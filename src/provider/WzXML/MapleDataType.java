/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import constants.MobConstants;
import handling.channel.handler.NPCHandler;

public final class MapleDataType
extends Enum<MapleDataType> {
    public static final /* synthetic */ /* enum */ MapleDataType UNKNOWN_TYPE;
    public static final /* synthetic */ /* enum */ MapleDataType CONVEX;
    public static final /* synthetic */ /* enum */ MapleDataType FLOAT;
    public static final /* synthetic */ /* enum */ MapleDataType IMG_0x00;
    public static final /* synthetic */ /* enum */ MapleDataType PROPERTY;
    public static final /* synthetic */ /* enum */ MapleDataType SOUND;
    private static final /* synthetic */ MapleDataType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleDataType VECTOR;
    public static final /* synthetic */ /* enum */ MapleDataType EXTENDED;
    public static final /* synthetic */ /* enum */ MapleDataType CANVAS;
    public static final /* synthetic */ /* enum */ MapleDataType UNKNOWN_EXTENDED_TYPE;
    public static final /* synthetic */ /* enum */ MapleDataType INT;
    public static final /* synthetic */ /* enum */ MapleDataType DOUBLE;
    public static final /* synthetic */ /* enum */ MapleDataType STRING;
    public static final /* synthetic */ /* enum */ MapleDataType NONE;
    public static final /* synthetic */ /* enum */ MapleDataType SHORT;
    public static final /* synthetic */ /* enum */ MapleDataType UOL;

    public static /* synthetic */ {
        NONE = new MapleDataType(MobConstants.ALLATORIxDEMO("L{Lq"), 0);
        IMG_0x00 = new MapleDataType(NPCHandler.ALLATORIxDEMO(".N \\W{W3"), 1);
        SHORT = new MapleDataType(MobConstants.ALLATORIxDEMO("gJ{P`"), 2);
        INT = new MapleDataType(NPCHandler.ALLATORIxDEMO("J)W"), 3);
        FLOAT = new MapleDataType(MobConstants.ALLATORIxDEMO("rN{C`"), 4);
        DOUBLE = new MapleDataType(NPCHandler.ALLATORIxDEMO("#L2A+F"), 5);
        STRING = new MapleDataType(MobConstants.ALLATORIxDEMO("Q`P}Ls"), 6);
        EXTENDED = new MapleDataType(NPCHandler.ALLATORIxDEMO("\"[3F)G\"G"), 7);
        PROPERTY = new MapleDataType(MobConstants.ALLATORIxDEMO("RfMdGfVm"), 8);
        CANVAS = new MapleDataType(NPCHandler.ALLATORIxDEMO("$B)U&P"), 9);
        VECTOR = new MapleDataType(MobConstants.ALLATORIxDEMO("TqA`Mf"), 10);
        CONVEX = new MapleDataType(NPCHandler.ALLATORIxDEMO("$L)U\"["), 11);
        SOUND = new MapleDataType(MobConstants.ALLATORIxDEMO("gMaLp"), 12);
        UOL = new MapleDataType(NPCHandler.ALLATORIxDEMO("V(O"), 13);
        UNKNOWN_TYPE = new MapleDataType(MobConstants.ALLATORIxDEMO("WzIzMcLkVmRq"), 14);
        UNKNOWN_EXTENDED_TYPE = new MapleDataType(NPCHandler.ALLATORIxDEMO("V)H)L0M8F?W\"M#F#\\3Z7F"), 15);
        MapleDataType[] arrmapleDataType = new MapleDataType[16];
        arrmapleDataType[0] = NONE;
        arrmapleDataType[1] = IMG_0x00;
        arrmapleDataType[2] = SHORT;
        arrmapleDataType[3] = INT;
        arrmapleDataType[4] = FLOAT;
        arrmapleDataType[5] = DOUBLE;
        arrmapleDataType[6] = STRING;
        arrmapleDataType[7] = EXTENDED;
        arrmapleDataType[8] = PROPERTY;
        arrmapleDataType[9] = CANVAS;
        arrmapleDataType[10] = VECTOR;
        arrmapleDataType[11] = CONVEX;
        arrmapleDataType[12] = SOUND;
        arrmapleDataType[13] = UOL;
        arrmapleDataType[14] = UNKNOWN_TYPE;
        arrmapleDataType[15] = UNKNOWN_EXTENDED_TYPE;
        ALLATORIxDEMO = arrmapleDataType;
    }

    public static /* synthetic */ MapleDataType[] values() {
        return (MapleDataType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ MapleDataType valueOf(String a2) {
        return Enum.valueOf(MapleDataType.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleDataType() {
        void var2_-1;
        void var1_-1;
        MapleDataType a2;
    }
}

