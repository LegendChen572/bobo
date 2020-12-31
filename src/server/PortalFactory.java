/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592f\u592f\u8c37
 */
package server;

import client.messages.commands.player.\u592f\u592f\u8c37;
import java.awt.Point;
import provider.MapleData;
import provider.MapleDataTool;
import server.MaplePortal;
import server.maps.MapleGenericPortal;
import server.maps.MapleMapPortal;
import tools.FileOperation;

public class PortalFactory {
    private /* synthetic */ int ALLATORIxDEMO;

    private /* synthetic */ void ALLATORIxDEMO(MapleGenericPortal a2, MapleData a3) {
        MapleGenericPortal mapleGenericPortal = a2;
        MapleData mapleData = a3;
        a2.setName(MapleDataTool.getString(mapleData.getChildByPath(FileOperation.ALLATORIxDEMO("|c"))));
        mapleGenericPortal.setTarget(MapleDataTool.getString(mapleData.getChildByPath(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0002\u001f"))));
        mapleGenericPortal.setTargetMapId(910000000);
        mapleGenericPortal.setPosition(new Point(MapleDataTool.getInt(a3.getChildByPath(FileOperation.ALLATORIxDEMO("u"))), MapleDataTool.getInt(a3.getChildByPath(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\b")))));
        if (a2.getType() == 6) {
            PortalFactory a4;
            PortalFactory portalFactory = a4;
            a2.setId(portalFactory.ALLATORIxDEMO);
            ++portalFactory.ALLATORIxDEMO;
            return;
        }
        a2.setId(Integer.parseInt(a3.getName()));
    }

    private /* synthetic */ void H(MapleGenericPortal a2, MapleData a3) {
        MapleGenericPortal mapleGenericPortal = a2;
        MapleData mapleData = a3;
        a2.setName(MapleDataTool.getString(a3.getChildByPath(FileOperation.ALLATORIxDEMO("|c"))));
        mapleGenericPortal.setTarget(MapleDataTool.getString(mapleData.getChildByPath(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0002\u001f"))));
        mapleGenericPortal.setTargetMapId(MapleDataTool.getInt(mapleData.getChildByPath(FileOperation.ALLATORIxDEMO("x`"))));
        a2.setPosition(new Point(MapleDataTool.getInt(a3.getChildByPath(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\t"))), MapleDataTool.getInt(a3.getChildByPath(FileOperation.ALLATORIxDEMO("t")))));
        String string = MapleDataTool.getString(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0005\u0012\u0004\u0018\u0006\u0005"), a3, null);
        if (string != null && string.equals("")) {
            string = null;
        }
        MapleGenericPortal mapleGenericPortal2 = a2;
        mapleGenericPortal2.setScriptName(string);
        if (mapleGenericPortal2.getType() == 6) {
            PortalFactory a4;
            PortalFactory portalFactory = a4;
            a2.setId(portalFactory.ALLATORIxDEMO);
            ++portalFactory.ALLATORIxDEMO;
            return;
        }
        a2.setId(Integer.parseInt(a3.getName()));
    }

    public /* synthetic */ PortalFactory() {
        PortalFactory a2;
        a2.ALLATORIxDEMO = 128;
    }

    public /* synthetic */ MaplePortal makePortal(int a2, MapleData a3) {
        PortalFactory portalFactory;
        PortalFactory a4;
        MapleGenericPortal mapleGenericPortal;
        if (a2 == 2) {
            mapleGenericPortal = new MapleMapPortal();
            portalFactory = a4;
        } else {
            mapleGenericPortal = new MapleGenericPortal(a2);
            portalFactory = a4;
        }
        portalFactory.H(mapleGenericPortal, a3);
        return mapleGenericPortal;
    }

    public /* synthetic */ MaplePortal makePortalFM(int a2, MapleData a3) {
        PortalFactory portalFactory;
        PortalFactory a4;
        MapleGenericPortal mapleGenericPortal;
        if (a2 == 2) {
            mapleGenericPortal = new MapleMapPortal();
            portalFactory = a4;
        } else {
            mapleGenericPortal = new MapleGenericPortal(a2);
            portalFactory = a4;
        }
        portalFactory.ALLATORIxDEMO(mapleGenericPortal, a3);
        return mapleGenericPortal;
    }
}

