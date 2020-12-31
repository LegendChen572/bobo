/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.MobSkillData;
import server.life.BanishInfo;
import server.life.Element;
import server.life.ElementalEffectiveness;
import server.life.MobAttackInfo;

public class MapleMonsterStats {
    private /* synthetic */ boolean j;
    private /* synthetic */ byte O;
    private /* synthetic */ List<MobAttackInfo> ALLATORIxDEMO;
    private /* synthetic */ boolean c;
    private /* synthetic */ int a;
    private /* synthetic */ boolean h;
    private /* synthetic */ short v;
    private final /* synthetic */ Map<Element, ElementalEffectiveness> F;
    private /* synthetic */ int P;
    private /* synthetic */ short T;
    private /* synthetic */ byte X;
    private /* synthetic */ byte s;
    private /* synthetic */ int g;
    private /* synthetic */ short n;
    private /* synthetic */ byte V;
    private /* synthetic */ int r;
    private /* synthetic */ boolean f;
    private /* synthetic */ byte x;
    private /* synthetic */ int d;
    private /* synthetic */ boolean m;
    private /* synthetic */ int o;
    private /* synthetic */ boolean i;
    private /* synthetic */ byte u;
    private /* synthetic */ boolean b;
    private /* synthetic */ short R;
    private /* synthetic */ int Z;
    private /* synthetic */ boolean L;
    private /* synthetic */ int K;
    private /* synthetic */ int t;
    private /* synthetic */ int G;
    private /* synthetic */ int E;
    private /* synthetic */ byte q;
    private /* synthetic */ BanishInfo e;
    private /* synthetic */ boolean J;
    private /* synthetic */ byte Y;
    private /* synthetic */ boolean M;
    private /* synthetic */ boolean A;
    private final /* synthetic */ List<MobSkillData> H;
    private /* synthetic */ boolean D;
    private /* synthetic */ int w;
    private /* synthetic */ int Q;
    private /* synthetic */ int B;
    private /* synthetic */ byte U;
    private /* synthetic */ List<Integer> C;
    private /* synthetic */ int k;
    private /* synthetic */ boolean l;
    private /* synthetic */ String I;
    private /* synthetic */ long S;
    private /* synthetic */ short N;
    private /* synthetic */ byte z;

    public /* synthetic */ List<Integer> getRevives() {
        MapleMonsterStats a2;
        return a2.C;
    }

    public /* synthetic */ void setTagBgColor(int a2) {
        a.x = (byte)a2;
    }

    public /* synthetic */ void setFly(boolean a2) {
        a.h = a2;
    }

    public final /* synthetic */ void setMagicAttack(int a2) {
        a.k = a2;
    }

    public /* synthetic */ boolean getUndead() {
        MapleMonsterStats a2;
        return a2.c;
    }

    public /* synthetic */ void setTagColor(int a2) {
        a.U = (byte)a2;
    }

    public /* synthetic */ byte getrareItemDropLevel() {
        MapleMonsterStats a2;
        return a2.q;
    }

    public /* synthetic */ boolean isExplosiveReward() {
        MapleMonsterStats a2;
        return a2.A;
    }

    public /* synthetic */ void setCP(byte a2) {
        a.V = a2;
    }

    public /* synthetic */ void setNoSkills() {
        MapleMonsterStats a2;
        a2.H.clear();
    }

    public /* synthetic */ boolean isFfaLoot() {
        MapleMonsterStats a2;
        return a2.l;
    }

    public /* synthetic */ boolean isNoDoom() {
        MapleMonsterStats a2;
        return a2.i;
    }

    public final /* synthetic */ int getSpeed() {
        MapleMonsterStats a2;
        return a2.a;
    }

    public /* synthetic */ void setFixedDamage(int a2) {
        a.t = a2;
    }

    public /* synthetic */ void setUndead(boolean a2) {
        a.c = a2;
    }

    public /* synthetic */ int getPushed() {
        MapleMonsterStats a2;
        return a2.d;
    }

    public /* synthetic */ boolean getOnlyNoramlAttack() {
        MapleMonsterStats a2;
        return a2.D;
    }

    public /* synthetic */ boolean isFirstAttack() {
        MapleMonsterStats a2;
        return a2.m;
    }

    public /* synthetic */ boolean isFriendly() {
        MapleMonsterStats a2;
        return a2.j;
    }

    public /* synthetic */ void setCharismaEXP(short a2) {
        a.N = a2;
    }

    public /* synthetic */ byte getPDRate() {
        MapleMonsterStats a2;
        return a2.s;
    }

    public /* synthetic */ List<MobSkillData> getSkills() {
        MapleMonsterStats a2;
        return Collections.unmodifiableList(a2.H);
    }

    public /* synthetic */ void setSkills(List<MobSkillData> a2) {
        MapleMonsterStats a3;
        a3.H.addAll(a2);
    }

    public /* synthetic */ void setChange(boolean a2) {
        a.M = a2;
    }

    public /* synthetic */ void setPhysicalDefense(short a2) {
        a.v = a2;
    }

    public /* synthetic */ void setrareItemDropLevel(byte a2) {
        a.q = a2;
    }

    public /* synthetic */ void setRevives(List<Integer> a2) {
        a.C = a2;
    }

    public /* synthetic */ void setExp(int a2) {
        a.r = a2;
    }

    public /* synthetic */ byte getTagColor() {
        MapleMonsterStats a2;
        return a2.U;
    }

    public /* synthetic */ int getPhysicalAttack() {
        MapleMonsterStats a2;
        return a2.B;
    }

    public /* synthetic */ void setEscort(boolean a2) {
        a.J = a2;
    }

    public /* synthetic */ void setMp(int a2) {
        a.Q = a2;
    }

    public /* synthetic */ void setSummonType(byte a2) {
        a.z = a2;
    }

    public /* synthetic */ void setLevel(short a2) {
        a.n = a2;
    }

    public /* synthetic */ void setRemoveAfter(int a2) {
        a.o = a2;
    }

    public /* synthetic */ void setSelfD(byte a2) {
        a.u = a2;
    }

    public /* synthetic */ void setPartyBonus(boolean a2) {
        a.L = a2;
    }

    public /* synthetic */ boolean getFly() {
        MapleMonsterStats a2;
        return a2.h;
    }

    public /* synthetic */ int getBuffToGive() {
        MapleMonsterStats a2;
        return a2.Z;
    }

    public /* synthetic */ short getPhysicalDefense() {
        MapleMonsterStats a2;
        return a2.v;
    }

    public final /* synthetic */ void setPartyBonusRate(int a2) {
        a.g = a2;
    }

    public /* synthetic */ boolean isEscort() {
        MapleMonsterStats a2;
        return a2.J;
    }

    public final /* synthetic */ int getPartyBonusRate() {
        MapleMonsterStats a2;
        return a2.g;
    }

    public /* synthetic */ void setCategory(byte a2) {
        a.Y = a2;
    }

    public /* synthetic */ String getName() {
        MapleMonsterStats a2;
        return a2.I;
    }

    public /* synthetic */ void setFirstAttack(boolean a2) {
        a.m = a2;
    }

    public /* synthetic */ void setPDRate(byte a2) {
        a.s = a2;
    }

    public /* synthetic */ int getPoint() {
        MapleMonsterStats a2;
        return a2.G;
    }

    public /* synthetic */ BanishInfo getBanishInfo() {
        MapleMonsterStats a2;
        return a2.e;
    }

    public /* synthetic */ int getMp() {
        MapleMonsterStats a2;
        return a2.Q;
    }

    public /* synthetic */ boolean getMobile() {
        MapleMonsterStats a2;
        return a2.f;
    }

    public /* synthetic */ void setName(String a2) {
        a.I = a2;
    }

    public final /* synthetic */ void setEva(short a2) {
        a.R = a2;
    }

    public /* synthetic */ byte getHPDisplayType() {
        MapleMonsterStats a2;
        return a2.X;
    }

    public /* synthetic */ long getHp() {
        MapleMonsterStats a2;
        return a2.S;
    }

    public /* synthetic */ void setHPDisplayType(byte a2) {
        a.X = a2;
    }

    public /* synthetic */ byte getCategory() {
        MapleMonsterStats a2;
        return a2.Y;
    }

    public /* synthetic */ ElementalEffectiveness getEffectiveness(Element a2) {
        MapleMonsterStats a3;
        if ((a2 = a3.F.get(a2)) == null) {
            return ElementalEffectiveness.NORMAL;
        }
        return a2;
    }

    public /* synthetic */ boolean isChangeable() {
        MapleMonsterStats a2;
        return a2.M;
    }

    public /* synthetic */ void setOnlyNormalAttack(boolean a2) {
        a.D = a2;
    }

    public final /* synthetic */ short getEva() {
        MapleMonsterStats a2;
        return a2.R;
    }

    public /* synthetic */ int getSelfDHp() {
        MapleMonsterStats a2;
        return a2.P;
    }

    public /* synthetic */ int getFixedDamage() {
        MapleMonsterStats a2;
        return a2.t;
    }

    public /* synthetic */ void setEffectiveness(Element a2, ElementalEffectiveness a3) {
        MapleMonsterStats a4;
        a4.F.put(a2, a3);
    }

    public final /* synthetic */ void setAcc(int a2) {
        a.K = a2;
    }

    public /* synthetic */ int getExp() {
        MapleMonsterStats a2;
        return a2.r;
    }

    public /* synthetic */ byte getCP() {
        MapleMonsterStats a2;
        return a2.V;
    }

    public /* synthetic */ void setExplosiveReward(boolean a2) {
        a.A = a2;
    }

    public /* synthetic */ void setSelfDHP(int a2) {
        a.P = a2;
    }

    public final /* synthetic */ int getMagicAttack() {
        MapleMonsterStats a2;
        return a2.k;
    }

    public /* synthetic */ short getLevel() {
        MapleMonsterStats a2;
        return a2.n;
    }

    public /* synthetic */ List<MobAttackInfo> getMobAttacks() {
        MapleMonsterStats a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setBoss(boolean a2) {
        a.b = a2;
    }

    public /* synthetic */ void setMDRate(byte a2) {
        a.O = a2;
    }

    public final /* synthetic */ int getAcc() {
        MapleMonsterStats a2;
        return a2.K;
    }

    public /* synthetic */ void setFriendly(boolean a2) {
        a.j = a2;
    }

    public /* synthetic */ void setPushed(int a2) {
        a.d = a2;
    }

    public /* synthetic */ short getCharismaEXP() {
        MapleMonsterStats a2;
        return a2.N;
    }

    public /* synthetic */ byte getNoSkills() {
        MapleMonsterStats a2;
        return (byte)a2.H.size();
    }

    public /* synthetic */ void setNoDoom(boolean a2) {
        a.i = a2;
    }

    public /* synthetic */ MapleMonsterStats(int a2) {
        MapleMonsterStats a3;
        MapleMonsterStats mapleMonsterStats = a3;
        MapleMonsterStats mapleMonsterStats2 = a3;
        a3.F = new HashMap<Element, ElementalEffectiveness>();
        mapleMonsterStats2.C = new ArrayList<Integer>();
        mapleMonsterStats.H = new ArrayList<MobSkillData>();
        mapleMonsterStats.ALLATORIxDEMO = new ArrayList<MobAttackInfo>();
        mapleMonsterStats.E = a2;
    }

    public /* synthetic */ byte getTagBgColor() {
        MapleMonsterStats a2;
        return a2.x;
    }

    public /* synthetic */ boolean isPartyBonus() {
        MapleMonsterStats a2;
        return a2.L;
    }

    public /* synthetic */ void setBuffToGive(int a2) {
        a.Z = a2;
    }

    public /* synthetic */ void setDropItemPeriod(int a2) {
        a.w = a2;
    }

    public /* synthetic */ boolean isBoss() {
        MapleMonsterStats a2;
        return a2.b;
    }

    public final /* synthetic */ short getMagicDefense() {
        MapleMonsterStats a2;
        return a2.T;
    }

    public /* synthetic */ void setFfaLoot(boolean a2) {
        a.l = a2;
    }

    public /* synthetic */ byte getMDRate() {
        MapleMonsterStats a2;
        return a2.O;
    }

    public /* synthetic */ void removeEffectiveness(Element a2) {
        MapleMonsterStats a3;
        a3.F.remove((Object)a2);
    }

    public /* synthetic */ void addMobAttack(MobAttackInfo a2) {
        MapleMonsterStats a3;
        a3.ALLATORIxDEMO.add(a2);
    }

    public /* synthetic */ int getRemoveAfter() {
        MapleMonsterStats a2;
        return a2.o;
    }

    public final /* synthetic */ void setSpeed(int a2) {
        a.a = a2;
    }

    public /* synthetic */ void setHp(long a2) {
        a.S = a2;
    }

    public /* synthetic */ boolean hasSkill(int a2, int a3) {
        MapleMonsterStats a4;
        for (MobSkillData mobSkillData : a4.H) {
            if (mobSkillData.getSkill() != a2 || mobSkillData.getLevel() != a3) continue;
            return true;
        }
        return false;
    }

    public /* synthetic */ byte getSelfD() {
        MapleMonsterStats a2;
        return a2.u;
    }

    public final /* synthetic */ void setMagicDefense(short a2) {
        a.T = a2;
    }

    public /* synthetic */ void setBanishInfo(BanishInfo a2) {
        a.e = a2;
    }

    public /* synthetic */ void setMobile(boolean a2) {
        a.f = a2;
    }

    public /* synthetic */ int getId() {
        MapleMonsterStats a2;
        return a2.E;
    }

    public /* synthetic */ int getDropItemPeriod() {
        MapleMonsterStats a2;
        return a2.w;
    }

    public /* synthetic */ void setPoint(int a2) {
        a.G = a2;
    }

    public /* synthetic */ byte getSummonType() {
        MapleMonsterStats a2;
        return a2.z;
    }

    public /* synthetic */ MobAttackInfo getMobAttack(int a2) {
        MapleMonsterStats a3;
        if (a2 >= a3.ALLATORIxDEMO.size() || a2 < 0) {
            return null;
        }
        return a3.ALLATORIxDEMO.get(a2);
    }

    public /* synthetic */ void setPhysicalAttack(int a2) {
        a.B = a2;
    }
}

