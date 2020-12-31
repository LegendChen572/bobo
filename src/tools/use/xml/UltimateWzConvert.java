/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FileUtils
 */
package tools.use.xml;

import client.inventory.MapleAndroid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tools.use.GetMACAddress;

public class UltimateWzConvert {
    public static /* synthetic */ int B;
    public static /* synthetic */ String ALLATORIxDEMO;
    public static /* synthetic */ NodeList g;
    public static /* synthetic */ Collection<File> F;
    public static /* synthetic */ File I;
    public static /* synthetic */ String d;
    public static /* synthetic */ Document e;
    public static /* synthetic */ XPath E;
    public static /* synthetic */ boolean k;
    public static /* synthetic */ String a;
    public static /* synthetic */ int K;
    public static /* synthetic */ DocumentBuilder H;
    public static /* synthetic */ DocumentBuilderFactory C;

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
            Logger.getLogger(UltimateWzConvert.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
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

    public /* synthetic */ UltimateWzConvert() {
        UltimateWzConvert a2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a) {
        System.out.println(MapleAndroid.ALLATORIxDEMO("\u001dP4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4y4S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7P\u001dP7S7S7S7S4P7P7S7P7S7S4P7P4P7P4P7P4S7P4P7S7S7S7S4y4S7S7S7S4S4S4S7S4S7S4S4S7P7S4S4S4S4S7P7S7S7S7S7P\u001dP7S7S7S7P4P7P7S7P7S7P4P7S4S7P7P7P4S7S4S7S7S7S7S4y4S7S7S7S4S4S4P4S4P4S4S4S7P7S4P4S4S4S4P4S7S7S7S7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4SX\u0011q\u0006d\u0010v\u0007~\u001cySu\n72{\u001fv\u0007x\u0001~SX\u0011q\u0006d\u0010v\u0007x\u00017\u0005 ]$SS6Z<7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4S7S7S7S7S7S\u007f\u0007c\u0003-\\8\u0004`\u00049\u0012{\u001fv\u0007x\u0001~]t\u001czS7S7S7S7S7S7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P\u001d"));
        var1_1 = System.currentTimeMillis();
        var3_3 = new SimpleDateFormat(GetMACAddress.ALLATORIxDEMO("Q+#\u000etYj\u0010#0J0"));
        System.out.println(MapleAndroid.ALLATORIxDEMO("\u63f0\u63d8\u769d\u9313\u4e5e9]9"));
        if (a.length >= 1 && !a[0].isEmpty()) {
            UltimateWzConvert.a = a[0];
        }
        UltimateWzConvert.I = new File(UltimateWzConvert.a);
        UltimateWzConvert.F = FileUtils.listFiles((File)UltimateWzConvert.I, null, (boolean)true);
        UltimateWzConvert.H = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        UltimateWzConvert.E = XPathFactory.newInstance().newXPath();
        var4_4 = UltimateWzConvert.F.iterator();
lbl13:
        // 3 sources

        while (var4_4.hasNext()) {
            UltimateWzConvert.I = var5_6 = var4_4.next();
            ++UltimateWzConvert.K;
            UltimateWzConvert.e = UltimateWzConvert.H.parse(var5_6);
            UltimateWzConvert.g = (NodeList)UltimateWzConvert.E.compile("/imgdir[@name='" + var5_6.getName().substring(0, 8) + ".img']").evaluate(UltimateWzConvert.e, XPathConstants.NODESET);
            UltimateWzConvert.g = UltimateWzConvert.g.item(0).getChildNodes();
            UltimateWzConvert.k = false;
            v0 = var6_7 = 0;
lbl22:
            // 2 sources

            while (v0 < UltimateWzConvert.g.getLength()) {
                var7_9 = UltimateWzConvert.g.item(var6_7);
                var8_10 = 0;
                if (var7_9.hasAttributes()) {
                    v1 = var8_10 = 0;
                    while (v1 < var7_9.getAttributes().getLength()) {
                        if (var7_9.getAttributes().item(var8_10).getNodeValue().equals(UltimateWzConvert.d)) {
                            var7_9.getAttributes().item(var8_10).setNodeValue(UltimateWzConvert.ALLATORIxDEMO);
                            System.out.println(var7_9.getAttributes().item(var8_10).getNodeValue());
                            UltimateWzConvert.k = true;
                            ++UltimateWzConvert.B;
                        }
                        v1 = ++var8_10;
                    }
                }
                ** GOTO lbl-1000
            }
            ** GOTO lbl-1000
            {
                catch (NullPointerException | SAXException var6_8) {
                }
            }
        }
        ** GOTO lbl49
        {
            catch (IOException | ParserConfigurationException | XPathExpressionException var1_2) {
                Logger.getLogger(UltimateWzConvert.class.getName()).log(Level.SEVERE, null, var1_2);
                return;
            }
lbl-1000:
            // 1 sources

            {
                v0 = ++var6_7;
                ** GOTO lbl22
            }
lbl-1000:
            // 1 sources

            {
                if (UltimateWzConvert.k) {
                    UltimateWzConvert.saveFile();
                }
                System.out.println("\r\u6700\u5f8c\u6a94\u6848: " + var5_6.getAbsolutePath() + "\t\t\t\t");
            }
            ** GOTO lbl13
lbl49:
            // 1 sources

            var4_5 = System.currentTimeMillis();
            System.out.println("\n\u6642\u9593: " + var3_3.format(var4_5 - var1_1 - 68400000L));
            System.out.println("\u5df2\u6383\u63cf\u6a94\u6848: " + UltimateWzConvert.K);
            System.out.println("\u4fee\u6b63\u7684\u7bc0\u9ede: " + UltimateWzConvert.B);
            return;
        }
    }
}

