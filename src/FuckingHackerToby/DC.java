/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.I;
import FuckingHackerToby.Ua;
import FuckingHackerToby.c;
import FuckingHackerToby.pb;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public final class DC
implements I,
c {
    private /* synthetic */ BufferedImage d;
    private /* synthetic */ double a;
    private /* synthetic */ double B;
    private /* synthetic */ double k;
    private /* synthetic */ int E;
    private /* synthetic */ pb ALLATORIxDEMO;
    private /* synthetic */ double K;
    private /* synthetic */ int g;

    public /* synthetic */ void E(double a2) {
        a.B = a2;
    }

    public /* synthetic */ int H() {
        DC a2;
        return a2.E;
    }

    public /* synthetic */ void ALLATORIxDEMO(BufferedImage a2) {
        a.d = a2;
    }

    public /* synthetic */ double H() {
        DC a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(Graphics2D a2) {
        DC a3;
        DC dC = a3;
        int n2 = (int)(a3.B - (double)dC.E * Math.signum(a3.B));
        int n3 = (int)(dC.k - (double)a3.g * Math.signum(a3.k));
        DC dC2 = a3;
        a2.drawImage((Image)dC2.d, (int)dC2.B, (int)a3.k, null);
        if (n2 != 0 && n3 != 0) {
            a2.drawImage((Image)a3.d, n2, (int)a3.k, null);
            DC dC3 = a3;
            a2.drawImage((Image)dC3.d, (int)dC3.B, n3, null);
            a2.drawImage((Image)a3.d, n2, n3, null);
            return;
        }
        if (n2 != 0) {
            a2.drawImage((Image)a3.d, n2, (int)a3.k, null);
            return;
        }
        if (n3 != 0) {
            DC dC4 = a3;
            a2.drawImage((Image)dC4.d, (int)dC4.B, n3, null);
        }
    }

    public /* synthetic */ DC(String a2, int a3, int a4) {
        a5(Ua.H(a2), a3, a4);
        DC a5;
    }

    public /* synthetic */ DC(BufferedImage a2, int a3, int a4) {
        DC a5;
        DC dC = a5;
        a5.E = a3;
        dC.g = a4;
        dC.d = Ua.ALLATORIxDEMO(a2, a3, a4);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(double a2) {
        DC a3;
        if (a3.ALLATORIxDEMO != null) {
            DC dC = a3;
            dC.ALLATORIxDEMO.ALLATORIxDEMO(a2);
            dC.d = dC.ALLATORIxDEMO.ALLATORIxDEMO();
        }
        DC dC = a3;
        dC.B += a3.K * a2;
        dC.k += a3.a * a2;
        dC.B %= (double)a3.E;
        dC.k %= (double)a3.g;
    }

    public /* synthetic */ void ALLATORIxDEMO(pb a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ DC(String a2) {
        a3(Ua.H(a2));
        DC a3;
    }

    public /* synthetic */ double D() {
        DC a2;
        return a2.B;
    }

    public /* synthetic */ void l(double a2) {
        a.K = a2;
    }

    public /* synthetic */ void H(double a2) {
        a.a = a2;
    }

    public /* synthetic */ DC(BufferedImage a2) {
        DC a3;
        BufferedImage bufferedImage = a2;
        a3(bufferedImage, a2.getWidth(), bufferedImage.getHeight());
    }

    public /* synthetic */ DC(pb a2) {
        a3(a2.ALLATORIxDEMO());
        DC a3;
        a3.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ double ALLATORIxDEMO() {
        DC a2;
        return a2.a;
    }

    public /* synthetic */ int ALLATORIxDEMO() {
        DC a2;
        return a2.g;
    }

    public /* synthetic */ void D(double a2) {
        a.k = a2;
    }

    public /* synthetic */ double l() {
        DC a2;
        return a2.k;
    }
}

