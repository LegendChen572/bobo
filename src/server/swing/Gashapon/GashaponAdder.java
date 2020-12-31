/*
 * Decompiled with CFR 0.150.
 */
package server.swing.Gashapon;

import client.messages.commands.player.eventSystem.MonsterPetSystem;
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
import server.shops.MaplePlayerShopItem;
import server.swing.UIWindow;
import server.swing.WvsCenter;

public class GashaponAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JButton E;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JLabel K;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JButton g;

    private /* synthetic */ void H(ActionEvent a2) {
        GashaponAdder a3;
        Object[] arrobject = new Object[3];
        arrobject[0] = a3.a.getText().isEmpty() ? 0 : Integer.parseInt(a3.a.getText());
        arrobject[1] = a3.d.getText().isEmpty() ? 0 : Integer.parseInt(a3.d.getText());
        arrobject[2] = a3.ALLATORIxDEMO.getText().isEmpty() ? 0 : (a3.ALLATORIxDEMO.getText().contains("\u662f") ? 1 : 0);
        WvsCenter.getInstance().AddGashaponItem(arrobject);
        a3.setVisible(false);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        GashaponAdder a3;
        GashaponAdder gashaponAdder = a3;
        gashaponAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        GashaponAdder gashaponAdder2 = a3;
        gashaponAdder2.setLocation((int)(dimension.getWidth() - (double)gashaponAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    public /* synthetic */ void init() {
        GashaponAdder a2;
        GashaponAdder gashaponAdder = a2;
        gashaponAdder.d.setText("");
        gashaponAdder.ALLATORIxDEMO.setText("");
        gashaponAdder.a.setText("");
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        GashaponAdder a3;
        a3.setVisible(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MonsterPetSystem.ALLATORIxDEMO("Y{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{pRpxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxs{Y{sxsxsxsxp{s{sxs{sxsxp{s{p{s{p{s{pxs{p{sxsxsxsxpRpxsxsxsxpxpxpxsxpxsxpxpxs{sxpxpxpxpxs{sxsxsxsxs{Y{sxsxsxs{p{s{sxs{sxs{p{sxpxs{s{s{pxsxpxsxsxsxsxpRpxsxsxsxpxpxp{pxp{pxpxpxs{sxp{pxpxpxp{pxsxsxsxs{Y{sxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxpRpx\u001c:5- ;2,:7=x1!s\u0019?42,<*:x\u001c:5- ;2,<*s.dv`x\u0017\u001d\u001e\u0017s{Y{sxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxpRpxsxsxsxsxsx;,'(iw|/$/}9?42,<*:v07>xsxsxsxsxsxs{Y{sxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxsxpRp{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{p{Y"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MaplePlayerShopItem.ALLATORIxDEMO("9_\u001aT\u0002E").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(GashaponAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(GashaponAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(GashaponAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(GashaponAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new GashaponAdder().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    public /* synthetic */ GashaponAdder() {
        GashaponAdder a2;
        GashaponAdder gashaponAdder = a2;
        gashaponAdder.ALLATORIxDEMO();
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        GashaponAdder a2;
        GashaponAdder gashaponAdder = a2;
        GashaponAdder gashaponAdder2 = a2;
        GashaponAdder gashaponAdder3 = a2;
        gashaponAdder2.k = new JLabel();
        gashaponAdder3.K = new JLabel();
        gashaponAdder2.d = new JTextField();
        gashaponAdder2.ALLATORIxDEMO = new JTextField();
        gashaponAdder2.E = new JButton();
        gashaponAdder2.g = new JButton();
        gashaponAdder2.B = new JLabel();
        a2.a = new JTextField();
        gashaponAdder.setDefaultCloseOperation(3);
        a2.k.setText(MonsterPetSystem.ALLATORIxDEMO("\u8f11\u8698\u6a07\u73d4"));
        gashaponAdder.K.setText(MaplePlayerShopItem.ALLATORIxDEMO("\u6658\u5410\u4e7d\u5ed5"));
        gashaponAdder.E.setText(MonsterPetSystem.ALLATORIxDEMO("\u65e8\u58cd"));
        gashaponAdder.E.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.GashaponAdder.this.H(a2);
            }
        });
        gashaponAdder.g.setText("\u53d6\u6d88");
        gashaponAdder.g.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.GashaponAdder.this.ALLATORIxDEMO(a2);
            }
        });
        gashaponAdder.B.setText(MaplePlayerShopItem.ALLATORIxDEMO("\u721e\u54f7\u4e94\u788a"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        gashaponAdder.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.k).addComponent(a2.K)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.d, GroupLayout.Alignment.TRAILING, -2, 90, -2).addComponent(a2.ALLATORIxDEMO, GroupLayout.Alignment.TRAILING, -2, 90, -2))).addGroup(groupLayout.createSequentialGroup().addComponent(a2.B).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.a, -2, 90, -2)))).addGroup(groupLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(a2.E, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.g, -2, 74, -2))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.K).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.E)).addGap(6, 6, 6)));
        gashaponAdder.pack();
    }
}

