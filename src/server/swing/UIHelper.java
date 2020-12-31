/*
 * Decompiled with CFR 0.150.
 */
package server.swing;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.MapleShopItem;

/*
 * Exception performing whole class analysis ignored.
 */
public class UIHelper {
    public static /* synthetic */ void numberWithNegative(KeyEvent a2) {
        char c2 = a2.getKeyChar();
        if ((c2 < '0' || c2 > '9') && c2 != '-') {
            a2.consume();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean findProcess(String a) {
        if (a.split("/").length > 1) {
            a = a.split("/")[a.split("/").length - 1];
        }
        var1_1 = null;
        try {
            var2_3 = Runtime.getRuntime().exec(MapleShopItem.ALLATORIxDEMO("\u001fJ\u0018\u0007SD\\S\u001dT\u0017K\u0015T\b"));
            var1_1 = new BufferedReader(new InputStreamReader(var2_3.getInputStream()));
            while ((var3_5 = var1_1.readLine()) != null) {
                if (!var3_5.contains(a)) continue;
                var4_7 = true;
                if (var1_1 == null) return var4_7;
                ** GOTO lbl29
            }
            ** GOTO lbl-1000
        }
        catch (IOException var2_4) {
            try {
                Logger.getLogger(UIHelper.class.getName()).log(Level.SEVERE, null, var2_4);
                var3_6 = false;
                if (var1_1 == null) return var3_6;
            }
            catch (Throwable var6_12) {
                if (var1_1 != null) {
                    try {
                        var1_1.close();
                        v0 = var6_12;
                        throw v0;
                    }
                    catch (IOException var1_2) {
                        // empty catch block
                    }
                }
                v0 = var6_12;
                throw v0;
            }
lbl29:
            // 1 sources

            try {
                var1_1.close();
                return var4_7;
            }
            catch (IOException var5_10) {
                // empty catch block
            }
            return var4_7;
lbl-1000:
            // 1 sources

            {
                var4_8 = false;
                if (var1_1 == null) return var4_8;
            }
            try {
                var1_1.close();
                return var4_8;
            }
            catch (IOException var5_11) {
                // empty catch block
            }
            return var4_8;
            try {
                var1_1.close();
                return var3_6;
            }
            catch (IOException var4_9) {
                // empty catch block
            }
            return var3_6;
        }
    }

    public static /* synthetic */ boolean killProcess(String a2) {
        if (a2.split("/").length > 1) {
            a2 = a2.split("/")[a2.split("/").length - 1];
        }
        if (UIHelper.findProcess(a2)) {
            try {
                Runtime.getRuntime().exec("taskkill /F /IM " + a2);
            }
            catch (IOException iOException) {
                Logger.getLogger(UIHelper.class.getName()).log(Level.SEVERE, null, iOException);
            }
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean runEXE(String a2, String a32) {
        Object object;
        String string;
        Runtime runtime;
        if (!new File(a2).exists()) {
            return false;
        }
        if (UIHelper.findProcess(a2)) {
            UIHelper.killProcess(a2);
        }
        try {
            runtime = Runtime.getRuntime();
            string = a2;
            object = a32 == null || a32.isEmpty() ? "" : " " + a32;
        }
        catch (IOException a32) {
            Logger.getLogger(UIHelper.class.getName()).log(Level.SEVERE, null, a32);
            return true;
        }
        {
            runtime.exec(string + (String)object);
            return true;
        }
    }

    public /* synthetic */ UIHelper() {
        UIHelper a2;
    }

    public static /* synthetic */ void numberOnly(KeyEvent a2) {
        char c2 = a2.getKeyChar();
        if (c2 >= '0' && c2 <= '9') {
            return;
        }
        a2.consume();
    }

    public static /* synthetic */ boolean runEXE(String a2) {
        return UIHelper.runEXE(a2, null);
    }
}

