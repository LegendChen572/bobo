/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 *  constants.ItemConstants$\u985e\u578b
 */
package scripting;

import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleJob;
import client.MapleQuestStatus;
import client.MapleTrait;
import client.PlayerStats;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryIdentifierPet;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.ModifyInventory;
import client.messages.CommandProcessor;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.ServerConstants;
import constants.ServerSet;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.channel.handler.InterServerHandler;
import handling.channel.handler.InventoryHandler;
import handling.opcodes.SpecialEffect;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.guild.MapleGuild;
import java.awt.Point;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lottery.CustomEventFactory;
import lottery.Lottery;
import scripting.event.EventInstanceManager;
import scripting.event.EventManager;
import scripting.npc.NPCScriptManager;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.Timer;
import server.events.MapleEvent;
import server.events.MapleEventType;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterInformationProvider;
import server.life.MapleNPC;
import server.life.OverrideMonsterStats;
import server.maps.Event_DojoAgent;
import server.maps.MapleFoothold;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import server.maps.MapleMapObject;
import server.maps.MapleReactor;
import server.maps.SavedLocationType;
import server.quest.MapleQuest;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.googledrive.SyncServerData;
import tools.packet.PetPacket;
import tools.packet.UIPacket;

public abstract class AbstractPlayerInteraction {
    private /* synthetic */ MapleClient ALLATORIxDEMO;

    public final /* synthetic */ void gainItem(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, int a18) {
        AbstractPlayerInteraction a19;
        a19.gainItemS(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a19.ALLATORIxDEMO, a18);
    }

    public /* synthetic */ void showScreenAutoLetterBox(String a2) {
        AbstractPlayerInteraction a3;
        a3.showScreenAutoLetterBox(false, a2);
    }

    public final /* synthetic */ int getAndroidStat(String a22) {
        AbstractPlayerInteraction a3;
        if (a22.equals(SyncServerData.ALLATORIxDEMO("=K<X"))) {
            return a3.ALLATORIxDEMO.getPlayer().getAndroid().getHair();
        }
        if (a22.equals(MapleFoothold.ALLATORIxDEMO("\u0016\u001d\u0013\u0019"))) {
            return a3.ALLATORIxDEMO.getPlayer().getAndroid().getFace();
        }
        if (a22.equals(SyncServerData.ALLATORIxDEMO("2O;N0X"))) {
            int a22 = a3.ALLATORIxDEMO.getPlayer().getAndroid().getItemId();
            if (a22 == 1662000 || a22 == 1662002) {
                return 0;
            }
            return 1;
        }
        return -1;
    }

    public /* synthetic */ void addTrait(String a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getPlayer().getTrait(MapleTrait.MapleTraitType.valueOf(a2)).addExp(a3, a4.getPlayer());
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ List<IItem> getPotentiallist() {
        AbstractPlayerInteraction a4;
        Object object = a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.CASH);
        ArrayList<IItem> arrayList = new ArrayList<IItem>();
        object = ((MapleInventory)object).iterator();
        block3: while (true) {
            if (!object.hasNext()) {
                Collections.sort(arrayList, (a2, a3) -> a2.getPosition() - a3.getPosition());
                return arrayList;
            }
            IItem iItem = (IItem)object.next();
            switch (iItem.getItemId()) {
                case 5062000: 
                case 5062001: 
                case 5062002: 
                case 5062005: 
                case 0x4D3DD4: 
                case 5062500: {
                    arrayList.add(iItem);
                    continue block3;
                }
            }
        }
    }

    public final /* synthetic */ void gainMaplePoint(int a2) {
        AbstractPlayerInteraction a3;
        a3.gainPotion(2, a2);
    }

    public /* synthetic */ void makeStatsEquip(int a22, short a3, short a4, short a5, short a6, byte a7, String a8) {
        AbstractPlayerInteraction a9;
        Equip a22 = a9.ALLATORIxDEMO(a22, a3, a4, a5, a6, a7, a8);
        a22.setGMLog(FileoutputUtil.NowTime() + " " + a9.getPlayer().getName());
        MapleInventoryManipulator.addbyItem(a9.getClient(), a22);
    }

    public final /* synthetic */ void removeAll(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().removeAll(a2, true);
    }

    public /* synthetic */ int getPartyBossLog(String a2) {
        AbstractPlayerInteraction a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getParty() != null) {
            for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
                if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
                MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId());
                arrayList.add(mapleCharacter.getBossLog(a2));
            }
        } else {
            return a3.getBossLog(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public /* synthetic */ void warpMapWithClock(final int a2, int a3) {
        Iterator<MapleCharacter> iterator;
        AbstractPlayerInteraction a4;
        final MapleMap mapleMap = a4.ALLATORIxDEMO.getPlayer().getMap();
        Iterator<MapleCharacter> iterator2 = iterator = mapleMap.getAllPlayersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getClient().sendPacket(MaplePacketCreator.getClock(a3));
            iterator2 = iterator;
        }
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void run() {
                1 a22;
                if (a22.AbstractPlayerInteraction.this.ALLATORIxDEMO != null && a22.AbstractPlayerInteraction.this.ALLATORIxDEMO.getChannelServer() != null) {
                    Iterator<MapleCharacter> iterator;
                    1 v0 = a22;
                    MapleMap mapleMap3 = a22.AbstractPlayerInteraction.this.ALLATORIxDEMO.getChannelServer().getMapFactory().getMap(v0.a2);
                    Iterator<MapleCharacter> iterator2 = iterator = v0.mapleMap.getAllPlayersThreadsafe().iterator();
                    while (iterator2.hasNext()) {
                        MapleCharacter mapleCharacter = iterator.next();
                        iterator2 = iterator;
                        MapleMap mapleMap2 = mapleMap3;
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        mapleCharacter2.getClient().sendPacket(MaplePacketCreator.stopClock());
                        mapleCharacter2.changeMap(mapleMap2, mapleMap2.getPortal(0));
                    }
                }
            }
        }, 1000 * a3);
    }

    public final /* synthetic */ void forceStartQuest(int a2, int a3, boolean a4) {
        AbstractPlayerInteraction a5;
        MapleQuest.getInstance(a2).forceStart(a5.ALLATORIxDEMO.getPlayer(), 0, a4 ? String.valueOf(a3) : null);
    }

    public final /* synthetic */ void gainItemHour(int a2, short a3, int a4) {
        AbstractPlayerInteraction a5;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a2);
            if (!MapleInventoryManipulator.checkSpace(a5.getClient(), a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a5.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (mapleInventoryType.equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                object = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                if (a4 > 0) {
                    ((Item)object).setExpiration(System.currentTimeMillis() + (long)(a4 * 60 * 60 * 1000));
                }
                MapleInventoryManipulator.addbyItem(a5.getClient(), ((Equip)object).copy());
            }
        }
        a5.getClient().sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public /* synthetic */ void EnableUI(short a2, short a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().sendPacket(UIPacket.IntroEnableUI(a2, a3));
    }

    public /* synthetic */ int getEventCount(String a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().getEventCount(a2);
    }

    public final /* synthetic */ void worldYellowMessage(String a2) {
        World.Broadcast.broadcastMessage(MaplePacketCreator.yellowChat(a2));
    }

    public final /* synthetic */ MapleMap getMap(int a2) {
        AbstractPlayerInteraction a3;
        return a3.ALLATORIxDEMO(a2);
    }

    public final /* synthetic */ void gainItem(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17) {
        AbstractPlayerInteraction a18;
        a18.gainItemS(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, -1, a18.ALLATORIxDEMO, -1L, null);
    }

    public /* synthetic */ void getDirectionInfo(byte a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().sendPacket(UIPacket.getDirectionInfo(a2, a3));
    }

    public final /* synthetic */ void openNpc(MapleClient a2, int a3, int a4, String a5) {
        a2.removeClickedNPC();
        NPCScriptManager.getInstance().start(a2, a3, a4, a5, true);
    }

    public final /* synthetic */ void addHP(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().addHP(a2);
    }

    public final /* synthetic */ boolean dojoAgent_NextMap(boolean a2, boolean a3) {
        AbstractPlayerInteraction a4;
        if (a2) {
            return Event_DojoAgent.warpNextMap(a4.ALLATORIxDEMO.getPlayer(), a3);
        }
        return Event_DojoAgent.warpNextMap_Agent(a4.ALLATORIxDEMO.getPlayer(), a3);
    }

    public /* synthetic */ void gainFatigue(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer() != null) {
            a3.getPlayer().setFatigue(a3.getPlayer().getFatigue() + a2);
        }
    }

    public /* synthetic */ int getofflinechannel() {
        AbstractPlayerInteraction a2;
        return a2.ALLATORIxDEMO.getPlayer().getofflinechannel();
    }

    public final /* synthetic */ void givePartyNX(int a2, List<MapleCharacter> a3) {
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            ((MapleCharacter)a3.next()).modifyCSPoints(true ? (byte)1 : 0, a2, true);
            object = a3;
        }
    }

    public final /* synthetic */ int getMapId() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getMapId();
    }

    public final /* synthetic */ void gainItemS(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, int a18, MapleClient a19, long a20, String a21) {
        AbstractPlayerInteraction a22;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            Object object2 = GameConstants.getInventoryType(a2);
            if (!GameSetConstants.STORAGE_EXCEED && !MapleInventoryManipulator.checkSpace(a19, a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a22.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a22.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (((Enum)object2).equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                object2 = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                object = ((MapleItemInformationProvider)object).getName(a2);
                if (a2 / 10000 == 114 && object != null && ((String)object).length() > 0) {
                    object = "\u4f60\u5df2\u7372\u5f97\u7a31\u865f <" + (String)object + ">";
                    MapleClient mapleClient = a19;
                    mapleClient.getPlayer().dropMessage(-1, (String)object);
                    mapleClient.getPlayer().dropMessage(5, (String)object);
                }
                if (a18 >= 0) {
                    ((Equip)object2).setUpgradeSlots((byte)a18);
                }
                if (a20 >= 0L) {
                    ((Item)object2).setExpiration(System.currentTimeMillis() + a20 * 60L * 60L * 1000L);
                }
                if (a4 >= 0) {
                    ((Equip)object2).setStr((short)a4);
                }
                if (a5 >= 0) {
                    ((Equip)object2).setDex((short)a5);
                }
                if (a6 >= 0) {
                    ((Equip)object2).setLuk((short)a6);
                }
                if (a7 >= 0) {
                    ((Equip)object2).setInt((short)a7);
                }
                if (a8 >= 0) {
                    ((Equip)object2).setHp((short)a8);
                }
                if (a9 >= 0) {
                    ((Equip)object2).setMp((short)a9);
                }
                if (a10 >= 0) {
                    ((Equip)object2).setWatk((short)a10);
                }
                if (a11 >= 0) {
                    ((Equip)object2).setMatk((short)a11);
                }
                if (a12 >= 0) {
                    ((Equip)object2).setWdef((short)a12);
                }
                if (a13 >= 0) {
                    ((Equip)object2).setMdef((short)a13);
                }
                if (a14 >= 0) {
                    ((Equip)object2).setAvoid((short)a14);
                }
                if (a15 >= 0) {
                    ((Equip)object2).setAcc((short)a15);
                }
                if (a16 >= 0) {
                    ((Equip)object2).setJump((short)a16);
                }
                if (a17 >= 0) {
                    ((Equip)object2).setSpeed((short)a17);
                }
                if (a21 != null) {
                    ((Item)object2).setOwner(a21);
                }
                MapleInventoryManipulator.addbyItem(a19, ((Equip)object2).copy());
            } else {
                MapleInventoryManipulator.addById(a19, a2, a3, "");
            }
        } else {
            if (!a22.getPlayer().haveItem(a2, Math.abs(a3))) {
                FileoutputUtil.logToFile_NpcScript_Bug(a22.getPlayer(), " \u542b\u6709 \u6263\u9664\u4e0d\u5b58\u5728\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "] \u4e4b\u6f0f\u6d1e\r\n");
                a22.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleInventoryManipulator.removeById(a19, GameConstants.getInventoryType(a2), a2, -a3, true, false);
        }
        a19.sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public final /* synthetic */ void resetMap(int a2) {
        AbstractPlayerInteraction a3;
        a3.getMap(a2).resetFully();
    }

    public /* synthetic */ void warpPlayer(int a2, int a32) {
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleMap a32 = abstractPlayerInteraction.ALLATORIxDEMO.getChannelServer().getMapFactory().getMap(a32);
        Iterator<MapleCharacter> iterator = a2 = abstractPlayerInteraction.ALLATORIxDEMO.getChannelServer().getMapFactory().getMap(a2).getCharactersThreadsafe().iterator();
        while (iterator.hasNext()) {
            MapleMap mapleMap = a32;
            a2.next().changeMap(mapleMap, mapleMap.getPortal(0));
            iterator = a2;
        }
    }

    public final /* synthetic */ ChannelServer getChannelServer() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getChannelServer();
    }

    public /* synthetic */ void addDoublePendant(int a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.getPlayer().getQuestNAdd(MapleQuest.getInstance(122700)).setCustomData(String.valueOf(System.currentTimeMillis() + (long)a2 * 24L * 60L * 60L * 1000L));
    }

    public /* synthetic */ void forceStartQuest(int a2) {
        AbstractPlayerInteraction a3;
        MapleQuest.getInstance(a2).forceStart(a3.ALLATORIxDEMO.getPlayer(), 0, null);
    }

    public final /* synthetic */ void openNpc(String a2) {
        AbstractPlayerInteraction a3;
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        abstractPlayerInteraction.openNpc(abstractPlayerInteraction.ALLATORIxDEMO, a2);
    }

    public final /* synthetic */ void showInstruction(String a2, int a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.getClient().sendPacket(MaplePacketCreator.sendHint(a2, a3, a4));
    }

    public final /* synthetic */ void channelMapPlayerAllBuuff() {
        AbstractPlayerInteraction a2;
        for (MapleCharacter mapleCharacter : a2.getClient().getPlayer().getMap().getCharactersThreadsafe()) {
            if (mapleCharacter == null || mapleCharacter.isGM()) continue;
            mapleCharacter.cancelAllBuffs();
        }
    }

    public /* synthetic */ int getReqLevel(int a2) {
        return MapleItemInformationProvider.getInstance().getReqLevel(a2);
    }

    public final /* synthetic */ boolean haveItem(int a2) {
        AbstractPlayerInteraction a3;
        return a3.haveItem(a2, 1);
    }

    public final /* synthetic */ boolean haveSkill(int a22, byte a3) {
        AbstractPlayerInteraction a4;
        ISkill a22 = SkillFactory.getSkill(a22);
        return a4.getPlayer().getSkillLevel(a22) >= a3;
    }

    public /* synthetic */ void reloadEquip(IEquip a2) {
        AbstractPlayerInteraction a3;
        ArrayList<ModifyInventory> arrayList = new ArrayList<ModifyInventory>();
        arrayList.add(new ModifyInventory(3, a2));
        arrayList.add(new ModifyInventory(0, a2));
        a3.ALLATORIxDEMO.sendPacket(MaplePacketCreator.modifyInventory(true, arrayList));
    }

    public final /* synthetic */ int getSkillByJob(int a2, int a3) {
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

    public /* synthetic */ DruidPooledConnection getConnection() throws SQLException {
        return DBConPool.getInstance().getDataSource().getConnection();
    }

    public final /* synthetic */ void gainItemS(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, MapleClient a18, long a19) {
        AbstractPlayerInteraction a20;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            Object object2 = GameConstants.getInventoryType(a2);
            if (!GameSetConstants.STORAGE_EXCEED && !MapleInventoryManipulator.checkSpace(a18, a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a20.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a20.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (((Enum)object2).equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                object2 = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                object = ((MapleItemInformationProvider)object).getName(a2);
                if (a2 / 10000 == 114 && object != null && ((String)object).length() > 0) {
                    object = "\u4f60\u5df2\u7372\u5f97\u7a31\u865f <" + (String)object + ">";
                    MapleClient mapleClient = a18;
                    mapleClient.getPlayer().dropMessage(-1, (String)object);
                    mapleClient.getPlayer().dropMessage(5, (String)object);
                }
                if (a19 >= 0L) {
                    ((Item)object2).setExpiration(System.currentTimeMillis() + a19 * 60L * 60L * 1000L);
                }
                if (a4 >= 0) {
                    ((Equip)object2).setStr((short)a4);
                }
                if (a5 >= 0) {
                    ((Equip)object2).setDex((short)a5);
                }
                if (a6 >= 0) {
                    ((Equip)object2).setLuk((short)a6);
                }
                if (a7 >= 0) {
                    ((Equip)object2).setInt((short)a7);
                }
                if (a8 >= 0) {
                    ((Equip)object2).setHp((short)a8);
                }
                if (a9 >= 0) {
                    ((Equip)object2).setMp((short)a9);
                }
                if (a10 >= 0) {
                    ((Equip)object2).setWatk((short)a10);
                }
                if (a11 >= 0) {
                    ((Equip)object2).setMatk((short)a11);
                }
                if (a12 >= 0) {
                    ((Equip)object2).setWdef((short)a12);
                }
                if (a13 >= 0) {
                    ((Equip)object2).setMdef((short)a13);
                }
                if (a14 >= 0) {
                    ((Equip)object2).setAvoid((short)a14);
                }
                if (a15 >= 0) {
                    ((Equip)object2).setAcc((short)a15);
                }
                if (a16 >= 0) {
                    ((Equip)object2).setJump((short)a16);
                }
                if (a17 >= 0) {
                    ((Equip)object2).setSpeed((short)a17);
                }
                MapleInventoryManipulator.addbyItem(a18, ((Equip)object2).copy());
            } else {
                MapleInventoryManipulator.addById(a18, a2, a3, "");
            }
        } else {
            if (!a20.getPlayer().haveItem(a2, Math.abs(a3))) {
                FileoutputUtil.logToFile_NpcScript_Bug(a20.getPlayer(), " \u542b\u6709 \u6263\u9664\u4e0d\u5b58\u5728\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "] \u4e4b\u6f0f\u6d1e\r\n");
                a20.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleInventoryManipulator.removeById(a18, GameConstants.getInventoryType(a2), a2, -a3, true, false);
        }
        a18.sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public final /* synthetic */ boolean gainRestricted(int a2) {
        AbstractPlayerInteraction a3;
        return (!MapleItemInformationProvider.getInstance().isPickupRestricted(a2) || !a3.ALLATORIxDEMO.getPlayer().haveItem(a2, true ? (byte)1 : 0, true, false)) && MapleItemInformationProvider.getInstance().itemExists(a2);
    }

    public /* synthetic */ AbstractPlayerInteraction(MapleClient a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ int getCurrentPartyId(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getMap(a2).getCurrentPartyId();
    }

    public final /* synthetic */ void useItem(int a2) {
        AbstractPlayerInteraction a3;
        MapleItemInformationProvider.getInstance().getItemEffect(a2).applyTo(a3.ALLATORIxDEMO.getPlayer());
        a3.getClient().sendPacket(UIPacket.getStatusMsg(a2));
    }

    public final /* synthetic */ void forceStartQuest(int a2, int a3, String a4) {
        AbstractPlayerInteraction a5;
        MapleQuest.getInstance(a2).forceStart(a5.ALLATORIxDEMO.getPlayer(), a3, a4);
    }

    public final /* synthetic */ void warp(int a22, int a3) {
        AbstractPlayerInteraction a4;
        MapleMap mapleMap = a4.ALLATORIxDEMO(a22);
        if (a3 != 0 && a22 == a4.getClient().getPlayer().getMapId()) {
            Point point;
            Point a22 = new Point(a4.ALLATORIxDEMO.getPlayer().getMap().getPortal(a3).getPosition());
            if (point.distanceSq(a4.getPlayer().getPosition()) < 90000.0) {
                AbstractPlayerInteraction abstractPlayerInteraction = a4;
                abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.instantMapWarp((byte)a3));
                abstractPlayerInteraction.getClient().getPlayer().checkFollow();
                abstractPlayerInteraction.getClient().getPlayer().getMap().movePlayer(a4.ALLATORIxDEMO.getPlayer(), a22);
                return;
            }
            MapleMap mapleMap2 = mapleMap;
            a4.getClient().getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(a3));
            return;
        }
        MapleMap mapleMap3 = mapleMap;
        a4.getClient().getPlayer().changeMap(mapleMap3, mapleMap3.getPortal(a3));
    }

    public /* synthetic */ void sendMoveScreen(int a2, int a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.ALLATORIxDEMO.sendPacket(UIPacket.MoveScreen(a2, a3, a4));
    }

    public /* synthetic */ boolean UseCube(MapleClient a2, int a3, int a4) {
        if (InventoryHandler.useCube(a2, a3, a4)) {
            a2.getPlayer().gainItem(a4, -1);
            return true;
        }
        return false;
    }

    public final /* synthetic */ void killMob(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().getMap().killMonster(a2);
    }

    public final /* synthetic */ void useSkill(int a2, int a3) {
        AbstractPlayerInteraction a4;
        if (a3 <= 0) {
            return;
        }
        SkillFactory.getSkill(a2).getEffect(a3).applyTo(a4.ALLATORIxDEMO.getPlayer());
    }

    public final /* synthetic */ void gainItemPeriod(int a2, short a3, long a4, String a5) {
        AbstractPlayerInteraction a6;
        a6.gainItem(a2, a3, true, a4, -1, a5);
    }

    public /* synthetic */ String getQuestCustomData(int a2) {
        AbstractPlayerInteraction a3;
        return a3.ALLATORIxDEMO.getPlayer().getQuestNAdd(MapleQuest.getInstance(a2)).getCustomData();
    }

    public final /* synthetic */ void givePartyPoints(int a2) {
        Iterator<MaplePartyCharacter> iterator;
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getParty() == null) {
            a3.getPlayer().gainPoints(a2);
            return;
        }
        Iterator<MaplePartyCharacter> iterator2 = iterator = a3.getPlayer().getParty().getMembers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getChr().gainPoints(a2);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void openNpc(int a2, String a3) {
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        abstractPlayerInteraction.openNpc(abstractPlayerInteraction.getClient(), a2, a3);
    }

    public /* synthetic */ short getSpace(byte a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().getSpace(a2);
    }

    public /* synthetic */ MapleInventoryType getInvType(int a2) {
        return MapleInventoryType.getByType((byte)a2);
    }

    public final /* synthetic */ boolean isQuestCompleted(int a2) {
        AbstractPlayerInteraction a3;
        return a3.isQuestFinished(a2);
    }

    public /* synthetic */ int getMapBossLog(String a2) {
        AbstractPlayerInteraction a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getMap() != null) {
            Iterator<MapleCharacter> iterator;
            Iterator<MapleCharacter> iterator2 = iterator = a3.getMap().getAllPlayersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                MapleCharacter mapleCharacter = iterator.next();
                iterator2 = iterator;
                arrayList.add(mapleCharacter.getBossLog(a2));
            }
        } else {
            return a3.getBossLog(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public /* synthetic */ OverrideMonsterStats newMonsterStats() {
        return new OverrideMonsterStats();
    }

    public final /* synthetic */ void gainItem(int a2, short a3, boolean a4) {
        AbstractPlayerInteraction a5;
        a5.gainItem(a2, a3, a4, 0L, -1, "");
    }

    public final /* synthetic */ void teachSkill(int a2, byte a3, byte a4, byte a5) {
        AbstractPlayerInteraction a6;
        if (SkillFactory.getSkill(a2) == null) {
            FileoutputUtil.logToFile_NpcScript_Bug(a6.getPlayer(), " \u542b\u6709\u5b78\u7fd2\u6280\u80fd[" + a2 + "]\u4e0d\u5b58\u5728\u4e4b\u6f0f\u6d1e\r\n");
            return;
        }
        a6.getPlayer().changeSkillLevel(a2, (int)a3, a4, a5);
    }

    public final /* synthetic */ int cm() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getMapId();
    }

    public /* synthetic */ void playSoundEffect(String a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(MaplePacketCreator.playVoiceEffect(a2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void gainPet(int a22, String a3, int a4, int a5, int a6, long a7, short a8) {
        if (a22 > 5010000 || a22 < 5000000) {
            a22 = 5000000;
        }
        if (a4 > 30) {
            a4 = 30;
        }
        if (a5 > 30000) {
            a5 = 30000;
        }
        if (a6 > 100) {
            a6 = 100;
        }
        try {
            AbstractPlayerInteraction a9;
            short s2;
            int n2;
            int n3 = a22;
            int n4 = MapleInventoryIdentifierPet.getInstance();
            if (a22 == 5000054) {
                n2 = (int)a7;
                s2 = a8;
            } else {
                n2 = 0;
                s2 = a8;
            }
            MapleInventoryManipulator.addById(a9.ALLATORIxDEMO, n3, (short)1, "", MaplePet.createPet(n3, a3, a4, a5, a6, n4, n2, s2), 45L);
            return;
        }
        catch (NullPointerException a22) {
            a22.printStackTrace();
            return;
        }
    }

    public final /* synthetic */ void midMsg(String a2) {
        AbstractPlayerInteraction a3;
        a3.getMidMsg(a2, true, 0);
    }

    public /* synthetic */ void gainExpR(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().gainExp((int)((double)a2 * a3.getClient().getChannelServer().getExpRate(a3.ALLATORIxDEMO.getPlayer().getWorld(), a3.ALLATORIxDEMO.getPlayer())), true, true, true);
    }

    public /* synthetic */ void playVoiceEffect(String a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(MaplePacketCreator.playVoiceEffect(a2));
    }

    public final /* synthetic */ void gainItem(int a2, short a3, boolean a42, long a5, int a6, String a7, MapleClient a8, int a9) {
        AbstractPlayerInteraction a10;
        if (a3 >= 0) {
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            Object object = GameConstants.getInventoryType(a2);
            if (!GameSetConstants.STORAGE_EXCEED && !MapleInventoryManipulator.checkSpace(a8, a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a10.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a10.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (((Enum)object).equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                IItem iItem;
                if (a42) {
                    MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
                    iItem = mapleItemInformationProvider2.randomizeStats((Equip)mapleItemInformationProvider2.getEquipById(a2));
                } else {
                    iItem = mapleItemInformationProvider.getEquipById(a2);
                }
                object = (Equip)iItem;
                if (a9 != 0) {
                    ((Item)object).setCustomFlag(a9);
                }
                if (a5 > 0L) {
                    ((Item)object).setExpiration(System.currentTimeMillis() + a5 * 24L * 60L * 60L * 1000L);
                }
                if (a6 > 0) {
                    Object object2 = object;
                    ((Equip)object2).setUpgradeSlots((byte)(((Equip)object2).getUpgradeSlots() + a6));
                }
                if (a7 != null) {
                    ((Item)object).setOwner(a7);
                }
                Object a42 = mapleItemInformationProvider.getName(a2);
                if (a2 / 10000 == 114 && a42 != null && ((String)a42).length() > 0) {
                    a42 = "\u4f60\u5df2\u7372\u5f97\u7a31\u865f <" + (String)a42 + ">";
                    MapleClient mapleClient = a8;
                    mapleClient.getPlayer().dropMessage(-1, (String)a42);
                    mapleClient.getPlayer().dropMessage(5, (String)a42);
                }
                MapleInventoryManipulator.addbyItem(a8, ((Equip)object).copy());
            } else {
                Object object3;
                String string;
                MapleClient mapleClient;
                if (ItemConstants.\u985e\u578b.\u5bf5\u7269((int)a2)) {
                    object = MaplePet.createPet(a2, MapleInventoryIdentifierPet.getInstance());
                    mapleClient = a8;
                } else {
                    object = null;
                    mapleClient = a8;
                }
                if (a7 == null) {
                    string = "";
                    object3 = object;
                } else {
                    string = a7;
                    object3 = object;
                }
                MapleInventoryManipulator.addById(mapleClient, a2, a3, string, (MaplePet)object3, a5);
            }
        } else {
            if (!a10.getPlayer().haveItem(a2, Math.abs(a3))) {
                FileoutputUtil.logToFile_NpcScript_Bug(a10.getPlayer(), " \u542b\u6709 \u6263\u9664\u4e0d\u5b58\u5728\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "] \u4e4b\u6f0f\u6d1e\r\n");
                a10.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleInventoryManipulator.removeById(a8, GameConstants.getInventoryType(a2), a2, -a3, true, false);
        }
        a8.sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public final /* synthetic */ void killAllMob() {
        AbstractPlayerInteraction a2;
        a2.getClient().getPlayer().getMap().killAllMonsters(true);
    }

    public final /* synthetic */ int getMonsterCount(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getChannelServer().getMapFactory().getMap(a2).getNumMonsters();
    }

    public /* synthetic */ void addPartyTrait(String a2, int a3, List<MapleCharacter> a4) {
        Object object = a4 = a4.iterator();
        while (object.hasNext()) {
            MapleCharacter mapleCharacter = (MapleCharacter)a4.next();
            object = a4;
            mapleCharacter.getTrait(MapleTrait.MapleTraitType.valueOf(a2)).addExp(a3, mapleCharacter);
        }
    }

    public /* synthetic */ void lockUI(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().sendPacket(UIPacket.IntroEnableUI(a2, a3));
    }

    public /* synthetic */ String getMapName(int a2) {
        return MapleItemInformationProvider.getInstance().getMapName(a2);
    }

    public static /* synthetic */ boolean faceExists(int a2) {
        return MapleItemInformationProvider.getInstance().itemExists(a2);
    }

    public final /* synthetic */ void playPortalSE() {
        AbstractPlayerInteraction a2;
        a2.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(0, SpecialEffect.MULUNG_DOJO_UP.getValue(), 1, 1));
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean haveNamePrize(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

    public final /* synthetic */ void warp(int a2, String a3) {
        AbstractPlayerInteraction a4;
        MapleMap mapleMap = a4.ALLATORIxDEMO(a2);
        if (a2 == 109060000 || a2 == 109060002 || a2 == 109060004) {
            a3 = mapleMap.getSnowballPortal();
        }
        if (a2 == a4.getClient().getPlayer().getMapId()) {
            Point point = new Point(a4.ALLATORIxDEMO.getPlayer().getMap().getPortal(a3).getPosition());
            if (point.distanceSq(a4.getPlayer().getPosition()) < 90000.0) {
                AbstractPlayerInteraction abstractPlayerInteraction = a4;
                abstractPlayerInteraction.getClient().getPlayer().checkFollow();
                AbstractPlayerInteraction abstractPlayerInteraction2 = a4;
                abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.instantMapWarp((byte)abstractPlayerInteraction2.getClient().getPlayer().getMap().getPortal(a3).getId()));
                abstractPlayerInteraction2.getClient().getPlayer().getMap().movePlayer(a4.ALLATORIxDEMO.getPlayer(), new Point(a4.ALLATORIxDEMO.getPlayer().getMap().getPortal(a3).getPosition()));
                return;
            }
            MapleMap mapleMap2 = mapleMap;
            a4.getClient().getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(a3));
            return;
        }
        MapleMap mapleMap3 = mapleMap;
        a4.getClient().getPlayer().changeMap(mapleMap3, mapleMap3.getPortal(a3));
    }

    public /* synthetic */ void setMapBossLog(String a2) {
        AbstractPlayerInteraction a3;
        Iterator<MapleCharacter> iterator;
        Iterator<MapleCharacter> iterator2 = iterator = a3.getMap().getAllPlayersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            iterator.next().setBossLog(a2);
            iterator2 = iterator;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void deleteNamePrizeLog(String a) {
        var2_2 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var4_4 = var2_2.prepareStatement(SyncServerData.ALLATORIxDEMO("\u0011o\u0019o\u0001oUl\u0007e\u0018*\u001bk\u0018o\u0005x\u001cp\u0010f\u001amU}\u001do\u0007oUd\u0014g\u0010*H*J*\u0014d\u0011*\u0013\u007f\u001bi\u0001c\u001adU7U5"));
            v0.setString(1, a.ALLATORIxDEMO.getPlayer().getName());
            var4_4.setString(2, a);
            v0.execute();
            var4_4.close();
            ** if (var2_2 == null) goto lbl-1000
        }
        catch (Throwable var3_6) {
            if (var2_2 == null) ** GOTO lbl24
            try {
                var2_2.close();
                v1 = var3_6;
                ** GOTO lbl25
            }
            catch (Throwable var4_5) {
                try {
                    var3_6.addSuppressed(var4_5);
lbl24:
                    // 2 sources

                    v1 = var3_6;
lbl25:
                    // 2 sources

                    throw v1;
                }
                catch (Exception var2_3) {
                    // empty catch block
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_2.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public final /* synthetic */ void gainPotion(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().getPlayer().modifyCSPoints(a2, a3, true);
    }

    public /* synthetic */ void spawnMonster(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.ALLATORIxDEMO(a2, a3, new Point(a4.ALLATORIxDEMO.getPlayer().getPosition()));
    }

    public final /* synthetic */ MapleParty getParty() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getParty();
    }

    public final /* synthetic */ void gainExp_PQ(int a2, double a3) {
        AbstractPlayerInteraction a4;
        a2 = (int)Math.round((double)GameConstants.getExpNeededForLevel(a4.getPlayer().getLevel() > a2 ? a2 + a4.getPlayer().getLevel() / 10 : a4.getPlayer().getLevel()) / ((double)Math.min(a4.getPlayer().getLevel(), a2) / 10.0) / a3);
        a4.gainExp(a2);
    }

    public final /* synthetic */ void openNpc(int a2) {
        AbstractPlayerInteraction a3;
        a3.openNpc(a2, null);
    }

    public final /* synthetic */ void warp(int a22) {
        AbstractPlayerInteraction a3;
        MapleMap a22 = a3.ALLATORIxDEMO(a22);
        try {
            MapleMap mapleMap = a22;
            a3.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(Randomizer.nextInt(mapleMap.getPortals().size())));
            return;
        }
        catch (Exception exception) {
            MapleMap mapleMap = a22;
            a3.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(0));
            return;
        }
    }

    public /* synthetic */ void trembleEffect(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.ALLATORIxDEMO.sendPacket(MaplePacketCreator.trembleEffect(a2, a3));
    }

    public static /* synthetic */ boolean hairExists(int a2) {
        return MapleItemInformationProvider.getInstance().itemExists(a2);
    }

    public final /* synthetic */ void gainItemPeriod(int a2, short a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.gainItem(a2, a3, true, a4, -1, "");
    }

    public final /* synthetic */ void gainItem(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, long a18, String a19) {
        AbstractPlayerInteraction a20;
        a20.gainItemS(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, -1, a20.ALLATORIxDEMO, a18, a19);
    }

    public /* synthetic */ int getVersion() {
        return GameSetConstants.MAPLE_VERSION;
    }

    public /* synthetic */ void EnableUI(short a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.IntroEnableUI(a2));
    }

    public /* synthetic */ void removeSlot(int a2, byte a3, short a4) {
        AbstractPlayerInteraction a5;
        MapleInventoryManipulator.removeFromSlot(a5.ALLATORIxDEMO, a5.getInvType(a2), a3, a4, true);
    }

    public final /* synthetic */ byte getQuestStatus(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getPlayer().getQuestStatus(a2);
    }

    public final /* synthetic */ void gainItem(int a2, short a3, boolean a4, int a5) {
        AbstractPlayerInteraction a6;
        a6.gainItem(a2, a3, a4, 0L, a5, "");
    }

    public /* synthetic */ int save(boolean a22, boolean a3) {
        try {
            AbstractPlayerInteraction a4;
            return a4.getPlayer().saveToDB(a22, a3);
        }
        catch (UnsupportedOperationException a22) {
            return 0;
        }
    }

    public final /* synthetic */ MapleEvent getEvent(String a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getChannelServer().getEvent(MapleEventType.valueOf(a2));
    }

    public /* synthetic */ void spawnMonster(MapleMonster a2, int a3) {
        AbstractPlayerInteraction a4;
        if (a2 != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a4.getMap().spawnMonster(a2);
                n3 = ++n2;
            }
        } else if (a4.getPlayer() != null && a4.getPlayer().isStaff()) {
            a4.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2.getId() + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a4.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2.getId() + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 3 << 1;
        int cfr_ignored_0 = 5 << 4;
        int n5 = n3;
        char c2 = '\u0001';
        while (n5 >= 0) {
            int n6 = n3--;
            arrc[n6] = (char)(a2.charAt(n6) ^ c2);
            if (n3 < 0) break;
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public final /* synthetic */ void MovieClipIntroUI(boolean a2) {
        AbstractPlayerInteraction a3;
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.IntroDisableUI(a2));
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.IntroLock(a2));
    }

    public final /* synthetic */ void worldMessage(int a2, String a3) {
        World.Broadcast.broadcastMessage(MaplePacketCreator.broadcastMessage(a2, a3));
    }

    public /* synthetic */ void gainExp(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().gainExp(a2, true, true, true);
    }

    public final /* synthetic */ void spawnNpc(int a2, Point a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().getPlayer().getMap().spawnNpc(a2, a3);
    }

    public /* synthetic */ int getTrueJobGrade() {
        AbstractPlayerInteraction a2;
        return MapleJob.getTrueJobGrade(a2.getPlayer().getJob());
    }

    public final /* synthetic */ int getMaplePoint() {
        AbstractPlayerInteraction a2;
        return a2.getPotion(2);
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, int a3, Point a4, long a5) {
        AbstractPlayerInteraction a6;
        MapleMonster mapleMonster = MapleLifeFactory.getMonster(a2);
        if (mapleMonster != null) {
            int n2;
            OverrideMonsterStats overrideMonsterStats = new OverrideMonsterStats(a5, mapleMonster.getMobMaxMp(), mapleMonster.getMobExp(), false);
            MapleMonster mapleMonster2 = mapleMonster;
            mapleMonster2.setHp(a5);
            mapleMonster2.setOverrideStats(overrideMonsterStats);
            int n3 = n2 = 0;
            while (n3 < a3) {
                a6.getClient().getPlayer().getMap().spawnMonsterOnGroundBelow(mapleMonster, a4);
                n3 = ++n2;
            }
        } else if (a6.getPlayer() != null && a6.getPlayer().isStaff()) {
            a6.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a6.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public /* synthetic */ void spawnDragon(int a2) {
        AbstractPlayerInteraction a3;
        MapleMonster mapleMonster;
        MapleMonster mapleMonster2 = mapleMonster = MapleLifeFactory.getMonster(8810026);
        mapleMonster2.setspawnRevivesHpRate(a2);
        a3.spawnMonster(mapleMonster2, 1, new Point(71, 260));
    }

    public final /* synthetic */ boolean allMembersHere() {
        AbstractPlayerInteraction a2;
        if (a2.ALLATORIxDEMO.getPlayer().getParty() == null) {
            return false;
        }
        for (MaplePartyCharacter maplePartyCharacter : a2.getClient().getPlayer().getParty().getMembers()) {
            if (a2.getClient().getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) != null) continue;
            return false;
        }
        return true;
    }

    public final /* synthetic */ void gainItemFlag(int a2, short a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.gainItem(a2, a3, false, -1L, -1, "", a5.ALLATORIxDEMO, a4);
    }

    public final /* synthetic */ void warpMap(int a22, int a3) {
        Iterator<MapleCharacter> iterator;
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleMap a22 = abstractPlayerInteraction.getMap(a22);
        Iterator<MapleCharacter> iterator2 = iterator = abstractPlayerInteraction.getClient().getPlayer().getMap().getCharactersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            MapleMap mapleMap = a22;
            iterator.next().changeMap(mapleMap, mapleMap.getPortal(a3));
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void summonMsg(String a2) {
        AbstractPlayerInteraction a3;
        if (!a3.ALLATORIxDEMO.getPlayer().hasSummon()) {
            a3.playerSummonHint(true);
        }
        a3.getClient().sendPacket(UIPacket.summonMessage(a2));
    }

    public /* synthetic */ void showEnvironment(int a2, String a3, int[] a4) {
        AbstractPlayerInteraction a5;
        a5.showEnvironment(false, a2, a3, a4);
    }

    public /* synthetic */ void lockUI(boolean a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.IntroEnableUI(a2));
    }

    public final /* synthetic */ void warpGuildMap(int a2) {
        AbstractPlayerInteraction a3;
        a3.warpGuildMap(a2, false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void sendPQreward() {
        v0 = a;
        var1_1 = v0.getClient().getChannel();
        var2_2 = v0.getPlayer().getMapId();
        var3_3 = v0.getPlayer().getParty();
        if (var3_3 == null) {
            return;
        }
        if (!a.getPlayer().isLeader()) {
            return;
        }
        var3_3 = var3_3.getOnlineMembers().iterator();
        block0: while (true) lbl-1000:
        // 3 sources

        {
            v1 = var3_3;
            while (v1.hasNext() != false) {
                var4_4 = (MaplePartyCharacter)var3_3.next();
                if (var4_4.getChr() == null) ** GOTO lbl-1000
                if (var4_4.getChr().getClient() == null) {
                    v1 = var3_3;
                    continue;
                }
                if (var4_4.getChr().getMapId() != var2_2) continue block0;
                if (var4_4.getChannel() != var1_1) {
                    v1 = var3_3;
                    continue;
                }
                v2 = var4_4;
                v2.getChr().setPQrewardUI(true);
                v2.getChr().getClient().sendPacket(MaplePacketCreator.showPQRewardUI(var4_4.getId()));
                v1 = var3_3;
            }
            return;
        }
    }

    public /* synthetic */ void setMP(int a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().setMP(a2);
    }

    public final /* synthetic */ void removeNpc(int a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.getPlayer().getMap().removeNpc(a2);
    }

    public /* synthetic */ void enterMTS() {
        AbstractPlayerInteraction a2;
        AbstractPlayerInteraction abstractPlayerInteraction = a2;
        InterServerHandler.EnterMTS(abstractPlayerInteraction.ALLATORIxDEMO, abstractPlayerInteraction.ALLATORIxDEMO.getPlayer());
    }

    public final /* synthetic */ void evanTutorial(String a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().sendPacket(MaplePacketCreator.getEvanTutorial(a2));
    }

    public /* synthetic */ void setEventCount(String a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().setEventCount(a2);
    }

    public final /* synthetic */ void warpParty(int a222, int a3) {
        AbstractPlayerInteraction a4;
        if (a4.getPlayer().getParty() == null || a4.getPlayer().getParty().getMembers().size() == 1) {
            if (a3 < 0) {
                a4.warp(a222);
                return;
            }
            a4.warp(a222, a3);
            return;
        }
        boolean bl = a3 < 0;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleMap a222 = abstractPlayerInteraction.getMap(a222);
        int n2 = abstractPlayerInteraction.getPlayer().getMapId();
        for (MaplePartyCharacter maplePartyCharacter : abstractPlayerInteraction.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a4.getChannelServer().getPlayerStorage().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null || serializable.getMapId() != n2 && serializable.getEventInstance() != a4.getPlayer().getEventInstance()) continue;
            if (bl) {
                try {
                    MapleMap mapleMap = a222;
                    serializable.changeMap(mapleMap, mapleMap.getPortal(Randomizer.nextInt(mapleMap.getPortals().size())));
                }
                catch (Exception exception) {
                    MapleMap mapleMap = a222;
                    serializable.changeMap(mapleMap, mapleMap.getPortal(0));
                }
                continue;
            }
            MapleMap mapleMap = a222;
            serializable.changeMap(mapleMap, mapleMap.getPortal(a3));
        }
    }

    public final /* synthetic */ void givePartyItems(int a2, short a3) {
        Iterator<MaplePartyCharacter> iterator;
        AbstractPlayerInteraction a4;
        if (a4.getPlayer().getParty() == null) {
            a4.getPlayer().gainItem(a2, a3);
            return;
        }
        Iterator<MaplePartyCharacter> iterator2 = iterator = a4.getPlayer().getParty().getMembers().iterator();
        while (iterator2.hasNext()) {
            iterator.next().getChr().gainItem(a2, a3);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void warpS(int a2, String a3) {
        AbstractPlayerInteraction a4;
        MapleMap mapleMap = a4.ALLATORIxDEMO(a2);
        if (a2 == 109060000 || a2 == 109060002 || a2 == 109060004) {
            a3 = mapleMap.getSnowballPortal();
        }
        MapleMap mapleMap2 = mapleMap;
        a4.getClient().getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(a3));
    }

    public /* synthetic */ Point getPoint(int a2, int a3) {
        return new Point(a2, a3);
    }

    public final /* synthetic */ String getName() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getName();
    }

    public /* synthetic */ void givePartyExp_PQ(int a2, double a3) {
        AbstractPlayerInteraction a4;
        if (a4.getPlayer().getParty() == null || a4.getPlayer().getParty().getMembers().size() == 1) {
            int n2 = (int)Math.round((double)GameConstants.getExpNeededForLevel(a4.getPlayer().getLevel() > a2 ? a2 + a4.getPlayer().getLevel() / 10 : a4.getPlayer().getLevel()) / ((double)Math.min(a4.getPlayer().getLevel(), a2) / 10.0) / a3);
            a4.gainExp(n2);
            return;
        }
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        int n3 = abstractPlayerInteraction.getPlayer().getMapId();
        for (MaplePartyCharacter maplePartyCharacter : abstractPlayerInteraction.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a4.getChannelServer().getPlayerStorage().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null || serializable.getMapId() != n3 && serializable.getEventInstance() != a4.getPlayer().getEventInstance()) continue;
            int n2 = (int)Math.round((double)GameConstants.getExpNeededForLevel(serializable.getLevel() > a2 ? a2 + serializable.getLevel() / 10 : serializable.getLevel()) / ((double)Math.min(serializable.getLevel(), a2) / 10.0) / a3);
            serializable.gainExp(n2, true, true, true);
        }
    }

    public /* synthetic */ boolean hasSquadByMap() {
        AbstractPlayerInteraction a2;
        return a2.getPlayer().getMap().getSquadByMap() != null;
    }

    public /* synthetic */ void setServerSet(String a2, int a3) {
        ServerSet.setServerSet(a2, a3);
    }

    public final /* synthetic */ void gainItem(int a2, short a3, boolean a4, long a5, int a6, String a7, MapleClient a8) {
        AbstractPlayerInteraction a9;
        a9.gainItem(a2, a3, a4, a5, a6, a7, a8, 0);
    }

    public final /* synthetic */ void saveReturnLocation(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().saveLocation(SavedLocationType.fromString(a2), a3.getClient().getPlayer().getMap().getReturnMap().getId());
    }

    public final /* synthetic */ int getChannelNumber() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getChannel();
    }

    public /* synthetic */ void sendDirectionInfo(String a2) {
        AbstractPlayerInteraction a3;
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.getDirectionInfo(a2, 2000, 0, -100, 0));
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.getDirectionInfo(1, 2000));
    }

    public final /* synthetic */ void forceStartReactor(int a22, int a3) {
        AbstractPlayerInteraction a4;
        Iterator<MapleReactor> iterator = a4.getClient().getChannelServer().getMapFactory().getMap(a22).getAllReactorsThreadsafe().iterator();
        while (iterator.hasNext()) {
            MapleReactor a22 = (MapleReactor)((MapleMapObject)iterator.next());
            if (a22.getReactorId() != a3) continue;
            a22.forceStartReactor(a4.ALLATORIxDEMO);
            return;
        }
    }

    public final /* synthetic */ boolean isLeader() {
        AbstractPlayerInteraction a2;
        if (a2.getParty() == null) {
            return false;
        }
        return a2.getParty().getLeader().getId() == a2.getClient().getPlayer().getId();
    }

    public final /* synthetic */ void saveLocation(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().saveLocation(SavedLocationType.fromString(a2));
    }

    public /* synthetic */ int itemQuantity(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().itemQuantity(a2);
    }

    public final /* synthetic */ void gainTimeItem(int a2, short a3, short a4, int a5) {
        AbstractPlayerInteraction a6;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a2);
            if (!MapleInventoryManipulator.checkSpace(a6.getClient(), a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a6.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a6.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (mapleInventoryType.equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                object = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                if (a5 > 0) {
                    ((Item)object).setExpiration(System.currentTimeMillis() + (long)(a5 * 60 * 1000));
                }
                if (a4 > 0) {
                    ((Equip)object).setInt(a4);
                }
                MapleInventoryManipulator.addbyItem(a6.getClient(), ((Equip)object).copy());
            }
        }
        a6.getClient().sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public /* synthetic */ boolean checkSlot(MapleCharacter a2, int[] a3) {
        int n2;
        short s2 = 0;
        int n3 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n4 = a3.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            AbstractPlayerInteraction a4;
            int n6 = a3[n2];
            if (!a4.canHold(n6, 1)) {
                return false;
            }
            switch (2.ALLATORIxDEMO[GameConstants.getInventoryType(n6).ordinal()]) {
                case 1: {
                    ++s2;
                    while (false) {
                    }
                    break;
                }
                case 2: {
                    arrayList.add(n6);
                    break;
                }
                case 3: {
                    ++s3;
                    break;
                }
                case 4: {
                    ++s4;
                    break;
                }
                case 5: {
                    ++s5;
                }
            }
            n5 = ++n2;
        }
        int[] arrn = new int[3];
        arrn[0] = 2022179;
        arrn[1] = 2450000;
        arrn[2] = 0x225511;
        a3 = arrn;
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n7 = n2 = 0;
        while (n7 < a3.length) {
            if (arrayList.contains(a3[n2]) && !arrayList2.contains(a3[n2])) {
                ++n3;
                arrayList2.add(a3[n2]);
            }
            n7 = ++n2;
        }
        return a2.getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() >= s2 && a2.getInventory(MapleInventoryType.USE).getNumFreeSlot() >= n3 && a2.getInventory(MapleInventoryType.SETUP).getNumFreeSlot() >= s3 && a2.getInventory(MapleInventoryType.ETC).getNumFreeSlot() >= s4 && a2.getInventory(MapleInventoryType.CASH).getNumFreeSlot() >= s5;
    }

    public final /* synthetic */ MapleMap getMap() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getMap();
    }

    public /* synthetic */ boolean isQuestStarted(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getQuestStatus(a2) == 1;
    }

    public final /* synthetic */ int getPlayerStat(String a2) {
        AbstractPlayerInteraction a3;
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u0010\u0006\u0010"))) {
            return a3.getClient().getPlayer().getLevel();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("Y!X"))) {
            return a3.getClient().getPlayer().getStat().getStr();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u0018\u0015\u0004"))) {
            return a3.getClient().getPlayer().getStat().getDex();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("C;^"))) {
            return a3.getClient().getPlayer().getStat().getInt();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u0010\u0005\u0017"))) {
            return a3.getClient().getPlayer().getStat().getLuk();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("=Z"))) {
            return a3.getClient().getPlayer().getStat().getHp();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u001d\f"))) {
            return a3.getClient().getPlayer().getStat().getMp();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("G4R=Z"))) {
            return a3.getClient().getPlayer().getStat().getMaxHp();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u0011\u0011\u0004\u001d\f"))) {
            return a3.getClient().getPlayer().getStat().getMaxMp();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("X4Z"))) {
            return a3.getClient().getPlayer().getRemainingAp();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u000e\u0003\f"))) {
            return a3.getClient().getPlayer().getRemainingSp();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("M<N"))) {
            return a3.getClient().getPlayer().getGuildId();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u001b\u0002\u001d\u001e\u0017"))) {
            return a3.getClient().getPlayer().getGuildRank();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("K'K;A"))) {
            return a3.getClient().getPlayer().getAllianceRank();
        }
        if (a2.equals("GM")) {
            if (a3.getClient().getPlayer().isGM()) {
                return 1;
            }
            return 0;
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u001d\u0014\u0011\u0019\u0012"))) {
            if (a3.getClient().getPlayer().hasGmLevel(5)) {
                return 1;
            }
            return 0;
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("2O;N0X"))) {
            return a3.getClient().getPlayer().getGender();
        }
        if (a2.equals(MapleFoothold.ALLATORIxDEMO("\u0016\u001d\u0013\u0019"))) {
            return a3.getClient().getPlayer().getFace();
        }
        if (a2.equals(SyncServerData.ALLATORIxDEMO("=K<X"))) {
            return a3.getClient().getPlayer().getHair();
        }
        return -1;
    }

    public final /* synthetic */ void setQuestInfo(int a22, String a3) {
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleQuestStatus a22 = abstractPlayerInteraction.getPlayer().getQuestNAdd(MapleQuest.getInstance(a22));
        a22.setCustomData(a3);
        abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.updateQuest(a22));
    }

    public final /* synthetic */ void openNpc(MapleClient a2, int a3, String a4) {
        a2.removeClickedNPC();
        NPCScriptManager.getInstance().start(a2, a3, false ? (byte)1 : 0, a4, false);
    }

    public /* synthetic */ boolean isAllReactorState(int a2, int a3) {
        AbstractPlayerInteraction a4;
        boolean bl = false;
        for (MapleReactor mapleReactor : a4.getMap().getAllReactorsThreadsafe()) {
            if (mapleReactor.getReactorId() != a2) continue;
            bl = mapleReactor.getState() == a3;
        }
        return bl;
    }

    public /* synthetic */ boolean hasEMByMap() {
        AbstractPlayerInteraction a2;
        return a2.getPlayer().getMap().getEMByMap() != null;
    }

    public final /* synthetic */ void Aran_Start() {
        AbstractPlayerInteraction a2;
        a2.getClient().sendPacket(UIPacket.Aran_Start());
    }

    public final /* synthetic */ boolean getEvanIntroState(String a2) {
        AbstractPlayerInteraction a3;
        return a3.getInfoQuest(22013).equals(a2);
    }

    public final /* synthetic */ void updateInfoQuest(int a2, String a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().getPlayer().updateInfoQuest(a2, a3);
    }

    public /* synthetic */ void getTopMsg(String a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(UIPacket.getTopMsg(a2));
    }

    public /* synthetic */ EventInstanceManager getDisconnected(String a2) {
        AbstractPlayerInteraction a3;
        if ((a2 = a3.getEventManager((String)((Object)a2))) == null) {
            return null;
        }
        for (EventInstanceManager eventInstanceManager : ((EventManager)((Object)a2)).getInstances()) {
            if (!eventInstanceManager.isDisconnected(a3.ALLATORIxDEMO.getPlayer()) || eventInstanceManager.getPlayerCount() <= 0) continue;
            return eventInstanceManager;
        }
        return null;
    }

    public /* synthetic */ int getTotalOnline() {
        return ChannelServer.getAllInstances().stream().map(a2 -> a2.getConnectedClients()).reduce(0, Integer::sum);
    }

    public /* synthetic */ void forceCompleteQuest(int a2) {
        AbstractPlayerInteraction a3;
        MapleQuest.getInstance(a2).forceComplete(a3.getPlayer(), 0);
    }

    public final /* synthetic */ void openNpc(MapleClient a2, String a3) {
        AbstractPlayerInteraction a4;
        a4.openNpc(a2, 0, a3);
    }

    public /* synthetic */ void setDayLog(String a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().setDayLog(a2);
    }

    public final /* synthetic */ boolean canHoldSlots(int a2) {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 5) {
            AbstractPlayerInteraction a3;
            if (a3.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType((byte)n2)).isFull(a2)) {
                return false;
            }
            n3 = ++n2;
        }
        return true;
    }

    public final /* synthetic */ boolean canHoldByTypea(byte a2, int a3) {
        AbstractPlayerInteraction a4;
        return a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType(a2)).getSlotLimit() - (a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType(a2)).getNextFreeSlot() - 1) > a3;
    }

    public final /* synthetic */ void hitReactor(int a22, int a3) {
        AbstractPlayerInteraction a4;
        Iterator<MapleReactor> iterator = a4.getClient().getChannelServer().getMapFactory().getMap(a22).getAllReactorsThreadsafe().iterator();
        while (iterator.hasNext()) {
            MapleReactor a22 = (MapleReactor)((MapleMapObject)iterator.next());
            if (a22.getReactorId() != a3) continue;
            a22.hitReactor(a4.ALLATORIxDEMO);
            return;
        }
    }

    public /* synthetic */ int Random(int a2, int a3) {
        return Randomizer.rand(a2, a3);
    }

    public final /* synthetic */ void gainNX(int a2) {
        AbstractPlayerInteraction a3;
        a3.gainPotion(1, a2);
    }

    public final /* synthetic */ MapleGuild getGuild(int a2) {
        return World.Guild.getGuild(a2);
    }

    public /* synthetic */ void openWeb(String a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(MaplePacketCreator.openWeb(a2));
    }

    public /* synthetic */ long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public final /* synthetic */ void ShowWZEffect(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.AranTutInstructionalBalloon(a2));
    }

    public final /* synthetic */ boolean isAllPartyMembersAllowedJob(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.ALLATORIxDEMO.getPlayer().getParty() == null) {
            return false;
        }
        Iterator<MaplePartyCharacter> iterator = a3.getClient().getPlayer().getParty().getMembers().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getJobId() / 100 == a2) continue;
            return false;
        }
        return true;
    }

    public final /* synthetic */ boolean canHoldByType(byte a2, int a3) {
        AbstractPlayerInteraction a4;
        return a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType(a2)).getSlotLimit() - (a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType(a2)).getNumSlotLimit() + 1) > a3;
    }

    public /* synthetic */ void getMidMsg(String a2) {
        AbstractPlayerInteraction a3;
        a3.getMidMsg(a2, true, 0);
    }

    public /* synthetic */ int UseCube(IItem a2, IItem a3) {
        AbstractPlayerInteraction abstractPlayerInteraction;
        AbstractPlayerInteraction a4;
        if (a3 == null || a3.getQuantity() < 1) {
            a4.ALLATORIxDEMO.getSession().write((Object)MaplePacketCreator.enableActions());
            return 1;
        }
        boolean bl = false;
        int n2 = 100;
        if (a3.getItemId() == 5062000) {
            AbstractPlayerInteraction abstractPlayerInteraction2;
            if (a4.ALLATORIxDEMO.getPlayer().getLevel() < 10) {
                return 2;
            }
            IItem iItem = a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((byte)a2.getPosition());
            if (iItem != null && a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
                Equip equip = (Equip)iItem;
                if (equip.getState() >= 5 && equip.getState() != 8) {
                    Equip equip2;
                    Object object;
                    Equip equip3;
                    Object object2;
                    if (!a4.haveItem(5062000, 1)) {
                        return 3;
                    }
                    AbstractPlayerInteraction abstractPlayerInteraction3 = a4;
                    abstractPlayerInteraction3.gainItem(5062000, (short)-1);
                    equip.renewPotential();
                    abstractPlayerInteraction3.ALLATORIxDEMO.getPlayer().forceReAddItem_Equip(iItem, MapleInventoryType.EQUIP);
                    MapleInventoryManipulator.addById(a4.ALLATORIxDEMO, 2430112, (short)1, "Cube on " + FileoutputUtil.CurrentReadable_Date());
                    String string = MapleFoothold.ALLATORIxDEMO("<37/\u007f\u00181(1s\u8dd5\u7d46\u5917\u5e27\u65e9\u5816~(((");
                    String string2 = FileoutputUtil.NowTime();
                    String string3 = a4.ALLATORIxDEMO.getPlayer().getClient().getSession().remoteAddress().toString().split(SyncServerData.ALLATORIxDEMO("0"))[0];
                    String string4 = a4.ALLATORIxDEMO.getPlayer().getName();
                    int n3 = a4.ALLATORIxDEMO.getPlayer().getMap().getId();
                    String string5 = a4.ALLATORIxDEMO.getPlayer().getMap().getMapName();
                    int n4 = equip.getItemId();
                    String string6 = equip.getItemName();
                    long l2 = equip.getEquipOnlyId();
                    if (equip.getPotential1() > 0) {
                        object2 = equip.getPotential1();
                        equip3 = equip;
                    } else {
                        object2 = MapleFoothold.ALLATORIxDEMO("\u717d");
                        equip3 = equip;
                    }
                    if (equip3.getPotential2() > 0) {
                        object = equip.getPotential2();
                        equip2 = equip;
                    } else {
                        object = SyncServerData.ALLATORIxDEMO("\u712b");
                        equip2 = equip;
                    }
                    FileoutputUtil.logToFile(string, "\r\n" + string2 + " IP: " + string3 + " \u89d2\u8272\u540d\u5b57: " + string4 + " \u5728\u5730\u5716\u300c" + n3 + "-" + string5 + "\u300d \u4f7f\u7528\u4e86\u5947\u5e7b\u65b9\u584a\u5728\u88dd\u5099:" + n4 + "(" + string6 + ") \u88dd\u5099\u552f\u4e00ID:" + l2 + "\u5df2\u7d93\u91cd\u65b0\u8a2d\u5b9a\u4e86\u6f5b\u80fd\u3000\u4e4b\u524d\u7684\u6dfa\u80fd1:" + (Serializable)object2 + " \u4e4b\u524d\u7684\u6dfa\u80fd2:" + (Serializable)object + " \u4e4b\u524d\u7684\u6dfa\u80fd3:" + (Serializable)(equip2.getPotential3() > 0 ? Integer.valueOf(equip.getPotential3()) : MapleFoothold.ALLATORIxDEMO("\u717d")));
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.serverNotice(6, "[GM \u5bc6\u8a9e]\u300e" + a4.ALLATORIxDEMO.getPlayer().getName() + "\u300f(" + a4.ALLATORIxDEMO.getPlayer().getId() + ")\u5730\u5716\u300e" + a4.ALLATORIxDEMO.getPlayer().getMapId() + "\u300f\u4f7f\u7528\u4e86\u9b54\u65b9\u9053\u5177: 5062000"));
                    a4.ALLATORIxDEMO.getSession().write((Object)MaplePacketCreator.enableActions());
                    return 0;
                }
                bl = true;
                n2 = 4;
                abstractPlayerInteraction2 = a4;
            } else {
                bl = true;
                n2 = 5;
                abstractPlayerInteraction2 = a4;
            }
            abstractPlayerInteraction2.ALLATORIxDEMO.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(bl, a4.ALLATORIxDEMO.getPlayer().getId(), a3.getItemId()));
            a4.ALLATORIxDEMO.getSession().write((Object)MaplePacketCreator.enableActions());
            return n2;
        }
        if (a3.getItemId() != 5062001) {
            return 6;
        }
        if (a4.ALLATORIxDEMO.getPlayer().getLevel() < 70) {
            return 12;
        }
        IItem iItem = a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((byte)a2.getPosition());
        if (iItem != null && a4.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
            Equip equip = (Equip)iItem;
            if (equip.getState() >= 5 && equip.getState() != 8) {
                Equip equip4;
                Object object;
                Equip equip5;
                Object object3;
                if (!a4.haveItem(5062001, 1)) {
                    return 3;
                }
                a4.gainItem(5062001, (short)-1);
                Equip equip6 = equip;
                equip6.renewPotential1(equip6.getPotential3() <= 0);
                AbstractPlayerInteraction abstractPlayerInteraction4 = a4;
                abstractPlayerInteraction4.ALLATORIxDEMO.getPlayer().forceReAddItem_Equip(iItem, MapleInventoryType.EQUIP);
                MapleInventoryManipulator.addById(abstractPlayerInteraction4.ALLATORIxDEMO, 2430112, (short)1, "Cube on " + FileoutputUtil.CurrentReadable_Date());
                String string = SyncServerData.ALLATORIxDEMO("\u0019e\u0012yZN\u0014~\u0014%\u6926\u8443\u5932\u5e71\u65cc\u5840[~\r~");
                String string7 = FileoutputUtil.NowTime();
                String string8 = a4.ALLATORIxDEMO.getPlayer().getClient().getSession().remoteAddress().toString().split(MapleFoothold.ALLATORIxDEMO("f"))[0];
                String string9 = a4.ALLATORIxDEMO.getPlayer().getName();
                int n5 = a4.ALLATORIxDEMO.getPlayer().getMap().getId();
                String string10 = a4.ALLATORIxDEMO.getPlayer().getMap().getMapName();
                int n6 = equip.getItemId();
                String string11 = equip.getItemName();
                long l3 = equip.getEquipOnlyId();
                if (equip.getPotential1() > 0) {
                    object3 = equip.getPotential1();
                    equip5 = equip;
                } else {
                    object3 = SyncServerData.ALLATORIxDEMO("\u712b");
                    equip5 = equip;
                }
                if (equip5.getPotential2() > 0) {
                    object = equip.getPotential2();
                    equip4 = equip;
                } else {
                    object = MapleFoothold.ALLATORIxDEMO("\u717d");
                    equip4 = equip;
                }
                FileoutputUtil.logToFile(string, "\r\n" + string7 + " IP: " + string8 + " \u89d2\u8272\u540d\u5b57: " + string9 + " \u5728\u5730\u5716\u300c" + n5 + "-" + string10 + "\u300d \u4f7f\u7528\u4e86\u5947\u5e7b\u65b9\u584a\u5728\u88dd\u5099:" + n6 + "(" + string11 + ") \u88dd\u5099\u552f\u4e00ID:" + l3 + "\u5df2\u7d93\u91cd\u65b0\u8a2d\u5b9a\u4e86\u6f5b\u80fd\u3000\u4e4b\u524d\u7684\u6dfa\u80fd1:" + (Serializable)object3 + " \u4e4b\u524d\u7684\u6dfa\u80fd2:" + (Serializable)object + " \u4e4b\u524d\u7684\u6dfa\u80fd3:" + (Serializable)(equip4.getPotential3() > 0 ? Integer.valueOf(equip.getPotential3()) : SyncServerData.ALLATORIxDEMO("\u712b")));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.serverNotice(6, "[GM \u5bc6\u8a9e]\u300e" + a4.ALLATORIxDEMO.getPlayer().getName() + "\u300f(" + a4.ALLATORIxDEMO.getPlayer().getId() + ")\u5730\u5716\u300e" + a4.ALLATORIxDEMO.getPlayer().getMapId() + "\u300f\u4f7f\u7528\u4e86\u9b54\u65b9\u9053\u5177: 5062001"));
                a4.ALLATORIxDEMO.getSession().write((Object)MaplePacketCreator.enableActions());
                return 0;
            }
            bl = true;
            n2 = 4;
            abstractPlayerInteraction = a4;
        } else {
            bl = true;
            n2 = 5;
            abstractPlayerInteraction = a4;
        }
        abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(bl, a4.ALLATORIxDEMO.getPlayer().getId(), a3.getItemId()));
        a4.ALLATORIxDEMO.getSession().write((Object)MaplePacketCreator.enableActions());
        return n2;
    }

    public final /* synthetic */ void teachSkill(int a22, int a3) {
        AbstractPlayerInteraction a4;
        ISkill a22 = SkillFactory.getSkill(a22);
        if (a4.getPlayer().getSkillLevel(a22) > a3) {
            a3 = a4.getPlayer().getSkillLevel(a22);
        }
        ISkill iSkill = a22;
        a4.getPlayer().changeSkillLevel(iSkill, a3, (int)iSkill.getMaxLevel());
    }

    public /* synthetic */ int getBossLog(String a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().getBossLog(a2);
    }

    public /* synthetic */ void gainGP(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getGuildId() <= 0) {
            return;
        }
        World.Guild.gainGP(a3.getPlayer().getGuildId(), a2);
    }

    public final /* synthetic */ MapleInventory getInventory(int a2) {
        AbstractPlayerInteraction a3;
        return a3.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType((byte)a2));
    }

    public /* synthetic */ String getMobName(int a2) {
        return MapleMonsterInformationProvider.getInstance().getMobName(a2);
    }

    public /* synthetic */ void save() {
        AbstractPlayerInteraction a2;
        a2.save(false, false);
    }

    public final /* synthetic */ void forceStartQuest(int a2, String a3) {
        AbstractPlayerInteraction a4;
        MapleQuest.getInstance(a2).forceStart(a4.ALLATORIxDEMO.getPlayer(), 0, a3);
    }

    public final /* synthetic */ void warp_Instanced(int a22) {
        AbstractPlayerInteraction a3;
        MapleMap a22 = a3.getMap_Instanced(a22);
        try {
            MapleMap mapleMap = a22;
            a3.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(Randomizer.nextInt(mapleMap.getPortals().size())));
            return;
        }
        catch (Exception exception) {
            MapleMap mapleMap = a22;
            a3.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(0));
            return;
        }
    }

    public final /* synthetic */ int getPotion(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getPlayer().getCSPoints(a2);
    }

    public /* synthetic */ void sendResetMoveScreen() {
        AbstractPlayerInteraction a2;
        a2.ALLATORIxDEMO.sendPacket(UIPacket.ResetScreen());
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, int a3, Point a4) {
        AbstractPlayerInteraction a5;
        if (MapleLifeFactory.getMonster(a2) != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a5.getClient().getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), a4);
                n3 = ++n2;
            }
        } else if (a5.getPlayer() != null && a5.getPlayer().isStaff()) {
            a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public final /* synthetic */ void gainItem(int a2, short a3) {
        AbstractPlayerInteraction a4;
        a4.gainItem(a2, a3, false, 0L, -1, "");
    }

    public /* synthetic */ int getPartyBossLogReload(String a2) {
        AbstractPlayerInteraction a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getParty() != null) {
            for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
                if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
                MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId());
                arrayList.add(mapleCharacter.getBossLogReload(a2));
            }
        } else {
            return a3.getPlayer().getBossLogReload(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public /* synthetic */ void spawnMonster(int a2, int a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.spawnMonster(a2, 1, new Point(a3, a4));
    }

    public final /* synthetic */ void clearSavedLocation(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().clearSavedLocation(SavedLocationType.fromString(a2));
    }

    public final /* synthetic */ int getSavedLocation(String a2) {
        AbstractPlayerInteraction a3;
        a2 = a3.getClient().getPlayer().getSavedLocation(SavedLocationType.fromString((String)a2));
        if (a2 == null || (Integer)a2 == -1) {
            return 100000000;
        }
        return (Integer)a2;
    }

    public final /* synthetic */ void mapMessage(String a2) {
        AbstractPlayerInteraction a3;
        a3.mapMessage(5, a2);
    }

    public final /* synthetic */ int getSavedLocation(String a2, int a3) {
        AbstractPlayerInteraction a4;
        a2 = a4.ALLATORIxDEMO.getPlayer().getSavedLocation(SavedLocationType.fromString((String)a2));
        if (a2 == null || (Integer)a2 == -1) {
            return a3;
        }
        return (Integer)a2;
    }

    public /* synthetic */ void sendDirectionStatus(int a2, int a3, boolean a4) {
        AbstractPlayerInteraction a5;
        AbstractPlayerInteraction abstractPlayerInteraction = a5;
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.getDirectionInfo(a2, a3));
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.getDirectionStatus(a4));
    }

    public final /* synthetic */ void inMushroomCastle() {
        AbstractPlayerInteraction a2;
        if (a2.getPlayer().getLevel() >= 30) {
            AbstractPlayerInteraction abstractPlayerInteraction = a2;
            abstractPlayerInteraction.playPortalSE();
            abstractPlayerInteraction.warp(106020001, 0);
            return;
        }
        a2.playerMessage(5, MapleFoothold.ALLATORIxDEMO("\u4f3c\u9750\u89ddcl\u7d4a\u6211\u53bf\u4eb9\u9062\u5139\u8397\u839b\u73db\u5757"));
    }

    public final /* synthetic */ void dojo_getUp() {
        AbstractPlayerInteraction a2;
        AbstractPlayerInteraction abstractPlayerInteraction = a2;
        abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.updateInfoQuest(1207, SyncServerData.ALLATORIxDEMO("\u0005~H;Ng\u001cdH>Nh\u0010f\u00017D1\u0001\u007f\u0001eH;")));
        abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.showMuLungPortal());
        abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.instantMapWarp((byte)6));
    }

    public final /* synthetic */ void gainItemNostat(int a2, short a3, long a4) {
        AbstractPlayerInteraction a5;
        a5.gainItemS(a2, a3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, a5.ALLATORIxDEMO, a4);
    }

    public final /* synthetic */ void warpGuildMap(int a22, boolean a32) {
        AbstractPlayerInteraction a4;
        block4: {
            int n2 = a4.getPlayer().getGuildId();
            if (n2 <= 0) {
                a4.getPlayer().dropMessage(MapleFoothold.ALLATORIxDEMO("\u60f4\u677a\u52fc\u5135\u5130\u6753}"));
                return;
            }
            MapleMap a22 = a4.getMapFactory().getGuildMap(a22, true, true, true, n2);
            try {
                MapleMap mapleMap = a22;
                a4.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(Randomizer.nextInt(mapleMap.getPortals().size())));
                if (!a32) break block4;
                a4.getClient().getPlayer().getMap().startMapEffect("\u6b61\u8fce" + a4.getPlayer().getName() + "\u9032\u5165 " + a4.getPlayer().getGuild().getName() + " \u5c08\u5c6c\u7df4\u529f\u5730\u5716!", 5122000);
                return;
            }
            catch (Exception a32) {
                MapleMap mapleMap = a22;
                a4.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(0));
                return;
            }
        }
        a4.getClient().getPlayer().getMap().startMapEffect("\u6b61\u8fce" + a4.getPlayer().getName() + "\u9032\u5165 " + a4.getPlayer().getGuild().getName() + " \u6703\u5730!", 5122000);
    }

    public /* synthetic */ MapleMapFactory getMapFactory() {
        AbstractPlayerInteraction a2;
        return a2.getChannelServer().getMapFactory();
    }

    public /* synthetic */ long seeAlltouzhu() {
        return CustomEventFactory.getInstance().getLottery().getAlltouzhu();
    }

    public /* synthetic */ int getofflinemap() {
        AbstractPlayerInteraction a2;
        return a2.ALLATORIxDEMO.getPlayer().getofflinemap();
    }

    public final /* synthetic */ void showWZEffectNew(String a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(UIPacket.ShowWZEffect2(a2));
    }

    public /* synthetic */ void showEnvironment(boolean a2, int a3, String a4, int[] a5) {
        AbstractPlayerInteraction a6;
        if (a2) {
            a6.ALLATORIxDEMO.getPlayer().getMap().broadcastMessage(MaplePacketCreator.showEnvironment(a3, a4, a5));
            return;
        }
        a6.ALLATORIxDEMO.sendPacket(MaplePacketCreator.showEnvironment(a3, a4, a5));
    }

    public /* synthetic */ long getofflinetime() {
        AbstractPlayerInteraction a2;
        return a2.ALLATORIxDEMO.getPlayer().getofflinetime();
    }

    public /* synthetic */ void setOneTimeLog(String a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().setOneTimeLog(a2);
    }

    public final /* synthetic */ void guildMessage(String a2) {
        AbstractPlayerInteraction a3;
        a3.guildMessage(5, a2);
    }

    public /* synthetic */ void gainPet(int a2, int a3) {
        AbstractPlayerInteraction a4;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        a4.gainPet(a2, MapleFoothold.ALLATORIxDEMO("\u5ba5\u7235"), 1, 0, 100, a3, mapleItemInformationProvider.getPetFlagInfo(a2));
    }

    public final /* synthetic */ void playerMessage(String a2) {
        AbstractPlayerInteraction a3;
        a3.playerMessage(5, a2);
    }

    public final /* synthetic */ void spawnNpc(int a2, int a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.getClient().getPlayer().getMap().spawnNpc(a2, new Point(a3, a4));
    }

    public final /* synthetic */ void showWZEffect(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.ShowWZEffect(a2));
    }

    public final /* synthetic */ boolean isQuestActive(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getQuestStatus(a2) == 1;
    }

    public final /* synthetic */ void resetMap(int a2, boolean a3) {
        AbstractPlayerInteraction a4;
        a4.getMap(a2).resetFully(a3);
    }

    public final /* synthetic */ void teachSkill(int a2, int a3, byte a4) {
        AbstractPlayerInteraction a5;
        a5.getPlayer().changeSkillLevel(SkillFactory.getSkill(a2), a3, (int)a4);
    }

    public /* synthetic */ int getMapPlayerSize(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getMap(a2).getCharactersSize();
    }

    public /* synthetic */ void spawnMonster(int a2, int a3, long a4) {
        AbstractPlayerInteraction a5;
        a5.ALLATORIxDEMO(a2, a3, new Point(a5.ALLATORIxDEMO.getPlayer().getPosition()), a4);
    }

    public /* synthetic */ MapleMonster getMonster(int a2) {
        return MapleLifeFactory.getMonster(a2);
    }

    public final /* synthetic */ void updateEvanIntroState(String a2) {
        AbstractPlayerInteraction a3;
        a3.updateInfoQuest(22013, a2);
    }

    public final /* synthetic */ void warpMap(int a22, String a3) {
        Iterator<MapleCharacter> iterator;
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleMap a22 = abstractPlayerInteraction.getMap(a22);
        Iterator<MapleCharacter> iterator2 = iterator = abstractPlayerInteraction.getClient().getPlayer().getMap().getCharactersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            MapleMap mapleMap = a22;
            iterator.next().changeMap(mapleMap, mapleMap.getPortal(a3));
            iterator2 = iterator;
        }
    }

    private /* synthetic */ Equip ALLATORIxDEMO(int a22, short a3, short a4, short a5, short a6, byte a7, String a8) {
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        Equip a22 = mapleItemInformationProvider.randomizeStats((Equip)mapleItemInformationProvider.getEquipById(a22));
        if (a3 != 0) {
            Equip equip = a22;
            short s2 = a3;
            a22.setStr(a3);
            a22.setDex(s2);
            equip.setInt(s2);
            equip.setLuk(a3);
        }
        if (a4 != 0) {
            Equip equip = a22;
            equip.setHp(a4);
            equip.setMp(a4);
        }
        if (a5 != 0) {
            Equip equip = a22;
            equip.setWatk(a5);
            equip.setMatk(a5);
        }
        if (a6 != 0) {
            Equip equip = a22;
            equip.setWdef(a6);
            equip.setWdef(a6);
        }
        if (a7 != 0) {
            a22.setUpgradeSlots(a7);
        }
        Equip equip = a22;
        equip.setOwner(a8);
        return equip;
    }

    public final /* synthetic */ void changeMusic(String a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().getMap().broadcastMessage(MaplePacketCreator.musicChange(a2));
    }

    public /* synthetic */ void getDirectionInfo(String a2, int a3, int a4, int a5, int a6) {
        AbstractPlayerInteraction a7;
        a7.getClient().sendPacket(UIPacket.getDirectionInfo(a2, a3, a4, a5, a6));
    }

    public /* synthetic */ List<IItem> getMagnifylist() {
        AbstractPlayerInteraction a2;
        Object object = a2.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.USE);
        ArrayList<IItem> arrayList = new ArrayList<IItem>();
        object = ((MapleInventory)object).iterator();
        while (object.hasNext()) {
            IItem iItem = (IItem)object.next();
            if (iItem.getItemId() != 2460000 && iItem.getItemId() != 2460001 && iItem.getItemId() != 2460002 && iItem.getItemId() != 2460003) continue;
            arrayList.add(iItem);
        }
        return arrayList;
    }

    public final /* synthetic */ void updateQuest(int a22) {
        AbstractPlayerInteraction a3;
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        MapleQuestStatus a22 = abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().getQuestNAdd(MapleQuest.getInstance(a22));
        abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().updateQuest(a22);
    }

    public final /* synthetic */ void openNpc(int a2, int a3) {
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        abstractPlayerInteraction.openNpc(abstractPlayerInteraction.getClient(), a2, a3, null);
    }

    public final /* synthetic */ void gainItem(int a2, short a3, long a4) {
        AbstractPlayerInteraction a5;
        a5.gainItem(a2, a3, false, a4, -1, "");
    }

    public final /* synthetic */ int getNX() {
        AbstractPlayerInteraction a2;
        return a2.getPotion(1);
    }

    public /* synthetic */ void lockUI(boolean a2, int a3) {
        AbstractPlayerInteraction a4;
        int n2;
        int n3;
        if (a2) {
            n3 = 1;
            n2 = a3;
        } else {
            n3 = 0;
            n2 = a3;
        }
        a4.lockUI(n3, n2);
    }

    public final /* synthetic */ boolean gainThreePetSkill() {
        int n2;
        AbstractPlayerInteraction a2;
        boolean bl = false;
        int n3 = a2.ALLATORIxDEMO.getPlayer().getJob();
        int n4 = 8;
        if (JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(n3)) {
            n2 = n4 = 10000018;
        } else if (JobConstants.is\u72c2\u72fc\u52c7\u58eb(n3)) {
            n2 = n4 = 20000024;
        } else if (JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(n3)) {
            n2 = n4 = 20011024;
        } else if (JobConstants.is\u7cbe\u9748\u904a\u4fe0(n3)) {
            n2 = n4 = 20020213;
        } else if (JobConstants.is\u60e1\u9b54\u6bba\u624b(n3)) {
            n2 = n4 = 80000023;
        } else if (JobConstants.is\u672b\u65e5\u53cd\u6297\u8ecd(n3)) {
            n2 = n4 = 30001024;
        } else if (JobConstants.is\u9670\u967d\u5e2b(n3)) {
            n2 = n4 = 40021024;
        } else if (JobConstants.is\u528d\u8c6a(n3)) {
            n2 = n4 = 40011024;
        } else if (JobConstants.is\u7c73\u54c8\u9038(n3)) {
            n2 = n4 = 80000023;
        } else if (JobConstants.is\u51f1\u6492(n3) || JobConstants.is\u591c\u5149(n3)) {
            n2 = n4 = 80000023;
        } else if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(n3)) {
            n2 = n4 = 80000023;
        } else {
            if (JobConstants.is\u5e7b\u5f71\u4fe0\u76dc(n3)) {
                n4 = 80000023;
            }
            n2 = n4;
        }
        if (n2 != 0) {
            AbstractPlayerInteraction abstractPlayerInteraction = a2;
            n3 = abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().getSkillLevel(SkillFactory.getSkill(n4));
            abstractPlayerInteraction.teachSkill(n4, ++n3, (byte)5);
            bl = true;
            return true;
        }
        bl = false;
        return false;
    }

    public final /* synthetic */ void instantMapWarp(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(MaplePacketCreator.instantMapWarp((byte)a2));
    }

    public /* synthetic */ int getPartyAcLog(String a2) {
        AbstractPlayerInteraction a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getParty() != null) {
            for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
                if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
                MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId());
                arrayList.add(mapleCharacter.getAcLog(a2));
            }
        } else {
            return a3.getClient().getPlayer().getAcLog(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public /* synthetic */ void showEffect(boolean a2, String a3) {
        AbstractPlayerInteraction a4;
        if (a2) {
            a4.ALLATORIxDEMO.getPlayer().getMap().broadcastMessage(MaplePacketCreator.showEffect(a3));
            return;
        }
        a4.ALLATORIxDEMO.sendPacket(MaplePacketCreator.showEffect(a3));
    }

    public /* synthetic */ int getGP() {
        AbstractPlayerInteraction a2;
        if (a2.getPlayer().getGuildId() <= 0) {
            return 0;
        }
        return World.Guild.getGP(a2.getPlayer().getGuildId());
    }

    public final /* synthetic */ MapleQuestStatus getQuest(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().getQuest(MapleQuest.getInstance(a2));
    }

    public final /* synthetic */ void givePartyNX(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getParty() == null || a3.getPlayer().getParty().getMembers().size() == 1) {
            a3.gainNX(a2);
            return;
        }
        for (MaplePartyCharacter maplePartyCharacter : a3.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a3.getMap().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null) continue;
            serializable.modifyCSPoints(true ? (byte)1 : 0, a2, true);
        }
    }

    public final /* synthetic */ boolean canHold() {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 5) {
            AbstractPlayerInteraction a2;
            if (a2.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType((byte)n2)).getNextFreeSlot() <= -1) {
                return false;
            }
            n3 = ++n2;
        }
        return true;
    }

    public final /* synthetic */ int getMorphState() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getMorphState();
    }

    public final /* synthetic */ void gainItem(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, int a18, long a19, String a20) {
        AbstractPlayerInteraction a21;
        a21.gainItemS(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a21.ALLATORIxDEMO, a19, a20);
    }

    public /* synthetic */ void spawnMonster(int a2, int a3, int a4, int a5) {
        AbstractPlayerInteraction a6;
        a6.spawnMonster(a2, a3, new Point(a4, a5));
    }

    public final /* synthetic */ boolean isQuestFinished(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getQuestStatus(a2) == 2;
    }

    public final /* synthetic */ void sendGachaponMega(int a2, int a32, String a4) {
        if (MapleItemInformationProvider.getInstance().itemExists(a2)) {
            AbstractPlayerInteraction a5;
            IItem a32 = GameConstants.getInventoryType(a2) == MapleInventoryType.EQUIP ? MapleItemInformationProvider.getInstance().getEquipById(a2) : new Item(a2, 0, 1, 0);
            World.Broadcast.broadcastEtcSmega(a5.ALLATORIxDEMO.getWorld(), MaplePacketCreator.getGachaponMega(a5.ALLATORIxDEMO.getPlayer().getName() + " : " + a4, a32, a5.ALLATORIxDEMO.getChannel(), a5.ALLATORIxDEMO.getPlayer().getName()));
        }
    }

    public /* synthetic */ void showScreenAutoLetterBox(boolean a2, String a3) {
        AbstractPlayerInteraction a4;
        if (a2) {
            a4.ALLATORIxDEMO.getPlayer().getMap().broadcastMessage(UIPacket.MapEff(a3));
            return;
        }
        a4.ALLATORIxDEMO.sendPacket(UIPacket.MapEff(a3));
    }

    public final /* synthetic */ void instantMapWarp(int a22, int a3) {
        AbstractPlayerInteraction a4;
        MapleMap mapleMap = a4.ALLATORIxDEMO(a22);
        if (a3 != 0 && a22 == a4.ALLATORIxDEMO.getPlayer().getMapId()) {
            Point a22 = new Point(a4.ALLATORIxDEMO.getPlayer().getMap().getPortal(a3).getPosition());
            AbstractPlayerInteraction abstractPlayerInteraction = a4;
            abstractPlayerInteraction.ALLATORIxDEMO.sendPacket(MaplePacketCreator.instantMapWarp((byte)a3));
            abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().checkFollow();
            abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().getMap().movePlayer(a4.ALLATORIxDEMO.getPlayer(), a22);
            return;
        }
        MapleMap mapleMap2 = mapleMap;
        a4.ALLATORIxDEMO.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(a3));
    }

    public final /* synthetic */ void gainItem(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, long a12) {
        AbstractPlayerInteraction a13;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            Object object2 = GameConstants.getInventoryType(a2);
            if (!GameSetConstants.STORAGE_EXCEED && !MapleInventoryManipulator.checkSpace(a13.ALLATORIxDEMO, a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a13.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a13.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (((Enum)object2).equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                object2 = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                object = ((MapleItemInformationProvider)object).getName(a2);
                if (a2 / 10000 == 114 && object != null && ((String)object).length() > 0) {
                    object = "\u4f60\u5df2\u7372\u5f97\u7a31\u865f <" + (String)object + ">";
                    AbstractPlayerInteraction abstractPlayerInteraction = a13;
                    abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().dropMessage(-1, (String)object);
                    abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().dropMessage(5, (String)object);
                }
                if (a12 >= 0L) {
                    ((Item)object2).setExpiration(System.currentTimeMillis() + a12 * 24L * 60L * 60L * 1000L);
                }
                if (a4 >= 0) {
                    ((Equip)object2).setStr((short)a4);
                }
                if (a5 >= 0) {
                    ((Equip)object2).setDex((short)a5);
                }
                if (a6 >= 0) {
                    ((Equip)object2).setLuk((short)a6);
                }
                if (a7 >= 0) {
                    ((Equip)object2).setInt((short)a7);
                }
                if (a8 >= 0) {
                    ((Equip)object2).setHp((short)a8);
                }
                if (a9 >= 0) {
                    ((Equip)object2).setMp((short)a9);
                }
                if (a10 >= 0) {
                    ((Equip)object2).setWatk((short)a10);
                }
                if (a11 >= 0) {
                    ((Equip)object2).setMatk((short)a11);
                }
                MapleInventoryManipulator.addbyItem(a13.ALLATORIxDEMO, ((Equip)object2).copy());
            } else {
                MapleInventoryManipulator.addById(a13.ALLATORIxDEMO, a2, a3, "");
            }
        } else {
            if (!a13.getPlayer().haveItem(a2, Math.abs(a3))) {
                FileoutputUtil.logToFile_NpcScript_Bug(a13.getPlayer(), " \u542b\u6709 \u6263\u9664\u4e0d\u5b58\u5728\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "] \u4e4b\u6f0f\u6d1e\r\n");
                a13.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleInventoryManipulator.removeById(a13.ALLATORIxDEMO, GameConstants.getInventoryType(a2), a2, -a3, true, false);
        }
        a13.ALLATORIxDEMO.sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public /* synthetic */ void gainPet(int a2, String a3, int a4, int a5, int a6) {
        AbstractPlayerInteraction a7;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        a7.gainPet(a2, a3, a4, a5, a6, mapleItemInformationProvider.getPetLife(a2), mapleItemInformationProvider.getPetFlagInfo(a2));
    }

    public final /* synthetic */ void EarnTitleMsg(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.EarnTitleMsg(a2));
    }

    public /* synthetic */ void showMapEffect(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.MapEff(a2));
    }

    public /* synthetic */ void dispose() {
        AbstractPlayerInteraction a2;
        NPCScriptManager.getInstance().dispose(a2.ALLATORIxDEMO);
    }

    public final /* synthetic */ void cancelItem(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().cancelEffect(MapleItemInformationProvider.getInstance().getItemEffect(a2), false, -1L);
    }

    public final /* synthetic */ void gainItem(int a2, short a3, long a4, boolean a5) {
        AbstractPlayerInteraction a6;
        a6.gainItem(a2, a3, a5, a4, -1, "");
    }

    public final /* synthetic */ void gainItemAdd(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, int a18) {
        AbstractPlayerInteraction a19;
        a19.gainItemAdd(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a19.ALLATORIxDEMO, a18);
    }

    public final /* synthetic */ void givePartyExp(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getParty() == null || a3.getPlayer().getParty().getMembers().size() == 1) {
            a3.gainExp((int)((double)a2 * a3.getClient().getChannelServer().getExpRate(a3.ALLATORIxDEMO.getPlayer().getWorld())));
            return;
        }
        for (MaplePartyCharacter maplePartyCharacter : a3.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a3.getMap().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null) continue;
            serializable.gainExp((int)((double)a2 * a3.getClient().getChannelServer().getExpRate(a3.ALLATORIxDEMO.getPlayer().getWorld())), true, true, true);
        }
    }

    public final /* synthetic */ MapleClient getC() {
        AbstractPlayerInteraction a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ boolean gainEnhanceSkill() {
        int n2;
        AbstractPlayerInteraction a2;
        boolean bl = false;
        int n3 = a2.ALLATORIxDEMO.getPlayer().getJob();
        int n4 = 0;
        if (MapleJob.is\u5192\u96aa\u5bb6(n3)) {
            n2 = n4 = 1007;
        } else if (MapleJob.is\u7687\u5bb6\u9a0e\u58eb\u5718(n3)) {
            n2 = n4 = 10001007;
        } else if (MapleJob.is\u72c2\u72fc\u52c7\u58eb(n3)) {
            n2 = n4 = 20001007;
        } else {
            if (MapleJob.is\u9f8d\u9b54\u5c0e\u58eb(n3)) {
                n4 = 20011007;
            }
            n2 = n4;
        }
        if (n2 != 0) {
            AbstractPlayerInteraction abstractPlayerInteraction = a2;
            n3 = abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().getSkillLevel(SkillFactory.getSkill(n4));
            abstractPlayerInteraction.teachSkill(n4, ++n3, (byte)5);
            bl = true;
            return true;
        }
        bl = false;
        return false;
    }

    public final /* synthetic */ boolean haveMonster(int a2) {
        AbstractPlayerInteraction a3;
        Iterator<MapleMonster> iterator = a3.getClient().getPlayer().getMap().getAllMonstersThreadsafe().iterator();
        while (iterator.hasNext()) {
            if (((MapleMonster)((MapleMapObject)iterator.next())).getId() != a2) continue;
            return true;
        }
        return false;
    }

    public /* synthetic */ void unlockUI() {
        AbstractPlayerInteraction a2;
        AbstractPlayerInteraction abstractPlayerInteraction = a2;
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.IntroDisableUI(false));
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.IntroLock(false));
    }

    public /* synthetic */ void sendDirectionStatus(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.sendDirectionStatus(a2, a3, true);
    }

    public /* synthetic */ long seeAllpeichu() {
        return CustomEventFactory.getInstance().getLottery().getAllpeichu();
    }

    public /* synthetic */ boolean hasEventInstance() {
        AbstractPlayerInteraction a2;
        return a2.getPlayer().getEventInstance() != null;
    }

    public /* synthetic */ void setQuestCustomData(int a2, String a3) {
        AbstractPlayerInteraction a4;
        a4.getPlayer().getQuestNAdd(MapleQuest.getInstance(a2)).setCustomData(a3);
    }

    public /* synthetic */ void gainServerSet(String a2, int a3) {
        ServerSet.gainServerSet(a2, a3);
    }

    public /* synthetic */ void getDirectionStatus(boolean a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(UIPacket.getDirectionStatus(a2));
    }

    public /* synthetic */ void print(String a2) {
        AbstractPlayerInteraction a3;
        if (a3.ALLATORIxDEMO.getPlayer().isGM()) {
            a3.ALLATORIxDEMO.getPlayer().dropMessage("[Npc_Debug]" + a2);
        }
        System.out.println("[NPC_DEBUG]:" + a2);
    }

    public final /* synthetic */ void AranTutInstructionalBubble(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.AranTutInstructionalBalloon(a2));
    }

    public /* synthetic */ void DisableUI(boolean a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(UIPacket.IntroDisableUI(a2));
    }

    public /* synthetic */ void sendNPCText(String a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getMap().broadcastMessage(MaplePacketCreator.getNPCTalk(a3, (byte)0, a2, SyncServerData.ALLATORIxDEMO(":E*E:"), (byte)0));
    }

    public final /* synthetic */ void endPartyQuest(int a2, List<MapleCharacter> a3) {
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            ((MapleCharacter)a3.next()).endPartyQuest(a2);
            object = a3;
        }
    }

    public /* synthetic */ void processCommand(String a2) {
        AbstractPlayerInteraction a3;
        CommandProcessor.processCommand(a3.getClient(), a2, ServerConstants.CommandType.NORMAL);
    }

    public /* synthetic */ void makeStatsEquip(int a22, short a3, short a4, short a5, short a6, byte a7) {
        AbstractPlayerInteraction a8;
        Equip a22 = a8.ALLATORIxDEMO(a22, a3, a4, a5, a6, a7, "");
        a22.setGMLog(FileoutputUtil.NowTime() + " " + a8.getPlayer().getName());
        MapleInventoryManipulator.addbyItem(a8.getClient(), a22);
    }

    public /* synthetic */ void getMidMsg(String a2, boolean a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.ALLATORIxDEMO.sendPacket(UIPacket.getMidMsg(a2, a3, a4));
    }

    public /* synthetic */ List<IItem> getEquipList() {
        int n2;
        AbstractPlayerInteraction a2;
        MapleInventory mapleInventory = a2.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.EQUIP);
        int n3 = mapleInventory.list().size();
        ArrayList<IItem> arrayList = new ArrayList<IItem>();
        int n4 = n2 = 0;
        while (n4 < n3) {
            if (mapleInventory.getItem((short)n2) != null && !MapleItemInformationProvider.getInstance().isCash(mapleInventory.getItem((short)n2).getItemId())) {
                IEquip iEquip = (IEquip)mapleInventory.getItem((short)n2);
                arrayList.add(mapleInventory.getItem((short)n2));
            }
            n4 = ++n2;
        }
        return arrayList;
    }

    public /* synthetic */ long getServerSet(String a2) {
        return ServerSet.getServerSet(a2);
    }

    public /* synthetic */ void EnableUI(boolean a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(UIPacket.IntroEnableUI(a2));
    }

    public final /* synthetic */ void spawnMob(int a2, int a3, int a4, int a5) {
        AbstractPlayerInteraction a6;
        a6.ALLATORIxDEMO(a2, a3, new Point(a4, a5));
    }

    public final /* synthetic */ boolean canHold(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getPlayer().getInventory(GameConstants.getInventoryType(a2)).getNextFreeSlot() > -1;
    }

    public final /* synthetic */ void givePartyItems(int a2, short a3, List<MapleCharacter> a4) {
        Object object = a4 = a4.iterator();
        while (object.hasNext()) {
            MapleCharacter mapleCharacter;
            MapleCharacter mapleCharacter2 = (MapleCharacter)a4.next();
            if (a3 >= 0) {
                MapleCharacter mapleCharacter3 = mapleCharacter2;
                mapleCharacter = mapleCharacter3;
                MapleInventoryManipulator.addById(mapleCharacter3.getClient(), a2, a3);
            } else {
                MapleCharacter mapleCharacter4 = mapleCharacter2;
                mapleCharacter = mapleCharacter4;
                MapleInventoryManipulator.removeById(mapleCharacter4.getClient(), GameConstants.getInventoryType(a2), a2, -a3, true, false);
            }
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
            object = a4;
        }
    }

    public /* synthetic */ int getChannelOnline() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getChannelServer().getConnectedClients();
    }

    public final /* synthetic */ void guildMessage(int a2, String a3) {
        AbstractPlayerInteraction a4;
        if (a4.getPlayer().getGuildId() > 0) {
            World.Guild.guildPacket(a4.getPlayer().getGuildId(), MaplePacketCreator.broadcastMessage(a2, a3));
        }
    }

    public final /* synthetic */ void spawnMob(int a2, int a3, int a4) {
        AbstractPlayerInteraction a5;
        a5.ALLATORIxDEMO(a2, 1, new Point(a3, a4));
    }

    public /* synthetic */ void enterCS(int a2) {
        AbstractPlayerInteraction a3;
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        abstractPlayerInteraction.getClient().setcs(a2);
        InterServerHandler.EnterCashShop(abstractPlayerInteraction.ALLATORIxDEMO, a3.ALLATORIxDEMO.getPlayer());
    }

    public /* synthetic */ void spawnMonster(int a2) {
        AbstractPlayerInteraction a3;
        a3.spawnMonster(a2, 1, new Point(a3.getPlayer().getPosition()));
    }

    public final /* synthetic */ void gainItem(int a2, short a3, boolean a4, long a5, int a6) {
        AbstractPlayerInteraction a7;
        a7.gainItem(a2, a3, a4, a5, a6, "");
    }

    public final /* synthetic */ EventManager getEventManager(String a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getChannelServer().getEventSM().getEventManager(a2);
    }

    public final /* synthetic */ void forceStartQuest(int a2, int a3) {
        AbstractPlayerInteraction a4;
        MapleNPC mapleNPC = MapleLifeFactory.getNPC(a3);
        if (mapleNPC == null || mapleNPC.getName().equalsIgnoreCase("MISSINGNO")) {
            a4.forceStartQuest(a2, String.valueOf(a3));
            return;
        }
        MapleQuest.getInstance(a2).forceStart(a4.ALLATORIxDEMO.getPlayer(), a3, null);
    }

    public final /* synthetic */ void summonMsg(int a2) {
        AbstractPlayerInteraction a3;
        if (!a3.ALLATORIxDEMO.getPlayer().hasSummon()) {
            a3.playerSummonHint(true);
        }
        a3.getClient().sendPacket(UIPacket.summonMessage(a2));
    }

    public /* synthetic */ void gainPet(int a2, String a3, int a4, int a5, int a6, int a7) {
        AbstractPlayerInteraction a8;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        a8.gainPet(a2, a3, a4, a5, a6, a7, mapleItemInformationProvider.getPetFlagInfo(a2));
    }

    public /* synthetic */ void SystemOutPrintln(String a2) {
        AbstractPlayerInteraction a3;
        if (a3.ALLATORIxDEMO.getPlayer().isGM()) {
            a3.ALLATORIxDEMO.getPlayer().dropMessage("[Npc_Debug]" + a2);
        }
        System.out.println("[NPC_DEBUG]:" + a2);
    }

    public /* synthetic */ void playMovie(String a2, boolean a3) {
        AbstractPlayerInteraction a4;
        a4.ALLATORIxDEMO.sendPacket(UIPacket.playMovie(a2, a3));
    }

    private final /* synthetic */ MapleMap ALLATORIxDEMO(int a2) {
        AbstractPlayerInteraction a3;
        return ChannelServer.getInstance(a3.ALLATORIxDEMO.getWorld(), a3.ALLATORIxDEMO.getChannel()).getMapFactory().getMap(a2);
    }

    public final /* synthetic */ void givePartyExp(int a2, List<MapleCharacter> a3) {
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            AbstractPlayerInteraction a4;
            ((MapleCharacter)a3.next()).gainExp((int)((double)a2 * a4.getClient().getChannelServer().getExpRate(a4.ALLATORIxDEMO.getPlayer().getWorld())), true, true, true);
            object = a3;
        }
    }

    public final /* synthetic */ void openNpc(MapleClient a2, int a3) {
        AbstractPlayerInteraction a4;
        NPCScriptManager.getInstance().dispose(a2);
        a4.openNpc(a2, a3, 0, null);
    }

    public final /* synthetic */ boolean hasSpace(int a2, int a3) {
        AbstractPlayerInteraction a4;
        return a4.ALLATORIxDEMO.getPlayer().getInventory(GameConstants.getInventoryType(a2)).getNumFreeSlot() >= a3;
    }

    public final /* synthetic */ String getQuestInfo(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().getQuestNAdd(MapleQuest.getInstance(a2)).getCustomData();
    }

    public final /* synthetic */ void topMsg(String a2) {
        AbstractPlayerInteraction a3;
        a3.getTopMsg(a2);
    }

    public final /* synthetic */ boolean haveItem(int a2, int a3, boolean a4, boolean a5) {
        AbstractPlayerInteraction a6;
        return a6.getClient().getPlayer().haveItem(a2, a3, a4, a5);
    }

    public final /* synthetic */ boolean canHold(int a2, int a3) {
        AbstractPlayerInteraction a4;
        return MapleInventoryManipulator.checkSpace(a4.ALLATORIxDEMO, a2, a3, "");
    }

    public /* synthetic */ int getMapBossLogReload(String a2) {
        AbstractPlayerInteraction a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getMap() != null) {
            Iterator<MapleCharacter> iterator;
            Iterator<MapleCharacter> iterator2 = iterator = a3.getMap().getAllPlayersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                MapleCharacter mapleCharacter = iterator.next();
                iterator2 = iterator;
                arrayList.add(mapleCharacter.getBossLog(a2));
            }
        } else {
            return a3.getPlayer().getBossLogReload(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public final /* synthetic */ void removeNpc(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().getChannelServer().getMapFactory().getMap(a2).removeNpc(a3);
    }

    public final /* synthetic */ String getInfoQuest(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getPlayer().getInfoQuest(a2);
    }

    public /* synthetic */ int getMP() {
        AbstractPlayerInteraction a2;
        return a2.getPlayer().getMP();
    }

    public final /* synthetic */ int getSkillByJob(MapleCharacter a2, int a3, int a4) {
        return PlayerStats.getSkillByJob(a3, a4);
    }

    public final /* synthetic */ boolean haveItem(int a2, int a3) {
        AbstractPlayerInteraction a4;
        return a4.haveItem(a2, a3, false, true);
    }

    public final /* synthetic */ void endPartyQuest(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getParty() == null || a3.getPlayer().getParty().getMembers().size() == 1) {
            a3.getPlayer().endPartyQuest(a2);
            return;
        }
        for (MaplePartyCharacter maplePartyCharacter : a3.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a3.getMap().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null) continue;
            serializable.endPartyQuest(a2);
        }
    }

    public /* synthetic */ MapleCharacter getChar() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer();
    }

    public /* synthetic */ void gainMeso(int a2) {
        AbstractPlayerInteraction a3;
        if (a2 < 0 && a3.getPlayer().getMeso() + a2 < 0) {
            FileoutputUtil.logToFile_NpcScript_Bug(a3.getPlayer(), " \u542b\u6709 \u6263\u9664\u4e0d\u5920\u6578\u91cf\u7684\u6953\u5e63[" + a2 + "] \u76ee\u524d\u6953\u5e63[" + a3.getPlayer().getMeso() + "] \u4e4b\u6f0f\u6d1e\r\n");
            a3.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2 + a3.getPlayer().getMeso() > Integer.MAX_VALUE) {
            FileoutputUtil.logToFile_NpcScript_Bug(a3.getPlayer(), " \u542b\u6709 \u7d66\u4e88\u904e\u591a\u6953\u5e63[" + a2 + "] \u76ee\u524d\u6953\u5e63[" + a3.getPlayer().getMeso() + "] \u4e4b\u6f0f\u6d1e\r\n");
            a3.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getClient().getPlayer().gainMeso(a2, true, false, true);
    }

    public final /* synthetic */ void destroyReactor(int a22, int a3) {
        AbstractPlayerInteraction a4;
        Iterator<MapleReactor> iterator = a4.getClient().getChannelServer().getMapFactory().getMap(a22).getAllReactorsThreadsafe().iterator();
        while (iterator.hasNext()) {
            MapleReactor a22 = (MapleReactor)((MapleMapObject)iterator.next());
            if (a22.getReactorId() != a3) continue;
            a22.hitReactor(a4.ALLATORIxDEMO);
            return;
        }
    }

    public final /* synthetic */ int PlayerCount(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getChannelServer().getMapFactory().getMap(a2).getCharactersSize();
    }

    public final /* synthetic */ void gainItem(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, String a18) {
        AbstractPlayerInteraction a19;
        a19.gainItemS(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, -1, a19.ALLATORIxDEMO, -1L, a18);
    }

    public /* synthetic */ void setSkillMap(int a2, int a3) {
        AbstractPlayerInteraction a4;
        a4.ALLATORIxDEMO.sendPacket(MaplePacketCreator.setSkillMap(a2, a3));
    }

    public final /* synthetic */ void warpPQsPortal(int a2, int a3) {
        AbstractPlayerInteraction a4;
        Object object = a4.ALLATORIxDEMO(a2);
        object = new Point(a4.ALLATORIxDEMO.getPlayer().getMap().getPortal(a3).getPosition());
        if (a3 != 0 && a2 == a4.getClient().getPlayer().getMapId()) {
            AbstractPlayerInteraction abstractPlayerInteraction = a4;
            abstractPlayerInteraction.getClient().sendPacket(MaplePacketCreator.instantMapWarp((byte)a3));
            abstractPlayerInteraction.getClient().getPlayer().getMap().movePlayer(a4.ALLATORIxDEMO.getPlayer(), (Point)object);
        }
    }

    public final /* synthetic */ void gainItemAdd(int a2, short a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, int a17, MapleClient a18, int a19) {
        AbstractPlayerInteraction a20;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            Object object2 = GameConstants.getInventoryType(a2);
            if (!GameSetConstants.STORAGE_EXCEED && !MapleInventoryManipulator.checkSpace(a18, a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a20.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a20.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (((Enum)object2).equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                Object object3;
                object2 = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                object = ((MapleItemInformationProvider)object).getName(a2);
                if (a2 / 10000 == 114 && object != null && ((String)object).length() > 0) {
                    object3 = "\u4f60\u5df2\u7372\u5f97\u7a31\u865f <" + (String)object + ">";
                    MapleClient mapleClient = a18;
                    mapleClient.getPlayer().dropMessage(-1, (String)object3);
                    mapleClient.getPlayer().dropMessage(5, (String)object3);
                }
                if (a19 >= 0) {
                    ((Item)object2).setExpiration(System.currentTimeMillis() + (long)(a19 * 60 * 60 * 1000));
                }
                if (a4 >= 0) {
                    Object object4 = object2;
                    object3 = (short)(((Equip)object4).getStr() + a4);
                    ((Equip)object4).setStr((Short)object3);
                }
                if (a5 >= 0) {
                    Object object5 = object2;
                    object3 = (short)(((Equip)object5).getDex() + a5);
                    ((Equip)object5).setDex((Short)object3);
                }
                if (a6 >= 0) {
                    Object object6 = object2;
                    object3 = (short)(((Equip)object6).getLuk() + a6);
                    ((Equip)object6).setLuk((Short)object3);
                }
                if (a7 >= 0) {
                    Object object7 = object2;
                    object3 = (short)(((Equip)object7).getInt() + a7);
                    ((Equip)object7).setInt((Short)object3);
                }
                if (a8 >= 0) {
                    Object object8 = object2;
                    object3 = (short)(((Equip)object8).getHp() + a8);
                    ((Equip)object8).setHp((Short)object3);
                }
                if (a9 >= 0) {
                    Object object9 = object2;
                    object3 = (short)(((Equip)object9).getMp() + a9);
                    ((Equip)object9).setMp((Short)object3);
                }
                if (a10 >= 0) {
                    Object object10 = object2;
                    object3 = (short)(((Equip)object10).getWatk() + a10);
                    ((Equip)object10).setWatk((Short)object3);
                }
                if (a11 >= 0) {
                    Object object11 = object2;
                    object3 = (short)(((Equip)object11).getMatk() + a11);
                    ((Equip)object11).setMatk((Short)object3);
                }
                if (a12 >= 0) {
                    Object object12 = object2;
                    object3 = (short)(((Equip)object12).getWdef() + a12);
                    ((Equip)object12).setWdef((Short)object3);
                }
                if (a13 >= 0) {
                    Object object13 = object2;
                    object3 = (short)(((Equip)object13).getMdef() + a13);
                    ((Equip)object13).setMdef((Short)object3);
                }
                if (a14 >= 0) {
                    Object object14 = object2;
                    object3 = (short)(((Equip)object14).getAvoid() + a14);
                    ((Equip)object14).setAvoid((Short)object3);
                }
                if (a15 >= 0) {
                    Object object15 = object2;
                    object3 = (short)(((Equip)object15).getAcc() + a15);
                    ((Equip)object15).setAcc((Short)object3);
                }
                if (a16 >= 0) {
                    Object object16 = object2;
                    object3 = (short)(((Equip)object16).getJump() + a16);
                    ((Equip)object16).setJump((Short)object3);
                }
                if (a17 >= 0) {
                    Object object17 = object2;
                    object3 = (short)(((Equip)object17).getSpeed() + a17);
                    ((Equip)object17).setSpeed((Short)object3);
                }
                MapleInventoryManipulator.addbyItem(a18, ((Equip)object2).copy());
            } else {
                MapleInventoryManipulator.addById(a18, a2, a3, "");
            }
        } else {
            if (!a20.getPlayer().haveItem(a2, Math.abs(a3))) {
                FileoutputUtil.logToFile_NpcScript_Bug(a20.getPlayer(), " \u542b\u6709 \u6263\u9664\u4e0d\u5b58\u5728\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "] \u4e4b\u6f0f\u6d1e\r\n");
                a20.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleInventoryManipulator.removeById(a18, GameConstants.getInventoryType(a2), a2, -a3, true, false);
        }
        a18.sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public final /* synthetic */ void gainCloseness(int a2, int a32) {
        AbstractPlayerInteraction a4;
        MaplePet a32 = a4.getPlayer().getPet(a32);
        if (a32 != null) {
            MaplePet maplePet = a32;
            maplePet.setCloseness(maplePet.getCloseness() + a2);
            MaplePet maplePet2 = a32;
            a4.getClient().sendPacket(PetPacket.updatePet(maplePet2, a4.getPlayer().getInventory(MapleInventoryType.CASH).getItem((byte)maplePet2.getInventoryPosition()), true));
        }
    }

    public /* synthetic */ void spawnMonster(int a2, int a3, Point a4) {
        AbstractPlayerInteraction a5;
        if (MapleLifeFactory.getMonster(a2) != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a5.getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), a4);
                n3 = ++n2;
            }
        } else if (a5.getPlayer() != null && a5.getPlayer().isStaff()) {
            a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public final /* synthetic */ EventInstanceManager getEventInstance() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getEventInstance();
    }

    public final /* synthetic */ void spawnMobOnMap(int a2, int a3, int a4, int a5, int a6) {
        AbstractPlayerInteraction a7;
        if (MapleLifeFactory.getMonster(a2) != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a7.getMap(a6).spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), new Point(a4, a5));
                n3 = ++n2;
            }
        } else if (a7.getPlayer() != null && a7.getPlayer().isStaff()) {
            a7.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a7.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public /* synthetic */ void spawnNpc(int a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().getPlayer().getMap().spawnNpc(a2, a3.getClient().getPlayer().getPosition());
    }

    public final /* synthetic */ void warpS(int a2, int a3) {
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleMap mapleMap = a2 = abstractPlayerInteraction.ALLATORIxDEMO(a2);
        abstractPlayerInteraction.getClient().getPlayer().changeMap(mapleMap, mapleMap.getPortal(a3));
    }

    public /* synthetic */ void spawnMonster(MapleMonster a2, int a3, Point a4) {
        AbstractPlayerInteraction a5;
        if (a2 != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a5.getMap().spawnMonsterOnGroundBelow(a2, a4);
                n3 = ++n2;
            }
        } else if (a5.getPlayer() != null && a5.getPlayer().isStaff()) {
            a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2.getId() + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2.getId() + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public final /* synthetic */ void showQuestMsg(String a2) {
        AbstractPlayerInteraction a3;
        a3.getClient().sendPacket(MaplePacketCreator.showQuestMsg(a2));
    }

    public final /* synthetic */ void removeFromParty(int a2) {
        AbstractPlayerInteraction a3;
        a3.givePartyItems(a2, (short)0, true);
    }

    public final /* synthetic */ void gainItem(int a2) {
        AbstractPlayerInteraction a3;
        a3.gainItem(a2, (short)1, false, 0L, -1, "");
    }

    public /* synthetic */ void getDayLog(String a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().getDayLog(a2);
    }

    public final /* synthetic */ boolean hasSpace(int a2) {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 5) {
            AbstractPlayerInteraction a3;
            if (a3.ALLATORIxDEMO.getPlayer().getInventory(MapleInventoryType.getByType((byte)n2)).getNumFreeSlot() <= a2) {
                return false;
            }
            n3 = ++n2;
        }
        return true;
    }

    public final /* synthetic */ MapleGuild getGuild() {
        AbstractPlayerInteraction a2;
        AbstractPlayerInteraction abstractPlayerInteraction = a2;
        return abstractPlayerInteraction.getGuild(abstractPlayerInteraction.getPlayer().getGuildId());
    }

    public final /* synthetic */ void gainItem(int a2, short a3, boolean a4, long a5, int a6, String a7) {
        AbstractPlayerInteraction a8;
        a8.gainItem(a2, a3, a4, a5, a6, a7, a8.ALLATORIxDEMO);
    }

    public final /* synthetic */ void removeFromParty(int a2, List<MapleCharacter> a3) {
        a3 = a3.iterator();
        while (a3.hasNext()) {
            AbstractPlayerInteraction a4;
            MapleCharacter mapleCharacter = (MapleCharacter)a3.next();
            int n2 = mapleCharacter.getInventory(GameConstants.getInventoryType(a2)).countById(a2);
            if (n2 <= 0) continue;
            MapleInventoryManipulator.removeById(a4.ALLATORIxDEMO, GameConstants.getInventoryType(a2), a2, n2, true, false);
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.getShowItemGain(a2, (short)(-n2), true));
        }
    }

    public final /* synthetic */ void givePartyItems(int a2, short a3, boolean a4) {
        AbstractPlayerInteraction a5;
        if (a5.getPlayer().getParty() == null || a5.getPlayer().getParty().getMembers().size() == 1) {
            a5.gainItem(a2, (short)(a4 ? -a5.getPlayer().itemQuantity(a2) : a3));
            return;
        }
        Iterator<MaplePartyCharacter> iterator = a5.getPlayer().getParty().getMembers().iterator();
        while (iterator.hasNext()) {
            MapleCharacter mapleCharacter = MapleCharacter.getOnlineCharacterById(iterator.next().getId());
            if (mapleCharacter == null) continue;
            mapleCharacter.gainItem(a2, (short)(a4 ? -mapleCharacter.itemQuantity(a2) : a3));
        }
    }

    public final /* synthetic */ void warpParty(int a222) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getParty() == null || a3.getPlayer().getParty().getMembers().size() == 1) {
            a3.warp(a222, 0);
            return;
        }
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        MapleMap a222 = abstractPlayerInteraction.getMap(a222);
        int n2 = abstractPlayerInteraction.getPlayer().getMapId();
        for (MaplePartyCharacter maplePartyCharacter : abstractPlayerInteraction.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a3.getChannelServer().getPlayerStorage().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null || serializable.getMapId() != n2 && serializable.getEventInstance() != a3.getPlayer().getEventInstance()) continue;
            MapleMap mapleMap = a222;
            serializable.changeMap(mapleMap, mapleMap.getPortal(0));
        }
    }

    public /* synthetic */ void warpAllPlayer(int a22, int a32) {
        AbstractPlayerInteraction a4;
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        MapleMap a32 = abstractPlayerInteraction.getMapFactory().getMap(a32);
        Object a22 = abstractPlayerInteraction.getMapFactory().getMap(a22);
        List<MapleCharacter> list = ((MapleMap)a22).getCharactersThreadsafe();
        if (a32 != null && a22 != null && list != null && ((MapleMap)a22).getCharactersSize() > 0) {
            Object object = a22 = list.iterator();
            while (object.hasNext()) {
                MapleMap mapleMap = a32;
                ((MapleCharacter)((MapleMapObject)a22.next())).changeMap(mapleMap, mapleMap.getPortal(0));
                object = a22;
            }
        }
    }

    public final /* synthetic */ MapleClient getClient() {
        AbstractPlayerInteraction a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void playerSummonHint(boolean a2) {
        AbstractPlayerInteraction a3;
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        abstractPlayerInteraction.getClient().getPlayer().setHasSummon(a2);
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.summonHelper(a2));
    }

    public final /* synthetic */ void warpParty_Instanced(int a222) {
        AbstractPlayerInteraction a3;
        if (a3.getPlayer().getParty() == null || a3.getPlayer().getParty().getMembers().size() == 1) {
            a3.warp_Instanced(a222);
            return;
        }
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        MapleMap a222 = abstractPlayerInteraction.getMap_Instanced(a222);
        int n2 = abstractPlayerInteraction.getPlayer().getMapId();
        for (MaplePartyCharacter maplePartyCharacter : abstractPlayerInteraction.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a3.getChannelServer().getPlayerStorage().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null || serializable.getMapId() != n2 && serializable.getEventInstance() != a3.getPlayer().getEventInstance()) continue;
            MapleMap mapleMap = a222;
            serializable.changeMap(mapleMap, mapleMap.getPortal(0));
        }
    }

    public /* synthetic */ void setPartyBossLog(String a2) {
        AbstractPlayerInteraction a3;
        for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
            if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
            a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()).setBossLog(a2);
        }
    }

    public /* synthetic */ void resetTemporaryStats() {
        AbstractPlayerInteraction a2;
        a2.getClient().sendPacket(MaplePacketCreator.temporaryStats_Reset());
    }

    public /* synthetic */ void setBossLog(String a2) {
        AbstractPlayerInteraction a3;
        a3.getPlayer().setBossLog(a2);
    }

    public /* synthetic */ int randInt(int a2) {
        return Randomizer.nextInt(a2);
    }

    public final /* synthetic */ int getJob() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getJob();
    }

    public final /* synthetic */ int getPlayerCount(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getChannelServer().getMapFactory().getMap(a2).getCharactersSize();
    }

    public /* synthetic */ boolean itemExists(int a2) {
        return MapleItemInformationProvider.getInstance().itemExists(a2);
    }

    public /* synthetic */ void lockUI() {
        AbstractPlayerInteraction a2;
        AbstractPlayerInteraction abstractPlayerInteraction = a2;
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.IntroDisableUI(true));
        abstractPlayerInteraction.getClient().sendPacket(UIPacket.IntroLock(true));
    }

    public /* synthetic */ int getOneTimeLog(String a2) {
        AbstractPlayerInteraction a3;
        return a3.getPlayer().getOneTimeLog(a2);
    }

    public /* synthetic */ int seeTouzhuByType(int a2) {
        return CustomEventFactory.getInstance().getLottery().getTouNumbyType(a2);
    }

    public final /* synthetic */ MapleQuestStatus getQuestRecord(int a2) {
        AbstractPlayerInteraction a3;
        return a3.getClient().getPlayer().getQuestNAdd(MapleQuest.getInstance(a2));
    }

    public /* synthetic */ String getItemName(int a2) {
        return MapleItemInformationProvider.getInstance().getName(a2);
    }

    public final /* synthetic */ int getEnhanceSkillLevel() {
        AbstractPlayerInteraction abstractPlayerInteraction;
        AbstractPlayerInteraction a2;
        short s2 = 0;
        s2 = a2.ALLATORIxDEMO.getPlayer().getJob();
        int n2 = 0;
        if (MapleJob.is\u5192\u96aa\u5bb6(s2)) {
            n2 = 1007;
            abstractPlayerInteraction = a2;
        } else if (MapleJob.is\u7687\u5bb6\u9a0e\u58eb\u5718(s2)) {
            n2 = 10001007;
            abstractPlayerInteraction = a2;
        } else if (MapleJob.is\u72c2\u72fc\u52c7\u58eb(s2)) {
            n2 = 20001007;
            abstractPlayerInteraction = a2;
        } else {
            if (MapleJob.is\u9f8d\u9b54\u5c0e\u58eb(s2)) {
                n2 = 20011007;
            }
            abstractPlayerInteraction = a2;
        }
        return abstractPlayerInteraction.ALLATORIxDEMO.getPlayer().getSkillLevel(SkillFactory.getSkill(n2));
    }

    public /* synthetic */ void addPartyTrait(String a2, int a3) {
        AbstractPlayerInteraction a4;
        if (a4.getPlayer().getParty() == null || a4.getPlayer().getParty().getMembers().size() == 1) {
            a4.addTrait(a2, a3);
            return;
        }
        AbstractPlayerInteraction abstractPlayerInteraction = a4;
        int n2 = abstractPlayerInteraction.getPlayer().getMapId();
        for (MaplePartyCharacter maplePartyCharacter : abstractPlayerInteraction.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a4.getChannelServer().getPlayerStorage().getCharacterById(maplePartyCharacter.getId());
            if (serializable == null || serializable.getMapId() != n2 && serializable.getEventInstance() != a4.getPlayer().getEventInstance()) continue;
            serializable.getTrait(MapleTrait.MapleTraitType.valueOf(a2)).addExp(a3, serializable);
        }
    }

    public final /* synthetic */ boolean canChangeName(String a2) {
        return MapleCharacter.getCharacterByName(a2) == null;
    }

    public /* synthetic */ void UseMagnify(IItem a2, IItem a3) {
        AbstractPlayerInteraction a4;
        InventoryHandler.UseMagnify((byte)a3.getPosition(), (byte)a2.getPosition(), a4.ALLATORIxDEMO);
    }

    public final /* synthetic */ void mapMessage(int a2, String a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().getPlayer().getMap().broadcastMessage(MaplePacketCreator.broadcastMessage(a2, a3));
    }

    public final /* synthetic */ void disableOthers(boolean a2) {
        AbstractPlayerInteraction a3;
        a3.ALLATORIxDEMO.sendPacket(UIPacket.disableOthers(a2));
    }

    public final /* synthetic */ int getSkillLevel(MapleCharacter a2, int a3, int a4) {
        return a2.getSkillLevel(PlayerStats.getSkillByJob(a3, a4));
    }

    public final /* synthetic */ int dojo_getPts() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer().getDojo();
    }

    public /* synthetic */ void setPartyAcLog(String a2) {
        AbstractPlayerInteraction a3;
        for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
            if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
            a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()).setAcLog(a2);
        }
    }

    public final /* synthetic */ MapleCharacter getPlayer() {
        AbstractPlayerInteraction a2;
        return a2.getClient().getPlayer();
    }

    public final /* synthetic */ void gainItemFlag(int a2, short a3, long a4, int a5) {
        AbstractPlayerInteraction a6;
        a6.gainItem(a2, a3, false, a4, -1, "", a6.ALLATORIxDEMO, a5);
    }

    public final /* synthetic */ void gainClosenessAll(int a2) {
        AbstractPlayerInteraction a3;
        for (MaplePet maplePet : a3.getPlayer().getPets()) {
            if (maplePet == null) continue;
            MaplePet maplePet2 = maplePet;
            maplePet2.setCloseness(maplePet2.getCloseness() + a2);
            MaplePet maplePet3 = maplePet;
            a3.getClient().sendPacket(PetPacket.updatePet(maplePet3, a3.getPlayer().getInventory(MapleInventoryType.CASH).getItem((byte)maplePet3.getInventoryPosition()), true));
        }
    }

    public final /* synthetic */ void gainItemMinute(int a2, short a3, int a4) {
        AbstractPlayerInteraction a5;
        if (a3 >= 0) {
            Object object = MapleItemInformationProvider.getInstance();
            MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a2);
            if (!MapleInventoryManipulator.checkSpace(a5.getClient(), a2, a3, "") && a3 > 0) {
                FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), " \u542b\u6709 \u80cc\u5305\u7a7a\u9593\u4e0d\u5920\u7372\u5f97\u9053\u5177[" + a2 + "] \u6578\u91cf[" + a3 + "]\u4e4b\u6f0f\u6d1e\r\n");
                a5.ALLATORIxDEMO.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (mapleInventoryType.equals((Object)MapleInventoryType.EQUIP) && !GameConstants.isThrowingStar(a2) && !GameConstants.isBullet(a2)) {
                object = (Equip)((MapleItemInformationProvider)object).getEquipById(a2);
                if (a4 > 0) {
                    ((Item)object).setExpiration(System.currentTimeMillis() + (long)(a4 * 60 * 1000));
                }
                MapleInventoryManipulator.addbyItem(a5.getClient(), ((Equip)object).copy());
            }
        }
        a5.getClient().sendPacket(MaplePacketCreator.getShowItemGain(a2, a3, true));
    }

    public final /* synthetic */ void playerMessage(int a2, String a3) {
        AbstractPlayerInteraction a4;
        a4.getClient().sendPacket(MaplePacketCreator.broadcastMessage(a2, a3));
    }

    public final /* synthetic */ MapleMap getMap_Instanced(int a2) {
        AbstractPlayerInteraction a3;
        if (a3.getClient().getPlayer().getEventInstance() == null) {
            return a3.getMap(a2);
        }
        return a3.getClient().getPlayer().getEventInstance().getMapInstance(a2);
    }

    public /* synthetic */ String goback(int a2) {
        AbstractPlayerInteraction a3;
        long l2 = System.currentTimeMillis() - a3.getofflinetime();
        if (a2 == 105100300 && a3.getMap(105100300).getMonsterById(8830007) == null && a3.getMap(105100300).getMonsterById(8830001) == null && a3.getMap(105100300).getMonsterById(8830002) == null) {
            return MapleFoothold.ALLATORIxDEMO("\u9b04\u73d7\u5da4\u6d47\u53b4\u5dae\u6b2b\u305e\u8a9b\u9191\u65e0\u539f\u52f0\u903c\u5fd1\u96d6\u53bc\u55c6\u7230\u305e");
        }
        if (a2 != a3.getofflinemap()) {
            return "#b\u60a8\u6240\u65b7\u7dda\u7684\u5730\u5716\u975e\u6b64\u5730\u5716!\r\n\u60a8\u65b7\u7dda\u7684\u5730\u5716\u70ba#r#m" + a3.getofflinemap() + "##k";
        }
        if (a3.getofflinechannel() != a3.ALLATORIxDEMO.getPlayer().getClient().getChannel()) {
            return "#b\u4f60\u4e26\u975e\u5f9e\u6b64\u983b\u9053\u5730\u5716\u65b7\u7dda \r\n#b\u60a8\u65b7\u7dda\u7684\u983b\u9053\u70ba#r" + a3.getofflinechannel() + "\u983b#k";
        }
        AbstractPlayerInteraction abstractPlayerInteraction = a3;
        abstractPlayerInteraction.warp(abstractPlayerInteraction.getofflinemap());
        return SyncServerData.ALLATORIxDEMO("\u5d87\u900b\u60dd\u56d4\u53ce\u65bd\u7daf\u573a\u5763+");
    }

    public /* synthetic */ boolean touzhu(int a2, int a3, int a4) {
        boolean bl = false;
        if (a3 >= 1) {
            AbstractPlayerInteraction a5;
            Lottery lottery = CustomEventFactory.getInstance().getLottery();
            AbstractPlayerInteraction abstractPlayerInteraction = a5;
            abstractPlayerInteraction.getPlayer().setTouzhuType(a2);
            abstractPlayerInteraction.getPlayer().setTouzhuNX(a3);
            abstractPlayerInteraction.getPlayer().setTouzhuNum(a4);
            abstractPlayerInteraction.getPlayer().modifyCSPoints(1, -a3);
            lottery.addChar(abstractPlayerInteraction.getPlayer());
            bl = true;
            return true;
        }
        bl = false;
        return false;
    }
}

