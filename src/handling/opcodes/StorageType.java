/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import client.messages.commands.player.eventSystem.MonsterPetSystem;
import handling.WritableIntValueHolder;
import tools.Quadra;

public final class StorageType
extends Enum<StorageType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ StorageType TAKE_OUT;
    public static final /* synthetic */ /* enum */ StorageType STORE;
    public static final /* synthetic */ /* enum */ StorageType ARRANGE;
    public static final /* synthetic */ /* enum */ StorageType TAKE_MESO;
    public static final /* synthetic */ /* enum */ StorageType LEAVE;
    private static final /* synthetic */ StorageType[] ALLATORIxDEMO;
    public /* synthetic */ short value;

    @Override
    public /* synthetic */ short getValue() {
        StorageType a2;
        return a2.value;
    }

    public static /* synthetic */ {
        TAKE_OUT = new StorageType(MonsterPetSystem.ALLATORIxDEMO("\f\u0012\u0013\u0016\u0007\u001c\r\u0007"), 0, 4);
        STORE = new StorageType(Quadra.ALLATORIxDEMO("\u001ab\u0006d\f"), 1, 5);
        ARRANGE = new StorageType(MonsterPetSystem.ALLATORIxDEMO("\u0012\n\u0001\u0019\u001d\u001f\u0016"), 2, 6);
        TAKE_MESO = new StorageType(Quadra.ALLATORIxDEMO("\u001dw\u0002s\u0016{\fe\u0006"), 3, 7);
        LEAVE = new StorageType(MonsterPetSystem.ALLATORIxDEMO("\u001f\u001d\u0012\u000e\u0016"), 4, 8);
        StorageType[] arrstorageType = new StorageType[5];
        arrstorageType[0] = TAKE_OUT;
        arrstorageType[1] = STORE;
        arrstorageType[2] = ARRANGE;
        arrstorageType[3] = TAKE_MESO;
        arrstorageType[4] = LEAVE;
        ALLATORIxDEMO = arrstorageType;
    }

    public static /* synthetic */ StorageType[] values() {
        return (StorageType[])ALLATORIxDEMO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ StorageType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        StorageType a3;
        StorageType storageType = a3;
        storageType.value = 0;
        storageType.value = (short)a2;
    }

    public static /* synthetic */ StorageType valueOf(String a2) {
        return Enum.valueOf(StorageType.class, a2);
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.value = a2;
    }
}

