/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import java.awt.Point;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import server.MaplePortal;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleDoor
extends AbstractMapleMapObject {
    private final /* synthetic */ int d;
    private final /* synthetic */ MapleMap K;
    private final /* synthetic */ MapleMap B;
    private final /* synthetic */ MaplePortal k;
    private final /* synthetic */ WeakReference<MapleCharacter> g;
    private final /* synthetic */ int a;
    private final /* synthetic */ Point ALLATORIxDEMO;

    public /* synthetic */ MapleDoor(MapleDoor a2) {
        MapleDoor a3;
        MapleDoor mapleDoor = a3;
        mapleDoor.g = new WeakReference<MapleCharacter>((MapleCharacter)a2.g.get());
        MapleDoor mapleDoor2 = a2;
        MapleDoor mapleDoor3 = a3;
        MapleDoor mapleDoor4 = a2;
        a3.B = mapleDoor4.B;
        mapleDoor3.k = mapleDoor4.k;
        mapleDoor3.K = a2.K;
        a3.ALLATORIxDEMO = mapleDoor2.ALLATORIxDEMO;
        a3.a = mapleDoor2.a;
        a3.d = a2.d;
        a3.setPosition(a3.k.getPosition());
    }

    public final /* synthetic */ MapleCharacter getOwner() {
        MapleDoor a2;
        return (MapleCharacter)a2.g.get();
    }

    @Override
    public final /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.DOOR;
    }

    @Override
    public final /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleDoor a3;
        if (a3.getOwner() == null || a2 == null || a3.K == null || a2.getPlayer() == null) {
            return;
        }
        if (a3.K.getId() == a2.getPlayer().getMapId() || a3.getOwnerId() == a2.getPlayer().getId() || a3.getOwner() != null && a3.getOwner().getParty() != null && a3.getOwner().getParty().getMemberById(a2.getPlayer().getId()) != null) {
            a2.sendPacket(MaplePacketCreator.removeDoor(a3.getOwnerId(), false));
            if (a3.getOwner().getParty() != null && (a3.getOwnerId() == a2.getPlayer().getId() || a3.getOwner().getParty().getMemberById(a2.getPlayer().getId()) != null)) {
                a2.sendPacket(MaplePacketCreator.partyPortal(999999999, 999999999, 0, new Point(-1, -1)));
            }
            a2.sendPacket(MaplePacketCreator.spawnPortal(999999999, 999999999, 0, null));
        }
    }

    public final /* synthetic */ MaplePortal getTownPortal() {
        MapleDoor a2;
        return a2.k;
    }

    public final /* synthetic */ MapleMap getTown() {
        MapleDoor a2;
        return a2.B;
    }

    private /* synthetic */ MaplePortal ALLATORIxDEMO() {
        MapleDoor a2;
        ArrayList<MaplePortal> arrayList = new ArrayList<MaplePortal>();
        for (MaplePortal object : a2.B.getPortals()) {
            if (object.getType() != 6) continue;
            arrayList.add(object);
        }
        Collections.sort(arrayList, new Comparator<MaplePortal>(){
            {
                1 a3;
            }

            @Override
            public final /* synthetic */ int compare(MaplePortal a2, MaplePortal a3) {
                if (a2.getId() < a3.getId()) {
                    return -1;
                }
                if (a2.getId() == a3.getId()) {
                    return 0;
                }
                return 1;
            }
        });
        for (MapleMapObject mapleMapObject : a2.B.getAllDoorsThreadsafe()) {
            MapleDoor mapleDoor = (MapleDoor)mapleMapObject;
            if (mapleDoor.getOwner() == null || mapleDoor.getOwner().getParty() == null || a2.getOwner() == null || a2.getOwner().getParty() == null || a2.getOwner().getParty().getMemberById(mapleDoor.getOwnerId()) == null) continue;
            arrayList.remove(mapleDoor.getTownPortal());
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return (MaplePortal)arrayList.iterator().next();
    }

    public final /* synthetic */ Point getTargetPosition() {
        MapleDoor a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void warp(MapleCharacter a2, boolean a3) {
        MapleDoor a4;
        if (a2.getId() == a4.getOwnerId() || a4.getOwner() != null && a4.getOwner().getParty() != null && a4.getOwner().getParty().getMemberById(a2.getId()) != null) {
            if (!a3) {
                MapleDoor mapleDoor = a4;
                a2.changeMap(mapleDoor.K, mapleDoor.K.findClosestPortal(a4.ALLATORIxDEMO));
                return;
            }
            MapleDoor mapleDoor = a4;
            a2.changeMap(mapleDoor.B, mapleDoor.k);
            return;
        }
        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
    }

    public final /* synthetic */ MapleMap getTarget() {
        MapleDoor a2;
        return a2.K;
    }

    public final /* synthetic */ int getOwnerId() {
        MapleDoor a2;
        return a2.d;
    }

    public final /* synthetic */ int getSkill() {
        MapleDoor a2;
        return a2.a;
    }

    @Override
    public final /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleDoor a3;
        if (a3.getOwner() == null) {
            return;
        }
        if (a3.K.getId() == a2.getPlayer().getMapId() || a3.getOwnerId() == a2.getPlayer().getId() && a3.getOwner().getParty() == null) {
            a2.sendPacket(MaplePacketCreator.spawnDoor(a3.getOwnerId(), a3.B.getId() == a2.getPlayer().getMapId() ? a3.k.getPosition() : a3.ALLATORIxDEMO, true));
            if (a3.getOwner() != null && a3.getOwner().getParty() != null && (a3.getOwnerId() == a2.getPlayer().getId() || a3.getOwner().getParty().getMemberById(a2.getPlayer().getId()) != null)) {
                MapleDoor mapleDoor = a3;
                a2.sendPacket(MaplePacketCreator.partyPortal(a3.B.getId(), a3.K.getId(), mapleDoor.a, mapleDoor.ALLATORIxDEMO));
            }
            MapleDoor mapleDoor = a3;
            a2.sendPacket(MaplePacketCreator.spawnPortal(a3.B.getId(), a3.K.getId(), mapleDoor.a, mapleDoor.ALLATORIxDEMO));
        }
    }

    public /* synthetic */ MapleDoor(MapleCharacter a2, Point a3, int a4) {
        MapleDoor a5;
        MapleDoor mapleDoor = a5;
        MapleCharacter mapleCharacter = a2;
        MapleDoor mapleDoor2 = a5;
        mapleDoor2.g = new WeakReference<MapleCharacter>(a2);
        a5.d = mapleCharacter.getId();
        a5.K = mapleCharacter.getMap();
        mapleDoor.ALLATORIxDEMO = a3;
        mapleDoor.setPosition(a5.ALLATORIxDEMO);
        mapleDoor.B = mapleDoor.K.getReturnMap();
        a5.k = a5.ALLATORIxDEMO();
        a5.a = a4;
    }
}

