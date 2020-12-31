/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import constants.SpecialSkillConstants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import server.Randomizer;
import server.shark.SharkReader;
import tools.Pair;

public class MapleOxQuizFactory {
    private final /* synthetic */ Map<Pair<Integer, Integer>, MapleOxQuizEntry> d;
    private static final /* synthetic */ MapleOxQuizFactory ALLATORIxDEMO;
    private /* synthetic */ boolean a;

    public static /* synthetic */ MapleOxQuizEntry getOxEntry(Pair<Integer, Integer> a2) {
        return MapleOxQuizFactory.ALLATORIxDEMO.getOxQuizEntry(a2);
    }

    private /* synthetic */ int ALLATORIxDEMO(String a2) {
        if (a2.equalsIgnoreCase(SpecialSkillConstants.ALLATORIxDEMO("O"))) {
            return 0;
        }
        if (a2.equalsIgnoreCase(SharkReader.ALLATORIxDEMO(","))) {
            return 1;
        }
        return -1;
    }

    public /* synthetic */ Map.Entry<Pair<Integer, Integer>, MapleOxQuizEntry> grabRandomQuestion() {
        Map.Entry<Pair<Integer, Integer>, MapleOxQuizEntry> entry;
        MapleOxQuizFactory a2;
        int n2 = a2.d.size();
        block0: while (true) {
            Iterator<Map.Entry<Pair<Integer, Integer>, MapleOxQuizEntry>> iterator = a2.d.entrySet().iterator();
            do {
                if (!iterator.hasNext()) continue block0;
                entry = iterator.next();
            } while (Randomizer.nextInt(n2) != 0);
            break;
        }
        return entry;
    }

    public /* synthetic */ boolean hasInitialized() {
        MapleOxQuizFactory a2;
        return a2.a;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void initialize() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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
        ALLATORIxDEMO = new MapleOxQuizFactory();
    }

    public /* synthetic */ MapleOxQuizFactory() {
        MapleOxQuizFactory a2;
        a2.a = false;
        MapleOxQuizFactory mapleOxQuizFactory = a2;
        a2.d = new HashMap<Pair<Integer, Integer>, MapleOxQuizEntry>();
    }

    private /* synthetic */ MapleOxQuizEntry ALLATORIxDEMO(ResultSet a2) throws SQLException {
        MapleOxQuizFactory a3;
        return new MapleOxQuizEntry(a2.getString(SharkReader.ALLATORIxDEMO("#670&*=-")), a2.getString(SpecialSkillConstants.ALLATORIxDEMO("S\u001bD\u0002[\u0013N")), a3.ALLATORIxDEMO(a2.getString(SharkReader.ALLATORIxDEMO("3-!471"))), a2.getInt(SpecialSkillConstants.ALLATORIxDEMO("F\u0007R\u0001C\u001bX\u001cD\u0017C")), a2.getInt(SharkReader.ALLATORIxDEMO("#670&*=-;'")));
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ MapleOxQuizEntry getFromSQL(String a) {
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

    public static /* synthetic */ MapleOxQuizEntry getOxEntry(int a2, int a3) {
        return MapleOxQuizFactory.ALLATORIxDEMO.getOxQuizEntry(new Pair<Integer, Integer>(a2, a3));
    }

    public /* synthetic */ MapleOxQuizEntry getOxQuizEntry(Pair<Integer, Integer> a2) {
        MapleOxQuizFactory a3;
        MapleOxQuizEntry mapleOxQuizEntry = a3.d.get(a2);
        if (mapleOxQuizEntry == null) {
            if (a3.a) {
                return null;
            }
            mapleOxQuizEntry = a3.getFromSQL("SELECT * FROM wz_oxdata WHERE questionset = " + a2.getLeft() + " AND questionid = " + a2.getRight());
            a3.d.put(a2, mapleOxQuizEntry);
        }
        return mapleOxQuizEntry;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void reloadOX() {
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

    public static class MapleOxQuizEntry {
        private final /* synthetic */ String K;
        private final /* synthetic */ int d;
        private final /* synthetic */ int ALLATORIxDEMO;
        private final /* synthetic */ String k;
        private final /* synthetic */ int a;

        public /* synthetic */ int getQuestionId() {
            MapleOxQuizEntry a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getAnswer() {
            MapleOxQuizEntry a2;
            return a2.a;
        }

        public /* synthetic */ MapleOxQuizEntry(String a2, String a3, int a4, int a5, int a6) {
            MapleOxQuizEntry a7;
            MapleOxQuizEntry mapleOxQuizEntry = a7;
            MapleOxQuizEntry mapleOxQuizEntry2 = a7;
            a7.k = a2;
            mapleOxQuizEntry2.K = a3;
            mapleOxQuizEntry2.a = a4;
            mapleOxQuizEntry.d = a5;
            mapleOxQuizEntry.ALLATORIxDEMO = a6;
        }

        public /* synthetic */ String getAnswerText() {
            MapleOxQuizEntry a2;
            return a2.K;
        }

        public /* synthetic */ String getQuestion() {
            MapleOxQuizEntry a2;
            return a2.k;
        }

        public /* synthetic */ int getQuestionSet() {
            MapleOxQuizEntry a2;
            return a2.d;
        }
    }
}

