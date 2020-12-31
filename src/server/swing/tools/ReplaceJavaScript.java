/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import client.MapleCoreAura;
import constants.GameSetConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.Closeable;
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
import tools.FileOperation;

public class ReplaceJavaScript
extends JFrame {
    private /* synthetic */ JLabel K;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JTextField e;
    private /* synthetic */ JTextField H;
    private /* synthetic */ JLabel a;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton E;
    private /* synthetic */ JTextField d;

    public /* synthetic */ ReplaceJavaScript() {
        ReplaceJavaScript a2;
        ReplaceJavaScript replaceJavaScript = a2;
        replaceJavaScript.H();
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        ReplaceJavaScript a3;
        ReplaceJavaScript replaceJavaScript = a3;
        replaceJavaScript.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        ReplaceJavaScript replaceJavaScript2 = a3;
        replaceJavaScript2.setLocation((int)(dimension.getWidth() - (double)replaceJavaScript2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleCoreAura.ALLATORIxDEMO("\u0006S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/z/P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,S\u0006S,P,P,P,P/S,S,P,S,P,P/S,S/S,S/S,S/P,S/S,P,P,P,P/z/P,P,P,P/P/P/P,P/P,P/P/P,S,P/P/P/P/P,S,P,P,P,P,S\u0006S,P,P,P,S/S,S,P,S,P,S/S,P/P,S,S,S/P,P/P,P,P,P,P/z/P,P,P,P/P/P/S/P/S/P/P/P,S,P/S/P/P/P/S/P,P,P,P,S\u0006S,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P/z/PC\u0012j\u0005\u007f\u0013m\u0004e\u001fbPn\t,1`\u001cm\u0004c\u0002ePC\u0012j\u0005\u007f\u0013m\u0004c\u0002,\u0006;^?PH5A?,S\u0006S,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P/z/P,P,P,P,P,Pd\u0004x\u00006_#\u0007{\u0007\"\u0011`\u001cm\u0004c\u0002e^o\u001faP,P,P,P,P,P,S\u0006S,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P/z/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S\u0006"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!FileOperation.ALLATORIxDEMO("Zechb{~").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleCoreAura.ALLATORIxDEMO("[\u0019b\u0014c\u0007\u007f").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(ReplaceJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                4 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new ReplaceJavaScript().setVisible(true);
            }
        });
    }

    private /* synthetic */ void H(ActionEvent a2) {
        ReplaceJavaScript a3;
        a3.ALLATORIxDEMO();
    }

    private /* synthetic */ void H() {
        ReplaceJavaScript a2;
        ReplaceJavaScript replaceJavaScript = a2;
        ReplaceJavaScript replaceJavaScript2 = a2;
        ReplaceJavaScript replaceJavaScript3 = a2;
        replaceJavaScript2.E = new JButton();
        replaceJavaScript3.g = new JLabel();
        replaceJavaScript2.B = new JLabel();
        replaceJavaScript2.d = new JTextField();
        replaceJavaScript2.k = new JLabel();
        replaceJavaScript2.ALLATORIxDEMO = new JTextField();
        replaceJavaScript2.H = new JTextField();
        replaceJavaScript2.K = new JLabel();
        replaceJavaScript2.e = new JTextField();
        a2.a = new JLabel();
        replaceJavaScript.setDefaultCloseOperation(3);
        a2.E.setText(FileOperation.ALLATORIxDEMO("\u6275\u91c2\u66f3\u63d6"));
        replaceJavaScript.E.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.ReplaceJavaScript.this.H(a2);
            }
        });
        replaceJavaScript.g.setForeground(new Color(255, 0, 0));
        replaceJavaScript.g.setText(MapleCoreAura.ALLATORIxDEMO("\u6209\u91c3:m\u0006m#o\u0002e\u0000x\u5b27\u7b2a\u8f39\u63d7\u5d95\u517b"));
        replaceJavaScript.B.setText(FileOperation.ALLATORIxDEMO("\u6a99\u6844\u8de2\u5f9d7"));
        replaceJavaScript.d.setText(GameSetConstants.getNpcFolder());
        replaceJavaScript.d.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.ReplaceJavaScript.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        replaceJavaScript.k.setText(MapleCoreAura.ALLATORIxDEMO("\u6a98\u6838\u5f80\u7dc46"));
        replaceJavaScript.ALLATORIxDEMO.setText(FileOperation.ALLATORIxDEMO("f~"));
        replaceJavaScript.H.setText("XX\u8c37");
        replaceJavaScript.K.setText(MapleCoreAura.ALLATORIxDEMO("\u66f3\u4e93\u70b6"));
        replaceJavaScript.e.setText("XX\u8c37");
        replaceJavaScript.a.setFont(new Font(FileOperation.ALLATORIxDEMO("^db{nm\u007fh-Kbxeen"), 0, 10));
        replaceJavaScript.a.setForeground(new Color(0, 0, 255));
        replaceJavaScript.a.setText(MapleCoreAura.ALLATORIxDEMO("n\t,P,\u0012c\u0012c"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        replaceJavaScript.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.E, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.K).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.e)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.k, -1, -1, 32767).addComponent(a2.B, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.d, -1, 144, 32767).addComponent(a2.ALLATORIxDEMO)).addGap(0, 0, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.g).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.a))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g, -2, 22, -2).addComponent(a2.a)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H, -2, -1, -2).addComponent(a2.K).addComponent(a2.e, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.E, -2, 23, -2).addGap(5, 5, 5)));
        replaceJavaScript.pack();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void changeJavaScripts(String a2, String a3) {
        ReplaceJavaScript a4;
        Object object = new File(a4.d.getText());
        if (((File)object).exists() && ((File)object).isDirectory()) {
            Object object2 = new ArrayList<File>();
            ArrayList<File> arrayList = object2;
            a4.listDirectory((File)object, arrayList);
            object = arrayList.iterator();
            block15: while (true) {
                Object object3 = object;
                while (object3.hasNext()) {
                    String string;
                    Closeable closeable;
                    object2 = (File)object.next();
                    String string2 = null;
                    String string3 = null;
                    try {
                        string3 = EncodingDetect.getJavaEncode(object2);
                    }
                    catch (Exception exception) {
                        System.out.println("getJavaEncode: " + exception);
                        object3 = object;
                        continue;
                    }
                    System.out.println("\u6a94\u6848\"" + ((File)object2).getName() + "\"\u7de8\u78bc(" + string3 + ") \u8f49\u63db\u4e2d");
                    try {
                        closeable = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream((File)object2), string3));
                        string2 = ((BufferedReader)closeable).lines().collect(Collectors.joining(System.lineSeparator()));
                        string2 = string2.replaceAll(a2, a3);
                        ((BufferedReader)closeable).close();
                        string = string2;
                    }
                    catch (Exception exception) {
                        System.out.println("ReplaceJavaScript: " + exception);
                        string = string2;
                    }
                    if (string == null) continue block15;
                    closeable = null;
                    try {
                        closeable = new FileOutputStream((File)object2);
                        object2 = new OutputStreamWriter((OutputStream)closeable, MapleCoreAura.ALLATORIxDEMO("Y$J]4"));
                        ((Writer)object2).write(string2);
                        ((OutputStreamWriter)object2).flush();
                        continue block15;
                    }
                    catch (IOException iOException) {
                        System.out.println("CryptJavaScript\u932f\u8aa4: " + iOException);
                        continue block15;
                    }
                    finally {
                        try {
                            if (closeable == null) continue block15;
                            ((FileOutputStream)closeable).close();
                        }
                        catch (IOException iOException) {
                            System.out.println("CryptJavaScript\u932f\u8aa4: " + iOException);
                        }
                        continue block15;
                    }
                }
                break;
            }
            JOptionPane.showMessageDialog(null, FileOperation.ALLATORIxDEMO("\u8658\u740a\u5b81\u621c\u300f"));
        }
    }

    public /* synthetic */ void listDirectory(File a2, List<File> a3) {
        ReplaceJavaScript a4;
        if (!a2.exists()) {
            System.out.println(FileOperation.ALLATORIxDEMO("\u6a98\u6845\u4e01\u5b55\u5724,"));
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

    private /* synthetic */ void ALLATORIxDEMO() {
        ReplaceJavaScript a2;
        new Thread(){

            @Override
            public /* synthetic */ void run() {
                3 a2;
                3 v0 = a2;
                v0.ReplaceJavaScript.this.changeJavaScripts(v0.ReplaceJavaScript.this.H.getText(), a2.ReplaceJavaScript.this.e.getText());
            }
            {
                3 a3;
            }
        }.start();
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
    }
}

