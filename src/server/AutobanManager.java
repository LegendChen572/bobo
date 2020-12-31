/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleClient;
import constants.GameSetConstants;
import handling.channel.handler.PlayersHandler;
import handling.world.World;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import server.life.MobSkill;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

public class AutobanManager
implements Runnable {
    private /* synthetic */ Map<Integer, List<String>> k;
    private /* synthetic */ Set<ExpirationEntry> K;
    private /* synthetic */ Map<Integer, Integer> B;
    private static /* synthetic */ AutobanManager d;
    private static final /* synthetic */ int a = 5000;
    private final /* synthetic */ ReentrantLock ALLATORIxDEMO;

    public static /* synthetic */ {
        d = new AutobanManager();
    }

    @Override
    public final /* synthetic */ void run() {
        AutobanManager a2;
        long l2 = System.currentTimeMillis();
        for (ExpirationEntry expirationEntry : a2.K) {
            if (expirationEntry.time <= l2) {
                a2.B.put(expirationEntry.acc, a2.B.get(expirationEntry.acc) - expirationEntry.points);
                continue;
            }
            return;
        }
    }

    public static final /* synthetic */ AutobanManager getInstance() {
        return d;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void addPoints(MapleClient a2, int a3, long a4, String a5) {
        AutobanManager a6;
        a6.ALLATORIxDEMO.lock();
        try {
            AutobanManager autobanManager;
            Object object;
            int n2 = a2.getPlayer().getAccountID();
            if (a6.B.containsKey(n2)) {
                int n3 = a6.B.get(n2);
                if (n3 >= 5000) {
                    return;
                }
                AutobanManager autobanManager2 = a6;
                autobanManager2.B.put(n2, n3 + a3);
                object = autobanManager2.k.get(n2);
                autobanManager = a6;
                object.add(a5);
            } else {
                AutobanManager autobanManager3 = a6;
                autobanManager = autobanManager3;
                autobanManager3.B.put(n2, a3);
                object = new LinkedList<String>();
                object.add(a5);
                a6.k.put(n2, (List<String>)object);
            }
            if (autobanManager.B.get(n2) >= 5000) {
                if (a2.getPlayer().isGM() || a2.getPlayer().isClone()) {
                    a2.getPlayer().dropMessage(5, "[\u8b66\u544a] A/b \u89f8\u767c \u539f\u56e0 : " + (String)a5);
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder(MobSkill.ALLATORIxDEMO("K\u0005H\n"));
                stringBuilder.append(a2.getPlayer().getName());
                stringBuilder.append(PlayersHandler.ALLATORIxDEMO("&\u0002Oz&"));
                stringBuilder.append(a2.getSession().remoteAddress().toString());
                stringBuilder.append(MobSkill.ALLATORIxDEMO("\u0003\u0010\n"));
                stringBuilder.append(PlayersHandler.ALLATORIxDEMO("\n.gGi&"));
                stringBuilder.append(a2.getMacs());
                stringBuilder.append(MobSkill.ALLATORIxDEMO("\u0003\u0010\n"));
                Object object2 = a5 = a6.k.get(n2).iterator();
                while (object2.hasNext()) {
                    object = (String)a5.next();
                    object2 = a5;
                    stringBuilder.append((String)object);
                    stringBuilder.append(PlayersHandler.ALLATORIxDEMO("\u0006&"));
                }
                if (GameSetConstants.AUTOBAN) {
                    FileoutputUtil.logToFile(MobSkill.ALLATORIxDEMO("FEMY\u0005bKIA\u0005hKD\u0005k_^EhKD\u0004^R^"), "\r\n" + FileoutputUtil.NowTime() + "\u73a9\u5bb6: " + a2.getPlayer().getName() + " \u56e0\u70ba " + stringBuilder + " \u800c\u88ab\u7cfb\u7d71\u5c01\u9396");
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.serverNotice("[GM\u5bc6\u8a9e] " + a2.getPlayer().getName() + "\u56e0\u70ba\u4f7f\u7528" + stringBuilder + "\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
                    World.Broadcast.broadcastMessage(MaplePacketCreator.serverNotice("[\u5c01\u9396\u7cfb\u7d71] " + a2.getPlayer().getName() + "\u56e0\u70ba\u4f7f\u7528\u9055\u6cd5\u7a0b\u5f0f\u7df4\u529f\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
                    a2.getPlayer().ban(stringBuilder.toString(), false, true, false);
                    a2.disconnect();
                } else {
                    FileoutputUtil.logToFile(PlayersHandler.ALLATORIxDEMO("jEaY)bgIm\u0005G_rEDKh\u0004rRr"), "\r\n" + FileoutputUtil.NowTime() + "\u73a9\u5bb6: " + a2.getPlayer().getName() + " \u56e0\u70ba " + stringBuilder + " \u800c\u88ab\u7cfb\u7d71\u5c01\u9396");
                }
            } else if (a4 > 0L) {
                a6.K.add(new ExpirationEntry(System.currentTimeMillis() + a4, n2, a3));
            }
            return;
        }
        finally {
            a6.ALLATORIxDEMO.unlock();
        }
    }

    public final /* synthetic */ void autoban(MapleClient a2, String a3) {
        AutobanManager a4;
        if (a2.getPlayer().isGM() || a2.getPlayer().isClone()) {
            a2.getPlayer().dropMessage(5, "[\u8b66\u544a] A/b \u89f8\u767c \u539f\u56e0 : " + a3);
            return;
        }
        a4.addPoints(a2, 5000, 0L, a3);
    }

    public /* synthetic */ AutobanManager() {
        AutobanManager a2;
        AutobanManager autobanManager = a2;
        a2.B = new HashMap<Integer, Integer>();
        autobanManager.k = new HashMap<Integer, List<String>>();
        a2.K = new TreeSet<ExpirationEntry>();
        a2.ALLATORIxDEMO = new ReentrantLock(true);
    }

    private static class ExpirationEntry
    implements Comparable<ExpirationEntry> {
        public /* synthetic */ int points;
        public /* synthetic */ long time;
        public /* synthetic */ int acc;

        public /* synthetic */ boolean equals(Object a2) {
            ExpirationEntry a3;
            if (!(a2 instanceof ExpirationEntry)) {
                return false;
            }
            ExpirationEntry expirationEntry = (ExpirationEntry)a2;
            return a3.time == expirationEntry.time && a3.points == expirationEntry.points && a3.acc == expirationEntry.acc;
        }

        public /* synthetic */ ExpirationEntry(long a2, int a3, int a4) {
            ExpirationEntry a5;
            ExpirationEntry expirationEntry = a5;
            a5.time = a2;
            expirationEntry.acc = a3;
            expirationEntry.points = a4;
        }

        @Override
        public /* synthetic */ int compareTo(ExpirationEntry a2) {
            ExpirationEntry a3;
            return (int)(a3.time - a2.time);
        }
    }
}

