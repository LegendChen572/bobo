/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.ISkill;
import client.MapleJob;
import client.SkillFactory;
import client.inventory.MapleInventoryType;
import client.messages.commands.SkilledCommand;
import constants.GameConstants;
import constants.skills.SkillType;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import provider.MapleData;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.ItemInformation;
import server.MapleItemInformationProvider;
import server.MerchItemPackage;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterInformationProvider;
import server.quest.MapleQuest;
import tools.HexTool;
import tools.StringTool;

public class SearchGenerator {
    public static final /* synthetic */ int \u4efb\u52d9;
    public static final /* synthetic */ int \u9053\u5177;
    public static final /* synthetic */ int \u9aee\u578b;
    public static final /* synthetic */ int \u602a\u7269;
    public static final /* synthetic */ int \u4f3a\u670d\u5668\u5305\u982d;
    public static final /* synthetic */ int NPC;
    public static final /* synthetic */ int \u6280\u80fd;
    public static final /* synthetic */ int \u7528\u6236\u7aef\u5305\u982d;
    public static final /* synthetic */ int \u5730\u5716;
    private static final /* synthetic */ Map<SearchType, Map<Integer, String>> ALLATORIxDEMO;
    public static final /* synthetic */ int \u81c9\u578b;
    public static final /* synthetic */ int \u8077\u696d;

    public static /* synthetic */ {
        \u9053\u5177 = SearchType.\u9053\u5177.getValue();
        NPC = SearchType.NPC.getValue();
        \u5730\u5716 = SearchType.\u5730\u5716.getValue();
        \u602a\u7269 = SearchType.\u602a\u7269.getValue();
        \u4efb\u52d9 = SearchType.\u4efb\u52d9.getValue();
        \u6280\u80fd = SearchType.\u6280\u80fd.getValue();
        \u8077\u696d = SearchType.\u8077\u696d.getValue();
        \u4f3a\u670d\u5668\u5305\u982d = SearchType.\u4f3a\u670d\u5668\u5305\u982d.getValue();
        \u7528\u6236\u7aef\u5305\u982d = SearchType.\u7528\u6236\u7aef\u5305\u982d.getValue();
        \u9aee\u578b = SearchType.\u9aee\u578b.getValue();
        \u81c9\u578b = SearchType.\u81c9\u578b.getValue();
        ALLATORIxDEMO = new HashMap<SearchType, Map<Integer, String>>();
    }

    public static /* synthetic */ Map<Integer, String> getSearchs(int a2) {
        return SearchGenerator.getSearchs(SearchType.valueOf(SearchType.nameOf(a2)));
    }

    public static /* synthetic */ boolean foundData(int a2, String a3) {
        return !SearchGenerator.getSearchData(SearchType.valueOf(SearchType.nameOf(a2)), a3).isEmpty();
    }

    public static /* synthetic */ String searchData(int a2, String a3) {
        return SearchGenerator.searchData(SearchType.valueOf(SearchType.nameOf(a2)), a3);
    }

    public static /* synthetic */ Map<Integer, String> getSearchData(SearchType a2, String a3) {
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        Map<Integer, String> map = SearchGenerator.getSearchs(a2);
        for (int n2 : map.keySet()) {
            if (!String.valueOf(n2).toLowerCase().contains(a3.toLowerCase()) && !map.get(n2).toLowerCase().contains(a3.toLowerCase())) continue;
            treeMap.put(n2, map.get(n2));
        }
        return treeMap;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String searchData(SearchType a2, String a3) {
        ArrayList<CallSite> arrayList;
        Object object;
        Object object2;
        StringBuilder stringBuilder;
        ArrayList<CallSite> arrayList2;
        block26: {
            Map<Integer, String> map = SearchGenerator.getSearchData(a2, a3);
            arrayList2 = new ArrayList<CallSite>();
            stringBuilder = new StringBuilder();
            switch (a2) {
                case \u9053\u5177: {
                    if (!a3.isEmpty()) {
                        object2 = map.keySet().iterator();
                        while (object2.hasNext()) {
                            object = (Integer)object2.next();
                            if (!MapleItemInformationProvider.getInstance().itemExists((Integer)object)) continue;
                            Object object3 = object;
                            arrayList2.add((CallSite)((Object)("\r\n#L" + (Integer)object3 + "##z" + (Integer)object3 + "# (" + (Integer)object3 + ")#l")));
                        }
                        break;
                    }
                    stringBuilder.append(ItemInformation.ALLATORIxDEMO("NQ\u8a88\u8f63\u5126\u9008\u5134\u5456\u7a72umum"));
                    arrayList = arrayList2;
                    break block26;
                }
                case NPC: {
                    Object object4 = object2 = map.entrySet().iterator();
                    while (object4.hasNext()) {
                        object = (Map.Entry)object2.next();
                        arrayList2.add((CallSite)((Object)("\r\n#L" + object.getKey() + "##p" + object.getKey() + "#(" + object.getKey() + ")#l")));
                        object4 = object2;
                    }
                    break;
                }
                case \u5730\u5716: {
                    Object object5 = object2 = map.keySet().iterator();
                    while (object5.hasNext()) {
                        object = (Integer)object2.next();
                        Iterator iterator = object;
                        arrayList2.add((CallSite)((Object)("\r\n#L" + (Integer)((Object)iterator) + "##m" + (Integer)((Object)iterator) + "#(" + (Integer)((Object)iterator) + ")#l")));
                        object5 = object2;
                    }
                    break;
                }
                case \u602a\u7269: {
                    Object object6 = object2 = map.keySet().iterator();
                    while (object6.hasNext()) {
                        object = (Integer)object2.next();
                        Iterator iterator = object;
                        arrayList2.add((CallSite)((Object)("\r\n#L" + (Integer)((Object)iterator) + "##o" + (Integer)((Object)iterator) + "#(" + (Integer)((Object)iterator) + ")#l")));
                        object6 = object2;
                    }
                    break;
                }
                case \u4efb\u52d9: {
                    Object object7 = object2 = map.entrySet().iterator();
                    while (object7.hasNext()) {
                        object = (Map.Entry)object2.next();
                        arrayList2.add((CallSite)((Object)("\r\n#L" + object.getKey() + "#" + (String)object.getValue() + "(" + object.getKey() + ")#l")));
                        object7 = object2;
                    }
                    break;
                }
                case \u6280\u80fd: {
                    object2 = new ArrayList();
                    Object object8 = object = map.entrySet().iterator();
                    while (object8.hasNext()) {
                        Map.Entry entry = (Map.Entry)object.next();
                        if (!SkillFactory.getSkillName((Integer)entry.getKey()).isEmpty()) {
                            arrayList2.add((CallSite)((Object)("\r\n#L" + entry.getKey() + "##s" + entry.getKey() + "#" + (String)entry.getValue() + "(" + entry.getKey() + ")#l")));
                        }
                        object2.add((Integer)entry.getKey());
                        object8 = object;
                    }
                    Iterator<Object> iterator = object2;
                    Collections.sort(iterator);
                    object = iterator.iterator();
                    while (object.hasNext()) {
                        int n2 = (Integer)object.next();
                        if (n2 / 10000 != 530 && n2 / 10000 != 531 && n2 / 10000 != 532) continue;
                        Object[] arrobject = new Object[1];
                        arrobject[0] = SkillFactory.getSkillName(n2);
                        System.out.println(String.format(SkilledCommand.ALLATORIxDEMO("\u000eV\u001fKX"), arrobject) + n2);
                    }
                    break;
                }
                case \u8077\u696d: {
                    Object object9 = object = map.entrySet().iterator();
                    while (object9.hasNext()) {
                        Map.Entry<Integer, String> entry = object.next();
                        arrayList2.add((CallSite)((Object)("\r\n#L" + entry.getKey() + "#" + entry.getValue() + "(" + entry.getKey() + ")#l")));
                        object9 = object;
                    }
                    break;
                }
                case \u4f3a\u670d\u5668\u5305\u982d: 
                case \u7528\u6236\u7aef\u5305\u982d: {
                    Object object10 = object = map.entrySet().iterator();
                    while (object10.hasNext()) {
                        Map.Entry<Integer, String> entry = object.next();
                        arrayList2.add((CallSite)((Object)("\r\n" + entry.getValue() + " \u503c: " + entry.getKey() + " 16\u9032\u5236: " + HexTool.getOpcodeToString(entry.getKey()))));
                        object10 = object;
                    }
                    break;
                }
                default: {
                    stringBuilder.append(ItemInformation.ALLATORIxDEMO("\u5c4e\u4e56\u8d34wc\u9042\u5048\u6af9\u7d61\u9805\u57c8\u4e56\u88e8\u6574\u63b7"));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList.size() > 0) {
            Object object11 = object2 = arrayList2.iterator();
            while (object11.hasNext()) {
                object = (String)object2.next();
                if (stringBuilder.length() > 35000) {
                    stringBuilder.append(SkilledCommand.ALLATORIxDEMO("&q&q\u5fa7\u9719\u90af\u6772\u5fa3\u5961\u6437\u5c70\u7d7b\u67e7\u0007[\u4f6d\u5d89\u7db8\u715a\u6cfe\u9814\u7911\u668f\u5931"));
                    break;
                }
                stringBuilder.append((String)object);
                object11 = object2;
            }
        }
        object2 = new StringBuilder();
        if (!stringBuilder.toString().isEmpty() && !stringBuilder.toString().equalsIgnoreCase(ItemInformation.ALLATORIxDEMO("\u5c4e\u4e56\u8d34wc\u9042\u5048\u6af9\u7d61\u635c\u4ea7\u4e56\u88e8\u6574\u63b7"))) {
            ((StringBuilder)object2).append(SkilledCommand.ALLATORIxDEMO("G\u0017\u9825\u57a0A\u000b")).append(a2.name()).append(ItemInformation.ALLATORIxDEMO("c'c\u6447\u5c48\u8a51\u602cac")).append(a3).append(SkilledCommand.ALLATORIxDEMO("E\u0015"));
        }
        Object object12 = object2;
        ((StringBuilder)object12).append((CharSequence)stringBuilder);
        if (((StringBuilder)object12).toString().isEmpty()) {
            ((StringBuilder)object2).append(ItemInformation.ALLATORIxDEMO("\u645f\u5c50\u4e4e\u526b\u6b27")).append(a2.name());
        }
        return ((StringBuilder)object2).toString();
    }

    public /* synthetic */ SearchGenerator() {
        SearchGenerator a2;
    }

    public static /* synthetic */ Map<Integer, String> getSearchs(SearchType a4) {
        TreeMap<Integer, String> treeMap = null;
        TreeMap<Integer, String> treeMap2 = new TreeMap();
        switch (1.ALLATORIxDEMO[a4.ordinal()]) {
            case 1: {
                Iterator<ItemInformation> iterator;
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                while (false) {
                }
                Iterator<ItemInformation> iterator2 = iterator = mapleItemInformationProvider.getAllItems().iterator();
                while (iterator2.hasNext()) {
                    ItemInformation itemInformation = iterator.next();
                    iterator2 = iterator;
                    treeMap2.put(itemInformation.itemId, itemInformation.name);
                }
                break;
            }
            case 2: {
                treeMap2 = MapleLifeFactory.getNPCNames();
                break;
            }
            case 3: {
                MapleData mapleData = MapleDataProviderFactory.getDataProvider(ItemInformation.ALLATORIxDEMO("\u0010/12-<m,9")).getData(SkilledCommand.ALLATORIxDEMO("f\u001a[UB\u0016L"));
                for (MapleData mapleData2 : mapleData.getChildren()) {
                    for (MapleData mapleData3 : mapleData2.getChildren()) {
                        if (!StringTool.isNumeric(mapleData3.getName())) continue;
                        treeMap2.put(Integer.parseInt(mapleData3.getName()), "'" + MapleDataTool.getString(mapleData3.getChildByPath(ItemInformation.ALLATORIxDEMO("(7)&>7\u0015\"6&")), SkilledCommand.ALLATORIxDEMO("\u710a\u5476\u7a1a")) + " : " + MapleDataTool.getString(mapleData3.getChildByPath(ItemInformation.ALLATORIxDEMO(".:3\u0015\"6&")), SkilledCommand.ALLATORIxDEMO("\u710a\u5476\u7a1a")) + "'");
                    }
                }
                break;
            }
            case 4: {
                Iterator<Map.Entry<Integer, String>> iterator;
                Iterator<Map.Entry<Integer, String>> iterator3 = iterator = MapleMonsterInformationProvider.getInstance().getAllMonsters().entrySet().iterator();
                while (iterator3.hasNext()) {
                    Map.Entry<Integer, String> entry = iterator.next();
                    treeMap2.put(entry.getKey(), entry.getValue());
                    iterator3 = iterator;
                }
                break;
            }
            case 5: {
                Iterator<MapleQuest> iterator;
                Iterator<MapleQuest> iterator4 = iterator = MapleQuest.getAllInstances().iterator();
                while (iterator4.hasNext()) {
                    MapleQuest mapleQuest = iterator.next();
                    iterator4 = iterator;
                    treeMap2.put(mapleQuest.getId(), mapleQuest.getName());
                }
                break;
            }
            case 6: {
                Iterator<ISkill> iterator;
                Iterator<ISkill> iterator5 = iterator = SkillFactory.getAllSkills().iterator();
                while (iterator5.hasNext()) {
                    ISkill iSkill = iterator.next();
                    iterator5 = iterator;
                    treeMap2.put(iSkill.getId(), iSkill.getName());
                }
                break;
            }
            case 7: {
                int n2;
                MapleJob[] arrmapleJob = MapleJob.values();
                int n3 = arrmapleJob.length;
                int n4 = n2 = 0;
                while (n4 < n3) {
                    MapleJob mapleJob = arrmapleJob[n2];
                    treeMap2.put(mapleJob.getId(), mapleJob.name());
                    n4 = ++n2;
                }
                break;
            }
            case 8: {
                int n5;
                SendPacketOpcode[] arrsendPacketOpcode = SendPacketOpcode.values();
                int n6 = arrsendPacketOpcode.length;
                int n7 = n5 = 0;
                while (n7 < n6) {
                    SendPacketOpcode sendPacketOpcode = arrsendPacketOpcode[n5];
                    treeMap2.put(Integer.valueOf(sendPacketOpcode.getValue()), sendPacketOpcode.name());
                    n7 = ++n5;
                }
                break;
            }
            case 9: {
                int n8;
                RecvPacketOpcode[] arrrecvPacketOpcode = RecvPacketOpcode.values();
                int n9 = arrrecvPacketOpcode.length;
                int n10 = n8 = 0;
                while (n10 < n9) {
                    RecvPacketOpcode recvPacketOpcode = arrrecvPacketOpcode[n8];
                    treeMap2.put(Integer.valueOf(recvPacketOpcode.getValue()), recvPacketOpcode.name());
                    n10 = ++n8;
                }
                break;
            }
            case 10: 
            case 11: {
                Object object;
                if (treeMap == null) {
                    treeMap = new TreeMap<Integer, String>((a2, a3) -> a2.compareTo((Integer)a3));
                    object = MapleItemInformationProvider.getInstance().getAllItems().iterator();
                    Object object2 = object;
                    while (object2.hasNext()) {
                        ItemInformation itemInformation = (ItemInformation)object.next();
                        object2 = object;
                        treeMap.put(itemInformation.itemId, itemInformation.name);
                    }
                    ALLATORIxDEMO.put(SearchType.\u9053\u5177, treeMap);
                }
                object = a4 == SearchType.\u9aee\u578b ? MapleInventoryType.HAIR : MapleInventoryType.FACE;
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (GameConstants.getInventoryType((Integer)entry.getKey()) != object) continue;
                    treeMap2.put((Integer)entry.getKey(), (String)entry.getValue());
                }
                break;
            }
        }
        ALLATORIxDEMO.put(a4, treeMap2);
        return treeMap2;
    }

    public static final class SearchType
    extends Enum<SearchType> {
        private static final /* synthetic */ SearchType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ SearchType \u8077\u696d;
        public static final /* synthetic */ /* enum */ SearchType \u5730\u5716;
        private /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ SearchType \u7528\u6236\u7aef\u5305\u982d;
        public static final /* synthetic */ /* enum */ SearchType \u9053\u5177;
        public static final /* synthetic */ /* enum */ SearchType \u4f3a\u670d\u5668\u5305\u982d;
        public static final /* synthetic */ /* enum */ SearchType \u602a\u7269;
        public static final /* synthetic */ /* enum */ SearchType NPC;
        public static final /* synthetic */ /* enum */ SearchType \u4efb\u52d9;
        public static final /* synthetic */ /* enum */ SearchType \u81c9\u578b;
        public static final /* synthetic */ /* enum */ SearchType \u9aee\u578b;
        public static final /* synthetic */ /* enum */ SearchType \u672a\u77e5;
        public static final /* synthetic */ /* enum */ SearchType \u6280\u80fd;

        public static /* synthetic */ SearchType valueOf(String a2) {
            return Enum.valueOf(SearchType.class, a2);
        }

        public final /* synthetic */ int getValue() {
            SearchType a2;
            return a2.d;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ SearchType(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            SearchType a3;
            a3.d = a2;
        }

        public static /* synthetic */ {
            \u9053\u5177 = new SearchType(SkillType.ALLATORIxDEMO("\u9077\u5144"), 0, 1);
            NPC = new SearchType(MerchItemPackage.ALLATORIxDEMO("z|w"), 1, 2);
            \u5730\u5716 = new SearchType(SkillType.ALLATORIxDEMO("\u5714\u5725"), 2, 3);
            \u602a\u7269 = new SearchType(MerchItemPackage.ALLATORIxDEMO("\u6006\u725d"), 3, 4);
            \u4efb\u52d9 = new SearchType(SkillType.ALLATORIxDEMO("\u4edf\u52ea"), 4, 5);
            \u6280\u80fd = new SearchType(MerchItemPackage.ALLATORIxDEMO("\u62ac\u80c9"), 5, 6);
            \u8077\u696d = new SearchType(SkillType.ALLATORIxDEMO("\u8053\u695e"), 6, 7);
            \u4f3a\u670d\u5668\u5305\u982d = new SearchType(MerchItemPackage.ALLATORIxDEMO("\u4f0e\u6721\u565c\u5329\u9819"), 7, 8);
            \u7528\u6236\u7aef\u5305\u982d = new SearchType(SkillType.ALLATORIxDEMO("\u751b\u6212\u7adc\u5321\u981e"), 8, 9);
            \u9aee\u578b = new SearchType(MerchItemPackage.ALLATORIxDEMO("\u9ac2\u57bf"), 9, 10);
            \u81c9\u578b = new SearchType(SkillType.ALLATORIxDEMO("\u81ed\u57b8"), 10, 11);
            \u672a\u77e5 = new SearchType(MerchItemPackage.ALLATORIxDEMO("\u6706\u77d1"), 11);
            SearchType[] arrsearchType = new SearchType[12];
            arrsearchType[0] = \u9053\u5177;
            arrsearchType[1] = NPC;
            arrsearchType[2] = \u5730\u5716;
            arrsearchType[3] = \u602a\u7269;
            arrsearchType[4] = \u4efb\u52d9;
            arrsearchType[5] = \u6280\u80fd;
            arrsearchType[6] = \u8077\u696d;
            arrsearchType[7] = \u4f3a\u670d\u5668\u5305\u982d;
            arrsearchType[8] = \u7528\u6236\u7aef\u5305\u982d;
            arrsearchType[9] = \u9aee\u578b;
            arrsearchType[10] = \u81c9\u578b;
            arrsearchType[11] = \u672a\u77e5;
            ALLATORIxDEMO = arrsearchType;
        }

        public static /* synthetic */ String nameOf(int a2) {
            int n2;
            SearchType[] arrsearchType = SearchType.values();
            int n3 = arrsearchType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                SearchType searchType = arrsearchType[n2];
                if (searchType.getValue() == a2) {
                    return searchType.name();
                }
                n4 = ++n2;
            }
            return MerchItemPackage.ALLATORIxDEMO("\u6706\u77d1");
        }

        public static /* synthetic */ SearchType[] values() {
            return (SearchType[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ SearchType() {
            void var2_-1;
            void var1_-1;
            SearchType a2;
            a2.d = 0;
        }
    }
}

