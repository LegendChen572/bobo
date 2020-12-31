/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.MapleCharacter;
import client.MapleCoolDownValueHolder;
import constants.ServerConfig;
import handling.world.World;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import server.Randomizer;
import server.Timer;
import server.life.MobSkill;
import tools.CheckCodeImageCreator;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;

public class MapleAntiMacro {
    private static final /* synthetic */ Map<String, Long> ALLATORIxDEMO;
    public static final /* synthetic */ int SYSTEM_ANTI = 0;
    private static final /* synthetic */ Map<String, MapleAntiMacroInfo> d;
    public static final /* synthetic */ int ANTI_NOW = 3;
    public static final /* synthetic */ int NON_ATTACK = 1;
    public static final /* synthetic */ int GM_SKILL_ANTI = 2;
    public static final /* synthetic */ int CAN_ANTI = 0;
    public static final /* synthetic */ int ITEM_ANTI = 1;
    public static final /* synthetic */ int ANTI_COOLING = 2;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean startAnti(MapleCharacter a2, MapleCharacter a3, byte a4) {
        int n2 = MapleAntiMacro.getCharacterState(a3);
        switch (n2) {
            case 0: {
                break;
            }
            case 1: {
                if (a2 != null) {
                    a2.getClient().sendPacket(MaplePacketCreator.AntiMacro.nonAttack());
                }
                return false;
            }
            case 2: {
                if (a2 != null) {
                    a2.getClient().sendPacket(MaplePacketCreator.AntiMacro.alreadyPass());
                }
                return false;
            }
            case 3: {
                if (a2 != null) {
                    a2.getClient().sendPacket(MaplePacketCreator.AntiMacro.antiMacroNow());
                }
                return false;
            }
            default: {
                System.out.println("\u6e2c\u8b0a\u6a5f\u72c0\u614b\u51fa\u73fe\u672a\u77e5\u985e\u578b\uff1a" + n2);
                return false;
            }
        }
        Pair<String, File> pair = CheckCodeImageCreator.createCheckCode(Randomizer.nextInt(100) > 80);
        MapleAntiMacroInfo mapleAntiMacroInfo = new MapleAntiMacroInfo(a2, a4, pair.getLeft(), System.currentTimeMillis(), Timer.MapTimer.getInstance().schedule(() -> {
            if (d.containsKey(a3.getName())) {
                MapleAntiMacro.antiFailure(a3);
            }
        }, 60000L));
        d.put(a3.getName(), mapleAntiMacroInfo);
        a3.getClient().sendPacket(MaplePacketCreator.AntiMacro.getImage(a4, pair.getRight(), mapleAntiMacroInfo.getTimesLeft()));
        pair.getRight().delete();
        if (a2 != null) {
            a2.getClient().sendPacket(MaplePacketCreator.AntiMacro.antiMsg(a4, a3.getName()));
        }
        return true;
    }

    public static /* synthetic */ boolean isCooling(String a2) {
        if (ALLATORIxDEMO.containsKey(a2)) {
            if (System.currentTimeMillis() - ALLATORIxDEMO.get(a2) < 1800000L) {
                return true;
            }
            ALLATORIxDEMO.remove(a2);
        }
        return false;
    }

    public static /* synthetic */ void antiReduce(MapleCharacter a2) {
        if (d.containsKey(a2.getName())) {
            if (d.get(a2.getName()).antiFailure() > 0) {
                MapleAntiMacro.refreshCode(a2);
                return;
            }
            MapleAntiMacro.antiFailure(a2);
        }
    }

    public static /* synthetic */ boolean verifyCode(String a2, String a3) {
        if (!d.containsKey(a2)) {
            return false;
        }
        return d.get(a2).getCode().equalsIgnoreCase(a3);
    }

    public static /* synthetic */ {
        d = new HashMap<String, MapleAntiMacroInfo>();
        ALLATORIxDEMO = new HashMap<String, Long>();
    }

    public static /* synthetic */ void antiSuccess(MapleCharacter a2) {
        MapleAntiMacroInfo mapleAntiMacroInfo = null;
        if (d.containsKey(a2.getName())) {
            MapleCharacter mapleCharacter;
            mapleAntiMacroInfo = d.get(a2.getName());
            if (mapleAntiMacroInfo.antiMode() == 1) {
                a2.gainMeso(5000, true);
            }
            if ((mapleCharacter = mapleAntiMacroInfo.getSourcePlayer()) != null) {
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.AntiMacro.successMsg(2, a2.getName()));
            }
        }
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.setAntiMacroFailureTimes(0);
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.AntiMacro.success(mapleAntiMacroInfo == null ? 0 : mapleAntiMacroInfo.antiMode()));
        MapleAntiMacro.stopAnti(a2.getName());
        ALLATORIxDEMO.put(a2.getName(), System.currentTimeMillis());
    }

    public static /* synthetic */ void refreshCode(MapleCharacter a2) {
        if (d.containsKey(a2.getName())) {
            MapleAntiMacroInfo mapleAntiMacroInfo = d.get(a2.getName());
            Pair<String, File> pair = CheckCodeImageCreator.createCheckCode(Randomizer.nextInt(100) > 80);
            mapleAntiMacroInfo.setCode(pair.getLeft());
            mapleAntiMacroInfo.setSchedule(Timer.MapTimer.getInstance().schedule(() -> {
                if (d.containsKey(a2.getName())) {
                    MapleAntiMacro.antiFailure(a2);
                }
            }, 60000L));
            a2.getClient().sendPacket(MaplePacketCreator.AntiMacro.getImage((byte)mapleAntiMacroInfo.antiMode(), pair.getRight(), mapleAntiMacroInfo.getTimesLeft()));
            pair.getRight().delete();
        }
    }

    public static /* synthetic */ void antiFailure(MapleCharacter a2) {
        MapleCharacter mapleCharacter;
        Serializable serializable;
        MapleAntiMacroInfo mapleAntiMacroInfo = null;
        if (d.containsKey(a2.getName()) && (serializable = (mapleAntiMacroInfo = d.get(a2.getName())).getSourcePlayer()) != null && mapleAntiMacroInfo.antiMode() == 2) {
            ((MapleCharacter)serializable).getClient().sendPacket(MaplePacketCreator.AntiMacro.failureScreenshot(a2.getName()));
        }
        if (a2.addAntiMacroFailureTimes() < 5) {
            MapleCharacter mapleCharacter2 = a2;
            mapleCharacter2.changeMap(mapleCharacter2.getMap().getReturnMap().getId());
            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.AntiMacro.failure(mapleAntiMacroInfo == null ? 0 : mapleAntiMacroInfo.antiMode()));
            mapleCharacter = a2;
        } else {
            MapleCharacter mapleCharacter3 = a2;
            mapleCharacter3.setAntiMacroFailureTimes(0);
            serializable = Calendar.getInstance();
            ((Calendar)serializable).add(5, 7);
            mapleCharacter3.tempban(MapleCoolDownValueHolder.ALLATORIxDEMO("\u6e77\u8b29\u6a04\u9000\u7ed7\u5912\u650c\u0016\u6b7a\u3021"), (Calendar)serializable, 1, false);
            mapleCharacter3.getClient().getSession().close();
            a2.getClient().disconnect();
            if (ServerConfig.LOG_DC) {
                FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005nK^K\u0005ni\u0004^R^"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
            }
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e] " + a2.getName() + "  \u56e0\u70ba\u6e2c\u8b0a\u6a5f\u9023\u7e8c\u5931\u65575\u6b21\u800c\u88ab\u5c01\u9396\u4e00\u500b\u79ae\u62dc\u3002"));
            mapleCharacter = a2;
        }
        MapleAntiMacro.stopAnti(mapleCharacter.getName());
    }

    public static /* synthetic */ boolean isAntiNow(String a2) {
        return d.containsKey(a2) && System.currentTimeMillis() - d.get(a2).getStartTime() < 60000L;
    }

    public static /* synthetic */ void stopAnti(String a2) {
        if (d.containsKey(a2)) {
            d.get(a2).cancelSchedule();
        }
        d.remove(a2);
    }

    public /* synthetic */ MapleAntiMacro() {
        MapleAntiMacro a2;
    }

    public static /* synthetic */ int getCharacterState(MapleCharacter a2) {
        if (MapleAntiMacro.isCooling(a2.getName())) {
            return 2;
        }
        if (MapleAntiMacro.isAntiNow(a2.getName())) {
            return 3;
        }
        return 0;
    }

    public static class MapleAntiMacroInfo {
        private final /* synthetic */ int k;
        private final /* synthetic */ MapleCharacter B;
        private /* synthetic */ ScheduledFuture<?> d;
        private final /* synthetic */ long a;
        private /* synthetic */ int ALLATORIxDEMO;
        private /* synthetic */ String K;

        public /* synthetic */ void setSchedule(ScheduledFuture<?> a2) {
            MapleAntiMacroInfo a3;
            a3.cancelSchedule();
            a3.d = a2;
        }

        public /* synthetic */ void setCode(String a2) {
            a.K = a2;
        }

        public /* synthetic */ void cancelSchedule() {
            MapleAntiMacroInfo a2;
            if (a2.d != null) {
                a2.d.cancel(false);
            }
        }

        public /* synthetic */ MapleCharacter getSourcePlayer() {
            MapleAntiMacroInfo a2;
            return a2.B;
        }

        public /* synthetic */ long getStartTime() {
            MapleAntiMacroInfo a2;
            return a2.a;
        }

        public /* synthetic */ int getTimesLeft() {
            MapleAntiMacroInfo a2;
            return a2.ALLATORIxDEMO - 1;
        }

        public /* synthetic */ int antiMode() {
            MapleAntiMacroInfo a2;
            return a2.k;
        }

        public /* synthetic */ String getCode() {
            MapleAntiMacroInfo a2;
            return a2.K;
        }

        public /* synthetic */ int antiFailure() {
            MapleAntiMacroInfo a2;
            return --a2.ALLATORIxDEMO;
        }

        public /* synthetic */ MapleAntiMacroInfo(MapleCharacter a2, int a3, String a4, long a5, ScheduledFuture<?> a6) {
            MapleAntiMacroInfo a7;
            MapleAntiMacroInfo mapleAntiMacroInfo = a7;
            MapleAntiMacroInfo mapleAntiMacroInfo2 = a7;
            MapleAntiMacroInfo mapleAntiMacroInfo3 = a7;
            mapleAntiMacroInfo3.ALLATORIxDEMO = 2;
            mapleAntiMacroInfo3.B = a2;
            mapleAntiMacroInfo2.k = a3;
            mapleAntiMacroInfo2.K = a4;
            mapleAntiMacroInfo.a = a5;
            mapleAntiMacroInfo.d = a6;
        }
    }
}

