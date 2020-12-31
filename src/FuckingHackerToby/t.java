/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public final class t
implements j {
    private /* synthetic */ int d;
    private static final /* synthetic */ String ALLATORIxDEMO = "http://";
    private /* synthetic */ String a;

    public /* synthetic */ t(String a2) {
        a3(a2, 1);
        t a3;
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        t a3;
        ta ta2 = a2;
        ta2.ALLATORIxDEMO(a3.a);
        ta2.ALLATORIxDEMO(a3.d);
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        t a3;
        t t2 = a3;
        t2.a = a2.H();
        t2.d = a2.D();
    }

    public /* synthetic */ t(String a2, int a3) {
        t a4;
        a4.d = a3;
        if (a2.startsWith(ALLATORIxDEMO)) {
            a4.a = a2;
            return;
        }
        a4.a = ALLATORIxDEMO + a2;
    }

    private /* synthetic */ void ALLATORIxDEMO(String a22) {
        Desktop desktop;
        if (Desktop.isDesktopSupported() && (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.BROWSE)) {
            try {
                a22 = new URI((String)a22);
                desktop.browse((URI)a22);
                return;
            }
            catch (IOException | URISyntaxException a22) {
                a22.printStackTrace();
            }
        }
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        t a2;
        return a2.a;
    }

    public /* synthetic */ t() {
        a2("");
        t a2;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a2) {
        t a3;
        int n2 = a2 = 0;
        while (n2 < a3.d) {
            t t2 = a3;
            t2.ALLATORIxDEMO(t2.a);
            n2 = ++a2;
        }
    }
}

