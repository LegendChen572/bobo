/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.inventory.MapleAndroid;
import server.gashapon.GashaponRewardSpecial;

public final class ItemFlag
extends Enum<ItemFlag> {
    public static final /* synthetic */ /* enum */ ItemFlag KARMA_USE;
    public static final /* synthetic */ /* enum */ ItemFlag CHARM_EQUIPPED;
    private static final /* synthetic */ ItemFlag[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ ItemFlag CRAFTED_USE;
    public static final /* synthetic */ /* enum */ ItemFlag SCROLL_PROTECT;
    public static final /* synthetic */ /* enum */ ItemFlag SHIELD_WARD;
    public static final /* synthetic */ /* enum */ ItemFlag LOCK;
    public static final /* synthetic */ /* enum */ ItemFlag LUCKS_KEY;
    public static final /* synthetic */ /* enum */ ItemFlag ANDROID_ACTIVATED;
    public static final /* synthetic */ /* enum */ ItemFlag SLOTS_PROTECT;
    public static final /* synthetic */ /* enum */ ItemFlag KARMA_EQ;
    public static final /* synthetic */ /* enum */ ItemFlag SPIKES;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ ItemFlag KARMA_ACC;
    public static final /* synthetic */ /* enum */ ItemFlag KARMA_ACC_USE;
    public static final /* synthetic */ /* enum */ ItemFlag UNTRADEABLE;
    public static final /* synthetic */ /* enum */ ItemFlag CRAFTED;
    public static final /* synthetic */ /* enum */ ItemFlag COLD;

    public final /* synthetic */ int getValue() {
        ItemFlag a2;
        return a2.d;
    }

    public static /* synthetic */ {
        LOCK = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("HhGl"), 0, 1);
        SPIKES = new ItemFlag(MapleAndroid.ALLATORIxDEMO(" G:\\6D"), 1, 2);
        COLD = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("GhHc"), 2, 4);
        UNTRADEABLE = new ItemFlag(MapleAndroid.ALLATORIxDEMO("B=C!V7R2U?R"), 3, 8);
        KARMA_EQ = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("OfVjExAv"), 4, 16);
        KARMA_USE = new ItemFlag(MapleAndroid.ALLATORIxDEMO("\\2E>V,B R"), 5, 2);
        CHARM_EQUIPPED = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("GoEuIxAvQnTwAc"), 6, 32);
        ANDROID_ACTIVATED = new ItemFlag(MapleAndroid.ALLATORIxDEMO("V=S!X:S,V0C:A2C6S"), 7, 64);
        CRAFTED = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("dVfBsAc"), 8, 128);
        CRAFTED_USE = new ItemFlag(MapleAndroid.ALLATORIxDEMO("T!V5C6S,B R"), 9, 16);
        SHIELD_WARD = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("tLnAk@xSfVc"), 10, 256);
        LUCKS_KEY = new ItemFlag(MapleAndroid.ALLATORIxDEMO("[&T8D,\\6N"), 11, 512);
        KARMA_ACC_USE = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("lEuIf[fGd[rWb"), 12, 1024);
        KARMA_ACC = new ItemFlag(MapleAndroid.ALLATORIxDEMO("\\2E>V,V0T"), 13, 4096);
        SLOTS_PROTECT = new ItemFlag(GashaponRewardSpecial.ALLATORIxDEMO("tHhPt[wVhPbGs"), 14, 8192);
        SCROLL_PROTECT = new ItemFlag(MapleAndroid.ALLATORIxDEMO(" T!X?[,G!X'R0C"), 15, 16384);
        ItemFlag[] arritemFlag = new ItemFlag[16];
        arritemFlag[0] = LOCK;
        arritemFlag[1] = SPIKES;
        arritemFlag[2] = COLD;
        arritemFlag[3] = UNTRADEABLE;
        arritemFlag[4] = KARMA_EQ;
        arritemFlag[5] = KARMA_USE;
        arritemFlag[6] = CHARM_EQUIPPED;
        arritemFlag[7] = ANDROID_ACTIVATED;
        arritemFlag[8] = CRAFTED;
        arritemFlag[9] = CRAFTED_USE;
        arritemFlag[10] = SHIELD_WARD;
        arritemFlag[11] = LUCKS_KEY;
        arritemFlag[12] = KARMA_ACC_USE;
        arritemFlag[13] = KARMA_ACC;
        arritemFlag[14] = SLOTS_PROTECT;
        arritemFlag[15] = SCROLL_PROTECT;
        ALLATORIxDEMO = arritemFlag;
    }

    public static /* synthetic */ ItemFlag[] values() {
        return (ItemFlag[])ALLATORIxDEMO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ItemFlag(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        ItemFlag a3;
        a3.d = a2;
    }

    public final /* synthetic */ boolean check(int a2) {
        ItemFlag a3;
        return (a2 & a3.d) == a3.d;
    }

    public static /* synthetic */ ItemFlag valueOf(String a2) {
        return Enum.valueOf(ItemFlag.class, a2);
    }
}

