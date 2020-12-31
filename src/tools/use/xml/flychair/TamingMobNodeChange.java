/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml.flychair;

import java.io.File;
import java.util.Collection;
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
import tools.use.xml.flychair.ChairNodeClear;

public class TamingMobNodeChange {
    public static /* synthetic */ XPath E;
    public static /* synthetic */ String ALLATORIxDEMO;
    public static /* synthetic */ File I;
    public static /* synthetic */ String d;
    public static /* synthetic */ NodeList g;
    public static /* synthetic */ String a;
    public static /* synthetic */ int K;
    public static /* synthetic */ int B;
    public static /* synthetic */ boolean k;
    public static /* synthetic */ DocumentBuilder H;
    public static /* synthetic */ Document e;
    public static /* synthetic */ Collection<File> F;
    public static /* synthetic */ DocumentBuilderFactory C;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void main(String[] a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 11[WHILELOOP]
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

    public static /* synthetic */ boolean chairExist(String a2) {
        Map<String, String> map = ChairNodeClear.d;
        String string = a2;
        String string2 = string.substring(1, string.length());
        return map.containsValue(string2);
    }

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(e);
            StreamResult streamResult = new StreamResult(new File(I.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(TamingMobNodeChange.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    public /* synthetic */ TamingMobNodeChange() {
        TamingMobNodeChange a2;
    }

    public static /* synthetic */ {
        C = null;
        H = null;
        e = null;
        E = null;
        g = null;
        B = 0;
        k = false;
        K = 0;
        a = "TamingMob";
        d = "sit";
        ALLATORIxDEMO = "stand1";
    }
}

