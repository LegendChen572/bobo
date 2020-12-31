/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 */
package tools.use.xml.cleaner;

import client.messages.commands.player.\u61a8\u61a8\u8c37;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import tools.Pair;
import tools.packet.MTSCSPacket;
import tools.use.xml.cleaner.CharacterData;

public class xmlCleaner {
    public static /* synthetic */ Document D;
    public static /* synthetic */ int FIX;
    public static /* synthetic */ Map<String, String> C;
    public static /* synthetic */ String a;
    public static /* synthetic */ NodeList j;
    public static /* synthetic */ File m;
    public static /* synthetic */ XPath L;
    public static /* synthetic */ int i;
    public static /* synthetic */ DocumentBuilder h;
    public static /* synthetic */ int M;
    public static /* synthetic */ int replacenumber;
    public static /* synthetic */ boolean d;
    public static /* synthetic */ int F;
    public static /* synthetic */ String K;
    public static /* synthetic */ boolean H;
    public static /* synthetic */ DocumentBuilderFactory f;
    public static /* synthetic */ Node ALLATORIxDEMO;
    public static /* synthetic */ String BASE_FOLDER;
    public static /* synthetic */ Collection<File> A;
    public static /* synthetic */ String g;
    public static /* synthetic */ List<String> NodeFactory;
    public static /* synthetic */ boolean k;
    public static /* synthetic */ boolean J;
    public static /* synthetic */ boolean E;
    public static /* synthetic */ Node B;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> e;
    public static /* synthetic */ int replacepet;
    public static /* synthetic */ int I;

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
    public static /* synthetic */ void main(String[] a) {
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

    public /* synthetic */ xmlCleaner() {
        xmlCleaner a2;
    }

    public static /* synthetic */ boolean skip(String a2) {
        boolean bl = false;
        if (a2.contains(MTSCSPacket.ALLATORIxDEMO("\u000b\u0004"))) {
            bl = true;
            return true;
        }
        if (a2.contains("/")) {
            bl = true;
            return true;
        }
        if (a2.contains("/")) {
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ boolean isChinese(String a2) {
        return a2.length() != a2.getBytes().length;
    }

    public static /* synthetic */ {
        f = null;
        h = null;
        D = null;
        L = null;
        j = null;
        BASE_FOLDER = "v220Char/Character";
        i = 0;
        J = false;
        M = 0;
        I = 0;
        F = 0;
        C = new LinkedHashMap<String, String>();
        H = false;
        e = new LinkedHashMap<String, List<Pair<String, String>>>();
        FIX = 0;
        E = false;
        B = null;
        k = false;
        K = "";
        replacenumber = 0;
        replacepet = 0;
        a = "";
        d = false;
        ALLATORIxDEMO = null;
        NodeFactory = new ArrayList<String>();
    }

    public static /* synthetic */ int getInt(String a2) {
        int n2 = 0;
        try {
            String string = MTSCSPacket.ALLATORIxDEMO("~t\u0015\u0007\u001cw");
            n2 = Integer.parseInt(Pattern.compile(string).matcher(a2).replaceAll("").trim());
            return n2;
        }
        catch (Exception exception) {
            return n2;
        }
    }

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(D);
            StreamResult streamResult = new StreamResult(new File(m.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(xmlCleaner.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    public static /* synthetic */ void scanSourceValues(NodeList a2, boolean a32) {
        Node a32 = null;
        int n2 = xmlCleaner.getInt(g);
        int n3 = n2 = 0;
        while (n3 < a2.getLength()) {
            a32 = a2.item(n2);
            if (a32.hasAttributes()) {
                int n4;
                int n5 = n4 = 0;
                while (n5 < a32.getAttributes().getLength()) {
                    String string = a32.getAttributes().item(n4).getNodeValue();
                    if (!string.matches(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"dV\u0012YdP\u0014BgC\u0012YdP\u0014C")) && CharacterData.NeedToRemove(string) && string.length() < 20 && !xmlCleaner.isChinese(string)) {
                        NodeFactory.add(string);
                        a32.getParentNode().removeChild(a32);
                        System.out.println("\n\u5df2\u79fb\u9664\u7bc0\u9ede: " + string);
                    }
                    n5 = ++n4;
                }
            }
            if (a32.hasChildNodes()) {
                xmlCleaner.scanSourceValues(a32.getChildNodes(), false);
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ void sortListAlphabetically(List a2) {
        Collections.sort(a2, new Comparator(){
            {
                1 a2;
            }

            public /* synthetic */ int compare(Object a2, Object a3) {
                String string = a2.toString();
                a3 = a3.toString();
                return string.compareToIgnoreCase((String)a3);
            }
        });
    }
}

