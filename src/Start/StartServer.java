/*
 * Decompiled with CFR 0.150.
 */
package Start;

import FuckingHackerToby.za;
import client.inventory.MapleAndroid;
import constants.GameSetConstants;
import constants.VersionCheckConstants;
import database.DBConPool;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;
import server.swing.WvsCenter;
import server.swing.autoupdate.AutoUpdate;
import server.swing.tools.SqlRecovery;
import tools.KoreanDateUtil;
import tools.use.GetMACAddress;

public class StartServer {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a) throws IOException, SQLException, ParseException {
        block19: {
            System.out.println(MapleAndroid.ALLATORIxDEMO("\u001dP4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4y4S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7P\u001dP7S7S7S7S4P7P7S7P7S7S4P7P4P7P4P7P4S7P4P7S7S7S7S4y4S7S7S7S4S4S4S7S4S7S4S4S7P7S4S4S4S4S7P7S7S7S7S7P\u001dP7S7S7S7P4P7P7S7P7S7P4P7S4S7P7P7P4S7S4S7S7S7S7S4y4S7S7S7S4S4S4P4S4P4S4S4S7P7S4P4S4S4S4P4S7S7S7S7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4SX\u0011q\u0006d\u0010v\u0007~\u001cySu\n72{\u001fv\u0007x\u0001~SX\u0011q\u0006d\u0010v\u0007x\u00017\u0005 ]$SS6Z<7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4S7S7S7S7S7S\u007f\u0007c\u0003-\\8\u0004`\u00049\u0012{\u001fv\u0007x\u0001~]t\u001czS7S7S7S7S7S7P\u001dP7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S7S4y4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P4P\u001d"));
            GameSetConstants.loadsetting();
            var1_1 = true;
            var2_2 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                System.out.println(KoreanDateUtil.ALLATORIxDEMO("\u306a[#E+Z\u9059\u7dcc\u306b[#E+Z\u5d88\u6206\u52e5\u5eec\u7ab1\u9035\u7da0"));
                ** if (var2_2 == null) goto lbl-1000
            }
            catch (Throwable var3_5) {
                if (var2_2 == null) ** GOTO lbl21
                try {
                    var2_2.close();
                    v0 = var3_5;
                    ** GOTO lbl22
                }
                catch (Throwable var4_7) {
                    try {
                        var3_5.addSuppressed(var4_7);
lbl21:
                        // 2 sources

                        v0 = var3_5;
lbl22:
                        // 2 sources

                        throw v0;
                    }
                    catch (Exception var2_3) {
                        v1 = var1_1 = false;
                        break block19;
                    }
                }
            }
lbl-1000:
            // 1 sources

            {
                var2_2.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            v1 = var1_1;
        }
        if (!v1) {
            JOptionPane.showMessageDialog(null, "\u627e\u4e0d\u5230\u8cc7\u6599\u5eab " + GameSetConstants.dbName + " !\u5c07\u70ba\u60a8\u91cd\u65b0\u5efa\u7acb\u3002");
            JOptionPane.showMessageDialog(null, MapleAndroid.ALLATORIxDEMO("\u8adc\u900b\u64d0\u60db\u60e4\u89f2\u5005\u5116\u7693\u8cb4\u658e\u5ed8\u8df8\u5fe26"));
            DBConPool.createDatabase();
            SqlRecovery.main(null);
            return;
        }
        GameSetConstants.reloadset();
        if (GameSetConstants.EXPIRED) {
            System.out.println(KoreanDateUtil.ALLATORIxDEMO("\u6b1e\u671b\u5d88\u4e1c\u5953\u5814\u3078"));
            System.exit(0);
        }
        if (!GameSetConstants.KeyCheck()) {
            System.out.println("\u3010\u96fb\u8166\u6388\u6b0a\u3011\u672c\u96fb\u8166\u5c1a\u672a\u6388\u6b0a\r\n\u6388\u6b0akey:" + GetMACAddress.getMD5Key());
            StartServer.showDialog("\u5982\u9808\u958b\u901a\u8acb\u8907\u88fd\u4ee5\u4e0bkey\u7d66BOBO! \r\nkey:" + GetMACAddress.getMD5Key() + "\r\n\u806f\u7d61\u65b9\u5f0f: LINE henry70336");
            System.exit(0);
        } else {
            System.out.println(MapleAndroid.ALLATORIxDEMO("\u3007\u9688\u8171\u63fb\u6b1d\u3062\u96ec\u8115\u639f\u6b79\u5de5\u5bff\u6207"));
        }
        GameSetConstants.handleVersion();
        var2_4 = new File("");
        var3_6 = var2_4.getAbsolutePath();
        var4_8 = var3_6 + File.separator + "AutoUpdate.bat";
        za.l(var4_8);
        var5_10 = AutoUpdate.getInstance().UpdateLib();
        if (var5_10 == 0) {
            JOptionPane.showMessageDialog(null, KoreanDateUtil.ALLATORIxDEMO("z\u0013t\u4e71\u8f1f\u668e\u65a6\u594b\u6541["));
            return;
        }
        if (var5_10 == 1) {
            JOptionPane.showMessageDialog(null, MapleAndroid.ALLATORIxDEMO("\u001f~\u0011\u66e3\u65c3\u5b9b\u6263;\u5c74\u5548\u52a6U<U<9\u0016o\u00166"));
            Runtime.getRuntime().exec(KoreanDateUtil.ALLATORIxDEMO("u\u0017rZ9\u00196\n\u007f\u0014qZz\u0015u\u001bz\u0012y\tbZ;\u00146H6D6\u0014c\u00166\\0ZT5T58\u001fn\u001f"));
            System.exit(0);
            return;
        }
        if (GameSetConstants.AUTO_UPDATE && !GameSetConstants.ADMIN_MODE && AutoUpdate.checkupdate()) {
            System.out.println(MapleAndroid.ALLATORIxDEMO("\u671e\u6773\u65a7\u723b\u673bR\u8adc\u9041\u885b\u6687\u65a7R6"));
            AutoUpdate.main(null);
            return;
        }
        if (VersionCheckConstants.isNowVersion()) {
            System.setProperty(KoreanDateUtil.ALLATORIxDEMO("E\u000ew\bb8o)a\u0013x\u001d"), MapleAndroid.ALLATORIxDEMO("\u0007e\u0006r"));
            EventQueue.invokeLater(new Runnable(){
                {
                    1 a2;
                }

                @Override
                public /* synthetic */ void run() {
                    WvsCenter.getInstance().setVisible(true);
                }
            });
            return;
        }
        JOptionPane.showMessageDialog(null, KoreanDateUtil.ALLATORIxDEMO("\u7232\u673a\u9355\u8ab2V\u8add\u668e\u65a6\u677a\u65a6\u7232\u673a["));
    }

    public /* synthetic */ StartServer() {
        StartServer a2;
    }

    public static /* synthetic */ void showDialog(String a2) {
        JComponent jComponent = new JTextArea(6, 25);
        JTextArea jTextArea = jComponent;
        JTextArea jTextArea2 = jComponent;
        ((JTextComponent)jComponent).setText(a2);
        jTextArea2.setEditable(false);
        jTextArea2.setWrapStyleWord(true);
        jTextArea.setLineWrap(true);
        jTextArea.setCaretPosition(0);
        jComponent = new JScrollPane(jComponent);
        ((JScrollPane)jComponent).setHorizontalScrollBarPolicy(31);
        JOptionPane.showMessageDialog(null, jComponent, MapleAndroid.ALLATORIxDEMO("\u63fb\u6b1d\u8a79\u6078"), 0);
    }
}

