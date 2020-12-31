/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCoreAura;
import tools.EmojiFilter;

public final class FieldLimitType
extends Enum<FieldLimitType> {
    public static final /* synthetic */ /* enum */ FieldLimitType Minigames;
    public static final /* synthetic */ /* enum */ FieldLimitType ChannelSwitch;
    public static final /* synthetic */ /* enum */ FieldLimitType Event2;
    public static final /* synthetic */ /* enum */ FieldLimitType RegularExpLoss;
    public static final /* synthetic */ /* enum */ FieldLimitType NoClue1;
    public static final /* synthetic */ /* enum */ FieldLimitType Mount;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ FieldLimitType Event;
    public static final /* synthetic */ /* enum */ FieldLimitType Jump;
    public static final /* synthetic */ /* enum */ FieldLimitType Pet;
    public static final /* synthetic */ /* enum */ FieldLimitType VipRock;
    public static final /* synthetic */ /* enum */ FieldLimitType PotionUse;
    public static final /* synthetic */ /* enum */ FieldLimitType MysticDoor;
    public static final /* synthetic */ /* enum */ FieldLimitType DropDown;
    private static final /* synthetic */ FieldLimitType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ FieldLimitType MovementSkills;
    public static final /* synthetic */ /* enum */ FieldLimitType SummoningBag;

    public final /* synthetic */ boolean check(int a2) {
        FieldLimitType a3;
        return (a2 & a3.d) == a3.d;
    }

    public static /* synthetic */ FieldLimitType[] values() {
        return (FieldLimitType[])ALLATORIxDEMO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ FieldLimitType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        FieldLimitType a3;
        a3.d = a2;
    }

    public static /* synthetic */ {
        Jump = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("I9n<"), 0, 1);
        MovementSkills = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("=c\u0006i\u001di\u001ex#g\u0019`\u001c\u007f"), 1, 2);
        SummoningBag = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("P9n!l\"j\"d\u000eb+"), 2, 4);
        MysticDoor = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("=u\u0003x\u0019o4c\u001f~"), 3, 8);
        ChannelSwitch = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("\u000fk-m\"f P;j8`$"), 4, 16);
        RegularExpLoss = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("\"i\u0017y\u001cm\u0002I\b|<c\u0003\u007f"), 5, 32);
        VipRock = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("\u001aj<Q#`'"), 6, 64);
        Minigames = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("A\u0019b\u0019k\u0011a\u0015\u007f"), 7, 128);
        NoClue1 = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("\u0002l\u000fo9f}"), 8, 256);
        Mount = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("A\u001fy\u001ex"), 9, 512);
        PotionUse = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("\u001cl8j#m\u0019p)"), 10, 1024);
        Event = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("I\u0006i\u001ex"), 11, 8192);
        Pet = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("\u001cf8"), 12, 32768);
        Event2 = new FieldLimitType(MapleCoreAura.ALLATORIxDEMO("5z\u0015b\u0004>"), 13, 65536);
        DropDown = new FieldLimitType(EmojiFilter.ALLATORIxDEMO("G>l<G#t\""), 14, 131072);
        FieldLimitType[] arrfieldLimitType = new FieldLimitType[15];
        arrfieldLimitType[0] = Jump;
        arrfieldLimitType[1] = MovementSkills;
        arrfieldLimitType[2] = SummoningBag;
        arrfieldLimitType[3] = MysticDoor;
        arrfieldLimitType[4] = ChannelSwitch;
        arrfieldLimitType[5] = RegularExpLoss;
        arrfieldLimitType[6] = VipRock;
        arrfieldLimitType[7] = Minigames;
        arrfieldLimitType[8] = NoClue1;
        arrfieldLimitType[9] = Mount;
        arrfieldLimitType[10] = PotionUse;
        arrfieldLimitType[11] = Event;
        arrfieldLimitType[12] = Pet;
        arrfieldLimitType[13] = Event2;
        arrfieldLimitType[14] = DropDown;
        ALLATORIxDEMO = arrfieldLimitType;
    }

    public static /* synthetic */ FieldLimitType valueOf(String a2) {
        return Enum.valueOf(FieldLimitType.class, a2);
    }

    public final /* synthetic */ int getValue() {
        FieldLimitType a2;
        return a2.d;
    }
}

