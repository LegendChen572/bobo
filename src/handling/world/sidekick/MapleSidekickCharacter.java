/*
 * Decompiled with CFR 0.150.
 */
package handling.world.sidekick;

import client.MapleCharacter;
import java.io.Serializable;

public class MapleSidekickCharacter
implements Serializable {
    private /* synthetic */ int d;
    private /* synthetic */ String k;
    private /* synthetic */ int K;
    private /* synthetic */ int ALLATORIxDEMO;
    private static final /* synthetic */ long B = 6215463252132450750L;
    private /* synthetic */ int a;

    public /* synthetic */ MapleSidekickCharacter(int a2, String a3, int a4, int a5, int a6) {
        MapleSidekickCharacter a7;
        MapleSidekickCharacter mapleSidekickCharacter = a7;
        MapleSidekickCharacter mapleSidekickCharacter2 = a7;
        a7.k = a3;
        mapleSidekickCharacter2.K = a2;
        mapleSidekickCharacter2.a = a4;
        mapleSidekickCharacter.d = a5;
        mapleSidekickCharacter.ALLATORIxDEMO = a6;
    }

    public /* synthetic */ void update(MapleCharacter a2) {
        MapleSidekickCharacter a3;
        MapleSidekickCharacter mapleSidekickCharacter = a3;
        MapleCharacter mapleCharacter = a2;
        MapleSidekickCharacter mapleSidekickCharacter2 = a3;
        mapleSidekickCharacter2.k = a2.getName();
        mapleSidekickCharacter2.a = a2.getLevel();
        a3.K = mapleCharacter.getId();
        mapleSidekickCharacter.d = mapleCharacter.getJob();
        mapleSidekickCharacter.ALLATORIxDEMO = a2.getMapId();
    }

    public /* synthetic */ int getJobId() {
        MapleSidekickCharacter a2;
        return a2.d;
    }

    public /* synthetic */ int getLevel() {
        MapleSidekickCharacter a2;
        return a2.a;
    }

    public /* synthetic */ int hashCode() {
        MapleSidekickCharacter a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + a2.K;
        return n2;
    }

    public /* synthetic */ MapleSidekickCharacter(MapleCharacter a2) {
        MapleSidekickCharacter a3;
        MapleSidekickCharacter mapleSidekickCharacter = a3;
        mapleSidekickCharacter.update(a2);
    }

    public /* synthetic */ int getId() {
        MapleSidekickCharacter a2;
        return a2.K;
    }

    public /* synthetic */ String getName() {
        MapleSidekickCharacter a2;
        return a2.k;
    }

    public /* synthetic */ int getMapid() {
        MapleSidekickCharacter a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ boolean equals(Object a2) {
        MapleSidekickCharacter a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (MapleSidekickCharacter)a2;
        return !(a3.k == null ? ((MapleSidekickCharacter)a2).k != null : !a3.k.equals(((MapleSidekickCharacter)a2).k));
    }
}

