/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 */
package client;

import client.messages.ConsoleCommandExecute;
import client.messages.commands.player.\u83c7\u83c7\u8c37;

public final class JobFlag
extends Enum<JobFlag> {
    public static final /* synthetic */ /* enum */ JobFlag \u6d77\u76dc;
    public static final /* synthetic */ /* enum */ JobFlag \u528d\u58eb;
    public static final /* synthetic */ /* enum */ JobFlag \u6cd5\u5e2b;
    private static final /* synthetic */ JobFlag[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ JobFlag \u76dc\u8cca;
    public static final /* synthetic */ /* enum */ JobFlag \u5f13\u7bad\u624b;
    public static final /* synthetic */ /* enum */ JobFlag \u901a\u7528;
    private final /* synthetic */ int d;

    public static /* synthetic */ JobFlag valueOf(String a2) {
        return Enum.valueOf(JobFlag.class, a2);
    }

    public final /* synthetic */ boolean check(int a2) {
        JobFlag a3;
        return (a2 & a3.d) == a3.d;
    }

    public static /* synthetic */ JobFlag[] values() {
        return (JobFlag[])ALLATORIxDEMO.clone();
    }

    public final /* synthetic */ int getValue() {
        JobFlag a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ JobFlag(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        JobFlag a3;
        a3.d = a2;
    }

    public static /* synthetic */ {
        \u901a\u7528 = new JobFlag(ConsoleCommandExecute.ALLATORIxDEMO("\u9057\u752f"), 0, 0);
        \u528d\u58eb = new JobFlag(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u52ec\u58f2"), 1, 1);
        \u6cd5\u5e2b = new JobFlag(ConsoleCommandExecute.ALLATORIxDEMO("\u6c98\u5e2c"), 2, 2);
        \u5f13\u7bad\u624b = new JobFlag(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5f0a\u7bcc\u6252"), 3, 4);
        \u76dc\u8cca = new JobFlag(ConsoleCommandExecute.ALLATORIxDEMO("\u7691\u8ccd"), 4, 8);
        \u6d77\u76dc = new JobFlag(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u6d16\u76c5"), 5, 16);
        JobFlag[] arrjobFlag = new JobFlag[6];
        arrjobFlag[0] = \u901a\u7528;
        arrjobFlag[1] = \u528d\u58eb;
        arrjobFlag[2] = \u6cd5\u5e2b;
        arrjobFlag[3] = \u5f13\u7bad\u624b;
        arrjobFlag[4] = \u76dc\u8cca;
        arrjobFlag[5] = \u6d77\u76dc;
        ALLATORIxDEMO = arrjobFlag;
    }
}

