/*
 * Decompiled with CFR 0.150.
 */
package tools.use;

import client.MapleKeyLayout;
import database.DatabaseException;
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

public class CheckSetItemId {
    public static final /* synthetic */ Map<Integer, Map<String, Integer>> equipStatsCache;
    public static final /* synthetic */ List<Integer> allitems;
    public static /* synthetic */ MapleDataProvider equipData;
    public static /* synthetic */ HashMap<Integer, String> items;
    public static /* synthetic */ int errorcount;

    public static final /* synthetic */ void checksetItem() {
        for (int n2 : allitems) {
            int n3 = CheckSetItemId.getSetItemID(n2);
            if (n3 <= 0) continue;
            ++errorcount;
            System.out.println("\u9053\u5177:" + MapleItemInformationProvider.getInstance().getName(n2) + "(" + n2 + ") \u5957\u88dd:" + n3);
        }
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
        if ((mapleData = mapleData.getChildByPath(DatabaseException.ALLATORIxDEMO("5D:E"))) == null) {
            return null;
        }
        LinkedHashMap<String, Integer> linkedHashMap2 = linkedHashMap;
        linkedHashMap2.put(MapleKeyLayout.ALLATORIxDEMO("\u000eO\tc\tO\u0010c9"), MapleDataTool.getInt(DatabaseException.ALLATORIxDEMO("Y9^\u0015^9G\u0015n"), mapleData, 0));
        return linkedHashMap2;
    }

    public static final /* synthetic */ MapleData getItemData(int a2) {
        MapleData mapleData = null;
        String string = "0" + String.valueOf(a2);
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry : equipData.getRoot().getSubdirectories()) {
            for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
                if (!mapleDataFileEntry.getName().equals(string + ".img")) continue;
                return equipData.getData(mapleDataDirectoryEntry.getName() + "/" + mapleDataFileEntry.getName());
            }
        }
        return mapleData;
    }

    public static final /* synthetic */ void loadAllItem() {
        Object var0 = null;
        Iterator<MapleDataDirectoryEntry> iterator = equipData.getRoot().getSubdirectories().iterator();
        while (iterator.hasNext()) {
            for (MapleDataFileEntry mapleDataFileEntry : iterator.next().getFiles()) {
                int n2;
                int n3 = -1;
                try {
                    n2 = n3 = Integer.parseInt(mapleDataFileEntry.getName().replace(MapleKeyLayout.ALLATORIxDEMO("\u0004\u0014G\u001a"), ""));
                }
                catch (Exception exception) {
                    n2 = n3;
                }
                if (n2 == -1) continue;
                allitems.add(n3);
                CheckSetItemId.getSetItemID(n3);
            }
        }
        System.out.println(DatabaseException.ALLATORIxDEMO("\u8881\u50b3\u8f55\u514f\u5bd0\u623a"));
    }

    public /* synthetic */ CheckSetItemId() {
        CheckSetItemId a2;
    }

    public static /* synthetic */ void main(String[] a2) throws IOException {
        System.out.println(MapleKeyLayout.ALLATORIxDEMO("w\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^ ^\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\tw\t]\n]\n]\n]\n^\t]\t]\n]\t]\n]\n^\t]\t^\t]\t^\t]\t^\n]\t^\t]\n]\n]\n]\n^ ^\n]\n]\n]\n^\n^\n^\n]\n^\n]\n^\n^\n]\t]\n^\n^\n^\n^\n]\t]\n]\n]\n]\n]\tw\t]\n]\n]\n]\t^\t]\t]\n]\t]\n]\t^\t]\n^\n]\t]\t]\t^\n]\n^\n]\n]\n]\n]\n^ ^\n]\n]\n]\n^\n^\n^\t^\n^\t^\n^\n^\n]\t]\n^\t^\n^\n^\n^\t^\n]\n]\n]\n]\tw\t]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n^ ^\n2H\u001b_\u000eI\u001c^\u0014E\u0013\n\u001fS]k\u0011F\u001c^\u0012X\u0014\n2H\u001b_\u000eI\u001c^\u0012X]\\J\u0004N\n9o0e]\tw\t]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n^ ^\n]\n]\n]\n]\n]\n\u0015^\tZG\u0005R]\n]SK\u0011F\u001c^\u0012X\u0014\u0004\u001eE\u0010\n]\n]\n]\n]\n]\n]\tw\t]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n]\n^ ^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\t^\tw"));
        equipData = MapleDataProviderFactory.getDataProvider(DatabaseException.ALLATORIxDEMO("\u001fB=X=I(O.\u0004+P"));
        CheckSetItemId.loadAllItem();
        CheckSetItemId.checksetItem();
        System.out.print("\u5171\u6709" + errorcount + "\u500b\u5957\u88dd\u4ee3\u78bc");
    }

    public static final /* synthetic */ int getSetItemID(int a2) {
        if (CheckSetItemId.getEquipStats(a2) == null) {
            return 0;
        }
        return CheckSetItemId.getEquipStats(a2).get(MapleKeyLayout.ALLATORIxDEMO("\u000eO\tc\tO\u0010c9"));
    }

    public static /* synthetic */ {
        items = new HashMap();
        allitems = new ArrayList<Integer>();
        equipStatsCache = new HashMap<Integer, Map<String, Integer>>();
        errorcount = 0;
    }
}

