/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import client.messages.commands.player.eventSystem.MonsterPetSystem;
import constants.GameSetConstants;
import server.MapleShopItem;

public final class MapleEventType
extends Enum<MapleEventType> {
    public static final /* synthetic */ /* enum */ MapleEventType \u4f60\u7684\u751f\u6b7b;
    public /* synthetic */ int world;
    public static final /* synthetic */ /* enum */ MapleEventType \u662f\u975e\u984c\u5927\u8003\u9a57;
    public static final /* synthetic */ /* enum */ MapleEventType \u6efe\u96ea\u7403;
    public static final /* synthetic */ /* enum */ MapleEventType \u5c0b\u5bf6;
    public /* synthetic */ int[] mapids;
    public static final /* synthetic */ /* enum */ MapleEventType \u6253\u74f6\u84cb;
    public static final /* synthetic */ /* enum */ MapleEventType \u7d42\u6975\u5fcd\u8010;
    public /* synthetic */ String command;
    private static final /* synthetic */ MapleEventType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleEventType \u6253\u679c\u5b50;
    public static final /* synthetic */ /* enum */ MapleEventType \u722c\u7e69\u5b50;
    public /* synthetic */ int channel;

    public static final /* synthetic */ MapleEventType getByString(String a2) {
        int n2;
        MapleEventType[] arrmapleEventType = MapleEventType.values();
        int n3 = arrmapleEventType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleEventType mapleEventType = arrmapleEventType[n2];
            if (mapleEventType.command.equalsIgnoreCase(a2)) {
                return mapleEventType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ {
        int[] arrn;
        int[] arrn2 = new int[1];
        arrn2[0] = 109080000;
        \u6253\u679c\u5b50 = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u622f\u67bb\u5b2c"), 0, MonsterPetSystem.ALLATORIxDEMO("\u6200\u67c4\u5b03"), arrn2, 1);
        int[] arrn3 = new int[1];
        arrn3[0] = 109080010;
        \u6253\u74f6\u84cb = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u622f\u74d1\u84b7"), 1, MonsterPetSystem.ALLATORIxDEMO("\u6200\u74ae\u8498"), arrn3, 1);
        int[] arrn4 = new int[5];
        arrn4[0] = 109040000;
        arrn4[1] = 109040001;
        arrn4[2] = 109040002;
        arrn4[3] = 109040003;
        arrn4[4] = 109040004;
        \u7d42\u6975\u5fcd\u8010 = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u7d65\u6909\u5fea\u806c"), 2, MonsterPetSystem.ALLATORIxDEMO("\u7d1a\u6926\u5f95\u8043"), arrn4, 1);
        String string = MapleShopItem.ALLATORIxDEMO("\u7250\u7e4e\u5b2c");
        String string2 = MonsterPetSystem.ALLATORIxDEMO("\u727f\u7e31\u5b03");
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            int[] arrn5 = new int[3];
            arrn5[0] = 109030201;
            arrn5[1] = 109030202;
            arrn = arrn5;
            arrn5[2] = 109030203;
        } else {
            int[] arrn6 = new int[3];
            arrn6[0] = 109030001;
            arrn6[1] = 109030002;
            arrn = arrn6;
            arrn6[2] = 109030003;
        }
        \u722c\u7e69\u5b50 = new MapleEventType(string, 3, string2, arrn, 1);
        int[] arrn7 = new int[1];
        arrn7[0] = 109020001;
        \u662f\u975e\u984c\u5927\u8003\u9a57 = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u6608\u9722\u986b\u595b\u8024\u9a2b"), 4, MonsterPetSystem.ALLATORIxDEMO("\u6677\u970d\u9814\u5974\u805b\u9a04"), arrn7, 1);
        int[] arrn8 = new int[1];
        arrn8[0] = 109060000;
        \u6efe\u96ea\u7403 = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u6e82\u96cd\u747f"), 5, MonsterPetSystem.ALLATORIxDEMO("\u6ead\u96b2\u7450"), arrn8, 1);
        int[] arrn9 = new int[18];
        arrn9[0] = 109010000;
        arrn9[1] = 109010100;
        arrn9[2] = 109010102;
        arrn9[3] = 109010103;
        arrn9[4] = 109010104;
        arrn9[5] = 109010105;
        arrn9[6] = 109010106;
        arrn9[7] = 109010107;
        arrn9[8] = 109010108;
        arrn9[9] = 109010109;
        arrn9[10] = 109010110;
        arrn9[11] = 109010200;
        arrn9[12] = 109010201;
        arrn9[13] = 109010202;
        arrn9[14] = 109010203;
        arrn9[15] = 109010204;
        arrn9[16] = 109010205;
        arrn9[17] = 109010206;
        \u5c0b\u5bf6 = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u5c2c\u5b8a"), 6, MonsterPetSystem.ALLATORIxDEMO("\u5c53\u5ba5"), arrn9, 1);
        int[] arrn10 = new int[1];
        arrn10[0] = 109020001;
        \u4f60\u7684\u751f\u6b7b = new MapleEventType(MapleShopItem.ALLATORIxDEMO("\u4f47\u76f8\u7538\u6b07"), 7, MonsterPetSystem.ALLATORIxDEMO("\u4f38\u76d7\u7547\u6b28"), arrn10, 1);
        MapleEventType[] arrmapleEventType = new MapleEventType[8];
        arrmapleEventType[0] = \u6253\u679c\u5b50;
        arrmapleEventType[1] = \u6253\u74f6\u84cb;
        arrmapleEventType[2] = \u7d42\u6975\u5fcd\u8010;
        arrmapleEventType[3] = \u722c\u7e69\u5b50;
        arrmapleEventType[4] = \u662f\u975e\u984c\u5927\u8003\u9a57;
        arrmapleEventType[5] = \u6efe\u96ea\u7403;
        arrmapleEventType[6] = \u5c0b\u5bf6;
        arrmapleEventType[7] = \u4f60\u7684\u751f\u6b7b;
        ALLATORIxDEMO = arrmapleEventType;
    }

    public static /* synthetic */ MapleEventType valueOf(String a2) {
        return Enum.valueOf(MapleEventType.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleEventType(String string2, int[] string2, int a2) {
        void a3;
        void a4;
        void var2_-1;
        void var1_-1;
        MapleEventType a5;
        MapleEventType mapleEventType = a5;
        a5.command = (String)a2;
        mapleEventType.mapids = a4;
        mapleEventType.channel = a3;
    }

    public static /* synthetic */ MapleEventType[] values() {
        return (MapleEventType[])ALLATORIxDEMO.clone();
    }
}

