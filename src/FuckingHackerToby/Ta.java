/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.l;
import java.util.Random;

public final class Ta
implements l {
    private /* synthetic */ Random ALLATORIxDEMO;

    public /* synthetic */ Ta(long a2) {
        Ta a3;
        Ta ta2 = a3;
        ta2();
        ta2.ALLATORIxDEMO.setSeed(a2);
    }

    public /* synthetic */ void ALLATORIxDEMO(long a2) {
        Ta a3;
        a3.ALLATORIxDEMO.setSeed(a2);
    }

    @Override
    public /* synthetic */ double ALLATORIxDEMO(double a2, double a3) {
        Ta a4;
        return a4.ALLATORIxDEMO.nextDouble();
    }

    public /* synthetic */ Ta() {
        Ta a2;
        Ta ta2 = a2;
        ta2.ALLATORIxDEMO = new Random();
    }
}

