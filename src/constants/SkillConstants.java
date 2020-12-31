/*
 * Decompiled with CFR 0.150.
 */
package constants;

import client.ISkill;
import client.MapleCharacter;
import client.MapleJob;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.JobConstants;
import handling.opcodes.MapleBuffStat;
import java.util.LinkedList;
import tools.Pair;

public class SkillConstants {
    public static final /* synthetic */ int[] luminous_lightSkills;
    public static final /* synthetic */ int[] rankS;
    public static final /* synthetic */ int[] rankB;
    public static final /* synthetic */ int[] rankA;
    public static final /* synthetic */ int[] luminous_darkSkills;
    public static final /* synthetic */ int[] rankC;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isBanKeyMapSkill(int a2) {
        if (!GameSetConstants.BAN_ARAN_KEY_MAP) {
            return false;
        }
        switch (a2) {
            case 21000000: 
            case 21000002: 
            case 21100001: 
            case 21100002: 
            case 21100004: 
            case 21100005: 
            case 21110000: 
            case 21110002: 
            case 21110003: 
            case 21110004: 
            case 21110006: 
            case 21110007: 
            case 21110008: 
            case 21120001: 
            case 21120002: 
            case 21120004: 
            case 21120005: 
            case 21120006: 
            case 21120007: 
            case 21120009: 
            case 21120010: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ int getCardSkillLevel(int a2) {
        if (GameSetConstants.MAPLE_VERSION < 152) {
            if (a2 >= 70 && a2 < 120) {
                return 2;
            }
            if (a2 >= 120 && a2 < 200) {
                return 3;
            }
            if (a2 >= 200) {
                return 4;
            }
            return 1;
        }
        if (a2 >= 60 && a2 < 100) {
            return 2;
        }
        if (a2 >= 100 && a2 < 200) {
            return 3;
        }
        if (a2 >= 200) {
            return 4;
        }
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isSpecialMove(int a2) {
        boolean bl = false;
        switch (a2 % 10000) {
            case 1000: 
            case 1001: 
            case 1002: 
            case 1003: 
            case 1004: 
            case 1005: 
            case 1006: 
            case 1007: 
            case 1010: 
            case 1011: 
            case 1013: 
            case 1014: 
            case 1015: 
            case 1016: 
            case 1017: 
            case 1018: 
            case 1019: 
            case 1023: 
            case 1025: 
            case 1026: 
            case 1027: 
            case 1028: 
            case 1029: 
            case 1030: 
            case 1031: 
            case 1033: 
            case 1034: 
            case 1035: 
            case 1037: 
            case 1042: 
            case 1043: 
            case 1044: 
            case 1049: 
            case 1050: 
            case 1051: 
            case 1054: 
            case 1058: 
            case 1061: 
            case 1062: 
            case 1063: 
            case 1064: 
            case 1066: 
            case 1067: 
            case 1068: 
            case 1069: 
            case 1070: 
            case 1074: 
            case 1075: 
            case 1076: 
            case 1079: 
            case 1081: 
            case 1084: 
            case 1085: 
            case 1087: 
            case 1089: 
            case 1091: 
            case 1101: 
            case 1106: 
            case 1112: 
            case 1113: 
            case 1116: 
            case 1118: 
            case 1119: 
            case 1120: 
            case 1121: 
            case 1122: 
            case 1126: 
            case 1129: 
            case 1130: 
            case 1132: 
            case 1136: 
            case 1138: 
            case 1139: 
            case 1142: 
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
            case 1157: 
            case 1159: 
            case 1179: 
            case 1181: 
            case 8000: 
            case 8001: 
            case 8002: 
            case 8003: 
            case 8004: 
            case 8005: 
            case 8006: {
                bl = true;
                break;
            }
        }
        switch (a2) {
            case 1113: 
            case 1114: 
            case 1196: 
            case 1198: 
            case 1001003: 
            case 0x10CCCC: 
            case 1101005: 
            case 1101006: 
            case 1101007: 
            case 1111002: 
            case 1111007: 
            case 1121000: 
            case 1121001: 
            case 0x111AEA: 
            case 1121010: 
            case 1121011: 
            case 1201004: 
            case 1201005: 
            case 1201006: 
            case 1201007: 
            case 1211003: 
            case 1211004: 
            case 1211005: 
            case 1211006: 
            case 1211007: 
            case 1211008: 
            case 1211009: 
            case 1221000: 
            case 1221001: 
            case 1221002: 
            case 1221003: 
            case 1221004: 
            case 1221012: 
            case 1301004: 
            case 1301005: 
            case 1301006: 
            case 1301007: 
            case 1311007: 
            case 1311008: 
            case 1321000: 
            case 1321001: 
            case 1321002: 
            case 1321007: 
            case 1321010: 
            case 2001002: 
            case 2001003: 
            case 2101001: 
            case 2101002: 
            case 2101003: 
            case 2111004: 
            case 2111005: 
            case 2111008: 
            case 2121000: 
            case 2121002: 
            case 2121004: 
            case 2121005: 
            case 2121008: 
            case 2121009: 
            case 2201001: 
            case 2201002: 
            case 2201003: 
            case 2211004: 
            case 2211005: 
            case 2211007: 
            case 2211008: 
            case 2221000: 
            case 2221002: 
            case 2221004: 
            case 2221005: 
            case 2221008: 
            case 2221009: 
            case 2301001: 
            case 2301002: 
            case 2301003: 
            case 2301004: 
            case 2311001: 
            case 2311002: 
            case 2311003: 
            case 2311005: 
            case 2311006: 
            case 2311007: 
            case 2311009: 
            case 2321000: 
            case 2321002: 
            case 2321003: 
            case 2321004: 
            case 2321005: 
            case 2321006: 
            case 2321009: 
            case 3001003: 
            case 3101002: 
            case 3101003: 
            case 3101004: 
            case 3111000: 
            case 3111002: 
            case 3111005: 
            case 3120012: 
            case 3121000: 
            case 3121002: 
            case 3121006: 
            case 3121007: 
            case 3121008: 
            case 3121009: 
            case 3201002: 
            case 3201004: 
            case 3201007: 
            case 3211000: 
            case 3211002: 
            case 3211005: 
            case 3220012: 
            case 3221000: 
            case 3221002: 
            case 3221005: 
            case 3221006: 
            case 3221008: 
            case 4001003: 
            case 4101003: 
            case 4101004: 
            case 4111001: 
            case 4111002: 
            case 4111003: 
            case 4111006: 
            case 4111007: 
            case 4121000: 
            case 4121004: 
            case 4121006: 
            case 4121009: 
            case 4201002: 
            case 4201003: 
            case 4201011: 
            case 4211001: 
            case 4211003: 
            case 4211005: 
            case 4211007: 
            case 0x404140: 
            case 0x404141: 
            case 4221000: 
            case 4221004: 
            case 4221006: 
            case 4221008: 
            case 4301002: 
            case 4311001: 
            case 4321000: 
            case 4321003: 
            case 4331002: 
            case 4331006: 
            case 4341000: 
            case 4341003: 
            case 4341005: 
            case 4341006: 
            case 4341007: 
            case 4341008: 
            case 5001005: 
            case 5101005: 
            case 5101006: 
            case 5101007: 
            case 5111005: 
            case 5111007: 
            case 5121000: 
            case 5121003: 
            case 5121008: 
            case 5121009: 
            case 5121010: 
            case 5201003: 
            case 5201005: 
            case 5211001: 
            case 5211002: 
            case 5211007: 
            case 5220002: 
            case 5221000: 
            case 5221006: 
            case 5221010: 
            case 5301003: 
            case 5320007: 
            case 5320008: 
            case 9001000: 
            case 9001001: 
            case 9001002: 
            case 9001003: 
            case 9001004: 
            case 9001005: 
            case 9001007: 
            case 9001008: 
            case 11001001: 
            case 11001004: 
            case 11101001: 
            case 11101002: 
            case 11101003: 
            case 11101005: 
            case 11111001: 
            case 11111007: 
            case 12001001: 
            case 12001002: 
            case 12001004: 
            case 12101000: 
            case 12101001: 
            case 12101003: 
            case 12101004: 
            case 12101005: 
            case 12111002: 
            case 12111004: 
            case 13001002: 
            case 13001004: 
            case 13101001: 
            case 13101002: 
            case 13101003: 
            case 0xC7E7CE: 
            case 13111004: 
            case 13111005: 
            case 14001003: 
            case 14001005: 
            case 14101002: 
            case 14101003: 
            case 14101004: 
            case 14111000: 
            case 14111001: 
            case 15001003: 
            case 15001004: 
            case 15101002: 
            case 15101006: 
            case 15111002: 
            case 15111005: 
            case 15111006: 
            case 20021110: 
            case 20021160: 
            case 20021161: 
            case 20021181: 
            case 21001001: 
            case 21001003: 
            case 21100005: 
            case 21101003: 
            case 21101006: 
            case 21111001: 
            case 21111005: 
            case 21111009: 
            case 21111012: 
            case 21120007: 
            case 21121000: 
            case 21121003: 
            case 21121008: 
            case 22101001: 
            case 22111001: 
            case 22121001: 
            case 22131001: 
            case 22141002: 
            case 22141003: 
            case 22151003: 
            case 22151004: 
            case 22161003: 
            case 22171000: 
            case 22181000: 
            case 22181003: 
            case 23101003: 
            case 23111008: 
            case 23111009: 
            case 23121008: 
            case 30001062: 
            case 30010183: 
            case 30010184: 
            case 30010186: 
            case 30011109: 
            case 31121007: 
            case 32001003: 
            case 32101003: 
            case 32111012: 
            case 32121003: 
            case 32121007: 
            case 32121008: 
            case 33001003: 
            case 33101003: 
            case 33101008: 
            case 33111003: 
            case 33121007: 
            case 33121008: 
            case 35101006: 
            case 35101007: 
            case 35111009: 
            case 35121003: 
            case 35121007: 
            case 35121008: 
            case 35121009: 
            case 80001008: 
            case 80001009: 
            case 80001012: 
            case 80001020: 
            case 80001021: 
            case 80001022: 
            case 80001032: 
            case 80001038: 
            case 80001039: 
            case 80001040: 
            case 80001046: 
            case 80001056: 
            case 80001057: 
            case 80001065: 
            case 80001071: 
            case 80001072: 
            case 80001073: 
            case 80001077: 
            case 80001078: 
            case 80001082: 
            case 80001083: 
            case 80001114: 
            case 80001117: 
            case 80001124: 
            case 80001129: 
            case 80001131: 
            case 80001139: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u9b25\u6c23\u653b\u64ca(int a2) {
        switch (a2) {
            case 1111003: 
            case 1111004: 
            case 1111005: 
            case 1111006: 
            case 11111002: 
            case 11111003: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u4e0d\u6d88\u8017\u5f48\u85e5\u6280\u80fd(int a2) {
        switch (a2) {
            case 4111004: 
            case 33101006: 
            case 33101007: {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ short getCharacter4thJobLevel(int a2) {
        if (!(GameSetConstants.MAPLE_VERSION < 152 || JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(a2) || JobConstants.is\u7c73\u54c8\u9038(a2) || JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a2))) {
            return 100;
        }
        return 120;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u7279\u6b8a\u89e3\u5305\u6280\u80fd(int a2) {
        boolean bl = SkillConstants.is\u77ac\u9593\u79fb\u52d5\u7cbe\u901a(a2);
        switch (a2) {
            case 5081001: 
            case 0x4DD5D4: 
            case 5300007: 
            case 15101010: 
            case 20041095: 
            case 21101003: 
            case 24121005: 
            case 30001095: 
            case 32121003: 
            case 35121003: {
                return true;
            }
        }
        return bl;
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
    public static /* synthetic */ boolean is\u6c34\u6676\u6295\u64f2(int a2) {
        switch (a2) {
            case 20021000: 
            case 20031000: 
            case 30001000: 
            case 30011000: {
                return true;
            }
        }
        return MapleJob.isBeginner(a2 / 10000) && a2 % 10000 == 1000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ int handleSpecialAttackMobCount(int a2, int a3) {
        switch (a2) {
            case 5710012: 
            case 32121003: {
                return 8;
            }
        }
        return a3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u6cd5\u8001\u7684\u61a4\u6012\u653b\u64ca(int a2) {
        switch (a2) {
            case 1020: 
            case 10001020: 
            case 20001020: 
            case 20011020: 
            case 20021020: 
            case 20031020: 
            case 30001020: 
            case 30011020: 
            case 50001020: {
                return true;
            }
        }
        return MapleJob.isBeginner(a2 / 10000) && a2 % 10000 == 1020;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isStackBuffStat(MapleBuffStat a2) {
        switch (a2) {
            case ANGEL_ATK: 
            case ANGEL_MATK: 
            case HP_BOOST: 
            case MP_BOOST: 
            case ANGEL_ACC: 
            case ANGEL_AVOID: 
            case ANGEL_JUMP: 
            case ANGEL_SPEED: 
            case ANGEL_STAT: 
            case ARCANE_AIM: 
            case HP_BOOST_PERCENT: 
            case MP_BOOST_PERCENT: 
            case INDIE_DAMAGE_PERCENT: 
            case INDIE_STR: 
            case INDIE_DEX: 
            case INDIE_INT: 
            case INDIE_LUK: 
            case INDIE_PDD: 
            case INDIE_MDD: 
            case INDIE_BOOSTER: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getLuminousSkillMode(int a2) {
        switch (a2) {
            case 27101100: 
            case 27101101: 
            case 27111100: 
            case 27121100: {
                return 20040216;
            }
            case 27101202: 
            case 27111202: 
            case 27121202: {
                return 20040217;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u77ac\u9593\u79fb\u52d5\u7cbe\u901a(int a2) {
        switch (a2) {
            case 2111007: 
            case 2211007: 
            case 2311007: 
            case 12111007: 
            case 22161005: 
            case 32111010: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMagicChargeSkill(int a2) {
        if (GameSetConstants.MAPLE_VERSION >= 145) {
            switch (a2) {
                case 22121000: 
                case 22151001: {
                    return false;
                }
            }
        }
        switch (a2) {
            case 2121001: 
            case 2221001: 
            case 2321001: 
            case 22121000: 
            case 22151001: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isIceKnightSkill(int a2) {
        return JobConstants.isBeginnerJob(a2 / 10000) && (a2 % 10000 == 1098 || a2 % 10000 == 97 || a2 % 10000 == 99 || a2 % 10000 == 100 || a2 % 10000 == 103 || a2 % 10000 == 104 || a2 % 10000 == 1105);
    }

    public static /* synthetic */ int getMasterySkill(MapleCharacter a2) {
        Object object = new LinkedList<Integer>();
        object.add(4100000);
        object.add(5200000);
        object.add(5900000);
        object.add(14100000);
        object = object.iterator();
        while (object.hasNext()) {
            int n2 = (Integer)object.next();
            if (a2.getTotalSkillLevel(n2) <= 0) continue;
            return n2;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u77ac\u9593\u79fb\u52d5(int a2) {
        boolean bl = false;
        switch (a2) {
            case 2101002: 
            case 2201002: 
            case 2301001: 
            case 8001001: 
            case 9001007: 
            case 12101003: 
            case 22101001: 
            case 27001002: 
            case 32001002: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd(int a2) {
        boolean bl = false;
        switch (a2) {
            case 4111006: 
            case 4321003: 
            case 4331005: 
            case 14101004: {
                bl = true;
                break;
            }
        }
        if (!SkillConstants.is\u4e8c\u6bb5\u8df3(a2)) return bl;
        return true;
    }

    public static final /* synthetic */ int getSkillByJob(int a2, int a3) {
        if (GameConstants.isKOC(a3)) {
            return a2 + 10000000;
        }
        if (GameConstants.isAran(a3)) {
            return a2 + 20000000;
        }
        if (GameConstants.isEvan(a3)) {
            return a2 + 20010000;
        }
        if (GameConstants.isMercedes(a3)) {
            return a2 + 20020000;
        }
        if (GameConstants.isDemon(a3)) {
            return a2 + 30010000;
        }
        if (GameConstants.isResist(a3)) {
            return a2 + 30000000;
        }
        return a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u6b66\u9675\u9053\u5834\u6280\u80fd(int a2) {
        switch (a2) {
            case 1009: 
            case 1010: 
            case 1011: {
                return true;
            }
        }
        return SkillConstants.isBeginner(a2 / 10000) && (a2 % 10000 == 1009 || a2 % 10000 == 1010 || a2 % 10000 == 1011);
    }

    public static /* synthetic */ boolean isApplicableSkill(int a2) {
        return (a2 < 80000000 || a2 >= 100000000) && (a2 % 10000 < 8000 || a2 % 10000 > 8006) && !SkillConstants.isAngel(a2) || a2 >= 92000000 || a2 >= 80000000 && a2 < 80010000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isRangedAttack(int a2) {
        boolean bl = false;
        switch (a2) {
            case 0: 
            case 1077: 
            case 1078: 
            case 1079: 
            case 3001004: 
            case 3001005: 
            case 3100001: 
            case 3101003: 
            case 3101005: 
            case 3110001: 
            case 3111003: 
            case 3111004: 
            case 3111006: 
            case 3111008: 
            case 3120008: 
            case 3120010: 
            case 3121003: 
            case 3121004: 
            case 3200001: 
            case 3201003: 
            case 3201005: 
            case 3210001: 
            case 3211003: 
            case 3211004: 
            case 3211006: 
            case 0x30FF00: 
            case 3221001: 
            case 3221003: 
            case 3221007: 
            case 4001344: 
            case 4101005: 
            case 4101008: 
            case 4101010: 
            case 4111004: 
            case 4111005: 
            case 4111010: 
            case 4111013: 
            case 4121003: 
            case 4121007: 
            case 4121013: 
            case 4221003: 
            case 4301001: 
            case 5001003: 
            case 5001008: 
            case 5011000: 
            case 5011001: 
            case 5011002: 
            case 5081002: 
            case 5121002: 
            case 5121013: 
            case 5121016: 
            case 5200010: 
            case 5201001: 
            case 5201006: 
            case 5210000: 
            case 5211004: 
            case 5211005: 
            case 5211006: 
            case 5211008: 
            case 5211010: 
            case 5220011: 
            case 5220020: 
            case 5221004: 
            case 5221007: 
            case 5221008: 
            case 5221009: 
            case 5221013: 
            case 5221015: 
            case 5221016: 
            case 5221017: 
            case 5301000: 
            case 5311000: 
            case 5311001: 
            case 5311002: 
            case 5311003: 
            case 5321000: 
            case 5321001: 
            case 5321012: 
            case 5700004: 
            case 5711000: 
            case 5711002: 
            case 5721001: 
            case 5721003: 
            case 5721004: 
            case 5721006: 
            case 5721007: 
            case 11101004: 
            case 13001003: 
            case 13101002: 
            case 13101005: 
            case 13101007: 
            case 13111000: 
            case 13111001: 
            case 13111002: 
            case 13111006: 
            case 13111007: 
            case 14001004: 
            case 14101006: 
            case 14101008: 
            case 14101009: 
            case 14111002: 
            case 14111005: 
            case 14111008: 
            case 15111006: 
            case 15111007: 
            case 15111008: 
            case 20021166: 
            case 21000004: 
            case 21100004: 
            case 21100007: 
            case 21110004: 
            case 21120006: 
            case 23001000: 
            case 23100006: 
            case 23101000: 
            case 23111000: 
            case 23111001: 
            case 23120012: 
            case 23121000: 
            case 23121002: 
            case 23121052: 
            case 33001000: 
            case 33100009: 
            case 33101001: 
            case 33101002: 
            case 33101007: 
            case 33111001: 
            case 33120011: 
            case 33121001: 
            case 33121005: 
            case 33121009: 
            case 35001001: 
            case 35001004: 
            case 35101009: 
            case 35101010: 
            case 35111004: 
            case 35111015: 
            case 35121005: 
            case 35121012: 
            case 35121013: 
            case 51001004: 
            case 51111007: 
            case 51121008: 
            case 60011216: 
            case 61001101: 
            case 65001100: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ boolean is\u5b87\u5b99\u8239(int a2) {
        switch (a2) {
            case 1013: 
            case 10001014: 
            case 20011046: 
            case 20021013: 
            case 30001013: 
            case 30011013: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean AttackCountCheck(int a2) {
        boolean bl = true;
        if (GameSetConstants.ATTACKCHECK_MODIFY) {
            switch (a2) {
                case 1311002: 
                case 13111000: 
                case 15111006: 
                case 32001011: {
                    bl = false;
                    break;
                }
            }
        }
        if (GameSetConstants.MAPLE_VERSION < 134) return bl;
        switch (a2) {
            case 1211002: 
            case 1220010: 
            case 5001008: 
            case 15001007: 
            case 24100003: 
            case 24120002: 
            case 24121010: 
            case 31121010: 
            case 32001008: 
            case 32001009: 
            case 32001010: 
            case 32001011: 
            case 61110009: {
                return false;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isFastAttack(int a2) {
        boolean bl = false;
        switch (a2) {
            case 2121007: 
            case 2221007: 
            case 2301002: 
            case 2321008: 
            case 3121004: 
            case 5221004: 
            case 13111002: 
            case 21101003: 
            case 32121004: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getStealSkill(int a2) {
        switch (a2) {
            case 1: {
                return 24001001;
            }
            case 2: {
                return 24101001;
            }
            case 3: {
                return 24111001;
            }
            case 4: {
                return 24121001;
            }
        }
        return 0;
    }

    public static /* synthetic */ int[] getInnerSkillbyRank(int a2) {
        if (a2 == 0) {
            return rankC;
        }
        if (a2 == 1) {
            return rankB;
        }
        if (a2 == 2) {
            return rankA;
        }
        if (a2 == 3) {
            return rankS;
        }
        return null;
    }

    public static /* synthetic */ boolean isLinkedAranSkill(int a2) {
        return SkillConstants.getLinkedAranSkill(a2) != a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean AttackDelayCheck(int a2) {
        boolean bl = true;
        if (GameSetConstants.ATTACKCHECK_MODIFY) {
            switch (a2) {
                case 11111004: 
                case 15111006: {
                    bl = false;
                    break;
                }
            }
        }
        switch (a2) {
            case 24100003: 
            case 24120002: 
            case 61111008: 
            case 61111100: 
            case 61120007: 
            case 65111007: {
                return false;
            }
        }
        return bl;
    }

    public static final /* synthetic */ short getCharacter3rdJobLevel(int a2) {
        if (!(GameSetConstants.MAPLE_VERSION < 152 || JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(a2) || JobConstants.is\u7c73\u54c8\u9038(a2) || JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a2))) {
            return 60;
        }
        return 70;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isGMSkill(int a2) {
        boolean bl = false;
        switch (a2) {
            case 9001000: 
            case 9001001: 
            case 9001002: 
            case 9001003: 
            case 9001004: 
            case 9001005: 
            case 9001006: 
            case 9001007: 
            case 9001008: 
            case 9001009: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isSpecialStackBuff(MapleBuffStat a2) {
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 23: 
            case 25: 
            case 26: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u885d\u523a(int a2) {
        boolean bl = false;
        switch (a2) {
            case 1101010: 
            case 1201010: 
            case 1301010: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isEncode4Buff(MapleBuffStat a2) {
        if (GameSetConstants.MAPLE_VERSION < 143) {
            return false;
        }
        switch (a2) {
            case DAMAGE_ABSORBED: {
                return GameSetConstants.MAPLE_VERSION >= 151;
            }
            case SPIRIT_LINK: 
            case MONSTER_RIDING: {
                return true;
            }
            case RETURN_TELEPORT: {
                return GameSetConstants.MAPLE_VERSION >= 152;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isChargeSkill(int a2) {
        if (SkillConstants.isMagicChargeSkill(a2)) {
            return true;
        }
        switch (a2) {
            case 32121003: {
                if (GameSetConstants.MAPLE_VERSION < 152) return false;
                return true;
            }
            case 5101004: 
            case 15101003: {
                if (GameSetConstants.MAPLE_VERSION < 147) return true;
                return false;
            }
            case 2121001: 
            case 2221001: 
            case 2321001: 
            case 3121004: 
            case 3221001: 
            case 4341002: 
            case 4341003: 
            case 5081001: 
            case 0x4DD5D4: 
            case 5201002: 
            case 5221004: 
            case 5300007: 
            case 5301001: 
            case 5311002: 
            case 5721001: 
            case 13111002: 
            case 14111006: 
            case 15101010: 
            case 20041226: 
            case 23121000: 
            case 24121000: 
            case 27101202: 
            case 27111100: 
            case 27120211: 
            case 27121201: 
            case 31001000: 
            case 31101000: 
            case 31111005: 
            case 33121009: 
            case 35001001: 
            case 35101009: 
            case 60011216: 
            case 61111100: 
            case 61111111: 
            case 65121003: 
            case 65121052: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ long getMaxDamage(MapleCharacter a2, int a3) {
        short s2;
        long l2 = GameSetConstants.MAX_DAMAGE;
        short s3 = a2.getLevel();
        if (s3 < 4) {
            l2 = 80L;
            s2 = s3;
        } else if (s3 < 9) {
            l2 = 150L;
            s2 = s3;
        } else if (s3 < 10) {
            l2 = 250L;
            s2 = s3;
        } else if (s3 <= 15) {
            l2 = 600L;
            s2 = s3;
        } else if (s3 <= 20) {
            l2 = 1000L;
            s2 = s3;
        } else if (s3 <= 25) {
            l2 = 1500L;
            s2 = s3;
        } else if (s3 <= 30) {
            l2 = 2200L;
            s2 = s3;
        } else if (s3 <= 35) {
            l2 = 3200L;
            s2 = s3;
        } else if (s3 <= 40) {
            l2 = 4000L;
            s2 = s3;
        } else if (s3 <= 50) {
            l2 = 7000L;
            s2 = s3;
        } else if (s3 <= 60) {
            l2 = 8000L;
            s2 = s3;
        } else if (s3 <= 70) {
            l2 = 12000L;
            s2 = s3;
        } else if (s3 <= 80) {
            l2 = 15000L;
            s2 = s3;
        } else if (s3 <= 90) {
            l2 = 18000L;
            s2 = s3;
        } else {
            if (s3 <= 100) {
                l2 = 25000L;
            }
            s2 = s3;
        }
        if (s2 >= 70) {
            if (a2.isCygnus()) {
                l2 += 1000L;
            }
            if (a2.isEvan()) {
                l2 = (long)((double)l2 * 1.4);
            }
        }
        switch (a3) {
            case 1001004: 
            case 11001002: 
            case 14111005: {
                l2 = (long)((double)l2 * 1.2);
            }
            case 15111004: {
                if (a2.getBuffedValue(MapleBuffStat.WK_CHARGE) != null && a2.isPirate()) {
                    l2 *= 2L;
                }
                l2 *= 3L;
                break;
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            l2 *= 2L;
        }
        if (GameSetConstants.CHECK_DAMAGE_STAGE < 100) {
            double d2 = 100.0 / (double)GameSetConstants.CHECK_DAMAGE_STAGE;
            l2 = (int)((double)l2 * d2);
        }
        return SkillConstants.handleSpecialSkillDamage(a3, l2);
    }

    public static /* synthetic */ {
        int[] arrn = new int[14];
        arrn[0] = 70000000;
        arrn[1] = 70000001;
        arrn[2] = 70000002;
        arrn[3] = 70000003;
        arrn[4] = 70000004;
        arrn[5] = 70000005;
        arrn[6] = 70000006;
        arrn[7] = 70000007;
        arrn[8] = 70000008;
        arrn[9] = 70000009;
        arrn[10] = 70000010;
        arrn[11] = 70000011;
        arrn[12] = 70000012;
        arrn[13] = 70000013;
        rankC = arrn;
        int[] arrn2 = new int[11];
        arrn2[0] = 70000014;
        arrn2[1] = 70000015;
        arrn2[2] = 70000016;
        arrn2[3] = 70000017;
        arrn2[4] = 70000018;
        arrn2[5] = 70000021;
        arrn2[6] = 70000022;
        arrn2[7] = 70000023;
        arrn2[8] = 70000024;
        arrn2[9] = 70000025;
        arrn2[10] = 70000026;
        rankB = arrn2;
        int[] arrn3 = new int[14];
        arrn3[0] = 70000027;
        arrn3[1] = 70000028;
        arrn3[2] = 70000029;
        arrn3[3] = 70000030;
        arrn3[4] = 70000031;
        arrn3[5] = 70000032;
        arrn3[6] = 70000033;
        arrn3[7] = 70000034;
        arrn3[8] = 70000035;
        arrn3[9] = 70000036;
        arrn3[10] = 70000039;
        arrn3[11] = 70000040;
        arrn3[12] = 70000041;
        arrn3[13] = 70000042;
        rankA = arrn3;
        int[] arrn4 = new int[19];
        arrn4[0] = 70000043;
        arrn4[1] = 70000044;
        arrn4[2] = 70000045;
        arrn4[3] = 70000047;
        arrn4[4] = 70000048;
        arrn4[5] = 70000049;
        arrn4[6] = 70000050;
        arrn4[7] = 70000051;
        arrn4[8] = 70000052;
        arrn4[9] = 70000053;
        arrn4[10] = 70000054;
        arrn4[11] = 70000055;
        arrn4[12] = 70000056;
        arrn4[13] = 70000057;
        arrn4[14] = 70000058;
        arrn4[15] = 70000059;
        arrn4[16] = 70000060;
        arrn4[17] = 70000061;
        arrn4[18] = 70000062;
        rankS = arrn4;
        int[] arrn5 = new int[6];
        arrn5[0] = 27001201;
        arrn5[1] = 27101202;
        arrn5[2] = 27111202;
        arrn5[3] = 27121201;
        arrn5[4] = 27121202;
        arrn5[5] = 27120211;
        luminous_darkSkills = arrn5;
        int[] arrn6 = new int[6];
        arrn6[0] = 27001100;
        arrn6[1] = 27101100;
        arrn6[2] = 27101101;
        arrn6[3] = 27111100;
        arrn6[4] = 27111101;
        arrn6[5] = 27121100;
        luminous_lightSkills = arrn6;
    }

    public static /* synthetic */ boolean is\u5de8\u5927\u85e5\u6c34\u6280\u80fd(int a2) {
        return JobConstants.isBeginnerJob(a2 / 10000) && (a2 % 10000 == 1092 || a2 % 10000 == 1094 || a2 % 10000 == 1095);
    }

    public static /* synthetic */ boolean is\u98db\u7fd4(int a2) {
        return a2 % 10000 == 1026 || a2 % 10000 == 1142;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getLinkedSkill(int a2) {
        switch (a2) {
            case 4321001: {
                return 4321000;
            }
            case 5001008: {
                return 5001003;
            }
            case 5211015: 
            case 5211016: {
                return 5211011;
            }
            case 5300007: {
                return 5301001;
            }
            case 5320011: {
                return 5321004;
            }
            case 5710012: {
                return 5711002;
            }
            case 15001007: {
                return 15001003;
            }
            case 21110007: 
            case 21110008: {
                return 21110002;
            }
            case 21120009: 
            case 21120010: {
                return 21120002;
            }
            case 23101007: {
                return 23101001;
            }
            case 23111009: 
            case 23111010: {
                return 23111008;
            }
            case 24111008: {
                return 24111006;
            }
            case 24121010: {
                return 24121003;
            }
            case 27120211: {
                return 27121201;
            }
            case 30010183: 
            case 30010184: 
            case 30010186: {
                return 30010110;
            }
            case 31001006: 
            case 31001007: 
            case 31001008: {
                return 31000004;
            }
            case 31121010: {
                return 31121000;
            }
            case 32001008: 
            case 32001009: 
            case 32001010: 
            case 32001011: {
                return 32001001;
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
            case 61001004: 
            case 61001005: 
            case 61110212: 
            case 61120219: {
                return 61001000;
            }
            case 61120018: {
                return 61121105;
            }
            case 61110211: 
            case 61121217: {
                return 61101002;
            }
            case 61111111: 
            case 61111113: {
                return 61111100;
            }
            case 61110009: {
                return 61111003;
            }
            case 61121116: {
                return 61121104;
            }
            case 61121201: {
                return 61121100;
            }
            case 61121203: {
                return 61121102;
            }
            case 61120008: {
                return 61111008;
            }
            case 65101006: {
                return 65101100;
            }
            case 65121007: 
            case 65121008: {
                return 65121101;
            }
            case 65111007: {
                return 65111100;
            }
        }
        return a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u7d42\u6975\u653b\u64ca(int a2) {
        boolean bl = false;
        switch (a2) {
            case 1100002: 
            case 1100003: 
            case 1120013: 
            case 1200002: 
            case 1200003: 
            case 1300002: 
            case 1300003: 
            case 3100001: 
            case 3200001: 
            case 11101002: 
            case 13101002: 
            case 21100010: 
            case 21120002: 
            case 21120005: 
            case 21120009: 
            case 21120010: 
            case 21120012: 
            case 22150004: 
            case 23100006: 
            case 24100003: 
            case 32121002: 
            case 33100009: 
            case 51100002: 
            case 51120002: {
                return true;
            }
        }
        return bl;
    }

    public static /* synthetic */ int getJobBySkill(int a2) {
        int n2 = a2 / 10000;
        if (a2 / 10000 == 8000) {
            n2 = a2 / 100;
        }
        return n2;
    }

    public static /* synthetic */ Pair<Integer, Integer> getRelatedLinkSkill(int a2) {
        int n2 = 0;
        int n3 = 0;
        if (JobConstants.is\u8056\u9b42\u528d\u58eb(a2)) {
            n3 = 80000066;
            n2 = 2;
        } else if (JobConstants.is\u70c8\u7130\u5deb\u5e2b(a2)) {
            n3 = 80000067;
            n2 = 2;
        } else if (JobConstants.is\u7834\u98a8\u4f7f\u8005(a2)) {
            n3 = 0x4C4B444;
            n2 = 2;
        } else if (JobConstants.is\u6697\u591c\u884c\u8005(a2)) {
            n3 = 80000069;
            n2 = 2;
        } else if (JobConstants.is\u9583\u96f7\u608d\u5c07(a2)) {
            n3 = 80000070;
            n2 = 2;
        } else if (JobConstants.is\u7c73\u54c8\u9038(a2)) {
            n3 = 80001140;
        } else if (JobConstants.is\u5e7b\u5f71\u4fe0\u76dc(a2)) {
            n3 = 80000002;
        } else if (JobConstants.is\u7cbe\u9748\u904a\u4fe0(a2)) {
            n3 = 80001040;
        } else if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a2)) {
            n3 = 80000001;
        } else if (JobConstants.is\u60e1\u9b54\u5fa9\u4ec7\u8005(a2)) {
            n3 = 80000050;
        } else if (JobConstants.is\u528d\u8c6a(a2)) {
            n3 = 80000003;
            n2 = 1;
        } else if (JobConstants.is\u9670\u967d\u5e2b(a2)) {
            n3 = 80000004;
            n2 = 2;
        } else if (JobConstants.is\u591c\u5149(a2)) {
            n3 = 80000005;
        } else if (JobConstants.is\u51f1\u6492(a2)) {
            n3 = 80000006;
        } else if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a2)) {
            n3 = 80001155;
        } else if (JobConstants.is\u5091\u8afe(a2)) {
            n3 = 80000047;
            n2 = 2;
        } else if (JobConstants.is\u84bc\u9f8d\u4fe0\u5ba2(a2)) {
            n3 = 80001151;
        } else if (JobConstants.is\u5e7b\u7378\u5e2b(a2)) {
            n3 = 80010006;
        } else if (JobConstants.is\u96b1\u6708(a2)) {
            n3 = 80000169;
            n2 = 2;
        } else if (JobConstants.is\u91cd\u7832\u6307\u63ee\u5b98(a2)) {
            n3 = 80000000;
        } else if (JobConstants.is\u795e\u4e4b\u5b50(a2)) {
            n3 = 80000110;
            n2 = 5;
        }
        return new Pair<Integer, Integer>(n3, n2);
    }

    public static /* synthetic */ int getJobGrade(int a2) {
        int n2 = a2 % 1000;
        if (n2 / 10 == 0) {
            return 0;
        }
        if (n2 / 10 % 10 == 0) {
            return 1;
        }
        return n2 % 10 + 2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ boolean isForceIncrease(int a2) {
        switch (a2) {
            case 30010166: 
            case 30011167: 
            case 30011168: 
            case 30011169: 
            case 30011170: 
            case 31000004: 
            case 31001006: 
            case 31001007: 
            case 31001008: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isInflationSkill(int a2) {
        return JobConstants.isBeginnerJob(a2 / 10000) && a2 % 10000 == 1092;
    }

    public static /* synthetic */ boolean isBuffSkill(int a2) {
        boolean bl = false;
        switch (a2) {
            case 1311006: {
                return false;
            }
            case 1076: 
            case 11076: 
            case 2111002: 
            case 2111003: 
            case 2121001: 
            case 2121007: 
            case 2221001: 
            case 2221007: 
            case 2301002: 
            case 2321001: 
            case 2321008: 
            case 4211001: 
            case 12111005: 
            case 22161002: 
            case 22161003: 
            case 32121006: {
                bl = false;
                return false;
            }
            case 93: 
            case 1004: 
            case 1026: 
            case 8003: 
            case 1001003: 
            case 0x10CCCC: 
            case 1101006: 
            case 1101007: 
            case 1101010: 
            case 1111002: 
            case 1111007: 
            case 1121000: 
            case 0x111AEA: 
            case 1121010: 
            case 1121011: 
            case 1201004: 
            case 1201007: 
            case 1201010: 
            case 1211004: 
            case 1211006: 
            case 1211008: 
            case 1211009: 
            case 1211010: 
            case 1211011: 
            case 1220013: 
            case 1221000: 
            case 1221002: 
            case 1221004: 
            case 1221006: 
            case 1221012: 
            case 1301004: 
            case 1301006: 
            case 1301007: 
            case 1301010: 
            case 1311007: 
            case 1311008: 
            case 1320009: 
            case 1321000: 
            case 1321002: 
            case 1321010: 
            case 2101002: 
            case 2111005: 
            case 2111007: 
            case 2120010: 
            case 2121000: 
            case 2121009: 
            case 2201002: 
            case 2211005: 
            case 2211007: 
            case 2220010: 
            case 2221000: 
            case 2221008: 
            case 2221009: 
            case 2301001: 
            case 2311006: 
            case 2311007: 
            case 2320011: 
            case 2321000: 
            case 2321010: 
            case 3120006: 
            case 3121000: 
            case 3121009: 
            case 3220005: 
            case 3221000: 
            case 3221008: 
            case 4101003: 
            case 4101009: 
            case 4111001: 
            case 4121000: 
            case 4121009: 
            case 4121015: 
            case 4201008: 
            case 4211003: 
            case 4221000: 
            case 4221008: 
            case 4321000: 
            case 4330009: 
            case 4331003: 
            case 4331007: 
            case 4341000: 
            case 4341002: 
            case 4341008: 
            case 5001005: 
            case 5110001: 
            case 5111005: 
            case 5111007: 
            case 5120011: 
            case 5120012: 
            case 5121000: 
            case 5121003: 
            case 5121008: 
            case 5121009: 
            case 5211001: 
            case 5211002: 
            case 5211006: 
            case 5211007: 
            case 5220002: 
            case 5220011: 
            case 5220012: 
            case 5220014: 
            case 5221000: 
            case 5221010: 
            case 5221015: 
            case 5311005: 
            case 5320007: 
            case 5321003: 
            case 5321004: 
            case 5321005: 
            case 5711001: 
            case 5720005: 
            case 5720012: 
            case 5721000: 
            case 5721003: 
            case 9001004: 
            case 9101004: 
            case 10000093: 
            case 10001004: 
            case 10001026: 
            case 10008003: 
            case 11001001: 
            case 12101004: 
            case 13111005: 
            case 14101002: 
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
            case 20008003: 
            case 20010093: 
            case 20011004: 
            case 20011026: 
            case 20018003: 
            case 20020093: 
            case 20021026: 
            case 20031209: 
            case 20031210: 
            case 21000000: 
            case 21101003: 
            case 21110011: 
            case 21121000: 
            case 21121008: 
            case 22121001: 
            case 22131001: 
            case 22141002: 
            case 22151002: 
            case 22151003: 
            case 22161004: 
            case 22171000: 
            case 22171004: 
            case 22181000: 
            case 22181003: 
            case 22181004: 
            case 23121005: 
            case 24121008: 
            case 27100003: 
            case 27101202: 
            case 30000093: 
            case 30001004: 
            case 30001026: 
            case 30008003: 
            case 30010093: 
            case 30011026: 
            case 31121004: 
            case 31121005: 
            case 32001001: 
            case 32001003: 
            case 32101002: 
            case 32101003: 
            case 32101005: 
            case 32110000: 
            case 32110007: 
            case 32110008: 
            case 32110009: 
            case 32111004: 
            case 32111005: 
            case 32111006: 
            case 32111010: 
            case 32111012: 
            case 32120000: 
            case 32120001: 
            case 32121003: 
            case 32121005: 
            case 32121007: 
            case 32121008: 
            case 33101006: 
            case 33111003: 
            case 33121007: 
            case 33121008: 
            case 35001001: 
            case 35001002: 
            case 35101002: 
            case 35101005: 
            case 35101006: 
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
            case 35120014: 
            case 35121003: 
            case 35121005: 
            case 35121006: 
            case 35121007: 
            case 35121008: 
            case 35121009: 
            case 35121010: 
            case 35121013: 
            case 60001216: 
            case 60001217: 
            case 61101002: 
            case 61120007: 
            case 61121217: 
            case 65101100: 
            case 65120006: 
            case 65121003: 
            case 65121101: 
            case 80001000: 
            case 80001089: {
                while (false) {
                }
                bl = true;
                return true;
            }
            case 22131002: {
                if (GameSetConstants.MAPLE_VERSION < 147) break;
                bl = true;
                return true;
            }
            default: {
                if (!SkillConstants.is\u4e8c\u6bb5\u8df3(a2)) break;
                return bl;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getLinkedAranSkill(int a2) {
        switch (a2) {
            case 30010183: 
            case 30010184: 
            case 30010186: {
                return 30010110;
            }
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
        }
        return a2;
    }

    public static /* synthetic */ boolean isBeginner(int a2) {
        return SkillConstants.getJobGrade(a2) == 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMagicAttack(int a2) {
        boolean bl = false;
        switch (a2 % 10000) {
            case 1000: 
            case 1020: 
            case 1125: 
            case 1130: 
            case 1188: {
                bl = true;
                break;
            }
        }
        switch (a2) {
            case 1000: 
            case 1076: 
            case 1111010: 
            case 2001004: 
            case 2001005: 
            case 2101004: 
            case 2101005: 
            case 2111002: 
            case 2111003: 
            case 2111006: 
            case 2121001: 
            case 2121003: 
            case 2121006: 
            case 2121007: 
            case 2201004: 
            case 2201005: 
            case 2211002: 
            case 2211003: 
            case 2211006: 
            case 2221001: 
            case 2221003: 
            case 2221006: 
            case 2221007: 
            case 2301002: 
            case 2301005: 
            case 2311004: 
            case 2321001: 
            case 2321007: 
            case 2321008: 
            case 10001000: 
            case 12001003: 
            case 12101002: 
            case 12101006: 
            case 12111003: 
            case 12111005: 
            case 12111006: 
            case 20001000: 
            case 20011000: 
            case 22000000: 
            case 22001001: 
            case 22101000: 
            case 22101001: 
            case 22111000: 
            case 22111001: 
            case 22121000: 
            case 22121001: 
            case 22131000: 
            case 22131001: 
            case 22140000: 
            case 22141001: 
            case 22141002: 
            case 22141003: 
            case 22150000: 
            case 22150004: 
            case 22151001: 
            case 22151002: 
            case 22151003: 
            case 22151004: 
            case 22160000: 
            case 22161001: 
            case 22161002: 
            case 22161003: 
            case 22170001: 
            case 22171000: 
            case 22171002: 
            case 22171003: 
            case 22171004: 
            case 22181000: 
            case 22181001: 
            case 22181002: 
            case 22181003: 
            case 27001100: 
            case 27001201: 
            case 27101100: 
            case 27101101: 
            case 27111101: 
            case 27111202: 
            case 27111303: 
            case 27121052: 
            case 27121100: 
            case 27121202: 
            case 27121303: 
            case 27121304: 
            case 32000013: 
            case 32101001: 
            case 32111003: 
            case 32111011: 
            case 32121004: 
            case 80001125: 
            case 80001130: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isNeedExtraRemoveSummon(int a2) {
        switch (a2) {
            case 1085: 
            case 1087: 
            case 1090: 
            case 1179: 
            case 1321007: 
            case 3111002: 
            case 3120012: 
            case 3211002: 
            case 3220012: 
            case 4341006: 
            case 5211001: 
            case 5211014: 
            case 5220002: 
            case 5321003: 
            case 13111004: 
            case 22171052: 
            case 33111003: 
            case 35111001: 
            case 35111005: 
            case 35111009: 
            case 35111010: 
            case 35111011: 
            case 35121003: 
            case 35121009: 
            case 35121010: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u4e8c\u6bb5\u8df3(int a2) {
        boolean bl = false;
        switch (a2) {
            case 4001001: 
            case 4001011: 
            case 4101009: 
            case 4111006: 
            case 4201008: 
            case 0x404141: 
            case 4311007: 
            case 4321003: 
            case 5081003: 
            case 14101004: 
            case 20021181: 
            case 23001002: 
            case 24001002: 
            case 33001002: 
            case 51001003: 
            case 61001002: 
            case 65001001: {
                return true;
            }
        }
        return bl;
    }

    public static /* synthetic */ int getSkillBookByLevel(int a2, int a3) {
        if (!JobConstants.isSeparatedSp(a2)) {
            return 0;
        }
        if (!JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a2)) {
            int n2 = 0;
            if (a3 > GameConstants.getCharacter4thJobLevel(a2)) {
                n2 = 4;
            } else if (a3 > GameConstants.getCharacter3rdJobLevel(a2)) {
                n2 = 3;
            } else if (a3 > GameConstants.getCharacter2ndJobLevel(a2)) {
                n2 = 2;
            } else if (a3 > GameConstants.getCharacter1stJobLevel(a2)) {
                n2 = 1;
            }
            return Math.max(0, n2 - 1);
        }
        if (a3 > 160) {
            return 9;
        }
        if (a3 > 120) {
            return 8;
        }
        if (a3 > 100) {
            return 7;
        }
        if (a3 > 80) {
            return 6;
        }
        if (a3 > 60) {
            return 5;
        }
        if (a3 > 50) {
            return 4;
        }
        if (a3 > 40) {
            return 3;
        }
        if (a3 > 30) {
            return 2;
        }
        if (a3 > 20) {
            return 1;
        }
        if (a3 > 10) {
            return 0;
        }
        return 0;
    }

    public static /* synthetic */ boolean is\u91d1\u5b57\u5854\u6280\u80fd(int a2) {
        return SkillConstants.isBeginner(a2 / 10000) && (a2 == 1020 || a2 % 10000 == 1020);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isCloseRangedAttack(int a2) {
        boolean bl = false;
        switch (a2 % 10000) {
            case 1009: 
            case 1020: 
            case 1092: 
            case 1094: 
            case 1095: {
                bl = true;
                break;
            }
        }
        switch (a2) {
            case 0: 
            case 1009: 
            case 1020: 
            case 1075: 
            case 1001004: 
            case 1001005: 
            case 1100002: 
            case 1100003: 
            case 1101008: 
            case 1101011: 
            case 1111003: 
            case 1111004: 
            case 1111005: 
            case 1111006: 
            case 1111008: 
            case 1111010: 
            case 1120013: 
            case 1121001: 
            case 0x111AEE: 
            case 1121008: 
            case 1200002: 
            case 1200003: 
            case 1201008: 
            case 1211002: 
            case 1221007: 
            case 1221009: 
            case 1221011: 
            case 1300002: 
            case 1300003: 
            case 1301008: 
            case 1311001: 
            case 1311002: 
            case 1311003: 
            case 1311004: 
            case 1311005: 
            case 1311006: 
            case 1321001: 
            case 1321003: 
            case 1321012: 
            case 2111007: 
            case 2211007: 
            case 2311007: 
            case 3101003: 
            case 3201003: 
            case 4001002: 
            case 4001013: 
            case 4001334: 
            case 4111003: 
            case 4121008: 
            case 4121016: 
            case 4201004: 
            case 4201005: 
            case 4211002: 
            case 4211004: 
            case 4211006: 
            case 4211011: 
            case 4221001: 
            case 4221007: 
            case 4221010: 
            case 4301001: 
            case 4301004: 
            case 4311002: 
            case 4311003: 
            case 4321001: 
            case 4321002: 
            case 4321004: 
            case 0x41EEEE: 
            case 4331000: 
            case 4331001: 
            case 4331003: 
            case 4331004: 
            case 4331005: 
            case 4331006: 
            case 4334005: 
            case 4341002: 
            case 4341003: 
            case 4341004: 
            case 4341005: 
            case 4341009: 
            case 4341011: 
            case 5001001: 
            case 5001002: 
            case 5081001: 
            case 5081005: 
            case 5101002: 
            case 5101003: 
            case 5101004: 
            case 0x4DD5D4: 
            case 5110001: 
            case 5111002: 
            case 5111004: 
            case 5111006: 
            case 5111012: 
            case 5121001: 
            case 5121004: 
            case 5121005: 
            case 5121007: 
            case 5201002: 
            case 5201004: 
            case 5221003: 
            case 5300007: 
            case 5301001: 
            case 5701001: 
            case 5701007: 
            case 5710012: 
            case 5711006: 
            case 9001006: 
            case 10001009: 
            case 10001020: 
            case 11001002: 
            case 11001003: 
            case 11101002: 
            case 11111002: 
            case 11111003: 
            case 11111004: 
            case 11111006: 
            case 12111007: 
            case 14001002: 
            case 14111001: 
            case 14111006: 
            case 15001001: 
            case 15001002: 
            case 15001007: 
            case 15100004: 
            case 15101003: 
            case 15101004: 
            case 15101005: 
            case 15101010: 
            case 15111001: 
            case 15111003: 
            case 15111004: 
            case 15111012: 
            case 20000014: 
            case 20000015: 
            case 20000016: 
            case 20001009: 
            case 20001020: 
            case 20011020: 
            case 20041226: 
            case 21000002: 
            case 21100001: 
            case 21100002: 
            case 21100010: 
            case 21101003: 
            case 21110003: 
            case 21110006: 
            case 21110007: 
            case 21110008: 
            case 21110011: 
            case 21120005: 
            case 21120009: 
            case 21120010: 
            case 21120012: 
            case 21120052: 
            case 21120055: 
            case 21120056: 
            case 22161005: 
            case 22181004: 
            case 23100004: 
            case 23101001: 
            case 23101007: 
            case 23110006: 
            case 23111002: 
            case 23111003: 
            case 23120011: 
            case 23121003: 
            case 24001000: 
            case 24100003: 
            case 24101000: 
            case 24101002: 
            case 24111000: 
            case 24111006: 
            case 24111008: 
            case 24120002: 
            case 24120055: 
            case 24121000: 
            case 24121005: 
            case 24121010: 
            case 24121052: 
            case 27101202: 
            case 27111100: 
            case 27120211: 
            case 27121201: 
            case 30010166: 
            case 30011166: 
            case 30011167: 
            case 30011168: 
            case 30011169: 
            case 30011170: 
            case 31000004: 
            case 31001000: 
            case 31001006: 
            case 31001007: 
            case 31001008: 
            case 31101000: 
            case 31101001: 
            case 31101002: 
            case 31111000: 
            case 31111001: 
            case 31111003: 
            case 31111005: 
            case 31121000: 
            case 31121001: 
            case 31121003: 
            case 31121005: 
            case 31121006: 
            case 31121010: 
            case 32001000: 
            case 32001008: 
            case 32001009: 
            case 32001010: 
            case 32001011: 
            case 32101000: 
            case 32111002: 
            case 32111010: 
            case 32121002: 
            case 32121003: 
            case 33111002: 
            case 33111006: 
            case 33121001: 
            case 33121002: 
            case 35001003: 
            case 35101003: 
            case 35101004: 
            case 35121003: 
            case 51100002: 
            case 51101005: 
            case 51101006: 
            case 51111006: 
            case 51120002: 
            case 51121007: 
            case 60001229: 
            case 61001000: 
            case 61001004: 
            case 61001005: 
            case 61101002: 
            case 61101100: 
            case 61101101: 
            case 61110009: 
            case 61110212: 
            case 61111100: 
            case 61111101: 
            case 61111111: 
            case 61111113: 
            case 61120007: 
            case 61120018: 
            case 61120219: 
            case 61121100: 
            case 61121102: 
            case 61121104: 
            case 61121105: 
            case 61121106: 
            case 61121116: 
            case 61121201: 
            case 61121203: 
            case 61121217: 
            case 65101001: 
            case 65101006: 
            case 65101100: 
            case 65101101: 
            case 65111002: 
            case 65111007: 
            case 65111101: 
            case 65121002: 
            case 65121003: 
            case 65121007: 
            case 65121008: 
            case 65121052: 
            case 65121100: 
            case 65121101: 
            case 80001210: 
            case 80001211: 
            case 80001212: 
            case 80001213: 
            case 80001214: 
            case 80001215: 
            case 80001372: {
                return true;
            }
        }
        return bl;
    }

    public static final /* synthetic */ int getSpecialSkillByJob(int a2, int a3) {
        int n2 = a2;
        if (a2 == 1013) {
            if (GameConstants.isKOC(a3)) {
                n2 = 10001014;
                return 10001014;
            }
            if (GameConstants.isAran(a3)) {
                n2 = 0x1313116;
                return 0x1313116;
            }
            if (GameConstants.isEvan(a3)) {
                n2 = 20011046;
                return 20011046;
            }
            if (GameConstants.isMercedes(a3)) {
                n2 = 20021013;
                return 20021013;
            }
            if (GameConstants.isDemon(a3)) {
                n2 = 30011013;
                return 30011013;
            }
            if (GameConstants.isResist(a3)) {
                n2 = 30001013;
            }
        }
        return n2;
    }

    public static final /* synthetic */ short getCharacter1stJobLevel(int a2) {
        if (a2 == 200) {
            return 8;
        }
        return 10;
    }

    public /* synthetic */ SkillConstants() {
        SkillConstants a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getBuffDelay(int a2) {
        switch (a2) {
            case 24111002: 
            case 24111003: 
            case 24111005: 
            case 24121004: 
            case 24121008: {
                return 1000;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u7d2f\u7a4d\u80fd\u91cf\u6280\u80fd(int a2) {
        switch (a2) {
            case 80001034: 
            case 80001035: 
            case 80001036: 
            case 80001041: 
            case 80001042: 
            case 80001043: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isLinkedSkill(int a2) {
        return SkillConstants.getLinkedSkill(a2) != a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMoveSkill(int a2) {
        if (SkillConstants.is\u98db\u884c\u8df3\u8e8d\u6280\u80fd(a2)) {
            return true;
        }
        if (SkillConstants.is\u77ac\u9593\u79fb\u52d5(a2)) {
            return true;
        }
        switch (a2) {
            case 5011002: 
            case 5201006: 
            case 11101005: 
            case 30001068: {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ short getCharacter2ndJobLevel(int a2) {
        return 30;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isRecoveryIncSkill(int a2) {
        switch (a2) {
            case 1110000: 
            case 1210000: 
            case 2000000: 
            case 4100002: 
            case 4200001: 
            case 11110000: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ long handleSpecialSkillDamage(int a2, long a3) {
        switch (a2) {
            case 3221007: 
            case 4221001: {
                return 9999999L;
            }
            case 65120046: 
            case 65120047: 
            case 65120048: 
            case 65121002: 
            case 65121003: {
                return 99999999L;
            }
            case 65121101: {
                return 40000000L;
            }
        }
        return a3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u98db\u884c\u8df3\u8e8d\u6280\u80fd(int a2) {
        switch (a2) {
            case 20010022: 
            case 30010110: 
            case 30010183: 
            case 30010184: 
            case 30010186: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean canSteal(ISkill a2) {
        return a2 != null && !a2.isMovement() && !SkillConstants.isLinkedSkill(a2.getId()) && a2.getId() % 10000 >= 1000 && JobConstants.getJobNumber(a2.getId() / 10000) > 0 && !JobConstants.isDualBlade(a2.getId() / 10000) && !JobConstants.is\u91cd\u7832\u6307\u63ee\u5b98(a2.getId() / 10000) && !JobConstants.is\u84bc\u9f8d\u4fe0\u5ba2(a2.getId() / 10000) && a2.getId() < 8000000 && a2.getEffect(1) != null && a2.getEffect(1).getSummonMovementType() == null && !a2.getEffect(1).isUnstealable();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5730\u5716\u77ac\u79fb(int a2) {
        boolean bl = false;
        switch (a2) {
            case 22141004: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getJudgmentStat(int a2, int a3) {
        switch (a3) {
            case 1: {
                if (a2 == 20031209) {
                    return 5;
                }
                return 10;
            }
            case 2: {
                if (a2 == 20031209) {
                    return 10;
                }
                return 20;
            }
            case 3: {
                return 2020;
            }
            case 4: {
                return 100;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u7a76\u6975\u7a81\u523a(int a2) {
        switch (a2) {
            case 0x111AEE: 
            case 1221007: 
            case 1321003: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isNoDelaySkill(int a2) {
        return a2 == 5110001 || a2 == 21101003 || a2 == 15100004 || a2 == 33101004 || a2 == 32111010 || a2 == 2111007 || a2 == 2211007 || a2 == 2311007 || a2 == 32121003 || a2 == 35121005 || a2 == 35111004 || a2 == 35121013 || a2 == 35121003 || a2 == 22150004 || a2 == 22181004 || a2 == 11101002 || a2 == 13101002;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isEnergyBuff(int a2) {
        switch (a2) {
            case 2111007: 
            case 2201009: 
            case 2211007: 
            case 2311007: 
            case 4341052: 
            case 12111007: 
            case 21101003: 
            case 22161005: 
            case 24120055: 
            case 32111010: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5ae9\u5bf6\u6295\u64f2\u8853(int a2) {
        switch (a2) {
            case 1000: 
            case 10001000: 
            case 20001000: 
            case 20011000: 
            case 50001000: {
                return true;
            }
        }
        return MapleJob.isBeginner(a2 / 10000) && a2 % 10000 == 1000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isAngel(int a2) {
        if (MapleJob.isBeginner(a2 / 10000) || a2 / 100000 == 800) {
            switch (a2 % 10000) {
                case 86: 
                case 1085: 
                case 1087: 
                case 1090: 
                case 1179: {
                    return true;
                }
            }
        }
        switch (a2) {
            case 80000052: 
            case 80000053: 
            case 80000054: 
            case 80000086: 
            case 80001154: 
            case 80001262: 
            case 80001518: 
            case 80001519: 
            case 80001520: 
            case 80001521: 
            case 80001522: 
            case 80001523: 
            case 80001524: 
            case 80001525: 
            case 80001526: 
            case 80001527: 
            case 80001528: 
            case 80001529: 
            case 80001530: 
            case 80001715: 
            case 80001716: 
            case 80001717: 
            case 80001718: 
            case 80001719: 
            case 80001720: 
            case 80001721: 
            case 80001722: 
            case 80001723: 
            case 80001724: 
            case 80001725: 
            case 80001726: 
            case 80001727: {
                return true;
            }
        }
        return false;
    }
}

