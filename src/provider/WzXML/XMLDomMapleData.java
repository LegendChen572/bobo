/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import client.SummonSkillEntry;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import provider.MapleData;
import provider.MapleDataEntity;
import provider.WzXML.FileStoredPngMapleCanvas;
import provider.WzXML.MapleDataType;
import tools.ExternalCodeLongTableGetter;
import tools.FilePrinter;

public class XMLDomMapleData
implements MapleData,
Serializable {
    private /* synthetic */ Node d;
    private /* synthetic */ File ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ Object getData() {
        XMLDomMapleData a2;
        XMLDomMapleData xMLDomMapleData = a2;
        NamedNodeMap namedNodeMap = xMLDomMapleData.d.getAttributes();
        MapleDataType mapleDataType = xMLDomMapleData.getType();
        switch (1.ALLATORIxDEMO[mapleDataType.ordinal()]) {
            case 1: {
                return Double.parseDouble(namedNodeMap.getNamedItem(SummonSkillEntry.ALLATORIxDEMO("Ej_~V")).getNodeValue());
            }
            case 2: {
                return Float.valueOf(Float.parseFloat(namedNodeMap.getNamedItem(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001d3\u0007'\u000e")).getNodeValue()));
            }
            case 3: {
                return Integer.parseInt(namedNodeMap.getNamedItem(SummonSkillEntry.ALLATORIxDEMO("Ej_~V")).getNodeValue());
            }
            case 4: {
                return Short.parseShort(namedNodeMap.getNamedItem(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001d3\u0007'\u000e")).getNodeValue());
            }
            case 5: 
            case 6: {
                return namedNodeMap.getNamedItem(SummonSkillEntry.ALLATORIxDEMO("Ej_~V")).getNodeValue();
            }
            case 7: {
                return new Point(Integer.parseInt(namedNodeMap.getNamedItem(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0013")).getNodeValue()), Integer.parseInt(namedNodeMap.getNamedItem(SummonSkillEntry.ALLATORIxDEMO("J")).getNodeValue()));
            }
            case 8: {
                return new FileStoredPngMapleCanvas(Integer.parseInt(namedNodeMap.getNamedItem(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001c;\u000f&\u0003")).getNodeValue()), Integer.parseInt(namedNodeMap.getNamedItem(SummonSkillEntry.ALLATORIxDEMO("cVbTcG")).getNodeValue()), new File(a2.ALLATORIxDEMO, a2.getName() + ".png"));
            }
        }
        return null;
    }

    @Override
    public /* synthetic */ MapleData getChildByPath(String a2) {
        XMLDomMapleData xMLDomMapleData;
        int n2;
        XMLDomMapleData a3;
        String[] arrstring = a2.split("/");
        if (arrstring[0].equals(SummonSkillEntry.ALLATORIxDEMO("%\u001d"))) {
            String string = a2;
            return ((MapleData)a3.getParent()).getChildByPath(string.substring(string.indexOf("/") + 1));
        }
        Node node = a3.d;
        int n3 = n2 = 0;
        while (n3 < arrstring.length) {
            boolean bl;
            block8: {
                NodeList nodeList = node.getChildNodes();
                boolean bl2 = false;
                if (nodeList != null) {
                    int n4;
                    int n5 = n4 = 0;
                    while (n5 < nodeList.getLength()) {
                        block7: {
                            try {
                                Node node2 = nodeList.item(n4);
                                if (node2 == null || node2.getNodeType() != 1 || !node2.getAttributes().getNamedItem(ExternalCodeLongTableGetter.ALLATORIxDEMO("<\n?\u000e")).getNodeValue().equals(arrstring[n2])) break block7;
                                node = node2;
                                bl = bl2 = true;
                                break block8;
                            }
                            catch (NullPointerException nullPointerException) {
                                FilePrinter.printError(SummonSkillEntry.ALLATORIxDEMO("S~GwdP~^n]\u007f~jCgVOR\u007fR%GsG"), nullPointerException, ExternalCodeLongTableGetter.ALLATORIxDEMO("5\u000e&(:\u0002>\u000f\u0010\u0012\u0002\n&\u0003"));
                            }
                        }
                        n5 = ++n4;
                    }
                }
                bl = bl2;
            }
            if (!bl) {
                return null;
            }
            n3 = ++n2;
        }
        XMLDomMapleData xMLDomMapleData2 = xMLDomMapleData = new XMLDomMapleData(node);
        xMLDomMapleData2.ALLATORIxDEMO = new File(a3.ALLATORIxDEMO, a3.getName() + "/" + a2).getParentFile();
        return xMLDomMapleData;
    }

    @Override
    public /* synthetic */ MapleDataEntity getParent() {
        XMLDomMapleData a2;
        Node node = a2.d.getParentNode();
        if (node.getNodeType() == 9) {
            return null;
        }
        new XMLDomMapleData(node).ALLATORIxDEMO = a2.ALLATORIxDEMO.getParentFile();
        return new XMLDomMapleData(node);
    }

    @Override
    public /* synthetic */ List<MapleData> getChildren() {
        int n2;
        XMLDomMapleData a2;
        ArrayList<MapleData> arrayList = new ArrayList<MapleData>();
        NodeList nodeList = a2.d.getChildNodes();
        int n3 = n2 = 0;
        while (n3 < nodeList.getLength()) {
            Object object = nodeList.item(n2);
            if (object != null && object.getNodeType() == 1) {
                ((XMLDomMapleData)(object = new XMLDomMapleData((Node)object))).ALLATORIxDEMO = new File(a2.ALLATORIxDEMO, a2.getName());
                arrayList.add((MapleData)(object = new XMLDomMapleData((Node)object)));
            }
            n3 = ++n2;
        }
        return arrayList;
    }

    @Override
    public /* synthetic */ String getName() {
        XMLDomMapleData a2;
        return a2.d.getAttributes().getNamedItem(ExternalCodeLongTableGetter.ALLATORIxDEMO("<\n?\u000e")).getNodeValue();
    }

    @Override
    public /* synthetic */ Iterator<MapleData> iterator() {
        XMLDomMapleData a2;
        return a2.getChildren().iterator();
    }

    public /* synthetic */ XMLDomMapleData(FileInputStream a2, File a3) {
        XMLDomMapleData a4;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            Document document = documentBuilderFactory.newDocumentBuilder().parse(a2);
            a4.d = document.getFirstChild();
        }
        catch (ParserConfigurationException parserConfigurationException) {
            throw new RuntimeException(parserConfigurationException);
        }
        catch (SAXException sAXException) {
            File file = a3;
            System.err.println("fis: " + a2.toString() + " File: " + file + " name: " + file.getName());
            throw new RuntimeException(sAXException);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        a4.ALLATORIxDEMO = a3;
    }

    @Override
    public final /* synthetic */ MapleDataType getType() {
        XMLDomMapleData a2;
        String string = a2.d.getNodeName();
        if (string.equals(ExternalCodeLongTableGetter.ALLATORIxDEMO(";\u00065\u000f;\u0019"))) {
            return MapleDataType.PROPERTY;
        }
        if (string.equals(SummonSkillEntry.ALLATORIxDEMO("hReEj@"))) {
            return MapleDataType.CANVAS;
        }
        if (string.equals(ExternalCodeLongTableGetter.ALLATORIxDEMO("1\u0004<\u001d7\u0013"))) {
            return MapleDataType.CONVEX;
        }
        if (string.equals(SummonSkillEntry.ALLATORIxDEMO("@dFeW"))) {
            return MapleDataType.SOUND;
        }
        if (string.equals(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001e=\u0007"))) {
            return MapleDataType.UOL;
        }
        if (string.equals(SummonSkillEntry.ALLATORIxDEMO("o\\~QgV"))) {
            return MapleDataType.DOUBLE;
        }
        if (string.equals(ExternalCodeLongTableGetter.ALLATORIxDEMO("\r>\u00043\u001f"))) {
            return MapleDataType.FLOAT;
        }
        if (string.equals(SummonSkillEntry.ALLATORIxDEMO("ZeG"))) {
            return MapleDataType.INT;
        }
        if (string.equals(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0018:\u0004 \u001f"))) {
            return MapleDataType.SHORT;
        }
        if (string.equals(SummonSkillEntry.ALLATORIxDEMO("xGyZeT"))) {
            return MapleDataType.STRING;
        }
        if (string.equals(ExternalCodeLongTableGetter.ALLATORIxDEMO("$\u000e1\u001f=\u0019"))) {
            return MapleDataType.VECTOR;
        }
        if (string.equals(SummonSkillEntry.ALLATORIxDEMO("eFg_"))) {
            return MapleDataType.IMG_0x00;
        }
        return null;
    }

    private /* synthetic */ XMLDomMapleData(Node a2) {
        XMLDomMapleData a3;
        a3.d = a2;
    }
}

