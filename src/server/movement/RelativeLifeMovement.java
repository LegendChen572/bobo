/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import constants.GameSetConstants;
import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class RelativeLifeMovement
extends AbstractLifeMovement {
    private /* synthetic */ Point ALLATORIxDEMO;
    private /* synthetic */ short d;

    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        RelativeLifeMovement a3;
        a2.write(a3.getType());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writePos(a3.getPosition());
        } else {
            a2.writePos(a3.ALLATORIxDEMO);
        }
        if (GameSetConstants.MAPLE_VERSION >= 145 && (a3.getType() == 18 || a3.getType() == 19)) {
            a2.writeShort(a3.d);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        RelativeLifeMovement relativeLifeMovement = a3;
        maplePacketLittleEndianWriter.write(relativeLifeMovement.getNewstate());
        maplePacketLittleEndianWriter.writeShort(relativeLifeMovement.getDuration());
    }

    public /* synthetic */ RelativeLifeMovement(int a2, Point a3, int a4, int a5) {
        super(a2, a3, a4, a5, 0);
        RelativeLifeMovement a6;
    }

    public /* synthetic */ short getUnk() {
        RelativeLifeMovement a2;
        return a2.d;
    }

    public /* synthetic */ void setUnk(short a2) {
        a.d = a2;
    }

    public /* synthetic */ void setPixelsPerSecond(Point a2) {
        a.ALLATORIxDEMO = a2;
    }
}

