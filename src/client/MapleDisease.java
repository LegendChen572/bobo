/*
 * Decompiled with CFR 0.150.
 */
package client;

import FuckingHackerToby.F;
import constants.GameSetConstants;
import handling.Buffstat;
import handling.world.family.MapleFamily;
import java.io.Serializable;
import server.Randomizer;

public final class MapleDisease
extends Enum<MapleDisease>
implements Serializable,
Buffstat {
    public static final /* synthetic */ /* enum */ MapleDisease SHADOW;
    public static final /* synthetic */ /* enum */ MapleDisease TORNADO;
    public static final /* synthetic */ /* enum */ MapleDisease FLAG;
    public static final /* synthetic */ /* enum */ MapleDisease WEAKEN;
    public static final /* synthetic */ /* enum */ MapleDisease CURSE;
    public static final /* synthetic */ /* enum */ MapleDisease ZOMBIFY;
    private static final /* synthetic */ long k = 0L;
    private final /* synthetic */ boolean a;
    public static final /* synthetic */ /* enum */ MapleDisease BLIND;
    public static final /* synthetic */ /* enum */ MapleDisease SEAL;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ MapleDisease FREEZE;
    private static final /* synthetic */ MapleDisease[] ALLATORIxDEMO;
    private final /* synthetic */ long K;
    public static final /* synthetic */ /* enum */ MapleDisease SEDUCE;
    public static final /* synthetic */ /* enum */ MapleDisease SLOW;
    public static final /* synthetic */ /* enum */ MapleDisease STUN;
    public static final /* synthetic */ /* enum */ MapleDisease DARKNESS;
    public static final /* synthetic */ /* enum */ MapleDisease REVERSE_DIRECTION;
    public static final /* synthetic */ /* enum */ MapleDisease POISON;
    public static final /* synthetic */ /* enum */ MapleDisease DISABLE_POTENTIAL;
    public static final /* synthetic */ /* enum */ MapleDisease POTION;
    public static final /* synthetic */ /* enum */ MapleDisease WEIRD_FLAME;
    public static final /* synthetic */ /* enum */ MapleDisease MORPH;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleDisease(long l2, boolean a2, int n2) {
        void a3;
        void a4;
        void var2_-1;
        void var1_-1;
        MapleDisease a5;
        MapleDisease mapleDisease = a5;
        a5.K = (long)a2;
        mapleDisease.a = a4;
        mapleDisease.d = a3;
    }

    @Override
    public /* synthetic */ int getPosition() {
        MapleDisease a2;
        return a2.d;
    }

    public /* synthetic */ boolean isFirst() {
        MapleDisease a2;
        return a2.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ MapleDisease getByMobSkill(int a2) {
        switch (a2) {
            case 120: {
                return SEAL;
            }
            case 121: {
                return DARKNESS;
            }
            case 122: {
                return WEAKEN;
            }
            case 123: {
                return STUN;
            }
            case 124: {
                return CURSE;
            }
            case 125: {
                return POISON;
            }
            case 126: {
                return SLOW;
            }
            case 128: {
                return SEDUCE;
            }
            case 132: {
                return REVERSE_DIRECTION;
            }
            case 133: {
                return ZOMBIFY;
            }
            case 134: {
                return POTION;
            }
            case 135: {
                return SHADOW;
            }
            case 136: {
                return BLIND;
            }
            case 137: {
                return FREEZE;
            }
            case 138: {
                return DISABLE_POTENTIAL;
            }
            case 173: {
                return TORNADO;
            }
            case 799: {
                return FLAG;
            }
        }
        return null;
    }

    public static /* synthetic */ MapleDisease[] values() {
        return (MapleDisease[])ALLATORIxDEMO.clone();
    }

    public static final /* synthetic */ MapleDisease getRandom() {
        block0: while (true) {
            int n2;
            MapleDisease[] arrmapleDisease = MapleDisease.values();
            int n3 = arrmapleDisease.length;
            int n4 = n2 = 0;
            while (true) {
                if (n4 >= n3) continue block0;
                MapleDisease mapleDisease = arrmapleDisease[n2];
                if (Randomizer.nextInt(MapleDisease.values().length) == 0) {
                    return mapleDisease;
                }
                n4 = ++n2;
            }
            break;
        }
    }

    public static /* synthetic */ {
        POTION = new MapleDisease(MapleFamily.ALLATORIxDEMO(">\u000f:\t!\u000e"), 0, GameSetConstants.MAPLE_VERSION >= 134 ? 512L : 0x80000000000L, true, 3);
        SHADOW = new MapleDisease(F.ALLATORIxDEMO("{\u0004i\bg\u001b"), 1, GameSetConstants.MAPLE_VERSION >= 134 ? 1024L : 0x100000000000L, true, 3);
        BLIND = new MapleDisease(MapleFamily.ALLATORIxDEMO("\u0002\"\t \u0004"), 2, GameSetConstants.MAPLE_VERSION >= 134 ? 2048L : 0x200000000000L, true, 3);
        FREEZE = new MapleDisease(F.ALLATORIxDEMO("n\u001em\tr\t"), 3, GameSetConstants.MAPLE_VERSION >= 134 ? 131072L : 0x8000000000000L, true, 3);
        SLOW = new MapleDisease(MapleFamily.ALLATORIxDEMO("=\f!\u0017"), 4, 1L, false, 2);
        MORPH = new MapleDisease(F.ALLATORIxDEMO("\u0001g\u001ex\u0004"), 5, 2L, false, 2);
        SEDUCE = new MapleDisease(MapleFamily.ALLATORIxDEMO("=\u0005*\u0015-\u0005"), 6, 128L, false, 2);
        ZOMBIFY = new MapleDisease(F.ALLATORIxDEMO("\u0016g\u0001j\u0005n\u0015"), 7, 16384L, false, 2);
        REVERSE_DIRECTION = new MapleDisease(MapleFamily.ALLATORIxDEMO("\u0012+\u0016+\u0012=\u00051\u0004'\u0012+\u0003:\t!\u000e"), 8, 524288L, false, 2);
        WEIRD_FLAME = new MapleDisease(F.ALLATORIxDEMO("\u001bm\u0005z\bw\nd\re\t"), 9, 0x8000000L, false, 2);
        STUN = new MapleDisease(MapleFamily.ALLATORIxDEMO("=\u0014;\u000e"), 10, GameSetConstants.MAPLE_VERSION >= 134 ? 131072L : 0x2000000000000L, false, 1);
        POISON = new MapleDisease(F.ALLATORIxDEMO("x\u0003a\u001fg\u0002"), 11, GameSetConstants.MAPLE_VERSION >= 134 ? 262144L : 0x4000000000000L, false, 1);
        SEAL = new MapleDisease(MapleFamily.ALLATORIxDEMO("=\u0005/\f"), 12, GameSetConstants.MAPLE_VERSION >= 134 ? 524288L : 0x8000000000000L, false, 1);
        DARKNESS = new MapleDisease(F.ALLATORIxDEMO("l\rz\u0007f\t{\u001f"), 13, GameSetConstants.MAPLE_VERSION >= 134 ? 0x100000L : 0x10000000000000L, false, 1);
        WEAKEN = new MapleDisease(MapleFamily.ALLATORIxDEMO("9\u0005/\u000b+\u000e"), 14, GameSetConstants.MAPLE_VERSION >= 134 ? 0x40000000L : 0x4000000000000000L, false, 1);
        CURSE = new MapleDisease(F.ALLATORIxDEMO("\u000f}\u001e{\t"), 15, GameSetConstants.MAPLE_VERSION >= 134 ? Integer.MIN_VALUE : Long.MIN_VALUE, false, 1);
        DISABLE_POTENTIAL = new MapleDisease(MapleFamily.ALLATORIxDEMO("\u0004'\u0013/\u0002\"\u00051\u0010!\u0014+\u000e:\t/\f"), 16, 0x4000000L, false, 4);
        TORNADO = new MapleDisease(F.ALLATORIxDEMO("\u0018g\u001ef\rl\u0003"), 17, 0x40000000L, false, 4);
        FLAG = new MapleDisease(MapleFamily.ALLATORIxDEMO("(\f/\u0007"), 18, Integer.MIN_VALUE, false, 5);
        MapleDisease[] arrmapleDisease = new MapleDisease[19];
        arrmapleDisease[0] = POTION;
        arrmapleDisease[1] = SHADOW;
        arrmapleDisease[2] = BLIND;
        arrmapleDisease[3] = FREEZE;
        arrmapleDisease[4] = SLOW;
        arrmapleDisease[5] = MORPH;
        arrmapleDisease[6] = SEDUCE;
        arrmapleDisease[7] = ZOMBIFY;
        arrmapleDisease[8] = REVERSE_DIRECTION;
        arrmapleDisease[9] = WEIRD_FLAME;
        arrmapleDisease[10] = STUN;
        arrmapleDisease[11] = POISON;
        arrmapleDisease[12] = SEAL;
        arrmapleDisease[13] = DARKNESS;
        arrmapleDisease[14] = WEAKEN;
        arrmapleDisease[15] = CURSE;
        arrmapleDisease[16] = DISABLE_POTENTIAL;
        arrmapleDisease[17] = TORNADO;
        arrmapleDisease[18] = FLAG;
        ALLATORIxDEMO = arrmapleDisease;
    }

    public static /* synthetic */ MapleDisease valueOf(String a2) {
        return Enum.valueOf(MapleDisease.class, a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ int getByDisease(MapleDisease a2) {
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 1: {
                return 120;
            }
            case 2: {
                return 121;
            }
            case 3: {
                return 122;
            }
            case 4: {
                return 123;
            }
            case 5: {
                return 124;
            }
            case 6: {
                return 125;
            }
            case 7: {
                return 126;
            }
            case 8: {
                return 128;
            }
            case 9: {
                return 132;
            }
            case 10: {
                return 133;
            }
            case 11: {
                return 134;
            }
            case 12: {
                return 135;
            }
            case 13: {
                return 136;
            }
            case 14: {
                return 137;
            }
            case 15: {
                return 138;
            }
            case 16: {
                return 173;
            }
            case 17: {
                return 799;
            }
        }
        return 0;
    }

    @Override
    public /* synthetic */ long getValue() {
        MapleDisease a2;
        return a2.K;
    }
}

