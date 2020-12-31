/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.channel.handler.BBSHandler;
import tools.packet.FamilyPacket;

public final class PartyOperation
extends Enum<PartyOperation> {
    public static final /* synthetic */ /* enum */ PartyOperation SILENT_UPDATE;
    public static final /* synthetic */ /* enum */ PartyOperation LEAVE;
    public static final /* synthetic */ /* enum */ PartyOperation DISBAND;
    public static final /* synthetic */ /* enum */ PartyOperation CHANGE_LEADER_DC;
    private static final /* synthetic */ PartyOperation[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ PartyOperation EXPEL;
    public static final /* synthetic */ /* enum */ PartyOperation CHANGE_LEADER;
    public static final /* synthetic */ /* enum */ PartyOperation JOIN;
    public static final /* synthetic */ /* enum */ PartyOperation LOG_ONOFF;

    public static /* synthetic */ PartyOperation valueOf(String a2) {
        return Enum.valueOf(PartyOperation.class, a2);
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

    public static /* synthetic */ {
        JOIN = new PartyOperation(FamilyPacket.ALLATORIxDEMO("\u0018m\u001bl"), 0);
        LEAVE = new PartyOperation(BBSHandler.ALLATORIxDEMO("ofbuf"), 1);
        EXPEL = new PartyOperation(FamilyPacket.ALLATORIxDEMO("g\nr\u0017n"), 2);
        DISBAND = new PartyOperation(BBSHandler.ALLATORIxDEMO("gjpabmg"), 3);
        SILENT_UPDATE = new PartyOperation(FamilyPacket.ALLATORIxDEMO("q\u001bn\u0017l\u0006}\u0007r\u0016c\u0006g"), 4);
        LOG_ONOFF = new PartyOperation(BBSHandler.ALLATORIxDEMO("old|lmlee"), 5);
        CHANGE_LEADER = new PartyOperation(FamilyPacket.ALLATORIxDEMO("a\u001ac\u001ce\u0017}\u001eg\u0013f\u0017p"), 6);
        CHANGE_LEADER_DC = new PartyOperation(BBSHandler.ALLATORIxDEMO("`kbmdf|ofbgfq|g`"), 7);
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
}

