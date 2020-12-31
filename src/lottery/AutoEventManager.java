/*
 * Decompiled with CFR 0.150.
 */
package lottery;

import handling.channel.ChannelServer;
import lottery.CustomEventFactory;
import server.maps.MapleMapFactory;

public class AutoEventManager
implements Runnable {
    private /* synthetic */ ChannelServer d;
    private /* synthetic */ MapleMapFactory ALLATORIxDEMO;
    private static /* synthetic */ AutoEventManager a;

    public /* synthetic */ MapleMapFactory getMapleMapFactory() {
        AutoEventManager a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void run() {
        AutoEventManager a2;
        AutoEventManager autoEventManager = a2;
        CustomEventFactory.getInstance().getLottery(autoEventManager.d, autoEventManager.ALLATORIxDEMO).doLottery();
    }

    public static /* synthetic */ AutoEventManager newInstance() {
        return new AutoEventManager();
    }

    public static /* synthetic */ {
        a = null;
    }

    public static /* synthetic */ AutoEventManager newInstance(ChannelServer a2, MapleMapFactory a3) {
        a = new AutoEventManager(a2, a3);
        return a;
    }

    public static /* synthetic */ AutoEventManager getInstance(ChannelServer a2, MapleMapFactory a3) {
        if (a == null) {
            a = new AutoEventManager(a2, a3);
        }
        return a;
    }

    private /* synthetic */ AutoEventManager() {
        AutoEventManager a2;
    }

    public /* synthetic */ ChannelServer getChannelServer() {
        AutoEventManager a2;
        return a2.d;
    }

    private /* synthetic */ AutoEventManager(ChannelServer a2, MapleMapFactory a3) {
        AutoEventManager a4;
        AutoEventManager autoEventManager = a4;
        autoEventManager.d = a2;
        autoEventManager.ALLATORIxDEMO = a3;
    }

    public static /* synthetic */ AutoEventManager getInstance() {
        if (a == null) {
            a = new AutoEventManager();
        }
        return a;
    }
}

