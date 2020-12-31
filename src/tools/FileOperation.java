/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.messages.commands.player.eventSystem.MonsterPetSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import tools.database.CashShopConvert;

public class FileOperation {
    public /* synthetic */ void delFolder(String a22) {
        try {
            FileOperation a3;
            a3.delAllFile(a22);
            a22 = a22.toString();
            new File(a22).delete();
            return;
        }
        catch (Exception a22) {
            System.out.println(CashShopConvert.ALLATORIxDEMO("\u526f\u9609\u8c82\u65f4\u597b\u64a0\u4f19\u5197\u936a"));
            a22.printStackTrace();
            return;
        }
    }

    public static /* synthetic */ Boolean DeleteLocal(String a2) {
        Object object = new File("").getAbsolutePath() + File.separator + a2;
        if (((File)(object = new File((String)object))).exists()) {
            ((File)object).delete();
            return true;
        }
        return false;
    }

    public /* synthetic */ void delAllFile(String a2) {
        int n2;
        String[] arrstring = new File(a2);
        if (!arrstring.exists()) {
            return;
        }
        if (!arrstring.isDirectory()) {
            return;
        }
        arrstring = arrstring.list();
        File file = null;
        int n3 = n2 = 0;
        while (n3 < arrstring.length) {
            File file2;
            File file3;
            if (a2.endsWith(File.separator)) {
                file3 = new File(a2 + arrstring[n2]);
                file2 = file = file3;
            } else {
                file3 = new File(a2 + File.separator + arrstring[n2]);
                file2 = file = file3;
            }
            if (file2.isFile()) {
                file.delete();
            }
            if (file.isDirectory()) {
                FileOperation a3;
                a3.delAllFile(a2 + "/" + arrstring[n2]);
                a3.delFolder(a2 + "/" + arrstring[n2]);
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ Boolean checkExist(String a2) {
        if (new File(a2).exists()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void moveFolder(String a2, String a3) {
        FileOperation a4;
        FileOperation fileOperation = a4;
        fileOperation.copyFolder(a2, a3);
        fileOperation.delFolder(a2);
    }

    public /* synthetic */ FileOperation() {
        FileOperation a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 1 << 3 ^ 4;
        int cfr_ignored_0 = 1 << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = 1 << 3 ^ 5;
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

    public static /* synthetic */ void newFolder(String a2) {
        try {
            String string = a2;
            string = string.toString();
            File file = new File(string);
            if (!file.exists()) {
                file.mkdir();
                return;
            }
        }
        catch (Exception exception) {
            System.out.println(MonsterPetSystem.ALLATORIxDEMO("\u65e8\u5ea9\u76b6\u9357\u6495\u4f0f\u51a2\u937c"));
            exception.printStackTrace();
        }
    }

    public /* synthetic */ void delFile(String a22) {
        try {
            a22 = a22.toString();
            new File(a22).delete();
            return;
        }
        catch (Exception a22) {
            System.out.println(MonsterPetSystem.ALLATORIxDEMO("\u5279\u963c\u6ac7\u6495\u4f0f\u51a2\u937c"));
            a22.printStackTrace();
            return;
        }
    }

    public /* synthetic */ void newFile(String a22, String a3) {
        try {
            a22 = a22.toString();
            Object object = new File(a22);
            if (!((File)object).exists()) {
                ((File)object).createNewFile();
            }
            object = new FileWriter((File)object);
            PrintWriter printWriter = new PrintWriter((Writer)object);
            printWriter.println(a3);
            ((OutputStreamWriter)object).close();
            return;
        }
        catch (Exception a22) {
            System.out.println(CashShopConvert.ALLATORIxDEMO("\u65dd\u5ebf\u7683\u9341\u64a0\u4f19\u5197\u936a"));
            a22.printStackTrace();
            return;
        }
    }

    public static /* synthetic */ Boolean checkExistLocal(String a2) {
        String string = new File("").getAbsolutePath() + File.separator + a2;
        if (new File(string).exists()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void moveFile(String a2, String a3) {
        FileOperation a4;
        FileOperation fileOperation = a4;
        fileOperation.copyFile(a2, a3);
        fileOperation.delFile(a2);
    }

    public /* synthetic */ void copyFile(String a2, String a3) {
        block4: {
            int n2 = 0;
            int n3 = 0;
            if (!new File((String)a2).exists()) break block4;
            a2 = new FileInputStream((String)a2);
            a3 = new FileOutputStream((String)a3);
            byte[] arrby = new byte[1444];
            Object object = a2;
            while ((n3 = ((InputStream)object).read(arrby)) != -1) {
                System.out.println(n2 += n3);
                object = a2;
                ((FileOutputStream)a3).write(arrby, 0, n3);
            }
            try {
                ((InputStream)a2).close();
                return;
            }
            catch (Exception exception) {
                System.out.println(MonsterPetSystem.ALLATORIxDEMO("\u8954\u88a5\u55fd\u5053\u6ac7\u6495\u4f0f\u51a2\u937c"));
                exception.printStackTrace();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void copyFolder(String a2, String a3) {
        try {
            new File(a3).mkdirs();
            File file = new File(a2);
            String[] arrstring = file.list();
            File file2 = null;
            for (int i2 = 0; i2 < arrstring.length; ++i2) {
                FileOperation a4;
                if ((a2.endsWith(File.separator) ? new File(a2 + arrstring[i2]) : new File(a2 + File.separator + arrstring[i2])).isFile()) {
                    int n2;
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    FileOutputStream fileOutputStream = new FileOutputStream(a3 + "/" + file2.getName().toString());
                    byte[] arrby = new byte[5120];
                    FileInputStream fileInputStream2 = fileInputStream;
                    while ((n2 = fileInputStream2.read(arrby)) != -1) {
                        fileInputStream2 = fileInputStream;
                        fileOutputStream.write(arrby, 0, n2);
                    }
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    fileInputStream.close();
                }
                if (!file2.isDirectory()) continue;
                a4.copyFolder(a2 + "/" + arrstring[i2], a3 + "/" + arrstring[i2]);
            }
            return;
        }
        catch (Exception exception) {
            System.out.println(CashShopConvert.ALLATORIxDEMO("\u8942\u8890\u6531\u5066\u8c82\u65f4\u597b\u510a\u5bfc\u64a0\u4f19\u5197\u936a"));
            exception.printStackTrace();
        }
    }
}

