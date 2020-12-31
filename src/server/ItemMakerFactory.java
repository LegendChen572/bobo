/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592f\u592f\u8c37
 */
package server;

import client.messages.commands.player.\u592f\u592f\u8c37;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import tools.Pair;
import tools.StringUtil;

public class ItemMakerFactory {
    public /* synthetic */ Map<Integer, ItemMakerCreateEntry> createCache;
    private static final /* synthetic */ ItemMakerFactory ALLATORIxDEMO;
    public /* synthetic */ Map<Integer, GemCreateEntry> gemCache;

    public /* synthetic */ ItemMakerFactory() {
        ItemMakerFactory a2;
        ItemMakerFactory itemMakerFactory = a2;
        a2.createCache = new HashMap<Integer, ItemMakerCreateEntry>();
        itemMakerFactory.gemCache = new HashMap<Integer, GemCreateEntry>();
        System.out.println(StringUtil.ALLATORIxDEMO("\u303a\u8bb1\u53fc\u4e1c\u303b\u0011cEO\\gPATXwKR^^XH\n\u000b\u0010\u000b"));
        Object object = MapleDataProviderFactory.getDataProvider(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"3\u0005\u0015_\u0001\u000b")).getData(StringUtil.ALLATORIxDEMO("cEO\\gPAT\u0004XGV"));
        if (object != null) {
            block4: for (MapleData mapleData : object.getChildren()) {
                switch (Integer.parseInt(mapleData.getName())) {
                    case 0: {
                        int n2;
                        int n3;
                        byte by;
                        int n4;
                        MapleData mapleData2;
                        Iterator<MapleData> iterator;
                        while (false) {
                        }
                        Iterator<MapleData> iterator2 = mapleData.getChildren().iterator();
                        while (iterator2.hasNext()) {
                            mapleData2 = iterator.next();
                            n4 = MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0004\u0014\u0007=\u0013\u0007\u0013\u001d"), mapleData2, 0);
                            by = (byte)MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("CO@yZC]F}OGO]"), mapleData2, 0);
                            n3 = MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u001b\u0014\u0005\u001e"), mapleData2, 0);
                            n2 = MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("X^TG\u007f_\\"), mapleData2, 0);
                            GemCreateEntry gemCreateEntry = new GemCreateEntry(n3, n4, by, n2);
                            for (MapleData mapleData3 : mapleData2.getChildren()) {
                                for (MapleData mapleData4 : mapleData3.getChildren()) {
                                    if (mapleData3.getName().equals(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0004\u0010\u0018\u0015\u0019\u001c$\u0014\u0001\u0010\u0004\u0015"))) {
                                        gemCreateEntry.addRandomReward(MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("CEO\\"), mapleData4, 0), MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0006\u0003\u0019\u0013"), mapleData4, 0));
                                        continue;
                                    }
                                    if (!mapleData3.getName().equals(StringUtil.ALLATORIxDEMO("XTIXZT"))) continue;
                                    gemCreateEntry.addReqRecipe(MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u001f\u0005\u0013\u001c"), mapleData4, 0), MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("REDDE"), mapleData4, 0));
                                }
                            }
                            a2.gemCache.put(Integer.parseInt(mapleData2.getName()), gemCreateEntry);
                            iterator2 = iterator;
                        }
                        continue block4;
                    }
                    case 1: 
                    case 2: 
                    case 4: 
                    case 8: 
                    case 16: {
                        int n2;
                        int n3;
                        byte by;
                        int n4;
                        MapleData mapleData2;
                        Iterator<MapleData> iterator;
                        Iterator<MapleData> iterator3 = mapleData.getChildren().iterator();
                        while (iterator3.hasNext()) {
                            mapleData2 = iterator.next();
                            n4 = MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0004\u0014\u0007=\u0013\u0007\u0013\u001d"), mapleData2, 0);
                            by = (byte)MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("CO@yZC]F}OGO]"), mapleData2, 0);
                            n3 = MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u001b\u0014\u0005\u001e"), mapleData2, 0);
                            n2 = MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("X^TG\u007f_\\"), mapleData2, 0);
                            byte by2 = (byte)MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0005\u0003\u0012"), mapleData2, 0);
                            int n5 = MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("IP^PFHYE"), mapleData2, 0);
                            object = new ItemMakerCreateEntry(n3, n4, by, n2, by2, n5);
                            for (MapleData mapleData3 : mapleData2.getChildren()) {
                                for (MapleData mapleData4 : mapleData3.getChildren()) {
                                    if (!mapleData3.getName().equals(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0004\u0014\u0015\u0018\u0006\u0014"))) continue;
                                    ((ItemMakerCreateEntry)object).addReqItem(MapleDataTool.getInt(StringUtil.ALLATORIxDEMO("CEO\\"), mapleData4, 0), MapleDataTool.getInt(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u0012\u0019\u0004\u0018\u0005"), mapleData4, 0));
                                }
                            }
                            a2.createCache.put(Integer.parseInt(mapleData2.getName()), (ItemMakerCreateEntry)object);
                            iterator3 = iterator;
                        }
                        continue block4;
                    }
                }
            }
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new ItemMakerFactory();
    }

    public /* synthetic */ ItemMakerCreateEntry getCreateInfo(int a2) {
        ItemMakerFactory a3;
        return a3.createCache.get(a2);
    }

    public /* synthetic */ GemCreateEntry getGemInfo(int a2) {
        ItemMakerFactory a3;
        return a3.gemCache.get(a2);
    }

    public static /* synthetic */ ItemMakerFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public static class GemCreateEntry {
        private /* synthetic */ int k;
        private /* synthetic */ List<Pair<Integer, Integer>> ALLATORIxDEMO;
        private /* synthetic */ int K;
        private /* synthetic */ int a;
        private /* synthetic */ List<Pair<Integer, Integer>> d;
        private /* synthetic */ int B;

        public /* synthetic */ List<Pair<Integer, Integer>> getRandomReward() {
            GemCreateEntry a2;
            return a2.d;
        }

        public /* synthetic */ int getCost() {
            GemCreateEntry a2;
            return a2.K;
        }

        public /* synthetic */ int getReqLevel() {
            GemCreateEntry a2;
            return a2.B;
        }

        public /* synthetic */ void addRandomReward(int a2, int a3) {
            GemCreateEntry a4;
            a4.d.add(new Pair<Integer, Integer>(a2, a3));
        }

        public /* synthetic */ int getRewardAmount() {
            GemCreateEntry a2;
            return a2.a;
        }

        public /* synthetic */ int getReqSkillLevel() {
            GemCreateEntry a2;
            return a2.k;
        }

        public /* synthetic */ GemCreateEntry(int a2, int a3, int a4, int a5) {
            GemCreateEntry a6;
            GemCreateEntry gemCreateEntry = a6;
            GemCreateEntry gemCreateEntry2 = a6;
            GemCreateEntry gemCreateEntry3 = a6;
            a6.d = new ArrayList<Pair<Integer, Integer>>();
            gemCreateEntry3.ALLATORIxDEMO = new ArrayList<Pair<Integer, Integer>>();
            gemCreateEntry2.K = a2;
            gemCreateEntry2.B = a3;
            gemCreateEntry.k = a4;
            gemCreateEntry.a = a5;
        }

        public /* synthetic */ void addReqRecipe(int a2, int a3) {
            GemCreateEntry a4;
            a4.ALLATORIxDEMO.add(new Pair<Integer, Integer>(a2, a3));
        }

        public /* synthetic */ List<Pair<Integer, Integer>> getReqRecipes() {
            GemCreateEntry a2;
            return a2.ALLATORIxDEMO;
        }
    }

    public static class ItemMakerCreateEntry {
        private /* synthetic */ List<Integer> ALLATORIxDEMO;
        private /* synthetic */ byte a;
        private /* synthetic */ int g;
        private /* synthetic */ int E;
        private /* synthetic */ byte K;
        private /* synthetic */ List<Pair<Integer, Integer>> d;
        private /* synthetic */ int B;
        private /* synthetic */ int k;

        public /* synthetic */ int getRewardAmount() {
            ItemMakerCreateEntry a2;
            return a2.B;
        }

        public /* synthetic */ int getCost() {
            ItemMakerCreateEntry a2;
            return a2.g;
        }

        public /* synthetic */ ItemMakerCreateEntry(int a2, int a3, byte a4, int a5, byte a6, int a7) {
            ItemMakerCreateEntry a8;
            ItemMakerCreateEntry itemMakerCreateEntry = a8;
            ItemMakerCreateEntry itemMakerCreateEntry2 = a8;
            ItemMakerCreateEntry itemMakerCreateEntry3 = a8;
            ItemMakerCreateEntry itemMakerCreateEntry4 = a8;
            a8.d = new ArrayList<Pair<Integer, Integer>>();
            itemMakerCreateEntry4.ALLATORIxDEMO = new ArrayList<Integer>();
            itemMakerCreateEntry3.g = a2;
            itemMakerCreateEntry3.K = a6;
            itemMakerCreateEntry2.E = a3;
            itemMakerCreateEntry2.a = a4;
            itemMakerCreateEntry.B = a5;
            itemMakerCreateEntry.k = a7;
        }

        public /* synthetic */ byte getTUC() {
            ItemMakerCreateEntry a2;
            return a2.K;
        }

        public /* synthetic */ int getReqLevel() {
            ItemMakerCreateEntry a2;
            return a2.E;
        }

        public /* synthetic */ List<Integer> getReqEquips() {
            ItemMakerCreateEntry a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ byte getReqSkillLevel() {
            ItemMakerCreateEntry a2;
            return a2.a;
        }

        public /* synthetic */ void addReqItem(int a2, int a3) {
            ItemMakerCreateEntry a4;
            a4.d.add(new Pair<Integer, Integer>(a2, a3));
        }

        public /* synthetic */ List<Pair<Integer, Integer>> getReqItems() {
            ItemMakerCreateEntry a2;
            return a2.d;
        }

        public /* synthetic */ int getStimulator() {
            ItemMakerCreateEntry a2;
            return a2.k;
        }
    }
}

