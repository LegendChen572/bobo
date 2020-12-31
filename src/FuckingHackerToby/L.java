/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

public class L {
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int d;

    public /* synthetic */ int H() {
        L a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = 5 << 4 ^ 5;
        int n5 = n3;
        int n6 = 5 << 3 ^ (2 ^ 5);
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

    public /* synthetic */ int ALLATORIxDEMO() {
        L a2;
        return a2.d;
    }

    public /* synthetic */ L() {
        L a2;
    }

    public /* synthetic */ void H(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void ALLATORIxDEMO(int a2) {
        a.d = a2;
    }
}

