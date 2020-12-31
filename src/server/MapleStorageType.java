/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.SummonSkillEntry;
import handling.world.MapleParty;

public final class MapleStorageType
extends Enum<MapleStorageType> {
    public static final /* synthetic */ /* enum */ MapleStorageType STORAGE_EXCEED_ITEM;
    private static final /* synthetic */ MapleStorageType[] ALLATORIxDEMO;
    private final /* synthetic */ int k;
    public static final /* synthetic */ /* enum */ MapleStorageType STORAGE;
    private final /* synthetic */ String d;
    public static final /* synthetic */ /* enum */ MapleStorageType STORAGE_EXCEED_ETC;
    private /* synthetic */ byte K;
    public static final /* synthetic */ /* enum */ MapleStorageType STORAGE_EXCEED_CHAIR;
    private final /* synthetic */ boolean a;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleStorageType(int n22, boolean n22, String a2, byte a3) {
        void a4;
        void a5;
        void var2_-1;
        void var1_-1;
        MapleStorageType a6;
        MapleStorageType mapleStorageType = a6;
        MapleStorageType mapleStorageType2 = a6;
        mapleStorageType2.k = (int)a2;
        mapleStorageType2.a = a3;
        mapleStorageType.d = a5;
        mapleStorageType.K = a4;
    }

    public static /* synthetic */ {
        STORAGE = new MapleStorageType(SummonSkillEntry.ALLATORIxDEMO("`_|YrLv"), false ? 1 : 0, false ? 1 : 0, false, MapleParty.ALLATORIxDEMO("\u0003m\u001fk\u0011~\u0015j"), 4);
        STORAGE_EXCEED_ITEM = new MapleStorageType(SummonSkillEntry.ALLATORIxDEMO("`_|YrLvTvSpNvOlBgN~"), true ? 1 : 0, 0, true, MapleParty.ALLATORIxDEMO("j\u0004v\u0002x\u0017|\u0003F\u0015a\u0013|\u0015}"), 127);
        STORAGE_EXCEED_CHAIR = new MapleStorageType(SummonSkillEntry.ALLATORIxDEMO("XgDaJtNlNkHvNwTpCrBa"), 2, true ? 1 : 0, true, MapleParty.ALLATORIxDEMO("j\u0004v\u0002x\u0017|\u0003F\u0015a\u0013|\u0015}"), 127);
        STORAGE_EXCEED_ETC = new MapleStorageType(SummonSkillEntry.ALLATORIxDEMO("XgDaJtNlNkHvNwTv_p"), 3, 2, true, MapleParty.ALLATORIxDEMO("j\u0004v\u0002x\u0017|\u0003F\u0015a\u0013|\u0015}"), 127);
        MapleStorageType[] arrmapleStorageType = new MapleStorageType[4];
        arrmapleStorageType[0] = STORAGE;
        arrmapleStorageType[1] = STORAGE_EXCEED_ITEM;
        arrmapleStorageType[2] = STORAGE_EXCEED_CHAIR;
        arrmapleStorageType[3] = STORAGE_EXCEED_ETC;
        ALLATORIxDEMO = arrmapleStorageType;
    }

    public /* synthetic */ boolean isExceed() {
        MapleStorageType a2;
        return a2.a;
    }

    public /* synthetic */ String getTable() {
        MapleStorageType a2;
        return a2.d;
    }

    public static /* synthetic */ MapleStorageType valueOf(String a2) {
        return Enum.valueOf(MapleStorageType.class, a2);
    }

    public /* synthetic */ int getValue() {
        MapleStorageType a2;
        return a2.k;
    }

    public static /* synthetic */ MapleStorageType[] values() {
        return (MapleStorageType[])ALLATORIxDEMO.clone();
    }

    public /* synthetic */ byte getCreateSlot() {
        MapleStorageType a2;
        return a2.K;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean checkItem(int a2) {
        MapleStorageType a3;
        boolean bl = true;
        switch (1.ALLATORIxDEMO[a3.ordinal()]) {
            case 1: {
                if (a2 < 3010000) return false;
                if (a2 <= 3019999) return bl;
                return false;
            }
            case 2: {
                if (a2 < 4000000) return false;
                if (a2 <= 4999999) return bl;
                return false;
            }
            case 3: {
                return false;
            }
        }
        return bl;
    }
}

