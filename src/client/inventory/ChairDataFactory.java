/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import constants.GameSetConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import provider.MapleData;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.MapleShopItem;
import tools.EmojiFilter;
import tools.StringTool;

public class ChairDataFactory {
    private static final /* synthetic */ Map<Integer, Integer> d;
    private static final /* synthetic */ MapleDataProvider K;
    private static /* synthetic */ List<Integer> ALLATORIxDEMO;
    private static final /* synthetic */ Map<Integer, Integer> a;

    public static final /* synthetic */ int getChairExpMax(int a2) {
        int n2 = 0;
        if (d.get(a2) == null) {
            MapleData mapleData = K.getData(EmojiFilter.ALLATORIxDEMO("J\"p8b oc3\u007f3~-%n+"));
            int n3 = 0;
            String string = "0" + String.valueOf(a2);
            if (mapleData != null) {
                n3 = MapleDataTool.getInt(string + "/info/maxExp", mapleData, 0);
            }
            d.put(a2, n3);
            n2 = d.get(a2);
            return n2;
        }
        n2 = d.get(a2);
        return n2;
    }

    public static /* synthetic */ boolean TamingMobExist(int a2) {
        if (ALLATORIxDEMO.isEmpty()) {
            for (MapleDataFileEntry mapleDataFileEntry : MapleDataProviderFactory.getDataProvider(MapleShopItem.ALLATORIxDEMO("d\u0014F\u000eF\u001fS\u0019URP\u0006\b(F\u0011N\u0012@1H\u001e")).getRoot().getFiles()) {
                if (!StringTool.isNumeric(mapleDataFileEntry.getName().substring(0, 8))) continue;
                int n2 = Integer.parseInt(mapleDataFileEntry.getName().substring(0, 8));
                ALLATORIxDEMO.add(n2);
            }
        }
        return ALLATORIxDEMO.contains(a2);
    }

    public static /* synthetic */ int getSpecialChairEffect(int a2) {
        switch (a2) {
            case 3010955: {
                int n2 = new Random().nextInt(100);
                if (n2 <= 50) {
                    return 1933047;
                }
                if (n2 <= 50) break;
                return 1933049;
            }
        }
        return 0;
    }

    public static final /* synthetic */ int getFlyChair(int a2) {
        int n2 = 0;
        if (a.get(a2) == null) {
            MapleData mapleData = null;
            if (a2 / 10000 == 301) {
                mapleData = K.getData(MapleShopItem.ALLATORIxDEMO("n\u0012T\bF\u0010KS\u0017O\u0017M\t\u0015J\u001b"));
            } else if (a2 / 10000 == 302) {
                mapleData = K.getData(EmojiFilter.ALLATORIxDEMO("J\"p8b oc3\u007f3~-%n+"));
            }
            int n3 = 0;
            String string = "0" + String.valueOf(a2);
            if (mapleData != null) {
                n3 = MapleDataTool.getInt(string + "/info/tamingMob", mapleData, 0);
            }
            a.put(a2, n3);
            n2 = a.get(a2);
        } else {
            n2 = a.get(a2);
        }
        if (GameSetConstants.MAPLE_VERSION < 134 && n2 >= 1980000 && n2 <= 1990000) {
            n2 -= 50000;
        }
        if (ChairDataFactory.getSpecialChairEffect(a2) != 0) {
            n2 = ChairDataFactory.getSpecialChairEffect(a2);
        }
        if (!ChairDataFactory.TamingMobExist(n2)) {
            n2 = 0;
        }
        return n2;
    }

    public /* synthetic */ ChairDataFactory() {
        ChairDataFactory a2;
    }

    public static /* synthetic */ {
        K = MapleDataProviderFactory.getDataProvider(EmojiFilter.ALLATORIxDEMO("\u0005w)nbt6"));
        a = new HashMap<Integer, Integer>();
        d = new HashMap<Integer, Integer>();
        ALLATORIxDEMO = new ArrayList<Integer>();
    }
}

