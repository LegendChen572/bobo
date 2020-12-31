/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.wztosql;

import client.SkillEntry;
import client.inventory.MapleInventoryType;
import client.messages.commands.InternCommand;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.swing.Progressbar;

public class DumpItemsIndividual {
    private final /* synthetic */ MapleDataProvider E;
    private static /* synthetic */ Thread k;
    public final /* synthetic */ MapleData etcStringData;
    public final /* synthetic */ MapleData consumeStringData;
    public final /* synthetic */ MapleData eqpStringData;
    private static /* synthetic */ Thread d;
    public final /* synthetic */ MapleData insStringData;
    public /* synthetic */ boolean individual;
    public final /* synthetic */ Set<Integer> doneIds;
    private final /* synthetic */ MapleDataProvider g;
    public final /* synthetic */ MapleData cashStringData;
    private static /* synthetic */ Thread a;
    private static /* synthetic */ Thread K;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ MapleDataProvider B;
    public /* synthetic */ boolean hadError;
    public final /* synthetic */ MapleData petStringData;
    public /* synthetic */ boolean update;
    public /* synthetic */ int id;

    public final /* synthetic */ MapleData getStringData(int a2) {
        String string;
        MapleData mapleData;
        DumpItemsIndividual a3;
        String string2 = null;
        if (a2 >= 5010000) {
            mapleData = a3.cashStringData;
            string = string2;
        } else if (a2 >= 2000000 && a2 < 3000000) {
            mapleData = a3.consumeStringData;
            string = string2;
        } else if (a2 >= 1010000 && a2 < 1040000 || a2 >= 1122000 && a2 < 1123000 || a2 >= 1132000 && a2 < 1210000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("P@e\u001eTRvTfBzCl");
        } else if (a2 >= 1662000 && a2 < 1680000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("@@u\u001eD_aCjXa");
        } else if (a2 >= 1680000 && a2 < 1690000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:s|Ef");
        } else if (a2 >= 1000000 && a2 < 1010000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("@@u\u001eFPu");
        } else if (a2 >= 1100000 && a2 < 1110000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:rtAp");
        } else if (a2 >= 1040000 && a2 < 1050000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("ttA*rjPq");
        } else if (a2 >= 1920000 && a2 < 2000000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:ugPr^{");
        } else if (a2 >= 20000 && a2 < 25000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("ttA*wdR`");
        } else if (a2 >= 1080000 && a2 < 1090000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("P@e\u001eR]zGp");
        } else if (a2 >= 30000 && a2 < 50000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("ttA*ydXw");
        } else if (a2 >= 1050000 && a2 < 1060000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:}z_rRzPa");
        } else if (a2 >= 1610000 && a2 < 1660000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("ttA*|`RmPkXf");
        } else if (a2 >= 1842000 && a2 < 1893000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("P@e\u001eX^{BaTgstEa]p");
        } else if (a2 >= 1060000 && a2 < 1070000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("@@u\u001eUPkEv");
        } else if (a2 >= 1802000 && a2 < 1820000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:apEP@`Xe");
        } else if (a2 >= 1112000 && a2 < 1130000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("ttA*cl_b");
        } else if (a2 >= 1092000 && a2 < 1100000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:b}Xp]q");
        } else if (a2 >= 1070000 && a2 < 1080000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("@@u\u001eVYjTv");
        } else if (a2 >= 1603000 && a2 < 1604000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("P@e\u001eFZ|]yB~X{");
        } else if (a2 >= 1900000 && a2 < 2000000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("ttA*ed\\l_b");
        } else if (a2 >= 1210000 && a2 < 1800000) {
            mapleData = a3.eqpStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("tdA:fpPe^{");
        } else if (a2 >= 1172000 && a2 < 1180000) {
            mapleData = a3.eqpStringData;
            string = string2 = InternCommand.ALLATORIxDEMO("@@u\u001eH^kBqTwsj^n");
        } else if (a2 >= 4000000 && a2 < 5000000) {
            mapleData = a3.etcStringData;
            string = string2 = SkillEntry.ALLATORIxDEMO("PEv");
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

    /*
     * Exception decompiling
     */
    public /* synthetic */ void dumpItems(String a) throws Exception {
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

    public /* synthetic */ void dumpItems(PreparedStatement a2, PreparedStatement a3, PreparedStatement a4, PreparedStatement a5, String a6) throws Exception {
        DumpItemsIndividual a7;
        if (!a7.update) {
            Progressbar.setText(InternCommand.ALLATORIxDEMO("\u6e34\u7403\u6549\u64df\u5e9a+\u001f+"));
            DumpItemsIndividual dumpItemsIndividual = a7;
            DumpItemsIndividual dumpItemsIndividual2 = a7;
            dumpItemsIndividual2.delete(SkillEntry.ALLATORIxDEMO("QtYtAt5wG~X\u0011bKJXaTxUtEt"));
            dumpItemsIndividual2.delete(InternCommand.ALLATORIxDEMO("u@}@e@\u0011CcJ|%F\u007fnlE`\\`@pXuUdEd"));
            dumpItemsIndividual.delete(SkillEntry.ALLATORIxDEMO("uP}PeP\u0011ScZ|5Fon|Ep\\tUqUtEt"));
            dumpItemsIndividual.delete(InternCommand.ALLATORIxDEMO("AtItQt%wW~H\u0011rKZXqThC`FdCaUdEd"));
            System.out.println(SkillEntry.ALLATORIxDEMO("\u6e34\u7a6f\u0013bKJXaTxUtEt\u0013\u5ebe\u6221\u528a"));
        }
        if (a7.individual) {
            a7.delete("DELETE FROM wz_itemdata WHERE itemid = " + a6);
            a7.delete("DELETE FROM wz_itemequipdata WHERE itemid = " + a6);
            a7.delete("DELETE FROM wz_itemadddata WHERE itemid = " + a6);
            a7.delete("DELETE FROM wz_itemrewarddata WHERE itemid = " + a6);
        }
        System.out.println(InternCommand.ALLATORIxDEMO("\u6b52\u572d\u6dca\u52a5\u9003'F\u007fnlE`\\aPqP'\u5e9a+\u001f+\u001f+"));
        DumpItemsIndividual dumpItemsIndividual = a7;
        dumpItemsIndividual.dumpItems(dumpItemsIndividual.E, a2, a3, a4, a5, false, a6);
        dumpItemsIndividual.dumpItems(dumpItemsIndividual.g, a2, a3, a4, a5, true, a6);
        System.out.println(SkillEntry.ALLATORIxDEMO("\u5bbd\u6205\u0013bKJXaTxUtEt\u0013\u5ebe\u76b5\u8f5c\u5b699\u0011\u8f5c\u5b69\u9091\u5719\u9027\u887d\u8ade\u52ce\u95c9\u95b8;\u001f;"));
    }

    public /* synthetic */ DumpItemsIndividual(boolean a2) throws Exception {
        DumpItemsIndividual a3;
        DumpItemsIndividual dumpItemsIndividual = a3;
        DumpItemsIndividual dumpItemsIndividual2 = a3;
        DumpItemsIndividual dumpItemsIndividual3 = a3;
        DumpItemsIndividual dumpItemsIndividual4 = a3;
        DumpItemsIndividual dumpItemsIndividual5 = a3;
        dumpItemsIndividual4.B = MapleDataProviderFactory.getDataProvider(InternCommand.ALLATORIxDEMO("VEwXkV+F\u007f"));
        dumpItemsIndividual4.cashStringData = dumpItemsIndividual5.B.getData(SkillEntry.ALLATORIxDEMO("rtB}\u001f|\\r"));
        dumpItemsIndividual4.consumeStringData = dumpItemsIndividual4.B.getData(InternCommand.ALLATORIxDEMO("F^kBp\\`\u001fl\\b"));
        dumpItemsIndividual4.eqpStringData = dumpItemsIndividual4.B.getData(SkillEntry.ALLATORIxDEMO("P@e\u001f|\\r"));
        dumpItemsIndividual4.etcStringData = dumpItemsIndividual4.B.getData(InternCommand.ALLATORIxDEMO("@Ef\u001fl\\b"));
        dumpItemsIndividual4.insStringData = dumpItemsIndividual4.B.getData(SkillEntry.ALLATORIxDEMO("\\_f\u001f|\\r"));
        dumpItemsIndividual4.petStringData = dumpItemsIndividual4.B.getData(InternCommand.ALLATORIxDEMO("UTq\u001fl\\b"));
        DumpItemsIndividual dumpItemsIndividual6 = a3;
        dumpItemsIndividual4.doneIds = new LinkedHashSet<Integer>();
        dumpItemsIndividual3.ALLATORIxDEMO = false;
        dumpItemsIndividual3.hadError = false;
        dumpItemsIndividual2.update = true;
        dumpItemsIndividual2.individual = true;
        dumpItemsIndividual.id = 0;
        dumpItemsIndividual.update = a2;
        a3.E = MapleDataProviderFactory.getDataProvider(SkillEntry.ALLATORIxDEMO("\\Ep\\;Fo"));
        a3.g = MapleDataProviderFactory.getDataProvider(InternCommand.ALLATORIxDEMO("rmPwPfE`C+F\u007f"));
        if (a3.E == null || a3.B == null || a3.g == null) {
            a3.hadError = true;
        }
    }

    public static /* synthetic */ void main(String a2) {
        GameSetConstants.loadsetting();
        GameSetConstants.reloadset();
        Progressbar.setValue(0);
        Progressbar.setText(InternCommand.ALLATORIxDEMO("\u8f4c\u5b69\u9056\u5146+\u001f+"));
        boolean bl = false;
        int n2 = 1;
        long l2 = System.currentTimeMillis();
        int n3 = 0;
        try {
            DumpItemsIndividual dumpItemsIndividual = new DumpItemsIndividual(n2 != 0);
            System.out.println(SkillEntry.ALLATORIxDEMO("\u8f78\u5b4d\u9062\u5162"));
            dumpItemsIndividual.dumpItems(a2);
            DumpItemsIndividual dumpItemsIndividual2 = dumpItemsIndividual;
            bl |= dumpItemsIndividual2.isHadError();
            n3 = dumpItemsIndividual2.currentId();
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
            string = InternCommand.ALLATORIxDEMO("-\u6738\u932a\u8a95,");
        }
        Progressbar.setValue(100);
        System.out.println("\u5b8c\u6210" + string + "\uff0c\u8017\u6642\uff1a" + n3 + "\u5206" + n2 + "\u79d2");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void dumpItem(PreparedStatement a, PreparedStatement a, PreparedStatement a, PreparedStatement a, MapleData a) throws Exception {
        block110: {
            try {
                a.id = a.getName().endsWith(InternCommand.ALLATORIxDEMO("\u001fl\\b")) != false ? Integer.parseInt(a.getName().substring(0, a.getName().length() - 4)) : Integer.parseInt(a.getName());
            }
            catch (NumberFormatException var6_6) {
                return;
            }
            v0 = a;
            if (v0.doneIds.contains(v0.id) || GameConstants.getInventoryType(a.id) == MapleInventoryType.UNDEFINED) {
                return;
            }
            v1 = a;
            v1.doneIds.add(v1.id);
            if (v1.update) {
                v2 = a;
                if (v2.doesExist("SELECT * FROM wz_itemdata WHERE itemid = " + v2.id)) {
                    return;
                }
            }
            a.setInt(1, a.id);
            v3 = a;
            var6_7 = v3.getStringData(v3.id);
            v4 = a;
            if (var6_7 == null) {
                v4.setString(2, "");
                v5 = var6_7;
                v6 = a;
                v6.setString(3, "");
                v6.setString(4, "");
            } else {
                v4.setString(2, MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("_t\\p"), var6_7, ""));
                v5 = var6_7;
                v7 = a;
                v7.setString(3, MapleDataTool.getString(InternCommand.ALLATORIxDEMO("hBb"), var6_7, ""));
                v7.setString(4, MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("UpBv"), var6_7, ""));
            }
            if (v5 == null) {
                v8 = InternCommand.ALLATORIxDEMO("\u007fj_`");
                v9 = a;
            } else {
                v8 = MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("_t\\p"), var6_7, "");
                v9 = a;
            }
            Progressbar.setText("\u8f49\u5b58\u9053\u5177[" + v8 + "(" + v9.id + ")]...");
            if (a.update) {
                if (var6_7 == null) {
                    v10 = InternCommand.ALLATORIxDEMO("\u007fj_`");
                    v11 = a;
                } else {
                    v10 = MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("_t\\p"), var6_7, "");
                    v11 = a;
                }
                System.out.println("\u8f49\u5b58\u65b0\u9053\u5177[" + v10 + "(" + v11.id + ")]...");
            }
            if ((var7_9 = a.getChildByPath(InternCommand.ALLATORIxDEMO("XkWj\u001ev]jEHP}"))) == null) {
                if (GameConstants.getInventoryType(a.id) == MapleInventoryType.EQUIP) {
                    var6_8 = 1;
                    v12 = a;
                } else {
                    var6_8 = 100;
                    v12 = a;
                }
            } else {
                var6_8 = MapleDataTool.getIntConvert(var7_9, -1);
                v12 = a;
            }
            v12.setInt(5, var6_8);
            var6_8 = MapleDataTool.getIntConvert(a.getChildByPath(SkillEntry.ALLATORIxDEMO("X{Wz\u001etDa^EC|Rp")), 0) > 0 ? 1 : 0;
            var7_10 = a.getChildByPath(InternCommand.ALLATORIxDEMO("XkWj\u001ep_lEUClR`"));
            if (var7_10 != null) {
                try {
                    var8_29 = MapleDataTool.getDouble(var7_10);
                    v13 = a;
                }
                catch (Exception var10_31) {
                    v13 = a;
                    var8_29 = MapleDataTool.getIntConvert(var7_10, -1);
                }
            } else {
                var7_11 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("X{Wz\u001eeC|Rp"));
                if (var7_11 == null && var6_8 == 0) {
                    var8_29 = -1.0;
                    v13 = a;
                } else if (var6_8 != 0) {
                    var10_32 = a.getChildByPath(InternCommand.ALLATORIxDEMO("l_c^*]s"));
                    v13 = a;
                    var8_29 = MapleDataTool.getIntConvert(var10_32, 0) * 2;
                } else {
                    var8_29 = MapleDataTool.getIntConvert(var7_11, -1);
                    v13 = a;
                }
            }
            if (v13.id == 2070019 || a.id == 2330007) {
                var8_29 = 1.0;
            }
            v14 = a;
            v14.setString(6, String.valueOf(var8_29));
            v14.setInt(7, MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("X{Wz\u001eeC|Rp"), a, -1));
            a.setInt(8, MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001evEdE`rmPkV`xqTh"), a, 0));
            var10_33 = MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("X{Wz\u001ewPrelAp"), a, 0);
            if (MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001ek^qbd]`"), a, 0) > 0) {
                var10_33 |= 16;
            }
            if (MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("|_s^:TmA|Cp~{}zVzDa"), a, 0) > 0) {
                var10_33 |= 32;
            }
            if (MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001euXfZPAG]jRn"), a, 0) > 0) {
                var10_33 |= 64;
            }
            if (MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("|_s^:^{]l"), a, 0) > 0) {
                var10_33 |= 128;
            }
            if (MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001edRf^p_qbmPwPg]`"), a, 0) > 0) {
                var10_33 |= 256;
            }
            if (MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("X{Wz\u001edDpBa"), a, 0) > 0) {
                var10_33 |= 512;
            }
            if (a.id != 4310008 && MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("l_c^*EwPaTG]jRn"), a, 0) > 0) {
                var10_33 |= 1024;
            }
            if (MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("X{Wz\u001etRv^`_ab}PgTAPr"), a, 0) > 0) {
                var10_33 |= 2048;
            }
            if (MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001eh^gyU"), a, 0) > 0 && MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("X{Wz\u001ex^wyE"), a, 0) < 100) {
                var10_33 |= 4096;
            }
            v15 = a;
            v16 = a;
            a.setInt(9, var10_33);
            v16.setInt(10, MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("l_c^*EwPaTDGdXiPg]`"), a, 0));
            v16.setInt(11, MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("|_s^:\\pBz"), a, 0));
            v15.setInt(12, MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001eh^g"), a, 0));
            v15.setInt(13, MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("|_s^:]c"), a, 0));
            a.setInt(14, MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XkWj\u001etD`Bqxa"), a, 0));
            var6_8 = 0;
            var7_13 = new StringBuilder();
            var10_34 = new StringBuilder();
            var8_30 = new StringBuilder();
            var9_40 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("gTd"));
            if (var9_40 != null) {
                v17 = var11_41 = var9_40.iterator();
                while (v17.hasNext()) {
                    var12_42 = (MapleData)var11_41.next();
                    if (var7_13.length() > 0) {
                        var7_13.append(InternCommand.ALLATORIxDEMO(")"));
                    }
                    var7_13.append(MapleDataTool.getIntConvert((MapleData)var12_42, 0));
                    v17 = var11_41;
                }
            }
            if ((var9_40 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("v^{B`\\pxaTx"))) != null) {
                v18 = var11_41 = var9_40.iterator();
                while (v18.hasNext()) {
                    var12_42 = (MapleData)var11_41.next();
                    if (var10_34.length() > 0) {
                        var10_34.append(InternCommand.ALLATORIxDEMO(")"));
                    }
                    var10_34.append(MapleDataTool.getIntConvert((MapleData)var12_42, 0));
                    v18 = var11_41;
                }
            }
            a.setString(15, var7_13.toString());
            a.setString(16, var10_34.toString());
            var11_41 = new HashMap<Integer, HashMap<K, V>>();
            var11_41.put(-1, new HashMap<K, V>());
            var9_40 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("x^w"));
            if (var9_40 != null) {
                var12_42 = var9_40.iterator();
                v19 /* !! */  = var12_42;
                while (v19 /* !! */ .hasNext()) {
                    var7_15 = (MapleData)var12_42.next();
                    ((Map)var11_41.get(-1)).put("mob" + MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("Xa"), var7_15, 0), MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("Ag^w"), var7_15, 0));
                    v19 /* !! */  = var12_42;
                }
            }
            if ((var9_40 = a.getChildByPath(InternCommand.ALLATORIxDEMO("l_c^*]`G`]*RdB`"))) != null) {
                for (MapleData var7_17 : var9_40) {
                    for (Object var13_43 : var7_17) {
                        v20 = new String[2];
                        v20[0] = SkillEntry.ALLATORIxDEMO("FZ|]y");
                        v20[1] = InternCommand.ALLATORIxDEMO("ttDlAhTkEVZl]i");
                        var14_48 = v20;
                        var15_50 = v20;
                        var16_51 = ((String[])var15_50).length;
                        v21 = var17_53 = 0;
                        while (v21 < var16_51) {
                            var18_56 = var15_50[var17_53];
                            if (var13_43.getName().length() == 1 && var13_43.getChildByPath(var18_56) != null) {
                                for (MapleData var20_60 : var13_43.getChildByPath(var18_56)) {
                                    var21_62 = MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("Xq"), var20_60, 0);
                                    if (var21_62 == 0) continue;
                                    if (var8_30.length() > 0) {
                                        var8_30.append(InternCommand.ALLATORIxDEMO(")"));
                                    }
                                    var8_30.append(var21_62);
                                }
                            }
                            v21 = ++var17_53;
                        }
                    }
                }
            }
            if ((var9_40 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("X{Wz\u001eyTcTy"))) != null && MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("WlIITsTi"), var9_40, 0) != 0 && MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("W|IYTcTy"), var9_40, 0) != 0) {
                v22 = var11_41;
                v22.put(-1, new HashMap<K, V>());
                ((Map)v22.get(-1)).put(InternCommand.ALLATORIxDEMO("WlIITsTi"), MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("W|IYTcTy"), var9_40));
            }
            if ((var9_40 = a.getChildByPath(InternCommand.ALLATORIxDEMO("l_c^*]`G`]*XkWj"))) != null) {
                var12_42 = var9_40.iterator();
                block34: while (true) {
                    v23 = var12_42;
                    while (v23.hasNext()) {
                        var7_19 = (MapleData)var12_42.next();
                        if (MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("pIe"), var7_19, 0) == 0) {
                            v23 = var12_42;
                            continue;
                        }
                        var10_35 = Integer.parseInt(var7_19.getName());
                        if (var11_41.get(var10_35) == null) {
                            var11_41.put(var10_35, new HashMap<K, V>());
                        }
                        var13_43 = var7_19.iterator();
                        while (true) {
                            if (!var13_43.hasNext()) continue block34;
                            var14_48 = (MapleData)var13_43.next();
                            if (var14_48.getName().length() <= 3) continue;
                            ((Map)var11_41.get(var10_35)).put(var14_48.getName().substring(3), MapleDataTool.getIntConvert((MapleData)var14_48, 0));
                        }
                    }
                    break;
                }
            }
            if ((var9_40 = a.getChildByPath(InternCommand.ALLATORIxDEMO("XkWj"))) != null) {
                a.setString(22, MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("PsEpC\\\\tVp"), var9_40, ""));
                var12_42 = (Map)var11_41.get(-1);
                for (MapleData var10_36 : var9_40.getChildren()) {
                    if (!var10_36.getName().startsWith(InternCommand.ALLATORIxDEMO("l_f")) || (var13_44 = MapleDataTool.getIntConvert(var10_36, 0)) == 0) continue;
                    var12_42.put(var10_36.getName().substring(3), var13_44);
                }
                var7_21 = GameConstants.stats;
                var10_37 = GameConstants.stats.length;
                v24 = var13_45 = 0;
                while (v24 < var10_37) {
                    var14_48 = var7_21[var13_45];
                    var15_50 = var9_40.getChildByPath((String)var14_48);
                    if (var14_48.equals(SkillEntry.ALLATORIxDEMO("Rt_YTcTy"))) {
                        if (var9_40.getChildByPath(InternCommand.ALLATORIxDEMO("iTsTi")) != null) {
                            var12_42.put(var14_48, 1);
                        }
                    } else if (var15_50 != null) {
                        if (var14_48.equals(SkillEntry.ALLATORIxDEMO("fZ|]y"))) {
                            v25 = var16_51 = 0;
                            while (v25 < var15_50.getChildren().size()) {
                                v26 = "skillid" + var16_51;
                                v27 = Integer.toString(var16_51);
                                var12_42.put(v26, MapleDataTool.getIntConvert(v27, (MapleData)var15_50, 0));
                                v25 = ++var16_51;
                            }
                        } else {
                            var16_51 = MapleDataTool.getIntConvert((MapleData)var15_50, 0);
                            if (var16_51 != 0) {
                                var12_42.put(var14_48, var16_51);
                            }
                        }
                    }
                    v24 = ++var13_45;
                }
            } else {
                a.setString(22, "");
            }
            a.setInt(1, a.id);
            for (Map.Entry var7_24 : var11_41.entrySet()) {
                a.setInt(2, (Integer)var7_24.getKey());
                for (Map.Entry<K, V> var13_46 : ((Map)var7_24.getValue()).entrySet()) {
                    a.setString(3, (String)var13_46.getKey());
                    a.setInt(4, (Integer)var13_46.getValue());
                    v28 = a;
                    if (a.update) {
                        v28.execute();
                        continue;
                    }
                    v28.addBatch();
                }
            }
            var9_40 = a.getChildByPath(InternCommand.ALLATORIxDEMO("l_c^*PaUlEl^k"));
            if (var9_40 == null) break block110;
            a.setInt(1, a.id);
            block42: for (MapleData var7_26 : var9_40.getChildren()) {
                block111: {
                    var10_39 = null;
                    var13_47 = var7_26.getName();
                    var14_49 = -1;
                    switch (var13_47.hashCode()) {
                        case -1897135862: {
                            if (!var13_47.equals(SkillEntry.ALLATORIxDEMO("fEtE|_v"))) break;
                            v29 = var14_49 = 0;
                            break block111;
                        }
                        case 1952151455: {
                            if (!var13_47.equals(InternCommand.ALLATORIxDEMO("RwXqXfPi"))) break;
                            v29 = var14_49 = 1;
                            break block111;
                        }
                        case 109496913: {
                            if (!var13_47.equals(SkillEntry.ALLATORIxDEMO("fZ|]y"))) break;
                            v29 = var14_49 = 2;
                            break block111;
                        }
                        case -1068860032: {
                            if (!var13_47.equals(InternCommand.ALLATORIxDEMO("\\jSaX`"))) break;
                            v29 = var14_49 = 3;
                            break block111;
                        }
                        case 708288539: {
                            if (!var13_47.equals(SkillEntry.ALLATORIxDEMO("Ye\\eR}P{Vp"))) break;
                            v29 = var14_49 = 4;
                            break block111;
                        }
                        case -261260940: {
                            if (!var13_47.equals(InternCommand.ALLATORIxDEMO("`]`\\g^jBq"))) break;
                            v29 = var14_49 = 5;
                            break block111;
                        }
                        case -290813612: {
                            if (!var13_47.equals(SkillEntry.ALLATORIxDEMO("p]p\\W^zBa"))) break;
                            v29 = var14_49 = 6;
                            break block111;
                        }
                        case 376267774: {
                            if (!var13_47.equals(InternCommand.ALLATORIxDEMO("h^gRdE`VjC|"))) break;
                            v29 = var14_49 = 7;
                            break block111;
                        }
                        case 3029869: {
                            if (!var13_47.equals(SkillEntry.ALLATORIxDEMO("SzBf"))) break;
                            var14_49 = 8;
                        }
                    }
                    v29 = var14_49;
                }
                switch (v29) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: {
                        for (MapleData var16_52 : var7_26.getChildren()) {
                            if (!var16_52.getName().equals(InternCommand.ALLATORIxDEMO("f^k"))) ** GOTO lbl371
                            block44: for (MapleData var18_58 : var16_52.getChildren()) {
                                var19_59 = var18_58.getName();
                                var20_61 = -1;
                                switch (var19_59.hashCode()) {
                                    case 105405: {
                                        if (!var19_59.equals(SkillEntry.ALLATORIxDEMO("\u007f^w"))) break;
                                        v30 = var20_61 = 0;
                                        ** GOTO lbl326
                                    }
                                    case 1226831624: {
                                        if (!var19_59.equals(InternCommand.ALLATORIxDEMO("rT`ZAP|"))) break;
                                        var20_61 = 1;
                                    }
                                }
                                v30 = var20_61;
lbl326:
                                // 2 sources

                                switch (v30) {
                                    case 0: {
                                        var21_63 = new StringBuilder();
                                        if (var18_58.getData() == null) {
                                            v31 = var18_58.getChildren().iterator();
                                            while (v31.hasNext()) {
                                                var11_41 = a.next();
                                                v31 = a;
                                                var21_63.append(var11_41.getData().toString());
                                                var21_63.append(SkillEntry.ALLATORIxDEMO("9"));
                                            }
                                            v32 = var21_63;
                                            v32.deleteCharAt(v32.length() - 1);
                                            v33 = a;
                                        } else {
                                            var21_63.append(var18_58.getData().toString());
                                            v33 = a;
                                        }
                                        v33.setString(2, var7_26.getName().equals(InternCommand.ALLATORIxDEMO("`]`\\G^jBq")) != false ? SkillEntry.ALLATORIxDEMO("p]p\\w^zBa") : var7_26.getName());
                                        v34 = a;
                                        v34.setString(3, InternCommand.ALLATORIxDEMO("f^k\u000bo^g"));
                                        v34.setString(4, var21_63.toString());
                                        v35 = a;
                                        if (a.update) {
                                            v35.execute();
                                            continue block44;
                                        }
                                        v35.addBatch();
                                        continue block44;
                                    }
                                    case 1: {
                                        continue block44;
                                    }
                                }
                                a.setString(2, var7_26.getName().equals(SkillEntry.ALLATORIxDEMO("p]p\\W^zBa")) != false ? InternCommand.ALLATORIxDEMO("`]`\\g^jBq") : var7_26.getName());
                                a.setString(3, "con:" + var18_58.getName());
                                a.setString(4, var18_58.getData().toString());
                                v36 = a;
                                if (a.update) {
                                    v36.execute();
                                    continue;
                                }
                                v36.addBatch();
                            }
                            continue;
lbl371:
                            // 1 sources

                            a.setString(2, var7_26.getName().equals(SkillEntry.ALLATORIxDEMO("p]p\\W^zBa")) != false ? InternCommand.ALLATORIxDEMO("`]`\\g^jBq") : var7_26.getName());
                            v37 = a;
                            v37.setString(3, var16_52.getName());
                            v37.setString(4, var16_52.getData().toString());
                            v38 = a;
                            if (a.update) {
                                v38.execute();
                                continue;
                            }
                            v38.addBatch();
                        }
                        continue block42;
                    }
                }
                System.out.println("UNKNOWN EQ ADDITION : " + var7_26.getName() + " from " + a.id);
            }
        }
        if ((var9_40 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("CpFtCq"))) != null) {
            a.setInt(1, a.id);
            var12_42 = var9_40.iterator();
            v39 /* !! */  = var12_42;
            while (v39 /* !! */ .hasNext()) {
                var7_28 = var12_42.next();
                v40 = a;
                v41 = a;
                v42 = a;
                v42.setInt(2, MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("XqTh"), var7_28, 0));
                v42.setInt(3, MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("Ag^w"), var7_28, 0));
                v41.setInt(4, MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("f^p_q"), var7_28, 0));
                v41.setInt(5, MapleDataTool.getIntConvert(SkillEntry.ALLATORIxDEMO("ApC|^q"), var7_28, 0));
                v40.setString(6, MapleDataTool.getString(InternCommand.ALLATORIxDEMO("FjCiUHBb"), var7_28, ""));
                v40.setString(7, MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("tsWpRa"), var7_28, ""));
                v43 = a;
                if (a.update) {
                    v43.execute();
                    v44 = var6_8;
                } else {
                    v43.addBatch();
                    v44 = var6_8;
                }
                var6_8 = v44 + MapleDataTool.getIntConvert(InternCommand.ALLATORIxDEMO("Aw^g"), var7_28, 0);
                v39 /* !! */  = var12_42;
            }
        }
        a.setInt(17, var6_8);
        a.setString(18, var8_30.toString());
        var9_40 = a.getChildByPath(SkillEntry.ALLATORIxDEMO("gTe]tRp"));
        v45 = a;
        if (var9_40 != null) {
            v45.setInt(19, MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("XqThXa"), var9_40, 0));
            v46 = a;
            v47 = v46;
            v46.setString(20, MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("xBr"), var9_40, ""));
        } else {
            v45.setInt(19, 0);
            v48 = a;
            v47 = v48;
            v48.setString(20, "");
        }
        v47.setInt(21, MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("l_c^*RwTdE`"), a, 0));
        v49 = a;
        a.setInt(23, MapleDataTool.getInt(SkillEntry.ALLATORIxDEMO("X{Wz\u001ezAaXz_:\u0001:^eE|^{"), a, 0));
        v49.setInt(24, MapleDataTool.getInt(InternCommand.ALLATORIxDEMO("XkWj\u001ejAqXj_*\u0000*^uEl^k"), a, 0));
        v49.setInt(25, MapleDataTool.getInt(SkillEntry.ALLATORIxDEMO("X{Wz\u001ezAaXz_:\u0003:^eE|^{"), a, 0));
        v50 = a;
        if (a.update) {
            v50.execute();
            return;
        }
        v50.addBatch();
    }

    public /* synthetic */ boolean isHadError() {
        DumpItemsIndividual a2;
        return a2.hadError;
    }

    public /* synthetic */ void dumpItems(MapleDataProvider a2, PreparedStatement a3, PreparedStatement a4, PreparedStatement a5, PreparedStatement a6, boolean a7, String a8) throws Exception {
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : a2.getRoot().getSubdirectories()) {
            if (mapleDataDirectoryEntry.getName().equalsIgnoreCase(SkillEntry.ALLATORIxDEMO("FApR|Py")) || mapleDataDirectoryEntry.getName().equalsIgnoreCase(InternCommand.ALLATORIxDEMO("pcE`Cl\\dV`"))) continue;
            for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
                DumpItemsIndividual a9;
                if (a9.ALLATORIxDEMO) {
                    MapleDataFileEntry mapleDataFileEntry2 = mapleDataFileEntry;
                    System.out.println("topDir: " + mapleDataDirectoryEntry.getName() + " ifile: " + mapleDataFileEntry2 + (String)(mapleDataFileEntry2 == null ? "" : " Name: " + mapleDataFileEntry.getName()));
                }
                if (!mapleDataFileEntry.getName().contains(a8)) continue;
                MapleDataFileEntry mapleDataFileEntry3 = mapleDataFileEntry;
                System.out.println("topDir: " + mapleDataDirectoryEntry.getName() + " ifile: " + mapleDataFileEntry3 + (String)(mapleDataFileEntry3 == null ? "" : " Name: " + mapleDataFileEntry.getName()));
                MapleData mapleData = a2.getData(mapleDataDirectoryEntry.getName() + "/" + mapleDataFileEntry.getName());
                if (mapleData == null) continue;
                if (a7 || mapleDataDirectoryEntry.getName().equalsIgnoreCase(SkillEntry.ALLATORIxDEMO("ETa"))) {
                    a9.dumpItem(a3, a4, a5, a6, mapleData);
                    continue;
                }
                Iterator iterator = mapleData.iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2;
                    MapleData mapleData2 = (MapleData)iterator2.next();
                    iterator = iterator2;
                    a9.dumpItem(a3, a4, a5, a6, mapleData2);
                }
            }
        }
    }

    public /* synthetic */ int currentId() {
        DumpItemsIndividual a2;
        return a2.id;
    }
}

