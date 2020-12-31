/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.MapleCharacter;
import handling.world.World;
import java.awt.Point;
import java.io.Serializable;
import server.maps.MapleDoor;

public class MaplePartyCharacter
implements Serializable {
    private final /* synthetic */ String C;
    private /* synthetic */ int e;
    private /* synthetic */ int g;
    private /* synthetic */ int E;
    private /* synthetic */ int a;
    private /* synthetic */ int B;
    private /* synthetic */ int k;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int H;
    private /* synthetic */ Point d;
    private /* synthetic */ int K;
    private static final /* synthetic */ long F = 6215463252132450750L;

    public /* synthetic */ int getLevel() {
        MaplePartyCharacter a2;
        return a2.e;
    }

    public /* synthetic */ int getMapid() {
        MaplePartyCharacter a2;
        return a2.B;
    }

    public /* synthetic */ int getDoorSkill() {
        MaplePartyCharacter a2;
        return a2.a;
    }

    public /* synthetic */ int getId() {
        MaplePartyCharacter a2;
        return a2.H;
    }

    public /* synthetic */ MaplePartyCharacter(MapleCharacter a2) {
        MaplePartyCharacter a3;
        MaplePartyCharacter maplePartyCharacter = a3;
        MapleCharacter mapleCharacter = a2;
        MaplePartyCharacter maplePartyCharacter2 = a3;
        MapleCharacter mapleCharacter2 = a2;
        MaplePartyCharacter maplePartyCharacter3 = a3;
        MaplePartyCharacter maplePartyCharacter4 = a3;
        maplePartyCharacter4.k = 999999999;
        maplePartyCharacter4.K = 999999999;
        maplePartyCharacter3.a = 0;
        MaplePartyCharacter maplePartyCharacter5 = a3;
        maplePartyCharacter3.d = new Point(0, 0);
        maplePartyCharacter3.C = a2.getName();
        a3.e = mapleCharacter2.getLevel();
        maplePartyCharacter2.E = mapleCharacter2.getClient().getChannel();
        maplePartyCharacter2.H = a2.getId();
        a3.g = mapleCharacter.getJob();
        maplePartyCharacter.B = mapleCharacter.getMapId();
        maplePartyCharacter.ALLATORIxDEMO = true;
        Object object = a2.getDoors();
        if (object.size() > 0) {
            object = object.get(0);
            MaplePartyCharacter maplePartyCharacter6 = a3;
            Object object2 = object;
            a3.k = ((MapleDoor)object).getTown().getId();
            a3.K = ((MapleDoor)object2).getTarget().getId();
            maplePartyCharacter6.a = ((MapleDoor)object2).getSkill();
            maplePartyCharacter6.d = ((MapleDoor)object).getTargetPosition();
            return;
        }
        a3.d = new Point(a2.getPosition());
    }

    public /* synthetic */ int getDoorTown() {
        MaplePartyCharacter a2;
        return a2.k;
    }

    public /* synthetic */ MapleCharacter getChr() {
        MaplePartyCharacter a2;
        return World.Find.findChr(a2.H);
    }

    public /* synthetic */ boolean isOnline() {
        MaplePartyCharacter a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 5 << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = 3 ^ 5;
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
        MaplePartyCharacter a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (MaplePartyCharacter)a2;
        return !(a3.C == null ? ((MaplePartyCharacter)a2).C != null : !a3.C.equals(((MaplePartyCharacter)a2).C));
    }

    public /* synthetic */ MaplePartyCharacter() {
        MaplePartyCharacter a2;
        MaplePartyCharacter maplePartyCharacter = a2;
        MaplePartyCharacter maplePartyCharacter2 = a2;
        MaplePartyCharacter maplePartyCharacter3 = a2;
        maplePartyCharacter3.k = 999999999;
        maplePartyCharacter3.K = 999999999;
        maplePartyCharacter2.a = 0;
        MaplePartyCharacter maplePartyCharacter4 = a2;
        maplePartyCharacter2.d = new Point(0, 0);
        maplePartyCharacter2.C = "";
        maplePartyCharacter.K = 999999999;
        maplePartyCharacter.a = 0;
        maplePartyCharacter.d = new Point(0, 0);
    }

    public /* synthetic */ void setOnline(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getDoorTarget() {
        MaplePartyCharacter a2;
        return a2.K;
    }

    public /* synthetic */ String getName() {
        MaplePartyCharacter a2;
        return a2.C;
    }

    public /* synthetic */ int getChannel() {
        MaplePartyCharacter a2;
        return a2.E;
    }

    public /* synthetic */ Point getDoorPosition() {
        MaplePartyCharacter a2;
        return a2.d;
    }

    public /* synthetic */ int hashCode() {
        MaplePartyCharacter a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + (a2.C == null ? 0 : a2.C.hashCode());
        return n2;
    }

    public /* synthetic */ int getJobId() {
        MaplePartyCharacter a2;
        return a2.g;
    }
}

