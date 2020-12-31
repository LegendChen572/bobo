/*
 * Decompiled with CFR 0.150.
 */
package server.swing.Gashapon;

import client.inventory.MapleRing;
import handling.world.CheaterData;
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

public class GashaponEditor
extends JFrame
implements UIWindow {
    private /* synthetic */ JLabel k;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JButton H;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton e;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField K;

    public /* synthetic */ GashaponEditor() {
        GashaponEditor a2;
        GashaponEditor gashaponEditor = a2;
        gashaponEditor.ALLATORIxDEMO();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(CheaterData.ALLATORIxDEMO("\u001f&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6\u000f6%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5&\u001f&5%5%5%5%6&5&5%5&5%5%6&5&6&5&6&5&6%5&6&5%5%5%5%6\u000f6%5%5%5%6%6%6%5%6%5%6%6%5&5%6%6%6%6%5&5%5%5%5%5&\u001f&5%5%5%5&6&5&5%5&5%5&6&5%6%5&5&5&6%5%6%5%5%5%5%6\u000f6%5%5%5%6%6%6&6%6&6%6%6%5&5%6&6%6%6%6&6%5%5%5%5&\u001f&5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%6\u000f6%Zgspfftq|j{%w|5Dyitqzw|%Zgspfftqzw5s\"+&%Q@XJ5&\u001f&5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%6\u000f6%5%5%5%5%5%}qau/*:rbr;dyitqzw|+vjx%5%5%5%5%5%5&\u001f&5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%5%6\u000f6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&6&\u001f"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleRing.ALLATORIxDEMO("T5w>o/").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(GashaponEditor.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(GashaponEditor.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(GashaponEditor.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(GashaponEditor.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new GashaponEditor().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    public /* synthetic */ void setGashapon(Object[] a2) {
        GashaponEditor a3;
        if (a2 == null || a2.length < 4) {
            return;
        }
        GashaponEditor gashaponEditor = a3;
        gashaponEditor.a.setText(String.valueOf(a2[0]));
        gashaponEditor.K.setText(String.valueOf(a2[1]));
        gashaponEditor.d.setText(String.valueOf(a2[2]));
        gashaponEditor.ALLATORIxDEMO.setText(String.valueOf(a2[3]));
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        GashaponEditor a2;
        GashaponEditor gashaponEditor = a2;
        GashaponEditor gashaponEditor2 = a2;
        GashaponEditor gashaponEditor3 = a2;
        gashaponEditor2.E = new JLabel();
        gashaponEditor3.B = new JLabel();
        gashaponEditor2.k = new JLabel();
        gashaponEditor2.K = new JTextField();
        gashaponEditor2.d = new JTextField();
        gashaponEditor2.ALLATORIxDEMO = new JTextField();
        gashaponEditor2.H = new JButton();
        gashaponEditor2.e = new JButton();
        gashaponEditor2.g = new JLabel();
        a2.a = new JTextField();
        gashaponEditor.setDefaultCloseOperation(3);
        a2.E.setText(MapleRing.ALLATORIxDEMO("\u7273\u549d\u5417\u7a6d"));
        gashaponEditor.B.setText(CheaterData.ALLATORIxDEMO("\u8f4c\u86de\u6a5a\u7392"));
        gashaponEditor.k.setText(MapleRing.ALLATORIxDEMO("\u6635\u547a\u4e10\u5ebf"));
        gashaponEditor.H.setText(CheaterData.ALLATORIxDEMO("\u4feb\u652c"));
        gashaponEditor.H.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.GashaponEditor.this.H(a2);
            }
            {
                1 a3;
            }
        });
        gashaponEditor.e.setText("\u53d6\u6d88");
        gashaponEditor.e.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.GashaponEditor.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        gashaponEditor.g.setText(MapleRing.ALLATORIxDEMO("\u7273\u549d\u4ef9\u78e0"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        gashaponEditor.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e, -1, -1, 32767)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.B).addComponent(a2.k)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.ALLATORIxDEMO, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.E).addComponent(a2.g)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, -2, 90, -2).addComponent(a2.K, -2, 90, -2)))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.e)).addContainerGap(-1, 32767)));
        gashaponEditor.pack();
    }

    public /* synthetic */ void init() {
        GashaponEditor a2;
        GashaponEditor gashaponEditor = a2;
        gashaponEditor.K.setText("");
        gashaponEditor.d.setText("");
        gashaponEditor.ALLATORIxDEMO.setText("");
        gashaponEditor.a.setText("");
    }

    private /* synthetic */ void H(ActionEvent a2) {
        GashaponEditor a3;
        Object[] arrobject = new Object[3];
        arrobject[0] = Integer.parseInt(a3.a.getText());
        arrobject[1] = Integer.parseInt(a3.d.getText());
        arrobject[2] = a3.ALLATORIxDEMO.getText().contains("\u662f") ? 1 : 0;
        WvsCenter.getInstance().UpdateGashaponItem(arrobject);
        a3.setVisible(false);
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        GashaponEditor a3;
        a3.setVisible(false);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        GashaponEditor a3;
        GashaponEditor gashaponEditor = a3;
        gashaponEditor.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        GashaponEditor gashaponEditor2 = a3;
        gashaponEditor2.setLocation((int)(dimension.getWidth() - (double)gashaponEditor2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }
}

