/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.inventory;

import client.messages.commands.player.\u738b\u4e4b\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.channel.handler.PlayersHandler;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapleInventoryIdentifierRing
implements Serializable {
    private static final /* synthetic */ long B = 21830921831301L;
    private /* synthetic */ Lock a;
    private /* synthetic */ AtomicInteger k;
    private static /* synthetic */ MapleInventoryIdentifierRing ALLATORIxDEMO;
    private /* synthetic */ Lock d;
    private /* synthetic */ ReentrantReadWriteLock K;

    public /* synthetic */ MapleInventoryIdentifierRing() {
        MapleInventoryIdentifierRing a2;
        MapleInventoryIdentifierRing mapleInventoryIdentifierRing = a2;
        mapleInventoryIdentifierRing.K = new ReentrantReadWriteLock();
        mapleInventoryIdentifierRing.a = a2.K.readLock();
        mapleInventoryIdentifierRing.d = mapleInventoryIdentifierRing.K.writeLock();
        mapleInventoryIdentifierRing.k = new AtomicInteger(0);
        mapleInventoryIdentifierRing.getNextUniqueId();
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new MapleInventoryIdentifierRing();
    }

    public /* synthetic */ void incrementRunningUID() {
        MapleInventoryIdentifierRing a2;
        MapleInventoryIdentifierRing mapleInventoryIdentifierRing = a2;
        mapleInventoryIdentifierRing.setRunningUID(mapleInventoryIdentifierRing.grabRunningUID() + 1);
    }

    public static /* synthetic */ int getInstance() {
        return ALLATORIxDEMO.getNextUniqueId();
    }

    public /* synthetic */ void setRunningUID(int a2) {
        MapleInventoryIdentifierRing a3;
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

    public /* synthetic */ int grabRunningUID() {
        MapleInventoryIdentifierRing a2;
        a2.a.lock();
        try {
            int n2 = a2.k.get();
            return n2;
        }
        finally {
            a2.a.unlock();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ int initUID() {
        MapleInventoryIdentifierRing a2;
        int n2 = 0;
        int n3 = 0;
        if (a2.grabRunningUID() > 0) {
            return a2.grabRunningUID();
        }
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            preparedStatement = druidPooledConnection.prepareStatement(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"MbRb]s>j_\u007f6UwIyNz\u000e>aLhS\u0007lNp@m"));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                n2 = resultSet.getInt(1) + 1;
            }
            resultSet.close();
            preparedStatement.close();
            preparedStatement = druidPooledConnection.prepareStatement(PlayersHandler.ALLATORIxDEMO("yCfCiR\nKk^\u0002vKt^hOtXoDaCb\u0003&lTeK\ntChMu"));
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                n3 = resultSet.getInt(1) + 1;
            }
            resultSet.close();
            preparedStatement.close();
            if (n3 > n2) {
                n2 = n3;
            }
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

    public /* synthetic */ int getNextUniqueId() {
        MapleInventoryIdentifierRing a2;
        if (a2.grabRunningUID() <= 0) {
            MapleInventoryIdentifierRing mapleInventoryIdentifierRing = a2;
            mapleInventoryIdentifierRing.setRunningUID(mapleInventoryIdentifierRing.initUID());
        }
        MapleInventoryIdentifierRing mapleInventoryIdentifierRing = a2;
        mapleInventoryIdentifierRing.incrementRunningUID();
        return mapleInventoryIdentifierRing.grabRunningUID();
    }
}

