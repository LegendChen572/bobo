/*
 * Decompiled with CFR 0.150.
 */
package client.messages;

public abstract class ConsoleCommandExecute {
    public /* synthetic */ ConsoleCommandExecute() {
        ConsoleCommandExecute a2;
    }

    public abstract /* synthetic */ boolean execute(String[] var1);

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 4 ^ (3 << 2 ^ 1);
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ 5 << 1;
        int n5 = n3;
        int n6 = 2 ^ 5;
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
}

