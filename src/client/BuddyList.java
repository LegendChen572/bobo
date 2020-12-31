/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client;

import FuckingHackerToby.ka;
import client.BuddyEntry;
import client.MapleCharacter;
import client.MapleClient;
import client.messages.commands.PracticerCommand;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import server.Timer;
import server.gashapon.GashaponRewardSpecial;
import server.maps.Event_PyramidSubway;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

public class BuddyList
implements Serializable {
    private final /* synthetic */ Deque<BuddyEntry> ALLATORIxDEMO;
    private final /* synthetic */ Map<Integer, BuddyEntry> a;
    private /* synthetic */ byte d;
    public static final /* synthetic */ String DEFAULT_GROUP = "\u5c1a\u672a\u8a2d\u5b9a\u7fa4\u7d44";

    public /* synthetic */ BuddyList(byte a2) {
        BuddyList a3;
        BuddyList buddyList = a3;
        BuddyList buddyList2 = a3;
        buddyList.ALLATORIxDEMO = new LinkedList<BuddyEntry>();
        buddyList.a = new LinkedHashMap<Integer, BuddyEntry>();
        buddyList.d = a2;
    }

    public /* synthetic */ boolean containsVisible(int a22) {
        BuddyList a3;
        BuddyEntry a22 = a3.a.get(a22);
        if (a22 == null) {
            return false;
        }
        return a22.isVisible();
    }

    public /* synthetic */ Collection<BuddyEntry> getBuddies() {
        BuddyList a2;
        return a2.a.values();
    }

    public /* synthetic */ BuddyList(int a2) {
        BuddyList a3;
        BuddyList buddyList = a3;
        BuddyList buddyList2 = a3;
        buddyList.ALLATORIxDEMO = new LinkedList<BuddyEntry>();
        buddyList.a = new LinkedHashMap<Integer, BuddyEntry>();
        buddyList.d = (byte)a2;
    }

    public /* synthetic */ void setCapacity(byte a2) {
        a.d = a2;
    }

    public /* synthetic */ boolean isFull() {
        BuddyList a2;
        if (a2.a.size() >= a2.d) {
            FileoutputUtil.logToFile(GashaponRewardSpecial.ALLATORIxDEMO("Kk@w\b\u5979\u53ec\u8d81\u51dd*S|S"), "\r\n " + FileoutputUtil.NowTime() + " buddies.size():" + a2.a.size() + "  capacity:" + a2.d);
        }
        return a2.a.size() >= a2.d;
    }

    public /* synthetic */ void remove(int a2) {
        BuddyList a3;
        a3.a.remove(a2);
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void addBuddyToDB(MapleCharacter a, BuddyEntry a) {
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

    public /* synthetic */ BuddyEntry pollPendingRequest() {
        BuddyList a2;
        return a2.ALLATORIxDEMO.pollLast();
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ int getBuddyCount(int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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
    public static /* synthetic */ int getBuddyPending(int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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

    public /* synthetic */ void addBuddyRequest(MapleClient a2, int a3, String a4, int a5, int a6, int a7, int a8, int a9) {
        BuddyList a10;
        BuddyList buddyList = a10;
        buddyList.put(new BuddyEntry(a4, a3, DEFAULT_GROUP, a5, a6, false, a7, a8, a9));
        if (buddyList.ALLATORIxDEMO.isEmpty()) {
            ((MapleClient)a2).sendPacket(MaplePacketCreator.requestBuddylistAdd(a3, a4, a7, a8, a9));
            return;
        }
        a2 = new BuddyEntry(a4, a3, DEFAULT_GROUP, -1, -1, false, a7, a8, a9);
        a10.ALLATORIxDEMO.push((BuddyEntry)a2);
    }

    public /* synthetic */ byte getCapacity() {
        BuddyList a2;
        return a2.d;
    }

    public /* synthetic */ void loadFromTransfer(Map<BuddyEntry, Boolean> a2) {
        for (Map.Entry<BuddyEntry, Boolean> entry : a2.entrySet()) {
            BuddyList a3;
            a2 = entry.getKey();
            if (!entry.getValue().booleanValue()) {
                a3.ALLATORIxDEMO.push((BuddyEntry)a2);
                continue;
            }
            a3.put(new BuddyEntry(((BuddyEntry)a2).getName(), ((BuddyEntry)a2).getCharacterId(), ((BuddyEntry)a2).getGroup(), -1, -1, true, ((BuddyEntry)a2).getLevel(), ((BuddyEntry)a2).getJob(), ((BuddyEntry)a2).getSub()));
        }
    }

    public /* synthetic */ void put(BuddyEntry a2) {
        BuddyList a3;
        a3.a.put(a2.getCharacterId(), a2);
    }

    public /* synthetic */ boolean contains(int a2) {
        BuddyList a3;
        return a3.a.containsKey(a2);
    }

    public /* synthetic */ BuddyEntry get(int a2) {
        BuddyList a3;
        return a3.a.get(a2);
    }

    public /* synthetic */ BuddyEntry get(String a2) {
        BuddyList a3;
        a2 = a2.toLowerCase();
        for (BuddyEntry buddyEntry : a3.a.values()) {
            if (!buddyEntry.getName().toLowerCase().equals(a2)) continue;
            return buddyEntry;
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void loadFromDb(int a2) throws SQLException {
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(Timer.ALLATORIxDEMO("3Q,Q#@@vNv\u0015p\u0004m\tpL4\u0002:\u0010q\u000ep\tz\u00078@wNz\u0001y\u00054\u0001g@v\u0015p\u0004m\u000eu\rqL4\u0003:\n{\u00024\u0001g@v\u0015p\u0004m\n{\u00028@wNx\u0005b\u0005x@u\u00134\u0002a\u0004p\u0019x\u0005b\u0005xL4\u0003:\u0013a\u0002w\u0001`\u0005s\u000ff\u00194\u0001g@v\u0015p\u0004m\u0013a\u00028@vNs\u0012{\u0015d\u000eu\rq@R2[-4\u0002a\u0004p\tq\u00134\u0001g@vL4\u0003|\u0001f\u0001w\u0014q\u0012g@u\u00134\u000347\\%F%4\u0003:\tp@)@vNv\u0015p\u0004m\tp@U.P@vNw\bu\u0012u\u0003`\u0005f\tp@)@+"));
            preparedStatement.setInt(1, a2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BuddyList a3;
                ResultSet resultSet2 = resultSet;
                int n2 = resultSet2.getInt(GashaponRewardSpecial.ALLATORIxDEMO("EqC`^mC"));
                String string = resultSet2.getString(Timer.ALLATORIxDEMO("v\u0015p\u0004m\u000eu\rq"));
                if (resultSet2.getInt(GashaponRewardSpecial.ALLATORIxDEMO("WaI`Nj@")) == 1) {
                    a3.ALLATORIxDEMO.push(new BuddyEntry(string, n2, resultSet.getString(Timer.ALLATORIxDEMO("s\u0012{\u0015d\u000eu\rq")), -1, -1, false, resultSet.getInt(GashaponRewardSpecial.ALLATORIxDEMO("fR`C}KaQaK")), resultSet.getInt(Timer.ALLATORIxDEMO("\u0002a\u0004p\u0019~\u000fv")), resultSet.getInt(GashaponRewardSpecial.ALLATORIxDEMO("fR`C}TqE"))));
                    continue;
                }
                a3.put(new BuddyEntry(string, n2, resultSet.getString(Timer.ALLATORIxDEMO("s\u0012{\u0015d\u000eu\rq")), -1, -1, true, resultSet.getInt(GashaponRewardSpecial.ALLATORIxDEMO("fR`C}KaQaK")), resultSet.getInt(Timer.ALLATORIxDEMO("\u0002a\u0004p\u0019~\u000fv")), resultSet.getInt(GashaponRewardSpecial.ALLATORIxDEMO("fR`C}TqE"))));
            }
            {
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
            resultSet.close();
            preparedStatement.close();
            preparedStatement = druidPooledConnection.prepareStatement(Timer.ALLATORIxDEMO("P%X%@%4&F/Y@v\u0015p\u0004}\u0005g@C(Q2Q@d\u0005z\u0004}\u000es@)@%@U.P@w\bu\u0012u\u0003`\u0005f\tp@)@+"));
            preparedStatement.setInt(1, a2);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            if (druidPooledConnection == null) return;
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            FileoutputUtil.outError(GashaponRewardSpecial.ALLATORIxDEMO("hHcT+\u8ce0\u659d\u5e8c\u7574\u5e1f*S|S"), sQLException);
        }
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ int getBuddyCapacity(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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

    public /* synthetic */ Collection<Integer> getBuddiesIds() {
        BuddyList a2;
        return a2.a.keySet();
    }

    public static final class BuddyAddResult
    extends Enum<BuddyAddResult> {
        public static final /* synthetic */ /* enum */ BuddyAddResult OK;
        private static final /* synthetic */ BuddyAddResult[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ BuddyAddResult ALREADY_ON_LIST;
        public static final /* synthetic */ /* enum */ BuddyAddResult BUDDYLIST_FULL;

        public static /* synthetic */ {
            BUDDYLIST_FULL = new BuddyAddResult(ka.H("W3Q\"L*\\5A9S3Y*"), 0);
            ALREADY_ON_LIST = new BuddyAddResult(PracticerCommand.ALLATORIxDEMO(":K)B:C\"X4I$K2T/"), 1);
            OK = new BuddyAddResult(ka.H("Z-"), 2);
            BuddyAddResult[] arrbuddyAddResult = new BuddyAddResult[3];
            arrbuddyAddResult[0] = BUDDYLIST_FULL;
            arrbuddyAddResult[1] = ALREADY_ON_LIST;
            arrbuddyAddResult[2] = OK;
            ALLATORIxDEMO = arrbuddyAddResult;
        }

        public static /* synthetic */ BuddyAddResult[] values() {
            return (BuddyAddResult[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ BuddyAddResult valueOf(String a2) {
            return Enum.valueOf(BuddyAddResult.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ BuddyAddResult() {
            void var2_-1;
            void var1_-1;
            BuddyAddResult a2;
        }
    }

    public static final class BuddyOperation
    extends Enum<BuddyOperation> {
        private static final /* synthetic */ BuddyOperation[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ BuddyOperation DELETED;
        public static final /* synthetic */ /* enum */ BuddyOperation ADDED;

        public static /* synthetic */ {
            ADDED = new BuddyOperation(Event_PyramidSubway.ALLATORIxDEMO("e\u001e`\u001f`"), 0);
            DELETED = new BuddyOperation(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"0\b8\b \b0"), 1);
            BuddyOperation[] arrbuddyOperation = new BuddyOperation[2];
            arrbuddyOperation[0] = ADDED;
            arrbuddyOperation[1] = DELETED;
            ALLATORIxDEMO = arrbuddyOperation;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ BuddyOperation() {
            void var2_-1;
            void var1_-1;
            BuddyOperation a2;
        }

        public static /* synthetic */ BuddyOperation valueOf(String a2) {
            return Enum.valueOf(BuddyOperation.class, a2);
        }

        public static /* synthetic */ BuddyOperation[] values() {
            return (BuddyOperation[])ALLATORIxDEMO.clone();
        }
    }
}

