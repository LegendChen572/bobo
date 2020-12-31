/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.I;
import FuckingHackerToby.ka;

public final class wC
extends ka<I> {
    private /* synthetic */ long d;
    private static final /* synthetic */ double ALLATORIxDEMO = 1.0E9;
    private /* synthetic */ long K;
    private /* synthetic */ long a;

    public /* synthetic */ double H() {
        wC a2;
        return (double)(System.nanoTime() - a2.K) / 1.0E9;
    }

    public /* synthetic */ long ALLATORIxDEMO() {
        wC a2;
        return a2.d;
    }

    public /* synthetic */ double ALLATORIxDEMO() {
        wC a2;
        return (double)(System.nanoTime() - a2.a) / 1.0E9;
    }

    public /* synthetic */ void ALLATORIxDEMO() {
        wC a2;
        wC wC2 = a2;
        wC2.K = wC2.a = System.nanoTime();
        a2.d = 0L;
    }

    public /* synthetic */ double l() {
        wC a2;
        long l2 = System.nanoTime();
        double d2 = (double)(System.nanoTime() - a2.a) / 1.0E9;
        a2.ALLATORIxDEMO(a3 -> a3.ALLATORIxDEMO(d2));
        a2.a = l2;
        ++a2.d;
        return d2;
    }

    public /* synthetic */ wC() {
        wC a2;
        wC wC2 = a2;
        wC2.ALLATORIxDEMO();
    }
}

