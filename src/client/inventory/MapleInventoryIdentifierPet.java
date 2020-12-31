/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.inventory;

import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import tools.googledrive.SyncServerData;

public class MapleInventoryIdentifierPet
implements Serializable {
    private /* synthetic */ AtomicInteger k;
    private static final /* synthetic */ long B = 21830921831301L;
    private /* synthetic */ Lock d;
    private /* synthetic */ ReentrantReadWriteLock K;
    private /* synthetic */ Lock a;
    private static /* synthetic */ MapleInventoryIdentifierPet ALLATORIxDEMO;

    public /* synthetic */ void setRunningUID(int a2) {
        MapleInventoryIdentifierPet a3;
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

    public /* synthetic */ MapleInventoryIdentifierPet() {
        MapleInventoryIdentifierPet a2;
        MapleInventoryIdentifierPet mapleInventoryIdentifierPet = a2;
        mapleInventoryIdentifierPet.K = new ReentrantReadWriteLock();
        mapleInventoryIdentifierPet.a = a2.K.readLock();
        mapleInventoryIdentifierPet.d = mapleInventoryIdentifierPet.K.writeLock();
        mapleInventoryIdentifierPet.k = new AtomicInteger(0);
        mapleInventoryIdentifierPet.getNextUniqueId();
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new MapleInventoryIdentifierPet();
    }

    public /* synthetic */ int getNextUniqueId() {
        MapleInventoryIdentifierPet a2;
        if (a2.grabRunningUID() <= 0) {
            MapleInventoryIdentifierPet mapleInventoryIdentifierPet = a2;
            mapleInventoryIdentifierPet.setRunningUID(mapleInventoryIdentifierPet.initUID());
        }
        MapleInventoryIdentifierPet mapleInventoryIdentifierPet = a2;
        mapleInventoryIdentifierPet.incrementRunningUID();
        return mapleInventoryIdentifierPet.grabRunningUID();
    }

    public /* synthetic */ void incrementRunningUID() {
        MapleInventoryIdentifierPet a2;
        MapleInventoryIdentifierPet mapleInventoryIdentifierPet = a2;
        mapleInventoryIdentifierPet.setRunningUID(mapleInventoryIdentifierPet.grabRunningUID() + 1);
    }

    public /* synthetic */ int grabRunningUID() {
        MapleInventoryIdentifierPet a2;
        a2.a.lock();
        try {
            int n2 = a2.k.get();
            return n2;
        }
        finally {
            a2.a.unlock();
        }
    }

    public static /* synthetic */ int getInstance() {
        return ALLATORIxDEMO.getNextUniqueId();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ int initUID() {
        MapleInventoryIdentifierPet a2;
        int n2 = 0;
        if (a2.grabRunningUID() > 0) {
            return a2.grabRunningUID();
        }
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            preparedStatement = druidPooledConnection.prepareStatement(SyncServerData.ALLATORIxDEMO("Y0F0I!*8K-\"\u0005o\u0001c\u0011#UL'E8*\u0005o\u0001y"));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                n2 = resultSet.getInt(1) + 1;
            }
            resultSet.close();
            preparedStatement.close();
            if (druidPooledConnection == null) return n2;
        }
        catch (Throwable throwable) {
            try {
                Throwable throwable2;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
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
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        druidPooledConnection.close();
        return n2;
    }
}

