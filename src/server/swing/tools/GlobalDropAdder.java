/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.life.ItemDropEntry;
import server.swing.UIWindow;
import server.swing.WvsCenter;
import tools.googledrive.SyncServerData;

public class GlobalDropAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JTextField K;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JButton e;
    private /* synthetic */ JButton H;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JLabel B;

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        GlobalDropAdder a3;
        GlobalDropAdder globalDropAdder = a3;
        globalDropAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        GlobalDropAdder globalDropAdder2 = a3;
        globalDropAdder2.setLocation((int)(dimension.getWidth() - (double)globalDropAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        GlobalDropAdder a2;
        GlobalDropAdder globalDropAdder = a2;
        GlobalDropAdder globalDropAdder2 = a2;
        GlobalDropAdder globalDropAdder3 = a2;
        globalDropAdder2.g = new JLabel();
        globalDropAdder3.B = new JLabel();
        globalDropAdder2.k = new JLabel();
        globalDropAdder2.a = new JTextField();
        globalDropAdder2.d = new JTextField();
        globalDropAdder2.ALLATORIxDEMO = new JTextField();
        globalDropAdder2.H = new JButton();
        globalDropAdder2.e = new JButton();
        globalDropAdder2.E = new JLabel();
        a2.K = new JTextField();
        globalDropAdder.setDefaultCloseOperation(3);
        a2.g.setText(SyncServerData.ALLATORIxDEMO("\u63fc\u8437\u6a2a\u738d"));
        globalDropAdder.B.setText(ItemDropEntry.ALLATORIxDEMO("\u671a\u592a\u6393\u8430\u6562"));
        globalDropAdder.k.setText(SyncServerData.ALLATORIxDEMO("\u670a\u5c7a\u6383\u8448\u6572"));
        globalDropAdder.H.setText(ItemDropEntry.ALLATORIxDEMO("\u65bd\u5884"));
        globalDropAdder.H.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.GlobalDropAdder.this.H(a2);
            }
            {
                1 a3;
            }
        });
        globalDropAdder.e.setText("\u53d6\u6d88");
        globalDropAdder.e.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.GlobalDropAdder.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        globalDropAdder.E.setText(SyncServerData.ALLATORIxDEMO("\u721c\u54cb\u4e96\u78b6"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        globalDropAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout3.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout3.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g).addComponent(a2.B)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.K, -2, 90, -2)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.H, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.ALLATORIxDEMO, -2, 90, -2))).addGap(0, 0, 32767))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.e)).addContainerGap(-1, 32767)));
        globalDropAdder.pack();
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        GlobalDropAdder a3;
        a3.setVisible(false);
    }

    public /* synthetic */ GlobalDropAdder() {
        GlobalDropAdder a2;
        GlobalDropAdder globalDropAdder = a2;
        globalDropAdder.ALLATORIxDEMO();
    }

    private /* synthetic */ void H(ActionEvent a2) {
        GlobalDropAdder a3;
        Object[] arrobject = new Object[4];
        arrobject[0] = a3.K.getText().isEmpty() ? 0 : Integer.parseInt(a3.K.getText());
        arrobject[1] = a3.a.getText().isEmpty() ? 0 : Integer.parseInt(a3.a.getText());
        arrobject[2] = a3.d.getText().isEmpty() ? 0 : Integer.parseInt(a3.d.getText());
        arrobject[3] = a3.ALLATORIxDEMO.getText().isEmpty() ? 0 : Integer.parseInt(a3.ALLATORIxDEMO.getText());
        WvsCenter.getInstance().AddGlobalDrop(arrobject);
        a3.setVisible(false);
    }

    public /* synthetic */ void init() {
        GlobalDropAdder a2;
        GlobalDropAdder globalDropAdder = a2;
        globalDropAdder.a.setText("");
        globalDropAdder.d.setText("");
        globalDropAdder.ALLATORIxDEMO.setText("");
        globalDropAdder.K.setText("");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(ItemDropEntry.ALLATORIxDEMO("\u0010.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9\u00079-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:.\u0010.:-:-:-:-9.:.:-:.:-:-9.:.9.:.9.:.9-:.9.:-:-:-:-9\u00079-:-:-:-9-9-9-:-9-:-9-9-:.:-9-9-9-9-:.:-:-:-:-:.\u0010.:-:-:-:.9.:.:-:.:-:.9.:-9-:.:.:.9-:-9-:-:-:-:-9\u00079-:-:-:-9-9-9.9-9.9-9-9-:.:-9.9-9-9-9.9-:-:-:-:.\u0010.:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-9\u00079-Uo|xin{ysbt-xt:Lva{yu\u007fs-Uo|xin{yu\u007f:{-#)-^HWB:.\u0010.:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-9\u00079-:-:-:-:-:-ryn} \"5zmz4lva{yu\u007fs#ybw-:-:-:-:-:-:.\u0010.:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-9\u00079.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.9.\u0010"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!SyncServerData.ALLATORIxDEMO(";c\u0018h\u0000y").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(GlobalDropAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(GlobalDropAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(GlobalDropAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(GlobalDropAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new GlobalDropAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }
}

