/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5976\u8336\u8c37
 */
package server.swing.Reward;

import client.inventory.MapleAndroid;
import client.messages.commands.player.\u5976\u8336\u8c37;
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

public class RewardAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JTextField a;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JButton H;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JButton e;

    public /* synthetic */ RewardAdder() {
        RewardAdder a2;
        RewardAdder rewardAdder = a2;
        rewardAdder.ALLATORIxDEMO();
    }

    private /* synthetic */ void H(ActionEvent a2) {
        RewardAdder rewardAdder;
        RewardAdder a3;
        if (!a3.isEmpty()) {
            Object[] arrobject = new Object[4];
            arrobject[0] = Integer.parseInt(a3.K.getText());
            arrobject[1] = Integer.parseInt(a3.a.getText());
            arrobject[2] = Integer.parseInt(a3.d.getText());
            arrobject[3] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
            WvsCenter.getInstance().AddRewardItem(arrobject);
            rewardAdder = a3;
        } else {
            JOptionPane.showMessageDialog(null, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u6758\u5729\u65e8\u6733\u8f69\u517cp"));
            rewardAdder = a3;
        }
        rewardAdder.setVisible(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleAndroid.ALLATORIxDEMO("\u001dP4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4y4S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7P\u001dP7S7S7S7S4P7P7S7P7S7S4P7P4P7P4P7P4S7P4P7S7S7S7S4y4S7S7S7S4S4S4S7S4S7S4S4S7P7S4S4S4S4S7P7S7S7S7S7P\u001dP7S7S7S7P4P7P7S7P7S7P4P7S4S7P7P7P4S7S4S7S7S7S7S4y4S7S7S7S4S4S4P4S4P4S4S4S7P7S4P4S4S4S4P4S7S7S7S7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4SX\u0011q\u0006d\u0010v\u0007~\u001cySu\n72{\u001fv\u0007x\u0001~SX\u0011q\u0006d\u0010v\u0007x\u00017\u0005 ]$SS6Z<7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4S7S7S7S7S7S\u007f\u0007c\u0003-\\8\u0004`\u00049\u0012{\u001fv\u0007x\u0001~]t\u001czS7S7S7S7S7S7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P\u001d"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!\u5976\u8336\u8c37.ALLATORIxDEMO((String)"W8t3l\"").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(RewardAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(RewardAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(RewardAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(RewardAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new RewardAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        RewardAdder a3;
        RewardAdder rewardAdder = a3;
        rewardAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        RewardAdder rewardAdder2 = a3;
        rewardAdder2.setLocation((int)(dimension.getWidth() - (double)rewardAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        RewardAdder a2;
        RewardAdder rewardAdder = a2;
        RewardAdder rewardAdder2 = a2;
        RewardAdder rewardAdder3 = a2;
        rewardAdder2.g = new JLabel();
        rewardAdder3.B = new JLabel();
        rewardAdder2.a = new JTextField();
        rewardAdder2.d = new JTextField();
        rewardAdder2.H = new JButton();
        rewardAdder2.e = new JButton();
        rewardAdder2.E = new JLabel();
        rewardAdder2.K = new JTextField();
        rewardAdder2.ALLATORIxDEMO = new JTextField();
        a2.k = new JLabel();
        rewardAdder.setDefaultCloseOperation(3);
        a2.g.setText(MapleAndroid.ALLATORIxDEMO("\u62ce\u4e3a\u6a2c\u7390"));
        rewardAdder.B.setText(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u6719\u5976\u6561\u919e"));
        rewardAdder.H.setText(MapleAndroid.ALLATORIxDEMO("\u65c3\u5889"));
        rewardAdder.H.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.RewardAdder.this.H(a2);
            }
            {
                1 a3;
            }
        });
        rewardAdder.e.setText("\u53d6\u6d88");
        rewardAdder.e.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.RewardAdder.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        rewardAdder.E.setText(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u7270\u5490\u4efa\u78ed"));
        rewardAdder.k.setText(MapleAndroid.ALLATORIxDEMO("\u6773\u5c18\u650b\u91d8"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        rewardAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g).addComponent(a2.B)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.K, -2, 90, -2)))).addGroup(groupLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(a2.H, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.e, -2, 74, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.ALLATORIxDEMO, -2, 90, -2))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.e)).addContainerGap(-1, 32767)));
        rewardAdder.pack();
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        RewardAdder a3;
        a3.setVisible(false);
    }

    public /* synthetic */ void init() {
        RewardAdder a2;
        RewardAdder rewardAdder = a2;
        rewardAdder.a.setText("");
        rewardAdder.d.setText("");
        rewardAdder.K.setText("");
    }

    public /* synthetic */ boolean isEmpty() {
        RewardAdder a2;
        return a2.K.getText().isEmpty() || a2.a.getText().isEmpty() || a2.d.getText().isEmpty() || a2.ALLATORIxDEMO.getText().isEmpty();
    }
}

