/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5408\u592a\u8c37
 */
package server.swing.tools;

import client.messages.commands.player.\u5408\u592a\u8c37;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.swing.UIWindow;
import server.swing.WvsCenter;
import tools.wztosql.DumpItemsAdditions;

public class EquipEditor
extends JFrame
implements UIWindow {
    private /* synthetic */ JLabel T;
    private /* synthetic */ JTextField F;
    private /* synthetic */ JLabel v;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JLabel S;
    private /* synthetic */ JTextField I;
    private /* synthetic */ JButton s;
    private /* synthetic */ JLabel c;
    private /* synthetic */ JLabel Z;
    private /* synthetic */ JLabel b;
    private /* synthetic */ JTextField D;
    private /* synthetic */ JLabel R;
    private /* synthetic */ JTextField e;
    private /* synthetic */ JLabel f;
    private /* synthetic */ JPanel h;
    private /* synthetic */ JLabel t;
    private /* synthetic */ JTextField C;
    private /* synthetic */ JLabel P;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JLabel o;
    private /* synthetic */ JTextField g;
    private /* synthetic */ JLabel A;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JLabel r;
    private /* synthetic */ JTextField B;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton n;
    private /* synthetic */ JTextField L;
    private /* synthetic */ JTextField j;
    private /* synthetic */ JLabel l;
    private /* synthetic */ JTextField M;
    private /* synthetic */ JTextField J;
    private /* synthetic */ JTextField H;
    private /* synthetic */ JLabel w;
    private static final /* synthetic */ EquipEditor O;
    private /* synthetic */ JLabel N;
    private /* synthetic */ JLabel Q;
    private /* synthetic */ JTextField E;
    private /* synthetic */ JLabel G;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JLabel m;
    private /* synthetic */ JTextField i;

    private /* synthetic */ void b(ActionEvent a2) {
    }

    private /* synthetic */ void H(ActionEvent a2) {
        EquipEditor a3;
        Object[] arrobject = new Object[17];
        arrobject[0] = Integer.parseInt(a3.g.getText());
        arrobject[1] = Integer.parseInt(a3.K.getText());
        arrobject[2] = Integer.parseInt(a3.k.getText());
        arrobject[3] = Integer.parseInt(a3.B.getText());
        arrobject[4] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
        arrobject[5] = Integer.parseInt(a3.a.getText());
        arrobject[6] = Integer.parseInt(a3.d.getText());
        arrobject[7] = Integer.parseInt(a3.L.getText());
        arrobject[8] = Integer.parseInt(a3.j.getText());
        arrobject[9] = Integer.parseInt(a3.i.getText());
        arrobject[10] = Integer.parseInt(a3.J.getText());
        arrobject[11] = Integer.parseInt(a3.F.getText());
        arrobject[12] = Integer.parseInt(a3.M.getText());
        arrobject[13] = Integer.parseInt(a3.I.getText());
        arrobject[14] = Integer.parseInt(a3.C.getText());
        arrobject[15] = Integer.parseInt(a3.H.getText());
        arrobject[16] = Long.parseLong(a3.e.getText());
        WvsCenter.getInstance().UpdateEquipStats(arrobject);
        a3.setVisible(false);
    }

    private /* synthetic */ void D(ActionEvent a2) {
    }

    public static final /* synthetic */ EquipEditor getInstance() {
        return O;
    }

    public /* synthetic */ void init() {
        EquipEditor a2;
        EquipEditor equipEditor = a2;
        equipEditor.D.setText("");
        equipEditor.E.setText("");
        equipEditor.g.setText("");
        equipEditor.B.setText("");
        equipEditor.k.setText("");
        equipEditor.K.setText("");
        equipEditor.a.setText("");
        equipEditor.d.setText("");
        equipEditor.ALLATORIxDEMO.setText("");
        equipEditor.L.setText("");
        equipEditor.j.setText("");
        equipEditor.i.setText("");
        equipEditor.J.setText("");
        equipEditor.M.setText("");
        equipEditor.I.setText("");
        equipEditor.F.setText("");
        equipEditor.C.setText("");
        equipEditor.H.setText("");
    }

    private /* synthetic */ void j(ActionEvent a2) {
    }

    private /* synthetic */ void l(ActionEvent a2) {
        EquipEditor a3;
        a3.setVisible(false);
    }

    private /* synthetic */ void c(ActionEvent a2) {
    }

    public /* synthetic */ void setEquipStats(Object[] a2) {
        EquipEditor a3;
        if (a2 == null || a2.length < 9) {
            return;
        }
        EquipEditor equipEditor = a3;
        equipEditor.D.setText(String.valueOf(a2[0]));
        equipEditor.E.setText(String.valueOf(a2[1]));
        equipEditor.g.setText(String.valueOf(a2[2]));
        equipEditor.K.setText(String.valueOf(a2[3]));
        equipEditor.k.setText(String.valueOf(a2[4]));
        equipEditor.B.setText(String.valueOf(a2[5]));
        equipEditor.ALLATORIxDEMO.setText(String.valueOf(a2[6]));
        equipEditor.a.setText(String.valueOf(a2[7]));
        equipEditor.d.setText(String.valueOf(a2[8]));
        equipEditor.L.setText(String.valueOf(a2[9]));
        equipEditor.j.setText(String.valueOf(a2[10]));
        equipEditor.i.setText(String.valueOf(a2[11]));
        equipEditor.J.setText(String.valueOf(a2[12]));
        equipEditor.F.setText(String.valueOf(a2[13]));
        equipEditor.M.setText(String.valueOf(a2[14]));
        equipEditor.I.setText(String.valueOf(a2[15]));
        equipEditor.C.setText(String.valueOf(a2[16]));
        equipEditor.H.setText(String.valueOf(a2[17]));
        equipEditor.e.setText(String.valueOf(a2[18]));
    }

    private /* synthetic */ void A(ActionEvent a2) {
    }

    private /* synthetic */ void d(ActionEvent a2) {
    }

    private /* synthetic */ void C(ActionEvent a2) {
    }

    private /* synthetic */ void i(ActionEvent a2) {
    }

    public static /* synthetic */ {
        O = new EquipEditor();
    }

    private /* synthetic */ void B(ActionEvent a2) {
    }

    private /* synthetic */ void I(ActionEvent a2) {
    }

    private /* synthetic */ void m(ActionEvent a2) {
    }

    private /* synthetic */ void a(ActionEvent a2) {
    }

    private /* synthetic */ void G(ActionEvent a2) {
    }

    private /* synthetic */ void J(ActionEvent a2) {
    }

    public /* synthetic */ EquipEditor() {
        EquipEditor a2;
        EquipEditor equipEditor = a2;
        equipEditor.ALLATORIxDEMO();
    }

    private /* synthetic */ void K(ActionEvent a2) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(DumpItemsAdditions.ALLATORIxDEMO("C\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j,j\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0005C\u0005i\u0006i\u0006i\u0006i\u0006j\u0005i\u0005i\u0006i\u0005i\u0006i\u0006j\u0005i\u0005j\u0005i\u0005j\u0005i\u0005j\u0006i\u0005j\u0005i\u0006i\u0006i\u0006i\u0006j,j\u0006i\u0006i\u0006i\u0006j\u0006j\u0006j\u0006i\u0006j\u0006i\u0006j\u0006j\u0006i\u0005i\u0006j\u0006j\u0006j\u0006j\u0006i\u0005i\u0006i\u0006i\u0006i\u0006i\u0005C\u0005i\u0006i\u0006i\u0006i\u0005j\u0005i\u0005i\u0006i\u0005i\u0006i\u0005j\u0005i\u0006j\u0006i\u0005i\u0005i\u0005j\u0006i\u0006j\u0006i\u0006i\u0006i\u0006i\u0006j,j\u0006i\u0006i\u0006i\u0006j\u0006j\u0006j\u0005j\u0006j\u0005j\u0006j\u0006j\u0006i\u0005i\u0006j\u0005j\u0006j\u0006j\u0006j\u0005j\u0006i\u0006i\u0006i\u0006i\u0005C\u0005i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006j,j\u0006\u0006D/S:E(R I'\u0006+_ig%J(R&T \u0006\u0006D/S:E(R&TiP~\bz\u0006\rc\u0004ii\u0005C\u0005i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006j,j\u0006i\u0006i\u0006i\u0006i\u0006i\u0006!R=Vs\tfQ>QgG%J(R&T \b*I$\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0005C\u0005i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006i\u0006j,j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005j\u0005C"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!\u5408\u592a\u8c37.ALLATORIxDEMO((String)"@Pc[{J").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(EquipEditor.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(EquipEditor.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(EquipEditor.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(EquipEditor.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                22 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new EquipEditor().setVisible(true);
            }
        });
    }

    private /* synthetic */ void h(ActionEvent a2) {
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
    }

    private /* synthetic */ void E(ActionEvent a2) {
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        EquipEditor a2;
        EquipEditor equipEditor = a2;
        EquipEditor equipEditor2 = a2;
        EquipEditor equipEditor3 = a2;
        equipEditor2.h = new JPanel();
        equipEditor3.P = new JLabel();
        equipEditor2.D = new JTextField();
        equipEditor2.G = new JLabel();
        equipEditor2.E = new JTextField();
        equipEditor2.b = new JLabel();
        equipEditor2.g = new JTextField();
        equipEditor2.c = new JLabel();
        equipEditor2.B = new JTextField();
        equipEditor2.k = new JTextField();
        equipEditor2.K = new JTextField();
        equipEditor2.l = new JLabel();
        equipEditor2.m = new JLabel();
        equipEditor2.A = new JLabel();
        equipEditor2.f = new JLabel();
        equipEditor2.a = new JTextField();
        equipEditor2.d = new JTextField();
        equipEditor2.v = new JLabel();
        equipEditor2.ALLATORIxDEMO = new JTextField();
        equipEditor2.T = new JLabel();
        equipEditor2.L = new JTextField();
        equipEditor2.R = new JLabel();
        equipEditor2.j = new JTextField();
        equipEditor2.N = new JLabel();
        equipEditor2.i = new JTextField();
        equipEditor2.S = new JLabel();
        equipEditor2.J = new JTextField();
        equipEditor2.r = new JLabel();
        equipEditor2.M = new JTextField();
        equipEditor2.Q = new JLabel();
        equipEditor2.I = new JTextField();
        equipEditor2.o = new JLabel();
        equipEditor2.F = new JTextField();
        equipEditor2.Z = new JLabel();
        equipEditor2.C = new JTextField();
        equipEditor2.t = new JLabel();
        equipEditor2.H = new JTextField();
        equipEditor2.w = new JLabel();
        equipEditor2.e = new JTextField();
        equipEditor2.n = new JButton();
        a2.s = new JButton();
        equipEditor.setDefaultCloseOperation(3);
        a2.P.setText(DumpItemsAdditions.ALLATORIxDEMO("\u88fb\u50d0\u4ec5\u78f5"));
        equipEditor.D.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.EquipEditor.this.j(a2);
            }
        });
        equipEditor.G.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u88d3\u50a0\u5403\u7a08"));
        equipEditor.E.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.EquipEditor.this.J(a2);
            }
        });
        equipEditor.b.setText(DumpItemsAdditions.ALLATORIxDEMO("\u524f\u9951\u6354\u6531"));
        equipEditor.g.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.EquipEditor.this.a(a2);
            }
            {
                3 a3;
            }
        });
        equipEditor.c.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u5295\u91f6"));
        equipEditor.B.addActionListener(new ActionListener(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                4 a3;
                a3.EquipEditor.this.m(a2);
            }
        });
        equipEditor.k.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                5 a3;
                a3.EquipEditor.this.A(a2);
            }
            {
                5 a3;
            }
        });
        equipEditor.K.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                6 a3;
                a3.EquipEditor.this.h(a2);
            }
            {
                6 a3;
            }
        });
        equipEditor.l.setText(DumpItemsAdditions.ALLATORIxDEMO("\u6569\u633e"));
        equipEditor.m.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6674\u52a2"));
        equipEditor.A.setText(DumpItemsAdditions.ALLATORIxDEMO("\u9b72\u52d2"));
        equipEditor.f.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u884e\u91f6"));
        equipEditor.a.addActionListener(new ActionListener(){
            {
                7 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                7 a3;
                a3.EquipEditor.this.C(a2);
            }
        });
        equipEditor.d.addActionListener(new ActionListener(){
            {
                8 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                8 a3;
                a3.EquipEditor.this.G(a2);
            }
        });
        equipEditor.v.setText(DumpItemsAdditions.ALLATORIxDEMO("\u5e5e\u9002"));
        equipEditor.ALLATORIxDEMO.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                9 a3;
                a3.EquipEditor.this.B(a2);
            }
            {
                9 a3;
            }
        });
        equipEditor.T.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u7267\u743f\u6535\u64f3"));
        equipEditor.L.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                10 a3;
                a3.EquipEditor.this.K(a2);
            }
            {
                10 a3;
            }
        });
        equipEditor.R.setText(DumpItemsAdditions.ALLATORIxDEMO("\u9b72\u6c9c\u651d\u6483"));
        equipEditor.j.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                11 a3;
                a3.EquipEditor.this.i(a2);
            }
            {
                11 a3;
            }
        });
        equipEditor.N.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u7267\u743f\u963c\u799f"));
        equipEditor.i.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                12 a3;
                a3.EquipEditor.this.g(a2);
            }
            {
                12 a3;
            }
        });
        equipEditor.S.setText(DumpItemsAdditions.ALLATORIxDEMO("\u9b72\u6c9c\u9614\u79ef"));
        equipEditor.J.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                13 a3;
                a3.EquipEditor.this.c(a2);
            }
            {
                13 a3;
            }
        });
        equipEditor.r.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u8ffa\u9046"));
        equipEditor.M.addActionListener(new ActionListener(){
            {
                14 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                14 a3;
                a3.EquipEditor.this.b(a2);
            }
        });
        equipEditor.Q.setText(DumpItemsAdditions.ALLATORIxDEMO("\u0001g\u0007b\u001a"));
        equipEditor.I.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                15 a3;
                a3.EquipEditor.this.d(a2);
            }
            {
                15 a3;
            }
        });
        equipEditor.o.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u5473\u4e14"));
        equipEditor.F.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                16 a3;
                a3.EquipEditor.this.I(a2);
            }
            {
                16 a3;
            }
        });
        equipEditor.Z.setText(DumpItemsAdditions.ALLATORIxDEMO("\u79dd\u529c\u9039\u5eef"));
        equipEditor.C.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                17 a3;
                a3.EquipEditor.this.E(a2);
            }
            {
                17 a3;
            }
        });
        equipEditor.t.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u8dca\u8e83\u52a2"));
        equipEditor.H.addActionListener(new ActionListener(){
            {
                18 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                18 a3;
                a3.EquipEditor.this.D(a2);
            }
        });
        equipEditor.w.setText(DumpItemsAdditions.ALLATORIxDEMO("\u5509\u4e49o\r"));
        equipEditor.e.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                19 a3;
                a3.EquipEditor.this.ALLATORIxDEMO(a2);
            }
            {
                19 a3;
            }
        });
        equipEditor.n.setText("\u53d6\u6d88");
        equipEditor.n.addActionListener(new ActionListener(){
            {
                20 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                20 a3;
                a3.EquipEditor.this.l(a2);
            }
        });
        equipEditor.s.setText(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u78b4\u8ab4\u4fe0\u6500"));
        equipEditor.s.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                21 a3;
                a3.EquipEditor.this.H(a2);
            }
            {
                21 a3;
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.h);
        equipEditor.h.setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.P, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.D, -1, 125, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.G, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.E)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.b, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.g)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.c, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.K)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.l, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.k)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.m, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.v, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.f, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.A, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.d)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.T, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.L)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.R, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.j)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.N, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.i)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.S, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.J)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.o, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.F)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.r, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.M)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.Q, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.I)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.Z, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.C)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.t, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.H)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.w, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.s, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.n, -2, 104, -2))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.P, -1, -1, 32767).addComponent(a2.D, -1, 26, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.G, -1, -1, 32767).addComponent(a2.E, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.b, -1, -1, 32767).addComponent(a2.g, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.c, -1, -1, 32767).addComponent(a2.K, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.l, -1, -1, 32767).addComponent(a2.k, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.m, -1, -1, 32767).addComponent(a2.B, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.v, -1, -1, 32767).addComponent(a2.ALLATORIxDEMO, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.f, -1, -1, 32767).addComponent(a2.a, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.A, -1, -1, 32767).addComponent(a2.d, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.T, -1, -1, 32767).addComponent(a2.L, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.R, -1, -1, 32767).addComponent(a2.j, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.N, -1, -1, 32767).addComponent(a2.i, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.S, -1, -1, 32767).addComponent(a2.J, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.o, -1, -1, 32767).addComponent(a2.F, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.r, -1, -1, 32767).addComponent(a2.M, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.Q, -1, -1, 32767).addComponent(a2.I, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.Z, -1, -1, 32767).addComponent(a2.C, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.t, -1, -1, 32767).addComponent(a2.H, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.w, -1, -1, 32767).addComponent(a2.e, -2, 26, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.n).addComponent(a2.s)).addContainerGap(-1, 32767)));
        groupLayout = new GroupLayout(a2.getContentPane());
        EquipEditor equipEditor4 = a2;
        equipEditor4.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout4 = groupLayout;
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.h, GroupLayout.Alignment.TRAILING, -2, -1, -2));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.h, GroupLayout.Alignment.TRAILING, -2, -1, -2));
        equipEditor4.pack();
    }

    private /* synthetic */ void g(ActionEvent a2) {
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        EquipEditor a3;
        EquipEditor equipEditor = a3;
        equipEditor.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        EquipEditor equipEditor2 = a3;
        equipEditor2.setLocation((int)(dimension.getWidth() - (double)equipEditor2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }
}

