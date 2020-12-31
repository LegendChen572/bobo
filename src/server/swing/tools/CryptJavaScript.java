/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u672a\u77e5\u8c37
 */
package server.swing.tools;

import client.MapleFriendship;
import client.messages.commands.player.\u672a\u77e5\u8c37;
import constants.GameSetConstants;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.swing.tools.EncodingDetect;
import tools.Pair;
import tools.crypt.AESOperator;
import tools.data.RandomAccessByteStream;

public class CryptJavaScript
extends JFrame {
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton B;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JLabel K;
    private /* synthetic */ JButton g;
    private /* synthetic */ JLabel a;
    private /* synthetic */ JTextField d;

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        CryptJavaScript a3;
        a3.ALLATORIxDEMO(true);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        CryptJavaScript a2;
        CryptJavaScript cryptJavaScript = a2;
        CryptJavaScript cryptJavaScript2 = a2;
        CryptJavaScript cryptJavaScript3 = a2;
        cryptJavaScript2.g = new JButton();
        cryptJavaScript3.k = new JLabel();
        cryptJavaScript2.K = new JLabel();
        cryptJavaScript2.d = new JTextField();
        cryptJavaScript2.a = new JLabel();
        cryptJavaScript2.ALLATORIxDEMO = new JTextField();
        a2.B = new JButton();
        cryptJavaScript.setDefaultCloseOperation(3);
        a2.g.setText(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u5295\u5bc7"));
        cryptJavaScript.g.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.CryptJavaScript.this.l(a2);
            }
        });
        cryptJavaScript.k.setText(MapleFriendship.ALLATORIxDEMO("\u528b\u5bdeay]yx{Yq[l\u5dce\u516f"));
        cryptJavaScript.K.setText(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u6a95\u687d\u8dee\u5fa4;"));
        cryptJavaScript.d.setText(GameSetConstants.getNpcFolder());
        cryptJavaScript.d.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.CryptJavaScript.this.H(a2);
            }
        });
        cryptJavaScript.a.setText(MapleFriendship.ALLATORIxDEMO("\u6a8c\u6863\u5f94\u7d9f\""));
        cryptJavaScript.ALLATORIxDEMO.setText(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"_r"));
        cryptJavaScript.B.setText(MapleFriendship.ALLATORIxDEMO("\u89c8\u5bde"));
        cryptJavaScript.B.addActionListener(new ActionListener(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.CryptJavaScript.this.ALLATORIxDEMO(a2);
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        cryptJavaScript.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.g, GroupLayout.Alignment.TRAILING, -1, 205, 32767).addComponent(a2.B, -1, 205, 32767).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.a, -1, -1, 32767).addComponent(a2.K, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.d, -1, 144, 32767).addComponent(a2.ALLATORIxDEMO))).addComponent(a2.k, -2, 120, -2)).addGap(0, 0, 32767))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.k, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.K).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.a).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.g, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B, -1, -1, 32767).addContainerGap()));
        cryptJavaScript.pack();
    }

    private /* synthetic */ void l(ActionEvent a2) {
        if (!GameSetConstants.SELF_BUY) {
            CryptJavaScript a3;
            a3.ALLATORIxDEMO(false);
        }
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        CryptJavaScript a3;
        CryptJavaScript cryptJavaScript = a3;
        cryptJavaScript.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        CryptJavaScript cryptJavaScript2 = a3;
        cryptJavaScript2.setLocation((int)(dimension.getWidth() - (double)cryptJavaScript2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(final boolean a2) {
        CryptJavaScript a3;
        new Thread(){
            {
                4 a3;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public /* synthetic */ void run() {
                4 a22;
                File file = new File(a22.CryptJavaScript.this.d.getText());
                if (file.exists() && file.isDirectory()) {
                    Object object = new ArrayList<File>();
                    ArrayList<File> arrayList = object;
                    a22.CryptJavaScript.this.listDirectory(file, arrayList);
                    object = arrayList.iterator();
                    block15: while (true) {
                        Object object2 = object;
                        while (object2.hasNext()) {
                            String string;
                            Object object3 = (File)object.next();
                            String string2 = null;
                            Object object4 = null;
                            try {
                                object4 = EncodingDetect.getJavaEncode((File)object3);
                            }
                            catch (Exception exception) {
                                System.out.println("getJavaEncode: " + exception);
                                object2 = object;
                                continue;
                            }
                            String string3 = a22.a2 ? Pair.ALLATORIxDEMO("\u8987\u5bda") : RandomAccessByteStream.ALLATORIxDEMO("\u52a5\u5b8b");
                            System.out.println("\u6a94\u6848\"" + ((File)object3).getName() + "\"\u7de8\u78bc(" + (String)object4 + ") " + string3 + "\u8655\u7406\u4e2d");
                            try {
                                Object object5;
                                object4 = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream((File)object3), (String)object4));
                                if (a22.a2) {
                                    string2 = AESOperator.getInstance().decrypt(((BufferedReader)object4).lines().collect(Collectors.joining(System.lineSeparator())));
                                    object5 = object4;
                                } else {
                                    string2 = AESOperator.getInstance().encrypt(((BufferedReader)object4).lines().collect(Collectors.joining(System.lineSeparator())));
                                    object5 = object4;
                                }
                                ((BufferedReader)object5).close();
                                string = string2;
                            }
                            catch (Exception exception) {
                                System.out.println("CryptJavaScript: " + exception);
                                string = string2;
                            }
                            if (string == null) continue block15;
                            object4 = null;
                            try {
                                object4 = new FileOutputStream((File)object3);
                                object3 = new OutputStreamWriter((OutputStream)object4, Pair.ALLATORIxDEMO("I0ZI$"));
                                ((Writer)object3).write(string2);
                                ((OutputStreamWriter)object3).flush();
                                continue block15;
                            }
                            catch (IOException iOException) {
                                System.out.println("CryptJavaScript\u932f\u8aa4: " + iOException);
                                continue block15;
                            }
                            finally {
                                try {
                                    if (object4 == null) continue block15;
                                    ((FileOutputStream)object4).close();
                                }
                                catch (IOException iOException) {
                                    System.out.println("CryptJavaScript\u932f\u8aa4: " + iOException);
                                }
                                continue block15;
                            }
                        }
                        break;
                    }
                    JOptionPane.showMessageDialog(null, RandomAccessByteStream.ALLATORIxDEMO("\u8618\u7403\u5bc1\u6215\u304f"));
                }
            }
        }.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleFriendship.ALLATORIxDEMO("\u0012\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;!;\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b;\b8\b8\u000b8\b8\u000b8\u000b;\b8\b;\b8\b;\b8\b;\u000b8\b;\b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b;\u000b;\u000b;\u000b8\u000b;\u000b8\u000b;\u000b;\u000b8\b8\u000b;\u000b;\u000b;\u000b;\u000b8\b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\b;\b8\b8\u000b8\b8\u000b8\b;\b8\u000b;\u000b8\b8\b8\b;\u000b8\u000b;\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b;\u000b;\u000b;\b;\u000b;\b;\u000b;\u000b;\u000b8\b8\u000b;\b;\u000b;\u000b;\u000b;\b;\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000bWI~^kHy_qDv\u000bzR8jtGy_wYq\u000bWI~^kHy_wY8]/\u0005+\u000b\\nUd8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b8\u000b8\u000bp_l[\"\u00047\\o\\6JtGy_wYq\u0005{Du\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b\u0012"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"V\\oQnBr").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleFriendship.ALLATORIxDEMO("OBvOw\\k").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(CryptJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                5 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new CryptJavaScript().setVisible(true);
            }
        });
    }

    private /* synthetic */ void H(ActionEvent a2) {
    }

    public /* synthetic */ CryptJavaScript() {
        CryptJavaScript a2;
        CryptJavaScript cryptJavaScript = a2;
        cryptJavaScript.ALLATORIxDEMO();
    }

    public /* synthetic */ void listDirectory(File a2, List<File> a3) {
        CryptJavaScript a4;
        if (!a2.exists()) {
            System.out.println(\u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u6aa1\u6849\u4e38\u5b59\u571d "));
            return;
        }
        if (a2.isFile()) {
            if (a2.getName().endsWith("." + a4.ALLATORIxDEMO.getText().toLowerCase()) || a2.getName().endsWith("." + a4.ALLATORIxDEMO.getText().toUpperCase())) {
                a3.add((File)a2);
                return;
            }
        } else {
            int n2;
            a2 = a2.listFiles();
            int n3 = n2 = 0;
            while (n3 < a2.length) {
                a4.listDirectory(a2[n2++], a3);
                n3 = n2;
            }
        }
    }
}

