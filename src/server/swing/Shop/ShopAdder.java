/*
 * Decompiled with CFR 0.150.
 */
package server.swing.Shop;

import client.ClientRedirector;
import constants.skills.SkillType;
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

public class ShopAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JTextField d;
    private /* synthetic */ JButton e;
    private /* synthetic */ JButton H;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JLabel E;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(ClientRedirector.ALLATORIxDEMO("?g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016N\u0016d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015g?g\u0015d\u0015d\u0015d\u0015d\u0016g\u0015g\u0015d\u0015g\u0015d\u0015d\u0016g\u0015g\u0016g\u0015g\u0016g\u0015g\u0016d\u0015g\u0016g\u0015d\u0015d\u0015d\u0015d\u0016N\u0016d\u0015d\u0015d\u0015d\u0016d\u0016d\u0016d\u0015d\u0016d\u0015d\u0016d\u0016d\u0015g\u0015d\u0016d\u0016d\u0016d\u0016d\u0015g\u0015d\u0015d\u0015d\u0015d\u0015g?g\u0015d\u0015d\u0015d\u0015g\u0016g\u0015g\u0015d\u0015g\u0015d\u0015g\u0016g\u0015d\u0016d\u0015g\u0015g\u0015g\u0016d\u0015d\u0016d\u0015d\u0015d\u0015d\u0015d\u0016N\u0016d\u0015d\u0015d\u0015d\u0016d\u0016d\u0016g\u0016d\u0016g\u0016d\u0016d\u0016d\u0015g\u0015d\u0016g\u0016d\u0016d\u0016d\u0016g\u0016d\u0015d\u0015d\u0015d\u0015g?g\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0016N\u0016dz&S1F'T0\\+[dW=\u0015\u0005Y(T0Z6\\dz&S1F'T0Z6\u00152\u0002j\u0006dq\u0001x\u000b\u0015g?g\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0016N\u0016d\u0015d\u0015d\u0015d\u0015d\u0015d]0A4\u000fk\u001a3B3\u001b%Y(T0Z6\\jV+Xd\u0015d\u0015d\u0015d\u0015d\u0015d\u0015g?g\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0015d\u0016N\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g\u0016g?"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!SkillType.ALLATORIxDEMO("jZIQQ@").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(ShopAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(ShopAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(ShopAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(ShopAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new ShopAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        ShopAdder a3;
        a3.setVisible(false);
    }

    public /* synthetic */ boolean isEmpty() {
        ShopAdder a2;
        return a2.K.getText().isEmpty() || a2.a.getText().isEmpty() || a2.d.getText().isEmpty() || a2.ALLATORIxDEMO.getText().isEmpty();
    }

    public /* synthetic */ ShopAdder() {
        ShopAdder a2;
        ShopAdder shopAdder = a2;
        shopAdder.ALLATORIxDEMO();
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        ShopAdder a2;
        ShopAdder shopAdder = a2;
        ShopAdder shopAdder2 = a2;
        ShopAdder shopAdder3 = a2;
        shopAdder2.g = new JLabel();
        shopAdder3.B = new JLabel();
        shopAdder2.a = new JTextField();
        shopAdder2.d = new JTextField();
        shopAdder2.H = new JButton();
        shopAdder2.e = new JButton();
        shopAdder2.E = new JLabel();
        shopAdder2.K = new JTextField();
        shopAdder2.ALLATORIxDEMO = new JTextField();
        a2.k = new JLabel();
        shopAdder.setDefaultCloseOperation(3);
        a2.g.setText(ClientRedirector.ALLATORIxDEMO("\u722d\u54f4\u50bd\u6809"));
        shopAdder.B.setText(SkillType.ALLATORIxDEMO("\u9724\u6c71\u724d\u54f2"));
        shopAdder.d.setText(ClientRedirector.ALLATORIxDEMO("\u0005"));
        shopAdder.H.setText(SkillType.ALLATORIxDEMO("\u6594\u58ad"));
        shopAdder.H.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.ShopAdder.this.H(a2);
            }
            {
                1 a3;
            }
        });
        shopAdder.e.setText("\u53d6\u6d88");
        shopAdder.e.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.ShopAdder.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        shopAdder.E.setText(ClientRedirector.ALLATORIxDEMO("\u722d\u54f4\u4ea7\u7889"));
        shopAdder.ALLATORIxDEMO.setText(SkillType.ALLATORIxDEMO("\u0003"));
        shopAdder.k.setText(ClientRedirector.ALLATORIxDEMO("\u9744\u6c77\u653c\u91fa"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        shopAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g).addComponent(a2.B)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.K, -2, 90, -2)))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.ALLATORIxDEMO, -2, 90, -2))).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.H, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e, -2, 74, -2).addContainerGap(-1, 32767)));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.e)).addContainerGap(-1, 32767)));
        shopAdder.pack();
    }

    public /* synthetic */ void init() {
        ShopAdder a2;
        ShopAdder shopAdder = a2;
        shopAdder.a.setText("");
        shopAdder.K.setText("");
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        ShopAdder a3;
        ShopAdder shopAdder = a3;
        shopAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        ShopAdder shopAdder2 = a3;
        shopAdder2.setLocation((int)(dimension.getWidth() - (double)shopAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        ShopAdder shopAdder;
        ShopAdder a3;
        if (!a3.isEmpty()) {
            Object[] arrobject = new Object[4];
            arrobject[0] = Integer.parseInt(a3.K.getText());
            arrobject[1] = Integer.parseInt(a3.a.getText());
            arrobject[2] = Integer.parseInt(a3.d.getText());
            arrobject[3] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
            WvsCenter.getInstance().AddShopItem(arrobject);
            shopAdder = a3;
        } else {
            JOptionPane.showMessageDialog(null, SkillType.ALLATORIxDEMO("\u673a\u5714\u658a\u670e\u8f0b\u5141\u0012"));
            shopAdder = a3;
        }
        shopAdder.setVisible(false);
    }
}

