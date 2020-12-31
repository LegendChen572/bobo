/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.http.HttpEntity
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.entity.StringEntity
 *  org.apache.http.impl.client.CloseableHttpClient
 *  org.apache.http.impl.client.HttpClientBuilder
 *  org.apache.http.util.EntityUtils
 */
package tools.CloudFlare;

import FuckingHackerToby.ka;
import handling.auction.handler.MTSOperation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class CloudFlareAPI {
    public static /* synthetic */ void addDefaultPort(String a2, String a3) {
        int n2;
        int n3 = n2 = 14000;
        while (n3 <= 14022) {
            CloudFlareAPI.addSpectrum(a2, a3, Integer.toString(n2++));
            n3 = n2;
        }
    }

    public static /* synthetic */ void main(String[] a2) throws IOException {
        System.out.println(ka.H("l6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E\u001fE5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F6l6F5F5F5F5E6F6F5F6F5F5E6F6E6F6E6F6E5F6E6F5F5F5F5E\u001fE5F5F5F5E5E5E5F5E5F5E5E5F6F5E5E5E5E5F6F5F5F5F5F6l6F5F5F5F6E6F6F5F6F5F6E6F5E5F6F6F6E5F5E5F5F5F5F5E\u001fE5F5F5F5E5E5E6E5E6E5E5E5F6F5E6E5E5E5E6E5F5F5F5F6l6F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5E\u001fE5)w\u0000`\u0015v\u0007a\u000fz\b5\u0004lFT\ny\u0007a\tg\u000f5)w\u0000`\u0015v\u0007a\tgFcQ;U5\"P+ZF6l6F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5E\u001fE5F5F5F5F5F5\u000ea\u0012e\\:Ib\u0011bHt\ny\u0007a\tg\u000f;\u0005z\u000b5F5F5F5F5F5F6l6F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5E\u001fE6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6l"));
        try {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            Object object = new HttpPost(MTSOperation.ALLATORIxDEMO("K8W<Pv\fcB<Jb@ L9G*O-Q)\r/L!\f/O%F\"WcUx\f6L\"F?\fx\u001b*B*B/\u0012~\u0017.\u001a}A~\u0010u\u0013t\u0014}\u0015y\u0010|\u0011\u007fAy\u0017.\u001acE%Q)T-O \f-@/F?P\u0013Q9O)PcQ9O)P"));
            StringEntity stringEntity = new StringEntity(ka.H("nDx\tq\u00037\\7\u0004y\tv\r7J7\u0005z\bs\u000fr\u0013g\u0007a\u000fz\b7\\nDa\u0007g\u0001p\u00127\\7\u000feD9Dc\u0007y\u0013pD/D$^ H'T%H$V$H#Q7\u001b9D{\ta\u0003fD/DT\"QFW?5$Z$ZFF#G0P47\u001b"));
            HttpPost httpPost = object;
            HttpPost httpPost2 = object;
            httpPost2.addHeader(MTSOperation.ALLATORIxDEMO("\u0014\u000e\rV8Kah)Z"), ka.H("Sq\u0005\"^$P#\u0002%U \u0000%V&Q \u0003pTqVtPtS#U,\u0004-\u0004,RtS"));
            httpPost2.addHeader(MTSOperation.ALLATORIxDEMO("\u0014\u000e\rV8Kaf!B%O"), ka.H("\u0003g\u000fv&f\u000e|\bpHf\u000e"));
            httpPost.addHeader(MTSOperation.ALLATORIxDEMO("\u000fL\"W)M8\u000e\u0018Z<F"), ka.H("t\u0016e\n|\u0005t\u0012|\t{I\u007f\u0015z\b"));
            httpPost.setEntity((HttpEntity)stringEntity);
            object = EntityUtils.toString((HttpEntity)closeableHttpClient.execute((HttpUriRequest)httpPost).getEntity());
            System.out.println((String)object);
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, unsupportedEncodingException);
            return;
        }
    }

    public static /* synthetic */ boolean addSpectrum(String a2, String a3, String a4) {
        try {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            Object object = new HttpPost(MTSOperation.ALLATORIxDEMO("K8W<Pv\fcB<Jb@ L9G*O-Q)\r/L!\f/O%F\"WcUx\f6L\"F?\fx\u001b*B*B/\u0012~\u0017.\u001a}A~\u0010u\u0013t\u0014}\u0015y\u0010|\u0011\u007fAy\u0017.\u001acP<F/W>V!\f-S<P"));
            String string = a4;
            StringEntity stringEntity = new StringEntity("{\"protocol\":\"tcp/" + string + "\",\"dns\":{\"type\":\"CNAME\",\"name\":\"" + a2 + "\"},\"origin_direct\":[\"tcp://" + a3 + ":" + string + "\"],\"proxy_protocol\":\"off\",\"ip_firewall\":true,\"tls\":\"off\",\"edge_ips\":{\"type\":\"dynamic\",\"connectivity\":\"all\"},\"traffic_type\":\"direct\",\"argo_smart_routing\":false}");
            HttpPost httpPost = object;
            HttpPost httpPost2 = object;
            httpPost2.addHeader(ka.H("MKT\u0013a\u000e8-p\u001f"), MTSOperation.ALLATORIxDEMO("\u0016(@{\u001b}\u0015zG|\u0010yE|\u0013\u007f\u0014yF)\u0011(\u0013-\u0015-\u0016z\u0010uAtAu\u0017-\u0016"));
            httpPost2.addHeader(ka.H("MKT\u0013a\u000e8#x\u0007|\n"), MTSOperation.ALLATORIxDEMO("F>J/c?K%M)\r?K"));
            httpPost.addHeader(ka.H("V\t{\u0012p\baKA\u001fe\u0003"), MTSOperation.ALLATORIxDEMO("-S<O%@-W%L\"\f&P#M"));
            httpPost.setEntity((HttpEntity)stringEntity);
            object = EntityUtils.toString((HttpEntity)closeableHttpClient.execute((HttpUriRequest)httpPost).getEntity());
            System.out.println("IP:" + a3 + " PORT:" + a4 + " \u662f\u5426\u6210\u529f:" + ((String)object).contains(ka.H("Df\u0013v\u0005p\u0015fD/Fa\u0014`\u0003")));
            return ((String)object).contains(MTSOperation.ALLATORIxDEMO("\u0001?V/@)P?\u0001v\u00038Q9F"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, unsupportedEncodingException);
        }
        catch (IOException iOException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, iOException);
        }
        return false;
    }

    public /* synthetic */ CloudFlareAPI() {
        CloudFlareAPI a2;
    }

    public static /* synthetic */ boolean addWhiteListIP(String a2) {
        try {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(MTSOperation.ALLATORIxDEMO("K8W<Pv\fcB<Jb@ L9G*O-Q)\r/L!\f/O%F\"WcUx\f6L\"F?\fx\u001b*B*B/\u0012~\u0017.\u001a}A~\u0010u\u0013t\u0014}\u0015y\u0010|\u0011\u007fAy\u0017.\u001acE%Q)T-O \f-@/F?P\u0013Q9O)PcQ9O)P"));
            StringEntity stringEntity = new StringEntity("{\"mode\":\"whitelist\",\"configuration\":{\"target\":\"ip\",\"value\":\"" + a2 + "\"},\"notes\":\"ADD BY BOBO SERVER\"}");
            HttpPost httpPost2 = httpPost;
            HttpPost httpPost3 = httpPost;
            httpPost3.addHeader(ka.H("MKT\u0013a\u000e8-p\u001f"), MTSOperation.ALLATORIxDEMO("\u0016(@{\u001b}\u0015zG|\u0010yE|\u0013\u007f\u0014yF)\u0011(\u0013-\u0015-\u0016z\u0010uAtAu\u0017-\u0016"));
            httpPost3.addHeader(ka.H("MKT\u0013a\u000e8#x\u0007|\n"), MTSOperation.ALLATORIxDEMO("F>J/c?K%M)\r?K"));
            httpPost2.addHeader(ka.H("V\t{\u0012p\baKA\u001fe\u0003"), MTSOperation.ALLATORIxDEMO("-S<O%@-W%L\"\f&P#M"));
            httpPost2.setEntity((HttpEntity)stringEntity);
            return EntityUtils.toString((HttpEntity)closeableHttpClient.execute((HttpUriRequest)httpPost2).getEntity()).contains(ka.H("Df\u0013v\u0005p\u0015fD/Fa\u0014`\u0003"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, unsupportedEncodingException);
        }
        catch (IOException iOException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, iOException);
        }
        return false;
    }

    public static /* synthetic */ boolean addBanIP(String a2) {
        try {
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(MTSOperation.ALLATORIxDEMO("K8W<Pv\fcB<Jb@ L9G*O-Q)\r/L!\f/O%F\"WcUx\f6L\"F?\fx\u001b*B*B/\u0012~\u0017.\u001a}A~\u0010u\u0013t\u0014}\u0015y\u0010|\u0011\u007fAy\u0017.\u001acE%Q)T-O \f-@/F?P\u0013Q9O)PcQ9O)P"));
            StringEntity stringEntity = new StringEntity("{\"mode\":\"block\",\"configuration\":{\"target\":\"ip\",\"value\":\"" + a2 + "\"},\"notes\":\"ADD BY BOBO SERVER\"}");
            HttpPost httpPost2 = httpPost;
            HttpPost httpPost3 = httpPost;
            httpPost3.addHeader(ka.H("MKT\u0013a\u000e8-p\u001f"), MTSOperation.ALLATORIxDEMO("\u0016(@{\u001b}\u0015zG|\u0010yE|\u0013\u007f\u0014yF)\u0011(\u0013-\u0015-\u0016z\u0010uAtAu\u0017-\u0016"));
            httpPost3.addHeader(ka.H("MKT\u0013a\u000e8#x\u0007|\n"), MTSOperation.ALLATORIxDEMO("F>J/c?K%M)\r?K"));
            httpPost2.addHeader(ka.H("V\t{\u0012p\baKA\u001fe\u0003"), MTSOperation.ALLATORIxDEMO("-S<O%@-W%L\"\f&P#M"));
            httpPost2.setEntity((HttpEntity)stringEntity);
            return EntityUtils.toString((HttpEntity)closeableHttpClient.execute((HttpUriRequest)httpPost2).getEntity()).contains(ka.H("Df\u0013v\u0005p\u0015fD/Fa\u0014`\u0003"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, unsupportedEncodingException);
        }
        catch (IOException iOException) {
            Logger.getLogger(CloudFlareAPI.class.getName()).log(Level.SEVERE, null, iOException);
        }
        return false;
    }
}

