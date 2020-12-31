/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleBuffStatValueHolder;
import handling.opcodes.MapleBuffStat;
import java.io.Serializable;

public class SpecialBuffInfo
implements Serializable {
    private /* synthetic */ int a;
    public /* synthetic */ MapleBuffStat d;
    public /* synthetic */ MapleBuffStatValueHolder ALLATORIxDEMO;

    public /* synthetic */ MapleBuffStat getBuffStat() {
        SpecialBuffInfo a2;
        return a2.d;
    }

    public /* synthetic */ int getSkillId() {
        SpecialBuffInfo a2;
        return a2.a;
    }

    public /* synthetic */ MapleBuffStatValueHolder getBuffStatValueHolder() {
        SpecialBuffInfo a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ SpecialBuffInfo(int a2, MapleBuffStat a3, MapleBuffStatValueHolder a4) {
        SpecialBuffInfo a5;
        SpecialBuffInfo specialBuffInfo = a5;
        SpecialBuffInfo specialBuffInfo2 = a5;
        SpecialBuffInfo specialBuffInfo3 = a5;
        specialBuffInfo3.a = 0;
        specialBuffInfo3.d = null;
        specialBuffInfo2.ALLATORIxDEMO = null;
        specialBuffInfo2.a = a2;
        specialBuffInfo.d = a3;
        specialBuffInfo.ALLATORIxDEMO = a4;
    }
}

