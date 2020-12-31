/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.wztosql;

import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import database.DBConPool;
import handling.world.guild.MapleGuild;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import tools.JsonMapConverter;

public class DumpOxQuizData {
    public static /* synthetic */ CharsetEncoder ALLATORIxDEMO;

    public static /* synthetic */ void start(String[] a2) {
        try {
            GameSetConstants.loadsetting();
            GameSetConstants.reloadset();
            System.out.println(JsonMapConverter.ALLATORIxDEMO("K-U\u0000m\u000f*\u001ci\u0012$\u8bf5\u53d2\u4e58$[*["));
            DumpOxQuizData dumpOxQuizData = new DumpOxQuizData();
            dumpOxQuizData.dumpOxData();
            System.out.println(MapleGuild.ALLATORIxDEMO("/|@u\u0015m\u001a$\u8be0\u53d2\u8ca7\u659d\u5bec\u6214\u3062"));
            return;
        }
        catch (SQLException sQLException) {
            Logger.getLogger(DumpOxQuizData.class.getName()).log(Level.SEVERE, null, sQLException);
            return;
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = Charset.forName(MapleGuild.ALLATORIxDEMO("5P&)X")).newEncoder();
    }

    public /* synthetic */ DumpOxQuizData() {
        DumpOxQuizData a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void dumpOxData() throws SQLException {
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        try {
            MapleDataProvider mapleDataProvider = MapleDataProviderFactory.getDataProvider(JsonMapConverter.ALLATORIxDEMO("A\u0001g[s\u000f"));
            MapleData mapleData = mapleDataProvider.getData(MapleGuild.ALLATORIxDEMO("K8U\u0015m\u001a*\ti\u0007"));
            PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("1A9A!AUB'K8$\u0015s\u000f[\u001a|\u0011e\u0001e\u0015"));
            preparedStatement.execute();
            preparedStatement.close();
            Iterator<MapleData> iterator = mapleData.getChildren().iterator();
            block6: while (true) {
                if (!iterator.hasNext()) {
                    if (druidPooledConnection == null) return;
                    druidPooledConnection.close();
                    return;
                }
                MapleData mapleData2 = iterator.next();
                Iterator<MapleData> iterator2 = mapleData2.getChildren().iterator();
                block7: while (true) {
                    Iterator<MapleData> iterator3 = iterator2;
                    while (true) {
                        MapleData mapleData3;
                        String string;
                        if (!iterator3.hasNext()) continue block6;
                        MapleData mapleData4 = iterator2.next();
                        MapleData mapleData5 = mapleData4.getChildByPath(MapleGuild.ALLATORIxDEMO("\u0011"));
                        MapleData mapleData6 = mapleData4.getChildByPath(JsonMapConverter.ALLATORIxDEMO("\u0011"));
                        int n2 = MapleDataTool.getInt(mapleData4.getChildByPath(MapleGuild.ALLATORIxDEMO("\u0001")));
                        String string2 = "";
                        String string3 = "";
                        if (n2 == 0) {
                            string = JsonMapConverter.ALLATORIxDEMO("\r");
                            mapleData3 = mapleData5;
                        } else {
                            string = MapleGuild.ALLATORIxDEMO("\u000f");
                            mapleData3 = mapleData5;
                        }
                        if (mapleData3 != null) {
                            string2 = (String)mapleData5.getData();
                        }
                        if (mapleData6 != null) {
                            string3 = (String)mapleData6.getData();
                        }
                        if (!ALLATORIxDEMO.canEncode(mapleData2.getName()) || !ALLATORIxDEMO.canEncode(mapleData4.getName()) || !ALLATORIxDEMO.canEncode(string2) || !ALLATORIxDEMO.canEncode(string3)) continue block7;
                        if (!ALLATORIxDEMO.canEncode(string)) {
                            iterator3 = iterator2;
                            continue;
                        }
                        preparedStatement = druidPooledConnection.prepareStatement(JsonMapConverter.ALLATORIxDEMO("<J&A'PUM;P:$\u0015s\u000f[\u001a|\u0011e\u0001e\u0015$]d\u0004q\u0010w\u0001m\u001aj\u0006a\u0001dY$\u0015u\u0000a\u0006p\u001ck\u001bm\u0011dY$\u0015u\u0000a\u0006p\u001ck\u001bdY$\u0015`\u001cw\u0005h\u0014}\u0015(Ud\u0014j\u0006s\u0010v\u0015-UR4H A&$];Y$J(U;Y$J(U;\\"));
                        iterator3 = iterator2;
                        PreparedStatement preparedStatement2 = preparedStatement;
                        PreparedStatement preparedStatement3 = preparedStatement;
                        preparedStatement.setString(1, mapleData2.getName());
                        preparedStatement3.setString(2, mapleData4.getName());
                        preparedStatement3.setString(3, string2);
                        preparedStatement2.setString(4, string3);
                        preparedStatement2.setString(5, string);
                        preparedStatement2.execute();
                        preparedStatement.close();
                    }
                    break;
                }
                break;
            }
        }
        catch (Throwable throwable) {
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
    }
}

