/*
 * Decompiled with CFR 0.150.
 */
package tools.others;

import client.messages.commands.GMCommand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tools.FileoutputUtil;
import tools.npcgenerator.NPCMessage;

public class IcatchScanner {
    public static /* synthetic */ int count;
    public static /* synthetic */ List<Integer> port;
    public static /* synthetic */ int all;

    public static /* synthetic */ void scanIP(HashSet<String> a2) {
        Iterator<String> iterator;
        Iterator<String> iterator2 = iterator = a2.iterator();
        while (iterator2.hasNext()) {
            String string = iterator.next();
            for (int n2 : port) {
                if (!IcatchScanner.scanIP(string, n2)) continue;
                System.out.println("icatch\u6578\u91cf:" + ++count);
                break;
            }
            System.out.println("\u76ee\u524d\u6383\u63cf\u6578\u91cf:" + ++all);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ IcatchScanner() {
        IcatchScanner a2;
    }

    public static /* synthetic */ boolean scanIP(String a2) {
        for (int n2 : port) {
            if (!IcatchScanner.scanIP(a2, n2)) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean isIcatch(String[] a2, String a32, int a42) {
        BufferedReader a42;
        Object object;
        block5: {
            object = new ProcessBuilder(a2);
            object = ((ProcessBuilder)object).start();
            if (((Process)object).waitFor(50L, TimeUnit.MILLISECONDS)) break block5;
            return false;
        }
        try {
            FileoutputUtil.logToFile(NPCMessage.ALLATORIxDEMO("\u001e\u0002\u0015\u001e]$\"\u63ee\u63bdB;=->1,<C\u0006\u0015\u0006"), "\r\n" + (String)a32 + ":" + a42, false);
            a32 = ((Process)object).getInputStream();
            a42 = new BufferedReader(new InputStreamReader(((Process)object).getInputStream()));
            object = new StringBuilder();
            String string = null;
            BufferedReader bufferedReader = a42;
            while ((string = bufferedReader.readLine()) != null) {
                bufferedReader = a42;
                ((StringBuilder)object).append(string);
            }
        }
        catch (Exception a32) {
            System.out.print(NPCMessage.ALLATORIxDEMO("\u0017\u001f\u0000\u0002\u0000"));
            a32.printStackTrace();
            return false;
        }
        a42.close();
        ((InputStream)a32).close();
        return ((StringBuilder)object).toString().contains(GMCommand.ALLATORIxDEMO("S\u000b\u0006W\u0001\u0000R\u0002Q")) || ((StringBuilder)object).toString().contains(NPCMessage.ALLATORIxDEMO("\u001b:\u0013\u0019\u0011\u00056; ")) || ((StringBuilder)object).toString().contains(GMCommand.ALLATORIxDEMO("1E\u000bT\u0016q\r\\\fW\u0001F\u000b]\f")) || ((StringBuilder)object).toString().contains(NPCMessage.ALLATORIxDEMO("$\f\u001c\u0019\u0017\u000e\u001a")) || ((StringBuilder)object).toString().contains(GMCommand.ALLATORIxDEMO("7{!S\u000f")) || ((StringBuilder)object).toString().contains(NPCMessage.ALLATORIxDEMO("<\b\u0006;\u001b\b\u0005\b\u0000")) || ((StringBuilder)object).toString().contains(GMCommand.ALLATORIxDEMO("\u000bd\u000bW\u0015b\u0010]&d0")) || ((StringBuilder)object).toString().contains(NPCMessage.ALLATORIxDEMO(";\u0003\u0006\b\u0000\u0003\u0017\u0019R(\n\u001d\u001e\u0002\u0000\b\u0000")) || ((StringBuilder)object).toString().contains(GMCommand.ALLATORIxDEMO("v4`\u0007_\rF\u0007s\u001a\u001c\u0001S\u0000"));
    }

    public static /* synthetic */ boolean checkResponse() throws IOException {
        String string = GMCommand.ALLATORIxDEMO("\nF\u0016BX\u001dM\u0000P\u0002L\u0003Q\u0000L\u0003S\u0005L\u0004U\bZ\u0002M");
        return false;
    }

    public static /* synthetic */ {
        port = new ArrayList<Integer>();
        count = 0;
        all = 0;
        port.add(80);
        port.add(8080);
        port.add(81);
        port.add(82);
        port.add(8888);
        port.add(8000);
        port.add(90);
    }

    public static /* synthetic */ boolean scanIP(String a2, int a3) {
        String[] arrstring = new String[2];
        arrstring[0] = NPCMessage.ALLATORIxDEMO("\u000e\u0007\u001f\u001e");
        arrstring[1] = "http://" + a2 + ":" + a3 + "/";
        if (IcatchScanner.isIcatch(arrstring, a2, a3)) {
            FileoutputUtil.logToFile(GMCommand.ALLATORIxDEMO("\u000e]\u0005AM{2\u63b1\u63ad\u001d+b={!s6q*\u001c\u0016J\u0016"), "\r\n" + a2 + ":" + a3, false);
            return true;
        }
        return false;
    }
}

