/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class GroundMovement
extends AbstractLifeMovement {
    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        GroundMovement a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        GroundMovement groundMovement = a3;
        a2.write(groundMovement.getType());
        maplePacketLittleEndianWriter.write(groundMovement.getNewstate());
        maplePacketLittleEndianWriter.writeShort(a3.getDuration());
    }

    public /* synthetic */ GroundMovement(int a2, Point a3, int a4, int a5) {
        super(a2, a3, a4, a5, 0);
        GroundMovement a6;
    }
}

