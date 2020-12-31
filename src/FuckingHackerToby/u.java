/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import client.messages.CommandProcessorUtil;
import java.awt.AWTException;
import java.awt.Robot;

public final class u
implements j {
    public static final /* synthetic */ byte ALLATORIxDEMO = 3;
    private /* synthetic */ int E;
    private /* synthetic */ byte k;
    private /* synthetic */ int B;
    public static final /* synthetic */ byte K = 0;
    private /* synthetic */ int g;
    public static final /* synthetic */ byte a = 1;
    public static final /* synthetic */ byte d = 2;

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a22) {
        u a3;
        block8: {
            block7: {
                a22 = new Robot();
                if (a3.k != 0) break block7;
                Object object = a22;
                u u2 = a3;
                ((Robot)object).mouseMove(u2.E, u2.g);
                ((Robot)object).mousePress(a3.B);
                return;
            }
            if (a3.k != 1) break block8;
            Object object = a22;
            u u3 = a3;
            ((Robot)object).mouseMove(u3.E, u3.g);
            ((Robot)object).mouseRelease(a3.B);
            return;
        }
        try {
            if (a3.k == 2) {
                Object object = a22;
                u u4 = a3;
                ((Robot)a22).mouseMove(a3.E, u4.g);
                ((Robot)object).mousePress(u4.B);
                ((Robot)object).mousePress(a3.B);
                return;
            }
            if (a3.k == 3) {
                u u5 = a3;
                ((Robot)a22).mouseMove(u5.E, u5.g);
                return;
            }
        }
        catch (IllegalArgumentException a22) {
            System.err.println(CommandProcessorUtil.ALLATORIxDEMO("v\t\u0018\u0010Y\nQ\u0002\u0018\u000bW\u0013K\u0003\u0018\u0004M\u0012L\tV"));
            return;
        }
        catch (AWTException a22) {
            a22.printStackTrace();
        }
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        u a3;
        u u2 = a3;
        ta ta2 = a2;
        a3.E = a2.D();
        a3.g = ta2.D();
        u2.B = ta2.D();
        u2.k = a2.ALLATORIxDEMO();
    }

    public /* synthetic */ u(int a2, int a3, int a4, byte a5) {
        u a6;
        u u2 = a6;
        u u3 = a6;
        u3.E = a2;
        u3.g = a3;
        u2.B = a4;
        u2.k = a5;
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        u a3;
        ta ta2 = a2;
        u u2 = a3;
        a2.ALLATORIxDEMO(a3.E);
        a2.ALLATORIxDEMO(u2.g);
        ta2.ALLATORIxDEMO(u2.B);
        ta2.ALLATORIxDEMO(a3.k);
    }

    public /* synthetic */ u() {
        a2(0, 0, 0, 2);
        u a2;
    }
}

