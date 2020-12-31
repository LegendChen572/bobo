/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package handling.opcodes;

import client.messages.commands.player.\u738b\u4e4b\u8c37;
import handling.WritableIntValueHolder;
import tools.ConcurrentEnumMap;

public final class BuddyType
extends Enum<BuddyType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ BuddyType CREATE;
    public static final /* synthetic */ /* enum */ BuddyType ACCEPT;
    public static final /* synthetic */ /* enum */ BuddyType INVITE;
    public static final /* synthetic */ /* enum */ BuddyType UNKNOWN1;
    public static final /* synthetic */ /* enum */ BuddyType LEAVE;
    public static final /* synthetic */ /* enum */ BuddyType UNKNOWN3;
    private static final /* synthetic */ BuddyType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ BuddyType UNKNOWN2;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ BuddyType EXPEL;
    public static final /* synthetic */ /* enum */ BuddyType CHANGE_LEADER;

    public static /* synthetic */ {
        UNKNOWN1 = new BuddyType(ConcurrentEnumMap.ALLATORIxDEMO("\f \u0012 \u00169\u0017_"), 0, 0);
        CREATE = new BuddyType(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"dLb_s["), 1, 1);
        LEAVE = new BuddyType(ConcurrentEnumMap.ALLATORIxDEMO("\"\u001c/\u000f+"), 2, 2);
        ACCEPT = new BuddyType(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"f]d[wJ"), 3, 3);
        INVITE = new BuddyType(ConcurrentEnumMap.ALLATORIxDEMO("\u0010 \u000f'\r+"), 4, 4);
        EXPEL = new BuddyType(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"[\u007fNbR"), 5, 5);
        CHANGE_LEADER = new BuddyType(ConcurrentEnumMap.ALLATORIxDEMO("-\u0011/\u0017)\u001c1\u0015+\u0018*\u001c<"), 6, 6);
        UNKNOWN2 = new BuddyType(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"rPlPhIi,"), 7, 82);
        UNKNOWN3 = new BuddyType(ConcurrentEnumMap.ALLATORIxDEMO("\f \u0012 \u00169\u0017]"), 8, 125);
        BuddyType[] arrbuddyType = new BuddyType[9];
        arrbuddyType[0] = UNKNOWN1;
        arrbuddyType[1] = CREATE;
        arrbuddyType[2] = LEAVE;
        arrbuddyType[3] = ACCEPT;
        arrbuddyType[4] = INVITE;
        arrbuddyType[5] = EXPEL;
        arrbuddyType[6] = CHANGE_LEADER;
        arrbuddyType[7] = UNKNOWN2;
        arrbuddyType[8] = UNKNOWN3;
        ALLATORIxDEMO = arrbuddyType;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ BuddyType valueOf(String a2) {
        return Enum.valueOf(BuddyType.class, a2);
    }

    public static /* synthetic */ BuddyType getBuddyOperationType(int a2) {
        int n2;
        BuddyType[] arrbuddyType = BuddyType.values();
        int n3 = arrbuddyType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            BuddyType buddyType = arrbuddyType[n2];
            if (buddyType.getValue() == a2) {
                return buddyType;
            }
            n4 = ++n2;
        }
        return null;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ BuddyType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        BuddyType a3;
        BuddyType buddyType = a3;
        a3.d = 0;
        buddyType.d = 0;
        buddyType.d = (short)a2;
    }

    @Override
    public /* synthetic */ short getValue() {
        BuddyType a2;
        return a2.d;
    }

    public static /* synthetic */ BuddyType[] values() {
        return (BuddyType[])ALLATORIxDEMO.clone();
    }
}

