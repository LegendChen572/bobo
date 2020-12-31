/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleClient;
import java.awt.Point;
import server.maps.MapleMapObjectType;

public interface MapleMapObject {
    public /* synthetic */ int getObjectId();

    public /* synthetic */ Point getPosition();

    public /* synthetic */ void sendSpawnData(MapleClient var1);

    public /* synthetic */ MapleMapObjectType getType();

    public /* synthetic */ void setObjectId(int var1);

    public /* synthetic */ void sendDestroyData(MapleClient var1);

    public /* synthetic */ void setPosition(Point var1);

    public /* synthetic */ Point getTruePosition();
}

