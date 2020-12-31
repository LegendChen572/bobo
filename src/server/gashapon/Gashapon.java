/*
 * Decompiled with CFR 0.150.
 */
package server.gashapon;

import client.MapleCharacter;
import client.messages.commands.player.eventSystem.AutoPickupSystem;
import database.DBConPool;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.gashapon.GashaponReward;
import tools.FilePrinter;
import tools.Pair;
import tools.use.GetMACAddress;

public final class Gashapon {
    private final /* synthetic */ String d;
    private final /* synthetic */ int a;
    private final /* synthetic */ List<Pair<Long, GashaponReward>> ALLATORIxDEMO;
    private final /* synthetic */ int K;

    public /* synthetic */ String getName() {
        Gashapon a2;
        return a2.d;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void ChangeChance(MapleCharacter a, int a, int a) {
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

    public /* synthetic */ GashaponReward generateReward() {
        Gashapon a2;
        if (a2.ALLATORIxDEMO.isEmpty()) {
            a2.reloadItems();
        }
        Gashapon gashapon = a2;
        Iterator<Pair<Long, GashaponReward>> iterator = gashapon.ALLATORIxDEMO.iterator();
        long l2 = (Long)gashapon.ALLATORIxDEMO.get((int)(a2.ALLATORIxDEMO.size() - 1)).left;
        Long l3 = Math.abs(Randomizer.nextLong() * System.currentTimeMillis() + 47L * System.currentTimeMillis()) % l2;
        while (iterator.hasNext()) {
            Pair<Long, GashaponReward> pair = iterator.next();
            if (l3 > (Long)pair.left) continue;
            if (MapleItemInformationProvider.getInstance().itemExists(((GashaponReward)pair.right).getItemId())) {
                return (GashaponReward)pair.right;
            }
            return null;
        }
        return null;
    }

    public /* synthetic */ Gashapon(int a2, int a3, String a4) {
        Gashapon a5;
        Gashapon gashapon = a5;
        a5.ALLATORIxDEMO = new LinkedList<Pair<Long, GashaponReward>>();
        a5.K = a2;
        a5.a = a3;
        a5.d = a4;
        a5.reloadItems();
    }

    public /* synthetic */ String ShowItem_GM() {
        Gashapon a2;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Pair<Long, GashaponReward>> iterator = a2.ALLATORIxDEMO.iterator();
        stringBuilder.append(AutoPickupSystem.ALLATORIxDEMO("+%\u6b6c\u8f0e\u86c3\u6a18\u7261\u5486\u6701}\u0005M"));
        while (iterator.hasNext()) {
            Pair<Long, GashaponReward> pair = iterator.next();
            if (!MapleItemInformationProvider.getInstance().itemExists(((GashaponReward)pair.right).getItemId())) continue;
            stringBuilder.append("#L" + ((GashaponReward)pair.right).getItemId() + "##v" + ((GashaponReward)pair.right).getItemId() + "##z" + ((GashaponReward)pair.right).getItemId() + "# \u6a5f\u7387:" + ((GashaponReward)pair.right).getChance() + "(\u9ede\u9078\u66f4\u6539)\r\n");
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String ShowItem(String a2) {
        Gashapon a3;
        StringBuilder stringBuilder = new StringBuilder();
        if (a2 == "GM" && (a3.ALLATORIxDEMO.isEmpty() || a3.ALLATORIxDEMO == null)) {
            StringBuilder stringBuilder2 = stringBuilder;
            stringBuilder2.append(AutoPickupSystem.ALLATORIxDEMO("J\u0002djdDv8w8w+\u6256\u8989\u65f7\u5896\u8f0e\u86c3\u6a18\u7261\u5486)f++\u0005M"));
            return stringBuilder2.toString();
        }
        Iterator<Pair<Long, GashaponReward>> iterator = a3.ALLATORIxDEMO.iterator();
        stringBuilder.append(GetMACAddress.ALLATORIxDEMO(":\u0001\u6b7d\u8f2a\u86d2\u6a3c\u7270\u54a2\u6710Y\u0014i"));
        if (a2 == "GM") {
            stringBuilder.append(AutoPickupSystem.ALLATORIxDEMO("J\u0002djdDv8w8w+\u6256\u8989\u65f7\u5896\u8f0e\u86c3\u6a18\u7261\u5486)f++\u0005M"));
        }
        block10: while (true) {
            int n2;
            Pair<Long, GashaponReward> pair;
            block14: {
                if (!iterator.hasNext()) {
                    return stringBuilder.toString();
                }
                pair = iterator.next();
                if (!MapleItemInformationProvider.getInstance().itemExists(((GashaponReward)pair.right).getItemId())) continue;
                String string = a2;
                int n3 = -1;
                switch (string.hashCode()) {
                    case 49: {
                        if (!string.equals("1")) break;
                        n2 = n3 = 0;
                        break block14;
                    }
                    case 50: {
                        if (!string.equals("2")) break;
                        n2 = n3 = 1;
                        break block14;
                    }
                    case 2278: {
                        if (!string.equals("GM")) break;
                        n3 = 2;
                    }
                }
                n2 = n3;
            }
            switch (n2) {
                case 0: {
                    if (((GashaponReward)pair.right).getChance() <= 0) continue block10;
                    stringBuilder.append("#i" + ((GashaponReward)pair.right).getItemId() + ":#");
                    continue block10;
                }
                case 1: {
                    if (((GashaponReward)pair.right).getChance() <= 0) continue block10;
                    stringBuilder.append("#v" + ((GashaponReward)pair.right).getItemId() + "#  \u9053\u5177\u540d\u7a31: #z" + ((GashaponReward)pair.right).getItemId() + "#\r\n");
                    continue block10;
                }
                case 2: {
                    stringBuilder.append("#L" + ((GashaponReward)pair.right).getItemId() + "##v" + ((GashaponReward)pair.right).getItemId() + "##z" + ((GashaponReward)pair.right).getItemId() + "# \u6a5f\u7387:" + ((GashaponReward)pair.right).getChance() + "(\u9ede\u9078\u66f4\u6539)\r\n");
                    continue block10;
                }
            }
            stringBuilder.append(GetMACAddress.ALLATORIxDEMO("\u6364\u5b83\u980c\u7923\u57e8\u6152\u934c\u8abdB"));
        }
    }

    public /* synthetic */ int getNpcId() {
        Gashapon a2;
        return a2.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void reloadItems() {
        block20: {
            block19: {
                block18: {
                    var1_1 = DBConPool.getInstance().ColumnExist(GetMACAddress.ALLATORIxDEMO("~\u0002j\u000bx\u0013v\rF\nm\u0006t\u0010"), AutoPickupSystem.ALLATORIxDEMO("*i?"));
                    var2_2 = 0L;
                    try {
                        var4_3 = DBConPool.getInstance().getDataSource().getConnection();
                        var5_5 = var4_3.prepareStatement(GetMACAddress.ALLATORIxDEMO("J&U&Z79I9%K,TC~\u0002j\u000bx\u0013v\rF\nm\u0006t\u001094Q&K&9\u0004x\u0010q\u0002i\fw\u0010p\u00079^9\\9,K'\\19!@Cp\u0017|\u000ep\u00079\"J "));
                        try {
                            v0 = var5_5;
                            v0.setInt(1, a.getId());
                            var6_7 = v0.executeQuery();
lbl11:
                            // 2 sources

                            while (var6_7.next()) {
                                if (!var1_1) break block18;
                                var7_10 = new GashaponReward(var6_7.getInt(AutoPickupSystem.ALLATORIxDEMO("a3m*a#")), var6_7.getInt(GetMACAddress.ALLATORIxDEMO("z\u000bx\rz\u0006")), var6_7.getBoolean(AutoPickupSystem.ALLATORIxDEMO("4`(\u007f*{ ")), var6_7.getInt(GetMACAddress.ALLATORIxDEMO("\u000ep\r")), var6_7.getInt(AutoPickupSystem.ALLATORIxDEMO("*i?")));
                                v1 = var2_2;
                                break block19;
                            }
                            break block20;
                        }
                        catch (Throwable var6_8) {
                            if (var5_5 != null) {
                                try {
                                    var5_5.close();
                                    v2 = var6_8;
                                    throw v2;
                                }
                                catch (Throwable var7_11) {
                                    var6_8.addSuppressed(var7_11);
                                }
                            }
                            v2 = var6_8;
                            throw v2;
                        }
                    }
                    catch (SQLException var4_4) {
                        FilePrinter.printError(AutoPickupSystem.ALLATORIxDEMO("O&{/i7g)&3p3"), var4_4, GetMACAddress.ALLATORIxDEMO("\u0011|\u000fv\u0002}*m\u0006t\u0010"));
                        return;
                    }
                    catch (Throwable var5_6) {
                        if (var4_3 != null) {
                            try {
                                var4_3.close();
                                v3 = var5_6;
                                throw v3;
                            }
                            catch (Throwable var6_9) {
                                var5_6.addSuppressed(var6_9);
                            }
                        }
                        v3 = var5_6;
                        throw v3;
                    }
                }
                var7_10 = new GashaponReward(var6_7.getInt(GetMACAddress.ALLATORIxDEMO("p\u0017|\u000ep\u0007")), var6_7.getInt(AutoPickupSystem.ALLATORIxDEMO("k/i)k\"")), var6_7.getBoolean(GetMACAddress.ALLATORIxDEMO("\u0010q\fn\u000ej\u0004")));
                v1 = var2_2;
            }
            var2_2 = v1 + (long)var7_10.getChance();
            a.ALLATORIxDEMO.add(new Pair<Long, GashaponReward>(var2_2, var7_10));
            ** GOTO lbl11
        }
        if (var5_5 != null) {
            v4 = var4_3;
            var5_5.close();
        } else {
            v4 = var4_3;
        }
        if (v4 == null) return;
        var4_3.close();
    }

    public /* synthetic */ int getId() {
        Gashapon a2;
        return a2.K;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void AddItem(MapleCharacter a, int a, int a, boolean a) {
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
}

