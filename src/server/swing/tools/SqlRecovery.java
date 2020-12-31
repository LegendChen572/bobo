/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 */
package server.swing.tools;

import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.life.MonsterDropEntry;
import server.swing.UIWindow;
import tools.FileoutputUtil;
import tools.database.MysqlBackup;
import tools.database.UniqueIdReset;
import tools.npcgenerator.Instruction;

public class SqlRecovery
extends JFrame
implements UIWindow {
    private /* synthetic */ JFileChooser ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(Instruction.ALLATORIxDEMO("k9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B\u0010B:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A9k9A:A:A:A:B9A9A:A9A:A:B9A9B9A9B9A9B:A9B9A:A:A:A:B\u0010B:A:A:A:B:B:B:A:B:A:B:B:A9A:B:B:B:B:A9A:A:A:A:A9k9A:A:A:A9B9A9A:A9A:A9B9A:B:A9A9A9B:A:B:A:A:A:A:B\u0010B:A:A:A:B:B:B9B:B9B:B:B:A9A:B9B:B:B:B9B:A:A:A:A9k9A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:B\u0010B:.x\u0007o\u0012y\u0000n\bu\u000f:\u0003cA[\rv\u0000n\u000eh\b:.x\u0007o\u0012y\u0000n\u000ehAlV4R:%_,UA9k9A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:B\u0010B:A:A:A:A:A:\tn\u0015j[5Nm\u0016mO{\rv\u0000n\u000eh\b4\u0002u\f:A:A:A:A:A:A9k9A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:B\u0010B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9k"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!UniqueIdReset.ALLATORIxDEMO("0o\tb\bq\u0014").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(SqlRecovery.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(SqlRecovery.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(SqlRecovery.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(SqlRecovery.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                new SqlRecovery().setVisible(true);
            }
            {
                3 a2;
            }
        });
    }

    private static /* synthetic */ String ALLATORIxDEMO() {
        return new File("").getAbsolutePath() + File.separator + "backup";
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        SqlRecovery a3;
        if (a2.getActionCommand().equals(UniqueIdReset.ALLATORIxDEMO("G\u0017v\u0015i\u0011c4c\u000bc\u0004r\u000ei\t"))) {
            new Thread(){
                {
                    2 a3;
                }

                @Override
                public /* synthetic */ void run() {
                    2 a2;
                    if (a2.SqlRecovery.this.ALLATORIxDEMO.getSelectedFile() == null) {
                        a2.SqlRecovery.this.setVisible(false);
                        return;
                    }
                    String string = a2.SqlRecovery.this.ALLATORIxDEMO.getSelectedFile().toString();
                    if (string.contains(MonsterDropEntry.ALLATORIxDEMO("\u0011DN["))) {
                        if (JOptionPane.showConfirmDialog(null, "\u60a8\u662f\u5426\u78ba\u5b9a\u8981\u9084\u539f\u6a94\u6848 : " + string + " ?", \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u8b1b\u544b"), -1, 1, null) == 0) {
                            2 v0 = a2;
                            v0.SqlRecovery.this.setVisible(false);
                            MysqlBackup.RecoverData(v0.SqlRecovery.this.ALLATORIxDEMO.getSelectedFile().toString());
                            JOptionPane.showMessageDialog(null, MonsterDropEntry.ALLATORIxDEMO("\u90b3\u53a0\u5bbb\u755d\u0016"));
                            String string2 = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
                            System.out.println("Pid is:" + string2);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("taskkill /f /PID " + string2 + "\r\n");
                            stringBuilder.append(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u000eu\u001cs\t!?N?NSd\u0005dp\u000b"));
                            stringBuilder.append(MonsterDropEntry.ALLATORIxDEMO("RG^LC2="));
                            FileoutputUtil.logToFile(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"<t\tn(q\u0019`\tdSc\u001cu"), stringBuilder.toString());
                            try {
                                Runtime.getRuntime().exec(MonsterDropEntry.ALLATORIxDEMO("~BKXjG[VKR\u0011U^C"));
                                return;
                            }
                            catch (IOException iOException) {
                                Logger.getLogger(SqlRecovery.class.getName()).log(Level.SEVERE, null, iOException);
                                return;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, \u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u6a95\u6835\u578a\u6136\u932e\u8ad9 "));
                    }
                }
            }.start();
            return;
        }
        a3.setVisible(false);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        SqlRecovery a3;
        SqlRecovery sqlRecovery = a3;
        sqlRecovery.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        SqlRecovery sqlRecovery2 = a3;
        sqlRecovery2.setLocation((int)(dimension.getWidth() - (double)sqlRecovery2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    public /* synthetic */ SqlRecovery() {
        SqlRecovery a2;
        SqlRecovery sqlRecovery = a2;
        sqlRecovery.ALLATORIxDEMO();
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        SqlRecovery a2;
        SqlRecovery sqlRecovery = a2;
        SqlRecovery sqlRecovery2 = a2;
        a2.ALLATORIxDEMO = new JFileChooser(SqlRecovery.ALLATORIxDEMO());
        a2.setDefaultCloseOperation(3);
        sqlRecovery.ALLATORIxDEMO.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.SqlRecovery.this.ALLATORIxDEMO(a2);
            }
            {
                1 a3;
            }
        });
        SqlRecovery sqlRecovery3 = a2;
        GroupLayout groupLayout = new GroupLayout(sqlRecovery3.getContentPane());
        sqlRecovery3.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.ALLATORIxDEMO, -2, -1, -2));
        groupLayout2.setVerticalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.ALLATORIxDEMO, -2, -1, -2).addGap(0, 0, 32767)));
        sqlRecovery.pack();
    }
}

