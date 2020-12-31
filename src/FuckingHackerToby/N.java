/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.j;
import FuckingHackerToby.ta;

public abstract class N
implements j {
    public static final /* synthetic */ byte d = 0;
    public static final /* synthetic */ byte ALLATORIxDEMO = 1;
    public /* synthetic */ byte a;

    public abstract /* synthetic */ void c(ta var1);

    public abstract /* synthetic */ void E(ta var1);

    public abstract /* synthetic */ void b(ta var1);

    @Override
    public final /* synthetic */ void H(ta a2) {
        N a3;
        a3.a = a2.ALLATORIxDEMO();
        if (a3.a == 0) {
            a3.d(a2);
            return;
        }
        if (a3.a == 1) {
            a3.I(a2);
        }
    }

    public abstract /* synthetic */ void D(ta var1);

    public final /* synthetic */ byte ALLATORIxDEMO() {
        N a2;
        return a2.a;
    }

    public /* synthetic */ N(byte a2) {
        N a3;
        a3.a = a2;
    }

    public abstract /* synthetic */ void I(ta var1);

    public /* synthetic */ N() {
        a2(0);
        N a2;
    }

    public abstract /* synthetic */ void d(ta var1);

    @Override
    public final /* synthetic */ void l(ta a2) {
        N a3;
        N n2 = a3;
        a2.ALLATORIxDEMO(n2.a);
        if (n2.a == 0) {
            a3.c(a2);
            return;
        }
        if (a3.a == 1) {
            a3.b(a2);
        }
    }

    @Override
    public final /* synthetic */ void ALLATORIxDEMO(ta a2) {
        N a3;
        if (a3.a == 0) {
            a3.E(a2);
            return;
        }
        if (a3.a == 1) {
            a3.D(a2);
        }
    }
}

