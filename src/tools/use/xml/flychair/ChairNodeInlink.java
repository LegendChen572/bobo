/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml.flychair;

import handling.world.guild.MapleGuild;
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
import server.maps.MapleMapEffect;
import tools.Pair;

public class ChairNodeInlink {
    public static /* synthetic */ NodeList i;
    public static /* synthetic */ String k;
    public static /* synthetic */ File A;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> g;
    public static /* synthetic */ int C;
    public static /* synthetic */ Map<String, String> e;
    public static /* synthetic */ boolean B;
    public static /* synthetic */ String K;
    public static /* synthetic */ String d;
    public static /* synthetic */ Document L;
    public static /* synthetic */ DocumentBuilderFactory h;
    public static /* synthetic */ boolean E;
    public static /* synthetic */ DocumentBuilder D;
    public static /* synthetic */ boolean I;
    public static /* synthetic */ boolean a;
    public static /* synthetic */ XPath j;
    public static /* synthetic */ int M;
    public static /* synthetic */ String J;
    public static /* synthetic */ Collection<File> f;
    public static /* synthetic */ int H;
    public static /* synthetic */ String ALLATORIxDEMO;
    public static /* synthetic */ int F;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void main(String[] a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 13[UNCONDITIONALDOLOOP]
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

    public /* synthetic */ ChairNodeInlink() {
        ChairNodeInlink a2;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void replaceSourceValues(File a) {
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

    public static /* synthetic */ {
        h = null;
        D = null;
        L = null;
        j = null;
        i = null;
        J = "Chair";
        M = 0;
        I = false;
        F = 0;
        C = 0;
        H = 0;
        e = new LinkedHashMap<String, String>();
        E = false;
        g = new LinkedHashMap<String, List<Pair<String, String>>>();
        B = false;
        k = "bobo";
        K = "\u7531 Henry Bobo \u6279\u91cf\u88dc\u9f4ainlink\u7f3a\u5716";
        a = false;
        d = "bobo_";
        ALLATORIxDEMO = "\u7531 Henry Bobo \u6279\u91cf\u5de5\u5177\u88dc\u9f4ainlink\u7f3a\u5716";
    }

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(L);
            StreamResult streamResult = new StreamResult(new File(A.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(ChairNodeInlink.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isremoveNodes(String a2) {
        int n2;
        block8: {
            String string = a2;
            int n3 = -1;
            switch (string.hashCode()) {
                case 1524473790: {
                    if (!string.equals(MapleGuild.ALLATORIxDEMO("?m\u000eh\tj\u000b"))) break;
                    n2 = n3 = 0;
                    break block8;
                }
                case 1848648073: {
                    if (!string.equals(MapleMapEffect.ALLATORIxDEMO("C<V*R\f[!T%"))) break;
                    n3 = 1;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                return true;
            }
            case 1: {
                return true;
            }
        }
        return false;
    }
}

