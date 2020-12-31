/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class JumpDownMovement
extends AbstractLifeMovement {
    private /* synthetic */ Point K;
    private /* synthetic */ int d;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ Point a;

    public /* synthetic */ void setFH(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getUnk() {
        JumpDownMovement a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        JumpDownMovement a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        JumpDownMovement jumpDownMovement = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        maplePacketLittleEndianWriter2.write(a3.getType());
        maplePacketLittleEndianWriter2.writePos(a3.K);
        a2.writeShort(jumpDownMovement.ALLATORIxDEMO);
        maplePacketLittleEndianWriter.write(jumpDownMovement.getNewstate());
        maplePacketLittleEndianWriter.writeShort(a3.getDuration());
    }

    public /* synthetic */ void setUnk(int a2) {
        a.d = a2;
    }

    public /* synthetic */ void setOffset(Point a2) {
        a.a = a2;
    }

    public /* synthetic */ JumpDownMovement(int a2, Point a3, int a4, int a5) {
        super(a2, a3, a4, a5, 0);
        JumpDownMovement a6;
    }

    public /* synthetic */ Point getPixelsPerSecond() {
        JumpDownMovement a2;
        return a2.K;
    }

    public /* synthetic */ int getFH() {
        JumpDownMovement a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ Point getOffset() {
        JumpDownMovement a2;
        return a2.a;
    }

    public /* synthetic */ void setPixelsPerSecond(Point a2) {
        a.K = a2;
    }
}

