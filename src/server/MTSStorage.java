/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server;

import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.MTSCart;
import server.life.MobNameData;
import tools.FilePrinter;
import tools.Pair;
import tools.packet.MTSCSPacket;

public class MTSStorage {
    private static /* synthetic */ MTSStorage K;
    private final /* synthetic */ AtomicInteger B;
    private final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;
    private static final /* synthetic */ long e = 231541893513228L;
    private final /* synthetic */ Map<Integer, MTSItemInfo> k;
    private /* synthetic */ long E;
    private /* synthetic */ boolean a;
    private final /* synthetic */ ReentrantReadWriteLock d;
    private final /* synthetic */ Map<Integer, MTSCart> g;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean removeFromBuyNow(int a2, int a3, boolean a422) {
        IItem iItem;
        MTSStorage a5;
        IItem iItem2 = null;
        a5.d.writeLock().lock();
        try {
            if (a5.k.containsKey(a2)) {
                MTSItemInfo mTSItemInfo = a5.k.get(a2);
                if (!a422 || mTSItemInfo.getCharacterId() == a3) {
                    iItem2 = mTSItemInfo.getItem();
                    a5.k.remove(a2);
                }
            }
        }
        finally {
            a5.d.writeLock().unlock();
        }
        if (iItem2 != null) {
            a5.ALLATORIxDEMO.readLock().lock();
            try {
                for (Map.Entry a422 : a5.g.entrySet()) {
                    ((MTSCart)a422.getValue()).removeFromCart(a2);
                    ((MTSCart)a422.getValue()).removeFromNotYetSold(a2);
                    if ((Integer)a422.getKey() != a3) continue;
                    ((MTSCart)a422.getValue()).addToInventory(iItem2);
                }
                iItem = iItem2;
            }
            finally {
                a5.ALLATORIxDEMO.readLock().unlock();
            }
        } else {
            iItem = iItem2;
        }
        return iItem != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ byte[] getCurrentNotYetSold(MTSCart a2) {
        MTSStorage a3;
        a3.d.readLock().lock();
        try {
            ArrayList<MTSItemInfo> arrayList = new ArrayList<MTSItemInfo>();
            Object object = new ArrayList<Integer>(a2.getNotYetSold()).iterator();
            while (object.hasNext()) {
                int n2 = (Integer)object.next();
                MTSItemInfo mTSItemInfo = a3.k.get(n2);
                if (mTSItemInfo == null) {
                    a2.removeFromNotYetSold(n2);
                    continue;
                }
                arrayList.add(mTSItemInfo);
            }
            object = MTSCSPacket.getNotYetSoldInv(arrayList);
            return object;
        }
        finally {
            a3.d.readLock().unlock();
        }
    }

    public /* synthetic */ MTSStorage() {
        MTSStorage a2;
        MTSStorage mTSStorage = a2;
        a2.E = System.currentTimeMillis();
        a2.a = false;
        System.out.println(MobNameData.ALLATORIxDEMO("\u303e\u8bb2\u53f8\u4e1f\u303f\u0012cf}aZ]\\SIW\u000e\b\u0014\b"));
        MTSStorage mTSStorage2 = a2;
        mTSStorage.g = new LinkedHashMap<Integer, MTSCart>();
        mTSStorage2.k = new LinkedHashMap<Integer, MTSItemInfo>();
        mTSStorage.B = new AtomicInteger(1);
        mTSStorage.d = new ReentrantReadWriteLock();
        mTSStorage.ALLATORIxDEMO = new ReentrantReadWriteLock();
    }

    public final /* synthetic */ boolean checkCart(int a22, int a3) {
        MTSStorage a4;
        MTSItemInfo a22 = a4.getSingleItem(a22);
        return a22 != null && a22.getCharacterId() != a3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ byte[] getCurrentMTS(MTSCart a2) {
        MTSStorage a3;
        a3.d.readLock().lock();
        try {
            switch (a2.getTab()) {
                case 1: {
                    byte[] arrby = MTSCSPacket.sendMTS(a3.ALLATORIxDEMO(a2.getType(), a2.getPage()), a2.getTab(), a2.getType(), a2.getPage(), a3.k.size() / 16 + (a3.k.size() % 16 > 0 ? 1 : 0));
                    return arrby;
                }
                case 4: {
                    byte[] arrby = MTSCSPacket.sendMTS(a3.ALLATORIxDEMO(a2), a2.getTab(), a2.getType(), a2.getPage(), 0);
                    return arrby;
                }
            }
            byte[] arrby = MTSCSPacket.sendMTS(new ArrayList<MTSItemInfo>(), a2.getTab(), a2.getType(), a2.getPage(), 0);
            return arrby;
        }
        finally {
            a3.d.readLock().unlock();
        }
    }

    public final /* synthetic */ void checkExpirations() {
        MTSStorage a2;
        if (System.currentTimeMillis() - a2.E > 3600000L) {
            a2.saveBuyNow(false);
        }
    }

    private /* synthetic */ List<MTSItemInfo> ALLATORIxDEMO(MTSCart a2) {
        ArrayList<MTSItemInfo> arrayList = new ArrayList<MTSItemInfo>();
        Iterator iterator = new ArrayList<Integer>(a2.getCart()).iterator();
        while (iterator.hasNext()) {
            MTSStorage a3;
            int n2 = (Integer)iterator.next();
            MTSItemInfo mTSItemInfo = a3.k.get(n2);
            if (mTSItemInfo == null) {
                a2.removeFromCart(n2);
                continue;
            }
            if (a2.getType() != 0 && GameConstants.getInventoryType(mTSItemInfo.getItem().getItemId()).getType() != a2.getType()) continue;
            arrayList.add(mTSItemInfo);
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void addToBuyNow(MTSCart a2, IItem a3, int a4, int a5, String a6, long a7) {
        int n2;
        MTSStorage a8;
        a8.d.writeLock().lock();
        try {
            MTSStorage mTSStorage = a8;
            n2 = mTSStorage.B.incrementAndGet();
            mTSStorage.k.put(n2, new MTSItemInfo(a4, a3, a6, n2, a5, a7));
        }
        finally {
            a8.d.writeLock().unlock();
        }
        a2.addToNotYetSold(n2);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4;
        int cfr_ignored_0 = 4 << 4 ^ (3 << 2 ^ 3);
        int n5 = n3;
        int n6 = 3 << 3 ^ 4;
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
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ MTSCart getCart(int a2) {
        MTSCart mTSCart;
        MTSStorage a3;
        a3.ALLATORIxDEMO.readLock().lock();
        try {
            mTSCart = a3.g.get(a2);
        }
        finally {
            a3.ALLATORIxDEMO.readLock().unlock();
        }
        if (mTSCart == null) {
            a3.ALLATORIxDEMO.writeLock().lock();
            try {
                mTSCart = new MTSCart(a2);
                a3.g.put(a2, mTSCart);
                return mTSCart;
            }
            catch (SQLException sQLException) {
                FilePrinter.printError(MobNameData.ALLATORIxDEMO("cf}aZ]\\SIW\u0000FVF"), sQLException, MaplePet.ALLATORIxDEMO("[RHt]EH"));
                return mTSCart;
            }
            finally {
                a3.ALLATORIxDEMO.writeLock().unlock();
            }
        }
        return mTSCart;
    }

    public final /* synthetic */ byte[] getCurrentTransfer(MTSCart a2, boolean a3) {
        return MTSCSPacket.getTransferInventory(a2.getInventory(), a3);
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void ALLATORIxDEMO() {
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

    public final /* synthetic */ MTSItemInfo getSingleItem(int a22) {
        MTSStorage a3;
        a3.d.readLock().lock();
        try {
            MTSItemInfo a22 = a3.k.get(a22);
            return a22;
        }
        finally {
            a3.d.readLock().unlock();
        }
    }

    public static final /* synthetic */ void load() {
        if (K == null) {
            K = new MTSStorage();
            K.ALLATORIxDEMO();
        }
    }

    private /* synthetic */ List<MTSItemInfo> ALLATORIxDEMO(int a2, int a3) {
        int n2;
        MTSStorage a4;
        int n3 = a4.k.size() / 16 + (a4.k.size() % 16 > 0 ? 1 : 0);
        ArrayList<MTSItemInfo> arrayList = new ArrayList<MTSItemInfo>();
        ArrayList<MTSItemInfo> arrayList2 = new ArrayList<MTSItemInfo>(a4.k.values());
        if (a3 > n3) {
            a3 = 0;
        }
        int n4 = n2 = a3 * 16;
        while (n4 < a3 * 16 + 16 && a4.k.size() >= n2 + 1) {
            MTSItemInfo mTSItemInfo = (MTSItemInfo)arrayList2.get(n2);
            if (mTSItemInfo != null && (a2 == 0 || GameConstants.getInventoryType(mTSItemInfo.getItem().getItemId()).getType() == a2)) {
                arrayList.add(mTSItemInfo);
            }
            n4 = ++n2;
        }
        return arrayList;
    }

    public static final /* synthetic */ MTSStorage getInstance() {
        return K;
    }

    public final /* synthetic */ boolean check(int a2) {
        MTSStorage a3;
        return a3.getSingleItem(a2) != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void saveBuyNow(boolean a22) {
        MTSStorage mTSStorage;
        MTSStorage mTSStorage2;
        boolean bl;
        Iterator<MTSItemInfo> iterator;
        MTSStorage a3;
        if (a3.a) {
            return;
        }
        a3.a = a22;
        if (a22) {
            System.out.println(MaplePet.ALLATORIxDEMO("\u6eaa\u50ae\u510e\u5b6f\u62f1\u8cd4\u0012\u0019\u0012"));
        }
        HashMap hashMap = new HashMap();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        long l2 = System.currentTimeMillis();
        HashMap hashMap2 = new HashMap();
        a3.d.writeLock().lock();
        try {
            MTSStorage mTSStorage3;
            block33: {
                block32: {
                    DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(MobNameData.ALLATORIxDEMO("vk~kfk\u0012h`a\u007f\u000e_ZAq[ZWCA\u000eefw|w\u000eFOP\u000e\u000f\u000e\u0003"));
                        preparedStatement.execute();
                        preparedStatement.close();
                        PreparedStatement preparedStatement2 = druidPooledConnection.prepareStatement(MaplePet.ALLATORIxDEMO("uyornc\u001c~rcs\u0017QCOhUCYZO\u0017jvpbyd\u001c\u001f\u0003\u001b\u001c\b\u0010\u0017\u0003\u001b\u001c\b\u0010\u0017\u0003\u001b\u001c\b\u0015"));
                        iterator = a3.k.values().iterator();
                        while (iterator.hasNext()) {
                            MTSItemInfo mTSItemInfo = iterator.next();
                            if (l2 > mTSItemInfo.getEndingDate()) {
                                if (!hashMap.containsKey(mTSItemInfo.getCharacterId())) {
                                    hashMap.put(mTSItemInfo.getCharacterId(), new ArrayList());
                                }
                                ((ArrayList)hashMap.get(mTSItemInfo.getCharacterId())).add(mTSItemInfo.getItem());
                                arrayList.add(mTSItemInfo.getId());
                                hashMap2.put(mTSItemInfo.getId(), null);
                                continue;
                            }
                            PreparedStatement preparedStatement3 = preparedStatement2;
                            PreparedStatement preparedStatement4 = preparedStatement2;
                            PreparedStatement preparedStatement5 = preparedStatement2;
                            preparedStatement5.setInt(1, mTSItemInfo.getId());
                            preparedStatement5.setByte(2, (byte)1);
                            preparedStatement4.setInt(3, mTSItemInfo.getPrice());
                            preparedStatement4.setInt(4, mTSItemInfo.getCharacterId());
                            preparedStatement3.setString(5, mTSItemInfo.getSeller());
                            preparedStatement3.setLong(6, mTSItemInfo.getEndingDate());
                            preparedStatement2.executeUpdate();
                            if (!hashMap2.containsKey(mTSItemInfo.getId())) {
                                hashMap2.put(mTSItemInfo.getId(), new ArrayList());
                            }
                            ((ArrayList)hashMap2.get(mTSItemInfo.getId())).add(new Pair<IItem, MapleInventoryType>(mTSItemInfo.getItem(), GameConstants.getInventoryType(mTSItemInfo.getItem().getItemId())));
                        }
                        iterator = arrayList.iterator();
                        Iterator<Object> iterator2 = iterator;
                        while (iterator2.hasNext()) {
                            int n2 = (Integer)((Object)iterator.next());
                            iterator2 = iterator;
                            a3.k.remove(n2);
                        }
                        preparedStatement2.close();
                        if (druidPooledConnection == null) break block32;
                        mTSStorage3 = a3;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                throw throwable2;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    druidPooledConnection.close();
                    break block33;
                }
                mTSStorage3 = a3;
            }
            mTSStorage3.d.writeLock().unlock();
            bl = a22;
        }
        catch (SQLException sQLException) {
            try {
                FilePrinter.printError(MobNameData.ALLATORIxDEMO("cf}aZ]\\SIW\u0000FVF"), sQLException, MaplePet.ALLATORIxDEMO("D]AYuINrXK"));
                bl = a22;
                a3.d.writeLock().unlock();
            }
            catch (Throwable throwable) {
                a3.d.writeLock().unlock();
                throw throwable;
            }
        }
        if (bl) {
            System.out.println(MobNameData.ALLATORIxDEMO("\u5100\u5b76\u62ff\u8ccd\u9061\u5159\u001c\u0000\u001c"));
        }
        try {
            for (Map.Entry entry : hashMap2.entrySet()) {
                Integer[] arrinteger = new Integer[1];
                arrinteger[0] = (Integer)entry.getKey();
                ItemLoader.MTS.saveItems((List<Pair<IItem, MapleInventoryType>>)((List)entry.getValue()), arrinteger);
                if (GameSetConstants.NEW_ITEM_SAVE) {
                    ItemLoader.MTS.saveItemsNew((List)entry.getValue(), (Integer)entry.getKey(), 0);
                    continue;
                }
                Integer[] arrinteger2 = new Integer[1];
                arrinteger2[0] = (Integer)entry.getKey();
                ItemLoader.MTS.saveItems((List<Pair<IItem, MapleInventoryType>>)((List)entry.getValue()), arrinteger2);
            }
        }
        catch (SQLException sQLException) {
            FilePrinter.printError(MaplePet.ALLATORIxDEMO("zhdoCSE]PY\u0019HOH"), sQLException, MobNameData.ALLATORIxDEMO("]SXWlGW|AE"));
        }
        if (a22) {
            System.out.println(MaplePet.ALLATORIxDEMO("\u510e\u5b6f\u62f1\u8cd4\u7a12\u9869\u0012\u0019\u0012"));
        }
        a3.ALLATORIxDEMO.writeLock().lock();
        try {
            for (Map.Entry entry : a3.g.entrySet()) {
                Iterator iterator3 = arrayList.iterator();
                while (iterator3.hasNext()) {
                    int n3 = (Integer)((Object)iterator.next());
                    ((MTSCart)entry.getValue()).removeFromCart(n3);
                    ((MTSCart)entry.getValue()).removeFromNotYetSold(n3);
                    iterator3 = iterator;
                }
                if (hashMap.containsKey(entry.getKey())) {
                    iterator = ((ArrayList)hashMap.get(entry.getKey())).iterator();
                    Iterator<Object> iterator4 = iterator;
                    while (iterator4.hasNext()) {
                        IItem iItem = (IItem)((Object)iterator.next());
                        ((MTSCart)entry.getValue()).addToInventory(iItem);
                        iterator4 = iterator;
                    }
                }
                ((MTSCart)entry.getValue()).save();
            }
            mTSStorage2 = a3;
        }
        catch (SQLException sQLException) {
            MTSStorage mTSStorage4;
            try {
                FilePrinter.printError(MobNameData.ALLATORIxDEMO("cf}aZ]\\SIW\u0000FVF"), sQLException, MaplePet.ALLATORIxDEMO("D]AYuINrXK"));
                mTSStorage4 = a3;
            }
            catch (Throwable a22) {
                a3.ALLATORIxDEMO.writeLock().unlock();
                throw a22;
            }
            mTSStorage = mTSStorage4;
            mTSStorage4.ALLATORIxDEMO.writeLock().unlock();
        }
        mTSStorage = mTSStorage2;
        mTSStorage2.ALLATORIxDEMO.writeLock().unlock();
        mTSStorage.E = System.currentTimeMillis();
    }

    public static class MTSItemInfo {
        private final /* synthetic */ int d;
        private final /* synthetic */ int a;
        private final /* synthetic */ long ALLATORIxDEMO;
        private final /* synthetic */ IItem k;
        private final /* synthetic */ String K;
        private final /* synthetic */ int B;

        public /* synthetic */ String getSeller() {
            MTSItemInfo a2;
            return a2.K;
        }

        public /* synthetic */ int getRealPrice() {
            MTSItemInfo a2;
            return a2.B + a2.getTaxes();
        }

        public /* synthetic */ int getCharacterId() {
            MTSItemInfo a2;
            return a2.d;
        }

        public /* synthetic */ MTSItemInfo(int a2, IItem a3, String a4, int a5, int a6, long a7) {
            MTSItemInfo a8;
            MTSItemInfo mTSItemInfo = a8;
            MTSItemInfo mTSItemInfo2 = a8;
            MTSItemInfo mTSItemInfo3 = a8;
            mTSItemInfo3.k = a3;
            mTSItemInfo3.B = a2;
            mTSItemInfo2.K = a4;
            mTSItemInfo2.a = a5;
            mTSItemInfo.d = a6;
            mTSItemInfo.ALLATORIxDEMO = a7;
        }

        public /* synthetic */ long getEndingDate() {
            MTSItemInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getTaxes() {
            MTSItemInfo a2;
            return 100 + a2.B * 10 / 100;
        }

        public /* synthetic */ IItem getItem() {
            MTSItemInfo a2;
            return a2.k;
        }

        public /* synthetic */ int getPrice() {
            MTSItemInfo a2;
            return a2.B;
        }

        public /* synthetic */ int getId() {
            MTSItemInfo a2;
            return a2.a;
        }
    }
}

