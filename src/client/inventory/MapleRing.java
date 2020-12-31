/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException
 */
package client.inventory;

import client.ClientRedirector;
import client.MapleCharacter;
import client.inventory.MapleInventoryIdentifierRing;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import database.DBConPool;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Comparator;
import server.MapleInventoryManipulator;
import tools.ArrayMap;
import tools.FilePrinter;
import tools.FileoutputUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleRing
implements Serializable {
    private static final /* synthetic */ long g = 9179541993413738579L;
    private final /* synthetic */ int a;
    private final /* synthetic */ int k;
    private /* synthetic */ String d;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ int K;
    private final /* synthetic */ int B;

    public /* synthetic */ int getPartnerChrId() {
        MapleRing a2;
        return a2.K;
    }

    public static /* synthetic */ int createRing(int a2, MapleCharacter a322, String a4, String a5, int a6, int a7) {
        MapleCharacter a322;
        block5: {
            block4: {
                try {
                    if (a322 != null) break block4;
                    return -2;
                }
                catch (Exception a322) {
                    FilePrinter.printError(ClientRedirector.ALLATORIxDEMO("x%E(P\u0016\\*RjA<A"), a322, ArrayMap.ALLATORIxDEMO("\f$\n7\u001b3=?\u00011"));
                    return 0;
                }
            }
            if (a6 > 0) break block5;
            return -1;
        }
        return MapleRing.makeRing(a2, a322, a4, a6, a5, a7);
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ MapleRing loadFromDb(int a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 8[TRYBLOCK]
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
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void addToDB(int a, MapleCharacter a, String a, int a, int[] a) throws SQLException {
        var5_6 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var6_8 = var5_6.prepareStatement(ArrayMap.ALLATORIxDEMO("\u001f!\u0005*\u0004;v&\u0018;\u0019O$\u00068\b%O~\u001d?\u00011&2Cv\u0006\"\n;\u00062Cv\u001f7\u001d\"\u00013\u001d\u0015\u0007$&2Cv\u001f7\u001d\"\u00013\u001d\u0018\u000e;\nzO&\u000e$\u001b8\n$=?\u00011&2Fv9\u0017#\u0003*\u0005O~PzOiCvPzOiCvP\u007f"));
            v1 = var6_8;
            var6_8.setInt(1, a[0]);
            v1.setInt(2, a);
            v1.setInt(3, a.getId());
            v0.setString(4, a.getName());
            v0.setInt(5, a[1]);
            v0.executeUpdate();
            var6_8.close();
            v2 = var6_8 = var5_6.prepareStatement(ClientRedirector.ALLATORIxDEMO("|\nf\u0001g\u0010\u0015\r{\u0010zdG-[#Fd\u001d6\\*R\rQh\u0015-A!X-Qh\u00154T6A*P6v,G\rQh\u00154T6A*P6{%X!\u0019dE%G0[!G\u0016\\*R\rQm\u0015\u0012t\b`\u0001fd\u001d{\u0019d\nh\u0015{\u0019d\nh\u0015{\u001c"));
            v3 = var6_8;
            var6_8.setInt(1, a[1]);
            v3.setInt(2, a);
            v3.setInt(3, a);
            v2.setString(4, a);
            v2.setInt(5, a[0]);
            v2.executeUpdate();
            var6_8.close();
            ** if (var5_6 == null) goto lbl-1000
        }
        catch (Throwable var6_9) {
            if (var5_6 == null) ** GOTO lbl38
            try {
                var5_6.close();
                v4 = var6_9;
                ** GOTO lbl39
            }
            catch (Throwable a) {
                try {
                    var6_9.addSuppressed(a);
lbl38:
                    // 2 sources

                    v4 = var6_9;
lbl39:
                    // 2 sources

                    throw v4;
                }
                catch (SQLException var5_7) {
                    FileoutputUtil.outError(ArrayMap.ALLATORIxDEMO("\u00039\b%@\u8c91\u65f6\u5efd\u751f\u5e6eA\"\u0017\""), var5_7);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var5_6.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public /* synthetic */ int hashCode() {
        MapleRing a2;
        int n2 = 5;
        n2 = 53 * n2 + a2.B;
        return n2;
    }

    public /* synthetic */ int getRingId() {
        MapleRing a2;
        return a2.B;
    }

    private /* synthetic */ MapleRing(int a2, int a3, int a4, int a5, String a6) {
        MapleRing a7;
        MapleRing mapleRing = a7;
        MapleRing mapleRing2 = a7;
        MapleRing mapleRing3 = a7;
        mapleRing3.ALLATORIxDEMO = false;
        mapleRing3.B = a2;
        mapleRing2.k = a3;
        mapleRing2.K = a4;
        mapleRing.a = a5;
        mapleRing.d = a6;
    }

    public /* synthetic */ String getPartnerName() {
        MapleRing a2;
        return a2.d;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void removeRingFromDB(MapleCharacter a2) {
        block11: {
            block12: {
                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                preparedStatement = druidPooledConnection.prepareStatement(ClientRedirector.ALLATORIxDEMO("\u0017p\bp\u0007ad\u001fds\u0016z\t\u00156\\*R7\u0015\u0013}\u0001g\u0001\u00154T6A*P6v,G\rQd\bd\n"));
                preparedStatement.setInt(1, a2.getId());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) break block11;
                preparedStatement.close();
                resultSet.close();
                if (druidPooledConnection == null) break block12;
                druidPooledConnection.close();
            }
            return;
        }
        v0 = resultSet;
        n2 = v0.getInt(ArrayMap.ALLATORIxDEMO("&\u000e$\u001b8\n$=?\u00011&2"));
        n3 = v0.getInt(ClientRedirector.ALLATORIxDEMO("6\\*R\rQ"));
        v0.close();
        preparedStatement.close();
        v1 = preparedStatement = druidPooledConnection.prepareStatement(ArrayMap.ALLATORIxDEMO("+\u0013#\u0013;\u0013O\u0010=\u0019\"v\u001d?\u00011\u001cv8\u001e*\u0004*v\u001d?\u00011&2OkOiO\u0019=v\u001d?\u00011&2OkOi"));
        v1.setInt(1, n3);
        preparedStatement.setInt(2, n2);
        v1.executeUpdate();
        preparedStatement.close();
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
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block13;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (SQLException sQLException) {
                    FilePrinter.printError(ClientRedirector.ALLATORIxDEMO("x%E(P\u0016\\*RjA<A"), sQLException, ArrayMap.ALLATORIxDEMO("\u001d3\u00029\u00193=?\u00011)$\u0000;+\u0014"));
                }
            }
        }
    }

    public /* synthetic */ int getItemId() {
        MapleRing a2;
        return a2.a;
    }

    public static /* synthetic */ MapleRing loadFromDb(int a2) {
        return MapleRing.loadFromDb(a2, false);
    }

    public /* synthetic */ void setPartnerName(String a2) {
        a.d = a2;
    }

    public /* synthetic */ int getPartnerRingId() {
        MapleRing a2;
        return a2.k;
    }

    public /* synthetic */ void setEquipped(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 << 3 ^ 2;
        int cfr_ignored_0 = 2 << 3;
        int n5 = n3;
        int n6 = 5 << 4 ^ (3 ^ 5) << 1;
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

    public /* synthetic */ boolean equals(Object a2) {
        if (a2 instanceof MapleRing) {
            MapleRing a3;
            return ((MapleRing)a2).getRingId() == a3.getRingId();
        }
        return false;
    }

    public static /* synthetic */ int makeRing(int a2, MapleCharacter a3, String a4, int a5, String a6, int a7) throws Exception {
        int[] arrn = new int[2];
        arrn[0] = MapleInventoryIdentifierRing.getInstance();
        arrn[1] = MapleInventoryIdentifierRing.getInstance();
        int[] arrn2 = arrn;
        try {
            MapleRing.addToDB(a2, a3, a4, a5, arrn2);
        }
        catch (MySQLIntegrityConstraintViolationException mySQLIntegrityConstraintViolationException) {
            return 0;
        }
        MapleInventoryManipulator.addRing(a3, a2, arrn2[1], a7, a4);
        a3.getCashInventory().gift(a5, a3.getName(), a6, a7, arrn2[0]);
        return 1;
    }

    public /* synthetic */ boolean isEquipped() {
        MapleRing a2;
        return a2.ALLATORIxDEMO;
    }

    public static class RingComparator
    implements Comparator<MapleRing>,
    Serializable {
        public /* synthetic */ RingComparator() {
            RingComparator a2;
        }

        @Override
        public /* synthetic */ int compare(MapleRing a2, MapleRing a3) {
            if (a2.B < a3.B) {
                return -1;
            }
            if (a2.B == a3.B) {
                return 0;
            }
            return 1;
        }
    }
}

