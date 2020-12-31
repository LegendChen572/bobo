/*
 * Decompiled with CFR 0.150.
 */
package tools.otp;

import handling.world.MapleParty;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class HmacOneTimePasswordGenerator {
    private final /* synthetic */ int d;
    private final /* synthetic */ String a;
    public static final /* synthetic */ int DEFAULT_PASSWORD_LENGTH = 6;
    public static final /* synthetic */ String HOTP_HMAC_ALGORITHM = "HmacSHA1";
    private final /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ HmacOneTimePasswordGenerator(int a2) throws NoSuchAlgorithmException {
        a3(a2, HOTP_HMAC_ALGORITHM);
        HmacOneTimePasswordGenerator a3;
    }

    public /* synthetic */ int generateOneTimePassword(SecretKey a22, long a32) throws InvalidKeyException {
        int n2;
        Object object;
        HmacOneTimePasswordGenerator a4;
        try {
            object = Mac.getInstance(a4.a);
            ((Mac)object).init((Key)a22);
        }
        catch (NoSuchAlgorithmException a22) {
            throw new RuntimeException(a22);
        }
        Object a22 = ByteBuffer.allocate(8);
        ((ByteBuffer)a22).putLong(0, a32);
        object = ((Mac)object).doFinal(((ByteBuffer)a22).array());
        Object object2 = object;
        int a32 = object2[((Object)object2).length - 1] & 0xF;
        int n3 = n2 = 0;
        while (n3 < 4) {
            int n4 = n2++;
            ((ByteBuffer)a22).put(n4, (byte)object[n4 + a32]);
            n3 = n2;
        }
        n2 = ((ByteBuffer)a22).getInt(0) & Integer.MAX_VALUE;
        return n2 % a4.ALLATORIxDEMO;
    }

    public /* synthetic */ HmacOneTimePasswordGenerator() throws NoSuchAlgorithmException {
        a2(6);
        HmacOneTimePasswordGenerator a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (2 ^ 5);
        int cfr_ignored_0 = 2 ^ 5;
        int n5 = n3;
        int n6 = 3 << 3 ^ 2;
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

    public /* synthetic */ int getPasswordLength() {
        HmacOneTimePasswordGenerator a2;
        return a2.d;
    }

    public /* synthetic */ HmacOneTimePasswordGenerator(int a2, String a3) throws NoSuchAlgorithmException {
        HmacOneTimePasswordGenerator a4;
        switch (a2) {
            case 6: {
                while (false) {
                }
                HmacOneTimePasswordGenerator hmacOneTimePasswordGenerator = a4;
                a4.ALLATORIxDEMO = 1000000;
                break;
            }
            case 7: {
                HmacOneTimePasswordGenerator hmacOneTimePasswordGenerator = a4;
                a4.ALLATORIxDEMO = 10000000;
                break;
            }
            case 8: {
                HmacOneTimePasswordGenerator hmacOneTimePasswordGenerator = a4;
                a4.ALLATORIxDEMO = 100000000;
                break;
            }
            default: {
                throw new IllegalArgumentException(MapleParty.ALLATORIxDEMO("I\u0011j\u0003n\u001fk\u00149\u001c|\u001e~\u0004qPt\u0005j\u00049\u0012|P{\u0015m\u0007|\u0015wP/Px\u001e}P!P}\u0019~\u0019m\u00037"));
            }
        }
        hmacOneTimePasswordGenerator.d = a2;
        Mac.getInstance(a3);
        a4.a = a3;
    }

    public /* synthetic */ String getAlgorithm() {
        HmacOneTimePasswordGenerator a2;
        return a2.a;
    }
}

