/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.MapleItemInformationProvider;
import server.shops.MaplePlayerShopItem;
import tools.database.UniqueIdReset;

public class CheckSetItemId {
    public static final /* synthetic */ Map<Integer, Map<String, Integer>> equipStatsCache;
    public static /* synthetic */ HashMap<Integer, String> items;
    public static final /* synthetic */ List<Integer> allitems;
    public static /* synthetic */ int errorcount;
    public static /* synthetic */ MapleDataProvider equipData;

    public static /* synthetic */ void main(String[] a2) throws IOException {
        System.out.println(UniqueIdReset.ALLATORIxDEMO("m%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D\fD&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G%m%G&G&G&G&D%G%G&G%G&G&D%G%D%G%D%G%D&G%D%G&G&G&G&D\fD&G&G&G&D&D&D&G&D&G&D&D&G%G&D&D&D&D&G%G&G&G&G&G%m%G&G&G&G%D%G%G&G%G&G%D%G&D&G%G%G%D&G&D&G&G&G&G&D\fD&G&G&G&D&D&D%D&D%D&D&D&G%G&D%D&D&D&D%D&G&G&G&G%m%G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&D\fD&(d\u0001s\u0014e\u0006r\u000ei\t&\u0005\u007fGG\u000bj\u0006r\bt\u000e&(d\u0001s\u0014e\u0006r\btGpP(T&#C*IG%m%G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&D\fD&G&G&G&G&G&\u000fr\u0013v])Hq\u0010qIg\u000bj\u0006r\bt\u000e(\u0004i\n&G&G&G&G&G&G%m%G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&G&D\fD%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%D%m"));
        equipData = MapleDataProviderFactory.getDataProvider(MaplePlayerShopItem.ALLATORIxDEMO("4^\u0016D\u0016U\u0003S\u0005\u0018\u0000L"));
        CheckSetItemId.loadAllItem();
        CheckSetItemId.checksetItem();
        System.out.print("\u5171\u6709" + errorcount + "\u500b\u5957\u88dd\u4ee3\u78bc");
    }

    public static final /* synthetic */ int getSetItemID(int a2) {
        if (CheckSetItemId.getEquipStats(a2) == null) {
            return 0;
        }
        return CheckSetItemId.getEquipStats(a2).get(UniqueIdReset.ALLATORIxDEMO("\u0014c\u0013O\u0013c\nO#"));
    }

    public static final /* synthetic */ void loadAllItem() {
        Object var0 = null;
        Iterator<MapleDataDirectoryEntry> iterator = equipData.getRoot().getSubdirectories().iterator();
        while (iterator.hasNext()) {
            for (MapleDataFileEntry mapleDataFileEntry : iterator.next().getFiles()) {
                int n2;
                int n3 = -1;
                try {
                    n2 = n3 = Integer.parseInt(mapleDataFileEntry.getName().replace(UniqueIdReset.ALLATORIxDEMO("(\u000ek\u0000"), ""));
                }
                catch (Exception exception) {
                    n2 = n3;
                }
                if (n2 == -1) continue;
                allitems.add(n3);
                CheckSetItemId.getSetItemID(n3);
            }
        }
        System.out.println(MaplePlayerShopItem.ALLATORIxDEMO("\u88aa\u50af\u8f7e\u5153\u5bfb\u6226"));
    }

    public static /* synthetic */ {
        items = new HashMap();
        allitems = new ArrayList<Integer>();
        equipStatsCache = new HashMap<Integer, Map<String, Integer>>();
        errorcount = 0;
    }

    public static final /* synthetic */ MapleData getItemData(int a2) {
        MapleData mapleData = null;
        String string = "0" + String.valueOf(a2);
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : equipData.getRoot().getSubdirectories()) {
            for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
                if (!mapleDataFileEntry.getName().equals(string + ".img")) continue;
                try {
                    mapleData = equipData.getData(mapleDataDirectoryEntry.getName() + "/" + mapleDataFileEntry.getName());
                }
                catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        }
        return mapleData;
    }

    public static final /* synthetic */ Map<String, Integer> getEquipStats(int a2) {
        if (equipStatsCache.containsKey(a2)) {
            return equipStatsCache.get(a2);
        }
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        MapleData mapleData = CheckSetItemId.getItemData(a2);
        if (mapleData == null) {
            return null;
        }
        if ((mapleData = mapleData.getChildByPath(MaplePlayerShopItem.ALLATORIxDEMO("\u001eX\u0011Y"))) == null) {
            return null;
        }
        LinkedHashMap<String, Integer> linkedHashMap2 = linkedHashMap;
        linkedHashMap2.put(UniqueIdReset.ALLATORIxDEMO("\u0014c\u0013O\u0013c\nO#"), MapleDataTool.getInt(MaplePlayerShopItem.ALLATORIxDEMO("E\u0012B>B\u0012[>r"), mapleData, 0));
        return linkedHashMap2;
    }

    public static final /* synthetic */ void checksetItem() {
        for (int n2 : allitems) {
            int n3 = CheckSetItemId.getSetItemID(n2);
            if (n3 <= 0) continue;
            ++errorcount;
            System.out.println("\u9053\u5177:" + MapleItemInformationProvider.getInstance().getName(n2) + "(" + n2 + ") \u5957\u88dd:" + n3);
        }
    }

    public /* synthetic */ CheckSetItemId() {
        CheckSetItemId a2;
    }
}

