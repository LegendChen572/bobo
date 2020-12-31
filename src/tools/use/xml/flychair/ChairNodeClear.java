/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml.flychair;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
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
import server.Extend.SpecialItemData;
import tools.FixDropNullItem;

public class ChairNodeClear {
    public static /* synthetic */ int a;
    public static /* synthetic */ Map<String, String> d;
    public static /* synthetic */ DocumentBuilder H;
    public static /* synthetic */ boolean K;
    public static /* synthetic */ String B;
    public static /* synthetic */ Collection<File> F;
    public static /* synthetic */ NodeList g;
    public static /* synthetic */ XPath E;
    public static /* synthetic */ Document e;
    public static /* synthetic */ boolean ALLATORIxDEMO;
    public static /* synthetic */ File I;
    public static /* synthetic */ int k;
    public static /* synthetic */ DocumentBuilderFactory C;

    public static /* synthetic */ {
        C = null;
        H = null;
        e = null;
        E = null;
        g = null;
        B = "Chair";
        k = 0;
        K = false;
        a = 0;
        d = new LinkedHashMap<String, String>();
        ALLATORIxDEMO = false;
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
            Logger.getLogger(ChairNodeClear.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

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
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isremoveNodes(String a2) {
        int n2;
        block7: {
            String string = a2;
            int n3 = -1;
            switch (string.hashCode()) {
                case 1524473790: {
                    if (!string.equals(FixDropNullItem.ALLATORIxDEMO("\u0019_(Z/X-"))) break;
                    n2 = n3 = 0;
                    break block7;
                }
                case 1251979017: {
                    if (!string.equals(SpecialItemData.ALLATORIxDEMO("w\\]GDZFX"))) break;
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

    public /* synthetic */ ChairNodeClear() {
        ChairNodeClear a2;
    }
}

