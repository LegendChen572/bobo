/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.ta;
import FuckingHackerToby.za;
import java.io.File;

public final class da
extends N {
    private /* synthetic */ String ALLATORIxDEMO;
    private /* synthetic */ String a;
    private /* synthetic */ byte[] d;

    @Override
    public /* synthetic */ void D(ta a2) {
        da a3;
        da da2 = a3;
        za.ALLATORIxDEMO(da2.ALLATORIxDEMO, da2.d);
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        da a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void c(ta a2) {
        da a3;
        a2.ALLATORIxDEMO(a3.a);
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        da a3;
        a2.ALLATORIxDEMO(a3.d.length);
        ta ta2 = a2;
        ta2.H(a3.d);
        ta2.ALLATORIxDEMO(a3.ALLATORIxDEMO);
    }

    public /* synthetic */ da() {
        a2("");
        da a2;
        a2.a = (String)true;
    }

    public /* synthetic */ da(String a2) {
        da a3;
        da da2 = a3;
        da2.a = a2;
        da2.a = (String)false;
    }

    @Override
    public /* synthetic */ void d(ta a2) {
        a.a = a2.H();
    }

    @Override
    public /* synthetic */ void E(ta a2) {
        da a3;
        File file = new File(a3.a);
        if (file.exists() && !file.isDirectory()) {
            a3.ALLATORIxDEMO = file.getName();
            a3.d = za.ALLATORIxDEMO(a3.a);
            a3.a = (String)true;
            a2.H(a3);
        }
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        da a3;
        ta ta2 = a2;
        int n2 = ta2.D();
        da da2 = a3;
        da2.d = new byte[n2];
        ta2.ALLATORIxDEMO(a3.d);
        da2.ALLATORIxDEMO = a2.H();
    }
}

