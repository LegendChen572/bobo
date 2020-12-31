/*
 * Decompiled with CFR 0.150.
 */
package handling.channel;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.inventory.InventoryException;
import client.messages.ConsoleCommandExecute;
import handling.world.CharacterTransfer;
import handling.world.CheaterData;
import handling.world.World;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.Timer;
import server.swing.WvsCenter;

public class PlayerStorage {
    private final /* synthetic */ Lock e;
    private final /* synthetic */ ReentrantReadWriteLock j;
    private final /* synthetic */ Lock H;
    private final /* synthetic */ ReentrantReadWriteLock C;
    private final /* synthetic */ Lock F;
    private final /* synthetic */ Lock J;
    private final /* synthetic */ Map<Integer, MapleCharacter> K;
    private final /* synthetic */ Map<Integer, CharacterTransfer> d;
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ Lock I;
    private final /* synthetic */ Lock g;
    private final /* synthetic */ Lock B;
    private final /* synthetic */ Map<Integer, MapleClient> a;
    private final /* synthetic */ Map<Integer, MapleCharacter> k;
    private final /* synthetic */ ReentrantReadWriteLock E;
    private final /* synthetic */ Lock i;
    private final /* synthetic */ ReentrantReadWriteLock M;

    public final /* synthetic */ int pendingCharacterSize(int a2) {
        PlayerStorage a3;
        HashMap<Integer, MapleCharacter> hashMap = new HashMap<Integer, MapleCharacter>();
        for (MapleCharacter mapleCharacter : a3.k.values()) {
            if (mapleCharacter.getWorld() != a2) continue;
            hashMap.put(mapleCharacter.getId(), mapleCharacter);
        }
        return hashMap.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void disconnectAll(MapleCharacter a2) {
        PlayerStorage a3;
        a3.J.lock();
        try {
            for (MapleCharacter mapleCharacter : a3.k.values()) {
                if (mapleCharacter.getGMLevel() >= a2.getGMLevel()) continue;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.getClient().disconnect();
                mapleCharacter2.getClient().getSession().close();
                World.Find.forceDeregister(mapleCharacter.getId(), mapleCharacter.getName());
            }
            return;
        }
        finally {
            a3.J.unlock();
        }
    }

    public final /* synthetic */ Collection<MapleClient> getAllPendingClients() {
        PlayerStorage a2;
        a2.i.lock();
        try {
            Collection<MapleClient> collection = a2.a.values();
            return collection;
        }
        finally {
            a2.i.unlock();
        }
    }

    public final /* synthetic */ boolean containsPlayerTransfer(int a2) {
        PlayerStorage a3;
        boolean bl = false;
        a3.B.lock();
        try {
            bl = a3.K.containsKey(a2);
            return bl;
        }
        finally {
            a3.B.unlock();
        }
    }

    public final /* synthetic */ void registerPlayer(MapleCharacter a2) {
        PlayerStorage a3;
        if (System.getProperty(ConsoleCommandExecute.ALLATORIxDEMO("\u001es,u9E4T:n#`")) != null) {
            WvsCenter.getInstance().updateCharTable(true, a2);
            WvsCenter.getInstance().updateOnlineNumber();
        }
        a3.J.lock();
        try {
            a3.k.put(a2.getId(), a2);
        }
        finally {
            a3.J.unlock();
        }
        World.Find.register(a2, a3.ALLATORIxDEMO, a2.getWorld());
    }

    public final /* synthetic */ void deregisterPendingClient(int a2) {
        PlayerStorage a3;
        a3.e.lock();
        try {
            a3.a.remove(a2);
            return;
        }
        finally {
            a3.e.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleCharacter getCharacterById(int a222) {
        PlayerStorage a3;
        a3.i.lock();
        try {
            MapleCharacter a222 = a3.k.get(a222);
            return a222;
        }
        catch (Exception a222) {
            MapleCharacter a222 = null;
            return a222;
        }
        finally {
            a3.i.unlock();
        }
    }

    public final /* synthetic */ Collection<MapleCharacter> getAllCharacters() {
        PlayerStorage a2;
        a2.i.lock();
        try {
            Collection<MapleCharacter> collection = Collections.unmodifiableCollection(a2.k.values());
            return collection;
        }
        finally {
            a2.i.unlock();
        }
    }

    public final /* synthetic */ Collection<CharacterTransfer> getAllPendingCharacters() {
        PlayerStorage a2;
        a2.i.lock();
        try {
            Collection<CharacterTransfer> collection = a2.d.values();
            return collection;
        }
        finally {
            a2.i.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcastEtcSmegaPacket(byte[] a2) {
        PlayerStorage a3;
        a3.i.lock();
        try {
            for (MapleCharacter mapleCharacter : a3.k.values()) {
                if (!mapleCharacter.getClient().isLoggedIn() || !mapleCharacter.getSmega()) continue;
                mapleCharacter.getClient().sendPacket(a2);
            }
            return;
        }
        finally {
            a3.i.unlock();
        }
    }

    public final /* synthetic */ void deregisterPlayer(int a2, String a3) {
        PlayerStorage a4;
        if (System.getProperty(ConsoleCommandExecute.ALLATORIxDEMO("\u001es,u9E4T:n#`")) != null) {
            WvsCenter.getInstance().updateCharTable(false, a4.k.get(a2));
        }
        a4.J.lock();
        try {
            a4.k.remove(a2);
        }
        finally {
            a4.J.unlock();
        }
        World.Find.forceDeregister(a2, a3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ String getOnlinePlayers(boolean a22) {
        StringBuilder stringBuilder;
        PlayerStorage a3;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!a22) {
            a3.i.lock();
            try {
                for (MapleCharacter mapleCharacter : a3.k.values()) {
                    if (mapleCharacter.isGM()) continue;
                    stringBuilder2.append(MapleCharacterUtil.makeMapleReadable(mapleCharacter.getName()));
                    stringBuilder2.append(ConsoleCommandExecute.ALLATORIxDEMO("a'"));
                }
                stringBuilder = stringBuilder2;
            }
            finally {
                a3.i.unlock();
            }
        } else {
            a3.i.lock();
            try {
                Iterator<MapleCharacter> a22 = a3.k.values().iterator();
                while (a22.hasNext()) {
                    stringBuilder2.append(MapleCharacterUtil.makeMapleReadable(a22.next().getName()));
                    stringBuilder2.append(InventoryException.ALLATORIxDEMO("VA"));
                }
            }
            finally {
                a3.i.unlock();
            }
            stringBuilder = stringBuilder2;
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ void registerPendingClient(MapleClient a2, int a3) {
        PlayerStorage a4;
        a4.e.lock();
        try {
            a4.a.put(a3, a2);
            return;
        }
        finally {
            a4.e.unlock();
        }
    }

    public /* synthetic */ void removePlayer(MapleCharacter a2) {
        PlayerStorage a3;
        a3.deregisterPlayer(a2);
    }

    public /* synthetic */ PlayerStorage(int a2) {
        PlayerStorage a3;
        PlayerStorage playerStorage = a3;
        PlayerStorage playerStorage2 = a3;
        playerStorage2.j = new ReentrantReadWriteLock();
        playerStorage2.i = a3.j.readLock();
        playerStorage2.J = playerStorage2.j.writeLock();
        playerStorage2.M = new ReentrantReadWriteLock();
        playerStorage2.I = playerStorage2.M.readLock();
        playerStorage2.F = playerStorage2.M.writeLock();
        playerStorage2.C = new ReentrantReadWriteLock();
        playerStorage2.H = playerStorage2.C.readLock();
        playerStorage2.e = playerStorage2.C.writeLock();
        playerStorage2.E = new ReentrantReadWriteLock();
        playerStorage2.g = playerStorage2.E.readLock();
        playerStorage2.B = playerStorage2.E.writeLock();
        playerStorage2.k = new HashMap<Integer, MapleCharacter>();
        playerStorage2.K = new HashMap<Integer, MapleCharacter>();
        playerStorage.a = new HashMap<Integer, MapleClient>();
        playerStorage.d = new HashMap<Integer, CharacterTransfer>();
        playerStorage.ALLATORIxDEMO = a2;
        Timer.PingTimer.getInstance().schedule(a3.new PersistingTask(), 2700000L);
    }

    public final /* synthetic */ void deregisterPendingPlayer(int a2) {
        PlayerStorage a3;
        a3.F.lock();
        try {
            a3.d.remove(a2);
            return;
        }
        finally {
            a3.F.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void registerPendingPlayer(CharacterTransfer a2, int a3) {
        PlayerStorage a4;
        a4.F.lock();
        try {
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            for (CharacterTransfer characterTransfer : a4.d.values()) {
                if (characterTransfer.accountid != a2.accountid) continue;
                linkedList.add(characterTransfer.characterid);
            }
            Iterator<CharacterTransfer> iterator = linkedList.iterator();
            Iterator<Object> iterator2 = iterator;
            while (iterator2.hasNext()) {
                int n2 = (Integer)((Object)iterator.next());
                iterator2 = iterator;
                a4.d.remove(n2);
            }
            a4.d.put(a3, a2);
            return;
        }
        finally {
            a4.F.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void disconnectAll(boolean a2) {
        PlayerStorage a3;
        a3.J.lock();
        try {
            for (MapleCharacter mapleCharacter : a3.k.values()) {
                if (mapleCharacter.isGM() && a2 || mapleCharacter.getClient() == null) continue;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                MapleCharacter mapleCharacter3 = mapleCharacter;
                World.Find.forceDeregister(mapleCharacter2.getId(), mapleCharacter3.getName());
                mapleCharacter2.getClient().disconnect();
                if (mapleCharacter3.getClient().getSession() == null) continue;
                mapleCharacter.getClient().getSession().close();
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        finally {
            a3.J.unlock();
        }
    }

    public final /* synthetic */ void SessionCloseAll() {
        PlayerStorage a2;
        a2.J.lock();
        try {
            for (MapleCharacter mapleCharacter : a2.k.values()) {
                if (mapleCharacter.getClient() == null) continue;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                World.Find.forceDeregister(mapleCharacter.getId(), mapleCharacter2.getName());
                if (mapleCharacter2.getClient().getSession() == null) continue;
                mapleCharacter.getClient().getSession().close();
            }
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        finally {
            a2.J.unlock();
        }
    }

    public final /* synthetic */ MapleClient getPendingClient(int a2) {
        MapleClient mapleClient;
        PlayerStorage a3;
        a3.H.lock();
        try {
            mapleClient = a3.a.get(a2);
        }
        finally {
            a3.H.unlock();
        }
        if (mapleClient != null) {
            a3.deregisterPendingClient(a2);
        }
        return mapleClient;
    }

    public final /* synthetic */ List<MapleCharacter> getAllCharactersThreadSafe() {
        ArrayList<MapleCharacter> arrayList = new ArrayList<MapleCharacter>();
        try {
            PlayerStorage a2;
            arrayList.addAll(a2.getAllCharacters());
            return arrayList;
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            return arrayList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcastPacket(byte[] a2) {
        PlayerStorage a3;
        a3.i.lock();
        try {
            for (MapleCharacter mapleCharacter : a3.k.values()) {
                if (!mapleCharacter.getGashaponMega()) continue;
                mapleCharacter.getClient().sendPacket(a2);
            }
            return;
        }
        finally {
            a3.i.unlock();
        }
    }

    public final /* synthetic */ Collection<MapleCharacter> getAllCharactersTransfer() {
        PlayerStorage a2;
        a2.g.lock();
        try {
            Collection<MapleCharacter> collection = Collections.unmodifiableCollection(a2.K.values());
            return collection;
        }
        finally {
            a2.g.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcastGMPacket(byte[] a2, boolean a3) {
        PlayerStorage a4;
        a4.i.lock();
        try {
            for (MapleCharacter mapleCharacter : a4.k.values()) {
                if (!mapleCharacter.getClient().isLoggedIn() || !mapleCharacter.isGM() || !mapleCharacter.getmsg_MobVac()) continue;
                mapleCharacter.getClient().sendPacket(a2);
            }
            return;
        }
        finally {
            a4.i.unlock();
        }
    }

    public final /* synthetic */ void deregisterPlayer(MapleCharacter a2) {
        PlayerStorage a3;
        if (System.getProperty(InventoryException.ALLATORIxDEMO(")\u0015\u001b\u0013\u000e#\u00032\r\b\u0014\u0006")) != null) {
            WvsCenter.getInstance().updateCharTable(false, a2);
        }
        a3.J.lock();
        try {
            a3.k.remove(a2.getId());
        }
        finally {
            a3.J.unlock();
        }
        World.Find.forceDeregister(a2.getId(), a2.getName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcastSmegaPacket(byte[] a2) {
        PlayerStorage a3;
        a3.i.lock();
        try {
            for (MapleCharacter mapleCharacter : a3.k.values()) {
                if (!mapleCharacter.getClient().isLoggedIn() || !mapleCharacter.getSmega()) continue;
                mapleCharacter.getClient().sendPacket(a2);
            }
            return;
        }
        finally {
            a3.i.unlock();
        }
    }

    public final /* synthetic */ void deregisterPlayerTransfer(MapleCharacter a2) {
        PlayerStorage a3;
        a3.J.lock();
        try {
            a3.K.remove(a2.getId());
            return;
        }
        finally {
            a3.J.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleCharacter getCharacterByName(String a2) {
        PlayerStorage a3;
        MapleCharacter mapleCharacter = null;
        a3.i.lock();
        try {
            for (MapleCharacter mapleCharacter2 : a3.k.values()) {
                if (!mapleCharacter2.getName().equalsIgnoreCase(a2)) continue;
                mapleCharacter = mapleCharacter2;
            }
            return mapleCharacter;
        }
        catch (Exception exception) {
            MapleCharacter mapleCharacter3 = null;
            return mapleCharacter3;
        }
        finally {
            a3.i.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ List<CheaterData> getCheaters() {
        PlayerStorage a2;
        ArrayList<CheaterData> arrayList = new ArrayList<CheaterData>();
        a2.i.lock();
        try {
            for (MapleCharacter mapleCharacter : a2.k.values()) {
                if (mapleCharacter.getCheatTracker().getPoints() <= 0) continue;
                arrayList.add(new CheaterData(mapleCharacter.getCheatTracker().getPoints(), MapleCharacterUtil.makeMapleReadable(mapleCharacter.getName()) + "(\u7de8\u865f:" + mapleCharacter.getId() + ") \u6aa2\u6e2c\u6b21\u6578(" + mapleCharacter.getCheatTracker().getPoints() + ") " + mapleCharacter.getCheatTracker().getSummary() + " \u5730\u5716:" + mapleCharacter.getMap().getMapName()));
            }
            return arrayList;
        }
        finally {
            a2.i.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void deregisterPendingPlayerByAccountId(int a2) {
        PlayerStorage a3;
        a3.F.lock();
        try {
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            for (CharacterTransfer characterTransfer : a3.d.values()) {
                if (characterTransfer.accountid != a2) continue;
                linkedList.add(characterTransfer.characterid);
            }
            Iterator<CharacterTransfer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)((Object)iterator.next());
                a3.d.remove(n2);
            }
            return;
        }
        finally {
            a3.F.unlock();
        }
    }

    public final /* synthetic */ void disconnectAll() {
        PlayerStorage a2;
        a2.disconnectAll(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcastGMPacket(byte[] a2) {
        PlayerStorage a3;
        a3.i.lock();
        try {
            for (MapleCharacter mapleCharacter : a3.k.values()) {
                if (!mapleCharacter.getClient().isLoggedIn() || !mapleCharacter.isGM()) continue;
                mapleCharacter.getClient().sendPacket(a2);
            }
            return;
        }
        finally {
            a3.i.unlock();
        }
    }

    public final /* synthetic */ void deregisterPlayerTransfer(int a2) {
        PlayerStorage a3;
        a3.B.lock();
        try {
            a3.K.remove(a2);
            return;
        }
        finally {
            a3.B.unlock();
        }
    }

    public final /* synthetic */ void registerPlayerTransfer(MapleCharacter a2) {
        PlayerStorage a3;
        a3.B.lock();
        try {
            if (a2 != null) {
                a2.setTransferTime(System.currentTimeMillis());
                a3.K.put(a2.getId(), a2);
            }
            return;
        }
        finally {
            a3.B.unlock();
        }
    }

    public final /* synthetic */ List<MapleCharacter> getAllCharactersTransferThreadSafe() {
        ArrayList<MapleCharacter> arrayList = new ArrayList<MapleCharacter>();
        try {
            PlayerStorage a2;
            arrayList.addAll(a2.getAllCharactersTransfer());
            return arrayList;
        }
        catch (ConcurrentModificationException concurrentModificationException) {
            return arrayList;
        }
    }

    public final /* synthetic */ CharacterTransfer getPendingCharacter(int a2) {
        CharacterTransfer characterTransfer;
        PlayerStorage a3;
        a3.I.lock();
        try {
            characterTransfer = a3.d.get(a2);
        }
        finally {
            a3.I.unlock();
        }
        if (characterTransfer != null) {
            a3.deregisterPendingPlayer(a2);
        }
        return characterTransfer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleCharacter getCharacterTransferById(int a222) {
        PlayerStorage a3;
        a3.i.lock();
        try {
            MapleCharacter a222 = a3.K.get(a222);
            return a222;
        }
        catch (Exception a222) {
            MapleCharacter a222 = null;
            return a222;
        }
        finally {
            a3.i.unlock();
        }
    }

    public final /* synthetic */ int getConnectedClients() {
        PlayerStorage a2;
        return a2.k.size();
    }

    public class PersistingTask
    implements Runnable {
        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public /* synthetic */ void run() {
            PersistingTask a2;
            a2.PlayerStorage.this.F.lock();
            try {
                long l2 = System.currentTimeMillis();
                Iterator iterator = a2.PlayerStorage.this.d.entrySet().iterator();
                while (iterator.hasNext()) {
                    if (l2 - ((CharacterTransfer)iterator.next().getValue()).TranferTime <= 40000L) continue;
                    iterator.remove();
                }
                return;
            }
            finally {
                a2.PlayerStorage.this.F.unlock();
            }
        }

        public /* synthetic */ PersistingTask() {
            PersistingTask a3;
        }
    }
}

