/*
 * Decompiled with CFR 0.150.
 */
package server.swing;

import client.anticheat.CheatingOffenseEntry;
import client.messages.commands.PlayerCommand;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import server.CashItem;
import server.CashItemFactory;
import server.swing.UIWindow;
import server.swing.WvsCenter;
import tools.Pair;
import tools.SearchGenerator;

public class CashShopItemAdder
extends JFrame
implements UIWindow {
    private /* synthetic */ JScrollPane a;
    private /* synthetic */ JButton e;
    private /* synthetic */ JButton g;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JTable d;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JComboBox B;
    private /* synthetic */ JLabel K;
    private /* synthetic */ JButton E;

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        CashShopItemAdder a3;
        CashShopItemAdder cashShopItemAdder = a3;
        cashShopItemAdder.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        CashShopItemAdder cashShopItemAdder2 = a3;
        cashShopItemAdder2.setLocation((int)(dimension.getWidth() - (double)cashShopItemAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(CheatingOffenseEntry.ALLATORIxDEMO("7\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e6\u001e\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001f7\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e\u001f\u001d\u001f\u001d\u001c\u001d\u001f\u001d\u001c\u001d\u001c\u001e\u001f\u001d\u001f\u001e\u001f\u001d\u001f\u001e\u001f\u001d\u001f\u001e\u001c\u001d\u001f\u001e\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e6\u001e\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001d\u001c\u001e\u001c\u001d\u001c\u001e\u001c\u001e\u001c\u001d\u001f\u001d\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001d\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001f7\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001f\u001e\u001f\u001d\u001f\u001d\u001c\u001d\u001f\u001d\u001c\u001d\u001f\u001e\u001f\u001d\u001c\u001e\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001e\u001c\u001d\u001c\u001e\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e6\u001e\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e\u001c\u001e\u001c\u001e\u001f\u001e\u001c\u001e\u001f\u001e\u001c\u001e\u001c\u001e\u001c\u001d\u001f\u001d\u001c\u001e\u001f\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001f\u001e\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001f7\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e6\u001e\u001cr^[IN_\\HTSS\u001c_E\u001d}QP\\HRNT\u001cr^[IN_\\HRN\u001dJ\n\u0012\u000e\u001cyyps\u001d\u001f7\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e6\u001e\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001cUHIL\u0007\u0013\u0012KJK\u0013]QP\\HRNT\u0012^SP\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001f7\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001d\u001c\u001e6\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f7"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!PlayerCommand.ALLATORIxDEMO("Y\r`\u0000a\u0013}").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(CashShopItemAdder.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(CashShopItemAdder.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(CashShopItemAdder.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(CashShopItemAdder.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                5 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new CashShopItemAdder().setVisible(true);
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void search() {
        Object object;
        CashShopItemAdder a2;
        CashShopItemAdder cashShopItemAdder = a2;
        cashShopItemAdder.modelClear();
        String string = cashShopItemAdder.ALLATORIxDEMO.getText();
        int n2 = cashShopItemAdder.B.getSelectedIndex();
        Map<Integer, String> map = SearchGenerator.getSearchs(SearchGenerator.SearchType.\u9053\u5177);
        Object object2 = CashItemFactory.getInstance().getAllItems();
        LinkedList<Object> linkedList = new LinkedList<Object>();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            String string2;
            object = (CashItem)object2.next();
            switch (n2) {
                case 0: {
                    string2 = String.valueOf(((CashItem)object).getSN());
                    break;
                }
                case 1: {
                    if (map.containsKey(((CashItem)object).getId())) {
                        string2 = map.get(((CashItem)object).getId());
                        break;
                    }
                    string2 = CheatingOffenseEntry.ALLATORIxDEMO("RHPQ");
                    break;
                }
                case 2: {
                    string2 = String.valueOf(((CashItem)object).getId());
                    break;
                }
                default: {
                    return;
                }
            }
            if (!string2.toLowerCase().contains(string.toLowerCase())) continue;
            linkedList.add(object);
        }
        if (linkedList.size() > 0) {
            object2 = (DefaultTableModel)a2.d.getModel();
            Object object3 = object = linkedList.iterator();
            while (object3.hasNext()) {
                CashItem cashItem = (CashItem)object.next();
                Object[] arrobject = new Object[3];
                arrobject[0] = cashItem.getSN();
                arrobject[1] = map.get(cashItem.getId());
                arrobject[2] = cashItem.getId();
                ((DefaultTableModel)object2).addRow(arrobject);
                object3 = object;
            }
            return;
        } else {
            JOptionPane.showMessageDialog(null, PlayerCommand.ALLATORIxDEMO("\u674e\u6270\u5254\u300c"));
        }
    }

    public /* synthetic */ void init() {
        CashShopItemAdder a2;
        CashShopItemAdder cashShopItemAdder = a2;
        cashShopItemAdder.ALLATORIxDEMO.setText("");
        cashShopItemAdder.B.setSelectedIndex(0);
        cashShopItemAdder.modelClear();
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        CashShopItemAdder a2;
        CashShopItemAdder cashShopItemAdder = a2;
        CashShopItemAdder cashShopItemAdder2 = a2;
        CashShopItemAdder cashShopItemAdder3 = a2;
        CashShopItemAdder cashShopItemAdder4 = a2;
        cashShopItemAdder3.k = new JLabel();
        cashShopItemAdder4.B = new JComboBox();
        cashShopItemAdder3.e = new JButton();
        cashShopItemAdder3.ALLATORIxDEMO = new JTextField();
        cashShopItemAdder3.K = new JLabel();
        cashShopItemAdder3.a = new JScrollPane();
        cashShopItemAdder3.d = new JTable();
        cashShopItemAdder3.E = new JButton();
        cashShopItemAdder3.g = new JButton();
        cashShopItemAdder2.setDefaultCloseOperation(3);
        cashShopItemAdder.setTitle(CheatingOffenseEntry.ALLATORIxDEMO("\u557a\u57f3\u906f\u514a\u658c\u58a3"));
        cashShopItemAdder2.k.setText(PlayerCommand.ALLATORIxDEMO("\u6aac\u7d46\u9850\u57ef4"));
        String[] arrstring = new String[3];
        arrstring[0] = CheatingOffenseEntry.ALLATORIxDEMO("os");
        arrstring[1] = PlayerCommand.ALLATORIxDEMO("\u9037\u5179\u5469\u7a3f");
        arrstring[2] = CheatingOffenseEntry.ALLATORIxDEMO("\u906f\u514auy");
        cashShopItemAdder.B.setModel(new DefaultComboBoxModel<String>(arrstring));
        CashShopItemAdder cashShopItemAdder5 = a2;
        cashShopItemAdder5.e.setText(PlayerCommand.ALLATORIxDEMO("\u6ac6\u7d2c"));
        cashShopItemAdder5.e.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.CashShopItemAdder.this.l(a2);
            }
            {
                1 a3;
            }
        });
        cashShopItemAdder5.K.setText(CheatingOffenseEntry.ALLATORIxDEMO("\u6a9f\u7d1e\u515a\u5b85\u0007"));
        Object[] arrobject = new String[3];
        arrobject[0] = PlayerCommand.ALLATORIxDEMO("7@");
        arrobject[1] = CheatingOffenseEntry.ALLATORIxDEMO("\u5431\u7a0c");
        arrobject[2] = PlayerCommand.ALLATORIxDEMO("\u9037\u5179-J");
        cashShopItemAdder5.d.setModel(new DefaultTableModel(new Object[0][], arrobject){
            public /* synthetic */ boolean[] d;
            public /* synthetic */ Class[] a;

            public /* synthetic */ Class getColumnClass(int a2) {
                2 a3;
                return a3.a[a2];
            }
            {
                2 a5;
                super(a3, a4);
                Class[] arrclass = new Class[3];
                arrclass[0] = Integer.class;
                arrclass[1] = String.class;
                arrclass[2] = Integer.class;
                a5.a = arrclass;
                boolean[] arrbl = new boolean[3];
                arrbl[0] = 0;
                arrbl[1] = false;
                arrbl[2] = false;
                a5.d = arrbl;
            }

            @Override
            public /* synthetic */ boolean isCellEditable(int a2, int a3) {
                2 a4;
                return a4.d[a3];
            }
        });
        CashShopItemAdder cashShopItemAdder6 = a2;
        CashShopItemAdder cashShopItemAdder7 = a2;
        cashShopItemAdder6.a.setViewportView(cashShopItemAdder7.d);
        cashShopItemAdder6.E.setText(CheatingOffenseEntry.ALLATORIxDEMO("\u7886\u8ab0\u658c\u58a3"));
        cashShopItemAdder7.E.addActionListener(new ActionListener(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.CashShopItemAdder.this.H(a2);
            }
        });
        cashShopItemAdder6.g.setText("\u53d6\u6d88");
        cashShopItemAdder6.g.addActionListener(new ActionListener(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                4 a3;
                a3.CashShopItemAdder.this.ALLATORIxDEMO(a2);
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        cashShopItemAdder6.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.E, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.g, -2, 184, -2)).addComponent(a2.a, -2, 374, -2).addGroup(groupLayout.createSequentialGroup().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B, -2, 68, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.K).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e))).addContainerGap(-1, 32767)));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.B, -2, -1, -2).addComponent(a2.e).addComponent(a2.ALLATORIxDEMO, -2, -1, -2).addComponent(a2.K)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.E).addComponent(a2.g)).addContainerGap()));
        cashShopItemAdder6.pack();
    }

    public /* synthetic */ CashShopItemAdder() {
        CashShopItemAdder a2;
        CashShopItemAdder cashShopItemAdder = a2;
        cashShopItemAdder.ALLATORIxDEMO();
        cashShopItemAdder.d.getColumnModel().getColumn(0).setPreferredWidth(75);
        cashShopItemAdder.d.getColumnModel().getColumn(1).setPreferredWidth(275);
        cashShopItemAdder.d.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private /* synthetic */ void l(ActionEvent a2) {
        CashShopItemAdder a3;
        a3.search();
    }

    public /* synthetic */ void modelClear() {
        int n2;
        CashShopItemAdder a2;
        DefaultTableModel defaultTableModel = (DefaultTableModel)a2.d.getModel();
        int n3 = defaultTableModel.getRowCount();
        int n4 = n2 = 0;
        while (n4 < n3) {
            defaultTableModel.removeRow(0);
            n4 = ++n2;
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        CashShopItemAdder a3;
        a3.setVisible(false);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        int n2;
        CashShopItemAdder a3;
        if (a3.d.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, PlayerCommand.ALLATORIxDEMO("\u674e\u9076\u64a3\u300c"));
            return;
        }
        a2 = new LinkedList();
        int[] arrn = a3.d.getSelectedRows();
        int n3 = arrn.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = arrn[n2];
            a2.add(new Pair<Integer, String>((Integer)a3.d.getValueAt(n5, 0), (String)a3.d.getValueAt(n5, 1)));
            n4 = ++n2;
        }
        WvsCenter.getInstance().addCashShopItem((List<Pair<Integer, String>>)((Object)a2));
        a3.setVisible(false);
    }
}

