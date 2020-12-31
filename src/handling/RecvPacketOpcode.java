/*
 * Decompiled with CFR 0.150.
 */
package handling;

import constants.GameSetConstants;
import handling.WritableIntValueHolder;
import tools.packet.FamilyPacket;
import tools.use.donate;

/*
 * Exception performing whole class analysis ignored.
 */
public final class RecvPacketOpcode
extends Enum<RecvPacketOpcode>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CANCEL_BUFF;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_BeansUpdate;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CRAFT_DONE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REPAIR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_CHAIR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CANCEL_CHAIR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FOLLOW_REPLY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHAR_SELECT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FACE_EXPRESSION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode UPDATE_CHAR_INFO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FACE_ANDROID;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CURE_POT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_PET;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CASHSHOP_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode BBS_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_PLAYER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DISTRIBUTE_AP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_ITEMEFFECT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MESO_DROP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MONSTER_BOMB_SINGLE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_FLAG_SCROLL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_SCRIPTED_NPC_ITEM;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PROFESSION_INFO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode STORAGE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode HYPNOTIZE_DMG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode YUTO_SHIELD_DETECT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PAM_SONG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CYGNUS_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode BUFF_FREEZER_REVIVE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHANGE_MAP_SPECIAL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVING_AREA;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ENTER_PVP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode UPDATE_FRIEND_POINTS;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ENTER_MTS;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode OPEN_FAMILY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PONG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_ITEM_QUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PVP_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REQUEST_INSTANCE_TABLE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_BAG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_MOUNT_FOOD;
    private static final /* synthetic */ RecvPacketOpcode[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TRANSFORM_PLAYER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHANGE_CHANNEL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REQUEST_SET_OFF_TRINITY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHANGE_ROOM_CHANNEL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SILENT_CRUSADE_CLOSE_UI;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_CIRCULATOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode OWL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ATTACK_FAMILIAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_UserAntiMacroSkillUseRequest;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_SKILL4;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode WHEEL_OF_FORTUNE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LIE_DETECTOR_RESPONSE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SILENT_CRUSADE_SHOP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REWARD_POT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SOLOMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GLIDE_DRAGON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_FAMILIAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SPAWN_FAMILIAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REQUEST_FAMILY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_CARVED_SEAL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PARTYCHAT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MAGIC_WHEEL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SIDEKICK_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DUEY_ACTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHAR_SELECT_SECOND_PASSWORD;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode WHISPER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REISSUE_MEDAL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode NPC_TALK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REPAIR_ALL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MAPLETV;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SKILL_MACRO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode UPDATE_CORE_AURA_EXPIRE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_COUNT4;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_FOOD;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHECK_CHAR_NAME;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SPECIAL_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DELETE_JUNIOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_COMMAND;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ANDROID_SHOP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RESET_HYPER_SP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLIENT_FEEDBACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MONSTER_BOMB;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode STRANGE_DATA;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CRAFT_EFFECT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode OWL_WARP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_ANGELIC;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ITEM_GATHER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_CASH_ITEM;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_SummonedSkill;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode AUTO_AGGRO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_SKILL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PART_TIME_JOB;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_TITLE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LOGIN_PASSWORD;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode COUPON_CODE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PQ_REWARD;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CANCEL_DEBUFF;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLOSE_RANGE_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ENTER_PVP_PARTY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GUILD_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLUSTER_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PARTY_REWARD_CHOOSE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MTS_TAB;
    private /* synthetic */ boolean d;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SHUFFLE_CORE_AURA;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SERVERSTATUS_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode THROW_SKILL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLIENT_LOGOUT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHINESE_PVP_RANKING;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SNOWBALL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RELEASE_TEMPEST_BLADES;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode VIEW_SKILLS;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_BeansGameAction;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CREATE_CHAR_2;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CS_XMAS_SURPRISE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_AUTO_EAT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TOUCH_FAMILIAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GIVE_FAME;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_MAGNIFY_GLASS;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PLAYER_INTERACTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode EVENT_TAKE_DAMAGE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PARTY_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_RETURN_SCROLL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHAR_INFO_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DENY_PARTY_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DISTRIBUTE_HYPER_SP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_HIRED_MERCHANT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PACKET_ERROR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CREATE_ULTIMATE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MONSTER_AREA_DISEASE_SKILL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LIE_DETECTOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DISPLAY_NODE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_SUMMON_BAG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DRESSUP_TIME;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CREATE_CHAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MAKE_EXTRACTOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DAMAGE_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode UPDATE_QUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode BUDDYLIST_MODIFY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PVP_RESPAWN;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode HEAL_OVER_TIME;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PVP_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode NPC_SHOP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PARTY_SEARCH_START;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLICK_REACTOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_SKILL3;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SWITCH_BAG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHANGE_KEYMAP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode UPDATE_LAPIDIFICATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LEFT_KNOCK_BACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FAMILY_PRECEPT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_FISH_MERCHANT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode NPC_TALK_MORE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GAIN_FORCE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOB_NODE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TEACH_SKILL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_TREASUER_CHEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ITEM_PICKUP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PARTY_SEARCH_STOP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_MOB;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_DIRECTION_INFO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_MECH_DOOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PLAYER_LOGGEDIN;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_UPGRADE_SCROLL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GACH_EXP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLOSE_CHALKBOARD;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CANCEL_ITEM_EFFECT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ITEM_UNLOCK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SCROLL_GASHAPON_BOX;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLIENT_ERROR;
    private /* synthetic */ short a;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FISHING_KING_RANKING;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLIENT_HELLO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode STOP_HARVEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_AUTO_BUFF;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MECH_CANCEL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ALLIANCE_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_ITEM_QUEST2;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SUB_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode APPLY_WING;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PARTY_REWARD_CLOSE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RENAME_FAMILIAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode QUEST_ITEM;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_EXP_POTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode COCONUT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode START_HARVEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MYSTIC_FIELD_MOVE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SPECIAL_MOVE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FRIENDLY_DAMAGE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_COUNT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_EQUIP_SCROLL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_POTENTIAL_SCROLL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_DOOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_AP_RESET;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FEED_POT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DELETE_CHAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RPS_GAME;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_DRAGON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MESSENGER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LOG_OUT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode HELLO_CHANNEL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_CATCH_ITEM;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SERVERLIST_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DENY_ALLIANCE_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REMOVE_LOGIN;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode QUEST_ACTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DAMAGE_REACTOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DENY_GUILD_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TOUCHING_MTS;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_COUNT2;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ITEM_MOVE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_RECIPE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LIE_DETECTOR_REFRESH;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SELECT_EXP_CHAIR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_SP_RESET;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ARAN_COMBO;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SET_GENDER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_FAMILY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_INNER_PORTAL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_ITEM;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_IGNORE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LOGIN_AUTH;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SKILL_SWIPE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ALLOW_PARTY_INVITE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode QUEST_TIP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CRAFT_MAKE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DENY_SIDEKICK_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_UserOldAntiMacroQuestionResult;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LIE_DETECTOR_SKILL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ITEM_SORT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ANYWHERE_DOOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode HELLO_LOGIN;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_LIFE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REMOTE_STORE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RANDOM_RECOMMEND;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GARBAGE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOVE_ANDROID;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_UserCalcDamageStatSetRequest;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TROCK_ADD_MAP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CANCEL_SKILL_WITH_BUFF;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_SKILL2;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FAMILY_OPERATION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_AUTO_POT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHARLIST_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SEND_GIFT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SILENT_CRUSADE_REWARD;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MERCH_ITEM_STORE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TAKE_DAMAGE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_UserAntiMacroItemUseRequest;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHANGE_CHAR_NAME;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DISTRIBUTE_SP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHOOSE_SKILL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHAIR_GAIN_EXP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GENERAL_CHAT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RANGED_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_OWL_MINERVA;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_BAG;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ACCEPT_FAMILY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CLEAR_POT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CHANGE_MAP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PASSIVE_ENERGY;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SPAWN_PET;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode KAISER_COLOR_CHANGE_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode UPDATE_CORE_AURA;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode DELETE_SENIOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ENTER_CASH_SHOP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_POT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode RING_ACTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MONSTER_BOOK_COVER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode GAME_POLL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode NPC_ACTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_CHAT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PET_LOOT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode AUTO_ASSIGN_AP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MOB_BOMB;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MAGIC_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REWARD_ITEM;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode VICIOUS_HAMMER_CASH_RESULT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SUMMON_ATTACK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode REMOVE_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode SKILL_EFFECT;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TOUCH_REACTOR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode MONSTER_CARNIVAL;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FOLLOW_REQUEST;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CP_UserThrowGrenade;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_FAMILIAR;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_GASHAPON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode USE_SKILL_BOOK;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode ITEM_MAKER;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode CS_UPDATE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode NOTE_ACTION;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LEVEL_GUIDE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode PVP_TOGGLE;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode TICK_COUNT3;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode FAMILY_SUMMON;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode LEAVE_PVP;
    public static final /* synthetic */ /* enum */ RecvPacketOpcode QUICK_SLOT;

    public final /* synthetic */ boolean NeedsChecking() {
        RecvPacketOpcode a2;
        return a2.d;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isSpamHeader(RecvPacketOpcode a2) {
        int n2;
        block21: {
            String string = a2.name();
            int n3 = -1;
            switch (string.hashCode()) {
                case 132404596: {
                    if (!string.equals(donate.ALLATORIxDEMO("=\u00160\u00192\u0005'\u000f<\b"))) break;
                    n2 = n3 = 0;
                    break block21;
                }
                case -410589526: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("o\u001dt\u0017}\u001ek\u0014g"))) break;
                    n2 = n3 = 1;
                    break block21;
                }
                case 677616399: {
                    if (!string.equals(donate.ALLATORIxDEMO("\u000b<\u00106\u0019#\n2\u001f6\u0014"))) break;
                    n2 = n3 = 2;
                    break block21;
                }
                case -836551711: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("\u001fm\u0004g\rc\u001cf\u0000m\u001bf"))) break;
                    n2 = n3 = 3;
                    break block21;
                }
                case 339590721: {
                    if (!string.equals(donate.ALLATORIxDEMO("\u000b<\u00106\u00197\u00142\u0001<\b"))) break;
                    n2 = n3 = 4;
                    break block21;
                }
                case 772161807: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("o\u001dt\u0017}\u0001w\u001fo\u001dl"))) break;
                    n2 = n3 = 5;
                    break block21;
                }
                case 679495569: {
                    if (!string.equals(donate.ALLATORIxDEMO(">\t%\u0003,\u00166\u0012"))) break;
                    n2 = n3 = 6;
                    break block21;
                }
                case 1344228430: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("\u0013w\u0006m\rc\u0015e\u0000m"))) break;
                    n2 = n3 = 7;
                    break block21;
                }
                case -214609837: {
                    if (!string.equals(donate.ALLATORIxDEMO("\"\u00136\u0015'\u00192\u0005'\u000f<\b"))) break;
                    n2 = n3 = 8;
                    break block21;
                }
                case 420688321: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("\u001ag\u0013n\rm\u0004g\u0000}\u0006k\u001fg"))) break;
                    n2 = n3 = 9;
                    break block21;
                }
                case 32155637: {
                    if (!string.equals(donate.ALLATORIxDEMO("1\u0013'\u0012<\b,\u0016!\u0003 \u00156\u0002"))) break;
                    n2 = n3 = 10;
                    break block21;
                }
                case 202952365: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("\u0001v\u0000c\u001ce\u0017}\u0016c\u0006c"))) break;
                    n2 = n3 = 11;
                    break block21;
                }
                case -586377058: {
                    if (!string.equals(donate.ALLATORIxDEMO("\u0015*\u0015'\u0003>\u0019#\u0014<\u00056\u0015 \u0019?\u000f \u0012"))) break;
                    n2 = n3 = 12;
                    break block21;
                }
                case 1095049045: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("r\u001bl\u0019`\u0017c\u001c}\u000bm\u000bm\rp\u0017s\u0007g\u0001v"))) break;
                    n2 = n3 = 13;
                    break block21;
                }
                case -1812126279: {
                    if (!string.equals(donate.ALLATORIxDEMO("\u00052\b0\u0003?\u00197\u00031\u00135\u0000"))) break;
                    n2 = n3 = 14;
                    break block21;
                }
                case 2461688: {
                    if (!string.equals(FamilyPacket.ALLATORIxDEMO("\u0002m\u001ce"))) break;
                    n3 = 15;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ boolean isUnknownRecvOpcode(short a2) {
        boolean bl = false;
        switch (a2) {
            case 12: {
                if (GameSetConstants.MAPLE_VERSION == 75) {
                    bl = true;
                    return true;
                }
            }
            case 119: 
            case 194: 
            case 215: {
                if (GameSetConstants.MAPLE_VERSION == 113 || GameSetConstants.MAPLE_VERSION == 118) {
                    bl = true;
                    return true;
                }
            }
            case 1: 
            case 27: 
            case 28: 
            case 52: 
            case 111: 
            case 124: 
            case 144: 
            case 244: 
            case 247: 
            case 250: 
            case 253: 
            case 270: 
            case 303: {
                while (false) {
                }
                if (GameSetConstants.MAPLE_VERSION == 135) {
                    bl = true;
                    return true;
                }
            }
            case 163: {
                if (GameSetConstants.MAPLE_VERSION != 149) break;
                bl = true;
            }
        }
        return bl;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.a = a2;
    }

    public static /* synthetic */ String nameOf(short a2) {
        int n2;
        RecvPacketOpcode[] arrrecvPacketOpcode = RecvPacketOpcode.values();
        int n3 = arrrecvPacketOpcode.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            RecvPacketOpcode recvPacketOpcode = arrrecvPacketOpcode[n2];
            if (recvPacketOpcode.getValue() == a2) {
                return recvPacketOpcode.name();
            }
            n4 = ++n2;
        }
        return FamilyPacket.ALLATORIxDEMO("w\u001ci\u001cm\u0005l");
    }

    public static /* synthetic */ RecvPacketOpcode[] values() {
        return (RecvPacketOpcode[])ALLATORIxDEMO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ RecvPacketOpcode() {
        void var2_-1;
        void var1_-1;
        RecvPacketOpcode a2;
        RecvPacketOpcode recvPacketOpcode = a2;
        recvPacketOpcode.a = (short)-2;
        recvPacketOpcode.d = true;
    }

    public static /* synthetic */ RecvPacketOpcode valueOf(String a2) {
        return Enum.valueOf(RecvPacketOpcode.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ RecvPacketOpcode(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        RecvPacketOpcode a3;
        RecvPacketOpcode recvPacketOpcode = a3;
        a3.a = (short)-2;
        recvPacketOpcode.a = (short)a2;
        recvPacketOpcode.d = false;
    }

    @Override
    public final /* synthetic */ short getValue() {
        RecvPacketOpcode a2;
        return a2.a;
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void reloadValues() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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
     * WARNING - void declaration
     */
    private /* synthetic */ RecvPacketOpcode(short s22, boolean s22) {
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        RecvPacketOpcode a4;
        RecvPacketOpcode recvPacketOpcode = a4;
        a4.a = (short)-2;
        recvPacketOpcode.a = a3;
        recvPacketOpcode.d = a2;
    }

    public static /* synthetic */ {
        GARBAGE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00012\u00141\u00074\u0003"), 0, 255);
        CLIENT_HELLO = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011n\u001bg\u001cv\rj\u0017n\u001em"), 1, 20);
        YUTO_SHIELD_DETECT = new RecvPacketOpcode(donate.ALLATORIxDEMO("*\u0013'\t,\u0015;\u000f6\n7\u00197\u0003'\u00030\u0012"), 2, 29);
        CHAIR_GAIN_EXP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011j\u0013k\u0000}\u0015c\u001bl\rg\nr"), 3);
        REMOVE_LOGIN = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0003>\t%\u0003,\n<\u0001:\b"), 4, 27);
        LOGIN_PASSWORD = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001em\u0015k\u001c}\u0002c\u0001q\u0005m\u0000f"), 5, 1);
        SERVERLIST_REQUEST = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \u0003!\u00106\u0014?\u000f \u0012,\u00146\u0017&\u0003 \u0012"), 6, 3);
        CHARLIST_REQUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011j\u0013p\u001ek\u0001v\rp\u0017s\u0007g\u0001v"), 7, 4);
        CHAR_SELECT = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005;\u0007!\u0019 \u0003?\u00030\u0012"), 8, 6);
        CHAR_SELECT_SECOND_PASSWORD = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001ac\u0000}\u0001g\u001eg\u0011v\rq\u0017a\u001dl\u0016}\u0002c\u0001q\u0005m\u0000f"), 9, 20);
        PLAYER_LOGGEDIN = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0016?\u0007*\u0003!\u0019?\t4\u00016\u0002:\b"), 10, 7);
        CHECK_CHAR_NAME = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001ag\u0011i\ra\u001ac\u0000}\u001cc\u001fg"), 11, 8);
        CHANGE_CHAR_NAME = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u000e2\b4\u0003,\u0005;\u0007!\u0019=\u0007>\u0003"), 12, 9);
        CREATE_CHAR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u0000g\u0013v\u0017}\u0011j\u0013p"), 13, false);
        CREATE_CHAR_2 = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005!\u00032\u00126\u00190\u000e2\u0014,t"), 14, false);
        CREATE_ULTIMATE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u0000g\u0013v\u0017}\u0007n\u0006k\u001fc\u0006g"), 15, 14);
        CLIENT_FEEDBACK = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005?\u000f6\b'\u00195\u00036\u00021\u00070\r"), 16, 12);
        DELETE_CHAR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("f\u0017n\u0017v\u0017}\u0011j\u0013p"), 17, 13);
        PONG = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\t=\u0001"), 18, 14);
        STRANGE_DATA = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001v\u0000c\u001ce\u0017}\u0016c\u0006c"), 19, 32767);
        CLIENT_ERROR = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\n:\u0003=\u0012,\u0003!\u0014<\u0014"), 20, 15);
        PACKET_ERROR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002c\u0011i\u0017v\rg\u0000p\u001dp"), 21);
        HELLO_LOGIN = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000e6\n?\t,\n<\u0001:\b"), 22, 23);
        SERVERSTATUS_REQUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001g\u0000t\u0017p\u0001v\u0013v\u0007q\rp\u0017s\u0007g\u0001v"), 23, 24);
        HELLO_CHANNEL = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000e6\n?\t,\u0005;\u0007=\b6\n"), 24, 218);
        SET_GENDER = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001g\u0006}\u0015g\u001cf\u0017p"), 25, 25);
        CLIENT_LOGOUT = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005?\u000f6\b'\u0019?\t4\t&\u0012"), 26, 26);
        CHANGE_MAP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011j\u0013l\u0015g\ro\u0013r"), 27, 30);
        CHANGE_CHANNEL = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u000e2\b4\u0003,\u0005;\u0007=\b6\n"), 28, 31);
        CHANGE_ROOM_CHANNEL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001ac\u001ce\u0017}\u0000m\u001do\ra\u001ac\u001cl\u0017n"), 29);
        ENTER_CASH_SHOP = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0003=\u00126\u0014,\u00052\u0015;\u0019 \u000e<\u0016"), 30, 32);
        MOVE_PLAYER = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("o\u001dt\u0017}\u0002n\u0013{\u0017p"), 31, 33);
        CANCEL_CHAIR = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u0007=\u00056\n,\u0005;\u0007:\u0014"), 32, 34);
        USE_CHAIR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0001g\ra\u001ac\u001bp"), 33, 35);
        SELECT_EXP_CHAIR = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \u0003?\u00030\u0012,\u0003+\u0016,\u0005;\u0007:\u0014"), 34, 36);
        CLOSE_RANGE_ATTACK = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011n\u001dq\u0017}\u0000c\u001ce\u0017}\u0013v\u0006c\u0011i"), 35, 37);
        RANGED_ATTACK = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00142\b4\u00037\u00192\u0012'\u00070\r"), 36, 38);
        MAGIC_ATTACK = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fc\u0015k\u0011}\u0013v\u0006c\u0011i"), 37, 39);
        CLUSTER_ATTACK = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\n&\u0015'\u0003!\u00192\u0012'\u00070\r"), 38);
        PASSIVE_ENERGY = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002c\u0001q\u001bt\u0017}\u0017l\u0017p\u0015{"), 39, 40);
        TAKE_DAMAGE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00122\r6\u00197\u0007>\u00074\u0003"), 40, 41);
        TEACH_SKILL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("v\u0017c\u0011j\rq\u0019k\u001en"), 41);
        GENERAL_CHAT = new RecvPacketOpcode(donate.ALLATORIxDEMO("4\u0003=\u0003!\u0007?\u00190\u000e2\u0012"), 42, 42);
        CLOSE_CHALKBOARD = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011n\u001dq\u0017}\u0011j\u0013n\u0019`\u001dc\u0000f"), 43, 43);
        FACE_EXPRESSION = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00002\u00056\u00196\u001e#\u00146\u0015 \u000f<\b"), 44, 44);
        USE_ITEMEFFECT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u001bv\u0017o\u0017d\u0014g\u0011v"), 45, 45);
        WHEEL_OF_FORTUNE = new RecvPacketOpcode(donate.ALLATORIxDEMO("$\u000e6\u0003?\u0019<\u0000,\u0000<\u0014'\u0013=\u0003"), 46, 46);
        MONSTER_BOOK_COVER = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fm\u001cq\u0006g\u0000}\u0010m\u001di\ra\u001dt\u0017p"), 47, 50);
        NPC_TALK = new RecvPacketOpcode(donate.ALLATORIxDEMO("=\u00160\u0019'\u0007?\r"), 48, 51);
        REMOTE_STORE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0000g\u001fm\u0006g\rq\u0006m\u0000g"), 49, 52);
        NPC_TALK_MORE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\b#\u0005,\u00122\n8\u0019>\t!\u0003"), 50, 53);
        NPC_SHOP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001cr\u0011}\u0001j\u001dr"), 51, 54);
        STORAGE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0015'\t!\u00074\u0003"), 52, 55);
        USE_HIRED_MERCHANT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u001ak\u0000g\u0016}\u001fg\u0000a\u001ac\u001cv"), 53, 56);
        USE_FISH_MERCHANT = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u0000:\u0015;\u0019>\u0003!\u0005;\u0007=\u0012"), 54);
        MERCH_ITEM_STORE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fg\u0000a\u001a}\u001bv\u0017o\rq\u0006m\u0000g"), 55, 58);
        DUEY_ACTION = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0002&\u0003*\u00192\u0005'\u000f<\b"), 56);
        ITEM_SORT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("k\u0006g\u001f}\u0001m\u0000v"), 57);
        ITEM_GATHER = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000f'\u0003>\u00194\u0007'\u000e6\u0014"), 58);
        ITEM_MOVE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("k\u0006g\u001f}\u001fm\u0004g"), 59);
        MOVE_BAG = new RecvPacketOpcode(donate.ALLATORIxDEMO(">\t%\u0003,\u00042\u0001"), 60);
        SWITCH_BAG = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001u\u001bv\u0011j\r`\u0013e"), 61);
        USE_ITEM = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u0019:\u00126\u000b"), 62);
        CANCEL_ITEM_EFFECT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011c\u001ca\u0017n\rk\u0006g\u001f}\u0017d\u0014g\u0011v"), 63);
        USE_TITLE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u0012:\u0012?\u0003"), 64);
        APPLY_WING = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0013r\u0002n\u000b}\u0005k\u001ce"), 65);
        DRESSUP_TIME = new RecvPacketOpcode(donate.ALLATORIxDEMO("7\u00146\u0015 \u0013#\u0019'\u000f>\u0003"), 66);
        REQUEST_INSTANCE_TABLE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0000g\u0003w\u0017q\u0006}\u001bl\u0001v\u0013l\u0011g\rv\u0013`\u001eg"), 67);
        USE_SUMMON_BAG = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u0019 \u0013>\u000b<\b,\u00042\u0001"), 68);
        USE_EXP_POTION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u0017z\u0002}\u0002m\u0006k\u001dl"), 69);
        PET_FOOD = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\u0003'\u00195\t<\u0002"), 70);
        USE_MOUNT_FOOD = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u001fm\u0007l\u0006}\u0014m\u001df"), 71);
        USE_SCRIPTED_NPC_ITEM = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u00150\u0014:\u0016'\u00037\u0019=\u00160\u0019:\u00126\u000b"), 72);
        USE_CASH_ITEM = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0001g\ra\u0013q\u001a}\u001bv\u0017o"), 73);
        ITEM_UNLOCK = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000f'\u0003>\u0019&\b?\t0\r"), 74);
        SOLOMON = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u001dn\u001do\u001dl"), 75);
        GACH_EXP = new RecvPacketOpcode(donate.ALLATORIxDEMO("4\u00070\u000e,\u0003+\u0016"), 76);
        USE_CATCH_ITEM = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u0011c\u0006a\u001a}\u001bv\u0017o"), 77);
        USE_SKILL_BOOK = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u0019 \r:\n?\u00191\t<\r"), 78);
        USE_RETURN_SCROLL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0001g\rp\u0017v\u0007p\u001c}\u0001a\u0000m\u001en"), 79);
        USE_UPGRADE_SCROLL = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u0019&\u00164\u00142\u00026\u0019 \u0005!\t?\n"), 80);
        USE_CARVED_SEAL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0001g\ra\u0013p\u0004g\u0016}\u0001g\u0013n"), 81);
        USE_FLAG_SCROLL = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u0000?\u00074\u0019 \u0005!\t?\n"), 82);
        DISTRIBUTE_AP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("f\u001bq\u0006p\u001b`\u0007v\u0017}\u0013r"), 83);
        AUTO_ASSIGN_AP = new RecvPacketOpcode(donate.ALLATORIxDEMO("2\u0013'\t,\u0007 \u0015:\u0001=\u00192\u0016"), 84);
        HEAL_OVER_TIME = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001ag\u0013n\rm\u0004g\u0000}\u0006k\u001fg"), 85);
        DISTRIBUTE_SP = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0002:\u0015'\u0014:\u0004&\u00126\u0019 \u0016"), 86);
        SPECIAL_MOVE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001r\u0017a\u001bc\u001e}\u001fm\u0004g"), 87);
        PROFESSION_INFO = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0016!\t5\u0003 \u0015:\t=\u0019:\b5\t"), 88);
        CANCEL_BUFF = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u0013l\u0011g\u001e}\u0010w\u0014d"), 89);
        SKILL_EFFECT = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \r:\n?\u00196\u00005\u00030\u0012"), 90);
        MESO_DROP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("o\u0017q\u001d}\u0016p\u001dr"), 91);
        GIVE_FAME = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0001:\u00106\u00195\u0007>\u0003"), 92);
        THROW_SKILL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("v\u001ap\u001du\rq\u0019k\u001en"), 93);
        CHAR_INFO_REQUEST = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005;\u0007!\u0019:\b5\t,\u00146\u0017&\u0003 \u0012"), 94);
        SPAWN_PET = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u0002c\u0005l\rr\u0017v"), 95);
        CANCEL_DEBUFF = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00052\b0\u0003?\u00197\u00031\u00135\u0000"), 96);
        CHANGE_MAP_SPECIAL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011j\u0013l\u0015g\ro\u0013r\rq\u0002g\u0011k\u0013n"), 97);
        USE_INNER_PORTAL = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u0019:\b=\u0003!\u0019#\t!\u00122\n"), 98);
        TROCK_ADD_MAP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("v\u0000m\u0011i\rc\u0016f\ro\u0013r"), 99);
        CP_UserAntiMacroItemUseRequest = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u0016,\u0013\u0000#\u0001\u0007\u001d2\u001a\u000b\u0012%\u0001):2\u0016+&5\u0016\u0014\u00167\u0006#\u00002"), 100);
        CP_UserAntiMacroSkillUseRequest = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u0002}\u0007Q7P\u0013L&K\u001fC1P=q9K>N\u0007Q7p7S'G!V"), 101);
        CP_UserOldAntiMacroQuestionResult = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005#\u0019&5\u00164<*\u0017\u0007\u001d2\u001a\u000b\u0012%\u0001)\"3\u00165\u0007/\u001c(!#\u00003\u001f2"), 102);
        QUEST_ACTION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0003w\u0017q\u0006}\u0013a\u0006k\u001dl"), 103);
        CP_UserCalcDamageStatSetRequest = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005#\u0019&5\u001640'\u001f%7'\u001e'\u0014# 2\u00122 #\u0007\u0014\u00167\u0006#\u00002"), 104);
        CP_UserThrowGrenade = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u0002}\u0007Q7P\u0006J M%e G<C6G"), 105);
        SKILL_MACRO = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00158\u000f?\n,\u000b2\u0005!\t"), 106);
        MAGIC_WHEEL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("o\u0013e\u001ba\ru\u001ag\u0017n"), 107);
        REWARD_ITEM = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00146\u00112\u00147\u0019:\u00126\u000b"), 108);
        ITEM_MAKER = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001bv\u0017o\ro\u0013i\u0017p"), 109);
        USE_TREASUER_CHEST = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u0019'\u00146\u0007 \u00136\u0014,\u0005;\u0003 \u0012"), 110);
        PARTYCHAT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("r\u0013p\u0006{\u0011j\u0013v"), 111);
        WHISPER = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0011;\u000f \u00166\u0014"), 112);
        MESSENGER = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("o\u0017q\u0001g\u001ce\u0017p"), 113);
        PLAYER_INTERACTION = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\n2\u001f6\u0014,\u000f=\u00126\u00142\u0005'\u000f<\b"), 114);
        PARTY_OPERATION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("r\u0013p\u0006{\rm\u0002g\u0000c\u0006k\u001dl"), 115);
        DENY_PARTY_REQUEST = new RecvPacketOpcode(donate.ALLATORIxDEMO("7\u0003=\u001f,\u00162\u0014'\u001f,\u00146\u0017&\u0003 \u0012"), 116);
        ALLOW_PARTY_INVITE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0013n\u001em\u0005}\u0002c\u0000v\u000b}\u001bl\u0004k\u0006g"), 117);
        GUILD_OPERATION = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0001&\u000f?\u0002,\t#\u0003!\u0007'\u000f<\b"), 118);
        DENY_GUILD_REQUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0016g\u001c{\re\u0007k\u001ef\rp\u0017s\u0007g\u0001v"), 119);
        BUDDYLIST_MODIFY = new RecvPacketOpcode(donate.ALLATORIxDEMO("1\u00137\u0002*\n:\u0015'\u0019>\t7\u000f5\u001f"), 120);
        NOTE_ACTION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("l\u001dv\u0017}\u0013a\u0006k\u001dl"), 121);
        USE_DOOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u00197\t<\u0014"), 122);
        CHANGE_KEYMAP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001ac\u001ce\u0017}\u0019g\u000bo\u0013r"), 123);
        UPDATE_CHAR_INFO = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00167\u0007'\u0003,\u0005;\u0007!\u0019:\b5\t"), 124);
        ENTER_MTS = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("g\u001cv\u0017p\ro\u0006q"), 125);
        ALLIANCE_OPERATION = new RecvPacketOpcode(donate.ALLATORIxDEMO("2\n?\u000f2\b0\u0003,\t#\u0003!\u0007'\u000f<\b"), 126);
        DENY_ALLIANCE_REQUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("f\u0017l\u000b}\u0013n\u001ek\u0013l\u0011g\rp\u0017s\u0007g\u0001v"), 127);
        REQUEST_FAMILY = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0003\"\u00136\u0015'\u00195\u0007>\u000f?\u001f"), 128);
        OPEN_FAMILY = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("m\u0002g\u001c}\u0014c\u001fk\u001e{"), 129);
        FAMILY_OPERATION = new RecvPacketOpcode(donate.ALLATORIxDEMO("5\u0007>\u000f?\u001f,\t#\u0003!\u0007'\u000f<\b"), 130);
        DELETE_JUNIOR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("f\u0017n\u0017v\u0017}\u0018w\u001ck\u001dp"), 131);
        DELETE_SENIOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00026\n6\u00126\u0019 \u0003=\u000f<\u0014"), 132);
        ACCEPT_FAMILY = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("c\u0011a\u0017r\u0006}\u0014c\u001fk\u001e{"), 133);
        USE_FAMILY = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u00195\u0007>\u000f?\u001f"), 134);
        FAMILY_PRECEPT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0014c\u001fk\u001e{\rr\u0000g\u0011g\u0002v"), 135);
        FAMILY_SUMMON = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00002\u000b:\n*\u0019 \u0013>\u000b<\b"), 136);
        CYGNUS_SUMMON = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u000be\u001cw\u0001}\u0001w\u001fo\u001dl"), 137);
        ARAN_COMBO = new RecvPacketOpcode(donate.ALLATORIxDEMO("2\u00142\b,\u0005<\u000b1\t"), 138);
        BBS_OPERATION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("`\u0010q\rm\u0002g\u0000c\u0006k\u001dl"), 139);
        TRANSFORM_PLAYER = new RecvPacketOpcode(donate.ALLATORIxDEMO("'\u00142\b \u0000<\u0014>\u0019#\n2\u001f6\u0014"), 140);
        MOVE_PET = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fm\u0004g\rr\u0017v"), 141);
        PET_CHAT = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\u0003'\u00190\u000e2\u0012"), 142);
        PET_COMMAND = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("r\u0017v\ra\u001do\u001fc\u001cf"), 143);
        PET_LOOT = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\u0003'\u0019?\t<\u0012"), 144);
        PET_AUTO_POT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002g\u0006}\u0013w\u0006m\rr\u001dv"), 145);
        PET_IGNORE = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\u0003'\u0019:\u0001=\t!\u0003"), 146);
        PET_AUTO_EAT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002g\u0006}\u0013w\u0006m\rg\u0013v"), 147);
        MOVE_SUMMON = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b<\u00106\u0019 \u0013>\u000b<\b"), 148);
        SUMMON_ATTACK = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u0007o\u001fm\u001c}\u0013v\u0006c\u0011i"), 149);
        MOVE_DRAGON = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b<\u00106\u00197\u00142\u0001<\b"), 150);
        GLIDE_DRAGON = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0015n\u001bf\u0017}\u0016p\u0013e\u001dl"), 151);
        DAMAGE_SUMMON = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00022\u000b2\u00016\u0019 \u0013>\u000b<\b"), 152);
        CP_SummonedSkill = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011r\rq'O?M<G6q9K>N"), 153);
        MOVE_LIFE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b<\u00106\u0019?\u000f5\u0003"), 154);
        AUTO_AGGRO = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0013w\u0006m\rc\u0015e\u0000m"), 155);
        FRIENDLY_DAMAGE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0000!\u000f6\b7\n*\u00197\u0007>\u00074\u0003"), 156);
        MONSTER_BOMB = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fm\u001cq\u0006g\u0000}\u0010m\u001f`"), 157);
        MONSTER_BOMB_SINGLE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b<\b \u00126\u0014,\u0004<\u000b1\u0019 \u000f=\u0001?\u0003"), 158);
        HYPNOTIZE_DMG = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("j\u000br\u001cm\u0006k\bg\rf\u001fe"), 159);
        NPC_ACTION = new RecvPacketOpcode(donate.ALLATORIxDEMO("=\u00160\u00192\u0005'\u000f<\b"), 160);
        CHINESE_PVP_RANKING = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001ak\u001cg\u0001g\rr\u0004r\rp\u0013l\u0019k\u001ce"), 161);
        FISHING_KING_RANKING = new RecvPacketOpcode(donate.ALLATORIxDEMO("5\u000f \u000e:\b4\u00198\u000f=\u0001,\u00142\b8\u000f=\u0001"), 162);
        ITEM_PICKUP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("k\u0006g\u001f}\u0002k\u0011i\u0007r"), 163);
        DAMAGE_REACTOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("7\u0007>\u00074\u0003,\u00146\u00070\u0012<\u0014"), 164);
        SNOWBALL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001l\u001du\u0010c\u001en"), 165);
        LEFT_KNOCK_BACK = new RecvPacketOpcode(donate.ALLATORIxDEMO("\n6\u0000'\u00198\b<\u00058\u00191\u00070\r"), 166);
        COCONUT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001da\u001dl\u0007v"), 167);
        MONSTER_CARNIVAL = new RecvPacketOpcode(donate.ALLATORIxDEMO(">\t=\u0015'\u0003!\u00190\u0007!\b:\u00102\n"), 168);
        PARTY_SEARCH_START = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002c\u0000v\u000b}\u0001g\u0013p\u0011j\rq\u0006c\u0000v"), 169);
        PARTY_SEARCH_STOP = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00162\u0014'\u001f,\u00156\u0007!\u0005;\u0019 \u0012<\u0016"), 170);
        START_HARVEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u0006c\u0000v\rj\u0013p\u0004g\u0001v"), 171);
        STOP_HARVEST = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \u0012<\u0016,\u000e2\u0014%\u0003 \u0012"), 172);
        MAKE_EXTRACTOR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fc\u0019g\rg\nv\u0000c\u0011v\u001dp"), 173);
        USE_BAG = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u00042\u0001"), 174);
        CS_UPDATE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u0001}\u0007r\u0016c\u0006g"), 175, 229);
        CASHSHOP_OPERATION = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u0007 \u000e \u000e<\u0016,\t#\u0003!\u0007'\u000f<\b"), 176, 230);
        COUPON_CODE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001dw\u0002m\u001c}\u0011m\u0016g"), 177, 231);
        MAPLETV = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b2\u0016?\u0003'\u0010"), 178);
        REPAIR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0000g\u0002c\u001bp"), 179);
        REPAIR_ALL = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0003#\u0007:\u0014,\u0007?\n"), 180);
        TOUCHING_MTS = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0006m\u0007a\u001ak\u001ce\ro\u0006q"), 181);
        USE_MAGNIFY_GLASS = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u000b2\u0001=\u000f5\u001f,\u0001?\u0007 \u0015"), 182);
        USE_POTENTIAL_SCROLL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u0002m\u0006g\u001cv\u001bc\u001e}\u0001a\u0000m\u001en"), 183);
        USE_EQUIP_SCROLL = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u00196\u0017&\u000f#\u0019 \u0005!\t?\n"), 184);
        GAME_POLL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("e\u0013o\u0017}\u0002m\u001en"), 185);
        OWL = new RecvPacketOpcode(donate.ALLATORIxDEMO("\t$\n"), 186);
        OWL_WARP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001du\u001e}\u0005c\u0000r"), 187);
        CS_XMAS_SURPRISE = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u0015,\u001e>\u0007 \u0019 \u0013!\u0016!\u000f \u0003"), 188);
        USE_OWL_MINERVA = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0001g\rm\u0005n\ro\u001bl\u0017p\u0004c"), 189);
        RPS_GAME = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0016 \u00194\u0007>\u0003"), 190);
        UPDATE_QUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007r\u0016c\u0006g\rs\u0007g\u0001v"), 191);
        QUEST_ITEM = new RecvPacketOpcode(donate.ALLATORIxDEMO("\"\u00136\u0015'\u0019:\u00126\u000b"), 192);
        USE_ITEM_QUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u001bv\u0017o\rs\u0007g\u0001v"), 193);
        USE_ITEM_QUEST2 = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u000f'\u0003>\u0019\"\u00136\u0015't"), 194);
        FOLLOW_REQUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0014m\u001en\u001du\rp\u0017s\u0007g\u0001v"), 195);
        FOLLOW_REPLY = new RecvPacketOpcode(donate.ALLATORIxDEMO("5\t?\n<\u0011,\u00146\u0016?\u001f"), 196);
        PQ_REWARD = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("r\u0003}\u0000g\u0005c\u0000f"), 197);
        MOB_NODE = new RecvPacketOpcode(donate.ALLATORIxDEMO(">\t1\u0019=\t7\u0003"), 198);
        DISPLAY_NODE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0016k\u0001r\u001ec\u000b}\u001cm\u0016g"), 199);
        MOB_BOMB = new RecvPacketOpcode(donate.ALLATORIxDEMO(">\t1\u00191\t>\u0004"), 200);
        TOUCH_REACTOR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("v\u001dw\u0011j\rp\u0017c\u0011v\u001dp"), 201);
        CLICK_REACTOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0005?\u000f0\r,\u00146\u00070\u0012<\u0014"), 202);
        RING_ACTION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("p\u001bl\u0015}\u0013a\u0006k\u001dl"), 203);
        MTS_TAB = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b'\u0015,\u00122\u0004"), 204);
        CP_BeansGameAction = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011r\r`7C<Q\u0015C?G\u0013A&K=L"), 205);
        CP_BeansUpdate = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u0016,\u0004\u0016'\u001d5&6\u0017'\u0007#"), 206);
        SEND_GIFT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u0017l\u0016}\u0015k\u0014v"), 207);
        PET_AUTO_BUFF = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00166\u0012,\u0007&\u0012<\u00191\u00135\u0000"), 208);
        VICIOUS_HAMMER_CASH_RESULT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0004k\u0011k\u001dw\u0001}\u001ac\u001fo\u0017p\ra\u0013q\u001a}\u0000g\u0001w\u001ev"), 209);
        LOGIN_AUTH = new RecvPacketOpcode(donate.ALLATORIxDEMO("?\t4\u000f=\u00192\u0013'\u000e"), 210, false);
        QUICK_SLOT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0003w\u001ba\u0019}\u0001n\u001dv"), 211);
        REISSUE_MEDAL = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00146\u000f \u0015&\u0003,\u000b6\u00022\n"), 212);
        SIDEKICK_OPERATION = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0001k\u0016g\u0019k\u0011i\rm\u0002g\u0000c\u0006k\u001dl"), 213);
        DENY_SIDEKICK_REQUEST = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00026\b*\u0019 \u000f7\u00038\u000f0\r,\u00146\u0017&\u0003 \u0012"), 214);
        MECH_CANCEL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("o\u0017a\u001a}\u0011c\u001ca\u0017n"), 215);
        SUB_SUMMON = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \u00131\u0019 \u0013>\u000b<\b"), 216);
        REMOVE_SUMMON = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("p\u0017o\u001dt\u0017}\u0001w\u001fo\u001dl"), 217);
        SPECIAL_ATTACK = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \u00166\u0005:\u0007?\u00192\u0012'\u00070\r"), 218);
        USE_MECH_DOOR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0001g\ro\u0017a\u001a}\u0016m\u001dp"), 219);
        CRAFT_DONE = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u00142\u0000'\u00197\t=\u0003"), 220);
        CRAFT_MAKE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011p\u0013d\u0006}\u001fc\u0019g"), 221);
        CRAFT_EFFECT = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u00142\u0000'\u00196\u00005\u00030\u0012"), 222);
        ENTER_PVP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("g\u001cv\u0017p\rr\u0004r"), 223);
        ENTER_PVP_PARTY = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0003=\u00126\u0014,\u0016%\u0016,\u00162\u0014'\u001f"), 224);
        PVP_ATTACK = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002t\u0002}\u0013v\u0006c\u0011i"), 225);
        PVP_SUMMON = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\u0010#\u0019 \u0013>\u000b<\b"), 226);
        PVP_RESPAWN = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("r\u0004r\rp\u0017q\u0002c\u0005l"), 227);
        LEAVE_PVP = new RecvPacketOpcode(donate.ALLATORIxDEMO("\n6\u0007%\u0003,\u0016%\u0016"), 228);
        USE_FAMILIAR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u0014c\u001fk\u001ek\u0013p"), 229);
        SPAWN_FAMILIAR = new RecvPacketOpcode(donate.ALLATORIxDEMO(" \u00162\u0011=\u00195\u0007>\u000f?\u000f2\u0014"), 230);
        RENAME_FAMILIAR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("p\u0017l\u0013o\u0017}\u0014c\u001fk\u001ek\u0013p"), 231);
        MOVE_FAMILIAR = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b<\u00106\u00195\u0007>\u000f?\u000f2\u0014"), 232);
        ATTACK_FAMILIAR = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("c\u0006v\u0013a\u0019}\u0014c\u001fk\u001ek\u0013p"), 233);
        TOUCH_FAMILIAR = new RecvPacketOpcode(donate.ALLATORIxDEMO("'\t&\u0005;\u00195\u0007>\u000f?\u000f2\u0014"), 234);
        USE_RECIPE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u0000g\u0011k\u0002g"), 235);
        MOVE_ANDROID = new RecvPacketOpcode(donate.ALLATORIxDEMO(">\t%\u0003,\u0007=\u0002!\t:\u0002"), 236);
        FACE_ANDROID = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0014c\u0011g\rc\u001cf\u0000m\u001bf"), 237);
        LIE_DETECTOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("?\u000f6\u00197\u0003'\u00030\u0012<\u0014"), 238);
        LIE_DETECTOR_SKILL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001ek\u0017}\u0016g\u0006g\u0011v\u001dp\rq\u0019k\u001en"), 239);
        LIE_DETECTOR_RESPONSE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\n:\u0003,\u00026\u00126\u0005'\t!\u0019!\u0003 \u0016<\b \u0003"), 240);
        LIE_DETECTOR_REFRESH = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001ek\u0017}\u0016g\u0006g\u0011v\u001dp\rp\u0017d\u0000g\u0001j"), 241);
        USE_POT = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013 \u0003,\u0016<\u0012"), 242);
        CLEAR_POT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("a\u001eg\u0013p\rr\u001dv"), 243);
        FEED_POT = new RecvPacketOpcode(donate.ALLATORIxDEMO("5\u00036\u0002,\u0016<\u0012"), 244);
        CURE_POT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011w\u0000g\rr\u001dv"), 245);
        REWARD_POT = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0003$\u0007!\u0002,\u0016<\u0012"), 246);
        PAM_SONG = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002c\u001f}\u0001m\u001ce"), 247);
        USE_GASHAPON = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u00194\u0007 \u000e2\u0016<\b"), 248);
        PARTY_REWARD_CHOOSE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("r\u0013p\u0006{\rp\u0017u\u0013p\u0016}\u0011j\u001dm\u0001g"), 249);
        PARTY_REWARD_CLOSE = new RecvPacketOpcode(donate.ALLATORIxDEMO("#\u0007!\u0012*\u0019!\u0003$\u0007!\u0002,\u0005?\t \u0003"), 250);
        RANDOM_RECOMMEND = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0000c\u001cf\u001do\rp\u0017a\u001do\u001fg\u001cf"), 251);
        ANYWHERE_DOOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0007=\u001f$\u000e6\u00146\u00197\t<\u0014"), 252);
        SKILL_SWIPE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u0019k\u001en\rq\u0005k\u0002g"), 253);
        CHOOSE_SKILL = new RecvPacketOpcode(donate.ALLATORIxDEMO("0\u000e<\t \u0003,\u00158\u000f?\n"), 254);
        VIEW_SKILLS = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("t\u001bg\u0005}\u0001i\u001bn\u001eq"), 255);
        QUEST_TIP = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0017&\u0003 \u0012,\u0012:\u0016"), 256);
        LEVEL_GUIDE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("n\u0017t\u0017n\re\u0007k\u0016g"), 257);
        RELEASE_TEMPEST_BLADES = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0003?\u00032\u00156\u0019'\u0003>\u00166\u0015'\u00191\n2\u00026\u0015"), 258);
        DISTRIBUTE_HYPER_SP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("f\u001bq\u0006p\u001b`\u0007v\u0017}\u001a{\u0002g\u0000}\u0001r"), 259);
        RESET_HYPER_SP = new RecvPacketOpcode(donate.ALLATORIxDEMO("!\u0003 \u0003'\u0019;\u001f#\u0003!\u0019 \u0016"), 260);
        REQUEST_SET_OFF_TRINITY = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("p\u0017s\u0007g\u0001v\rq\u0017v\rm\u0014d\rv\u0000k\u001ck\u0006{"), 261);
        LOG_OUT = new RecvPacketOpcode(donate.ALLATORIxDEMO("\n<\u0001,\t&\u0012"), 262);
        TICK = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0006k\u0011i"), 263);
        TICK_MOB = new RecvPacketOpcode(donate.ALLATORIxDEMO("'\u000f0\r,\u000b<\u0004"), 264);
        TICK_SKILL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0006k\u0011i\rq\u0019k\u001en"), 265);
        TICK_SKILL2 = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0012:\u00058\u0019 \r:\n?t"), 266);
        TICK_SKILL3 = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("v\u001ba\u0019}\u0001i\u001bn\u001e\u0011"), 267);
        TICK_SKILL4 = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0012:\u00058\u0019 \r:\n?r"), 268);
        TICK_COUNT = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0006k\u0011i\ra\u001dw\u001cv"), 269);
        TICK_COUNT2 = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0012:\u00058\u00190\t&\b't"), 270);
        TICK_COUNT3 = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("v\u001ba\u0019}\u0011m\u0007l\u0006\u0011"), 271);
        TICK_COUNT4 = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0012:\u00058\u00190\t&\b'r"), 272);
        CANCEL_SKILL_WITH_BUFF = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0011c\u001ca\u0017n\rq\u0019k\u001en\ru\u001bv\u001a}\u0010w\u0014d"), 273);
        PART_TIME_JOB = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00162\u0014'\u0019'\u000f>\u0003,\f<\u0004"), 274);
        UPDATE_FRIEND_POINTS = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007r\u0016c\u0006g\rd\u0000k\u0017l\u0016}\u0002m\u001bl\u0006q"), 275);
        GAIN_FORCE = new RecvPacketOpcode(donate.ALLATORIxDEMO("4\u0007:\b,\u0000<\u00140\u0003"), 276);
        BUFF_FREEZER_REVIVE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("`\u0007d\u0014}\u0014p\u0017g\bg\u0000}\u0000g\u0004k\u0004g"), 277);
        UPDATE_LAPIDIFICATION = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0013#\u00022\u00126\u0019?\u0007#\u000f7\u000f5\u000f0\u0007'\u000f<\b"), 278);
        MONSTER_AREA_DISEASE_SKILL = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u001fm\u001cq\u0006g\u0000}\u0013p\u0017c\rf\u001bq\u0017c\u0001g\rq\u0019k\u001en"), 279);
        TICK_DIRECTION_INFO = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0012:\u00058\u00197\u000f!\u00030\u0012:\t=\u0019:\b5\t"), 280);
        TICK_ANGELIC = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0006k\u0011i\rc\u001ce\u0017n\u001ba"), 281);
        ANDROID_SHOP = new RecvPacketOpcode(donate.ALLATORIxDEMO("2\b7\u0014<\u000f7\u0019 \u000e<\u0016"), 282);
        SILENT_CRUSADE_SHOP = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u001bn\u0017l\u0006}\u0011p\u0007q\u0013f\u0017}\u0001j\u001dr"), 283);
        SILENT_CRUSADE_REWARD = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0015:\n6\b'\u00190\u0014&\u00152\u00026\u0019!\u0003$\u0007!\u0002"), 284);
        SILENT_CRUSADE_CLOSE_UI = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("q\u001bn\u0017l\u0006}\u0011p\u0007q\u0013f\u0017}\u0011n\u001dq\u0017}\u0007k"), 285);
        SHUFFLE_CORE_AURA = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0015;\u00135\u0000?\u0003,\u0005<\u00146\u00192\u0013!\u0007"), 286);
        UPDATE_CORE_AURA_EXPIRE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("w\u0002f\u0013v\u0017}\u0011m\u0000g\rc\u0007p\u0013}\u0017z\u0002k\u0000g"), 287);
        SCROLL_GASHAPON_BOX = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u00150\u0014<\n?\u00194\u0007 \u000e2\u0016<\b,\u0004<\u001e"), 288);
        PVP_TOGGLE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0002t\u0002}\u0006m\u0015e\u001eg"), 289);
        EVENT_TAKE_DAMAGE = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u0003%\u0003=\u0012,\u00122\r6\u00197\u0007>\u00074\u0003"), 290);
        MYSTIC_FIELD_MOVE = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("o\u000bq\u0006k\u0011}\u0014k\u0017n\u0016}\u001fm\u0004g"), 291);
        USE_CIRCULATOR = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u00190\u000f!\u0005&\n2\u0012<\u0014"), 292);
        UPDATE_CORE_AURA = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007r\u0016c\u0006g\ra\u001dp\u0017}\u0013w\u0000c"), 293);
        MOVING_AREA = new RecvPacketOpcode(donate.ALLATORIxDEMO("\u000b<\u0010:\b4\u00192\u00146\u0007"), 294);
        USE_SP_RESET = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("\u0007q\u0017}\u0001r\rp\u0017q\u0017v"), 295);
        USE_AP_RESET = new RecvPacketOpcode(donate.ALLATORIxDEMO("&\u00156\u00192\u0016,\u00146\u00156\u0012"), 296);
        KAISER_COLOR_CHANGE_REQUEST = new RecvPacketOpcode(FamilyPacket.ALLATORIxDEMO("i\u0013k\u0001g\u0000}\u0011m\u001em\u0000}\u0011j\u0013l\u0015g\rp\u0017s\u0007g\u0001v"), 297);
        RecvPacketOpcode[] arrrecvPacketOpcode = new RecvPacketOpcode[298];
        arrrecvPacketOpcode[0] = GARBAGE;
        arrrecvPacketOpcode[1] = CLIENT_HELLO;
        arrrecvPacketOpcode[2] = YUTO_SHIELD_DETECT;
        arrrecvPacketOpcode[3] = CHAIR_GAIN_EXP;
        arrrecvPacketOpcode[4] = REMOVE_LOGIN;
        arrrecvPacketOpcode[5] = LOGIN_PASSWORD;
        arrrecvPacketOpcode[6] = SERVERLIST_REQUEST;
        arrrecvPacketOpcode[7] = CHARLIST_REQUEST;
        arrrecvPacketOpcode[8] = CHAR_SELECT;
        arrrecvPacketOpcode[9] = CHAR_SELECT_SECOND_PASSWORD;
        arrrecvPacketOpcode[10] = PLAYER_LOGGEDIN;
        arrrecvPacketOpcode[11] = CHECK_CHAR_NAME;
        arrrecvPacketOpcode[12] = CHANGE_CHAR_NAME;
        arrrecvPacketOpcode[13] = CREATE_CHAR;
        arrrecvPacketOpcode[14] = CREATE_CHAR_2;
        arrrecvPacketOpcode[15] = CREATE_ULTIMATE;
        arrrecvPacketOpcode[16] = CLIENT_FEEDBACK;
        arrrecvPacketOpcode[17] = DELETE_CHAR;
        arrrecvPacketOpcode[18] = PONG;
        arrrecvPacketOpcode[19] = STRANGE_DATA;
        arrrecvPacketOpcode[20] = CLIENT_ERROR;
        arrrecvPacketOpcode[21] = PACKET_ERROR;
        arrrecvPacketOpcode[22] = HELLO_LOGIN;
        arrrecvPacketOpcode[23] = SERVERSTATUS_REQUEST;
        arrrecvPacketOpcode[24] = HELLO_CHANNEL;
        arrrecvPacketOpcode[25] = SET_GENDER;
        arrrecvPacketOpcode[26] = CLIENT_LOGOUT;
        arrrecvPacketOpcode[27] = CHANGE_MAP;
        arrrecvPacketOpcode[28] = CHANGE_CHANNEL;
        arrrecvPacketOpcode[29] = CHANGE_ROOM_CHANNEL;
        arrrecvPacketOpcode[30] = ENTER_CASH_SHOP;
        arrrecvPacketOpcode[31] = MOVE_PLAYER;
        arrrecvPacketOpcode[32] = CANCEL_CHAIR;
        arrrecvPacketOpcode[33] = USE_CHAIR;
        arrrecvPacketOpcode[34] = SELECT_EXP_CHAIR;
        arrrecvPacketOpcode[35] = CLOSE_RANGE_ATTACK;
        arrrecvPacketOpcode[36] = RANGED_ATTACK;
        arrrecvPacketOpcode[37] = MAGIC_ATTACK;
        arrrecvPacketOpcode[38] = CLUSTER_ATTACK;
        arrrecvPacketOpcode[39] = PASSIVE_ENERGY;
        arrrecvPacketOpcode[40] = TAKE_DAMAGE;
        arrrecvPacketOpcode[41] = TEACH_SKILL;
        arrrecvPacketOpcode[42] = GENERAL_CHAT;
        arrrecvPacketOpcode[43] = CLOSE_CHALKBOARD;
        arrrecvPacketOpcode[44] = FACE_EXPRESSION;
        arrrecvPacketOpcode[45] = USE_ITEMEFFECT;
        arrrecvPacketOpcode[46] = WHEEL_OF_FORTUNE;
        arrrecvPacketOpcode[47] = MONSTER_BOOK_COVER;
        arrrecvPacketOpcode[48] = NPC_TALK;
        arrrecvPacketOpcode[49] = REMOTE_STORE;
        arrrecvPacketOpcode[50] = NPC_TALK_MORE;
        arrrecvPacketOpcode[51] = NPC_SHOP;
        arrrecvPacketOpcode[52] = STORAGE;
        arrrecvPacketOpcode[53] = USE_HIRED_MERCHANT;
        arrrecvPacketOpcode[54] = USE_FISH_MERCHANT;
        arrrecvPacketOpcode[55] = MERCH_ITEM_STORE;
        arrrecvPacketOpcode[56] = DUEY_ACTION;
        arrrecvPacketOpcode[57] = ITEM_SORT;
        arrrecvPacketOpcode[58] = ITEM_GATHER;
        arrrecvPacketOpcode[59] = ITEM_MOVE;
        arrrecvPacketOpcode[60] = MOVE_BAG;
        arrrecvPacketOpcode[61] = SWITCH_BAG;
        arrrecvPacketOpcode[62] = USE_ITEM;
        arrrecvPacketOpcode[63] = CANCEL_ITEM_EFFECT;
        arrrecvPacketOpcode[64] = USE_TITLE;
        arrrecvPacketOpcode[65] = APPLY_WING;
        arrrecvPacketOpcode[66] = DRESSUP_TIME;
        arrrecvPacketOpcode[67] = REQUEST_INSTANCE_TABLE;
        arrrecvPacketOpcode[68] = USE_SUMMON_BAG;
        arrrecvPacketOpcode[69] = USE_EXP_POTION;
        arrrecvPacketOpcode[70] = PET_FOOD;
        arrrecvPacketOpcode[71] = USE_MOUNT_FOOD;
        arrrecvPacketOpcode[72] = USE_SCRIPTED_NPC_ITEM;
        arrrecvPacketOpcode[73] = USE_CASH_ITEM;
        arrrecvPacketOpcode[74] = ITEM_UNLOCK;
        arrrecvPacketOpcode[75] = SOLOMON;
        arrrecvPacketOpcode[76] = GACH_EXP;
        arrrecvPacketOpcode[77] = USE_CATCH_ITEM;
        arrrecvPacketOpcode[78] = USE_SKILL_BOOK;
        arrrecvPacketOpcode[79] = USE_RETURN_SCROLL;
        arrrecvPacketOpcode[80] = USE_UPGRADE_SCROLL;
        arrrecvPacketOpcode[81] = USE_CARVED_SEAL;
        arrrecvPacketOpcode[82] = USE_FLAG_SCROLL;
        arrrecvPacketOpcode[83] = DISTRIBUTE_AP;
        arrrecvPacketOpcode[84] = AUTO_ASSIGN_AP;
        arrrecvPacketOpcode[85] = HEAL_OVER_TIME;
        arrrecvPacketOpcode[86] = DISTRIBUTE_SP;
        arrrecvPacketOpcode[87] = SPECIAL_MOVE;
        arrrecvPacketOpcode[88] = PROFESSION_INFO;
        arrrecvPacketOpcode[89] = CANCEL_BUFF;
        arrrecvPacketOpcode[90] = SKILL_EFFECT;
        arrrecvPacketOpcode[91] = MESO_DROP;
        arrrecvPacketOpcode[92] = GIVE_FAME;
        arrrecvPacketOpcode[93] = THROW_SKILL;
        arrrecvPacketOpcode[94] = CHAR_INFO_REQUEST;
        arrrecvPacketOpcode[95] = SPAWN_PET;
        arrrecvPacketOpcode[96] = CANCEL_DEBUFF;
        arrrecvPacketOpcode[97] = CHANGE_MAP_SPECIAL;
        arrrecvPacketOpcode[98] = USE_INNER_PORTAL;
        arrrecvPacketOpcode[99] = TROCK_ADD_MAP;
        arrrecvPacketOpcode[100] = CP_UserAntiMacroItemUseRequest;
        arrrecvPacketOpcode[101] = CP_UserAntiMacroSkillUseRequest;
        arrrecvPacketOpcode[102] = CP_UserOldAntiMacroQuestionResult;
        arrrecvPacketOpcode[103] = QUEST_ACTION;
        arrrecvPacketOpcode[104] = CP_UserCalcDamageStatSetRequest;
        arrrecvPacketOpcode[105] = CP_UserThrowGrenade;
        arrrecvPacketOpcode[106] = SKILL_MACRO;
        arrrecvPacketOpcode[107] = MAGIC_WHEEL;
        arrrecvPacketOpcode[108] = REWARD_ITEM;
        arrrecvPacketOpcode[109] = ITEM_MAKER;
        arrrecvPacketOpcode[110] = USE_TREASUER_CHEST;
        arrrecvPacketOpcode[111] = PARTYCHAT;
        arrrecvPacketOpcode[112] = WHISPER;
        arrrecvPacketOpcode[113] = MESSENGER;
        arrrecvPacketOpcode[114] = PLAYER_INTERACTION;
        arrrecvPacketOpcode[115] = PARTY_OPERATION;
        arrrecvPacketOpcode[116] = DENY_PARTY_REQUEST;
        arrrecvPacketOpcode[117] = ALLOW_PARTY_INVITE;
        arrrecvPacketOpcode[118] = GUILD_OPERATION;
        arrrecvPacketOpcode[119] = DENY_GUILD_REQUEST;
        arrrecvPacketOpcode[120] = BUDDYLIST_MODIFY;
        arrrecvPacketOpcode[121] = NOTE_ACTION;
        arrrecvPacketOpcode[122] = USE_DOOR;
        arrrecvPacketOpcode[123] = CHANGE_KEYMAP;
        arrrecvPacketOpcode[124] = UPDATE_CHAR_INFO;
        arrrecvPacketOpcode[125] = ENTER_MTS;
        arrrecvPacketOpcode[126] = ALLIANCE_OPERATION;
        arrrecvPacketOpcode[127] = DENY_ALLIANCE_REQUEST;
        arrrecvPacketOpcode[128] = REQUEST_FAMILY;
        arrrecvPacketOpcode[129] = OPEN_FAMILY;
        arrrecvPacketOpcode[130] = FAMILY_OPERATION;
        arrrecvPacketOpcode[131] = DELETE_JUNIOR;
        arrrecvPacketOpcode[132] = DELETE_SENIOR;
        arrrecvPacketOpcode[133] = ACCEPT_FAMILY;
        arrrecvPacketOpcode[134] = USE_FAMILY;
        arrrecvPacketOpcode[135] = FAMILY_PRECEPT;
        arrrecvPacketOpcode[136] = FAMILY_SUMMON;
        arrrecvPacketOpcode[137] = CYGNUS_SUMMON;
        arrrecvPacketOpcode[138] = ARAN_COMBO;
        arrrecvPacketOpcode[139] = BBS_OPERATION;
        arrrecvPacketOpcode[140] = TRANSFORM_PLAYER;
        arrrecvPacketOpcode[141] = MOVE_PET;
        arrrecvPacketOpcode[142] = PET_CHAT;
        arrrecvPacketOpcode[143] = PET_COMMAND;
        arrrecvPacketOpcode[144] = PET_LOOT;
        arrrecvPacketOpcode[145] = PET_AUTO_POT;
        arrrecvPacketOpcode[146] = PET_IGNORE;
        arrrecvPacketOpcode[147] = PET_AUTO_EAT;
        arrrecvPacketOpcode[148] = MOVE_SUMMON;
        arrrecvPacketOpcode[149] = SUMMON_ATTACK;
        arrrecvPacketOpcode[150] = MOVE_DRAGON;
        arrrecvPacketOpcode[151] = GLIDE_DRAGON;
        arrrecvPacketOpcode[152] = DAMAGE_SUMMON;
        arrrecvPacketOpcode[153] = CP_SummonedSkill;
        arrrecvPacketOpcode[154] = MOVE_LIFE;
        arrrecvPacketOpcode[155] = AUTO_AGGRO;
        arrrecvPacketOpcode[156] = FRIENDLY_DAMAGE;
        arrrecvPacketOpcode[157] = MONSTER_BOMB;
        arrrecvPacketOpcode[158] = MONSTER_BOMB_SINGLE;
        arrrecvPacketOpcode[159] = HYPNOTIZE_DMG;
        arrrecvPacketOpcode[160] = NPC_ACTION;
        arrrecvPacketOpcode[161] = CHINESE_PVP_RANKING;
        arrrecvPacketOpcode[162] = FISHING_KING_RANKING;
        arrrecvPacketOpcode[163] = ITEM_PICKUP;
        arrrecvPacketOpcode[164] = DAMAGE_REACTOR;
        arrrecvPacketOpcode[165] = SNOWBALL;
        arrrecvPacketOpcode[166] = LEFT_KNOCK_BACK;
        arrrecvPacketOpcode[167] = COCONUT;
        arrrecvPacketOpcode[168] = MONSTER_CARNIVAL;
        arrrecvPacketOpcode[169] = PARTY_SEARCH_START;
        arrrecvPacketOpcode[170] = PARTY_SEARCH_STOP;
        arrrecvPacketOpcode[171] = START_HARVEST;
        arrrecvPacketOpcode[172] = STOP_HARVEST;
        arrrecvPacketOpcode[173] = MAKE_EXTRACTOR;
        arrrecvPacketOpcode[174] = USE_BAG;
        arrrecvPacketOpcode[175] = CS_UPDATE;
        arrrecvPacketOpcode[176] = CASHSHOP_OPERATION;
        arrrecvPacketOpcode[177] = COUPON_CODE;
        arrrecvPacketOpcode[178] = MAPLETV;
        arrrecvPacketOpcode[179] = REPAIR;
        arrrecvPacketOpcode[180] = REPAIR_ALL;
        arrrecvPacketOpcode[181] = TOUCHING_MTS;
        arrrecvPacketOpcode[182] = USE_MAGNIFY_GLASS;
        arrrecvPacketOpcode[183] = USE_POTENTIAL_SCROLL;
        arrrecvPacketOpcode[184] = USE_EQUIP_SCROLL;
        arrrecvPacketOpcode[185] = GAME_POLL;
        arrrecvPacketOpcode[186] = OWL;
        arrrecvPacketOpcode[187] = OWL_WARP;
        arrrecvPacketOpcode[188] = CS_XMAS_SURPRISE;
        arrrecvPacketOpcode[189] = USE_OWL_MINERVA;
        arrrecvPacketOpcode[190] = RPS_GAME;
        arrrecvPacketOpcode[191] = UPDATE_QUEST;
        arrrecvPacketOpcode[192] = QUEST_ITEM;
        arrrecvPacketOpcode[193] = USE_ITEM_QUEST;
        arrrecvPacketOpcode[194] = USE_ITEM_QUEST2;
        arrrecvPacketOpcode[195] = FOLLOW_REQUEST;
        arrrecvPacketOpcode[196] = FOLLOW_REPLY;
        arrrecvPacketOpcode[197] = PQ_REWARD;
        arrrecvPacketOpcode[198] = MOB_NODE;
        arrrecvPacketOpcode[199] = DISPLAY_NODE;
        arrrecvPacketOpcode[200] = MOB_BOMB;
        arrrecvPacketOpcode[201] = TOUCH_REACTOR;
        arrrecvPacketOpcode[202] = CLICK_REACTOR;
        arrrecvPacketOpcode[203] = RING_ACTION;
        arrrecvPacketOpcode[204] = MTS_TAB;
        arrrecvPacketOpcode[205] = CP_BeansGameAction;
        arrrecvPacketOpcode[206] = CP_BeansUpdate;
        arrrecvPacketOpcode[207] = SEND_GIFT;
        arrrecvPacketOpcode[208] = PET_AUTO_BUFF;
        arrrecvPacketOpcode[209] = VICIOUS_HAMMER_CASH_RESULT;
        arrrecvPacketOpcode[210] = LOGIN_AUTH;
        arrrecvPacketOpcode[211] = QUICK_SLOT;
        arrrecvPacketOpcode[212] = REISSUE_MEDAL;
        arrrecvPacketOpcode[213] = SIDEKICK_OPERATION;
        arrrecvPacketOpcode[214] = DENY_SIDEKICK_REQUEST;
        arrrecvPacketOpcode[215] = MECH_CANCEL;
        arrrecvPacketOpcode[216] = SUB_SUMMON;
        arrrecvPacketOpcode[217] = REMOVE_SUMMON;
        arrrecvPacketOpcode[218] = SPECIAL_ATTACK;
        arrrecvPacketOpcode[219] = USE_MECH_DOOR;
        arrrecvPacketOpcode[220] = CRAFT_DONE;
        arrrecvPacketOpcode[221] = CRAFT_MAKE;
        arrrecvPacketOpcode[222] = CRAFT_EFFECT;
        arrrecvPacketOpcode[223] = ENTER_PVP;
        arrrecvPacketOpcode[224] = ENTER_PVP_PARTY;
        arrrecvPacketOpcode[225] = PVP_ATTACK;
        arrrecvPacketOpcode[226] = PVP_SUMMON;
        arrrecvPacketOpcode[227] = PVP_RESPAWN;
        arrrecvPacketOpcode[228] = LEAVE_PVP;
        arrrecvPacketOpcode[229] = USE_FAMILIAR;
        arrrecvPacketOpcode[230] = SPAWN_FAMILIAR;
        arrrecvPacketOpcode[231] = RENAME_FAMILIAR;
        arrrecvPacketOpcode[232] = MOVE_FAMILIAR;
        arrrecvPacketOpcode[233] = ATTACK_FAMILIAR;
        arrrecvPacketOpcode[234] = TOUCH_FAMILIAR;
        arrrecvPacketOpcode[235] = USE_RECIPE;
        arrrecvPacketOpcode[236] = MOVE_ANDROID;
        arrrecvPacketOpcode[237] = FACE_ANDROID;
        arrrecvPacketOpcode[238] = LIE_DETECTOR;
        arrrecvPacketOpcode[239] = LIE_DETECTOR_SKILL;
        arrrecvPacketOpcode[240] = LIE_DETECTOR_RESPONSE;
        arrrecvPacketOpcode[241] = LIE_DETECTOR_REFRESH;
        arrrecvPacketOpcode[242] = USE_POT;
        arrrecvPacketOpcode[243] = CLEAR_POT;
        arrrecvPacketOpcode[244] = FEED_POT;
        arrrecvPacketOpcode[245] = CURE_POT;
        arrrecvPacketOpcode[246] = REWARD_POT;
        arrrecvPacketOpcode[247] = PAM_SONG;
        arrrecvPacketOpcode[248] = USE_GASHAPON;
        arrrecvPacketOpcode[249] = PARTY_REWARD_CHOOSE;
        arrrecvPacketOpcode[250] = PARTY_REWARD_CLOSE;
        arrrecvPacketOpcode[251] = RANDOM_RECOMMEND;
        arrrecvPacketOpcode[252] = ANYWHERE_DOOR;
        arrrecvPacketOpcode[253] = SKILL_SWIPE;
        arrrecvPacketOpcode[254] = CHOOSE_SKILL;
        arrrecvPacketOpcode[255] = VIEW_SKILLS;
        arrrecvPacketOpcode[256] = QUEST_TIP;
        arrrecvPacketOpcode[257] = LEVEL_GUIDE;
        arrrecvPacketOpcode[258] = RELEASE_TEMPEST_BLADES;
        arrrecvPacketOpcode[259] = DISTRIBUTE_HYPER_SP;
        arrrecvPacketOpcode[260] = RESET_HYPER_SP;
        arrrecvPacketOpcode[261] = REQUEST_SET_OFF_TRINITY;
        arrrecvPacketOpcode[262] = LOG_OUT;
        arrrecvPacketOpcode[263] = TICK;
        arrrecvPacketOpcode[264] = TICK_MOB;
        arrrecvPacketOpcode[265] = TICK_SKILL;
        arrrecvPacketOpcode[266] = TICK_SKILL2;
        arrrecvPacketOpcode[267] = TICK_SKILL3;
        arrrecvPacketOpcode[268] = TICK_SKILL4;
        arrrecvPacketOpcode[269] = TICK_COUNT;
        arrrecvPacketOpcode[270] = TICK_COUNT2;
        arrrecvPacketOpcode[271] = TICK_COUNT3;
        arrrecvPacketOpcode[272] = TICK_COUNT4;
        arrrecvPacketOpcode[273] = CANCEL_SKILL_WITH_BUFF;
        arrrecvPacketOpcode[274] = PART_TIME_JOB;
        arrrecvPacketOpcode[275] = UPDATE_FRIEND_POINTS;
        arrrecvPacketOpcode[276] = GAIN_FORCE;
        arrrecvPacketOpcode[277] = BUFF_FREEZER_REVIVE;
        arrrecvPacketOpcode[278] = UPDATE_LAPIDIFICATION;
        arrrecvPacketOpcode[279] = MONSTER_AREA_DISEASE_SKILL;
        arrrecvPacketOpcode[280] = TICK_DIRECTION_INFO;
        arrrecvPacketOpcode[281] = TICK_ANGELIC;
        arrrecvPacketOpcode[282] = ANDROID_SHOP;
        arrrecvPacketOpcode[283] = SILENT_CRUSADE_SHOP;
        arrrecvPacketOpcode[284] = SILENT_CRUSADE_REWARD;
        arrrecvPacketOpcode[285] = SILENT_CRUSADE_CLOSE_UI;
        arrrecvPacketOpcode[286] = SHUFFLE_CORE_AURA;
        arrrecvPacketOpcode[287] = UPDATE_CORE_AURA_EXPIRE;
        arrrecvPacketOpcode[288] = SCROLL_GASHAPON_BOX;
        arrrecvPacketOpcode[289] = PVP_TOGGLE;
        arrrecvPacketOpcode[290] = EVENT_TAKE_DAMAGE;
        arrrecvPacketOpcode[291] = MYSTIC_FIELD_MOVE;
        arrrecvPacketOpcode[292] = USE_CIRCULATOR;
        arrrecvPacketOpcode[293] = UPDATE_CORE_AURA;
        arrrecvPacketOpcode[294] = MOVING_AREA;
        arrrecvPacketOpcode[295] = USE_SP_RESET;
        arrrecvPacketOpcode[296] = USE_AP_RESET;
        arrrecvPacketOpcode[297] = KAISER_COLOR_CHANGE_REQUEST;
        ALLATORIxDEMO = arrrecvPacketOpcode;
        RecvPacketOpcode.reloadValues();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ RecvPacketOpcode(boolean bl) {
        void a2;
        void var2_-1;
        void var1_-1;
        RecvPacketOpcode a3;
        RecvPacketOpcode recvPacketOpcode = a3;
        recvPacketOpcode.a = (short)-2;
        recvPacketOpcode.d = a2;
    }
}

