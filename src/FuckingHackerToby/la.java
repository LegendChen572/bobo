/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.ta;
import handling.auction.handler.MTSOperation;
import java.net.InetAddress;
import java.net.UnknownHostException;
import server.buffs.AbstractBuffClass;

public class la
extends N {
    private /* synthetic */ String k;
    private /* synthetic */ String a;
    private /* synthetic */ String g;
    private /* synthetic */ int d;
    private /* synthetic */ long ALLATORIxDEMO;
    private /* synthetic */ String B;
    private /* synthetic */ String K;

    @Override
    public /* synthetic */ void I(ta a2) {
        la a3;
        la la2 = a3;
        ta ta2 = a2;
        la la3 = a3;
        ta ta3 = a2;
        a3.g = a2.H();
        a3.B = ta3.H();
        la3.k = ta3.H();
        la3.K = a2.H();
        a3.a = ta2.H();
        la2.d = ta2.D();
        la2.ALLATORIxDEMO = a2.ALLATORIxDEMO();
    }

    @Override
    public /* synthetic */ void c(ta a2) {
    }

    @Override
    public /* synthetic */ void d(ta a2) {
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        la a2;
        return a2.a;
    }

    public /* synthetic */ long ALLATORIxDEMO() {
        la a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        la a3;
        ta ta2 = a2;
        la la2 = a3;
        ta ta3 = a2;
        la la3 = a3;
        a2.ALLATORIxDEMO(a3.g);
        a2.ALLATORIxDEMO(la3.B);
        ta3.ALLATORIxDEMO(la3.k);
        ta3.ALLATORIxDEMO(a3.K);
        a2.ALLATORIxDEMO(la2.a);
        ta2.ALLATORIxDEMO(la2.d);
        ta2.ALLATORIxDEMO(a3.ALLATORIxDEMO);
    }

    public /* synthetic */ int ALLATORIxDEMO() {
        la a2;
        return a2.d;
    }

    public /* synthetic */ la() {
        la a2;
    }

    public /* synthetic */ String E() {
        la a2;
        return a2.g;
    }

    @Override
    public /* synthetic */ void D(ta a2) {
    }

    public /* synthetic */ String D() {
        la a2;
        return a2.B;
    }

    public /* synthetic */ String H() {
        la a2;
        return a2.K;
    }

    public /* synthetic */ String l() {
        la a2;
        return a2.k;
    }

    @Override
    public /* synthetic */ void E(ta a2) {
        ta ta2;
        la a3;
        la la2 = a3;
        la la3 = a3;
        la la4 = a3;
        a3.a = (String)true;
        la4.g = System.getProperty(AbstractBuffClass.ALLATORIxDEMO("kf{g0{\u007fx{"));
        la4.k = System.getProperty(MTSOperation.ALLATORIxDEMO("L?\r\"B!F"));
        la3.K = System.getProperty(AbstractBuffClass.ALLATORIxDEMO("zm;hplfwzp"));
        la2.a = System.getProperty(MTSOperation.ALLATORIxDEMO("L?\r-Q/K"));
        la3.d = Runtime.getRuntime().availableProcessors();
        la2.ALLATORIxDEMO = Runtime.getRuntime().totalMemory();
        try {
            a3.B = InetAddress.getLocalHost().getHostName();
            ta2 = a2;
        }
        catch (UnknownHostException unknownHostException) {
            ta2 = a2;
            a3.B = "";
            unknownHostException.printStackTrace();
        }
        ta2.H(a3);
    }
}

