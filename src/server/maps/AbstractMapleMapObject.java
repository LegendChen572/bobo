/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleClient;
import java.awt.Point;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;

public abstract class AbstractMapleMapObject
implements MapleMapObject {
    private /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ Point d;

    public /* synthetic */ AbstractMapleMapObject() {
        AbstractMapleMapObject a2;
        AbstractMapleMapObject abstractMapleMapObject = a2;
        abstractMapleMapObject.d = new Point();
    }

    @Override
    public abstract /* synthetic */ void sendSpawnData(MapleClient var1);

    @Override
    public /* synthetic */ void setPosition(Point a2) {
        AbstractMapleMapObject a3;
        AbstractMapleMapObject abstractMapleMapObject = a3;
        abstractMapleMapObject.d.x = a2.x;
        abstractMapleMapObject.d.y = a2.y;
    }

    @Override
    public /* synthetic */ int getObjectId() {
        AbstractMapleMapObject a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ Point getPosition() {
        AbstractMapleMapObject a2;
        return new Point(a2.d);
    }

    @Override
    public /* synthetic */ void setObjectId(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public abstract /* synthetic */ MapleMapObjectType getType();

    @Override
    public /* synthetic */ Point getTruePosition() {
        AbstractMapleMapObject a2;
        return a2.d;
    }

    @Override
    public abstract /* synthetic */ void sendDestroyData(MapleClient var1);
}

