/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import java.awt.Point;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleMapItem
extends AbstractMapleMapObject {
    public /* synthetic */ long nextExpiry;
    public /* synthetic */ boolean playerDrop;
    public /* synthetic */ IItem item;
    public /* synthetic */ int questid;
    public /* synthetic */ int meso;
    private /* synthetic */ ReentrantLock ALLATORIxDEMO;
    public /* synthetic */ long nextFFA;
    public /* synthetic */ MapleMapObject dropper;
    public /* synthetic */ boolean randDrop;
    public /* synthetic */ boolean pickedUp;
    public /* synthetic */ byte type;
    public /* synthetic */ int character_ownerid;

    public /* synthetic */ void setDropType(byte a2) {
        a.type = a2;
    }

    public /* synthetic */ void setPickedUp(boolean a2) {
        a.pickedUp = a2;
    }

    public final /* synthetic */ int getMeso() {
        MapleMapItem a2;
        return a2.meso;
    }

    public /* synthetic */ MapleMapItem(IItem a2, Point a3, MapleMapObject a4, MapleCharacter a5, byte a6, boolean a7) {
        MapleMapItem a8;
        MapleMapItem mapleMapItem = a8;
        MapleMapItem mapleMapItem2 = a8;
        MapleMapItem mapleMapItem3 = a8;
        MapleMapItem mapleMapItem4 = a8;
        a8.meso = 0;
        mapleMapItem4.questid = -1;
        mapleMapItem4.pickedUp = false;
        mapleMapItem3.randDrop = false;
        mapleMapItem3.nextExpiry = 0L;
        a8.nextFFA = 0L;
        MapleMapItem mapleMapItem5 = a8;
        mapleMapItem5.ALLATORIxDEMO = new ReentrantLock();
        a8.setPosition(a3);
        a8.item = a2;
        mapleMapItem2.dropper = a4;
        mapleMapItem2.character_ownerid = a5.getId();
        mapleMapItem.type = a6;
        mapleMapItem.playerDrop = a7;
    }

    public /* synthetic */ byte getDropType() {
        MapleMapItem a2;
        return a2.type;
    }

    public final /* synthetic */ IItem getItem() {
        MapleMapItem a2;
        return a2.item;
    }

    public /* synthetic */ MapleMapItem(Point a2, IItem a3) {
        MapleMapItem a4;
        MapleMapItem mapleMapItem = a4;
        MapleMapItem mapleMapItem2 = a4;
        MapleMapItem mapleMapItem3 = a4;
        MapleMapItem mapleMapItem4 = a4;
        a4.meso = 0;
        mapleMapItem4.questid = -1;
        mapleMapItem4.pickedUp = false;
        mapleMapItem3.randDrop = false;
        mapleMapItem3.nextExpiry = 0L;
        a4.nextFFA = 0L;
        MapleMapItem mapleMapItem5 = a4;
        mapleMapItem5.ALLATORIxDEMO = new ReentrantLock();
        a4.setPosition(a2);
        a4.item = a3;
        mapleMapItem2.character_ownerid = 0;
        mapleMapItem2.type = (byte)2;
        mapleMapItem.playerDrop = false;
        mapleMapItem.randDrop = true;
    }

    public /* synthetic */ boolean shouldFFA() {
        MapleMapItem a2;
        return !a2.pickedUp && a2.type < 2 && a2.nextFFA > 0L && a2.nextFFA < System.currentTimeMillis();
    }

    public /* synthetic */ void registerFFA(long a2) {
        a.nextFFA = System.currentTimeMillis() + a2;
    }

    public /* synthetic */ void registerExpire(long a2) {
        a.nextExpiry = System.currentTimeMillis() + a2;
    }

    public final /* synthetic */ MapleMapObject getDropper() {
        MapleMapItem a2;
        return a2.dropper;
    }

    public /* synthetic */ MapleMapItem(IItem a2, Point a3, MapleMapObject a4, MapleCharacter a5, byte a6, boolean a7, int a8) {
        MapleMapItem a9;
        MapleMapItem mapleMapItem = a9;
        MapleMapItem mapleMapItem2 = a9;
        MapleMapItem mapleMapItem3 = a9;
        MapleMapItem mapleMapItem4 = a9;
        MapleMapItem mapleMapItem5 = a9;
        a9.meso = 0;
        mapleMapItem5.questid = -1;
        mapleMapItem5.pickedUp = false;
        mapleMapItem4.randDrop = false;
        mapleMapItem4.nextExpiry = 0L;
        a9.nextFFA = 0L;
        MapleMapItem mapleMapItem6 = a9;
        a9.ALLATORIxDEMO = new ReentrantLock();
        a9.setPosition(a3);
        mapleMapItem3.item = a2;
        mapleMapItem3.dropper = a4;
        mapleMapItem2.character_ownerid = a5.getId();
        mapleMapItem2.type = a6;
        mapleMapItem.playerDrop = a7;
        mapleMapItem.questid = a8;
    }

    public final /* synthetic */ int getItemId() {
        MapleMapItem a2;
        if (a2.getMeso() > 0) {
            return a2.meso;
        }
        return a2.item.getItemId();
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleMapItem a3;
        a2.sendPacket(MaplePacketCreator.removeItemFromMap(a3.getObjectId(), 1, 0));
    }

    public /* synthetic */ MapleMapItem(int a2, Point a3, MapleMapObject a4, MapleCharacter a5, byte a6, boolean a7) {
        MapleMapItem a8;
        MapleMapItem mapleMapItem = a8;
        MapleMapItem mapleMapItem2 = a8;
        MapleMapItem mapleMapItem3 = a8;
        MapleMapItem mapleMapItem4 = a8;
        MapleMapItem mapleMapItem5 = a8;
        a8.meso = 0;
        mapleMapItem5.questid = -1;
        mapleMapItem5.pickedUp = false;
        mapleMapItem4.randDrop = false;
        mapleMapItem4.nextExpiry = 0L;
        a8.nextFFA = 0L;
        MapleMapItem mapleMapItem6 = a8;
        a8.ALLATORIxDEMO = new ReentrantLock();
        a8.setPosition(a3);
        mapleMapItem3.item = null;
        mapleMapItem3.dropper = a4;
        mapleMapItem2.character_ownerid = a5.getId();
        mapleMapItem2.meso = a2;
        mapleMapItem.type = a6;
        mapleMapItem.playerDrop = a7;
    }

    public final /* synthetic */ boolean isRandDrop() {
        MapleMapItem a2;
        return a2.randDrop;
    }

    public /* synthetic */ boolean shouldExpire() {
        MapleMapItem a2;
        return !a2.pickedUp && a2.nextExpiry > 0L && a2.nextExpiry < System.currentTimeMillis();
    }

    @Override
    public final /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.ITEM;
    }

    public /* synthetic */ Lock getLock() {
        MapleMapItem a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setItem(IItem a2) {
        a.item = a2;
    }

    public /* synthetic */ void expire(MapleMap a2) {
        MapleMapItem a3;
        MapleMapItem mapleMapItem = a3;
        mapleMapItem.pickedUp = true;
        a2.broadcastMessage(MaplePacketCreator.removeItemFromMap(a3.getObjectId(), 0, 0));
        a2.removeMapObject(mapleMapItem);
        if (mapleMapItem.randDrop) {
            a2.spawnRandDrop();
        }
    }

    public final /* synthetic */ int getOwner() {
        MapleMapItem a2;
        return a2.character_ownerid;
    }

    public final /* synthetic */ boolean isPickedUp() {
        MapleMapItem a2;
        return a2.pickedUp;
    }

    public final /* synthetic */ boolean isPlayerDrop() {
        MapleMapItem a2;
        return a2.playerDrop;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleMapItem a3;
        if (a3.questid <= 0 || a2.getPlayer().getQuestStatus(a3.questid) == 1) {
            MapleMapItem mapleMapItem = a3;
            a2.sendPacket(MaplePacketCreator.dropItemFromMapObject(mapleMapItem, null, mapleMapItem.getPosition(), (byte)2));
        }
    }

    public final /* synthetic */ int getQuest() {
        MapleMapItem a2;
        return a2.questid;
    }
}

