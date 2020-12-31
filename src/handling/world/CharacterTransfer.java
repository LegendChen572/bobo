/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.BuddyEntry;
import client.ISkill;
import client.MapleCharacter;
import client.MapleCoreAura;
import client.MapleFriendship;
import client.MapleLieDetector;
import client.MapleTrait;
import client.SkillEntry;
import client.innerSkills.InnerSkillValueHolder;
import client.inventory.IItem;
import client.inventory.MapleImp;
import client.inventory.MapleMount;
import client.inventory.MaplePet;
import constants.GameSetConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.Framework.MapleExtendedSlots;
import server.MapleShopItem;
import server.MapleStorage;
import server.MapleStorageType;
import server.game.BlackJack;
import server.game.NiuNiu;
import server.life.MapleMonsterPet;
import server.quest.MapleQuest;
import tools.Pair;

public class CharacterTransfer
implements Externalizable {
    public /* synthetic */ boolean check_msg_BuyMerChant;
    public /* synthetic */ int mBookCover;
    public /* synthetic */ byte skinColor;
    public /* synthetic */ int mount_exp;
    public /* synthetic */ int[] regrocks;
    public /* synthetic */ int[] FaceAlbum;
    public /* synthetic */ int maxhp;
    public /* synthetic */ Map<Integer, Integer> mbook;
    public /* synthetic */ boolean showRegister;
    public /* synthetic */ String BlessOfEmpress;
    public /* synthetic */ int fishGameHistoryScore;
    public /* synthetic */ MapleImp[] imps;
    public /* synthetic */ int seniorid;
    public /* synthetic */ int addMove;
    public /* synthetic */ List<MapleShopItem> rebuy;
    public /* synthetic */ short soulcount;
    public /* synthetic */ boolean check_msg_Chat;
    public /* synthetic */ String SaveKeyStorage;
    public /* synthetic */ Map<String, Long> CharacterSet_Acc;
    public /* synthetic */ List<MapleExtendedSlots> extendedSlots;
    public /* synthetic */ boolean DebugMessage;
    public /* synthetic */ int pee;
    public /* synthetic */ List<IItem> ShopSellItem;
    public /* synthetic */ int[] remainingHSp;
    public /* synthetic */ byte mount_Fatigue;
    public /* synthetic */ int mount_id;
    public /* synthetic */ int accountid;
    public final /* synthetic */ Map<MapleFriendship.MapleFriendshipType, Integer> friendships;
    public /* synthetic */ byte alliancerank;
    public /* synthetic */ short fame;
    public /* synthetic */ int FishGameTimes;
    public /* synthetic */ int[] savedHairs;
    public /* synthetic */ Object cs;
    public /* synthetic */ Map<String, Long> CharacterSetTemp;
    public /* synthetic */ short level;
    public /* synthetic */ NiuNiu.NiuNiuResultInfo NiuNiuCard;
    public /* synthetic */ List<InnerSkillValueHolder> innerSkills;
    public /* synthetic */ boolean smega;
    public /* synthetic */ int expression;
    public /* synthetic */ boolean check_msg_MobVac;
    public /* synthetic */ byte buddysize;
    public /* synthetic */ int[] rocks;
    public /* synthetic */ int fishkingscore;
    public /* synthetic */ int[] ExcludeItem;
    public /* synthetic */ int face;
    public /* synthetic */ Map<Integer, Pair<Byte, Integer>> keymap;
    public /* synthetic */ int blood;
    public /* synthetic */ long checkdc;
    public /* synthetic */ Object inventorys;
    public /* synthetic */ long dpm;
    public /* synthetic */ int guildid;
    public /* synthetic */ int vpoints;
    public /* synthetic */ boolean cashEquipHide;
    public /* synthetic */ short luk;
    public /* synthetic */ MapleCoreAura coreAura;
    public /* synthetic */ byte gender;
    public /* synthetic */ byte dojoRecord;
    public final /* synthetic */ Map<Integer, Object> Quest;
    public /* synthetic */ HashMap<Integer, Long> LeftSkillTime;
    public /* synthetic */ int[] wishlist;
    public /* synthetic */ int lastday;
    public /* synthetic */ boolean showLogin;
    public /* synthetic */ int partyid;
    public /* synthetic */ String SaveKeyB;
    public /* synthetic */ long lastfametime;
    public /* synthetic */ short int_;
    public /* synthetic */ long lastCheckCopyTime;
    public /* synthetic */ Object skillmacro;
    public /* synthetic */ boolean GashaponMega;
    public /* synthetic */ String accountname;
    public /* synthetic */ int[] savedlocation;
    public /* synthetic */ byte[] petStore;
    public /* synthetic */ boolean loggedIn;
    public /* synthetic */ int constellation;
    public final /* synthetic */ Map<MapleTrait.MapleTraitType, Integer> traits;
    public /* synthetic */ int beans;
    public /* synthetic */ short job;
    public /* synthetic */ int day;
    public /* synthetic */ boolean attackdebug;
    public /* synthetic */ String nowmacs;
    public /* synthetic */ int hair;
    public /* synthetic */ int gachexp;
    public /* synthetic */ String SaveKeyCs;
    public /* synthetic */ long TranferTime;
    public /* synthetic */ Object storage;
    public /* synthetic */ int MaplePoints;
    public /* synthetic */ Map<Integer, String> InfoQuest;
    public /* synthetic */ String BlessOfFairy;
    public /* synthetic */ int marriageId;
    public /* synthetic */ int faceMarking;
    public /* synthetic */ short remainingAp;
    public /* synthetic */ String SaveKeyInventory;
    public /* synthetic */ int exp;
    public /* synthetic */ int totalrep;
    public /* synthetic */ long petVacTime;
    public /* synthetic */ int junior2;
    public final /* synthetic */ Map<Integer, SkillEntry> Skills;
    public /* synthetic */ int fatigue;
    public /* synthetic */ long lastHiredFishingTime;
    public /* synthetic */ int owlCount;
    public /* synthetic */ byte world;
    public /* synthetic */ MapleMonsterPet MonsterPet;
    public /* synthetic */ int[] savedFaces;
    public /* synthetic */ int maxmp;
    public /* synthetic */ int messengerid;
    public /* synthetic */ MapleLieDetector antiMacro;
    public /* synthetic */ int mount_itemid;
    public /* synthetic */ long lastaddmovetime;
    public /* synthetic */ byte mount_level;
    public /* synthetic */ BlackJack.BlackJackResultInfo BlackJackCard;
    public /* synthetic */ int onlinesecs;
    public /* synthetic */ String chalkboard;
    public /* synthetic */ String charmessage;
    public /* synthetic */ int[] remainingSp;
    public /* synthetic */ byte initialSpawnPoint;
    public /* synthetic */ long transfertime;
    public /* synthetic */ int familyid;
    public /* synthetic */ int currentrep;
    public /* synthetic */ List<Pair<Integer, Boolean>> stolenSkills;
    public /* synthetic */ boolean canTalk;
    public /* synthetic */ Map<Integer, Integer> killMapMonsterInfo;
    public /* synthetic */ int meso;
    public /* synthetic */ short dex;
    public /* synthetic */ String name;
    public /* synthetic */ byte subcategory;
    public final /* synthetic */ List<Integer> finishedAchievements;
    public /* synthetic */ int hp;
    public /* synthetic */ Map<MapleStorageType, MapleStorage> storage_exceed;
    public /* synthetic */ List<MaplePet> pets;
    public /* synthetic */ byte fairyExp;
    public /* synthetic */ String prefix;
    public /* synthetic */ boolean Vip_Medal;
    public /* synthetic */ int junior1;
    public /* synthetic */ int peeNumber;
    public /* synthetic */ short str;
    public /* synthetic */ int mapid;
    public /* synthetic */ Map<String, Long> CharacterSet;
    public /* synthetic */ String SaveKeyA;
    public /* synthetic */ byte channel;
    public /* synthetic */ int battleshipHP;
    public /* synthetic */ short hpApUsed;
    public /* synthetic */ int lasthour;
    public /* synthetic */ int points;
    public /* synthetic */ int dojo;
    public /* synthetic */ byte clonez;
    public /* synthetic */ int charm;
    public /* synthetic */ byte gmLevel;
    public /* synthetic */ int MobCount;
    public /* synthetic */ int mp;
    public /* synthetic */ int characterid;
    public final /* synthetic */ Map<BuddyEntry, Boolean> buddies;
    public /* synthetic */ long[] lastTime;
    public /* synthetic */ int[] HairAlbum;
    public /* synthetic */ int KillCount;
    public /* synthetic */ int month;
    public final /* synthetic */ List<Integer> famedcharacters;
    public /* synthetic */ int onlinemins;
    public /* synthetic */ byte guildrank;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public /* synthetic */ void readExternal(ObjectInput a) throws IOException, ClassNotFoundException {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a.antiMacro = (MapleLieDetector)a.readObject();
        }
        v0 = a;
        v1 = a;
        a.lastCheckCopyTime = a.readLong();
        v0.addMove = v1.readInt();
        v0.lastTime = (long[])v1.readObject();
        v2 = a;
        v3 = a;
        v4 = a;
        v5 = a;
        v6 = a;
        v7 = a;
        v8 = a;
        v9 = a;
        v10 = a;
        v11 = a;
        v12 = a;
        v13 = a;
        v14 = a;
        v15 = a;
        v16 = a;
        v17 = a;
        v18 = a;
        v19 = a;
        v20 = a;
        v21 = a;
        v22 = a;
        v22.showRegister = a.readBoolean();
        v22.showLogin = a.readBoolean();
        a.nowmacs = v21.readUTF();
        v20.canTalk = v21.readBoolean();
        v20.attackdebug = a.readBoolean();
        a.DebugMessage = v19.readBoolean();
        v18.check_msg_MobVac = v19.readBoolean();
        v18.Vip_Medal = a.readBoolean();
        a.check_msg_Chat = v17.readBoolean();
        v16.check_msg_BuyMerChant = v17.readBoolean();
        v16.smega = a.readBoolean();
        a.characterid = v15.readInt();
        v14.accountid = v15.readInt();
        v14.accountname = a.readUTF();
        a.channel = v13.readByte();
        v12.MaplePoints = v13.readInt();
        v12.name = a.readUTF();
        a.fame = v11.readShort();
        v10.gender = v11.readByte();
        v10.level = a.readShort();
        a.str = v9.readShort();
        v8.dex = v9.readShort();
        v8.int_ = a.readShort();
        a.luk = v7.readShort();
        v6.hp = v7.readShort();
        v6.mp = a.readShort();
        a.maxhp = v5.readShort();
        v4.maxmp = v5.readShort();
        v4.exp = a.readInt();
        a.hpApUsed = v3.readShort();
        v2.remainingAp = v3.readShort();
        v2.remainingSp = new int[a.readByte()];
        v23 = var2_2 = 0;
        while (v23 < a.remainingSp.length) {
            a.remainingSp[var2_2++] = a.readInt();
            v23 = var2_2;
        }
        a.savedHairs = new int[a.readByte()];
        v24 = var2_2 = 0;
        while (v24 < a.savedHairs.length) {
            a.savedHairs[var2_2++] = a.readInt();
            v24 = var2_2;
        }
        a.savedFaces = new int[a.readByte()];
        v25 = var2_2 = 0;
        while (v25 < a.savedFaces.length) {
            a.savedFaces[var2_2++] = a.readInt();
            v25 = var2_2;
        }
        v26 = a;
        v27 = a;
        v28 = a;
        v29 = a;
        v30 = a;
        v31 = a;
        v32 = a;
        v33 = a;
        v34 = a;
        v35 = a;
        a.beans = a.readInt();
        a.meso = v35.readInt();
        v34.skinColor = v35.readByte();
        v34.job = a.readShort();
        a.hair = v33.readInt();
        v32.face = v33.readInt();
        v32.mapid = a.readInt();
        a.initialSpawnPoint = v31.readByte();
        v30.world = v31.readByte();
        v30.guildid = a.readInt();
        a.guildrank = v29.readByte();
        v28.alliancerank = v29.readByte();
        v28.gmLevel = a.readByte();
        v26.points = v27.readInt();
        v26.vpoints = v27.readInt();
        a.BlessOfFairy = a.readByte() == 1 ? a.readUTF() : null;
        if (GameSetConstants.MAPLE_VERSION < 134) ** GOTO lbl113
        if (a.readByte() == 1) {
            v36 = a;
            v37 = v36;
            a.BlessOfEmpress = v36.readUTF();
        } else {
            a.BlessOfEmpress = null;
lbl113:
            // 2 sources

            v37 = a;
        }
        if (v37.readByte() == 1) {
            v38 = a;
            a.chalkboard = a.readUTF();
        } else {
            v38 = a;
            a.chalkboard = null;
        }
        v38.clonez = a.readByte();
        v39 = a;
        v40 = a;
        v41 = a;
        v42 = a;
        v43 = a;
        v44 = a;
        v45 = a;
        v46 = a;
        v47 = a;
        v48 = a;
        v49 = a;
        v50 = a;
        v51 = a;
        v52 = a;
        v53 = a;
        v54 = a;
        v55 = a;
        v56 = a;
        v57 = a;
        v58 = a;
        v59 = a;
        v60 = a;
        v61 = a;
        a.skillmacro = a.readObject();
        a.lastaddmovetime = v61.readLong();
        v60.lastfametime = v61.readLong();
        v60.storage = a.readObject();
        a.cs = v59.readObject();
        v58.mount_itemid = v59.readInt();
        v58.mount_Fatigue = a.readByte();
        a.mount_level = v57.readByte();
        v56.mount_exp = v57.readInt();
        v56.partyid = a.readInt();
        a.messengerid = v55.readInt();
        v54.mBookCover = v55.readInt();
        v54.dojo = a.readInt();
        a.dojoRecord = v53.readByte();
        v52.inventorys = v53.readObject();
        v52.fairyExp = a.readByte();
        a.subcategory = v51.readByte();
        v50.marriageId = v51.readInt();
        v50.familyid = a.readInt();
        a.seniorid = v49.readInt();
        v48.junior1 = v49.readInt();
        v48.junior2 = a.readInt();
        a.currentrep = v47.readInt();
        v46.totalrep = v47.readInt();
        v46.charmessage = a.readUTF();
        a.expression = v45.readByte();
        v44.constellation = v45.readInt();
        v44.blood = a.readInt();
        a.month = v43.readInt();
        v42.day = v43.readInt();
        v42.battleshipHP = a.readInt();
        a.prefix = v41.readUTF();
        v40.gachexp = v41.readInt();
        v40.MobCount = a.readInt();
        a.dpm = v39.readLong();
        var2_2 = v39.readShort();
        v62 = var3_4 = 0;
        while (v62 < var2_2) {
            a.mbook.put(a.readInt(), a.readInt());
            v62 = ++var3_4;
        }
        var3_4 = a.readShort();
        v63 = var2_2 = 0;
        while (v63 < var3_4) {
            a.Skills.put(a.readInt(), new SkillEntry(a.readByte(), a.readByte(), a.readLong()));
            v63 = ++var2_2;
        }
        var2_2 = a.readShort();
        v64 = var3_4 = 0;
        while (v64 < var2_2) {
            a.LeftSkillTime.put(a.readInt(), a.readLong());
            v64 = ++var3_4;
        }
        a.buddysize = a.readByte();
        var3_4 = a.readShort();
        v65 = var2_2 = 0;
        while (v65 < var3_4) {
            a.buddies.put(new BuddyEntry(a.readUTF(), a.readInt(), a.readUTF(), a.readInt(), a.readInt(), a.readBoolean(), a.readInt(), a.readInt(), a.readInt()), a.readBoolean());
            v65 = ++var2_2;
        }
        var2_2 = a.readShort();
        v66 = var3_4 = 0;
        while (v66 < var2_2) {
            a.Quest.put(a.readInt(), a.readObject());
            v66 = ++var3_4;
        }
        var3_4 = a.readShort();
        v67 = var2_2 = 0;
        while (v67 < var3_4) {
            a.finishedAchievements.add(a.readInt());
            v67 = ++var2_2;
        }
        var2_2 = a.readInt();
        v68 = var3_4 = 0;
        while (v68 < var2_2) {
            a.famedcharacters.add(a.readInt());
            v68 = ++var3_4;
        }
        var3_4 = a.readShort();
        a.savedlocation = new int[var3_4];
        v69 = var2_2 = 0;
        while (v69 < var3_4) {
            a.savedlocation[var2_2++] = a.readInt();
            v69 = var2_2;
        }
        var2_2 = a.readShort();
        a.wishlist = new int[var2_2];
        v70 = var3_4 = 0;
        while (v70 < var2_2) {
            a.wishlist[var3_4++] = a.readInt();
            v70 = var3_4;
        }
        var3_4 = a.readShort();
        a.rocks = new int[var3_4];
        v71 = var2_2 = 0;
        while (v71 < var3_4) {
            a.rocks[var2_2++] = a.readInt();
            v71 = var2_2;
        }
        var2_2 = a.readShort();
        a.regrocks = new int[var2_2];
        v72 = var3_4 = 0;
        while (v72 < var2_2) {
            a.regrocks[var3_4++] = a.readInt();
            v72 = var3_4;
        }
        var3_4 = a.readShort();
        v73 = var2_2 = 0;
        while (v73 < var3_4) {
            a.InfoQuest.put(a.readInt(), a.readUTF());
            v73 = ++var2_2;
        }
        var2_2 = a.readInt();
        v74 = var3_4 = 0;
        while (v74 < var2_2) {
            a.keymap.put(a.readInt(), new Pair<Byte, Integer>(a.readByte(), a.readInt()));
            v74 = ++var3_4;
        }
        a.petStore = new byte[a.readByte()];
        v75 = var3_4 = 0;
        while (v75 < 3) {
            a.petStore[var3_4++] = a.readByte();
            v75 = var3_4;
        }
        a.imps = new MapleImp[a.readByte()];
        v76 = var3_4 = 0;
        while (v76 < a.imps.length) {
            if (a.readByte() > 0) {
                v77 = var2_3 = new MapleImp(a.readInt());
                v78 = a;
                var2_3.setFullness(a.readShort());
                var2_3.setCloseness(v78.readShort());
                v77.setState(v78.readByte());
                v77.setLevel(a.readByte());
                a.imps[var3_4] = var2_3;
            }
            v76 = ++var3_4;
        }
        v79 = var3_4 = 0;
        while (v79 < MapleTrait.MapleTraitType.values().length) {
            a.traits.put(MapleTrait.MapleTraitType.values()[a.readByte()], a.readInt());
            v79 = ++var3_4;
        }
        v80 = var3_4 = 0;
        while (true) {
            if (v80 >= MapleFriendship.MapleFriendshipType.values().length) {
                a.TranferTime = System.currentTimeMillis();
                return;
            }
            a.friendships.put(MapleFriendship.MapleFriendshipType.values()[a.readByte()], a.readInt());
            v80 = ++var3_4;
        }
    }

    public /* synthetic */ CharacterTransfer() {
        CharacterTransfer a2;
        CharacterTransfer characterTransfer = a2;
        CharacterTransfer characterTransfer2 = a2;
        CharacterTransfer characterTransfer3 = a2;
        CharacterTransfer characterTransfer4 = a2;
        CharacterTransfer characterTransfer5 = a2;
        CharacterTransfer characterTransfer6 = a2;
        CharacterTransfer characterTransfer7 = a2;
        a2.storage_exceed = new LinkedHashMap<MapleStorageType, MapleStorage>();
        characterTransfer7.LeftSkillTime = new HashMap();
        a2.mbook = new LinkedHashMap<Integer, Integer>();
        a2.keymap = new LinkedHashMap<Integer, Pair<Byte, Integer>>();
        a2.finishedAchievements = new ArrayList<Integer>();
        a2.famedcharacters = new ArrayList<Integer>();
        a2.buddies = new LinkedHashMap<BuddyEntry, Boolean>();
        a2.Quest = new LinkedHashMap<Integer, Object>();
        a2.InfoQuest = new LinkedHashMap<Integer, String>();
        a2.Skills = new LinkedHashMap<Integer, SkillEntry>();
        characterTransfer6.NiuNiuCard = null;
        characterTransfer5.BlackJackCard = null;
        characterTransfer6.CharacterSet = new HashMap<String, Long>();
        characterTransfer5.CharacterSet_Acc = new HashMap<String, Long>();
        characterTransfer5.CharacterSetTemp = new HashMap<String, Long>();
        characterTransfer5.ShopSellItem = new ArrayList<IItem>();
        characterTransfer5.friendships = new EnumMap<MapleFriendship.MapleFriendshipType, Integer>(MapleFriendship.MapleFriendshipType.class);
        characterTransfer5.traits = new EnumMap<MapleTrait.MapleTraitType, Integer>(MapleTrait.MapleTraitType.class);
        characterTransfer5.pets = new ArrayList<MaplePet>();
        characterTransfer5.killMapMonsterInfo = new HashMap<Integer, Integer>();
        characterTransfer5.rebuy = new ArrayList<MapleShopItem>();
        characterTransfer4.checkdc = -1L;
        characterTransfer4.SaveKeyA = "";
        characterTransfer3.SaveKeyB = "";
        characterTransfer3.SaveKeyStorage = "";
        characterTransfer2.SaveKeyCs = "";
        characterTransfer.SaveKeyInventory = "";
        characterTransfer2.stolenSkills = new ArrayList<Pair<Integer, Boolean>>();
        characterTransfer.innerSkills = new LinkedList<InnerSkillValueHolder>();
    }

    @Override
    public /* synthetic */ void writeExternal(ObjectOutput a2) throws IOException {
        int n2;
        Object object;
        int n3;
        Object object2;
        int n4;
        CharacterTransfer a3;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeObject(a3.antiMacro);
        }
        ObjectOutput objectOutput = a2;
        CharacterTransfer characterTransfer = a3;
        ObjectOutput objectOutput2 = a2;
        CharacterTransfer characterTransfer2 = a3;
        ObjectOutput objectOutput3 = a2;
        CharacterTransfer characterTransfer3 = a3;
        ObjectOutput objectOutput4 = a2;
        CharacterTransfer characterTransfer4 = a3;
        ObjectOutput objectOutput5 = a2;
        CharacterTransfer characterTransfer5 = a3;
        ObjectOutput objectOutput6 = a2;
        CharacterTransfer characterTransfer6 = a3;
        ObjectOutput objectOutput7 = a2;
        CharacterTransfer characterTransfer7 = a3;
        ObjectOutput objectOutput8 = a2;
        CharacterTransfer characterTransfer8 = a3;
        ObjectOutput objectOutput9 = a2;
        CharacterTransfer characterTransfer9 = a3;
        ObjectOutput objectOutput10 = a2;
        CharacterTransfer characterTransfer10 = a3;
        ObjectOutput objectOutput11 = a2;
        CharacterTransfer characterTransfer11 = a3;
        ObjectOutput objectOutput12 = a2;
        CharacterTransfer characterTransfer12 = a3;
        a2.writeLong(characterTransfer12.lastCheckCopyTime);
        objectOutput12.writeInt(characterTransfer12.addMove);
        objectOutput12.writeObject(a3.lastTime);
        a2.writeBoolean(characterTransfer11.showLogin);
        objectOutput11.writeBoolean(characterTransfer11.showRegister);
        objectOutput11.writeUTF(a3.nowmacs);
        a2.writeBoolean(characterTransfer10.canTalk);
        objectOutput10.writeBoolean(characterTransfer10.attackdebug);
        objectOutput10.writeBoolean(a3.DebugMessage);
        a2.writeBoolean(characterTransfer9.check_msg_MobVac);
        objectOutput9.writeBoolean(characterTransfer9.Vip_Medal);
        objectOutput9.writeBoolean(a3.check_msg_BuyMerChant);
        a2.writeBoolean(characterTransfer8.check_msg_Chat);
        objectOutput8.writeBoolean(characterTransfer8.smega);
        objectOutput8.writeInt(a3.characterid);
        a2.writeInt(characterTransfer7.accountid);
        objectOutput7.writeUTF(characterTransfer7.accountname);
        objectOutput7.writeByte(a3.channel);
        a2.writeInt(characterTransfer6.MaplePoints);
        objectOutput6.writeUTF(characterTransfer6.name);
        objectOutput6.writeShort(a3.fame);
        a2.writeByte(characterTransfer5.gender);
        objectOutput5.writeShort(characterTransfer5.level);
        objectOutput5.writeShort(a3.str);
        a2.writeShort(characterTransfer4.dex);
        objectOutput4.writeShort(characterTransfer4.int_);
        objectOutput4.writeShort(a3.luk);
        a2.writeShort(characterTransfer3.hp);
        objectOutput3.writeShort(characterTransfer3.mp);
        objectOutput3.writeShort(a3.maxhp);
        a2.writeShort(characterTransfer2.maxmp);
        objectOutput2.writeInt(characterTransfer2.exp);
        objectOutput2.writeShort(a3.hpApUsed);
        objectOutput.writeShort(characterTransfer.remainingAp);
        objectOutput.writeByte(characterTransfer.remainingSp.length);
        int n5 = n4 = 0;
        while (n5 < a3.remainingSp.length) {
            a2.writeInt(a3.remainingSp[n4++]);
            n5 = n4;
        }
        a2.writeByte(a3.savedHairs.length);
        int n6 = n4 = 0;
        while (n6 < a3.savedHairs.length) {
            a2.writeInt(a3.savedHairs[n4++]);
            n6 = n4;
        }
        a2.writeByte(a3.savedFaces.length);
        int n7 = n4 = 0;
        while (n7 < a3.savedFaces.length) {
            a2.writeInt(a3.savedFaces[n4++]);
            n7 = n4;
        }
        ObjectOutput objectOutput13 = a2;
        CharacterTransfer characterTransfer13 = a3;
        ObjectOutput objectOutput14 = a2;
        CharacterTransfer characterTransfer14 = a3;
        ObjectOutput objectOutput15 = a2;
        CharacterTransfer characterTransfer15 = a3;
        ObjectOutput objectOutput16 = a2;
        CharacterTransfer characterTransfer16 = a3;
        ObjectOutput objectOutput17 = a2;
        CharacterTransfer characterTransfer17 = a3;
        ObjectOutput objectOutput18 = a2;
        objectOutput18.writeInt(a3.beans);
        objectOutput18.writeInt(a3.meso);
        a2.writeByte(characterTransfer17.skinColor);
        objectOutput17.writeShort(characterTransfer17.job);
        objectOutput17.writeInt(a3.hair);
        a2.writeInt(characterTransfer16.face);
        objectOutput16.writeInt(characterTransfer16.mapid);
        objectOutput16.writeByte(a3.initialSpawnPoint);
        a2.writeByte(characterTransfer15.world);
        objectOutput15.writeInt(characterTransfer15.guildid);
        objectOutput15.writeByte(a3.guildrank);
        a2.writeByte(characterTransfer14.alliancerank);
        objectOutput14.writeByte(characterTransfer14.gmLevel);
        objectOutput14.writeInt(a3.points);
        objectOutput13.writeInt(characterTransfer13.vpoints);
        objectOutput13.writeByte(characterTransfer13.BlessOfFairy == null ? 0 : 1);
        if (a3.BlessOfFairy != null) {
            a2.writeUTF(a3.BlessOfFairy);
        }
        a2.writeByte(a3.chalkboard == null ? 0 : 1);
        if (a3.chalkboard != null) {
            a2.writeUTF(a3.chalkboard);
        }
        ObjectOutput objectOutput19 = a2;
        CharacterTransfer characterTransfer18 = a3;
        ObjectOutput objectOutput20 = a2;
        CharacterTransfer characterTransfer19 = a3;
        ObjectOutput objectOutput21 = a2;
        CharacterTransfer characterTransfer20 = a3;
        ObjectOutput objectOutput22 = a2;
        CharacterTransfer characterTransfer21 = a3;
        ObjectOutput objectOutput23 = a2;
        CharacterTransfer characterTransfer22 = a3;
        ObjectOutput objectOutput24 = a2;
        CharacterTransfer characterTransfer23 = a3;
        ObjectOutput objectOutput25 = a2;
        CharacterTransfer characterTransfer24 = a3;
        ObjectOutput objectOutput26 = a2;
        CharacterTransfer characterTransfer25 = a3;
        ObjectOutput objectOutput27 = a2;
        CharacterTransfer characterTransfer26 = a3;
        ObjectOutput objectOutput28 = a2;
        CharacterTransfer characterTransfer27 = a3;
        ObjectOutput objectOutput29 = a2;
        CharacterTransfer characterTransfer28 = a3;
        ObjectOutput objectOutput30 = a2;
        CharacterTransfer characterTransfer29 = a3;
        ObjectOutput objectOutput31 = a2;
        objectOutput31.writeByte(a3.clonez);
        objectOutput31.writeObject(a3.skillmacro);
        a2.writeLong(characterTransfer29.lastaddmovetime);
        objectOutput30.writeLong(characterTransfer29.lastfametime);
        objectOutput30.writeObject(a3.storage);
        a2.writeObject(characterTransfer28.cs);
        objectOutput29.writeInt(characterTransfer28.mount_itemid);
        objectOutput29.writeByte(a3.mount_Fatigue);
        a2.writeByte(characterTransfer27.mount_level);
        objectOutput28.writeInt(characterTransfer27.mount_exp);
        objectOutput28.writeInt(a3.partyid);
        a2.writeInt(characterTransfer26.messengerid);
        objectOutput27.writeInt(characterTransfer26.mBookCover);
        objectOutput27.writeInt(a3.dojo);
        a2.writeByte(characterTransfer25.dojoRecord);
        objectOutput26.writeObject(characterTransfer25.inventorys);
        objectOutput26.writeByte(a3.fairyExp);
        a2.writeByte(characterTransfer24.subcategory);
        objectOutput25.writeInt(characterTransfer24.marriageId);
        objectOutput25.writeInt(a3.familyid);
        a2.writeInt(characterTransfer23.seniorid);
        objectOutput24.writeInt(characterTransfer23.junior1);
        objectOutput24.writeInt(a3.junior2);
        a2.writeInt(characterTransfer22.currentrep);
        objectOutput23.writeInt(characterTransfer22.totalrep);
        objectOutput23.writeInt(a3.battleshipHP);
        a2.writeUTF(characterTransfer21.charmessage);
        objectOutput22.writeInt(characterTransfer21.expression);
        objectOutput22.writeInt(a3.constellation);
        a2.writeInt(characterTransfer20.blood);
        objectOutput21.writeInt(characterTransfer20.month);
        objectOutput21.writeInt(a3.day);
        a2.writeUTF(characterTransfer19.prefix);
        objectOutput20.writeInt(characterTransfer19.gachexp);
        objectOutput20.writeInt(a3.MobCount);
        objectOutput19.writeLong(characterTransfer18.dpm);
        objectOutput19.writeShort(characterTransfer18.mbook.size());
        Iterator<Map.Entry<Integer, Object>> iterator = a3.mbook.entrySet().iterator();
        Iterator<Map.Entry<Integer, Object>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            object2 = iterator.next();
            a2.writeInt(object2.getKey());
            a2.writeInt(object2.getValue());
            iterator2 = iterator;
        }
        a2.writeShort(a3.Skills.size());
        iterator = a3.Skills.entrySet().iterator();
        Iterator<Map.Entry<Object, Object>> iterator3 = iterator;
        while (iterator3.hasNext()) {
            object2 = iterator.next();
            a2.writeInt(object2.getKey());
            a2.writeByte(((SkillEntry)object2.getValue()).skillevel);
            a2.writeByte(((SkillEntry)object2.getValue()).masterlevel);
            a2.writeLong(((SkillEntry)object2.getValue()).expiration);
            iterator3 = iterator;
        }
        a2.writeShort(a3.LeftSkillTime.size());
        iterator = a3.LeftSkillTime.entrySet().iterator();
        Iterator<Map.Entry<Object, Object>> iterator4 = iterator;
        while (iterator4.hasNext()) {
            object2 = iterator.next();
            a2.writeInt(object2.getKey());
            a2.writeLong((Long)object2.getValue());
            iterator4 = iterator;
        }
        ObjectOutput objectOutput32 = a2;
        CharacterTransfer characterTransfer30 = a3;
        objectOutput32.writeByte(characterTransfer30.buddysize);
        objectOutput32.writeShort(characterTransfer30.buddies.size());
        iterator = a3.buddies.entrySet().iterator();
        Iterator<Object> iterator5 = iterator;
        while (iterator5.hasNext()) {
            object2 = iterator.next();
            a2.writeUTF(((BuddyEntry)object2.getKey()).getName());
            a2.writeInt(((BuddyEntry)object2.getKey()).getCharacterId());
            a2.writeUTF(((BuddyEntry)object2.getKey()).getGroup());
            a2.writeInt(((BuddyEntry)object2.getKey()).getChannel());
            a2.writeBoolean((Boolean)object2.getValue());
            a2.writeBoolean((Boolean)object2.getValue());
            iterator5 = iterator;
        }
        a2.writeShort(a3.Quest.size());
        iterator = a3.Quest.entrySet().iterator();
        Iterator<Map.Entry<Integer, Object>> iterator6 = iterator;
        while (iterator6.hasNext()) {
            object2 = iterator.next();
            a2.writeInt((Integer)object2.getKey());
            iterator6 = iterator;
            a2.writeObject(object2.getValue());
        }
        a2.writeShort(a3.finishedAchievements.size());
        iterator = a3.finishedAchievements.iterator();
        Iterator<Object> iterator7 = iterator;
        while (iterator7.hasNext()) {
            object2 = (Integer)iterator.next();
            iterator7 = iterator;
            a2.writeInt((Integer)object2);
        }
        a2.writeInt(a3.famedcharacters.size());
        iterator = a3.famedcharacters.iterator();
        Iterator<Object> iterator8 = iterator;
        while (iterator8.hasNext()) {
            object2 = (Integer)iterator.next();
            iterator8 = iterator;
            a2.writeInt((Integer)object2);
        }
        a2.writeShort(a3.savedlocation.length);
        iterator = (Iterator<Map.Entry<Integer, Object>>)a3.savedlocation;
        int n8 = a3.savedlocation.length;
        int n9 = n3 = 0;
        while (n9 < n8) {
            Object object3 = iterator[n3];
            object = object3;
            a2.writeInt((int)object3);
            n9 = ++n3;
        }
        a2.writeShort(a3.wishlist.length);
        iterator = (Iterator<Map.Entry<Integer, Object>>)a3.wishlist;
        n8 = a3.wishlist.length;
        int n10 = n3 = 0;
        while (n10 < n8) {
            Object object4 = iterator[n3];
            object = object4;
            a2.writeInt((int)object4);
            n10 = ++n3;
        }
        a2.writeShort(a3.rocks.length);
        iterator = (Iterator<Map.Entry<Integer, Object>>)a3.rocks;
        n8 = a3.rocks.length;
        int n11 = n3 = 0;
        while (n11 < n8) {
            Object object5 = iterator[n3];
            object = object5;
            a2.writeInt((int)object5);
            n11 = ++n3;
        }
        a2.writeShort(a3.regrocks.length);
        iterator = (Iterator<Map.Entry<Integer, Object>>)a3.regrocks;
        n8 = a3.regrocks.length;
        int n12 = n3 = 0;
        while (n12 < n8) {
            Object object6 = iterator[n3];
            object = object6;
            a2.writeInt((int)object6);
            n12 = ++n3;
        }
        a2.writeShort(a3.InfoQuest.size());
        iterator = a3.InfoQuest.entrySet().iterator();
        Iterator<Map.Entry<Integer, Object>> iterator9 = iterator;
        while (iterator9.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            a2.writeInt(entry.getKey());
            a2.writeUTF(entry.getValue());
            iterator9 = iterator;
        }
        a2.writeInt(a3.keymap.size());
        iterator = a3.keymap.entrySet().iterator();
        Iterator<Map.Entry<Integer, Object>> iterator10 = iterator;
        while (iterator10.hasNext()) {
            Map.Entry<Integer, Object> entry = iterator.next();
            a2.writeInt(entry.getKey());
            a2.writeByte(((Byte)((Pair)entry.getValue()).left).byteValue());
            a2.writeInt((Integer)((Pair)entry.getValue()).right);
            iterator10 = iterator;
        }
        a2.writeByte(a3.petStore.length);
        int n13 = n2 = 0;
        while (n13 < a3.petStore.length) {
            a2.writeByte(a3.petStore[n2++]);
            n13 = n2;
        }
        a2.writeByte(a3.imps.length);
        int n14 = n2 = 0;
        while (n14 < a3.imps.length) {
            ObjectOutput objectOutput33 = a2;
            if (a3.imps[n2] != null) {
                objectOutput33.writeByte(1);
                ObjectOutput objectOutput34 = a2;
                CharacterTransfer characterTransfer31 = a3;
                ObjectOutput objectOutput35 = a2;
                objectOutput35.writeInt(a3.imps[n2].getItemId());
                objectOutput35.writeShort(a3.imps[n2].getFullness());
                a2.writeShort(characterTransfer31.imps[n2].getCloseness());
                objectOutput34.writeByte(characterTransfer31.imps[n2].getState());
                objectOutput34.writeByte(a3.imps[n2].getLevel());
            } else {
                objectOutput33.writeByte(0);
            }
            n14 = ++n2;
        }
        Iterator<Map.Entry<Enum, Integer>> iterator11 = a3.traits.entrySet().iterator();
        Iterator<Map.Entry<Enum, Integer>> iterator12 = iterator11;
        while (iterator12.hasNext()) {
            Map.Entry<MapleTrait.MapleTraitType, Integer> entry = iterator11.next();
            a2.writeByte(entry.getKey().ordinal());
            a2.writeInt(entry.getValue());
            iterator12 = iterator11;
        }
        iterator11 = a3.friendships.entrySet().iterator();
        Iterator<Map.Entry<Enum, Integer>> iterator13 = iterator11;
        while (iterator13.hasNext()) {
            Map.Entry<Enum, Integer> entry = iterator11.next();
            a2.writeByte(((MapleFriendship.MapleFriendshipType)entry.getKey()).ordinal());
            a2.writeInt(entry.getValue());
            iterator13 = iterator11;
        }
    }

    public /* synthetic */ CharacterTransfer(MapleCharacter a2) {
        CharacterTransfer characterTransfer;
        Object object;
        Object object2;
        int n2;
        CharacterTransfer a3;
        CharacterTransfer characterTransfer2 = a3;
        CharacterTransfer characterTransfer3 = a3;
        CharacterTransfer characterTransfer4 = a3;
        CharacterTransfer characterTransfer5 = a3;
        CharacterTransfer characterTransfer6 = a3;
        CharacterTransfer characterTransfer7 = a3;
        CharacterTransfer characterTransfer8 = a3;
        a3.storage_exceed = new LinkedHashMap<MapleStorageType, MapleStorage>();
        characterTransfer8.LeftSkillTime = new HashMap();
        a3.mbook = new LinkedHashMap<Integer, Integer>();
        a3.keymap = new LinkedHashMap<Integer, Pair<Byte, Integer>>();
        a3.finishedAchievements = new ArrayList<Integer>();
        a3.famedcharacters = new ArrayList<Integer>();
        a3.buddies = new LinkedHashMap<BuddyEntry, Boolean>();
        a3.Quest = new LinkedHashMap<Integer, Object>();
        a3.InfoQuest = new LinkedHashMap<Integer, String>();
        a3.Skills = new LinkedHashMap<Integer, SkillEntry>();
        characterTransfer7.NiuNiuCard = null;
        characterTransfer6.BlackJackCard = null;
        characterTransfer7.CharacterSet = new HashMap<String, Long>();
        characterTransfer6.CharacterSet_Acc = new HashMap<String, Long>();
        characterTransfer6.CharacterSetTemp = new HashMap<String, Long>();
        characterTransfer6.ShopSellItem = new ArrayList<IItem>();
        characterTransfer6.friendships = new EnumMap<MapleFriendship.MapleFriendshipType, Integer>(MapleFriendship.MapleFriendshipType.class);
        characterTransfer6.traits = new EnumMap<MapleTrait.MapleTraitType, Integer>(MapleTrait.MapleTraitType.class);
        characterTransfer6.pets = new ArrayList<MaplePet>();
        characterTransfer6.killMapMonsterInfo = new HashMap<Integer, Integer>();
        characterTransfer6.rebuy = new ArrayList<MapleShopItem>();
        characterTransfer5.checkdc = -1L;
        characterTransfer5.SaveKeyA = "";
        characterTransfer4.SaveKeyB = "";
        characterTransfer4.SaveKeyStorage = "";
        characterTransfer3.SaveKeyCs = "";
        characterTransfer2.SaveKeyInventory = "";
        characterTransfer3.stolenSkills = new ArrayList<Pair<Integer, Boolean>>();
        characterTransfer2.innerSkills = new LinkedList<InnerSkillValueHolder>();
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            CharacterTransfer characterTransfer9 = a3;
            characterTransfer9.BlessOfEmpress = a2.getBlessOfEmpressOrigin();
            characterTransfer9.antiMacro = a2.getAntiMacro();
        }
        CharacterTransfer characterTransfer10 = a3;
        MapleCharacter mapleCharacter = a2;
        CharacterTransfer characterTransfer11 = a3;
        MapleCharacter mapleCharacter2 = a2;
        CharacterTransfer characterTransfer12 = a3;
        MapleCharacter mapleCharacter3 = a2;
        CharacterTransfer characterTransfer13 = a3;
        MapleCharacter mapleCharacter4 = a2;
        CharacterTransfer characterTransfer14 = a3;
        MapleCharacter mapleCharacter5 = a2;
        CharacterTransfer characterTransfer15 = a3;
        MapleCharacter mapleCharacter6 = a2;
        CharacterTransfer characterTransfer16 = a3;
        MapleCharacter mapleCharacter7 = a2;
        CharacterTransfer characterTransfer17 = a3;
        MapleCharacter mapleCharacter8 = a2;
        CharacterTransfer characterTransfer18 = a3;
        MapleCharacter mapleCharacter9 = a2;
        CharacterTransfer characterTransfer19 = a3;
        MapleCharacter mapleCharacter10 = a2;
        CharacterTransfer characterTransfer20 = a3;
        MapleCharacter mapleCharacter11 = a2;
        CharacterTransfer characterTransfer21 = a3;
        MapleCharacter mapleCharacter12 = a2;
        CharacterTransfer characterTransfer22 = a3;
        MapleCharacter mapleCharacter13 = a2;
        CharacterTransfer characterTransfer23 = a3;
        MapleCharacter mapleCharacter14 = a2;
        CharacterTransfer characterTransfer24 = a3;
        MapleCharacter mapleCharacter15 = a2;
        CharacterTransfer characterTransfer25 = a3;
        MapleCharacter mapleCharacter16 = a2;
        CharacterTransfer characterTransfer26 = a3;
        MapleCharacter mapleCharacter17 = a2;
        CharacterTransfer characterTransfer27 = a3;
        MapleCharacter mapleCharacter18 = a2;
        CharacterTransfer characterTransfer28 = a3;
        MapleCharacter mapleCharacter19 = a2;
        CharacterTransfer characterTransfer29 = a3;
        MapleCharacter mapleCharacter20 = a2;
        CharacterTransfer characterTransfer30 = a3;
        MapleCharacter mapleCharacter21 = a2;
        CharacterTransfer characterTransfer31 = a3;
        MapleCharacter mapleCharacter22 = a2;
        CharacterTransfer characterTransfer32 = a3;
        MapleCharacter mapleCharacter23 = a2;
        CharacterTransfer characterTransfer33 = a3;
        MapleCharacter mapleCharacter24 = a2;
        CharacterTransfer characterTransfer34 = a3;
        MapleCharacter mapleCharacter25 = a2;
        CharacterTransfer characterTransfer35 = a3;
        MapleCharacter mapleCharacter26 = a2;
        CharacterTransfer characterTransfer36 = a3;
        MapleCharacter mapleCharacter27 = a2;
        CharacterTransfer characterTransfer37 = a3;
        MapleCharacter mapleCharacter28 = a2;
        CharacterTransfer characterTransfer38 = a3;
        MapleCharacter mapleCharacter29 = a2;
        CharacterTransfer characterTransfer39 = a3;
        MapleCharacter mapleCharacter30 = a2;
        CharacterTransfer characterTransfer40 = a3;
        MapleCharacter mapleCharacter31 = a2;
        CharacterTransfer characterTransfer41 = a3;
        MapleCharacter mapleCharacter32 = a2;
        CharacterTransfer characterTransfer42 = a3;
        MapleCharacter mapleCharacter33 = a2;
        CharacterTransfer characterTransfer43 = a3;
        MapleCharacter mapleCharacter34 = a2;
        CharacterTransfer characterTransfer44 = a3;
        MapleCharacter mapleCharacter35 = a2;
        CharacterTransfer characterTransfer45 = a3;
        MapleCharacter mapleCharacter36 = a2;
        CharacterTransfer characterTransfer46 = a3;
        MapleCharacter mapleCharacter37 = a2;
        CharacterTransfer characterTransfer47 = a3;
        MapleCharacter mapleCharacter38 = a2;
        a3.loggedIn = a2.isLoggedIn();
        a3.soulcount = mapleCharacter38.getSoulCount();
        characterTransfer47.coreAura = mapleCharacter38.getCoreAura();
        characterTransfer47.innerSkills = a2.getInnerSkills();
        a3.stolenSkills = mapleCharacter37.getStolenSkills();
        characterTransfer46.SaveKeyInventory = mapleCharacter37.getSaveKeyInventory();
        characterTransfer46.SaveKeyCs = a2.getSaveKeyCs();
        a3.SaveKeyStorage = mapleCharacter36.getSaveKeyStorage();
        characterTransfer45.SaveKeyB = mapleCharacter36.getSaveKeyB();
        characterTransfer45.SaveKeyA = a2.getSaveKeyA();
        a3.cashEquipHide = mapleCharacter35.getCashEquipHide();
        characterTransfer44.KillCount = mapleCharacter35.getKillCount();
        characterTransfer44.petVacTime = a2.getPetVacTime();
        a3.transfertime = mapleCharacter34.getTransferTime();
        characterTransfer43.rebuy = mapleCharacter34.getRebuy();
        characterTransfer43.fishGameHistoryScore = a2.getFishGameHistoryScore();
        a3.FishGameTimes = mapleCharacter33.getFishGameTime();
        characterTransfer42.lastday = mapleCharacter33.getLastDay();
        characterTransfer42.onlinesecs = a2.getOnlineSecond();
        a3.onlinemins = mapleCharacter32.getOnlineMins();
        characterTransfer41.charm = mapleCharacter32.getCharm();
        characterTransfer41.faceMarking = a2.getFaceMarking();
        a3.extendedSlots = mapleCharacter31.getExtendedSlots();
        characterTransfer40.fatigue = mapleCharacter31.getFatigue();
        characterTransfer40.imps = a2.getImps();
        a3.pets = mapleCharacter30.getPets();
        characterTransfer39.GashaponMega = mapleCharacter30.getGashaponMega();
        characterTransfer39.ShopSellItem = a2.getSell();
        a3.CharacterSetTemp = mapleCharacter29.getCharacterSetTemp();
        characterTransfer38.CharacterSet = mapleCharacter29.getCharacterSet();
        characterTransfer38.CharacterSet_Acc = a2.getCharacterSet_Acc();
        a3.NiuNiuCard = mapleCharacter28.getNiuNiuCard();
        characterTransfer37.BlackJackCard = mapleCharacter28.getBlackJackCard();
        characterTransfer37.MonsterPet = a2.getMonsterPet();
        a3.owlCount = mapleCharacter27.getOwlCount();
        characterTransfer36.lastHiredFishingTime = mapleCharacter27.getLastHiredFishingTime();
        characterTransfer36.lastCheckCopyTime = a2.getLastCheckCopyTime();
        a3.FaceAlbum = mapleCharacter26.GetFaceAlbum();
        characterTransfer35.HairAlbum = mapleCharacter26.GetHairAlbum();
        characterTransfer35.ExcludeItem = a2.GetExcludeItem();
        a3.mount_id = mapleCharacter25.getMountId();
        characterTransfer34.pee = mapleCharacter25.getPee();
        characterTransfer34.addMove = a2.getAddMove();
        a3.lastTime = mapleCharacter24.getCheatTracker().getLastGMspam();
        characterTransfer33.showRegister = mapleCharacter24.getShow(1);
        characterTransfer33.showLogin = a2.getShow(2);
        a3.nowmacs = mapleCharacter23.getNowMacs();
        characterTransfer32.canTalk = mapleCharacter23.getCanTalk();
        characterTransfer32.attackdebug = a2.getAttackDebugMessage();
        a3.DebugMessage = mapleCharacter22.getDebugMessage();
        characterTransfer31.check_msg_MobVac = mapleCharacter22.getmsg_MobVac();
        characterTransfer31.Vip_Medal = a2.getVipMedal();
        a3.check_msg_Chat = mapleCharacter21.getmsg_Chat();
        characterTransfer30.check_msg_BuyMerChant = mapleCharacter21.getmsg_HiredMerchant();
        characterTransfer30.smega = a2.getSmega();
        a3.characterid = mapleCharacter20.getId();
        characterTransfer29.accountid = mapleCharacter20.getAccountID();
        characterTransfer29.accountname = a2.getClient().getAccountName();
        a3.channel = (byte)mapleCharacter19.getClient().getChannel();
        characterTransfer28.MaplePoints = mapleCharacter19.getCSPoints(2);
        characterTransfer28.vpoints = a2.getVPoints();
        a3.name = mapleCharacter18.getName();
        characterTransfer27.fame = mapleCharacter18.getFame();
        characterTransfer27.gender = a2.getGender();
        a3.level = mapleCharacter17.getLevel();
        characterTransfer26.str = mapleCharacter17.getStat().getStr();
        characterTransfer26.dex = a2.getStat().getDex();
        a3.int_ = mapleCharacter16.getStat().getInt();
        characterTransfer25.luk = mapleCharacter16.getStat().getLuk();
        characterTransfer25.hp = a2.getStat().getHp();
        a3.mp = mapleCharacter15.getStat().getMp();
        characterTransfer24.maxhp = mapleCharacter15.getStat().getMaxHp();
        characterTransfer24.maxmp = a2.getStat().getMaxMp();
        a3.exp = mapleCharacter14.getExp();
        characterTransfer23.hpApUsed = mapleCharacter14.getHpMpApUsed();
        characterTransfer23.remainingAp = a2.getRemainingAp();
        a3.remainingSp = mapleCharacter13.getRemainingSps();
        characterTransfer22.remainingHSp = mapleCharacter13.getRemainingHSps();
        characterTransfer22.beans = a2.getBeans();
        a3.meso = mapleCharacter12.getMeso();
        characterTransfer21.skinColor = mapleCharacter12.getSkinColor();
        characterTransfer21.job = a2.getJob();
        a3.hair = mapleCharacter11.getHair();
        characterTransfer20.face = mapleCharacter11.getFace();
        characterTransfer20.mapid = a2.getMapId();
        a3.initialSpawnPoint = mapleCharacter10.getInitialSpawnpoint();
        characterTransfer19.marriageId = mapleCharacter10.getMarriageId();
        characterTransfer19.world = a2.getWorld();
        a3.guildid = mapleCharacter9.getGuildId();
        characterTransfer18.guildrank = mapleCharacter9.getGuildRank();
        characterTransfer18.alliancerank = a2.getAllianceRank();
        a3.gmLevel = (byte)mapleCharacter8.getGMLevel();
        characterTransfer17.points = mapleCharacter8.getPoints();
        characterTransfer17.fairyExp = a2.getFairyExp();
        a3.clonez = mapleCharacter7.getNumClones();
        characterTransfer16.petStore = mapleCharacter7.getPetStores();
        characterTransfer16.subcategory = a2.getSubcategory();
        a3.currentrep = mapleCharacter6.getCurrentRep();
        characterTransfer15.totalrep = mapleCharacter6.getTotalRep();
        characterTransfer15.familyid = a2.getFamilyId();
        a3.seniorid = mapleCharacter5.getSeniorId();
        characterTransfer14.junior1 = mapleCharacter5.getJunior1();
        characterTransfer14.junior2 = a2.getJunior2();
        a3.charmessage = mapleCharacter4.getcharmessage();
        characterTransfer13.expression = mapleCharacter4.getexpression();
        characterTransfer13.constellation = a2.getconstellation();
        a3.blood = mapleCharacter3.getblood();
        characterTransfer12.month = mapleCharacter3.getmonth();
        characterTransfer12.day = a2.getday();
        a3.battleshipHP = mapleCharacter2.getCurrentBattleshipHP();
        characterTransfer11.prefix = mapleCharacter2.getPrefix();
        characterTransfer11.gachexp = a2.getGachExp();
        characterTransfer10.MobCount = mapleCharacter.getMobCount();
        characterTransfer10.dpm = mapleCharacter.getDPM();
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < a3.petStore.length) {
            object2 = a2.getPet(n2);
            if (a3.petStore[n2] == 0) {
                a3.petStore[n2] = -1;
            }
            if (object2 != null) {
                n3 = 1;
                CharacterTransfer characterTransfer48 = a3;
                int n5 = n2;
                characterTransfer48.petStore[n5] = (byte)Math.max(characterTransfer48.petStore[n5], ((MaplePet)object2).getInventoryPosition());
            }
            n4 = ++n2;
        }
        if (n3 != 0) {
            a2.unequipAllPets();
        }
        Object object3 = object = a2.getBuddylist().getBuddies().iterator();
        while (object3.hasNext()) {
            object2 = object.next();
            object3 = object;
            Object object4 = object2;
            a3.buddies.put((BuddyEntry)object4, ((BuddyEntry)object4).isVisible());
        }
        CharacterTransfer characterTransfer49 = a3;
        MapleCharacter mapleCharacter39 = a2;
        characterTransfer49.buddysize = mapleCharacter39.getBuddyCapacity();
        characterTransfer49.partyid = mapleCharacter39.getPartyId();
        CharacterTransfer characterTransfer50 = a3;
        if (a2.getMessenger() != null) {
            characterTransfer50.messengerid = a2.getMessenger().getId();
            characterTransfer = a3;
        } else {
            characterTransfer50.messengerid = 0;
            characterTransfer = a3;
        }
        characterTransfer.mBookCover = a2.getMonsterBookCover();
        MapleCharacter mapleCharacter40 = a2;
        CharacterTransfer characterTransfer51 = a3;
        characterTransfer51.dojo = a2.getDojo();
        characterTransfer51.dojoRecord = (byte)a2.getDojoRecord();
        a3.InfoQuest = mapleCharacter40.getInfoQuest_Map();
        Object object5 = object = mapleCharacter40.getQuest_Map().entrySet().iterator();
        while (object5.hasNext()) {
            object2 = (Map.Entry)object.next();
            a3.Quest.put(((MapleQuest)object2.getKey()).getId(), object2.getValue());
            object5 = object;
        }
        CharacterTransfer characterTransfer52 = a3;
        MapleCharacter mapleCharacter41 = a2;
        characterTransfer52.mbook = mapleCharacter41.getMonsterBook().getCards();
        characterTransfer52.inventorys = mapleCharacter41.getInventorys();
        Object object6 = object = a2.getSkills().entrySet().iterator();
        while (object6.hasNext()) {
            object2 = (Map.Entry)object.next();
            a3.Skills.put(((ISkill)object2.getKey()).getId(), (SkillEntry)object2.getValue());
            object6 = object;
        }
        Object object7 = object = a2.getSkillWorkings().entrySet().iterator();
        while (object7.hasNext()) {
            object2 = (Map.Entry)object.next();
            a3.LeftSkillTime.put((Integer)object2.getKey(), (Long)object2.getValue());
            object7 = object;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            Iterator<Object> iterator;
            object = MapleTrait.MapleTraitType.values();
            int n6 = ((MapleTrait.MapleTraitType[])object).length;
            int n7 = n3 = 0;
            while (n7 < n6) {
                Iterator<Object> iterator2 = iterator = object[n3];
                a3.traits.put((MapleTrait.MapleTraitType)((Object)iterator2), a2.getTrait((MapleTrait.MapleTraitType)((Object)iterator2)).getTotalExp());
                n7 = ++n3;
            }
            object = MapleFriendship.MapleFriendshipType.values();
            n6 = ((MapleFriendship.MapleFriendshipType[])object).length;
            int n8 = n3 = 0;
            while (n8 < n6) {
                Iterator<Object> iterator3 = iterator = object[n3];
                a3.friendships.put((MapleFriendship.MapleFriendshipType)((Object)iterator3), a2.getFriendship((MapleFriendship.MapleFriendshipType)((Object)iterator3)).getPoints());
                n8 = ++n3;
            }
        }
        CharacterTransfer characterTransfer53 = a3;
        MapleCharacter mapleCharacter42 = a2;
        CharacterTransfer characterTransfer54 = a3;
        MapleCharacter mapleCharacter43 = a2;
        CharacterTransfer characterTransfer55 = a3;
        MapleCharacter mapleCharacter44 = a2;
        a3.BlessOfFairy = mapleCharacter44.getBlessOfFairyOrigin();
        characterTransfer55.chalkboard = mapleCharacter44.getChalkboard();
        characterTransfer55.skillmacro = a2.getMacros();
        a3.keymap = mapleCharacter43.getKeyLayout().Layout();
        characterTransfer54.savedlocation = mapleCharacter43.getSavedLocations();
        characterTransfer54.wishlist = a2.getWishlist();
        characterTransfer53.rocks = mapleCharacter42.getRocks();
        characterTransfer53.regrocks = mapleCharacter42.getRegRocks();
        Object object8 = object = a2.getFamedCharacters().iterator();
        while (object8.hasNext()) {
            Integer n9 = (Integer)object.next();
            object8 = object;
            a3.famedcharacters.add(n9);
        }
        CharacterTransfer characterTransfer56 = a3;
        MapleCharacter mapleCharacter45 = a2;
        a3.lastaddmovetime = a2.getLastAddMoveTime();
        characterTransfer56.lastfametime = mapleCharacter45.getLastFameTime();
        characterTransfer56.storage = mapleCharacter45.getStorage();
        if (GameSetConstants.STORAGE_EXCEED) {
            a3.storage_exceed = a2.getStorageExceed();
        }
        CharacterTransfer characterTransfer57 = a3;
        CharacterTransfer characterTransfer58 = a3;
        characterTransfer58.cs = a2.getCashInventory();
        object = a2.getMount();
        characterTransfer57.mount_itemid = ((MapleMount)object).getItemId();
        characterTransfer58.mount_Fatigue = ((MapleMount)object).getFatigue();
        characterTransfer57.mount_level = ((MapleMount)object).getLevel();
        characterTransfer57.mount_exp = ((MapleMount)object).getExp();
        characterTransfer57.TranferTime = System.currentTimeMillis();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 ^ 5;
        int cfr_ignored_0 = 5 << 4 ^ 5 << 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ (3 ^ 5);
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
}

