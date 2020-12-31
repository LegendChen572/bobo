/*
 * Decompiled with CFR 0.150.
 */
package tools.npcgenerator;

public abstract class Instruction {
    private /* synthetic */ boolean ALLATORIxDEMO;

    public /* synthetic */ Instruction(boolean a2) {
        Instruction a3;
        a3.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ boolean isDispose() {
        Instruction a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 << 3 ^ 2;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ 1;
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

