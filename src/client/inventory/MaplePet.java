/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package client.inventory;

import client.inventory.ItemLoader;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.cashshop.handler.CashShopOperation;
import java.awt.Point;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import server.MapleItemInformationProvider;
import server.MerchItemPackage;
import server.movement.LifeMovementFragment;
import server.movement.StaticLifeMovement;
import tools.ConcurrentEnumMap;
import tools.FilePrinter;
import tools.KoreanDateUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public class MaplePet
implements Serializable {
    private /* synthetic */ int M;
    private /* synthetic */ int J;
    private /* synthetic */ short B;
    private /* synthetic */ int F;
    private final /* synthetic */ int D;
    private /* synthetic */ int[] d;
    private /* synthetic */ int i;
    private /* synthetic */ short K;
    private /* synthetic */ String h;
    private /* synthetic */ int I;
    private static final /* synthetic */ long f = 9179541993413738569L;
    private /* synthetic */ byte e;
    private /* synthetic */ byte H;
    private /* synthetic */ Point C;
    private /* synthetic */ short g;
    private final /* synthetic */ int L;
    private /* synthetic */ byte ALLATORIxDEMO;
    private /* synthetic */ int j;
    private /* synthetic */ boolean a;
    private /* synthetic */ byte E;
    private /* synthetic */ short k;

    public final /* synthetic */ void setCanPickup(short a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.K = a2;
        maplePet.a = true;
    }

    public /* synthetic */ int[] getExcludedArrays() {
        MaplePet a2;
        return (int[])a2.d.clone();
    }

    private /* synthetic */ MaplePet(int a2, int a3) {
        MaplePet a4;
        MaplePet maplePet = a4;
        MaplePet maplePet2 = a4;
        MaplePet maplePet3 = a4;
        MaplePet maplePet4 = a4;
        MaplePet maplePet5 = a4;
        MaplePet maplePet6 = a4;
        MaplePet maplePet7 = a4;
        MaplePet maplePet8 = a4;
        MaplePet maplePet9 = a4;
        maplePet9.j = 0;
        maplePet9.i = 0;
        maplePet8.J = 0;
        maplePet8.M = 0;
        maplePet7.I = 0;
        maplePet7.F = -1;
        maplePet6.H = (byte)100;
        maplePet6.e = 1;
        maplePet5.E = 0;
        maplePet5.g = 0;
        maplePet4.B = 0;
        maplePet4.k = 0;
        maplePet3.K = 1;
        maplePet3.a = false;
        maplePet2.d = new int[10];
        maplePet2.ALLATORIxDEMO = 0;
        maplePet.L = a2;
        maplePet.D = a3;
        int n2 = a2 = 0;
        while (n2 < a4.d.length) {
            a4.d[a2++] = 0;
            n2 = a2;
        }
    }

    public final /* synthetic */ void setSummoned(int a2) {
        a.E = (byte)a2;
    }

    public final /* synthetic */ int getStance() {
        MaplePet a2;
        return a2.i;
    }

    public final /* synthetic */ void setCloseness(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.B = (short)a2;
        maplePet.a = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void saveToDb() {
        DruidPooledConnection druidPooledConnection;
        DruidPooledConnection druidPooledConnection2;
        block18: {
            block17: {
                StringBuilder stringBuilder;
                PreparedStatement preparedStatement;
                MaplePet a2;
                if (!a2.a) {
                    return;
                }
                try {
                    druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        preparedStatement = druidPooledConnection2.prepareStatement(ConcurrentEnumMap.ALLATORIxDEMO(";\t*\u0018:\u001cN)\u000b-\u001dy=\u001c:y\u00008\u0003<NdNfBy\u0002<\u0018<\u0002ySyQuN:\u00026\u001d<\u0000<\u001d*NdNfBy\b,\u00025\u0000<\u001d*NdNfBy\u001d<\r6\u0000=\u001dySyQuN?\u00028\t*NdNfBy\u000b!\r5\u001b=\u000b=NdNfNuN*\u001e<\u000b=NdNfBy\f,\b?\u001d2\u00075\u00020\nySyQuN:\u000f7>0\r2;)NdNfBy\u001d2\u00075\u00020\nySyQy9\u0011+\u000b+y\u001e<\u001a0\nySyQ"));
                        try {
                            int n2;
                            PreparedStatement preparedStatement2 = preparedStatement;
                            PreparedStatement preparedStatement3 = preparedStatement;
                            preparedStatement.setString(1, a2.h);
                            preparedStatement3.setByte(2, a2.e);
                            preparedStatement3.setShort(3, a2.B);
                            preparedStatement2.setByte(4, a2.H);
                            preparedStatement2.setInt(5, a2.J);
                            preparedStatement.setShort(6, a2.k);
                            stringBuilder = new StringBuilder();
                            int n3 = n2 = 0;
                            while (n3 < a2.d.length) {
                                stringBuilder.append(a2.d[n2]);
                                stringBuilder.append(KoreanDateUtil.ALLATORIxDEMO("V"));
                                n3 = ++n2;
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
                    FilePrinter.printError(ConcurrentEnumMap.ALLATORIxDEMO("\u0014\u000f)\u0002<><\u001aw\u001a!\u001a"), sQLException, KoreanDateUtil.ALLATORIxDEMO("e\u001b`\u001fB\u0015R\u0018"));
                    return;
                }
                {
                    String string = stringBuilder.toString();
                    PreparedStatement preparedStatement4 = preparedStatement;
                    PreparedStatement preparedStatement5 = preparedStatement;
                    PreparedStatement preparedStatement6 = preparedStatement;
                    String string2 = string;
                    preparedStatement6.setString(7, string2.substring(0, string2.length() - 1));
                    preparedStatement6.setInt(8, a2.ALLATORIxDEMO);
                    preparedStatement5.setInt(9, a2.I);
                    preparedStatement5.setShort(10, a2.K);
                    preparedStatement4.setInt(11, a2.M);
                    preparedStatement4.setInt(12, a2.D);
                    preparedStatement4.executeUpdate();
                    a2.a = false;
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

    public final /* synthetic */ int getPetItemId() {
        MaplePet a2;
        return a2.L;
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(ConcurrentEnumMap.ALLATORIxDEMO("dzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMSMyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNzdzNyNyNyNyMzNzNyNzNyNyMzNzMzNzMzNzMyNzMzNyNyNyNyMSMyNyNyNyMyMyMyNyMyNyMyMyNzNyMyMyMyMyNzNyNyNyNyNzdzNyNyNyNzMzNzNyNzNyNzMzNyMyNzNzNzMyNyMyNyNyNyNyMSMyNyNyNyMyMyMzMyMzMyMyMyNzNyMzMyMyMyMzMyNyNyNyNzdzNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyMSMy!;\b,\u001d:\u000f-\u00076\u0000y\f N\u0018\u00025\u000f-\u0001+\u0007y!;\b,\u001d:\u000f-\u0001+N/Yw]y*\u001c#\u0016NzdzNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyMSMyNyNyNyNyNy\u0006-\u001a)TvA.\u0019.@8\u00025\u000f-\u0001+\u0007w\r6\u0003yNyNyNyNyNyNzdzNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyNyMSMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzd"));
        MaplePet.clearPet();
    }

    public final /* synthetic */ void setName(String a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.h = a2;
        maplePet.a = true;
    }

    public final /* synthetic */ short getInventoryPosition() {
        MaplePet a2;
        return a2.g;
    }

    public final /* synthetic */ byte getLevel() {
        MaplePet a2;
        return a2.e;
    }

    public final /* synthetic */ void setFh(int a2) {
        a.j = a2;
    }

    public /* synthetic */ int getSkill() {
        MaplePet a2;
        return a2.M;
    }

    public final /* synthetic */ byte getFullness() {
        MaplePet a2;
        return a2.H;
    }

    public /* synthetic */ void setSkill(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.M = a2;
        maplePet.a = true;
    }

    public final /* synthetic */ void updatePosition(List<LifeMovementFragment> a2) {
        a2 = a2.iterator();
        while (a2.hasNext()) {
            MaplePet a3;
            Point point;
            LifeMovementFragment lifeMovementFragment = (LifeMovementFragment)a2.next();
            if (!(lifeMovementFragment instanceof StaticLifeMovement) || (point = lifeMovementFragment.getPosition()) == null) continue;
            MaplePet maplePet = a3;
            maplePet.setPos(point);
            maplePet.setStance(((StaticLifeMovement)lifeMovementFragment).getNewstate());
        }
    }

    public final /* synthetic */ short getFlags() {
        MaplePet a2;
        return a2.k;
    }

    public final /* synthetic */ void setPos(Point a2) {
        a.C = a2;
    }

    public final /* synthetic */ short getCloseness() {
        MaplePet a2;
        return a2.B;
    }

    public final /* synthetic */ boolean getSummoned() {
        MaplePet a2;
        return a2.E > 0;
    }

    public final /* synthetic */ void saveToDb(Connection a22) {
        StringBuilder stringBuilder;
        MaplePet a3;
        if (!a3.a) {
            return;
        }
        try {
            int n2;
            AutoCloseable autoCloseable = a22 = a22.prepareStatement(ConcurrentEnumMap.ALLATORIxDEMO(";\t*\u0018:\u001cN)\u000b-\u001dy=\u001c:y\u00008\u0003<NdNfBy\u0002<\u0018<\u0002ySyQuN:\u00026\u001d<\u0000<\u001d*NdNfBy\b,\u00025\u0000<\u001d*NdNfBy\u001d<\r6\u0000=\u001dySyQuN?\u00028\t*NdNfBy\u000b!\r5\u001b=\u000b=NdNfNuN*\u001e<\u000b=NdNfBy\f,\b?\u001d2\u00075\u00020\nySyQuN:\u000f7>0\r2;)NdNfBy\u001d2\u00075\u00020\nySyQy9\u0011+\u000b+y\u001e<\u001a0\nySyQ"));
            AutoCloseable autoCloseable2 = a22;
            AutoCloseable autoCloseable3 = a22;
            autoCloseable3.setString(1, a3.h);
            autoCloseable3.setByte(2, a3.e);
            autoCloseable2.setShort(3, a3.B);
            autoCloseable2.setByte(4, a3.H);
            autoCloseable.setInt(5, a3.J);
            autoCloseable.setShort(6, a3.k);
            stringBuilder = new StringBuilder();
            int n3 = n2 = 0;
            while (n3 < a3.d.length) {
                stringBuilder.append(a3.d[n2]);
                stringBuilder.append(KoreanDateUtil.ALLATORIxDEMO("V"));
                n3 = ++n2;
            }
        }
        catch (SQLException a22) {
            FilePrinter.printError(ConcurrentEnumMap.ALLATORIxDEMO("\u0014\u000f)\u0002<><\u001aw\u001a!\u001a"), a22, KoreanDateUtil.ALLATORIxDEMO("e\u001b`\u001fB\u0015R\u0018"));
            return;
        }
        String string = stringBuilder.toString();
        AutoCloseable autoCloseable = a22;
        AutoCloseable autoCloseable4 = a22;
        AutoCloseable autoCloseable5 = a22;
        String string2 = string;
        autoCloseable5.setString(7, string2.substring(0, string2.length() - 1));
        autoCloseable5.setInt(8, a3.ALLATORIxDEMO);
        autoCloseable4.setInt(9, a3.I);
        autoCloseable4.setShort(10, a3.K);
        autoCloseable.setInt(11, a3.M);
        autoCloseable.setInt(12, a3.D);
        autoCloseable.executeUpdate();
        a22.close();
        a3.a = false;
    }

    public final /* synthetic */ void setSpeed(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.ALLATORIxDEMO = (byte)a2;
        maplePet.a = true;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = 5 << 4 ^ (3 ^ 5) << 1;
        int n5 = n3;
        int n6 = (2 ^ 5) << 3 ^ 4;
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

    public final /* synthetic */ String getName() {
        MaplePet a2;
        if (a2.h == null) {
            MaplePet maplePet = a2;
            maplePet.setName(MapleItemInformationProvider.getInstance().getName(maplePet.L));
        }
        return a2.h;
    }

    public final /* synthetic */ void setLevel(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.e = (byte)a2;
        maplePet.a = true;
    }

    private /* synthetic */ MaplePet(int a2, int a3, short a4) {
        MaplePet a5;
        MaplePet maplePet = a5;
        MaplePet maplePet2 = a5;
        MaplePet maplePet3 = a5;
        MaplePet maplePet4 = a5;
        MaplePet maplePet5 = a5;
        MaplePet maplePet6 = a5;
        MaplePet maplePet7 = a5;
        MaplePet maplePet8 = a5;
        MaplePet maplePet9 = a5;
        a5.j = 0;
        maplePet9.i = 0;
        maplePet9.J = 0;
        maplePet8.M = 0;
        maplePet8.I = 0;
        maplePet7.F = -1;
        maplePet7.H = (byte)100;
        maplePet6.e = 1;
        maplePet6.E = 0;
        maplePet5.g = 0;
        maplePet5.B = 0;
        maplePet4.k = 0;
        maplePet4.K = 1;
        maplePet3.a = false;
        maplePet3.d = new int[10];
        maplePet2.ALLATORIxDEMO = 0;
        maplePet2.L = a2;
        maplePet.D = a3;
        maplePet.g = a4;
        int n2 = a2 = 0;
        while (n2 < a5.d.length) {
            a5.d[a2++] = 0;
            n2 = a2;
        }
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ MaplePet createPet(int a, String a, int a, int a, int a, int a, int a, short a) {
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

    public final /* synthetic */ boolean canConsume(int a22) {
        Iterator<Integer> a22 = MapleItemInformationProvider.getInstance().petsCanConsume(a22).iterator();
        while (a22.hasNext()) {
            MaplePet a3;
            if (a22.next() != a3.L) continue;
            return true;
        }
        return false;
    }

    public /* synthetic */ void setColor(int a2) {
        a.F = a2;
    }

    public final /* synthetic */ Point getPos() {
        MaplePet a2;
        return a2.C;
    }

    public final /* synthetic */ byte getSpeed() {
        MaplePet a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void setFlags(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.k = (short)a2;
        maplePet.a = true;
    }

    public final /* synthetic */ void setLimitedLife(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.J = a2;
        maplePet.a = true;
    }

    public final /* synthetic */ int getSecondsLeft() {
        MaplePet a2;
        return a2.J;
    }

    public final /* synthetic */ void setInventoryPosition(short a2) {
        a.g = a2;
    }

    public final /* synthetic */ void setStance(int a2) {
        a.i = a2;
    }

    public final /* synthetic */ byte getSummonedValue() {
        MaplePet a2;
        return a2.E;
    }

    public /* synthetic */ int getBuffSkill() {
        MaplePet a2;
        return a2.I;
    }

    public static final /* synthetic */ MaplePet createPet(int a2, int a3) {
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        int n2 = a2;
        return MaplePet.createPet(n2, mapleItemInformationProvider.getName(n2), 1, 0, 100, a3, mapleItemInformationProvider.getPetLimitLife(a2), mapleItemInformationProvider.getPetFlagInfo(a2));
    }

    public /* synthetic */ int getColor() {
        MaplePet a2;
        return a2.F;
    }

    public /* synthetic */ List<Integer> getExcluded() {
        MaplePet a2;
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = n2 = 0;
        while (n3 < a2.d.length) {
            if (a2.d[n2] > 0 && PetFlag.UNPICKABLE.check(a2.k)) {
                arrayList.add(a2.d[n2]);
            }
            n3 = ++n2;
        }
        return arrayList;
    }

    public final /* synthetic */ int getFh() {
        MaplePet a2;
        return a2.j;
    }

    public /* synthetic */ void setExcluded(List<Integer> a2) {
        int n2;
        MaplePet a3;
        if (a2.size() > a3.d.length) {
            return;
        }
        int n3 = a3.d.length - a2.size();
        int n4 = n2 = 0;
        while (n4 < n3) {
            a2.add(0);
            n4 = ++n2;
        }
        a3.setExcluded(a2.stream().mapToInt(Integer::intValue).toArray());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void clearPet() {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(KoreanDateUtil.ALLATORIxDEMO("E?Z?U.6P6<D5[Zf\u001fb\t"));
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            n2 = resultSet.getInt(ConcurrentEnumMap.ALLATORIxDEMO("\u001e<\u001a0\n"));
            if (ItemLoader.isExistsByUniqueid(n2)) continue;
            preparedStatement = druidPooledConnection.prepareStatement(KoreanDateUtil.ALLATORIxDEMO("R?Z?B?6<D5[Zf\u001fb\t6-^?D?6\ns\u000e\u007f\u001e6G6E"));
            preparedStatement.setInt(1, n2);
            preparedStatement.executeUpdate();
            System.err.println("\u5bf5\u7269\uff1a" + resultSet.getString(ConcurrentEnumMap.ALLATORIxDEMO("7\u000f4\u000b")) + " petid: " + n2 + " \u4e0d\u5b58\u5728, \u6e05\u7406\u3002");
        }
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
                                v0 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v0 = throwable;
                    }
                    throw v0;
                }
                catch (SQLException sQLException) {
                    System.err.println(KoreanDateUtil.ALLATORIxDEMO("M7w\nz\u001fF\u001fb'6\u5fe4\u656e\u64a0\u5ebd\u4e57\u52b6\u8f73\u5be3\u7213\u8a1c\u6015\u51ec\u9355"));
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ MaplePet loadFromDb(int a, int a, short a) {
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

    public /* synthetic */ void setBuffSkill(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.I = a2;
        maplePet.a = true;
    }

    public /* synthetic */ void setExcluded(int[] a2) {
        MaplePet a3;
        if (a2.length != a3.d.length || Arrays.equals(a2, a3.d)) {
            return;
        }
        a3.d = (int[])a2.clone();
        a3.a = true;
    }

    public /* synthetic */ int getUniqueId() {
        MaplePet a2;
        return a2.D;
    }

    public /* synthetic */ String getPetKey() {
        MaplePet a2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append(a2.h);
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(a2.e);
        stringBuilder3.append(a2.B);
        stringBuilder.append(a2.H);
        stringBuilder.append(a2.J);
        stringBuilder.append(a2.k);
        stringBuilder.append(a2.d);
        stringBuilder.append(a2.ALLATORIxDEMO);
        stringBuilder.append(a2.I);
        stringBuilder.append(a2.K);
        stringBuilder.append(a2.M);
        stringBuilder.append(a2.D);
        return stringBuilder3.toString();
    }

    public final /* synthetic */ short isCanPickup() {
        MaplePet a2;
        return a2.K;
    }

    public final /* synthetic */ void setFullness(int a2) {
        MaplePet a3;
        MaplePet maplePet = a3;
        maplePet.H = (byte)a2;
        maplePet.a = true;
    }

    public static final class PetFlag
    extends Enum<PetFlag> {
        public static final /* synthetic */ /* enum */ PetFlag PET_CURE;
        public static final /* synthetic */ /* enum */ PetFlag EXPAND_PICKUP;
        public static final /* synthetic */ /* enum */ PetFlag AUTO_PICKUP;
        public static final /* synthetic */ /* enum */ PetFlag PET_DRAW;
        public static final /* synthetic */ /* enum */ PetFlag PET_BUFF;
        public static final /* synthetic */ /* enum */ PetFlag PET_DIALOGUE;
        private final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ PetFlag AUTO_FEED_MOVE;
        public static final /* synthetic */ /* enum */ PetFlag UNPICKABLE;
        public static final /* synthetic */ /* enum */ PetFlag MP_CHARGE;
        private final /* synthetic */ int K;
        public static final /* synthetic */ /* enum */ PetFlag HP_CHARGE;
        private static final /* synthetic */ PetFlag[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ PetFlag LEFTOVER_PICKUP;
        public static final /* synthetic */ /* enum */ PetFlag ITEM_PICKUP;
        private final /* synthetic */ int a;

        public final /* synthetic */ boolean check(int a2) {
            PetFlag a3;
            return (a2 & a3.K) == a3.K;
        }

        public static final /* synthetic */ PetFlag getByAddId(int a2) {
            int n2;
            PetFlag[] arrpetFlag = PetFlag.values();
            int n3 = arrpetFlag.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                PetFlag petFlag = arrpetFlag[n2];
                if (petFlag.a == a2) {
                    return petFlag;
                }
                n4 = ++n2;
            }
            return null;
        }

        public final /* synthetic */ int getValue() {
            PetFlag a2;
            return a2.K;
        }

        public static /* synthetic */ PetFlag valueOf(String a2) {
            return Enum.valueOf(PetFlag.class, a2);
        }

        public static /* synthetic */ PetFlag[] values() {
            return (PetFlag[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ {
            ITEM_PICKUP = new PetFlag(CashShopOperation.ALLATORIxDEMO("/b#{9f/u-c6"), 0, 1, 5190000, 5191000);
            EXPAND_PICKUP = new PetFlag(MerchItemPackage.ALLATORIxDEMO("qtdmzhk|}o\u007fyd"), 1, 2, 5190002, 5191002);
            AUTO_PICKUP = new PetFlag(CashShopOperation.ALLATORIxDEMO("'c2y9f/u-c6"), 2, 4, 5190003, 5191003);
            UNPICKABLE = new PetFlag(MerchItemPackage.ALLATORIxDEMO("yz|}o\u007fmv`q"), 3, 8, 5190005, -1);
            LEFTOVER_PICKUP = new PetFlag(CashShopOperation.ALLATORIxDEMO("*s b)`#d9f/u-c6"), 4, 16, 5190004, 5191004);
            HP_CHARGE = new PetFlag(MerchItemPackage.ALLATORIxDEMO("||ko|mfkq"), 5, 32, 5190001, 5191001);
            MP_CHARGE = new PetFlag(CashShopOperation.ALLATORIxDEMO("+f9u.w4q#"), 6, 64, 5190006, -1);
            PET_DRAW = new PetFlag(MerchItemPackage.ALLATORIxDEMO("|qxkhfmc"), 7, 128, 5190007, -1);
            PET_DIALOGUE = new PetFlag(CashShopOperation.ALLATORIxDEMO("f#b9r/w*y!c#"), 8, 256, 5190008, -1);
            PET_BUFF = new PetFlag(MerchItemPackage.ALLATORIxDEMO("|qxknajr"), 9, 512, 5190010, -1);
            PET_CURE = new PetFlag(CashShopOperation.ALLATORIxDEMO("f#b9u3d#"), 10, 1024, 5190009, -1);
            AUTO_FEED_MOVE = new PetFlag(MerchItemPackage.ALLATORIxDEMO("max{sriqhka{zq"), 11, 2048, 5190011, -1);
            PetFlag[] arrpetFlag = new PetFlag[12];
            arrpetFlag[0] = ITEM_PICKUP;
            arrpetFlag[1] = EXPAND_PICKUP;
            arrpetFlag[2] = AUTO_PICKUP;
            arrpetFlag[3] = UNPICKABLE;
            arrpetFlag[4] = LEFTOVER_PICKUP;
            arrpetFlag[5] = HP_CHARGE;
            arrpetFlag[6] = MP_CHARGE;
            arrpetFlag[7] = PET_DRAW;
            arrpetFlag[8] = PET_DIALOGUE;
            arrpetFlag[9] = PET_BUFF;
            arrpetFlag[10] = PET_CURE;
            arrpetFlag[11] = AUTO_FEED_MOVE;
            ALLATORIxDEMO = arrpetFlag;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ PetFlag(int n22, int n22, int a2) {
            void a3;
            void a4;
            void var2_-1;
            void var1_-1;
            PetFlag a5;
            PetFlag petFlag = a5;
            a5.K = a2;
            petFlag.a = a4;
            petFlag.d = a3;
        }

        public static final /* synthetic */ PetFlag getByDelId(int a2) {
            int n2;
            PetFlag[] arrpetFlag = PetFlag.values();
            int n3 = arrpetFlag.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                PetFlag petFlag = arrpetFlag[n2];
                if (petFlag.d == a2) {
                    return petFlag;
                }
                n4 = ++n2;
            }
            return null;
        }
    }
}

