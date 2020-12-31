/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.MapleCoolDownValueHolder;
import constants.GameSetConstants;
import handling.world.sidekick.MapleSidekick;

public final class MapleWeaponType
extends Enum<MapleWeaponType> {
    public static final /* synthetic */ /* enum */ MapleWeaponType \u52a0\u8fb2\u7832;
    private final /* synthetic */ float a;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u706b\u69cd;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u55ae\u624b\u528d;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u6c92\u6709\u6b66\u5668;
    private static final /* synthetic */ MapleWeaponType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u9583\u4eae\u514b\u9b6f;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u96d9\u624b\u65a7;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u6247\u5b50;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u9b54\u6cd5\u7bad;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u9748\u9b42\u5c04\u624b;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u55ae\u624b\u65a7;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u5f13;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u77db;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u7483;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u592a\u5200;
    public static final /* synthetic */ /* enum */ MapleWeaponType NOT_A_WEAPON;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u7409;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u624b\u6756;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u96d9\u5200;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u96d9\u624b\u528d;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u77ed\u6756;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u77ed\u528d;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u69cd;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u96d9\u5f29;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u62f3\u5957;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u672a\u77e5;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u55ae\u624b\u68cd;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u5f29;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u6307\u864e;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u96d9\u624b\u68cd;
    public static final /* synthetic */ /* enum */ MapleWeaponType \u9577\u6756;

    public final /* synthetic */ float getMaxDamageMultiplier() {
        MapleWeaponType a2;
        return a2.a;
    }

    public static /* synthetic */ {
        NOT_A_WEAPON = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("-?7/\"/45\" ,>"), 0, 1.43f, 20);
        \u6c92\u6709\u6b66\u5668 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u6cc9\u672a\u6b3d\u564b"), 1, 0.0f, 0);
        \u55ae\u624b\u528d = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u55de\u6228\u52fd"), 2, 1.2f, 20);
        \u55ae\u624b\u65a7 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u558d\u6210\u6584"), 3, 1.2f, 20);
        \u55ae\u624b\u68cd = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u55de\u6228\u68bd"), 4, 1.2f, 20);
        \u624b\u6756 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u6210\u6775"), 5, 1.3f, 15);
        \u77ed\u528d = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u778e\u52fd"), 6, 1.3f, 20);
        \u77ed\u6756 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u77b6\u6775"), 7, GameSetConstants.MAPLE_VERSION >= 134 ? 1.2f : 1.0f, 25);
        \u9577\u6756 = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u9514\u6726"), 8, GameSetConstants.MAPLE_VERSION >= 134 ? 1.2f : 1.0f, 25);
        \u9583\u4eae\u514b\u9b6f = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u95d8\u4e8d\u5110\u9b4c"), 9, 1.2f, 25);
        \u96d9\u624b\u528d = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u96a9\u6228\u52fd"), 10, GameSetConstants.MAPLE_VERSION >= 134 ? 1.32f : 1.34f, 20);
        \u96d9\u624b\u65a7 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u96fa\u6210\u6584"), 11, GameSetConstants.MAPLE_VERSION >= 134 ? 1.32f : 1.34f, 20);
        \u96d9\u624b\u68cd = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u96a9\u6228\u68bd"), 12, GameSetConstants.MAPLE_VERSION >= 134 ? 1.32f : 1.34f, 20);
        \u69cd = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u69ee"), 13, 1.49f, 20);
        \u77db = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u77ab"), 14, 1.49f, 20);
        \u5f13 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5f30"), 15, GameSetConstants.MAPLE_VERSION >= 134 ? 1.2f : 1.3f, 15);
        \u5f29 = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u5f59"), 16, 1.35f, 15);
        \u62f3\u5957 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u62a8\u5974"), 17, 1.75f, 15);
        \u6307\u864e = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u6364\u863e"), 18, 1.7f, 20);
        \u706b\u69cd = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u7030\u69ee"), 19, 1.5f, 15);
        \u9748\u9b42\u5c04\u624b = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u972b\u9b32\u5c67\u623b"), 20, 1.7f, 15);
        \u52a0\u8fb2\u7832 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5283\u8fe9\u7811"), 21, 1.35f, 15);
        \u96d9\u5f29 = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u96ba\u5f59"), 22, 2.0f, 15);
        \u9b54\u6cd5\u7bad = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u9b77\u6c8e\u7b8e"), 23, 2.0f, 15);
        \u96d9\u5200 = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u96ba\u5270"), 24, 1.3f, 20);
        \u592a\u5200 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5971\u5223"), 25, 1.25f, 20);
        \u6247\u5b50 = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u6224\u5b20"), 26, 1.35f, 25);
        \u7409 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u742a"), 27, 1.49f, 20);
        \u7483 = new MapleWeaponType(MapleSidekick.ALLATORIxDEMO("\u74f3"), 28, 1.34f, 20);
        \u672a\u77e5 = new MapleWeaponType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u6771\u77c6"), 29, 0.0f, 0);
        MapleWeaponType[] arrmapleWeaponType = new MapleWeaponType[30];
        arrmapleWeaponType[0] = NOT_A_WEAPON;
        arrmapleWeaponType[1] = \u6c92\u6709\u6b66\u5668;
        arrmapleWeaponType[2] = \u55ae\u624b\u528d;
        arrmapleWeaponType[3] = \u55ae\u624b\u65a7;
        arrmapleWeaponType[4] = \u55ae\u624b\u68cd;
        arrmapleWeaponType[5] = \u624b\u6756;
        arrmapleWeaponType[6] = \u77ed\u528d;
        arrmapleWeaponType[7] = \u77ed\u6756;
        arrmapleWeaponType[8] = \u9577\u6756;
        arrmapleWeaponType[9] = \u9583\u4eae\u514b\u9b6f;
        arrmapleWeaponType[10] = \u96d9\u624b\u528d;
        arrmapleWeaponType[11] = \u96d9\u624b\u65a7;
        arrmapleWeaponType[12] = \u96d9\u624b\u68cd;
        arrmapleWeaponType[13] = \u69cd;
        arrmapleWeaponType[14] = \u77db;
        arrmapleWeaponType[15] = \u5f13;
        arrmapleWeaponType[16] = \u5f29;
        arrmapleWeaponType[17] = \u62f3\u5957;
        arrmapleWeaponType[18] = \u6307\u864e;
        arrmapleWeaponType[19] = \u706b\u69cd;
        arrmapleWeaponType[20] = \u9748\u9b42\u5c04\u624b;
        arrmapleWeaponType[21] = \u52a0\u8fb2\u7832;
        arrmapleWeaponType[22] = \u96d9\u5f29;
        arrmapleWeaponType[23] = \u9b54\u6cd5\u7bad;
        arrmapleWeaponType[24] = \u96d9\u5200;
        arrmapleWeaponType[25] = \u592a\u5200;
        arrmapleWeaponType[26] = \u6247\u5b50;
        arrmapleWeaponType[27] = \u7409;
        arrmapleWeaponType[28] = \u7483;
        arrmapleWeaponType[29] = \u672a\u77e5;
        ALLATORIxDEMO = arrmapleWeaponType;
    }

    public static /* synthetic */ MapleWeaponType[] values() {
        return (MapleWeaponType[])ALLATORIxDEMO.clone();
    }

    public final /* synthetic */ int getBaseMastery() {
        MapleWeaponType a2;
        return a2.d;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ MapleWeaponType(float f22, int f22) {
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        MapleWeaponType a4;
        MapleWeaponType mapleWeaponType = a4;
        mapleWeaponType.a = a3;
        mapleWeaponType.d = a2;
    }

    public static /* synthetic */ MapleWeaponType valueOf(String a2) {
        return Enum.valueOf(MapleWeaponType.class, a2);
    }
}

