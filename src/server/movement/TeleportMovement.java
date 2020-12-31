/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class TeleportMovement
extends AbstractLifeMovement {
    private /* synthetic */ short ALLATORIxDEMO;

    public /* synthetic */ void setFh(short a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        TeleportMovement a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        TeleportMovement teleportMovement = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        maplePacketLittleEndianWriter2.write(a3.getType());
        maplePacketLittleEndianWriter2.writePos(a3.getPosition());
        a2.writeShort(teleportMovement.ALLATORIxDEMO);
        maplePacketLittleEndianWriter.write(teleportMovement.getNewstate());
        maplePacketLittleEndianWriter.writeShort(a3.getDuration());
    }

    public /* synthetic */ TeleportMovement(int a2, Point a3, int a4, int a5) {
        super(a2, a3, a4, a5, 0);
        TeleportMovement a6;
    }
}

