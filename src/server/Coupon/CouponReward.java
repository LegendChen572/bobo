/*
 * Decompiled with CFR 0.150.
 */
package server.Coupon;

public class CouponReward {
    private final /* synthetic */ int k;
    private final /* synthetic */ int K;
    private final /* synthetic */ boolean ALLATORIxDEMO;
    private final /* synthetic */ int a;
    private final /* synthetic */ int d;

    public /* synthetic */ boolean canShowMsg() {
        CouponReward a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ CouponReward(int a2, int a3, int a4, int a5, boolean a6) {
        CouponReward a7;
        CouponReward couponReward = a7;
        CouponReward couponReward2 = a7;
        a7.k = a2;
        couponReward2.K = a3;
        couponReward2.a = a4;
        couponReward.d = a5;
        couponReward.ALLATORIxDEMO = a6;
    }

    public /* synthetic */ int getItemId() {
        CouponReward a2;
        return a2.k;
    }

    public /* synthetic */ int getMinNumber() {
        CouponReward a2;
        return a2.a;
    }

    public /* synthetic */ int getChance() {
        CouponReward a2;
        return a2.K;
    }

    public /* synthetic */ int getMaxNumber() {
        CouponReward a2;
        return a2.d;
    }
}

