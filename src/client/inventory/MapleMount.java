/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.inventory;

import client.MapleCharacter;
import client.messages.commands.player.\u592d\u58fd\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.channel.handler.NPCHandler;
import handling.opcodes.MapleBuffStat;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import server.Randomizer;
import tools.FilePrinter;
import tools.MaplePacketCreator;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleMount
implements Serializable {
    public /* synthetic */ boolean Riding;
    private final /* synthetic */ int e;
    private /* synthetic */ int E;
    private /* synthetic */ int g;
    private static final /* synthetic */ Map<Integer, List<MonsterPetInfo>> ALLATORIxDEMO;
    private static final /* synthetic */ Map<Integer, List<MountBankInfo>> d;
    private static final /* synthetic */ long H = 9179541993413738569L;
    public /* synthetic */ byte fatigue;
    private final /* synthetic */ long k = 0L;
    private /* synthetic */ ScheduledFuture<?> a;
    public /* synthetic */ byte level;
    private final transient /* synthetic */ WeakReference<MapleCharacter> K;
    private transient /* synthetic */ boolean B;

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static /* synthetic */ void ALLATORIxDEMO(int a2) {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT*FROM `monsterpet` WHERE `characterid` = " + a2);
        resultSet = preparedStatement.executeQuery();
        linkedList = new LinkedList<MonsterPetInfo>();
        v0 = resultSet;
        while (v0.next()) {
            monsterPetInfo = new MonsterPetInfo(resultSet.getInt(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0005\u001c\u0007\u0006\u0007\u0017\u0012\u0011\u0014\u001d\u0002")), resultSet.getInt(NPCHandler.ALLATORIxDEMO("n\bm\u0014w\u0002q\u000eg")), resultSet.getInt(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0019\t\u001a\u0015\u0000\u0003\u0006\n\u0011\u0010\u0011\n")), resultSet.getInt(NPCHandler.ALLATORIxDEMO("\u0017o\u0006z\u0002q\fj\u000bo\u0002g")));
            v0 = resultSet;
            linkedList.add(monsterPetInfo);
        }
        MapleMount.ALLATORIxDEMO.put(a2, linkedList);
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
                    System.err.println("\u672a\u80fd\u986f\u793a\u89d2\u8272" + a2 + "\u602a\u7269\u5bf5\u7269");
                }
            }
        }
    }

    public /* synthetic */ int getItemId() {
        MapleMount a2;
        return a2.E;
    }

    public /* synthetic */ void setExp(int a2) {
        MapleMount a3;
        MapleMount mapleMount = a3;
        mapleMount.B = true;
        mapleMount.g = a2;
    }

    public /* synthetic */ int getExp() {
        MapleMount a2;
        return a2.g;
    }

    public /* synthetic */ void increaseFatigue() {
        MapleMount a2;
        MapleCharacter mapleCharacter = (MapleCharacter)a2.K.get();
        a2.B = true;
        a2.fatigue = (byte)(a2.fatigue + 1);
        if (mapleCharacter != null && mapleCharacter.getMap() != null) {
            mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.updateMount(mapleCharacter, false));
        }
        if (a2.fatigue > 99) {
            a2.fatigue = (byte)95;
            if (mapleCharacter != null) {
                mapleCharacter.dropMessage(5, "\u9a0e\u5bf5\u76ee\u524d\u75b2\u52de\u503c:" + a2.fatigue);
                mapleCharacter.cancelEffectFromBuffStat(MapleBuffStat.MONSTER_RIDING);
            }
        }
    }

    public /* synthetic */ void setItemId(int a2) {
        MapleMount a3;
        MapleMount mapleMount = a3;
        mapleMount.B = true;
        mapleMount.E = a2;
    }

    public /* synthetic */ byte getFatigue() {
        MapleMount a2;
        return a2.fatigue;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static /* synthetic */ void H(int a2) {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement("SELECT*FROM `mountbank` WHERE `characterid` = " + a2);
        resultSet = preparedStatement.executeQuery();
        linkedList = new LinkedList<MountBankInfo>();
        v0 = resultSet;
        while (v0.next()) {
            mountBankInfo = new MountBankInfo(resultSet.getInt(NPCHandler.ALLATORIxDEMO("`\u000fb\u0015b\u0004w\u0002q\u000eg")), resultSet.getInt(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u000b\u001b\u0013\u001a\u0012\u001d\u0002")));
            v0 = resultSet;
            linkedList.add(mountBankInfo);
        }
        MapleMount.d.put(a2, linkedList);
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
                    System.err.println("\u672a\u80fd\u986f\u793a\u89d2\u8272" + a2 + "\u9a0e\u5bf5\u5009\u5eab");
                }
            }
        }
    }

    public /* synthetic */ void increaseExp() {
        MapleMount mapleMount;
        int n2;
        MapleMount a2;
        if (a2.level >= 1 && a2.level <= 7) {
            n2 = Randomizer.nextInt(10) + 15;
            mapleMount = a2;
        } else if (a2.level >= 8 && a2.level <= 15) {
            n2 = Randomizer.nextInt(13) + 7;
            mapleMount = a2;
        } else if (a2.level >= 16 && a2.level <= 24) {
            n2 = Randomizer.nextInt(23) + 9;
            mapleMount = a2;
        } else {
            n2 = Randomizer.nextInt(28) + 12;
            mapleMount = a2;
        }
        mapleMount.setExp(a2.g + n2);
    }

    public /* synthetic */ long getTiredness() {
        return 0L;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ String addMonsterPet(int a2, int a3) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ResultSet resultSet2;
        PreparedStatement preparedStatement2;
        DruidPooledConnection druidPooledConnection;
        String string;
        block19: {
            string = "";
            if (a3 < 100100) {
                return \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6333\u633d\u7516\u5e4cJ\u605e\u720f\u7d9c\u8639\u5c7b\u65daEVDWDVX\u8aad\u801b\u7e0d\u7bd5\u7460\u5495G");
            }
            try {
                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    PreparedStatement preparedStatement3 = preparedStatement2 = druidPooledConnection.prepareStatement(NPCHandler.ALLATORIxDEMO("4F+F$WME5L*#\nl\tp\u0013f\u0015s\u0002wGT/F5FG`\u000fb\u0015b\u0004w\u0002q\u000egG>G<GB)GGn\bm\u0014w\u0002q\u000egG>G<"));
                    preparedStatement3.setInt(1, a2);
                    preparedStatement3.setInt(2, a3);
                    resultSet2 = preparedStatement3.executeQuery();
                    try {
                        if (resultSet2.next()) {
                            ResultSet resultSet3 = resultSet2;
                            resultSet = resultSet3;
                            resultSet3.close();
                            preparedStatement2.close();
                            string = \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u60dc\u5d94\u6321\u632f\u6b10\u604c\u721dG\u7155\u6cb3\u51f9\u6b47\u6321\u632f");
                            break block19;
                        }
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        if (resultSet2 != null) {
                            try {
                                resultSet2.close();
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
                    if (druidPooledConnection != null) {
                        try {
                            druidPooledConnection.close();
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
                System.err.println("\u8173\u8272ID" + a2 + "\u672a\u80fd\u9806\u5229\u65b0\u589e\u602a\u7269\u5bf5\u7269:" + a3);
                return NPCHandler.ALLATORIxDEMO("\u6332\u634a\u7517\u5e3bK\u8ac8\u8008\u7e68\u7bc6\u7405\u5486\"");
            }
            {
                PreparedStatement preparedStatement4;
                PreparedStatement preparedStatement5 = preparedStatement4 = druidPooledConnection.prepareStatement(NPCHandler.ALLATORIxDEMO("J)P\"Q3#.M3LGn\bm\u0014w\u0002q\u0017f\u0013#O`\u000fb\u0015b\u0004w\u0002q\u000egG/\nl\tp\u0013f\u0015j\u0003*GU&O2F4#O<K#X*"));
                preparedStatement5.setInt(1, a2);
                preparedStatement5.setInt(2, a3);
                preparedStatement5.executeUpdate();
                string = \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d94\u6321\u7314\u605e\u720f\u6264\u70dc\u4f14\u76e2\u5b81\u720fX\u8aad\u6791\u95d7\u605e\u720f\u5b81\u720f\u507d\u5ecd\u5113\u78dc\u8af9\u3064");
                resultSet = resultSet2;
            }
        }
        if (resultSet != null) {
            preparedStatement = preparedStatement2;
            resultSet2.close();
        } else {
            preparedStatement = preparedStatement2;
        }
        preparedStatement.close();
        if (druidPooledConnection == null) return string;
        druidPooledConnection.close();
        return string;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void addMountId(int a, int a) {
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

    public static /* synthetic */ List<MonsterPetInfo> getMonsterPet(int a2) {
        ALLATORIxDEMO.clear();
        if (ALLATORIxDEMO.get(a2) == null || ALLATORIxDEMO.get(a2).isEmpty()) {
            MapleMount.ALLATORIxDEMO(a2);
        }
        return ALLATORIxDEMO.get(a2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void saveMount(int a22, Connection a322) {
        AutoCloseable a322;
        MapleMount a4;
        if (!a4.B) {
            return;
        }
        a322 = a322.prepareStatement(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"!60' #T\u000b\u001b\u0013\u001a\u0012\u0010\u0007\u0000\u0007T\u0015\u0011\u0012T\u00068\u0003\u0002\u0003\u0018\u0006T[TYXF\u0014#\f\u0016\u0014FIFKJT\u00062\u0007\u0000\u000f\u0013\u0013\u0011\u0006T[TYT1<#&#T\u0005\u001c\u0007\u0006\u0007\u0017\u0012\u0011\u0014\u001d\u0002T[TY"));
        try {
            AutoCloseable autoCloseable = a322;
            AutoCloseable autoCloseable2 = a322;
            AutoCloseable autoCloseable3 = a322;
            autoCloseable3.setByte(1, a4.level);
            autoCloseable3.setInt(2, a4.g);
            autoCloseable2.setByte(3, a4.fatigue);
            autoCloseable.setInt(4, a22);
            autoCloseable2.executeUpdate();
            autoCloseable.close();
            if (a322 == null) return;
        }
        catch (Throwable throwable) {
            try {
                Throwable throwable2;
                if (a322 != null) {
                    try {
                        a322.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (Throwable a22) {
                        throwable.addSuppressed(a22);
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
            catch (SQLException a322) {
                FilePrinter.printError(NPCHandler.ALLATORIxDEMO("*b\u0017o\u0002N\bv\twIw\u001fw"), a322, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0015\u0015\u0010\u0011+\u001b\u0013\u001a\u0012"));
            }
        }
        a322.close();
        return;
    }

    public static /* synthetic */ {
        d = new HashMap<Integer, List<MountBankInfo>>();
        ALLATORIxDEMO = new HashMap<Integer, List<MonsterPetInfo>>();
    }

    public static /* synthetic */ List<MountBankInfo> getMountBank(int a2) {
        d.clear();
        if (d.get(a2) == null || d.get(a2).isEmpty()) {
            MapleMount.H(a2);
        }
        return d.get(a2);
    }

    public /* synthetic */ void setFatigue(byte a2) {
        MapleMount a3;
        MapleMount mapleMount = a3;
        mapleMount.B = true;
        mapleMount.fatigue = (byte)(mapleMount.fatigue + a2);
        if (mapleMount.fatigue < 0) {
            a3.fatigue = 0;
        }
    }

    public final /* synthetic */ boolean canTire(long a2) {
        return false;
    }

    public /* synthetic */ int getSkillId() {
        MapleMount a2;
        return a2.e;
    }

    public /* synthetic */ MapleMount(MapleCharacter a2, int a3, int a4, byte a5, byte a6, int a7) {
        MapleMount a8;
        MapleMount mapleMount = a8;
        MapleMount mapleMount2 = a8;
        MapleMount mapleMount3 = a8;
        MapleMount mapleMount4 = a8;
        mapleMount4.B = false;
        mapleMount4.k = 0L;
        mapleMount3.Riding = false;
        mapleMount3.E = a3;
        mapleMount2.e = a4;
        mapleMount2.fatigue = a5;
        mapleMount.level = a6;
        mapleMount.g = a7;
        MapleMount mapleMount5 = a8;
        mapleMount.K = new WeakReference<MapleCharacter>(a2);
    }

    public /* synthetic */ void setLevel(byte a2) {
        MapleMount a3;
        MapleMount mapleMount = a3;
        mapleMount.B = true;
        mapleMount.level = a2;
    }

    public /* synthetic */ byte getLevel() {
        MapleMount a2;
        return a2.level;
    }

    public static class MountBankInfo {
        private final /* synthetic */ int d;
        private final /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ int getCharacterId() {
            MountBankInfo a2;
            return a2.d;
        }

        public /* synthetic */ MountBankInfo(int a2, int a3) {
            MountBankInfo a4;
            MountBankInfo mountBankInfo = a4;
            mountBankInfo.d = a2;
            mountBankInfo.ALLATORIxDEMO = a3;
        }

        public /* synthetic */ int getMountId() {
            MountBankInfo a2;
            return a2.ALLATORIxDEMO;
        }
    }

    public static class MonsterPetInfo {
        private final /* synthetic */ int K;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ int d;
        private final /* synthetic */ int a;

        public /* synthetic */ int getMountId() {
            MonsterPetInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getPlayerKilled() {
            MonsterPetInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ MonsterPetInfo(int a2, int a3, int a4, int a5) {
            MonsterPetInfo a6;
            MonsterPetInfo monsterPetInfo = a6;
            MonsterPetInfo monsterPetInfo2 = a6;
            monsterPetInfo2.K = a2;
            monsterPetInfo2.a = a3;
            monsterPetInfo.d = a4;
            monsterPetInfo.ALLATORIxDEMO = a5;
        }

        public /* synthetic */ int getCharacterId() {
            MonsterPetInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getMountLevel() {
            MonsterPetInfo a2;
            return a2.d;
        }
    }
}

