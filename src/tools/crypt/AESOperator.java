/*
 * Decompiled with CFR 0.150.
 */
package tools.crypt;

import client.MapleLieDetector;
import constants.GameSetConstants;
import java.security.Key;
import java.util.Base64;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import tools.use.donate;

public class AESOperator {
    private /* synthetic */ String a;
    private /* synthetic */ String d;
    private static /* synthetic */ AESOperator ALLATORIxDEMO;

    public /* synthetic */ String encrypt(String a2) {
        StringBuilder stringBuilder;
        if (((String)a2).contains(donate.ALLATORIxDEMO("\u001d\u5d81\u52e6\u5bb5\u001b"))) {
            return a2;
        }
        String string = "";
        StringBuilder stringBuilder2 = new StringBuilder();
        try {
            AESOperator a3;
            Cipher cipher = Cipher.getInstance(MapleLieDetector.ALLATORIxDEMO("~xl\u0012|\u007f|\u0012ov|n\nm^Y[TQZ"));
            Object object = a3.a.getBytes();
            object = new SecretKeySpec((byte[])object, donate.ALLATORIxDEMO("\u00076\u0015"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a3.d.getBytes());
            Cipher cipher2 = cipher;
            cipher2.init(1, (Key)object, ivParameterSpec);
            a2 = cipher2.doFinal(((String)a2).getBytes(MapleLieDetector.ALLATORIxDEMO("HK[\u0012\u0005")));
            string = Base64.getEncoder().encodeToString((byte[])a2);
            StringBuilder stringBuilder3 = stringBuilder2;
            stringBuilder3.append(donate.ALLATORIxDEMO("\u001d\u5d81\u52e6\u5bb5\u001b"));
            stringBuilder3.append(string);
            stringBuilder = stringBuilder2;
        }
        catch (Exception exception) {
            stringBuilder = stringBuilder2;
            exception.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = null;
    }

    public static /* synthetic */ AESOperator getInstance() {
        if (ALLATORIxDEMO == null) {
            ALLATORIxDEMO = new AESOperator();
        }
        return ALLATORIxDEMO;
    }

    public /* synthetic */ String encodeBytes(byte[] a2) {
        int n2;
        StringBuffer stringBuffer = new StringBuffer();
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            stringBuffer.append((char)((a2[n2] >> 4 & 0xF) + 97));
            int n4 = a2[n2] & 0xF;
            stringBuffer.append((char)(n4 + 97));
            n3 = ++n2;
        }
        return stringBuffer.toString();
    }

    private /* synthetic */ AESOperator() {
        AESOperator a2;
        AESOperator aESOperator = a2;
        aESOperator.a = "abcdef0f23456789";
        aESOperator.d = "d4w5w115r7g4e3fd";
    }

    public static /* synthetic */ void main(String[] a2) throws Exception {
        System.out.println(MapleLieDetector.ALLATORIxDEMO("7\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e5\u001e\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001c7\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e\u001c\u001d\u001c\u001d\u001f\u001d\u001c\u001d\u001f\u001d\u001f\u001e\u001c\u001d\u001c\u001e\u001c\u001d\u001c\u001e\u001c\u001d\u001c\u001e\u001f\u001d\u001c\u001e\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e5\u001e\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001d\u001f\u001e\u001f\u001d\u001f\u001e\u001f\u001e\u001f\u001d\u001c\u001d\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001f\u001d\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001c7\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001c\u001e\u001c\u001d\u001c\u001d\u001f\u001d\u001c\u001d\u001f\u001d\u001c\u001e\u001c\u001d\u001f\u001e\u001f\u001d\u001c\u001d\u001c\u001d\u001c\u001e\u001f\u001d\u001f\u001e\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e5\u001e\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e\u001f\u001e\u001f\u001e\u001c\u001e\u001f\u001e\u001c\u001e\u001f\u001e\u001f\u001e\u001f\u001d\u001c\u001d\u001f\u001e\u001c\u001e\u001f\u001e\u001f\u001e\u001f\u001e\u001c\u001e\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001c7\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e5\u001e\u001fr][JN\\\\KTPS\u001f_F\u001d~QS\\KRMT\u001fr][JN\\\\KRM\u001dI\n\u0011\u000e\u001fyzpp\u001d\u001c7\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e5\u001e\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001fUKIO\u0007\u0010\u0012HJH\u0013^QS\\KRMT\u0011^PP\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001c7\u001c\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001d\u001f\u001e5\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c\u001e\u001c7"));
        byte[] arrby = new byte[16];
        arrby[0] = 24;
        arrby[1] = -56;
        arrby[2] = 10;
        arrby[3] = 116;
        arrby[4] = 80;
        arrby[5] = -59;
        arrby[6] = 126;
        arrby[7] = 27;
        arrby[8] = -27;
        arrby[9] = 31;
        arrby[10] = 36;
        arrby[11] = 99;
        arrby[12] = 18;
        arrby[13] = 18;
        arrby[14] = -97;
        arrby[15] = -110;
        byte[] arrby2 = arrby;
        byte[] arrby3 = new byte[16];
        arrby3[0] = 76;
        arrby3[1] = -64;
        arrby3[2] = -124;
        arrby3[3] = -55;
        arrby3[4] = 121;
        arrby3[5] = 54;
        arrby3[6] = -67;
        arrby3[7] = 13;
        arrby3[8] = 53;
        arrby3[9] = -82;
        arrby3[10] = -58;
        arrby3[11] = 36;
        arrby3[12] = -85;
        arrby3[13] = 21;
        arrby3[14] = -117;
        arrby3[15] = -108;
        arrby2 = arrby3;
        byte[] arrby4 = new byte[16];
        arrby4[0] = 96;
        arrby4[1] = -30;
        arrby4[2] = 33;
        arrby4[3] = 17;
        arrby4[4] = 42;
        arrby4[5] = -40;
        arrby4[6] = 73;
        arrby4[7] = 64;
        arrby4[8] = 91;
        arrby4[9] = -19;
        arrby4[10] = -114;
        arrby4[11] = -119;
        arrby4[12] = 100;
        arrby4[13] = -64;
        arrby4[14] = -66;
        arrby4[15] = -3;
        arrby2 = arrby4;
        AESOperator.getInstance().DecryptPacket(arrby2);
    }

    public /* synthetic */ byte[] DecryptPacket(byte[] a2) {
        byte[] arrby = null;
        try {
            byte[] arrby2 = GameSetConstants.SPECIAL_CRYPT_AES.getBytes(donate.ALLATORIxDEMO("\u0013'\u0000^~"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby2, MapleLieDetector.ALLATORIxDEMO("|zn"));
            Cipher cipher = Cipher.getInstance(donate.ALLATORIxDEMO("\u00076\u0015\\\u00051\u0005\\\b\u001c\u0016\u0012\"\u0017/\u001d!"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(GameSetConstants.SPECIAL_CRYPT_IV.getBytes(MapleLieDetector.ALLATORIxDEMO("hk{\u0012\u0005")));
            Cipher cipher2 = cipher;
            cipher2.init(2, (Key)secretKeySpec, ivParameterSpec);
            arrby = cipher2.doFinal((byte[])a2);
            a2 = new String(arrby, donate.ALLATORIxDEMO("\u0013'\u0000^~"));
            return arrby;
        }
        catch (Exception exception) {
            System.out.println(exception);
            return arrby;
        }
    }

    public /* synthetic */ String decrypt(String a2) {
        if (!((String)a2).contains(donate.ALLATORIxDEMO("\u001d\u5d81\u52e6\u5bb5\u001b"))) {
            return a2;
        }
        try {
            AESOperator a3;
            a2 = ((String)a2).replace(MapleLieDetector.ALLATORIxDEMO("f\u5dcd\u529d\u5bf9`"), "");
            byte[] arrby = a3.a.getBytes(donate.ALLATORIxDEMO("\u0007 \u0005:\u000f"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby, MapleLieDetector.ALLATORIxDEMO("|zn"));
            Cipher cipher = Cipher.getInstance(donate.ALLATORIxDEMO("2\u0003 i0\u00040i#\r0\u0015F\u0016\u0012\"\u0017/\u001d!"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a3.d.getBytes());
            Cipher cipher2 = cipher;
            cipher2.init(2, (Key)secretKeySpec, ivParameterSpec);
            a2 = cipher2.doFinal(Base64.getMimeDecoder().decode((String)a2));
            a2 = new String((byte[])a2, MapleLieDetector.ALLATORIxDEMO("HK[\u0012\u0005"));
            return a2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public /* synthetic */ byte[] EncryptPacket(byte[] a2) throws Exception {
        int n2;
        Object object = GameSetConstants.SPECIAL_CRYPT_AES.getBytes();
        object = new SecretKeySpec((byte[])object, MapleLieDetector.ALLATORIxDEMO("|zn"));
        Cipher cipher = Cipher.getInstance(donate.ALLATORIxDEMO("2\u0003 i0\u00040i#\r0\u0015F\u0016\u0012\"\u0017/\u001d!"));
        IvParameterSpec ivParameterSpec = new IvParameterSpec(GameSetConstants.SPECIAL_CRYPT_IV.getBytes());
        cipher.init(1, (Key)object, ivParameterSpec);
        System.out.println("AES_DEFAULT IV:" + cipher.getIV());
        System.out.println("AES_DEFAULT Algoritm:" + cipher.getAlgorithm());
        a2 = cipher.doFinal(a2);
        System.out.println("");
        System.out.print(MapleLieDetector.ALLATORIxDEMO("\u529d\u5bf9\u0007"));
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            Object[] arrobject = new Object[1];
            Byte by = a2[n2];
            arrobject[0] = by;
            System.out.print(String.format(donate.ALLATORIxDEMO("cCt+f"), arrobject));
            n3 = ++n2;
        }
        return a2;
    }

    public /* synthetic */ String decryptServer(String a2) {
        try {
            byte[] arrby = MapleLieDetector.ALLATORIxDEMO("\u000e[\u000eDQ\u007f\n~j~k\u0004Fwf|LH}\\GJQqRr\tu\u000bEnR").getBytes(donate.ALLATORIxDEMO("\u0013'\u0000^~"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(arrby, MapleLieDetector.ALLATORIxDEMO("|zn"));
            Cipher cipher = Cipher.getInstance(donate.ALLATORIxDEMO("2\u0003 i0\u00040i#\r0\u0015F\u0016\u0012\"\u0017/\u001d!"));
            IvParameterSpec ivParameterSpec = new IvParameterSpec(MapleLieDetector.ALLATORIxDEMO("WM\r\nukjKMuT\u000bvQlO").getBytes(donate.ALLATORIxDEMO("\u0013'\u0000^~")));
            Cipher cipher2 = cipher;
            cipher2.init(2, (Key)secretKeySpec, ivParameterSpec);
            a2 = cipher2.doFinal(Base64.getMimeDecoder().decode((String)a2));
            a2 = new String((byte[])a2, MapleLieDetector.ALLATORIxDEMO("hk{\u0012\u0005"));
            return a2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(String a2) {
        return Pattern.matches(donate.ALLATORIxDEMO("-n(\u0007^\u001c\u0012k\tv^\u007fXi.=G;Zl[\u001d2k)'^<CkJm\\\u001b\br\u000e:(\u0007^\u001c\u0012k\tv^\u007fXi.=@;N:(\u0007^\u001c\u0012k\tv^\u007fXi.=A;N{Zb"), a2);
    }
}

