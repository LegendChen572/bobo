/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.X;
import FuckingHackerToby.ta;
import java.util.ArrayList;

public final class w
extends N {
    private static final /* synthetic */ byte K = 1;
    private static final /* synthetic */ byte B = 1;
    private static final /* synthetic */ byte g = 0;
    private static final /* synthetic */ byte k = 0;
    private /* synthetic */ X[] E;

    @Override
    public /* synthetic */ void b(ta a2) {
        int n2;
        w a3;
        X[] arrx = a3.E;
        int n3 = a3.E.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            X x2 = arrx[n2];
            byte by = X.ALLATORIxDEMO(x2) ? (byte)0 : 1;
            ta ta2 = a2;
            X x3 = x2;
            ta ta3 = a2;
            a2.ALLATORIxDEMO((byte)1);
            ta3.ALLATORIxDEMO(X.D(x2));
            ta3.ALLATORIxDEMO(X.l(x2));
            a2.ALLATORIxDEMO(X.H(x3));
            ta2.ALLATORIxDEMO(X.ALLATORIxDEMO(x3));
            ta2.ALLATORIxDEMO(by);
            n4 = ++n2;
        }
        a2.ALLATORIxDEMO((byte)0);
    }

    public /* synthetic */ X[] ALLATORIxDEMO() {
        w a2;
        return a2.E;
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        w a3;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ta ta2 = a2;
        while (ta2.ALLATORIxDEMO() == 1) {
            ta ta3 = a2;
            String string = ta3.H();
            Object object = ta3.H();
            String string2 = ta3.H();
            String string3 = ta3.H();
            boolean bl = ta3.ALLATORIxDEMO() == 0;
            object = new X(string, (String)object, string2, string3, bl);
            ta2 = a2;
            arrayList.add(object);
        }
        int n2 = arrayList.size();
        a3.E = new X[n2];
        a3.E = arrayList.toArray(a3.E);
    }

    @Override
    public /* synthetic */ void E(ta a2) {
    }

    @Override
    public /* synthetic */ void D(ta a2) {
    }

    public /* synthetic */ w(X ... a2) {
        w a3;
        a3.E = a2;
    }

    @Override
    public /* synthetic */ void d(ta a2) {
    }

    public /* synthetic */ w() {
        w a2;
        a2.E = new X[0];
    }

    @Override
    public /* synthetic */ void c(ta a2) {
    }
}

