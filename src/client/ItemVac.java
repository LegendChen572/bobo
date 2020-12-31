/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleCharacter;
import client.MapleClient;
import handling.channel.handler.InventoryHandler;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import server.MapleItemInformationProvider;
import server.maps.MapleMapItem;
import server.maps.MapleMapObject;

public class ItemVac
extends Thread {
    private /* synthetic */ MapleMapItem K;
    private final /* synthetic */ ConcurrentLinkedQueue<MapleMapObject> k;
    private /* synthetic */ MapleMapObject a;
    private final /* synthetic */ MapleClient ALLATORIxDEMO;
    private final /* synthetic */ MapleCharacter d;

    public /* synthetic */ ItemVac(MapleCharacter a2) {
        ItemVac a3;
        ItemVac itemVac = a3;
        itemVac.d = a2;
        ItemVac itemVac2 = a3;
        itemVac.k = new ConcurrentLinkedQueue();
        itemVac.ALLATORIxDEMO = a2.getClient();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized /* synthetic */ void addObject(MapleMapObject a222) {
        Lock lock;
        block7: {
            MapleMapObject a222;
            ItemVac a3;
            Lock lock2;
            MapleMapItem mapleMapItem;
            block6: {
                block5: {
                    mapleMapItem = (MapleMapItem)a222;
                    lock2 = mapleMapItem.getLock();
                    lock2.lock();
                    try {
                        if (!(mapleMapItem.isPickedUp() || mapleMapItem.getQuest() > 0 && a3.d.getQuestStatus(mapleMapItem.getQuest()) != 1 || mapleMapItem.getOwner() != a3.d.getId() && (!mapleMapItem.isPlayerDrop() && mapleMapItem.getDropType() == 0 || mapleMapItem.isPlayerDrop() && a3.d.getMap().getEverlast())) && (mapleMapItem.isPlayerDrop() || mapleMapItem.getDropType() != 1 || mapleMapItem.getOwner() == a3.d.getId())) break block5;
                        lock2.unlock();
                        return;
                    }
                    catch (Throwable a222) {
                        lock2.unlock();
                        throw a222;
                    }
                }
                if (mapleMapItem.getMeso() <= 0) break block6;
                lock = lock2;
                a3.k.add(a222);
                break block7;
            }
            if (!MapleItemInformationProvider.getInstance().isPickupBlocked(mapleMapItem.getItemId()) && !InventoryHandler.useItem(a3.ALLATORIxDEMO, mapleMapItem.getItemId()) && mapleMapItem.getItemId() / 10000 != 291) {
                a3.k.add(a222);
            }
            lock = lock2;
        }
        lock.unlock();
    }

    /*
     * Exception decompiling
     */
    @Override
    public synchronized /* synthetic */ void run() {
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

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 5;
        int cfr_ignored_0 = 4 << 3 ^ 3;
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ 5;
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
}

