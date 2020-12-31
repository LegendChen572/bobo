/*
 * Decompiled with CFR 0.150.
 */
package handling.world.exped;

import handling.world.MapleParty;
import handling.world.World;
import handling.world.exped.ExpeditionType;
import java.util.ArrayList;
import java.util.List;

public class MapleExpedition {
    private /* synthetic */ ExpeditionType a;
    private /* synthetic */ List<Integer> K;
    private /* synthetic */ int d;
    private /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ int getFreeParty() {
        MapleExpedition a2;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.K.size()) {
            MapleParty mapleParty = World.Party.getParty(a2.K.get(n2));
            if (mapleParty == null) {
                a2.K.remove(n2);
            } else if (mapleParty.getMembers().size() < 6) {
                return mapleParty.getId();
            }
            n3 = ++n2;
        }
        if (a2.K.size() < a2.a.maxParty) {
            return 0;
        }
        return -1;
    }

    public /* synthetic */ ExpeditionType getType() {
        MapleExpedition a2;
        return a2.a;
    }

    public /* synthetic */ int getIndex(int a2) {
        MapleExpedition a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.K.size()) {
            if (a3.K.get(n2) == a2) {
                return n2;
            }
            n3 = ++n2;
        }
        return -1;
    }

    public /* synthetic */ MapleExpedition(ExpeditionType a2, int a3, int a4) {
        MapleExpedition a5;
        MapleExpedition mapleExpedition = a5;
        a5.a = a2;
        mapleExpedition.ALLATORIxDEMO = a4;
        mapleExpedition.d = a3;
        MapleExpedition mapleExpedition2 = a5;
        mapleExpedition.K = new ArrayList<Integer>(a2.maxParty);
    }

    public /* synthetic */ int getAllMembers() {
        MapleExpedition a2;
        int n2;
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < a2.K.size()) {
            MapleParty mapleParty = World.Party.getParty(a2.K.get(n2));
            if (mapleParty == null) {
                a2.K.remove(n2);
            } else {
                n3 += mapleParty.getMembers().size();
            }
            n4 = ++n2;
        }
        return n3;
    }

    public /* synthetic */ int getId() {
        MapleExpedition a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getLeader() {
        MapleExpedition a2;
        return a2.d;
    }

    public /* synthetic */ List<Integer> getParties() {
        MapleExpedition a2;
        return a2.K;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ 5;
        int cfr_ignored_0 = 4 << 3 ^ (3 ^ 5);
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

    public /* synthetic */ void setLeader(int a2) {
        a.d = a2;
    }
}

