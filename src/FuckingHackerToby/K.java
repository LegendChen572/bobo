/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

public final class K {
    private static final /* synthetic */ byte ALLATORIxDEMO = 56;

    public static /* synthetic */ byte[] ALLATORIxDEMO(byte[] a2) {
        return K.ALLATORIxDEMO(a2, (byte)56);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 << 3 ^ 2;
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ 3 << 1;
        int n5 = n3;
        int n6 = 2 << 3 ^ 5;
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

    private /* synthetic */ K() {
        K a2;
    }

    public static /* synthetic */ byte[] ALLATORIxDEMO(byte[] a2, byte a3) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            byte by = (byte)(a2[n2] ^ a3);
            a2[n2] = by;
            n3 = ++n2;
        }
        return a2;
    }
}

