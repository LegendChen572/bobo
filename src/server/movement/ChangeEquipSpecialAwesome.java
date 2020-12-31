/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import server.movement.LifeMovementFragment;
import tools.data.MaplePacketLittleEndianWriter;

public class ChangeEquipSpecialAwesome
implements LifeMovementFragment {
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int d;

    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        ChangeEquipSpecialAwesome a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.write(a3.d);
        maplePacketLittleEndianWriter.write(a3.ALLATORIxDEMO);
    }

    @Override
    public /* synthetic */ Point getPosition() {
        return new Point(0, 0);
    }

    public /* synthetic */ ChangeEquipSpecialAwesome(int a2, int a3) {
        ChangeEquipSpecialAwesome a4;
        ChangeEquipSpecialAwesome changeEquipSpecialAwesome = a4;
        changeEquipSpecialAwesome.d = a2;
        changeEquipSpecialAwesome.ALLATORIxDEMO = a3;
    }
}

