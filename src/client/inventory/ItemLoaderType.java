/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.messages.commands.PracticerCommand;
import server.swing.autoupdate.GetSelfDocName;

public final class ItemLoaderType
extends Enum<ItemLoaderType> {
    public static final /* synthetic */ /* enum */ ItemLoaderType SENDER;
    public static final /* synthetic */ /* enum */ ItemLoaderType UPGRADESLOTS;
    public static final /* synthetic */ /* enum */ ItemLoaderType VICIOUSHAMMER;
    public static final /* synthetic */ /* enum */ ItemLoaderType MPR;
    public static final /* synthetic */ /* enum */ ItemLoaderType INVENTORYTYPE;
    public static final /* synthetic */ /* enum */ ItemLoaderType CUSTOMFLAG;
    public static final /* synthetic */ /* enum */ ItemLoaderType DEX;
    public static final /* synthetic */ /* enum */ ItemLoaderType MDEF;
    public static final /* synthetic */ /* enum */ ItemLoaderType POTENTIAL5;
    public static final /* synthetic */ /* enum */ ItemLoaderType HP;
    public static final /* synthetic */ /* enum */ ItemLoaderType POTENTIAL4;
    public static final /* synthetic */ /* enum */ ItemLoaderType MATK;
    public static final /* synthetic */ /* enum */ ItemLoaderType PVPDAMAGE;
    public static final /* synthetic */ /* enum */ ItemLoaderType GM_LOG;
    public static final /* synthetic */ /* enum */ ItemLoaderType SPEED;
    public static final /* synthetic */ /* enum */ ItemLoaderType POTENTIAL3;
    public static final /* synthetic */ /* enum */ ItemLoaderType OWNER;
    public static final /* synthetic */ /* enum */ ItemLoaderType WATK;
    public static final /* synthetic */ /* enum */ ItemLoaderType INCSKILL;
    private final /* synthetic */ int d;
    private static final /* synthetic */ ItemLoaderType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ ItemLoaderType MP;
    public static final /* synthetic */ /* enum */ ItemLoaderType EQUIPONLYID;
    public static final /* synthetic */ /* enum */ ItemLoaderType ENHANCE;
    public static final /* synthetic */ /* enum */ ItemLoaderType INVENTORYITEMID;
    public static final /* synthetic */ /* enum */ ItemLoaderType DURABILITY;
    public static final /* synthetic */ /* enum */ ItemLoaderType ITEMID;
    public static final /* synthetic */ /* enum */ ItemLoaderType INT;
    public static final /* synthetic */ /* enum */ ItemLoaderType CRAFTED;
    public static final /* synthetic */ /* enum */ ItemLoaderType QUANTITY;
    public static final /* synthetic */ /* enum */ ItemLoaderType LEVEL;
    public static final /* synthetic */ /* enum */ ItemLoaderType WDEF;
    public static final /* synthetic */ /* enum */ ItemLoaderType STR;
    public static final /* synthetic */ /* enum */ ItemLoaderType CHARMEXP;
    public static final /* synthetic */ /* enum */ ItemLoaderType JUMP;
    public static final /* synthetic */ /* enum */ ItemLoaderType EXPIREDATE;
    public static final /* synthetic */ /* enum */ ItemLoaderType POTENTIAL2;
    public static final /* synthetic */ /* enum */ ItemLoaderType ACC;
    public static final /* synthetic */ /* enum */ ItemLoaderType ITEMEXP;
    public static final /* synthetic */ /* enum */ ItemLoaderType POSITION;
    public static final /* synthetic */ /* enum */ ItemLoaderType HANDS;
    public static final /* synthetic */ /* enum */ ItemLoaderType TYPE;
    public static final /* synthetic */ /* enum */ ItemLoaderType HPR;
    public static final /* synthetic */ /* enum */ ItemLoaderType POTENTIAL1;
    public static final /* synthetic */ /* enum */ ItemLoaderType UNIQUEID;
    public static final /* synthetic */ /* enum */ ItemLoaderType AVOID;
    public static final /* synthetic */ /* enum */ ItemLoaderType FLAG;
    public static final /* synthetic */ /* enum */ ItemLoaderType LUK;

    public static /* synthetic */ ItemLoaderType[] values() {
        return (ItemLoaderType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        INVENTORYITEMID = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("2I-B5S4U\"N/B6N?"), 0, 1);
        ITEMID = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("-]!D-M"), 1, 2);
        INVENTORYTYPE = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("2I-B5S4U\"S\"W>"), 2, 3);
        POSITION = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("4F7@0@+G"), 3, 4);
        QUANTITY = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("V.F5S2S\""), 4, 5);
        OWNER = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("F3G!["), 5, 6);
        GM_LOG = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("@6X7H<"), 6, 7);
        UNIQUEID = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("1G-X1L-M"), 7, 8);
        CRAFTED = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("8U:A/B?"), 8, 9);
        EXPIREDATE = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("!Q4@6L H0L"), 9, 10);
        FLAG = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("A7F<"), 10, 11);
        TYPE = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("0P4L"), 11, 12);
        SENDER = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("T>I?B)"), 12, 13);
        EQUIPONLYID = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("L5\\-Y+G(P-M"), 13, 14);
        UPGRADESLOTS = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("R+@)F?B(K4S("), 14, 15);
        LEVEL = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("E!_!E"), 15, 16);
        STR = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("(S)"), 16, 17);
        DEX = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("M!Q"), 17, 18);
        INT = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("2I/"), 18, 19);
        LUK = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("E1B"), 19, 20);
        HP = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("O+"), 20, 21);
        MP = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO(")Y"), 21, 22);
        WATK = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("P:S0"), 22, 23);
        MATK = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO(")H0B"), 23, 24);
        WDEF = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("P?B="), 24, 25);
        MDEF = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO(")M!O"), 25, 26);
        ACC = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO(":D8"), 26, 27);
        AVOID = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("H2F-M"), 27, 28);
        HANDS = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("3F5C("), 28, 29);
        SPEED = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("Z4L!M"), 29, 30);
        JUMP = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("M.J+"), 30, 31);
        VICIOUSHAMMER = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("_-J-F1Z,H)D!["), 31, 32);
        ITEMEXP = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("2S>J>_+"), 32, 33);
        DURABILITY = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO(" \\6H&@(@0P"), 33, 34);
        ENHANCE = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO(">I3F5D>"), 34, 35);
        POTENTIAL1 = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("4F0L*]-H(8"), 35, 36);
        POTENTIAL2 = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("W4S>I/N:KI"), 36, 37);
        POTENTIAL3 = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("4F0L*]-H(:"), 37, 38);
        INCSKILL = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("N5D(L2K7"), 38, 39);
        HPR = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("A4["), 39, 40);
        MPR = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("6W)"), 40, 41);
        CHARMEXP = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("'A%[)L<Y"), 41, 42);
        PVPDAMAGE = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("+Q+C:J:@>"), 42, 43);
        POTENTIAL4 = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("4F0L*]-H(="), 43, 44);
        POTENTIAL5 = new ItemLoaderType(PracticerCommand.ALLATORIxDEMO("W4S>I/N:KN"), 44, 45);
        CUSTOMFLAG = new ItemLoaderType(GetSelfDocName.ALLATORIxDEMO("'\\7]+D\"E%N"), 45, 46);
        ItemLoaderType[] arritemLoaderType = new ItemLoaderType[46];
        arritemLoaderType[0] = INVENTORYITEMID;
        arritemLoaderType[1] = ITEMID;
        arritemLoaderType[2] = INVENTORYTYPE;
        arritemLoaderType[3] = POSITION;
        arritemLoaderType[4] = QUANTITY;
        arritemLoaderType[5] = OWNER;
        arritemLoaderType[6] = GM_LOG;
        arritemLoaderType[7] = UNIQUEID;
        arritemLoaderType[8] = CRAFTED;
        arritemLoaderType[9] = EXPIREDATE;
        arritemLoaderType[10] = FLAG;
        arritemLoaderType[11] = TYPE;
        arritemLoaderType[12] = SENDER;
        arritemLoaderType[13] = EQUIPONLYID;
        arritemLoaderType[14] = UPGRADESLOTS;
        arritemLoaderType[15] = LEVEL;
        arritemLoaderType[16] = STR;
        arritemLoaderType[17] = DEX;
        arritemLoaderType[18] = INT;
        arritemLoaderType[19] = LUK;
        arritemLoaderType[20] = HP;
        arritemLoaderType[21] = MP;
        arritemLoaderType[22] = WATK;
        arritemLoaderType[23] = MATK;
        arritemLoaderType[24] = WDEF;
        arritemLoaderType[25] = MDEF;
        arritemLoaderType[26] = ACC;
        arritemLoaderType[27] = AVOID;
        arritemLoaderType[28] = HANDS;
        arritemLoaderType[29] = SPEED;
        arritemLoaderType[30] = JUMP;
        arritemLoaderType[31] = VICIOUSHAMMER;
        arritemLoaderType[32] = ITEMEXP;
        arritemLoaderType[33] = DURABILITY;
        arritemLoaderType[34] = ENHANCE;
        arritemLoaderType[35] = POTENTIAL1;
        arritemLoaderType[36] = POTENTIAL2;
        arritemLoaderType[37] = POTENTIAL3;
        arritemLoaderType[38] = INCSKILL;
        arritemLoaderType[39] = HPR;
        arritemLoaderType[40] = MPR;
        arritemLoaderType[41] = CHARMEXP;
        arritemLoaderType[42] = PVPDAMAGE;
        arritemLoaderType[43] = POTENTIAL4;
        arritemLoaderType[44] = POTENTIAL5;
        arritemLoaderType[45] = CUSTOMFLAG;
        ALLATORIxDEMO = arritemLoaderType;
    }

    public final /* synthetic */ String getValueString() {
        ItemLoaderType a2;
        return Integer.toString(a2.d);
    }

    public static /* synthetic */ ItemLoaderType getByValue(int a2) {
        int n2;
        ItemLoaderType[] arritemLoaderType = ItemLoaderType.values();
        int n3 = arritemLoaderType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            ItemLoaderType itemLoaderType = arritemLoaderType[n2];
            if (itemLoaderType.getValue() == a2) {
                return itemLoaderType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ ItemLoaderType getByValueString(String a2) {
        int n2;
        int n3 = Integer.parseInt(a2);
        ItemLoaderType[] arritemLoaderType = ItemLoaderType.values();
        int n4 = arritemLoaderType.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            ItemLoaderType itemLoaderType = arritemLoaderType[n2];
            if (itemLoaderType.getValue() == n3) {
                return itemLoaderType;
            }
            n5 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ ItemLoaderType valueOf(String a2) {
        return Enum.valueOf(ItemLoaderType.class, a2);
    }

    public final /* synthetic */ int getValue() {
        ItemLoaderType a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ItemLoaderType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        ItemLoaderType a3;
        a3.d = a2;
    }
}

