/*
 * Decompiled with CFR 0.150.
 */
package server.swing.Drop;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.swing.UIWindow;
import server.swing.WvsCenter;
import tools.database.CashShopConvert;
import tools.wztosql.DumpMobName;

public class DropAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JLabel E;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JButton C;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JLabel e;
    private /* synthetic */ JLabel H;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JButton F;
    private /* synthetic */ JTextField K;

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        DropAdder a3;
        a3.setVisible(false);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        DropAdder dropAdder;
        DropAdder a3;
        if (!a3.isEmpty()) {
            Object[] arrobject = new Object[5];
            arrobject[0] = Integer.parseInt(a3.k.getText());
            arrobject[1] = Integer.parseInt(a3.K.getText());
            arrobject[2] = Integer.parseInt(a3.a.getText());
            arrobject[3] = Integer.parseInt(a3.d.getText());
            arrobject[4] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
            WvsCenter.getInstance().AddDropItem(arrobject);
            dropAdder = a3;
        } else {
            JOptionPane.showMessageDialog(null, CashShopConvert.ALLATORIxDEMO("\u674c\u575d\u65fc\u6747\u8f7d\u5108d"));
            dropAdder = a3;
        }
        dropAdder.setVisible(false);
    }

    public /* synthetic */ boolean isEmpty() {
        DropAdder a2;
        return a2.k.getText().isEmpty() || a2.K.getText().isEmpty() || a2.a.getText().isEmpty() || a2.d.getText().isEmpty() || a2.ALLATORIxDEMO.getText().isEmpty();
    }

    public /* synthetic */ DropAdder() {
        DropAdder a2;
        DropAdder dropAdder = a2;
        dropAdder.ALLATORIxDEMO();
    }

    public /* synthetic */ void init() {
        DropAdder a2;
        DropAdder dropAdder = a2;
        dropAdder.K.setText("");
        dropAdder.a.setText("");
        dropAdder.k.setText("");
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        DropAdder a2;
        DropAdder dropAdder = a2;
        DropAdder dropAdder2 = a2;
        DropAdder dropAdder3 = a2;
        dropAdder2.e = new JLabel();
        dropAdder3.E = new JLabel();
        dropAdder2.K = new JTextField();
        dropAdder2.a = new JTextField();
        dropAdder2.F = new JButton();
        dropAdder2.C = new JButton();
        dropAdder2.H = new JLabel();
        dropAdder2.k = new JTextField();
        dropAdder2.d = new JTextField();
        dropAdder2.g = new JLabel();
        dropAdder2.B = new JLabel();
        a2.ALLATORIxDEMO = new JTextField();
        dropAdder.setDefaultCloseOperation(3);
        a2.e.setText(CashShopConvert.ALLATORIxDEMO("\u63e4\u8478\u6a32\u73c2"));
        dropAdder.E.setText(DumpMobName.ALLATORIxDEMO("\u6750\u5932\u6528\u91da"));
        dropAdder.K.setText(CashShopConvert.ALLATORIxDEMO("\\u]u]u"));
        dropAdder.a.setText("1");
        dropAdder.F.setText(DumpMobName.ALLATORIxDEMO("\u65e0\u588b"));
        dropAdder.F.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.DropAdder.this.H(a2);
            }
        });
        dropAdder.C.setText("\u53d6\u6d88");
        dropAdder.C.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.DropAdder.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        dropAdder.H.setText(CashShopConvert.ALLATORIxDEMO("\u7204\u5484\u4e8e\u78f9"));
        dropAdder.d.setText("1");
        dropAdder.g.setText(DumpMobName.ALLATORIxDEMO("\u6750\u5c1a\u6528\u91da"));
        dropAdder.B.setText(CashShopConvert.ALLATORIxDEMO("\u4e96\u529c\u4e8e\u78f9"));
        dropAdder.ALLATORIxDEMO.setText(DumpMobName.ALLATORIxDEMO("%"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        dropAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.e).addComponent(a2.E)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.K, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.k, -2, 90, -2)))).addGroup(groupLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(a2.F, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.C, -2, 74, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.g).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.d, -2, 90, -2)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.B).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.ALLATORIxDEMO, -2, 90, -2))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.k, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.e).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.F).addComponent(a2.C)).addContainerGap()));
        dropAdder.pack();
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        DropAdder a3;
        DropAdder dropAdder = a3;
        dropAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        DropAdder dropAdder2 = a3;
        dropAdder2.setLocation((int)(dimension.getWidth() - (double)dropAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(DumpMobName.ALLATORIxDEMO("\u001fs6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6Z6p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5s\u001fs5p5p5p5p6s5s5p5s5p5p6s5s6s5s6s5s6p5s6s5p5p5p5p6Z6p5p5p5p6p6p6p5p6p5p6p6p5s5p6p6p6p6p5s5p5p5p5p5s\u001fs5p5p5p5s6s5s5p5s5p5s6s5p6p5s5s5s6p5p6p5p5p5p5p6Z6p5p5p5p6p6p6s6p6s6p6p6p5s5p6s6p6p6p6s6p5p5p5p5s\u001fs5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p6Z6pZ2s%f3t$|?{pw)5\u0011y<t$z\"|pZ2s%f3t$z\"5&\"~&pQ\u0015X\u001f5s\u001fs5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p6Z6p5p5p5p5p5p}$a /\u007f:'b';1y<t$z\"|~v?xp5p5p5p5p5p5s\u001fs5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p5p6Z6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s6s\u001f"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!CashShopConvert.ALLATORIxDEMO("#,\u0000'\u00186").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(DropAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(DropAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(DropAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(DropAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new DropAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }
}

