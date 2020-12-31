/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package server.swing.tools;

import client.MapleCoreAura;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import constants.GameSetConstants;
import handling.world.guild.MapleGuild;
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
import tools.StringUtil;

public class TranslateJavaScript
extends JFrame {
    private /* synthetic */ JLabel K;
    private /* synthetic */ JLabel g;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ JButton E;
    private /* synthetic */ JLabel k;
    private /* synthetic */ JTextField d;
    private /* synthetic */ JLabel B;
    private /* synthetic */ JTextField H;
    private /* synthetic */ JLabel a;
    private /* synthetic */ JTextField e;

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
    }

    public /* synthetic */ void listDirectory(File a2, List<File> a3) {
        TranslateJavaScript a4;
        if (!a2.exists()) {
            System.out.println(MapleGuild.ALLATORIxDEMO("\u6a90\u6828\u4e09\u5b38\u572cA"));
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MapleCoreAura.ALLATORIxDEMO("\u0006S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/z/P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,S\u0006S,P,P,P,P/S,S,P,S,P,P/S,S/S,S/S,S/P,S/S,P,P,P,P/z/P,P,P,P/P/P/P,P/P,P/P/P,S,P/P/P/P/P,S,P,P,P,P,S\u0006S,P,P,P,S/S,S,P,S,P,S/S,P/P,S,S,S/P,P/P,P,P,P,P/z/P,P,P,P/P/P/S/P/S/P/P/P,S,P/S/P/P/P/S/P,P,P,P,S\u0006S,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P/z/PC\u0012j\u0005\u007f\u0013m\u0004e\u001fbPn\t,1`\u001cm\u0004c\u0002ePC\u0012j\u0005\u007f\u0013m\u0004c\u0002,\u0006;^?PH5A?,S\u0006S,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P/z/P,P,P,P,P,Pd\u0004x\u00006_#\u0007{\u0007\"\u0011`\u001cm\u0004c\u0002e^o\u001faP,P,P,P,P,P,S\u0006S,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P,P/z/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S/S\u0006"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleGuild.ALLATORIxDEMO("7m\u000e`\u000fs\u0013").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!MapleCoreAura.ALLATORIxDEMO("[\u0019b\u0014c\u0007\u007f").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(TranslateJavaScript.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                4 a2;
            }

            @Override
            public /* synthetic */ void run() {
                new TranslateJavaScript().setVisible(true);
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        TranslateJavaScript a2;
        new Thread(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public /* synthetic */ void run() {
                File file = new File(GameSetConstants.getNpcFolder());
                if (file.exists() && file.isDirectory()) {
                    3 a2;
                    Object object = new ArrayList<File>();
                    ArrayList<File> arrayList = object;
                    a2.TranslateJavaScript.this.listDirectory(file, arrayList);
                    object = arrayList.iterator();
                    block15: while (true) {
                        Object object2 = object;
                        while (object2.hasNext()) {
                            String string;
                            Closeable closeable;
                            Object object3 = (File)object.next();
                            String string2 = null;
                            String string3 = null;
                            try {
                                string3 = EncodingDetect.getJavaEncode((File)object3);
                            }
                            catch (Exception exception) {
                                System.out.println("getJavaEncode: " + exception);
                                object2 = object;
                                continue;
                            }
                            System.out.println("\u6a94\u6848\"" + ((File)object3).getName() + "\"\u7de8\u78bc(" + string3 + ") \u8f49\u63db\u4e2d");
                            try {
                                closeable = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream((File)object3), string3));
                                string2 = ((BufferedReader)closeable).lines().collect(Collectors.joining(System.lineSeparator()));
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
                                closeable = new FileOutputStream((File)object3);
                                object3 = new OutputStreamWriter((OutputStream)closeable, StringUtil.ALLATORIxDEMO("d~w\u0007\t"));
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
                    JOptionPane.showMessageDialog(null, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u8604\u7432\u5bdd\u6224\u3053"));
                }
            }
            {
                3 a3;
            }
        }.start();
    }

    private /* synthetic */ void H() {
        TranslateJavaScript a2;
        TranslateJavaScript translateJavaScript = a2;
        TranslateJavaScript translateJavaScript2 = a2;
        TranslateJavaScript translateJavaScript3 = a2;
        translateJavaScript2.E = new JButton();
        translateJavaScript3.g = new JLabel();
        translateJavaScript2.B = new JLabel();
        translateJavaScript2.d = new JTextField();
        translateJavaScript2.k = new JLabel();
        translateJavaScript2.ALLATORIxDEMO = new JTextField();
        translateJavaScript2.H = new JTextField();
        translateJavaScript2.K = new JLabel();
        translateJavaScript2.e = new JTextField();
        a2.a = new JLabel();
        translateJavaScript.setDefaultCloseOperation(3);
        a2.E.setText(MapleCoreAura.ALLATORIxDEMO("\u6209\u91c3\u668f\u63d7"));
        translateJavaScript.E.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.TranslateJavaScript.this.H(a2);
            }
            {
                1 a3;
            }
        });
        translateJavaScript.g.setForeground(new Color(255, 0, 0));
        translateJavaScript.g.setText(MapleGuild.ALLATORIxDEMO("\u627d\u91afN\u0001r\u0001W\u0003v\tt\u0014\u5b53\u7b46\u8f4d\u63bb\u5de1\u5117"));
        translateJavaScript.B.setText(MapleCoreAura.ALLATORIxDEMO("\u6a98\u6838\u8de3\u5fe16"));
        translateJavaScript.d.setText(MapleGuild.ALLATORIxDEMO("+\u0013g\u0012m\u0010p\u00135Q<O"));
        translateJavaScript.d.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.TranslateJavaScript.this.ALLATORIxDEMO(a2);
            }
        });
        translateJavaScript.k.setText(MapleCoreAura.ALLATORIxDEMO("\u6a98\u6838\u5f80\u7dc46"));
        translateJavaScript.ALLATORIxDEMO.setText(MapleGuild.ALLATORIxDEMO("n\u0013"));
        translateJavaScript.H.setText("XX\u8c37");
        translateJavaScript.K.setText(MapleCoreAura.ALLATORIxDEMO("\u66f3\u4e93\u70b6"));
        translateJavaScript.e.setText("XX\u8c37");
        translateJavaScript.a.setFont(new Font(MapleGuild.ALLATORIxDEMO("3l\u000fs\u0003e\u0012`@C\u000fp\bm\u0003"), 0, 10));
        translateJavaScript.a.setForeground(new Color(0, 0, 255));
        translateJavaScript.a.setText(MapleCoreAura.ALLATORIxDEMO("n\t,P,\u0012c\u0012c"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        translateJavaScript.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.E, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.K).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.e)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.k, -1, -1, 32767).addComponent(a2.B, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(a2.d, -1, 144, 32767).addComponent(a2.ALLATORIxDEMO)).addGap(0, 0, 32767)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.g).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.a)))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.g, -2, 22, -2).addComponent(a2.a)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B).addComponent(a2.d, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.H, -2, -1, -2).addComponent(a2.K).addComponent(a2.e, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.E, -2, 23, -2).addGap(5, 5, 5)));
        translateJavaScript.pack();
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        TranslateJavaScript a3;
        TranslateJavaScript translateJavaScript = a3;
        translateJavaScript.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        TranslateJavaScript translateJavaScript2 = a3;
        translateJavaScript2.setLocation((int)(dimension.getWidth() - (double)translateJavaScript2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    private /* synthetic */ void H(ActionEvent a2) {
        TranslateJavaScript a3;
        a3.ALLATORIxDEMO();
    }

    public /* synthetic */ TranslateJavaScript() {
        TranslateJavaScript a2;
        TranslateJavaScript translateJavaScript = a2;
        translateJavaScript.H();
    }
}

