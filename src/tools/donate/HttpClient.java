/*
 * Decompiled with CFR 0.150.
 */
package tools.donate;

import client.messages.CommandExecute;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import tools.Quadra;

public class HttpClient {
    private static final /* synthetic */ String ALLATORIxDEMO = "Mozilla/5.0";

    public /* synthetic */ HttpClient() {
        HttpClient a2;
    }

    public static /* synthetic */ void sendPost() throws Exception {
        String string;
        String string2 = Quadra.ALLATORIxDEMO("!B=F:\ff\u00199W0[,X=\u0018,U9W0\u0018*Y$\u0018=Afu(E!_,Dfw Y\n^,U\"y<Bf`|");
        Object object = (HttpsURLConnection)new URL(string2).openConnection();
        HttpsURLConnection httpsURLConnection = object;
        HttpsURLConnection httpsURLConnection2 = object;
        httpsURLConnection2.setRequestMethod(CommandExecute.ALLATORIxDEMO("!\u001a\"\u0001"));
        httpsURLConnection2.setRequestProperty("User-Agent", ALLATORIxDEMO);
        httpsURLConnection.setRequestProperty(Quadra.ALLATORIxDEMO("\bU*S9Bdz(X.C(Q,"), CommandExecute.ALLATORIxDEMO("\u0014;\\\u0000\"y\u0014;J$Le_`"));
        httpsURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(((URLConnection)object).getOutputStream());
        dataOutputStream.flush();
        dataOutputStream.close();
        int n2 = httpsURLConnection.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + string2);
        System.out.println("Response Code : " + n2);
        object = new BufferedReader(new InputStreamReader(((URLConnection)object).getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        Object object2 = object;
        while ((string = ((BufferedReader)object2).readLine()) != null) {
            object2 = object;
            stringBuffer.append(string);
        }
        ((BufferedReader)object).close();
        System.out.println(stringBuffer.toString());
    }
}

