/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.maps.Extend;

import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import server.MapleCarnivalChallenge;
import server.maps.Extend.MapNoticeData;
import server.maps.MapNameData;

public class MapNoticeFactory {
    private static final /* synthetic */ MapNoticeFactory ALLATORIxDEMO;
    public final /* synthetic */ Map<Integer, MapNoticeData> MapNoticeCache;

    public static final /* synthetic */ MapNoticeFactory getInstance() {
        return ALLATORIxDEMO;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void loadMapNotice() {
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleCarnivalChallenge.ALLATORIxDEMO("\"Y=Y2HQ6QZ#S<<\u001c}\u0001r\u001eh\u0018\u007f\u0014"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            MapNoticeFactory a2;
            int n2 = resultSet.getInt(MapNameData.ALLATORIxDEMO("(\u007f+c1u7y!"));
            MapNoticeData mapNoticeData = new MapNoticeData(n2, resultSet.getInt(MapleCarnivalChallenge.ALLATORIxDEMO("\u001c}\u0001u\u0015")), resultSet.getInt(MapNameData.ALLATORIxDEMO("&x$~\"u(q5")), resultSet.getString(MapleCarnivalChallenge.ALLATORIxDEMO("y\u0007y\u001fh\u0012s\u0004r\u0005")), resultSet.getString(MapNameData.ALLATORIxDEMO("s*~\"b$d0|$d,\u007f+")));
            a2.MapNoticeCache.put(n2, mapNoticeData);
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
            return;
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block11: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block11;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                    }
                    throw throwable2;
                }
                catch (SQLException sQLException) {
                    System.out.println(sQLException);
                }
            }
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new MapNoticeFactory();
    }

    public final /* synthetic */ MapNoticeData getMapNotice(int a2) {
        MapNoticeFactory a3;
        if (a3.MapNoticeCache.containsKey(a2)) {
            return a3.MapNoticeCache.get(a2);
        }
        return null;
    }

    public /* synthetic */ MapNoticeFactory() {
        MapNoticeFactory a2;
        MapNoticeFactory mapNoticeFactory = a2;
        mapNoticeFactory.MapNoticeCache = new HashMap<Integer, MapNoticeData>();
        System.out.println(MapNameData.ALLATORIxDEMO("\u3000\u8bc5\u53c6\u4e68\u3001e]$`\u000b\u007f1y&u\u0003q&d*b<0\u007f*\u007f"));
    }
}

