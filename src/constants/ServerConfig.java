/*
 * Decompiled with CFR 0.150.
 */
package constants;

import constants.GameSetConstants;
import handling.world.guild.MapleGuild;
import java.io.File;
import java.util.Calendar;
import server.characterCards.MapleCharacterCards;
import tools.FileoutputUtil;

public class ServerConfig {
    public static /* synthetic */ int GAMBLING_CHANNEL;
    public static /* synthetic */ boolean checkCopyItem;
    public static /* synthetic */ boolean LOG_MEGA;
    public static /* synthetic */ String IP;
    public static /* synthetic */ boolean REGULAR_BONUS;
    public static /* synthetic */ boolean LOG_DAMAGE;
    public static /* synthetic */ boolean LOG_MERCHANT;
    private static /* synthetic */ String ALLATORIxDEMO;
    public static /* synthetic */ boolean AUTO_REGISTER;
    public static /* synthetic */ boolean SAVEBUFF;
    public static /* synthetic */ boolean LOG_CSBUY;
    public static /* synthetic */ boolean LOG_CHALKBOARD;
    public static /* synthetic */ boolean LOG_TRADE;
    public static /* synthetic */ String SERVER_NAME;
    public static /* synthetic */ boolean HiredMerchantBan;
    public static /* synthetic */ int PVP_CHANNEL;
    public static /* synthetic */ boolean LOG_SCROLL;
    public static /* synthetic */ boolean GAMBLING_SYSTEM;
    public static /* synthetic */ boolean LOG_CHAT;
    public static /* synthetic */ int PVP_MAP;
    public static /* synthetic */ boolean LOG_DC;
    public static /* synthetic */ boolean PVP_SYSTEM;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getDayOfWeek() {
        int n2 = Calendar.getInstance().get(7) - 1;
        String string = String.valueOf(n2);
        switch (n2) {
            case 0: {
                return MapleGuild.ALLATORIxDEMO("\u6585");
            }
            case 1: {
                return MapleCharacterCards.ALLATORIxDEMO("\u4e0c");
            }
            case 2: {
                return MapleGuild.ALLATORIxDEMO("\u4eec");
            }
            case 3: {
                return MapleCharacterCards.ALLATORIxDEMO("\u4e05");
            }
            case 4: {
                return MapleGuild.ALLATORIxDEMO("\u56bb");
            }
            case 5: {
                return MapleCharacterCards.ALLATORIxDEMO("\u4e98");
            }
            case 6: {
                return MapleGuild.ALLATORIxDEMO("\u510d");
            }
        }
        return string;
    }

    public /* synthetic */ ServerConfig() {
        ServerConfig a2;
    }

    public static /* synthetic */ String[] getEvents(boolean a2) {
        return ServerConfig.getEventList(a2).split(MapleCharacterCards.ALLATORIxDEMO(" "));
    }

    public static /* synthetic */ String getEventList(boolean a2) {
        if (ALLATORIxDEMO == null || a2) {
            int n2;
            File[] arrfile = new File(GameSetConstants.getNpcFolder() + "/event").listFiles();
            ALLATORIxDEMO = "";
            int n3 = arrfile.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                String[] arrstring = arrfile[n2];
                if (!arrstring.isDirectory() && (arrstring = arrstring.getName().split(MapleGuild.ALLATORIxDEMO("XN"))).length > 1 && MapleCharacterCards.ALLATORIxDEMO(">\u007f").equals(arrstring[arrstring.length - 1])) {
                    int n5;
                    int n6 = n5 = 0;
                    while (n6 < arrstring.length - 1) {
                        ALLATORIxDEMO = ALLATORIxDEMO + arrstring[n5++];
                        n6 = n5;
                    }
                    ALLATORIxDEMO = ALLATORIxDEMO + ",";
                }
                n4 = ++n2;
            }
        }
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ String getVipMedalName(int a2) {
        String string = "";
        if (!GameSetConstants.USE_VIPNAME) {
            return string;
        }
        int n2 = GameSetConstants.VIPNAME.length;
        if (n2 > 1 && a2 > n2) {
            FileoutputUtil.logToFile(MapleGuild.ALLATORIxDEMO("h\u000fc\u0013+%v\u0012k\u0012+\u0007a\u0014R\tt-a\u0004e\fJ\u0001i\u0005*\u0014|\u0014"), "\r\n " + FileoutputUtil.NowTime() + "\u7cfb\u7d71\u8d0a\u52a9\u52f3\u7ae0\u8a2d\u7f6e\u7570\u5e38,\u73a9\u5bb6VIP\u7b49\u7d1a:" + a2 + "\u7cfb\u7d71\u8d0a\u52a9\u52f3\u7ae0\u8a2d\u7acb\u6700\u9ad8\u7b49\u7d1a" + n2);
            return "";
        }
        if (n2 != 0) {
            string = GameSetConstants.VIPNAME[a2 - 1];
        }
        return string;
    }

    public static /* synthetic */ boolean isPvP(int a2, int a3) {
        if (PVP_MAP == 0) {
            return PVP_SYSTEM && a2 == PVP_CHANNEL;
        }
        if (PVP_CHANNEL == 0) {
            return PVP_SYSTEM && a3 == PVP_MAP;
        }
        return PVP_SYSTEM && a3 == PVP_MAP && a2 == PVP_CHANNEL;
    }

    public static /* synthetic */ void loadSetting() {
        if (GameSetConstants.SERVER_NAME.isEmpty()) {
            GameSetConstants.loadsetting();
            GameSetConstants.reloadset();
        }
        HiredMerchantBan = GameSetConstants.HiredMerchantBan;
        LOG_TRADE = GameSetConstants.LOG_TRADE;
        LOG_MERCHANT = GameSetConstants.LOG_MERCHANT;
        LOG_CSBUY = GameSetConstants.LOG_CSBUY;
        LOG_DAMAGE = GameSetConstants.LOG_DAMAGE;
        LOG_CHAT = GameSetConstants.LOG_CHAT;
        LOG_MEGA = GameSetConstants.LOG_MEGA;
        AUTO_REGISTER = GameSetConstants.AUTO_REGISTER;
        LOG_CHALKBOARD = GameSetConstants.LOG_CHALKBOARD;
        LOG_SCROLL = GameSetConstants.LOG_SCROLL;
        LOG_DC = GameSetConstants.LOG_DC;
        SERVER_NAME = GameSetConstants.SERVER_NAME;
        IP = GameSetConstants.IP;
        ALLATORIxDEMO = GameSetConstants.EVENTS;
        checkCopyItem = GameSetConstants.checkCopyItem;
        PVP_SYSTEM = GameSetConstants.PVP_SYSTEM;
        PVP_CHANNEL = GameSetConstants.PVP_CHANNEL;
        PVP_MAP = GameSetConstants.PVP_MAP;
        GAMBLING_CHANNEL = GameSetConstants.GAMBLING_CHANNEL;
        GAMBLING_SYSTEM = GameSetConstants.GAMBLING_SYSTEM;
        REGULAR_BONUS = GameSetConstants.REGULAR_BONUS;
        SAVEBUFF = GameSetConstants.SAVEBUFF;
    }

    public static /* synthetic */ boolean isAutoRegister() {
        return AUTO_REGISTER;
    }

    public static /* synthetic */ {
        HiredMerchantBan = false;
        LOG_TRADE = true;
        LOG_MERCHANT = true;
        LOG_CSBUY = true;
        LOG_DAMAGE = false;
        LOG_CHAT = false;
        LOG_MEGA = false;
        AUTO_REGISTER = true;
        LOG_CHALKBOARD = false;
        LOG_SCROLL = false;
        LOG_DC = true;
        SERVER_NAME = "\u5408\u592a\u8c37";
        IP = "127.0.0.1";
        ALLATORIxDEMO = null;
        checkCopyItem = true;
        PVP_SYSTEM = false;
        PVP_CHANNEL = 20;
        PVP_MAP = 0;
        GAMBLING_CHANNEL = 19;
        GAMBLING_SYSTEM = false;
        REGULAR_BONUS = true;
        SAVEBUFF = false;
        ServerConfig.loadSetting();
    }

    public static /* synthetic */ int getGamblingChannel() {
        return GAMBLING_CHANNEL;
    }

    public static /* synthetic */ boolean isGamblingChannel(int a2) {
        return GAMBLING_SYSTEM && a2 == GAMBLING_CHANNEL;
    }

    public static /* synthetic */ boolean isRegularDropBonus() {
        int n2 = Calendar.getInstance().get(11);
        int n3 = Calendar.getInstance().get(7);
        if (REGULAR_BONUS && GameSetConstants.REGULAR_DROP_BONUS) {
            int n4 = n3 = 0;
            while (n4 < GameSetConstants.DROP_BONUS_HOURDAY.length) {
                if (ServerConfig.getDayOfWeek().equals(GameSetConstants.DROP_BONUS_HOURDAY[n3])) {
                    int n5;
                    int n6 = n5 = 0;
                    while (n6 < GameSetConstants.DROP_BONUS_HOUR.length) {
                        if (n2 == GameSetConstants.DROP_BONUS_HOUR[n5]) {
                            return true;
                        }
                        n6 = ++n5;
                    }
                }
                n4 = ++n3;
            }
            int n7 = n3 = 0;
            while (n7 < GameSetConstants.DROP_BONUS_ALLDAY.length) {
                if (ServerConfig.getDayOfWeek().equals(GameSetConstants.DROP_BONUS_ALLDAY[n3])) {
                    return true;
                }
                n7 = ++n3;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isRegularExpBonus() {
        int n2 = Calendar.getInstance().get(11);
        int n3 = Calendar.getInstance().get(7);
        if (REGULAR_BONUS && GameSetConstants.REGULAR_EXP_BONUS) {
            int n4 = n3 = 0;
            while (n4 < GameSetConstants.EXP_BONUS_HOURDAY.length) {
                if (ServerConfig.getDayOfWeek().equals(GameSetConstants.EXP_BONUS_HOURDAY[n3])) {
                    int n5;
                    int n6 = n5 = 0;
                    while (n6 < GameSetConstants.EXP_BONUS_HOUR.length) {
                        if (n2 == GameSetConstants.EXP_BONUS_HOUR[n5]) {
                            return true;
                        }
                        n6 = ++n5;
                    }
                }
                n4 = ++n3;
            }
            int n7 = n3 = 0;
            while (n7 < GameSetConstants.EXP_BONUS_ALLDAY.length) {
                if (ServerConfig.getDayOfWeek().equals(GameSetConstants.EXP_BONUS_ALLDAY[n3])) {
                    return true;
                }
                n7 = ++n3;
            }
        }
        return false;
    }

    public static /* synthetic */ int getPvPChannel() {
        return PVP_CHANNEL;
    }
}

