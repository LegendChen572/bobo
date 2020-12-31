/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import java.awt.Point;

public class MobAttackInfo {
    public /* synthetic */ int attackAfter;
    private /* synthetic */ int d;
    public /* synthetic */ Point rb;
    public /* synthetic */ Point lt;
    public /* synthetic */ int PADamage;
    private /* synthetic */ int K;
    private /* synthetic */ boolean k;
    public /* synthetic */ boolean magic;
    private /* synthetic */ int a;
    public /* synthetic */ int range;
    public /* synthetic */ int MADamage;
    private /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ void setMpCon(int a2) {
        a.a = a2;
    }

    public /* synthetic */ void setDiseaseLevel(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void setDiseaseSkill(int a2) {
        a.d = a2;
    }

    public /* synthetic */ void setDeadlyAttack(boolean a2) {
        a.k = a2;
    }

    public /* synthetic */ MobAttackInfo() {
        MobAttackInfo a2;
        MobAttackInfo mobAttackInfo = a2;
        MobAttackInfo mobAttackInfo2 = a2;
        mobAttackInfo2.range = 0;
        mobAttackInfo2.magic = false;
        mobAttackInfo.lt = null;
        mobAttackInfo.rb = null;
    }

    public /* synthetic */ int getDiseaseSkill() {
        MobAttackInfo a2;
        return a2.d;
    }

    public /* synthetic */ int getDiseaseLevel() {
        MobAttackInfo a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ boolean isDeadlyAttack() {
        MobAttackInfo a2;
        return a2.k;
    }

    public /* synthetic */ int getMpBurn() {
        MobAttackInfo a2;
        return a2.K;
    }

    public /* synthetic */ void setMpBurn(int a2) {
        a.K = a2;
    }

    public /* synthetic */ int getMpCon() {
        MobAttackInfo a2;
        return a2.a;
    }
}

