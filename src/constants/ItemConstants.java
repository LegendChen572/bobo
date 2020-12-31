/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package constants;

import client.ClientRedirector;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleJob;
import client.inventory.Equip;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import client.inventory.MapleWeaponType;
import client.status.MonsterStatus;
import constants.GameSetConstants;
import constants.ItemConstants;
import handling.channel.handler.UserInterfaceHandler;
import java.util.Calendar;
import java.util.Map;
import server.MapleItemInformationProvider;

/*
 * Exception performing whole class analysis ignored.
 */
public class ItemConstants {
    public static /* synthetic */ boolean isPendantSlot(int a2) {
        return a2 == ItemConstants.getPendantSlot() || a2 == ItemConstants.getPendantSlot() * 10;
    }

    public static /* synthetic */ boolean is\u5fc3\u81df(int a2) {
        return a2 / 10000 == 167;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u6c38\u6046\u88dd\u5099(int a2) {
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

    public static /* synthetic */ int getPendantSlot() {
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            return -36;
        }
        return -35;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5e78\u904b\u65e5\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5063100: 
            case 5068000: {
                return true;
            }
        }
        return a2 / 1000 == 2530;
    }

    public static /* synthetic */ boolean isPetEquip(int a2) {
        return a2 / 10000 == 180;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ MonsterStatus getStatFromWeapon(int a2) {
        switch (a2) {
            case 1302109: 
            case 1312041: 
            case 1322067: 
            case 1332083: 
            case 1372048: 
            case 1382064: 
            case 1402055: 
            case 1412037: 
            case 1422041: 
            case 1432052: 
            case 1442073: 
            case 1452064: 
            case 1462058: 
            case 1472079: 
            case 1482035: {
                return MonsterStatus.ACC;
            }
            case 1302108: 
            case 1312040: 
            case 1322066: 
            case 1332082: 
            case 1372047: 
            case 1382063: 
            case 1402054: 
            case 1412036: 
            case 1422040: 
            case 1432051: 
            case 1442072: 
            case 1452063: 
            case 1462057: 
            case 1472078: 
            case 1482036: {
                return MonsterStatus.SPEED;
            }
        }
        return null;
    }

    public static /* synthetic */ short[] getEquipedSlot(int a2) {
        boolean bl = MapleItemInformationProvider.getInstance().isCash(a2);
        if (\u985e\u578b.\u5e3d\u5b50((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -101;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -1;
            return arrs;
        }
        if (\u985e\u578b.\u81c9\u98fe((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -102;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -2;
            return arrs;
        }
        if (\u985e\u578b.\u773c\u98fe((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -103;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -3;
            return arrs;
        }
        if (\u985e\u578b.\u8033\u74b0((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -104;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -4;
            return arrs;
        }
        if (\u985e\u578b.\u4e0a\u8863((int)a2) || \u985e\u578b.\u5957\u670d((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -105;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -5;
            return arrs;
        }
        if (\u985e\u578b.\u8932\u88d9((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -106;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -6;
            return arrs;
        }
        if (\u985e\u578b.\u978b\u5b50((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -107;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -7;
            return arrs;
        }
        if (\u985e\u578b.\u624b\u5957((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -108;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -8;
            return arrs;
        }
        if (\u985e\u578b.\u62ab\u98a8((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -109;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -9;
            return arrs;
        }
        if (\u985e\u578b.\u526f\u624b((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -110;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -10;
            return arrs;
        }
        if (\u985e\u578b.\u6b66\u5668((int)a2)) {
            if (bl) {
                short[] arrs = new short[1];
                arrs[0] = -111;
                return arrs;
            }
            short[] arrs = new short[1];
            arrs[0] = -11;
            return arrs;
        }
        if (\u985e\u578b.\u6212\u6307((int)a2)) {
            if (bl) {
                short[] arrs = new short[4];
                arrs[0] = -112;
                arrs[1] = -113;
                arrs[2] = -115;
                arrs[3] = -116;
                return arrs;
            }
            short[] arrs = new short[4];
            arrs[0] = -12;
            arrs[1] = -13;
            arrs[2] = -15;
            arrs[3] = -16;
            return arrs;
        }
        if (\u985e\u578b.\u589c\u98fe((int)a2)) {
            if (bl) {
                short[] arrs = new short[2];
                arrs[0] = -117;
                arrs[1] = -136;
                return arrs;
            }
            short[] arrs = new short[2];
            arrs[0] = -17;
            arrs[1] = -36;
            return arrs;
        }
        if (\u985e\u578b.\u9a0e\u5bf5((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -18;
            return arrs;
        }
        if (\u985e\u578b.\u99ac\u978d((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -19;
            return arrs;
        }
        if (\u985e\u578b.\u52f3\u7ae0((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -21;
            return arrs;
        }
        if (\u985e\u578b.\u8170\u5e36((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -22;
            return arrs;
        }
        if (\u985e\u578b.\u80a9\u98fe((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -28;
            return arrs;
        }
        if (\u985e\u578b.\u53e3\u888b\u9053\u5177((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -31;
            return arrs;
        }
        if (\u985e\u578b.\u6a5f\u5668\u4eba((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -32;
            return arrs;
        }
        if (\u985e\u578b.\u5fc3\u81df((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -33;
            return arrs;
        }
        if (\u985e\u578b.\u80f8\u7ae0((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -34;
            return arrs;
        }
        if (\u985e\u578b.\u80fd\u6e90((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -35;
            return arrs;
        }
        if (\u985e\u578b.\u5bf5\u7269\u88dd\u5099((int)a2)) {
            short[] arrs = new short[3];
            arrs[0] = -114;
            arrs[1] = -124;
            arrs[2] = -126;
            return arrs;
        }
        if (\u985e\u578b.\u9f8d\u9762\u5177((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1000;
            return arrs;
        }
        if (\u985e\u578b.\u9f8d\u589c\u98fe((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1001;
            return arrs;
        }
        if (\u985e\u578b.\u9f8d\u4e4b\u7ffc((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1002;
            return arrs;
        }
        if (\u985e\u578b.\u9f8d\u5c3e\u5df4((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1003;
            return arrs;
        }
        if (\u985e\u578b.\u5f15\u64ce((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1100;
            return arrs;
        }
        if (\u985e\u578b.\u624b\u81c2((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1101;
            return arrs;
        }
        if (\u985e\u578b.\u8173((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1102;
            return arrs;
        }
        if (\u985e\u578b.\u6a5f\u6bbc((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1103;
            return arrs;
        }
        if (\u985e\u578b.\u6676\u9ad4\u7ba1((int)a2)) {
            short[] arrs = new short[1];
            arrs[0] = -1104;
            return arrs;
        }
        if (\u985e\u578b.\u5716\u9a30((int)a2)) {
            short[] arrs = new short[3];
            arrs[0] = -5000;
            arrs[1] = -5001;
            arrs[2] = -5002;
            return arrs;
        }
        return new short[0];
    }

    public static /* synthetic */ boolean isEquipScroll(int a2) {
        return a2 / 100 == 20493;
    }

    public static /* synthetic */ boolean \u5176\u4ed6(int a2) {
        return a2 / 10000 >= 400 && a2 / 10000 < 500;
    }

    public static /* synthetic */ boolean is\u96d9\u5200\u526f\u624b(int a2) {
        return a2 / 10000 == 134;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean \u5973\u9aee\u578b(int a2) {
        if (a2 == 32160 || a2 == 32330 || a2 == 34740) {
            return false;
        }
        if (a2 / 1000 == 31 || a2 / 1000 == 34 || a2 / 1000 == 32 && a2 < 32370 || a2 / 1000 == 37 && a2 < 37160) {
            return true;
        }
        switch (a2) {
            case 33030: 
            case 33160: 
            case 33590: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isPotentialAddScroll(int a2) {
        return a2 / 100 == 20483 && (a2 < 2048200 || a2 > 2048304);
    }

    public static /* synthetic */ boolean isInBag(int a2, int a3) {
        return a2 >= 101 && a2 <= 512 && a3 == MapleInventoryType.ETC.getType();
    }

    public static /* synthetic */ boolean is\u6280\u80fd\u66f8(int a2) {
        return a2 / 10000 == 228 || a2 / 10000 == 229;
    }

    public static /* synthetic */ boolean isForGM(int a2) {
        return a2 >= 2049335 && a2 <= 2049349 || a2 == 2430011 || a2 == 2430012 || a2 == 2430124 || a2 == 2002085;
    }

    public static /* synthetic */ boolean isMechanicItem(int a2) {
        return a2 >= 1610000 && a2 < 1660000;
    }

    public static /* synthetic */ boolean \u7537\u81c9\u578b(int a2) {
        return a2 / 1000 == 20;
    }

    public static /* synthetic */ boolean is\u5e7b\u5f71\u5361\u7247(int a2) {
        return a2 >= 0x14A1A4 && a2 <= 1352107;
    }

    public static /* synthetic */ boolean isOverPoweredEquip(MapleClient a2, int a32, short a4) {
        Equip a32 = (Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a4);
        return a32.getAcc() > 1000 || a32.getAvoid() > 1000 || a32.getStr() > 500 || a32.getDex() > 500 || a32.getInt() > 500 || a32.getLuk() > 500 || a32.getEnhance() > 25 || a32.getHands() > 100 || a32.getHp() > 5000 || a32.getMp() > 5000 || a32.getJump() > 100 || a32.getSpeed() > 100 || a32.getMatk() > 1000 || a32.getMdef() > 1500 || a32.getUpgradeSlots() > 32 || a32.getViciousHammer() > 1 || a32.getWatk() > 1000 || a32.getWdef() > 1500;
    }

    public static /* synthetic */ int[] getAndroidEquipedSlot(int a2) {
        if (\u985e\u578b.\u5e3d\u5b50((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1200;
            return arrn;
        }
        if (\u985e\u578b.\u62ab\u98a8((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1201;
            return arrn;
        }
        if (\u985e\u578b.\u81c9\u98fe((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1202;
            return arrn;
        }
        if (\u985e\u578b.\u4e0a\u8863((int)a2) || \u985e\u578b.\u5957\u670d((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1203;
            return arrn;
        }
        if (\u985e\u578b.\u8932\u88d9((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1204;
            return arrn;
        }
        if (\u985e\u578b.\u978b\u5b50((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1205;
            return arrn;
        }
        if (\u985e\u578b.\u624b\u5957((int)a2)) {
            int[] arrn = new int[1];
            arrn[0] = -1206;
            return arrn;
        }
        return new int[0];
    }

    public static /* synthetic */ boolean \u7279\u6b8a(int a2) {
        return a2 / 1000 >= 500;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isChaosForGoodness(int a2) {
        if (!ItemConstants.isChaosScroll(a2)) {
            return false;
        }
        switch (a2) {
            case 2049122: 
            case 2049124: 
            case 2049127: 
            case 2049129: 
            case 2049130: 
            case 2049131: 
            case 2049135: 
            case 2049136: 
            case 2049137: 
            case 2049140: 
            case 2049155: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isMadeByGM(MapleClient a2, int a32, short a42) {
        Equip a32 = (Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a42);
        MapleCharacter a42 = a2.getChannelServer().getPlayerStorage().getCharacterByName(a32.getOwner());
        if (a32.getOwner() == null || a32.getOwner().isEmpty() || a42 == null) {
            return false;
        }
        return a42.isStaff();
    }

    public static /* synthetic */ boolean is\u96d9\u624b\u6b66\u5668\u5377\u8ef8(int a2) {
        return a2 / 100 == 20461 || a2 / 100 == 20471;
    }

    public static /* synthetic */ int getReverseRequiredEXP(int a2) {
        return 60 + a2 * 5;
    }

    public static /* synthetic */ boolean is\u88dd\u5099\u5f37\u5316\u5377\u8ef8(int a2) {
        return a2 / 100 == 20493;
    }

    public static /* synthetic */ boolean is\u7279\u6b8a\u5377\u8ef8(int a2) {
        return ItemConstants.is\u5e78\u904b\u5377\u8ef8(a2) || ItemConstants.is\u9632\u66b4\u5377\u8ef8(a2) || ItemConstants.is\u5b89\u5168\u5377\u8ef8(a2) || ItemConstants.is\u4fdd\u8b77\u5377\u8ef8(a2) || ItemConstants.is\u5377\u8ef8\u9632\u8b77\u5377\u8ef8(a2) || ItemConstants.is\u5e36\u6210\u529f\u7387\u7279\u6b8a\u5377\u8ef8(a2) || ItemConstants.is\u5377\u8ef8\u4fdd\u8b77\u5361(a2);
    }

    public static /* synthetic */ boolean isResetScroll(int a2) {
        return a2 / 100 == 20496;
    }

    public static /* synthetic */ boolean \u81c9\u578b(int a2) {
        return a2 / 10000 == 2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean \u7537\u9aee\u578b(int a2) {
        if (a2 == 33030 || a2 == 33160 || a2 == 33590) {
            return false;
        }
        if (a2 / 1000 == 30 || a2 / 1000 == 33 || a2 / 1000 == 32 && a2 >= 32370 || a2 / 1000 == 36 || a2 / 1000 == 37 && a2 >= 37160 && a2 <= 37170) {
            return true;
        }
        switch (a2) {
            case 32160: 
            case 32330: 
            case 34740: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean \u6d88\u8017(int a2) {
        return a2 / 10000 >= 200 && a2 / 10000 < 300;
    }

    public static /* synthetic */ boolean isEvanDragonItem(int a2) {
        return a2 >= 1940000 && a2 < 1980000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getCoreMinByLevel(int a2) {
        switch (a2) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 3;
            }
            case 7: {
                return 4;
            }
            case 8: {
                return 4;
            }
            case 9: {
                return 5;
            }
            case 10: {
                return 6;
            }
            case 11: {
                return 6;
            }
            case 12: {
                return 7;
            }
            case 13: {
                return 7;
            }
            case 14: {
                return 8;
            }
            case 15: {
                return 9;
            }
        }
        return 0;
    }

    public static /* synthetic */ boolean is\u9644\u52a0\u6f5b\u80fd\u5377\u8ef8(int a2) {
        return a2 / 100 == 20483 && (a2 < 2048200 || a2 > 2048304);
    }

    public static /* synthetic */ boolean is\u9748\u9b42\u624b\u9432(int a2) {
        return a2 >= 1352600 && a2 <= 1352604;
    }

    public static /* synthetic */ boolean is\u767d\u8863\u5377\u8ef8(int a2) {
        return a2 / 100 == 20490;
    }

    public static /* synthetic */ boolean is\u64f4\u5145\u80cc\u5305(int a2) {
        return a2 >= 4330000 && a2 <= 4330015;
    }

    public static /* synthetic */ boolean isMonsterCard(int a2) {
        return a2 / 10000 == 238;
    }

    public static /* synthetic */ boolean is\u70d9\u5370\u5370\u7ae0(int a2) {
        return a2 / 100 == 20495;
    }

    public static /* synthetic */ int getEffectItemID(int a2) {
        Map<String, Integer> map = MapleItemInformationProvider.getInstance().getEquipStats(a2);
        if (map.containsKey(ClientRedirector.ALLATORIxDEMO("!S\"P'A\rA!X\rq"))) {
            return map.get(UserInterfaceHandler.ALLATORIxDEMO("^R]QX@r@^Yrp"));
        }
        return 0;
    }

    public static /* synthetic */ boolean is\u55ae\u624b\u6b66\u5668\u5377\u8ef8(int a2) {
        return a2 / 100 == 20460 || a2 / 100 == 20469 || a2 / 100 == 20470;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u900f\u660e\u77ed\u5200(int a2) {
        switch (a2) {
            case 1342069: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5e36\u6210\u529f\u7387\u7279\u6b8a\u5377\u8ef8(int a2) {
        switch (a2) {
            case 2040727: 
            case 2041058: {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ boolean canTradeByCut(int a2) {
        return ItemFlag.KARMA_EQ.check(a2) || ItemFlag.KARMA_USE.check(a2);
    }

    public static /* synthetic */ boolean is\u63d0\u5347\u5377(int a2) {
        return a2 >= 2047000 && a2 < 2047310;
    }

    public static /* synthetic */ boolean \u57ce\u93ae\u50b3\u9001\u5377\u8ef8(int a2) {
        return a2 >= 2030000 && a2 < 2040000;
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

    public static /* synthetic */ boolean is\u88dd\u5099\u4fdd\u8b77\u5377\u8ef8(int a2) {
        return a2 == 5064000 || a2 == 2531000;
    }

    public static /* synthetic */ boolean isChaosScroll(int a2) {
        if (a2 >= 2049105 && a2 <= 2049110) {
            return false;
        }
        return a2 / 100 == 20491;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u6a02\u89c0\u6df7\u6c8c\u5377\u8ef8(int a2) {
        if (!ItemConstants.is\u6df7\u6c8c\u5377\u8ef8(a2)) {
            return false;
        }
        switch (a2) {
            case 2049122: 
            case 2049129: 
            case 2049130: 
            case 2049131: 
            case 2049135: 
            case 2049136: 
            case 2049137: 
            case 2049141: 
            case 2049153: 
            case 2049155: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5377\u8ef8\u9632\u8b77\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5064300: 
            case 5068200: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean \u7279\u6b8a\u6f5b\u80fd\u9053\u5177(int a2) {
        if (a2 / 100 == 10121 && a2 % 100 >= 64 && a2 % 100 <= 74 && a2 % 100 != 65 && a2 % 100 != 66) {
            return true;
        }
        if (a2 / 10 == 112212 && a2 % 10 >= 2 && a2 % 10 <= 6) {
            return true;
        }
        if (a2 >= 1122224 && a2 <= 1122245) {
            return true;
        }
        return a2 / 10 == 101244;
    }

    public static /* synthetic */ boolean is\u9b54\u6cd5\u7bad(int a2) {
        return a2 >= 1352000 && a2 <= 1352007;
    }

    public static /* synthetic */ boolean is\u9f8d\u50b3\u5bf6\u76d2(int a2) {
        return a2 >= 1352300 && a2 <= 1352304;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isLockedCard(int a2) {
        switch (a2) {
            case 2382001: 
            case 2382005: 
            case 2382008: 
            case 2382028: 
            case 2382052: 
            case 2383003: 
            case 2383004: 
            case 2383006: 
            case 2383010: 
            case 2388000: 
            case 2388002: 
            case 2388003: 
            case 2388005: 
            case 2388006: 
            case 2388007: 
            case 2388008: 
            case 2388009: 
            case 2388010: 
            case 2388016: 
            case 2388022: 
            case 2388023: 
            case 2388025: 
            case 2388029: 
            case 2388030: 
            case 2388031: 
            case 2388032: 
            case 2388033: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean is\u9632\u5177\u5377\u8ef8(int a2) {
        return a2 / 100 == 20462 || a2 / 100 == 20465;
    }

    public static /* synthetic */ boolean WashHpEquipBan(MapleClient a2, short a32) {
        if (!GameSetConstants.WASH_HP_MAGICIAN_BAN) {
            return false;
        }
        if (a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a32) != null && (MapleJob.is\u70c8\u7130\u5deb\u5e2b(a2.getPlayer().getJob()) || MapleJob.is\u6cd5\u5e2b(a2.getPlayer().getJob()) || MapleJob.isBeginner(a2.getPlayer().getJob()) || MapleJob.is\u9f8d\u9b54\u5c0e\u58eb(a2.getPlayer().getJob()))) {
            Equip a32 = (Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a32);
            return a32.getInt() > 150 && !MapleItemInformationProvider.getInstance().isCash(a32.getItemId());
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getMaxLevel(int a2) {
        if (ItemConstants.is\u6c38\u6046\u88dd\u5099(a2)) {
            return 5;
        }
        if (ItemConstants.is\u9f8d\u50b3\u5bf6\u76d2(a2)) {
            return 4;
        }
        if (ItemConstants.is\u5f37\u5316\u88dd\u5099(a2)) {
            return 3;
        }
        switch (a2) {
            case 0x10C110: 
            case 0x10C111: 
            case 1098002: 
            case 1099000: 
            case 1099002: 
            case 1099003: {
                return 4;
            }
            case 1098003: 
            case 1099004: {
                return 10;
            }
            case 1302108: 
            case 1302109: 
            case 1312040: 
            case 1312041: 
            case 1322066: 
            case 1322067: 
            case 1332082: 
            case 1332083: 
            case 1372047: 
            case 1372048: 
            case 1382063: 
            case 1382064: 
            case 1402054: 
            case 1402055: 
            case 1412036: 
            case 1412037: 
            case 1422040: 
            case 1422041: 
            case 1432051: 
            case 1432052: 
            case 1442072: 
            case 1442073: 
            case 1452063: 
            case 1452064: 
            case 1462057: 
            case 1462058: 
            case 1472078: 
            case 1472079: 
            case 1482035: 
            case 1482036: {
                return 1;
            }
            case 1072376: {
                return 2;
            }
        }
        Map<Integer, Map<String, Integer>> map = MapleItemInformationProvider.getInstance().getEquipIncrements(a2);
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public static /* synthetic */ boolean is\u5f8c\u671f\u5377\u8ef8(int a2) {
        return a2 / 10000 == 261;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u9632\u66b4\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5063100: 
            case 5064000: 
            case 5064003: {
                return true;
            }
        }
        return a2 / 1000 == 2531;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getCoreMaxByLevel(int a2) {
        switch (a2) {
            case 1: {
                return 2;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 6;
            }
            case 4: {
                return 8;
            }
            case 5: {
                return 10;
            }
            case 6: {
                return 12;
            }
            case 7: {
                return 14;
            }
            case 8: {
                return 16;
            }
            case 9: {
                return 18;
            }
            case 10: {
                return 20;
            }
            case 11: {
                return 23;
            }
            case 12: {
                return 28;
            }
            case 13: {
                return 35;
            }
            case 14: {
                return 44;
            }
            case 15: {
                return 55;
            }
        }
        return 2;
    }

    public static /* synthetic */ boolean \u88dd\u5099(int a2) {
        return a2 / 10000 >= 100 && a2 / 10000 < 200;
    }

    public static /* synthetic */ MapleWeaponType \u6b66\u5668\u985e\u578b(int a2) {
        if (\u985e\u578b.\u55ae\u624b\u528d((int)a2)) {
            return MapleWeaponType.\u55ae\u624b\u528d;
        }
        if (\u985e\u578b.\u55ae\u624b\u65a7((int)a2)) {
            return MapleWeaponType.\u55ae\u624b\u65a7;
        }
        if (\u985e\u578b.\u55ae\u624b\u68cd((int)a2)) {
            return MapleWeaponType.\u55ae\u624b\u68cd;
        }
        if (\u985e\u578b.\u77ed\u528d((int)a2)) {
            return MapleWeaponType.\u77ed\u528d;
        }
        if (\u985e\u578b.\u77ed\u6756((int)a2)) {
            return MapleWeaponType.\u77ed\u6756;
        }
        if (\u985e\u578b.\u9577\u6756((int)a2)) {
            return MapleWeaponType.\u9577\u6756;
        }
        if (\u985e\u578b.\u96d9\u624b\u528d((int)a2)) {
            return MapleWeaponType.\u96d9\u624b\u528d;
        }
        if (\u985e\u578b.\u96d9\u624b\u65a7((int)a2)) {
            return MapleWeaponType.\u96d9\u624b\u65a7;
        }
        if (\u985e\u578b.\u96d9\u624b\u68cd((int)a2)) {
            return MapleWeaponType.\u96d9\u624b\u68cd;
        }
        if (\u985e\u578b.\u69cd((int)a2)) {
            return MapleWeaponType.\u69cd;
        }
        if (\u985e\u578b.\u77db((int)a2)) {
            return MapleWeaponType.\u77db;
        }
        if (\u985e\u578b.\u5f13((int)a2)) {
            return MapleWeaponType.\u5f13;
        }
        if (\u985e\u578b.\u5f29((int)a2)) {
            return MapleWeaponType.\u5f29;
        }
        if (\u985e\u578b.\u62f3\u5957((int)a2)) {
            return MapleWeaponType.\u62f3\u5957;
        }
        if (\u985e\u578b.\u6307\u864e((int)a2)) {
            return MapleWeaponType.\u6307\u864e;
        }
        if (\u985e\u578b.\u706b\u69cd((int)a2)) {
            return MapleWeaponType.\u706b\u69cd;
        }
        return MapleWeaponType.\u672a\u77e5;
    }

    public static /* synthetic */ boolean sub_609CDE(int a2, int a3) {
        return a3 - 3 <= 1 && a2 >= 0 && a2 < ItemConstants.sub_5015E5(a3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getRewardPot(int a2, int a3) {
        switch (a2) {
            case 2440000: {
                switch (a3 / 10) {
                    case 0: 
                    case 1: 
                    case 2: {
                        return 2028041 + a3 / 10;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        return 2028046 + a3 / 10;
                    }
                    case 6: 
                    case 7: 
                    case 8: {
                        return 2028049 + a3 / 10;
                    }
                }
                return 2028057;
            }
            case 2440001: {
                switch (a3 / 10) {
                    case 0: 
                    case 1: 
                    case 2: {
                        return 2028044 + a3 / 10;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        return 2028049 + a3 / 10;
                    }
                    case 6: 
                    case 7: 
                    case 8: {
                        return 2028052 + a3 / 10;
                    }
                }
                return 2028060;
            }
            case 2440002: {
                return 2028069;
            }
            case 2440003: {
                return 2430278;
            }
            case 2440004: {
                return 2430381;
            }
            case 2440005: {
                return 2430393;
            }
        }
        return 0;
    }

    public /* synthetic */ ItemConstants() {
        ItemConstants a2;
    }

    public static /* synthetic */ boolean isChair(int a2) {
        return a2 / 10000 == 302;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u56de\u771f\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5064200: 
            case 5064201: {
                return true;
            }
        }
        return a2 / 100 == 20496;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isAzwanScroll(int a2) {
        switch (a2) {
            case 2046060: 
            case 2046061: 
            case 2046062: 
            case 2046063: 
            case 2046064: 
            case 2046065: 
            case 2046066: 
            case 2046067: 
            case 2046068: 
            case 2046069: 
            case 2046141: 
            case 2046142: 
            case 2046143: 
            case 2046144: 
            case 2046145: 
            case 2046519: 
            case 2046520: 
            case 2046521: 
            case 2046522: 
            case 2046523: 
            case 2046524: 
            case 2046525: 
            case 2046526: 
            case 2046527: 
            case 2046528: 
            case 2046529: 
            case 2046530: 
            case 2046701: 
            case 2046702: 
            case 2046703: 
            case 2046704: 
            case 2046705: 
            case 2046706: 
            case 2046707: 
            case 2046708: 
            case 2046709: 
            case 2046710: 
            case 2046711: 
            case 2046712: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getCubeFragment(int a2) {
        switch (a2) {
            case 5062000: {
                return 2430112;
            }
            case 5062002: {
                return 2430481;
            }
            case 5062004: {
                return 2432114;
            }
            case 5062005: {
                return 2430759;
            }
            case 5062006: {
                return 2431427;
            }
            case 5062009: {
                return 2431893;
            }
            case 5062010: {
                return 2431894;
            }
            case 5062013: {
                return 2432115;
            }
            case 5062090: {
                return 2431445;
            }
            case 0x4D3DD4: {
                return 2430112;
            }
            case 5062102: {
                return 2430112;
            }
            case 5062103: {
                return 2430112;
            }
            case 5062500: {
                return 2430915;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5b89\u5168\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5064100: 
            case 5064101: 
            case 0x4D5544: {
                return true;
            }
        }
        return a2 / 1000 == 2532;
    }

    public static /* synthetic */ boolean is\u60e1\u9b54\u6bba\u624b\u76fe(int a2) {
        return a2 >= 1099000 && a2 <= 1099009;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5377\u8ef8\u4fdd\u8b77\u5361(int a2) {
        switch (a2) {
            case 5064300: 
            case 0x4D466D: 
            case 5068200: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isExpChair(int a2) {
        switch (a2 / 10000) {
            case 302: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean \u9435\u939a(int a2) {
        return a2 / 10000 == 247;
    }

    public static /* synthetic */ boolean isOverPoweredEquip(MapleClient a2, short a32) {
        if (a2.getPlayer().isGM() || !GameSetConstants.OVERPOWER_EQUIPCHECK) {
            return false;
        }
        if (a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a32) != null && a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a32).getItemId() < 2000000) {
            Equip a32 = (Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a32);
            return a32.getAcc() > 255 || a32.getAvoid() > 255 || a32.getStr() > 500 || a32.getDex() > 500 || a32.getInt() > 500 || a32.getLuk() > 500 || a32.getEnhance() > 25 || a32.getHands() > 100 || a32.getHp() > 10000 || a32.getMp() > 10000 || a32.getJump() > 100 || a32.getSpeed() > 100 || a32.getMatk() > 1000 || a32.getMdef() > 1500 || a32.getUpgradeSlots() > 32 || a32.getViciousHammer() > 1 || a32.getWatk() > 1000 || a32.getWdef() > 1500;
        }
        return false;
    }

    public static /* synthetic */ boolean \u666e\u901a\u5347\u7d1a\u5377\u8ef8(int a2) {
        return a2 >= 2040000 && a2 <= 2048100;
    }

    public static /* synthetic */ boolean isHarvesting(int a2) {
        return a2 >= 1500000 && a2 < 1520000;
    }

    public static /* synthetic */ boolean is\u8afe\u5df4\u7cbe\u9ad3(int a2) {
        return a2 >= 1352500 && a2 <= 1352504;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isScroll(int a2) {
        switch (a2 / 10000) {
            case 204: 
            case 253: {
                return true;
            }
        }
        switch (a2 / 1000) {
            case 5063: 
            case 5064: 
            case 5068: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean \u88dd\u98fe(int a2) {
        return a2 / 10000 >= 300 && a2 / 10000 < 400;
    }

    public static /* synthetic */ boolean is\u706b\u9f8d\u7684\u773c\u73e0(int a2) {
        return a2 == 5064001;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5f37\u5316\u88dd\u5099(int a2) {
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
            case 1052379: 
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
            case 1492025: 
            case 1942002: 
            case 1952002: 
            case 1962002: 
            case 1972002: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ long getCubeNeedMeso(Equip a2) {
        int n2;
        int n3 = MapleItemInformationProvider.getInstance().getReqLevel(a2.getItemId());
        int n4 = 0;
        if (n3 >= 120) {
            n4 = 20;
            n2 = n3;
        } else if (n3 >= 70) {
            n4 = 5;
            n2 = n3;
        } else {
            if (n3 >= 30) {
                n4 = 1;
            }
            n2 = n3;
        }
        double d2 = n2;
        n3 = 2;
        double d3 = 1.0;
        int n5 = n3;
        while (true) {
            if ((n5 & 1) != 0) {
                d3 *= d2;
            }
            if ((n3 >>= 1) == 0) break;
            double d4 = d2;
            d2 = d4 * d4;
            n5 = n3;
        }
        n3 = (int)Math.ceil(d3);
        return (n4 * n3 <= 0 ? 1 : 0) - 1 & n4 * n3;
    }

    public static /* synthetic */ boolean is\u63a7\u5236\u5668(int a2) {
        return a2 >= 1353000 && a2 <= 1353004;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isGMEquip(int a2) {
        switch (a2) {
            case 1002140: 
            case 1002959: 
            case 1003142: 
            case 1042003: 
            case 1062007: 
            case 1322013: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean \u9aee\u578b(int a2) {
        return a2 / 10000 == 3;
    }

    public static /* synthetic */ boolean is\u98fe\u54c1\u5377\u8ef8(int a2) {
        return a2 / 100 == 20492 || a2 / 100 == 20463 || a2 / 100 == 20467;
    }

    public static /* synthetic */ boolean \u5973\u81c9\u578b(int a2) {
        return a2 / 1000 == 21;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u5e78\u904b\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5063100: 
            case 5068000: {
                return true;
            }
        }
        return a2 / 1000 == 2530;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean getSpecialItem(int a2, MapleCharacter a3) {
        boolean bl = false;
        if (!GameSetConstants.SPECIAL_ITEM) return bl;
        switch (a2) {
            case 4031466: {
                if (!GameSetConstants.UNDER_CITY) return bl;
                if (a3.getMapId() < 100020100) return bl;
                if (a3.getMapId() > 100020129) return bl;
                MapleCharacter mapleCharacter = a3;
                mapleCharacter.addPotentialAll(1);
                mapleCharacter.dropMessageAll("\u60a8\u5df2\u7372\u5f97\u6f5b\u80fd\u80fd\u91cf:0.01%! \u76ee\u524d\u7d2f\u7a4d\u6f5b\u80fd\u80fd\u91cf:" + (double)mapleCharacter.getPotentialAll() * 0.01 + "%");
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u4fdd\u8b77\u5377\u8ef8(int a2) {
        switch (a2) {
            case 5063100: 
            case 5064000: 
            case 5064002: 
            case 5064003: 
            case 0x4D4544: {
                return true;
            }
        }
        return a2 / 1000 == 2531;
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

    public static /* synthetic */ boolean is\u88dd\u5099\u5377\u8ef8(int a2) {
        return a2 / 100 == 20493;
    }

    public static /* synthetic */ boolean is\u9748\u9b42\u76fe(int a2) {
        return a2 >= 0x10C110 && a2 <= 1098003;
    }

    public static /* synthetic */ boolean \u8010\u4e45\u5ea6\u53ef\u4f7f\u7528\u5377\u8ef8(int a2) {
        return a2 >= 2047000 && a2 < 2047310 || a2 / 1000 == 2049;
    }

    public static /* synthetic */ int getTimelessRequiredEXP(int a2) {
        return 70 + a2 * 10;
    }

    public static /* synthetic */ int getExpForLevel(int a2, int a3) {
        if (ItemConstants.is\u5f37\u5316\u88dd\u5099(a3)) {
            return ItemConstants.getReverseRequiredEXP(a2);
        }
        if (ItemConstants.getMaxLevel(a3) > 0) {
            return ItemConstants.getTimelessRequiredEXP(a2);
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int sub_5015E5(int a2) {
        switch (a2) {
            case 3: {
                return 2;
            }
            case 4: {
                return 6;
            }
        }
        return 0;
    }

    public static /* synthetic */ boolean is\u6f5b\u5728\u80fd\u529b\u5377\u8ef8(int a2) {
        return a2 / 100 == 20494 || a2 / 100 == 20497 || a2 == 5534000;
    }

    public static /* synthetic */ boolean is\u9748\u9b42\u5377\u8ef8(int a2) {
        return a2 / 100 == 25900;
    }

    public static /* synthetic */ boolean is\u6df7\u6c8c\u5377\u8ef8(int a2) {
        if (a2 >= 2049105 && a2 <= 2049110) {
            return false;
        }
        return a2 / 100 == 20491 || a2 == 2040126;
    }

    public static /* synthetic */ int getCustomReactItem(int a2, int a3) {
        if (a2 == 2008006) {
            return Calendar.getInstance().get(7) + 4001055;
        }
        return a3;
    }

    public static /* synthetic */ boolean is\u8077\u696d\u7279\u6b8a\u88dd\u5099(int a2) {
        return ItemConstants.is\u9b54\u6cd5\u7bad(a2) || ItemConstants.is\u63a7\u5236\u5668(a2) || ItemConstants.is\u9748\u9b42\u624b\u9432(a2) || ItemConstants.is\u8afe\u5df4\u7cbe\u9ad3(a2) || ItemConstants.is\u9748\u9b42\u76fe(a2) || ItemConstants.is\u60e1\u9b54\u6bba\u624b\u76fe(a2) || ItemConstants.is\u9f8d\u50b3\u5bf6\u76d2(a2) || ItemConstants.is\u5e7b\u5f71\u5361\u7247(a2) || ItemConstants.is\u96d9\u5200\u526f\u624b(a2);
    }
}

