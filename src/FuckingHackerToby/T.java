/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Ba;
import FuckingHackerToby.Ca;
import FuckingHackerToby.Da;
import FuckingHackerToby.Ea;
import FuckingHackerToby.Ga;
import FuckingHackerToby.Ia;
import FuckingHackerToby.Ja;
import FuckingHackerToby.Ka;
import FuckingHackerToby.La;
import FuckingHackerToby.O;
import FuckingHackerToby.P;
import FuckingHackerToby.Q;
import FuckingHackerToby.R;
import FuckingHackerToby.S;
import FuckingHackerToby.V;
import FuckingHackerToby.W;
import FuckingHackerToby.Y;
import FuckingHackerToby.ca;
import FuckingHackerToby.da;
import FuckingHackerToby.fa;
import FuckingHackerToby.ga;
import FuckingHackerToby.ha;
import FuckingHackerToby.j;
import FuckingHackerToby.la;
import FuckingHackerToby.ma;
import FuckingHackerToby.p;
import FuckingHackerToby.q;
import FuckingHackerToby.t;
import FuckingHackerToby.u;
import FuckingHackerToby.w;
import FuckingHackerToby.y;
import handling.world.exped.MapleExpedition;
import server.maps.MapleNodes;

public final class T
extends Enum<T> {
    public static final /* synthetic */ /* enum */ T l;
    public static final /* synthetic */ /* enum */ T J;
    public static final /* synthetic */ /* enum */ T i;
    public static final /* synthetic */ /* enum */ T H;
    public static final /* synthetic */ /* enum */ T D;
    public final /* synthetic */ byte a;
    public static final /* synthetic */ /* enum */ T G;
    public static final /* synthetic */ /* enum */ T P;
    public static final /* synthetic */ /* enum */ T o;
    public static final /* synthetic */ /* enum */ T A;
    public static final /* synthetic */ /* enum */ T t;
    public static final /* synthetic */ /* enum */ T C;
    public static final /* synthetic */ /* enum */ T K;
    public static final /* synthetic */ /* enum */ T j;
    public static final /* synthetic */ /* enum */ T g;
    public static final /* synthetic */ /* enum */ T M;
    public static final /* synthetic */ /* enum */ T h;
    public static final /* synthetic */ /* enum */ T f;
    public static final /* synthetic */ /* enum */ T w;
    public static final /* synthetic */ /* enum */ T b;
    public static final /* synthetic */ /* enum */ T F;
    public static final /* synthetic */ /* enum */ T Q;
    public static final /* synthetic */ /* enum */ T k;
    public static final /* synthetic */ /* enum */ T e;
    public final /* synthetic */ Class<? extends j> d;
    public static final /* synthetic */ /* enum */ T E;
    public static final /* synthetic */ /* enum */ T B;
    private static final /* synthetic */ T[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ T Z;
    public static final /* synthetic */ /* enum */ T L;
    public static final /* synthetic */ /* enum */ T c;
    public static final /* synthetic */ /* enum */ T I;
    public static final /* synthetic */ /* enum */ T m;

    public static /* synthetic */ Class<? extends j> ALLATORIxDEMO(byte a2) {
        int n2;
        T[] arrt = T.values();
        int n3 = arrt.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            T t2 = arrt[n2];
            if (t2.a == a2) {
                return t2.d;
            }
            n4 = ++n2;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ T(int n22, Class<? extends j> n22) {
        a4((String)var1_-1, (int)var2_-1, (byte)a3, (Class)a2);
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        T a4;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ T(byte by2, Class<? extends j> by2) {
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        T a4;
        T t2 = a4;
        t2.a = a3;
        t2.d = a2;
    }

    public static /* synthetic */ byte ALLATORIxDEMO(Class<? extends j> a2) {
        int n2;
        T[] arrt = T.values();
        int n3 = arrt.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            T t2 = arrt[n2];
            if (t2.d == a2) {
                return t2.a;
            }
            n4 = ++n2;
        }
        return 0;
    }

    public static /* synthetic */ byte ALLATORIxDEMO(j a2) {
        return T.ALLATORIxDEMO(a2.getClass());
    }

    public static /* synthetic */ T[] values() {
        return (T[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ T valueOf(String a2) {
        return Enum.valueOf(T.class, a2);
    }

    public static /* synthetic */ {
        Q = new T(MapleNodes.ALLATORIxDEMO("|A|[|"), 0, 1, Y.class);
        o = new T(MapleExpedition.ALLATORIxDEMO("vEwC`HvNjR"), 1, 2, p.class);
        Z = new T(MapleNodes.ALLATORIxDEMO("gKuQiXi@x"), 2, 3, Ba.class);
        t = new T(MapleExpedition.ALLATORIxDEMO("cT`C"), 3, 4, Da.class);
        P = new T(MapleNodes.ALLATORIxDEMO("e@jA~CmZeAb"), 4, 5, Ka.class);
        w = new T(MapleExpedition.ALLATORIxDEMO("EjKhGkB"), 5, 6, Ja.class);
        G = new T(MapleNodes.ALLATORIxDEMO("hK\u007fExA|"), 6, 7, Ea.class);
        b = new T(MapleExpedition.ALLATORIxDEMO("EiOuDjGwB"), 7, 8, ca.class);
        c = new T(MapleNodes.ALLATORIxDEMO("HeBi"), 8, 9, La.class);
        l = new T(MapleExpedition.ALLATORIxDEMO("aIrHiIdB"), 9, 10, da.class);
        m = new T(MapleNodes.ALLATORIxDEMO("[|BcOh"), 10, 11, P.class);
        A = new T(MapleExpedition.ALLATORIxDEMO("C}CfSqC"), 11, 12, ma.class);
        f = new T(MapleNodes.ALLATORIxDEMO("hG~KoZc\\u"), 12, 13, y.class);
        h = new T(MapleExpedition.ALLATORIxDEMO("aCiCqC"), 13, 14, Ca.class);
        D = new T(MapleNodes.ALLATORIxDEMO("aAy]iQiXi@x"), 14, 15, u.class);
        L = new T(MapleExpedition.ALLATORIxDEMO("PjOfC"), 15, 16, R.class);
        j = new T(MapleNodes.ALLATORIxDEMO("{Kn]eZi"), 16, 17, t.class);
        i = new T(MapleExpedition.ALLATORIxDEMO("GpBlI"), 17, 18, Ga.class);
        J = new T(MapleNodes.ALLATORIxDEMO("^e@k"), 18, 19, W.class);
        M = new T(MapleExpedition.ALLATORIxDEMO("aIrHiIdBzSwJ"), 19, 20, ga.class);
        I = new T(MapleNodes.ALLATORIxDEMO("MdOx"), 20, 21, Ia.class);
        F = new T(MapleExpedition.ALLATORIxDEMO("cOiCzOk@jThGqOjH"), 21, 22, ha.class);
        C = new T(MapleNodes.ALLATORIxDEMO("OxZmMg"), 22, 23, fa.class);
        H = new T(MapleExpedition.ALLATORIxDEMO("fIhVpR`TzOk@jThGqOjH"), 23, 24, la.class);
        e = new T(MapleNodes.ALLATORIxDEMO("y@e@\u007fZmB`"), 24, 25, q.class);
        E = new T(MapleExpedition.ALLATORIxDEMO("nC|JjA"), 25, 26, S.class);
        g = new T(MapleNodes.ALLATORIxDEMO("]d[xJcYb"), 26, 27, Q.class);
        B = new T(MapleExpedition.ALLATORIxDEMO("T`UqGwR"), 27, 28, V.class);
        k = new T("ROOTS", 28, 29, O.class);
        K = new T(MapleNodes.ALLATORIxDEMO("|O\u007f]{A~J\u007f"), 29, 30, w.class);
        T[] arrt = new T[30];
        arrt[0] = Q;
        arrt[1] = o;
        arrt[2] = Z;
        arrt[3] = t;
        arrt[4] = P;
        arrt[5] = w;
        arrt[6] = G;
        arrt[7] = b;
        arrt[8] = c;
        arrt[9] = l;
        arrt[10] = m;
        arrt[11] = A;
        arrt[12] = f;
        arrt[13] = h;
        arrt[14] = D;
        arrt[15] = L;
        arrt[16] = j;
        arrt[17] = i;
        arrt[18] = J;
        arrt[19] = M;
        arrt[20] = I;
        arrt[21] = F;
        arrt[22] = C;
        arrt[23] = H;
        arrt[24] = e;
        arrt[25] = E;
        arrt[26] = g;
        arrt[27] = B;
        arrt[28] = k;
        arrt[29] = K;
        ALLATORIxDEMO = arrt;
    }
}

