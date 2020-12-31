/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.I;
import FuckingHackerToby.Pa;
import java.util.ArrayList;

public final class va
implements I {
    private /* synthetic */ ArrayList<Pa> ALLATORIxDEMO;

    @Override
    public /* synthetic */ void ALLATORIxDEMO(double a2) {
        int n2;
        va a3;
        int n3 = a3.ALLATORIxDEMO.size();
        int n4 = n2 = 0;
        while (n4 < n3) {
            Pa pa2 = a3.ALLATORIxDEMO.get(n2);
            pa2.ALLATORIxDEMO(a2);
            if (pa2.ALLATORIxDEMO()) {
                pa2.ALLATORIxDEMO();
            }
            n4 = ++n2;
        }
        a3.ALLATORIxDEMO.removeIf(Pa::ALLATORIxDEMO);
    }

    public /* synthetic */ va() {
        va a2;
        va va2 = a2;
        va2.ALLATORIxDEMO = new ArrayList();
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        va a2;
        return !a2.ALLATORIxDEMO.isEmpty();
    }

    public /* synthetic */ void ALLATORIxDEMO() {
        va a2;
        a2.ALLATORIxDEMO.clear();
    }

    public /* synthetic */ void ALLATORIxDEMO(Pa a2) {
        va a3;
        a3.ALLATORIxDEMO.remove(a2);
    }

    public /* synthetic */ void H(Pa a2) {
        va a3;
        a3.ALLATORIxDEMO.add(a2);
    }
}

