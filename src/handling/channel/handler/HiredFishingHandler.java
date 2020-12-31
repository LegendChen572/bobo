/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import database.DBConPool;
import handling.world.World;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.MapleInventoryManipulator;
import server.MerchItemPackage;
import server.shops.HiredFishing;
import tools.FileoutputUtil;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.PlayerShopPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class HiredFishingHandler {
    /*
     * Exception decompiling
     */
    private static final /* synthetic */ boolean ALLATORIxDEMO(int a, int a, int a) {
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

    /*
     * Exception decompiling
     */
    private static /* synthetic */ byte ALLATORIxDEMO(int a, int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean ALLATORIxDEMO(MapleCharacter a2, MerchItemPackage a3) {
        if (a2.getMeso() + ((MerchItemPackage)((Object)a3)).getMesos() < 0) {
            return false;
        }
        byte by = 0;
        byte by2 = 0;
        byte by3 = 0;
        byte by4 = 0;
        byte by5 = 0;
        a3 = ((MerchItemPackage)((Object)a3)).getItems().iterator();
        block7: while (true) {
            Iterator<IItem> iterator = a3;
            block8: while (iterator.hasNext()) {
                MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a3.next().getItemId());
                if (null == mapleInventoryType) continue block7;
                switch (1.ALLATORIxDEMO[mapleInventoryType.ordinal()]) {
                    case 1: {
                        by = (byte)(by + 1);
                        iterator = a3;
                        continue block8;
                    }
                    case 2: {
                        by2 = (byte)(by2 + 1);
                        iterator = a3;
                        continue block8;
                    }
                    case 3: {
                        by3 = (byte)(by3 + 1);
                        iterator = a3;
                        continue block8;
                    }
                    case 4: {
                        by4 = (byte)(by4 + 1);
                        iterator = a3;
                        continue block8;
                    }
                    case 5: {
                        by5 = (byte)(by5 + 1);
                        iterator = a3;
                        continue block8;
                    }
                }
                continue block7;
            }
            break;
        }
        if (a2.getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() <= by) {
            a2.dropMessage(-1, "\u88dd\u5099\u6b04\u4f4d\u9700\u8981" + by + "\u683c\u624d\u80fd\u9818\u53d6\u5594");
            return false;
        }
        if (a2.getInventory(MapleInventoryType.USE).getNumFreeSlot() <= by2) {
            a2.dropMessage(-1, "\u6d88\u8017\u6b04\u4f4d\u9700\u8981" + by2 + "\u683c\u624d\u80fd\u9818\u53d6\u5594");
            return false;
        }
        if (a2.getInventory(MapleInventoryType.SETUP).getNumFreeSlot() <= by3) {
            a2.dropMessage(-1, "\u88dd\u98fe\u6b04\u4f4d\u9700\u8981" + by3 + "\u683c\u624d\u80fd\u9818\u53d6\u5594");
            return false;
        }
        if (a2.getInventory(MapleInventoryType.ETC).getNumFreeSlot() <= by4) {
            a2.dropMessage(-1, "\u5176\u4ed6\u6b04\u4f4d\u9700\u8981" + by4 + "\u683c\u624d\u80fd\u9818\u53d6\u5594");
            return false;
        }
        if (a2.getInventory(MapleInventoryType.CASH).getNumFreeSlot() <= by5) {
            a2.dropMessage(-1, "\u7279\u6b8a\u6b04\u4f4d\u9700\u8981" + by5 + "\u683c\u624d\u80fd\u9818\u53d6\u5594");
            return false;
        }
        return true;
    }

    public static final /* synthetic */ void OpenFishingItemStore(MapleClient a2) {
        MapleClient mapleClient;
        if (World.hasFishing(a2.getPlayer().getAccountID()) != null) {
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().dropMessage(1, \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u8aaa\u95c5\u95e8\u91fa\u9b3b\u5c16\u7cdf\u9751\u5fed\u5731\u8a07\u4e19\u6b407"));
            mapleClient2.getPlayer().setConversation(0);
            return;
        }
        MerchItemPackage merchItemPackage = HiredFishingHandler.loadItemFrom_Database(a2.getPlayer().getId(), a2.getPlayer().getAccountID(), a2.getWorld());
        if (merchItemPackage == null) {
            MapleClient mapleClient3 = a2;
            mapleClient3.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u4f31\u6ca6\u6758\u571c\u9048\u90be\u7f3f\u650a\u9002\u5143p"));
            mapleClient3.getPlayer().setConversation(0);
            return;
        }
        if (merchItemPackage.getItems().size() <= 0) {
            MapleClient mapleClient4;
            if (!HiredFishingHandler.ALLATORIxDEMO(a2.getPlayer(), merchItemPackage)) {
                MapleClient mapleClient5 = a2;
                mapleClient5.getPlayer().dropMessage(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u8ad2\u5129\u78a3\u8aec\u6636\u5447\u6710\u8dd2\u5939\u6b65\u4f54\u9879\u53cf\u88ca\u4fc4\u7bc0\u769d\u9032\u516e"));
                mapleClient5.getPlayer().setConversation(0);
                return;
            }
            MapleClient mapleClient6 = a2;
            if (HiredFishingHandler.ALLATORIxDEMO(a2.getPlayer().getId(), a2.getPlayer().getAccountID(), merchItemPackage.getPackageid())) {
                mapleClient6.getPlayer().gainMeso(merchItemPackage.getMesos(), false);
                a2.getPlayer().dropMessage("\u6211\u5e6b\u4f60\u4fdd\u7ba1\u4e86\u4e00\u4e9b\u9053\u5177\uff0c\u4e0b\u6b21\u4e5f\u8981\u8a18\u5f97\u4f86\u9818\u53d6\uff0c\u795d\u4f60\u904a\u6232\u6109\u5feb.\u6210\u529f\u9818\u53d6\u6953\u5e63" + merchItemPackage.getMesos());
                mapleClient4 = a2;
            } else {
                mapleClient6.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0010ZqA?_?[&ZqQ#F>Fq[2W$F4P\u007f"));
                mapleClient4 = a2;
            }
            mapleClient4.getPlayer().setConversation(0);
            return;
        }
        if (!HiredFishingHandler.ALLATORIxDEMO(a2.getPlayer(), merchItemPackage)) {
            MapleClient mapleClient7 = a2;
            mapleClient7.getPlayer().dropMessage(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u8ad2\u5129\u78a3\u8aec\u6636\u5447\u6710\u8dd2\u5939\u6b65\u4f54\u9879\u53cf\u88ca\u4fc4\u7bc0\u769d\u9032\u516e"));
            mapleClient7.getPlayer().setConversation(0);
            return;
        }
        if (HiredFishingHandler.ALLATORIxDEMO(a2.getPlayer().getId(), a2.getPlayer().getAccountID(), merchItemPackage.getPackageid())) {
            Iterator<IItem> iterator;
            MerchItemPackage merchItemPackage2 = merchItemPackage;
            a2.getPlayer().gainMeso(merchItemPackage2.getMesos(), false);
            Iterator<IItem> iterator2 = iterator = merchItemPackage2.getItems().iterator();
            while (iterator2.hasNext()) {
                IItem iItem = iterator.next();
                iterator2 = iterator;
                MapleInventoryManipulator.addFromDrop(a2, iItem, true);
            }
            a2.getPlayer().dropMessage("\u6211\u5e6b\u4f60\u4fdd\u7ba1\u4e86\u4e00\u4e9b\u9053\u5177\uff0c\u4e0b\u6b21\u4e5f\u8981\u8a18\u5f97\u4f86\u9818\u53d6\uff0c\u795d\u4f60\u904a\u6232\u6109\u5feb.\u6210\u529f\u9818\u53d6\u6953\u5e63" + merchItemPackage.getMesos());
            mapleClient = a2;
        } else {
            MapleClient mapleClient8 = a2;
            mapleClient = mapleClient8;
            mapleClient8.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0010ZqA?_?[&ZqQ#F>Fq[2W$F4P\u007f"));
        }
        mapleClient.getPlayer().setConversation(0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void UseHiredFishing(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().getMapId() >= 749050500 && a3.getPlayer().getMapId() <= 749050502) {
            switch (HiredFishingHandler.ALLATORIxDEMO(a3.getPlayer().getAccountID(), a3.getPlayer().getId(), a3.getWorld())) {
                case 1: {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u8aaa\u5151\u53da\u6267\u5bad\u8634\u5fd6\u91d5\u9879\u53cf\u4f01\u4e52\u522c\u6259\u9182\u769d\u6710\u8966"));
                    mapleClient.getPlayer().setConversation(0);
                    return;
                }
                case 0: {
                    HiredFishing hiredFishing = World.hasFishing(a3.getPlayer().getAccountID());
                    if (hiredFishing == null) {
                        a3.sendPacket(PlayerShopPacket.sendFishBox());
                        return;
                    }
                    if (hiredFishing == null) {
                        a3.getPlayer().dropMessage(1, \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"X\u000f9\u0014w\nw\u000en\u000f9\u0004k\u0013v\u00139\u000ez\u0002l\u0013|\u00057"));
                        return;
                    }
                    if (hiredFishing.isOwner(a3.getPlayer())) {
                        a3.sendPacket(PlayerShopPacket.closeHiredFishing(hiredFishing));
                        return;
                    }
                    if (hiredFishing == null) {
                        a3.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u622f\u4e39\u5261\u609c\u76d5\u7c8a\u9719\u91d7\u621a"));
                    }
                    return;
                }
            }
            a3.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0010ZqA?_?[&ZqQ#F>Fq[2W$F4P\u007f"));
            return;
        }
        a3.getSession().close();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ MerchItemPackage loadItemFrom_Database(int a2, int a3, int a422) {
        DruidPooledConnection druidPooledConnection;
        MerchItemPackage merchItemPackage;
        Object a422;
        PreparedStatement preparedStatement;
        DruidPooledConnection druidPooledConnection2;
        block20: {
            MerchItemPackage merchItemPackage2;
            block22: {
                try {
                    block21: {
                        druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                        preparedStatement = druidPooledConnection2.prepareStatement(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"g\u0014x\u0014w\u0005\u0014{\u00147F>Yq\\8F4P7]\"\\8Z6\u0014&\\4F4\u00142\\0F0W%Q#]5\u0014l\u0014n\u00140Z5\u0014&[#X5\u0014l\u0014n"));
                        try {
                            PreparedStatement preparedStatement2 = preparedStatement;
                            preparedStatement2.setInt(1, a2);
                            preparedStatement2.setInt(2, a422);
                            a422 = preparedStatement.executeQuery();
                            if (a422.next()) break block20;
                            preparedStatement.close();
                            a422.close();
                            merchItemPackage2 = null;
                            if (preparedStatement == null) break block21;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            if (preparedStatement != null) {
                                try {
                                    preparedStatement.close();
                                    throwable2 = throwable;
                                    throw throwable2;
                                }
                                catch (Throwable a422) {
                                    throwable.addSuppressed(a422);
                                }
                            }
                            throwable2 = throwable;
                            throw throwable2;
                        }
                        preparedStatement.close();
                    }
                    if (druidPooledConnection2 == null) return merchItemPackage2;
                    break block22;
                }
                catch (SQLException sQLException) {
                    System.err.println("\u7cbe\u9748\u5c0f\u91e3\u624b\u932f\u8aa4: " + sQLException);
                    FileoutputUtil.printError(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0019]#Q5r8G9]?S\u0019U?P=Q#\u001a%L%"), sQLException, " \u73a9\u5bb6\u7de8\u865f: " + a2 + " \u5e33\u865f\u7de8\u865f: " + a3);
                    return null;
                }
                catch (Throwable throwable) {
                    Throwable throwable3;
                    if (druidPooledConnection2 != null) {
                        try {
                            druidPooledConnection2.close();
                            throwable3 = throwable;
                            throw throwable3;
                        }
                        catch (Throwable throwable4) {
                            throwable.addSuppressed(throwable4);
                        }
                    }
                    throwable3 = throwable;
                    throw throwable3;
                }
            }
            druidPooledConnection2.close();
            return merchItemPackage2;
        }
        ResultSet resultSet = a422;
        int n2 = resultSet.getInt(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"I\u0000z\nx\u0006|(}"));
        MerchItemPackage merchItemPackage3 = merchItemPackage = new MerchItemPackage();
        merchItemPackage.setPackageid(n2);
        merchItemPackage3.setMesos(a422.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"<Q\"[\"")));
        merchItemPackage3.setSentTime(a422.getLong(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0015p\f|")));
        resultSet.close();
        Integer[] arrinteger = new Integer[1];
        arrinteger[0] = n2;
        Map<Long, Pair<IItem, MapleInventoryType>> map = ItemLoader.HIRED_FISHING.loadItems(false, arrinteger);
        if (map != null) {
            Iterator<Pair<IItem, MapleInventoryType>> iterator;
            a422 = new ArrayList();
            Iterator<Pair<IItem, MapleInventoryType>> iterator2 = iterator = map.values().iterator();
            while (iterator2.hasNext()) {
                Pair<IItem, MapleInventoryType> pair = iterator.next();
                a422.add((IItem)pair.left);
                iterator2 = iterator;
            }
            {
                merchItemPackage.setItems((List<IItem>)a422);
            }
        }
        if (preparedStatement != null) {
            druidPooledConnection = druidPooledConnection2;
            preparedStatement.close();
        } else {
            druidPooledConnection = druidPooledConnection2;
        }
        if (druidPooledConnection == null) return merchItemPackage;
        druidPooledConnection2.close();
        return merchItemPackage;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void FishingItemStore(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer() == null) {
            return;
        }
        switch (a2.readByte()) {
            case 20: {
                Iterator<IItem> iterator;
                String string = a2.readMapleAsciiString();
                if (a3.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5bad\u8634\u5fd6\u91d5\u5ba7\u78a5\u8f59\u517c")));
                }
                if (a3.getSecondPassword() != null) {
                    if (string == null) {
                        a3.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u8aff\u8f69\u5151\u5b97\u7888\u3053"));
                        return;
                    }
                    if (!a3.check2ndPassword(string)) {
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().dropMessage(1, \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5bdf\u78dd\u9336\u8ac5\u301b"));
                        mapleClient.getPlayer().setConversation(0);
                        if (!mapleClient.isMonitored()) return;
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5bf8\u867c\u5f83\u919d\u5bf2\u78ed\u8f0c\u5134\u931b\u8af5")));
                        return;
                    }
                }
                MapleClient mapleClient = a3;
                int n2 = mapleClient.getPlayer().getConversation();
                boolean bl = World.hasMerchant(mapleClient.getPlayer().getAccountID());
                if (mapleClient.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5bad\u8634\u5fd6\u91d5\u5ba7\u78a5\u8f59\u517c\u5bed\u757b\u9053\u517c\u7cdf\u9751\u5527\u4ea3\u5068\u5eb2")));
                }
                if (bl) {
                    MapleClient mapleClient2 = a3;
                    mapleClient2.sendPacket(PlayerShopPacket.ShowMerchItemStore(9030000, World.getMerchantMap(mapleClient2.getPlayer()), World.getMerchantChannel(a3.getPlayer())));
                    mapleClient2.getPlayer().setConversation(0);
                    return;
                }
                if (n2 != 6) return;
                MerchItemPackage merchItemPackage = HiredFishingHandler.loadItemFrom_Database(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), a3.getPlayer().getWorld());
                MapleClient mapleClient3 = a3;
                if (merchItemPackage == null) {
                    mapleClient3.sendPacket(PlayerShopPacket.fishingItemStore((byte)37));
                    a3.getPlayer().setConversation(0);
                    return;
                }
                if (mapleClient3.getPlayer().getMeso() + merchItemPackage.getMesos() >= Integer.MAX_VALUE) {
                    MapleClient mapleClient4 = a3;
                    mapleClient4.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u609c\u76d5\u9316\u9849\u53e2\u901f\u5fb8\u5c56\u6737\u901f\u592e\uff5d\u8aff\u5119\u5c33\u594b\u992c\u76d5\u9316\u656f\u7f5a\u5058\u5e9fp"));
                    mapleClient4.getPlayer().setConversation(0);
                    return;
                }
                if (!merchItemPackage.getItems().isEmpty()) {
                    a3.sendPacket(PlayerShopPacket.fishingItemStore_ItemData(merchItemPackage));
                    return;
                }
                if (!HiredFishingHandler.ALLATORIxDEMO(a3.getPlayer(), merchItemPackage)) {
                    a3.sendPacket(PlayerShopPacket.merchItem_Message((byte)33));
                    return;
                }
                MapleClient mapleClient5 = a3;
                if (HiredFishingHandler.ALLATORIxDEMO(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), merchItemPackage.getPackageid())) {
                    mapleClient5.getPlayer().gainMeso(merchItemPackage.getMesos(), true);
                    a3.getPlayer().dropMessage(1, "\u4f60\u5df2\u7d93\u5f9e\u7cbe\u9748\u5546\u4eba\u9818\u53d6\u4e86" + merchItemPackage.getMesos() + "\u6953\u5e63");
                    a3.getPlayer().setConversation(0);
                } else {
                    mapleClient5.getPlayer().dropMessage(1, \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u761d\u7506\u674b\u77fc\u76e5\u9336\u8ac57"));
                }
                Object object = "";
                Iterator<IItem> iterator2 = iterator = merchItemPackage.getItems().iterator();
                while (true) {
                    if (!iterator2.hasNext()) {
                        a3.getPlayer().setConversation(0);
                        return;
                    }
                    IItem iItem = iterator.next();
                    object = (String)object + iItem.getItemId() + "(" + iItem.getQuantity() + "), ";
                    iterator2 = iterator;
                }
            }
            case 25: {
                if (a3.getPlayer().getConversation() != 6) {
                    return;
                }
                a3.sendPacket(PlayerShopPacket.merchItemStore((byte)36));
                return;
            }
            case 26: {
                Iterator<IItem> iterator;
                if (a3.getPlayer().getConversation() != 6) {
                    return;
                }
                MerchItemPackage merchItemPackage = HiredFishingHandler.loadItemFrom_Database(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), a3.getWorld());
                if (merchItemPackage == null) {
                    a3.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0010ZqA?_?[&ZqQ#F>Fq[2W$F4P\u007f"));
                    return;
                }
                if (!HiredFishingHandler.ALLATORIxDEMO(a3.getPlayer(), merchItemPackage)) {
                    a3.sendPacket(PlayerShopPacket.merchItem_Message((byte)33));
                    return;
                }
                if (!HiredFishingHandler.ALLATORIxDEMO(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), merchItemPackage.getPackageid())) {
                    a3.getPlayer().dropMessage(1, \u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"X\u000f9\u0014w\nw\u000en\u000f9\u0004k\u0013v\u00139\u000ez\u0002l\u0013|\u00057"));
                    return;
                }
                MerchItemPackage merchItemPackage2 = merchItemPackage;
                a3.getPlayer().gainMeso(merchItemPackage2.getMesos(), false);
                Iterator<IItem> iterator3 = iterator = merchItemPackage2.getItems().iterator();
                while (true) {
                    if (!iterator3.hasNext()) {
                        a3.sendPacket(PlayerShopPacket.merchItem_Message((byte)29));
                        return;
                    }
                    IItem iItem = iterator.next();
                    iterator3 = iterator;
                    MapleInventoryManipulator.addFromDrop(a3, iItem, false);
                }
            }
            case 27: {
                a3.getPlayer().setConversation(0);
                return;
            }
        }
    }

    public /* synthetic */ HiredFishingHandler() {
        HiredFishingHandler a2;
    }
}

