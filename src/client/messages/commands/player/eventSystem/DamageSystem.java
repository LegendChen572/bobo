/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands.player.eventSystem;

import client.MapleClient;
import client.inventory.MapleAndroid;
import client.messages.CommandExecute;
import constants.ServerConstants;
import java.awt.Point;
import server.Timer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.OverrideMonsterStats;
import server.maps.MapleMap;
import tools.use.GetMACAddress;

public class DamageSystem {
    public /* synthetic */ DamageSystem() {
        DamageSystem a2;
    }

    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public static class dpm
    extends CommandExecute {
        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            dpm a4;
            if (a2.getPlayer().getMapId() / 100 == 7010002 && a2.getPlayer().getLevel() >= 70 || a2.getPlayer().isGM()) {
                if (a2.getPlayer().isTestingDPM()) {
                    a2.getPlayer().dropMessage(5, GetMACAddress.ALLATORIxDEMO("\u8aa8\u5151\u62e9\u4f79\u76e7\u9000\u56bd]3T\u6e4f\u8a7f\u5bef\u757b\u3061"));
                    return true;
                }
            } else {
                a2.getPlayer().dropMessage(5, MapleAndroid.ALLATORIxDEMO("\u5399\u80ea\u575bG%G\u5954\u64d5\u5383\u5ef4\u5847\u6e3b\u8a15S#D[\u8adc\u7542\u62da\u8c90\u7693\u50c0\u9016\u95f3\u9025\u5116>"));
                return true;
            }
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().toggleTestingDPM();
            mapleClient.getPlayer().dropMessage(5, MapleAndroid.ALLATORIxDEMO("\u8adc\u6372\u7e9b\u6548\u64dd\u6059\u727eB\"\u79a1\uff1b\u4ff5\u6e3b\u8a15\u60bf\u76f7\u6bd8\u79a1\u8f2f\u5189\uff16"));
            a3 = MapleLifeFactory.getMonster(9001007);
            int n2 = mapleClient.getPlayer().getJob() >= 300 && a2.getPlayer().getJob() < 413 || a2.getPlayer().getJob() >= 1300 && a2.getPlayer().getJob() < 1500 || a2.getPlayer().getJob() >= 520 && a2.getPlayer().getJob() < 600 ? 125 : 50;
            Object object = new Point(a2.getPlayer().getPosition().x - n2, a2.getPlayer().getPosition().y);
            Object object2 = a3;
            Object object3 = a3;
            ((MapleMonster)object3).setDpmBelongTo(a2.getPlayer());
            long l2 = Long.MAX_VALUE;
            OverrideMonsterStats overrideMonsterStats = new OverrideMonsterStats();
            overrideMonsterStats.setOHp(Long.MAX_VALUE);
            ((MapleMonster)object3).setHp(Long.MAX_VALUE);
            ((MapleMonster)object2).getStats().setBoss(true);
            ((MapleMonster)object2).setOverrideStats(overrideMonsterStats);
            MapleClient mapleClient2 = a2;
            mapleClient2.getPlayer().getMap().spawnMonsterOnGroundBelow((MapleMonster)a3, (Point)object);
            object = mapleClient2.getPlayer().getMap();
            Timer.EventTimer.getInstance().schedule(new Runnable(){
                public final /* synthetic */ dpm ALLATORIxDEMO;
                public final /* synthetic */ MapleMonster K;
                public final /* synthetic */ MapleMap a;
                public final /* synthetic */ MapleClient d;

                @Override
                public /* synthetic */ void run() {
                    1 a2;
                    1 v0 = a2;
                    long l2 = v0.K.getHp();
                    v0.a.killMonsterDpm(a2.K);
                    long l3 = (Long.MAX_VALUE - l2) / 15L;
                    if (l3 > a2.d.getPlayer().getDPM()) {
                        a2.d.getPlayer().dropMessage(6, "\u4f60\u7684\u6bcf\u79d2\u8f38\u51fa\u662f " + l3 + ". \u9019\u662f\u4e00\u500b\u65b0\u7684\u7d00\u9304\uff01");
                        1 v1 = a2;
                        v1.d.getPlayer().setDPM(l3);
                        v1.d.getPlayer().toggleTestingDPM();
                        return;
                    }
                    a2.d.getPlayer().dropMessage(6, "\u4f60\u7684\u6bcf\u79d2\u8f38\u51fa\u662f " + l3 + ". \u60a8\u76ee\u524d\u7684\u7d00\u9304\u662f " + a2.d.getPlayer().getDPM() + ".");
                    a2.d.getPlayer().toggleTestingDPM();
                }
                {
                    1 a3;
                    1 v0 = a3;
                    v0.ALLATORIxDEMO = a2;
                    v0.K = mapleMonster;
                    a3.a = mapleMap;
                    a3.d = mapleClient;
                }
            }, 15000L);
            return true;
        }

        public /* synthetic */ dpm() {
            dpm a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return new StringBuilder().insert(0, GetMACAddress.ALLATORIxDEMO("#]3TC4C\u6e35\u8a05\u50ae\u5bd0")).toString();
        }
    }
}

