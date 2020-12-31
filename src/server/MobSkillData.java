/*
 * Decompiled with CFR 0.150.
 */
package server;

public class MobSkillData {
    private final /* synthetic */ int d;
    private final /* synthetic */ int a;
    private final /* synthetic */ int K;
    private final /* synthetic */ int k;
    private final /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ int B;

    public /* synthetic */ int getSkill() {
        MobSkillData a2;
        return a2.k;
    }

    public /* synthetic */ int getLevel() {
        MobSkillData a2;
        return a2.B;
    }

    public /* synthetic */ int getEffectAfter() {
        MobSkillData a2;
        return a2.a;
    }

    public /* synthetic */ boolean inOnlyFsm() {
        MobSkillData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MobSkillData(int a2, int a3, int a4, int a5, int a6, boolean a7) {
        MobSkillData a8;
        MobSkillData mobSkillData = a8;
        MobSkillData mobSkillData2 = a8;
        MobSkillData mobSkillData3 = a8;
        mobSkillData3.B = a2;
        mobSkillData3.k = a3;
        mobSkillData2.K = a4;
        mobSkillData2.a = a5;
        mobSkillData.d = a6;
        mobSkillData.ALLATORIxDEMO = a7;
    }

    public /* synthetic */ int getSkillForbid() {
        MobSkillData a2;
        return a2.K;
    }

    public /* synthetic */ int getSkillAfter() {
        MobSkillData a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = 1 << 3 ^ 5;
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

