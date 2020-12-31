/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleClient;
import java.awt.Point;

public interface MaplePortal {
    public static final /* synthetic */ int MAP_PORTAL = 2;
    public static final /* synthetic */ int DOOR_PORTAL = 6;

    public /* synthetic */ String getScriptName();

    public /* synthetic */ String getName();

    public /* synthetic */ int getType();

    public /* synthetic */ void enterPortal(MapleClient var1);

    public /* synthetic */ boolean getPortalState();

    public /* synthetic */ String getTarget();

    public /* synthetic */ void setPortalState(boolean var1);

    public /* synthetic */ int getTargetMapId();

    public /* synthetic */ Point getPosition();

    public /* synthetic */ int getId();

    public /* synthetic */ void setScriptName(String var1);
}

