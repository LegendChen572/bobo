/*
 * Decompiled with CFR 0.150.
 */
package ecpay.payment.integration.ecpayOperator;

import ecpay.payment.integration.ecpayOperator.EcpayFunction;
import ecpay.payment.integration.exception.EcpayException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class PaymentVerifyBase {
    protected String confPath = "/ecpay/payment/integration/config/EcpayPayment.xml";
    protected Document doc;

    public PaymentVerifyBase() {
        URL fileURL = this.getClass().getResource(this.confPath);
        this.doc = EcpayFunction.xmlParser(fileURL.toString());
        this.doc.getDocumentElement().normalize();
    }

    protected void requireCheck(String FieldName, String objValue, String require) {
        if (require.equals("1") && objValue.isEmpty()) {
            throw new EcpayException(FieldName + "\u70ba\u5fc5\u586b");
        }
    }

    protected void valueCheck(String type, String objValue, Element ele) {
        if (objValue.isEmpty()) {
            return;
        }
        if (type.equals("String")) {
            Pattern r2;
            Matcher m2;
            if (ele.getElementsByTagName("pattern") != null && !(m2 = (r2 = Pattern.compile(ele.getElementsByTagName("pattern").item(0).getTextContent().toString())).matcher(objValue)).find()) {
                throw new EcpayException(ele.getAttribute("name") + "\u586b\u5165\u975e\u6cd5\u503c\uff0c\u8acb\u53c3\u95b1\u6587\u4ef6\u898f\u7bc4");
            }
        } else if (type.equals("Opt")) {
            ArrayList<String> opt = new ArrayList<String>();
            NodeList n2 = ele.getElementsByTagName("option");
            for (int i2 = 0; i2 < n2.getLength(); ++i2) {
                opt.add(n2.item(i2).getTextContent().toString());
            }
            if (!opt.contains(objValue)) {
                throw new EcpayException(ele.getAttribute("name") + "\u586b\u5165\u975e\u6cd5\u503c\uff0c\u8acb\u53c3\u95b1\u6587\u4ef6\u898f\u7bc4");
            }
        } else if (type.equals("Int")) {
            String mode = ele.getElementsByTagName("mode").item(0).getTextContent();
            String minimum = ele.getElementsByTagName("minimal").item(0).getTextContent();
            String maximum = ele.getElementsByTagName("maximum").item(0).getTextContent();
            if (objValue.isEmpty()) {
                throw new EcpayException(ele.getAttribute("name") + "\u4e0d\u80fd\u70ba\u7a7a");
            }
            int value = Integer.valueOf(objValue);
            if (mode.equals("GE") && value < Integer.valueOf(minimum)) {
                throw new EcpayException(ele.getAttribute("name") + "\u4e0d\u80fd\u5c0f\u65bc" + minimum);
            }
            if (mode.equals("LE") && value > Integer.valueOf(maximum)) {
                throw new EcpayException(ele.getAttribute("name") + "\u4e0d\u80fd\u5927\u65bc" + maximum);
            }
            if (mode.equals("BETWEEN") && value < Integer.valueOf(minimum) && value > Integer.valueOf(maximum)) {
                throw new EcpayException(ele.getAttribute("name") + "\u5fc5\u9808\u4ecb\u65bc" + minimum + "\u548c" + maximum + "\u4e4b\u9593");
            }
            if (mode.equals("EXCLUDE") && value >= Integer.valueOf(minimum) && value <= Integer.valueOf(maximum)) {
                throw new EcpayException(ele.getAttribute("name") + "\u5fc5\u9808\u5c0f\u65bc" + minimum + "\u6216\u5927\u65bc" + maximum);
            }
        } else if (type.equals("DepOpt")) {
            // empty if block
        }
    }
}

