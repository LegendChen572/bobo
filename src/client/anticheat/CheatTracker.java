/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5408\u592a\u8c37
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 */
package client.anticheat;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import client.anticheat.CheatingOffenseEntry;
import client.anticheat.CheatingOffensePersister;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.MapleWeaponType;
import client.messages.commands.player.\u5408\u592a\u8c37;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MobConstants;
import constants.SkillConstants;
import handling.opcodes.MapleBuffStat;
import handling.world.World;
import java.awt.Point;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.AutobanManager;
import server.Timer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.StringUtil;

public class CheatTracker {
    private /* synthetic */ long B;
    private /* synthetic */ long ALLATORIxDEMO;
    private /* synthetic */ int i;
    private /* synthetic */ int b;
    private /* synthetic */ int a;
    private /* synthetic */ int l;
    private final /* synthetic */ ReentrantReadWriteLock s;
    private /* synthetic */ long M;
    private /* synthetic */ long o;
    private /* synthetic */ long f;
    private /* synthetic */ int w;
    private /* synthetic */ long t;
    private final /* synthetic */ WeakReference<MapleCharacter> R;
    private /* synthetic */ long H;
    private /* synthetic */ int g;
    private /* synthetic */ int m;
    private /* synthetic */ byte h;
    private /* synthetic */ int Z;
    private /* synthetic */ long r;
    private /* synthetic */ int j;
    private /* synthetic */ Point c;
    private /* synthetic */ long G;
    private /* synthetic */ int E;
    private /* synthetic */ byte P;
    private /* synthetic */ byte S;
    private /* synthetic */ long Q;
    private /* synthetic */ int J;
    private /* synthetic */ ScheduledFuture<?> L;
    private /* synthetic */ long C;
    public /* synthetic */ long[] lastTime;
    private final /* synthetic */ Lock v;
    private /* synthetic */ long d;
    private /* synthetic */ long e;
    private /* synthetic */ long I;
    private final /* synthetic */ Map<CheatingOffense, CheatingOffenseEntry> T;
    private final /* synthetic */ Map<Integer, Long> N;
    private final /* synthetic */ Lock n;
    private /* synthetic */ long D;
    private /* synthetic */ long K;
    private /* synthetic */ long F;
    private /* synthetic */ byte A;
    private /* synthetic */ long k;

    public final /* synthetic */ void checkDrop(boolean a2) {
        block2: {
            CheatTracker cheatTracker;
            CheatTracker a3;
            block1: {
                block0: {
                    if (System.currentTimeMillis() - a3.f >= 1000L) break block0;
                    CheatTracker cheatTracker2 = a3;
                    cheatTracker2.A = (byte)(cheatTracker2.A + 1);
                    if (cheatTracker2.A < (a2 ? (byte)32 : 16) || a3.R.get() == null) break block1;
                    cheatTracker = a3;
                    break block2;
                }
                a3.A = 0;
            }
            cheatTracker = a3;
        }
        cheatTracker.f = System.currentTimeMillis();
    }

    public final /* synthetic */ void checkSameDamage(int a2, double a3) {
        CheatTracker a4;
        if (a2 > 2000 && a4.Q == (long)a2 && a4.R.get() != null && (((MapleCharacter)a4.R.get()).getLevel() < 175 || (double)a2 > a3 * 2.0)) {
            CheatTracker cheatTracker = a4;
            ++cheatTracker.b;
            if (cheatTracker.b > 5) {
                a4.b = 0;
                CheatTracker cheatTracker2 = a4;
                cheatTracker2.registerOffense(CheatingOffense.SAME_DAMAGE, cheatTracker2.b + " \u6b21, \u653b\u64ca\u50b7\u5bb3: " + a2 + ", \u9810\u8a08\u50b7\u5bb3: " + a3 + " [\u7b49\u7d1a: " + ((MapleCharacter)a4.R.get()).getLevel() + ", \u8077\u696d: " + ((MapleCharacter)a4.R.get()).getJob() + "]");
                return;
            }
        } else {
            a4.Q = a2;
            a4.b = 0;
        }
    }

    public final /* synthetic */ void registerOffense(CheatingOffense a2) {
        CheatTracker a3;
        a3.registerOffense(a2, null);
    }

    public final /* synthetic */ void check\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd() {
        CheatTracker a2;
        long l2 = System.currentTimeMillis();
        if (l2 - a2.H < 400L) {
            CheatTracker cheatTracker = a2;
            long l3 = l2;
            cheatTracker.registerOffense(CheatingOffense.\u5feb\u901f\u4f7f\u7528\u4e8c\u6bb5\u8df3, "\u76ee\u524d <" + l3 + "> \u4e0a\u6b21 <" + cheatTracker.H + "> \u9593\u9694 <" + (l3 - a2.H) + ">");
        }
        a2.H = System.currentTimeMillis();
    }

    public final /* synthetic */ void checkTakeDamage(int a2, int a3) {
        MapleMonster mapleMonster;
        long l2;
        int n2;
        CheatTracker a4;
        block6: {
            block5: {
                block4: {
                    CheatTracker cheatTracker = a4;
                    ++cheatTracker.Z;
                    cheatTracker.t = System.currentTimeMillis();
                    if (cheatTracker.t - a4.o / 500L >= (long)a4.Z || a4.t - a4.o > 4500L) {
                        a4.o = a4.t;
                        a4.Z = 0;
                    }
                    if (a2 != 0) break block4;
                    CheatTracker cheatTracker2 = a4;
                    cheatTracker2.P = (byte)(cheatTracker2.P + 1);
                    if (cheatTracker2.P < 35) break block5;
                    n2 = a2;
                    a4.P = 0;
                    a4.registerOffense(CheatingOffense.HIGH_AVOID);
                    break block6;
                }
                if (a2 != -1) {
                    a4.P = 0;
                }
            }
            n2 = a2;
        }
        if ((long)n2 == a4.B && a2 > 0) {
            a4.registerOffense(CheatingOffense.TAKE_SAME_DAMAGE, " \u602a\u7269[" + a3 + "] \u53d7\u5230\u50b7\u5bb3 [" + a2 + "]");
        }
        if (!(a2 <= 1 || a3 == 0 || ((MapleCharacter)a4.R.get()).hasDisease(MapleBuffStat.POISON) || (l2 = System.currentTimeMillis()) - a4.C >= 900L || (mapleMonster = (MapleMonster)MapleLifeFactory.getLife(a3, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0019"))) == null || mapleMonster.getStats().isBoss() || MobConstants.isForceRespawn(((MapleCharacter)a4.R.get()).getMapId()))) {
            a4.registerOffense(CheatingOffense.FAST_TAKE_DAMAGE, " \u9593\u9694 <" + (l2 - a4.C) + "> \u5730\u5716[" + ((MapleCharacter)a4.R.get()).getMapId() + "] \u602a\u7269[" + a3 + "] \u53d7\u5230\u50b7\u5bb3 [" + a2 + "]");
        }
        a4.C = System.currentTimeMillis();
    }

    public final /* synthetic */ boolean canCheckBuff() {
        CheatTracker a2;
        return a2.k + 5000L < System.currentTimeMillis() && a2.K + 3000L < System.currentTimeMillis();
    }

    public /* synthetic */ boolean canLieDetector() {
        CheatTracker a2;
        if (a2.ALLATORIxDEMO + 300000L > System.currentTimeMillis() && a2.R.get() != null) {
            return false;
        }
        a2.ALLATORIxDEMO = System.currentTimeMillis();
        return true;
    }

    public final /* synthetic */ void checkMsg() {
        CheatTracker cheatTracker;
        CheatTracker a2;
        if (System.currentTimeMillis() - a2.D < 1000L) {
            CheatTracker cheatTracker2 = a2;
            cheatTracker = cheatTracker2;
            cheatTracker2.h = (byte)(cheatTracker2.h + 1);
        } else {
            cheatTracker = a2;
            a2.h = 0;
        }
        cheatTracker.D = System.currentTimeMillis();
    }

    public final /* synthetic */ void resetSummonAttack() {
        CheatTracker a2;
        CheatTracker cheatTracker = a2;
        cheatTracker.G = System.currentTimeMillis();
        cheatTracker.w = 0;
    }

    public final /* synthetic */ void checkPVPAttack(int a2) {
        CheatTracker a3;
        a2 = GameConstants.getAttackDelay((MapleCharacter)a3.R.get(), a2);
        if (System.currentTimeMillis() - a3.k < (long)a2) {
            a3.registerOffense(CheatingOffense.FASTATTACK);
        }
        a3.k = System.currentTimeMillis();
    }

    public final /* synthetic */ void expireEntry(CheatingOffenseEntry a2) {
        CheatTracker a3;
        a3.v.lock();
        try {
            a3.T.remove((Object)a2.getOffense());
            return;
        }
        finally {
            a3.v.unlock();
        }
    }

    public final /* synthetic */ void checkTakeDamage(int a2) {
        CheatTracker a3;
        CheatTracker cheatTracker = a3;
        ++cheatTracker.Z;
        cheatTracker.t = System.currentTimeMillis();
        if (cheatTracker.t - a3.o / 500L < (long)a3.Z) {
            // empty if block
        }
        if (a3.t - a3.o > 4500L) {
            a3.o = a3.t;
            a3.Z = 0;
        }
        if (a2 == 0) {
            CheatTracker cheatTracker2 = a3;
            cheatTracker2.P = (byte)(cheatTracker2.P + 1);
            if (cheatTracker2.P >= 35) {
                a3.P = 0;
                a3.registerOffense(CheatingOffense.HIGH_AVOID, \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u8ffa\u9046\u7389\u9077\u9ad6\u0019"));
                return;
            }
        } else if (a2 != -1) {
            a3.P = 0;
        }
    }

    public final /* synthetic */ boolean \u5730\u5716\u77ac\u79fbing() {
        CheatTracker a2;
        long l2 = System.currentTimeMillis();
        boolean bl = false;
        if (l2 - a2.e < 1000L) {
            bl = true;
        }
        return bl;
    }

    public /* synthetic */ void updateTick(int a2) {
        CheatTracker cheatTracker;
        CheatTracker a3;
        if (a2 == a3.i) {
            CheatTracker cheatTracker2 = a3;
            cheatTracker = cheatTracker2;
            ++cheatTracker2.J;
        } else {
            cheatTracker = a3;
            a3.J = 0;
        }
        cheatTracker.i = a2;
    }

    public final /* synthetic */ int getAttacksWithoutHit() {
        CheatTracker a2;
        return a2.m;
    }

    public /* synthetic */ boolean canAvatarSmega2() {
        CheatTracker a2;
        long l2 = 10000L;
        if (a2.R.get() != null) {
            if (((MapleCharacter)a2.R.get()).getId() == 845 || ((MapleCharacter)a2.R.get()).getId() == 5247 || ((MapleCharacter)a2.R.get()).getId() == 12048) {
                l2 = 20000L;
            }
            if (a2.M + l2 > System.currentTimeMillis() && !((MapleCharacter)a2.R.get()).isGM()) {
                return false;
            }
        }
        a2.M = System.currentTimeMillis();
        return true;
    }

    public /* synthetic */ CheatTracker(MapleCharacter a2) {
        CheatTracker a3;
        CheatTracker cheatTracker = a3;
        CheatTracker cheatTracker2 = a3;
        CheatTracker cheatTracker3 = a3;
        CheatTracker cheatTracker4 = a3;
        CheatTracker cheatTracker5 = a3;
        CheatTracker cheatTracker6 = a3;
        CheatTracker cheatTracker7 = a3;
        CheatTracker cheatTracker8 = a3;
        CheatTracker cheatTracker9 = a3;
        CheatTracker cheatTracker10 = a3;
        CheatTracker cheatTracker11 = a3;
        CheatTracker cheatTracker12 = a3;
        CheatTracker cheatTracker13 = a3;
        CheatTracker cheatTracker14 = a3;
        CheatTracker cheatTracker15 = a3;
        CheatTracker cheatTracker16 = a3;
        CheatTracker cheatTracker17 = a3;
        CheatTracker cheatTracker18 = a3;
        cheatTracker18.s = new ReentrantReadWriteLock();
        cheatTracker18.n = a3.s.readLock();
        cheatTracker18.v = cheatTracker18.s.writeLock();
        cheatTracker18.T = new LinkedHashMap<CheatingOffense, CheatingOffenseEntry>();
        cheatTracker18.N = new LinkedHashMap<Integer, Long>();
        cheatTracker17.S = 0;
        cheatTracker17.r = 0L;
        cheatTracker16.Q = 0L;
        cheatTracker16.Z = 0;
        cheatTracker15.t = 0L;
        cheatTracker15.P = 0;
        cheatTracker14.w = 0;
        cheatTracker14.G = 0L;
        cheatTracker13.b = 0;
        cheatTracker13.m = 0;
        cheatTracker12.A = (byte)0;
        cheatTracker12.f = 0L;
        cheatTracker11.h = 0;
        cheatTracker11.D = 0L;
        cheatTracker10.j = 100;
        cheatTracker10.i = 0;
        cheatTracker9.J = 0;
        cheatTracker9.M = 0L;
        cheatTracker8.lastTime = new long[6];
        cheatTracker8.I = 0L;
        cheatTracker7.F = 0L;
        cheatTracker7.C = 0L;
        cheatTracker6.H = 0L;
        cheatTracker6.e = 0L;
        cheatTracker5.E = 0;
        cheatTracker5.g = 0;
        cheatTracker4.B = 0L;
        cheatTracker4.k = 0L;
        cheatTracker3.K = 0L;
        cheatTracker3.a = 0;
        cheatTracker2.d = 0L;
        cheatTracker2.ALLATORIxDEMO = 0L;
        cheatTracker.R = new WeakReference<MapleCharacter>(a2);
        cheatTracker.L = Timer.CheatTimer.getInstance().register(a3.new InvalidationTask(null), 60000L);
        cheatTracker.o = System.currentTimeMillis();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ String getSummary() {
        int n2;
        CheatTracker a2;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<CheatingOffenseEntry> arrayList = new ArrayList<CheatingOffenseEntry>();
        a2.n.lock();
        try {
            for (CheatingOffenseEntry cheatingOffenseEntry : a2.T.values()) {
                if (cheatingOffenseEntry.isExpired()) continue;
                arrayList.add(cheatingOffenseEntry);
            }
        }
        finally {
            a2.n.unlock();
        }
        Collections.sort(arrayList, new Comparator<CheatingOffenseEntry>(){
            {
                1 a3;
            }

            @Override
            public final /* synthetic */ int compare(CheatingOffenseEntry a2, CheatingOffenseEntry a32) {
                int n2;
                int a32 = a2.getPoints();
                if (a32 < (n2 = a32.getPoints())) {
                    return 1;
                }
                if (a32 == n2) {
                    return 0;
                }
                return -1;
            }
        });
        int n3 = Math.min(arrayList.size(), 4);
        int n4 = n2 = 0;
        while (n4 < n3) {
            stringBuilder.append(StringUtil.makeEnumHumanReadable(((CheatingOffenseEntry)arrayList.get(n2)).getOffense().name()));
            stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"4\u0019"));
            stringBuilder.append(((CheatingOffenseEntry)arrayList.get(n2)).getCount());
            if (n2 != n3 - 1) {
                stringBuilder.append(" ");
            }
            n4 = ++n2;
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ void dispose() {
        CheatTracker a2;
        if (a2.L != null) {
            a2.L.cancel(false);
        }
        a2.L = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void registerOffense(CheatingOffense a, String a) {
        var3_3 = (MapleCharacter)a.R.get();
        if (var3_3 == null) return;
        if (a.isEnabled() == false) return;
        if (var3_3.isClone()) {
            return;
        }
        if (((MapleCharacter)a.R.get()).hasGmLevel(5)) {
            ((MapleCharacter)a.R.get()).dropMessage("\u89f8\u767c\u9055\u898f\uff1a" + a + " \u539f\u56e0\uff1a" + a);
        }
        var4_4 = null;
        a.n.lock();
        try {
            var4_4 = a.T.get((Object)a);
        }
        finally {
            a.n.unlock();
        }
        if (var4_4 != null && var4_4.isExpired()) {
            a.expireEntry(var4_4);
            var4_4 = null;
        }
        if (var4_4 == null) {
            var4_4 = new CheatingOffenseEntry(a, var3_3.getId());
        }
        if (a != null) {
            var4_4.setParam(a);
        }
        var4_4.incrementCount();
        if (a.shouldAutoban(var4_4.getCount())) {
            var5_6 = a.getBanType();
            switch (var5_6) {
                case 1: {
                    AutobanManager.getInstance().autoban(var3_3.getClient(), StringUtil.makeEnumHumanReadable(a.name()));
                    v0 = a;
                    break;
                }
                case 2: {
                    if (GameSetConstants.AUTODC) {
                        var6_8 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u65fa\u7dae");
                        World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " \u81ea\u52d5\u65b7\u7dda \u985e\u5225: " + a.toString() + " \u539f\u56e0: " + (String)(a == null ? "" : " - " + a)));
                        FileoutputUtil.logToFile("logs/Hack/" + var6_8 + ".txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + ((MapleCharacter)a.R.get()).getName() + " \u9805\u76ee\uff1a" + a.toString() + " \u539f\u56e0\uff1a " + (String)(a == null ? "" : " - " + a));
                        v0 = a;
                        var3_3.getClient().getSession().close();
                        break;
                    }
                    var6_9 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6713\u65b9\u7de3");
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " \u672a\u81ea\u52d5\u65b7\u7dda \u985e\u5225: " + a.toString() + " \u539f\u56e0: " + (String)(a == null ? "" : " - " + a)));
                    FileoutputUtil.logToFile("logs/Hack/" + var6_9 + ".txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + ((MapleCharacter)a.R.get()).getName() + " \u9805\u76ee\uff1a" + a.toString() + " \u539f\u56e0\uff1a " + (String)(a == null ? "" : " - " + a));
                    v0 = a;
                    break;
                }
                case 3: {
                    var7_12 = true;
                    var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u5c4c\u93e2");
                    var8_14 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u905b\u6cec\u7a05\u5f36\u7dfa\u52a6");
                    var9_16 = "";
                    switch (2.ALLATORIxDEMO[a.ordinal()]) {
                        case 1: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u5125\u5762\u5475\u721d");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u5166\u572f\u5436\u7250");
                            if (GameSetConstants.ITEMVAC_BAN) break;
                            var7_12 = false;
                            break;
                        }
                        case 2: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u53a1\u55ee\u7335\u7155\u5ebb\u9006");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u53e2\u55a3\u7376\u7118\u5ef8\u904b\u6535\u64f3");
                            break;
                        }
                        case 3: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)",\u5475\u605e");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f46\u7526a\u5436\u6013");
                            if (GameSetConstants.MOBVAC_BAN) break;
                            var7_12 = false;
                            break;
                        }
                        case 4: 
                        case 5: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u5475\u605e");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u5436\u6013");
                            if (GameSetConstants.MOBVAC_BAN) break;
                            var7_12 = false;
                            break;
                        }
                        case 6: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u5475\u605e\u0012\u65c4");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u5436\u6013#\u6589");
                            var7_12 = false;
                            break;
                        }
                        case 7: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u63ea\u605e\u0012\u65c4");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u63a9\u6013Q\u6589");
                            var7_12 = false;
                            break;
                        }
                        case 8: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u511c\u575b\u6227");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f46\u7526\u5151\u5718\u626a");
                            if (GameSetConstants.ALLMAPATTACK_BAN) break;
                            var7_12 = false;
                            break;
                        }
                        case 9: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u7118\u9b2b\u6c1a\u4f71\u7511\u9b2b\u6c1a\u628e\u80c4");
                            break;
                        }
                        case 10: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u7be0\u7796\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6c9c\u6730\u7ba3\u77db\u7672\u5c3d\u5f1d\u7b94");
                            if (GameSetConstants.NOARROWATTACK_BAN) break;
                            var7_12 = false;
                            break;
                        }
                        case 11: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6c9c\u6730\u8dbd\u5919Ci\u4f71\u7511\u628e\u80c4");
                            break;
                        }
                        case 12: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u7f9d\u9ada\u6c82\u765c\u6502\u64c4\u4e34\u6b75\u7cc2\u6024\u7250");
                            break;
                        }
                        case 13: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u625d\u6013\u6576\u91f6\u757e\u5e01");
                            break;
                        }
                        case 14: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u628e\u80c4\u6535\u64f3\u6b2f\u6541");
                            break;
                        }
                        case 15: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6cab\u6707\u8d8a\u592ezAtLv\u4f71\u7511\u628e\u80c4");
                            break;
                        }
                        case 16: 
                        case 17: {
                            var6_10 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u62cd\u8089\u753d\u5e4c");
                            var9_16 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u7118\u5ef8\u904b\u4f71\u7511\u628e\u80c4");
                            if (GameSetConstants.ATTACKSPEEDUP_BAN) break;
                            var7_12 = false;
                            break;
                        }
                        default: {
                            var7_12 = false;
                            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + MapleCharacterUtil.makeMapleReadable(var3_3.getName()) + " (\u7de8\u865f: " + var3_3.getId() + " )\u4f7f\u7528\u5916\u639b! " + StringUtil.makeEnumHumanReadable(a.name()) + (String)(a == null ? "" : " - " + a)));
                        }
                    }
                    if (!GameSetConstants.AUTOBAN) {
                        var7_12 = false;
                    }
                    if (((MapleCharacter)a.R.get()).hasGmLevel(1)) {
                        ((MapleCharacter)a.R.get()).dropMessage("\u89f8\u767c\u5c01\u9396: " + var9_16 + " \u539f\u56e0: " + (String)(a == null ? "" : " - " + a));
                        v0 = a;
                        break;
                    }
                    if (var7_12) {
                        FileoutputUtil.logToFile("logs/Hack/Ban/" + var6_10 + ".txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + ((MapleCharacter)a.R.get()).getName() + " \u9805\u76ee\uff1a" + a.toString() + " \u539f\u56e0\uff1a " + (String)(a == null ? "" : " - " + a));
                        World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + var3_3.getName() + " \u56e0\u70ba" + var8_14 + "\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
                        World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " " + var9_16 + "\u81ea\u52d5\u5c01\u9396! "));
                        v1 = var3_3;
                        v1.ban(v1.getName() + var9_16, true, true, false);
                        var3_3.getClient().getSession().close();
                        v0 = a;
                        break;
                    }
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] \u73a9\u5bb6: " + var3_3.getName() + " \u7de8\u865f:(" + var3_3.getId() + ")" + var9_16 + "[\u672a\u5c01\u9396]! "));
                    FileoutputUtil.logToFile("logs/Hack/\u672a\u5c01\u9396-" + var6_10 + ".txt", "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + ((MapleCharacter)a.R.get()).getName() + " \u9805\u76ee\uff1a" + a.toString() + " \u539f\u56e0\uff1a " + (String)(a == null ? "" : " - " + a));
                    v0 = a;
                    break;
                }
                default: {
                    v0 = a;
                }
            }
            v0.j = 100;
            return;
        }
        a.v.lock();
        try {
            a.T.put(a, var4_4);
        }
        finally {
            a.v.unlock();
        }
        switch (2.ALLATORIxDEMO[a.ordinal()]) {
            case 17: {
                v2 = a;
                --v2.j;
                if (v2.j % 10 != 0) break;
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! \u7121\u5ef6\u9072\u653b\u64ca" + (String)(a == null ? "" : " - " + a)));
                FileoutputUtil.logToFile(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0018\"\u0013>[\u0005\u0015.\u001fb\u7155\u5ebb\u9006c\u00005\u0000"), "\r\n" + FileoutputUtil.NowTime() + " " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! \u7121\u5ef6\u9072\u653b\u64ca" + (String)(a == null ? "" : " - " + a));
                break;
            }
            case 7: 
            case 18: {
                v3 = a;
                --v3.j;
                if (v3.j % 10 != 0) break;
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! \u63a7\u602a" + (String)(a == null ? "" : " - " + a)));
                FileoutputUtil.logToFile(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"bViJ!qoZe\u0016\u63a9\u6013 MvM"), "\r\n" + FileoutputUtil.NowTime() + " " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! \u63a7\u602a" + (String)(a == null ? "" : " - " + a));
                break;
            }
            case 19: {
                v4 = a;
                --v4.j;
                if (v4.j % 10 != 0) break;
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! \u79fb\u52d5\u7121\u5ef6\u9072" + (String)(a == null ? "" : " - " + a)));
                FileoutputUtil.logToFile(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0018\"\u0013>[\u0005\u0015.\u001fb\u798f\u5298\u7155\u5ebb\u9006c\u00005\u0000"), "\r\n" + FileoutputUtil.NowTime() + " " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! \u79fb\u52d5\u7121\u5ef6\u9072" + (String)(a == null ? "" : " - " + a));
                break;
            }
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: {
                --a.j;
                var5_7 = "";
                var6_11 = a.name();
                var7_13 = false;
                var8_15 = true;
                var9_17 = var6_11;
                var10_19 = -1;
                switch (var9_17.hashCode()) {
                    case -1087274007: {
                        if (!var9_17.equals(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"OmZxMrQ\u007fOkOnO`QtAw]mKk"))) break;
                        v5 = var10_19 = 0;
                        ** GOTO lbl206
                    }
                    case 1943876889: {
                        if (!var9_17.equals(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"9\u00026\u0012\"\f7"))) break;
                        var10_19 = 1;
                    }
                }
                v5 = var10_19;
lbl206:
                // 2 sources

                switch (v5) {
                    case 0: {
                        var6_11 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u5151\u5718\u626a");
                        var5_7 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u6576\u64be\u7b89\u5779\u753d\u5e4c");
                        var7_13 = true;
                        v6 = a;
                        break;
                    }
                    case 1: {
                        var6_11 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u4f71\u7511\u5436\u6013");
                        var5_7 = \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u5475\u605e");
                        var8_15 = false;
                        var7_13 = true;
                    }
                    default: {
                        v6 = a;
                    }
                }
                if (v6.j % 5 == 0) {
                    if (var8_15) {
                        World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! " + var6_11 + (String)(a == null ? "" : " - " + a)));
                    }
                    if (var7_13) {
                        FileoutputUtil.logToFile("logs/Hack/" + var5_7 + ".txt", "\r\n" + FileoutputUtil.NowTime() + " " + var3_3.getName() + " (\u7de8\u865f:" + var3_3.getId() + ")\u7591\u4f3c\u5916\u639b! " + var6_11 + (String)(a == null ? "" : " - " + a));
                    }
                }
                if (!GameSetConstants.AUTOBAN || !GameSetConstants.ALLMAPATTACK_BAN || a.j != 0) break;
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[\u5c01\u865f\u7cfb\u7d71] " + var3_3.getName() + " (\u7de8\u865f: " + var3_3.getId() + " )\u7591\u4f3c\u5916\u639b\uff01" + var6_11 + (String)(a == null ? "" : " - " + a)));
                AutobanManager.getInstance().autoban(var3_3.getClient(), StringUtil.makeEnumHumanReadable(a.name()));
                a.j = 100;
                break;
            }
        }
        CheatingOffensePersister.getInstance().persistEntry(var4_4);
    }

    public /* synthetic */ long[] getLastGMspam() {
        CheatTracker a2;
        return a2.lastTime;
    }

    public final /* synthetic */ void check\u5730\u5716\u77ac\u79fb() {
        a.e = System.currentTimeMillis();
    }

    public final /* synthetic */ void checkDrop() {
        CheatTracker a2;
        a2.checkDrop(false);
    }

    public final /* synthetic */ void UpdateBuffTime() {
        a.K = System.currentTimeMillis();
    }

    public synchronized /* synthetic */ boolean GMSpam(int a2, int a3) {
        CheatTracker a4;
        if (a3 < 0 || a4.lastTime.length < a3) {
            a3 = 1;
        }
        if (System.currentTimeMillis() < (long)a2 + a4.lastTime[a3]) {
            return true;
        }
        a4.lastTime[a3] = System.currentTimeMillis();
        return false;
    }

    public final /* synthetic */ boolean checkAttack(int a2, int a3) {
        MapleWeaponType mapleWeaponType;
        CheatTracker cheatTracker;
        CheatTracker a4;
        boolean bl = true;
        long l2 = 0L;
        a4.k = System.currentTimeMillis();
        if (a2 == 15111006) {
            return true;
        }
        if (a4.N.containsKey(a2)) {
            l2 = a4.N.get(a2);
            cheatTracker = a4;
        } else {
            CheatTracker cheatTracker2 = a4;
            cheatTracker = cheatTracker2;
            cheatTracker2.N.put(a2, 0L);
        }
        short s2 = GameConstants.getAttackDelay((MapleCharacter)cheatTracker.R.get(), a2);
        IItem iItem = ((MapleCharacter)a4.R.get()).getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
        MapleWeaponType mapleWeaponType2 = mapleWeaponType = iItem == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(iItem.getItemId());
        if (GameSetConstants.DELAY_CHECK) {
            long l3;
            if (GameSetConstants.CHECK_DELAY_STAGE < 100) {
                double d2 = (double)GameSetConstants.CHECK_DELAY_STAGE / 100.0;
                s2 = (short)((double)s2 * d2);
            }
            if (SkillConstants.AttackDelayCheck(a2)) {
                if ((long)a3 - l2 > 0L && (long)a3 - l2 < (long)s2) {
                    CheatTracker cheatTracker3;
                    Object object;
                    MapleWeaponType mapleWeaponType3;
                    int n2;
                    String string = SkillFactory.getName(a2);
                    long l4 = (long)a3 - l2;
                    if (iItem == null) {
                        n2 = 0;
                        mapleWeaponType3 = mapleWeaponType;
                    } else {
                        n2 = iItem.getItemId();
                        mapleWeaponType3 = mapleWeaponType;
                    }
                    String string2 = mapleWeaponType3.name();
                    if (((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.SPEED_INFUSION) == null) {
                        object = "";
                        cheatTracker3 = a4;
                    } else {
                        object = "\u6700\u7d42\u6975\u901f:" + ((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.SPEED_INFUSION);
                        cheatTracker3 = a4;
                    }
                    a4.registerOffense(CheatingOffense.\u5feb\u901f\u653b\u64ca, "\u653b\u64ca\u901f\u5ea6\u7570\u5e38\uff0c\u6280\u80fd: " + string + "[" + a2 + "] \u73a9\u5bb6\u56de\u50b3: " + l4 + " \u670d\u52d9\u7aef\u8a08\u7b97: " + s2 + " " + n2 + "(" + string2 + ")" + (String)object + (String)(((MapleCharacter)cheatTracker3.R.get()).getBuffedValue(MapleBuffStat.BOOSTER) == null ? "" : "\u589e\u52a0\u529f\u901f" + ((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.BOOSTER)));
                    bl = false;
                }
                if (a2 != 3110001 && (long)a3 - l2 >= 0L && ((long)a3 - l2 == 90L || (long)a3 - l2 == 60L || (long)a3 - l2 == 30L)) {
                    int n3 = 10;
                    if (((MapleCharacter)a4.R.get()).getAttackDebugMessage()) {
                        ((MapleCharacter)a4.R.get()).dropMessage(6, \u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u89b5\u7608\u52d2\u906b\u58d3\u91bb"));
                    }
                    int n4 = n3;
                    while (n4 > 0) {
                        CheatTracker cheatTracker4;
                        Object object;
                        MapleWeaponType mapleWeaponType4;
                        int n5;
                        String string = SkillFactory.getName(a2);
                        long l5 = (long)a3 - l2;
                        if (iItem == null) {
                            n5 = 0;
                            mapleWeaponType4 = mapleWeaponType;
                        } else {
                            n5 = iItem.getItemId();
                            mapleWeaponType4 = mapleWeaponType;
                        }
                        String string3 = mapleWeaponType4.name();
                        if (((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.SPEED_INFUSION) == null) {
                            object = "";
                            cheatTracker4 = a4;
                        } else {
                            object = "\u6700\u7d42\u6975\u901f:" + ((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.SPEED_INFUSION);
                            cheatTracker4 = a4;
                        }
                        a4.registerOffense(CheatingOffense.\u5feb\u901f\u653b\u64ca, "\u653b\u901f\u7570\u5e38,\u6280\u80fd: " + string + "[" + a2 + "] \u73a9\u5bb6\u56de\u50b3: " + l5 + " \u670d\u52d9\u7aef\u8a08\u7b97: " + s2 + " " + n5 + "(" + string3 + ")" + (String)object + (String)(((MapleCharacter)cheatTracker4.R.get()).getBuffedValue(MapleBuffStat.BOOSTER) == null ? "" : "\u589e\u52a0\u529f\u901f" + ((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.BOOSTER)));
                        n4 = --n3;
                    }
                    bl = false;
                }
            }
            if (a4.r - (l3 = System.currentTimeMillis() - (long)a3) > 1500L) {
                CheatTracker cheatTracker5 = a4;
                long l6 = l3;
                cheatTracker5.registerOffense(CheatingOffense.\u7121\u5ef6\u9072\u653b\u64ca, "\u7121\u5ef6\u9072,\u5730\u5716[" + ((MapleCharacter)cheatTracker5.R.get()).getMapId() + "] \u6280\u80fd: " + SkillFactory.getSkillName(a2) + " Server_ClientAtkTickDiff: " + a4.r + " STime_TC: " + l6 + " \u9593\u9694" + (a4.r - l6));
                bl = false;
            }
            if (((MapleCharacter)a4.R.get()).getAttackDebugMessage()) {
                MapleWeaponType mapleWeaponType5;
                int n6;
                MapleCharacter mapleCharacter = (MapleCharacter)a4.R.get();
                String string = SkillFactory.getName(a2);
                long l7 = (long)a3 - l2;
                if (iItem == null) {
                    n6 = 0;
                    mapleWeaponType5 = mapleWeaponType;
                } else {
                    n6 = iItem.getItemId();
                    mapleWeaponType5 = mapleWeaponType;
                }
                mapleCharacter.dropMessage(5, "Delay " + string + "[" + a2 + "] = \u73a9\u5bb6\u56de\u50b3: " + l7 + ", \u670d\u52d9\u7aef\u8a08\u7b97:" + s2 + " " + n6 + "(" + mapleWeaponType5.name() + ")\u6700\u7d42\u6975\u901f:" + ((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.SPEED_INFUSION) + " \u589e\u52a0\u529f\u901f:" + ((MapleCharacter)a4.R.get()).getBuffedValue(MapleBuffStat.BOOSTER));
            }
            a4.r = l3;
            ((MapleCharacter)a4.R.get()).updateTick(a3);
        }
        if (a4.N.containsKey(a2)) {
            a4.N.remove(a2);
            a4.N.put(a2, Long.valueOf(a3));
        }
        return bl;
    }

    public final /* synthetic */ void check\u77ac\u9593\u79fb\u52d5() {
        CheatTracker a2;
        long l2 = System.currentTimeMillis();
        if (l2 - a2.F < 280L) {
            CheatTracker cheatTracker = a2;
            long l3 = l2;
            cheatTracker.registerOffense(CheatingOffense.\u7570\u5e38\u4f7f\u7528\u77ac\u9593\u79fb\u52d5, "\u76ee\u524d <" + l3 + "> \u4e0a\u6b21 <" + cheatTracker.F + "> \u9593\u9694 <" + (l3 - a2.F) + ">");
        }
        a2.F = System.currentTimeMillis();
    }

    public final /* synthetic */ void resetFamiliarAttack() {
        CheatTracker a2;
        CheatTracker cheatTracker = a2;
        cheatTracker.d = System.currentTimeMillis();
        cheatTracker.a = 0;
    }

    public final /* synthetic */ void setAttacksWithoutHit(boolean a2) {
        if (a2) {
            CheatTracker a3;
            ++a3.m;
            return;
        }
        a3.m = 0;
    }

    public final /* synthetic */ boolean checkFamiliarAttack(MapleCharacter a2) {
        CheatTracker a3;
        ++a3.a;
        if ((System.currentTimeMillis() - a3.d) / 601L < (long)a3.a) {
            a3.registerOffense(CheatingOffense.\u53ec\u559a\u7378\u7121\u5ef6\u9072);
            return false;
        }
        return true;
    }

    public final /* synthetic */ Map<CheatingOffense, CheatingOffenseEntry> getOffenses() {
        CheatTracker a2;
        return Collections.unmodifiableMap(a2.T);
    }

    public final /* synthetic */ boolean \u5927\u7bc4\u570d\u79fb\u52d5ing() {
        CheatTracker a2;
        long l2 = System.currentTimeMillis();
        boolean bl = false;
        if (l2 - a2.H < 1000L) {
            bl = true;
        }
        return bl;
    }

    public final /* synthetic */ boolean checkSummonAttack() {
        CheatTracker a2;
        ++a2.w;
        return 1 != 0;
    }

    public final /* synthetic */ void check\u7d42\u6975\u653b\u64ca(int a2, int a3) {
        int n2;
        CheatTracker cheatTracker;
        CheatTracker a4;
        switch (a3) {
            case 24100003: 
            case 32121002: {
                return;
            }
        }
        boolean bl = SkillConstants.is\u7d42\u6975\u653b\u64ca(a3);
        a2 = bl ? 1 : 0;
        if (bl) {
            CheatTracker cheatTracker2 = a4;
            cheatTracker = cheatTracker2;
            ++cheatTracker2.E;
        } else {
            CheatTracker cheatTracker3 = a4;
            cheatTracker = cheatTracker3;
            ++cheatTracker3.g;
        }
        if (cheatTracker.g == 0) {
            a4.g = 1;
        }
        if ((n2 = a4.E * 100 / a4.g) > 100) {
            n2 = 100;
        }
        if (a2 != 0) {
            CheatTracker cheatTracker4 = a4;
            if (cheatTracker4.g + cheatTracker4.E > 500 && n2 > (a2 = SkillFactory.getSkill(a3).getEffect(((MapleCharacter)a4.R.get()).getSkillLevel(a3)).getProp()) + 10) {
                CheatTracker cheatTracker5 = a4;
                cheatTracker5.registerOffense(CheatingOffense.\u7d42\u6975\u653b\u64ca\u767e\u5206\u767e, "\u7d42\u6975\u653b\u64ca\u7570\u5e38,\u5730\u5716[" + ((MapleCharacter)cheatTracker5.R.get()).getMapId() + "] \u6280\u80fd: " + SkillFactory.getSkillName(a3) + " \u7d42\u6975\u653b\u64ca\u6aa2\u6e2c\u6a5f\u7387 :" + n2 + "\u6b63\u5e38\u503c:" + a2);
            }
        }
    }

    public final /* synthetic */ int getPoints() {
        int n2;
        CheatingOffenseEntry[] arrcheatingOffenseEntry;
        CheatTracker a2;
        int n3 = 0;
        a2.n.lock();
        try {
            arrcheatingOffenseEntry = a2.T.values().toArray(new CheatingOffenseEntry[a2.T.size()]);
        }
        finally {
            a2.n.unlock();
        }
        CheatingOffenseEntry[] arrcheatingOffenseEntry2 = arrcheatingOffenseEntry;
        int n4 = arrcheatingOffenseEntry2.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            CheatingOffenseEntry cheatingOffenseEntry = arrcheatingOffenseEntry2[n2];
            if (cheatingOffenseEntry.isExpired()) {
                a2.expireEntry(cheatingOffenseEntry);
            } else {
                n3 += cheatingOffenseEntry.getPoints();
            }
            n5 = ++n2;
        }
        return n3;
    }

    private final class InvalidationTask
    implements Runnable {
        private /* synthetic */ InvalidationTask() {
            InvalidationTask a2;
        }

        public /* synthetic */ InvalidationTask(1 a3) {
            a4();
            InvalidationTask a4;
        }

        @Override
        public final /* synthetic */ void run() {
            int n2;
            CheatingOffenseEntry[] arrcheatingOffenseEntry;
            InvalidationTask a2;
            a2.CheatTracker.this.n.lock();
            try {
                arrcheatingOffenseEntry = a2.CheatTracker.this.T.values().toArray(new CheatingOffenseEntry[a2.CheatTracker.this.T.size()]);
            }
            finally {
                a2.CheatTracker.this.n.unlock();
            }
            CheatingOffenseEntry[] arrcheatingOffenseEntry2 = arrcheatingOffenseEntry;
            int n3 = arrcheatingOffenseEntry2.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                CheatingOffenseEntry cheatingOffenseEntry = arrcheatingOffenseEntry2[n2];
                if (cheatingOffenseEntry.isExpired()) {
                    a2.CheatTracker.this.expireEntry(cheatingOffenseEntry);
                }
                n4 = ++n2;
            }
            if (a2.CheatTracker.this.R.get() == null) {
                a2.CheatTracker.this.dispose();
            }
        }
    }
}

