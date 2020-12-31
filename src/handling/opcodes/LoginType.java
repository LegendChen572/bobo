/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import handling.world.exped.MapleExpedition;
import server.life.MonsterQuestDropEntry;

public final class LoginType
extends Enum<LoginType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ LoginType BLOCKED_LOGGEDIN;
    public static final /* synthetic */ /* enum */ LoginType LOGIN_SUCCESS;
    private static final /* synthetic */ LoginType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ LoginType NOT_REGISTERED;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ LoginType SYSTEM_ERROR2;
    public static final /* synthetic */ /* enum */ LoginType SYSTEM_ERROR;
    public static final /* synthetic */ /* enum */ LoginType SYSTEM_OVERLOADED;
    public static final /* synthetic */ /* enum */ LoginType IP_NOT_ALLOWED;
    public static final /* synthetic */ /* enum */ LoginType ALREADY_LOGGED_IN;
    public static final /* synthetic */ /* enum */ LoginType NOP;
    public static final /* synthetic */ /* enum */ LoginType ACCOUNT_BLOCKED;
    public static final /* synthetic */ /* enum */ LoginType WRONG_PASSWORD;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ LoginType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        LoginType a3;
        LoginType loginType = a3;
        a3.d = 0;
        loginType.d = 0;
        loginType.d = (short)a2;
    }

    public static /* synthetic */ LoginType valueOf(String a2) {
        return Enum.valueOf(LoginType.class, a2);
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ LoginType[] values() {
        return (LoginType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        LOGIN_SUCCESS = new LoginType(MapleExpedition.ALLATORIxDEMO("JjAlHzUpEfCvU"), 0, 0);
        NOP = new LoginType(MonsterQuestDropEntry.ALLATORIxDEMO("\u001aa\u0004"), 1, 1);
        ACCOUNT_BLOCKED = new LoginType(MapleExpedition.ALLATORIxDEMO("GfEjSkRzDiIfM`B"), 2, 3);
        WRONG_PASSWORD = new LoginType(MonsterQuestDropEntry.ALLATORIxDEMO("y\u0006a\u001ai\u000b~\u0015}\u0007y\u001b|\u0010"), 3, 4);
        NOT_REGISTERED = new LoginType(MapleExpedition.ALLATORIxDEMO("kIqYwCbOvR`T`B"), 4, 5);
        ALREADY_LOGGED_IN = new LoginType(MonsterQuestDropEntry.ALLATORIxDEMO("\u0015b\u0006k\u0015j\rq\u0018a\u0013i\u0011j\u000bg\u001a"), 5, 7);
        SYSTEM_ERROR = new LoginType(MapleExpedition.ALLATORIxDEMO("v_vR`KzCwTjT"), 6, 8);
        SYSTEM_ERROR2 = new LoginType(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007w\u0007z\u0011c\u000bk\u0006|\u001b|f"), 7, 9);
        SYSTEM_OVERLOADED = new LoginType(MapleExpedition.ALLATORIxDEMO("U|UqChYjP`TiIdB`B"), 8, 10);
        IP_NOT_ALLOWED = new LoginType(MonsterQuestDropEntry.ALLATORIxDEMO("g\u0004q\u001aa\u0000q\u0015b\u0018a\u0003k\u0010"), 9, 34);
        BLOCKED_LOGGEDIN = new LoginType(MapleExpedition.ALLATORIxDEMO("gJjEnCaYiIbA`BlH"), 10, 99);
        LoginType[] arrloginType = new LoginType[11];
        arrloginType[0] = LOGIN_SUCCESS;
        arrloginType[1] = NOP;
        arrloginType[2] = ACCOUNT_BLOCKED;
        arrloginType[3] = WRONG_PASSWORD;
        arrloginType[4] = NOT_REGISTERED;
        arrloginType[5] = ALREADY_LOGGED_IN;
        arrloginType[6] = SYSTEM_ERROR;
        arrloginType[7] = SYSTEM_ERROR2;
        arrloginType[8] = SYSTEM_OVERLOADED;
        arrloginType[9] = IP_NOT_ALLOWED;
        arrloginType[10] = BLOCKED_LOGGEDIN;
        ALLATORIxDEMO = arrloginType;
    }

    @Override
    public /* synthetic */ short getValue() {
        LoginType a2;
        return a2.d;
    }

    public static /* synthetic */ LoginType getLoginOperationType(int a2) {
        int n2;
        LoginType[] arrloginType = LoginType.values();
        int n3 = arrloginType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            LoginType loginType = arrloginType[n2];
            if (loginType.getValue() == a2) {
                return loginType;
            }
            n4 = ++n2;
        }
        return null;
    }
}

