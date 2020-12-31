/*
 * Decompiled with CFR 0.150.
 */
package client.messages;

import client.messages.ConsoleCommandExecute;

public class ConsoleCommandObject {
    private /* synthetic */ ConsoleCommandExecute ALLATORIxDEMO;
    private /* synthetic */ String d;

    public /* synthetic */ boolean execute(String[] a2) {
        ConsoleCommandObject a3;
        return a3.ALLATORIxDEMO.execute(a2);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 << 3 ^ 4;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 1 << 1;
        int n5 = n3;
        int n6 = (2 ^ 5) << 3 ^ 2;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ ConsoleCommandObject(String a2, ConsoleCommandExecute a3) {
        ConsoleCommandObject a4;
        ConsoleCommandObject consoleCommandObject = a4;
        consoleCommandObject.d = a2;
        consoleCommandObject.ALLATORIxDEMO = a3;
    }
}

