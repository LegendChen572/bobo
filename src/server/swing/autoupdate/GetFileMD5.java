/*
 * Decompiled with CFR 0.150.
 */
package server.swing.autoupdate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import server.ItemInformation;
import tools.database.UniqueIdReset;

public class GetFileMD5 {
    public static /* synthetic */ char[] hexDigits;
    public static /* synthetic */ MessageDigest messagedigest;

    public static /* synthetic */ String getFileMD5String(File a2) throws IOException {
        MappedByteBuffer mappedByteBuffer = new FileInputStream(a2).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, a2.length());
        messagedigest.update(mappedByteBuffer);
        return GetFileMD5.ALLATORIxDEMO(GetFileMD5.messagedigest.digest(), 0, GetFileMD5.messagedigest.digest().length);
    }

    public static /* synthetic */ String getFileMD5String(String a2) throws FileNotFoundException, IOException {
        Comparable<File> comparable = new File("");
        String string = comparable.getAbsolutePath() + File.separator + a2;
        comparable = new File(string);
        comparable = new FileInputStream((File)comparable).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, comparable.length());
        messagedigest.update((ByteBuffer)comparable);
        return GetFileMD5.ALLATORIxDEMO(GetFileMD5.messagedigest.digest(), 0, GetFileMD5.messagedigest.digest().length);
    }

    private static /* synthetic */ String ALLATORIxDEMO(byte[] a2, int a3, int a4) {
        StringBuffer stringBuffer = new StringBuffer(2 * a4);
        a4 = a3 + a4;
        int n2 = a3 = a3;
        while (n2 < a4) {
            GetFileMD5.ALLATORIxDEMO(a2[a3++], stringBuffer);
            n2 = a3;
        }
        return stringBuffer.toString();
    }

    public static /* synthetic */ {
        char[] arrc = new char[16];
        arrc[0] = 48;
        arrc[1] = 49;
        arrc[2] = 50;
        arrc[3] = 51;
        arrc[4] = 52;
        arrc[5] = 53;
        arrc[6] = 54;
        arrc[7] = 55;
        arrc[8] = 56;
        arrc[9] = 57;
        arrc[10] = 97;
        arrc[11] = 98;
        arrc[12] = 99;
        arrc[13] = 100;
        arrc[14] = 101;
        arrc[15] = 102;
        hexDigits = arrc;
        messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance(UniqueIdReset.ALLATORIxDEMO("*BR"));
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        }
    }

    public static /* synthetic */ String getMD5(String a2) throws FileNotFoundException, IOException {
        Comparable<File> comparable = new File("");
        comparable = new File(a2);
        comparable = new FileInputStream((File)comparable).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, comparable.length());
        messagedigest.update((ByteBuffer)comparable);
        return GetFileMD5.ALLATORIxDEMO(GetFileMD5.messagedigest.digest(), 0, GetFileMD5.messagedigest.digest().length);
    }

    public static /* synthetic */ void main(String[] a2) throws IOException {
        System.out.println(UniqueIdReset.ALLATORIxDEMO("m%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D\fD&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G%m%G&G&G&G&D%G%G&G%G&G&D%G%D%G%D%G%D&G%D%G&G&G&G&D\fD&G&G&G&D&D&D&G&D&G&D&D&G%G&D&D&D&D&G%G&G&G&G&G%m%G&G&G&G%D%G%G&G%G&G%D%G&D&G%G%G%D&G&D&G&G&G&G&D\fD&G&G&G&D&D&D%D&D%D&D&D&G%G&D%D&D&D&D%D&G&G&G&G%m%G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&D\fD&(d\u0001s\u0014e\u0006r\u000ei\t&\u0005\u007fGG\u000bj\u0006r\bt\u000e&(d\u0001s\u0014e\u0006r\btGpP(T&#C*IG%m%G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&D\fD&G&G&G&G&G&\u000fr\u0013v])Hq\u0010qIg\u000bj\u0006r\bt\u000e(\u0004i\n&G&G&G&G&G&G%m%G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&D\fD%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%m"));
        long l2 = System.currentTimeMillis();
        String string = GetFileMD5.getFileMD5String(new File(ItemInformation.ALLATORIxDEMO("\u001fyt\u0017\u001e\u0010\u000fl\u0012\u000e\u001c\u001ckskwu923")));
        long l3 = System.currentTimeMillis();
        System.out.println("md5:" + string + "\n time:" + (l3 - l2) / 1000L + "s");
    }

    public static /* synthetic */ long getFileLastModified(String a2) throws FileNotFoundException, IOException {
        File file = new File("");
        String string = file.getAbsolutePath() + File.separator + a2;
        file = new File(string);
        return file.lastModified();
    }

    public /* synthetic */ GetFileMD5() {
        GetFileMD5 a2;
    }

    public static /* synthetic */ boolean checkPassword(String a2, String a3) {
        return GetFileMD5.getMD5String(a2.getBytes()).equals(a3);
    }

    public static /* synthetic */ long getDocSize(String a2) {
        File file = new File("");
        String string = file.getAbsolutePath() + File.separator + a2;
        if ((file = new File(string)).exists() && file.isFile()) {
            return file.length();
        }
        return 0L;
    }

    private static /* synthetic */ void ALLATORIxDEMO(byte a2, StringBuffer a3) {
        char c2 = hexDigits[(a2 & 0xF0) >> 4];
        char c3 = hexDigits[a2 & 0xF];
        a3.append(c2);
        a3.append(c3);
    }

    public static /* synthetic */ String getMD5String(byte[] a2) {
        messagedigest.update(a2);
        return GetFileMD5.ALLATORIxDEMO(GetFileMD5.messagedigest.digest(), 0, GetFileMD5.messagedigest.digest().length);
    }
}

