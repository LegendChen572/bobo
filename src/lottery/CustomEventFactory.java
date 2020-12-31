/*
 * Decompiled with CFR 0.150.
 */
package lottery;

import handling.channel.ChannelServer;
import lottery.Lottery;
import lottery.LotteryImpl;
import server.maps.MapleMapFactory;

public class CustomEventFactory {
    private static /* synthetic */ CustomEventFactory d;
    private static /* synthetic */ boolean ALLATORIxDEMO;

    public /* synthetic */ boolean isCANLOG() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ CustomEventFactory getInstance() {
        if (d == null) {
            d = new CustomEventFactory();
        }
        return d;
    }

    public /* synthetic */ void setCANLOG(boolean a2) {
    }

    public /* synthetic */ Lottery getLottery(ChannelServer a2, MapleMapFactory a3) {
        return LotteryImpl.getInstance(a2, a3);
    }

    public /* synthetic */ Lottery getLottery() {
        return LotteryImpl.getInstance();
    }

    public /* synthetic */ CustomEventFactory() {
        CustomEventFactory a2;
    }

    public static /* synthetic */ {
        d = null;
    }
}

