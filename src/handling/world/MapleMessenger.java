/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import handling.world.MapleMessengerCharacter;
import java.util.Arrays;
import java.util.Collection;

public final class MapleMessenger {
    private /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ MapleMessengerCharacter[] a;
    private final /* synthetic */ String[] d;

    public /* synthetic */ boolean equals(Object a2) {
        MapleMessenger a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (MapleMessenger)a2;
        return a3.ALLATORIxDEMO == ((MapleMessenger)a2).ALLATORIxDEMO;
    }

    public /* synthetic */ void silentRemoveMember(MapleMessengerCharacter a2) {
        MapleMessenger a3;
        int n2 = a3.getPositionByName(a2.getName());
        if (n2 > -1 && n2 < 4) {
            MapleMessenger mapleMessenger = a3;
            mapleMessenger.a[n2] = null;
            mapleMessenger.d[n2] = a2.getName();
        }
    }

    public /* synthetic */ int hashCode() {
        MapleMessenger a2;
        return 31 + a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getLowestPosition() {
        MapleMessenger a2;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.a.length) {
            if (a2.a[n2] == null) {
                return n2;
            }
            n3 = ++n2;
        }
        return 4;
    }

    public /* synthetic */ Collection<MapleMessengerCharacter> getMembers() {
        MapleMessenger a2;
        return Arrays.asList(a2.a);
    }

    public /* synthetic */ void addMember(MapleMessengerCharacter a2) {
        MapleMessenger a3;
        int n2 = a3.getLowestPosition();
        if (n2 > -1 && n2 < 4) {
            a3.addMem(n2, a2);
        }
    }

    public /* synthetic */ void silentAddMember(MapleMessengerCharacter a2) {
        MapleMessenger a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.d.length) {
            if (a3.d[n2] != null && a3.d[n2].equalsIgnoreCase(a2.getName())) {
                MapleMessenger mapleMessenger = a3;
                mapleMessenger.addMem(n2, a2);
                mapleMessenger.d[n2] = null;
                return;
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ int getPositionByName(String a2) {
        MapleMessenger a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.a.length) {
            MapleMessengerCharacter mapleMessengerCharacter = a3.a[n2];
            if (mapleMessengerCharacter != null && mapleMessengerCharacter.getName().equalsIgnoreCase(a2)) {
                return n2;
            }
            n3 = ++n2;
        }
        return 4;
    }

    public /* synthetic */ boolean containsMembers(MapleMessengerCharacter a2) {
        MapleMessenger a3;
        return a3.getPositionByName(a2.getName()) < 4;
    }

    public /* synthetic */ void setId(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void addMem(int a2, MapleMessengerCharacter a3) {
        MapleMessenger a4;
        if (a4.a[a2] != null) {
            return;
        }
        a4.a[a2] = a3;
    }

    public /* synthetic */ void removeMember(MapleMessengerCharacter a22) {
        MapleMessenger a3;
        int a22 = a3.getPositionByName(a22.getName());
        if (a22 > -1 && a22 < 4) {
            a3.a[a22] = null;
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = 2 << 3 ^ 1;
        int n5 = n3;
        int n6 = 3 << 3;
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

    public /* synthetic */ MapleMessenger(int a2, MapleMessengerCharacter a3) {
        MapleMessenger a4;
        a4.a = new MapleMessengerCharacter[3];
        a4.d = new String[3];
        a4.ALLATORIxDEMO = a2;
        a4.addMem(0, a3);
    }

    public /* synthetic */ int getId() {
        MapleMessenger a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void updateMember(MapleMessengerCharacter a2) {
        MapleMessenger a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.a.length) {
            if (a3.a[n2].equals(a2)) {
                MapleMessenger mapleMessenger = a3;
                mapleMessenger.a[n2] = null;
                mapleMessenger.addMem(n2, a2);
                return;
            }
            n3 = ++n2;
        }
    }
}

