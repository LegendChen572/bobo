/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import constants.GameSetConstants;
import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class AbsoluteLifeMovement
extends AbstractLifeMovement {
    private /* synthetic */ Point a;
    private /* synthetic */ short d;
    private /* synthetic */ short ALLATORIxDEMO;
    private /* synthetic */ Point K;

    public /* synthetic */ void setUnk(short a2) {
        a.d = a2;
    }

    public /* synthetic */ void setPixelsPerSecond(Point a2) {
        a.K = a2;
    }

    public /* synthetic */ void setFh(short a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ AbsoluteLifeMovement(int a2, Point a3, int a4, int a5) {
        super(a2, a3, a4, a5, 0);
        AbsoluteLifeMovement a6;
    }

    public /* synthetic */ void defaulted() {
        AbsoluteLifeMovement a2;
        AbsoluteLifeMovement absoluteLifeMovement = a2;
        absoluteLifeMovement.d = 0;
        absoluteLifeMovement.ALLATORIxDEMO = 0;
        AbsoluteLifeMovement absoluteLifeMovement2 = a2;
        absoluteLifeMovement.K = new Point(0, 0);
        absoluteLifeMovement2.a = new Point(0, 0);
    }

    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        AbsoluteLifeMovement absoluteLifeMovement;
        AbsoluteLifeMovement a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        AbsoluteLifeMovement absoluteLifeMovement2 = a3;
        a2.write(a3.getType());
        a2.writePos(absoluteLifeMovement2.getPosition());
        maplePacketLittleEndianWriter.writePos(absoluteLifeMovement2.K);
        maplePacketLittleEndianWriter.writeShort(a3.d);
        int n2 = 15;
        if (GameSetConstants.MAPLE_VERSION >= 142) {
            n2 = 14;
            absoluteLifeMovement = a3;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                n2 = 13;
            }
            absoluteLifeMovement = a3;
        }
        if (absoluteLifeMovement.getType() == n2) {
            a2.writeShort(a3.ALLATORIxDEMO);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        AbsoluteLifeMovement absoluteLifeMovement3 = a3;
        a2.writePos(a3.a);
        maplePacketLittleEndianWriter2.write(absoluteLifeMovement3.getNewstate());
        maplePacketLittleEndianWriter2.writeShort(absoluteLifeMovement3.getDuration());
    }

    public /* synthetic */ short getUnk() {
        AbsoluteLifeMovement a2;
        return a2.d;
    }

    public /* synthetic */ void setOffset(Point a2) {
        a.a = a2;
    }
}

