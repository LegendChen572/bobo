/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Fc;
import FuckingHackerToby.wC;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class fc {
    private /* synthetic */ String ALLATORIxDEMO;
    private /* synthetic */ wC K;
    private /* synthetic */ PrintStream k;
    private /* synthetic */ LinkedList<Fc> a;
    private /* synthetic */ boolean d;

    private /* synthetic */ void l() {
        fc a2;
        double d2 = a2.K.l();
        fc fc2 = a2;
        Fc fc3 = new Fc(fc2, a2.ALLATORIxDEMO, d2);
        fc2.a.add(fc3);
    }

    public /* synthetic */ fc(PrintStream a2) {
        fc a3;
        a3.k = a2;
        fc fc2 = a3;
        a3.K = new wC();
        fc2.a = new LinkedList();
    }

    public /* synthetic */ fc() {
        a2(System.out);
        fc a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 4;
        int n5 = n3;
        int n6 = 5 << 4 ^ 1 << 1;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ void ALLATORIxDEMO(String a2) {
        fc fc2;
        fc a3;
        if (!a3.d) {
            fc fc3 = a3;
            fc2 = fc3;
            fc3.d = true;
            fc3.K.ALLATORIxDEMO();
        } else {
            fc fc4 = a3;
            fc2 = fc4;
            fc4.l();
        }
        fc2.ALLATORIxDEMO = a2;
    }

    private /* synthetic */ void H() {
        Iterator iterator;
        fc a2;
        fc fc2 = a2;
        double d2 = fc2.K.H();
        Iterator iterator2 = iterator = fc2.a.iterator();
        while (iterator2.hasNext()) {
            Fc fc3 = (Fc)iterator.next();
            iterator2 = iterator;
            a2.k.println(fc3);
        }
        a2.k.println("Total - " + d2);
    }

    public /* synthetic */ void ALLATORIxDEMO() {
        fc a2;
        if (!a2.d) {
            return;
        }
        fc fc2 = a2;
        fc2.l();
        fc2.H();
        a2.d = false;
        a2.ALLATORIxDEMO = null;
        a2.K.ALLATORIxDEMO();
        a2.a.clear();
    }
}

