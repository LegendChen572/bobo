/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleCharacter;
import client.MapleDiseaseValueHolder;
import client.MapleKeyLayout;
import handling.channel.ChannelServer;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.maps.MapleMap;
import tools.MaplePacketCreator;

public class MapleCarnivalParty {
    private /* synthetic */ boolean d;
    private /* synthetic */ short K;
    private final /* synthetic */ int B;
    private final /* synthetic */ int k;
    private final /* synthetic */ byte g;
    private final /* synthetic */ List<Integer> e;
    private /* synthetic */ short a;
    private final /* synthetic */ WeakReference<MapleCharacter> E;
    private final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ boolean allInMap(MapleMap a2) {
        MapleCarnivalParty a3;
        try {
            MapleCarnivalParty mapleCarnivalParty = a3;
            mapleCarnivalParty.ALLATORIxDEMO.readLock().lock();
            for (int n2 : mapleCarnivalParty.e) {
                if (a2.getCharacterById(n2) != null) continue;
                n2 = 0;
                return n2 != 0;
            }
        }
        finally {
            a3.ALLATORIxDEMO.readLock().unlock();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void warp(MapleMap a2, int a3) {
        MapleCarnivalParty a4;
        a4.ALLATORIxDEMO.readLock().lock();
        try {
            for (int n2 : a4.e) {
                MapleCarnivalParty mapleCarnivalParty = a4;
                MapleCharacter mapleCharacter = ChannelServer.getInstance(mapleCarnivalParty.B, mapleCarnivalParty.k).getPlayerStorage().getCharacterById(n2);
                if (mapleCharacter == null) continue;
                MapleMap mapleMap = a2;
                mapleCharacter.changeMap(mapleMap, mapleMap.getPortal(a3));
            }
            return;
        }
        finally {
            a4.ALLATORIxDEMO.readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void warp(MapleMap a2) {
        MapleCarnivalParty a3;
        a3.ALLATORIxDEMO.readLock().lock();
        try {
            for (int n2 : a3.e) {
                MapleCarnivalParty mapleCarnivalParty = a3;
                MapleCharacter mapleCharacter = ChannelServer.getInstance(mapleCarnivalParty.B, mapleCarnivalParty.k).getPlayerStorage().getCharacterById(n2);
                if (mapleCharacter == null) continue;
                mapleCharacter.changeMap(a2);
            }
            return;
        }
        finally {
            a3.ALLATORIxDEMO.readLock().unlock();
        }
    }

    public /* synthetic */ void setWinner(boolean a2) {
        a.d = a2;
    }

    public /* synthetic */ List<Integer> getMembers() {
        MapleCarnivalParty a2;
        return a2.e;
    }

    public final /* synthetic */ MapleCharacter getLeader() {
        MapleCarnivalParty a2;
        return (MapleCharacter)a2.E.get();
    }

    public /* synthetic */ int getTeam() {
        MapleCarnivalParty a2;
        return a2.g;
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2) {
        MapleCarnivalParty a3;
        try {
            MapleCarnivalParty mapleCarnivalParty = a3;
            mapleCarnivalParty.ALLATORIxDEMO.writeLock().lock();
            mapleCarnivalParty.e.add(a2);
            return;
        }
        finally {
            a3.ALLATORIxDEMO.writeLock().unlock();
        }
    }

    public /* synthetic */ int getTotalCP() {
        MapleCarnivalParty a2;
        return a2.a;
    }

    public /* synthetic */ void useCP(MapleCharacter a2, int a3) {
        MapleCharacter mapleCharacter;
        MapleCarnivalParty a4;
        if (a4.K >= a3) {
            mapleCharacter = a2;
            a4.K = (short)(a4.K - a3);
        } else {
            a4.K = 0;
            mapleCharacter = a2;
        }
        mapleCharacter.useCP(a3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void warp(MapleMap a2, String a3) {
        MapleCarnivalParty a4;
        a4.ALLATORIxDEMO.readLock().lock();
        try {
            for (int n2 : a4.e) {
                MapleCarnivalParty mapleCarnivalParty = a4;
                MapleCharacter mapleCharacter = ChannelServer.getInstance(mapleCarnivalParty.B, mapleCarnivalParty.k).getPlayerStorage().getCharacterById(n2);
                if (mapleCharacter == null) continue;
                MapleMap mapleMap = a2;
                mapleCharacter.changeMap(mapleMap, mapleMap.getPortal(a3));
            }
            return;
        }
        finally {
            a4.ALLATORIxDEMO.readLock().unlock();
        }
    }

    public /* synthetic */ boolean isWinner() {
        MapleCarnivalParty a2;
        return a2.d;
    }

    public /* synthetic */ MapleCarnivalParty(MapleCharacter a2, List<MapleCharacter> a3, byte a4) {
        MapleCarnivalParty a5;
        MapleCarnivalParty mapleCarnivalParty = a5;
        MapleCarnivalParty mapleCarnivalParty2 = a5;
        MapleCarnivalParty mapleCarnivalParty3 = a5;
        a5.e = new LinkedList<Integer>();
        a5.K = 0;
        mapleCarnivalParty2.a = 0;
        mapleCarnivalParty.d = false;
        mapleCarnivalParty2.ALLATORIxDEMO = new ReentrantReadWriteLock();
        mapleCarnivalParty.E = new WeakReference<MapleCharacter>(a2);
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            MapleCharacter mapleCharacter = (MapleCharacter)a3.next();
            object = a3;
            a5.ALLATORIxDEMO(mapleCharacter.getId());
        }
        MapleCarnivalParty mapleCarnivalParty4 = a5;
        MapleCharacter mapleCharacter = a2;
        a5.g = a4;
        mapleCarnivalParty4.B = mapleCharacter.getWorld();
        mapleCarnivalParty4.k = mapleCharacter.getClient().getChannel();
    }

    public /* synthetic */ int getAvailableCP() {
        MapleCarnivalParty a2;
        return a2.K;
    }

    public /* synthetic */ void displayMatchResult() {
        MapleCarnivalParty a2;
        String string = a2.d ? MapleDiseaseValueHolder.ALLATORIxDEMO("R\u0002F\u0004WX@\u0016Q\u0019J\u0001B\u001b\f\u0000J\u0019") : MapleKeyLayout.ALLATORIxDEMO("\f_\u0018Y\t\u0005\u001eK\u000fD\u0014\\\u001cFRF\u0012Y\u0018");
        String string2 = a2.d ? MapleDiseaseValueHolder.ALLATORIxDEMO(":L\u0015`\u0016Q\u0019J\u0001B\u001b\f J\u0019") : MapleKeyLayout.ALLATORIxDEMO("g\u0012H>K\u000fD\u0014\\\u001cFRf\u0012Y\u0018");
        boolean bl = false;
        for (int n2 : a2.e) {
            MapleCarnivalParty mapleCarnivalParty = a2;
            MapleCharacter mapleCharacter = ChannelServer.getInstance(mapleCarnivalParty.B, mapleCarnivalParty.k).getPlayerStorage().getCharacterById(n2);
            if (mapleCharacter == null) continue;
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.showEffect(string));
            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.playSound(string2));
            if (bl) continue;
            bl = true;
            MapleCharacter mapleCharacter3 = mapleCharacter;
            mapleCharacter3.getMap().killAllMonsters(true);
            mapleCharacter3.getMap().setSpawns(false);
        }
    }

    public /* synthetic */ void addCP(MapleCharacter a2, int a3) {
        MapleCarnivalParty a4;
        MapleCarnivalParty mapleCarnivalParty = a4;
        mapleCarnivalParty.a = (short)(mapleCarnivalParty.a + a3);
        int n2 = a3;
        mapleCarnivalParty.K = (short)(mapleCarnivalParty.K + n2);
        a2.addCP(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void removeMember(MapleCharacter a2) {
        MapleCarnivalParty a3;
        try {
            int n2;
            a3.ALLATORIxDEMO.writeLock().lock();
            int n3 = -1;
            int n4 = n2 = 0;
            while (n4 < a3.e.size()) {
                if (a3.e.get(n2).intValue() == a2.getId()) {
                    n3 = n2;
                }
                n4 = ++n2;
            }
            if (n3 != -1) {
                a2.setCarnivalParty(null);
                a3.e.remove(n3);
            }
            return;
        }
        finally {
            a3.ALLATORIxDEMO.writeLock().unlock();
        }
    }
}

