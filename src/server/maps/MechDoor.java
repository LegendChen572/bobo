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

public class MechDoor
extends AbstractMapleMapObject {
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int d;
    private /* synthetic */ int a;

    public /* synthetic */ MechDoor(MapleCharacter a2, Point a3, int a4) {
        MechDoor a5;
        MechDoor mechDoor = a5;
        mechDoor.a = a2.getId();
        mechDoor.d = a2.getParty() == null ? 0 : a2.getParty().getId();
        a5.setPosition(a3);
        a5.ALLATORIxDEMO = a4;
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.DOOR;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MechDoor a3;
        a2.sendPacket(MaplePacketCreator.spawnMechDoor(a3, false));
    }

    public /* synthetic */ int getOwnerId() {
        MechDoor a2;
        return a2.a;
    }

    public /* synthetic */ int getId() {
        MechDoor a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MechDoor a3;
        a2.sendPacket(MaplePacketCreator.removeMechDoor(a3, false));
    }

    public /* synthetic */ int getPartyId() {
        MechDoor a2;
        return a2.d;
    }
}

