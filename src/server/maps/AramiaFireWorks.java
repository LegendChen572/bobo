/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import constants.GameSetConstants;
import constants.ServerSet;
import handling.world.World;
import java.awt.Point;
import server.RandomRewards;
import server.Randomizer;
import server.Timer;
import server.characterCards.MapleCharacterCards;
import server.life.MapleLifeFactory;
import server.maps.MapleMap;
import server.maps.MapleReactor;
import tools.MaplePacketCreator;

public class AramiaFireWorks {
    public static final /* synthetic */ int SUN_ID = 4001246;
    private static final /* synthetic */ int ALLATORIxDEMO = 149;
    private /* synthetic */ short e;
    public static /* synthetic */ int MAX_DEC;
    public static /* synthetic */ int MAX_KEGS;
    private static final /* synthetic */ AramiaFireWorks g;
    public static final /* synthetic */ int KEG_ID = 4031875;
    private static final /* synthetic */ int[] K;
    private static final /* synthetic */ int[] k;
    private /* synthetic */ int E;
    public static final /* synthetic */ int DEC_ID = 4001473;
    private static final /* synthetic */ int[] d;
    public static /* synthetic */ int MAX_SUN;
    private static final /* synthetic */ int[] B;
    private static final /* synthetic */ int[] a;
    public static final /* synthetic */ int XIANG_ID = 4000516;

    private /* synthetic */ void l(final MapleCharacter a2) {
        AramiaFireWorks a3;
        a3.ALLATORIxDEMO(a2, 4000516);
        Timer.EventTimer.getInstance().schedule(new Runnable(){
            {
                1 a3;
            }

            @Override
            public final /* synthetic */ void run() {
                1 a22;
                1 v0 = a22;
                v0.AramiaFireWorks.this.I(v0.a2.getClient().getChannelServer().getMapFactory().getMap(741000000));
            }
        }, 10000L);
    }

    private /* synthetic */ void H(final MapleCharacter a2) {
        AramiaFireWorks a3;
        a3.ALLATORIxDEMO(a2, 4001246);
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public final /* synthetic */ void run() {
                3 a22;
                3 v0 = a22;
                v0.AramiaFireWorks.this.D(v0.a2.getClient().getChannelServer().getMapFactory().getMap(970010000));
            }
            {
                3 a3;
            }
        }, 10000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void giveSuns(MapleCharacter a2, int a32) {
        int n2 = (int)ServerSet.getServerSet(Timer.ALLATORIxDEMO("\u6933\u6a2d\u5c11\u4e0c\u7d4f\u7a59"));
        n2 += a32;
        ServerSet.gainServerSet(MapleCharacterCards.ALLATORIxDEMO("\u6907\u6a35\u5c25\u4e14\u7d7b\u7a41"), a32);
        MapleMap mapleMap = a2.getClient().getChannelServer().getMapFactory().getMap(970010000);
        MapleReactor mapleReactor = mapleMap.getReactorByName(Timer.ALLATORIxDEMO("y\u0001d\fq4f\u0005q"));
        try {
            a32 += MAX_SUN / 6;
            while (a32 > 0) {
                int n3;
                block8: {
                    switch (mapleReactor.getState()) {
                        case 0: 
                        case 1: 
                        case 2: 
                        case 3: 
                        case 4: {
                            if (n2 < MAX_SUN / 6 * (2 + mapleReactor.getState())) break;
                            n3 = a32;
                            MapleReactor mapleReactor2 = mapleReactor;
                            mapleReactor2.setState((byte)(mapleReactor.getState() + 1));
                            mapleReactor2.setTimerActive(false);
                            mapleMap.broadcastMessage(MaplePacketCreator.triggerReactor(mapleReactor2, mapleReactor.getState()));
                            break block8;
                        }
                        default: {
                            if (n2 < MAX_SUN / 6) break;
                            mapleMap.resetReactors();
                        }
                    }
                    n3 = a32;
                }
                a32 = n3 - MAX_SUN / 6;
            }
        }
        catch (Exception a32) {
            System.out.println(a32);
        }
        if (n2 >= MAX_SUN) {
            AramiaFireWorks a4;
            ServerSet.setServerSet(MapleCharacterCards.ALLATORIxDEMO("\u6907\u6a35\u5c25\u4e14\u7d7b\u7a41"), 0L);
            a4.H(a2);
        }
    }

    public /* synthetic */ AramiaFireWorks() {
        AramiaFireWorks a2;
        a2.e = 0;
        a2.E = MAX_DEC / 6;
    }

    public final /* synthetic */ short getDecsPercentage() {
        AramiaFireWorks a2;
        return (short)(a2.E / MAX_DEC * 10000);
    }

    private /* synthetic */ void D(final MapleMap a2) {
        int n2;
        a2.startMapEffect(MapleCharacterCards.ALLATORIxDEMO("\u9671\u511d\u6b6f\u577c\u7db7\u656a\uff0d"), 5121010);
        int n3 = n2 = 0;
        while (n3 < 3) {
            AramiaFireWorks a3;
            int n4 = n2 * 10000;
            Timer.EventTimer.getInstance().schedule(new Runnable(){
                {
                    4 a3;
                }

                @Override
                public final /* synthetic */ void run() {
                    4 a22;
                    4 v0 = a22;
                    v0.AramiaFireWorks.this.l(v0.a2);
                }
            }, 5000 + n4);
            n3 = ++n2;
        }
    }

    private /* synthetic */ void I(final MapleMap a2) {
        AramiaFireWorks a3;
        a2.startMapEffect(MapleCharacterCards.ALLATORIxDEMO("\u53bb\u4ee9\u9066\u8840\u65e4\u5e78\u6d6f\u52d9\u76d0\u8864\u6f40\u4e8a\uff55\uff0d"), 5121020);
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public final /* synthetic */ void run() {
                2 a22;
                2 v0 = a22;
                v0.AramiaFireWorks.this.E(v0.a2);
            }
            {
                2 a3;
            }
        }, 5000L);
    }

    public final /* synthetic */ short getSunsPercentage() {
        return (short)((int)ServerSet.getServerSet(Timer.ALLATORIxDEMO("\u6933\u6a2d\u5c11\u4e0c\u7d4f\u7a59")) * 100 / MAX_SUN);
    }

    private final /* synthetic */ void H(final MapleMap a2) {
        int n2;
        a2.startMapEffect(MapleCharacterCards.ALLATORIxDEMO("\u8002\u8a99\u6a6d\u6b6f\u577c\u7db7\u656a\uff0d"), 5120000);
        int n3 = n2 = 0;
        while (n3 < 3) {
            AramiaFireWorks a3;
            int n4 = n2 * 10000;
            Timer.EventTimer.getInstance().schedule(new Runnable(){

                @Override
                public final /* synthetic */ void run() {
                    6 a22;
                    6 v0 = a22;
                    v0.AramiaFireWorks.this.ALLATORIxDEMO(v0.a2);
                }
                {
                    6 a3;
                }
            }, 5000 + n4);
            n3 = ++n2;
        }
    }

    private final /* synthetic */ void ALLATORIxDEMO(MapleMap a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < Randomizer.nextInt(10) + 40) {
            Point point;
            int n4;
            Point point2 = new Point(Randomizer.nextInt(800) - 400, 149);
            if (Randomizer.nextInt(15) == 1) {
                n4 = 2060006;
                point = point2;
            } else {
                n4 = 2060006;
                point = point2;
            }
            a2.spawnAutoDrop(n4, point);
            n3 = ++n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void giveKegs(MapleCharacter a2, int a3) {
        AramiaFireWorks aramiaFireWorks;
        AramiaFireWorks a4;
        AramiaFireWorks aramiaFireWorks2 = a4;
        aramiaFireWorks2.e = (short)(aramiaFireWorks2.e + a3);
        switch (aramiaFireWorks2.e) {
            case 1000: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 1500: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 2000: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 2500: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 3000: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 3500: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 4000: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 4500: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
                aramiaFireWorks = a4;
                break;
            }
            case 4999: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u9032\u5ea6\u76ee\u524d\u662f5000/" + a4.e + "\uff01\uff01"));
            }
            default: {
                aramiaFireWorks = a4;
            }
        }
        if (aramiaFireWorks.e >= MAX_KEGS) {
            a4.e = 0;
            a4.l(a2);
        }
    }

    private final /* synthetic */ void ALLATORIxDEMO(final MapleCharacter a2) {
        AramiaFireWorks a3;
        a3.ALLATORIxDEMO(a2, 4001473);
        Timer.EventTimer.getInstance().schedule(new Runnable(){
            {
                5 a3;
            }

            @Override
            public final /* synthetic */ void run() {
                5 a22;
                5 v0 = a22;
                v0.AramiaFireWorks.this.H(v0.a2.getClient().getChannelServer().getMapFactory().getMap(555000000));
            }
        }, 10000L);
    }

    public static /* synthetic */ {
        MAX_KEGS = 5000;
        MAX_SUN = GameSetConstants.SERVER_NAME.equals(Timer.ALLATORIxDEMO("\u6064\u6010\u8c23")) ? 2000 : 14000;
        MAX_DEC = 18000;
        g = new AramiaFireWorks();
        int[] arrn = new int[1];
        arrn[0] = 9410066;
        B = arrn;
        int[] arrn2 = new int[1];
        arrn2[0] = -255;
        k = arrn2;
        int[] arrn3 = new int[1];
        arrn3[0] = 340;
        K = arrn3;
        int[] arrn4 = new int[16];
        arrn4[0] = 720;
        arrn4[1] = 180;
        arrn4[2] = 630;
        arrn4[3] = 270;
        arrn4[4] = 360;
        arrn4[5] = 540;
        arrn4[6] = 450;
        arrn4[7] = 142;
        arrn4[8] = 142;
        arrn4[9] = 218;
        arrn4[10] = 772;
        arrn4[11] = 810;
        arrn4[12] = 848;
        arrn4[13] = 232;
        arrn4[14] = 308;
        arrn4[15] = 142;
        a = arrn4;
        int[] arrn5 = new int[16];
        arrn5[0] = 1234;
        arrn5[1] = 1234;
        arrn5[2] = 1174;
        arrn5[3] = 1234;
        arrn5[4] = 1174;
        arrn5[5] = 1174;
        arrn5[6] = 1174;
        arrn5[7] = 1260;
        arrn5[8] = 1234;
        arrn5[9] = 1234;
        arrn5[10] = 1234;
        arrn5[11] = 1234;
        arrn5[12] = 1234;
        arrn5[13] = 1114;
        arrn5[14] = 1114;
        arrn5[15] = 1140;
        d = arrn5;
    }

    private /* synthetic */ void l(MapleMap a2) {
        int n2;
        boolean bl = RandomRewards.getInstance().getAramiaFireWorks().size() == 0;
        int n3 = n2 = 0;
        while (n3 < Randomizer.nextInt(5) + 10) {
            Point point = new Point(a[n2], d[n2]);
            if (bl) {
                a2.spawnAutoDrop(RandomRewards.getInstance().getStartSunReward(), point);
            } else {
                a2.spawnAutoDrop(RandomRewards.getInstance().getAramiaFireWorkReward(), point);
            }
            n3 = ++n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, int a3) {
        switch (a3) {
            case 4000516: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u4e0d\u591c\u57ce\u65b0\u5e74\u6d3b\u52d5\u5373\u5c07\u958b\u59cb\u8209\u8fa6\u602a\u7269\u5927\u904a\u884c\uff01\uff01", a3));
                return;
            }
            case 4001246: {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("<\u983b\u9053 " + a2.getClient().getChannel() + "> \u967d\u5149\u6b63\u5728\u7dbb\u653e,\u6953\u6a39\u5c71\u4e18\u6210\u9577\u8301\u58ef\uff01\uff01", a3));
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void giveDecs(MapleCharacter a2, int a3) {
        AramiaFireWorks a4;
        a4.E += a3;
        MapleMap mapleMap = a2.getClient().getChannelServer().getMapFactory().getMap(555000000);
        MapleReactor mapleReactor = mapleMap.getReactorByName(Timer.ALLATORIxDEMO("8y\u0001g4f\u0005q"));
        int n2 = a3 = a3 + MAX_DEC / 6;
        while (n2 > 0) {
            int n3;
            block5: {
                switch (mapleReactor.getState()) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        if (a4.E < MAX_DEC / 6 * (2 + mapleReactor.getState())) break;
                        n3 = a3;
                        MapleReactor mapleReactor2 = mapleReactor;
                        mapleReactor2.setState((byte)(mapleReactor.getState() + 1));
                        mapleReactor2.setTimerActive(false);
                        mapleMap.broadcastMessage(MaplePacketCreator.triggerReactor(mapleReactor2, mapleReactor.getState()));
                        break block5;
                    }
                    default: {
                        if (a4.E < MAX_DEC / 6) break;
                        mapleMap.resetReactors();
                    }
                }
                n3 = a3;
            }
            n2 = n3 - MAX_DEC / 6;
        }
        if (a4.E >= MAX_DEC) {
            a4.E = 0;
            a4.ALLATORIxDEMO(a2);
        }
    }

    public static final /* synthetic */ AramiaFireWorks getInstance() {
        return g;
    }

    public final /* synthetic */ short getKegsPercentage() {
        AramiaFireWorks a2;
        return (short)((double)a2.e * 1.0 / ((double)MAX_KEGS * 1.0) * 100.0);
    }

    private /* synthetic */ void E(MapleMap a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < B.length) {
            Point point = new Point(k[n2], K[n2]);
            int n4 = B[n2];
            a2.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(n4), point);
            n3 = ++n2;
        }
    }
}

