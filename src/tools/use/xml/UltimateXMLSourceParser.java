/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FileUtils
 */
package tools.use.xml;

import client.PlayerRandomStream;
import handling.channel.handler.PetHandler;
import java.io.File;
import java.lang.invoke.CallSite;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * Exception performing whole class analysis ignored.
 */
public class UltimateXMLSourceParser {
    public static /* synthetic */ ArrayList<String> g;
    public static /* synthetic */ File a;
    public static /* synthetic */ Collection<File> K;
    public static /* synthetic */ Document e;
    public static /* synthetic */ DocumentBuilderFactory C;
    public static /* synthetic */ int d;
    public static /* synthetic */ XPath E;
    public static /* synthetic */ ArrayList<String> B;
    public static /* synthetic */ DocumentBuilder H;
    public static /* synthetic */ String[] ALLATORIxDEMO;
    public static /* synthetic */ ArrayList<String> k;
    public static /* synthetic */ String F;

    public static /* synthetic */ void main(String[] a2) {
        Iterator<File> iterator;
        System.out.println(PlayerRandomStream.ALLATORIxDEMO("EplplplplplplplplplplplplplplplplplplplplplplplplYlsososososososososososososososososososososososopEpososososlpoposopososlpoplpoplpoplsoplpososososlYlsosososlslslsoslsoslslsoposlslslslsopososososopEposososoplpoposoposoplposlsopopoplsoslsososososlYlsosososlslslplslplslslsoposlplslslslplsosososopEposososososososososososososososososososososososlYls\u00001)&<0.'&<!s-*o\u0012#?.' !&s\u00001)&<0.' !o%x}|s\u000b\u0016\u0002\u001copEposososososososososososososososososososososososlYlsososososos'';#u|`$8$a2#?.' !&},<\"sosososososopEposososososososososososososososososososososososlYlplplplplplplplplplplplplplplplplplplplplplplplpE"));
        int n2 = 0;
        long l2 = System.currentTimeMillis();
        long l3 = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PetHandler.ALLATORIxDEMO("&ITl\u0003;\u001drTR=R"));
        System.out.println(PlayerRandomStream.ALLATORIxDEMO("\u001c0.=!:!4o7&!*0;<=*a}a"));
        if (a2.length >= 1 && !a2[0].isEmpty()) {
            F = a2[0];
        }
        UltimateXMLSourceParser.directoryScan();
        Iterator<File> iterator2 = iterator = K.iterator();
        while (iterator2.hasNext()) {
            File file = iterator.next();
            ALLATORIxDEMO = file.getAbsolutePath().split(Pattern.quote(System.getProperty(PetHandler.ALLATORIxDEMO("\bh\u0002d@r\u000bq\u000fs\u000fu\u0001s"))));
            l3 = System.currentTimeMillis();
            System.out.print("\rFile: " + ALLATORIxDEMO[3] + "\t" + ALLATORIxDEMO[ALLATORIxDEMO.length - 1] + "\tFiles: " + ++n2 + "\tValues: " + d + "\tTime: " + simpleDateFormat.format(l3 - l2 - 68400000L) + " ");
            iterator2 = iterator;
            UltimateXMLSourceParser.initializeFile(file);
        }
        Object[] arrobject = new Object[1];
        arrobject[0] = "\rFile: " + ALLATORIxDEMO[3] + "\t" + ALLATORIxDEMO[ALLATORIxDEMO.length - 1] + "\tFiles: " + n2 + "\tValues: " + d + ".";
        System.out.println(String.format(PlayerRandomStream.ALLATORIxDEMO("v\u007fwwc<"), arrobject));
        System.out.println(PetHandler.ALLATORIxDEMO("d\u5b8d\u627e/"));
    }

    public static /* synthetic */ {
        F = System.getProperty(PlayerRandomStream.ALLATORIxDEMO("!6;}<5a<+:!><}8)?2;;\u00100<"), PetHandler.ALLATORIxDEMO("v\u0014^\rr"));
        C = null;
        H = null;
        e = null;
        E = null;
        g = null;
        B = null;
        k = null;
        d = 0;
    }

    public static /* synthetic */ void initializeFile(File a2) {
        try {
            g = new ArrayList();
            B = new ArrayList();
            k = new ArrayList();
            a = new File(a2.getAbsolutePath());
            H = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            e = H.parse(a2);
            E = XPathFactory.newInstance().newXPath();
            if (e.hasChildNodes()) {
                UltimateXMLSourceParser.scanSourceValues(e.getChildNodes());
                if (B.size() > 0) {
                    UltimateXMLSourceParser.replaceSourceValues(a);
                    return;
                }
            }
        }
        catch (Exception exception) {
            System.out.println("\r\nError 1: " + a2.getAbsolutePath() + "\r\n");
        }
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

    public static /* synthetic */ void scanSourceValues(NodeList a2) {
        int n2;
        Object object = "";
        int n3 = n2 = 0;
        while (n3 < a2.getLength()) {
            boolean bl = false;
            Node node = a2.item(n2);
            if (node.getNodeType() == 1) {
                if (node.getNodeName().equals(PlayerRandomStream.ALLATORIxDEMO(" ;!&=(")) && node.hasAttributes()) {
                    Node node2;
                    int n4;
                    NamedNodeMap namedNodeMap = node.getAttributes();
                    int n5 = n4 = 0;
                    while (n5 < namedNodeMap.getLength()) {
                        node2 = namedNodeMap.item(n4);
                        if (node2.getNodeValue().equals(PetHandler.ALLATORIxDEMO("\u001dn\u001bs\rd")) || node2.getNodeValue().equals(PlayerRandomStream.ALLATORIxDEMO("\u0010:!?&=$")) || node2.getNodeValue().equals(PetHandler.ALLATORIxDEMO("1n\u001bu\u0002h\u0000j"))) {
                            bl = true;
                        }
                        n5 = ++n4;
                    }
                    if (bl) {
                        int n6 = n4 = 0;
                        while (n6 < namedNodeMap.getLength()) {
                            node2 = namedNodeMap.item(n4);
                            if (n4 == 1) {
                                B.add(node2.getNodeValue());
                            } else {
                                k.add(node2.getNodeValue());
                            }
                            n6 = ++n4;
                        }
                        Node node3 = node;
                        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
                        object = "";
                        try {
                            while (node3.getParentNode() != null) {
                                arrayList.add((CallSite)((Object)(node3.getParentNode().getAttributes().getNamedItem(PlayerRandomStream.ALLATORIxDEMO("=.>*")).getNodeValue() + "/")));
                                node3 = node3.getParentNode();
                            }
                        }
                        catch (NullPointerException nullPointerException) {
                            // empty catch block
                        }
                        int n7 = n4 = arrayList.size() - 1;
                        while (n7 > -1) {
                            Object e2 = arrayList.get(n4);
                            object = (String)object + (String)e2;
                            n7 = --n4;
                        }
                        object = ((String)object).substring(0, ((String)object).length() - 1);
                        g.add((String)object);
                    }
                }
                if (node.hasChildNodes()) {
                    UltimateXMLSourceParser.scanSourceValues(node.getChildNodes());
                }
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ void directoryScan() {
        a = new File(F);
        K = FileUtils.listFiles((File)a, null, (boolean)true);
    }

    public /* synthetic */ UltimateXMLSourceParser() {
        UltimateXMLSourceParser a2;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void replaceSourceValues(File a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[WHILELOOP]], but top level block is 4[TRYBLOCK]
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
}

