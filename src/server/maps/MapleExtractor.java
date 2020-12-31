/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import constants.GameConstants;
import java.awt.Point;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleExtractor
extends AbstractMapleMapObject {
    public /* synthetic */ int owner;
    public /* synthetic */ int itemId;
    public /* synthetic */ int timeLeft;
    private /* synthetic */ Point d;
    public /* synthetic */ long startTime;
    private /* synthetic */ int ALLATORIxDEMO;
    public /* synthetic */ int fee;
    public /* synthetic */ String ownerName;

    public /* synthetic */ Double getRange() {
        return GameConstants.maxViewRangeSq_();
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.EXTRACTOR;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleExtractor a3;
        MapleExtractor mapleExtractor = a3;
        MapleExtractor mapleExtractor2 = a3;
        a2.sendPacket(MaplePacketCreator.makeExtractor(mapleExtractor.owner, mapleExtractor.ownerName, a3.getTruePosition(), a3.getTimeLeft(), mapleExtractor2.itemId, mapleExtractor2.fee));
    }

    @Override
    public /* synthetic */ void setPosition(Point a2) {
        MapleExtractor a3;
        MapleExtractor mapleExtractor = a3;
        mapleExtractor.d.x = a2.x;
        mapleExtractor.d.y = a2.y;
    }

    @Override
    public /* synthetic */ Point getTruePosition() {
        MapleExtractor a2;
        return a2.d;
    }

    public /* synthetic */ MapleExtractor(MapleCharacter a2, int a3, int a4, int a5) {
        MapleExtractor a6;
        MapleExtractor mapleExtractor = a6;
        MapleExtractor mapleExtractor2 = a6;
        MapleExtractor mapleExtractor3 = a6;
        mapleExtractor3.d = new Point();
        mapleExtractor2.owner = a2.getId();
        mapleExtractor2.itemId = a3;
        mapleExtractor.fee = a4;
        mapleExtractor.ownerName = a2.getName();
        mapleExtractor.startTime = System.currentTimeMillis();
        a6.timeLeft = a5;
        a6.setPosition(a2.getPosition());
    }

    @Override
    public /* synthetic */ int getObjectId() {
        MapleExtractor a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void setObjectId(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleExtractor a3;
        a2.sendPacket(MaplePacketCreator.removeExtractor(a3.owner));
    }

    public /* synthetic */ int getTimeLeft() {
        MapleExtractor a2;
        return a2.timeLeft;
    }

    @Override
    public /* synthetic */ Point getPosition() {
        MapleExtractor a2;
        return new Point(a2.d);
    }
}

