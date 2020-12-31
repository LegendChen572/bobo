/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import client.messages.commands.player.eventSystem.BankSystem;
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
import server.swing.UIWindow;
import server.swing.WvsCenter;
import tools.data.LittleEndianAccessor;

public class GlobalDropHellEditor
extends JFrame
implements UIWindow {
    private /* synthetic */ JTextField d;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JLabel e;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JLabel H;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton C;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JButton F;

    public /* synthetic */ void init() {
        GlobalDropHellEditor a2;
        GlobalDropHellEditor globalDropHellEditor = a2;
        globalDropHellEditor.k.setText("");
        globalDropHellEditor.a.setText("");
        globalDropHellEditor.d.setText("");
        globalDropHellEditor.ALLATORIxDEMO.setText("");
        globalDropHellEditor.K.setText("");
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        GlobalDropHellEditor a3;
        a3.setVisible(false);
    }

    public /* synthetic */ void setGlobalDropHell(Object[] a2) {
        GlobalDropHellEditor a3;
        if (a2 == null || a2.length < 5) {
            return;
        }
        GlobalDropHellEditor globalDropHellEditor = a3;
        globalDropHellEditor.k.setText(String.valueOf(a2[0]));
        globalDropHellEditor.K.setText(String.valueOf(a2[1]));
        globalDropHellEditor.a.setText(String.valueOf(a2[2]));
        globalDropHellEditor.d.setText(String.valueOf(a2[3]));
        globalDropHellEditor.ALLATORIxDEMO.setText(String.valueOf(a2[4]));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(LittleEndianAccessor.ALLATORIxDEMO("'7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e\u001e\u000e4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r7'7\r4\r4\r4\r4\u000e7\r7\r4\r7\r4\r4\u000e7\r7\u000e7\r7\u000e7\r7\u000e4\r7\u000e7\r4\r4\r4\r4\u000e\u001e\u000e4\r4\r4\r4\u000e4\u000e4\u000e4\r4\u000e4\r4\u000e4\u000e4\r7\r4\u000e4\u000e4\u000e4\u000e4\r7\r4\r4\r4\r4\r7'7\r4\r4\r4\r7\u000e7\r7\r4\r7\r4\r7\u000e7\r4\u000e4\r7\r7\r7\u000e4\r4\u000e4\r4\r4\r4\r4\u000e\u001e\u000e4\r4\r4\r4\u000e4\u000e4\u000e7\u000e4\u000e7\u000e4\u000e4\u000e4\r7\r4\u000e7\u000e4\u000e4\u000e4\u000e7\u000e4\r4\r4\r4\r7'7\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\u000e\u001e\u000e4bvKa^wL`D{C4Om\rUAxL`BfD4bvKa^wL`Bf\rb\u001a:\u001e4iQ`[\r7'7\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\u000e\u001e\u000e4\r4\r4\r4\r4\r4E`Yd\u0017;\u0002cZc\u0003uAxL`BfD:N{@4\r4\r4\r4\r4\r4\r7'7\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\r4\u000e\u001e\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7\u000e7'"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!BankSystem.ALLATORIxDEMO("=\u001e\u001e\u0015\u0006\u0004").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(GlobalDropHellEditor.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(GlobalDropHellEditor.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(GlobalDropHellEditor.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(GlobalDropHellEditor.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                3 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new GlobalDropHellEditor().setVisible(true);
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        GlobalDropHellEditor a2;
        GlobalDropHellEditor globalDropHellEditor = a2;
        GlobalDropHellEditor globalDropHellEditor2 = a2;
        GlobalDropHellEditor globalDropHellEditor3 = a2;
        globalDropHellEditor2.H = new JLabel();
        globalDropHellEditor3.E = new JLabel();
        globalDropHellEditor2.g = new JLabel();
        globalDropHellEditor2.B = new JLabel();
        globalDropHellEditor2.k = new JTextField();
        globalDropHellEditor2.a = new JTextField();
        globalDropHellEditor2.d = new JTextField();
        globalDropHellEditor2.ALLATORIxDEMO = new JTextField();
        globalDropHellEditor2.F = new JButton();
        globalDropHellEditor2.C = new JButton();
        globalDropHellEditor2.e = new JLabel();
        a2.K = new JTextField();
        globalDropHellEditor.setDefaultCloseOperation(3);
        a2.H.setText(LittleEndianAccessor.ALLATORIxDEMO("\u727d\u54ec\u5419\u7a1c"));
        globalDropHellEditor.E.setText(BankSystem.ALLATORIxDEMO("\u63fa\u844a\u6a2c\u73f0"));
        globalDropHellEditor.g.setText(LittleEndianAccessor.ALLATORIxDEMO("\u672d\u5933\u63a4\u8429\u6555"));
        globalDropHellEditor.B.setText(BankSystem.ALLATORIxDEMO("\u6777\u5c7c\u63fe\u844e\u650f"));
        globalDropHellEditor.F.setText(LittleEndianAccessor.ALLATORIxDEMO("\u4ffa\u6514"));
        globalDropHellEditor.F.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.GlobalDropHellEditor.this.H(a2);
            }
            {
                1 a3;
            }
        });
        globalDropHellEditor.C.setText("\u53d6\u6d88");
        globalDropHellEditor.C.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.GlobalDropHellEditor.this.ALLATORIxDEMO(a2);
            }
        });
        globalDropHellEditor.e.setText(BankSystem.ALLATORIxDEMO("\u721a\u54b6\u4e90\u78cb"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        globalDropHellEditor.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.B).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.ALLATORIxDEMO, -2, 90, -2).addGap(0, 0, 32767)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.E).addComponent(a2.g)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.H).addComponent(a2.e)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.K, -2, 90, -2).addComponent(a2.k, -2, 90, -2)).addContainerGap()))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.F, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.C, -1, -1, 32767).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.k, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.e).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.F).addComponent(a2.C)).addContainerGap(-1, 32767)));
        globalDropHellEditor.pack();
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        GlobalDropHellEditor a3;
        GlobalDropHellEditor globalDropHellEditor = a3;
        globalDropHellEditor.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        GlobalDropHellEditor globalDropHellEditor2 = a3;
        globalDropHellEditor2.setLocation((int)(dimension.getWidth() - (double)globalDropHellEditor2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        GlobalDropHellEditor a3;
        Object[] arrobject = new Object[4];
        arrobject[0] = Integer.parseInt(a3.K.getText());
        arrobject[1] = Integer.parseInt(a3.a.getText());
        arrobject[2] = Integer.parseInt(a3.d.getText());
        arrobject[3] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
        WvsCenter.getInstance().UpdateGlobalDropHell(arrobject);
        a3.setVisible(false);
    }

    public /* synthetic */ GlobalDropHellEditor() {
        GlobalDropHellEditor a2;
        GlobalDropHellEditor globalDropHellEditor = a2;
        globalDropHellEditor.ALLATORIxDEMO();
    }
}

