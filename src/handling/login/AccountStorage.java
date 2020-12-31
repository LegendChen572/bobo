/*
 * Decompiled with CFR 0.150.
 */
package handling.login;

import client.MapleClient;
import client.messages.CommandExecute;
import client.messages.commands.player.eventSystem.AutoPickupSystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccountStorage {
    private final /* synthetic */ Lock d;
    private final /* synthetic */ Lock a;
    private final /* synthetic */ Map<Integer, MapleClient> ALLATORIxDEMO;
    private final /* synthetic */ ReentrantReadWriteLock K;

    public final /* synthetic */ int getConnectedClients() {
        AccountStorage a2;
        return a2.ALLATORIxDEMO.size();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcastGMPacket(byte[] a2) {
        AccountStorage a3;
        a3.a.lock();
        try {
            for (MapleClient mapleClient : a3.ALLATORIxDEMO.values()) {
                if (!mapleClient.isLoggedIn() || !mapleClient.isGm()) continue;
                mapleClient.sendPacket(a2);
            }
            return;
        }
        finally {
            a3.a.unlock();
        }
    }

    public final /* synthetic */ List<MapleClient> getAllClientsThreadSafe() {
        AccountStorage a2;
        ArrayList<MapleClient> arrayList = new ArrayList<MapleClient>();
        arrayList.addAll(a2.getAllClients());
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void deregisterAccount(MapleClient a2) {
        AccountStorage a3;
        a3.d.lock();
        try {
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (Map.Entry<Integer, MapleClient> entry : a3.ALLATORIxDEMO.entrySet()) {
                if (entry.getValue() != a2) continue;
                arrayList.add(entry.getKey());
            }
            Iterator<Map.Entry<Integer, MapleClient>> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)((Object)iterator.next());
                a3.ALLATORIxDEMO.remove(n2);
            }
            return;
        }
        finally {
            a3.d.unlock();
        }
    }

    public final /* synthetic */ Collection<MapleClient> getAllClients() {
        AccountStorage a2;
        a2.a.lock();
        try {
            Collection<MapleClient> collection = Collections.unmodifiableCollection(a2.ALLATORIxDEMO.values());
            return collection;
        }
        finally {
            a2.a.unlock();
        }
    }

    public final /* synthetic */ MapleClient getCharacterById(int a22) {
        AccountStorage a3;
        a3.a.lock();
        try {
            MapleClient a22 = a3.ALLATORIxDEMO.get(a22);
            return a22;
        }
        finally {
            a3.a.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ String getOnlinePlayers(boolean a22) {
        StringBuilder stringBuilder;
        AccountStorage a3;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!a22) {
            a3.a.lock();
            try {
                for (MapleClient mapleClient : a3.ALLATORIxDEMO.values()) {
                    if (mapleClient.isGm()) continue;
                    stringBuilder2.append(mapleClient.getAccountName());
                    stringBuilder2.append(CommandExecute.ALLATORIxDEMO("]u"));
                }
                stringBuilder = stringBuilder2;
            }
            finally {
                a3.a.unlock();
            }
        } else {
            a3.a.lock();
            try {
                Iterator<MapleClient> a22 = a3.ALLATORIxDEMO.values().iterator();
                while (a22.hasNext()) {
                    stringBuilder2.append(a22.next().getAccountName());
                    stringBuilder2.append(AutoPickupSystem.ALLATORIxDEMO("$g"));
                }
            }
            finally {
                a3.a.unlock();
            }
            stringBuilder = stringBuilder2;
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ int pendingClientSize(int a2) {
        AccountStorage a3;
        HashMap<Integer, MapleClient> hashMap = new HashMap<Integer, MapleClient>();
        for (MapleClient mapleClient : a3.ALLATORIxDEMO.values()) {
            if (mapleClient.getWorld() != a2) continue;
            hashMap.put(mapleClient.getAccID(), mapleClient);
        }
        return hashMap.size();
    }

    public final /* synthetic */ void registerAccount(MapleClient a2) {
        AccountStorage a3;
        a3.d.lock();
        try {
            a3.ALLATORIxDEMO.put(a2.getAccID(), a2);
            return;
        }
        finally {
            a3.d.unlock();
        }
    }

    public final /* synthetic */ void deregisterAccountById(int a2) {
        AccountStorage a3;
        a3.d.lock();
        try {
            a3.ALLATORIxDEMO.remove(a2);
            return;
        }
        finally {
            a3.d.unlock();
        }
    }

    public /* synthetic */ AccountStorage() {
        AccountStorage a2;
        AccountStorage accountStorage = a2;
        accountStorage.K = new ReentrantReadWriteLock();
        accountStorage.a = a2.K.readLock();
        accountStorage.d = accountStorage.K.writeLock();
        accountStorage.ALLATORIxDEMO = new HashMap<Integer, MapleClient>();
    }

    public final /* synthetic */ void broadcastPacket(byte[] a2) {
        AccountStorage a3;
        a3.a.lock();
        try {
            Iterator<MapleClient> iterator = a3.ALLATORIxDEMO.values().iterator();
            while (iterator.hasNext()) {
                iterator.next().sendPacket(a2);
            }
            return;
        }
        finally {
            a3.a.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MapleClient getClientByName(String a2) {
        AccountStorage a3;
        MapleClient mapleClient = null;
        a3.a.lock();
        try {
            for (MapleClient mapleClient2 : a3.ALLATORIxDEMO.values()) {
                if (!mapleClient2.getAccountName().equalsIgnoreCase(a2)) continue;
                mapleClient = mapleClient2;
            }
            return mapleClient;
        }
        finally {
            a3.a.unlock();
        }
    }
}

