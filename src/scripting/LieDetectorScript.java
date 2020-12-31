/*
 * Decompiled with CFR 0.150.
 */
package scripting;

import constants.GameSetConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import server.Randomizer;
import server.maps.Event_PyramidSubway;
import server.swing.autoupdate.GetSelfDocName;
import tools.HexTool;
import tools.Pair;

public class LieDetectorScript {
    private static final /* synthetic */ String a;
    private static final /* synthetic */ String d = "98818D40B83AECCFB7AFD7FD9653E1037519AC61";
    private static final /* synthetic */ String ALLATORIxDEMO = "http://localhost/captcha.php?verify=98818D40B83AECCFB7AFD7FD9653E1037519AC61";

    public /* synthetic */ LieDetectorScript() {
        LieDetectorScript a2;
    }

    public static /* synthetic */ Pair<String, String> getImageBytes() {
        String string;
        Object object;
        String[] arrstring;
        Object object2;
        try {
            URL uRL = new URL(ALLATORIxDEMO);
            object2 = uRL.openStream();
            arrstring = new ByteArrayOutputStream();
            object = new byte[1024];
            int n2 = 0;
            while (-1 != (n2 = ((InputStream)object2).read((byte[])object))) {
                arrstring.write((byte[])object, 0, n2);
            }
        }
        catch (IOException iOException) {
            object2 = new File(GameSetConstants.getNpcFolder() + "/liedetector/");
            if (!((File)object2).exists()) {
                System.err.println(Event_PyramidSubway.ALLATORIxDEMO("6M?`?P?G.K(\u0004<K6@?Vz@5A)\u00044K.\u0004?\\3W.\u0005"));
                return null;
            }
            arrstring = ((File)object2).list();
            Object object3 = object = (Object)arrstring[Randomizer.nextInt(arrstring.length)];
            object = ((String)object3).substring(0, ((String)object3).length() - 4);
            try {
                return new Pair<String, Object>(HexTool.toString(LieDetectorScript.getBytesFromFile(new File(GameSetConstants.getNpcFolder() + "/liedetector/" + (String)object + ".jpg"))), object);
            }
            catch (IOException iOException2) {
                return null;
            }
        }
        String string2 = string = HexTool.toString(arrstring.toByteArray());
        return new Pair<String, String>(string2.substring(39, string2.length()), arrstring.toString().split(GetSelfDocName.ALLATORIxDEMO("J%Y0J,H"))[0]);
    }

    public static /* synthetic */ {
        a = GameSetConstants.getNpcFolder() + "/liedetector/";
    }

    public static /* synthetic */ byte[] getBytesFromFile(File a2) throws IOException {
        int n2;
        byte[] arrby;
        long l2;
        FileInputStream fileInputStream;
        block6: {
            fileInputStream = new FileInputStream(a2);
            l2 = a2.length();
            if (l2 <= Integer.MAX_VALUE) break block6;
            return null;
        }
        try {
            arrby = new byte[(int)l2];
            n2 = 0;
            int n3 = 0;
            int n4 = n2;
            while (n4 < arrby.length && (n3 = ((InputStream)fileInputStream).read(arrby, n2, arrby.length - n2)) >= 0) {
                n4 = n2 + n3;
            }
        }
        catch (IOException iOException) {
            return null;
        }
        if (n2 < arrby.length) {
            System.err.println("[Lie Detector Script] Could not completely read file " + a2.getName());
            return null;
        }
        return arrby;
    }
}

