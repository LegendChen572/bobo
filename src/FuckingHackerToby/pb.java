/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.I;
import FuckingHackerToby.Rb;
import FuckingHackerToby.f;
import FuckingHackerToby.ka;
import java.awt.image.BufferedImage;

public final class pb
extends ka<f>
implements I {
    private /* synthetic */ int a;
    private /* synthetic */ BufferedImage[] g;
    private /* synthetic */ int d;
    public static final /* synthetic */ int ALLATORIxDEMO = -1;
    private /* synthetic */ float K;
    private /* synthetic */ double k;
    private /* synthetic */ int B;

    public /* synthetic */ float ALLATORIxDEMO() {
        pb a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(int a2) {
        a.a = a2;
    }

    public /* synthetic */ pb(float a2, Rb a3) {
        a4(a2, a3.ALLATORIxDEMO());
        pb a4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean ALLATORIxDEMO() {
        pb a2;
        if (a2.a == -1) return true;
        pb pb2 = a2;
        if (pb2.d >= pb2.a) return false;
        return true;
    }

    public /* synthetic */ int ALLATORIxDEMO() {
        pb a2;
        return a2.g.length;
    }

    public /* synthetic */ pb(float a2, BufferedImage ... a3) {
        pb a4;
        pb pb2 = a4;
        a4.K = a2;
        pb2.g = a3;
        pb2.a = -1;
    }

    public /* synthetic */ void H() {
        pb a2;
        pb pb2 = a2;
        a2.k = 0.0;
        pb2.B = 0;
        pb2.d = 0;
    }

    public /* synthetic */ void ALLATORIxDEMO() {
        pb a3;
        pb pb2 = a3;
        ++pb2.B;
        if (pb2.B > a3.g.length - 1) {
            pb pb3 = a3;
            pb3.B = 0;
            ++pb3.d;
            pb3.ALLATORIxDEMO(a2 -> {
                pb a3;
                a2.ALLATORIxDEMO(a3);
            });
        }
    }

    public /* synthetic */ int H() {
        pb a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(float a2) {
        a.K = a2;
    }

    public /* synthetic */ int l() {
        pb a2;
        return a2.B;
    }

    public /* synthetic */ BufferedImage ALLATORIxDEMO() {
        pb a2;
        pb pb2 = a2;
        return pb2.g[pb2.B];
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(double a2) {
        pb a3;
        if (!a3.ALLATORIxDEMO()) {
            return;
        }
        pb pb2 = a3;
        pb2.k += a2;
        if (pb2.k >= (double)a3.K) {
            a3.k = 0.0;
            a3.ALLATORIxDEMO();
        }
    }

    public /* synthetic */ BufferedImage ALLATORIxDEMO(int a2) {
        pb a3;
        if (a2 < 0 || a2 > a3.ALLATORIxDEMO() - 1) {
            return null;
        }
        return a3.g[a2];
    }
}

