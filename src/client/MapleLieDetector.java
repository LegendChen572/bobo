/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleCharacter;
import handling.world.World;
import java.io.Serializable;
import java.util.concurrent.ScheduledFuture;
import scripting.LieDetectorScript;
import server.Timer;
import server.maps.MapleMap;
import tools.HexTool;
import tools.MaplePacketCreator;
import tools.Pair;

public class MapleLieDetector {
    public /* synthetic */ String answer;
    public /* synthetic */ int attempt;
    public /* synthetic */ ScheduledFuture<?> schedule;
    public /* synthetic */ byte type;
    public /* synthetic */ long lasttime;
    public /* synthetic */ int cid;
    public /* synthetic */ boolean inProgress;
    public /* synthetic */ boolean passed;
    public /* synthetic */ String tester;

    public final /* synthetic */ boolean startLieDetector(final String a2, final boolean a3, boolean a42) {
        MapleLieDetector a5;
        if (!a42 && (a5.isPassed() && a3 || a5.inProgress() || a5.attempt == 3)) {
            return false;
        }
        Serializable a42 = LieDetectorScript.getImageBytes();
        if (a42 == null) {
            return false;
        }
        byte[] arrby = HexTool.getByteArrayFromHexString(((Pair)a42).getLeft().toString());
        MapleLieDetector mapleLieDetector = a5;
        MapleLieDetector mapleLieDetector2 = a5;
        mapleLieDetector2.answer = ((Pair)a42).getRight().toString();
        mapleLieDetector2.tester = a2;
        mapleLieDetector.inProgress = true;
        mapleLieDetector.type = (byte)(!a3 ? 1 : 0);
        MapleLieDetector mapleLieDetector3 = a5;
        ++mapleLieDetector3.attempt;
        a42 = MapleCharacter.getOnlineCharacterById(mapleLieDetector3.cid);
        if (mapleLieDetector3.attempt < 3 && a42 != null) {
            ((MapleCharacter)a42).getClient().sendPacket(MaplePacketCreator.sendLieDetector(arrby, a5.attempt));
        }
        a5.schedule = Timer.EtcTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a22;
                1 v0 = a22;
                MapleCharacter mapleCharacter = MapleCharacter.getOnlineCharacterById(v0.MapleLieDetector.this.cid);
                if (!v0.MapleLieDetector.this.isPassed() && mapleCharacter != null) {
                    if (a22.MapleLieDetector.this.attempt >= 3) {
                        MapleCharacter mapleCharacter2 = mapleCharacter.getMap().getCharacterByName(a22.a2);
                        if (mapleCharacter2 != null && mapleCharacter2.getId() != mapleCharacter.getId()) {
                            mapleCharacter2.dropMessage(5, mapleCharacter.getName() + " \u6c92\u6709\u901a\u904e\u6e2c\u8b0a\u5668\u3002");
                        }
                        a22.MapleLieDetector.this.end();
                        MapleCharacter mapleCharacter3 = mapleCharacter;
                        mapleCharacter3.getClient().sendPacket(MaplePacketCreator.LieDetectorResponse((byte)7, (byte)0));
                        MapleMap mapleMap = mapleCharacter3.getMap().getReturnMap();
                        mapleCharacter3.changeMap(mapleMap, mapleMap.getPortal(0));
                        World.Broadcast.broadcastGMMessage(MaplePacketCreator.serverNotice(6, "[GM\u5bc6\u8a9e] \u89d2\u8272ID: " + mapleCharacter.getId() + " \u73a9\u5bb6: " + mapleCharacter.getName() + " (\u7b49\u7d1a " + mapleCharacter.getLevel() + ") \u672a\u901a\u904e\u6e2c\u8b0a\u5668\u6aa2\u6e2c\uff0c\u7591\u4f3c\u4f7f\u7528\u8173\u672c\u5916\u639b\uff01"));
                        return;
                    }
                    1 v3 = a22;
                    v3.MapleLieDetector.this.startLieDetector(v3.a2, a22.a3, true);
                }
            }
            {
                1 a32;
            }
        }, 60000L);
        return true;
    }

    public final /* synthetic */ void reset() {
        MapleLieDetector a2;
        MapleLieDetector mapleLieDetector = a2;
        MapleLieDetector mapleLieDetector2 = a2;
        a2.tester = "";
        mapleLieDetector2.answer = "";
        mapleLieDetector2.attempt = 0;
        mapleLieDetector.inProgress = 0;
        mapleLieDetector.passed = false;
    }

    public final /* synthetic */ String getTester() {
        MapleLieDetector a2;
        return a2.tester;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = 1 << 3 ^ 4;
        int n5 = n3;
        int n6 = (2 ^ 5) << 3 ^ 5;
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

    public final /* synthetic */ boolean isPassed() {
        MapleLieDetector a2;
        return a2.passed;
    }

    public final /* synthetic */ String getAnswer() {
        MapleLieDetector a2;
        return a2.answer;
    }

    public /* synthetic */ MapleLieDetector(int a2) {
        MapleLieDetector a3;
        MapleLieDetector mapleLieDetector = a3;
        mapleLieDetector.cid = a2;
        mapleLieDetector.reset();
    }

    public final /* synthetic */ void end() {
        MapleLieDetector a2;
        MapleLieDetector mapleLieDetector = a2;
        a2.inProgress = false;
        mapleLieDetector.passed = true;
        a2.attempt = 0;
        mapleLieDetector.lasttime = System.currentTimeMillis();
        if (a2.schedule != null) {
            a2.schedule.cancel(false);
            a2.schedule = null;
        }
    }

    public final /* synthetic */ boolean inProgress() {
        MapleLieDetector a2;
        return a2.inProgress;
    }

    public final /* synthetic */ int getAttempt() {
        MapleLieDetector a2;
        return a2.attempt;
    }

    public /* synthetic */ void setPassed(boolean a2) {
        a.passed = a2;
    }

    public final /* synthetic */ byte getLastType() {
        MapleLieDetector a2;
        return a2.type;
    }

    public final /* synthetic */ boolean canDetector(long a2) {
        MapleLieDetector a3;
        return a3.lasttime + 300000L > a2;
    }
}

