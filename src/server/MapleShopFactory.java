/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleCharacter;
import java.util.HashMap;
import java.util.Map;
import server.MapleShop;

public class MapleShopFactory {
    private /* synthetic */ Map<Integer, MapleShop> a;
    private /* synthetic */ Map<Integer, MapleShop> d;
    private static /* synthetic */ MapleShopFactory ALLATORIxDEMO;

    public /* synthetic */ MapleShopFactory() {
        MapleShopFactory a2;
        MapleShopFactory mapleShopFactory = a2;
        a2.a = new HashMap<Integer, MapleShop>();
        mapleShopFactory.d = new HashMap<Integer, MapleShop>();
    }

    public /* synthetic */ MapleShop getShop(int a2) {
        MapleShopFactory a3;
        if (a3.a.containsKey(a2)) {
            return a3.a.get(a2);
        }
        return a3.ALLATORIxDEMO(a2, true);
    }

    public static /* synthetic */ MapleShopFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public /* synthetic */ void clear() {
        MapleShopFactory a2;
        MapleShopFactory mapleShopFactory = a2;
        mapleShopFactory.a.clear();
        mapleShopFactory.d.clear();
    }

    private /* synthetic */ MapleShop ALLATORIxDEMO(int a2, boolean a3) {
        MapleShopFactory a4;
        MapleShop mapleShop = MapleShop.createFromDB(a2, a3);
        if (mapleShop != null) {
            MapleShop mapleShop2 = mapleShop;
            a4.a.put(mapleShop.getId(), mapleShop2);
            a4.d.put(mapleShop.getNpcId(), mapleShop);
            return mapleShop2;
        }
        if (a3) {
            a4.a.put(a2, null);
            return mapleShop;
        }
        a4.d.put(a2, null);
        return mapleShop;
    }

    public /* synthetic */ MapleShop getShopSell(MapleCharacter a2) {
        return MapleShop.createFromSell(a2);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new MapleShopFactory();
    }

    public /* synthetic */ MapleShop getShopForNPC(int a2) {
        MapleShopFactory a3;
        if (a3.d.containsKey(a2)) {
            return a3.d.get(a2);
        }
        return a3.ALLATORIxDEMO(a2, false);
    }
}

