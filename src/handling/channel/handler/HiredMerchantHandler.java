/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleCoolDownValueHolder;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ServerConfig;
import constants.ServerTempStorage;
import handling.world.World;
import java.util.Iterator;
import java.util.List;
import server.MapleInventoryManipulator;
import server.MerchItemPackage;
import server.shops.HiredMerchant;
import server.shops.MaplePlayerShopItem;
import tools.ConcurrentEnumMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.PlayerShopPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class HiredMerchantHandler {
    public static final /* synthetic */ byte \u5bcc\u862d\u5fb7\u91cc\u6aa2\u67e5\u5bc6\u78bc = 20;
    public static final /* synthetic */ byte \u5efa\u7acb\u7cbe\u9748\u5546\u4eba = 0;
    public static final /* synthetic */ byte \u5bcc\u862d\u5fb7\u91cc\u9ede\u9078\u5168\u90e8\u9818\u56de = 25;
    public static final /* synthetic */ byte \u5bcc\u862d\u5fb7\u91cc\u5168\u90e8\u9818\u56de = 26;
    public static final /* synthetic */ byte \u5bcc\u862d\u5fb7\u91cc\u9ede\u9078\u96e2\u958b = 27;
    public static final /* synthetic */ byte \u958b\u555f\u7cbe\u9748\u5546\u4eba = 1;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = 1 << 3 ^ (3 ^ 5);
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ byte checkExistance(int a, int a) {
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
     * Exception decompiling
     */
    public static /* synthetic */ MerchItemPackage loadItemFromDatabase(int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 5[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    public static /* synthetic */ void displayMerch(MapleClient a2) {
    }

    public static /* synthetic */ void ClearWorldMerchant(MapleCharacter a2) {
        HiredMerchant hiredMerchant = World.getMerchant(a2.getAccountID());
        if (hiredMerchant != null && hiredMerchant.getShopType() == 1 && hiredMerchant.isOwner(a2) && hiredMerchant.isAvailable()) {
            if (ServerConfig.LOG_MERCHANT) {
                Object object = "";
                Iterator<MaplePlayerShopItem> iterator = hiredMerchant.getItems().iterator();
                while (iterator.hasNext()) {
                    IItem iItem = iterator.next().item;
                    if (iItem == null) continue;
                    object = (String)object + iItem.getItemName() + "(" + iItem.getItemId() + ")";
                    if (iItem.getEquipOnlyId() > 0L) {
                        object = (String)object + "\u552f\u4e00ID:" + iItem.getEquipOnlyId();
                    }
                    object = (String)object + ", ";
                }
                FileoutputUtil.logToFile(MapleCoolDownValueHolder.ALLATORIxDEMO("O4D(\f\u001fB/Bt\u7c9d\u9713\u5565\u4ee1|\u752b\u5e1b\u9587\u95aauW#W"), "\r\n" + FileoutputUtil.CurrentReadable_Time() + " " + a2.getClient().getSessionIPAddress() + " \u73a9\u5bb6 " + a2.getName() + " \u7cbe\u9748\u5546\u4eba\u95dc\u9589, \u6953\u5e63[" + hiredMerchant.getMeso() + "]\u7269\u54c1[" + (String)object + "]\r\n");
            }
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.getClient().sendPacket(PlayerShopPacket.closeMerchantUI());
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
            hiredMerchant.removeAllVisitors(-1, -1);
            a2.setPlayerShop(null);
            hiredMerchant.closeShop(true, true);
            if (ServerTempStorage.getMerchant(a2)) {
                ServerTempStorage.setMerchant(a2, false);
            }
            if (a2.getClient().isMonitored()) {
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a2.getChrInfo(ConcurrentEnumMap.ALLATORIxDEMO("\u95b2\u95d0\u7cd0\u9711\u5528\u4ee3F\u7ce7\u9726\u551f\u4ed4\u0006\u751e\u5e61\u95b2\u95d0G")));
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void MerchantItemStore(LittleEndianAccessor a2, MapleClient a3) {
        byte by;
        if (a3.getPlayer() == null) {
            return;
        }
        byte by2 = a2.readByte();
        if (GameSetConstants.MAPLE_VERSION == 75) {
            by = by2 = (byte)(by2 + 3);
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 147 && (by2 = (byte)(by2 - 1)) == 28) {
                by2 = (byte)(by2 - 1);
            }
            by = by2;
        }
        switch (by) {
            case 20: {
                Iterator<IItem> iterator;
                if (a3.getPlayer().getMapId() != 910000000) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u8aa5\u81aa\u8184\u7568\u5e6c\u586d\u510b\u53ba\u306c"));
                    mapleClient.getPlayer().setConversation(0);
                    return;
                }
                String string = a2.readMapleAsciiString();
                if (a3.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5b97\u860e\u5fec\u91ef\u5b9d\u789f\u8f63\u5146")));
                }
                if (a3.getSecondPassword() != null) {
                    if (string == null) {
                        a3.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u8a92\u8f56\u513c\u5ba8\u78e5\u306c"));
                        return;
                    }
                    if (!a3.check2ndPassword(string)) {
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().dropMessage(1, MapleCoolDownValueHolder.ALLATORIxDEMO("\u5be5\u78e7\u930c\u8aff\u3021"));
                        mapleClient.getPlayer().setConversation(0);
                        if (!mapleClient.isMonitored()) return;
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(ConcurrentEnumMap.ALLATORIxDEMO("\u5b95\u8643\u5fee\u91a2\u5b9f\u78d2\u8f61\u510b\u9376\u8aca")));
                        return;
                    }
                }
                MapleClient mapleClient = a3;
                int n2 = mapleClient.getPlayer().getConversation();
                boolean bl = World.hasMerchant(mapleClient.getPlayer().getAccountID());
                boolean bl2 = World.haveHiredMerchants(mapleClient.getPlayer().getAccountID());
                if (mapleClient.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5b97\u860e\u5fec\u91ef\u5b9d\u789f\u8f63\u5146\u5bd7\u7541\u9069\u5146\u7ce5\u976b\u551d\u4e99\u5052\u5e88")));
                }
                if (bl) {
                    MapleClient mapleClient2 = a3;
                    mapleClient2.sendPacket(PlayerShopPacket.ShowMerchItemStore(9030000, World.getMerchantMap(mapleClient2.getPlayer()), World.getMerchantChannel(a3.getPlayer())));
                    mapleClient2.getPlayer().setConversation(0);
                    return;
                }
                MapleClient mapleClient3 = a3;
                if (bl2) {
                    mapleClient3.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u60c6\u76dd\u5528\u5ece\u95e5\u840e\uff6f"));
                    a3.getPlayer().setConversation(0);
                    FileoutputUtil.logToFile(MapleCoolDownValueHolder.ALLATORIxDEMO("7L<Ptk:@0\f\u7ce5\u976b\u551d\u4e99\u752b\u5e1buW#W"), a3.getPlayer().getChrInfo("World.hasMerchant \u627e\u4e0d\u5230\u7cbe\u9748\u5546\u4eba,\u537b\u80fd\u9818\u56de\u3002" + World.getMerchantMap(a3.getPlayer()) + " " + World.getMerchantChannel(a3.getPlayer())));
                    return;
                }
                if (ServerTempStorage.getMerchant(mapleClient3.getPlayer())) {
                    MapleClient mapleClient4 = a3;
                    mapleClient4.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u60c6\u5dab\u9876\u538f\u5194\u6567\u7f00\u5771\u7cd0\u9711\u5528\u4ee3\u5109\u76dd\u7207\u5498\uff6f"));
                    mapleClient4.getPlayer().setConversation(0);
                    return;
                }
                if (n2 != 3) return;
                MerchItemPackage merchItemPackage = HiredMerchantHandler.loadItemFromDatabase(a3.getPlayer().getId(), a3.getPlayer().getAccountID());
                MapleClient mapleClient5 = a3;
                if (merchItemPackage == null) {
                    mapleClient5.sendPacket(PlayerShopPacket.merchItemStore((byte)37));
                    a3.getPlayer().setConversation(0);
                    return;
                }
                if ((long)mapleClient5.getPlayer().getMeso() + (long)merchItemPackage.getMesos() >= Integer.MAX_VALUE) {
                    MapleClient mapleClient6 = a3;
                    mapleClient6.getPlayer().dropMessage(1, MapleCoolDownValueHolder.ALLATORIxDEMO("\u60f3\u76a7\u9379\u983b\u538d\u906d\u5fd7\u5c24\u6758\u906d\u5941\uff2f\u8a90\u516b\u5c5c\u5939\u9943\u76a7\u9379\u651d\u7f35\u502a\u5ef0\u0002"));
                    mapleClient6.getPlayer().setConversation(0);
                    return;
                }
                if (!merchItemPackage.getItems().isEmpty()) {
                    a3.sendPacket(PlayerShopPacket.merchItemStore_ItemData(merchItemPackage));
                    return;
                }
                if (!HiredMerchantHandler.ALLATORIxDEMO(a3.getPlayer(), merchItemPackage)) {
                    MapleClient mapleClient7 = a3;
                    mapleClient7.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u60f1\u76ea\u8ef2\u4e64\u7a23\u95fd\u4e54\u8dddu\u8aa5\u7a23\u5194\u8dea\u594e\u76dd\u6852\u6521O"));
                    mapleClient7.getPlayer().setConversation(0);
                    return;
                }
                MapleClient mapleClient8 = a3;
                if (HiredMerchantHandler.ALLATORIxDEMO(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), merchItemPackage.getPackageid())) {
                    mapleClient8.getPlayer().gainMeso(merchItemPackage.getMesos(), true);
                    MapleClient mapleClient9 = a3;
                    ServerTempStorage.setMerchant(mapleClient9.getPlayer(), true);
                    mapleClient9.getPlayer().dropMessage(1, "\u4f60\u5df2\u7d93\u5f9e\u7cbe\u9748\u5546\u4eba\u9818\u53d6\u4e86" + merchItemPackage.getMesos() + "\u6953\u5e63");
                    MapleClient mapleClient10 = a3;
                    World.removeMerchantByAcId(mapleClient10.getAccID());
                    mapleClient10.getPlayer().setConversation(0);
                } else {
                    mapleClient8.getPlayer().dropMessage(1, MapleCoolDownValueHolder.ALLATORIxDEMO("\u7627\u753c\u6771\u77c6\u76df\u930c\u8aff\r"));
                }
                Object object = "";
                Iterator<IItem> iterator2 = iterator = merchItemPackage.getItems().iterator();
                while (iterator2.hasNext()) {
                    IItem iItem = iterator.next();
                    object = (String)object + iItem.getItemId() + "(" + iItem.getQuantity() + "), ";
                    iterator2 = iterator;
                }
                if (ServerConfig.LOG_MERCHANT) {
                    FileoutputUtil.logToFile(ConcurrentEnumMap.ALLATORIxDEMO("5\u0001>\u001dv*8\u001a8A\u7ce7\u9726\u551f\u4ed4\u9841\u56b0w\u001a!\u001a"), FileoutputUtil.NowTime() + "\u89d2\u8272\u540d\u5b57:" + a3.getPlayer().getName() + " \u5f9e\u7cbe\u9748\u5546\u4eba\u53d6\u56de\u6953\u5e63: " + merchItemPackage.getMesos() + " \u548c" + merchItemPackage.getItems().size() + "\u4ef6\u7269\u54c1[" + (String)object + "]\r\n");
                }
                if (a3.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u7cbe\u9748\u5546\u4eba\u9818\u56de.txt", a3.getPlayer().getChrInfo("\u5f9e\u7cbe\u9748\u5546\u4eba\u53d6\u56de\u6953\u5e63: " + merchItemPackage.getMesos() + " \u548c" + merchItemPackage.getItems().size() + "\u4ef6\u7269\u54c1[" + (String)object + "]"));
                }
                a3.getPlayer().setConversation(0);
                return;
            }
            case 25: {
                if (a3.getPlayer().getConversation() != 3) {
                    return;
                }
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(PlayerShopPacket.merchItemStore((byte)36));
                if (!mapleClient.isMonitored()) return;
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5bef\u8676\u5f94\u9197\u000e\u9e85\u905b\u5133\u90cb\u9843\u56fd")));
                return;
            }
            case 26: {
                Iterator<IItem> iterator;
                if (a3.getPlayer().getConversation() != 3) {
                    return;
                }
                MerchItemPackage merchItemPackage = HiredMerchantHandler.loadItemFromDatabase(a3.getPlayer().getId(), a3.getPlayer().getAccountID());
                if (merchItemPackage == null) {
                    a3.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u6773\u778b\u76dd\u9341\u8afd@"));
                    return;
                }
                if (!HiredMerchantHandler.ALLATORIxDEMO(a3.getPlayer(), merchItemPackage)) {
                    a3.sendPacket(PlayerShopPacket.merchItem_Message((byte)33));
                    return;
                }
                if (a3.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5bef\u8676\u5f94\u9197\u000e\u9e85\u905b\u78e1\u8aae\u9843\u56fd")));
                }
                if (ServerTempStorage.getMerchant(a3.getPlayer())) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u60c6\u5dab\u9876\u538f\u5194\u6567\u7f00\u5771\u7cd0\u9711\u5528\u4ee3\u5109\u76dd\u7207\u5498\uff6f"));
                    mapleClient.getPlayer().setConversation(0);
                    return;
                }
                if (!HiredMerchantHandler.ALLATORIxDEMO(a3.getPlayer().getId(), a3.getPlayer().getAccountID(), merchItemPackage.getPackageid())) {
                    a3.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u7625\u7571\u6773\u778b\u76dd\u9341\u8afd@"));
                    return;
                }
                Object object = "";
                MerchItemPackage merchItemPackage2 = merchItemPackage;
                a3.getPlayer().gainMeso(merchItemPackage2.getMesos(), true);
                Iterator<IItem> iterator3 = iterator = merchItemPackage2.getItems().iterator();
                while (iterator3.hasNext()) {
                    IItem iItem;
                    IItem iItem2 = iItem = iterator.next();
                    MapleInventoryManipulator.addFromDrop(a3, iItem2, true);
                    object = (String)object + iItem2.getItemId() + "(" + iItem.getQuantity() + "), ";
                    iterator3 = iterator;
                }
                if (GameSetConstants.COPTITEMCHECK_STRICT) {
                    a3.getPlayer().checkCopyItems(true);
                }
                int n3 = 29;
                if (GameSetConstants.MAPLE_VERSION >= 147) {
                    n3 = 32;
                }
                a3.sendPacket(PlayerShopPacket.merchItem_Message((byte)n3));
                if (ServerConfig.LOG_MERCHANT) {
                    FileoutputUtil.logToFile(MapleCoolDownValueHolder.ALLATORIxDEMO("7L<Ptg:W:\f\u7ce5\u976b\u551d\u4e99\u9843\u56fduW#W"), FileoutputUtil.NowTime() + "\u89d2\u8272\u540d\u5b57:" + a3.getPlayer().getName() + " \u5f9e\u7cbe\u9748\u5546\u4eba\u53d6\u56de\u6953\u5e63: " + merchItemPackage.getMesos() + " \u548c" + merchItemPackage.getItems().size() + "\u4ef6\u7269\u54c1[" + (String)object + "]\r\n");
                }
                if (a3.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo("\u5f9e\u7cbe\u9748\u5546\u4eba\u53d6\u56de\u6953\u5e63: " + merchItemPackage.getMesos() + " \u548c" + merchItemPackage.getItems().size() + "\u4ef6\u7269\u54c1[" + (String)object + "]"));
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u7cbe\u9748\u5546\u4eba\u9818\u56de.txt", a3.getPlayer().getChrInfo("\u5f9e\u7cbe\u9748\u5546\u4eba\u53d6\u56de\u6953\u5e63: " + merchItemPackage.getMesos() + " \u548c" + merchItemPackage.getItems().size() + "\u4ef6\u7269\u54c1[" + (String)object + "]"));
                }
                MapleClient mapleClient = a3;
                World.removeMerchantByAcId(mapleClient.getAccID());
                ServerTempStorage.setMerchant(mapleClient.getPlayer(), true);
                mapleClient.getPlayer().setConversation(0);
                return;
            }
            case 27: {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().setConversation(0);
                if (!mapleClient.isMonitored()) return;
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5bef\u8676\u5f94\u9197\u000e\u96b9\u95a8\u5052\u5e88")));
                return;
            }
        }
    }

    public /* synthetic */ HiredMerchantHandler() {
        HiredMerchantHandler a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final /* synthetic */ boolean ALLATORIxDEMO(MapleCharacter a2, MerchItemPackage a32) {
        if (a2.getMeso() + ((MerchItemPackage)((Object)a32)).getMesos() < 0) {
            return false;
        }
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        a32 = ((MerchItemPackage)((Object)a32)).getItems().iterator();
        block7: while (a32.hasNext()) {
            MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a32.next().getItemId());
            if (null == mapleInventoryType) continue;
            switch (1.ALLATORIxDEMO[mapleInventoryType.ordinal()]) {
                case 1: {
                    s2 = (byte)(s2 + 1);
                    continue block7;
                }
                case 2: {
                    s3 = (byte)(s3 + 1);
                    continue block7;
                }
                case 3: {
                    s4 = (byte)(s4 + 1);
                    continue block7;
                }
                case 4: {
                    s5 = (byte)(s5 + 1);
                    continue block7;
                }
                case 5: {
                    s6 = (byte)(s6 + 1);
                    continue block7;
                }
            }
        }
        boolean a32 = true;
        if (a2.getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() <= s2 && s2 != 0) {
            a32 = false;
        }
        if (a2.getInventory(MapleInventoryType.USE).getNumFreeSlot() <= s3 && s3 != 0) {
            a32 = false;
        }
        if (a2.getInventory(MapleInventoryType.SETUP).getNumFreeSlot() <= s4 && s4 != 0) {
            a32 = false;
        }
        if (a2.getInventory(MapleInventoryType.ETC).getNumFreeSlot() <= s5 && s5 != 0) {
            a32 = false;
        }
        if (a2.getInventory(MapleInventoryType.CASH).getNumFreeSlot() > s6) return a32;
        if (s6 == 0) return a32;
        return false;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ List<Pair<IItem, MapleInventoryType>> loadItemFromDatabase_(int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 5[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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
     * Exception decompiling
     */
    private static /* synthetic */ boolean ALLATORIxDEMO(int a, int a, int a) {
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
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void UseHiredMerchant(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null || a3.getPlayer().getMap() == null) {
            if (a3 == null || a3.getPlayer() == null) return;
            a3.getPlayer().dropMessage(ConcurrentEnumMap.ALLATORIxDEMO("\u7625\u7571\u6773\u778b\u76dd\u9341\u8afd\uff62\u8a92\u7a63\u5fd5\u51e3\u8a3f\u306c"));
            return;
        }
        if (a3.getPlayer().getMap().allowPersonalShop()) {
            MapleClient mapleClient = a3;
            byte by = HiredMerchantHandler.checkExistance(a3.getPlayer().getAccountID(), mapleClient.getPlayer().getId());
            boolean bl = World.hasMerchant(mapleClient.getPlayer().getAccountID());
            switch (by) {
                case 1: {
                    if (ServerTempStorage.getMerchant(a3.getPlayer())) {
                        MapleClient mapleClient2 = a3;
                        HiredMerchantHandler.ClearWorldMerchant(mapleClient2.getPlayer());
                        mapleClient2.getPlayer().RemoveHired();
                        FileoutputUtil.logToFile(MapleCoolDownValueHolder.ALLATORIxDEMO("O4D(\f\u0013B8Ht\u8924\u88a6\f\u7ce5\u976b\u551d\u4e99\u895c\u88deuW#W"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getPlayer().getName() + "\u7b49\u7d1a:" + a3.getPlayer().getLevel() + " (\u7de8\u865f: " + a3.getPlayer().getId() + ")\u5617\u8a66\u5229\u7528\u5bcc\u862d\u5fb7\u91cc\u8907\u88fd--\u7d00\u9304\u4f86\u81ea\u958b\u555f\u7cbe\u9748\u5546\u4eba");
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a3.getPlayer().getChrInfo(ConcurrentEnumMap.ALLATORIxDEMO("\u564e\u8a08\u5270\u7546\u5b95\u8643\u5fee\u91a2\u895e\u8893tC\u7d59\u936a\u4fdf\u8184\u95d2\u5531\u7ce7\u9726\u551f\u4ed4")));
                        World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] \u89d2\u8272" + a3.getPlayer().getName() + "\u7b49\u7d1a:" + a3.getPlayer().getLevel() + " (\u7de8\u865f: " + a3.getPlayer().getId() + ")\u5617\u8a66\u5229\u7528\u5bcc\u862d\u5fb7\u91cc\u8907\u88fd--\u7d00\u9304\u4f86\u81ea\u958b\u555f\u7cbe\u9748\u5546\u4eba"));
                        MapleClient mapleClient3 = a3;
                        mapleClient3.getPlayer().dropMessage(1, MapleCoolDownValueHolder.ALLATORIxDEMO("\u64ee\u4f07\u7553\u5e63\u000f\u5da9\u81c9\u528e\u63b1\u963f\u930c\u8aff\u0002\u8a90\u7a2e\u5fd7\u51ae\u8a3d\u3021"));
                        ServerTempStorage.setMerchant(mapleClient3.getPlayer(), false);
                        return;
                    }
                    MapleClient mapleClient4 = a3;
                    if (bl) {
                        mapleClient4.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u7680\u5214\u60c6\u76dd\u5e5d\u8606\u5d9c\u8a74\u7aa5\u551f\u5ef9\u65e5\u8184\u7568\u5e6c\u586dO"));
                        return;
                    }
                    mapleClient4.getPlayer().dropMessage(1, MapleCoolDownValueHolder.ALLATORIxDEMO("\u8ae8\u5113\u5398\u6225\u5bef\u8676\u5f94\u9197\u983b\u538d\u4f43\u4e10\u526e\u64a1\u76a7\u672a\u895c"));
                    return;
                }
                case 0: {
                    if (bl) {
                        a3.sendPacket(PlayerShopPacket.ShowMerchItemStore(9030000, World.getMerchantMap(a3.getPlayer()), World.getMerchantChannel(a3.getPlayer())));
                        return;
                    }
                    if (a3.getPlayer().getTrade() != null) {
                        a3.getPlayer().dropMessage(1, ConcurrentEnumMap.ALLATORIxDEMO("\u7680\u5214\u72ae\u6112\u714f\u6c8c\u4f11\u7571@"));
                        return;
                    }
                    if (a2.available() <= 0L) return;
                    a3.sendPacket(PlayerShopPacket.sendTitleBox());
                    return;
                }
                default: {
                    a3.getPlayer().dropMessage(1, MapleCoolDownValueHolder.ALLATORIxDEMO("\u765f\u7544\u4ea5\u6771\u77c6\u76df\u930c\u8aff\r"));
                    return;
                }
            }
        }
        a3.getSession().close();
        if (!ServerConfig.LOG_DC) return;
        FileoutputUtil.logToFile(ConcurrentEnumMap.ALLATORIxDEMO("5\u0001>\u001dv*8\u001a8A\u001d-w\u001a!\u001a"), "\r\n \u6642\u9593:" + FileoutputUtil.NowTime() + "\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
    }
}

