/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Lb;
import FuckingHackerToby.Ua;
import java.awt.image.BufferedImage;

public final class Rb {
    private /* synthetic */ int d;
    private /* synthetic */ int B;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ BufferedImage[][] g;
    private /* synthetic */ int K;
    private /* synthetic */ int k;
    private /* synthetic */ int a;

    public /* synthetic */ BufferedImage ALLATORIxDEMO(int a2, Lb a3) {
        Rb rb;
        Rb a4;
        int n2 = 0;
        int n3 = 0;
        if (a3 == Lb.a) {
            n2 = a2 % a4.d;
            n3 = a2 / a4.d;
            rb = a4;
        } else {
            if (a3 == Lb.d) {
                n2 = a2 / a4.d;
                n3 = a2 % a4.d;
            }
            rb = a4;
        }
        return rb.ALLATORIxDEMO(n2, n3);
    }

    public /* synthetic */ Rb(String a2, int a3, int a4) {
        a5(Ua.H(a2), a3, a4);
        Rb a5;
    }

    public /* synthetic */ int l() {
        Rb a2;
        return a2.a;
    }

    public /* synthetic */ BufferedImage[] ALLATORIxDEMO(Lb a2, int ... a3) {
        int n2;
        int n3 = a3.length;
        BufferedImage[] arrbufferedImage = new BufferedImage[n3];
        int n4 = n2 = 0;
        while (n4 < n3) {
            Rb a4;
            int n5 = a3[n2];
            arrbufferedImage[n2++] = a4.ALLATORIxDEMO(n5, a2);
            n4 = n2;
        }
        return arrbufferedImage;
    }

    public /* synthetic */ BufferedImage[] ALLATORIxDEMO() {
        int n2;
        Rb a2;
        Rb rb = a2;
        BufferedImage[] arrbufferedImage = new BufferedImage[rb.d * rb.ALLATORIxDEMO];
        int n3 = n2 = 0;
        while (n3 < a2.d) {
            int n4;
            int n5 = n4 = 0;
            while (n5 < a2.ALLATORIxDEMO) {
                BufferedImage bufferedImage = a2.ALLATORIxDEMO(n2, n4);
                int n6 = n2 + n4 * a2.d;
                arrbufferedImage[n6] = bufferedImage;
                n5 = ++n4;
            }
            n3 = ++n2;
        }
        return arrbufferedImage;
    }

    public /* synthetic */ int ALLATORIxDEMO() {
        Rb a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int D() {
        Rb a2;
        return a2.K;
    }

    public /* synthetic */ Rb(BufferedImage a2, int a3, int a4) {
        Rb a5;
        Rb rb = a5;
        Rb rb2 = a5;
        rb2.K = a3;
        rb2.a = a4;
        a5.B = a2.getWidth();
        rb.k = a2.getHeight();
        rb.d = a5.B / a3;
        rb.ALLATORIxDEMO = rb.k / a4;
        rb.g = new BufferedImage[rb.d][a5.ALLATORIxDEMO];
        a5.ALLATORIxDEMO(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(BufferedImage a2) {
        Rb a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.d) {
            int n4;
            int n5 = n4 = 0;
            while (n5 < a3.ALLATORIxDEMO) {
                int n6 = n2 * a3.K;
                int n7 = n4 * a3.a;
                Rb rb = a3;
                BufferedImage bufferedImage = a2.getSubimage(n6, n7, rb.K, rb.a);
                a3.g[n2][n4++] = bufferedImage;
                n5 = n4;
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ int H() {
        Rb a2;
        return a2.d;
    }

    public /* synthetic */ BufferedImage[] ALLATORIxDEMO(int ... a2) {
        Rb a3;
        return a3.ALLATORIxDEMO(Lb.a, a2);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 2 << 1;
        int cfr_ignored_0 = 3 ^ 5;
        int n5 = n3;
        int n6 = 4 << 3 ^ 3;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ BufferedImage ALLATORIxDEMO(int a2, int a3) {
        Rb a4;
        if (a2 < 0 || a3 < 0 || a2 > a4.d - 1 || a3 > a4.ALLATORIxDEMO - 1) {
            return null;
        }
        return a4.g[a2][a3];
    }

    public /* synthetic */ BufferedImage ALLATORIxDEMO(int a2) {
        Rb a3;
        return a3.ALLATORIxDEMO(a2, Lb.a);
    }
}

