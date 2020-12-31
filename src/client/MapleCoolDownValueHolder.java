/*
 * Decompiled with CFR 0.150.
 */
package client;

public class MapleCoolDownValueHolder {
    public /* synthetic */ int skillId;
    public /* synthetic */ long length;
    public /* synthetic */ long startTime;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ 3;
        int n5 = n3;
        int n6 = 4 << 3 ^ 3;
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

    public /* synthetic */ MapleCoolDownValueHolder(int a2, long a3, long a4) {
        MapleCoolDownValueHolder a5;
        MapleCoolDownValueHolder mapleCoolDownValueHolder = a5;
        a5.skillId = a2;
        mapleCoolDownValueHolder.startTime = a3;
        mapleCoolDownValueHolder.length = a4;
    }
}

