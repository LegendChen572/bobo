/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FileUtils
 */
package tools.use.xml;

import FuckingHackerToby.ka;
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
import tools.data.LittleEndianAccessor;

public class UltimateWzClear {
    public static /* synthetic */ int d;
    public static /* synthetic */ DocumentBuilder e;
    public static /* synthetic */ int K;
    public static /* synthetic */ Collection<File> C;
    public static /* synthetic */ File F;
    public static /* synthetic */ NodeList B;
    public static /* synthetic */ boolean a;
    public static /* synthetic */ String[] ALLATORIxDEMO;
    public static /* synthetic */ XPath g;
    public static /* synthetic */ Document E;
    public static /* synthetic */ DocumentBuilderFactory H;
    public static /* synthetic */ String k;

    public static /* synthetic */ {
        H = null;
        e = null;
        E = null;
        g = null;
        B = null;
        k = "TamingMob";
        K = 0;
        a = false;
        d = 0;
        String[] arrstring = new String[112];
        arrstring[0] = ka.H("\u000ff\nz\u0012");
        arrstring[1] = LittleEndianAccessor.ALLATORIxDEMO("[gA{Y");
        arrstring[2] = ka.H("v\u0007f\u000e");
        arrstring[3] = LittleEndianAccessor.ALLATORIxDEMO("}N{C");
        arrstring[4] = ka.H("\u000fv\t{4t\u0011");
        arrstring[5] = LittleEndianAccessor.ALLATORIxDEMO("fHeg{O");
        arrstring[6] = ka.H("g\u0003d*p\u0010p\n");
        arrstring[7] = LittleEndianAccessor.ALLATORIxDEMO("fHe~@\u007f");
        arrstring[8] = ka.H("g\u0003d\"P>");
        arrstring[9] = LittleEndianAccessor.ALLATORIxDEMO("fHedZy");
        arrstring[10] = ka.H("g\u0003d*@-");
        arrstring[11] = LittleEndianAccessor.ALLATORIxDEMO("}Cw~@\u007f");
        arrstring[12] = ka.H("\u0012|\u000bp*|\u000b|\u0012p\u0002");
        arrstring[13] = LittleEndianAccessor.ALLATORIxDEMO("YaN");
        arrstring[14] = ka.H("|\bv\"P>");
        arrstring[15] = LittleEndianAccessor.ALLATORIxDEMO("}CwdZy");
        arrstring[16] = ka.H("|\bv*@-");
        arrstring[17] = LittleEndianAccessor.ALLATORIxDEMO("}Cw}Ui");
        arrstring[18] = ka.H("|\bv6Q\"");
        arrstring[19] = LittleEndianAccessor.ALLATORIxDEMO("}Cw`Ui");
        arrstring[20] = ka.H("|\bv+Q\"");
        arrstring[21] = LittleEndianAccessor.ALLATORIxDEMO("}CwhBl");
        arrstring[22] = ka.H("|\bv'V%");
        arrstring[23] = LittleEndianAccessor.ALLATORIxDEMO("`_uIqoxBwF");
        arrstring[24] = ka.H("\u0016g\u000fv\u0003");
        arrstring[25] = LittleEndianAccessor.ALLATORIxDEMO("^xB``uU");
        arrstring[26] = ka.H("\bz\u0012F\u0007y\u0003");
        arrstring[27] = LittleEndianAccessor.ALLATORIxDEMO("}Cw~dHqI");
        arrstring[28] = ka.H("\u000f{\u0005_\u0013x\u0016");
        arrstring[29] = LittleEndianAccessor.ALLATORIxDEMO("{CxT");
        arrstring[30] = ka.H("|\bv+]6");
        arrstring[31] = LittleEndianAccessor.ALLATORIxDEMO("}Cw`Y}");
        arrstring[32] = ka.H("|\bv%g\u0007s\u0012");
        arrstring[33] = LittleEndianAccessor.ALLATORIxDEMO("Aq[qA");
        arrstring[34] = ka.H("a\u0014t\u0002p'c\u0007|\nt\u0004y\u0003");
        arrstring[35] = LittleEndianAccessor.ALLATORIxDEMO("LwN{XzYGEu_uOxH");
        arrstring[36] = ka.H("\u0003d\u0013|\u0016A\u0014t\u0002p$y\tv\r");
        arrstring[37] = LittleEndianAccessor.ALLATORIxDEMO("qKrHwY");
        arrstring[38] = ka.H("\u0012g\u0007q$y\tv\r");
        arrstring[39] = LittleEndianAccessor.ALLATORIxDEMO("`uU\\}");
        arrstring[40] = ka.H("\u000f{\u0005X.E\u0014");
        arrstring[41] = LittleEndianAccessor.ALLATORIxDEMO("pXfLvDxD`T");
        arrstring[42] = ka.H("\t{\nl#d\u0013|\u0016");
        arrstring[43] = LittleEndianAccessor.ALLATORIxDEMO("vBzXghl]");
        arrstring[44] = ka.H("\u000f{\u0005X+E\u0014");
        arrstring[45] = LittleEndianAccessor.ALLATORIxDEMO("yHpLxyuJ");
        arrstring[46] = ka.H("\bz\u0012P\u001ea\u0003{\u0002");
        arrstring[47] = LittleEndianAccessor.ALLATORIxDEMO("_q]xLwH");
        arrstring[48] = ka.H("\u0015e\u0003v\u000ft\n\\\"");
        arrstring[49] = LittleEndianAccessor.ALLATORIxDEMO("^dHqI");
        arrstring[50] = ka.H("p\u001ee\u000fg\u0003Z\bY\tr\t`\u0012");
        arrstring[51] = LittleEndianAccessor.ALLATORIxDEMO("IfBdoxBwF");
        arrstring[52] = ka.H("E\ta\u000fz\bQ\u000ff\u0005z\u0013{\u0012");
        arrstring[53] = LittleEndianAccessor.ALLATORIxDEMO("zBQUdHzI");
        arrstring[54] = ka.H("\u0015p\u0012\\\u0012p\u000b\\\"");
        arrstring[55] = LittleEndianAccessor.ALLATORIxDEMO("fHe}[}");
        arrstring[56] = ka.H("\u0017`\u0003f\u0012");
        arrstring[57] = LittleEndianAccessor.ALLATORIxDEMO("dLwE}C\u007fB");
        arrstring[58] = ka.H("\u0007v\u0005");
        arrstring[59] = LittleEndianAccessor.ALLATORIxDEMO("cHqFxT");
        arrstring[60] = ka.H("\rp\u001fb\tg\u0002P\u0000s\u0003v\u0012");
        arrstring[61] = LittleEndianAccessor.ALLATORIxDEMO("DzN\\}");
        arrstring[62] = ka.H("p\u0016|\u0005\\\u0012p\u000b");
        arrstring[63] = LittleEndianAccessor.ALLATORIxDEMO("{_}J}C");
        arrstring[64] = ka.H("\u0003{\u0005}\u0007{\u0012V\u0007a\u0003r\tg\u001f");
        arrstring[65] = LittleEndianAccessor.ALLATORIxDEMO("]xW`uU");
        arrstring[66] = ka.H("\u0012g\u0007{\u0015s\tg\u000b");
        arrstring[67] = LittleEndianAccessor.ALLATORIxDEMO("LpI`D{C");
        arrstring[68] = ka.H("f\u0007x\u0016y\u0003");
        arrstring[69] = LittleEndianAccessor.ALLATORIxDEMO("Iq^dL}_");
        arrstring[70] = ka.H("y\tc\u0003");
        arrstring[71] = LittleEndianAccessor.ALLATORIxDEMO("^|DzH");
        arrstring[72] = ka.H("\u0004y\u0007o\u0003");
        arrstring[73] = LittleEndianAccessor.ALLATORIxDEMO("Ea@");
        arrstring[74] = ka.H("w\tb\u000f{\u0001");
        arrstring[75] = LittleEndianAccessor.ALLATORIxDEMO("E{Y");
        arrstring[76] = ka.H("|\bv*@\r");
        arrstring[77] = LittleEndianAccessor.ALLATORIxDEMO("fHwBbHfT");
        arrstring[78] = ka.H("t\u0002q\u000fa\u000fz\b");
        arrstring[79] = LittleEndianAccessor.ALLATORIxDEMO("dDwFa]YHgB");
        arrstring[80] = ka.H("e\u000fv\r`\u0016\\\u0012p\u000b");
        arrstring[81] = LittleEndianAccessor.ALLATORIxDEMO("dDwFa][Y|Hf^");
        arrstring[82] = ka.H("f\u0011p\u0003e z\u0014Q\u0014z\u0016");
        arrstring[83] = LittleEndianAccessor.ALLATORIxDEMO("N{CgXyH\\}");
        arrstring[84] = ka.H("\nz\br4t\br\u0003");
        arrstring[85] = LittleEndianAccessor.ALLATORIxDEMO("N{CgXyHY}");
        arrstring[86] = ka.H("|\u0001{\tg\u0003E\u000fv\r`\u0016");
        arrstring[87] = LittleEndianAccessor.ALLATORIxDEMO("Cu@qyuJ");
        arrstring[88] = ka.H("\u0005}\u0007a$t\ny\tz\b");
        arrstring[89] = LittleEndianAccessor.ALLATORIxDEMO("gEu_uOxH[CwH");
        arrstring[90] = ka.H("s\u0015");
        arrstring[91] = LittleEndianAccessor.ALLATORIxDEMO("Yu@}Cs`{O");
        arrstring[92] = ka.H("\u000f{\u0005F\u0011|\u000b");
        arrstring[93] = LittleEndianAccessor.ALLATORIxDEMO("}CwkuY}JaH");
        arrstring[94] = ka.H("}\u0016G\u0003v\tc\u0003g\u001f");
        arrstring[95] = LittleEndianAccessor.ALLATORIxDEMO("y]FHwBbHfT");
        arrstring[96] = ka.H("b\u0007y\r");
        arrstring[97] = LittleEndianAccessor.ALLATORIxDEMO("^`LzI");
        arrstring[98] = ka.H("t\u0012a\u0007v\r");
        arrstring[99] = LittleEndianAccessor.ALLATORIxDEMO("uK`HfdyLsH");
        arrstring[100] = ka.H("\u0015s\u001e");
        arrstring[101] = LittleEndianAccessor.ALLATORIxDEMO("L`YuN\u007f~dHqI");
        arrstring[102] = ka.H("f\u0005t\bA\u0014t\u0002p$y\tv\r");
        arrstring[103] = LittleEndianAccessor.ALLATORIxDEMO("DzNF`Uk");
        arrstring[104] = ka.H("\u000f{\u0005G+T5");
        arrstring[105] = LittleEndianAccessor.ALLATORIxDEMO("HxHyiqKuXxY");
        arrstring[106] = ka.H("\u000f{\u0005G+T/");
        arrstring[107] = LittleEndianAccessor.ALLATORIxDEMO("DzNF`Ua");
        arrstring[108] = ka.H("p\u0016|\u0005");
        arrstring[109] = LittleEndianAccessor.ALLATORIxDEMO("|DpH");
        arrstring[110] = ka.H("\u0007q\u0002|\u0012z\b");
        arrstring[111] = LittleEndianAccessor.ALLATORIxDEMO("FzBwFvLwF");
        ALLATORIxDEMO = arrstring;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a) {
        System.out.println(ka.H("l6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E\u001fE5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F6l6F5F5F5F5E6F6F5F6F5F5E6F6E6F6E6F6E5F6E6F5F5F5F5E\u001fE5F5F5F5E5E5E5F5E5F5E5E5F6F5E5E5E5E5F6F5F5F5F5F6l6F5F5F5F6E6F6F5F6F5F6E6F5E5F6F6F6E5F5E5F5F5F5F5E\u001fE5F5F5F5E5E5E6E5E6E5E5E5F6F5E6E5E5E5E6E5F5F5F5F6l6F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5E\u001fE5)w\u0000`\u0015v\u0007a\u000fz\b5\u0004lFT\ny\u0007a\tg\u000f5)w\u0000`\u0015v\u0007a\tgFcQ;U5\"P+ZF6l6F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5E\u001fE5F5F5F5F5F5\u000ea\u0012e\\:Ib\u0011bHt\ny\u0007a\tg\u000f;\u0005z\u000b5F5F5F5F5F5F6l6F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5F5E\u001fE6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6E6l"));
        var1_1 = System.currentTimeMillis();
        var3_3 = new SimpleDateFormat(LittleEndianAccessor.ALLATORIxDEMO("\\e.@y\u0017g^.~G~"));
        System.out.println(ka.H("\u6396\u63a9\u76fb\u9362\u4e38H;H"));
        if (a.length >= 1 && !a[0].isEmpty()) {
            UltimateWzClear.k = a[0];
        }
        UltimateWzClear.F = new File(UltimateWzClear.k);
        UltimateWzClear.C = FileUtils.listFiles((File)UltimateWzClear.F, null, (boolean)true);
        UltimateWzClear.e = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        UltimateWzClear.g = XPathFactory.newInstance().newXPath();
        var4_4 = UltimateWzClear.C.iterator();
lbl13:
        // 3 sources

        while (var4_4.hasNext()) {
            UltimateWzClear.F = var5_6 = var4_4.next();
            ++UltimateWzClear.d;
            UltimateWzClear.E = UltimateWzClear.e.parse(var5_6);
            UltimateWzClear.B = (NodeList)UltimateWzClear.g.compile("/imgdir[@name='" + var5_6.getName().substring(0, 8) + ".img']/imgdir[@name='info']").evaluate(UltimateWzClear.E, XPathConstants.NODESET);
            UltimateWzClear.B = UltimateWzClear.B.item(0).getChildNodes();
            UltimateWzClear.a = false;
            v0 = var6_7 = 0;
lbl22:
            // 2 sources

            while (v0 < UltimateWzClear.B.getLength()) {
                var7_9 = UltimateWzClear.B.item(var6_7);
                var8_10 = false;
                if (!var7_9.hasAttributes()) ** GOTO lbl47
                v1 = var9_11 = 0;
lbl27:
                // 2 sources

                while (v1 < UltimateWzClear.ALLATORIxDEMO.length) {
                    if (!var7_9.getAttributes().getNamedItem(LittleEndianAccessor.ALLATORIxDEMO("zLyH")).toString().contains(UltimateWzClear.ALLATORIxDEMO[var9_11])) ** GOTO lbl-1000
                    v2 = var8_10 = true;
                    ** GOTO lbl42
                }
                ** GOTO lbl-1000
            }
            ** GOTO lbl49
            {
                catch (NullPointerException | SAXException var6_8) {
                }
            }
        }
        ** GOTO lbl53
        {
            catch (IOException | ParserConfigurationException | XPathExpressionException var1_2) {
                Logger.getLogger(UltimateWzClear.class.getName()).log(Level.SEVERE, null, var1_2);
                return;
            }
lbl-1000:
            // 1 sources

            {
                v1 = ++var9_11;
                ** GOTO lbl27
            }
lbl-1000:
            // 1 sources

            {
                v2 = var8_10;
lbl42:
                // 2 sources

                if (!v2) {
                    var7_9.getParentNode().removeChild(var7_9);
                    ++UltimateWzClear.K;
                    UltimateWzClear.a = true;
                }
lbl47:
                // 4 sources

                v0 = ++var6_7;
                ** GOTO lbl22
lbl49:
                // 1 sources

                if (UltimateWzClear.a) {
                    UltimateWzClear.saveFile();
                }
                System.out.println("\r\u6700\u5f8c\u6a94\u6848: " + var5_6.getAbsolutePath() + "\t\t\t\t");
            }
            ** GOTO lbl13
lbl53:
            // 1 sources

            var4_5 = System.currentTimeMillis();
            System.out.println("\n\u6642\u9593: " + var3_3.format(var4_5 - var1_1 - 68400000L));
            System.out.println("\u5df2\u6383\u63cf\u6a94\u6848: " + UltimateWzClear.d);
            System.out.println("\u79fb\u9664\u7bc0\u9ede: " + UltimateWzClear.K);
            return;
        }
    }

    public /* synthetic */ UltimateWzClear() {
        UltimateWzClear a2;
    }

    public static /* synthetic */ void saveFile() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource dOMSource = new DOMSource(E);
            StreamResult streamResult = new StreamResult(new File(F.getAbsolutePath()));
            transformer.transform(dOMSource, streamResult);
            return;
        }
        catch (TransformerException transformerException) {
            Logger.getLogger(UltimateWzClear.class.getName()).log(Level.SEVERE, null, transformerException);
            return;
        }
    }
}

