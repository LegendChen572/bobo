/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.messages.CommandExecute;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import server.maps.MapNameData;

public class LoginCryptoLegacy {
    private static final /* synthetic */ Random d;
    private static final /* synthetic */ char[] ALLATORIxDEMO;

    public static final /* synthetic */ String encodeSHA1(String a2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance(CommandExecute.ALLATORIxDEMO("\u00069\u0014\\d"));
        messageDigest.update(a2.getBytes(MapNameData.ALLATORIxDEMO("y6\u007fh(}%|=t")), 0, a2.length());
        return LoginCryptoLegacy.H(messageDigest.digest());
    }

    private static /* synthetic */ String ALLATORIxDEMO(String a2, String a3) throws RuntimeException {
        Object object;
        Object object2;
        Object object3 = null;
        int n2 = 8;
        if (!a3.substring(0, 3).equals(CommandExecute.ALLATORIxDEMO("q9q"))) {
            object2 = new byte[6];
            d.nextBytes((byte[])object2);
            a3 = LoginCryptoLegacy.l(object2);
        }
        String string = a3.substring(4, 12);
        object2 = string;
        if (string.length() != 8) {
            throw new RuntimeException(MapNameData.ALLATORIxDEMO("U7b*bex$c-y+we`$c6g*b!0h0\f~3q)y!06u tk"));
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(CommandExecute.ALLATORIxDEMO("\u00069\u0014\\d"));
            messageDigest.update(((String)object2 + a2).getBytes(MapNameData.ALLATORIxDEMO("y6\u007fh(}%|=t")), 0, ((String)object2 + a2).length());
            object2 = messageDigest.digest();
            do {
                byte[] arrby = new byte[((byte[])object2).length + a2.length()];
                System.arraycopy(object2, 0, arrby, 0, ((byte[])object2).length);
                System.arraycopy(a2.getBytes(CommandExecute.ALLATORIxDEMO("\u0018&\u001exImDl\\d")), 0, arrby, ((byte[])object2).length, a2.getBytes(MapNameData.ALLATORIxDEMO("y6\u007fh(}%|=t")).length);
                messageDigest.update(arrby, 0, arrby.length);
                object2 = messageDigest.digest();
            } while (--n2 > 0);
            object3 = a3.substring(0, 12);
            object = object3 = (String)object3 + LoginCryptoLegacy.ALLATORIxDEMO(object2);
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException exception) {
            System.err.println("Error hashing password." + exception);
            object = object3;
        }
        if (object == null) {
            throw new RuntimeException(CommandExecute.ALLATORIxDEMO("\u0010\u0003'\u001e'Q=\u0010&\u0019<\u001f2Q%\u0010&\u0002\"\u001e'\u0015u\\u\u001e \u0005uLu\u001f \u001d9"));
        }
        return object3;
    }

    private static /* synthetic */ String ALLATORIxDEMO(byte[] a2) {
        int n2 = a2.length;
        int n3 = (n2 * 4 + 2) / 3;
        char[] arrc = new char[(n2 + 2) / 3 * 4];
        int n4 = 0;
        int n5 = 0;
        int n6 = n4;
        while (n6 < n2) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11 = n10 = a2[n4] & 0xFF;
            if (++n4 < n2) {
                n9 = a2[n4] & 0xFF;
                ++n4;
            } else {
                n9 = n8 = 0;
            }
            if (n4 < n2) {
                n7 = a2[n4] & 0xFF;
                ++n4;
            } else {
                n7 = 0;
            }
            int n12 = n7;
            int n13 = n10 >>> 2;
            n10 = (n10 & 3) << 4 | n8 >>> 4;
            n8 = (n8 & 0xF) << 2 | n12 >>> 6;
            char[] arrc2 = arrc;
            arrc2[n5++] = ALLATORIxDEMO[n13];
            arrc[n5++] = ALLATORIxDEMO[n10];
            int n14 = n5;
            arrc2[n14] = n14 < n3 ? ALLATORIxDEMO[n8] : 61;
            int n15 = ++n5;
            arrc[n15] = n15 < n3 ? ALLATORIxDEMO[n12 &= 0x3F] : 61;
            n6 = n4;
            ++n5;
        }
        return new String(arrc);
    }

    public static final /* synthetic */ boolean isLegacyPassword(String a2) {
        return a2.substring(0, 3).equals(MapNameData.ALLATORIxDEMO("aXa"));
    }

    private static /* synthetic */ String l(byte[] a2) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder(MapNameData.ALLATORIxDEMO("aXa"));
        stringBuilder.append(ALLATORIxDEMO[30]);
        stringBuilder2.append(LoginCryptoLegacy.ALLATORIxDEMO(a2));
        return stringBuilder2.toString();
    }

    public static /* synthetic */ {
        int n2;
        d = new Random();
        ALLATORIxDEMO = new char[64];
        int n3 = 0;
        LoginCryptoLegacy.ALLATORIxDEMO[n3++] = 46;
        LoginCryptoLegacy.ALLATORIxDEMO[n3++] = 47;
        int n4 = n2 = 65;
        while (n4 <= 90) {
            LoginCryptoLegacy.ALLATORIxDEMO[n3++] = n2;
            n4 = n2 = (int)((char)(n2 + 1));
        }
        int n5 = n2 = 97;
        while (n5 <= 122) {
            LoginCryptoLegacy.ALLATORIxDEMO[n3++] = n2;
            n5 = n2 = (int)((char)(n2 + 1));
        }
        int n6 = n2 = 48;
        while (n6 <= 57) {
            LoginCryptoLegacy.ALLATORIxDEMO[n3++] = n2;
            n6 = n2 = (int)((char)(n2 + 1));
        }
    }

    public static final /* synthetic */ String hashPassword(String a2) {
        byte[] arrby = new byte[6];
        d.setSeed(System.currentTimeMillis());
        d.nextBytes(arrby);
        return LoginCryptoLegacy.ALLATORIxDEMO(a2, LoginCryptoLegacy.l(arrby));
    }

    public /* synthetic */ LoginCryptoLegacy() {
        LoginCryptoLegacy a2;
    }

    public static final /* synthetic */ boolean checkPassword(String a2, String a3) {
        return LoginCryptoLegacy.ALLATORIxDEMO(a2, a3).equals(a3);
    }

    private static /* synthetic */ String H(byte[] a2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            int n4 = a2[n2] >>> 4 & 0xF;
            int n5 = 0;
            do {
                byte[] arrby;
                if (0 <= n4 && n4 <= 9) {
                    arrby = a2;
                    stringBuilder.append((char)(48 + n4));
                } else {
                    stringBuilder.append((char)(97 + (n4 - 10)));
                    arrby = a2;
                }
                n4 = arrby[n2] & 0xF;
            } while (n5++ < 1);
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }
}

