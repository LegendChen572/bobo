/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 */
package server.maps;

import client.messages.commands.player.\u61a8\u61a8\u8c37;
import server.life.MobNameData;

public final class SummonMovementType
extends Enum<SummonMovementType> {
    public static final /* synthetic */ /* enum */ SummonMovementType FOLLOW;
    public static final /* synthetic */ /* enum */ SummonMovementType WALK_STATIONARY;
    public static final /* synthetic */ /* enum */ SummonMovementType STATIONARY;
    public static final /* synthetic */ /* enum */ SummonMovementType CIRCLE_STATIONARY;
    private final /* synthetic */ int d;
    private static final /* synthetic */ SummonMovementType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ SummonMovementType CIRCLE_FOLLOW;

    public /* synthetic */ int getValue() {
        SummonMovementType a2;
        return a2.d;
    }

    public static /* synthetic */ SummonMovementType[] values() {
        return (SummonMovementType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        STATIONARY = new SummonMovementType(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u001a=\b=\u0000&\u0007(\u001b0"), 0, 0);
        FOLLOW = new SummonMovementType(MobNameData.ALLATORIxDEMO("h}b~ae"), 1, 1);
        WALK_STATIONARY = new SummonMovementType(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)">\b%\u00026\u001a=\b=\u0000&\u0007(\u001b0"), 2, 2);
        CIRCLE_FOLLOW = new SummonMovementType(MobNameData.ALLATORIxDEMO("qg`m~kmh}b~ae"), 3, 3);
        CIRCLE_STATIONARY = new SummonMovementType(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"*\u0000;\n%\f6\u001a=\b=\u0000&\u0007(\u001b0"), 4, 4);
        SummonMovementType[] arrsummonMovementType = new SummonMovementType[5];
        arrsummonMovementType[0] = STATIONARY;
        arrsummonMovementType[1] = FOLLOW;
        arrsummonMovementType[2] = WALK_STATIONARY;
        arrsummonMovementType[3] = CIRCLE_FOLLOW;
        arrsummonMovementType[4] = CIRCLE_STATIONARY;
        ALLATORIxDEMO = arrsummonMovementType;
    }

    public static /* synthetic */ SummonMovementType valueOf(String a2) {
        return Enum.valueOf(SummonMovementType.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SummonMovementType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        SummonMovementType a3;
        a3.d = a2;
    }
}

