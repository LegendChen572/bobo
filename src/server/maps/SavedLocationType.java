/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import handling.auction.handler.MTSOperation;
import server.buffs.AbstractBuffClass;

public final class SavedLocationType
extends Enum<SavedLocationType> {
    public static final /* synthetic */ /* enum */ SavedLocationType BIRTHDAY;
    public static final /* synthetic */ /* enum */ SavedLocationType ARDENTMILL;
    public static final /* synthetic */ /* enum */ SavedLocationType ENGLISH;
    public static final /* synthetic */ /* enum */ SavedLocationType GM_COMMAND;
    public static final /* synthetic */ /* enum */ SavedLocationType GUILD;
    public static final /* synthetic */ /* enum */ SavedLocationType RICHIE;
    public static final /* synthetic */ /* enum */ SavedLocationType ARIANT_PQ;
    public static final /* synthetic */ /* enum */ SavedLocationType FREE_MARKET;
    public static final /* synthetic */ /* enum */ SavedLocationType GACHAPON;
    public static final /* synthetic */ /* enum */ SavedLocationType PVP;
    private static final /* synthetic */ SavedLocationType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ SavedLocationType MULUNG_TC;
    public static final /* synthetic */ /* enum */ SavedLocationType AMORIA;
    public static final /* synthetic */ /* enum */ SavedLocationType PACHINKO;
    public static final /* synthetic */ /* enum */ SavedLocationType TURNEGG;
    private /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ SavedLocationType FLORINA;
    public static final /* synthetic */ /* enum */ SavedLocationType BPRETURN;
    public static final /* synthetic */ /* enum */ SavedLocationType DONGDONGCHIANG;
    public static final /* synthetic */ /* enum */ SavedLocationType WORLDTOUR;
    public static final /* synthetic */ /* enum */ SavedLocationType MONSTER_CARNIVAL;
    public static final /* synthetic */ /* enum */ SavedLocationType PACH;
    public static final /* synthetic */ /* enum */ SavedLocationType SLEEP;
    public static final /* synthetic */ /* enum */ SavedLocationType HOTEL;
    public static final /* synthetic */ /* enum */ SavedLocationType FISHING;
    public static final /* synthetic */ /* enum */ SavedLocationType PROTECT_SNOWMAN;
    public static final /* synthetic */ /* enum */ SavedLocationType EVENT;
    public static final /* synthetic */ /* enum */ SavedLocationType PINK_ZAKUM;
    public static final /* synthetic */ /* enum */ SavedLocationType CHRISTMAS;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SavedLocationType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        SavedLocationType a3;
        a3.d = a2;
    }

    public static /* synthetic */ {
        FREE_MARKET = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("XG[PAX_GUPJ"), 0, 0);
        MULUNG_TC = new SavedLocationType(MTSOperation.ALLATORIxDEMO("n\u0019o\u0019m\u000b|\u0018`"), 1, 1);
        WORLDTOUR = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("IZLYZAQ@L"), 2, 2);
        FLORINA = new SavedLocationType(MTSOperation.ALLATORIxDEMO("e\u0000l\u001ej\u0002b"), 3, 3);
        FISHING = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("X\\M]W[Y"), 4, 4);
        RICHIE = new SavedLocationType(MTSOperation.ALLATORIxDEMO("\u001ej\u000fk\u0005f"), 5, 5);
        DONGDONGCHIANG = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("QQ[YQQ[YVV\\_[Y"), 6, 6);
        EVENT = new SavedLocationType(MTSOperation.ALLATORIxDEMO("f\u001af\u0002w"), 7, 7);
        AMORIA = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("TSZL\\_"), 8, 8);
        CHRISTMAS = new SavedLocationType(MTSOperation.ALLATORIxDEMO("`\u0004q\u0005p\u0018n\rp"), 9, 9);
        MONSTER_CARNIVAL = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("XQ[MA[GAV_GP\\HTR"), 10, 10);
        PVP = new SavedLocationType(MTSOperation.ALLATORIxDEMO("s\u001as"), 11, 11);
        HOTEL = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("VZJPR"), 12, 12);
        PACH = new SavedLocationType(MTSOperation.ALLATORIxDEMO("\u001cb\u000fk"), 13, 13);
        ENGLISH = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("[[YYWFV"), 14, 14);
        SLEEP = new SavedLocationType(MTSOperation.ALLATORIxDEMO("p\u0000f\ts"), 15, 15);
        BIRTHDAY = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("WWGJ]ZTG"), 16, 16);
        PACHINKO = new SavedLocationType(MTSOperation.ALLATORIxDEMO("\u001cb\u000fk\u0005m\u0007l"), 17, 17);
        PROTECT_SNOWMAN = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("NGQA[VJJM[QBSTP"), 18, 18);
        GM_COMMAND = new SavedLocationType(MTSOperation.ALLATORIxDEMO("\u000bn\u0013`\u0003n\u0001b\u0002g"), 19, 19);
        PINK_ZAKUM = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("EW[UJDTU@S"), 20, 20);
        ARIANT_PQ = new SavedLocationType(MTSOperation.ALLATORIxDEMO("b\u001ej\rm\u0018|\u001cr"), 21, 21);
        TURNEGG = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("J@L[[RY"), 22, 22);
        ARDENTMILL = new SavedLocationType(MTSOperation.ALLATORIxDEMO("\rq\bf\u0002w\u0001j\u0000o"), 23, 23);
        GUILD = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("Y@WYZ"), 24, 24);
        GACHAPON = new SavedLocationType(MTSOperation.ALLATORIxDEMO("\u000bb\u000fk\rs\u0003m"), 25, 25);
        BPRETURN = new SavedLocationType(AbstractBuffClass.ALLATORIxDEMO("WNG[AKGP"), 26, 26);
        SavedLocationType[] arrsavedLocationType = new SavedLocationType[27];
        arrsavedLocationType[0] = FREE_MARKET;
        arrsavedLocationType[1] = MULUNG_TC;
        arrsavedLocationType[2] = WORLDTOUR;
        arrsavedLocationType[3] = FLORINA;
        arrsavedLocationType[4] = FISHING;
        arrsavedLocationType[5] = RICHIE;
        arrsavedLocationType[6] = DONGDONGCHIANG;
        arrsavedLocationType[7] = EVENT;
        arrsavedLocationType[8] = AMORIA;
        arrsavedLocationType[9] = CHRISTMAS;
        arrsavedLocationType[10] = MONSTER_CARNIVAL;
        arrsavedLocationType[11] = PVP;
        arrsavedLocationType[12] = HOTEL;
        arrsavedLocationType[13] = PACH;
        arrsavedLocationType[14] = ENGLISH;
        arrsavedLocationType[15] = SLEEP;
        arrsavedLocationType[16] = BIRTHDAY;
        arrsavedLocationType[17] = PACHINKO;
        arrsavedLocationType[18] = PROTECT_SNOWMAN;
        arrsavedLocationType[19] = GM_COMMAND;
        arrsavedLocationType[20] = PINK_ZAKUM;
        arrsavedLocationType[21] = ARIANT_PQ;
        arrsavedLocationType[22] = TURNEGG;
        arrsavedLocationType[23] = ARDENTMILL;
        arrsavedLocationType[24] = GUILD;
        arrsavedLocationType[25] = GACHAPON;
        arrsavedLocationType[26] = BPRETURN;
        ALLATORIxDEMO = arrsavedLocationType;
    }

    public static /* synthetic */ SavedLocationType fromString(String a2) {
        return SavedLocationType.valueOf(a2);
    }

    public /* synthetic */ int getValue() {
        SavedLocationType a2;
        return a2.d;
    }

    public static /* synthetic */ SavedLocationType valueOf(String a2) {
        return Enum.valueOf(SavedLocationType.class, a2);
    }

    public static /* synthetic */ SavedLocationType[] values() {
        return (SavedLocationType[])ALLATORIxDEMO.clone();
    }
}

