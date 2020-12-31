/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.MapleCoolDownValueHolder;
import database.DatabaseConnection;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
import tools.GZIPCompression;

public class DropTool
extends JFrame {
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JLabel H;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JButton C;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel e;
    private /* synthetic */ JLabel E;

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        DropTool a2;
        DropTool dropTool = a2;
        DropTool dropTool2 = a2;
        DropTool dropTool3 = a2;
        dropTool2.H = new JLabel();
        dropTool3.e = new JLabel();
        dropTool2.E = new JLabel();
        dropTool2.g = new JLabel();
        dropTool2.B = new JLabel();
        dropTool2.k = new JTextField();
        dropTool2.K = new JTextField();
        dropTool2.a = new JTextField();
        dropTool2.d = new JTextField();
        dropTool2.ALLATORIxDEMO = new JTextField();
        a2.C = new JButton();
        dropTool.setDefaultCloseOperation(3);
        a2.H.setText(MapleCoolDownValueHolder.ALLATORIxDEMO("\u0012W>N\u0012g"));
        dropTool.e.setText(GZIPCompression.ALLATORIxDEMO("cySbFeFu\u0012$_e\\%"));
        dropTool.E.setText(MapleCoolDownValueHolder.ALLATORIxDEMO("\nV:M/J/Z{\u000b6B#\n"));
        dropTool.g.setText(GZIPCompression.ALLATORIxDEMO("H@cB|Wh\u0012NK6"));
        dropTool.B.setText(MapleCoolDownValueHolder.ALLATORIxDEMO("\u0018K:M8F"));
        dropTool.k.setText(GZIPCompression.ALLATORIxDEMO("=\u0002<\u0002<\u0002<"));
        dropTool.k.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.DropTool.this.l(a2);
            }
        });
        dropTool.K.setText("1");
        dropTool.a.setText("1");
        dropTool.a.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.DropTool.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        dropTool.d.setText(MapleCoolDownValueHolder.ALLATORIxDEMO("j\u0013k\u0012k\u0013"));
        dropTool.d.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.DropTool.this.H(a2);
            }
            {
                3 a3;
            }
        });
        dropTool.ALLATORIxDEMO.setText(GZIPCompression.ALLATORIxDEMO("=\u0002<\u0002<\u0002<"));
        dropTool.C.setText(MapleCoolDownValueHolder.ALLATORIxDEMO("\bV9N2W"));
        dropTool.C.addMouseListener(new MouseAdapter(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void mouseClicked(MouseEvent a2) {
                4 a3;
                a3.DropTool.this.ALLATORIxDEMO(a2);
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        dropTool.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H).addGap(45, 45, 45).addComponent(a2.k, -2, -1, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.e).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.K, -2, 47, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a, -2, 49, -2)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g).addComponent(a2.B)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.d).addComponent(a2.ALLATORIxDEMO)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.C, -1, 122, 32767).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H).addComponent(a2.k, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.e).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.a, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addGap(0, 3, 32767)).addComponent(a2.C, -1, -1, 32767)).addContainerGap()));
        dropTool.pack();
    }

    private /* synthetic */ void H(ActionEvent a2) {
    }

    public /* synthetic */ DropTool() {
        DropTool a2;
        DropTool dropTool = a2;
        dropTool.ALLATORIxDEMO();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(MouseEvent a) {
        v0 = a;
        a = Integer.parseInt(v0.k.getText());
        var2_4 = Integer.parseInt(v0.K.getText());
        var3_6 = Integer.parseInt(v0.a.getText());
        var4_7 = Integer.parseInt(v0.d.getText());
        var5_8 = Integer.parseInt(v0.ALLATORIxDEMO.getText());
        var6_9 = DatabaseConnection.getConnection().prepareStatement(GZIPCompression.ALLATORIxDEMO("{BaI`X\u0012E|X},V~]|mhSxS,\u001ah@cB|W~[h\u001e,[xWa[h\u001e,_e\\e_y_SCySbFeFu\u001e,_mJe_y_SCySbFeFu\u001e,QdSbQi\u001b,dM~Yw_\u0012$\r \u00123\u001e,\r \u00123\u001e,\r%"));
        try {
            v1 = var6_9;
            v2 = var6_9;
            var6_9.setInt(1, var4_7);
            v2.setInt(2, a);
            v2.setInt(3, var2_4);
            v1.setInt(4, var3_6);
            v1.setInt(5, var5_8);
            var6_9.executeQuery();
            ** if (var6_9 == null) goto lbl-1000
        }
        catch (Throwable var7_10) {
            if (var6_9 == null) ** GOTO lbl33
            try {
                var6_9.close();
                v3 = var7_10;
                ** GOTO lbl34
            }
            catch (Throwable var2_5) {
                try {
                    var7_10.addSuppressed(var2_5);
lbl33:
                    // 2 sources

                    v3 = var7_10;
lbl34:
                    // 2 sources

                    throw v3;
                }
                catch (NumberFormatException | SQLException a) {
                    // empty catch block
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var6_9.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    private /* synthetic */ void l(ActionEvent a2) {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a) {
        block5: {
            System.out.println(MapleCoolDownValueHolder.ALLATORIxDEMO(")x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000Q\u0000{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003x)x\u0003{\u0003{\u0003{\u0003{\u0000x\u0003x\u0003{\u0003x\u0003{\u0003{\u0000x\u0003x\u0000x\u0003x\u0000x\u0003x\u0000{\u0003x\u0000x\u0003{\u0003{\u0003{\u0003{\u0000Q\u0000{\u0003{\u0003{\u0003{\u0000{\u0000{\u0000{\u0003{\u0000{\u0003{\u0000{\u0000{\u0003x\u0003{\u0000{\u0000{\u0000{\u0000{\u0003x\u0003{\u0003{\u0003{\u0003{\u0003x)x\u0003{\u0003{\u0003{\u0003x\u0000x\u0003x\u0003{\u0003x\u0003{\u0003x\u0000x\u0003{\u0000{\u0003x\u0003x\u0003x\u0000{\u0003{\u0000{\u0003{\u0003{\u0003{\u0003{\u0000Q\u0000{\u0003{\u0003{\u0003{\u0000{\u0000{\u0000x\u0000{\u0000x\u0000{\u0000{\u0000{\u0003x\u0003{\u0000x\u0000{\u0000{\u0000{\u0000x\u0000{\u0003{\u0003{\u0003{\u0003x)x\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0000Q\u0000{l9E.P8B/J4M{A\"\u0003\u001aO7B/L)J{l9E.P8B/L)\u0003-\u0014u\u0010{g\u001en\u0014\u0003x)x\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0000Q\u0000{\u0003{\u0003{\u0003{\u0003{\u0003{K/W+\u0019t\f,T,\r:O7B/L)Ju@4N{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003x)x\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0003{\u0000Q\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x\u0000x)"));
            try {
                var1_1 = UIManager.getInstalledLookAndFeels();
                var2_3 = var1_1.length;
                var3_4 = 0;
lbl6:
                // 2 sources

                while (var3_4 < var2_3) {
                    var4_5 = var1_1[var3_4];
                    if (GZIPCompression.ALLATORIxDEMO("|e_nG\u007f").equals(var4_5.getName())) {
                        UIManager.setLookAndFeel(var4_5.getClassName());
                    }
                    ** GOTO lbl-1000
                }
                break block5;
            }
            catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException var1_2) {
                Logger.getLogger(DropTool.class.getName()).log(Level.SEVERE, null, var1_2);
            }
            break block5;
lbl-1000:
            // 1 sources

            {
                ++var3_4;
                ** GOTO lbl6
            }
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new DropTool().setVisible(true);
            }
            {
                5 a2;
            }
        });
    }
}

