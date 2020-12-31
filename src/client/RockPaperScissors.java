/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleClient;
import handling.world.World;
import server.MapleInventoryManipulator;
import server.Randomizer;
import tools.MaplePacketCreator;

public class RockPaperScissors {
    private /* synthetic */ boolean a;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ boolean d;
    private /* synthetic */ int K;

    public final /* synthetic */ void reward(MapleClient a2) {
        MapleClient mapleClient;
        RockPaperScissors a3;
        RockPaperScissors rockPaperScissors = a3;
        int n2 = rockPaperScissors.K + 1;
        if (rockPaperScissors.d) {
            MapleClient mapleClient2 = a2;
            MapleInventoryManipulator.addById(mapleClient2, 4031332 + a3.K, (short)1, "", null, 0L);
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u300e\u731c\u62f3PK\u300f" + mapleClient2.getPlayer().getName() + "\u5f9e\u731c\u62f3\u738b\u8d0f\u5f97\u4e86" + n2 + "\u5834\u52dd\u5229\uff01"));
            mapleClient = a2;
        } else {
            if (a3.K == 0 && a3.ALLATORIxDEMO) {
                a2.getPlayer().gainMeso(500, true, true, true);
            }
            mapleClient = a2;
        }
        mapleClient.getPlayer().setRPS(null);
    }

    public final /* synthetic */ void dispose(MapleClient a2) {
        RockPaperScissors a3;
        MapleClient mapleClient = a2;
        a3.reward(mapleClient);
        mapleClient.sendPacket(MaplePacketCreator.getRPSMode((byte)13, -1, -1, -1));
    }

    public /* synthetic */ RockPaperScissors(MapleClient a2, byte a3) {
        RockPaperScissors a4;
        RockPaperScissors rockPaperScissors = a4;
        RockPaperScissors rockPaperScissors2 = a4;
        rockPaperScissors2.K = 0;
        rockPaperScissors2.a = true;
        rockPaperScissors.d = false;
        rockPaperScissors.ALLATORIxDEMO = false;
        byte by = a3;
        a2.sendPacket(MaplePacketCreator.getRPSMode((byte)(9 + by), -1, -1, -1));
        if (by == 0) {
            a2.getPlayer().gainMeso(-1000, true, true, true);
        }
    }

    public final /* synthetic */ boolean answer(MapleClient a2, int a3) {
        RockPaperScissors a4;
        if (a4.a && !a4.d && a3 >= 0 && a3 <= 2) {
            a4.ALLATORIxDEMO = true;
            int n2 = Randomizer.nextInt(3);
            if (n2 == a3) {
                a2.sendPacket(MaplePacketCreator.getRPSMode((byte)11, -1, (byte)n2, (byte)a4.K));
            } else if (a3 == 0 && n2 == 2 || a3 == 1 && n2 == 0 || a3 == 2 && n2 == 1) {
                a2.sendPacket(MaplePacketCreator.getRPSMode((byte)11, -1, (byte)n2, (byte)(a4.K + 1)));
                RockPaperScissors rockPaperScissors = a4;
                rockPaperScissors.a = false;
                rockPaperScissors.d = true;
            } else {
                a2.sendPacket(MaplePacketCreator.getRPSMode((byte)11, -1, (byte)n2, -1));
                a4.a = false;
            }
            return true;
        }
        a4.reward(a2);
        return false;
    }

    public final /* synthetic */ boolean nextRound(MapleClient a2) {
        RockPaperScissors a3;
        if (a3.d) {
            RockPaperScissors rockPaperScissors = a3;
            ++rockPaperScissors.K;
            if (rockPaperScissors.K < 10) {
                RockPaperScissors rockPaperScissors2 = a3;
                rockPaperScissors2.d = false;
                rockPaperScissors2.a = true;
                a2.sendPacket(MaplePacketCreator.getRPSMode((byte)12, -1, -1, -1));
                return true;
            }
        }
        a3.reward(a2);
        return false;
    }

    public final /* synthetic */ boolean timeOut(MapleClient a2) {
        RockPaperScissors a3;
        if (a3.a && !a3.d) {
            a3.a = false;
            a2.sendPacket(MaplePacketCreator.getRPSMode((byte)10, -1, -1, -1));
            return true;
        }
        a3.reward(a2);
        return false;
    }
}

