/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import client.messages.commands.player.eventSystem.MapOwner;
import handling.WritableIntValueHolder;
import handling.cashshop.handler.CashShopOperation;

public final class NpcShopType
extends Enum<NpcShopType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ NpcShopType RECHARGE;
    public static final /* synthetic */ /* enum */ NpcShopType SELL;
    public static final /* synthetic */ /* enum */ NpcShopType BUY;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ NpcShopType LEAVE;
    private static final /* synthetic */ NpcShopType[] ALLATORIxDEMO;

    public static /* synthetic */ NpcShopType valueOf(String a2) {
        return Enum.valueOf(NpcShopType.class, a2);
    }

    @Override
    public /* synthetic */ short getValue() {
        NpcShopType a2;
        return a2.d;
    }

    public static /* synthetic */ NpcShopType[] values() {
        return (NpcShopType[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ NpcShopType getNpcShopOperationType(int a2) {
        int n2;
        NpcShopType[] arrnpcShopType = NpcShopType.values();
        int n3 = arrnpcShopType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            NpcShopType npcShopType = arrnpcShopType[n2];
            if (npcShopType.getValue() == a2) {
                return npcShopType;
            }
            n4 = ++n2;
        }
        return null;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ NpcShopType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        NpcShopType a3;
        NpcShopType npcShopType = a3;
        a3.d = 0;
        npcShopType.d = 0;
        npcShopType.d = (short)a2;
    }

    public static /* synthetic */ {
        BUY = new NpcShopType(MapOwner.ALLATORIxDEMO("\nk\u0011"), 0, 0);
        SELL = new NpcShopType(CashShopOperation.ALLATORIxDEMO("e#z*"), 1, 1);
        RECHARGE = new NpcShopType(MapOwner.ALLATORIxDEMO("l\r}\u0000\u007f\u001ay\r"), 2, 2);
        LEAVE = new NpcShopType(CashShopOperation.ALLATORIxDEMO("*s'`#"), 3, 3);
        NpcShopType[] arrnpcShopType = new NpcShopType[4];
        arrnpcShopType[0] = BUY;
        arrnpcShopType[1] = SELL;
        arrnpcShopType[2] = RECHARGE;
        arrnpcShopType[3] = LEAVE;
        ALLATORIxDEMO = arrnpcShopType;
    }
}

