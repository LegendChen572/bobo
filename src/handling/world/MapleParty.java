/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import handling.world.MaplePartyCharacter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tools.Pair;
import tools.Triple;

public class MapleParty
implements Serializable {
    private /* synthetic */ MaplePartyCharacter B;
    private /* synthetic */ int d;
    private /* synthetic */ List<Triple<Integer, Integer, Integer>> ALLATORIxDEMO;
    private static final /* synthetic */ long g = 9179541993413738569L;
    private /* synthetic */ int K;
    private final /* synthetic */ List<MaplePartyCharacter> k;
    private /* synthetic */ int a;

    public /* synthetic */ void updateMember(MaplePartyCharacter a2) {
        MapleParty a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.k.size()) {
            if (a3.k.get(n2).equals(a2)) {
                a3.k.set(n2, a2);
            }
            n3 = ++n2;
        }
        a3.ALLATORIxDEMO();
    }

    public /* synthetic */ void resetChooseItem() {
        MapleParty a2;
        a2.ALLATORIxDEMO.clear();
    }

    public /* synthetic */ void addMember(MaplePartyCharacter a2) {
        MapleParty a3;
        a3.k.add(a2);
        a3.ALLATORIxDEMO();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4;
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 4;
        int n5 = n3;
        int n6 = 3 << 3 ^ 1;
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

    public /* synthetic */ int getAverageLevel() {
        MapleParty a2;
        return a2.d;
    }

    public /* synthetic */ Collection<MaplePartyCharacter> getMembers() {
        MapleParty a2;
        return new LinkedList<MaplePartyCharacter>(a2.k);
    }

    public /* synthetic */ int getExpeditionId() {
        MapleParty a2;
        return a2.a;
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        MapleParty a2;
        Iterator<MaplePartyCharacter> iterator;
        int n2 = 0;
        Iterator<MaplePartyCharacter> iterator2 = iterator = a2.k.iterator();
        while (iterator2.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = iterator.next();
            n2 += maplePartyCharacter.getLevel();
            iterator2 = iterator;
        }
        a2.d = n2 = (int)((double)a2.d / (double)a2.k.size());
    }

    public /* synthetic */ boolean equals(Object a2) {
        MapleParty a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (MapleParty)a2;
        return a3.K == ((MapleParty)a2).K;
    }

    public /* synthetic */ Pair<Integer, Integer> getChooseItemByChrId(int a2) {
        MapleParty a3;
        for (Triple<Integer, Integer, Integer> triple : a3.ALLATORIxDEMO) {
            if (triple.getLeft() != a2) continue;
            return new Pair<Integer, Integer>(triple.getMid(), triple.getRight());
        }
        return null;
    }

    public /* synthetic */ MapleParty(int a2, MaplePartyCharacter a3) {
        MapleParty a4;
        MapleParty mapleParty = a4;
        MapleParty mapleParty2 = a4;
        mapleParty2.k = new LinkedList<MaplePartyCharacter>();
        mapleParty.a = -1;
        mapleParty.d = 0;
        a4.ALLATORIxDEMO = new LinkedList<Triple<Integer, Integer, Integer>>();
        a4.B = a3;
        a4.k.add(a4.B);
        MapleParty mapleParty3 = a4;
        mapleParty3.K = a2;
        mapleParty3.d = 0;
    }

    public /* synthetic */ int getId() {
        MapleParty a2;
        return a2.K;
    }

    public /* synthetic */ void setLeader(MaplePartyCharacter a2) {
        a.B = a2;
    }

    public /* synthetic */ void addChooseItem(int a2, int a3, int a4) {
        MapleParty a5;
        a5.ALLATORIxDEMO.add(new Triple<Integer, Integer, Integer>(a2, a3, a4));
    }

    public /* synthetic */ boolean containsMembers(MaplePartyCharacter a2) {
        MapleParty a3;
        return a3.k.contains(a2);
    }

    public /* synthetic */ void removeMember(MaplePartyCharacter a2) {
        MapleParty a3;
        a3.k.remove(a2);
        a3.ALLATORIxDEMO();
    }

    public /* synthetic */ void setId(int a2) {
        a.K = a2;
    }

    public /* synthetic */ int hashCode() {
        MapleParty a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + a2.K;
        return n2;
    }

    public /* synthetic */ MaplePartyCharacter getMemberById(int a2) {
        MapleParty a3;
        for (MaplePartyCharacter maplePartyCharacter : a3.k) {
            if (maplePartyCharacter.getId() != a2) continue;
            return maplePartyCharacter;
        }
        return null;
    }

    public /* synthetic */ MaplePartyCharacter getLeader() {
        MapleParty a2;
        return a2.B;
    }

    public /* synthetic */ Collection<MaplePartyCharacter> getOnlineMembers() {
        MapleParty a2;
        LinkedList<MaplePartyCharacter> linkedList = new LinkedList<MaplePartyCharacter>();
        for (MaplePartyCharacter maplePartyCharacter : a2.k) {
            if (!maplePartyCharacter.isOnline()) continue;
            linkedList.add(maplePartyCharacter);
        }
        return new LinkedList<MaplePartyCharacter>(linkedList);
    }

    public /* synthetic */ List<Triple<Integer, Integer, Integer>> getChooseItems() {
        MapleParty a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MaplePartyCharacter getMemberByIndex(int a2) {
        MapleParty a3;
        return a3.k.get(a2);
    }

    public /* synthetic */ boolean hasChoosenItem(int a2) {
        MapleParty a3;
        Iterator<Triple<Integer, Integer, Integer>> iterator = a3.ALLATORIxDEMO.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLeft() != a2) continue;
            return true;
        }
        return false;
    }
}

