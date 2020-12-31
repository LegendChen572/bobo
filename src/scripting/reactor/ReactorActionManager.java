/*
 * Decompiled with CFR 0.150.
 */
package scripting.reactor;

import client.MapleClient;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import handling.channel.ChannelServer;
import handling.world.MaplePartyCharacter;
import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import scripting.AbstractPlayerInteraction;
import scripting.reactor.ReactorScriptManager;
import server.MapleCarnivalFactory;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.maps.MapleReactor;
import server.maps.ReactorDropEntry;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;

public class ReactorActionManager
extends AbstractPlayerInteraction {
    private final /* synthetic */ MapleReactor ALLATORIxDEMO;

    public /* synthetic */ MapleReactor getReactor() {
        ReactorActionManager a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ ReactorActionManager(MapleClient a2, MapleReactor a3) {
        super(a2);
        ReactorActionManager a4;
        a4.ALLATORIxDEMO = a3;
        if (a2.getPlayer() != null) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().setReactorNow(a3.getReactorId());
            mapleClient.getPlayer().setReactor(a3);
        }
    }

    public /* synthetic */ void spawnFakeMonster(int a2) {
        ReactorActionManager a3;
        ReactorActionManager reactorActionManager = a3;
        reactorActionManager.ALLATORIxDEMO(a2, 1, reactorActionManager.getPosition());
    }

    @Override
    public /* synthetic */ void spawnMonster(int a2, int a3, int a4) {
        ReactorActionManager a5;
        if (MapleLifeFactory.getMonster(a2) != null) {
            a5.ALLATORIxDEMO.getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), new Point(a3, a4));
            return;
        }
        if (a5.getPlayer() != null && a5.getPlayer().isStaff()) {
            a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    @Override
    public /* synthetic */ void spawnMonster(int a2) {
        ReactorActionManager a3;
        if (a3.getPlayer() != null && MapleLifeFactory.getMonster(a2) == null) {
            FileoutputUtil.logToFile_ReactorScript_Bug(a3.getPlayer(), " \u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
            if (a3.getPlayer().isStaff()) {
                a3.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
                return;
            }
        } else {
            a3.spawnMonster(a2, 1, a3.getPosition());
        }
    }

    public /* synthetic */ void spawnZakum() {
        ReactorActionManager a2;
        a2.ALLATORIxDEMO.getMap().spawnZakum(a2.getPosition().x, a2.getPosition().y);
    }

    public /* synthetic */ void dropItems(boolean a2, int a3, int a4, int a5) {
        ReactorActionManager a6;
        a6.dropItems(a2, a3, a4, a5, 0);
    }

    public /* synthetic */ void dropItems() {
        ReactorActionManager a2;
        a2.dropItems(0 != 0, 0, 0, 0, 0);
    }

    public /* synthetic */ void dropItems(boolean a22, int a3, int a4, int a5, int a62) {
        Object object;
        ReactorActionManager a7;
        Object object2 = ReactorScriptManager.getInstance().getDrops(a7.ALLATORIxDEMO.getReactorId());
        Object object3 = new LinkedList<Object>();
        if (a22 && Math.random() < 1.0 / (double)a3) {
            object3.add(new ReactorDropEntry(0, a3, -1));
        }
        a22 = false;
        Object object4 = object2.iterator();
        while (object4.hasNext()) {
            object = object4.next();
            if (!(Math.random() < 1.0 / (double)((ReactorDropEntry)object).chance) || ((ReactorDropEntry)object).questid > 0 && a7.getPlayer().getQuestStatus(((ReactorDropEntry)object).questid) != 1) continue;
            a22 += 1;
            object3.add(object);
        }
        LinkedList<Object> linkedList = object3;
        while (linkedList.size() < a62) {
            LinkedList<Object> linkedList2 = object3;
            linkedList = linkedList2;
            a22 += 1;
            linkedList2.add(new ReactorDropEntry(0, a3, -1));
        }
        if (a7.getPlayer() != null && a7.getPlayer().isHarversting() && (object = a7.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((short)a7.getPlayer().getStat().harvestingTool)) != null) {
            int n2;
            a3 = 0;
            switch (object.getItemId()) {
                case 1512001: {
                    n2 = a3 += 2;
                    break;
                }
                case 1502004: 
                case 1512004: 
                case 1512005: {
                    n2 = a3 += 3;
                    break;
                }
                case 1502001: 
                case 1502005: 
                case 1502006: 
                case 1512006: {
                    a3 += 5;
                    while (false) {
                    }
                }
                default: {
                    n2 = a3;
                }
            }
            if (n2 > 0) {
                while (a3 > 0) {
                    if (!object4.hasNext()) {
                        object4 = object2.iterator();
                    }
                    ReactorDropEntry a62 = object4.next();
                    if (!(Math.random() < 1.0 / (double)a62.chance) || a62.questid > 0 && a7.getPlayer().getQuestStatus(a62.questid) != 1) continue;
                    a22 += 1;
                    --a3;
                    object3.add(a62);
                }
            }
        }
        object = a7.ALLATORIxDEMO.getPosition();
        ((Point)object).x -= 12 * a22;
        MapleItemInformationProvider a22 = MapleItemInformationProvider.getInstance();
        Object object5 = object2 = object3.iterator();
        while (object5.hasNext()) {
            Object object6;
            object3 = (ReactorDropEntry)object2.next();
            if (((ReactorDropEntry)object3).itemId == 0) {
                a3 = a5 - a4;
                int a62 = Randomizer.nextInt(a3) + a4 * ChannelServer.getInstance(a7.getClient().getWorld(), a7.getClient().getChannel()).getMesoRate(a7.getClient().getPlayer().getWorld());
                Object object7 = object;
                object6 = object7;
                a7.ALLATORIxDEMO.getMap().spawnMesoDrop(a62, (Point)object7, a7.ALLATORIxDEMO, a7.getPlayer(), 0 != 0, (byte)0);
            } else {
                ReactorActionManager reactorActionManager;
                if (GameConstants.getInventoryType(((ReactorDropEntry)object3).itemId) != MapleInventoryType.EQUIP) {
                    object4 = new Item(((ReactorDropEntry)object3).itemId, 0, 1, 0);
                    reactorActionManager = a7;
                } else {
                    MapleItemInformationProvider mapleItemInformationProvider = a22;
                    object4 = mapleItemInformationProvider.randomizeStats((Equip)mapleItemInformationProvider.getEquipById(((ReactorDropEntry)object3).itemId));
                    reactorActionManager = a7;
                }
                reactorActionManager.ALLATORIxDEMO.getMap().spawnItemDrop(a7.ALLATORIxDEMO, a7.getPlayer(), (IItem)object4, (Point)object, false, false);
                object6 = object;
            }
            ((Point)object6).x += 25;
            object5 = object2;
        }
    }

    public /* synthetic */ void spawnFakeMonster(int a2, int a3) {
        ReactorActionManager a4;
        ReactorActionManager reactorActionManager = a4;
        reactorActionManager.ALLATORIxDEMO(a2, a3, reactorActionManager.getPosition());
    }

    public /* synthetic */ void dispelAllMonsters(int a22) {
        MapleCarnivalFactory.MCSkill a22 = MapleCarnivalFactory.getInstance().getGuardian(a22);
        if (a22 != null) {
            ReactorActionManager a3;
            Iterator<MapleMonster> iterator;
            Iterator<MapleMonster> iterator2 = iterator = a3.getMap().getAllMonstersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                iterator.next().dispelSkill(a22.getMobSkill());
                iterator2 = iterator;
            }
        }
    }

    public /* synthetic */ void killMonster(int a2) {
        ReactorActionManager a3;
        a3.ALLATORIxDEMO.getMap().killMonster(a2);
    }

    @Override
    public /* synthetic */ void spawnMonster(MapleMonster a2, int a3, Point a4) {
        ReactorActionManager a5;
        if (a2 != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a5.ALLATORIxDEMO.getMap().spawnMonsterOnGroundBelow(a2, a4);
                n3 = ++n2;
            }
        } else if (a5.getPlayer() != null && a5.getPlayer().isStaff()) {
            a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2.getId() + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2.getId() + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public /* synthetic */ void spawnFakeMonster(int a2, int a3, int a4, int a5) {
        ReactorActionManager a6;
        a6.ALLATORIxDEMO(a2, a3, new Point(a4, a5));
    }

    public /* synthetic */ void spawnFakeMonster(int a2, int a3, int a4) {
        ReactorActionManager a5;
        a5.ALLATORIxDEMO(a2, 1, new Point(a3, a4));
    }

    public /* synthetic */ void doHarvest() {
        ReactorActionManager reactorActionManager;
        int n2;
        int n3;
        String string;
        int n4;
        ReactorActionManager a2;
        block11: {
            block13: {
                block12: {
                    block10: {
                        int n5;
                        if (a2.getPlayer().getFatigue() >= 200 || a2.getPlayer().getStat().harvestingTool <= 0 || a2.getReactor().getTruePosition().distanceSq(a2.getPlayer().getTruePosition()) > 10000.0) {
                            return;
                        }
                        n4 = a2.getReactor().getReactorId() < 200000 ? 92000000 : 92010000;
                        string = a2.getReactor().getReactorId() < 200000 ? MaplePacketOperation.ALLATORIxDEMO("\u6381\u85a0") : MaplePartyCharacter.ALLATORIxDEMO("\u639f\u7920");
                        n3 = a2.getPlayer().getProfessionLevel(n4);
                        if (n3 <= 0) {
                            return;
                        }
                        IItem iItem = a2.getInventory(1).getItem((short)a2.getPlayer().getStat().harvestingTool);
                        if (iItem == null || iItem.getItemId() / 10000 != (a2.getReactor().getReactorId() < 200000 ? 150 : 151)) {
                            return;
                        }
                        ReactorActionManager reactorActionManager2 = a2;
                        n2 = reactorActionManager2.getReactor().getReactorId() % 100;
                        int n6 = 90 + (n3 - n2) * 10;
                        if (reactorActionManager2.getReactor().getReactorId() % 100 == 10) {
                            n2 = 1;
                            n5 = n6 = 100;
                        } else {
                            if (a2.getReactor().getReactorId() % 100 == 11) {
                                n6 -= 40;
                                n2 = 10;
                            }
                            n5 = n6;
                        }
                        if (n5 < 0) {
                            n6 = 0;
                        }
                        ReactorActionManager reactorActionManager3 = a2;
                        reactorActionManager3.getPlayer().getStat().checkEquipDurabilitys(a2.getPlayer(), -1, true);
                        n3 = (n2 - n3) * 2 + 20;
                        int n7 = n2 = reactorActionManager3.randInt(100) < n6 ? 1 : 0;
                        if (n2 != 0) break block10;
                        n3 /= 10;
                        ReactorActionManager reactorActionManager4 = a2;
                        reactorActionManager4.dropSingleItem(reactorActionManager4.getReactor().getReactorId() < 200000 ? 4022023 : 4011010);
                        reactorActionManager = a2;
                        break block11;
                    }
                    ReactorActionManager reactorActionManager5 = a2;
                    reactorActionManager5.dropItems();
                    if (reactorActionManager5.getReactor().getReactorId() >= 200000) break block12;
                    a2.addTrait(MaplePacketOperation.ALLATORIxDEMO("\u6d5b\u5bff\u52de"), 5);
                    if (Randomizer.nextInt(10) == 0) {
                        a2.dropSingleItem(2440000);
                    }
                    if (Randomizer.nextInt(100) != 0) break block13;
                    ReactorActionManager reactorActionManager6 = a2;
                    reactorActionManager = reactorActionManager6;
                    reactorActionManager6.dropSingleItem(4032933);
                    break block11;
                }
                a2.addTrait(MaplePartyCharacter.ALLATORIxDEMO("\u6d18\u5be1\u529d"), 5);
                if (Randomizer.nextInt(10) == 0) {
                    a2.dropSingleItem(2440001);
                }
            }
            reactorActionManager = a2;
        }
        reactorActionManager.cancelHarvest(n2 != 0);
        a2.playerMessage(-5, string + "'\u7684\u719f\u7df4\u5ea6\u63d0\u9ad8\u4e86\u3002(+" + n3 + ")");
        if (a2.getPlayer().addProfessionExp(n4, n3)) {
            a2.playerMessage(-5, string + " \u7684\u7b49\u7d1a\u63d0\u5347\u4e86\u3002");
        }
    }

    @Override
    public /* synthetic */ void spawnMonster(int a2, int a3) {
        ReactorActionManager a4;
        if (a4.getPlayer() != null && MapleLifeFactory.getMonster(a2) == null) {
            FileoutputUtil.logToFile_ReactorScript_Bug(a4.getPlayer(), " \u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
            if (a4.getPlayer().isStaff()) {
                a4.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
                return;
            }
        } else {
            a4.spawnMonster(a2, a3, a4.getPosition());
        }
    }

    public /* synthetic */ void dropSingleItem(int a2) {
        ReactorActionManager a3;
        Item item2;
        Item item3;
        if (GameConstants.getInventoryType(a2) != MapleInventoryType.EQUIP) {
            item3 = new Item(a2, 0, 1, 0);
            item2 = item3;
        } else {
            item3 = MapleItemInformationProvider.getInstance().randomizeStats((Equip)MapleItemInformationProvider.getInstance().getEquipById(a2));
            item2 = item3;
        }
        item2.setGMLog("\u5f9e\u53cd\u61c9\u7269 " + a3.ALLATORIxDEMO.getReactorId() + "\u4e2d\u6389\u843d \u5730\u5716: " + a3.getPlayer().getMapId());
        a3.ALLATORIxDEMO.getMap().spawnItemDrop(a3.ALLATORIxDEMO, a3.getPlayer(), item3, a3.ALLATORIxDEMO.getPosition(), false, false);
    }

    @Override
    public /* synthetic */ MapleMonster getMonster(int a2) {
        return MapleLifeFactory.getMonster(a2);
    }

    @Override
    public /* synthetic */ void spawnMonster(int a2, int a3, Point a4) {
        ReactorActionManager a5;
        if (MapleLifeFactory.getMonster(a2) != null) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a5.ALLATORIxDEMO.getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), a4);
                n3 = ++n2;
            }
        } else if (a5.getPlayer() != null && a5.getPlayer().isStaff()) {
            a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_NpcScript_Bug(a5.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public /* synthetic */ void cancelHarvest(boolean a2) {
        ReactorActionManager a3;
        ReactorActionManager reactorActionManager = a3;
        ReactorActionManager reactorActionManager2 = a3;
        reactorActionManager.getPlayer().setFatigue((byte)(reactorActionManager2.getPlayer().getFatigue() + 1));
        reactorActionManager.getPlayer().getMap().broadcastMessage(a3.getPlayer(), MaplePacketCreator.showHarvesting(a3.getPlayer().getId(), 0), false);
        reactorActionManager2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.harvestResult(a3.getPlayer().getId(), a2));
    }

    @Override
    public /* synthetic */ void spawnMonster(int a2, int a3, int a4, int a5) {
        ReactorActionManager a6;
        a6.spawnMonster(a2, a3, new Point(a4, a5));
    }

    @Override
    public /* synthetic */ void spawnNpc(int a2) {
        ReactorActionManager a3;
        ReactorActionManager reactorActionManager = a3;
        reactorActionManager.spawnNpc(a2, reactorActionManager.getPosition());
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, int a3, Point a4) {
        ReactorActionManager a5;
        if (a5.getPlayer() != null && MapleLifeFactory.getMonster(a2) == null) {
            FileoutputUtil.logToFile_ReactorScript_Bug(a5.getPlayer(), " \u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
            if (a5.getPlayer().isStaff()) {
                a5.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
                return;
            }
        } else {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3) {
                a5.ALLATORIxDEMO.getMap().spawnFakeMonsterOnGroundBelow(MapleLifeFactory.getMonster(a2), a4);
                n3 = ++n2;
            }
        }
    }

    public /* synthetic */ void killAll() {
        ReactorActionManager a2;
        a2.ALLATORIxDEMO.getMap().killAllMonsters(true);
    }

    public /* synthetic */ Point getPosition() {
        ReactorActionManager a2;
        Point point = a2.ALLATORIxDEMO.getPosition();
        point.y -= 10;
        return point;
    }
}

