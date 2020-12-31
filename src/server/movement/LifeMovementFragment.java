/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import tools.data.MaplePacketLittleEndianWriter;

public interface LifeMovementFragment {
    public /* synthetic */ Point getPosition();

    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter var1);
}

