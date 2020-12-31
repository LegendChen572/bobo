/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.formdev.flatlaf.FlatLightLaf
 */
package tools.use.xml.swing;

import com.formdev.flatlaf.FlatLightLaf;
import handling.world.exped.MapleExpedition;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.MobSkillData;
import server.swing.WvsCenter;
import tools.packet.BeansPacket;
import tools.use.xml.InlinkFix.LinkFix;
import tools.use.xml.flychair.TamingMobNodeInlink;
import tools.use.xml.removeChild;
import tools.use.xml.string.StringNodeChange;

public class XMLGUI
extends JFrame {
    private /* synthetic */ JScrollPane k;
    private /* synthetic */ JLabel m;
    private /* synthetic */ JTextField t;
    private /* synthetic */ JScrollPane K;
    private /* synthetic */ JLabel D;
    private /* synthetic */ JButton l;
    private /* synthetic */ JButton c;
    private /* synthetic */ JPanel E;
    private /* synthetic */ JTextField Z;
    private static final /* synthetic */ XMLGUI s;
    private /* synthetic */ JTextField r;
    private /* synthetic */ JLabel R;
    private /* synthetic */ JCheckBox S;
    private /* synthetic */ JLabel A;
    private /* synthetic */ JLabel j;
    private /* synthetic */ JTextArea v;
    private /* synthetic */ JLabel T;
    private /* synthetic */ JLabel N;
    private /* synthetic */ JScrollPane g;
    private /* synthetic */ JTabbedPane a;
    private /* synthetic */ JPanel C;
    private /* synthetic */ JPanel H;
    private /* synthetic */ JButton G;
    private /* synthetic */ JLabel f;
    private /* synthetic */ JPanel I;
    private /* synthetic */ JLabel h;
    private /* synthetic */ JTextField P;
    private /* synthetic */ JLabel L;
    private /* synthetic */ JPanel F;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel J;
    private /* synthetic */ JTextField o;
    private /* synthetic */ JButton b;
    private /* synthetic */ JLabel M;
    private /* synthetic */ JTextArea d;
    private /* synthetic */ JTextField w;
    private /* synthetic */ JLabel i;
    private /* synthetic */ JTextArea n;
    private /* synthetic */ JScrollPane B;
    private /* synthetic */ JPanel e;
    private /* synthetic */ JTextArea Q;

    public /* synthetic */ void init() {
        XMLGUI a2;
        XMLGUI xMLGUI = a2;
        TamingMobNodeInlink.BASE_FOLDER = xMLGUI.Z.getText();
        TamingMobNodeInlink.removeNodes = xMLGUI.S.isSelected();
        StringNodeChange.BASE_FOLDER = xMLGUI.w.getText();
        StringNodeChange.CHANGE_FROM = xMLGUI.r.getText();
        StringNodeChange.CHANGE_TO = xMLGUI.o.getText();
        LinkFix.BASE_FOLDER = xMLGUI.t.getText();
    }

    public /* synthetic */ void printStringLog(String a2) {
        XMLGUI a3;
        XMLGUI xMLGUI = a3;
        xMLGUI.Q.setText(xMLGUI.Q.getText() + a2 + "\r\n");
    }

    private /* synthetic */ void c(ActionEvent a2) {
        XMLGUI a3;
        new Thread(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                try {
                    10 a2;
                    a2.XMLGUI.this.init();
                    LinkFix.main(null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
            {
                10 a3;
            }
        }).start();
    }

    private /* synthetic */ void E(ActionEvent a2) {
        XMLGUI a3;
        new Thread(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                try {
                    12 a2;
                    a2.XMLGUI.this.init();
                    TamingMobNodeInlink.main(null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
            {
                12 a3;
            }
        }).start();
    }

    private /* synthetic */ void H(ActionEvent a2) {
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        XMLGUI a2;
        XMLGUI xMLGUI = a2;
        XMLGUI xMLGUI2 = a2;
        XMLGUI xMLGUI3 = a2;
        xMLGUI2.F = new JPanel();
        xMLGUI3.I = new JPanel();
        xMLGUI2.a = new JTabbedPane();
        xMLGUI2.C = new JPanel();
        xMLGUI2.m = new JLabel();
        xMLGUI2.Z = new JTextField();
        xMLGUI2.g = new JScrollPane();
        xMLGUI2.n = new JTextArea();
        xMLGUI2.S = new JCheckBox();
        xMLGUI2.G = new JButton();
        xMLGUI2.f = new JLabel();
        xMLGUI2.T = new JLabel();
        xMLGUI2.H = new JPanel();
        xMLGUI2.B = new JScrollPane();
        xMLGUI2.Q = new JTextArea();
        xMLGUI2.h = new JLabel();
        xMLGUI2.w = new JTextField();
        xMLGUI2.b = new JButton();
        xMLGUI2.D = new JLabel();
        xMLGUI2.R = new JLabel();
        xMLGUI2.r = new JTextField();
        xMLGUI2.L = new JLabel();
        xMLGUI2.o = new JTextField();
        xMLGUI2.e = new JPanel();
        xMLGUI2.j = new JLabel();
        xMLGUI2.t = new JTextField();
        xMLGUI2.i = new JLabel();
        xMLGUI2.N = new JLabel();
        xMLGUI2.k = new JScrollPane();
        xMLGUI2.v = new JTextArea();
        xMLGUI2.c = new JButton();
        xMLGUI2.E = new JPanel();
        xMLGUI2.J = new JLabel();
        xMLGUI2.P = new JTextField();
        xMLGUI2.M = new JLabel();
        xMLGUI2.ALLATORIxDEMO = new JTextField();
        xMLGUI2.A = new JLabel();
        xMLGUI2.K = new JScrollPane();
        xMLGUI2.d = new JTextArea();
        a2.l = new JButton();
        xMLGUI.setDefaultCloseOperation(3);
        a2.m.setText(BeansPacket.ALLATORIxDEMO("\u6ab1\u680a\u8dca\u5fd3\u001f"));
        xMLGUI.Z.setText("TamingMob");
        xMLGUI.Z.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.XMLGUI.this.D(a2);
            }
            {
                1 a3;
            }
        });
        xMLGUI.n.setColumns(20);
        xMLGUI.n.setRows(5);
        xMLGUI.g.setViewportView(a2.n);
        xMLGUI.S.setText(MapleExpedition.ALLATORIxDEMO("\u6e03\u9641\u4f48\u726d\u672a\u4e28\u6529\u63d1\u7bc6\u9efb.qKv7\u0016^\u21b6/"));
        xMLGUI.G.setText(BeansPacket.ALLATORIxDEMO("\u95c9\u59ee\u6e47\u9641"));
        xMLGUI.G.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.XMLGUI.this.E(a2);
            }
            {
                2 a3;
            }
        });
        xMLGUI.f.setText(MapleExpedition.ALLATORIxDEMO("\u6b65\u570d\u6385\u63ea\u6a92\u686d\uff1c"));
        xMLGUI.T.setText(BeansPacket.ALLATORIxDEMO("\u5c58\u670f\u95c9\u59ee"));
        GroupLayout groupLayout = new GroupLayout(a2.C);
        xMLGUI.C.setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g).addGroup(groupLayout.createSequentialGroup().addComponent(a2.m, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.Z)).addComponent(a2.S, -1, -1, 32767).addComponent(a2.G, -1, -1, 32767).addGroup(groupLayout.createSequentialGroup().addComponent(a2.f).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.T, -1, -1, 32767))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.m).addComponent(a2.Z, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.S).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.f, -2, 24, -2).addComponent(a2.T, -2, 24, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.g, -1, 519, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.G).addContainerGap()));
        xMLGUI.a.addTab(MapleExpedition.ALLATORIxDEMO("\u9a2b\u5bf3lhIoKm"), a2.C);
        xMLGUI.Q.setColumns(20);
        xMLGUI.Q.setRows(5);
        xMLGUI.B.setViewportView(a2.Q);
        xMLGUI.h.setText(BeansPacket.ALLATORIxDEMO("\u6ab1\u680a\u8dca\u5fd3\u001f"));
        xMLGUI.w.setText("String");
        xMLGUI.w.addActionListener(new ActionListener(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.XMLGUI.this.I(a2);
            }
        });
        xMLGUI.b.setText(MapleExpedition.ALLATORIxDEMO("\u95ae\u59cd\u66da\u63dd"));
        xMLGUI.b.addActionListener(new ActionListener(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                4 a3;
                a3.XMLGUI.this.d(a2);
            }
        });
        xMLGUI.D.setText(BeansPacket.ALLATORIxDEMO("\u6b46\u576a\u63a6\u638d\u6ab1\u680a\uff3f"));
        xMLGUI.R.setText(MapleExpedition.ALLATORIxDEMO("\u5c3f\u672c\u95ae\u59cd"));
        xMLGUI.r.setText("\u6953\u4e4b\u8c37");
        xMLGUI.L.setText(BeansPacket.ALLATORIxDEMO("\u66da\u6399\u6235"));
        xMLGUI.o.setText("XX\u8c37");
        groupLayout = new GroupLayout(a2.H);
        xMLGUI.H.setLayout(groupLayout);
        GroupLayout groupLayout4 = groupLayout;
        GroupLayout groupLayout5 = groupLayout;
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout5.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.B, -1, 637, 32767).addComponent(a2.b, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.D).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.R, -1, -1, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.r, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.L).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.o, -2, 79, -2).addGap(0, 0, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.h, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.w))).addContainerGap()));
        groupLayout4.setVerticalGroup(groupLayout5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.h).addComponent(a2.w, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.r, -2, -1, -2).addComponent(a2.L).addComponent(a2.o, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.D, -2, 24, -2).addComponent(a2.R, -2, 24, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B, -1, 522, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.b)));
        xMLGUI.a.addTab(MapleExpedition.ALLATORIxDEMO("\u625c\u91c9vrWoKa"), a2.H);
        xMLGUI.j.setText(BeansPacket.ALLATORIxDEMO("\u6ab1\u680a\u8dca\u5fd3\u001f"));
        xMLGUI.t.setText("String");
        xMLGUI.t.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                5 a3;
                a3.XMLGUI.this.b(a2);
            }
            {
                5 a3;
            }
        });
        xMLGUI.i.setText(MapleExpedition.ALLATORIxDEMO("\u6b65\u570d\u88da\u9f6f\u6a92\u686d\uff1c"));
        xMLGUI.N.setText(BeansPacket.ALLATORIxDEMO("\u5c58\u670f\u95c9\u59ee"));
        xMLGUI.v.setColumns(20);
        xMLGUI.v.setRows(5);
        xMLGUI.k.setViewportView(a2.v);
        xMLGUI.c.setText(MapleExpedition.ALLATORIxDEMO("\u95ae\u59cd\u88f9\u5710"));
        xMLGUI.c.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                6 a3;
                a3.XMLGUI.this.c(a2);
            }
            {
                6 a3;
            }
        });
        groupLayout = new GroupLayout(a2.e);
        xMLGUI.e.setLayout(groupLayout);
        GroupLayout groupLayout6 = groupLayout;
        GroupLayout groupLayout7 = groupLayout;
        groupLayout6.setHorizontalGroup(groupLayout6.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout7.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.j, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.t, -1, 573, 32767)).addComponent(a2.c, -1, -1, 32767)).addContainerGap()).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.k).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.i).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.N, -1, -1, 32767))).addContainerGap())));
        groupLayout6.setVerticalGroup(groupLayout7.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.j).addComponent(a2.t, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 586, 32767).addComponent(a2.c).addGap(5, 5, 5)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(38, 38, 38).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.i, -2, 24, -2).addComponent(a2.N, -2, 24, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.k, -2, 540, -2).addContainerGap(37, 32767))));
        XMLGUI xMLGUI4 = a2;
        XMLGUI xMLGUI5 = a2;
        XMLGUI xMLGUI6 = a2;
        xMLGUI5.a.addTab(BeansPacket.ALLATORIxDEMO("\u000bK.L,N\u889e\u5733"), xMLGUI6.e);
        xMLGUI6.J.setText(MapleExpedition.ALLATORIxDEMO("\u6a92\u686d\u8de9\u5fb4<"));
        xMLGUI5.P.setText("String");
        xMLGUI5.P.addActionListener(new ActionListener(){
            {
                7 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                7 a3;
                a3.XMLGUI.this.l(a2);
            }
        });
        xMLGUI5.M.setText(BeansPacket.ALLATORIxDEMO("\u79de\u9626\u7be5\u9e9c\u001f"));
        xMLGUI5.ALLATORIxDEMO.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                8 a3;
                a3.XMLGUI.this.H(a2);
            }
            {
                8 a3;
            }
        });
        xMLGUI5.A.setForeground(new Color(255, 0, 0));
        xMLGUI5.A.setText(MapleExpedition.ALLATORIxDEMO("\u001b8\u53ca\u752e\u0005$\t$\u0005\u5200\u95ae&@~\u001f\u8987\u79de\u9662IcScI\u8dd9HiG\u516f\u502e\u7bc6\u9efb&\u5eb0\u4e0d\u5c14\u8f3e\u5140<\u0005j@p@j\tkJd"));
        xMLGUI5.d.setColumns(20);
        xMLGUI5.d.setRows(5);
        xMLGUI5.K.setViewportView(a2.d);
        xMLGUI5.l.setText(BeansPacket.ALLATORIxDEMO("\u95c9\u59ee\u79b9\u9641"));
        xMLGUI5.l.addActionListener(new ActionListener(){
            {
                9 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                9 a3;
                a3.XMLGUI.this.ALLATORIxDEMO(a2);
            }
        });
        groupLayout = new GroupLayout(a2.E);
        xMLGUI5.E.setLayout(groupLayout);
        GroupLayout groupLayout8 = groupLayout;
        GroupLayout groupLayout9 = groupLayout;
        groupLayout8.setHorizontalGroup(groupLayout8.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout9.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.K).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.J, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.P, -1, 573, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.M, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO, -1, 573, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.A).addGap(0, 0, 32767)).addComponent(a2.l, -1, -1, 32767)).addContainerGap()));
        groupLayout8.setVerticalGroup(groupLayout9.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.J).addComponent(a2.P, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.A).addGap(6, 6, 6).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.M).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.K, -2, 510, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.l, -2, 27, -2).addContainerGap(12, 32767)));
        xMLGUI5.a.addTab(MapleExpedition.ALLATORIxDEMO("\u7be5\u9ed8\u79de\u9662"), a2.E);
        groupLayout = new GroupLayout(a2.I);
        xMLGUI4.I.setLayout(groupLayout);
        GroupLayout groupLayout10 = groupLayout;
        GroupLayout groupLayout11 = groupLayout;
        groupLayout10.setHorizontalGroup(groupLayout10.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout11.createSequentialGroup().addComponent(a2.a, -2, 662, -2).addGap(0, 0, 32767)));
        groupLayout10.setVerticalGroup(groupLayout11.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.a, -2, 673, -2).addGap(0, 0, 32767)));
        groupLayout = new GroupLayout(a2.F);
        xMLGUI4.F.setLayout(groupLayout);
        GroupLayout groupLayout12 = groupLayout;
        groupLayout12.setHorizontalGroup(groupLayout12.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.I, -1, -1, 32767));
        groupLayout12.setVerticalGroup(groupLayout12.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.I, -2, -1, -2).addGap(2, 2, 2)));
        groupLayout = new GroupLayout(a2.getContentPane());
        a2.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout13 = groupLayout;
        groupLayout13.setHorizontalGroup(groupLayout13.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.F, -1, -1, 32767));
        groupLayout13.setVerticalGroup(groupLayout13.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.F, -1, -1, 32767));
        xMLGUI4.pack();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(BeansPacket.ALLATORIxDEMO("/a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006H\u0006b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005a/a\u0005b\u0005b\u0005b\u0005b\u0006a\u0005a\u0005b\u0005a\u0005b\u0005b\u0006a\u0005a\u0006a\u0005a\u0006a\u0005a\u0006b\u0005a\u0006a\u0005b\u0005b\u0005b\u0005b\u0006H\u0006b\u0005b\u0005b\u0005b\u0006b\u0006b\u0006b\u0005b\u0006b\u0005b\u0006b\u0006b\u0005a\u0005b\u0006b\u0006b\u0006b\u0006b\u0005a\u0005b\u0005b\u0005b\u0005b\u0005a/a\u0005b\u0005b\u0005b\u0005a\u0006a\u0005a\u0005b\u0005a\u0005b\u0005a\u0006a\u0005b\u0006b\u0005a\u0005a\u0005a\u0006b\u0005b\u0006b\u0005b\u0005b\u0005b\u0005b\u0006H\u0006b\u0005b\u0005b\u0005b\u0006b\u0006b\u0006a\u0006b\u0006a\u0006b\u0006b\u0006b\u0005a\u0005b\u0006a\u0006b\u0006b\u0006b\u0006a\u0006b\u0005b\u0005b\u0005b\u0005a/a\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0006H\u0006bj C7V!D6L-KbG;\u0005\u0003I.D6J0Lbj C7V!D6J0\u00054\u0012l\u0016ba\u0007h\r\u0005a/a\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0006H\u0006b\u0005b\u0005b\u0005b\u0005b\u0005bM6Q2\u001fm\n5R5\u000b#I.D6J0LlF-Hb\u0005b\u0005b\u0005b\u0005b\u0005b\u0005a/a\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0005b\u0006H\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a\u0006a/"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleExpedition.ALLATORIxDEMO("QLhAiRu").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(XMLGUI.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                14 a2;
                new Thread(new Runnable(){

                    /*
                     * Unable to fully structure code
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    @Override
                    public /* synthetic */ void run() {
                        try {
                            UIManager.setLookAndFeel((LookAndFeel)new FlatLightLaf());
                            ** GOTO lbl7
                        }
                        catch (UnsupportedLookAndFeelException var1_1) {
                            try {
                                Logger.getLogger(WvsCenter.class.getName()).log(Level.SEVERE, null, var1_1);
lbl7:
                                // 2 sources

                                var1_2 = new XMLGUI();
                                var1_2.Visible(true);
                                return;
                            }
                            catch (Exception var1_3) {
                                var1_3.printStackTrace();
                                return;
                            }
                        }
                    }
                    {
                        1 a3;
                    }
                }).start();
            }
            {
                14 a2;
            }
        });
    }

    public /* synthetic */ void setNowScan1(String a2) {
        XMLGUI a3;
        a3.R.setText(a2);
    }

    public /* synthetic */ void printInlinkLog(String a2) {
        XMLGUI a3;
        XMLGUI xMLGUI = a3;
        xMLGUI.v.setText(xMLGUI.v.getText() + a2 + "\r\n");
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        XMLGUI a3;
        new Thread(new Runnable(){
            {
                13 a3;
            }

            @Override
            public /* synthetic */ void run() {
                try {
                    13 a2;
                    removeChild.remove(a2.XMLGUI.this.P.getText(), a2.XMLGUI.this.ALLATORIxDEMO.getText().split(MobSkillData.ALLATORIxDEMO("!")));
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        }).start();
    }

    public static /* synthetic */ {
        s = new XMLGUI();
    }

    public /* synthetic */ void addInlinkLog(String a2) {
        XMLGUI a3;
        XMLGUI xMLGUI = a3;
        xMLGUI.v.setText(xMLGUI.v.getText() + a2);
    }

    public /* synthetic */ void setNowScan(String a2) {
        XMLGUI a3;
        a3.T.setText(a2);
    }

    private /* synthetic */ void l(ActionEvent a2) {
    }

    public static final /* synthetic */ XMLGUI getInstance() {
        return s;
    }

    private /* synthetic */ void D(ActionEvent a2) {
    }

    private /* synthetic */ void b(ActionEvent a2) {
    }

    public /* synthetic */ XMLGUI() {
        XMLGUI a2;
    }

    private /* synthetic */ void d(ActionEvent a2) {
        XMLGUI a3;
        new Thread(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                try {
                    11 a2;
                    a2.XMLGUI.this.init();
                    StringNodeChange.main(null);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
            {
                11 a3;
            }
        }).start();
    }

    public /* synthetic */ void addChatLog(String a2) {
        XMLGUI a3;
        XMLGUI xMLGUI = a3;
        xMLGUI.n.setText(xMLGUI.n.getText() + a2);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        XMLGUI a3;
        a3.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        XMLGUI xMLGUI = a3;
        xMLGUI.setLocation((int)(dimension.getWidth() - (double)xMLGUI.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        if (a2) {
            a3.init();
        }
        super.setVisible(a2);
    }

    private /* synthetic */ void I(ActionEvent a2) {
    }

    public /* synthetic */ void Visible(boolean a2) {
        s.ALLATORIxDEMO();
        s.setVisible(a2);
    }

    public /* synthetic */ void printChatLog(String a2) {
        XMLGUI a3;
        XMLGUI xMLGUI = a3;
        xMLGUI.n.setText(xMLGUI.n.getText() + a2 + "\r\n");
    }
}

