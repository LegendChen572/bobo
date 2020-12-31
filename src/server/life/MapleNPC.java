/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import client.MapleClient;
import server.MapleShopFactory;
import server.life.AbstractLoadedMapleLife;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleNPC
extends AbstractLoadedMapleLife {
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ String d;

    @Override
    public final /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.NPC;
    }

    public /* synthetic */ MapleNPC(int a2, String a3, boolean a4) {
        MapleNPC a5;
        MapleNPC mapleNPC = a5;
        MapleNPC mapleNPC2 = a5;
        super(a2);
        mapleNPC2.d = "MISSINGNO";
        mapleNPC2.ALLATORIxDEMO = false;
        mapleNPC.d = a3;
        mapleNPC.ALLATORIxDEMO = a4;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleNPC a3;
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MaplePacketCreator.spawnNPC(a3, true));
        mapleClient.sendPacket(MaplePacketCreator.spawnNPCRequestController(a3, true));
    }

    public final /* synthetic */ void sendShop(MapleClient a2) {
        MapleNPC a3;
        MapleShopFactory.getInstance().getShopForNPC(a3.getId()).sendShop(a2);
    }

    public final /* synthetic */ boolean hasShop() {
        MapleNPC a2;
        return MapleShopFactory.getInstance().getShopForNPC(a2.getId()) != null;
    }

    public /* synthetic */ void setName(String a2) {
        a.d = a2;
    }

    @Override
    public final /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleNPC a3;
        a2.getSession().writeAndFlush((Object)MaplePacketCreator.removeNPCController(a3.getObjectId()));
        a2.sendPacket(MaplePacketCreator.removeNPC(a3.getObjectId()));
    }

    public /* synthetic */ MapleNPC(int a2, String a3) {
        MapleNPC a4;
        MapleNPC mapleNPC = a4;
        super(a2);
        a4.d = "MISSINGNO";
        mapleNPC.ALLATORIxDEMO = false;
        mapleNPC.d = a3;
    }

    public final /* synthetic */ String getName() {
        MapleNPC a2;
        return a2.d;
    }
}

