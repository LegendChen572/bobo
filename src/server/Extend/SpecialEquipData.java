/*
 * Decompiled with CFR 0.150.
 */
package server.Extend;

public class SpecialEquipData {
    private final /* synthetic */ int E;
    private final /* synthetic */ int B;
    private final /* synthetic */ int d;
    private final /* synthetic */ int g;
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int e;
    private final /* synthetic */ int a;
    private final /* synthetic */ int K;
    private final /* synthetic */ int k;

    public /* synthetic */ int getDamage() {
        SpecialEquipData a2;
        return a2.a;
    }

    public /* synthetic */ int getItemId() {
        SpecialEquipData a2;
        return a2.e;
    }

    public /* synthetic */ int getMobSpawn() {
        SpecialEquipData a2;
        return a2.d;
    }

    public /* synthetic */ int getMeso() {
        SpecialEquipData a2;
        return a2.B;
    }

    public /* synthetic */ int getSkillLevel() {
        SpecialEquipData a2;
        return a2.K;
    }

    public /* synthetic */ int getDrop() {
        SpecialEquipData a2;
        return a2.g;
    }

    public /* synthetic */ int getVac() {
        SpecialEquipData a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ 1;
        int n5 = n3;
        int n6 = 5 << 3 ^ 4;
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

    public /* synthetic */ int getSkill() {
        SpecialEquipData a2;
        return a2.k;
    }

    public /* synthetic */ SpecialEquipData(int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10) {
        SpecialEquipData a11;
        SpecialEquipData specialEquipData = a11;
        SpecialEquipData specialEquipData2 = a11;
        SpecialEquipData specialEquipData3 = a11;
        SpecialEquipData specialEquipData4 = a11;
        a11.e = a2;
        specialEquipData4.E = a3;
        specialEquipData4.g = a4;
        specialEquipData3.B = a5;
        specialEquipData3.k = a6;
        specialEquipData2.K = a7;
        specialEquipData2.a = a8;
        specialEquipData.d = a9;
        specialEquipData.ALLATORIxDEMO = a10;
    }

    public /* synthetic */ int getExp() {
        SpecialEquipData a2;
        return a2.E;
    }
}

