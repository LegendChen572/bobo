/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import handling.world.CheaterData;
import server.StructSetItem;

public final class PartyOperation
extends Enum<PartyOperation> {
    public static final /* synthetic */ /* enum */ PartyOperation LOG_ONOFF;
    public static final /* synthetic */ /* enum */ PartyOperation DISBAND;
    public static final /* synthetic */ /* enum */ PartyOperation SILENT_UPDATE;
    public static final /* synthetic */ /* enum */ PartyOperation CHANGE_LEADER;
    private static final /* synthetic */ PartyOperation[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ PartyOperation JOIN;
    public static final /* synthetic */ /* enum */ PartyOperation EXPEL;
    public static final /* synthetic */ /* enum */ PartyOperation CHANGE_LEADER_DC;
    public static final /* synthetic */ /* enum */ PartyOperation LEAVE;

    public static /* synthetic */ PartyOperation valueOf(String a2) {
        return Enum.valueOf(PartyOperation.class, a2);
    }

    public static /* synthetic */ {
        JOIN = new PartyOperation(StructSetItem.ALLATORIxDEMO(".i-h"), 0);
        LEAVE = new PartyOperation(CheaterData.ALLATORIxDEMO("Y@TSP"), 1);
        EXPEL = new PartyOperation(StructSetItem.ALLATORIxDEMO("c<v!j"), 2);
        DISBAND = new PartyOperation(CheaterData.ALLATORIxDEMO("QLFGTKQ"), 3);
        SILENT_UPDATE = new PartyOperation(StructSetItem.ALLATORIxDEMO("u-j!h0y1v g0c"), 4);
        LOG_ONOFF = new PartyOperation(CheaterData.ALLATORIxDEMO("YJRZZKZCS"), 5);
        CHANGE_LEADER = new PartyOperation(StructSetItem.ALLATORIxDEMO("e,g*a!y(c%b!t"), 6);
        CHANGE_LEADER_DC = new PartyOperation(CheaterData.ALLATORIxDEMO("F]D[BPZY@TAPWJAV"), 7);
        PartyOperation[] arrpartyOperation = new PartyOperation[8];
        arrpartyOperation[0] = JOIN;
        arrpartyOperation[1] = LEAVE;
        arrpartyOperation[2] = EXPEL;
        arrpartyOperation[3] = DISBAND;
        arrpartyOperation[4] = SILENT_UPDATE;
        arrpartyOperation[5] = LOG_ONOFF;
        arrpartyOperation[6] = CHANGE_LEADER;
        arrpartyOperation[7] = CHANGE_LEADER_DC;
        ALLATORIxDEMO = arrpartyOperation;
    }

    public static /* synthetic */ PartyOperation[] values() {
        return (PartyOperation[])ALLATORIxDEMO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ PartyOperation() {
        void var2_-1;
        void var1_-1;
        PartyOperation a2;
    }
}

