/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.formdev.flatlaf.FlatLightLaf
 */
package server.swing.CashShop;

import client.inventory.MapleInventoryType;
import com.formdev.flatlaf.FlatLightLaf;
import constants.GameConstants;
import database.DatabaseConnection;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import server.MapleItemInformationProvider;
import server.MapleSquad;
import server.swing.CashShop.CashShopItemAdder;
import server.swing.WvsCenter;
import tools.FixDropNullItem;

public class CashShopManager
extends JFrame {
    private /* synthetic */ JCheckBox e;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JButton F;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JButton J;
    private /* synthetic */ boolean i;
    private /* synthetic */ JButton C;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JButton I;
    private /* synthetic */ JCheckBox E;
    private /* synthetic */ JLabel K;
    private /* synthetic */ int[] j;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JComboBox H;
    private /* synthetic */ JScrollPane a;
    private /* synthetic */ JButton M;
    private /* synthetic */ JTable d;

    private /* synthetic */ void H(int a2) {
        int n2;
        CashShopManager a3;
        DefaultTableModel defaultTableModel = (DefaultTableModel)a3.d.getModel();
        int n3 = n2 = 0;
        while (n3 < a3.d.getRowCount()) {
            if ((Integer)defaultTableModel.getValueAt(n2, 0) == a2) {
                defaultTableModel.removeRow(n2);
                return;
            }
            n3 = ++n2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(int a, String a) {
        var3_4 = DatabaseConnection.getConnection();
        var3_4 = var3_4.prepareStatement(MapleSquad.ALLATORIxDEMO("YEHTXP,uot\u007f}\u007f}ceS|xpafl5_PX5l{mxiu,(,*,BDP^P,u\u007fp~|myl5153"));
        try {
            v0 = var3_4;
            v0.setString(1, a);
            v0.setInt(2, a);
            var3_4.executeUpdate();
            ** if (var3_4 == null) goto lbl-1000
        }
        catch (Throwable var4_6) {
            if (var3_4 == null) ** GOTO lbl24
            try {
                var3_4.close();
                v1 = var4_6;
                ** GOTO lbl25
            }
            catch (Throwable a) {
                try {
                    var4_6.addSuppressed(a);
lbl24:
                    // 2 sources

                    v1 = var4_6;
lbl25:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var3_5) {
                    a.K.setText("\u767c\u751f\u8cc7\u6599\u5eab\u4f8b\u5916\u72c0\u6cc1 : " + var3_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var3_4.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(FixDropNullItem.ALLATORIxDEMO("L\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e<e\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0015L\u0015f\u0016f\u0016f\u0016f\u0016e\u0015f\u0015f\u0016f\u0015f\u0016f\u0016e\u0015f\u0015e\u0015f\u0015e\u0015f\u0015e\u0016f\u0015e\u0015f\u0016f\u0016f\u0016f\u0016e<e\u0016f\u0016f\u0016f\u0016e\u0016e\u0016e\u0016f\u0016e\u0016f\u0016e\u0016e\u0016f\u0015f\u0016e\u0016e\u0016e\u0016e\u0016f\u0015f\u0016f\u0016f\u0016f\u0016f\u0015L\u0015f\u0016f\u0016f\u0016f\u0015e\u0015f\u0015f\u0016f\u0015f\u0016f\u0015e\u0015f\u0016e\u0016f\u0015f\u0015f\u0015e\u0016f\u0016e\u0016f\u0016f\u0016f\u0016f\u0016e<e\u0016f\u0016f\u0016f\u0016e\u0016e\u0016e\u0015e\u0016e\u0015e\u0016e\u0016e\u0016f\u0015f\u0016e\u0015e\u0016e\u0016e\u0016e\u0015e\u0016f\u0016f\u0016f\u0016f\u0015L\u0015f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016e<e\u0016\tT C5U'B/Y(\u0016$Ofw*Z'B)D/\u0016\tT C5U'B)Df@q\u0018u\u0016\u0002s\u000byf\u0015L\u0015f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016e<e\u0016f\u0016f\u0016f\u0016f\u0016f\u0016.B2F|\u0019iA1AhW*Z'B)D/\u0018%Y+\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0015L\u0015f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016f\u0016e<e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015e\u0015L"));
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                1 a2;
                new Thread(new Runnable(){

                    /*
                     * Unable to fully structure code
                     * Enabled aggressive block sorting
                     * Enabled unnecessary exception pruning
                     * Enabled aggressive exception aggregation
                     * Lifted jumps to return sites
                     */
                    @Override
                    public /* synthetic */ void run() {
                        try {
                            UIManager.setLookAndFeel((LookAndFeel)new FlatLightLaf());
                            ** GOTO lbl7
                        }
                        catch (UnsupportedLookAndFeelException var1_1) {
                            try {
                                Logger.getLogger(WvsCenter.class.getName()).log(Level.SEVERE, null, var1_1);
lbl7:
                                // 2 sources

                                new CashShopManager().setVisible(true);
                                return;
                            }
                            catch (Exception var1_2) {
                                var1_2.printStackTrace();
                                return;
                            }
                        }
                    }
                    {
                        1 a3;
                    }
                }).start();
            }
            {
                1 a2;
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        CashShopManager a2;
        CashShopManager cashShopManager = a2;
        CashShopManager cashShopManager2 = a2;
        CashShopManager cashShopManager3 = a2;
        cashShopManager2.H = new JComboBox();
        cashShopManager3.B = new JLabel();
        cashShopManager2.a = new JScrollPane();
        cashShopManager2.d = new JTable();
        cashShopManager2.g = new JLabel();
        cashShopManager2.E = new JCheckBox();
        cashShopManager2.ALLATORIxDEMO = new JTextField();
        cashShopManager2.C = new JButton();
        cashShopManager2.k = new JLabel();
        cashShopManager2.K = new JLabel();
        cashShopManager2.e = new JCheckBox();
        cashShopManager2.I = new JButton();
        cashShopManager2.J = new JButton();
        a2.M = new JButton();
        a2.F = new JButton();
        a2.setDefaultCloseOperation(2);
        cashShopManager.setTitle(FixDropNullItem.ALLATORIxDEMO("\u6915\u4e7d\u8c71\u5570\u5788\u4fd8\u657f\u5dd3\u5131"));
        cashShopManager.setResizable(false);
        String[] arrstring = new String[29];
        arrstring[0] = MapleSquad.ALLATORIxDEMO("\u517d\u90e4");
        arrstring[1] = FixDropNullItem.ALLATORIxDEMO("\u63ee\u8590f\u001bf\u6586\u5487\u0016w\u0006v");
        arrstring[2] = MapleSquad.ALLATORIxDEMO("\u63a4\u85b3,8,\u6d2e\u52d95=%=");
        arrstring[3] = FixDropNullItem.ALLATORIxDEMO("\u889b\u50aff\u001bf\u5e0b\u5b16\u0016t\u0006v");
        arrstring[4] = MapleSquad.ALLATORIxDEMO("\u88d1\u508c,8,\u81dc\u98f25>%=");
        arrstring[5] = FixDropNullItem.ALLATORIxDEMO("\u889b\u50aff\u001bf\u770a\u98b8\u0016t\u0006t");
        arrstring[6] = MapleSquad.ALLATORIxDEMO("\u88d1\u508c,8,\u5942\u88d15>%?");
        arrstring[7] = FixDropNullItem.ALLATORIxDEMO("\u889b\u50aff\u001bf\u4e3c\u8825\u0016t\u0006r");
        arrstring[8] = MapleSquad.ALLATORIxDEMO("\u88c8\u50955!5\u893e5#5\u88d55>%9");
        arrstring[9] = FixDropNullItem.ALLATORIxDEMO("\u889b\u50aff\u001bf\u97bd\u5b16\u0016t\u0006p");
        arrstring[10] = MapleSquad.ALLATORIxDEMO("\u88d1\u508c,8,\u625e\u595b5>%;");
        arrstring[11] = FixDropNullItem.ALLATORIxDEMO("\u889b\u50aff\u001bf\u6b50\u562e\u0016t\u0006~");
        arrstring[12] = MapleSquad.ALLATORIxDEMO("\u88d1\u508c,8,\u6207\u630b5>%5");
        arrstring[13] = FixDropNullItem.ALLATORIxDEMO("\u889b\u50aff\u001bf\u629d\u98ee\u0016t\u0007w");
        arrstring[14] = MapleSquad.ALLATORIxDEMO("\u88d1\u508c,8,\u5745\u9a025>$>");
        arrstring[15] = FixDropNullItem.ALLATORIxDEMO("\u6dbe\u8051\u0016k\u0016\u900c\u6204\u527e\u0016u\u0006v");
        arrstring[16] = MapleSquad.ALLATORIxDEMO("\u6d84\u8002,8,\u5ef6\u64a15?%=");
        arrstring[17] = FixDropNullItem.ALLATORIxDEMO("\u6dce\u8021f\u001bf\u724f\u650e\u0016u\u0006t");
        arrstring[18] = MapleSquad.ALLATORIxDEMO("\u7275\u6b9f,8,\u726c\u6b8658%<");
        arrstring[19] = FixDropNullItem.ALLATORIxDEMO("\u9065\u5131\u0016k\u0016\u900c\u6204\u527e\u0016s\u0006v");
        arrstring[20] = MapleSquad.ALLATORIxDEMO("\u905f\u5162,8,\u5553\u5e9b59%=");
        arrstring[21] = FixDropNullItem.ALLATORIxDEMO("\u9015\u5141f\u001bf\u907c\u6274\u0016s\u0006t");
        arrstring[22] = MapleSquad.ALLATORIxDEMO("\u905f\u5162,8,\u887d\u60c959%?");
        arrstring[23] = FixDropNullItem.ALLATORIxDEMO("\u9015\u5141f\u001bf\u7d66\u5a1c\u0016s\u0006r");
        arrstring[24] = MapleSquad.ALLATORIxDEMO("\u905f\u5162,8,\u726c\u654459%9");
        arrstring[25] = FixDropNullItem.ALLATORIxDEMO("\u9015\u5141f\u001bf\u89e4\u8234\u0016s\u0006p");
        arrstring[26] = MapleSquad.ALLATORIxDEMO("\u5bf9\u727c,8,\u5be0\u72655:%<");
        arrstring[27] = FixDropNullItem.ALLATORIxDEMO("\u5bb3\u725ff\u001bf\u5bc3\u722f\u88eb\u50df\u0016p\u0006w");
        arrstring[28] = MapleSquad.ALLATORIxDEMO("\u5bf9\u727c,8,\u5be0\u7265\u9046\u517b5:%>");
        cashShopManager.H.setModel(new DefaultComboBoxModel<String>(arrstring));
        CashShopManager cashShopManager4 = a2;
        cashShopManager4.B.setText(FixDropNullItem.ALLATORIxDEMO("\u5230\u9818"));
        Object[] arrobject = new String[11];
        arrobject[0] = MapleSquad.ALLATORIxDEMO("\u5e83\u864a,FB");
        arrobject[1] = FixDropNullItem.ALLATORIxDEMO("\u5570\u5487\u543b\u7a77");
        arrobject[2] = MapleSquad.ALLATORIxDEMO("\u8cbc\u8cef\u50ec\u6830");
        arrobject[3] = FixDropNullItem.ALLATORIxDEMO("\u6a2f\u8a5e");
        arrobject[4] = MapleSquad.ALLATORIxDEMO("\u4e1f\u67ba\u72d5\u6147");
        arrobject[5] = FixDropNullItem.ALLATORIxDEMO("\u9065\u5131\u4ed5\u78fa");
        arrobject[6] = MapleSquad.ALLATORIxDEMO("\u6387\u5e83");
        arrobject[7] = FixDropNullItem.ALLATORIxDEMO("\u6729\u9616");
        arrobject[8] = MapleSquad.ALLATORIxDEMO("\u6032\u5229\u9645\u523a");
        arrobject[9] = FixDropNullItem.ALLATORIxDEMO("\u9065\u5131\u654e\u9189");
        arrobject[10] = MapleSquad.ALLATORIxDEMO("\u9858\u591a\u65c2\u6a15");
        cashShopManager4.d.setModel(new DefaultTableModel(new Object[0][], arrobject){
            public /* synthetic */ Class[] a;
            public /* synthetic */ boolean[] d;

            @Override
            public /* synthetic */ boolean isCellEditable(int a2, int a3) {
                3 a4;
                return a4.d[a3];
            }

            public /* synthetic */ Class getColumnClass(int a2) {
                3 a3;
                return a3.a[a2];
            }
            {
                3 a5;
                super(a3, a4);
                Class[] arrclass = new Class[11];
                arrclass[0] = Integer.class;
                arrclass[1] = String.class;
                arrclass[2] = Integer.class;
                arrclass[3] = Integer.class;
                arrclass[4] = Integer.class;
                arrclass[5] = Integer.class;
                arrclass[6] = Integer.class;
                arrclass[7] = Integer.class;
                arrclass[8] = Integer.class;
                arrclass[9] = Integer.class;
                arrclass[10] = Integer.class;
                a5.a = arrclass;
                boolean[] arrbl = new boolean[11];
                arrbl[0] = 0;
                arrbl[1] = 1;
                arrbl[2] = true;
                arrbl[3] = true;
                arrbl[4] = true;
                arrbl[5] = true;
                arrbl[6] = true;
                arrbl[7] = true;
                arrbl[8] = true;
                arrbl[9] = true;
                arrbl[10] = true;
                a5.d = arrbl;
            }
        });
        CashShopManager cashShopManager5 = a2;
        cashShopManager5.d.setAutoResizeMode(0);
        CashShopManager cashShopManager6 = a2;
        cashShopManager5.a.setViewportView(cashShopManager6.d);
        cashShopManager6.g.setFont(new Font(FixDropNullItem.ALLATORIxDEMO("\u5fe8\u8ee9\u6b25\u9ee7\u9a92"), 0, 14));
        cashShopManager5.g.setText(MapleSquad.ALLATORIxDEMO("\u5553\u57c2\u8cd2\u6595\u7bb4\u740a"));
        cashShopManager5.E.setText(FixDropNullItem.ALLATORIxDEMO("\u53dc\u645a\u7d14\u5bca\u515e\u7b60\u543e\u76c2\u5151\u5bff"));
        cashShopManager5.E.setEnabled(false);
        cashShopManager5.ALLATORIxDEMO.setEnabled(false);
        cashShopManager5.C.setText(MapleSquad.ALLATORIxDEMO("\u6409\u7d2e"));
        cashShopManager5.C.addActionListener(new ActionListener(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                4 a3;
                a3.CashShopManager.this.I(a2);
            }
        });
        cashShopManager5.k.setText(FixDropNullItem.ALLATORIxDEMO("\u8613\u7430\u7286\u617d\uff5c"));
        cashShopManager5.K.setText(MapleSquad.ALLATORIxDEMO("\u7b45\u5f90\u4e215\";\""));
        cashShopManager5.e.setText(FixDropNullItem.ALLATORIxDEMO("\u5500\u54f7\u544b\u7a07\uff5c"));
        cashShopManager5.e.addActionListener(new ActionListener(){
            {
                5 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                5 a3;
                a3.CashShopManager.this.E(a2);
            }
        });
        cashShopManager5.I.setText(MapleSquad.ALLATORIxDEMO("\u523f\u9668"));
        cashShopManager5.I.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                6 a3;
                a3.CashShopManager.this.D(a2);
            }
            {
                6 a3;
            }
        });
        cashShopManager5.J.setText(FixDropNullItem.ALLATORIxDEMO("\u6586\u58d8\u9065\u5131"));
        cashShopManager5.J.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                7 a3;
                a3.CashShopManager.this.l(a2);
            }
            {
                7 a3;
            }
        });
        cashShopManager5.M.setText(MapleSquad.ALLATORIxDEMO("\u4eef\u78a9\u67e9\u8a77\u5664"));
        cashShopManager5.M.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                8 a3;
                a3.CashShopManager.this.H(a2);
            }
            {
                8 a3;
            }
        });
        cashShopManager5.F.setText(FixDropNullItem.ALLATORIxDEMO("\u8f0f\u5104fa\u001c\u0016\u5500\u57f8\u8c81\u65af\u81b5\u0016\u0015g\n"));
        cashShopManager5.F.addActionListener(new ActionListener(){
            {
                9 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                9 a3;
                a3.CashShopManager.this.ALLATORIxDEMO(a2);
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        cashShopManager5.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a).addGroup(groupLayout.createSequentialGroup().addComponent(a2.g).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.F)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.K).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.J).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.I).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.M)).addGroup(groupLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(a2.B).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.H, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 197, 32767).addComponent(a2.e).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.C))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g).addComponent(a2.F)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.ALLATORIxDEMO, -2, -1, -2).addComponent(a2.C).addComponent(a2.E).addComponent(a2.e).addComponent(a2.H, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a, -1, 436, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.K).addComponent(a2.I).addComponent(a2.J).addComponent(a2.M)).addContainerGap()));
        cashShopManager5.pack();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(int a, String a, int a) {
        var4_6 = DatabaseConnection.getConnection();
        var5_7 = new StringBuilder();
        var5_7.append(MapleSquad.ALLATORIxDEMO("YEHTXP,uot\u007f}\u007f}ceS|xpafl5_PX5l")).append((String)a).append(FixDropNullItem.ALLATORIxDEMO("Vf\u000bf\tfa\u000es\u0014sfV5S4_'Z&\u0016{\u0016y"));
        a = var4_6.prepareStatement(var5_7.toString());
        try {
            v0 = a;
            v0.setInt(1, a);
            v0.setInt(2, a);
            a.executeUpdate();
            ** if (a == null) goto lbl-1000
        }
        catch (Throwable var6_8) {
            if (a == null) ** GOTO lbl27
            try {
                a.close();
                v1 = var6_8;
                ** GOTO lbl28
            }
            catch (Throwable a) {
                try {
                    var6_8.addSuppressed(a);
lbl27:
                    // 2 sources

                    v1 = var6_8;
lbl28:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException a) {
                    a.K.setText("\u767c\u751f\u8cc7\u6599\u5eab\u4f8b\u5916\u72c0\u6cc1 : " + a);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            a.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void l() {
        CashShopManager cashShopManager;
        CashShopManager a2;
        CashShopManager cashShopManager2 = a2;
        int n2 = cashShopManager2.d.getSelectedRow();
        int n3 = cashShopManager2.d.getSelectedColumn();
        if (((DefaultTableModel)cashShopManager2.d.getModel()).getRowCount() == 0 || n2 == -1 || n3 == -1 || a2.i) {
            return;
        }
        DefaultTableModel defaultTableModel = (DefaultTableModel)a2.d.getModel();
        int n4 = (Integer)defaultTableModel.getValueAt(n2, 0);
        a2.K.setText(FixDropNullItem.ALLATORIxDEMO("\u8613\u7430\u4e6b\u0016h\u0018h"));
        switch (n3) {
            case 1: {
                String string = (String)defaultTableModel.getValueAt(n2, n3);
                if (string.equals("")) {
                    CashShopManager cashShopManager3 = a2;
                    cashShopManager3.ALLATORIxDEMO(n4);
                    cashShopManager3.K.setText(MapleSquad.ALLATORIxDEMO("\u5553\u54cd\u5418\u7a3d\u4e18\u5f9b\u70af\u7a76"));
                    return;
                }
                CashShopManager cashShopManager4 = a2;
                cashShopManager = cashShopManager4;
                cashShopManager4.ALLATORIxDEMO(n4, string);
                break;
            }
            case 2: {
                int n5 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n5 <= 0) {
                    CashShopManager cashShopManager5 = a2;
                    cashShopManager5.ALLATORIxDEMO(n4);
                    cashShopManager5.K.setText(FixDropNullItem.ALLATORIxDEMO("\u8c9f\u8ca5\u50cf\u687a\u4e3b\u5fd1\u4f78\u65fa\u0016w\u0016\u9e98\u9ee8\u653e"));
                    return;
                }
                CashShopManager cashShopManager6 = a2;
                cashShopManager = cashShopManager6;
                cashShopManager6.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("\\gevi"), n5);
                break;
            }
            case 3: {
                int n6 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n6 < -1 || n6 > 4) {
                    CashShopManager cashShopManager7 = a2;
                    cashShopManager7.ALLATORIxDEMO(n4);
                    cashShopManager7.K.setText(FixDropNullItem.ALLATORIxDEMO("\u6a2f\u8a5e\u500a\u8f7e\u5153\u9369\u8a92f\u001ek\u0007fHf\u0002o"));
                    return;
                }
                CashShopManager cashShopManager8 = a2;
                cashShopManager = cashShopManager8;
                cashShopManager8.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("Xmgg"), n6);
                break;
            }
            case 4: {
                int n7 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n7 < 0 || n7 > 1) {
                    CashShopManager cashShopManager9 = a2;
                    cashShopManager9.ALLATORIxDEMO(n4);
                    cashShopManager9.K.setText(FixDropNullItem.ALLATORIxDEMO("\u4e3c\u67f0\u72f6\u610d\u8f0e\u5123\u9319\u8ae2\u0016n\u0006fHf\u0007o"));
                    return;
                }
                CashShopManager cashShopManager10 = a2;
                cashShopManager = cashShopManager10;
                cashShopManager10.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("Zbfmyi"), n7);
                break;
            }
            case 5: {
                int n8 = (Integer)defaultTableModel.getValueAt(n2, n3);
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                if (!mapleItemInformationProvider.itemExists(n8)) {
                    CashShopManager cashShopManager11 = a2;
                    cashShopManager11.ALLATORIxDEMO(n4);
                    cashShopManager11.K.setText(FixDropNullItem.ALLATORIxDEMO("\u8a44\u9015\u5141\u4e4b\u5b6e\u576e"));
                    return;
                }
                CashShopManager cashShopManager12 = a2;
                cashShopManager = cashShopManager12;
                cashShopManager12.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("\\xpa\\h"), n8);
                break;
            }
            case 6: {
                int n9 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n9 < -1) {
                    CashShopManager cashShopManager13 = a2;
                    cashShopManager13.ALLATORIxDEMO(n4);
                    cashShopManager13.K.setText(FixDropNullItem.ALLATORIxDEMO("\u63d4\u5eb9\u8f7e\u5153\u9369\u8a92f\u001ek\u0007f\u9826\u8a6b\u0016\u614e\u9aee\u5201\u5570\u5487\u4f7b\u7f28\u613e\u520b\u9754o"));
                    return;
                }
                CashShopManager cashShopManager14 = a2;
                cashShopManager = cashShopManager14;
                cashShopManager14.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("E~|cgeau"), n9);
                break;
            }
            case 7: {
                int n10 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n10 < -1 || n10 == 0) {
                    CashShopManager cashShopManager15 = a2;
                    cashShopManager15.ALLATORIxDEMO(n4);
                    cashShopManager15.K.setText(FixDropNullItem.ALLATORIxDEMO("\u6759\u9666\u4e4b\u5fa1\u4f08\u658af\u001bw\u0016\u6250\u708cf\u0006f\u001ek\u0007f\ff\u6c0e\u4e03\u0016\u55e8\u4f7bf\ff\u591fo"));
                    return;
                }
                CashShopManager cashShopManager16 = a2;
                cashShopManager = cashShopManager16;
                cashShopManager16.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("Eigezh"), n10);
                break;
            }
            case 8: {
                int n11 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n11 < 0 || n11 > 2) {
                    CashShopManager cashShopManager17 = a2;
                    cashShopManager17.ALLATORIxDEMO(n4);
                    cashShopManager17.K.setText(FixDropNullItem.ALLATORIxDEMO("\u6011\u5263\u8f0e\u5123\u9319\u8ae2\u0016n\u0006fHf\u0004o"));
                    return;
                }
                CashShopManager cashShopManager18 = a2;
                cashShopManager = cashShopManager18;
                cashShopManager18.ALLATORIxDEMO(n4, MapleSquad.ALLATORIxDEMO("Ri{hp~"), n11);
                break;
            }
            case 9: {
                int n12 = (Integer)defaultTableModel.getValueAt(n2, 5);
                int n13 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n13 <= 0 || n13 > 32767) {
                    CashShopManager cashShopManager19 = a2;
                    cashShopManager19.ALLATORIxDEMO(n4);
                    cashShopManager19.K.setText(FixDropNullItem.ALLATORIxDEMO("\u9065\u5131\u654e\u9189\u8f0e\u5123\u9319\u8ae2\u0016n\u0007fHf\u0005t\u0001p\u0001o"));
                    return;
                }
                if (GameConstants.getInventoryType(n12) == MapleInventoryType.EQUIP && n13 > 1) {
                    CashShopManager cashShopManager20 = a2;
                    cashShopManager20.ALLATORIxDEMO(n4);
                    cashShopManager20.K.setText(MapleSquad.ALLATORIxDEMO("\u88d1\u508c\u6574\u91da\u5fc9\u981d\u66235="));
                    return;
                }
                CashShopManager cashShopManager21 = a2;
                cashShopManager = cashShopManager21;
                cashShopManager21.ALLATORIxDEMO(n4, FixDropNullItem.ALLATORIxDEMO("\u0005Y3X2"), n13);
                break;
            }
            case 10: {
                int n14 = (Integer)defaultTableModel.getValueAt(n2, n3);
                if (n14 < -1) {
                    CashShopManager cashShopManager22 = a2;
                    cashShopManager22.ALLATORIxDEMO(n4);
                    cashShopManager22.K.setText(MapleSquad.ALLATORIxDEMO("\u9858\u591a\u65c2\u6a15\u5fd0\u9804\u5932\u65b0\u6203\u7b45\u65a9,8=\u0018\u0006\u5163\u4e215!$,\u4ef6\u8864\u9805\u8a21"));
                    return;
                }
                CashShopManager cashShopManager23 = a2;
                cashShopManager = cashShopManager23;
                cashShopManager23.ALLATORIxDEMO(n4, FixDropNullItem.ALLATORIxDEMO("\u0005Z'E5"), n14);
                break;
            }
            default: {
                cashShopManager = a2;
            }
        }
        cashShopManager.ALLATORIxDEMO(n4);
        a2.K.setText(MapleSquad.ALLATORIxDEMO("\u8cd2\u6595\u4ffb\u6535\u5b99\u621c"));
    }

    private /* synthetic */ void D() {
        CashShopManager a2;
        CashShopManager cashShopManager = a2;
        cashShopManager.d.setSelectionMode(0);
        ((DefaultTableModel)cashShopManager.d.getModel()).addTableModelListener(new TableModelListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void tableChanged(TableModelEvent a2) {
                2 a3;
                a3.CashShopManager.this.l();
            }
        });
    }

    public /* synthetic */ CashShopManager() {
        CashShopManager a2;
        int[] arrn = new int[29];
        arrn[0] = -1;
        arrn[1] = 100;
        arrn[2] = 101;
        arrn[3] = 200;
        arrn[4] = 201;
        arrn[5] = 202;
        arrn[6] = 203;
        arrn[7] = 204;
        arrn[8] = 205;
        arrn[9] = 206;
        arrn[10] = 207;
        arrn[11] = 208;
        arrn[12] = 209;
        arrn[13] = 211;
        arrn[14] = 212;
        arrn[15] = 300;
        arrn[16] = 301;
        arrn[17] = 302;
        arrn[18] = 400;
        arrn[19] = 500;
        arrn[20] = 501;
        arrn[21] = 502;
        arrn[22] = 503;
        arrn[23] = 504;
        arrn[24] = 505;
        arrn[25] = 506;
        arrn[26] = 600;
        arrn[27] = 601;
        arrn[28] = 602;
        a2.j = arrn;
        a2.i = false;
        a2.ALLATORIxDEMO();
        a2.D();
    }

    private /* synthetic */ void H() {
        CashShopManager a2;
        ((DefaultTableModel)a2.d.getModel()).getDataVector().clear();
        ((DefaultTableModel)a2.d.getModel()).fireTableDataChanged();
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void ALLATORIxDEMO(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    private /* synthetic */ void E(ActionEvent a2) {
        CashShopManager a3;
        CashShopManager cashShopManager = a3;
        CashShopManager cashShopManager2 = a3;
        cashShopManager.ALLATORIxDEMO.setEnabled(cashShopManager2.e.isSelected());
        cashShopManager.E.setEnabled(a3.e.isSelected());
        if (!cashShopManager2.e.isSelected()) {
            CashShopManager cashShopManager3 = a3;
            cashShopManager3.ALLATORIxDEMO.setText("");
            cashShopManager3.E.setSelected(false);
        }
    }

    private /* synthetic */ void H(ActionEvent a2) {
        WvsCenter.getInstance().OpenSearchGenerator();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void D(ActionEvent a) {
        v0 = a;
        v0.i = true;
        v0.K.setText(MapleSquad.ALLATORIxDEMO("\u8659\u7413\u4e215\";\""));
        a = v0.d.getSelectedRow();
        a = (Integer)((DefaultTableModel)v0.d.getModel()).getValueAt(a, 0);
        var2_4 = DatabaseConnection.getConnection();
        a.K.setText(FixDropNullItem.ALLATORIxDEMO("\u526c\u9652\u4e6b\u0016h\u0018h"));
        var2_4 = var2_4.prepareStatement(MapleSquad.ALLATORIxDEMO("HP@PXP,S^ZA5lvmfdfdz|Jeaix\u007fu,BDP^P,u_[l5153"));
        try {
            v1 = var2_4;
            v1.setInt(1, a);
            v1.execute();
            a.H(a);
            a.K.setText(FixDropNullItem.ALLATORIxDEMO("\u9065\u5131\u521c\u9622\u5bba\u6256"));
            ** if (var2_4 == null) goto lbl-1000
        }
        catch (Throwable var3_6) {
            if (var2_4 == null) ** GOTO lbl30
            try {
                var2_4.close();
                v2 = var3_6;
                ** GOTO lbl31
            }
            catch (Throwable a) {
                try {
                    var3_6.addSuppressed(a);
lbl30:
                    // 2 sources

                    v2 = var3_6;
lbl31:
                    // 2 sources

                    throw v2;
                }
                catch (SQLException var2_5) {
                    a.K.setText("\u767c\u751f\u8cc7\u6599\u5eab\u4f8b\u5916\u72c0\u6cc1 : " + var2_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_4.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        a.i = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private /* synthetic */ void I(ActionEvent a22) {
        CashShopManager a3;
        CashShopManager cashShopManager = a3;
        cashShopManager.K.setText(MapleSquad.ALLATORIxDEMO("\u8659\u7413\u4e215\";\""));
        cashShopManager.H();
        a22 = cashShopManager.ALLATORIxDEMO.getText();
        if (cashShopManager.e.isSelected() && ((String)a22).equals("")) {
            a3.K.setText(FixDropNullItem.ALLATORIxDEMO("\u764a\u7559\u9319\u8ae2\u0016\u8a8d\u6a94\u67a3\u8f0e\u5123\u6619\u5460\u6b55\u78fc"));
            return;
        }
        CashShopManager cashShopManager2 = a3;
        int n2 = cashShopManager2.j[cashShopManager2.H.getSelectedIndex()];
        Object object = new StringBuilder();
        ((StringBuilder)object).append(MapleSquad.ALLATORIxDEMO("FIYIVX5&5JGCX,uot\u007f}\u007f}ceS|xpafl"));
        if (n2 != -1 || a3.e.isSelected()) {
            ((StringBuilder)object).append(FixDropNullItem.ALLATORIxDEMO("\u0016\u0011~\u0003d\u0003"));
            if (n2 != -1) {
                ((StringBuilder)object).append(MapleSquad.ALLATORIxDEMO(",=lFBu,+1535M[H5lFBu,),*%"));
                if (a3.e.isSelected()) {
                    ((StringBuilder)object).append(FixDropNullItem.ALLATORIxDEMO("\u0016\u0007x\u0002"));
                }
            }
            if (a3.e.isSelected()) {
                ((StringBuilder)object).append(a3.E.isSelected() ? MapleSquad.ALLATORIxDEMO(",uBzxpl5153") : FixDropNullItem.ALLATORIxDEMO("\u0016&x)B#Vfz\u000f}\u0003\u0016y"));
            }
        }
        ((StringBuilder)object).append(MapleSquad.ALLATORIxDEMO("5CGHP^5NL,u_[l5MFO"));
        Connection connection = DatabaseConnection.getConnection();
        try {
            object = connection.prepareStatement(((StringBuilder)object).toString());
            try {
                CashShopManager cashShopManager3;
                block23: {
                    block19: {
                        CashShopManager cashShopManager4;
                        block22: {
                            block21: {
                                block20: {
                                    if (n2 == -1) break block20;
                                    Object object2 = object;
                                    object2.setInt(1, n2 * 100000);
                                    object2.setInt(2, (n2 + 1) * 100000);
                                    if (!a3.e.isSelected()) break block21;
                                    object.setString(3, (String)(a3.E.isSelected() ? a22 : "%" + (String)a22 + "%"));
                                    cashShopManager4 = a3;
                                    break block22;
                                }
                                if (a3.e.isSelected()) {
                                    object.setString(1, (String)(a3.E.isSelected() ? a22 : "%" + (String)a22 + "%"));
                                }
                            }
                            cashShopManager4 = a3;
                        }
                        cashShopManager4.K.setText(FixDropNullItem.ALLATORIxDEMO("\u67a3\u8a54\u4e6b\u0016h\u0018h"));
                        ResultSet resultSet = object.executeQuery();
                        try {
                            while (resultSet.next()) {
                                Object[] arrobject = new Object[11];
                                arrobject[0] = resultSet.getInt(MapleSquad.ALLATORIxDEMO("FB"));
                                arrobject[1] = resultSet.getString(FixDropNullItem.ALLATORIxDEMO("x)B#"));
                                arrobject[2] = resultSet.getInt(MapleSquad.ALLATORIxDEMO("|gevi"));
                                arrobject[3] = resultSet.getInt(FixDropNullItem.ALLATORIxDEMO("{'D-"));
                                arrobject[4] = resultSet.getInt(MapleSquad.ALLATORIxDEMO("zbfmyi"));
                                arrobject[5] = resultSet.getInt(FixDropNullItem.ALLATORIxDEMO("\u007f2S+\u007f\""));
                                arrobject[6] = resultSet.getInt(MapleSquad.ALLATORIxDEMO("E~|cgeau"));
                                arrobject[7] = resultSet.getInt(FixDropNullItem.ALLATORIxDEMO("f#D/Y\""));
                                arrobject[8] = resultSet.getInt(MapleSquad.ALLATORIxDEMO("Ri{hp~"));
                                arrobject[9] = resultSet.getInt(FixDropNullItem.ALLATORIxDEMO("\u0005Y3X2"));
                                arrobject[10] = resultSet.getInt(MapleSquad.ALLATORIxDEMO("Oymf\u007f"));
                                ((DefaultTableModel)a3.d.getModel()).insertRow(a3.d.getRowCount(), arrobject);
                            }
                            if (resultSet == null) break block19;
                            cashShopManager3 = a3;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            if (resultSet != null) {
                                try {
                                    resultSet.close();
                                    throwable2 = throwable;
                                    throw throwable2;
                                }
                                catch (Throwable a22) {
                                    throwable.addSuppressed(a22);
                                }
                            }
                            throwable2 = throwable;
                            throw throwable2;
                        }
                        resultSet.close();
                        break block23;
                    }
                    cashShopManager3 = a3;
                }
                cashShopManager3.K.setText(FixDropNullItem.ALLATORIxDEMO("\u67d3\u8a24\u5bba\u7524"));
                if (object == null) return;
            }
            catch (Throwable throwable) {
                Throwable throwable3;
                if (object != null) {
                    try {
                        object.close();
                        throwable3 = throwable;
                        throw throwable3;
                    }
                    catch (Throwable throwable4) {
                        throwable.addSuppressed(throwable4);
                    }
                }
                throwable3 = throwable;
                throw throwable3;
            }
            object.close();
            return;
        }
        catch (SQLException sQLException) {
            sQLException.printStackTrace();
            a3.K.setText("\u767c\u751f\u8cc7\u6599\u5eab\u4f8b\u5916\u72c0\u6cc1 : " + sQLException);
        }
    }

    private /* synthetic */ void l(ActionEvent a2) {
        CashShopItemAdder.main(null);
    }
}

