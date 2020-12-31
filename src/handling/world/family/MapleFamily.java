/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.world.family;

import client.MapleCharacter;
import client.MapleCoolDownValueHolder;
import client.messages.CommandProcessorUtil;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.world.World;
import handling.world.family.MapleFamilyCharacter;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tools.EmojiFilter;
import tools.KoreanDateUtil;
import tools.MaplePacketCreator;
import tools.packet.FamilyPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public final class MapleFamily
implements Serializable {
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ String E;
    private /* synthetic */ int k;
    public static final /* synthetic */ long serialVersionUID = 6322150443228168192L;
    private /* synthetic */ int B;
    private /* synthetic */ boolean d;
    private /* synthetic */ boolean a;
    private /* synthetic */ int K;
    private final /* synthetic */ Map<Integer, MapleFamilyCharacter> e;
    private /* synthetic */ String g;

    public /* synthetic */ void resetPedigree() {
        MapleFamily a2;
        Iterator<MapleFamilyCharacter> iterator;
        Iterator<MapleFamilyCharacter> iterator2 = iterator = a2.e.values().iterator();
        while (iterator2.hasNext()) {
            iterator.next().resetPedigree(a2);
            iterator2 = iterator;
        }
        a2.d = true;
    }

    public final /* synthetic */ int getLeaderId() {
        MapleFamily a2;
        return a2.k;
    }

    public final /* synthetic */ int setRep(int a22, int a3, int a42) {
        MapleFamily a5;
        MapleFamilyCharacter a22 = a5.getMFC(a22);
        if (a22 != null && a22.getFamilyId() == a5.B) {
            MapleFamilyCharacter mapleFamilyCharacter;
            if (a42 > a22.getLevel()) {
                a3 /= 2;
            }
            if (a22.isOnline()) {
                ArrayList<Integer> a42 = new ArrayList<Integer>();
                boolean bl = a42.add(a22.getId());
                MapleFamily mapleFamily = a5;
                mapleFamily.broadcast(FamilyPacket.changeRep(a3), -1, a42);
                MapleFamilyCharacter mapleFamilyCharacter2 = a22;
                mapleFamilyCharacter = mapleFamilyCharacter2;
                World.Family.setFamily(mapleFamily.B, mapleFamilyCharacter2.getSeniorId(), a22.getJunior1(), a22.getJunior2(), a22.getCurrentRep() + a3, a22.getTotalRep() + a3, a22.getId());
            } else {
                MapleFamily.setOfflineFamilyStatus(a5.B, a22.getSeniorId(), a22.getJunior1(), a22.getJunior2(), a22.getCurrentRep() + a3, a22.getTotalRep() + a3, a22.getId());
                mapleFamilyCharacter = a22;
            }
            return mapleFamilyCharacter.getSeniorId();
        }
        return 0;
    }

    public /* synthetic */ boolean isProper() {
        MapleFamily a2;
        return a2.a;
    }

    public final /* synthetic */ int getId() {
        MapleFamily a2;
        return a2.B;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ boolean splitFamily(int a222, MapleFamilyCharacter a3) {
        MapleFamily a4;
        Object a222 = a4.getMFC(a222);
        if (a222 == null && (a222 = a3) == null) {
            return false;
        }
        try {
            Object object;
            a3 = ((MapleFamilyCharacter)a222).getAllJuniors(a4);
            if (a3.size() <= 1) {
                a4.leaveFamily((MapleFamilyCharacter)a222, false);
                boolean bl = true;
                return bl;
            }
            int n2 = MapleFamily.createFamily(((MapleFamilyCharacter)a222).getId());
            if (n2 <= 0) {
                boolean a222 = false;
                return a222;
            }
            Object object2 = a222 = a3.iterator();
            while (object2.hasNext()) {
                object = (MapleFamilyCharacter)a222.next();
                object2 = a222;
                int n3 = n2;
                ((MapleFamilyCharacter)object).setFamilyId(n3);
                MapleFamily.setOfflineFamilyStatus(n3, ((MapleFamilyCharacter)object).getSeniorId(), ((MapleFamilyCharacter)object).getJunior1(), ((MapleFamilyCharacter)object).getJunior2(), ((MapleFamilyCharacter)object).getCurrentRep(), ((MapleFamilyCharacter)object).getTotalRep(), ((MapleFamilyCharacter)object).getId());
                a4.e.remove(((MapleFamilyCharacter)object).getId());
            }
            a222 = World.Family.getFamily(n2);
            object = a3.iterator();
            while (object.hasNext()) {
                a3 = (MapleFamilyCharacter)object.next();
                if (((MapleFamilyCharacter)a3).isOnline()) {
                    World.Family.setFamily(n2, ((MapleFamilyCharacter)a3).getSeniorId(), ((MapleFamilyCharacter)a3).getJunior1(), ((MapleFamilyCharacter)a3).getJunior2(), ((MapleFamilyCharacter)a3).getCurrentRep(), ((MapleFamilyCharacter)a3).getTotalRep(), ((MapleFamilyCharacter)a3).getId());
                }
                ((MapleFamily)a222).setOnline(((MapleFamilyCharacter)a3).getId(), ((MapleFamilyCharacter)a3).isOnline(), ((MapleFamilyCharacter)a3).getChannel());
            }
        }
        finally {
            if (a4.e.size() <= 1) {
                World.Family.disbandFamily(a4.B);
                return true;
            }
        }
        a4.d = true;
        return false;
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ Collection<MapleFamily> loadAll() {
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

    public final /* synthetic */ void leaveFamily(MapleFamilyCharacter a2, boolean a32) {
        MapleFamily mapleFamily;
        MapleFamily a4;
        a4.d = true;
        if (a2.getId() == a4.k && !a32) {
            MapleFamily mapleFamily2 = a4;
            mapleFamily = mapleFamily2;
            mapleFamily2.E = null;
            World.Family.disbandFamily(mapleFamily2.B);
        } else {
            if (a2.getJunior1() > 0 && (a32 = a4.getMFC(a2.getJunior1())) != null) {
                MapleFamilyCharacter mapleFamilyCharacter = a32;
                mapleFamilyCharacter.setSeniorId(0);
                a4.splitFamily(mapleFamilyCharacter.getId(), a32);
            }
            if (a2.getJunior2() > 0 && (a32 = a4.getMFC(a2.getJunior2())) != null) {
                MapleFamilyCharacter mapleFamilyCharacter = a32;
                mapleFamilyCharacter.setSeniorId(0);
                a4.splitFamily(mapleFamilyCharacter.getId(), a32);
            }
            if (a2.getSeniorId() > 0 && (a32 = a4.getMFC(a2.getSeniorId())) != null) {
                if (a32.getJunior1() == a2.getId()) {
                    a32.setJunior1(0);
                } else {
                    a32.setJunior2(0);
                }
            }
            ArrayList<Integer> a32 = new ArrayList<Integer>();
            MapleFamily mapleFamily3 = a4;
            a32.add(a2.getId());
            mapleFamily = mapleFamily3;
            mapleFamily3.broadcast(null, -1, FCOp.DISBAND, a32);
            mapleFamily3.resetPedigree();
        }
        mapleFamily.e.remove(a2.getId());
        a4.d = true;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ int createFamily(int a2) {
        int n2;
        block12: {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            DruidPooledConnection druidPooledConnection;
            block10: {
                int n3;
                block11: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    preparedStatement = druidPooledConnection.prepareStatement(EmojiFilter.ALLATORIxDEMO("J\u0002P\tQ\u0018#\u0005M\u0018Lle-n%o%f?#dc f-g)q%g,*lU\rO\u0019F\u001f#d<e"), 1);
                    preparedStatement.setInt(1, a2);
                    preparedStatement.executeUpdate();
                    resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()) break block10;
                    resultSet.close();
                    preparedStatement.close();
                    n3 = 0;
                    if (druidPooledConnection == null) break block11;
                    druidPooledConnection.close();
                }
                return n3;
            }
            ResultSet resultSet2 = resultSet;
            n2 = resultSet2.getInt(1);
            resultSet2.close();
            preparedStatement.close();
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
                    catch (Exception exception) {
                        return 0;
                    }
                }
            }
            druidPooledConnection.close();
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void deleteFamily(int a) {
        var2_2 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var3_4 = var2_2.prepareStatement(EmojiFilter.ALLATORIxDEMO("\bF\u0000F\u0018FlE\u001eL\u0001#*b!j j)plT\u0004F\u001eFle-n%o5j(#q#s"));
            var3_4.setInt(1, a);
            var3_4.execute();
            ** if (var2_2 == null) goto lbl-1000
        }
        catch (Throwable var3_5) {
            if (var2_2 == null) ** GOTO lbl21
            try {
                var2_2.close();
                v0 = var3_5;
                ** GOTO lbl22
            }
            catch (Throwable var4_6) {
                try {
                    var3_5.addSuppressed(var4_6);
lbl21:
                    // 2 sources

                    v0 = var3_5;
lbl22:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var2_3) {
                    System.out.println("\u89e3\u6563\u65cf\u5931\u6557 " + var2_3);
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
        System.out.println("\u522a\u9664\u5bb6\u65cf: " + a + " \u6210\u529f!");
    }

    private final /* synthetic */ void ALLATORIxDEMO() {
        MapleFamily a2;
        if (!a2.d) {
            return;
        }
        Iterator<Map.Entry<Integer, MapleFamilyCharacter>> iterator = a2.e.entrySet().iterator();
        block0: while (true) {
            Iterator<Map.Entry<Integer, MapleFamilyCharacter>> iterator2 = iterator;
            while (iterator2.hasNext()) {
                MapleFamilyCharacter mapleFamilyCharacter = iterator.next().getValue();
                if (mapleFamilyCharacter.getJunior1() > 0 && a2.getMFC(mapleFamilyCharacter.getJunior1()) == null) {
                    mapleFamilyCharacter.setJunior1(0);
                }
                if (mapleFamilyCharacter.getJunior2() > 0 && a2.getMFC(mapleFamilyCharacter.getJunior2()) == null) {
                    mapleFamilyCharacter.setJunior2(0);
                }
                if (mapleFamilyCharacter.getSeniorId() > 0 && a2.getMFC(mapleFamilyCharacter.getSeniorId()) == null) {
                    mapleFamilyCharacter.setSeniorId(0);
                }
                if (mapleFamilyCharacter.getFamilyId() == a2.B) continue block0;
                Iterator<Map.Entry<Integer, MapleFamilyCharacter>> iterator3 = iterator;
                iterator2 = iterator3;
                iterator3.remove();
            }
            break;
        }
        if (a2.e.size() < 2 && World.Family.getFamily(a2.B) != null) {
            World.Family.disbandFamily(a2.B);
        }
        a2.d = false;
    }

    public final /* synthetic */ void leaveFamily(int a2) {
        MapleFamily a3;
        MapleFamily mapleFamily = a3;
        mapleFamily.leaveFamily(mapleFamily.getMFC(a2), true);
    }

    public /* synthetic */ void resetGens() {
        MapleFamily a2;
        MapleFamily mapleFamily = a2;
        MapleFamilyCharacter mapleFamilyCharacter = mapleFamily.getMFC(mapleFamily.k);
        if (mapleFamilyCharacter != null) {
            a2.K = mapleFamilyCharacter.resetGenerations(a2);
        }
        a2.d = true;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void writeToDB(boolean a) {
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

    public /* synthetic */ Collection<MapleFamilyCharacter> getMembers() {
        MapleFamily a2;
        return a2.e.values();
    }

    public /* synthetic */ int getMemberSize() {
        MapleFamily a2;
        return a2.e.size();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void setOfflineFamilyStatus(int a, int a, int a, int a, int a, int a, int a) {
        var7_8 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var8_10 = var7_8.prepareStatement(KoreanDateUtil.ALLATORIxDEMO("/F>W.SZu\u0012w\bw\u0019b\u001fd\t6)S.6\u001cw\u0017\u007f\u0016o\u0013rZ+Z)V6\ts\u0014\u007f\u0015d\u0013rZ+Z)V6\u0010c\u0014\u007f\u0015dK6G6E:Z|\u000fx\u0013y\b$Z+Z)V6\u0019c\bd\u001fx\u000ed\u001ffZ+Z)V6\u000ey\u000ew\u0016d\u001ffZ+Z)ZA2S(SZ\u007f\u001e6G6E"));
            v1 = var8_10;
            v2 = var8_10;
            var8_10.setInt(1, a);
            v2.setInt(2, a);
            v2.setInt(3, a);
            v1.setInt(4, a);
            v1.setInt(5, a);
            v0.setInt(6, a);
            var8_10.setInt(7, a);
            v0.execute();
            var8_10.close();
            ** if (var7_8 == null) goto lbl-1000
        }
        catch (Throwable var8_11) {
            if (var7_8 == null) ** GOTO lbl31
            try {
                var7_8.close();
                v3 = var8_11;
                ** GOTO lbl32
            }
            catch (Throwable a) {
                try {
                    var8_11.addSuppressed(a);
lbl31:
                    // 2 sources

                    v3 = var8_11;
lbl32:
                    // 2 sources

                    throw v3;
                }
                catch (SQLException var7_9) {
                    System.err.println("SQLException: " + var7_9.getLocalizedMessage());
                    var7_9.printStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var7_8.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public final /* synthetic */ void setNotice(String a2) {
        MapleFamily a3;
        MapleFamily mapleFamily = a3;
        mapleFamily.ALLATORIxDEMO = true;
        mapleFamily.g = a2;
    }

    public final /* synthetic */ String getNotice() {
        MapleFamily a2;
        if (a2.g == null) {
            return "";
        }
        return a2.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ MapleFamily(int a2) {
        MapleFamily a3;
        MapleFamily mapleFamily = a3;
        MapleFamily mapleFamily2 = a3;
        MapleFamily mapleFamily3 = a3;
        a3.e = new ConcurrentHashMap<Integer, MapleFamilyCharacter>();
        a3.E = null;
        mapleFamily2.K = 0;
        mapleFamily2.a = true;
        mapleFamily.d = false;
        mapleFamily.ALLATORIxDEMO = false;
        try {
            DruidPooledConnection druidPooledConnection;
            block26: {
                ResultSet resultSet;
                PreparedStatement preparedStatement;
                block25: {
                    druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    preparedStatement = druidPooledConnection.prepareStatement(KoreanDateUtil.ALLATORIxDEMO(")S6S9BZ<ZP(Y76\u001cw\u0017\u007f\u0016\u007f\u001feZA2S(SZp\u001b{\u0013z\u0003\u007f\u001e6G6E"));
                    preparedStatement.setInt(1, a2);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.first()) break block25;
                    resultSet.close();
                    preparedStatement.close();
                    a3.B = -1;
                    if (druidPooledConnection == null) return;
                    druidPooledConnection.close();
                    return;
                }
                ResultSet resultSet2 = resultSet;
                a3.B = a2;
                a3.k = resultSet2.getInt(EmojiFilter.ALLATORIxDEMO("o)b(f>j("));
                a3.g = resultSet2.getString(KoreanDateUtil.ALLATORIxDEMO("x\u0015b\u0013u\u001f"));
                resultSet.close();
                preparedStatement.close();
                preparedStatement = druidPooledConnection.prepareStatement(EmojiFilter.ALLATORIxDEMO("P\tO\t@\u0018#%g`#\"b!f`# f:f /li#a`#?f\"j#q%g`#&v\"j#q}/li9m%l>1`#/v>q)m8q)s`#8l8b q)slE\u001eL\u0001#/k-q-`8f>plT\u0004F\u001eFle-n%o5j(#q#s"));
                preparedStatement.setInt(1, a2);
                ResultSet resultSet3 = resultSet = preparedStatement.executeQuery();
                while (resultSet3.next()) {
                    if (resultSet.getInt(KoreanDateUtil.ALLATORIxDEMO("\u007f\u001e")) == a3.k) {
                        a3.E = resultSet.getString(EmojiFilter.ALLATORIxDEMO("m-n)"));
                    }
                    a3.e.put(resultSet.getInt(KoreanDateUtil.ALLATORIxDEMO("\u007f\u001e")), new MapleFamilyCharacter(resultSet.getInt(EmojiFilter.ALLATORIxDEMO("j(")), resultSet.getShort(KoreanDateUtil.ALLATORIxDEMO("\u0016s\fs\u0016")), resultSet.getString(EmojiFilter.ALLATORIxDEMO("m-n)")), -1, resultSet.getInt(KoreanDateUtil.ALLATORIxDEMO("\u0010y\u0018")), a2, resultSet.getInt(EmojiFilter.ALLATORIxDEMO("p)m%l>j(")), resultSet.getInt(KoreanDateUtil.ALLATORIxDEMO("\u0010c\u0014\u007f\u0015dK")), resultSet.getInt(EmojiFilter.ALLATORIxDEMO("&v\"j#q~")), resultSet.getInt(KoreanDateUtil.ALLATORIxDEMO("u\u000fd\bs\u0014b\bs\n")), resultSet.getInt(EmojiFilter.ALLATORIxDEMO("w#w-o>f<")), false));
                    resultSet3 = resultSet;
                }
                resultSet.close();
                preparedStatement.close();
                if (a3.E != null && a3.e.size() >= 2) break block26;
                MapleFamily mapleFamily4 = a3;
                System.err.println("Leader " + mapleFamily4.k + " isn't in family " + mapleFamily4.B + ".  Impossible... family is disbanding.");
                a3.writeToDB(true);
                a3.a = false;
                if (druidPooledConnection == null) return;
                druidPooledConnection.close();
                return;
            }
            try {
                for (MapleFamilyCharacter mapleFamilyCharacter : a3.e.values()) {
                    MapleFamilyCharacter mapleFamilyCharacter2;
                    if (mapleFamilyCharacter.getJunior1() > 0 && (a3.getMFC(mapleFamilyCharacter.getJunior1()) == null || mapleFamilyCharacter.getId() == mapleFamilyCharacter.getJunior1())) {
                        mapleFamilyCharacter.setJunior1(0);
                    }
                    if (mapleFamilyCharacter.getJunior2() > 0 && (a3.getMFC(mapleFamilyCharacter.getJunior2()) == null || mapleFamilyCharacter.getId() == mapleFamilyCharacter.getJunior2() || mapleFamilyCharacter.getJunior1() == mapleFamilyCharacter.getJunior2())) {
                        mapleFamilyCharacter.setJunior2(0);
                    }
                    if (mapleFamilyCharacter.getSeniorId() > 0 && (a3.getMFC(mapleFamilyCharacter.getSeniorId()) == null || mapleFamilyCharacter.getId() == mapleFamilyCharacter.getSeniorId())) {
                        mapleFamilyCharacter.setSeniorId(0);
                    }
                    if (mapleFamilyCharacter.getJunior2() > 0 && mapleFamilyCharacter.getJunior1() <= 0) {
                        MapleFamilyCharacter mapleFamilyCharacter3 = mapleFamilyCharacter;
                        mapleFamilyCharacter3.setJunior1(mapleFamilyCharacter3.getJunior2());
                        mapleFamilyCharacter3.setJunior2(0);
                    }
                    if (mapleFamilyCharacter.getJunior1() > 0) {
                        mapleFamilyCharacter2 = a3.getMFC(mapleFamilyCharacter.getJunior1());
                        if (mapleFamilyCharacter2.getJunior1() == mapleFamilyCharacter.getId()) {
                            mapleFamilyCharacter2.setJunior1(0);
                        }
                        if (mapleFamilyCharacter2.getJunior2() == mapleFamilyCharacter.getId()) {
                            mapleFamilyCharacter2.setJunior2(0);
                        }
                        if (mapleFamilyCharacter2.getSeniorId() != mapleFamilyCharacter.getId()) {
                            mapleFamilyCharacter2.setSeniorId(mapleFamilyCharacter.getId());
                        }
                    }
                    if (mapleFamilyCharacter.getJunior2() <= 0) continue;
                    mapleFamilyCharacter2 = a3.getMFC(mapleFamilyCharacter.getJunior2());
                    if (mapleFamilyCharacter2.getJunior1() == mapleFamilyCharacter.getId()) {
                        mapleFamilyCharacter2.setJunior1(0);
                    }
                    if (mapleFamilyCharacter2.getJunior2() == mapleFamilyCharacter.getId()) {
                        mapleFamilyCharacter2.setJunior2(0);
                    }
                    if (mapleFamilyCharacter2.getSeniorId() == mapleFamilyCharacter.getId()) continue;
                    mapleFamilyCharacter2.setSeniorId(mapleFamilyCharacter.getId());
                }
                MapleFamily mapleFamily5 = a3;
                mapleFamily5.resetPedigree();
                mapleFamily5.resetDescendants();
                mapleFamily5.resetGens();
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
            System.err.println(KoreanDateUtil.ALLATORIxDEMO("c\u0014w\u0018z\u001f6\u000eyZd\u001fw\u001e6\u001cw\u0017\u007f\u0016oZ\u007f\u0014p\u0015d\u0017w\u000e\u007f\u0015xZp\by\u00176\tg\u0016"));
            sQLException.printStackTrace();
            return;
        }
        catch (StackOverflowError stackOverflowError) {
            System.err.println("StackOverflowError \u5806\u758a\u7570\u5e38 \u5bb6\u65cf\u4ee3\u78bc:" + a3.B + " \u81ea\u52d5\u522a\u9664\u4e2d...");
            MapleFamily mapleFamily6 = a3;
            mapleFamily6.deleteFamily(mapleFamily6.B);
        }
    }

    public final /* synthetic */ void broadcast(byte[] a2, int a3, FCOp a4, List<Integer> a5) {
        MapleFamily a6;
        MapleFamily mapleFamily = a6;
        mapleFamily.ALLATORIxDEMO();
        if (mapleFamily.e.size() < 2) {
            a6.d = true;
            return;
        }
        for (MapleFamilyCharacter mapleFamilyCharacter : a6.e.values()) {
            if (a5 != null && !a5.contains(mapleFamilyCharacter.getId())) continue;
            if (a4 == FCOp.DISBAND) {
                if (mapleFamilyCharacter.isOnline()) {
                    World.Family.setFamily(0, 0, 0, 0, mapleFamilyCharacter.getCurrentRep(), mapleFamilyCharacter.getTotalRep(), mapleFamilyCharacter.getId());
                    continue;
                }
                MapleFamily.setOfflineFamilyStatus(0, 0, 0, 0, mapleFamilyCharacter.getCurrentRep(), mapleFamilyCharacter.getTotalRep(), mapleFamilyCharacter.getId());
                continue;
            }
            if (!mapleFamilyCharacter.isOnline() || mapleFamilyCharacter.getId() == a3) continue;
            World.Broadcast.sendFamilyPacket(mapleFamilyCharacter.getId(), a2, a3, a6.B);
        }
    }

    public final /* synthetic */ void setOnline(int a2, boolean a3, int a4) {
        MapleFamily a5;
        MapleFamilyCharacter mapleFamilyCharacter = a5.getMFC(a2);
        if (mapleFamilyCharacter != null && mapleFamilyCharacter.getFamilyId() == a5.B) {
            if (mapleFamilyCharacter.isOnline() != a3) {
                a5.broadcast(FamilyPacket.familyLoggedIn(a3, mapleFamilyCharacter.getName()), a2, mapleFamilyCharacter.getId() == a5.k ? null : mapleFamilyCharacter.getPedigree());
            }
            mapleFamilyCharacter.setOnline(a3);
            mapleFamilyCharacter.setChannel((byte)a4);
        }
        a5.d = true;
    }

    public final /* synthetic */ MapleFamilyCharacter getMFC(int a2) {
        MapleFamily a3;
        return a3.e.get(a2);
    }

    public final /* synthetic */ void memberLevelJobUpdate(MapleCharacter a2) {
        MapleFamily a3;
        MapleFamilyCharacter mapleFamilyCharacter = a3.getMFC(a2.getId());
        if (mapleFamilyCharacter != null) {
            MapleFamilyCharacter mapleFamilyCharacter2 = mapleFamilyCharacter;
            MapleFamilyCharacter mapleFamilyCharacter3 = mapleFamilyCharacter;
            int n2 = mapleFamilyCharacter3.getLevel();
            int n3 = mapleFamilyCharacter3.getJobId();
            mapleFamilyCharacter2.setJobId(a2.getJob());
            mapleFamilyCharacter2.setLevel(a2.getLevel());
            if (n2 != a2.getLevel()) {
                a3.broadcast(MaplePacketCreator.sendLevelup(true, a2.getLevel(), a2.getName()), a2.getId(), a2.getId() == a3.k ? null : mapleFamilyCharacter.getPedigree());
            }
            if (n3 != a2.getJob()) {
                a3.broadcast(MaplePacketCreator.sendJobup(true, a2.getJob(), a2.getName()), a2.getId(), a2.getId() == a3.k ? null : mapleFamilyCharacter.getPedigree());
            }
        }
    }

    public final /* synthetic */ void disbandFamily() {
        MapleFamily a2;
        a2.writeToDB(true);
    }

    public /* synthetic */ void resetDescendants() {
        MapleFamily a2;
        MapleFamily mapleFamily = a2;
        MapleFamilyCharacter mapleFamilyCharacter = mapleFamily.getMFC(mapleFamily.k);
        if (mapleFamilyCharacter != null) {
            mapleFamilyCharacter.resetDescendants(a2);
        }
        a2.d = true;
    }

    public /* synthetic */ int getGens() {
        MapleFamily a2;
        return a2.K;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
        int cfr_ignored_0 = 5 << 4 ^ 5;
        int n5 = n3;
        int n6 = 4 << 4;
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

    public final /* synthetic */ String getLeaderName() {
        MapleFamily a2;
        return a2.E;
    }

    public final /* synthetic */ void broadcast(byte[] a2, int a3, List<Integer> a4) {
        MapleFamily a5;
        a5.broadcast(a2, a3, FCOp.NONE, a4);
    }

    public static final /* synthetic */ MapleFamily load(int a2) {
        ArrayList arrayList = new ArrayList();
        return new MapleFamily(a2);
    }

    public static /* synthetic */ void mergeFamily(MapleFamily a2, MapleFamily a3) {
        Iterator<MapleFamilyCharacter> iterator;
        Iterator<MapleFamilyCharacter> iterator2 = iterator = a3.e.values().iterator();
        while (iterator2.hasNext()) {
            MapleFamily mapleFamily;
            MapleFamilyCharacter mapleFamilyCharacter = iterator.next();
            mapleFamilyCharacter.setFamilyId(a2.getId());
            if (mapleFamilyCharacter.isOnline()) {
                MapleFamily mapleFamily2 = a2;
                mapleFamily = mapleFamily2;
                World.Family.setFamily(mapleFamily2.getId(), mapleFamilyCharacter.getSeniorId(), mapleFamilyCharacter.getJunior1(), mapleFamilyCharacter.getJunior2(), mapleFamilyCharacter.getCurrentRep(), mapleFamilyCharacter.getTotalRep(), mapleFamilyCharacter.getId());
            } else {
                MapleFamily mapleFamily3 = a2;
                mapleFamily = mapleFamily3;
                MapleFamily.setOfflineFamilyStatus(mapleFamily3.getId(), mapleFamilyCharacter.getSeniorId(), mapleFamilyCharacter.getJunior1(), mapleFamilyCharacter.getJunior2(), mapleFamilyCharacter.getCurrentRep(), mapleFamilyCharacter.getTotalRep(), mapleFamilyCharacter.getId());
            }
            mapleFamily.e.put(mapleFamilyCharacter.getId(), mapleFamilyCharacter);
            a2.setOnline(mapleFamilyCharacter.getId(), mapleFamilyCharacter.isOnline(), mapleFamilyCharacter.getChannel());
            iterator2 = iterator;
        }
        a2.resetPedigree();
        World.Family.disbandFamily(a3.getId());
    }

    public final /* synthetic */ void broadcast(byte[] a2, List<Integer> a3) {
        MapleFamily a4;
        a4.broadcast(a2, -1, FCOp.NONE, a3);
    }

    public final /* synthetic */ MapleFamilyCharacter addFamilyMemberInfo(MapleCharacter a2, int a32, int a4, int a52) {
        MapleFamily a6;
        MapleFamilyCharacter a32 = new MapleFamilyCharacter((MapleCharacter)a2, a6.B, a32, a4, a52);
        a6.e.put(((MapleCharacter)a2).getId(), a32);
        a32.resetPedigree(a6);
        a6.d = true;
        a2 = new ArrayList();
        a4 = 0;
        int n2 = a4;
        while (n2 < a32.getPedigree().size()) {
            if (a32.getPedigree().get(a4).intValue() != a32.getId()) {
                MapleFamilyCharacter a52 = a6.getMFC(a32.getPedigree().get(a4));
                if (a52 == null) {
                    a2.add(a4);
                } else {
                    a52.resetPedigree(a6);
                }
            }
            n2 = ++a4;
        }
        Iterator iterator = a4 = a2.iterator();
        while (iterator.hasNext()) {
            int a52 = (Integer)a4.next();
            iterator = a4;
            a32.getPedigree().remove(a52);
        }
        return a32;
    }

    public final /* synthetic */ int addFamilyMember(MapleFamilyCharacter a2) {
        MapleFamily a3;
        MapleFamily mapleFamily = a3;
        ((MapleFamilyCharacter)a2).setFamilyId(mapleFamily.B);
        mapleFamily.e.put(((MapleFamilyCharacter)a2).getId(), (MapleFamilyCharacter)a2);
        MapleFamilyCharacter mapleFamilyCharacter = a2;
        mapleFamilyCharacter.resetPedigree(a3);
        a3.d = true;
        a2 = mapleFamilyCharacter.getPedigree().iterator();
        Object object = a2;
        while (object.hasNext()) {
            int n2 = (Integer)a2.next();
            object = a2;
            a3.getMFC(n2).resetPedigree(a3);
        }
        return 1;
    }

    public static final class FCOp
    extends Enum<FCOp> {
        private static final /* synthetic */ FCOp[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ FCOp NONE;
        public static final /* synthetic */ /* enum */ FCOp DISBAND;

        public static /* synthetic */ {
            NONE = new FCOp(CommandProcessorUtil.ALLATORIxDEMO("(w(}"), 0);
            DISBAND = new FCOp(MapleCoolDownValueHolder.ALLATORIxDEMO("g\u0012p\u0019b\u0015g"), 1);
            FCOp[] arrfCOp = new FCOp[2];
            arrfCOp[0] = NONE;
            arrfCOp[1] = DISBAND;
            ALLATORIxDEMO = arrfCOp;
        }

        public static /* synthetic */ FCOp[] values() {
            return (FCOp[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ FCOp() {
            void var2_-1;
            void var1_-1;
            FCOp a2;
        }

        public static /* synthetic */ FCOp valueOf(String a2) {
            return Enum.valueOf(FCOp.class, a2);
        }
    }
}

