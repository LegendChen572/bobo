/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import client.inventory.InventoryException;
import constants.GameSetConstants;
import handling.ExternalCodeTableGetter;
import handling.WritableIntValueHolder;
import java.util.Properties;
import tools.wztosql.DumpMobName;

public final class SummonMovementType
extends Enum<SummonMovementType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ SummonMovementType STATIONARY;
    public static final /* synthetic */ /* enum */ SummonMovementType WALK_STATIONARY;
    private static final /* synthetic */ SummonMovementType[] ALLATORIxDEMO;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ SummonMovementType CIRCLE_STATIONARY;
    public static final /* synthetic */ /* enum */ SummonMovementType CIRCLE_FOLLOW;
    public static final /* synthetic */ /* enum */ SummonMovementType FOLLOW;

    public static /* synthetic */ SummonMovementType[] values() {
        return (SummonMovementType[])ALLATORIxDEMO.clone();
    }

    public static final /* synthetic */ void reloadValues() {
        Properties properties;
        Properties properties2 = new Properties();
        properties2.setProperty(DumpMobName.ALLATORIxDEMO("\u0003A\u0011A\u0019Z\u001eT\u0002L"), InventoryException.ALLATORIxDEMO("Q"));
        properties2.setProperty(DumpMobName.ALLATORIxDEMO("\u0016Z\u001cY\u001fB"), "1");
        properties2.setProperty(InventoryException.ALLATORIxDEMO("6;-1>)5;53.4 (8"), "2");
        if (GameSetConstants.MAPLE_VERSION < 118) {
            Properties properties3 = properties2;
            properties2.setProperty(DumpMobName.ALLATORIxDEMO("V\u0019G\u0013Y\u0015J\u0016Z\u001cY\u001fB"), "3");
            properties = properties3;
            properties3.setProperty(InventoryException.ALLATORIxDEMO("\"339-?>)5;53.4 (8"), "4");
        } else {
            Properties properties4 = properties2;
            properties = properties4;
            properties4.setProperty(DumpMobName.ALLATORIxDEMO("V\u0019G\u0013Y\u0015J\u0016Z\u001cY\u001fB"), "4");
            properties2.setProperty(InventoryException.ALLATORIxDEMO("\"339-?>)5;53.4 (8"), DumpMobName.ALLATORIxDEMO(" "));
        }
        ExternalCodeTableGetter.populateValues((Properties)properties, (Enum[])SummonMovementType.values());
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ short getValue() {
        SummonMovementType a2;
        return a2.d;
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
        SummonMovementType summonMovementType = a3;
        a3.d = 0;
        summonMovementType.d = 0;
        summonMovementType.d = (short)a2;
    }

    public static /* synthetic */ SummonMovementType valueOf(String a2) {
        return Enum.valueOf(SummonMovementType.class, a2);
    }

    public static /* synthetic */ {
        STATIONARY = new SummonMovementType(InventoryException.ALLATORIxDEMO(")5;53.4 (8"), 0, 0);
        FOLLOW = new SummonMovementType(DumpMobName.ALLATORIxDEMO("\u0016Z\u001cY\u001fB"), 1, 1);
        WALK_STATIONARY = new SummonMovementType(InventoryException.ALLATORIxDEMO("6;-1>)5;53.4 (8"), 2, 2);
        CIRCLE_FOLLOW = new SummonMovementType(DumpMobName.ALLATORIxDEMO("V\u0019G\u0013Y\u0015J\u0016Z\u001cY\u001fB"), 3, 3);
        CIRCLE_STATIONARY = new SummonMovementType(InventoryException.ALLATORIxDEMO("\"339-?>)5;53.4 (8"), 4, 4);
        SummonMovementType[] arrsummonMovementType = new SummonMovementType[5];
        arrsummonMovementType[0] = STATIONARY;
        arrsummonMovementType[1] = FOLLOW;
        arrsummonMovementType[2] = WALK_STATIONARY;
        arrsummonMovementType[3] = CIRCLE_FOLLOW;
        arrsummonMovementType[4] = CIRCLE_STATIONARY;
        ALLATORIxDEMO = arrsummonMovementType;
        SummonMovementType.reloadValues();
    }
}

