/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleFriendship;
import client.PlayerRandomStream;
import database.DBConPool;
import java.sql.SQLException;
import tools.data.LittleEndianAccessor;

public class MapleMapRank {
    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void FishRank(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        a = DBConPool.getInstance().getDataSource().getConnection();
        try {
            a = a.prepareStatement(PlayerRandomStream.ALLATORIxDEMO("\u0000\n\u001f\n\u0010\u001bs/=.>*3cs/' '.?\u0010# :!'<3o\u0015\u001d\u001c\u0002s):<;=2!8&=( o\u001c\u001d\u0017\n\u0001o\u0011\u0016s/' '.?\u0010# :!'<3o\u0012\u001c\u0010o\u001f\u0006\u001e\u0006\u0007ob\u007f"));
            var3_5 = a.executeQuery();
            a.close();
            var3_5.close();
            ** if (a == null) goto lbl-1000
        }
        catch (Throwable a) {
            if (a == null) ** GOTO lbl22
            try {
                a.close();
                v0 = a;
                ** GOTO lbl23
            }
            catch (Throwable var3_6) {
                try {
                    a.addSuppressed(var3_6);
lbl22:
                    // 2 sources

                    v0 = a;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException a) {
                    System.out.println("\u8b80\u53d6\u4e0d\u591c\u57ce\u6293\u9b5a\u6392\u884c\u699c\u51fa\u932f " + a);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            a.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public /* synthetic */ MapleMapRank() {
        MapleMapRank a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void PVPRank(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        a = DBConPool.getInstance().getDataSource().getConnection();
        try {
            a = a.prepareStatement(MapleFriendship.ALLATORIxDEMO("KnTn[\u007f8KvJuNx\u00078KoBvE}Yx\u000b^yWf8[n[jJv@qE\u007fX8dJo]y8iA\u000bx\\qEvNjK8jKh8gQfQ\u007f8\u001a("));
            var3_5 = a.executeQuery();
            a.close();
            var3_5.close();
            ** if (a == null) goto lbl-1000
        }
        catch (Throwable a) {
            if (a == null) ** GOTO lbl22
            try {
                a.close();
                v0 = a;
                ** GOTO lbl23
            }
            catch (Throwable var3_6) {
                try {
                    a.addSuppressed(var3_6);
lbl22:
                    // 2 sources

                    v0 = a;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException a) {
                    System.out.println("\u8b80\u53d6\u4e0a\u6d77\u7058PVP\u6392\u884c\u699c\u51fa\u932f " + a);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            a.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }
}

