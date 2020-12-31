/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.B;
import FuckingHackerToby.Fa;
import FuckingHackerToby.a;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public final class ua
extends Fa
implements B {
    private /* synthetic */ JTextField M;
    private static final /* synthetic */ TitledBorder d;
    private /* synthetic */ JButton H;
    private /* synthetic */ JScrollPane g;
    private /* synthetic */ JFormattedTextField I;
    private static final /* synthetic */ NumberFormat K;
    private /* synthetic */ JButton F;
    private /* synthetic */ JButton e;
    private static final /* synthetic */ CompoundBorder ALLATORIxDEMO;
    private static final /* synthetic */ TitledBorder a;
    private /* synthetic */ JTextField J;
    private /* synthetic */ JList<String> E;
    private /* synthetic */ JButton C;
    private static final /* synthetic */ Dimension k;
    private /* synthetic */ DefaultListModel<String> B;

    @Override
    public /* synthetic */ String g() {
        ua a2;
        return a2.E.getSelectedValue();
    }

    public static /* synthetic */ {
        k = new Dimension(750, 450);
        K = NumberFormat.getInstance();
        a = new TitledBorder("Address");
        d = new TitledBorder("Port");
        ALLATORIxDEMO = new CompoundBorder(new LineBorder(Color.GRAY), new EmptyBorder(5, 5, 5, 5));
        K.setGroupingUsed(false);
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, a a3) {
        ua a4;
        a3.ALLATORIxDEMO(a2, a4);
    }

    @Override
    public /* synthetic */ void M(String a2) {
        ua a3;
        a3.B.addElement(a2);
    }

    @Override
    public /* synthetic */ void J(String a2) {
        ua a3;
        a3.I.setText(a2);
    }

    private /* synthetic */ JPanel ALLATORIxDEMO() {
        ua a2;
        JPanel jPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JSeparator jSeparator = new JSeparator(0);
        JPanel jPanel2 = jPanel;
        ua ua2 = a2;
        JPanel jPanel3 = jPanel;
        JPanel jPanel4 = jPanel;
        GridBagConstraints gridBagConstraints2 = gridBagConstraints;
        JPanel jPanel5 = jPanel;
        GridBagConstraints gridBagConstraints3 = gridBagConstraints;
        jPanel.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints4 = gridBagConstraints;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints4.weightx = 1.0;
        gridBagConstraints4.weighty = 3.0;
        GridBagConstraints gridBagConstraints5 = gridBagConstraints;
        gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints3.fill = 2;
        jPanel5.add((Component)a2.g, gridBagConstraints);
        gridBagConstraints.gridy = 1;
        gridBagConstraints3.weighty = 1.0;
        gridBagConstraints.gridwidth = 1;
        jPanel5.add((Component)a2.J, gridBagConstraints);
        gridBagConstraints2.gridx = 1;
        jPanel4.add((Component)a2.I, gridBagConstraints);
        gridBagConstraints2.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel4.add((Component)a2.F, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        jPanel.add((Component)a2.C, gridBagConstraints);
        GridBagConstraints gridBagConstraints6 = gridBagConstraints;
        gridBagConstraints6.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints6.gridwidth = 2;
        jPanel3.add((Component)jSeparator, gridBagConstraints);
        GridBagConstraints gridBagConstraints7 = gridBagConstraints;
        gridBagConstraints7.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints7.anchor = 15;
        jPanel3.add((Component)a2.H, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        jPanel.add((Component)ua2.M, gridBagConstraints);
        GridBagConstraints gridBagConstraints8 = gridBagConstraints;
        gridBagConstraints8.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints8.gridwidth = 2;
        jPanel2.add((Component)ua2.e, gridBagConstraints);
        return jPanel2;
    }

    @Override
    public /* synthetic */ String i() {
        ua a2;
        return a2.M.getText();
    }

    @Override
    public /* synthetic */ void j(String a2) {
        ua a3;
        a3.J.setText(a2);
    }

    @Override
    public /* synthetic */ void a(String a2) {
        ua a3;
        a3.M.setText(a2);
    }

    @Override
    public /* synthetic */ String B() {
        ua a2;
        return a2.J.getText();
    }

    @Override
    public /* synthetic */ String K() {
        ua a2;
        return a2.I.getText();
    }

    @Override
    public /* synthetic */ boolean D(String a2) {
        ua a3;
        return a3.B.contains(a2);
    }

    @Override
    public /* synthetic */ String[] ALLATORIxDEMO() {
        int n2;
        ua a2;
        int n3 = a2.B.size();
        String[] arrstring = new String[n3];
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = a2.B.getElementAt(n2);
            arrstring[n2++] = string;
            n4 = n2;
        }
        return arrstring;
    }

    public /* synthetic */ ua() {
        ua a3;
        ua ua2 = a3;
        ua ua3 = a3;
        ua2.J = new JTextField();
        ua3.I = new JFormattedTextField(K);
        ua2.M = new JTextField("No file selected");
        ua2.F = new JButton("Add");
        ua2.C = new JButton("Remove");
        ua2.H = new JButton("Choose file");
        ua2.e = new JButton("Build");
        ua2.E = new JList();
        ua2.g = new JScrollPane(a3.E);
        ua2.B = new DefaultListModel();
        ua2.E.setModel(a3.B);
        ua2.F.setActionCommand("Add");
        ua2.F.addActionListener(a2 -> {
            ua a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            ua ua2 = a3;
            ua2.ALLATORIxDEMO(arg_0 -> ua2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        ua ua4 = a3;
        ua4.C.setActionCommand("Remove");
        ua4.C.addActionListener(a2 -> {
            ua a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            ua ua2 = a3;
            ua2.ALLATORIxDEMO(arg_0 -> ua2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        ua ua5 = a3;
        ua5.H.setActionCommand("Choose file");
        ua5.H.addActionListener(a2 -> {
            ua a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            ua ua2 = a3;
            ua2.ALLATORIxDEMO(arg_0 -> ua2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        ua ua6 = a3;
        ua6.e.setActionCommand("Build");
        ua6.e.addActionListener(a2 -> {
            ua a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            ua ua2 = a3;
            ua2.ALLATORIxDEMO(arg_0 -> ua2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        ua ua7 = a3;
        ua7.M.setEditable(false);
        ua7.M.setBorder(ALLATORIxDEMO);
        ua7.M.setHorizontalAlignment(0);
        ua7.J.setBorder(a);
        ua7.I.setBorder(d);
        JPanel jPanel = ua7.ALLATORIxDEMO();
        ((JFrame)((Object)ua7.d)).setDefaultCloseOperation(1);
        ((JFrame)((Object)ua7.d)).setContentPane(jPanel);
        ((Component)((Object)ua7.d)).setPreferredSize(k);
        ((Window)((Object)ua7.d)).setMinimumSize(k);
        ((Window)((Object)ua7.d)).pack();
        ((Window)((Object)ua7.d)).setLocationRelativeTo(null);
    }

    @Override
    public /* synthetic */ void b() {
        ua a2;
        a2.B.clear();
    }

    @Override
    public /* synthetic */ void L(String a2) {
        ua a3;
        a3.B.removeElement(a2);
    }
}

