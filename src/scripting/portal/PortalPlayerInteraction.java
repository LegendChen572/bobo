/*
 * Decompiled with CFR 0.150.
 */
package scripting.portal;

import client.MapleClient;
import constants.GameSetConstants;
import scripting.AbstractPlayerInteraction;
import server.MaplePortal;
import server.life.MapleLifeFactory;
import server.shark.SharkLogger;
import tools.FileoutputUtil;
import tools.googledrive.SyncServerData;

public class PortalPlayerInteraction
extends AbstractPlayerInteraction {
    private final /* synthetic */ MaplePortal ALLATORIxDEMO;

    @Override
    public /* synthetic */ void spawnMonster(int a2) {
        PortalPlayerInteraction a3;
        if (MapleLifeFactory.getMonster(a2) != null) {
            PortalPlayerInteraction portalPlayerInteraction = a3;
            portalPlayerInteraction.spawnMonster(a2, 1, portalPlayerInteraction.ALLATORIxDEMO.getPosition());
            return;
        }
        if (a3.getPlayer() != null && a3.getPlayer().isStaff()) {
            a3.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_PortalScript_Bug(a3.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }

    public final /* synthetic */ void inFreeMarket() {
        PortalPlayerInteraction a2;
        if (a2.getPlayer().getLevel() >= GameSetConstants.FREEMARKET_LEVEL) {
            PortalPlayerInteraction portalPlayerInteraction = a2;
            portalPlayerInteraction.saveLocation(SyncServerData.ALLATORIxDEMO("L'O0U8K'A0^"));
            portalPlayerInteraction.playPortalSE();
            portalPlayerInteraction.warp(910000000, SharkLogger.ALLATORIxDEMO("_U\u001c\u0011"));
            return;
        }
        a2.playerMessage(5, "\u4f60\u9700\u8981" + GameSetConstants.FREEMARKET_LEVEL + "\u7d1a\u624d\u53ef\u4ee5\u9032\u5165\u81ea\u7531\u5e02\u5834");
    }

    public /* synthetic */ PortalPlayerInteraction(MapleClient a2, MaplePortal a3) {
        super(a2);
        PortalPlayerInteraction a4;
        a4.ALLATORIxDEMO = a3;
        if (a2.getPlayer() != null) {
            a2.getPlayer().setPortalNow(a3.getId());
        }
    }

    public final /* synthetic */ MaplePortal getPortal() {
        PortalPlayerInteraction a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void inArdentmill() {
        PortalPlayerInteraction a2;
        if (a2.getMapId() != 910001000) {
            if (a2.getPlayer().getLevel() >= 30) {
                PortalPlayerInteraction portalPlayerInteraction = a2;
                portalPlayerInteraction.saveLocation(SyncServerData.ALLATORIxDEMO("4X1O;^8C9F"));
                portalPlayerInteraction.playPortalSE();
                portalPlayerInteraction.warp(910001000, SharkLogger.ALLATORIxDEMO("_U\u001c\u0011"));
                return;
            }
            a2.playerMessage(5, SyncServerData.ALLATORIxDEMO("\u675f\u6ef5U9E*\u7d6f\u712b\u6ca0\u9038\u5110\u688f\u65da\u7273\u93db\u3008"));
        }
    }

    @Override
    public /* synthetic */ void spawnMonster(int a2, int a3) {
        PortalPlayerInteraction a4;
        if (MapleLifeFactory.getMonster(a2) != null) {
            PortalPlayerInteraction portalPlayerInteraction = a4;
            portalPlayerInteraction.spawnMonster(a2, a3, portalPlayerInteraction.ALLATORIxDEMO.getPosition());
            return;
        }
        if (a4.getPlayer() != null && a4.getPlayer().isStaff()) {
            a4.getPlayer().dropMessage("\u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728");
            FileoutputUtil.logToFile_PortalScript_Bug(a4.getPlayer(), "\u542b\u6709 \u602a\u7269\u4ee3\u78bc[" + a2 + "] \u4e0d\u5b58\u5728 \u4e4b\u6f0f\u6d1e\r\n");
        }
    }
}

