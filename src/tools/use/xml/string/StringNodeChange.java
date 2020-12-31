/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml.string;

import FuckingHackerToby.ka;
import client.MapleDiseaseValueHolder;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tools.Pair;
import tools.use.xml.swing.XMLGUI;

public class StringNodeChange {
    public static /* synthetic */ boolean d;
    public static /* synthetic */ int B;
    public static /* synthetic */ int E;
    public static /* synthetic */ String CHANGE_TO;
    public static /* synthetic */ DocumentBuilderFactory J;
    public static /* synthetic */ int g;
    public static /* synthetic */ String BASE_FOLDER;
    public static /* synthetic */ File j;
    public static /* synthetic */ String CHANGE_FROM;
    public static /* synthetic */ Document I;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> a;
    public static /* synthetic */ boolean e;
    public static /* synthetic */ Map<String, String> k;
    public static /* synthetic */ XPath F;
    public static /* synthetic */ int H;
    public static /* synthetic */ String ALLATORIxDEMO;
    public static /* synthetic */ DocumentBuilder M;
    public static /* synthetic */ NodeList C;
    public static /* synthetic */ Collection<File> i;
    public static /* synthetic */ boolean K;

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

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(I);
            StreamResult streamResult = new StreamResult(new File(j.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(StringNodeChange.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    public static /* synthetic */ boolean isNumeric(String a2) {
        int n2 = a2.length();
        while (--n2 >= 0) {
            if (Character.isDigit(a2.charAt(n2))) continue;
            return false;
        }
        return true;
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

    public static /* synthetic */ String replaceNodes(String a2) {
        String string = a2;
        if (string.contains(CHANGE_FROM)) {
            string = a2.replace(CHANGE_FROM, CHANGE_TO);
            System.out.println(a2 + "  \u5df2\u66ff\u4ee3\u70ba  " + string);
            XMLGUI.getInstance().printStringLog(a2 + "  \u5df2\u66ff\u4ee3\u70ba  " + string);
        }
        return string;
    }

    public /* synthetic */ StringNodeChange() {
        StringNodeChange a2;
    }

    public static /* synthetic */ void scanSourceValues(NodeList a2) {
        int n2;
        int n3 = 0;
        String string = "";
        String string2 = "";
        int n4 = n2 = 0;
        while (n4 < a2.getLength()) {
            Node node = a2.item(n2);
            if (node.hasAttributes()) {
                int n5;
                int n6 = n5 = 0;
                while (n6 < node.getAttributes().getLength()) {
                    int n7;
                    int n8 = 0;
                    Node node2 = node;
                    String string3 = node2.getAttributes().item(n5).getNodeValue();
                    node2.getAttributes().item(n5).setNodeValue(StringNodeChange.replaceNodes(string3));
                    if (n8 == 1) {
                        string = string3;
                        n7 = n5;
                    } else {
                        if (n8 == 2) {
                            string2 = string3;
                        }
                        n7 = n5;
                    }
                    if (n7 == 0 && StringNodeChange.isNumeric(string3)) {
                        n3 = Integer.parseInt(string3);
                    } else if (n5 == 0 && string3.equals(ka.H("{\u0007x\u0003"))) {
                        n8 = 1;
                    } else if (n5 == 0 && string3.equals(MapleDiseaseValueHolder.ALLATORIxDEMO("G\u0012P\u0014"))) {
                        n8 = 2;
                    }
                    n6 = ++n5;
                }
            }
            if (node.hasChildNodes()) {
                StringNodeChange.scanSourceValues(node.getChildNodes());
            }
            n4 = ++n2;
        }
    }

    public static /* synthetic */ {
        J = null;
        M = null;
        I = null;
        F = null;
        C = null;
        BASE_FOLDER = "String";
        H = 0;
        e = false;
        E = 0;
        g = 0;
        B = 0;
        k = new LinkedHashMap<String, String>();
        K = false;
        a = new LinkedHashMap<String, List<Pair<String, String>>>();
        d = true;
        ALLATORIxDEMO = "bobo";
        CHANGE_FROM = "\u6953\u4e4b\u8c37";
        CHANGE_TO = "XX\u8c37";
    }
}

