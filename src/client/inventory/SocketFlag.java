/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import tools.otp.HmacOneTimePasswordGenerator;
import tools.wztosql.DumpItemsAdditions;

public final class SocketFlag
extends Enum<SocketFlag> {
    public static final /* synthetic */ /* enum */ SocketFlag SOCKET_BOX_1;
    public static final /* synthetic */ /* enum */ SocketFlag USED_SOCKET_2;
    public static final /* synthetic */ /* enum */ SocketFlag DEFAULT;
    public static final /* synthetic */ /* enum */ SocketFlag USED_SOCKET_3;
    public static final /* synthetic */ /* enum */ SocketFlag USED_SOCKET_1;
    private static final /* synthetic */ SocketFlag[] ALLATORIxDEMO;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ SocketFlag SOCKET_BOX_2;
    public static final /* synthetic */ /* enum */ SocketFlag SOCKET_BOX_3;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SocketFlag(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        SocketFlag a3;
        a3.d = a2;
    }

    public final /* synthetic */ int getValue() {
        SocketFlag a2;
        return a2.d;
    }

    public static /* synthetic */ SocketFlag valueOf(String a2) {
        return Enum.valueOf(SocketFlag.class, a2);
    }

    public final /* synthetic */ boolean check(int a2) {
        SocketFlag a3;
        return (a2 & a3.d) == a3.d;
    }

    public static /* synthetic */ SocketFlag[] values() {
        return (SocketFlag[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        DEFAULT = new SocketFlag(DumpItemsAdditions.ALLATORIxDEMO("\rc\u000fg\u001cj\u001d"), 0, 1);
        SOCKET_BOX_1 = new SocketFlag(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u0004U\u0014Q\u0012N\bX\u0018B\b+"), 1, 2);
        SOCKET_BOX_2 = new SocketFlag(DumpItemsAdditions.ALLATORIxDEMO("u\u0006e\u0002c\u001dy\u000bi\u0011y{"), 2, 4);
        SOCKET_BOX_3 = new SocketFlag(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u0004U\u0014Q\u0012N\bX\u0018B\b)"), 3, 8);
        USED_SOCKET_1 = new SocketFlag(DumpItemsAdditions.ALLATORIxDEMO("\u001cu\fb\u0016u\u0006e\u0002c\u001dyx"), 4, 16);
        USED_SOCKET_2 = new SocketFlag(HmacOneTimePasswordGenerator.ALLATORIxDEMO("O\u0004_\u0013E\u0004U\u0014Q\u0012N\b("), 5, 32);
        USED_SOCKET_3 = new SocketFlag(DumpItemsAdditions.ALLATORIxDEMO("\u001cu\fb\u0016u\u0006e\u0002c\u001dyz"), 6, 64);
        SocketFlag[] arrsocketFlag = new SocketFlag[7];
        arrsocketFlag[0] = DEFAULT;
        arrsocketFlag[1] = SOCKET_BOX_1;
        arrsocketFlag[2] = SOCKET_BOX_2;
        arrsocketFlag[3] = SOCKET_BOX_3;
        arrsocketFlag[4] = USED_SOCKET_1;
        arrsocketFlag[5] = USED_SOCKET_2;
        arrsocketFlag[6] = USED_SOCKET_3;
        ALLATORIxDEMO = arrsocketFlag;
    }
}

