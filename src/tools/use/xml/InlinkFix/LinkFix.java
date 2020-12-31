/*
 * Decompiled with CFR 0.150.
 */
package tools.use.xml.InlinkFix;

import java.io.File;
import java.io.IOException;
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
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tools.Pair;
import tools.npcgenerator.NPCMessage;
import tools.use.GetMACAddress;

public class LinkFix {
    public static /* synthetic */ int FIX;
    public static /* synthetic */ String BASE_FOLDER;
    public static /* synthetic */ int j;
    public static /* synthetic */ Document A;
    public static /* synthetic */ boolean C;
    public static /* synthetic */ boolean E;
    public static /* synthetic */ String K;
    public static /* synthetic */ String a;
    public static /* synthetic */ String k;
    public static /* synthetic */ String H;
    public static /* synthetic */ DocumentBuilder m;
    public static /* synthetic */ int replacenumber;
    public static /* synthetic */ NodeList h;
    public static /* synthetic */ Map<String, List<Pair<String, String>>> F;
    public static /* synthetic */ Collection<File> c;
    public static /* synthetic */ boolean g;
    public static /* synthetic */ int D;
    public static /* synthetic */ int replacepet;
    public static /* synthetic */ XPath f;
    public static /* synthetic */ File b;
    public static /* synthetic */ Map<String, String> M;
    public static /* synthetic */ Node ALLATORIxDEMO;
    public static /* synthetic */ boolean L;
    public static /* synthetic */ boolean d;
    public static /* synthetic */ int J;
    public static /* synthetic */ Node e;
    public static /* synthetic */ int i;
    public static /* synthetic */ String B;
    public static /* synthetic */ boolean I;
    public static /* synthetic */ DocumentBuilderFactory l;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void scanSourceValues(NodeList a2, boolean a32) {
        int n2;
        Node a32 = null;
        int n3 = LinkFix.getInt(H);
        int n4 = n2 = 0;
        while (n4 < a2.getLength()) {
            a32 = a2.item(n2);
            if (a32.hasAttributes()) {
                int n5;
                int n6 = n5 = 0;
                while (n6 < a32.getAttributes().getLength()) {
                    block37: {
                        int n7;
                        String string;
                        Object object;
                        Object object2;
                        String string2;
                        block38: {
                            string2 = a32.getAttributes().item(n5).getNodeValue();
                            if (string2.equals(GetMACAddress.ALLATORIxDEMO("<p\ru\nw\b"))) {
                                NodeList nodeList;
                                int n8;
                                block36: {
                                    if (g) {
                                        a32.getAttributes().item(n5).setNodeValue(B);
                                    }
                                    try {
                                        int n9;
                                        n8 = n5 + 1;
                                        object2 = a32.getAttributes().item(n8).getNodeValue();
                                        object = ((String)object2).split("/");
                                        Object object3 = "";
                                        string = null;
                                        System.out.println((String)object2);
                                        int n10 = n9 = 0;
                                        while (n10 < ((String[])object).length) {
                                            object3 = n9 == ((String[])object).length - 1 ? (String)object3 + "/canvas[@name='" + object[n9] + "']" : (String)object3 + "/imgdir[@name='" + object[n9] + "']";
                                            n10 = ++n9;
                                        }
                                        nodeList = (NodeList)f.compile("/imgdir[@name='" + H + "']" + (String)object3).evaluate(A, XPathConstants.NODESET);
                                        if (nodeList != null) break block36;
                                        System.out.println("\u7f3a\u5c11\u8cc7\u6599:" + (String)object2);
                                        break block37;
                                    }
                                    catch (XPathExpressionException xPathExpressionException) {
                                        Logger.getLogger(LinkFix.class.getName()).log(Level.SEVERE, null, xPathExpressionException);
                                        n7 = n3;
                                        break block38;
                                    }
                                }
                                if (nodeList.item(0).getAttributes().getNamedItem(NPCMessage.ALLATORIxDEMO("\u000f\u0013\u001e\u0017\t\u0013\u0019\u0013")) != null) {
                                    string = nodeList.item(0).getAttributes().getNamedItem(GetMACAddress.ALLATORIxDEMO("{\u0002j\u0006}\u0002m\u0002")).getNodeValue();
                                    a32.getParentNode().getAttributes().getNamedItem(NPCMessage.ALLATORIxDEMO("\u000f\u0013\u001e\u0017\t\u0013\u0019\u0013")).setTextContent(string);
                                    ++replacenumber;
                                }
                                if (g) {
                                    a32.getAttributes().item(n8).setNodeValue(k);
                                }
                            } else if (string2.equals(GetMACAddress.ALLATORIxDEMO("F\fl\u0017u\nw\b")) || string2.equals(NPCMessage.ALLATORIxDEMO("\u001e\u001d\u0018\u0000\u000e\u0017"))) {
                                if (g) {
                                    a32.getAttributes().item(n5).setNodeValue(B);
                                }
                                try {
                                    Object object4;
                                    Object object5;
                                    int n11;
                                    Object object6;
                                    Object object7;
                                    String string3;
                                    Object object8;
                                    int n12;
                                    block39: {
                                        int n13;
                                        n12 = n5 + 1;
                                        object2 = a32.getAttributes().item(n12).getNodeValue();
                                        object = ((String)object2).split("/");
                                        object8 = "";
                                        string = null;
                                        string3 = "";
                                        System.out.println((String)object2);
                                        object7 = K;
                                        object6 = new File("").getAbsolutePath();
                                        n11 = 0;
                                        int n14 = n13 = 0;
                                        while (n14 < ((String[])object).length) {
                                            object5 = object[n13];
                                            if (!((String)object5).contains(GetMACAddress.ALLATORIxDEMO("7\nt\u0004"))) {
                                                object7 = (String)object7 + File.separator + (String)object5;
                                                object6 = (String)object6 + File.separator + (String)object5;
                                                n14 = ++n13;
                                                continue;
                                            }
                                            n11 = n13;
                                            object7 = (String)object7 + File.separator + (String)object5 + ".xml";
                                            object6 = (String)object6 + File.separator + (String)object5 + ".xml";
                                            object4 = object;
                                            break block39;
                                        }
                                        object4 = object;
                                    }
                                    string3 = object4[n11];
                                    Document document = null;
                                    try {
                                        document = m.parse("file:///" + (String)object7);
                                    }
                                    catch (Exception exception) {
                                        document = m.parse("file:///" + (String)object6);
                                        System.out.println("\u91cd\u5b9a\u5411\u8def\u5f91:" + (String)object6);
                                    }
                                    int n15 = ++n11;
                                    while (n15 < ((String[])object).length) {
                                        int n16;
                                        object8 = n16 == ((Object)object).length - 1 ? (String)object8 + "/canvas[@name='" + (String)object[n16] + "']" : (String)object8 + "/imgdir[@name='" + (String)object[n16] + "']";
                                        n15 = ++n16;
                                    }
                                    object5 = (NodeList)f.compile("/imgdir[@name='" + string3 + "']" + (String)object8).evaluate(document, XPathConstants.NODESET);
                                    if (object5 == null) {
                                        System.out.println("\u7f3a\u5c11\u8cc7\u6599:" + (String)object2);
                                        break block37;
                                    }
                                    try {
                                        if (object5.item(0).getAttributes().getNamedItem(NPCMessage.ALLATORIxDEMO("\u000f\u0013\u001e\u0017\t\u0013\u0019\u0013")) != null) {
                                            string = object5.item(0).getAttributes().getNamedItem(GetMACAddress.ALLATORIxDEMO("{\u0002j\u0006}\u0002m\u0002")).getNodeValue();
                                            a32.getParentNode().getAttributes().getNamedItem(NPCMessage.ALLATORIxDEMO("\u000f\u0013\u001e\u0017\t\u0013\u0019\u0013")).setTextContent(string);
                                            ++replacenumber;
                                        }
                                    }
                                    catch (Exception exception) {
                                        System.out.println("\u8def\u5f91:" + (String)object2 + "\u7f3a\u5716!");
                                    }
                                    if (g) {
                                        a32.getAttributes().item(n12).setNodeValue(k);
                                    }
                                }
                                catch (XPathExpressionException xPathExpressionException) {
                                    Logger.getLogger(LinkFix.class.getName()).log(Level.SEVERE, null, xPathExpressionException);
                                    n7 = n3;
                                    break block38;
                                }
                                catch (SAXException sAXException) {
                                    Logger.getLogger(LinkFix.class.getName()).log(Level.SEVERE, null, sAXException);
                                    n7 = n3;
                                    break block38;
                                }
                                catch (IOException iOException) {
                                    Logger.getLogger(LinkFix.class.getName()).log(Level.SEVERE, null, iOException);
                                }
                            }
                            n7 = n3;
                        }
                        if (n7 >= 5000000 && n3 < 5010000 && string2.equals(GetMACAddress.ALLATORIxDEMO("\u0005u\u001a")) && a32.getAttributes().getNamedItem(NPCMessage.ALLATORIxDEMO("\u0004\f\u001e\u0018\u0017")) != null && a32.getAttributes().getNamedItem(GetMACAddress.ALLATORIxDEMO("\u0015x\u000fl\u0006")).getNodeValue().equals(NPCMessage.ALLATORIxDEMO("\u0007\u0007\u0000\u0002"))) {
                            int n17;
                            Object object9;
                            Node node = a32;
                            Node node2 = node.getParentNode();
                            node.getParentNode().removeChild(a32);
                            object2 = null;
                            try {
                                object9 = object2 = (NodeList)f.compile("/imgdir[@name='" + n3 + ".img']/imgdir[@name='jump']").evaluate(A, XPathConstants.NODESET);
                            }
                            catch (XPathExpressionException xPathExpressionException) {
                                Logger.getLogger(LinkFix.class.getName()).log(Level.SEVERE, null, xPathExpressionException);
                                object9 = object2;
                            }
                            object = object9.item(0).cloneNode(true);
                            int n18 = n17 = 0;
                            while (n18 < object.getAttributes().getLength()) {
                                string = object.getAttributes().item(n17).getNodeValue();
                                if (string.equals(GetMACAddress.ALLATORIxDEMO("s\u0016t\u0013"))) {
                                    object.getAttributes().item(n17).setNodeValue(NPCMessage.ALLATORIxDEMO("\u0014\u0001\u000b"));
                                }
                                n18 = ++n17;
                            }
                            node2.appendChild((Node)object);
                            System.out.println(n3);
                            ++replacepet;
                        }
                    }
                    n6 = ++n5;
                }
            }
            if (a32.hasChildNodes()) {
                LinkFix.scanSourceValues(a32.getChildNodes(), false);
            }
            n4 = ++n2;
        }
        return;
    }

    public /* synthetic */ LinkFix() {
        LinkFix a2;
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
            Logger.getLogger(LinkFix.class.getName()).log(Level.SEVERE, null, transformerException);
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
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isNotRemoveMobWz(String a2) {
        int n2;
        int n3;
        String[] arrstring;
        block160: {
            if (a.equals(NPCMessage.ALLATORIxDEMO("\b\u001e\b\u001f,\u0006\u0019\u0000"))) {
                return true;
            }
            arrstring = a2;
            int n4 = -1;
            switch (arrstring.hashCode()) {
                case 95467907: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0007|\u000fx\u001a"))) break;
                    n3 = n4 = 0;
                    break block160;
                }
                case 3198432: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0005\u0017\f\u0016"))) break;
                    n3 = n4 = 1;
                    break block160;
                }
                case -1008619738: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("v\u0011p\u0004p\r"))) break;
                    n3 = n4 = 2;
                    break block160;
                }
                case 3464: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0001\u0006"))) break;
                    n3 = n4 = 3;
                    break block160;
                }
                case 3632: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("k\u0001"))) break;
                    n3 = n4 = 4;
                    break block160;
                }
                case 122: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\b"))) break;
                    n3 = n4 = 5;
                    break block160;
                }
                case -1422950858: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("x\u0000m\nv\r"))) break;
                    n3 = n4 = 6;
                    break block160;
                }
                case 1633136331: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0017\u000b\u0014\b\u0011\u00193\u000b\u0006\b\u0000"))) break;
                    n3 = n4 = 7;
                    break block160;
                }
                case 109496913: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0010r\nu\u000f"))) break;
                    n3 = n4 = 8;
                    break block160;
                }
                case 3496420: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001f\u0017\u000e\u0006"))) break;
                    n3 = n4 = 9;
                    break block160;
                }
                case 96385: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0002z\u0000"))) break;
                    n3 = n4 = 10;
                    break block160;
                }
                case -669724022: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000f\u001d\t\u000b,\u0006\u0019\u0013\u000e\u0019"))) break;
                    n3 = n4 = 11;
                    break block160;
                }
                case 3035219: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("{\u0016\u007f\u0005"))) break;
                    n3 = n4 = 12;
                    break block160;
                }
                case 3029869: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000f\u001d\u001e\u0001"))) break;
                    n3 = n4 = 13;
                    break block160;
                }
                case 50511102: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("z\u0002m\u0006~\fk\u001a"))) break;
                    n3 = n4 = 14;
                    break block160;
                }
                case 1544803905: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0016\b\u0014\f\u0007\u0001\u0006"))) break;
                    n3 = n4 = 15;
                    break block160;
                }
                case -1502129399: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0007|\u0005x\u0016u\u0017Q3"))) break;
                    n3 = n4 = 16;
                    break block160;
                }
                case -1502129244: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0016\b\u0014\f\u0007\u0001\u0006 \""))) break;
                    n3 = n4 = 17;
                    break block160;
                }
                case -9405920: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("|\u000f|\u000eX\u0017m\u0011"))) break;
                    n3 = n4 = 18;
                    break block160;
                }
                case 100816: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0017\u001b\u0013"))) break;
                    n3 = n4 = 19;
                    break block160;
                }
                case 100893: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0006a\u0013"))) break;
                    n3 = n4 = 20;
                    break block160;
                }
                case 1515794292: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0017\u0015\u0002\u0001\u001d\u001e\u001b\u001b\u0017?\u0017\u001a\u0013\u001f\u0016"))) break;
                    n3 = n4 = 21;
                    break block160;
                }
                case -1548359400: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0005p\u0011j\u0017X\u0017m\u0002z\b"))) break;
                    n3 = n4 = 22;
                    break block160;
                }
                case 3277: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000b\u0001"))) break;
                    n3 = n4 = 23;
                    break block160;
                }
                case 500047315: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("+I\u0004x\u0016~\u0006Q\n}\u0006"))) break;
                    n3 = n4 = 24;
                    break block160;
                }
                case -268474179: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0005\u0002?\u0017\u000e\u001d\u001b\u0017\u001f\u000b"))) break;
                    n3 = n4 = 25;
                    break block160;
                }
                case -1251041704: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("t\u0013K\u0006z\fo\u0006k\u001a"))) break;
                    n3 = n4 = 26;
                    break block160;
                }
                case -1041057330: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0003\u001d+\u001e\u0004\u0002"))) break;
                    n3 = n4 = 27;
                    break block160;
                }
                case 2127385372: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\rv\u0011|\u0004|\r"))) break;
                    n3 = n4 = 28;
                    break block160;
                }
                case -1096860564: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0005\u00029\u0013\n0\n\u0011\u0002\u001e\u0002\u0000"))) break;
                    n3 = n4 = 29;
                    break block160;
                }
                case -259188463: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("q\u0013M\u0002~ v\u000fv\u0011"))) break;
                    n3 = n4 = 30;
                    break block160;
                }
                case 102865796: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001e\b\u0004\b\u001e"))) break;
                    n3 = n4 = 31;
                    break block160;
                }
                case 650314275: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("T\"]\u0002t\u0002~\u0006"))) break;
                    n3 = n4 = 32;
                    break block160;
                }
                case 103671148: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001f\f\n%\""))) break;
                    n3 = n4 = 33;
                    break block160;
                }
                case 103671303: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u000ex\u001bT3"))) break;
                    n3 = n4 = 34;
                    break block160;
                }
                case 865233009: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001f\u000f\u001d\u0002\u0019$6"))) break;
                    n3 = n4 = 35;
                    break block160;
                }
                case -982141978: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("T']\u0002t\u0002~\u0006"))) break;
                    n3 = n4 = 36;
                    break block160;
                }
                case 1583777984: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("=3)\u0013\u0000\u0013\n\u0017"))) break;
                    n3 = n4 = 37;
                    break block160;
                }
                case -48678269: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("I']\u0002t\u0002~\u0006"))) break;
                    n3 = n4 = 38;
                    break block160;
                }
                case 491961080: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001d\u0007\u000f\u001e\u0004\u0011?\u0017\u001a\u0013\u001f\u0016"))) break;
                    n3 = n4 = 39;
                    break block160;
                }
                case -976921287: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("i\u0016j\u000b|\u0007"))) break;
                    n3 = n4 = 40;
                    break block160;
                }
                case -1041113846: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0003\u001d)\u001d\u0002\u001f"))) break;
                    n3 = n4 = 41;
                    break block160;
                }
                case 1224616538: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u000ev\u0001M\u001ai\u0006"))) break;
                    n3 = n4 = 42;
                    break block160;
                }
                case -934348459: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001f\u0017\u001b\u001b\u001b\u0017"))) break;
                    n3 = n4 = 43;
                    break block160;
                }
                case 490724992: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0011x\u0011|*m\u0006t'k\fi/|\u0015|\u000f"))) break;
                    n3 = n4 = 44;
                    break block160;
                }
                case 109641799: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0001\u001d\u0017\b\u0016"))) break;
                    n3 = n4 = 45;
                    break block160;
                }
                case 80473019: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("j\u0016t\u000ev\rM\u001ai\u0006"))) break;
                    n3 = n4 = 46;
                    break block160;
                }
                case -840690051: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0018\u001c\t\u0017\f\u0016"))) break;
                    n3 = n4 = 47;
                    break block160;
                }
                case -702052344: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("c\n~\u0019x\u0004"))) break;
                    n3 = n4 = 48;
                    break block160;
                }
                case 3055: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\fB"))) break;
                    n3 = n4 = 49;
                    break block160;
                }
                case 3056: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("xR"))) break;
                    n3 = n4 = 50;
                    break block160;
                }
                case 3057: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\f@"))) break;
                    n3 = n4 = 51;
                    break block160;
                }
                case 3058: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("xP"))) break;
                    n3 = n4 = 52;
                    break block160;
                }
                case 3059: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\fF"))) break;
                    n3 = n4 = 53;
                    break block160;
                }
                case 3060: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("xV"))) break;
                    n3 = n4 = 54;
                    break block160;
                }
                case 3061: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\fD"))) break;
                    n3 = n4 = 55;
                    break block160;
                }
                case 3062: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("xT"))) break;
                    n3 = n4 = 56;
                    break block160;
                }
                case 3063: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\fJ"))) break;
                    n3 = n4 = 57;
                    break block160;
                }
                case 3064: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("xZ"))) break;
                    n3 = n4 = 58;
                    break block160;
                }
                case 98690: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0011\u0002\u001c"))) break;
                    n3 = n4 = 59;
                    break block160;
                }
                case 107944162: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0012l\u0006j\u0017"))) break;
                    n3 = n4 = 60;
                    break block160;
                }
                case 655126909: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0003\u0018\u0017\u001e\u0006$6"))) break;
                    n3 = n4 = 61;
                    break block160;
                }
                case 109757585: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0010m\u0002m\u0006"))) break;
                    n3 = n4 = 62;
                    break block160;
                }
                case 110879: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0002\b\u0006"))) break;
                    n3 = n4 = 63;
                    break block160;
                }
                case 1631815095: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0000q\u0002m!x\u000fu\fv\r"))) break;
                    n3 = n4 = 64;
                    break block160;
                }
                case 3336: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0005\u0002"))) break;
                    n3 = n4 = 65;
                    break block160;
                }
                case 3449685: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("i\u0011v\u0001"))) break;
                    n3 = n4 = 66;
                    break block160;
                }
                case -1074038666: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0000\u001b\u0003\u001b\u0002\u001c"))) break;
                    n3 = n4 = 67;
                    break block160;
                }
                case 3575610: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("m\u001ai\u0006"))) break;
                    n3 = n4 = 68;
                    break block160;
                }
                case -677145915: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0014\u0002\u0000\u001a\u0013\u001f\u0016"))) break;
                    n3 = n4 = 69;
                    break block160;
                }
                case -782868633: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0013x\u0011m\u001a[\fw\u0016j.v\u0001"))) break;
                    n3 = n4 = 70;
                    break block160;
                }
                case -1939296012: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("=6?\u0013\u0019\u0017"))) break;
                    n3 = n4 = 71;
                    break block160;
                }
                case -2025183465: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("T'K\u0002m\u0006"))) break;
                    n3 = n4 = 72;
                    break block160;
                }
                case 108280125: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0000\f\u001c\n\u0017"))) break;
                    n3 = n4 = 73;
                    break block160;
                }
                case 111188: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0013v\u0010"))) break;
                    n3 = n4 = 74;
                    break block160;
                }
                case 94843557: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0011\u0002\u001c \""))) break;
                    n3 = n4 = 75;
                    break block160;
                }
                case -1407259067: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("x\u0017m\u0002z\u000b"))) break;
                    n3 = n4 = 76;
                    break block160;
                }
                case 3677: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001e\u0002"))) break;
                    n3 = n4 = 77;
                    break block160;
                }
                case 114: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0011"))) break;
                    n3 = n4 = 78;
                    break block160;
                }
                case -1306084975: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\b\u0014\u000b\u0017\u000e\u0006"))) break;
                    n3 = n4 = 79;
                    break block160;
                }
                case 103655853: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u000ex\u0004p\u0000"))) break;
                    n3 = n4 = 80;
                    break block160;
                }
                case 76: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO(">"))) break;
                    n3 = n4 = 81;
                    break block160;
                }
                case -1366786971: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0001l\u000fu\u0006m0i\u0006|\u0007"))) break;
                    n3 = n4 = 82;
                    break block160;
                }
                case -1638517153: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\f\u0006\u0019\u0013\u000e\u001a\u000b\u0013\u000e\u001b\u0003\u0015"))) break;
                    n3 = n4 = 83;
                    break block160;
                }
                case 976288699: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\bw\fz\b{\u0002z\b"))) break;
                    n3 = n4 = 84;
                    break block160;
                }
                case 70: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("4"))) break;
                    n3 = n4 = 85;
                    break block160;
                }
                case 97295: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0001x\r"))) break;
                    n3 = n4 = 86;
                    break block160;
                }
                case -1396374286: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000f\u0013\u0003?\u001e\u0015"))) break;
                    n3 = n4 = 87;
                    break block160;
                }
                case -1396374835: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("{\u0002w.x\u0013"))) break;
                    n3 = n4 = 88;
                    break block160;
                }
                case 97427706: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0014\u0004\u0017\u0001\u0016"))) break;
                    n3 = n4 = 89;
                    break block160;
                }
                case -982480788: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("i\fk\u0017x\u000f"))) break;
                    n3 = n4 = 90;
                    break block160;
                }
                case 3235303: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0004\u001c]@"))) break;
                    n3 = n4 = 91;
                    break block160;
                }
                case 109757538: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0010m\u0002k\u0017"))) break;
                    n3 = n4 = 92;
                    break block160;
                }
                case -126623614: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0013\u001f\u0017\f1\u0002\u0007\u0003\u0006"))) break;
                    n3 = n4 = 93;
                    break block160;
                }
                case -1259590065: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0002k\u0006x4x\u0011w\nw\u0004"))) break;
                    n3 = n4 = 94;
                    break block160;
                }
                case -2088557927: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\t\u0017\f\u0016\u0001\u000b,\u0006\u0019\u0013\u000e\u0019"))) break;
                    n3 = n4 = 95;
                    break block160;
                }
                case 1671426428: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0007p\u0010|\u0002j\u0006"))) break;
                    n3 = n4 = 96;
                    break block160;
                }
                case 3321850: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0001\u001b\u0003\u0019"))) break;
                    n3 = n4 = 97;
                    break block160;
                }
                case 80089127: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("0i\u0006|\u0007"))) break;
                    n3 = n4 = 98;
                    break block160;
                }
                case 3016191: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000f\u0013\u0001\u001e"))) break;
                    n3 = n4 = 99;
                    break block160;
                }
                case -523647002: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("z\u000bx\u0017x!x\u000fu\fv\r"))) break;
                    n3 = n4 = 100;
                    break block160;
                }
                case 1801778405: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0016\u00024\u0004\u0000\u001e\u0006"))) break;
                    n3 = n4 = 101;
                    break block160;
                }
                case 90929645: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("<q\u0002j\u000b"))) break;
                    n3 = n4 = 102;
                    break block160;
                }
                case 544605638: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0001\b\u001e\u000b6\b\u0001\u0019\u0000\u0018\u0011\u0019\u001b\u0002\u001c"))) break;
                    n3 = n4 = 103;
                    break block160;
                }
                case -896505829: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("j\fl\u0011z\u0006"))) break;
                    n3 = n4 = 104;
                    break block160;
                }
                case 95457677: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0016\b\u0013\u0001\u000b"))) break;
                    n3 = n4 = 105;
                    break block160;
                }
                case 110544405: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0017v\u0013)S"))) break;
                    n3 = n4 = 106;
                    break block160;
                }
                case 3538977: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001e\u0006]B"))) break;
                    n3 = n4 = 107;
                    break block160;
                }
                case 1520471804: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("k\fm\u0002m\u0006I\u0006k\nv\u0007"))) break;
                    n3 = n4 = 108;
                    break block160;
                }
                case 1556909824: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0016\b\u0001\b\u0013\u001e\u0017"))) break;
                    n3 = n4 = 109;
                    break block160;
                }
                case 120: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u001b"))) break;
                    n3 = n4 = 110;
                    break block160;
                }
                case 121: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000b"))) break;
                    n3 = n4 = 111;
                    break block160;
                }
                case 3135355: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u007f\u0002u\u000f"))) break;
                    n3 = n4 = 112;
                    break block160;
                }
                case 570418373: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0004\u001c\u0019\u0017\u001f\u0004\f\u001e"))) break;
                    n3 = n4 = 113;
                    break block160;
                }
                case 94851343: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0000v\u0016w\u0017"))) break;
                    n3 = n4 = 114;
                    break block160;
                }
                case -1992012396: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\t\u0007\u001f\u0013\u0019\u001b\u0002\u001c"))) break;
                    n3 = n4 = 115;
                    break block160;
                }
                case 1715833963: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("|\u0005\u007f\u0006z\u0017M\u001ai\u0006"))) break;
                    n3 = n4 = 116;
                    break block160;
                }
                case -1940083738: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0004\u0015\u0003\u001d\u001f\u0017+\u001b\b\u001e\t=\u0018\u0006"))) break;
                    n3 = n4 = 117;
                    break block160;
                }
                case 440984299: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("{\u0016u\u000f|\u0017W\u0016t\u0001|\u0011"))) break;
                    n3 = n4 = 118;
                    break block160;
                }
                case 1672472646: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0000\f\u001c\t6\b\u001e\f\u000b,\u0006\u0019\u0013\u000e\u0019"))) break;
                    n3 = n4 = 119;
                    break block160;
                }
                case -1833928513: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0006\u007f\u0005|\u0000mS"))) break;
                    n3 = n4 = 120;
                    break block160;
                }
                case -1339258714: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\b\u0014\u000b\u0017\u000e\u0006)\u001b\u001e\u0006\f\u001c\u000e\u0017"))) break;
                    n3 = n4 = 121;
                    break block160;
                }
                case -827557231: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0011x\r}\ft3v\u0010"))) break;
                    n3 = n4 = 122;
                    break block160;
                }
                case -1063411723: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0006\u001f\u0017\u0000\u0010\u0001\u0017"))) break;
                    n3 = n4 = 123;
                    break block160;
                }
                case 1671308008: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0007p\u0010x\u0001u\u0006"))) break;
                    n3 = n4 = 124;
                    break block160;
                }
                case 70793394: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO(";\u0003\u0016\b\n"))) break;
                    n3 = n4 = 125;
                    break block160;
                }
                case -1774101779: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("q\n}\u0006W\u0002t\u0006"))) break;
                    n3 = n4 = 126;
                    break block160;
                }
                case 1025079327: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0004\u001c\u001b\u001b\u0003\u0011\u0004\u0010\u0001\u0017"))) break;
                    n3 = n4 = 127;
                    break block160;
                }
                case -164832940: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("}\u0002t\u0002~\u0006}!`.v\u0001"))) break;
                    n3 = n4 = 128;
                    break block160;
                }
                case -752193789: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\t\u0000\u0002\u0002$\u0006\b\u001f=\u0017\u001f\u001b\u0002\u0016"))) break;
                    n3 = n4 = 129;
                    break block160;
                }
                case 98245187: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0004|\u0017Z3"))) break;
                    n3 = n4 = 130;
                    break block160;
                }
                case -1401810759: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\t\u0013\u0000\u0013\n\u0017\t0\u0014!\b\u001e\b\u0011\u0019\u0017\t?\u0002\u0010"))) break;
                    n3 = n4 = 131;
                    break block160;
                }
                case 3830: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("cS"))) break;
                    n3 = n4 = 132;
                    break block160;
                }
                case 3831: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0017C"))) break;
                    n3 = n4 = 133;
                    break block160;
                }
                case -1217487414: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("q\n}\u0006Q3"))) break;
                    n3 = n4 = 134;
                    break block160;
                }
                case 106845584: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0002\u0002\u001b\u0003\u0006"))) break;
                    n3 = n4 = 135;
                    break block160;
                }
                case -149153907: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("z\fv\u000f]\u0002t\u0002~\u0006I\u0011v\u0001"))) break;
                    n3 = n4 = 136;
                    break block160;
                }
                case -1754674152: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u000e\u001d\u0002\u001e)\u0013\u0000\u0013\n\u0017"))) break;
                    n3 = n4 = 137;
                    break block160;
                }
                case 3351804: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("t\nj\u0010"))) break;
                    n3 = n4 = 138;
                    break block160;
                }
                case 3449699: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001d\u0000\u0002\u0002"))) break;
                    n3 = n4 = 139;
                    break block160;
                }
                case 1679712219: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("v\ru\u001aW\fk\u000ex\u000fX\u0017m\u0002z\b"))) break;
                    n3 = n4 = 140;
                    break block160;
                }
                case 615249923: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0014\u0004\n\b\u0016)\u0013\u0000\u0013\n\u0017"))) break;
                    n3 = n4 = 141;
                    break block160;
                }
                case 3355: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("p\u0007"))) break;
                    n3 = n4 = 142;
                    break block160;
                }
                case 1236836586: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\b\u0014\u000b\u0017\u000e\u0006\u0004\u0004\b!\u0006\u001b\u0001\u001e"))) break;
                    n3 = n4 = 143;
                    break block160;
                }
                case -337715223: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\u0001x\rM\u001ai\u0006"))) break;
                    n3 = n4 = 144;
                    break block160;
                }
                case 106855744: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0002\u0002\u0006\f\u001e"))) break;
                    n3 = n4 = 145;
                    break block160;
                }
                case 106109390: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("\fl\u0017)S"))) break;
                    n3 = n4 = 146;
                    break block160;
                }
                case 3540994: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u001e\u0006\u0002\u0002"))) break;
                    n3 = n4 = 147;
                    break block160;
                }
                case -1067919886: {
                    if (!arrstring.equals(GetMACAddress.ALLATORIxDEMO("t\u0013{\u0016k\r"))) break;
                    n3 = n4 = 148;
                    break block160;
                }
                case 3296579: {
                    if (!arrstring.equals(NPCMessage.ALLATORIxDEMO("\u0006\u001c\b\u0017"))) break;
                    n4 = 149;
                }
            }
            n3 = n4;
        }
        switch (n3) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 42: 
            case 43: 
            case 44: 
            case 45: 
            case 46: 
            case 47: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 65: 
            case 66: 
            case 67: 
            case 68: 
            case 69: 
            case 70: 
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: 
            case 76: 
            case 77: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 83: 
            case 84: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 109: 
            case 110: 
            case 111: 
            case 112: 
            case 113: 
            case 114: 
            case 115: 
            case 116: 
            case 117: 
            case 118: 
            case 119: 
            case 120: 
            case 121: 
            case 122: 
            case 123: 
            case 124: 
            case 125: 
            case 126: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 131: 
            case 132: 
            case 133: 
            case 134: 
            case 135: 
            case 136: 
            case 137: 
            case 138: 
            case 139: 
            case 140: 
            case 141: 
            case 142: 
            case 143: 
            case 144: 
            case 145: 
            case 146: 
            case 147: 
            case 148: 
            case 149: {
                return true;
            }
        }
        String[] arrstring2 = new String[21];
        arrstring2[0] = GetMACAddress.ALLATORIxDEMO("\u0007p\u0006");
        arrstring2[1] = NPCMessage.ALLATORIxDEMO("\u001a\u0004\u0006");
        arrstring2[2] = GetMACAddress.ALLATORIxDEMO("p\r\u007f\f");
        arrstring2[3] = NPCMessage.ALLATORIxDEMO("\u0000\u001d\u001b\u0017");
        arrstring2[4] = GetMACAddress.ALLATORIxDEMO("\u0010m\u0002w\u0007");
        arrstring2[5] = NPCMessage.ALLATORIxDEMO("\u0001\u0006\u001b\u0001\u001e");
        arrstring2[6] = GetMACAddress.ALLATORIxDEMO("\u0011|\u0004|\r");
        arrstring2[7] = NPCMessage.ALLATORIxDEMO("\u0014\u0001\u000b");
        arrstring2[8] = GetMACAddress.ALLATORIxDEMO("x\u0017m\u0002z\b");
        arrstring2[9] = NPCMessage.ALLATORIxDEMO("\u0007\u0007\u0000\u0002");
        arrstring2[10] = GetMACAddress.ALLATORIxDEMO("\u0000q\u0002j\u0006");
        arrstring2[11] = NPCMessage.ALLATORIxDEMO("\u0001\u001d\u0017\f\u0019");
        arrstring2[12] = GetMACAddress.ALLATORIxDEMO("\nwS");
        arrstring2[13] = NPCMessage.ALLATORIxDEMO("\u2054");
        arrstring2[14] = GetMACAddress.ALLATORIxDEMO("\u3061");
        arrstring2[15] = NPCMessage.ALLATORIxDEMO("\uff73");
        arrstring2[16] = "!";
        arrstring2[17] = GetMACAddress.ALLATORIxDEMO("\u001d");
        arrstring2[18] = "/";
        arrstring2[19] = NPCMessage.ALLATORIxDEMO("\uff6d");
        arrstring2[20] = GetMACAddress.ALLATORIxDEMO("7M");
        arrstring = arrstring2;
        String[] arrstring3 = arrstring2;
        int n5 = arrstring3.length;
        int n6 = n2 = 0;
        while (n6 < n5) {
            String string = arrstring3[n2];
            if (a2.contains(string)) {
                return true;
            }
            n6 = ++n2;
        }
        if (((String)a2).matches(NPCMessage.ALLATORIxDEMO("@M6B@K0YCX6B@K0X"))) {
            return true;
        }
        if (a2.length() > 20) {
            return true;
        }
        System.out.println("\u5176\u9918\u7bc0\u9ede\u540d\u7a31:" + (String)a2);
        return false;
    }

    public static /* synthetic */ int getInt(String a2) {
        int n2 = 0;
        try {
            String string = GetMACAddress.ALLATORIxDEMO("B=)N >");
            n2 = Integer.parseInt(Pattern.compile(string).matcher(a2).replaceAll("").trim());
            return n2;
        }
        catch (Exception exception) {
            return n2;
        }
    }

    public static /* synthetic */ {
        l = null;
        m = null;
        A = null;
        f = null;
        h = null;
        BASE_FOLDER = "Mob";
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
}

