/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import FuckingHackerToby.wa;

public final class fa
implements j {
    private /* synthetic */ int K;
    public static final /* synthetic */ byte ALLATORIxDEMO = 1;
    private /* synthetic */ long a;
    public static final /* synthetic */ byte d = 0;
    private /* synthetic */ byte B;
    private /* synthetic */ String k;

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a2) {
        fa a3;
        if (a3.B == 0) {
            fa fa2 = a3;
            wa.ALLATORIxDEMO(fa2.k, fa2.K, a3.a);
            return;
        }
        if (a3.B == 1) {
            fa fa3 = a3;
            wa.ALLATORIxDEMO(fa3.k, fa3.a);
        }
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        fa a3;
        ta ta2 = a2;
        fa fa2 = a3;
        a2.ALLATORIxDEMO(a3.B);
        a2.ALLATORIxDEMO(fa2.k);
        ta2.ALLATORIxDEMO(fa2.K);
        ta2.ALLATORIxDEMO(a3.a);
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        fa a3;
        fa fa2 = a3;
        ta ta2 = a2;
        a3.B = a2.ALLATORIxDEMO();
        a3.k = ta2.H();
        fa2.K = ta2.D();
        fa2.a = a2.ALLATORIxDEMO();
    }

    public /* synthetic */ fa() {
        a2(0, "", 1, 0L);
        fa a2;
    }

    public /* synthetic */ fa(byte a2, String a3, int a4, long a5) {
        fa a6;
        fa fa2 = a6;
        fa fa3 = a6;
        fa3.B = a2;
        fa3.k = a3;
        fa2.K = a4;
        fa2.a = a5;
    }
}

