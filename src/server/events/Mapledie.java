/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import client.MapleCharacter;
import client.MapleStat;
import client.messages.commands.GMCommand;
import handling.channel.handler.PlayerHandler;
import handling.world.CharacterIdChannelPair;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import server.StructSetItem;
import server.Timer;
import server.events.MapleEvent;
import server.maps.MapleMap;
import tools.MaplePacketCreator;

public class Mapledie
extends MapleEvent {
    private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;
    private /* synthetic */ ScheduledFuture<?> d;
    private /* synthetic */ int a;
    private /* synthetic */ int K;

    private /* synthetic */ void ALLATORIxDEMO() {
        Mapledie a2;
        if (a2.ALLATORIxDEMO != null) {
            a2.ALLATORIxDEMO.cancel(false);
            a2.ALLATORIxDEMO = null;
        }
        if (a2.d != null) {
            a2.d.cancel(false);
            a2.d = null;
        }
    }

    @Override
    public /* synthetic */ void unreset() {
        Mapledie a2;
        Mapledie mapledie = a2;
        super.unreset();
        mapledie.getMap(0).getPortal(GMCommand.ALLATORIxDEMO("X\r[\f\u0002R")).setPortalState(true);
        mapledie.ALLATORIxDEMO();
    }

    @Override
    public /* synthetic */ void startEvent() {
        Mapledie a2;
        a2.a = (int)(Math.random() * 6.0) + 1;
        a2.startgod();
    }

    @Override
    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
        Mapledie a3;
        a2.setLifeRandom();
        a3.getMap(0).broadcastMessage(MaplePacketCreator.musicChange(GMCommand.ALLATORIxDEMO("p\u0005_S\u0004Mf\u000b_\u0007f\u0007_\u0012^\u0007")));
    }

    private /* synthetic */ boolean ALLATORIxDEMO(MapleCharacter a2) {
        Mapledie a3;
        if (a2.getLifeRandom() > a3.a) {
            a2.dropMessage(6, CharacterIdChannelPair.ALLATORIxDEMO("\u6037\u55ed\u60f2\u88da\u7904\u9009\u4e50\uff70"));
            return true;
        }
        a2.dropMessage(6, GMCommand.ALLATORIxDEMO("\u5fea\u6283\u6b2b\u609a\u88c9\u796c\u62a9\u68f6\u4ee4\u3030\u3060"));
        return false;
    }

    public /* synthetic */ Mapledie(int a2, int a3, int[] a4) {
        Mapledie a5;
        Mapledie mapledie = a5;
        super(a2, a3, a4);
        mapledie.K = 0;
        mapledie.a = 0;
    }

    public /* synthetic */ void startgod(final MapleMap a2) {
        Mapledie a3;
        if (a3.d != null) {
            a3.d.cancel(false);
        }
        a3.d = Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                var a22;
                if (a22.Mapledie.this.K == 1) {
                    var v0 = a22;
                    v0.a2.broadcastMessage(MaplePacketCreator.getItemNotice(PlayerHandler.ALLATORIxDEMO("\u677e\u6b34\u6d69\u52c0\u5da0\u7d86\u7d02\u674a\uff53")));
                    v0.Mapledie.this.unreset();
                    for (MapleCharacter mapleCharacter : v0.a2.getCharactersThreadsafe()) {
                        if (mapleCharacter == null || !mapleCharacter.isAlive()) continue;
                        var v1 = a22;
                        v1.Mapledie.this.givePrize(mapleCharacter);
                        v1.Mapledie.this.warpBack(mapleCharacter);
                    }
                    return;
                }
                var v2 = a22;
                v2.Mapledie.this.broadcast(MaplePacketCreator.serverNotice(StructSetItem.ALLATORIxDEMO("\u6d5f\u52f3\u5d96\u7db5\u95ef\u59ed\uff68\u0017T\u79f4\u5fe8\u5c17\u7781\u9075\u7d34\u67baE\u0007")));
                v2.a2.broadcastMessage(MaplePacketCreator.getClock(10));
                if (v2.Mapledie.this.ALLATORIxDEMO != null) {
                    a22.Mapledie.this.ALLATORIxDEMO.cancel(false);
                }
                a22.Mapledie.this.ALLATORIxDEMO = Timer.EventTimer.getInstance().schedule(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        1 a2;
                        a2.Mapledie.this.K++;
                        Iterator<MapleCharacter> iterator = a2.a2.getCharactersThreadsafe().iterator();
                        while (iterator.hasNext()) {
                            MapleCharacter mapleCharacter = iterator.next();
                            if (mapleCharacter == null || !mapleCharacter.isAlive() || a2.Mapledie.this.ALLATORIxDEMO(mapleCharacter)) continue;
                            mapleCharacter.getStat().setHp(0);
                            mapleCharacter.updateSingleStat(MapleStat.HP, 0);
                        }
                        a2.Mapledie.this.startgod();
                    }
                    {
                        1 a3;
                    }
                }, 10000L);
            }
            {
                1 a3;
            }
        }, 10000L);
    }

    @Override
    public /* synthetic */ void reset() {
        Mapledie a2;
        Mapledie mapledie = a2;
        super.reset();
        mapledie.getMap(0).getPortal(CharacterIdChannelPair.ALLATORIxDEMO("0\u001e3\u001fjA")).setPortalState(false);
        mapledie.ALLATORIxDEMO();
        mapledie.K = 0;
    }

    public /* synthetic */ void startgod() {
        Mapledie a2;
        Mapledie mapledie = a2;
        mapledie.startgod(mapledie.getMap(0));
    }
}

