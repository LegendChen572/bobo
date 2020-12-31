/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.C;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public final class ra
implements C {
    private static final /* synthetic */ int a = 30;
    private static final /* synthetic */ int d = 3;
    private /* synthetic */ JLabel k;
    private static final /* synthetic */ int ALLATORIxDEMO = 3000;
    private /* synthetic */ JDialog B;
    private static final /* synthetic */ EmptyBorder K;

    public static /* synthetic */ {
        K = new EmptyBorder(10, 50, 10, 50);
    }

    public /* synthetic */ ra() {
        a2("");
        ra a2;
    }

    public /* synthetic */ ra(String a2, Icon a3) {
        ra a4;
        ra ra2 = a4;
        ra ra3 = a4;
        ra2.B = new JDialog();
        ra3.k = new JLabel(a2);
        ra2.k.setIcon(a3);
        ra2.k.setHorizontalAlignment(0);
        ra2.k.setVerticalAlignment(0);
        ra2.k.setBorder(K);
        ra2.k.setIconTextGap(30);
        ra2.B.setUndecorated(true);
        ra2.B.setContentPane(a4.k);
        ra2.B.pack();
        ra2.B.setLocation(-a4.B.getWidth(), 0);
        ra2.B.setAlwaysOnTop(true);
    }

    public /* synthetic */ ra(String a2) {
        a3(a2, null);
        ra a3;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO() {
        ra a2;
        if (a2.B.isVisible() || !a2.B.isDisplayable()) {
            return;
        }
        Runnable runnable = () -> {
            int n2;
            int n3;
            ra a2;
            ra ra2 = a2;
            while (ra2.B.getX() < 0) {
                ra ra3 = a2;
                ra2 = ra3;
                n3 = ra3.B.getX() + 1;
                n2 = ra3.B.getY();
                ra3.B.setLocation(n3, n2);
                Thread.sleep(3L);
            }
            try {
                Thread.sleep(3000L);
                while (a2.B.getX() > -a2.B.getWidth()) {
                    ra ra4 = a2;
                    n3 = ra4.B.getX() - 1;
                    n2 = ra4.B.getY();
                    ra4.B.setLocation(n3, n2);
                    Thread.sleep(3L);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            ra ra5 = a2;
            ra5.B.setVisible(false);
            ra5.B.dispose();
        };
        Thread thread = new Thread(runnable);
        a2.B.setVisible(true);
        thread.setDaemon(true);
        thread.start();
    }
}

