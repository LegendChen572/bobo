/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import constants.GameConstants;
import constants.GameSetConstants;
import handling.opcodes.SummonMovementType;
import java.awt.Point;
import server.MapleStatEffect;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.MapleMap;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleSummon
extends AbstractAnimatedMapleMapObject {
    private /* synthetic */ long d;
    private /* synthetic */ long ALLATORIxDEMO;
    private /* synthetic */ SummonMovementType B;
    private /* synthetic */ MapleMap e;
    private /* synthetic */ int k;
    private final /* synthetic */ int I;
    private /* synthetic */ long a;
    private final /* synthetic */ int C;
    private final /* synthetic */ int H;
    private /* synthetic */ byte K;
    private /* synthetic */ boolean g;
    private /* synthetic */ short E;
    private final /* synthetic */ int F;

    @Override
    public final /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.SUMMON;
    }

    public final /* synthetic */ void CheckSummonAttackFrequency(MapleCharacter a2, int a3) {
        MapleSummon mapleSummon;
        long l2;
        MapleSummon a4;
        long l3 = System.currentTimeMillis();
        int n2 = a3 - a4.k;
        if (n2 > 0 && n2 < GameConstants.getSummonAttackDelay(a4.H)) {
            MapleSummon mapleSummon2 = a4;
            a2.getCheatTracker().registerOffense(CheatingOffense.\u53ec\u559a\u7378\u7121\u5ef6\u9072, a2.getName() + "\u5feb\u901f\u53ec\u559a\u7378\u653b\u64ca \u6280\u80fd:" + mapleSummon2.H + " \u670d\u52d9\u7aef\u8a08\u7b97:" + GameConstants.getSummonAttackDelay(mapleSummon2.H) + " \u5ba2\u6236\u7aef\u6aa2\u6e2c:" + n2);
        }
        if (a4.a - (l2 = System.currentTimeMillis() - (long)a3) > 200L) {
            // empty if block
        }
        MapleSummon mapleSummon3 = a4;
        mapleSummon3.K = (byte)(mapleSummon3.K + 1);
        if (mapleSummon3.K > 4) {
            MapleSummon mapleSummon4 = a4;
            mapleSummon4.K = 0;
            mapleSummon4.a = l2;
        }
        n2 = 1000;
        if (a4.H == 35111002 || a4.H == 5321004 || a4.H == 5320011) {
            n2 = 800;
            mapleSummon = a4;
        } else if (a4.H == 5711001) {
            n2 = 560;
            mapleSummon = a4;
        } else if (a4.H == 5211014 || a4.H == 5211016) {
            n2 = 500;
            mapleSummon = a4;
        } else if (a4.H == 35111002) {
            n2 = 250;
            mapleSummon = a4;
        } else {
            if (a4.H == 5211016) {
                n2 = 300;
            }
            mapleSummon = a4;
        }
        if (mapleSummon.d > 0L && l3 - a4.d < (long)n2) {
            a2.getCheatTracker().registerOffense(CheatingOffense.\u53ec\u559a\u7378\u7121\u5ef6\u9072, "\u653b\u901f\u7570\u5e38,\u6280\u80fd: " + SkillFactory.getSkillName(a4.H) + "[" + a4.H + "] \u5ef6\u9072:" + (l3 - a4.d));
        }
        MapleSummon mapleSummon5 = a4;
        mapleSummon5.k = a3;
        mapleSummon5.d = System.currentTimeMillis();
    }

    @Override
    public final /* synthetic */ void sendSpawnData(MapleClient a2) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ int getSummonType() {
        MapleSummon a2;
        if (a2.isAngel()) {
            return 2;
        }
        if (a2.H != 33111003 && a2.H != 3120012 && a2.H != 3220012 && a2.isPuppet() || a2.H == 33101008 || a2.H == 35111002) {
            return 0;
        }
        switch (a2.H) {
            case 1321007: {
                return 2;
            }
            case 35111001: 
            case 35111009: 
            case 35111010: {
                return 3;
            }
            case 35111011: 
            case 35121009: {
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    return 5;
                }
                return 4;
            }
            case 35121003: {
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    return 6;
                }
                return 5;
            }
            case 4111007: 
            case 4211007: {
                return 6;
            }
        }
        return 1;
    }

    public final /* synthetic */ int getOwnerLevel() {
        MapleSummon a2;
        return a2.C;
    }

    public final /* synthetic */ boolean isGaviota() {
        MapleSummon a2;
        return a2.H == 5211002;
    }

    public final /* synthetic */ short getHP() {
        MapleSummon a2;
        return a2.E;
    }

    public final /* synthetic */ void updateMap(MapleMap a2) {
        a.e = a2;
    }

    public final /* synthetic */ SummonMovementType getMovementType() {
        MapleSummon a2;
        return a2.B;
    }

    public /* synthetic */ MapleSummon(MapleCharacter a22, MapleStatEffect a3, Point a4, SummonMovementType a5) {
        MapleSummon mapleSummon;
        MapleSummon a6;
        MapleSummon mapleSummon2 = a6;
        MapleSummon mapleSummon3 = a6;
        MapleSummon mapleSummon4 = a6;
        MapleSummon mapleSummon5 = a6;
        a6.g = false;
        mapleSummon5.I = a22.getId();
        mapleSummon5.C = a22.getLevel();
        mapleSummon4.H = a3.getSourceId();
        mapleSummon4.e = a22.getMap();
        mapleSummon3.F = a3.getLevel();
        mapleSummon3.B = a5;
        mapleSummon2.setPosition(a4);
        mapleSummon2.setStance(a22.getStance());
        try {
            a6.setFh(a22.getMap().getFootholds().findBelow(a4).getId());
            mapleSummon = a6;
        }
        catch (NullPointerException a22) {
            MapleSummon mapleSummon6 = a6;
            mapleSummon = mapleSummon6;
            mapleSummon6.setFh(0);
        }
        if (!mapleSummon.isPuppet()) {
            MapleSummon mapleSummon7 = a6;
            a6.k = 0;
            mapleSummon7.K = (byte)0;
            mapleSummon7.a = 0L;
        }
    }

    public final /* synthetic */ void addHP(short a2) {
        MapleSummon a3;
        a3.E = (short)(a3.E + a2);
    }

    @Override
    public final /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleSummon a3;
        a2.sendPacket(MaplePacketCreator.removeSummon(a3, false));
    }

    public final /* synthetic */ int getOwnerId() {
        MapleSummon a2;
        return a2.I;
    }

    public final /* synthetic */ int getSkill() {
        MapleSummon a2;
        return a2.H;
    }

    public /* synthetic */ void setRemoveTime(long a2) {
        a.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ boolean isBeholder() {
        MapleSummon a2;
        return a2.H == 1321007;
    }

    public final /* synthetic */ boolean isAngel() {
        MapleSummon a2;
        return GameConstants.isAngel(a2.H);
    }

    public final /* synthetic */ void setChangedMap(boolean a2) {
        a.g = a2;
    }

    public final /* synthetic */ boolean isMultiSummon() {
        MapleSummon a2;
        return a2.H == 5211002 || a2.H == 5211001 || a2.H == 5220002 || a2.H == 32111006;
    }

    public /* synthetic */ long getRemoveTime() {
        MapleSummon a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ boolean isChangedMap() {
        MapleSummon a2;
        return a2.g;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isMultiAttack() {
        MapleSummon a2;
        switch (a2.H) {
            case 2111010: 
            case 5211002: 
            case 33101008: 
            case 42100010: {
                return false;
            }
            case 35111001: 
            case 35111002: 
            case 35111009: 
            case 35111010: 
            case 35121003: 
            case 42111003: 
            case 61111002: 
            case 80001129: 
            case 131002015: {
                return true;
            }
        }
        return a2.H < 35000000;
    }

    public final /* synthetic */ MapleCharacter getOwner() {
        MapleSummon a2;
        MapleSummon mapleSummon = a2;
        return mapleSummon.e.getCharacterById(mapleSummon.I);
    }

    public final /* synthetic */ void CheckPVPSummonAttackFrequency(MapleCharacter a2) {
        MapleSummon a3;
        if (System.currentTimeMillis() - a3.d < (long)SkillFactory.getSummonData((int)a3.H).delay) {
            a2.getCheatTracker().registerOffense(CheatingOffense.\u53ec\u559a\u7378\u7121\u5ef6\u9072);
        }
        a3.d = System.currentTimeMillis();
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isPuppet() {
        MapleSummon a2;
        switch (a2.H) {
            case 3111002: 
            case 3120012: 
            case 3211002: 
            case 3220012: 
            case 4341006: 
            case 13111004: 
            case 33111003: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isSummon() {
        MapleSummon a2;
        switch (a2.H) {
            case 1321007: 
            case 2121005: 
            case 2221005: 
            case 2311006: 
            case 2321003: 
            case 3101007: 
            case 3111005: 
            case 3201007: 
            case 3211005: 
            case 4111007: 
            case 4211007: 
            case 5211001: 
            case 5211002: 
            case 5220002: 
            case 5321003: 
            case 5321004: 
            case 11001004: 
            case 12001004: 
            case 12111004: 
            case 13001004: 
            case 13111004: 
            case 14001005: 
            case 15001004: 
            case 23111008: 
            case 23111009: 
            case 23111010: 
            case 32111006: 
            case 33101008: 
            case 33101011: 
            case 33111005: 
            case 35111001: 
            case 35111002: 
            case 35111005: 
            case 35111009: 
            case 35111010: 
            case 35111011: 
            case 35121003: 
            case 35121009: 
            case 35121010: 
            case 35121011: {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ int getSkillLevel() {
        MapleSummon a2;
        return a2.F;
    }
}

