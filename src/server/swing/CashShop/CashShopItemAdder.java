/*
 * Decompiled with CFR 0.150.
 */
package server.swing.CashShop;

import client.SummonSkillEntry;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import database.DatabaseConnection;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import server.MapleItemInformationProvider;
import server.swing.UIHelper;
import tools.EmojiFilter;

public class CashShopItemAdder
extends JFrame {
    private /* synthetic */ JTextField d;
    private /* synthetic */ JLabel i;
    private /* synthetic */ JTextField K;
    private /* synthetic */ JTextField ALLATORIxDEMO;
    private /* synthetic */ int[] Z;
    private /* synthetic */ JComboBox<String> c;
    private /* synthetic */ JTextField B;
    private /* synthetic */ int[] t;
    private /* synthetic */ JRadioButton e;
    private /* synthetic */ JComboBox<String> b;
    private /* synthetic */ JLabel j;
    private /* synthetic */ JButton w;
    private /* synthetic */ JLabel I;
    private /* synthetic */ JComboBox<String> G;
    private /* synthetic */ JLabel m;
    private /* synthetic */ JLabel L;
    private /* synthetic */ JLabel l;
    private /* synthetic */ int[] o;
    private /* synthetic */ JLabel H;
    private /* synthetic */ JLabel J;
    private /* synthetic */ JTextField a;
    private /* synthetic */ JTextField g;
    private /* synthetic */ JTextField k;
    private /* synthetic */ JLabel F;
    private /* synthetic */ JLabel D;
    private /* synthetic */ ButtonGroup P;
    private /* synthetic */ JLabel A;
    private /* synthetic */ JLabel f;
    private /* synthetic */ JLabel h;
    private /* synthetic */ JLabel C;
    private /* synthetic */ JRadioButton E;
    private /* synthetic */ JLabel M;

    private /* synthetic */ void H(KeyEvent a2) {
        UIHelper.numberOnly(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a22) {
        CashShopItemAdder a3;
        block29: {
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            a22 = a3.K.getText();
            if (((String)a22).equals("")) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u554d\u54f2\u5406\u7a02\u4e06\u5fa4\u70b1\u7a49"));
                return;
            }
            CashShopItemAdder cashShopItemAdder = a3;
            CashShopItemAdder cashShopItemAdder2 = a3;
            int n8 = cashShopItemAdder.o[cashShopItemAdder2.G.getSelectedIndex()];
            int n9 = cashShopItemAdder2.Z[a3.c.getSelectedIndex()];
            int n10 = cashShopItemAdder.t[a3.b.getSelectedIndex()];
            try {
                n7 = Integer.parseInt(a3.d.getText());
            }
            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8a87\u78b9\u8ac1\u50fa\u6870\u662c\u546a\u8f3b\u5129\u6b60\u78f6"));
                return;
            }
            if (n7 <= 0) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u554d\u54f2\u50f2\u680f\u4e06\u5fa4\u4f45\u658f+\u0002"));
                return;
            }
            try {
                n6 = Integer.parseInt(a3.k.getText());
            }
            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8a87\u78b9\u8ac1\u9050\u513b\u4ee0\u78f0\u662c\u546a\u8f3b\u5129\u6b60\u78f6"));
                return;
            }
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            if (!mapleItemInformationProvider.itemExists(n6)) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u8a79\u9060\u517c\u4e3e\u5b53\u571b"));
                return;
            }
            try {
                n5 = Integer.parseInt(a3.ALLATORIxDEMO.getText());
            }
            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8a87\u78b9\u8ac1\u5129\u5104\u9805\u5ec3\u662c\u546a\u8f3b\u5129\u6b60\u78f6"));
                return;
            }
            if (n5 < -1) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u5119\u5143\u9835\u5e84\u4e3e\u5f9c\u4f7d\u65b7\u0013&\u0002\u00069\u517d\u4e1e\u5121\u517b\u980d\u5ebc\u6103\u9aeb\u524c\u5575\u54ca\u4f7e\u7f65\u613b\u5246\u9751"));
                return;
            }
            try {
                n4 = Integer.parseInt(a3.a.getText());
            }
            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8a87\u78b9\u8ac1\u671c\u961c\u662c\u546a\u8f3b\u5129\u6b60\u78f6"));
                return;
            }
            if (n4 < 0) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u672c\u965b\u4e3e\u5f9c\u4f7d\u65b7\u0013;>\u0001\u5145\u4e26\u0013;\u0013\u4ee8\u885b\u6c33\u4e76"));
                return;
            }
            try {
                n3 = Integer.parseInt(a3.g.getText());
            }
            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8a87\u78b9\u8ac1\u9050\u513b\u657b\u9183\u662c\u546a\u8f3b\u5129\u6b60\u78f6"));
                return;
            }
            if (n3 <= 0) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u9058\u5144\u6573\u91fc\u4e06\u5fa4\u4f45\u658f+\u0002"));
                return;
            }
            if (GameConstants.getInventoryType(n6) == MapleInventoryType.EQUIP && n3 > 1) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8891\u509a\u6534\u91cc\u5f89\u980b\u6663#}"));
                return;
            }
            if (n3 > 32767) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u9058\u5144\u6573\u91fc\u4e06\u5fa4\u9ad3\u658f+\u00009\u0004=\u0004"));
                return;
            }
            try {
                n2 = Integer.parseInt(a3.B.getText());
            }
            catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u8a87\u78b9\u8ac1\u984e\u595a\u65d4\u6a55\u662c\u546a\u8f3b\u5129\u6b60\u78f6"));
                return;
            }
            if (n2 < 0) {
                JOptionPane.showMessageDialog(a3, SummonSkillEntry.ALLATORIxDEMO("\u9846\u5925\u65dc\u6a2a\u5fce\u983b\u592c\u658f\u621d\u7b7a\u65b7\u0013;>\u0001\u5145\u4e26\u0013;\u0013\u4ee8\u885b\u981b\u8a1e"));
                return;
            }
            int n11 = a3.findNextEmptySN(n8);
            if (n11 == -1) {
                JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u7122\u6c99\u67e6\u8a2e\u5545\u548d\u5e8c\u8613"));
                return;
            }
            AutoCloseable autoCloseable = DatabaseConnection.getConnection();
            try {
                autoCloseable = autoCloseable.prepareStatement(SummonSkillEntry.ALLATORIxDEMO("B}XvYg+zEgD\u0013kPj@c@c\\{lbGn^xS+\u001bk}dGnS'\u0013k`ES'\u0013kcyZhVk\u001f+SFRyXk\u001f+SD]xRgVk\u001f+SBGn^bWk\u001f+S[Ab\\yZ\u007fJk\u001f+S[RhXjTnS'\u0013kcnAb\\oS'\u0013ktn]oVyS'\u0013kpdFeGk\u001f+SFVx\\k\u001f+S~]`l:S'\u0013kFeXT\u0001k\u001f+S~]`l8S'\u0013kpgRx@k\u001a+eJ\u007f^vX\u0013#\f'\u00134\u001f+\f'\u00134\u001f+\f'\u00134\u001f+\f'\u00134\u001f+\f'\u00134\u001f+\f'\u00134\u001f+\f'\u00134\u001f+\f'\u00134\u001a"));
                try {
                    AutoCloseable autoCloseable2 = autoCloseable;
                    AutoCloseable autoCloseable3 = autoCloseable;
                    autoCloseable3.setString(1, (String)a22);
                    autoCloseable3.setInt(2, n11);
                    autoCloseable2.setInt(3, n7);
                    autoCloseable2.setInt(4, n9);
                    autoCloseable.setInt(5, a3.E.isSelected() ? 1 : 0);
                    AutoCloseable autoCloseable4 = autoCloseable;
                    AutoCloseable autoCloseable5 = autoCloseable;
                    AutoCloseable autoCloseable6 = autoCloseable;
                    AutoCloseable autoCloseable7 = autoCloseable;
                    AutoCloseable autoCloseable8 = autoCloseable;
                    autoCloseable.setInt(6, n6);
                    autoCloseable8.setInt(7, n5);
                    autoCloseable8.setInt(8, 0);
                    autoCloseable7.setInt(9, n4);
                    autoCloseable7.setInt(10, n10);
                    autoCloseable6.setInt(11, n3);
                    autoCloseable6.setInt(12, 0);
                    autoCloseable5.setInt(13, 0);
                    autoCloseable5.setInt(14, 0);
                    autoCloseable4.setInt(15, 0);
                    autoCloseable4.setInt(16, n2);
                    autoCloseable4.execute();
                    if (autoCloseable == null) break block29;
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (autoCloseable != null) {
                        try {
                            autoCloseable.close();
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
                autoCloseable.close();
            }
            catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(a3, "\u767c\u751f\u8cc7\u6599\u5eab\u4f8b\u5916\u72c0\u6cc1 : " + sQLException);
                return;
            }
        }
        JOptionPane.showMessageDialog(a3, EmojiFilter.ALLATORIxDEMO("\u5545\u5782\u726a\u548d\u65b3\u58d2\u5b8f\u625c"));
    }

    private /* synthetic */ void I(KeyEvent a2) {
        UIHelper.numberOnly(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(KeyEvent a2) {
        UIHelper.numberOnly(a2);
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        CashShopItemAdder a3;
        CashShopItemAdder cashShopItemAdder = a3;
        cashShopItemAdder.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        CashShopItemAdder cashShopItemAdder2 = a3;
        cashShopItemAdder2.setLocation((int)(dimension.getWidth() - (double)cashShopItemAdder2.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        super.setVisible(a2);
    }

    public /* synthetic */ CashShopItemAdder() {
        CashShopItemAdder a2;
        int[] arrn = new int[28];
        arrn[0] = 100;
        arrn[1] = 101;
        arrn[2] = 200;
        arrn[3] = 201;
        arrn[4] = 202;
        arrn[5] = 203;
        arrn[6] = 204;
        arrn[7] = 205;
        arrn[8] = 206;
        arrn[9] = 207;
        arrn[10] = 208;
        arrn[11] = 209;
        arrn[12] = 211;
        arrn[13] = 212;
        arrn[14] = 300;
        arrn[15] = 301;
        arrn[16] = 302;
        arrn[17] = 400;
        arrn[18] = 500;
        arrn[19] = 501;
        arrn[20] = 502;
        arrn[21] = 503;
        arrn[22] = 504;
        arrn[23] = 505;
        arrn[24] = 506;
        arrn[25] = 600;
        arrn[26] = 601;
        arrn[27] = 602;
        a2.o = arrn;
        int[] arrn2 = new int[6];
        arrn2[0] = -1;
        arrn2[1] = 2;
        arrn2[2] = 0;
        arrn2[3] = 1;
        arrn2[4] = 3;
        arrn2[5] = 4;
        a2.Z = arrn2;
        int[] arrn3 = new int[3];
        arrn3[0] = 2;
        arrn3[1] = 1;
        arrn3[2] = 0;
        a2.t = arrn3;
        a2.ALLATORIxDEMO();
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int findNextEmptySN(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

    private /* synthetic */ void D(KeyEvent a2) {
        UIHelper.numberWithNegative(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        CashShopItemAdder a2;
        CashShopItemAdder cashShopItemAdder = a2;
        CashShopItemAdder cashShopItemAdder2 = a2;
        CashShopItemAdder cashShopItemAdder3 = a2;
        cashShopItemAdder2.P = new ButtonGroup();
        cashShopItemAdder3.l = new JLabel();
        cashShopItemAdder2.A = new JLabel();
        cashShopItemAdder2.G = new JComboBox();
        cashShopItemAdder2.i = new JLabel();
        cashShopItemAdder2.c = new JComboBox();
        cashShopItemAdder2.I = new JLabel();
        cashShopItemAdder2.d = new JTextField();
        cashShopItemAdder2.j = new JLabel();
        cashShopItemAdder2.k = new JTextField();
        cashShopItemAdder2.F = new JLabel();
        cashShopItemAdder2.ALLATORIxDEMO = new JTextField();
        cashShopItemAdder2.m = new JLabel();
        cashShopItemAdder2.M = new JLabel();
        cashShopItemAdder2.a = new JTextField();
        cashShopItemAdder2.h = new JLabel();
        cashShopItemAdder2.f = new JLabel();
        cashShopItemAdder2.g = new JTextField();
        cashShopItemAdder2.H = new JLabel();
        cashShopItemAdder2.D = new JLabel();
        cashShopItemAdder2.B = new JTextField();
        cashShopItemAdder2.L = new JLabel();
        cashShopItemAdder2.b = new JComboBox();
        cashShopItemAdder2.C = new JLabel();
        cashShopItemAdder2.E = new JRadioButton();
        cashShopItemAdder2.e = new JRadioButton();
        cashShopItemAdder2.w = new JButton();
        cashShopItemAdder2.J = new JLabel();
        a2.K = new JTextField();
        cashShopItemAdder.setDefaultCloseOperation(3);
        a2.l.setFont(new Font(EmojiFilter.ALLATORIxDEMO("\u5fe2\u8edc\u6b2f\u9ed2\u9a98"), 0, 14));
        cashShopItemAdder.l.setText(SummonSkillEntry.ALLATORIxDEMO("\u554d\u57fd\u9058\u5144\u65bb\u58ad\u5dee\u5144"));
        cashShopItemAdder.A.setText(EmojiFilter.ALLATORIxDEMO("\u5205\u9812"));
        String[] arrstring = new String[28];
        arrstring[0] = SummonSkillEntry.ALLATORIxDEMO("\u639b\u85ad\u0013&\u0013\u65bb\u54f2+\u0002;\u0003");
        arrstring[1] = EmojiFilter.ALLATORIxDEMO("\u63e4\u85a5l.l\u6d38\u5299#}3}");
        arrstring[2] = SummonSkillEntry.ALLATORIxDEMO("\u88ee\u5092\u0013&\u0013\u5e36\u5b63+\u0001;\u0003");
        arrstring[3] = EmojiFilter.ALLATORIxDEMO("\u8891\u509al.l\u81ca\u98b2#~3}");
        arrstring[4] = SummonSkillEntry.ALLATORIxDEMO("\u88ee\u5092\u0013&\u0013\u7737\u98cd+\u0001;\u0001");
        arrstring[5] = EmojiFilter.ALLATORIxDEMO("\u8891\u509al.l\u5954\u8891#~3\u007f");
        arrstring[6] = SummonSkillEntry.ALLATORIxDEMO("\u88ee\u5092\u0013&\u0013\u4e01\u8850+\u0001;\u0007");
        arrstring[7] = EmojiFilter.ALLATORIxDEMO("\u88de\u50d5#a#\u897e#c#\u8895#~3y");
        arrstring[8] = SummonSkillEntry.ALLATORIxDEMO("\u88ee\u5092\u0013&\u0013\u9780\u5b63+\u0001;\u0005");
        arrstring[9] = EmojiFilter.ALLATORIxDEMO("\u8891\u509al.l\u6248\u591b#~3{");
        arrstring[10] = SummonSkillEntry.ALLATORIxDEMO("\u88ee\u5092\u0013&\u0013\u6b6d\u565b+\u0001;\u000b");
        arrstring[11] = EmojiFilter.ALLATORIxDEMO("\u8891\u509al.l\u6211\u634b#~3u");
        arrstring[12] = SummonSkillEntry.ALLATORIxDEMO("\u88ee\u5092\u0013&\u0013\u62a0\u989b+\u0001:\u0002");
        arrstring[13] = EmojiFilter.ALLATORIxDEMO("\u8891\u509al.l\u5753\u9a42#~2~");
        arrstring[14] = SummonSkillEntry.ALLATORIxDEMO("\u6d83\u8024+\u001e+\u9079\u6239\u520b+\u0000;\u0003");
        arrstring[15] = EmojiFilter.ALLATORIxDEMO("\u6dc4\u8014l.l\u5ee0\u64e1#\u007f3}");
        arrstring[16] = SummonSkillEntry.ALLATORIxDEMO("\u6dbb\u801c\u0013&\u0013\u7272\u657b+\u0000;\u0001");
        arrstring[17] = EmojiFilter.ALLATORIxDEMO("\u7235\u6b89l.l\u727a\u6bc6#x3|");
        arrstring[18] = SummonSkillEntry.ALLATORIxDEMO("\u9058\u5144+\u001e+\u9079\u6239\u520b+\u0006;\u0003");
        arrstring[19] = EmojiFilter.ALLATORIxDEMO("\u901f\u5174l.l\u5545\u5edb#y3}");
        arrstring[20] = SummonSkillEntry.ALLATORIxDEMO("\u9060\u517c\u0013&\u0013\u9041\u6201+\u0006;\u0001");
        arrstring[21] = EmojiFilter.ALLATORIxDEMO("\u901f\u5174l.l\u886b\u6089#y3\u007f");
        arrstring[22] = SummonSkillEntry.ALLATORIxDEMO("\u9060\u517c\u0013&\u0013\u7d5b\u5a69+\u0006;\u0007");
        arrstring[23] = EmojiFilter.ALLATORIxDEMO("\u901f\u5174l.l\u727a\u6504#y3y");
        arrstring[24] = SummonSkillEntry.ALLATORIxDEMO("\u9060\u517c\u0013&\u0013\u89d9\u8241+\u0006;\u0005");
        arrstring[25] = EmojiFilter.ALLATORIxDEMO("\u5bb9\u726al.l\u5bf6\u7225#z3|");
        arrstring[26] = SummonSkillEntry.ALLATORIxDEMO("\u5bc6\u7262\u0013&\u0013\u5bfe\u725a\u88d6\u50aa+\u0005;\u0002");
        arrstring[27] = EmojiFilter.ALLATORIxDEMO("\u5bb9\u726al.l\u5bf6\u7225\u9050\u513b#z3~");
        cashShopItemAdder.G.setModel(new DefaultComboBoxModel<String>(arrstring));
        CashShopItemAdder cashShopItemAdder4 = a2;
        cashShopItemAdder4.i.setText(SummonSkillEntry.ALLATORIxDEMO("\u6a12\u8a2b"));
        String[] arrstring2 = new String[6];
        arrstring2[0] = EmojiFilter.ALLATORIxDEMO("\u7122l.}");
        arrstring2[1] = SummonSkillEntry.ALLATORIxDEMO("\u71ba\u95b3+\u0001");
        arrstring2[2] = EmojiFilter.ALLATORIxDEMO("\u65b3\u548d#|");
        arrstring2[3] = SummonSkillEntry.ALLATORIxDEMO("\u6293\u6250+\u0002");
        arrstring2[4] = EmojiFilter.ALLATORIxDEMO("\u6d38\u5299#\u007f");
        arrstring2[5] = SummonSkillEntry.ALLATORIxDEMO("\u965b\u5ba9+\u0007");
        cashShopItemAdder4.c.setModel(new DefaultComboBoxModel<String>(arrstring2));
        CashShopItemAdder cashShopItemAdder5 = a2;
        cashShopItemAdder5.I.setText(EmojiFilter.ALLATORIxDEMO("\u8caa\u8caf\u50fa\u6870"));
        cashShopItemAdder5.d.addKeyListener(new KeyAdapter(){

            @Override
            public /* synthetic */ void keyTyped(KeyEvent a2) {
                2 a3;
                a3.CashShopItemAdder.this.I(a2);
            }
            {
                2 a3;
            }
        });
        cashShopItemAdder5.j.setText(SummonSkillEntry.ALLATORIxDEMO("\u9058\u5144\u4ee8\u788f"));
        cashShopItemAdder5.k.addKeyListener(new KeyAdapter(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ void keyTyped(KeyEvent a2) {
                3 a3;
                a3.CashShopItemAdder.this.E(a2);
            }
        });
        cashShopItemAdder5.F.setText(EmojiFilter.ALLATORIxDEMO("\u6391\u5ec3"));
        cashShopItemAdder5.ALLATORIxDEMO.setText(SummonSkillEntry.ALLATORIxDEMO("\u0003"));
        cashShopItemAdder5.ALLATORIxDEMO.addKeyListener(new KeyAdapter(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void keyTyped(KeyEvent a2) {
                4 a3;
                a3.CashShopItemAdder.this.D(a2);
            }
        });
        cashShopItemAdder5.m.setText(EmojiFilter.ALLATORIxDEMO("\u9edd\u6534"));
        cashShopItemAdder5.M.setText(SummonSkillEntry.ALLATORIxDEMO("\u6714\u9663"));
        cashShopItemAdder5.a.setText(EmojiFilter.ALLATORIxDEMO("|"));
        cashShopItemAdder5.a.addKeyListener(new KeyAdapter(){
            {
                5 a3;
            }

            @Override
            public /* synthetic */ void keyTyped(KeyEvent a2) {
                5 a3;
                a3.CashShopItemAdder.this.l(a2);
            }
        });
        cashShopItemAdder5.h.setText(SummonSkillEntry.ALLATORIxDEMO("\u591a"));
        cashShopItemAdder5.f.setText(EmojiFilter.ALLATORIxDEMO("\u9050\u513b\u657b\u9183"));
        cashShopItemAdder5.g.setText("1");
        cashShopItemAdder5.g.addKeyListener(new KeyAdapter(){
            {
                6 a3;
            }

            @Override
            public /* synthetic */ void keyTyped(KeyEvent a2) {
                6 a3;
                a3.CashShopItemAdder.this.H(a2);
            }
        });
        cashShopItemAdder5.H.setText(SummonSkillEntry.ALLATORIxDEMO("\u5038"));
        cashShopItemAdder5.D.setText(EmojiFilter.ALLATORIxDEMO("\u984e\u595a\u65d4\u6a55"));
        cashShopItemAdder5.B.setText(SummonSkillEntry.ALLATORIxDEMO("&\u0002"));
        cashShopItemAdder5.B.addKeyListener(new KeyAdapter(){

            @Override
            public /* synthetic */ void keyTyped(KeyEvent a2) {
                7 a3;
                a3.CashShopItemAdder.this.ALLATORIxDEMO(a2);
            }
            {
                7 a3;
            }
        });
        cashShopItemAdder5.L.setText(EmojiFilter.ALLATORIxDEMO("\u6024\u5269\u9653\u527a"));
        String[] arrstring3 = new String[3];
        arrstring3[0] = SummonSkillEntry.ALLATORIxDEMO("\u5163\u90db");
        arrstring3[1] = EmojiFilter.ALLATORIxDEMO("\u757b");
        arrstring3[2] = SummonSkillEntry.ALLATORIxDEMO("\u5940");
        cashShopItemAdder5.b.setModel(new DefaultComboBoxModel<String>(arrstring3));
        CashShopItemAdder cashShopItemAdder6 = a2;
        cashShopItemAdder6.C.setText(EmojiFilter.ALLATORIxDEMO("\u4e09\u67fa"));
        CashShopItemAdder cashShopItemAdder7 = a2;
        cashShopItemAdder6.P.add(cashShopItemAdder7.E);
        cashShopItemAdder7.E.setSelected(true);
        cashShopItemAdder6.E.setText("\u662f");
        cashShopItemAdder6.P.add(a2.e);
        cashShopItemAdder6.e.setText("\u5426");
        cashShopItemAdder6.w.setText(SummonSkillEntry.ALLATORIxDEMO("\u65bb\u58ad"));
        cashShopItemAdder6.w.addActionListener(new ActionListener(){
            {
                8 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                8 a3;
                a3.CashShopItemAdder.this.ALLATORIxDEMO(a2);
            }
        });
        cashShopItemAdder6.J.setText(EmojiFilter.ALLATORIxDEMO("\u5545\u548d\u540e\u7a7d"));
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        cashShopItemAdder6.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.l).addGroup(groupLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.i).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.c, -2, -1, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.A).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.G, -2, -1, -2)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addComponent(a2.I).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.d, -2, 100, -2)).addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.j).addComponent(a2.F).addComponent(a2.M).addComponent(a2.f)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.k).addComponent(a2.ALLATORIxDEMO).addComponent(a2.a).addComponent(a2.g)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.H).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.w)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.m).addComponent(a2.h)).addGap(18, 18, 18).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.J).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.K)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a2.L).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.b, -2, 65, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.C).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.E).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.e)).addGroup(groupLayout.createSequentialGroup().addComponent(a2.D).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.B, -2, 100, -2))).addGap(0, 0, 32767))))))))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.l).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.A).addComponent(a2.G, -2, -1, -2).addComponent(a2.L).addComponent(a2.b, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.i).addComponent(a2.c, -2, -1, -2).addComponent(a2.C).addComponent(a2.E).addComponent(a2.e)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.I).addComponent(a2.d, -2, -1, -2).addComponent(a2.m).addComponent(a2.D).addComponent(a2.B, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.j).addComponent(a2.k, -2, -1, -2).addComponent(a2.J).addComponent(a2.K, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.F).addComponent(a2.ALLATORIxDEMO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.M).addComponent(a2.a, -2, -1, -2).addComponent(a2.h)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(a2.f).addComponent(a2.g, -2, -1, -2).addComponent(a2.H).addComponent(a2.w)).addContainerGap(-1, 32767)));
        cashShopItemAdder6.pack();
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(SummonSkillEntry.ALLATORIxDEMO("9(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010\u0001\u0010+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013(9(\u0013+\u0013+\u0013+\u0013+\u0010(\u0013(\u0013+\u0013(\u0013+\u0013+\u0010(\u0013(\u0010(\u0013(\u0010(\u0013(\u0010+\u0013(\u0010(\u0013+\u0013+\u0013+\u0013+\u0010\u0001\u0010+\u0013+\u0013+\u0013+\u0010+\u0010+\u0010+\u0013+\u0010+\u0013+\u0010+\u0010+\u0013(\u0013+\u0010+\u0010+\u0010+\u0010+\u0013(\u0013+\u0013+\u0013+\u0013+\u0013(9(\u0013+\u0013+\u0013+\u0013(\u0010(\u0013(\u0013+\u0013(\u0013+\u0013(\u0010(\u0013+\u0010+\u0013(\u0013(\u0013(\u0010+\u0013+\u0010+\u0013+\u0013+\u0013+\u0013+\u0010\u0001\u0010+\u0013+\u0013+\u0013+\u0010+\u0010+\u0010(\u0010+\u0010(\u0010+\u0010+\u0010+\u0013(\u0013+\u0010(\u0010+\u0010+\u0010+\u0010(\u0010+\u0013+\u0013+\u0013+\u0013(9(\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0010\u0001\u0010+|iU~@hR\u007fZd]+Qr\u0013J_gR\u007f\\yZ+|iU~@hR\u007f\\y\u0013}\u0004%\u0000+wN~D\u0013(9(\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0010\u0001\u0010+\u0013+\u0013+\u0013+\u0013+\u0013+[\u007fG{\t$\u001c|D|\u001dj_gR\u007f\\yZ%Pd^+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013(9(\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0013+\u0010\u0001\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(\u0010(9"));
        EventQueue.invokeLater(new Runnable(){
            {
                1 a2;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                new Thread(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        try {
                            new CashShopItemAdder().setVisible(true);
                            return;
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return;
                        }
                    }
                    {
                        1 a3;
                    }
                }).start();
            }
        });
    }

    private /* synthetic */ void E(KeyEvent a2) {
        UIHelper.numberOnly(a2);
    }

    private /* synthetic */ void l(KeyEvent a2) {
        UIHelper.numberWithNegative(a2);
    }
}

