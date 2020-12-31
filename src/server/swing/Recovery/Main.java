/*
 * Decompiled with CFR 0.150.
 */
package server.swing.Recovery;

import constants.skills.SkillType;
import database.DBConPool;
import handling.channel.handler.StatsHandling;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import server.swing.Recovery.DatabaseConnection;
import tools.packet.FamilyPacket;

public class Main
extends JFrame {
    private /* synthetic */ JButton k;
    private final /* synthetic */ StringBuffer E;
    private /* synthetic */ JLabel a;
    private /* synthetic */ JScrollPane d;
    private /* synthetic */ JTextField g;
    private /* synthetic */ JTextPane ALLATORIxDEMO;
    private /* synthetic */ JLabel K;
    public static /* synthetic */ String dbname;
    private /* synthetic */ JTextField B;

    private /* synthetic */ void ALLATORIxDEMO() {
        Main a2;
        Main main = a2;
        Main main2 = a2;
        Main main3 = a2;
        main2.k = new JButton();
        main3.g = new JTextField();
        main2.K = new JLabel();
        main2.d = new JScrollPane();
        main2.ALLATORIxDEMO = new JTextPane();
        main2.a = new JLabel();
        a2.B = new JTextField();
        main.setDefaultCloseOperation(3);
        a2.k.setText(FamilyPacket.ALLATORIxDEMO("\u5ffb\u53bd"));
        main.k.addActionListener(new ActionListener(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                1 a3;
                a3.Main.this.H(a2);
            }
        });
        main.g.setText(SkillType.ALLATORIxDEMO("R\u0002\u0015\u0000\t\u0001"));
        main.g.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.Main.this.ALLATORIxDEMO(a2);
            }
            {
                2 a3;
            }
        });
        main.K.setText(FamilyPacket.ALLATORIxDEMO("\u6030\u5f8b\u76d6\u89f0\u8220\u542f\u5b05\u0018"));
        main.ALLATORIxDEMO.setFont(new Font(SkillType.ALLATORIxDEMO("\u6594\u7d03\u662a\u9ae7"), 1, 18));
        main.d.setViewportView(a2.ALLATORIxDEMO);
        main.a.setText(FamilyPacket.ALLATORIxDEMO("\u50cb\u4edf\u8c95\u65bb\u5ef9\u542f\u7a63\u0018"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        main.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(a2.d).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(a2.K).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B, -2, 105, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.a).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.g, -2, 105, -2))).addGap(11, 11, 11).addComponent(a2.k, -2, 158, -2))).addContainerGap(-1, 32767)));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.a).addComponent(a2.g, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.B, -2, -1, -2).addComponent(a2.K))).addComponent(a2.k, -2, 54, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.d, -1, 277, 32767).addContainerGap()));
        main.pack();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean start(String a) {
        var2_3 = false;
        a.print("Start Recovery DB Player Name:" + (String)a + " Please wait...");
        var3_4 = DatabaseConnection.getConnection2();
        var4_6 = var3_4.prepareStatement(SkillType.ALLATORIxDEMO("@A_APP\u0013\u000e\u0013BAK^\u0004PLRVRGGAAW\u0013S[AAA\u0013JRIV\u0004\u000e\u0004\f"));
        var4_6.setString(1, (String)a);
        a = var4_6.executeQuery();
        if (!a.next()) ** GOTO lbl31
        var5_8 = a.getInt(FamilyPacket.ALLATORIxDEMO(";F"));
        var6_10 = var3_4.prepareStatement(SkillType.ALLATORIxDEMO("WVHVGG\u0004\u0019\u0004UV\\I\u0013M]RVJGKA]ZPVI@\u0004DLVVV\u0004PLRVRGGAAMW\u0004\u000e\u0004\f"));
        var6_10.setInt(1, var5_8);
        var5_9 = var6_10.executeQuery();
        while (var5_9.next()) {
            var7_11 = a.CreateInvInfo(var5_9);
            if (var7_11 == -1L) continue;
            var9_13 = var5_9.getLong(FamilyPacket.ALLATORIxDEMO("K<T7L&M [;V7O;F"));
            var11_14 = var3_4.prepareStatement(SkillType.ALLATORIxDEMO("WVHVGG\u0004\u0019\u0004UV\\I\u0013M]RVJGKA]VUFMCIVJG\u0004DLVVV\u0004ZJEA]P\\VJMGA^MW\u0004\u000e\u0004\f"));
            var11_14.setLong(1, var9_13);
            var9_12 = var11_14.executeQuery();
            if (var9_12.next()) {
                a.CreateEquipInfo(var9_12, var7_11);
            }
            var11_14.close();
            var9_12.close();
        }
        var6_10.close();
        var5_9.close();
        var2_3 = true;
lbl31:
        // 2 sources

        var4_6.close();
        a.close();
        var3_4.close();
        ** if (var3_4 == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            var3_4.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable var4_7) {
                try {
                    block13: {
                        if (var3_4 != null) {
                            try {
                                var3_4.close();
                                v0 = var4_7;
                                break block13;
                            }
                            catch (Throwable a) {
                                var4_7.addSuppressed(a);
                            }
                        }
                        v0 = var4_7;
                    }
                    throw v0;
                }
                catch (SQLException var3_5) {
                    a.print(var3_5);
                    var2_3 = false;
                }
            }
        }
        return var2_3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ long CreateInvInfo(ResultSet a) {
        var2_3 = -1L;
        var4_4 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var5_6 = var4_4.prepareStatement(SkillType.ALLATORIxDEMO("ZJ@AAP\u0013M]P\\\u0004ZJEA]P\\VJMGA^W\u0013\fDKAHW\bPLRVRGGAAMW\b\u0013EPG\\Q]PZ@\u001f\u0004CEPORCVMW\b\u0013MGA^MW\b\u0013M]RVJGKA]G]CA\u001f\u0004CK@MGM\\J\u001f\u0004BQRJGMG]\u001f\u0004\\S]AA\b\u0013c~{\u007fKT\b\u0013Q]MBQVMW\b\u0013B_ET\b\u0013AKTZVV@RPV\b\u0013DG]CAS\b\u0013WVJWAA\b\u0013ABQZT|J_]z@\u001a\u0004EE_QVW\u0013\f\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001f\u0004\f\b\u0013\u001b\u001a"), 1);
            v1 = var5_6;
            v2 = var5_6;
            v3 = var5_6;
            v4 = var5_6;
            v5 = var5_6;
            v6 = var5_6;
            v7 = var5_6;
            v7.setInt(1, a.getInt(FamilyPacket.ALLATORIxDEMO("U=P>F")));
            v7.setInt(2, a.getInt(SkillType.ALLATORIxDEMO("PLRVRGGAAMW")));
            v6.setInt(3, a.getInt(FamilyPacket.ALLATORIxDEMO("C1A=W<V;F")));
            v6.setInt(4, a.getInt(SkillType.ALLATORIxDEMO("CEPORCVMW")));
            v5.setInt(5, a.getInt(FamilyPacket.ALLATORIxDEMO(";V7O;F")));
            v5.setInt(6, a.getInt(SkillType.ALLATORIxDEMO("ZJEA]P\\VJPJTV")));
            v4.setInt(7, a.getInt(FamilyPacket.ALLATORIxDEMO("\"M!K&K=L")));
            v4.setInt(8, a.getInt(SkillType.ALLATORIxDEMO("UFE]PZPJ")));
            v3.setString(9, a.getString(FamilyPacket.ALLATORIxDEMO("M%L7P")));
            v3.setString(10, a.getString(SkillType.ALLATORIxDEMO("c~{\u007fKT")));
            v2.setInt(11, a.getInt(FamilyPacket.ALLATORIxDEMO("'L;S'G;F")));
            v2.setByte(12, a.getByte(SkillType.ALLATORIxDEMO("B_ET")));
            v1.setLong(13, a.getLong(FamilyPacket.ALLATORIxDEMO("7Z\"K G6C&G")));
            v1.setByte(14, a.getByte(SkillType.ALLATORIxDEMO("PJTV")));
            v0.setString(15, a.getString(FamilyPacket.ALLATORIxDEMO("!G<F7P")));
            v0.setLong(16, a.getLong(SkillType.ALLATORIxDEMO("VUFMCk]HJmW")));
            v0.execute();
            a.print("insert into inv item " + a.getInt(FamilyPacket.ALLATORIxDEMO(";V7O;F")) + " type:" + a.getByte(SkillType.ALLATORIxDEMO("PJTV")) + " success!!");
            a = var5_6.getGeneratedKeys();
            if (a.next()) {
                var2_3 = a.getLong(1);
            }
            a.close();
            var5_6.close();
            var4_4.close();
            ** if (var4_4 == null) goto lbl-1000
        }
        catch (Throwable var5_7) {
            if (var4_4 == null) ** GOTO lbl51
            try {
                var4_4.close();
                v8 = var5_7;
                ** GOTO lbl52
            }
            catch (Throwable a) {
                try {
                    var5_7.addSuppressed(a);
lbl51:
                    // 2 sources

                    v8 = var5_7;
lbl52:
                    // 2 sources

                    throw v8;
                }
                catch (SQLException var4_5) {
                    a.print(var4_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var4_4.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return var2_3;
    }

    public /* synthetic */ void print(Object a2) {
        Main a3;
        a3.E.append(String.valueOf(a2));
        a3.E.append(FamilyPacket.ALLATORIxDEMO("_("));
        Main main = a3;
        a3.ALLATORIxDEMO.setText(main.E.toString());
        main.ALLATORIxDEMO.setCaretPosition(a3.ALLATORIxDEMO.getDocument().getLength());
    }

    private /* synthetic */ void H(ActionEvent a2) {
        Main a3;
        Main main = a3;
        main.k.setEnabled(false);
        a2 = main.B.getText();
        dbname = main.g.getText();
        main.B.setText("");
        new Thread(new Runnable(){
            public final /* synthetic */ String d;

            @Override
            public /* synthetic */ void run() {
                3 v2;
                3 a2;
                3 v0 = a2;
                if (v0.Main.this.start(v0.d)) {
                    3 v1 = a2;
                    v1.Main.this.print("\u73a9\u5bb6: " + v1.d + " \u6062\u5fa9\u5b8c\u7562\u3002");
                    v2 = a2;
                } else {
                    3 v3 = a2;
                    v3.Main.this.print("\u627e\u4e0d\u5230 " + v3.d + " \u7684\u4efb\u4f55\u6578\u64da\u3002");
                    v2 = a2;
                }
                v2.Main.this.k.setEnabled(true);
            }
            {
                3 a3;
                a3.d = string;
            }
        }).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(FamilyPacket.ALLATORIxDEMO("(q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001X\u0001r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002q(q\u0002r\u0002r\u0002r\u0002r\u0001q\u0002q\u0002r\u0002q\u0002r\u0002r\u0001q\u0002q\u0001q\u0002q\u0001q\u0002q\u0001r\u0002q\u0001q\u0002r\u0002r\u0002r\u0002r\u0001X\u0001r\u0002r\u0002r\u0002r\u0001r\u0001r\u0001r\u0002r\u0001r\u0002r\u0001r\u0001r\u0002q\u0002r\u0001r\u0001r\u0001r\u0001r\u0002q\u0002r\u0002r\u0002r\u0002r\u0002q(q\u0002r\u0002r\u0002r\u0002q\u0001q\u0002q\u0002r\u0002q\u0002r\u0002q\u0001q\u0002r\u0001r\u0002q\u0002q\u0002q\u0001r\u0002r\u0001r\u0002r\u0002r\u0002r\u0002r\u0001X\u0001r\u0002r\u0002r\u0002r\u0001r\u0001r\u0001q\u0001r\u0001q\u0001r\u0001r\u0001r\u0002q\u0002r\u0001q\u0001r\u0001r\u0001r\u0001q\u0001r\u0002r\u0002r\u0002r\u0002q(q\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0001X\u0001rm0D'Q1C&K=Lr@+\u0002\u0013N>C&M Krm0D'Q1C&M \u0002$\u0015|\u0011rf\u0017o\u001d\u0002q(q\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0001X\u0001r\u0002r\u0002r\u0002r\u0002r\u0002rJ&V\"\u0018}\r%U%\f3N>C&M K|A=Or\u0002r\u0002r\u0002r\u0002r\u0002r\u0002q(q\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0002r\u0001X\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q\u0001q("));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!SkillType.ALLATORIxDEMO("jZIQQ@").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                4 a2;
            }

            @Override
            public /* synthetic */ void run() {
                Main main;
                Main main2 = main = new Main();
                Main main3 = main;
                main.setVisible(true);
                main3.setResizable(false);
                main3.setLocationRelativeTo(null);
                main2.setTitle(StatsHandling.ALLATORIxDEMO("\u7a54\u88a6\u604c\u5fd2\u5c21\u5d9e\u5159"));
                main2.setAlwaysOnTop(true);
            }
        });
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void CreateEquipInfo(ResultSet a, long a) {
        var4_4 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var5_6 = var4_4.prepareStatement(FamilyPacket.ALLATORIxDEMO("K<Q7P&\u0002;L&MrK<T7L&M [7S'K\"O7L&\u0002zK<T7L&M [;V7O;F~\u0002'R5P3F7G<A:\u000erW\"E C6G!N=V!\u000erB>G$G>B~\u0002!V \u000erF7Z~\u00022K<V2\u000erN'I~\u0002:R~\u0002?R~\u0002%C&I~\u0002?C&I~\u0002%F7D~\u0002?F7D~\u00023A1\u000erC$M;F~\u0002:C<F!\u000erQ\"G7F~\u00028W?R~\u0002\u0004K1K=W!j3O?G \u000erK&G?g*R~\u00026W C0K>K&[~\u00027L:C<A7\u000erR=V7L&K3Nc\u000erR=V7L&K3N`\u000erR=V7L&K3Na\u000erK<A\u0001I;N>\u000erJ\"p~\u0002?R\u0000\u000erA:C O\u0017z\u0002\u000erR$R\u0016C?C5G{\u0002$C>W7Qr\nm\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000em\u000b"));
            v1 = var5_6;
            v2 = var5_6;
            v3 = var5_6;
            v4 = var5_6;
            v5 = var5_6;
            v6 = var5_6;
            v7 = var5_6;
            v8 = var5_6;
            v9 = var5_6;
            v10 = var5_6;
            v11 = var5_6;
            v12 = var5_6;
            v13 = var5_6;
            v14 = var5_6;
            v14.setLong(1, a);
            v14.setInt(2, a.getInt(SkillType.ALLATORIxDEMO("QCCAEWA@H\\P@")));
            v13.setInt(3, a.getInt(FamilyPacket.ALLATORIxDEMO("N7T7N")));
            v13.setInt(4, a.getInt(SkillType.ALLATORIxDEMO("@PA")));
            v12.setInt(5, a.getInt(FamilyPacket.ALLATORIxDEMO("F7Z")));
            v12.setInt(6, a.getInt(SkillType.ALLATORIxDEMO("ZJG")));
            v11.setInt(7, a.getInt(FamilyPacket.ALLATORIxDEMO("N'I")));
            v11.setInt(8, a.getInt(SkillType.ALLATORIxDEMO("LC")));
            v10.setInt(9, a.getInt(FamilyPacket.ALLATORIxDEMO("?R")));
            v10.setInt(10, a.getInt(SkillType.ALLATORIxDEMO("SRPX")));
            v9.setInt(11, a.getInt(FamilyPacket.ALLATORIxDEMO("?C&I")));
            v9.setInt(12, a.getInt(SkillType.ALLATORIxDEMO("SWAU")));
            v8.setInt(13, a.getInt(FamilyPacket.ALLATORIxDEMO("?F7D")));
            v8.setInt(14, a.getInt(SkillType.ALLATORIxDEMO("RGP")));
            v7.setInt(15, a.getInt(FamilyPacket.ALLATORIxDEMO("C$M;F")));
            v7.setInt(16, a.getInt(SkillType.ALLATORIxDEMO("[E]@@")));
            v6.setInt(17, a.getInt(FamilyPacket.ALLATORIxDEMO("Q\"G7F")));
            v6.setInt(18, a.getInt(SkillType.ALLATORIxDEMO("NFIC")));
            v5.setInt(19, a.getInt(FamilyPacket.ALLATORIxDEMO("t;A;M'Q\u001aC?O7P")));
            v5.setInt(20, a.getInt(SkillType.ALLATORIxDEMO("ZPVIv\\C")));
            v4.setInt(21, a.getInt(FamilyPacket.ALLATORIxDEMO("6W C0K>K&[")));
            v4.setByte(22, a.getByte(SkillType.ALLATORIxDEMO("VJ[E]GV")));
            v3.setInt(23, a.getInt(FamilyPacket.ALLATORIxDEMO("\"M&G<V;C>\u0013")));
            v3.setInt(24, a.getInt(SkillType.ALLATORIxDEMO("T\\PVJGMRH\u0001")));
            v2.setInt(25, a.getInt(FamilyPacket.ALLATORIxDEMO("\"M&G<V;C>\u0011")));
            v2.setInt(26, a.getInt(SkillType.ALLATORIxDEMO("M]G`OZH_")));
            v1.setInt(27, a.getInt(FamilyPacket.ALLATORIxDEMO("J\"p")));
            v1.setInt(28, a.getInt(SkillType.ALLATORIxDEMO("^Ta")));
            v0.setInt(29, a.getInt(FamilyPacket.ALLATORIxDEMO("1J3P?g\nr")));
            v0.setInt(30, a.getInt(SkillType.ALLATORIxDEMO("CRC`RIRCV")));
            v0.execute();
            var5_6.close();
            var4_4.close();
            a.print("insert into equip inv id:" + a + " success!!");
            ** if (var4_4 == null) goto lbl-1000
        }
        catch (Throwable var5_7) {
            if (var4_4 == null) ** GOTO lbl68
            try {
                var4_4.close();
                v15 = var5_7;
                ** GOTO lbl69
            }
            catch (Throwable a) {
                try {
                    var5_7.addSuppressed(a);
lbl68:
                    // 2 sources

                    v15 = var5_7;
lbl69:
                    // 2 sources

                    throw v15;
                }
                catch (SQLException var4_5) {
                    a.print(var4_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var4_4.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public /* synthetic */ Main() {
        Main a2;
        a2.E = new StringBuffer();
        a2.ALLATORIxDEMO();
    }

    public static /* synthetic */ {
        dbname = "";
    }
}

