/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.formdev.flatlaf.FlatLightLaf
 */
package server.swing.Item;

import com.formdev.flatlaf.FlatLightLaf;
import handling.world.family.MapleFamilyCharacter;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import server.swing.WvsCenter;
import tools.otp.HmacOneTimePasswordGenerator;

public class ItemsSearch
extends JFrame {
    private /* synthetic */ JPanel d;
    private /* synthetic */ JTable a;
    private /* synthetic */ JScrollPane ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleFamilyCharacter.ALLATORIxDEMO("H\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a.a\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0007H\u0007b\u0004b\u0004b\u0004b\u0004a\u0007b\u0007b\u0004b\u0007b\u0004b\u0004a\u0007b\u0007a\u0007b\u0007a\u0007b\u0007a\u0004b\u0007a\u0007b\u0004b\u0004b\u0004b\u0004a.a\u0004b\u0004b\u0004b\u0004a\u0004a\u0004a\u0004b\u0004a\u0004b\u0004a\u0004a\u0004b\u0007b\u0004a\u0004a\u0004a\u0004a\u0004b\u0007b\u0004b\u0004b\u0004b\u0004b\u0007H\u0007b\u0004b\u0004b\u0004b\u0007a\u0007b\u0007b\u0004b\u0007b\u0004b\u0007a\u0007b\u0004a\u0004b\u0007b\u0007b\u0007a\u0004b\u0004a\u0004b\u0004b\u0004b\u0004b\u0004a.a\u0004b\u0004b\u0004b\u0004a\u0004a\u0004a\u0007a\u0004a\u0007a\u0004a\u0004a\u0004b\u0007b\u0004a\u0007a\u0004a\u0004a\u0004a\u0007a\u0004b\u0004b\u0004b\u0004b\u0007H\u0007b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004a.a\u0004\rF$Q1G#P+K,\u0004 ]be.H#P-V+\u0004\rF$Q1G#P-VbRu\nq\u0004\u0006a\u000fkb\u0007H\u0007b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004a.a\u0004b\u0004b\u0004b\u0004b\u0004b\u0004*P6Tx\u000bmS5SlE.H#P-V+\n!K/\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0007H\u0007b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004b\u0004a.a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007a\u0007H"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u0019s:x\"i").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(ItemsSearch.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(ItemsSearch.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(ItemsSearch.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(ItemsSearch.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                2 a2;
            }

            @Override
            public /* synthetic */ void run() {
                2 a2;
                new Thread(new Runnable(){
                    {
                        1 a3;
                    }

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

                                new ItemsSearch().setVisible(true);
                                return;
                            }
                            catch (Exception var1_2) {
                                var1_2.printStackTrace();
                                return;
                            }
                        }
                    }
                }).start();
            }
        });
    }

    public /* synthetic */ ItemsSearch() {
        Iterator iterator;
        Iterator iterator2;
        Object[] arrobject;
        Object[] arrobject2;
        ItemsSearch a4;
        ItemsSearch itemsSearch = a4;
        itemsSearch.ALLATORIxDEMO();
        DefaultTableModel defaultTableModel = (DefaultTableModel)itemsSearch.a.getModel();
        defaultTableModel.getDataVector().removeAllElements();
        defaultTableModel.fireTableDataChanged();
        LinkedList<Object[]> linkedList = WvsCenter.getInstance().lists;
        HashMap<String, Object[]> hashMap = new HashMap<String, Object[]>();
        String string = "";
        for (Object[] object2 : linkedList) {
            arrobject2 = (String)object2[2];
            arrobject = (Object[])object2[4];
            if (string.isEmpty()) {
                string = (String)object2[1];
            }
            if (hashMap.get(arrobject2) == null) {
                hashMap.put((String)object2[2], arrobject);
                continue;
            }
            arrobject = arrobject.intValue() + (Integer)hashMap.get(arrobject2);
            hashMap.remove((String)object2[2]);
            hashMap.put((String)object2[2], arrobject);
        }
        linkedList = new LinkedList<Object[]>();
        Iterator iterator3 = iterator2 = hashMap.entrySet().iterator();
        while (iterator3.hasNext()) {
            arrobject2 = iterator2.next();
            Object[] arrobject3 = new Object[3];
            arrobject3[0] = arrobject2.getKey();
            arrobject3[1] = string;
            arrobject3[2] = arrobject2.getValue();
            arrobject = arrobject3;
            iterator3 = iterator2;
            linkedList.add(arrobject);
        }
        Collections.sort(linkedList, (a2, a3) -> (Integer)a3[2] - (Integer)a2[2]);
        Iterator iterator4 = iterator = linkedList.iterator();
        while (iterator4.hasNext()) {
            arrobject2 = (Object[])iterator.next();
            ((DefaultTableModel)a4.a.getModel()).insertRow(a4.a.getRowCount(), arrobject2);
            iterator4 = iterator;
        }
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        ItemsSearch a3;
        ItemsSearch itemsSearch = a3;
        itemsSearch.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        ItemsSearch itemsSearch2 = a3;
        itemsSearch2.setLocation((int)(dimension.getWidth() - (double)itemsSearch2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        ItemsSearch a2;
        ItemsSearch itemsSearch = a2;
        ItemsSearch itemsSearch2 = a2;
        itemsSearch2.d = new JPanel();
        itemsSearch2.ALLATORIxDEMO = new JScrollPane();
        itemsSearch.a = new JTable();
        itemsSearch.setDefaultCloseOperation(3);
        Object[] arrobject = new String[3];
        arrobject[0] = HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u73fe\u5bac\u545a\u7a2b");
        arrobject[1] = MapleFamilyCharacter.ALLATORIxDEMO("\u724d\u5483\u5429\u7a73");
        arrobject[2] = HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u723e\u54db\u652f\u91d5");
        itemsSearch.a.setModel(new DefaultTableModel(new Object[0][], arrobject){
            public /* synthetic */ Class[] d;
            {
                1 a5;
                super(a3, a4);
                Class[] arrclass = new Class[3];
                arrclass[0] = String.class;
                arrclass[1] = String.class;
                arrclass[2] = Integer.class;
                a5.d = arrclass;
            }

            public /* synthetic */ Class getColumnClass(int a2) {
                1 a3;
                return a3.d[a2];
            }
        });
        ItemsSearch itemsSearch3 = a2;
        a2.ALLATORIxDEMO.setViewportView(itemsSearch3.a);
        if (itemsSearch3.a.getColumnModel().getColumnCount() > 0) {
            ItemsSearch itemsSearch4 = a2;
            itemsSearch4.a.getColumnModel().getColumn(0).setResizable(false);
            itemsSearch4.a.getColumnModel().getColumn(2).setResizable(false);
        }
        GroupLayout groupLayout = new GroupLayout(a2.d);
        ItemsSearch itemsSearch5 = a2;
        GroupLayout groupLayout2 = groupLayout;
        itemsSearch5.d.setLayout(groupLayout2);
        GroupLayout groupLayout3 = groupLayout;
        groupLayout3.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addComponent(a2.ALLATORIxDEMO, -2, 475, -2).addGap(0, 0, 32767)));
        groupLayout2.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.ALLATORIxDEMO, -1, 500, 32767));
        groupLayout = new GroupLayout(a2.getContentPane());
        itemsSearch5.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout4 = groupLayout;
        groupLayout4.setHorizontalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.d, -1, -1, 32767));
        ItemsSearch itemsSearch6 = a2;
        groupLayout4.setVerticalGroup(groupLayout4.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(itemsSearch6.d, -1, -1, 32767));
        itemsSearch6.pack();
    }
}

