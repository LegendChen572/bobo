/*
 * Decompiled with CFR 0.150.
 */
package ecpay.payment.integration.verification;

import ecpay.payment.integration.domain.TradeNoAioObj;
import ecpay.payment.integration.ecpayOperator.PaymentVerifyBase;
import ecpay.payment.integration.exception.EcpayException;
import java.lang.reflect.Method;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class VerifyTradeNoAio
extends PaymentVerifyBase {
    public String getAPIUrl(String mode) {
        Element ele = (Element)this.doc.getElementsByTagName("TradeNoAio").item(0);
        String url = "";
        NodeList nodeList = ele.getElementsByTagName("url");
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            ele = (Element)nodeList.item(i2);
            if (!ele.getAttribute("type").equalsIgnoreCase(mode)) continue;
            url = ele.getTextContent();
            break;
        }
        if (url == "") {
            throw new EcpayException("payment_conf\u8a2d\u5b9a\u64cbOperatingMode\u8a2d\u5b9a\u932f\u8aa4");
        }
        return url;
    }

    public void verifyParams(TradeNoAioObj obj) {
        Class<?> cls = obj.getClass();
        Element ele = (Element)this.doc.getElementsByTagName("TradeNoAio").item(0);
        NodeList nodeList = ele.getElementsByTagName("param");
        for (int i2 = 0; i2 < nodeList.getLength(); ++i2) {
            String objValue;
            Element tmpEle = (Element)nodeList.item(i2);
            try {
                Method method = cls.getMethod("get" + tmpEle.getAttribute("name"), null);
                objValue = method.invoke(obj, null).toString();
            }
            catch (Exception e2) {
                throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
            }
            this.requireCheck(tmpEle.getAttribute("name"), objValue, tmpEle.getAttribute("require").toString());
            this.valueCheck(tmpEle.getAttribute("type"), objValue, tmpEle);
        }
    }
}

