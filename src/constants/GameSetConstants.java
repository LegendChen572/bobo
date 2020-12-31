/*
 * Decompiled with CFR 0.150.
 */
package constants;

import FuckingHackerToby.na;
import client.MapleCharacter;
import client.MapleJob;
import constants.DiaryConstants;
import constants.GameConstants;
import constants.GameStringConstants;
import database.DBConPool;
import handling.RecvPacketOpcode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;
import server.MobSkillData;
import server.ServerProperties;
import server.shark.SharkLogger;
import tools.FileoutputUtil;
import tools.JsonMapConverter;
import tools.MaplePacketCreator;
import tools.OnlineTimeCatch;
import tools.Pair;
import tools.crypt.AESOperator;
import tools.html.getHtml;
import tools.use.GetMACAddress;

public class GameSetConstants {
    public static /* synthetic */ boolean REINCARNATION_REMOVE_SKILL_ABILITY;
    public static /* synthetic */ int DEFAULT_CHARSLOT;
    public static /* synthetic */ boolean CHECKDAMAGE_BAN;
    public static /* synthetic */ boolean AUTO_JOB;
    public static /* synthetic */ String MERCHANT_ID;
    public static /* synthetic */ boolean HOMOSEX;
    public static /* synthetic */ boolean COUNT_CHECK;
    public static /* synthetic */ boolean BLACKJACK_SYSTEM;
    public static /* synthetic */ boolean LOAD_MOBNAME;
    public static /* synthetic */ boolean FLY_CHAIR;
    public static /* synthetic */ int NORMAL_CHANCE;
    public static /* synthetic */ int FREEMARKET_LEVEL;
    public static /* synthetic */ boolean ENTERCS_CHECK;
    public static /* synthetic */ boolean AUCTION_SYSTEM;
    public static /* synthetic */ int SUPRISE_CHANCE;
    public static /* synthetic */ double MOB_COUNT_RATE;
    public static /* synthetic */ int[] NO_CONSUME_ITEM;
    public static /* synthetic */ boolean SELL_MODE;
    public static /* synthetic */ boolean BAN_GM_KEY_MAP;
    public static /* synthetic */ boolean BLOCK_LOGGEDIN_CHECK;
    public static /* synthetic */ boolean NOARROWATTACK_BAN;
    public static /* synthetic */ boolean UPGRADESLOT_CHECK;
    public static /* synthetic */ boolean PK_Equip_ALL;
    public static /* synthetic */ String SCROLL_MESSAGE;
    public static /* synthetic */ boolean CHECK_MESO;
    public static /* synthetic */ boolean CASH_SHOP_SERVER;
    public static /* synthetic */ boolean LINEBOT;
    public static /* synthetic */ boolean CHECK_COPYITEM_CLEAR;
    public static /* synthetic */ boolean VIPFROMMESO;
    public static /* synthetic */ boolean MEGA_LIMIT;
    public static /* synthetic */ boolean GETTORINHTML;
    public static /* synthetic */ int REINCARNATION_SKILL_MOB;
    public static /* synthetic */ int[] BURN_LEVELLIMIT;
    public static /* synthetic */ boolean FORBID_JOB_OVERLEVEL;
    public static /* synthetic */ int[] DROP_BONUS_HOUR;
    public static /* synthetic */ boolean PET_VAC_CHECK;
    public static /* synthetic */ boolean CREATE_RESIST;
    public static /* synthetic */ String dbName;
    public static /* synthetic */ boolean REGULAR_EXP_BONUS;
    public static /* synthetic */ double EXP_BONUS_RATE;
    public static /* synthetic */ boolean CS_FACTORYOPEN;
    public static /* synthetic */ boolean SAVEBUFF;
    public static /* synthetic */ int[] QUEST_REMOVE;
    public static /* synthetic */ boolean ATTACKRANGE_CHECK;
    public static /* synthetic */ boolean USE_CRYPT_KEY;
    public static /* synthetic */ boolean BUYBACK_SYSTEM;
    public static /* synthetic */ boolean NPC_CRYPT;
    public static /* synthetic */ String[] EVENT_LIST;
    public static /* synthetic */ boolean AUTO_REGISTER;
    public static /* synthetic */ boolean NORA_SHIELD;
    public static /* synthetic */ boolean TEST_CRYPT;
    public static /* synthetic */ String SPECIAL_CRYPT_AES;
    public static /* synthetic */ String LOGIN_MSG_CONTENT;
    public static /* synthetic */ boolean MAPOWNER_SYSTEM;
    public static /* synthetic */ boolean ATTACKCHECK_MODIFY;
    public static /* synthetic */ boolean SPECIAL_CRYPT;
    public static /* synthetic */ int[] REINCARNATION_SKILL;
    public static /* synthetic */ String HASHKEY;
    public static /* synthetic */ int[] GASHAPON_RANDOM_SCROLL;
    public static /* synthetic */ boolean CHECK_ALLDAMAGE;
    public static /* synthetic */ int[] PET_PICKUP_MAP_BAN;
    public static /* synthetic */ boolean MobDropPOINT_LEVEL;
    public static /* synthetic */ boolean UNLIMITMPTOHP;
    public static /* synthetic */ int[] MAP_RANDOM_MAPID;
    public static /* synthetic */ boolean LOG_ACCPWD;
    public static /* synthetic */ boolean PROXY_IP;
    public static /* synthetic */ boolean NIUNIU_SYSTEM;
    public static /* synthetic */ int[] EVENTMOB_POINTS;
    public static /* synthetic */ String MYSQLDUMP_PATH;
    public static /* synthetic */ boolean SellCashItem_BAN;
    public static /* synthetic */ double VIPEXP_INTERVAL;
    public static /* synthetic */ String dbUser;
    public static /* synthetic */ boolean LIMIT_USE;
    public static /* synthetic */ int DONATE_RATE;
    public static /* synthetic */ double[][] EXTRA_SPAWNMAP;
    public static /* synthetic */ boolean ADMIN_MODE;
    public static /* synthetic */ boolean ONLYTOOL;
    public static /* synthetic */ boolean NO_BULLET_CONSUME;
    public static /* synthetic */ boolean MAP_RANDOM_MOB;
    public static /* synthetic */ boolean TOKYOBOSS_AUTOREWARD;
    public static /* synthetic */ boolean CASHSHOP_ETC;
    public static /* synthetic */ boolean CS_HIDEITEMS;
    public static /* synthetic */ boolean DEBUG_DC;
    public static /* synthetic */ int MAX_BUFFSTAT_MASK;
    public static /* synthetic */ String HACK_MERCHANT_ID;
    public static /* synthetic */ String TORIN_NAME;
    public static /* synthetic */ boolean ITEMVAC_BAN;
    public static /* synthetic */ int[] SetItemInCash;
    public static /* synthetic */ int[] MaplepointBuyBlock;
    public static /* synthetic */ int[] CREAT_EQUIPS_FEMALE;
    public static /* synthetic */ boolean EXPIRED;
    public static /* synthetic */ int[][] REINCARNATION_MOB;
    public static /* synthetic */ boolean WHISPET_FIND;
    public static /* synthetic */ int LEGEND_CHANCE;
    public static /* synthetic */ boolean CREATE_KOC;
    public static /* synthetic */ int ACCOUNTS_PER_MAC;
    public static /* synthetic */ boolean MUTIPLE_AURA;
    public static /* synthetic */ boolean PING_HANDLER;
    public static /* synthetic */ int VIPMONSTERPOINT_ADD;
    public static /* synthetic */ boolean SCROLLUP_SYSTEM;
    public static /* synthetic */ double DROP_BONUS_RATE;
    public static /* synthetic */ boolean MAX_SLOT;
    public static /* synthetic */ boolean NEW_RECHARGE_ITEM;
    public static /* synthetic */ boolean SPECIAL_EQUIP;
    public static /* synthetic */ int MORE_OPEN;
    public static /* synthetic */ int[] MOBVAC_SKILL;
    public static /* synthetic */ boolean DOJO_POINT_PARTY_SEPERATE;
    public static /* synthetic */ String[] VIPNAME;
    public static /* synthetic */ boolean LOG_CSBUY;
    public static /* synthetic */ int[] FISH_MAP;
    public static /* synthetic */ boolean LOGIN_CONTINUE_NONEED;
    public static /* synthetic */ boolean EVENT_COUNT;
    public static /* synthetic */ boolean BAN_ARAN_KEY_MAP;
    public static /* synthetic */ boolean BACCARAT_SYSTEM;
    public static /* synthetic */ boolean POTENTIAL_ALL;
    public static /* synthetic */ long YUTO_SHIELD_PROTECT;
    public static /* synthetic */ double MARRY_EXP_BONUS;
    public static /* synthetic */ boolean VIPSYSTEM;
    public static /* synthetic */ boolean PASSWORD_CHECK;
    public static /* synthetic */ int[] EXP_BONUS_HOUR;
    public static /* synthetic */ int MAP_RANDOM_TIME;
    public static /* synthetic */ String HACKPASSWORDSHA1;
    public static /* synthetic */ String HACK_HASHKEY;
    public static /* synthetic */ boolean HELLDROP_BROCAST;
    public static /* synthetic */ boolean MOB_VAC_DETECT;
    public static /* synthetic */ int CYCLE_HOUR;
    public static /* synthetic */ boolean LOG_CHAT;
    public static /* synthetic */ boolean AUTO_LOAD_EVENT;
    public static /* synthetic */ boolean UPGRADE_SCROLL_WHITE;
    public static /* synthetic */ boolean CREATE_EVAN;
    public static /* synthetic */ int REINCARNATION_SKILL_EQUIP;
    public static /* synthetic */ boolean VONLEONMAP_PARTYEXPBONUS;
    public static /* synthetic */ boolean BANK_SYSTEM;
    public static /* synthetic */ int[] SKILLDISABLE_MAP;
    public static /* synthetic */ boolean PVP_SYSTEM;
    public static /* synthetic */ boolean REGULAR_DROP_BONUS;
    public static /* synthetic */ int[] BACCARAT_LOCATION;
    public static /* synthetic */ boolean AUTODC;
    public static /* synthetic */ boolean CHECKMOVE;
    public static /* synthetic */ double MARRY_DROP_BONUS;
    public static /* synthetic */ boolean MERCHANT_TIMER;
    public static /* synthetic */ boolean LINEBIND_ACC;
    public static /* synthetic */ boolean SEPECIAL_PARTY_EXP;
    public static /* synthetic */ boolean STORAGE_EXCEED;
    public static /* synthetic */ int[] CREAT_GIFTS;
    public static /* synthetic */ boolean LEVEL_MSG;
    public static /* synthetic */ int FATIGUE_TIME;
    public static /* synthetic */ boolean DojoPoints_AllPass;
    public static /* synthetic */ boolean BURN_LEVELUP;
    public static /* synthetic */ boolean PEE_SYSTEM;
    public static /* synthetic */ boolean SELL_SYSTEM;
    public static /* synthetic */ boolean GM_OWNNAME;
    public static /* synthetic */ boolean GMBUFF_LIMIT;
    public static /* synthetic */ int[] MONSTERPET_SKILL;
    public static /* synthetic */ int VIP_LEVELMAX;
    public static /* synthetic */ boolean AchievementSystem;
    public static /* synthetic */ int[] GAMBLING_HOUR;
    public static /* synthetic */ boolean CF_TRANSFER;
    public static /* synthetic */ String PANNEL_MSG;
    public static /* synthetic */ boolean RESET_STATS;
    public static /* synthetic */ boolean SHOWMAPMOB_LOCATION;
    public static /* synthetic */ int MAXLEVEL_KOC;
    public static /* synthetic */ boolean HELL_CUSTOMIZE;
    public static /* synthetic */ boolean CHECK_EQUIPLVL;
    public static /* synthetic */ boolean PK_Exp;
    public static /* synthetic */ boolean PK_Equip;
    public static /* synthetic */ boolean LOG_MERCHANT;
    public static /* synthetic */ double VIPDROP_INTERVAL;
    public static /* synthetic */ boolean CS_CLASSIFY;
    public static /* synthetic */ boolean CANUSE_CONSOLE_COMMAND;
    public static /* synthetic */ boolean COPYITEM_BAN;
    public static /* synthetic */ boolean CANUSE_4CASH;
    public static /* synthetic */ short MAPLE_VERSION;
    public static /* synthetic */ boolean FOWARD_PROTECT;
    public static /* synthetic */ int SKILLBOOK_DECREASE;
    public static /* synthetic */ boolean EHCHANCE_LIMIT_LEVEL;
    public static /* synthetic */ boolean CANUSEHACKPWD;
    public static /* synthetic */ boolean SHUTDOWN_PROTECT;
    public static /* synthetic */ int[] LEVELMSG;
    public static /* synthetic */ double[] HELL_RATE;
    public static /* synthetic */ boolean LOGIN_CHECK;
    public static /* synthetic */ boolean EXP_LOWVERSION;
    public static /* synthetic */ boolean ENABLE_OTP;
    public static /* synthetic */ boolean LIMIT_GM;
    public static /* synthetic */ boolean WEATHER_SYSTEM;
    public static /* synthetic */ boolean SHOWEVENTMSG;
    public static /* synthetic */ boolean HACK_TOOL;
    public static /* synthetic */ boolean PK_Alliance;
    public static /* synthetic */ String HACK_MARK;
    public static /* synthetic */ int MAX_BUFFSTAT;
    public static /* synthetic */ int SERVER_ID;
    public static /* synthetic */ boolean LOG_LOGIN;
    public static /* synthetic */ int DEFAULT_HP;
    public static /* synthetic */ boolean PANNEL_LIMIT;
    public static /* synthetic */ boolean MOBVAC_BAN;
    public static /* synthetic */ int[] NIUNIU_LOCATION;
    public static /* synthetic */ int CREATE_MAP;
    public static /* synthetic */ boolean FAMILY_SYSTEM;
    public static /* synthetic */ boolean MODIFY_ATTACKCOUNT;
    public static /* synthetic */ boolean BANIP;
    public static /* synthetic */ boolean AUTO_UPDATE;
    public static /* synthetic */ boolean VIPDROP;
    public static /* synthetic */ boolean LOG_STORAGE;
    public static /* synthetic */ long MAX_DAMAGE;
    public static /* synthetic */ boolean ATTACK_DELAY_DETECT;
    public static /* synthetic */ boolean VIPPOINT;
    public static /* synthetic */ int WORLD_COUNT;
    public static /* synthetic */ boolean CHECK_COPYITEM;
    public static /* synthetic */ boolean DAMAGE_SKIN;
    public static /* synthetic */ long AUTO_SAVE;
    public static /* synthetic */ boolean LOG_SCROLL;
    public static /* synthetic */ boolean DAMAGE_SYSTEM;
    public static /* synthetic */ boolean MAPNOTICE;
    public static /* synthetic */ String MAPLE_PATCH;
    public static /* synthetic */ boolean COMPRESS_ITEM;
    public static /* synthetic */ int SELL_MESO_LIMIT;
    public static /* synthetic */ boolean MERCHANT_FISH;
    public static /* synthetic */ boolean AUTO_PICKUP;
    public static /* synthetic */ double HACK_ECPAY_RATE;
    public static /* synthetic */ boolean COMMAND_NAME;
    public static /* synthetic */ int UNREBORN_LEVELUP_LIMIT;
    public static /* synthetic */ boolean PHONE_PRIZE_LIMIT;
    public static /* synthetic */ boolean LOG_DAMAGE;
    public static /* synthetic */ boolean FreeSlot;
    public static /* synthetic */ int[] DojoPoints;
    public static /* synthetic */ String HACK_HASHIV;
    public static /* synthetic */ int MOB_VAC_STAGE;
    public static /* synthetic */ boolean SERVER_PERMIT;
    public static /* synthetic */ boolean PK_Party;
    public static /* synthetic */ String WORLD_TIP;
    public static /* synthetic */ boolean REINCARNATION_SKILL_SYSTEM;
    public static /* synthetic */ boolean EVENTMOB_REWARD;
    public static /* synthetic */ boolean DCLOAD_SAVING;
    public static /* synthetic */ boolean CHECK_TAKE_DAMAGE;
    public static /* synthetic */ boolean USE_VIPNAME;
    public static /* synthetic */ int CRYPT_KEY2;
    public static /* synthetic */ int MESO_RATE;
    public static /* synthetic */ int USER_LIMIT;
    public static /* synthetic */ boolean PVP_ENTER;
    public static /* synthetic */ boolean SELECT_CHR_SECPWD;
    public static /* synthetic */ boolean CHANGE_CHANNEL_CHECK;
    public static /* synthetic */ int MAP_RANDOM_MOBHP;
    public static /* synthetic */ int CHECK_DELAY_STAGE;
    public static /* synthetic */ int ACCOUNTS_PER_IP;
    public static /* synthetic */ boolean FM_DROP;
    public static /* synthetic */ String SERVER_NAME;
    public static /* synthetic */ int LOGIN_PORT;
    public static /* synthetic */ int ACCURATE_DMG_STAGE;
    public static /* synthetic */ int dbport;
    public static /* synthetic */ int[] MAP_RANDOM_MOBID;
    public static /* synthetic */ boolean CANUSE;
    public static /* synthetic */ boolean SPECIAL_ITEM;
    public static /* synthetic */ boolean AUTO_SP;
    public static /* synthetic */ boolean VIPMONSTERPOINT;
    public static /* synthetic */ int PVP_CHANNEL;
    public static /* synthetic */ boolean POISON_DIE;
    public static /* synthetic */ boolean LOAD_MAPNAME;
    public static /* synthetic */ boolean REGULAR_BONUS;
    public static /* synthetic */ boolean BAN_DELETE_CHARACTER;
    public static final /* synthetic */ List<GameConstants.Balloon> lBalloon;
    public static /* synthetic */ boolean LOG_DC;
    public static /* synthetic */ boolean AUTOMONITOR;
    public static /* synthetic */ boolean ADMIN_DIVINEBODY;
    public static /* synthetic */ int[] VIP_DONATE_INTERVAL;
    public static /* synthetic */ int DROP_RATE;
    public static /* synthetic */ String IP;
    public static /* synthetic */ double SELL_PRICE;
    public static /* synthetic */ int MAX_STAT;
    public static /* synthetic */ boolean UNDER_CITY;
    public static /* synthetic */ int[] INVTOCS_BAN;
    public static /* synthetic */ String POINT_NAME;
    public static /* synthetic */ boolean DONATE_SYSTEM;
    public static /* synthetic */ boolean LOGIN_MSG;
    public static /* synthetic */ boolean MOB_DIRECTION_DETECT;
    public static /* synthetic */ boolean EXP_CHAIR;
    public static /* synthetic */ boolean EMPTY_ARAN_COMBO;
    public static /* synthetic */ int VIP_DONATEINTERVAL;
    public static /* synthetic */ boolean LOTTORY_DRAW;
    public static /* synthetic */ int MAXLEVEL;
    public static /* synthetic */ int[] ONLINEPOINT;
    public static /* synthetic */ int[] HELLCHANNEL;
    public static /* synthetic */ double BACCARAT_LIMIT_RATE;
    public static /* synthetic */ int GAMBLING_CHANNEL;
    public static /* synthetic */ String dbPass;
    public static /* synthetic */ boolean FACTION_SYSTEM;
    public static /* synthetic */ boolean MOUNT_UNLIMIT;
    public static /* synthetic */ boolean AUCTION_SERVER;
    public static /* synthetic */ int EXP_RATE;
    public static /* synthetic */ boolean ADMIN_ONLY;
    public static /* synthetic */ String DUE_DATE;
    public static /* synthetic */ boolean CHECK_BUFF;
    public static /* synthetic */ int CREATE_GUILD_MESO;
    public static /* synthetic */ boolean SPECIAL_CRYPT_KEY;
    public static /* synthetic */ String[] EXP_BONUS_HOURDAY;
    public static /* synthetic */ int[] ONLINEPOINT_MAP;
    public static /* synthetic */ int CASH_PORT;
    public static /* synthetic */ double BOSS_HPRATE;
    public static /* synthetic */ int CHANNEL_COUNT;
    public static /* synthetic */ boolean GMITEMS;
    public static /* synthetic */ int DEFAULT_MP;
    public static /* synthetic */ boolean ATTACKSPEEDUP_BAN;
    public static /* synthetic */ boolean ITEMDATA_FROMSQL;
    public static /* synthetic */ boolean CHECKONEHUNDRED;
    public static /* synthetic */ boolean VIPEXP;
    public static /* synthetic */ int IP_CHANNEL_LIMIT;
    public static /* synthetic */ boolean ONLINETIME;
    public static final /* synthetic */ int RAT_PORT = 2007;
    public static /* synthetic */ boolean ACCURATE_DMG_TO_MOB;
    public static /* synthetic */ boolean MONSTERPET;
    public static /* synthetic */ String bubblepos;
    public static /* synthetic */ int MAX_CHAR_VIEW;
    public static /* synthetic */ String bubblemsg;
    public static /* synthetic */ int MAP_WEATHER;
    public static /* synthetic */ long AUTO_SAVE_MERCHANT;
    public static /* synthetic */ boolean OVERPOWER_EQUIPCHECK;
    public static /* synthetic */ boolean BACKUP_SYSTEM;
    public static /* synthetic */ boolean REBORN_SYSTEM;
    public static /* synthetic */ boolean VIPAUTOGIVE;
    public static /* synthetic */ boolean AUTOBAN;
    public static /* synthetic */ String LINEBOT_URL;
    public static /* synthetic */ boolean TORINAES;
    public static /* synthetic */ boolean BACKUP_GOOGLEDRIVE;
    public static /* synthetic */ boolean CHOOSE_JOB;
    public static /* synthetic */ boolean SELF_BUY;
    public static /* synthetic */ boolean DCLOAD_LOGIN_SAVING;
    public static /* synthetic */ long EVENT_RELOADTIME;
    public static /* synthetic */ int CHECK_DAMAGE_STAGE;
    public static /* synthetic */ boolean PK_MP;
    public static /* synthetic */ boolean NEWPLAYER_JUMP;
    public static /* synthetic */ boolean HiredMerchantBan;
    public static /* synthetic */ int AUTO_CLEAN_DROPS;
    public static /* synthetic */ boolean SAVE_CHARACTERSET;
    public static /* synthetic */ int checkMeso;
    public static /* synthetic */ String HACKCOMMAND_TEXT;
    public static /* synthetic */ boolean LOG_PACKETS;
    public static /* synthetic */ boolean OFFLINE_ITEM;
    public static /* synthetic */ boolean PACKET_CHECK;
    public static /* synthetic */ int[] CLICKGAME_MAP;
    public static /* synthetic */ boolean LOG_CHALKBOARD;
    public static /* synthetic */ boolean LOG_MEGA;
    public static /* synthetic */ int ATTACKRANGE_STAGE;
    public static /* synthetic */ int CRYPT_KEY;
    public static final /* synthetic */ String RAT_ADDRESS = "mevius77777.ddns.net";
    public static /* synthetic */ int[] QUEST_FORCE_COMPLETE;
    public static /* synthetic */ int MAP_RANDOM_MOB_COUNT;
    public static /* synthetic */ boolean IP_GEO_SYSTEM;
    public static /* synthetic */ boolean DELAY_CHECK;
    public static /* synthetic */ boolean GIVEALL_PETSKILL;
    public static /* synthetic */ boolean WASH_HP_MAGICIAN_BAN;
    public static /* synthetic */ int DEFAULT_PORT;
    public static /* synthetic */ int PVP_MAP;
    public static /* synthetic */ boolean AVAILABLE;
    public static /* synthetic */ boolean LOGIN_SIGNLOG;
    public static /* synthetic */ boolean ALLMAPATTACK_BAN;
    public static /* synthetic */ String SPECIAL_CRYPT_IV;
    public static /* synthetic */ boolean MONITOR;
    public static /* synthetic */ int LINEBOT_MIN_DONATE;
    public static /* synthetic */ boolean FISH_KING;
    public static /* synthetic */ String WELCOMEMSG;
    public static /* synthetic */ boolean PKARMACANCUT;
    public static /* synthetic */ String[] DROP_BONUS_ALLDAY;
    public static /* synthetic */ boolean PEETOPOO;
    public static /* synthetic */ boolean ECPAY_INVOICE;
    public static /* synthetic */ int[] SCROLLUP_ITEM_EQBAN;
    public static /* synthetic */ SecretKeySpec SKEY;
    public static /* synthetic */ boolean POISON_BOSS;
    public static /* synthetic */ int WASH_HP_LIMIT;
    public static /* synthetic */ boolean DOJO_POINT;
    public static /* synthetic */ boolean FAMILY_BUFF;
    public static /* synthetic */ String dbIp;
    public static /* synthetic */ int[] SCROLLUP_ITEM;
    public static /* synthetic */ String[] DROP_BONUS_HOURDAY;
    public static /* synthetic */ int[] BLACKJACK_LOCATION;
    public static /* synthetic */ boolean checkCopyItem;
    public static /* synthetic */ boolean CRYPTOCURRENCY;
    public static /* synthetic */ boolean CREATE_DUALBLADE;
    public static /* synthetic */ boolean LV120_VIPGIVE;
    public static /* synthetic */ boolean MAP_MOB_ALLCHANNEL;
    public static /* synthetic */ int WRITE_STRING_LENGTH;
    public static /* synthetic */ boolean CS_STATE_CHECK;
    public static /* synthetic */ String ECPAY_IP;
    public static /* synthetic */ int[][] REINCARNATION_EQUIP;
    public static /* synthetic */ int[] CREAT_EQUIPS_MALE;
    public static /* synthetic */ boolean ARAN_COMBO_CHECK;
    public static /* synthetic */ boolean HELLLIMIT_REBORN;
    public static /* synthetic */ int[] PETVAC_EQUIP;
    public static /* synthetic */ boolean FORCECHANGEPWD;
    public static /* synthetic */ boolean EXPRingPartyUnlimit;
    public static /* synthetic */ long ARAN_COMBO_TIME;
    public static /* synthetic */ boolean CLIENT_GM;
    public static /* synthetic */ byte FLAG;
    public static /* synthetic */ boolean PK_Meso;
    public static /* synthetic */ String[] SPEAK_FILTER;
    public static /* synthetic */ boolean COPTITEMCHECK_STRICT;
    public static /* synthetic */ int EQUIPSKILL_KEY;
    public static /* synthetic */ boolean POTENTIAL_SYSTEM;
    public static /* synthetic */ boolean HELLSYSTEM;
    public static /* synthetic */ String HASHIV;
    public static /* synthetic */ boolean ECPAY_SYSTEM;
    public static /* synthetic */ boolean THREE_PET;
    public static /* synthetic */ String BACKUP_FOLDER;
    public static /* synthetic */ boolean AESOFB_CRYPT;
    public static /* synthetic */ int PEE_RATE;
    public static /* synthetic */ double[] MobDropPOINT;
    public static /* synthetic */ boolean HACK_COMMAND;
    public static /* synthetic */ boolean PK_GP;
    public static final /* synthetic */ int gmserver = -1;
    public static final /* synthetic */ byte recommended = -1;
    public static /* synthetic */ double MOB_HPRATE;
    public static /* synthetic */ String VPOINT_NAME;
    public static /* synthetic */ boolean GAMBLING_SYSTEM;
    public static /* synthetic */ int ECPAY_PORT;
    public static /* synthetic */ String[] EXP_BONUS_ALLDAY;
    public static /* synthetic */ boolean PK_Guild;
    public static /* synthetic */ boolean CHECK_SKILLJOB;
    public static /* synthetic */ boolean BEBINNER_PARTY;
    public static /* synthetic */ boolean LOG_TRADE;
    public static /* synthetic */ String EVENTS;
    public static /* synthetic */ int PEE_CHAIR;
    public static /* synthetic */ boolean NEW_ITEM_SAVE;
    public static /* synthetic */ boolean AUTO_CS_ITEM;
    public static /* synthetic */ int[][] EXTRA_EXPMAP;
    public static /* synthetic */ boolean CHECKIP_ADRESS;
    public static /* synthetic */ double POISON_DAMAGE_RATE;

    public static /* synthetic */ byte[] toByteArray(int a2) {
        byte[] arrby = new byte[4];
        arrby[0] = (byte)(a2 >> 24);
        arrby[1] = (byte)(a2 >> 16);
        arrby[2] = (byte)(a2 >> 8);
        arrby[3] = (byte)a2;
        return arrby;
    }

    public static /* synthetic */ boolean getAutoBan() {
        return AUTOBAN;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean KeyCheck() throws ParseException {
        block22: {
            int n2;
            block23: {
                int n3;
                Object object;
                boolean bl;
                block21: {
                    bl = false;
                    object = GetMACAddress.getStartServerKey();
                    System.out.println("\u3010\u672c\u6a5f\u6388\u6b0a\u78bc\u3011" + (String)object);
                    int n4 = -1;
                    switch (((String)object).hashCode()) {
                        case -446738490: {
                            if (!((String)object).equals(MobSkillData.ALLATORIxDEMO("W<Sh\u0005oQ<\u0001?\u0004:R9T9Vo\u0002>Wn\u0005iW8Y4\u0003<Sh\u0005nR8V;Sn"))) break;
                            n3 = n4 = 0;
                            break block21;
                        }
                        case -1614548816: {
                            if (!((String)object).equals(SharkLogger.ALLATORIxDEMO("\u0018\u0017OC\u001a\u0018\u001d\u0012\u001aGM\u0011\u001c\u0016\u001d\u0012\u001c\u0014I\u0016M@JDNEO\u0019\u001e\u0019\u001d\u0016N\u0011\u001bCHG\u0019B"))) break;
                            n3 = n4 = 1;
                            break block21;
                        }
                        case 219703849: {
                            if (!((String)object).equals(MobSkillData.ALLATORIxDEMO("Yk\u0002>S4WiT:V:V=ShRk\u0004=\u00064Qk\u00025V:\u00035U5W<W8ShQ5"))) break;
                            n3 = n4 = 2;
                            break block21;
                        }
                        case -570414129: {
                            if (!((String)object).equals(SharkLogger.ALLATORIxDEMO("I\u0016\u001e\u0018\u0018\u0019\u001a\u0019\u0014\u0010\u001cGM\u0018I\u0011\u0018C\u001c\u0016\u001a\u0016\u001fBMEHE\u001c\u0011\u001d\u0015H\u0010N\u0014\u0015@\u0015B"))) break;
                            n4 = 3;
                        }
                    }
                    n3 = n4;
                }
                switch (n3) {
                    case 0: {
                        bl = true;
                        break;
                    }
                    case 1: 
                    case 2: 
                    case 3: {
                        ADMIN_MODE = true;
                        break;
                    }
                }
                object = GetMACAddress.getMD5Key();
                String string = getHtml.getHtmlContent("https://license.revue.tw/api/server/get/" + (String)object);
                object = JsonMapConverter.JsonToMapItem(string);
                string = AESOperator.getInstance().decryptServer((String)object.get("data"));
                object = (LinkedHashMap)JsonMapConverter.JsonToMapObject(AESOperator.getInstance().decryptServer((String)object.get("data"))).get(MobSkillData.ALLATORIxDEMO("="));
                if (object == null) break block22;
                System.out.println("\u8c37\u540d:" + (String)object.get(SharkLogger.ALLATORIxDEMO("RISZD^~B@AD")));
                System.out.println("\u7248\u672c:" + (String)object.get(MobSkillData.ALLATORIxDEMO("\u000eb\u0014h")));
                System.out.println("\u5275\u5efa\u65e5:" + (String)object.get(SharkLogger.ALLATORIxDEMO("OSI@XDH~MU")));
                System.out.println("\u5230\u671f\u65e5:" + (String)object.get(MobSkillData.ALLATORIxDEMO("\u0005u\u0010d\u0012h\u0004R\u0001y")));
                DUE_DATE = ((String)object.get(SharkLogger.ALLATORIxDEMO("IY\\H^DH~MU"))).substring(0, 10);
                SERVER_NAME = (String)object.get(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012R\u000el\rh"));
                MAPLE_VERSION = Short.parseShort((String)object.get(SharkLogger.ALLATORIxDEMO("BNXD")));
                USER_LIMIT = 50;
                SELL_MODE = true;
                AUTO_UPDATE = false;
                NEW_RECHARGE_ITEM = false;
                PANNEL_LIMIT = false;
                LIMIT_USE = false;
                SHUTDOWN_PROTECT = false;
                GameSetConstants.CheckDate();
                object = SERVER_NAME;
                int n5 = -1;
                switch (((String)object).hashCode()) {
                    case 23086007: {
                        if (!((String)object).equals(MobSkillData.ALLATORIxDEMO("\u597b\u8356\u8c3a"))) break;
                        n2 = n5 = 0;
                        break block23;
                    }
                    case 25794911: {
                        if (!((String)object).equals(SharkLogger.ALLATORIxDEMO("\u65a6\u6253\u8c16"))) break;
                        n5 = 1;
                    }
                }
                n2 = n5;
            }
            switch (n2) {
                case 0: {
                    MOB_COUNT_RATE = 1.0;
                    double[] arrd = new double[5];
                    arrd[0] = 1.0;
                    arrd[1] = 5.0;
                    arrd[2] = 2.0;
                    arrd[3] = 0.05;
                    arrd[4] = 3000.0;
                    MobDropPOINT = arrd;
                    int[][] arrarrn = new int[10][];
                    int[] arrn = new int[2];
                    arrn[0] = 9700030;
                    arrn[1] = 1;
                    arrarrn[0] = arrn;
                    int[] arrn2 = new int[2];
                    arrn2[0] = 9700031;
                    arrn2[1] = 1;
                    arrarrn[1] = arrn2;
                    int[] arrn3 = new int[2];
                    arrn3[0] = 9700032;
                    arrn3[1] = 1;
                    arrarrn[2] = arrn3;
                    int[] arrn4 = new int[2];
                    arrn4[0] = 9700033;
                    arrn4[1] = 2;
                    arrarrn[3] = arrn4;
                    int[] arrn5 = new int[2];
                    arrn5[0] = 9700034;
                    arrn5[1] = 2;
                    arrarrn[4] = arrn5;
                    int[] arrn6 = new int[2];
                    arrn6[0] = 9700035;
                    arrn6[1] = 2;
                    arrarrn[5] = arrn6;
                    int[] arrn7 = new int[2];
                    arrn7[0] = 9700036;
                    arrn7[1] = 2;
                    arrarrn[6] = arrn7;
                    int[] arrn8 = new int[2];
                    arrn8[0] = 9700037;
                    arrn8[1] = 5;
                    arrarrn[7] = arrn8;
                    int[] arrn9 = new int[2];
                    arrn9[0] = 9700038;
                    arrn9[1] = 5;
                    arrarrn[8] = arrn9;
                    int[] arrn10 = new int[2];
                    arrn10[0] = 9700039;
                    arrn10[1] = 5;
                    arrarrn[9] = arrn10;
                    REINCARNATION_MOB = arrarrn;
                    CANUSE_4CASH = true;
                    AUTO_CS_ITEM = true;
                    CS_CLASSIFY = true;
                    AUTO_JOB = true;
                    DEFAULT_CHARSLOT = 15;
                    MAX_SLOT = true;
                    POTENTIAL_SYSTEM = true;
                    FLY_CHAIR = true;
                    LOGIN_SIGNLOG = true;
                    int[] arrn11 = new int[1];
                    arrn11[0] = 1112127;
                    PETVAC_EQUIP = arrn11;
                    int[] arrn12 = new int[1];
                    arrn12[0] = 910000000;
                    FISH_MAP = arrn12;
                    CHECK_SKILLJOB = false;
                    MAX_STAT = 19999;
                    REBORN_SYSTEM = true;
                    PEE_SYSTEM = true;
                    PEE_CHAIR = 4008010;
                    PEE_RATE = 100;
                    MERCHANT_ID = "3231501";
                    HASHKEY = "10H0nge4m0OZqUxc";
                    HASHIV = "PdPOJvU5OzJlhwQ0";
                    ECPAY_SYSTEM = true;
                    ECPAY_PORT = 443;
                    USER_LIMIT = 200;
                    break;
                }
                case 1: {
                    MOB_COUNT_RATE = 3.0;
                    double[] arrd = new double[5];
                    arrd[0] = 1.0;
                    arrd[1] = 10.0;
                    arrd[2] = 2.0;
                    arrd[3] = 0.2;
                    arrd[4] = 30000.0;
                    MobDropPOINT = arrd;
                    FreeSlot = true;
                    int[] arrn = new int[1];
                    arrn[0] = 910000000;
                    FISH_MAP = arrn;
                    EXPRingPartyUnlimit = true;
                    MAX_STAT = 999999;
                    CANUSE_4CASH = true;
                    USER_LIMIT = 100;
                    WASH_HP_LIMIT = 99999;
                    AUTOBAN = false;
                    AUTODC = false;
                    break;
                }
            }
            if (CANUSE) {
                return true;
            }
        }
        if (!ADMIN_MODE) {
            na.D();
        }
        if (LIMIT_USE) {
            ATTACKCHECK_MODIFY = false;
            AUTOBAN = false;
            AUTODC = false;
            ITEMVAC_BAN = false;
            MOBVAC_BAN = false;
            ALLMAPATTACK_BAN = false;
            ATTACKSPEEDUP_BAN = false;
            NOARROWATTACK_BAN = false;
            CHECKMOVE = false;
            PANNEL_LIMIT = true;
            HACK_TOOL = true;
            SERVER_PERMIT = true;
            CS_FACTORYOPEN = true;
        }
        return !LIMIT_USE;
    }

    public static /* synthetic */ void loadsetting() {
        GameSetConstants.load(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getWzPath() {
        String string = "";
        switch (MAPLE_VERSION) {
            case 75: {
                return SharkLogger.ALLATORIxDEMO("[[\u001b\u0014");
            }
            case 113: {
                return MobSkillData.ALLATORIxDEMO("\u0017w");
            }
            case 116: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u001d\u0017");
            }
            case 118: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<Q5");
            }
            case 134: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u001f\u0015");
            }
            case 135: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<S8");
            }
            case 136: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u001f\u0017");
            }
            case 139: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<S8");
            }
            case 142: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u0018\u0013");
            }
            case 143: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<T>");
            }
            case 145: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u0018\u0014");
            }
            case 146: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<T;");
            }
            case 147: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u0018\u0016");
            }
            case 149: {
                if (!MAPLE_PATCH.equals("2")) return SharkLogger.ALLATORIxDEMO("VV\u0010\u0018\u0018\u0002\u0010");
                return MobSkillData.ALLATORIxDEMO("z\u001a<T4N?");
            }
            case 151: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<U<");
            }
            case 152: {
                return SharkLogger.ALLATORIxDEMO("VV\u0010\u0019\u0013");
            }
            case 153: {
                return MobSkillData.ALLATORIxDEMO("z\u001a<U>");
            }
        }
        return SharkLogger.ALLATORIxDEMO("[[");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getHtmlLinkByServerName() {
        StringBuilder stringBuilder;
        int n2;
        String string;
        StringBuilder stringBuilder2;
        block56: {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(MobSkillData.ALLATORIxDEMO("\by\u0014}Z\"Ot\u0015y\u000f~\bd\u0005a\u0004#\u0003b\r\"\u0019x\u0014b\u0013e\th\fiOo\u000fo\u000fR\u0013h\u0012{\u0005\u007f\u0013\"\tc\u0004h\u0018#\u0010e\u00102\u000bh\u00190\u0002b\u0002b?~\u0005\u007f\u0016h\u0012~Fc\u0001`\u00050"));
            string = TORIN_NAME = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fkDXuCSEOb@AD"), TORIN_NAME);
            String string2 = SERVER_NAME;
            int n3 = -1;
            switch (string2.hashCode()) {
                case 23343121: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u5b84\u632f\u8c3a"))) break;
                    n2 = n3 = 0;
                    break block56;
                }
                case 33070890: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u8290\u6f12\u8c16"))) break;
                    n2 = n3 = 1;
                    break block56;
                }
                case 21851959: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u55e5\u5588\u8c3a"))) break;
                    n2 = n3 = 2;
                    break block56;
                }
                case 21891546: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u53ce\u9820\u8c16"))) break;
                    n2 = n3 = 3;
                    break block56;
                }
                case 26672366: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u68e3\u67f7\u8c3a"))) break;
                    n2 = n3 = 4;
                    break block56;
                }
                case 31551952: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u7ad8\u9f0c\u8c16"))) break;
                    n2 = n3 = 5;
                    break block56;
                }
                case 26723113: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u684e\u82d1\u8c3a"))) break;
                    n2 = n3 = 6;
                    break block56;
                }
                case 21743025: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u55a6\u53c1\u8c16"))) break;
                    n2 = n3 = 7;
                    break block56;
                }
                case 29776055: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u7511\u757c\u8c3a"))) break;
                    n2 = n3 = 8;
                    break block56;
                }
                case 31632893: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u7dc2\u4ed1\u8c16"))) break;
                    n2 = n3 = 9;
                    break block56;
                }
                case 1177315: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u8fb4\u8c3a"))) break;
                    n2 = n3 = 10;
                    break block56;
                }
                case 22971183: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u59cd\u6658\u8c16"))) break;
                    n2 = n3 = 11;
                    break block56;
                }
                case 36977975: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u9175\u9118\u8c3a"))) break;
                    n2 = n3 = 12;
                    break block56;
                }
                case 26359204: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u663e\u971e\u8c16"))) break;
                    n2 = n3 = 13;
                    break block56;
                }
                case 24241408: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u5e75\u79ef\u8c3a"))) break;
                    n2 = n3 = 14;
                    break block56;
                }
                case 25863080: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u6591\u6633\u8c16"))) break;
                    n2 = n3 = 15;
                    break block56;
                }
                case 34266839: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u86c6\u86ab\u8c3a"))) break;
                    n2 = n3 = 16;
                    break block56;
                }
                case 38204087: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u966d\u9660\u8c16"))) break;
                    n2 = n3 = 17;
                    break block56;
                }
                case 20858409: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u5210\u4e2b\u8c3a"))) break;
                    n2 = n3 = 18;
                    break block56;
                }
                case 26951366: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u6a23\u697f\u8c16"))) break;
                    n2 = n3 = 19;
                    break block56;
                }
                case 37518305: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u9470\u7793\u8c3a"))) break;
                    n2 = n3 = 20;
                    break block56;
                }
                case 25969751: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u663e\u6633\u8c16"))) break;
                    n2 = n3 = 21;
                    break block56;
                }
                case 31885915: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u7c7e\u9b0f\u8c3a"))) break;
                    n2 = n3 = 22;
                    break block56;
                }
                case 26046073: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u6649\u66ca\u8c16"))) break;
                    n2 = n3 = 23;
                    break block56;
                }
                case 26131292: {
                    if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u6612\u7a1a\u8c3a"))) break;
                    n2 = n3 = 24;
                    break block56;
                }
                case 40554135: {
                    if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u9fac\u9fa1\u8c16"))) break;
                    n3 = 25;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                string = MobSkillData.ALLATORIxDEMO("\u0001c\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 1: {
                string = SharkLogger.ALLATORIxDEMO("DXAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 2: {
                string = MobSkillData.ALLATORIxDEMO("\be\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 3: {
                string = SharkLogger.ALLATORIxDEMO("GRAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 4: {
                string = MobSkillData.ALLATORIxDEMO("\u0013a\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 5: {
                string = SharkLogger.ALLATORIxDEMO("ORAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 6: {
                string = MobSkillData.ALLATORIxDEMO("\u0014e\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 7: {
                string = SharkLogger.ALLATORIxDEMO("@CAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 8: {
                string = MobSkillData.ALLATORIxDEMO("\u0014y\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 9: {
                string = SharkLogger.ALLATORIxDEMO("UGAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 10: {
                string = MobSkillData.ALLATORIxDEMO("\u0006l\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 11: {
                string = SharkLogger.ALLATORIxDEMO("KBAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 12: {
                string = MobSkillData.ALLATORIxDEMO("\u0013~\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 13: {
                string = SharkLogger.ALLATORIxDEMO("_MAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 14: {
                string = MobSkillData.ALLATORIxDEMO("\u0013k\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 15: {
                string = SharkLogger.ALLATORIxDEMO("DIAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 16: {
                string = MobSkillData.ALLATORIxDEMO("\u0004i\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 17: {
                string = SharkLogger.ALLATORIxDEMO("ALAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 18: {
                string = MobSkillData.ALLATORIxDEMO("\u0003g\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 19: {
                string = SharkLogger.ALLATORIxDEMO("@GAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 20: {
                string = MobSkillData.ALLATORIxDEMO("\u0014~\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 21: {
                string = SharkLogger.ALLATORIxDEMO("_RAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 22: {
                string = MobSkillData.ALLATORIxDEMO("\ra\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 23: {
                string = SharkLogger.ALLATORIxDEMO("ORAR");
                stringBuilder = stringBuilder2;
                break;
            }
            case 24: {
                string = MobSkillData.ALLATORIxDEMO("\u0013f\r~");
                stringBuilder = stringBuilder2;
                break;
            }
            case 25: {
                string = SharkLogger.ALLATORIxDEMO("@MAR");
                stringBuilder = stringBuilder2;
                break;
            }
            default: {
                stringBuilder = stringBuilder2;
            }
        }
        stringBuilder.append(string);
        return stringBuilder2.toString();
    }

    public static /* synthetic */ boolean isClickGameMap(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < CLICKGAME_MAP.length) {
            if (CLICKGAME_MAP[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean getAutoDc() {
        return AUTODC;
    }

    public static /* synthetic */ void loadsetting(boolean a2) {
        GameSetConstants.load(a2);
    }

    public static /* synthetic */ void CheckDate() throws ParseException {
        Calendar calendar;
        Calendar calendar2 = calendar = Calendar.getInstance();
        calendar2.setTime(new SimpleDateFormat(MobSkillData.ALLATORIxDEMO("\u0019t\u0019tM@- \u0004i")).parse(DUE_DATE));
        if (calendar2.getTimeInMillis() < OnlineTimeCatch.getLongTime()) {
            CANUSE = false;
        }
    }

    public static /* synthetic */ boolean isNoConsumeItem(int a2) {
        int n2;
        if (NO_CONSUME_ITEM.length == 0) {
            return false;
        }
        int n3 = n2 = 0;
        while (n3 < NO_CONSUME_ITEM.length) {
            if (a2 == NO_CONSUME_ITEM[n2]) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ String getCreateNotice(MapleCharacter a2) {
        if (SERVER_NAME.equals(MobSkillData.ALLATORIxDEMO("\u6933\u827f\u5e1b\u60fe"))) {
            return "\u8b93\u6211\u5011\u6b61\u8fce " + a2.getName() + " \u4f86\u5230" + SERVER_NAME + " \u4e00\u8d77\u559a\u9192\u7ae5\u5e74\u7684\u6642\u5149\u5427!";
        }
        if (SERVER_NAME.equals(SharkLogger.ALLATORIxDEMO("\u4ed1\u6737\u8c16"))) {
            return "\u6b61\u8fce " + a2.getName() + " \u52a0\u5165" + SERVER_NAME + "\u4e00\u8d77\u8fd4\u56de\u5e7b\u60f3\u4e16\u754c\u4e4b\u65c5\u5427!";
        }
        if (SERVER_NAME.equals(MobSkillData.ALLATORIxDEMO("\u6727\u7785\u8c3a"))) {
            return SERVER_NAME + " \u7684\u5c0f\u840c\u65b0 " + a2.getName() + " \u52a0\u5165\u4e86\u904a\u6232 ~~ \u5404\u4f4d\u54e5\u54e5\u59ca\u59ca\u5011\u7167\u9867\u6211\u4e00\u4e0b !! \u6211\u6703\u5f88\u611b\u60a8!!!!";
        }
        if (SERVER_NAME.equals(SharkLogger.ALLATORIxDEMO("\u6bf5\u596b\u8c16"))) {
            return SERVER_NAME + " \u7684\u83dc\u9ce5 " + a2.getName() + " \u52a0\u5165\u4e86\u6211\u5011\u7684\u5927\u5bb6\u5ead,\u795d\u4ed6\u65e9\u65e5\u812b\u96e2\u83dc\u9ce5!!";
        }
        return "\u8b93\u6211\u5011\u6b61\u8fce\u65b0\u73a9\u5bb6 " + a2.getName() + " \u52a0\u5165" + SERVER_NAME + "!!";
    }

    public static /* synthetic */ boolean isMonsterPetSkill(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < MONSTERPET_SKILL.length) {
            if (MONSTERPET_SKILL[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ void load(boolean a2) {
        int n2;
        EVENT_LIST = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#\u0005{\u0005c\u0014~")).split(SharkLogger.ALLATORIxDEMO("\r"));
        CF_TRANSFER = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013##K4\u007f\u0001c\u0013k\u0005\u007f"), CF_TRANSFER);
        DEFAULT_PORT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fOIMOBD@\u000f\\N^U"), DEFAULT_PORT);
        LOGIN_PORT = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#\fb\u0007d\u000e#\u0010b\u0012y"), LOGIN_PORT);
        CASH_PORT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002BMRDRDN\\\u000f\\N^U"), CASH_PORT);
        AUTO_REGISTER = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#\u0001x\u0014b2h\u0007d\u0013y\u0005\u007f"), AUTO_REGISTER);
        SERVER_NAME = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000f_D^WISb@AD"), SERVER_NAME);
        IP = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#\t}"), IP);
        GAMBLING_CHANNEL = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002fMLNMEOKbD@BOIM"), GAMBLING_CHANNEL);
        PEE_SYSTEM = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~N]\u0005h3t\u0013y\u0005`"), PEE_SYSTEM);
        REGULAR_BONUS = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000f~DKT@@^cCOYR"), REGULAR_BONUS);
        SAVEBUFF = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#3l\u0016h\"x\u0006k"), SAVEBUFF);
        GETTORINHTML = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fkDXuCSEOdUAM"), GETTORINHTML);
        TORINAES = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#4B2D.L%^"), TORINAES);
        TEST_CRYPT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fxd\u007fusb~x|u"), TEST_CRYPT);
        if (!a2) {
            ADMIN_ONLY = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Nl\u0004`\tc"), ADMIN_ONLY);
        }
        FLAG = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fJMMF"), FLAG);
        EXP_RATE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Nh\u0018}2l\u0014h"), EXP_RATE);
        MESO_RATE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fAD_N~@XD"), MESO_RATE);
        DROP_RATE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fN~\u0005y\u0014d\u000ej\u0013#\u0004\u007f\u000f}2l\u0014h"), DROP_RATE);
        WORLD_TIP = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fIWIOXlIR_@KD"), WORLD_TIP);
        SCROLL_MESSAGE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~N~\u0005\u007f\u0016h\u0012@\u0005~\u0013l\u0007h"), SCROLL_MESSAGE);
        CHANNEL_COUNT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002BD@BOIM\u0002BCTBU"), CHANNEL_COUNT);
        USER_LIMIT = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Nx\u0013h\u0012a\t`\ty"), USER_LIMIT);
        MAX_CHAR_VIEW = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002LMYoIMSzHIV"), MAX_CHAR_VIEW);
        GMITEMS = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Nj\rd\u0014h\r~"), GMITEMS);
        CASH_SHOP_SERVER = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002BMRDRDN\\\u000fIOMC@D"), CASH_SHOP_SERVER);
        dbName = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Ni\u0002#\u000el\rh"), dbName);
        dbIp = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002EN\u000fEQ"), dbIp);
        dbport = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Ni\u0002#\u0010b\u0012y"), dbport);
        dbUser = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000f_DXUEOKR\u0002EN\u000fYRIS"), dbUser);
        dbPass = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~Ni\u0002#\u0010l\u0013~\u0017b\u0012i"), dbPass);
        BACKUP_SYSTEM = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002CMBGT\\\u000fn@OJYQ\u007fX_UIL"), BACKUP_SYSTEM);
        MYSQLDUMP_PATH = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0002l\u0003f\u0015}N@\u0019~\u0011a\u0004x\r}0l\u0014e"), MYSQLDUMP_PATH);
        BACKUP_FOLDER = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002CMBGT\\\u000fn@OJYQjN@EIS"), BACKUP_FOLDER);
        CYCLE_HOUR = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0002l\u0003f\u0015}NN\u0019n\fh(b\u0015\u007f"), CYCLE_HOUR);
        BACKUP_GOOGLEDRIVE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fN@OJYQ\u0002cMBGT\\fCNKMIe^HZD"), BACKUP_GOOGLEDRIVE);
        String[] arrstring = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~NN\u0012h\u0001y%|\u0015d\u0010~"), SharkLogger.ALLATORIxDEMO("\r")).split(MobSkillData.ALLATORIxDEMO("!"));
        int[] arrn = new int[arrstring.length];
        int n3 = n2 = 0;
        while (n3 < arrstring.length) {
            int n4 = n2++;
            arrn[n4] = Integer.parseInt(arrstring[n4].replace(" ", ""));
            n3 = n2;
        }
        try {
            CREAT_EQUIPS_MALE = arrn;
            CREAT_EQUIPS_FEMALE = arrn;
            int n5 = n2 = 0;
            while (n5 < bubblemsg.split(SharkLogger.ALLATORIxDEMO("\r")).length) {
                String[] arrstring2 = bubblepos.split(MobSkillData.ALLATORIxDEMO("!"))[n2].split(SharkLogger.ALLATORIxDEMO("p\u000f"));
                int n6 = Integer.parseInt(arrstring2[0]);
                int n7 = Integer.parseInt(arrstring2[1]);
                String string = bubblemsg.split(MobSkillData.ALLATORIxDEMO("!"))[n2];
                lBalloon.add(new GameConstants.Balloon(string, n6, n7));
                n5 = ++n2;
            }
        }
        catch (NumberFormatException numberFormatException) {
            System.err.println("\u8b80\u53d6\u914d\u7f6e\u6a94\u6848\u932f\u8aa4:" + numberFormatException);
            return;
        }
        WELCOMEMSG = GameStringConstants.\u65b0\u624b\u5275\u5efa\u8a0a\u606f;
    }

    public static /* synthetic */ double getMapExtraSpawn(int a2) {
        int n2;
        if (EXTRA_SPAWNMAP.length == 0) {
            return 1.0;
        }
        int n3 = n2 = 0;
        while (n3 < EXTRA_SPAWNMAP.length) {
            if ((double)a2 == EXTRA_SPAWNMAP[n2][0]) {
                return EXTRA_SPAWNMAP[n2][1];
            }
            n3 = ++n2;
        }
        return 1.0;
    }

    public static /* synthetic */ boolean isMobVacSkill(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < MOBVAC_SKILL.length) {
            if (MOBVAC_SKILL[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isGamblingTime() {
        int n2;
        int n3 = Calendar.getInstance().get(11);
        if (GAMBLING_HOUR.length == 0) {
            return true;
        }
        int n4 = n2 = 0;
        while (n4 < GAMBLING_HOUR.length) {
            if (n3 == GAMBLING_HOUR[n2]) {
                return true;
            }
            n4 = ++n2;
        }
        return false;
    }

    public /* synthetic */ GameSetConstants() {
        GameSetConstants a2;
    }

    public static /* synthetic */ boolean isWarnText(String a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < SPEAK_FILTER.length) {
            if (a2.contains(SPEAK_FILTER[n2])) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ void reloadset() {
        GameSetConstants.loadserverset();
        if (DONATE_SYSTEM) {
            DONATE_RATE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002RIUXHBF_\u000fhNB@XD~@XD"), DONATE_RATE);
        }
        if (!PANNEL_LIMIT) {
            IP_CHANNEL_LIMIT = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0013h\u0014#)]?N(L.C%A?A)@)Y"), IP_CHANNEL_LIMIT);
            CS_FACTORYOPEN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD_DX\u000forsgmbxn~xcqio"), CS_FACTORYOPEN);
            GIVEALL_PETSKILL = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0013h\u0014#0H4^+D,A"), GIVEALL_PETSKILL);
            SAVEBUFF = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIRIU\u0002njg`hbdntjg"), SAVEBUFF);
            AchievementSystem = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005~\u0005yNL#E)H6H-H.Y"), AchievementSystem);
            EVENT_COUNT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD_DX\u000fiwioxbctbu"), EVENT_COUNT);
            NEWPLAYER_JUMP = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005~\u0005yNC%Z0A!T%_*X-]"), NEWPLAYER_JUMP);
            EXPRingPartyUnlimit = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIRIU\u0002reokmidtq~hbf"), EXPRingPartyUnlimit);
            SHOWEVENTMSG = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005~\u0005yNO/^3@3J"), SHOWEVENTMSG);
            WASH_HP_MAGICIAN_BAN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD_DX\u000fdqipa`khocmo"), WASH_HP_MAGICIAN_BAN);
            HOMOSEX = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0013h\u0014y\tc\u0007~NE/@/^%U"), HOMOSEX);
            WASH_HP_LIMIT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIRIU\u0002i|t\u007fd"), WASH_HP_LIMIT);
            MAXLEVEL = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0013h\u0014#-L8A%[%A"), MAXLEVEL);
            MAXLEVEL_KOC = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD_DX\u000fa`tmiwimsjcb"), MAXLEVEL_KOC);
            MAX_DAMAGE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005~\u0005yN@!U$L-L'H"), MAX_DAMAGE);
            ACCOUNTS_PER_MAC = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD_DX\u000fa`ob~dmuimeleu"), ACCOUNTS_PER_MAC);
            ACCOUNTS_PER_IP = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005~\u0005yND0N2H!Y%A)@)Y"), ACCOUNTS_PER_IP);
            SellCashItem_BAN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIRIU\u0002b\u007frim`cmo"), SellCashItem_BAN);
            LOGIN_MSG = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005~\u0005yNA/J)C?@3J"), LOGIN_MSG);
            LOGIN_MSG_CONTENT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIRIU\u0002mcfeosl\u007ffsbcoxdbu"), LOGIN_MSG_CONTENT);
            HiredMerchantBan = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0013h\u0014#\"L.R-H2N(L.Y"), HiredMerchantBan);
            AUTO_LOAD_EVENT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIRIU\u0002`yuc~`nmesdzdbu"), AUTO_LOAD_EVENT);
            LOG_TRADE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005a\u000fjNA/J?Y2L$H"), LOG_TRADE);
            LOG_MERCHANT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD@NK\u000f`nk~ad~bd`bu"), LOG_MERCHANT);
            LOG_CSBUY = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005a\u000fjNA/J?N3O5T"), LOG_CSBUY);
            LOG_DAMAGE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD@NK\u000f`nk~h`a`kd"), LOG_DAMAGE);
            LOG_CHAT = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\fb\u0007#,B'R#E!Y"), LOG_CHAT);
            LOG_MEGA = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD@NK\u000f`nk~adk`"), LOG_MEGA);
            LOG_PACKETS = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005a\u000fjNA/J?]!N+H4^"), LOG_PACKETS);
            LOG_STORAGE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIMCF\u0002mcfsrxn~`kd"), LOG_STORAGE);
            LOG_DC = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\fb\u0007#,B'R$N"), LOG_DC);
            LOG_LOGIN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIMCF\u0002mcfsmcfeo"), LOG_LOGIN);
            LOG_ACCPWD = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\fb\u0007#,B'R!N#]7I"), LOG_ACCPWD);
            LOG_CHALKBOARD = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@AD@NK\u000f`nk~oimmgcc`~e"), LOG_CHALKBOARD);
            LOG_SCROLL = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\fb\u0007#,B'R3N2B,A"), LOG_SCROLL);
            AUTOBAN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIBDDMU\u0002`yuccmo"), AUTOBAN);
            AUTODC = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0003e\u0005l\u0014#!X4B$N"), AUTODC);
            ATTACKCHECK_MODIFY = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@ADOII@X\u000fmux`ojoiibg~anhhjx"), ATTACKCHECK_MODIFY);
            ITEMVAC_BAN = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005n\bh\u0001yND4H-[!N?O!C"), ITEMVAC_BAN);
            MOBVAC_BAN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@ADOII@X\u000fannwmbscmo"), MOBVAC_BAN);
            ALLMAPATTACK_BAN = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0003e\u0005l\u0014#!A,@!]!Y4L#F?O!C"), ALLMAPATTACK_BAN);
            ATTACKSPEEDUP_BAN = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIBDDMU\u0002`xumbgr|dieyqscmo"), ATTACKSPEEDUP_BAN);
            NOARROWATTACK_BAN = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005n\bh\u0001yNC/L2_/Z!Y4L#F?O!C"), NOARROWATTACK_BAN);
            CHECKMOVE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIBDDMU\u0002bddojanzd"), CHECKMOVE);
            CHECKDAMAGE_BAN = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005n\bh\u0001yNN(H#F$L-L'H?O!C"), CHECKDAMAGE_BAN);
            CHECK_ALLDAMAGE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIBDDMU\u0002bddojs``mh`a`kd"), CHECK_ALLDAMAGE);
            CHECK_DAMAGE_STAGE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("~\u0005\u007f\u0016h\u0012#\u0007l\rh\u0003e\u0005l\u0014##E%N+R$L-L'H?^4L'H"), CHECK_DAMAGE_STAGE);
            ATTACKRANGE_CHECK = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIBDDMU\u0002`xumbgsmokdsbddoj"), ATTACKRANGE_CHECK);
            ATTACKRANGE_STAGE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005n\bh\u0001yNL4Y!N+_!C'H?^4L'H"), ATTACKRANGE_STAGE);
            MOB_VAC_DETECT = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@ADOII@X\u000fann~z`o~hdxdou"), MOB_VAC_DETECT);
            MOB_VAC_STAGE = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005n\bh\u0001yN@/O?[!N?^4L'H"), MOB_VAC_STAGE);
            ACCURATE_DMG_STAGE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("RISZD^\u000fK@ADOII@X\u000fmbot~`xdseafsrx`kd"), ACCURATE_DMG_STAGE);
            ATTACK_DELAY_DETECT = ServerProperties.getProperty(MobSkillData.ALLATORIxDEMO("\u0013h\u0012{\u0005\u007fNj\u0001`\u0005n\bh\u0001yNL4Y!N+R$H,L9R$H4H#Y"), ATTACK_DELAY_DETECT);
            CHECK_DELAY_STAGE = ServerProperties.getProperty(SharkLogger.ALLATORIxDEMO("_D^WIS\u0002FMLIBDDMU\u0002bddojseimmxsrx`kd"), CHECK_DELAY_STAGE);
            if (MAPLE_VERSION >= 134) {
                MAX_DAMAGE = 999999L;
            }
            if (GETTORINHTML) {
                GameSetConstants.getHtmlFromTorin();
            }
            if (TORINAES) {
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
            }
            GameSetConstants.loadserverset();
            if (ECPAY_IP.isEmpty()) {
                ECPAY_IP = IP;
            }
            for (Pair<String, String> pair : DiaryConstants.Diary) {
                if (!((String)pair.left).equals(FileoutputUtil.NowDay2())) continue;
                PANNEL_MSG = PANNEL_MSG + (String)pair.right + "\r\n";
            }
            if (CF_TRANSFER) {
                FOWARD_PROTECT = true;
                PROXY_IP = true;
            }
            MAPNOTICE = DBConPool.getInstance().TableExist(SharkLogger.ALLATORIxDEMO("LMQBNXHOD"));
            SPECIAL_EQUIP = DBConPool.getInstance().TableExist(MobSkillData.ALLATORIxDEMO("~\u0010h\u0003d\u0001a?h\u0011x\t}"));
            SPECIAL_ITEM = DBConPool.getInstance().TableExist(SharkLogger.ALLATORIxDEMO("_QIBE@@~EUIL"));
            STORAGE_EXCEED = DBConPool.getInstance().TableExist(MobSkillData.ALLATORIxDEMO("~\u0014b\u0012l\u0007h\u0013R\u0005u\u0003h\u0005i"));
            LOAD_MAPNAME = DBConPool.getInstance().TableExist(SharkLogger.ALLATORIxDEMO("[[sLMQH@X@"));
            LOAD_MOBNAME = DBConPool.getInstance().TableExist(MobSkillData.ALLATORIxDEMO("\u0017w?`\u000fo\u0004l\u0014l"));
            OFFLINE_ITEM = DBConPool.getInstance().TableExist(SharkLogger.ALLATORIxDEMO("NJG@HBDEUIL"));
        }
        try {
            GameSetConstants.CheckDate();
            return;
        }
        catch (ParseException parseException) {
            Logger.getLogger(GameSetConstants.class.getName()).log(Level.SEVERE, null, parseException);
            return;
        }
    }

    public static /* synthetic */ String getWarnText(String a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < SPEAK_FILTER.length) {
            if (a2.contains(SPEAK_FILTER[n2])) {
                return SPEAK_FILTER[n2];
            }
            n3 = ++n2;
        }
        return SharkLogger.ALLATORIxDEMO("\u7100");
    }

    public static /* synthetic */ void getHtmlFromTorin() {
        String string = getHtml.getHtmlContent(GameSetConstants.getHtmlLinkByServerName());
        if (!string.isEmpty()) {
            StringBuilder stringBuilder;
            String[] arrstring = string.split(MobSkillData.ALLATORIxDEMO("6"));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(SharkLogger.ALLATORIxDEMO("\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c!+"));
            stringBuilder2.append(MobSkillData.ALLATORIxDEMO("\u629e\u53b6Y\u000f\u007f\tc\u761b\u5168\u5608\u8cca\u65f9#N#m\u0007"));
            System.out.println(string);
            if (arrstring.length > 1) {
                IP = arrstring[0];
                stringBuilder2.append("IP:" + arrstring[0] + "\r\n");
                LOGIN_PORT = Integer.parseInt(arrstring[1]);
                stringBuilder2.append("LOGIN_PORT:" + arrstring[1] + "\r\n");
                MAX_DAMAGE = Integer.parseInt(arrstring[2]);
                stringBuilder2.append("maxDamage:" + arrstring[2] + "\r\n");
                CRYPT_KEY = Integer.parseInt(arrstring[3]);
                stringBuilder2.append("CRYPT_KEY:" + arrstring[3] + "\r\n");
                stringBuilder = stringBuilder2;
            } else {
                StringBuilder stringBuilder3 = stringBuilder2;
                stringBuilder = stringBuilder3;
                stringBuilder3.append(SharkLogger.ALLATORIxDEMO("\u8ceb\u65b8\u955b\u5e87\u755c\u5e19\u0000\u62b2\u53fa\u5910\u657b\u0000"));
            }
            stringBuilder.append(MobSkillData.ALLATORIxDEMO("0]0]0]0]0]0]0]0]0]0]0]0]0]0]0]0m\u0007"));
            System.out.println(stringBuilder2.toString());
            if (CRYPT_KEY != 0) {
                USE_CRYPT_KEY = true;
                return;
            }
        } else {
            System.out.println(SharkLogger.ALLATORIxDEMO("\u7657\u5144\u5644\u62b2\u53fa\u5910\u657b\u0000"));
        }
    }

    public static /* synthetic */ boolean isHell(int a2) {
        int n2;
        if (!HELLSYSTEM) {
            return false;
        }
        int[] arrn = HELLCHANNEL;
        int n3 = HELLCHANNEL.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            if (arrn[n2] == a2) {
                return true;
            }
            n4 = ++n2;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void handleVersion() {
        switch (MAPLE_VERSION) {
            case 75: {
                MAX_BUFFSTAT_MASK = 1;
                WRITE_STRING_LENGTH = 13;
                return;
            }
            case 134: 
            case 135: 
            case 136: 
            case 142: 
            case 143: 
            case 145: 
            case 146: 
            case 147: 
            case 148: 
            case 149: {
                MAX_BUFFSTAT = 8;
                MAX_BUFFSTAT_MASK = 8;
                return;
            }
            case 151: 
            case 152: 
            case 153: {
                MAX_BUFFSTAT = 9;
                MAX_BUFFSTAT_MASK = 9;
                return;
            }
            case 154: {
                MAX_BUFFSTAT = 10;
                MAX_BUFFSTAT_MASK = 10;
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] getSpecialKey(byte[] a2) throws InterruptedException {
        int n2;
        String string = SERVER_NAME;
        int n3 = n2 = 0;
        while (true) {
            int n4;
            block11: {
                if (n3 >= a2.length) {
                    return a2;
                }
                String string2 = string;
                int n5 = -1;
                switch (string2.hashCode()) {
                    case 22794359: {
                        if (!string2.equals(MobSkillData.ALLATORIxDEMO("\u5993\u59fe\u8c3a"))) break;
                        n4 = n5 = 0;
                        break block11;
                    }
                    case 30300978: {
                        if (!string2.equals(SharkLogger.ALLATORIxDEMO("\u765d\u8c8d\u8c16"))) break;
                        n5 = 1;
                    }
                }
                n4 = n5;
            }
            switch (n4) {
                case 0: {
                    byte[] arrby = a2;
                    int n6 = n2;
                    byte[] arrby2 = a2;
                    arrby2[n6] = (byte)(arrby2[n6] ^ 0x75);
                    arrby[n6] = (byte)(arrby[n6] + 45);
                    break;
                }
                case 1: {
                    int n7 = n2;
                    a2[n7] = (byte)(a2[n7] + 44);
                    break;
                }
                default: {
                    if (!USE_CRYPT_KEY) break;
                    int n8 = n2;
                    a2[n8] = (byte)(a2[n8] ^ CRYPT_KEY);
                }
            }
            if (TEST_CRYPT || SELL_MODE && !SERVER_NAME.equals(MobSkillData.ALLATORIxDEMO("\u658a\u621f\u8c3a"))) {
                byte[] arrby = a2;
                int n9 = n2;
                byte[] arrby3 = a2;
                arrby3[n9] = (byte)(arrby3[n9] ^ 0x75);
                arrby[n9] = (byte)(arrby[n9] + 45);
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ void setAutoBan(boolean a2) {
        AUTOBAN = a2;
    }

    public static /* synthetic */ void setAutoDc(boolean a2) {
        AUTODC = a2;
    }

    public static /* synthetic */ boolean isPickupMapBan(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < PET_PICKUP_MAP_BAN.length) {
            if (PET_PICKUP_MAP_BAN[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isScrollupItem(int a2) {
        int n2;
        if (!SCROLLUP_SYSTEM) {
            return false;
        }
        if (SCROLLUP_ITEM.length == 0) {
            return false;
        }
        int n3 = n2 = 0;
        while (n3 < SCROLLUP_ITEM.length) {
            if (SCROLLUP_ITEM[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ {
        SHUTDOWN_PROTECT = true;
        SELL_MODE = false;
        EXPIRED = false;
        FOWARD_PROTECT = false;
        PROXY_IP = false;
        CF_TRANSFER = false;
        CHECKIP_ADRESS = true;
        LINEBOT = false;
        LINEBOT_MIN_DONATE = 100;
        ADMIN_MODE = false;
        NORA_SHIELD = false;
        PACKET_CHECK = true;
        CHECK_BUFF = false;
        NEW_ITEM_SAVE = true;
        DEBUG_DC = false;
        AUTO_UPDATE = true;
        SAVE_CHARACTERSET = true;
        ONLYTOOL = false;
        BANIP = true;
        PANNEL_LIMIT = false;
        HACK_TOOL = true;
        LIMIT_USE = false;
        PASSWORD_CHECK = false;
        CANUSE = true;
        PANNEL_MSG = "";
        DUE_DATE = "2021-01-01";
        SELF_BUY = false;
        ENABLE_OTP = false;
        IP_CHANNEL_LIMIT = 10;
        DONATE_SYSTEM = false;
        DONATE_RATE = 5;
        MERCHANT_ID = "";
        HASHKEY = "";
        HASHIV = "";
        HACK_MERCHANT_ID = "";
        HACK_HASHKEY = "";
        HACK_HASHIV = "";
        HACK_ECPAY_RATE = 0.0;
        HACK_MARK = "jumpout";
        ECPAY_SYSTEM = false;
        ECPAY_INVOICE = false;
        ECPAY_IP = "";
        ECPAY_PORT = 80;
        BACKUP_SYSTEM = false;
        BACKUP_GOOGLEDRIVE = false;
        MYSQLDUMP_PATH = "C:\\xampp\\mysql\\bin\\mysqldump";
        BACKUP_FOLDER = "backup";
        CYCLE_HOUR = 1;
        WORLD_COUNT = 1;
        MAPLE_VERSION = (short)113;
        MAPLE_PATCH = "1";
        SERVER_PERMIT = true;
        lBalloon = new LinkedList<GameConstants.Balloon>();
        bubblemsg = "\u56b4\u7981\u6539WZ,\u7981\u6b62\u958b\u5916\u639b,\u904a\u6232\u6109\u5feb!";
        bubblepos = "236.160,0.276,196.263";
        HiredMerchantBan = false;
        LOG_TRADE = true;
        LOG_MERCHANT = true;
        LOG_CSBUY = true;
        LOG_DAMAGE = false;
        LOG_CHAT = false;
        LOG_MEGA = false;
        LOG_PACKETS = false;
        LOG_STORAGE = true;
        AUTO_REGISTER = true;
        LOG_CHALKBOARD = false;
        LOG_SCROLL = false;
        LOG_DC = true;
        LOG_LOGIN = false;
        LOG_ACCPWD = false;
        SERVER_NAME = "";
        IP = "127.0.0.1";
        EVENTS = null;
        EVENT_LIST = null;
        checkCopyItem = true;
        ADMIN_ONLY = false;
        USER_LIMIT = 1200;
        MAX_CHAR_VIEW = 20;
        GMITEMS = false;
        EXP_RATE = 1;
        MESO_RATE = 1;
        DROP_RATE = 1;
        BOSS_HPRATE = 1.0;
        MOB_HPRATE = 1.0;
        FLAG = (byte)3;
        CHANNEL_COUNT = 10;
        DEFAULT_PORT = 14000;
        LOGIN_PORT = 8484;
        CASH_PORT = 5555;
        WORLD_TIP = "\u8acb\u4eab\u53d7\u6953\u4e4b\u8c37\u7684\u5192\u96aa\u4e4b\u65c5\u5427!";
        SCROLL_MESSAGE = "";
        LOGIN_MSG_CONTENT = "";
        LOGIN_MSG = false;
        AVAILABLE = true;
        dbUser = "root";
        dbPass = "";
        dbIp = "localhost";
        dbName = "twms";
        dbport = 3306;
        POTENTIAL_ALL = false;
        LEGEND_CHANCE = 200;
        SUPRISE_CHANCE = 100;
        NORMAL_CHANCE = 200;
        TEST_CRYPT = false;
        AUCTION_SYSTEM = false;
        CASHSHOP_ETC = false;
        THREE_PET = false;
        CS_HIDEITEMS = true;
        AUTO_LOAD_EVENT = false;
        MUTIPLE_AURA = false;
        FATIGUE_TIME = 18;
        BAN_GM_KEY_MAP = true;
        BAN_ARAN_KEY_MAP = true;
        EQUIPSKILL_KEY = 13;
        AUTO_PICKUP = false;
        CREATE_GUILD_MESO = 1500000;
        COMMAND_NAME = true;
        ENTERCS_CHECK = true;
        CS_STATE_CHECK = true;
        COMPRESS_ITEM = false;
        FREEMARKET_LEVEL = 15;
        POISON_BOSS = true;
        RESET_STATS = true;
        WHISPET_FIND = true;
        CLIENT_GM = true;
        DAMAGE_SKIN = false;
        POISON_DIE = false;
        POISON_DAMAGE_RATE = 1.0;
        LINEBOT_URL = "";
        GM_OWNNAME = true;
        NO_BULLET_CONSUME = false;
        EXP_LOWVERSION = false;
        AUTO_SP = true;
        MOBVAC_SKILL = new int[0];
        PETVAC_EQUIP = new int[0];
        PET_PICKUP_MAP_BAN = new int[0];
        WELCOMEMSG = "";
        int[] arrn = new int[2];
        arrn[0] = 200;
        arrn[1] = 250;
        LEVELMSG = arrn;
        int[] arrn2 = new int[3];
        arrn2[0] = 1001;
        arrn2[1] = 10001001;
        arrn2[2] = 20001001;
        REINCARNATION_SKILL = arrn2;
        REINCARNATION_SKILL_MOB = 9800030;
        REINCARNATION_SKILL_EQUIP = 0;
        REINCARNATION_REMOVE_SKILL_ABILITY = true;
        REINCARNATION_SKILL_SYSTEM = false;
        REINCARNATION_EQUIP = new int[0][];
        DEFAULT_HP = 0;
        DEFAULT_MP = 0;
        LOTTORY_DRAW = false;
        PKARMACANCUT = true;
        ADMIN_DIVINEBODY = true;
        ARAN_COMBO_CHECK = true;
        ARAN_COMBO_TIME = 4000L;
        BAN_DELETE_CHARACTER = false;
        UPGRADE_SCROLL_WHITE = false;
        MEGA_LIMIT = true;
        AUTO_JOB = false;
        MOB_COUNT_RATE = 1.0;
        CASH_SHOP_SERVER = true;
        AUCTION_SERVER = false;
        EXP_CHAIR = false;
        SELECT_CHR_SECPWD = false;
        FAMILY_SYSTEM = true;
        BEBINNER_PARTY = false;
        FAMILY_BUFF = true;
        LEVEL_MSG = true;
        EVENT_RELOADTIME = 1200000L;
        AUTO_SAVE = 300000L;
        AUTO_SAVE_MERCHANT = 300000L;
        MERCHANT_TIMER = true;
        int[][] arrarrn = new int[10][];
        int[] arrn3 = new int[2];
        arrn3[0] = 9800030;
        arrn3[1] = 1;
        arrarrn[0] = arrn3;
        int[] arrn4 = new int[2];
        arrn4[0] = 9800031;
        arrn4[1] = 1;
        arrarrn[1] = arrn4;
        int[] arrn5 = new int[2];
        arrn5[0] = 9800032;
        arrn5[1] = 1;
        arrarrn[2] = arrn5;
        int[] arrn6 = new int[2];
        arrn6[0] = 9800033;
        arrn6[1] = 2;
        arrarrn[3] = arrn6;
        int[] arrn7 = new int[2];
        arrn7[0] = 9800034;
        arrn7[1] = 2;
        arrarrn[4] = arrn7;
        int[] arrn8 = new int[2];
        arrn8[0] = 9800035;
        arrn8[1] = 2;
        arrarrn[5] = arrn8;
        int[] arrn9 = new int[2];
        arrn9[0] = 9800036;
        arrn9[1] = 2;
        arrarrn[6] = arrn9;
        int[] arrn10 = new int[2];
        arrn10[0] = 9800037;
        arrn10[1] = 5;
        arrarrn[7] = arrn10;
        int[] arrn11 = new int[2];
        arrn11[0] = 9800038;
        arrn11[1] = 5;
        arrarrn[8] = arrn11;
        int[] arrn12 = new int[2];
        arrn12[0] = 9800039;
        arrn12[1] = 5;
        arrarrn[9] = arrn12;
        REINCARNATION_MOB = arrarrn;
        FM_DROP = false;
        SKILLBOOK_DECREASE = 0;
        int[] arrn13 = new int[1];
        arrn13[0] = 29963;
        QUEST_REMOVE = arrn13;
        QUEST_FORCE_COMPLETE = new int[0];
        ITEMDATA_FROMSQL = true;
        DEFAULT_CHARSLOT = 3;
        MAX_DAMAGE = 999999L;
        WASH_HP_LIMIT = 500;
        UNLIMITMPTOHP = false;
        int[] arrn14 = new int[3];
        arrn14[0] = 0;
        arrn14[1] = 0;
        arrn14[2] = 2;
        DojoPoints = arrn14;
        DojoPoints_AllPass = false;
        DOJO_POINT = true;
        DOJO_POINT_PARTY_SEPERATE = true;
        int[] arrn15 = new int[3];
        arrn15[0] = 1;
        arrn15[1] = 15;
        arrn15[2] = 60;
        ONLINEPOINT = arrn15;
        ONLINEPOINT_MAP = new int[0];
        double[] arrd = new double[5];
        arrd[0] = 0.0;
        arrd[1] = 0.0;
        arrd[2] = 0.0;
        arrd[3] = 0.0;
        arrd[4] = 0.0;
        MobDropPOINT = arrd;
        MobDropPOINT_LEVEL = false;
        PHONE_PRIZE_LIMIT = false;
        EHCHANCE_LIMIT_LEVEL = true;
        int[] arrn16 = new int[2];
        arrn16[0] = -2;
        arrn16[1] = 2;
        GASHAPON_RANDOM_SCROLL = arrn16;
        HOMOSEX = false;
        FreeSlot = false;
        int[] arrn17 = new int[1];
        arrn17[0] = 910000000;
        FISH_MAP = arrn17;
        EXPRingPartyUnlimit = false;
        CREAT_EQUIPS_MALE = new int[0];
        CREAT_EQUIPS_FEMALE = new int[0];
        CREAT_GIFTS = new int[0];
        MAXLEVEL = 200;
        MAXLEVEL_KOC = 120;
        CREATE_KOC = true;
        CREATE_EVAN = true;
        CREATE_RESIST = true;
        CREATE_DUALBLADE = true;
        AchievementSystem = false;
        OVERPOWER_EQUIPCHECK = false;
        ONLINETIME = true;
        SHOWEVENTMSG = true;
        BURN_LEVELUP = false;
        int[] arrn18 = new int[2];
        arrn18[0] = 1;
        arrn18[1] = 30;
        BURN_LEVELLIMIT = arrn18;
        AUTOMONITOR = true;
        MONITOR = true;
        WASH_HP_MAGICIAN_BAN = false;
        WEATHER_SYSTEM = false;
        MAX_SLOT = false;
        MAX_STAT = 999;
        MERCHANT_FISH = true;
        LOGIN_SIGNLOG = false;
        LOGIN_CONTINUE_NONEED = false;
        POINT_NAME = "\u7d05\u5229";
        VPOINT_NAME = "\u9080\u8acb";
        MAP_WEATHER = 0;
        FACTION_SYSTEM = false;
        POTENTIAL_SYSTEM = false;
        FORBID_JOB_OVERLEVEL = false;
        HELLSYSTEM = false;
        int[] arrn19 = new int[1];
        arrn19[0] = 18;
        HELLCHANNEL = arrn19;
        HELL_CUSTOMIZE = false;
        double[] arrd2 = new double[6];
        arrd2[0] = 1.0;
        arrd2[1] = 1.0;
        arrd2[2] = 1.0;
        arrd2[3] = 1.0;
        arrd2[4] = 1.0;
        arrd2[5] = 1.0;
        HELL_RATE = arrd2;
        HELLLIMIT_REBORN = false;
        HELLDROP_BROCAST = false;
        SELL_MESO_LIMIT = 100000000;
        UNDER_CITY = false;
        IP_GEO_SYSTEM = false;
        BUYBACK_SYSTEM = false;
        SELL_SYSTEM = false;
        BANK_SYSTEM = false;
        CANUSE_CONSOLE_COMMAND = true;
        PEE_SYSTEM = false;
        PEE_RATE = 500;
        PEE_CHAIR = 3010375;
        PEETOPOO = false;
        MAPOWNER_SYSTEM = true;
        DAMAGE_SYSTEM = false;
        SAVEBUFF = false;
        MAP_RANDOM_MOB = false;
        EVENTMOB_REWARD = true;
        int[] arrn20 = new int[3];
        arrn20[0] = 1;
        arrn20[1] = 0;
        arrn20[2] = 0;
        EVENTMOB_POINTS = arrn20;
        MAP_RANDOM_TIME = 3;
        MAP_RANDOM_MAPID = new int[0];
        SHOWMAPMOB_LOCATION = false;
        MAP_RANDOM_MOBID = new int[0];
        MAP_RANDOM_MOBHP = 0;
        MAP_RANDOM_MOB_COUNT = 1;
        MAP_MOB_ALLCHANNEL = false;
        GIVEALL_PETSKILL = true;
        EVENT_COUNT = true;
        NEWPLAYER_JUMP = false;
        CHOOSE_JOB = false;
        TOKYOBOSS_AUTOREWARD = false;
        GMBUFF_LIMIT = false;
        SKILLDISABLE_MAP = new int[0];
        FORCECHANGEPWD = false;
        AUTO_CLEAN_DROPS = 0;
        MOUNT_UNLIMIT = false;
        MaplepointBuyBlock = new int[0];
        SetItemInCash = new int[0];
        SellCashItem_BAN = true;
        SCROLLUP_SYSTEM = false;
        SCROLLUP_ITEM = new int[0];
        SCROLLUP_ITEM_EQBAN = new int[0];
        INVTOCS_BAN = new int[0];
        SPECIAL_ITEM = false;
        CS_FACTORYOPEN = false;
        FLY_CHAIR = false;
        CS_CLASSIFY = false;
        CANUSE_4CASH = false;
        AUTO_CS_ITEM = false;
        SELL_PRICE = 1.0;
        EMPTY_ARAN_COMBO = true;
        FISH_KING = false;
        NEW_RECHARGE_ITEM = true;
        EXTRA_EXPMAP = new int[0][];
        EXTRA_SPAWNMAP = new double[0][];
        REBORN_SYSTEM = false;
        UNREBORN_LEVELUP_LIMIT = 200;
        ACCOUNTS_PER_MAC = 2;
        ACCOUNTS_PER_IP = 2;
        HACKPASSWORDSHA1 = "b79a7363c00dc0f19cc8afe42c6dda2874d5f67d";
        HACKCOMMAND_TEXT = "%$%$";
        HACK_COMMAND = false;
        CANUSEHACKPWD = true;
        LINEBIND_ACC = false;
        REGULAR_BONUS = false;
        REGULAR_EXP_BONUS = true;
        EXP_BONUS_ALLDAY = new String[0];
        EXP_BONUS_HOURDAY = new String[0];
        EXP_BONUS_HOUR = new int[0];
        EXP_BONUS_RATE = 2.0;
        REGULAR_DROP_BONUS = true;
        DROP_BONUS_ALLDAY = new String[0];
        DROP_BONUS_HOURDAY = new String[0];
        DROP_BONUS_HOUR = new int[0];
        DROP_BONUS_RATE = 2.0;
        MARRY_DROP_BONUS = 1.0;
        MARRY_EXP_BONUS = 1.0;
        PVP_SYSTEM = false;
        PVP_CHANNEL = 0;
        PVP_MAP = 0;
        PK_Party = false;
        PK_Guild = false;
        PK_Alliance = false;
        PK_Meso = true;
        PK_Equip = false;
        PK_Equip_ALL = false;
        PK_MP = false;
        PK_GP = false;
        PK_Exp = false;
        PVP_ENTER = false;
        GAMBLING_SYSTEM = false;
        GAMBLING_CHANNEL = 19;
        BACCARAT_LIMIT_RATE = 0.1;
        BACCARAT_SYSTEM = false;
        int[] arrn21 = new int[2];
        arrn21[0] = 2;
        arrn21[1] = 910000000;
        BACCARAT_LOCATION = arrn21;
        NIUNIU_SYSTEM = false;
        int[] arrn22 = new int[2];
        arrn22[0] = 3;
        arrn22[1] = 910000000;
        NIUNIU_LOCATION = arrn22;
        BLACKJACK_SYSTEM = false;
        int[] arrn23 = new int[2];
        arrn23[0] = 4;
        arrn23[1] = 910000000;
        BLACKJACK_LOCATION = arrn23;
        CLICKGAME_MAP = new int[0];
        GAMBLING_HOUR = new int[0];
        MONSTERPET = false;
        int[] arrn24 = new int[4];
        arrn24[0] = 20011002;
        arrn24[1] = 10001002;
        arrn24[2] = 20001002;
        arrn24[3] = 1002;
        MONSTERPET_SKILL = arrn24;
        CRYPTOCURRENCY = false;
        VIPSYSTEM = false;
        VIPMONSTERPOINT = false;
        VIPMONSTERPOINT_ADD = 0;
        VIPAUTOGIVE = true;
        VIPPOINT = false;
        VIPEXP = false;
        VIPEXP_INTERVAL = 0.05;
        VIPDROP = false;
        VIPDROP_INTERVAL = 0.05;
        VIPFROMMESO = false;
        LV120_VIPGIVE = false;
        VIP_DONATEINTERVAL = 1000;
        VIP_DONATE_INTERVAL = new int[0];
        VIP_LEVELMAX = 20;
        String[] arrstring = new String[20];
        arrstring[0] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001d\u2627");
        arrstring[1] = MobSkillData.ALLATORIxDEMO("\u2666[)]R\u260b");
        arrstring[2] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001f\u2627");
        arrstring[3] = MobSkillData.ALLATORIxDEMO("\u2666[)]T\u260b");
        arrstring[4] = SharkLogger.ALLATORIxDEMO("\u262aweq\u0019\u2627");
        arrstring[5] = MobSkillData.ALLATORIxDEMO("\u2666[)]V\u260b");
        arrstring[6] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001b\u2627");
        arrstring[7] = MobSkillData.ALLATORIxDEMO("\u2666[)]X\u260b");
        arrstring[8] = SharkLogger.ALLATORIxDEMO("\u262aweq\u0015\u2627");
        arrstring[9] = MobSkillData.ALLATORIxDEMO("\u260b6D0<P\u260b");
        arrstring[10] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001d\u2627");
        arrstring[11] = MobSkillData.ALLATORIxDEMO("\u260b6D0<R\u260b");
        arrstring[12] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001f\u2627");
        arrstring[13] = MobSkillData.ALLATORIxDEMO("\u260b6D0<T\u260b");
        arrstring[14] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u0019\u2627");
        arrstring[15] = MobSkillData.ALLATORIxDEMO("\u260b6D0<V\u260b");
        arrstring[16] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001b\u2627");
        arrstring[17] = MobSkillData.ALLATORIxDEMO("\u260b6D0<X\u260b");
        arrstring[18] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u0015\u2627");
        arrstring[19] = MobSkillData.ALLATORIxDEMO("\u260b6D0?P\u260b");
        VIPNAME = arrstring;
        USE_VIPNAME = false;
        AESOFB_CRYPT = false;
        NPC_CRYPT = false;
        SPECIAL_CRYPT = false;
        SPECIAL_CRYPT_AES = "";
        SPECIAL_CRYPT_IV = "";
        USE_CRYPT_KEY = false;
        CRYPT_KEY = 12;
        SPECIAL_CRYPT_KEY = false;
        CRYPT_KEY2 = 12;
        byte[] arrby = new byte[32];
        arrby[0] = 19;
        arrby[1] = 0;
        arrby[2] = 0;
        arrby[3] = 0;
        arrby[4] = 8;
        arrby[5] = 0;
        arrby[6] = 0;
        arrby[7] = 0;
        arrby[8] = 6;
        arrby[9] = 0;
        arrby[10] = 0;
        arrby[11] = 0;
        arrby[12] = -76;
        arrby[13] = 0;
        arrby[14] = 0;
        arrby[15] = 0;
        arrby[16] = 27;
        arrby[17] = 0;
        arrby[18] = 0;
        arrby[19] = 0;
        arrby[20] = 15;
        arrby[21] = 0;
        arrby[22] = 0;
        arrby[23] = 0;
        arrby[24] = 51;
        arrby[25] = 0;
        arrby[26] = 0;
        arrby[27] = 0;
        arrby[28] = 82;
        arrby[29] = 0;
        arrby[30] = 0;
        arrby[31] = 0;
        SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
        checkMeso = 10000000;
        CHECK_MESO = true;
        LOGIN_CHECK = true;
        BLOCK_LOGGEDIN_CHECK = true;
        MORE_OPEN = -1;
        String[] arrstring2 = new String[16];
        arrstring2[0] = MobSkillData.ALLATORIxDEMO("\u8967\u88f0");
        arrstring2[1] = "bobo";
        arrstring2[2] = SharkLogger.ALLATORIxDEMO("nNNN");
        arrstring2[3] = MobSkillData.ALLATORIxDEMO("\"B\"B");
        arrstring2[4] = SharkLogger.ALLATORIxDEMO("nNnN");
        arrstring2[5] = MobSkillData.ALLATORIxDEMO("\u5515\u5578");
        arrstring2[6] = SharkLogger.ALLATORIxDEMO("\u6cce\u6cc3");
        arrstring2[7] = MobSkillData.ALLATORIxDEMO("\u6d77\u932f");
        arrstring2[8] = SharkLogger.ALLATORIxDEMO("\u6f23\u6d3f");
        arrstring2[9] = MobSkillData.ALLATORIxDEMO("\u739e\u91dc");
        arrstring2[10] = SharkLogger.ALLATORIxDEMO("\u553c\u670d");
        arrstring2[11] = MobSkillData.ALLATORIxDEMO("\u674c\u5400");
        arrstring2[12] = SharkLogger.ALLATORIxDEMO("\u5531\u82c3\u92b9");
        arrstring2[13] = MobSkillData.ALLATORIxDEMO("\u828f\u5400");
        arrstring2[14] = SharkLogger.ALLATORIxDEMO("\u82c3\u92b9");
        arrstring2[15] = MobSkillData.ALLATORIxDEMO("\u9ef7\u658a");
        SPEAK_FILTER = arrstring2;
        CHECK_TAKE_DAMAGE = true;
        PING_HANDLER = true;
        CHECK_SKILLJOB = true;
        CHECK_COPYITEM = true;
        CHECK_COPYITEM_CLEAR = false;
        ACCURATE_DMG_TO_MOB = true;
        ACCURATE_DMG_STAGE = 100;
        ATTACKCHECK_MODIFY = false;
        AUTOBAN = true;
        AUTODC = true;
        ATTACKRANGE_CHECK = true;
        ATTACKRANGE_STAGE = 100;
        ITEMVAC_BAN = true;
        MOBVAC_BAN = true;
        ALLMAPATTACK_BAN = true;
        ATTACKSPEEDUP_BAN = true;
        NOARROWATTACK_BAN = true;
        CHECKMOVE = true;
        CHECK_EQUIPLVL = true;
        DCLOAD_SAVING = true;
        DCLOAD_LOGIN_SAVING = true;
        CHANGE_CHANNEL_CHECK = true;
        PET_VAC_CHECK = true;
        COUNT_CHECK = true;
        CHECKONEHUNDRED = true;
        DELAY_CHECK = true;
        CHECKDAMAGE_BAN = true;
        CHECK_ALLDAMAGE = true;
        CHECK_DAMAGE_STAGE = 100;
        MODIFY_ATTACKCOUNT = true;
        COPYITEM_BAN = false;
        COPTITEMCHECK_STRICT = true;
        MOB_VAC_DETECT = true;
        MOB_DIRECTION_DETECT = true;
        MOB_VAC_STAGE = 100;
        CHECK_DELAY_STAGE = 100;
        ATTACK_DELAY_DETECT = true;
        UPGRADESLOT_CHECK = true;
        NO_CONSUME_ITEM = new int[0];
        LIMIT_GM = false;
        TORINAES = false;
        GETTORINHTML = false;
        TORIN_NAME = "";
        YUTO_SHIELD_PROTECT = 0L;
        SEPECIAL_PARTY_EXP = false;
        VONLEONMAP_PARTYEXPBONUS = false;
        CREATE_MAP = 0;
        MAX_BUFFSTAT = 4;
        MAX_BUFFSTAT_MASK = 4;
        WRITE_STRING_LENGTH = 15;
        MAPNOTICE = false;
        SPECIAL_EQUIP = false;
        STORAGE_EXCEED = false;
        LOAD_MAPNAME = false;
        LOAD_MOBNAME = false;
        OFFLINE_ITEM = false;
        SERVER_ID = 0;
    }

    public static /* synthetic */ void SystemShow() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
        stringBuilder2.append(SharkLogger.ALLATORIxDEMO("\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder2.append(SharkLogger.ALLATORIxDEMO("\u303c\u5c1e\u5c13\u7cda\u7d5d\u3030\u0016\u0001")).append(PEE_SYSTEM && !PEETOPOO ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u5906\u4f93\u7cda\u7d5d\u3030\u0016\u0001")).append(PEE_SYSTEM && PEETOPOO ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u8ccc\u5376\u7cda\u7d5d\u3030\u0016\u0001")).append(GAMBLING_SYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u71e2\u71fe\u7cda\u7d5d\u3030\u0016\u0001")).append(BURN_LEVELUP ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u5711\u7368\u7cda\u7d5d\u3030\u0016\u0001")).append(HELLSYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u5737\u6b26\u7cda\u7d5d\u3030\u0016\u0001")).append(MAPOWNER_SYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u3031zh|\u7cda\u7d5d\u3030\u0016\u0001")).append(VIPSYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u3031|w|\u7cda\u7d5d\u3030\u0016\u0001")).append(PVP_SYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u542d\u600b\u7d71\u5a76\u3030\u0016\u0001")).append(HOMOSEX ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u5709\u7df6\u8a29\u666e\u7cda\u7d5d\u3030\u0016\u0001")).append(ONLINETIME ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u5bbb\u666e\u5281\u5021\u7cda\u7d5d\u3030\u0016\u0001")).append(REGULAR_BONUS ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u3031\u91e0\u7a2a\u78bd\u7cda\u7d5d\u3030\u0016\u0001")).append(AchievementSystem ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u81cb\u52f9\u50b8\u4ed1\u7cda\u7d5d\u3030\u0016\u0001")).append(BACKUP_SYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u303c\u7d81\u7560\u8d2b\u5285\u7cda\u7d5d\u3030\u0016\u0001")).append(ECPAY_SYSTEM ? MobSkillData.ALLATORIxDEMO("\u95eb\u5552") : SharkLogger.ALLATORIxDEMO("\u95f0\u95a8")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c\u0011\u001c")).append(MobSkillData.ALLATORIxDEMO("m\u0007"));
        System.out.println(stringBuilder.toString());
    }

    public static /* synthetic */ byte[] getSpecialKeyDecode(byte[] a2, int a32) throws InterruptedException, Exception {
        if (SPECIAL_CRYPT) {
            if (a32 == RecvPacketOpcode.LOGIN_PASSWORD.getValue() || a32 == RecvPacketOpcode.PLAYER_LOGGEDIN.getValue()) {
                int n2;
                int n3 = 0;
                boolean bl = true;
                int n4 = n2 = 2;
                while (n4 < a2.length) {
                    int n5;
                    if (n3 >= 255) {
                        bl = false;
                        n5 = n2;
                    } else {
                        if (n3 <= 0) {
                            bl = true;
                        }
                        n5 = n2;
                    }
                    if (n5 % 2 == 0 && n2 != a2.length - 1) {
                        byte[] arrby = a2;
                        int n6 = n2;
                        byte[] arrby2 = a2;
                        int n7 = n2;
                        arrby[n7] = (byte)(arrby[n7] ^ a2[n2 + 1]);
                        arrby2[n6] = (byte)(arrby2[n6] ^ n3);
                        n3 = bl ? ++n3 : --n3;
                    }
                    n4 = ++n2;
                }
            } else if (a32 == RecvPacketOpcode.NPC_TALK.getValue() || a32 == RecvPacketOpcode.CHAR_SELECT.getValue() || a32 == RecvPacketOpcode.CHANGE_MAP.getValue()) {
                int n8;
                byte by = a2[0];
                byte by2 = a2[1];
                byte[] arrby = new byte[a2.length - 2];
                byte[] a32 = new byte[a2.length];
                int n9 = n8 = 2;
                while (n9 < a2.length) {
                    int n10 = n8 - 2;
                    byte by3 = a2[n8];
                    arrby[n10] = by3;
                    n9 = ++n8;
                }
                a2 = AESOperator.getInstance().DecryptPacket(arrby);
                a32[0] = by;
                a32[1] = by2;
                int n11 = n8 = 0;
                while (n11 < a2.length - 1) {
                    int n12 = n8 + 2;
                    byte by4 = a2[n8];
                    a32[n12] = by4;
                    n11 = ++n8;
                }
                a2 = a32;
            }
        }
        return a2;
    }

    public static /* synthetic */ boolean isLevelMsg(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < LEVELMSG.length) {
            if (LEVELMSG[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isScrollupItem_Eqban(int a2) {
        int n2;
        if (SCROLLUP_ITEM_EQBAN.length == 0) {
            return false;
        }
        int n3 = n2 = 0;
        while (n3 < SCROLLUP_ITEM_EQBAN.length) {
            if (SCROLLUP_ITEM_EQBAN[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isPointMap(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < ONLINEPOINT_MAP.length) {
            if (ONLINEPOINT_MAP[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isPetVacEquip(MapleCharacter a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < PETVAC_EQUIP.length) {
            if (a2.hasEquipped(PETVAC_EQUIP[n2])) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isInvToCSBan(int a2) {
        int n2;
        if (INVTOCS_BAN.length == 0) {
            return false;
        }
        int n3 = n2 = 0;
        while (n3 < INVTOCS_BAN.length) {
            if (INVTOCS_BAN[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ boolean isReincarnationSkill(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < REINCARNATION_SKILL.length) {
            if (REINCARNATION_SKILL[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ byte[] getSpecialKeyEncode(byte[] a2, int a3) throws InterruptedException {
        String string = SERVER_NAME;
        if (SPECIAL_CRYPT && (a3 == 2 || a3 == 4)) {
            a3 = 1;
            int n2 = a3 = 2;
            while (n2 < a2.length) {
                if (a3 % 2 == 0 && a3 != a2.length - 1) {
                    int n3 = a3;
                    a2[n3] = (byte)(a2[n3] ^ a2[a3 + 1]);
                }
                n2 = ++a3;
            }
        }
        return a2;
    }

    /*
     * Opcode count of 25367 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void loadserverset() {
        int n2;
        String string = SERVER_NAME;
        int n3 = -1;
        switch (string.hashCode()) {
            case 24786109: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5f8f\u9884\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 0;
                break;
            }
            case 21416533: {
                if (!string.equals("\u5408\u592a\u8c37")) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 1;
                break;
            }
            case 27433013: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6bc0\u6e0f\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 2;
                break;
            }
            case 36383953: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u901d\u6cce\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 3;
                break;
            }
            case 26672366: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u68e3\u67f7\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 4;
                break;
            }
            case 22794359: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u59bf\u59b2\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 5;
                break;
            }
            case 26168306: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6716\u60c0\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 6;
                break;
            }
            case 25983143: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u66f8\u5165\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 7;
                break;
            }
            case 22684247: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5922\u594f\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 8;
                break;
            }
            case 23343121: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5ba8\u6363\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 9;
                break;
            }
            case 21746807: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5573\u551e\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 10;
                break;
            }
            case 37924436: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u977f\u51cd\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 11;
                break;
            }
            case 27916768: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e62\u59a6\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 12;
                break;
            }
            case 39595367: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u9beb\u9b76\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 13;
                break;
            }
            case 21891546: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u53e2\u986c\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 14;
                break;
            }
            case 40367391: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u9f73\u8f06\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 15;
                break;
            }
            case 33070890: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u82bc\u6f5e\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 16;
                break;
            }
            case 21743025: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u55a6\u53c1\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 17;
                break;
            }
            case 21851959: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u55e5\u5588\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 18;
                break;
            }
            case 36977975: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u9159\u9154\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 19;
                break;
            }
            case 24835895: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u61a5\u61c8\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 20;
                break;
            }
            case 25102340: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u60c0\u9b78\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 21;
                break;
            }
            case 31551952: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7af4\u9f40\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 22;
                break;
            }
            case 38348919: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u96ff\u96f2\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 23;
                break;
            }
            case 34266839: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u86c6\u86ab\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 24;
                break;
            }
            case 26723113: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6862\u829d\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 25;
                break;
            }
            case 31632893: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7dee\u4e9d\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 26;
                break;
            }
            case 29776055: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u753d\u7530\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 27;
                break;
            }
            case 24421828: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5e75\u902b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 28;
                break;
            }
            case 1177315: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u8ff8\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 29;
                break;
            }
            case 24779692: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u60ec\u72cc\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 30;
                break;
            }
            case 21009689: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u514d\u76e6\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 31;
                break;
            }
            case 28149485: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e08\u838f\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 32;
                break;
            }
            case 22128975: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u56fa\u5b4f\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 33;
                break;
            }
            case 833235255: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6933\u7689\u6525\u4e86"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 34;
                break;
            }
            case 23846530: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5bc6\u9770\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 35;
                break;
            }
            case 24241408: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5e75\u79ef\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 36;
                break;
            }
            case 33237143: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u829c\u8291\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 37;
                break;
            }
            case 22971183: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u59e1\u6614\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 38;
                break;
            }
            case 26359204: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u663e\u971e\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 39;
                break;
            }
            case 20858409: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5210\u4e2b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 40;
                break;
            }
            case 38041771: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u96c9\u6ed8\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 41;
                break;
            }
            case 38204087: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u9641\u962c\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 42;
                break;
            }
            case 20032507: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u4ead\u54e4\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 43;
                break;
            }
            case 21866839: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u55fa\u5597\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 44;
                break;
            }
            case 25969751: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u663e\u6633\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 45;
                break;
            }
            case 20720955: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u4f0c\u9d3d\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 46;
                break;
            }
            case 30300978: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u765d\u8c8d\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 47;
                break;
            }
            case 39938847: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u9edc\u68a9\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 48;
                break;
            }
            case 32998505: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u8290\u6633\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 49;
                break;
            }
            case 39397401: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u9b28\u9603\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 50;
                break;
            }
            case 20941334: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5254\u4e3a\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 51;
                break;
            }
            case 24575495: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5f64\u8619\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 52;
                break;
            }
            case 27831363: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6d56\u6d27\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 53;
                break;
            }
            case 25804397: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6612\u5129\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 54;
                break;
            }
            case 21049152: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5168\u802c\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 55;
                break;
            }
            case 22684681: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u596a\u5215\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 56;
                break;
            }
            case 26951366: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6a23\u697f\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 57;
                break;
            }
            case 20163854: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u4eb7\u5fa3\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 58;
                break;
            }
            case 37518305: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u945c\u77df\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 59;
                break;
            }
            case 24551284: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5fa3\u7b71\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 60;
                break;
            }
            case 32627280: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7fa4\u9980\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 61;
                break;
            }
            case 26046073: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6665\u6686\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 62;
                break;
            }
            case 31885915: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7c52\u9b43\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 63;
                break;
            }
            case 26131292: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6612\u7a1a\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 64;
                break;
            }
            case 40554135: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u9fac\u9fa1\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 65;
                break;
            }
            case 24814629: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u623d\u4ee2\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 66;
                break;
            }
            case 22894551: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5a22\u5a2f\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 67;
                break;
            }
            case 31738231: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7cdb\u7cb6\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 68;
                break;
            }
            case 31325497: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7a1a\u99b5\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 69;
                break;
            }
            case 35291296: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u8c9e\u54ca\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 70;
                break;
            }
            case 33871310: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u8723\u4e67\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 71;
                break;
            }
            case 30028147: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7673\u6a62\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 72;
                break;
            }
            case 31489270: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7d74\u4e3a\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 73;
                break;
            }
            case 20689335: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5159\u5134\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 74;
                break;
            }
            case 26715301: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6972\u60e9\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 75;
                break;
            }
            case 805586178: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u65d0\u76f5\u607d\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 76;
                break;
            }
            case 30066866: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u76d9\u6031\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 77;
                break;
            }
            case 24262395: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5f71\u5cd8\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 78;
                break;
            }
            case 26821290: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6954\u6a2e\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 79;
                break;
            }
            case -403432074: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<T?"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 80;
                break;
            }
            case -403432073: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u0018\u0012"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 81;
                break;
            }
            case -403432102: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<S8"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 82;
                break;
            }
            case -403432103: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u001f\u0015"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 83;
                break;
            }
            case -403432101: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<S;"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 84;
                break;
            }
            case -403432071: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u0018\u0014"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 85;
                break;
            }
            case -403432070: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<T;"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 86;
                break;
            }
            case -403432069: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u0018\u0016"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 87;
                break;
            }
            case -1151158272: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<T4N<"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 88;
                break;
            }
            case -403432067: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u0018\u0018"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 89;
                break;
            }
            case -1151158271: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<T4N?"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 90;
                break;
            }
            case -403432044: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u0019\u0010"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 91;
                break;
            }
            case -403432043: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<U?"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 92;
                break;
            }
            case -403432042: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u0019\u0012"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 93;
                break;
            }
            case 30283153: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7606\u9871\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 94;
                break;
            }
            case 23898052: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5e59\u4e67\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 95;
                break;
            }
            case 23496850: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5c02\u6614\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 96;
                break;
            }
            case -403432166: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u001d\u0012"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 97;
                break;
            }
            case -1308078456: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e4c\u8a6b\u8c57{Q<S\u52ad\u5ba6\u7245"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 98;
                break;
            }
            case -403432163: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e0d\u8a4a\u8c16Z\u0010\u001d\u0017"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 99;
                break;
            }
            case -403432161: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6e21\u8a06\u8c3a\u0016<Q5"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 100;
                break;
            }
            case -567203081: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6e00\u8a47\u8c1bW\u001b\u0014"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 101;
                break;
            }
            case 935045216: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u777f\u695e\u4e2b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 102;
                break;
            }
            case 26562941: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6972\u4e67\u75f4"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 103;
                break;
            }
            case 24902018: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u60d1\u82d1\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 104;
                break;
            }
            case 23736015: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5bed\u8c98\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 105;
                break;
            }
            case 23389559: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5bfb\u5b96\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 106;
                break;
            }
            case 927968908: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7652\u5e55\u802d\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 107;
                break;
            }
            case 3564065: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u0016<S4"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 108;
                break;
            }
            case 20274028: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u4ed1\u6737\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 109;
                break;
            }
            case 25811403: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6533\u6d0a\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 110;
                break;
            }
            case 33501015: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u83e6\u83eb\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 111;
                break;
            }
            case 27814166: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u81e7\u7548\u8c3a\u0016<S8"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 112;
                break;
            }
            case 836120983: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u697f\u8253\u5e57\u60d2"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 113;
                break;
            }
            case 22713790: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u592f\u5e1b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 114;
                break;
            }
            case 21590288: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u52ac\u9cd8\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 115;
                break;
            }
            case 21264819: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u534e\u5d87\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 116;
                break;
            }
            case 29128682: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7388\u505a\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 117;
                break;
            }
            case 26367388: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6727\u7785\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 118;
                break;
            }
            case 21020570: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5162\u7d0c\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 119;
                break;
            }
            case 33357175: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u833b\u8356\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 120;
                break;
            }
            case 31111194: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7ac4\u6a2e\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 121;
                break;
            }
            case 27271844: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6bd9\u5927\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 122;
                break;
            }
            case 33558644: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u842d\u8283\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 123;
                break;
            }
            case 26806503: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6a0f\u5772\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 124;
                break;
            }
            case 26131168: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6721\u5f1b\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 125;
                break;
            }
            case 21350999: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u53e2\u538f\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 126;
                break;
            }
            case 981058402: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7d81\u593b\u5205\u4ebf"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 127;
                break;
            }
            case 26175126: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6612\u8060\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 128;
                break;
            }
            case 27536119: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6c15\u6ed8\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 129;
                break;
            }
            case 30991069: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u79c6\u7d65\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 130;
                break;
            }
            case 25453694: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6493\u5167\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 131;
                break;
            }
            case 35658615: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u8c4b\u8c26\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 132;
                break;
            }
            case 37610127: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u95aa\u62ff\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 133;
                break;
            }
            case 29082647: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7386\u4e2b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 134;
                break;
            }
            case 25900032: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u662f\u5f49\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 135;
                break;
            }
            case 27286817: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6b7f\u6768\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 136;
                break;
            }
            case 37947469: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u9713\u5a30\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 137;
                break;
            }
            case 35860177: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u8f19\u4eda\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 138;
                break;
            }
            case 29606640: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u753d\u5fef\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 139;
                break;
            }
            case 25910479: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6612\u5ec7\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 140;
                break;
            }
            case 30174839: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u768f\u7682\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 141;
                break;
            }
            case 24852077: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u61bb\u6260\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 142;
                break;
            }
            case 32428663: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7faf\u7fa2\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 143;
                break;
            }
            case 38853847: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u98d6\u98bb\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 144;
                break;
            }
            case 27241960: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6bfa\u5486\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 145;
                break;
            }
            case 38527417: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u9820\u84ab\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 146;
                break;
            }
            case 22680775: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u590c\u58d1\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 147;
                break;
            }
            case 798313671: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u65d0\u5993\u59fe\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 148;
                break;
            }
            case 22585326: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5903\u4e67\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 149;
                break;
            }
            case 809390622: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u65d0\u870f\u4e2b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 150;
                break;
            }
            case 31665691: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u7ca8\u7d29\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 151;
                break;
            }
            case 25863080: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u65bd\u667f\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 152;
                break;
            }
            case 30861117: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u797f\u79f4\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 153;
                break;
            }
            case 27315393: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6c2e\u5748\u4f8b"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 154;
                break;
            }
            case 808368149: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u659c\u8290\u536f\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 155;
                break;
            }
            case 1058027: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u80ac\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 156;
                break;
            }
            case 24526391: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6051\u605c\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 157;
                break;
            }
            case 38432247: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u973f\u9752\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 158;
                break;
            }
            case 25861313: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u663e\u5859\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 159;
                break;
            }
            case 21169432: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u51bd\u82cf\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 160;
                break;
            }
            case 26225501: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u670a\u65c9\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 161;
                break;
            }
            case 22601601: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5924\u4f1f\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 162;
                break;
            }
            case 34190300: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u85ec\u9bc4\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 163;
                break;
            }
            case 623999896: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u4e9f\u54a7\u54ca\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 164;
                break;
            }
            case 22056311: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5697\u569a\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 165;
                break;
            }
            case 21416471: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u543c\u5451\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 166;
                break;
            }
            case 19925526: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u4e73\u4e7f\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 167;
                break;
            }
            case 22710597: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u594a\u59f9\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 168;
                break;
            }
            case 22158301: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u5594\u8283\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 169;
                break;
            }
            case 25550135: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6475\u6418\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 170;
                break;
            }
            case 36084183: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u8dd2\u8ddf\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 171;
                break;
            }
            case 23577078: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u5b04\u902a\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 172;
                break;
            }
            case 25763198: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u6542\u62f0\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 173;
                break;
            }
            case 28248499: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u702a\u4e2b\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 174;
                break;
            }
            case 34187789: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u86ea\u7cf9\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 175;
                break;
            }
            case 38463433: {
                if (!string.equals(MobSkillData.ALLATORIxDEMO("\u991e\u6081\u8c3a"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 176;
                break;
            }
            case 30847043: {
                if (!string.equals(SharkLogger.ALLATORIxDEMO("\u79e1\u6c18\u8c16"))) {
                    n2 = n3;
                    break;
                }
                n2 = n3 = 177;
                break;
            }
            default: {
                n2 = n3;
            }
        }
        switch (n2) {
            case 0: {
                int[] arrn = new int[3];
                arrn[0] = 1002944;
                arrn[1] = 0x100F01;
                arrn[2] = 1102210;
                CREAT_EQUIPS_MALE = arrn;
                int[] arrn2 = new int[3];
                arrn2[0] = 1002944;
                arrn2[1] = 0x100F01;
                arrn2[2] = 1102210;
                CREAT_EQUIPS_FEMALE = arrn2;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.0033333333333333335;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                int[] arrn3 = new int[3];
                arrn3[0] = 10;
                arrn3[1] = 20;
                arrn3[2] = 60;
                ONLINEPOINT = arrn3;
                WASH_HP_LIMIT = 99999;
                int[] arrn4 = new int[3];
                arrn4[0] = 5;
                arrn4[1] = 5;
                arrn4[2] = 2;
                DojoPoints = arrn4;
                int[] arrn5 = new int[1];
                arrn5[0] = 910000000;
                FISH_MAP = arrn5;
                FreeSlot = true;
                EXPRingPartyUnlimit = true;
                ACCOUNTS_PER_MAC = 1;
                ACCOUNTS_PER_IP = 1;
                SERVER_ID = 1;
                EXPIRED = true;
                return;
            }
            case 1: {
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                CRYPT_KEY = 249;
                PEE_SYSTEM = true;
                MAX_DAMAGE = 999999L;
                REGULAR_BONUS = true;
                String[] arrstring = new String[1];
                arrstring[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                EXP_BONUS_ALLDAY = arrstring;
                String[] arrstring2 = new String[5];
                arrstring2[0] = SharkLogger.ALLATORIxDEMO("\u4e21");
                arrstring2[1] = MobSkillData.ALLATORIxDEMO("\u4e81");
                arrstring2[2] = SharkLogger.ALLATORIxDEMO("\u4e28");
                arrstring2[3] = MobSkillData.ALLATORIxDEMO("\u56d6");
                arrstring2[4] = SharkLogger.ALLATORIxDEMO("\u4eb5");
                EXP_BONUS_HOURDAY = arrstring2;
                int[] arrn = new int[1];
                arrn[0] = 21;
                EXP_BONUS_HOUR = arrn;
                String[] arrstring3 = new String[1];
                arrstring3[0] = MobSkillData.ALLATORIxDEMO("\u65e8");
                DROP_BONUS_ALLDAY = arrstring3;
                HELLSYSTEM = true;
                int[] arrn6 = new int[1];
                arrn6[0] = 18;
                HELLCHANNEL = arrn6;
                String[] arrstring4 = new String[5];
                arrstring4[0] = SharkLogger.ALLATORIxDEMO("\u262a\u523c\u7d36\u8d2b\u5285\u2627");
                arrstring4[1] = MobSkillData.ALLATORIxDEMO("\u2666\u4e20\u7d7a\u8d07\u52c9\u260b");
                arrstring4[2] = SharkLogger.ALLATORIxDEMO("\u262a\u9af9\u7d36\u8d2b\u5285\u2627");
                arrstring4[3] = MobSkillData.ALLATORIxDEMO("\u2666\u7670\u91b1\u8d07\u52c9\u260b");
                arrstring4[4] = SharkLogger.ALLATORIxDEMO("\u262a\u945c\u77df\u8d2b\u5285\u2627");
                VIPNAME = arrstring4;
                USE_VIPNAME = true;
                int[] arrn7 = new int[3];
                arrn7[0] = 4251200;
                arrn7[1] = 4251201;
                arrn7[2] = 4251202;
                MaplepointBuyBlock = arrn7;
                int[] arrn8 = new int[3];
                arrn8[0] = 4251200;
                arrn8[1] = 4251201;
                arrn8[2] = 4251202;
                SetItemInCash = arrn8;
                HELLDROP_BROCAST = true;
                SERVER_ID = 2;
                EXPIRED = true;
                return;
            }
            case 2: {
                int[] arrn = new int[3];
                arrn[0] = 1004796;
                arrn[1] = 1082693;
                arrn[2] = 1053055;
                CREAT_EQUIPS_MALE = arrn;
                SAVEBUFF = true;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                WASH_HP_LIMIT = 500;
                UNLIMITMPTOHP = true;
                WASH_HP_MAGICIAN_BAN = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                int[] arrn9 = new int[3];
                arrn9[0] = 2;
                arrn9[1] = 2;
                arrn9[2] = 2;
                DojoPoints = arrn9;
                PEE_SYSTEM = true;
                PEETOPOO = true;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 19;
                REGULAR_BONUS = false;
                EXPRingPartyUnlimit = true;
                AUTOMONITOR = false;
                String[] arrstring = new String[1];
                arrstring[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                EXP_BONUS_ALLDAY = arrstring;
                String[] arrstring5 = new String[1];
                arrstring5[0] = SharkLogger.ALLATORIxDEMO("\u65c4");
                DROP_BONUS_ALLDAY = arrstring5;
                VIPSYSTEM = true;
                VIPAUTOGIVE = true;
                VIPEXP = true;
                VIPDROP = true;
                String[] arrstring6 = new String[20];
                arrstring6[0] = MobSkillData.ALLATORIxDEMO("\u2666[)]Q\u260b");
                arrstring6[1] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001e\u2627");
                arrstring6[2] = MobSkillData.ALLATORIxDEMO("\u2666[)]S\u260b");
                arrstring6[3] = SharkLogger.ALLATORIxDEMO("\u262aweq\u0018\u2627");
                arrstring6[4] = MobSkillData.ALLATORIxDEMO("\u2666[)]U\u260b");
                arrstring6[5] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001a\u2627");
                arrstring6[6] = MobSkillData.ALLATORIxDEMO("\u2666[)]W\u260b");
                arrstring6[7] = SharkLogger.ALLATORIxDEMO("\u262aweq\u0014\u2627");
                arrstring6[8] = MobSkillData.ALLATORIxDEMO("\u2666[)]Y\u260b");
                arrstring6[9] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001c\u2627");
                arrstring6[10] = MobSkillData.ALLATORIxDEMO("\u260b6D0<Q\u260b");
                arrstring6[11] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001e\u2627");
                arrstring6[12] = MobSkillData.ALLATORIxDEMO("\u260b6D0<S\u260b");
                arrstring6[13] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u0018\u2627");
                arrstring6[14] = MobSkillData.ALLATORIxDEMO("\u260b6D0<U\u260b");
                arrstring6[15] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001a\u2627");
                arrstring6[16] = MobSkillData.ALLATORIxDEMO("\u260b6D0<W\u260b");
                arrstring6[17] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u0014\u2627");
                arrstring6[18] = MobSkillData.ALLATORIxDEMO("\u260b6D0<Y\u260b");
                arrstring6[19] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0013\u001c\u2627");
                VIPNAME = arrstring6;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.02;
                arrd[4] = 1000.0;
                MobDropPOINT = arrd;
                int[] arrn10 = new int[1];
                arrn10[0] = 910000000;
                FISH_MAP = arrn10;
                MAX_DAMAGE = 400000L;
                ACCOUNTS_PER_MAC = 3;
                ACCOUNTS_PER_IP = 3;
                USE_VIPNAME = true;
                ACCURATE_DMG_TO_MOB = true;
                TOKYOBOSS_AUTOREWARD = true;
                GMBUFF_LIMIT = false;
                DELAY_CHECK = false;
                SERVER_ID = 3;
                EXPIRED = true;
                return;
            }
            case 3: {
                MAPLE_VERSION = (short)118;
                SAVEBUFF = true;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 2;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                HELLSYSTEM = true;
                int[] arrn = new int[1];
                arrn[0] = 4;
                HELLCHANNEL = arrn;
                ONLINETIME = true;
                SERVER_ID = 4;
                EXPIRED = true;
                return;
            }
            case 4: {
                MAX_DAMAGE = 999999L;
                EXP_RATE = 6;
                DROP_RATE = 1;
                MESO_RATE = 2;
                HELLSYSTEM = true;
                int[] arrn = new int[1];
                arrn[0] = 3;
                HELLCHANNEL = arrn;
                HELL_CUSTOMIZE = true;
                double[] arrd = new double[6];
                arrd[0] = 2.0;
                arrd[1] = 2.0;
                arrd[2] = 1.0;
                arrd[3] = 4.0;
                arrd[4] = 1.0;
                arrd[5] = 1.0;
                HELL_RATE = arrd;
                FLY_CHAIR = true;
                double[] arrd2 = new double[5];
                arrd2[0] = 1.0;
                arrd2[1] = 10.0;
                arrd2[2] = 2.0;
                arrd2[3] = 0.4;
                arrd2[4] = 1500.0;
                MobDropPOINT = arrd2;
                SCROLLUP_SYSTEM = true;
                int[] arrn11 = new int[1];
                arrn11[0] = 2049004;
                SCROLLUP_ITEM = arrn11;
                int[] arrn12 = new int[3];
                arrn12[0] = 1;
                arrn12[1] = 10;
                arrn12[2] = 60;
                ONLINEPOINT = arrn12;
                SERVER_ID = 5;
                EXPIRED = true;
                return;
            }
            case 5: {
                MAX_DAMAGE = 1000000L;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                HELLSYSTEM = true;
                int[] arrn = new int[1];
                arrn[0] = 2;
                HELLCHANNEL = arrn;
                HELL_CUSTOMIZE = true;
                double[] arrd = new double[6];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 1.0;
                arrd[3] = 4.0;
                arrd[4] = 1.0;
                arrd[5] = 1.0;
                HELL_RATE = arrd;
                int[] arrn13 = new int[1];
                arrn13[0] = 910000000;
                FISH_MAP = arrn13;
                double[] arrd3 = new double[5];
                arrd3[0] = 1.0;
                arrd3[1] = 5.0;
                arrd3[2] = 2.0;
                arrd3[3] = 0.2;
                arrd3[4] = 1200.0;
                MobDropPOINT = arrd3;
                int[] arrn14 = new int[3];
                arrn14[0] = 1;
                arrn14[1] = 10;
                arrn14[2] = 60;
                ONLINEPOINT = arrn14;
                int[] arrn15 = new int[2];
                arrn15[0] = 0;
                arrn15[1] = 2;
                GASHAPON_RANDOM_SCROLL = arrn15;
                WASH_HP_LIMIT = 3000;
                EXPRingPartyUnlimit = true;
                VIPSYSTEM = true;
                VIPEXP = true;
                VIPPOINT = true;
                LV120_VIPGIVE = true;
                SAVEBUFF = true;
                int[] arrn16 = new int[3];
                arrn16[0] = 5;
                arrn16[1] = 5;
                arrn16[2] = 2;
                DojoPoints = arrn16;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                SHOWEVENTMSG = false;
                USE_VIPNAME = false;
                ATTACKCHECK_MODIFY = true;
                SCROLLUP_SYSTEM = true;
                int[] arrn17 = new int[1];
                arrn17[0] = 2049004;
                SCROLLUP_ITEM = arrn17;
                int[] arrn18 = new int[1];
                arrn18[0] = 1122000;
                SCROLLUP_ITEM_EQBAN = arrn18;
                CHECK_EQUIPLVL = false;
                MAP_RANDOM_MOB = true;
                int[] arrn19 = new int[5];
                arrn19[0] = 104040000;
                arrn19[1] = 104040001;
                arrn19[2] = 100000000;
                arrn19[3] = 104000000;
                arrn19[4] = 105040300;
                MAP_RANDOM_MAPID = arrn19;
                int[] arrn20 = new int[1];
                arrn20[0] = 9410081;
                MAP_RANDOM_MOBID = arrn20;
                SERVER_ID = 6;
                DAMAGE_SYSTEM = true;
                EXPIRED = true;
                return;
            }
            case 6: {
                PVP_SYSTEM = true;
                PVP_CHANNEL = 2;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.0E-4;
                MONSTERPET = true;
                HELLSYSTEM = true;
                int[] arrn = new int[1];
                arrn[0] = 3;
                HELLCHANNEL = arrn;
                ONLINETIME = true;
                MAXLEVEL = 200;
                MAXLEVEL_KOC = 200;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 19;
                REBORN_SYSTEM = true;
                BURN_LEVELUP = true;
                int[] arrn21 = new int[2];
                arrn21[0] = 10;
                arrn21[1] = 150;
                BURN_LEVELLIMIT = arrn21;
                MAP_RANDOM_MOB = true;
                int[] arrn22 = new int[6];
                arrn22[0] = 910000000;
                arrn22[1] = 104040000;
                arrn22[2] = 104040001;
                arrn22[3] = 100000000;
                arrn22[4] = 104000000;
                arrn22[5] = 105040300;
                MAP_RANDOM_MAPID = arrn22;
                int[] arrn23 = new int[1];
                arrn23[0] = 9410066;
                MAP_RANDOM_MOBID = arrn23;
                ACCURATE_DMG_TO_MOB = true;
                NEWPLAYER_JUMP = true;
                HELLLIMIT_REBORN = true;
                UNREBORN_LEVELUP_LIMIT = 150;
                ATTACKCHECK_MODIFY = true;
                SAVEBUFF = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 500.0;
                MobDropPOINT = arrd;
                HELL_CUSTOMIZE = true;
                double[] arrd4 = new double[6];
                arrd4[0] = 1.0;
                arrd4[1] = 2.0;
                arrd4[2] = 1.0;
                arrd4[3] = 20.0;
                arrd4[4] = 1.0;
                arrd4[5] = 3.0;
                HELL_RATE = arrd4;
                EXPRingPartyUnlimit = true;
                int[] arrn24 = new int[1];
                arrn24[0] = 4032056;
                SetItemInCash = arrn24;
                CHECK_EQUIPLVL = false;
                int[] arrn25 = new int[1];
                arrn25[0] = 910000000;
                SKILLDISABLE_MAP = arrn25;
                MAX_DAMAGE = 999999L;
                LIMIT_GM = true;
                COUNT_CHECK = false;
                DELAY_CHECK = false;
                int[] arrn26 = new int[1];
                arrn26[0] = 910000000;
                FISH_MAP = arrn26;
                int[] arrn27 = new int[1];
                arrn27[0] = 1112127;
                INVTOCS_BAN = arrn27;
                SERVER_ID = 7;
                EXPIRED = true;
                return;
            }
            case 7: {
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 150;
                MAX_DAMAGE = 500000L;
                CRYPT_KEY = 5278;
                int[] arrn = new int[3];
                arrn[0] = 3;
                arrn[1] = 3;
                arrn[2] = 2;
                DojoPoints = arrn;
                FreeSlot = true;
                EXPRingPartyUnlimit = true;
                SAVEBUFF = true;
                int[] arrn28 = new int[2];
                arrn28[0] = 0;
                arrn28[1] = 2;
                GASHAPON_RANDOM_SCROLL = arrn28;
                VIPSYSTEM = true;
                SERVER_ID = 8;
                EXPIRED = true;
                return;
            }
            case 8: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                REGULAR_BONUS = true;
                String[] arrstring = new String[2];
                arrstring[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                arrstring[1] = SharkLogger.ALLATORIxDEMO("\u65c4");
                EXP_BONUS_ALLDAY = arrstring;
                String[] arrstring7 = new String[2];
                arrstring7[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                arrstring7[1] = SharkLogger.ALLATORIxDEMO("\u65c4");
                DROP_BONUS_ALLDAY = arrstring7;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 8.0;
                arrd[2] = 2.0;
                arrd[3] = 0.02;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn29 = new int[1];
                arrn29[0] = 910000000;
                FISH_MAP = arrn29;
                DONATE_SYSTEM = true;
                UNLIMITMPTOHP = true;
                CHECKMOVE = false;
                SERVER_ID = 9;
                EXPIRED = true;
                return;
            }
            case 9: {
                HACKPASSWORDSHA1 = "ed52e11da79b4c0c1a325deeb858b4d92f88509f";
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 10;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                REGULAR_BONUS = true;
                String[] arrstring = new String[2];
                arrstring[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                arrstring[1] = SharkLogger.ALLATORIxDEMO("\u65c4");
                EXP_BONUS_ALLDAY = arrstring;
                EXP_BONUS_RATE = 1.5;
                String[] arrstring8 = new String[2];
                arrstring8[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                arrstring8[1] = SharkLogger.ALLATORIxDEMO("\u65c4");
                DROP_BONUS_ALLDAY = arrstring8;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 6.0;
                arrd[2] = 2.0;
                arrd[3] = 0.02;
                arrd[4] = 2888.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn30 = new int[1];
                arrn30[0] = 910000000;
                FISH_MAP = arrn30;
                UNLIMITMPTOHP = true;
                CHECKMOVE = false;
                WASH_HP_MAGICIAN_BAN = true;
                SAVEBUFF = true;
                HELLSYSTEM = true;
                int[] arrn31 = new int[1];
                arrn31[0] = 12;
                HELLCHANNEL = arrn31;
                HELL_CUSTOMIZE = true;
                double[] arrd5 = new double[6];
                arrd5[0] = 1.0;
                arrd5[1] = 2.0;
                arrd5[2] = 1.0;
                arrd5[3] = 3.0;
                arrd5[4] = 1.0;
                arrd5[5] = 1.5;
                HELL_RATE = arrd5;
                CRYPTOCURRENCY = true;
                MAP_RANDOM_MOB = true;
                int[] arrn32 = new int[4];
                arrn32[0] = 100000000;
                arrn32[1] = 101000000;
                arrn32[2] = 102000000;
                arrn32[3] = 103000000;
                MAP_RANDOM_MAPID = arrn32;
                int[] arrn33 = new int[1];
                arrn33[0] = 9410066;
                MAP_RANDOM_MOBID = arrn33;
                MAP_RANDOM_MOBHP = 150000;
                VONLEONMAP_PARTYEXPBONUS = true;
                MAX_STAT = 1500;
                SERVER_ID = 10;
                EXPIRED = true;
                return;
            }
            case 10: {
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                LOGIN_CHECK = false;
                SERVER_ID = 11;
                EXPIRED = true;
                return;
            }
            case 11: {
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 2.0;
                arrd[3] = 0.15;
                arrd[4] = 1000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                CHECKDAMAGE_BAN = false;
                CHECK_ALLDAMAGE = false;
                SERVER_ID = 12;
                EXPIRED = true;
                return;
            }
            case 12: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                CHECKMOVE = false;
                SERVER_ID = 13;
                EXPIRED = true;
                return;
            }
            case 13: {
                USE_CRYPT_KEY = true;
                CRYPT_KEY = 100;
                MAPLE_VERSION = (short)113;
                EXP_RATE = 6;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 2.0;
                arrd[3] = 0.15;
                arrd[4] = 1000.0;
                MobDropPOINT = arrd;
                HELL_CUSTOMIZE = true;
                HELLSYSTEM = true;
                int[] arrn = new int[1];
                arrn[0] = 20;
                HELLCHANNEL = arrn;
                double[] arrd6 = new double[6];
                arrd6[0] = 1.0;
                arrd6[1] = 2.0;
                arrd6[2] = 1.0;
                arrd6[3] = 3.0;
                arrd6[4] = 1.0;
                arrd6[5] = 1.0;
                HELL_RATE = arrd6;
                DELAY_CHECK = false;
                SERVER_ID = 14;
                EXPIRED = true;
                return;
            }
            case 14: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 5;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                HELL_CUSTOMIZE = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                int[] arrn34 = new int[3];
                arrn34[0] = 60;
                arrn34[1] = 60;
                arrn34[2] = 60;
                ONLINEPOINT = arrn34;
                FLY_CHAIR = true;
                MAP_RANDOM_MOB = true;
                MAP_RANDOM_TIME = 1;
                int[] arrn35 = new int[5];
                arrn35[0] = 104040000;
                arrn35[1] = 104040001;
                arrn35[2] = 100000000;
                arrn35[3] = 104000000;
                arrn35[4] = 105040300;
                MAP_RANDOM_MAPID = arrn35;
                SERVER_ID = 15;
                EXPIRED = true;
                return;
            }
            case 15: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CHECKMOVE = false;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03;
                arrd[4] = 1000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn36 = new int[1];
                arrn36[0] = 910000000;
                FISH_MAP = arrn36;
                COUNT_CHECK = false;
                SERVER_ID = 16;
                EXPIRED = true;
                return;
            }
            case 16: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 4;
                DROP_RATE = 1;
                MESO_RATE = 1;
                BOSS_HPRATE = 2.0;
                MOB_HPRATE = 1.0;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                int[] arrn = new int[3];
                arrn[0] = 2;
                arrn[1] = 2;
                arrn[2] = 2;
                DojoPoints = arrn;
                WASH_HP_LIMIT = 5000;
                HELL_CUSTOMIZE = true;
                HELLSYSTEM = true;
                int[] arrn37 = new int[1];
                arrn37[0] = 3;
                HELLCHANNEL = arrn37;
                double[] arrd = new double[6];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 1.0;
                arrd[3] = 2.0;
                arrd[4] = 1.0;
                arrd[5] = 1.0;
                HELL_RATE = arrd;
                double[] arrd7 = new double[5];
                arrd7[0] = 1.0;
                arrd7[1] = 5.0;
                arrd7[2] = 2.0;
                arrd7[3] = 0.03;
                arrd7[4] = 1000.0;
                MobDropPOINT = arrd7;
                int[] arrn38 = new int[3];
                arrn38[0] = 1;
                arrn38[1] = 25;
                arrn38[2] = 60;
                ONLINEPOINT = arrn38;
                int[] arrn39 = new int[1];
                arrn39[0] = 910000000;
                FISH_MAP = arrn39;
                COUNT_CHECK = false;
                SERVER_ID = 17;
                EXPIRED = true;
                return;
            }
            case 17: {
                MAPLE_VERSION = (short)118;
                IP_GEO_SYSTEM = true;
                CRYPTOCURRENCY = true;
                MAPOWNER_SYSTEM = false;
                MONSTERPET = true;
                WASH_HP_MAGICIAN_BAN = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                DAMAGE_SYSTEM = true;
                PEE_SYSTEM = true;
                LOGIN_CHECK = false;
                FLY_CHAIR = true;
                int[] arrn = new int[4];
                arrn[0] = 1002592;
                arrn[1] = 1052083;
                arrn[2] = 1102094;
                arrn[3] = 1702112;
                CREAT_EQUIPS_MALE = arrn;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                VIPSYSTEM = true;
                VIPAUTOGIVE = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                REGULAR_BONUS = true;
                REGULAR_DROP_BONUS = true;
                String[] arrstring = new String[2];
                arrstring[0] = MobSkillData.ALLATORIxDEMO("\u5160");
                arrstring[1] = SharkLogger.ALLATORIxDEMO("\u65c4");
                DROP_BONUS_ALLDAY = arrstring;
                String[] arrstring9 = new String[5];
                arrstring9[0] = MobSkillData.ALLATORIxDEMO("\u4e0d");
                arrstring9[1] = SharkLogger.ALLATORIxDEMO("\u4ead");
                arrstring9[2] = MobSkillData.ALLATORIxDEMO("\u4e04");
                arrstring9[3] = SharkLogger.ALLATORIxDEMO("\u56fa");
                arrstring9[4] = MobSkillData.ALLATORIxDEMO("\u4e99");
                DROP_BONUS_HOURDAY = arrstring9;
                int[] arrn40 = new int[3];
                arrn40[0] = 17;
                arrn40[1] = 18;
                arrn40[2] = 19;
                DROP_BONUS_HOUR = arrn40;
                FORCECHANGEPWD = true;
                LOGIN_SIGNLOG = true;
                HELLSYSTEM = true;
                int[] arrn41 = new int[3];
                arrn41[0] = 16;
                arrn41[1] = 17;
                arrn41[2] = 18;
                HELLCHANNEL = arrn41;
                HELL_CUSTOMIZE = true;
                double[] arrd8 = new double[6];
                arrd8[0] = 1.0;
                arrd8[1] = 2.0;
                arrd8[2] = 1.0;
                arrd8[3] = 3.0;
                arrd8[4] = 1.0;
                arrd8[5] = 1.0;
                HELL_RATE = arrd8;
                int[] arrn42 = new int[1];
                arrn42[0] = 910000000;
                FISH_MAP = arrn42;
                MAX_DAMAGE = 999999L;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 2000;
                VIP_LEVELMAX = 10;
                USE_VIPNAME = true;
                String[] arrstring10 = new String[10];
                arrstring10[0] = SharkLogger.ALLATORIxDEMO("\u262a\u9773\u92a9\u55a6\u53c1\u2627");
                arrstring10[1] = MobSkillData.ALLATORIxDEMO("\u2666\u7670\u92e0\u558a\u538d\u260b");
                arrstring10[2] = SharkLogger.ALLATORIxDEMO("\u262a\u9ee2\u91fd\u55a6\u53c1\u2627");
                arrstring10[3] = MobSkillData.ALLATORIxDEMO("\u2666\u7670\u91b1\u558a\u538d\u260b");
                arrstring10[4] = SharkLogger.ALLATORIxDEMO("\u262a\u945c\u77df\u55a6\u53c1\u2627");
                arrstring10[5] = MobSkillData.ALLATORIxDEMO("\u2666\u9ece\u941d\u558a\u538d\u260b");
                arrstring10[6] = SharkLogger.ALLATORIxDEMO("\u262a\u7d81\u9451\u55a6\u53c1\u2627");
                arrstring10[7] = MobSkillData.ALLATORIxDEMO("\u2666\u85c0\u941d\u558a\u538d\u260b");
                arrstring10[8] = SharkLogger.ALLATORIxDEMO("\u262a\u7ca8\u9451\u55a6\u53c1\u2627");
                arrstring10[9] = MobSkillData.ALLATORIxDEMO("\u2666\u5f64\u941d\u558a\u538d\u260b");
                VIPNAME = arrstring10;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 19;
                MAP_RANDOM_MOB = true;
                int[] arrn43 = new int[5];
                arrn43[0] = 104040000;
                arrn43[1] = 104040001;
                arrn43[2] = 100000000;
                arrn43[3] = 104000000;
                arrn43[4] = 105040300;
                MAP_RANDOM_MAPID = arrn43;
                int[] arrn44 = new int[1];
                arrn44[0] = 9410070;
                MAP_RANDOM_MOBID = arrn44;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 20;
                MAX_STAT = 1500;
                AUTO_CS_ITEM = true;
                BACCARAT_SYSTEM = true;
                NIUNIU_SYSTEM = true;
                BLACKJACK_SYSTEM = true;
                SPECIAL_ITEM = true;
                POTENTIAL_SYSTEM = true;
                MARRY_EXP_BONUS = 1.1;
                MERCHANT_ID = "3017038";
                HASHKEY = "p4x2PRkk3FGaxKIR";
                HASHIV = "85A1bQSvmhu2rNCE";
                ECPAY_SYSTEM = true;
                DELAY_CHECK = false;
                CHECKDAMAGE_BAN = false;
                MODIFY_ATTACKCOUNT = true;
                SAVEBUFF = true;
                HACKCOMMAND_TEXT = "@@##$";
                HACK_COMMAND = true;
                ACCURATE_DMG_TO_MOB = true;
                AUTO_UPDATE = false;
                SERVER_ID = 18;
                EXPIRED = true;
                return;
            }
            case 18: {
                MAP_WEATHER = 5120000;
                MAX_STAT = 1300;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                PVP_SYSTEM = true;
                PVP_MAP = 230020101;
                SAVEBUFF = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.02;
                arrd[4] = 1800.0;
                MobDropPOINT = arrd;
                SPECIAL_ITEM = true;
                int[] arrn45 = new int[3];
                arrn45[0] = 1002256;
                arrn45[1] = 1052179;
                arrn45[2] = 1072153;
                CREAT_EQUIPS_MALE = arrn45;
                MAP_RANDOM_MOB = true;
                int[] arrn46 = new int[4];
                arrn46[0] = 100000000;
                arrn46[1] = 101000000;
                arrn46[2] = 102000000;
                arrn46[3] = 103000000;
                MAP_RANDOM_MAPID = arrn46;
                int[] arrn47 = new int[1];
                arrn47[0] = 9410066;
                MAP_RANDOM_MOBID = arrn47;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                FLY_CHAIR = true;
                DAMAGE_SYSTEM = true;
                MODIFY_ATTACKCOUNT = true;
                SERVER_ID = 19;
                EXPIRED = true;
                return;
            }
            case 19: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                FLY_CHAIR = true;
                MARRY_DROP_BONUS = 1.2;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                SAVEBUFF = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                CS_FACTORYOPEN = true;
                MODIFY_ATTACKCOUNT = true;
                DAMAGE_SYSTEM = true;
                PVP_SYSTEM = false;
                HOMOSEX = true;
                CHECK_ALLDAMAGE = false;
                DELAY_CHECK = false;
                CHECKDAMAGE_BAN = false;
                MAX_STAT = 2000;
                SERVER_ID = 20;
                EXPIRED = true;
                return;
            }
            case 20: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                HELL_CUSTOMIZE = true;
                HELLSYSTEM = true;
                int[] arrn = new int[1];
                arrn[0] = 3;
                HELLCHANNEL = arrn;
                double[] arrd = new double[6];
                arrd[0] = 1.0;
                arrd[1] = 3.0;
                arrd[2] = 1.0;
                arrd[3] = 2.0;
                arrd[4] = 1.0;
                arrd[5] = 1.0;
                HELL_RATE = arrd;
                VIPSYSTEM = true;
                VIPAUTOGIVE = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIPFROMMESO = true;
                LV120_VIPGIVE = true;
                VIP_DONATEINTERVAL = 2000;
                VIP_LEVELMAX = 10;
                String[] arrstring = new String[10];
                arrstring[0] = SharkLogger.ALLATORIxDEMO("\u2627\u6133\u61e8\u58af\u2627");
                arrstring[1] = MobSkillData.ALLATORIxDEMO("\u260b\u9728\u52d8\u58e3\u260b");
                arrstring[2] = SharkLogger.ALLATORIxDEMO("\u2627\u9764\u8f0b\u58af\u2627");
                arrstring[3] = MobSkillData.ALLATORIxDEMO("\u260b\u793e\u9b49\u58e3\u260b");
                arrstring[4] = SharkLogger.ALLATORIxDEMO("\u2627\u87a1\u5908\u58af\u2627");
                arrstring[5] = MobSkillData.ALLATORIxDEMO("\u260b\u5376\u5924\u58e3\u260b");
                arrstring[6] = SharkLogger.ALLATORIxDEMO("\u2627\u9036\u5908\u58af\u2627");
                arrstring[7] = MobSkillData.ALLATORIxDEMO("\u260b\u8193\u5c07\u58e3\u260b");
                arrstring[8] = SharkLogger.ALLATORIxDEMO("\u2627\u571c\u81d2\u5c26\u2627");
                arrstring[9] = MobSkillData.ALLATORIxDEMO("\u260b\u5949\u81fe\u5c6a\u260b");
                VIPNAME = arrstring;
                USE_VIPNAME = false;
                GAMBLING_SYSTEM = true;
                double[] arrd9 = new double[5];
                arrd9[0] = 1.0;
                arrd9[1] = 10.0;
                arrd9[2] = 2.0;
                arrd9[3] = 0.03;
                arrd9[4] = 1000.0;
                MobDropPOINT = arrd9;
                int[] arrn48 = new int[3];
                arrn48[0] = 5;
                arrn48[1] = 20;
                arrn48[2] = 60;
                ONLINEPOINT = arrn48;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 2;
                MODIFY_ATTACKCOUNT = true;
                DELAY_CHECK = false;
                SAVEBUFF = true;
                SERVER_ID = 21;
                EXPIRED = true;
                return;
            }
            case 21: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 20;
                arrn[1] = 40;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                WASH_HP_MAGICIAN_BAN = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                DUE_DATE = "2019-2-18";
                SERVER_ID = 22;
                EXPIRED = true;
                return;
            }
            case 22: {
                PVP_SYSTEM = true;
                PVP_CHANNEL = 10;
                GAMBLING_SYSTEM = true;
                AUTOBAN = false;
                COUNT_CHECK = false;
                MODIFY_ATTACKCOUNT = true;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 30;
                arrn[1] = 50;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 2000;
                VIP_LEVELMAX = 10;
                USE_VIPNAME = true;
                FLY_CHAIR = true;
                SERVER_ID = 23;
                EXPIRED = true;
                return;
            }
            case 23: {
                PVP_SYSTEM = true;
                PVP_CHANNEL = 5;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03;
                arrd[4] = 1200.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                HELL_CUSTOMIZE = true;
                HELLSYSTEM = true;
                int[] arrn49 = new int[1];
                arrn49[0] = 6;
                HELLCHANNEL = arrn49;
                double[] arrd10 = new double[6];
                arrd10[0] = 1.0;
                arrd10[1] = 2.0;
                arrd10[2] = 1.0;
                arrd10[3] = 3.0;
                arrd10[4] = 1.0;
                arrd10[5] = 1.5;
                HELL_RATE = arrd10;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 3000;
                VIP_LEVELMAX = 10;
                USE_VIPNAME = true;
                String[] arrstring = new String[10];
                arrstring[0] = SharkLogger.ALLATORIxDEMO("\u4e2c\u663e\u96f2\u2624");
                arrstring[1] = MobSkillData.ALLATORIxDEMO("\u4eec\u6612\u96be\u2608");
                arrstring[2] = SharkLogger.ALLATORIxDEMO("\u4e25\u663e\u96f2\u2624");
                arrstring[3] = MobSkillData.ALLATORIxDEMO("\u56bb\u6612\u96be\u2608");
                arrstring[4] = SharkLogger.ALLATORIxDEMO("\u4eb8\u663e\u96f2\u2624");
                arrstring[5] = MobSkillData.ALLATORIxDEMO("\u510d\u6612\u96be\u2608");
                arrstring[6] = SharkLogger.ALLATORIxDEMO("\u4e2f\u663e\u96f2\u2624");
                arrstring[7] = MobSkillData.ALLATORIxDEMO("\u510b\u6612\u96be\u2608");
                arrstring[8] = SharkLogger.ALLATORIxDEMO("\u4e71\u663e\u96f2\u2624");
                arrstring[9] = MobSkillData.ALLATORIxDEMO("\u9758\u7386\u96be\u2608");
                VIPNAME = arrstring;
                FLY_CHAIR = true;
                WASH_HP_MAGICIAN_BAN = true;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                int[] arrn50 = new int[3];
                arrn50[0] = 1;
                arrn50[1] = 5;
                arrn50[2] = 2;
                DojoPoints = arrn50;
                MAP_RANDOM_MOB = true;
                MAP_RANDOM_TIME = 2;
                int[] arrn51 = new int[5];
                arrn51[0] = 103000000;
                arrn51[1] = 100000000;
                arrn51[2] = 101000000;
                arrn51[3] = 102000000;
                arrn51[4] = 104000000;
                MAP_RANDOM_MAPID = arrn51;
                int[] arrn52 = new int[1];
                arrn52[0] = 9410066;
                MAP_RANDOM_MOBID = arrn52;
                IP_GEO_SYSTEM = true;
                SERVER_ID = 24;
                EXPIRED = true;
                return;
            }
            case 24: {
                PVP_SYSTEM = true;
                PVP_CHANNEL = 5;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 3000;
                VIP_LEVELMAX = 10;
                USE_VIPNAME = true;
                FLY_CHAIR = true;
                WASH_HP_MAGICIAN_BAN = true;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                int[] arrn53 = new int[3];
                arrn53[0] = 1;
                arrn53[1] = 5;
                arrn53[2] = 2;
                DojoPoints = arrn53;
                MODIFY_ATTACKCOUNT = true;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 20;
                SERVER_ID = 25;
                EXPIRED = true;
                return;
            }
            case 25: {
                MARRY_DROP_BONUS = 1.3;
                LOGIN_CHECK = false;
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAXLEVEL = 250;
                FLY_CHAIR = true;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 1500.0;
                MobDropPOINT = arrd;
                WASH_HP_LIMIT = 99999;
                DELAY_CHECK = false;
                COUNT_CHECK = false;
                ACCURATE_DMG_TO_MOB = false;
                int[] arrn = new int[1];
                arrn[0] = 1112127;
                CREAT_GIFTS = arrn;
                AUTO_CS_ITEM = true;
                SERVER_ID = 26;
                EXPIRED = true;
                return;
            }
            case 26: {
                LOGIN_CHECK = false;
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 2;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 1000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                GIVEALL_PETSKILL = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                CS_FACTORYOPEN = true;
                MAX_DAMAGE = 399999L;
                WASH_HP_LIMIT = 9999;
                SERVER_ID = 27;
                EXPIRED = true;
                return;
            }
            case 27: {
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 2;
                BOSS_HPRATE = 2.0;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                POINT_NAME = "\u751c\u751c";
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 30;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                BOSS_HPRATE = 1.5;
                MOB_HPRATE = 1.5;
                CS_FACTORYOPEN = true;
                WASH_HP_LIMIT = 99999;
                int[] arrn54 = new int[1];
                arrn54[0] = 910000000;
                FISH_MAP = arrn54;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                LOGIN_SIGNLOG = true;
                int[] arrn55 = new int[3];
                arrn55[0] = 1;
                arrn55[1] = 2;
                arrn55[2] = 2;
                DojoPoints = arrn55;
                FreeSlot = true;
                AUTO_CS_ITEM = true;
                BUYBACK_SYSTEM = true;
                MERCHANT_ID = "3063850";
                HASHKEY = "TI4DrhQzxZgsS09n";
                HASHIV = "BBkkWxGqMsawB2xY";
                ECPAY_SYSTEM = true;
                CHECK_COPYITEM_CLEAR = false;
                IP_CHANNEL_LIMIT = 20;
                SERVER_ID = 28;
                EXPIRED = true;
                return;
            }
            case 28: {
                MAPLE_VERSION = (short)118;
                SERVER_ID = 29;
                EXPIRED = true;
                return;
            }
            case 29: {
                MAPLE_VERSION = (short)113;
                CS_FACTORYOPEN = true;
                EXP_RATE = 6;
                DROP_RATE = 2;
                MESO_RATE = 2;
                MAX_DAMAGE = 999999L;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                HELL_CUSTOMIZE = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                int[] arrn56 = new int[3];
                arrn56[0] = 60;
                arrn56[1] = 60;
                arrn56[2] = 60;
                ONLINEPOINT = arrn56;
                FLY_CHAIR = true;
                LOGIN_SIGNLOG = true;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 19;
                SERVER_ID = 30;
                EXPIRED = true;
                return;
            }
            case 30: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAX_SLOT = true;
                MODIFY_ATTACKCOUNT = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 50.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                MAX_STAT = 2000;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 20;
                FLY_CHAIR = true;
                VIPSYSTEM = true;
                VIPAUTOGIVE = true;
                VIPEXP = true;
                VIPDROP = true;
                String[] arrstring = new String[20];
                arrstring[0] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001d\u2627");
                arrstring[1] = MobSkillData.ALLATORIxDEMO("\u2666[)]R\u260b");
                arrstring[2] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001f\u2627");
                arrstring[3] = MobSkillData.ALLATORIxDEMO("\u2666[)]T\u260b");
                arrstring[4] = SharkLogger.ALLATORIxDEMO("\u262aweq\u0019\u2627");
                arrstring[5] = MobSkillData.ALLATORIxDEMO("\u2666[)]V\u260b");
                arrstring[6] = SharkLogger.ALLATORIxDEMO("\u262aweq\u001b\u2627");
                arrstring[7] = MobSkillData.ALLATORIxDEMO("\u2666[)]X\u260b");
                arrstring[8] = SharkLogger.ALLATORIxDEMO("\u262aweq\u0015\u2627");
                arrstring[9] = MobSkillData.ALLATORIxDEMO("\u260b6D0<P\u260b");
                arrstring[10] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001d\u2627");
                arrstring[11] = MobSkillData.ALLATORIxDEMO("\u260b6D0<R\u260b");
                arrstring[12] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001f\u2627");
                arrstring[13] = MobSkillData.ALLATORIxDEMO("\u260b6D0<T\u260b");
                arrstring[14] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u0019\u2627");
                arrstring[15] = MobSkillData.ALLATORIxDEMO("\u260b6D0<V\u260b");
                arrstring[16] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u001b\u2627");
                arrstring[17] = MobSkillData.ALLATORIxDEMO("\u260b6D0<X\u260b");
                arrstring[18] = SharkLogger.ALLATORIxDEMO("\u2627zh|\u0010\u0015\u2627");
                arrstring[19] = MobSkillData.ALLATORIxDEMO("\u260b6D0?P\u260b");
                VIPNAME = arrstring;
                VIP_DONATEINTERVAL = 5000;
                BEBINNER_PARTY = true;
                POTENTIAL_SYSTEM = true;
                SERVER_ID = 31;
                CANUSE_4CASH = true;
                WASH_HP_LIMIT = 1999;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FreeSlot = true;
                int[] arrn57 = new int[1];
                arrn57[0] = 910000000;
                FISH_MAP = arrn57;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                SHOWEVENTMSG = true;
                MAX_SLOT = true;
                GIVEALL_PETSKILL = true;
                GMBUFF_LIMIT = false;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 5000;
                VIPEXP = true;
                VIP_LEVELMAX = 20;
                VIPPOINT = false;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                MOB_COUNT_RATE = 2.0;
                SELL_SYSTEM = true;
                LINEBOT = true;
                MERCHANT_ID = "3099994";
                HASHKEY = "P3SUOmfj2TNYKuYm";
                HASHIV = "iMGtVD49oDqLAgmR";
                ECPAY_PORT = 443;
                ECPAY_SYSTEM = true;
                LINEBOT_URL = "https://baddog.bobolinebot.tk";
                LINEBOT_MIN_DONATE = 500;
                BUYBACK_SYSTEM = true;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                int[] arrn58 = new int[3];
                arrn58[0] = 8248;
                arrn58[1] = 8249;
                arrn58[2] = 10619;
                QUEST_REMOVE = arrn58;
                AUTO_JOB = true;
                return;
            }
            case 31: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 15;
                DROP_RATE = 3;
                MESO_RATE = 2;
                AUTO_CS_ITEM = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 20000.0;
                MobDropPOINT = arrd;
                MAX_DAMAGE = 999999L;
                CHECKDAMAGE_BAN = false;
                CHECK_ALLDAMAGE = false;
                DELAY_CHECK = false;
                AUTO_UPDATE = false;
                SERVER_ID = 32;
                EXPIRED = true;
                return;
            }
            case 32: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                AUTO_CS_ITEM = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                MAX_DAMAGE = 999999L;
                CHECKDAMAGE_BAN = false;
                CHECK_ALLDAMAGE = false;
                DELAY_CHECK = false;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 100;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn59 = new int[1];
                arrn59[0] = 910000000;
                ONLINEPOINT_MAP = arrn59;
                int[] arrn60 = new int[1];
                arrn60[0] = 910000000;
                FISH_MAP = arrn60;
                PEE_SYSTEM = true;
                MAX_STAT = 9999;
                IP_GEO_SYSTEM = true;
                MOB_VAC_DETECT = false;
                BACCARAT_SYSTEM = true;
                MERCHANT_ID = "3017038";
                HASHKEY = "p4x2PRkk3FGaxKIR";
                HASHIV = "85A1bQSvmhu2rNCE";
                ECPAY_SYSTEM = true;
                VIPSYSTEM = true;
                VIPMONSTERPOINT = true;
                VIPAUTOGIVE = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_DONATEINTERVAL = 1000;
                VIP_LEVELMAX = 20;
                USE_VIPNAME = true;
                CHECK_COPYITEM_CLEAR = false;
                PHONE_PRIZE_LIMIT = true;
                SERVER_ID = 33;
                EXPIRED = true;
                return;
            }
            case 33: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 2;
                AUTO_CS_ITEM = true;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 5;
                DojoPoints = arrn;
                int[] arrn61 = new int[1];
                arrn61[0] = 910000000;
                FISH_MAP = arrn61;
                MAX_STAT = 1999;
                AUTO_UPDATE = false;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3082327";
                HASHKEY = "n2a8H9Ie60PTtlwU";
                HASHIV = "aCQdHF3aSfjdXo04";
                BOSS_HPRATE = 2.0;
                MOB_HPRATE = 2.0;
                SERVER_ID = 34;
                EXPIRED = true;
                return;
            }
            case 34: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 1;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 500;
                DOJO_POINT = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                int[] arrn62 = new int[3];
                arrn62[0] = 1;
                arrn62[1] = 5;
                arrn62[2] = 60;
                ONLINEPOINT = arrn62;
                BUYBACK_SYSTEM = true;
                PEE_SYSTEM = true;
                CRYPTOCURRENCY = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPEXP_INTERVAL = 0.1;
                VIPDROP_INTERVAL = 0.1;
                AUTO_CS_ITEM = true;
                int[] arrn63 = new int[10];
                arrn63[0] = 1000;
                arrn63[1] = 3000;
                arrn63[2] = 5000;
                arrn63[3] = 7000;
                arrn63[4] = 10000;
                arrn63[5] = 15000;
                arrn63[6] = 20000;
                arrn63[7] = 30000;
                arrn63[8] = 40000;
                arrn63[9] = 50000;
                VIP_DONATE_INTERVAL = arrn63;
                VIPAUTOGIVE = true;
                CHECK_COPYITEM_CLEAR = false;
                BUYBACK_SYSTEM = true;
                ONLINETIME = true;
                BACCARAT_SYSTEM = true;
                int[] arrn64 = new int[2];
                arrn64[0] = 20;
                arrn64[1] = 910000000;
                BACCARAT_LOCATION = arrn64;
                EVENT_COUNT = true;
                CREATE_EVAN = false;
                MERCHANT_ID = "3017038";
                HASHKEY = "p4x2PRkk3FGaxKIR";
                HASHIV = "85A1bQSvmhu2rNCE";
                ECPAY_SYSTEM = true;
                FORBID_JOB_OVERLEVEL = true;
                REINCARNATION_MOB = new int[0][];
                DOJO_POINT_PARTY_SEPERATE = false;
                DAMAGE_SYSTEM = true;
                EHCHANCE_LIMIT_LEVEL = false;
                CREATE_EVAN = true;
                PVP_ENTER = true;
                AUTO_CLEAN_DROPS = 999;
                EXP_CHAIR = true;
                FISH_KING = true;
                SERVER_ID = 35;
                EXPIRED = true;
                return;
            }
            case 35: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 5;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 3.0;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FreeSlot = true;
                int[] arrn65 = new int[1];
                arrn65[0] = 910000000;
                FISH_MAP = arrn65;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAX_STAT = 2000;
                SHOWEVENTMSG = false;
                MAX_SLOT = true;
                MAX_STAT = 2000;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                AUTO_CLEAN_DROPS = 500;
                DUE_DATE = "2019-11-14";
                DEFAULT_CHARSLOT = 15;
                SERVER_ID = 36;
                EXPIRED = true;
                return;
            }
            case 36: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                CS_FACTORYOPEN = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn66 = new int[4];
                arrn66[0] = 910000000;
                arrn66[1] = 749050500;
                arrn66[2] = 749050501;
                arrn66[3] = 749050502;
                ONLINEPOINT_MAP = arrn66;
                int[] arrn67 = new int[3];
                arrn67[0] = 1;
                arrn67[1] = 5;
                arrn67[2] = 2;
                DojoPoints = arrn67;
                DOJO_POINT_PARTY_SEPERATE = false;
                DOJO_POINT = true;
                PEE_SYSTEM = true;
                LOGIN_SIGNLOG = true;
                MAP_RANDOM_MOB = true;
                int[] arrn68 = new int[1];
                arrn68[0] = 100000000;
                MAP_RANDOM_MAPID = arrn68;
                int[] arrn69 = new int[1];
                arrn69[0] = 9410066;
                MAP_RANDOM_MOBID = arrn69;
                int[] arrn70 = new int[3];
                arrn70[0] = 2;
                arrn70[1] = 25;
                arrn70[2] = 25;
                EVENTMOB_POINTS = arrn70;
                FACTION_SYSTEM = true;
                SPECIAL_ITEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn71 = new int[2];
                arrn71[0] = 1;
                arrn71[1] = 300000678;
                BACCARAT_LOCATION = arrn71;
                NIUNIU_SYSTEM = true;
                int[] arrn72 = new int[2];
                arrn72[0] = 2;
                arrn72[1] = 300000678;
                NIUNIU_LOCATION = arrn72;
                BLACKJACK_SYSTEM = true;
                int[] arrn73 = new int[2];
                arrn73[0] = 3;
                arrn73[1] = 300000678;
                BLACKJACK_LOCATION = arrn73;
                PVP_SYSTEM = true;
                PVP_MAP = 990001115;
                PVP_CHANNEL = 3;
                DAMAGE_SYSTEM = true;
                FLY_CHAIR = true;
                DELAY_CHECK = false;
                CHECKDAMAGE_BAN = false;
                MARRY_DROP_BONUS = 1.1;
                MARRY_EXP_BONUS = 1.1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 2500.0;
                MobDropPOINT = arrd;
                CRYPTOCURRENCY = true;
                MODIFY_ATTACKCOUNT = true;
                int[] arrn74 = new int[3];
                arrn74[0] = 8248;
                arrn74[1] = 8249;
                arrn74[2] = 10619;
                QUEST_REMOVE = arrn74;
                EVENTMOB_REWARD = false;
                int[][] arrarrn = new int[1][];
                int[] arrn75 = new int[2];
                arrn75[0] = 9800130;
                arrn75[1] = 2;
                arrarrn[0] = arrn75;
                REINCARNATION_MOB = arrarrn;
                MAX_STAT = 1500;
                ACCURATE_DMG_TO_MOB = true;
                VONLEONMAP_PARTYEXPBONUS = true;
                AUTOMONITOR = true;
                LOG_ACCPWD = false;
                FORCECHANGEPWD = true;
                IP_GEO_SYSTEM = true;
                MONSTERPET = true;
                BUYBACK_SYSTEM = true;
                IP_CHANNEL_LIMIT = 999999;
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                AUTO_CS_ITEM = true;
                int[] arrn76 = new int[1];
                arrn76[0] = 910000000;
                FISH_MAP = arrn76;
                CHANGE_CHANNEL_CHECK = false;
                SERVER_ID = 37;
                NEW_ITEM_SAVE = true;
                POTENTIAL_SYSTEM = true;
                CHECK_COPYITEM_CLEAR = false;
                LINEBOT = true;
                MERCHANT_ID = "3080023";
                HASHKEY = "hGJ6RmXHItpfa0AX";
                HASHIV = "UZvvKTHD9EZplOm7";
                ECPAY_PORT = 443;
                ECPAY_SYSTEM = true;
                LINEBOT_URL = "https://happyms.bobolinebot.tk";
                EXPIRED = true;
                return;
            }
            case 37: {
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                HOMOSEX = true;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 20;
                MAX_SLOT = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                MODIFY_ATTACKCOUNT = true;
                COUNT_CHECK = false;
                CS_FACTORYOPEN = true;
                MAX_STAT = 1999;
                SERVER_ID = 38;
                EXPIRED = true;
                return;
            }
            case 38: {
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 3.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03333333333333333;
                arrd[4] = 200.0;
                MobDropPOINT = arrd;
                SERVER_ID = 39;
                return;
            }
            case 39: {
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                EXP_RATE = 7;
                DROP_RATE = 1;
                MESO_RATE = 1;
                int[] arrn = new int[3];
                arrn[0] = 100;
                arrn[1] = 100;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                MARRY_EXP_BONUS = 1.2;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 2;
                CS_FACTORYOPEN = true;
                SERVER_ID = 40;
                EXPIRED = true;
                return;
            }
            case 40: {
                int[] arrn = new int[3];
                arrn[0] = 30;
                arrn[1] = 30;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 2;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                int[] arrn77 = new int[4];
                arrn77[0] = 30;
                arrn77[1] = 30;
                arrn77[2] = 2;
                arrn77[3] = 60;
                ONLINEPOINT = arrn77;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 2;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                MAP_RANDOM_MOB = true;
                int[] arrn78 = new int[1];
                arrn78[0] = 910000000;
                MAP_RANDOM_MAPID = arrn78;
                int[] arrn79 = new int[1];
                arrn79[0] = 9410066;
                MAP_RANDOM_MOBID = arrn79;
                MAP_RANDOM_TIME = 6;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                DUE_DATE = "2019-04-22";
                MAX_SLOT = true;
                SERVER_ID = 41;
                EXPIRED = true;
                return;
            }
            case 41: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                MAX_DAMAGE = 1000000L;
                WASH_HP_LIMIT = 1000;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                GIVEALL_PETSKILL = true;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                WASH_HP_MAGICIAN_BAN = true;
                MAX_STAT = 99999;
                CS_FACTORYOPEN = true;
                FreeSlot = true;
                int[] arrn80 = new int[1];
                arrn80[0] = 910000000;
                FISH_MAP = arrn80;
                DUE_DATE = "2019-02-24";
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 19;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 1.0;
                arrd[3] = 0.05;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                SERVER_ID = 42;
                EXPIRED = true;
                return;
            }
            case 42: 
            case 43: {
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                ATTACKRANGE_CHECK = false;
                CS_FACTORYOPEN = true;
                DEFAULT_CHARSLOT = 15;
                DELAY_CHECK = false;
                MAX_SLOT = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                MAX_STAT = 1999;
                PEE_SYSTEM = true;
                PEETOPOO = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3102783";
                HASHKEY = "XLjw2acA3ae3t5cB";
                HASHIV = "loPusJuEDlNEe3eA";
                SERVER_ID = 43;
                EXPIRED = true;
                return;
            }
            case 44: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 2;
                BOSS_HPRATE = 3.0;
                MOB_HPRATE = 2.0;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.068;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                UPGRADESLOT_CHECK = false;
                int[] arrn = new int[3];
                arrn[0] = 20;
                arrn[1] = 45;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                CS_FACTORYOPEN = true;
                DUE_DATE = "2019-11-14";
                MERCHANT_ID = "3010553";
                HASHKEY = "OMHuzLvXIKn8eo5L";
                HASHIV = "5b1lkJ7eTX013lFZ";
                ECPAY_SYSTEM = true;
                MAX_STAT = 9999;
                MAX_SLOT = true;
                CHECK_SKILLJOB = false;
                SERVER_ID = 45;
                EXPIRED = true;
                return;
            }
            case 45: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 3.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                LOGIN_SIGNLOG = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                WASH_HP_MAGICIAN_BAN = true;
                HOMOSEX = true;
                CS_FACTORYOPEN = true;
                int[] arrn81 = new int[3];
                arrn81[0] = 35;
                arrn81[1] = 60;
                arrn81[2] = 60;
                ONLINEPOINT = arrn81;
                int[] arrn82 = new int[1];
                arrn82[0] = 910000000;
                FISH_MAP = arrn82;
                DUE_DATE = "2019-09-03";
                FLY_CHAIR = true;
                DAMAGE_SYSTEM = true;
                MAX_STAT = 9999;
                int[][] arrarrn = new int[1][];
                int[] arrn83 = new int[2];
                arrn83[0] = 9700033;
                arrn83[1] = 2;
                arrarrn[0] = arrn83;
                REINCARNATION_MOB = arrarrn;
                DELAY_CHECK = false;
                SERVER_ID = 46;
                EXPIRED = true;
                return;
            }
            case 46: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 5;
                DROP_RATE = 2;
                MESO_RATE = 1;
                BOSS_HPRATE = 1.5;
                MAX_SLOT = true;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                LOGIN_SIGNLOG = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 230;
                WASH_HP_MAGICIAN_BAN = true;
                HOMOSEX = true;
                CS_FACTORYOPEN = true;
                int[] arrn = new int[3];
                arrn[0] = 40;
                arrn[1] = 65;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn84 = new int[1];
                arrn84[0] = 910000000;
                FISH_MAP = arrn84;
                DUE_DATE = "2019-10-22";
                FLY_CHAIR = true;
                DAMAGE_SYSTEM = true;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                MAX_STAT = 9999;
                int[][] arrarrn = new int[1][];
                int[] arrn85 = new int[2];
                arrn85[0] = 9800130;
                arrn85[1] = 2;
                arrarrn[0] = arrn85;
                REINCARNATION_MOB = arrarrn;
                DELAY_CHECK = false;
                SERVER_ID = 47;
                EXPIRED = true;
                return;
            }
            case 47: 
            case 48: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAXLEVEL = 225;
                MAXLEVEL_KOC = 225;
                HOMOSEX = true;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                DOJO_POINT = false;
                int[] arrn86 = new int[1];
                arrn86[0] = 910000000;
                FISH_MAP = arrn86;
                DUE_DATE = "2020-02-27";
                FM_DROP = true;
                SEPECIAL_PARTY_EXP = true;
                LOGIN_CHECK = false;
                USE_CRYPT_KEY = true;
                SERVER_ID = 48;
                EXPIRED = true;
                return;
            }
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 2;
                CREATE_KOC = false;
                MAXLEVEL = 250;
                MAX_DAMAGE = Integer.MAX_VALUE;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                ONLINETIME = true;
                HOMOSEX = true;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 2.0;
                arrd[1] = 10.0;
                arrd[2] = 1.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                int[] arrn87 = new int[3];
                arrn87[0] = 1;
                arrn87[1] = 10;
                arrn87[2] = 60;
                ONLINEPOINT = arrn87;
                CHECK_EQUIPLVL = false;
                ACCURATE_DMG_TO_MOB = false;
                CHECKDAMAGE_BAN = false;
                COUNT_CHECK = false;
                LEVEL_MSG = false;
                CHECK_SKILLJOB = false;
                CHECK_COPYITEM = false;
                checkCopyItem = false;
                DUE_DATE = "2020-04-27";
                SERVER_ID = 49;
                EXPIRED = true;
                return;
            }
            case 56: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 2;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_DAMAGE = 500000L;
                int[] arrn = new int[3];
                arrn[0] = 20;
                arrn[1] = 50;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                VIPSYSTEM = true;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 20;
                int[] arrn88 = new int[1];
                arrn88[0] = 910000000;
                FISH_MAP = arrn88;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 10.0;
                arrd[1] = 50.0;
                arrd[2] = 1.0;
                arrd[3] = 0.1;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                DUE_DATE = "2020-04-23";
                SERVER_ID = 50;
                EXPIRED = true;
                return;
            }
            case 57: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                BOSS_HPRATE = 1.0;
                MAXLEVEL_KOC = 200;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                MERCHANT_ID = "3063850";
                HASHKEY = "TI4DrhQzxZgsS09n";
                HASHIV = "BBkkWxGqMsawB2xY";
                ECPAY_SYSTEM = true;
                CS_FACTORYOPEN = true;
                SERVER_ID = 51;
                EXPIRED = true;
                return;
            }
            case 58: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 1;
                DROP_RATE = 2;
                MESO_RATE = 1;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                CS_FACTORYOPEN = true;
                MAX_STAT = 1500;
                MERCHANT_ID = "3080023";
                HASHKEY = "hGJ6RmXHItpfa0AX";
                HASHIV = "UZvvKTHD9EZplOm7";
                ECPAY_SYSTEM = true;
                SERVER_ID = 52;
                EXPIRED = true;
                return;
            }
            case 59: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 3000;
                VIP_LEVELMAX = 10;
                MODIFY_ATTACKCOUNT = true;
                MERCHANT_ID = "3074993";
                HASHKEY = "ysLVDILt1DpGHJTT";
                HASHIV = "53wHSO17DdT70TDu";
                ECPAY_SYSTEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn = new int[2];
                arrn[0] = 1;
                arrn[1] = 209080100;
                BACCARAT_LOCATION = arrn;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                MAX_STAT = 1500;
                SERVER_ID = 53;
                EXPIRED = true;
                return;
            }
            case 60: 
            case 61: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn89 = new int[1];
                arrn89[0] = 910000000;
                ONLINEPOINT_MAP = arrn89;
                FLY_CHAIR = true;
                GAMBLING_SYSTEM = true;
                CHECK_ALLDAMAGE = false;
                DELAY_CHECK = false;
                CHECKDAMAGE_BAN = false;
                MERCHANT_ID = "3120721";
                HASHKEY = "KkcJaWSkRpz6F1hw";
                HASHIV = "wXCkhTueCIMdxCWj";
                ECPAY_SYSTEM = true;
                SERVER_ID = 54;
                EXPIRED = true;
                return;
            }
            case 62: {
                int[] arrn = new int[3];
                arrn[0] = 30;
                arrn[1] = 30;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn90 = new int[3];
                arrn90[0] = 25;
                arrn90[1] = 25;
                arrn90[2] = 60;
                ONLINEPOINT = arrn90;
                FLY_CHAIR = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                MAX_SLOT = true;
                MERCHANT_ID = "3050153";
                HASHKEY = "x5ko1Lkxpec2oJSS";
                HASHIV = "1hLUeYxkwoMwClud";
                ECPAY_SYSTEM = true;
                SERVER_ID = 55;
                EXPIRED = true;
                return;
            }
            case 63: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 2;
                WASH_HP_LIMIT = 99999;
                WASH_HP_MAGICIAN_BAN = true;
                MAX_STAT = 1300;
                HOMOSEX = true;
                MAX_SLOT = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                DUE_DATE = "2020-04-29";
                int[] arrn91 = new int[3];
                arrn91[0] = 20;
                arrn91[1] = 60;
                arrn91[2] = 60;
                ONLINEPOINT = arrn91;
                AUTO_CS_ITEM = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                MERCHANT_ID = "3123627";
                HASHKEY = "25n5lmMNkqL9xNVL";
                HASHIV = "HddHLME0QZUhbRwi";
                ECPAY_SYSTEM = true;
                UNLIMITMPTOHP = true;
                BACCARAT_SYSTEM = true;
                int[] arrn92 = new int[2];
                arrn92[0] = 19;
                arrn92[1] = 910000019;
                BACCARAT_LOCATION = arrn92;
                SERVER_ID = 56;
                EXPIRED = true;
                return;
            }
            case 64: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                MAX_STAT = 2000;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn93 = new int[2];
                arrn93[0] = 910000000;
                arrn93[1] = 749050502;
                ONLINEPOINT_MAP = arrn93;
                PEE_CHAIR = 3015027;
                MERCHANT_ID = "3074187";
                HASHKEY = "9bOjTGuo8THgcbGR";
                HASHIV = "0gV1GfTaYF2t62ad";
                ECPAY_SYSTEM = true;
                double[] arrd = new double[5];
                arrd[0] = 10.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[][] arrarrn = new int[1][];
                int[] arrn94 = new int[2];
                arrn94[0] = 9800130;
                arrn94[1] = 2;
                arrarrn[0] = arrn94;
                REINCARNATION_MOB = arrarrn;
                int[] arrn95 = new int[3];
                arrn95[0] = 1;
                arrn95[1] = 5;
                arrn95[2] = 2;
                DojoPoints = arrn95;
                CHECK_COPYITEM = false;
                SERVER_ID = 57;
                EXPIRED = true;
                return;
            }
            case 65: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 1;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                MAX_STAT = 2000;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                MERCHANT_ID = "3121725";
                HASHKEY = "vBD8wWejrzJcgrJP";
                HASHIV = "RRXiLg3rh9KCROcB";
                ECPAY_SYSTEM = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.02;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                DELAY_CHECK = false;
                int[] arrn96 = new int[3];
                arrn96[0] = 0;
                arrn96[1] = 0;
                arrn96[2] = 1;
                DojoPoints = arrn96;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                MAX_DAMAGE = 999999L;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 18;
                CHECK_COPYITEM_CLEAR = false;
                SERVER_ID = 58;
                EXPIRED = true;
                return;
            }
            case 66: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 2;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 3000;
                VIP_LEVELMAX = 10;
                MODIFY_ATTACKCOUNT = true;
                MERCHANT_ID = "3074993";
                HASHKEY = "ysLVDILt1DpGHJTT";
                HASHIV = "53wHSO17DdT70TDu";
                ECPAY_SYSTEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn = new int[2];
                arrn[0] = 1;
                arrn[1] = 209080100;
                BACCARAT_LOCATION = arrn;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                MAX_STAT = 1500;
                BURN_LEVELUP = true;
                int[] arrn97 = new int[2];
                arrn97[0] = 10;
                arrn97[1] = 110;
                BURN_LEVELLIMIT = arrn97;
                SERVER_ID = 59;
                EXPIRED = true;
                return;
            }
            case 67: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                CS_FACTORYOPEN = true;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 30;
                ONLINEPOINT = arrn;
                int[] arrn98 = new int[1];
                arrn98[0] = 910000000;
                ONLINEPOINT_MAP = arrn98;
                int[] arrn99 = new int[3];
                arrn99[0] = 1;
                arrn99[1] = 2;
                arrn99[2] = 2;
                DojoPoints = arrn99;
                PEE_SYSTEM = true;
                LOGIN_SIGNLOG = true;
                FACTION_SYSTEM = true;
                SPECIAL_ITEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn100 = new int[2];
                arrn100[0] = 8;
                arrn100[1] = 910000000;
                BACCARAT_LOCATION = arrn100;
                DAMAGE_SYSTEM = true;
                FLY_CHAIR = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3087693";
                HASHKEY = "RSsT3RQ8vr0hmer7";
                HASHIV = "9ICz9mU90i2SbPci";
                DELAY_CHECK = false;
                CHECKDAMAGE_BAN = false;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                CRYPTOCURRENCY = true;
                MODIFY_ATTACKCOUNT = true;
                int[] arrn101 = new int[3];
                arrn101[0] = 8248;
                arrn101[1] = 8249;
                arrn101[2] = 10619;
                QUEST_REMOVE = arrn101;
                EVENTMOB_REWARD = false;
                int[][] arrarrn = new int[1][];
                int[] arrn102 = new int[2];
                arrn102[0] = 9800130;
                arrn102[1] = 2;
                arrarrn[0] = arrn102;
                REINCARNATION_MOB = arrarrn;
                MAX_STAT = 1500;
                ACCURATE_DMG_TO_MOB = true;
                VONLEONMAP_PARTYEXPBONUS = true;
                AUTOMONITOR = true;
                ENABLE_OTP = true;
                LOG_ACCPWD = false;
                FORCECHANGEPWD = true;
                CHECK_COPYITEM = false;
                IP_GEO_SYSTEM = true;
                MONSTERPET = true;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                SERVER_ID = 60;
                EXPIRED = true;
                return;
            }
            case 68: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                MERCHANT_ID = "3063850";
                HASHKEY = "TI4DrhQzxZgsS09n";
                HASHIV = "BBkkWxGqMsawB2xY";
                ECPAY_SYSTEM = true;
                int[] arrn = new int[2];
                arrn[0] = 0;
                arrn[1] = 2;
                GASHAPON_RANDOM_SCROLL = arrn;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                SERVER_ID = 61;
                EXPIRED = true;
                return;
            }
            case 69: {
                MAPLE_VERSION = (short)113;
                SERVER_ID = 62;
                EXPIRED = true;
                return;
            }
            case 70: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.01;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                MERCHANT_ID = "3069908";
                HASHKEY = "shhzuSBMXUpaQhJa";
                HASHIV = "90Z37ngEaaYpRio6";
                ECPAY_SYSTEM = true;
                int[] arrn103 = new int[1];
                arrn103[0] = 910000000;
                FISH_MAP = arrn103;
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 15;
                MAP_RANDOM_MOB = true;
                MAP_RANDOM_TIME = 4;
                int[] arrn104 = new int[1];
                arrn104[0] = 100000000;
                MAP_RANDOM_MAPID = arrn104;
                int[] arrn105 = new int[1];
                arrn105[0] = 9410066;
                MAP_RANDOM_MOBID = arrn105;
                BACCARAT_SYSTEM = true;
                int[] arrn106 = new int[2];
                arrn106[0] = 1;
                arrn106[1] = 910000000;
                BACCARAT_LOCATION = arrn106;
                MAX_STAT = 1500;
                int[] arrn107 = new int[3];
                arrn107[0] = 300;
                arrn107[1] = 300;
                arrn107[2] = 1;
                DojoPoints = arrn107;
                DojoPoints_AllPass = true;
                SERVER_ID = 63;
                EXPIRED = true;
                return;
            }
            case 71: {
                MAPLE_VERSION = (short)113;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                MAX_STAT = 2000;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[] arrn108 = new int[3];
                arrn108[0] = 15;
                arrn108[1] = 15;
                arrn108[2] = 60;
                ONLINEPOINT = arrn108;
                int[] arrn109 = new int[4];
                arrn109[0] = 1003392;
                arrn109[1] = 0x100F01;
                arrn109[2] = 1072426;
                arrn109[3] = 1102210;
                CREAT_EQUIPS_MALE = arrn109;
                int[] arrn110 = new int[4];
                arrn110[0] = 1003392;
                arrn110[1] = 0x100F01;
                arrn110[2] = 1072426;
                arrn110[3] = 1102210;
                CREAT_EQUIPS_FEMALE = arrn110;
                BACCARAT_SYSTEM = true;
                int[] arrn111 = new int[2];
                arrn111[0] = 20;
                arrn111[1] = 910000000;
                BACCARAT_LOCATION = arrn111;
                PEE_CHAIR = 3015027;
                MERCHANT_ID = "3074187";
                HASHKEY = "9bOjTGuo8THgcbGR";
                HASHIV = "0gV1GfTaYF2t62ad";
                ECPAY_SYSTEM = true;
                double[] arrd = new double[5];
                arrd[0] = 10.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[][] arrarrn = new int[1][];
                int[] arrn112 = new int[2];
                arrn112[0] = 9700033;
                arrn112[1] = 2;
                arrarrn[0] = arrn112;
                REINCARNATION_MOB = arrarrn;
                int[] arrn113 = new int[3];
                arrn113[0] = 5;
                arrn113[1] = 8;
                arrn113[2] = 2;
                DojoPoints = arrn113;
                CHECK_COPYITEM = true;
                IP_CHANNEL_LIMIT = 10;
                MOUNT_UNLIMIT = true;
                DCLOAD_LOGIN_SAVING = false;
                PEE_CHAIR = 3010865;
                SERVER_ID = 64;
                NEW_ITEM_SAVE = true;
                EXPIRED = true;
                return;
            }
            case 72: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 0.5;
                BOSS_HPRATE = 1.5;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 99999;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 10.0;
                arrd[1] = 50.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 15;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn114 = new int[1];
                arrn114[0] = 910000000;
                FISH_MAP = arrn114;
                int[][] arrarrn = new int[1][];
                int[] arrn115 = new int[2];
                arrn115[0] = 9800130;
                arrn115[1] = 2;
                arrarrn[0] = arrn115;
                REINCARNATION_MOB = arrarrn;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3078929";
                HASHKEY = "Fs2Te91rkREZh4AO";
                HASHIV = "gdSOyGdj44sbU31m";
                DUE_DATE = "2019-08-01";
                GAMBLING_SYSTEM = true;
                GAMBLING_CHANNEL = 1;
                SERVER_ID = 65;
                EXPIRED = true;
                return;
            }
            case 73: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 99999;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 3.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                CS_FACTORYOPEN = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3052221";
                HASHKEY = "L4CJn7XgxU76ZG8s";
                HASHIV = "EPwjupWMKQbR82jL";
                DUE_DATE = "2019-08-03";
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 10000;
                VIP_LEVELMAX = 10;
                USE_VIPNAME = true;
                SERVER_ID = 66;
                EXPIRED = true;
                return;
            }
            case 74: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 13;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 3.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 999999;
                UNLIMITMPTOHP = false;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 1;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn116 = new int[4];
                arrn116[0] = 1;
                arrn116[1] = 20;
                arrn116[2] = 2;
                arrn116[3] = 60;
                ONLINEPOINT = arrn116;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn117 = new int[1];
                arrn117[0] = 910000000;
                FISH_MAP = arrn117;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 999;
                GIVEALL_PETSKILL = true;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                SAVEBUFF = true;
                PEE_SYSTEM = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                MOB_COUNT_RATE = 2.0;
                int[] arrn118 = new int[3];
                arrn118[0] = 3;
                arrn118[1] = 3;
                arrn118[2] = 2;
                DojoPoints = arrn118;
                LOGIN_SIGNLOG = true;
                BACCARAT_SYSTEM = true;
                int[] arrn119 = new int[2];
                arrn119[0] = 20;
                arrn119[1] = 910000000;
                BACCARAT_LOCATION = arrn119;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                FAMILY_SYSTEM = false;
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                CHANGE_CHANNEL_CHECK = false;
                EXP_CHAIR = true;
                MARRY_DROP_BONUS = 1.3;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                MAX_STAT = 1999;
                SERVER_ID = 67;
                NEW_ITEM_SAVE = true;
                EXPIRED = true;
                return;
            }
            case 75: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CS_FACTORYOPEN = true;
                int[] arrn = new int[4];
                arrn[0] = 1;
                arrn[1] = 1;
                arrn[2] = 2;
                arrn[3] = 60;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                SELL_PRICE = 0.8;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                ECPAY_IP = "202.153.5.194";
                MERCHANT_ID = "3080023";
                HASHKEY = "hGJ6RmXHItpfa0AX";
                HASHIV = "UZvvKTHD9EZplOm7";
                FAMILY_SYSTEM = false;
                MAPOWNER_SYSTEM = false;
                int[] arrn120 = new int[3];
                arrn120[0] = 1;
                arrn120[1] = 1;
                arrn120[2] = 2;
                DojoPoints = arrn120;
                DOJO_POINT_PARTY_SEPERATE = false;
                DOJO_POINT = true;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                SERVER_ID = 68;
                EXPIRED = true;
                return;
            }
            case 76: 
            case 77: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 220;
                MAX_STAT = 1999;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 9.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[4];
                arrn[0] = 8;
                arrn[1] = 8;
                arrn[2] = 1;
                arrn[3] = 30;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MAP_RANDOM_MOB = true;
                MAP_RANDOM_TIME = 3;
                int[] arrn121 = new int[1];
                arrn121[0] = 100000000;
                MAP_RANDOM_MAPID = arrn121;
                int[] arrn122 = new int[1];
                arrn122[0] = 8180000;
                MAP_RANDOM_MOBID = arrn122;
                MARRY_DROP_BONUS = 1.1;
                MARRY_EXP_BONUS = 1.1;
                DUE_DATE = "2020-02-19";
                DOJO_POINT_PARTY_SEPERATE = true;
                GMBUFF_LIMIT = false;
                CHECK_COPYITEM_CLEAR = false;
                DCLOAD_LOGIN_SAVING = false;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                AUTO_CS_ITEM = true;
                SERVER_ID = 69;
                EXPIRED = true;
                return;
            }
            case 78: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAX_DAMAGE = 999999L;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 220;
                MAX_STAT = 1999;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 9.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[4];
                arrn[0] = 8;
                arrn[1] = 8;
                arrn[2] = 1;
                arrn[3] = 30;
                ONLINEPOINT = arrn;
                FLY_CHAIR = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MARRY_DROP_BONUS = 1.1;
                MARRY_EXP_BONUS = 1.1;
                DUE_DATE = "2020-02-08";
                DOJO_POINT_PARTY_SEPERATE = true;
                GMBUFF_LIMIT = false;
                CHECK_COPYITEM_CLEAR = false;
                DCLOAD_LOGIN_SAVING = false;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3169233";
                HASHKEY = "saZXaH5HuHPkG6OZ";
                HASHIV = "WY8F32QPAzpPsFTt";
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                AUTO_CS_ITEM = true;
                EXPIRED = true;
                return;
            }
            case 79: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                int[] arrn = new int[4];
                arrn[0] = 1;
                arrn[1] = 3;
                arrn[2] = 1;
                arrn[3] = 5;
                ONLINEPOINT = arrn;
                int[] arrn123 = new int[1];
                arrn123[0] = 910000000;
                ONLINEPOINT_MAP = arrn123;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 6.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 1200.0;
                MobDropPOINT = arrd;
                MobDropPOINT_LEVEL = true;
                int[] arrn124 = new int[1];
                arrn124[0] = 910000000;
                FISH_MAP = arrn124;
                CS_FACTORYOPEN = true;
                AUTO_CS_ITEM = true;
                SERVER_ID = 70;
                EXPIRED = true;
                return;
            }
            case 80: {
                MAPLE_VERSION = (short)142;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                return;
            }
            case 81: {
                MAPLE_VERSION = (short)143;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                return;
            }
            case 82: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                LOGIN_CHECK = false;
                ENTERCS_CHECK = false;
                return;
            }
            case 83: {
                MAPLE_VERSION = (short)134;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                return;
            }
            case 84: {
                MAPLE_VERSION = (short)136;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                return;
            }
            case 85: {
                MAPLE_VERSION = (short)145;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                return;
            }
            case 86: {
                MAPLE_VERSION = (short)146;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                return;
            }
            case 87: {
                MAPLE_VERSION = (short)147;
                MAPLE_PATCH = "4";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CHOOSE_JOB = true;
                return;
            }
            case 88: {
                MAPLE_VERSION = (short)149;
                MAPLE_PATCH = "1";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CHOOSE_JOB = true;
                return;
            }
            case 89: 
            case 90: {
                MAPLE_VERSION = (short)149;
                MAPLE_PATCH = "2";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                NIUNIU_SYSTEM = true;
                int[] arrn = new int[2];
                arrn[0] = 2;
                arrn[1] = 910000000;
                NIUNIU_LOCATION = arrn;
                CHOOSE_JOB = true;
                BUYBACK_SYSTEM = true;
                return;
            }
            case 91: {
                MAPLE_VERSION = (short)151;
                MAPLE_PATCH = "2";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CHOOSE_JOB = true;
                return;
            }
            case 92: {
                MAPLE_VERSION = (short)152;
                MAPLE_PATCH = "3";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CHOOSE_JOB = true;
                return;
            }
            case 93: {
                MAPLE_VERSION = (short)153;
                MAPLE_PATCH = "1";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CHOOSE_JOB = true;
                BUYBACK_SYSTEM = true;
                int[][] arrarrn = new int[10][];
                int[] arrn = new int[2];
                arrn[0] = 9900030;
                arrn[1] = 1;
                arrarrn[0] = arrn;
                int[] arrn125 = new int[2];
                arrn125[0] = 9900031;
                arrn125[1] = 1;
                arrarrn[1] = arrn125;
                int[] arrn126 = new int[2];
                arrn126[0] = 9900032;
                arrn126[1] = 1;
                arrarrn[2] = arrn126;
                int[] arrn127 = new int[2];
                arrn127[0] = 9900033;
                arrn127[1] = 2;
                arrarrn[3] = arrn127;
                int[] arrn128 = new int[2];
                arrn128[0] = 9900034;
                arrn128[1] = 2;
                arrarrn[4] = arrn128;
                int[] arrn129 = new int[2];
                arrn129[0] = 9900035;
                arrn129[1] = 2;
                arrarrn[5] = arrn129;
                int[] arrn130 = new int[2];
                arrn130[0] = 9900036;
                arrn130[1] = 2;
                arrarrn[6] = arrn130;
                int[] arrn131 = new int[2];
                arrn131[0] = 9900037;
                arrn131[1] = 5;
                arrarrn[7] = arrn131;
                int[] arrn132 = new int[2];
                arrn132[0] = 9900038;
                arrn132[1] = 5;
                arrarrn[8] = arrn132;
                int[] arrn133 = new int[2];
                arrn133[0] = 9900039;
                arrn133[1] = 5;
                arrarrn[9] = arrn133;
                REINCARNATION_MOB = arrarrn;
                LEGEND_CHANCE = 10000;
                return;
            }
            case 94: {
                MAPLE_VERSION = (short)153;
                MAPLE_PATCH = "1";
                DROP_RATE = 1;
                MESO_RATE = 1;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[1];
                arrn[0] = 0x11BB21;
                PETVAC_EQUIP = arrn;
                int[][] arrarrn = new int[10][];
                int[] arrn134 = new int[2];
                arrn134[0] = 9900030;
                arrn134[1] = 1;
                arrarrn[0] = arrn134;
                int[] arrn135 = new int[2];
                arrn135[0] = 9900031;
                arrn135[1] = 1;
                arrarrn[1] = arrn135;
                int[] arrn136 = new int[2];
                arrn136[0] = 9900032;
                arrn136[1] = 1;
                arrarrn[2] = arrn136;
                int[] arrn137 = new int[2];
                arrn137[0] = 9900033;
                arrn137[1] = 2;
                arrarrn[3] = arrn137;
                int[] arrn138 = new int[2];
                arrn138[0] = 9900034;
                arrn138[1] = 2;
                arrarrn[4] = arrn138;
                int[] arrn139 = new int[2];
                arrn139[0] = 9900035;
                arrn139[1] = 2;
                arrarrn[5] = arrn139;
                int[] arrn140 = new int[2];
                arrn140[0] = 9900036;
                arrn140[1] = 2;
                arrarrn[6] = arrn140;
                int[] arrn141 = new int[2];
                arrn141[0] = 9900037;
                arrn141[1] = 5;
                arrarrn[7] = arrn141;
                int[] arrn142 = new int[2];
                arrn142[0] = 9900038;
                arrn142[1] = 5;
                arrarrn[8] = arrn142;
                int[] arrn143 = new int[2];
                arrn143[0] = 9900039;
                arrn143[1] = 5;
                arrarrn[9] = arrn143;
                REINCARNATION_MOB = arrarrn;
                MERCHANT_ID = "3076868";
                HASHKEY = "4g7f7opPmuPYbVsb";
                HASHIV = "S95ipG3vQ2knE8iL";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LEGEND_CHANCE = 500;
                SUPRISE_CHANCE = 250;
                CS_FACTORYOPEN = true;
                CANUSE_4CASH = true;
                LINEBOT_URL = "https://play.bobolinebot.tk";
                LINEBOT = true;
                SHUTDOWN_PROTECT = false;
                MAX_STAT = 19999;
                CHOOSE_JOB = true;
                REINCARNATION_SKILL_MOB = 9900034;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1202193;
                int[] arrn144 = new int[1];
                arrn144[0] = 80001129;
                REINCARNATION_SKILL = arrn144;
                SELL_SYSTEM = true;
                HELLSYSTEM = true;
                int[] arrn145 = new int[4];
                arrn145[0] = 7;
                arrn145[1] = 8;
                arrn145[2] = 9;
                arrn145[3] = 10;
                HELLCHANNEL = arrn145;
                HELL_CUSTOMIZE = true;
                double[] arrd11 = new double[6];
                arrd11[0] = 1.0;
                arrd11[1] = 1.0;
                arrd11[2] = 10.0;
                arrd11[3] = 3.0;
                arrd11[4] = 3.0;
                arrd11[5] = 1.5;
                HELL_RATE = arrd11;
                return;
            }
            case 95: {
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAPLE_VERSION = (short)149;
                MAPLE_PATCH = "2";
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 2.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 3499999L;
                WASH_HP_LIMIT = 2000;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 1;
                arrn[2] = 2;
                DojoPoints = arrn;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 10000.0;
                MobDropPOINT = arrd;
                int[] arrn146 = new int[3];
                arrn146[0] = 100;
                arrn146[1] = 150;
                arrn146[2] = 60;
                ONLINEPOINT = arrn146;
                int[] arrn147 = new int[1];
                arrn147[0] = 910000000;
                ONLINEPOINT_MAP = arrn147;
                FreeSlot = true;
                int[] arrn148 = new int[1];
                arrn148[0] = 910000000;
                FISH_MAP = arrn148;
                MAX_STAT = 1999;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                BUYBACK_SYSTEM = true;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 2.0;
                BACCARAT_SYSTEM = true;
                int[] arrn149 = new int[2];
                arrn149[0] = 8;
                arrn149[1] = 910000000;
                BACCARAT_LOCATION = arrn149;
                NIUNIU_SYSTEM = true;
                int[] arrn150 = new int[2];
                arrn150[0] = 2;
                arrn150[1] = 910000000;
                NIUNIU_LOCATION = arrn150;
                BLACKJACK_SYSTEM = true;
                int[] arrn151 = new int[2];
                arrn151[0] = 3;
                arrn151[1] = 910000000;
                BLACKJACK_LOCATION = arrn151;
                int[][] arrarrn = new int[2][];
                int[] arrn152 = new int[2];
                arrn152[0] = 9800142;
                arrn152[1] = 2;
                arrarrn[0] = arrn152;
                int[] arrn153 = new int[2];
                arrn153[0] = 9800143;
                arrn153[1] = 2;
                arrarrn[1] = arrn153;
                REINCARNATION_MOB = arrarrn;
                LOGIN_CHECK = false;
                SELL_SYSTEM = true;
                int[] arrn154 = new int[1];
                arrn154[0] = 29963;
                QUEST_REMOVE = arrn154;
                int[] arrn155 = new int[6];
                arrn155[0] = 109040000;
                arrn155[1] = 109040001;
                arrn155[2] = 109040002;
                arrn155[3] = 109040003;
                arrn155[4] = 109040004;
                arrn155[5] = 109010100;
                SKILLDISABLE_MAP = arrn155;
                PEE_SYSTEM = true;
                MERCHANT_ID = "3208037";
                HASHKEY = "rq4nbrPkUPpaAlpU";
                HASHIV = "lvGEsGzTQ6REEAcj";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://happy.bobolinebot.tk";
                IP_CHANNEL_LIMIT = 999999;
                LINEBOT = true;
                LOGIN_SIGNLOG = true;
                LOGIN_CONTINUE_NONEED = true;
                PEE_CHAIR = 5062002;
                DELAY_CHECK = false;
                CHECK_TAKE_DAMAGE = false;
                CHECKONEHUNDRED = false;
                HOMOSEX = true;
                CHECKIP_ADRESS = false;
                MORE_OPEN = 2;
                DCLOAD_LOGIN_SAVING = false;
                MARRY_DROP_BONUS = 1.1;
                MARRY_EXP_BONUS = 1.1;
                DAMAGE_SKIN = true;
                BAN_DELETE_CHARACTER = true;
                CLIENT_GM = false;
                FISH_KING = true;
                LEGEND_CHANCE = 160;
                COMPRESS_ITEM = false;
                IP_GEO_SYSTEM = true;
                COPYITEM_BAN = true;
                return;
            }
            case 96: {
                MAPLE_VERSION = (short)113;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                FORBID_JOB_OVERLEVEL = true;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                AUTO_UPDATE = false;
                PING_HANDLER = true;
                NEW_RECHARGE_ITEM = false;
                VONLEONMAP_PARTYEXPBONUS = true;
                PKARMACANCUT = true;
                CHECK_ALLDAMAGE = false;
                LOTTORY_DRAW = true;
                EXP_CHAIR = true;
                NEW_ITEM_SAVE = true;
                FLY_CHAIR = true;
                EXPIRED = true;
                return;
            }
            case 97: {
                MAPLE_VERSION = (short)113;
                MAXLEVEL = 255;
                MAXLEVEL_KOC = 255;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                PING_HANDLER = true;
                NEW_RECHARGE_ITEM = false;
                VONLEONMAP_PARTYEXPBONUS = true;
                PKARMACANCUT = true;
                CHECK_ALLDAMAGE = false;
                EXP_CHAIR = true;
                NEW_ITEM_SAVE = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[1];
                arrn[0] = 1332005;
                PETVAC_EQUIP = arrn;
                PKARMACANCUT = true;
                STORAGE_EXCEED = false;
                NEW_RECHARGE_ITEM = false;
                CS_CLASSIFY = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                ECPAY_IP = "202.39.153.200";
                MERCHANT_ID = "3017038";
                HASHKEY = "p4x2PRkk3FGaxKIR";
                HASHIV = "85A1bQSvmhu2rNCE";
                CANUSE_4CASH = true;
                AUCTION_SYSTEM = true;
                return;
            }
            case 98: {
                MAPLE_VERSION = (short)113;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                FORBID_JOB_OVERLEVEL = true;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                PING_HANDLER = true;
                NEW_RECHARGE_ITEM = false;
                VONLEONMAP_PARTYEXPBONUS = true;
                PKARMACANCUT = true;
                CHECK_ALLDAMAGE = false;
                LOTTORY_DRAW = true;
                EXP_CHAIR = true;
                NEW_ITEM_SAVE = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 6.0;
                arrd[2] = 2.0;
                arrd[3] = 1.0;
                arrd[4] = 6000.0;
                MobDropPOINT = arrd;
                SPECIAL_CRYPT = true;
                USE_CRYPT_KEY = true;
                CRYPT_KEY = 231;
                SPECIAL_CRYPT_AES = "AiJS45AIDM25WQ45";
                SPECIAL_CRYPT_IV = "1S5S4F1HNWWCEFad";
                NORA_SHIELD = true;
                return;
            }
            case 99: {
                MAPLE_VERSION = (short)116;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                NEW_ITEM_SAVE = true;
                NEW_RECHARGE_ITEM = false;
                return;
            }
            case 100: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                NEW_ITEM_SAVE = true;
                NEW_RECHARGE_ITEM = false;
                return;
            }
            case 101: {
                MAPLE_VERSION = (short)75;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                NEW_RECHARGE_ITEM = false;
                return;
            }
            case 102: {
                MAPLE_VERSION = (short)75;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                NEW_RECHARGE_ITEM = false;
                int[] arrn = new int[3];
                arrn[0] = 0;
                arrn[1] = 0;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                MERCHANT_ID = "3180347";
                HASHKEY = "yoTxB6VgJ4Q3fVDy";
                HASHIV = "9uDNc1Ckuk7t6w0y";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://true.bobolinebot.tk";
                LINEBOT = true;
                FLY_CHAIR = true;
                POISON_BOSS = false;
                return;
            }
            case 103: {
                MAPLE_VERSION = (short)75;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 500;
                UNLIMITMPTOHP = false;
                MAX_SLOT = true;
                NEW_RECHARGE_ITEM = false;
                int[] arrn = new int[3];
                arrn[0] = 0;
                arrn[1] = 0;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                RESET_STATS = false;
                VIP_DONATEINTERVAL = 1000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 5;
                VIPPOINT = true;
                POISON_BOSS = false;
                FREEMARKET_LEVEL = 8;
                CREATE_GUILD_MESO = 500000;
                int[] arrn156 = new int[1];
                arrn156[0] = 180000000;
                ONLINEPOINT_MAP = arrn156;
                MERCHANT_ID = "3195349";
                HASHKEY = "II2hBvOevYsBo5xm";
                HASHIV = "At5SOm5BypqVeOPp";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://maplemark.bobolinebot.tk";
                LINEBOT = true;
                int[] arrn157 = new int[1];
                arrn157[0] = 741000200;
                FISH_MAP = arrn157;
                return;
            }
            case 104: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                int[] arrn = new int[4];
                arrn[0] = 1005174;
                arrn[1] = 1103108;
                arrn[2] = 1053318;
                arrn[3] = 1073283;
                CREAT_EQUIPS_MALE = arrn;
                int[] arrn158 = new int[4];
                arrn158[0] = 1005174;
                arrn158[1] = 1103108;
                arrn158[2] = 1053318;
                arrn158[3] = 1073283;
                CREAT_EQUIPS_FEMALE = arrn158;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 3000;
                VIPPOINT = true;
                int[] arrn159 = new int[3];
                arrn159[0] = 1;
                arrn159[1] = 5;
                arrn159[2] = 120;
                ONLINEPOINT = arrn159;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                VIPMONSTERPOINT_ADD = 5;
                MobDropPOINT_LEVEL = true;
                int[][] arrarrn = new int[1][];
                int[] arrn160 = new int[2];
                arrn160[0] = 9700030;
                arrn160[1] = 2;
                arrarrn[0] = arrn160;
                REINCARNATION_MOB = arrarrn;
                IP_GEO_SYSTEM = true;
                DUE_DATE = "2020-01-08";
                AUTO_CS_ITEM = true;
                SERVER_ID = 71;
                EXPIRED = true;
                return;
            }
            case 105: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                DUE_DATE = "2020-01-08";
                SERVER_ID = 72;
                EXPIRED = true;
                return;
            }
            case 106: {
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 99999L;
                WASH_HP_LIMIT = 999999;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 1;
                arrn[2] = 2;
                DojoPoints = arrn;
                DOJO_POINT_PARTY_SEPERATE = false;
                DOJO_POINT = true;
                int[] arrn161 = new int[4];
                arrn161[0] = 1;
                arrn161[1] = 1;
                arrn161[2] = 2;
                arrn161[3] = 60;
                ONLINEPOINT = arrn161;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 2.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 1500.0;
                MobDropPOINT = arrd;
                int[] arrn162 = new int[1];
                arrn162[0] = 910000000;
                FISH_MAP = arrn162;
                EXPRingPartyUnlimit = true;
                MAX_STAT = 999;
                GIVEALL_PETSKILL = false;
                CS_FACTORYOPEN = true;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                BACCARAT_SYSTEM = true;
                int[] arrn163 = new int[2];
                arrn163[0] = 20;
                arrn163[1] = 809030001;
                BACCARAT_LOCATION = arrn163;
                NIUNIU_SYSTEM = true;
                int[] arrn164 = new int[2];
                arrn164[0] = 19;
                arrn164[1] = 809030001;
                NIUNIU_LOCATION = arrn164;
                DUE_DATE = "2019-11-01";
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                IP_CHANNEL_LIMIT = 3;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3154319";
                HASHKEY = "jhmlXKFCvuorgh4c";
                HASHIV = "WZkwVzPfcCZHOxFD";
                SERVER_ID = 73;
                BACCARAT_LIMIT_RATE = 0.5;
                EXPIRED = true;
                return;
            }
            case 107: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 99999999;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 1;
                arrn[2] = 2;
                DojoPoints = arrn;
                DOJO_POINT_PARTY_SEPERATE = false;
                DOJO_POINT = true;
                int[] arrn165 = new int[4];
                arrn165[0] = 1;
                arrn165[1] = 15;
                arrn165[2] = 2;
                arrn165[3] = 60;
                ONLINEPOINT = arrn165;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 6.0;
                arrd[2] = 2.0;
                arrd[3] = 0.16666666666666666;
                arrd[4] = 6000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn166 = new int[1];
                arrn166[0] = 910000000;
                FISH_MAP = arrn166;
                EXPRingPartyUnlimit = true;
                MAX_STAT = 999;
                MAX_SLOT = true;
                GIVEALL_PETSKILL = false;
                CS_FACTORYOPEN = true;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                BACCARAT_SYSTEM = true;
                int[] arrn167 = new int[2];
                arrn167[0] = 20;
                arrn167[1] = 809030000;
                BACCARAT_LOCATION = arrn167;
                NIUNIU_SYSTEM = true;
                int[] arrn168 = new int[2];
                arrn168[0] = 19;
                arrn168[1] = 809030000;
                NIUNIU_LOCATION = arrn168;
                DUE_DATE = "2020-01-01";
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                IP_CHANNEL_LIMIT = 3;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3154319";
                HASHKEY = "jhmlXKFCvuorgh4c";
                HASHIV = "WZkwVzPfcCZHOxFD";
                BACCARAT_LIMIT_RATE = 0.5;
                BUYBACK_SYSTEM = true;
                VPOINT_NAME = "\u767e\u5e74";
                BLOCK_LOGGEDIN_CHECK = false;
                SERVER_ID = 74;
                EXPIRED = true;
                return;
            }
            case 108: {
                MAPLE_VERSION = (short)139;
                return;
            }
            case 109: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = false;
                WASH_HP_LIMIT = 99999;
                int[] arrn = new int[4];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 1;
                arrn[3] = 60;
                ONLINEPOINT = arrn;
                UNLIMITMPTOHP = true;
                int[] arrn169 = new int[3];
                arrn169[0] = 5;
                arrn169[1] = 5;
                arrn169[2] = 2;
                DojoPoints = arrn169;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn170 = new int[1];
                arrn170[0] = 910000000;
                FISH_MAP = arrn170;
                MAX_STAT = 1500;
                GAMBLING_SYSTEM = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                CS_FACTORYOPEN = true;
                SAVEBUFF = true;
                FLY_CHAIR = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3167023";
                HASHKEY = "AZx7N5AqzWz8Qhfz";
                HASHIV = "G0COWodkirGTJcAW";
                REGULAR_BONUS = true;
                String[] arrstring = new String[2];
                arrstring[0] = SharkLogger.ALLATORIxDEMO("\u514c");
                arrstring[1] = MobSkillData.ALLATORIxDEMO("\u65e8");
                EXP_BONUS_ALLDAY = arrstring;
                MAP_MOB_ALLCHANNEL = false;
                DUE_DATE = "2020-01-20";
                AUTO_CS_ITEM = true;
                SERVER_ID = 75;
                EXPIRED = true;
                return;
            }
            case 110: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                WASH_HP_LIMIT = 99999;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn171 = new int[4];
                arrn171[0] = 1;
                arrn171[1] = 15;
                arrn171[2] = 2;
                arrn171[3] = 60;
                ONLINEPOINT = arrn171;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.3333333333333333;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn172 = new int[1];
                arrn172[0] = 910000000;
                FISH_MAP = arrn172;
                MAX_STAT = 999;
                GAMBLING_SYSTEM = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                ECPAY_SYSTEM = true;
                DUE_DATE = "2019-11-30";
                ECPAY_PORT = 80;
                MERCHANT_ID = "3158005";
                HASHKEY = "MRyjRi5YeJGNLstj";
                HASHIV = "euMDYQ6bxSri64w7";
                AUTO_CS_ITEM = true;
                CS_FACTORYOPEN = true;
                SERVER_ID = 76;
                EXPIRED = true;
                return;
            }
            case 111: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                CS_FACTORYOPEN = true;
                int[] arrn = new int[4];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 1;
                arrn[3] = 60;
                ONLINEPOINT = arrn;
                DOJO_POINT_PARTY_SEPERATE = false;
                DOJO_POINT = true;
                LOGIN_SIGNLOG = true;
                FACTION_SYSTEM = true;
                SPECIAL_ITEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn173 = new int[2];
                arrn173[0] = 2;
                arrn173[1] = 910000000;
                BACCARAT_LOCATION = arrn173;
                DAMAGE_SYSTEM = true;
                FLY_CHAIR = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3080023";
                HASHKEY = "hGJ6RmXHItpfa0AX";
                HASHIV = "UZvvKTHD9EZplOm7";
                DELAY_CHECK = false;
                CHECKDAMAGE_BAN = false;
                MARRY_DROP_BONUS = 1.1;
                MARRY_EXP_BONUS = 1.1;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.025;
                arrd[4] = 2500.0;
                MobDropPOINT = arrd;
                CRYPTOCURRENCY = true;
                MODIFY_ATTACKCOUNT = true;
                int[] arrn174 = new int[3];
                arrn174[0] = 8248;
                arrn174[1] = 8249;
                arrn174[2] = 10619;
                QUEST_REMOVE = arrn174;
                EVENTMOB_REWARD = false;
                int[][] arrarrn = new int[1][];
                int[] arrn175 = new int[2];
                arrn175[0] = 9800130;
                arrn175[1] = 2;
                arrarrn[0] = arrn175;
                REINCARNATION_MOB = arrarrn;
                MAX_STAT = 1999;
                ACCURATE_DMG_TO_MOB = true;
                CHECK_COPYITEM = true;
                IP_GEO_SYSTEM = true;
                MONSTERPET = true;
                BUYBACK_SYSTEM = true;
                IP_CHANNEL_LIMIT = 10;
                SERVER_ID = 77;
                EXPIRED = true;
                return;
            }
            case 112: {
                MAPLE_VERSION = (short)135;
                SELF_BUY = true;
                ATTACKCHECK_MODIFY = false;
                AUTOBAN = false;
                AUTODC = false;
                ITEMVAC_BAN = false;
                MOBVAC_BAN = false;
                ALLMAPATTACK_BAN = false;
                ATTACKSPEEDUP_BAN = false;
                NOARROWATTACK_BAN = false;
                CHECKMOVE = false;
                PANNEL_LIMIT = true;
                HACK_TOOL = true;
                SERVER_PERMIT = true;
                AUTO_UPDATE = false;
                NPC_CRYPT = true;
                EXPIRED = true;
                return;
            }
            case 113: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                WASH_HP_LIMIT = 500;
                DOJO_POINT = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 120;
                MAX_SLOT = true;
                MAX_STAT = 999;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                int[] arrn176 = new int[4];
                arrn176[0] = 1;
                arrn176[1] = 5;
                arrn176[2] = 2;
                arrn176[3] = 60;
                ONLINEPOINT = arrn176;
                BUYBACK_SYSTEM = true;
                PEE_SYSTEM = true;
                CRYPTOCURRENCY = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPEXP_INTERVAL = 0.1;
                VIPDROP_INTERVAL = 0.1;
                AUTO_CS_ITEM = true;
                int[] arrn177 = new int[10];
                arrn177[0] = 1000;
                arrn177[1] = 3000;
                arrn177[2] = 5000;
                arrn177[3] = 7000;
                arrn177[4] = 10000;
                arrn177[5] = 15000;
                arrn177[6] = 20000;
                arrn177[7] = 30000;
                arrn177[8] = 40000;
                arrn177[9] = 50000;
                VIP_DONATE_INTERVAL = arrn177;
                VIPAUTOGIVE = true;
                CHECK_COPYITEM_CLEAR = false;
                BUYBACK_SYSTEM = true;
                ONLINETIME = true;
                BACCARAT_SYSTEM = true;
                int[] arrn178 = new int[2];
                arrn178[0] = 20;
                arrn178[1] = 910000000;
                BACCARAT_LOCATION = arrn178;
                EVENT_COUNT = true;
                CREATE_EVAN = false;
                MERCHANT_ID = "3017038";
                HASHKEY = "p4x2PRkk3FGaxKIR";
                HASHIV = "85A1bQSvmhu2rNCE";
                ECPAY_SYSTEM = true;
                FORBID_JOB_OVERLEVEL = true;
                DOJO_POINT_PARTY_SEPERATE = false;
                DAMAGE_SYSTEM = true;
                EHCHANCE_LIMIT_LEVEL = false;
                CREATE_EVAN = true;
                PVP_ENTER = true;
                AUTO_CLEAN_DROPS = 999;
                EXP_CHAIR = true;
                FISH_KING = true;
                HELLSYSTEM = true;
                int[] arrn179 = new int[5];
                arrn179[0] = 16;
                arrn179[1] = 17;
                arrn179[2] = 18;
                arrn179[3] = 19;
                arrn179[4] = 20;
                HELLCHANNEL = arrn179;
                HELL_CUSTOMIZE = true;
                double[] arrd = new double[6];
                arrd[0] = 1.0;
                arrd[1] = 1.0;
                arrd[2] = 1.0;
                arrd[3] = 500.0;
                arrd[4] = 1.0;
                arrd[5] = 90.0;
                HELL_RATE = arrd;
                double[] arrd12 = new double[5];
                arrd12[0] = 1.0;
                arrd12[1] = 5.0;
                arrd12[2] = 2.0;
                arrd12[3] = 0.2;
                arrd12[4] = 3000.0;
                MobDropPOINT = arrd12;
                AUTO_UPDATE = false;
                SERVER_ID = 78;
                EXPIRED = true;
                return;
            }
            case 114: {
                ONLYTOOL = true;
                return;
            }
            case 115: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                WASH_HP_LIMIT = 99999;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 2;
                DojoPoints = arrn;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 1.0;
                arrd[2] = 2.0;
                arrd[3] = 1.0;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                int[] arrn180 = new int[1];
                arrn180[0] = 910000000;
                FISH_MAP = arrn180;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 30000;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                AUTO_CS_ITEM = true;
                MERCHANT_ID = "3152757";
                HASHKEY = "mHzSAGjQJrE48TEL";
                HASHIV = "FOmf2ywooUXmsz4q";
                ECPAY_SYSTEM = true;
                double[] arrd13 = new double[5];
                arrd13[0] = 1.0;
                arrd13[1] = 10.0;
                arrd13[2] = 2.0;
                arrd13[3] = 0.1;
                arrd13[4] = 3000.0;
                MobDropPOINT = arrd13;
                SERVER_ID = 79;
                USE_CRYPT_KEY = true;
                CRYPT_KEY = 12;
                int[][] arrarrn = new int[1][];
                int[] arrn181 = new int[2];
                arrn181[0] = 9700030;
                arrn181[1] = 2;
                arrarrn[0] = arrn181;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9700030;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1112797;
                int[] arrn182 = new int[1];
                arrn182[0] = 10001002;
                REINCARNATION_SKILL = arrn182;
                AUTO_CLEAN_DROPS = 300;
                FLY_CHAIR = true;
                EXPIRED = true;
                return;
            }
            case 116: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 499999L;
                WASH_HP_LIMIT = 999999;
                FreeSlot = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 2000;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[][] arrarrn = new int[6][];
                int[] arrn183 = new int[2];
                arrn183[0] = 9600080;
                arrn183[1] = 2;
                arrarrn[0] = arrn183;
                int[] arrn184 = new int[2];
                arrn184[0] = 9600081;
                arrn184[1] = 2;
                arrarrn[1] = arrn184;
                int[] arrn185 = new int[2];
                arrn185[0] = 9600082;
                arrn185[1] = 2;
                arrarrn[2] = arrn185;
                int[] arrn186 = new int[2];
                arrn186[0] = 9600083;
                arrn186[1] = 2;
                arrarrn[3] = arrn186;
                int[] arrn187 = new int[2];
                arrn187[0] = 9600084;
                arrn187[1] = 2;
                arrarrn[4] = arrn187;
                int[] arrn188 = new int[2];
                arrn188[0] = 9600085;
                arrn188[1] = 2;
                arrarrn[5] = arrn188;
                REINCARNATION_MOB = arrarrn;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                DUE_DATE = "2020-03-08";
                MERCHANT_ID = "3066385";
                HASHKEY = "u6rGSLX0f8dGf3Qn";
                HASHIV = "aWKOR0U4HGj3baWe";
                ECPAY_SYSTEM = true;
                LOGIN_CHECK = false;
                SERVER_ID = 80;
                EXPIRED = true;
                return;
            }
            case 117: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 800;
                UNLIMITMPTOHP = false;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn189 = new int[1];
                arrn189[0] = 910000000;
                FISH_MAP = arrn189;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 5000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 20;
                VIPPOINT = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 80;
                MERCHANT_ID = "3041587";
                HASHKEY = "DQvU0zguteWLm5lq";
                HASHIV = "MQMyvZ0nm9fTA7O1";
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                SAVEBUFF = true;
                LOGIN_SIGNLOG = true;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                int[][] arrarrn = new int[10][];
                int[] arrn190 = new int[2];
                arrn190[0] = 9800030;
                arrn190[1] = 2;
                arrarrn[0] = arrn190;
                int[] arrn191 = new int[2];
                arrn191[0] = 9800031;
                arrn191[1] = 2;
                arrarrn[1] = arrn191;
                int[] arrn192 = new int[2];
                arrn192[0] = 9800032;
                arrn192[1] = 2;
                arrarrn[2] = arrn192;
                int[] arrn193 = new int[2];
                arrn193[0] = 9800033;
                arrn193[1] = 2;
                arrarrn[3] = arrn193;
                int[] arrn194 = new int[2];
                arrn194[0] = 9800034;
                arrn194[1] = 2;
                arrarrn[4] = arrn194;
                int[] arrn195 = new int[2];
                arrn195[0] = 9800035;
                arrn195[1] = 2;
                arrarrn[5] = arrn195;
                int[] arrn196 = new int[2];
                arrn196[0] = 9800036;
                arrn196[1] = 2;
                arrarrn[6] = arrn196;
                int[] arrn197 = new int[2];
                arrn197[0] = 9800037;
                arrn197[1] = 5;
                arrarrn[7] = arrn197;
                int[] arrn198 = new int[2];
                arrn198[0] = 9800038;
                arrn198[1] = 5;
                arrarrn[8] = arrn198;
                int[] arrn199 = new int[2];
                arrn199[0] = 9800039;
                arrn199[1] = 5;
                arrarrn[9] = arrn199;
                REINCARNATION_MOB = arrarrn;
                DUE_DATE = "2020-02-03";
                AUTO_CLEAN_DROPS = 600;
                MORE_OPEN = 2;
                SERVER_ID = 81;
                EXPIRED = true;
                return;
            }
            case 118: {
                MAPLE_VERSION = (short)113;
                MAXLEVEL = 210;
                MAXLEVEL_KOC = 200;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                CS_FACTORYOPEN = true;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                LOGIN_SIGNLOG = true;
                int[] arrn = new int[3];
                arrn[0] = 910000000;
                arrn[1] = 100000000;
                arrn[2] = 993053000;
                FISH_MAP = arrn;
                GIVEALL_PETSKILL = true;
                int[] arrn200 = new int[4];
                arrn200[0] = 5;
                arrn200[1] = 25;
                arrn200[2] = 1;
                arrn200[3] = 60;
                ONLINEPOINT = arrn200;
                int[] arrn201 = new int[5];
                arrn201[0] = 910000000;
                arrn201[1] = 749050502;
                arrn201[2] = 749050501;
                arrn201[3] = 749050500;
                arrn201[4] = 100000000;
                ONLINEPOINT_MAP = arrn201;
                HOMOSEX = true;
                MAX_STAT = 1999;
                BACCARAT_SYSTEM = true;
                int[] arrn202 = new int[2];
                arrn202[0] = 1;
                arrn202[1] = 993053000;
                BACCARAT_LOCATION = arrn202;
                NIUNIU_SYSTEM = true;
                int[] arrn203 = new int[2];
                arrn203[0] = 2;
                arrn203[1] = 993053000;
                NIUNIU_LOCATION = arrn203;
                BLACKJACK_SYSTEM = true;
                int[] arrn204 = new int[2];
                arrn204[0] = 3;
                arrn204[1] = 993053000;
                BLACKJACK_LOCATION = arrn204;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                PEE_SYSTEM = true;
                PEE_CHAIR = 3010373;
                MERCHANT_ID = " 3180347";
                HASHKEY = "yoTxB6VgJ4Q3fVDy";
                HASHIV = "9uDNc1Ckuk7t6w0y";
                ECPAY_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                MEGA_LIMIT = false;
                FAMILY_SYSTEM = false;
                AUTO_SAVE_MERCHANT = 180000L;
                EXPRingPartyUnlimit = true;
                WASH_HP_MAGICIAN_BAN = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                STORAGE_EXCEED = true;
                MAX_SLOT = true;
                FreeSlot = true;
                FORBID_JOB_OVERLEVEL = true;
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                BAN_DELETE_CHARACTER = true;
                WASH_HP_LIMIT = 2000;
                VONLEONMAP_PARTYEXPBONUS = true;
                EVENT_RELOADTIME = 1200000L;
                ARAN_COMBO_TIME = 12000L;
                PKARMACANCUT = true;
                EXP_CHAIR = true;
                LOTTORY_DRAW = true;
                int[] arrn205 = new int[3];
                arrn205[0] = 200;
                arrn205[1] = 210;
                arrn205[2] = 250;
                LEVELMSG = arrn205;
                int[] arrn206 = new int[1];
                arrn206[0] = 970010000;
                PET_PICKUP_MAP_BAN = arrn206;
                SERVER_ID = 82;
                NEW_ITEM_SAVE = true;
                CHECK_BUFF = true;
                POTENTIAL_SYSTEM = true;
                EXPIRED = true;
                return;
            }
            case 119: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 1;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 2.0;
                BOSS_HPRATE = 2.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 1999;
                int[] arrn = new int[4];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                arrn[3] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03333333333333333;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                MAX_SLOT = true;
                int[] arrn207 = new int[1];
                arrn207[0] = 910000000;
                FISH_MAP = arrn207;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                GMBUFF_LIMIT = false;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 5000;
                VIP_LEVELMAX = 20;
                VIPEXP = true;
                VIPDROP = true;
                VIPPOINT = false;
                BUYBACK_SYSTEM = true;
                PEE_SYSTEM = true;
                SAVEBUFF = true;
                AUTO_CS_ITEM = true;
                int[] arrn208 = new int[3];
                arrn208[0] = 5;
                arrn208[1] = 5;
                arrn208[2] = 2;
                DojoPoints = arrn208;
                EXPIRED = true;
                SERVER_ID = 83;
                return;
            }
            case 120: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 15000000L;
                WASH_HP_LIMIT = 1000;
                UNLIMITMPTOHP = false;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn209 = new int[1];
                arrn209[0] = 910000000;
                FISH_MAP = arrn209;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 3600;
                GIVEALL_PETSKILL = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                AUTO_CS_ITEM = true;
                CANUSE_4CASH = true;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                int[] arrn210 = new int[1];
                arrn210[0] = 1112100;
                PETVAC_EQUIP = arrn210;
                int[][] arrarrn = new int[1][];
                int[] arrn211 = new int[2];
                arrn211[0] = 9700039;
                arrn211[1] = 2;
                arrarrn[0] = arrn211;
                REINCARNATION_MOB = arrarrn;
                SELL_SYSTEM = true;
                LOGIN_SIGNLOG = true;
                ARAN_COMBO_TIME = 6000L;
                COUNT_CHECK = false;
                POISON_DIE = true;
                MARRY_DROP_BONUS = 1.1;
                MARRY_EXP_BONUS = 1.1;
                CHECK_COPYITEM = false;
                COPTITEMCHECK_STRICT = false;
                REINCARNATION_SKILL_MOB = 9700039;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1112442;
                int[] arrn212 = new int[1];
                arrn212[0] = 1001;
                REINCARNATION_SKILL = arrn212;
                DAMAGE_SYSTEM = true;
                FLY_CHAIR = true;
                LOGIN_CHECK = false;
                AUTO_JOB = true;
                SERVER_ID = 84;
                MERCHANT_ID = "3183783";
                HASHKEY = "XJCViNzGqtGO4bfz";
                HASHIV = "hiziAWH6IAPHgSiJ";
                return;
            }
            case 121: 
            case 122: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                UNLIMITMPTOHP = true;
                WASH_HP_LIMIT = 999;
                int[] arrn = new int[4];
                arrn[0] = 8;
                arrn[1] = 8;
                arrn[2] = 2;
                arrn[3] = 60;
                ONLINEPOINT = arrn;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                EXPRingPartyUnlimit = true;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[] arrn213 = new int[1];
                arrn213[0] = 910000000;
                FISH_MAP = arrn213;
                BUYBACK_SYSTEM = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                MAX_DAMAGE = 300000L;
                USE_CRYPT_KEY = true;
                CRYPT_KEY = 242;
                SPECIAL_CRYPT = true;
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                ARAN_COMBO_TIME = 12000L;
                SPECIAL_CRYPT_AES = "Q3Unz3wnpTbxnhqS";
                SPECIAL_CRYPT_IV = "GRUxDFugZx2Tm9ef";
                NORA_SHIELD = true;
                EXPIRED = true;
                SERVER_ID = 85;
                return;
            }
            case 123: {
                MAPLE_VERSION = (short)118;
                UPGRADE_SCROLL_WHITE = true;
                BUYBACK_SYSTEM = true;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 500;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.16666666666666666;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn = new int[1];
                arrn[0] = 910000026;
                FISH_MAP = arrn;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                SHOWEVENTMSG = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                ADMIN_DIVINEBODY = false;
                MOB_COUNT_RATE = 2.0;
                FLY_CHAIR = true;
                int[][] arrarrn = new int[3][];
                int[] arrn214 = new int[2];
                arrn214[0] = 9700100;
                arrn214[1] = 3;
                arrarrn[0] = arrn214;
                int[] arrn215 = new int[2];
                arrn215[0] = 9700200;
                arrn215[1] = 3;
                arrarrn[1] = arrn215;
                int[] arrn216 = new int[2];
                arrn216[0] = 9700300;
                arrn216[1] = 3;
                arrarrn[2] = arrn216;
                REINCARNATION_MOB = arrarrn;
                MERCHANT_ID = "3155251";
                HASHKEY = "yzTUiiWwLJmoRI4P";
                HASHIV = "X36Hy4fKSVA0lO9N";
                ECPAY_SYSTEM = true;
                FM_DROP = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://ms.bobolinebot.tk";
                LINEBOT = true;
                MORE_OPEN = 2;
                SELL_SYSTEM = true;
                DELAY_CHECK = false;
                CANUSE_4CASH = true;
                AUTO_CS_ITEM = true;
                int[] arrn217 = new int[1];
                arrn217[0] = 1112286;
                PETVAC_EQUIP = arrn217;
                WASH_HP_MAGICIAN_BAN = false;
                MAX_STAT = 1999;
                LOGIN_CHECK = false;
                WASH_HP_LIMIT = 1000;
                CHECKDAMAGE_BAN = false;
                PACKET_CHECK = false;
                int[] arrn218 = new int[5];
                arrn218[0] = 910000026;
                arrn218[1] = 910000025;
                arrn218[2] = 910000024;
                arrn218[3] = 910000023;
                arrn218[4] = 910000087;
                SKILLDISABLE_MAP = arrn218;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                DAMAGE_SYSTEM = true;
                GM_OWNNAME = false;
                int[] arrn219 = new int[2];
                arrn219[0] = 2060007;
                arrn219[1] = 2061005;
                NO_CONSUME_ITEM = arrn219;
                SERVER_ID = 86;
                CS_CLASSIFY = true;
                return;
            }
            case 124: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 3.0;
                MAX_DAMAGE = 10000000L;
                WASH_HP_LIMIT = 500;
                UNLIMITMPTOHP = false;
                int[] arrn = new int[3];
                arrn[0] = 30;
                arrn[1] = 30;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn220 = new int[3];
                arrn220[0] = 15;
                arrn220[1] = 30;
                arrn220[2] = 60;
                ONLINEPOINT = arrn220;
                double[] arrd = new double[5];
                arrd[0] = 2.0;
                arrd[1] = 30.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 30000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn221 = new int[1];
                arrn221[0] = 910000000;
                FISH_MAP = arrn221;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                SHOWEVENTMSG = true;
                MAX_STAT = 1245;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                AUTO_JOB = false;
                DEFAULT_HP = 30000;
                DEFAULT_MP = 30000;
                UPGRADESLOT_CHECK = false;
                CHECK_SKILLJOB = false;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                USE_CRYPT_KEY = true;
                MOB_DIRECTION_DETECT = false;
                AUTODC = false;
                AUTOBAN = false;
                ATTACKRANGE_CHECK = false;
                ITEMVAC_BAN = false;
                MOBVAC_BAN = false;
                ALLMAPATTACK_BAN = false;
                ATTACKSPEEDUP_BAN = false;
                NOARROWATTACK_BAN = false;
                CHECKMOVE = false;
                CHECK_EQUIPLVL = false;
                COUNT_CHECK = false;
                DELAY_CHECK = false;
                CHECK_ALLDAMAGE = false;
                MODIFY_ATTACKCOUNT = false;
                ATTACK_DELAY_DETECT = false;
                PKARMACANCUT = true;
                MAPOWNER_SYSTEM = false;
                WELCOMEMSG = "\u6b61\u8fce\u4f86\u5230 \u6a02\u5712\u8c37\u3002\n\u65b0\u624b\u8a18\u5f97\u7df4\u523010\u7b49(\u5305\u542b\u6cd5\u5e2b)\n\u51fa\u65b0\u624b\u6751\u5f8c\u76f4\u63a5\u9ede\u62cd\u8ce3\u7684\u842c\u80fd\u8f49\u8077\uff01\n@\u6eff\u6280\u5f8c\u63db\u5e73  \u6280\u80fd\u5373\u53ef\u5168\u6eff\uff01\n\u5e0c\u671b\u60a8\u5165\u5712\u904a\u73a9\u6109\u5feb\u3002";
                NEW_ITEM_SAVE = true;
                FLY_CHAIR = true;
                DUE_DATE = "2021-04-10";
                CRYPT_KEY = 28;
                SPECIAL_CRYPT = true;
                SPECIAL_CRYPT_AES = "nzWTuXPmWpzuZuz6";
                SPECIAL_CRYPT_IV = "6epEXxYqCtbsUaF5";
                COPTITEMCHECK_STRICT = false;
                EXPIRED = true;
                SERVER_ID = 87;
                return;
            }
            case 125: {
                MAXLEVEL = 200;
                MAXLEVEL_KOC = 200;
                VIPAUTOGIVE = true;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPEXP_INTERVAL = 0.1;
                VIPDROP_INTERVAL = 0.1;
                int[] arrn = new int[5];
                arrn[0] = 1000;
                arrn[1] = 5000;
                arrn[2] = 15000;
                arrn[3] = 20000;
                arrn[4] = 40000;
                VIP_DONATE_INTERVAL = arrn;
                EXP_RATE = 3;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                int[] arrn222 = new int[3];
                arrn222[0] = 5;
                arrn222[1] = 10;
                arrn222[2] = 60;
                ONLINEPOINT = arrn222;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 999999L;
                int[] arrn223 = new int[1];
                arrn223[0] = 910000000;
                FISH_MAP = arrn223;
                EXPRingPartyUnlimit = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 15.0;
                arrd[2] = 2.0;
                arrd[3] = 0.16666666666666666;
                arrd[4] = 4000.0;
                MobDropPOINT = arrd;
                MAX_STAT = 2000;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 1000;
                VIPEXP = true;
                VIPDROP = true;
                VIPPOINT = false;
                int[] arrn224 = new int[3];
                arrn224[0] = 300;
                arrn224[1] = 300;
                arrn224[2] = 1;
                DojoPoints = arrn224;
                DojoPoints_AllPass = true;
                NEW_ITEM_SAVE = true;
                AUTO_CS_ITEM = true;
                int[] arrn225 = new int[2];
                arrn225[0] = 2109998;
                arrn225[1] = 2009999;
                NO_CONSUME_ITEM = arrn225;
                NEW_RECHARGE_ITEM = false;
                FLY_CHAIR = true;
                int[][] arrarrn = new int[1][];
                int[] arrn226 = new int[2];
                arrn226[0] = 8641020;
                arrn226[1] = 2;
                arrarrn[0] = arrn226;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 8641020;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 0x1116F6;
                int[] arrn227 = new int[3];
                arrn227[0] = 1005;
                arrn227[1] = 10001005;
                arrn227[2] = 20001005;
                REINCARNATION_SKILL = arrn227;
                MAX_STAT = 1999;
                EXPIRED = true;
                SERVER_ID = 88;
                return;
            }
            case 126: {
                int[][] arrarrn = new int[1][];
                int[] arrn = new int[2];
                arrn[0] = 9800030;
                arrn[1] = 2;
                arrarrn[0] = arrn;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9800030;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1112324;
                int[] arrn228 = new int[3];
                arrn228[0] = 1017;
                arrn228[1] = 10001019;
                arrn228[2] = 20001019;
                REINCARNATION_SKILL = arrn228;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                BEBINNER_PARTY = true;
                WASH_HP_LIMIT = 99999;
                int[] arrn229 = new int[3];
                arrn229[0] = 30;
                arrn229[1] = 30;
                arrn229[2] = 2;
                DojoPoints = arrn229;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.25;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn230 = new int[1];
                arrn230[0] = 910000000;
                FISH_MAP = arrn230;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 5000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                NEW_ITEM_SAVE = true;
                CANUSE_4CASH = true;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                DUE_DATE = "2020-07-02";
                DELAY_CHECK = false;
                SELL_MESO_LIMIT = 1000000000;
                MAX_STAT = 1999;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                DEFAULT_CHARSLOT = 6;
                COPTITEMCHECK_STRICT = true;
                DAMAGE_SYSTEM = true;
                EXPIRED = true;
                SERVER_ID = 89;
                return;
            }
            case 127: {
                COUNT_CHECK = false;
                EXPRingPartyUnlimit = true;
                int[][] arrarrn = new int[1][];
                int[] arrn = new int[2];
                arrn[0] = 8641020;
                arrn[1] = 2;
                arrarrn[0] = arrn;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 8641020;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 0;
                int[] arrn231 = new int[3];
                arrn231[0] = 1017;
                arrn231[1] = 10001019;
                arrn231[2] = 20001019;
                REINCARNATION_SKILL = arrn231;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                BEBINNER_PARTY = true;
                WASH_HP_LIMIT = 99999;
                int[] arrn232 = new int[3];
                arrn232[0] = 30;
                arrn232[1] = 30;
                arrn232[2] = 2;
                DojoPoints = arrn232;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn233 = new int[1];
                arrn233[0] = 910000000;
                FISH_MAP = arrn233;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 5000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                NEW_ITEM_SAVE = true;
                CANUSE_4CASH = true;
                FLY_CHAIR = true;
                DUE_DATE = "2020-11-07";
                DELAY_CHECK = false;
                SELL_MESO_LIMIT = 1000000000;
                MAX_STAT = 1999;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                DEFAULT_CHARSLOT = 6;
                COPTITEMCHECK_STRICT = true;
                LINEBOT = true;
                DAMAGE_SYSTEM = true;
                NEW_RECHARGE_ITEM = false;
                AUTO_CS_ITEM = true;
                CS_CLASSIFY = true;
                CHECK_SKILLJOB = false;
                SELL_SYSTEM = true;
                int[] arrn234 = new int[3];
                arrn234[0] = 5;
                arrn234[1] = 5;
                arrn234[2] = 60;
                ONLINEPOINT = arrn234;
                HOMOSEX = true;
                BAN_GM_KEY_MAP = false;
                SERVER_ID = 90;
                return;
            }
            case 128: {
                MAPLE_VERSION = (short)118;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 500;
                UNLIMITMPTOHP = false;
                DojoPoints_AllPass = true;
                int[] arrn = new int[3];
                arrn[0] = 150;
                arrn[1] = 300;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn235 = new int[3];
                arrn235[0] = 1;
                arrn235[1] = 10;
                arrn235[2] = 60;
                ONLINEPOINT = arrn235;
                int[] arrn236 = new int[1];
                arrn236[0] = 180000000;
                ONLINEPOINT_MAP = arrn236;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.25;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                int[] arrn237 = new int[1];
                arrn237[0] = 910000023;
                FISH_MAP = arrn237;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                AUTO_CS_ITEM = true;
                VIP_DONATEINTERVAL = 1000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 5;
                VIPPOINT = true;
                int[] arrn238 = new int[2];
                arrn238[0] = 2109998;
                arrn238[1] = 2009999;
                NO_CONSUME_ITEM = arrn238;
                NEW_RECHARGE_ITEM = false;
                int[][] arrarrn = new int[1][];
                int[] arrn239 = new int[2];
                arrn239[0] = 8641020;
                arrn239[1] = 2;
                arrarrn[0] = arrn239;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 8641020;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 0x1116F6;
                int[] arrn240 = new int[3];
                arrn240[0] = 1005;
                arrn240[1] = 10001005;
                arrn240[2] = 20001005;
                REINCARNATION_SKILL = arrn240;
                int[] arrn241 = new int[8];
                arrn241[0] = 910001003;
                arrn241[1] = 910001004;
                arrn241[2] = 910001005;
                arrn241[3] = 910001006;
                arrn241[4] = 910001007;
                arrn241[5] = 910001008;
                arrn241[6] = 910001009;
                arrn241[7] = 910001010;
                SKILLDISABLE_MAP = arrn241;
                int[] arrn242 = new int[2];
                arrn242[0] = 0;
                arrn242[1] = 2;
                GASHAPON_RANDOM_SCROLL = arrn242;
                MAX_SLOT = true;
                PKARMACANCUT = true;
                UPGRADESLOT_CHECK = false;
                ARAN_COMBO_TIME = 10000L;
                NO_BULLET_CONSUME = true;
                DELAY_CHECK = false;
                MAX_STAT = 1999;
                SERVER_ID = 91;
                DAMAGE_SYSTEM = true;
                CS_CLASSIFY = true;
                MAPOWNER_SYSTEM = false;
                FLY_CHAIR = true;
                MERCHANT_ID = "3195349";
                HASHKEY = "II2hBvOevYsBo5xm";
                HASHIV = "At5SOm5BypqVeOPp";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://star.bobolinebot.tk";
                LINEBOT = true;
                CHECK_SKILLJOB = false;
                return;
            }
            case 129: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                MOB_COUNT_RATE = 2.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 399999L;
                WASH_HP_LIMIT = 1000;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn243 = new int[4];
                arrn243[0] = 910000000;
                arrn243[1] = 749050500;
                arrn243[2] = 749050501;
                arrn243[3] = 749050502;
                ONLINEPOINT_MAP = arrn243;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 15.0;
                arrd[2] = 2.0;
                arrd[3] = 0.3333333333333333;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn244 = new int[1];
                arrn244[0] = 910000000;
                FISH_MAP = arrn244;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                SHOWEVENTMSG = true;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 5000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPPOINT = true;
                AUTO_CS_ITEM = true;
                int[] arrn245 = new int[2];
                arrn245[0] = 1114300;
                arrn245[1] = 0x110121;
                PETVAC_EQUIP = arrn245;
                FLY_CHAIR = true;
                int[] arrn246 = new int[3];
                arrn246[0] = 0;
                arrn246[1] = 0;
                arrn246[2] = 1;
                DojoPoints = arrn246;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                PKARMACANCUT = true;
                HOMOSEX = true;
                FAMILY_SYSTEM = false;
                CHECK_COPYITEM_CLEAR = false;
                COPTITEMCHECK_STRICT = false;
                MAX_STAT = 1999;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://waterms.bobolinebot.tk";
                LINEBOT = true;
                DUE_DATE = "2020-08-12";
                BUYBACK_SYSTEM = true;
                DAMAGE_SYSTEM = true;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                MOB_COUNT_RATE = 2.0;
                MAP_RANDOM_MOB = true;
                int[] arrn247 = new int[4];
                arrn247[0] = 100000000;
                arrn247[1] = 103000000;
                arrn247[2] = 102000000;
                arrn247[3] = 101000000;
                MAP_RANDOM_MAPID = arrn247;
                int[] arrn248 = new int[1];
                arrn248[0] = 9410066;
                MAP_RANDOM_MOBID = arrn248;
                MAP_RANDOM_TIME = 6;
                MAP_RANDOM_MOBHP = 250000;
                int[] arrn249 = new int[3];
                arrn249[0] = 3;
                arrn249[1] = 25;
                arrn249[2] = 25;
                EVENTMOB_POINTS = arrn249;
                EXPIRED = true;
                SERVER_ID = 92;
                return;
            }
            case 130: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CANUSE_4CASH = true;
                AUTO_CS_ITEM = true;
                UNLIMITMPTOHP = true;
                WASH_HP_LIMIT = 999;
                int[] arrn = new int[3];
                arrn[0] = 8;
                arrn[1] = 8;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 120;
                EXPRingPartyUnlimit = true;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[] arrn250 = new int[1];
                arrn250[0] = 910000000;
                FISH_MAP = arrn250;
                BUYBACK_SYSTEM = true;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.07142857142857142;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                MAX_DAMAGE = 300000L;
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                ARAN_COMBO_TIME = 12000L;
                BANIP = false;
                MAPOWNER_SYSTEM = false;
                double[][] arrarrd = new double[8][];
                double[] arrd14 = new double[2];
                arrd14[0] = 2.110601E8;
                arrd14[1] = 3.0;
                arrarrd[0] = arrd14;
                double[] arrd15 = new double[2];
                arrd15[0] = 2.110603E8;
                arrd15[1] = 3.0;
                arrarrd[1] = arrd15;
                double[] arrd16 = new double[2];
                arrd16[0] = 2.110605E8;
                arrd16[1] = 3.0;
                arrarrd[2] = arrd16;
                double[] arrd17 = new double[2];
                arrd17[0] = 2.110607E8;
                arrd17[1] = 3.0;
                arrarrd[3] = arrd17;
                double[] arrd18 = new double[2];
                arrd18[0] = 2.110609E8;
                arrd18[1] = 3.0;
                arrarrd[4] = arrd18;
                double[] arrd19 = new double[2];
                arrd19[0] = 2.1106081E8;
                arrd19[1] = 3.0;
                arrarrd[5] = arrd19;
                double[] arrd20 = new double[2];
                arrd20[0] = 2.1106082E8;
                arrd20[1] = 3.0;
                arrarrd[6] = arrd20;
                double[] arrd21 = new double[2];
                arrd21[0] = 2.1106083E8;
                arrd21[1] = 3.0;
                arrarrd[7] = arrd21;
                EXTRA_SPAWNMAP = arrarrd;
                CHECKMOVE = false;
                LINEBOT = true;
                FreeSlot = true;
                CREATE_RESIST = false;
                CHECK_TAKE_DAMAGE = false;
                IP_CHANNEL_LIMIT = 999999;
                FOWARD_PROTECT = true;
                PROXY_IP = true;
                ATTACKRANGE_CHECK = false;
                EXPIRED = true;
                SERVER_ID = 93;
                return;
            }
            case 131: {
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = false;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 2000;
                UNLIMITMPTOHP = false;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 10.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.03333333333333333;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn251 = new int[1];
                arrn251[0] = 910000000;
                FISH_MAP = arrn251;
                EXPRingPartyUnlimit = false;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                SHOWEVENTMSG = true;
                MAX_SLOT = true;
                MAX_STAT = 999;
                GIVEALL_PETSKILL = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 5000;
                VIPPOINT = false;
                EXPRingPartyUnlimit = true;
                USE_CRYPT_KEY = true;
                int[] arrn252 = new int[1];
                arrn252[0] = 910000000;
                FISH_MAP = arrn252;
                FLY_CHAIR = true;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                CRYPT_KEY = 90;
                AUTO_CS_ITEM = true;
                SPECIAL_CRYPT = true;
                SPECIAL_CRYPT_AES = "vPkHsmgV5hqRCn93";
                SPECIAL_CRYPT_IV = "2xvTQpkmGWN6EsbU";
                MOB_COUNT_RATE = 1.5;
                MAX_STAT = 1250;
                SELL_SYSTEM = true;
                EXPIRED = true;
                SERVER_ID = 94;
                return;
            }
            case 132: {
                EXP_RATE = 1;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 999999;
                UNLIMITMPTOHP = false;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 1;
                arrn[2] = 10;
                ONLINEPOINT = arrn;
                int[] arrn253 = new int[1];
                arrn253[0] = 910000000;
                ONLINEPOINT_MAP = arrn253;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn254 = new int[1];
                arrn254[0] = 910000000;
                FISH_MAP = arrn254;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                GIVEALL_PETSKILL = false;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                EXPIRED = true;
                SERVER_ID = 95;
                return;
            }
            case 133: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = false;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 500;
                int[] arrn = new int[3];
                arrn[0] = 20;
                arrn[1] = 20;
                arrn[2] = 2;
                DojoPoints = arrn;
                double[] arrd = new double[5];
                arrd[0] = 2.0;
                arrd[1] = 2.0;
                arrd[2] = 2.0;
                arrd[3] = 1.0;
                arrd[4] = 6000.0;
                MobDropPOINT = arrd;
                MobDropPOINT_LEVEL = true;
                FreeSlot = true;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                CS_FACTORYOPEN = true;
                SPECIAL_CRYPT = true;
                USE_CRYPT_KEY = true;
                CRYPT_KEY = 111;
                SPECIAL_CRYPT_AES = "6N5FmgmbNKurWBBs";
                SPECIAL_CRYPT_IV = "5t4gKcRWkWhQ2dcN";
                NORA_SHIELD = true;
                DUE_DATE = "2020-06-14";
                SERVER_ID = 96;
                return;
            }
            case 134: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 5;
                DROP_RATE = 2;
                WASH_HP_LIMIT = 99999;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                ONLINEPOINT_MAP = arrn;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 300.0;
                MobDropPOINT = arrd;
                int[] arrn255 = new int[1];
                arrn255[0] = 910000000;
                FISH_MAP = arrn255;
                MAXLEVEL_KOC = 250;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                int[] arrn256 = new int[10];
                arrn256[0] = 1000;
                arrn256[1] = 3000;
                arrn256[2] = 5000;
                arrn256[3] = 15000;
                arrn256[4] = 20000;
                arrn256[5] = 25000;
                arrn256[6] = 30000;
                arrn256[7] = 35000;
                arrn256[8] = 40000;
                arrn256[9] = 50000;
                VIP_DONATE_INTERVAL = arrn256;
                VIP_LEVELMAX = 10;
                VIPEXP = true;
                VIPDROP = true;
                VIPPOINT = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                BANK_SYSTEM = true;
                int[] arrn257 = new int[2];
                arrn257[0] = 1002824;
                arrn257[1] = 1052170;
                CREAT_EQUIPS_MALE = arrn257;
                int[] arrn258 = new int[2];
                arrn258[0] = 1002824;
                arrn258[1] = 1052170;
                CREAT_EQUIPS_FEMALE = arrn258;
                int[] arrn259 = new int[2];
                arrn259[0] = 911006100;
                arrn259[1] = 910000000;
                FISH_MAP = arrn259;
                int[][] arrarrn = new int[2][];
                int[] arrn260 = new int[2];
                arrn260[0] = 9700030;
                arrn260[1] = 2;
                arrarrn[0] = arrn260;
                int[] arrn261 = new int[2];
                arrn261[0] = 9700031;
                arrn261[1] = 2;
                arrarrn[1] = arrn261;
                REINCARNATION_MOB = arrarrn;
                MERCHANT_ID = "3200371";
                HASHKEY = "4mrdHkjsAycILYxb";
                HASHIV = "dCpdQEs5BpjMc2qt";
                LINEBOT_URL = "https://kingms.bobolinebot.tk";
                BACCARAT_SYSTEM = true;
                int[] arrn262 = new int[2];
                arrn262[0] = 20;
                arrn262[1] = 910000000;
                BACCARAT_LOCATION = arrn262;
                STORAGE_EXCEED = true;
                ECPAY_IP = "211.21.200.106";
                IP_CHANNEL_LIMIT = 999999;
                SELL_SYSTEM = true;
                CHECK_SKILLJOB = false;
                MAX_STAT = 1999;
                ACCURATE_DMG_TO_MOB = false;
                HACKPASSWORDSHA1 = "cbf09dffd57430281da1c50832781b0cf1ae336c";
                BACCARAT_SYSTEM = true;
                int[] arrn263 = new int[2];
                arrn263[0] = 20;
                arrn263[1] = 910000000;
                BACCARAT_LOCATION = arrn263;
                SERVER_ID = 97;
                return;
            }
            case 135: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                EXP_LOWVERSION = true;
                EXPIRED = true;
                SERVER_ID = 98;
                return;
            }
            case 136: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 2;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 1000;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 1;
                DojoPoints = arrn;
                int[] arrn264 = new int[3];
                arrn264[0] = 5;
                arrn264[1] = 15;
                arrn264[2] = 60;
                ONLINEPOINT = arrn264;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 1.0;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn265 = new int[1];
                arrn265[0] = 910000000;
                FISH_MAP = arrn265;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 1500;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 5000;
                VIPEXP = true;
                VIPEXP_INTERVAL = 0.1;
                VIPDROP = true;
                VIPDROP_INTERVAL = 0.1;
                VIP_LEVELMAX = 5;
                VIPPOINT = false;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                POTENTIAL_SYSTEM = true;
                AUTO_CS_ITEM = true;
                DELAY_CHECK = false;
                EXPIRED = true;
                SERVER_ID = 99;
                return;
            }
            case 137: {
                MAPLE_VERSION = (short)118;
                int[] arrn = new int[1];
                arrn[0] = 29903;
                QUEST_REMOVE = arrn;
                int[][] arrarrn = new int[1][];
                int[] arrn266 = new int[2];
                arrn266[0] = 9990088;
                arrn266[1] = 2;
                arrarrn[0] = arrn266;
                REINCARNATION_MOB = arrarrn;
                int[] arrn267 = new int[1];
                arrn267[0] = 2108888;
                NO_CONSUME_ITEM = arrn267;
                DUE_DATE = "2020-07-09";
                EXPIRED = true;
                return;
            }
            case 138: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                BEBINNER_PARTY = false;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 500;
                FreeSlot = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                EXPIRED = true;
                return;
            }
            case 139: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 2;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 1499999L;
                WASH_HP_LIMIT = 99999;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn268 = new int[3];
                arrn268[0] = 1;
                arrn268[1] = 10;
                arrn268[2] = 60;
                ONLINEPOINT = arrn268;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn269 = new int[1];
                arrn269[0] = 910000000;
                FISH_MAP = arrn269;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 255;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                GMBUFF_LIMIT = false;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = false;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                CANUSE_4CASH = true;
                int[] arrn270 = new int[2];
                arrn270[0] = 0x110441;
                arrn270[1] = 1115202;
                PETVAC_EQUIP = arrn270;
                int[][] arrarrn = new int[1][];
                int[] arrn271 = new int[2];
                arrn271[0] = 9700039;
                arrn271[1] = 2;
                arrarrn[0] = arrn271;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9700039;
                REINCARNATION_SKILL_SYSTEM = true;
                int[] arrn272 = new int[1];
                arrn272[0] = 10001019;
                REINCARNATION_SKILL = arrn272;
                CS_CLASSIFY = true;
                SELL_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                FreeSlot = true;
                BACCARAT_SYSTEM = true;
                int[] arrn273 = new int[2];
                arrn273[0] = 19;
                arrn273[1] = 910000000;
                BACCARAT_LOCATION = arrn273;
                FORCECHANGEPWD = true;
                DAMAGE_SYSTEM = true;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                int[] arrn274 = new int[1];
                arrn274[0] = 3010001;
                CREAT_GIFTS = arrn274;
                PEE_SYSTEM = true;
                PEETOPOO = true;
                PEE_CHAIR = 4031997;
                WHISPET_FIND = true;
                LINEBOT_URL = "https://heart.bobolinebot.tk";
                LINEBOT = true;
                FISH_KING = true;
                LOG_ACCPWD = true;
                ATTACKRANGE_CHECK = false;
                DAMAGE_SKIN = true;
                SERVER_ID = 100;
                return;
            }
            case 140: 
            case 141: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = false;
                MAX_DAMAGE = 199999L;
                int[] arrn = new int[3];
                arrn[0] = 15;
                arrn[1] = 15;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 6000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn275 = new int[1];
                arrn275[0] = 910000000;
                FISH_MAP = arrn275;
                MAXLEVEL = 251;
                MAXLEVEL_KOC = 251;
                SHOWEVENTMSG = true;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIPSYSTEM = true;
                int[] arrn276 = new int[5];
                arrn276[0] = 1000;
                arrn276[1] = 3000;
                arrn276[2] = 5000;
                arrn276[3] = 10000;
                arrn276[4] = 30000;
                VIP_DONATE_INTERVAL = arrn276;
                VIP_LEVELMAX = 20;
                VIPEXP = true;
                VIPDROP = true;
                VIPPOINT = true;
                DUE_DATE = "2020-09-11";
                AUTO_CS_ITEM = true;
                int[][] arrarrn = new int[2][];
                int[] arrn277 = new int[2];
                arrn277[0] = 9990088;
                arrn277[1] = 2;
                arrarrn[0] = arrn277;
                int[] arrn278 = new int[2];
                arrn278[0] = 9990089;
                arrn278[1] = 2;
                arrarrn[1] = arrn278;
                REINCARNATION_MOB = arrarrn;
                FLY_CHAIR = true;
                ARAN_COMBO_CHECK = false;
                int[] arrn279 = new int[1];
                arrn279[0] = 1112000;
                PETVAC_EQUIP = arrn279;
                int[][] arrarrn2 = new int[1][];
                int[] arrn280 = new int[2];
                arrn280[0] = 9990088;
                arrn280[1] = 2;
                arrarrn2[0] = arrn280;
                REINCARNATION_MOB = arrarrn2;
                REINCARNATION_SKILL_MOB = 9990088;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1112974;
                int[] arrn281 = new int[1];
                arrn281[0] = 10001002;
                REINCARNATION_SKILL = arrn281;
                MERCHANT_ID = "3169233";
                HASHKEY = "saZXaH5HuHPkG6OZ";
                HASHIV = "WY8F32QPAzpPsFTt";
                ECPAY_SYSTEM = true;
                FM_DROP = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://pepe.bobolinebot.tk";
                LINEBOT = true;
                SELL_SYSTEM = true;
                ARAN_COMBO_CHECK = false;
                DELAY_CHECK = false;
                CHECK_SKILLJOB = false;
                COUNT_CHECK = false;
                BAN_ARAN_KEY_MAP = false;
                EXPIRED = true;
                return;
            }
            case 142: {
                AUTO_CS_ITEM = true;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_COUNT_RATE = 1.2;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 99999;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 10;
                arrn[1] = 10;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn282 = new int[3];
                arrn282[0] = 3;
                arrn282[1] = 8;
                arrn282[2] = 60;
                ONLINEPOINT = arrn282;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 4500.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn283 = new int[1];
                arrn283[0] = 910000000;
                FISH_MAP = arrn283;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                SHOWEVENTMSG = true;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, SharkLogger.ALLATORIxDEMO("`ir"));
                MOB_COUNT_RATE = 1.5;
                DUE_DATE = "2020-07-26";
                BUYBACK_SYSTEM = true;
                SELL_SYSTEM = true;
                MAX_STAT = 2999;
                EXPIRED = true;
                return;
            }
            case 143: {
                MAPLE_VERSION = (short)113;
                int[] arrn = new int[3];
                arrn[0] = 1002;
                arrn[1] = 10001002;
                arrn[2] = 20001002;
                MOBVAC_SKILL = arrn;
                EXP_RATE = 5;
                DROP_RATE = 3;
                MESO_RATE = 1;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 999999;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn284 = new int[1];
                arrn284[0] = 910000000;
                FISH_MAP = arrn284;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                CANUSE_4CASH = true;
                AUTO_JOB = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://meimeims.bobolinebot.tk";
                BACCARAT_SYSTEM = true;
                int[] arrn285 = new int[2];
                arrn285[0] = 20;
                arrn285[1] = 910000000;
                BACCARAT_LOCATION = arrn285;
                int[] arrn286 = new int[1];
                arrn286[0] = 1112180;
                PETVAC_EQUIP = arrn286;
                CHANGE_CHANNEL_CHECK = false;
                MAX_STAT = 9999;
                BUYBACK_SYSTEM = true;
                FISH_KING = true;
                VIPSYSTEM = true;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                VIPAUTOGIVE = true;
                VIP_DONATEINTERVAL = 2000;
                CHECK_SKILLJOB = false;
                int[] arrn287 = new int[2];
                arrn287[0] = 2002052;
                arrn287[1] = 2002053;
                NO_CONSUME_ITEM = arrn287;
                byte[] arrby = new byte[32];
                arrby[0] = 19;
                arrby[1] = 0;
                arrby[2] = 0;
                arrby[3] = 0;
                arrby[4] = 8;
                arrby[5] = 0;
                arrby[6] = 0;
                arrby[7] = 0;
                arrby[8] = 6;
                arrby[9] = 0;
                arrby[10] = 0;
                arrby[11] = 0;
                arrby[12] = -121;
                arrby[13] = 0;
                arrby[14] = 0;
                arrby[15] = 0;
                arrby[16] = 27;
                arrby[17] = 0;
                arrby[18] = 0;
                arrby[19] = 0;
                arrby[20] = 15;
                arrby[21] = 0;
                arrby[22] = 0;
                arrby[23] = 0;
                arrby[24] = 51;
                arrby[25] = 0;
                arrby[26] = 0;
                arrby[27] = 0;
                arrby[28] = 82;
                arrby[29] = 0;
                arrby[30] = 0;
                arrby[31] = 0;
                SKEY = new SecretKeySpec(arrby, MobSkillData.ALLATORIxDEMO("L%^"));
                PROXY_IP = true;
                MAP_RANDOM_MOB = true;
                MAP_RANDOM_TIME = 3;
                int[] arrn288 = new int[1];
                arrn288[0] = 910000000;
                MAP_RANDOM_MAPID = arrn288;
                int[] arrn289 = new int[1];
                arrn289[0] = 100102;
                MAP_RANDOM_MOBID = arrn289;
                MAP_RANDOM_MOBHP = 20000000;
                SHOWMAPMOB_LOCATION = true;
                SELL_SYSTEM = true;
                MOB_VAC_DETECT = false;
                CHECK_COPYITEM_CLEAR = true;
                DELAY_CHECK = false;
                int[] arrn290 = new int[1];
                arrn290[0] = 910000000;
                FISH_MAP = arrn290;
                PKARMACANCUT = true;
                ECPAY_IP = "35.236.170.249";
                EXPIRED = true;
                return;
            }
            case 144: {
                CANUSE_4CASH = true;
                AUTO_CS_ITEM = true;
                int[][] arrarrn = new int[1][];
                int[] arrn = new int[2];
                arrn[0] = 9800030;
                arrn[1] = 2;
                arrarrn[0] = arrn;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9800030;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1113227;
                int[] arrn291 = new int[3];
                arrn291[0] = 1017;
                arrn291[1] = 10001019;
                arrn291[2] = 20001019;
                REINCARNATION_SKILL = arrn291;
                EXP_RATE = 3;
                BEBINNER_PARTY = true;
                WASH_HP_LIMIT = 1000;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 1.0;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                MAX_SLOT = true;
                int[] arrn292 = new int[1];
                arrn292[0] = 910000000;
                FISH_MAP = arrn292;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                CS_FACTORYOPEN = true;
                SELL_SYSTEM = true;
                FLY_CHAIR = true;
                MAX_STAT = 9999;
                PKARMACANCUT = true;
                SAVEBUFF = true;
                ARAN_COMBO_CHECK = false;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://flyms.bobolinebot.tk";
                LINEBOT = true;
                MERCHANT_ID = "3007961";
                HASHKEY = "Wf4a8vWRBT1tKqFP";
                HASHIV = "uwndqGvf7oZ9FrEf";
                DELAY_CHECK = false;
                DAMAGE_SYSTEM = true;
                EXPIRED = true;
                return;
            }
            case 145: {
                EXP_RATE = 2;
                MOB_COUNT_RATE = 1.5;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 200;
                arrn[1] = 200;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 15.0;
                arrd[1] = 15.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                int[] arrn293 = new int[1];
                arrn293[0] = 910000000;
                FISH_MAP = arrn293;
                MAXLEVEL = 250;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                GIVEALL_PETSKILL = false;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 2000;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPPOINT = false;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                CANUSE_4CASH = true;
                CS_CLASSIFY = true;
                SELL_SYSTEM = true;
                LOGIN_SIGNLOG = true;
                STORAGE_EXCEED = true;
                BUYBACK_SYSTEM = true;
                int[] arrn294 = new int[1];
                arrn294[0] = 1132230;
                PETVAC_EQUIP = arrn294;
                int[] arrn295 = new int[1];
                arrn295[0] = 2435764;
                NO_CONSUME_ITEM = arrn295;
                MOB_COUNT_RATE = 1.5;
                HOMOSEX = true;
                CREATE_KOC = false;
                ARAN_COMBO_CHECK = false;
                COUNT_CHECK = false;
                DUE_DATE = "2020-09-01";
                EXPIRED = true;
                return;
            }
            case 146: {
                AUTO_CS_ITEM = true;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 99999;
                UNLIMITMPTOHP = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                FLY_CHAIR = true;
                int[][] arrarrn = new int[1][];
                int[] arrn296 = new int[2];
                arrn296[0] = 9700039;
                arrn296[1] = 2;
                arrarrn[0] = arrn296;
                REINCARNATION_MOB = arrarrn;
                NEW_RECHARGE_ITEM = false;
                SPECIAL_EQUIP = true;
                MERCHANT_ID = "3216412";
                HASHKEY = "Scoha6lR3po4E3lu";
                HASHIV = "9fceuP17AeB4y2st";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://skull.bobolinebot.tk";
                LINEBOT = true;
                SELL_SYSTEM = true;
                DUE_DATE = "2020-09-28";
                EXPIRED = true;
                return;
            }
            case 147: {
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                BOSS_HPRATE = 1.0;
                POTENTIAL_SYSTEM = true;
                AUTO_CS_ITEM = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn297 = new int[3];
                arrn297[0] = 5;
                arrn297[1] = 20;
                arrn297[2] = 60;
                ONLINEPOINT = arrn297;
                int[] arrn298 = new int[1];
                arrn298[0] = 910000000;
                ONLINEPOINT_MAP = arrn298;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 25.0;
                arrd[2] = 2.0;
                arrd[3] = 0.3;
                arrd[4] = 16888.0;
                MobDropPOINT = arrd;
                int[] arrn299 = new int[1];
                arrn299[0] = 910000000;
                FISH_MAP = arrn299;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_STAT = 1999;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 3000;
                VIPPOINT = true;
                VIPEXP = true;
                VIPDROP = true;
                DAMAGE_SYSTEM = true;
                CANUSE_4CASH = true;
                FLY_CHAIR = true;
                SAVEBUFF = true;
                LOGIN_SIGNLOG = true;
                COMMAND_NAME = false;
                int[][] arrarrn = new int[2][];
                int[] arrn300 = new int[2];
                arrn300[0] = 9700039;
                arrn300[1] = 2;
                arrarrn[0] = arrn300;
                int[] arrn301 = new int[2];
                arrn301[0] = 9700040;
                arrn301[1] = 2;
                arrarrn[1] = arrn301;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9700039;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1112940;
                int[] arrn302 = new int[1];
                arrn302[0] = 1001;
                REINCARNATION_SKILL = arrn302;
                int[] arrn303 = new int[1];
                arrn303[0] = 1112943;
                PETVAC_EQUIP = arrn303;
                SELL_SYSTEM = true;
                int[] arrn304 = new int[1];
                arrn304[0] = 2022457;
                NO_CONSUME_ITEM = arrn304;
                CS_CLASSIFY = true;
                LINEBOT = true;
                MERCHANT_ID = "3214800";
                HASHKEY = "MOrioCfzrXtWwQZ9";
                HASHIV = "xWkLvWuacNHzMOra";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://yaoshou.bobolinebot.tk";
                DUE_DATE = "2020-11-09";
                MAX_SLOT = true;
                PET_VAC_CHECK = false;
                HOMOSEX = true;
                BAN_ARAN_KEY_MAP = false;
                CHECK_SKILLJOB = false;
                BEBINNER_PARTY = true;
                DAMAGE_SKIN = true;
                return;
            }
            case 148: {
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 2;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 199999L;
                WASH_HP_LIMIT = 10000;
                UNLIMITMPTOHP = false;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 20.0;
                arrd[2] = 2.0;
                arrd[3] = 0.4;
                arrd[4] = 10000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn = new int[1];
                arrn[0] = 910000000;
                FISH_MAP = arrn;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 1500;
                CS_FACTORYOPEN = true;
                IP_GEO_SYSTEM = true;
                AUTO_CS_ITEM = true;
                MOB_COUNT_RATE = 2.0;
                VPOINT_NAME = "\u599e\u599e";
                FLY_CHAIR = true;
                MERCHANT_ID = "3063850";
                HASHKEY = "TI4DrhQzxZgsS09n";
                HASHIV = "BBkkWxGqMsawB2xY";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://newniu.bobolinebot.tk";
                LINEBOT = true;
                int[] arrn305 = new int[3];
                arrn305[0] = 1;
                arrn305[1] = 10;
                arrn305[2] = 60;
                ONLINEPOINT = arrn305;
                int[][] arrarrn = new int[2][];
                int[] arrn306 = new int[2];
                arrn306[0] = 9800032;
                arrn306[1] = 2;
                arrarrn[0] = arrn306;
                int[] arrn307 = new int[2];
                arrn307[0] = 9800033;
                arrn307[1] = 2;
                arrarrn[1] = arrn307;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9800032;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1113227;
                int[] arrn308 = new int[1];
                arrn308[0] = 1017;
                REINCARNATION_SKILL = arrn308;
                SELL_SYSTEM = true;
                FISH_KING = true;
                ARAN_COMBO_CHECK = false;
                BAN_ARAN_KEY_MAP = false;
                CHECK_SKILLJOB = false;
                return;
            }
            case 149: {
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 500;
                int[] arrn = new int[3];
                arrn[0] = 150;
                arrn[1] = 300;
                arrn[2] = 2;
                DojoPoints = arrn;
                DojoPoints_AllPass = true;
                int[] arrn309 = new int[1];
                arrn309[0] = 910000000;
                ONLINEPOINT_MAP = arrn309;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 10000.0;
                MobDropPOINT = arrd;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                SHOWEVENTMSG = true;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                GIVEALL_PETSKILL = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                AUTO_CS_ITEM = true;
                int[] arrn310 = new int[1];
                arrn310[0] = 910000000;
                FISH_MAP = arrn310;
                int[][] arrarrn = new int[1][];
                int[] arrn311 = new int[2];
                arrn311[0] = 8700000;
                arrn311[1] = 2;
                arrarrn[0] = arrn311;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 8700000;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1115141;
                int[] arrn312 = new int[1];
                arrn312[0] = 1005;
                REINCARNATION_SKILL = arrn312;
                int[] arrn313 = new int[1];
                arrn313[0] = 1115132;
                PETVAC_EQUIP = arrn313;
                int[] arrn314 = new int[1];
                arrn314[0] = 2109900;
                NO_CONSUME_ITEM = arrn314;
                SELL_SYSTEM = true;
                DUE_DATE = "2020-10-22";
                MERCHANT_ID = "3180347";
                HASHKEY = "yoTxB6VgJ4Q3fVDy";
                HASHIV = "9uDNc1Ckuk7t6w0y";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://dream.bobolinebot.tk";
                LINEBOT = true;
                ECPAY_IP = "srv2-shine.access.ly";
                return;
            }
            case 150: {
                MAPLE_VERSION = (short)135;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 1999999L;
                WASH_HP_LIMIT = 2000;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 3;
                arrn[1] = 3;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn315 = new int[3];
                arrn315[0] = 5;
                arrn315[1] = 15;
                arrn315[2] = 60;
                ONLINEPOINT = arrn315;
                int[] arrn316 = new int[4];
                arrn316[0] = 910000000;
                arrn316[1] = 749050500;
                arrn316[2] = 749050501;
                arrn316[3] = 749050502;
                ONLINEPOINT_MAP = arrn316;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 4000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 2000;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                SERVER_ID = 101;
                int[][] arrarrn = new int[2][];
                int[] arrn317 = new int[2];
                arrn317[0] = 9800142;
                arrn317[1] = 2;
                arrarrn[0] = arrn317;
                int[] arrn318 = new int[2];
                arrn318[0] = 9800143;
                arrn318[1] = 2;
                arrarrn[1] = arrn318;
                REINCARNATION_MOB = arrarrn;
                CS_CLASSIFY = true;
                SELL_SYSTEM = true;
                PEE_SYSTEM = true;
                MORE_OPEN = 2;
                PEE_CHAIR = 2103004;
                CHECK_TAKE_DAMAGE = false;
                MUTIPLE_AURA = true;
                COUNT_CHECK = false;
                return;
            }
            case 151: {
                MAPLE_VERSION = (short)151;
                MAPLE_PATCH = "2";
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                DAMAGE_SKIN = true;
                CS_FACTORYOPEN = true;
                BUYBACK_SYSTEM = true;
                COMPRESS_ITEM = false;
                CHECK_TAKE_DAMAGE = false;
                CHECKONEHUNDRED = false;
                CS_CLASSIFY = true;
                CANUSE_4CASH = true;
                HACKPASSWORDSHA1 = "d2091b46ff788519fa25898a5d82df48f6b79f0a";
                CHOOSE_JOB = true;
                int[][] arrarrn = new int[2][];
                int[] arrn = new int[2];
                arrn[0] = 9700031;
                arrn[1] = 2;
                arrarrn[0] = arrn;
                int[] arrn319 = new int[2];
                arrn319[0] = 9700032;
                arrn319[1] = 4;
                arrarrn[1] = arrn319;
                REINCARNATION_MOB = arrarrn;
                BANK_SYSTEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn320 = new int[2];
                arrn320[0] = 20;
                arrn320[1] = 910000000;
                BACCARAT_LOCATION = arrn320;
                SELL_SYSTEM = true;
                MAX_SLOT = true;
                int[] arrn321 = new int[1];
                arrn321[0] = 910000000;
                FISH_MAP = arrn321;
                FreeSlot = true;
                LEGEND_CHANCE = 100;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 50000.0;
                MobDropPOINT = arrd;
                MERCHANT_ID = "1052601";
                HASHKEY = "aM31fpNusLzDWIwO";
                HASHIV = "F6P9fkwcdn2MyNMQ";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                ECPAY_INVOICE = true;
                LINEBOT = true;
                LINEBOT_URL = "https://pinkms.bobolinebot.tk";
                ECPAY_IP = "211.21.200.106";
                LOGIN_SIGNLOG = true;
                DEFAULT_CHARSLOT = 15;
                MAX_STAT = 1999;
                HOMOSEX = true;
                SERVER_ID = 102;
                MAX_DAMAGE = Integer.MAX_VALUE;
                SELL_SYSTEM = true;
                PEE_SYSTEM = true;
                return;
            }
            case 152: {
                MAPLE_VERSION = (short)135;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CS_CLASSIFY = true;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = false;
                MAX_DAMAGE = 999999L;
                WASH_HP_LIMIT = 99999;
                int[] arrn = new int[3];
                arrn[0] = 3;
                arrn[1] = 5;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn322 = new int[1];
                arrn322[0] = 910000000;
                ONLINEPOINT_MAP = arrn322;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn323 = new int[1];
                arrn323[0] = 910000000;
                FISH_MAP = arrn323;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 9999;
                CS_FACTORYOPEN = true;
                CANUSE_4CASH = true;
                CREATE_RESIST = false;
                NEW_RECHARGE_ITEM = false;
                CREATE_EVAN = false;
                SAVEBUFF = true;
                SELL_SYSTEM = true;
                SERVER_ID = 103;
                return;
            }
            case 153: {
                MERCHANT_ID = "3030858";
                HASHKEY = "1FzTvCVLO26aXOrZ";
                HASHIV = "kHZnd6sxaJy4Vj3Z";
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                int[] arrn = new int[3];
                arrn[0] = 50;
                arrn[1] = 50;
                arrn[2] = 30;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 3.0;
                arrd[1] = 5.0;
                arrd[2] = 2.0;
                arrd[3] = 0.2;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn324 = new int[1];
                arrn324[0] = 910000000;
                FISH_MAP = arrn324;
                MAXLEVEL = 251;
                MAXLEVEL_KOC = 251;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                int[] arrn325 = new int[8];
                arrn325[0] = 1000;
                arrn325[1] = 3000;
                arrn325[2] = 5000;
                arrn325[3] = 10000;
                arrn325[4] = 15000;
                arrn325[5] = 20000;
                arrn325[6] = 30000;
                arrn325[7] = 50000;
                VIP_DONATE_INTERVAL = arrn325;
                VIPEXP = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPPOINT = true;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                DUE_DATE = "2020-12-29";
                LOGIN_SIGNLOG = true;
                int[][] arrarrn = new int[1][];
                int[] arrn326 = new int[2];
                arrn326[0] = 9990089;
                arrn326[1] = 2;
                arrarrn[0] = arrn326;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9990089;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 0x111EE1;
                int[] arrn327 = new int[1];
                arrn327[0] = 20001001;
                REINCARNATION_SKILL = arrn327;
                SELL_SYSTEM = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://mystery.bobolinebot.tk";
                LINEBOT = true;
                ECPAY_IP = "srv6-shine.access.ly";
                CS_CLASSIFY = true;
                HOMOSEX = true;
                SERVER_ID = 104;
                DAMAGE_SKIN = true;
                return;
            }
            case 154: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 2000;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 3;
                arrn[1] = 3;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn328 = new int[3];
                arrn328[0] = 10;
                arrn328[1] = 20;
                arrn328[2] = 60;
                ONLINEPOINT = arrn328;
                int[] arrn329 = new int[4];
                arrn329[0] = 910000000;
                arrn329[1] = 749050500;
                arrn329[2] = 749050501;
                arrn329[3] = 749050502;
                ONLINEPOINT_MAP = arrn329;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn330 = new int[1];
                arrn330[0] = 910000000;
                FISH_MAP = arrn330;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 2000;
                GMBUFF_LIMIT = true;
                CS_FACTORYOPEN = true;
                BACCARAT_SYSTEM = true;
                int[] arrn331 = new int[2];
                arrn331[0] = 8;
                arrn331[1] = 910000000;
                BACCARAT_LOCATION = arrn331;
                int[] arrn332 = new int[2];
                arrn332[0] = 7;
                arrn332[1] = 910000000;
                NIUNIU_LOCATION = arrn332;
                NIUNIU_SYSTEM = true;
                int[][] arrarrn = new int[2][];
                int[] arrn333 = new int[2];
                arrn333[0] = 9800033;
                arrn333[1] = 2;
                arrarrn[0] = arrn333;
                int[] arrn334 = new int[2];
                arrn334[0] = 9800034;
                arrn334[1] = 2;
                arrarrn[1] = arrn334;
                REINCARNATION_MOB = arrarrn;
                FLY_CHAIR = true;
                SAVEBUFF = true;
                AUTO_CS_ITEM = true;
                CS_CLASSIFY = true;
                CANUSE_4CASH = true;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT_URL = "https://windms.bobolinebot.tk";
                LINEBOT = true;
                ECPAY_IP = "srv2-ns201024-y8UD9q.access.ly";
                SERVER_ID = 105;
                DELAY_CHECK = false;
                SELL_SYSTEM = true;
                MERCHANT_ID = "3180347";
                HASHKEY = "yoTxB6VgJ4Q3fVDy";
                HASHIV = "9uDNc1Ckuk7t6w0y";
                DUE_DATE = "2021-01-21";
                AUTOMONITOR = false;
                MONITOR = false;
                BAN_DELETE_CHARACTER = true;
                CS_STATE_CHECK = true;
                BUYBACK_SYSTEM = true;
                PACKET_CHECK = false;
                return;
            }
            case 155: {
                MAPLE_VERSION = (short)147;
                MAPLE_PATCH = "4";
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CANUSE_4CASH = true;
                CHOOSE_JOB = true;
                int[] arrn = new int[5];
                arrn[0] = 5000;
                arrn[1] = 10000;
                arrn[2] = 15000;
                arrn[3] = 20000;
                arrn[4] = 30000;
                VIP_DONATE_INTERVAL = arrn;
                SERVER_ID = 106;
                MAX_SLOT = true;
                int[] arrn335 = new int[3];
                arrn335[0] = 1;
                arrn335[1] = 10;
                arrn335[2] = 60;
                ONLINEPOINT = arrn335;
                VIPSYSTEM = true;
                VIPEXP = true;
                VIP_LEVELMAX = 5;
                VIPPOINT = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                MERCHANT_ID = "3022108";
                HASHKEY = "paBUFC0BmAkhmlYs";
                HASHIV = "T8jI3t6soY89t57H";
                MAP_RANDOM_MOB = true;
                int[] arrn336 = new int[4];
                arrn336[0] = 100000000;
                arrn336[1] = 103000000;
                arrn336[2] = 102000000;
                arrn336[3] = 101000000;
                MAP_RANDOM_MAPID = arrn336;
                SHOWMAPMOB_LOCATION = true;
                int[] arrn337 = new int[1];
                arrn337[0] = 9410070;
                MAP_RANDOM_MOBID = arrn337;
                MAP_RANDOM_TIME = 8;
                BACCARAT_SYSTEM = true;
                int[] arrn338 = new int[2];
                arrn338[0] = 20;
                arrn338[1] = 910000000;
                BACCARAT_LOCATION = arrn338;
                int[] arrn339 = new int[1];
                arrn339[0] = 1113135;
                PETVAC_EQUIP = arrn339;
                FOWARD_PROTECT = true;
                PROXY_IP = false;
                int[][] arrarrn = new int[2][];
                int[] arrn340 = new int[2];
                arrn340[0] = 9800142;
                arrn340[1] = 2;
                arrarrn[0] = arrn340;
                int[] arrn341 = new int[2];
                arrn341[0] = 9800143;
                arrn341[1] = 2;
                arrarrn[1] = arrn341;
                REINCARNATION_MOB = arrarrn;
                BANIP = false;
                AUTO_UPDATE = false;
                return;
            }
            case 156: {
                MAPLE_VERSION = (short)153;
                MAPLE_PATCH = "1";
                EXP_RATE = 4;
                DROP_RATE = 1;
                MESO_RATE = 3;
                CANUSE_4CASH = true;
                CHOOSE_JOB = true;
                MAX_DAMAGE = 19999999L;
                WASH_HP_LIMIT = 500;
                int[] arrn = new int[23];
                arrn[0] = 910000000;
                arrn[1] = 910000001;
                arrn[2] = 910000002;
                arrn[3] = 910000003;
                arrn[4] = 910000004;
                arrn[5] = 910000005;
                arrn[6] = 910000006;
                arrn[7] = 910000007;
                arrn[8] = 910000008;
                arrn[9] = 910000009;
                arrn[10] = 910000010;
                arrn[11] = 910000011;
                arrn[12] = 910000012;
                arrn[13] = 910000013;
                arrn[14] = 910000014;
                arrn[15] = 910000015;
                arrn[16] = 910000016;
                arrn[17] = 910000017;
                arrn[18] = 910000028;
                arrn[19] = 910000019;
                arrn[20] = 910000020;
                arrn[21] = 910000021;
                arrn[22] = 910000022;
                ONLINEPOINT_MAP = arrn;
                MAXLEVEL = 200;
                MAXLEVEL_KOC = 200;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                MobDropPOINT_LEVEL = true;
                VIPSYSTEM = true;
                VIP_DONATEINTERVAL = 3000;
                VIPEXP = true;
                VIP_LEVELMAX = 10;
                VIPPOINT = true;
                SERVER_ID = 107;
                return;
            }
            case 157: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 2.0;
                MAX_DAMAGE = 300000L;
                WASH_HP_LIMIT = 99999;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 30;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                FreeSlot = true;
                MAX_SLOT = true;
                MAXLEVEL = 200;
                MAXLEVEL_KOC = 200;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                CANUSE_4CASH = true;
                PEE_SYSTEM = true;
                MAPOWNER_SYSTEM = true;
                SAVEBUFF = true;
                int[][] arrarrn = new int[10][];
                int[] arrn342 = new int[2];
                arrn342[0] = 9700030;
                arrn342[1] = 1;
                arrarrn[0] = arrn342;
                int[] arrn343 = new int[2];
                arrn343[0] = 9700031;
                arrn343[1] = 1;
                arrarrn[1] = arrn343;
                int[] arrn344 = new int[2];
                arrn344[0] = 9700032;
                arrn344[1] = 1;
                arrarrn[2] = arrn344;
                int[] arrn345 = new int[2];
                arrn345[0] = 9700033;
                arrn345[1] = 2;
                arrarrn[3] = arrn345;
                int[] arrn346 = new int[2];
                arrn346[0] = 9700034;
                arrn346[1] = 2;
                arrarrn[4] = arrn346;
                int[] arrn347 = new int[2];
                arrn347[0] = 9700035;
                arrn347[1] = 2;
                arrarrn[5] = arrn347;
                int[] arrn348 = new int[2];
                arrn348[0] = 9700036;
                arrn348[1] = 2;
                arrarrn[6] = arrn348;
                int[] arrn349 = new int[2];
                arrn349[0] = 9700037;
                arrn349[1] = 5;
                arrarrn[7] = arrn349;
                int[] arrn350 = new int[2];
                arrn350[0] = 9700038;
                arrn350[1] = 5;
                arrarrn[8] = arrn350;
                int[] arrn351 = new int[2];
                arrn351[0] = 9700039;
                arrn351[1] = 5;
                arrarrn[9] = arrn351;
                REINCARNATION_MOB = arrarrn;
                SERVER_ID = 108;
                int[] arrn352 = new int[1];
                arrn352[0] = 0x111EE1;
                PETVAC_EQUIP = arrn352;
                CS_CLASSIFY = true;
                MERCHANT_ID = "3017316";
                HASHKEY = "ymAfW62egJbv52q7";
                HASHIV = "Q9nBXLeSHXFicBeh";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                ECPAY_IP = "srv-5.access.ly";
                LINEBOT_URL = "https://chacha.bobolinebot.tk";
                LINEBOT = true;
                REINCARNATION_SKILL_MOB = 9700034;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1112926;
                int[] arrn353 = new int[3];
                arrn353[0] = 1002;
                arrn353[1] = 10001002;
                arrn353[2] = 20001002;
                REINCARNATION_SKILL = arrn353;
                REGULAR_DROP_BONUS = true;
                REGULAR_BONUS = true;
                String[] arrstring = new String[2];
                arrstring[0] = SharkLogger.ALLATORIxDEMO("\u514c");
                arrstring[1] = MobSkillData.ALLATORIxDEMO("\u65e8");
                DROP_BONUS_ALLDAY = arrstring;
                String[] arrstring11 = new String[5];
                arrstring11[0] = SharkLogger.ALLATORIxDEMO("\u4e21");
                arrstring11[1] = MobSkillData.ALLATORIxDEMO("\u4e81");
                arrstring11[2] = SharkLogger.ALLATORIxDEMO("\u4e28");
                arrstring11[3] = MobSkillData.ALLATORIxDEMO("\u56d6");
                arrstring11[4] = SharkLogger.ALLATORIxDEMO("\u4eb5");
                DROP_BONUS_HOURDAY = arrstring11;
                int[] arrn354 = new int[6];
                arrn354[0] = 20;
                arrn354[1] = 21;
                arrn354[2] = 0;
                arrn354[3] = 1;
                arrn354[4] = 6;
                arrn354[5] = 7;
                DROP_BONUS_HOUR = arrn354;
                BOSS_HPRATE = 1.2;
                REINCARNATION_REMOVE_SKILL_ABILITY = true;
                MAX_STAT = 1200;
                int[] arrn355 = new int[1];
                arrn355[0] = 105050101;
                SKILLDISABLE_MAP = arrn355;
                FATIGUE_TIME = 60;
                BUYBACK_SYSTEM = true;
                int[] arrn356 = new int[1];
                arrn356[0] = 910000000;
                PET_PICKUP_MAP_BAN = arrn356;
                EXPRingPartyUnlimit = true;
                int[] arrn357 = new int[1];
                arrn357[0] = 670010800;
                PET_PICKUP_MAP_BAN = arrn357;
                return;
            }
            case 158: {
                MAPLE_VERSION = (short)135;
                EXP_RATE = 12;
                DROP_RATE = 2;
                MESO_RATE = 1;
                CANUSE_4CASH = true;
                AUTO_CS_ITEM = true;
                UNLIMITMPTOHP = true;
                WASH_HP_LIMIT = 9999;
                MAX_DAMAGE = 999999L;
                UNLIMITMPTOHP = true;
                DOJO_POINT = false;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 15;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 5.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 8000.0;
                MobDropPOINT = arrd;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 120;
                EXPRingPartyUnlimit = true;
                CS_FACTORYOPEN = true;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                AUTO_CS_ITEM = true;
                FLY_CHAIR = true;
                int[] arrn358 = new int[1];
                arrn358[0] = 910000000;
                FISH_MAP = arrn358;
                BUYBACK_SYSTEM = true;
                LOGIN_CHECK = false;
                DCLOAD_LOGIN_SAVING = false;
                CS_FACTORYOPEN = true;
                MOB_COUNT_RATE = 2.0;
                CREATE_RESIST = false;
                SELL_SYSTEM = true;
                SERVER_ID = 109;
                MERCHANT_ID = "3120373";
                HASHKEY = "sfuKfvQUTsVltcNX";
                HASHIV = "pTwVM7MvFCKftlrH";
                ECPAY_SYSTEM = true;
                return;
            }
            case 159: {
                MAPLE_VERSION = (short)151;
                MAPLE_PATCH = "2";
                EXP_RATE = 5;
                DROP_RATE = 1;
                MESO_RATE = 1;
                DAMAGE_SKIN = true;
                CS_FACTORYOPEN = true;
                BUYBACK_SYSTEM = true;
                COMPRESS_ITEM = false;
                CHECK_TAKE_DAMAGE = false;
                CHECKONEHUNDRED = false;
                CS_CLASSIFY = true;
                CANUSE_4CASH = true;
                CHOOSE_JOB = true;
                int[][] arrarrn = new int[2][];
                int[] arrn = new int[2];
                arrn[0] = 9700031;
                arrn[1] = 2;
                arrarrn[0] = arrn;
                int[] arrn359 = new int[2];
                arrn359[0] = 9700032;
                arrn359[1] = 4;
                arrarrn[1] = arrn359;
                REINCARNATION_MOB = arrarrn;
                BANK_SYSTEM = true;
                BACCARAT_SYSTEM = true;
                int[] arrn360 = new int[2];
                arrn360[0] = 20;
                arrn360[1] = 910000000;
                BACCARAT_LOCATION = arrn360;
                SELL_SYSTEM = true;
                MAX_SLOT = true;
                int[] arrn361 = new int[1];
                arrn361[0] = 910000000;
                FISH_MAP = arrn361;
                FreeSlot = true;
                LEGEND_CHANCE = 100;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.04;
                arrd[4] = 50000.0;
                MobDropPOINT = arrd;
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LOGIN_SIGNLOG = true;
                DEFAULT_CHARSLOT = 15;
                MAX_STAT = 1999;
                DAMAGE_SYSTEM = true;
                HOMOSEX = true;
                SERVER_ID = 110;
                MAX_DAMAGE = 5000000L;
                ECPAY_INVOICE = true;
                POINT_NAME = "\u8d0a\u52a9";
                int[] arrn362 = new int[1];
                arrn362[0] = 2450010;
                NO_CONSUME_ITEM = arrn362;
                AUTO_JOB = true;
                int[][] arrarrn3 = new int[2][];
                int[] arrn363 = new int[2];
                arrn363[0] = 1202194;
                arrn363[1] = 2;
                arrarrn3[0] = arrn363;
                int[] arrn364 = new int[2];
                arrn364[0] = 1202193;
                arrn364[1] = 3;
                arrarrn3[1] = arrn364;
                REINCARNATION_EQUIP = arrarrn3;
                int[] arrn365 = new int[3];
                arrn365[0] = 5;
                arrn365[1] = 15;
                arrn365[2] = 60;
                ONLINEPOINT = arrn365;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                CS_FACTORYOPEN = true;
                int[] arrn366 = new int[3];
                arrn366[0] = 5;
                arrn366[1] = 15;
                arrn366[2] = 60;
                ONLINEPOINT = arrn366;
                int[] arrn367 = new int[3];
                arrn367[0] = 5;
                arrn367[1] = 5;
                arrn367[2] = 2;
                DojoPoints = arrn367;
                MAX_SLOT = true;
                MERCHANT_ID = "1052601";
                HASHKEY = "aM31fpNusLzDWIwO";
                HASHIV = "F6P9fkwcdn2MyNMQ";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                ECPAY_INVOICE = true;
                LINEBOT = true;
                LINEBOT_URL = "https://star.bobolinebot.tk";
                return;
            }
            case 160: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 3;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.5;
                BOSS_HPRATE = 1.5;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 399999L;
                WASH_HP_LIMIT = 1000;
                int[] arrn = new int[3];
                arrn[0] = 1;
                arrn[1] = 5;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn368 = new int[1];
                arrn368[0] = 910000000;
                ONLINEPOINT_MAP = arrn368;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.16666666666666666;
                arrd[4] = 3500.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn369 = new int[2];
                arrn369[0] = 910000000;
                arrn369[1] = 910000023;
                FISH_MAP = arrn369;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                AUTO_CS_ITEM = true;
                CS_CLASSIFY = true;
                CANUSE_4CASH = true;
                int[] arrn370 = new int[1];
                arrn370[0] = 1112127;
                PETVAC_EQUIP = arrn370;
                int[][] arrarrn = new int[1][];
                int[] arrn371 = new int[2];
                arrn371[0] = 1112127;
                arrn371[1] = 2;
                arrarrn[0] = arrn371;
                REINCARNATION_EQUIP = arrarrn;
                SELL_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                LOTTORY_DRAW = true;
                PVP_SYSTEM = true;
                PVP_CHANNEL = 18;
                PVP_MAP = 701000201;
                BACCARAT_SYSTEM = true;
                int[] arrn372 = new int[2];
                arrn372[0] = 20;
                arrn372[1] = 910000000;
                BACCARAT_LOCATION = arrn372;
                int[] arrn373 = new int[7];
                arrn373[0] = 1082705;
                arrn373[1] = 1102811;
                arrn373[2] = 1073258;
                arrn373[3] = 1702974;
                arrn373[4] = 0x1011AA;
                arrn373[5] = 1004849;
                arrn373[6] = 1142263;
                CREAT_EQUIPS_MALE = arrn373;
                int[] arrn374 = new int[7];
                arrn374[0] = 1082705;
                arrn374[1] = 1102811;
                arrn374[2] = 1073258;
                arrn374[3] = 1702974;
                arrn374[4] = 0x1011AA;
                arrn374[5] = 1004849;
                arrn374[6] = 1142263;
                CREAT_EQUIPS_FEMALE = arrn374;
                BACCARAT_LIMIT_RATE = 0.3;
                int[][] arrarrn4 = new int[3][];
                int[] arrn375 = new int[2];
                arrn375[0] = 9700100;
                arrn375[1] = 1;
                arrarrn4[0] = arrn375;
                int[] arrn376 = new int[2];
                arrn376[0] = 9700200;
                arrn376[1] = 1;
                arrarrn4[1] = arrn376;
                int[] arrn377 = new int[2];
                arrn377[0] = 9700300;
                arrn377[1] = 1;
                arrarrn4[2] = arrn377;
                REINCARNATION_MOB = arrarrn4;
                int[][] arrarrn5 = new int[1][];
                int[] arrn378 = new int[2];
                arrn378[0] = 1112127;
                arrn378[1] = 2;
                arrarrn5[0] = arrn378;
                REINCARNATION_EQUIP = arrarrn5;
                SELL_MESO_LIMIT = Integer.MAX_VALUE;
                CS_HIDEITEMS = false;
                MERCHANT_ID = "3155251";
                HASHKEY = "yzTUiiWwLJmoRI4P";
                HASHIV = "X36Hy4fKSVA0lO9N";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT = true;
                LINEBOT_URL = "https://iceheart.bobolinebot.tk";
                ECPAY_IP = "srv1-ns201129-C3TyCS.access.ly";
                MARRY_DROP_BONUS = 1.2;
                MARRY_EXP_BONUS = 1.2;
                LOGIN_CHECK = false;
                FISH_KING = true;
                return;
            }
            case 161: {
                EXP_RATE = 2;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 9999;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn379 = new int[3];
                arrn379[0] = 10;
                arrn379[1] = 50;
                arrn379[2] = 60;
                ONLINEPOINT = arrn379;
                double[] arrd = new double[5];
                arrd[0] = 15.0;
                arrd[1] = 15.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 3000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn380 = new int[1];
                arrn380[0] = 910000000;
                FISH_MAP = arrn380;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 9999;
                CS_FACTORYOPEN = true;
                int[] arrn381 = new int[1];
                arrn381[0] = 2103009;
                NO_CONSUME_ITEM = arrn381;
                CANUSE_4CASH = true;
                AUTO_CS_ITEM = true;
                CS_CLASSIFY = true;
                FLY_CHAIR = true;
                MERCHANT_ID = "3221962";
                HASHKEY = "SA9cALbCnFvIxyTB";
                HASHIV = "OYFatebeiRsK4bML";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                return;
            }
            case 162: {
                MAPLE_VERSION = (short)149;
                MAPLE_PATCH = "2";
                EXP_RATE = 4;
                DROP_RATE = 2;
                MESO_RATE = 1;
                int[] arrn = new int[4];
                arrn[0] = 5000;
                arrn[1] = 10000;
                arrn[2] = 30000;
                arrn[3] = 50000;
                VIP_DONATE_INTERVAL = arrn;
                SERVER_ID = 106;
                MAX_SLOT = true;
                int[] arrn382 = new int[3];
                arrn382[0] = 1;
                arrn382[1] = 10;
                arrn382[2] = 60;
                ONLINEPOINT = arrn382;
                VIP_LEVELMAX = 4;
                EXP_RATE = 5;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 2.0;
                BOSS_HPRATE = 4.0;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 66666666L;
                WASH_HP_LIMIT = 99999;
                UNLIMITMPTOHP = true;
                int[] arrn383 = new int[3];
                arrn383[0] = 1;
                arrn383[1] = 15;
                arrn383[2] = 60;
                ONLINEPOINT = arrn383;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 30.0;
                arrd[2] = 2.0;
                arrd[3] = 0.05;
                arrd[4] = 0.0;
                MobDropPOINT = arrd;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_STAT = 32767;
                GIVEALL_PETSKILL = true;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                MERCHANT_ID = "1052601";
                HASHKEY = "aM31fpNusLzDWIwO";
                HASHIV = "F6P9fkwcdn2MyNMQ";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                ECPAY_INVOICE = true;
                AUTO_JOB = true;
                return;
            }
            case 163: {
                EXP_RATE = 7;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                DUE_DATE = "2021-01-29";
                MAX_DAMAGE = 10000000L;
                DOJO_POINT = false;
                int[] arrn = new int[3];
                arrn[0] = 15;
                arrn[1] = 15;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 6.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 2000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn384 = new int[1];
                arrn384[0] = 910000000;
                FISH_MAP = arrn384;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 1450;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                DEFAULT_HP = 30000;
                DEFAULT_MP = 30000;
                AUTO_CS_ITEM = true;
                CANUSE_4CASH = true;
                int[] arrn385 = new int[1];
                arrn385[0] = 1112127;
                PETVAC_EQUIP = arrn385;
                int[][] arrarrn = new int[1][];
                int[] arrn386 = new int[2];
                arrn386[0] = 1112127;
                arrn386[1] = 2;
                arrarrn[0] = arrn386;
                REINCARNATION_EQUIP = arrarrn;
                SELL_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                return;
            }
            case 164: {
                MAPLE_VERSION = (short)145;
                POTENTIAL_ALL = true;
                CANUSE_4CASH = true;
                CHOOSE_JOB = true;
                PEE_SYSTEM = true;
                POINT_NAME = "\u8d0a\u52a9";
                MERCHANT_ID = "1052601";
                HASHKEY = "aM31fpNusLzDWIwO";
                HASHIV = "F6P9fkwcdn2MyNMQ";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                ECPAY_INVOICE = true;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 100.0;
                arrd[2] = 2.0;
                arrd[3] = 0.5;
                arrd[4] = 500000.0;
                MobDropPOINT = arrd;
                return;
            }
            case 165: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                BEBINNER_PARTY = true;
                WASH_HP_LIMIT = 5000;
                int[] arrn = new int[3];
                arrn[0] = 2;
                arrn[1] = 2;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn387 = new int[3];
                arrn387[0] = 20;
                arrn387[1] = 40;
                arrn387[2] = 60;
                ONLINEPOINT = arrn387;
                int[] arrn388 = new int[4];
                arrn388[0] = 910000000;
                arrn388[1] = 749050500;
                arrn388[2] = 749050501;
                arrn388[3] = 749050502;
                ONLINEPOINT_MAP = arrn388;
                double[] arrd = new double[5];
                arrd[0] = 15.0;
                arrd[1] = 30.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 4000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                int[] arrn389 = new int[1];
                arrn389[0] = 910000000;
                FISH_MAP = arrn389;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                CANUSE_4CASH = true;
                CASHSHOP_ETC = true;
                DAMAGE_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                SELL_SYSTEM = true;
                CS_HIDEITEMS = false;
                return;
            }
            case 166: {
                MAPLE_VERSION = (short)147;
                LEGEND_CHANCE = 500;
                SUPRISE_CHANCE = 200;
                MONSTERPET = true;
                CANUSE_4CASH = true;
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 9999999L;
                WASH_HP_LIMIT = 9999;
                UNLIMITMPTOHP = true;
                int[] arrn = new int[3];
                arrn[0] = 5;
                arrn[1] = 5;
                arrn[2] = 2;
                DojoPoints = arrn;
                int[] arrn390 = new int[3];
                arrn390[0] = 10;
                arrn390[1] = 50;
                arrn390[2] = 60;
                ONLINEPOINT = arrn390;
                double[] arrd = new double[5];
                arrd[0] = 10.0;
                arrd[1] = 50.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 8000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                EXPRingPartyUnlimit = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 120;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                CS_FACTORYOPEN = true;
                MAPLE_PATCH = "4";
                CHOOSE_JOB = true;
                int[] arrn391 = new int[2];
                arrn391[0] = 2103009;
                arrn391[1] = 5570000;
                NO_CONSUME_ITEM = arrn391;
                DELAY_CHECK = false;
                MERCHANT_ID = "3120373";
                HASHKEY = "sfuKfvQUTsVltcNX";
                HASHIV = "pTwVM7MvFCKftlrH";
                ECPAY_SYSTEM = true;
                ECPAY_PORT = 443;
                LINEBOT = true;
                LINEBOT_URL = "https://gg.bobolinebot.tk";
                POISON_BOSS = false;
                POISON_DAMAGE_RATE = 0.3;
                SELL_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                USE_CRYPT_KEY = true;
                CRYPT_KEY = 45;
                int[][] arrarrn = new int[10][];
                int[] arrn392 = new int[2];
                arrn392[0] = 9800030;
                arrn392[1] = 1;
                arrarrn[0] = arrn392;
                int[] arrn393 = new int[2];
                arrn393[0] = 9800031;
                arrn393[1] = 1;
                arrarrn[1] = arrn393;
                int[] arrn394 = new int[2];
                arrn394[0] = 9800032;
                arrn394[1] = 1;
                arrarrn[2] = arrn394;
                int[] arrn395 = new int[2];
                arrn395[0] = 9800033;
                arrn395[1] = 2;
                arrarrn[3] = arrn395;
                int[] arrn396 = new int[2];
                arrn396[0] = 9800034;
                arrn396[1] = 2;
                arrarrn[4] = arrn396;
                int[] arrn397 = new int[2];
                arrn397[0] = 9800035;
                arrn397[1] = 2;
                arrarrn[5] = arrn397;
                int[] arrn398 = new int[2];
                arrn398[0] = 9800036;
                arrn398[1] = 2;
                arrarrn[6] = arrn398;
                int[] arrn399 = new int[2];
                arrn399[0] = 9800037;
                arrn399[1] = 2;
                arrarrn[7] = arrn399;
                int[] arrn400 = new int[2];
                arrn400[0] = 9800038;
                arrn400[1] = 3;
                arrarrn[8] = arrn400;
                int[] arrn401 = new int[2];
                arrn401[0] = 9800039;
                arrn401[1] = 3;
                arrarrn[9] = arrn401;
                REINCARNATION_MOB = arrarrn;
                THREE_PET = true;
                return;
            }
            case 167: {
                MAPLE_VERSION = (short)113;
                AUTO_CS_ITEM = true;
                CANUSE_4CASH = true;
                BUYBACK_SYSTEM = true;
                SELL_SYSTEM = true;
                FLY_CHAIR = true;
                SELL_SYSTEM = true;
                CS_CLASSIFY = true;
                CANUSE_4CASH = true;
                int[][] arrarrn = new int[2][];
                int[] arrn = new int[2];
                arrn[0] = 9700033;
                arrn[1] = 2;
                arrarrn[0] = arrn;
                int[] arrn402 = new int[2];
                arrn402[0] = 9700034;
                arrn402[1] = 2;
                arrarrn[1] = arrn402;
                REINCARNATION_MOB = arrarrn;
                REINCARNATION_SKILL_MOB = 9700034;
                REINCARNATION_SKILL_SYSTEM = true;
                REINCARNATION_SKILL_EQUIP = 1115999;
                int[] arrn403 = new int[1];
                arrn403[0] = 1017;
                REINCARNATION_SKILL = arrn403;
                FLY_CHAIR = true;
                return;
            }
            case 168: {
                MAPLE_VERSION = (short)118;
                int[] arrn = new int[1];
                arrn[0] = 1122086;
                PETVAC_EQUIP = arrn;
                int[][] arrarrn = new int[1][];
                int[] arrn404 = new int[2];
                arrn404[0] = 1112127;
                arrn404[1] = 2;
                arrarrn[0] = arrn404;
                REINCARNATION_EQUIP = arrarrn;
                AUTO_CS_ITEM = true;
                CANUSE_4CASH = true;
                FLY_CHAIR = true;
                BEBINNER_PARTY = true;
                MAX_DAMAGE = 299999L;
                WASH_HP_LIMIT = 2000;
                UNLIMITMPTOHP = true;
                int[] arrn405 = new int[3];
                arrn405[0] = 3;
                arrn405[1] = 3;
                arrn405[2] = 1;
                DojoPoints = arrn405;
                int[] arrn406 = new int[3];
                arrn406[0] = 1;
                arrn406[1] = 10;
                arrn406[2] = 60;
                ONLINEPOINT = arrn406;
                double[] arrd = new double[5];
                arrd[0] = 30.0;
                arrd[1] = 50.0;
                arrd[2] = 2.0;
                arrd[3] = 0.3;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 250;
                MAX_SLOT = true;
                MAX_STAT = 32767;
                CS_FACTORYOPEN = true;
                GAMBLING_SYSTEM = true;
                VIPSYSTEM = true;
                VIPEXP = true;
                VIPPOINT = true;
                VIPDROP = true;
                VIP_LEVELMAX = 10;
                VIPPOINT = true;
                VIP_DONATEINTERVAL = 3000;
                SELL_SYSTEM = true;
                CS_CLASSIFY = true;
                CANUSE_4CASH = true;
                PACKET_CHECK = false;
                WHISPET_FIND = false;
                DAMAGE_SYSTEM = true;
                SAVEBUFF = true;
                return;
            }
            case 169: {
                MAPLE_VERSION = (short)145;
                EXP_RATE = 1;
                DROP_RATE = 1;
                MESO_RATE = 1;
                CANUSE_4CASH = true;
                int[] arrn = new int[7];
                arrn[0] = 1005563;
                arrn[1] = 1053594;
                arrn[2] = 1072153;
                arrn[3] = 1702952;
                arrn[4] = 1022048;
                arrn[5] = 1082102;
                arrn[6] = 1102039;
                CREAT_EQUIPS_MALE = arrn;
                int[] arrn407 = new int[7];
                arrn407[0] = 1005563;
                arrn407[1] = 1053594;
                arrn407[2] = 1072153;
                arrn407[3] = 1702952;
                arrn407[4] = 1022048;
                arrn407[5] = 1082102;
                arrn407[6] = 1102039;
                CREAT_EQUIPS_FEMALE = arrn407;
                CANUSE_4CASH = true;
                int[][] arrarrn = new int[10][];
                int[] arrn408 = new int[2];
                arrn408[0] = 9900030;
                arrn408[1] = 1;
                arrarrn[0] = arrn408;
                int[] arrn409 = new int[2];
                arrn409[0] = 9900031;
                arrn409[1] = 1;
                arrarrn[1] = arrn409;
                int[] arrn410 = new int[2];
                arrn410[0] = 9900032;
                arrn410[1] = 1;
                arrarrn[2] = arrn410;
                int[] arrn411 = new int[2];
                arrn411[0] = 9900033;
                arrn411[1] = 2;
                arrarrn[3] = arrn411;
                int[] arrn412 = new int[2];
                arrn412[0] = 9900034;
                arrn412[1] = 2;
                arrarrn[4] = arrn412;
                int[] arrn413 = new int[2];
                arrn413[0] = 9900035;
                arrn413[1] = 2;
                arrarrn[5] = arrn413;
                int[] arrn414 = new int[2];
                arrn414[0] = 9900036;
                arrn414[1] = 2;
                arrarrn[6] = arrn414;
                int[] arrn415 = new int[2];
                arrn415[0] = 9900037;
                arrn415[1] = 5;
                arrarrn[7] = arrn415;
                int[] arrn416 = new int[2];
                arrn416[0] = 9900038;
                arrn416[1] = 5;
                arrarrn[8] = arrn416;
                int[] arrn417 = new int[2];
                arrn417[0] = 9900039;
                arrn417[1] = 5;
                arrarrn[9] = arrn417;
                REINCARNATION_MOB = arrarrn;
                AUCTION_SYSTEM = true;
                EXP_RATE = 9;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 2.0;
                BOSS_HPRATE = 3.0;
                int[] arrn418 = new int[3];
                arrn418[0] = 20;
                arrn418[1] = 20;
                arrn418[2] = 2;
                DojoPoints = arrn418;
                int[] arrn419 = new int[3];
                arrn419[0] = 20;
                arrn419[1] = 100;
                arrn419[2] = 60;
                ONLINEPOINT = arrn419;
                int[] arrn420 = new int[2];
                arrn420[0] = 910000000;
                arrn420[1] = 871100010;
                ONLINEPOINT_MAP = arrn420;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 10.0;
                arrd[2] = 2.0;
                arrd[3] = 0.06666666666666667;
                arrd[4] = 50000.0;
                MobDropPOINT = arrd;
                FreeSlot = true;
                MAXLEVEL = 251;
                MAXLEVEL_KOC = 200;
                MAX_SLOT = true;
                MAX_STAT = 99999;
                CS_FACTORYOPEN = true;
                VIPSYSTEM = true;
                VIPEXP = true;
                VIPEXP_INTERVAL = 0.02;
                VIPDROP = true;
                VIPDROP_INTERVAL = 0.03;
                VIP_LEVELMAX = 8;
                int[] arrn421 = new int[8];
                arrn421[0] = 1000;
                arrn421[1] = 3000;
                arrn421[2] = 5000;
                arrn421[3] = 10000;
                arrn421[4] = 20000;
                arrn421[5] = 30000;
                arrn421[6] = 40000;
                arrn421[7] = 50000;
                VIP_DONATE_INTERVAL = arrn421;
                return;
            }
            case 170: {
                EXP_RATE = 3;
                DROP_RATE = 1;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.2;
                WASH_HP_LIMIT = 9999;
                DOJO_POINT = false;
                int[] arrn = new int[3];
                arrn[0] = 20;
                arrn[1] = 20;
                arrn[2] = 60;
                ONLINEPOINT = arrn;
                int[] arrn422 = new int[1];
                arrn422[0] = 910000000;
                ONLINEPOINT_MAP = arrn422;
                double[] arrd = new double[5];
                arrd[0] = 1.0;
                arrd[1] = 3.0;
                arrd[2] = 2.0;
                arrd[3] = 0.02;
                arrd[4] = 500.0;
                MobDropPOINT = arrd;
                MAX_SLOT = true;
                CS_FACTORYOPEN = true;
                return;
            }
            case 171: {
                MAPLE_VERSION = (short)113;
                EXP_RATE = 2;
                DROP_RATE = 2;
                MESO_RATE = 1;
                MOB_HPRATE = 1.0;
                BOSS_HPRATE = 1.0;
                BEBINNER_PARTY = true;
                WASH_HP_LIMIT = 5000;
                int[] arrn = new int[3];
                arrn[0] = 2;
                arrn[1] = 2;
                arrn[2] = 1;
                DojoPoints = arrn;
                int[] arrn423 = new int[3];
                arrn423[0] = 20;
                arrn423[1] = 40;
                arrn423[2] = 60;
                ONLINEPOINT = arrn423;
                int[] arrn424 = new int[4];
                arrn424[0] = 910000000;
                arrn424[1] = 749050500;
                arrn424[2] = 749050501;
                arrn424[3] = 749050502;
                ONLINEPOINT_MAP = arrn424;
                double[] arrd = new double[5];
                arrd[0] = 15.0;
                arrd[1] = 30.0;
                arrd[2] = 2.0;
                arrd[3] = 0.1;
                arrd[4] = 5000.0;
                MobDropPOINT = arrd;
                MAX_SLOT = true;
                MAXLEVEL = 250;
                MAXLEVEL_KOC = 200;
                EXPRingPartyUnlimit = true;
                MAX_STAT = 1999;
                CS_FACTORYOPEN = true;
                FLY_CHAIR = true;
                BACCARAT_SYSTEM = true;
                int[] arrn425 = new int[2];
                arrn425[0] = 2;
                arrn425[1] = 910000000;
                BACCARAT_LOCATION = arrn425;
                SELL_SYSTEM = true;
                BUYBACK_SYSTEM = true;
                return;
            }
            case 172: {
                MAPLE_VERSION = (short)113;
                DUE_DATE = "2030-02-01";
                return;
            }
            case 173: 
            case 174: 
            case 175: {
                MAPLE_VERSION = (short)118;
                DUE_DATE = "2030-01-01";
                AUTO_UPDATE = false;
                SELL_MODE = true;
                SHUTDOWN_PROTECT = false;
                return;
            }
            case 176: 
            case 177: {
                MAPLE_VERSION = (short)113;
                DUE_DATE = "2030-01-01";
                AUTO_UPDATE = false;
                SELL_MODE = true;
                SHUTDOWN_PROTECT = false;
                return;
            }
        }
        LIMIT_USE = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getNpcFolder() {
        String string = "";
        switch (MAPLE_VERSION) {
            case 75: {
                string = MobSkillData.ALLATORIxDEMO("~\u0003\u007f\t}\u0014~W8");
                break;
            }
            case 113: {
                string = SharkLogger.ALLATORIxDEMO("ROSEQXR");
                break;
            }
            case 116: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<Q;");
                break;
            }
            case 118: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u001d\u0019");
                break;
            }
            case 134: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<S9");
                break;
            }
            case 135: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u001f\u0014");
                break;
            }
            case 136: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<S;");
                break;
            }
            case 139: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u001f\u0014");
                break;
            }
            case 142: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<T?");
                break;
            }
            case 143: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u0018\u0012");
                break;
            }
            case 145: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<T8");
                break;
            }
            case 146: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u0018\u0017");
                break;
            }
            case 147: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<T:");
                break;
            }
            case 149: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u0018\u0018");
                break;
            }
            case 151: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<U<");
                break;
            }
            case 152: {
                string = SharkLogger.ALLATORIxDEMO("_B^H\\U_\u0010\u0019\u0013");
                break;
            }
            case 153: {
                string = MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<U>");
                break;
            }
            default: {
                string = SharkLogger.ALLATORIxDEMO("ROSEQXR");
            }
        }
        if (SERVER_NAME.contains(MobSkillData.ALLATORIxDEMO("\u6e4c\u8a6b\u8c57{Q9"))) return MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<TU");
        if (!SERVER_NAME.contains(SharkLogger.ALLATORIxDEMO("\u6e00\u8a47\u8c1bW\u001d\u0014"))) return string;
        return MobSkillData.ALLATORIxDEMO("\u0013n\u0012d\u0010y\u0013<TU");
    }

    public static /* synthetic */ boolean isSkillDisableMap(int a2) {
        int n2;
        if (SKILLDISABLE_MAP.length == 0) {
            return false;
        }
        int n3 = n2 = 0;
        while (n3 < SKILLDISABLE_MAP.length) {
            if (SKILLDISABLE_MAP[n2] == a2) {
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void handleShield(MapleCharacter a2) {
        int n2;
        block12: {
            String string = SERVER_NAME;
            int n3 = -1;
            switch (string.hashCode()) {
                case 27271844: {
                    if (!string.equals(MobSkillData.ALLATORIxDEMO("\u6bd9\u5927\u8c3a"))) break;
                    n2 = n3 = 0;
                    break block12;
                }
                case 30991069: {
                    if (!string.equals(SharkLogger.ALLATORIxDEMO("\u79ea\u7d29\u8c16"))) break;
                    n2 = n3 = 1;
                    break block12;
                }
                case 32428663: {
                    if (!string.equals(MobSkillData.ALLATORIxDEMO("\u7f83\u7fee\u8c3a"))) break;
                    n3 = 2;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                if (MapleJob.is\u72c2\u72fc\u52c7\u58eb(a2.getJob())) {
                    a2.getClient().sendPacket(MaplePacketCreator.sendDamage(300000, true));
                }
                if (!a2.isGM()) return;
                a2.getClient().sendPacket(MaplePacketCreator.RemoveSpeakLimit());
                return;
            }
            case 1: {
                MapleCharacter mapleCharacter = a2;
                if (MapleJob.is\u72c2\u72fc\u52c7\u58eb(a2.getJob())) {
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.sendDamage(1000000, false));
                    return;
                }
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.sendDamage(false ? 1 : 0, false));
                return;
            }
            case 2: {
                if (!a2.isGM()) return;
                a2.getClient().sendPacket(MaplePacketCreator.RemoveSpeakLimit());
                return;
            }
        }
    }

    public static /* synthetic */ boolean isLimitGM(MapleCharacter a2) {
        return LIMIT_GM && a2.getGMLevel() <= 5;
    }
}

