/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import server.MapleCarnivalChallenge;
import server.MapleDueyActions;

public final class AttackType
extends Enum<AttackType> {
    public static final /* synthetic */ /* enum */ AttackType NON_RANGED;
    public static final /* synthetic */ /* enum */ AttackType RANGED;
    private static final /* synthetic */ AttackType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ AttackType NON_RANGED_WITH_MIRROR;
    public static final /* synthetic */ /* enum */ AttackType RANGED_WITH_SHADOWPARTNER;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ AttackType() {
        void var2_-1;
        void var1_-1;
        AttackType a2;
    }

    public static /* synthetic */ AttackType valueOf(String a2) {
        return Enum.valueOf(AttackType.class, a2);
    }

    public static /* synthetic */ AttackType[] values() {
        return (AttackType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        NON_RANGED = new AttackType(MapleCarnivalChallenge.ALLATORIxDEMO("R>R.N0R6Y5"), 0);
        RANGED = new AttackType(MapleDueyActions.ALLATORIxDEMO("d\u0016x\u0010s\u0013"), 1);
        RANGED_WITH_SHADOWPARTNER = new AttackType(MapleCarnivalChallenge.ALLATORIxDEMO("#]?[4X.K8H9C\"T0X>K!]#H?Y#"), 2);
        NON_RANGED_WITH_MIRROR = new AttackType(MapleDueyActions.ALLATORIxDEMO("x\u0018x\bd\u0016x\u0010s\u0013i\u0000\u007f\u0003~\b{\u001ed\u0005y\u0005"), 3);
        AttackType[] arrattackType = new AttackType[4];
        arrattackType[0] = NON_RANGED;
        arrattackType[1] = RANGED;
        arrattackType[2] = RANGED_WITH_SHADOWPARTNER;
        arrattackType[3] = NON_RANGED_WITH_MIRROR;
        ALLATORIxDEMO = arrattackType;
    }
}

