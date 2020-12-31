/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.H;
import FuckingHackerToby.a;
import FuckingHackerToby.ka;
import client.MapleCoreAura;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class Fa
extends ka<a>
implements H {
    public /* synthetic */ JFileChooser ALLATORIxDEMO;
    public /* synthetic */ JFrame d;

    private /* synthetic */ int ALLATORIxDEMO(int a2, String a3, int a4, String ... a5) {
        Fa a6;
        return JOptionPane.showOptionDialog(a6.d, a3, null, a4, a2, null, a5, null);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO() {
        Fa a2;
        SwingUtilities.invokeLater(() -> {
            Fa a2;
            Fa fa2 = a2;
            fa2.d.setVisible(false);
            fa2.d.dispose();
        });
    }

    @Override
    public /* synthetic */ void D(String a2) {
        Fa a3;
        a3.d.setTitle(a2);
    }

    @Override
    public /* synthetic */ int ALLATORIxDEMO(String a2, String a3, String a4, String a5) {
        Fa a6;
        if (!a6.ALLATORIxDEMO()) {
            return -1;
        }
        String[] arrstring = new String[3];
        arrstring[0] = a3;
        arrstring[1] = a4;
        arrstring[2] = a5;
        return a6.ALLATORIxDEMO(3, a2, 1, arrstring);
    }

    @Override
    public /* synthetic */ void H() {
    }

    @Override
    public /* synthetic */ int ALLATORIxDEMO(String a2, String a3, String a4) {
        Fa a5;
        if (!a5.ALLATORIxDEMO()) {
            return -1;
        }
        String[] arrstring = new String[2];
        arrstring[0] = a3;
        arrstring[1] = a4;
        return a5.ALLATORIxDEMO(2, a2, 0, arrstring);
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, String a3) {
        Fa a4;
        JOptionPane.showMessageDialog(a4.d, a3, null, a2, null);
    }

    @Override
    public /* synthetic */ void H(String a2) {
        Fa a3;
        if (!a3.ALLATORIxDEMO()) {
            return;
        }
        a3.ALLATORIxDEMO(0, a2);
    }

    public /* synthetic */ Fa() {
        Fa a2;
        Fa fa2 = a2;
        a2.d = new JFrame();
        fa2.ALLATORIxDEMO = new JFileChooser(MapleCoreAura.ALLATORIxDEMO("\""));
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(boolean a2) {
        Fa a3;
        SwingUtilities.invokeLater(() -> {
            Fa a3;
            a3.d.setVisible(a2);
        });
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(List<? extends Image> a2) {
        Fa a3;
        a3.d.setIconImages(a2);
    }

    @Override
    public /* synthetic */ String ALLATORIxDEMO(String a2) {
        Fa a3;
        if (!a3.ALLATORIxDEMO()) {
            return null;
        }
        return JOptionPane.showInputDialog(a3.d, (Object)a2);
    }

    @Override
    public /* synthetic */ void l(String a2) {
        Fa a3;
        if (!a3.ALLATORIxDEMO()) {
            return;
        }
        a3.ALLATORIxDEMO(2, a2);
    }

    @Override
    public /* synthetic */ boolean ALLATORIxDEMO() {
        Fa a2;
        return a2.d.isVisible();
    }

    @Override
    public /* synthetic */ File ALLATORIxDEMO() {
        Fa a2;
        Fa fa2 = a2;
        if (fa2.ALLATORIxDEMO.showSaveDialog(fa2.d) == 0) {
            return a2.ALLATORIxDEMO.getSelectedFile();
        }
        return null;
    }

    @Override
    public /* synthetic */ File H(String a2) {
        Fa fa2;
        Fa a3;
        FileNameExtensionFilter fileNameExtensionFilter;
        if (a2 != null) {
            String[] arrstring = new String[1];
            arrstring[0] = a2;
            fileNameExtensionFilter = new FileNameExtensionFilter("*." + a2, arrstring);
            fa2 = a3;
        } else {
            fileNameExtensionFilter = null;
            fa2 = a3;
        }
        fa2.ALLATORIxDEMO.setFileFilter(fileNameExtensionFilter);
        Fa fa3 = a3;
        if (fa3.ALLATORIxDEMO.showOpenDialog(fa3.d) == 0) {
            return a3.ALLATORIxDEMO.getSelectedFile();
        }
        return null;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a2) {
        Fa a3;
        if (!a3.ALLATORIxDEMO()) {
            return;
        }
        a3.ALLATORIxDEMO(1, a2);
    }

    @Override
    public /* synthetic */ File ALLATORIxDEMO(String a2) {
        Fa a3;
        File file = a3.ALLATORIxDEMO();
        if (file == null) {
            return null;
        }
        String string = file.toString().toLowerCase();
        if (!string.endsWith((String)(a2 = "." + ((String)a2).toLowerCase()))) {
            file = new File(file + (String)a2);
        }
        return file;
    }
}

