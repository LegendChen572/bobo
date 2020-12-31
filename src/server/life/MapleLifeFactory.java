/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import client.messages.commands.InternCommand;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MobConstants;
import handling.world.MaplePartyCharacter;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import provider.WzXML.MapleDataType;
import server.MobSkillData;
import server.Randomizer;
import server.life.AbstractLoadedMapleLife;
import server.life.BanishInfo;
import server.life.Element;
import server.life.ElementalEffectiveness;
import server.life.MapleMonster;
import server.life.MapleMonsterInformationProvider;
import server.life.MapleMonsterStats;
import server.life.MapleNPC;
import server.life.MobAttackInfo;
import server.life.OverrideMonsterStats;
import server.maps.MapleMap;
import tools.StringUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleLifeFactory {
    private static final /* synthetic */ Map<Integer, String> K;
    private static final /* synthetic */ MapleDataProvider e;
    private static final /* synthetic */ MapleData B;
    private static final /* synthetic */ Map<Integer, Integer> d;
    private static final /* synthetic */ Map<Integer, Boolean> k;
    private static final /* synthetic */ MapleData E;
    private static final /* synthetic */ MapleDataProvider C;
    private static final /* synthetic */ Map<Integer, List<Integer>> ALLATORIxDEMO;
    private static final /* synthetic */ MapleDataProvider H;
    private static final /* synthetic */ Map<Integer, MapleMonsterStats> a;
    private static final /* synthetic */ MapleData g;

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void loadNpcNames() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ MapleMonster getMonsterA(int a) {
        var1_1 = MapleLifeFactory.a.get(a);
        var2_2 = null;
        if (var1_1 != null) return new MapleMonster(a, var1_1);
        try {
            v0 = var2_2 = MapleLifeFactory.C.getData(StringUtil.getLeftPaddedStr(Integer.toString(a) + ".img", '0', 11));
        }
        catch (Exception var3_3) {
            v0 = var2_2;
        }
        if (v0 == null) {
            return null;
        }
        var3_4 = var2_2.getChildByPath(InternCommand.ALLATORIxDEMO("XkWj"));
        v1 = var1_1 = new MapleMonsterStats(a);
        v2 = var1_1;
        v3 = var1_1;
        var1_1.setHp(MapleDataTool.getLongConvert(MaplePartyCharacter.ALLATORIxDEMO("k_~vV"), var3_4, 0x7FFFFFFFL));
        v3.setMp(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("hP}|U"), var3_4, 0));
        v3.setExp(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("cFv"), var3_4, 0));
        v2.setLevel((short)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("iTsTi"), var3_4));
        v2.setRemoveAfter(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("t[kQp[GXr[t"), var3_4, 0));
        v1.setrareItemDropLevel((byte)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("wPwTLE`\\ACjAITsTi"), var3_4, 0));
        v1.setFixedDamage(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("`W~[bzgSgYc"), var3_4, -1));
        if (a == 9410066) {
            System.out.println(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("^k]|\u007fjChPipqEdRn"), var3_4, 0));
        }
        var1_1.setOnlyNormalAttack(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("QhR\u007fpiLk_j\u007frJg]m"), var3_4, 0) > 0);
        var1_1.setBoss(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("SjBv"), var3_4, 0) > 0 || a == 8810018 || a == 9410066 || a >= 0x866E86 && a <= 8810122);
        var1_1.setExplosiveReward(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("cFvRiMoHclcIgLb"), var3_4, 0) > 0);
        var1_1.setFfaLoot(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("ApSiXfc`FdCa"), var3_4, 0) > 0);
        var1_1.setUndead(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("KhZc_b"), var3_4, 0) > 0 || a == 9700004 || a == 9700009 || a == 9700010 || a == 9700011);
        var1_1.setName(MapleMonsterInformationProvider.getInstance().getMobName(a).isEmpty() != false ? MapleDataTool.getString(a + "/name", MapleLifeFactory.E, "MISSINGNO") : MapleMonsterInformationProvider.getInstance().getMobName(a));
        v4 = var1_1;
        v4.setBuffToGive(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("SpWc"), var3_4, -1));
        v4.setFriendly(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("ZgSgYcZDGKQd"), var3_4, 0) > 0);
        var1_1.setNoDoom(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("_juj^h"), var3_4, 0) > 0);
        v5 = var1_1;
        v6 = var1_1;
        v7 = var1_1;
        v7.setCP((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("a[r}V"), var3_4, 0));
        v7.setPoint(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("u^l_q"), var3_4, 0));
        v6.setDropItemPeriod(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("ZtQvwr[kncLoQb"), var3_4, 0));
        v6.setPhysicalDefense((short)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("aAud\\dV`"), var3_4, 0));
        v5.setMagicDefense((short)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("sBzgSgYc"), var3_4, 0));
        v5.setEva((short)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("`Gd"), var3_4, 0));
        var4_5 = MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("Nna_sYcvoZc"), var3_4, 0) > 0 || MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("YlU`yU"), var3_4, 0) > 0;
        var5_9 = var3_4.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("u[jXB[uJtKeJoQh"));
        v8 = var1_1;
        if (var5_9 != null) {
            v8.setSelfDHP(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("Yu"), (MapleData)var5_9, 0));
            v9 = var3_4;
            var1_1.setSelfD((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("_eJoQh"), (MapleData)var5_9, -1));
        } else {
            v8.setSelfD((byte)-1);
            v9 = var3_4;
        }
        var5_9 = v9.getChildByPath(InternCommand.ALLATORIxDEMO("cXwBqpqEdRn"));
        if (var5_9 == null) ** GOTO lbl60
        if (var5_9.getType() == MapleDataType.FLOAT) {
            var1_1.setFirstAttack(Math.round(MapleDataTool.getFloat((MapleData)var5_9)) > 0);
            v10 = var1_1;
        } else {
            var1_1.setFirstAttack(MapleDataTool.getInt((MapleData)var5_9) > 0);
lbl60:
            // 2 sources

            v10 = var1_1;
        }
        if (!v10.isBoss() && !MapleLifeFactory.ALLATORIxDEMO(a)) ** GOTO lbl69
        if (var4_5 || var3_4.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("VvjgYEQjQt")) == null || var3_4.getChildByPath(InternCommand.ALLATORIxDEMO("YuedVGVf^i^w")) == null) {
            var1_1.setTagColor(0);
            var1_1.setTagBgColor(0);
            v11 = var3_4;
        } else {
            var1_1.setTagColor(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("VvjgYEQjQt"), var3_4));
            var1_1.setTagBgColor(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("YuedVGVf^i^w"), var3_4));
lbl69:
            // 2 sources

            v11 = var3_4;
        }
        var4_6 = v11.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("d_h"));
        if (var4_6 != null) {
            var1_1.setBanishInfo(new BanishInfo(MapleDataTool.getString(InternCommand.ALLATORIxDEMO("Sd_HBb"), var4_6), MapleDataTool.getInt(MaplePartyCharacter.ALLATORIxDEMO("\\gPK_v\u00116\u0011`WcRb"), var4_6, -1), MapleDataTool.getString(InternCommand.ALLATORIxDEMO("gPk|dA*\u0001*AjCqPi"), var4_6, MaplePartyCharacter.ALLATORIxDEMO("Mv"))));
        }
        if ((var4_6 = var3_4.getChildByPath(InternCommand.ALLATORIxDEMO("C`GlG`"))) != null) {
            var5_9 = new LinkedList<E>();
            v12 = var6_10 = var4_6.iterator();
            while (v12.hasNext()) {
                var7_13 = (MapleData)var6_10.next();
                v12 = var6_10;
                var5_9.add(MapleDataTool.getInt(var7_13));
            }
            var1_1.setRevives((List<Integer>)var5_9);
        }
        if ((var5_9 = var3_4.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("uUoRj"))) != null) {
            var6_11 = 0;
            var7_13 = new ArrayList<E>();
            v13 = var5_9;
            while (v13.getChildByPath(Integer.toString(var6_11)) != null) {
                var4_7 = MapleDataTool.getInt(var6_11 + "/level", var5_9, 0);
                var8_15 = MapleDataTool.getInt(var6_11 + "/skill", var5_9, 0);
                var9_17 = MapleDataTool.getInt(var6_11 + "/skillForbid", var5_9, 0);
                var10_18 = MapleDataTool.getInt(var6_11 + "/effectAfter", var5_9, 0);
                var11_19 = MapleDataTool.getInt(var6_11 + "/skillAfter", var5_9, 0);
                var12_20 = MapleDataTool.getInt(var6_11 + "/onlyFsm", var5_9, 0) == 1;
                v13 = var5_9;
                ++var6_11;
                var7_13.add(new MobSkillData(var4_7, var8_15, var9_17, var10_18, var11_19, var12_20));
            }
            var1_1.setSkills((List<MobSkillData>)var7_13);
        }
        MapleLifeFactory.decodeElementalString(var1_1, MapleDataTool.getString(InternCommand.ALLATORIxDEMO("TiThpqEw"), var3_4, ""));
        var6_12 = MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("RoPm"), var3_4, 0);
        if (var6_12 != 0) {
            var2_2 = MapleLifeFactory.C.getData(StringUtil.getLeftPaddedStr(var6_12 + ".img", '0', 11));
        }
        block12: for (MapleData var4_8 : var2_2) {
            block32: {
                var8_16 = var4_8.getName();
                var9_17 = -1;
                switch (var8_16.hashCode()) {
                    case 101491: {
                        if (!var8_16.equals(InternCommand.ALLATORIxDEMO("c]|"))) break;
                        v14 = var9_17 = 0;
                        break block32;
                    }
                    case 3357649: {
                        if (!var8_16.equals(MaplePartyCharacter.ALLATORIxDEMO("SiHc"))) break;
                        var9_17 = 1;
                    }
                }
                v14 = var9_17;
            }
            switch (v14) {
                case 0: {
                    var1_1.setFly(true);
                    var1_1.setMobile(true);
                    break block12;
                }
                case 1: {
                    var1_1.setMobile(true);
                }
                default: {
                    continue block12;
                }
            }
        }
        var7_14 = -1;
        if (var1_1.getTagColor() > 0) {
            var7_14 = 0;
            v15 = var1_1;
        } else if (var1_1.isFriendly()) {
            var7_14 = 1;
            v15 = var1_1;
        } else if (a >= 0x8DE8D8 && a <= 9300215) {
            var7_14 = 2;
            v15 = var1_1;
        } else {
            if (!var1_1.isBoss() || a == 9410066) {
                var7_14 = 3;
            }
            v15 = var1_1;
        }
        v15.setHPDisplayType((byte)var7_14);
        MapleLifeFactory.a.put(a, var1_1);
        return new MapleMonster(a, var1_1);
    }

    public static /* synthetic */ int getNpcIdByName(String a2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : K.entrySet()) {
            if (!a2.equals(entry.getValue())) continue;
            return (Integer)entry.getKey();
        }
        return 0;
    }

    public static /* synthetic */ void loadMoveNpc() {
        MapleDataProvider mapleDataProvider = MapleDataProviderFactory.getDataProvider(MaplePartyCharacter.ALLATORIxDEMO("pv](I|"));
        Object object = mapleDataProvider.getRoot().getFiles();
        String string = null;
        MapleData mapleData = null;
        object = object.iterator();
        while (object.hasNext()) {
            string = ((MapleDataFileEntry)object.next()).getName();
            mapleData = mapleDataProvider.getData(string).getChildByPath(InternCommand.ALLATORIxDEMO("\\jG`"));
            if (mapleData == null) continue;
            k.put(Integer.parseInt(string.replace(MaplePartyCharacter.ALLATORIxDEMO("\u0010oSa"), "")), true);
        }
    }

    public static /* synthetic */ {
        C = MapleDataProviderFactory.getDataProvider(InternCommand.ALLATORIxDEMO("|jS+F\u007f"));
        H = MapleDataProviderFactory.getDataProvider(MaplePartyCharacter.ALLATORIxDEMO("UJtWhY(I|"));
        e = MapleDataProviderFactory.getDataProvider(InternCommand.ALLATORIxDEMO("tqR+F\u007f"));
        E = H.getData(MaplePartyCharacter.ALLATORIxDEMO("KQd\u0010oSa"));
        g = H.getData(InternCommand.ALLATORIxDEMO("KAf\u001fl\\b"));
        B = e.getData(MaplePartyCharacter.ALLATORIxDEMO("HNeri]gJoQh\u0010oSa"));
        k = new HashMap<Integer, Boolean>();
        K = new HashMap<Integer, String>();
        a = new HashMap<Integer, MapleMonsterStats>();
        d = new HashMap<Integer, Integer>();
        ALLATORIxDEMO = new HashMap<Integer, List<Integer>>();
    }

    public static /* synthetic */ String getNpcNameById(int a2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : K.entrySet()) {
            if (a2 != (Integer)entry.getKey()) continue;
            return (String)entry.getValue();
        }
        return MaplePartyCharacter.ALLATORIxDEMO("\u6714\u77e3");
    }

    public static /* synthetic */ int getNPCLocation(int a2) {
        if (d.containsKey(a2)) {
            return d.get(a2);
        }
        int n2 = MapleDataTool.getIntConvert(Integer.toString(a2) + "/0", B, -1);
        d.put(a2, n2);
        return n2;
    }

    public static final /* synthetic */ List<Integer> getQuestCount(int a2) {
        return ALLATORIxDEMO.get(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ MapleMonster getMonsterB(int a) {
        block30: {
            block29: {
                var1_1 = MapleLifeFactory.a.get(a);
                if (var1_1 != null) return new MapleMonster(a, var1_1);
                var2_2 = null;
                try {
                    var2_2 = MapleLifeFactory.C.getData(StringUtil.getLeftPaddedStr(Integer.toString(a) + ".img", '0', 11));
                }
                catch (RuntimeException var3_3) {
                    return null;
                }
                if (var2_2 == null) {
                    return null;
                }
                var3_4 = var2_2.getChildByPath(InternCommand.ALLATORIxDEMO("XkWj"));
                var1_1 = new MapleMonsterStats(a);
                var1_1.setBoss(GameConstants.getPartyPlayHP(a) > 0 || MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("\\iMu"), var3_4, 0) > 0 || a == 8810018 || a == 9410066 || a >= 0x866E86 && a <= 8810122);
                var1_1.setHp(GameConstants.getPartyPlayHP(a) > 0 ? (long)GameConstants.getPartyPlayHP(a) : MapleDataTool.getLongConvert(InternCommand.ALLATORIxDEMO("hP}yU"), var3_4, 0x7FFFFFFFL));
                v0 = var1_1;
                var1_1.setHp(MapleDataTool.getLongConvert(MaplePartyCharacter.ALLATORIxDEMO("k_~vV"), var3_4, 0x7FFFFFFFL));
                v0.setMp(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("hP}|U"), var3_4, 0));
                v0.setExp(a == 9300027 ? 0 : (GameConstants.getPartyPlayEXP(a) > 0 ? GameConstants.getPartyPlayEXP(a) : MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("cFv"), var3_4, 0)));
                v1 = var1_1;
                v2 = var1_1;
                v3 = var1_1;
                v3.setLevel((short)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("iTsTi"), var3_4, 1));
                v3.setCharismaEXP((short)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("eVgLoMk_CfV"), var3_4, 0));
                v2.setRemoveAfter(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("wTh^sTDWqTw"), var3_4, 0));
                v2.setrareItemDropLevel((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("t_t[OJcSBLiNJ[p[j"), var3_4, 0));
                v1.setFixedDamage(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("cX}Taud\\dV`"), var3_4, -1));
                v1.setOnlyNormalAttack(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("QhR\u007fpiLk_j\u007frJg]m"), var3_4, 0) > 0);
                var1_1.setExplosiveReward(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("`Iu]jBlG`c`FdCa"), var3_4, 0) > 0);
                var1_1.setUndead(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("KhZc_b"), var3_4, 0) > 0);
                var1_1.setEscort(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("TvRjCq"), var3_4, 0) > 0);
                var1_1.setPartyBonus(GameConstants.getPartyPlayHP(a) > 0 || MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("v_tJ\u007f|iPsMKQd"), var3_4, 0) > 0);
                var1_1.setPartyBonusRate(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("uPwE|sj_pBW"), var3_4, 0));
                if (MapleLifeFactory.E.getChildByPath(String.valueOf(a)) != null) {
                    var1_1.setName(MapleMonsterInformationProvider.getInstance().getMobName(a).isEmpty() != false ? MapleDataTool.getString(MaplePartyCharacter.ALLATORIxDEMO("PgSc"), MapleLifeFactory.E.getChildByPath(String.valueOf(a)), "MISSINGNO") : MapleMonsterInformationProvider.getInstance().getMobName(a));
                }
                var1_1.setBuffToGive(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("SpWc"), var3_4, -1));
                var1_1.setChange(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("eVgPa[g\\j[KQd"), var3_4, 0) > 0);
                var1_1.setFriendly(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("Ud\\dV`UGHH^g"), var3_4, 0) > 0);
                var1_1.setNoDoom(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("PiziQk"), var3_4, 0) > 0);
                var1_1.setFfaLoot(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("ApSiXfc`FdCa"), var3_4, 0) > 0);
                v4 = var1_1;
                v5 = var1_1;
                v6 = var1_1;
                v7 = var1_1;
                var1_1.setCP((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("a[r}V"), var3_4, 0));
                v7.setPoint(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("u^l_q"), var3_4, 0));
                v7.setDropItemPeriod(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("ZtQvwr[kncLoQb"), var3_4, 0));
                v6.setPhysicalAttack(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("aDud\\dV`"), var3_4, 0));
                v6.setMagicAttack(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("sGzgSgYc"), var3_4, 0));
                v5.setPDRate((byte)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("aAcdE`"), var3_4, 0));
                v5.setMDRate((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("sBlgJc"), var3_4, 0));
                v4.setAcc(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("dRf"), var3_4, 0));
                v4.setEva((short)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("cHg"), var3_4, 0));
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    var1_1.setSummonType((byte)MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("Bp\\h^ke|A`"), var3_4, 0));
                }
                v8 = var1_1;
                v8.setCategory((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("]gJcYiL\u007f"), var3_4, 0));
                v8.setSpeed(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("vA`Ta"), var3_4, 0));
                var1_1.setPushed(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("NsMn[b"), var3_4, 0));
                var4_5 = var3_4.getChildByPath(InternCommand.ALLATORIxDEMO("vTiWATvEwDfEl^k"));
                v9 = var1_1;
                if (var4_5 != null) {
                    v9.setSelfDHP(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("Vv"), var4_5, 0));
                    v10 = var3_4;
                    v11 = var1_1;
                    v11.setRemoveAfter(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("wTh^sTDWqTw"), var4_5, var1_1.getRemoveAfter()));
                    v11.setSelfD((byte)MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("_eJoQh"), var4_5, -1));
                } else {
                    v9.setSelfD((byte)-1);
                    v10 = var3_4;
                }
                var4_5 = v10.getChildByPath(InternCommand.ALLATORIxDEMO("cXwBqpqEdRn"));
                if (var4_5 == null) ** GOTO lbl77
                if (var4_5.getType() == MapleDataType.FLOAT) {
                    var1_1.setFirstAttack(Math.round(MapleDataTool.getFloat(var4_5)) > 0);
                    v12 = var1_1;
                } else {
                    var1_1.setFirstAttack(MapleDataTool.getInt(var4_5) > 0);
lbl77:
                    // 2 sources

                    v12 = var1_1;
                }
                if (!v12.isBoss() && !MapleLifeFactory.ALLATORIxDEMO(a)) ** GOTO lbl86
                if (var3_4.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("VvjgYEQjQt")) == null || var3_4.getChildByPath(InternCommand.ALLATORIxDEMO("YuedVGVf^i^w")) == null) {
                    var1_1.setTagColor(0);
                    var1_1.setTagBgColor(0);
                    v13 = var3_4;
                } else {
                    var1_1.setTagColor(MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("VvjgYEQjQt"), var3_4));
                    var1_1.setTagBgColor(MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("YuedVGVf^i^w"), var3_4));
lbl86:
                    // 2 sources

                    v13 = var3_4;
                }
                var4_5 = v13.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("d_h"));
                if (var4_5 != null) {
                    var1_1.setBanishInfo(new BanishInfo(MapleDataTool.getString(InternCommand.ALLATORIxDEMO("Sd_HBb"), var4_5), MapleDataTool.getInt(MaplePartyCharacter.ALLATORIxDEMO("\\gPK_v\u00116\u0011`WcRb"), var4_5, -1), MapleDataTool.getString(InternCommand.ALLATORIxDEMO("gPk|dA*\u0001*AjCqPi"), var4_5, MaplePartyCharacter.ALLATORIxDEMO("Mv"))));
                }
                if ((var4_5 = var3_4.getChildByPath(InternCommand.ALLATORIxDEMO("C`GlG`"))) != null) {
                    var5_7 = new LinkedList<E>();
                    v14 = var6_8 = var4_5.iterator();
                    while (v14.hasNext()) {
                        var7_11 = (MapleData)var6_8.next();
                        v14 = var6_8;
                        var5_7.add(MapleDataTool.getInt(var7_11));
                    }
                    var1_1.setRevives(var5_7);
                }
                if ((var5_7 = var3_4.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("uUoRj"))) != null) {
                    var6_9 = 0;
                    var7_11 = new ArrayList<E>();
                    v15 = var5_7;
                    while (v15.getChildByPath(Integer.toString(var6_9)) != null) {
                        var4_6 = MapleDataTool.getInt(var6_9 + "/level", var5_7, 0);
                        var8_13 = MapleDataTool.getInt(var6_9 + "/skill", var5_7, 0);
                        var9_15 = MapleDataTool.getInt(var6_9 + "/skillForbid", var5_7, 0);
                        var10_16 = MapleDataTool.getInt(var6_9 + "/effectAfter", var5_7, 0);
                        var11_17 = MapleDataTool.getInt(var6_9 + "/skillAfter", var5_7, 0);
                        var12_18 = MapleDataTool.getInt(var6_9 + "/onlyFsm", var5_7, 0) == 1;
                        v15 = var5_7;
                        ++var6_9;
                        var7_11.add(new MobSkillData(var4_6, var8_13, var9_15, var10_16, var11_17, var12_18));
                    }
                    var1_1.setSkills((List<MobSkillData>)var7_11);
                }
                MapleLifeFactory.decodeElementalString(var1_1, MapleDataTool.getString(InternCommand.ALLATORIxDEMO("TiThpqEw"), var3_4, ""));
                var6_10 = MapleDataTool.getIntConvert(MaplePartyCharacter.ALLATORIxDEMO("RoPm"), var3_4, 0);
                if (var6_10 != 0) {
                    var2_2 = MapleLifeFactory.C.getData(StringUtil.getLeftPaddedStr(var6_10 + ".img", '0', 11));
                }
                for (MapleData var4_5 : var2_2) {
                    if (var4_5.getName().equals(InternCommand.ALLATORIxDEMO("c]|"))) {
                        v16 = var1_1;
                        v16.setFly(true);
                        v16.setMobile(true);
                        break;
                    }
                    if (!var4_5.getName().equals(MaplePartyCharacter.ALLATORIxDEMO("SiHc"))) continue;
                    var1_1.setMobile(true);
                }
                var7_12 = 1;
                v17 = var2_2;
                while (true) {
                    if ((var4_5 = v17.getChildByPath("attack" + var7_12 + "/info")) == null) {
                        var7_12 = -1;
                        if (var1_1.getTagColor() > 0) {
                            break;
                        }
                        break block29;
                    }
                    var8_14 = new MobAttackInfo();
                    var8_14.setDeadlyAttack(var4_5.getChildByPath(InternCommand.ALLATORIxDEMO("U`Pa]|pqEdRn")) != null);
                    v18 = var8_14;
                    v19 = var8_14;
                    v20 = var8_14;
                    v21 = var8_14;
                    v21.setMpBurn(MapleDataTool.getInt(MaplePartyCharacter.ALLATORIxDEMO("Sv|sLh"), var4_5, 0));
                    v21.setDiseaseSkill(MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("aXvTdB`"), var4_5, 0));
                    v20.setDiseaseLevel(MapleDataTool.getInt(MaplePartyCharacter.ALLATORIxDEMO("j[p[j"), var4_5, 0));
                    v20.setMpCon(MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("f^k|U"), var4_5, 0));
                    v19.attackAfter = MapleDataTool.getInt(MaplePartyCharacter.ALLATORIxDEMO("gJr_eUGXr[t"), var4_5, 0);
                    v19.PADamage = MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("aDud\\dV`"), var4_5, 0);
                    v18.MADamage = MapleDataTool.getInt(MaplePartyCharacter.ALLATORIxDEMO("nGzgSgYc"), var4_5, 0);
                    v22 = v18.magic = MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("hPbXf"), var4_5, 0) > 0;
                    if (var4_5.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("t_hYc")) != null) {
                        var8_14.range = MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("wPkV`\u001ew"), var4_5, 0);
                        if (var4_5.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("LgPa[)Rr")) != null && var4_5.getChildByPath(InternCommand.ALLATORIxDEMO("Cd_bT*Cg")) != null) {
                            var8_14.lt = (Point)var4_5.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("LgPa[)Rr")).getData();
                            var8_14.rb = (Point)var4_5.getChildByPath(InternCommand.ALLATORIxDEMO("Cd_bT*Cg")).getData();
                        }
                    }
                    ++var7_12;
                    var1_1.addMobAttack(var8_14);
                    v17 = var2_2;
                }
                var7_12 = 0;
                v23 = var1_1;
                break block30;
            }
            if (var1_1.isFriendly()) {
                var7_12 = 1;
                v23 = var1_1;
            } else if (a >= 0x8DE8D8 && a <= 9300215) {
                var7_12 = 2;
                v23 = var1_1;
            } else {
                if (!var1_1.isBoss() || a == 9410066 || var1_1.isPartyBonus()) {
                    var7_12 = 3;
                }
                v23 = var1_1;
            }
        }
        v23.setHPDisplayType((byte)var7_12);
        MapleLifeFactory.a.put(a, var1_1);
        return new MapleMonster(a, var1_1);
    }

    public static final /* synthetic */ void decodeElementalString(MapleMonsterStats a2, String a3) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.length()) {
            Element element = Element.getFromChar(a3.charAt(n2));
            Integer n4 = Integer.valueOf(String.valueOf(a3.charAt(n2 + 1)));
            a2.setEffectiveness(element, ElementalEffectiveness.getByNumber(n4));
            n3 = n2 += 2;
        }
    }

    public static /* synthetic */ boolean isMoveNpc(int a2) {
        return k.containsKey(a2);
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void ReloadNpcNames() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static final /* synthetic */ void loadQuestCounts(boolean a2) {
        if (a2) {
            ALLATORIxDEMO.clear();
        }
        if (!ALLATORIxDEMO.isEmpty()) {
            return;
        }
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : C.getRoot().getSubdirectories()) {
            if (!mapleDataDirectoryEntry.getName().equals(InternCommand.ALLATORIxDEMO("TD`BqrjDkEBCjDu"))) continue;
            for (Object object : mapleDataDirectoryEntry.getFiles()) {
                int n2 = Integer.parseInt(object.getName().substring(0, object.getName().length() - 4));
                if ((object = C.getData("QuestCountGroup/" + object.getName())) != null && object.getChildByPath(MaplePartyCharacter.ALLATORIxDEMO("WhXi")) != null) {
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();
                    Object object2 = object = object.getChildByPath(InternCommand.ALLATORIxDEMO("XkWj")).iterator();
                    while (object2.hasNext()) {
                        MapleData mapleData = (MapleData)object.next();
                        object2 = object;
                        arrayList.add(MapleDataTool.getInt(mapleData, 0));
                    }
                    ALLATORIxDEMO.put(n2, arrayList);
                    continue;
                }
                System.out.println(MaplePartyCharacter.ALLATORIxDEMO("PsRj\u001ewKcMr]iKhJaLiKv"));
            }
        }
    }

    public static /* synthetic */ Map<Integer, String> getNPCNames() {
        return K;
    }

    public static /* synthetic */ MapleMonster getRandomMonster(MapleMap a2, int a32) {
        MapleMonster mapleMonster = null;
        List<Integer> list = MobConstants.getAllOldMonsters();
        int n2 = 0;
        int n3 = a32 + 15;
        int n4 = a32 - 15;
        if (a32 > 120) {
            n3 = 200;
            n4 = 110;
        }
        try {
            while ((mapleMonster = MapleLifeFactory.getMonsterB(n2 = list.get(Randomizer.rand(0, list.size() - 1)).intValue())) == null || mapleMonster.getStats().isBoss() || mapleMonster.getStats().isFriendly() || mapleMonster.getLevel() > n3 || mapleMonster.getLevel() < n4) {
            }
        }
        catch (Exception a32) {
            System.out.println(a32);
        }
        OverrideMonsterStats a32 = new OverrideMonsterStats();
        MapleMonster mapleMonster2 = mapleMonster;
        a32.setOHp(mapleMonster2.getMobMaxHp() * 3L);
        MapleMonster mapleMonster3 = mapleMonster;
        mapleMonster3.setHp(mapleMonster3.getMobMaxHp() * 3L);
        mapleMonster2.setOverrideStats(a32);
        return mapleMonster2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean ALLATORIxDEMO(int a2) {
        switch (a2) {
            case 8810018: 
            case 0x866E86: 
            case 8810119: 
            case 0x866E88: 
            case 8810121: 
            case 8810122: 
            case 8820009: 
            case 8820010: 
            case 8820011: 
            case 8820012: 
            case 8820013: 
            case 8820014: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void reloadMonster() {
        a.clear();
    }

    public /* synthetic */ MapleLifeFactory() {
        MapleLifeFactory a2;
    }

    public static /* synthetic */ AbstractLoadedMapleLife getLife(int a2, String a3) {
        if (a3.equalsIgnoreCase(MaplePartyCharacter.ALLATORIxDEMO("h"))) {
            return MapleLifeFactory.getNPC(a2);
        }
        if (a3.equalsIgnoreCase(InternCommand.ALLATORIxDEMO("h"))) {
            return MapleLifeFactory.getMonster(a2);
        }
        System.err.println("Unknown Life type: " + a3);
        return null;
    }

    public static /* synthetic */ MapleNPC getNPC(int a2) {
        String string = K.get(a2);
        if (string == null) {
            string = MapleDataTool.getString(a2 + "/name", g, "MISSINGNO");
            if (a2 / 100 == 99016) {
                string = MaplePartyCharacter.ALLATORIxDEMO("\f6\u000e\u7b4f\u96eb\u50c9");
            }
            K.put(a2, string);
        }
        if (string.contains(InternCommand.ALLATORIxDEMO("|dAiT%eS"))) {
            return null;
        }
        return new MapleNPC(a2, string);
    }
}

