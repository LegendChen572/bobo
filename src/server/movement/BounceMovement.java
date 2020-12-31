/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class BounceMovement
extends AbstractLifeMovement {
    private /* synthetic */ Point ALLATORIxDEMO;

    public /* synthetic */ void setOffset(Point a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ BounceMovement(int a2, Point a3, int a4, int a5) {
        super(a2, a3, a4, a5, 0);
        BounceMovement a6;
    }

    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        BounceMovement a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        BounceMovement bounceMovement = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        maplePacketLittleEndianWriter2.write(a3.getType());
        maplePacketLittleEndianWriter2.writePos(a3.getPosition());
        a2.writePos(bounceMovement.ALLATORIxDEMO);
        maplePacketLittleEndianWriter.write(bounceMovement.getNewstate());
        maplePacketLittleEndianWriter.writeShort(a3.getDuration());
    }
}

