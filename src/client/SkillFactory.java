/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5154\u5154\u8c37
 */
package client;

import client.ISkill;
import client.Skill;
import client.SummonSkillEntry;
import client.inventory.MapleRing;
import client.messages.commands.player.\u5154\u5154\u8c37;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import constants.MobConstants;
import handling.channel.handler.PartyHandler;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.MapleItemInformationProvider;
import server.Randomizer;
import tools.StringUtil;
import tools.Triple;

public class SkillFactory {
    private static final /* synthetic */ Map<Integer, List<Integer>> B;
    private static final /* synthetic */ Map<Integer, CraftingEntry> d;
    private static final /* synthetic */ Map<Integer, ISkill> g;
    private static final /* synthetic */ MapleData K;
    private static final /* synthetic */ Map<Integer, FamiliarEntry> ALLATORIxDEMO;
    private static final /* synthetic */ Map<Integer, SummonSkillEntry> k;
    private static final /* synthetic */ Map<String, Integer> a;

    public static /* synthetic */ long getDefaultSExpiry(ISkill a2) {
        if (a2 == null) {
            return -1L;
        }
        if (a2.isTimeLimited()) {
            return System.currentTimeMillis() + 2592000000L;
        }
        return -1L;
    }

    public static /* synthetic */ void LoadSkillInformaion(boolean a2) {
        if (a2) {
            g.clear();
        }
        if (!g.isEmpty()) {
            return;
        }
        System.out.println(MobConstants.ALLATORIxDEMO("\u3012\u8bb4\u53d4\u4e19\u3013\u0014Q_kXnrcWv[pM\"\u000e8\u000e"));
        MapleDataProvider mapleDataProvider = MapleDataProviderFactory.getDataProvider(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"_JeM`\u000f{["));
        Object object = mapleDataProvider.getRoot();
        MapleData mapleData = null;
        int n2 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            mapleData = MapleDataProviderFactory.getDataProvider(MobConstants.ALLATORIxDEMO("A\\cFcWvQp\u001auN")).getData(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"<\u0011<\u0011>\u0011<\u0011\"HaF"));
            for (MapleData mapleData2 : mapleData) {
                if (mapleData2.getName().equals(MobConstants.ALLATORIxDEMO("kZd["))) continue;
                a.put(mapleData2.getName(), n2++);
            }
        }
        for (MapleDataFileEntry mapleDataFileEntry : object.getFiles()) {
            Object object2;
            Object object3;
            Object object4;
            MapleData mapleData3;
            Iterator iterator;
            if (mapleDataFileEntry.getName().length() <= 8) {
                iterator = mapleDataProvider.getData(mapleDataFileEntry.getName()).iterator();
                block4: while (iterator.hasNext()) {
                    mapleData3 = (MapleData)iterator.next();
                    if (!mapleData3.getName().equals(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"RgH`M"))) continue;
                    object4 = mapleData3.iterator();
                    block5: while (true) {
                        Object object5 = object4;
                        while (object5.hasNext()) {
                            MapleData mapleData4;
                            int n3;
                            String[] arrstring;
                            int n4;
                            MapleData mapleData2;
                            block32: {
                                int n5;
                                object3 = (MapleData)object4.next();
                                if (object3 == null) continue block5;
                                n4 = Integer.parseInt(object3.getName());
                                object2 = null;
                                try {
                                    object2 = GameSetConstants.MAPLE_VERSION >= 134 ? Skill.loadFromData(n4, (MapleData)object3, mapleData) : Skill.loadFromData(n4, (MapleData)object3);
                                }
                                catch (Exception exception) {
                                    System.out.println("\u6280\u80fdXML\u7570\u5e38 \u6280\u80fdID:" + n4);
                                    object5 = object4;
                                    exception.printStackTrace();
                                    continue;
                                }
                                arrstring = B.get(n4 / 10000);
                                if (arrstring == null) {
                                    arrstring = new ArrayList<Integer>();
                                    B.put(n4 / 10000, (List<Integer>)arrstring);
                                }
                                arrstring.add(n4);
                                ((Skill)object2).setName(SkillFactory.getName(n4));
                                g.put(n4, (ISkill)object2);
                                String[] arrstring2 = new String[2];
                                arrstring2[0] = MobConstants.ALLATORIxDEMO("qAoYmZ-Uv@cWi\u0005");
                                arrstring2[1] = \u5154\u5154\u8c37.ALLATORIxDEMO((String)"\u007fTaLcO#EeD");
                                arrstring = arrstring2;
                                n3 = 0;
                                mapleData2 = null;
                                int n6 = n5 = 0;
                                while (n6 < arrstring.length) {
                                    if (object3.getChildByPath(arrstring[n5] + "/info") != null) {
                                        mapleData2 = object3.getChildByPath(arrstring[n5] + "/info");
                                        n3 = n5;
                                        mapleData4 = mapleData2;
                                        break block32;
                                    }
                                    n6 = ++n5;
                                }
                                mapleData4 = mapleData2;
                            }
                            if (mapleData4 == null) continue block5;
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                Object object6;
                                Object object7;
                                object = new SummonSkillEntry();
                                ((SummonSkillEntry)object).type = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("vMrQ"), mapleData2, 0);
                                if (object3.getChildByPath(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"oNaLcO")) != null) {
                                    ((SummonSkillEntry)object).mobCount = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("o[`wmAl@"), object3.getChildByPath(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"oNaLcO")), 0);
                                }
                                if (((SummonSkillEntry)object).mobCount == 0 && n3 == 0) {
                                    object7 = object;
                                    ((SummonSkillEntry)object).mobCount = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("o[`wmAl@"), mapleData2, 1);
                                } else {
                                    if (n3 == 1) {
                                        ((SummonSkillEntry)object).dieMobCount = (byte)MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"aNnbcTbU"), mapleData2, 1);
                                    }
                                    object7 = object;
                                }
                                ((SummonSkillEntry)object7).attackCount = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("Uv@cWiwmAl@"), mapleData2, 1);
                                if (mapleData2.getChildByPath(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"~@bFi\u000e`U")) != null) {
                                    MapleData mapleData5 = mapleData2.getChildByPath(MobConstants.ALLATORIxDEMO("pUlSg\u001bn@"));
                                    ((SummonSkillEntry)object).lt = (Point)mapleData5.getData();
                                    ((SummonSkillEntry)object).rb = (Point)mapleData2.getChildByPath(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"~@bFi\u000e~C")).getData();
                                    object6 = object;
                                } else {
                                    object6 = object;
                                    ((SummonSkillEntry)object).lt = new Point(-100, -100);
                                    Object object8 = object;
                                    ((SummonSkillEntry)object8).rb = new Point(100, 100);
                                }
                                ((SummonSkillEntry)object6).delay = MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("QdRgWvud@gF"), mapleData2, 0) + MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"@xUmBg`jUiS"), mapleData2, 0);
                                for (MapleData mapleData6 : mapleData2) {
                                    if (mapleData6.getChildren().size() <= 0) continue;
                                    Iterator iterator2 = mapleData6.iterator();
                                    while (iterator2.hasNext()) {
                                        Iterator iterator3;
                                        MapleData mapleData7 = (MapleData)iterator3.next();
                                        iterator2 = iterator3;
                                        ((SummonSkillEntry)object).delay += MapleDataTool.getIntConvert(MobConstants.ALLATORIxDEMO("PgXcM"), mapleData7, 0);
                                    }
                                }
                                Iterator iterator4 = object3.getChildByPath(arrstring[n3]).iterator();
                                Iterator iterator5 = iterator4;
                                while (iterator5.hasNext()) {
                                    MapleData mapleData6;
                                    mapleData6 = (MapleData)iterator4.next();
                                    iterator5 = iterator4;
                                    ((SummonSkillEntry)object).delay += MapleDataTool.getIntConvert(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"EiMmX"), mapleData6, 0);
                                }
                                k.put(n4, (SummonSkillEntry)object);
                                continue block5;
                            }
                            Object object9 = object = new SummonSkillEntry();
                            ((SummonSkillEntry)object).attackAfter = (short)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("Uv@cWiud@gF"), mapleData2, 999999);
                            ((SummonSkillEntry)object9).type = (byte)MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"xX|D"), mapleData2, 0);
                            ((SummonSkillEntry)object9).mobCount = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("o[`wmAl@"), mapleData2, 1);
                            k.put(n4, (SummonSkillEntry)object);
                            continue block5;
                        }
                        continue block4;
                        break;
                    }
                }
                continue;
            }
            if (GameSetConstants.MAPLE_VERSION < 134) continue;
            if (mapleDataFileEntry.getName().startsWith(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"J@aH`HmS"))) {
                Iterator iterator6 = mapleDataProvider.getData(mapleDataFileEntry.getName()).iterator();
                while (iterator6.hasNext()) {
                    mapleData3 = (MapleData)iterator.next();
                    int n7 = Integer.parseInt(mapleData3.getName());
                    Object object10 = object4 = new FamiliarEntry();
                    Object object11 = object4;
                    Object object12 = object4;
                    ((FamiliarEntry)object12).prop = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("rFmD"), mapleData3, 0);
                    ((FamiliarEntry)object12).time = (byte)MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"xHaD"), mapleData3, 0);
                    ((FamiliarEntry)object11).attackCount = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("Uv@cWiwmAl@"), mapleData3, 1);
                    ((FamiliarEntry)object11).targetCount = (byte)MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"UmSkDxbcTbU"), mapleData3, 1);
                    ((FamiliarEntry)object10).speed = (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("GrQgP"), mapleData3, 1);
                    boolean bl = ((FamiliarEntry)object10).knockback = MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"JbNoJn@oJ"), mapleData3, 0) > 0 || MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("Uv@pUa@"), mapleData3, 0) > 0;
                    if (mapleData3.getChildByPath(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"`U")) != null) {
                        ((FamiliarEntry)object4).lt = (Point)mapleData3.getChildByPath(MobConstants.ALLATORIxDEMO("n@")).getData();
                        ((FamiliarEntry)object4).rb = (Point)mapleData3.getChildByPath(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"~C")).getData();
                    }
                    if (MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("q@wZ"), mapleData3, 0) > 0) {
                        ((FamiliarEntry)object4).status.add(MonsterStatus.STUN);
                    }
                    if (MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"\u007fMcV"), mapleData3, 0) > 0) {
                        ((FamiliarEntry)object4).status.add(MonsterStatus.SPEED);
                    }
                    ALLATORIxDEMO.put(n7, (FamiliarEntry)object4);
                    iterator6 = iterator;
                }
                continue;
            }
            if (!mapleDataFileEntry.getName().startsWith(MobConstants.ALLATORIxDEMO("PQa]rQ"))) continue;
            Iterator iterator7 = mapleDataProvider.getData(mapleDataFileEntry.getName()).iterator();
            while (iterator7.hasNext()) {
                mapleData3 = (MapleData)iterator.next();
                int n8 = Integer.parseInt(mapleData3.getName());
                object4 = new CraftingEntry(n8, (byte)MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"HbBJ@xHk@nH`HxX"), mapleData3, 0), (byte)MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("FgEQ_kXnxgBgX"), mapleData3, 0), (byte)MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"HbB_JeM`q~NjHoHiOoX"), mapleData3, 0), MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("lQgPMDgZK@gY"), mapleData3, 0) > 0, MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"|D~HcE"), mapleData3, 0));
                Iterator iterator8 = object3 = mapleData3.getChildByPath(MobConstants.ALLATORIxDEMO("vUpSg@")).iterator();
                while (iterator8.hasNext()) {
                    object2 = (MapleData)object3.next();
                    iterator8 = object3;
                    ((CraftingEntry)object4).targetItems.add(new Triple<Integer, Integer, Integer>(MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"eUiL"), (MapleData)object2, 0), MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("WmAl@"), (MapleData)object2, 0), MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"|ScC[DeFdU"), (MapleData)object2, 0)));
                }
                Iterator iterator9 = object3 = mapleData3.getChildByPath(MobConstants.ALLATORIxDEMO("pQa]rQ")).iterator();
                while (iterator9.hasNext()) {
                    object2 = (MapleData)object3.next();
                    iterator9 = object3;
                    ((CraftingEntry)object4).reqItems.put(MapleDataTool.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"eUiL"), (MapleData)object2, 0), MapleDataTool.getInt(MobConstants.ALLATORIxDEMO("WmAl@"), (MapleData)object2, 0));
                }
                d.put(n8, (CraftingEntry)object4);
                iterator7 = iterator;
            }
        }
    }

    public static final /* synthetic */ SummonSkillEntry getSummonData(int a2) {
        return k.get(a2);
    }

    public static final /* synthetic */ String getSkillName(int a2) {
        String string;
        String string2 = null;
        ISkill iSkill = SkillFactory.getSkill(a2);
        if (a2 == 0) {
            string = string2 = \u5154\u5154\u8c37.ALLATORIxDEMO((String)"\u6662\u903b\u6537\u64eb");
        } else {
            if (iSkill != null) {
                string2 = iSkill.getName();
            }
            string = string2;
        }
        if (string == null) {
            string2 = MapleItemInformationProvider.getInstance().getName(a2);
        }
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public static final /* synthetic */ Collection<ISkill> getAllSkills() {
        return g.values();
    }

    public static /* synthetic */ {
        g = new HashMap<Integer, ISkill>();
        B = new HashMap<Integer, List<Integer>>();
        k = new HashMap<Integer, SummonSkillEntry>();
        K = MapleDataProviderFactory.getDataProvider(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"rxSeOk\u000f{[")).getData(MobConstants.ALLATORIxDEMO("gi]nX,]oS"));
        a = new HashMap<String, Integer>();
        d = new HashMap<Integer, CraftingEntry>();
        ALLATORIxDEMO = new HashMap<Integer, FamiliarEntry>();
    }

    public /* synthetic */ SkillFactory() {
        SkillFactory a2;
    }

    public static /* synthetic */ CraftingEntry getCraft(int a2) {
        if (!d.isEmpty()) {
            return d.get(a2);
        }
        return null;
    }

    public static final /* synthetic */ String getName(int a2) {
        Object object = Integer.toString(a2);
        object = StringUtil.getLeftPaddedStr((String)object, '0', 7);
        if ((object = K.getChildByPath((String)object)) != null) {
            MapleData mapleData;
            MapleData mapleData2 = null;
            try {
                mapleData = mapleData2 = object.getChildByPath(MobConstants.ALLATORIxDEMO("lUoQ"));
            }
            catch (Exception exception) {
                mapleData = mapleData2;
            }
            return MapleDataTool.getString(mapleData, "");
        }
        return "";
    }

    public static final /* synthetic */ ISkill getSkill(int a2) {
        if (g.isEmpty()) {
            return null;
        }
        if (a2 >= 92000000 && d.containsKey(a2)) {
            return d.get(a2);
        }
        return g.get(a2);
    }

    public static /* synthetic */ boolean CheckSkillByJob(int a2, int a3) {
        boolean bl;
        int n2 = 0;
        int n3 = 0;
        boolean bl2 = true;
        boolean bl3 = true;
        if (a3 >= 10000000) {
            bl2 = false;
        }
        if (a2 >= 1000) {
            bl3 = false;
        }
        if (bl2) {
            n2 = a3 / 100000;
            bl = bl3;
        } else {
            n2 = a3 / 1000000;
            bl = bl3;
        }
        n3 = bl ? a2 / 10 : a2 / 100;
        int n4 = 0;
        boolean bl4 = false;
        if (bl2 && bl3 && (n4 = a2 / 100 * 100) / 10 == n2) {
            bl4 = true;
        }
        if (a3 > 90000000) {
            return true;
        }
        return bl4 || n3 == n2 || bl3 && n2 == 0 || (n3 == 21 || n3 == 22) && n2 == 20 || (n3 == 32 || n3 == 33 || n3 == 35) && n2 == 30 || (n3 == 11 || n3 == 12 || n3 == 13 || n3 == 14 || n3 == 15) && n2 == 10;
    }

    public static /* synthetic */ Integer getDelay(String a2) {
        if (Delay.fromString(a2) != null) {
            return Delay.fromString((String)a2).i;
        }
        return a.get(a2);
    }

    public static final /* synthetic */ List<Integer> getSkillsByJob(int a2) {
        return B.get(a2);
    }

    public static /* synthetic */ FamiliarEntry getFamiliar(int a2) {
        if (!ALLATORIxDEMO.isEmpty()) {
            return ALLATORIxDEMO.get(a2);
        }
        return null;
    }

    public static class FamiliarEntry {
        public /* synthetic */ boolean knockback;
        public /* synthetic */ byte prop;
        public /* synthetic */ EnumSet<MonsterStatus> status;
        public /* synthetic */ byte targetCount;
        public /* synthetic */ Point rb;
        public /* synthetic */ byte attackCount;
        public /* synthetic */ byte time;
        public /* synthetic */ Point lt;
        public /* synthetic */ byte speed;

        public final /* synthetic */ boolean makeChanceResult() {
            FamiliarEntry a2;
            return a2.prop >= 100 || Randomizer.nextInt(100) < a2.prop;
        }

        public /* synthetic */ FamiliarEntry() {
            FamiliarEntry a2;
            a2.status = EnumSet.noneOf(MonsterStatus.class);
        }
    }

    public static class CraftingEntry
    extends Skill {
        public /* synthetic */ Map<Integer, Integer> reqItems;
        public /* synthetic */ int period;
        public /* synthetic */ byte incSkillProficiency;
        public /* synthetic */ byte reqSkillLevel;
        public /* synthetic */ boolean needOpenItem;
        public /* synthetic */ byte incFatigability;
        public /* synthetic */ List<Triple<Integer, Integer, Integer>> targetItems;

        public /* synthetic */ CraftingEntry(int a2, byte a3, byte a4, byte a5, boolean a6, int a7) {
            CraftingEntry a8;
            CraftingEntry craftingEntry = a8;
            CraftingEntry craftingEntry2 = a8;
            CraftingEntry craftingEntry3 = a8;
            super(a2);
            CraftingEntry craftingEntry4 = a8;
            craftingEntry3.targetItems = new ArrayList<Triple<Integer, Integer, Integer>>();
            craftingEntry3.reqItems = new HashMap<Integer, Integer>();
            craftingEntry3.incFatigability = a3;
            craftingEntry2.reqSkillLevel = a4;
            craftingEntry2.incSkillProficiency = a5;
            craftingEntry.needOpenItem = a6;
            craftingEntry.period = a7;
        }
    }

    public static final class Delay
    extends Enum<Delay> {
        public static final /* synthetic */ /* enum */ Delay fly;
        public static final /* synthetic */ /* enum */ Delay comboTempest;
        public static final /* synthetic */ /* enum */ Delay walk2;
        public static final /* synthetic */ /* enum */ Delay comboJudgement;
        public static final /* synthetic */ /* enum */ Delay swingPF;
        public static final /* synthetic */ /* enum */ Delay immolation;
        public static final /* synthetic */ /* enum */ Delay monsterBombPrepare;
        public static final /* synthetic */ /* enum */ Delay shoot2;
        public static final /* synthetic */ /* enum */ Delay chainAttack;
        public static final /* synthetic */ /* enum */ Delay fly2;
        public static final /* synthetic */ /* enum */ Delay straight;
        public static final /* synthetic */ /* enum */ Delay mistEruption;
        public static final /* synthetic */ /* enum */ Delay finalBlow;
        public static final /* synthetic */ /* enum */ Delay jShot;
        public static final /* synthetic */ /* enum */ Delay icebreathe_prepare;
        public static final /* synthetic */ /* enum */ Delay flamethrower_pre;
        public static final /* synthetic */ /* enum */ Delay cannonJump;
        public static final /* synthetic */ /* enum */ Delay fireCircle;
        public static final /* synthetic */ /* enum */ Delay sonicBoom;
        public static final /* synthetic */ /* enum */ Delay proneStab;
        public static final /* synthetic */ /* enum */ Delay assaulter;
        public static final /* synthetic */ /* enum */ Delay jump;
        public static final /* synthetic */ /* enum */ Delay dragonstrike;
        public static final /* synthetic */ /* enum */ Delay burster1;
        public static final /* synthetic */ /* enum */ Delay shootDb2;
        public static final /* synthetic */ /* enum */ Delay swingP2PoleArm;
        public static final /* synthetic */ /* enum */ Delay tornadoDash;
        public static final /* synthetic */ /* enum */ Delay cannonSpike;
        public static final /* synthetic */ /* enum */ Delay ghoststand;
        public static final /* synthetic */ /* enum */ Delay swingD1;
        public static final /* synthetic */ /* enum */ Delay tornadoDashStop;
        public static final /* synthetic */ /* enum */ Delay ninjastorm;
        public static final /* synthetic */ /* enum */ Delay swingP2;
        public static final /* synthetic */ /* enum */ Delay swingO1;
        public static final /* synthetic */ /* enum */ Delay magic3;
        public static final /* synthetic */ /* enum */ Delay stabT1;
        public static final /* synthetic */ /* enum */ Delay magicShield;
        public static final /* synthetic */ /* enum */ Delay OnixProtection;
        public static final /* synthetic */ /* enum */ Delay dash2;
        public static final /* synthetic */ /* enum */ Delay alert5;
        public static final /* synthetic */ /* enum */ Delay blaze;
        public static final /* synthetic */ /* enum */ Delay swallow_loop;
        public static final /* synthetic */ /* enum */ Delay arrowEruption;
        public static final /* synthetic */ /* enum */ Delay alert2;
        public static final /* synthetic */ /* enum */ Delay speedDualShot;
        public static final /* synthetic */ /* enum */ Delay maxForce1;
        public static final /* synthetic */ /* enum */ Delay flameWheel;
        public static final /* synthetic */ /* enum */ Delay finalToss;
        public static final /* synthetic */ /* enum */ Delay alert4;
        public static final /* synthetic */ /* enum */ Delay swingT3;
        public static final /* synthetic */ /* enum */ Delay octopus;
        public static final /* synthetic */ /* enum */ Delay fly2Skill;
        public static final /* synthetic */ /* enum */ Delay iceAttack1;
        public static final /* synthetic */ /* enum */ Delay tornadoRush;
        public static final /* synthetic */ /* enum */ Delay swallow_attack;
        public static final /* synthetic */ /* enum */ Delay bamboo;
        public static final /* synthetic */ /* enum */ Delay swingP1PoleArm;
        public static final /* synthetic */ /* enum */ Delay elfrush;
        public static final /* synthetic */ /* enum */ Delay tripleSwing;
        public static final /* synthetic */ /* enum */ Delay rpunch;
        public static final /* synthetic */ /* enum */ Delay doubleSwing;
        public static final /* synthetic */ /* enum */ Delay torpedo;
        public static final /* synthetic */ /* enum */ Delay swingT2PoleArm;
        public static final /* synthetic */ /* enum */ Delay elementalReset;
        public static final /* synthetic */ /* enum */ Delay clawCut;
        public static final /* synthetic */ /* enum */ Delay sit;
        public static final /* synthetic */ /* enum */ Delay stabOF;
        public static final /* synthetic */ /* enum */ Delay iceSmash;
        public static final /* synthetic */ /* enum */ Delay swingC1;
        public static final /* synthetic */ /* enum */ Delay finalCharge;
        public static final /* synthetic */ /* enum */ Delay glacialchain;
        public static final /* synthetic */ /* enum */ Delay flamegear;
        public static final /* synthetic */ /* enum */ Delay overSwingDouble;
        public static final /* synthetic */ /* enum */ Delay shot;
        public static final /* synthetic */ /* enum */ Delay windshot;
        public static final /* synthetic */ /* enum */ Delay burster2;
        public static final /* synthetic */ /* enum */ Delay windspear;
        public static final /* synthetic */ /* enum */ Delay windEffect;
        public static final /* synthetic */ /* enum */ Delay tripleStab;
        public static final /* synthetic */ /* enum */ Delay darksight;
        public static final /* synthetic */ /* enum */ Delay quadBlow;
        public static final /* synthetic */ /* enum */ Delay swingO2;
        public static final /* synthetic */ /* enum */ Delay comboSmash;
        public static final /* synthetic */ /* enum */ Delay finalCut;
        public static final /* synthetic */ /* enum */ Delay swingDb1;
        public static final /* synthetic */ /* enum */ Delay stabTF;
        public static final /* synthetic */ /* enum */ Delay stabO1;
        public static final /* synthetic */ /* enum */ Delay gatlingshot2;
        public static final /* synthetic */ /* enum */ Delay rush;
        public static final /* synthetic */ /* enum */ Delay paralyze;
        public static final /* synthetic */ /* enum */ Delay pyramid;
        public static final /* synthetic */ /* enum */ Delay gatlingshot;
        public static final /* synthetic */ /* enum */ Delay brandish2;
        public static final /* synthetic */ /* enum */ Delay slashStorm2;
        public static final /* synthetic */ /* enum */ Delay ghostLettering;
        public static final /* synthetic */ /* enum */ Delay swingTF;
        public static final /* synthetic */ /* enum */ Delay demonSlasher;
        public static final /* synthetic */ /* enum */ Delay stabD1;
        public static final /* synthetic */ /* enum */ Delay magic5;
        public static final /* synthetic */ /* enum */ Delay assassination;
        public static final /* synthetic */ /* enum */ Delay showdown;
        public static final /* synthetic */ /* enum */ Delay alert7;
        public static final /* synthetic */ /* enum */ Delay OnixWill;
        public static final /* synthetic */ /* enum */ Delay flamethrower2;
        public static final /* synthetic */ /* enum */ Delay prone;
        public static final /* synthetic */ /* enum */ Delay elfTornado;
        public static final /* synthetic */ /* enum */ Delay comboFenrir;
        public static final /* synthetic */ /* enum */ Delay darkImpale;
        public static final /* synthetic */ /* enum */ Delay darkChain;
        public static final /* synthetic */ /* enum */ Delay fly2Move;
        public static final /* synthetic */ /* enum */ Delay finishAttack;
        public static final /* synthetic */ /* enum */ Delay tank_laser;
        public static final /* synthetic */ /* enum */ Delay iceTempest;
        public static final /* synthetic */ /* enum */ Delay screw;
        public static final /* synthetic */ /* enum */ Delay iceAttack2;
        public static final /* synthetic */ /* enum */ Delay vampire;
        public static final /* synthetic */ /* enum */ Delay savage;
        public static final /* synthetic */ /* enum */ Delay magicRegistance;
        public static final /* synthetic */ /* enum */ Delay iceDoubleJump;
        public static final /* synthetic */ /* enum */ Delay darkLightning;
        public static final /* synthetic */ /* enum */ Delay chainlightning;
        public static final /* synthetic */ /* enum */ Delay elfrush2;
        public static final /* synthetic */ /* enum */ Delay mapleHero;
        public static final /* synthetic */ /* enum */ Delay swiftShot;
        public static final /* synthetic */ /* enum */ Delay noiseWave;
        public static final /* synthetic */ /* enum */ Delay magic2;
        public static final /* synthetic */ /* enum */ Delay monsterBombThrow;
        public static final /* synthetic */ /* enum */ Delay giganticBackstep;
        public static final /* synthetic */ /* enum */ Delay alert;
        public static final /* synthetic */ /* enum */ Delay swingD2;
        public static final /* synthetic */ /* enum */ Delay rush2;
        public static final /* synthetic */ /* enum */ Delay OnixBlessing;
        public static final /* synthetic */ /* enum */ Delay deathBlow;
        public static final /* synthetic */ /* enum */ Delay slashStorm1;
        public static final /* synthetic */ /* enum */ Delay dragonIceBreathe;
        public static final /* synthetic */ /* enum */ Delay stand2;
        public static final /* synthetic */ /* enum */ Delay fist;
        public static final /* synthetic */ /* enum */ Delay shoot1;
        public static final /* synthetic */ /* enum */ Delay tank;
        public static final /* synthetic */ /* enum */ Delay ghostproneStab;
        public static final /* synthetic */ /* enum */ Delay flamethrower_pre2;
        public static final /* synthetic */ /* enum */ Delay braveslash1;
        public static final /* synthetic */ /* enum */ Delay finishBlow;
        public static final /* synthetic */ /* enum */ Delay swingP1;
        public static final /* synthetic */ /* enum */ Delay drillrush;
        public static final /* synthetic */ /* enum */ Delay iceChop;
        public static final /* synthetic */ /* enum */ Delay rope;
        public static final /* synthetic */ /* enum */ Delay piercing;
        public static final /* synthetic */ /* enum */ Delay fullSwingTriple;
        public static final /* synthetic */ /* enum */ Delay homing;
        public static final /* synthetic */ /* enum */ Delay slow;
        public static final /* synthetic */ /* enum */ Delay cannonSmash;
        public static final /* synthetic */ /* enum */ Delay shotC1;
        public static final /* synthetic */ /* enum */ Delay stabT2;
        public static final /* synthetic */ /* enum */ Delay bladeFury;
        public static final /* synthetic */ /* enum */ Delay shockwave;
        public static final /* synthetic */ /* enum */ Delay bloodyStorm;
        public static final /* synthetic */ /* enum */ Delay rope2;
        public static final /* synthetic */ /* enum */ Delay rbooster;
        public static final /* synthetic */ /* enum */ Delay assassinationS;
        public static final /* synthetic */ /* enum */ Delay cyclone_pre;
        public static final /* synthetic */ /* enum */ Delay flamethrower;
        public static final /* synthetic */ /* enum */ Delay fullSwingDouble;
        public static final /* synthetic */ /* enum */ Delay knockback;
        public static final /* synthetic */ /* enum */ Delay firestrike;
        public static final /* synthetic */ /* enum */ Delay shoot6;
        public static final /* synthetic */ /* enum */ Delay prone2;
        public static final /* synthetic */ /* enum */ Delay swallow;
        public static final /* synthetic */ /* enum */ Delay maxForce2;
        public static final /* synthetic */ /* enum */ Delay ghostwalk;
        public static final /* synthetic */ /* enum */ Delay souldriver;
        public static final /* synthetic */ /* enum */ Delay illusion;
        public static final /* synthetic */ /* enum */ Delay rushBoom;
        public static final /* synthetic */ /* enum */ Delay swingT2;
        public static final /* synthetic */ /* enum */ Delay shootF;
        public static final /* synthetic */ /* enum */ Delay meteor;
        public static final /* synthetic */ /* enum */ Delay cyclone;
        public static final /* synthetic */ /* enum */ Delay maxForce0;
        public static final /* synthetic */ /* enum */ Delay rbooster_after;
        public static final /* synthetic */ /* enum */ Delay flashBang;
        public static final /* synthetic */ /* enum */ Delay timeleap;
        public static final /* synthetic */ /* enum */ Delay snatch;
        public static final /* synthetic */ /* enum */ Delay alert6;
        public static final /* synthetic */ /* enum */ Delay magic6;
        public static final /* synthetic */ /* enum */ Delay demolition;
        public static final /* synthetic */ /* enum */ Delay cannon;
        public static final /* synthetic */ /* enum */ Delay dealingRush;
        public static final /* synthetic */ /* enum */ Delay somersault;
        public static final /* synthetic */ /* enum */ Delay iceStrike;
        public static final /* synthetic */ /* enum */ Delay magicmissile;
        public static final /* synthetic */ /* enum */ Delay holyshield;
        public static final /* synthetic */ /* enum */ Delay crossPiercing;
        public static final /* synthetic */ /* enum */ Delay finishAttack_link2;
        public static final /* synthetic */ /* enum */ Delay blizzard;
        public static final /* synthetic */ /* enum */ Delay phantomBlow;
        public static final /* synthetic */ /* enum */ Delay tripleBlow;
        public static final /* synthetic */ /* enum */ Delay ghostsit;
        public static final /* synthetic */ /* enum */ Delay Earthquake;
        public static final /* synthetic */ /* enum */ Delay rbooster_pre;
        public static final /* synthetic */ /* enum */ Delay doubleupper;
        public static final /* synthetic */ /* enum */ Delay Awakening;
        public static final /* synthetic */ /* enum */ Delay ghostjump;
        public static final /* synthetic */ /* enum */ Delay dragonThrust;
        public static final /* synthetic */ /* enum */ Delay dead;
        public static final /* synthetic */ /* enum */ Delay heal;
        public static final /* synthetic */ /* enum */ Delay ladder2;
        public static final /* synthetic */ /* enum */ Delay flashRain;
        public static final /* synthetic */ /* enum */ Delay braveslash3;
        public static final /* synthetic */ /* enum */ Delay magicBooster;
        public static final /* synthetic */ /* enum */ Delay sanctuary;
        public static final /* synthetic */ /* enum */ Delay flamesplash;
        public static final /* synthetic */ /* enum */ Delay bluntSmash;
        public static final /* synthetic */ /* enum */ Delay arrowRain;
        public static final /* synthetic */ /* enum */ Delay braveSlash;
        private static final /* synthetic */ Delay[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ Delay breathe_prepare;
        public static final /* synthetic */ /* enum */ Delay overSwingTriple;
        public static final /* synthetic */ /* enum */ Delay stabO2;
        public static final /* synthetic */ /* enum */ Delay backspin;
        public static final /* synthetic */ /* enum */ Delay swingT2Giant;
        public static final /* synthetic */ /* enum */ Delay stormbreak;
        public static final /* synthetic */ /* enum */ Delay stand1;
        public static final /* synthetic */ /* enum */ Delay swingOF;
        public static final /* synthetic */ /* enum */ Delay swingC2;
        public static final /* synthetic */ /* enum */ Delay backstep;
        public static final /* synthetic */ /* enum */ Delay cannonSlam;
        public static final /* synthetic */ /* enum */ Delay finishAttack_link;
        public static final /* synthetic */ /* enum */ Delay avenger;
        public static final /* synthetic */ /* enum */ Delay eburster;
        public static final /* synthetic */ /* enum */ Delay blast;
        public static final /* synthetic */ /* enum */ Delay rapidfire;
        public static final /* synthetic */ /* enum */ Delay crossRoad;
        public static final /* synthetic */ /* enum */ Delay killingWing;
        public static final /* synthetic */ /* enum */ Delay fake;
        public static final /* synthetic */ /* enum */ Delay recoveryAura;
        public static final /* synthetic */ /* enum */ Delay lightningBolt;
        public static final /* synthetic */ /* enum */ Delay nemesis;
        public static final /* synthetic */ /* enum */ Delay rain;
        public static final /* synthetic */ /* enum */ Delay genesis;
        public static final /* synthetic */ /* enum */ Delay rollingSpin;
        public static final /* synthetic */ /* enum */ Delay upperStab;
        public static final /* synthetic */ /* enum */ Delay swingT1;
        public static final /* synthetic */ /* enum */ Delay icePanic;
        public static final /* synthetic */ /* enum */ Delay walk1;
        public static final /* synthetic */ /* enum */ Delay bombExplosion;
        public static final /* synthetic */ /* enum */ Delay dragonBreathe;
        public static final /* synthetic */ /* enum */ Delay strikeDual;
        public static final /* synthetic */ /* enum */ Delay multiSniping;
        public static final /* synthetic */ /* enum */ Delay soulStone;
        public static final /* synthetic */ /* enum */ Delay superCannon;
        public static final /* synthetic */ /* enum */ Delay airstrike;
        public static final /* synthetic */ /* enum */ Delay resurrection;
        public static final /* synthetic */ /* enum */ Delay siege_pre;
        public static final /* synthetic */ /* enum */ Delay ghostrope;
        public static final /* synthetic */ /* enum */ Delay finalCutPrepare;
        public static final /* synthetic */ /* enum */ Delay ladder;
        public /* synthetic */ int i;
        public static final /* synthetic */ /* enum */ Delay blade;
        public static final /* synthetic */ /* enum */ Delay earthslug;
        public static final /* synthetic */ /* enum */ Delay owlDead;
        public static final /* synthetic */ /* enum */ Delay fireburner;
        public static final /* synthetic */ /* enum */ Delay edrain;
        public static final /* synthetic */ /* enum */ Delay flyingAssaulter;
        public static final /* synthetic */ /* enum */ Delay braveslash4;
        public static final /* synthetic */ /* enum */ Delay coolingeffect;
        public static final /* synthetic */ /* enum */ Delay ghostladder;
        public static final /* synthetic */ /* enum */ Delay maxForce3;
        public static final /* synthetic */ /* enum */ Delay magicFlare;
        public static final /* synthetic */ /* enum */ Delay brandish1;
        public static final /* synthetic */ /* enum */ Delay fatalBlow;
        public static final /* synthetic */ /* enum */ Delay smokeshell;
        public static final /* synthetic */ /* enum */ Delay triplefire;
        public static final /* synthetic */ /* enum */ Delay swingDb2;
        public static final /* synthetic */ /* enum */ Delay doublefire;
        public static final /* synthetic */ /* enum */ Delay magic1;
        public static final /* synthetic */ /* enum */ Delay suddenRaid;
        public static final /* synthetic */ /* enum */ Delay braveslash2;
        public static final /* synthetic */ /* enum */ Delay tank_siegepre;
        public static final /* synthetic */ /* enum */ Delay swingO3;
        public static final /* synthetic */ /* enum */ Delay alert3;
        public static final /* synthetic */ /* enum */ Delay chainPull;
        public static final /* synthetic */ /* enum */ Delay dash;
        public static final /* synthetic */ /* enum */ Delay wave;
        public static final /* synthetic */ /* enum */ Delay eorb;
        public static final /* synthetic */ /* enum */ Delay explosion;
        public static final /* synthetic */ /* enum */ Delay darkFog;
        public static final /* synthetic */ /* enum */ Delay ghostfly;

        public static /* synthetic */ {
            walk1 = new Delay(MapleRing.ALLATORIxDEMO("+{0qm"), 0, 0);
            walk2 = new Delay(PartyHandler.ALLATORIxDEMO("\u00149\u000f3Q"), 1, 1);
            stand1 = new Delay("stand1", 2, 2);
            stand2 = new Delay(MapleRing.ALLATORIxDEMO("i({2~n"), 3, 3);
            alert = new Delay(PartyHandler.ALLATORIxDEMO("\u00024\u0006*\u0017"), 4, 4);
            swingO1 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;Um"), 5, 5);
            swingO2 = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\u0017Q"), 6, 6);
            swingO3 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;Uo"), 7, 7);
            swingOF = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\u0017%"), 8, 8);
            swingT1 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;Nm"), 9, 9);
            swingT2 = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\fQ"), 10, 10);
            swingT3 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;No"), 11, 11);
            swingTF = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\f%"), 12, 12);
            swingP1 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;Jm"), 13, 13);
            swingP2 = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\bQ"), 14, 14);
            swingPF = new Delay(MapleRing.ALLATORIxDEMO("/m5t;J\u001a"), 15, 15);
            stabO1 = new Delay(PartyHandler.ALLATORIxDEMO("+\u00179\u0001\u0017R"), 16, 16);
            stabO2 = new Delay(MapleRing.ALLATORIxDEMO("i({>Un"), 17, 17);
            stabOF = new Delay(PartyHandler.ALLATORIxDEMO("+\u00179\u0001\u0017%"), 18, 18);
            stabT1 = new Delay(MapleRing.ALLATORIxDEMO("i({>Nm"), 19, 19);
            stabT2 = new Delay(PartyHandler.ALLATORIxDEMO("+\u00179\u0001\fQ"), 20, 20);
            stabTF = new Delay(MapleRing.ALLATORIxDEMO("i({>N\u001a"), 21, 21);
            swingD1 = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\u001cR"), 22, 22);
            swingD2 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;^n"), 23, 23);
            stabD1 = new Delay(PartyHandler.ALLATORIxDEMO("+\u00179\u0001\u001cR"), 24, 24);
            swingDb1 = new Delay(MapleRing.ALLATORIxDEMO("i+s2}\u0018xm"), 25, 25);
            swingDb2 = new Delay(PartyHandler.ALLATORIxDEMO("+\u00141\r?':Q"), 26, 26);
            swingC1 = new Delay(MapleRing.ALLATORIxDEMO("/m5t;Ym"), 27, 27);
            swingC2 = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n6\u0004\u001bQ"), 28, 28);
            rushBoom = new Delay(MapleRing.ALLATORIxDEMO("h)i4X3u1"), 29, 28);
            tripleBlow = new Delay(PartyHandler.ALLATORIxDEMO(",\u00111\u00134\u0006\u001a\u000f7\u0014"), 30, 30);
            quadBlow = new Delay(MapleRing.ALLATORIxDEMO("k){8X0u+"), 31, 31);
            deathBlow = new Delay(PartyHandler.ALLATORIxDEMO("\u0007=\u0002,\u000b\u001a\u000f7\u0014"), 32, 32);
            finishBlow = new Delay(MapleRing.ALLATORIxDEMO("|5t5i4X0u+"), 33, 33);
            finishAttack = new Delay(PartyHandler.ALLATORIxDEMO(">\n6\n+\u000b\u0019\u0017,\u0002;\b"), 34, 34);
            finishAttack_link = new Delay(MapleRing.ALLATORIxDEMO(":s2s/r\u001dn({?q\u0003v5t7"), 35, 35);
            finishAttack_link2 = new Delay(PartyHandler.ALLATORIxDEMO(">\n6\n+\u000b\u0019\u0017,\u0002;\b\u0007\u000f1\r3Q"), 36, 36);
            shoot1 = new Delay(MapleRing.ALLATORIxDEMO("i4u3nm"), 37, 31);
            shoot2 = new Delay(PartyHandler.ALLATORIxDEMO("+\u000b7\f,Q"), 38, 32);
            shootF = new Delay(MapleRing.ALLATORIxDEMO("i4u3n\u001a"), 39, 33);
            shootDb2 = new Delay(PartyHandler.ALLATORIxDEMO("+\u000b7\f,':Q"), 40, 40);
            shotC1 = new Delay(MapleRing.ALLATORIxDEMO("i4u(Ym"), 41, 41);
            dash = new Delay(PartyHandler.ALLATORIxDEMO("<\u0002+\u000b"), 42, 37);
            dash2 = new Delay(MapleRing.ALLATORIxDEMO("8{/rn"), 43, 38);
            proneStab = new Delay(PartyHandler.ALLATORIxDEMO("\u0013*\f6\u0006\u000b\u00179\u0001"), 44, 41);
            prone = new Delay(MapleRing.ALLATORIxDEMO(",h3t9"), 45, 42);
            heal = new Delay(PartyHandler.ALLATORIxDEMO("0\u00069\u000f"), 46, 43);
            fly = new Delay(MapleRing.ALLATORIxDEMO(":v%"), 47, 44);
            jump = new Delay(PartyHandler.ALLATORIxDEMO("2\u00165\u0013"), 48, 45);
            sit = new Delay("sit", 49, 46);
            rope = new Delay(MapleRing.ALLATORIxDEMO("h3j9"), 50, 47);
            dead = new Delay(PartyHandler.ALLATORIxDEMO("<\u00069\u0007"), 51, 48);
            ladder = new Delay(MapleRing.ALLATORIxDEMO("v=~8\u007f."), 52, 49);
            rain = new Delay(PartyHandler.ALLATORIxDEMO("*\u00021\r"), 53, 50);
            alert2 = new Delay(MapleRing.ALLATORIxDEMO("{0\u007f.nn"), 54, 52);
            alert3 = new Delay(PartyHandler.ALLATORIxDEMO("9\u000f=\u0011,P"), 55, 53);
            alert4 = new Delay(MapleRing.ALLATORIxDEMO("{0\u007f.nh"), 56, 54);
            alert5 = new Delay(PartyHandler.ALLATORIxDEMO("9\u000f=\u0011,V"), 57, 55);
            alert6 = new Delay(MapleRing.ALLATORIxDEMO("{0\u007f.nj"), 58, 56);
            alert7 = new Delay(PartyHandler.ALLATORIxDEMO("9\u000f=\u0011,T"), 59, 57);
            ladder2 = new Delay(MapleRing.ALLATORIxDEMO("0{8~9hn"), 60, 58);
            rope2 = new Delay(PartyHandler.ALLATORIxDEMO("\u00117\u0013=Q"), 61, 59);
            shoot6 = new Delay(MapleRing.ALLATORIxDEMO("i4u3nj"), 62, 60);
            magic1 = new Delay(PartyHandler.ALLATORIxDEMO("5\u0002?\n;R"), 63, 61);
            magic2 = new Delay(MapleRing.ALLATORIxDEMO("w=}5yn"), 64, 62);
            magic3 = new Delay(PartyHandler.ALLATORIxDEMO("5\u0002?\n;P"), 65, 63);
            magic5 = new Delay(MapleRing.ALLATORIxDEMO("w=}5yi"), 66, 64);
            magic6 = new Delay(PartyHandler.ALLATORIxDEMO("5\u0002?\n;U"), 67, 65);
            explosion = new Delay(MapleRing.ALLATORIxDEMO("9b,v3i5u2"), 68, 78);
            burster1 = new Delay(PartyHandler.ALLATORIxDEMO(":\u0016*\u0010,\u0006*R"), 69, 66);
            burster2 = new Delay(MapleRing.ALLATORIxDEMO("x)h/n9hn"), 70, 67);
            savage = new Delay(PartyHandler.ALLATORIxDEMO("+\u0002.\u0002?\u0006"), 71, 74);
            avenger = new Delay(MapleRing.ALLATORIxDEMO("=l9t;\u007f."), 72, 76);
            assaulter = new Delay(PartyHandler.ALLATORIxDEMO("\u0002+\u00109\u00164\u0017=\u0011"), 73, 77);
            prone2 = new Delay(MapleRing.ALLATORIxDEMO("j.u2\u007fn"), 74, 71);
            assassination = new Delay(PartyHandler.ALLATORIxDEMO("\u0002+\u00109\u0010+\n6\u0002,\n7\r"), 75, 78);
            assassinationS = new Delay(MapleRing.ALLATORIxDEMO("{/i=i/s2{(s3t\u000f"), 76, 73);
            tornadoDash = new Delay(PartyHandler.ALLATORIxDEMO("\u00177\u00116\u0002<\f\u001c\u0002+\u000b"), 77, 76);
            tornadoDashStop = new Delay(MapleRing.ALLATORIxDEMO("(u.t=~3^=i4I(u,"), 78, 76);
            tornadoRush = new Delay(PartyHandler.ALLATORIxDEMO("\u00177\u00116\u0002<\f\n\u0016+\u000b"), 79, 76);
            rush = new Delay(MapleRing.ALLATORIxDEMO("h)i4"), 80, 85);
            rush2 = new Delay(PartyHandler.ALLATORIxDEMO("\u0011-\u00100Q"), 81, 86);
            brandish1 = new Delay(MapleRing.ALLATORIxDEMO(">h=t8s/rm"), 82, 86);
            brandish2 = new Delay(PartyHandler.ALLATORIxDEMO("\u0001*\u00026\u00071\u00100Q"), 83, 80);
            braveSlash = new Delay(MapleRing.ALLATORIxDEMO("x.{*\u007f\u000fv=i4"), 84, 81);
            braveslash1 = new Delay(PartyHandler.ALLATORIxDEMO("\u0001*\u0002.\u0006+\u000f9\u00100R"), 85, 81);
            braveslash2 = new Delay(MapleRing.ALLATORIxDEMO(">h=l9i0{/rn"), 86, 81);
            braveslash3 = new Delay(PartyHandler.ALLATORIxDEMO("\u0001*\u0002.\u0006+\u000f9\u00100P"), 87, 81);
            braveslash4 = new Delay(MapleRing.ALLATORIxDEMO(">h=l9i0{/rh"), 88, 81);
            darkImpale = new Delay(PartyHandler.ALLATORIxDEMO("<\u0002*\b\u0011\u000e(\u00024\u0006"), 89, 92);
            sanctuary = new Delay(MapleRing.ALLATORIxDEMO("/{2y(o=h%"), 90, 93);
            meteor = new Delay(PartyHandler.ALLATORIxDEMO("5\u0006,\u00067\u0011"), 91, 94);
            paralyze = new Delay(MapleRing.ALLATORIxDEMO("j=h=v%`9"), 92, 84);
            blizzard = new Delay(PartyHandler.ALLATORIxDEMO(":\u000f1\u0019\"\u0002*\u0007"), 93, 96);
            genesis = new Delay(MapleRing.ALLATORIxDEMO(";\u007f2\u007f/s/"), 94, 97);
            blast = new Delay(PartyHandler.ALLATORIxDEMO("\u00014\u0002+\u0017"), 95, 100);
            smokeshell = new Delay(MapleRing.ALLATORIxDEMO("i1u7\u007f/r9v0"), 96, 89);
            showdown = new Delay(PartyHandler.ALLATORIxDEMO("+\u000b7\u0014<\f/\r"), 97, 102);
            ninjastorm = new Delay(MapleRing.ALLATORIxDEMO("t5t6{/n3h1"), 98, 99);
            chainlightning = new Delay(PartyHandler.ALLATORIxDEMO(";\u000b9\n6\u000f1\u00040\u00176\n6\u0004"), 99, 104);
            holyshield = new Delay(MapleRing.ALLATORIxDEMO("r3v%i4s9v8"), 100, 93);
            resurrection = new Delay(PartyHandler.ALLATORIxDEMO("*\u0006+\u0016*\u0011=\u0000,\n7\r"), 101, 94);
            somersault = new Delay(MapleRing.ALLATORIxDEMO("i3w9h/{)v("), 102, 107);
            straight = new Delay(PartyHandler.ALLATORIxDEMO("+\u0017*\u00021\u00040\u0017"), 103, 108);
            eburster = new Delay(MapleRing.ALLATORIxDEMO("\u007f>o.i(\u007f."), 104, 109);
            backspin = new Delay(PartyHandler.ALLATORIxDEMO(":\u0002;\b+\u00131\r"), 105, 110);
            eorb = new Delay(MapleRing.ALLATORIxDEMO("\u007f3h>"), 106, 111);
            screw = new Delay(PartyHandler.ALLATORIxDEMO("\u0010;\u0011=\u0014"), 107, 112);
            doubleupper = new Delay(MapleRing.ALLATORIxDEMO("8u)x0\u007f)j,\u007f."), 108, 113);
            dragonstrike = new Delay(PartyHandler.ALLATORIxDEMO("<\u00119\u00047\r+\u0017*\n3\u0006"), 109, 114);
            doublefire = new Delay(MapleRing.ALLATORIxDEMO("~3o>v9|5h9"), 110, 115);
            triplefire = new Delay(PartyHandler.ALLATORIxDEMO(",\u00111\u00134\u0006>\n*\u0006"), 111, 116);
            fake = new Delay(MapleRing.ALLATORIxDEMO("|=q9"), 112, 117);
            airstrike = new Delay(PartyHandler.ALLATORIxDEMO("\u00021\u0011+\u0017*\n3\u0006"), 113, 118);
            edrain = new Delay(MapleRing.ALLATORIxDEMO("\u007f8h=s2"), 114, 119);
            octopus = new Delay(PartyHandler.ALLATORIxDEMO("\f;\u00177\u0013-\u0010"), 115, 120);
            backstep = new Delay(MapleRing.ALLATORIxDEMO("x=y7i(\u007f,"), 116, 121);
            shot = new Delay(PartyHandler.ALLATORIxDEMO("+\u000b7\u0017"), 117, 122);
            rapidfire = new Delay(MapleRing.ALLATORIxDEMO(".{,s8|5h9"), 118, 122);
            fireburner = new Delay(PartyHandler.ALLATORIxDEMO(">\n*\u0006:\u0016*\r=\u0011"), 119, 123);
            coolingeffect = new Delay(MapleRing.ALLATORIxDEMO("?u3v5t;\u007f:|9y("), 120, 124);
            fist = new Delay(PartyHandler.ALLATORIxDEMO(">\n+\u0017"), 121, 126);
            timeleap = new Delay(MapleRing.ALLATORIxDEMO("n5w9v9{,"), 122, 127);
            homing = new Delay(PartyHandler.ALLATORIxDEMO("0\f5\n6\u0004"), 123, 129);
            ghostwalk = new Delay(MapleRing.ALLATORIxDEMO(";r3i(m=v7"), 124, 130);
            ghoststand = new Delay(PartyHandler.ALLATORIxDEMO("?\u000b7\u0010,\u0010,\u00026\u0007"), 125, 131);
            ghostjump = new Delay(MapleRing.ALLATORIxDEMO(";r3i(p)w,"), 126, 132);
            ghostproneStab = new Delay(PartyHandler.ALLATORIxDEMO("?\u000b7\u0010,\u0013*\f6\u0006\u000b\u00179\u0001"), 127, 133);
            ghostladder = new Delay(MapleRing.ALLATORIxDEMO(";r3i(v=~8\u007f."), 128, 134);
            ghostrope = new Delay(PartyHandler.ALLATORIxDEMO("\u00040\f+\u0017*\f(\u0006"), 129, 135);
            ghostfly = new Delay(MapleRing.ALLATORIxDEMO("}4u/n:v%"), 130, 136);
            ghostsit = new Delay(PartyHandler.ALLATORIxDEMO("?\u000b7\u0010,\u00101\u0017"), 131, 137);
            cannon = new Delay(MapleRing.ALLATORIxDEMO("y=t2u2"), 132, 138);
            torpedo = new Delay(PartyHandler.ALLATORIxDEMO("\u00177\u0011(\u0006<\f"), 133, 139);
            darksight = new Delay(MapleRing.ALLATORIxDEMO("8{.q/s;r("), 134, 140);
            bamboo = new Delay(PartyHandler.ALLATORIxDEMO(":\u00025\u00017\f"), 135, 141);
            pyramid = new Delay(MapleRing.ALLATORIxDEMO(",c.{1s8"), 136, 142);
            wave = new Delay(PartyHandler.ALLATORIxDEMO("/\u0002.\u0006"), 137, 143);
            blade = new Delay(MapleRing.ALLATORIxDEMO(">v=~9"), 138, 144);
            souldriver = new Delay(PartyHandler.ALLATORIxDEMO("+\f-\u000f<\u00111\u0015=\u0011"), 139, 145);
            firestrike = new Delay(MapleRing.ALLATORIxDEMO("|5h9i(h5q9"), 140, 146);
            flamegear = new Delay(PartyHandler.ALLATORIxDEMO("\u00054\u00025\u0006?\u00069\u0011"), 141, 147);
            stormbreak = new Delay(MapleRing.ALLATORIxDEMO("i(u.w>h9{7"), 142, 148);
            vampire = new Delay(PartyHandler.ALLATORIxDEMO("\u00159\u000e(\n*\u0006"), 143, 149);
            swingT2PoleArm = new Delay(MapleRing.ALLATORIxDEMO("i+s2}\b(\fu0\u007f\u001dh1"), 144, 151);
            swingP1PoleArm = new Delay(PartyHandler.ALLATORIxDEMO("+\u00141\r?3i37\u000f=\"*\u000e"), 145, 152);
            swingP2PoleArm = new Delay(MapleRing.ALLATORIxDEMO("i+s2}\f(\fu0\u007f\u001dh1"), 146, 153);
            doubleSwing = new Delay(PartyHandler.ALLATORIxDEMO("\u00077\u0016:\u000f=0/\n6\u0004"), 147, 154);
            tripleSwing = new Delay(MapleRing.ALLATORIxDEMO("(h5j0\u007f\u000fm5t;"), 148, 155);
            fullSwingDouble = new Delay(PartyHandler.ALLATORIxDEMO("\u0005-\u000f40/\n6\u0004\u001c\f-\u00014\u0006"), 149, 156);
            fullSwingTriple = new Delay(MapleRing.ALLATORIxDEMO(":o0v\u000fm5t;N.s,v9"), 150, 157);
            overSwingDouble = new Delay(PartyHandler.ALLATORIxDEMO("\f.\u0006*0/\n6\u0004\u001c\f-\u00014\u0006"), 151, 158);
            overSwingTriple = new Delay(MapleRing.ALLATORIxDEMO("3l9h\u000fm5t;N.s,v9"), 152, 159);
            rollingSpin = new Delay(PartyHandler.ALLATORIxDEMO("\u00117\u000f4\n6\u0004\u000b\u00131\r"), 153, 160);
            comboSmash = new Delay(MapleRing.ALLATORIxDEMO("y3w>u\u000fw=i4"), 154, 161);
            comboFenrir = new Delay(PartyHandler.ALLATORIxDEMO("\u00007\u000e:\f\u001e\u00066\u00111\u0011"), 155, 162);
            comboTempest = new Delay(MapleRing.ALLATORIxDEMO("y3w>u\b\u007f1j9i("), 156, 163);
            finalCharge = new Delay(PartyHandler.ALLATORIxDEMO("\u00051\r9\u000f\u001b\u000b9\u0011?\u0006"), 157, 164);
            finalBlow = new Delay(MapleRing.ALLATORIxDEMO(":s2{0X0u+"), 158, 166);
            finalToss = new Delay(PartyHandler.ALLATORIxDEMO("\u00051\r9\u000f\f\f+\u0010"), 159, 167);
            magicmissile = new Delay(MapleRing.ALLATORIxDEMO("w=}5y1s/i5v9"), 160, 168);
            lightningBolt = new Delay(PartyHandler.ALLATORIxDEMO("\u000f1\u00040\u00176\n6\u0004\u001a\f4\u0017"), 161, 169);
            dragonBreathe = new Delay(MapleRing.ALLATORIxDEMO("8h=}3t\u001eh9{(r9"), 162, 170);
            breathe_prepare = new Delay(PartyHandler.ALLATORIxDEMO("\u0001*\u00069\u00170\u0006\u0007\u0013*\u0006(\u0002*\u0006"), 163, 171);
            dragonIceBreathe = new Delay(MapleRing.ALLATORIxDEMO("~.{;u2S?\u007f\u001eh9{(r9"), 164, 172);
            icebreathe_prepare = new Delay(PartyHandler.ALLATORIxDEMO("1\u0000=\u0001*\u00069\u00170\u0006\u0007\u0013*\u0006(\u0002*\u0006"), 165, 173);
            blaze = new Delay(MapleRing.ALLATORIxDEMO(">v=`9"), 166, 174);
            fireCircle = new Delay(PartyHandler.ALLATORIxDEMO(">\n*\u0006\u001b\n*\u00004\u0006"), 167, 175);
            illusion = new Delay(MapleRing.ALLATORIxDEMO("s0v)i5u2"), 168, 176);
            magicFlare = new Delay(PartyHandler.ALLATORIxDEMO("5\u0002?\n;%4\u0002*\u0006"), 169, 177);
            elementalReset = new Delay(MapleRing.ALLATORIxDEMO("\u007f0\u007f1\u007f2n=v\u000e\u007f/\u007f("), 170, 178);
            magicRegistance = new Delay(PartyHandler.ALLATORIxDEMO("\u000e9\u00041\u0000\n\u0006?\n+\u00179\r;\u0006"), 171, 179);
            magicBooster = new Delay(MapleRing.ALLATORIxDEMO("w=}5y\u001eu3i(\u007f."), 172, 180);
            magicShield = new Delay(PartyHandler.ALLATORIxDEMO("\u000e9\u00041\u0000\u000b\u000b1\u00064\u0007"), 173, 181);
            recoveryAura = new Delay(MapleRing.ALLATORIxDEMO("h9y3l9h%[)h="), 174, 182);
            flameWheel = new Delay(PartyHandler.ALLATORIxDEMO(">\u000f9\u000e=40\u0006=\u000f"), 175, 183);
            killingWing = new Delay(MapleRing.ALLATORIxDEMO("7s0v5t;M5t;"), 176, 184);
            OnixBlessing = new Delay(PartyHandler.ALLATORIxDEMO("\u0017\r1\u001b\u001a\u000f=\u0010+\n6\u0004"), 177, 185);
            Earthquake = new Delay(MapleRing.ALLATORIxDEMO("_=h(r-o=q9"), 178, 186);
            soulStone = new Delay(PartyHandler.ALLATORIxDEMO("\u00107\u001640,\f6\u0006"), 179, 187);
            dragonThrust = new Delay(MapleRing.ALLATORIxDEMO("~.{;u2N4h)i("), 180, 188);
            ghostLettering = new Delay(PartyHandler.ALLATORIxDEMO("?\u000b7\u0010,/=\u0017,\u0006*\n6\u0004"), 181, 189);
            darkFog = new Delay(MapleRing.ALLATORIxDEMO("8{.q\u001au;"), 182, 190);
            slow = new Delay(PartyHandler.ALLATORIxDEMO("+\u000f7\u0014"), 183, 191);
            mapleHero = new Delay(MapleRing.ALLATORIxDEMO("1{,v9R9h3"), 184, 192);
            Awakening = new Delay(PartyHandler.ALLATORIxDEMO("\"/\u00023\u00066\n6\u0004"), 185, 193);
            flyingAssaulter = new Delay(MapleRing.ALLATORIxDEMO(":v%s2}\u001di/{)v(\u007f."), 186, 194);
            tripleStab = new Delay(PartyHandler.ALLATORIxDEMO(",\u00111\u00134\u0006\u000b\u00179\u0001"), 187, 195);
            fatalBlow = new Delay(MapleRing.ALLATORIxDEMO(":{({0X0u+"), 188, 196);
            slashStorm1 = new Delay(PartyHandler.ALLATORIxDEMO("\u00104\u0002+\u000b\u000b\u00177\u00115R"), 189, 197);
            slashStorm2 = new Delay(MapleRing.ALLATORIxDEMO("/v=i4I(u.wn"), 190, 198);
            bloodyStorm = new Delay(PartyHandler.ALLATORIxDEMO("\u00014\f7\u0007!0,\f*\u000e"), 191, 199);
            flashBang = new Delay(MapleRing.ALLATORIxDEMO(":v=i4X=t;"), 192, 200);
            upperStab = new Delay(PartyHandler.ALLATORIxDEMO("\u0016(\u0013=\u0011\u000b\u00179\u0001"), 193, 201);
            bladeFury = new Delay(MapleRing.ALLATORIxDEMO(">v=~9\\)h%"), 194, 202);
            chainPull = new Delay(PartyHandler.ALLATORIxDEMO("\u00000\u00021\r\b\u00164\u000f"), 195, 204);
            chainAttack = new Delay(MapleRing.ALLATORIxDEMO("?r=s2[(n=y7"), 196, 204);
            owlDead = new Delay(PartyHandler.ALLATORIxDEMO("\f/\u000f\u001c\u00069\u0007"), 197, 205);
            monsterBombPrepare = new Delay(MapleRing.ALLATORIxDEMO("w3t/n9h\u001eu1x\fh9j=h9"), 198, 207);
            monsterBombThrow = new Delay(PartyHandler.ALLATORIxDEMO("5\f6\u0010,\u0006*!7\u000e:70\u00117\u0014"), 199, 207);
            finalCut = new Delay(MapleRing.ALLATORIxDEMO("|5t=v\u001fo("), 200, 208);
            finalCutPrepare = new Delay(PartyHandler.ALLATORIxDEMO("\u00051\r9\u000f\u001b\u0016,3*\u0006(\u0002*\u0006"), 201, 208);
            suddenRaid = new Delay(MapleRing.ALLATORIxDEMO("i)~8\u007f2H=s8"), 202, 210);
            fly2 = new Delay(PartyHandler.ALLATORIxDEMO(">\u000f!Q"), 203, 211);
            fly2Move = new Delay(MapleRing.ALLATORIxDEMO("|0cnW3l9"), 204, 212);
            fly2Skill = new Delay(PartyHandler.ALLATORIxDEMO("\u00054\u001aj03\n4\u000f"), 205, 213);
            knockback = new Delay(MapleRing.ALLATORIxDEMO("7t3y7x=y7"), 206, 214);
            rbooster_pre = new Delay(PartyHandler.ALLATORIxDEMO("*\u00017\f+\u0017=\u0011\u0007\u0013*\u0006"), 207, 218);
            rbooster = new Delay(MapleRing.ALLATORIxDEMO("h>u3i(\u007f."), 208, 218);
            rbooster_after = new Delay(PartyHandler.ALLATORIxDEMO("*\u00017\f+\u0017=\u0011\u0007\u0002>\u0017=\u0011"), 209, 218);
            crossRoad = new Delay(MapleRing.ALLATORIxDEMO("?h3i/H3{8"), 210, 221);
            nemesis = new Delay(PartyHandler.ALLATORIxDEMO("\r=\u000e=\u00101\u0010"), 211, 222);
            tank = new Delay(MapleRing.ALLATORIxDEMO("n=t7"), 212, 229);
            tank_laser = new Delay(PartyHandler.ALLATORIxDEMO(",\u00026\b\u0007\u000f9\u0010=\u0011"), 213, 233);
            siege_pre = new Delay(MapleRing.ALLATORIxDEMO("/s9}9E,h9"), 214, 234);
            tank_siegepre = new Delay(PartyHandler.ALLATORIxDEMO("\u00179\r3<+\n=\u0004=\u0013*\u0006"), 215, 234);
            sonicBoom = new Delay(MapleRing.ALLATORIxDEMO("/u2s?X3u1"), 216, 237);
            darkLightning = new Delay(PartyHandler.ALLATORIxDEMO("\u00079\u00113/1\u00040\u00176\n6\u0004"), 217, 239);
            darkChain = new Delay(MapleRing.ALLATORIxDEMO("8{.q\u001fr=s2"), 218, 240);
            cyclone_pre = new Delay(PartyHandler.ALLATORIxDEMO("\u0000!\u00004\f6\u0006\u0007\u0013*\u0006"), 219, 0);
            cyclone = new Delay(MapleRing.ALLATORIxDEMO("?c?v3t9"), 220, 0);
            glacialchain = new Delay(PartyHandler.ALLATORIxDEMO("?\u000f9\u00001\u00024\u00000\u00021\r"), 221, 241);
            flamethrower = new Delay(MapleRing.ALLATORIxDEMO("|0{1\u007f(r.u+\u007f."), 222, 245);
            flamethrower_pre = new Delay(PartyHandler.ALLATORIxDEMO(">\u000f9\u000e=\u00170\u00117\u0014=\u0011\u0007\u0013*\u0006"), 223, 245);
            flamethrower2 = new Delay(MapleRing.ALLATORIxDEMO(":v=w9n4h3m9hn"), 224, 246);
            flamethrower_pre2 = new Delay(PartyHandler.ALLATORIxDEMO("\u00054\u00025\u0006,\u000b*\f/\u0006*<(\u0011=Q"), 225, 246);
            gatlingshot = new Delay(MapleRing.ALLATORIxDEMO(";{(v5t;i4u("), 226, 254);
            gatlingshot2 = new Delay(PartyHandler.ALLATORIxDEMO("?\u0002,\u000f1\r?\u00100\f,Q"), 227, 255);
            drillrush = new Delay(MapleRing.ALLATORIxDEMO("8h5v0h)i4"), 228, 256);
            earthslug = new Delay(PartyHandler.ALLATORIxDEMO("\u00069\u0011,\u000b+\u000f-\u0004"), 229, 257);
            rpunch = new Delay(MapleRing.ALLATORIxDEMO("h,o2y4"), 230, 258);
            clawCut = new Delay(PartyHandler.ALLATORIxDEMO("\u00004\u0002/ -\u0017"), 231, 259);
            swallow = new Delay(MapleRing.ALLATORIxDEMO("/m=v0u+"), 232, 262);
            swallow_attack = new Delay(PartyHandler.ALLATORIxDEMO("+\u00149\u000f4\f/<9\u0017,\u0002;\b"), 233, 262);
            swallow_loop = new Delay(MapleRing.ALLATORIxDEMO("i+{0v3m\u0003v3u,"), 234, 262);
            flashRain = new Delay(PartyHandler.ALLATORIxDEMO("\u00054\u0002+\u000b\n\u00021\r"), 235, 264);
            OnixProtection = new Delay(MapleRing.ALLATORIxDEMO("U2s$J.u(\u007f?n5u2"), 236, 279);
            OnixWill = new Delay(PartyHandler.ALLATORIxDEMO("\u0017\r1\u001b\u000f\n4\u000f"), 237, 280);
            phantomBlow = new Delay(MapleRing.ALLATORIxDEMO(",r=t(u1X0u+"), 238, 281);
            comboJudgement = new Delay(PartyHandler.ALLATORIxDEMO(";\f5\u00017)-\u0007?\u00065\u00066\u0017"), 239, 282);
            arrowRain = new Delay(MapleRing.ALLATORIxDEMO("=h.u+H=s2"), 240, 283);
            arrowEruption = new Delay(PartyHandler.ALLATORIxDEMO("\u0002*\u00117\u0014\u001d\u0011-\u0013,\n7\r"), 241, 269);
            iceStrike = new Delay(MapleRing.ALLATORIxDEMO("5y9I(h5q9"), 242, 270);
            swingT2Giant = new Delay(PartyHandler.ALLATORIxDEMO("+\u00141\r?7j$1\u00026\u0017"), 243, 273);
            cannonJump = new Delay(MapleRing.ALLATORIxDEMO("y=t2u2P)w,"), 244, 290);
            swiftShot = new Delay(PartyHandler.ALLATORIxDEMO("\u0010/\n>\u0017\u000b\u000b7\u0017"), 245, 296);
            giganticBackstep = new Delay(MapleRing.ALLATORIxDEMO("}5}=t(s?X=y7i(\u007f,"), 246, 298);
            mistEruption = new Delay(PartyHandler.ALLATORIxDEMO("5\n+\u0017\u001d\u0011-\u0013,\n7\r"), 247, 299);
            cannonSmash = new Delay(MapleRing.ALLATORIxDEMO("?{2t3t\u000fw=i4"), 248, 300);
            cannonSlam = new Delay(PartyHandler.ALLATORIxDEMO(";\u00026\r7\r\u000b\u000f9\u000e"), 249, 301);
            flamesplash = new Delay(MapleRing.ALLATORIxDEMO(":v=w9i,v=i4"), 250, 302);
            noiseWave = new Delay(PartyHandler.ALLATORIxDEMO("\r7\n+\u0006\u000f\u0002.\u0006"), 251, 300);
            superCannon = new Delay(MapleRing.ALLATORIxDEMO("/o,\u007f.Y=t2u2"), 252, 310);
            jShot = new Delay(PartyHandler.ALLATORIxDEMO("\t\u000b\u000b7\u0017"), 253, 312);
            demonSlasher = new Delay(MapleRing.ALLATORIxDEMO("~9w3t\u000fv=i4\u007f."), 254, 329);
            bombExplosion = new Delay(PartyHandler.ALLATORIxDEMO("\u00017\u000e:& \u00134\f+\n7\r"), 255, 314);
            cannonSpike = new Delay(MapleRing.ALLATORIxDEMO("?{2t3t\u000fj5q9"), 256, 309);
            speedDualShot = new Delay(PartyHandler.ALLATORIxDEMO("\u0010(\u0006=\u0007\u001c\u00169\u000f\u000b\u000b7\u0017"), 257, 316);
            strikeDual = new Delay(MapleRing.ALLATORIxDEMO("i(h5q9^){0"), 258, 317);
            bluntSmash = new Delay(PartyHandler.ALLATORIxDEMO(":\u000f-\r,05\u0002+\u000b"), 259, 319);
            crossPiercing = new Delay(MapleRing.ALLATORIxDEMO("?h3i/J5\u007f.y5t;"), 260, 320);
            piercing = new Delay(PartyHandler.ALLATORIxDEMO("(\n=\u0011;\n6\u0004"), 261, 321);
            elfTornado = new Delay(MapleRing.ALLATORIxDEMO("\u007f0|\bu.t=~3"), 262, 323);
            immolation = new Delay(PartyHandler.ALLATORIxDEMO("1\u000e5\f4\u0002,\n7\r"), 263, 324);
            multiSniping = new Delay(MapleRing.ALLATORIxDEMO("w)v(s\u000ft5j5t;"), 264, 327);
            windEffect = new Delay(PartyHandler.ALLATORIxDEMO("/\n6\u0007\u001d\u0005>\u0006;\u0017"), 265, 328);
            elfrush = new Delay(MapleRing.ALLATORIxDEMO("9v:h)i4"), 266, 329);
            elfrush2 = new Delay(PartyHandler.ALLATORIxDEMO("=\u000f>\u0011-\u00100Q"), 267, 329);
            dealingRush = new Delay(MapleRing.ALLATORIxDEMO("8\u007f=v5t;H)i4"), 268, 334);
            maxForce0 = new Delay(PartyHandler.ALLATORIxDEMO("\u000e9\u001b\u001e\f*\u0000=S"), 269, 336);
            maxForce1 = new Delay(MapleRing.ALLATORIxDEMO("1{$\\3h?\u007fm"), 270, 337);
            maxForce2 = new Delay(PartyHandler.ALLATORIxDEMO("\u000e9\u001b\u001e\f*\u0000=Q"), 271, 338);
            maxForce3 = new Delay(MapleRing.ALLATORIxDEMO("1{$\\3h?\u007fo"), 272, 339);
            iceAttack1 = new Delay(PartyHandler.ALLATORIxDEMO("1\u0000=\",\u00179\u00003R"), 273, 274);
            iceAttack2 = new Delay(MapleRing.ALLATORIxDEMO("s?\u007f\u001dn({?qn"), 274, 275);
            iceSmash = new Delay(PartyHandler.ALLATORIxDEMO("1\u0000=05\u0002+\u000b"), 275, 276);
            iceTempest = new Delay(MapleRing.ALLATORIxDEMO("s?\u007f\b\u007f1j9i("), 276, 277);
            iceChop = new Delay(PartyHandler.ALLATORIxDEMO("\n;\u0006\u001b\u000b7\u0013"), 277, 278);
            icePanic = new Delay(MapleRing.ALLATORIxDEMO("s?\u007f\f{2s?"), 278, 279);
            iceDoubleJump = new Delay(PartyHandler.ALLATORIxDEMO("\n;\u0006\u001c\f-\u00014\u0006\u0012\u00165\u0013"), 279, 280);
            shockwave = new Delay(MapleRing.ALLATORIxDEMO("/r3y7m=l9"), 280, 386);
            demolition = new Delay(PartyHandler.ALLATORIxDEMO("<\u00065\f4\n,\n7\r"), 281, 387);
            snatch = new Delay(MapleRing.ALLATORIxDEMO("i2{(y4"), 282, 388);
            windspear = new Delay(PartyHandler.ALLATORIxDEMO("\u00141\r<\u0010(\u00069\u0011"), 283, 295);
            windshot = new Delay(MapleRing.ALLATORIxDEMO("m5t8i4u("), 284, 296);
            Delay[] arrdelay = new Delay[285];
            arrdelay[0] = walk1;
            arrdelay[1] = walk2;
            arrdelay[2] = stand1;
            arrdelay[3] = stand2;
            arrdelay[4] = alert;
            arrdelay[5] = swingO1;
            arrdelay[6] = swingO2;
            arrdelay[7] = swingO3;
            arrdelay[8] = swingOF;
            arrdelay[9] = swingT1;
            arrdelay[10] = swingT2;
            arrdelay[11] = swingT3;
            arrdelay[12] = swingTF;
            arrdelay[13] = swingP1;
            arrdelay[14] = swingP2;
            arrdelay[15] = swingPF;
            arrdelay[16] = stabO1;
            arrdelay[17] = stabO2;
            arrdelay[18] = stabOF;
            arrdelay[19] = stabT1;
            arrdelay[20] = stabT2;
            arrdelay[21] = stabTF;
            arrdelay[22] = swingD1;
            arrdelay[23] = swingD2;
            arrdelay[24] = stabD1;
            arrdelay[25] = swingDb1;
            arrdelay[26] = swingDb2;
            arrdelay[27] = swingC1;
            arrdelay[28] = swingC2;
            arrdelay[29] = rushBoom;
            arrdelay[30] = tripleBlow;
            arrdelay[31] = quadBlow;
            arrdelay[32] = deathBlow;
            arrdelay[33] = finishBlow;
            arrdelay[34] = finishAttack;
            arrdelay[35] = finishAttack_link;
            arrdelay[36] = finishAttack_link2;
            arrdelay[37] = shoot1;
            arrdelay[38] = shoot2;
            arrdelay[39] = shootF;
            arrdelay[40] = shootDb2;
            arrdelay[41] = shotC1;
            arrdelay[42] = dash;
            arrdelay[43] = dash2;
            arrdelay[44] = proneStab;
            arrdelay[45] = prone;
            arrdelay[46] = heal;
            arrdelay[47] = fly;
            arrdelay[48] = jump;
            arrdelay[49] = sit;
            arrdelay[50] = rope;
            arrdelay[51] = dead;
            arrdelay[52] = ladder;
            arrdelay[53] = rain;
            arrdelay[54] = alert2;
            arrdelay[55] = alert3;
            arrdelay[56] = alert4;
            arrdelay[57] = alert5;
            arrdelay[58] = alert6;
            arrdelay[59] = alert7;
            arrdelay[60] = ladder2;
            arrdelay[61] = rope2;
            arrdelay[62] = shoot6;
            arrdelay[63] = magic1;
            arrdelay[64] = magic2;
            arrdelay[65] = magic3;
            arrdelay[66] = magic5;
            arrdelay[67] = magic6;
            arrdelay[68] = explosion;
            arrdelay[69] = burster1;
            arrdelay[70] = burster2;
            arrdelay[71] = savage;
            arrdelay[72] = avenger;
            arrdelay[73] = assaulter;
            arrdelay[74] = prone2;
            arrdelay[75] = assassination;
            arrdelay[76] = assassinationS;
            arrdelay[77] = tornadoDash;
            arrdelay[78] = tornadoDashStop;
            arrdelay[79] = tornadoRush;
            arrdelay[80] = rush;
            arrdelay[81] = rush2;
            arrdelay[82] = brandish1;
            arrdelay[83] = brandish2;
            arrdelay[84] = braveSlash;
            arrdelay[85] = braveslash1;
            arrdelay[86] = braveslash2;
            arrdelay[87] = braveslash3;
            arrdelay[88] = braveslash4;
            arrdelay[89] = darkImpale;
            arrdelay[90] = sanctuary;
            arrdelay[91] = meteor;
            arrdelay[92] = paralyze;
            arrdelay[93] = blizzard;
            arrdelay[94] = genesis;
            arrdelay[95] = blast;
            arrdelay[96] = smokeshell;
            arrdelay[97] = showdown;
            arrdelay[98] = ninjastorm;
            arrdelay[99] = chainlightning;
            arrdelay[100] = holyshield;
            arrdelay[101] = resurrection;
            arrdelay[102] = somersault;
            arrdelay[103] = straight;
            arrdelay[104] = eburster;
            arrdelay[105] = backspin;
            arrdelay[106] = eorb;
            arrdelay[107] = screw;
            arrdelay[108] = doubleupper;
            arrdelay[109] = dragonstrike;
            arrdelay[110] = doublefire;
            arrdelay[111] = triplefire;
            arrdelay[112] = fake;
            arrdelay[113] = airstrike;
            arrdelay[114] = edrain;
            arrdelay[115] = octopus;
            arrdelay[116] = backstep;
            arrdelay[117] = shot;
            arrdelay[118] = rapidfire;
            arrdelay[119] = fireburner;
            arrdelay[120] = coolingeffect;
            arrdelay[121] = fist;
            arrdelay[122] = timeleap;
            arrdelay[123] = homing;
            arrdelay[124] = ghostwalk;
            arrdelay[125] = ghoststand;
            arrdelay[126] = ghostjump;
            arrdelay[127] = ghostproneStab;
            arrdelay[128] = ghostladder;
            arrdelay[129] = ghostrope;
            arrdelay[130] = ghostfly;
            arrdelay[131] = ghostsit;
            arrdelay[132] = cannon;
            arrdelay[133] = torpedo;
            arrdelay[134] = darksight;
            arrdelay[135] = bamboo;
            arrdelay[136] = pyramid;
            arrdelay[137] = wave;
            arrdelay[138] = blade;
            arrdelay[139] = souldriver;
            arrdelay[140] = firestrike;
            arrdelay[141] = flamegear;
            arrdelay[142] = stormbreak;
            arrdelay[143] = vampire;
            arrdelay[144] = swingT2PoleArm;
            arrdelay[145] = swingP1PoleArm;
            arrdelay[146] = swingP2PoleArm;
            arrdelay[147] = doubleSwing;
            arrdelay[148] = tripleSwing;
            arrdelay[149] = fullSwingDouble;
            arrdelay[150] = fullSwingTriple;
            arrdelay[151] = overSwingDouble;
            arrdelay[152] = overSwingTriple;
            arrdelay[153] = rollingSpin;
            arrdelay[154] = comboSmash;
            arrdelay[155] = comboFenrir;
            arrdelay[156] = comboTempest;
            arrdelay[157] = finalCharge;
            arrdelay[158] = finalBlow;
            arrdelay[159] = finalToss;
            arrdelay[160] = magicmissile;
            arrdelay[161] = lightningBolt;
            arrdelay[162] = dragonBreathe;
            arrdelay[163] = breathe_prepare;
            arrdelay[164] = dragonIceBreathe;
            arrdelay[165] = icebreathe_prepare;
            arrdelay[166] = blaze;
            arrdelay[167] = fireCircle;
            arrdelay[168] = illusion;
            arrdelay[169] = magicFlare;
            arrdelay[170] = elementalReset;
            arrdelay[171] = magicRegistance;
            arrdelay[172] = magicBooster;
            arrdelay[173] = magicShield;
            arrdelay[174] = recoveryAura;
            arrdelay[175] = flameWheel;
            arrdelay[176] = killingWing;
            arrdelay[177] = OnixBlessing;
            arrdelay[178] = Earthquake;
            arrdelay[179] = soulStone;
            arrdelay[180] = dragonThrust;
            arrdelay[181] = ghostLettering;
            arrdelay[182] = darkFog;
            arrdelay[183] = slow;
            arrdelay[184] = mapleHero;
            arrdelay[185] = Awakening;
            arrdelay[186] = flyingAssaulter;
            arrdelay[187] = tripleStab;
            arrdelay[188] = fatalBlow;
            arrdelay[189] = slashStorm1;
            arrdelay[190] = slashStorm2;
            arrdelay[191] = bloodyStorm;
            arrdelay[192] = flashBang;
            arrdelay[193] = upperStab;
            arrdelay[194] = bladeFury;
            arrdelay[195] = chainPull;
            arrdelay[196] = chainAttack;
            arrdelay[197] = owlDead;
            arrdelay[198] = monsterBombPrepare;
            arrdelay[199] = monsterBombThrow;
            arrdelay[200] = finalCut;
            arrdelay[201] = finalCutPrepare;
            arrdelay[202] = suddenRaid;
            arrdelay[203] = fly2;
            arrdelay[204] = fly2Move;
            arrdelay[205] = fly2Skill;
            arrdelay[206] = knockback;
            arrdelay[207] = rbooster_pre;
            arrdelay[208] = rbooster;
            arrdelay[209] = rbooster_after;
            arrdelay[210] = crossRoad;
            arrdelay[211] = nemesis;
            arrdelay[212] = tank;
            arrdelay[213] = tank_laser;
            arrdelay[214] = siege_pre;
            arrdelay[215] = tank_siegepre;
            arrdelay[216] = sonicBoom;
            arrdelay[217] = darkLightning;
            arrdelay[218] = darkChain;
            arrdelay[219] = cyclone_pre;
            arrdelay[220] = cyclone;
            arrdelay[221] = glacialchain;
            arrdelay[222] = flamethrower;
            arrdelay[223] = flamethrower_pre;
            arrdelay[224] = flamethrower2;
            arrdelay[225] = flamethrower_pre2;
            arrdelay[226] = gatlingshot;
            arrdelay[227] = gatlingshot2;
            arrdelay[228] = drillrush;
            arrdelay[229] = earthslug;
            arrdelay[230] = rpunch;
            arrdelay[231] = clawCut;
            arrdelay[232] = swallow;
            arrdelay[233] = swallow_attack;
            arrdelay[234] = swallow_loop;
            arrdelay[235] = flashRain;
            arrdelay[236] = OnixProtection;
            arrdelay[237] = OnixWill;
            arrdelay[238] = phantomBlow;
            arrdelay[239] = comboJudgement;
            arrdelay[240] = arrowRain;
            arrdelay[241] = arrowEruption;
            arrdelay[242] = iceStrike;
            arrdelay[243] = swingT2Giant;
            arrdelay[244] = cannonJump;
            arrdelay[245] = swiftShot;
            arrdelay[246] = giganticBackstep;
            arrdelay[247] = mistEruption;
            arrdelay[248] = cannonSmash;
            arrdelay[249] = cannonSlam;
            arrdelay[250] = flamesplash;
            arrdelay[251] = noiseWave;
            arrdelay[252] = superCannon;
            arrdelay[253] = jShot;
            arrdelay[254] = demonSlasher;
            arrdelay[255] = bombExplosion;
            arrdelay[256] = cannonSpike;
            arrdelay[257] = speedDualShot;
            arrdelay[258] = strikeDual;
            arrdelay[259] = bluntSmash;
            arrdelay[260] = crossPiercing;
            arrdelay[261] = piercing;
            arrdelay[262] = elfTornado;
            arrdelay[263] = immolation;
            arrdelay[264] = multiSniping;
            arrdelay[265] = windEffect;
            arrdelay[266] = elfrush;
            arrdelay[267] = elfrush2;
            arrdelay[268] = dealingRush;
            arrdelay[269] = maxForce0;
            arrdelay[270] = maxForce1;
            arrdelay[271] = maxForce2;
            arrdelay[272] = maxForce3;
            arrdelay[273] = iceAttack1;
            arrdelay[274] = iceAttack2;
            arrdelay[275] = iceSmash;
            arrdelay[276] = iceTempest;
            arrdelay[277] = iceChop;
            arrdelay[278] = icePanic;
            arrdelay[279] = iceDoubleJump;
            arrdelay[280] = shockwave;
            arrdelay[281] = demolition;
            arrdelay[282] = snatch;
            arrdelay[283] = windspear;
            arrdelay[284] = windshot;
            ALLATORIxDEMO = arrdelay;
        }

        public static /* synthetic */ Delay[] values() {
            return (Delay[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ Delay valueOf(String a2) {
            return Enum.valueOf(Delay.class, a2);
        }

        public static /* synthetic */ Delay fromString(String a2) {
            int n2;
            Delay[] arrdelay = Delay.values();
            int n3 = arrdelay.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                Delay delay = arrdelay[n2];
                if (delay.name().equalsIgnoreCase(a2)) {
                    return delay;
                }
                n4 = ++n2;
            }
            return null;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ Delay(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            Delay a3;
            a3.i = a2;
        }
    }
}

