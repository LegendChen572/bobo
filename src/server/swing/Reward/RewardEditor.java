/*
 * Decompiled with CFR 0.150.
 */
package server.swing.Reward;

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
import server.life.MonsterDropEntry;
import server.maps.MapleMapEffect;
import server.swing.UIWindow;
import server.swing.WvsCenter;

public class RewardEditor
extends JFrame
implements UIWindow {
    private /* synthetic */ JTextField K;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel H;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JButton C;
    private /* synthetic */ JLabel e;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JButton F;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JTextField d;

    public /* synthetic */ RewardEditor() {
        RewardEditor a2;
        RewardEditor rewardEditor = a2;
        rewardEditor.ALLATORIxDEMO();
    }

    public /* synthetic */ boolean isEmpty() {
        RewardEditor a2;
        return a2.K.getText().isEmpty() || a2.a.getText().isEmpty() || a2.d.getText().isEmpty() || a2.ALLATORIxDEMO.getText().isEmpty();
    }

    private /* synthetic */ void H(ActionEvent a2) {
        RewardEditor rewardEditor;
        RewardEditor a3;
        if (!a3.isEmpty()) {
            Object[] arrobject = new Object[4];
            arrobject[0] = Integer.parseInt(a3.K.getText());
            arrobject[1] = Integer.parseInt(a3.a.getText());
            arrobject[2] = Integer.parseInt(a3.d.getText());
            arrobject[3] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
            WvsCenter.getInstance().UpdateRewardItem(arrobject);
            rewardEditor = a3;
        } else {
            JOptionPane.showMessageDialog(null, MapleMapEffect.ALLATORIxDEMO("\u6747\u5707\u65f7\u671d\u8f76\u5152o"));
            rewardEditor = a3;
        }
        rewardEditor.setVisible(false);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        RewardEditor a2;
        RewardEditor rewardEditor = a2;
        RewardEditor rewardEditor2 = a2;
        RewardEditor rewardEditor3 = a2;
        rewardEditor2.H = new JLabel();
        rewardEditor3.E = new JLabel();
        rewardEditor2.g = new JLabel();
        rewardEditor2.k = new JTextField();
        rewardEditor2.a = new JTextField();
        rewardEditor2.d = new JTextField();
        rewardEditor2.F = new JButton();
        rewardEditor2.C = new JButton();
        rewardEditor2.e = new JLabel();
        rewardEditor2.K = new JTextField();
        rewardEditor2.B = new JLabel();
        a2.ALLATORIxDEMO = new JTextField();
        rewardEditor.setDefaultCloseOperation(3);
        a2.H.setText(MapleMapEffect.ALLATORIxDEMO("\u725e\u548f\u543a\u7a7f"));
        rewardEditor.E.setText(MonsterDropEntry.ALLATORIxDEMO("\u6282\u4e1a\u6a60\u73b0"));
        rewardEditor.g.setText(MapleMapEffect.ALLATORIxDEMO("\u6737\u5c41\u654f\u9181"));
        rewardEditor.F.setText(MonsterDropEntry.ALLATORIxDEMO("\u4fd1\u650e"));
        rewardEditor.F.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.RewardEditor.this.H(a2);
            }
        });
        rewardEditor.C.setText("\u53d6\u6d88");
        rewardEditor.C.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.RewardEditor.this.ALLATORIxDEMO(a2);
            }
        });
        rewardEditor.e.setText(MapleMapEffect.ALLATORIxDEMO("\u725e\u548f\u4ed4\u78f2"));
        rewardEditor.B.setText(MonsterDropEntry.ALLATORIxDEMO("\u673f\u5910\u6547\u91f8"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        rewardEditor.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.E).addComponent(a2.g)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.H).addComponent(a2.e)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.K, -2, 90, -2).addComponent(a2.k, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.F, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.C, -1, -1, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.B).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addComponent(a2.ALLATORIxDEMO, -2, 90, -2))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.k, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.e).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.F).addComponent(a2.C)).addContainerGap()));
        rewardEditor.pack();
    }

    public /* synthetic */ void setReward(Object[] a2) {
        RewardEditor a3;
        if (a2 == null || a2.length < 4) {
            return;
        }
        RewardEditor rewardEditor = a3;
        rewardEditor.K.setText(String.valueOf(a2[0]));
        rewardEditor.k.setText(String.valueOf(a2[1]));
        rewardEditor.a.setText(String.valueOf(a2[2]));
        rewardEditor.d.setText(String.valueOf(a2[3]));
        rewardEditor.ALLATORIxDEMO.setText(String.valueOf(a2[4]));
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        RewardEditor a3;
        a3.setVisible(false);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        RewardEditor a3;
        RewardEditor rewardEditor = a3;
        rewardEditor.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        RewardEditor rewardEditor2 = a3;
        rewardEditor2.setLocation((int)(dimension.getWidth() - (double)rewardEditor2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MonsterDropEntry.ALLATORIxDEMO("=\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u00145\u0014\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001c=\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0014\u001c\u0017\u001c\u0017\u001f\u0017\u001c\u0017\u001f\u0017\u001f\u0014\u001c\u0017\u001c\u0014\u001c\u0017\u001c\u0014\u001c\u0017\u001c\u0014\u001f\u0017\u001c\u0014\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u00145\u0014\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0014\u001f\u0014\u001f\u0014\u001f\u0017\u001f\u0014\u001f\u0017\u001f\u0014\u001f\u0014\u001f\u0017\u001c\u0017\u001f\u0014\u001f\u0014\u001f\u0014\u001f\u0014\u001f\u0017\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001c=\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001c\u0014\u001c\u0017\u001c\u0017\u001f\u0017\u001c\u0017\u001f\u0017\u001c\u0014\u001c\u0017\u001f\u0014\u001f\u0017\u001c\u0017\u001c\u0017\u001c\u0014\u001f\u0017\u001f\u0014\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u00145\u0014\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0014\u001f\u0014\u001f\u0014\u001c\u0014\u001f\u0014\u001c\u0014\u001f\u0014\u001f\u0014\u001f\u0017\u001c\u0017\u001f\u0014\u001c\u0014\u001f\u0014\u001f\u0014\u001f\u0014\u001c\u0014\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001c=\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u00145\u0014\u001fx]QJD\\VK^PY\u001fUF\u0017~[SVKXM^\u001fx]QJD\\VKXM\u0017I\u0000\u0011\u0004\u001fszzp\u0017\u001c=\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u00145\u0014\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f_KCO\r\u0010\u0018H@H\u0019^[SVKXM^\u0011TPZ\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001c=\u001c\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u0017\u001f\u00145\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c\u0014\u001c="));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleMapEffect.ALLATORIxDEMO("y'Z,B=").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(RewardEditor.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(RewardEditor.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(RewardEditor.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(RewardEditor.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new RewardEditor().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    public /* synthetic */ void init() {
        RewardEditor a2;
        RewardEditor rewardEditor = a2;
        rewardEditor.k.setText("");
        rewardEditor.a.setText("");
        rewardEditor.d.setText("");
        rewardEditor.K.setText("");
    }
}

