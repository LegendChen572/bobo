/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleFriendship;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import tools.FileOperation;
import tools.HexTool;

public class LoginCrypto {
    private static final /* synthetic */ String[] a;
    private static final /* synthetic */ Random ALLATORIxDEMO;
    public static final /* synthetic */ int extralength = 6;
    private static final /* synthetic */ String[] d;

    public static /* synthetic */ boolean checkSha1Hash(String a2, String a3) {
        return a2.equals(LoginCrypto.hexSha1(a3));
    }

    private static /* synthetic */ String ALLATORIxDEMO(byte[] a2) {
        return HexTool.toString(a2).replace(" ", "").toLowerCase();
    }

    private static /* synthetic */ String ALLATORIxDEMO(String a2, String a32) {
        try {
            a32 = MessageDigest.getInstance((String)a32);
            ((MessageDigest)a32).update(a2.getBytes(MapleFriendship.ALLATORIxDEMO("M\u007f^\u0006 ")), 0, a2.length());
            return LoginCrypto.ALLATORIxDEMO(((MessageDigest)a32).digest());
        }
        catch (NoSuchAlgorithmException a32) {
            throw new RuntimeException(FileOperation.ALLATORIxDEMO("Em~ddbj,ydh,}m~\u007fzc\u007fh-jleaii"), a32);
        }
        catch (UnsupportedEncodingException a32) {
            throw new RuntimeException(MapleFriendship.ALLATORIxDEMO("nvHwOqE\u007f\u000blC}\u000bk_jBvL8MyBtN|"), a32);
        }
    }

    public static /* synthetic */ {
        String[] arrstring = new String[26];
        arrstring[0] = FileOperation.ALLATORIxDEMO("L");
        arrstring[1] = MapleFriendship.ALLATORIxDEMO("Z");
        arrstring[2] = FileOperation.ALLATORIxDEMO("N");
        arrstring[3] = MapleFriendship.ALLATORIxDEMO("\\");
        arrstring[4] = FileOperation.ALLATORIxDEMO("H");
        arrstring[5] = MapleFriendship.ALLATORIxDEMO("^");
        arrstring[6] = FileOperation.ALLATORIxDEMO("J");
        arrstring[7] = MapleFriendship.ALLATORIxDEMO("P");
        arrstring[8] = FileOperation.ALLATORIxDEMO("D");
        arrstring[9] = MapleFriendship.ALLATORIxDEMO("R");
        arrstring[10] = FileOperation.ALLATORIxDEMO("F");
        arrstring[11] = MapleFriendship.ALLATORIxDEMO("T");
        arrstring[12] = FileOperation.ALLATORIxDEMO("@");
        arrstring[13] = MapleFriendship.ALLATORIxDEMO("V");
        arrstring[14] = FileOperation.ALLATORIxDEMO("B");
        arrstring[15] = MapleFriendship.ALLATORIxDEMO("H");
        arrstring[16] = FileOperation.ALLATORIxDEMO("\\");
        arrstring[17] = MapleFriendship.ALLATORIxDEMO("J");
        arrstring[18] = FileOperation.ALLATORIxDEMO("^");
        arrstring[19] = MapleFriendship.ALLATORIxDEMO("L");
        arrstring[20] = FileOperation.ALLATORIxDEMO("X");
        arrstring[21] = MapleFriendship.ALLATORIxDEMO("N");
        arrstring[22] = FileOperation.ALLATORIxDEMO("Z");
        arrstring[23] = MapleFriendship.ALLATORIxDEMO("@");
        arrstring[24] = FileOperation.ALLATORIxDEMO("T");
        arrstring[25] = MapleFriendship.ALLATORIxDEMO("B");
        a = arrstring;
        String[] arrstring2 = new String[9];
        arrstring2[0] = "1";
        arrstring2[1] = "2";
        arrstring2[2] = "3";
        arrstring2[3] = "4";
        arrstring2[4] = FileOperation.ALLATORIxDEMO("8");
        arrstring2[5] = MapleFriendship.ALLATORIxDEMO(".");
        arrstring2[6] = FileOperation.ALLATORIxDEMO(":");
        arrstring2[7] = MapleFriendship.ALLATORIxDEMO(" ");
        arrstring2[8] = FileOperation.ALLATORIxDEMO("4");
        d = arrstring2;
        ALLATORIxDEMO = new Random();
    }

    public static /* synthetic */ String makeSalt() {
        byte[] arrby = new byte[16];
        ALLATORIxDEMO.nextBytes(arrby);
        return LoginCrypto.ALLATORIxDEMO(arrby);
    }

    public static /* synthetic */ String Generate_13DigitAsiasoftPassport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a[ALLATORIxDEMO.nextInt(a.length)]);
        int n2 = 0;
        int n3 = n2;
        while (n3 < 11) {
            stringBuilder.append(d[ALLATORIxDEMO.nextInt(d.length)]);
            n3 = ++n2;
        }
        stringBuilder.append(a[ALLATORIxDEMO.nextInt(a.length)]);
        return stringBuilder.toString();
    }

    public static /* synthetic */ String rand_r(String a2) {
        return a2.substring(6, 134);
    }

    public static /* synthetic */ boolean checkSaltedSha512Hash(String a2, String a3, String a4) {
        return a2.equals(LoginCrypto.ALLATORIxDEMO(a3 + a4));
    }

    public /* synthetic */ LoginCrypto() {
        LoginCrypto a2;
    }

    public static /* synthetic */ String rand_s(String a2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = n2 = 0;
        while (n3 < 6) {
            stringBuilder.append(ALLATORIxDEMO.nextBoolean() ? a[ALLATORIxDEMO.nextInt(a.length)] : d[ALLATORIxDEMO.nextInt(d.length)]);
            n3 = ++n2;
        }
        return stringBuilder.toString() + a2;
    }
}

