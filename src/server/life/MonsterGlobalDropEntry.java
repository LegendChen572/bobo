/*
 * Decompiled with CFR 0.150.
 */
package server.life;

public class MonsterGlobalDropEntry {
    public /* synthetic */ int chance;
    public /* synthetic */ int itemId;
    public /* synthetic */ int Minimum;
    public /* synthetic */ int Maximum;
    public /* synthetic */ int continent;
    public /* synthetic */ short questid;
    public /* synthetic */ byte dropType;
    public /* synthetic */ boolean onlySelf;

    public /* synthetic */ MonsterGlobalDropEntry(int a2, int a3, int a4, byte a5, int a6, int a7, short a8) {
        MonsterGlobalDropEntry a9;
        MonsterGlobalDropEntry monsterGlobalDropEntry = a9;
        MonsterGlobalDropEntry monsterGlobalDropEntry2 = a9;
        MonsterGlobalDropEntry monsterGlobalDropEntry3 = a9;
        MonsterGlobalDropEntry monsterGlobalDropEntry4 = a9;
        monsterGlobalDropEntry4.onlySelf = false;
        monsterGlobalDropEntry4.itemId = a2;
        monsterGlobalDropEntry3.chance = a3;
        monsterGlobalDropEntry3.dropType = a5;
        monsterGlobalDropEntry2.continent = a4;
        monsterGlobalDropEntry2.questid = a8;
        monsterGlobalDropEntry.Minimum = a6;
        monsterGlobalDropEntry.Maximum = a7;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ 2;
        int cfr_ignored_0 = 4 << 4 ^ 5 << 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
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

    public /* synthetic */ MonsterGlobalDropEntry(int a2, int a3, int a4, byte a5, int a6, int a7, short a8, boolean a9) {
        MonsterGlobalDropEntry a10;
        MonsterGlobalDropEntry monsterGlobalDropEntry = a10;
        MonsterGlobalDropEntry monsterGlobalDropEntry2 = a10;
        MonsterGlobalDropEntry monsterGlobalDropEntry3 = a10;
        MonsterGlobalDropEntry monsterGlobalDropEntry4 = a10;
        a10.onlySelf = false;
        monsterGlobalDropEntry4.itemId = a2;
        monsterGlobalDropEntry4.chance = a3;
        monsterGlobalDropEntry3.dropType = a5;
        monsterGlobalDropEntry3.continent = a4;
        monsterGlobalDropEntry2.questid = a8;
        monsterGlobalDropEntry2.Minimum = a6;
        monsterGlobalDropEntry.Maximum = a7;
        monsterGlobalDropEntry.onlySelf = a9;
    }
}

