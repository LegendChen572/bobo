/*
 * Decompiled with CFR 0.150.
 */
package tools.database;

import FuckingHackerToby.za;
import client.SummonSkillEntry;
import constants.GameSetConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import server.swing.Progressbar;
import tools.FileOperation;
import tools.FileoutputUtil;
import tools.googledrive.GoogleDrive;
import tools.packet.FamilyPacket;

public class MysqlBackup {
    private static /* synthetic */ String B;
    private static /* synthetic */ String k;
    private static /* synthetic */ String d;
    private static /* synthetic */ String ALLATORIxDEMO;
    private static /* synthetic */ int K;
    private static /* synthetic */ String a;

    public static /* synthetic */ void run() {
        String string;
        block7: {
            string = MysqlBackup.ALLATORIxDEMO();
            if (!FileOperation.checkExistLocal(GameSetConstants.BACKUP_FOLDER).booleanValue()) break block7;
            MysqlBackup.backupData(B, k, a, d, string);
        }
        try {
            FileOperation.newFolder(MysqlBackup.ALLATORIxDEMO());
            MysqlBackup.backupData(B, k, a, d, string);
        }
        catch (Exception exception) {
            System.out.println("MysqlBackup\u932f\u8aa4: " + exception);
        }
        File file = new File(string + "/" + ALLATORIxDEMO + ".sql");
        try {
            int n2;
            ZipOutputStream zipOutputStream;
            FileInputStream fileInputStream = new FileInputStream(file);
            ZipOutputStream zipOutputStream2 = zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(string + "/" + ALLATORIxDEMO + ".zip")));
            ZipOutputStream zipOutputStream3 = zipOutputStream;
            zipOutputStream2.putNextEntry(new ZipEntry(file.getName()));
            zipOutputStream2.setLevel(9);
            byte[] arrby = new byte[64];
            FileInputStream fileInputStream2 = fileInputStream;
            while ((n2 = fileInputStream2.read(arrby)) > 0) {
                fileInputStream2 = fileInputStream;
                zipOutputStream.write(arrby, 0, n2);
            }
            zipOutputStream.close();
            fileInputStream.close();
            za.l(string + "/" + ALLATORIxDEMO + ".sql");
            return;
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }

    public /* synthetic */ MysqlBackup() {
        MysqlBackup a2;
    }

    public static /* synthetic */ void uploadGoogleDrive() {
        if (GameSetConstants.BACKUP_GOOGLEDRIVE) {
            try {
                GoogleDrive.upload(ALLATORIxDEMO, FamilyPacket.ALLATORIxDEMO("o\u000bq\u0003n"));
                return;
            }
            catch (IOException iOException) {
                try {
                    Logger.getLogger(MysqlBackup.class.getName()).log(Level.SEVERE, null, iOException);
                    return;
                }
                catch (GeneralSecurityException generalSecurityException) {
                    Logger.getLogger(MysqlBackup.class.getName()).log(Level.SEVERE, null, generalSecurityException);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean backupData(String a2, String a3, String a42, String a5, String a6) {
        Long l2 = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        try {
            Object object;
            Object object2;
            ALLATORIxDEMO = FileoutputUtil.getChineseData();
            if (((String)a5).isEmpty()) {
                object2 = "";
                object = a3;
            } else {
                object2 = " -p" + (String)a5;
                object = a3;
            }
            a42 = GameSetConstants.MYSQLDUMP_PATH + " -h " + a2 + " -P " + K + " -u " + (String)a42 + (String)object2 + " " + (String)object + " --result-file " + (String)a6 + File.separator + ALLATORIxDEMO + ".sql";
            System.out.println("mysqldump running this command-->" + (String)a42);
            a3 = runtime.exec((String)a42);
            if (((Process)a3).waitFor() == 0) {
                a5 = System.currentTimeMillis();
                a6 = (Long)a5 - l2;
                System.out.println("\u6210\u529f\u5099\u4efd! \u5099\u4efd\u6642\u9593:" + FileoutputUtil.getChineseData() + " \u82b1" + (Long)a6 / 1000L + "\u79d2");
                return true;
            }
            System.out.println(SummonSkillEntry.ALLATORIxDEMO("{AdPn@x\u001d|RbGM\\y\u001b\"\u00126\u0003"));
            a5 = ((Process)a3).getErrorStream();
            if (a5 == null) return false;
            a6 = new BufferedReader(new InputStreamReader((InputStream)a5, FamilyPacket.ALLATORIxDEMO("W&D\u007f\u001a")));
            while ((a3 = ((BufferedReader)a6).readLine()) != null) {
                System.out.println("mysqldump\u9519\u8bef\u65e5\u5fd7>" + (String)a3);
            }
            return false;
        }
        catch (Exception a42) {
            System.out.println(SummonSkillEntry.ALLATORIxDEMO("^r@z_oFfC+QjP`F{\u0013mRb_nW"));
            a42.printStackTrace();
            return false;
        }
    }

    private static /* synthetic */ String ALLATORIxDEMO() {
        return new File("").getAbsolutePath() + File.separator + GameSetConstants.BACKUP_FOLDER;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean RecoverData(String a2, String a3, String a42, String a5, String a6, String a7) {
        a6 = System.currentTimeMillis();
        Progressbar.setTitle(SummonSkillEntry.ALLATORIxDEMO("\u654b\u64d1\u5e98\u908f\u53ac\u5092\u4ece"), 1);
        try {
            String string;
            Object object;
            Progressbar.setText(FamilyPacket.ALLATORIxDEMO("\u6b41\u577a\u90a6\u53cd\f|\f"));
            Progressbar.visible(true);
            String string2 = GameSetConstants.MYSQLDUMP_PATH.replace(SummonSkillEntry.ALLATORIxDEMO("^r@z_oFfC"), FamilyPacket.ALLATORIxDEMO("O+Q#N"));
            if (((String)a5).isEmpty()) {
                object = "";
                string = a3;
            } else {
                object = " -p" + (String)a5;
                string = a3;
            }
            a42 = string2 + " -h " + a2 + " -P " + K + " -u " + (String)a42 + (String)object + " --default-character-set=utf8 " + string;
            System.out.println("mysql recovery running this command-->" + (String)a42);
            a5 = Runtime.getRuntime().exec((String)a42).getOutputStream();
            a7 = new FileInputStream((String)a7);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)a7, SummonSkillEntry.ALLATORIxDEMO("~Gm\u000b")));
            int n2 = ((FileInputStream)a7).available();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)a5, FamilyPacket.ALLATORIxDEMO("'V4\u001a"));
            BufferedReader bufferedReader2 = bufferedReader;
            while ((a6 = bufferedReader2.readLine()) != null) {
                outputStreamWriter.write((String)a6 + "\r\n");
                Progressbar.setValue((int)(100.0 - (double)((FileInputStream)a7).available() / (double)n2 * 100.0));
                bufferedReader2 = bufferedReader;
            }
            Progressbar.setText("\u6b63\u5728\u9084\u539f\u5099\u4efd\u5230: " + a3 + "...");
            OutputStreamWriter outputStreamWriter2 = outputStreamWriter;
            outputStreamWriter2.flush();
            ((OutputStream)a5).close();
            bufferedReader.close();
            outputStreamWriter2.close();
            Progressbar.setText(SummonSkillEntry.ALLATORIxDEMO("\u50aa\u4ef6\u6051\u5fa2\u5bbf\u621b\u001d%\u001d"));
            Thread.sleep(1000L);
            Progressbar.visible(false);
            return false;
        }
        catch (Exception a42) {
            Progressbar.visible(false);
            System.out.println(FamilyPacket.ALLATORIxDEMO("?[!S>\u0002 G1M$G \u00024C;N7F"));
            a42.printStackTrace();
            return false;
        }
    }

    public static /* synthetic */ {
        B = GameSetConstants.dbIp;
        k = GameSetConstants.dbName;
        K = GameSetConstants.dbport;
        a = GameSetConstants.dbUser;
        d = GameSetConstants.dbPass;
        ALLATORIxDEMO = "";
    }

    public static /* synthetic */ void RecoverData(String a2) {
        String string = MysqlBackup.ALLATORIxDEMO();
        MysqlBackup.RecoverData(B, k, a, d, string, a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean backupData_New(String a2, String a32, String a4, String a5, String a6) {
        Object object = System.currentTimeMillis();
        object = Runtime.getRuntime();
        try {
            BufferedReader bufferedReader;
            Object object2;
            Object object3;
            if (((String)a5).isEmpty()) {
                object3 = "";
                object2 = a32;
            } else {
                object3 = " -p" + (String)a5;
                object2 = a32;
            }
            a32 = GameSetConstants.MYSQLDUMP_PATH + " -h " + a2 + " -P " + K + " -u " + (String)a4 + (String)object3 + " " + (String)object2;
            System.out.println("mysqldump running this command-->" + (String)a32);
            a4 = ((Runtime)object).exec((String)a32).getInputStream();
            a5 = new InputStreamReader((InputStream)a4, FamilyPacket.ALLATORIxDEMO("W&D\u007f\u001a"));
            Appendable appendable = new StringBuffer("");
            BufferedReader bufferedReader2 = bufferedReader = new BufferedReader((Reader)a5);
            while ((object = bufferedReader2.readLine()) != null) {
                ((StringBuffer)appendable).append((String)object + "\r\n");
                bufferedReader2 = bufferedReader;
            }
            object = ((StringBuffer)appendable).toString();
            a6 = new FileOutputStream((String)a6 + File.separator + FileoutputUtil.getChineseData() + ".sql");
            Appendable appendable2 = appendable = new OutputStreamWriter((OutputStream)a6, SummonSkillEntry.ALLATORIxDEMO("F\u007fU&\u000b"));
            ((Writer)appendable2).write((String)object);
            ((OutputStreamWriter)appendable2).flush();
            ((InputStream)a4).close();
            ((InputStreamReader)a5).close();
            bufferedReader.close();
            ((OutputStreamWriter)appendable).close();
            ((FileOutputStream)a6).close();
            System.out.println("");
            return false;
        }
        catch (Exception a32) {
            System.out.println(FamilyPacket.ALLATORIxDEMO("O+Q#N6W?Rr@3A9W\"\u00024C;N7F"));
            a32.printStackTrace();
            return false;
        }
    }
}

