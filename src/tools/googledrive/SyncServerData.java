/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 */
package tools.googledrive;

import client.messages.commands.player.\u61a8\u61a8\u8c37;
import constants.GameSetConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import server.MapleSquad;
import tools.googledrive.GoogleDrive;

public class SyncServerData {
    public /* synthetic */ SyncServerData() {
        SyncServerData a2;
    }

    public static /* synthetic */ void ZipData(String a2, String a32) throws FileNotFoundException, IOException, GeneralSecurityException {
        String string;
        Object object = new File("").getAbsolutePath();
        String string2 = (String)object + File.separator + a2;
        a32 = (String)object + File.separator + "backup" + File.separator + (String)a32;
        object = new SyncServerData();
        try {
            ((SyncServerData)object).zip(string2, (String)a32);
            string = a2;
        }
        catch (Exception a32) {
            string = a2;
            a32.printStackTrace();
        }
        GoogleDrive.upload(string, \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u00079\n6\u000b(\n\"\u001c9"));
    }

    public static /* synthetic */ void ZipScriptsFiles() {
        try {
            SyncServerData.ZipData(GameSetConstants.getNpcFolder(), GameSetConstants.getNpcFolder() + ".zip");
            return;
        }
        catch (IOException iOException) {
            Logger.getLogger(SyncServerData.class.getName()).log(Level.SEVERE, null, iOException);
            return;
        }
        catch (GeneralSecurityException generalSecurityException) {
            Logger.getLogger(SyncServerData.class.getName()).log(Level.SEVERE, null, generalSecurityException);
            return;
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2, File a3) throws Exception {
        SyncServerData a4;
        System.out.println(MapleSquad.ALLATORIxDEMO("\u6a98\u685d\u58df\u7e3b\u4e21;\""));
        Object object = a2 = new ZipOutputStream(new FileOutputStream((String)a2));
        a4.ALLATORIxDEMO((ZipOutputStream)object, a3, "");
        System.out.println(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u6add\u6821\u589a\u7e47\u5bc5\u750b"));
        ((ZipOutputStream)object).close();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ 5;
        int cfr_ignored_0 = 5 << 4 ^ 3 << 1;
        int n5 = n3;
        int n6 = 1 << 3 ^ 2;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ void zip(String a2, String a3) throws Exception {
        SyncServerData a4;
        System.out.println(a3);
        a4.ALLATORIxDEMO(a3, new File(a2));
    }

    private /* synthetic */ void ALLATORIxDEMO(ZipOutputStream a2, File a3, String a4) throws Exception {
        if (a3.isDirectory()) {
            int n2;
            File[] arrfile = a3.listFiles();
            a2.putNextEntry(new ZipEntry((String)a4 + "/"));
            a4 = ((String)a4).length() == 0 ? "" : (String)a4 + "/";
            int n3 = n2 = 0;
            while (n3 < arrfile.length) {
                SyncServerData a5;
                File file = arrfile[n2];
                File file2 = arrfile[n2];
                a5.ALLATORIxDEMO(a2, file, (String)a4 + file2.getName());
                n3 = ++n2;
            }
        } else {
            int n4;
            FileInputStream fileInputStream;
            a2.putNextEntry(new ZipEntry((String)a4));
            FileInputStream fileInputStream2 = fileInputStream = new FileInputStream(a3);
            while ((n4 = fileInputStream2.read()) != -1) {
                fileInputStream2 = fileInputStream;
                a2.write(n4);
            }
            fileInputStream.close();
        }
    }
}

