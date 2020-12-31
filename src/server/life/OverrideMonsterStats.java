/*
 * Decompiled with CFR 0.150.
 */
package server.life;

public class OverrideMonsterStats {
    public /* synthetic */ int exp;
    public /* synthetic */ long hp;
    public /* synthetic */ int mp;

    public /* synthetic */ OverrideMonsterStats(long a2, int a3, int a4, boolean a5) {
        OverrideMonsterStats a6;
        OverrideMonsterStats overrideMonsterStats = a6;
        a6.hp = a2;
        overrideMonsterStats.mp = a3;
        overrideMonsterStats.exp = a4;
    }

    public /* synthetic */ int getExp() {
        OverrideMonsterStats a2;
        return a2.exp;
    }

    public /* synthetic */ int getMp() {
        OverrideMonsterStats a2;
        return a2.mp;
    }

    public /* synthetic */ OverrideMonsterStats() {
        OverrideMonsterStats a2;
        OverrideMonsterStats overrideMonsterStats = a2;
        a2.hp = 0L;
        overrideMonsterStats.exp = 0;
        overrideMonsterStats.mp = 0;
    }

    public /* synthetic */ void setOMp(int a2) {
        a.mp = a2;
    }

    public /* synthetic */ long getHp() {
        OverrideMonsterStats a2;
        return a2.hp;
    }

    public /* synthetic */ void setOHp(long a2) {
        a.hp = a2;
    }

    public /* synthetic */ void setOExp(int a2) {
        a.exp = a2;
    }

    public /* synthetic */ OverrideMonsterStats(long a2, int a3, int a4) {
        a5(a2, a3, a4, true);
        OverrideMonsterStats a5;
    }
}

