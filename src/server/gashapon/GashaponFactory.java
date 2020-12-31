/*
 * Decompiled with CFR 0.150.
 */
package server.gashapon;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.gashapon.Gashapon;
import tools.use.GetMACAddress;

public class GashaponFactory {
    private final /* synthetic */ Map<Integer, Gashapon> K;
    private static /* synthetic */ GashaponFactory ALLATORIxDEMO;
    private final /* synthetic */ Map<String, Gashapon> a;
    private final /* synthetic */ ReentrantReadWriteLock d;

    /*
     * Exception decompiling
     */
    public /* synthetic */ void reloadGashapons() {
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

    public /* synthetic */ Gashapon getGashaponByNpcName(String a2) {
        GashaponFactory a3;
        Gashapon gashapon = null;
        a3.d.readLock().lock();
        try {
            gashapon = a3.a.get(a2);
            return gashapon;
        }
        finally {
            a3.d.readLock().unlock();
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void reloadGashapons(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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

    public /* synthetic */ GashaponFactory() {
        GashaponFactory a2;
        GashaponFactory gashaponFactory = a2;
        a2.K = new HashMap<Integer, Gashapon>();
        gashaponFactory.a = new HashMap<String, Gashapon>();
        a2.d = new ReentrantReadWriteLock();
    }

    public static /* synthetic */ GashaponFactory getInstance() {
        if (ALLATORIxDEMO == null) {
            System.out.println(GetMACAddress.ALLATORIxDEMO("\u3073\u8b99\u53b5\u4e34\u30729$x\u0010q\u0002i\fw%x\u0000m\fk\u001a9Y#Y"));
            ALLATORIxDEMO = new GashaponFactory();
            ALLATORIxDEMO.reloadGashapons();
        }
        return ALLATORIxDEMO;
    }

    public /* synthetic */ Map<Integer, Gashapon> getgashapons() {
        GashaponFactory a2;
        return a2.K;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = null;
    }

    public /* synthetic */ Gashapon getGashaponByNpcId(int a2) {
        GashaponFactory a3;
        Gashapon gashapon = null;
        a3.d.readLock().lock();
        try {
            gashapon = a3.K.get(a2);
            return gashapon;
        }
        finally {
            a3.d.readLock().unlock();
        }
    }
}

