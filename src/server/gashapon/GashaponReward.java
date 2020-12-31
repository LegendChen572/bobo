/*
 * Decompiled with CFR 0.150.
 */
package server.gashapon;

public class GashaponReward {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ int k;
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int K;
    private final /* synthetic */ int d;

    public /* synthetic */ boolean canShowMsg() {
        GashaponReward a2;
        return a2.a;
    }

    public /* synthetic */ int getMin() {
        GashaponReward a2;
        return a2.d;
    }

    public /* synthetic */ int getMax() {
        GashaponReward a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getItemId() {
        GashaponReward a2;
        return a2.k;
    }

    public /* synthetic */ GashaponReward(int a2, int a3, boolean a4, int a5, int a6) {
        GashaponReward a7;
        GashaponReward gashaponReward = a7;
        GashaponReward gashaponReward2 = a7;
        a7.k = a2;
        gashaponReward2.K = a3;
        gashaponReward2.a = a4;
        gashaponReward.d = a5;
        gashaponReward.ALLATORIxDEMO = a6;
    }

    public /* synthetic */ int getChance() {
        GashaponReward a2;
        return a2.K;
    }

    public /* synthetic */ GashaponReward(int a2, int a3, boolean a4) {
        GashaponReward a5;
        GashaponReward gashaponReward = a5;
        GashaponReward gashaponReward2 = a5;
        a5.k = a2;
        gashaponReward2.K = a3;
        gashaponReward2.a = a4;
        gashaponReward.d = 1;
        gashaponReward.ALLATORIxDEMO = 1;
    }
}

