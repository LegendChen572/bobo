/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import client.MapleBuffStatValueHolder;
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
import tools.Pair;

public class GlobalDropHellAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JTextField d;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JButton e;
    private /* synthetic */ JButton H;
    private /* synthetic */ JLabel k;

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        GlobalDropHellAdder a3;
        a3.setVisible(false);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        GlobalDropHellAdder a3;
        Object[] arrobject = new Object[4];
        arrobject[0] = a3.K.getText().isEmpty() ? 0 : Integer.parseInt(a3.K.getText());
        arrobject[1] = a3.a.getText().isEmpty() ? 0 : Integer.parseInt(a3.a.getText());
        arrobject[2] = a3.d.getText().isEmpty() ? 0 : Integer.parseInt(a3.d.getText());
        arrobject[3] = a3.ALLATORIxDEMO.getText().isEmpty() ? 0 : Integer.parseInt(a3.ALLATORIxDEMO.getText());
        WvsCenter.getInstance().AddGlobalDropHell(arrobject);
        a3.setVisible(false);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        GlobalDropHellAdder a2;
        GlobalDropHellAdder globalDropHellAdder = a2;
        GlobalDropHellAdder globalDropHellAdder2 = a2;
        GlobalDropHellAdder globalDropHellAdder3 = a2;
        globalDropHellAdder2.g = new JLabel();
        globalDropHellAdder3.B = new JLabel();
        globalDropHellAdder2.k = new JLabel();
        globalDropHellAdder2.a = new JTextField();
        globalDropHellAdder2.d = new JTextField();
        globalDropHellAdder2.ALLATORIxDEMO = new JTextField();
        globalDropHellAdder2.H = new JButton();
        globalDropHellAdder2.e = new JButton();
        globalDropHellAdder2.E = new JLabel();
        a2.K = new JTextField();
        globalDropHellAdder.setDefaultCloseOperation(3);
        a2.g.setText(Pair.ALLATORIxDEMO("\u63ed\u8421\u6a3b\u739b"));
        globalDropHellAdder.B.setText(MapleBuffStatValueHolder.ALLATORIxDEMO("\u6740\u5977\u63c9\u846d\u6538"));
        globalDropHellAdder.k.setText(Pair.ALLATORIxDEMO("\u671c\u5c6b\u6395\u8459\u6564"));
        globalDropHellAdder.H.setText(MapleBuffStatValueHolder.ALLATORIxDEMO("\u65e0\u58de"));
        globalDropHellAdder.H.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.GlobalDropHellAdder.this.H(a2);
            }
        });
        globalDropHellAdder.e.setText("\u53d6\u6d88");
        globalDropHellAdder.e.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.GlobalDropHellAdder.this.ALLATORIxDEMO(a2);
            }
        });
        globalDropHellAdder.E.setText(Pair.ALLATORIxDEMO("\u720d\u54dd\u4e87\u78a0"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        globalDropHellAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout3.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout3.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g).addComponent(a2.B)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.K, -2, 90, -2)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.H, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.ALLATORIxDEMO, -2, 90, -2))).addGap(0, 0, 32767))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.e)).addContainerGap(-1, 32767)));
        globalDropHellAdder.pack();
    }

    public /* synthetic */ GlobalDropHellAdder() {
        GlobalDropHellAdder a2;
        GlobalDropHellAdder globalDropHellAdder = a2;
        globalDropHellAdder.ALLATORIxDEMO();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleBuffStatValueHolder.ALLATORIxDEMO("JscscscscscscscscscscscscscscscscscscscscscscscscZcp`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`sJs`p`p`p`pcs`s`p`s`p`pcs`scs`scs`scp`scs`p`p`p`pcZcp`p`p`pcpcpcp`pcp`pcpcp`s`pcpcpcpcp`s`p`p`p`p`sJs`p`p`p`scs`s`p`s`p`scs`pcp`s`s`scp`pcp`p`p`p`pcZcp`p`p`pcpcpcscpcscpcpcp`s`pcscpcpcpcscp`p`p`p`sJs`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`pcZcp\u000f2&%33!$)?.p\")`\u0011,<!$/\")p\u000f2&%33!$/\"`&w~sp\u0004\u0015\r\u001f`sJs`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`pcZcp`p`p`p`p`p($4 z\u007fo'7'n1,<!$/\")~#?-p`p`p`p`p`p`sJs`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`p`pcZcscscscscscscscscscscscscscscscscscscscscscscscsJ"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!Pair.ALLATORIxDEMO("*u\t~\u0011o").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(GlobalDropHellAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(GlobalDropHellAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(GlobalDropHellAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(GlobalDropHellAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new GlobalDropHellAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    public /* synthetic */ void init() {
        GlobalDropHellAdder a2;
        GlobalDropHellAdder globalDropHellAdder = a2;
        globalDropHellAdder.a.setText("");
        globalDropHellAdder.d.setText("");
        globalDropHellAdder.ALLATORIxDEMO.setText("");
        globalDropHellAdder.K.setText("");
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        GlobalDropHellAdder a3;
        GlobalDropHellAdder globalDropHellAdder = a3;
        globalDropHellAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        GlobalDropHellAdder globalDropHellAdder2 = a3;
        globalDropHellAdder2.setLocation((int)(dimension.getWidth() - (double)globalDropHellAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }
}

