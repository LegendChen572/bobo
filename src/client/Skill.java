/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.ISkill;
import client.MapleJob;
import client.SkillFactory;
import constants.GameSetConstants;
import constants.SpecialSkillConstants;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import provider.MapleData;
import provider.MapleDataTool;
import server.MTSCart;
import server.MapleStatEffect;
import server.Randomizer;
import server.characterCards.MapleCharacterCards;
import server.life.Element;

/*
 * Exception performing whole class analysis ignored.
 */
public class Skill
implements ISkill {
    private /* synthetic */ boolean M;
    private /* synthetic */ int c;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ String o;
    public static final /* synthetic */ int[] evanskills1;
    private /* synthetic */ boolean J;
    private /* synthetic */ boolean C;
    private /* synthetic */ int j;
    private /* synthetic */ String Q;
    private /* synthetic */ boolean m;
    private /* synthetic */ int K;
    private /* synthetic */ boolean l;
    private /* synthetic */ int d;
    private /* synthetic */ boolean A;
    private /* synthetic */ int G;
    private /* synthetic */ int b;
    private /* synthetic */ byte P;
    private /* synthetic */ int D;
    private /* synthetic */ boolean F;
    public static final /* synthetic */ int[] evanskills2;
    private /* synthetic */ int i;
    private /* synthetic */ int g;
    private /* synthetic */ int h;
    private /* synthetic */ int a;
    private /* synthetic */ boolean H;
    private /* synthetic */ Element t;
    private /* synthetic */ boolean f;
    private /* synthetic */ boolean I;
    private /* synthetic */ int k;
    private /* synthetic */ List<MapleStatEffect> B;
    private /* synthetic */ int L;
    private /* synthetic */ int E;
    private final /* synthetic */ List<MapleStatEffect> Z;
    private /* synthetic */ List<Integer> e;
    private final /* synthetic */ int w;

    public /* synthetic */ Skill(int a2) {
        Skill a3;
        Skill skill = a3;
        Skill skill2 = a3;
        Skill skill3 = a3;
        Skill skill4 = a3;
        Skill skill5 = a3;
        Skill skill6 = a3;
        Skill skill7 = a3;
        Skill skill8 = a3;
        Skill skill9 = a3;
        Skill skill10 = a3;
        Skill skill11 = a3;
        a3.Q = "";
        skill11.o = "";
        Skill skill12 = a3;
        skill11.Z = new ArrayList<MapleStatEffect>();
        skill11.h = 0;
        skill10.D = 0;
        skill10.L = 0;
        skill9.j = 0;
        skill9.i = 0;
        skill8.J = 0;
        skill8.M = false;
        skill7.I = false;
        skill7.F = false;
        skill6.C = false;
        skill6.H = false;
        skill5.e = null;
        skill5.E = 0;
        skill4.g = 0;
        skill4.B = null;
        skill3.k = 0;
        skill3.K = 0;
        skill2.a = 0;
        skill2.d = 0;
        skill.ALLATORIxDEMO = 0;
        skill.w = a2;
    }

    private static /* synthetic */ int H(MapleStatEffect a2, MapleStatEffect a3) {
        return a2.level - a3.level;
    }

    @Override
    public /* synthetic */ boolean isSpecialSkill() {
        Skill a2;
        int n2 = a2.w / 10000;
        return n2 == 7000 || n2 == 7100 || n2 == 8000 || n2 == 9000 || n2 == 9100 || n2 == 9200 || n2 == 9201 || n2 == 9202 || n2 == 9203 || n2 == 9204;
    }

    public static final /* synthetic */ Skill loadFromData(int a2, MapleData a3) {
        return Skill.loadFromData(a2, a3, null);
    }

    @Override
    public /* synthetic */ boolean isSkillNeedMasterLevel() {
        Skill a2;
        Skill skill = a2;
        return SpecialSkillConstants.isSkillNeedMasterLevel(skill.w, skill.c);
    }

    @Override
    public /* synthetic */ boolean isPVPDisabled() {
        Skill a2;
        return a2.M;
    }

    @Override
    public /* synthetic */ String getPsdDamR() {
        Skill a2;
        return a2.o;
    }

    @Override
    public /* synthetic */ boolean isChargeSkill() {
        Skill a2;
        return a2.A;
    }

    @Override
    public /* synthetic */ boolean isTimeLimited() {
        Skill a2;
        return a2.f;
    }

    @Override
    public /* synthetic */ int getvehicleID() {
        Skill a2;
        return a2.i;
    }

    @Override
    public /* synthetic */ int getPsd() {
        Skill a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ int getAnimation() {
        Skill a2;
        if (a2.e == null) {
            return -1;
        }
        Skill skill = a2;
        return skill.e.get(Randomizer.nextInt(skill.e.size()));
    }

    @Override
    public /* synthetic */ MapleStatEffect getEffect(int a2) {
        Skill a3;
        if (a3.Z.size() < a2) {
            if (a3.Z.size() > 0) {
                Skill skill = a3;
                return skill.Z.get(skill.Z.size() - 1);
            }
            return null;
        }
        if (a2 <= 0) {
            return a3.Z.get(0);
        }
        return a3.Z.get(a2 - 1);
    }

    public /* synthetic */ void setName(String a2) {
        a.Q = a2;
    }

    @Override
    public /* synthetic */ String getName() {
        Skill a2;
        return a2.Q;
    }

    @Override
    public /* synthetic */ boolean isPush() {
        Skill a2;
        return a2.C;
    }

    @Override
    public /* synthetic */ Element getElement() {
        Skill a2;
        return a2.t;
    }

    @Override
    public /* synthetic */ int getRequiredSkillId() {
        Skill a2;
        return a2.b;
    }

    @Override
    public /* synthetic */ boolean isMagic() {
        Skill a2;
        return a2.I;
    }

    @Override
    public /* synthetic */ int getAnimationTime() {
        Skill a2;
        return a2.G;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ boolean isFourthJob() {
        Skill a2;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            return a2.w / 10000 % 100 > 0 && a2.w / 10000 % 10 == 2;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (a2.w / 10000 == 2312) {
                return true;
            }
            if (a2.getMaxLevel() <= 15 && !a2.m && a2.getMasterLevel() <= 0) {
                return false;
            }
            switch (a2.w) {
                case 1120012: 
                case 1320011: 
                case 3110014: 
                case 3120010: 
                case 3120011: 
                case 3220010: 
                case 4320005: 
                case 4340010: 
                case 4340012: 
                case 5120011: 
                case 5120012: 
                case 5220012: 
                case 5220014: 
                case 5321006: 
                case 21120011: 
                case 21120014: 
                case 22181004: 
                case 23120011: 
                case 23120013: 
                case 23121008: 
                case 32120009: 
                case 33120010: {
                    return false;
                }
            }
            Skill skill = a2;
            int n2 = skill.w / 10000;
            if (skill.w / 10000 >= 2212 && a2.w / 10000 < 3000) {
                return a2.w / 10000 % 10 >= 7;
            }
            if (a2.w / 10000 >= 430 && a2.w / 10000 <= 434) {
                return a2.w / 10000 % 10 == 4 || a2.getMasterLevel() > 0;
            }
            return a2.w / 10000 % 10 == 2 && a2.w < 90000000 && !a2.isBeginnerSkill();
        }
        if (a2.w / 10000 >= 2212 && a2.w / 10000 < 3000) {
            return a2.w / 10000 % 10 >= 7;
        }
        if (a2.w / 10000 >= 430 && a2.w / 10000 <= 434) {
            return a2.w / 10000 % 10 == 4 || a2.getMasterLevel() > 0;
        }
        return a2.w / 10000 % 10 == 2;
    }

    @Override
    public /* synthetic */ boolean isInvisible() {
        Skill a2;
        return a2.m;
    }

    @Override
    public /* synthetic */ byte getMaxLevel() {
        Skill a2;
        return (byte)a2.E;
    }

    @Override
    public /* synthetic */ boolean isZeroSkill(int a2) {
        Skill a3;
        int n2 = a3.w / 10000;
        a2 = MapleJob.getJobGrade(a2);
        n2 = MapleJob.getJobGrade(n2);
        return a2 == 0 || n2 == 0;
    }

    @Override
    public /* synthetic */ boolean hasRequiredSkill() {
        Skill a2;
        return a2.P > 0;
    }

    @Override
    public /* synthetic */ int getTamingMob() {
        Skill a2;
        return a2.h;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ boolean isLinkSkills() {
        Skill a2;
        switch (a2.w) {
            case 80000000: 
            case 80000001: 
            case 80000002: 
            case 80000003: 
            case 80000004: 
            case 80000005: 
            case 80000006: 
            case 80000047: 
            case 80000050: 
            case 80000066: 
            case 80000067: 
            case 0x4C4B444: 
            case 80000069: 
            case 80000070: 
            case 80000110: 
            case 80000169: 
            case 80001040: 
            case 80001140: 
            case 80001151: 
            case 80001155: 
            case 80010006: {
                return true;
            }
        }
        return false;
    }

    @Override
    public /* synthetic */ boolean isHyperStat() {
        Skill a2;
        return a2.a > 0;
    }

    @Override
    public /* synthetic */ boolean canBeLearnedBy(int a2) {
        Skill a3;
        int n2 = a3.w / 10000;
        return MapleJob.getJobGrade(n2) <= MapleJob.getJobGrade(a2) && MapleJob.isSameJob(a2, n2);
    }

    private static /* synthetic */ int ALLATORIxDEMO(MapleStatEffect a2, MapleStatEffect a3) {
        return a2.level - a3.level;
    }

    @Override
    public /* synthetic */ MapleStatEffect getPVPEffect(int a2) {
        Skill a3;
        if (a3.B == null) {
            return a3.getEffect(a2);
        }
        if (a3.B.size() < a2) {
            if (a3.B.size() > 0) {
                Skill skill = a3;
                return skill.B.get(skill.B.size() - 1);
            }
            return null;
        }
        if (a2 <= 0) {
            return a3.B.get(0);
        }
        return a3.B.get(a2 - 1);
    }

    @Override
    public /* synthetic */ boolean isGuildSkill() {
        Skill a2;
        return a2.w / 10000 == 9100;
    }

    @Override
    public /* synthetic */ int getHyper() {
        Skill a2;
        return a2.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ boolean isTeachSkills() {
        Skill a2;
        switch (a2.w) {
            case 110: 
            case 1214: 
            case 10000255: 
            case 10000256: 
            case 10000257: 
            case 10000258: 
            case 10000259: 
            case 20021110: 
            case 20030204: 
            case 20040218: 
            case 20050286: 
            case 30010112: 
            case 30010241: 
            case 30020233: 
            case 40010001: 
            case 40020002: 
            case 50001214: 
            case 60000222: 
            case 60011219: 
            case 100000271: 
            case 110000800: {
                return true;
            }
        }
        return false;
    }

    @Override
    public /* synthetic */ boolean isPull() {
        Skill a2;
        return a2.H;
    }

    @Override
    public /* synthetic */ boolean hasAction() {
        Skill a2;
        return a2.l;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ Skill loadFromData(int a, MapleData a, MapleData a) {
        block36: {
            block39: {
                block40: {
                    block37: {
                        block38: {
                            block33: {
                                block34: {
                                    block35: {
                                        var3_3 = new Skill(a);
                                        var4_4 = false;
                                        var5_5 = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO(" *:-?\u0015*16"), a, -1);
                                        var6_8 = MapleDataTool.getString(MapleCharacterCards.ALLATORIxDEMO("1`1a\u0015x ~"), a, null);
                                        if (var6_8 != null) {
                                            v0 = var3_3;
                                            var3_3.t = Element.getFromChar(var6_8.charAt(0));
                                        } else {
                                            v0 = var3_3;
                                            var3_3.t = Element.NEUTRAL;
                                        }
                                        v0.m = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO(":/%( (1-6"), a, 0) > 0;
                                        var3_3.f = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("x=a1@=a=x1h"), a, 0) > 0;
                                        var3_3.c = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO(">  563\u001f$%$?"), a, 0);
                                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                                            var3_3.J = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("7c9n5x\u001b~0i&\u007f"), a, 0) > 0;
                                            v1 = var3_3;
                                            v2 = var3_3;
                                            v2.h = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("$%$=5\u0007 >(=&\u001e.1"), a, 0);
                                            v2.j = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("'g=`8X5a=b3A;n"), a, 0);
                                            v1.i = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("%$;(0-6\b\u0017"), a, 0);
                                            v1.D = var5_5;
                                            var6_8 = a.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("=b2c"));
                                            if (var6_8 != null) {
                                                var3_3.M = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("#7#"), (MapleData)var6_8, 1) <= 0;
                                                var3_3.I = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("a5k=o\u0010m9m3i"), (MapleData)var6_8, 0) > 0;
                                                var3_3.F = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("\"22'$!\f<76"), (MapleData)var6_8, 0) > 0;
                                                var3_3.C = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("$y'd\u0000m&k1x"), (MapleData)var6_8, 0) > 0;
                                                v3 = var3_3.H = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("1&-?\u0015234$'"), (MapleData)var6_8, 0) > 0;
                                            }
                                            if (GameSetConstants.MAPLE_VERSION >= 151) {
                                                v4 = var3_3;
                                                v4.k = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("d-|1~"), a, 0);
                                                v4.a = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO(";8#$!\u0012' '"), a, 0);
                                                var3_3.d = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("|'h"), a, 0);
                                                var3_3.K = MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("360\u001f$%"), a, 0);
                                                if (var3_3.d == 1 && (var7_9 = a.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("$\u007f0_?e8`"))) != null && a.getChildByPath(MTSCart.ALLATORIxDEMO("1 %\u0000*:-?")).getChildren().size() > 0) {
                                                    var3_3.ALLATORIxDEMO = Integer.parseInt(a.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("$\u007f0_?e8`")).getChildren().get(0).getName());
                                                }
                                            }
                                        }
                                        var6_8 = a.getChildByPath(MTSCart.ALLATORIxDEMO("$5'6\"'"));
                                        if (var5_5 == -1) break block33;
                                        if (GameSetConstants.MAPLE_VERSION < 134) break block34;
                                        if (var5_5 != 2) break block35;
                                        var4_4 = true;
                                        v5 = var3_3;
                                        break block36;
                                    }
                                    if (var5_5 != 3) ** GOTO lbl-1000
                                    var3_3.e = new ArrayList<Integer>();
                                    var3_3.e.add(0);
                                    var4_4 = var6_8 != null;
                                    v5 = var3_3;
                                    break block36;
                                }
                                if (var5_5 != 2) ** GOTO lbl-1000
                                var4_4 = true;
                                v5 = var3_3;
                                break block36;
                            }
                            v6 = a;
                            var7_9 = v6.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("5o e;b"));
                            var8_10 = v6.getChildByPath(MTSCart.ALLATORIxDEMO(";('"));
                            var9_13 = v6.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("6m8`"));
                            var10_15 = false;
                            if (var7_9 != null) break block37;
                            if (a.getChildByPath(MTSCart.ALLATORIxDEMO("1!$# !$| 05:.=")) == null) break block38;
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                var7_9 = a.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("$~1|5~1#5o e;b"));
                            }
                            var10_15 = true;
                            v7 = var3_3;
                            break block39;
                        }
                        switch (a) {
                            case 3101005: 
                            case 4221001: 
                            case 4321000: 
                            case 4321001: 
                            case 4331001: 
                            case 5201001: 
                            case 5221009: {
                                var10_15 = true;
                                break;
                            }
                        }
                        break block40;
                    }
                    if (GameSetConstants.MAPLE_VERSION < 134) {
                        var10_15 = true;
                    }
                }
                v7 = var3_3;
            }
            v7.l = var10_15;
            var4_4 = var6_8 != null && var8_10 == null && var9_13 == null;
            var4_4 |= var7_9 != null && MapleDataTool.getString(MTSCart.ALLATORIxDEMO("c"), var7_9, "").equals(MapleCharacterCards.ALLATORIxDEMO("5`1~ >")) != false;
            if (GameSetConstants.MAPLE_VERSION >= 134 && var7_9 != null) {
                var11_18 = null;
                if ((var10_15 != false ? (var11_18 = MapleDataTool.getString(var7_9, null)) : (var11_18 = MapleDataTool.getString(MTSCart.ALLATORIxDEMO("c"), var7_9, null))) != null) {
                    var4_4 |= var11_18.equals(MapleCharacterCards.ALLATORIxDEMO("5`1~ >"));
                    if (a != null && (var5_6 = a.getChildByPath((String)var11_18)) != null) {
                        v8 = var12_19 = var5_6.iterator();
                        while (v8.hasNext()) {
                            var13_20 = (MapleData)var12_19.next();
                            v8 = var12_19;
                            var3_3.L += Math.abs(MapleDataTool.getInt(MTSCart.ALLATORIxDEMO("7$? *"), (MapleData)var13_20, 0));
                        }
                        if (var3_3.L > 30) {
                            v9 = var3_3;
                            v9.L = (int)Math.round((double)v9.L * 11.0 / 16.0);
                            v9.L -= var3_3.L % 30;
                        }
                    }
                    if (SkillFactory.getDelay((String)var11_18) != null) {
                        var3_3.e = new ArrayList<Integer>();
                        var3_3.e.add(SkillFactory.getDelay((String)var11_18));
                        if (!var10_15) {
                            for (Object var12_19 : var7_9) {
                                if (MapleDataTool.getString((MapleData)var12_19, (String)var11_18).equals(var11_18) || SkillFactory.getDelay((String)(var13_20 = MapleDataTool.getString((MapleData)var12_19))) == null) continue;
                                var3_3.e.add(SkillFactory.getDelay((String)var13_20));
                            }
                        }
                    }
                }
            }
            switch (a) {
                case 1076: 
                case 11076: 
                case 2111002: 
                case 2111003: 
                case 2121001: 
                case 2221001: 
                case 2301002: 
                case 2321001: 
                case 4211001: 
                case 8001000: 
                case 12111005: 
                case 22161003: 
                case 32121006: {
                    var4_4 = false;
                    v5 = var3_3;
                    break;
                }
                case 93: 
                case 1004: 
                case 1026: 
                case 1111002: 
                case 1111007: 
                case 1211009: 
                case 1220013: 
                case 1311007: 
                case 1320009: 
                case 2120010: 
                case 2121009: 
                case 2220010: 
                case 2221009: 
                case 2311006: 
                case 2320011: 
                case 2321010: 
                case 3120006: 
                case 3121002: 
                case 3220005: 
                case 3221002: 
                case 4111001: 
                case 4111009: 
                case 4211003: 
                case 4321000: 
                case 4331003: 
                case 4341002: 
                case 5001005: 
                case 5110001: 
                case 5111005: 
                case 5111007: 
                case 5120011: 
                case 5121003: 
                case 5121009: 
                case 5121015: 
                case 5211001: 
                case 5211002: 
                case 5211006: 
                case 5211007: 
                case 5211009: 
                case 5220002: 
                case 5220011: 
                case 5220012: 
                case 5311004: 
                case 5311005: 
                case 5320007: 
                case 5321003: 
                case 5321004: 
                case 5701005: 
                case 5711001: 
                case 5711011: 
                case 5720005: 
                case 5721002: 
                case 9001004: 
                case 9101004: 
                case 10000093: 
                case 10001004: 
                case 10001026: 
                case 11111001: 
                case 12101005: 
                case 13111005: 
                case 14111007: 
                case 15001003: 
                case 15100004: 
                case 15101006: 
                case 15111002: 
                case 15111005: 
                case 15111006: 
                case 15111011: 
                case 20000093: 
                case 20001004: 
                case 20001026: 
                case 20010093: 
                case 20011004: 
                case 20011026: 
                case 20020093: 
                case 20021026: 
                case 20031209: 
                case 20031210: 
                case 21000000: 
                case 21101003: 
                case 22121001: 
                case 22131001: 
                case 22131002: 
                case 22141002: 
                case 22151002: 
                case 22151003: 
                case 22161002: 
                case 22161004: 
                case 22171000: 
                case 22171004: 
                case 22181000: 
                case 22181003: 
                case 22181004: 
                case 24101005: 
                case 24111002: 
                case 24121008: 
                case 24121009: 
                case 30000093: 
                case 30001004: 
                case 30001026: 
                case 30010093: 
                case 30011026: 
                case 31121005: 
                case 32001003: 
                case 32101002: 
                case 32101003: 
                case 32110000: 
                case 32110007: 
                case 32110008: 
                case 32110009: 
                case 32111004: 
                case 32111005: 
                case 32111006: 
                case 32111012: 
                case 32111014: 
                case 32120000: 
                case 32120001: 
                case 32121003: 
                case 33101006: 
                case 33111003: 
                case 35001001: 
                case 35001002: 
                case 35101002: 
                case 35101005: 
                case 35101007: 
                case 35101009: 
                case 35111001: 
                case 35111002: 
                case 35111004: 
                case 35111005: 
                case 35111007: 
                case 35111009: 
                case 35111010: 
                case 35111011: 
                case 35111013: 
                case 35120000: 
                case 35121003: 
                case 35121005: 
                case 35121006: 
                case 35121009: 
                case 35121010: 
                case 35121013: 
                case 80001000: 
                case 80001079: 
                case 80001080: 
                case 80001081: 
                case 80001089: {
                    var4_4 = true;
                }
                default: lbl-1000:
                // 3 sources

                {
                    v5 = var3_3;
                }
            }
        }
        v5.A = a.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("g1u0c#b")) != null;
        var7_9 = a.getChildByPath(MTSCart.ALLATORIxDEMO("\"<,>.="));
        if (var7_9 != null) {
            var3_3.E = MapleDataTool.getInt(MapleCharacterCards.ALLATORIxDEMO("9m,@1z1`"), var7_9, 1);
            if (a == 5711006 && GameSetConstants.MAPLE_VERSION < 152) {
                var3_3.E = 30;
            }
            var3_3.o = MapleDataTool.getString(MTSCart.ALLATORIxDEMO("%2,\u0001"), var7_9, "");
            var3_3.g = var3_3.E + (var3_3.J != false ? 2 : 0);
            v10 = var8_11 = 1;
            while (v10 <= var3_3.g) {
                var3_3.Z.add(MapleStatEffect.loadSkillEffectFromData(var7_9, a, var4_4, var8_11++, MapleCharacterCards.ALLATORIxDEMO("t")));
                v10 = var8_11;
            }
            Collections.sort(var3_3.Z, (Comparator)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)I, ALLATORIxDEMO(server.MapleStatEffect server.MapleStatEffect ), (Lserver/MapleStatEffect;Lserver/MapleStatEffect;)I)());
            v11 = a;
        } else {
            v12 = var8_10 = a.getChildByPath(MTSCart.ALLATORIxDEMO("?$%$?")).iterator();
            while (v12.hasNext()) {
                var9_13 = (MapleData)var8_10.next();
                v12 = var8_10;
                v13 = var9_13;
                var3_3.Z.add(MapleStatEffect.loadSkillEffectFromData(v13, a, var4_4, Byte.parseByte(v13.getName()), null));
            }
            Collections.sort(var3_3.Z, (Comparator)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)I, H(server.MapleStatEffect server.MapleStatEffect ), (Lserver/MapleStatEffect;Lserver/MapleStatEffect;)I)());
            v11 = a;
            v14 = var3_3;
            v14.E = v14.Z.size();
            v14.g = v14.Z.size();
        }
        var8_12 = v11.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("\\\u0002\\7c9a;b"));
        if (var8_12 != null) {
            var3_3.B = new ArrayList<MapleStatEffect>();
            v15 = var9_14 = 1;
            while (v15 <= var3_3.g) {
                var3_3.B.add(MapleStatEffect.loadSkillEffectFromData(var8_12, a, var4_4, var9_14++, MTSCart.ALLATORIxDEMO("+")));
                v15 = var9_14;
            }
        }
        if ((var9_13 = a.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("~1}"))) != null) {
            v16 = var10_16 = var9_13.getChildren().iterator();
            while (v16.hasNext()) {
                var11_18 = var10_16.next();
                v16 = var10_16;
                v17 = var3_3;
                v17.b = Integer.parseInt(var11_18.getName());
                v17.P = (byte)MapleDataTool.getInt((MapleData)var11_18, 1);
            }
        }
        var3_3.G = 0;
        if (var6_8 == null) return var3_3;
        v18 = var10_17 = var6_8.iterator();
        while (v18.hasNext() != false) {
            var11_18 = (MapleData)var10_17.next();
            v18 = var10_17;
            var3_3.G += MapleDataTool.getIntConvert(MTSCart.ALLATORIxDEMO("7$? *"), (MapleData)var11_18, 0);
        }
        return var3_3;
    }

    @Override
    public /* synthetic */ boolean isHyperSkill() {
        Skill a2;
        return a2.k > 0 && a2.K > 0;
    }

    @Override
    public /* synthetic */ int getTrueMax() {
        Skill a2;
        return a2.g;
    }

    @Override
    public /* synthetic */ int getReqLevel() {
        Skill a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ int getId() {
        Skill a2;
        return a2.w;
    }

    @Override
    public /* synthetic */ boolean isBeginnerSkill() {
        Skill a2;
        int n2 = a2.w / 10000;
        return n2 == 0 || n2 == 1000 || n2 == 2000 || n2 == 2001 || n2 == 3000;
    }

    public static /* synthetic */ {
        int[] arrn = new int[4];
        arrn[0] = 22171000;
        arrn[1] = 22171002;
        arrn[2] = 22171003;
        arrn[3] = 22171004;
        evanskills1 = arrn;
        int[] arrn2 = new int[4];
        arrn2[0] = 22181000;
        arrn2[1] = 22181001;
        arrn2[2] = 22181002;
        arrn2[3] = 22181003;
        evanskills2 = arrn2;
    }

    @Override
    public /* synthetic */ int getPsdSkill() {
        Skill a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ int getRequiredSkillLevel() {
        Skill a2;
        return a2.P;
    }

    @Override
    public /* synthetic */ boolean isMovement() {
        Skill a2;
        return a2.F;
    }

    @Override
    public /* synthetic */ int getSkillTamingMob() {
        Skill a2;
        return a2.j;
    }

    @Override
    public /* synthetic */ int getMasterLevel() {
        Skill a2;
        return a2.c;
    }
}

