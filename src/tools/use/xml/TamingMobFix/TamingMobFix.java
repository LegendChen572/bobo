/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml.TamingMobFix;

import client.messages.ConsoleCommandExecute;
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import server.Timer;
import tools.Pair;

public class TamingMobFix {
    public static /* synthetic */ XPath i;
    public static /* synthetic */ boolean I;
    public static /* synthetic */ Map<String, String> e;
    public static /* synthetic */ File f;
    public static /* synthetic */ Node d;
    public static /* synthetic */ String CHANGE_TO;
    public static /* synthetic */ boolean B;
    public static /* synthetic */ String BASE_FOLDER;
    public static /* synthetic */ int C;
    public static /* synthetic */ int M;
    public static /* synthetic */ NodeList J;
    public static /* synthetic */ Document j;
    public static /* synthetic */ DocumentBuilderFactory D;
    public static /* synthetic */ int F;
    public static /* synthetic */ boolean E;
    public static /* synthetic */ int H;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> g;
    public static /* synthetic */ String CHANGE_FROM;
    public static /* synthetic */ DocumentBuilder L;
    public static /* synthetic */ boolean K;
    public static /* synthetic */ Collection<File> h;
    public static /* synthetic */ String a;
    public static /* synthetic */ String k;
    public static /* synthetic */ boolean ALLATORIxDEMO;
    public static /* synthetic */ int FIX;

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
            Logger.getLogger(TamingMobFix.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean TamingMobValueExist(String a2) {
        int n2;
        block13: {
            String string = a2;
            int n3 = -1;
            switch (string.hashCode()) {
                case 49: {
                    if (!string.equals("1")) break;
                    n2 = n3 = 0;
                    break block13;
                }
                case 50: {
                    if (!string.equals("2")) break;
                    n2 = n3 = 1;
                    break block13;
                }
                case 51: {
                    if (!string.equals("3")) break;
                    n2 = n3 = 2;
                    break block13;
                }
                case 52: {
                    if (!string.equals("4")) break;
                    n2 = n3 = 3;
                    break block13;
                }
                case 53: {
                    if (!string.equals(Timer.ALLATORIxDEMO("!"))) break;
                    n2 = n3 = 4;
                    break block13;
                }
                case 54: {
                    if (!string.equals(ConsoleCommandExecute.ALLATORIxDEMO("1"))) break;
                    n2 = n3 = 5;
                    break block13;
                }
                case 55: {
                    if (!string.equals(Timer.ALLATORIxDEMO("#"))) break;
                    n2 = n3 = 6;
                    break block13;
                }
                case 56: {
                    if (!string.equals(ConsoleCommandExecute.ALLATORIxDEMO("?"))) break;
                    n3 = 7;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
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

    public static /* synthetic */ String FixNodes(String a2) {
        String string = a2;
        if (string.equals(ConsoleCommandExecute.ALLATORIxDEMO("s,j$i*J\"e"))) {
            FIX = 2;
        }
        return string;
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
        CHANGE_FROM = "\u6953\u4e4b\u8c37";
        CHANGE_TO = "XX\u8c37";
        FIX = 0;
        K = false;
        d = null;
        ALLATORIxDEMO = false;
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

    public static /* synthetic */ String replaceNodes(String a2) {
        String string = a2;
        if (string.contains(CHANGE_FROM)) {
            string = a2.replace(CHANGE_FROM, CHANGE_TO);
            System.out.println(a2 + "  \u5df2\u66ff\u4ee3\u70ba  " + string);
        }
        return string;
    }

    public /* synthetic */ TamingMobFix() {
        TamingMobFix a2;
    }

    public static /* synthetic */ void scanSourceValues(NodeList a2, boolean a3) {
        int n2;
        Node node = null;
        node = null;
        int n3 = n2 = 0;
        while (n3 < a2.getLength()) {
            node = a2.item(n2);
            if (node.hasAttributes()) {
                int n4;
                int n5 = n4 = 0;
                while (n5 < node.getAttributes().getLength()) {
                    String string = node.getAttributes().item(n4).getNodeValue();
                    System.out.println(string);
                    if (string.equals(ConsoleCommandExecute.ALLATORIxDEMO("$i+h"))) {
                        d = a2.item(n2);
                    }
                    if (string.equals(Timer.ALLATORIxDEMO("`\u0001y\tz\u0007Y\u000fv"))) {
                        int n6 = n4 + 1;
                        if (!TamingMobFix.TamingMobValueExist(node.getAttributes().item(n6).getNodeValue())) {
                            node.getAttributes().item(n6).setNodeValue("2");
                        }
                        FIX = 2;
                    }
                    n5 = ++n4;
                }
            }
            if (node.hasChildNodes()) {
                TamingMobFix.scanSourceValues(node.getChildNodes(), false);
            }
            n3 = ++n2;
        }
        if (FIX == 1 && a3) {
            Element element;
            Element element2 = element = j.createElement(ConsoleCommandExecute.ALLATORIxDEMO("n#s"));
            element2.setAttribute(Timer.ALLATORIxDEMO("\u000eu\rq"), ConsoleCommandExecute.ALLATORIxDEMO("s,j$i*J\"e"));
            element2.setAttribute(Timer.ALLATORIxDEMO("b\u0001x\u0015q"), "2");
            FIX = 2;
        }
    }
}

