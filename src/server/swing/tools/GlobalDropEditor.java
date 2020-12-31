/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import FuckingHackerToby.fc;
import handling.channel.handler.StatsHandling;
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

public class GlobalDropEditor
extends JFrame
implements UIWindow {
    private /* synthetic */ JLabel H;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton C;
    private /* synthetic */ JLabel E;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JLabel e;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JButton F;
    private /* synthetic */ JTextField K;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(fc.ALLATORIxDEMO("X4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q\u001dq7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r4X4r7r7r7r7q4r4r7r4r7r7q4r4q4r4q4r4q7r4q4r7r7r7r7q\u001dq7r7r7r7q7q7q7r7q7r7q7q7r4r7q7q7q7q7r4r7r7r7r7r4X4r7r7r7r4q4r4r7r4r7r4q4r7q7r4r4r4q7r7q7r7r7r7r7q\u001dq7r7r7r7q7q7q4q7q4q7q7q7r4r7q4q7q7q7q4q7r7r7r7r4X4r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7q\u001dq7\u001du4b!t3c;x<70nrV>{3c=e;7\u001du4b!t3c=erae9a7\u0016R\u001fXr4X4r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7q\u001dq7r7r7r7r7r7:c&gh8}`%`|v>{3c=e;91x?7r7r7r7r7r7r4X4r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7r7q\u001dq4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4q4X"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!StatsHandling.ALLATORIxDEMO("5G\u0016L\u000e]").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(GlobalDropEditor.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(GlobalDropEditor.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(GlobalDropEditor.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(GlobalDropEditor.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new GlobalDropEditor().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    private /* synthetic */ void H(ActionEvent a2) {
        GlobalDropEditor a3;
        Object[] arrobject = new Object[4];
        arrobject[0] = Integer.parseInt(a3.K.getText());
        arrobject[1] = Integer.parseInt(a3.a.getText());
        arrobject[2] = Integer.parseInt(a3.d.getText());
        arrobject[3] = Integer.parseInt(a3.ALLATORIxDEMO.getText());
        WvsCenter.getInstance().UpdateGlobalDrop(arrobject);
        a3.setVisible(false);
    }

    public /* synthetic */ void init() {
        GlobalDropEditor a2;
        GlobalDropEditor globalDropEditor = a2;
        globalDropEditor.k.setText("");
        globalDropEditor.a.setText("");
        globalDropEditor.d.setText("");
        globalDropEditor.ALLATORIxDEMO.setText("");
        globalDropEditor.K.setText("");
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        GlobalDropEditor a3;
        GlobalDropEditor globalDropEditor = a3;
        globalDropEditor.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        GlobalDropEditor globalDropEditor2 = a3;
        globalDropEditor2.setLocation((int)(dimension.getWidth() - (double)globalDropEditor2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        GlobalDropEditor a3;
        a3.setVisible(false);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        GlobalDropEditor a2;
        GlobalDropEditor globalDropEditor = a2;
        GlobalDropEditor globalDropEditor2 = a2;
        GlobalDropEditor globalDropEditor3 = a2;
        globalDropEditor2.H = new JLabel();
        globalDropEditor3.E = new JLabel();
        globalDropEditor2.g = new JLabel();
        globalDropEditor2.B = new JLabel();
        globalDropEditor2.k = new JTextField();
        globalDropEditor2.a = new JTextField();
        globalDropEditor2.d = new JTextField();
        globalDropEditor2.ALLATORIxDEMO = new JTextField();
        globalDropEditor2.F = new JButton();
        globalDropEditor2.C = new JButton();
        globalDropEditor2.e = new JLabel();
        a2.K = new JTextField();
        globalDropEditor.setDefaultCloseOperation(3);
        a2.H.setText(fc.ALLATORIxDEMO("\u727e\u5493\u541a\u7a63"));
        globalDropEditor.E.setText(StatsHandling.ALLATORIxDEMO("\u63f2\u8413\u6a24\u73a9"));
        globalDropEditor.g.setText(fc.ALLATORIxDEMO("\u6752\u5930\u63db\u842a\u652a"));
        globalDropEditor.B.setText(StatsHandling.ALLATORIxDEMO("\u672e\u5c74\u63a7\u8446\u6556"));
        globalDropEditor.F.setText(fc.ALLATORIxDEMO("\u4ff9\u656b"));
        globalDropEditor.F.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.GlobalDropEditor.this.H(a2);
            }
            {
                1 a3;
            }
        });
        globalDropEditor.C.setText("\u53d6\u6d88");
        globalDropEditor.C.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.GlobalDropEditor.this.ALLATORIxDEMO(a2);
            }
        });
        globalDropEditor.e.setText(StatsHandling.ALLATORIxDEMO("\u7212\u54ef\u4e98\u7892"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        globalDropEditor.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.B).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.ALLATORIxDEMO, -2, 90, -2).addGap(0, 0, 32767)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.E).addComponent(a2.g)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.H).addComponent(a2.e)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.K, -2, 90, -2).addComponent(a2.k, -2, 90, -2)).addContainerGap()))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.F, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.C, -1, -1, 32767).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.k, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.e).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.F).addComponent(a2.C)).addContainerGap(-1, 32767)));
        globalDropEditor.pack();
    }

    public /* synthetic */ GlobalDropEditor() {
        GlobalDropEditor a2;
        GlobalDropEditor globalDropEditor = a2;
        globalDropEditor.ALLATORIxDEMO();
    }

    public /* synthetic */ void setGlobalDrop(Object[] a2) {
        GlobalDropEditor a3;
        if (a2 == null || a2.length < 5) {
            return;
        }
        GlobalDropEditor globalDropEditor = a3;
        globalDropEditor.k.setText(String.valueOf(a2[0]));
        globalDropEditor.K.setText(String.valueOf(a2[1]));
        globalDropEditor.a.setText(String.valueOf(a2[2]));
        globalDropEditor.d.setText(String.valueOf(a2[3]));
        globalDropEditor.ALLATORIxDEMO.setText(String.valueOf(a2[4]));
    }
}

