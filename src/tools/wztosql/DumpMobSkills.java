/*
 * Decompiled with CFR 0.150.
 */
package tools.wztosql;

import client.MapleCoreAura;
import handling.channel.handler.PlayerHandler;
import java.awt.Point;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;

public class DumpMobSkills {
    private final /* synthetic */ MapleDataProvider ALLATORIxDEMO;
    public /* synthetic */ boolean hadError;
    public /* synthetic */ int id;
    public /* synthetic */ boolean update;

    public /* synthetic */ boolean isHadError() {
        DumpMobSkills a2;
        return a2.hadError;
    }

    public /* synthetic */ void dumpMobSkills(PreparedStatement a2) throws Exception {
        DumpMobSkills a3;
        if (!a3.update) {
            a3.delete(MapleCoreAura.ALLATORIxDEMO("H5@5X5,6^?AP{\nS\u001dc\u0012\u007f\u001be\u001c`\u0014m\u0004m"));
            System.out.println(PlayerHandler.ALLATORIxDEMO("\u0016p>p&p65%o\rx=w!~;y>q3a35!`1v7f!s'y>l|"));
        }
        MapleData mapleData = a3.ALLATORIxDEMO.getData(MapleCoreAura.ALLATORIxDEMO("=c\u0012_\u001be\u001c`^e\u001dk"));
        System.out.println(PlayerHandler.ALLATORIxDEMO("T6q;{55;{&zrb(J?z0f9|>y6t&t|;|;|"));
        for (MapleData mapleData2 : mapleData.getChildren()) {
            Iterator<MapleData> iterator = mapleData2.getChildByPath(MapleCoreAura.ALLATORIxDEMO("`\u0015z\u0015`")).getChildren().iterator();
            while (iterator.hasNext()) {
                PreparedStatement preparedStatement;
                MapleData mapleData3;
                Object object;
                ArrayList<Integer> arrayList;
                Serializable serializable;
                StringBuilder stringBuilder;
                int n2;
                MapleData mapleData4;
                Iterator<MapleData> iterator2;
                block13: {
                    int n3;
                    mapleData4 = iterator2.next();
                    a3.id = Integer.parseInt(mapleData2.getName());
                    n2 = Integer.parseInt(mapleData4.getName());
                    if (a3.update) {
                        DumpMobSkills dumpMobSkills = a3;
                        if (dumpMobSkills.doesExist("SELECT * FROM wz_mobskilldata WHERE skillid = " + dumpMobSkills.id + " AND level = " + n2)) {
                            iterator = iterator2;
                            continue;
                        }
                    }
                    PreparedStatement preparedStatement2 = a2;
                    PreparedStatement preparedStatement3 = a2;
                    PreparedStatement preparedStatement4 = a2;
                    PreparedStatement preparedStatement5 = a2;
                    PreparedStatement preparedStatement6 = a2;
                    preparedStatement6.setInt(1, a3.id);
                    preparedStatement6.setInt(2, n2);
                    preparedStatement5.setInt(3, MapleDataTool.getInt(PlayerHandler.ALLATORIxDEMO("}\""), mapleData4, 100));
                    preparedStatement5.setInt(4, MapleDataTool.getInt(MapleCoreAura.ALLATORIxDEMO("a\u0000O\u001fb"), mapleData4, 0));
                    preparedStatement4.setInt(5, MapleDataTool.getInt(PlayerHandler.ALLATORIxDEMO("*"), mapleData4, 1));
                    preparedStatement4.setInt(6, MapleDataTool.getInt(MapleCoreAura.ALLATORIxDEMO("u"), mapleData4, 1));
                    preparedStatement3.setInt(7, MapleDataTool.getInt(PlayerHandler.ALLATORIxDEMO("a;x7"), mapleData4, 0));
                    preparedStatement3.setInt(8, MapleDataTool.getInt(MapleCoreAura.ALLATORIxDEMO("\u0000~\u001f|"), mapleData4, 100));
                    preparedStatement2.setInt(9, MapleDataTool.getInt(PlayerHandler.ALLATORIxDEMO(">|?|&"), mapleData4, 0));
                    preparedStatement2.setInt(10, MapleDataTool.getInt(MapleCoreAura.ALLATORIxDEMO("\u0003y\u001da\u001fb5j\u0016i\u0013x"), mapleData4, 0));
                    a2.setInt(11, MapleDataTool.getInt(PlayerHandler.ALLATORIxDEMO("|<a7g$t>"), mapleData4, 0));
                    stringBuilder = new StringBuilder();
                    serializable = new ArrayList<Integer>();
                    int n4 = n3 = 0;
                    while (n4 > -1) {
                        if (mapleData4.getChildByPath(String.valueOf(n3)) == null) {
                            arrayList = serializable;
                            break block13;
                        }
                        MapleData mapleData5 = mapleData4.getChildByPath(String.valueOf(n3));
                        serializable.add(MapleDataTool.getInt(mapleData5, 0));
                        n4 = ++n3;
                    }
                    arrayList = serializable;
                }
                Iterator iterator3 = arrayList.iterator();
                while (iterator3.hasNext()) {
                    serializable = (Integer)object.next();
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(MapleCoreAura.ALLATORIxDEMO("\\,"));
                    }
                    stringBuilder.append(String.valueOf(serializable));
                    iterator3 = object;
                }
                a2.setString(12, stringBuilder.toString());
                if (mapleData4.getChildByPath(PlayerHandler.ALLATORIxDEMO("y&")) != null) {
                    object = (Point)mapleData4.getChildByPath(MapleCoreAura.ALLATORIxDEMO("\u001cx")).getData();
                    mapleData3 = mapleData4;
                    PreparedStatement preparedStatement7 = a2;
                    preparedStatement7.setInt(13, ((Point)object).x);
                    preparedStatement7.setInt(14, ((Point)object).y);
                } else {
                    a2.setInt(13, 0);
                    a2.setInt(14, 0);
                    mapleData3 = mapleData4;
                }
                if (mapleData3.getChildByPath(PlayerHandler.ALLATORIxDEMO("g0")) != null) {
                    object = (Point)mapleData4.getChildByPath(MapleCoreAura.ALLATORIxDEMO("\u0002n")).getData();
                    PreparedStatement preparedStatement8 = a2;
                    preparedStatement = preparedStatement8;
                    preparedStatement8.setInt(15, ((Point)object).x);
                    preparedStatement8.setInt(16, ((Point)object).y);
                } else {
                    preparedStatement = a2;
                    PreparedStatement preparedStatement9 = a2;
                    preparedStatement9.setInt(15, 0);
                    preparedStatement9.setInt(16, 0);
                }
                preparedStatement.setByte(17, (byte)(MapleDataTool.getInt(PlayerHandler.ALLATORIxDEMO("f'x?z<Z<v7"), mapleData4, 0) > 0 ? 1 : 0));
                System.out.println("Added skill: " + a3.id + " level " + n2);
                iterator = iterator2;
                a2.addBatch();
            }
        }
        System.out.println(MapleCoreAura.ALLATORIxDEMO("H\u001fb\u0015,\u0007v/a\u001fn\u0003g\u0019`\u001ch\u0011x\u0011\"^\""));
    }

    public /* synthetic */ int currentId() {
        DumpMobSkills a2;
        return a2.id;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void dumpMobSkills() throws Exception {
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

    public /* synthetic */ DumpMobSkills(boolean a2) throws Exception {
        DumpMobSkills a3;
        DumpMobSkills dumpMobSkills = a3;
        a3.hadError = false;
        dumpMobSkills.update = false;
        dumpMobSkills.id = 0;
        a3.update = a2;
        a3.ALLATORIxDEMO = MapleDataProviderFactory.getDataProvider(PlayerHandler.ALLATORIxDEMO("F9|>y|b("));
        if (a3.ALLATORIxDEMO == null) {
            a3.hadError = true;
        }
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

    public static /* synthetic */ void start(String[] a2) {
        int n2;
        boolean bl = false;
        int n3 = 0;
        long l2 = System.currentTimeMillis();
        String[] arrstring = a2;
        int n4 = a2.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            String string = arrstring[n2];
            if (string.equalsIgnoreCase(PlayerHandler.ALLATORIxDEMO("\u007f`\"q3a7"))) {
                n3 = 1;
            }
            n5 = ++n2;
        }
        int n6 = 0;
        try {
            DumpMobSkills dumpMobSkills = new DumpMobSkills(n3 != 0);
            System.out.println(MapleCoreAura.ALLATORIxDEMO("H\u0005a\u0000e\u001ekPa\u001fn\u0003g\u0019`\u001c\u007f"));
            dumpMobSkills.dumpMobSkills();
            DumpMobSkills dumpMobSkills2 = dumpMobSkills;
            bl |= dumpMobSkills2.isHadError();
            n6 = dumpMobSkills2.currentId();
        }
        catch (Exception exception) {
            bl = true;
            System.out.println(exception);
            System.out.println(n6 + " skill.");
        }
        long l3 = System.currentTimeMillis();
        double d2 = (double)(l3 - l2) / 1000.0;
        n3 = (int)d2 % 60;
        n6 = (int)(d2 / 60.0);
        String string = "";
        if (bl) {
            string = PlayerHandler.ALLATORIxDEMO("5%|&}rp g=g!");
        }
        System.out.println("Finished" + string + " in " + n6 + " minutes " + n3 + " seconds");
    }
}

