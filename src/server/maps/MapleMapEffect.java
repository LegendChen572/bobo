/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleClient;
import tools.MaplePacketCreator;
import tools.packet.MTSCSPacket;

public class MapleMapEffect {
    private /* synthetic */ String K;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ boolean d;
    private /* synthetic */ int a;

    public /* synthetic */ void setActive(boolean a2) {
        a.d = a2;
    }

    public /* synthetic */ byte[] makeDestroyData() {
        MapleMapEffect a2;
        if (a2.ALLATORIxDEMO) {
            return MTSCSPacket.playCashSong(0, "");
        }
        return MaplePacketCreator.removeMapEffect();
    }

    public /* synthetic */ void setJukebox(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ MapleMapEffect(String a2, int a3) {
        MapleMapEffect a4;
        MapleMapEffect mapleMapEffect = a4;
        MapleMapEffect mapleMapEffect2 = a4;
        MapleMapEffect mapleMapEffect3 = a4;
        mapleMapEffect3.K = "";
        mapleMapEffect3.a = 0;
        mapleMapEffect2.d = true;
        mapleMapEffect2.ALLATORIxDEMO = false;
        mapleMapEffect.K = a2;
        mapleMapEffect.a = a3;
    }

    public /* synthetic */ void sendStartData(MapleClient a2) {
        MapleMapEffect a3;
        a2.sendPacket(a3.makeStartData());
    }

    public /* synthetic */ byte[] makeStartData() {
        MapleMapEffect a2;
        if (a2.ALLATORIxDEMO) {
            MapleMapEffect mapleMapEffect = a2;
            return MTSCSPacket.playCashSong(mapleMapEffect.a, mapleMapEffect.K);
        }
        MapleMapEffect mapleMapEffect = a2;
        return MaplePacketCreator.startMapEffect(mapleMapEffect.K, mapleMapEffect.a, a2.d);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
        int n5 = n3;
        int n6 = 4 << 4 ^ (2 ^ 5) << 1;
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

    public /* synthetic */ boolean isJukebox() {
        MapleMapEffect a2;
        return a2.ALLATORIxDEMO;
    }
}

