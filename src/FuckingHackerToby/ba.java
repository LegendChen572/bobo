/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Fa;
import FuckingHackerToby.J;
import FuckingHackerToby.a;
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
import javax.swing.border.TitledBorder;

public final class ba
extends Fa
implements J {
    private static final /* synthetic */ Dimension K;
    private static final /* synthetic */ NumberFormat a;
    private static final /* synthetic */ TitledBorder d;
    private /* synthetic */ DefaultListModel<String> ALLATORIxDEMO;
    private /* synthetic */ JList<String> H;
    private static final /* synthetic */ String k = "Port";
    private /* synthetic */ JButton B;
    private /* synthetic */ JButton g;
    private /* synthetic */ JFormattedTextField E;
    private /* synthetic */ JScrollPane e;

    @Override
    public /* synthetic */ void E(String a2) {
        ba a3;
        a3.E.setText(a2);
    }

    public static /* synthetic */ {
        K = new Dimension(500, 300);
        a = NumberFormat.getInstance();
        d = new TitledBorder(k);
        a.setGroupingUsed(false);
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, a a3) {
        ba a4;
        a3.ALLATORIxDEMO(a2, a4);
    }

    @Override
    public /* synthetic */ void I(String a2) {
        ba a3;
        a3.ALLATORIxDEMO.removeElement(a2);
    }

    public /* synthetic */ ba() {
        ba a3;
        ba ba2 = a3;
        ba ba3 = a3;
        ba2.H = new JList();
        ba3.e = new JScrollPane(a3.H, 22, 30);
        ba2.E = new JFormattedTextField(a);
        ba2.g = new JButton("Start server");
        ba2.B = new JButton("Stop server");
        ba2.ALLATORIxDEMO = new DefaultListModel();
        ba2.g.setActionCommand("Start server");
        ba2.g.addActionListener(a2 -> {
            ba a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            ba ba2 = a3;
            ba2.ALLATORIxDEMO(arg_0 -> ba2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        ba ba4 = a3;
        ba4.B.setActionCommand("Stop server");
        ba4.B.addActionListener(a2 -> {
            ba a3;
            a2 = ((ActionEvent)a2).getActionCommand();
            ba ba2 = a3;
            ba2.ALLATORIxDEMO(arg_0 -> ba2.ALLATORIxDEMO((String)((Object)a2), arg_0));
        });
        ba ba5 = a3;
        ba5.E.setBorder(d);
        ba ba6 = a3;
        ba5.H.setModel(ba6.ALLATORIxDEMO);
        JPanel jPanel = ba6.ALLATORIxDEMO();
        ((JFrame)((Object)ba5.d)).setDefaultCloseOperation(1);
        ((JFrame)((Object)ba5.d)).setContentPane(jPanel);
        ((Component)((Object)ba5.d)).setPreferredSize(K);
        ((Window)((Object)ba5.d)).pack();
        ((Window)((Object)ba5.d)).setLocationRelativeTo(null);
    }

    @Override
    public /* synthetic */ boolean ALLATORIxDEMO(String a2) {
        ba a3;
        return a3.ALLATORIxDEMO.contains(a2);
    }

    @Override
    public /* synthetic */ String H() {
        ba a2;
        return a2.H.getSelectedValue();
    }

    @Override
    public /* synthetic */ String l() {
        ba a2;
        return a2.E.getText();
    }

    private /* synthetic */ JPanel ALLATORIxDEMO() {
        ba a2;
        JPanel jPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        jPanel.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints2 = gridBagConstraints;
        gridBagConstraints2.gridwidth = 2;
        gridBagConstraints2.weighty = 1.0;
        gridBagConstraints2.weightx = 1.0;
        JPanel jPanel2 = jPanel;
        GridBagConstraints gridBagConstraints3 = gridBagConstraints;
        GridBagConstraints gridBagConstraints4 = gridBagConstraints;
        GridBagConstraints gridBagConstraints5 = gridBagConstraints;
        GridBagConstraints gridBagConstraints6 = gridBagConstraints;
        gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints5.fill = 1;
        jPanel.add((Component)a2.e, gridBagConstraints);
        gridBagConstraints4.gridy = 1;
        gridBagConstraints4.fill = 2;
        jPanel.add((Component)a2.E, gridBagConstraints);
        gridBagConstraints3.gridy = 2;
        gridBagConstraints3.gridwidth = 1;
        jPanel2.add((Component)a2.g, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        jPanel2.add((Component)a2.B, gridBagConstraints);
        return jPanel2;
    }

    @Override
    public /* synthetic */ void d(String a2) {
        ba a3;
        a3.ALLATORIxDEMO.addElement(a2);
    }

    @Override
    public /* synthetic */ void D() {
        ba a2;
        a2.ALLATORIxDEMO.clear();
    }
}

