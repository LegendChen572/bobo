/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Ua;
import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import java.awt.Dialog;
import java.awt.Window;
import javax.swing.JOptionPane;

public final class Y
implements j {
    private /* synthetic */ String ALLATORIxDEMO;

    public /* synthetic */ Y() {
        a2("");
        Y a2;
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        Y a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(ta a2) {
        Y a3;
        Object object = a2 = new JOptionPane(a3.ALLATORIxDEMO).createDialog(null);
        Object object2 = a2;
        ((Window)object2).setAlwaysOnTop(true);
        ((Window)object2).setIconImage(Ua.ALLATORIxDEMO);
        ((Dialog)object).setModal(false);
        ((Dialog)object).setVisible(true);
    }

    @Override
    public /* synthetic */ void H(ta a2) {
        a.ALLATORIxDEMO = a2.H();
    }

    public /* synthetic */ Y(String a2) {
        Y a3;
        a3.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ void l(ta a2) {
        Y a3;
        a2.ALLATORIxDEMO(a3.ALLATORIxDEMO);
    }
}

