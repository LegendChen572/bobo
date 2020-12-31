/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 */
package scripting;

import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import tools.EmojiFilter;

public final class ScriptType
extends Enum<ScriptType> {
    public static final /* synthetic */ /* enum */ ScriptType ON_USER_ENTER;
    public static final /* synthetic */ /* enum */ ScriptType NPC;
    public static final /* synthetic */ /* enum */ ScriptType QUEST_START;
    public static final /* synthetic */ /* enum */ ScriptType QUEST_END;
    private /* synthetic */ byte d;
    public static final /* synthetic */ /* enum */ ScriptType PORTAL;
    public static final /* synthetic */ /* enum */ ScriptType EVENT;
    public static final /* synthetic */ /* enum */ ScriptType ITEM;
    public static final /* synthetic */ /* enum */ ScriptType REACTOR;
    private static final /* synthetic */ ScriptType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ ScriptType ON_FIRST_USER_ENTER;

    public static /* synthetic */ ScriptType[] values() {
        return (ScriptType[])ALLATORIxDEMO.clone();
    }

    public /* synthetic */ byte getValue() {
        ScriptType a2;
        return a2.d;
    }

    public static /* synthetic */ {
        NPC = new ScriptType(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"O-B"), 0, -1);
        QUEST_START = new ScriptType(EmojiFilter.ALLATORIxDEMO("\u001dV\tP\u0018\\\u001fW\rQ\u0018"), 1, 0);
        QUEST_END = new ScriptType(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"P(D.U\"D3E"), 2, 1);
        ITEM = new ScriptType(EmojiFilter.ALLATORIxDEMO("J\u0018F\u0001"), 3, -1);
        ON_FIRST_USER_ENTER = new ScriptType(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"N3^;H/R)^(R8S\"D3U8S"), 4, -1);
        ON_USER_ENTER = new ScriptType(EmojiFilter.ALLATORIxDEMO("\u0003M\u0013V\u001fF\u001e\\\tM\u0018F\u001e"), 5, -1);
        PORTAL = new ScriptType(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"-N/U<M"), 6, -2);
        REACTOR = new ScriptType(EmojiFilter.ALLATORIxDEMO("\u001eF\r@\u0018L\u001e"), 7, -2);
        EVENT = new ScriptType(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"D+D3U"), 8, -2);
        ScriptType[] arrscriptType = new ScriptType[9];
        arrscriptType[0] = NPC;
        arrscriptType[1] = QUEST_START;
        arrscriptType[2] = QUEST_END;
        arrscriptType[3] = ITEM;
        arrscriptType[4] = ON_FIRST_USER_ENTER;
        arrscriptType[5] = ON_USER_ENTER;
        arrscriptType[6] = PORTAL;
        arrscriptType[7] = REACTOR;
        arrscriptType[8] = EVENT;
        ALLATORIxDEMO = arrscriptType;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ScriptType() {
        void var2_-1;
        void var1_-1;
        ScriptType a2;
        a2.d = (byte)-2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ScriptType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        ScriptType a3;
        ScriptType scriptType = a3;
        scriptType.d = (byte)-2;
        scriptType.d = (byte)a2;
    }

    public static /* synthetic */ ScriptType valueOf(String a2) {
        return Enum.valueOf(ScriptType.class, a2);
    }
}

