/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import server.buffs.AbstractBuffClass;
import tools.Pair;
import tools.npcgenerator.NPCMessage;

public class removeChild {
    public static /* synthetic */ Map<String, String> M;
    public static /* synthetic */ int replacenumber;
    public static /* synthetic */ Document A;
    public static /* synthetic */ boolean I;
    public static /* synthetic */ String K;
    public static /* synthetic */ String H;
    public static /* synthetic */ DocumentBuilder m;
    public static /* synthetic */ boolean L;
    public static /* synthetic */ DocumentBuilderFactory l;
    public static /* synthetic */ String B;
    public static /* synthetic */ String BASE_FOLDER;
    public static /* synthetic */ int replacepet;
    public static /* synthetic */ Node ALLATORIxDEMO;
    public static /* synthetic */ int i;
    public static /* synthetic */ int D;
    public static /* synthetic */ String a;
    public static /* synthetic */ int J;
    public static /* synthetic */ int FIX;
    public static /* synthetic */ boolean g;
    public static /* synthetic */ boolean C;
    public static /* synthetic */ boolean d;
    public static /* synthetic */ String k;
    public static /* synthetic */ Node e;
    public static /* synthetic */ File b;
    public static /* synthetic */ NodeList h;
    public static /* synthetic */ XPath f;
    public static /* synthetic */ int j;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> F;
    public static /* synthetic */ boolean E;
    public static /* synthetic */ Collection<File> c;

    public static /* synthetic */ {
        l = null;
        m = null;
        A = null;
        f = null;
        h = null;
        BASE_FOLDER = "";
        D = 0;
        L = false;
        j = 0;
        i = 0;
        J = 0;
        M = new LinkedHashMap<String, String>();
        I = false;
        F = new LinkedHashMap<String, List<Pair<String, String>>>();
        FIX = 0;
        C = false;
        e = null;
        E = false;
        g = true;
        B = "bobo";
        k = "\u88dc\u9f4ainlink,outlink,source\u7f3a\u5716 by Henry Bobo \u6279\u91cf\u5de5\u5177";
        K = "";
        replacenumber = 0;
        replacepet = 0;
        a = "";
        d = false;
        ALLATORIxDEMO = null;
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

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void remove(String a, String[] a) {
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

    public static /* synthetic */ int getInt(String a2) {
        int n2 = 0;
        try {
            String string = AbstractBuffClass.ALLATORIxDEMO("N@%3,C");
            n2 = Integer.parseInt(Pattern.compile(string).matcher(a2).replaceAll("").trim());
            return n2;
        }
        catch (Exception exception) {
            return n2;
        }
    }

    public /* synthetic */ removeChild() {
        removeChild a2;
    }

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(A);
            StreamResult streamResult = new StreamResult(new File(b.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(removeChild.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    public static /* synthetic */ void scanSourceValues(NodeList a2, boolean a32, String[] a4) {
        Node a32 = null;
        int n2 = removeChild.getInt(H);
        int n3 = n2 = 0;
        while (n3 < a2.getLength()) {
            a32 = a2.item(n2);
            if (a32.hasAttributes()) {
                int n4;
                int n5 = n4 = 0;
                while (n5 < a32.getAttributes().getLength()) {
                    boolean bl;
                    String string;
                    block7: {
                        int n6;
                        string = a32.getAttributes().item(n4).getNodeValue();
                        boolean bl2 = false;
                        int n7 = n6 = 0;
                        while (n7 < a4.length) {
                            if (a4[n6].equals(string)) {
                                bl = bl2 = true;
                                break block7;
                            }
                            n7 = ++n6;
                        }
                        bl = bl2;
                    }
                    if (bl) {
                        a32.getParentNode().removeChild(a32);
                        ++D;
                    }
                    a = string;
                    n5 = ++n4;
                }
            }
            if (a32.hasChildNodes()) {
                removeChild.scanSourceValues(a32.getChildNodes(), false, a4);
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ boolean isNumeric(String a2) {
        return a2.matches(NPCMessage.ALLATORIxDEMO("@M6B@K0YCX6B@K0X"));
    }
}

