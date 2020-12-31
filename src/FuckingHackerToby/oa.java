/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.A;
import FuckingHackerToby.D;
import FuckingHackerToby.G;
import FuckingHackerToby.OA;
import FuckingHackerToby.Oa;
import FuckingHackerToby.Ua;
import FuckingHackerToby.a;
import FuckingHackerToby.dA;
import FuckingHackerToby.ka;
import FuckingHackerToby.s;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;

public final class oa
extends ka<a>
implements A,
D,
G {
    private /* synthetic */ int a;
    private /* synthetic */ OA H;
    private static final /* synthetic */ int ALLATORIxDEMO = 540;
    private static final /* synthetic */ int d = 960;
    private /* synthetic */ String E;
    private /* synthetic */ int K;
    private /* synthetic */ int B;
    private /* synthetic */ int k;
    private /* synthetic */ BufferedImage[] g;
    private /* synthetic */ BufferedImage e;

    public static /* synthetic */ void ALLATORIxDEMO(oa a2, Consumer a3) {
        a2.ALLATORIxDEMO(a3);
    }

    @Override
    public /* synthetic */ int ALLATORIxDEMO(String a2, String a3, String a4, String a5) {
        return -1;
    }

    @Override
    public /* synthetic */ File H(String a2) {
        return null;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(List<? extends Image> a3) {
        a.g = (BufferedImage[])a3.stream().filter(a2 -> a2 instanceof BufferedImage).map(a2 -> (BufferedImage)a2).toArray(BufferedImage[]::new);
    }

    @Override
    public /* synthetic */ int l() {
        oa a2;
        return a2.k;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(int a2, boolean a42) {
        oa a5;
        String a42 = a42 ? "Key pressed" : "Key released";
        oa oa2 = a5;
        oa2.a = a2;
        oa2.ALLATORIxDEMO(a3 -> {
            oa a4;
            a3.ALLATORIxDEMO(a42, a4);
        });
    }

    @Override
    public /* synthetic */ boolean ALLATORIxDEMO() {
        oa a2;
        return a2.H.D();
    }

    @Override
    public /* synthetic */ int ALLATORIxDEMO() {
        oa a2;
        return a2.a;
    }

    private /* synthetic */ void H(int a2, int a3) {
        oa a4;
        if (a4.e == null || a4.e.getWidth() != a2 || a4.e.getHeight() != a3) {
            a4.e = new BufferedImage(a2, a3, 1);
        }
    }

    @Override
    public /* synthetic */ int ALLATORIxDEMO(String a2, String a3, String a4) {
        return -1;
    }

    @Override
    public /* synthetic */ void l(String a2) {
    }

    @Override
    public /* synthetic */ String ALLATORIxDEMO(String a2) {
        return null;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(int a2, int a3, s ... a4) {
        int n2;
        oa a5;
        a5.H(a2, a3);
        int n3 = a4.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            s s2;
            s s3 = s2 = a4[n2];
            a5.ALLATORIxDEMO(s3.d, s3.K, s2.a);
            n4 = ++n2;
        }
        a5.ALLATORIxDEMO(a2, a3);
    }

    @Override
    public /* synthetic */ void D(String a2) {
        a.E = a2;
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, int a3) {
        oa a4;
        if (a4.H == null || a4.H.I() != a2 || a4.H.E() != a3 || !a4.H.E()) {
            if (a4.H != null) {
                a4.H.D();
            }
            a4.H = a4.ALLATORIxDEMO(a2, a3);
        }
        oa oa2 = a4;
        oa2.H.I();
        oa2.H.d();
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO() {
        oa a2;
        if (a2.H != null) {
            SwingUtilities.invokeLater(() -> {
                oa a2;
                a2.H.D();
            });
        }
    }

    @Override
    public /* synthetic */ void H(String a2) {
    }

    @Override
    public /* synthetic */ int D() {
        oa a2;
        return a2.B;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(int a2, int a3, int a4) {
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a2) {
    }

    public /* synthetic */ oa() {
        oa a2;
        oa oa2 = a2;
        oa2.B = 0;
        oa2.a = 0;
    }

    @Override
    public /* synthetic */ int H() {
        oa a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(BufferedImage a22) {
        oa a3;
        BufferedImage bufferedImage = a3.e = a22;
        int a22 = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        a3.ALLATORIxDEMO(a22, n2);
    }

    @Override
    public /* synthetic */ void H() {
        oa a2;
        a2.H.d();
    }

    @Override
    public /* synthetic */ File ALLATORIxDEMO(String a2) {
        return null;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(boolean a2) {
        oa a3;
        SwingUtilities.invokeLater(() -> {
            oa a3;
            if (a2) {
                a3.H.I();
                return;
            }
            a3.H.E();
        });
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(int a2, int a4, int a5, boolean a6) {
        oa oa2;
        oa a7;
        String string = a2 = a6 ? "Mouse pressed" : "Mouse released";
        if (a5 == 1) {
            oa2 = a7;
            a7.B = 1024;
        } else if (a5 == 2) {
            oa2 = a7;
            a7.B = 2048;
        } else if (a5 == 3) {
            oa2 = a7;
            a7.B = 4096;
        } else {
            oa2 = a7;
            a7.B = 0;
        }
        oa2.ALLATORIxDEMO(a3 -> {
            oa a4;
            a3.ALLATORIxDEMO(a2, a4);
        });
    }

    private /* synthetic */ OA ALLATORIxDEMO(int a32, int a42) {
        oa a5;
        OA a32 = new OA(a32, a42);
        Oa a42 = new Oa(a5);
        if (a5.g != null) {
            a32.ALLATORIxDEMO(a5.g);
        }
        OA oA = a32;
        oa oa2 = a5;
        OA oA2 = a32;
        a32.ALLATORIxDEMO(a5.E);
        oA2.ALLATORIxDEMO(dA.K);
        oA2.H(960, 540);
        oA2.ALLATORIxDEMO(Color.BLACK);
        a32.H(oa2);
        oA.H(oa2);
        oA.H(a42);
        a32.H(a2 -> {
            oa a3;
            Graphics2D graphics2D = a2;
            Ua.H(graphics2D);
            graphics2D.drawImage((Image)a3.e, 0, 0, null);
        });
        return a32;
    }

    private /* synthetic */ void ALLATORIxDEMO(BufferedImage a2, int a3, int a4) {
        oa a5;
        Graphics2D graphics2D;
        Graphics2D graphics2D2 = graphics2D = a5.e.createGraphics();
        Ua.H(graphics2D2);
        graphics2D2.drawImage((Image)a2, a3, a4, null);
        graphics2D.dispose();
    }

    @Override
    public /* synthetic */ void H(int a2, int a3, int a4) {
        oa a5;
        oa oa2 = a5;
        oa2.k = a2;
        oa2.K = a3;
    }
}

