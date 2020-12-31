/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.wztosql;

import client.inventory.EquipAdditions;
import client.inventory.MapleInventoryType;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataEntity;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.Extend.SpecialEquipData;
import server.life.Element;
import server.swing.Progressbar;
import tools.Eval;
import tools.FileoutputUtil;
import tools.Pair;

public class DumpItemsAdditions {
    private final /* synthetic */ MapleDataProvider g;
    public final /* synthetic */ Set<Integer> doneIds;
    private static /* synthetic */ Thread d;
    public final /* synthetic */ MapleData petStringData;
    public final /* synthetic */ MapleData cashStringData;
    private static /* synthetic */ Thread K;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ MapleDataProvider E;
    public final /* synthetic */ MapleData insStringData;
    private final /* synthetic */ MapleDataProvider B;
    public /* synthetic */ int id;
    private static /* synthetic */ Thread a;
    public final /* synthetic */ MapleData etcStringData;
    public /* synthetic */ boolean OnlyItem;
    private static /* synthetic */ Thread k;
    public final /* synthetic */ MapleData eqpStringData;
    public /* synthetic */ boolean hadError;
    public final /* synthetic */ MapleData consumeStringData;

    public /* synthetic */ boolean isHadError() {
        DumpItemsAdditions a2;
        return a2.hadError;
    }

    public /* synthetic */ DumpItemsAdditions(boolean a2) throws Exception {
        DumpItemsAdditions a3;
        DumpItemsAdditions dumpItemsAdditions = a3;
        DumpItemsAdditions dumpItemsAdditions2 = a3;
        DumpItemsAdditions dumpItemsAdditions3 = a3;
        DumpItemsAdditions dumpItemsAdditions4 = a3;
        DumpItemsAdditions dumpItemsAdditions5 = a3;
        dumpItemsAdditions4.B = MapleDataProviderFactory.getDataProvider(SpecialEquipData.ALLATORIxDEMO("\u007fM^PB^\u0002NV"));
        dumpItemsAdditions4.cashStringData = dumpItemsAdditions5.B.getData(Eval.ALLATORIxDEMO("\u001c%,,q-2#"));
        dumpItemsAdditions4.consumeStringData = dumpItemsAdditions4.B.getData(SpecialEquipData.ALLATORIxDEMO("oVBJYTI\u0017ETK"));
        dumpItemsAdditions4.eqpStringData = dumpItemsAdditions4.B.getData(Eval.ALLATORIxDEMO("\u0001.4q-2#"));
        dumpItemsAdditions4.etcStringData = dumpItemsAdditions4.B.getData(SpecialEquipData.ALLATORIxDEMO("iMO\u0017ETK"));
        dumpItemsAdditions4.insStringData = dumpItemsAdditions4.B.getData(Eval.ALLATORIxDEMO("\r17q-2#"));
        dumpItemsAdditions3.petStringData = dumpItemsAdditions4.B.getData(SpecialEquipData.ALLATORIxDEMO("|\\X\u0017ETK"));
        DumpItemsAdditions dumpItemsAdditions6 = a3;
        dumpItemsAdditions3.doneIds = new LinkedHashSet<Integer>();
        dumpItemsAdditions3.ALLATORIxDEMO = true;
        dumpItemsAdditions2.hadError = false;
        dumpItemsAdditions2.OnlyItem = false;
        dumpItemsAdditions.id = false ? 1 : 0;
        dumpItemsAdditions.OnlyItem = a2;
        a3.E = MapleDataProviderFactory.getDataProvider(Eval.ALLATORIxDEMO("\r+!2j(>"));
        a3.g = MapleDataProviderFactory.getDataProvider(SpecialEquipData.ALLATORIxDEMO("zDX^XOMIK\u0002NV"));
        if (a3.E == null || a3.B == null || a3.g == null) {
            a3.hadError = true;
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void dumpItems() throws Exception {
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
    public /* synthetic */ void delete(String a) throws Exception {
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

    public /* synthetic */ String dumpItemData(MapleData a2) throws Exception {
        DumpItemsAdditions a3;
        block9: {
            try {
                if (!a2.getName().endsWith(Eval.ALLATORIxDEMO("q-2#"))) break block9;
                a3.id = Integer.parseInt(a2.getName().substring(0, a2.getName().length() - 4));
            }
            catch (NumberFormatException numberFormatException) {
                return "";
            }
        }
        a3.id = Integer.parseInt(a2.getName());
        DumpItemsAdditions dumpItemsAdditions = a3;
        if (dumpItemsAdditions.doneIds.contains(dumpItemsAdditions.id) || GameConstants.getInventoryType(a3.id) == MapleInventoryType.UNDEFINED) {
            return "";
        }
        DumpItemsAdditions dumpItemsAdditions2 = a3;
        dumpItemsAdditions2.doneIds.add(dumpItemsAdditions2.id);
        DumpItemsAdditions dumpItemsAdditions3 = a3;
        Object object = dumpItemsAdditions3.getStringData(dumpItemsAdditions3.id);
        String string = object == null ? SpecialEquipData.ALLATORIxDEMO("wCWI") : MapleDataTool.getString(Eval.ALLATORIxDEMO("1%2!"), (MapleData)object, "");
        Progressbar.setText("\u8f49\u5b58\u9053\u5177[" + string + "(" + a3.id + ")]...");
        MapleData mapleData = a2;
        a2 = mapleData.getChildByPath(SpecialEquipData.ALLATORIxDEMO("PB_C\u0016_UCMaXT"));
        a2 = mapleData.getChildByPath(Eval.ALLATORIxDEMO("-1\"0k> ;-+-0*"));
        object = new StringBuilder();
        if (a2 != null) {
            for (MapleData mapleData2 : a2.getChildren()) {
                EquipAdditions equipAdditions = EquipAdditions.fromString(mapleData2.getName());
                if (equipAdditions != null) {
                    Object object2;
                    Pair<Integer, Integer> pair = null;
                    if (equipAdditions.isElement()) {
                        String string2;
                        String string3 = string2 = MapleDataTool.getString(equipAdditions.getValue1(), mapleData2, SpecialEquipData.ALLATORIxDEMO("j\n\u001c"));
                        pair = new Pair<Integer, Integer>(Element.getFromChar(string2.charAt(0)).getValue(), Integer.parseInt(string3.substring(1, string3.length())));
                        object2 = object;
                    } else {
                        pair = new Pair<Integer, Integer>(MapleDataTool.getIntConvert(equipAdditions.getValue1(), mapleData2, 0), MapleDataTool.getIntConvert(equipAdditions.getValue2(), mapleData2, 0));
                        object2 = object;
                    }
                    Pair<Integer, Integer> pair2 = pair;
                    ((StringBuilder)object2).append("\u7269\u54c1\u4ee3\u78bc:" + a3.id + " \u7269\u54c1\u540d\u7a31: " + string + " key: " + mapleData2.getName() + "value1: " + pair2.left + " value2:" + pair2.right + "\r\n");
                    continue;
                }
                System.out.println("UNKNOWN EQ ADDITION : " + mapleData2.getName() + " from " + a3.id);
            }
        }
        return ((StringBuilder)object).toString();
    }

    public /* synthetic */ void dumpItems(PreparedStatement a2) throws Exception {
        DumpItemsAdditions a3;
        Progressbar.setText(SpecialEquipData.ALLATORIxDEMO("\u6e3c\u742a\u6541\u64f6\u5e92\u0002\u0017\u0002"));
        if (!a3.OnlyItem) {
            a3.delete(Eval.ALLATORIxDEMO("\u001b\u0001\u0013\u0001\u000b\u0001\u007f\u0002\r\u000b\u0012d(>\u0000-+!2%; ;%+%"));
            System.out.println(SpecialEquipData.ALLATORIxDEMO("\u6e29\u7a43\u000eNVfEMITM]H]MMM\u001b\u5e87b\u5144\u90d1q\u6229\u52b3"));
        }
        System.out.println(Eval.ALLATORIxDEMO("\u6b3c\u576c\u6da4\u52e4\u906df(>\u0000-+!2 >0>f\u5ef4jqjqj"));
        DumpItemsAdditions dumpItemsAdditions = a3;
        dumpItemsAdditions.dumpItems(dumpItemsAdditions.E, a2, false);
        if (!dumpItemsAdditions.OnlyItem) {
            DumpItemsAdditions dumpItemsAdditions2 = a3;
            dumpItemsAdditions2.dumpItems(dumpItemsAdditions2.g, a2, true);
        }
        System.out.println(SpecialEquipData.ALLATORIxDEMO("\u5bb5\u623c\u001b[CsPX\\A]MMM\u001b\u5e87\u76bd\u8f65\u5b61\u0000\u0019\u8f65\u5b61\u90a8\u5711\u901e\u8875\u8ae7\u52c6\u95f0\u95b0\u0002\u0017\u0002"));
    }

    public /* synthetic */ void dumpItem(PreparedStatement a2, MapleData a3) throws Exception {
        DumpItemsAdditions dumpItemsAdditions;
        String string;
        DumpItemsAdditions a4;
        block11: {
            try {
                if (!a3.getName().endsWith(Eval.ALLATORIxDEMO("q-2#"))) break block11;
                a4.id = Integer.parseInt(a3.getName().substring(0, a3.getName().length() - 4));
            }
            catch (NumberFormatException numberFormatException) {
                return;
            }
        }
        a4.id = Integer.parseInt(a3.getName());
        DumpItemsAdditions dumpItemsAdditions2 = a4;
        if (dumpItemsAdditions2.doneIds.contains(dumpItemsAdditions2.id) || GameConstants.getInventoryType(a4.id) == MapleInventoryType.UNDEFINED) {
            return;
        }
        DumpItemsAdditions dumpItemsAdditions3 = a4;
        dumpItemsAdditions3.doneIds.add(dumpItemsAdditions3.id);
        DumpItemsAdditions dumpItemsAdditions4 = a4;
        MapleData mapleData2 = dumpItemsAdditions4.getStringData(dumpItemsAdditions4.id);
        if (mapleData2 == null) {
            string = SpecialEquipData.ALLATORIxDEMO("wCWI");
            dumpItemsAdditions = a4;
        } else {
            string = MapleDataTool.getString(Eval.ALLATORIxDEMO("1%2!"), mapleData2, "");
            dumpItemsAdditions = a4;
        }
        Progressbar.setText("\u8f49\u5b58\u9053\u5177[" + string + "(" + dumpItemsAdditions.id + ")]...");
        a3 = a3.getChildByPath(SpecialEquipData.ALLATORIxDEMO("EWJV\u0003XH]EMEVB"));
        if (a3 != null) {
            a2.setInt(1, a4.id);
            for (MapleData mapleData2 : a3.getChildren()) {
                EquipAdditions equipAdditions = EquipAdditions.fromString(mapleData2.getName());
                if (equipAdditions != null) {
                    PreparedStatement preparedStatement;
                    Pair<Integer, Integer> pair = null;
                    if (equipAdditions.isElement()) {
                        String string2;
                        String string3 = string2 = MapleDataTool.getString(equipAdditions.getValue1(), mapleData2, Eval.ALLATORIxDEMO("\u0002lt"));
                        pair = new Pair<Integer, Integer>(Element.getFromChar(string2.charAt(0)).getValue(), Integer.parseInt(string3.substring(1, string3.length())));
                        preparedStatement = a2;
                    } else {
                        pair = new Pair<Integer, Integer>(MapleDataTool.getIntConvert(equipAdditions.getValue1(), mapleData2, 0), MapleDataTool.getIntConvert(equipAdditions.getValue2(), mapleData2, 0));
                        preparedStatement = a2;
                    }
                    preparedStatement.setString(2, mapleData2.getName());
                    a2.setInt(3, (Integer)pair.left);
                    a2.setInt(4, (Integer)pair.right);
                    a2.addBatch();
                    continue;
                }
                System.out.println("UNKNOWN EQ ADDITION : " + mapleData2.getName() + " from " + a4.id);
            }
        }
    }

    public final /* synthetic */ MapleData getStringData(int a2) {
        String string;
        MapleData mapleData;
        DumpItemsAdditions a3;
        String string2 = null;
        if (a2 >= 5010000) {
            mapleData = a3.cashStringData;
            string = string2;
        } else if (a2 >= 2000000 && a2 < 3000000) {
            mapleData = a3.consumeStringData;
            string = string2;
        } else if (a2 >= 1010000 && a2 < 1040000 || a2 >= 1122000 && a2 < 1123000 || a2 >= 1132000 && a2 < 1210000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u0001.4p\u0005<':7,+-=");
        } else if (a2 >= 1662000 && a2 < 1680000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("iH\\\u0016mWHKCPH");
        } else if (a2 >= 1680000 && a2 < 1690000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\u001d-+7");
        } else if (a2 >= 1000000 && a2 < 1010000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("iH\\\u0016oX\\");
        } else if (a2 >= 1100000 && a2 < 1103000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\u001c%/!");
        } else if (a2 >= 1040000 && a2 < 1050000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("|]I\u0003zCXX");
        } else if (a2 >= 1920000 && a2 < 2000000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\u001b6>#0*");
        } else if (a2 >= 20000 && a2 < 25000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("|]I\u0003\u007fMZI");
        } else if (a2 >= 1080000 && a2 < 1090000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u0001.4p\u00033+)!");
        } else if (a2 >= 30000 && a2 < 50000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("|]I\u0003qMP^");
        } else if (a2 >= 1050000 && a2 < 1060000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\u0013+1#<+>0");
        } else if (a2 >= 1610000 && a2 < 1660000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("|]I\u0003tIZDXBPO");
        } else if (a2 >= 1842000 && a2 < 1893000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u0001.4p\t0*,0:6\u001d%+03!");
        } else if (a2 >= 1060000 && a2 < 1070000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("iH\\\u0016|XBM_");
        } else if (a2 >= 1802000 && a2 < 1820000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\u000f!+\u0001.164");
        } else if (a2 >= 1112000 && a2 < 1130000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("|]I\u0003kEWK");
        } else if (a2 >= 1092000 && a2 < 1100000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\f,6!3 ");
        } else if (a2 >= 1070000 && a2 < 1080000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("iH\\\u0016\u007fQC\\_");
        } else if (a2 >= 1603000 && a2 < 1604000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u0001.4p\u00174-3(,/6*");
        } else if (a2 >= 1900000 && a2 < 2000000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("|]I\u0003mMTEWK");
        } else if (a2 >= 1210000 && a2 < 1800000) {
            mapleData = a3.eqpStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u001a5/k\b!>40*");
        } else if (a2 >= 1172000 && a2 < 1180000) {
            mapleData = a3.eqpStringData;
            string = string2 = SpecialEquipData.ALLATORIxDEMO("iH\\\u0016aVBJX\\^{CVG");
        } else if (a2 >= 4000000 && a2 < 5000000) {
            mapleData = a3.etcStringData;
            string = string2 = Eval.ALLATORIxDEMO("\u0001+'");
        } else if (a2 >= 3000000 && a2 < 4000000) {
            mapleData = a3.insStringData;
            string = string2;
        } else if (a2 >= 5000000 && a2 < 5010000) {
            mapleData = a3.petStringData;
            string = string2;
        } else {
            return null;
        }
        if (string == null) {
            return mapleData.getChildByPath(String.valueOf(a2));
        }
        return mapleData.getChildByPath(string2 + "/" + a2);
    }

    public /* synthetic */ boolean doesExist(String a22) throws Exception {
        boolean bl;
        block5: {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement((String)a22);
                a22 = preparedStatement.executeQuery();
                bl = a22.next();
                a22.close();
                preparedStatement.close();
                if (druidPooledConnection == null) break block5;
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                block6: {
                    if (druidPooledConnection != null) {
                        try {
                            druidPooledConnection.close();
                            throwable2 = throwable;
                            break block6;
                        }
                        catch (Throwable a22) {
                            throwable.addSuppressed(a22);
                        }
                    }
                    throwable2 = throwable;
                }
                throw throwable2;
            }
            druidPooledConnection.close();
        }
        return bl;
    }

    public /* synthetic */ int currentId() {
        DumpItemsAdditions a2;
        return a2.id;
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(Eval.ALLATORIxDEMO("N|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|gUg\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd|N|d\u007fd\u007fd\u007fd\u007fg|d|d\u007fd|d\u007fd\u007fg|d|g|d|g|d|g\u007fd|g|d\u007fd\u007fd\u007fd\u007fgUg\u007fd\u007fd\u007fd\u007fg\u007fg\u007fg\u007fd\u007fg\u007fd\u007fg\u007fg\u007fd|d\u007fg\u007fg\u007fg\u007fg\u007fd|d\u007fd\u007fd\u007fd\u007fd|N|d\u007fd\u007fd\u007fd|g|d|d\u007fd|d\u007fd|g|d\u007fg\u007fd|d|d|g\u007fd\u007fg\u007fd\u007fd\u007fd\u007fd\u007fgUg\u007fd\u007fd\u007fd\u007fg\u007fg\u007fg|g\u007fg|g\u007fg\u007fg\u007fd|d\u007fg|g\u007fg\u007fg\u007fg|g\u007fd\u007fd\u007fd\u007fd|N|d\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fgUg\u007f\u000b=\"*7<%+-0*\u007f&&d\u001e(3%++--\u007f\u000b=\"*7<%++-d)sqw\u007f\u0000\u001a\t\u0010d|N|d\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fgUg\u007fd\u007fd\u007fd\u007fd\u007fd\u007f,+0/~pk(3(j>(3%++--q'0)\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd|N|d\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fd\u007fgUg|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|g|N"));
        GameSetConstants.loadsetting();
        GameSetConstants.reloadset();
        Progressbar.setValue(0);
        Progressbar.setText(SpecialEquipData.ALLATORIxDEMO("\u8f65\u5b61\u907f\u514e\u0002\u0017\u0002"));
        boolean bl = false;
        int n2 = 0;
        n2 = 0;
        long l2 = System.currentTimeMillis();
        int n3 = 0;
        try {
            DumpItemsAdditions dumpItemsAdditions = new DumpItemsAdditions(n2 != 0);
            System.out.println(Eval.ALLATORIxDEMO("\u8f16\u5b1c\u900c\u5133"));
            dumpItemsAdditions.dumpItems();
            DumpItemsAdditions dumpItemsAdditions2 = dumpItemsAdditions;
            bl |= dumpItemsAdditions2.isHadError();
            n3 = dumpItemsAdditions2.currentId();
        }
        catch (Exception exception) {
            bl = true;
            exception.printStackTrace();
            System.out.println(n3 + " quest.");
        }
        long l3 = System.currentTimeMillis();
        double d2 = (double)(l3 - l2) / 1000.0;
        n2 = (int)d2 % 60;
        n3 = (int)(d2 / 60.0);
        String string = "";
        if (bl) {
            string = SpecialEquipData.ALLATORIxDEMO("\u0004\u6730\u9303\u8a9d\u0005");
        }
        Progressbar.setValue(100);
        System.out.println("\u5b8c\u6210" + string + "\uff0c\u8017\u6642\uff1a" + n3 + "\u5206" + n2 + "\u79d2");
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 5 << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = 4 << 4 ^ (2 << 2 ^ 1);
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

    public /* synthetic */ String dumpAdditionItemData() throws Exception {
        DumpItemsAdditions a2;
        StringBuilder stringBuilder = new StringBuilder();
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : a2.g.getRoot().getSubdirectories()) {
            if (mapleDataDirectoryEntry.getName().equalsIgnoreCase(SpecialEquipData.ALLATORIxDEMO("\u007fIIZEX@")) || mapleDataDirectoryEntry.getName().equalsIgnoreCase(Eval.ALLATORIxDEMO("\u001e\"+!--2%8!"))) continue;
            for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
                MapleData mapleData;
                if (a2.ALLATORIxDEMO) {
                    MapleDataFileEntry mapleDataFileEntry2 = mapleDataFileEntry;
                    System.out.println("topDir: " + mapleDataDirectoryEntry.getName() + " ifile: " + mapleDataFileEntry2 + (String)(mapleDataFileEntry2 == null ? "" : " Name: " + mapleDataFileEntry.getName()));
                }
                MapleData mapleData2 = null;
                try {
                    mapleData = mapleData2 = a2.g.getData(mapleDataDirectoryEntry.getName() + "/" + mapleDataFileEntry.getName());
                }
                catch (Exception exception) {
                    FileoutputUtil.logToFile(SpecialEquipData.ALLATORIxDEMO("UC^_\u0016TT@\u0017XAX"), mapleDataDirectoryEntry.getName() + "/" + mapleDataFileEntry.getName());
                    mapleData = mapleData2;
                }
                if (mapleData == null) continue;
                stringBuilder.append(a2.dumpItemData(mapleData2));
            }
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ void dumpItems(MapleDataProvider a2, PreparedStatement a3, boolean a4) throws Exception {
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : a2.getRoot().getSubdirectories()) {
            if (mapleDataDirectoryEntry.getName().equalsIgnoreCase(Eval.ALLATORIxDEMO("\u0017/!<->(")) || mapleDataDirectoryEntry.getName().equalsIgnoreCase(SpecialEquipData.ALLATORIxDEMO("xJMIKETM^I"))) continue;
            for (MapleDataEntity mapleDataEntity : mapleDataDirectoryEntry.getFiles()) {
                MapleData mapleData;
                DumpItemsAdditions a5;
                if (a5.ALLATORIxDEMO) {
                    MapleDataFileEntry mapleDataFileEntry = mapleDataEntity;
                    System.out.println("topDir: " + mapleDataDirectoryEntry.getName() + " ifile: " + mapleDataFileEntry + (String)(mapleDataFileEntry == null ? "" : " Name: " + mapleDataEntity.getName()));
                }
                MapleData mapleData2 = null;
                try {
                    mapleData = mapleData2 = a2.getData(mapleDataDirectoryEntry.getName() + "/" + mapleDataEntity.getName());
                }
                catch (Exception exception) {
                    FileoutputUtil.logToFile(Eval.ALLATORIxDEMO("3+87p<2(q0'0"), mapleDataDirectoryEntry.getName() + "/" + mapleDataEntity.getName());
                    mapleData = mapleData2;
                }
                if (mapleData == null) continue;
                if (a4 || mapleDataDirectoryEntry.getName().equalsIgnoreCase(SpecialEquipData.ALLATORIxDEMO("|\\X"))) {
                    a5.dumpItem(a3, mapleData2);
                    continue;
                }
                Iterator iterator = mapleData2.iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2;
                    mapleDataEntity = (MapleData)iterator2.next();
                    iterator = iterator2;
                    a5.dumpItem(a3, (MapleData)mapleDataEntity);
                }
            }
        }
    }
}

