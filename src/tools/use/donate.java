/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.use;

import client.MapleCharacter;
import client.messages.ConsoleCommandExecute;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.channel.ChannelServer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import tools.Quadra;

public class donate {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ 3;
        int cfr_ignored_0 = 5 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 4 << 4 ^ 3 << 1;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ HashMap<MapleCharacter, String> Donate() {
        Object object;
        LinkedHashMap<MapleCharacter, String> linkedHashMap;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        DruidPooledConnection druidPooledConnection;
        try {
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                preparedStatement = druidPooledConnection.prepareStatement(Quadra.ALLATORIxDEMO("\u001as\u0005s\nbi\u001cip\u001by\u0004\u0016-Y'W=Sia\u0001s\u001bsis\nf(Oi\u000bi\u0007r"));
                resultSet = preparedStatement.executeQuery();
                linkedHashMap = new LinkedHashMap<MapleCharacter, String>();
                while (resultSet.next()) {
                    object = ChannelServer.getAllChannelInstances().iterator();
                    while (object.hasNext()) {
                        for (MapleCharacter mapleCharacter : object.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                            if (!mapleCharacter.getClient().getAccountName().equals(resultSet.getString(ConsoleCommandExecute.ALLATORIxDEMO("f.d\"r#s"))) || linkedHashMap.containsKey(mapleCharacter)) continue;
                            linkedHashMap.put(mapleCharacter, resultSet.getString(Quadra.ALLATORIxDEMO("\u0019W0u&R,")));
                        }
                    }
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
        catch (SQLException sQLException) {
            System.out.println("donate error :" + sQLException);
            return null;
        }
        {
            preparedStatement.close();
            resultSet.close();
            druidPooledConnection.close();
            object = linkedHashMap.size() > 0 ? linkedHashMap : null;
            if (druidPooledConnection == null) return object;
        }
        druidPooledConnection.close();
        return object;
    }

    public static /* synthetic */ void Start() {
        donate.gainDonate();
    }

    public /* synthetic */ donate() {
        donate a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ int getMoney(String a2) {
        try {
            int n2;
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                preparedStatement = druidPooledConnection.prepareStatement(ConsoleCommandExecute.ALLATORIxDEMO("\u001eB\u0001B\u000eSm-mA\u001fH\u0000')h#f9bmP\u0005B\u001fBmW,~\u000eh)bm:m8"));
                preparedStatement.setString(1, a2);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    n2 = 0;
                    n2 = resultSet.getInt(Quadra.ALLATORIxDEMO("$Y'S0"));
                    if (n2 == 0) continue;
                    if (druidPooledConnection == null) return n2;
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
            {
                druidPooledConnection.close();
                return n2;
            }
            preparedStatement.close();
            resultSet.close();
            druidPooledConnection.close();
            if (druidPooledConnection == null) return 0;
            druidPooledConnection.close();
            return 0;
        }
        catch (SQLException sQLException) {
            System.out.println("getMoney error:" + sQLException);
            return 0;
        }
    }

    public static /* synthetic */ void gainDonate() {
        HashMap<MapleCharacter, String> hashMap = donate.Donate();
        if (hashMap != null) {
            Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
            while (iterator.hasNext()) {
                for (MapleCharacter mapleCharacter : iterator.next().getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (mapleCharacter == null || !hashMap.containsKey(mapleCharacter)) continue;
                    String string = hashMap.get(mapleCharacter);
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    String string2 = string;
                    mapleCharacter2.gainDonate(string2, donate.getMoney(string2));
                    hashMap.remove(mapleCharacter2, string);
                }
            }
        }
    }
}

