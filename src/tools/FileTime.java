/*
 * Decompiled with CFR 0.150.
 */
package tools;

public class FileTime {
    private static final /* synthetic */ long a = 150842304000000000L;
    private static final /* synthetic */ long K = 116444592000000000L;
    public /* synthetic */ int dwLowDateTime;
    private static final /* synthetic */ long d = 94354848000000000L;
    public /* synthetic */ int dwHighDateTime;
    private static final /* synthetic */ long ALLATORIxDEMO = 150841440000000000L;

    public /* synthetic */ FileTime(long a2) {
        FileTime a3;
        FileTime fileTime = a3;
        fileTime.dwLowDateTime = (int)(a2 & 0xFFFFFFFFFFFFFFFFL);
        fileTime.dwHighDateTime = (int)(a2 >> 32);
    }

    public static /* synthetic */ FileTime GetPermanentTime() {
        return new FileTime(FileTime.getTime(-3L));
    }

    public static /* synthetic */ FileTime GetMaxTime() {
        return new FileTime(FileTime.getTime(-1L));
    }

    public static /* synthetic */ FileTime GetZeroTime() {
        return new FileTime(FileTime.getTime(-2L));
    }

    public static /* synthetic */ long getTime(long a2) {
        if (a2 == -1L) {
            return 150842304000000000L;
        }
        if (a2 == -2L) {
            return 94354848000000000L;
        }
        if (a2 == -3L) {
            return 150841440000000000L;
        }
        return a2 * 10000L + 116444592000000000L;
    }

    public static /* synthetic */ FileTime GetSystemTime() {
        return new FileTime(FileTime.getTime(System.currentTimeMillis()));
    }
}

