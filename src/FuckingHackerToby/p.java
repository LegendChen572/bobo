/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.OA;
import FuckingHackerToby.Ua;
import FuckingHackerToby.Z;
import FuckingHackerToby.dA;
import FuckingHackerToby.ta;
import java.awt.Image;
import java.awt.image.BufferedImage;
import tools.data.LittleEndianAccessor;

public final class p
extends N {
    private static final /* synthetic */ BufferedImage a;
    private static final /* synthetic */ int d = 800;
    private static final /* synthetic */ int ALLATORIxDEMO = 600;
    private /* synthetic */ BufferedImage K;

    @Override
    public /* synthetic */ void E(ta a2) {
        p a3;
        a3.a = (BufferedImage)true;
        a3.K = Z.H();
        if (a3.K == null) {
            a3.K = a;
        }
        a2.H(a3);
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        p a3;
        byte[] arrby = Ua.ALLATORIxDEMO(a3.K, LittleEndianAccessor.ALLATORIxDEMO("}Zj"));
        a2.ALLATORIxDEMO(arrby.length);
        a2.H(arrby);
    }

    @Override
    public /* synthetic */ void D(ta a2222) {
        p a3;
        p p2 = a3;
        int a2222 = p2.K.getWidth();
        int n2 = p2.K.getHeight();
        OA a2222 = new OA(a2222, n2);
        a2222.H(a2 -> {
            p a3;
            a2.drawImage((Image)a3.K, 0, 0, null);
        });
        OA oA = a2222;
        OA oA2 = a2222;
        oA2.ALLATORIxDEMO(dA.K);
        oA.H(800, 600);
        oA2.I();
        oA.d();
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        p a3;
        ta ta2 = a2;
        byte[] arrby = new byte[ta2.D()];
        a2 = arrby;
        ta2.ALLATORIxDEMO(arrby);
        a3.K = Ua.ALLATORIxDEMO((byte[])a2);
        if (a3.K == null) {
            a3.K = a;
        }
    }

    public static /* synthetic */ {
        a = new BufferedImage(10, 10, 1);
    }

    public /* synthetic */ p() {
        p a2;
        a2.a = (BufferedImage)false;
        a2.K = a;
    }

    @Override
    public /* synthetic */ void c(ta a2) {
    }

    @Override
    public /* synthetic */ void d(ta a2) {
    }

    public /* synthetic */ BufferedImage ALLATORIxDEMO() {
        p a2;
        return a2.K;
    }
}

