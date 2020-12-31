/*
 * Decompiled with CFR 0.150.
 */
package tools.otp;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.SecretKey;
import tools.otp.HmacOneTimePasswordGenerator;

public class TimeBasedOneTimePasswordGenerator
extends HmacOneTimePasswordGenerator {
    private final /* synthetic */ long ALLATORIxDEMO;
    public static final /* synthetic */ String TOTP_ALGORITHM_HMAC_SHA256 = "HmacSHA256";
    public static final /* synthetic */ String TOTP_ALGORITHM_HMAC_SHA512 = "HmacSHA512";
    public static final /* synthetic */ String TOTP_ALGORITHM_HMAC_SHA1 = "HmacSHA1";

    public /* synthetic */ long getTimeStep(TimeUnit a2) {
        TimeBasedOneTimePasswordGenerator a3;
        return a2.convert(a3.ALLATORIxDEMO, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ TimeBasedOneTimePasswordGenerator(long a2, TimeUnit a3, int a4, String a5) throws NoSuchAlgorithmException {
        super(a4, a5);
        TimeBasedOneTimePasswordGenerator a6;
        a6.ALLATORIxDEMO = a3.toMillis(a2);
    }

    public /* synthetic */ TimeBasedOneTimePasswordGenerator(long a2, TimeUnit a3, int a4) throws NoSuchAlgorithmException {
        a5(a2, a3, a4, TOTP_ALGORITHM_HMAC_SHA1);
        TimeBasedOneTimePasswordGenerator a5;
    }

    public /* synthetic */ int generateOneTimePassword(SecretKey a2, Date a3) throws InvalidKeyException {
        TimeBasedOneTimePasswordGenerator a4;
        return a4.generateOneTimePassword(a2, a3.getTime() / a4.ALLATORIxDEMO);
    }

    public /* synthetic */ TimeBasedOneTimePasswordGenerator() throws NoSuchAlgorithmException {
        a2(30L, TimeUnit.SECONDS);
        TimeBasedOneTimePasswordGenerator a2;
    }

    public /* synthetic */ TimeBasedOneTimePasswordGenerator(long a2, TimeUnit a3) throws NoSuchAlgorithmException {
        a4(a2, a3, 6);
        TimeBasedOneTimePasswordGenerator a4;
    }
}

