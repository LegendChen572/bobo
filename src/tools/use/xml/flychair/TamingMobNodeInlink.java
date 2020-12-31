/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5154\u5154\u8c37
 */
package tools.use.xml.flychair;

import client.messages.commands.player.\u5154\u5154\u8c37;
import handling.world.MapleParty;
import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import tools.Pair;

public class TamingMobNodeInlink {
    public static /* synthetic */ String ALLATORIxDEMO;
    public static /* synthetic */ Collection<File> h;
    public static /* synthetic */ boolean I;
    public static /* synthetic */ int C;
    public static /* synthetic */ boolean E;
    public static /* synthetic */ DocumentBuilder L;
    public static /* synthetic */ boolean removeNodes;
    public static /* synthetic */ String K;
    public static /* synthetic */ int F;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> g;
    public static /* synthetic */ NodeList J;
    public static /* synthetic */ String d;
    public static /* synthetic */ Map<String, String> e;
    public static /* synthetic */ File f;
    public static /* synthetic */ String k;
    public static /* synthetic */ DocumentBuilderFactory D;
    public static /* synthetic */ XPath i;
    public static /* synthetic */ int M;
    public static /* synthetic */ String BASE_FOLDER;
    public static /* synthetic */ Document j;
    public static /* synthetic */ boolean B;
    public static /* synthetic */ int H;
    public static /* synthetic */ boolean a;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void main(String[] a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 11[UNCONDITIONALDOLOOP]
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
    public static /* synthetic */ void replaceSourceValues(File a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK], 13[DOLOOP]], but top level block is 7[CATCHBLOCK]
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

    public /* synthetic */ TamingMobNodeInlink() {
        TamingMobNodeInlink a2;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean isreplaceNodes(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(SwitchStringRewriter.java:379)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$200(SwitchStringRewriter.java:50)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:343)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:197)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:70)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:837)
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

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(j);
            StreamResult streamResult = new StreamResult(new File(f.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(TamingMobNodeInlink.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    public static /* synthetic */ {
        D = null;
        L = null;
        j = null;
        i = null;
        J = null;
        BASE_FOLDER = "TamingMob";
        M = 0;
        I = false;
        F = 0;
        C = 0;
        H = 0;
        e = new LinkedHashMap<String, String>();
        E = false;
        g = new LinkedHashMap<String, List<Pair<String, String>>>();
        B = true;
        k = "bobo";
        K = "\u88dc\u9f4ainlink\u7f3a\u5716 by Henry Bobo \u6279\u91cf\u5de5\u5177,\u6b64\u70ba\u514d\u8cbb\u5de5\u5177\u52ff\u9032\u884c\u5546\u696d\u7528\u9014!";
        removeNodes = true;
        a = true;
        d = "bobo_";
        ALLATORIxDEMO = "by Henry Bobo \u6279\u91cf\u5de5\u5177\u88dc\u9f4ainlink\u7f3a\u5716";
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isremoveNodes(String a2) {
        int n2;
        block8: {
            if (!removeNodes) {
                return false;
            }
            String string = a2;
            int n3 = -1;
            switch (string.hashCode()) {
                case 1605853887: {
                    if (!string.equals(MapleParty.ALLATORIxDEMO("z\u0018x\u0002x\u0013m\u0015k1z\u0004p\u001fw"))) break;
                    n2 = n3 = 0;
                    break block8;
                }
                case -445197285: {
                    if (!string.equals(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"GcSoHbFEUiL"))) break;
                    n3 = 1;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void saveFile(Document a2, String a3) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(a2);
            StreamResult streamResult = new StreamResult(new File(a3));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            System.err.println("\r\nError 3: " + a3 + "\r\n");
            return;
        }
    }
}

