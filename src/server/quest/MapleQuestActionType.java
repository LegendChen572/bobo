/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 */
package server.quest;

import client.messages.commands.player.\u61b6\u6200\u8c37;
import handling.world.MapleMessengerCharacter;

public final class MapleQuestActionType
extends Enum<MapleQuestActionType> {
    public static final /* synthetic */ /* enum */ MapleQuestActionType charismaEXP;
    public static final /* synthetic */ /* enum */ MapleQuestActionType insightEXP;
    public static final /* synthetic */ /* enum */ MapleQuestActionType exp;
    public static final /* synthetic */ /* enum */ MapleQuestActionType sp;
    public static final /* synthetic */ /* enum */ MapleQuestActionType skill;
    public static final /* synthetic */ /* enum */ MapleQuestActionType buffItemID;
    public static final /* synthetic */ /* enum */ MapleQuestActionType charmEXP;
    public static final /* synthetic */ /* enum */ MapleQuestActionType quest;
    public static final /* synthetic */ /* enum */ MapleQuestActionType item;
    public static final /* synthetic */ /* enum */ MapleQuestActionType senseEXP;
    public static final /* synthetic */ /* enum */ MapleQuestActionType nextQuest;
    public final /* synthetic */ byte d;
    public static final /* synthetic */ /* enum */ MapleQuestActionType infoNumber;
    private static final /* synthetic */ MapleQuestActionType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleQuestActionType UNDEFINED;
    public static final /* synthetic */ /* enum */ MapleQuestActionType willEXP;
    public static final /* synthetic */ /* enum */ MapleQuestActionType craftEXP;
    public static final /* synthetic */ /* enum */ MapleQuestActionType money;
    public static final /* synthetic */ /* enum */ MapleQuestActionType pop;

    public static /* synthetic */ MapleQuestActionType valueOf(String a2) {
        return Enum.valueOf(MapleQuestActionType.class, a2);
    }

    public static /* synthetic */ MapleQuestActionType[] values() {
        return (MapleQuestActionType[])ALLATORIxDEMO.clone();
    }

    public /* synthetic */ byte getType() {
        MapleQuestActionType a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleQuestActionType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        MapleQuestActionType a3;
        a3.d = (byte)a2;
    }

    public static /* synthetic */ {
        UNDEFINED = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("Q@@KBGJK@"), 0, -1);
        exp = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"oaz"), 1, 0);
        item = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("gpki"), 2, 1);
        nextQuest = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"d|rm[loj~"), 3, 2);
        money = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("iajk}"), 4, 3);
        quest = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"{loj~"), 5, 4);
        skill = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("wembh"), 6, 5);
        pop = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"zvz"), 7, 6);
        buffItemID = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("lqhbGpkiG@"), 8, 7);
        infoNumber = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"pd\u007feW\u007fth|x"), 9, 8);
        sp = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("}t"), 10, 9);
        charismaEXP = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"iqkkcjgxOAZ"), 11, 10);
        charmEXP = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("mlovcAVT"), 12, 11);
        willEXP = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"}pfuOAZ"), 13, 12);
        insightEXP = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("gj}milzAVT"), 14, 13);
        senseEXP = new MapleQuestActionType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"jowy|OAZ"), 15, 14);
        craftEXP = new MapleQuestActionType(MapleMessengerCharacter.ALLATORIxDEMO("mvobzAVT"), 16, 15);
        MapleQuestActionType[] arrmapleQuestActionType = new MapleQuestActionType[17];
        arrmapleQuestActionType[0] = UNDEFINED;
        arrmapleQuestActionType[1] = exp;
        arrmapleQuestActionType[2] = item;
        arrmapleQuestActionType[3] = nextQuest;
        arrmapleQuestActionType[4] = money;
        arrmapleQuestActionType[5] = quest;
        arrmapleQuestActionType[6] = skill;
        arrmapleQuestActionType[7] = pop;
        arrmapleQuestActionType[8] = buffItemID;
        arrmapleQuestActionType[9] = infoNumber;
        arrmapleQuestActionType[10] = sp;
        arrmapleQuestActionType[11] = charismaEXP;
        arrmapleQuestActionType[12] = charmEXP;
        arrmapleQuestActionType[13] = willEXP;
        arrmapleQuestActionType[14] = insightEXP;
        arrmapleQuestActionType[15] = senseEXP;
        arrmapleQuestActionType[16] = craftEXP;
        ALLATORIxDEMO = arrmapleQuestActionType;
    }

    public static /* synthetic */ MapleQuestActionType getByWZName(String a2) {
        try {
            return MapleQuestActionType.valueOf(a2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return UNDEFINED;
        }
    }

    public static /* synthetic */ MapleQuestActionType getByType(byte a2) {
        int n2;
        MapleQuestActionType[] arrmapleQuestActionType = MapleQuestActionType.values();
        int n3 = arrmapleQuestActionType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleQuestActionType mapleQuestActionType = arrmapleQuestActionType[n2];
            if (mapleQuestActionType.getType() == a2) {
                return mapleQuestActionType;
            }
            n4 = ++n2;
        }
        return null;
    }
}

