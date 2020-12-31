/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import database.DBConPool;
import handling.world.World;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import server.MapleItemInformationProvider;
import server.maps.MapleNodes;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Quadra;
import tools.Triple;

public class MapleEquipIdOnly {
    private static final /* synthetic */ MapleEquipIdOnly K;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ boolean d;
    private static /* synthetic */ List<Triple<Integer, Long, Long>> a;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void StartChecking() {
        System.out.println(MapleNodes.ALLATORIxDEMO("#\u0001#\u0001\u7cf5\u7d5d\u6b6d\u5704\u6aac\u67c9\u8909\u88d1\u88d3\u50b5#\u0001#\u0001"));
        a.d = true;
        if (!MapleEquipIdOnly.a.isEmpty()) {
            MapleEquipIdOnly.a.clear();
        }
        var1_1 = new StringBuilder();
        var2_2 = new StringBuilder();
        var3_5 = new ArrayList<Quadra<Integer, Integer, Long, Integer>>();
        var4_6 = new HashMap<Long, Integer>();
        var5_7 = new LinkedList<Integer>();
        var6_8 = new LinkedList<Integer>();
        try {
            var7_9 = DBConPool.getInstance().getDataSource().getConnection();
            var8_11 = var7_9.prepareStatement(MapleNodes.ALLATORIxDEMO("]iBiMx.OfM|MmXk^gH.j\\cC\fgBxI`Xa^wEzIc_.{Fi\\i.I\u007fYg\\ABbUGH.\u0012.\u001c"));
            var9_13 = var8_11.executeQuery();
            while (var9_13.next()) {
                var10_15 = var9_13.getInt(MapleNodes.ALLATORIxDEMO("OfM|MmXk^gH"));
                if (var10_15 == 0) continue;
                var5_7.add(var10_15);
            }
            var8_11.close();
            var9_13.close();
            var2_2 = new StringBuilder();
            if (var5_7.isEmpty()) ** GOTO lbl43
            var2_2.append(MapleNodes.ALLATORIxDEMO("oBj\f&Ej\f3\f"));
            var10_15 = 0;
            v0 = var10_15;
            while (v0 < var5_7.size()) {
                v1 = var10_15;
                var2_2.append(var5_7.get(v1));
                if (v1 < var5_7.size() - 1) {
                    var2_2.append(MapleNodes.ALLATORIxDEMO("\fA~.Ej\f3\f"));
                }
                v0 = ++var10_15;
            }
            try {
                var2_2.append(MapleNodes.ALLATORIxDEMO("\u0005"));
lbl43:
                // 2 sources

                var8_11 = var7_9.prepareStatement("SELECT id FROM characters WHERE gm > 0 " + var2_2);
                var9_13 = var8_11.executeQuery();
                while (var9_13.next()) {
                    var10_15 = var9_13.getInt(MapleNodes.ALLATORIxDEMO("gH"));
                    if (var10_15 == 0) continue;
                    var6_8.add(var10_15);
                }
                var8_11.close();
                var9_13.close();
                var2_2 = new StringBuilder();
                if (!var6_8.isEmpty()) {
                    var2_2.append(MapleNodes.ALLATORIxDEMO("M`H.OfM|MmXk^gH.\r3\f"));
                    var10_15 = 0;
                    v2 = var10_15;
                    while (v2 < var6_8.size()) {
                        v3 = var10_15;
                        var2_2.append(var6_8.get(v3));
                        if (v3 < var6_8.size() - 1) {
                            var2_2.append(MapleNodes.ALLATORIxDEMO(".M`H.OfM|MmXk^gH.\r3\f"));
                        }
                        v2 = ++var10_15;
                    }
                }
                var8_11 = var7_9.prepareStatement("SELECT * FROM inventoryitems WHERE equipOnlyId > 0 " + var2_2);
                var9_13 = var8_11.executeQuery();
                while (var9_13.next()) {
                    v4 = var9_13;
                    var10_15 = v4.getInt(MapleNodes.ALLATORIxDEMO("OfM|MmXk^gH"));
                    var2_3 = v4.getInt(MapleNodes.ALLATORIxDEMO("MmOaY`XgH"));
                    var11_17 = v4.getInt(MapleNodes.ALLATORIxDEMO("gXkAGH"));
                    var12_19 = v4.getLong(MapleNodes.ALLATORIxDEMO("I\u007fYg\\ABbUGH"));
                    var14_20 = v4.getLong(MapleNodes.ALLATORIxDEMO("E`ZkBzC|UgXkAgH"));
                    if (var12_19 <= 0L) continue;
                    if (var4_6.containsKey(var12_19)) {
                        if ((Integer)var4_6.get(var12_19) != var11_17) continue;
                        var3_5.add(new Quadra<Integer, Integer, Long, Integer>(var10_15, var2_3, var12_19, var11_17));
                        a.addData(var10_15, var14_20, var12_19);
                        continue;
                    }
                    var4_6.put(var12_19, var11_17);
                }
                var9_13.close();
                var8_11.close();
                var10_16 = var3_5.listIterator();
                while (var10_16.hasNext()) {
                    var1_1 = new StringBuilder();
                    var2_4 = (Quadra)var10_16.next();
                    var11_18 = (Long)var2_4.getThird();
                    var13_23 = (Integer)var2_4.getForth();
                    var8_11 = var7_9.prepareStatement("SELECT characterid FROM inventoryitems WHERE equipOnlyId = " + var11_18);
                    var9_13 = var8_11.executeQuery();
                    while (var9_13.next()) {
                        var14_21 = var9_13.getInt(MapleNodes.ALLATORIxDEMO("OfM|MmXk^gH"));
                        if (var14_21 == 0) continue;
                        var1_1.append(MapleNodes.ALLATORIxDEMO("\u89dc\u825e.w")).append(var14_21).append(MapleNodes.ALLATORIxDEMO("q"));
                    }
                    var8_11.close();
                    var9_13.close();
                    var14_22 = MapleNodes.ALLATORIxDEMO("`Yb@");
                    var14_22 = MapleItemInformationProvider.getInstance().getName(var13_23);
                    var15_24 = "\u767c\u73fe\u8907\u88fd,\u552f\u4e00ID [" + var11_18 + "] " + var1_1.toString() + " \u7269\u54c1[" + var14_22 + "](" + var13_23 + ")";
                    System.out.println(var15_24);
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var15_24));
                    FileoutputUtil.logToFile(MapleNodes.ALLATORIxDEMO("@aK}\u0003FMmG!\u892b\u88f3\u0003\u88d3\u50b5\u8909\u88d1Q\u007f_` XvX"), FileoutputUtil.NowTime() + " " + var15_24 + "\r\n");
                }
                ** if (var7_9 == null) goto lbl-1000
            }
            catch (Throwable var8_12) {
                if (var7_9 != null) {
                    try {
                        var7_9.close();
                        v5 = var8_12;
                        throw v5;
                    }
                    catch (Throwable var9_14) {
                        var8_12.addSuppressed(var9_14);
                    }
                }
                v5 = var8_12;
                throw v5;
            }
lbl-1000:
            // 1 sources

            {
                var7_9.close();
            }
lbl-1000:
            // 2 sources

            {
            }
        }
        catch (SQLException var7_10) {
            System.out.println("[EXCEPTION] \u8907\u88fd\u88dd\u5099\u51fa\u73fe\u932f\u8aa4." + var7_10);
        }
        a.d = false;
    }

    public /* synthetic */ boolean isSearching() {
        MapleEquipIdOnly a2;
        return a2.d;
    }

    public /* synthetic */ MapleEquipIdOnly() {
        MapleEquipIdOnly a2;
        MapleEquipIdOnly mapleEquipIdOnly = a2;
        mapleEquipIdOnly.d = false;
        mapleEquipIdOnly.ALLATORIxDEMO = false;
    }

    public /* synthetic */ boolean isCleaning() {
        MapleEquipIdOnly a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void removeData(int a2) {
        a.remove(a2);
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void StartCleaning() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[TRYBLOCK]], but top level block is 8[TRYBLOCK]
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
        K = new MapleEquipIdOnly();
        a = new ArrayList<Triple<Integer, Long, Long>>();
    }

    public /* synthetic */ boolean isDoing() {
        MapleEquipIdOnly a2;
        return a2.isCleaning() || a2.isSearching();
    }

    public /* synthetic */ void setCleaning(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void addData(int a2, long a3, long a4) {
        a.add(new Triple<Integer, Long, Long>(a2, a3, a4));
    }

    public /* synthetic */ List<Triple<Integer, Long, Long>> getData() {
        return a;
    }

    public /* synthetic */ void clearData() {
        if (!a.isEmpty()) {
            a.clear();
        }
    }

    public static class run
    implements Runnable {
        @Override
        public /* synthetic */ void run() {
            if (!K.isDoing()) {
                K.StartChecking();
                K.StartCleaning();
            }
        }

        public /* synthetic */ run() {
            run a2;
        }
    }
}

