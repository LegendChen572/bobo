/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client;

import client.LoginCrypto;
import client.LoginCryptoLegacy;
import client.MaplePartTimeJob;
import client.inventory.MapleImp;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.PiPiConfig;
import database.DBConPool;
import handling.world.guild.MapleGuild;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tools.FileoutputUtil;
import tools.Pair;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleCharacterUtil {
    private static final /* synthetic */ String[] ALLATORIxDEMO;
    private static final /* synthetic */ Pattern d;
    private static final /* synthetic */ Pattern a;

    public /* synthetic */ long getTotalKillMob() {
        MapleCharacterUtil a2;
        return a2.getTotalChr(MapleImp.ALLATORIxDEMO("t9S<r?]\u0013P%Q$"));
    }

    public static /* synthetic */ {
        a = Pattern.compile(MapleImp.ALLATORIxDEMO("\u000b^}E\u0011\u0012\n\u000f}\u0006\u000f\u0012\rDc\u0013a\r-"));
        d = Pattern.compile(MapleGuild.ALLATORIxDEMO(";eM~!):4M=?)=\u007fT(Q6\u001d"));
        String[] arrstring = new String[30];
        arrstring[0] = MapleImp.ALLATORIxDEMO("0");
        arrstring[1] = MapleGuild.ALLATORIxDEMO("\u001e");
        arrstring[2] = "!";
        arrstring[3] = "@";
        arrstring[4] = MapleImp.ALLATORIxDEMO("s");
        arrstring[5] = MapleGuild.ALLATORIxDEMO("D");
        arrstring[6] = MapleImp.ALLATORIxDEMO("u");
        arrstring[7] = MapleGuild.ALLATORIxDEMO(">");
        arrstring[8] = MapleImp.ALLATORIxDEMO("v");
        arrstring[9] = MapleGuild.ALLATORIxDEMO("J");
        arrstring[10] = MapleImp.ALLATORIxDEMO("x");
        arrstring[11] = MapleGuild.ALLATORIxDEMO("I");
        arrstring[12] = MapleImp.ALLATORIxDEMO("\u000f");
        arrstring[13] = MapleGuild.ALLATORIxDEMO("M");
        arrstring[14] = MapleImp.ALLATORIxDEMO("m");
        arrstring[15] = MapleGuild.ALLATORIxDEMO("K");
        arrstring[16] = MapleImp.ALLATORIxDEMO("+");
        arrstring[17] = MapleGuild.ALLATORIxDEMO(";");
        arrstring[18] = MapleImp.ALLATORIxDEMO("\r");
        arrstring[19] = MapleGuild.ALLATORIxDEMO("\u001d");
        arrstring[20] = MapleImp.ALLATORIxDEMO(",");
        arrstring[21] = MapleGuild.ALLATORIxDEMO("[");
        arrstring[22] = MapleImp.ALLATORIxDEMO("j");
        arrstring[23] = MapleGuild.ALLATORIxDEMO("G");
        arrstring[24] = MapleImp.ALLATORIxDEMO("|");
        arrstring[25] = MapleGuild.ALLATORIxDEMO("\\");
        arrstring[26] = MapleImp.ALLATORIxDEMO("n");
        arrstring[27] = MapleGuild.ALLATORIxDEMO("N");
        arrstring[28] = MapleImp.ALLATORIxDEMO("o");
        arrstring[29] = "/";
        ALLATORIxDEMO = arrstring;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ String getNameById(int a2) {
        String string;
        block12: {
            ResultSet resultSet;
            DruidPooledConnection druidPooledConnection;
            block10: {
                String string2;
                block11: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleGuild.ALLATORIxDEMO("3A,A#P@.@B2K-$\u0003l\u0001v\u0001g\u0014a\u0012w@S(A2A@m\u0004$]$_"));
                    preparedStatement.setInt(1, a2);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) break block10;
                    string2 = null;
                    if (druidPooledConnection == null) break block11;
                    druidPooledConnection.close();
                }
                return string2;
            }
            string = resultSet.getString(MapleImp.ALLATORIxDEMO("Q1R5"));
            if (druidPooledConnection == null) break block12;
            {
                catch (Throwable throwable) {
                    try {
                        Throwable throwable2;
                        block13: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    throwable2 = throwable;
                                    break block13;
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
                        System.err.println("error 'getNameById' " + sQLException);
                        return null;
                    }
                }
            }
            druidPooledConnection.close();
        }
        return string;
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ int getIdByName(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK], 2[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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
    public static /* synthetic */ void addPartTime(int a, byte a, long a, int a) {
        var5_5 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var6_7 = var5_5.prepareStatement(MapleGuild.ALLATORIxDEMO(")J3A2P@M.P/$\u0010e\u0012p\u0014m\ra@,\u0003m\u0004(@n\u000ffL$\u0014m\raL$\u0012a\u0017e\u0012`I$6E,Q%W@,_(@;L$_(@;I"));
            v1 = var6_7;
            v1.setInt(1, a);
            v1.setByte(2, a);
            v0.setLong(3, a);
            v0.setInt(4, a);
            v0.execute();
            ** if (var5_5 == null) goto lbl-1000
        }
        catch (Throwable var6_8) {
            if (var5_5 == null) ** GOTO lbl26
            try {
                var5_5.close();
                v2 = var6_8;
                ** GOTO lbl27
            }
            catch (Throwable a) {
                try {
                    var6_8.addSuppressed(a);
lbl26:
                    // 2 sources

                    v2 = var6_8;
lbl27:
                    // 2 sources

                    throw v2;
                }
                catch (SQLException var5_6) {
                    System.out.println("\u6dfb\u52a0\u6253\u5de5\u7cfb\u7d71\u5931\u6557: " + var5_6);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var5_5.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ boolean SetPoll(int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
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

    private static /* synthetic */ boolean ALLATORIxDEMO(String a2, String a3, String a4) {
        if (LoginCryptoLegacy.isLegacyPassword(a2) && LoginCryptoLegacy.checkPassword(a3, a2)) {
            return true;
        }
        if (a4 == null && LoginCrypto.checkSha1Hash(a2, a3)) {
            return true;
        }
        return LoginCrypto.checkSaltedSha512Hash(a2, a3, a4);
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ String getAccountNameByCharacterName(String a2) {
        String string = "";
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement("SELECT name FROM accounts WHERE id in (SELECT `accountid` FROM `characters` WHERE name = '" + a2 + "')");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            string = resultSet.getString(MapleImp.ALLATORIxDEMO("Q1R5"));
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block12;
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
                    System.err.println(sQLException);
                    SQLException sQLException2 = sQLException;
                    FileoutputUtil.printError(MapleGuild.ALLATORIxDEMO("I\u0001t\fa#l\u0001v\u0001g\u0014a\u0012Q\u0014m\f*\u0014|\u0014"), sQLException2, "[getAccountNameByCharacterName] id: " + sQLException2);
                    return string;
                }
                catch (Exception exception) {
                    System.err.println(exception);
                    Exception exception2 = exception;
                    FileoutputUtil.printError(MapleImp.ALLATORIxDEMO("r1O<Z\u0013W1M1\\$Z\"j$V<\u0011$G$"), exception2, "[getAccountNameByCharacterName] id: " + exception2);
                }
            }
        }
        return string;
    }

    public static final /* synthetic */ boolean isEligibleCharName(String a2) {
        int n2;
        if (a2.getBytes().length > 15) {
            return false;
        }
        if (a2.getBytes().length < 3) {
            return false;
        }
        String[] arrstring = GameConstants.RESERVED;
        int n3 = GameConstants.RESERVED.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = arrstring[n2];
            if (a2.contains(string)) {
                return false;
            }
            n4 = ++n2;
        }
        return PiPiConfig.isCanTalkText(a2);
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void setbindac(int a, int a) {
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

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getTotalAcc(String a) {
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

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void sendNote(String a, String a, String a, int a) {
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

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean setMonitored(int a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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
    public static final /* synthetic */ boolean isExistCharacterInDataBase(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 4[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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
    public static /* synthetic */ int loadAccountidByPlayerid(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    public static /* synthetic */ boolean isEnglishAndNumberAndChinese(String a2) {
        return a2.matches(MapleImp.ALLATORIxDEMO("a\u000b\u4e3f}\u9f9a\u000f^}E\u0011\u0012\n\u000f}\u0006\r\u0014t"));
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ List<String> getCharacterNameByAccountName(String a2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleImp.ALLATORIxDEMO("\u0003z\u001cz\u0013kpQ1R5\u001f\u0016m\u001frp\\8^\"^3K5M#\u001f\u0007w\u0015m\u0015\u001f1\\3P%Q$V4\u001f9Qp\u0017\u0003z\u001cz\u0013kp_9[0\u001f\u0016m\u001frp_1\\3P%Q$L0\u001f\u0007w\u0015m\u0015\u001f>^=Zp\u0002p\u0000y"));
        preparedStatement.setString(1, a2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            arrayList.add(resultSet.getString(MapleGuild.ALLATORIxDEMO("j\u0001i\u0005")));
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block12;
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
                    System.err.println(sQLException);
                    SQLException sQLException2 = sQLException;
                    FileoutputUtil.printError(MapleImp.ALLATORIxDEMO("r1O<Z\u0013W1M1\\$Z\"j$V<\u0011$G$"), sQLException2, "[getChataterNameByAccountName] id: " + sQLException2);
                    return arrayList;
                }
                catch (Exception exception) {
                    System.err.println(exception);
                    Exception exception2 = exception;
                    FileoutputUtil.printError(MapleGuild.ALLATORIxDEMO("I\u0001t\fa#l\u0001v\u0001g\u0014a\u0012Q\u0014m\f*\u0014|\u0014"), exception2, "[getChataterNameByAccountName] id: " + exception2);
                }
            }
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getTotalChr(String a) {
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

    public static /* synthetic */ boolean hasSymbols(String a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < ALLATORIxDEMO.length) {
            if (a2.contains(ALLATORIxDEMO[n2])) {
                return true;
            }
            n3 = n2 = (int)((byte)(n2 + 1));
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ boolean PromptPoll(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK], 2[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    public /* synthetic */ long getTotalLevel() {
        MapleCharacterUtil a2;
        return a2.getTotalChr(MapleGuild.ALLATORIxDEMO("\fa\u0016a\f"));
    }

    public /* synthetic */ long getTotalMeso() {
        MapleCharacterUtil a2;
        return a2.getTotalChr(MapleGuild.ALLATORIxDEMO("i\u0005w\u000f"));
    }

    public /* synthetic */ long getTotalMP() {
        MapleCharacterUtil a2;
        return a2.getTotalChr(MapleGuild.ALLATORIxDEMO("\rT\u000fm\u000ep\u0013"));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void removePartTime(int a) {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var1_1.prepareStatement(MapleImp.ALLATORIxDEMO("{\u0015s\u0015k\u0015\u001f\u0016m\u001frpO1M$K9R5\u001f\u0007w\u0015m\u0015\u001f3V4\u001fm\u001fo"));
            var2_3.setInt(1, a);
            var2_3.executeUpdate();
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_1 == null) ** GOTO lbl22
            try {
                var1_1.close();
                v0 = var2_4;
                ** GOTO lbl23
            }
            catch (Throwable var3_5) {
                try {
                    var2_4.addSuppressed(var3_5);
lbl22:
                    // 2 sources

                    v0 = var2_4;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var1_2) {
                    System.out.println("\u522a\u9664\u6253\u5de5\u7cfb\u7d71\u5931\u6557: " + var1_2);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_1.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ String getAccountNameByAccountId(int a) {
        var1_1 = "";
        var3_2 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var4_5 = var3_2.prepareStatement(MapleGuild.ALLATORIxDEMO("W%H%G4$\u000ee\ra@B2K-$\u0001g\u0003k\u0015j\u0014w@S(A2A@m\u0004$]$_"));
            var4_5.setInt(1, a);
            var2_7 = var4_5.executeQuery();
            if (var2_7.next()) {
                var1_1 = var2_7.getString(MapleImp.ALLATORIxDEMO("Q1R5"));
            }
            ** if (var3_2 == null) goto lbl-1000
        }
        catch (Throwable var4_6) {
            if (var3_2 == null) ** GOTO lbl23
            try {
                var3_2.close();
                v0 = var4_6;
                ** GOTO lbl24
            }
            catch (Throwable var2_8) {
                try {
                    var4_6.addSuppressed(var2_8);
lbl23:
                    // 2 sources

                    v0 = var4_6;
lbl24:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var3_3) {
                    System.err.println(var3_3);
                    v1 = var3_3;
                    FileoutputUtil.printError(MapleGuild.ALLATORIxDEMO("I\u0001t\fa#l\u0001v\u0001g\u0014a\u0012Q\u0014m\f*\u0014|\u0014"), v1, "[getAccountNameByAccountId] id: " + v1);
                    return var1_1;
                }
                catch (Exception var3_4) {
                    System.err.println(var3_4);
                    v2 = var3_4;
                    FileoutputUtil.printError(MapleImp.ALLATORIxDEMO("r1O<Z\u0013W1M1\\$Z\"j$V<\u0011$G$"), v2, "[getAccountNameByAccountId] id: " + v2);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var3_2.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return var1_1;
    }

    public /* synthetic */ MapleCharacterUtil() {
        MapleCharacterUtil a2;
    }

    public /* synthetic */ long getTotalVPoints() {
        MapleCharacterUtil a2;
        return a2.getTotalChr(MapleGuild.ALLATORIxDEMO("\u0016t\u000fm\u000ep\u0013"));
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void sendAccNote(String a, String a, String a, int a) {
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

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ Pair<String, Integer> getAcccountNameById(int a2, int a322222222) {
        Pair<String, Integer> pair;
        block12: {
            ResultSet a322222222;
            DruidPooledConnection druidPooledConnection;
            block10: {
                Pair<String, Integer> pair2;
                block11: {
                    PreparedStatement preparedStatement;
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(MapleImp.ALLATORIxDEMO("\u0003z\u001cz\u0013kp\u0015py\u0002p\u001d\u001f3W1M1\\$Z\"Lph\u0018z\u0002zpV4\u001fm\u001fo\u001f\u0011q\u0014\u001f'P\"S4\u001fm\u001fo"));
                    preparedStatement2.setInt(1, a2);
                    preparedStatement2.setInt(2, a322222222);
                    a322222222 = preparedStatement2.executeQuery();
                    if (a322222222.next()) break block10;
                    pair2 = null;
                    if (druidPooledConnection == null) break block11;
                    druidPooledConnection.close();
                }
                return pair2;
            }
            pair = new Pair<String, Integer>(a322222222.getString(MapleGuild.ALLATORIxDEMO("j\u0001i\u0005")), a322222222.getInt(MapleImp.ALLATORIxDEMO("1\\3P%Q$V4")));
            if (druidPooledConnection == null) break block12;
            {
                catch (Throwable throwable) {
                    try {
                        Throwable throwable2;
                        block13: {
                            if (druidPooledConnection != null) {
                                try {
                                    druidPooledConnection.close();
                                    throwable2 = throwable;
                                    break block13;
                                }
                                catch (Throwable a322222222) {
                                    throwable.addSuppressed(a322222222);
                                }
                            }
                            throwable2 = throwable;
                        }
                        throw throwable2;
                    }
                    catch (SQLException sQLException) {
                        System.err.println("error 'getNameById' " + sQLException);
                        return null;
                    }
                }
            }
            druidPooledConnection.close();
        }
        return pair;
    }

    public static final /* synthetic */ boolean canCreateChar(String a2) {
        return MapleCharacterUtil.getIdByName(a2) == -1 && MapleCharacterUtil.isEligibleCharName(a2);
    }

    public /* synthetic */ long getTotalGash() {
        MapleCharacterUtil a2;
        return a2.getTotalAcc(MapleImp.ALLATORIxDEMO("\u0011\\1L8"));
    }

    public static final /* synthetic */ boolean canChangePetName(String a2) {
        int n2;
        String[] arrstring = GameConstants.RESERVED;
        int n3 = GameConstants.RESERVED.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = arrstring[n2];
            if (a2.contains(string)) {
                return false;
            }
            n4 = ++n2;
        }
        return !MapleCharacterUtil.hasSymbols(a2) && MapleCharacterUtil.isEnglishAndNumberAndChinese(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean checkPassword(String a, String a) {
        block15: {
            block13: {
                var2_2 = false;
                var3_3 = "";
                var4_4 = "";
                var5_5 = DBConPool.getInstance().getDataSource().getConnection();
                var6_7 = var5_5.prepareStatement(MapleGuild.ALLATORIxDEMO("3A,A#P@.@B2K-$\u0001g\u0003k\u0015j\u0014w@S(A2A@j\u0001i\u0005$]$_"));
                var6_7.setString(1, a);
                var7_9 = var6_7.executeQuery();
                if (var7_9.next()) {
                    v0 = var7_9;
                    var3_3 = v0.getString(MapleImp.ALLATORIxDEMO("O1L#H?M4"));
                    var4_4 = v0.getString(MapleGuild.ALLATORIxDEMO("w\u0001h\u0014"));
                }
                if (var4_4 != null || !LoginCrypto.checkSha1Hash(var3_3, a)) break block13;
                var2_2 = true;
                v1 = var5_5;
                ** GOTO lbl24
            }
            if (LoginCrypto.checkSaltedSha512Hash(var3_3, a, var4_4)) {
                var2_2 = true;
            }
            v1 = var5_5;
lbl24:
            // 2 sources

            if (v1 != null) {
                var5_5.close();
            }
            break block15;
            {
                catch (Throwable var6_8) {
                    try {
                        block14: {
                            if (var5_5 != null) {
                                try {
                                    var5_5.close();
                                    v2 = var6_8;
                                    break block14;
                                }
                                catch (Throwable var7_10) {
                                    var6_8.addSuppressed(var7_10);
                                }
                            }
                            v2 = var6_8;
                        }
                        throw v2;
                    }
                    catch (Exception var5_6) {
                        var5_6.printStackTrace();
                    }
                }
            }
        }
        return var2_2;
    }

    public /* synthetic */ long getTotalPoints() {
        MapleCharacterUtil a2;
        return a2.getTotalChr(MapleImp.ALLATORIxDEMO("O?V>K#"));
    }

    public static final /* synthetic */ String makeMapleReadable(String a2) {
        String string = a2.replace('I', 'i');
        string = string.replace('l', 'L');
        string = string.replace(MapleGuild.ALLATORIxDEMO("v\u000e"), MapleImp.ALLATORIxDEMO("m>"));
        string = string.replace(MapleGuild.ALLATORIxDEMO("r\u0016"), MapleImp.ALLATORIxDEMO("i&"));
        string = string.replace(MapleGuild.ALLATORIxDEMO("R6"), MapleImp.ALLATORIxDEMO("i&"));
        return string;
    }

    public static /* synthetic */ void addPartTime(MaplePartTimeJob a2) {
        if (a2.getCharacterId() < 1) {
            return;
        }
        MapleCharacterUtil.addPartTime(a2.getCharacterId(), a2.getJob(), a2.getTime(), a2.getReward());
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ int getGiftAmount(int a) {
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

    /*
     * Exception decompiling
     */
    public static /* synthetic */ Pair<Integer, Pair<Integer, Integer>> getInfoByName(String a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 4[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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
    public static /* synthetic */ MaplePartTimeJob getPartTime(int a) {
        var1_1 = new MaplePartTimeJob(a);
        var2_2 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var3_4 = var2_2.prepareStatement(MapleGuild.ALLATORIxDEMO("W%H%G4$J$&V/I@t\u0001v\u0014p\ti\u0005$7L%V%$\u0003m\u0004$]$_"));
            var3_4.setInt(1, a);
            var4_6 = var3_4.executeQuery();
            if (var4_6.next()) {
                v0 = var1_1;
                v1 = var4_6;
                var1_1.setJob(v1.getByte(MapleImp.ALLATORIxDEMO(":P2")));
                v0.setTime(v1.getLong(MapleGuild.ALLATORIxDEMO("p\ti\u0005")));
                v0.setReward(var4_6.getInt(MapleImp.ALLATORIxDEMO("M5H1M4")));
            }
            ** if (var2_2 == null) goto lbl-1000
        }
        catch (Throwable var3_5) {
            if (var2_2 == null) ** GOTO lbl27
            try {
                var2_2.close();
                v2 = var3_5;
                ** GOTO lbl28
            }
            catch (Throwable var4_7) {
                try {
                    var3_5.addSuppressed(var4_7);
lbl27:
                    // 2 sources

                    v2 = var3_5;
lbl28:
                    // 2 sources

                    throw v2;
                }
                catch (Exception var2_3) {
                    System.out.println("\u67e5\u8a62\u6253\u5de5\u7cfb\u7d71\u5931\u6557: " + var2_3);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_2.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return var1_1;
    }
}

