/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import handling.world.family.MapleFamily;
import server.life.MobNameData;

public final class MapleInventoryType
extends Enum<MapleInventoryType> {
    public static final /* synthetic */ /* enum */ MapleInventoryType CASH;
    public static final /* synthetic */ /* enum */ MapleInventoryType ETC;
    public final /* synthetic */ byte d;
    public static final /* synthetic */ /* enum */ MapleInventoryType EQUIP;
    public static final /* synthetic */ /* enum */ MapleInventoryType USE;
    public static final /* synthetic */ /* enum */ MapleInventoryType SETUP;
    private static final /* synthetic */ MapleInventoryType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleInventoryType EQUIPPED;
    public static final /* synthetic */ /* enum */ MapleInventoryType HAIR;
    public static final /* synthetic */ /* enum */ MapleInventoryType UNDEFINED;
    public static final /* synthetic */ /* enum */ MapleInventoryType FACE;

    public /* synthetic */ short getBitfieldEncoding() {
        MapleInventoryType a2;
        return (short)(2 << a2.d);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleInventoryType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        MapleInventoryType a3;
        a3.d = (byte)a2;
    }

    public static /* synthetic */ MapleInventoryType valueOf(String a2) {
        return Enum.valueOf(MapleInventoryType.class, a2);
    }

    public static /* synthetic */ MapleInventoryType getByType(byte a2) {
        int n2;
        MapleInventoryType[] arrmapleInventoryType = MapleInventoryType.values();
        int n3 = arrmapleInventoryType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleInventoryType mapleInventoryType = arrmapleInventoryType[n2];
            if (mapleInventoryType.getType() == a2) {
                return mapleInventoryType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public /* synthetic */ byte getType() {
        MapleInventoryType a2;
        return a2.d;
    }

    public static /* synthetic */ MapleInventoryType[] values() {
        return (MapleInventoryType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        UNDEFINED = new MapleInventoryType(MobNameData.ALLATORIxDEMO("g`vktg|kv"), 0, 0);
        FACE = new MapleInventoryType(MapleFamily.ALLATORIxDEMO("(\u0001-\u0005"), 1, 0);
        HAIR = new MapleInventoryType(MobNameData.ALLATORIxDEMO("fsg`"), 2, 0);
        EQUIP = new MapleInventoryType(MapleFamily.ALLATORIxDEMO("\u0005?\u0015'\u0010"), 3, 1);
        USE = new MapleInventoryType(MobNameData.ALLATORIxDEMO("g}w"), 4, 2);
        SETUP = new MapleInventoryType(MapleFamily.ALLATORIxDEMO("\u0013+\u0014;\u0010"), 5, 3);
        ETC = new MapleInventoryType(MobNameData.ALLATORIxDEMO("wzq"), 6, 4);
        CASH = new MapleInventoryType(MapleFamily.ALLATORIxDEMO("-\u0001=\b"), 7, 5);
        EQUIPPED = new MapleInventoryType(MobNameData.ALLATORIxDEMO("kc{{~bkv"), 8, -1);
        MapleInventoryType[] arrmapleInventoryType = new MapleInventoryType[9];
        arrmapleInventoryType[0] = UNDEFINED;
        arrmapleInventoryType[1] = FACE;
        arrmapleInventoryType[2] = HAIR;
        arrmapleInventoryType[3] = EQUIP;
        arrmapleInventoryType[4] = USE;
        arrmapleInventoryType[5] = SETUP;
        arrmapleInventoryType[6] = ETC;
        arrmapleInventoryType[7] = CASH;
        arrmapleInventoryType[8] = EQUIPPED;
        ALLATORIxDEMO = arrmapleInventoryType;
    }

    public static /* synthetic */ MapleInventoryType getByWZName(String a2) {
        if (a2.equals(MapleFamily.ALLATORIxDEMO("\t\u00003\u001a!\u0002,"))) {
            return SETUP;
        }
        if (a2.equals(MobNameData.ALLATORIxDEMO("qA\\]GCW"))) {
            return USE;
        }
        if (a2.equals(MapleFamily.ALLATORIxDEMO("\u0005\u001a#"))) {
            return ETC;
        }
        if (a2.equals(MobNameData.ALLATORIxDEMO("mS]Z"))) {
            return CASH;
        }
        if (a2.equals(MapleFamily.ALLATORIxDEMO("\u0010\u000b4"))) {
            return CASH;
        }
        return UNDEFINED;
    }
}

