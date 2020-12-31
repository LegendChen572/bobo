/*
 * Decompiled with CFR 0.150.
 */
package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import handling.channel.ChannelServer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.Timer;
import server.maps.MapleMapObjectType;
import server.shops.AbstractPlayerStore;
import tools.packet.PlayerShopPacket;

public class HiredFishing
extends AbstractPlayerStore {
    public /* synthetic */ ScheduledFuture<?> schedule;
    private /* synthetic */ int a;
    private final /* synthetic */ long d;
    public /* synthetic */ boolean canShop;
    private final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;

    @Override
    public final /* synthetic */ boolean getCanShop() {
        HiredFishing a2;
        return a2.canShop;
    }

    public /* synthetic */ int getTimeLeft() {
        HiredFishing a2;
        return (int)((System.currentTimeMillis() - a2.d) / 1000L);
    }

    @Override
    public /* synthetic */ void buy(MapleClient a2, int a3, short a4) {
    }

    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3, boolean a4) {
        HiredFishing a5;
        a5.closeShop(a2, a3);
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.HIRED_FISHING;
    }

    public final /* synthetic */ void setStoreid(int a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        HiredFishing a3;
        if (a3.isAvailable()) {
            a2.sendPacket(PlayerShopPacket.spawnHiredFishing(a3));
        }
    }

    @Override
    public /* synthetic */ byte getShopType() {
        return 0;
    }

    public /* synthetic */ HiredFishing(MapleCharacter a2, int a3) {
        HiredFishing a4;
        HiredFishing hiredFishing = a4;
        HiredFishing hiredFishing2 = a4;
        super(a2, a3, "", "", 3);
        HiredFishing hiredFishing3 = a4;
        hiredFishing2.ALLATORIxDEMO = new ReentrantReadWriteLock();
        hiredFishing.canShop = true;
        hiredFishing2.d = System.currentTimeMillis();
        hiredFishing.schedule = Timer.EtcTimer.getInstance().schedule(new Runnable(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                a2.HiredFishing.this.closeShop(true, true);
            }
        }, 86400000L);
    }

    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3) {
        HiredFishing a4;
        a4.ALLATORIxDEMO.writeLock().lock();
        try {
            if (a4.schedule != null) {
                a4.schedule.cancel(false);
            }
            if (a2) {
                a4.saveItems(false);
            }
            if (a3) {
                HiredFishing hiredFishing = a4;
                HiredFishing hiredFishing2 = a4;
                ChannelServer.getInstance(hiredFishing.world, hiredFishing.channel).removeFishing(hiredFishing2);
                hiredFishing2.getMap().broadcastMessage(PlayerShopPacket.destroyHiredMerchant(a4.getOwnerId()));
            }
            a4.getMap().removeMapObject(a4);
            a4.schedule = null;
            return;
        }
        finally {
            a4.ALLATORIxDEMO.writeLock().unlock();
        }
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        HiredFishing a3;
        if (a3.isAvailable()) {
            a2.sendPacket(PlayerShopPacket.destroyHiredMerchant(a3.getOwnerId()));
        }
    }

    public final /* synthetic */ int getStoreId() {
        HiredFishing a2;
        return a2.a;
    }

    @Override
    public final /* synthetic */ void setCanShop(boolean a2) {
        a.canShop = a2;
    }
}

