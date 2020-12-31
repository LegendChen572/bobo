/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.gashapon;

import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.world.World;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import server.Randomizer;
import server.Timer;
import server.gashapon.GashaponRewardSpecial;
import tools.FilePrinter;
import tools.JsonMapConverter;
import tools.MaplePacketCreator;

public class GashaponSpecial {
    private static /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ List<GashaponRewardSpecial> a;
    private static /* synthetic */ GashaponSpecial d;

    public static /* synthetic */ {
        d = null;
        ALLATORIxDEMO = false;
    }

    public /* synthetic */ GashaponSpecial() {
        GashaponSpecial a2;
        GashaponSpecial gashaponSpecial = a2;
        gashaponSpecial.a = new LinkedList<GashaponRewardSpecial>();
    }

    public static /* synthetic */ GashaponSpecial getInstance() {
        if (d == null) {
            System.out.println(Timer.ALLATORIxDEMO("\u3004\u8be0\u53c2\u4e4d\u3005@S\u0001g\bu\u0010{\u000eG\u0010q\u0003}\u0001x@.Z."));
            d = new GashaponSpecial();
        }
        return d;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ GashaponRewardSpecial generateReward() {
        GashaponSpecial a2;
        if (!ALLATORIxDEMO && a2.a.size() <= 0) {
            ALLATORIxDEMO = true;
            a2.reloadItems();
        }
        if (a2.a.size() <= 0) {
            return null;
        }
        int n2 = Randomizer.rand(0, a2.a.size() - 1);
        GashaponRewardSpecial gashaponRewardSpecial = a2.a.get(n2);
        GashaponSpecial gashaponSpecial = a2;
        gashaponSpecial.a.remove(n2);
        switch (gashaponSpecial.a.size()) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u4e00\u756a\u8cde\u8f49\u86cb\u6a5f] \u4e00\u756a\u8cde\u8f49\u86cb\u6a5f\u5167\u7684\u734e\u54c1\u5df2\u5269\u9918\u6700\u5f8c" + a2.a.size() + "\u7d44,\u8acb\u73a9\u5bb6\u5011\u8981\u6436\u8981\u5feb!"));
                return gashaponRewardSpecial;
            }
            case 0: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(JsonMapConverter.ALLATORIxDEMO("_\u4e75\u756e\u8cab\u8f4d\u86be\u6a5b($\u4e75\u756e\u8cab\u8f4d\u86be\u6a5b\u5112\u7680\u733b\u54c5\u5d87\u516c\u650d\u8ce7\u7a0f%\u8abe\u6c96\u6443\u5234\u76f1\u5400\u4f38\u4e0f\u6b54\u8acf\u659cz\u000b")));
                return gashaponRewardSpecial;
            }
        }
        if (a2.a.size() % 20 == 0) {
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u4e00\u756a\u8cde\u8f49\u86cb\u6a5f] \u4e00\u756a\u8cde\u8f49\u86cb\u6a5f\u5167\u7684\u734e\u54c1\u71b1\u8ce3\u4e2d,\u9084\u6709" + a2.a.size() + "\u7d44,\u8acb\u73a9\u5bb6\u5011\u628a\u63e1\u6a5f\u6703!"));
        }
        return gashaponRewardSpecial;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void reloadItems() {
        DruidPooledConnection druidPooledConnection;
        DruidPooledConnection druidPooledConnection2;
        block18: {
            block17: {
                ResultSet resultSet;
                PreparedStatement preparedStatement;
                GashaponSpecial a2;
                a2.a.clear();
                try {
                    druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        preparedStatement = druidPooledConnection2.prepareStatement(JsonMapConverter.ALLATORIxDEMO("W0H0G!$_$3V:IUc\u0014w\u001de\u0005k\u001b[\u001cp\u0010i\u0006[\u0006t\u0010g\u001ce\u0019$:V1A'$7]Um\u0001a\u0018m\u0011$4W6"));
                        try {
                            resultSet = preparedStatement.executeQuery();
                            while (resultSet.next()) {
                                int n2;
                                GashaponRewardSpecial gashaponRewardSpecial = new GashaponRewardSpecial(resultSet.getInt(Timer.ALLATORIxDEMO("\t`\u0005y\tp")), resultSet.getBoolean(JsonMapConverter.ALLATORIxDEMO("\u0006l\u001as\u0018w\u0012")));
                                int n3 = resultSet.getInt(Timer.ALLATORIxDEMO("w\u000fa\u000e`"));
                                int n4 = n2 = 0;
                                while (n4 < n3) {
                                    a2.a.add(gashaponRewardSpecial);
                                    n4 = ++n2;
                                }
                            }
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            if (preparedStatement != null) {
                                try {
                                    preparedStatement.close();
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
                    catch (Throwable throwable) {
                        Throwable throwable4;
                        if (druidPooledConnection2 != null) {
                            try {
                                druidPooledConnection2.close();
                                throwable4 = throwable;
                                throw throwable4;
                            }
                            catch (Throwable throwable5) {
                                throwable.addSuppressed(throwable5);
                            }
                        }
                        throwable4 = throwable;
                        throw throwable4;
                    }
                }
                catch (SQLException sQLException) {
                    FilePrinter.printError(JsonMapConverter.ALLATORIxDEMO("C\u0014w\u001de\u0005k\u001b*\u0001|\u0001"), sQLException, Timer.ALLATORIxDEMO("f\u0005x\u000fu\u0004]\u0014q\rg"));
                    return;
                }
                {
                    resultSet.close();
                    if (preparedStatement == null) break block17;
                    druidPooledConnection = druidPooledConnection2;
                }
                preparedStatement.close();
                break block18;
            }
            druidPooledConnection = druidPooledConnection2;
        }
        if (druidPooledConnection == null) return;
        druidPooledConnection2.close();
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void removeFromSQL(int a) {
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

    public /* synthetic */ int getItemSize() {
        GashaponSpecial a2;
        return a2.a.size();
    }
}

