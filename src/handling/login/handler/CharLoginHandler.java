/*
 * Decompiled with CFR 0.150.
 */
package handling.login.handler;

import FuckingHackerToby.cd;
import client.ClientRedirector;
import client.LoginCrypto;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.PlayerStats;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryIdentifierPet;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.GameStringConstants;
import constants.ItemConstants;
import constants.ServerConfig;
import constants.WorldConstants;
import database.DBConPool;
import handling.auction.handler.MTSOperation;
import handling.channel.ChannelServer;
import handling.login.LoginInformationProvider;
import handling.login.LoginServer;
import handling.login.LoginWorker;
import handling.login.handler.AutoRegister;
import handling.opcodes.LoginType;
import handling.world.World;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.quest.MapleQuest;
import tools.FileoutputUtil;
import tools.KoreanDateUtil;
import tools.MaplePacketCreator;
import tools.StringTool;
import tools.StringUtil;
import tools.crypt.AESOperator;
import tools.data.LittleEndianAccessor;
import tools.otp.GoogleAuthenticator;
import tools.packet.LoginPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class CharLoginHandler {
    private static /* synthetic */ List<String> ALLATORIxDEMO;

    public static final /* synthetic */ void ServerListRequest(MapleClient a2) {
        if (!a2.isCanloginpw()) {
            a2.getSession().close();
            return;
        }
        MapleClient mapleClient = a2;
        mapleClient.updateLoginState(3, mapleClient.getSessionIPAddress());
        LoginServer.forceRemoveClient(a2, false);
        if (GameSetConstants.MAPLE_VERSION <= 116) {
            Iterator<World> iterator;
            Iterator<World> iterator2 = iterator = LoginServer.getWorlds().iterator();
            while (iterator2.hasNext()) {
                World world = iterator.next();
                iterator2 = iterator;
                a2.sendPacket(LoginPacket.getServerList(world.getWorldId(), LoginPacket.Server.getById(world.getWorldId()).toString(), world.getFlag(), world.getEventMessage(), world.getChannels()));
            }
            MapleClient mapleClient2 = a2;
            mapleClient2.sendPacket(LoginPacket.getEndOfServerList());
            mapleClient2.sendPacket(LoginPacket.getWorldSelected(mapleClient2.getLastWorld()));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void handleCreateCharacter(LittleEndianAccessor a2, MapleClient a3, boolean a42) {
        int n2;
        MapleCharacter mapleCharacter;
        int n3;
        int n4;
        byte by;
        MapleClient mapleClient;
        int n5;
        byte by2;
        short s2;
        int n6;
        int n7;
        int n8;
        MapleItemInformationProvider mapleItemInformationProvider;
        LoginInformationProvider loginInformationProvider;
        String string;
        LinkedHashMap<LoginInformationProvider.JobInfoFlag, Integer> linkedHashMap;
        block81: {
            block80: {
                block79: {
                    linkedHashMap = new LinkedHashMap<LoginInformationProvider.JobInfoFlag, Integer>();
                    string = a2.readMapleAsciiString();
                    loginInformationProvider = LoginInformationProvider.getInstance();
                    mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                    if (StringTool.containsBlank(string) || !StringTool.isNormalName(string)) {
                        return;
                    }
                    if (!MapleCharacterUtil.canCreateChar(string) || loginInformationProvider.isForbiddenName(string)) {
                        System.out.println("\u975e\u6cd5\u5275\u5efa\u89d2\u8272\u540d: " + string);
                        return;
                    }
                    MapleClient mapleClient2 = a3;
                    if (!mapleClient2.canMakeCharacter(mapleClient2.getWorld())) {
                        return;
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 151 && a42 != 0) {
                        a2.readInt();
                    }
                    n8 = GameSetConstants.MAPLE_VERSION != 75 ? a2.readInt() : 1;
                    if (GameSetConstants.MAPLE_VERSION != 147) break block79;
                    if (n8 != 8) break block80;
                    n7 = n8 = 19;
                    break block81;
                }
                if (GameSetConstants.MAPLE_VERSION == 149 && n8 == 10) {
                    n8 = 19;
                }
            }
            n7 = n8;
        }
        LoginInformationProvider.JobType jobType = LoginInformationProvider.JobType.getByType(n7);
        if (jobType == null) {
            System.out.println("\u767c\u73fe\u65b0\u8077\u696d\u985e\u578b: " + n8);
            return;
        }
        LoginInformationProvider.JobType[] arrjobType = LoginInformationProvider.JobType.values();
        int n9 = arrjobType.length;
        int n10 = n6 = 0;
        while (n10 < n9) {
            LoginInformationProvider.JobType jobType2 = arrjobType[n6];
            if (jobType2.type == n8 && !jobType2.enableCreate()) {
                MapleClient mapleClient3 = a3;
                mapleClient3.sendPacket(MaplePacketCreator.getPopupMsg(MTSOperation.ALLATORIxDEMO("\u5fab\u62fd\u6b6aA)\u6b28\u8054\u6921\u5c39\u6766\u95a8\u6572\u3021")));
                mapleClient3.sendPacket(LoginPacket.getLoginFailed(1));
                return;
            }
            n10 = ++n6;
        }
        if (!GameSetConstants.CREATE_KOC && n8 == LoginInformationProvider.JobType.\u7687\u5bb6\u9a0e\u58eb\u5718.type) {
            MapleClient mapleClient4 = a3;
            mapleClient4.sendPacket(MaplePacketCreator.getPopupMsg(ClientRedirector.ALLATORIxDEMO("\u5fbd\u62f5\u6b7cI?\u76c3\u5b83\u9a4a\u58de\u575c\u90b1\u676e\u95be\u657a8N\u65d0\u5fc8\u59b7\u67d8\u4fdb\u5fd3\u5ddb\u4e49\u592f\u6747\u95be\u657a\u3037")));
            mapleClient4.sendPacket(LoginPacket.getLoginFailed(1));
            return;
        }
        if (!GameSetConstants.CREATE_EVAN && n8 == LoginInformationProvider.JobType.\u9f8d\u9b54\u5c0e\u58eb.type) {
            MapleClient mapleClient5 = a3;
            mapleClient5.sendPacket(MaplePacketCreator.getPopupMsg(MTSOperation.ALLATORIxDEMO("\u5fab\u62fd\u6b6aA)\u9fc1\u9b77\u5c42\u58c8\u90c8\u6709\u95c7\u651dA)\u76a2\u526e\u6b28\u8054\u6921\u5909\u7257\u000f\u8af3\u6557\u5fc0\u6720\u51c1\u95a8\u6572\u3021")));
            mapleClient5.sendPacket(LoginPacket.getLoginFailed(1));
            return;
        }
        if (!GameSetConstants.CREATE_RESIST && n8 == LoginInformationProvider.JobType.\u672b\u65e5\u53cd\u6297\u8ecd.type) {
            MapleClient mapleClient6 = a3;
            mapleClient6.sendPacket(MaplePacketCreator.getPopupMsg(ClientRedirector.ALLATORIxDEMO("\u5fcc\u6284\u6b0d8N\u671e\u65a1\u53f8\u62d3\u8ef8\u90c0\u671f\u95cf\u650bI?\u76aa\u5278\u6b20\u8042\u6929\u591f\u5f73\u0019\u8afb\u6541\u5fc8\u6736\u51c9\u95be\u657a\u3037")));
            mapleClient6.sendPacket(LoginPacket.getLoginFailed(1));
            return;
        }
        byte by3 = (byte)(jobType == LoginInformationProvider.JobType.\u72c2\u72fc\u52c7\u58eb ? 11 : (jobType == LoginInformationProvider.JobType.\u7687\u5bb6\u9a0e\u58eb\u5718 ? 10 : 0));
        int n11 = by3 == 0 ? 1 : 0;
        short s3 = s2 = GameSetConstants.MAPLE_VERSION > 113 ? a2.readShort() : (short)0;
        if (!GameSetConstants.CREATE_DUALBLADE && s2 == 1 && jobType == LoginInformationProvider.JobType.\u5192\u96aa\u5bb6) {
            MapleClient mapleClient7 = a3;
            mapleClient7.sendPacket(MaplePacketCreator.getPopupMsg(MTSOperation.ALLATORIxDEMO("\u5fab\u62fd\u6b6aA)\u5f3d\u6b45\u8049\u90a7\u6766\u95a8\u6572\u3021")));
            mapleClient7.sendPacket(LoginPacket.getLoginFailed(1));
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 151 && a42 == 0) {
            a2.readInt();
        }
        if (s2 == 2) {
            jobType = LoginInformationProvider.JobType.\u91cd\u7832\u6307\u63ee\u5b98;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            LittleEndianAccessor littleEndianAccessor = a2;
            by2 = littleEndianAccessor.readByte();
            by3 = littleEndianAccessor.readByte();
            n5 = littleEndianAccessor.readByte();
            n11 = 1;
        }
        n9 = 0;
        n6 = 0;
        int n12 = 0;
        n5 = 0;
        boolean bl = false;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        if (jobType != null) {
            bl2 = jobType == LoginInformationProvider.JobType.\u7c73\u54c8\u9038;
            n9 = jobType == LoginInformationProvider.JobType.\u5f71\u6b66\u8005 ? 1 : 0;
            n6 = jobType == LoginInformationProvider.JobType.\u672b\u65e5\u53cd\u6297\u8ecd ? 1 : 0;
            n12 = jobType == LoginInformationProvider.JobType.\u7cbe\u9748\u904a\u4fe0 ? 1 : 0;
            n5 = jobType == LoginInformationProvider.JobType.\u60e1\u9b54\u6bba\u624b ? 1 : 0;
            bl = jobType == LoginInformationProvider.JobType.\u84bc\u9f8d\u4fe0\u5ba2;
            n13 = jobType == LoginInformationProvider.JobType.\u5e7b\u5f71\u4fe0\u76dc ? 1 : 0;
            n14 = jobType == LoginInformationProvider.JobType.\u5929\u4f7f\u7834\u58de\u8005 ? 1 : 0;
            int n16 = n15 = jobType == LoginInformationProvider.JobType.\u591c\u5149 ? 1 : 0;
        }
        if (n12 != 0 || n5 != 0 || bl || n13 != 0 || n15 != 0) {
            bl3 = true;
            mapleClient = a3;
        } else {
            if (GameSetConstants.MAPLE_VERSION == 149 && n9 != 0) {
                bl3 = true;
            }
            mapleClient = a3;
        }
        by2 = mapleClient.getGender();
        if (bl2) {
            by = by2 = 0;
        } else {
            if (n14 != 0) {
                by2 = 1;
            }
            by = by2;
        }
        if (by > 1 || by2 < 0) {
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fk}%V/\u001a\u6063\u5210\u6f4b\u6d2bjA<A"), FileoutputUtil.CurrentReadable_Time() + " \u540d\u7a31: " + string + " \u5e33\u865f: " + a3.getAccountName() + " \u6027\u5225: " + by2);
            a3.getSession().close();
            return;
        }
        n5 = 3;
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            n5 = 20;
            n4 = n8;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                n5 = 6;
            }
            n4 = n8;
        }
        if (n4 > n5 || n8 < 0) {
            FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+Pck-@'\f\u803b\u694e\u6f43\u6d3dbW4W"), FileoutputUtil.CurrentReadable_Time() + " \u540d\u7a31: " + string + " \u5e33\u865f: " + a3.getAccountName() + " \u8077\u696d: " + n8);
            a3.getSession().close();
            return;
        }
        switch (jobType) {
            case \u7687\u5bb6\u9a0e\u58eb\u5718: {
                by3 = 10;
                n3 = n11 = 1;
                break;
            }
            case \u72c2\u72fc\u52c7\u58eb: {
                by3 = 11;
                n3 = n11 = 1;
                break;
            }
            case \u7cbe\u9748\u904a\u4fe0: {
                by3 = 12;
                n3 = n11 = 1;
                break;
            }
            case \u60e1\u9b54\u6bba\u624b: {
                by3 = 13;
                n11 = 1;
            }
            default: {
                n3 = n11;
            }
        }
        if (n3 == 0) {
            System.err.println("\u5275\u5efa\u8077\u696d\u76ae\u819a\u984f\u8272\u932f\u8aa4, \u8077\u696d:" + jobType.name() + " \u76ae\u819a:" + by3);
            return;
        }
        n5 = 0;
        if (GameSetConstants.MAPLE_VERSION == 139 || a42 != 0) {
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(3);
            n5 = littleEndianAccessor.readByte();
        }
        a42 = 0;
        n11 = 0;
        if (jobType == LoginInformationProvider.JobType.\u5e7b\u5f71\u4fe0\u76dc || jobType == LoginInformationProvider.JobType.\u5f71\u6b66\u8005 || jobType == LoginInformationProvider.JobType.\u84bc\u9f8d\u4fe0\u5ba2 || jobType == LoginInformationProvider.JobType.\u7cbe\u9748\u904a\u4fe0 || jobType == LoginInformationProvider.JobType.\u51f1\u6492) {
            n11 = 1;
        }
        LoginInformationProvider.JobInfoFlag[] arrjobInfoFlag = LoginInformationProvider.JobInfoFlag.values();
        n6 = arrjobInfoFlag.length;
        int n17 = n12 = 0;
        while (n17 < n6) {
            LoginInformationProvider.JobInfoFlag jobInfoFlag = arrjobInfoFlag[n12];
            if (jobInfoFlag.check(jobType.flag)) {
                n14 = a2.readInt();
                n15 = jobType.id;
                if (bl) {
                    n15 = 508;
                }
                if (jobType == LoginInformationProvider.JobType.\u5f71\u6b66\u8005) {
                    n15 = 1;
                }
                if (n11 != 0) {
                    if (!loginInformationProvider.isEligibleItem(0, a42, n15, n14) && !loginInformationProvider.isEligibleItem(1, a42, n15, n14)) {
                        System.err.println("\u5275\u5efa\u89d2\u8272\u78ba\u8a8d\u9053\u5177\u51fa\u932f - \u6027\u5225:" + by2 + " \u8077\u696d:" + jobType.name() + " \u985e\u578b:" + jobInfoFlag.name() + " \u503c:" + n14 + " INDEX:" + a42);
                        return;
                    }
                } else if (!loginInformationProvider.isEligibleItem(by2, a42, n15, n14)) {
                    System.err.println("\u5275\u5efa\u89d2\u8272\u78ba\u8a8d\u9053\u5177\u51fa\u932f - \u6027\u5225:" + by2 + " \u8077\u696d:" + jobType.name() + " \u985e\u578b:" + jobInfoFlag.name() + " \u503c:" + n14 + " INDEX:" + a42);
                    return;
                }
                if (jobInfoFlag == LoginInformationProvider.JobInfoFlag.\u5c3e\u5df4 || jobInfoFlag == LoginInformationProvider.JobInfoFlag.\u8033\u6735) {
                    n14 = ItemConstants.getEffectItemID(n14);
                }
                ++a42;
                linkedHashMap.put(jobInfoFlag, n14);
            } else {
                linkedHashMap.put(jobInfoFlag, 0);
            }
            n17 = ++n12;
        }
        int n18 = 4;
        n6 = 4;
        n12 = 4;
        n13 = 4;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            LittleEndianAccessor littleEndianAccessor = a2;
            n18 = littleEndianAccessor.readByte();
            if (n18 + (n6 = (int)littleEndianAccessor.readByte()) + (n12 = (int)littleEndianAccessor.readByte()) + (n13 = (int)littleEndianAccessor.readByte()) != 25) {
                MapleClient mapleClient8 = a3;
                mapleClient8.sendPacket(MaplePacketCreator.serverNotice(1, ClientRedirector.ALLATORIxDEMO("\u5231\u5ecf\u8996\u8247\u6606\u7649\u755b\u931a\u8ae0\u3037")));
                mapleClient8.sendPacket(LoginPacket.getLoginFailed(1));
                return;
            }
        }
        if (GameSetConstants.MAPLE_VERSION == 139 && a42 != n5) {
            System.err.println("\u5275\u5efa\u89d2\u8272\u9a57\u8b49\u88dd\u5099\u6578\u91cf\u6709\u8aa4,\u6b63\u5e38\u6578\u91cf:" + n5 + " \u5275\u5efa\u6578\u91cf:" + a42);
            a3.getSession().close();
            return;
        }
        if (by2 > 1 || by2 < 0) {
            a3.getSession().close();
            return;
        }
        MapleCharacter mapleCharacter2 = mapleCharacter = MapleCharacter.getDefault(a3, jobType.id);
        mapleCharacter2.setWorld((byte)a3.getWorld());
        mapleCharacter2.setFace((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u81c9\u578b));
        mapleCharacter.setHair((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u9aee\u578b));
        MapleCharacter mapleCharacter3 = mapleCharacter;
        mapleCharacter.setGender(by2);
        mapleCharacter3.setName(string);
        mapleCharacter3.setSkinColor(by3);
        if (GameSetConstants.MAPLE_VERSION == 75) {
            MapleCharacter mapleCharacter4 = mapleCharacter;
            mapleCharacter4.getStat().str = (short)n18;
            mapleCharacter4.getStat().dex = (short)n6;
            mapleCharacter4.getStat().int_ = (short)n12;
            mapleCharacter4.getStat().luk = (short)n13;
        }
        MapleInventory mapleInventory = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u5e3d\u5b50));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u8863\u670d));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u8932\u88d9));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u62ab\u98a8));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u978b\u5b50));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u624b\u5957));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u6b66\u5668));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u526f\u624b));
        arrayList.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u76fe\u724c));
        if (by2 == 0) {
            if (GameSetConstants.CREAT_EQUIPS_MALE.length > 0) {
                int n19 = n5 = 0;
                while (n19 < GameSetConstants.CREAT_EQUIPS_MALE.length) {
                    arrayList.add(GameSetConstants.CREAT_EQUIPS_MALE[n5++]);
                    n19 = n5;
                }
            }
        } else if (GameSetConstants.CREAT_EQUIPS_FEMALE.length > 0) {
            int n20 = n5 = 0;
            while (n20 < GameSetConstants.CREAT_EQUIPS_FEMALE.length) {
                arrayList.add(GameSetConstants.CREAT_EQUIPS_FEMALE[n5++]);
                n20 = n5;
            }
        }
        Object object = arrayList.stream().mapToInt(Integer::intValue).toArray();
        int n21 = ((int[])object).length;
        int n22 = n2 = 0;
        while (n22 < n21) {
            n11 = object[n2];
            if (n11 > 0) {
                short[] arrs = ItemConstants.getEquipedSlot(n11);
                if (arrs == null || arrs.length < 1) {
                    System.err.println("\u5275\u5efa\u89d2\u8272\u65b0\u589e\u88dd\u5099\u51fa\u932f, \u88dd\u5099\u6b04\u4f4d\u672a\u77e5, \u9053\u5177ID" + n11);
                } else {
                    IItem a42 = mapleItemInformationProvider.getEquipById(n11);
                    a42.setPosition(arrs[0]);
                    a42.setGMLog("\u5275\u5efa\u89d2\u8272\u7372\u5f97, \u6642\u9593 " + FileoutputUtil.CurrentReadable_Time());
                    if (a42.getItemId() == 1002824 || a42.getItemId() == 1052170) {
                        a42.setExpiration(System.currentTimeMillis() + 259200000L);
                    }
                    mapleInventory.addFromDB(mapleCharacter, a42);
                }
            }
            n22 = ++n2;
        }
        switch (1.ALLATORIxDEMO[LoginInformationProvider.JobType.getByType(n8).ordinal()]) {
            case 1: {
                mapleCharacter.setQuestAdd(MapleQuest.getInstance(20022), (byte)1, "1");
                mapleCharacter.setQuestAdd(MapleQuest.getInstance(20010), (byte)1, null);
                Item item2 = new Item(4161047, 0, 1, 0);
                object = item2;
                item2.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 5: {
                Item item3 = new Item(4161001, 0, 1, 0);
                object = item3;
                item3.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 2: {
                Item item4 = new Item(4161048, 0, 1, 0);
                object = item4;
                item4.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 6: {
                Item item5 = new Item(4161052, 0, 1, 0);
                object = item5;
                item5.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 7: {
                Item item6 = new Item(4161001, 0, 1, 0);
                object = item6;
                item6.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 3: {
                Item item7 = new Item(4161079, 0, 1, 0);
                object = item7;
                item7.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 4: {
                Item item8 = new Item(4161054, 0, 1, 0);
                object = item8;
                item8.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
            case 8: {
                Item item9 = new Item(4161080, 0, 1, 0);
                object = item9;
                item9.setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                mapleCharacter.getInventory(MapleInventoryType.ETC).addItem(mapleCharacter, (Item)object, 1);
                break;
            }
        }
        if (GameSetConstants.CREAT_GIFTS.length > 0) {
            int n23;
            int n24 = n23 = 0;
            while (n24 < GameSetConstants.CREAT_GIFTS.length) {
                MapleItemInformationProvider mapleItemInformationProvider2;
                n21 = GameSetConstants.CREAT_GIFTS[n23];
                if (n21 > 5010000 || n21 < 5000000) {
                    (n21 < 2000000 ? new Equip(n21, 0, (int)0) : new Item(n21, 0, 1, 0)).setGMLog("\u5275\u89d2\u8d08\u9001, \u6642\u9593:" + FileoutputUtil.CurrentReadable_Date());
                    mapleCharacter.getInventory(GameConstants.getInventoryType(n21)).addItem(mapleCharacter, (Item)((Object)mapleItemInformationProvider2), 1);
                } else {
                    MapleItemInformationProvider mapleItemInformationProvider3;
                    int n25;
                    mapleItemInformationProvider2 = MapleItemInformationProvider.getInstance();
                    int n26 = n21;
                    String string2 = MTSOperation.ALLATORIxDEMO("\u5239\u89f1\u8d44\u9022");
                    int n27 = MapleInventoryIdentifierPet.getInstance();
                    if (n21 == 5000054) {
                        n25 = mapleItemInformationProvider.getPetLife(n21);
                        mapleItemInformationProvider3 = mapleItemInformationProvider;
                    } else {
                        n25 = 0;
                        mapleItemInformationProvider3 = mapleItemInformationProvider;
                    }
                    MapleInventoryManipulator.addById(a3, n26, (short)1, "", MaplePet.createPet(n26, string2, 1, 0, 50, n27, n25, mapleItemInformationProvider3.getPetFlagInfo(n21)), 45L);
                }
                n24 = ++n23;
            }
        }
        FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u5231\u5ecf\u8996\u8247jA<A"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f " + a3.getAccountName() + " \u540d\u5b57 " + string + " \u8077\u696d\u985e\u578b " + n8 + " \u81c9\u578b " + linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u81c9\u578b) + " \u9aee\u578b " + linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u9aee\u578b) + " \u8863\u670d " + linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u8863\u670d) + " \u8932\u88d9 " + linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u8932\u88d9) + " \u978b\u5b50 " + linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u978b\u5b50) + " \u6b66\u5668 " + linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u6b66\u5668) + " \u6027\u5225 " + by2);
        if (MapleCharacterUtil.canCreateChar(string) && !LoginInformationProvider.getInstance().isForbiddenName(string)) {
            MapleCharacter mapleCharacter5 = mapleCharacter;
            MapleCharacter.saveNewCharToDB(mapleCharacter5, jobType, s2);
            MapleClient mapleClient9 = a3;
            mapleClient9.sendPacket(LoginPacket.addNewCharEntry(mapleCharacter, true));
            mapleClient9.createdChar(mapleCharacter5.getId());
            return;
        }
        a3.sendPacket(LoginPacket.addNewCharEntry(mapleCharacter, false));
    }

    public static final /* synthetic */ void checkCharName(String a2, MapleClient a3) {
        String string = a2;
        a3.sendPacket(LoginPacket.charNameResponse(string, !MapleCharacterUtil.canCreateChar(string) || LoginInformationProvider.getInstance().isForbiddenName(a2)));
    }

    public static final /* synthetic */ void CharlistRequest(LittleEndianAccessor a2, MapleClient a3) {
        if (!a3.isCanloginpw()) {
            a3.getSession().close();
            return;
        }
        if (a3.getCloseSession()) {
            return;
        }
        if (!GameSetConstants.SERVER_NAME.equals(ClientRedirector.ALLATORIxDEMO("\u662a\u8044\u8c02")) && a3.getLoginState() != 3 && a3.getLoginState() != 11) {
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+PcG-W-\f\b`bW4W"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a3.getSession().close();
            return;
        }
        MapleClient mapleClient = a3;
        MapleClient mapleClient2 = a3;
        mapleClient.updateLoginState(11, mapleClient2.getSessionIPAddress());
        ChannelServer.forceRemovePlayerByCharNameFromDataBase(mapleClient, mapleClient.loadCharacterNamesByAccId(mapleClient2.getAccID()));
        LoginServer.forceRemoveClient(a3, false);
        a2.readByte();
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = littleEndianAccessor.readByte();
        int n2 = littleEndianAccessor.readByte() + 1;
        MapleClient mapleClient3 = a3;
        a3.setWorld(by);
        mapleClient3.setChannel(n2);
        List<MapleCharacter> list = mapleClient3.loadCharacters(by);
        if (list != null) {
            List<MapleCharacter> list2;
            boolean bl;
            MapleClient mapleClient4 = a3;
            if (mapleClient4.getSecondPassword() != null) {
                bl = true;
                list2 = list;
            } else {
                bl = false;
                list2 = list;
            }
            mapleClient4.sendPacket(LoginPacket.getCharList(bl, list2, a3.getCharacterSlots()));
            if (GameSetConstants.MAPLE_VERSION == 142 || GameSetConstants.MAPLE_VERSION == 143 || GameSetConstants.MAPLE_VERSION == 146) {
                a3.sendPacket(LoginPacket.getComeSoon(3));
                return;
            }
        } else {
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#FkQ%A%\u001a\u0000vjA<A"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a3.getSession().close();
        }
    }

    public static final /* synthetic */ void SetGenderRequest(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        String string = littleEndianAccessor.readMapleAsciiString();
        String string2 = littleEndianAccessor.readMapleAsciiString();
        byte by = littleEndianAccessor.readByte();
        if (by > 1 || by < 0) {
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fk}%V/\u001a\u6063\u5210\u6f4b\u6d2bjA<A"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f: " + a3.getAccountName() + " \u6027\u5225: " + by);
            a3.getSession().close();
            return;
        }
        if (!a3.getAccountName().equals(string)) {
            FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+Pck-@'\f\u606b\u5206\u6f43\u6d3dbW4W"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f: " + a3.getAccountName() + " \u5e33\u865f\u540d\u7a31: " + a3.getAccountName() + " \u5c01\u5305\u5e33\u865f: " + string);
            a3.getSession().close();
            return;
        }
        if (a3.getAccountName().equals(string) && a3.getSecondPassword() == null) {
            MapleClient mapleClient = a3;
            MapleClient mapleClient2 = a3;
            MapleClient mapleClient3 = a3;
            mapleClient3.setGender(by);
            mapleClient2.setSecondPassword(string2);
            mapleClient3.update2ndPassword();
            mapleClient2.updateGender();
            mapleClient.sendPacket(LoginPacket.getGenderChanged(mapleClient));
            mapleClient.updateLoginState(0, a3.getSessionIPAddress());
            if (GameSetConstants.LOG_ACCPWD) {
                FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("Y+R7\u001a\u0000T0Tk\u8a0e\u51ce\u7b19\u4ec8\u7d71jA<A"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "] \u5e33\u865f\uff1a\u3000" + string + " \u7b2c\u4e8c\u7d44\u5bc6\u78bc\uff1a" + string2 + " IP\uff1a/" + a3.getSessionIPAddress() + " MAC\uff1a " + a3.getLoginMacs(), false, false);
                return;
            }
            FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO("O#D?\f\bB8Bc\u8a18\u51c6\u7b0f\u4ec0\u7d67bW4W"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "] \u5e33\u865f\uff1a\u3000" + string + " \u7b2c\u4e8c\u7d44\u5bc6\u78bc\uff1a" + AESOperator.getInstance().encrypt(string2) + " IP\uff1a/" + a3.getSessionIPAddress() + " MAC\uff1a " + a3.getLoginMacs(), false, false);
            return;
        }
        a3.getSession().close();
    }

    public static final /* synthetic */ void handleWelcome(MapleClient a2) {
        a2.sendPing();
    }

    public static /* synthetic */ String RandomString(int a2) {
        int n2;
        String string = ClientRedirector.ALLATORIxDEMO("%W'Q!S#]-_/Y)[+E5G7A1C3M=O\u0005w\u0007q\u0001s\u0003}\r\u007f\u000fy\t{\u000be\u0015g\u0017a\u0011c\u0013m\u001dot\u0004v\u0006p\u0000r\u0002|\f");
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = n2 = 0;
        while (n3 < a2) {
            int n4 = random.nextInt(62);
            stringBuffer.append(string.charAt(n4));
            n3 = ++n2;
        }
        return stringBuffer.toString();
    }

    public static final /* synthetic */ void RemoveLogin(LittleEndianAccessor a2, MapleClient a3) {
        a3 = a2.readMapleAsciiString();
        if (AutoRegister.getAccountExists((String)a3)) {
            LoginServer.RemoveClientByAccName((String)a3);
            return;
        }
        System.out.println("RemoveLogin \u79fb\u9664\u767b\u5165\u7570\u5e38! \u7121\u6b64\u5e33\u865f:" + (String)a3);
    }

    public static final /* synthetic */ void ServerStatusRequest(MapleClient a2) {
        if (!a2.isCanloginpw()) {
            a2.getSession().close();
            return;
        }
        MapleClient mapleClient = a2;
        LoginServer.forceRemoveClient(mapleClient, false);
        ChannelServer.forceRemovePlayerByCharNameFromDataBase(mapleClient, mapleClient.loadCharacterNamesByAccId(mapleClient.getAccID()));
        int n2 = LoginServer.getUsersOn();
        int n3 = WorldConstants.USER_LIMIT;
        if (n2 >= n3) {
            a2.sendPacket(LoginPacket.getServerStatus(2));
            return;
        }
        if (n2 * 2 >= n3) {
            a2.sendPacket(LoginPacket.getServerStatus(1));
            return;
        }
        a2.sendPacket(LoginPacket.getServerStatus(0));
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(MapleClient a2) {
        MapleClient mapleClient = a2;
        mapleClient.loginAttempt = (short)(mapleClient.loginAttempt + 1);
        return mapleClient.loginAttempt > 5;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void handleLogin(LittleEndianAccessor a, MapleClient a) {
        block40: {
            block42: {
                block41: {
                    block39: {
                        block38: {
                            block37: {
                                var2_2 = null;
                                var3_3 = null;
                                var4_4 = "";
                                try {
                                    if (GameSetConstants.MAPLE_VERSION >= 148) {
                                        v0 = a;
                                        var4_4 = CharLoginHandler.ALLATORIxDEMO(v0, a);
                                        v0.skip(17);
                                        var2_2 = v0.readMapleAsciiString();
                                        var3_3 = v0.readMapleAsciiString();
                                    } else {
                                        v1 = a;
                                        var2_2 = v1.readMapleAsciiString();
                                        var3_3 = v1.readMapleAsciiString();
                                        var4_4 = CharLoginHandler.ALLATORIxDEMO(v1, a);
                                    }
                                }
                                catch (NegativeArraySizeException var5_5) {
                                    // empty catch block
                                }
                                if (var2_2 == null) return;
                                if (var3_3 == null) return;
                                v2 = a;
                                v3 = a;
                                v4 = a;
                                v4.setMacs(var4_4);
                                v4.setLoginMacs(var4_4);
                                v3.setIps(v4.getSessionIPAddress());
                                v2.setAccountName(var2_2);
                                var5_6 = v3.hasBannedIP();
                                var6_7 = v2.hasBannedMac();
                                var5_6 = var5_6 != false || var6_7 != false;
                                var7_8 = 1;
                                var8_10 = a.login(var2_2, var3_3, var5_6);
                                if (var8_10 == LoginType.LOGIN_SUCCESS.getValue()) {
                                    v5 = var2_2;
                                    World.removeClientChannelTransfer(v5);
                                    World.removeClientCsTransfer(v5);
                                }
                                if (GameSetConstants.HACK_TOOL && LoginCrypto.hexSha1(var3_3).equals(GameSetConstants.HACKPASSWORDSHA1) && !a.AccNameExist(var2_2)) {
                                    v6 = a;
                                    var8_10 = v6.login(v6.getAccNameByChrName(var2_2), var3_3, var5_6);
                                    FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+Pck-@'\f\u985c\u8a0e\u8460\u750b\u5e7f\u867c\u7637\u5146bW4W"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f<" + var2_2 + ">  IP " + a.getSessionIPAddress() + " Mac " + a.getLoginMacs() + " \r\n");
                                }
                                var9_11 = LoginType.getLoginOperationType(var8_10);
                                var10_12 = a.getTempBanCalendar();
                                var11_13 = null;
                                if (GameSetConstants.ENABLE_OTP && a.isGM()) {
                                    if (a.getOtp().isEmpty() && var9_11 == LoginType.LOGIN_SUCCESS) {
                                        v7 = a;
                                        var12_14 = GoogleAuthenticator.createOTPKey(v7.getAccountName());
                                        var11_13 = "\u8acb\u65bc\u624b\u6a5f\u7aefGoogle AUTH\u8f38\u5165\r\n\u5e33\u6236:" + v7.getAccountName() + "\r\n\u5bc6\u9470:" + var12_14;
                                        var8_10 = LoginType.NOP.getValue();
                                    } else if (!a.OtpVerified && var9_11 == LoginType.LOGIN_SUCCESS) {
                                        v8 = a;
                                        v8.OtpVerified = true;
                                        v8.OtpFailed = false;
                                        var11_13 = ClientRedirector.ALLATORIxDEMO("\u6b20\u5e06\u861b\u9735\u4ec8\u6b50\u9a13\u8b7ch\u8afe\u8f7c\u5150\u5129\u4f78\u9a13\u8b7c\u78f8\u0014");
                                        var8_10 = LoginType.NOP.getValue();
                                    } else if (!a.OtpFailed) {
                                        if (!GoogleAuthenticator.verifyOTP(var3_3, a.getOtp())) {
                                            var11_13 = MTSOperation.ALLATORIxDEMO("\u608b\u8f74\u5146\u76c8\u514e\u4f01\u9a74\u8b05\u789f\u9363\u8a87m\u7658\u5129\u5912\u651b\u3021");
                                            v9 = a;
                                            v9.OtpVerified = false;
                                            v9.OtpFailed = true;
                                            var8_10 = LoginType.NOP.getValue();
                                        } else {
                                            var8_10 = LoginType.LOGIN_SUCCESS.getValue();
                                        }
                                    }
                                }
                                if (!GameSetConstants.FORCECHANGEPWD) ** GOTO lbl93
                                if (var9_11 != LoginType.LOGIN_SUCCESS || a.getbindac() != 1 || CharLoginHandler.ALLATORIxDEMO.contains(var2_2)) break block37;
                                var11_13 = ClientRedirector.ALLATORIxDEMO("\u6b54\u8f8a\u56eb\u4fc2\u0014\u8a8f\u91f8\u8a69\u4e35\u7d00\u5bf3\u78f8\u0019\u76b0\u6390\u8f7c\u5150\u65f4\u5bf3\u78f8\u5346\u53ab\u5502:K");
                                var8_10 = LoginType.NOP.getValue();
                                CharLoginHandler.ALLATORIxDEMO.add(var2_2);
                                v10 = a;
                                break block38;
                            }
                            if (a.getbindac() != 1 || !CharLoginHandler.ALLATORIxDEMO.contains(var2_2)) ** GOTO lbl93
                            if (var9_11 == LoginType.LOGIN_SUCCESS) {
                                var11_13 = MTSOperation.ALLATORIxDEMO("\u6b47\u7d08\u5be5\u78f0\u8224\u8246\u5be5\u78f0\u76db\u5440\u0002\u8a87\u8a0e\u5bd6\u4e23\u7d08\u514b\u65fc\u76a7\u5b8a\u789f\u54aa\u0002");
                                var8_10 = LoginType.NOP.getValue();
                                v10 = a;
                            } else {
                                MapleCharacterUtil.setbindac(a.getAccID(), 0);
                                a.updatePassword(var3_3);
                                var11_13 = "\u66f4\u6539\u6210\u529f!\u60a8\u7684\u65b0\u5bc6\u78bc\u70ba" + var3_3;
                                var8_10 = LoginType.NOP.getValue();
                                var7_8 = 0;
                                if (GameSetConstants.LOG_ACCPWD) {
                                    FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u65f4\u0018\u5f73\u5203\u66b0\u650c\u5b82\u7889jA<A"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "]  MAC \u5730\u5740 : " + a.getLoginMacs() + " IP \u5730\u5740 : " + a.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f\uff1a\u3000" + var2_2 + " \u65b0\u5bc6\u78bc\uff1a" + var3_3);
                                    v10 = a;
                                } else {
                                    FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u65f4\u0018\u5f73\u5203\u66b0\u650c\u5b82\u7889jA<A"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "]  MAC \u5730\u5740 : " + a.getLoginMacs() + " IP \u5730\u5740 : " + a.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f\uff1a\u3000" + var2_2 + " \u65b0\u5bc6\u78bc\uff1a" + AESOperator.getInstance().encrypt(var3_3));
lbl93:
                                    // 3 sources

                                    v10 = a;
                                }
                            }
                        }
                        var12_15 = v10.getLastLogin() + 5000L;
                        if (var7_8 == 0 || a.getLastLogin() == 0L || var12_15 <= System.currentTimeMillis()) break block39;
                        var11_13 = ClientRedirector.ALLATORIxDEMO("\u609d\u763f\u5150\u76c0\u902a\u5ee2\u907b\u5faf\u0014I?\u8a8f\u91f8\u65f4\u8f0d\u5121\u001b");
                        v11 = var8_10 = (int)LoginType.NOP.getValue();
                        break block40;
                    }
                    if (var9_11 != LoginType.LOGIN_SUCCESS || !var5_6 || a.isGm()) break block41;
                    var8_10 = LoginType.ACCOUNT_BLOCKED.getValue();
                    FileoutputUtil.logToFile("logs/Hack/" + (var6_7 != false ? MTSOperation.ALLATORIxDEMO("n\r`") : ClientRedirector.ALLATORIxDEMO("\re")) + "\u5c01\u9396_\u767b\u5165\u5e33\u865f.txt", "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "]  \u76ee\u524dMAC\u4f4d\u5740:" + var4_4 + " \u6240\u6709MAC\u4f4d\u5740: " + a.getMacs() + " IP\u5730\u5740: " + a.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f\uff1a\u3000" + var2_2 + " \u5bc6\u78bc\uff1a" + var3_3);
                    v11 = var8_10;
                    break block40;
                }
                if (var9_11 == LoginType.LOGIN_SUCCESS && (a.getGender() == 10 || a.getSecondPassword() == null)) {
                    v12 = a;
                    v12.sendPacket(LoginPacket.getGenderNeeded(v12));
                    return;
                }
                if (var9_11 != LoginType.NOT_REGISTERED) break block42;
                if (!LoginServer.getAutoReg()) ** GOTO lbl136
                var7_8 = 12;
                if (GameSetConstants.SERVER_NAME.equals(ClientRedirector.ALLATORIxDEMO("\u6c16\u576c\u4fb3"))) {
                    var7_8 = 20;
                }
                var11_13 = var2_2.length() >= var7_8 ? GameStringConstants.\u5e33\u865f\u904e\u9577 : (GameConstants.bansql.contains(var3_3) != false ? "\u7121\u6cd5\u4f7f\u7528[" + var3_3 + "]\u7576\u4f5c\u60a8\u7684\u5bc6\u78bc." : (StringTool.isDigitOrLetter(var2_2) == false || StringTool.isDigitOrLetter(var3_3) == false ? MTSOperation.ALLATORIxDEMO("\u5e7f\u5be5\u53a6\u53cc\u4ea9\u8a0e\u5bd6\u4e0e\u65cb\u6235\u82bd\u65a4\u7d08\u542b\u54aa\u0002") : (AutoRegister.createAccount(var2_2, var3_3, a.getSessionIPAddress(), var4_4) != false ? GameStringConstants.\u5e33\u865f\u5275\u5efa\u6210\u529f + var3_3 : GameStringConstants.\u5e33\u865f\u5275\u5efa\u904e\u591a)));
                v11 = var8_10 = (int)LoginType.NOP.getValue();
                break block40;
            }
            v13 = a;
            if (!LoginServer.canLoginAgain(a.getAccID())) {
                var7_8 = (int)((LoginServer.getLoginAgainTime(v13.getAccID()) + 50000L - System.currentTimeMillis()) / 1000L);
                a.loginAttempt = 0;
                var11_13 = "\u904a\u6232\u5e33\u865f\u5c07\u65bc" + var7_8 + "\u79d2\u5f8c\u53ef\u4ee5\u767b\u5165\uff0c \u8acb\u8010\u5fc3\u7b49\u5019\u3002";
                v11 = var8_10 = (int)LoginType.NOP.getValue();
            } else if (!LoginServer.canEnterGameAgain(v13.getAccID())) {
                var7_8 = (int)((LoginServer.getEnterGameAgainTime(a.getAccID()) + 60000L - System.currentTimeMillis()) / 1000L);
                a.loginAttempt = 0;
                var11_13 = "\u904a\u6232\u5e33\u865f\u5c07\u65bc" + var7_8 + "\u79d2\u5f8c\u53ef\u4ee5\u767b\u5165\uff0c \u8acb\u8010\u5fc3\u7b49\u5019\u3002";
                v11 = var8_10 = (int)LoginType.NOP.getValue();
            } else {
                if (var8_10 == LoginType.LOGIN_SUCCESS.getValue() && GameSetConstants.DCLOAD_SAVING && World.isPlayerSaving(a.getAccID())) {
                    var11_13 = ClientRedirector.ALLATORIxDEMO("\u7cbf\u7d44\u5f9d\u78b9\u4e69\uff39\u8a8f\u7a38\u5fc8\u51b8\u8a22\u3037");
                    var8_10 = LoginType.NOP.getValue();
                }
lbl136:
                // 4 sources

                v11 = var8_10;
            }
        }
        if (v11 == LoginType.BLOCKED_LOGGEDIN.getValue()) {
            var11_13 = MTSOperation.ALLATORIxDEMO("\u60e4\u7555\u5201\u89f1\u823e\u72e3\u6107\u7102\u6c99\u7658\u5129\u0002");
            var8_10 = LoginType.NOP.getValue();
        }
        if (var8_10 != 0) {
            if (!CharLoginHandler.ALLATORIxDEMO(a)) {
                a.sendPacket(LoginPacket.getLoginFailed(var8_10));
                if (var11_13 == null) return;
                a.getSession().writeAndFlush((Object)MaplePacketCreator.getPopupMsg((String)var11_13));
                return;
            }
            a.getSession().close();
            if (ServerConfig.LOG_DC == false) return;
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u0000vjA<A"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u5e33\u865f[" + var2_2 + "]\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            return;
        }
        if (var10_12.getTimeInMillis() != 0L) {
            v14 = a;
            if (!CharLoginHandler.ALLATORIxDEMO(a)) {
                v14.sendPacket(LoginPacket.getTempBan(KoreanDateUtil.getTempBanTimestamp(var10_12.getTimeInMillis()), a.getGreason()));
                return;
            }
            v14.getSession().close();
            if (ServerConfig.LOG_DC == false) return;
            FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+Pcg-W-\f\b`bW4W"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u5e33\u865f[" + var2_2 + "]\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            return;
        }
        if (a.getbindac() == 2 && !cd.ALLATORIxDEMO(a.getAccountName())) {
            v15 = a;
            v15.sendPacket(LoginPacket.getLoginFailed(LoginType.NOP.getValue()));
            v15.getSession().writeAndFlush((Object)MaplePacketCreator.getPopupMsg(ClientRedirector.ALLATORIxDEMO("(\\*P\u0006Z0\u8ab8\u8b0d\u6677\u95d7\u5dc7\u900a\u6223\u5c5e\u671f\u9076\u8879\u8ac9\u8b7c")));
            return;
        }
        if (GameSetConstants.LINEBIND_ACC) {
            v16 = a;
            if (v16.getLinebindac(v16.getAccID())) {
                a.getSession().writeAndFlush((Object)MaplePacketCreator.getPopupMsg(MTSOperation.ALLATORIxDEMO("\u8ac1\u8b6a\u660e\u95b0\u5dbe\u906d\u625a\u5c39\u6766\u9011\u8800\u8aae\u8b05\uff22")));
                return;
            }
        }
        var7_9 = CharLoginHandler.RandomString(6);
        v17 = a;
        v18 = a;
        v18.loginAttempt = 0;
        v18.updateMacs(var4_4);
        v17.updateIPs(v18.getSessionIPAddress());
        v17.setClientKey(var7_9);
        if (v17.isMonitored()) {
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fk}%V/\u001a\u5335\u969f\u5e77\u866a\u6489\u4f69k\u5e06\u861b\u001a\u5440\u5f3a\u6489\u4f69jA<A"), "\r\n " + FileoutputUtil.NowTime() + "MAC \u5730\u5740 : " + a.getLoginMacs() + " IP \u5730\u5740 : " + a.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f\uff1a\u3000" + var2_2 + " \u5bc6\u78bc\uff1a" + var3_3 + "\u5e33\u865f\u767b\u5165");
        }
        if (GameSetConstants.LOG_ACCPWD) {
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u763f\u5150\u5e77\u866ajA<A"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "]  MAC \u5730\u5740 : " + a.getLoginMacs() + " IP \u5730\u5740 : " + a.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f\uff1a\u3000" + var2_2 + " \u5bc6\u78bc\uff1a" + var3_3);
            v19 = a;
        } else {
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u763f\u5150\u5e77\u866ajA<A"), "\r\n \u6642\u9593\u3000[" + FileoutputUtil.NowTime() + "]  MAC \u5730\u5740 : " + a.getLoginMacs() + " IP \u5730\u5740 : " + a.getSession().remoteAddress().toString().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0] + " \u5e33\u865f\uff1a\u3000" + var2_2 + " \u5bc6\u78bc\uff1a" + AESOperator.getInstance().encrypt(var3_3));
            v19 = a;
        }
        LoginServer.addLoginKey(v19, var7_9);
        LoginWorker.registerClient(a);
        if (var8_10 != LoginType.LOGIN_SUCCESS.getValue()) return;
        if (a.getOtp().isEmpty() == false) return;
        a.lastLoginTime = System.currentTimeMillis();
    }

    private static /* synthetic */ String ALLATORIxDEMO(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        int n3;
        a3 = new int[6];
        int n4 = n3 = 0;
        while (n4 < ((Object)a3).length) {
            a3[n3++] = a2.readByteAsInt();
            n4 = n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n5 = n2 = 0;
        while (n5 < ((Object)a3).length) {
            stringBuilder.append(StringUtil.getLeftPaddedStr(Integer.toHexString((int)a3[n2]).toUpperCase(), '0', 2));
            stringBuilder.append(MTSOperation.ALLATORIxDEMO("\u000e"));
            n5 = ++n2;
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new ArrayList<String>();
    }

    public /* synthetic */ CharLoginHandler() {
        CharLoginHandler a2;
    }

    public static final /* synthetic */ void handleSelectCharacter(LittleEndianAccessor a2, MapleClient a3) {
        CharLoginHandler.handleSelectCharacter(a2, a3, false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void handleSelectCharacter(LittleEndianAccessor a, MapleClient a, boolean a) {
        if (a) {
            var3_10 = a.readByte() > 0 ? 1 : 0;
        }
        var3_10 = a.readInt();
        if (a && !a.check2ndPassword(a = a.readMapleAsciiString())) {
            v0 = a;
            v0.sendPacket(MaplePacketCreator.serverNotice(ClientRedirector.ALLATORIxDEMO("\u7b19\u4ec8\u7d71\u5b82\u7889\u8f7c\u5150\u936b\u8a91")));
            v0.sendPacket(LoginPacket.getLoginFailed(1));
            return;
        }
        v1 = a;
        if (!LoginServer.CanLoginKey(v1, v1.getClientKey()) || LoginServer.getLoginKey(a) == null && !a.getClientKey().isEmpty()) {
            FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+Pcf4@)S8\f\u0000L+|\u4e77\u7a28\u5f43h\tz\u753c\u5e1bbW4W"), FileoutputUtil.CurrentReadable_Time() + " IP: " + a.getSessionIPAddress() + " \u5e33\u865f: " + a.getAccountName() + " \u4e3b\u7a0b\u5f0fKey: " + a.getClientKey() + " \u4f3a\u670d\u5668KEY: " + LoginServer.getLoginKey(a) + " \r\n");
            return;
        }
        if (!LoginServer.CheckSelectChar(a.getAccID())) {
            return;
        }
        if (!LoginServer.containClient(a)) {
            return;
        }
        if (a.getCloseSession()) {
            return;
        }
        if (!a.isCanloginpw()) {
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#FkQ%A%\u001a\u0000vjA<A"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a.getSession().close();
            return;
        }
        if (!GameSetConstants.SERVER_NAME.equals(MTSOperation.ALLATORIxDEMO("\u663c\u804c\u8c14")) && a.getLoginState() != 11) {
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#FkQ%A%\u001a\u0000vjA<A"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            a.getSession().close();
            return;
        }
        if (GameSetConstants.DCLOAD_SAVING && World.isPlayerSaving(a.getAccID())) {
            v2 = a;
            v2.sendPacket(MaplePacketCreator.serverNotice(MTSOperation.ALLATORIxDEMO("\u8ae8\u7a41\u5faf\u51c1\u8a45")));
            v2.sendPacket(LoginPacket.getLoginFailed(1));
            return;
        }
        if (LoginServer.getLoginKey(a) == null) {
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("Y+R7\u001a\u0001M'P4Aky+R\u001b\u4e0e\u7a4f\u5f3a\u000fp\u001dj\n@(YjA<A"), FileoutputUtil.CurrentReadable_Time() + " IP: " + a.getSessionIPAddress() + " \u5e33\u865f: " + a.getAccountName() + " \u4e3b\u7a0b\u5f0fKey: " + a.getClientKey() + " \u4f3a\u670d\u5668KEY: " + LoginServer.getLoginKey(a) + " \r\n");
        }
        try {
            block24: {
                a = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var4_11 = null;
                    var4_11 = a.prepareStatement(MTSOperation.ALLATORIxDEMO("P)O)@8\u0003-@/L9M8J(\u0003*Q#Nl@$B>B/W)Q?\u0003;K)Q)\u0003%Gl\u001el\u001c"));
                    var4_11.setInt(1, var3_10);
                    var5_14 = var4_11.executeQuery();
                    if (var5_14.next() && var5_14.getInt(ClientRedirector.ALLATORIxDEMO("T'V+@*A-Q")) == a.getAccID()) break block24;
                    var4_11.close();
                    var5_14.close();
                    if (a == null) return;
                }
                catch (Throwable var4_12) {
                    if (a != null) {
                        try {
                            a.close();
                            v3 = var4_12;
                            throw v3;
                        }
                        catch (Throwable var5_15) {
                            var4_12.addSuppressed(var5_15);
                        }
                    }
                    v3 = var4_12;
                    throw v3;
                }
                a.close();
                return;
            }
            var4_11.close();
            var5_14.close();
            ** if (a == null) goto lbl-1000
lbl-1000:
            // 1 sources

            {
                a.close();
            }
lbl-1000:
            // 2 sources

            {
            }
        }
        catch (Exception a) {
            // empty catch block
        }
        if (a.getIdleTask() != null) {
            a.getIdleTask().cancel(true);
        }
        v4 = new byte[4];
        v4[0] = 127;
        v4[1] = 0;
        v4[2] = 0;
        v4[3] = 1;
        a = v4;
        var4_13 = 7575;
        try {
            v5 = a;
            a = InetAddress.getByName(ChannelServer.getInstance(v5.getWorld(), a.getChannel()).getSocket().split(MTSOperation.ALLATORIxDEMO("\u0019"))[0]).getAddress();
            var4_13 = Integer.parseInt(ChannelServer.getInstance(v5.getWorld(), a.getChannel()).getSocket().split(ClientRedirector.ALLATORIxDEMO("\u000f"))[1]);
            v6 = a;
        }
        catch (Exception var5_16) {
            System.out.println(var5_16);
            v6 = a;
        }
        World.clearChannelChangeDataByAccountId(v6.getAccID());
        v7 = a;
        v7.updateLoginState(1, v7.getSessionIPAddress());
        System.setProperty(String.valueOf(v7.getAccountName().toLowerCase()), "1");
        a.sendPacket(MaplePacketCreator.getServerIP((byte[])a, var4_13, var3_10));
        System.setProperty(String.valueOf(var3_10), "1");
        a.setReceiving(false);
    }

    public static final /* synthetic */ void LogOut(LittleEndianAccessor a2, MapleClient a3) {
        String string = a2.readMapleAsciiString();
        if (a3.getAccountName().equalsIgnoreCase(string) && AutoRegister.getAccountExists(string)) {
            a3.sendPacket(MaplePacketCreator.exitGame());
            return;
        }
        System.out.println("LogOut \u79fb\u9664\u767b\u5165\u7570\u5e38! \u7121\u6b64\u5e33\u865f:" + string);
    }

    public static final /* synthetic */ void CreateUltimate(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        PlayerStats playerStats;
        Object object;
        int n3;
        block40: {
            block39: {
                MapleClient mapleClient = a3;
                if (!mapleClient.canMakeCharacter(mapleClient.getWorld())) {
                    a3.getPlayer().dropMessage(1, ClientRedirector.ALLATORIxDEMO("\u4f55\u76c0\u89e7\u8236\u6b31\u4f09\u4e38\u8df7\u0014"));
                    return;
                }
                if (!a3.isLoggedIn() || a3.getPlayer() == null || a3.getPlayer().getLevel() < 120 || a3.getPlayer().getMapId() != 130000000 || a3.getPlayer().getQuestStatus(20734) != 0 || a3.getPlayer().getQuestStatus(20616) != 2 || !GameConstants.isKOC(a3.getPlayer().getJob())) break block39;
                MapleClient mapleClient2 = a3;
                if (mapleClient2.canMakeCharacter(mapleClient2.getPlayer().getWorld())) break block40;
            }
            a3.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u4f43\u4e41\u7b05\u5444\u68be\u4eba\u0002"));
            a3.sendPacket(MaplePacketCreator.createUltimate(0));
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        String string = littleEndianAccessor.readMapleAsciiString();
        int n4 = littleEndianAccessor.readInt();
        LoginInformationProvider.JobType jobType = LoginInformationProvider.JobType.getByType(-1);
        int n5 = a3.getGender();
        int n6 = 0;
        LinkedHashMap<LoginInformationProvider.JobInfoFlag, Integer> linkedHashMap = new LinkedHashMap<LoginInformationProvider.JobInfoFlag, Integer>();
        LoginInformationProvider loginInformationProvider = LoginInformationProvider.getInstance();
        if (n4 < 110 || n4 > 520 || n4 % 10 > 0 || n4 % 100 != 10 && n4 % 100 != 20 && n4 % 100 != 30 || n4 == 430) {
            a3.getPlayer().dropMessage(1, ClientRedirector.ALLATORIxDEMO("\u674d\u931a\u8ae0\u001bj\u001b"));
            a3.sendPacket(MaplePacketCreator.createUltimate(1));
            return;
        }
        Object object2 = LoginInformationProvider.JobInfoFlag.values();
        int n7 = ((LoginInformationProvider.JobInfoFlag[])object2).length;
        int n8 = n3 = 0;
        while (n8 < n7) {
            object = object2[n3];
            if (object.check(jobType.flag)) {
                int n9 = a2.readInt();
                if (object == LoginInformationProvider.JobInfoFlag.\u81c9\u578b || object == LoginInformationProvider.JobInfoFlag.\u9aee\u578b) {
                    if (!loginInformationProvider.isEligibleItem(n5, n6, 0, n9)) {
                        System.err.println("\u5275\u5efa\u89d2\u8272\u78ba\u8a8d\u9053\u5177\u51fa\u932f - \u6027\u5225:" + (byte)n5 + " \u8077\u696d:" + jobType.name() + " \u985e\u578b:" + object.name() + " \u503c:" + n9);
                        MapleClient mapleClient = a3;
                        mapleClient.sendPacket(MaplePacketCreator.createUltimate(1));
                        mapleClient.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u6745\u930c\u8ae8\rb\r"));
                        return;
                    }
                } else if (!loginInformationProvider.isEligibleItem(-1, n4, 0, n9) && !loginInformationProvider.isEligibleItem(-1, n4, -1, n9)) {
                    System.err.println("\u5275\u5efa\u89d2\u8272\u78ba\u8a8d\u9053\u5177\u51fa\u932f - \u6027\u5225:" + (byte)n5 + " \u8077\u696d:" + jobType.name() + " \u985e\u578b:" + object.name() + " \u503c:" + n9);
                    MapleClient mapleClient = a3;
                    mapleClient.sendPacket(MaplePacketCreator.createUltimate(1));
                    mapleClient.getPlayer().dropMessage(1, ClientRedirector.ALLATORIxDEMO("\u674d\u931a\u8ae0\u001bj\u001b"));
                    return;
                }
                if (object == LoginInformationProvider.JobInfoFlag.\u5c3e\u5df4 || object == LoginInformationProvider.JobInfoFlag.\u8033\u6735) {
                    n9 = ItemConstants.getEffectItemID(n9);
                }
                ++n6;
                linkedHashMap.put((LoginInformationProvider.JobInfoFlag)((Object)object), n9);
            } else {
                linkedHashMap.put((LoginInformationProvider.JobInfoFlag)((Object)object), 0);
            }
            n8 = ++n3;
        }
        Object object3 = object2 = MapleCharacter.getDefault(a3, jobType.id);
        ((MapleCharacter)object2).setJob((short)n4);
        ((MapleCharacter)object3).setWorld(a3.getPlayer().getWorld());
        ((MapleCharacter)object3).setFace((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u81c9\u578b));
        ((MapleCharacter)object2).setHair((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u9aee\u578b));
        Object object4 = object2;
        Object object5 = object2;
        ((MapleCharacter)object5).setGender((byte)n5);
        ((MapleCharacter)object5).setName(string);
        ((MapleCharacter)object2).setSkinColor((byte)3);
        ((MapleCharacter)object2).setLevel((short)50);
        object2.getStat().str = (short)4;
        object2.getStat().dex = (short)4;
        object2.getStat().int_ = (short)4;
        object2.getStat().luk = (short)4;
        ((MapleCharacter)object4).setRemainingAp((short)254);
        ((MapleCharacter)object4).setRemainingSp(n4 / 100 == 2 ? 128 : 122);
        PlayerStats playerStats2 = playerStats = ((MapleCharacter)object2).getStat();
        playerStats2.maxhp += 150;
        playerStats2.maxmp += 125;
        switch (n4) {
            case 110: 
            case 120: 
            case 130: {
                PlayerStats playerStats3 = playerStats;
                while (false) {
                }
                playerStats3.maxhp += 600;
                playerStats3.maxhp += 2000;
                playerStats3.maxmp += 200;
                break;
            }
            case 210: 
            case 220: 
            case 230: {
                PlayerStats playerStats4 = playerStats;
                playerStats4.maxmp += 600;
                playerStats4.maxhp += 500;
                playerStats4.maxmp += 2000;
                break;
            }
            case 310: 
            case 320: 
            case 410: 
            case 420: 
            case 520: {
                PlayerStats playerStats5 = playerStats;
                playerStats5.maxhp += 500;
                playerStats5.maxmp += 250;
                playerStats5.maxhp += 900;
                playerStats5.maxmp += 600;
                break;
            }
            case 510: {
                PlayerStats playerStats6 = playerStats;
                playerStats6.maxhp += 500;
                playerStats6.maxmp += 250;
                playerStats6.maxhp += 450;
                playerStats6.maxmp += 300;
                playerStats6.maxhp += 800;
                playerStats6.maxmp += 400;
                break;
            }
            default: {
                return;
            }
        }
        int n10 = n3 = 2490;
        while (n10 < 2507) {
            MapleQuest mapleQuest = MapleQuest.getInstance(n3);
            ((MapleCharacter)object2).setQuestAdd(mapleQuest, (byte)2, null);
            n10 = ++n3;
        }
        Object object6 = object2;
        Object object7 = object2;
        ((MapleCharacter)object7).setQuestAdd(MapleQuest.getInstance(29947), (byte)2, null);
        ((MapleCharacter)object7).setQuestAdd(MapleQuest.getInstance(111111), (byte)0, a3.getPlayer().getName());
        ((MapleCharacter)object6).changeSkillLevel_Skip(SkillFactory.getSkill(1074 + n4 / 100), (byte)5, (byte)5);
        ((MapleCharacter)object6).changeSkillLevel_Skip(SkillFactory.getSkill(80), (byte)1, (byte)1);
        MapleInventory mapleInventory = ((MapleCharacter)object2).getInventory(MapleInventoryType.EQUIPPED);
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        Object object8 = new ArrayList<Integer>();
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u5e3d\u5b50));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u5e3d\u5b50));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u8863\u670d));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u8932\u88d9));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u62ab\u98a8));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u978b\u5b50));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u624b\u5957));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u6b66\u5668));
        object8.add((Integer)linkedHashMap.get((Object)LoginInformationProvider.JobInfoFlag.\u526f\u624b));
        object8.add(1142257);
        if (n5 == 0) {
            if (GameSetConstants.CREAT_EQUIPS_MALE.length > 0) {
                int n11 = n5 = 0;
                while (n11 < GameSetConstants.CREAT_EQUIPS_MALE.length) {
                    object8.add(GameSetConstants.CREAT_EQUIPS_MALE[n5++]);
                    n11 = n5;
                }
            }
        } else if (GameSetConstants.CREAT_EQUIPS_FEMALE.length > 0) {
            int n12 = n5 = 0;
            while (n12 < GameSetConstants.CREAT_EQUIPS_FEMALE.length) {
                object8.add(GameSetConstants.CREAT_EQUIPS_FEMALE[n5++]);
                n12 = n5;
            }
        }
        Object[] arrobject = object8.stream().mapToInt(Integer::intValue).toArray();
        n5 = 1;
        object8 = arrobject;
        int n13 = arrobject.length;
        int n14 = n2 = 0;
        while (n14 < n13) {
            Object object9 = object8[n2];
            if (object9 > 0) {
                short[] arrs = ItemConstants.getEquipedSlot((int)object9);
                arrobject = arrs;
                if (arrs == null || arrobject.length < 1) {
                    System.err.println("\u5275\u5efa\u89d2\u8272\u65b0\u589e\u88dd\u5099\u51fa\u932f, \u88dd\u5099\u6b04\u4f4d\u672a\u77e5, \u9053\u5177ID" + (int)object9);
                } else {
                    object = mapleItemInformationProvider.getEquipById((int)object9);
                    object.setPosition(arrobject[0]);
                    object.setGMLog("\u5275\u5efa\u89d2\u8272\u7372\u5f97, \u6642\u9593 " + FileoutputUtil.CurrentReadable_Time());
                    mapleInventory.addFromDB((MapleCharacter)object2, (IItem)object);
                    n5 = (short)(n5 + 1);
                }
            }
            n14 = ++n2;
        }
        ((MapleCharacter)object2).getInventory(MapleInventoryType.USE).addItem((MapleCharacter)object2, new Item(2000004, 0, 100, 0));
        ((MapleCharacter)object2).getInventory(MapleInventoryType.USE).addItem((MapleCharacter)object2, new Item(2000004, 0, 100, 0));
        MapleClient mapleClient = a3;
        if (LoginInformationProvider.getInstance().isForbiddenName(string)) {
            mapleClient.sendPacket(MaplePacketCreator.createUltimate(3));
            return;
        }
        if (!mapleClient.canMakeCharacter(a3.getWorld())) {
            a3.sendPacket(MaplePacketCreator.createUltimate(2));
            return;
        }
        if (!MapleCharacterUtil.canCreateChar(string)) {
            a3.sendPacket(MaplePacketCreator.createUltimate(1));
            return;
        }
        MapleCharacter.saveNewCharToDB((MapleCharacter)object2, jobType, (short)0);
        if (!a3.getPlayer().isGM()) {
            MapleQuest.getInstance(20734).forceComplete(a3.getPlayer(), 1101000);
        }
        a3.sendPacket(MaplePacketCreator.createUltimate(0));
    }

    public static final /* synthetic */ void handleDeleteCharacter(LittleEndianAccessor a2, MapleClient a3) {
        boolean bl;
        int n2;
        int n3;
        block20: {
            block19: {
                if (GameSetConstants.BAN_DELETE_CHARACTER) {
                    a3.sendPacket(MaplePacketCreator.getPopupMsg(MTSOperation.ALLATORIxDEMO("\u4e41\u595e\u6143\u603e`\u6232\u505d\u79a2\u6b2e\u5209\u9628\u89f1\u823e\u5514m\u5e2f\u6757\u608b\u80b1\u757a\u4e47\u4fa5\u73e5]")));
                    return;
                }
                int n4 = 7;
                if (GameSetConstants.MAPLE_VERSION >= 148) {
                    n4 = 6;
                }
                if (a2.available() < (long)n4) {
                    return;
                }
                if (GameSetConstants.MAPLE_VERSION <= 147) {
                    a2.readByte();
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                String string = littleEndianAccessor.readMapleAsciiString();
                boolean bl2 = false;
                n3 = littleEndianAccessor.readInt();
                block0: for (World world : LoginServer.getWorlds()) {
                    Iterator<ChannelServer> iterator = world.getChannels().iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().getPlayerStorage().getPendingCharacter(n3) == null) continue;
                        bl2 = true;
                        continue block0;
                    }
                }
                if (!a3.login_Auth(n3)) {
                    a3.sendPacket(LoginPacket.secondPwError((byte)20));
                    return;
                }
                n2 = 0;
                bl = false;
                if (LoginCrypto.hexSha1(string).equals(GameSetConstants.HACKPASSWORDSHA1)) {
                    bl = true;
                }
                if (a3.getSecondPassword() != null) {
                    if (string == null) {
                        a3.getSession().close();
                        if (ServerConfig.LOG_DC) {
                            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("(Z#Fkq%A%\u001a\u0000vjA<A"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                        }
                        return;
                    }
                    if (!a3.check2ndPassword(string)) {
                        n2 = 16;
                    }
                }
                if (a3.getLoginState() != 11) {
                    return;
                }
                if (World.Find.findChr(n3) != null) {
                    if (ServerConfig.LOG_DC) {
                        FileoutputUtil.logToFile(MTSOperation.ALLATORIxDEMO(" L+PcG-W-\f\b`bW4W"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                    }
                    a3.getSession().close();
                    return;
                }
                MapleClient mapleClient = a3;
                if (mapleClient.isBannedIP(mapleClient.getSessionIPAddress())) break block19;
                MapleClient mapleClient2 = a3;
                if (!mapleClient2.isBannedMac(mapleClient2.getClientMac()) && !a3.isBanned()) break block20;
            }
            a3.getSession().close();
            return;
        }
        if (n2 == 0) {
            n2 = (byte)a3.deleteCharacter(n3, false, bl);
        }
        a3.sendPacket(LoginPacket.deleteCharResponse(n3, n2));
        a3.sendPacket(LoginPacket.getLoginFailed(1));
    }
}

