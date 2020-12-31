/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import client.inventory.PetCommand;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
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
import server.ItemInformation;
import server.swing.UIWindow;
import tools.SearchGenerator;

public class SearchGeneratorUI
extends JFrame
implements UIWindow {
    private /* synthetic */ JTable d;
    private /* synthetic */ JButton g;
    private /* synthetic */ JLabel K;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JComboBox B;
    private /* synthetic */ JScrollPane a;

    public /* synthetic */ boolean addModel(SearchGenerator.SearchType a2, Map<Integer, String> a3, boolean a42) {
        Iterator<Integer> iterator;
        SearchGeneratorUI a5;
        if (a3 == null || a3.isEmpty()) {
            if (a42) {
                JOptionPane.showMessageDialog(null, ItemInformation.ALLATORIxDEMO("\u6771\u623d\u526b\u3041"));
            }
            return false;
        }
        DefaultTableModel a42 = (DefaultTableModel)a5.d.getModel();
        Iterator<Integer> iterator2 = iterator = a3.keySet().iterator();
        while (iterator2.hasNext()) {
            int n2 = iterator.next();
            Object[] arrobject = new Object[3];
            arrobject[0] = a2.name();
            arrobject[1] = a3.get(n2);
            arrobject[2] = n2;
            a42.addRow(arrobject);
            iterator2 = iterator;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(ItemInformation.ALLATORIxDEMO("Ix`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`Q`{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{cxIxc{c{c{c{`xcxc{cxc{c{`xcx`xcx`xcx`{cx`xc{c{c{c{`Q`{c{c{c{`{`{`{c{`{c{`{`{cxc{`{`{`{`{cxc{c{c{c{cxIxc{c{c{cx`xcxc{cxc{cx`xc{`{cxcxcx`{c{`{c{c{c{c{`Q`{c{c{c{`{`{`x`{`x`{`{`{cxc{`x`{`{`{`x`{c{c{c{cxIxc{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{`Q`{\f9%.08\"/*4-{!\"c\u001a/7\"/,)*{\f9%.08\"/,)c-tup{\u0007\u001e\u000e\u0014cxIxc{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{`Q`{c{c{c{c{c{+/7+ytl,4,m:/7\"/,)*u 4.{c{c{c{c{c{cxIxc{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{`Q`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`xI"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!PetCommand.ALLATORIxDEMO("bv[{ZhF").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(SearchGeneratorUI.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(SearchGeneratorUI.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(SearchGeneratorUI.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(SearchGeneratorUI.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                3 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new SearchGeneratorUI().setVisible(true);
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        SearchGeneratorUI a3;
        a3.search();
    }

    public /* synthetic */ boolean addModel(int a2, Map<Integer, String> a3, boolean a4) {
        SearchGeneratorUI a5;
        return a5.addModel(SearchGenerator.SearchType.valueOf(SearchGenerator.SearchType.nameOf(a2)), a3, a4);
    }

    public /* synthetic */ void init() {
        SearchGeneratorUI a2;
        SearchGeneratorUI searchGeneratorUI = a2;
        searchGeneratorUI.ALLATORIxDEMO.setText("");
        searchGeneratorUI.B.setSelectedIndex(0);
        searchGeneratorUI.modelClear();
    }

    public /* synthetic */ void search() {
        SearchGeneratorUI a2;
        SearchGeneratorUI searchGeneratorUI = a2;
        searchGeneratorUI.modelClear();
        String string = searchGeneratorUI.ALLATORIxDEMO.getText();
        int n2 = searchGeneratorUI.B.getSelectedIndex();
        if (n2 == 0) {
            int n3;
            boolean bl = false;
            int n4 = n3 = 1;
            while (n4 <= SearchGenerator.\u8077\u696d) {
                int n5 = n3;
                boolean bl2 = a2.addModel(n5, SearchGenerator.getSearchData(n3, string), n5 == SearchGenerator.\u8077\u696d ? !bl : false);
                if (!bl) {
                    bl = bl2;
                }
                n4 = ++n3;
            }
        } else {
            int n6 = n2;
            a2.addModel(n6, SearchGenerator.getSearchData(n6, string), true);
        }
    }

    public /* synthetic */ SearchGeneratorUI() {
        SearchGeneratorUI a2;
        SearchGeneratorUI searchGeneratorUI = a2;
        searchGeneratorUI.ALLATORIxDEMO();
        searchGeneratorUI.d.getColumnModel().getColumn(0).setPreferredWidth(75);
        searchGeneratorUI.d.getColumnModel().getColumn(1).setPreferredWidth(275);
        searchGeneratorUI.d.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        SearchGeneratorUI a3;
        SearchGeneratorUI searchGeneratorUI = a3;
        searchGeneratorUI.init();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        SearchGeneratorUI searchGeneratorUI2 = a3;
        searchGeneratorUI2.setLocation((int)(dimension.getWidth() - (double)searchGeneratorUI2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        SearchGeneratorUI a2;
        SearchGeneratorUI searchGeneratorUI = a2;
        SearchGeneratorUI searchGeneratorUI2 = a2;
        SearchGeneratorUI searchGeneratorUI3 = a2;
        SearchGeneratorUI searchGeneratorUI4 = a2;
        searchGeneratorUI3.k = new JLabel();
        searchGeneratorUI4.B = new JComboBox();
        searchGeneratorUI3.g = new JButton();
        searchGeneratorUI3.ALLATORIxDEMO = new JTextField();
        searchGeneratorUI3.K = new JLabel();
        searchGeneratorUI3.a = new JScrollPane();
        searchGeneratorUI3.d = new JTable();
        searchGeneratorUI2.setDefaultCloseOperation(3);
        searchGeneratorUI.setTitle(PetCommand.ALLATORIxDEMO("\u4ed6\u78a3\u6a97\u7d3d\u565d"));
        searchGeneratorUI2.k.setText(ItemInformation.ALLATORIxDEMO("\u6ae1\u7d79\u981d\u57d0y"));
        String[] arrstring = new String[8];
        arrstring[0] = PetCommand.ALLATORIxDEMO("\u5177\u90dd");
        arrstring[1] = ItemInformation.ALLATORIxDEMO("\u9008\u5134");
        arrstring[2] = PetCommand.ALLATORIxDEMO("{Ov");
        arrstring[3] = ItemInformation.ALLATORIxDEMO("\u576b\u5755");
        arrstring[4] = PetCommand.ALLATORIxDEMO("\u6035\u725c");
        arrstring[5] = ItemInformation.ALLATORIxDEMO("\u4ea0\u529a");
        arrstring[6] = PetCommand.ALLATORIxDEMO("\u629f\u80c8");
        arrstring[7] = ItemInformation.ALLATORIxDEMO("\u802c\u692e");
        searchGeneratorUI.B.setModel(new DefaultComboBoxModel<String>(arrstring));
        SearchGeneratorUI searchGeneratorUI5 = a2;
        searchGeneratorUI5.g.setText(PetCommand.ALLATORIxDEMO("\u6abd\u7d17"));
        searchGeneratorUI5.g.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.SearchGeneratorUI.this.ALLATORIxDEMO(a2);
            }
            {
                1 a3;
            }
        });
        searchGeneratorUI5.K.setText(ItemInformation.ALLATORIxDEMO("\u6ae1\u7d79\u5124\u5be2y"));
        Object[] arrobject = new String[3];
        arrobject[0] = PetCommand.ALLATORIxDEMO("\u9841\u57be");
        arrobject[1] = ItemInformation.ALLATORIxDEMO("\u5456\u7a72");
        arrobject[2] = PetCommand.ALLATORIxDEMO("\u5009");
        searchGeneratorUI5.d.setModel(new DefaultTableModel(new Object[0][], arrobject){
            public /* synthetic */ boolean[] d;
            public /* synthetic */ Class[] a;

            public /* synthetic */ Class getColumnClass(int a2) {
                2 a3;
                return a3.a[a2];
            }

            @Override
            public /* synthetic */ boolean isCellEditable(int a2, int a3) {
                2 a4;
                return a4.d[a3];
            }
            {
                2 a5;
                super(a3, a4);
                Class[] arrclass = new Class[3];
                arrclass[0] = String.class;
                arrclass[1] = String.class;
                arrclass[2] = Integer.class;
                a5.a = arrclass;
                boolean[] arrbl = new boolean[3];
                arrbl[0] = 0;
                arrbl[1] = 1;
                arrbl[2] = true;
                a5.d = arrbl;
            }
        });
        SearchGeneratorUI searchGeneratorUI6 = a2;
        SearchGeneratorUI searchGeneratorUI7 = a2;
        searchGeneratorUI6.a.setViewportView(searchGeneratorUI7.d);
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        searchGeneratorUI6.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.a, -2, 374, -2).addGroup(groupLayout.createSequentialGroup().addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.K).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.ALLATORIxDEMO, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.g))).addContainerGap(-1, 32767)));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.B, -2, -1, -2).addComponent(a2.g).addComponent(a2.ALLATORIxDEMO, -2, -1, -2).addComponent(a2.K)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.a, -2, 251, -2).addContainerGap()));
        searchGeneratorUI7.pack();
    }

    public /* synthetic */ void modelClear() {
        int n2;
        SearchGeneratorUI a2;
        DefaultTableModel defaultTableModel = (DefaultTableModel)a2.d.getModel();
        int n3 = defaultTableModel.getRowCount();
        int n4 = n2 = 0;
        while (n4 < n3) {
            defaultTableModel.removeRow(0);
            n4 = ++n2;
        }
    }
}

