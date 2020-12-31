/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.MapleCharacter;
import java.io.Serializable;

public class MapleMessengerCharacter
implements Serializable {
    private /* synthetic */ int a;
    private static final /* synthetic */ long k = 6215463252132450750L;
    private /* synthetic */ String K;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int d;

    public /* synthetic */ String getName() {
        MapleMessengerCharacter a2;
        return a2.K;
    }

    public /* synthetic */ int getId() {
        MapleMessengerCharacter a2;
        return a2.a;
    }

    public /* synthetic */ MapleMessengerCharacter(MapleCharacter a2) {
        MapleMessengerCharacter a3;
        MapleMessengerCharacter mapleMessengerCharacter = a3;
        MapleCharacter mapleCharacter = a2;
        MapleMessengerCharacter mapleMessengerCharacter2 = a3;
        MapleMessengerCharacter mapleMessengerCharacter3 = a3;
        a3.K = "";
        mapleMessengerCharacter3.a = -1;
        mapleMessengerCharacter3.d = -1;
        mapleMessengerCharacter2.ALLATORIxDEMO = false;
        mapleMessengerCharacter2.K = a2.getName();
        a3.d = mapleCharacter.getClient().getChannel();
        mapleMessengerCharacter.a = mapleCharacter.getId();
        mapleMessengerCharacter.ALLATORIxDEMO = true;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 1 << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 1 << 3;
        int n5 = n3;
        int n6 = 4;
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

    public /* synthetic */ boolean equals(Object a2) {
        MapleMessengerCharacter a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (MapleMessengerCharacter)a2;
        return !(a3.K == null ? ((MapleMessengerCharacter)a2).K != null : !a3.K.equals(((MapleMessengerCharacter)a2).K));
    }

    public /* synthetic */ MapleMessengerCharacter() {
        MapleMessengerCharacter a2;
        MapleMessengerCharacter mapleMessengerCharacter = a2;
        MapleMessengerCharacter mapleMessengerCharacter2 = a2;
        mapleMessengerCharacter2.K = "";
        mapleMessengerCharacter2.a = -1;
        mapleMessengerCharacter.d = -1;
        mapleMessengerCharacter.ALLATORIxDEMO = false;
    }

    public /* synthetic */ boolean isOnline() {
        MapleMessengerCharacter a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getChannel() {
        MapleMessengerCharacter a2;
        return a2.d;
    }

    public /* synthetic */ void setOnline(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int hashCode() {
        MapleMessengerCharacter a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + (a2.K == null ? 0 : a2.K.hashCode());
        return n2;
    }
}

