/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleCharacter;
import constants.GameSetConstants;
import handling.world.World;
import server.MapleAchievements;
import tools.MaplePacketCreator;

public class MapleAchievement {
    private /* synthetic */ int d;
    private /* synthetic */ String a;
    private /* synthetic */ boolean ALLATORIxDEMO;

    public /* synthetic */ void setReward(int a2) {
        a.d = a2;
    }

    public /* synthetic */ MapleAchievement(String a2, int a3, boolean a4) {
        MapleAchievement a5;
        MapleAchievement mapleAchievement = a5;
        a5.a = a2;
        mapleAchievement.d = a3;
        mapleAchievement.ALLATORIxDEMO = a4;
    }

    public /* synthetic */ boolean getNotice() {
        MapleAchievement a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void finishAchievement(MapleCharacter a2) {
        if (GameSetConstants.AchievementSystem) {
            MapleAchievement a3;
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.modifyAchievementCSPoints(2, a3.d);
            MapleAchievement mapleAchievement = a3;
            mapleCharacter.setAchievementFinished(MapleAchievements.getInstance().getByMapleAchievement(mapleAchievement));
            if (mapleAchievement.ALLATORIxDEMO && !a2.isGM()) {
                MapleAchievement mapleAchievement2 = a3;
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u6210\u5c31\u7cfb\u7d71] \u795d\u8cc0\u60a8 " + a2.getName() + " \u56e0\u70ba " + mapleAchievement2.a + " \u5f97\u5230\u4e86 " + mapleAchievement2.d + " \u9ede !"));
                return;
            }
            MapleAchievement mapleAchievement3 = a3;
            a2.getClient().sendPacket(MaplePacketCreator.serverNotice("[\u6210\u5c31\u7cfb\u7d71] \u60a8\u7372\u5f97\u4e86 " + mapleAchievement3.d + " \u9ede\u6578 \u56e0\u70ba\u60a8 " + mapleAchievement3.a + "."));
        }
    }

    public /* synthetic */ int getReward() {
        MapleAchievement a2;
        return a2.d;
    }

    public /* synthetic */ String getAchievemenName() {
        MapleAchievement a2;
        return a2.a;
    }

    public /* synthetic */ MapleAchievement(String a2, int a3) {
        MapleAchievement a4;
        MapleAchievement mapleAchievement = a4;
        a4.a = a2;
        mapleAchievement.d = a3;
        mapleAchievement.ALLATORIxDEMO = true;
    }

    public /* synthetic */ void setAchievementName(String a2) {
        a.a = a2;
    }
}

