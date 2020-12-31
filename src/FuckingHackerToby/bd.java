/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Qa;
import FuckingHackerToby.l;
import java.util.Random;

public final class bd
implements l {
    private /* synthetic */ Random a;
    private /* synthetic */ int g;
    private /* synthetic */ double K;
    private static final /* synthetic */ double ALLATORIxDEMO = 1.0;
    private /* synthetic */ Qa[][] k;
    private /* synthetic */ int B;
    private static final /* synthetic */ double d = 1.0;

    public /* synthetic */ int ALLATORIxDEMO() {
        bd a2;
        return a2.B;
    }

    private /* synthetic */ double ALLATORIxDEMO(double a2, double a3, double a4) {
        a4 = (1.0 - Math.cos(a4 * Math.PI)) / 2.0;
        return a2 * (1.0 - a4) + a3 * a4;
    }

    public /* synthetic */ int H() {
        bd a2;
        return a2.g;
    }

    public /* synthetic */ bd(int a2, int a3, long a4) {
        bd a5;
        bd bd2 = a5;
        bd2(a2, a3);
        bd2.a.setSeed(a4);
    }

    public /* synthetic */ void ALLATORIxDEMO(double a2) {
        a.K = a2;
    }

    @Override
    public /* synthetic */ double ALLATORIxDEMO(double a2, double a3) {
        bd a4;
        int n2 = (int)a2;
        int n3 = (int)a3;
        int n4 = n2 + 1;
        int n5 = n3 + 1;
        if (n2 < 0 || n3 < 0 || n4 > a4.g - 1 || n5 > a4.B - 1) {
            return 0.0;
        }
        Qa qa2 = new Qa(a2, a3);
        Qa qa3 = new Qa(n2, n3);
        Qa qa4 = new Qa(n4, n3);
        Qa qa5 = new Qa(n2, n5);
        Qa qa6 = new Qa(n4, n5);
        Qa qa7 = qa2;
        qa2 = qa7.H(qa3);
        qa3 = qa7.H(qa4);
        qa4 = qa7.H(qa5);
        qa5 = qa7.H(qa6);
        bd bd2 = a4;
        qa6 = bd2.k[n2][n3];
        Qa qa8 = bd2.k[n4][n3];
        Qa qa9 = bd2.k[n2][n5];
        Qa qa10 = bd2.k[n4][n5];
        double d2 = qa2.H(qa6);
        double d3 = qa3.H(qa8);
        double d4 = qa4.H(qa9);
        double d5 = qa5.H(qa10);
        d2 = bd2.ALLATORIxDEMO(d2, d3, a2 -= (double)n2);
        a2 = bd2.ALLATORIxDEMO(d4, d5, a2);
        a2 = bd2.ALLATORIxDEMO(d2, a2, a3 -= (double)n3) * a4.K;
        a2 = Math.max(Math.min(a2, 1.0), -1.0);
        return a2;
    }

    public /* synthetic */ void H(double a2) {
        bd a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.g) {
            int n4;
            int n5 = n4 = 0;
            while (n5 < a3.B) {
                bd bd2 = a3;
                Qa qa2 = bd2.k[n2][n4].ALLATORIxDEMO(a2);
                bd2.k[n2][n4++] = qa2;
                n5 = n4;
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ bd(int a2, int a3) {
        bd a4;
        bd bd2 = a4;
        a4.g = a2;
        bd2.B = a3;
        bd2.k = new Qa[a2][a3];
        bd bd3 = a4;
        bd3.K = 1.0;
        bd3.a = new Random();
        a4.ALLATORIxDEMO();
    }

    public /* synthetic */ void ALLATORIxDEMO() {
        bd a2;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.g) {
            int n4;
            int n5 = n4 = 0;
            while (n5 < a2.B) {
                bd bd2 = a2;
                double d2 = bd2.a.nextDouble() * 360.0;
                Qa qa2 = new Qa(1.0, 0.0).ALLATORIxDEMO(d2);
                bd2.k[n2][n4++] = qa2;
                n5 = n4;
            }
            n3 = ++n2;
        }
    }
}

