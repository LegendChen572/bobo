/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import FuckingHackerToby.za;

public final class P
implements j {
    private /* synthetic */ String k;
    private /* synthetic */ byte a;
    private static final /* synthetic */ byte d = 0;
    private static final /* synthetic */ byte ALLATORIxDEMO = 1;
    private /* synthetic */ byte[] K;

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a2) {
        P a3;
        P p2 = a3;
        za.D(a3.k);
        za.ALLATORIxDEMO(a3.k, p2.K);
        if (p2.a == 1) {
            za.ALLATORIxDEMO(a3.k);
        }
    }

    public /* synthetic */ P() {
        P a2;
        P p2 = a2;
        p2.k = "";
        p2.K = new byte[0];
    }

    public /* synthetic */ P(String a2, byte[] a3, boolean a4) {
        P a5;
        P p2 = a5;
        a5.k = a2;
        p2.K = a3;
        p2.a = a4 ? (byte)1 : 0;
    }

    public /* synthetic */ P(String a2, byte[] a3) {
        a4(a2, a3, false);
        P a4;
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        P a3;
        ta ta2 = a2;
        int n2 = ta2.D();
        P p2 = a3;
        p2.K = new byte[n2];
        ta2.ALLATORIxDEMO(a3.K);
        ta ta3 = a2;
        a3.k = ta3.H();
        p2.a = ta3.ALLATORIxDEMO();
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        P a3;
        a2.ALLATORIxDEMO(a3.K.length);
        ta ta2 = a2;
        P p2 = a3;
        a2.H(p2.K);
        ta2.ALLATORIxDEMO(p2.k);
        ta2.ALLATORIxDEMO(a3.a);
    }
}

