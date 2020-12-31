/*
 * Decompiled with CFR 0.150.
 */
package database;

import java.sql.SQLException;

public class DatabaseException
extends RuntimeException {
    private static final /* synthetic */ long ALLATORIxDEMO = -420103154764822555L;

    public /* synthetic */ DatabaseException(String a2, Throwable a3) {
        super(a2, a3);
        DatabaseException a4;
    }

    public /* synthetic */ DatabaseException(String a2) {
        super(a2);
        DatabaseException a3;
    }

    public /* synthetic */ DatabaseException(SQLException a2) {
        DatabaseException a3;
        throw new UnsupportedOperationException(a2);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (3 ^ 5) << 1;
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 3;
        int n5 = n3;
        int n6 = 5 << 3 ^ 2;
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
}

