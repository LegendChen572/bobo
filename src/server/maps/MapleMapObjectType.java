/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import FuckingHackerToby.K;
import server.maps.MapleMapEffect;

public final class MapleMapObjectType
extends Enum<MapleMapObjectType> {
    public static final /* synthetic */ /* enum */ MapleMapObjectType MIST;
    public static final /* synthetic */ /* enum */ MapleMapObjectType ITEM;
    public static final /* synthetic */ /* enum */ MapleMapObjectType SUMMON;
    public static final /* synthetic */ /* enum */ MapleMapObjectType REACTOR;
    private static final /* synthetic */ MapleMapObjectType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleMapObjectType HIRED_MERCHANT;
    public static final /* synthetic */ /* enum */ MapleMapObjectType HIRED_FISHING;
    public static final /* synthetic */ /* enum */ MapleMapObjectType EXTRACTOR;
    public static final /* synthetic */ /* enum */ MapleMapObjectType NPC;
    public static final /* synthetic */ /* enum */ MapleMapObjectType SHOP;
    public static final /* synthetic */ /* enum */ MapleMapObjectType DOOR;
    public static final /* synthetic */ /* enum */ MapleMapObjectType Kite;
    public static final /* synthetic */ /* enum */ MapleMapObjectType FAMILIAR;
    public static final /* synthetic */ /* enum */ MapleMapObjectType PLAYER;
    public static final /* synthetic */ /* enum */ MapleMapObjectType MONSTER;

    public static /* synthetic */ {
        NPC = new MapleMapObjectType(K.ALLATORIxDEMO("[JV"), 0);
        MONSTER = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("\u0003x\u0000d\u001ar\u001c"), 1);
        ITEM = new MapleMapObjectType(K.ALLATORIxDEMO("SA_X"), 2);
        PLAYER = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("g\u0002v\u0017r\u001c"), 3);
        DOOR = new MapleMapObjectType(K.ALLATORIxDEMO("^ZUG"), 4);
        SUMMON = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("d\u001bz\u0003x\u0000"), 5);
        SHOP = new MapleMapObjectType(K.ALLATORIxDEMO("I]UE"), 6);
        Kite = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("|'C+"), 7);
        MIST = new MapleMapObjectType(K.ALLATORIxDEMO("W\\IA"), 8);
        REACTOR = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("\u001cr\u000ft\u001ax\u001c"), 9);
        EXTRACTOR = new MapleMapObjectType(K.ALLATORIxDEMO("PBAHTYAUG"), 10);
        HIRED_MERCHANT = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("\u007f\u0007e\u000bs\u0011z\u000be\r\u007f\u000fy\u001a"), 11);
        HIRED_FISHING = new MapleMapObjectType(K.ALLATORIxDEMO("]SG_QESSFR\\TR"), 12);
        FAMILIAR = new MapleMapObjectType(MapleMapEffect.ALLATORIxDEMO("q\u000fz\u0007{\u0007v\u001c"), 13);
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[14];
        arrmapleMapObjectType[0] = NPC;
        arrmapleMapObjectType[1] = MONSTER;
        arrmapleMapObjectType[2] = ITEM;
        arrmapleMapObjectType[3] = PLAYER;
        arrmapleMapObjectType[4] = DOOR;
        arrmapleMapObjectType[5] = SUMMON;
        arrmapleMapObjectType[6] = SHOP;
        arrmapleMapObjectType[7] = Kite;
        arrmapleMapObjectType[8] = MIST;
        arrmapleMapObjectType[9] = REACTOR;
        arrmapleMapObjectType[10] = EXTRACTOR;
        arrmapleMapObjectType[11] = HIRED_MERCHANT;
        arrmapleMapObjectType[12] = HIRED_FISHING;
        arrmapleMapObjectType[13] = FAMILIAR;
        ALLATORIxDEMO = arrmapleMapObjectType;
    }

    public static /* synthetic */ MapleMapObjectType[] values() {
        return (MapleMapObjectType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ MapleMapObjectType valueOf(String a2) {
        return Enum.valueOf(MapleMapObjectType.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleMapObjectType() {
        void var2_-1;
        void var1_-1;
        MapleMapObjectType a2;
    }
}

