/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import java.awt.Point;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleKite
extends AbstractMapleMapObject {
    private final /* synthetic */ Point k;
    private final /* synthetic */ MapleCharacter K;
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ String a;
    private final /* synthetic */ int d;

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleKite a3;
        a2.getSession().writeAndFlush((Object)a3.makeSpawnData());
    }

    @Override
    public /* synthetic */ Point getPosition() {
        MapleKite a2;
        return a2.k.getLocation();
    }

    @Override
    public /* synthetic */ void setPosition(Point a2) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ byte[] makeDestroyData() {
        MapleKite a2;
        return MaplePacketCreator.destroyKite(a2.getObjectId());
    }

    public /* synthetic */ MapleCharacter getOwner() {
        MapleKite a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.Kite;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleKite a3;
        a2.getSession().writeAndFlush((Object)a3.makeDestroyData());
    }

    public /* synthetic */ MapleKite(MapleCharacter a2, Point a3, int a4, String a5, int a6) {
        MapleKite a7;
        MapleKite mapleKite = a7;
        MapleKite mapleKite2 = a7;
        a7.K = a2;
        mapleKite2.k = a3;
        mapleKite2.a = a5;
        mapleKite.d = a4;
        mapleKite.ALLATORIxDEMO = a6;
    }

    public /* synthetic */ byte[] makeSpawnData() {
        MapleKite a2;
        MapleKite mapleKite = a2;
        MapleKite mapleKite2 = a2;
        return MaplePacketCreator.spawnKite(a2.getObjectId(), mapleKite.ALLATORIxDEMO, mapleKite.K.getName(), mapleKite2.a, mapleKite2.k, a2.d);
    }
}

