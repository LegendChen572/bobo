/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.D;
import FuckingHackerToby.G;
import FuckingHackerToby.c;

public abstract class lB
implements c,
D,
G {
    public /* synthetic */ boolean K;
    public /* synthetic */ boolean k;
    public /* synthetic */ boolean d;
    public /* synthetic */ boolean ALLATORIxDEMO;
    public /* synthetic */ int B;
    public /* synthetic */ int E;
    public /* synthetic */ int e;
    public /* synthetic */ boolean a;
    public /* synthetic */ int g;

    public final /* synthetic */ void H(int a2) {
        a.g = a2;
    }

    @Override
    public final /* synthetic */ void ALLATORIxDEMO(int a2, int a3, int a4) {
        lB a5;
        if (a5.k) {
            a5.I(a4);
        }
    }

    public final /* synthetic */ void ALLATORIxDEMO(int a2) {
        a.B = a2;
    }

    public /* synthetic */ lB(int a2, int a3, int a4, int a5) {
        lB a6;
        lB lB2 = a6;
        lB lB3 = a6;
        lB3.e = a2;
        lB3.E = a3;
        lB2.g = a4;
        lB2.B = a5;
    }

    public final /* synthetic */ int ALLATORIxDEMO() {
        lB a2;
        return a2.B;
    }

    public abstract /* synthetic */ void E(int var1);

    public final /* synthetic */ void l(int a2) {
        a.E = a2;
    }

    @Override
    public final /* synthetic */ void ALLATORIxDEMO(int a2, boolean a3) {
        lB a4;
        if (a4.K && a3) {
            a4.E(a2);
        }
    }

    public final /* synthetic */ boolean H() {
        lB a2;
        return a2.d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean ALLATORIxDEMO(int a2, int a3) {
        lB a4;
        if (a2 <= a4.e) return false;
        lB lB2 = a4;
        if (a2 >= lB2.e + lB2.g) return false;
        if (a3 <= a4.E) return false;
        lB lB3 = a4;
        if (a3 >= lB3.E + lB3.B) return false;
        return true;
    }

    public final /* synthetic */ void D(int a2) {
        a.e = a2;
    }

    public final /* synthetic */ boolean E() {
        lB a2;
        return a2.k;
    }

    public final /* synthetic */ boolean l() {
        lB a2;
        return a2.a;
    }

    public final /* synthetic */ int l() {
        lB a2;
        return a2.E;
    }

    public final /* synthetic */ boolean ALLATORIxDEMO() {
        lB a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ boolean D() {
        lB a2;
        return a2.K;
    }

    public final /* synthetic */ int D() {
        lB a2;
        return a2.e;
    }

    public abstract /* synthetic */ void d(int var1);

    @Override
    public final /* synthetic */ void ALLATORIxDEMO(int a2, int a3, int a4, boolean a5) {
        lB a6;
        int n2 = a2 = (a6.a || a6.ALLATORIxDEMO) && !a5 && a6.k ? 1 : 0;
        if (a2 != 0) {
            a6.d(a4);
        }
        if (a4 == 1) {
            boolean bl = a6.a = a6.k && a5;
            if (!a5) {
                a6.K = a6.k;
                return;
            }
        } else {
            if (a4 == 2) {
                a6.d = a6.k && a5;
                return;
            }
            if (a4 == 3) {
                a6.ALLATORIxDEMO = a6.k && a5;
            }
        }
    }

    @Override
    public final /* synthetic */ void H(int a2, int a3, int a4) {
        lB a5;
        a5.k = a5.ALLATORIxDEMO(a2, a3);
    }

    public final /* synthetic */ int H() {
        lB a2;
        return a2.g;
    }

    public abstract /* synthetic */ void I(int var1);
}

