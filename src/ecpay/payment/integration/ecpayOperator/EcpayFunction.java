/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.gargoylesoftware.htmlunit.BrowserVersion
 *  com.gargoylesoftware.htmlunit.HttpMethod
 *  com.gargoylesoftware.htmlunit.WebClient
 *  com.gargoylesoftware.htmlunit.WebRequest
 *  com.gargoylesoftware.htmlunit.html.DomElement
 *  com.gargoylesoftware.htmlunit.html.DomNodeList
 *  com.gargoylesoftware.htmlunit.html.HtmlPage
 *  com.gargoylesoftware.htmlunit.util.NameValuePair
 */
package ecpay.payment.integration.ecpayOperator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import ecpay.payment.integration.domain.AioCheckOutATM;
import ecpay.payment.integration.domain.AioCheckOutCVS;
import ecpay.payment.integration.exception.EcpayException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class EcpayFunction {
    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static final String CIPHER_ALGORITHM = "AES/CBC/NoPadding";

    public static final String genCheckMacValue(String key, String iv, Object obj) {
        Class<?> cls = obj.getClass();
        List<String> fieldNames = EcpayFunction.getSortedFieldNames(cls);
        Object data = "";
        try {
            for (String name : fieldNames) {
                if (name == "CheckMacValue" || name == "PaymentToken") continue;
                Method method = cls.getMethod("get" + name, null);
                data = (String)data + "&" + name + "=" + method.invoke(obj, new Object[0]).toString();
            }
            String urlEncode = EcpayFunction.urlEncode("HashKey=" + key + (String)data + "&HashIV=" + iv).toLowerCase();
            urlEncode = EcpayFunction.netUrlEncode(urlEncode);
            return EcpayFunction.hash(urlEncode.getBytes(), "SHA-256");
        }
        catch (Exception e2) {
            throw new EcpayException("\u7522\u751f\u6aa2\u67e5\u78bc\u5931\u6557");
        }
    }

    public static final String AESEncode(String HashKey, String HashIV, String plaintext) throws Exception {
        SecretKeySpec key = new SecretKeySpec(HashKey.getBytes("UTF-8"), "AES");
        AlgorithmParameters iv = AlgorithmParameters.getInstance("AES");
        iv.init(new IvParameterSpec(HashIV.getBytes("UTF-8")));
        plaintext = EcpayFunction.pkcs7Padding(plaintext);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(1, (Key)key, iv);
        byte[] encrypt = cipher.doFinal(plaintext.getBytes("UTF-8"));
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedText = encoder.encodeToString(encrypt);
        String urlEncode = EcpayFunction.urlEncode(encodedText);
        urlEncode = EcpayFunction.netUrlEncode(urlEncode);
        urlEncode = urlEncode.toLowerCase();
        return urlEncode;
    }

    private static final String pkcs7Padding(String plaintext) {
        int blockSize = 16;
        int pad = 0;
        if (((String)plaintext).length() < blockSize) {
            pad = blockSize - ((String)plaintext).length();
        } else if (((String)plaintext).length() >= blockSize) {
            pad = ((String)plaintext).length() % blockSize == 0 ? 16 : blockSize - ((String)plaintext).length() % blockSize;
        }
        for (int i2 = 0; i2 < pad; ++i2) {
            plaintext = (String)plaintext + (char)pad;
        }
        return plaintext;
    }

    public static final String genCheckMacValue(String key, String iv, Hashtable<String, String> params) {
        Set<String> keySet = params.keySet();
        TreeSet<String> treeSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(keySet);
        String[] name = treeSet.toArray(new String[treeSet.size()]);
        Object paramStr = "";
        for (int i2 = 0; i2 < name.length; ++i2) {
            if (name[i2].equals("CheckMacValue")) continue;
            paramStr = (String)paramStr + "&" + name[i2] + "=" + params.get(name[i2]);
        }
        String par = "Hashkey=" + key + (String)paramStr + "&HashIV=" + iv;
        String urlEncode = EcpayFunction.urlEncode(par).toLowerCase();
        urlEncode = EcpayFunction.netUrlEncode(urlEncode);
        return EcpayFunction.hash(urlEncode.getBytes(), "SHA-256");
    }

    public static final String genHttpValue(Object obj, String CheckMacValue) {
        Class<?> cls = obj.getClass();
        List<String> fieldNames = EcpayFunction.getSortedFieldNames(cls);
        Object result = "";
        for (int i2 = 0; i2 < fieldNames.size(); ++i2) {
            try {
                Method method = cls.getMethod("get" + fieldNames.get(i2), null);
                fieldNames.set(i2, fieldNames.get(i2) + "=" + EcpayFunction.invokeMethod(method, obj));
            }
            catch (Exception e2) {
                throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
            }
            result = (String)result + fieldNames.get(i2) + "&";
        }
        return (String)result + "CheckMacValue=" + CheckMacValue;
    }

    public static final Hashtable<String, String> objToHashtable(Object obj) {
        Class<?> cls = obj.getClass();
        Hashtable<String, String> resultDict = new Hashtable<String, String>();
        List<String> fieldNames = EcpayFunction.getSortedFieldNames(cls);
        for (int i2 = 0; i2 < fieldNames.size(); ++i2) {
            try {
                Method method = cls.getMethod("get" + fieldNames.get(i2), null);
                resultDict.put(fieldNames.get(i2), EcpayFunction.invokeMethod(method, obj));
                continue;
            }
            catch (Exception e2) {
                throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
            }
        }
        return resultDict;
    }

    private static final String invokeMethod(Method method, Object obj) {
        try {
            return method.invoke(obj, null).toString();
        }
        catch (Exception e2) {
            throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
        }
    }

    public static final String httpPost(String url, String urlParameters, String encoding) {
        try {
            String inputLine;
            URL obj = new URL(url);
            HttpURLConnection connection = null;
            if (obj.getProtocol().toLowerCase().equals("https")) {
                EcpayFunction.trustAllHosts();
                connection = (HttpsURLConnection)obj.openConnection();
            } else {
                connection = (HttpURLConnection)obj.openConnection();
            }
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.2171.71 Safari/537.36 EcPay JAVA API Version 2.0.0");
            connection.setRequestProperty("Accept-Language", encoding);
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(urlParameters.getBytes(encoding));
            wr.flush();
            wr.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        catch (Exception e2) {
            throw new EcpayException(e2.getMessage());
        }
    }

    public static void htmlunit(String url, String para, String encoding) throws Exception {
        String inputLine;
        URL obj = new URL(url);
        HttpURLConnection connection = null;
        if (obj.getProtocol().toLowerCase().equals("https")) {
            EcpayFunction.trustAllHosts();
            connection = (HttpsURLConnection)obj.openConnection();
        } else {
            connection = (HttpURLConnection)obj.openConnection();
        }
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.2171.71 Safari/537.36 EcPay JAVA API Version 2.0.0");
        connection.setRequestProperty("Accept-Language", encoding);
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(para.getBytes(encoding));
        wr.flush();
        wr.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        boolean redirect = false;
        int status = connection.getResponseCode();
        if (status != 200 && (status == 302 || status == 301 || status == 303)) {
            redirect = true;
        }
        String newUrl = "https://payment.ecpay.com.tw/PaymentRule/CVSPaymentInfo";
        String cookies = connection.getHeaderField("Set-Cookie");
        connection = (HttpURLConnection)new URL(newUrl).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.2171.71 Safari/537.36 EcPay JAVA API Version 2.0.0");
        connection.setRequestProperty("Accept-Language", encoding);
        connection.setDoOutput(true);
        BufferedReader ins = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));
        StringBuffer html = new StringBuffer();
        in.close();
    }

    public static final String genUnixTimeStamp() {
        Date date = new Date();
        Integer timeStamp = (int)(date.getTime() / 1000L);
        return timeStamp.toString();
    }

    public static final Document xmlParser(String uri) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(uri);
        }
        catch (Exception e2) {
            throw new Error(e2);
        }
    }

    private static void trustAllHosts() {
        X509TrustManager easyTrustManager = new X509TrustManager(){

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        TrustManager[] trustAllCerts = new TrustManager[]{easyTrustManager};
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static List<String> getSortedFieldNames(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        ArrayList<String> fieldNames = new ArrayList<String>();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }
        Collections.sort(fieldNames, String.CASE_INSENSITIVE_ORDER);
        return fieldNames;
    }

    public static String urlEncode(String data) {
        String result = "";
        try {
            result = URLEncoder.encode(data, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        return result;
    }

    private static String netUrlEncode(String url) {
        String netUrlEncode = url.replaceAll("%21", "\\!").replaceAll("%28", "\\(").replaceAll("%29", "\\)");
        return netUrlEncode;
    }

    private static final String hash(byte[] data, String mode) {
        MessageDigest md = null;
        try {
            if (mode == "MD5") {
                md = MessageDigest.getInstance("MD5");
            } else if (mode == "SHA-256") {
                md = MessageDigest.getInstance("SHA-256");
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        return EcpayFunction.bytesToHex(md.digest(data));
    }

    private static final String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j2 = 0; j2 < bytes.length; ++j2) {
            int v2 = bytes[j2] & 0xFF;
            hexChars[j2 * 2] = hexArray[v2 >>> 4];
            hexChars[j2 * 2 + 1] = hexArray[v2 & 0xF];
        }
        return new String(hexChars);
    }

    public static PaymentInfo htmlunit(String url, ArrayList<NameValuePair> para, String encoding, Object aio) throws Exception {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        URL urlset = new URL(url);
        WebRequest requestSettings = new WebRequest(urlset, HttpMethod.POST);
        requestSettings.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.2171.71 Safari/537.36 EcPay JAVA API Version 2.0.0");
        requestSettings.setAdditionalHeader("Accept-Language", encoding);
        requestSettings.setRequestParameters(para);
        HtmlPage page = null;
        try {
            page = (HtmlPage)webClient.getPage(requestSettings);
        }
        catch (Exception e2) {
            System.out.println("Get page error" + e2);
        }
        DomNodeList elementsByTagName = page.getElementsByTagName("dd");
        String order_number = "";
        String merchant_name = "";
        String item_name = "";
        String item_price = "";
        String SubPayment = "";
        String payment_expiredate = "";
        String payment_No = "";
        String bank_code = "";
        block20: for (int i2 = 0; i2 < elementsByTagName.getLength(); ++i2) {
            DomElement domElement = (DomElement)elementsByTagName.get(i2);
            String s2 = "";
            System.out.println(i2 + " : " + domElement.asText().replaceAll("\r|\n", ""));
            if (aio instanceof AioCheckOutATM) {
                s2 = domElement.asText().replaceAll("\r|\n", "");
                switch (i2) {
                    case 0: {
                        order_number = s2;
                        break;
                    }
                    case 1: {
                        merchant_name = s2;
                        break;
                    }
                    case 5: {
                        item_name = s2;
                        break;
                    }
                    case 8: {
                        item_price = s2;
                        break;
                    }
                    case 2: {
                        SubPayment = s2;
                        break;
                    }
                    case 9: {
                        bank_code = s2.substring(0, 8);
                        payment_No = s2.substring(8, 30);
                        break;
                    }
                    case 10: {
                        payment_expiredate = s2.substring(0, 19);
                    }
                }
                continue;
            }
            if (!(aio instanceof AioCheckOutCVS)) continue;
            s2 = domElement.asText().replaceAll("\r|\n", "");
            switch (i2) {
                case 0: {
                    order_number = s2;
                    continue block20;
                }
                case 1: {
                    merchant_name = s2;
                    continue block20;
                }
                case 5: {
                    item_name = s2;
                    continue block20;
                }
                case 8: {
                    item_price = s2;
                    continue block20;
                }
                case 2: {
                    SubPayment = s2;
                    continue block20;
                }
                case 10: {
                    payment_expiredate = s2.substring(0, 19);
                    continue block20;
                }
                case 9: {
                    payment_No = s2;
                }
            }
        }
        webClient.close();
        PaymentInfo payment = new PaymentInfo(order_number, merchant_name, item_name, item_price, SubPayment, payment_expiredate, payment_No, bank_code, "\u5c1a\u672a\u7e73\u6b3e");
        return payment;
    }

    public static String handlePaymentCVS(int type, String text) {
        String ret = "";
        switch (type) {
            case 0: {
                ret = text.replace("\u8a02\u55ae\u7de8\u865f", "").trim();
                break;
            }
            case 1: {
                ret = text.replace("\u5546\u5e97\u540d\u7a31", "").trim();
                break;
            }
            case 2: {
                ret = text.replace("\u5546\u54c1\u660e\u7d30", "").trim();
                break;
            }
            case 3: {
                ret = text.replace("\u5be6\u969b\u7e73\u8cbb\u91d1\u984d", "").trim();
                break;
            }
            case 4: {
                ret = text.replace("\u4ed8\u6b3e\u65b9\u5f0f", "").trim();
                break;
            }
            case 5: {
                ret = text.replace("\u7e73\u8cbb\u622a\u6b62\u65e5\u671f", "").trim();
                break;
            }
            case 6: {
                ret = text.replace("\u8d85\u5546\u7e73\u8cbb\u4ee3\u78bc", "").trim();
            }
        }
        return ret;
    }

    public static String handlePaymentATM(int type, String text) {
        String ret = "";
        switch (type) {
            case 0: {
                ret = text.replace("\u8a02\u55ae\u7de8\u865f", "").trim();
                break;
            }
            case 1: {
                ret = text.replace("\u5546\u5e97\u540d\u7a31", "").trim();
                break;
            }
            case 2: {
                ret = text.replace("\u5546\u54c1\u660e\u7d30", "").trim();
                break;
            }
            case 3: {
                ret = text.replace("\u8a02\u55ae\u91d1\u984d", "").trim();
                break;
            }
            case 4: {
                ret = text.replace("\u4ed8\u6b3e\u65b9\u5f0f", "").trim();
                break;
            }
            case 5: {
                ret = text.replace("\u9280\u884c\u4ee3\u78bc", "").trim();
                break;
            }
            case 6: {
                ret = text.replace("ATM\u7e73\u8cbb\u5e33\u865f", "").trim();
                break;
            }
            case 7: {
                ret = text.replace("\u7e73\u8cbb\u622a\u6b62\u65e5\u671f", "").trim();
            }
        }
        return ret;
    }

    public static class PaymentInfo {
        private final String order_number;
        private final String merchant_name;
        private final String item_name;
        private final String item_price;
        private final String SubPayment;
        private final String payment_expiredate;
        private final String payment_No;
        private final String bank_code;
        private final String payment_status;

        public PaymentInfo(String order_number, String merchant_name, String item_name, String item_price, String SubPayment, String payment_expiredate, String payment_No, String bank_code, String payment_status) {
            this.order_number = order_number;
            this.merchant_name = merchant_name;
            this.item_name = item_name;
            this.item_price = item_price;
            this.SubPayment = SubPayment;
            this.payment_expiredate = payment_expiredate;
            this.payment_No = payment_No;
            this.bank_code = bank_code;
            this.payment_status = payment_status;
        }

        public String getOrderNumber() {
            return this.order_number;
        }

        public String getMerchantName() {
            return this.merchant_name;
        }

        public String getItemName() {
            return this.item_name;
        }

        public String getItemPrice() {
            return this.item_price;
        }

        public String getSubPayment() {
            return this.SubPayment;
        }

        public String getPaymentExpiryDate() {
            return this.payment_expiredate;
        }

        public String getPaymentNo() {
            return this.payment_No;
        }

        public String getPaymentStatus() {
            return this.payment_status;
        }

        public String getBankCode() {
            return this.bank_code;
        }
    }
}

