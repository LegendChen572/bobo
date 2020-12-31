/*
 * Decompiled with CFR 0.150.
 */
package server.swing.autoupdate;

import client.messages.commands.player.eventSystem.SellSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ProgressBarUI;
import server.MTSStorage;
import server.swing.autoupdate.GetFileMD5;
import server.swing.autoupdate.ProgressUI;
import tools.FileOperation;
import tools.FileoutputUtil;
import tools.html.getHtml;

public class AutoUpdate
extends JFrame {
    private /* synthetic */ JProgressBar ALLATORIxDEMO;
    private /* synthetic */ JLabel B;
    private static /* synthetic */ String C;
    private static /* synthetic */ String I;
    private static /* synthetic */ String M;
    private static /* synthetic */ String h;
    private static /* synthetic */ String i;
    private /* synthetic */ JColorChooser d;
    private static /* synthetic */ String F;
    private static /* synthetic */ String J;
    private static /* synthetic */ String j;
    private static /* synthetic */ AutoUpdate E;
    private static /* synthetic */ String e;
    private /* synthetic */ JButton K;
    private static /* synthetic */ String D;
    private /* synthetic */ JButton k;
    private static /* synthetic */ String L;
    private /* synthetic */ JColorChooser a;
    private static /* synthetic */ String f;
    private static /* synthetic */ String H;
    private static /* synthetic */ boolean g;

    public /* synthetic */ void RunUpdate() {
        AutoUpdate a2;
        new Thread(new Runnable(){
            {
                5 a3;
            }

            @Override
            public /* synthetic */ void run() {
                try {
                    5 a2;
                    a2.AutoUpdate.this.runs(false);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
        }).start();
    }

    private /* synthetic */ void ALLATORIxDEMO(ActionEvent a2) {
        AutoUpdate a3;
        new Thread(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                try {
                    6 a2;
                    a2.AutoUpdate.this.runs(true);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
            {
                6 a3;
            }
        }).start();
    }

    public /* synthetic */ int UpdateLib() {
        int n2;
        int n3 = 2;
        String[] arrstring = new File(MTSStorage.ALLATORIxDEMO("p\t~"));
        if (!arrstring.exists()) {
            arrstring.mkdirs();
        }
        if ((arrstring = AutoUpdate.getLibs()) == null) {
            return n3;
        }
        int n4 = arrstring.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            String string = arrstring[n2];
            if (!FileOperation.checkExistLocal("lib/" + string).booleanValue()) {
                byte[] arrby;
                AutoUpdate a2;
                block7: {
                    try {
                        arrby = a2.getFileFormServer(H + string, e + string, false);
                        if (arrby != null) break block7;
                        System.out.println(SellSystem.ALLATORIxDEMO("\u7307\u53b9\u0019\u0006\u0017\u6afb\u683d\u595e\u6522N"));
                        return 0;
                    }
                    catch (Exception exception) {
                        Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, exception);
                        return 0;
                    }
                }
                a2.autoUpdate(arrby, "lib/" + string);
                System.out.println("\u6b63\u5728\u81ea\u52d5\u66f4\u65b0lib : " + string);
                n3 = 1;
            }
            n5 = ++n2;
        }
        FileOperation.DeleteLocal(MTSStorage.ALLATORIxDEMO("\fu\u00023\u000ey\u0014h\u00191\u0001p\f1U2P2P2!p\u0010t\u0001.Nv\u0001n"));
        return n3;
    }

    public static /* synthetic */ boolean Check(String a2, String a322) throws Exception {
        boolean bl;
        Object object = new StringBuilder();
        ((StringBuilder)object).append(a2);
        ((StringBuilder)object).append("?" + System.currentTimeMillis());
        object = (HttpURLConnection)new URL(((StringBuilder)object).toString()).openConnection();
        ((URLConnection)object).connect();
        long l2 = ((URLConnection)object).getLastModified();
        int bl2 = ((HttpURLConnection)object).getResponseCode();
        boolean bl3 = bl = bl2 >= 200 && bl2 < 300;
        if (bl) {
            if (g) {
                long n2 = System.currentTimeMillis();
                String string = AutoUpdate.getMD5().replaceAll(" ", "");
                long l3 = l2;
                System.out.println("\u9060\u7aef\u6a94\u6848MD5\u6700\u5f8c\u4fee\u6539\u6642\u9593:" + l3 + " \u6642\u9593:" + FileoutputUtil.getTime(l3));
                System.out.println("\u9060\u7aef\u6a94\u6848MD5\u6293\u53d6\u6d88\u8017\u6642\u9593: " + (n2 - System.currentTimeMillis()) + " \u6beb\u79d2");
                n2 = System.currentTimeMillis();
                String string2 = GetFileMD5.getFileMD5String(a322);
                System.out.println("\u672c\u5730\u6a94\u6848MD5\u6293\u53d6\u6d88\u8017\u6642\u9593: " + (n2 - System.currentTimeMillis()) + " \u6beb\u79d2");
                boolean a322 = string.equals(string2);
                System.out.println("\u9060\u7aef\u6a94\u6848MD5:" + string + " \u672c\u5730\u6a94\u6848MD5\u5927\u5c0f:" + string2 + "\u662f\u5426\u60f3\u540c? :" + a322);
                if (a322) {
                    return false;
                }
            } else {
                long l4;
                int n2 = ((URLConnection)object).getContentLength();
                boolean bl4 = (long)n2 == (l4 = GetFileMD5.getDocSize(f));
                System.out.println("\u9060\u7aef\u6a94\u6848\u5927\u5c0f:" + n2 + " \u672c\u5730\u6a94\u6848\u5927\u5c0f:" + l4 + "\u662f\u5426\u60f3\u540c? :" + bl4);
                if (bl4) {
                    return false;
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean checkupdate() {
        boolean bl;
        block3: {
            bl = false;
            boolean bl2 = AutoUpdate.getServerStatus(L);
            if (!bl2) break block3;
            bl = AutoUpdate.Check(L, f);
        }
        try {
            bl = AutoUpdate.Check(j, f);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }

    @Override
    public /* synthetic */ void setVisible(boolean a2) {
        AutoUpdate a3;
        a3.setDefaultCloseOperation(1);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        AutoUpdate autoUpdate = a3;
        autoUpdate.setLocation((int)(dimension.getWidth() - (double)autoUpdate.getWidth()) / 2, (int)(dimension.getHeight() - (double)a3.getHeight()) / 2);
        if (a2) {
            a3.ALLATORIxDEMO();
        }
        super.setVisible(a2);
    }

    public /* synthetic */ boolean CheckUpdate(String a22, String a3) throws Exception {
        AutoUpdate a4;
        AutoUpdate autoUpdate = a4;
        autoUpdate.B.setText(SellSystem.ALLATORIxDEMO("\u6b0c\u575d\u6acd\u6e59\u6afb\u683d\u7227\u6759A[A[A[A[A\u8abe\u7a62\u5ff9\u306d"));
        boolean a22 = AutoUpdate.Check(a22, a3);
        autoUpdate.B.setText("\u6aa2\u6e2c\u6a94\u6848\u5b8c\u7562...\u662f\u5426\u9700\u8981\u66f4\u65b0:" + !a22);
        return true;
    }

    public /* synthetic */ byte[] getFileFormServer(String a2, String a2222, boolean a3) throws Exception {
        Object object;
        byte[] a2222;
        block3: {
            AutoUpdate a4;
            if (!AutoUpdate.getServerStatus((String)a2) || a3) {
                a2 = a2222;
            }
            a2222 = new StringBuilder();
            ((StringBuilder)a2222).append((String)a2);
            ((StringBuilder)a2222).append("?" + System.currentTimeMillis());
            a2 = (HttpURLConnection)new URL(((StringBuilder)a2222).toString()).openConnection();
            ((URLConnection)a2).connect();
            int a2222 = ((HttpURLConnection)a2).getResponseCode();
            a3 = a2222 >= 200 && a2222 < 300 ? 1 : 0;
            a2222 = null;
            Object object2 = a2;
            a4.B.setText(MTSStorage.ALLATORIxDEMO("\u6b7f\u5748\u89ff\u67f0\u907c\u7a8f\u6a88\u68282N2N2N2N2\u8aab\u7a11\u5fec\u301e"));
            a2 = ((URLConnection)object2).getInputStream();
            a3 = ((URLConnection)object2).getContentLength();
            System.out.println("size:" + a3);
            a2222 = new byte[a3];
            int n2 = 0;
            int n3 = 0;
            int n4 = n2;
            while (n4 < a3) {
                int n5 = n2;
                n3 = ((InputStream)a2).read(a2222, n5, a3 - n5);
                if (n3 <= 0) {
                    object = a2;
                    break block3;
                }
                long l2 = (long)(n2 += n3) * 100L / (long)a3;
                n4 = n2;
                a4.ALLATORIxDEMO.setValue((int)l2);
            }
            object = a2;
        }
        ((InputStream)object).close();
        return a2222;
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        AutoUpdate a2;
        AutoUpdate autoUpdate = a2;
        autoUpdate.ALLATORIxDEMO.setMaximum(100);
        autoUpdate.ALLATORIxDEMO.setMinimum(0);
    }

    public /* synthetic */ AutoUpdate() {
        AutoUpdate a2;
        AutoUpdate autoUpdate = a2;
        autoUpdate.H();
    }

    public static /* synthetic */ String[] getLibs() {
        String[] arrstring = null;
        try {
            String string = F;
            if (!AutoUpdate.getServerStatus(string)) {
                string = C;
            }
            arrstring = getHtml.getHtmlContent(string).replaceAll(MTSStorage.ALLATORIxDEMO("m\u0016"), "").trim().split(" ");
            return arrstring;
        }
        catch (Exception exception) {
            Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, exception);
            return arrstring;
        }
    }

    public /* synthetic */ void reStartXihetool() {
        try {
            File file = new File("");
            Object object = file.getAbsolutePath();
            object = Runtime.getRuntime().exec("java -cp \"" + (String)object + "/" + f + "\" com.test skipUpdate");
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void runs(boolean a22) throws IOException {
        Object object;
        Object object2;
        Object object3;
        AutoUpdate a3;
        Object object4 = null;
        String string = null;
        a3.B.setText(SellSystem.ALLATORIxDEMO("\u6b0c\u575d\u684e\u9a22\u669b\u65c5\u6afb\u683dA[A[A[A[A\u8abe\u7a62\u5ff9\u306d"));
        try {
            int n2;
            object3 = new File(MTSStorage.ALLATORIxDEMO("p\t~"));
            if (!((File)object3).exists()) {
                ((File)object3).mkdirs();
            }
            object2 = AutoUpdate.getLibs();
            object = object2;
            int n3 = ((String[])object).length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                String string2 = object[n2];
                if (!FileOperation.checkExistLocal("lib/" + string2).booleanValue()) {
                    byte[] arrby = a3.getFileFormServer(H + string2, e + string2, a22);
                    if (arrby == null) {
                        a3.B.setText(SellSystem.ALLATORIxDEMO("\u7307\u53b9\u0019\u0006\u0017\u6afb\u683d\u595e\u6522N"));
                        System.out.println(MTSStorage.ALLATORIxDEMO("\u7312\u53ca\fu\u0002\u6a88\u6828\u592d\u6537="));
                    } else {
                        a3.B.setText(SellSystem.ALLATORIxDEMO("\u0019\u0006\u0017\u6afb\u683d\u512c\u4e83\u731d\u53a3\u627f\u52eaN"));
                        a3.autoUpdate(arrby, "lib/" + string2);
                        a3.B.setText(MTSStorage.ALLATORIxDEMO("\fu\u0002\u6a88\u6828\u515f\u4e96\u4e17\u8f69\u5b90\u7502="));
                    }
                }
                n4 = ++n2;
            }
            AutoUpdate autoUpdate = a3;
            object = autoUpdate.getFileFormServer(L, j, a22);
            if (!autoUpdate.CheckUpdate(L, f)) {
                object4 = SellSystem.ALLATORIxDEMO("\u7681\u5238\u5d9d\u665a\u676f\u65c5\u7227\u6759N");
                string = MTSStorage.ALLATORIxDEMO("Q\u0005o\u0013}\u0007y");
            } else if (object == null) {
                object4 = SellSystem.ALLATORIxDEMO("\u669b\u65c5\u595e\u8d50\uff6e\u53ea\u568f\uff6f\u4ea1-7-7\u4e7f\u4e64\u8f08\u6afb\u683d\u595e\u8d50\uff6e");
                string = MTSStorage.ALLATORIxDEMO("Y\u0012n\u000fn");
            } else {
                a3.autoUpdate((byte[])object, h);
            }
            object3 = ManagementFactory.getRuntimeMXBean().getName();
        }
        catch (Exception exception) {
            try {
                object4 = "\u66f4\u65b0\u5931\u8d25\uff01\u539f\u56e0\uff1a" + exception.getMessage();
                string = MTSStorage.ALLATORIxDEMO("Y\u0012n\u000fn");
                exception.printStackTrace();
                object2 = ManagementFactory.getRuntimeMXBean().getName();
            }
            catch (Throwable throwable) {
                String a22 = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
                System.out.println("Pid is:" + a22);
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("taskkill /f /PID " + a22 + "\r\n");
                ((StringBuilder)object4).append(MTSStorage.ALLATORIxDEMO("\u0003q\u0004<O\u007f@l\tr\u0007<\fs\u0003}\ft\u000fo\u0014<Mr@.@\"@r\u0015p@:F<\u0004y\f<\"S\"SNy\u0018y@:F<\u0012y\u000e<\"S\"SNy\u0018yNh\u0005q\u0010<\"S\"SNy\u0018y@:F<\u0013h\u0001n\u0014<\"S\"SNy\u0018ym\u0016"));
                ((StringBuilder)object4).append(SellSystem.ALLATORIxDEMO("\u0006\u001b\u0014\u001d\u0001O7 7 [\n\r\nxe"));
                ((StringBuilder)object4).append(MTSStorage.ALLATORIxDEMO("y\u0018u\u0013hm\u0016"));
                FileoutputUtil.logToFile(SellSystem.ALLATORIxDEMO("4\u001a\u0001\u0000 \u001f\u0011\u000e\u0001\n[\r\u0014\u001b"), ((StringBuilder)object4).toString());
                Runtime.getRuntime().exec(MTSStorage.ALLATORIxDEMO("!i\u0014s5l\u0004}\u0014yN~\u0001h"));
                throw throwable;
            }
            object = object2.split("@")[0];
            System.out.println("Pid is:" + (String)object);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("taskkill /f /PID " + (String)object + "\r\n");
            stringBuilder.append(SellSystem.ALLATORIxDEMO("\u0016\u0002\u0011OZ\fU\u001f\u001c\u0001\u0012O\u0019\u0000\u0016\u000e\u0019\u0007\u001a\u001c\u0001OX\u0001U]UQU\u0001\u0000\u0003UISO\u0011\n\u0019O7 7 [\n\r\nUISO\u0007\n\u001bO7 7 [\n\r\n[\u001b\u0010\u0002\u0005O7 7 [\n\r\nUISO\u0006\u001b\u0014\u001d\u0001O7 7 [\n\r\nxe"));
            stringBuilder.append(MTSStorage.ALLATORIxDEMO("\u0013h\u0001n\u0014<\"S\"SNy\u0018ym\u0016"));
            stringBuilder.append(SellSystem.ALLATORIxDEMO("\n\r\u0006\u0006\u001bxe"));
            FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("!i\u0014s5l\u0004}\u0014yN~\u0001h"), stringBuilder.toString());
            Runtime.getRuntime().exec(SellSystem.ALLATORIxDEMO("4\u001a\u0001\u0000 \u001f\u0011\u000e\u0001\n[\r\u0014\u001b"));
            return;
        }
        object2 = ((String)object3).split("@")[0];
        System.out.println("Pid is:" + (String)object2);
        object = new StringBuilder();
        ((StringBuilder)object).append("taskkill /f /PID " + (String)object2 + "\r\n");
        ((StringBuilder)object).append(SellSystem.ALLATORIxDEMO("\u0016\u0002\u0011OZ\fU\u001f\u001c\u0001\u0012O\u0019\u0000\u0016\u000e\u0019\u0007\u001a\u001c\u0001OX\u0001U]UQU\u0001\u0000\u0003UISO\u0011\n\u0019O7 7 [\n\r\nUISO\u0007\n\u001bO7 7 [\n\r\n[\u001b\u0010\u0002\u0005O7 7 [\n\r\nUISO\u0006\u001b\u0014\u001d\u0001O7 7 [\n\r\nxe"));
        ((StringBuilder)object).append(MTSStorage.ALLATORIxDEMO("\u0013h\u0001n\u0014<\"S\"SNy\u0018ym\u0016"));
        ((StringBuilder)object).append(SellSystem.ALLATORIxDEMO("\n\r\u0006\u0006\u001bxe"));
        FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("!i\u0014s5l\u0004}\u0014yN~\u0001h"), ((StringBuilder)object).toString());
        Runtime.getRuntime().exec(SellSystem.ALLATORIxDEMO("4\u001a\u0001\u0000 \u001f\u0011\u000e\u0001\n[\r\u0014\u001b"));
        return;
    }

    private final /* synthetic */ long ALLATORIxDEMO(String a22) {
        try {
            a22 = new URL((String)a22);
            long l2 = ((HttpURLConnection)((URL)a22).openConnection()).getLastModified();
            if (l2 == 0L && "file".equals(((URL)a22).getProtocol())) {
                l2 = Paths.get(((URL)a22).toURI()).toFile().lastModified();
            }
            return l2;
        }
        catch (Exception a22) {
            return System.currentTimeMillis();
        }
    }

    public /* synthetic */ void delFile(String a22) {
        try {
            a22 = a22.toString();
            new File(a22).delete();
            return;
        }
        catch (Exception a22) {
            System.out.println(MTSStorage.ALLATORIxDEMO("\u5236\u9604\u6a88\u64ad\u4f40\u519a\u9333"));
            a22.printStackTrace();
            return;
        }
    }

    public static /* synthetic */ {
        f = "BOBO.exe";
        h = "BOBO.exe.temp";
        D = "UpdateTool.exe";
        L = "http://bobofiles.tk/bobo/BOBO.exe";
        j = "http://mapleserver.top/bobo/BOBO.exe";
        i = "http://bobofiles.tk/bobo/UpdateTool.exe";
        J = "http://mapleserver.top/bobo/UpdateTool.exe";
        M = "http://bobofiles.tk/bobo/callback.php";
        I = "http://mapleserver.top/bobo/callback.php";
        F = "http://bobofiles.tk/bobo/callback_lib.php";
        C = "http://mapleserver.top/bobo/callback_lib.php";
        H = "http://bobofiles.tk/bobo/lib/";
        e = "http://mapleserver.top/bobo/lib/";
        E = new AutoUpdate();
        g = true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean getServerStatus(String a2) throws Exception {
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a2);
        stringBuilder.append("?" + System.currentTimeMillis());
        HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(stringBuilder.toString()).openConnection();
        httpURLConnection.connect();
        switch (httpURLConnection.getResponseCode()) {
            case 403: 
            case 404: 
            case 500: 
            case 504: {
                return false;
            }
        }
        return bl;
    }

    public static /* synthetic */ AutoUpdate getInstance() {
        return E;
    }

    public /* synthetic */ void autoUpdate(byte[] a2, String a3) throws Exception {
        a3 = new File("").getAbsolutePath() + File.separator + (String)a3;
        a3 = new File((String)a3);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)a3));
        ((OutputStream)bufferedOutputStream).write(a2);
        ((OutputStream)bufferedOutputStream).close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(MTSStorage.ALLATORIxDEMO("\u0016C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?j?@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<C\u0016C<@<@<@<@?C<C<@<C<@<@?C<C?C<C?C<C?@<C?C<@<@<@<@?j?@<@<@<@?@?@?@<@?@<@?@?@<C<@?@?@?@?@<C<@<@<@<@<C\u0016C<@<@<@<C?C<C<@<C<@<C?C<@?@<C<C<C?@<@?@<@<@<@<@?j?@<@<@<@?@?@?C?@?C?@?@?@<C<@?C?@?@?@?C?@<@<@<@<C\u0016C<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@?j?@S\u0002z\u0015o\u0003}\u0014u\u000fr@~\u0019<!p\f}\u0014s\u0012u@S\u0002z\u0015o\u0003}\u0014s\u0012<\u0016+N/@X%Q/<C\u0016C<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@?j?@<@<@<@<@<@t\u0014h\u0010&O3\u0017k\u00172\u0001p\f}\u0014s\u0012uN\u007f\u000fq@<@<@<@<@<@<C\u0016C<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@<@?j?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C?C\u0016"));
        try {
            for (UIManager.LookAndFeelInfo lookAndFeelInfo : UIManager.getInstalledLookAndFeels()) {
                if (!SellSystem.ALLATORIxDEMO("8\u001c\u0001\u0011\u0000\u0002\u001c").equals(lookAndFeelInfo.getName())) continue;
                UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, illegalAccessException);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, unsupportedLookAndFeelException);
        }
        EventQueue.invokeLater(new Runnable(){
            {
                7 a2;
            }

            @Override
            public /* synthetic */ void run() {
                AutoUpdate autoUpdate;
                AutoUpdate autoUpdate2 = autoUpdate = new AutoUpdate();
                autoUpdate2.H();
                autoUpdate2.setVisible(true);
                E = autoUpdate2;
            }
        });
    }

    private /* synthetic */ void H() {
        AutoUpdate a2;
        AutoUpdate autoUpdate = a2;
        AutoUpdate autoUpdate2 = a2;
        AutoUpdate autoUpdate3 = a2;
        autoUpdate2.a = new JColorChooser();
        autoUpdate3.d = new JColorChooser();
        autoUpdate2.k = new JButton();
        autoUpdate2.ALLATORIxDEMO = new JProgressBar(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void setUI(ProgressBarUI a2) {
                1 a3;
                1 v0 = a3;
                1 v1 = a3;
                super.setUI(new ProgressUI(v1, new Color(255, 201, 14)));
            }
        };
        autoUpdate2.B = new JLabel();
        a2.K = new JButton();
        autoUpdate.setDefaultCloseOperation(3);
        a2.k.setText(MTSStorage.ALLATORIxDEMO("\u9597\u59ab\u66e8\u65d04\u5266\u6d5d\u4e605"));
        autoUpdate.k.addActionListener(new ActionListener(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                2 a3;
                a3.AutoUpdate.this.H(a2);
            }
        });
        autoUpdate.B.setForeground(new Color(255, 0, 51));
        autoUpdate.K.setText(SellSystem.ALLATORIxDEMO("\u95e4\u59be\u669b\u65c5G\u5273\u6d2e\u4ef9F"));
        autoUpdate.K.addActionListener(new ActionListener(){

            @Override
            public /* synthetic */ void actionPerformed(ActionEvent a2) {
                3 a3;
                a3.AutoUpdate.this.ALLATORIxDEMO(a2);
            }
            {
                3 a3;
            }
        });
        GroupLayout groupLayout = new GroupLayout(a2.getContentPane());
        autoUpdate.getContentPane().setLayout(groupLayout);
        GroupLayout groupLayout2 = groupLayout;
        GroupLayout groupLayout3 = groupLayout;
        groupLayout2.setHorizontalGroup(groupLayout2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout3.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.B, -1, -1, 32767).addGroup(groupLayout.createSequentialGroup().addComponent(a2.k, -2, 237, -2).addGap(0, 1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(a2.ALLATORIxDEMO, GroupLayout.Alignment.TRAILING, -2, 236, -2).addComponent(a2.K, GroupLayout.Alignment.TRAILING, -2, 237, -2)))).addContainerGap()));
        groupLayout2.setVerticalGroup(groupLayout3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(a2.ALLATORIxDEMO, -2, 26, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(a2.B, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(a2.k).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(a2.K).addContainerGap()));
        autoUpdate.pack();
    }

    public static /* synthetic */ void openMyExe() {
        String string = new File("").getAbsolutePath();
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            process = runtime.exec(string + File.separator + D);
            return;
        }
        catch (Exception exception) {
            System.out.println(SellSystem.ALLATORIxDEMO("0\u001d\u0007\u0000\u0007O\u0018\u0016U\n\r\n\u0016O"));
            return;
        }
    }

    public static /* synthetic */ String getMD5() {
        String string = "";
        try {
            String string2 = M;
            if (!AutoUpdate.getServerStatus(string2)) {
                string2 = I;
            }
            string = getHtml.getHtmlContent(string2);
            string = string.replaceAll(SellSystem.ALLATORIxDEMO("xe"), "");
            return string;
        }
        catch (Exception exception) {
            Logger.getLogger(AutoUpdate.class.getName()).log(Level.SEVERE, null, exception);
            return string;
        }
    }

    private /* synthetic */ void H(ActionEvent a2) {
        AutoUpdate a3;
        new Thread(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                try {
                    4 a2;
                    a2.AutoUpdate.this.runs(false);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
            {
                4 a3;
            }
        }).start();
    }
}

