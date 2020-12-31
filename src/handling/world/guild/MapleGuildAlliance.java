/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.world.guild;

import client.messages.commands.PracticerCommand;
import client.messages.commands.player.\u61a8\u61a8\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.world.World;
import handling.world.guild.MapleGuild;
import handling.world.guild.MapleGuildCharacter;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import server.buffs.AbstractBuffClass;
import tools.MaplePacketCreator;
import tools.StringUtil;

public class MapleGuildAlliance
implements Serializable {
    private /* synthetic */ String d;
    public static final /* synthetic */ long serialVersionUID = 24081985245L;
    private /* synthetic */ String a;
    private /* synthetic */ int k;
    private /* synthetic */ int B;
    private /* synthetic */ int K;
    private final /* synthetic */ int[] g;
    public static final /* synthetic */ int CHANGE_CAPACITY_COST = 10000000;
    private /* synthetic */ String[] ALLATORIxDEMO;

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ Collection<MapleGuildAlliance> loadAll() {
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

    public /* synthetic */ int getGuildId(int a2) {
        MapleGuildAlliance a3;
        return a3.g[a2];
    }

    public /* synthetic */ int getCapacity() {
        MapleGuildAlliance a2;
        return a2.K;
    }

    public /* synthetic */ boolean setLeaderId(int a2) {
        MapleGuildAlliance a3;
        return a3.setLeaderId(a2, false);
    }

    public final /* synthetic */ void broadcast(byte[] a2, int a3) {
        MapleGuildAlliance a4;
        a4.broadcast(a2, a3, GAOp.NONE, false);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void saveToDb() {
        block19: {
            block18: {
                block17: {
                    try {
                        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
                        var2_3 = var1_1.prepareStatement(StringUtil.ALLATORIxDEMO("dzukeo\u0011K]FXK_ITY\u0011YT^\u0011MDC]N\u0000\n\f\n\u000e\u0006\u0011MDC]N\u0003\n\f\n\u000e\u0006\u0011MDC]N\u0002\n\f\n\u000e\u0006\u0011MDC]N\u0005\n\f\n\u000e\u0006\u0011MDC]N\u0004\n\f\n\u000e\u0006\u0011XPDZ\u001b\u0011\u0017\u0011\u0015\u001d\nCK_A\u0003\n\f\n\u000e\u0006\u0011XPDZ\u0019\u0011\u0017\u0011\u0015\u001d\nCK_A\u0005\n\f\n\u000e\u0006\u0011XPDZ\u001f\u0011\u0017\u0011\u0015\u001d\nRKAKRCES\u0011\u0017\u0011\u0015\u001d\n]OPNTXXN\u0011\u0017\u0011\u0015\u001d\n_EECRO\u0011\u0017\u0011\u0015\u0011]YOCO\u0011CU\n\f\n\u000e"));
                        try {
                            v0 = var3_5 = 0;
lbl7:
                            // 2 sources

                            while (v0 < 5) {
                                v1 = var2_3;
                                v2 = var3_5 + 1;
                                v3 = a.g[var3_5] < 0 ? 0 : a.g[var3_5];
                                break block17;
                            }
                            ** GOTO lbl-1000
                        }
                        catch (Throwable var3_6) {
                            if (var2_3 != null) {
                                try {
                                    var2_3.close();
                                    v4 = var3_6;
                                    throw v4;
                                }
                                catch (Throwable var4_8) {
                                    var3_6.addSuppressed(var4_8);
                                }
                            }
                            v4 = var3_6;
                            throw v4;
                        }
                    }
                    catch (SQLException var1_2) {
                        System.err.println(AbstractBuffClass.ALLATORIxDEMO("MDR5J]LZI"));
                        return;
                    }
                    catch (Throwable var2_4) {
                        if (var1_1 != null) {
                            try {
                                var1_1.close();
                                v5 = var2_4;
                                throw v5;
                            }
                            catch (Throwable var3_7) {
                                var2_4.addSuppressed(var3_7);
                            }
                        }
                        v5 = var2_4;
                        throw v5;
                    }
                }
                v1.setInt(v2, v3);
                var2_3.setString(var3_5 + 6, a.ALLATORIxDEMO[var3_5++]);
                v0 = var3_5;
                ** GOTO lbl7
lbl-1000:
                // 1 sources

                {
                    v6 = var2_3;
                    v7 = var2_3;
                    v7.setInt(11, a.K);
                    v7.setInt(12, a.k);
                    v6.setString(13, a.d);
                    v6.setInt(14, a.B);
                    var2_3.executeUpdate();
                    if (var2_3 == null) break block18;
                    v8 = var1_1;
                }
                var2_3.close();
                break block19;
            }
            v8 = var1_1;
        }
        if (v8 == null) return;
        var1_1.close();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ boolean ForceDeleteAlliance(int a) {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var1_1.prepareStatement(AbstractBuffClass.ALLATORIxDEMO("@NQ_A[5y`wyzf>F[A>trywtpv{5#5.5I][G[5y`wyz|z5#5!"));
            var2_3.setInt(1, a);
            var2_3.execute();
            var2_3.close();
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
                    System.err.println("SQL THROW" + var1_2);
                    return false;
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_1.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return true;
    }

    public /* synthetic */ String[] getRanks() {
        MapleGuildAlliance a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ boolean disband() {
        MapleGuildAlliance a2;
        boolean bl = a2.deleteAlliance();
        if (bl) {
            a2.broadcast(null, -1, GAOp.DISBAND, false);
        }
        return bl;
    }

    public /* synthetic */ boolean removeGuild(int a2, boolean a3) {
        MapleGuildAlliance a4;
        return a4.removeGuild(a2, a3, false);
    }

    public /* synthetic */ boolean removeGuild(int a2, boolean a3, boolean a4) {
        MapleGuildAlliance a5;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a5.getNoGuilds()) {
            if (a5.g[n2] == a2) {
                if (!a4) {
                    a5.broadcast(null, a2, GAOp.DISBAND, a3);
                }
                if (n2 > 0 && n2 != a5.getNoGuilds() - 1) {
                    int n4;
                    int n5 = n4 = n2 + 1;
                    while (n5 < a5.getNoGuilds()) {
                        if (a5.g[n4] > 0) {
                            int n6 = n4;
                            a5.g[n6 - 1] = a5.g[n4];
                            if (n6 == a5.getNoGuilds() - 1) {
                                a5.g[n4] = -1;
                            }
                        }
                        n5 = ++n4;
                    }
                } else {
                    a5.g[n2] = -1;
                }
                if (n2 == 0) {
                    return a5.disband();
                }
                MapleGuildAlliance mapleGuildAlliance = a5;
                mapleGuildAlliance.broadcast(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance));
                mapleGuildAlliance.broadcast(MaplePacketCreator.getGuildAlliance(mapleGuildAlliance));
                mapleGuildAlliance.saveToDb();
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ boolean deleteAlliance() {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        v0 = n2 = 0;
        while (v0 < a2.getNoGuilds()) {
            preparedStatement = druidPooledConnection.prepareStatement(AbstractBuffClass.ALLATORIxDEMO("@NQ_A[5}}\u007fg\u007fvjplf>F[A>trywtpv{g\u007f{u5#5+5I][G[5y`wyz|z5#5!"));
            preparedStatement.setInt(1, a2.g[n2]);
            preparedStatement.execute();
            preparedStatement.close();
            v0 = ++n2;
        }
        preparedStatement = druidPooledConnection.prepareStatement(StringUtil.ALLATORIxDEMO("NTFT^T\nWX^G\u0011K]FXK_ITY\u0011]YOCO\u0011CU\n\f\n\u000e"));
        preparedStatement.setInt(1, a2.B);
        preparedStatement.execute();
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
                    System.err.println("SQL THROW" + sQLException);
                    return false;
                }
            }
        }
        return true;
    }

    public /* synthetic */ int getLeaderId() {
        MapleGuildAlliance a2;
        return a2.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ int createToDb(int a2, String a3, int a4, int a5) {
        int n2 = -1;
        if (a3.length() > 12) {
            return n2;
        }
        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            DruidPooledConnection druidPooledConnection;
            block11: {
                int n3;
                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    preparedStatement = druidPooledConnection.prepareStatement(StringUtil.ALLATORIxDEMO("bo}or~\u0011CU\nwx~g\u0011K]FXK_ITY\u0011}yoco\u0011DPGT\n\f\n\u000e"));
                    preparedStatement.setString(1, a3);
                    resultSet = preparedStatement.executeQuery();
                    if (!resultSet.first()) break block11;
                    resultSet.close();
                    preparedStatement.close();
                    n3 = n2;
                    if (druidPooledConnection == null) return n3;
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
                return n3;
            }
            preparedStatement.close();
            resultSet.close();
            PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(AbstractBuffClass.ALLATORIxDEMO("|pf{gj5w{jz>trywtpv{f>=ptsp25y`wyz$25y`wyz'25rp\u007fq{gwq75HTR@[F>=!9>*25!9>*7"), 1);
            PreparedStatement preparedStatement3 = preparedStatement;
            preparedStatement3.setString(1, a3);
            preparedStatement3.setInt(2, a4);
            preparedStatement2.setInt(3, a5);
            preparedStatement2.setInt(4, a2);
            preparedStatement2.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                n2 = resultSet.getInt(1);
            }
            resultSet.close();
            preparedStatement.close();
            if (druidPooledConnection == null) return n2;
            druidPooledConnection.close();
            return n2;
        }
        catch (SQLException sQLException) {
            System.err.println(StringUtil.ALLATORIxDEMO("b{}\nebcef"));
        }
        return n2;
    }

    public /* synthetic */ String getNotice() {
        MapleGuildAlliance a2;
        return a2.d;
    }

    public /* synthetic */ int getId() {
        MapleGuildAlliance a2;
        return a2.B;
    }

    public /* synthetic */ boolean setCapacity() {
        MapleGuildAlliance a2;
        if (a2.K >= 5) {
            return false;
        }
        MapleGuildAlliance mapleGuildAlliance = a2;
        ++mapleGuildAlliance.K;
        mapleGuildAlliance.broadcast(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance));
        mapleGuildAlliance.saveToDb();
        return true;
    }

    public /* synthetic */ boolean addGuild(int a2) {
        MapleGuildAlliance a3;
        if (a3.getNoGuilds() >= a3.getCapacity()) {
            return false;
        }
        MapleGuildAlliance mapleGuildAlliance = a3;
        a3.g[mapleGuildAlliance.getNoGuilds()] = a2;
        mapleGuildAlliance.saveToDb();
        a3.broadcast(null, a2, GAOp.NEWGUILD, false);
        return true;
    }

    public /* synthetic */ String getName() {
        MapleGuildAlliance a2;
        return a2.a;
    }

    public /* synthetic */ int getNoGuilds() {
        MapleGuildAlliance a2;
        int n2;
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < a2.K) {
            if (a2.g[n2] > 0) {
                ++n3;
            }
            n4 = ++n2;
        }
        return n3;
    }

    public /* synthetic */ String getRank(int a2) {
        MapleGuildAlliance a3;
        return a3.ALLATORIxDEMO[a2 - 1];
    }

    public /* synthetic */ boolean setLeaderId(int a2, boolean a3) {
        int n2;
        MapleGuildAlliance a4;
        if (a4.k == a2) {
            return false;
        }
        int n3 = -1;
        String string = null;
        int n4 = n2 = 0;
        while (n4 < a4.getNoGuilds()) {
            MapleGuild mapleGuild = World.Guild.getGuild(a4.g[n2]);
            if (mapleGuild != null) {
                MapleGuild mapleGuild2 = mapleGuild;
                MapleGuildCharacter mapleGuildCharacter = mapleGuild2.getMGC(a2);
                MapleGuildCharacter mapleGuildCharacter2 = mapleGuild2.getMGC(a4.k);
                if (mapleGuildCharacter != null && mapleGuildCharacter2 != null && !a3) {
                    return false;
                }
                if (mapleGuildCharacter != null && mapleGuildCharacter.getGuildRank() == 1 && mapleGuildCharacter.getAllianceRank() == 2) {
                    mapleGuild.changeARank(a2, 1);
                    n3 = n2;
                    string = mapleGuildCharacter.getName();
                } else if (mapleGuildCharacter2 != null && mapleGuildCharacter2.getGuildRank() == 1 && mapleGuildCharacter2.getAllianceRank() == 1) {
                    mapleGuild.changeARank(a4.k, 2);
                } else if (mapleGuildCharacter2 != null || mapleGuildCharacter != null) {
                    return false;
                }
            }
            n4 = ++n2;
        }
        if (n3 == -1) {
            return false;
        }
        MapleGuildAlliance mapleGuildAlliance = a4;
        n2 = mapleGuildAlliance.g[n3];
        mapleGuildAlliance.g[n3] = a4.g[0];
        mapleGuildAlliance.g[0] = n2;
        if (string != null) {
            a4.broadcast(MaplePacketCreator.getErrorNotice(string + " \u5df2\u6210\u70ba\u76ee\u524d\u7684\u516c\u6703\u806f\u76df\u9577!"));
        }
        MapleGuildAlliance mapleGuildAlliance2 = a4;
        MapleGuildAlliance mapleGuildAlliance3 = a4;
        MapleGuildAlliance mapleGuildAlliance4 = a4;
        mapleGuildAlliance3.broadcast(MaplePacketCreator.changeAllianceLeader(mapleGuildAlliance3.B, mapleGuildAlliance4.k, a2));
        mapleGuildAlliance3.broadcast(MaplePacketCreator.updateAllianceLeader(mapleGuildAlliance4.B, a4.k, a2));
        mapleGuildAlliance3.broadcast(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance3));
        mapleGuildAlliance2.broadcast(MaplePacketCreator.getGuildAlliance(mapleGuildAlliance2));
        mapleGuildAlliance2.k = a2;
        a4.saveToDb();
        return true;
    }

    public /* synthetic */ void setRank(String[] a2) {
        MapleGuildAlliance a3;
        MapleGuildAlliance mapleGuildAlliance = a3;
        mapleGuildAlliance.ALLATORIxDEMO = a2;
        mapleGuildAlliance.broadcast(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance));
        mapleGuildAlliance.saveToDb();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ MapleGuildAlliance(int a222) {
        DruidPooledConnection druidPooledConnection;
        DruidPooledConnection druidPooledConnection2;
        block21: {
            block20: {
                int a222;
                ResultSet resultSet;
                PreparedStatement preparedStatement;
                block17: {
                    block19: {
                        MapleGuildAlliance a3;
                        MapleGuildAlliance mapleGuildAlliance = a3;
                        mapleGuildAlliance.g = new int[5];
                        mapleGuildAlliance.ALLATORIxDEMO = new String[5];
                        try {
                            block18: {
                                druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                                preparedStatement = druidPooledConnection2.prepareStatement(AbstractBuffClass.ALLATORIxDEMO("F[Y[VJ545XGQX>trywtpv{f>BVPLP>|z5#5!"));
                                try {
                                    PreparedStatement preparedStatement2 = preparedStatement;
                                    preparedStatement2.setInt(1, a222);
                                    resultSet = preparedStatement2.executeQuery();
                                    if (resultSet.first()) break block17;
                                    resultSet.close();
                                    preparedStatement.close();
                                    a3.B = -1;
                                    if (preparedStatement == null) break block18;
                                }
                                catch (Throwable throwable) {
                                    Throwable throwable2;
                                    if (preparedStatement != null) {
                                        try {
                                            preparedStatement.close();
                                            throwable2 = throwable;
                                            throw throwable2;
                                        }
                                        catch (Throwable a222) {
                                            throwable.addSuppressed(a222);
                                        }
                                    }
                                    throwable2 = throwable;
                                    throw throwable2;
                                }
                                preparedStatement.close();
                            }
                            if (druidPooledConnection2 == null) return;
                            break block19;
                        }
                        catch (SQLException sQLException) {
                            System.err.println(StringUtil.ALLATORIxDEMO("DDPH]O\u0011^^\nCOPN\u0011MDC]N\u0011C_L^X\\KEC^D\u0011LCE\\\nB[]"));
                            return;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable3;
                            if (druidPooledConnection2 != null) {
                                try {
                                    druidPooledConnection2.close();
                                    throwable3 = throwable;
                                    throw throwable3;
                                }
                                catch (Throwable throwable4) {
                                    throwable.addSuppressed(throwable4);
                                }
                            }
                            throwable3 = throwable;
                            throw throwable3;
                        }
                    }
                    druidPooledConnection2.close();
                    return;
                }
                ResultSet resultSet2 = resultSet;
                a3.B = a222;
                a3.a = resultSet2.getString(StringUtil.ALLATORIxDEMO("DPGT"));
                a3.K = resultSet2.getInt(AbstractBuffClass.ALLATORIxDEMO("v\u007fe\u007fvwag"));
                int n2 = a222 = 1;
                while (n2 < 6) {
                    a3.g[a222 - 1] = resultSet.getInt("guild" + a222);
                    int n3 = a222 - 1;
                    String string = resultSet.getString("rank" + a222);
                    a3.ALLATORIxDEMO[n3] = string;
                    n2 = ++a222;
                }
                {
                    ResultSet resultSet3 = resultSet;
                    a3.k = resultSet3.getInt(StringUtil.ALLATORIxDEMO("FTKUOCCU"));
                    a3.d = resultSet3.getString(AbstractBuffClass.ALLATORIxDEMO("{qawv{"));
                    resultSet.close();
                    if (preparedStatement == null) break block20;
                    druidPooledConnection = druidPooledConnection2;
                }
                preparedStatement.close();
                break block21;
            }
            druidPooledConnection = druidPooledConnection2;
        }
        if (druidPooledConnection == null) return;
        druidPooledConnection2.close();
    }

    public final /* synthetic */ void broadcast(byte[] a2) {
        MapleGuildAlliance a3;
        a3.broadcast(a2, -1, GAOp.NONE, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void broadcast(byte[] a2, int a3, GAOp a4, boolean a5) {
        MapleGuildAlliance a6;
        if (null == a4) {
            World.Alliance.sendGuild(a2, a3, a6.B);
            return;
        }
        switch (1.ALLATORIxDEMO[a4.ordinal()]) {
            case 1: {
                World.Alliance.setOldAlliance(a3, a5, a6.B);
                return;
            }
            case 2: {
                World.Alliance.setNewAlliance(a3, a6.B);
                return;
            }
        }
        World.Alliance.sendGuild(a2, a3, a6.B);
    }

    public /* synthetic */ boolean changeAllianceRank(int a2, int a3) {
        int n2;
        MapleGuildAlliance a4;
        if (a4.k == a2 || a3 < 0 || a3 > 1) {
            return false;
        }
        int n3 = n2 = 0;
        while (n3 < a4.getNoGuilds()) {
            MapleGuildCharacter mapleGuildCharacter;
            MapleGuild mapleGuild = World.Guild.getGuild(a4.g[n2]);
            if (mapleGuild != null && (mapleGuildCharacter = mapleGuild.getMGC(a2)) != null && mapleGuildCharacter.getAllianceRank() > 2) {
                if (a3 == 0 && mapleGuildCharacter.getAllianceRank() >= 5 || a3 == 1 && mapleGuildCharacter.getAllianceRank() <= 3) {
                    return false;
                }
                mapleGuild.changeARank(a2, mapleGuildCharacter.getAllianceRank() + (a3 == 0 ? 1 : -1));
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public /* synthetic */ void setNotice(String a2) {
        MapleGuildAlliance a3;
        MapleGuildAlliance mapleGuildAlliance = a3;
        a3.d = a2;
        mapleGuildAlliance.broadcast(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance));
        mapleGuildAlliance.broadcast(MaplePacketCreator.getErrorNotice("\u806f\u76df\u516c\u544a\u4e8b\u9805 : " + a2));
        a3.saveToDb();
    }

    private static final class GAOp
    extends Enum<GAOp> {
        private static final /* synthetic */ GAOp[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ GAOp NEWGUILD;
        public static final /* synthetic */ /* enum */ GAOp DISBAND;
        public static final /* synthetic */ /* enum */ GAOp NONE;

        public static /* synthetic */ GAOp valueOf(String a2) {
            return Enum.valueOf(GAOp.class, a2);
        }

        public static /* synthetic */ {
            NONE = new GAOp(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u0007&\u0007,"), 0);
            DISBAND = new GAOp(PracticerCommand.ALLATORIxDEMO("?N(E:I?"), 1);
            NEWGUILD = new GAOp(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u0007,\u001e.\u001c \u0005-"), 2);
            GAOp[] arrgAOp = new GAOp[3];
            arrgAOp[0] = NONE;
            arrgAOp[1] = DISBAND;
            arrgAOp[2] = NEWGUILD;
            ALLATORIxDEMO = arrgAOp;
        }

        public static /* synthetic */ GAOp[] values() {
            return (GAOp[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ GAOp() {
            void var2_-1;
            void var1_-1;
            GAOp a2;
        }
    }
}

