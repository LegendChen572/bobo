/*
 * Decompiled with CFR 0.150.
 */
package server.life;

public class MonsterDropEntry {
    public /* synthetic */ int chance;
    public /* synthetic */ int questid;
    public /* synthetic */ int Maximum;
    public /* synthetic */ int itemId;
    public /* synthetic */ int Minimum;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = 5 << 4 ^ (2 ^ 5) << 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ (2 ^ 5);
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

    public /* synthetic */ MonsterDropEntry(int a2, int a3, int a4, int a5, int a6) {
        MonsterDropEntry a7;
        MonsterDropEntry monsterDropEntry = a7;
        MonsterDropEntry monsterDropEntry2 = a7;
        a7.itemId = a2;
        monsterDropEntry2.chance = a3;
        monsterDropEntry2.questid = a6;
        monsterDropEntry.Minimum = a4;
        monsterDropEntry.Maximum = a5;
    }
}

