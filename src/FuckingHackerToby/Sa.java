/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592f\u592f\u8c37
 */
package FuckingHackerToby;

import FuckingHackerToby.Fa;
import FuckingHackerToby.Ya;
import FuckingHackerToby.a;
import FuckingHackerToby.e;
import FuckingHackerToby.i;
import FuckingHackerToby.pa;
import FuckingHackerToby.xa;
import FuckingHackerToby.ya;
import client.messages.commands.player.\u592f\u592f\u8c37;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.function.Consumer;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionListener;
import tools.StringUtil;

public final class Sa
extends Fa
implements i {
    private /* synthetic */ JButton A;
    private /* synthetic */ JMenuBar m;
    private /* synthetic */ JButton h;
    private static final /* synthetic */ CompoundBorder d;
    private static final /* synthetic */ double g = 0.15;
    private static final /* synthetic */ MatteBorder B;
    private /* synthetic */ JButton f;
    private /* synthetic */ JMenuItem M;
    private /* synthetic */ Ya w;
    private static final /* synthetic */ Insets K;
    private static final /* synthetic */ CompoundBorder ALLATORIxDEMO;
    private /* synthetic */ JMenuItem j;
    private /* synthetic */ JSplitPane l;
    private /* synthetic */ Path H;
    private /* synthetic */ JMenuItem i;
    private static final /* synthetic */ int E = 5;
    private /* synthetic */ JMenuItem I;
    private /* synthetic */ JPopupMenu L;
    private static final /* synthetic */ FlowLayout k;
    private /* synthetic */ DefaultListModel<pa> C;
    private static final /* synthetic */ CompoundBorder a;
    private /* synthetic */ DefaultListModel<String> F;
    private /* synthetic */ JList<String> P;
    private static final /* synthetic */ int e = 600;
    private /* synthetic */ JButton D;
    private /* synthetic */ xa b;
    private /* synthetic */ JLabel t;
    private /* synthetic */ JList<pa> G;
    private /* synthetic */ JMenuItem J;
    private /* synthetic */ JScrollPane c;

    @Override
    public /* synthetic */ String E() {
        Sa a2;
        if (a2.G.getSelectedValue() == null) {
            return null;
        }
        String string = a2.G.getSelectedValue().a.replace(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"-"), "/");
        Object object = a2.b();
        if (string.endsWith("/")) {
            object = (String)object + string;
            return object;
        }
        object = (String)object + "/" + string;
        return object;
    }

    public static /* synthetic */ void ALLATORIxDEMO(Sa a2, Consumer a3) {
        a2.ALLATORIxDEMO(a3);
    }

    public /* synthetic */ Sa() {
        Sa a4;
        Sa sa2 = a4;
        Sa sa3 = a4;
        Sa sa4 = a4;
        Sa sa5 = a4;
        a4.t = new JLabel(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"_X_"));
        sa5.P = new JList();
        a4.w = new Ya(FuckingHackerToby.e.N);
        a4.G = new JList();
        a4.b = new xa(FuckingHackerToby.e.s, FuckingHackerToby.e.O);
        a4.c = new JScrollPane(a4.G, 22, 30);
        Sa sa6 = a4;
        a4.l = new JSplitPane(1, sa6.P, sa6.c);
        a4.m = new JMenuBar();
        a4.A = a4.ALLATORIxDEMO("Directory up", FuckingHackerToby.e.Z);
        a4.f = a4.ALLATORIxDEMO("Upload file here", FuckingHackerToby.e.e);
        sa4.h = sa4.ALLATORIxDEMO("Create new directory", FuckingHackerToby.e.L);
        a4.D = sa4.ALLATORIxDEMO("Download file from the internet", FuckingHackerToby.e.i);
        a4.L = new JPopupMenu();
        a4.j = a4.ALLATORIxDEMO("Request content", FuckingHackerToby.e.C);
        a4.i = a4.ALLATORIxDEMO("Download file", FuckingHackerToby.e.H);
        sa3.J = sa3.ALLATORIxDEMO("Execute file", FuckingHackerToby.e.l);
        a4.M = sa3.ALLATORIxDEMO("Delete file", FuckingHackerToby.e.F);
        a4.I = a4.ALLATORIxDEMO("Get file information", FuckingHackerToby.e.w);
        sa2.F = new DefaultListModel();
        sa2.C = new DefaultListModel();
        sa2.H = Paths.get("", new String[0]);
        Sa sa7 = a4;
        Serializable serializable = ((JFrame)((Object)sa7.d)).getContentPane();
        ListSelectionListener listSelectionListener = a3 -> {
            if (a3.getValueIsAdjusting()) {
                Sa a4;
                Sa sa2 = a4;
                sa2.ALLATORIxDEMO(a2 -> {
                    Sa a3;
                    a2.ALLATORIxDEMO("ROOTS", a3);
                });
            }
        };
        ListSelectionListener listSelectionListener2 = a2 -> {
            Sa a3;
            a3.P.clearSelection();
        };
        ya ya2 = new ya(a4);
        Sa sa8 = a4;
        sa8.L.add(sa8.j);
        Sa sa9 = a4;
        sa9.L.add(sa9.i);
        Sa sa10 = a4;
        sa10.L.add(sa10.f);
        Sa sa11 = a4;
        sa11.L.add(sa11.J);
        Sa sa12 = a4;
        sa12.L.add(sa12.M);
        Sa sa13 = a4;
        sa13.L.add(sa13.h);
        Sa sa14 = a4;
        sa14.L.add(sa14.I);
        Sa sa15 = a4;
        sa15.m.setLayout(k);
        sa15.m.setMargin(K);
        sa15.m.add(a4.A);
        Sa sa16 = a4;
        sa16.m.add(sa16.f);
        Sa sa17 = a4;
        sa17.m.add(sa17.h);
        Sa sa18 = a4;
        sa18.m.add(sa18.D);
        Sa sa19 = a4;
        Sa sa20 = a4;
        Sa sa21 = a4;
        sa21.l.setDividerSize(5);
        sa21.l.setResizeWeight(0.15);
        sa21.l.setEnabled(false);
        sa21.c.setBorder(B);
        sa21.G.setSelectionMode(0);
        sa21.G.setModel(a4.C);
        sa21.G.setCellRenderer(a4.b);
        sa21.G.setComponentPopupMenu(a4.L);
        sa21.G.addListSelectionListener(listSelectionListener2);
        sa21.G.addMouseListener(ya2);
        sa21.G.setBorder(ALLATORIxDEMO);
        sa21.P.setCellRenderer(a4.w);
        sa21.P.setSelectionMode(0);
        sa21.P.addListSelectionListener(listSelectionListener);
        sa21.P.setBorder(d);
        sa21.P.setModel(a4.F);
        sa21.t.setBorder(a);
        Container container = serializable;
        container.add((Component)a4.t, StringUtil.ALLATORIxDEMO("\u007fEC^Y"));
        container.add((Component)a4.l, \u592f\u592f\u8c37.ALLATORIxDEMO((String)"5\u0014\u0018\u0005\u0013\u0003"));
        serializable.add(sa20.m, StringUtil.ALLATORIxDEMO("bED^Y"));
        ((JFrame)((Object)sa19.d)).setDefaultCloseOperation(1);
        ((Window)((Object)sa20.d)).pack();
        serializable = ((Component)((Object)sa19.d)).getSize();
        serializable = new Dimension(((Dimension)serializable).width, 600);
        ((Component)((Object)sa19.d)).setPreferredSize((Dimension)serializable);
        ((Window)((Object)sa19.d)).pack();
        ((Window)((Object)sa19.d)).setLocationRelativeTo(null);
    }

    @Override
    private /* synthetic */ void ALLATORIxDEMO(pa a2) {
        Sa a3;
        a3.C.addElement(a2);
    }

    @Override
    public /* synthetic */ void i(String a2) {
        Sa a3;
        if ((a2 = a3.l(a2)) != null) {
            a3.d(a2);
        }
    }

    @Override
    public /* synthetic */ void g(String a2) {
        Sa a3;
        SwingUtilities.invokeLater(() -> {
            Sa a3;
            a3.F.removeElement(a2);
        });
    }

    @Override
    public /* synthetic */ void G(String a2) {
        Sa a3;
        if ((a2 = a3.l(a2)) != null) {
            a3.ALLATORIxDEMO(a2, true);
        }
    }

    @Override
    public /* synthetic */ void K(String a2) {
        Sa a3;
        a3.d(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, a a3) {
        Sa a4;
        a3.ALLATORIxDEMO(a2, a4);
    }

    @Override
    public /* synthetic */ void C(String a2) {
        Sa a3;
        a3.ALLATORIxDEMO(a2, true);
    }

    private /* synthetic */ JButton ALLATORIxDEMO(String a3, BufferedImage a4) {
        Sa a5;
        a4 = new ImageIcon((Image)a4);
        Object object = a4 = new JButton(a3, (Icon)a4);
        ((AbstractButton)object).setActionCommand(a3);
        ((AbstractButton)object).addActionListener(a2 -> {
            Sa a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            Sa sa2 = a3;
            sa2.ALLATORIxDEMO(arg_0 -> sa2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        return a4;
    }

    @Override
    public /* synthetic */ void B(String a2) {
        Sa a3;
        SwingUtilities.invokeLater(() -> {
            Sa a3;
            a3.F.addElement(a2);
        });
    }

    @Override
    public /* synthetic */ String D() {
        Sa a2;
        String string = a2.P.getSelectedValue();
        if (string != null) {
            return string.replace(StringUtil.ALLATORIxDEMO("m"), "/");
        }
        return null;
    }

    @Override
    public /* synthetic */ boolean H(String a2) {
        Sa a3;
        Sa sa2 = a3;
        return (a2 = sa2.ALLATORIxDEMO(sa2.l((String)a2))) != null && ((pa)a2).d;
    }

    @Override
    public /* synthetic */ void I() {
        Sa a2;
        SwingUtilities.invokeLater(() -> {
            Sa a2;
            a2.F.clear();
        });
    }

    public static /* synthetic */ JList ALLATORIxDEMO(Sa a2) {
        return a2.G;
    }

    @Override
    public /* synthetic */ String d() {
        Sa a2;
        Path path = a2.H.getParent();
        if (path != null) {
            return path.toString();
        }
        return null;
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, boolean a3) {
        Sa a4;
        a2 = new pa(a4, (String)a2, a3);
        SwingUtilities.invokeLater(() -> a4.ALLATORIxDEMO((pa)a2));
    }

    @Override
    public /* synthetic */ String b() {
        Sa a2;
        String string = a2.H.toString().replace(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"-"), "/");
        if (string.endsWith("/")) {
            String string2 = string;
            string = string2.substring(0, string2.length() - 1);
        }
        return string;
    }

    @Override
    public /* synthetic */ void d() {
        Sa a2;
        SwingUtilities.invokeLater(() -> {
            Sa a2;
            a2.C.clear();
        });
    }

    @Override
    private /* synthetic */ void H(pa a2) {
        Sa a3;
        a3.C.removeElement(a2);
    }

    @Override
    public /* synthetic */ void c(String a2) {
        Sa a3;
        a3.H = Paths.get(a2, new String[0]);
        a3.t.setText(a2);
    }

    public static /* synthetic */ {
        B = new MatteBorder(0, 1, 0, 0, Color.BLACK);
        k = new FlowLayout(0, 6, 0);
        K = new Insets(3, 0, 3, 0);
        a = new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK), new EmptyBorder(5, 5, 5, 5));
        d = new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK), new EmptyBorder(5, 5, 5, 5));
        ALLATORIxDEMO = new CompoundBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK), new EmptyBorder(5, 5, 5, 5));
    }

    private /* synthetic */ JMenuItem ALLATORIxDEMO(String a3, BufferedImage a4) {
        Sa a5;
        JMenuItem jMenuItem = new JMenuItem(a3);
        a4 = new ImageIcon((Image)a4);
        JMenuItem jMenuItem2 = jMenuItem;
        jMenuItem2.setActionCommand(a3);
        jMenuItem2.addActionListener(a2 -> {
            Sa a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            Sa sa2 = a3;
            sa2.ALLATORIxDEMO(arg_0 -> sa2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        JMenuItem jMenuItem3 = jMenuItem;
        jMenuItem3.setIcon((Icon)a4);
        return jMenuItem3;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO() {
        Sa a2;
        Sa sa2 = a2;
        sa2.d();
        sa2.I();
        super.ALLATORIxDEMO();
    }

    @Override
    public /* synthetic */ boolean l(String a2) {
        Sa a3;
        return (a2 = a3.ALLATORIxDEMO((String)a2)) != null && ((pa)a2).d;
    }

    @Override
    public /* synthetic */ void A(String a2) {
        Sa a3;
        a3.ALLATORIxDEMO(a2, false);
    }

    @Override
    public /* synthetic */ String I() {
        Sa a2;
        return a2.G.getSelectedValue().a.replace(StringUtil.ALLATORIxDEMO("m"), "/");
    }

    @Override
    public /* synthetic */ void h(String a2) {
        Sa a3;
        if ((a2 = a3.l(a2)) != null) {
            a3.ALLATORIxDEMO(a2, false);
        }
    }

    private /* synthetic */ String l(String a2) {
        Sa a3;
        if (!(a2 = Paths.get((String)a2, new String[0])).getRoot().equals(a3.H.getRoot())) {
            return null;
        }
        if ((a2 = a3.H.relativize((Path)a2)).getNameCount() == 1) {
            return a2.getFileName().toString();
        }
        return null;
    }

    private /* synthetic */ void d(String a2) {
        Sa a3;
        Sa sa2 = a3;
        SwingUtilities.invokeLater(() -> sa2.H(sa2.ALLATORIxDEMO(a2)));
    }

    private /* synthetic */ pa ALLATORIxDEMO(String a2) {
        Sa a3;
        Enumeration<pa> enumeration = a3.C.elements();
        while (enumeration.hasMoreElements()) {
            pa pa2 = enumeration.nextElement();
            if (!pa2.a.equals(a2)) continue;
            return pa2;
        }
        return null;
    }
}

