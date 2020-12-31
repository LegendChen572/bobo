/*
 * Decompiled with CFR 0.150.
 */
package ecpay.payment.integration.verification;

import ecpay.payment.integration.domain.InvoiceObj;
import ecpay.payment.integration.ecpayOperator.PaymentVerifyBase;
import ecpay.payment.integration.exception.EcpayException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class VerifyAioCheckOut
extends PaymentVerifyBase {
    public String getAPIUrl(String mode) throws EcpayException {
        Element ele = (Element)this.doc.getElementsByTagName("AioCheckOut").item(0);
        String url = "";
        NodeList nodeList = ele.getElementsByTagName("url");
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            ele = (Element)nodeList.item(i2);
            if (!ele.getAttribute("type").equalsIgnoreCase(mode)) continue;
            url = ele.getTextContent();
            System.out.println(url);
            break;
        }
        if (url == "") {
            throw new EcpayException("payment_conf\u8a2d\u5b9a\u64cbOperatingMode\u8a2d\u5b9a\u932f\u8aa4");
        }
        return url;
    }

    public void verifyParams(Object obj) {
        Class<?> cls = obj.getClass();
        ArrayList<String> fieldNames = new ArrayList<String>();
        for (Field field : cls.getDeclaredFields()) {
            fieldNames.add(field.getName());
        }
        Element ele = (Element)this.doc.getElementsByTagName("AioCheckOut").item(0);
        NodeList nodeList = ele.getElementsByTagName("param");
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            String objValue;
            Element tmpEle = (Element)nodeList.item(i2);
            if (!fieldNames.contains(tmpEle.getAttribute("name"))) continue;
            try {
                Method method = cls.getMethod("get" + tmpEle.getAttribute("name"), null);
                objValue = method.invoke(obj, null).toString();
            }
            catch (Exception e2) {
                throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
            }
            if (!(obj instanceof InvoiceObj)) {
                this.requireCheck(tmpEle.getAttribute("name"), objValue, tmpEle.getAttribute("require").toString());
            }
            this.valueCheck(tmpEle.getAttribute("type"), objValue, tmpEle);
        }
    }

    public void verifyInvoice(InvoiceObj obj) {
        Matcher m2;
        Pattern r2;
        if (obj.getCarruerType().equals("1")) {
            if (obj.getCustomerID().isEmpty()) {
                throw new EcpayException("CustomerID cannot be empty when CarruerType is 1.");
            }
        } else if (!obj.getCustomerID().isEmpty() && obj.getCarruerType().isEmpty()) {
            throw new EcpayException("CarruerType cannot be empty when CustomerID is not empty.");
        }
        if (obj.getPrint().equals("1")) {
            if (obj.getCustomerName().isEmpty() || obj.getCustomerAddr().isEmpty()) {
                throw new EcpayException("CustomerName and CustomerAddr cannot be empty when Print is 1.");
            }
            if (!obj.getCustomerID().isEmpty()) {
                throw new EcpayException("Print cannot be 1 when CustomerID is not empty.");
            }
        }
        if (obj.getCustomerPhone().isEmpty() && obj.getCustomerEmail().isEmpty()) {
            throw new EcpayException("CustomerPhone and CustomerEmail cannot both be empty.");
        }
        if (obj.getTaxType().equals("2") && !obj.getClearanceMark().equals("1") && !obj.getClearanceMark().equals("2")) {
            throw new EcpayException("ClearanceMark has to be 1 or 2 when TaxType is 2.");
        }
        if (!obj.getCustomerIdentifier().isEmpty()) {
            if (obj.getCarruerType().equals("1") || obj.getCarruerType().equals("2")) {
                throw new EcpayException("CarruerType cannot be 1 or 2 when CustomerIdentifier is given");
            }
            if (!obj.getDonation().equals("2") || !obj.getPrint().equals("1")) {
                throw new EcpayException("Print must be 1 and Donation must be 2 when CustomerIdentifier is given.");
            }
        }
        if (!obj.getCarruerType().isEmpty() && obj.getPrint().equals("1")) {
            throw new EcpayException("Print must be 0 when CarruerType is given.");
        }
        if (obj.getCarruerType().isEmpty() || obj.getCarruerType().equals("1")) {
            if (!obj.getCarruerNum().isEmpty()) {
                throw new EcpayException("CarruerNum must be empty when CarruerType is empty or 1.");
            }
        } else if (obj.getCarruerType().equals("2")) {
            r2 = Pattern.compile("[A-Za-z]{2}[0-9]{14}");
            m2 = r2.matcher(obj.getCarruerNum());
            if (!m2.find()) {
                throw new EcpayException("CarruerNum must be 2 alphabets and 14 numbers when CarruerType is 2.");
            }
        } else if (obj.getCarruerType().equals("3")) {
            r2 = Pattern.compile("^\\/[A-Za-z0-9\\s+-]{7}$");
            m2 = r2.matcher(obj.getCarruerNum());
            if (!m2.find()) {
                throw new EcpayException("CarruerNum must start with / followed by 7 alphabet and number characters when CarruerType is 3.");
            }
        } else {
            throw new EcpayException("Unexpected Value in CarruerType");
        }
        if (obj.getDonation().equals("1")) {
            if (obj.getLoveCode().isEmpty()) {
                throw new EcpayException("LoveCode cannot be empty when Donation is 1.");
            }
            if (!obj.getPrint().equals("0")) {
                throw new EcpayException("Print must be 0 when Donation is 1.");
            }
        }
        if (obj.getInvoiceItemName().isEmpty()) {
            throw new EcpayException("InvoiceItemName cannot be empty.");
        }
        if (obj.getInvoiceItemCount().isEmpty()) {
            throw new EcpayException("InvoiceItemCount cannot be empty.");
        }
        if (obj.getInvoiceItemWord().isEmpty()) {
            throw new EcpayException("InvoiceItemWord cannot be empty.");
        }
        if (obj.getInvoiceItemPrice().isEmpty()) {
            throw new EcpayException("InvoiceItemPrice cannot be empty.");
        }
        if (obj.getInvoiceItemTaxType().isEmpty()) {
            throw new EcpayException("InvoiceItemTaxType cannot be empty.");
        }
        if (obj.getInvoiceItemName().contains("|")) {
            String[] itemTax;
            int itemCount = obj.getInvoiceItemName().split("|").length;
            int paramCount = 0;
            Pattern r3 = Pattern.compile("(\\|\\||^\\||\\|$)");
            Matcher invCount = r3.matcher(obj.getInvoiceItemCount());
            Matcher invWord = r3.matcher(obj.getInvoiceItemWord());
            Matcher invPrice = r3.matcher(obj.getInvoiceItemPrice());
            Matcher invType = r3.matcher(obj.getInvoiceItemTaxType());
            if (invCount.find()) {
                throw new EcpayException("InvoiceItemCount contains empty value.");
            }
            paramCount = obj.getInvoiceItemCount().split("|").length;
            if (itemCount != paramCount) {
                throw new EcpayException("Count of item info InvoiceItemCount(" + paramCount + ") not match item count from InvoiceItemName(" + itemCount + ")");
            }
            if (invWord.find()) {
                throw new EcpayException("InvoiceItemWord contains empty value.");
            }
            paramCount = obj.getInvoiceItemWord().split("|").length;
            if (itemCount != paramCount) {
                throw new EcpayException("Count of item info InvoiceItemWord(" + paramCount + ") not match item count from InvoiceItemName(" + itemCount + ")");
            }
            if (invPrice.find()) {
                throw new EcpayException("InvoiceItemPrice contains empty value.");
            }
            paramCount = obj.getInvoiceItemPrice().split("|").length;
            if (itemCount != paramCount) {
                throw new EcpayException("Count of item info InvoiceItemPrice(" + paramCount + ") not match item count from InvoiceItemName(" + itemCount + ")");
            }
            if (invType.find()) {
                throw new EcpayException("InvoiceItemTaxType contains empty value.");
            }
            paramCount = obj.getInvoiceItemTaxType().split("|").length;
            if (itemCount != paramCount) {
                throw new EcpayException("Count of item info InvoiceItemTaxType(" + paramCount + ") not match item count from InvoiceItemName(" + itemCount + ")");
            }
            for (String tax : itemTax = obj.getInvoiceItemTaxType().split("|")) {
                if (tax.equals("1") || tax.equals("2") || tax.equals("3")) continue;
                throw new EcpayException("Ilegal InvoiceItemTaxType: " + tax);
            }
            if (obj.getTaxType().equals("9")) {
                if (!itemTax.toString().contains("1")) {
                    throw new EcpayException("InvoiceItemTaxType must contain at least one 1.");
                }
                if (itemTax.toString().contains("2") && itemTax.toString().contains("3")) {
                    throw new EcpayException("InvoiceItemTaxType cannot contain 2 and 3 at the same time.");
                }
            }
        } else {
            if (obj.getInvoiceItemCount().contains("|")) {
                throw new EcpayException("Item info InvoiceItemCount contains pipeline delimiter but there's only one item in param InvoiceItemName.");
            }
            if (obj.getInvoiceItemWord().contains("|")) {
                throw new EcpayException("Item info InvoiceItemWord contains pipeline delimiter but there's only one item in param InvoiceItemName.");
            }
            if (obj.getInvoiceItemPrice().contains("|")) {
                throw new EcpayException("Item info InvoiceItemPrice contains pipeline delimiter but there's only one item in param InvoiceItemName.");
            }
            if (obj.getInvoiceItemTaxType().contains("|")) {
                throw new EcpayException("Item info InvoiceItemTaxType contains pipeline delimiter but there's only one item in param InvoiceItemName.");
            }
        }
        this.verifyParams(obj);
    }
}

