/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.inventory;

import client.messages.commands.player.\u6bd4\u5947\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.ServerSet;
import database.DBConPool;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tools.wztosql.DumpItemsAdditions;

public class MapleInventoryIdentifier
implements Serializable {
    private /* synthetic */ ReentrantReadWriteLock K;
    private /* synthetic */ Lock a;
    private static /* synthetic */ MapleInventoryIdentifier ALLATORIxDEMO;
    private /* synthetic */ Lock d;
    private static final /* synthetic */ long B = 21830921831301L;
    private /* synthetic */ AtomicInteger k;

    public /* synthetic */ void setRunningUID(int a2) {
        MapleInventoryIdentifier a3;
        if (a2 < a3.grabRunningUID()) {
            return;
        }
        a3.d.lock();
        try {
            a3.k.set(a2);
            return;
        }
        finally {
            a3.d.unlock();
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new MapleInventoryIdentifier();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ int initUID() {
        DruidPooledConnection druidPooledConnection;
        DruidPooledConnection druidPooledConnection2;
        int n2;
        block11: {
            MapleInventoryIdentifier a2;
            n2 = 0;
            if (a2.grabRunningUID() > 0) {
                return a2.grabRunningUID();
            }
            try {
                druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    Object var3_4 = null;
                    Object var4_6 = null;
                    if (ServerSet.getServerSet(DumpItemsAdditions.ALLATORIxDEMO("S'O8S,O-")) == 0L) {
                        n2 = 1;
                        druidPooledConnection = druidPooledConnection2;
                        break block11;
                    }
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (druidPooledConnection2 != null) {
                        try {
                            druidPooledConnection2.close();
                            throwable2 = throwable;
                            throw throwable2;
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                    }
                    throwable2 = throwable;
                    throw throwable2;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return n2;
            }
            {
                n2 = (int)ServerSet.getServerSet(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"8\u001a$\u00058\u0011$\u0010"));
                druidPooledConnection = druidPooledConnection2;
            }
        }
        if (druidPooledConnection == null) return n2;
        druidPooledConnection2.close();
        return n2;
    }

    public /* synthetic */ int grabRunningUID() {
        MapleInventoryIdentifier a2;
        a2.a.lock();
        try {
            int n2 = a2.k.get();
            if (n2 != 0) {
                ServerSet.setServerSet(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"8\u001a$\u00058\u0011$\u0010"), n2);
            }
            return n2;
        }
        finally {
            a2.a.unlock();
        }
    }

    public /* synthetic */ MapleInventoryIdentifier() {
        MapleInventoryIdentifier a2;
        MapleInventoryIdentifier mapleInventoryIdentifier = a2;
        mapleInventoryIdentifier.K = new ReentrantReadWriteLock();
        mapleInventoryIdentifier.a = a2.K.readLock();
        mapleInventoryIdentifier.d = mapleInventoryIdentifier.K.writeLock();
        mapleInventoryIdentifier.k = new AtomicInteger(0);
        mapleInventoryIdentifier.getNextUniqueId();
    }

    public /* synthetic */ void incrementRunningUID() {
        MapleInventoryIdentifier a2;
        MapleInventoryIdentifier mapleInventoryIdentifier = a2;
        mapleInventoryIdentifier.setRunningUID(mapleInventoryIdentifier.grabRunningUID() + 1);
    }

    public static /* synthetic */ int getInstance() {
        return ALLATORIxDEMO.getNextUniqueId();
    }

    public /* synthetic */ int getNextUniqueId() {
        MapleInventoryIdentifier a2;
        if (a2.grabRunningUID() <= 0) {
            MapleInventoryIdentifier mapleInventoryIdentifier = a2;
            mapleInventoryIdentifier.setRunningUID(mapleInventoryIdentifier.initUID());
        }
        MapleInventoryIdentifier mapleInventoryIdentifier = a2;
        mapleInventoryIdentifier.incrementRunningUID();
        return mapleInventoryIdentifier.grabRunningUID();
    }
}

