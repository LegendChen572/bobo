/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client;

import com.alibaba.druid.pool.DruidPooledConnection;
import constants.SkillConstants;
import database.DBConPool;
import handling.channel.handler.BBSHandler;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import server.shark.SharkReader;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;

public class MapleKeyLayout
implements Serializable {
    private /* synthetic */ boolean d;
    private static final /* synthetic */ long a = 9179541993413738569L;
    private final /* synthetic */ Map<Integer, Pair<Byte, Integer>> ALLATORIxDEMO;

    public /* synthetic */ MapleKeyLayout(Map<Integer, Pair<Byte, Integer>> a2) {
        MapleKeyLayout a3;
        MapleKeyLayout mapleKeyLayout = a3;
        mapleKeyLayout.d = false;
        mapleKeyLayout.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ Map<Integer, Pair<Byte, Integer>> Layout() {
        MapleKeyLayout a2;
        a2.d = true;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 2;
        int cfr_ignored_0 = 1 << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ (3 << 2 ^ 1);
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

    public final /* synthetic */ void DeleteKeys(int a2) throws SQLException {
        MapleKeyLayout a3;
        if (!a3.d || a3.ALLATORIxDEMO.isEmpty()) {
            return;
        }
        Object object = null;
        object = DBConPool.getInstance().getDataSource().getConnection();
        object = object.prepareStatement(BBSHandler.ALLATORIxDEMO("gfofwf\u0003eqln\u0003HFZNBS\u0003tkfqf\u0003@KBQB@WFQJG\u0003\u001e\u0003\u001c"));
        object.setInt(1, a2);
        object.execute();
        object.close();
    }

    public final /* synthetic */ void saveKeys(int a2, Connection a3) throws SQLException {
        MapleKeyLayout a4;
        if (!a4.d || a4.ALLATORIxDEMO.isEmpty()) {
            return;
        }
        PreparedStatement preparedStatement = a3.prepareStatement(SharkReader.ALLATORIxDEMO("\u0016\u0006\u001e\u0006\u0006\u0006r\u0005\u0000\f\u001fc9&+.33r\u0014\u001a\u0006\u0000\u0006r :\" \"1771;'r~r|"));
        preparedStatement.setInt(1, a2);
        preparedStatement.execute();
        preparedStatement.close();
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<Integer, Pair<Byte, Integer>>> iterator = a4.ALLATORIxDEMO.entrySet().iterator();
        Iterator<Map.Entry<Integer, Pair<Byte, Integer>>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            StringBuilder stringBuilder2;
            Map.Entry<Integer, Pair<Byte, Integer>> entry = iterator.next();
            if (bl) {
                bl = false;
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2 = stringBuilder3;
                stringBuilder3.append(BBSHandler.ALLATORIxDEMO("jmpfqw\u0003jmwl\u0003HFZNBS\u0003ubovfp\u0003\u000b"));
            } else {
                StringBuilder stringBuilder4 = stringBuilder;
                stringBuilder2 = stringBuilder4;
                stringBuilder4.append(SharkReader.ALLATORIxDEMO("~k"));
            }
            stringBuilder2.append(BBSHandler.ALLATORIxDEMO("gfebvow\u000f"));
            stringBuilder.append(a2).append(SharkReader.ALLATORIxDEMO("o"));
            stringBuilder.append(entry.getKey()).append(BBSHandler.ALLATORIxDEMO("\u000f"));
            stringBuilder.append(entry.getValue().getLeft().byteValue()).append(SharkReader.ALLATORIxDEMO("o"));
            stringBuilder.append(entry.getValue().getRight()).append(BBSHandler.ALLATORIxDEMO("\n"));
            iterator2 = iterator;
        }
        preparedStatement = a3.prepareStatement(stringBuilder.toString());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public /* synthetic */ void clearKeyMap() {
        MapleKeyLayout a2;
        a2.ALLATORIxDEMO.clear();
    }

    public final /* synthetic */ void writeData(MaplePacketLittleEndianWriter a2) {
        int n2;
        MapleKeyLayout a3;
        a2.write(a3.ALLATORIxDEMO.isEmpty() ? 1 : 0);
        if (a3.ALLATORIxDEMO.isEmpty()) {
            return;
        }
        int n3 = n2 = 0;
        while (n3 < 89) {
            Pair<Byte, Integer> pair = a3.ALLATORIxDEMO.get(n2);
            if (pair != null && !SkillConstants.isBanKeyMapSkill(pair.getRight())) {
                a2.write(pair.getLeft());
                a2.writeInt(pair.getRight());
            } else {
                a2.write(0);
                a2.writeInt(0);
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ MapleKeyLayout() {
        MapleKeyLayout a2;
        a2.d = false;
        MapleKeyLayout mapleKeyLayout = a2;
        a2.ALLATORIxDEMO = new HashMap<Integer, Pair<Byte, Integer>>();
    }

    public final /* synthetic */ void resetKeys(int a2) throws SQLException {
        StringBuilder stringBuilder;
        DruidPooledConnection druidPooledConnection = null;
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(SharkReader.ALLATORIxDEMO("\u0016\u0006\u001e\u0006\u0006\u0006r\u0005\u0000\f\u001fc9&+.33r\u0014\u001a\u0006\u0000\u0006r :\" \"1771;'r~r|"));
        preparedStatement.setInt(1, a2);
        preparedStatement.execute();
        preparedStatement.close();
        boolean bl = true;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (bl) {
            bl = false;
            StringBuilder stringBuilder3 = stringBuilder2;
            stringBuilder = stringBuilder3;
            stringBuilder3.append(BBSHandler.ALLATORIxDEMO("jmpfqw\u0003jmwl\u0003HFZNBS\u0003ubovfp\u0003\u000b"));
        } else {
            StringBuilder stringBuilder4 = stringBuilder2;
            stringBuilder = stringBuilder4;
            stringBuilder4.append(SharkReader.ALLATORIxDEMO("~k"));
        }
        stringBuilder.append(BBSHandler.ALLATORIxDEMO("gfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("odw~u~rbv{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("odv~u~rbu{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("o`ofocs{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("oaofocq{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ofofocp{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ogofoc{{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("odofo`w{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("oeofo`r{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ocu~w~{{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("oct~w~v{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("oc{~w~s{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ocz~w~w{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("o`p~w~r{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~qgofocz{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~qdofocw{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~qeofocv{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~qkogogq{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("oar~w~q{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~pfofoct{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~pgofocr{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("oat~w~p{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~pjofo`s{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~wbofocu{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~wcofo`p{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ofp~w~z{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~wfogogs{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~wgogogr{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ofu~w~u{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~wjofo`q{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ogs~w~t{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~vdogogp{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~veogogw{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ogz~u~rbs{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("ods~u~rbr{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("odr~u~rbq{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("odq~u~rbp{o"));
        stringBuilder2.append(BBSHandler.ALLATORIxDEMO("\u000bgfebvow\u000f")).append(a2).append(SharkReader.ALLATORIxDEMO("~uaodocsfj"));
        preparedStatement = druidPooledConnection.prepareStatement(stringBuilder2.toString());
        preparedStatement.execute();
        preparedStatement.close();
    }
}

