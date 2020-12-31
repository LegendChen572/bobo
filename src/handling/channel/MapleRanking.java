/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.channel;

import client.MapleCharacterUtil;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.MapleSquad;
import server.MapleStorageType;
import tools.FileoutputUtil;
import tools.otp.HmacOneTimePasswordGenerator;

public class MapleRanking {
    private final /* synthetic */ List<fishingKingRankingInfo> ALLATORIxDEMO;
    private final /* synthetic */ List<GuildRankingInfo> g;
    private static final /* synthetic */ MapleRanking D;
    private final /* synthetic */ List<GuildRankingInfo> B;
    private final /* synthetic */ Map<Integer, List<SpeedRank>> k;
    private final /* synthetic */ Map<Integer, List<dpmRankingInfo>> C;
    private final /* synthetic */ List<levelRankingInfo> j;
    private final /* synthetic */ Map<String, List<SpeedRank>> K;
    private final /* synthetic */ Map<Integer, List<ItemRankingInfo>> E;
    private final /* synthetic */ List<DonateMesoRankingInfo> H;
    private final /* synthetic */ List<donateRankingInfo> M;
    private final /* synthetic */ List<chinesePVPRankingInfo> d;
    private final /* synthetic */ List<mesoRankingInfo> i;
    private final /* synthetic */ List<StorageRank> a;
    private final /* synthetic */ List<donateRankingInfo> F;
    private final /* synthetic */ List<fameRankingInfo> J;
    private final /* synthetic */ List<donateRankingInfo> I;
    private final /* synthetic */ List<GuildRankingInfo> L;
    private final /* synthetic */ Map<Integer, List<JobRankingInfo>> e;

    public static /* synthetic */ {
        D = new MapleRanking();
    }

    public /* synthetic */ List<SpeedRank> getSpeedRank(String a2) {
        MapleRanking a3;
        if (a3.K.get(a2) == null || a3.K.get(a2).isEmpty()) {
            a3.ALLATORIxDEMO(a2, false);
        }
        return a3.K.get(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void H(int a2) {
        MapleRanking a3;
        if (a3.C.get(a2) != null) {
            a3.C.get(a2).clear();
        }
        Object object = "";
        switch (a2) {
            case 1: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2=%<2,tbq,\u007fcw,)15+$?'+");
                break;
            }
            case 2: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p(g*p:6t3:=u5:k'w=e)e=");
                break;
            }
            case 3: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2?%<2,tbq,\u007fcw,)15+&>'+");
                break;
            }
            case 4: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p.g*p:6t3:=u5:k'w=c(e=");
                break;
            }
            case 5: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,28&<2,tbq,\u007fcw,)15+!?!+");
                break;
            }
            case 6: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p/g*p:6t3:=u5:k'w=b(e=");
                break;
            }
            case 7: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2>%<%+5m{h5fzn50(,2>$='+");
                break;
            }
            case 8: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p(e*g=w{9~wp8xw&j:p(e+o=");
                break;
            }
            case 9: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2?'<%+5m{h5fzn50(,2?'='+");
                break;
            }
            case 10: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p)d*g=w{9~wp8xw&j:p)d+e=");
                break;
            }
            case 11: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2? <%+5m{h5fzn50(,2? ='+");
                break;
            }
        }
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement("SELECT * FROM characters WHERE gm = 0 " + (String)object + " and accountid in (select id from accounts where banned= '0') ORDER BY `dpm` DESC LIMIT 10");
                object = preparedStatement.executeQuery();
                LinkedList<dpmRankingInfo> linkedList = new LinkedList<dpmRankingInfo>();
                Object object2 = object;
                while (object2.next()) {
                    dpmRankingInfo dpmRankingInfo2 = new dpmRankingInfo(object.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("9{:\u007f")), object.getLong(MapleSquad.ALLATORIxDEMO("hea")), object.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("i#h")), object.getInt(MapleSquad.ALLATORIxDEMO("hpt")), object.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("s9n")), object.getInt(MapleSquad.ALLATORIxDEMO("``g")));
                    object2 = object;
                    linkedList.add(dpmRankingInfo2);
                }
                a3.C.put(a2, linkedList);
                preparedStatement.close();
                object.close();
                if (druidPooledConnection == null) return;
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
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
        }
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void i() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public /* synthetic */ List<chinesePVPRankingInfo> getChinesePVPRank() {
        MapleRanking a2;
        if (a2.d.isEmpty()) {
            a2.H();
        }
        return a2.d;
    }

    public /* synthetic */ MapleRanking() {
        MapleRanking a2;
        MapleRanking mapleRanking = a2;
        a2.L = new LinkedList<GuildRankingInfo>();
        mapleRanking.j = new LinkedList<levelRankingInfo>();
        a2.i = new LinkedList<mesoRankingInfo>();
        a2.J = new LinkedList<fameRankingInfo>();
        a2.M = new LinkedList<donateRankingInfo>();
        a2.I = new LinkedList<donateRankingInfo>();
        a2.F = new LinkedList<donateRankingInfo>();
        a2.C = new HashMap<Integer, List<dpmRankingInfo>>();
        a2.H = new LinkedList<DonateMesoRankingInfo>();
        a2.e = new HashMap<Integer, List<JobRankingInfo>>();
        a2.E = new HashMap<Integer, List<ItemRankingInfo>>();
        a2.g = new LinkedList<GuildRankingInfo>();
        a2.B = new LinkedList<GuildRankingInfo>();
        a2.k = new HashMap<Integer, List<SpeedRank>>();
        a2.K = new HashMap<String, List<SpeedRank>>();
        a2.a = new LinkedList<StorageRank>();
        a2.d = new LinkedList<chinesePVPRankingInfo>();
        a2.ALLATORIxDEMO = new LinkedList<fishingKingRankingInfo>();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void b() {
        a2.I.clear();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT `username` ,SUM(amount) FROM `donate` where date LIKE CONCAT('%', '" + FileoutputUtil.NowMonthD() + "', '%') GROUP BY `username` ORDER BY SUM(amount) DESC LIMIT 100");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list = MapleCharacterUtil.getCharacterNameByAccountName(resultSet.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\"i2h9{:\u007f")));
            if (list.isEmpty()) continue;
            list = new donateRankingInfo(list.get(0), resultSet.getInt(MapleSquad.ALLATORIxDEMO("_@A=mxc`ba%")), 0, 0, 0, 0);
            a2.I.add((donateRankingInfo)list);
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v0 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v0 = throwable;
                    }
                    throw v0;
                }
                catch (SQLException sQLException) {
                    System.err.println("\u672a\u80fd\u986f\u793a\u8d0a\u52a9\u6392\u884c " + sQLException);
                }
            }
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, boolean a3) {
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void H() {
        MapleRanking a2;
        a2.d.clear();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleSquad.ALLATORIxDEMO("FIYIVX5&5JGCX,vd|bp\u007fp|c|gm{g5CGHP^5NL,u|ze{xfl5HP_V,YEXEA,$<"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            chinesePVPRankingInfo chinesePVPRankingInfo2 = new chinesePVPRankingInfo(resultSet.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("9{:\u007f")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("ec|ba\u007f")));
            a2.d.add(chinesePVPRankingInfo2);
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
                catch (Exception exception) {
                    System.err.println("\u8f09\u5165\u4e0a\u6d77\u7058PVP\u6392\u884c\u51fa\u73fe\u554f\u984c" + exception);
                }
            }
        }
    }

    public /* synthetic */ List<SpeedRank> getCharacterRank(String a2) {
        MapleRanking a3;
        if (a3.K.get(a2) == null || a3.K.get(a2).isEmpty()) {
            a3.ALLATORIxDEMO(a2, true);
        }
        return a3.K.get(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void d() {
        a2.F.clear();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT `username` ,SUM(amount) FROM `donate` where date LIKE CONCAT('%', '" + FileoutputUtil.NowDay2() + "', '%') GROUP BY `username` ORDER BY SUM(amount) DESC LIMIT 100");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list = MapleCharacterUtil.getCharacterNameByAccountName(resultSet.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\"i2h9{:\u007f")));
            if (list.isEmpty()) continue;
            list = new donateRankingInfo(list.get(0), resultSet.getInt(MapleSquad.ALLATORIxDEMO("_@A=mxc`ba%")), 0, 0, 0, 0);
            a2.F.add((donateRankingInfo)list);
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v0 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v0 = throwable;
                    }
                    throw v0;
                }
                catch (SQLException sQLException) {
                    System.err.println("\u672a\u80fd\u986f\u793a\u8d0a\u52a9\u6392\u884c " + sQLException);
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(int a2) {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT *,SUM(quantity) FROM `inventoryitems`,`characters`WHERE `inventoryitems`.`characterid` = `characters`.`id` AND `inventoryitems`.`itemid` = " + a2 + " GROUP BY `inventoryitems`.`characterid` ORDER BY SUM(quantity) DESC LIMIT 100");
        resultSet = preparedStatement.executeQuery();
        linkedList = new LinkedList<ItemRankingInfo>();
        v0 = resultSet;
        while (v0.next()) {
            itemRankingInfo = new ItemRankingInfo(resultSet.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("9{:\u007f")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("`pzp`")), resultSet.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("p8x")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("_@A=}`m{x|xl%")));
            v0 = resultSet;
            linkedList.add(itemRankingInfo);
        }
        a3.E.put(a2, linkedList);
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v1 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v1 = throwable;
                    }
                    throw v1;
                }
                catch (SQLException sQLException) {
                    System.err.println("\u672a\u80fd\u986f\u793a\u7269\u54c1" + a2 + "\u6392\u884c");
                }
            }
        }
    }

    public /* synthetic */ List<SpeedRank> getSpeedRank(int a2, boolean a3) {
        MapleRanking a4;
        if (a4.k.get(a2) == null || a4.k.get(a2).isEmpty()) {
            a4.ALLATORIxDEMO(a2, a3);
        }
        return a4.k.get(a2);
    }

    public /* synthetic */ List<GuildRankingInfo> getGuildPointRank() {
        MapleRanking a2;
        if (a2.B.isEmpty()) {
            a2.i();
        }
        return a2.B;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO() {
        MapleRanking a2;
        a2.ALLATORIxDEMO.clear();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u0004_\u001b_\u0014Nw0w\\\u0005U\u001a:1s$r>t0E<s9}wU\u0005^\u0012HwX\u000e:7r>i#u%c$y8h2zw^\u0012I\u0014:\u001bS\u001aS\u0003:f*"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            fishingKingRankingInfo fishingKingRankingInfo2 = new fishingKingRankingInfo(resultSet.getString(MapleSquad.ALLATORIxDEMO("{mxi")), resultSet.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("?s$n8h.i4u%\u007f")));
            a2.ALLATORIxDEMO.add(fishingKingRankingInfo2);
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
                catch (Exception exception) {
                    System.err.println(MapleSquad.ALLATORIxDEMO("\u8f1c\u5169\u4e18\u5910\u57db\u91ef\u9b4f\u7387\u6387\u8840\u51ef\u73f2\u555a\u9840"));
                }
            }
        }
    }

    public /* synthetic */ List<ItemRankingInfo> getItemRank(int a2) {
        MapleRanking a3;
        if (a3.E.get(a2) == null || a3.E.get(a2).isEmpty()) {
            a3.ALLATORIxDEMO(a2);
        }
        return a3.E.get(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void c() {
        a2.M.clear();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapleSquad.ALLATORIxDEMO("FIYIVX5l`\u007fp~{mxiu,9_@A=mxc`ba%5JGCX,uhzbtxpl5KGC@\\5NL,uyfigbtapl5CGHP^5NL,FYX$tazy{x<,QIFO5@\\A\\X5=%<"));
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list = MapleCharacterUtil.getCharacterNameByAccountName(resultSet.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\"i2h9{:\u007f")));
            if (list.isEmpty()) continue;
            list = new donateRankingInfo(list.get(0), resultSet.getInt(MapleSquad.ALLATORIxDEMO("_@A=mxc`ba%")), 0, 0, 0, 0);
            a2.M.add((donateRankingInfo)list);
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v0 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v0 = throwable;
                    }
                    throw v0;
                }
                catch (SQLException sQLException) {
                    System.err.println("\u672a\u80fd\u986f\u793a\u8d0a\u52a9\u6392\u884c " + sQLException);
                }
            }
        }
    }

    public /* synthetic */ List<GuildRankingInfo> getGuildRank() {
        MapleRanking a2;
        if (a2.L.isEmpty()) {
            a2.B();
        }
        return a2.L;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void K() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void ALLATORIxDEMO(String a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public /* synthetic */ List<donateRankingInfo> getDonateRank() {
        MapleRanking a2;
        if (a2.M.isEmpty()) {
            a2.c();
        }
        return a2.M;
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2) {
        MapleRanking a3;
        a3.ALLATORIxDEMO(a2, true);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void g() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void D() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public /* synthetic */ List<dpmRankingInfo> getDpmRank(int a2) {
        MapleRanking a3;
        if (a3.C.get(a2) == null || a3.C.get(a2).isEmpty()) {
            a3.H(a2);
        }
        return a3.C.get(a2);
    }

    public /* synthetic */ List<StorageRank> getStorageRank() {
        MapleRanking a2;
        if (a2.a.isEmpty()) {
            a2.l();
        }
        return a2.a;
    }

    public /* synthetic */ List<mesoRankingInfo> getMesoRank() {
        MapleRanking a2;
        if (a2.i.isEmpty()) {
            a2.D();
        }
        return a2.i;
    }

    public /* synthetic */ List<donateRankingInfo> getDonateDayRank() {
        MapleRanking a2;
        if (a2.F.isEmpty()) {
            a2.d();
        }
        return a2.F;
    }

    public /* synthetic */ List<JobRankingInfo> getJobRank(int a2) {
        MapleRanking a3;
        if (a3.e.get(a2) == null || a3.e.get(a2).isEmpty()) {
            a3.l(a2);
        }
        return a3.e.get(a2);
    }

    public /* synthetic */ List<levelRankingInfo> getLevelRank() {
        MapleRanking a2;
        if (a2.j.isEmpty()) {
            a2.E();
        }
        return a2.j;
    }

    public /* synthetic */ List<fishingKingRankingInfo> getFishingKingRank() {
        MapleRanking a2;
        if (a2.ALLATORIxDEMO.isEmpty()) {
            a2.ALLATORIxDEMO();
        }
        return a2.ALLATORIxDEMO;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void l() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static /* synthetic */ MapleRanking getInstance() {
        return D;
    }

    public /* synthetic */ List<DonateMesoRankingInfo> getDonateMesoRank() {
        MapleRanking a2;
        MapleRanking mapleRanking = a2;
        mapleRanking.I();
        return mapleRanking.H;
    }

    public /* synthetic */ List<donateRankingInfo> getDonateMonthRank() {
        MapleRanking a2;
        if (a2.I.isEmpty()) {
            a2.b();
        }
        return a2.I;
    }

    private /* synthetic */ void I() {
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void B() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public /* synthetic */ List<fameRankingInfo> getFameRank() {
        MapleRanking a2;
        if (a2.J.isEmpty()) {
            a2.g();
        }
        return a2.J;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void E() {
        a2.j.clear();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(HmacOneTimePasswordGenerator.ALLATORIxDEMO("I\u0012V\u0012Y\u0003:}:\u0011H\u0018Wwy?{%{4n2h$:\u0000R\u0012H\u0012:0ww'w*w{9~w{4y8o9n>~ws9:\u007fi2v2y#:>~w|%u::6y4u\"t#iwm?\u007f%\u007fwx6t9\u007f3:j:g3wU\u0005^\u0012HwX\u000e:7v2l2v7:\u0013_\u0004YwV\u001eW\u001eNw+g*"));
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            levelRankingInfo2 = new levelRankingInfo(resultSet.getString(MapleSquad.ALLATORIxDEMO("{mxi")), resultSet.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("v2l2v")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("\u007fa~")), resultSet.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("~2b")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("e{x")), resultSet.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("v\"q")));
            v0 = resultSet;
            a2.j.add(levelRankingInfo2);
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v1 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v1 = throwable;
                    }
                    throw v1;
                }
                catch (SQLException sQLException) {
                    System.err.println(MapleSquad.ALLATORIxDEMO("\u673f\u80f1\u987a\u7936\u7b5c\u7d16\u6387\u8840"));
                }
            }
        }
    }

    public /* synthetic */ void reloadAllRank() {
        MapleRanking a2;
        a2.getGuildRank();
        a2.getJobRank(1);
        a2.getJobRank(2);
        a2.getJobRank(3);
        a2.getJobRank(4);
        a2.getJobRank(5);
        a2.getJobRank(6);
        a2.getJobRank(7);
        a2.getJobRank(8);
        a2.getFishingKingRank();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void l(int a2) {
        MapleRanking a3;
        if (a3.e.get(a2) != null) {
            a3.e.get(a2).clear();
        }
        Object object = "";
        switch (a2) {
            case 1: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p+g*p:6t3:=u5:k'w=f)e=");
                break;
            }
            case 2: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2>%<2,tbq,\u007fcw,)15+'?'+");
                break;
            }
            case 3: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p)g*p:6t3:=u5:k'w=d(e=");
                break;
            }
            case 4: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,28%<2,tbq,\u007fcw,)15+!>'+");
                break;
            }
            case 5: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p.d*p:6t3:=u5:k'w=c)c=");
                break;
            }
            case 6: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,29%<2,tbq,\u007fcw,)15+ >'+");
                break;
            }
            case 7: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p(g*g=w{9~wp8xw&j:p(f+e=");
                break;
            }
            case 8: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2>'<%+5m{h5fzn50(,2>'=-+");
                break;
            }
            case 9: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p)e*g=w{9~wp8xw&j:p)e+e=");
                break;
            }
            case 10: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2?&<%+5m{h5fzn50(,2?&='+");
                break;
            }
            case 11: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p)b*g=w{9~wp8xw&j:p)b+e=");
                break;
            }
            case 12: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2='<%+5m{h5fzn50(,2='='+");
                break;
            }
            case 13: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p+d*g=w{9~wp8xw&j:p+d+e=");
                break;
            }
            case 14: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2=!<%+5m{h5fzn50(,2=!='+");
                break;
            }
            case 15: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p+b*g=w{9~wp8xw&j:p+b+e=");
                break;
            }
            case 16: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2>!<%+5m{h5fzn50(,2>!='+");
                break;
            }
            case 17: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p/d*p:6t3:=u5:k'w=b)e=");
                break;
            }
            case 18: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,29\"<2,tbq,\u007fcw,)15+ ;'+");
                break;
            }
            case 19: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p(d*g=w{9~wp8xw&j:p(d+e=");
                break;
            }
            case 20: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,29$<%+5m{h5fzn50(,29$='+");
                break;
            }
            case 21: {
                object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("{9~wp8xw$j:p)f*g=w{9~wp8xw&j:p)f+e=");
                break;
            }
            case 22: {
                object = MapleSquad.ALLATORIxDEMO("m{h5fzn52(,2=$<%+5m{h5fzn50(,2=$='+");
                break;
            }
        }
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement("SELECT * FROM characters WHERE gm = 0 " + (String)object + " and accountid in (select id from accounts where banned= '0') ORDER BY `level` DESC LIMIT 10");
                object = preparedStatement.executeQuery();
                LinkedList<JobRankingInfo> linkedList = new LinkedList<JobRankingInfo>();
                Object object2 = object;
                while (object2.next()) {
                    JobRankingInfo jobRankingInfo = new JobRankingInfo(object.getString(HmacOneTimePasswordGenerator.ALLATORIxDEMO("9{:\u007f")), object.getInt(MapleSquad.ALLATORIxDEMO("`pzp`")), object.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("p8x")), object.getInt(MapleSquad.ALLATORIxDEMO("\u007fa~")), object.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("~2b")), object.getInt(MapleSquad.ALLATORIxDEMO("e{x")), object.getInt(HmacOneTimePasswordGenerator.ALLATORIxDEMO("v\"q")));
                    object2 = object;
                    linkedList.add(jobRankingInfo);
                }
                a3.e.put(a2, linkedList);
                preparedStatement.close();
                object.close();
                if (druidPooledConnection == null) return;
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
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            System.err.println("\u672a\u80fd\u986f\u793a\u8077\u696d" + a2 + "\u6392\u884c");
        }
    }

    public /* synthetic */ void ClearAllRank() {
        MapleRanking a2;
        MapleRanking mapleRanking = a2;
        mapleRanking.ALLATORIxDEMO.clear();
        mapleRanking.e.clear();
        mapleRanking.E.clear();
        mapleRanking.k.clear();
        mapleRanking.K.clear();
        mapleRanking.a.clear();
        mapleRanking.g.clear();
        mapleRanking.B.clear();
        mapleRanking.L.clear();
        mapleRanking.J.clear();
        mapleRanking.H.clear();
        mapleRanking.C.clear();
        mapleRanking.d.clear();
        mapleRanking.M.clear();
        mapleRanking.I.clear();
        mapleRanking.F.clear();
        mapleRanking.j.clear();
        mapleRanking.i.clear();
    }

    public /* synthetic */ List<GuildRankingInfo> getGuildMesoRank() {
        MapleRanking a2;
        if (a2.g.isEmpty()) {
            a2.K();
        }
        return a2.g;
    }

    public static class GuildRankingInfo {
        private final /* synthetic */ int a;
        private final /* synthetic */ int K;
        private final /* synthetic */ int k;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ String B;
        private final /* synthetic */ int d;

        public /* synthetic */ GuildRankingInfo(String a2, int a3, int a4, int a5, int a6, int a7) {
            GuildRankingInfo a8;
            GuildRankingInfo guildRankingInfo = a8;
            GuildRankingInfo guildRankingInfo2 = a8;
            GuildRankingInfo guildRankingInfo3 = a8;
            guildRankingInfo3.B = a2;
            guildRankingInfo3.k = a3;
            guildRankingInfo2.K = a4;
            guildRankingInfo2.a = a5;
            guildRankingInfo.d = a6;
            guildRankingInfo.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ int getLogoColor() {
            GuildRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getGP() {
            GuildRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getLogo() {
            GuildRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getLogoBgColor() {
            GuildRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getLogoBg() {
            GuildRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ String getName() {
            GuildRankingInfo a2;
            return a2.B;
        }
    }

    public static class fameRankingInfo {
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int a;
        private final /* synthetic */ int K;
        private final /* synthetic */ int d;
        private final /* synthetic */ int k;
        private final /* synthetic */ String B;

        public /* synthetic */ int getDex() {
            fameRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getInt() {
            fameRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ String getName() {
            fameRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ fameRankingInfo(String a2, int a3, int a4, int a5, int a6, int a7) {
            fameRankingInfo a8;
            fameRankingInfo fameRankingInfo2 = a8;
            fameRankingInfo fameRankingInfo3 = a8;
            fameRankingInfo fameRankingInfo4 = a8;
            fameRankingInfo4.B = a2;
            fameRankingInfo4.k = a3;
            fameRankingInfo3.K = a4;
            fameRankingInfo3.a = a5;
            fameRankingInfo2.d = a6;
            fameRankingInfo2.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ int getFame() {
            fameRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getStr() {
            fameRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getLuk() {
            fameRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }
    }

    public static class donateRankingInfo {
        private final /* synthetic */ int k;
        private final /* synthetic */ int a;
        private final /* synthetic */ int K;
        private final /* synthetic */ String B;
        private final /* synthetic */ int d;
        private final /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ String getName() {
            donateRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ int getLuk() {
            donateRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getdonate() {
            donateRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getStr() {
            donateRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ donateRankingInfo(String a2, int a3, int a4, int a5, int a6, int a7) {
            donateRankingInfo a8;
            donateRankingInfo donateRankingInfo2 = a8;
            donateRankingInfo donateRankingInfo3 = a8;
            donateRankingInfo donateRankingInfo4 = a8;
            donateRankingInfo4.B = a2;
            donateRankingInfo4.k = a3;
            donateRankingInfo3.K = a4;
            donateRankingInfo3.a = a5;
            donateRankingInfo2.d = a6;
            donateRankingInfo2.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ int getDex() {
            donateRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getInt() {
            donateRankingInfo a2;
            return a2.d;
        }
    }

    public static class levelRankingInfo {
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int a;
        private final /* synthetic */ int K;
        private final /* synthetic */ int k;
        private final /* synthetic */ int d;
        private final /* synthetic */ String B;

        public /* synthetic */ levelRankingInfo(String a2, int a3, int a4, int a5, int a6, int a7) {
            levelRankingInfo a8;
            levelRankingInfo levelRankingInfo2 = a8;
            levelRankingInfo levelRankingInfo3 = a8;
            levelRankingInfo levelRankingInfo4 = a8;
            levelRankingInfo4.B = a2;
            levelRankingInfo4.k = a3;
            levelRankingInfo3.K = a4;
            levelRankingInfo3.a = a5;
            levelRankingInfo2.d = a6;
            levelRankingInfo2.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ int getLevel() {
            levelRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getInt() {
            levelRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ String getName() {
            levelRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ int getStr() {
            levelRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getLuk() {
            levelRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getDex() {
            levelRankingInfo a2;
            return a2.a;
        }
    }

    public static class mesoRankingInfo {
        private final /* synthetic */ int K;
        private final /* synthetic */ long k;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ String B;
        private final /* synthetic */ int d;
        private final /* synthetic */ int a;

        public /* synthetic */ mesoRankingInfo(String a2, long a3, int a4, int a5, int a6, int a7) {
            mesoRankingInfo a8;
            mesoRankingInfo mesoRankingInfo2 = a8;
            mesoRankingInfo mesoRankingInfo3 = a8;
            mesoRankingInfo mesoRankingInfo4 = a8;
            mesoRankingInfo4.B = a2;
            mesoRankingInfo4.k = a3;
            mesoRankingInfo3.K = a4;
            mesoRankingInfo3.a = a5;
            mesoRankingInfo2.d = a6;
            mesoRankingInfo2.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ long getMeso() {
            mesoRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ String getName() {
            mesoRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ int getDex() {
            mesoRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getStr() {
            mesoRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getInt() {
            mesoRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ int getLuk() {
            mesoRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }
    }

    public static class JobRankingInfo {
        private final /* synthetic */ int B;
        private final /* synthetic */ int k;
        private final /* synthetic */ int a;
        private final /* synthetic */ String g;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int d;
        private final /* synthetic */ int K;

        public /* synthetic */ int getDex() {
            JobRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ String getName() {
            JobRankingInfo a2;
            return a2.g;
        }

        public /* synthetic */ int getInt() {
            JobRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getLevel() {
            JobRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ int getLuk() {
            JobRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ int getStr() {
            JobRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getJob() {
            JobRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ JobRankingInfo(String a2, int a3, int a4, int a5, int a6, int a7, int a8) {
            JobRankingInfo a9;
            JobRankingInfo jobRankingInfo = a9;
            JobRankingInfo jobRankingInfo2 = a9;
            JobRankingInfo jobRankingInfo3 = a9;
            a9.g = a2;
            jobRankingInfo3.B = a3;
            jobRankingInfo3.ALLATORIxDEMO = a4;
            jobRankingInfo2.k = a5;
            jobRankingInfo2.K = a6;
            jobRankingInfo.a = a7;
            jobRankingInfo.d = a8;
        }
    }

    public static class dpmRankingInfo {
        private final /* synthetic */ long ALLATORIxDEMO;
        private final /* synthetic */ int a;
        private final /* synthetic */ int k;
        private final /* synthetic */ int K;
        private final /* synthetic */ String B;
        private final /* synthetic */ int d;

        public /* synthetic */ int getLuk() {
            dpmRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ int getInt() {
            dpmRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getDex() {
            dpmRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getStr() {
            dpmRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ String getName() {
            dpmRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ long getdps() {
            dpmRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ dpmRankingInfo(String a2, long a3, int a4, int a5, int a6, int a7) {
            dpmRankingInfo a8;
            dpmRankingInfo dpmRankingInfo2 = a8;
            dpmRankingInfo dpmRankingInfo3 = a8;
            dpmRankingInfo dpmRankingInfo4 = a8;
            dpmRankingInfo4.B = a2;
            dpmRankingInfo4.ALLATORIxDEMO = a3;
            dpmRankingInfo3.k = a4;
            dpmRankingInfo3.K = a5;
            dpmRankingInfo2.a = a6;
            dpmRankingInfo2.d = a7;
        }
    }

    public static class ItemRankingInfo {
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int d;
        private final /* synthetic */ int a;
        private final /* synthetic */ String K;

        public /* synthetic */ String getName() {
            ItemRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getLevel() {
            ItemRankingInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getJob() {
            ItemRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ ItemRankingInfo(String a2, int a3, int a4, int a5) {
            ItemRankingInfo a6;
            ItemRankingInfo itemRankingInfo = a6;
            ItemRankingInfo itemRankingInfo2 = a6;
            itemRankingInfo2.K = a2;
            itemRankingInfo2.a = a3;
            itemRankingInfo.ALLATORIxDEMO = a4;
            itemRankingInfo.d = a5;
        }

        public /* synthetic */ int getQuantity() {
            ItemRankingInfo a2;
            return a2.d;
        }
    }

    public static class SpeedRank {
        private /* synthetic */ String a;
        private /* synthetic */ String d;
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ String getName() {
            SpeedRank a2;
            return a2.a;
        }

        public /* synthetic */ SpeedRank(String a2, String a3, int a4) {
            SpeedRank a5;
            SpeedRank speedRank = a5;
            a5.a = a2;
            speedRank.d = a3;
            speedRank.ALLATORIxDEMO = a4;
        }

        public /* synthetic */ int getTime() {
            SpeedRank a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ String getMapName() {
            SpeedRank a2;
            return a2.d;
        }
    }

    public static class StorageRank {
        private /* synthetic */ int d;
        private /* synthetic */ String a;
        private /* synthetic */ MapleStorageType ALLATORIxDEMO;

        public /* synthetic */ String getName() {
            StorageRank a2;
            return a2.a;
        }

        public /* synthetic */ int getCount() {
            StorageRank a2;
            return a2.d;
        }

        public /* synthetic */ StorageRank(String a2, int a3, MapleStorageType a4) {
            StorageRank a5;
            StorageRank storageRank = a5;
            a5.a = a2;
            storageRank.d = a3;
            storageRank.ALLATORIxDEMO = a4;
        }

        public /* synthetic */ MapleStorageType getType() {
            StorageRank a2;
            return a2.ALLATORIxDEMO;
        }
    }

    public static class chinesePVPRankingInfo {
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ String d;

        public /* synthetic */ chinesePVPRankingInfo(String a2, int a3) {
            chinesePVPRankingInfo a4;
            chinesePVPRankingInfo chinesePVPRankingInfo2 = a4;
            chinesePVPRankingInfo2.d = a2;
            chinesePVPRankingInfo2.ALLATORIxDEMO = a3;
        }

        public /* synthetic */ int getPoints() {
            chinesePVPRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ String getName() {
            chinesePVPRankingInfo a2;
            return a2.d;
        }
    }

    public static class fishingKingRankingInfo {
        private final /* synthetic */ String d;
        private final /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ int getPoints() {
            fishingKingRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ fishingKingRankingInfo(String a2, int a3) {
            fishingKingRankingInfo a4;
            fishingKingRankingInfo fishingKingRankingInfo2 = a4;
            fishingKingRankingInfo2.d = a2;
            fishingKingRankingInfo2.ALLATORIxDEMO = a3;
        }

        public /* synthetic */ String getName() {
            fishingKingRankingInfo a2;
            return a2.d;
        }
    }

    public static class dojoRankingInfo {
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ String d;

        public /* synthetic */ int getTime() {
            dojoRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ String getName() {
            dojoRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ dojoRankingInfo(String a2, int a3) {
            dojoRankingInfo a4;
            dojoRankingInfo dojoRankingInfo2 = a4;
            dojoRankingInfo2.d = a2;
            dojoRankingInfo2.ALLATORIxDEMO = a3;
        }
    }

    public static class DonateMesoRankingInfo {
        private final /* synthetic */ int k;
        private final /* synthetic */ String B;
        private final /* synthetic */ int a;
        private final /* synthetic */ int d;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int K;

        public /* synthetic */ DonateMesoRankingInfo(String a2, int a3, int a4, int a5, int a6, int a7) {
            DonateMesoRankingInfo a8;
            DonateMesoRankingInfo donateMesoRankingInfo = a8;
            DonateMesoRankingInfo donateMesoRankingInfo2 = a8;
            DonateMesoRankingInfo donateMesoRankingInfo3 = a8;
            donateMesoRankingInfo3.B = a2;
            donateMesoRankingInfo3.k = a3;
            donateMesoRankingInfo2.K = a4;
            donateMesoRankingInfo2.a = a5;
            donateMesoRankingInfo.d = a6;
            donateMesoRankingInfo.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ int getInt() {
            DonateMesoRankingInfo a2;
            return a2.d;
        }

        public /* synthetic */ int getLuk() {
            DonateMesoRankingInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getStr() {
            DonateMesoRankingInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getMeso() {
            DonateMesoRankingInfo a2;
            return a2.k;
        }

        public /* synthetic */ String getName() {
            DonateMesoRankingInfo a2;
            return a2.B;
        }

        public /* synthetic */ int getDex() {
            DonateMesoRankingInfo a2;
            return a2.a;
        }
    }
}

