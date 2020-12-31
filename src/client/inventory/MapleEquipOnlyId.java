/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.inventory;

import client.MapleCoolDownValueHolder;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import constants.ServerSet;
import database.DBConPool;
import handling.world.family.MapleFamily;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

public class MapleEquipOnlyId {
    private final /* synthetic */ AtomicLong ALLATORIxDEMO;

    public /* synthetic */ long initOnlyId() {
        long l2 = 0L;
        if (GameSetConstants.NEW_ITEM_SAVE) {
            if (ServerSet.getServerSet(MapleFamily.ALLATORIxDEMO("%\u001f5\u00070!.\u00029'$")) == 0L) {
                l2 = 100000000L;
                return 100000000L;
            }
            l2 = (int)ServerSet.getServerSet(MapleCoolDownValueHolder.ALLATORIxDEMO("F*V2S\u0014M7Z\u0012G"));
            return l2;
        }
        try {
            DruidPooledConnection druidPooledConnection;
            DruidPooledConnection druidPooledConnection2;
            block25: {
                druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    PreparedStatement preparedStatement;
                    PreparedStatement preparedStatement2;
                    block23: {
                        preparedStatement2 = druidPooledConnection2.prepareStatement(MapleFamily.ALLATORIxDEMO("\u0013+\f+\u0003:`#\u00016h\u000b1\u001b)\u001e\u000f\u0000,\u0017\t\niN\u0006<\u000f#`\u0007.\u0018%\u00004\u00012\u0017)\u001a%\u00033N\u0017&\u0005<\u0005N%\u001f5\u00070!.\u00029'$N~Np"));
                        try {
                            block22: {
                                ResultSet resultSet = preparedStatement2.executeQuery();
                                try {
                                    if (resultSet.next()) {
                                        l2 = resultSet.getLong(1) + 1L;
                                    }
                                    preparedStatement2.close();
                                    if (resultSet == null) break block22;
                                    preparedStatement = preparedStatement2;
                                }
                                catch (Throwable throwable) {
                                    Throwable throwable2;
                                    block24: {
                                        if (resultSet != null) {
                                            try {
                                                resultSet.close();
                                                throwable2 = throwable;
                                                break block24;
                                            }
                                            catch (Throwable throwable3) {
                                                throwable.addSuppressed(throwable3);
                                            }
                                        }
                                        throwable2 = throwable;
                                    }
                                    throw throwable2;
                                }
                                resultSet.close();
                                break block23;
                            }
                            preparedStatement = preparedStatement2;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable4;
                            block26: {
                                if (preparedStatement2 != null) {
                                    try {
                                        preparedStatement2.close();
                                        throwable4 = throwable;
                                        break block26;
                                    }
                                    catch (Throwable throwable5) {
                                        throwable.addSuppressed(throwable5);
                                    }
                                }
                                throwable4 = throwable;
                            }
                            throw throwable4;
                        }
                    }
                    if (preparedStatement != null) {
                        druidPooledConnection = druidPooledConnection2;
                        preparedStatement2.close();
                        break block25;
                    }
                    druidPooledConnection = druidPooledConnection2;
                }
                catch (Throwable throwable) {
                    Throwable throwable6;
                    block28: {
                        if (druidPooledConnection2 != null) {
                            try {
                                druidPooledConnection2.close();
                                throwable6 = throwable;
                                break block28;
                            }
                            catch (Throwable throwable7) {
                                throwable.addSuppressed(throwable7);
                            }
                        }
                        throwable6 = throwable;
                    }
                    throw throwable6;
                }
            }
            if (druidPooledConnection != null) {
                druidPooledConnection2.close();
            }
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
        return l2;
    }

    public /* synthetic */ long getNextEquipOnlyId() {
        MapleEquipOnlyId mapleEquipOnlyId;
        MapleEquipOnlyId a2;
        if (a2.ALLATORIxDEMO.get() <= 0L) {
            MapleEquipOnlyId mapleEquipOnlyId2 = a2;
            mapleEquipOnlyId = mapleEquipOnlyId2;
            a2.ALLATORIxDEMO.set(mapleEquipOnlyId2.initOnlyId());
        } else {
            MapleEquipOnlyId mapleEquipOnlyId3 = a2;
            mapleEquipOnlyId = mapleEquipOnlyId3;
            long l2 = mapleEquipOnlyId3.ALLATORIxDEMO.get() + 1L;
            mapleEquipOnlyId3.ALLATORIxDEMO.set(l2);
            ServerSet.setServerSet(MapleCoolDownValueHolder.ALLATORIxDEMO("F*V2S\u0014M7Z\u0012G"), l2);
        }
        return mapleEquipOnlyId.ALLATORIxDEMO.get();
    }

    public /* synthetic */ MapleEquipOnlyId(1 a2) {
        a3();
        MapleEquipOnlyId a3;
    }

    private /* synthetic */ MapleEquipOnlyId() {
        MapleEquipOnlyId a2;
        MapleEquipOnlyId mapleEquipOnlyId = a2;
        mapleEquipOnlyId.ALLATORIxDEMO = new AtomicLong(0L);
    }

    public static /* synthetic */ MapleEquipOnlyId getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        public static final /* synthetic */ MapleEquipOnlyId instance;

        private /* synthetic */ SingletonHolder() {
            SingletonHolder a2;
        }

        public static /* synthetic */ {
            instance = new MapleEquipOnlyId(null);
        }
    }
}

