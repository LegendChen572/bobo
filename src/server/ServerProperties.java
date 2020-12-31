/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package server;

import client.messages.commands.GM.\u65b0\u661f\u8c37;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import server.Extend.SpecialItemData;
import tools.FileoutputUtil;
import tools.StringUtil;

public class ServerProperties {
    private static final /* synthetic */ Properties ALLATORIxDEMO;

    public static /* synthetic */ void setProperty(String a2, String a3) {
        ALLATORIxDEMO.setProperty(a2, a3);
    }

    public static /* synthetic */ double getWorldProperty(String a2, double a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Double.parseDouble(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ boolean getProperty(String a2, boolean a3) {
        return ServerProperties.ALLATORIxDEMO.getProperty(a2, a3 ? \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\t8\b/") : SpecialItemData.ALLATORIxDEMO("UI_[V")).equalsIgnoreCase(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\t8\b/"));
    }

    public static /* synthetic */ void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(ServerProperties.getPath());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)fileInputStream, StringUtil.codeString(ServerProperties.getPath())));
            ALLATORIxDEMO.load(bufferedReader);
            bufferedReader.close();
            return;
        }
        catch (IOException iOException) {
            System.err.println("\u8b80\u53d6\"" + ServerProperties.getPath() + "\"\u6a94\u6848\u5931\u6557 " + iOException);
            return;
        }
    }

    public static /* synthetic */ void setProperty(String a2, boolean a3) {
        ALLATORIxDEMO.setProperty(a2, String.valueOf(a3));
    }

    public static /* synthetic */ String getPath() {
        return System.getProperty(SpecialItemData.ALLATORIxDEMO("XR\\["), "") + "settings.ini";
    }

    public static /* synthetic */ String getProperty(String a2) {
        return ALLATORIxDEMO.getProperty(a2);
    }

    public static /* synthetic */ void removeProperty(String a2) {
        ALLATORIxDEMO.remove(a2);
    }

    public static /* synthetic */ byte getProperty(String a2, byte a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Byte.parseByte(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ long getWorldProperty(String a2, long a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Long.parseLong(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new Properties();
        ServerProperties.loadProperties();
    }

    public static /* synthetic */ byte getWorldProperty(String a2, byte a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Byte.parseByte(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ int getWorldProperty(String a2, int a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Integer.parseInt(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ int getProperty(String a2, int a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Integer.parseInt(string);
        }
        return a3;
    }

    public /* synthetic */ ServerProperties() {
        ServerProperties a2;
    }

    public static /* synthetic */ boolean getWorldProperty(String a2, boolean a3) {
        return ServerProperties.getWorldProperty(a2, a3 ? SpecialItemData.ALLATORIxDEMO("\\A]V") : \u65b0\u661f\u8c37.ALLATORIxDEMO((String)",\u001c&\u000e/")).equalsIgnoreCase(SpecialItemData.ALLATORIxDEMO("\\A]V"));
    }

    public static /* synthetic */ long getProperty(String a2, long a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Long.parseLong(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ char getWorldProperty(String a2, char a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return string.charAt(0);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ void setProperty(String a2, long a3) {
        ALLATORIxDEMO.setProperty(a2, String.valueOf(a3));
    }

    public static /* synthetic */ short getWorldProperty(String a2, short a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Short.parseShort(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ void setProperty(String a2, byte a3) {
        ALLATORIxDEMO.setProperty(a2, String.valueOf(a3));
    }

    public static /* synthetic */ void setProperty(String a2, short a3) {
        ALLATORIxDEMO.setProperty(a2, String.valueOf(a3));
    }

    public static /* synthetic */ void saveProperties() {
        File file = new File(ServerProperties.getPath());
        if (file.exists()) {
            file.delete();
        }
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList2 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList3 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList4 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList5 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList6 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList7 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList8 = new ArrayList<CallSite>();
        ArrayList<CallSite> arrayList9 = new ArrayList<CallSite>();
        for (Map.Entry<Object, Object> object2 : ALLATORIxDEMO.entrySet()) {
            String string = object2.getKey() + " = " + object2.getValue().toString().replace(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0016"), SpecialItemData.ALLATORIxDEMO("to")) + "\r\n";
            if (((String)object2.getKey()).contains(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"-\u001c'\u00189\u0018>"))) {
                arrayList3.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains(SpecialItemData.ALLATORIxDEMO("X\\ZG"))) {
                arrayList4.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u00182\u001b?\u0013)\t#\u0012$"))) {
                arrayList5.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains(SpecialItemData.ALLATORIxDEMO("TI^M_GT"))) {
                arrayList7.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"-\u001c'\u0018)\u0015/\u001c>"))) {
                arrayList6.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains(SpecialItemData.ALLATORIxDEMO("yGQ"))) {
                arrayList2.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains("backup")) {
                arrayList8.add((CallSite)((Object)string));
                continue;
            }
            if (((String)object2.getKey()).contains(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u0019("))) {
                arrayList9.add((CallSite)((Object)string));
                continue;
            }
            arrayList.add((CallSite)((Object)string));
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), SpecialItemData.ALLATORIxDEMO("\u0010\bh\u8cef\u65aa\u5e83\u917e\u7f46n%9"));
        Iterator<Map.Entry<Object, Object>> iterator = arrayList9.iterator();
        Iterator<Object> iterator2 = iterator;
        while (iterator2.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator2 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"i]\u0011\u7a92\u53a9\u9661\u9107\u7f13\u0017p@"));
        iterator = arrayList4.iterator();
        Iterator<Object> iterator3 = iterator;
        while (iterator3.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator3 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), SpecialItemData.ALLATORIxDEMO("\u000b\u0013s\u7cc8\u7d59\u917e\u7f46n%9"));
        iterator = arrayList.iterator();
        Iterator<Object> iterator4 = iterator;
        while (iterator4.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator4 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"^j&\u9000\u624f\u8a67\u5be7\u0017p@"));
        iterator = arrayList3.iterator();
        Iterator<Object> iterator5 = iterator;
        while (iterator5.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator5 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), SpecialItemData.ALLATORIxDEMO("\u000b\u0013s\u9079\u621a\u7d33\u932cn%9"));
        iterator = arrayList5.iterator();
        Iterator<Object> iterator6 = iterator;
        while (iterator6.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator6 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"^j&\u9678\u63e6\u52d5\u8080\u0017p@"));
        iterator = arrayList6.iterator();
        Iterator<Object> iterator7 = iterator;
        while (iterator7.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator7 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), SpecialItemData.ALLATORIxDEMO("\u000b\u0013s\u64c7\u516d\u52ac\u80d5n%9"));
        iterator = arrayList7.iterator();
        Iterator<Object> iterator8 = iterator;
        while (iterator8.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator8 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"^j&\u50d3\u4e80\u52d5\u8080\u0017p@"));
        iterator = arrayList8.iterator();
        Iterator<Object> iterator9 = iterator;
        while (iterator9.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator9 = iterator;
        }
        FileoutputUtil.logToFile(ServerProperties.getPath(), SpecialItemData.ALLATORIxDEMO("%9\u000b\u0013s\u8044\u6945\u5246\u5ed2\u95b8\u95f4n%9"));
        iterator = arrayList2.iterator();
        Iterator<Object> iterator10 = iterator;
        while (iterator10.hasNext()) {
            String string = (String)((Object)iterator.next());
            FileoutputUtil.logToFile(ServerProperties.getPath(), string);
            iterator10 = iterator;
        }
    }

    public static /* synthetic */ void setProperty(String a2, int a3) {
        ALLATORIxDEMO.setProperty(a2, String.valueOf(a3));
    }

    public static /* synthetic */ short getProperty(String a2, short a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return Short.parseShort(string);
        }
        System.out.println("\u7f3a\u5c11\u8a2d\u5b9a: " + a2 + " \u63a1\u7528\u9810\u8a2d: " + a3);
        return a3;
    }

    public static /* synthetic */ String getWorldProperty(String a2, String a3) {
        String string = ALLATORIxDEMO.getProperty(a2);
        if (string != null) {
            return string;
        }
        return a3;
    }
}

