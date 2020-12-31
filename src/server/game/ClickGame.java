/*
 * Decompiled with CFR 0.150.
 */
package server.game;

import client.MapleCharacter;
import java.awt.Point;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import tools.MaplePacketCreator;

public class ClickGame {
    public /* synthetic */ ClickGame() {
        ClickGame a2;
    }

    public static /* synthetic */ void ClickPlayer(MapleCharacter a2, MapleCharacter a3) {
        if (a2.canSpeak() && a2.getParty() != null && a3.getParty() != null && a2 != a3) {
            MapleCharacter mapleCharacter;
            int n2 = (int)((double)a3.getMaxHp() * 0.1);
            if (a2.getPartyId() != a3.getPartyId()) {
                MapleMonster mapleMonster = MapleLifeFactory.getMonster(9001007);
                MapleCharacter mapleCharacter2 = a3;
                MapleCharacter mapleCharacter3 = a3;
                mapleCharacter2.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.damageFriendlyMob(mapleMonster, n2, true), false);
                mapleCharacter2.getClient().sendPacket(MaplePacketCreator.damagePlayer(a2.getId(), 1, n2, mapleMonster.getId(), (byte)(false ? 1 : 0), false ? 1 : 0, false ? 1 : 0, false, 0, (byte)0, new Point((int)mapleMonster.getPosition().getX(), (int)mapleMonster.getPosition().getY()), (byte)0, 0, 0));
                mapleCharacter3.getMap().broadcastMessage(a3, MaplePacketCreator.damagePlayer(a2.getId(), 1, n2, mapleMonster.getId(), (byte)(false ? 1 : 0), false ? 1 : 0, false ? 1 : 0, false, 0, (byte)0, new Point((int)mapleMonster.getPosition().getX(), (int)mapleMonster.getPosition().getY()), (byte)0, 0, 0), false);
                if (!mapleCharacter2.isInvincible()) {
                    a3.addHP(-n2);
                }
                a2.dropMessageAll("\u60a8\u5df2\u5c0d\u73a9\u5bb6:" + a3.getName() + " \u767c\u52d5\u653b\u64ca\u6210\u529f \u73a9\u5bb6\u5269\u9918\u8840\u91cf:" + a3.getHp() + "!");
                a3.dropMessageAll("\u6575\u5c0d\u73a9\u5bb6:" + a2.getName() + " \u7121\u60c5\u7684\u5c0d\u4f60\u767c\u52d5\u4e86\u653b\u64ca!");
                mapleCharacter = a2;
            } else {
                a3.addHP(n2);
                a2.dropMessageAll("\u60a8\u5df2\u5c0d\u73a9\u5bb6:" + a3.getName() + " \u88dc\u8840\u653b\u64ca\u6210\u529f \u73a9\u5bb6\u5269\u9918\u8840\u91cf:" + a3.getHp() + "!");
                a3.dropMessageAll("\u540c\u968a\u968a\u53cb:" + a2.getName() + " \u71b1\u60c5\u7684\u5e6b\u4f60\u9032\u884c\u4e86\u88dc\u8840!");
                mapleCharacter = a2;
            }
            mapleCharacter.setSpeakTime();
        }
    }
}

