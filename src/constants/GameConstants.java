/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 *  constants.ItemConstants$\u985e\u578b
 */
package constants;

import client.MapleCharacter;
import client.MapleJob;
import client.PlayerStats;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.MapleWeaponType;
import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.SkillConstants;
import handling.channel.handler.AttackInfo;
import handling.opcodes.MapleBuffStat;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import server.MapleStatEffect;
import server.Randomizer;
import server.characterCards.MapleCharacterCards;
import server.maps.MapleMapObjectType;
import tools.FileoutputUtil;

public class GameConstants {
    private static final /* synthetic */ int[] H;
    public static final /* synthetic */ int CURRENT_SET = 122800;
    public static final /* synthetic */ int DOJO = 150100;
    public static final /* synthetic */ int PENDANT_SLOT = 122700;
    private static final /* synthetic */ int[] g;
    public static final /* synthetic */ int[] normalDrops;
    public static /* synthetic */ int[] eventCommonReward;
    public static final /* synthetic */ int[] superMagicWheel;
    public static final /* synthetic */ int[] silverrewards;
    public static final /* synthetic */ List<MapleMapObjectType> rangedMapobjectTypes;
    public static /* synthetic */ int[] eventRareReward;
    public static final /* synthetic */ int[] rareDrops;
    public static final /* synthetic */ int[] rareMagicWheel;
    public static /* synthetic */ int[] tenPercent;
    public static final /* synthetic */ int QUICK_SLOT = 123000;
    public static final /* synthetic */ int[] superDrops;
    public static final /* synthetic */ int MP_ITEM = 122222;
    private static final /* synthetic */ int[] K;
    public static final /* synthetic */ int MATCH_SCORE = 122210;
    public static final /* synthetic */ int HP_ITEM = 122221;
    private static final /* synthetic */ int[] E;
    public static final /* synthetic */ int[] itemBlock;
    private static final /* synthetic */ int[] a;
    public static /* synthetic */ ArrayList<String> bansql;
    public static final /* synthetic */ int[] cashBlock;
    private static final /* synthetic */ int[] d;
    private static final /* synthetic */ int[] ALLATORIxDEMO;
    public static final /* synthetic */ int DOJO_RECORD = 150101;
    public static final /* synthetic */ int PARTY_INVITE = 122901;
    public static final /* synthetic */ int OMOK_SCORE = 122200;
    public static /* synthetic */ int[] Equipments_Bonus;
    public static /* synthetic */ int[] fishingReward;
    public static final /* synthetic */ String[] RESERVED;
    public static final /* synthetic */ int ULT_EXPLORER = 111111;
    public static final /* synthetic */ int[] blockedSkills;
    public static final /* synthetic */ int PARTY_REQUEST = 122900;
    public static final /* synthetic */ String[] stats;
    public static final /* synthetic */ int REPORT_QUEST = 123457;
    private static final /* synthetic */ int[] e;
    public static final /* synthetic */ int HARVEST_TIME = 122501;
    public static /* synthetic */ int[] eventUncommonReward;
    public static final /* synthetic */ int JAIL = 180000002;
    private static final /* synthetic */ int[] B;
    public static final /* synthetic */ int JAIL_QUEST = 123456;
    public static final /* synthetic */ int JAIL_TIME = 123455;
    public static final /* synthetic */ int ENERGY_DRINK = 122500;
    public static final /* synthetic */ int[] goldrewards;
    public static final /* synthetic */ int JAGUAR = 111112;
    private static final /* synthetic */ int[] k;
    public static final /* synthetic */ int[] normalMagicWheel;
    public static /* synthetic */ int[] eventSuperReward;
    public static /* synthetic */ int[] blockedMaps;
    public static /* synthetic */ int[] xmaxsReward;
    public static final /* synthetic */ int BOSS_PQ = 150001;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getAttackDelay(MapleCharacter a2, int a3) {
        int n2;
        short s2;
        block15: {
            block13: {
                block14: {
                    boolean bl;
                    s2 = 0;
                    IItem iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
                    if (a3 != 0) {
                        if (GameConstants.getAttackDelayBySkill(a3) != 0) {
                            s2 = GameConstants.getAttackDelayBySkill(a3);
                            if (iItem != null) {
                                block0 : switch (a3) {
                                    case 1001004: 
                                    case 11001002: {
                                        switch (iItem.getItemId()) {
                                            case 1322004: 
                                            case 1322006: 
                                            case 1332010: {
                                                s2 = 660;
                                                break block0;
                                            }
                                        }
                                        break;
                                    }
                                    case 35111004: {
                                        s2 = 40;
                                    }
                                    default: {
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        s2 = GameConstants.ALLATORIxDEMO(a2);
                    }
                    s2 = GameConstants.handleAttackDelayBuff(a2, s2);
                    boolean bl2 = GameSetConstants.MAPLE_VERSION >= 134 ? a2.getBuffedValue(MapleBuffStat.SPEED_INFUSION) != null : (bl = a2.getBuffedValue(MapleBuffStat.SPEED_INFUSION) != null);
                    if (a2.getBuffedValue(MapleBuffStat.BOOSTER) == null && !bl) break block13;
                    if (a3 == 0) break block14;
                    if (GameConstants.getAttackDelayBySkillAfterBuff(a3) == 0) break block13;
                    s2 = GameConstants.getAttackDelayBySkillAfterBuff(a3);
                    n2 = a3;
                    break block15;
                }
                if (GameConstants.H(a2) != 0) {
                    s2 = GameConstants.H(a2);
                }
            }
            n2 = a3;
        }
        if (n2 == 21101003 || a3 == 5110001) {
            s2 = 0;
        }
        if (GameSetConstants.MAPLE_VERSION < 134) return s2;
        return (short)(s2 / 2);
    }

    public static /* synthetic */ int getSkillByJob(int a2, int a3) {
        if (a2 == 8) {
            int n2 = 8;
            if (JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(a3)) {
                n2 = 10000018;
                return 10000018;
            }
            if (JobConstants.is\u72c2\u72fc\u52c7\u58eb(a3)) {
                n2 = 20000024;
                return 20000024;
            }
            if (JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a3)) {
                n2 = 20011024;
                return 20011024;
            }
            if (JobConstants.is\u7cbe\u9748\u904a\u4fe0(a3)) {
                n2 = 20020213;
                return 20020213;
            }
            if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u672b\u65e5\u53cd\u6297\u8ecd(a3)) {
                n2 = 30001024;
                return 30001024;
            }
            if (JobConstants.is\u9670\u967d\u5e2b(a3)) {
                n2 = 40021024;
                return 40021024;
            }
            if (JobConstants.is\u528d\u8c6a(a3)) {
                n2 = 40011024;
                return 40011024;
            }
            if (JobConstants.is\u7c73\u54c8\u9038(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u51f1\u6492(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a3)) {
                n2 = 80000023;
            }
            return n2;
        }
        if (a2 == 1142 && GameSetConstants.MAPLE_VERSION >= 138) {
            return 80001089;
        }
        if (a2 == 1017 && GameSetConstants.MAPLE_VERSION >= 138) {
            return 80001025;
        }
        return a2 + MapleJob.getBeginner((short)a3) * 10000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getATK(int a2, int a3) {
        switch (a2) {
            case 1122121: {
                return 3;
            }
            case 1002959: {
                return 4;
            }
            case 1142002: {
                return 9;
            }
        }
        return (short)a3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ double ALLATORIxDEMO(AttackInfo a2) {
        double d2 = 0.0;
        switch (a2.skill) {
            case 21120006: {
                return 800000.0;
            }
            case 15111007: {
                return 900000.0;
            }
            case 11111006: {
                return 500000.0;
            }
            case 2121007: 
            case 2221007: 
            case 2321008: 
            case 12111003: {
                return 750000.0;
            }
            case 2221006: 
            case 3101005: 
            case 21101003: {
                return 600000.0;
            }
            case 15111006: {
                return 800000.0;
            }
            case 12111006: {
                return 525000.0;
            }
            case 2111003: {
                return 400000.0;
            }
            case 4001344: 
            case 5221004: {
                return 400000.0;
            }
            case 1121008: 
            case 2101004: {
                return 350000.0;
            }
            case 2211002: {
                return 300000.0;
            }
            case 2001005: 
            case 2211003: 
            case 2311004: 
            case 5110001: {
                return 250000.0;
            }
            case 2321007: {
                return 200000.0;
            }
            case 1000: 
            case 20001000: {
                return 180000.0;
            }
            case 1221009: {
                return 300000.0;
            }
            case 3121004: {
                return 999999.0;
            }
            case 4331000: {
                return 450000.0;
            }
            case 27121100: 
            case 61111100: 
            case 61111113: 
            case 65001001: 
            case 65111007: {
                return 9.9999999E7;
            }
        }
        return d2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ short ALLATORIxDEMO(MapleCharacter a2) {
        IItem iItem;
        int n2;
        int n3;
        IItem iItem2;
        block29: {
            iItem2 = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
            Object object = iItem2 == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(iItem2.getItemId());
            object = ((Enum)object).name();
            int n4 = -1;
            switch (((String)object).hashCode()) {
                case 808132: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u62a7\u595b"))) break;
                    n3 = n4 = 0;
                    break block29;
                }
                case 37912123: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u96d8\u6236\u528c"))) break;
                    n3 = n4 = 1;
                    break block29;
                }
                case 21879760: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u55a2\u621f\u5281"))) break;
                    n3 = n4 = 2;
                    break block29;
                }
                case 21885456: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u55af\u6236\u68cc"))) break;
                    n3 = n4 = 3;
                    break block29;
                }
                case 1212607: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u9523\u675a"))) break;
                    n3 = n4 = 4;
                    break block29;
                }
                case 972864: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u7790\u528c"))) break;
                    n3 = n4 = 5;
                    break block29;
                }
                case 21884650: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u55a2\u621f\u65ab"))) break;
                    n3 = n4 = 6;
                    break block29;
                }
                case 978185: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u7790\u6757"))) break;
                    n3 = n4 = 7;
                    break block29;
                }
                case 30683: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u77d7"))) break;
                    n3 = n4 = 8;
                    break block29;
                }
                case 919234: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u7016\u69cc"))) break;
                    n3 = n4 = 9;
                    break block29;
                }
                case 24339: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u5f1f"))) break;
                    n3 = n4 = 10;
                    break block29;
                }
                case 37917819: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u96d8\u6236\u68cc"))) break;
                    n3 = n4 = 11;
                    break block29;
                }
                case 820263: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u6353\u8642"))) break;
                    n3 = n4 = 12;
                    break block29;
                }
                case 27085: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u69cc"))) break;
                    n3 = n4 = 13;
                    break block29;
                }
                case 24361: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u5f25"))) break;
                    n3 = n4 = 14;
                    break block29;
                }
                case 854233785: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u6cef\u6708\u6b1b\u5669"))) break;
                    n3 = n4 = 15;
                    break block29;
                }
                case 37917013: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u96d5\u621f\u65ab"))) break;
                    n4 = 16;
                }
            }
            n3 = n4;
        }
        switch (n3) {
            case 0: {
                n2 = 540;
                iItem = iItem2;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                n2 = 570;
                iItem = iItem2;
                break;
            }
            case 6: 
            case 7: {
                n2 = 630;
                iItem = iItem2;
                break;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                n2 = 660;
                iItem = iItem2;
                break;
            }
            case 16: {
                n2 = 720;
                iItem = iItem2;
                break;
            }
            default: {
                n2 = 690;
                iItem = iItem2;
            }
        }
        if (iItem == null) return (short)n2;
        switch (iItem2.getItemId()) {
            case 1492037: {
                return (short)630;
            }
        }
        return (short)n2;
    }

    public static /* synthetic */ double getAttackRange(MapleCharacter a2, MapleStatEffect a3, AttackInfo a4) {
        int n2 = a2.getStat().defRange;
        double d2 = 450.0;
        d2 = (450.0 + (double)n2) * (d2 + (double)n2);
        if (a3 != null) {
            d2 += a3.getMaxDistanceSq() + (double)(a3.getRange() * a3.getRange());
            if (GameConstants.ALLATORIxDEMO(a4) != 0.0) {
                d2 = GameConstants.ALLATORIxDEMO(a4);
            }
        } else {
            d2 = GameConstants.ALLATORIxDEMO(a2);
        }
        if (GameSetConstants.ATTACKRANGE_STAGE < 100) {
            double d3 = 100.0 / (double)GameSetConstants.ATTACKRANGE_STAGE;
            d2 *= d3;
        }
        return d2;
    }

    public static /* synthetic */ int getCurrentDate() {
        String string = FileoutputUtil.CurrentReadable_Time();
        return Integer.parseInt(string.substring(0, 4) + string.substring(5, 7) + string.substring(8, 10) + string.substring(11, 13));
    }

    public static /* synthetic */ int getMaxDamage(int a2, int a3, int a4) {
        int n2;
        int n3 = 0;
        if (a2 < 20) {
            n2 = a3;
            n3 += 900;
        } else if (a2 < 30) {
            n2 = a3;
            n3 += 1800;
        } else if (a2 < 40) {
            n2 = a3;
            n3 += 5000;
        } else if (a2 < 50) {
            n2 = a3;
            n3 += 7000;
        } else if (a2 < 60) {
            n2 = a3;
            n3 += 8000;
        } else if (a2 < 70) {
            n2 = a3;
            n3 += 9000;
        } else if (a2 < 80) {
            n2 = a3;
            n3 += 10000;
        } else if (a2 < 90) {
            n2 = a3;
            n3 += 11000;
        } else if (a2 < 100) {
            n2 = a3;
            n3 += 12000;
        } else if (a2 < 110) {
            n2 = a3;
            n3 += 13000;
        } else {
            n3 = (int)GameSetConstants.MAX_DAMAGE;
            n2 = a3;
        }
        if (GameConstants.isCygnus(n2)) {
            n3 += 1000;
        }
        switch (a4) {
            case 21110004: {
                return n3 *= 3;
            }
            case 1111005: {
                while (false) {
                }
                return n3 *= 2;
            }
            case 4211006: 
            case 21100004: {
                n3 = (int)((double)n3 * 1.5);
                return n3;
            }
        }
        return n3;
    }

    public static /* synthetic */ boolean isResist(int a2) {
        return a2 >= 3000 && a2 <= 3512;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getNumSteal(int a2) {
        switch (a2) {
            case 1: 
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getPartyPlayHP(int a2) {
        if (GameSetConstants.MAPLE_VERSION < 134) {
            return 0;
        }
        switch (a2) {
            case 4250000: {
                return 836000;
            }
            case 4250001: {
                return 924000;
            }
            case 5250000: {
                return 1100000;
            }
            case 5250001: {
                return 1276000;
            }
            case 5250002: {
                return 1452000;
            }
            case 9400661: {
                return 15000000;
            }
            case 9400660: {
                return 30000000;
            }
            case 9400659: {
                return 45000000;
            }
            case 9400658: {
                return 20000000;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getRandDisplayByWeapon(int a2, boolean a3, boolean a4, int a5) {
        LinkedList<Integer> linkedList;
        int n2 = a2 / 10000;
        n2 %= 100;
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        if (a5 != 0) {
            LinkedList<Integer> linkedList3;
            switch (a5) {
                case 4111005: {
                    LinkedList<Integer> linkedList4 = linkedList2;
                    linkedList3 = linkedList4;
                    linkedList4.add(69);
                    break;
                }
                case 4121003: {
                    LinkedList<Integer> linkedList5 = linkedList2;
                    linkedList3 = linkedList5;
                    linkedList5.add(90);
                    break;
                }
                case 4121008: {
                    LinkedList<Integer> linkedList6 = linkedList2;
                    linkedList3 = linkedList6;
                    linkedList6.add(87);
                    break;
                }
                case 4201005: {
                    LinkedList<Integer> linkedList7 = linkedList2;
                    linkedList3 = linkedList7;
                    linkedList7.add(68);
                    break;
                }
                case 4211002: {
                    LinkedList<Integer> linkedList8 = linkedList2;
                    linkedList3 = linkedList8;
                    linkedList8.add(70);
                    break;
                }
                case 4211006: {
                    LinkedList<Integer> linkedList9 = linkedList2;
                    linkedList3 = linkedList9;
                    linkedList9.add(71);
                    break;
                }
                case 4221003: {
                    LinkedList<Integer> linkedList10 = linkedList2;
                    linkedList3 = linkedList10;
                    linkedList10.add(90);
                    break;
                }
                case 4221007: {
                    LinkedList<Integer> linkedList11 = linkedList2;
                    linkedList3 = linkedList11;
                    linkedList11.add(55);
                    break;
                }
                case 4221001: {
                    LinkedList<Integer> linkedList12 = linkedList2;
                    linkedList3 = linkedList12;
                    linkedList12.add(72);
                    linkedList2.add(73);
                    break;
                }
                case 1100002: {
                    LinkedList<Integer> linkedList13 = linkedList2;
                    linkedList3 = linkedList13;
                    linkedList13.add(8);
                    linkedList2.add(18);
                    break;
                }
                case 1200002: {
                    LinkedList<Integer> linkedList14 = linkedList2;
                    linkedList3 = linkedList14;
                    linkedList14.add(8);
                    linkedList2.add(18);
                    linkedList2.add(12);
                    break;
                }
                case 1111010: {
                    LinkedList<Integer> linkedList15 = linkedList2;
                    linkedList3 = linkedList15;
                    linkedList15.add(79);
                    break;
                }
                case 1111008: {
                    LinkedList<Integer> linkedList16 = linkedList2;
                    linkedList3 = linkedList16;
                    linkedList16.add(53);
                    break;
                }
                case 1121008: {
                    LinkedList<Integer> linkedList17 = linkedList2;
                    linkedList3 = linkedList17;
                    linkedList17.add(81);
                    break;
                }
                case 1300002: {
                    LinkedList<Integer> linkedList18 = linkedList2;
                    linkedList3 = linkedList18;
                    linkedList18.add(15);
                    break;
                }
                case 1311001: {
                    LinkedList<Integer> linkedList19 = linkedList2;
                    linkedList3 = linkedList19;
                    linkedList19.add(67);
                    break;
                }
                case 1311006: {
                    LinkedList<Integer> linkedList20 = linkedList2;
                    linkedList3 = linkedList20;
                    linkedList20.add(53);
                    break;
                }
                case 1321003: {
                    LinkedList<Integer> linkedList21 = linkedList2;
                    linkedList3 = linkedList21;
                    linkedList21.add(77);
                    break;
                }
                case 1221011: {
                    LinkedList<Integer> linkedList22 = linkedList2;
                    linkedList3 = linkedList22;
                    linkedList22.add(82);
                    break;
                }
                case 1221009: {
                    LinkedList<Integer> linkedList23 = linkedList2;
                    linkedList3 = linkedList23;
                    linkedList23.add(88);
                    break;
                }
                case 1221007: {
                    LinkedList<Integer> linkedList24 = linkedList2;
                    linkedList3 = linkedList24;
                    linkedList24.add(78);
                    break;
                }
                case 2101004: {
                    LinkedList<Integer> linkedList25 = linkedList2;
                    linkedList3 = linkedList25;
                    linkedList25.add(31);
                    break;
                }
                case 2101005: {
                    LinkedList<Integer> linkedList26 = linkedList2;
                    linkedList3 = linkedList26;
                    linkedList26.add(7);
                    break;
                }
                case 2111002: {
                    LinkedList<Integer> linkedList27 = linkedList2;
                    linkedList3 = linkedList27;
                    linkedList27.add(65);
                    break;
                }
                case 2111003: {
                    LinkedList<Integer> linkedList28 = linkedList2;
                    linkedList3 = linkedList28;
                    linkedList28.add(53);
                    break;
                }
                case 2111006: {
                    LinkedList<Integer> linkedList29 = linkedList2;
                    linkedList3 = linkedList29;
                    linkedList29.add(60);
                    break;
                }
                case 2111007: {
                    LinkedList<Integer> linkedList30 = linkedList2;
                    linkedList3 = linkedList30;
                    linkedList30.add(0);
                    break;
                }
                case 2121006: {
                    LinkedList<Integer> linkedList31 = linkedList2;
                    linkedList3 = linkedList31;
                    linkedList31.add(84);
                    break;
                }
                case 2121007: {
                    LinkedList<Integer> linkedList32 = linkedList2;
                    linkedList3 = linkedList32;
                    linkedList32.add(83);
                    break;
                }
                case 2211002: {
                    LinkedList<Integer> linkedList33 = linkedList2;
                    linkedList3 = linkedList33;
                    linkedList33.add(14);
                    break;
                }
                case 2211003: {
                    LinkedList<Integer> linkedList34 = linkedList2;
                    linkedList3 = linkedList34;
                    linkedList34.add(61);
                    break;
                }
                case 2211006: {
                    LinkedList<Integer> linkedList35 = linkedList2;
                    linkedList3 = linkedList35;
                    linkedList35.add(60);
                    break;
                }
                case 2221007: {
                    LinkedList<Integer> linkedList36 = linkedList2;
                    linkedList3 = linkedList36;
                    linkedList36.add(85);
                    break;
                }
                case 2221006: {
                    LinkedList<Integer> linkedList37 = linkedList2;
                    linkedList3 = linkedList37;
                    linkedList37.add(92);
                    break;
                }
                case 2301005: {
                    LinkedList<Integer> linkedList38 = linkedList2;
                    linkedList3 = linkedList38;
                    linkedList38.add(31);
                    break;
                }
                case 2311004: {
                    LinkedList<Integer> linkedList39 = linkedList2;
                    linkedList3 = linkedList39;
                    linkedList39.add(62);
                    break;
                }
                case 2321007: {
                    LinkedList<Integer> linkedList40 = linkedList2;
                    linkedList3 = linkedList40;
                    linkedList40.add(31);
                    break;
                }
                case 2321008: {
                    LinkedList<Integer> linkedList41 = linkedList2;
                    linkedList3 = linkedList41;
                    linkedList41.add(86);
                    break;
                }
                case 3101003: {
                    LinkedList<Integer> linkedList42 = linkedList2;
                    linkedList3 = linkedList42;
                    linkedList42.add(11);
                    break;
                }
                case 3100001: {
                    LinkedList<Integer> linkedList43 = linkedList2;
                    linkedList3 = linkedList43;
                    linkedList43.add(36);
                    break;
                }
                case 3101005: {
                    LinkedList<Integer> linkedList44 = linkedList2;
                    linkedList3 = linkedList44;
                    linkedList44.add(31);
                    break;
                }
                case 3111004: {
                    LinkedList<Integer> linkedList45 = linkedList2;
                    linkedList3 = linkedList45;
                    linkedList45.add(12);
                    break;
                }
                case 3201003: {
                    LinkedList<Integer> linkedList46 = linkedList2;
                    linkedList3 = linkedList46;
                    linkedList46.add(9);
                    break;
                }
                case 3211004: {
                    LinkedList<Integer> linkedList47 = linkedList2;
                    linkedList3 = linkedList47;
                    linkedList47.add(13);
                    break;
                }
                case 4311002: {
                    LinkedList<Integer> linkedList48 = linkedList2;
                    linkedList3 = linkedList48;
                    linkedList48.add(-72);
                    break;
                }
                case 4311003: {
                    LinkedList<Integer> linkedList49 = linkedList2;
                    linkedList3 = linkedList49;
                    linkedList49.add(-70);
                    break;
                }
                case 4321004: {
                    LinkedList<Integer> linkedList50 = linkedList2;
                    linkedList3 = linkedList50;
                    linkedList50.add(-67);
                    break;
                }
                case 4331003: {
                    LinkedList<Integer> linkedList51 = linkedList2;
                    linkedList3 = linkedList51;
                    linkedList51.add(-63);
                    break;
                }
                case 4331005: {
                    LinkedList<Integer> linkedList52 = linkedList2;
                    linkedList3 = linkedList52;
                    linkedList52.add(-74);
                    break;
                }
                case 4331006: {
                    LinkedList<Integer> linkedList53 = linkedList2;
                    linkedList3 = linkedList53;
                    linkedList53.add(-64);
                    break;
                }
                case 4341009: {
                    LinkedList<Integer> linkedList54 = linkedList2;
                    linkedList3 = linkedList54;
                    linkedList54.add(10);
                    break;
                }
                case 4331000: {
                    LinkedList<Integer> linkedList55 = linkedList2;
                    linkedList3 = linkedList55;
                    linkedList55.add(-69);
                    break;
                }
                case 4341004: {
                    LinkedList<Integer> linkedList56 = linkedList2;
                    linkedList3 = linkedList56;
                    linkedList56.add(-66);
                    break;
                }
                case 4341002: {
                    LinkedList<Integer> linkedList57 = linkedList2;
                    linkedList3 = linkedList57;
                    linkedList57.add(-60);
                    break;
                }
                case 5001002: {
                    LinkedList<Integer> linkedList58 = linkedList2;
                    linkedList3 = linkedList58;
                    linkedList58.add(95);
                    linkedList2.add(98);
                    break;
                }
                case 5101003: {
                    LinkedList<Integer> linkedList59 = linkedList2;
                    linkedList3 = linkedList59;
                    linkedList59.add(101);
                    break;
                }
                case 5101004: {
                    LinkedList<Integer> linkedList60 = linkedList2;
                    linkedList3 = linkedList60;
                    linkedList60.add(100);
                    break;
                }
                case 5111006: {
                    LinkedList<Integer> linkedList61 = linkedList2;
                    linkedList3 = linkedList61;
                    linkedList61.add(36);
                    break;
                }
                case 5111002: {
                    LinkedList<Integer> linkedList62 = linkedList2;
                    linkedList3 = linkedList62;
                    linkedList62.add(97);
                    break;
                }
                case 5121007: {
                    LinkedList<Integer> linkedList63 = linkedList2;
                    linkedList3 = linkedList63;
                    linkedList63.add(114);
                    break;
                }
                case 5121005: {
                    LinkedList<Integer> linkedList64 = linkedList2;
                    linkedList3 = linkedList64;
                    linkedList64.add(38);
                    break;
                }
                case 5121001: {
                    LinkedList<Integer> linkedList65 = linkedList2;
                    linkedList3 = linkedList65;
                    linkedList65.add(102);
                    break;
                }
                case 5121002: {
                    LinkedList<Integer> linkedList66 = linkedList2;
                    linkedList3 = linkedList66;
                    linkedList66.add(99);
                    break;
                }
                case 5110001: {
                    LinkedList<Integer> linkedList67 = linkedList2;
                    linkedList3 = linkedList67;
                    linkedList67.add(0);
                    break;
                }
                case 21120009: {
                    LinkedList<Integer> linkedList68 = linkedList2;
                    linkedList3 = linkedList68;
                    linkedList68.add(-110);
                    break;
                }
                case 21120010: {
                    LinkedList<Integer> linkedList69 = linkedList2;
                    linkedList3 = linkedList69;
                    linkedList69.add(-109);
                    break;
                }
                case 21110011: {
                    LinkedList<Integer> linkedList70 = linkedList2;
                    linkedList3 = linkedList70;
                    linkedList70.add(11);
                    break;
                }
                case 21120006: {
                    LinkedList<Integer> linkedList71 = linkedList2;
                    linkedList3 = linkedList71;
                    linkedList71.add(-105);
                    break;
                }
                case 21100002: {
                    LinkedList<Integer> linkedList72 = linkedList2;
                    linkedList3 = linkedList72;
                    linkedList72.add(-104);
                    break;
                }
                case 21110003: {
                    LinkedList<Integer> linkedList73 = linkedList2;
                    linkedList3 = linkedList73;
                    linkedList73.add(-101);
                    break;
                }
                case 21101003: {
                    LinkedList<Integer> linkedList74 = linkedList2;
                    linkedList3 = linkedList74;
                    linkedList74.add(0);
                    break;
                }
                case 21100007: {
                    LinkedList<Integer> linkedList75 = linkedList2;
                    linkedList3 = linkedList75;
                    linkedList75.add(-106);
                    break;
                }
                case 21000004: {
                    LinkedList<Integer> linkedList76 = linkedList2;
                    linkedList3 = linkedList76;
                    linkedList76.add(-107);
                    break;
                }
                case 22001001: {
                    LinkedList<Integer> linkedList77 = linkedList2;
                    linkedList3 = linkedList77;
                    linkedList77.add(-100);
                    break;
                }
                case 22101000: {
                    LinkedList<Integer> linkedList78 = linkedList2;
                    linkedList3 = linkedList78;
                    linkedList78.add(-93);
                    break;
                }
                case 22150004: {
                    LinkedList<Integer> linkedList79 = linkedList2;
                    linkedList3 = linkedList79;
                    linkedList79.add(37);
                    linkedList2.add(38);
                    break;
                }
                case 22111000: {
                    LinkedList<Integer> linkedList80 = linkedList2;
                    linkedList3 = linkedList80;
                    linkedList80.add(-99);
                    break;
                }
                case 22121000: {
                    LinkedList<Integer> linkedList81 = linkedList2;
                    linkedList3 = linkedList81;
                    linkedList81.add(-96);
                    break;
                }
                case 22131000: {
                    LinkedList<Integer> linkedList82 = linkedList2;
                    linkedList3 = linkedList82;
                    linkedList82.add(-91);
                    break;
                }
                case 22141001: {
                    LinkedList<Integer> linkedList83 = linkedList2;
                    linkedList3 = linkedList83;
                    linkedList83.add(-80);
                    break;
                }
                case 22151002: {
                    LinkedList<Integer> linkedList84 = linkedList2;
                    linkedList3 = linkedList84;
                    linkedList84.add(-84);
                    break;
                }
                case 22151001: {
                    LinkedList<Integer> linkedList85 = linkedList2;
                    linkedList3 = linkedList85;
                    linkedList85.add(-98);
                    break;
                }
                case 22161002: {
                    LinkedList<Integer> linkedList86 = linkedList2;
                    linkedList3 = linkedList86;
                    linkedList86.add(-79);
                    break;
                }
                case 22171002: {
                    LinkedList<Integer> linkedList87 = linkedList2;
                    linkedList3 = linkedList87;
                    linkedList87.add(-92);
                    break;
                }
                case 22171003: {
                    LinkedList<Integer> linkedList88 = linkedList2;
                    linkedList3 = linkedList88;
                    linkedList88.add(-85);
                    break;
                }
                case 22181002: {
                    LinkedList<Integer> linkedList89 = linkedList2;
                    linkedList3 = linkedList89;
                    linkedList89.add(-78);
                    break;
                }
                case 2301002: {
                    LinkedList<Integer> linkedList90 = linkedList2;
                    linkedList3 = linkedList90;
                    linkedList90.add(52);
                    break;
                }
                case 32001000: {
                    LinkedList<Integer> linkedList91 = linkedList2;
                    linkedList3 = linkedList91;
                    linkedList91.add(25);
                    break;
                }
                case 32001008: {
                    LinkedList<Integer> linkedList92 = linkedList2;
                    linkedList3 = linkedList92;
                    linkedList92.add(29);
                    break;
                }
                case 32101001: {
                    LinkedList<Integer> linkedList93 = linkedList2;
                    linkedList3 = linkedList93;
                    linkedList93.add(-27);
                    break;
                }
                case 32101000: {
                    LinkedList<Integer> linkedList94 = linkedList2;
                    linkedList3 = linkedList94;
                    linkedList94.add(26);
                    break;
                }
                case 32111002: {
                    LinkedList<Integer> linkedList95 = linkedList2;
                    linkedList3 = linkedList95;
                    linkedList95.add(27);
                    break;
                }
                case 32111003: {
                    LinkedList<Integer> linkedList96 = linkedList2;
                    linkedList3 = linkedList96;
                    linkedList96.add(-28);
                    break;
                }
                case 32111011: {
                    LinkedList<Integer> linkedList97 = linkedList2;
                    linkedList3 = linkedList97;
                    linkedList97.add(-27);
                    break;
                }
                case 32121004: {
                    LinkedList<Integer> linkedList98 = linkedList2;
                    linkedList3 = linkedList98;
                    linkedList98.add(-46);
                    break;
                }
                case 32121002: {
                    LinkedList<Integer> linkedList99 = linkedList2;
                    linkedList3 = linkedList99;
                    linkedList99.add(28);
                    break;
                }
                case 33101002: {
                    LinkedList<Integer> linkedList100 = linkedList2;
                    linkedList3 = linkedList100;
                    linkedList100.add(-54);
                    break;
                }
                case 33111006: {
                    LinkedList<Integer> linkedList101 = linkedList2;
                    linkedList3 = linkedList101;
                    linkedList101.add(-12);
                    break;
                }
                case 33121002: {
                    LinkedList<Integer> linkedList102 = linkedList2;
                    linkedList3 = linkedList102;
                    linkedList102.add(-30);
                    break;
                }
                case 33121001: {
                    LinkedList<Integer> linkedList103 = linkedList2;
                    linkedList3 = linkedList103;
                    linkedList103.add(-7);
                    break;
                }
                case 12001003: {
                    LinkedList<Integer> linkedList104 = linkedList2;
                    linkedList3 = linkedList104;
                    linkedList104.add(37);
                    break;
                }
                case 12101002: {
                    LinkedList<Integer> linkedList105 = linkedList2;
                    linkedList3 = linkedList105;
                    linkedList105.add(31);
                    break;
                }
                case 12111003: {
                    LinkedList<Integer> linkedList106 = linkedList2;
                    linkedList3 = linkedList106;
                    linkedList106.add(83);
                    break;
                }
                case 12111006: {
                    LinkedList<Integer> linkedList107 = linkedList2;
                    linkedList3 = linkedList107;
                    linkedList107.add(-122);
                    break;
                }
                case 12101006: {
                    LinkedList<Integer> linkedList108 = linkedList2;
                    linkedList3 = linkedList108;
                    linkedList108.add(64);
                    break;
                }
                case 14101006: {
                    LinkedList<Integer> linkedList109 = linkedList2;
                    linkedList3 = linkedList109;
                    linkedList109.add(-119);
                    break;
                }
                case 14111006: {
                    LinkedList<Integer> linkedList110 = linkedList2;
                    linkedList3 = linkedList110;
                    linkedList110.add(16);
                    break;
                }
                case 14111002: {
                    LinkedList<Integer> linkedList111 = linkedList2;
                    linkedList3 = linkedList111;
                    linkedList111.add(69);
                    break;
                }
                case 11101004: {
                    LinkedList<Integer> linkedList112 = linkedList2;
                    linkedList3 = linkedList112;
                    linkedList112.add(-124);
                    break;
                }
                case 11111004: {
                    LinkedList<Integer> linkedList113 = linkedList2;
                    linkedList3 = linkedList113;
                    linkedList113.add(79);
                    break;
                }
                case 11111006: {
                    LinkedList<Integer> linkedList114 = linkedList2;
                    linkedList3 = linkedList114;
                    linkedList114.add(-123);
                    break;
                }
                case 15001001: {
                    LinkedList<Integer> linkedList115 = linkedList2;
                    linkedList3 = linkedList115;
                    linkedList115.add(96);
                    break;
                }
                case 15001002: {
                    LinkedList<Integer> linkedList116 = linkedList2;
                    linkedList3 = linkedList116;
                    linkedList116.add(95);
                    break;
                }
                case 15101003: {
                    LinkedList<Integer> linkedList117 = linkedList2;
                    linkedList3 = linkedList117;
                    linkedList117.add(100);
                    break;
                }
                case 15111003: {
                    LinkedList<Integer> linkedList118 = linkedList2;
                    linkedList3 = linkedList118;
                    linkedList118.add(36);
                    break;
                }
                case 15111007: {
                    LinkedList<Integer> linkedList119 = linkedList2;
                    linkedList3 = linkedList119;
                    linkedList119.add(-125);
                    break;
                }
                case 15100004: {
                    LinkedList<Integer> linkedList120 = linkedList2;
                    linkedList3 = linkedList120;
                    linkedList120.add(0);
                    break;
                }
                case 15111006: {
                    LinkedList<Integer> linkedList121 = linkedList2;
                    linkedList3 = linkedList121;
                    linkedList121.add(55);
                    break;
                }
                case 15101005: {
                    LinkedList<Integer> linkedList122 = linkedList2;
                    linkedList3 = linkedList122;
                    linkedList122.add(97);
                    break;
                }
                case 13101005: {
                    LinkedList<Integer> linkedList123 = linkedList2;
                    linkedList3 = linkedList123;
                    linkedList123.add(-120);
                    break;
                }
                case 13111000: {
                    LinkedList<Integer> linkedList124 = linkedList2;
                    linkedList3 = linkedList124;
                    linkedList124.add(12);
                    break;
                }
                case 13111002: {
                    LinkedList<Integer> linkedList125 = linkedList2;
                    linkedList3 = linkedList125;
                    linkedList125.add(31);
                    break;
                }
                case 13111006: {
                    LinkedList<Integer> linkedList126 = linkedList2;
                    linkedList3 = linkedList126;
                    linkedList126.add(39);
                    break;
                }
                case 13111007: {
                    LinkedList<Integer> linkedList127 = linkedList2;
                    linkedList3 = linkedList127;
                    linkedList127.add(40);
                    break;
                }
                case 22161001: {
                    LinkedList<Integer> linkedList128 = linkedList2;
                    linkedList3 = linkedList128;
                    linkedList128.add(-82);
                    break;
                }
                case 22181001: {
                    LinkedList<Integer> linkedList129 = linkedList2;
                    linkedList3 = linkedList129;
                    linkedList129.add(-94);
                    break;
                }
                case 5210000: {
                    LinkedList<Integer> linkedList130 = linkedList2;
                    linkedList3 = linkedList130;
                    linkedList130.add(104);
                    break;
                }
                case 5201001: {
                    LinkedList<Integer> linkedList131 = linkedList2;
                    linkedList3 = linkedList131;
                    linkedList131.add(110);
                    break;
                }
                case 5201004: {
                    LinkedList<Integer> linkedList132 = linkedList2;
                    linkedList3 = linkedList132;
                    linkedList132.add(105);
                    break;
                }
                case 5201002: {
                    LinkedList<Integer> linkedList133 = linkedList2;
                    linkedList3 = linkedList133;
                    linkedList133.add(10);
                    break;
                }
                case 5201006: {
                    LinkedList<Integer> linkedList134 = linkedList2;
                    linkedList3 = linkedList134;
                    linkedList134.add(109);
                    break;
                }
                case 5211004: {
                    LinkedList<Integer> linkedList135 = linkedList2;
                    linkedList3 = linkedList135;
                    linkedList135.add(112);
                    break;
                }
                case 5211005: {
                    LinkedList<Integer> linkedList136 = linkedList2;
                    linkedList3 = linkedList136;
                    linkedList136.add(113);
                    break;
                }
                case 5220011: {
                    LinkedList<Integer> linkedList137 = linkedList2;
                    linkedList3 = linkedList137;
                    linkedList137.add(117);
                    break;
                }
                case 5221004: {
                    LinkedList<Integer> linkedList138 = linkedList2;
                    linkedList3 = linkedList138;
                    linkedList138.add(110);
                    break;
                }
                case 5221007: {
                    LinkedList<Integer> linkedList139 = linkedList2;
                    linkedList3 = linkedList139;
                    linkedList139.add(126);
                    break;
                }
                case 5221008: {
                    LinkedList<Integer> linkedList140 = linkedList2;
                    linkedList3 = linkedList140;
                    linkedList140.add(127);
                    break;
                }
                case 5121004: {
                    LinkedList<Integer> linkedList141 = linkedList2;
                    linkedList3 = linkedList141;
                    linkedList141.add(37);
                    break;
                }
                case 35101003: {
                    LinkedList<Integer> linkedList142 = linkedList2;
                    linkedList3 = linkedList142;
                    linkedList142.add(-14);
                    break;
                }
                case 35001003: {
                    LinkedList<Integer> linkedList143 = linkedList2;
                    linkedList3 = linkedList143;
                    linkedList143.add(-15);
                    break;
                }
                case 35101010: {
                    LinkedList<Integer> linkedList144 = linkedList2;
                    linkedList3 = linkedList144;
                    linkedList144.add(-16);
                    break;
                }
                case 35101009: {
                    LinkedList<Integer> linkedList145 = linkedList2;
                    linkedList3 = linkedList145;
                    linkedList145.add(-22);
                    break;
                }
                case 35111004: {
                    LinkedList<Integer> linkedList146 = linkedList2;
                    linkedList3 = linkedList146;
                    linkedList146.add(-43);
                    break;
                }
                case 35121003: {
                    LinkedList<Integer> linkedList147 = linkedList2;
                    linkedList3 = linkedList147;
                    linkedList147.add(0);
                    break;
                }
                case 35121012: {
                    LinkedList<Integer> linkedList148 = linkedList2;
                    linkedList3 = linkedList148;
                    linkedList148.add(-35);
                    break;
                }
                case 35111015: {
                    linkedList2.add(-13);
                }
                default: {
                    linkedList3 = linkedList2;
                }
            }
            if (linkedList3.isEmpty() && SkillConstants.isMagicAttack(a5)) {
                linkedList2.add(37);
                linkedList2.add(38);
            }
        }
        if (linkedList2.isEmpty()) {
            boolean bl;
            switch (n2) {
                case 30: 
                case 31: 
                case 32: 
                case 33: {
                    linkedList2.add(5);
                    linkedList2.add(6);
                    linkedList2.add(7);
                    linkedList2.add(16);
                    linkedList2.add(17);
                    bl = a3;
                    break;
                }
                case 37: 
                case 38: {
                    linkedList2.add(6);
                    bl = a3;
                    break;
                }
                case 40: 
                case 41: 
                case 42: {
                    linkedList2.add(9);
                    linkedList2.add(10);
                    linkedList2.add(11);
                    linkedList2.add(16);
                    linkedList2.add(17);
                    bl = a3;
                    break;
                }
                case 43: 
                case 44: {
                    linkedList2.add(10);
                    linkedList2.add(13);
                    linkedList2.add(14);
                    linkedList2.add(19);
                    linkedList2.add(20);
                    bl = a3;
                    break;
                }
                case 45: {
                    linkedList2.add(31);
                    bl = a3;
                    break;
                }
                case 46: {
                    linkedList2.add(32);
                    bl = a3;
                    break;
                }
                case 47: {
                    linkedList2.add(33);
                    linkedList2.add(34);
                    linkedList2.add(35);
                    bl = a3;
                    break;
                }
                case 48: {
                    linkedList2.add(16);
                    linkedList2.add(17);
                    bl = a3;
                    break;
                }
                case 49: {
                    linkedList2.add(110);
                }
                default: {
                    bl = a3;
                }
            }
            if (bl) {
                LinkedList<Integer> linkedList149 = linkedList2;
                linkedList = linkedList149;
                linkedList149.clear();
                linkedList149.add(22);
                linkedList2.add(23);
                linkedList2.add(24);
                return (Integer)linkedList.get(Randomizer.rand(0, linkedList2.size() - 1));
            }
            if (a4) {
                LinkedList<Integer> linkedList150 = linkedList2;
                linkedList150.clear();
                linkedList150.add(-115);
                linkedList2.add(-116);
                linkedList2.add(-117);
            }
        }
        linkedList = linkedList2;
        return (Integer)linkedList.get(Randomizer.rand(0, linkedList2.size() - 1));
    }

    public static /* synthetic */ boolean isGeneralScroll(int a2) {
        return a2 / 1000 == 2046;
    }

    public static /* synthetic */ boolean isCustomQuest(int a2) {
        return a2 > 99999;
    }

    public static /* synthetic */ int getBOF_ForJob(int a2) {
        return GameConstants.getSkillByJob(12, a2);
    }

    public static /* synthetic */ int getChaosNumber(int a2) {
        if (a2 == 2049009) {
            return 7;
        }
        if (a2 == 2049116 && GameSetConstants.SERVER_NAME.equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u5e79\u79f2\u8c36"))) {
            return 7;
        }
        if (a2 == 2049119 && GameSetConstants.SERVER_NAME.equals(MapleCharacterCards.ALLATORIxDEMO("\u7c85\u7d51\u8c3b"))) {
            return 10;
        }
        if (GameSetConstants.SERVER_NAME.equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u65cd\u8703\u4e36\u8c36"))) {
            if (a2 == 2049116 || a2 == 2049113) {
                return 10;
            }
            return 4;
        }
        if (a2 == 2049116 || a2 == 2049113) {
            return 10;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            return 5;
        }
        return 4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isSpaceItem(int a2) {
        switch (a2) {
            case 5350003: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getCustomSpawnID(int a2, int a3) {
        switch (a2) {
            case 9400589: 
            case 9400748: {
                return 9400706;
            }
        }
        return a3;
    }

    private static /* synthetic */ double ALLATORIxDEMO(MapleCharacter a2) {
        IItem iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
        MapleWeaponType mapleWeaponType = iItem == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(iItem.getItemId());
        switch (1.d[mapleWeaponType.ordinal()]) {
            case 8: {
                return 200000.0;
            }
            case 6: {
                return 250000.0;
            }
            case 2: 
            case 5: 
            case 7: {
                while (false) {
                }
                return 220000.0;
            }
            case 9: {
                return 180000.0;
            }
        }
        return 100000.0;
    }

    public static /* synthetic */ boolean isGem(int a2) {
        return a2 >= 4250000 && a2 <= 4251402;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean potentialIDFits(int a2, int a3, int a4) {
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            switch (a3) {
                case 21: {
                    return a2 >= 40000 && a2 < (GameSetConstants.POTENTIAL_ALL ? 60004 : 60000);
                }
                case 20: {
                    if (a4 == 1 || Randomizer.nextInt(20) == 0) {
                        return a2 >= 40000 && a2 < (GameSetConstants.POTENTIAL_ALL ? 60004 : 60000);
                    }
                    return a2 >= 30000 && a2 < (GameSetConstants.POTENTIAL_ALL ? 60004 : 60000);
                }
                case 19: {
                    if (a4 == 1 || Randomizer.nextInt(20) == 0) {
                        return a2 >= 30000 && a2 < 40000;
                    }
                    return a2 >= 20000 && a2 < 30000;
                }
                case 18: {
                    if (a4 == 1 || Randomizer.nextInt(20) == 0) {
                        return a2 >= 20000 && a2 < 30000;
                    }
                    return a2 >= 10000 && a2 < 20000;
                }
                case 17: {
                    if (a4 == 1 || Randomizer.nextInt(20) == 0) {
                        return a2 >= 10000 && a2 < 20000;
                    }
                    return a2 < 10000;
                }
            }
            return false;
        }
        switch (a3) {
            case 8: {
                if (a4 == 0 || Randomizer.nextInt(10) == 0) {
                    return a2 >= 40000;
                }
                return a2 >= 30000 && a2 < 41008;
            }
            case 7: {
                if (a4 == 0 || Randomizer.nextInt(10) == 0) {
                    return a2 >= 30000;
                }
                return a2 >= 20000 && a2 < 30000;
            }
            case 6: {
                if (a4 == 0 || Randomizer.nextInt(10) == 0) {
                    return a2 >= 20000 && a2 < 30000;
                }
                return a2 >= 10000 && a2 < 20000;
            }
            case 5: {
                if (a4 == 0 || Randomizer.nextInt(10) == 0) {
                    return a2 >= 10000 && a2 < 20000;
                }
                return a2 < 10000;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isRechargable(int a2) {
        return GameConstants.isThrowingStar(a2) || GameConstants.isBullet(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getSkillForStat(MonsterStatus a2) {
        switch (a2) {
            case ACC: {
                return 3221006;
            }
            case SPEED: {
                return 3121007;
            }
        }
        return 0;
    }

    public static /* synthetic */ boolean isEvanDragonItem(int a2) {
        return a2 >= 1940000 && a2 < 1980000;
    }

    public static /* synthetic */ boolean isPet(int a2) {
        return a2 / 10000 == 500;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getStatDice(int a2) {
        switch (a2) {
            case 2: {
                return 30;
            }
            case 3: {
                return 20;
            }
            case 4: {
                return 15;
            }
            case 5: {
                return 20;
            }
            case 6: {
                return 30;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ short H(MapleCharacter a2) {
        int n2;
        IItem iItem;
        int n3;
        block9: {
            n3 = 0;
            iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
            Object object = iItem == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(iItem.getItemId());
            object = ((Enum)object).name();
            int n4 = -1;
            switch (((String)object).hashCode()) {
                case 820263: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u6353\u8642"))) break;
                    n2 = n4 = 0;
                    break block9;
                }
                case 919234: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u7016\u69cc"))) break;
                    n2 = n4 = 1;
                    break block9;
                }
                case 24361: {
                    if (!((String)object).equals(MapleCharacterCards.ALLATORIxDEMO("\u5f25"))) break;
                    n2 = n4 = 2;
                    break block9;
                }
                case 24339: {
                    if (!((String)object).equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u5f12"))) break;
                    n4 = 3;
                }
            }
            n2 = n4;
        }
        switch (n2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                n3 = 570;
                break;
            }
        }
        if (iItem == null) return (short)n3;
        if (iItem.getItemId() != 1492037) return (short)n3;
        return (short)540;
    }

    public static /* synthetic */ int getEmpress_ForJob(int a2) {
        return GameConstants.getSkillByJob(73, a2);
    }

    public static /* synthetic */ boolean isKatara(int a2) {
        return a2 / 10000 == 134;
    }

    public static /* synthetic */ int getSkillBookForSkill(int a2) {
        return GameConstants.getSkillBook(a2 / 10000);
    }

    public static /* synthetic */ int getPVPExpNeededForLevel(int a2) {
        if (a2 < 0 || a2 >= K.length) {
            return Integer.MAX_VALUE;
        }
        return K[a2];
    }

    public static /* synthetic */ boolean isRing(int a2) {
        return a2 >= 1112000 && a2 < 1113000;
    }

    public static /* synthetic */ int getCurrentDate_NoTime() {
        String string = FileoutputUtil.CurrentReadable_Time();
        return Integer.parseInt(string.substring(0, 4) + string.substring(5, 7) + string.substring(8, 10));
    }

    public static /* synthetic */ boolean isCygnus(int a2) {
        return a2 >= 1000 && a2 <= 1512;
    }

    public static final /* synthetic */ short getCharacter2ndJobLevel(int a2) {
        return 30;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getMountItem(int a2, MapleCharacter a3) {
        switch (a2) {
            case 5221006: {
                return 1932000;
            }
            case 33001001: {
                if (a3 == null) {
                    return 1932015;
                }
                switch (((MapleCharacter)a3).getIntNoRecord(111112)) {
                    case 20: {
                        return 1932030;
                    }
                    case 30: {
                        return 1932031;
                    }
                    case 40: {
                        return 1932032;
                    }
                    case 50: {
                        return 1932033;
                    }
                    case 60: {
                        return 1932036;
                    }
                    case 70: {
                        return 1932100;
                    }
                    case 80: {
                        return 1932149;
                    }
                    case 90: {
                        return 1932215;
                    }
                }
                return 1932015;
            }
            case 35001002: 
            case 35120000: {
                return 1932016;
            }
            case 20021160: {
                return 1932086;
            }
            case 20021161: {
                return 1932087;
            }
        }
        if (MapleJob.isBeginner(a2 / 10000) && a2 != 80001000 && (a3 = SkillFactory.getSkill(a2)) != null && a3.getSkillTamingMob() > 0) {
            return a3.getSkillTamingMob();
        }
        switch (a2) {
            case 20021160: {
                return 1932086;
            }
            case 20021161: {
                return 1932087;
            }
            case 20031160: {
                return 1932106;
            }
            case 20031161: {
                return 1932107;
            }
            case 30011109: {
                return 1932051;
            }
            case 30011159: {
                return 1932051;
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            return GameConstants.getMountItemEx(a2);
        }
        switch (a2 % 10000) {
            case 1013: 
            case 1046: {
                return 1932001;
            }
            case 1015: 
            case 1048: {
                return 1932002;
            }
            case 1016: 
            case 1017: 
            case 1027: {
                return 1932007;
            }
            case 1018: {
                return 1932003;
            }
            case 1019: {
                return 1932003;
            }
            case 1025: {
                return 1932006;
            }
            case 1028: {
                return 1932008;
            }
            case 1029: {
                return 1932009;
            }
            case 1030: {
                return 1932011;
            }
            case 1031: {
                return 1932010;
            }
            case 1033: {
                return 1932013;
            }
            case 1034: {
                return 1932014;
            }
            case 1035: {
                return 1932012;
            }
            case 1036: {
                return 1932017;
            }
            case 1037: {
                return 1932018;
            }
            case 1038: {
                return 1932019;
            }
            case 1039: {
                return 1932020;
            }
            case 1040: {
                return 1932021;
            }
            case 1042: {
                return 1932022;
            }
            case 1044: {
                return 1932023;
            }
            case 1049: {
                return 1932025;
            }
            case 1050: {
                return 1932004;
            }
            case 1051: {
                return 1932026;
            }
            case 1052: {
                return 1932027;
            }
            case 1053: {
                return 1932028;
            }
            case 1054: {
                return 1932029;
            }
            case 1063: {
                return 1932034;
            }
            case 1064: {
                return 1932035;
            }
            case 1065: {
                return 1932037;
            }
            case 1069: {
                return 1932038;
            }
            case 1070: {
                return 1932039;
            }
            case 1071: {
                return 1932040;
            }
            case 1072: {
                return 1932041;
            }
            case 1084: {
                return 1932043;
            }
            case 1089: {
                return 1932044;
            }
            case 1096: {
                return 1932045;
            }
            case 1101: {
                return 1932046;
            }
            case 1102: {
                return 1932047;
            }
            case 1106: {
                return 1932048;
            }
            case 1118: {
                return 1932060;
            }
            case 1115: {
                return 1932052;
            }
            case 1121: {
                return 1932063;
            }
            case 1122: {
                return 1932064;
            }
            case 1123: {
                return 1932065;
            }
            case 1128: {
                return 1932066;
            }
            case 1130: {
                return 1932072;
            }
            case 1136: {
                return 1932078;
            }
            case 1138: {
                return 1932080;
            }
            case 1139: {
                return 1932081;
            }
            case 1143: 
            case 1144: 
            case 1145: 
            case 1146: 
            case 1147: 
            case 1148: 
            case 1149: 
            case 1150: 
            case 1151: 
            case 1152: 
            case 1153: 
            case 1154: 
            case 1155: 
            case 1156: 
            case 1157: {
                return 1992000 + a2 % 10000 - 1143;
            }
        }
        return GameConstants.getMountItemEx(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isOtherGem(int a2) {
        switch (a2) {
            case 1032062: 
            case 1142156: 
            case 1142157: 
            case 2040727: 
            case 2041058: 
            case 4001174: 
            case 4001175: 
            case 4001176: 
            case 4001177: 
            case 4001178: 
            case 4001179: 
            case 4001180: 
            case 4001181: 
            case 4001182: 
            case 4001183: 
            case 4001184: 
            case 4001185: 
            case 4001186: 
            case 4031980: 
            case 4032312: 
            case 4032334: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getMountItemEx(int a2) {
        int n2 = 1932000;
        if (a2 >= 80001003 && a2 <= 80001006) {
            return 1932006 + (a2 - 80001003);
        }
        if (a2 >= 80001014 && a2 <= 80001017) {
            return 1932025 + (a2 - 80001014);
        }
        if (a2 >= 80001018 && a2 <= 80001019) {
            return 1932034 + (a2 - 80001018);
        }
        if (a2 >= 80001021 && a2 <= 80001022) {
            return 1932043 + (a2 - 80001021);
        }
        if (a2 >= 80001027 && a2 <= 80001028) {
            return 1932049 + (a2 - 80001027);
        }
        if (a2 >= 80001029 && a2 <= 80001033) {
            return 1932053 + (a2 - 80001029);
        }
        if (a2 >= 80001054 && a2 <= 80001056) {
            return 1932045 + (a2 - 80001054);
        }
        if (a2 >= 80001063 && a2 <= 80001077) {
            return 1992000 + (a2 - 80001063);
        }
        if (a2 >= 80001115 && a2 <= 80001116) {
            return 1932065 + (a2 - 80001115);
        }
        if (a2 >= 80001121 && a2 <= 80001121) {
            return 1932092 + (a2 - 80001121);
        }
        if (a2 >= 80001083 && a2 <= 80001084) {
            return 1932094 + (a2 - 80001083);
        }
        if (a2 >= 80001112 && a2 <= 80001114) {
            return 1932097 + (a2 - 80001112);
        }
        if (a2 >= 80001148 && a2 <= 80001149) {
            return 1932114 + (a2 - 80001148);
        }
        if (a2 >= 80001220 && a2 <= 80001221) {
            return 1932143 + (a2 - 80001220);
        }
        if (a2 >= 80001243 && a2 <= 80001244) {
            return 1932156 + (a2 - 80001243);
        }
        if (a2 >= 80001257 && a2 <= 80001258) {
            return 1932161 + (a2 - 80001257);
        }
        if (a2 >= 80001289 && a2 <= 80001290) {
            return 1932170 + (a2 - 80001289);
        }
        if (a2 >= 80001304 && a2 <= 80001309) {
            return 1932179 + (a2 - 80001304);
        }
        if (a2 >= 80001312 && a2 <= 80001319) {
            return 1932187 + (a2 - 80001312);
        }
        if (a2 >= 80001347 && a2 <= 80001348) {
            return 1932207 + (a2 - 80001347);
        }
        if (a2 >= 80001449 && a2 <= 80001451) {
            return 1932225 + (a2 - 80001449);
        }
        switch (a2) {
            case 1204: {
                return 1932000;
            }
            case 80001001: 
            case 80001024: 
            case 80001025: {
                return 1932004;
            }
            case 80001007: {
                return 1932011;
            }
            case 80001008: {
                return 1932010;
            }
            case 80001009: {
                return 1932013;
            }
            case 80001010: {
                return 1932014;
            }
            case 80001011: {
                return 1932012;
            }
            case 80001012: {
                return 1932022;
            }
            case 80001013: {
                return 1932023;
            }
            case 80001020: {
                return 1932041;
            }
            case 80001023: {
                return 1932048;
            }
            case 80001026: {
                return 1932005;
            }
            case 80001037: {
                return 1932084;
            }
            case 80001038: {
                return 1932053;
            }
            case 80001039: {
                return 1932089;
            }
            case 80001044: {
                return 1932090;
            }
            case 80001046: {
                return 1932084;
            }
            case 80001050: {
                return 1932062;
            }
            case 80001051: {
                return 1932038;
            }
            case 80001057: {
                return 1932052;
            }
            case 80001059: {
                return 1932063;
            }
            case 80001058: {
                return 1932060;
            }
            case 80001060: {
                return 1932064;
            }
            case 80001061: {
                return 1932071;
            }
            case 80001062: {
                return 1932081;
            }
            case 80001078: {
                return 1932052;
            }
            case 80001082: {
                return 1932093;
            }
            case 80001090: {
                return 1932096;
            }
            case 80001117: {
                return 1932072;
            }
            case 80001118: {
                return 1932078;
            }
            case 80001119: {
                return 1932080;
            }
            case 80001120: {
                return 1992015;
            }
            case 80001124: {
                return 1932105;
            }
            case 80001131: {
                return 1932109;
            }
            case 80001137: {
                return 1932110;
            }
            case 80001144: {
                return 1932113;
            }
            case 80001163: {
                return 1932002;
            }
            case 80001198: {
                return 1932140;
            }
            case 80001228: {
                return 1932148;
            }
            case 80001237: {
                return 1932153;
            }
            case 80001246: {
                return 1932159;
            }
            case 80001261: {
                return 1932164;
            }
            case 80001285: {
                return 1932167;
            }
            case 80001292: {
                return 1932173;
            }
            case 80001302: {
                return 1932178;
            }
            case 80001327: {
                return 1932198;
            }
            case 80001331: {
                return 1932199;
            }
            case 80001336: {
                return 1932200;
            }
            case 80001338: {
                return 1932201;
            }
            case 80001333: {
                return 1932205;
            }
            case 80001353: {
                return 1932211;
            }
            case 80001413: {
                return 1932219;
            }
            case 80001421: {
                return 1932221;
            }
            case 80001423: {
                return 1932222;
            }
            case 80001445: {
                return 1932242;
            }
            case 80001447: {
                return 1932243;
            }
            case 80001484: {
                return 1932235;
            }
            case 80001508: {
                return 1932244;
            }
            case 80001345: {
                return 1932204;
            }
            case 80001199: {
                return 1932256;
            }
            case 80001490: {
                return 1932259;
            }
            case 80001491: {
                return 1932258;
            }
            case 80001505: {
                return 1932251;
            }
            case 80001492: {
                return 1932249;
            }
            case 80001531: {
                return 1932253;
            }
            case 80001549: {
                return 1932254;
            }
            case 80001550: {
                return 1932255;
            }
            case 80001355: {
                return 1932212;
            }
            case 80001411: {
                return 1932218;
            }
        }
        return 0;
    }

    public static /* synthetic */ int getExpNeededForLevel(int a2) {
        int n2 = 250;
        if (a2 < 0 || a2 >= 250) {
            return Integer.MAX_VALUE;
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            return g[a2];
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (GameSetConstants.SERVER_NAME.equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u65b1\u6662\u8c36")) || GameSetConstants.SERVER_NAME.equals(MapleCharacterCards.ALLATORIxDEMO("\u65e4\u870e\u4e1f\u8c3b"))) {
                return e[a2];
            }
            return E[a2];
        }
        return e[a2];
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getAttackDelayBySkillAfterBuff(int a2) {
        switch (a2) {
            case 3121004: 
            case 5221004: 
            case 13111002: {
                return 120;
            }
            case 5001003: {
                return 390;
            }
            case 0x111AEE: 
            case 1221007: 
            case 1321003: 
            case 5111004: {
                return 450;
            }
            case 3111006: 
            case 4001344: 
            case 4121007: 
            case 5221007: 
            case 14001004: 
            case 14111005: {
                return 600;
            }
            case 1121008: {
                return 630;
            }
            case 15111006: {
                return 550;
            }
            case 3001005: 
            case 5001002: {
                return 660;
            }
            case 5211006: {
                return 780;
            }
            case 2211003: {
                return 1140;
            }
            case 5110001: 
            case 21101003: {
                return 1500;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte gachaponRareItem(int a2) {
        switch (a2) {
            case 1012171: 
            case 1022191: 
            case 1032206: 
            case 1102558: 
            case 1132213: 
            case 1143112: 
            case 2040807: 
            case 2290125: 
            case 3018112: 
            case 4280000: 
            case 4310216: 
            case 4310217: 
            case 4310260: 
            case 5220010: {
                return 1;
            }
            case 2022217: 
            case 2022221: 
            case 2022222: 
            case 2022223: {
                return 1;
            }
            case 2022483: 
            case 2210029: 
            case 2370000: 
            case 2370001: 
            case 2370002: 
            case 2370003: 
            case 2370004: 
            case 2370005: 
            case 2370006: 
            case 2370007: 
            case 3010054: {
                return 2;
            }
            case 1092049: 
            case 1372039: 
            case 1372040: 
            case 1372041: 
            case 1372042: 
            case 1382037: 
            case 2049100: {
                return 3;
            }
            case 1082149: 
            case 1082179: 
            case 1102041: 
            case 1102042: 
            case 1102084: 
            case 1102086: 
            case 1402044: 
            case 3010020: 
            case 3010041: 
            case 3010064: 
            case 3010065: 
            case 3010068: 
            case 3012001: 
            case 3012002: {
                return 3;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getStampRate(int a2) {
        switch (a2) {
            case 2049500: {
                return 80;
            }
            case 2049501: {
                return 50;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getMaxMPByJob(MapleCharacter a2) {
        switch (a2.getJob()) {
            case 3100: {
                return 30;
            }
            case 3110: {
                return 50;
            }
            case 3111: {
                return 100;
            }
            case 3112: {
                return 120;
            }
        }
        return 30;
    }

    public static /* synthetic */ Double maxViewRangeSq_Half() {
        return 1049088.0;
    }

    public static /* synthetic */ boolean isDemon(int a2) {
        return a2 == 3001 || a2 >= 3100 && a2 <= 3112;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean canHammer(int a2) {
        switch (a2) {
            case 1122000: 
            case 0x111F1C: {
                return false;
            }
        }
        return GameConstants.canScroll(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMarriageRing(int a2) {
        switch (a2) {
            case 1112300: 
            case 1112301: 
            case 1112302: 
            case 1112303: 
            case 1112304: 
            case 1112305: 
            case 1112306: 
            case 1112307: 
            case 1112308: 
            case 1112309: 
            case 1112310: 
            case 1112311: 
            case 1112315: 
            case 1112316: 
            case 1112317: 
            case 1112318: 
            case 1112319: 
            case 1112320: 
            case 1112803: 
            case 1112806: 
            case 1112807: 
            case 1112808: 
            case 1112809: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int getMountExpNeededForLevel(int a2) {
        return k[a2 - 1];
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean optionTypeFits(int a2, int a3, int a4) {
        if (a2 == 40055) {
            return ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4);
        }
        switch (a3) {
            case 10: {
                if (GameSetConstants.MAPLE_VERSION < 147) {
                    return ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4) || ItemConstants.\u985e\u578b.\u96d9\u5200((int)a4) || ItemConstants.\u985e\u578b.\u9b54\u6cd5\u7bad((int)a4) || ItemConstants.\u985e\u578b.\u80fd\u6e90((int)a4);
                }
                return ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4) || ItemConstants.\u985e\u578b.\u526f\u624b((int)a4) || ItemConstants.\u985e\u578b.\u80fd\u6e90((int)a4);
            }
            case 11: {
                return !ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4);
            }
            case 20: {
                return !ItemConstants.\u985e\u578b.\u98fe\u54c1((int)a4) && !ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4);
            }
            case 21: {
                return ItemConstants.\u985e\u578b.\u5bf5\u7269\u88dd((int)a4);
            }
            case 40: {
                return ItemConstants.\u985e\u578b.\u98fe\u54c1((int)a4);
            }
            case 51: {
                return ItemConstants.\u985e\u578b.\u5e3d\u5b50((int)a4);
            }
            case 52: {
                return ItemConstants.\u985e\u578b.\u62ab\u98a8((int)a4);
            }
            case 53: {
                return ItemConstants.\u985e\u578b.\u4e0a\u8863((int)a4) || ItemConstants.\u985e\u578b.\u5957\u670d((int)a4) || ItemConstants.\u985e\u578b.\u8932\u88d9((int)a4);
            }
            case 54: {
                return ItemConstants.\u985e\u578b.\u624b\u5957((int)a4);
            }
            case 55: {
                return ItemConstants.\u985e\u578b.\u978b\u5b50((int)a4);
            }
            case 90: {
                return false;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMarrigeRing(int a2) {
        switch (a2) {
            case 1112300: 
            case 1112301: 
            case 1112302: 
            case 1112303: 
            case 1112304: 
            case 1112305: 
            case 1112306: 
            case 1112307: 
            case 1112308: 
            case 1112309: 
            case 1112310: 
            case 1112311: 
            case 1112315: 
            case 1112316: 
            case 1112317: 
            case 1112318: 
            case 1112319: 
            case 1112320: 
            case 1112803: 
            case 1112806: 
            case 1112807: 
            case 1112808: 
            case 1112809: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isEffectRing(int a2) {
        return GameConstants.isFriendshipRing(a2) || GameConstants.isCrushRing(a2) || GameConstants.isMarriageRing(a2);
    }

    public static /* synthetic */ {
        String[] arrstring = new String[8];
        arrstring[0] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"&");
        arrstring[1] = MapleCharacterCards.ALLATORIxDEMO("1");
        arrstring[2] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"]n\u000f!");
        arrstring[3] = MapleCharacterCards.ALLATORIxDEMO(",5b0,");
        arrstring[4] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"!\ni\u0018s\u0018!");
        arrstring[5] = MapleCharacterCards.ALLATORIxDEMO("tj&c9,");
        arrstring[6] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"]o\bm\u0011!");
        arrstring[7] = MapleCharacterCards.ALLATORIxDEMO("th&c$,");
        bansql = new ArrayList<String>(Arrays.asList(arrstring));
        int[] arrn = new int[10];
        arrn[0] = 0;
        arrn[1] = 250;
        arrn[2] = 600;
        arrn[3] = 1050;
        arrn[4] = 1600;
        arrn[5] = 2250;
        arrn[6] = 3000;
        arrn[7] = 3850;
        arrn[8] = 4900;
        arrn[9] = 5850;
        H = arrn;
        int[] arrn2 = new int[10];
        arrn2[0] = 4006000;
        arrn2[1] = 2050004;
        arrn2[2] = 3994102;
        arrn2[3] = 3994103;
        arrn2[4] = 3994104;
        arrn2[5] = 3994102;
        arrn2[6] = 3994103;
        arrn2[7] = 3994104;
        arrn2[8] = 3994105;
        arrn2[9] = 2430007;
        normalMagicWheel = arrn2;
        int[] arrn3 = new int[9];
        arrn3[0] = 2028061;
        arrn3[1] = 2290285;
        arrn3[2] = 2049301;
        arrn3[3] = 2049401;
        arrn3[4] = 2022326;
        arrn3[5] = 2022193;
        arrn3[6] = 2049000;
        arrn3[7] = 2049001;
        arrn3[8] = 2049002;
        rareMagicWheel = arrn3;
        int[] arrn4 = new int[13];
        arrn4[0] = 2040804;
        arrn4[1] = 2049400;
        arrn4[2] = 2028062;
        arrn4[3] = 2028061;
        arrn4[4] = 2430144;
        arrn4[5] = 2430144;
        arrn4[6] = 2430144;
        arrn4[7] = 2430144;
        arrn4[8] = 2290285;
        arrn4[9] = 2049100;
        arrn4[10] = 2049100;
        arrn4[11] = 2049100;
        arrn4[12] = 2049100;
        superMagicWheel = arrn4;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[7];
        arrmapleMapObjectType[0] = MapleMapObjectType.ITEM;
        arrmapleMapObjectType[1] = MapleMapObjectType.MONSTER;
        arrmapleMapObjectType[2] = MapleMapObjectType.DOOR;
        arrmapleMapObjectType[3] = MapleMapObjectType.REACTOR;
        arrmapleMapObjectType[4] = MapleMapObjectType.SUMMON;
        arrmapleMapObjectType[5] = MapleMapObjectType.NPC;
        arrmapleMapObjectType[6] = MapleMapObjectType.MIST;
        rangedMapobjectTypes = Collections.unmodifiableList(Arrays.asList(arrmapleMapObjectType));
        int[] arrn5 = new int[251];
        arrn5[0] = 0;
        arrn5[1] = 15;
        arrn5[2] = 34;
        arrn5[3] = 57;
        arrn5[4] = 92;
        arrn5[5] = 135;
        arrn5[6] = 372;
        arrn5[7] = 560;
        arrn5[8] = 840;
        arrn5[9] = 1242;
        arrn5[10] = 1716;
        arrn5[11] = 2360;
        arrn5[12] = 3216;
        arrn5[13] = 4200;
        arrn5[14] = 5460;
        arrn5[15] = 7050;
        arrn5[16] = 8840;
        arrn5[17] = 11040;
        arrn5[18] = 13716;
        arrn5[19] = 16680;
        arrn5[20] = 20216;
        arrn5[21] = 24402;
        arrn5[22] = 28980;
        arrn5[23] = 34320;
        arrn5[24] = 40512;
        arrn5[25] = 47216;
        arrn5[26] = 54900;
        arrn5[27] = 63666;
        arrn5[28] = 73080;
        arrn5[29] = 83720;
        arrn5[30] = 95700;
        arrn5[31] = 108480;
        arrn5[32] = 122760;
        arrn5[33] = 138666;
        arrn5[34] = 155540;
        arrn5[35] = 174216;
        arrn5[36] = 194832;
        arrn5[37] = 216600;
        arrn5[38] = 240500;
        arrn5[39] = 266682;
        arrn5[40] = 294216;
        arrn5[41] = 324240;
        arrn5[42] = 356916;
        arrn5[43] = 391160;
        arrn5[44] = 428280;
        arrn5[45] = 468450;
        arrn5[46] = 510420;
        arrn5[47] = 555680;
        arrn5[48] = 604416;
        arrn5[49] = 655200;
        arrn5[50] = 709716;
        arrn5[51] = 748608;
        arrn5[52] = 789631;
        arrn5[53] = 832902;
        arrn5[54] = 878545;
        arrn5[55] = 926689;
        arrn5[56] = 977471;
        arrn5[57] = 1031036;
        arrn5[58] = 1087536;
        arrn5[59] = 1147132;
        arrn5[60] = 1209994;
        arrn5[61] = 1276301;
        arrn5[62] = 1346242;
        arrn5[63] = 1420016;
        arrn5[64] = 1497832;
        arrn5[65] = 1579913;
        arrn5[66] = 1666492;
        arrn5[67] = 1757815;
        arrn5[68] = 1854143;
        arrn5[69] = 1955750;
        arrn5[70] = 2062925;
        arrn5[71] = 2175973;
        arrn5[72] = 2295216;
        arrn5[73] = 2410993;
        arrn5[74] = 2553663;
        arrn5[75] = 2693603;
        arrn5[76] = 2841212;
        arrn5[77] = 2996910;
        arrn5[78] = 3161140;
        arrn5[79] = 3334370;
        arrn5[80] = 0x35AAA5;
        arrn5[81] = 3709829;
        arrn5[82] = 3913127;
        arrn5[83] = 4127566;
        arrn5[84] = 4353756;
        arrn5[85] = 4592341;
        arrn5[86] = 4844001;
        arrn5[87] = 5109452;
        arrn5[88] = 5389449;
        arrn5[89] = 5684790;
        arrn5[90] = 5996316;
        arrn5[91] = 6324914;
        arrn5[92] = 6671519;
        arrn5[93] = 7037118;
        arrn5[94] = 7422752;
        arrn5[95] = 7829518;
        arrn5[96] = 8258575;
        arrn5[97] = 8711144;
        arrn5[98] = 9188514;
        arrn5[99] = 9692044;
        arrn5[100] = 10223168;
        arrn5[101] = 10783397;
        arrn5[102] = 11374327;
        arrn5[103] = 11997640;
        arrn5[104] = 12655110;
        arrn5[105] = 13348610;
        arrn5[106] = 14080113;
        arrn5[107] = 14851703;
        arrn5[108] = 15665576;
        arrn5[109] = 16524049;
        arrn5[110] = 17429566;
        arrn5[111] = 18384706;
        arrn5[112] = 19392187;
        arrn5[113] = 20454878;
        arrn5[114] = 21575805;
        arrn5[115] = 22758159;
        arrn5[116] = 24005306;
        arrn5[117] = 25320796;
        arrn5[118] = 26708375;
        arrn5[119] = 28171993;
        arrn5[120] = 29715818;
        arrn5[121] = 31344244;
        arrn5[122] = 33061908;
        arrn5[123] = 34873700;
        arrn5[124] = 36784778;
        arrn5[125] = 38800583;
        arrn5[126] = 40926854;
        arrn5[127] = 43169645;
        arrn5[128] = 45535341;
        arrn5[129] = 48030677;
        arrn5[130] = 50662758;
        arrn5[131] = 53439077;
        arrn5[132] = 56367538;
        arrn5[133] = 59456479;
        arrn5[134] = 62714694;
        arrn5[135] = 66151459;
        arrn5[136] = 69776558;
        arrn5[137] = 73600313;
        arrn5[138] = 77633610;
        arrn5[139] = 81887931;
        arrn5[140] = 86375389;
        arrn5[141] = 91108760;
        arrn5[142] = 96101520;
        arrn5[143] = 101367883;
        arrn5[144] = 106922842;
        arrn5[145] = 112782213;
        arrn5[146] = 118962678;
        arrn5[147] = 125481832;
        arrn5[148] = 132358236;
        arrn5[149] = 139611467;
        arrn5[150] = 147262175;
        arrn5[151] = 155332142;
        arrn5[152] = 163844343;
        arrn5[153] = 172823012;
        arrn5[154] = 182293713;
        arrn5[155] = 192283408;
        arrn5[156] = 202820538;
        arrn5[157] = 213935103;
        arrn5[158] = 225658746;
        arrn5[159] = 238024845;
        arrn5[160] = 251068606;
        arrn5[161] = 264827165;
        arrn5[162] = 279339693;
        arrn5[163] = 294647508;
        arrn5[164] = 310794191;
        arrn5[165] = 327825712;
        arrn5[166] = 345790561;
        arrn5[167] = 364739883;
        arrn5[168] = 384727628;
        arrn5[169] = 405810702;
        arrn5[170] = 428049128;
        arrn5[171] = 451506220;
        arrn5[172] = 476248760;
        arrn5[173] = 502347192;
        arrn5[174] = 529875818;
        arrn5[175] = 558913012;
        arrn5[176] = 589541445;
        arrn5[177] = 621848316;
        arrn5[178] = 655925603;
        arrn5[179] = 691870326;
        arrn5[180] = 729784819;
        arrn5[181] = 769777027;
        arrn5[182] = 811960808;
        arrn5[183] = 856456260;
        arrn5[184] = 903390063;
        arrn5[185] = 952895838;
        arrn5[186] = 1005114529;
        arrn5[187] = 1060194805;
        arrn5[188] = 1118293480;
        arrn5[189] = 1179575962;
        arrn5[190] = 1244216724;
        arrn5[191] = 1312399800;
        arrn5[192] = 1384319309;
        arrn5[193] = 1460180007;
        arrn5[194] = 1540197871;
        arrn5[195] = 1624600714;
        arrn5[196] = 1713628833;
        arrn5[197] = 1807535693;
        arrn5[198] = 1906588648;
        arrn5[199] = 2011069705;
        arrn5[200] = 2121276324;
        arrn5[201] = 2121276324;
        arrn5[202] = 2121276324;
        arrn5[203] = 2121276324;
        arrn5[204] = 2121276324;
        arrn5[205] = 2121276324;
        arrn5[206] = 2121276324;
        arrn5[207] = 2121276324;
        arrn5[208] = 2121276324;
        arrn5[209] = 2121276324;
        arrn5[210] = 2121276324;
        arrn5[211] = 2121276324;
        arrn5[212] = 2121276324;
        arrn5[213] = 2121276324;
        arrn5[214] = 2121276324;
        arrn5[215] = 2121276324;
        arrn5[216] = 2121276324;
        arrn5[217] = 2121276324;
        arrn5[218] = 2121276324;
        arrn5[219] = 2121276324;
        arrn5[220] = 2121276324;
        arrn5[221] = 2121276324;
        arrn5[222] = 2121276324;
        arrn5[223] = 2121276324;
        arrn5[224] = 2121276324;
        arrn5[225] = 2121276324;
        arrn5[226] = 2121276324;
        arrn5[227] = 2121276324;
        arrn5[228] = 2121276324;
        arrn5[229] = 2121276324;
        arrn5[230] = 2121276324;
        arrn5[231] = 2121276324;
        arrn5[232] = 2121276324;
        arrn5[233] = 2121276324;
        arrn5[234] = 2121276324;
        arrn5[235] = 2121276324;
        arrn5[236] = 2121276324;
        arrn5[237] = 2121276324;
        arrn5[238] = 2121276324;
        arrn5[239] = 2121276324;
        arrn5[240] = 2121276324;
        arrn5[241] = 2121276324;
        arrn5[242] = 2121276324;
        arrn5[243] = 2121276324;
        arrn5[244] = 2121276324;
        arrn5[245] = 2121276324;
        arrn5[246] = 2121276324;
        arrn5[247] = 2121276324;
        arrn5[248] = 2121276324;
        arrn5[249] = 2121276324;
        arrn5[250] = 2121276324;
        e = arrn5;
        int[] arrn6 = new int[256];
        arrn6[0] = 0;
        arrn6[1] = 15;
        arrn6[2] = 35;
        arrn6[3] = 57;
        arrn6[4] = 92;
        arrn6[5] = 135;
        arrn6[6] = 372;
        arrn6[7] = 560;
        arrn6[8] = 840;
        arrn6[9] = 1242;
        arrn6[10] = 1242;
        arrn6[11] = 1242;
        arrn6[12] = 1242;
        arrn6[13] = 1242;
        arrn6[14] = 1242;
        arrn6[15] = 1490;
        arrn6[16] = 1788;
        arrn6[17] = 2146;
        arrn6[18] = 2575;
        arrn6[19] = 3090;
        arrn6[20] = 3708;
        arrn6[21] = 4450;
        arrn6[22] = 5340;
        arrn6[23] = 6408;
        arrn6[24] = 7690;
        arrn6[25] = 9228;
        arrn6[26] = 11074;
        arrn6[27] = 13289;
        arrn6[28] = 15947;
        arrn6[29] = 19136;
        arrn6[30] = 19136;
        arrn6[31] = 19136;
        arrn6[32] = 19136;
        arrn6[33] = 19136;
        arrn6[34] = 19136;
        arrn6[35] = 22963;
        arrn6[36] = 27556;
        arrn6[37] = 33067;
        arrn6[38] = 39681;
        arrn6[39] = 47616;
        arrn6[40] = 51425;
        arrn6[41] = 55539;
        arrn6[42] = 59982;
        arrn6[43] = 64781;
        arrn6[44] = 69963;
        arrn6[45] = 75560;
        arrn6[46] = 81605;
        arrn6[47] = 88133;
        arrn6[48] = 95184;
        arrn6[49] = 102799;
        arrn6[50] = 111023;
        arrn6[51] = 119905;
        arrn6[52] = 129497;
        arrn6[53] = 139857;
        arrn6[54] = 151046;
        arrn6[55] = 163129;
        arrn6[56] = 176180;
        arrn6[57] = 190274;
        arrn6[58] = 205496;
        arrn6[59] = 221936;
        arrn6[60] = 239691;
        arrn6[61] = 258866;
        arrn6[62] = 279575;
        arrn6[63] = 301941;
        arrn6[64] = 326097;
        arrn6[65] = 352184;
        arrn6[66] = 380359;
        arrn6[67] = 410788;
        arrn6[68] = 443651;
        arrn6[69] = 479143;
        arrn6[70] = 479143;
        arrn6[71] = 479143;
        arrn6[72] = 479143;
        arrn6[73] = 479143;
        arrn6[74] = 479143;
        arrn6[75] = 512683;
        arrn6[76] = 548571;
        arrn6[77] = 586971;
        arrn6[78] = 628059;
        arrn6[79] = 672024;
        arrn6[80] = 719065;
        arrn6[81] = 769400;
        arrn6[82] = 823258;
        arrn6[83] = 880886;
        arrn6[84] = 942548;
        arrn6[85] = 1008526;
        arrn6[86] = 1079123;
        arrn6[87] = 1154662;
        arrn6[88] = 1235488;
        arrn6[89] = 1321972;
        arrn6[90] = 1414511;
        arrn6[91] = 1513526;
        arrn6[92] = 1619473;
        arrn6[93] = 1732836;
        arrn6[94] = 1854135;
        arrn6[95] = 1983924;
        arrn6[96] = 2122799;
        arrn6[97] = 2271395;
        arrn6[98] = 2430393;
        arrn6[99] = 2600520;
        arrn6[100] = 2782557;
        arrn6[101] = 2977336;
        arrn6[102] = 3185749;
        arrn6[103] = 3408752;
        arrn6[104] = 3647365;
        arrn6[105] = 3902680;
        arrn6[106] = 4175868;
        arrn6[107] = 4468179;
        arrn6[108] = 4780951;
        arrn6[109] = 5115618;
        arrn6[110] = 5473711;
        arrn6[111] = 5856871;
        arrn6[112] = 6266852;
        arrn6[113] = 6705531;
        arrn6[114] = 7174919;
        arrn6[115] = 7677163;
        arrn6[116] = 8214565;
        arrn6[117] = 8789584;
        arrn6[118] = 9404855;
        arrn6[119] = 10063195;
        arrn6[120] = 10063195;
        arrn6[121] = 10063195;
        arrn6[122] = 10063195;
        arrn6[123] = 10063195;
        arrn6[124] = 10063195;
        arrn6[125] = 10767619;
        arrn6[126] = 11521352;
        arrn6[127] = 12327847;
        arrn6[128] = 13190796;
        arrn6[129] = 14114152;
        arrn6[130] = 15102142;
        arrn6[131] = 16159292;
        arrn6[132] = 17290443;
        arrn6[133] = 18500774;
        arrn6[134] = 19795828;
        arrn6[135] = 21181536;
        arrn6[136] = 22664244;
        arrn6[137] = 24250741;
        arrn6[138] = 25948292;
        arrn6[139] = 27764673;
        arrn6[140] = 29708200;
        arrn6[141] = 31787774;
        arrn6[142] = 34012918;
        arrn6[143] = 36393823;
        arrn6[144] = 38941390;
        arrn6[145] = 41667288;
        arrn6[146] = 44583998;
        arrn6[147] = 47704878;
        arrn6[148] = 51044219;
        arrn6[149] = 54617315;
        arrn6[150] = 58440527;
        arrn6[151] = 62531364;
        arrn6[152] = 66908559;
        arrn6[153] = 71592158;
        arrn6[154] = 76603609;
        arrn6[155] = 81965862;
        arrn6[156] = 87703472;
        arrn6[157] = 93842715;
        arrn6[158] = 100411706;
        arrn6[159] = 107440525;
        arrn6[160] = 113895024;
        arrn6[161] = 120728726;
        arrn6[162] = 127972450;
        arrn6[163] = 135650797;
        arrn6[164] = 143789844;
        arrn6[165] = 152417235;
        arrn6[166] = 161562269;
        arrn6[167] = 171256005;
        arrn6[168] = 181531366;
        arrn6[169] = 192423248;
        arrn6[170] = 203968643;
        arrn6[171] = 216206761;
        arrn6[172] = 229179167;
        arrn6[173] = 242929917;
        arrn6[174] = 257505712;
        arrn6[175] = 272956055;
        arrn6[176] = 289333418;
        arrn6[177] = 306693423;
        arrn6[178] = 325095029;
        arrn6[179] = 344600730;
        arrn6[180] = 365276774;
        arrn6[181] = 387193381;
        arrn6[182] = 410424983;
        arrn6[183] = 435050483;
        arrn6[184] = 461153512;
        arrn6[185] = 488822722;
        arrn6[186] = 518152086;
        arrn6[187] = 549241211;
        arrn6[188] = 582195683;
        arrn6[189] = 617127424;
        arrn6[190] = 654155070;
        arrn6[191] = 693404374;
        arrn6[192] = 735008637;
        arrn6[193] = 779109155;
        arrn6[194] = 825855704;
        arrn6[195] = 875407047;
        arrn6[196] = 927931469;
        arrn6[197] = 983607358;
        arrn6[198] = 1042623799;
        arrn6[199] = 1105181227;
        arrn6[200] = 1171492101;
        arrn6[201] = 2121276324;
        arrn6[202] = 2121276324;
        arrn6[203] = 2121276324;
        arrn6[204] = 2121276324;
        arrn6[205] = 2121276324;
        arrn6[206] = 2121276324;
        arrn6[207] = 2121276324;
        arrn6[208] = 2121276324;
        arrn6[209] = 2121276324;
        arrn6[210] = 2121276324;
        arrn6[211] = 2121276324;
        arrn6[212] = 2121276324;
        arrn6[213] = 2121276324;
        arrn6[214] = 2121276324;
        arrn6[215] = 2121276324;
        arrn6[216] = 2121276324;
        arrn6[217] = 2121276324;
        arrn6[218] = 2121276324;
        arrn6[219] = 2121276324;
        arrn6[220] = 2121276324;
        arrn6[221] = 2121276324;
        arrn6[222] = 2121276324;
        arrn6[223] = 2121276324;
        arrn6[224] = 2121276324;
        arrn6[225] = 2121276324;
        arrn6[226] = 2121276324;
        arrn6[227] = 2121276324;
        arrn6[228] = 2121276324;
        arrn6[229] = 2121276324;
        arrn6[230] = 2121276324;
        arrn6[231] = 2121276324;
        arrn6[232] = 2121276324;
        arrn6[233] = 2121276324;
        arrn6[234] = 2121276324;
        arrn6[235] = 2121276324;
        arrn6[236] = 2121276324;
        arrn6[237] = 2121276324;
        arrn6[238] = 2121276324;
        arrn6[239] = 2121276324;
        arrn6[240] = 2121276324;
        arrn6[241] = 2121276324;
        arrn6[242] = 2121276324;
        arrn6[243] = 2121276324;
        arrn6[244] = 2121276324;
        arrn6[245] = 2121276324;
        arrn6[246] = 2121276324;
        arrn6[247] = 2121276324;
        arrn6[248] = 2121276324;
        arrn6[249] = 2121276324;
        arrn6[250] = 2121276324;
        arrn6[251] = 2121276324;
        arrn6[252] = 2121276324;
        arrn6[253] = 2121276324;
        arrn6[254] = 2121276324;
        arrn6[255] = 2121276324;
        E = arrn6;
        int[] arrn7 = new int[256];
        arrn7[0] = 0;
        arrn7[1] = 15;
        arrn7[2] = 34;
        arrn7[3] = 57;
        arrn7[4] = 92;
        arrn7[5] = 135;
        arrn7[6] = 372;
        arrn7[7] = 560;
        arrn7[8] = 840;
        arrn7[9] = 1242;
        arrn7[10] = 1242;
        arrn7[11] = 1242;
        arrn7[12] = 1242;
        arrn7[13] = 1242;
        arrn7[14] = 1242;
        arrn7[15] = 1490;
        arrn7[16] = 1788;
        arrn7[17] = 2145;
        arrn7[18] = 2574;
        arrn7[19] = 3088;
        arrn7[20] = 3705;
        arrn7[21] = 4446;
        arrn7[22] = 5335;
        arrn7[23] = 6402;
        arrn7[24] = 7682;
        arrn7[25] = 9218;
        arrn7[26] = 11061;
        arrn7[27] = 13273;
        arrn7[28] = 15927;
        arrn7[29] = 19112;
        arrn7[30] = 19112;
        arrn7[31] = 19112;
        arrn7[32] = 19112;
        arrn7[33] = 19112;
        arrn7[34] = 19112;
        arrn7[35] = 22934;
        arrn7[36] = 27520;
        arrn7[37] = 33024;
        arrn7[38] = 39628;
        arrn7[39] = 47553;
        arrn7[40] = 51357;
        arrn7[41] = 55465;
        arrn7[42] = 59902;
        arrn7[43] = 64694;
        arrn7[44] = 69869;
        arrn7[45] = 75458;
        arrn7[46] = 81494;
        arrn7[47] = 88013;
        arrn7[48] = 95054;
        arrn7[49] = 102658;
        arrn7[50] = 110870;
        arrn7[51] = 119739;
        arrn7[52] = 129318;
        arrn7[53] = 139663;
        arrn7[54] = 150836;
        arrn7[55] = 162902;
        arrn7[56] = 175934;
        arrn7[57] = 190008;
        arrn7[58] = 205208;
        arrn7[59] = 221624;
        arrn7[60] = 221624;
        arrn7[61] = 221624;
        arrn7[62] = 221624;
        arrn7[63] = 221624;
        arrn7[64] = 221624;
        arrn7[65] = 239353;
        arrn7[66] = 258501;
        arrn7[67] = 279181;
        arrn7[68] = 301515;
        arrn7[69] = 325636;
        arrn7[70] = 351686;
        arrn7[71] = 379820;
        arrn7[72] = 410205;
        arrn7[73] = 443021;
        arrn7[74] = 478462;
        arrn7[75] = 511954;
        arrn7[76] = 547790;
        arrn7[77] = 586135;
        arrn7[78] = 627164;
        arrn7[79] = 671065;
        arrn7[80] = 718039;
        arrn7[81] = 768301;
        arrn7[82] = 822082;
        arrn7[83] = 879627;
        arrn7[84] = 941200;
        arrn7[85] = 1007084;
        arrn7[86] = 1077579;
        arrn7[87] = 1153009;
        arrn7[88] = 1233719;
        arrn7[89] = 1320079;
        arrn7[90] = 1412484;
        arrn7[91] = 1511357;
        arrn7[92] = 1617151;
        arrn7[93] = 1730351;
        arrn7[94] = 1851475;
        arrn7[95] = 1981078;
        arrn7[96] = 2119753;
        arrn7[97] = 2268135;
        arrn7[98] = 2426904;
        arrn7[99] = 2596787;
        arrn7[100] = 2596787;
        arrn7[101] = 2596787;
        arrn7[102] = 2596787;
        arrn7[103] = 2596787;
        arrn7[104] = 2596787;
        arrn7[105] = 2778562;
        arrn7[106] = 2973061;
        arrn7[107] = 3181175;
        arrn7[108] = 3403857;
        arrn7[109] = 3642126;
        arrn7[110] = 3897074;
        arrn7[111] = 4169869;
        arrn7[112] = 4461759;
        arrn7[113] = 4774082;
        arrn7[114] = 5108267;
        arrn7[115] = 5465845;
        arrn7[116] = 5848454;
        arrn7[117] = 6257845;
        arrn7[118] = 6695894;
        arrn7[119] = 7164606;
        arrn7[120] = 7666128;
        arrn7[121] = 8202756;
        arrn7[122] = 8776948;
        arrn7[123] = 9391334;
        arrn7[124] = 10048727;
        arrn7[125] = 10752137;
        arrn7[126] = 11504786;
        arrn7[127] = 12310121;
        arrn7[128] = 13171829;
        arrn7[129] = 14093857;
        arrn7[130] = 15080426;
        arrn7[131] = 16136055;
        arrn7[132] = 17265578;
        arrn7[133] = 18474168;
        arrn7[134] = 19767359;
        arrn7[135] = 21151074;
        arrn7[136] = 22631649;
        arrn7[137] = 24215864;
        arrn7[138] = 25910974;
        arrn7[139] = 27724742;
        arrn7[140] = 29665473;
        arrn7[141] = 31742056;
        arrn7[142] = 33963999;
        arrn7[143] = 36341478;
        arrn7[144] = 38885381;
        arrn7[145] = 41607357;
        arrn7[146] = 44519871;
        arrn7[147] = 47636261;
        arrn7[148] = 50970799;
        arrn7[149] = 54538754;
        arrn7[150] = 58356466;
        arrn7[151] = 62441418;
        arrn7[152] = 66812317;
        arrn7[153] = 71489179;
        arrn7[154] = 76493421;
        arrn7[155] = 81847960;
        arrn7[156] = 87577317;
        arrn7[157] = 93707729;
        arrn7[158] = 100267270;
        arrn7[159] = 107285978;
        arrn7[160] = 113723136;
        arrn7[161] = 120546524;
        arrn7[162] = 127779315;
        arrn7[163] = 135446073;
        arrn7[164] = 143572837;
        arrn7[165] = 152187207;
        arrn7[166] = 161318439;
        arrn7[167] = 170997545;
        arrn7[168] = 181257397;
        arrn7[169] = 192132840;
        arrn7[170] = 203660810;
        arrn7[171] = 215880458;
        arrn7[172] = 228833285;
        arrn7[173] = 242563282;
        arrn7[174] = 257117078;
        arrn7[175] = 272544102;
        arrn7[176] = 288896748;
        arrn7[177] = 306230552;
        arrn7[178] = 324604385;
        arrn7[179] = 344080648;
        arrn7[180] = 364725486;
        arrn7[181] = 386609015;
        arrn7[182] = 409805555;
        arrn7[183] = 434393888;
        arrn7[184] = 460457521;
        arrn7[185] = 488084972;
        arrn7[186] = 517370070;
        arrn7[187] = 548412274;
        arrn7[188] = 581317010;
        arrn7[189] = 616196030;
        arrn7[190] = 653167791;
        arrn7[191] = 692357858;
        arrn7[192] = 733899329;
        arrn7[193] = 777933288;
        arrn7[194] = 824609285;
        arrn7[195] = 874085842;
        arrn7[196] = 926530992;
        arrn7[197] = 982122851;
        arrn7[198] = 1041050222;
        arrn7[199] = 1103513235;
        arrn7[200] = 1171492101;
        arrn7[201] = 2121276324;
        arrn7[202] = 2121276324;
        arrn7[203] = 2121276324;
        arrn7[204] = 2121276324;
        arrn7[205] = 2121276324;
        arrn7[206] = 2121276324;
        arrn7[207] = 2121276324;
        arrn7[208] = 2121276324;
        arrn7[209] = 2121276324;
        arrn7[210] = 2121276324;
        arrn7[211] = 2121276324;
        arrn7[212] = 2121276324;
        arrn7[213] = 2121276324;
        arrn7[214] = 2121276324;
        arrn7[215] = 2121276324;
        arrn7[216] = 2121276324;
        arrn7[217] = 2121276324;
        arrn7[218] = 2121276324;
        arrn7[219] = 2121276324;
        arrn7[220] = 2121276324;
        arrn7[221] = 2121276324;
        arrn7[222] = 2121276324;
        arrn7[223] = 2121276324;
        arrn7[224] = 2121276324;
        arrn7[225] = 2121276324;
        arrn7[226] = 2121276324;
        arrn7[227] = 2121276324;
        arrn7[228] = 2121276324;
        arrn7[229] = 2121276324;
        arrn7[230] = 2121276324;
        arrn7[231] = 2121276324;
        arrn7[232] = 2121276324;
        arrn7[233] = 2121276324;
        arrn7[234] = 2121276324;
        arrn7[235] = 2121276324;
        arrn7[236] = 2121276324;
        arrn7[237] = 2121276324;
        arrn7[238] = 2121276324;
        arrn7[239] = 2121276324;
        arrn7[240] = 2121276324;
        arrn7[241] = 2121276324;
        arrn7[242] = 2121276324;
        arrn7[243] = 2121276324;
        arrn7[244] = 2121276324;
        arrn7[245] = 2121276324;
        arrn7[246] = 2121276324;
        arrn7[247] = 2121276324;
        arrn7[248] = 2121276324;
        arrn7[249] = 2121276324;
        arrn7[250] = 2121276324;
        arrn7[251] = 2121276324;
        arrn7[252] = 2121276324;
        arrn7[253] = 2121276324;
        arrn7[254] = 2121276324;
        arrn7[255] = 2121276324;
        g = arrn7;
        int[] arrn8 = new int[30];
        arrn8[0] = 0;
        arrn8[1] = 1;
        arrn8[2] = 3;
        arrn8[3] = 6;
        arrn8[4] = 14;
        arrn8[5] = 31;
        arrn8[6] = 60;
        arrn8[7] = 108;
        arrn8[8] = 181;
        arrn8[9] = 287;
        arrn8[10] = 434;
        arrn8[11] = 632;
        arrn8[12] = 891;
        arrn8[13] = 1224;
        arrn8[14] = 1642;
        arrn8[15] = 2161;
        arrn8[16] = 2793;
        arrn8[17] = 3557;
        arrn8[18] = 4467;
        arrn8[19] = 5542;
        arrn8[20] = 6801;
        arrn8[21] = 8263;
        arrn8[22] = 9950;
        arrn8[23] = 11882;
        arrn8[24] = 14084;
        arrn8[25] = 16578;
        arrn8[26] = 19391;
        arrn8[27] = 22547;
        arrn8[28] = 26074;
        arrn8[29] = 30000;
        B = arrn8;
        int[] arrn9 = new int[30];
        arrn9[0] = 0;
        arrn9[1] = 6;
        arrn9[2] = 25;
        arrn9[3] = 50;
        arrn9[4] = 105;
        arrn9[5] = 134;
        arrn9[6] = 196;
        arrn9[7] = 254;
        arrn9[8] = 263;
        arrn9[9] = 315;
        arrn9[10] = 367;
        arrn9[11] = 430;
        arrn9[12] = 543;
        arrn9[13] = 587;
        arrn9[14] = 679;
        arrn9[15] = 725;
        arrn9[16] = 897;
        arrn9[17] = 1146;
        arrn9[18] = 1394;
        arrn9[19] = 1701;
        arrn9[20] = 2247;
        arrn9[21] = 2543;
        arrn9[22] = 2898;
        arrn9[23] = 3156;
        arrn9[24] = 3313;
        arrn9[25] = 3584;
        arrn9[26] = 3923;
        arrn9[27] = 4150;
        arrn9[28] = 4305;
        arrn9[29] = 4550;
        k = arrn9;
        int[] arrn10 = new int[40];
        arrn10[0] = 2340000;
        arrn10[1] = 2049100;
        arrn10[2] = 4001129;
        arrn10[3] = 2040037;
        arrn10[4] = 2040006;
        arrn10[5] = 2040007;
        arrn10[6] = 2040303;
        arrn10[7] = 2040403;
        arrn10[8] = 2040506;
        arrn10[9] = 2040507;
        arrn10[10] = 2040603;
        arrn10[11] = 2040709;
        arrn10[12] = 2040710;
        arrn10[13] = 2040711;
        arrn10[14] = 2040806;
        arrn10[15] = 2040903;
        arrn10[16] = 2041024;
        arrn10[17] = 2041025;
        arrn10[18] = 2043003;
        arrn10[19] = 2043103;
        arrn10[20] = 2043203;
        arrn10[21] = 2043303;
        arrn10[22] = 2043703;
        arrn10[23] = 2043803;
        arrn10[24] = 2044003;
        arrn10[25] = 2044103;
        arrn10[26] = 2044203;
        arrn10[27] = 2044303;
        arrn10[28] = 0x1F31F3;
        arrn10[29] = 2044503;
        arrn10[30] = 2044603;
        arrn10[31] = 2044908;
        arrn10[32] = 2044815;
        arrn10[33] = 2044019;
        arrn10[34] = 0x1F331F;
        arrn10[35] = 1004001;
        arrn10[36] = 4007008;
        arrn10[37] = 1004002;
        arrn10[38] = 5152053;
        arrn10[39] = 5150040;
        itemBlock = arrn10;
        int[] arrn11 = new int[16];
        arrn11[0] = 5500001;
        arrn11[1] = 5500002;
        arrn11[2] = 5600001;
        arrn11[3] = 5401000;
        arrn11[4] = 5490000;
        arrn11[5] = 5490001;
        arrn11[6] = 5500000;
        arrn11[7] = 5252001;
        arrn11[8] = 5252003;
        arrn11[9] = 5220002;
        arrn11[10] = 5200000;
        arrn11[11] = 5200001;
        arrn11[12] = 5200002;
        arrn11[13] = 5440000;
        arrn11[14] = 5201001;
        arrn11[15] = 5201002;
        cashBlock = arrn11;
        blockedSkills = new int[0];
        int[] arrn12 = new int[315];
        arrn12[0] = 109050000;
        arrn12[1] = 280030000;
        arrn12[2] = 240060200;
        arrn12[3] = 280090000;
        arrn12[4] = 280030001;
        arrn12[5] = 240060201;
        arrn12[6] = 950101100;
        arrn12[7] = 950101010;
        arrn12[8] = 270040000;
        arrn12[9] = 270050000;
        arrn12[10] = 270050100;
        arrn12[11] = 880001000;
        arrn12[12] = 880002000;
        arrn12[13] = 880003000;
        arrn12[14] = 880004000;
        arrn12[15] = 880005000;
        arrn12[16] = 880006000;
        arrn12[17] = 880007000;
        arrn12[18] = 880008000;
        arrn12[19] = 880009000;
        arrn12[20] = 880010000;
        arrn12[21] = 880011000;
        arrn12[22] = 880012000;
        arrn12[23] = 881001000;
        arrn12[24] = 881002000;
        arrn12[25] = 881003000;
        arrn12[26] = 881004000;
        arrn12[27] = 881005000;
        arrn12[28] = 881006000;
        arrn12[29] = 881007000;
        arrn12[30] = 881008000;
        arrn12[31] = 881009000;
        arrn12[32] = 881010000;
        arrn12[33] = 881012000;
        arrn12[34] = 881102000;
        arrn12[35] = 881103000;
        arrn12[36] = 881201000;
        arrn12[37] = 881202000;
        arrn12[38] = 881203000;
        arrn12[39] = 881204000;
        arrn12[40] = 881205000;
        arrn12[41] = 881207000;
        arrn12[42] = 870005500;
        arrn12[43] = 870005501;
        arrn12[44] = 870005502;
        arrn12[45] = 870005503;
        arrn12[46] = 870005002;
        arrn12[47] = 870005003;
        arrn12[48] = 881301000;
        arrn12[49] = 881302000;
        arrn12[50] = 881303000;
        arrn12[51] = 881304000;
        arrn12[52] = 881305000;
        arrn12[53] = 881306000;
        arrn12[54] = 881307000;
        arrn12[55] = 870005501;
        arrn12[56] = 870005502;
        arrn12[57] = 870005503;
        arrn12[58] = 881411000;
        arrn12[59] = 881415000;
        arrn12[60] = 881502000;
        arrn12[61] = 881504000;
        arrn12[62] = 881505000;
        arrn12[63] = 881506000;
        arrn12[64] = 881701000;
        arrn12[65] = 881702000;
        arrn12[66] = 881703000;
        arrn12[67] = 881704000;
        arrn12[68] = 881705000;
        arrn12[69] = 881706000;
        arrn12[70] = 881707000;
        arrn12[71] = 881708000;
        arrn12[72] = 881709000;
        arrn12[73] = 881710000;
        arrn12[74] = 881711000;
        arrn12[75] = 881712000;
        arrn12[76] = 881713000;
        arrn12[77] = 881714000;
        arrn12[78] = 881715000;
        arrn12[79] = 881716000;
        arrn12[80] = 870005707;
        arrn12[81] = 870005708;
        arrn12[82] = 870005751;
        arrn12[83] = 870005752;
        arrn12[84] = 990000000;
        arrn12[85] = 990000100;
        arrn12[86] = 990000200;
        arrn12[87] = 990000300;
        arrn12[88] = 990000301;
        arrn12[89] = 990000400;
        arrn12[90] = 990000401;
        arrn12[91] = 990000410;
        arrn12[92] = 990000420;
        arrn12[93] = 990000430;
        arrn12[94] = 990000431;
        arrn12[95] = 990000440;
        arrn12[96] = 990000500;
        arrn12[97] = 990000501;
        arrn12[98] = 990000502;
        arrn12[99] = 990000600;
        arrn12[100] = 990000610;
        arrn12[101] = 990000611;
        arrn12[102] = 990000620;
        arrn12[103] = 990000630;
        arrn12[104] = 990000631;
        arrn12[105] = 990000640;
        arrn12[106] = 990000641;
        arrn12[107] = 990000700;
        arrn12[108] = 990000800;
        arrn12[109] = 990000900;
        arrn12[110] = 990001000;
        arrn12[111] = 990001100;
        arrn12[112] = 990001101;
        arrn12[113] = 870005601;
        arrn12[114] = 870005602;
        arrn12[115] = 870005603;
        arrn12[116] = 870005604;
        arrn12[117] = 870005605;
        arrn12[118] = 870005606;
        arrn12[119] = 870005607;
        arrn12[120] = 870005608;
        arrn12[121] = 870005609;
        arrn12[122] = 870005610;
        arrn12[123] = 870005611;
        arrn12[124] = 881001000;
        arrn12[125] = 881001001;
        arrn12[126] = 881001002;
        arrn12[127] = 881001003;
        arrn12[128] = 881001004;
        arrn12[129] = 881001005;
        arrn12[130] = 881001006;
        arrn12[131] = 881001007;
        arrn12[132] = 881001008;
        arrn12[133] = 881001009;
        arrn12[134] = 881001010;
        arrn12[135] = 881001011;
        arrn12[136] = 881001012;
        arrn12[137] = 881001013;
        arrn12[138] = 881001014;
        arrn12[139] = 881001015;
        arrn12[140] = 870005761;
        arrn12[141] = 870005762;
        arrn12[142] = 870005763;
        arrn12[143] = 870005764;
        arrn12[144] = 870005765;
        arrn12[145] = 870005766;
        arrn12[146] = 870005767;
        arrn12[147] = 870005768;
        arrn12[148] = 870005769;
        arrn12[149] = 870005770;
        arrn12[150] = 870005771;
        arrn12[151] = 870005772;
        arrn12[152] = 870005773;
        arrn12[153] = 870005760;
        arrn12[154] = 103000800;
        arrn12[155] = 103000801;
        arrn12[156] = 103000802;
        arrn12[157] = 103000803;
        arrn12[158] = 103000804;
        arrn12[159] = 103000805;
        arrn12[160] = 103000890;
        arrn12[161] = 922010000;
        arrn12[162] = 922010100;
        arrn12[163] = 922010200;
        arrn12[164] = 922010300;
        arrn12[165] = 922010400;
        arrn12[166] = 922010500;
        arrn12[167] = 922010600;
        arrn12[168] = 922010700;
        arrn12[169] = 922010800;
        arrn12[170] = 922010900;
        arrn12[171] = 922011000;
        arrn12[172] = 922011100;
        arrn12[173] = 922010201;
        arrn12[174] = 922010401;
        arrn12[175] = 922010402;
        arrn12[176] = 922010403;
        arrn12[177] = 922010404;
        arrn12[178] = 922010405;
        arrn12[179] = 922010501;
        arrn12[180] = 922010502;
        arrn12[181] = 922010503;
        arrn12[182] = 922010504;
        arrn12[183] = 922010505;
        arrn12[184] = 922010506;
        arrn12[185] = 930000000;
        arrn12[186] = 930000100;
        arrn12[187] = 930000200;
        arrn12[188] = 930000300;
        arrn12[189] = 930000400;
        arrn12[190] = 930000500;
        arrn12[191] = 930000510;
        arrn12[192] = 930000520;
        arrn12[193] = 930000530;
        arrn12[194] = 930000540;
        arrn12[195] = 930000550;
        arrn12[196] = 930000600;
        arrn12[197] = 930000700;
        arrn12[198] = 930000800;
        arrn12[199] = 930000900;
        arrn12[200] = 920010400;
        arrn12[201] = 920010500;
        arrn12[202] = 920010600;
        arrn12[203] = 920010601;
        arrn12[204] = 920010602;
        arrn12[205] = 920010603;
        arrn12[206] = 920010604;
        arrn12[207] = 920010700;
        arrn12[208] = 920010800;
        arrn12[209] = 920010900;
        arrn12[210] = 920010910;
        arrn12[211] = 920010911;
        arrn12[212] = 920010912;
        arrn12[213] = 920010920;
        arrn12[214] = 920010921;
        arrn12[215] = 920010922;
        arrn12[216] = 920010930;
        arrn12[217] = 920010931;
        arrn12[218] = 920010932;
        arrn12[219] = 920011000;
        arrn12[220] = 920011100;
        arrn12[221] = 920011200;
        arrn12[222] = 920011300;
        arrn12[223] = 920010000;
        arrn12[224] = 920010100;
        arrn12[225] = 920010300;
        arrn12[226] = 925100000;
        arrn12[227] = 925100100;
        arrn12[228] = 925100200;
        arrn12[229] = 925100201;
        arrn12[230] = 925100202;
        arrn12[231] = 925100300;
        arrn12[232] = 925100301;
        arrn12[233] = 925100302;
        arrn12[234] = 925100400;
        arrn12[235] = 925100500;
        arrn12[236] = 925100600;
        arrn12[237] = 925100700;
        arrn12[238] = 926100000;
        arrn12[239] = 926100001;
        arrn12[240] = 926100100;
        arrn12[241] = 926100200;
        arrn12[242] = 926100201;
        arrn12[243] = 926100202;
        arrn12[244] = 926100203;
        arrn12[245] = 926100300;
        arrn12[246] = 926100301;
        arrn12[247] = 926100302;
        arrn12[248] = 926100303;
        arrn12[249] = 926100304;
        arrn12[250] = 926100400;
        arrn12[251] = 926100401;
        arrn12[252] = 926100500;
        arrn12[253] = 926100600;
        arrn12[254] = 926100700;
        arrn12[255] = 882000001;
        arrn12[256] = 882000002;
        arrn12[257] = 882000003;
        arrn12[258] = 882000004;
        arrn12[259] = 882000005;
        arrn12[260] = 882000006;
        arrn12[261] = 882000007;
        arrn12[262] = 882000008;
        arrn12[263] = 882000009;
        arrn12[264] = 882000010;
        arrn12[265] = 882000011;
        arrn12[266] = 882000012;
        arrn12[267] = 882000013;
        arrn12[268] = 882000014;
        arrn12[269] = 882000015;
        arrn12[270] = 882000016;
        arrn12[271] = 882000017;
        arrn12[272] = 882000018;
        arrn12[273] = 882000019;
        arrn12[274] = 882000020;
        arrn12[275] = 882000021;
        arrn12[276] = 882000022;
        arrn12[277] = 882000023;
        arrn12[278] = 882000024;
        arrn12[279] = 882000025;
        arrn12[280] = 882000026;
        arrn12[281] = 882000027;
        arrn12[282] = 882000028;
        arrn12[283] = 882000029;
        arrn12[284] = 882000030;
        arrn12[285] = 882000031;
        arrn12[286] = 882000032;
        arrn12[287] = 882000033;
        arrn12[288] = 882000034;
        arrn12[289] = 882000035;
        arrn12[290] = 882000036;
        arrn12[291] = 882000037;
        arrn12[292] = 882000038;
        arrn12[293] = 882000039;
        arrn12[294] = 882000040;
        arrn12[295] = 882000041;
        arrn12[296] = 882000042;
        arrn12[297] = 882000043;
        arrn12[298] = 882000044;
        arrn12[299] = 882000045;
        arrn12[300] = 882000046;
        arrn12[301] = 882000047;
        arrn12[302] = 882000048;
        arrn12[303] = 882000049;
        arrn12[304] = 882000050;
        arrn12[305] = 882000000;
        arrn12[306] = 882000100;
        arrn12[307] = 882000200;
        arrn12[308] = 882000300;
        arrn12[309] = 882000400;
        arrn12[310] = 882000500;
        arrn12[311] = 882000600;
        arrn12[312] = 882000700;
        arrn12[313] = 882000800;
        arrn12[314] = 882000900;
        blockedMaps = arrn12;
        String[] arrstring2 = new String[1];
        arrstring2[0] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"/d\u0013u\u001cm");
        RESERVED = arrstring2;
        String[] arrstring3 = new String[35];
        arrstring3[0] = MapleCharacterCards.ALLATORIxDEMO("x!o");
        arrstring3[1] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000fd\fM\u0018w\u0018m");
        arrstring3[2] = MapleCharacterCards.ALLATORIxDEMO("&i%F;n");
        arrstring3[3] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000fd\fR)S");
        arrstring3[4] = MapleCharacterCards.ALLATORIxDEMO("&i%H\u0011T");
        arrstring3[5] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000fd\fH3U");
        arrstring3[6] = MapleCharacterCards.ALLATORIxDEMO("&i%@\u0001G");
        arrstring3[7] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000fd\fQ2Q");
        arrstring3[8] = MapleCharacterCards.ALLATORIxDEMO("7m'd");
        arrstring3[9] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u001et\u000fr\u0018e");
        arrstring3[10] = MapleCharacterCards.ALLATORIxDEMO("\u007f!o7i'\u007f");
        arrstring3[11] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"r\u0018u4u\u0018l4E");
        arrstring3[12] = MapleCharacterCards.ALLATORIxDEMO("i%y=|\u0000~5h1N8c7g");
        arrstring3[13] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u0019t\u000f`\u001fh\u0011h\tx");
        arrstring3[14] = MapleCharacterCards.ALLATORIxDEMO("&m:h\u001b| e;b");
        arrstring3[15] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000f`\u0013e.u\u001cu");
        arrstring3[16] = MapleCharacterCards.ALLATORIxDEMO("a5\u007f i&@1z1`");
        arrstring3[17] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"s\u0018p.j\u0014m\u0011M\u0018w\u0018m");
        arrstring3[18] = MapleCharacterCards.ALLATORIxDEMO("i8i9H1j5y8x");
        arrstring3[19] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"h\u0013b/L<R");
        arrstring3[20] = MapleCharacterCards.ALLATORIxDEMO("e:o\u0006A\u0015J");
        arrstring3[21] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"h\u0013b/L<H");
        arrstring3[22] = MapleCharacterCards.ALLATORIxDEMO("e:o\u0006A\u0015@");
        arrstring3[23] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u001e`\u0013M\u0018w\u0018m");
        arrstring3[24] = MapleCharacterCards.ALLATORIxDEMO("\u007f?e8`");
        arrstring3[25] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u001ei\u001cs\u0010D%Q");
        arrstring3[26] = MapleCharacterCards.ALLATORIxDEMO("`=a=x1h\u0018z");
        arrstring3[27] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u0014l\u0019S");
        arrstring3[28] = MapleCharacterCards.ALLATORIxDEMO("n0^");
        arrstring3[29] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"r\bq\u0018s\u0014n\u000fD\fq");
        arrstring3[30] = MapleCharacterCards.ALLATORIxDEMO("9m,_!|1~=c&I%|");
        arrstring3[31] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"s\u0018b\u0012w\u0018s");
        arrstring3[32] = MapleCharacterCards.ALLATORIxDEMO("~1\u007f1x");
        arrstring3[33] = \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\rd\u000fg\u0018b\tS\u0018r\u0018u");
        arrstring3[34] = MapleCharacterCards.ALLATORIxDEMO("1j2i7x\u001dx1a\u001dH");
        stats = arrstring3;
        int[] arrn13 = new int[1];
        arrn13[0] = 0x111EE1;
        Equipments_Bonus = arrn13;
        int[] arrn14 = new int[10];
        arrn14[0] = 0;
        arrn14[1] = 3000;
        arrn14[2] = 6000;
        arrn14[3] = 12000;
        arrn14[4] = 24000;
        arrn14[5] = 48000;
        arrn14[6] = 960000;
        arrn14[7] = 192000;
        arrn14[8] = 384000;
        arrn14[9] = 768000;
        K = arrn14;
        int[] arrn15 = new int[102];
        arrn15[0] = 0;
        arrn15[1] = 20;
        arrn15[2] = 46;
        arrn15[3] = 80;
        arrn15[4] = 124;
        arrn15[5] = 181;
        arrn15[6] = 255;
        arrn15[7] = 351;
        arrn15[8] = 476;
        arrn15[9] = 639;
        arrn15[10] = 851;
        arrn15[11] = 1084;
        arrn15[12] = 1340;
        arrn15[13] = 1622;
        arrn15[14] = 1932;
        arrn15[15] = 2273;
        arrn15[16] = 2648;
        arrn15[17] = 3061;
        arrn15[18] = 3515;
        arrn15[19] = 4014;
        arrn15[20] = 4563;
        arrn15[21] = 5128;
        arrn15[22] = 5710;
        arrn15[23] = 6309;
        arrn15[24] = 6926;
        arrn15[25] = 7562;
        arrn15[26] = 8217;
        arrn15[27] = 8892;
        arrn15[28] = 9587;
        arrn15[29] = 10303;
        arrn15[30] = 11040;
        arrn15[31] = 11788;
        arrn15[32] = 12547;
        arrn15[33] = 13307;
        arrn15[34] = 14089;
        arrn15[35] = 14883;
        arrn15[36] = 15689;
        arrn15[37] = 16507;
        arrn15[38] = 17337;
        arrn15[39] = 18179;
        arrn15[40] = 19034;
        arrn15[41] = 19902;
        arrn15[42] = 20783;
        arrn15[43] = 21677;
        arrn15[44] = 22584;
        arrn15[45] = 23505;
        arrn15[46] = 24440;
        arrn15[47] = 25399;
        arrn15[48] = 26362;
        arrn15[49] = 27339;
        arrn15[50] = 28331;
        arrn15[51] = 29338;
        arrn15[52] = 30360;
        arrn15[53] = 31397;
        arrn15[54] = 32450;
        arrn15[55] = 33519;
        arrn15[56] = 34604;
        arrn15[57] = 35705;
        arrn15[58] = 36823;
        arrn15[59] = 37958;
        arrn15[60] = 39110;
        arrn15[61] = 40279;
        arrn15[62] = 41466;
        arrn15[63] = 32671;
        arrn15[64] = 43894;
        arrn15[65] = 45135;
        arrn15[66] = 46395;
        arrn15[67] = 47674;
        arrn15[68] = 48972;
        arrn15[69] = 50289;
        arrn15[70] = 51626;
        arrn15[71] = 52967;
        arrn15[72] = 54312;
        arrn15[73] = 55661;
        arrn15[74] = 57014;
        arrn15[75] = 58371;
        arrn15[76] = 59732;
        arrn15[77] = 61097;
        arrn15[78] = 62466;
        arrn15[79] = 63839;
        arrn15[80] = 65216;
        arrn15[81] = 66597;
        arrn15[82] = 67982;
        arrn15[83] = 69371;
        arrn15[84] = 70764;
        arrn15[85] = 72161;
        arrn15[86] = 73562;
        arrn15[87] = 74967;
        arrn15[88] = 76376;
        arrn15[89] = 77789;
        arrn15[90] = 79206;
        arrn15[91] = 80627;
        arrn15[92] = 82052;
        arrn15[93] = 83481;
        arrn15[94] = 84914;
        arrn15[95] = 86351;
        arrn15[96] = 87792;
        arrn15[97] = 89237;
        arrn15[98] = 90686;
        arrn15[99] = 92139;
        arrn15[100] = 93596;
        arrn15[101] = 96000;
        a = arrn15;
        int[] arrn16 = new int[199];
        arrn16[0] = 0;
        arrn16[1] = 15;
        arrn16[2] = 20;
        arrn16[3] = 25;
        arrn16[4] = 35;
        arrn16[5] = 50;
        arrn16[6] = 65;
        arrn16[7] = 80;
        arrn16[8] = 95;
        arrn16[9] = 110;
        arrn16[10] = 125;
        arrn16[11] = 150;
        arrn16[12] = 175;
        arrn16[13] = 200;
        arrn16[14] = 225;
        arrn16[15] = 250;
        arrn16[16] = 275;
        arrn16[17] = 300;
        arrn16[18] = 325;
        arrn16[19] = 350;
        arrn16[20] = 375;
        arrn16[21] = 405;
        arrn16[22] = 435;
        arrn16[23] = 465;
        arrn16[24] = 495;
        arrn16[25] = 525;
        arrn16[26] = 580;
        arrn16[27] = 650;
        arrn16[28] = 720;
        arrn16[29] = 790;
        arrn16[30] = 900;
        arrn16[31] = 990;
        arrn16[32] = 1100;
        arrn16[33] = 1200;
        arrn16[34] = 1300;
        arrn16[35] = 1400;
        arrn16[36] = 1500;
        arrn16[37] = 1600;
        arrn16[38] = 1700;
        arrn16[39] = 1800;
        arrn16[40] = 1900;
        arrn16[41] = 2000;
        arrn16[42] = 2100;
        arrn16[43] = 2200;
        arrn16[44] = 2300;
        arrn16[45] = 2400;
        arrn16[46] = 2520;
        arrn16[47] = 2640;
        arrn16[48] = 2760;
        arrn16[49] = 2880;
        arrn16[50] = 3000;
        arrn16[51] = 3200;
        arrn16[52] = 3400;
        arrn16[53] = 3600;
        arrn16[54] = 3800;
        arrn16[55] = 4000;
        arrn16[56] = 4300;
        arrn16[57] = 4600;
        arrn16[58] = 4900;
        arrn16[59] = 5200;
        arrn16[60] = 5500;
        arrn16[61] = 5900;
        arrn16[62] = 6300;
        arrn16[63] = 6700;
        arrn16[64] = 7100;
        arrn16[65] = 7500;
        arrn16[66] = 8000;
        arrn16[67] = 8500;
        arrn16[68] = 9000;
        arrn16[69] = 9500;
        arrn16[70] = 10000;
        arrn16[71] = 11000;
        arrn16[72] = 12000;
        arrn16[73] = 13000;
        arrn16[74] = 14000;
        arrn16[75] = 15000;
        arrn16[76] = 17000;
        arrn16[77] = 19000;
        arrn16[78] = 21000;
        arrn16[79] = 23000;
        arrn16[80] = 25000;
        arrn16[81] = 27000;
        arrn16[82] = 29000;
        arrn16[83] = 31000;
        arrn16[84] = 33000;
        arrn16[85] = 35000;
        arrn16[86] = 37000;
        arrn16[87] = 39000;
        arrn16[88] = 41000;
        arrn16[89] = 43000;
        arrn16[90] = 45000;
        arrn16[91] = 47000;
        arrn16[92] = 49000;
        arrn16[93] = 51000;
        arrn16[94] = 53000;
        arrn16[95] = 55000;
        arrn16[96] = 57000;
        arrn16[97] = 59000;
        arrn16[98] = 61000;
        arrn16[99] = 63000;
        arrn16[100] = 65000;
        arrn16[101] = 67000;
        arrn16[102] = 69000;
        arrn16[103] = 71000;
        arrn16[104] = 73000;
        arrn16[105] = 75000;
        arrn16[106] = 77000;
        arrn16[107] = 79000;
        arrn16[108] = 81000;
        arrn16[109] = 83000;
        arrn16[110] = 85000;
        arrn16[111] = 89000;
        arrn16[112] = 91000;
        arrn16[113] = 93000;
        arrn16[114] = 95000;
        arrn16[115] = 97000;
        arrn16[116] = 99000;
        arrn16[117] = 101000;
        arrn16[118] = 103000;
        arrn16[119] = 105000;
        arrn16[120] = 107000;
        arrn16[121] = 109000;
        arrn16[122] = 111000;
        arrn16[123] = 113000;
        arrn16[124] = 115000;
        arrn16[125] = 118000;
        arrn16[126] = 120000;
        arrn16[127] = 125000;
        arrn16[128] = 130000;
        arrn16[129] = 135000;
        arrn16[130] = 140000;
        arrn16[131] = 145000;
        arrn16[132] = 150000;
        arrn16[133] = 155000;
        arrn16[134] = 160000;
        arrn16[135] = 165000;
        arrn16[136] = 170000;
        arrn16[137] = 175000;
        arrn16[138] = 180000;
        arrn16[139] = 185000;
        arrn16[140] = 190000;
        arrn16[141] = 195000;
        arrn16[142] = 200000;
        arrn16[143] = 205000;
        arrn16[144] = 210000;
        arrn16[145] = 215000;
        arrn16[146] = 220000;
        arrn16[147] = 225000;
        arrn16[148] = 230000;
        arrn16[149] = 235000;
        arrn16[150] = 240000;
        arrn16[151] = 250000;
        arrn16[152] = 260000;
        arrn16[153] = 270000;
        arrn16[154] = 280000;
        arrn16[155] = 290000;
        arrn16[156] = 300000;
        arrn16[157] = 310000;
        arrn16[158] = 320000;
        arrn16[159] = 330000;
        arrn16[160] = 340000;
        arrn16[161] = 350000;
        arrn16[162] = 360000;
        arrn16[163] = 370000;
        arrn16[164] = 380000;
        arrn16[165] = 390000;
        arrn16[166] = 400000;
        arrn16[167] = 410000;
        arrn16[168] = 420000;
        arrn16[169] = 430000;
        arrn16[170] = 440000;
        arrn16[171] = 450000;
        arrn16[172] = 460000;
        arrn16[173] = 470000;
        arrn16[174] = 480000;
        arrn16[175] = 490000;
        arrn16[176] = 500000;
        arrn16[177] = 510000;
        arrn16[178] = 520000;
        arrn16[179] = 530000;
        arrn16[180] = 550000;
        arrn16[181] = 570000;
        arrn16[182] = 590000;
        arrn16[183] = 610000;
        arrn16[184] = 630000;
        arrn16[185] = 650000;
        arrn16[186] = 670000;
        arrn16[187] = 690000;
        arrn16[188] = 710000;
        arrn16[189] = 730000;
        arrn16[190] = 750000;
        arrn16[191] = 770000;
        arrn16[192] = 790000;
        arrn16[193] = 810000;
        arrn16[194] = 830000;
        arrn16[195] = 850000;
        arrn16[196] = 870000;
        arrn16[197] = 890000;
        arrn16[198] = 910000;
        d = arrn16;
        int[] arrn17 = new int[10];
        arrn17[0] = 0;
        arrn17[1] = 20000;
        arrn17[2] = 160000;
        arrn17[3] = 540000;
        arrn17[4] = 1280000;
        arrn17[5] = 2500000;
        arrn17[6] = 4320000;
        arrn17[7] = 6860000;
        arrn17[8] = 10240000;
        arrn17[9] = 14580000;
        ALLATORIxDEMO = arrn17;
        int[] arrn18 = new int[102];
        arrn18[0] = 1302059;
        arrn18[1] = 3;
        arrn18[2] = 1402037;
        arrn18[3] = 1;
        arrn18[4] = 1092049;
        arrn18[5] = 1;
        arrn18[6] = 1102041;
        arrn18[7] = 1;
        arrn18[8] = 1432018;
        arrn18[9] = 3;
        arrn18[10] = 1022047;
        arrn18[11] = 3;
        arrn18[12] = 1432011;
        arrn18[13] = 3;
        arrn18[14] = 1442020;
        arrn18[15] = 3;
        arrn18[16] = 1382035;
        arrn18[17] = 3;
        arrn18[18] = 1372010;
        arrn18[19] = 3;
        arrn18[20] = 1332027;
        arrn18[21] = 3;
        arrn18[22] = 1302056;
        arrn18[23] = 3;
        arrn18[24] = 1402005;
        arrn18[25] = 3;
        arrn18[26] = 1472053;
        arrn18[27] = 3;
        arrn18[28] = 1462018;
        arrn18[29] = 3;
        arrn18[30] = 1452017;
        arrn18[31] = 3;
        arrn18[32] = 1422013;
        arrn18[33] = 3;
        arrn18[34] = 1322029;
        arrn18[35] = 3;
        arrn18[36] = 1412010;
        arrn18[37] = 3;
        arrn18[38] = 1472051;
        arrn18[39] = 1;
        arrn18[40] = 1482013;
        arrn18[41] = 1;
        arrn18[42] = 1492013;
        arrn18[43] = 1;
        arrn18[44] = 1382050;
        arrn18[45] = 1;
        arrn18[46] = 1382045;
        arrn18[47] = 1;
        arrn18[48] = 1382047;
        arrn18[49] = 1;
        arrn18[50] = 1382048;
        arrn18[51] = 1;
        arrn18[52] = 1382046;
        arrn18[53] = 1;
        arrn18[54] = 1442018;
        arrn18[55] = 3;
        arrn18[56] = 1332032;
        arrn18[57] = 4;
        arrn18[58] = 1482025;
        arrn18[59] = 3;
        arrn18[60] = 2290096;
        arrn18[61] = 1;
        arrn18[62] = 2290049;
        arrn18[63] = 1;
        arrn18[64] = 2290041;
        arrn18[65] = 1;
        arrn18[66] = 2290047;
        arrn18[67] = 1;
        arrn18[68] = 2290095;
        arrn18[69] = 1;
        arrn18[70] = 2290017;
        arrn18[71] = 1;
        arrn18[72] = 2290075;
        arrn18[73] = 1;
        arrn18[74] = 2290085;
        arrn18[75] = 1;
        arrn18[76] = 2290116;
        arrn18[77] = 1;
        arrn18[78] = 2049100;
        arrn18[79] = 1;
        arrn18[80] = 2040914;
        arrn18[81] = 1;
        arrn18[82] = 2040900;
        arrn18[83] = 4;
        arrn18[84] = 2030008;
        arrn18[85] = 5;
        arrn18[86] = 2000005;
        arrn18[87] = 10;
        arrn18[88] = 2000004;
        arrn18[89] = 10;
        arrn18[90] = 3010051;
        arrn18[91] = 1;
        arrn18[92] = 3010020;
        arrn18[93] = 1;
        arrn18[94] = 4001011;
        arrn18[95] = 4;
        arrn18[96] = 4001010;
        arrn18[97] = 4;
        arrn18[98] = 4001009;
        arrn18[99] = 4;
        arrn18[100] = 4280000;
        arrn18[101] = 4;
        goldrewards = arrn18;
        int[] arrn19 = new int[96];
        arrn19[0] = 1002452;
        arrn19[1] = 3;
        arrn19[2] = 1002455;
        arrn19[3] = 3;
        arrn19[4] = 1102082;
        arrn19[5] = 1;
        arrn19[6] = 1302049;
        arrn19[7] = 1;
        arrn19[8] = 1102041;
        arrn19[9] = 1;
        arrn19[10] = 1452019;
        arrn19[11] = 2;
        arrn19[12] = 1022060;
        arrn19[13] = 2;
        arrn19[14] = 1432011;
        arrn19[15] = 3;
        arrn19[16] = 1442020;
        arrn19[17] = 3;
        arrn19[18] = 1382035;
        arrn19[19] = 3;
        arrn19[20] = 1372010;
        arrn19[21] = 3;
        arrn19[22] = 1332027;
        arrn19[23] = 3;
        arrn19[24] = 1302056;
        arrn19[25] = 3;
        arrn19[26] = 1402005;
        arrn19[27] = 3;
        arrn19[28] = 1472053;
        arrn19[29] = 3;
        arrn19[30] = 1462018;
        arrn19[31] = 3;
        arrn19[32] = 1452017;
        arrn19[33] = 3;
        arrn19[34] = 1422013;
        arrn19[35] = 3;
        arrn19[36] = 1322029;
        arrn19[37] = 3;
        arrn19[38] = 1412010;
        arrn19[39] = 3;
        arrn19[40] = 1002587;
        arrn19[41] = 3;
        arrn19[42] = 1402044;
        arrn19[43] = 1;
        arrn19[44] = 1442046;
        arrn19[45] = 1;
        arrn19[46] = 1422031;
        arrn19[47] = 1;
        arrn19[48] = 1332054;
        arrn19[49] = 3;
        arrn19[50] = 1012056;
        arrn19[51] = 3;
        arrn19[52] = 1022047;
        arrn19[53] = 3;
        arrn19[54] = 1442012;
        arrn19[55] = 3;
        arrn19[56] = 1442018;
        arrn19[57] = 3;
        arrn19[58] = 1432010;
        arrn19[59] = 3;
        arrn19[60] = 2290084;
        arrn19[61] = 1;
        arrn19[62] = 2290048;
        arrn19[63] = 1;
        arrn19[64] = 2290040;
        arrn19[65] = 1;
        arrn19[66] = 2290046;
        arrn19[67] = 1;
        arrn19[68] = 2290074;
        arrn19[69] = 1;
        arrn19[70] = 2290064;
        arrn19[71] = 1;
        arrn19[72] = 2290094;
        arrn19[73] = 1;
        arrn19[74] = 2290022;
        arrn19[75] = 1;
        arrn19[76] = 2290056;
        arrn19[77] = 1;
        arrn19[78] = 2290066;
        arrn19[79] = 1;
        arrn19[80] = 2290020;
        arrn19[81] = 1;
        arrn19[82] = 2000005;
        arrn19[83] = 10;
        arrn19[84] = 2000004;
        arrn19[85] = 10;
        arrn19[86] = 3010041;
        arrn19[87] = 1;
        arrn19[88] = 3012002;
        arrn19[89] = 1;
        arrn19[90] = 4001116;
        arrn19[91] = 3;
        arrn19[92] = 4001012;
        arrn19[93] = 3;
        arrn19[94] = 4280001;
        arrn19[95] = 4;
        silverrewards = arrn19;
        int[] arrn20 = new int[6];
        arrn20[0] = 0;
        arrn20[1] = 40;
        arrn20[2] = 1;
        arrn20[3] = 10;
        arrn20[4] = 4031019;
        arrn20[5] = 5;
        eventCommonReward = arrn20;
        int[] arrn21 = new int[102];
        arrn21[0] = 2;
        arrn21[1] = 4;
        arrn21[2] = 3;
        arrn21[3] = 4;
        arrn21[4] = 5160000;
        arrn21[5] = 5;
        arrn21[6] = 5160001;
        arrn21[7] = 5;
        arrn21[8] = 5160002;
        arrn21[9] = 5;
        arrn21[10] = 5160003;
        arrn21[11] = 5;
        arrn21[12] = 5160004;
        arrn21[13] = 5;
        arrn21[14] = 5160005;
        arrn21[15] = 5;
        arrn21[16] = 5160006;
        arrn21[17] = 5;
        arrn21[18] = 5160007;
        arrn21[19] = 5;
        arrn21[20] = 5160008;
        arrn21[21] = 5;
        arrn21[22] = 5160009;
        arrn21[23] = 5;
        arrn21[24] = 5160010;
        arrn21[25] = 5;
        arrn21[26] = 5160011;
        arrn21[27] = 5;
        arrn21[28] = 5160012;
        arrn21[29] = 5;
        arrn21[30] = 5160013;
        arrn21[31] = 5;
        arrn21[32] = 5240017;
        arrn21[33] = 5;
        arrn21[34] = 5240000;
        arrn21[35] = 5;
        arrn21[36] = 4080000;
        arrn21[37] = 5;
        arrn21[38] = 4080001;
        arrn21[39] = 5;
        arrn21[40] = 4080002;
        arrn21[41] = 5;
        arrn21[42] = 4080003;
        arrn21[43] = 5;
        arrn21[44] = 4080004;
        arrn21[45] = 5;
        arrn21[46] = 4080005;
        arrn21[47] = 5;
        arrn21[48] = 4080006;
        arrn21[49] = 5;
        arrn21[50] = 4080007;
        arrn21[51] = 5;
        arrn21[52] = 4080008;
        arrn21[53] = 5;
        arrn21[54] = 4080009;
        arrn21[55] = 5;
        arrn21[56] = 4080010;
        arrn21[57] = 5;
        arrn21[58] = 4080011;
        arrn21[59] = 5;
        arrn21[60] = 4080100;
        arrn21[61] = 5;
        arrn21[62] = 4031019;
        arrn21[63] = 5;
        arrn21[64] = 5121003;
        arrn21[65] = 5;
        arrn21[66] = 5150000;
        arrn21[67] = 5;
        arrn21[68] = 5150001;
        arrn21[69] = 5;
        arrn21[70] = 5150002;
        arrn21[71] = 1;
        arrn21[72] = 5150003;
        arrn21[73] = 1;
        arrn21[74] = 5150004;
        arrn21[75] = 1;
        arrn21[76] = 5150005;
        arrn21[77] = 2;
        arrn21[78] = 5150006;
        arrn21[79] = 2;
        arrn21[80] = 5150007;
        arrn21[81] = 2;
        arrn21[82] = 5150008;
        arrn21[83] = 2;
        arrn21[84] = 5150009;
        arrn21[85] = 14;
        arrn21[86] = 2022459;
        arrn21[87] = 5;
        arrn21[88] = 2022460;
        arrn21[89] = 5;
        arrn21[90] = 2022461;
        arrn21[91] = 5;
        arrn21[92] = 2022462;
        arrn21[93] = 5;
        arrn21[94] = 2022463;
        arrn21[95] = 5;
        arrn21[96] = 2450000;
        arrn21[97] = 2;
        arrn21[98] = 5152000;
        arrn21[99] = 5;
        arrn21[100] = 5152001;
        arrn21[101] = 5;
        eventUncommonReward = arrn21;
        int[] arrn22 = new int[46];
        arrn22[0] = 4031019;
        arrn22[1] = 5;
        arrn22[2] = 2049100;
        arrn22[3] = 5;
        arrn22[4] = 2049401;
        arrn22[5] = 10;
        arrn22[6] = 2049301;
        arrn22[7] = 20;
        arrn22[8] = 2049400;
        arrn22[9] = 3;
        arrn22[10] = 3010130;
        arrn22[11] = 5;
        arrn22[12] = 3010131;
        arrn22[13] = 5;
        arrn22[14] = 3010132;
        arrn22[15] = 5;
        arrn22[16] = 3010133;
        arrn22[17] = 5;
        arrn22[18] = 3010136;
        arrn22[19] = 5;
        arrn22[20] = 3010116;
        arrn22[21] = 5;
        arrn22[22] = 3010117;
        arrn22[23] = 5;
        arrn22[24] = 3010118;
        arrn22[25] = 5;
        arrn22[26] = 1112405;
        arrn22[27] = 1;
        arrn22[28] = 2040211;
        arrn22[29] = 1;
        arrn22[30] = 2040212;
        arrn22[31] = 1;
        arrn22[32] = 2049000;
        arrn22[33] = 2;
        arrn22[34] = 2049001;
        arrn22[35] = 2;
        arrn22[36] = 2049002;
        arrn22[37] = 2;
        arrn22[38] = 1012058;
        arrn22[39] = 2;
        arrn22[40] = 1012059;
        arrn22[41] = 2;
        arrn22[42] = 1012060;
        arrn22[43] = 2;
        arrn22[44] = 1012061;
        arrn22[45] = 2;
        eventRareReward = arrn22;
        int[] arrn23 = new int[18];
        arrn23[0] = 4031019;
        arrn23[1] = 5;
        arrn23[2] = 4031307;
        arrn23[3] = 50;
        arrn23[4] = 3010127;
        arrn23[5] = 10;
        arrn23[6] = 3010128;
        arrn23[7] = 10;
        arrn23[8] = 3010137;
        arrn23[9] = 10;
        arrn23[10] = 2049300;
        arrn23[11] = 10;
        arrn23[12] = 1012139;
        arrn23[13] = 10;
        arrn23[14] = 1012140;
        arrn23[15] = 10;
        arrn23[16] = 1012141;
        arrn23[17] = 10;
        eventSuperReward = arrn23;
        int[] arrn24 = new int[93];
        arrn24[0] = 2040002;
        arrn24[1] = 2040005;
        arrn24[2] = 2040026;
        arrn24[3] = 2040031;
        arrn24[4] = 2040100;
        arrn24[5] = 2040105;
        arrn24[6] = 2040200;
        arrn24[7] = 2040205;
        arrn24[8] = 2040302;
        arrn24[9] = 2040310;
        arrn24[10] = 2040318;
        arrn24[11] = 2040323;
        arrn24[12] = 2040328;
        arrn24[13] = 2040329;
        arrn24[14] = 2040330;
        arrn24[15] = 2040331;
        arrn24[16] = 2040402;
        arrn24[17] = 2040412;
        arrn24[18] = 2040419;
        arrn24[19] = 2040422;
        arrn24[20] = 2040427;
        arrn24[21] = 2040502;
        arrn24[22] = 2040505;
        arrn24[23] = 2040514;
        arrn24[24] = 2040517;
        arrn24[25] = 2040534;
        arrn24[26] = 2040602;
        arrn24[27] = 2040612;
        arrn24[28] = 2040619;
        arrn24[29] = 2040622;
        arrn24[30] = 2040627;
        arrn24[31] = 2040702;
        arrn24[32] = 2040705;
        arrn24[33] = 2040708;
        arrn24[34] = 2040727;
        arrn24[35] = 2040802;
        arrn24[36] = 2040805;
        arrn24[37] = 2040816;
        arrn24[38] = 2040825;
        arrn24[39] = 2040902;
        arrn24[40] = 2040915;
        arrn24[41] = 2040920;
        arrn24[42] = 2040925;
        arrn24[43] = 2040928;
        arrn24[44] = 2040933;
        arrn24[45] = 2041002;
        arrn24[46] = 2041005;
        arrn24[47] = 2041008;
        arrn24[48] = 2041011;
        arrn24[49] = 2041014;
        arrn24[50] = 2041017;
        arrn24[51] = 2041020;
        arrn24[52] = 2041023;
        arrn24[53] = 2041058;
        arrn24[54] = 2041102;
        arrn24[55] = 2041105;
        arrn24[56] = 2041108;
        arrn24[57] = 2041111;
        arrn24[58] = 2041302;
        arrn24[59] = 2041305;
        arrn24[60] = 2041308;
        arrn24[61] = 2041311;
        arrn24[62] = 2043002;
        arrn24[63] = 2043008;
        arrn24[64] = 2043019;
        arrn24[65] = 2043102;
        arrn24[66] = 2043114;
        arrn24[67] = 2043202;
        arrn24[68] = 2043214;
        arrn24[69] = 2043302;
        arrn24[70] = 2043402;
        arrn24[71] = 2043702;
        arrn24[72] = 2043802;
        arrn24[73] = 2044002;
        arrn24[74] = 2044014;
        arrn24[75] = 2044015;
        arrn24[76] = 2044102;
        arrn24[77] = 2044114;
        arrn24[78] = 2044202;
        arrn24[79] = 2044214;
        arrn24[80] = 2044302;
        arrn24[81] = 2044314;
        arrn24[82] = 2044402;
        arrn24[83] = 2044414;
        arrn24[84] = 2044502;
        arrn24[85] = 2044602;
        arrn24[86] = 2044702;
        arrn24[87] = 2044802;
        arrn24[88] = 2044809;
        arrn24[89] = 2044902;
        arrn24[90] = 2045302;
        arrn24[91] = 2048002;
        arrn24[92] = 2048005;
        tenPercent = arrn24;
        int[] arrn25 = new int[66];
        arrn25[0] = 0;
        arrn25[1] = 40;
        arrn25[2] = 1;
        arrn25[3] = 40;
        arrn25[4] = 1302021;
        arrn25[5] = 5;
        arrn25[6] = 1072238;
        arrn25[7] = 1;
        arrn25[8] = 1072239;
        arrn25[9] = 1;
        arrn25[10] = 2049100;
        arrn25[11] = 1;
        arrn25[12] = 1302000;
        arrn25[13] = 3;
        arrn25[14] = 1442011;
        arrn25[15] = 1;
        arrn25[16] = 4031627;
        arrn25[17] = 2;
        arrn25[18] = 4031628;
        arrn25[19] = 1;
        arrn25[20] = 4031630;
        arrn25[21] = 1;
        arrn25[22] = 4031631;
        arrn25[23] = 1;
        arrn25[24] = 4031632;
        arrn25[25] = 1;
        arrn25[26] = 4031633;
        arrn25[27] = 2;
        arrn25[28] = 4031634;
        arrn25[29] = 1;
        arrn25[30] = 4031635;
        arrn25[31] = 1;
        arrn25[32] = 4031636;
        arrn25[33] = 1;
        arrn25[34] = 4031637;
        arrn25[35] = 2;
        arrn25[36] = 4031638;
        arrn25[37] = 2;
        arrn25[38] = 4031639;
        arrn25[39] = 1;
        arrn25[40] = 4031640;
        arrn25[41] = 1;
        arrn25[42] = 4031641;
        arrn25[43] = 2;
        arrn25[44] = 4031642;
        arrn25[45] = 2;
        arrn25[46] = 4031643;
        arrn25[47] = 1;
        arrn25[48] = 4031644;
        arrn25[49] = 1;
        arrn25[50] = 4031645;
        arrn25[51] = 2;
        arrn25[52] = 4031646;
        arrn25[53] = 2;
        arrn25[54] = 4031647;
        arrn25[55] = 1;
        arrn25[56] = 4031648;
        arrn25[57] = 1;
        arrn25[58] = 4031629;
        arrn25[59] = 1;
        arrn25[60] = 1102041;
        arrn25[61] = 1;
        arrn25[62] = 1102042;
        arrn25[63] = 1;
        arrn25[64] = 2101120;
        arrn25[65] = 1;
        fishingReward = arrn25;
        int[] arrn26 = new int[6];
        arrn26[0] = 20300223;
        arrn26[1] = 1;
        arrn26[2] = 20300221;
        arrn26[3] = 1;
        arrn26[4] = 20300275;
        arrn26[5] = 1;
        xmaxsReward = arrn26;
        int[] arrn27 = new int[94];
        arrn27[0] = 4001009;
        arrn27[1] = 4001010;
        arrn27[2] = 4001011;
        arrn27[3] = 4001012;
        arrn27[4] = 4001013;
        arrn27[5] = 4001014;
        arrn27[6] = 4001021;
        arrn27[7] = 4001038;
        arrn27[8] = 4001039;
        arrn27[9] = 4001040;
        arrn27[10] = 4001041;
        arrn27[11] = 4001042;
        arrn27[12] = 4001043;
        arrn27[13] = 4001038;
        arrn27[14] = 4001039;
        arrn27[15] = 4001040;
        arrn27[16] = 4001041;
        arrn27[17] = 4001042;
        arrn27[18] = 4001043;
        arrn27[19] = 4001038;
        arrn27[20] = 4001039;
        arrn27[21] = 4001040;
        arrn27[22] = 4001041;
        arrn27[23] = 4001042;
        arrn27[24] = 4001043;
        arrn27[25] = 4000164;
        arrn27[26] = 2000000;
        arrn27[27] = 2000003;
        arrn27[28] = 2000004;
        arrn27[29] = 2000005;
        arrn27[30] = 4000019;
        arrn27[31] = 4000000;
        arrn27[32] = 4000016;
        arrn27[33] = 4000006;
        arrn27[34] = 2100121;
        arrn27[35] = 4000029;
        arrn27[36] = 4000064;
        arrn27[37] = 5110000;
        arrn27[38] = 4000306;
        arrn27[39] = 4032181;
        arrn27[40] = 4006001;
        arrn27[41] = 4006000;
        arrn27[42] = 2050004;
        arrn27[43] = 3994102;
        arrn27[44] = 3994103;
        arrn27[45] = 3994104;
        arrn27[46] = 3994105;
        arrn27[47] = 2430007;
        arrn27[48] = 4000164;
        arrn27[49] = 2000000;
        arrn27[50] = 2000003;
        arrn27[51] = 2000004;
        arrn27[52] = 2000005;
        arrn27[53] = 4000019;
        arrn27[54] = 4000000;
        arrn27[55] = 4000016;
        arrn27[56] = 4000006;
        arrn27[57] = 2100121;
        arrn27[58] = 4000029;
        arrn27[59] = 4000064;
        arrn27[60] = 5110000;
        arrn27[61] = 4000306;
        arrn27[62] = 4032181;
        arrn27[63] = 4006001;
        arrn27[64] = 4006000;
        arrn27[65] = 2050004;
        arrn27[66] = 3994102;
        arrn27[67] = 3994103;
        arrn27[68] = 3994104;
        arrn27[69] = 3994105;
        arrn27[70] = 2430007;
        arrn27[71] = 4000164;
        arrn27[72] = 2000000;
        arrn27[73] = 2000003;
        arrn27[74] = 2000004;
        arrn27[75] = 2000005;
        arrn27[76] = 4000019;
        arrn27[77] = 4000000;
        arrn27[78] = 4000016;
        arrn27[79] = 4000006;
        arrn27[80] = 2100121;
        arrn27[81] = 4000029;
        arrn27[82] = 4000064;
        arrn27[83] = 5110000;
        arrn27[84] = 4000306;
        arrn27[85] = 4032181;
        arrn27[86] = 4006001;
        arrn27[87] = 4006000;
        arrn27[88] = 2050004;
        arrn27[89] = 3994102;
        arrn27[90] = 3994103;
        arrn27[91] = 3994104;
        arrn27[92] = 3994105;
        arrn27[93] = 2430007;
        normalDrops = arrn27;
        int[] arrn28 = new int[8];
        arrn28[0] = 2049100;
        arrn28[1] = 2049301;
        arrn28[2] = 2049401;
        arrn28[3] = 2022326;
        arrn28[4] = 2022193;
        arrn28[5] = 2049000;
        arrn28[6] = 2049001;
        arrn28[7] = 2049002;
        rareDrops = arrn28;
        int[] arrn29 = new int[3];
        arrn29[0] = 2040804;
        arrn29[1] = 2049400;
        arrn29[2] = 2049100;
        superDrops = arrn29;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ boolean isMountItemAvailable(int a2, int a3) {
        if (GameSetConstants.MOUNT_UNLIMIT) {
            return true;
        }
        if (a3 != 900 && a2 / 10000 == 190) {
            switch (a2) {
                case 1902000: 
                case 1902001: 
                case 1902002: {
                    return GameConstants.isAdventurer(a3);
                }
                case 1902005: 
                case 1902006: 
                case 1902007: {
                    return GameConstants.isKOC(a3);
                }
                case 1902015: 
                case 1902016: 
                case 1902017: 
                case 1902018: {
                    return GameConstants.isAran(a3);
                }
                case 1902040: 
                case 1902041: 
                case 1902042: {
                    return GameConstants.isEvan(a3);
                }
            }
            if (GameConstants.isResist(a3)) {
                return false;
            }
        }
        return a2 / 10000 == 190;
    }

    public static /* synthetic */ boolean isTablet(int a2) {
        return a2 / 1000 == 2047;
    }

    public static /* synthetic */ int getStatChance() {
        return 25;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isReverseItem(int a2) {
        switch (a2) {
            case 1002790: 
            case 1002791: 
            case 1002792: 
            case 1002793: 
            case 1002794: 
            case 0x100E00: 
            case 0x100E01: 
            case 1052162: 
            case 1052163: 
            case 1052164: 
            case 1072361: 
            case 1072362: 
            case 1072363: 
            case 1072364: 
            case 1072365: 
            case 1082239: 
            case 1082240: 
            case 1082241: 
            case 1082242: 
            case 1082243: 
            case 1302086: 
            case 1312038: 
            case 1322061: 
            case 1332075: 
            case 1332076: 
            case 1342012: 
            case 1372045: 
            case 1382059: 
            case 1402047: 
            case 1412034: 
            case 1422038: 
            case 1432049: 
            case 1442067: 
            case 1452059: 
            case 1462051: 
            case 1472071: 
            case 1482024: 
            case 1492025: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int getMasterySkill(int a2) {
        if (a2 >= 1410 && a2 <= 1412) {
            return 14100000;
        }
        if (a2 >= 410 && a2 <= 412) {
            return 4100000;
        }
        if (a2 >= 520 && a2 <= 522) {
            return 5200000;
        }
        return 0;
    }

    public static /* synthetic */ boolean isAllowedPotentialStat(int a2, boolean a3) {
        int n2 = a2 / 1000 % 10;
        return (!a3 || n2 == 2) && (a3 || n2 != 2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isFriendshipRing(int a2) {
        switch (a2) {
            case 1049000: 
            case 1112800: 
            case 1112801: 
            case 1112802: 
            case 1112804: 
            case 1112810: 
            case 1112811: 
            case 1112812: 
            case 1112813: 
            case 1112814: 
            case 1112815: 
            case 1112816: 
            case 1112817: 
            case 1112822: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getPartyPlay(int a2) {
        switch (a2) {
            case 300010000: 
            case 300010100: 
            case 300010200: 
            case 300010300: 
            case 300010400: 
            case 300020000: 
            case 300020100: 
            case 300020200: 
            case 300030000: 
            case 683070400: 
            case 683070401: 
            case 683070402: {
                return 25;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isElseSkill(int a2) {
        switch (a2) {
            case 1009: 
            case 1020: 
            case 3221001: 
            case 4211006: 
            case 10001009: 
            case 10001020: 
            case 20001009: 
            case 20001020: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isGun(int a2) {
        return a2 >= 1492000 && a2 < 1500000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getSkillBook(int a2, int a3) {
        if (a2 >= 2210 && a2 <= 2218) {
            return a2 - 2209;
        }
        switch (a2) {
            case 2300: 
            case 2310: 
            case 2311: 
            case 2312: 
            case 3100: 
            case 3110: 
            case 3111: 
            case 3112: 
            case 3200: 
            case 3210: 
            case 3211: 
            case 3212: 
            case 3300: 
            case 3310: 
            case 3311: 
            case 3312: 
            case 3500: 
            case 3510: 
            case 3511: 
            case 3512: {
                if (a3 <= 30) {
                    return 0;
                }
                if (a3 >= 31 && a3 <= 70) {
                    return 1;
                }
                if (a3 >= 71 && a3 <= 120) {
                    return 2;
                }
                if (a3 >= 120) {
                    return 3;
                }
                return 0;
            }
        }
        return 0;
    }

    public static /* synthetic */ int getBookLevel(int a2) {
        return 5 * a2 * (a2 + 1);
    }

    public static /* synthetic */ boolean isNoDelaySkill(int a2) {
        return a2 == 5110001 || a2 == 21101003 || a2 == 15100004 || a2 == 2111007 || a2 == 2211007 || a2 == 2311007 || a2 == 32121003 || a2 == 35121005 || a2 == 35111004 || a2 == 35121013 || a2 == 35121003 || a2 == 22150004 || a2 == 22181004 || a2 == 11101002 || a2 == 51100002 || a2 == 13101002 || a2 == 24121000 || a2 == 112001008 || a2 == 22161005 || a2 == 22161005;
    }

    public static /* synthetic */ double getAttackRange(Point a2, Point a32) {
        double d2 = 160000.0;
        int n2 = Math.max(Math.abs(a2 == null ? 0 : a2.x), Math.abs(a32 == null ? 0 : a32.x));
        int a32 = Math.max(Math.abs(a2 == null ? 0 : a2.y), Math.abs(a32 == null ? 0 : a32.y));
        int n3 = n2;
        int n4 = a32;
        return (d2 += (double)(n3 * n3 + n4 * n4)) + 120000.0;
    }

    public static /* synthetic */ int getReverseRequiredEXP(int a2) {
        return 60 + a2 * 5;
    }

    public static /* synthetic */ boolean isThrowingStar(int a2) {
        return a2 / 10000 == 207;
    }

    public static final /* synthetic */ short getCharacter3rdJobLevel(int a2) {
        if (!(GameSetConstants.MAPLE_VERSION < 152 || JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(a2) || JobConstants.is\u7c73\u54c8\u9038(a2) || JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a2))) {
            return 60;
        }
        return 70;
    }

    public static /* synthetic */ boolean isAngel(int a2) {
        return JobConstants.isBeginnerJob(a2 / 10000) && (a2 % 10000 == 1085 || a2 % 10000 == 1087 || a2 % 10000 == 1090 || a2 % 10000 == 1179);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getChairEffect(int a2) {
        switch (a2) {
            case 3015998: {
                return 1933391;
            }
            case 3010075: {
                return 1933019;
            }
            case 3010086: {
                return 1933025;
            }
            case 0x2DEE2D: {
                return 1933024;
            }
            case 3010117: {
                return 1933006;
            }
            case 3010118: {
                return 1933005;
            }
            case 3010123: {
                return 1933021;
            }
            case 3010125: {
                return 1933017;
            }
            case 3010141: {
                return 1933002;
            }
            case 3010142: {
                return 1933003;
            }
            case 3010145: {
                return 1933022;
            }
            case 3010146: {
                return 1933022;
            }
            case 3010151: {
                return 1933007;
            }
            case 3010153: {
                return 1933009;
            }
            case 3010156: {
                return 1933008;
            }
            case 3010162: {
                return 1933010;
            }
            case 3010163: {
                return 1933013;
            }
            case 3010164: {
                return 1933013;
            }
            case 3010166: {
                return 1933011;
            }
            case 3010167: {
                return 1933002;
            }
            case 3010183: {
                return 1933012;
            }
            case 3010204: {
                return 1933026;
            }
            case 3010217: {
                return 1933027;
            }
            case 3010219: {
                return 1933028;
            }
            case 3010220: {
                return 1933029;
            }
            case 3010221: {
                return 1933030;
            }
            case 3010226: {
                return 1933031;
            }
            case 3010230: {
                return 1933002;
            }
            case 3010241: {
                return 1933019;
            }
            case 3010242: {
                return 1933007;
            }
            case 3010253: {
                return 1933013;
            }
            case 3010255: {
                return 1933022;
            }
            case 3010266: {
                return 1933933;
            }
            case 3010279: {
                return 1933352;
            }
            case 3010282: {
                return 1933035;
            }
            case 3010283: {
                return 1933036;
            }
            case 3010284: {
                return 1933037;
            }
            case 0x2DEEED: {
                return 1933099;
            }
            case 0x2DEEEE: {
                return 1933038;
            }
            case 3010287: {
                return 1933039;
            }
            case 3010299: {
                return 1933006;
            }
            case 3010304: {
                return 1933028;
            }
            case 3010305: {
                return 1933032;
            }
            case 3010306: {
                return 1933021;
            }
            case 3010312: {
                return 1933040;
            }
            case 3010323: {
                return 1933000;
            }
            case 3010338: {
                return 1933008;
            }
            case 3010350: {
                return 1933006;
            }
            case 3010355: {
                return 1933042;
            }
            case 3010359: {
                return 1933035;
            }
            case 3010362: {
                return 1933043;
            }
            case 3010366: {
                return 1933028;
            }
            case 3010367: {
                return 1933004;
            }
            case 3010400: {
                return 1933042;
            }
            case 3010401: {
                return 1933041;
            }
            case 3010412: {
                return 1933028;
            }
            case 3010423: {
                return 1933371;
            }
            case 3010424: {
                return 1933046;
            }
            case 3010462: {
                return 1933047;
            }
            case 3010473: {
                return 1933003;
            }
            case 3010480: {
                return 1933006;
            }
            case 3010483: {
                return 1933020;
            }
            case 3010485: {
                return 1933012;
            }
            case 3010489: {
                return 1933023;
            }
            case 3010495: {
                return 1933049;
            }
            case 3010501: {
                return 1933352;
            }
            case 3010506: {
                return 1933352;
            }
            case 3010527: {
                return 1933004;
            }
            case 3010528: {
                return 1933007;
            }
            case 3010571: {
                return 1933371;
            }
            case 3010583: {
                return 1933050;
            }
            case 3010590: {
                return 1933051;
            }
            case 3010592: {
                return 1933099;
            }
            case 3010595: {
                return 1933052;
            }
            case 3010599: {
                return 1933053;
            }
            case 3010610: {
                return 1933054;
            }
            case 3010651: {
                return 1933056;
            }
            case 3010652: {
                return 1933057;
            }
            case 3010653: {
                return 1933058;
            }
            case 3010654: {
                return 1933059;
            }
            case 3010655: {
                return 1933060;
            }
            case 3010656: {
                return 1933061;
            }
            case 3010682: {
                return 1933047;
            }
            case 3010700: {
                return 1933064;
            }
            case 3010703: {
                return 1933043;
            }
            case 3010704: {
                return 1933065;
            }
            case 3010705: {
                return 1933352;
            }
            case 3010706: {
                return 1933005;
            }
            case 3010708: {
                return 1933066;
            }
            case 3010719: {
                return 1933069;
            }
            case 3010742: {
                return 1933072;
            }
            case 3010743: {
                return 1933073;
            }
            case 3010747: {
                return 1933075;
            }
            case 3010748: {
                return 1933076;
            }
            case 3010749: {
                return 1933077;
            }
            case 3010750: {
                return 1933078;
            }
            case 3010751: {
                return 1933079;
            }
            case 3010761: {
                return 1933080;
            }
            case 3010779: {
                return 1933082;
            }
            case 3010780: {
                return 1933081;
            }
            case 3010783: {
                return 1933083;
            }
            case 3010794: {
                return 1933084;
            }
            case 3010811: {
                return 1933087;
            }
            case 3010812: {
                return 1933085;
            }
            case 3010813: {
                return 1933086;
            }
            case 3010824: {
                return 1933089;
            }
            case 3010825: {
                return 1933090;
            }
            case 3010826: {
                return 1933091;
            }
            case 3010827: {
                return 1933092;
            }
            case 3010828: {
                return 1933093;
            }
            case 3010829: {
                return 1933094;
            }
            case 3010830: {
                return 1933095;
            }
            case 3010831: {
                return 1933096;
            }
            case 3010832: {
                return 1983097;
            }
            case 3010835: {
                return 1933098;
            }
            case 3010837: {
                return 1933103;
            }
            case 3010838: {
                return 1933102;
            }
            case 3010839: {
                return 1933067;
            }
            case 3010842: {
                return 1933099;
            }
            case 3010843: {
                return 1933100;
            }
            case 3010844: {
                return 1933101;
            }
            case 3010855: {
                return 1933028;
            }
            case 3010876: {
                return 1933105;
            }
            case 3010878: {
                return 1933106;
            }
            case 3010883: {
                return 1933036;
            }
            case 3010889: {
                return 1933010;
            }
            case 3010890: {
                return 1933011;
            }
            case 3010925: {
                return 1933080;
            }
            case 3010930: {
                return 1933038;
            }
            case 3010936: {
                return 1933107;
            }
            case 3010955: {
                int n2 = new Random().nextInt(100);
                if (n2 <= 50) {
                    return 1933047;
                }
                if (n2 > 50) {
                    return 1933049;
                }
                return 1933105;
            }
            case 3010964: {
                return 1933105;
            }
            case 3010969: {
                return 1933069;
            }
            case 3010980: {
                return 1933110;
            }
            case 3010988: {
                return 1933113;
            }
            case 3010989: {
                return 1933114;
            }
            case 3010990: {
                return 1933115;
            }
            case 3010991: {
                return 1933116;
            }
            case 3010992: {
                return 1933117;
            }
            case 3010993: {
                return 1933118;
            }
            case 3010994: {
                return 1933119;
            }
            case 3010995: {
                return 1933120;
            }
            case 3010996: {
                return 1933121;
            }
            case 3010997: {
                return 1933122;
            }
            case 3010998: {
                return 1933123;
            }
            case 3015000: {
                return 1933111;
            }
            case 3015002: {
                return 1933112;
            }
            case 3015008: {
                return 1933138;
            }
            case 3015013: {
                return 1933137;
            }
            case 3015014: {
                return 1933139;
            }
            case 3015015: {
                return 1933124;
            }
            case 3015016: {
                return 1933125;
            }
            case 3015017: {
                return 1933126;
            }
            case 3015018: {
                return 1933127;
            }
            case 3015019: {
                return 1933128;
            }
            case 3015020: {
                return 1933129;
            }
            case 3015021: {
                return 1933130;
            }
            case 3015022: {
                return 1933131;
            }
            case 3015023: {
                return 1933132;
            }
            case 3015024: {
                return 1933133;
            }
            case 3015025: {
                return 1933134;
            }
            case 3015026: {
                return 1933135;
            }
            case 3015027: {
                return 1933136;
            }
            case 3015031: {
                return 1933141;
            }
            case 3015035: {
                return 1933147;
            }
            case 3015048: {
                return 1933144;
            }
            case 3015049: {
                return 1933145;
            }
            case 3015050: {
                return 1933146;
            }
            case 3015999: {
                return 1933388;
            }
        }
        return 0;
    }

    public static /* synthetic */ int EntrustedStoreTax(int a2) {
        if (a2 >= 100000000) {
            return (int)Math.round(0.03 * (double)a2);
        }
        if (a2 >= 25000000) {
            return (int)Math.round(0.025 * (double)a2);
        }
        if (a2 >= 10000000) {
            return (int)Math.round(0.02 * (double)a2);
        }
        if (a2 >= 5000000) {
            return (int)Math.round(0.015 * (double)a2);
        }
        if (a2 >= 1000000) {
            return (int)Math.round(0.009 * (double)a2);
        }
        if (a2 >= 100000) {
            return (int)Math.round(0.004 * (double)a2);
        }
        return 0;
    }

    public static /* synthetic */ boolean canScroll(int a2) {
        return a2 / 100000 != 19 && a2 / 100000 != 16 || a2 / 1000 == 1672 && a2 != 1672030 && a2 != 1672031 && a2 != 1672032;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getCurseTablet(int a2, int a3) {
        switch (a2 % 1000 / 100) {
            case 2: {
                switch (a3) {
                    case 0: {
                        return 10;
                    }
                    case 1: {
                        return 12;
                    }
                    case 2: {
                        return 16;
                    }
                    case 3: {
                        return 20;
                    }
                    case 4: {
                        return 26;
                    }
                    case 5: {
                        return 33;
                    }
                    case 6: {
                        return 43;
                    }
                    case 7: {
                        return 55;
                    }
                    case 8: {
                        return 70;
                    }
                }
                return 100;
            }
            case 3: {
                switch (a3) {
                    case 0: {
                        return 12;
                    }
                    case 1: {
                        return 18;
                    }
                    case 2: {
                        return 35;
                    }
                    case 3: {
                        return 70;
                    }
                }
                return 100;
            }
        }
        switch (a3) {
            case 0: {
                return 10;
            }
            case 1: {
                return 14;
            }
            case 2: {
                return 19;
            }
            case 3: {
                return 26;
            }
            case 4: {
                return 36;
            }
            case 5: {
                return 50;
            }
            case 6: {
                return 70;
            }
        }
        return 100;
    }

    public static /* synthetic */ boolean isPickupRestricted(int a2) {
        return a2 == 4030003 || a2 == 4030004;
    }

    public static final /* synthetic */ short getCharacter1stJobLevel(int a2) {
        if (a2 == 200) {
            return 8;
        }
        return 10;
    }

    public static /* synthetic */ boolean isMagicWeapon(int a2) {
        int n2 = a2 / 10000;
        return n2 == 137 || n2 == 138;
    }

    public static /* synthetic */ int getGuildExpNeededForLevel(int a2) {
        if (a2 < 0 || a2 >= ALLATORIxDEMO.length) {
            return Integer.MAX_VALUE;
        }
        return ALLATORIxDEMO[a2];
    }

    public static /* synthetic */ boolean isCleanSlate(int a2) {
        return a2 / 100 == 20490;
    }

    public static /* synthetic */ Double maxViewRangeSq_() {
        return 2098176.0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int isMonsterRiding(int a2) {
        switch (a2) {
            case 1004: 
            case 10001004: 
            case 20001004: {
                return a2;
            }
        }
        return 0;
    }

    public static /* synthetic */ boolean isSpecialCard(int a2) {
        return a2 / 1000 >= 2388;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getStat(int a2, int a3) {
        switch (a2) {
            case 1002959: {
                return 25;
            }
            case 1142002: {
                return 10;
            }
            case 1122121: {
                return 7;
            }
        }
        return (short)a3;
    }

    public static /* synthetic */ boolean isMonsterCard(int a2) {
        return a2 / 10000 == 238;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isElementAmpSkill(int a2) {
        switch (a2) {
            case 2110001: 
            case 2210001: 
            case 12110001: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int getExpRate_Quest(MapleCharacter a2) {
        if (GameSetConstants.SERVER_NAME.equals(MapleCharacterCards.ALLATORIxDEMO("\u7387\u4e1f\u8c3b"))) {
            if (a2.getJob() == 0 || a2.getJob() == 1000 || a2.getJob() == 2000) {
                return 1;
            }
            return 10;
        }
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isTimelessItem(int a2) {
        switch (a2) {
            case 1002776: 
            case 1002777: 
            case 1002778: 
            case 1002779: 
            case 1002780: 
            case 1032031: 
            case 1052155: 
            case 1052156: 
            case 1052157: 
            case 1052158: 
            case 1052159: 
            case 1072355: 
            case 1072356: 
            case 1072357: 
            case 1072358: 
            case 1072359: 
            case 1082234: 
            case 1082235: 
            case 1082236: 
            case 1082237: 
            case 1082238: 
            case 1092057: 
            case 1092058: 
            case 1092059: 
            case 1102172: 
            case 1122011: 
            case 1122012: 
            case 1302081: 
            case 1312037: 
            case 1322060: 
            case 1332073: 
            case 1332074: 
            case 1342011: 
            case 1372044: 
            case 1382057: 
            case 1402046: 
            case 1412033: 
            case 1422037: 
            case 1432047: 
            case 1442063: 
            case 1452057: 
            case 1462050: 
            case 1472068: 
            case 1482023: 
            case 1492023: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isTwoHanded(int a2) {
        switch (1.d[GameConstants.getWeaponType(a2).ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ GameConstants() {
        GameConstants a2;
    }

    public static /* synthetic */ boolean isAran(int a2) {
        return a2 >= 2000 && a2 <= 2112 && a2 != 2001;
    }

    public static /* synthetic */ int getClosenessNeededForLevel(int a2) {
        return B[a2 - 1];
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean Novice_Skill(int a2) {
        switch (a2) {
            case 1000: 
            case 10001000: 
            case 20001000: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isNoSpawn(int a2) {
        return a2 == 809040100 || a2 == 925020010 || a2 == 925020011 || a2 == 925020012 || a2 == 925020013 || a2 == 925020014 || a2 == 980010000 || a2 == 980010100 || a2 == 980010200 || a2 == 980010300 || a2 == 980010020;
    }

    public static /* synthetic */ boolean isOverall(int a2) {
        return a2 / 10000 == 105;
    }

    public static final /* synthetic */ short getCharacter4thJobLevel(int a2) {
        if (!(GameSetConstants.MAPLE_VERSION < 152 || JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(a2) || JobConstants.is\u7c73\u54c8\u9038(a2) || JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a2))) {
            return 100;
        }
        return 120;
    }

    public static /* synthetic */ boolean isUpgradeScroll(int a2) {
        return a2 >= 2040000 && a2 < 2050000;
    }

    public static /* synthetic */ int getEnchantSstarts(int a2, boolean a3) {
        if (a2 >= 0 && a2 <= 94) {
            if (a3) {
                return 3;
            }
            return 5;
        }
        if (a2 > 94 && a2 <= 107) {
            if (a3) {
                return 5;
            }
            return 8;
        }
        if (a2 > 107 && a2 <= 117) {
            if (a3) {
                return 8;
            }
            return 10;
        }
        if (a2 > 117 && a2 <= 127) {
            if (a3) {
                return 10;
            }
            return 15;
        }
        if (a2 > 127 && a2 <= 137) {
            if (a3) {
                return 12;
            }
            return 20;
        }
        if (a2 > 137 && a2 <= 147) {
            if (a3) {
                return 15;
            }
            return 25;
        }
        if (a2 > 147) {
            if (a3) {
                return 15;
            }
            return 25;
        }
        return 0;
    }

    public static /* synthetic */ MapleInventoryType getInventoryType(int a2) {
        MapleInventoryType mapleInventoryType = MapleInventoryType.getByType((byte)(a2 / 1000000));
        if (mapleInventoryType == MapleInventoryType.UNDEFINED || mapleInventoryType == null) {
            switch ((byte)(a2 / 10000)) {
                case 2: 
                case 5: {
                    while (false) {
                    }
                    mapleInventoryType = MapleInventoryType.FACE;
                    return mapleInventoryType;
                }
                case 3: 
                case 4: {
                    mapleInventoryType = MapleInventoryType.HAIR;
                    return mapleInventoryType;
                }
            }
            mapleInventoryType = MapleInventoryType.UNDEFINED;
        }
        return mapleInventoryType;
    }

    public static /* synthetic */ int getJobNumber(int a2) {
        int n2 = a2 % 1000;
        if (n2 / 100 == 0 || GameConstants.isBeginnerJob(a2)) {
            return 0;
        }
        if (n2 / 10 % 10 == 0 || n2 == 501) {
            return 1;
        }
        return 2 + n2 % 10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isGMEquip(int a2) {
        switch (a2) {
            case 1002140: 
            case 1042003: 
            case 1062007: 
            case 1322013: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isSummonSack(int a2) {
        return a2 / 10000 == 210;
    }

    public static /* synthetic */ boolean isCarnivalMaps(int a2) {
        return a2 / 100000 == 9800 && (a2 % 10 == 1 || a2 % 1000 == 100);
    }

    public static /* synthetic */ boolean isCannon(int a2) {
        return a2 == 1 || a2 == 501 || a2 >= 530 && a2 <= 532;
    }

    public static /* synthetic */ short handleAttackDelayBuff(MapleCharacter a2, short a3) {
        boolean bl;
        boolean bl2 = false;
        if (a2.getBuffedValue(MapleBuffStat.BODY_PRESSURE) != null) {
            a3 = (short)(a3 / 6);
        }
        if (a2.getBuffedValue(MapleBuffStat.BOOSTER) != null) {
            if (a2.isWarrior()) {
                a3 = (short)((double)a3 / 1.21);
            } else if (a2.isMage()) {
                a3 = (short)((double)a3 / 1.14);
            } else if (a2.isBowman()) {
                a3 = (short)((double)a3 / 1.14);
            } else if (a2.isThief()) {
                a3 = (short)((double)a3 / 1.21);
            } else {
                short s2 = a3;
                a3 = a2.isPirate() ? (short)((double)s2 / 1.15) : (short)((double)s2 / 1.21);
            }
            bl2 = true;
        }
        boolean bl3 = GameSetConstants.MAPLE_VERSION >= 134 ? a2.getBuffedValue(MapleBuffStat.SPEED_INFUSION) != null : (bl = a2.getBuffedValue(MapleBuffStat.SPEED_INFUSION) != null);
        if (bl) {
            if (a2.isWarrior()) {
                if (!bl2) {
                    a3 = (short)((double)a3 / 1.21);
                    return a3;
                }
            } else if (a2.isMage()) {
                if (!bl2) {
                    a3 = (short)((double)a3 / 1.14);
                    return a3;
                }
            } else if (a2.isBowman()) {
                if (!bl2) {
                    a3 = (short)((double)a3 / 1.14);
                    return a3;
                }
            } else if (a2.isThief()) {
                if (!bl2) {
                    a3 = (short)((double)a3 / 1.21);
                    return a3;
                }
            } else {
                short s3 = a3;
                if (a2.isPirate()) {
                    a3 = (short)((double)s3 / 1.15);
                    return a3;
                }
                a3 = (short)((double)s3 / 1.21);
            }
        }
        return a3;
    }

    public static /* synthetic */ List<Balloon> getBalloons() {
        return GameSetConstants.lBalloon;
    }

    public static /* synthetic */ boolean isAdventurer(int a2) {
        return a2 >= 0 && a2 < 1000;
    }

    public static /* synthetic */ boolean isCustomReactItem(int a2, int a3, int a4) {
        if (a2 == 2008006) {
            return a3 == Calendar.getInstance().get(7) + 4001055;
        }
        return a3 == a4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getSlotMax(int a2) {
        switch (a2) {
            case 4030003: 
            case 4030004: 
            case 4030005: {
                return 1;
            }
            case 3993000: 
            case 3993002: 
            case 3993003: 
            case 4001168: 
            case 4031306: 
            case 4031307: {
                return 100;
            }
            case 5220010: 
            case 5220013: {
                return 1000;
            }
            case 5220020: {
                return 2000;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isDragonItem(int a2) {
        switch (a2) {
            case 1302059: 
            case 1312031: 
            case 1322052: 
            case 1332049: 
            case 1332050: 
            case 1342010: 
            case 1372032: 
            case 1382036: 
            case 1402036: 
            case 1412026: 
            case 1422028: 
            case 1432038: 
            case 1442045: 
            case 1452044: 
            case 1462039: 
            case 1472051: 
            case 1472052: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getMPByJob(MapleCharacter a2) {
        int n2 = 0;
        for (IItem iItem : a2.getInventory(MapleInventoryType.EQUIPPED).list()) {
            if (iItem.getItemId() / 1000 != 1099) continue;
            iItem = (Equip)iItem;
            n2 += ((Equip)iItem).getMp();
        }
        switch (a2.getJob()) {
            case 3100: {
                return 30 + n2;
            }
            case 3110: {
                return 50 + n2;
            }
            case 3111: {
                return 100 + n2;
            }
            case 3112: {
                return 120 + n2;
            }
        }
        return 30 + n2;
    }

    public static /* synthetic */ int getFishingTime(boolean a2, boolean a3) {
        if (GameSetConstants.SERVER_NAME.equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u8337\u834b\u8c36"))) {
            if (a3) {
                return 1000;
            }
            if (a2) {
                return 60000;
            }
            return 120000;
        }
        if (GameSetConstants.SERVER_NAME.equals(MapleCharacterCards.ALLATORIxDEMO("\u833a\u8362\u8c3b"))) {
            if (a3) {
                return 1000;
            }
            if (a2) {
                return 60000;
            }
            return 180000;
        }
        if (GameSetConstants.SERVER_NAME.equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u795f\u79a5\u8c36"))) {
            if (a3) {
                return 1000;
            }
            if (a2) {
                return 60000;
            }
            return 60000;
        }
        if (GameSetConstants.SERVER_NAME.equals(MapleCharacterCards.ALLATORIxDEMO("\u6613\u8054\u8c3b"))) {
            if (a3) {
                return 1000;
            }
            if (a2) {
                return 60000;
            }
            return 120000;
        }
        if (GameSetConstants.SERVER_NAME.equals(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u51b1\u82d2\u8c36"))) {
            return 120000;
        }
        if (a3) {
            return 1000;
        }
        if (a2) {
            return 120000;
        }
        return 240000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getLinkedAranSkill(int a2) {
        switch (a2) {
            case 21110007: 
            case 21110008: {
                return 21110002;
            }
            case 21120009: 
            case 21120010: {
                return 21120002;
            }
            case 4321001: {
                return 4321000;
            }
            case 33101006: 
            case 33101007: {
                return 33101005;
            }
            case 33101008: {
                return 33101004;
            }
            case 35101009: 
            case 35101010: {
                return 35100008;
            }
            case 35111009: 
            case 35111010: {
                return 35111001;
            }
        }
        return a2;
    }

    public static /* synthetic */ boolean isAccessoryScroll(int a2) {
        return a2 / 100 == 20492;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getRandAnimationBySkill(int a2) {
        int n2 = 0;
        switch (a2) {
            case 4341009: 
            case 5121004: 
            case 13111000: 
            case 13111006: 
            case 13111007: {
                return 1;
            }
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getXForStat(MonsterStatus a2) {
        switch (a2) {
            case ACC: {
                return -70;
            }
            case SPEED: {
                return -50;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getHpMp(int a2, int a3) {
        switch (a2) {
            case 1122121: {
                return 500;
            }
            case 1002959: 
            case 1142002: {
                return 1000;
            }
        }
        return (short)a3;
    }

    public static /* synthetic */ boolean isApplicableSkill_(int a2) {
        int n2;
        int[] arrn = PlayerStats.pvpSkills;
        int n3 = PlayerStats.pvpSkills.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = arrn[n2];
            if (a2 == n5) {
                return true;
            }
            n4 = ++n2;
        }
        return a2 >= 90000000 && a2 < 92000000 || a2 % 10000 >= 8000 && a2 % 10000 <= 8006 || GameConstants.isAngel(a2);
    }

    public static /* synthetic */ int getTimelessRequiredEXP(int a2) {
        return 70 + a2 * 10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getSummonAttackDelay(int a2) {
        switch (a2) {
            case 2121005: 
            case 2221005: 
            case 2311006: 
            case 2321003: 
            case 3111005: 
            case 3121006: 
            case 3211005: 
            case 3221005: 
            case 11001004: 
            case 12001004: 
            case 13001004: 
            case 14001005: 
            case 15001004: {
                return 3030;
            }
            case 5211001: 
            case 5211002: 
            case 5220002: {
                return 1530;
            }
            case 5321004: {
                return 800;
            }
            case 1321007: 
            case 3111002: 
            case 3211002: 
            case 5211014: 
            case 5211016: {
                return 0;
            }
        }
        return 0;
    }

    public static /* synthetic */ boolean isArrowForCrossBow(int a2) {
        return a2 >= 2061000 && a2 < 2062000;
    }

    public static /* synthetic */ boolean isBullet(int a2) {
        return a2 / 10000 == 233;
    }

    public static /* synthetic */ int getTaxAmount(int a2) {
        if (a2 >= 100000000) {
            return (int)Math.round(0.06 * (double)a2);
        }
        if (a2 >= 25000000) {
            return (int)Math.round(0.05 * (double)a2);
        }
        if (a2 >= 10000000) {
            return (int)Math.round(0.04 * (double)a2);
        }
        if (a2 >= 5000000) {
            return (int)Math.round(0.03 * (double)a2);
        }
        if (a2 >= 1000000) {
            return (int)Math.round(0.018 * (double)a2);
        }
        if (a2 >= 100000) {
            return (int)Math.round(0.008 * (double)a2);
        }
        return 0;
    }

    public static /* synthetic */ boolean isArrowForBow(int a2) {
        return a2 >= 2060000 && a2 < 2061000;
    }

    public static /* synthetic */ boolean isAccessory(int a2) {
        return a2 >= 1010000 && a2 < 1040000 || a2 >= 1122000 && a2 < 1153000 || a2 >= 1112000 && a2 < 1113000;
    }

    public static /* synthetic */ boolean isEvan(int a2) {
        return a2 == 2001 || a2 >= 2200 && a2 <= 2218;
    }

    public static /* synthetic */ int getCardShortId(int a2) {
        return a2 % 10000;
    }

    public static /* synthetic */ int getProfessionEXP(int a2) {
        if (a2 < 0 || a2 >= H.length) {
            return Integer.MAX_VALUE;
        }
        return H[a2];
    }

    public static /* synthetic */ boolean isEventMap(int a2) {
        return a2 >= 109010000 && a2 < 109050000 || a2 > 109050001 && a2 < 109090000 || a2 >= 809040000 && a2 <= 809040100;
    }

    public static /* synthetic */ boolean isWeapon(int a2) {
        return ItemConstants.\u985e\u578b.\u6b66\u5668((int)a2);
    }

    public static /* synthetic */ boolean isKOC(int a2) {
        return a2 >= 1000 && a2 < 2000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getCashBlockedMsg(int a2) {
        switch (a2) {
            case 5062000: {
                return \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u9018\u5076\u6770\u8902\u53eb\u8080\u901b\u9033\u81eb\u754c\u5e03\u5849\u73a8\u5bcbO-B");
            }
        }
        return MapleCharacterCards.ALLATORIxDEMO("\u904d\u5007\u9007\u517b\u7175\u6cd9\u8ca8\u8cbbY\u0006\u677e\u4f8a\u675d\u6a53\u6757\u9587\u656a\u8cf0\u8ce3\u300e");
    }

    public static /* synthetic */ int getJobShortValue(int a2) {
        if (a2 >= 1000) {
            int n2 = a2;
            a2 = n2 - n2 / 1000 * 1000;
        }
        switch (a2 /= 100) {
            case 4: {
                return a2 *= 2;
            }
            case 3: {
                ++a2;
                while (false) {
                }
                return a2;
            }
            case 5: {
                return a2 += 11;
            }
        }
        return a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ MapleWeaponType getWeaponType(int a2) {
        int n2 = a2 / 10000;
        switch (n2 %= 100) {
            case 21: {
                return MapleWeaponType.\u9583\u4eae\u514b\u9b6f;
            }
            case 22: {
                return MapleWeaponType.\u9748\u9b42\u5c04\u624b;
            }
            case 30: {
                return MapleWeaponType.\u55ae\u624b\u528d;
            }
            case 31: {
                return MapleWeaponType.\u55ae\u624b\u65a7;
            }
            case 32: {
                return MapleWeaponType.\u55ae\u624b\u68cd;
            }
            case 33: {
                return MapleWeaponType.\u77ed\u528d;
            }
            case 34: {
                return MapleWeaponType.\u96d9\u5200;
            }
            case 36: {
                return MapleWeaponType.\u624b\u6756;
            }
            case 38: {
                return MapleWeaponType.\u9577\u6756;
            }
            case 37: {
                return MapleWeaponType.\u77ed\u6756;
            }
            case 40: {
                return MapleWeaponType.\u96d9\u624b\u528d;
            }
            case 41: {
                return MapleWeaponType.\u96d9\u624b\u65a7;
            }
            case 42: {
                return MapleWeaponType.\u96d9\u624b\u68cd;
            }
            case 43: {
                return MapleWeaponType.\u69cd;
            }
            case 44: {
                return MapleWeaponType.\u77db;
            }
            case 45: {
                return MapleWeaponType.\u5f13;
            }
            case 46: {
                return MapleWeaponType.\u5f29;
            }
            case 47: {
                return MapleWeaponType.\u62f3\u5957;
            }
            case 48: {
                return MapleWeaponType.\u6307\u864e;
            }
            case 49: {
                return MapleWeaponType.\u706b\u69cd;
            }
            case 52: {
                return MapleWeaponType.\u96d9\u5f29;
            }
            case 53: {
                return MapleWeaponType.\u52a0\u8fb2\u7832;
            }
            case 54: {
                return MapleWeaponType.\u592a\u5200;
            }
            case 55: {
                return MapleWeaponType.\u6247\u5b50;
            }
            case 56: {
                return MapleWeaponType.\u7409;
            }
            case 57: {
                return MapleWeaponType.\u7483;
            }
        }
        return MapleWeaponType.\u6c92\u6709\u6b66\u5668;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isBeginnerJob(int a2) {
        switch (a2) {
            case 0: 
            case 1000: 
            case 2000: 
            case 2001: 
            case 2002: 
            case 2003: 
            case 2004: 
            case 2005: 
            case 3000: 
            case 3001: 
            case 3002: 
            case 4001: 
            case 4002: 
            case 5000: 
            case 6000: 
            case 6001: 
            case 10000: 
            case 11000: 
            case 13000: 
            case 14000: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getLinkedAttackSkill(int a2) {
        switch (a2) {
            case 11101220: {
                return 11101120;
            }
            case 11101221: {
                return 11101121;
            }
            case 11111120: {
                return 11111220;
            }
            case 11111121: {
                return 11111221;
            }
            case 11121102: 
            case 11121201: 
            case 11121202: {
                return 11121101;
            }
            case 11121103: {
                return 11121203;
            }
            case 21110007: 
            case 21110008: 
            case 21110015: {
                return 21110002;
            }
            case 21120009: 
            case 21120010: 
            case 21120015: {
                return 21120002;
            }
            case 4321001: {
                return 4321000;
            }
            case 32120055: {
                return 32120052;
            }
            case 33101006: 
            case 33101007: {
                return 33101005;
            }
            case 33101008: {
                return 33101004;
            }
            case 35101009: 
            case 35101010: {
                return 35100008;
            }
            case 35111009: 
            case 35111010: {
                return 35111001;
            }
            case 35121013: {
                return 35111004;
            }
            case 35121011: {
                return 35121009;
            }
            case 32001007: 
            case 32001008: 
            case 32001009: 
            case 32001010: 
            case 32001011: {
                return 32001001;
            }
            case 5300007: {
                return 5301001;
            }
            case 5320011: {
                return 5321004;
            }
            case 23101007: {
                return 23101001;
            }
            case 23111009: 
            case 23111010: {
                return 23111008;
            }
            case 31001006: 
            case 31001007: 
            case 31001008: {
                return 31000004;
            }
            case 30010183: 
            case 30010184: 
            case 30010186: {
                return 30010110;
            }
            case 31010004: 
            case 31010005: 
            case 31010006: 
            case 31010007: {
                return 31011000;
            }
            case 31201007: 
            case 31201008: 
            case 31201009: 
            case 31201010: {
                return 31201000;
            }
            case 31211007: 
            case 31211008: 
            case 31211009: 
            case 31211010: {
                return 31211000;
            }
            case 31221009: 
            case 31221010: 
            case 31221011: 
            case 31221012: {
                return 31221000;
            }
            case 5710012: {
                return 5711002;
            }
            case 5701012: 
            case 5710020: {
                return 5701011;
            }
            case 31121010: {
                return 31121000;
            }
            case 5211015: 
            case 5211016: {
                return 5211011;
            }
            case 24111008: {
                return 24111006;
            }
            case 24121010: {
                return 24121003;
            }
            case 5001008: {
                return 5001003;
            }
            case 5001009: {
                return 5101004;
            }
            case 41001004: 
            case 41001005: {
                return 41001000;
            }
            case 41001006: 
            case 41001007: 
            case 41001008: {
                return 41001002;
            }
            case 41101008: 
            case 41101009: {
                return 41101000;
            }
            case 41111011: 
            case 41111012: {
                return 41111000;
            }
            case 41120011: 
            case 41120012: 
            case 41120013: {
                return 41121000;
            }
            case 42001005: 
            case 42001006: {
                return 42001000;
            }
            case 42001007: {
                return 42001002;
            }
            case 42100010: {
                return 42101001;
            }
            case 101000102: {
                return 101000101;
            }
            case 101000202: {
                return 101000201;
            }
            case 0x606AAAA: {
                return 101100201;
            }
            case 101110201: {
                return 101110200;
            }
            case 101110204: {
                return 101110203;
            }
            case 101120101: {
                return 101120100;
            }
            case 101120103: {
                return 101120102;
            }
            case 101120105: 
            case 101120106: {
                return 101120104;
            }
            case 101120203: {
                return 101120202;
            }
            case 101120205: 
            case 101120206: {
                return 101120204;
            }
            case 101120200: {
                return 101121200;
            }
            case 112000001: 
            case 112000002: {
                return 112000000;
            }
            case 112120001: 
            case 112120002: 
            case 112120003: {
                return 112120000;
            }
            case 33111212: {
                return 33111112;
            }
            case 33101213: {
                return 33101113;
            }
            case 33001205: {
                return 33001105;
            }
            case 33100016: 
            case 33101215: {
                return 33101115;
            }
            case 2321055: {
                return 2321052;
            }
            case 61111217: {
                return 61101101;
            }
            case 61111219: {
                return 61111101;
            }
            case 61111220: {
                return 61111002;
            }
            case 61111215: {
                return 61001101;
            }
            case 112000019: {
                return 112000015;
            }
            case 61121221: 
            case 61121223: {
                return 61121104;
            }
            case 61120018: 
            case 61121222: {
                return 61121105;
            }
            case 10001253: 
            case 10001254: {
                return 10000252;
            }
            case 5710023: 
            case 5710024: 
            case 5710025: 
            case 5710026: {
                return 5710020;
            }
            case 11121055: {
                return 11121052;
            }
            case 5101014: {
                return 0x4DD5D4;
            }
            case 2120013: {
                return 2121007;
            }
            case 2220014: {
                return 2221007;
            }
            case 12001028: {
                return 0xB71B17;
            }
            case 12000026: {
                return 12001020;
            }
            case 12100028: 
            case 12101028: {
                return 12100020;
            }
            case 0xB8C8CC: 
            case 12111028: {
                return 12110020;
            }
            case 12120010: {
                return 12120006;
            }
            case 12121055: {
                return 12121054;
            }
            case 12120012: {
                return 12121003;
            }
            case 12120013: 
            case 12120014: {
                return 12121004;
            }
            case 21110003: {
                return 21111013;
            }
            case 21110006: {
                return 21111014;
            }
            case 21120005: {
                return 21121013;
            }
            case 5310011: {
                return 5311010;
            }
            case 12120011: {
                return 12121001;
            }
            case 112100001: {
                return 112100000;
            }
            case 21100002: {
                return 21101011;
            }
            case 21121055: 
            case 21121056: {
                return 21120052;
            }
            case 24120055: {
                return 24121052;
            }
            case 65111007: {
                return 65111100;
            }
            case 2121055: {
                return 2121052;
            }
            case 3120017: {
                return 3121016;
            }
            case 95001000: {
                return 3111013;
            }
            case 4210014: {
                return 4211006;
            }
            case 1320019: {
                return 1320016;
            }
            case 0x111711: {
                return 1121008;
            }
            case 4100012: {
                return 4100011;
            }
            case 0x3EDDD3: {
                return 4120018;
            }
            case 4221016: {
                return 4221014;
            }
            case 3000008: 
            case 3000009: 
            case 3000010: {
                return 3001007;
            }
            case 3120019: {
                return 3111009;
            }
            case 5111013: {
                return 5111002;
            }
            case 5111015: {
                return 5111012;
            }
            case 5121019: {
                return 5121001;
            }
            case 5121020: {
                return 5121007;
            }
            case 5121017: {
                return 5121016;
            }
            case 5201005: {
                return 5201011;
            }
            case 5201013: 
            case 5201014: {
                return 5201012;
            }
            case 5210016: 
            case 5210017: 
            case 5210018: {
                return 5210015;
            }
            case 5220023: 
            case 5221022: {
                return 5221004;
            }
            case 21000006: {
                return 21000002;
            }
            case 30011159: {
                return 30011109;
            }
            case 20010022: {
                return 80001000;
            }
            case 27120211: {
                return 27121201;
            }
            case 61001004: 
            case 61001005: 
            case 61110212: 
            case 61120219: {
                return 61001000;
            }
            case 61111111: {
                return 61111100;
            }
            case 61110009: {
                return 61111003;
            }
            case 61121116: {
                return 61121104;
            }
            case 61120008: {
                return 61111008;
            }
            case 61121203: {
                return 61121102;
            }
            case 61121201: {
                return 61121100;
            }
            case 61110211: {
                return 61101002;
            }
            case 61121217: {
                return 61120007;
            }
            case 65121007: 
            case 65121008: {
                return 65121101;
            }
            case 31011004: 
            case 31011005: 
            case 31011006: 
            case 31011007: {
                return 31011000;
            }
            case 31221014: {
                return 31221001;
            }
            case 36101008: 
            case 36101009: {
                return 36101000;
            }
            case 36111009: 
            case 36111010: {
                return 36111000;
            }
            case 36121013: 
            case 36121014: {
                return 36121002;
            }
            case 36121011: 
            case 36121012: {
                return 36121001;
            }
            case 11120010: {
                return 11120009;
            }
            case 11121011: 
            case 11121012: {
                return 11121005;
            }
            case 11121013: {
                return 11121004;
            }
            case 13100027: {
                return 13100022;
            }
            case 13110027: {
                return 13110022;
            }
            case 13120010: {
                return 13120003;
            }
            case 13121009: {
                return 13121002;
            }
            case 0x5F5E5F5: {
                return 100001266;
            }
            case 101110104: {
                return 101110102;
            }
            case 112000000: {
                return 110001501;
            }
            case 112100000: {
                return 110001502;
            }
            case 112111003: {
                return 110001503;
            }
            case 112120000: {
                return 110001504;
            }
            case 25000003: {
                return 25001002;
            }
            case 25000001: {
                return 25001000;
            }
            case 25100001: 
            case 25100002: {
                return 25101000;
            }
            case 25110001: 
            case 25110002: 
            case 25110003: {
                return 25111000;
            }
            case 25120001: 
            case 25120002: 
            case 25120003: {
                return 25121000;
            }
            case 25100010: {
                return 25100009;
            }
            case 25120115: {
                return 25120110;
            }
            case 14101021: {
                return 14101020;
            }
            case 14111021: {
                return 14111020;
            }
            case 14111023: {
                return 14111022;
            }
            case 14121002: {
                return 14121001;
            }
            case 131001001: 
            case 131001002: 
            case 131001003: 
            case 131001101: 
            case 131001102: 
            case 131001103: 
            case 131002000: {
                return 131001000;
            }
            case 131001013: 
            case 131001113: 
            case 131001213: 
            case 131001313: {
                return 131001013;
            }
            case 131001104: 
            case 131002004: {
                return 131001004;
            }
            case 131001106: 
            case 131001206: 
            case 131001306: 
            case 131001406: 
            case 131001506: {
                return 131001006;
            }
            case 131001107: 
            case 131001207: 
            case 131001307: {
                return 131001007;
            }
            case 131001108: 
            case 131001208: {
                return 131001008;
            }
            case 131001011: 
            case 131002010: {
                return 131001010;
            }
            case 131002012: {
                return 131001012;
            }
            case 131002014: {
                return 131000014;
            }
            case 131002015: {
                return 131001015;
            }
            case 131002016: {
                return 131000016;
            }
        }
        return a2;
    }

    public static /* synthetic */ int getMPEaterForJob(int a2) {
        switch (a2) {
            case 210: 
            case 211: 
            case 212: {
                while (false) {
                }
                return 0x200B20;
            }
            case 220: 
            case 221: 
            case 222: {
                return 2200000;
            }
            case 230: 
            case 231: 
            case 232: {
                return 2300000;
            }
        }
        return 0x200B20;
    }

    public static /* synthetic */ boolean isHarvesting(int a2) {
        return a2 >= 1500000 && a2 < 1520000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isCrushRing(int a2) {
        switch (a2) {
            case 1048000: 
            case 1048001: 
            case 1048002: 
            case 1112001: 
            case 1112002: 
            case 1112003: 
            case 1112005: 
            case 1112006: 
            case 1112007: 
            case 1112012: 
            case 1112013: 
            case 1112015: 
            case 1112016: 
            case 1112023: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isTownScroll(int a2) {
        return a2 >= 2030000 && a2 < 2040000;
    }

    public static /* synthetic */ boolean isUse(int a2) {
        return a2 >= 2000000 && a2 <= 3000000;
    }

    public static /* synthetic */ int getPartyPlay(int a2, int a3) {
        int n2 = GameConstants.getPartyPlay(a2);
        if (n2 > 0) {
            return n2;
        }
        return a3;
    }

    public static /* synthetic */ boolean isShield(int a2) {
        int n2 = a2 / 10000;
        return (n2 %= 100) == 9;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getDEF(int a2, int a3) {
        switch (a2) {
            case 1122121: {
                return 250;
            }
            case 1002959: {
                return 500;
            }
        }
        return (short)a3;
    }

    public static /* synthetic */ boolean isMercedes(int a2) {
        return a2 == 2002 || a2 >= 2300 && a2 <= 2312;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean CanAcceptQuest(int a2) {
        switch (a2) {
            case 2350: 
            case 3096: 
            case 3619: 
            case 6006: 
            case 6220: 
            case 6221: 
            case 6290: 
            case 6294: 
            case 6310: 
            case 6340: 
            case 6350: 
            case 6380: 
            case 6390: 
            case 8248: 
            case 8249: 
            case 8511: 
            case 8512: 
            case 8613: 
            case 8614: 
            case 8615: 
            case 8627: 
            case 21607: 
            case 22509: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isJobFamily(int a2, int a3) {
        return a3 >= a2 && a3 / 100 == a2 / 100;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getPartyPlayEXP(int a2) {
        if (GameSetConstants.MAPLE_VERSION < 228) {
            return 0;
        }
        switch (a2) {
            case 4250000: {
                return 5770;
            }
            case 4250001: {
                return 6160;
            }
            case 5250000: {
                return 7100;
            }
            case 5250001: {
                return 7975;
            }
            case 5250002: {
                return 8800;
            }
            case 9400661: {
                return 40000;
            }
            case 9400660: {
                return 70000;
            }
            case 9400659: {
                return 90000;
            }
            case 9400658: {
                return 50000;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getSkillBook(int a2) {
        if (a2 >= 2210 && a2 <= 2218) {
            return a2 - 2209;
        }
        switch (a2) {
            case 2310: 
            case 2410: 
            case 2710: 
            case 3110: 
            case 3210: 
            case 3310: 
            case 3510: 
            case 5110: 
            case 6110: 
            case 6510: {
                return 1;
            }
            case 2311: 
            case 2411: 
            case 2711: 
            case 3111: 
            case 3211: 
            case 3311: 
            case 3511: 
            case 5111: 
            case 6111: 
            case 6511: {
                return 2;
            }
            case 2312: 
            case 2412: 
            case 2712: 
            case 3112: 
            case 3212: 
            case 3312: 
            case 3512: 
            case 5112: 
            case 6112: 
            case 6512: {
                return 3;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ short getAttackDelayBySkill(int a2) {
        switch (a2) {
            case 3211004: {
                return 620;
            }
            case 5201002: {
                return 60;
            }
            case 3121004: 
            case 4221001: 
            case 5201006: 
            case 5221004: 
            case 13111002: {
                return 120;
            }
            case 13101005: {
                return 360;
            }
            case 3110001: 
            case 5001003: {
                return 450;
            }
            case 5001001: 
            case 15001001: {
                return 510;
            }
            case 0x111AEE: 
            case 1221007: 
            case 1321003: 
            case 5111002: 
            case 11001002: 
            case 11001003: 
            case 15101005: 
            case 15111001: {
                return 570;
            }
            case 1311004: 
            case 2301002: 
            case 4001334: 
            case 4111004: 
            case 11111004: 
            case 12101002: 
            case 13111000: 
            case 14001004: 
            case 14111002: 
            case 15101003: {
                return 600;
            }
            case 1001005: 
            case 4001344: 
            case 4101005: 
            case 4121007: 
            case 4201004: 
            case 4211004: 
            case 5001002: 
            case 15001002: {
                return 660;
            }
            case 4111005: 
            case 5201001: 
            case 5221007: {
                return 690;
            }
            case 1001004: 
            case 1211002: 
            case 1311005: 
            case 4201005: {
                return 720;
            }
            case 1121008: 
            case 1221009: 
            case 1311003: 
            case 3001004: 
            case 3001005: 
            case 3101003: 
            case 3101005: 
            case 3111003: 
            case 3111004: 
            case 3121003: 
            case 5201004: 
            case 5210000: 
            case 12001003: 
            case 12111006: 
            case 13001003: {
                return 750;
            }
            case 3111006: 
            case 3211006: 
            case 13111001: {
                return 650;
            }
            case 2221006: 
            case 3201005: 
            case 3211003: 
            case 3221007: 
            case 5220011: {
                return 780;
            }
            case 1000: 
            case 2001004: 
            case 2001005: 
            case 2101004: 
            case 2101005: 
            case 2121003: 
            case 2121006: 
            case 2201004: 
            case 2201005: 
            case 2221003: 
            case 2301005: 
            case 2321007: 
            case 5121007: 
            case 10001000: 
            case 15111007: 
            case 20001000: {
                return 810;
            }
            case 4211006: {
                return 840;
            }
            case 2121001: 
            case 2221001: 
            case 2321001: 
            case 5221008: 
            case 11101004: {
                return 870;
            }
            case 1311001: 
            case 1311002: 
            case 2111006: 
            case 2211006: 
            case 3221001: 
            case 5101002: 
            case 5211006: 
            case 13111006: 
            case 21000002: 
            case 21100004: {
                return 900;
            }
            case 4341002: 
            case 5121003: {
                return 930;
            }
            case 13111007: {
                return 960;
            }
            case 4121003: 
            case 4221003: 
            case 14101006: 
            case 15100004: {
                return 1020;
            }
            case 2211002: 
            case 2311004: 
            case 4211002: 
            case 5211004: 
            case 5211005: 
            case 12101006: {
                return 1050;
            }
            case 21110007: {
                return 1131;
            }
            case 4221007: {
                return 900;
            }
            case 5101003: 
            case 5121002: {
                return 1140;
            }
            case 5111004: 
            case 5121001: 
            case 15111004: {
                return 1170;
            }
            case 11111006: {
                return 1230;
            }
            case 12111005: 
            case 21110002: 
            case 21120010: {
                return 1260;
            }
            case 21120009: {
                return 1290;
            }
            case 1111008: 
            case 2211003: 
            case 5121005: {
                return 1320;
            }
            case 1311006: {
                return 1410;
            }
            case 4121008: {
                return 1440;
            }
            case 2111003: 
            case 5110001: 
            case 15111003: 
            case 21101003: {
                return 1500;
            }
            case 5101004: 
            case 21100001: {
                return 1560;
            }
            case 2111002: {
                return 1300;
            }
            case 21110003: {
                return 1710;
            }
            case 5111006: {
                return 1600;
            }
            case 21120005: {
                return 1890;
            }
            case 21100002: {
                return 2250;
            }
            case 2321008: {
                return 2700;
            }
            case 21120006: {
                return 2820;
            }
            case 1221011: {
                return 2910;
            }
            case 5121004: 
            case 5221003: {
                return 2700;
            }
            case 1011: 
            case 10001011: 
            case 12111003: 
            case 20001011: {
                return 3060;
            }
            case 2121007: 
            case 2221007: {
                return 3480;
            }
            case 1009: 
            case 10001009: 
            case 20001009: {
                return 3900;
            }
            case 1020: 
            case 10001020: 
            case 20001020: 
            case 20011020: {
                return 5000;
            }
        }
        return 0;
    }

    public static /* synthetic */ int getDiceStat(int a2, int a3) {
        if (a2 == a3 || a2 % 10 == a3 || a2 / 10 == a3) {
            return GameConstants.getStatDice(a3);
        }
        if (a2 == a3 * 100) {
            return GameConstants.getStatDice(a3) + 10;
        }
        return 0;
    }

    public static /* synthetic */ boolean isDagger(int a2) {
        return a2 / 10000 == 133;
    }

    public static /* synthetic */ int getTraitExpNeededForLevel(int a2) {
        if (a2 < 0 || a2 >= a.length) {
            return Integer.MAX_VALUE;
        }
        return a[a2];
    }

    public static /* synthetic */ boolean isDropRestricted(int a2) {
        return a2 == 3012000 || a2 == 4030004 || a2 == 1052098 || a2 == 1052202;
    }

    public static /* synthetic */ boolean isLinkedAranSkill(int a2) {
        return GameConstants.getLinkedAranSkill(a2) != a2;
    }

    public static /* synthetic */ int getMonsterHP(int a2) {
        if (a2 < 0 || a2 >= d.length) {
            return Integer.MAX_VALUE;
        }
        return d[a2];
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getSuccessTablet(int a2, int a3) {
        switch (a2 % 1000 / 100) {
            case 2: {
                switch (a3) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 55;
                    }
                    case 2: {
                        return 43;
                    }
                    case 3: {
                        return 33;
                    }
                    case 4: {
                        return 26;
                    }
                    case 5: {
                        return 20;
                    }
                    case 6: {
                        return 16;
                    }
                    case 7: {
                        return 12;
                    }
                    case 8: {
                        return 10;
                    }
                }
                return 7;
            }
            case 3: {
                switch (a3) {
                    case 0: {
                        return 70;
                    }
                    case 1: {
                        return 35;
                    }
                    case 2: {
                        return 18;
                    }
                    case 3: {
                        return 12;
                    }
                }
                return 7;
            }
        }
        switch (a3) {
            case 0: {
                return 70;
            }
            case 1: {
                return 50;
            }
            case 2: {
                return 36;
            }
            case 3: {
                return 26;
            }
            case 4: {
                return 19;
            }
            case 5: {
                return 14;
            }
            case 6: {
                return 10;
            }
        }
        return 7;
    }

    public static /* synthetic */ boolean isDualBlade(int a2) {
        return a2 >= 430 && a2 <= 434;
    }

    public static /* synthetic */ int maxViewRangeSq() {
        return 800000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int Equipment_Bonus_EXP(int a2) {
        switch (a2) {
            case 0x111EE1: {
                return 10;
            }
        }
        return 0;
    }

    public static /* synthetic */ boolean isEquip(int a2) {
        return a2 / 1000000 == 1;
    }

    public static /* synthetic */ boolean isApplicableSkill(int a2) {
        return (a2 < 80000000 || a2 >= 100000000) && (a2 % 10000 < 8000 || a2 % 10000 > 8006) && !GameConstants.isAngel(a2) || a2 >= 92000000 || a2 >= 80000000 && a2 < 80010000;
    }

    public static /* synthetic */ int getExpRate_Below10(int a2) {
        if (GameConstants.isAran(a2) || GameConstants.isKOC(a2)) {
            return 5;
        }
        return 1;
    }

    public static /* synthetic */ int getBofForJob(int a2) {
        return GameConstants.getSkillByJob(12, a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getModifier(int a2, int a3) {
        if (a3 <= 0) {
            return 0;
        }
        switch (a2) {
            case 2022459: 
            case 2860179: 
            case 2860193: 
            case 2860207: {
                return 130;
            }
            case 2022460: 
            case 2022462: 
            case 2022730: {
                return 150;
            }
            case 2860181: 
            case 2860195: 
            case 2860209: {
                return 200;
            }
        }
        if (a2 / 10000 == 286) {
            return 150;
        }
        return 200;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean canForfeit(int a2) {
        switch (a2) {
            case 20000: 
            case 20010: 
            case 20015: 
            case 20020: {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean isStampScroll(int a2) {
        return a2 == 2049500 || a2 == 2049501;
    }

    public static /* synthetic */ boolean isLinkedAttackSkill(int a2) {
        return GameConstants.getLinkedAttackSkill(a2) != a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean SkillDisableMap(int a2) {
        if (GameSetConstants.isSkillDisableMap(a2)) {
            return true;
        }
        switch (a2) {
            case 109010000: 
            case 749050500: 
            case 749050501: 
            case 749050502: {
                return true;
            }
        }
        return false;
    }

    public static class Balloon {
        public /* synthetic */ int y;
        public /* synthetic */ int x;
        public /* synthetic */ String msg;

        public /* synthetic */ Balloon(String a2, int a3, int a4) {
            Balloon a5;
            Balloon balloon = a5;
            a5.msg = a2;
            balloon.x = a3;
            balloon.y = a4;
        }
    }
}

