/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 */
package FuckingHackerToby;

import FuckingHackerToby.E;
import FuckingHackerToby.K;
import FuckingHackerToby.o;
import FuckingHackerToby.za;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import constants.skills.SkillType;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public final class z {
    public static final /* synthetic */ String k = "1.29.3.1";
    public static final /* synthetic */ E K;
    public static final /* synthetic */ Path ALLATORIxDEMO;
    public static final /* synthetic */ int[] d;
    private static final /* synthetic */ String B = "de/resource/data";
    public static final /* synthetic */ String[] a;

    public static /* synthetic */ {
        byte[] arrby;
        int n2;
        K = E.ALLATORIxDEMO();
        Object object = za.H(B);
        object = Base64.getDecoder().decode((byte[])object);
        object = FuckingHackerToby.K.ALLATORIxDEMO(object);
        String string = new String((byte[])object);
        String[] arrstring = string.split(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"@~"));
        a = new String[arrstring.length];
        d = new int[arrstring.length];
        int n3 = n2 = 0;
        while (n3 < arrstring.length) {
            try {
                String string2 = arrstring[n2];
                String[] arrstring2 = string2.split(SkillType.ALLATORIxDEMO("\t"));
                String string3 = arrstring2[0];
                int n4 = Integer.parseInt(arrstring2[1]);
                z.a[n2] = string3;
                z.d[n2] = n4;
            }
            catch (Exception exception) {
                z.a[n2] = "";
                z.d[n2] = 0;
            }
            n3 = ++n2;
        }
        object = null;
        try {
            arrby = object = (Object)Paths.get(z.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        }
        catch (URISyntaxException uRISyntaxException) {
            arrby = object;
            uRISyntaxException.printStackTrace();
        }
        ALLATORIxDEMO = arrby;
    }

    public static /* synthetic */ void ALLATORIxDEMO() {
        NimbusLookAndFeel nimbusLookAndFeel = new NimbusLookAndFeel();
        UIDefaults uIDefaults = nimbusLookAndFeel.getDefaults();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        o.ALLATORIxDEMO(uIDefaults);
        try {
            UIManager.setLookAndFeel(nimbusLookAndFeel);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private /* synthetic */ z() {
        z a2;
    }

    public static /* synthetic */ void H() {
        try {
            String string = UIManager.getSystemLookAndFeelClassName();
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(string);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
}

