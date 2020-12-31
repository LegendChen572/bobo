/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.inventory.MapleInventoryIdentifier;
import database.DBConPool;
import database.DatabaseConnection;
import handling.channel.handler.AllianceHandler;
import handling.world.family.MapleFamily;
import java.awt.Point;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.StructAndroid;
import server.maps.MapNameData;
import server.movement.AbsoluteLifeMovement;
import server.movement.LifeMovement;
import server.movement.LifeMovementFragment;
import tools.FileoutputUtil;
import tools.npcgenerator.Instruction;

public class MapleAndroid
implements Serializable {
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int e;
    private /* synthetic */ int k;
    private /* synthetic */ Point d;
    private static final /* synthetic */ long F = 9179541993413738569L;
    private /* synthetic */ int C;
    private /* synthetic */ int B;
    private /* synthetic */ int H;
    private /* synthetic */ String a;
    private /* synthetic */ int K;
    private /* synthetic */ int g;
    private /* synthetic */ int E;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ 3;
        int cfr_ignored_0 = 4 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 2 << 3 ^ (2 ^ 5);
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

    public /* synthetic */ int getGender() {
        MapleAndroid a2;
        return a2.K;
    }

    public final /* synthetic */ int getFace() {
        MapleAndroid a2;
        return a2.B;
    }

    public static final /* synthetic */ MapleAndroid create(int a2, int a3, int a4, int a5, int a6) {
        Object object;
        if (a3 <= -1) {
            a3 = MapleInventoryIdentifier.getInstance();
        }
        try {
            object = DatabaseConnection.getConnection().prepareStatement(MapleFamily.ALLATORIxDEMO("'\u000e=\u0005<\u0014N\t \u0014!`\u000f.\n2\u0001)\n3Nh\u001b.\u00071\u001b%\u0007$B`\u001d+\u0007.B`\u0006!\u00072B`\b!\r%B`\u0000!\u0003%G`8\u0001\"\u0015+\u0013NhQlN\u007fB`QlN\u007fB`Qi"));
            PreparedStatement preparedStatement = object;
            PreparedStatement preparedStatement2 = object;
            object.setInt(1, a3);
            preparedStatement2.setInt(2, a4);
            preparedStatement2.setInt(3, a5);
            preparedStatement.setInt(4, a6);
            object.setString(5, AllianceHandler.ALLATORIxDEMO("\u6a4f\u565e\u4eaa"));
            preparedStatement.executeUpdate();
            object.close();
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return null;
        }
        Object object2 = object = new MapleAndroid(a2, a3);
        Object object3 = object;
        ((MapleAndroid)object3).setSkin(a4);
        ((MapleAndroid)object3).setHair(a5);
        ((MapleAndroid)object2).setFace(a6);
        ((MapleAndroid)object2).setName(MapleFamily.ALLATORIxDEMO("\u0001\u0000$\u001c/\u0007$"));
        return object2;
    }

    public /* synthetic */ int getUniqueId() {
        MapleAndroid a2;
        return a2.H;
    }

    public /* synthetic */ void setGender(int a2) {
        MapleAndroid a3;
        MapleAndroid mapleAndroid = a3;
        mapleAndroid.K = a2;
        mapleAndroid.ALLATORIxDEMO = true;
    }

    public final /* synthetic */ void setPos(Point a2) {
        a.d = a2;
    }

    public final /* synthetic */ void setHair(int a2) {
        MapleAndroid a3;
        MapleAndroid mapleAndroid = a3;
        mapleAndroid.g = a2;
        mapleAndroid.ALLATORIxDEMO = true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ MapleAndroid create(int a, int a) {
        v0 = MapleItemInformationProvider.getInstance();
        var2_2 = v0.getAndroidType(a);
        var3_3 = v0.getAndroidInfo(var2_2);
        if (var3_3 == null) {
            return null;
        }
        v1 = var3_3;
        var4_5 = v1.gender;
        var5_6 = v1.skin.get(Randomizer.nextInt(var3_3.skin.size()));
        v2 = var3_3;
        var6_7 = v2.hair.get(Randomizer.nextInt(v2.hair.size()));
        v3 = var3_3;
        var3_4 = v3.face.get(Randomizer.nextInt(v3.face.size()));
        if (a <= -1) {
            a = MapleInventoryIdentifier.getInstance();
        }
        var7_8 = AllianceHandler.ALLATORIxDEMO("\u5b99\u5365\u6a4f\u565e\u4eaa");
        var8_9 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v4 = var9_11 = var8_9.prepareStatement(MapleFamily.ALLATORIxDEMO("'\u000e=\u0005<\u0014N\t \u0014!`\u000f.\n2\u0001)\n3Nh\u001b.\u00071\u001b%\u0007$B`\u001a9\u001e%B`\t%\u0000$\u000b2B`\u001d+\u0007.B`\u0006!\u00072B`\b!\r%B`\u0000!\u0003%G`8\u0001\"\u0015+\u0013NhQlN\u007fB`QlN\u007fB`QlN\u007fB`Qi"));
            v5 = var9_11;
            v6 = var9_11;
            var9_11.setInt(1, a);
            v6.setInt(2, var2_2);
            v6.setInt(3, var4_5);
            v5.setInt(4, var5_6);
            v5.setInt(5, var6_7);
            v4.setInt(6, var3_4);
            var9_11.setString(7, var7_8);
            v4.executeUpdate();
            var9_11.close();
            ** if (var8_9 == null) goto lbl-1000
        }
        catch (Throwable var9_12) {
            try {
                block11: {
                    if (var8_9 != null) {
                        try {
                            var8_9.close();
                            v7 = var9_12;
                            break block11;
                        }
                        catch (Throwable var10_13) {
                            var9_12.addSuppressed(var10_13);
                        }
                    }
                    v7 = var9_12;
                }
                throw v7;
            }
            catch (SQLException var8_10) {
                FileoutputUtil.printError(AllianceHandler.ALLATORIxDEMO("{qF|SQXtD\u007f_t\u0018dNd"), var8_10, "itemid:" + a + " uniqueid:" + a);
                System.err.println("\u5275\u7acb\u6a5f\u5668\u4eba\u51fa\u73fe\u932f\u8aa4: " + var8_10.getMessage());
                return null;
            }
        }
lbl-1000:
        // 1 sources

        {
            var8_9.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        v8 = var8_9 = new MapleAndroid(a, a);
        v9 = var8_9;
        v10 = var8_9;
        v10.setType(var2_2);
        v10.setGender(var4_5);
        v9.setSkin(var5_6);
        v9.setHair(var6_7);
        v8.setFace(var3_4);
        v8.setName(var7_8);
        return v8;
    }

    public /* synthetic */ int getType() {
        MapleAndroid a2;
        return a2.k;
    }

    public final /* synthetic */ void updatePosition(List<LifeMovementFragment> a2) {
        a2 = a2.iterator();
        while (a2.hasNext()) {
            MapleAndroid a3;
            LifeMovementFragment lifeMovementFragment = (LifeMovementFragment)a2.next();
            if (!(lifeMovementFragment instanceof LifeMovement)) continue;
            if (lifeMovementFragment instanceof AbsoluteLifeMovement) {
                a3.setPos(((LifeMovement)lifeMovementFragment).getPosition());
            }
            a3.setStance(((LifeMovement)lifeMovementFragment).getNewstate());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ MapleAndroid loadFromDb(int a2, int a32) {
        try {
            MapleAndroid mapleAndroid = new MapleAndroid(a2, a32);
            PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(AllianceHandler.ALLATORIxDEMO("Cs\\sSb0\u001c0pBy]\u0016qXtD\u007f_tE0aXsBs0C~_aCu_t\u0016-\u0016/"));
            preparedStatement.setInt(1, a32);
            ResultSet a32 = preparedStatement.executeQuery();
            if (!a32.next()) {
                a32.close();
                preparedStatement.close();
                return null;
            }
            ResultSet resultSet = a32;
            int n2 = resultSet.getInt(MapleFamily.ALLATORIxDEMO("\u001a9\u001e%"));
            int n3 = resultSet.getInt(AllianceHandler.ALLATORIxDEMO("QuXtSb"));
            boolean bl = false;
            if (n2 < 1) {
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                n2 = mapleItemInformationProvider.getAndroidType(a2);
                StructAndroid structAndroid = mapleItemInformationProvider.getAndroidInfo(n2);
                if (structAndroid == null) {
                    return null;
                }
                n3 = structAndroid.gender;
                bl = true;
            }
            MapleAndroid mapleAndroid2 = mapleAndroid;
            ResultSet resultSet2 = a32;
            MapleAndroid mapleAndroid3 = mapleAndroid;
            mapleAndroid.setType(n2);
            mapleAndroid3.setGender(n3);
            mapleAndroid3.setSkin(a32.getInt(MapleFamily.ALLATORIxDEMO("\u001d+\u0007.")));
            mapleAndroid.setHair(resultSet2.getInt(AllianceHandler.ALLATORIxDEMO("^q_b")));
            mapleAndroid2.setFace(resultSet2.getInt(MapleFamily.ALLATORIxDEMO("\b!\r%")));
            mapleAndroid2.setName(a32.getString(AllianceHandler.ALLATORIxDEMO("Xq[u")));
            mapleAndroid.ALLATORIxDEMO = false;
            a32.close();
            preparedStatement.close();
            return mapleAndroid;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            return null;
        }
    }

    public final /* synthetic */ void setStance(int a2) {
        a.C = a2;
    }

    public /* synthetic */ void setName(String a2) {
        MapleAndroid a3;
        MapleAndroid mapleAndroid = a3;
        mapleAndroid.a = a2;
        mapleAndroid.ALLATORIxDEMO = true;
    }

    public final /* synthetic */ int getSkin() {
        MapleAndroid a2;
        return a2.E;
    }

    public /* synthetic */ String getName() {
        MapleAndroid a2;
        return a2.a;
    }

    public /* synthetic */ void setType(int a2) {
        MapleAndroid a3;
        MapleAndroid mapleAndroid = a3;
        mapleAndroid.k = a2;
        mapleAndroid.ALLATORIxDEMO = true;
    }

    public final /* synthetic */ int getHair() {
        MapleAndroid a2;
        return a2.g;
    }

    public final /* synthetic */ void setSkin(int a2) {
        MapleAndroid a3;
        MapleAndroid mapleAndroid = a3;
        mapleAndroid.E = a2;
        mapleAndroid.ALLATORIxDEMO = true;
    }

    public final /* synthetic */ Point getPos() {
        MapleAndroid a2;
        return a2.d;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void saveToDb() {
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

    public final /* synthetic */ void setFace(int a2) {
        MapleAndroid a3;
        MapleAndroid mapleAndroid = a3;
        mapleAndroid.B = a2;
        mapleAndroid.ALLATORIxDEMO = true;
    }

    public final /* synthetic */ int getStance() {
        MapleAndroid a2;
        return a2.C;
    }

    private /* synthetic */ MapleAndroid(int a2, int a3) {
        MapleAndroid a4;
        MapleAndroid mapleAndroid = a4;
        MapleAndroid mapleAndroid2 = a4;
        mapleAndroid2.C = 0;
        MapleAndroid mapleAndroid3 = a4;
        mapleAndroid2.d = new Point(0, 0);
        mapleAndroid2.ALLATORIxDEMO = false;
        mapleAndroid.e = a2;
        mapleAndroid.H = a3;
    }

    public final /* synthetic */ int getItemId() {
        MapleAndroid a2;
        return a2.e;
    }

    public static final class AndroidFlag
    extends Enum<AndroidFlag> {
        public static final /* synthetic */ /* enum */ AndroidFlag TOP_PANTS;
        public static final /* synthetic */ /* enum */ AndroidFlag SHOES;
        public static final /* synthetic */ /* enum */ AndroidFlag HAT;
        public static final /* synthetic */ /* enum */ AndroidFlag FACE;
        public static final /* synthetic */ /* enum */ AndroidFlag CAPE;
        private final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ AndroidFlag GLOVES;
        public static final /* synthetic */ /* enum */ AndroidFlag OVERALL;
        public static final /* synthetic */ /* enum */ AndroidFlag DEFAULT;
        private static final /* synthetic */ AndroidFlag[] ALLATORIxDEMO;

        public final /* synthetic */ int getValue() {
            AndroidFlag a2;
            return a2.d;
        }

        public static /* synthetic */ AndroidFlag valueOf(String a2) {
            return Enum.valueOf(AndroidFlag.class, a2);
        }

        public static /* synthetic */ AndroidFlag[] values() {
            return (AndroidFlag[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ AndroidFlag(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            AndroidFlag a3;
            a3.d = a2;
        }

        public static /* synthetic */ {
            HAT = new AndroidFlag(Instruction.ALLATORIxDEMO(")[5"), 0, 1);
            CAPE = new AndroidFlag(MapNameData.ALLATORIxDEMO("S\u0004@\u0000"), 1, 2);
            FACE = new AndroidFlag(Instruction.ALLATORIxDEMO("\\ Y$"), 2, 4);
            OVERALL = new AndroidFlag(MapNameData.ALLATORIxDEMO("\nF\u0000B\u0004\\\t"), 3, 8);
            TOP_PANTS = new AndroidFlag(Instruction.ALLATORIxDEMO("5U1E1[/N2"), 4, 16);
            SHOES = new AndroidFlag(MapNameData.ALLATORIxDEMO("\u0016X\nU\u0016"), 5, 32);
            GLOVES = new AndroidFlag(Instruction.ALLATORIxDEMO("]-U7_2"), 6, 64);
            DEFAULT = new AndroidFlag(MapNameData.ALLATORIxDEMO("\u0001U\u0003Q\u0010\\\u0011"), 7, 128);
            AndroidFlag[] arrandroidFlag = new AndroidFlag[8];
            arrandroidFlag[0] = HAT;
            arrandroidFlag[1] = CAPE;
            arrandroidFlag[2] = FACE;
            arrandroidFlag[3] = OVERALL;
            arrandroidFlag[4] = TOP_PANTS;
            arrandroidFlag[5] = SHOES;
            arrandroidFlag[6] = GLOVES;
            arrandroidFlag[7] = DEFAULT;
            ALLATORIxDEMO = arrandroidFlag;
        }
    }
}

