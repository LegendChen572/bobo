/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 */
package tools;

import client.messages.commands.player.\u61b6\u6200\u8c37;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import tools.html.getHtml;

public class OnlineTimeCatch {
    public static /* synthetic */ String webUrl5;
    public static /* synthetic */ String webUrl4;
    public static /* synthetic */ String webUrl3;
    public static /* synthetic */ String webUrl2;
    public static /* synthetic */ String webUrl6;
    public static /* synthetic */ String webUrl1;

    public /* synthetic */ OnlineTimeCatch() {
        OnlineTimeCatch a2;
    }

    private static /* synthetic */ String ALLATORIxDEMO(String a2) {
        try {
            URL uRL = new URL(a2);
            URLConnection uRLConnection = uRL.openConnection();
            uRLConnection.connect();
            long l2 = uRLConnection.getDate();
            Date date = new Date(l2);
            return new SimpleDateFormat(getHtml.ALLATORIxDEMO("s\u0012s\u0012'&GFn\u000f*#BQg\u00060\u0018y"), Locale.CHINA).format(date);
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return null;
    }

    private static /* synthetic */ long ALLATORIxDEMO(String a2) {
        try {
            URL uRL = new URL(a2);
            URLConnection uRLConnection = uRL.openConnection();
            uRLConnection.connect();
            long l2 = uRLConnection.getDate();
            return l2;
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return 0L;
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u0000:):):):):):):):):):):):):):):):):):):):):):):):)\u0013)9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*:\u0000:*9*9*9*9):*:*9*:*9*9):*:):*:):*:)9*:):*9*9*9*9)\u0013)9*9*9*9)9)9)9*9)9*9)9)9*:*9)9)9)9)9*:*9*9*9*9*:\u0000:*9*9*9*:):*:*9*:*9*:):*9)9*:*:*:)9*9)9*9*9*9*9)\u0013)9*9*9*9)9)9):)9):)9)9)9*:*9):)9)9)9):)9*9*9*9*:\u0000:*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9)\u0013)9E{llyzkmcvd9h`*Xfukmekc9E{llyzkmek*o=799N\\GV*:\u0000:*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9)\u0013)9*9*9*9*9*9bm~i06%n}n$xfukmekc7ivg9*9*9*9*9*9*:\u0000:*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9*9)\u0013):):):):):):):):):):):):):):):):):):):):):):):):\u0000"));
        String string = "http://www.bjtime.cn";
        String string2 = "http://www.baidu.com";
        String string3 = "http://www.taobao.com";
        String string4 = "http://www.ntsc.ac.cn";
        String string5 = "http://www.360.cn";
        String string6 = "http://www.beijing-time.org";
        System.out.println(OnlineTimeCatch.ALLATORIxDEMO(string) + " [bjtime]");
        System.out.println(OnlineTimeCatch.ALLATORIxDEMO(string2) + " [\u767e\u5ea6]");
        System.out.println(OnlineTimeCatch.ALLATORIxDEMO(string3) + " [\u6dd8\u5b9d]");
        System.out.println(OnlineTimeCatch.ALLATORIxDEMO(string4) + " [\u4e2d\u56fd\u79d1\u5b66\u9662\u56fd\u5bb6\u6388\u65f6\u4e2d\u5fc3]");
        System.out.println(OnlineTimeCatch.ALLATORIxDEMO(string5) + " [360\u5b89\u5168\u536b\u58eb]");
        System.out.println(OnlineTimeCatch.ALLATORIxDEMO(string6) + " [beijing-time]");
    }

    public static /* synthetic */ {
        webUrl1 = "http://www.bjtime.cn";
        webUrl2 = "http://www.baidu.com";
        webUrl3 = "http://www.taobao.com";
        webUrl4 = "http://www.ntsc.ac.cn";
        webUrl5 = "http://www.360.cn";
        webUrl6 = "http://www.beijing-time.org";
    }

    public static /* synthetic */ long getLongTime() {
        long l2 = OnlineTimeCatch.ALLATORIxDEMO(webUrl3);
        if (l2 == 0L) {
            l2 = OnlineTimeCatch.ALLATORIxDEMO(webUrl4);
        }
        if (l2 == 0L) {
            l2 = OnlineTimeCatch.ALLATORIxDEMO(webUrl5);
        }
        if (l2 == 0L) {
            l2 = OnlineTimeCatch.ALLATORIxDEMO(webUrl3);
        }
        if (l2 == 0L) {
            l2 = System.currentTimeMillis();
        }
        return l2;
    }
}

