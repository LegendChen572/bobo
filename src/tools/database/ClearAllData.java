/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.database;

import client.MapleClient;
import client.messages.commands.SkilledCommand;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tools.MockIOSession;
import tools.use.GetMACAddress;

/*
 * Exception performing whole class analysis ignored.
 */
public class ClearAllData {
    private static /* synthetic */ List<Integer> ALLATORIxDEMO;

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(SkilledCommand.ALLATORIxDEMO("!X\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bq\b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000bX!X\u000b[\u000b[\u000b[\u000b[\bX\u000bX\u000b[\u000bX\u000b[\u000b[\bX\u000bX\bX\u000bX\bX\u000bX\b[\u000bX\bX\u000b[\u000b[\u000b[\u000b[\bq\b[\u000b[\u000b[\u000b[\b[\b[\b[\u000b[\b[\u000b[\b[\b[\u000bX\u000b[\b[\b[\b[\b[\u000bX\u000b[\u000b[\u000b[\u000b[\u000bX!X\u000b[\u000b[\u000b[\u000bX\bX\u000bX\u000b[\u000bX\u000b[\u000bX\bX\u000b[\b[\u000bX\u000bX\u000bX\b[\u000b[\b[\u000b[\u000b[\u000b[\u000b[\bq\b[\u000b[\u000b[\u000b[\b[\b[\bX\b[\bX\b[\b[\b[\u000bX\u000b[\bX\b[\b[\b[\bX\b[\u000b[\u000b[\u000b[\u000bX!X\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\bq\b[d\u0019M\u000eX\u0018J\u000fB\u0014E[I\u0002\u000b:G\u0017J\u000fD\tB[d\u0019M\u000eX\u0018J\u000fD\t\u000b\r\u001cU\u0018[o>f4\u000bX!X\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\bq\b[\u000b[\u000b[\u000b[\u000b[\u000b[C\u000f_\u000b\u0011T\u0004\f\\\f\u0005\u001aG\u0017J\u000fD\tBUH\u0014F[\u000b[\u000b[\u000b[\u000b[\u000b[\u000bX!X\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\u000b[\bq\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX\bX!"));
        try {
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("z\u000bx\u0011x\u0000m\u0006k\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("F\u0014E\b_\u001eY\u0019D\u0014@"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("t\u0017j<z\u0002k\u0017"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("F\u000fX$B\u000fN\u0016X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u000ev\u0016w\u0017}\u0002m\u0002"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("M\u001aF\u001eG\u0014L"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("}\u0016|\u001ai\u0002z\bx\u0004|\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\fB\bC\u0017B\b_"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0001l\u0007}\n|\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0010N\u0002F\u001a["));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("j\u0002o\u0006}\u000fv\u0000x\u0017p\fw\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\b@\u0012G\u0017X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("m\u0011v\u0000r\u000fv\u0000x\u0017p\fw\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("Z\u000eN\b_\b_\u001a_\u000eX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\nw\u0015|\rm\fk\u001aj\u000fv\u0017"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0016D\u0015X\u000fN\t[\u001e_"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0001v\u0010j\u000fv\u0004"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0014E\u001e_\u0012F\u001eG\u0014L"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0004p\u0005m\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("N\rN\u0015_$H\u0014^\u0015_"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u000ev\u0016w\u0017{\u0002w\b"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0014M\u001dG\u0012E\u001eG\u0014H\u001a_\u0012D\u0015X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("k\u0006~\u0011v\u0000r\u000fv\u0000x\u0017p\fw\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u000fY\u0014H\u0010G\u0014H\u001a_\u0012D\u0015X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0011p\r~\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0018C\u001aY\u001aH\u000fN\tX$X\u001e_"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("i\u0011p\u0019|\u000fv\u0004"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("J\u0018G\u0014L"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0004t\u000fv\u0004"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u001c^\u0012G\u001fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("p\u0013{\u0002w\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("F\u001aH\u0019J\u0015X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0010i\u0006|\u0007k\u0016w\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\b_\u0014Y\u001aL\u001eX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("}\fw\u0002m\u0006"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u001aH\u0018D\u000eE\u000fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0001v\u0010j\u000fv\u0004"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\b@\u0012G\u0017X$H\u0014D\u0017O\u0014\\\u0015X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0010r\nu\u000ft\u0002z\u0011v\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("E\u0014_\u001eX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("t\fw\u0010m\u0006k\u0013|\u0017"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0012E\rN\u0015_\u0014Y\u0002B\u000fN\u0016X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("p\ro\u0006w\u0017v\u0011`\u0006h\u0016p\u0013t\u0006w\u0017"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("B\u0015]\u001eE\u000fD\tR\u0012_\u001eF\bt\u0011X\u0014E"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\nw\u0015|\rm\fk\u001ap\u0017|\u000ej<s\u0010v\rF\b|\u001a"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0013B\tN\u001fF\u001eY\u0018C"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("z\u000bx\u0011x\u0000m\u0006k\u0010F\u0010|\u0017"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u001dJ\u0016B\u0017B\u001eX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("i\u0006m\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u001eH\u000bJ\u0002t\u001fD\u0015J\u000fN\u000bD\u0012E\u000fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0006z\u0013x\u001aF\u0013x\u001at\u0006w\u0017"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("N\u0003_\u001eE\u001fN\u001fX\u0017D\u000fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("~\u0002j\u000bx\u0013v\rF\nm\u0006t\u0010F\u0010i\u0006z\nx\u000f"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("D\u001dM\u0017B\u0015N\u0012_\u001eF"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0010m\fk\u0002~\u0006j<|\u001bz\u0006|\u0007"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\fQ$B\u000fN\u0016O\u001a_\u001at\u0016D\u001fB\u001dR$X\u0017D\u000fF\u001aS"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0001{\u0010F\u0011|\u0013u\n|\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("I\u0019X$_\u0013Y\u001eJ\u001fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0000q\u0002k\u0002z\u0017|\u0011F\u0000v\u0011|\u0002l\u0011x\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("H\u0013J\tJ\u0018_\u001eY$H\u001aY\u001fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("j\u0017v\u000f|\r"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u000bJ\t_\u000fB\u0016N"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("x\r}\u0011v\n}\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u0018C\tt\u0011X\u0014E"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("x\u0000z<s\u0010v\r"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("H\u0013J\tJ\u0018_\u001eY$X\u0017D\u000fX"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u007f\nj\u000bp\r~<r\nw\u0004"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\u001fJ\u0002G\u0014L"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("w\u001bz\f}\u0006"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("\bN\t]\u001eY$X\u001e_"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("\u0004l\nu\u0007j\bp\u000fu\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("Z\u000eN\b_\b_\u001a_\u000eX\u0016D\u0019X"));
            ClearAllData.DeleteDatabase(GetMACAddress.ALLATORIxDEMO("q\u001ai\u0006k\u0011v\u0000r\u000fv\u0000x\u0017p\fw\u0010"));
            ClearAllData.DeleteDatabase(SkilledCommand.ALLATORIxDEMO("G\u0012E\u001eI\u0014_"));
            return;
        }
        catch (Exception exception) {
            System.out.println("ClearAllData:" + exception);
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void loadAllCharacter() {
        ALLATORIxDEMO.clear();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        preparedStatement = druidPooledConnection.prepareStatement(GetMACAddress.ALLATORIxDEMO("J&U&Z79I9%K,TCz\u000bx\u0011x\u0000m\u0006k\u0010"));
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ALLATORIxDEMO.add(resultSet.getInt(SkilledCommand.ALLATORIxDEMO("\u0012O")));
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
                    System.out.println("loadAllCharacter: " + sQLException);
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void deleteAcount(int a) {
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

    public static /* synthetic */ {
        ALLATORIxDEMO = new ArrayList<Integer>();
    }

    public static /* synthetic */ void DeleteDatabase(String a2) {
        try {
            if (DBConPool.getInstance().TableExist(a2)) {
                ClearAllData.Execute("DELETE FROM " + a2);
                ClearAllData.Execute("ALTER TABLE " + a2 + " AUTO_INCREMENT=1");
            }
        }
        catch (Exception exception) {
            System.out.println("ClearAllData:" + exception);
            System.out.println("[\u8cc7\u6599\u8868]" + a2 + " \u6e05\u9664\u5931\u6557..");
        }
        System.out.println("[\u8cc7\u6599\u8868]" + a2 + " \u6e05\u9664\u5b8c\u7562..");
    }

    public /* synthetic */ ClearAllData() {
        ClearAllData a2;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void Execute(String a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
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

    public static /* synthetic */ void DeleteAllCharacter() {
        Iterator<Integer> iterator;
        MapleClient mapleClient = new MapleClient(null, null, new MockIOSession());
        Iterator<Integer> iterator2 = iterator = ALLATORIxDEMO.iterator();
        while (iterator2.hasNext()) {
            int n2 = iterator.next();
            mapleClient.deleteCharacter(n2, true, false);
            ClearAllData.deleteAcount(n2);
            System.out.println("\u89d2\u8272\u522a\u9664\u5b8c\u7562 \u89d2\u8272ID:" + n2);
            iterator2 = iterator;
        }
    }
}

