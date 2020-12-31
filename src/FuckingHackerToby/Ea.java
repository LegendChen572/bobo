/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.Ua;
import FuckingHackerToby.Z;
import FuckingHackerToby.s;
import FuckingHackerToby.ta;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.stream.Stream;

public final class Ea
extends N {
    private /* synthetic */ int C;
    private /* synthetic */ int H;
    private static final /* synthetic */ byte k = 1;
    private /* synthetic */ byte e;
    private static /* synthetic */ BufferedImage E;
    private static final /* synthetic */ byte B = 1;
    private static final /* synthetic */ byte g = 0;
    private /* synthetic */ s[] F;
    private static final /* synthetic */ byte K = 0;

    @Override
    public /* synthetic */ void E(ta a2) {
        Ea ea2;
        Ea a3;
        BufferedImage bufferedImage = Z.ALLATORIxDEMO();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        if (a3.e == 1 || E == null) {
            s s2 = new s(0, 0, bufferedImage);
            a3.F = new s[1];
            Ea ea3 = a3;
            ea2 = ea3;
            ea3.F[0] = s2;
        } else if (a3.e == 0) {
            ea2 = a3;
            a3.F = Z.ALLATORIxDEMO(E, bufferedImage);
        } else {
            a3.F = new s[0];
            ea2 = a3;
        }
        ea2.a = 1;
        Dimension dimension2 = dimension;
        a3.C = dimension2.width;
        a3.H = dimension2.height;
        E = bufferedImage;
        a2.H(a3);
    }

    public /* synthetic */ Ea() {
        a2(false);
        Ea a2;
    }

    @Override
    public /* synthetic */ void c(ta a2) {
        Ea a3;
        a2.ALLATORIxDEMO(a3.e);
    }

    @Override
    public /* synthetic */ void d(ta a2) {
        a.e = a2.ALLATORIxDEMO();
    }

    public /* synthetic */ int H() {
        Ea a2;
        return a2.C;
    }

    public /* synthetic */ int ALLATORIxDEMO() {
        Ea a2;
        return a2.H;
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        Ea a3;
        ArrayList<s> arrayList = new ArrayList<s>();
        ta ta2 = a2;
        while (ta2.ALLATORIxDEMO() == 1) {
            ta ta3 = a2;
            ta2 = ta3;
            short s2 = ta3.ALLATORIxDEMO();
            short s3 = ta3.ALLATORIxDEMO();
            Object object = new byte[ta3.D()];
            ta3.ALLATORIxDEMO((byte[])object);
            object = Ua.ALLATORIxDEMO(object);
            s s4 = new s(s2, s3, (BufferedImage)object);
            arrayList.add(s4);
        }
        a3.F = (s[])arrayList.stream().toArray(s[]::new);
        Ea ea2 = a3;
        ea2.C = a2.D();
        ea2.H = a2.D();
    }

    @Override
    public /* synthetic */ void D(ta a2) {
    }

    public /* synthetic */ Ea(boolean a2) {
        Ea a3;
        Ea ea2 = a3;
        ea2.a = 0;
        ea2.e = a2 ? (byte)1 : 0;
    }

    public /* synthetic */ s[] ALLATORIxDEMO() {
        Ea a2;
        return a2.F;
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        Ea a4;
        Stream.of(a4.F).forEach(a3 -> {
            byte[] arrby = Ua.ALLATORIxDEMO(a3.d, 0.0f);
            ta ta2 = a2;
            s s2 = a3;
            a2.ALLATORIxDEMO((byte)1);
            a2.ALLATORIxDEMO((short)s2.K);
            ta2.ALLATORIxDEMO((short)s2.a);
            ta2.ALLATORIxDEMO(arrby.length);
            a2.H(arrby);
        });
        ta ta2 = a2;
        a2.ALLATORIxDEMO((byte)0);
        ta2.ALLATORIxDEMO(a4.C);
        ta2.ALLATORIxDEMO(a4.H);
    }
}

