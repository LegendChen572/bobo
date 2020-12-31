/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleQuestStatus;
import client.RockPaperScissors;
import client.inventory.CheckItemFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.ItemCustomFlag;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.GameStringConstants;
import handling.SendPacketOpcode;
import handling.channel.handler.MovementParse;
import handling.login.LoginServer;
import handling.opcodes.NpcShopType;
import handling.world.World;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import scripting.ScriptType;
import scripting.item.ItemScriptManager;
import scripting.npc.NPCConversationManager;
import scripting.npc.NPCScriptManager;
import server.AutobanManager;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleShop;
import server.MapleStorage;
import server.MapleStorageType;
import server.characterCards.MapleCharacterCards;
import server.life.AbstractLoadedMapleLife;
import server.life.MapleLifeFactory;
import server.life.MapleNPC;
import server.maps.MapNameData;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.quest.MapleQuest;
import tools.ArrayMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Triple;
import tools.data.LittleEndianAccessor;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;

public class NPCHandler {
    public static final /* synthetic */ void UpdateQuest(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = a2.readInt();
        if (a3 != null && a3.getPlayer() != null) {
            if (a3.getPlayer().isAdmin()) {
                a3.getPlayer().dropMessage("[UPDATE_QUEST] itemId: " + n2);
            }
            if (n2 / 10000 == 422) {
                a3.getPlayer().setItemQuestItemId(n2);
                return;
            }
            if (a3.getPlayer().isAdmin()) {
                a3.getPlayer().dropMessage("[UPDATE_QUEST] \u9053\u5177\u4ee3\u78bc\u4e0d\u5728422\u958b\u982d\uff0c\u767c\u751f\u7570\u5e38(" + n2 + ")");
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void RPSGame(LittleEndianAccessor a2, MapleClient a3) {
        if (a2.available() == 0L || !a3.getPlayer().getMap().containsNPC(9209002)) {
            if (a3.getPlayer().getRPS() == null) return;
            a3.getPlayer().getRPS().dispose(a3);
            return;
        }
        int n2 = a2.readByte();
        switch (n2) {
            case 0: 
            case 5: {
                if (a3.getPlayer().getRPS() != null) {
                    a3.getPlayer().getRPS().reward(a3);
                }
                if (a3.getPlayer().getMeso() >= 1000) {
                    a3.getPlayer().setRPS(new RockPaperScissors(a3, (byte)n2));
                    return;
                }
                n2 = 8;
                if (GameSetConstants.MAPLE_VERSION >= 147) {
                    n2 = 9;
                }
                a3.sendPacket(MaplePacketCreator.getRPSMode((byte)n2, -1, -1, -1));
                return;
            }
            case 1: {
                if (a3.getPlayer().getRPS() != null && a3.getPlayer().getRPS().answer(a3, a2.readByte())) return;
                a3.sendPacket(MaplePacketCreator.getRPSMode((byte)13, -1, -1, -1));
                return;
            }
            case 2: {
                if (a3.getPlayer().getRPS() != null && a3.getPlayer().getRPS().timeOut(a3)) return;
                a3.sendPacket(MaplePacketCreator.getRPSMode((byte)13, -1, -1, -1));
                return;
            }
            case 3: {
                if (a3.getPlayer().getRPS() != null && a3.getPlayer().getRPS().nextRound(a3)) return;
                a3.sendPacket(MaplePacketCreator.getRPSMode((byte)13, -1, -1, -1));
                return;
            }
            case 4: {
                MapleClient mapleClient = a3;
                if (a3.getPlayer().getRPS() != null) {
                    mapleClient.getPlayer().getRPS().dispose(a3);
                    return;
                }
                mapleClient.sendPacket(MaplePacketCreator.getRPSMode((byte)13, -1, -1, -1));
                return;
            }
        }
    }

    public static final /* synthetic */ void NPCMoreTalk(LittleEndianAccessor a2, MapleClient a3) {
        boolean bl;
        byte by;
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by2 = littleEndianAccessor.readByte();
        byte by3 = littleEndianAccessor.readByte();
        NPCConversationManager nPCConversationManager = NPCScriptManager.getInstance().getCM(a3);
        boolean bl2 = false;
        if (nPCConversationManager == null) {
            bl2 = true;
            nPCConversationManager = ItemScriptManager.getInstance().getIM(a3);
        }
        if (nPCConversationManager == null || a3 == null || a3.getPlayer() == null) {
            return;
        }
        if (nPCConversationManager.getScriptType() != ScriptType.ON_USER_ENTER && nPCConversationManager.getScriptType() != ScriptType.ON_FIRST_USER_ENTER && (a3.getPlayer().getConversation() == 0 || nPCConversationManager.getLastMsg() != by2)) {
            if (a3.getPlayer().isStaff()) {
                a3.getPlayer().dropMessage("[NPCMoreTalk\u932f\u8aa4] \u6700\u5f8cMsg\u985e\u578b[" + nPCConversationManager.getLastMsg() + "] \u5c01\u5305\u63a5\u6536\u985e\u578b[" + by2 + "]");
            }
            return;
        }
        nPCConversationManager.setLastMsg((byte)-1);
        if (by2 == (GameSetConstants.MAPLE_VERSION > 113 ? (byte)3 : 2)) {
            if (by3 != 0) {
                nPCConversationManager.setGetText(a2.readMapleAsciiString());
                switch (nPCConversationManager.getType()) {
                    case QUEST_START: {
                        NPCScriptManager nPCScriptManager = NPCScriptManager.getInstance();
                        while (false) {
                        }
                        nPCScriptManager.startQuest(a3, by3, by2, -1);
                        return;
                    }
                    case QUEST_END: {
                        NPCScriptManager.getInstance().endQuest(a3, by3, by2, -1);
                        return;
                    }
                }
                NPCScriptManager.getInstance().action(a3, by3, by2, -1);
                return;
            }
            nPCConversationManager.dispose();
            return;
        }
        int n2 = -1;
        LittleEndianAccessor littleEndianAccessor2 = a2;
        if (a2.available() >= 4L) {
            n2 = littleEndianAccessor2.readInt();
            by = by2;
        } else {
            if (littleEndianAccessor2.available() > 0L) {
                n2 = a2.readByte();
            }
            by = by2;
        }
        boolean bl3 = bl = by == (GameSetConstants.MAPLE_VERSION > 113 ? (byte)4 : 3);
        if (bl && n2 < 0) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().setCheckSelection(false);
            mapleClient.getPlayer().setCheckSelectionMin(-1);
            mapleClient.getPlayer().setCheckSelectionMax(-1);
            mapleClient.getPlayer().clearNpcSelect();
            nPCConversationManager.dispose();
            return;
        }
        if (n2 != -1) {
            if (!a3.getPlayer().isNpcSelect(n2) && !a3.getPlayer().isNpcSelect(-999999999)) {
                FileoutputUtil.logToFile(MapleCharacterCards.ALLATORIxDEMO("`;k'#\u001cm7g{B\u0004O\u000b_\u0011@\u0011O\u0000E\u001bB\u7628\u5309zx,x"), a3.getPlayer().getChrInfo(nPCConversationManager.getNpc() + " " + nPCConversationManager.getScript() + "\r\n"));
                nPCConversationManager.dispose();
                return;
            }
            if (a3.getPlayer().isCheckSelection() && a3.getPlayer().getCheckSelectionMin() != -1 && a3.getPlayer().getCheckSelectionMax() != -1) {
                if (n2 < a3.getPlayer().getCheckSelectionMin()) {
                    FileoutputUtil.logToFile(MapNameData.ALLATORIxDEMO(")\u007f\"cjX$s.?\u000b@\u0006O\u0002U\u0011^\u0010]\u0007U\u0017\u766c\u5340>1h1"), a3.getPlayer().getChrInfo(nPCConversationManager.getNpc() + " " + nPCConversationManager.getScript() + " \u6700\u5c0fselection = " + a3.getPlayer().getCheckSelectionMin() + " \u76ee\u524dselection = " + n2 + "\r\n"));
                    nPCConversationManager.dispose();
                    return;
                }
                if (n2 > a3.getPlayer().getCheckSelectionMax()) {
                    FileoutputUtil.logToFile(MapleCharacterCards.ALLATORIxDEMO("`;k'#\u001cm7g{B\u0004O\u000bK\u0011X\u001aY\u0019N\u0011^\u7628\u5309zx,x"), a3.getPlayer().getChrInfo(nPCConversationManager.getNpc() + " " + nPCConversationManager.getScript() + " \u6700\u5927selection = " + a3.getPlayer().getCheckSelectionMax() + " \u76ee\u524dselection = " + n2 + "\r\n"));
                    nPCConversationManager.dispose();
                    return;
                }
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().setCheckSelection(false);
                mapleClient.getPlayer().setCheckSelectionMin(-1);
                mapleClient.getPlayer().setCheckSelectionMax(-1);
            }
        }
        if (nPCConversationManager.getNpc() != 9000069 && by2 == 4 && n2 == -1) {
            nPCConversationManager.dispose();
            if (a3.isMonitored()) {
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapNameData.ALLATORIxDEMO("\u7d40\u671a\u8217\u000b@\u0006\u7694\u5c48\u8a61\u3047\u001dO")));
            }
            return;
        }
        if (n2 >= -1 && by3 != -1) {
            switch (nPCConversationManager.getType()) {
                case QUEST_START: {
                    NPCScriptManager nPCScriptManager = NPCScriptManager.getInstance();
                    while (false) {
                    }
                    nPCScriptManager.startQuest(a3, by3, by2, n2);
                    return;
                }
                case QUEST_END: {
                    NPCScriptManager.getInstance().endQuest(a3, by3, by2, n2);
                    return;
                }
            }
            if (bl2) {
                ItemScriptManager.getInstance().action(a3, by3, by2, n2);
                return;
            }
            NPCScriptManager.getInstance().action(a3, by3, by2, n2);
            return;
        }
        nPCConversationManager.dispose();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void handleNPCShop(LittleEndianAccessor a2, MapleClient a3) {
        MapleCharacter mapleCharacter = a3.getPlayer();
        Object object = NpcShopType.getNpcShopOperationType(a2.readByte());
        if (mapleCharacter == null) {
            return;
        }
        switch (1.d[((Enum)object).ordinal()]) {
            case 1: {
                object = mapleCharacter.getShop();
                if (object == null) {
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                littleEndianAccessor.skip(2);
                int n2 = littleEndianAccessor.readInt();
                short s2 = littleEndianAccessor.readShort();
                if (((MapleShop)object).getId() == 999) {
                    ((MapleShop)object).buySellBack(a3, n2, s2);
                    return;
                }
                ((MapleShop)object).buy(a3, n2, s2);
                return;
            }
            case 2: {
                object = mapleCharacter.getShop();
                if (object == null) {
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                byte by = (byte)littleEndianAccessor.readShort();
                int n3 = littleEndianAccessor.readInt();
                short s3 = littleEndianAccessor.readShort();
                ((MapleShop)object).sell(a3, GameConstants.getInventoryType(n3), by, s3);
                return;
            }
            case 3: {
                object = mapleCharacter.getShop();
                if (object == null) {
                    return;
                }
                byte by = (byte)a2.readShort();
                ((MapleShop)object).recharge(a3, by);
                return;
            }
        }
        mapleCharacter.setConversation(0);
    }

    public static final /* synthetic */ void repairAll(MapleClient a2) {
        Iterator iterator;
        int n2;
        if (a2.getPlayer().getMapId() != 240000000) {
            return;
        }
        int n3 = 0;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        ArrayMap<Equip, Integer> arrayMap = new ArrayMap<Equip, Integer>();
        MapleInventoryType[] arrmapleInventoryType = new MapleInventoryType[2];
        arrmapleInventoryType[0] = MapleInventoryType.EQUIP;
        arrmapleInventoryType[1] = MapleInventoryType.EQUIPPED;
        Object object = arrmapleInventoryType;
        int n4 = arrmapleInventoryType.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            MapleInventoryType mapleInventoryType = object[n2];
            for (IItem iItem : a2.getPlayer().getInventory(mapleInventoryType)) {
                Map<String, Integer> map;
                Equip equip;
                if (!(iItem instanceof Equip) || (equip = (Equip)iItem).getDurability() < 0 || (map = mapleItemInformationProvider.getEquipStats(equip.getItemId())).get(MapleCharacterCards.ALLATORIxDEMO("0y&m6e8e u")) <= 0 || equip.getDurability() >= map.get(MapNameData.ALLATORIxDEMO("t0b$r,|,d<"))) continue;
                double d2 = 100.0 - Math.ceil((double)equip.getDurability() * 1000.0 / ((double)map.get(MapleCharacterCards.ALLATORIxDEMO("0y&m6e8e u")).intValue() * 10.0));
                arrayMap.put(equip, map.get(MapNameData.ALLATORIxDEMO("t0b$r,|,d<")));
                n3 += (int)Math.ceil(d2 * mapleItemInformationProvider.getPrice(equip.getItemId()) / (mapleItemInformationProvider.getReqLevel(equip.getItemId()) < 70 ? 100.0 : 1.0));
            }
            n5 = ++n2;
        }
        if (arrayMap.size() <= 0 || a2.getPlayer().getMeso() < n3) {
            return;
        }
        a2.getPlayer().gainMeso(-n3, true);
        Iterator iterator2 = iterator = arrayMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator.next();
            object = (Equip)entry.getKey();
            ((Equip)object).setDurability((Integer)entry.getValue());
            a2.getPlayer().forceReAddItem(((Equip)object).copy(), ((Item)object).getPosition() < 0 ? MapleInventoryType.EQUIPPED : MapleInventoryType.EQUIP);
            iterator2 = iterator;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void handleStorage(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        MapleStorage mapleStorage;
        byte by = a2.readByte();
        MapleStorageType mapleStorageType = a4.getOperateStorageExceed();
        if (a4 == null) {
            return;
        }
        if (a4.getMap() == null || a4.getTrade() != null || !a4.isAlive()) {
            a4.setOperateStorage(false);
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, MapleCharacterCards.ALLATORIxDEMO("\u76e2\u5219\u7688\u7294\u6147\u7175\u6cd9\u57a3\u8840\u6778\u64c1\u4f08\u300e"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a4.setOperateStorage(true);
        MapleStorage mapleStorage2 = mapleStorage = mapleStorageType != null && mapleStorageType.isExceed() ? a4.getStorageExceed().get((Object)mapleStorageType) : a4.getStorage();
        if (!a3.getPlayer().canStorage()) {
            if (a4.isOperateStorage()) {
                a4.setOperateStorage(false);
            }
            mapleStorage.close();
            MapleClient mapleClient = a3;
            a4.setConversation(0);
            mapleClient.getPlayer().dropMessage(1, MapNameData.ALLATORIxDEMO("\u5019\u5eee\u64dd\u4f19\u905e\u5fae<\u8a8e\u7a1d\u505c\u5738\u8a23"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        switch (by) {
            case 4: {
                byte by2 = a2.readByte();
                MapleStorage mapleStorage3 = mapleStorage;
                byte by3 = mapleStorage3.getSlot(MapleInventoryType.getByType(by2), a2.readByte());
                IItem iItem = mapleStorage3.takeOut(by3);
                if (iItem == null) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (!MapleInventoryManipulator.checkSpace(a3, iItem.getItemId(), iItem.getQuantity(), iItem.getOwner())) {
                    mapleStorage.store(iItem);
                    a4.dropMessage(1, MapleCharacterCards.ALLATORIxDEMO("\u4f6c\u76d0\u7265\u5495\u6518\u5da6\u7d9f\u6eab\u4e8az\""));
                    mapleStorage.update(a3);
                    return;
                }
                if (a4.getMapId() == 910000000 && a4.getMeso() < 1000) {
                    mapleStorage.store(iItem);
                    a4.dropMessage(1, MapNameData.ALLATORIxDEMO("\u4f25\u6c82\u674c\u8da3\u5965\u7694\u6916\u5e73\u985d\u53c6\u504c\u5ebb\u9016\u5167\u3047"));
                    mapleStorage.update(a3);
                    return;
                }
                if (iItem.getQuantity() < 1) {
                    return;
                }
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.addStorageMsg(mapleCharacter.getName(), " \u62ff\u51fa\u9053\u5177 " + iItem.getItemName() + "(" + iItem.getItemId() + ") \u6578\u91cf:" + iItem.getQuantity() + "\r\n");
                if (a4.getMapId() == 910000000) {
                    a4.gainMeso(-1000, false, true, false);
                }
                if (!LoginServer.doubleLogin(a3)) {
                    MapleInventoryManipulator.addFromDrop(a3, iItem, false);
                    mapleStorage.sendTakenOut(a3, GameConstants.getInventoryType(iItem.getItemId()));
                    a4.saveToDB(false, false);
                    return;
                }
                FileoutputUtil.logToFile(MapleCharacterCards.ALLATORIxDEMO("`;k'#\u001cm7g{\u96d5\u762f\u64c1\u4f08#\u505d\u5ea7\u5382\u51f6zx,x"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getPlayer().getName() + "\u7b49\u7d1a:" + a3.getPlayer().getLevel() + "\u9818\u53d6\u5009\u5eab" + iItem.getQuantity() + "\u5f35" + MapleItemInformationProvider.getInstance().getName(iItem.getItemId()));
                return;
            }
            case 5: {
                LittleEndianAccessor littleEndianAccessor = a2;
                byte by4 = (byte)littleEndianAccessor.readShort();
                int n2 = littleEndianAccessor.readInt();
                short s2 = littleEndianAccessor.readShort();
                if (!mapleStorageType.checkItem(n2)) {
                    a4.dropMessage(1, MapNameData.ALLATORIxDEMO("\u60b8\u7164\u6cc5\u5c42\u6b74\u722c\u54d1\u657b\u5175\u905c\u501b\u504c\u5ebb\u3047"));
                    mapleStorage.update(a3);
                    return;
                }
                if (mapleStorageType == MapleStorageType.STORAGE_EXCEED_CHAIR && mapleStorage.containsItem(n2)) {
                    a4.dropMessage(1, MapleCharacterCards.ALLATORIxDEMO("\u60a4\u7175\u6cd9\u656a\u5169\u9199\u890b\u76d0\u6909\u5b04\u300e"));
                    mapleStorage.update(a3);
                    return;
                }
                MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(n2);
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                if (s2 < 1) {
                    return;
                }
                if (mapleStorage.isFull()) {
                    a3.sendPacket(MaplePacketCreator.getStorageFull());
                    return;
                }
                if (a4.getInventory(mapleInventoryType).getItem(by4) == null) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (a4.getMeso() < 100 || a4.getMapId() == 910000000 && a4.getMeso() < 500) {
                    a4.dropMessage(1, MapNameData.ALLATORIxDEMO("\u4f70\u6cd7\u6719\u8df6\u5930\u76c1\u6943\u5e26\u652e\u504c\u5ebb\u9016\u5167\u3047"));
                    return;
                }
                Object object = a4.getInventory(mapleInventoryType).getItem(by4).copy();
                if (GameConstants.isPet(object.getItemId())) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (object.getQuantity() <= 0) {
                    a4.dropMessage(1, MapleCharacterCards.ALLATORIxDEMO("\u98d7\u93b6\u300d\u5f1c\u4e34\u652c\u91c3\u5c5b\u65b0d\u4e01\u53bb\u5b54\u5131\u5005\u5eff\u300e"));
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (ItemCustomFlag.\u7121\u6cd5\u653e\u5165\u5009\u5eab.check(object.getCustomFlag())) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, MapNameData.ALLATORIxDEMO("\u6b74\u9016\u5167\u7164\u6cc5\u657b\u5175\u504c\u5ebb\u3047"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                int n3 = object.getFlag();
                if (mapleItemInformationProvider.isPickupRestricted(object.getItemId()) && mapleStorage.findById(object.getItemId()) != null) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (object.getItemId() == n2 && (object.getQuantity() >= s2 || GameConstants.isThrowingStar(n2) || GameConstants.isBullet(n2))) {
                    int n4;
                    if (mapleItemInformationProvider.isDropRestricted(object.getItemId())) {
                        if (ItemFlag.KARMA_EQ.check(n3)) {
                            n4 = n2;
                            object.setFlag(n3 - ItemFlag.KARMA_EQ.getValue());
                        } else {
                            if (!ItemFlag.KARMA_USE.check(n3)) {
                                a3.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            n4 = n2;
                            object.setFlag(n3 - ItemFlag.KARMA_USE.getValue());
                        }
                    } else {
                        n4 = n2;
                    }
                    if (GameConstants.isThrowingStar(n4) || GameConstants.isBullet(n2)) {
                        s2 = object.getQuantity();
                    }
                    if (!LoginServer.doubleLogin(a3)) {
                        int n5 = a4.getMapId() == 910000000 ? 500 : 100;
                        MapleCharacter mapleCharacter = a4;
                        mapleCharacter.gainMeso(-n5, false, true, false);
                        MapleInventoryManipulator.removeFromSlot(a3, mapleInventoryType, by4, s2, false);
                        Object object2 = object;
                        object2.setQuantity(s2);
                        object2.setInventoryitemId(MapleInventoryIdentifier.getInstance());
                        MapleStorage mapleStorage4 = mapleStorage;
                        mapleStorage4.store((IItem)object);
                        mapleStorage4.sendStored(a3, GameConstants.getInventoryType(n2));
                        mapleCharacter.addStorageMsg(mapleCharacter.getName(), " \u5b58\u5165\u9053\u5177 " + object.getItemName() + "(" + object.getItemId() + ") \u6578\u91cf:" + s2 + "\r\n");
                    } else {
                        FileoutputUtil.logToFile(MapleCharacterCards.ALLATORIxDEMO("`;k'#\u001cm7g{\u96d5\u762f\u64c1\u4f08#\u505d\u5ea7\u5b0c\u5169zx,x"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getPlayer().getName() + "\u7b49\u7d1a:" + a3.getPlayer().getLevel() + "\u653e\u5165\u5009\u5eab" + object.getQuantity() + "\u5f35" + MapleItemInformationProvider.getInstance().getName(object.getItemId()));
                    }
                } else {
                    AutobanManager.getInstance().addPoints(a3, 1000, 0L, "Trying to store non-matching itemid (" + n2 + "/" + object.getItemId() + ") or quantity not in posession (" + s2 + "/" + object.getQuantity() + ")");
                    return;
                }
                object = CheckItemFactory.getItems();
                if (!object.containsKey(n2) || s2 <= (Integer)object.get(n2)) break;
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a4.getName() + "\u7b49\u7d1a:" + a4.getLevel() + "(\u7de8\u865f: " + a4.getId() + ")\u653e\u5165\u5009\u5eab" + s2 + "\u5f35" + MapleItemInformationProvider.getInstance().getName(n2) + "\uff0c\u5341\u5206\u53ef\u7591\u3002"));
                FileoutputUtil.logToFile(MapNameData.ALLATORIxDEMO(")\u007f\"cjX$s.?\u7535\u5e28\u6916\u5e73\u9016\u5167\u5030\u6e3cj\u5019\u5eee\u7279\u5484\u6ab2\u6e69>1h1"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a4.getName() + "\u7b49\u7d1a:" + a4.getLevel() + "(\u7de8\u865f: " + a4.getId() + ")\u653e\u5165\u5009\u5eab" + s2 + "\u5f35" + MapleItemInformationProvider.getInstance().getName(n2));
                if (!GameSetConstants.AUTOMONITOR || a3.isMonitored() || a3.isGm()) break;
                a3.setMonitored(true);
                return;
            }
            case 6: {
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.addStorageMsg(mapleCharacter.getName(), MapleCharacterCards.ALLATORIxDEMO(",\u6520\u740a\u9007\u517bY\u0006"));
                MapleStorage mapleStorage5 = mapleStorage;
                mapleStorage5.arrange();
                mapleStorage5.update(a3);
                return;
            }
            case 7: {
                int n6 = a2.readInt();
                if (mapleStorageType.isExceed() && n6 < 0) {
                    a4.dropMessage(1, MapNameData.ALLATORIxDEMO("\u60ed\u7131\u6c90\u5c17\u6916\u5e73\u5b1d\u5175\u905c\u501b\u504c\u5ebb\u3047"));
                    mapleStorage.update(a3);
                    return;
                }
                int n7 = mapleStorage.getMeso();
                int n8 = a4.getMeso();
                if (n6 > 0 && n7 >= n6 || n6 < 0 && n8 >= -n6) {
                    int n9;
                    String string;
                    int n10;
                    String string2;
                    MapleClient mapleClient;
                    if (n6 < 0 && n7 - n6 < 0 ? -(n6 = -(Integer.MAX_VALUE - n7)) > n8 : n6 > 0 && n8 + n6 < 0 && (n6 = Integer.MAX_VALUE - n8) > n7) {
                        return;
                    }
                    int n11 = GameSetConstants.checkMeso;
                    if (n6 >= n11) {
                        a3.SetMonitored(true);
                        World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a4.getName() + "\u7b49\u7d1a:" + a4.getLevel() + "(\u7de8\u865f: " + a4.getId() + ")\u53d6\u51fa\u5009\u5eab" + n6 + "\u6953\u5e63\uff0c\u5341\u5206\u53ef\u7591\u3002"));
                        FileoutputUtil.logToFile(MapleCharacterCards.ALLATORIxDEMO("`;k'#\u001cm7g{\u757c\u5e6c\u695f\u5e37\u905f\u5123\u5079\u6e78#\u5973\u91c3\u6907\u5e6f\u5382\u51f6\u505d\u5ea7zx,x"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a4.getName() + "\u7b49\u7d1a:" + a4.getLevel() + "(\u7de8\u865f: " + a4.getId() + ")\u53d6\u51fa\u5009\u5eab" + n6 + "\u6953\u5e63");
                        mapleClient = a3;
                    } else {
                        if (n6 <= -n11) {
                            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a4.getName() + "\u7b49\u7d1a:" + a4.getLevel() + "(\u7de8\u865f: " + a4.getId() + ")\u5b58\u5165\u5009\u5eab" + -n6 + "\u6953\u5e63\uff0c\u5341\u5206\u53ef\u7591\u3002"));
                            FileoutputUtil.logToFile(MapNameData.ALLATORIxDEMO(")\u007f\"cjX$s.?\u7535\u5e28\u6916\u5e73\u9016\u5167\u5030\u6e3cj\u5937\u918a\u6943\u5e26\u5b48\u5120\u5019\u5eee>1h1"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a4.getName() + "\u7b49\u7d1a:" + a4.getLevel() + "(\u7de8\u865f: " + a4.getId() + ")\u5b58\u5165\u5009\u5eab" + -n6 + "\u6953\u5e63");
                            a3.SetMonitored(true);
                        }
                        mapleClient = a3;
                    }
                    if (mapleClient.isMonitored()) {
                        int n12 = n6;
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5009\u5eab\u6953\u5e63.txt", a3.getPlayer().getChrInfo(n12 > 0 ? "\u53d6\u51fa\u5009\u5eab " + n12 + "\u6953\u5e63" : "\u5b58\u5165\u5009\u5eab " + -n12 + "\u6953\u5e63"));
                    }
                    MapleCharacter mapleCharacter = a4;
                    String string3 = mapleCharacter.getName();
                    if (n6 >= 0) {
                        string2 = MapleCharacterCards.ALLATORIxDEMO("\u62ab\u51f6");
                        n10 = n6;
                    } else {
                        string2 = MapNameData.ALLATORIxDEMO("e\u5b48\u5120");
                        n10 = n6;
                    }
                    mapleCharacter.addStorageMsg(string3, " " + string2 + " \u6953\u5e63: " + n10 + "\r\n");
                    if (!LoginServer.doubleLogin(a3)) {
                        MapleCharacter mapleCharacter2;
                        if (World.Find.findChannel(a4.getName()) <= 0) {
                            int n13;
                            String string4;
                            String string5 = MapleCharacterCards.ALLATORIxDEMO("`;k'#\u001cm7g{\u5005\u5eff\u890b\u88a9#\u505d\u5ea7\u6907\u5e6fzx,x");
                            String string6 = FileoutputUtil.NowTime();
                            String string7 = a3.getPlayer().getName();
                            short s3 = a3.getPlayer().getLevel();
                            if (n6 >= 0) {
                                string4 = MapNameData.ALLATORIxDEMO("\u62ef\u51bf");
                                n13 = n6;
                            } else {
                                string4 = MapleCharacterCards.ALLATORIxDEMO(",\u5b0c\u5169");
                                n13 = n6;
                            }
                            FileoutputUtil.logToFile(string5, "\r\n " + string6 + "\u89d2\u8272" + string7 + "\u7b49\u7d1a:" + s3 + " " + string4 + " \u6953\u5e63: " + n13 + " \u89d2\u8272\u5df2\u96e2\u7dda!\r\n");
                            mapleCharacter2 = a4;
                        } else {
                            int n14 = n6;
                            mapleStorage.setMeso(n7 - n14);
                            a4.gainMeso(n14, false, true, false, true);
                            mapleStorage.sendMeso(a3);
                            mapleCharacter2 = a4;
                        }
                        mapleCharacter2.saveToDB(false, false);
                        mapleStorage.saveToDB();
                        return;
                    }
                    String string8 = MapNameData.ALLATORIxDEMO(")\u007f\"cjX$s.?\u969c\u766b\u6488\u4f4cj\u5019\u5eee\u6943\u5e26>1h1");
                    String string9 = FileoutputUtil.NowTime();
                    String string10 = a3.getPlayer().getName();
                    short s4 = a3.getPlayer().getLevel();
                    if (n6 >= 0) {
                        string = MapleCharacterCards.ALLATORIxDEMO("\u62ab\u51f6");
                        n9 = n6;
                    } else {
                        string = MapNameData.ALLATORIxDEMO("e\u5b48\u5120");
                        n9 = n6;
                    }
                    FileoutputUtil.logToFile(string8, "\r\n " + string9 + "\u89d2\u8272" + string10 + "\u7b49\u7d1a:" + s4 + " " + string + " \u6953\u5e63: " + n9 + "\r\n");
                    return;
                }
                AutobanManager.getInstance().addPoints(a3, 1000, 0L, "Trying to store or take out unavailable amount of mesos (" + n6 + "/" + mapleStorage.getMeso() + "/" + a3.getPlayer().getMeso() + ")");
                return;
            }
            case 8: {
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.addStorageMsg(mapleCharacter.getName(), a4.getClient().getSessionIPAddress() + " \u9ede\u9078-\u96e2\u958b\u5009\u5eab\r\n");
                MapleCharacter mapleCharacter3 = a4;
                MapleCharacter mapleCharacter4 = a4;
                mapleCharacter4.addEmptyStorageMsg(MapleCharacterCards.ALLATORIxDEMO("1i1i1i1i1i1i1i1i1i1i1i1i1i1Y\u0006"));
                mapleCharacter3.endStorageMsg(mapleCharacter4.getName());
                mapleStorage.close();
                mapleCharacter3.setConversation(0);
                if (mapleCharacter3.isOperateStorage()) {
                    a4.setOperateStorage(false);
                }
                if (mapleStorageType.isExceed()) {
                    a4.setOperateStorageExceed(null);
                }
                if (!a3.isMonitored()) break;
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapNameData.ALLATORIxDEMO("\u9e9b\u9068h\u96f2\u95ce\u5019\u5eee")));
                return;
            }
            default: {
                System.err.println("Unhandled Storage mode : " + by);
            }
        }
    }

    public static final /* synthetic */ void OpenQuestItem(LittleEndianAccessor a2, MapleClient a3) {
        Serializable serializable = MapleQuest.getInstance(a2.readShort());
        serializable = a3.getPlayer().getQuestNAdd((MapleQuest)serializable);
        if (serializable != null && ((MapleQuestStatus)serializable).getCustomData() != null && !((MapleQuestStatus)serializable).getCustomData().contains(MapleCharacterCards.ALLATORIxDEMO(":y8`")) && !((MapleQuestStatus)serializable).getCustomData().isEmpty()) {
            a3.sendPacket(MaplePacketCreator.showQuestEffect((MapleQuestStatus)serializable));
        }
    }

    public static final /* synthetic */ void ItemQuestUI(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = a2.readShortAsInt();
        if (a3 != null && a3.getPlayer() != null) {
            Serializable serializable;
            if (a3.getPlayer().isAdmin()) {
                a3.getPlayer().dropMessage("[QUEST_ITEM] questId: " + n2);
            }
            if ((serializable = MapleQuest.getInstance(n2)) != null) {
                boolean bl;
                boolean bl2 = false;
                if (a3.getPlayer().getQuestStatus(4710) > 0 && n2 == 4716) {
                    bl = bl2 = true;
                } else if (a3.getPlayer().getQuestStatus(21742) > 0 && n2 == 21763) {
                    bl = bl2 = true;
                } else if (a3.getPlayer().getQuestStatus(8251) > 0 && n2 == 8252) {
                    bl = bl2 = true;
                } else if (a3.getPlayer().getQuestStatus(20522) > 0 && n2 == 20514) {
                    bl = bl2 = true;
                } else if (a3.getPlayer().getQuestStatus(3250) > 0 && n2 == 7067) {
                    bl = bl2 = true;
                } else {
                    if (a3.getPlayer().isGM()) {
                        if (a3.getPlayer().getQuestStatus(n2) == 0) {
                            a3.getPlayer().dropMessage("\u4f7f\u7528\u4e86Debug\u6a21\u5f0f\u5f37\u5236\u958b\u59cb\u4e86\u4efb\u52d9: " + n2);
                        }
                        bl2 = true;
                    }
                    bl = bl2;
                }
                if (bl && a3.getPlayer().getQuestStatus(n2) == 0) {
                    serializable.forceStart(a3.getPlayer(), 9010000, null);
                }
                if ((serializable = a3.getPlayer().getQuestRemove((MapleQuest)serializable)) != null) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().updateQuest((MapleQuestStatus)serializable, true);
                    mapleClient.getPlayer().setItemQuestId(n2);
                }
            }
        }
    }

    public static final /* synthetic */ void UseItemQuest(LittleEndianAccessor a2, MapleClient a3) {
        a2.readByte();
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        Object object = MapleItemInformationProvider.getInstance();
        MapleClient mapleClient = a3;
        MapleQuest mapleQuest = MapleQuest.getInstance(mapleClient.getPlayer().getItemQuestId());
        IItem iItem = mapleClient.getPlayer().getInventory(MapleInventoryType.ETC).getItem(s2);
        if (a3.getPlayer().isAdmin()) {
            a3.getPlayer().dropMessage("[USE_ITEM_QUEST] itemId: " + n2);
        }
        if ((object = ((MapleItemInformationProvider)object).getQuestItemInfo(a3.getPlayer().getItemQuestItemId())) == null) {
            return;
        }
        if (((Integer)((Triple)object).getLeft()).intValue() != a3.getPlayer().getItemQuestId()) {
            return;
        }
        if (!((List)((Triple)object).getRight()).contains(iItem.getItemId())) {
            return;
        }
        if (mapleQuest != null && iItem != null && iItem.getQuantity() > 0 && n2 == a3.getPlayer().getItemQuestItemId()) {
            n2 = (Integer)((Triple)object).getMid();
            object = a3.getPlayer().getQuestNAdd(mapleQuest);
            if (object != null) {
                int n3 = ((MapleQuestStatus)object).getCustomData() == null ? 0 : Integer.valueOf(((MapleQuestStatus)object).getCustomData());
                MapleClient mapleClient2 = a3;
                ((MapleQuestStatus)object).setCustomData(String.valueOf(n3 + n2));
                mapleClient2.getPlayer().updateQuest((MapleQuestStatus)object, true);
                MapleInventoryManipulator.removeFromSlot(mapleClient2, MapleInventoryType.ETC, s2, (short)1, false);
                MapleClient mapleClient3 = a3;
                mapleClient3.sendPacket(MaplePacketCreator.updateQuestInfo(a3.getPlayer(), mapleClient3.getPlayer().getItemQuestId(), 9900001, (byte)1));
            }
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void handleNPCTalk(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a3 == null || a4 == null || a4.getMap() == null) {
            return;
        }
        if (a4.hasBlockedInventory()) {
            a3.removeClickedNPC();
            MapleClient mapleClient = a3;
            NPCScriptManager.getInstance().dispose(mapleClient);
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleNPC mapleNPC = a4.getMap().getNPCByOid(a2.readInt());
        if (mapleNPC == null) {
            return;
        }
        if (a4.isOperateStorage()) {
            a3.getPlayer().dropMessage(5, MapleCharacterCards.ALLATORIxDEMO("\u4f34\u6b6f\u577c\u64c1\u4f08\u5005\u5eff-"));
            return;
        }
        if (World.isShutDown) {
            a4.dropMessage(1, GameStringConstants.\u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f);
            return;
        }
        if (mapleNPC.hasShop()) {
            a4.setConversation(1);
            mapleNPC.sendShop(a3);
            return;
        }
        NPCScriptManager.getInstance().start(a3, mapleNPC.getId());
    }

    public static final /* synthetic */ void handleNPCAnimation(LittleEndianAccessor a2, MapleClient a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        int n2 = (int)a2.available();
        if (a3 == null || a3.getPlayer() == null || n2 < 4) {
            return;
        }
        Object object = a3.getPlayer().getMap();
        if (object == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        int n3 = a2.readInt();
        if ((object = ((MapleMap)object).getNPCByOid(n3)) == null) {
            if (a3.getPlayer().isShowErr()) {
                a3.getPlayer().showInfo(MapNameData.ALLATORIxDEMO("\u000b@\u0006\u52c5\u4f19"), true, "\u5730\u5716\u4e0a\u4e0d\u5b58\u5728NPC, OID=" + n3);
            }
            return;
        }
        if (!a3.getPlayer().isMapObjectVisible((MapleMapObject)object)) {
            return;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.NPC_ACTION.getValue());
        maplePacketLittleEndianWriter3.writeInt(n3);
        maplePacketLittleEndianWriter2.write(a2.readByte());
        maplePacketLittleEndianWriter2.write(a2.readByte());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.writeInt(a2.readInt());
        }
        if (MapleLifeFactory.isMoveNpc(((AbstractLoadedMapleLife)object).getId()) && a2.available() > 4L) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeShort(a2.readShort());
            maplePacketLittleEndianWriter4.writeShort(a2.readShort());
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter5.writeShort(a2.readShort());
                maplePacketLittleEndianWriter5.writeShort(a2.readShort());
            }
            object = MovementParse.parseMovement(a2, a3, 3);
            PacketHelper.serializeMovementList(maplePacketLittleEndianWriter, object);
        }
        maplePacketLittleEndianWriter.writeZeroBytes(20);
        a3.sendPacket(maplePacketLittleEndianWriter.getPacket());
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ (2 ^ 5);
        int cfr_ignored_0 = 4 << 3;
        int n5 = n3;
        int n6 = 3;
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

    public static /* synthetic */ void RequestRanks(LittleEndianAccessor a2, MapleClient a3, boolean a4) {
        int n2 = a2.readInt();
        if (a4) {
            a3.sendPacket(MaplePacketCreator.showChinesePVPRank(n2));
            return;
        }
        a3.sendPacket(MaplePacketCreator.showFishingKingPVPRank(n2));
    }

    public /* synthetic */ NPCHandler() {
        NPCHandler a2;
    }

    public static final /* synthetic */ void repair(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().getMapId() != 240000000 || a2.available() < 4L) {
            return;
        }
        int n2 = a2.readInt();
        MapleInventoryType mapleInventoryType = n2 < 0 ? MapleInventoryType.EQUIPPED : MapleInventoryType.EQUIP;
        Object object = a3.getPlayer().getInventory(mapleInventoryType).getItem((byte)n2);
        if (object == null) {
            return;
        }
        Equip equip = (Equip)object;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        object = mapleItemInformationProvider.getEquipStats(object.getItemId());
        if (equip.getDurability() < 0 || (Integer)object.get(MapleCharacterCards.ALLATORIxDEMO("0y&m6e8e u")) <= 0 || equip.getDurability() >= (Integer)object.get(MapNameData.ALLATORIxDEMO("t0b$r,|,d<"))) {
            return;
        }
        int n3 = (int)Math.ceil((100.0 - Math.ceil((double)equip.getDurability() * 1000.0 / ((double)((Integer)object.get(MapleCharacterCards.ALLATORIxDEMO("0y&m6e8e u"))).intValue() * 10.0))) * mapleItemInformationProvider.getPrice(equip.getItemId()) / (mapleItemInformationProvider.getReqLevel(equip.getItemId()) < 70 ? 100.0 : 1.0));
        if (a3.getPlayer().getMeso() < n3) {
            return;
        }
        a3.getPlayer().gainMeso(-n3, false);
        equip.setDurability((Integer)object.get(MapNameData.ALLATORIxDEMO("t0b$r,|,d<")));
        a3.getPlayer().forceReAddItem(equip.copy(), mapleInventoryType);
    }

    public static final /* synthetic */ void UseItemQuest2(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        Object object = MapleItemInformationProvider.getInstance();
        MapleQuest mapleQuest = MapleQuest.getInstance(n3);
        MapleClient mapleClient = a3;
        IItem iItem = mapleClient.getPlayer().getInventory(MapleInventoryType.ETC).getItem(s2);
        if (mapleClient.getPlayer().isAdmin()) {
            a3.getPlayer().dropMessage("[USE_ITEM_QUEST2] itemId: " + n2 + " questId: " + n3);
        }
        object = ((MapleItemInformationProvider)object).getQuestItemInfo(a3.getPlayer().getItemQuestItemId());
        if (iItem == null || iItem.getItemId() != n2) {
            return;
        }
        if (n3 != a3.getPlayer().getItemQuestId()) {
            return;
        }
        if (object == null) {
            return;
        }
        if ((Integer)((Triple)object).getLeft() != n3) {
            return;
        }
        if (!((List)((Triple)object).getRight()).contains(n2)) {
            return;
        }
        if (mapleQuest != null && iItem != null && iItem.getQuantity() > 0) {
            n2 = a2.readInt();
            object = a3.getPlayer().getQuestNAdd(mapleQuest);
            if (object != null) {
                int n4 = ((MapleQuestStatus)object).getCustomData() == null ? 0 : Integer.valueOf(((MapleQuestStatus)object).getCustomData());
                MapleClient mapleClient2 = a3;
                ((MapleQuestStatus)object).setCustomData(String.valueOf(n4 + n2));
                mapleClient2.getPlayer().updateQuest((MapleQuestStatus)object, true);
                MapleInventoryManipulator.removeFromSlot(mapleClient2, MapleInventoryType.ETC, s2, (short)1, false);
                MapleClient mapleClient3 = a3;
                mapleClient3.sendPacket(MaplePacketCreator.updateQuestInfo(mapleClient3.getPlayer(), n3, 9900001, (byte)1));
            }
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void QuestAction(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readByte();
        int n3 = littleEndianAccessor.readShortAsInt();
        if (a3 == null || a4 == null) {
            return;
        }
        MapleQuest mapleQuest = MapleQuest.getInstance(n3);
        switch (n2) {
            case 0: {
                a4.updateTick(a2.readInt());
                n2 = a2.readInt();
                MapleQuest.getInstance(n3).RestoreLostItem(a4, n2);
                return;
            }
            case 1: {
                n2 = a2.readInt();
                if (n2 == 0 && n3 > 0) {
                    mapleQuest.forceStart(a4, n2, null);
                    return;
                }
                if (n3 == 2001 || n3 == 8511 || n3 == 21301 || n3 == 21302 || n3 == 3083) {
                    mapleQuest.forceStart(a4, n2, null);
                    return;
                }
                if (n3 == 8512) {
                    mapleQuest.start(a4, n2);
                    return;
                }
                if (mapleQuest.hasStartScript()) break;
                mapleQuest.start(a4, n2);
                return;
            }
            case 2: {
                n2 = a2.readInt();
                a4.updateTick(a2.readInt());
                boolean bl = true;
                Integer n4 = -1;
                if (a2.available() >= 4L) {
                    if (a2.available() >= 8L) {
                        if (a3.getPlayer().itemQuantity(5660001) > 0 && !mapleQuest.checkNPCOnMap(a4, n2)) {
                            MapleInventoryManipulator.removeById(a3, MapleInventoryType.CASH, 5660001, 1, false, false);
                            bl = false;
                        }
                        a2.skip(4);
                    }
                    n4 = a2.readInt();
                }
                mapleQuest.complete(a4, n2, n4, bl);
                return;
            }
            case 3: {
                if (GameConstants.canForfeit(mapleQuest.getId())) {
                    mapleQuest.forfeit(a4);
                    return;
                }
                a4.dropMessage(1, MapNameData.ALLATORIxDEMO("\u4f70\u4e48\u80ed\u657b\u68d4\u905c\u501b\u4ebe\u52c9\u3047"));
                return;
            }
            case 4: {
                n2 = a2.readInt();
                if (a4.hasBlockedInventory()) {
                    return;
                }
                NPCScriptManager.getInstance().startQuest(a3, n2, n3);
                a2.readInt();
                return;
            }
            case 5: {
                n2 = a2.readInt();
                if (a4.hasBlockedInventory()) {
                    return;
                }
                NPCScriptManager.getInstance().endQuest(a3, n2, n3, false);
                a3.sendPacket(MaplePacketCreator.showQuestFinishEffect());
                MapleCharacter mapleCharacter = a4;
                a4.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showForeignQuestFinishEffect(mapleCharacter.getId()), false);
                return;
            }
        }
    }
}

