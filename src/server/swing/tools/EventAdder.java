/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import client.MapleFriendship;
import handling.channel.handler.PartyHandler;
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

public class EventAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JButton a;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton K;
    private /* synthetic */ JLabel d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleFriendship.ALLATORIxDEMO("\u0012\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;!;\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b;\b8\b8\u000b8\b8\u000b8\u000b;\b8\b;\b8\b;\b8\b;\u000b8\b;\b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b;\u000b;\u000b;\u000b8\u000b;\u000b8\u000b;\u000b;\u000b8\b8\u000b;\u000b;\u000b;\u000b;\u000b8\b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\b;\b8\b8\u000b8\b8\u000b8\b;\b8\u000b;\u000b8\b8\b8\b;\u000b8\u000b;\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b;\u000b;\u000b;\b;\u000b;\b;\u000b;\u000b;\u000b8\b8\u000b;\b;\u000b;\u000b;\u000b;\b;\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000bWI~^kHy_qDv\u000bzR8jtGy_wYq\u000bWI~^kHy_wY8]/\u0005+\u000b\\nUd8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b8\u000b8\u000bp_l[\"\u00047\\o\\6JtGy_wYq\u0005{Du\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b\u0012"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!PartyHandler.ALLATORIxDEMO("\u0016\n5\u0001-\u0010").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(EventAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(EventAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(EventAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(EventAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new EventAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        EventAdder a3;
        a3.setVisible(false);
    }

    public /* synthetic */ EventAdder() {
        EventAdder a2;
        EventAdder eventAdder = a2;
        eventAdder.ALLATORIxDEMO();
    }

    public /* synthetic */ void init() {
        EventAdder a2;
        a2.ALLATORIxDEMO.setText("");
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        EventAdder a3;
        EventAdder eventAdder = a3;
        EventAdder eventAdder2 = a3;
        eventAdder2.init();
        eventAdder.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        eventAdder2.setLocation((int)(dimension.getWidth() - (double)a3.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        EventAdder a3;
        if (!a3.ALLATORIxDEMO.getText().isEmpty()) {
            WvsCenter.getInstance().AddEvent(a3.ALLATORIxDEMO.getText());
        }
        a3.setVisible(false);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        EventAdder a2;
        EventAdder eventAdder = a2;
        EventAdder eventAdder2 = a2;
        EventAdder eventAdder3 = a2;
        eventAdder2.K = new JButton();
        eventAdder3.a = new JButton();
        eventAdder2.d = new JLabel();
        a2.ALLATORIxDEMO = new JTextField();
        eventAdder.setDefaultCloseOperation(3);
        a2.K.setText(MapleFriendship.ALLATORIxDEMO("\u659b\u5886"));
        eventAdder.K.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.EventAdder.this.H(a2);
            }
        });
        eventAdder.a.setText("\u53d6\u6d88");
        eventAdder.a.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.EventAdder.this.ALLATORIxDEMO(a2);
            }
        });
        eventAdder.d.setText(PartyHandler.ALLATORIxDEMO("\u4ed3\u4e95\u5455\u7a52"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        eventAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(a2.d).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.ALLATORIxDEMO, -2, 90, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.K, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a, -2, 82, -2))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.d).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.K).addComponent(a2.a)).addGap(8, 8, 8)));
        eventAdder.pack();
    }
}

