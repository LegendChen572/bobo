/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

public strictfp final class Qa {
    private /* synthetic */ double ALLATORIxDEMO;
    private /* synthetic */ double d;

    public /* synthetic */ Qa ALLATORIxDEMO() {
        Qa a2;
        return Qa.ALLATORIxDEMO(a2);
    }

    public static /* synthetic */ double ALLATORIxDEMO(Qa a2, Qa a3) {
        return a2.d * a3.d + a2.ALLATORIxDEMO * a3.ALLATORIxDEMO;
    }

    public /* synthetic */ Qa(double a2, double a3) {
        Qa a4;
        Qa qa2 = a4;
        qa2.d = a2;
        qa2.ALLATORIxDEMO = a3;
    }

    public /* synthetic */ double H() {
        Qa a2;
        return a2.d;
    }

    public /* synthetic */ void H(double a2) {
        a.d = a2;
    }

    public /* synthetic */ double l() {
        Qa a2;
        return Qa.ALLATORIxDEMO(a2);
    }

    public /* synthetic */ String toString() {
        Qa a2;
        return "[" + a2.d + " | " + a2.ALLATORIxDEMO + "] - Length: " + a2.l();
    }

    public /* synthetic */ void D(double a2) {
        a.d += a2;
    }

    public /* synthetic */ void ALLATORIxDEMO(double a2) {
        a.ALLATORIxDEMO = a2;
    }

    public static /* synthetic */ double ALLATORIxDEMO(Qa a2) {
        return Math.sqrt(a2.d * a2.d + a2.ALLATORIxDEMO * a2.ALLATORIxDEMO);
    }

    public static /* synthetic */ Qa ALLATORIxDEMO(Qa a2) {
        Qa qa2 = a2;
        double d2 = Qa.ALLATORIxDEMO(qa2);
        double d3 = qa2.d / d2;
        d2 = qa2.ALLATORIxDEMO / d2;
        return new Qa(d3, d2);
    }

    public static /* synthetic */ Qa ALLATORIxDEMO(Qa a2, double a3) {
        a3 = Math.toRadians(a3);
        Qa qa2 = a2;
        double d2 = a2.d * Math.cos(a3) - qa2.ALLATORIxDEMO * Math.sin(a3);
        a3 = qa2.ALLATORIxDEMO * Math.cos(a3) + a2.d * Math.sin(a3);
        return new Qa(d2, a3);
    }

    public /* synthetic */ Qa() {
        a2(0.0, 0.0);
        Qa a2;
    }

    public /* synthetic */ Qa H(Qa a2) {
        Qa a3;
        return Qa.ALLATORIxDEMO(a3, a2);
    }

    public /* synthetic */ Qa(double a2) {
        Qa a3;
        double d2 = a2;
        a3(d2, d2);
    }

    public static /* synthetic */ Qa ALLATORIxDEMO(Qa a2, Qa a3) {
        Qa qa2 = a3;
        double d2 = qa2.d - a2.d;
        double d3 = qa2.ALLATORIxDEMO - a2.ALLATORIxDEMO;
        return new Qa(d2, d3);
    }

    public /* synthetic */ double ALLATORIxDEMO() {
        Qa a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void ALLATORIxDEMO(double a2, double a3) {
        Qa a4;
        Qa qa2 = a4;
        qa2.d = a2;
        qa2.ALLATORIxDEMO = a3;
    }

    public /* synthetic */ double H(Qa a2) {
        Qa a3;
        return Qa.ALLATORIxDEMO(a3, a2);
    }

    public /* synthetic */ Qa ALLATORIxDEMO(double a2) {
        Qa a3;
        return Qa.ALLATORIxDEMO(a3, a2);
    }

    public /* synthetic */ void l(double a2) {
        a.ALLATORIxDEMO += a2;
    }
}

