/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package tools.wztosql;

import client.messages.commands.SkilledCommand;
import constants.GameSetConstants;
import constants.ItemConstants;
import handling.auction.handler.MTSOperation;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.MapleItemInformationProvider;
import server.life.ItemDropEntry;
import server.maps.MapleNodes;
import tools.StringTool;

/*
 * Exception performing whole class analysis ignored.
 */
public class DumpAllCashShop {
    private static /* synthetic */ Map<String, List<Integer>> ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean ALLATORIxDEMO(int a2) {
        switch (a2) {
            case 1112127: 
            case 1112918: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void TransferToSql() {
        for (Map.Entry<String, List<Integer>> entry : ALLATORIxDEMO.entrySet()) {
            String string = entry.getKey();
            int n2 = DumpAllCashShop.ALLATORIxDEMO(string);
            Iterator<Integer> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                Iterator<Integer> iterator2;
                int n3 = iterator2.next();
                System.out.println("\u7269\u54c1\u985e\u578b:" + string + " \u8ce6\u4e88SN:" + n2++ + " \u7269\u54c1\u540d\u7a31:" + MapleItemInformationProvider.getInstance().getName(n3) + " \u7269\u54c1ID:" + n3);
                iterator = iterator2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ int ALLATORIxDEMO(String a2) {
        int n2;
        int n3;
        block34: {
            n3 = -1;
            String string = a2;
            int n4 = -1;
            switch (string.hashCode()) {
                case 771251: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u5e46\u5b7b"))) break;
                    n2 = n4 = 0;
                    break block34;
                }
                case 0x105055: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u81c7\u98d2"))) break;
                    n2 = n4 = 1;
                    break block34;
                }
                case 985410: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u7747\u98d5"))) break;
                    n2 = n4 = 2;
                    break block34;
                }
                case 744038: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u5959\u88f1"))) break;
                    n2 = n4 = 3;
                    break block34;
                }
                case 654233: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u4e71\u8848"))) break;
                    n2 = n4 = 4;
                    break block34;
                }
                case 1123815: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u893c\u88f5"))) break;
                    n2 = n4 = 5;
                    break block34;
                }
                case 1226021: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u97f0\u5b7b"))) break;
                    n2 = n4 = 6;
                    break block34;
                }
                case 802924: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u6245\u597b"))) break;
                    n2 = n4 = 7;
                    break block34;
                }
                case 874434: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u6b1d\u5643"))) break;
                    n2 = n4 = 8;
                    break block34;
                }
                case 803637: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u621c\u632b"))) break;
                    n2 = n4 = 9;
                    break block34;
                }
                case 822109: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u62d0\u9883"))) break;
                    n2 = n4 = 10;
                    break block34;
                }
                case 1107293: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u8866\u60e9"))) break;
                    n2 = n4 = 11;
                    break block34;
                }
                case 934383: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u7202\u6563"))) break;
                    n2 = n4 = 12;
                    break block34;
                }
                case 759060: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u5bfb\u7245"))) break;
                    n2 = n4 = 13;
                    break block34;
                }
                case 23565897: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u5bde\u7212\u88f6"))) break;
                    n4 = 14;
                }
            }
            n2 = n4;
        }
        switch (n2) {
            case 0: {
                return 20000000;
            }
            case 1: {
                return 20100000;
            }
            case 2: {
                return 20200000;
            }
            case 3: {
                return 20300000;
            }
            case 4: {
                return 20400000;
            }
            case 5: {
                return 20500000;
            }
            case 6: {
                return 20600000;
            }
            case 7: {
                return 20700000;
            }
            case 8: {
                return 20800000;
            }
            case 9: {
                return 20900000;
            }
            case 10: {
                return 21100000;
            }
            case 11: {
                return 50100000;
            }
            case 12: {
                return 50500000;
            }
            case 13: {
                return 60000000;
            }
            case 14: {
                return 60100000;
            }
        }
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ int H(String a2) {
        int n2;
        int n3;
        block30: {
            n3 = 100;
            String string = a2;
            int n4 = -1;
            switch (string.hashCode()) {
                case 771251: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u5e33\u5b7c"))) break;
                    n2 = n4 = 0;
                    break block30;
                }
                case 0x105055: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u81b2\u98d5"))) break;
                    n2 = n4 = 1;
                    break block30;
                }
                case 985410: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u7732\u98d2"))) break;
                    n2 = n4 = 2;
                    break block30;
                }
                case 744038: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u592c\u88f6"))) break;
                    n2 = n4 = 3;
                    break block30;
                }
                case 654233: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u4e04\u884f"))) break;
                    n2 = n4 = 4;
                    break block30;
                }
                case 1123815: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u8949\u88f2"))) break;
                    n2 = n4 = 5;
                    break block30;
                }
                case 1226021: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u9785\u5b7c"))) break;
                    n2 = n4 = 6;
                    break block30;
                }
                case 802924: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u6230\u597c"))) break;
                    n2 = n4 = 7;
                    break block30;
                }
                case 874434: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u6b68\u5644"))) break;
                    n2 = n4 = 8;
                    break block30;
                }
                case 803637: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u6269\u632c"))) break;
                    n2 = n4 = 9;
                    break block30;
                }
                case 822109: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u62a5\u9884"))) break;
                    n2 = n4 = 10;
                    break block30;
                }
                case 759060: {
                    if (!string.equals(SkilledCommand.ALLATORIxDEMO("\u5b8e\u7242"))) break;
                    n2 = n4 = 11;
                    break block30;
                }
                case 23565897: {
                    if (!string.equals(MapleNodes.ALLATORIxDEMO("\u5bd9\u7267\u88f1"))) break;
                    n4 = 12;
                }
            }
            n2 = n4;
        }
        switch (n2) {
            case 0: {
                return 80;
            }
            case 1: {
                return 70;
            }
            case 2: {
                return 70;
            }
            case 3: {
                return 90;
            }
            case 4: {
                return 60;
            }
            case 5: {
                return 60;
            }
            case 6: {
                return 70;
            }
            case 7: {
                return 45;
            }
            case 8: {
                return 150;
            }
            case 9: {
                return 100;
            }
            case 10: {
                return 150;
            }
            case 11: {
                return 150;
            }
            case 12: {
                return 80;
            }
        }
        return n3;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void dumpItems() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 9[CATCHBLOCK]
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

    public static /* synthetic */ void getNormalCashEquip() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList5 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList6 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList7 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList8 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList9 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList10 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList11 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList12 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList13 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList14 = new ArrayList<Integer>();
        ArrayList<Integer> arrayList15 = new ArrayList<Integer>();
        for (int n2 : MapleItemInformationProvider.getInstance().getNormalCashEquip()) {
            if (DumpAllCashShop.ALLATORIxDEMO(n2)) continue;
            if (ItemConstants.\u985e\u578b.\u5e3d\u5b50((int)n2)) {
                arrayList.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u81c9\u98fe((int)n2)) {
                arrayList2.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u773c\u98fe((int)n2) || ItemConstants.\u985e\u578b.\u8033\u74b0((int)n2)) {
                arrayList3.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u5957\u670d((int)n2)) {
                arrayList4.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u4e0a\u8863((int)n2)) {
                arrayList5.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u8932\u88d9((int)n2)) {
                arrayList6.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u978b\u5b50((int)n2)) {
                arrayList7.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u624b\u5957((int)n2)) {
                arrayList8.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u6b66\u5668((int)n2) || ItemConstants.\u985e\u578b.\u76fe\u724c((int)n2)) {
                arrayList9.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u6212\u6307((int)n2)) {
                arrayList10.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u62ab\u98a8((int)n2)) {
                arrayList11.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u5bf5\u7269((int)n2)) {
                arrayList12.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u7279\u6548((int)n2) || ItemConstants.\u985e\u578b.\u98db\u93e2\u7279\u6548((int)n2)) {
                arrayList13.add(n2);
                continue;
            }
            if (ItemConstants.\u985e\u578b.\u5bf5\u7269\u88dd((int)n2)) {
                arrayList14.add(n2);
                continue;
            }
            if (!ItemConstants.\u985e\u578b.\u8868\u60c5((int)n2)) continue;
            arrayList15.add(n2);
        }
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u5e33\u5b7c"), arrayList);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u81b2\u98d5"), arrayList2);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u7732\u98d2"), arrayList3);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u592c\u88f6"), arrayList4);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u4e04\u884f"), arrayList5);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u8949\u88f2"), arrayList6);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u9785\u5b7c"), arrayList7);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u6230\u597c"), arrayList8);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u6b68\u5644"), arrayList9);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u6269\u632c"), arrayList10);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u62a5\u9884"), arrayList11);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u5b8e\u7242"), arrayList12);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u7277\u6564"), arrayList13);
        ALLATORIxDEMO.put(SkilledCommand.ALLATORIxDEMO("\u5bde\u7212\u88f6"), arrayList14);
        ALLATORIxDEMO.put(MapleNodes.ALLATORIxDEMO("\u8866\u60e9"), arrayList15);
    }

    public /* synthetic */ DumpAllCashShop() {
        DumpAllCashShop a2;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new LinkedHashMap<String, List<Integer>>();
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void delete(String a) throws Exception {
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

    public static /* synthetic */ void main() {
        DumpAllCashShop.getNormalCashEquip();
        System.out.println(SkilledCommand.ALLATORIxDEMO("\u8f72\u514e\u623b\u6722\u9ea5\u88f6\u4e5d\u522d\u9825\u623b\u52e4\n"));
        DumpAllCashShop.dumpItems();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void addbatch(PreparedStatement a2) {
        Iterator<Map.Entry<String, List<Integer>>> iterator = ALLATORIxDEMO.entrySet().iterator();
        while (iterator.hasNext()) {
            int n2;
            String string;
            Map.Entry<String, List<Integer>> entry = iterator.next();
            String string2 = string = entry.getKey();
            int n3 = n2 = DumpAllCashShop.ALLATORIxDEMO(string2);
            n2 = 0;
            int n4 = 0;
            DumpAllCashShop.delete(string2);
            Iterator<Integer> iterator2 = entry.getValue().iterator();
            block7: while (true) {
                Iterator<Integer> iterator3 = iterator2;
                while (iterator3.hasNext()) {
                    int n5 = iterator2.next();
                    String string3 = "";
                    if (MapleItemInformationProvider.getInstance().getName(n5) != null) {
                        string3 = MapleItemInformationProvider.getInstance().getName(n5);
                    }
                    if (!StringTool.ValidString(string3)) {
                        string3 = MapleNodes.ALLATORIxDEMO("\u97dd\u65ab\u88d3\u50b5");
                    }
                    if (GameSetConstants.SERVER_NAME.equals(SkilledCommand.ALLATORIxDEMO("\u4e79\u4e28\u8c1c")) && string3.isEmpty()) {
                        string3 = MapleNodes.ALLATORIxDEMO("\u6c9c\u6725\u5403\u7a1d");
                    }
                    if (string3.isEmpty()) {
                        iterator3 = iterator2;
                        ++n4;
                        continue;
                    }
                    ++n2;
                    PreparedStatement preparedStatement = a2;
                    PreparedStatement preparedStatement2 = a2;
                    preparedStatement2.setInt(1, n3);
                    preparedStatement2.setString(2, string3);
                    preparedStatement.setInt(3, DumpAllCashShop.H(string));
                    preparedStatement.setInt(4, n5);
                    preparedStatement.execute();
                    ++n3;
                    continue block7;
                }
                break;
            }
            System.out.println("\u5546\u57ce \u7269\u54c1\u985e\u578b:" + string + " \u65b0\u589e\u6578\u91cf:" + n2 + " \u5df2\u6392\u9664\u7121\u540d\u7a31\u9ede\u88dd: " + n4 + " \u500b");
            {
                catch (Exception exception) {
                    Logger.getLogger(DumpAllCashShop.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    public static final class CashType
    extends Enum<CashType> {
        public static final /* synthetic */ /* enum */ CashType \u8932\u88d9;
        public static final /* synthetic */ /* enum */ CashType \u81c9\u98fe;
        public static final /* synthetic */ /* enum */ CashType \u5e3d\u5b50;
        public static final /* synthetic */ /* enum */ CashType \u773c\u98fe;
        public static final /* synthetic */ /* enum */ CashType \u624b\u5957;
        public static final /* synthetic */ /* enum */ CashType \u978b\u5b50;
        public static final /* synthetic */ /* enum */ CashType \u4e0a\u8863;
        public static final /* synthetic */ /* enum */ CashType \u6b66\u5668;
        private static final /* synthetic */ CashType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ CashType \u6212\u6307;
        public static final /* synthetic */ /* enum */ CashType \u5bf5\u7269;
        public static final /* synthetic */ /* enum */ CashType \u5957\u88dd;
        public final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ CashType \u62ab\u98a8;

        public static /* synthetic */ CashType[] values() {
            return (CashType[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ CashType getById(int a2) {
            int n2;
            CashType[] arrcashType = CashType.values();
            int n3 = arrcashType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                CashType cashType = arrcashType[n2];
                if (cashType.getId() == a2) {
                    return cashType;
                }
                n4 = ++n2;
            }
            return null;
        }

        public /* synthetic */ int getId() {
            CashType a2;
            return a2.d;
        }

        public static /* synthetic */ {
            \u5e3d\u5b50 = new CashType(MTSOperation.ALLATORIxDEMO("\u5e71\u5b73"), 0, 20000000);
            \u81c9\u98fe = new CashType(ItemDropEntry.ALLATORIxDEMO("\u81c4\u98e4"), 1, 20100000);
            \u773c\u98fe = new CashType(MTSOperation.ALLATORIxDEMO("\u7770\u98dd"), 2, 20200000);
            \u5957\u88dd = new CashType(ItemDropEntry.ALLATORIxDEMO("\u595a\u88c7"), 3, 20300000);
            \u4e0a\u8863 = new CashType(MTSOperation.ALLATORIxDEMO("\u4e46\u8840"), 4, 20400000);
            \u8932\u88d9 = new CashType(ItemDropEntry.ALLATORIxDEMO("\u893f\u88c3"), 5, 20500000);
            \u978b\u5b50 = new CashType(MTSOperation.ALLATORIxDEMO("\u97c7\u5b73"), 6, 20600000);
            \u624b\u5957 = new CashType(ItemDropEntry.ALLATORIxDEMO("\u6246\u594d"), 7, 20700000);
            \u6b66\u5668 = new CashType(MTSOperation.ALLATORIxDEMO("\u6b2a\u564b"), 8, 20800000);
            \u6212\u6307 = new CashType(ItemDropEntry.ALLATORIxDEMO("\u621f\u631d"), 9, 20900000);
            \u62ab\u98a8 = new CashType(MTSOperation.ALLATORIxDEMO("\u62e7\u988b"), 10, 21100000);
            \u5bf5\u7269 = new CashType(ItemDropEntry.ALLATORIxDEMO("\u5bf8\u7273"), 11, 60000000);
            CashType[] arrcashType = new CashType[12];
            arrcashType[0] = \u5e3d\u5b50;
            arrcashType[1] = \u81c9\u98fe;
            arrcashType[2] = \u773c\u98fe;
            arrcashType[3] = \u5957\u88dd;
            arrcashType[4] = \u4e0a\u8863;
            arrcashType[5] = \u8932\u88d9;
            arrcashType[6] = \u978b\u5b50;
            arrcashType[7] = \u624b\u5957;
            arrcashType[8] = \u6b66\u5668;
            arrcashType[9] = \u6212\u6307;
            arrcashType[10] = \u62ab\u98a8;
            arrcashType[11] = \u5bf5\u7269;
            ALLATORIxDEMO = arrcashType;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ CashType(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            CashType a3;
            a3.d = a2;
        }

        public static /* synthetic */ CashType valueOf(String a2) {
            return Enum.valueOf(CashType.class, a2);
        }
    }
}

