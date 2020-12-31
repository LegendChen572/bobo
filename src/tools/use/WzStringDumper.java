/*
 * Decompiled with CFR 0.150.
 */
package tools.use;

import handling.cashshop.handler.CashShopOperation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import provider.MapleData;
import provider.MapleDataProviderFactory;
import tools.data.ByteArrayByteStream;
import tools.wztosql.DumpItemsAdditions;

public class WzStringDumper {
    public /* synthetic */ WzStringDumper() {
        WzStringDumper a2;
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ void main(String[] a2) throws FileNotFoundException, IOException {
        Object object;
        Iterator<MapleData> iterator;
        Object object2;
        Object object3;
        System.out.println(CashShopOperation.ALLATORIxDEMO("l\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E<E\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0015l\u0015F\u0016F\u0016F\u0016F\u0016E\u0015F\u0015F\u0016F\u0015F\u0016F\u0016E\u0015F\u0015E\u0015F\u0015E\u0015F\u0015E\u0016F\u0015E\u0015F\u0016F\u0016F\u0016F\u0016E<E\u0016F\u0016F\u0016F\u0016E\u0016E\u0016E\u0016F\u0016E\u0016F\u0016E\u0016E\u0016F\u0015F\u0016E\u0016E\u0016E\u0016E\u0016F\u0015F\u0016F\u0016F\u0016F\u0016F\u0015l\u0015F\u0016F\u0016F\u0016F\u0015E\u0015F\u0015F\u0016F\u0015F\u0016F\u0015E\u0015F\u0016E\u0016F\u0015F\u0015F\u0015E\u0016F\u0016E\u0016F\u0016F\u0016F\u0016F\u0016E<E\u0016F\u0016F\u0016F\u0016E\u0016E\u0016E\u0015E\u0016E\u0015E\u0016E\u0016E\u0016F\u0015F\u0016E\u0015E\u0016E\u0016E\u0016E\u0015E\u0016F\u0016F\u0016F\u0016F\u0015l\u0015F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016E<E\u0016)T\u0000C\u0015U\u0007B\u000fY\b\u0016\u0004OFw\nZ\u0007B\tD\u000f\u0016)T\u0000C\u0015U\u0007B\tDF@Q\u0018U\u0016\"s+yF\u0015l\u0015F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016E<E\u0016F\u0016F\u0016F\u0016F\u0016F\u0016\u000eB\u0012F\\\u0019IA\u0011AHW\nZ\u0007B\tD\u000f\u0018\u0005Y\u000b\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0015l\u0015F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016F\u0016E<E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015E\u0015l"));
        Object object4 = MapleDataProviderFactory.fileInWZPath(ByteArrayByteStream.ALLATORIxDEMO("DYEDYJ\u0019ZM"));
        Object object5 = MapleDataProviderFactory.fileInWZPath(CashShopOperation.ALLATORIxDEMO("\u0003P\u0000S\u0005BHA\u001c"));
        object4 = MapleDataProviderFactory.getDataProvider((File)object4);
        object5 = MapleDataProviderFactory.getDataProvider((File)object5);
        Iterator<MapleData> iterator2 = object4;
        object4 = iterator2.getData(ByteArrayByteStream.ALLATORIxDEMO("nV^_\u0003^@P"));
        MapleData object62 = iterator2.getData(CashShopOperation.ALLATORIxDEMO("%Y\bE\u0013[\u0003\u0018\u000f[\u0001"));
        Object object6 = iterator2.getData(ByteArrayByteStream.ALLATORIxDEMO("r\\G\u0003^@P")).getChildByPath(CashShopOperation.ALLATORIxDEMO("#G\u0016"));
        MapleData mapleData = iterator2.getData(ByteArrayByteStream.ALLATORIxDEMO("rYT\u0003^@P")).getChildByPath(CashShopOperation.ALLATORIxDEMO("#B\u0005"));
        MapleData mapleData2 = iterator2.getData(ByteArrayByteStream.ALLATORIxDEMO("~CD\u0003^@P"));
        MapleData mapleData3 = iterator2.getData(CashShopOperation.ALLATORIxDEMO("6S\u0012\u0018\u000f[\u0001"));
        MapleData mapleData4 = iterator2.getData(ByteArrayByteStream.ALLATORIxDEMO("zLG\u0003^@P"));
        MapleData mapleData5 = iterator2.getData(CashShopOperation.ALLATORIxDEMO("+Y\u0004\u0018\u000f[\u0001"));
        MapleData mapleData6 = iterator2.getData(ByteArrayByteStream.ALLATORIxDEMO("dF^A[\u0003^@P"));
        MapleData mapleData7 = iterator2.getData(CashShopOperation.ALLATORIxDEMO("(F\u0005\u0018\u000f[\u0001"));
        object5 = object5.getData(ByteArrayByteStream.ALLATORIxDEMO("~RYrKQ\u0003^@P"));
        String string = a2 == null || a2.length == 0 ? CashShopOperation.ALLATORIxDEMO("\u007f\u0012S\u000br\u0007B\u0007") : a2[0];
        Object object7 = new File(string);
        Object object8 = new File(string + "\\\u7279\u6b8a.txt");
        Iterator<MapleData> iterator3 = new File(string + "\\\u6d88\u8017.txt");
        Object object9 = new File(string + "\\\u88dd\u5099\u5340");
        File file = new File(string + "\\\u5176\u4ed6.txt");
        File file2 = new File(string + "\\\u88dd\u98fe.txt");
        File file3 = new File(string + "\\\u5bf5\u7269.txt");
        File file4 = new File(string + "\\\u5730\u5716.txt");
        File file5 = new File(string + "\\\u602a\u7269.txt");
        File file6 = new File(string + "\\\u6280\u80fd.txt");
        File file7 = new File(string + "\\NPC.txt");
        File file8 = new File(string + "\\\u7279\u6548\u5957\u88dd.txt");
        File file9 = new File(string + "\\\u6f5b\u80fd\u88dd\u5099.txt");
        ((File)object7).mkdir();
        ((File)object8).createNewFile();
        ((File)((Object)iterator3)).createNewFile();
        ((File)object9).mkdir();
        file.createNewFile();
        file2.createNewFile();
        file3.createNewFile();
        file4.createNewFile();
        file5.createNewFile();
        file6.createNewFile();
        file7.createNewFile();
        file8.createNewFile();
        file9.createNewFile();
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("\u63e7\u53fb\u0017nV^_\u0003^@P\r\u654f\u64f7\u0019\u0003\u0019"));
        object7 = new PrintWriter(new FileOutputStream((File)object8));
        object4 = object4.getChildren().iterator();
        Iterator<MapleData> iterator4 = object4;
        while (iterator4.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("X\u0007[\u0003"));
            object3 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("IR^T"));
            object2 = "";
            iterator = CashShopOperation.ALLATORIxDEMO("N\u7117\u63a9\u8fc6O");
            if (object9 != null) {
                object2 = (String)object9.getData();
            }
            if (object3 != null) {
                iterator = (String)object3.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object2 + " - " + (String)((Object)iterator));
            iterator4 = object4;
        }
        Object object10 = object7;
        ((PrintWriter)object10).flush();
        ((PrintWriter)object10).close();
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("nV^_\u0003^@P\r\u63e7\u53fb\u5bbb\u623d\u0019"));
        System.out.println(CashShopOperation.ALLATORIxDEMO("\u63e6\u53b0\u0016%Y\bE\u0013[\u0003\u0018\u000f[\u0001\u0016\u651e\u64ecH\u0018H"));
        object7 = new PrintWriter(new FileOutputStream((File)((Object)iterator3)));
        Object object11 = object4 = object62.getChildren().iterator();
        while (object11.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("CV@R"));
            object3 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("R\u0003E\u0005"));
            object2 = "";
            iterator = ByteArrayByteStream.ALLATORIxDEMO("\u001f\u710c\u63f8\u8fdd\u001e");
            if (object9 != null) {
                object2 = (String)object9.getData();
            }
            if (object3 != null) {
                iterator = (String)object3.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object2 + " - " + (String)((Object)iterator));
            object11 = object4;
        }
        Object object12 = object7;
        ((PrintWriter)object12).flush();
        ((PrintWriter)object12).close();
        System.out.println(CashShopOperation.ALLATORIxDEMO("%Y\bE\u0013[\u0003\u0018\u000f[\u0001\u0016\u63b6\u53e0\u5bea\u6226H"));
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("\u63fd\u53e1\rr\\G\u0003^@P\r\u654f\u64f7\u0019\u0003\u0019"));
        Object object13 = object4 = object6.getChildren().iterator();
        while (object13.hasNext()) {
            object8 = object4.next();
            System.out.println("\u63d0\u53d6 " + object8.getName() + " \u6578\u64da...");
            object9 = new File(string + "\\\u88dd\u5099\u5340\\" + object8.getName() + ".txt");
            ((File)object9).createNewFile();
            object3 = new PrintWriter(new FileOutputStream((File)object9));
            try {
                Object object14 = object8.getChildren().iterator();
                while (object14.hasNext()) {
                    void var29_40;
                    iterator = (MapleData)object2.next();
                    MapleData mapleData8 = iterator.getChildByPath(CashShopOperation.ALLATORIxDEMO("X\u0007[\u0003"));
                    object6 = iterator.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("IR^T"));
                    iterator3 = "";
                    String string2 = CashShopOperation.ALLATORIxDEMO("N\u7117\u63a9\u8fc6O");
                    if (mapleData8 != null) {
                        iterator3 = String.valueOf(mapleData8.getData());
                    }
                    if (object6 != null) {
                        String string3 = (String)object6.getData();
                    }
                    ((PrintWriter)object3).println(iterator.getName() + " - " + (String)((Object)iterator3) + " - " + (String)var29_40);
                    object14 = object2;
                }
                ((PrintWriter)object3).flush();
                ((PrintWriter)object3).close();
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                try {
                    ((PrintWriter)object3).close();
                    throwable2 = throwable;
                }
                catch (Throwable throwable3) {
                    Throwable throwable4 = throwable;
                    throwable2 = throwable4;
                    throwable4.addSuppressed(throwable3);
                }
                throw throwable2;
            }
            System.out.println(object8.getName() + " \u63d0\u53d6\u5b8c\u6210.");
            object13 = object4;
        }
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("r\\G\u0003^@P\r\u63e7\u53fb\u5bbb\u623d\u0019"));
        System.out.println(CashShopOperation.ALLATORIxDEMO("\u63e6\u53b0\u0016#B\u0005\u0018\u000f[\u0001\u0016\u651e\u64ecH\u0018H"));
        object7 = new PrintWriter(new FileOutputStream(file));
        Object object15 = object4 = mapleData.getChildren().iterator();
        while (object15.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("CV@R"));
            object3 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("R\u0003E\u0005"));
            object2 = "";
            iterator = ByteArrayByteStream.ALLATORIxDEMO("\u001f\u710c\u63f8\u8fdd\u001e");
            if (object9 != null) {
                object2 = (String)object9.getData();
            }
            if (object3 != null) {
                iterator = (String)object3.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object2 + " - " + (String)((Object)iterator));
            object15 = object4;
        }
        Object object16 = object7;
        ((PrintWriter)object16).flush();
        ((PrintWriter)object16).close();
        System.out.println(CashShopOperation.ALLATORIxDEMO("#B\u0005\u0018\u000f[\u0001\u0016\u63b6\u53e0\u5bea\u6226H"));
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("\u63fd\u53e1\r~CD\u0003^@P\r\u654f\u64f7\u0019\u0003\u0019"));
        object7 = new PrintWriter(new FileOutputStream(file2));
        Object object17 = object4 = mapleData2.getChildren().iterator();
        while (object17.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("X\u0007[\u0003"));
            object3 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("IR^T"));
            object2 = "";
            iterator = CashShopOperation.ALLATORIxDEMO("N\u7117\u63a9\u8fc6O");
            if (object9 != null) {
                object2 = (String)object9.getData();
            }
            if (object3 != null) {
                iterator = (String)object3.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object2 + " - " + (String)((Object)iterator));
            object17 = object4;
        }
        Object object18 = object7;
        ((PrintWriter)object18).flush();
        ((PrintWriter)object18).close();
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("~CD\u0003^@P\r\u63e7\u53fb\u5bbb\u623d\u0019"));
        System.out.println(CashShopOperation.ALLATORIxDEMO("\u63e6\u53b0\u00166S\u0012\u0018\u000f[\u0001\u0016\u651e\u64ecH\u0018H"));
        object7 = new PrintWriter(new FileOutputStream(file3));
        Object object19 = object4 = mapleData3.getChildren().iterator();
        while (object19.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("CV@R"));
            object3 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("R\u0003E\u0005"));
            object2 = "";
            iterator = ByteArrayByteStream.ALLATORIxDEMO("\u001f\u710c\u63f8\u8fdd\u001e");
            if (object9 != null) {
                object2 = (String)object9.getData();
            }
            if (object3 != null) {
                iterator = (String)object3.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object2 + " - " + (String)((Object)iterator));
            object19 = object4;
        }
        Object object20 = object7;
        ((PrintWriter)object20).flush();
        ((PrintWriter)object20).close();
        System.out.println(CashShopOperation.ALLATORIxDEMO("6S\u0012\u0018\u000f[\u0001\u0016\u63b6\u53e0\u5bea\u6226H"));
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("\u63fd\u53e1\rzLG\u0003^@P\r\u654f\u64f7\u0019\u0003\u0019"));
        object7 = new PrintWriter(new FileOutputStream(file4));
        Object object21 = object4 = mapleData4.getChildren().iterator();
        while (object21.hasNext()) {
            object8 = object4.next();
            Object object22 = object7;
            Object object23 = object8;
            ((PrintWriter)object22).println(object23.getName());
            ((PrintWriter)object22).println();
            object9 = object23.getChildByPath(CashShopOperation.ALLATORIxDEMO("E\u0012D\u0003S\u0012x\u0007[\u0003"));
            object3 = object23.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("ZLGcV@R"));
            object2 = CashShopOperation.ALLATORIxDEMO("\u001e\u7147\u654e\u64bc\u543bO");
            iterator = ByteArrayByteStream.ALLATORIxDEMO("\u0005\u7116\u571d\u5721\u5420\u001e");
            if (object9 != null) {
                object2 = (String)object9.getData();
            }
            if (object3 != null) {
                iterator = (String)object3.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object2 + " - " + (String)((Object)iterator));
            object21 = object4;
            ((PrintWriter)object7).println();
        }
        Object object24 = object7;
        ((PrintWriter)object24).flush();
        ((PrintWriter)object24).close();
        System.out.println(CashShopOperation.ALLATORIxDEMO("+W\u0016\u0018\u000f[\u0001\u0016\u63b6\u53e0\u5bea\u6226H"));
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("\u63fd\u53e1\rzBU\u0003^@P\r\u654f\u64f7\u0019\u0003\u0019"));
        object7 = new PrintWriter(new FileOutputStream(file5));
        Object object25 = object4 = mapleData5.getChildren().iterator();
        while (object25.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("X\u0007[\u0003"));
            object3 = "";
            if (object9 != null) {
                object3 = (String)object9.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object3);
            object25 = object4;
        }
        Object object26 = object7;
        ((PrintWriter)object26).flush();
        ((PrintWriter)object26).close();
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("zBU\u0003^@P\r\u63e7\u53fb\u5bbb\u623d\u0019"));
        System.out.println(CashShopOperation.ALLATORIxDEMO("\u63e6\u53b0\u00165]\u000fZ\n\u0018\u000f[\u0001\u0016\u651e\u64ecH\u0018H"));
        object7 = new PrintWriter(new FileOutputStream(file6));
        object4 = mapleData6.getChildren().iterator();
        while (object4.hasNext()) {
            void var3_10;
            object8 = object4.next();
            object9 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("CV@R"));
            object3 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("R\u0003E\u0005"));
            object2 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("OXB\\cV@R"));
            iterator = "";
            String string4 = "";
            if (object9 != null) {
                iterator = (String)object9.getData();
            }
            if (object3 != null) {
                String string5 = (String)object3.getData();
            }
            if (object2 != null) continue;
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)((Object)iterator) + " - " + (String)var3_10);
        }
        Object object27 = object7;
        ((PrintWriter)object27).flush();
        ((PrintWriter)object27).close();
        System.out.println(CashShopOperation.ALLATORIxDEMO("5]\u000fZ\n\u0018\u000f[\u0001\u0016\u63b6\u53e0\u5bea\u6226H"));
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("\u63fd\u53e1\ry]T\u0003^@P\r\u654f\u64f7\u0019\u0003\u0019"));
        object7 = new PrintWriter(new FileOutputStream(file7));
        Object object28 = object4 = mapleData7.getChildren().iterator();
        while (object28.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("X\u0007[\u0003"));
            object3 = "";
            if (object9 != null) {
                object3 = (String)object9.getData();
            }
            ((PrintWriter)object7).println(object8.getName() + " - " + (String)object3);
            object28 = object4;
        }
        Object object29 = object7;
        ((PrintWriter)object29).flush();
        ((PrintWriter)object29).close();
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("y]T\u0003^@P\r\u63e7\u53fb\u5bbb\u623d\u0019"));
        object7 = new PrintWriter(new FileOutputStream(file8));
        System.out.println(CashShopOperation.ALLATORIxDEMO("\u63e6\u53b0\u0016#P\u0000S\u0005BIe\u0003B#P\u0000\u0018\u000f[\u0001\u0016\u651e\u64ecH\u0018H"));
        Object object30 = object4 = object5.getChildren().iterator();
        while (object30.hasNext()) {
            object8 = object4.next();
            object9 = object8.getChildByPath(ByteArrayByteStream.ALLATORIxDEMO("CV@R"));
            object3 = "";
            if (object9 != null) {
                object3 = (String)object9.getData();
            }
            ((PrintWriter)object7).print("\u5957\u88dd\u540d\u7a31:" + (String)object3 + "  \u7de8\u865f:" + object8.getName() + " \u5957\u88dd:");
            object2 = object8.getChildByPath(CashShopOperation.ALLATORIxDEMO("_\bP\t"));
            if (object2 != null) {
                for (MapleData mapleData9 : object2.getChildren()) {
                    object6 = "";
                    if (mapleData9 == null) continue;
                    MapleData mapleData10 = mapleData9;
                    object6 = mapleData10.getName();
                    for (MapleData mapleData11 : mapleData10.getChildren()) {
                        object5 = "";
                        if (mapleData11 == null) continue;
                        object5 = mapleData11.getData().toString();
                        ((PrintWriter)object7).print("[" + (String)object6 + " " + (String)object5 + "]");
                    }
                }
            }
            ((PrintWriter)object7).println(ByteArrayByteStream.ALLATORIxDEMO(" =\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a\u0000\u001a"));
            object30 = object4;
        }
        Object object31 = object7;
        ((PrintWriter)object31).flush();
        ((PrintWriter)object31).close();
        System.out.println(CashShopOperation.ALLATORIxDEMO("e\u0003B#P\u0000\u0018\u000f[\u0001\u0016\u63b6\u53e0\u5bea\u6226H"));
        object7 = new PrintWriter(new FileOutputStream(file9));
        try {
            object4 = null;
            object4 = new DumpItemsAdditions(false);
            ((PrintWriter)object7).println(((DumpItemsAdditions)object4).dumpAdditionItemData());
            object = object7;
        }
        catch (Exception exception) {
            Logger.getLogger(WzStringDumper.class.getName()).log(Level.SEVERE, null, exception);
            object = object7;
        }
        ((PrintWriter)object).flush();
        ((PrintWriter)object7).close();
        System.out.println(ByteArrayByteStream.ALLATORIxDEMO("tEV_VNCHE\u0003VISDCDXCVAD\r\u63e7\u53fb\u5bbb\u623d\u0019"));
    }
}

