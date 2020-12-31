/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.util.Date;
import java.util.SimpleTimeZone;

public class KoreanDateUtil {
    private static final /* synthetic */ int d = 27111908;
    private static final /* synthetic */ long ALLATORIxDEMO = 116444736000000000L;
    private static final /* synthetic */ long a = 946681229830L;
    private static final /* synthetic */ int K = -1085019342;

    public static /* synthetic */ long getFileTimestamp(long a2) {
        return KoreanDateUtil.getFileTimestamp(a2, false);
    }

    public static final /* synthetic */ int getItemTimestamp(long a2) {
        return (int)((double)((int)((a2 - 946681229830L) / 1000L / 60L)) * 35.762787) + -1085019342;
    }

    public /* synthetic */ KoreanDateUtil() {
        KoreanDateUtil a2;
    }

    public static final /* synthetic */ long getTempBanTimestamp(long a2) {
        return a2 * 10000L + 116444736000000000L;
    }

    public static /* synthetic */ long getFileTimestamp(long a2, boolean a3) {
        long l2;
        long l3;
        if (KoreanDateUtil.isDST()) {
            a2 -= 3600000L;
        }
        return (a3 ? (l3 = a2 / 1000L / 60L * 600000000L) : (l2 = a2 * 10000L)) + 116444736000000000L;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 1 << 1;
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ 5 << 1;
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

    public static /* synthetic */ boolean isDST() {
        return SimpleTimeZone.getDefault().inDaylightTime(new Date());
    }

    public static final /* synthetic */ int getQuestTimestamp(long a2) {
        return (int)((double)((int)(a2 / 1000L / 60L)) * 0.1396987) + 27111908;
    }
}

