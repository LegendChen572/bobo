/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import java.awt.AWTException;
import java.awt.Robot;
import tools.JsonMapConverter;

public final class Ba
implements j {
    private /* synthetic */ byte K;
    public static final /* synthetic */ byte a = 0;
    public static final /* synthetic */ byte d = 1;
    public static final /* synthetic */ byte ALLATORIxDEMO = 2;
    private /* synthetic */ int k;

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a22) {
        Ba a3;
        block7: {
            block6: {
                a22 = new Robot();
                if (a3.K != 0) break block6;
                ((Robot)a22).keyPress(a3.k);
                return;
            }
            if (a3.K != 1) break block7;
            ((Robot)a22).keyRelease(a3.k);
            return;
        }
        try {
            if (a3.K == 2) {
                Object object = a22;
                ((Robot)object).keyPress(a3.k);
                ((Robot)object).keyRelease(a3.k);
                return;
            }
        }
        catch (IllegalArgumentException a22) {
            System.err.println(JsonMapConverter.ALLATORIxDEMO(";kUr\u0014h\u001c`Uo\u0010}Ug\u001a`\u0010"));
            return;
        }
        catch (AWTException a22) {
            a22.printStackTrace();
        }
    }

    public /* synthetic */ Ba(int a2, byte a3) {
        Ba a4;
        Ba ba2 = a4;
        ba2.k = a2;
        ba2.K = a3;
    }

    public /* synthetic */ Ba() {
        a2(0, 2);
        Ba a2;
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        Ba a3;
        ta ta2 = a2;
        ta2.ALLATORIxDEMO(a3.k);
        ta2.ALLATORIxDEMO(a3.K);
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        Ba a3;
        Ba ba2 = a3;
        ba2.k = a2.D();
        ba2.K = a2.ALLATORIxDEMO();
    }
}

