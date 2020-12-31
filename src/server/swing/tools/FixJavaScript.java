/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import client.messages.commands.PlayerCommand;
import handling.cashshop.handler.CashShopOperation;
import handling.channel.handler.PetHandler;
import handling.world.exped.MapleExpedition;
import java.awt.EventQueue;
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
import java.nio.charset.Charset;
import java.nio.file.Files;
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

public class FixJavaScript
extends JFrame {
    private /* synthetic */ JButton B;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JLabel a;
    private /* synthetic */ JLabel K;

    public /* synthetic */ void listDirectory(File a2, List<File> a3) {
        FixJavaScript a4;
        if (!a2.exists()) {
            System.out.println(PetHandler.ALLATORIxDEMO("\u6afa\u6849\u4e63\u5b59\u5746 "));
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

    public static /* synthetic */ JTextField ALLATORIxDEMO(FixJavaScript a2) {
        return a2.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleExpedition.ALLATORIxDEMO("\f\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%/%\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0006\f\u0006&\u0005&\u0005&\u0005&\u0005%\u0006&\u0006&\u0005&\u0006&\u0005&\u0005%\u0006&\u0006%\u0006&\u0006%\u0006&\u0006%\u0005&\u0006%\u0006&\u0005&\u0005&\u0005&\u0005%/%\u0005&\u0005&\u0005&\u0005%\u0005%\u0005%\u0005&\u0005%\u0005&\u0005%\u0005%\u0005&\u0006&\u0005%\u0005%\u0005%\u0005%\u0005&\u0006&\u0005&\u0005&\u0005&\u0005&\u0006\f\u0006&\u0005&\u0005&\u0005&\u0006%\u0006&\u0006&\u0005&\u0006&\u0005&\u0006%\u0006&\u0005%\u0005&\u0006&\u0006&\u0006%\u0005&\u0005%\u0005&\u0005&\u0005&\u0005&\u0005%/%\u0005&\u0005&\u0005&\u0005%\u0005%\u0005%\u0006%\u0005%\u0006%\u0005%\u0005%\u0005&\u0006&\u0005%\u0006%\u0005%\u0005%\u0005%\u0006%\u0005&\u0005&\u0005&\u0005&\u0006\f\u0006&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005%/%\u0005IG`PuFgQoJh\u0005d\\&djIgQiWo\u0005IG`PuFgQiW&S1\u000b5\u0005B`Kj&\u0006\f\u0006&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005%/%\u0005&\u0005&\u0005&\u0005&\u0005&\u0005nQrU<\n)RqR(DjIgQiWo\u000beJk\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0006\f\u0006&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005&\u0005%/%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006%\u0006\f"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!PetHandler.ALLATORIxDEMO(" h\u0003c\u001br").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(FixJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(FixJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(FixJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(FixJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                3 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new FixJavaScript().setVisible(true);
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        FixJavaScript a2;
        FixJavaScript fixJavaScript = a2;
        FixJavaScript fixJavaScript2 = a2;
        FixJavaScript fixJavaScript3 = a2;
        fixJavaScript2.B = new JButton();
        fixJavaScript3.k = new JLabel();
        fixJavaScript2.K = new JLabel();
        fixJavaScript2.d = new JTextField();
        fixJavaScript2.a = new JLabel();
        a2.ALLATORIxDEMO = new JTextField();
        fixJavaScript.setDefaultCloseOperation(3);
        a2.B.setText(PetHandler.ALLATORIxDEMO("\u0004C\u001bu\u001an\u00000"));
        fixJavaScript.B.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.FixJavaScript.this.ALLATORIxDEMO(a2);
            }
        });
        fixJavaScript.k.setText(MapleExpedition.ALLATORIxDEMO("\u4fcb\u6b65ogSgveWoUr\u5dc0\u5171"));
        fixJavaScript.K.setText(PetHandler.ALLATORIxDEMO("\u6a95\u6826\u8dee\u5fff;"));
        fixJavaScript.d.setText(MapleExpedition.ALLATORIxDEMO("\nuFtLvQu\nhUe"));
        fixJavaScript.a.setText(PetHandler.ALLATORIxDEMO("\u6a95\u6826\u5f8d\u7dda;"));
        fixJavaScript.ALLATORIxDEMO.setText(MapleExpedition.ALLATORIxDEMO("Ou"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        fixJavaScript.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(a2.B, -2, 97, -2)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.a, -1, -1, 32767).addComponent(a2.K, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.d, -1, 81, 32767).addComponent(a2.ALLATORIxDEMO))).addGroup(groupLayout.createSequentialGroup().addGap(27, 27, 27).addComponent(a2.k, -2, 107, -2))).addGap(0, 0, 32767))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.k, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.K).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.a).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(a2.B)));
        fixJavaScript.pack();
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        FixJavaScript a3;
        new Thread(){
            {
                2 a3;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Unable to fully structure code
             * Enabled aggressive exception aggregation
             */
            @Override
            public /* synthetic */ void run() {
                block28: {
                    var1_1 = new File(FixJavaScript.ALLATORIxDEMO(a.FixJavaScript.this).getText());
                    if (!var1_1.exists() || !var1_1.isDirectory()) break block28;
                    var2_2 = new ArrayList<File>();
                    v0 = var2_2;
                    a.FixJavaScript.this.listDirectory(var1_1, v0);
                    for (File var3_3 : v0) {
                        block27: {
                            block26: {
                                var4_5 = null;
                                var5_6 = EncodingDetect.getJavaEncode(var3_3);
                                var6_7 = false;
                                var7_8 = Files.lines(var3_3.toPath(), Charset.forName(var5_6));
                                try {
                                    var8_11 = var7_8.collect(Collectors.joining(System.lineSeparator())).toLowerCase();
                                    if (!var8_11.contains(PlayerCommand.ALLATORIxDEMO("\ba\u0005jL)\no\u0017f\u000b|\n4\ta\u001eg\bb\u0005Q\u0007a\t~\u0005zJd\u0017)M5")) && (var8_11.contains(CashShopOperation.ALLATORIxDEMO("_\u000bF\tD\u0012F\u0007U\rW\u0001SN")) || var8_11.contains(PlayerCommand.ALLATORIxDEMO("\rc\u0014a\u0016z\u0007b\u0005}\u0017&")))) {
                                        var6_7 = true;
                                    }
                                    ** if (var7_8 == null) goto lbl-1000
                                }
                                catch (Throwable var8_12) {
                                    if (var7_8 == null) ** GOTO lbl29
                                    try {
                                        var7_8.close();
                                        v1 = var8_12;
                                        ** GOTO lbl30
                                    }
                                    catch (Throwable var9_16) {
                                        try {
                                            var8_12.addSuppressed(var9_16);
lbl29:
                                            // 2 sources

                                            v1 = var8_12;
lbl30:
                                            // 2 sources

                                            throw v1;
                                        }
                                        catch (IOException var7_9) {
                                            // empty catch block
                                        }
                                    }
                                }
lbl-1000:
                                // 1 sources

                                {
                                    var7_8.close();
                                }
lbl-1000:
                                // 2 sources

                                {
                                }
                                if (!var6_7 && (!var3_3.exists() || var3_3.isDirectory() || var5_6.toUpperCase().equals(CashShopOperation.ALLATORIxDEMO("3b \u001b^")) || var5_6.toUpperCase().equals(PlayerCommand.ALLATORIxDEMO("O7M-G")))) break block26;
                                System.out.println("\u6a94\u6848\"" + var3_3.getName() + "\"\u7de8\u78bc(" + var5_6 + ") \u662f\u5426\u9700\u8981\u9069\u914dJava8(" + var6_7 + ") \u88ab\u8655\u7406");
                                try {
                                    var7_8 = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(var3_3), var5_6));
                                    if (var6_7) {
                                        v2 = CashShopOperation.ALLATORIxDEMO("Z\tW\u0002\u001eAX\u0007E\u000eY\u0014X\\[\tL\u000fZ\nW9U\t[\u0016W\u0012\u0018\fEA\u001f];l");
                                        v3 = var7_8;
                                    } else {
                                        v2 = "";
                                        v3 = var7_8;
                                    }
                                    var4_5 = v2 + v3.lines().collect(Collectors.joining(System.lineSeparator()));
                                    var7_8.close();
                                    v4 = var4_5;
                                    break block27;
                                }
                                catch (Exception var7_10) {
                                    System.out.println("FixJavaScripts\u932f\u8aa4: " + var7_10);
                                }
                            }
                            v4 = var4_5;
                        }
                        if (v4 == null) continue;
                        var7_8 = null;
                        try {
                            var7_8 = new FileOutputStream(var3_3);
                            var8_11 = new OutputStreamWriter((OutputStream)var7_8, PlayerCommand.ALLATORIxDEMO("[0HI6"));
                            var8_11.write(var4_5);
                            var8_11.flush();
                        }
                        catch (IOException var8_14) {
                            System.out.println("FixJavaScripts\u932f\u8aa4: " + var8_14);
                        }
                        finally {
                            try {
                                if (var7_8 == null) continue;
                                var7_8.close();
                            }
                            catch (IOException var8_15) {
                                System.out.println("FixJavaScripts\u932f\u8aa4: " + var8_15);
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, CashShopOperation.ALLATORIxDEMO("\u8633\u7430\u5bea\u6226\u3064"));
                }
            }
        }.start();
    }

    public /* synthetic */ FixJavaScript() {
        FixJavaScript a2;
        FixJavaScript fixJavaScript = a2;
        fixJavaScript.ALLATORIxDEMO();
    }
}

