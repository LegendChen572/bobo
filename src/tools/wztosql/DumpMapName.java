/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.wztosql;

import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import provider.MapleData;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.buffs.AbstractBuffClass;
import server.gashapon.GashaponRewardSpecial;
import tools.StringUtil;

public class DumpMapName {
    public /* synthetic */ int no_exist;
    public /* synthetic */ boolean update;
    public /* synthetic */ List<Integer> mapids;
    public /* synthetic */ int id;
    public /* synthetic */ List<Integer> alreadymapids;
    public /* synthetic */ boolean hadError;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void delete(String a22) throws Exception {
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        try {
            PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(a22);
            preparedStatement.executeUpdate();
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
                catch (Throwable a22) {
                    throwable.addSuppressed(a22);
                }
            }
            throwable2 = throwable;
            throw throwable2;
        }
        druidPooledConnection.close();
    }

    private /* synthetic */ String ALLATORIxDEMO(int a2) {
        String string = StringUtil.getLeftPaddedStr(Integer.toString(a2), '0', 9);
        StringBuilder stringBuilder = new StringBuilder(GashaponRewardSpecial.ALLATORIxDEMO("jeW+jeW"));
        stringBuilder.append(a2 / 100000000);
        stringBuilder.append("/");
        stringBuilder.append(string);
        stringBuilder.append(AbstractBuffClass.ALLATORIxDEMO(";wxy"));
        string = stringBuilder.toString();
        return string;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void dumpMapName() throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 9[CATCHBLOCK]
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

    public /* synthetic */ boolean isNumeric(String a2) throws Exception {
        return a2.matches(GashaponRewardSpecial.ALLATORIxDEMO("\n;{`\f,{*{`\f-\u0018"));
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 3 << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = 5 << 4 ^ 3;
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

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(GashaponRewardSpecial.ALLATORIxDEMO("-'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0004'\u0007'\u0007$\u0007'\u0007$\u0007$\u0004'\u0007'\u0004'\u0007'\u0004'\u0007'\u0004$\u0007'\u0004'\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0004$\u0004$\u0004$\u0007$\u0004$\u0007$\u0004$\u0004$\u0007'\u0007$\u0004$\u0004$\u0004$\u0004$\u0007'\u0007$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007'\u0004'\u0007'\u0007$\u0007'\u0007$\u0007'\u0004'\u0007$\u0004$\u0007'\u0007'\u0007'\u0004$\u0007$\u0004$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0004$\u0004$\u0004'\u0004$\u0004'\u0004$\u0004$\u0004$\u0007'\u0007$\u0004'\u0004$\u0004$\u0004$\u0004'\u0004$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$hfAqTgFpNkI$E}\u0007EKhFpHvN$hfAqTgFpHv\u0007r\u0010*\u0014$cAjK\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0007$\u0007$OpSt\u001d+\bsPs\teKhFpHvN*DkJ$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'-"));
        boolean bl = false;
        int n2 = 0;
        long l2 = System.currentTimeMillis();
        if (a2 != null) {
            int n3;
            String[] arrstring = a2;
            int n4 = a2.length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                String string = arrstring[n3];
                if (string.equalsIgnoreCase(AbstractBuffClass.ALLATORIxDEMO("3`nq\u007fa{"))) {
                    n2 = 1;
                }
                n5 = ++n3;
            }
        }
        int n6 = 0;
        try {
            DumpMapName dumpMapName = new DumpMapName(n2 != 0);
            System.out.println(GashaponRewardSpecial.ALLATORIxDEMO("\u5016\u51dd\u5734\u5731\u5409\u7a16"));
            dumpMapName.dumpMapName();
            DumpMapName dumpMapName2 = dumpMapName;
            bl |= dumpMapName2.isHadError();
            n6 = dumpMapName2.currentId();
        }
        catch (Exception exception) {
            bl = true;
            exception.printStackTrace();
            System.out.println(n6 + " \u4ee3\u78bc.");
        }
        long l3 = System.currentTimeMillis();
        double d2 = (double)(l3 - l2) / 1000.0;
        n2 = (int)d2 % 60;
        n6 = (int)(d2 / 60.0);
        String string = "";
        if (bl) {
            string = AbstractBuffClass.ALLATORIxDEMO(">=\u6717\u933a\u8aba<>");
        }
        System.out.println(string + "\u7d50\u675f\u4f7f\u7528\u4e86 " + n6 + " \u5206\u9418 " + n2 + " \u79d2\u9418");
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean doesExist(String a) throws Exception {
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

    public /* synthetic */ DumpMapName(boolean a2) throws Exception {
        DumpMapName a3;
        DumpMapName dumpMapName = a3;
        DumpMapName dumpMapName2 = a3;
        a3.no_exist = 0;
        DumpMapName dumpMapName3 = a3;
        a3.mapids = new LinkedList<Integer>();
        dumpMapName3.alreadymapids = new LinkedList<Integer>();
        dumpMapName2.hadError = 0;
        dumpMapName2.update = false;
        dumpMapName.id = false ? 1 : 0;
        dumpMapName.update = a2;
    }

    public /* synthetic */ int currentId() {
        DumpMapName a2;
        return a2.id;
    }

    public /* synthetic */ boolean isHadError() {
        DumpMapName a2;
        return a2.hadError;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void dumpMapName(PreparedStatement a) throws Exception {
        if (!a.update) {
            a.delete(GashaponRewardSpecial.ALLATORIxDEMO("@bHbPb$aVhI\u0007s][JeW`FpF"));
            System.out.println(AbstractBuffClass.ALLATORIxDEMO("\u523f\u967a\u8cd2\u6587\u887d>bdJstnq\u007fa\u007f5\u620e\u528a0"));
        }
        var2_2 = MapleDataProviderFactory.getDataProvider(GashaponRewardSpecial.ALLATORIxDEMO("tpUmIc\ts]"));
        var3_3 = MapleDataProviderFactory.getDataProvider(AbstractBuffClass.ALLATORIxDEMO("X\u007fe0bd"));
        var4_4 = new ArrayList<E>();
        var2_2 = var2_2.getData(GashaponRewardSpecial.ALLATORIxDEMO("jeW*Ni@"));
        System.out.println(AbstractBuffClass.ALLATORIxDEMO("\u6b76\u5736\u5bfe\u517b5ioAx\u007feztjt>\u4e380;0;0"));
        var2_2 = var2_2.getChildren().iterator();
        block12: while (true) {
            if (!var2_2.hasNext()) {
                System.out.println("\u4e00\u5171\u6709" + a.mapids.size() + "\u5f35\u5730\u5716, \u91cd\u8907\u4e86" + a.alreadymapids.size() + "\u500b\u5730\u5716\u4ee3\u78bc Map.wz \u4e0d\u5b58\u5728" + a.no_exist + "\u5f35\u5730\u5716!");
                System.out.println(AbstractBuffClass.ALLATORIxDEMO("\u5bf5\u5170\u81ed5ioAx\u007feztjt>\u4e380;0"));
                return;
            }
            var4_4 = var2_2.next().getChildren().iterator();
            while (true) {
                block20: {
                    block21: {
                        block19: {
                            if (!var4_4.hasNext()) continue block12;
                            var5_6 = (MapleData)var4_4.next();
                            var6_9 = "";
                            var7_10 = "";
                            var8_11 = "";
                            var9_12 = "";
                            var10_13 = new StringBuilder();
                            var11_14 = new StringBuilder();
                            var12_15 = false;
                            var13_17 = 1;
                            var13_17 = -1;
                            try {
                                var13_17 = Integer.parseInt(var5_6.getName());
                                v0 = var3_3;
                                ** GOTO lbl36
                            }
                            catch (NumberFormatException var14_19) {
                                var12_15 = true;
                                try {
                                    v0 = var3_3;
lbl36:
                                    // 2 sources

                                    v1 = var14_18 = v0.getData(a.ALLATORIxDEMO(var13_17));
                                }
                                catch (Exception var15_20) {
                                    v1 = var14_18 = null;
                                }
                            }
                            if (v1 == null) break block19;
                            var15_21 = var14_18.getChildByPath(GashaponRewardSpecial.ALLATORIxDEMO("NjAk\bhNjL"));
                            if (var15_21 != null) {
                                var14_18 = var3_3.getData(a.ALLATORIxDEMO(MapleDataTool.getIntConvert(AbstractBuffClass.ALLATORIxDEMO("w{xz1yw{u"), (MapleData)var14_18)));
                            }
                            if (var13_17 == -1 || var12_15) break block20;
                            var6_9 = MapleDataTool.getString(GashaponRewardSpecial.ALLATORIxDEMO("wSvBaSJFiB"), var5_6, AbstractBuffClass.ALLATORIxDEMO("PZ3[_X["));
                            var7_10 = MapleDataTool.getString(GashaponRewardSpecial.ALLATORIxDEMO("JeWJFiB"), var5_6, AbstractBuffClass.ALLATORIxDEMO("PZ3[_X["));
                            var5_7 = var14_18.getChildByPath(GashaponRewardSpecial.ALLATORIxDEMO("hNbB"));
                            var12_16 = new LinkedList<Integer>();
                            if (var5_7 == null) break block20;
                            var5_8 = var5_7.iterator();
                            break block21;
                        }
                        System.out.println("\u767c\u73fe\u5730\u5716: " + var13_17 + "\u4e0d\u5b58\u5728\u65bcMap.wz\u4e2d!");
                        ++a.no_exist;
                        continue;
                    }
                    while (var5_8.hasNext()) {
                        block22: {
                            var14_18 = (MapleData)var5_8.next();
                            if (var14_18 == null) continue;
                            v2 = var14_18;
                            var14_18 = MapleDataTool.getString(v2.getChildByPath(AbstractBuffClass.ALLATORIxDEMO("age{")));
                            var15_22 = Integer.parseInt(MapleDataTool.getString(v2.getChildByPath(GashaponRewardSpecial.ALLATORIxDEMO("mC"))));
                            if (var12_16.contains(var15_22)) ** GOTO lbl-1000
                            var16_23 = -1;
                            switch (var14_18.hashCode()) {
                                case 110: {
                                    if (!var14_18.equals(AbstractBuffClass.ALLATORIxDEMO("p"))) break;
                                    v3 = var16_23 = 0;
                                    break block22;
                                }
                                case 109: {
                                    if (!var14_18.equals(GashaponRewardSpecial.ALLATORIxDEMO("J"))) break;
                                    var16_23 = 1;
                                }
                            }
                            v3 = var16_23;
                        }
                        switch (v3) {
                            case 0: {
                                var11_14.append(var15_22 + ",");
                                v4 = var12_16;
                                break;
                            }
                            case 1: {
                                var10_13.append(var15_22 + ",");
                            }
                            default: lbl-1000:
                            // 2 sources

                            {
                                v4 = var12_16;
                            }
                        }
                        v4.add(var15_22);
                    }
                    var8_11 = var10_13.length() > 0 ? var10_13.toString().substring(0, var10_13.length() - 1) : "";
                    var9_12 = var11_14.length() > 0 ? var11_14.toString().substring(0, var11_14.length() - 1) : "";
                }
                v5 = a;
                if (!a.mapids.contains(var13_17)) {
                    v5.mapids.add(var13_17);
                    v6 = a;
                    v7 = a;
                    a.setInt(1, var13_17);
                    v7.setString(2, var7_10);
                    v7.setString(3, var6_9);
                    v6.setString(4, var9_12);
                    v6.setString(5, var8_11);
                    v6.addBatch();
                    System.out.println("\u767c\u73fe\u5730\u5716: " + var13_17 + " \u540d\u7a31 " + var7_10 + " " + var6_9 + " NPC:" + var9_12 + " MOB: " + var8_11);
                    continue;
                }
                v5.alreadymapids.add(var13_17);
            }
            break;
        }
    }
}

