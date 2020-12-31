/*
 * Decompiled with CFR 0.150.
 */
package tools.wztosql;

import client.inventory.MapleAndroid;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import database.DatabaseConnection;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.Extend.SpecialItemData;
import server.MapleItemInformationProvider;
import tools.StringTool;

public class DumpCashShop {
    private static final /* synthetic */ MapleDataProvider d;
    private static /* synthetic */ List<Integer> ALLATORIxDEMO;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean cleanDuplicateItem() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 25[WHILELOOP]
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void main(String[] a) throws IOException {
        System.out.println(SpecialItemData.ALLATORIxDEMO("9\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\"\u0010\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\u000b9\u000b\u0013\b\u0013\b\u0013\b\u0013\b\u0010\u000b\u0013\u000b\u0013\b\u0013\u000b\u0013\b\u0013\b\u0010\u000b\u0013\u000b\u0010\u000b\u0013\u000b\u0010\u000b\u0013\u000b\u0010\b\u0013\u000b\u0010\u000b\u0013\b\u0013\b\u0013\b\u0013\b\u0010\"\u0010\b\u0013\b\u0013\b\u0013\b\u0010\b\u0010\b\u0010\b\u0013\b\u0010\b\u0013\b\u0010\b\u0010\b\u0013\u000b\u0013\b\u0010\b\u0010\b\u0010\b\u0010\b\u0013\u000b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\u000b9\u000b\u0013\b\u0013\b\u0013\b\u0013\u000b\u0010\u000b\u0013\u000b\u0013\b\u0013\u000b\u0013\b\u0013\u000b\u0010\u000b\u0013\b\u0010\b\u0013\u000b\u0013\u000b\u0013\u000b\u0010\b\u0013\b\u0010\b\u0013\b\u0013\b\u0013\b\u0013\b\u0010\"\u0010\b\u0013\b\u0013\b\u0013\b\u0010\b\u0010\b\u0010\u000b\u0010\b\u0010\u000b\u0010\b\u0010\b\u0010\b\u0013\u000b\u0013\b\u0010\u000b\u0010\b\u0010\b\u0010\b\u0010\u000b\u0010\b\u0013\b\u0013\b\u0013\b\u0013\u000b9\u000b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0010\"\u0010\b|JU]@KR\\ZG]\bQQ\u0013i_DR\\\\ZZ\b|JU]@KR\\\\Z\u0013^\u0004\u0006\u0000\bwm~g\u0013\u000b9\u000b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0010\"\u0010\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b[\\GX\t\u0007\u001c_D_\u001dI_DR\\\\ZZ\u0006PG^\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\u000b9\u000b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0013\b\u0010\"\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b\u0010\u000b9"));
        GameSetConstants.loadsetting();
        GameSetConstants.reloadset();
        if (a == null) {
            DumpCashShop.deleteOldCashItems();
        }
        MapleItemInformationProvider.getInstance().loadEtc(false);
        MapleItemInformationProvider.getInstance().loadItems(false);
        var1_1 = new HashMap<Integer, ArrayList<E>>();
        var2_2 = new ArrayList<Integer>();
        var3_3 = 0;
        var4_4 = 0;
        var5_5 = 0;
        DumpCashShop.ALLATORIxDEMO.clear();
        var6_6 = DumpCashShop.d.getData(MapleAndroid.ALLATORIxDEMO("T\u001cz\u001ex\u0017~\u0007n]~\u001ep")).iterator();
        block6: while (true) {
            v0 = var6_6;
            while (true) {
                if (!v0.hasNext()) {
                    System.out.println(var3_3 + " " + var4_4 + " " + var5_5);
                    return;
                }
                ++var3_3;
                var7_8 = (MapleData)var6_6.next();
                var8_11 = MapleDataTool.getIntConvert(SpecialItemData.ALLATORIxDEMO("aGM^aW"), var7_8, 0);
                var9_13 = MapleDataTool.getIntConvert(MapleAndroid.ALLATORIxDEMO(" Y"), var7_8, 0);
                var10_14 = MapleDataTool.getIntConvert(SpecialItemData.ALLATORIxDEMO("pGFFG"), var7_8, 0);
                var11_15 = MapleDataTool.getIntConvert(MapleAndroid.ALLATORIxDEMO("G\u0001~\u0010r"), var7_8, 0);
                var12_16 = MapleDataTool.getIntConvert(SpecialItemData.ALLATORIxDEMO("xAA\\ZZ\\J"), var7_8, 0);
                var13_17 = MapleDataTool.getIntConvert(MapleAndroid.ALLATORIxDEMO("#r\u0001~\u001cs"), var7_8, 0);
                var14_18 = MapleDataTool.getIntConvert(SpecialItemData.ALLATORIxDEMO("oVFWMA"), var7_8, -1);
                var15_19 = MapleDataTool.getIntConvert(MapleAndroid.ALLATORIxDEMO("<y v\u001fr"), var7_8, -1);
                var7_9 = MapleDataTool.getIntConvert(SpecialItemData.ALLATORIxDEMO("eV[\\"), var7_8, 0);
                if (GameSetConstants.MAPLE_VERSION < 136 && var9_13 / 10000000 == 1) {
                    System.out.println("[\u63a8\u8350\u5546\u54c1] SN :" + var9_13 + " \u7269\u54c1\u4ee3\u78bc :" + var8_11 + " \u671f\u9650 : " + var13_17 + " \u6953\u5e63: " + var7_9 + " \u662f\u9ede\u88dd: ");
                    v0 = var6_6;
                    continue;
                }
                if (GameSetConstants.MAPLE_VERSION < 136 && var2_2.contains(var8_11)) {
                    v0 = var6_6;
                    continue;
                }
                if (DumpCashShop.ALLATORIxDEMO.contains(var8_11)) {
                    v0 = var6_6;
                    continue;
                }
                if (var8_11 < 2000000) {
                    DumpCashShop.ALLATORIxDEMO.add(var8_11);
                }
                if (var8_11 == 0) {
                    v0 = var6_6;
                    continue;
                }
                if (var9_13 >= 70000000) {
                    v0 = var6_6;
                    continue;
                }
                var15_19 = var8_11 / 10000;
                if (var1_1.get(var15_19) == null) {
                    var1_1.put(var15_19, new ArrayList<E>());
                }
                var16_21 = true;
                var17_23 = false;
                if (var7_9 <= 0 || GameConstants.getInventoryType(var8_11) == MapleInventoryType.EQUIP && !MapleItemInformationProvider.getInstance().isCash(var8_11)) {
                    var17_23 = true;
                    var16_21 = false;
                }
                if (GameConstants.getInventoryType(var8_11) != MapleInventoryType.EQUIP || var13_17 <= 0 || var9_13 < 20000000) {
                    var17_23 = true;
                }
                if (var17_23 && var16_21) {
                    System.out.println(MapleItemInformationProvider.getInstance().getName(var8_11) + " \u671f\u9650 : " + var13_17 + " \u6953\u5e63: " + var7_9 + " \u662f\u9ede\u88dd: " + var16_21);
                }
                if (!MapleItemInformationProvider.getInstance().itemExists(var8_11)) {
                    ++var4_4;
                    System.out.println("[\u4e0d\u5b58\u5728] SN :" + var9_13 + " \u7269\u54c1\u4ee3\u78bc :" + var8_11 + " \u671f\u9650 : " + var13_17 + " \u6953\u5e63: " + var7_9 + " \u662f\u9ede\u88dd: " + var16_21);
                    v0 = var6_6;
                    continue;
                }
                if (a == null) ** GOTO lbl77
                if (a[0] == "update") {
                    DumpCashShop.deleteCashShopItem(var9_13);
                    v1 = var2_2;
                } else {
                    if (a[0] == "renew" && DumpCashShop.CashShopItemExists(var9_13)) {
                        v0 = var6_6;
                        continue;
                    }
lbl77:
                    // 3 sources

                    v1 = var2_2;
                }
                v1.add(var8_11);
                try {
                    var16_20 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        ++var5_5;
                        v2 = var18_24 = var16_20.prepareStatement(MapleAndroid.ALLATORIxDEMO("^=D6E'7:Y'XSt\u0012d\u001bd\u001bx\u0003H\u001ac\u0016z\u00007[D=;SX\u001dd\u0012{\u0016;:c\u0016z\u001as_g\u0001~\u001ce\u001ac\n;\u0003r\u0001~\u001cs_p\u0016y\u0017r\u0001;\u0010x\u0006y\u0007;\u001er\u0000x_G\u0001~\u0010r_z\u0012e\u0018;Sb\u001d|,&_7\u0006y\u0018HA;Sb\u001d|,$_7=x\u0007r_G\u0012t\u0018v\u0014r_T\u001fv\u0000dZ7%V?B6DS?S(_7L;S(_7L;S(_7L;S(_7L;S(_7L;S(_7L;S(_7L;S(_7L>"));
                        v3 = var18_24;
                        v4 = var18_24;
                        v5 = var18_24;
                        v6 = var18_24;
                        v7 = var18_24;
                        var18_24.setInt(1, var9_13);
                        v7.setInt(2, 1);
                        v7.setInt(3, var8_11);
                        v6.setInt(4, var12_16);
                        v6.setInt(5, var13_17);
                        v5.setInt(6, var14_18);
                        v5.setInt(7, var10_14);
                        v4.setInt(8, var7_9);
                        v4.setInt(9, var11_15);
                        v3.setInt(10, 0);
                        v3.setInt(11, 0);
                        v2.setInt(12, 0);
                        v2.setInt(13, 0);
                        var7_7 = SpecialItemData.ALLATORIxDEMO("ffd\u007f");
                        if (MapleItemInformationProvider.getInstance().getName(var8_11) != null && StringTool.isNormalName(MapleItemInformationProvider.getInstance().getName(var8_11))) {
                            var7_7 = MapleItemInformationProvider.getInstance().getName(var8_11);
                            v8 = var18_24;
                        } else {
                            var7_7 = Integer.toString(var8_11);
                            v8 = var18_24;
                        }
                        v8.setString(14, var7_7);
                        v9 = var18_24;
                        v9.setInt(15, 0);
                        v9.setInt(16, -1);
                        v10 = var18_24;
                        v9.executeUpdate();
                        v10.toString();
                        var9_12 = v10.toString().split(MapleAndroid.ALLATORIxDEMO("-"))[1].trim() + ";";
                        ((List)var1_1.get(var15_19)).add("-- " + MapleItemInformationProvider.getInstance().getName(var8_11) + "\n" + var9_12);
                        var18_24.close();
                        if (var16_20 == null) continue block6;
                    }
                    catch (Throwable var18_25) {
                        if (var16_20 != null) {
                            try {
                                var16_20.close();
                                v11 = var18_25;
                                throw v11;
                            }
                            catch (Throwable var7_10) {
                                var18_25.addSuppressed(var7_10);
                            }
                        }
                        v11 = var18_25;
                        throw v11;
                    }
                    var16_20.close();
                    continue block6;
                }
                catch (Exception var16_22) {
                    v0 = var6_6;
                    var16_22.printStackTrace();
                    continue;
                }
                break;
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void deleteOldCashItems() {
        System.out.println(SpecialItemData.ALLATORIxDEMO("\u0005\u001e\u0005\u95b8\u59e3\u5219\u964c\u5575\u57e6\u9060\u515f\u001e\u0005\u001e"));
        var0 = DatabaseConnection.getConnection();
        var1_2 = MapleAndroid.ALLATORIxDEMO("\u0017r\u001fr\u0007rSq\u0001x\u001e7\u0010v\u0000\u007f\u0000\u007f\u001cg,~\u0007r\u001ed");
        var1_2 = var0.prepareStatement((String)var1_2);
        try {
            var1_2.executeUpdate();
            System.out.println(SpecialItemData.ALLATORIxDEMO("\u0005\u001e\u0005\u5219\u964c\u5575\u57e6\u9060\u515f\u5bbf\u754a\u001e\u0005\u001e"));
            ** if (var1_2 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_2 == null) ** GOTO lbl24
            try {
                var1_2.close();
                v0 = var2_4;
                ** GOTO lbl25
            }
            catch (Throwable var1_3) {
                try {
                    var2_4.addSuppressed(var1_3);
lbl24:
                    // 2 sources

                    v0 = var2_4;
lbl25:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    System.err.println(var0_1);
                    System.out.println(MapleAndroid.ALLATORIxDEMO("^:^\u523d\u9617\u5551\u57bd\u9044\u5104\u5926\u6524:^:"));
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_2.close();
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
    public static /* synthetic */ void deleteCashShopItem(int a) {
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
        d = MapleDataProviderFactory.getDataProvider(MapleAndroid.ALLATORIxDEMO("6c\u00109\u0004m"));
        ALLATORIxDEMO = new LinkedList<Integer>();
    }

    public /* synthetic */ DumpCashShop() {
        DumpCashShop a2;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean CashShopItemExists(int a) {
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
}

