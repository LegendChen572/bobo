/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.world.sidekick;

import client.MapleCharacter;
import client.MapleDiseaseValueHolder;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import database.DatabaseConnection;
import handling.opcodes.MapleBuffStat;
import handling.world.World;
import handling.world.sidekick.MapleSidekickCharacter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.life.MobSkill;
import tools.MaplePacketCreator;
import tools.Pair;

public class MapleSidekick
implements Serializable {
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ MapleSidekickCharacter[] d;
    private static final /* synthetic */ long a = 954199343336738569L;

    public /* synthetic */ List<String> getSidekickMsg(boolean a2) {
        MapleSidekick a3;
        ArrayList<String> arrayList = new ArrayList<String>();
        if (!a2) {
            arrayList.add(MobSkill.ALLATORIxDEMO("sE_\nGKS\nEDFS\nMO^\nHODOLC^Y\nLXEG\n^BO\nYCNOACIA\nCL\n^BOS\nKXO\nCD\n^BO\nYKGO\nGKZ\u0004"));
        }
        if (a3.getCharacter(0).getLevel() > 140 || a3.getCharacter(1).getLevel() > 140) {
            arrayList.add(MapleDiseaseValueHolder.ALLATORIxDEMO("w\u001fFWP\u001eG\u0012H\u001e@\u001c\u0003\u0005F\u001bB\u0003J\u0018M\u0004K\u001eSWT\u001eO\u001b\u0003\u0012M\u0013\u0003\u001eEWL\u0019FWS\u001bB\u000eF\u0005\u0003\u0010F\u0003PWB\u0015L\u0001FWO\u0012U\u0012OW\u0012B\u0013Y"));
        }
        if (Math.abs(a3.getCharacter(0).getLevel() - a3.getCharacter(1).getLevel()) < 5 || Math.abs(a3.getCharacter(0).getLevel() - a3.getCharacter(1).getLevel()) > 30) {
            arrayList.add(MobSkill.ALLATORIxDEMO("~BO\nYCNOACIA\nXOFK^CEDYBCZ\n]CFF\nODN\nCL\n^BO\nFO\\OF\nNCLLOXODIO\nCY\nFOYY\n^BKD\n\u001f\nEX\nMXOK^OX\n^BKD\n\u0019\u001a\u0004"));
        }
        return arrayList;
    }

    public /* synthetic */ boolean equals(Object a2) {
        MapleSidekick a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (MapleSidekick)a2;
        return a3.ALLATORIxDEMO == ((MapleSidekick)a2).ALLATORIxDEMO;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ List<MapleSidekick> loadAll() {
        arrayList = new ArrayList<MapleSidekick>();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapleDiseaseValueHolder.ALLATORIxDEMO("p2o2`#\u0003\u001eGWe%l:\u0003\u0004J\u0013F\u001cJ\u0014H\u0004"));
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            v0 = resultSet;
            arrayList.add(new MapleSidekick(resultSet.getInt(MobSkill.ALLATORIxDEMO("CN"))));
        }
        resultSet.close();
        preparedStatement.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
        }
lbl-1000:
        // 2 sources

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
                    System.err.println(MapleDiseaseValueHolder.ALLATORIxDEMO("V\u0019B\u0015O\u0012\u0003\u0003LWQ\u0012B\u0013\u0003\u0004J\u0013F\u001cJ\u0014HWJ\u0019E\u0018Q\u001aB\u0003J\u0018MWE\u0005L\u001a\u0003\u0004R\u001b"));
                    sQLException.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public /* synthetic */ void eraseToDB() {
        try {
            MapleSidekick a2;
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MobSkill.ALLATORIxDEMO("nofo~o\nlxeg\nYCNOACIAY\n}boxo\nCN\n\u0017\n\u0015"));
            preparedStatement.setInt(1, a2.ALLATORIxDEMO);
            MapleSidekick mapleSidekick = a2;
            preparedStatement.executeUpdate();
            preparedStatement.close();
            mapleSidekick.broadcast(MaplePacketCreator.disbandSidekick(mapleSidekick));
            World.Sidekick.eraseSidekick(mapleSidekick.ALLATORIxDEMO);
            return;
        }
        catch (SQLException sQLException) {
            System.err.println(MapleDiseaseValueHolder.ALLATORIxDEMO("2Q\u0005L\u0005\u0003\u0013F\u001bF\u0003J\u0019DWP\u001eG\u0012H\u001e@\u001c"));
            sQLException.printStackTrace();
            return;
        }
    }

    public static /* synthetic */ boolean checkLevels(int a2, int a3) {
        return Math.abs(a2 - a3) >= 5 && Math.abs(a2 - a3) <= 30 && a2 <= 150 && a3 <= 150 && a2 >= 10 && a3 >= 10;
    }

    public /* synthetic */ int getId() {
        MapleSidekick a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void applyBuff(MapleCharacter a2) {
        MapleSidekick a3;
        LinkedList<Pair<MapleBuffStat, Integer>> linkedList = new LinkedList<Pair<MapleBuffStat, Integer>>();
        int n2 = Math.abs(a3.getCharacter(0).getLevel() - a3.getCharacter(1).getLevel());
        linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STR, n2 * 5));
        linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DEX, n2 * 5));
        linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INT, n2 * 5));
        linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.LUK, n2 * 5));
        linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SIDEKICK_PASSIVE, 1));
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveBuff(79797980, 2100000000, linkedList, null, a2));
        MapleStatEffect mapleStatEffect = MapleItemInformationProvider.getInstance().getItemEffect(2022891);
        mapleCharacter.cancelEffectFromBuffStat(MapleBuffStat.SIDEKICK_PASSIVE);
        mapleCharacter.registerEffect(mapleStatEffect, System.currentTimeMillis(), linkedList, 2100000000, a2.getId());
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ MapleSidekick(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[WHILELOOP]], but top level block is 4[TRYBLOCK]
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

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 3;
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int n5 = n3;
        int n6 = (2 ^ 5) << 4;
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
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ int create(int a2, int a3) {
        block13: {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            DruidPooledConnection druidPooledConnection;
            block11: {
                int n2;
                block12: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(MobSkill.ALLATORIxDEMO("yofoi~\nCN\nlxeg\nYCNOACIAY\n}boxo\nLCXY^CN\n\u0017\n\u0015\nex\nYOIEDNCN\n\u0017\n\u0015\nex\nLCXY^CN\n\u0017\n\u0015\nex\nYOIEDNCN\n\u0017\n\u0015"));
                    PreparedStatement preparedStatement3 = preparedStatement;
                    preparedStatement3.setInt(1, a2);
                    preparedStatement3.setInt(2, a3);
                    preparedStatement2.setInt(3, a2);
                    preparedStatement2.setInt(4, a3);
                    resultSet = preparedStatement2.executeQuery();
                    if (!resultSet.first()) break block11;
                    resultSet.close();
                    preparedStatement.close();
                    n2 = 0;
                    if (druidPooledConnection == null) break block12;
                    druidPooledConnection.close();
                }
                return n2;
            }
            preparedStatement.close();
            resultSet.close();
            PreparedStatement preparedStatement4 = preparedStatement = druidPooledConnection.prepareStatement(MapleDiseaseValueHolder.ALLATORIxDEMO(">m$f%wWj9w8\u0003\u0004J\u0013F\u001cJ\u0014H\u0004\u0003_E\u001eQ\u0004W\u001eG[\u0003\u0004F\u0014L\u0019G\u001eG^\u0003!b;v2pW\u000bH\u000fW\u001c^"), 1);
            preparedStatement4.setInt(1, a2);
            preparedStatement4.setInt(2, a3);
            preparedStatement4.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            int n3 = 0;
            if (resultSet.next()) {
                n3 = resultSet.getInt(1);
            }
            resultSet.close();
            preparedStatement.close();
            a3 = n3;
            if (druidPooledConnection == null) break block13;
            {
                catch (Throwable throwable) {
                    try {
                        Throwable throwable2;
                        block14: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    throwable2 = throwable;
                                    break block14;
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
                        System.err.println(MobSkill.ALLATORIxDEMO("y{f\n~bxe}"));
                        sQLException.printStackTrace();
                        return 0;
                    }
                }
            }
            druidPooledConnection.close();
        }
        return a3;
    }

    public /* synthetic */ void broadcast(byte[] a2) {
        MapleSidekick a3;
        MapleSidekick mapleSidekick = a3;
        World.Broadcast.sendPacket(mapleSidekick.d[0].getId(), a2);
        World.Broadcast.sendPacket(mapleSidekick.d[1].getId(), a2);
    }

    public /* synthetic */ int hashCode() {
        MapleSidekick a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + a2.ALLATORIxDEMO;
        return n2;
    }

    public /* synthetic */ MapleSidekickCharacter getCharacter(int a2) {
        MapleSidekick a3;
        return a3.d[a2];
    }
}

