/*
 * Decompiled with CFR 0.150.
 */
package server.life;

public class MonsterQuestDropEntry {
    public /* synthetic */ int questid;
    public /* synthetic */ int itemId;
    public /* synthetic */ int chance;
    public /* synthetic */ int Minimum;
    public /* synthetic */ int MobId;
    public /* synthetic */ int Maximum;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = 5 << 4 ^ 2 << 1;
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

    public /* synthetic */ MonsterQuestDropEntry(int a2, int a3, int a4, int a5, int a6, int a7) {
        MonsterQuestDropEntry a8;
        MonsterQuestDropEntry monsterQuestDropEntry = a8;
        MonsterQuestDropEntry monsterQuestDropEntry2 = a8;
        MonsterQuestDropEntry monsterQuestDropEntry3 = a8;
        monsterQuestDropEntry3.MobId = a2;
        monsterQuestDropEntry3.itemId = a3;
        monsterQuestDropEntry2.chance = a7;
        monsterQuestDropEntry2.questid = a6;
        monsterQuestDropEntry.Minimum = a4;
        monsterQuestDropEntry.Maximum = a5;
    }
}

