/*
 * Decompiled with CFR 0.150.
 */
package client;

public class MaplePartTimeJob {
    private final /* synthetic */ int K;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ byte a;
    private /* synthetic */ long d;

    public /* synthetic */ void setJob(byte a2) {
        a.a = a2;
    }

    public /* synthetic */ int getReward() {
        MaplePartTimeJob a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ long getTime() {
        MaplePartTimeJob a2;
        return a2.d;
    }

    public /* synthetic */ int getCharacterId() {
        MaplePartTimeJob a2;
        return a2.K;
    }

    public /* synthetic */ void setReward(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ MaplePartTimeJob(int a2) {
        MaplePartTimeJob a3;
        MaplePartTimeJob maplePartTimeJob = a3;
        MaplePartTimeJob maplePartTimeJob2 = a3;
        maplePartTimeJob2.a = 0;
        maplePartTimeJob2.d = 0L;
        maplePartTimeJob.ALLATORIxDEMO = 0;
        maplePartTimeJob.K = a2;
    }

    public /* synthetic */ void setTime(long a2) {
        a.d = a2;
    }

    public /* synthetic */ byte getJob() {
        MaplePartTimeJob a2;
        return a2.a;
    }
}

