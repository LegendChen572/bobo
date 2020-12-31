/*
 * Decompiled with CFR 0.150.
 */
package constants;

import constants.GameSetConstants;

public class MapConstants {
    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u7dad\u591a\u5229\u4e9e\u6e2f\u5730\u57df(int a2) {
        switch (a2) {
            case 104000100: 
            case 104000200: 
            case 104000300: 
            case 104000400: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isGuildPvPMap(int a2) {
        boolean bl = false;
        switch (a2) {
            case 100000000: {
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u96f2\u5f69\u516c\u5712(int a2) {
        switch (a2) {
            case 200020000: 
            case 200030000: 
            case 200040000: 
            case 200040001: 
            case 200050000: 
            case 200060000: 
            case 200070000: 
            case 200080000: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isRabbitMap(int a2) {
        switch (a2) {
            case 742010100: 
            case 742010102: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u7334\u5b50\u68ee\u6797(int a2) {
        switch (a2) {
            case 100040101: 
            case 100040102: 
            case 100040103: 
            case 100040104: 
            case 107000401: 
            case 107000402: 
            case 107000403: 
            case 191000000: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean BanItemMoveMap(int a2) {
        switch (a2) {
            case 741000100: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u9748\u85e5\u5e7b\u5883(int a2) {
        switch (a2) {
            case 251010000: 
            case 251010100: 
            case 251010101: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = 4 << 4 ^ (2 ^ 5) << 1;
        int n5 = n3;
        int n6 = 3 << 3;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isStartingEventMap(int a2) {
        switch (a2) {
            case 109010000: 
            case 109020001: 
            case 109030001: 
            case 109030101: 
            case 109030201: 
            case 109030301: 
            case 109030401: 
            case 109040000: 
            case 109060001: 
            case 109060002: 
            case 109060003: 
            case 109060004: 
            case 109060005: 
            case 109060006: 
            case 109080000: 
            case 109080001: 
            case 109080002: 
            case 109080003: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean is\u6b66\u9675\u9053\u5834(int a2) {
        return a2 / 10000 == 92502 || a2 / 10000 == 92506;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isBossMap(int a2) {
        if (a2 / 10000 == 92502) {
            return true;
        }
        switch (a2) {
            case 105100300: 
            case 220080001: 
            case 230040420: 
            case 240060000: 
            case 240060100: 
            case 240060200: 
            case 270010500: 
            case 270020500: 
            case 270030500: 
            case 270050100: 
            case 280030000: 
            case 280030001: 
            case 551030200: 
            case 740000000: 
            case 741020101: 
            case 741020102: 
            case 749040001: 
            case 749050301: 
            case 802000211: 
            case 802000611: 
            case 922010900: 
            case 925020200: 
            case 930000600: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isBlockWarpMap(int a2) {
        int n2 = a2 / 100000;
        if (MapConstants.isEventMap(a2)) {
            return true;
        }
        if (n2 == 9800 && (a2 % 10 == 1 || a2 % 1000 == 100)) {
            return true;
        }
        if (a2 / 10000 == 92502) {
            return true;
        }
        if (n2 == 7090) {
            return true;
        }
        if (n2 == 1090) {
            return true;
        }
        switch (a2) {
            case 702060000: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isBanGlobalDrop(int a2) {
        switch (a2) {
            case 925100100: 
            case 925100400: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isVonleonMap(int a2) {
        switch (a2) {
            case 211060000: 
            case 211060010: 
            case 211060100: 
            case 211060200: 
            case 211060201: 
            case 211060300: 
            case 211060400: 
            case 211060401: 
            case 211060410: 
            case 211060500: 
            case 211060600: 
            case 211060601: 
            case 211060610: 
            case 211060620: 
            case 211060700: 
            case 211060800: 
            case 211060801: 
            case 211060810: 
            case 211060820: 
            case 211060830: 
            case 211060900: 
            case 211061000: 
            case 211061001: 
            case 211061100: 
            case 211061101: 
            case 211061102: 
            case 211061103: 
            case 211061104: 
            case 211061105: 
            case 211061106: 
            case 211061107: 
            case 211061108: 
            case 211061109: 
            case 211070000: 
            case 211070100: 
            case 211070101: 
            case 211070102: 
            case 211070103: 
            case 211070110: 
            case 211070111: 
            case 211070200: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isPVPMap(int a2) {
        switch (a2) {
            case 689000000: 
            case 689000010: 
            case 960010100: 
            case 960010101: 
            case 960010102: 
            case 960020100: 
            case 960020101: 
            case 960020102: 
            case 960020103: 
            case 960030100: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMobVac_y(int a2) {
        switch (a2) {
            case 1210100: 
            case 1210101: 
            case 1210102: 
            case 1210103: 
            case 2220100: 
            case 2230100: 
            case 2230101: 
            case 2230102: 
            case 3000005: 
            case 3000006: 
            case 3110101: 
            case 3210100: 
            case 3210200: 
            case 3210201: 
            case 3210202: 
            case 3210203: 
            case 3210800: 
            case 3230100: 
            case 3230101: 
            case 3230102: 
            case 3230200: 
            case 3230302: 
            case 4090000: 
            case 4230100: 
            case 4230102: 
            case 4230103: 
            case 4230104: 
            case 4230106: 
            case 4230108: 
            case 4230119: 
            case 4230120: 
            case 4230121: 
            case 4240000: 
            case 5120000: 
            case 5120001: 
            case 5120002: 
            case 5120003: 
            case 5130104: 
            case 5130106: 
            case 5410000: 
            case 6130101: 
            case 6230100: 
            case 7130000: 
            case 9000001: 
            case 9000100: 
            case 9000101: 
            case 9000200: 
            case 9000201: 
            case 9000300: 
            case 9000301: 
            case 9100000: 
            case 9101001: 
            case 9200000: 
            case 9200001: 
            case 9200006: 
            case 9200008: 
            case 9200010: 
            case 9200011: 
            case 9200013: 
            case 9200014: 
            case 9200015: 
            case 9200017: 
            case 9200019: 
            case 9200102: 
            case 9300002: 
            case 9300003: 
            case 9300004: 
            case 9300058: 
            case 9300059: 
            case 9300060: 
            case 9300127: 
            case 9300128: 
            case 9300155: 
            case 9300187: 
            case 9300191: 
            case 9300225: 
            case 9300227: 
            case 9300228: 
            case 9300229: 
            case 9300238: 
            case 9300251: 
            case 9300259: 
            case 9300334: 
            case 9300335: 
            case 9300336: 
            case 9300337: 
            case 9303002: 
            case 9303004: 
            case 9400201: 
            case 9400241: 
            case 9400242: 
            case 9400245: 
            case 9400520: 
            case 9400523: 
            case 9400524: 
            case 9400525: 
            case 9400527: 
            case 9400532: 
            case 9410003: 
            case 9410009: 
            case 9410057: 
            case 9500101: 
            case 9500103: 
            case 9500110: 
            case 9500111: 
            case 9500113: 
            case 9500115: 
            case 9500121: 
            case 9500122: 
            case 9500124: 
            case 9500131: 
            case 9500156: 
            case 9500157: 
            case 9500168: 
            case 9500203: 
            case 9500204: 
            case 9500325: 
            case 9500326: 
            case 9500340: 
            case 9500345: 
            case 9500369: 
            case 9500370: 
            case 9500371: 
            case 9500372: 
            case 9610000: 
            case 9610001: 
            case 9611003: 
            case 9611004: 
            case 9611006: 
            case 9612000: 
            case 9612001: 
            case 9612002: 
            case 9612003: 
            case 9612004: 
            case 9612005: 
            case 9612006: 
            case 9613000: 
            case 9613001: 
            case 9613002: 
            case 9613003: 
            case 9613004: 
            case 9613005: 
            case 9613006: 
            case 9613007: 
            case 9614000: 
            case 9614001: 
            case 0x92B2B2: 
            case 9614003: 
            case 9614004: 
            case 9614005: 
            case 9614006: 
            case 9614007: 
            case 9615000: 
            case 9615001: 
            case 9615002: 
            case 9615003: 
            case 9615004: 
            case 9615005: 
            case 9615006: 
            case 9615007: 
            case 9616000: 
            case 9616001: 
            case 9616002: 
            case 9616003: 
            case 9616004: 
            case 9616005: 
            case 9616006: 
            case 9616007: 
            case 9616008: 
            case 9617000: 
            case 9617001: 
            case 9617002: 
            case 9617003: 
            case 9617004: 
            case 9617005: 
            case 9617006: 
            case 9617007: 
            case 9618000: 
            case 9618001: 
            case 9618002: 
            case 9618003: 
            case 9618004: 
            case 9618005: 
            case 9618006: 
            case 9618007: 
            case 9618099: 
            case 9619000: 
            case 9619001: 
            case 9619002: 
            case 9619003: 
            case 9619004: 
            case 9619005: 
            case 9619006: 
            case 9619007: 
            case 9620000: 
            case 9620001: 
            case 9620002: 
            case 9621000: 
            case 9621001: 
            case 9621002: 
            case 9622000: 
            case 9622001: 
            case 9622002: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isTeamMap(int a2) {
        return a2 == 109080000 || a2 == 109080001 || a2 == 109080002 || a2 == 109080003 || a2 == 109080010 || a2 == 109080011 || a2 == 109080012 || a2 == 109090300 || a2 == 109090301 || a2 == 109090302 || a2 == 109090303 || a2 == 109090304 || a2 == 910040100 || a2 == 960020100 || a2 == 960020101 || a2 == 960020102 || a2 == 960020103 || a2 == 960030100 || a2 == 689000000 || a2 == 689000010;
    }

    public static /* synthetic */ boolean isMapleIsland(int a2) {
        return a2 <= 2000001;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u611b\u5967\u65af\u5854(int a2) {
        switch (a2) {
            case 221020100: 
            case 221020200: 
            case 221020300: 
            case 221020400: 
            case 221023700: 
            case 221023800: 
            case 221023900: 
            case 221024000: 
            case 221024100: 
            case 221024200: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isFishingMap(int a2) {
        int n2;
        int[] arrn = GameSetConstants.FISH_MAP;
        int n3 = GameSetConstants.FISH_MAP.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            if (arrn[n2] == a2) {
                return true;
            }
            n4 = ++n2;
        }
        switch (a2) {
            case 749050500: 
            case 749050501: 
            case 749050502: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isCakeMap(int a2) {
        return a2 >= 749020000 && a2 <= 749020800;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u8d6b\u723e\u5967\u65af\u5854(int a2) {
        switch (a2) {
            case 222020100: 
            case 222020200: 
            case 222020300: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isDropProhibitedMap(int a2) {
        switch (a2) {
            case 910000000: 
            case 910000001: 
            case 910000002: 
            case 910000003: 
            case 910000004: 
            case 910000005: 
            case 910000006: 
            case 910000007: 
            case 910000008: 
            case 910000009: 
            case 910000010: 
            case 910000011: 
            case 910000012: 
            case 910000013: 
            case 910000014: 
            case 910000015: 
            case 910000016: 
            case 910000017: 
            case 910000018: 
            case 910000019: 
            case 910000020: 
            case 910000021: 
            case 910000022: {
                return !GameSetConstants.FM_DROP;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isEventMap(int a2) {
        return a2 >= 109010000 && a2 < 109050000 || a2 > 109050001 && a2 < 109090000 || a2 >= 809040000 && a2 <= 809040100;
    }

    public static /* synthetic */ boolean isMapleLand(int a2) {
        return a2 < 1010004;
    }

    public /* synthetic */ MapConstants() {
        MapConstants a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isVonleonMobMap(int a2) {
        switch (a2) {
            case 211030900: 
            case 211060100: 
            case 211060300: 
            case 211060410: 
            case 211060500: 
            case 211060610: 
            case 211060620: 
            case 211060700: 
            case 211060810: 
            case 211060820: 
            case 211060830: {
                return true;
            }
        }
        return false;
    }
}

