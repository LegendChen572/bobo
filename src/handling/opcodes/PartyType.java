/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import client.messages.CommandProcessorUtil;
import handling.WritableIntValueHolder;
import server.MapleShopItem;

public final class PartyType
extends Enum<PartyType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ PartyType LEAVE;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ PartyType INVITE;
    public static final /* synthetic */ /* enum */ PartyType ACCEPT;
    private static final /* synthetic */ PartyType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ PartyType CHANGE_LEADER;
    public static final /* synthetic */ /* enum */ PartyType CREATE;
    public static final /* synthetic */ /* enum */ PartyType EXPEL;

    public static /* synthetic */ {
        CREATE = new PartyType(CommandProcessorUtil.ALLATORIxDEMO("%j#y2}"), 0, 1);
        LEAVE = new PartyType(MapleShopItem.ALLATORIxDEMO("0b=q9"), 1, 2);
        ACCEPT = new PartyType(CommandProcessorUtil.ALLATORIxDEMO("'{%}6l"), 2, 3);
        INVITE = new PartyType(MapleShopItem.ALLATORIxDEMO("n2q5s9"), 3, 4);
        EXPEL = new PartyType(CommandProcessorUtil.ALLATORIxDEMO("}>h#t"), 4, 5);
        CHANGE_LEADER = new PartyType(MapleShopItem.ALLATORIxDEMO("?o=i;b#k9f8b."), 5, 6);
        PartyType[] arrpartyType = new PartyType[6];
        arrpartyType[0] = CREATE;
        arrpartyType[1] = LEAVE;
        arrpartyType[2] = ACCEPT;
        arrpartyType[3] = INVITE;
        arrpartyType[4] = EXPEL;
        arrpartyType[5] = CHANGE_LEADER;
        ALLATORIxDEMO = arrpartyType;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ PartyType[] values() {
        return (PartyType[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ short getValue() {
        PartyType a2;
        return a2.d;
    }

    public static /* synthetic */ PartyType valueOf(String a2) {
        return Enum.valueOf(PartyType.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ PartyType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        PartyType a3;
        PartyType partyType = a3;
        a3.d = 0;
        partyType.d = 0;
        partyType.d = (short)a2;
    }

    public static /* synthetic */ PartyType getPartyOperationType(int a2) {
        int n2;
        PartyType[] arrpartyType = PartyType.values();
        int n3 = arrpartyType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            PartyType partyType = arrpartyType[n2];
            if (partyType.getValue() == a2) {
                return partyType;
            }
            n4 = ++n2;
        }
        return null;
    }
}

