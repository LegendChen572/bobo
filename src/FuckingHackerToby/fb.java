/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.I;
import FuckingHackerToby.Pa;
import FuckingHackerToby.lC;
import FuckingHackerToby.va;
import java.awt.Graphics2D;

public final class fb
implements I {
    private /* synthetic */ double J;
    private /* synthetic */ double M;
    private /* synthetic */ va k;
    private /* synthetic */ double I;
    private /* synthetic */ double B;
    private /* synthetic */ double C;
    private /* synthetic */ double j;
    private /* synthetic */ double F;
    private /* synthetic */ float D;
    private /* synthetic */ lC K;
    private /* synthetic */ double e;
    public static final /* synthetic */ float a = 0.0f;
    private /* synthetic */ double m;
    private /* synthetic */ double A;
    private /* synthetic */ double E;
    private /* synthetic */ double f;
    private /* synthetic */ double H;
    public static final /* synthetic */ int d = Integer.MIN_VALUE;
    private /* synthetic */ double g;
    private /* synthetic */ double h;
    public static final /* synthetic */ int ALLATORIxDEMO = Integer.MAX_VALUE;
    private /* synthetic */ double L;
    private /* synthetic */ double i;

    public /* synthetic */ void ALLATORIxDEMO(double a2, double a3, double a4, double a5) {
        fb a6;
        fb fb2 = a6;
        fb2.D(a2, a3);
        fb2.l(a4, a5);
    }

    public /* synthetic */ void E(double a2, double a3) {
        fb a4;
        fb fb2 = a4;
        fb2.m = fb2.f = a2;
        fb fb3 = a4;
        fb3.A = fb3.h = a3;
        fb fb4 = a4;
        fb4.I();
        fb4.d();
    }

    public /* synthetic */ double I() {
        fb a2;
        return a2.L;
    }

    public /* synthetic */ void D() {
        fb a2;
        fb fb2 = a2;
        fb2.g = 0.0;
        fb2.E = 0.0;
        fb fb3 = a2;
        fb3.B = 0.0;
        fb3.k.ALLATORIxDEMO();
        fb3.K.ALLATORIxDEMO();
    }

    public /* synthetic */ void E() {
        fb a2;
        fb fb2 = a2;
        fb2.A = 0.0;
        fb2.m = 0.0;
        fb fb3 = a2;
        fb3.h = 0.0;
        fb3.f = 0.0;
        fb fb4 = a2;
        fb4.D();
        fb4.l();
        fb4.H();
    }

    public /* synthetic */ void ALLATORIxDEMO(Graphics2D a2) {
        fb a3;
        fb fb2 = a3;
        double d2 = fb2.g();
        double d3 = fb2.c();
        double d4 = fb2.H();
        if (fb2.C != 0.0) {
            double d5 = 1.0 / a3.C;
            Graphics2D graphics2D = a2;
            a2.translate(a3.H, a3.e);
            graphics2D.scale(d5, d5);
            graphics2D.translate(-a3.H, -a3.e);
        }
        a2.translate(d2, d3);
        if (d4 != 0.0) {
            a2.rotate(-d4, a3.I, a3.F);
        }
    }

    public /* synthetic */ void D(double a2, double a3) {
        fb a4;
        fb fb2 = a4;
        fb2.L = a2;
        fb2.j = a3;
    }

    public /* synthetic */ double l() {
        fb a2;
        return a2.J;
    }

    public /* synthetic */ float ALLATORIxDEMO() {
        fb a2;
        return a2.D;
    }

    private /* synthetic */ void I() {
        fb a2;
        fb fb2 = a2;
        a2.f = Math.max(Math.min(fb2.f, a2.i), a2.L);
        fb2.h = Math.max(Math.min(fb2.h, a2.J), a2.j);
    }

    public /* synthetic */ double d() {
        fb a2;
        return a2.h;
    }

    public /* synthetic */ double ALLATORIxDEMO() {
        fb a2;
        return a2.C;
    }

    public static /* synthetic */ double l(fb a2, double a3) {
        a2.E = a3;
        return a2.E;
    }

    public /* synthetic */ double b() {
        fb a2;
        return a2.f;
    }

    public /* synthetic */ void d(double a2, double a3) {
        fb a4;
        fb fb2 = a4;
        fb2.f += a2;
        fb2.h += a3;
        fb2.I();
    }

    private /* synthetic */ void D(double a2) {
        fb a3;
        if (a3.D == 0.0f) {
            fb fb2 = a3;
            fb2.m = fb2.f;
            fb2.A = fb2.h;
            return;
        }
        fb fb3 = a3;
        double d2 = fb3.f - a3.m;
        fb fb4 = a3;
        double d3 = fb3.h - fb4.A;
        fb4.m += d2 / (double)a3.D * a2;
        fb3.A += d3 / (double)a3.D * a2;
    }

    public /* synthetic */ fb() {
        fb a2;
        a2.j = -2.147483648E9;
        a2.L = -2.147483648E9;
        fb fb2 = a2;
        fb2.J = 2.147483647E9;
        fb2.i = 2.147483647E9;
        fb fb3 = a2;
        fb3.k = new va();
        fb3.K = new lC(a2);
    }

    public /* synthetic */ void l(double a2) {
        a.M = Math.toRadians(a2);
    }

    public /* synthetic */ void ALLATORIxDEMO(double a2, double a3, double a4, float a5) {
        fb a6;
        Pa pa2 = new Pa(() -> {
            fb a2;
            a2.D();
        }, a5);
        fb fb2 = a6;
        fb2.D();
        fb2.k.H(pa2);
        fb2.K.ALLATORIxDEMO(a2, a3, Math.toRadians(a4), a5);
    }

    public /* synthetic */ void l() {
        fb a2;
        fb fb2 = a2;
        fb2.M = 0.0;
        fb2.F = 0.0;
        fb2.I = 0.0;
    }

    private /* synthetic */ void d() {
        double d2;
        fb a2;
        fb fb2 = a2;
        a2.m = Math.max(Math.min(fb2.m, a2.i), a2.L);
        fb2.A = Math.max(Math.min(fb2.A, a2.J), a2.j);
        double d3 = fb2.g();
        double d4 = fb2.c();
        if (d3 < a2.L) {
            d2 = d4;
            a2.E = a2.m - a2.L;
        } else {
            if (d3 > a2.i) {
                a2.E = a2.m - a2.i;
            }
            d2 = d4;
        }
        if (d2 < a2.j) {
            a2.g = a2.A - a2.j;
            return;
        }
        if (d4 > a2.J) {
            a2.g = a2.A - a2.J;
        }
    }

    public static /* synthetic */ double ALLATORIxDEMO(fb a2, double a3) {
        a2.B = a3;
        return a2.B;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(double a2) {
        fb a3;
        fb fb2 = a3;
        fb2.D(a2);
        fb2.k.ALLATORIxDEMO(a2);
        fb2.K.ALLATORIxDEMO(a2);
        fb2.d();
    }

    public /* synthetic */ double c() {
        fb a2;
        return a2.A + a2.g;
    }

    public /* synthetic */ void ALLATORIxDEMO(float a2) {
        a.D = a2;
    }

    public /* synthetic */ void I(double a2, double a3) {
        fb a4;
        a4.f = a2;
        a4.h = a3;
        a4.I();
    }

    public /* synthetic */ void l(double a2, double a3) {
        fb a4;
        fb fb2 = a4;
        fb2.i = a2;
        fb2.J = a3;
    }

    public /* synthetic */ void H(double a2, double a3) {
        fb a4;
        fb fb2 = a4;
        fb2.I = a2;
        fb2.F = a3;
    }

    public /* synthetic */ void H() {
        fb a2;
        fb fb2 = a2;
        fb2.C = 0.0;
        fb2.e = 0.0;
        fb2.H = 0.0;
    }

    public /* synthetic */ void H(Graphics2D a2) {
        fb a3;
        fb fb2 = a3;
        double d2 = fb2.g();
        double d3 = fb2.c();
        double d4 = fb2.H();
        if (d4 != 0.0) {
            a2.rotate(d4, a3.I, a3.F);
        }
        a2.translate(-d2, -d3);
        if (a3.C != 0.0) {
            Graphics2D graphics2D = a2;
            fb fb3 = a3;
            a2.translate(fb3.H, a3.e);
            graphics2D.scale(fb3.C, a3.C);
            graphics2D.translate(-a3.H, -a3.e);
        }
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        fb a2;
        return lC.ALLATORIxDEMO(a2.K);
    }

    public static /* synthetic */ double H(fb a2, double a3) {
        a2.g = a3;
        return a2.g;
    }

    public /* synthetic */ double g() {
        fb a2;
        return a2.m + a2.E;
    }

    public /* synthetic */ double D() {
        fb a2;
        return a2.i;
    }

    public /* synthetic */ void ALLATORIxDEMO(double a2, double a3) {
        fb a4;
        fb fb2 = a4;
        fb2.H = a2;
        fb2.e = a3;
    }

    public /* synthetic */ double H() {
        fb a2;
        return a2.M + a2.B;
    }

    public /* synthetic */ double E() {
        fb a2;
        return a2.j;
    }

    public /* synthetic */ void H(double a2) {
        a.C = a2;
    }
}

