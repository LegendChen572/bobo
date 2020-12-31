/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleClient;
import client.anticheat.CheatingOffense;
import constants.MapConstants;
import handling.channel.ChannelServer;
import handling.world.MaplePartyCharacter;
import java.awt.Point;
import scripting.portal.PortalScriptManager;
import server.MaplePortal;
import tools.MaplePacketCreator;

public class MapleGenericPortal
implements MaplePortal {
    private /* synthetic */ int K;
    private /* synthetic */ int a;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ String E;
    private /* synthetic */ String B;
    private /* synthetic */ Point k;
    private /* synthetic */ String g;
    private /* synthetic */ int d;

    public final /* synthetic */ void setId(int a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ boolean getPortalState() {
        MapleGenericPortal a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void setTarget(String a2) {
        a.g = a2;
    }

    @Override
    public /* synthetic */ void setPortalState(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public final /* synthetic */ Point getPosition() {
        MapleGenericPortal a2;
        return a2.k;
    }

    @Override
    public final /* synthetic */ int getId() {
        MapleGenericPortal a2;
        return a2.d;
    }

    @Override
    public final /* synthetic */ void setScriptName(String a2) {
        a.B = a2;
    }

    @Override
    public final /* synthetic */ String getScriptName() {
        MapleGenericPortal a2;
        return a2.B;
    }

    public final /* synthetic */ void setPosition(Point a2) {
        a.k = a2;
    }

    @Override
    public final /* synthetic */ String getName() {
        MapleGenericPortal a2;
        return a2.E;
    }

    public /* synthetic */ MapleGenericPortal(int a2) {
        MapleGenericPortal a3;
        MapleGenericPortal mapleGenericPortal = a3;
        mapleGenericPortal.ALLATORIxDEMO = true;
        mapleGenericPortal.a = a2;
    }

    @Override
    public final /* synthetic */ int getType() {
        MapleGenericPortal a2;
        return a2.a;
    }

    @Override
    public final /* synthetic */ String getTarget() {
        MapleGenericPortal a2;
        return a2.g;
    }

    public final /* synthetic */ void setTargetMapId(int a2) {
        a.K = a2;
    }

    public final /* synthetic */ void setName(String a2) {
        a.E = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public final /* synthetic */ void enterPortal(MapleClient a) {
        if (a.getPosition().distanceSq(a.getPlayer().getPosition()) > 22500.0) {
            a.getPlayer().getCheatTracker().registerOffense(CheatingOffense.USING_FARAWAY_PORTAL);
        }
        if (a.getPlayer().getConversation() != 0) {
            a.getPlayer().dropMessage(-1, MapConstants.ALLATORIxDEMO("\u4f1b\u5c02\u6772\u5c15\u8a0a\u6732\u7d39\u6b7aW\u73e6\u5753\u4e15\u8086\u902a\u511e\u50ab\u9ea58\u8ab0\u8f20\u511eX\u001ey\u8998\u967c\u750b\u5e20\u72bb\u6153"));
            return;
        }
        var2_2 = a.getPlayer().getMap();
        if (!a.ALLATORIxDEMO && !a.getPlayer().isGM()) ** GOTO lbl28
        if (a.getScriptName() != null) {
            a.getPlayer().checkFollow();
            try {
                PortalScriptManager.getInstance().executePortalScript(a, a);
                v0 = a;
            }
            catch (Exception var3_3) {
                v0 = a;
                var3_3.printStackTrace();
            }
        } else {
            if (a.getTargetMapId() != 999999999) {
                v1 = a;
                var3_4 = ChannelServer.getInstance(a.getWorld(), v1.getChannel()).getMapFactory().getMap(a.getTargetMapId());
                if (!v1.getPlayer().isGM() && var3_4.getLevelLimit() > 0 && var3_4.getLevelLimit() > a.getPlayer().getLevel()) {
                    v2 = a;
                    v2.getPlayer().dropMessage(-1, MaplePartyCharacter.ALLATORIxDEMO("\u7b77\u7d1c\u9070\u4f48\u711f\u6cd3\u900c\u5163\u6712\u5736\u537e("));
                    v2.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                v3 = var3_4;
                a.getPlayer().changeMapPortal(v3, var3_4.getPortal(a.getTarget()) == null ? v3.getPortal(0) : v3.getPortal(a.getTarget()));
            }
lbl28:
            // 4 sources

            v0 = a;
        }
        if (v0 == null) return;
        if (a.getPlayer() == null) return;
        if (a.getPlayer().getMap() != var2_2) return;
        a.sendPacket(MaplePacketCreator.enableActions());
    }

    @Override
    public final /* synthetic */ int getTargetMapId() {
        MapleGenericPortal a2;
        return a2.K;
    }
}

