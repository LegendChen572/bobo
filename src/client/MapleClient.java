/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 *  io.netty.channel.Channel
 *  io.netty.util.AttributeKey
 */
package client;

import client.LoginCrypto;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleCoreAura;
import client.messages.commands.player.\u592d\u58fd\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.BanAttackIP;
import constants.GameSetConstants;
import constants.ServerConfig;
import constants.ServerConstants;
import database.DBConPool;
import handling.ClientChannelGroup;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.opcodes.PartyOperation;
import handling.world.MapleMessengerCharacter;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.guild.MapleGuildSummary;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.script.ScriptEngine;
import server.quest.MapleQuest;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.HexTool;
import tools.MapleAESOFB;
import tools.packet.LoginPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleClient {
    public static final transient /* synthetic */ byte CHANGE_CHANNEL = 6;
    private final transient /* synthetic */ Set<String> b;
    private /* synthetic */ byte P;
    private /* synthetic */ boolean O;
    private /* synthetic */ boolean d;
    public static final transient /* synthetic */ byte CASH_SHOP_TRANSITION_LEAVE = 9;
    private /* synthetic */ boolean n;
    public /* synthetic */ long lastNpcClick;
    public /* synthetic */ boolean OtpFailed;
    public static final /* synthetic */ AttributeKey<MapleClient> CLIENT_KEY;
    private /* synthetic */ int z;
    private final /* synthetic */ MapleAESOFB y;
    private /* synthetic */ String ALLATORIxDEMO;
    private transient /* synthetic */ Calendar v;
    private final /* synthetic */ Channel p;
    private transient /* synthetic */ String i;
    private transient /* synthetic */ ScheduledFuture<?> A;
    private /* synthetic */ int u;
    private /* synthetic */ long H;
    private /* synthetic */ byte Z;
    public /* synthetic */ boolean OtpVerified;
    private /* synthetic */ int Q;
    private static final /* synthetic */ Lock L;
    public static final transient /* synthetic */ byte LOGIN_CS_LOGGEDIN = 5;
    private /* synthetic */ int q;
    public static final transient /* synthetic */ byte LOGIN_MTS_LOGGEDIN = 8;
    private final transient /* synthetic */ List<Integer> w;
    private /* synthetic */ long B;
    public /* synthetic */ long lastLoginTime;
    private /* synthetic */ int Y;
    private /* synthetic */ long k;
    private /* synthetic */ boolean s;
    public static final transient /* synthetic */ byte LOGIN_SERVERLIST = 3;
    private /* synthetic */ String I;
    private /* synthetic */ String C;
    private transient /* synthetic */ long N;
    private final /* synthetic */ MapleAESOFB W;
    private /* synthetic */ int J;
    private final transient /* synthetic */ Map<String, ScriptEngine> m;
    private /* synthetic */ int M;
    public static final transient /* synthetic */ byte LOGIN_LOGGEDIN = 2;
    private /* synthetic */ short o;
    private /* synthetic */ String l;
    public static final transient /* synthetic */ byte MAPLE_TRADE_TRANSITION_LEAVE = 10;
    private /* synthetic */ boolean r;
    private /* synthetic */ boolean S;
    public static final transient /* synthetic */ byte LOGIN_SERVER_TRANSITION = 1;
    private /* synthetic */ boolean g;
    private final transient /* synthetic */ Lock D;
    public static final transient /* synthetic */ byte CASH_SHOP_TRANSITION = 4;
    private /* synthetic */ boolean X;
    private final transient /* synthetic */ Lock h;
    public static final transient /* synthetic */ byte LOGIN_CHARLIST = 11;
    private /* synthetic */ String U;
    private /* synthetic */ int e;
    private static /* synthetic */ int F;
    private /* synthetic */ byte t;
    private /* synthetic */ boolean j;
    public static final transient /* synthetic */ byte MAPLE_TRADE_TRANSITION = 7;
    private transient /* synthetic */ Calendar T;
    private transient /* synthetic */ String f;
    private transient /* synthetic */ long R;
    public static final transient /* synthetic */ byte LOGIN_NOTLOGGEDIN = 0;
    private /* synthetic */ int x;
    private /* synthetic */ int E;
    public transient /* synthetic */ short loginAttempt;
    private final transient /* synthetic */ Set<String> G;
    private /* synthetic */ int K;
    private /* synthetic */ int a;
    private /* synthetic */ MapleCharacter V;
    private /* synthetic */ String c;

    public final /* synthetic */ boolean checkBirthDate(int a2) {
        MapleClient a3;
        return a3.z == a2;
    }

    public /* synthetic */ World getWorldServer() {
        MapleClient a2;
        return LoginServer.getInstance().getWorld(a2.x);
    }

    public final /* synthetic */ int getChannel() {
        MapleClient a2;
        return a2.q;
    }

    public /* synthetic */ int getBirthday() {
        MapleClient a2;
        return a2.z;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int getYesturdayDonateRank() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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
    public /* synthetic */ void gainDonatePoints(int a) {
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

    public final /* synthetic */ void setChannel(int a2) {
        if (a2 == -1) {
            // empty if block
        }
        a.q = a2;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getTotalDonate() {
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
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean updatePassword(String a) {
        block15: {
            block14: {
                var2_3 = DBConPool.getInstance().getDataSource().getConnection();
                var3_5 = var2_3.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("g>v/f+\u0012\u000fQ\r]\u001b\\\u001aANa+fNB\u000fA\u001dE\u0001@\n\u0012S\u0012Q\u001eNA\u000f^\u001a\u0012S\u0012 g\"~Ne&w<wN\\\u000f_\u000b\u0012S\u0012Q"));
                v0 = var3_5;
                v0.setString(1, LoginCrypto.hexSha1(a));
                v0.setString(2, a.U);
                var3_5.executeUpdate();
                var4_7 = true;
                if (var3_5 == null) break block14;
                var3_5.close();
            }
            if (var2_3 == null) break block15;
            var2_3.close();
        }
        return var4_7;
        {
            catch (Throwable var4_8) {
                if (var3_5 == null) ** GOTO lbl30
                try {
                    var3_5.close();
                    v1 = var4_8;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var4_8.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var4_8;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var3_6) {
                            block16: {
                                if (var2_3 != null) {
                                    try {
                                        var2_3.close();
                                        v2 = var3_6;
                                        break block16;
                                    }
                                    catch (Throwable var4_9) {
                                        var3_6.addSuppressed(var4_9);
                                    }
                                }
                                v2 = var3_6;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var2_4) {
                        return false;
                    }
                }
            }
        }
    }

    public /* synthetic */ void createdChar(int a2) {
        MapleClient a3;
        a3.w.add(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean gainpoint(String a, int a) {
        block15: {
            block14: {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                var4_6 = var3_4.prepareStatement(MapleGuildSummary.ALLATORIxDEMO(";b*s:wNS\rQ\u0001G\u0000F\u001d\u0012=w:\u0012>]\u0007\\\u001aAN\u000fNb\u0001[\u0000F\u001d\u0012E\u0012Q\u00129z+`+\u0012\u0007VN[\u0000\u0012Fa+~+q:\u0012\u000fQ\r]\u001b\\\u001a[\n\u0012(`!\u007fNQ\u0006S\u001cS\rF\u000b@\u001d\u0012\u0019Z\u000b@\u000b\u0012\u0000S\u0003WN\u000fN\rG"));
                v0 = var4_6;
                v0.setInt(1, a);
                v0.setString(2, a);
                var4_6.executeUpdate();
                var5_8 = true;
                if (var4_6 == null) break block14;
                var4_6.close();
            }
            if (var3_4 == null) break block15;
            var3_4.close();
        }
        return var5_8;
        {
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var5_9.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var5_9;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var4_7) {
                            block16: {
                                if (var3_4 != null) {
                                    try {
                                        var3_4.close();
                                        v2 = var4_7;
                                        break block16;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_7.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_7;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var3_5) {
                        return false;
                    }
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean UpdateAccount(String a, int a) {
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

    public /* synthetic */ void sendPacket(byte[] a2) {
        MapleClient a3;
        a3.getSession().writeAndFlush((Object)a2);
    }

    public final /* synthetic */ boolean isCs() {
        MapleClient a2;
        return a2.X;
    }

    public /* synthetic */ Calendar getTempBanCalendar() {
        MapleClient a2;
        return a2.v;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getMonthDonate() {
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
    public /* synthetic */ void loadAccountData(int a) {
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

    public static final /* synthetic */ String getLogMessage(MapleCharacter a2, String a3) {
        String string;
        MapleClient mapleClient;
        if (a2 == null) {
            mapleClient = null;
            string = a3;
        } else {
            mapleClient = a2.getClient();
            string = a3;
        }
        return MapleClient.getLogMessage(mapleClient, string, new Object[0]);
    }

    public /* synthetic */ String getClientMac() {
        MapleClient a2;
        return a2.i;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ byte unbanIP(String a2) {
        try {
            byte by;
            DruidPooledConnection druidPooledConnection;
            block19: {
                byte by2;
                block20: {
                    block18: {
                        ResultSet resultSet;
                        PreparedStatement preparedStatement;
                        block17: {
                            block16: {
                                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                                preparedStatement = druidPooledConnection.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fNS\rQ\u0001G\u0000F\u0007VNT\u001c]\u0003\u0012\rZ\u000f@\u000fQ\u001aW\u001cANE\u0006W\u001cWN\\\u000f_\u000b\u0012S\u0012Q"));
                                preparedStatement.setString(1, a2);
                                resultSet = preparedStatement.executeQuery();
                                if (resultSet.next()) break block16;
                                resultSet.close();
                                preparedStatement.close();
                                byte by3 = -1;
                                if (druidPooledConnection == null) return by3;
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
                                druidPooledConnection.close();
                                return by3;
                            }
                            ResultSet resultSet2 = resultSet;
                            byte by4 = resultSet2.getInt(1);
                            resultSet2.close();
                            preparedStatement.close();
                            preparedStatement = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("_5@5O$,\u0003i\u0003\u007f\u0019c\u001eE ,6^?APm\u0013o\u001fy\u001ex\u0003,'D5^5,\u0019hP1P3"));
                            preparedStatement.setInt(1, by4);
                            resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) break block17;
                            resultSet.close();
                            preparedStatement.close();
                            by4 = -1;
                            if (druidPooledConnection == null) return by4;
                            druidPooledConnection.close();
                            return by4;
                        }
                        ResultSet resultSet3 = resultSet;
                        String string = resultSet3.getString(MapleGuildSummary.ALLATORIxDEMO("\u001dW\u001dA\u0007]\u0000{>"));
                        resultSet3.close();
                        preparedStatement.close();
                        by = 0;
                        if (string == null) break block19;
                        PreparedStatement preparedStatement2 = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("H5@5X5,6^?APe\u0000n\u0011b\u0003,'D5^5,\u0019|P1P3"));
                        try {
                            PreparedStatement preparedStatement3 = preparedStatement2;
                            preparedStatement3.setString(1, string);
                            preparedStatement3.execute();
                            if (preparedStatement2 == null) break block18;
                            by2 = by;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable3;
                            if (preparedStatement2 != null) {
                                try {
                                    preparedStatement2.close();
                                    throwable3 = throwable;
                                    throw throwable3;
                                }
                                catch (Throwable throwable5) {
                                    throwable.addSuppressed(throwable5);
                                }
                            }
                            throwable3 = throwable;
                            throw throwable3;
                        }
                        preparedStatement2.close();
                        break block20;
                    }
                    by2 = by;
                }
                by = (byte)(by2 + 1);
            }
            byte by5 = by;
            if (druidPooledConnection == null) return by5;
            druidPooledConnection.close();
            return by5;
        }
        catch (SQLException sQLException) {
            System.err.println("Error while unbanning" + sQLException);
            return -2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean update2ndPassword(String a, String a) {
        block15: {
            block14: {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                var4_6 = var3_4.prepareStatement(MapleGuildSummary.ALLATORIxDEMO(";b*s:wNS\rQ\u0001G\u0000F\u001d\u0012=w:\u0012\\\\\nB\u000fA\u001dE\u0001@\n\u0012S\u0012Q\u00129z+`+\u0012\u0007VN[\u0000\u0012Fa+~+q:\u0012\u000fQ\r]\u001b\\\u001a[\n\u0012(`!\u007fNQ\u0006S\u001cS\rF\u000b@\u001d\u0012\u0019Z\u000b@\u000b\u0012\u0000S\u0003WN\u000fN\rG"));
                v0 = var4_6;
                v0.setString(1, LoginCrypto.hexSha1(a));
                v0.setString(2, a);
                var4_6.executeUpdate();
                var5_8 = true;
                if (var4_6 == null) break block14;
                var4_6.close();
            }
            if (var3_4 == null) break block15;
            var3_4.close();
        }
        return var5_8;
        {
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var5_9.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var5_9;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var4_7) {
                            block16: {
                                if (var3_4 != null) {
                                    try {
                                        var3_4.close();
                                        v2 = var4_7;
                                        break block16;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_7.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_7;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var3_5) {
                        return false;
                    }
                }
            }
        }
    }

    public /* synthetic */ long getLastLogin() {
        MapleClient a2;
        return a2.lastLoginTime;
    }

    public /* synthetic */ int getGmLevel() {
        MapleClient a2;
        return a2.Q;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void banMacs(String[] a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[WHILELOOP]], but top level block is 4[TRYBLOCK]
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
    public /* synthetic */ void setGM(int a) {
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var3_6 = var2_3.prepareStatement(MapleGuildSummary.ALLATORIxDEMO(";B\nS\u001aWNS\rQ\u0001G\u0000F\u001d\u0012\u001dW\u001a\u0012\t_N\u000fN\rNe\u0006W\u001cWN[\n\u0012S\u0012Q"));
            v0.setInt(1, a);
            var3_6.setInt(2, a.getAccID());
            v0.execute();
            var3_6.close();
            ** if (var2_3 == null) goto lbl-1000
        }
        catch (Throwable var3_7) {
            if (var2_3 == null) ** GOTO lbl24
            try {
                var2_3.close();
                v1 = var3_7;
                ** GOTO lbl25
            }
            catch (Throwable a) {
                try {
                    var3_7.addSuppressed(a);
lbl24:
                    // 2 sources

                    v1 = var3_7;
lbl25:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var2_4) {
                    FilePrinter.printError(MapleCoreAura.ALLATORIxDEMO("=m\u0000`\u0015O\u0018m\u0002m\u0013x\u0015~^x\bx"), var2_4, MapleGuildSummary.ALLATORIxDEMO("\u001dW\u001au#"));
                    System.err.println(MapleCoreAura.ALLATORIxDEMO("+\u007f\u0015x7A-\u712d\u6ca5\u902f\u63d5\u8ccb\u65e9\u5ea7"));
                    return;
                }
                catch (Exception var2_5) {
                    FilePrinter.printError(MapleGuildSummary.ALLATORIxDEMO("\u007f\u000fB\u0002W-Z\u000f@\u000fQ\u001aW\u001c\u001c\u001aJ\u001a"), var2_5, MapleCoreAura.ALLATORIxDEMO("\u007f\u0015x7A"));
                    System.err.println("[setGM]" + var2_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_3.close();
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
    public /* synthetic */ List<String> loadCharacterNamesByCharId(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public final /* synthetic */ boolean login_Auth(int a2) {
        MapleClient a3;
        return a3.w.contains(a2);
    }

    public final /* synthetic */ void setGmLevel(int a2) {
        a.Q = a2;
    }

    public final /* synthetic */ void setSecondPassword(String a2) {
        a.f = a2;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ int deleteCharacter(int a, boolean a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK], 2[TRYBLOCK]], but top level block is 19[CATCHBLOCK]
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

    public static /* synthetic */ boolean checkHash(String a2, String a32, String a4) {
        try {
            a32 = MessageDigest.getInstance((String)a32);
            ((MessageDigest)a32).update(a4.getBytes(MapleGuildSummary.ALLATORIxDEMO(";f(\u001fV")), 0, a4.length());
            return HexTool.toString(((MessageDigest)a32).digest()).replace(" ", "").toLowerCase().equals(a2);
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException a32) {
            throw new RuntimeException(MapleCoreAura.ALLATORIxDEMO("5b\u0013c\u0014e\u001ekPx\u0018iP\u007f\u0004~\u0019b\u0017,\u0016m\u0019`\u0015h"), a32);
        }
    }

    public final /* synthetic */ Lock getNPCLock() {
        MapleClient a2;
        return a2.D;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean gaingash(String a, String a) {
        block15: {
            block14: {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                var4_6 = var3_4.prepareStatement(MapleGuildSummary.ALLATORIxDEMO(";b*s:wNS\rQ\u0001G\u0000F\u001d\u0012=w:\u0012/Q\u000fA\u0006\u0012S\u0012/Q\u000fA\u0006\u0012E\u0012Q\u00129z+`+\u0012\u0007VN[\u0000\u0012Fa+~+q:\u0012\u000fQ\r]\u001b\\\u001a[\n\u0012(`!\u007fNQ\u0006S\u001cS\rF\u000b@\u001d\u0012\u0019Z\u000b@\u000b\u0012\u0000S\u0003WN\u000fN\rG"));
                v0 = var4_6;
                v0.setString(1, a);
                v0.setString(2, a);
                var4_6.executeUpdate();
                var5_8 = true;
                if (var4_6 == null) break block14;
                var4_6.close();
            }
            if (var3_4 == null) break block15;
            var3_4.close();
        }
        return var5_8;
        {
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var5_9.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var5_9;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var4_7) {
                            block16: {
                                if (var3_4 != null) {
                                    try {
                                        var3_4.close();
                                        v2 = var4_7;
                                        break block16;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_7.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_7;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var3_5) {
                        return false;
                    }
                }
            }
        }
    }

    public /* synthetic */ void setReceiving(boolean a2) {
        a.r = a2;
    }

    public /* synthetic */ boolean getCanTalk() {
        MapleClient a2;
        return a2.getTalkBanCalendar().getTimeInMillis() == 0L;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void loadAccountidByPlayerid(int a) {
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

    public /* synthetic */ void updateMacs(String a2) {
        MapleClient a3;
        MapleClient mapleClient = a3;
        mapleClient.updateAllMac(a2);
        mapleClient.updateClientMac(a2);
    }

    public final /* synthetic */ byte getbindac() {
        MapleClient a2;
        return a2.P;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ String getAccNameByChrName(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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

    public /* synthetic */ void setClientKey(String a2) {
        a.l = a2;
    }

    public /* synthetic */ void setMacs(String a22) {
        MapleClient a3;
        if (a3.G != null) {
            try {
                if (!MapleCoreAura.ALLATORIxDEMO("<@!@<]<@!@<]<@!@<").equals(a22) && !a22.isEmpty()) {
                    a3.G.addAll(Arrays.asList(a22.split(MapleGuildSummary.ALLATORIxDEMO("\u001eN"))));
                    return;
                }
            }
            catch (Exception a22) {
                // empty catch block
            }
        }
    }

    public final /* synthetic */ void unLockDisconnect() {
        MapleClient a2;
        MapleClient mapleClient = a2;
        mapleClient.disconnect();
        mapleClient.getSession().close();
        MapleClient mapleClient2 = a2;
        LoginServer.removeClient(mapleClient2);
        mapleClient2.j = true;
        Object object = mapleClient2;
        object = new Thread((MapleClient)object){
            public final /* synthetic */ MapleClient d;

            @Override
            public /* synthetic */ void run() {
                1 v0;
                1 a2;
                try {
                    1.sleep(3000L);
                    v0 = a2;
                }
                catch (InterruptedException interruptedException) {
                    v0 = a2;
                }
                v0.d.getSession().close();
                if (ServerConfig.LOG_DC) {
                    FileoutputUtil.logToFile(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0018\t\u0013\u0015[\"\u0015\u0012\u0015I0%Z\u0012\f\u0012"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u5e33\u865f[" + a2.MapleClient.this.U + "] \u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                }
            }
            {
                1 a3;
                a3.d = mapleClient;
            }
        };
        try {
            ((Thread)object).start();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean isBannedIP(String a) {
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
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean hasBannedMac() {
        DruidPooledConnection druidPooledConnection;
        DruidPooledConnection druidPooledConnection2;
        boolean bl;
        block27: {
            int n2;
            StringBuilder stringBuilder;
            MapleClient a2;
            if (a2.G.isEmpty()) {
                return false;
            }
            bl = false;
            try {
                druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    stringBuilder = new StringBuilder(MapleCoreAura.ALLATORIxDEMO("_5@5O$,3C%B$$Z%PJ\"C=,\u001dm\u0013n\u0011b\u0003,'D5^5,\u001dm\u0013,9BP$"));
                    int n3 = n2 = 0;
                    while (n3 < a2.G.size()) {
                        stringBuilder.append(MapleGuildSummary.ALLATORIxDEMO("Q"));
                        if (n2 != a2.G.size() - 1) {
                            stringBuilder.append(MapleCoreAura.ALLATORIxDEMO("\\,"));
                        }
                        n3 = ++n2;
                    }
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (druidPooledConnection2 != null) {
                        try {
                            druidPooledConnection2.close();
                            throwable2 = throwable;
                            throw throwable2;
                        }
                        catch (Throwable throwable7) {
                            throwable.addSuppressed(throwable7);
                        }
                    }
                    throwable2 = throwable;
                    throw throwable2;
                }
            }
            catch (SQLException sQLException) {
                System.err.println("Error checking mac bans" + sQLException);
                return bl;
            }
            {
                PreparedStatement preparedStatement;
                PreparedStatement preparedStatement2;
                block26: {
                    stringBuilder.append(MapleGuildSummary.ALLATORIxDEMO("G"));
                    preparedStatement2 = druidPooledConnection2.prepareStatement(stringBuilder.toString());
                    try {
                        block25: {
                            Object object;
                            n2 = 0;
                            Object object2 = object = a2.G.iterator();
                            while (object2.hasNext()) {
                                String string = object.next();
                                object2 = object;
                                preparedStatement2.setString(++n2, string);
                            }
                            object = preparedStatement2.executeQuery();
                            try {
                                object.next();
                                if (object.getInt(1) > 0) {
                                    bl = true;
                                }
                                if (object == null) break block25;
                                preparedStatement = preparedStatement2;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable3;
                                if (object != null) {
                                    try {
                                        object.close();
                                        throwable3 = throwable;
                                        throw throwable3;
                                    }
                                    catch (Throwable throwable32) {
                                        throwable.addSuppressed(throwable32);
                                    }
                                }
                                throwable3 = throwable;
                                throw throwable3;
                            }
                            object.close();
                            break block26;
                        }
                        preparedStatement = preparedStatement2;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable4;
                        if (preparedStatement2 != null) {
                            try {
                                preparedStatement2.close();
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
                if (preparedStatement != null) {
                    druidPooledConnection = druidPooledConnection2;
                    preparedStatement2.close();
                    break block27;
                }
                druidPooledConnection = druidPooledConnection2;
            }
        }
        if (druidPooledConnection == null) return bl;
        druidPooledConnection2.close();
        return bl;
    }

    public final /* synthetic */ MapleAESOFB getReceiveCrypto() {
        MapleClient a2;
        return a2.W;
    }

    public final /* synthetic */ String getSessionIPAddress() {
        MapleClient a2;
        if (!a2.ALLATORIxDEMO.isEmpty()) {
            return "/" + a2.ALLATORIxDEMO;
        }
        if (a2.p != null && a2.p.remoteAddress() != null) {
            return a2.p.remoteAddress().toString().split(MapleGuildSummary.ALLATORIxDEMO("T"))[0];
        }
        return a2.getLastIPAddress();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ int ALLATORIxDEMO(int a) {
        var2_4 = 0;
        var3_5 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var4_7 = var3_5.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fNQ\u0001G\u0000FF\u0018G\u0012(`!\u007fNQ\u0006S\u001cS\rF\u000b@\u001d\u00129z+`+\u0012\u000fQ\r]\u001b\\\u001a[\n\u0012S\u0012Q\u0012/|*\u0012\u0019]\u001c^\n\u0012S\u0012Q"));
            v0.setInt(1, a.u);
            v0.setInt(2, a);
            a = v0.executeQuery();
            if (a.next()) {
                var2_4 = a.getInt(1);
            }
            a.close();
            var4_7.close();
            ** if (var3_5 == null) goto lbl-1000
        }
        catch (Throwable var4_8) {
            if (var3_5 == null) ** GOTO lbl26
            try {
                var3_5.close();
                v1 = var4_8;
                ** GOTO lbl27
            }
            catch (Throwable a) {
                try {
                    var4_8.addSuppressed(a);
lbl26:
                    // 2 sources

                    v1 = var4_8;
lbl27:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var3_6) {
                    System.err.println(MapleCoreAura.ALLATORIxDEMO("i\u0002~\u001f~P`\u001fm\u0014e\u001ekPo\u0018m\u0002m\u0013x\u0015~\u0003,\u0019b\u0004i\u0002b\u0011`"));
                    var3_6.printStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var3_5.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return var2_4;
    }

    public final /* synthetic */ void disconnect() {
        MapleClient a2;
        a2.disconnect(false, true);
    }

    public final /* synthetic */ String getAccountName() {
        MapleClient a2;
        return a2.U;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ List<Integer> loadCharacterIDsByAccId(int a222222222) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("_5@5O$,\u0019hPJ\"C=,\u0013d\u0011~\u0011o\u0004i\u0002\u007fP[8I\"IPm\u0013o\u001fy\u001ex\u0019hP1P3"));
        preparedStatement.setInt(1, a222222222);
        ResultSet a222222222 = preparedStatement.executeQuery();
        while (a222222222.next()) {
            linkedList.add(a222222222.getInt(MapleGuildSummary.ALLATORIxDEMO("[\n")));
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
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
                            catch (Throwable a222222222) {
                                throwable.addSuppressed(a222222222);
                            }
                        }
                        throwable2 = throwable;
                    }
                    throw throwable2;
                }
                catch (SQLException sQLException) {
                    System.err.println("error loading characters cids by id " + sQLException);
                }
            }
        }
        return linkedList;
    }

    public /* synthetic */ boolean canMakeCharacter(int a2) {
        MapleClient a3;
        return a3.ALLATORIxDEMO(a2) < a3.getCharacterSlots();
    }

    public /* synthetic */ boolean isBanned() {
        MapleClient a2;
        return !a2.isGM() && a2.J > 0;
    }

    public /* synthetic */ int getVipFromDonate() {
        MapleClient a2;
        long l2 = a2.getTotalDonate();
        int n2 = 0;
        if (GameSetConstants.VIP_DONATE_INTERVAL.length != 0) {
            int n3;
            int n4 = n3 = 0;
            while (n4 < GameSetConstants.VIP_DONATE_INTERVAL.length) {
                if ((long)GameSetConstants.VIP_DONATE_INTERVAL[n3] <= l2) {
                    ++n2;
                }
                n4 = ++n3;
            }
        } else {
            n2 = (int)a2.getTotalDonate() / GameSetConstants.VIP_DONATEINTERVAL;
        }
        if (n2 >= GameSetConstants.VIP_LEVELMAX) {
            n2 = GameSetConstants.VIP_LEVELMAX;
        }
        if (GameSetConstants.SERVER_NAME.equals(MapleGuildSummary.ALLATORIxDEMO("\u6961\u821c\u5e49\u609d"))) {
            if (l2 >= 50000L) {
                n2 = 10;
                return 10;
            }
            if (l2 >= 40000L) {
                n2 = 9;
                return 9;
            }
            if (l2 >= 30000L) {
                n2 = 8;
                return 8;
            }
            if (l2 >= 20000L) {
                n2 = 7;
                return 7;
            }
            if (l2 >= 10000L) {
                n2 = 6;
                return 6;
            }
            if (l2 >= 5000L) {
                n2 = 5;
                return 5;
            }
            if (l2 >= 4000L) {
                n2 = 4;
                return 4;
            }
            if (l2 >= 3000L) {
                n2 = 3;
                return 3;
            }
            if (l2 >= 2000L) {
                n2 = 2;
                return 2;
            }
            if (l2 >= 1000L) {
                n2 = 1;
            }
        }
        return n2;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ byte getLoginState() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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
    public final /* synthetic */ void updateGender() {
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

    public /* synthetic */ void setcs(int a2) {
        F = a2;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void update2ndPassword() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public /* synthetic */ void setLoginMacs(String a2) {
        a.c = a2;
    }

    public final /* synthetic */ ChannelServer getChannelServer() {
        MapleClient a2;
        MapleClient mapleClient = a2;
        return ChannelServer.getInstance(mapleClient.x, mapleClient.q);
    }

    public /* synthetic */ byte getGreason() {
        MapleClient a2;
        return a2.t;
    }

    public final /* synthetic */ String getSecondPassword() {
        MapleClient a2;
        return a2.f;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int getTodayDonateRank() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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

    public final /* synthetic */ void removeScriptEngine(String a2) {
        MapleClient a3;
        a3.m.remove(a2);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ List<CharNameAndId> ALLATORIxDEMO(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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
    public final /* synthetic */ String getLastIPAddress() {
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

    public /* synthetic */ void setPinging(boolean a2) {
        a.g = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ byte unbanIPMacs(String a) {
        block27: {
            try {
                block29: {
                    block30: {
                        block26: {
                            block25: {
                                block24: {
                                    var1_1 = DBConPool.getInstance().getDataSource().getConnection();
                                    var2_3 = var1_1.prepareStatement(MapleCoreAura.ALLATORIxDEMO("_5@5O$,\u0011o\u0013c\u0005b\u0004e\u0014,\u0016~\u001faPo\u0018m\u0002m\u0013x\u0015~\u0003,\u0007d\u0015~\u0015,\u001em\u001diP1P3"));
                                    var2_3.setString(1, a);
                                    var3_5 = var2_3.executeQuery();
                                    if (var3_5.next()) break block24;
                                    var3_5.close();
                                    var2_3.close();
                                    var4_7 = -1;
                                    if (var1_1 == null) return var4_7;
                                    {
                                        catch (Throwable var2_4) {
                                            if (var1_1 != null) {
                                                try {
                                                    var1_1.close();
                                                    v0 = var2_4;
                                                    throw v0;
                                                }
                                                catch (Throwable var3_6) {
                                                    var2_4.addSuppressed(var3_6);
                                                }
                                            }
                                            v0 = var2_4;
                                            throw v0;
                                        }
                                    }
                                    var1_1.close();
                                    return var4_7;
                                }
                                v1 = var3_5;
                                var4_8 = v1.getInt(1);
                                v1.close();
                                var2_3.close();
                                var2_3 = var1_1.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fNA\u000bA\u001d[\u0001\\'bB\u0012\u0003S\rANt<}#\u0012\u000fQ\r]\u001b\\\u001aANe&w<wN[\n\u0012S\u0012Q"));
                                var2_3.setInt(1, var4_8);
                                var3_5 = var2_3.executeQuery();
                                if (var3_5.next()) break block25;
                                var3_5.close();
                                var2_3.close();
                                var4_8 = -1;
                                if (var1_1 == null) return var4_8;
                                var1_1.close();
                                return var4_8;
                            }
                            v2 = var3_5;
                            var4_9 = v2.getString(MapleCoreAura.ALLATORIxDEMO("\u007f\u0015\u007f\u0003e\u001fb9\\"));
                            var5_11 = v2.getString(MapleGuildSummary.ALLATORIxDEMO("_\u000fQ\u001d"));
                            v2.close();
                            var2_3.close();
                            var6_13 = 0;
                            if (var4_9 == null) break block29;
                            var7_14 = var1_1.prepareStatement(MapleCoreAura.ALLATORIxDEMO("H5@5X5,6^?APe\u0000n\u0011b\u0003,'D5^5,\u0019|P1P3"));
                            try {
                                var7_14.setString(1, var4_9);
                                var7_14.execute();
                                if (var7_14 == null) break block26;
                                v3 = var6_13;
                            }
                            catch (Throwable var8_16) {
                                if (var7_14 != null) {
                                    try {
                                        var7_14.close();
                                        v4 = var8_16;
                                        throw v4;
                                    }
                                    catch (Throwable var9_18) {
                                        var8_16.addSuppressed(var9_18);
                                    }
                                }
                                v4 = var8_16;
                                throw v4;
                            }
                            var7_14.close();
                            break block30;
                        }
                        v3 = var6_13;
                    }
                    var6_13 = (byte)(v3 + 1);
                }
                if (var5_11 == null) break block27;
                var8_17 = var7_14 = var5_11.split(MapleGuildSummary.ALLATORIxDEMO("\u001eN"));
                var9_19 = var8_17.length;
                v5 = var4_10 = 0;
            }
            catch (SQLException var1_2) {
                System.err.println("Error while unbanning" + var1_2);
                return -2;
            }
            while (v5 < var9_19) {
                var5_11 = var8_17[var4_10];
                if (!var5_11.equals("")) {
                    var10_20 = var1_1.prepareStatement(MapleCoreAura.ALLATORIxDEMO("H5@5X5,6^?APa\u0011o\u0012m\u001e\u007fP[8I\"IPa\u0011oP1P3"));
                    try {
                        v6 = var10_20;
                        v6.setString(1, var5_11);
                        v6.execute();
                        ** if (var10_20 == null) goto lbl-1000
                    }
                    catch (Throwable var11_21) {
                        if (var10_20 != null) {
                            try {
                                var10_20.close();
                                v7 = var11_21;
                                throw v7;
                            }
                            catch (Throwable var5_12) {
                                var11_21.addSuppressed(var5_12);
                            }
                        }
                        v7 = var11_21;
                        throw v7;
                    }
lbl-1000:
                    // 1 sources

                    {
                        var10_20.close();
                    }
lbl-1000:
                    // 2 sources

                    {
                    }
                }
                v5 = ++var4_10;
            }
            var6_13 = (byte)(var6_13 + 1);
        }
        var7_15 = var6_13;
        if (var1_1 == null) return var7_15;
        var1_1.close();
        return var7_15;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void sendCGMLog(MapleClient a, String a) {
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

    public final /* synthetic */ void setIdleTask(ScheduledFuture<?> a2) {
        a.A = a2;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ String getIPstatus(String a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public /* synthetic */ boolean isCanloginpw() {
        MapleClient a2;
        return a2.n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void removalTask(boolean a) {
        try {
            v0 = a;
            v0.V.cancelAllBuffs_();
            v0.V.cancelAllDebuffs();
            if (v0.V.getMarriageId() > 0) {
                v1 = a;
                var2_2 = v1.V.getQuestNAdd(MapleQuest.getInstance(160001));
                var3_4 = v1.V.getQuestNAdd(MapleQuest.getInstance(160002));
                if (var2_2.getCustomData() != null && (var2_2.getCustomData().equals(MapleCoreAura.ALLATORIxDEMO("BS")) || var2_2.getCustomData().equals("2"))) {
                    if (var3_4.getCustomData() != null) {
                        var3_4.setCustomData(MapleGuildSummary.ALLATORIxDEMO("^"));
                    }
                    var2_2.setCustomData("3");
                }
            }
            v2 = a;
            v2.V.changeRemoval(true);
            if (v2.V.getEventInstance() != null) {
                v3 = a;
                a.V.getEventInstance().playerDisconnected(v3.V, v3.V.getId());
            }
            if (a.V.getMap() != null) {
                switch (a.V.getMapId()) {
                    case 220080001: 
                    case 541010100: 
                    case 541020800: 
                    case 551030200: {
                        a.V.getMap().addDisconnected(a.V.getId());
                        break;
                    }
                }
                a.V.getMap().removePlayer(a.V);
            }
            var2_2 = a;
            // MONITORENTER : var2_2
            var3_4 = a.V.getPlayerShop();
            if (var3_4 == null) ** GOTO lbl37
            v4 = var3_4;
            v4.removeVisitor(a.V);
            if (!v4.isOwner(a.V)) ** GOTO lbl37
            if (var3_4.getShopType() == 1 && var3_4.isAvailable() && !a) {
                v5 = var2_2;
                var3_4.setOpen(true);
            } else {
                var3_4.closeShop(true, a == false, true);
lbl37:
                // 3 sources

                v5 = var2_2;
            }
            // MONITOREXIT : v5
            v6 = a;
        }
        catch (Throwable var2_3) {
            FilePrinter.printError("AccountStuck.txt", var2_3);
            return;
        }
        v6.V.setMessenger(null);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void H() {
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
    public /* synthetic */ long getTodayDonate() {
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
    public /* synthetic */ void loadVip(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 0[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    public final /* synthetic */ Set<String> getIps() {
        MapleClient a2;
        return Collections.unmodifiableSet(a2.b);
    }

    public /* synthetic */ void removeClickedNPC() {
        a.lastNpcClick = 0L;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void updateLoginState(int a, String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    public final /* synthetic */ void DebugMessage(StringBuilder a2) {
        MapleClient a3;
        MapleClient mapleClient = a3;
        StringBuilder stringBuilder = a2;
        a2.append(mapleClient.getSession().remoteAddress());
        stringBuilder.append(MapleCoreAura.ALLATORIxDEMO("PO\u001fb\u001ei\u0013x\u0015hJ,"));
        a2.append(a3.getSession().isActive());
        a2.append(MapleGuildSummary.ALLATORIxDEMO("Nq\u0002[\u000b\\\u001ay\u000bK=W\u001a\bN"));
        stringBuilder.append(mapleClient.getSession().attr(CLIENT_KEY).get() != null);
        a2.append(MapleCoreAura.ALLATORIxDEMO(",\u001cc\u0017k\u0015h\u0019bJ,"));
        a2.append(a3.isLoggedIn());
        a2.append(MapleGuildSummary.ALLATORIxDEMO("NZ\u000fANQ\u0006S\u001c\bN"));
        a2.append(a3.getPlayer() != null);
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void updateSecondPassword() {
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
        CLIENT_KEY = AttributeKey.valueOf((String)MapleGuildSummary.ALLATORIxDEMO("q\u0002[\u000b\\\u001a"));
        L = new ReentrantLock(true);
        F = 0;
    }

    public /* synthetic */ boolean isInGame() {
        MapleClient a2;
        return a2.d;
    }

    public /* synthetic */ String getDecodeProxyIP() {
        MapleClient a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setCanloginpw(boolean a2) {
        a.n = a2;
    }

    public /* synthetic */ void setLastFeedBackTime(long a2) {
        a.k = a2;
    }

    public /* synthetic */ List<String> loadCharacterNames(int a2) {
        MapleClient a3;
        LinkedList<String> linkedList = new LinkedList<String>();
        Iterator<CharNameAndId> iterator = a2 = a3.ALLATORIxDEMO(a2).iterator();
        while (iterator.hasNext()) {
            CharNameAndId charNameAndId = a2.next();
            iterator = a2;
            linkedList.add(charNameAndId.name);
        }
        return linkedList;
    }

    private /* synthetic */ Calendar H(ResultSet a2) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        if (a2.getLong(MapleGuildSummary.ALLATORIxDEMO("\u001aW\u0003B\fS\u0000")) == 0L) {
            Calendar calendar2 = calendar;
            calendar2.setTimeInMillis(0L);
            return calendar2;
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar.setTimeInMillis(a2.getTimestamp(MapleCoreAura.ALLATORIxDEMO("x\u0015a\u0000n\u0011b")).getTime());
        if (calendar3.getTimeInMillis() < calendar.getTimeInMillis()) {
            return calendar;
        }
        Calendar calendar4 = calendar;
        calendar4.setTimeInMillis(0L);
        return calendar4;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ boolean AccNameExist(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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
    public /* synthetic */ void setVip(int a) {
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var3_6 = var2_3.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("g\u001eV\u000fF\u000b\u0012\u000fQ\r]\u001b\\\u001aANA\u000bFND\u0007BN\u000fN\rNe\u0006W\u001cWN[\n\u0012S\u0012Q"));
            v0.setInt(1, a);
            var3_6.setInt(2, a.getAccID());
            v0.execute();
            var3_6.close();
            ** if (var2_3 == null) goto lbl-1000
        }
        catch (Throwable var3_7) {
            if (var2_3 == null) ** GOTO lbl24
            try {
                var2_3.close();
                v1 = var3_7;
                ** GOTO lbl25
            }
            catch (Throwable a) {
                try {
                    var3_7.addSuppressed(a);
lbl24:
                    // 2 sources

                    v1 = var3_7;
lbl25:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var2_4) {
                    FilePrinter.printError(MapleCoreAura.ALLATORIxDEMO("=m\u0000`\u0015O\u0018m\u0002m\u0013x\u0015~^x\bx"), var2_4, MapleGuildSummary.ALLATORIxDEMO("a\u000bF8[\u001e"));
                    System.err.println(MapleCoreAura.ALLATORIxDEMO("+z\u0019|-\u712d\u6ca5\u902f\u63d5\u8ccb\u65e9\u5ea7"));
                    return;
                }
                catch (Exception var2_5) {
                    FilePrinter.printError(MapleGuildSummary.ALLATORIxDEMO("\u007f\u000fB\u0002W-Z\u000f@\u000fQ\u001aW\u001c\u001c\u001aJ\u001a"), var2_5, MapleCoreAura.ALLATORIxDEMO("#i\u0004Z\u0019|"));
                    System.err.println("[setvip]" + var2_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_3.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public /* synthetic */ MapleCharacter getPlayer() {
        MapleClient a2;
        return a2.V;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean updatename(String a, String a) {
        block15: {
            block14: {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                var4_6 = var3_4.prepareStatement(MapleCoreAura.ALLATORIxDEMO("Y H1X5,\u0013d\u0011~\u0011o\u0004i\u0002\u007fP_5XPb\u0011a\u0015,M,O,'D5^5,\u001em\u001diP1P3"));
                v0 = var4_6;
                v0.setString(1, a);
                v0.setString(2, a);
                var4_6.executeUpdate();
                var5_8 = true;
                if (var4_6 == null) break block14;
                var4_6.close();
            }
            if (var3_4 == null) break block15;
            var3_4.close();
        }
        return var5_8;
        {
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var5_9.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var5_9;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var4_7) {
                            block16: {
                                if (var3_4 != null) {
                                    try {
                                        var3_4.close();
                                        v2 = var4_7;
                                        break block16;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_7.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_7;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var3_5) {
                        return false;
                    }
                }
            }
        }
    }

    public static final /* synthetic */ String getLogMessage(MapleCharacter a2, String a3, Object ... a4) {
        String string;
        MapleClient mapleClient;
        if (a2 == null) {
            mapleClient = null;
            string = a3;
        } else {
            mapleClient = a2.getClient();
            string = a3;
        }
        return MapleClient.getLogMessage(mapleClient, string, a4);
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ List<String> loadCharacterNamesByAccId(int a222222222) {
        LinkedList<String> linkedList = new LinkedList<String>();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("_5@5O$,\u001em\u001diPJ\"C=,\u0013d\u0011~\u0011o\u0004i\u0002\u007fP[8I\"IPm\u0013o\u001fy\u001ex\u0019hP1P3"));
        preparedStatement.setInt(1, a222222222);
        ResultSet a222222222 = preparedStatement.executeQuery();
        while (a222222222.next()) {
            linkedList.add(a222222222.getString(MapleGuildSummary.ALLATORIxDEMO("\\\u000f_\u000b")));
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
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
                            catch (Throwable a222222222) {
                                throwable.addSuppressed(a222222222);
                            }
                        }
                        throwable2 = throwable;
                    }
                    throw throwable2;
                }
                catch (SQLException sQLException) {
                    System.err.println("error loading characters names by id " + sQLException);
                }
            }
        }
        return linkedList;
    }

    public /* synthetic */ void setIps(String a22) {
        MapleClient a3;
        if (a3.b != null) {
            try {
                if (!MapleGuildSummary.ALLATORIxDEMO("\u001d^\u001c^\u001c^\u001c^").equals(a22) && !a22.isEmpty()) {
                    a3.b.addAll(Arrays.asList(a22.split(MapleCoreAura.ALLATORIxDEMO("\\,"))));
                    return;
                }
            }
            catch (Exception a22) {
                // empty catch block
            }
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getYesturdayDonate() {
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
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO() throws SQLException {
        DruidPooledConnection druidPooledConnection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        PreparedStatement preparedStatement2;
        DruidPooledConnection druidPooledConnection2;
        block26: {
            MapleClient a2;
            if (!a2.G.isEmpty()) return;
            druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                preparedStatement2 = druidPooledConnection2.prepareStatement(MapleCoreAura.ALLATORIxDEMO("#I<I3XPa\u0011o\u0003,6^?APm\u0013o\u001fy\u001ex\u0003,'D5^5,\u0019hP1P3"));
                try {
                    PreparedStatement preparedStatement3 = preparedStatement2;
                    preparedStatement3.setInt(1, a2.u);
                    resultSet = preparedStatement3.executeQuery();
                    try {
                        if (resultSet.next()) {
                            if (resultSet.getString(MapleGuildSummary.ALLATORIxDEMO("_\u000fQ\u001d")) != null) {
                                int n2;
                                String[] arrstring;
                                String[] arrstring2 = arrstring = resultSet.getString(MapleCoreAura.ALLATORIxDEMO("\u001dm\u0013\u007f")).split(MapleGuildSummary.ALLATORIxDEMO("\u001eN"));
                                int n3 = arrstring2.length;
                                int n4 = n2 = 0;
                                while (n4 < n3) {
                                    String string = arrstring2[n2];
                                    if (!string.equals("")) {
                                        a2.G.add(string);
                                    }
                                    n4 = ++n2;
                                }
                            }
                            break block26;
                        }
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        if (resultSet != null) {
                            try {
                                resultSet.close();
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
                    if (preparedStatement2 != null) {
                        try {
                            preparedStatement2.close();
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
            catch (Throwable throwable) {
                Throwable throwable6;
                if (druidPooledConnection2 != null) {
                    try {
                        druidPooledConnection2.close();
                        throwable6 = throwable;
                        throw throwable6;
                    }
                    catch (Throwable throwable7) {
                        throwable.addSuppressed(throwable7);
                    }
                }
                throwable6 = throwable;
                throw throwable6;
            }
            {
                resultSet.close();
                preparedStatement2.close();
                throw new RuntimeException(MapleCoreAura.ALLATORIxDEMO("B\u001f,\u0006m\u001ce\u0014,\u0011o\u0013c\u0005b\u0004,\u0011\u007f\u0003c\u0013e\u0011x\u0015hP{\u0019x\u0018,\u0004d\u0019\u007fPo\u001ce\u0015b\u0004\""));
            }
        }
        if (resultSet != null) {
            preparedStatement = preparedStatement2;
            resultSet.close();
        } else {
            preparedStatement = preparedStatement2;
        }
        if (preparedStatement != null) {
            druidPooledConnection = druidPooledConnection2;
            preparedStatement2.close();
        } else {
            druidPooledConnection = druidPooledConnection2;
        }
        if (druidPooledConnection == null) return;
        druidPooledConnection2.close();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void HackChrName() {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var1_1.prepareStatement(MapleGuildSummary.ALLATORIxDEMO(";b*s:wNQ\u0006S\u001cS\rF\u000b@\u001d\u0012=w:\u0012\u0000S\u0003WN\u000fN\rN"));
            var2_3.setString(1, MapleCoreAura.ALLATORIxDEMO("\u0018m\u0013g\u0015h"));
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
                    // empty catch block
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

    public final /* synthetic */ void setCs(boolean a2) {
        a.X = a2;
    }

    public /* synthetic */ boolean getCloseSession() {
        MapleClient a2;
        return a2.j;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void updateLoginKey(String a) {
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var3_5 = var2_3.prepareStatement(MapleCoreAura.ALLATORIxDEMO("Y H1X5,\u0011o\u0013c\u0005b\u0004\u007fP_5XP`\u001fk\u0019b\u001bi\t,M,O,'D5^5,\u0019hP1P3"));
            v0.setString(1, a);
            v0.setInt(2, a.getAccID());
            v0.executeUpdate();
            ** if (var2_3 == null) goto lbl-1000
        }
        catch (Throwable var3_6) {
            if (var2_3 == null) ** GOTO lbl23
            try {
                var2_3.close();
                v1 = var3_6;
                ** GOTO lbl24
            }
            catch (Throwable a) {
                try {
                    var3_6.addSuppressed(a);
lbl23:
                    // 2 sources

                    v1 = var3_6;
lbl24:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var2_4) {
                    FileoutputUtil.outError(MapleGuildSummary.ALLATORIxDEMO("^\u0001U\u001d\u001d\u8ca9\u65ab\u5ec5\u7542\u5e56\u001c\u001aJ\u001a"), var2_4);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_3.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public final /* synthetic */ boolean CheckIPAddress() {
        MapleClient a2;
        boolean bl = false;
        String string = a2.getLastIPAddress();
        if (!string.isEmpty()) {
            bl = a2.getSessionIPAddress().equals(string.split(MapleGuildSummary.ALLATORIxDEMO("T"))[0]);
        }
        return bl;
    }

    public /* synthetic */ String getBanReason() {
        MapleClient a2;
        return a2.I;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean SetMonitored(boolean a) {
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
    public /* synthetic */ boolean getMonitored(String a) {
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

    public /* synthetic */ void updateIPs(String a222) {
        String string;
        MapleClient a3;
        try {
            a3.b.addAll(Arrays.asList(((String)a222).split(MapleGuildSummary.ALLATORIxDEMO("\u001eN"))));
        }
        catch (Exception a222) {
            // empty catch block
        }
        CharSequence a222 = new StringBuilder();
        Iterator<String> iterator = a3.b.iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            if (!MapleCoreAura.ALLATORIxDEMO("_<^<^<^<").equals(string)) {
                ((StringBuilder)a222).append(string);
            }
            if (!iterator.hasNext() || MapleGuildSummary.ALLATORIxDEMO("\u001d^\u001c^\u001c^\u001c^").equals(string)) continue;
            ((StringBuilder)a222).append(MapleCoreAura.ALLATORIxDEMO("\\,"));
        }
        try {
            String string2;
            block18: {
                string = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    block17: {
                        PreparedStatement preparedStatement = string.prepareStatement(MapleGuildSummary.ALLATORIxDEMO(";b*s:wNS\rQ\u0001G\u0000F\u001d\u0012=w:\u0012=W\u001dA\u0007]\u0000{>aN\u000fN\rNe&w<wN[\n\u0012S\u0012Q"));
                        try {
                            PreparedStatement preparedStatement2 = preparedStatement;
                            preparedStatement2.setString(1, ((StringBuilder)a222).toString());
                            preparedStatement2.setInt(2, a3.u);
                            preparedStatement.executeUpdate();
                            if (preparedStatement == null) break block17;
                            string2 = string;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            block19: {
                                if (preparedStatement != null) {
                                    try {
                                        preparedStatement.close();
                                        throwable2 = throwable;
                                        break block19;
                                    }
                                    catch (Throwable a222) {
                                        throwable.addSuppressed(a222);
                                    }
                                }
                                throwable2 = throwable;
                            }
                            throw throwable2;
                        }
                        preparedStatement.close();
                        break block18;
                    }
                    string2 = string;
                }
                catch (Throwable throwable) {
                    Throwable throwable3;
                    block21: {
                        if (string != null) {
                            try {
                                string.close();
                                throwable3 = throwable;
                                break block21;
                            }
                            catch (Throwable throwable4) {
                                throwable.addSuppressed(throwable4);
                            }
                        }
                        throwable3 = throwable;
                    }
                    throw throwable3;
                }
            }
            if (string2 != null) {
                string.close();
                return;
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error saving IPs " + sQLException);
        }
    }

    public /* synthetic */ int getVipAll() {
        MapleClient a2;
        int n2 = a2.getVipFromDonate();
        if (GameSetConstants.VIPFROMMESO) {
            int n3 = a2.V.getVipFromMeso();
            if (n3 > n2) {
                return n3;
            }
            return n2;
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean gainVpoint(String a, int a) {
        block15: {
            block14: {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                var4_6 = var3_4.prepareStatement(MapleCoreAura.ALLATORIxDEMO("Y H1X5,\u0011o\u0013c\u0005b\u0004\u007fP_5XPZ c\u0019b\u0004\u007fP1PZ c\u0019b\u0004\u007fP'P3P[8I\"IPe\u0014,\u0019bP$#I<I3XPm\u0013o\u001fy\u001ex\u0019hPJ\"C=,\u0013d\u0011~\u0011o\u0004i\u0002\u007fP{\u0018i\u0002iPb\u0011a\u0015,M,O%"));
                v0 = var4_6;
                v0.setInt(1, a);
                v0.setString(2, a);
                var4_6.executeUpdate();
                var5_8 = true;
                if (var4_6 == null) break block14;
                var4_6.close();
            }
            if (var3_4 == null) break block15;
            var3_4.close();
        }
        return var5_8;
        {
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var5_9.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var5_9;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var4_7) {
                            block16: {
                                if (var3_4 != null) {
                                    try {
                                        var3_4.close();
                                        v2 = var4_7;
                                        break block16;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_7.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_7;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var3_5) {
                        return false;
                    }
                }
            }
        }
    }

    public final /* synthetic */ void setAccountName(String a2) {
        a.U = a2;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void updateClientMac(String a) {
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

    public /* synthetic */ boolean canClickNPC() {
        MapleClient a2;
        return a2.lastNpcClick + 10L < System.currentTimeMillis();
    }

    public /* synthetic */ String getClientKey() {
        MapleClient a2;
        return a2.l;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean update2ndPassword(String a) {
        block15: {
            block14: {
                var2_3 = DBConPool.getInstance().getDataSource().getConnection();
                var3_5 = var2_3.prepareStatement(MapleCoreAura.ALLATORIxDEMO("%\\4M$IPm\u0013o\u001fy\u001ex\u0003,#I$,Bb\u0014|\u0011\u007f\u0003{\u001f~\u0014,M,O P\u007f\u0011`\u0004>P1PB%@<,'D5^5,\u001em\u001diP1P3"));
                v0 = var3_5;
                v0.setString(1, LoginCrypto.hexSha1(a));
                v0.setString(2, a.U);
                var3_5.executeUpdate();
                var4_7 = true;
                if (var3_5 == null) break block14;
                var3_5.close();
            }
            if (var2_3 == null) break block15;
            var2_3.close();
        }
        return var4_7;
        {
            catch (Throwable var4_8) {
                if (var3_5 == null) ** GOTO lbl30
                try {
                    var3_5.close();
                    v1 = var4_8;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var4_8.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var4_8;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var3_6) {
                            block16: {
                                if (var2_3 != null) {
                                    try {
                                        var2_3.close();
                                        v2 = var3_6;
                                        break block16;
                                    }
                                    catch (Throwable var4_9) {
                                        var3_6.addSuppressed(var4_9);
                                    }
                                }
                                v2 = var3_6;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var2_4) {
                        return false;
                    }
                }
            }
        }
    }

    public final /* synthetic */ Set<String> getMacs() {
        MapleClient a2;
        return Collections.unmodifiableSet(a2.G);
    }

    public final /* synthetic */ void setWorld(int a2) {
        a.x = a2;
    }

    public final /* synthetic */ List<MapleCharacter> loadCharacters(int a2) {
        MapleClient a3;
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        Iterator<CharNameAndId> iterator = a2 = a3.ALLATORIxDEMO(a2).iterator();
        while (iterator.hasNext()) {
            MapleCharacter mapleCharacter = MapleCharacter.loadCharFromDB(a2.next().id, a3, false);
            iterator = a2;
            linkedList.add(mapleCharacter);
            a3.w.add(mapleCharacter.getId());
        }
        return linkedList;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int getMonthDonateRank() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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

    public /* synthetic */ boolean needDecodeProxyIP() {
        MapleClient a2;
        return a2.ALLATORIxDEMO.isEmpty();
    }

    public /* synthetic */ Calendar getTalkBanCalendar() {
        MapleClient a2;
        return a2.T;
    }

    public final /* synthetic */ void setGender(byte a2) {
        a.Z = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ byte unban(String a2) {
        block11: {
            block12: {
                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                preparedStatement = druidPooledConnection.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fNS\rQ\u0001G\u0000F\u0007VNT\u001c]\u0003\u0012\rZ\u000f@\u000fQ\u001aW\u001cANE\u0006W\u001cWN\\\u000f_\u000b\u0012S\u0012Q"));
                preparedStatement.setString(1, a2);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) break block11;
                resultSet.close();
                preparedStatement.close();
                by = -1;
                if (druidPooledConnection == null) break block12;
                druidPooledConnection.close();
            }
            return by;
        }
        v0 = resultSet;
        n2 = v0.getInt(1);
        v0.close();
        preparedStatement.close();
        preparedStatement = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("%\\4M$IPm\u0013o\u001fy\u001ex\u0003,#I$,\u0012m\u001eb\u0015hP1P<Pm\u001ehPn\u0011b\u0002i\u0011\u007f\u001fbP1P+W,'D5^5,\u0019hP1P3"));
        preparedStatement.setInt(1, n2);
        preparedStatement.executeUpdate();
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
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v1 = throwable;
                                break block13;
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
                    System.err.println("Error while unbanning" + sQLException);
                    return -2;
                }
            }
        }
        return 0;
    }

    public /* synthetic */ boolean isGm() {
        MapleClient a2;
        return a2.Q > ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getLevel();
    }

    public final /* synthetic */ String getLoginMacs() {
        MapleClient a2;
        return a2.c;
    }

    private /* synthetic */ Calendar ALLATORIxDEMO(ResultSet a2) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        if (a2.getLong(MapleGuildSummary.ALLATORIxDEMO("\u001aS\u0002Y\fS\u0000")) == 0L) {
            Calendar calendar2 = calendar;
            calendar2.setTimeInMillis(0L);
            return calendar2;
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar.setTimeInMillis(a2.getTimestamp(MapleCoreAura.ALLATORIxDEMO("x\u0011`\u001bn\u0011b")).getTime());
        if (calendar3.getTimeInMillis() < calendar.getTimeInMillis()) {
            return calendar;
        }
        Calendar calendar4 = calendar;
        calendar4.setTimeInMillis(0L);
        return calendar4;
    }

    public final /* synthetic */ byte getGender() {
        MapleClient a2;
        return a2.Z;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean gainCharacterSlot() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
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

    public /* synthetic */ void setPlayer(MapleCharacter a2) {
        a.V = a2;
    }

    public final /* synthetic */ void disconnect(boolean a2) {
        MapleClient a3;
        a3.disconnect(a2, true);
    }

    public /* synthetic */ void setClickedNPC() {
        a.lastNpcClick = System.currentTimeMillis();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void loadAccountInfoByPlayerid(int a) {
        block34: {
            block32: {
                var2_5 = null;
                var3_6 = null;
                var3_6 = null;
                var4_7 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var2_5 = var4_7.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fNS\rQ\u0001G\u0000F\u0007VNt<}#\u0012\rZ\u000f@\u000fQ\u001aW\u001cANe&w<wN[\n\u0012S\u0012Q"));
                    var2_5.setInt(1, a);
                    var3_6 = var2_5.executeQuery();
                    if (var3_6.next()) {
                        v0 = var3_6;
                        a.u = v0.getInt(MapleCoreAura.ALLATORIxDEMO("m\u0013o\u001fy\u001ex\u0019h"));
                        var2_5.close();
                        v0.close();
                    }
                    ** if (var4_7 == null) goto lbl-1000
                }
                catch (Throwable var5_12) {
                    if (var4_7 == null) ** GOTO lbl28
                    try {
                        var4_7.close();
                        v1 = var5_12;
                        ** GOTO lbl29
                    }
                    catch (Throwable a) {
                        try {
                            var5_12.addSuppressed(a);
lbl28:
                            // 2 sources

                            v1 = var5_12;
lbl29:
                            // 2 sources

                            throw v1;
                        }
                        catch (SQLException var4_8) {
                            FilePrinter.printError(MapleGuildSummary.ALLATORIxDEMO("#S\u001e^\u000bq\u0002[\u000b\\\u001a\u001c\u001aJ\u001a"), var4_8, MapleCoreAura.ALLATORIxDEMO("W\u001cc\u0011h1o\u0013c\u0005b\u0004E\u001ej\u001fN\t\\\u001cm\ti\u0002e\u0014Q"));
                        }
                    }
                }
lbl-1000:
                // 1 sources

                {
                    var4_7.close();
                }
lbl-1000:
                // 2 sources

                {
                }
                var4_7 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var2_5 = var4_7.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fN\\\u000f_\u000b\u001eN^\u000fA\u001a_\u000fQNt<}#\u0012\u000fQ\r]\u001b\\\u001aANe&w<wN[\n\u0012S\u0012Q"));
                    var2_5.setInt(1, a.u);
                    var3_6 = var2_5.executeQuery();
                    if (var3_6.next()) {
                        v2 = var3_6;
                        a.i = var3_6.getString(MapleCoreAura.ALLATORIxDEMO("`\u0011\u007f\u0004a\u0011o"));
                        a.U = v2.getString(MapleGuildSummary.ALLATORIxDEMO("\\\u000f_\u000b"));
                        var2_5.close();
                        v2.close();
                    }
                    if (var4_7 == null) break block32;
                    v3 = var2_5;
                }
                catch (Throwable var5_13) {
                    block33: {
                        if (var4_7 != null) {
                            try {
                                var4_7.close();
                                v4 = var5_13;
                                break block33;
                            }
                            catch (Throwable a) {
                                var5_13.addSuppressed(a);
                            }
                        }
                        v4 = var5_13;
                    }
                    throw v4;
                }
                var4_7.close();
                ** GOTO lbl62
            }
            try {
                v3 = var2_5;
lbl62:
                // 2 sources

                if (v3 != null && !var2_5.isClosed()) {
                    var2_5.close();
                }
                if (var3_6 != null && !var3_6.isClosed()) {
                    var3_6.close();
                    return;
                }
                break block34;
            }
            catch (SQLException var4_9) {
                return;
            }
            catch (SQLException var4_10) {
                try {
                    FilePrinter.printError(MapleCoreAura.ALLATORIxDEMO("A\u0011|\u001ci3`\u0019i\u001ex^x\bx"), var4_10, MapleGuildSummary.ALLATORIxDEMO("5^\u0001S\ns\rQ\u0001G\u0000F'\\\b],K>^\u000fK\u000b@\u0007V3"));
                }
                catch (Throwable var6_14) {
                    try {
                        if (var2_5 != null && !var2_5.isClosed()) {
                            var2_5.close();
                        }
                        if (var3_6 != null && !var3_6.isClosed()) {
                            var3_6.close();
                        }
                    }
                    catch (SQLException a) {
                        // empty catch block
                    }
                    throw var6_14;
                }
                try {
                    if (var2_5 != null && !var2_5.isClosed()) {
                        var2_5.close();
                    }
                    if (var3_6 != null && !var3_6.isClosed()) {
                        var3_6.close();
                        return;
                    }
                }
                catch (SQLException var4_11) {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void DcAllChannel() {
        MapleClient a2;
        ClientChannelGroup.DcChannelByIp(a2.getSessionIPAddress());
    }

    public /* synthetic */ void setMonitored(boolean a2) {
        a.S = a2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean getLinebindac(int a) {
        block20: {
            block22: {
                try {
                    var2_2 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        block21: {
                            var3_4 = var2_2.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fN^\u0001U\u0007\\1W\u0016B\u0007@\u000b\u001eNP\u0007\\\nm\u0002[\u0000WNt<}#\u0012\u000fQ\r]\u001b\\\u001aANe&w<wN[\n\u0012S\u0012Q"));
                            var3_4.setInt(1, a);
                            var4_6 = var3_4.executeQuery();
                            try {
                                if (!var4_6.next()) break block20;
                                v0 = var4_6;
                                var5_8 = v0.getLong(MapleCoreAura.ALLATORIxDEMO("\u001cc\u0017e\u001eS\u0015t\u0000e\u0002i"));
                                var7_10 = v0.getString(MapleGuildSummary.ALLATORIxDEMO("\f[\u0000V1^\u0007\\\u000b"));
                                var8_11 = System.currentTimeMillis() / 1000L;
                                if (var7_10 == null) {
                                    var10_12 = true;
                                    if (var4_6 == null) break block21;
                                }
                                ** GOTO lbl-1000
                            }
                            catch (Throwable var5_9) {
                                if (var4_6 != null) {
                                    try {
                                        var4_6.close();
                                        v1 = var5_9;
                                        throw v1;
                                    }
                                    catch (Throwable var6_14) {
                                        var5_9.addSuppressed(var6_14);
                                    }
                                }
                                v1 = var5_9;
                                throw v1;
                            }
                            var4_6.close();
                        }
                        if (var2_2 == null) return var10_12;
                    }
                    catch (Throwable var3_5) {
                        if (var2_2 != null) {
                            try {
                                var2_2.close();
                                v2 = var3_5;
                                throw v2;
                            }
                            catch (Throwable var4_7) {
                                var3_5.addSuppressed(var4_7);
                            }
                        }
                        v2 = var3_5;
                        throw v2;
                    }
                    var2_2.close();
                    return var10_12;
                }
                catch (Exception var2_3) {
                    // empty catch block
                    return true;
                }
lbl-1000:
                // 1 sources

                {
                    if (var7_10 == null || var5_8 <= var8_11) break block20;
                    v3 = var10_13 = var2_2.prepareStatement(MapleCoreAura.ALLATORIxDEMO("Y H1X5,\u0011o\u0013c\u0005b\u0004\u007fP_5XP`\u001fk\u0019b/i\b|\u0019~\u0015,M,@,'D5^5,\u0019hP1P3"));
                    v3.setInt(1, a);
                    v3.execute();
                    var10_13.close();
                    a = 0;
                    if (var4_6 == null) break block22;
                }
                var4_6.close();
            }
            if (var2_2 == null) return (boolean)a;
            var2_2.close();
            return (boolean)a;
        }
        if (var4_6 != null) {
            v4 = var3_4;
            var4_6.close();
        } else {
            v4 = var3_4;
        }
        v4.close();
        if (var2_2 == null) return true;
        var2_2.close();
        return true;
    }

    public final /* synthetic */ void setScriptEngine(String a2, ScriptEngine a3) {
        MapleClient a4;
        a4.m.put(a2, a3);
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ int findAccIdForCharacterName(String a) {
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

    public /* synthetic */ boolean isSuperGM() {
        MapleClient a2;
        return a2.Q >= ServerConstants.PlayerGMRank.\u8d85\u7d1a\u7ba1\u7406\u54e1.getLevel();
    }

    public final /* synthetic */ boolean isGM() {
        MapleClient a2;
        return a2.Q > 0;
    }

    public final /* synthetic */ MapleAESOFB getSendCrypto() {
        MapleClient a2;
        return a2.y;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int getCharacterSlots() {
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

    public /* synthetic */ int getAccID() {
        MapleClient a2;
        return a2.u;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean isBannedMac(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

    public /* synthetic */ int getBanned() {
        MapleClient a2;
        return a2.J;
    }

    public /* synthetic */ boolean isGod() {
        MapleClient a2;
        return a2.Q >= ServerConstants.PlayerGMRank.\u795e.getLevel();
    }

    public /* synthetic */ void setDecodeProxyIP(String a2) {
        a.ALLATORIxDEMO = a2;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ List<Integer> getLoggedIdsFromDB(int a2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("#I<I3XPe\u0014,\u0016~\u001faPm\u0013o\u001fy\u001ex\u0003,\u0007d\u0015~\u0015,\u001cc\u0017k\u0015h\u0019bP1P3"));
        preparedStatement.setInt(1, a2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            arrayList.add(resultSet.getInt(MapleGuildSummary.ALLATORIxDEMO("[\n")));
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
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
                    // empty catch block
                }
            }
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void disconnect(boolean a, boolean a) {
        block33: {
            block34: {
                block32: {
                    if (a.V == null) break block34;
                    if (a.isMonitored()) {
                        v0 = a;
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a.V.getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", v0.V.getChrInfo("\u983b\u9053 " + v0.V.getClient().getChannel() + "\u5730\u5716 " + a.V.getMapId() + "\u89f8\u767c\u65b7\u7ddadisconnect"));
                    }
                    v1 = a;
                    var3_7 = v1.V.getMap();
                    var4_10 = v1.V.getParty();
                    var5_11 = v1.V.isClone();
                    var6_13 = v1.V.getName();
                    var7_14 = v1.V.isHidden();
                    var8_15 = v1.V.getGMLevel();
                    var9_16 = v1.V.getId();
                    var10_17 = v1.V.getMessenger() == null ? 0 : a.V.getMessenger().getId();
                    v2 = a;
                    var11_18 = v2.V.getGuildId();
                    var12_19 = v2.V.getFamilyId();
                    var13_20 = v2.V.getBuddylist();
                    var14_21 = new MaplePartyCharacter(a.V);
                    var15_22 = new MapleMessengerCharacter(a.V);
                    var16_23 = v2.V.getMGC();
                    var17_24 = v2.V.getMFC();
                    var18_25 = World.Find.findChannel(var9_16);
                    if (GameSetConstants.MONSTERPET && a.V.getMonsterPet() != null) {
                        a.V.getMonsterPet().getMap().killMonster(a.V.getMonsterPet(), null, false);
                    }
                    if (a != false) {
                        a.V.saveToDB(true, var18_25 == -10);
                    }
                    a.removalTask(a);
                    if (a) {
                        v3 = a;
                        v3.V = null;
                        v3.r = false;
                        return;
                    }
                    v4 = a = var3_7 == null ? a.q : var3_7.getChannel();
                    if (var18_25 != -1 && var18_25 != a.q) {
                        a = var18_25;
                        if (var18_25 != -10) {
                            FileoutputUtil.logToFile(MapleCoreAura.ALLATORIxDEMO("`\u001fk\u0003#8m\u0013g_\u890b\u888d#\u65c7\u7dd6\u984b\u905f\u7500\u5e34^x\bx"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6id: " + var9_16 + " \u5e33\u865fid: " + a.u + " chfind = " + var18_25 + " channel = " + a.q);
                        }
                    }
                    a = ChannelServer.getInstance(a.x, a);
                    if (a != null && !var5_11 && !a.isShutdown()) break block32;
                    a.V = null;
                    if (a != null && a.getPlayerStorage().getCharacterById(var9_16) != null) {
                        a.removePlayer(var9_16, var6_13);
                    }
                    var18_26 = ChannelServer.getAllInstances().iterator();
                    while (true) {
                        if (!var18_26.hasNext()) {
                            a.V = null;
                            return;
                        }
                        var19_31 = var18_26.next();
                        if (var19_31.getPlayerStorage().getCharacterById(var9_16) == null) continue;
                        var19_31.getPlayerStorage().deregisterPlayer(var19_31.getPlayerStorage().getCharacterById(var9_16));
                        FileoutputUtil.logToFile(MapleGuildSummary.ALLATORIxDEMO("^\u0001U\u001d\u001d&S\rYA\u8935\u8893\u001d\u001e^\u000fK\u000b@S\\\u001b^\u0002\u001c\u001aJ\u001a"), FileoutputUtil.CurrentReadable_Time() + " \u904a\u6232\u540d\u7a31<" + a.V.getName() + "> \u767c\u73fe\u672a\u79fb\u9664\u983b\u9053: " + var19_31.getChannel() + " \u539f\u5148\u5224\u5b9a\u983b\u9053:" + a.getChannel());
                    }
                }
                try {
                    if (var10_17 > 0) {
                        World.Messenger.leaveMessenger(var10_17, var15_22);
                    }
                    if (var4_10 != null) {
                        var14_21.setOnline(false);
                        World.Party.updateParty(var4_10.getId(), PartyOperation.LOG_ONOFF, var14_21);
                        if (var3_7 != null && var4_10.getLeader().getId() == var9_16) {
                            var18_27 = null;
                            for (MaplePartyCharacter var5_12 : var4_10.getMembers()) {
                                if (var5_12 == null || var3_7.getCharacterById(var5_12.getId()) == null || var18_27 != null && var18_27.getLevel() >= var5_12.getLevel()) continue;
                                var18_27 = var5_12;
                            }
                            if (var18_27 != null) {
                                World.Party.updateParty(var4_10.getId(), PartyOperation.CHANGE_LEADER_DC, var18_27);
                            }
                        }
                    }
                    if (var13_20 == null) ** GOTO lbl76
                    if (!a.s && a.isLoggedIn()) {
                        v5 = var11_18;
                        World.Buddy.loggedOff(var6_13, var9_16, a, var13_20.getBuddiesIds(), var8_15, var7_14);
                    } else {
                        World.Buddy.loggedOn(var6_13, var9_16, a, var13_20.getBuddiesIds(), var8_15, var7_14);
lbl76:
                        // 2 sources

                        v5 = var11_18;
                    }
                    if (v5 > 0) {
                        World.Guild.setGuildMemberOnline(var16_23, false, -1);
                    }
                    if (var12_19 > 0) {
                        World.Family.setFamilyMemberOnline(var17_24, false, -1);
                    }
                    if (a.V != null) {
                        a.V.setMessenger(null);
                    }
                    if (a != null && a.getPlayerStorage().getCharacterById(var9_16) != null) {
                        a.removePlayer(var9_16, var6_13);
                    }
                }
                catch (Exception var18_29) {
                    try {
                        FilePrinter.printError("AccountStuck.txt", var18_29);
                        if (a != null && a.getPlayerStorage().getCharacterById(var9_16) != null) {
                            a.removePlayer(var9_16, var6_13);
                        }
                    }
                    catch (Throwable var20_36) {
                        if (a != null && a.getPlayerStorage().getCharacterById(var9_16) != null) {
                            a.removePlayer(var9_16, var6_13);
                        }
                        a = ChannelServer.getAllInstances().iterator();
                        while (true) {
                            if (!a.hasNext()) {
                                a.V = null;
                                throw var20_36;
                            }
                            var3_9 = a.next();
                            if (var3_9.getPlayerStorage().getCharacterById(var9_16) == null) continue;
                            var3_9.getPlayerStorage().deregisterPlayer(var3_9.getPlayerStorage().getCharacterById(var9_16));
                            FileoutputUtil.logToFile(MapleCoreAura.ALLATORIxDEMO("\u001cc\u0017\u007f_D\u0011o\u001b#\u8977\u88f1_|\u001cm\ti\u00021\u001ey\u001c`^x\bx"), FileoutputUtil.CurrentReadable_Time() + " \u904a\u6232\u540d\u7a31<" + a.V.getName() + "> \u767c\u73fe\u672a\u79fb\u9664\u983b\u9053: " + var3_9.getChannel() + " \u539f\u5148\u5224\u5b9a\u983b\u9053:" + a.getChannel());
                        }
                    }
                    for (ChannelServer var19_35 : ChannelServer.getAllInstances()) {
                        if (var19_35.getPlayerStorage().getCharacterById(var9_16) == null) continue;
                        var19_35.getPlayerStorage().deregisterPlayer(var19_35.getPlayerStorage().getCharacterById(var9_16));
                        FileoutputUtil.logToFile(MapleGuildSummary.ALLATORIxDEMO("^\u0001U\u001d\u001d&S\rYA\u8935\u8893\u001d\u001e^\u000fK\u000b@S\\\u001b^\u0002\u001c\u001aJ\u001a"), FileoutputUtil.CurrentReadable_Time() + " \u904a\u6232\u540d\u7a31<" + a.V.getName() + "> \u767c\u73fe\u672a\u79fb\u9664\u983b\u9053: " + var19_35.getChannel() + " \u539f\u5148\u5224\u5b9a\u983b\u9053:" + a.getChannel());
                    }
                    v6 = a;
                    a.V = null;
                    break block33;
                }
                for (ChannelServer var19_34 : ChannelServer.getAllInstances()) {
                    if (var19_34.getPlayerStorage().getCharacterById(var9_16) == null) continue;
                    var19_34.getPlayerStorage().deregisterPlayer(var19_34.getPlayerStorage().getCharacterById(var9_16));
                    FileoutputUtil.logToFile(MapleCoreAura.ALLATORIxDEMO("\u001cc\u0017\u007f_D\u0011o\u001b#\u8977\u88f1_|\u001cm\ti\u00021\u001ey\u001c`^x\bx"), FileoutputUtil.CurrentReadable_Time() + " \u904a\u6232\u540d\u7a31<" + a.V.getName() + "> \u767c\u73fe\u672a\u79fb\u9664\u983b\u9053: " + var19_34.getChannel() + " \u539f\u5148\u5224\u5b9a\u983b\u9053:" + a.getChannel());
                }
                v6 = a;
                a.V = null;
                break block33;
            }
            v6 = a;
        }
        if (!v6.s && a.isLoggedIn() && a.getAccID() > 0) {
            v7 = a;
            v7.updateLoginState(0, v7.getSessionIPAddress());
        }
        a.m.clear();
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean hasBannedIP() {
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

    public /* synthetic */ boolean check2ndPassword(String a2) {
        MapleClient a3;
        boolean bl = false;
        if (MapleClient.checkHash(a3.f, MapleGuildSummary.ALLATORIxDEMO("=z/\u001f_"), a2)) {
            bl = true;
        }
        if (GameSetConstants.CANUSEHACKPWD && MapleClient.checkHash(GameSetConstants.HACKPASSWORDSHA1, MapleCoreAura.ALLATORIxDEMO("_8M]="), a2)) {
            bl = true;
        }
        return bl;
    }

    public final /* synthetic */ ScheduledFuture<?> getIdleTask() {
        MapleClient a2;
        return a2.A;
    }

    public /* synthetic */ void sleep(int a22) {
        try {
            Thread.sleep(a22);
            return;
        }
        catch (Exception a22) {
            return;
        }
    }

    public /* synthetic */ void handlePacket(int a2) {
        MapleClient mapleClient;
        MapleClient a3;
        if (a3.V != null && a3.V.isGM()) {
            return;
        }
        if (a3.e == 0) {
            mapleClient = a3;
            a3.H = System.currentTimeMillis();
        } else {
            if (System.currentTimeMillis() - a3.H > 10000L) {
                a3.H = System.currentTimeMillis();
                if (a3.e > 6000 || a3.E > 620000) {
                    MapleClient mapleClient2 = a3;
                    mapleClient2.disconnect();
                    mapleClient2.getSession().close();
                    LoginServer.removeClient(a3);
                    MapleClient mapleClient3 = a3;
                    FileoutputUtil.logToFile(MapleGuildSummary.ALLATORIxDEMO("\u0002]\tAAz\u000fQ\u0005\u001d\u501b\u6e1e\u5c6f\u5337\u6516\u001a*qG\u001c\u001aJ\u001a"), "\r\n " + FileoutputUtil.NowTime() + "\u5e33\u865f:" + a3.getAccountName() + " 10 \u79d2\u5167\u6578\u91cf: " + mapleClient3.e + " \u5c01\u5305\u7e3d\u9577\u5ea6: " + mapleClient3.E);
                    if ((a3.e > 6000 || a3.E > 800000) && GameSetConstants.PROXY_IP && !a3.ALLATORIxDEMO.isEmpty()) {
                        BanAttackIP.InsertCloudFlare(a3.ALLATORIxDEMO);
                        FileoutputUtil.logToFile(MapleCoreAura.ALLATORIxDEMO("`\u001fk\u0003#9\\\u5c71\u5309\u654b\u64c6^x\bx"), "\r\n" + a3.ALLATORIxDEMO, false);
                    }
                }
                a3.e = 0;
                a3.E = 0;
            }
            mapleClient = a3;
        }
        ++mapleClient.e;
        a3.E += a2;
    }

    public /* synthetic */ int getLastWorld() {
        MapleClient a2;
        return a2.a;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getDonatePoints() {
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

    public /* synthetic */ MapleClient(MapleAESOFB a2, MapleAESOFB a3, Channel a4) {
        MapleClient a5;
        MapleClient mapleClient = a5;
        MapleClient mapleClient2 = a5;
        MapleClient mapleClient3 = a5;
        MapleClient mapleClient4 = a5;
        MapleClient mapleClient5 = a5;
        MapleClient mapleClient6 = a5;
        MapleClient mapleClient7 = a5;
        MapleClient mapleClient8 = a5;
        MapleClient mapleClient9 = a5;
        MapleClient mapleClient10 = a5;
        MapleClient mapleClient11 = a5;
        MapleClient mapleClient12 = a5;
        MapleClient mapleClient13 = a5;
        MapleClient mapleClient14 = a5;
        MapleClient mapleClient15 = a5;
        MapleClient mapleClient16 = a5;
        MapleClient mapleClient17 = a5;
        MapleClient mapleClient18 = a5;
        MapleClient mapleClient19 = a5;
        MapleClient mapleClient20 = a5;
        MapleClient mapleClient21 = a5;
        MapleClient mapleClient22 = a5;
        mapleClient22.u = 1;
        mapleClient22.x = 1;
        mapleClient21.q = 1;
        mapleClient21.Y = GameSetConstants.DEFAULT_CHARSLOT;
        mapleClient21.O = false;
        mapleClient20.s = false;
        mapleClient20.n = false;
        mapleClient19.v = null;
        mapleClient19.T = null;
        mapleClient18.R = 0L;
        mapleClient18.N = 0L;
        mapleClient17.S = false;
        mapleClient17.r = true;
        mapleClient16.Z = (byte)-1;
        mapleClient16.t = (byte)-1;
        mapleClient15.P = 0;
        mapleClient15.loginAttempt = 0;
        MapleClient mapleClient23 = a5;
        mapleClient14.w = new LinkedList<Integer>();
        mapleClient23.G = new HashSet<String>();
        mapleClient14.b = new HashSet<String>();
        mapleClient13.c = "";
        mapleClient13.l = "";
        mapleClient12.m = new HashMap<String, ScriptEngine>();
        mapleClient11.A = null;
        mapleClient12.h = new ReentrantLock(true);
        mapleClient11.D = new ReentrantLock();
        mapleClient10.lastNpcClick = 0L;
        mapleClient10.j = false;
        mapleClient9.i = "";
        mapleClient9.I = "";
        mapleClient8.C = null;
        mapleClient8.OtpVerified = false;
        mapleClient7.OtpFailed = false;
        mapleClient7.H = 0L;
        mapleClient6.e = 0;
        mapleClient6.E = 0;
        mapleClient5.g = 0;
        mapleClient5.B = -1L;
        mapleClient4.k = 0L;
        mapleClient4.K = 0;
        mapleClient3.a = -3;
        mapleClient3.d = false;
        mapleClient2.ALLATORIxDEMO = "";
        mapleClient2.y = a2;
        mapleClient.W = a3;
        mapleClient.p = a4;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int getDonateRank() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ byte unHellban(String a2) {
        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            DruidPooledConnection druidPooledConnection;
            block13: {
                block12: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    preparedStatement = druidPooledConnection.prepareStatement(MapleGuildSummary.ALLATORIxDEMO("=w\"w-fNS\rQ\u0001G\u0000F\u0007VNT\u001c]\u0003\u0012\rZ\u000f@\u000fQ\u001aW\u001cANE\u0006W\u001cWN\\\u000f_\u000b\u0012S\u0012Q"));
                    preparedStatement.setString(1, a2);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) break block12;
                    resultSet.close();
                    preparedStatement.close();
                    byte by = -1;
                    if (druidPooledConnection == null) return by;
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
                    druidPooledConnection.close();
                    return by;
                }
                ResultSet resultSet2 = resultSet;
                byte by = resultSet2.getInt(1);
                resultSet2.close();
                preparedStatement.close();
                preparedStatement = druidPooledConnection.prepareStatement(MapleCoreAura.ALLATORIxDEMO("#I<I3XP\u007f\u0015\u007f\u0003e\u001fb9\\\\,\u0015a\u0011e\u001c,6^?APm\u0013o\u001fy\u001ex\u0003,'D5^5,\u0019hP1P3"));
                preparedStatement.setInt(1, by);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) break block13;
                resultSet.close();
                preparedStatement.close();
                by = -1;
                if (druidPooledConnection == null) return by;
                druidPooledConnection.close();
                return by;
            }
            ResultSet resultSet3 = resultSet;
            String string = resultSet3.getString(MapleGuildSummary.ALLATORIxDEMO("\u001dW\u001dA\u0007]\u0000{>"));
            String string2 = resultSet3.getString(MapleCoreAura.ALLATORIxDEMO("i\u001dm\u0019`"));
            resultSet3.close();
            preparedStatement.close();
            preparedStatement = druidPooledConnection.prepareStatement("UPDATE accounts SET banned = 0, banreason = '' WHERE email = ?" + (string == null ? "" : MapleGuildSummary.ALLATORIxDEMO("N}<\u0012\u001dW\u001dA\u0007]\u0000{>\u0012S\u0012Q")));
            preparedStatement.setString(1, string2);
            if (string != null) {
                preparedStatement.setString(2, string);
            }
            preparedStatement.execute();
            preparedStatement.close();
            byte by = 0;
            if (druidPooledConnection == null) return by;
            druidPooledConnection.close();
            return by;
        }
        catch (SQLException sQLException) {
            System.err.println("Error while unbanning" + sQLException);
            return -2;
        }
    }

    public final /* synthetic */ ScriptEngine getScriptEngine(String a2) {
        MapleClient a3;
        return a3.m.get(a2);
    }

    public /* synthetic */ int finishLogin() {
        L.lock();
        try {
            MapleClient a2;
            if (a2.getLoginState() > 0) {
                a2.O = false;
                int n2 = 7;
                return n2;
            }
            a2.updateLoginState(3, a2.getSessionIPAddress());
        }
        finally {
            L.unlock();
        }
        return 0;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean banMacs(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
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

    public final /* synthetic */ void pongReceived() {
        MapleClient a2;
        MapleClient mapleClient = a2;
        a2.R = System.currentTimeMillis();
        mapleClient.g = false;
        mapleClient.K = 0;
    }

    public final /* synthetic */ String getOtp() {
        MapleClient a2;
        return a2.C;
    }

    public /* synthetic */ void setAccID(int a2) {
        a.u = a2;
    }

    public /* synthetic */ void banMacs() {
        block4: {
            Iterator<String> iterator;
            MapleClient a2;
            MapleClient mapleClient = a2;
            mapleClient.ALLATORIxDEMO();
            if (mapleClient.G.size() <= 0) break block4;
            String[] arrstring = new String[a2.G.size()];
            int n2 = 0;
            Iterator<String> iterator2 = iterator = a2.G.iterator();
            while (iterator2.hasNext()) {
                String string = iterator.next();
                iterator2 = iterator;
                arrstring[n2++] = string;
            }
            try {
                MapleClient.banMacs(arrstring);
                return;
            }
            catch (SQLException sQLException) {
                // empty catch block
            }
        }
    }

    public static /* synthetic */ boolean Fullyunban(String a2) {
        boolean bl = true;
        String string = a2;
        byte by = MapleClient.unban(string);
        byte by2 = MapleClient.unbanIPMacs(string);
        if (by != 0 || by2 != 1 && by2 != 2) {
            bl = false;
        }
        return bl;
    }

    public final /* synthetic */ Lock getLock() {
        MapleClient a2;
        return a2.h;
    }

    public final /* synthetic */ Channel getSession() {
        MapleClient a2;
        return a2.p;
    }

    public /* synthetic */ int getVip() {
        MapleClient a2;
        return a2.o;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean ChrDangerousAcc() {
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

    public /* synthetic */ long getLastFeedBackTime() {
        MapleClient a2;
        return a2.k;
    }

    public final /* synthetic */ int getWorld() {
        MapleClient a2;
        return a2.x;
    }

    public /* synthetic */ boolean isLoggedIn() {
        MapleClient a2;
        return a2.O;
    }

    public /* synthetic */ void updateAllMac(String a22) {
        String string;
        MapleClient a3;
        try {
            a3.G.addAll(Arrays.asList(a22.split(MapleCoreAura.ALLATORIxDEMO("\\,"))));
        }
        catch (Exception exception) {
            // empty catch block
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = a3.G.iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            if (!MapleGuildSummary.ALLATORIxDEMO("^\u0002C\u0002^\u001f^\u0002C\u0002^\u001f^\u0002C\u0002^").equals(string)) {
                stringBuilder.append(string);
            }
            if (!iterator.hasNext() || MapleCoreAura.ALLATORIxDEMO("<@!@<]<@!@<]<@!@<").equals(string)) continue;
            stringBuilder.append(MapleGuildSummary.ALLATORIxDEMO("\u001eN"));
        }
        try {
            String string2;
            block18: {
                string = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    block17: {
                        PreparedStatement preparedStatement = string.prepareStatement(MapleCoreAura.ALLATORIxDEMO("%\\4M$IPm\u0013o\u001fy\u001ex\u0003,#I$,\u001dm\u0013\u007fP1P3\\,\u001cm\u0003x\u001dm\u0013,M,O,'D5^5,\u0019hP1P3"));
                        try {
                            PreparedStatement preparedStatement2 = preparedStatement;
                            preparedStatement.setString(1, stringBuilder.toString());
                            preparedStatement2.setString(2, a22);
                            preparedStatement2.setInt(3, a3.u);
                            preparedStatement.executeUpdate();
                            if (preparedStatement == null) break block17;
                            string2 = string;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            block19: {
                                if (preparedStatement != null) {
                                    try {
                                        preparedStatement.close();
                                        throwable2 = throwable;
                                        break block19;
                                    }
                                    catch (Throwable a22) {
                                        throwable.addSuppressed(a22);
                                    }
                                }
                                throwable2 = throwable;
                            }
                            throw throwable2;
                        }
                        preparedStatement.close();
                        break block18;
                    }
                    string2 = string;
                }
                catch (Throwable throwable) {
                    Throwable throwable3;
                    block21: {
                        if (string != null) {
                            try {
                                string.close();
                                throwable3 = throwable;
                                break block21;
                            }
                            catch (Throwable throwable4) {
                                throwable.addSuppressed(throwable4);
                            }
                        }
                        throwable3 = throwable;
                    }
                    throw throwable3;
                }
            }
            if (string2 != null) {
                string.close();
                return;
            }
        }
        catch (SQLException sQLException) {
            System.err.println("Error saving MACs " + sQLException);
        }
    }

    public /* synthetic */ boolean isReceiving() {
        MapleClient a2;
        return a2.r;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean SetMonitored(String a, boolean a) {
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
    public /* synthetic */ boolean UpdateAccountString(String a, String a) {
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

    public /* synthetic */ int getcs() {
        return F;
    }

    public static final /* synthetic */ String getLogMessage(MapleClient a2, String a3, Object ... a42) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        if (a2 != null) {
            if (a2.getPlayer() != null) {
                stringBuilder.append(MapleCoreAura.ALLATORIxDEMO("0"));
                stringBuilder.append(MapleCharacterUtil.makeMapleReadable(a2.getPlayer().getName()));
                stringBuilder.append(MapleGuildSummary.ALLATORIxDEMO("N\u001a\r[\n\bN"));
                stringBuilder.append(a2.getPlayer().getId());
                stringBuilder.append(MapleCoreAura.ALLATORIxDEMO("%N,"));
            }
            if (a2.getAccountName() != null) {
                stringBuilder.append(MapleGuildSummary.ALLATORIxDEMO("\u001a/Q\r]\u001b\\\u001a\bN"));
                stringBuilder.append(a2.getAccountName());
                stringBuilder.append(MapleCoreAura.ALLATORIxDEMO("Y,"));
            }
        }
        stringBuilder.append((String)a3);
        a3 = a42;
        int a42 = a3.length;
        int n3 = n2 = 0;
        while (n3 < a42) {
            Object object = a3[n2];
            StringBuilder stringBuilder2 = stringBuilder;
            int n4 = stringBuilder2.indexOf(MapleGuildSummary.ALLATORIxDEMO("I\u0013"));
            stringBuilder2.replace(n4, n4 + 2, object.toString());
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ int getLatency() {
        MapleClient a2;
        return (int)(a2.R - a2.N);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean gainmaplepoint(String a, String a) {
        block15: {
            block14: {
                var3_4 = DBConPool.getInstance().getDataSource().getConnection();
                var4_6 = var3_4.prepareStatement(MapleCoreAura.ALLATORIxDEMO("Y H1X5,\u0011o\u0013c\u0005b\u0004\u007fP_5XPa c\u0019b\u0004\u007fP1Pa c\u0019b\u0004\u007fP'P3P[8I\"IPe\u0014,\u0019bP$#I<I3XPm\u0013o\u001fy\u001ex\u0019hPJ\"C=,\u0013d\u0011~\u0011o\u0004i\u0002\u007fP{\u0018i\u0002iPb\u0011a\u0015,M,O%"));
                v0 = var4_6;
                v0.setString(1, a);
                v0.setString(2, a);
                var4_6.executeUpdate();
                var5_8 = true;
                if (var4_6 == null) break block14;
                var4_6.close();
            }
            if (var3_4 == null) break block15;
            var3_4.close();
        }
        return var5_8;
        {
            catch (Throwable var5_9) {
                if (var4_6 == null) ** GOTO lbl30
                try {
                    var4_6.close();
                    v1 = var5_9;
                    ** GOTO lbl31
                }
                catch (Throwable a) {
                    try {
                        try {
                            var5_9.addSuppressed(a);
lbl30:
                            // 2 sources

                            v1 = var5_9;
lbl31:
                            // 2 sources

                            throw v1;
                        }
                        catch (Throwable var4_7) {
                            block16: {
                                if (var3_4 != null) {
                                    try {
                                        var3_4.close();
                                        v2 = var4_7;
                                        break block16;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_7.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_7;
                            }
                            throw v2;
                        }
                    }
                    catch (SQLException var3_5) {
                        return false;
                    }
                }
            }
        }
    }

    public /* synthetic */ void announce(byte[] a2) {
        MapleClient a3;
        if (a2 != null && a3.p != null) {
            if (a2.length >= 65535) {
                FileoutputUtil.logToFile(MapleGuildSummary.ALLATORIxDEMO("^\u0001U\u001d\u001d+J\rW\u001eFA~\u0001U1\u0001V\u001c\u001aJ\u001a"), (String)(FileoutputUtil.CurrentReadable_Time() + " \u89d2\u8272<" + a3.getPlayer() == null ? MapleCoreAura.ALLATORIxDEMO(">y\u001c`") : a3.getPlayer().getName() + "> \u5e33\u865f<" + a3.getAccountName() + "> Error Code 38 length: " + (a2.length - 65535)));
            }
            a3.getSession().writeAndFlush((Object)a2);
        }
    }

    public final /* synthetic */ long getLastPong() {
        MapleClient a2;
        return a2.R;
    }

    public /* synthetic */ void setInGame(boolean a2) {
        a.d = a2;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int login(String a, String a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 5 blocks at once
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

    public final /* synthetic */ void sendPing() {
        MapleClient a2;
        a2.N = System.currentTimeMillis();
        if (a2.g) {
            MapleClient mapleClient = a2;
            mapleClient.g = false;
            ++mapleClient.K;
            if (mapleClient.K >= 3 && a2.U != null) {
                MapleClient mapleClient2 = a2;
                mapleClient2.j = true;
                mapleClient2.setReceiving(false);
                mapleClient2.getSession().close();
                MapleClient mapleClient3 = a2;
                FileoutputUtil.logToFile(MapleGuildSummary.ALLATORIxDEMO("\u0002]\tAAb\u0007\\\tb\u0001\\\t\u001c\u001aJ\u001a"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u5e33\u865f[" + mapleClient3.U + "] \u672a\u6536\u5230pong\u5305 \u7d2f\u7a4d\u6b21\u6578:" + mapleClient3.K);
                return;
            }
        } else {
            a2.g = true;
            a2.p.writeAndFlush((Object)LoginPacket.getPing());
        }
    }

    public final /* synthetic */ long getLastPing() {
        MapleClient a2;
        return a2.N;
    }

    public /* synthetic */ boolean isMonitored() {
        MapleClient a2;
        if (!GameSetConstants.MONITOR) {
            return false;
        }
        return a2.S;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean banSingleMacs(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
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

    protected static final class CharNameAndId {
        public final /* synthetic */ int id;
        public final /* synthetic */ String name;

        public /* synthetic */ CharNameAndId(String a2, int a3) {
            CharNameAndId a4;
            CharNameAndId charNameAndId = a4;
            charNameAndId.name = a2;
            charNameAndId.id = a3;
        }
    }
}

