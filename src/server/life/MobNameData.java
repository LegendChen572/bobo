/*
 * Decompiled with CFR 0.150.
 */
package server.life;

public class MobNameData {
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int k;
    private final /* synthetic */ int K;
    private final /* synthetic */ int a;
    private final /* synthetic */ String B;
    private final /* synthetic */ int d;

    public /* synthetic */ int getLevel() {
        MobNameData a2;
        return a2.K;
    }

    public /* synthetic */ MobNameData(int a2, String a3, int a4, int a5, int a6, int a7) {
        MobNameData a8;
        MobNameData mobNameData = a8;
        MobNameData mobNameData2 = a8;
        MobNameData mobNameData3 = a8;
        mobNameData3.k = a2;
        mobNameData3.B = a3;
        mobNameData2.K = a4;
        mobNameData2.a = a5;
        mobNameData.d = a6;
        mobNameData.ALLATORIxDEMO = a7;
    }

    public /* synthetic */ String getMobName() {
        MobNameData a2;
        return a2.B;
    }

    public /* synthetic */ int getMaxMp() {
        MobNameData a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 3 << 3 ^ 5;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 2;
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

    public /* synthetic */ int getMobId() {
        MobNameData a2;
        return a2.k;
    }

    public /* synthetic */ int getExp() {
        MobNameData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getMaxHp() {
        MobNameData a2;
        return a2.a;
    }
}

