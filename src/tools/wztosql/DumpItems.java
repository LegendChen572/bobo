/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.wztosql;

import client.inventory.EquipAdditions;
import client.inventory.MapleInventoryType;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import handling.cashshop.handler.CashShopOperation;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataEntity;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import provider.WzXML.MapleDataType;
import server.life.Element;
import server.swing.Progressbar;
import tools.FileoutputUtil;
import tools.GZIPCompression;
import tools.Pair;
import tools.database.DatabaseConvert;

public class DumpItems {
    private static /* synthetic */ Thread k;
    public final /* synthetic */ MapleData petStringData;
    private /* synthetic */ boolean ALLATORIxDEMO;
    public /* synthetic */ int id;
    public /* synthetic */ boolean OnlyItem;
    private final /* synthetic */ MapleDataProvider g;
    public final /* synthetic */ MapleData cashStringData;
    public final /* synthetic */ MapleData insStringData;
    private final /* synthetic */ MapleDataProvider B;
    private static /* synthetic */ Thread d;
    private final /* synthetic */ MapleDataProvider E;
    public final /* synthetic */ MapleData consumeStringData;
    private static /* synthetic */ Thread K;
    public /* synthetic */ boolean update;
    public final /* synthetic */ MapleData etcStringData;
    public final /* synthetic */ Set<Integer> doneIds;
    private static /* synthetic */ Thread a;
    public final /* synthetic */ MapleData eqpStringData;
    public /* synthetic */ boolean hadError;

    /*
     * Exception decompiling
     */
    public /* synthetic */ void dumpItems() throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

    public /* synthetic */ int currentId() {
        DumpItems a2;
        return a2.id;
    }

    public /* synthetic */ void dumpItem(PreparedStatement a2, PreparedStatement a3, PreparedStatement a4, PreparedStatement a5, MapleData a6) throws Exception {
        PreparedStatement preparedStatement;
        int n2;
        Object object;
        Object object2;
        Iterator<MapleData> iterator;
        Object object3;
        DumpItems dumpItems;
        double d2;
        PreparedStatement preparedStatement2;
        int n3;
        MapleData object52;
        DumpItems dumpItems2;
        String string;
        MapleData mapleData;
        DumpItems a7;
        block84: {
            try {
                if (!a6.getName().endsWith(CashShopOperation.ALLATORIxDEMO("\u0018\u000f[\u0001"))) break block84;
                a7.id = Integer.parseInt(a6.getName().substring(0, a6.getName().length() - 4));
            }
            catch (NumberFormatException numberFormatException) {
                return;
            }
        }
        a7.id = Integer.parseInt(a6.getName());
        DumpItems dumpItems3 = a7;
        if (dumpItems3.doneIds.contains(dumpItems3.id) || GameConstants.getInventoryType(a7.id) == MapleInventoryType.UNDEFINED) {
            return;
        }
        DumpItems dumpItems4 = a7;
        dumpItems4.doneIds.add(dumpItems4.id);
        if (dumpItems4.update) {
            DumpItems dumpItems5 = a7;
            if (dumpItems5.doesExist("SELECT * FROM wz_itemdata WHERE itemid = " + dumpItems5.id)) {
                return;
            }
        }
        a4.setInt(1, a7.id);
        DumpItems dumpItems6 = a7;
        MapleData mapleData2 = dumpItems6.getStringData(dumpItems6.id);
        PreparedStatement preparedStatement3 = a4;
        if (mapleData2 == null) {
            preparedStatement3.setString(2, "");
            mapleData = mapleData2;
            PreparedStatement preparedStatement4 = a4;
            preparedStatement4.setString(3, "");
            preparedStatement4.setString(4, "");
        } else {
            preparedStatement3.setString(2, MapleDataTool.getString(GZIPCompression.ALLATORIxDEMO("\\m_i"), mapleData2, ""));
            mapleData = mapleData2;
            PreparedStatement preparedStatement5 = a4;
            preparedStatement5.setString(3, MapleDataTool.getString(CashShopOperation.ALLATORIxDEMO("\u000bE\u0001"), mapleData2, ""));
            preparedStatement5.setString(4, MapleDataTool.getString(GZIPCompression.ALLATORIxDEMO("ViAo"), mapleData2, ""));
        }
        if (mapleData == null) {
            string = CashShopOperation.ALLATORIxDEMO("x\tX\u0003");
            dumpItems2 = a7;
        } else {
            string = MapleDataTool.getString(GZIPCompression.ALLATORIxDEMO("\\m_i"), mapleData2, "");
            dumpItems2 = a7;
        }
        Progressbar.setText("\u8f49\u5b58\u9053\u5177[" + string + "(" + dumpItems2.id + ")]...");
        if (a7.update) {
            DumpItems dumpItems7;
            String string2;
            if (mapleData2 == null) {
                string2 = CashShopOperation.ALLATORIxDEMO("x\tX\u0003");
                dumpItems7 = a7;
            } else {
                string2 = MapleDataTool.getString(GZIPCompression.ALLATORIxDEMO("\\m_i"), mapleData2, "");
                dumpItems7 = a7;
            }
            System.out.println("\u8f49\u5b58\u65b0\u9053\u5177[" + string2 + "(" + dumpItems7.id + ")]...");
        }
        if ((object52 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u0015Z\tB+W\u001e"))) == null) {
            if (GameConstants.getInventoryType(a7.id) == MapleInventoryType.EQUIP) {
                n3 = 1;
                preparedStatement2 = a4;
            } else {
                n3 = 100;
                preparedStatement2 = a4;
            }
        } else {
            n3 = MapleDataTool.getIntConvert(object52, -1);
            preparedStatement2 = a4;
        }
        preparedStatement2.setInt(5, n3);
        n3 = MapleDataTool.getIntConvert(a6.getChildByPath(GZIPCompression.ALLATORIxDEMO("[bTc\u001dmGx]\\@eQi")), 0) > 0 ? 1 : 0;
        MapleData mapleData3 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u0013X\u000fB6D\u000fU\u0003"));
        if (mapleData3 != null) {
            try {
                d2 = MapleDataTool.getDouble(mapleData3);
                dumpItems = a7;
            }
            catch (Exception exception) {
                dumpItems = a7;
                d2 = MapleDataTool.getIntConvert(mapleData3, -1);
            }
        } else {
            MapleData mapleData4 = a6.getChildByPath(GZIPCompression.ALLATORIxDEMO("[bTc\u001d|@eQi"));
            if (mapleData4 == null && n3 == 0) {
                d2 = -1.0;
                dumpItems = a7;
            } else if (n3 != 0) {
                MapleData mapleData5 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("\u000fX\u0000YIZ\u0010"));
                dumpItems = a7;
                d2 = MapleDataTool.getIntConvert(mapleData5, 0) * 2;
            } else {
                d2 = MapleDataTool.getIntConvert(mapleData4, -1);
                dumpItems = a7;
            }
        }
        if (dumpItems.id == 2070019 || a7.id == 2330007) {
            d2 = 1.0;
        }
        PreparedStatement preparedStatement6 = a4;
        preparedStatement6.setString(6, String.valueOf(d2));
        preparedStatement6.setInt(7, MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[bTc\u001d|@eQi"), a6, -1));
        a4.setInt(8, MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u0015B\u0007B\u0003u\u000eW\bQ\u0003\u007f\u0012S\u000b"), a6, 0));
        int n4 = MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[bTc\u001dnSkfuBi"), a6, 0);
        if (MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\bY\u0012e\u0007Z\u0003"), a6, 0) > 0) {
            n4 |= 0x10;
        }
        if (MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("e\\j]#WtBe@i}b~cUcGx"), a6, 0) > 0) {
            n4 |= 0x20;
        }
        if (MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u0016_\u0005]3F$Z\tU\r"), a6, 0) > 0) {
            n4 |= 0x40;
        }
        if (MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("e\\j]#]b^u"), a6, 0) > 0) {
            n4 |= 0x80;
        }
        if (MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u0007U\u0005Y\u0013X\u0012e\u000eW\u0014W\u0004Z\u0003"), a6, 0) > 0) {
            n4 |= 0x100;
        }
        if (MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[bTc\u001d}GiAx"), a6, 0) > 0) {
            n4 |= 0x200;
        }
        if (a7.id != 4310008 && MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("\u000fX\u0000YIB\u0014W\u0002S$Z\tU\r"), a6, 0) > 0) {
            n4 |= 0x400;
        }
        if (MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[bTc\u001dmQo]y\\xadS~WXSk"), a6, 0) > 0) {
            n4 |= 0x800;
        }
        if (MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u000bY\u0004~6"), a6, 0) > 0 && MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[bTc\u001da]nz\\"), a6, 0) < 100) {
            n4 |= 0x1000;
        }
        PreparedStatement preparedStatement7 = a4;
        PreparedStatement preparedStatement8 = a4;
        a4.setInt(9, n4);
        preparedStatement8.setInt(10, MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("\u000fX\u0000YIB\u0014W\u0002S'@\u0007_\nW\u0004Z\u0003"), a6, 0));
        preparedStatement8.setInt(11, MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("e\\j]#_iAc"), a6, 0));
        preparedStatement7.setInt(12, MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u000bY\u0004"), a6, 0));
        preparedStatement7.setInt(13, MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("e\\j]#^z"), a6, 0));
        a4.setInt(14, MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\u0017C\u0003E\u0012\u007f\u0002"), a6, 0));
        n3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        MapleData mapleData6 = a6.getChildByPath(GZIPCompression.ALLATORIxDEMO("~W}"));
        if (mapleData6 != null) {
            Object object4 = object3 = mapleData6.iterator();
            while (object4.hasNext()) {
                iterator = (MapleData)object3.next();
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(CashShopOperation.ALLATORIxDEMO("J"));
                }
                stringBuilder.append(MapleDataTool.getIntConvert((MapleData)((Object)iterator), 0));
                object4 = object3;
            }
        }
        if ((mapleData6 = a6.getChildByPath(GZIPCompression.ALLATORIxDEMO("o]bAy_i{xWa"))) != null) {
            Object object5 = object3 = mapleData6.iterator();
            while (object5.hasNext()) {
                iterator = (MapleData)object3.next();
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(CashShopOperation.ALLATORIxDEMO("J"));
                }
                stringBuilder2.append(MapleDataTool.getIntConvert((MapleData)((Object)iterator), 0));
                object5 = object3;
            }
        }
        a4.setString(15, stringBuilder.toString());
        a4.setString(16, stringBuilder2.toString());
        object3 = new HashMap();
        object3.put(-1, new HashMap());
        mapleData6 = a6.getChildByPath(GZIPCompression.ALLATORIxDEMO("a]n"));
        if (mapleData6 != null) {
            iterator = mapleData6.iterator();
            Iterator<Object> iterator2 = iterator;
            while (iterator2.hasNext()) {
                MapleData mapleData7 = (MapleData)iterator.next();
                ((Map)object3.get(-1)).put("mob" + MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("_\u0002"), mapleData7, 0), MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("B~]n"), mapleData7, 0));
                iterator2 = iterator;
            }
        }
        if ((mapleData6 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("\u000fX\u0000YIZ\u0003@\u0003ZIU\u0007E\u0003"))) != null) {
            for (MapleData mapleData8 : mapleData6) {
                for (Object object6 : mapleData8) {
                    int n5;
                    String[] arrstring = new String[2];
                    arrstring[0] = GZIPCompression.ALLATORIxDEMO("_Ye^`");
                    arrstring[1] = CashShopOperation.ALLATORIxDEMO("s\u0017C\u000fF\u000bS\bB5]\u000fZ\n");
                    object2 = arrstring;
                    object = arrstring;
                    n2 = ((String[])object).length;
                    int n6 = n5 = 0;
                    while (n6 < n2) {
                        String string3 = object[n5];
                        if (object6.getName().length() == 1 && object6.getChildByPath(string3) != null) {
                            for (MapleData mapleData9 : object6.getChildByPath(string3)) {
                                int n7 = MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[h"), mapleData9, 0);
                                if (n7 == 0) continue;
                                if (stringBuilder3.length() > 0) {
                                    stringBuilder3.append(CashShopOperation.ALLATORIxDEMO("J"));
                                }
                                stringBuilder3.append(n7);
                            }
                        }
                        n6 = ++n5;
                    }
                }
            }
        }
        if ((mapleData6 = a6.getChildByPath(GZIPCompression.ALLATORIxDEMO("[bTc\u001d`WzW`"))) != null && MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("P\u000fN*S\u0010S\n"), mapleData6, 0) != 0 && MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("TeJ@WzW`"), mapleData6, 0) != 0) {
            Object object7 = object3;
            object7.put(-1, new HashMap());
            ((Map)object7.get(-1)).put(CashShopOperation.ALLATORIxDEMO("P\u000fN*S\u0010S\n"), MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("TeJ@WzW`"), mapleData6));
        }
        if ((mapleData6 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("\u000fX\u0000YIZ\u0003@\u0003ZI_\bP\t"))) != null) {
            iterator = mapleData6.iterator();
            block12: while (true) {
                Iterator iterator3 = iterator;
                while (iterator3.hasNext()) {
                    Object object6;
                    MapleData mapleData10 = (MapleData)iterator.next();
                    if (MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("iJ|"), mapleData10, 0) == 0) {
                        iterator3 = iterator;
                        continue;
                    }
                    int n8 = Integer.parseInt(mapleData10.getName());
                    if (object3.get(n8) == null) {
                        object3.put(n8, new HashMap());
                    }
                    object6 = mapleData10.iterator();
                    while (true) {
                        if (!object6.hasNext()) continue block12;
                        object2 = (MapleData)object6.next();
                        if (object2.getName().length() <= 3 || object2.getType() == MapleDataType.CANVAS) continue;
                        ((Map)object3.get(n8)).put(object2.getName().substring(3), MapleDataTool.getIntConvert((MapleData)object2, 0));
                    }
                }
                break;
            }
        }
        if ((mapleData6 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("_\bP\t"))) != null) {
            int n9;
            a4.setString(22, MapleDataTool.getString(GZIPCompression.ALLATORIxDEMO("SjFi@E_mUi"), mapleData6, ""));
            iterator = (Map)object3.get(-1);
            for (MapleData mapleData11 : mapleData6.getChildren()) {
                int n10;
                if (!mapleData11.getName().startsWith(CashShopOperation.ALLATORIxDEMO("\u000fX\u0005")) || (n10 = MapleDataTool.getIntConvert(mapleData11, 0)) == 0) continue;
                iterator.put(mapleData11.getName().substring(3), n10);
            }
            String[] arrstring = GameConstants.stats;
            int n11 = GameConstants.stats.length;
            int n12 = n9 = 0;
            while (n12 < n11) {
                object2 = arrstring[n9];
                object = mapleData6.getChildByPath((String)object2);
                if (((String)object2).equals(GZIPCompression.ALLATORIxDEMO("Qm\\@WzW`"))) {
                    if (mapleData6.getChildByPath(CashShopOperation.ALLATORIxDEMO("\nS\u0010S\n")) != null) {
                        iterator.put(object2, 1);
                    }
                } else if (object != null) {
                    if (((String)object2).equals(GZIPCompression.ALLATORIxDEMO("\u007fYe^`"))) {
                        int n13 = n2 = 0;
                        while (n13 < object.getChildren().size()) {
                            String string4 = "skillid" + n2;
                            String string5 = Integer.toString(n2);
                            iterator.put(string4, MapleDataTool.getIntConvert(string5, (MapleData)object, 0));
                            n13 = ++n2;
                        }
                    } else {
                        n2 = MapleDataTool.getIntConvert((MapleData)object, 0);
                        if (n2 != 0) {
                            iterator.put(object2, n2);
                        }
                    }
                }
                n12 = ++n9;
            }
        } else {
            a4.setString(22, "");
        }
        a5.setInt(1, a7.id);
        for (Map.Entry entry : object3.entrySet()) {
            a5.setInt(2, (Integer)entry.getKey());
            for (Map.Entry entry2 : ((Map)entry.getValue()).entrySet()) {
                a5.setString(3, (String)entry2.getKey());
                a5.setInt(4, (Integer)entry2.getValue());
                PreparedStatement preparedStatement9 = a5;
                if (a7.update) {
                    preparedStatement9.execute();
                    continue;
                }
                preparedStatement9.addBatch();
            }
        }
        mapleData6 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("\u000fX\u0000YIW\u0002R\u000fB\u000fY\b"));
        if (mapleData6 != null) {
            a2.setInt(1, a7.id);
            for (MapleData mapleData12 : mapleData6.getChildren()) {
                EquipAdditions equipAdditions = EquipAdditions.fromString(mapleData12.getName());
                if (equipAdditions != null) {
                    PreparedStatement preparedStatement10;
                    Pair<Integer, Integer> pair = null;
                    if (equipAdditions.isElement()) {
                        Object object8 = object2 = MapleDataTool.getString(equipAdditions.getValue1(), mapleData12, GZIPCompression.ALLATORIxDEMO("J\u0001<"));
                        pair = new Pair<Integer, Integer>(Element.getFromChar(((String)object2).charAt(0)).getValue(), Integer.parseInt(((String)object8).substring(1, ((String)object8).length())));
                        preparedStatement10 = a2;
                    } else {
                        pair = new Pair<Integer, Integer>(MapleDataTool.getIntConvert(equipAdditions.getValue1(), mapleData12, 0), MapleDataTool.getIntConvert(equipAdditions.getValue2(), mapleData12, 0));
                        preparedStatement10 = a2;
                    }
                    preparedStatement10.setString(2, mapleData12.getName());
                    a2.setInt(3, (Integer)pair.left);
                    a2.setInt(4, (Integer)pair.right);
                    a2.addBatch();
                    continue;
                }
                System.out.println("UNKNOWN EQ ADDITION : " + mapleData12.getName() + " from " + a7.id);
            }
        }
        if ((mapleData6 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("D\u0003A\u0007D\u0002"))) != null) {
            a3.setInt(1, a7.id);
            iterator = mapleData6.iterator();
            Iterator<Object> iterator4 = iterator;
            while (iterator4.hasNext()) {
                int n14;
                MapleData mapleData13 = iterator.next();
                PreparedStatement preparedStatement11 = a3;
                PreparedStatement preparedStatement12 = a3;
                PreparedStatement preparedStatement13 = a3;
                preparedStatement13.setInt(2, MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("[xWa"), mapleData13, 0));
                preparedStatement13.setInt(3, MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("F\u0014Y\u0004"), mapleData13, 0));
                preparedStatement12.setInt(4, MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("o]y\\x"), mapleData13, 0));
                preparedStatement12.setInt(5, MapleDataTool.getIntConvert(CashShopOperation.ALLATORIxDEMO("F\u0003D\u000fY\u0002"), mapleData13, 0));
                preparedStatement11.setString(6, MapleDataTool.getString(GZIPCompression.ALLATORIxDEMO("Ec@`VAAk"), mapleData13, ""));
                preparedStatement11.setString(7, MapleDataTool.getString(CashShopOperation.ALLATORIxDEMO("s\u0000P\u0003U\u0012"), mapleData13, ""));
                PreparedStatement preparedStatement14 = a3;
                if (a7.update) {
                    preparedStatement14.execute();
                    n14 = n3;
                } else {
                    preparedStatement14.addBatch();
                    n14 = n3;
                }
                n3 = n14 + MapleDataTool.getIntConvert(GZIPCompression.ALLATORIxDEMO("B~]n"), mapleData13, 0);
                iterator4 = iterator;
            }
        }
        a4.setInt(17, n3);
        a4.setString(18, stringBuilder3.toString());
        mapleData6 = a6.getChildByPath(CashShopOperation.ALLATORIxDEMO("\u0014S\u0016Z\u0007U\u0003"));
        PreparedStatement preparedStatement15 = a4;
        if (mapleData6 != null) {
            preparedStatement15.setInt(19, MapleDataTool.getInt(GZIPCompression.ALLATORIxDEMO("[xWa[h"), mapleData6, 0));
            PreparedStatement preparedStatement16 = a4;
            preparedStatement = preparedStatement16;
            preparedStatement16.setString(20, MapleDataTool.getString(CashShopOperation.ALLATORIxDEMO("\u000bE\u0001"), mapleData6, ""));
        } else {
            preparedStatement15.setInt(19, 0);
            PreparedStatement preparedStatement17 = a4;
            preparedStatement = preparedStatement17;
            preparedStatement17.setString(20, "");
        }
        preparedStatement.setInt(21, MapleDataTool.getInt(GZIPCompression.ALLATORIxDEMO("e\\j]#Q~WmFi"), a6, 0));
        PreparedStatement preparedStatement18 = a4;
        a4.setInt(23, MapleDataTool.getInt(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\tF\u0012_\tXI\u0006IY\u0016B\u000fY\b"), a6, 0));
        preparedStatement18.setInt(24, MapleDataTool.getInt(GZIPCompression.ALLATORIxDEMO("[bTc\u001dcBx[c\\#\u0003#]|Fe]b"), a6, 0));
        preparedStatement18.setInt(25, MapleDataTool.getInt(CashShopOperation.ALLATORIxDEMO("_\bP\t\u0019\tF\u0012_\tXI\u0004IY\u0016B\u000fY\b"), a6, 0));
        PreparedStatement preparedStatement19 = a4;
        if (a7.update) {
            preparedStatement19.execute();
            return;
        }
        preparedStatement19.addBatch();
    }

    public static /* synthetic */ void main(String[] a2) {
        int n2;
        System.out.println(GZIPCompression.ALLATORIxDEMO("\u0006\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/8/\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0011\u0006\u0011,\u0012,\u0012,\u0012,\u0012/\u0011,\u0011,\u0012,\u0011,\u0012,\u0012/\u0011,\u0011/\u0011,\u0011/\u0011,\u0011/\u0012,\u0011/\u0011,\u0012,\u0012,\u0012,\u0012/8/\u0012,\u0012,\u0012,\u0012/\u0012/\u0012/\u0012,\u0012/\u0012,\u0012/\u0012/\u0012,\u0011,\u0012/\u0012/\u0012/\u0012/\u0012,\u0011,\u0012,\u0012,\u0012,\u0012,\u0011\u0006\u0011,\u0012,\u0012,\u0012,\u0011/\u0011,\u0011,\u0012,\u0011,\u0012,\u0011/\u0011,\u0012/\u0012,\u0011,\u0011,\u0011/\u0012,\u0012/\u0012,\u0012,\u0012,\u0012,\u0012/8/\u0012,\u0012,\u0012,\u0012/\u0012/\u0012/\u0011/\u0012/\u0011/\u0012/\u0012/\u0012,\u0011,\u0012/\u0011/\u0012/\u0012/\u0012/\u0011/\u0012,\u0012,\u0012,\u0012,\u0011\u0006\u0011,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012/8/\u0012CPjG\u007fQmFe]b\u0012nK,s`^mFc@e\u0012CPjG\u007fQmFc@,D;\u001c?\u0012HwA},\u0011\u0006\u0011,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012/8/\u0012,\u0012,\u0012,\u0012,\u0012,\u0012dFxB6\u001d#E{E\"S`^mFc@e\u001co]a\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0011\u0006\u0011,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012,\u0012/8/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011/\u0011\u0006"));
        GameSetConstants.loadsetting();
        GameSetConstants.reloadset();
        Progressbar.setValue(0);
        Progressbar.setText(CashShopOperation.ALLATORIxDEMO("\u8f2f\u5b6e\u9035\u5141H\u0018H"));
        boolean bl = false;
        int n3 = 0;
        int n4 = 0;
        long l2 = System.currentTimeMillis();
        String[] arrstring = a2;
        int n5 = a2.length;
        int n6 = n2 = 0;
        while (n6 < n5) {
            String string = arrstring[n2];
            if (string.equalsIgnoreCase("update")) {
                n3 = 1;
            } else if (string.equalsIgnoreCase(GZIPCompression.ALLATORIxDEMO("]b^u[xWa"))) {
                n4 = 1;
            }
            n6 = ++n2;
        }
        if (!DBConPool.getInstance().ColumnExist(CashShopOperation.ALLATORIxDEMO("\u0011L9_\u0012S\u000bR\u0007B\u0007"), GZIPCompression.ALLATORIxDEMO("cBx[c\\="))) {
            DatabaseConvert.Add_WzItemData();
            System.out.println(CashShopOperation.ALLATORIxDEMO("\u5d94\u7da5\u70dc\u609e\u818c\u52e3\u6692\u6586\u0011L9_\u0012S\u000bR\u0007B\u0007\u8cf1\u65ff\u885eG"));
        }
        int n7 = 0;
        try {
            DumpItems dumpItems = new DumpItems(n3 != 0, n4 != 0);
            System.out.println(GZIPCompression.ALLATORIxDEMO("\u8f7b\u5b54\u9061\u517b"));
            dumpItems.dumpItems();
            DumpItems dumpItems2 = dumpItems;
            bl |= dumpItems2.isHadError();
            n7 = dumpItems2.currentId();
        }
        catch (Exception exception) {
            bl = true;
            exception.printStackTrace();
            System.out.println(n7 + " quest.");
        }
        long l3 = System.currentTimeMillis();
        double d2 = (double)(l3 - l2) / 1000.0;
        n3 = (int)d2 % 60;
        n4 = (int)(d2 / 60.0);
        String string = "";
        if (bl) {
            string = CashShopOperation.ALLATORIxDEMO("N\u673f\u9349\u8a92O");
        }
        Progressbar.setValue(100);
        System.out.println("\u5b8c\u6210" + string + "\uff0c\u8017\u6642\uff1a" + n4 + "\u5206" + n3 + "\u79d2");
    }

    public /* synthetic */ void dumpItems(PreparedStatement a2, PreparedStatement a3, PreparedStatement a4, PreparedStatement a5) throws Exception {
        DumpItems a6;
        if (!a6.update) {
            Progressbar.setText(GZIPCompression.ALLATORIxDEMO("\u6e37\u740a\u654a\u64d6\u5e99\"\u001c\""));
            if (!a6.OnlyItem) {
                DumpItems dumpItems = a6;
                DumpItems dumpItems2 = a6;
                dumpItems2.delete(CashShopOperation.ALLATORIxDEMO("\"s*s2sFp4y+\u0016\u0011L9_\u0012S\u000bR\u0007B\u0007"));
                dumpItems2.delete(GZIPCompression.ALLATORIxDEMO("vI~IfI\u0012J`C\u007f,EvmeFi_iCy[|VmFm"));
                dumpItems.delete(CashShopOperation.ALLATORIxDEMO("r#z#b#\u0016 d){FA\u001ci\u000fB\u0003[\u0007R\u0002R\u0007B\u0007"));
                dumpItems.delete(GZIPCompression.ALLATORIxDEMO("Hw@wXw,t^}A\u0012{HS[xWa@iEm@hVmFm"));
                System.out.println(CashShopOperation.ALLATORIxDEMO("\u6e33\u7a1c\u0014\u0011L9_\u0012S\u000bR\u0007B\u0007\u0014\u5ecdm\u510e\u90de;\u6226\u52f9"));
            } else {
                a6.delete(GZIPCompression.ALLATORIxDEMO("Hw@wXw,t^}A\u0012{HS[xWaVmFm\u0012[zI`I\u0012eFi_eV,\f1\u0012>\u0002<\u0002<\u0002<"));
                System.out.println(CashShopOperation.ALLATORIxDEMO("\u6e33\u7a1c\u0014\u0011L9_\u0012S\u000bR\u0007B\u0007\u0014\u5ecdm/b#{\u8ca1\u65af;\u6226\u52f9"));
            }
        }
        System.out.println(GZIPCompression.ALLATORIxDEMO("\u6b51\u5724\u6dc9\u52ac\u9000.EvmeFi_hSxS.\u5e99\"\u001c\"\u001c\""));
        DumpItems dumpItems = a6;
        dumpItems.dumpItems(dumpItems.E, a2, a3, a4, a5, false);
        if (!dumpItems.OnlyItem) {
            DumpItems dumpItems3 = a6;
            dumpItems3.dumpItems(dumpItems3.g, a2, a3, a4, a5, true);
        }
        System.out.println(CashShopOperation.ALLATORIxDEMO("\u5bba\u6276\u0014\u0011L9_\u0012S\u000bR\u0007B\u0007\u0014\u5ecd\u76b2\u8f2f\u5b6eJ\u0016\u8f2f\u5b6e\u90e2\u571e\u9054\u887a\u8aad\u52c9\u95ba\u95bfH\u0018H"));
    }

    public /* synthetic */ boolean doesExist(String a22) throws Exception {
        boolean bl;
        block5: {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement = druidPooledConnection.prepareStatement((String)a22);
                a22 = preparedStatement.executeQuery();
                bl = a22.next();
                a22.close();
                preparedStatement.close();
                if (druidPooledConnection == null) break block5;
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                block6: {
                    if (druidPooledConnection != null) {
                        try {
                            druidPooledConnection.close();
                            throwable2 = throwable;
                            break block6;
                        }
                        catch (Throwable a22) {
                            throwable.addSuppressed(a22);
                        }
                    }
                    throwable2 = throwable;
                }
                throw throwable2;
            }
            druidPooledConnection.close();
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void delete(String a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
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

    public /* synthetic */ void dumpItems(MapleDataProvider a2, PreparedStatement a3, PreparedStatement a4, PreparedStatement a5, PreparedStatement a6, boolean a7) throws Exception {
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : a2.getRoot().getSubdirectories()) {
            if (mapleDataDirectoryEntry.getName().equalsIgnoreCase(CashShopOperation.ALLATORIxDEMO("5F\u0003U\u000fW\n")) || mapleDataDirectoryEntry.getName().equalsIgnoreCase(GZIPCompression.ALLATORIxDEMO("sjFi@e_mUi"))) continue;
            for (MapleDataEntity mapleDataEntity : mapleDataDirectoryEntry.getFiles()) {
                MapleData mapleData;
                DumpItems a8;
                if (a8.ALLATORIxDEMO) {
                    MapleDataFileEntry mapleDataFileEntry = mapleDataEntity;
                    System.out.println("topDir: " + mapleDataDirectoryEntry.getName() + " ifile: " + mapleDataFileEntry + (String)(mapleDataFileEntry == null ? "" : " Name: " + mapleDataEntity.getName()));
                }
                MapleData mapleData2 = null;
                try {
                    mapleData = mapleData2 = a2.getData(mapleDataDirectoryEntry.getName() + "/" + mapleDataEntity.getName());
                }
                catch (Exception exception) {
                    FileoutputUtil.logToFile(CashShopOperation.ALLATORIxDEMO("Z\tQ\u0015\u0019\u001e[\n\u0018\u0012N\u0012"), mapleDataDirectoryEntry.getName() + "/" + mapleDataEntity.getName());
                    mapleData = mapleData2;
                }
                if (mapleData == null) continue;
                if (a7 || mapleDataDirectoryEntry.getName().equalsIgnoreCase(GZIPCompression.ALLATORIxDEMO("\\Wx"))) {
                    a8.dumpItem(a3, a4, a5, a6, mapleData2);
                    continue;
                }
                Iterator iterator = mapleData2.iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2;
                    mapleDataEntity = (MapleData)iterator2.next();
                    iterator = iterator2;
                    a8.dumpItem(a3, a4, a5, a6, (MapleData)mapleDataEntity);
                }
            }
        }
    }

    public final /* synthetic */ MapleData getStringData(int a2) {
        String string;
        MapleData mapleData;
        DumpItems a3;
        String string2 = null;
        if (a2 >= 5010000) {
            mapleData = a3.cashStringData;
            string = string2;
        } else if (a2 >= 2000000 && a2 < 3000000) {
            mapleData = a3.consumeStringData;
            string = string2;
        } else if (a2 >= 1010000 && a2 < 1040000 || a2 >= 1122000 && a2 < 1123000 || a2 >= 1132000 && a2 < 1210000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("IC|\u001dMQoW\u007fAc@u");
        } else if (a2 >= 1662000 && a2 < 1680000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("#G\u0016\u0019'X\u0002D\t_\u0002");
        } else if (a2 >= 1680000 && a2 < 1690000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#peF\u007f");
        } else if (a2 >= 1000000 && a2 < 1010000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("#G\u0016\u0019%W\u0016");
        } else if (a2 >= 1100000 && a2 < 1103000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#qmBi");
        } else if (a2 >= 1040000 && a2 < 1050000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("s\u0017FIu\tW\u0012");
        } else if (a2 >= 1920000 && a2 < 2000000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#v~Sk]b");
        } else if (a2 >= 20000 && a2 < 25000 || a2 >= 50000 && a2 < 60000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("s\u0017FIp\u0007U\u0003");
        } else if (a2 >= 1080000 && a2 < 1090000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("IC|\u001dK^cDi");
        } else if (a2 >= 30000 && a2 < 50000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("s\u0017FI~\u0007_\u0014");
        } else if (a2 >= 1050000 && a2 < 1060000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#~c\\kQcSx");
        } else if (a2 >= 1610000 && a2 < 1660000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("s\u0017FI{\u0003U\u000eW\b_\u0005");
        } else if (a2 >= 1842000 && a2 < 1893000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("IC|\u001dA]bAxW~pmFx^i");
        } else if (a2 >= 1060000 && a2 < 1070000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("#G\u0016\u00196W\bB\u0015");
        } else if (a2 >= 1802000 && a2 < 1820000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#biFICy[|");
        } else if (a2 >= 1112000 && a2 < 1130000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("s\u0017FId\u000fX\u0001");
        } else if (a2 >= 1092000 && a2 < 1100000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#ad[i^h");
        } else if (a2 >= 1070000 && a2 < 1080000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("#G\u0016\u00195^\tS\u0015");
        } else if (a2 >= 1603000 && a2 < 1604000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("IC|\u001d_Ye^`Ag[b");
        } else if (a2 >= 1900000 && a2 < 2000000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("s\u0017FIb\u0007[\u000fX\u0001");
        } else if (a2 >= 1210000 && a2 < 1800000) {
            mapleData = a3.eqpStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("w}B#eiS|]b");
        } else if (a2 >= 1172000 && a2 < 1180000) {
            mapleData = a3.eqpStringData;
            string = string2 = CashShopOperation.ALLATORIxDEMO("#G\u0016\u0019+Y\bE\u0012S\u0014t\tY\r");
        } else if (a2 >= 4000000 && a2 < 5000000) {
            mapleData = a3.etcStringData;
            string = string2 = GZIPCompression.ALLATORIxDEMO("IFo");
        } else if (a2 >= 3000000 && a2 < 4000000) {
            mapleData = a3.insStringData;
            string = string2;
        } else if (a2 >= 5000000 && a2 < 5010000) {
            mapleData = a3.petStringData;
            string = string2;
        } else {
            return null;
        }
        if (string == null) {
            return mapleData.getChildByPath(String.valueOf(a2));
        }
        return mapleData.getChildByPath(string2 + "/" + a2);
    }

    public /* synthetic */ DumpItems(boolean a2, boolean a3) throws Exception {
        DumpItems a4;
        DumpItems dumpItems = a4;
        DumpItems dumpItems2 = a4;
        DumpItems dumpItems3 = a4;
        DumpItems dumpItems4 = a4;
        DumpItems dumpItems5 = a4;
        DumpItems dumpItems6 = a4;
        dumpItems5.B = MapleDataProviderFactory.getDataProvider(GZIPCompression.ALLATORIxDEMO("_F~[bU\"Ev"));
        dumpItems5.cashStringData = dumpItems6.B.getData(CashShopOperation.ALLATORIxDEMO("u\u0007E\u000e\u0018\u000f[\u0001"));
        dumpItems5.consumeStringData = dumpItems5.B.getData(GZIPCompression.ALLATORIxDEMO("O]bAy_i\u001ce_k"));
        dumpItems5.eqpStringData = dumpItems5.B.getData(CashShopOperation.ALLATORIxDEMO("#G\u0016\u0018\u000f[\u0001"));
        dumpItems5.etcStringData = dumpItems5.B.getData(GZIPCompression.ALLATORIxDEMO("IFo\u001ce_k"));
        dumpItems5.insStringData = dumpItems5.B.getData(CashShopOperation.ALLATORIxDEMO("/X\u0015\u0018\u000f[\u0001"));
        dumpItems4.petStringData = dumpItems5.B.getData(GZIPCompression.ALLATORIxDEMO("\\Wx\u001ce_k"));
        DumpItems dumpItems7 = a4;
        dumpItems4.doneIds = new LinkedHashSet<Integer>();
        dumpItems4.ALLATORIxDEMO = true;
        dumpItems3.hadError = false;
        dumpItems3.update = false;
        dumpItems2.OnlyItem = false;
        dumpItems2.id = 0;
        dumpItems.update = a2;
        dumpItems.OnlyItem = a3;
        a4.E = MapleDataProviderFactory.getDataProvider(CashShopOperation.ALLATORIxDEMO("/B\u0003[HA\u001c"));
        a4.g = MapleDataProviderFactory.getDataProvider(GZIPCompression.ALLATORIxDEMO("qdS~SoFi@\"Ev"));
        if (a4.E == null || a4.B == null || a4.g == null) {
            a4.hadError = true;
        }
    }

    public /* synthetic */ boolean isHadError() {
        DumpItems a2;
        return a2.hadError;
    }
}

