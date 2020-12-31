/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import constants.GameConstants;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.skills.SkillType;
import database.DBConPool;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.MapleItemInformationProvider;
import server.PortalFactory;
import server.Randomizer;
import server.life.AbstractLoadedMapleLife;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleNPC;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleFoothold;
import server.maps.MapleFootholdTree;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleNodes;
import server.maps.MapleReactor;
import server.maps.MapleReactorFactory;
import tools.StringUtil;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleMapFactory {
    private /* synthetic */ int d;
    private final /* synthetic */ Map<Integer, MapleMap> H;
    private static final /* synthetic */ MapleData F;
    private final /* synthetic */ Map<Integer, Integer> K;
    private static final /* synthetic */ Map<Integer, MapleNodes> E;
    private final /* synthetic */ Map<Integer, MapleMap> e;
    private static /* synthetic */ boolean ALLATORIxDEMO;
    private static final /* synthetic */ Map<Integer, List<AbstractLoadedMapleLife>> B;
    private final /* synthetic */ Map<Integer, MapleMap> C;
    private /* synthetic */ int a;
    private static final /* synthetic */ MapleDataProvider I;
    private static final /* synthetic */ Map<Integer, List<AbstractLoadedMapleLife>> k;
    private final /* synthetic */ ReentrantLock g;

    public /* synthetic */ MapleMapFactory(int a2, int a3) {
        MapleMapFactory a4;
        MapleMapFactory mapleMapFactory = a4;
        MapleMapFactory mapleMapFactory2 = a4;
        a4.C = new HashMap<Integer, MapleMap>();
        mapleMapFactory2.H = new HashMap<Integer, MapleMap>();
        a4.e = new HashMap<Integer, MapleMap>();
        a4.g = new ReentrantLock(true);
        a4.K = new HashMap<Integer, Integer>();
        mapleMapFactory.a = a2;
        mapleMapFactory.d = a3;
    }

    private /* synthetic */ String H(int a2) {
        String string = StringUtil.getLeftPaddedStr(Integer.toString(a2), '0', 9);
        StringBuilder stringBuilder = new StringBuilder(SkillType.ALLATORIxDEMO("~EC\u000b~EC"));
        stringBuilder.append(a2 / 100000000);
        stringBuilder.append("/");
        stringBuilder.append(string);
        stringBuilder.append(SkillType.ALLATORIxDEMO("\nZIT"));
        string = stringBuilder.toString();
        return string;
    }

    public /* synthetic */ boolean isInstanceMapLoaded(int a2) {
        MapleMapFactory a3;
        return a3.H.containsKey(a2);
    }

    public /* synthetic */ MapleMap getInstanceMap(int a2) {
        MapleMapFactory a3;
        return a3.H.get(a2);
    }

    public /* synthetic */ void removeGuildMap(int a2) {
        MapleMapFactory a3;
        if (a3.isGuildMapLoaded(a2)) {
            MapleMapFactory mapleMapFactory = a3;
            mapleMapFactory.getGuildMap(a2).checkStates("");
            mapleMapFactory.e.remove(a2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean destroyMap(int a2, boolean a3) {
        MapleMapFactory a4;
        Map<Integer, MapleMap> map = a4.C;
        synchronized (map) {
            Map<Integer, MapleMap> map2;
            boolean bl;
            if (!a4.C.containsKey(a2)) return false;
            if (a3) {
                a4.K.put(a2, 0);
                a4.C.remove(a2);
            }
            if (a4.C.remove(a2) != null) {
                bl = true;
                map2 = map;
            } else {
                bl = false;
                map2 = map;
            }
            // ** MonitorExit[v1] (shouldn't be in output)
            return bl;
        }
    }

    public /* synthetic */ boolean destroyMap(int a2) {
        MapleMapFactory a3;
        return a3.destroyMap(a2, false);
    }

    public /* synthetic */ void clearLoadedMap() {
        MapleMapFactory a2;
        a2.C.clear();
    }

    public /* synthetic */ MapleMap getGuildMap(int a2) {
        MapleMapFactory a3;
        return a3.e.get(a2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ MapleMap getMap(int a, boolean a, boolean a, boolean a) {
        var5_9 = a;
        var6_10 = a.C.get(var5_9);
        if (var6_10 != null) ** GOTO lbl254
        a.g.lock();
        try {
            block66: {
                if (a.K.get(var5_9) != null) {
                    var7_11 = null;
                    return var7_11;
                }
                var6_10 = a.C.get(var5_9);
                if (var6_10 != null) {
                    var7_12 = var6_10;
                    return var7_12;
                }
                var7_13 = MapleMapFactory.I.getData(a.H(a));
                if (var7_13 == null) {
                    System.out.println("\u5730\u5716\u4ee3\u78bc:" + a + " \u4e0d\u5b58\u5728!");
                    var8_15 = null;
                    return var8_15;
                }
                var8_16 = var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cHZJX"));
                if (var8_16 != null) {
                    var7_13 = MapleMapFactory.I.getData(a.H(MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("ZJUK\u001cHZJX"), var7_13)));
                }
                var9_18 = 0.0f;
                if (a && (var10_20 = var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b^KQvRPV"))) != null) {
                    var9_18 = ((Float)var10_20.getData()).floatValue();
                }
                var10_21 = MapleDataTool.getInt(SkillType.ALLATORIxDEMO("M]B\\\u000bAAGQAJ~EC"), var7_13);
                if (MapConstants.isPVPMap(a)) {
                    var10_21 = 960000000;
                }
                v0 = a;
                var6_10 = new MapleMap(a, v0.a, v0.d, var10_21, var9_18);
                var11_23 = new PortalFactory();
                v1 = var12_25 = var7_13.getChildByPath(SkillType.ALLATORIxDEMO("T\\VGE_")).iterator();
                while (v1.hasNext()) {
                    a = (MapleData)var12_25.next();
                    v1 = var12_25;
                    var6_10.addPortal(var11_23.makePortal(MapleDataTool.getInt(a.getChildByPath(SkillType.ALLATORIxDEMO("TG"))), a));
                }
                v2 = var7_13;
                v3 = var6_10;
                v3.setTop(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bevgKC")), 0));
                v3.setLeft(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001crahVBG")), 0));
                var6_10.setBottom(MapleDataTool.getInt(v2.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001craf\\PGK^")), 0));
                var6_10.setRight(MapleDataTool.getInt(v2.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bevaMTLG")), 0));
                var12_25 = new LinkedList<E>();
                a = new Point();
                var13_27 = new Point();
                for (Object var16_31 : var7_13.getChildByPath(SkillType.ALLATORIxDEMO("B\\KGL\\HW"))) {
                    var17_33 = var16_31.iterator();
                    while (var17_33.hasNext()) {
                        var18_34 = (MapleData)var17_33.next();
                        v4 = var18_34.iterator();
                        while (v4.hasNext()) {
                            var20_37 = (MapleData)var19_35.next();
                            var14_30 = new MapleFoothold(new Point(MapleDataTool.getInt(var20_37.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0002"))), MapleDataTool.getInt(var20_37.getChildByPath(SkillType.ALLATORIxDEMO("]\u0002")))), new Point(MapleDataTool.getInt(var20_37.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0001"))), MapleDataTool.getInt(var20_37.getChildByPath(SkillType.ALLATORIxDEMO("]\u0001")))), Integer.parseInt(var20_37.getName()));
                            v5 = var14_30;
                            v5.setPrev((short)MapleDataTool.getInt(var20_37.getChildByPath(SkillType.ALLATORIxDEMO("TAAE"))));
                            v5.setNext((short)MapleDataTool.getInt(var20_37.getChildByPath(SkillType.ALLATORIxDEMO("JV\\G"))));
                            if (v5.getX1() < a.x) {
                                a.x = var14_30.getX1();
                            }
                            if (var14_30.getX2() > var13_27.x) {
                                var13_27.x = var14_30.getX2();
                            }
                            if (var14_30.getY1() < a.y) {
                                a.y = var14_30.getY1();
                            }
                            if (var14_30.getY2() > var13_27.y) {
                                var13_27.y = var14_30.getY2();
                            }
                            var12_25.add(var14_30);
                            v4 = var19_35;
                        }
                    }
                }
                var15_29 = new MapleFootholdTree((Point)a, (Point)var13_27);
                v6 = var16_31 = var12_25.iterator();
                while (v6.hasNext()) {
                    var17_33 = (MapleFoothold)var16_31.next();
                    v6 = var16_31;
                    var15_29.insert((MapleFoothold)var17_33);
                }
                v7 = var6_10;
                v7.setFootholds((MapleFootholdTree)var15_29);
                if (v7.getTop() == 0) {
                    var6_10.setTop(a.y);
                }
                if (var6_10.getBottom() == 0) {
                    var6_10.setBottom(var13_27.y);
                }
                if (var6_10.getLeft() == 0) {
                    var6_10.setLeft(a.x);
                }
                if (var6_10.getRight() == 0) {
                    var6_10.setRight(var13_27.x);
                }
                var16_32 = -1;
                var17_33 = null;
                if (a != 749020900 && var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A~KQ")) != null) {
                    v8 = var7_13;
                    var16_32 = MapleDataTool.getInt(v8.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cPZIVi\\F\u001cMW")), 0);
                    var17_33 = MapleDataTool.getString(v8.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A~KQ\u000b^A@WRCV")), null);
                }
                var18_34 = new ArrayList<E>();
                var19_36 = 200;
                var20_38 = 0;
                for (Object var21_39 : var7_13.getChildByPath(SkillType.ALLATORIxDEMO("HZBV"))) {
                    a = MapleDataTool.getString(var21_39.getChildByPath(SkillType.ALLATORIxDEMO("PJTV")));
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        var13_27 = MapleDataTool.getString(SkillType.ALLATORIxDEMO("_M^MGAWJRIV"), (MapleData)var21_39, "");
                        if (a == 0 && a.equals(SkillType.ALLATORIxDEMO("]")) || var13_27.equals(SkillType.ALLATORIxDEMO("wGETA\u0003"))) continue;
                        v9 = var21_39;
                        var14_30 = a.ALLATORIxDEMO((MapleData)v9, MapleDataTool.getString(v9.getChildByPath(SkillType.ALLATORIxDEMO("MW"))), (String)a);
                        if (var14_30 instanceof MapleMonster && !GameConstants.isNoSpawn(a)) {
                            v10 = var22_41 = (MapleMonster)var14_30;
                            var18_34.add((Point)var6_10.addMonsterSpawn(v10, MapleDataTool.getInt(SkillType.ALLATORIxDEMO("^KQpZIV"), (MapleData)var21_39, 0), (byte)MapleDataTool.getInt(SkillType.ALLATORIxDEMO("PVE^"), (MapleData)var21_39, -1), (String)(v10.getId() == var16_32 ? var17_33 : null)).getPosition());
                            if (var22_41.getStats().getLevel() > var20_38 && !var22_41.getStats().isBoss()) {
                                var20_38 = var22_41.getStats().getLevel();
                            }
                            if (var22_41.getStats().getLevel() >= var19_36 || var22_41.getStats().isBoss()) continue;
                            var19_36 = var22_41.getStats().getLevel();
                            continue;
                        }
                        if (!(var14_30 instanceof MapleNPC)) continue;
                        var6_10.addMapObject((MapleMapObject)var14_30);
                        continue;
                    }
                    if (a == 0 && a.equals(SkillType.ALLATORIxDEMO("]"))) continue;
                    v11 = var21_39;
                    var14_30 = a.ALLATORIxDEMO((MapleData)v11, MapleDataTool.getString(v11.getChildByPath(SkillType.ALLATORIxDEMO("MW"))), (String)a);
                    if (var14_30 instanceof MapleMonster) {
                        v12 = var22_42 = (MapleMonster)var14_30;
                        var6_10.addMonsterSpawn(v12, MapleDataTool.getInt(SkillType.ALLATORIxDEMO("^KQpZIV"), (MapleData)var21_39, 0), (byte)MapleDataTool.getInt(SkillType.ALLATORIxDEMO("PVE^"), (MapleData)var21_39, -1), (String)(v12.getId() == var16_32 ? var17_33 : null));
                        var6_10.addSpawnPoint(var22_42.getPosition());
                        continue;
                    }
                    if (var14_30 == null || MapleLifeFactory.getNPC(var14_30.getId()) == null) continue;
                    var6_10.addMapObject((MapleMapObject)var14_30);
                }
                var15_29 = MapleMapFactory.B.get(a);
                if (var15_29 == null) break block66;
                block32: for (AbstractLoadedMapleLife var22_44 : var15_29) {
                    block67: {
                        if (MapleLifeFactory.getNPC(var22_44.getId()) == null) continue;
                        a = var22_44.getCType();
                        a = -1;
                        switch (a.hashCode()) {
                            case 110: {
                                if (!a.equals(SkillType.ALLATORIxDEMO("]"))) break;
                                v13 = a = 0;
                                break block67;
                            }
                            case 109: {
                                if (!a.equals(SkillType.ALLATORIxDEMO("^"))) break;
                                a = 1;
                            }
                        }
                        v13 = a;
                    }
                    switch (v13) {
                        case 0: {
                            var6_10.addMapObject(var22_44);
                            continue block32;
                        }
                        case 1: {
                            var13_27 = (MapleMonster)var22_44;
                            var6_10.addMonsterSpawn((MapleMonster)var13_27, var22_44.getMTime(), (byte)-1, null);
                            continue block32;
                        }
                    }
                }
            }
            a.ALLATORIxDEMO(var6_10);
            v14 = var6_10;
            v15 = var6_10;
            var6_10.setCreateMobInterval((short)MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPVVEGA~KQm]PVVEE_")), 9000));
            v15.loadMonsterRate(true);
            v15.setNodes(a.ALLATORIxDEMO(a, var7_13));
            v14.setFirstUserEnter(MapleDataTool.getString(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cK]bZV@PfWVVvJGAA")), ""));
            v14.setUserEnter(a == 180000002 ? SkillType.ALLATORIxDEMO("NRM_") : MapleDataTool.getString(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b\\JfWVVvJGAA")), ""));
            if (a && var7_13.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKA")) != null) {
                for (Object a : var7_13.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKA"))) {
                    var21_39 = MapleDataTool.getString(a.getChildByPath(SkillType.ALLATORIxDEMO("MW")));
                    if (var21_39 == null) continue;
                    v16 = a;
                    var6_10.spawnReactor(a.ALLATORIxDEMO((MapleData)v16, (String)var21_39, (byte)MapleDataTool.getInt(v16.getChildByPath(SkillType.ALLATORIxDEMO("U")), 0), var6_10.getWorld()));
                }
            }
            if (GameSetConstants.MAPLE_VERSION >= 134 && a && var18_34.size() > 0 && var20_38 >= 30 && var6_10.getFirstUserEnter().equals("") && var6_10.getUserEnter().equals("")) {
                var22_47 = new ArrayList<Integer>(24);
                var22_47.add(100011);
                var22_47.add(200011);
                if (var20_38 < 100) {
                    v17 = a = var19_36 % 10 > var20_38 % 10 ? 0 : var19_36 % 10;
                    while (v17 < var20_38 % 10) {
                        v18 = a = 0;
                        while (v18 < 4) {
                            var22_47.add(100000 + a);
                            var22_47.add(200000 + a);
                            v18 = ++a;
                        }
                        v17 = ++a;
                    }
                } else {
                    v19 = a = 0;
                    while (v19 < 10) {
                        v20 = a = 0;
                        while (v20 < 4) {
                            var22_47.add(100000 + a);
                            var22_47.add(200000 + a);
                            v20 = ++a;
                        }
                        v19 = ++a;
                    }
                }
                a = Randomizer.nextInt(var22_47.size()) / 6;
                v21 = a = 0;
                while (v21 < a && !var18_34.isEmpty()) {
                    v22 = var22_47;
                    var13_28 = (Integer)v22.get(Randomizer.nextInt(v22.size()));
                    a = Randomizer.nextInt(var18_34.size());
                    var14_30 = new MapleReactor(MapleReactorFactory.getReactor(var13_28), var13_28, var6_10.getWorld());
                    var14_30.setPosition((Point)var18_34.get((int)a));
                    var14_30.setDelay(var13_28 % 100 == 11 ? 3600000 : 300000);
                    var6_10.spawnReactor((MapleReactor)var14_30);
                    var18_34.remove((int)a);
                    v21 = ++a;
                }
            }
            try {
                var6_10.setMapName(MapleItemInformationProvider.getInstance().getMapName(a).isEmpty() != false ? MapleDataTool.getString(SkillType.ALLATORIxDEMO("^ECjRIV"), MapleMapFactory.F.getChildByPath(a.ALLATORIxDEMO(var5_9)), "") : MapleItemInformationProvider.getInstance().getMapName(a));
                var6_10.setStreetName(MapleItemInformationProvider.getInstance().getStreetName(a).isEmpty() != false ? MapleDataTool.getString(SkillType.ALLATORIxDEMO("WGVVAGjRIV"), MapleMapFactory.F.getChildByPath(a.ALLATORIxDEMO(var5_9)), "") : MapleItemInformationProvider.getInstance().getStreetName(a));
                v23 = var6_10;
            }
            catch (Exception var22_48) {
                v24 = var6_10;
                v23 = v24;
                v24.setMapName("");
                v24.setStreetName("");
            }
            v23.setClock(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("PH\\GX")) != null);
            var6_10.setEverlast(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cAEAAHRWG")), 0) > 0);
            var6_10.setTown(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cP\\S]")), 0) > 0);
            var6_10.setSoaring(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b]AV@`OZH_b\\VuHJ")), 0) > 0);
            var6_10.setPersonalShop(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cTVV@K]E_w[KC")), 0) > 0);
            var6_10.setForceMove(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b_RuKAGVi\\RV")), 0));
            if (a != 749020900) {
                var6_10.setHPDec(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bWAPlc")), 0));
            }
            v25 = var7_13;
            var6_10.setHPDecInterval(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bWAPlcm]PVVEE_")), 10000));
            var6_10.setHPDecProtect(MapleDataTool.getInt(v25.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bCV\\PVGGmGA^")), 0));
            var6_10.setBoat(v25.getChildByPath(SkillType.ALLATORIxDEMO("@LZT|FY")) != null);
            var6_10.setForcedReturnMap(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cB\\VPAWvVPFV]")), 999999999));
            if (MapConstants.isPVPMap(a)) {
                var6_10.setForcedReturnMap(960000000);
            }
            v26 = var6_10;
            v27 = var7_13;
            v28 = var6_10;
            v28.setTimeLimit(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A\u007fM^MG")), -1));
            v28.setFieldLimit(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cBZA_@\u007fM^MG")), 0));
            var6_10.setRecoveryRate(MapleDataTool.getFloat(v27.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cVVG\\RVVJ")), 1.0f));
            v26.setFixedMob(MapleDataTool.getInt(v27.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cBZ\\V@~KQgRTRGZPJ")), 0));
            v26.setConsumeItemCoolTime(MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPK]WFIVmGA^g\\K_pZIV")), 0));
            var6_10.setPartyBonusRate(GameConstants.getPartyPlay(a, MapleDataTool.getInt(var7_13.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bCEAPJf\\JFWa")), 0)));
            a.C.put(var5_9, var6_10);
            return var6_10;
lbl254:
            // 1 sources

            if (MapleMapFactory.ALLATORIxDEMO == false) return var6_10;
            var7_14 = MapleMapFactory.B.get(a);
            if (var7_14 == null) return var6_10;
            var8_17 = var7_14.iterator();
        }
        finally {
            a.g.unlock();
        }
        block39: while (var8_17.hasNext() != false) {
            block68: {
                var9_19 = var8_17.next();
                var10_22 = var9_19.getCType();
                var11_24 = -1;
                switch (var10_22.hashCode()) {
                    case 110: {
                        if (!var10_22.equals(SkillType.ALLATORIxDEMO("]"))) break;
                        v29 = var11_24 = 0;
                        break block68;
                    }
                    case 109: {
                        if (!var10_22.equals(SkillType.ALLATORIxDEMO("^"))) break;
                        var11_24 = 1;
                    }
                }
                v29 = var11_24;
            }
            switch (v29) {
                case 0: {
                    var6_10.addMapObject(var9_19);
                    continue block39;
                }
                case 1: {
                    var12_26 = (MapleMonster)var9_19;
                    var6_10.addMonsterSpawn(var12_26, var9_19.getMTime(), (byte)-1, null);
                    continue block39;
                }
            }
        }
        return var6_10;
    }

    public /* synthetic */ boolean isGuildMapLoaded(int a2) {
        MapleMapFactory a3;
        return a3.e.containsKey(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ MapleReactor ALLATORIxDEMO(MapleData a, String a, byte a, int a) {
        var5_6 = MapleReactorFactory.getReactor(Integer.parseInt(a));
        a = new MapleReactor(var5_6, Integer.parseInt(a), a);
        var6_7 = MapleDataTool.getInt(a.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKApZIV")));
        if (GameSetConstants.MAPLE_VERSION < 134) ** GOTO lbl-1000
        switch (Integer.parseInt(a)) {
            case 3102000: {
                var6_7 = 30;
                v0 = var5_6;
                break;
            }
            case 2202003: {
                var6_7 = -1;
            }
            default: lbl-1000:
            // 2 sources

            {
                v0 = var5_6;
            }
        }
        v0.setFacingDirection(a);
        v1 = a;
        v2 = a;
        v3 = a;
        v2.setPosition(new Point(MapleDataTool.getInt(a.getChildByPath(SkillType.ALLATORIxDEMO("K"))), MapleDataTool.getInt(a.getChildByPath(SkillType.ALLATORIxDEMO("J")))));
        v2.setDelay(var6_7 * 1000);
        v1.setState((byte)0);
        v1.setName(MapleDataTool.getString(a.getChildByPath(SkillType.ALLATORIxDEMO("JRIV")), ""));
        return v1;
    }

    public /* synthetic */ MapleMap CreateInstanceMap(int a2, boolean a3322, boolean a4, boolean a5, int a6, int a7) {
        MapleMap mapleMap;
        Object object;
        AbstractLoadedMapleLife abstractLoadedMapleLife;
        Object object2;
        Object object3;
        Iterator iterator2;
        Object object4;
        Object object5;
        MapleMapFactory a8;
        if (a8.isInstanceMapLoaded((int)a6)) {
            return a8.getInstanceMap((int)a6);
        }
        MapleData mapleData = I.getData(a8.H(a2));
        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cHZJX")) != null) {
            mapleData = I.getData(a8.H(MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("ZJUK\u001cHZJX"), mapleData)));
        }
        float f2 = 0.0f;
        if (a3322 && (a3322 = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b^KQvRPV"))) != null) {
            f2 = ((Float)a3322.getData()).floatValue();
        }
        int a3322 = MapleDataTool.getInt(SkillType.ALLATORIxDEMO("M]B\\\u000bAAGQAJ~EC"), mapleData);
        if (MapConstants.isPVPMap(a2)) {
            a3322 = 960000000;
        }
        MapleMapFactory mapleMapFactory = a8;
        MapleMap a3322 = new MapleMap(a2, mapleMapFactory.a, mapleMapFactory.d, a3322, f2);
        Object object62 = new PortalFactory();
        Object object7 = object5 = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("T\\VGE_")).iterator();
        while (object7.hasNext()) {
            object4 = (MapleData)object5.next();
            object7 = object5;
            a3322.addPortal(((PortalFactory)object62).makePortal(MapleDataTool.getInt(object4.getChildByPath(SkillType.ALLATORIxDEMO("TG"))), (MapleData)object4));
        }
        MapleData mapleData2 = mapleData;
        MapleMap mapleMap2 = a3322;
        mapleMap2.setTop(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bevgKC")), 0));
        mapleMap2.setLeft(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001crahVBG")), 0));
        a3322.setBottom(MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001craf\\PGK^")), 0));
        a3322.setRight(MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bevaMTLG")), 0));
        object5 = new LinkedList();
        object4 = new Point();
        object62 = new Point();
        for (Iterator iterator2 : mapleData.getChildByPath(SkillType.ALLATORIxDEMO("B\\KGL\\HW"))) {
            object3 = iterator2.iterator();
            while (object3.hasNext()) {
                object2 = (MapleData)object3.next();
                Object object8 = object2.iterator();
                while (object8.hasNext()) {
                    Iterator iterator3;
                    object = (MapleData)abstractLoadedMapleLife.next();
                    Iterator iterator4 = iterator3 = new MapleFoothold(new Point(MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0002"))), MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("]\u0002")))), new Point(MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0001"))), MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("]\u0001")))), Integer.parseInt(object.getName()));
                    ((MapleFoothold)((Object)iterator4)).setPrev((short)MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("TAAE"))));
                    ((MapleFoothold)((Object)iterator4)).setNext((short)MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("JV\\G"))));
                    if (((MapleFoothold)((Object)iterator4)).getX1() < ((Point)object4).x) {
                        ((Point)object4).x = ((MapleFoothold)((Object)iterator3)).getX1();
                    }
                    if (((MapleFoothold)((Object)iterator3)).getX2() > ((Point)object62).x) {
                        ((Point)object62).x = ((MapleFoothold)((Object)iterator3)).getX2();
                    }
                    if (((MapleFoothold)((Object)iterator3)).getY1() < ((Point)object4).y) {
                        ((Point)object4).y = ((MapleFoothold)((Object)iterator3)).getY1();
                    }
                    if (((MapleFoothold)((Object)iterator3)).getY2() > ((Point)object62).y) {
                        ((Point)object62).y = ((MapleFoothold)((Object)iterator3)).getY2();
                    }
                    object5.add(iterator3);
                    object8 = abstractLoadedMapleLife;
                }
            }
        }
        MapleFootholdTree mapleFootholdTree = new MapleFootholdTree((Point)object4, (Point)object62);
        Iterator iterator5 = iterator2 = object5.iterator();
        while (iterator5.hasNext()) {
            object3 = (MapleFoothold)iterator2.next();
            iterator5 = iterator2;
            mapleFootholdTree.insert((MapleFoothold)object3);
        }
        MapleMap mapleMap3 = a3322;
        mapleMap3.setFootholds(mapleFootholdTree);
        if (mapleMap3.getTop() == 0) {
            a3322.setTop(((Point)object4).y);
        }
        if (a3322.getBottom() == 0) {
            a3322.setBottom(((Point)object62).y);
        }
        if (a3322.getLeft() == 0) {
            a3322.setLeft(((Point)object4).x);
        }
        if (a3322.getRight() == 0) {
            a3322.setRight(((Point)object62).x);
        }
        Iterator iterator6 = iterator2 = object5.iterator();
        while (iterator6.hasNext()) {
            object3 = (MapleFoothold)iterator2.next();
            iterator6 = iterator2;
            mapleFootholdTree.insert((MapleFoothold)object3);
        }
        a3322.setFootholds(mapleFootholdTree);
        int n2 = -1;
        object3 = null;
        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A~KQ")) != null) {
            MapleData mapleData3 = mapleData;
            n2 = MapleDataTool.getInt(mapleData3.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cPZIVi\\F\u001cMW")), 0);
            object3 = MapleDataTool.getString(mapleData3.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A~KQ\u000b^A@WRCV")), null);
        }
        for (Iterator iterator3 : mapleData.getChildByPath(SkillType.ALLATORIxDEMO("HZBV"))) {
            object2 = MapleDataTool.getString(iterator3.getChildByPath(SkillType.ALLATORIxDEMO("PJTV")));
            if (a4 == false && ((String)object2).equals(SkillType.ALLATORIxDEMO("]"))) continue;
            Iterator iterator7 = iterator3;
            abstractLoadedMapleLife = a8.ALLATORIxDEMO((MapleData)((Object)iterator7), MapleDataTool.getString(iterator7.getChildByPath(SkillType.ALLATORIxDEMO("MW"))), (String)object2, (int)a7);
            if (abstractLoadedMapleLife instanceof MapleMonster) {
                object62 = (MapleMonster)abstractLoadedMapleLife;
                if (a7 != 1110101) {
                    Object object9 = object62;
                    a3322.addMonsterSpawn((MapleMonster)object9, MapleDataTool.getInt(SkillType.ALLATORIxDEMO("^KQpZIV"), iterator3, 0), (byte)MapleDataTool.getInt(SkillType.ALLATORIxDEMO("PVE^"), iterator3, -1), (String)(((AbstractLoadedMapleLife)object9).getId() == n2 ? object3 : null));
                }
                a3322.addSpawnPoint(((AbstractMapleMapObject)object62).getPosition());
                continue;
            }
            a3322.addMapObject(abstractLoadedMapleLife);
        }
        a8.ALLATORIxDEMO(a3322);
        MapleMap mapleMap4 = a3322;
        a3322.setCreateMobInterval((short)MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPVVEGA~KQm]PVVEE_")), 9000));
        mapleMap4.loadMonsterRate(true);
        mapleMap4.setNodes(a8.ALLATORIxDEMO(a2, mapleData));
        if (a5 != false && mapleData.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKA")) != null) {
            for (Object object62 : mapleData.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKA"))) {
                object = MapleDataTool.getString(object62.getChildByPath(SkillType.ALLATORIxDEMO("MW")));
                if (object == null) continue;
                Object object10 = object62;
                a3322.spawnReactor(a8.ALLATORIxDEMO((MapleData)object10, (String)object, (byte)MapleDataTool.getInt(object10.getChildByPath(SkillType.ALLATORIxDEMO("U")), 0), a3322.getWorld()));
            }
        }
        try {
            a3322.setMapName(MapleItemInformationProvider.getInstance().getMapName(a2).isEmpty() ? MapleDataTool.getString(SkillType.ALLATORIxDEMO("^ECjRIV"), F.getChildByPath(a8.ALLATORIxDEMO(a2)), "") : MapleItemInformationProvider.getInstance().getMapName(a2));
            a3322.setStreetName(MapleItemInformationProvider.getInstance().getStreetName(a2).isEmpty() ? MapleDataTool.getString(SkillType.ALLATORIxDEMO("WGVVAGjRIV"), F.getChildByPath(a8.ALLATORIxDEMO(a2)), "") : MapleItemInformationProvider.getInstance().getStreetName(a2));
            mapleMap = a3322;
        }
        catch (Exception exception) {
            MapleMap mapleMap5 = a3322;
            mapleMap = mapleMap5;
            mapleMap5.setMapName("");
            mapleMap5.setStreetName("");
        }
        mapleMap.setClock(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPH\\GX")), 0) > 0);
        a3322.setEverlast(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cAEAAHRWG")), 0) > 0);
        a3322.setTown(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cP\\S]")), 0) > 0);
        a3322.setSoaring(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b]AV@`OZH_b\\VuHJ")), 0) > 0);
        MapleMap mapleMap6 = a3322;
        MapleData mapleData4 = mapleData;
        MapleMap mapleMap7 = a3322;
        mapleMap7.setForceMove(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b_RuKAGVi\\RV")), 0));
        mapleMap7.setHPDec(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bWAPlc")), 0));
        a3322.setHPDecInterval(MapleDataTool.getInt(mapleData4.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bWAPlcm]PVVEE_")), 10000));
        mapleMap6.setHPDecProtect(MapleDataTool.getInt(mapleData4.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bCV\\PVGGmGA^")), 0));
        mapleMap6.setForcedReturnMap(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cB\\VPAWvVPFV]")), 999999999));
        if (MapConstants.isPVPMap(a2)) {
            a3322.setForcedReturnMap(960000000);
        }
        MapleMap mapleMap8 = a3322;
        MapleData mapleData5 = mapleData;
        MapleMap mapleMap9 = a3322;
        MapleData mapleData6 = mapleData;
        MapleMap mapleMap10 = a3322;
        mapleMap10.setTimeLimit(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A\u007fM^MG")), -1));
        mapleMap10.setFieldLimit(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cBZA_@\u007fM^MG")), 0));
        a3322.setFirstUserEnter(MapleDataTool.getString(mapleData6.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cK]bZV@PfWVVvJGAA")), ""));
        mapleMap9.setUserEnter(MapleDataTool.getString(mapleData6.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b\\JfWVVvJGAA")), ""));
        mapleMap9.setRecoveryRate(MapleDataTool.getFloat(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cVVG\\RVVJ")), 1.0f));
        a3322.setFixedMob(MapleDataTool.getInt(mapleData5.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cBZ\\V@~KQgRTRGZPJ")), 0));
        mapleMap8.setConsumeItemCoolTime(MapleDataTool.getInt(mapleData5.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPK]WFIVmGA^g\\K_pZIV")), 0));
        mapleMap8.setPartyBonusRate(GameConstants.getPartyPlay(a2, MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bCEAPJf\\JFWa")), 0)));
        a8.H.put((int)a6, a3322);
        return a3322;
    }

    public final /* synthetic */ MapleMap getMap(int a2) {
        MapleMapFactory a3;
        MapleMapFactory mapleMapFactory = a3;
        return mapleMapFactory.handleSpecialMap(mapleMapFactory.getMap(a2, true, true, true));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void HealMap(int a2) {
        MapleMapFactory a3;
        Map<Integer, MapleMap> map = a3.C;
        synchronized (map) {
            if (a3.K.containsKey(a2)) {
                a3.K.remove(a2);
            }
            return;
        }
    }

    public /* synthetic */ MapleMap handleSpecialMap(MapleMap a2) {
        if (GameSetConstants.UNDER_CITY && a2.getId() >= 100020100 && a2.getId() <= 100020129) {
            MapleMap mapleMap = a2;
            MapleMap mapleMap2 = a2;
            MapleMap mapleMap3 = a2;
            mapleMap3.resetFully();
            mapleMap3.closeDrops();
            mapleMap3.closeGDrops();
            mapleMap2.addMapDrop(4031466, 20000);
            mapleMap2.addMapDrop(2022431, 50000);
            mapleMap.addMapDrop(2022432, 50000);
            mapleMap.addMapDrop(2022433, 50000);
        }
        return a2;
    }

    private /* synthetic */ AbstractLoadedMapleLife ALLATORIxDEMO(MapleData a2, String a3, String a4, int a5) {
        String string;
        int n2;
        if (a5 == 0 || ((String)a4).equals(SkillType.ALLATORIxDEMO("]"))) {
            n2 = Integer.parseInt((String)a3);
            string = a4;
        } else {
            n2 = a5;
            string = a4;
        }
        a3 = MapleLifeFactory.getLife(n2, string);
        if (a3 == null) {
            return null;
        }
        ((AbstractLoadedMapleLife)a3).setCy(MapleDataTool.getInt(a2.getChildByPath(SkillType.ALLATORIxDEMO("GJ"))));
        a4 = a2.getChildByPath(SkillType.ALLATORIxDEMO("U"));
        if (a4 != null) {
            ((AbstractLoadedMapleLife)a3).setF(MapleDataTool.getInt((MapleData)a4));
        }
        Object object = a3;
        MapleData mapleData = a2;
        ((AbstractAnimatedMapleMapObject)a3).setFh(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("B["))));
        ((AbstractLoadedMapleLife)object).setRx0(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("A\\\u0003"))));
        ((AbstractLoadedMapleLife)object).setRx1(MapleDataTool.getInt(a2.getChildByPath(SkillType.ALLATORIxDEMO("A\\\u0002"))));
        Object object2 = a3;
        ((AbstractMapleMapObject)a3).setPosition(new Point(MapleDataTool.getInt(a2.getChildByPath(SkillType.ALLATORIxDEMO("K"))), MapleDataTool.getInt(a2.getChildByPath(SkillType.ALLATORIxDEMO("J")))));
        if (MapleDataTool.getInt(SkillType.ALLATORIxDEMO("LZ@V"), a2, 0) == 1 && a3 instanceof MapleNPC) {
            ((AbstractLoadedMapleLife)a3).setHide(true);
        }
        return a3;
    }

    public /* synthetic */ Collection<MapleMap> getAllInstanceMaps() {
        MapleMapFactory a2;
        return a2.H.values();
    }

    public /* synthetic */ Collection<MapleMap> getAllMapThreadSafe() {
        MapleMapFactory a2;
        ArrayList<MapleMap> arrayList = new ArrayList<MapleMap>();
        MapleMapFactory mapleMapFactory = a2;
        arrayList.addAll(mapleMapFactory.C.values());
        if (!mapleMapFactory.e.isEmpty()) {
            arrayList.addAll(a2.e.values());
        }
        return arrayList;
    }

    public /* synthetic */ int getLoadedMaps() {
        MapleMapFactory a2;
        return a2.C.size();
    }

    public /* synthetic */ void setChannel(int a2) {
        a.d = a2;
    }

    public /* synthetic */ void removeInstanceMap(int a2) {
        MapleMapFactory a3;
        if (a3.isInstanceMapLoaded(a2)) {
            MapleMapFactory mapleMapFactory = a3;
            mapleMapFactory.getInstanceMap(a2).checkStates("");
            mapleMapFactory.H.remove(a2);
        }
    }

    public final /* synthetic */ MapleMap getMap(int a2, boolean a3, boolean a4) {
        MapleMapFactory a5;
        MapleMapFactory mapleMapFactory = a5;
        return mapleMapFactory.handleSpecialMap(mapleMapFactory.getMap(a2, a3, a4, true));
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleMap a2) {
        int n2;
        int n3 = -1;
        int n4 = -1;
        String string = null;
        Point point = null;
        Point point2 = null;
        Point point3 = null;
        boolean bl = false;
        boolean bl2 = false;
        switch (a2.getId()) {
            case 104000400: {
                n4 = 2700;
                n3 = 2220000;
                string = SkillType.ALLATORIxDEMO("\u7d36\u5bd2\u73b8\u51de\u73cd\u4ea2\uff32");
                point = new Point(439, 185);
                point2 = new Point(301, -85);
                point3 = new Point(107, -355);
                n2 = n3;
                break;
            }
            case 101030404: {
                n4 = 2700;
                n3 = 3220000;
                string = SkillType.ALLATORIxDEMO("\u6a0a\u59b2\u73b8\u51de\u73cd\u4ea2\uff32");
                point = new Point(867, 1282);
                point2 = new Point(810, 1570);
                point3 = new Point(838, 2197);
                n2 = n3;
                break;
            }
            case 110040000: {
                n4 = 1200;
                n3 = 5220001;
                string = SkillType.ALLATORIxDEMO("\u5ddb\u5c61\u87ca\u51de\u73cd\u4ea2\uff32");
                point = new Point(-355, 179);
                point2 = new Point(-1283, -113);
                point3 = new Point(-571, -593);
                n2 = n3;
                break;
            }
            case 250010304: {
                n4 = 2100;
                n3 = 7220000;
                string = SkillType.ALLATORIxDEMO("\u6d72\u6d4e\u71b9\u51de\u73cd\u4ea2\uff32");
                point = new Point(-210, 33);
                point2 = new Point(-234, 393);
                point3 = new Point(-654, 33);
                n2 = n3;
                break;
            }
            case 200010300: {
                n4 = 1200;
                n3 = 8220000;
                string = SkillType.ALLATORIxDEMO("\u824d\u83ad\u50a2\u51de\u73cd\u4ea2\uff32");
                point = new Point(665, 83);
                point2 = new Point(672, -217);
                point3 = new Point(-123, -217);
                n2 = n3;
                break;
            }
            case 250010503: {
                n4 = 1800;
                n3 = 7220002;
                string = SkillType.ALLATORIxDEMO("\u5591\u4eea\u600e\u4e89\u51de\u73cd\u4ea2\uff32");
                point = new Point(-303, 543);
                point2 = new Point(227, 543);
                point3 = new Point(719, 543);
                n2 = n3;
                break;
            }
            case 222010310: {
                n4 = 2700;
                n3 = 7220001;
                string = SkillType.ALLATORIxDEMO("\u4e79\u5c0d\u59b2\u72e3\u51de\u73cd\u4ea2\uff32");
                point = new Point(-169, -147);
                point2 = new Point(-517, 93);
                point3 = new Point(247, 93);
                n2 = n3;
                break;
            }
            case 107000300: {
                n4 = 1800;
                n3 = 6220000;
                string = SkillType.ALLATORIxDEMO("\u6c98\u6f97\u5dcc\u9c44\u51de\u73cd\u4ea2\uff32");
                point = new Point(710, 118);
                point2 = new Point(95, 119);
                point3 = new Point(-535, 120);
                n2 = n3;
                break;
            }
            case 100040105: {
                n4 = 1800;
                n3 = 5220002;
                string = SkillType.ALLATORIxDEMO("\u85fe\u8256\u76b7\u9703\u6c10\u8bae\u5fa4\u66d0\u66a4\u6666\u51c9\u73da\u4eb5\u6b89\u5c7e\u7310\u73b8");
                point = new Point(1000, 278);
                point2 = new Point(557, 278);
                point3 = new Point(95, 278);
                n2 = n3;
                break;
            }
            case 220050100: {
                n4 = 1500;
                n3 = 5220003;
                string = SkillType.ALLATORIxDEMO("\u6ec7\u7b70\u6ec7\u7b70\u001d\n\u001d\n\u54a6\u54b1\u942b\u51de\u73cd\u4ea2\u0012");
                point = new Point(-467, 1032);
                point2 = new Point(532, 1032);
                point3 = new Point(-47, 1032);
                n2 = n3;
                break;
            }
            case 221040301: {
                n4 = 2400;
                n3 = 6220001;
                string = SkillType.ALLATORIxDEMO("\u847f\u96c4\u91f5\u5268\u51de\u73cd\u4ea2\uff32");
                point = new Point(-4134, 416);
                point2 = new Point(-4283, 776);
                point3 = new Point(-3292, 776);
                n2 = n3;
                break;
            }
            case 240040401: {
                n4 = 7200;
                n3 = 8220003;
                string = SkillType.ALLATORIxDEMO("\u5bf6\u972f\u5194\u9fbe\u51de\u73cd\u4ea2\uff32");
                point = new Point(-15, 2481);
                point2 = new Point(127, 1634);
                point3 = new Point(159, 1142);
                n2 = n3;
                break;
            }
            case 260010201: {
                n4 = 3600;
                n3 = 0x312221;
                string = SkillType.ALLATORIxDEMO("\u4efd\u4e89\u9553\u8032\u51de\u73cd\u4ea2\uff32");
                point = new Point(-215, 275);
                point2 = new Point(298, 275);
                point3 = new Point(592, 275);
                n2 = n3;
                break;
            }
            case 261030000: {
                n4 = 2700;
                n3 = 8220002;
                string = SkillType.ALLATORIxDEMO("\u5974\u7faa\u62fa\u51de\u73cd\u4ea2\uff32");
                point = new Point(-1094, -405);
                point2 = new Point(-772, -116);
                point3 = new Point(-108, 181);
                n2 = n3;
                break;
            }
            case 230020100: {
                n4 = 2700;
                n3 = 0x406460;
                string = SkillType.ALLATORIxDEMO("\u7058\u86a8\u6b8f\u51de\u73cd\u4ea2\uff32");
                point = new Point(-291, -20);
                point2 = new Point(-272, -500);
                point3 = new Point(-462, 640);
                n2 = n3;
                break;
            }
            case 677000001: {
                n4 = 60;
                n3 = 9400612;
                string = SkillType.ALLATORIxDEMO("\u7459\u5dd0\u659c\u5dd6\u7da0\u51de\u73cd\u4ea2\u3031");
                point = new Point(99, 60);
                point2 = new Point(99, 60);
                point3 = new Point(99, 60);
                n2 = n3;
                break;
            }
            case 677000003: {
                n4 = 60;
                n3 = 9400610;
                string = SkillType.ALLATORIxDEMO("\u5bad\u7750\u895b\u4ead\u5dd6\u7da0\u51de\u73cd\u4ea2\u3031");
                point = new Point(6, 35);
                point2 = new Point(6, 35);
                point3 = new Point(6, 35);
                n2 = n3;
                break;
            }
            case 677000005: {
                n4 = 60;
                n3 = 9400609;
                string = SkillType.ALLATORIxDEMO("\u5bba\u5377\u659c\u5dd6\u7da0\u51de\u73cd\u4ea2\u3031");
                point = new Point(-277, 78);
                point2 = new Point(547, 86);
                point3 = new Point(-347, 80);
                n2 = n3;
                break;
            }
            case 677000007: {
                n4 = 60;
                n3 = 9400611;
                string = SkillType.ALLATORIxDEMO("\u516f\u7fb6\u8cd9\u720d\u5dd6\u7da0\u51de\u73cd\u4ea2\u3031");
                point = new Point(117, 73);
                point2 = new Point(117, 73);
                point3 = new Point(117, 73);
                n2 = n3;
                break;
            }
            case 677000009: {
                n4 = 60;
                n3 = 9400613;
                string = SkillType.ALLATORIxDEMO("\u83dc\u520d\u5f24\u5dd6\u7da0\u51de\u73cd\u4ea2\u3031");
                point = new Point(85, 66);
                point2 = new Point(85, 66);
                point3 = new Point(85, 66);
                n2 = n3;
                break;
            }
            case 103020320: {
                n4 = 1800;
                n3 = 5090000;
                string = SkillType.ALLATORIxDEMO("\u571b\u5714\u9406\u76a0\u9643\u5f55\u4e1e\u51de\u73cd\u4ea2\u4ef3\u9e98\u6742\u895b\u3031");
                point = new Point(79, 174);
                point2 = new Point(-223, 296);
                point3 = new Point(80, 275);
                n2 = n3;
                break;
            }
            case 103020420: {
                n4 = 1800;
                n3 = 5090000;
                string = SkillType.ALLATORIxDEMO("\u571b\u5714\u9406\u76a0\u9643\u5f55\u4e1e\u51de\u73cd\u4ea2\u4ef3\u9e98\u6742\u895b\u3031");
                point = new Point(2241, 301);
                point2 = new Point(1990, 301);
                point3 = new Point(1684, 307);
                n2 = n3;
                break;
            }
            case 261020300: {
                n4 = 2700;
                n3 = 7090000;
                string = SkillType.ALLATORIxDEMO("\u81ce\u52e6\u8b42\u50aa\u7cdf\u7d42\u51de\u73cd\u4ea2\uff32");
                point = new Point(312, 157);
                point2 = new Point(539, 136);
                point3 = new Point(760, 141);
                n2 = n3;
                break;
            }
            case 261020401: {
                n4 = 2700;
                n3 = 8090000;
                string = SkillType.ALLATORIxDEMO("\u8fd9\u725d\u54bf\u6d3f\u4fae\u51de\u73cd\u4ea2\u3031");
                point = new Point(-263, 155);
                point2 = new Point(-436, 122);
                point3 = new Point(22, 144);
                n2 = n3;
                break;
            }
            case 250020300: {
                n4 = 2700;
                n3 = 5090001;
                string = SkillType.ALLATORIxDEMO("\u4efd\u4e89\u738d\u5045\u51de\u73cd\u4ea2\u3031");
                point = new Point(1208, 27);
                point2 = new Point(1654, 40);
                point3 = new Point(927, -502);
                n2 = n3;
                break;
            }
            case 261010003: {
                n4 = 2700;
                n3 = 6090004;
                string = SkillType.ALLATORIxDEMO("\u7d21\u85fe\u96fd\u6019\u51de\u73cd\u4ea2\u3031");
                point = new Point(-861, 301);
                point2 = new Point(-703, 301);
                point3 = new Point(-426, 287);
                n2 = n3;
                break;
            }
            case 222010300: {
                n4 = 2700;
                n3 = 6090003;
                string = SkillType.ALLATORIxDEMO("\u66dc\u752c\u5e59\u977b\u51de\u73cd\u4ea2\u3031");
                point = new Point(1300, -400);
                point2 = new Point(1100, -100);
                point3 = new Point(1100, 100);
                n2 = n3;
                break;
            }
            case 251010101: {
                n4 = 2700;
                n3 = 6090002;
                string = SkillType.ALLATORIxDEMO("\u7add\u5233\u6b42\u58d8\u51de\u73cd\u4ea2\u3031");
                point = new Point(-15, -449);
                point2 = new Point(-114, -442);
                point3 = new Point(-255, -446);
                n2 = n3;
                break;
            }
            case 211041400: {
                n4 = 2700;
                n3 = 6090000;
                string = SkillType.ALLATORIxDEMO("\u53a0\u9078\u6b5f\u796d\u51de\u73cd\u4ea2\uff32");
                point = new Point(1672, 82);
                point2 = new Point(2071, 10);
                point3 = new Point(1417, 57);
                n2 = n3;
                break;
            }
            case 105030500: {
                n4 = 2700;
                n3 = 8130100;
                string = SkillType.ALLATORIxDEMO("\u5dc7\u6d3f\u53d7\u51de\u73cd\u4ea2\u3031");
                point = new Point(1275, -399);
                point2 = new Point(1254, -412);
                point3 = new Point(1058, -427);
                n2 = n3;
                break;
            }
            case 105020400: {
                n4 = 2700;
                n3 = 8220008;
                string = SkillType.ALLATORIxDEMO("\u51c9\u73da\u4eb5\u4e24\u5038\u5963\u6019\u76a0\u5575\u5eb3\u3031");
                point = new Point(-163, 82);
                point2 = new Point(958, 107);
                point3 = new Point(706, -206);
                n2 = n3;
                break;
            }
            case 211040101: {
                n4 = 3600;
                n3 = 8220001;
                string = SkillType.ALLATORIxDEMO("\u96ce\u6be8\u600e\u4e89\u51de\u73cd\u4ea2\u3031");
                point = new Point(485, 244);
                point2 = new Point(-60, 249);
                point3 = new Point(208, 255);
                n2 = n3;
                break;
            }
            case 120030500: {
                n4 = 1200;
                n3 = 5220001;
                string = SkillType.ALLATORIxDEMO("\u5fba\u6caa\u707c\u88d2\u6146\u6151\u76a0\u8d43\u51de\u4eb5\u4e24\u9688\u5dcc\u5c76\u87dd\u3031");
                point = new Point(-355, 179);
                point2 = new Point(-1283, -113);
                point3 = new Point(-571, -593);
                n2 = n3;
                break;
            }
            case 931000500: 
            case 931000501: 
            case 931000502: 
            case 931000503: 
            case 931000504: 
            case 931000505: 
            case 931000506: 
            case 931000507: 
            case 931000508: 
            case 931000509: {
                n4 = 21600;
                n3 = 9304005;
                string = SkillType.ALLATORIxDEMO("\u7faa\u6d01\u8c5d\u68c1\u604b\u5703\u51de\u73cd\u4ea2\u7a33\u672d\u8c4aD\u6743\u62edS\uff28\u5fd8\u539f\u6366\u636d\u5bb0\u5403\uff32");
                point = new Point(-872, -332);
                point2 = new Point(409, -572);
                point3 = new Point(-131, 0);
                bl = true;
                bl2 = true;
                n2 = n3;
                break;
            }
            case 100020401: {
                n4 = 7200;
                n3 = 6300005;
                string = SkillType.ALLATORIxDEMO("\u6b9e\u5c69\u8622\u83e3\u73b8\u51de\u73cd\u4ea2\uff32");
                point = new Point(204, -625);
                point2 = new Point(204, -625);
                point3 = new Point(204, -625);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 104010200: {
                n4 = 1200;
                n3 = 2220000;
                string = SkillType.ALLATORIxDEMO("\u7d36\u5bd2\u73b8\u51de\u73cd\u4ea2\uff32");
                point = new Point(189, 2);
                point2 = new Point(478, 250);
                point3 = new Point(611, 489);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 102020500: {
                n4 = 1200;
                n3 = 3220000;
                string = SkillType.ALLATORIxDEMO("\u6a0a\u59b2\u73b8\u51de\u73cd\u4ea2\uff32");
                point = new Point(1121, 2130);
                point2 = new Point(483, 2171);
                point3 = new Point(1474, 1706);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 100020101: {
                n4 = 1200;
                n3 = 6130101;
                string = SkillType.ALLATORIxDEMO("\u4ef3\u9e99\u5703\u659d\u51c9\u73da\u4eb5\u5dcc\u5914\u76a0\u8622\u83e3\u3031");
                point = new Point(-311, 201);
                point2 = new Point(-903, 197);
                point3 = new Point(-568, 196);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 100020301: {
                n4 = 1200;
                n3 = 0x7D6D67;
                string = SkillType.ALLATORIxDEMO("\u4ef3\u9e99\u5703\u659d\u51c9\u73da\u4eb5\u5dcc\u5914\u76a0\u85fe\u8256\u8622\u83e3\u3031");
                point = new Point(-188, -657);
                point2 = new Point(625, -660);
                point3 = new Point(508, -648);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 103030400: {
                n4 = 1800;
                n3 = 6220000;
                string = SkillType.ALLATORIxDEMO("\u6c98\u6f97\u5dcc\u9c44\u51de\u73cd\u4ea2\uff32");
                point = new Point(-831, 109);
                point2 = new Point(1525, -75);
                point3 = new Point(-511, 107);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 101040300: {
                n4 = 1800;
                n3 = 5220002;
                string = SkillType.ALLATORIxDEMO("\u85e9\u8241\u76a0\u9714\u6c07\u8bb9\u5fb3\u66c7\u66b3\u6671\u51de\u73cd\u4ea2\u6b9e\u5c69\u7307\u73af\u3031");
                point = new Point(600, -600);
                point2 = new Point(600, -800);
                point3 = new Point(600, -300);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 251010102: {
                n4 = 3600;
                n3 = 5220004;
                string = SkillType.ALLATORIxDEMO("\u5903\u73b8\u872c\u8690\u51de\u73cd\u4ea2\u3031");
                point = new Point(-41, 124);
                point2 = new Point(-173, 126);
                point3 = new Point(79, 118);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 211050000: {
                n4 = 2700;
                n3 = 6090001;
                string = SkillType.ALLATORIxDEMO("\u8898\u677b\u7e28\u570c\u5183\u88eb\u76b7\u9b70\u5940\u7778\u95b8\u4ea2\u770f\u777f\u3031");
                point = new Point(-233, -431);
                point2 = new Point(-370, -426);
                point3 = new Point(-526, -420);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 103040430: {
                n4 = 3600;
                n3 = 4300013;
                string = SkillType.ALLATORIxDEMO("\u6425\u6eda\u76b7\u7c9a\u796d\u51de\u73cd\u4ea2\u3031");
                point = new Point(240, 88);
                point2 = new Point(240, 88);
                point3 = new Point(240, 88);
                bl2 = true;
                n2 = n3;
                break;
            }
            case 209000000: {
                n4 = 300;
                n3 = 9500317;
                string = SkillType.ALLATORIxDEMO("\u5c3c\u96ce\u4e89\u51de\u73cd\u4ea2\u0012");
                point = new Point(-115, 154);
                point2 = new Point(-115, 154);
                point3 = new Point(-115, 154);
                bl2 = true;
                n2 = n3;
                break;
            }
            default: {
                return;
            }
        }
        if (n2 <= 0) return;
        if (bl2) {
            if (GameSetConstants.MAPLE_VERSION < 134) return;
            a2.addAreaMonsterSpawn(MapleLifeFactory.getMonster(n3), point, point2, point3, n4, string, bl);
            return;
        } else {
            if ((n3 == 8090000 || n3 == 7090000) && GameSetConstants.SERVER_NAME.equals(SkillType.ALLATORIxDEMO("\u76cb\u6039\u8c04"))) {
                return;
            }
            a2.addAreaMonsterSpawn(MapleLifeFactory.getMonster(n3), point, point2, point3, n4, string, bl);
        }
    }

    public /* synthetic */ void removeMap(int a2) {
        MapleMapFactory a3;
        if (a3.isMapLoaded(a2)) {
            MapleMapFactory mapleMapFactory = a3;
            mapleMapFactory.getMap(a2).checkStates("");
            mapleMapFactory.C.remove(a2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ MapleNodes ALLATORIxDEMO(int a2, MapleData a3) {
        int n2;
        Object object;
        int n3;
        Object object2;
        Object object3;
        MapleNodes mapleNodes;
        block32: {
            mapleNodes = E.get(a2);
            if (mapleNodes != null) return mapleNodes;
            mapleNodes = new MapleNodes(a2);
            if (a3.getChildByPath(SkillType.ALLATORIxDEMO("J\\@Vm]B\\")) == null) break block32;
            Iterator iterator = a3.getChildByPath(SkillType.ALLATORIxDEMO("J\\@Vm]B\\")).iterator();
            block12: while (true) {
                Iterator iterator2 = iterator;
                block13: while (iterator2.hasNext()) {
                    object3 = (MapleData)iterator.next();
                    try {
                        int n4;
                        block33: {
                            object2 = object3.getName();
                            n3 = -1;
                            switch (((String)object2).hashCode()) {
                                case 109757538: {
                                    if (!((String)object2).equals(SkillType.ALLATORIxDEMO("@PRVG"))) break;
                                    n4 = n3 = 0;
                                    break block33;
                                }
                                case 100571: {
                                    if (!((String)object2).equals(SkillType.ALLATORIxDEMO("VJW"))) break;
                                    n3 = 1;
                                }
                            }
                            n4 = n3;
                        }
                        switch (n4) {
                            case 0: {
                                mapleNodes.setNodeStart(MapleDataTool.getInt((MapleData)object3, 0));
                                iterator2 = iterator;
                                continue block13;
                            }
                            case 1: {
                                mapleNodes.setNodeEnd(MapleDataTool.getInt((MapleData)object3, 0));
                                iterator2 = iterator;
                                continue block13;
                            }
                        }
                        object2 = new ArrayList();
                        if (object3.getChildByPath(SkillType.ALLATORIxDEMO("AWCV")) != null) {
                            Iterator iterator3 = object3.getChildByPath(SkillType.ALLATORIxDEMO("AWCV")).iterator();
                            while (iterator3.hasNext()) {
                                Iterator iterator4;
                                object = (MapleData)iterator4.next();
                                iterator3 = iterator4;
                                object2.add(MapleDataTool.getInt((MapleData)object, -1));
                            }
                        }
                        MapleNodes.MapleNodeInfo mapleNodeInfo = new MapleNodes.MapleNodeInfo(Integer.parseInt(object3.getName()), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("XAJ"), (MapleData)object3, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("K"), (MapleData)object3, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("J"), (MapleData)object3, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("EGPA"), (MapleData)object3, 0), (List<Integer>)object2);
                        mapleNodes.addNode(mapleNodeInfo);
                    }
                    catch (NumberFormatException numberFormatException) {}
                    continue block12;
                }
                break;
            }
            mapleNodes.sortNodes();
        }
        int n5 = n2 = 1;
        while (true) {
            block35: {
                Iterable<MapleData> iterable;
                block36: {
                    block34: {
                        if (n5 > 7) break block34;
                        if (a3.getChildByPath(String.valueOf(n2)) == null || a3.getChildByPath(n2 + "/obj") == null) break block35;
                        break block36;
                    }
                    if (a3.getChildByPath(SkillType.ALLATORIxDEMO("EAAR")) != null) {
                        Iterator iterator;
                        Iterator iterator5 = iterator = a3.getChildByPath(SkillType.ALLATORIxDEMO("EAAR")).iterator();
                        while (iterator5.hasNext()) {
                            iterable = (MapleData)iterator.next();
                            n2 = MapleDataTool.getInt(iterable.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0002")));
                            int n6 = MapleDataTool.getInt(iterable.getChildByPath(SkillType.ALLATORIxDEMO("]\u0002")));
                            int n7 = MapleDataTool.getInt(iterable.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0001")));
                            n3 = MapleDataTool.getInt(iterable.getChildByPath(SkillType.ALLATORIxDEMO("]\u0001")));
                            int n8 = n2;
                            object = new Rectangle(n8, n6, n7 - n8, n3 - n6);
                            iterator5 = iterator;
                            mapleNodes.addMapleArea((Rectangle)object);
                        }
                    }
                    if (a3.getChildByPath(SkillType.ALLATORIxDEMO("^K]WGAAgRV]MEE_")) != null) {
                        MapleData mapleData = a3.getChildByPath(SkillType.ALLATORIxDEMO("^K]WGAAgRV]MEE_"));
                        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("^KQcVJcK@")) != null) {
                            Iterator iterator;
                            Iterator iterator6 = iterator = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("^KQcVJcK@")).iterator();
                            while (iterator6.hasNext()) {
                                MapleData mapleData2 = (MapleData)iterator.next();
                                iterator6 = iterator;
                                mapleNodes.addMonsterPoint(MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("K"))), MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("J"))), MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("B["))), MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("GJ"))), MapleDataTool.getInt(SkillType.ALLATORIxDEMO("PVE^"), mapleData2, -1));
                            }
                        }
                        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("^KQ")) != null) {
                            Iterator iterator;
                            Iterator iterator7 = iterator = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("^KQ")).iterator();
                            while (iterator7.hasNext()) {
                                MapleData mapleData3 = (MapleData)iterator.next();
                                iterator7 = iterator;
                                mapleNodes.addMobSpawn(MapleDataTool.getInt(mapleData3.getChildByPath(SkillType.ALLATORIxDEMO("MW"))), MapleDataTool.getInt(mapleData3.getChildByPath(SkillType.ALLATORIxDEMO("@TVJWgc"))));
                            }
                        }
                        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("CFEA@ZE]cVJcK@")) != null) {
                            Iterator iterator;
                            Iterator iterator8 = iterator = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("CFEA@ZE]cVJcK@")).iterator();
                            while (iterator8.hasNext()) {
                                MapleData mapleData4 = (MapleData)iterator.next();
                                iterator8 = iterator;
                                mapleNodes.addGuardianSpawn(new Point(MapleDataTool.getInt(mapleData4.getChildByPath(SkillType.ALLATORIxDEMO("K"))), MapleDataTool.getInt(mapleData4.getChildByPath(SkillType.ALLATORIxDEMO("J")))), MapleDataTool.getInt(SkillType.ALLATORIxDEMO("PVE^"), mapleData4, -1));
                            }
                        }
                        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("@OZH_")) != null) {
                            Iterator iterator;
                            Iterator iterator9 = iterator = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("@OZH_")).iterator();
                            while (iterator9.hasNext()) {
                                MapleData mapleData5 = (MapleData)iterator.next();
                                iterator9 = iterator;
                                mapleNodes.addSkillId(MapleDataTool.getInt(mapleData5));
                            }
                        }
                    }
                    E.put(a2, mapleNodes);
                    return mapleNodes;
                }
                object3 = a3.getChildByPath(n2 + "/obj").iterator();
                block21: while (true) {
                    Object object4 = object3;
                    while (object4.hasNext()) {
                        int n9;
                        object2 = (MapleData)object3.next();
                        n3 = MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("w}{PKFJG"), (MapleData)object2, 0);
                        object = MapleDataTool.getString(SkillType.ALLATORIxDEMO("JRIV"), (MapleData)object2, "");
                        int n10 = MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("@TVAW"), (MapleData)object2, 0);
                        if (n3 <= 0 || n10 <= 0) continue block21;
                        if (((String)object).equals("")) {
                            object4 = object3;
                            continue;
                        }
                        iterable = new ArrayList();
                        int n11 = n9 = 0;
                        while (n11 < n3) {
                            String string = "SN" + n9;
                            iterable.add(MapleDataTool.getIntConvert(string, (MapleData)object2, 0));
                            n11 = ++n9;
                        }
                        MapleNodes.MaplePlatform maplePlatform = new MapleNodes.MaplePlatform((String)object, MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("@PRVG"), (MapleData)object2, 2), n10, MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("\\\u0002"), (MapleData)object2, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("]\u0002"), (MapleData)object2, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("\\\u0001"), (MapleData)object2, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("]\u0001"), (MapleData)object2, 0), MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("A"), (MapleData)object2, 0), (List<Integer>)iterable);
                        object4 = object3;
                        mapleNodes.addPlatform(maplePlatform);
                    }
                    break;
                }
            }
            n5 = ++n2;
        }
    }

    public /* synthetic */ MapleMap getGuildMap(int a2, boolean a3322, boolean a4, boolean a5, int a6) {
        MapleMap mapleMap;
        Object object;
        AbstractLoadedMapleLife abstractLoadedMapleLife;
        Object object2;
        Object object3;
        Object object42;
        Object object5;
        Object object6;
        MapleMapFactory a7;
        if (a7.isGuildMapLoaded(a6 = a2 + a6)) {
            return a7.getGuildMap(a6);
        }
        MapleData mapleData = I.getData(a7.H(a2));
        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cHZJX")) != null) {
            mapleData = I.getData(a7.H(MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("ZJUK\u001cHZJX"), mapleData)));
        }
        float f2 = 0.0f;
        if (a3322 && (a3322 = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b^KQvRPV"))) != null) {
            f2 = ((Float)a3322.getData()).floatValue();
        }
        int a3322 = MapleDataTool.getInt(SkillType.ALLATORIxDEMO("M]B\\\u000bAAGQAJ~EC"), mapleData);
        if (MapConstants.isPVPMap(a2)) {
            a3322 = 960000000;
        }
        MapleMapFactory mapleMapFactory = a7;
        MapleMap a3322 = new MapleMap(a2, mapleMapFactory.a, mapleMapFactory.d, a3322, f2);
        Object object72 = new PortalFactory();
        Object object8 = object6 = mapleData.getChildByPath(SkillType.ALLATORIxDEMO("T\\VGE_")).iterator();
        while (object8.hasNext()) {
            object5 = (MapleData)object6.next();
            object8 = object6;
            a3322.addPortal(((PortalFactory)object72).makePortalFM(MapleDataTool.getInt(object5.getChildByPath(SkillType.ALLATORIxDEMO("TG"))), (MapleData)object5));
        }
        MapleData mapleData2 = mapleData;
        MapleMap mapleMap2 = a3322;
        mapleMap2.setTop(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bevgKC")), 0));
        mapleMap2.setLeft(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001crahVBG")), 0));
        a3322.setBottom(MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001craf\\PGK^")), 0));
        a3322.setRight(MapleDataTool.getInt(mapleData2.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bevaMTLG")), 0));
        object6 = new LinkedList();
        object5 = new Point();
        object72 = new Point();
        for (Object object42 : mapleData.getChildByPath(SkillType.ALLATORIxDEMO("B\\KGL\\HW"))) {
            object3 = object42.iterator();
            while (object3.hasNext()) {
                object2 = (MapleData)object3.next();
                Object object9 = object2.iterator();
                while (object9.hasNext()) {
                    Iterator iterator;
                    object = (MapleData)abstractLoadedMapleLife.next();
                    Iterator iterator2 = iterator = new MapleFoothold(new Point(MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0002"))), MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("]\u0002")))), new Point(MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("\\\u0001"))), MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("]\u0001")))), Integer.parseInt(object.getName()));
                    ((MapleFoothold)((Object)iterator2)).setPrev((short)MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("TAAE"))));
                    ((MapleFoothold)((Object)iterator2)).setNext((short)MapleDataTool.getInt(object.getChildByPath(SkillType.ALLATORIxDEMO("JV\\G"))));
                    if (((MapleFoothold)((Object)iterator2)).getX1() < ((Point)object5).x) {
                        ((Point)object5).x = ((MapleFoothold)((Object)iterator)).getX1();
                    }
                    if (((MapleFoothold)((Object)iterator)).getX2() > ((Point)object72).x) {
                        ((Point)object72).x = ((MapleFoothold)((Object)iterator)).getX2();
                    }
                    if (((MapleFoothold)((Object)iterator)).getY1() < ((Point)object5).y) {
                        ((Point)object5).y = ((MapleFoothold)((Object)iterator)).getY1();
                    }
                    if (((MapleFoothold)((Object)iterator)).getY2() > ((Point)object72).y) {
                        ((Point)object72).y = ((MapleFoothold)((Object)iterator)).getY2();
                    }
                    object6.add(iterator);
                    object9 = abstractLoadedMapleLife;
                }
            }
        }
        MapleFootholdTree mapleFootholdTree = new MapleFootholdTree((Point)object5, (Point)object72);
        Object object10 = object42 = object6.iterator();
        while (object10.hasNext()) {
            object3 = (MapleFoothold)object42.next();
            object10 = object42;
            mapleFootholdTree.insert((MapleFoothold)object3);
        }
        a3322.setFootholds(mapleFootholdTree);
        int n2 = -1;
        object3 = null;
        if (mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A~KQ")) != null) {
            MapleData mapleData3 = mapleData;
            n2 = MapleDataTool.getInt(mapleData3.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cPZIVi\\F\u001cMW")), 0);
            object3 = MapleDataTool.getString(mapleData3.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A~KQ\u000b^A@WRCV")), null);
        }
        for (Iterator iterator : mapleData.getChildByPath(SkillType.ALLATORIxDEMO("HZBV"))) {
            object2 = MapleDataTool.getString(iterator.getChildByPath(SkillType.ALLATORIxDEMO("PJTV")));
            if (a4 == false && ((String)object2).equals(SkillType.ALLATORIxDEMO("]"))) continue;
            MapleData mapleData4 = iterator;
            abstractLoadedMapleLife = a7.ALLATORIxDEMO(mapleData4, MapleDataTool.getString(mapleData4.getChildByPath(SkillType.ALLATORIxDEMO("MW"))), (String)object2);
            if (abstractLoadedMapleLife instanceof MapleMonster) {
                Object object11 = object72 = (MapleMonster)abstractLoadedMapleLife;
                a3322.addMonsterSpawn((MapleMonster)object11, MapleDataTool.getInt(SkillType.ALLATORIxDEMO("^KQpZIV"), (MapleData)((Object)iterator), 0), (byte)MapleDataTool.getInt(SkillType.ALLATORIxDEMO("PVE^"), iterator, -1), (String)(((AbstractLoadedMapleLife)object11).getId() == n2 ? object3 : null));
                continue;
            }
            a3322.addMapObject(abstractLoadedMapleLife);
        }
        a7.ALLATORIxDEMO(a3322);
        MapleMap mapleMap3 = a3322;
        a3322.setCreateMobInterval((short)MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPVVEGA~KQm]PVVEE_")), 9000));
        mapleMap3.loadMonsterRate(true);
        mapleMap3.setNodes(a7.ALLATORIxDEMO(a2, mapleData));
        if (a5 != false && mapleData.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKA")) != null) {
            for (Object object72 : mapleData.getChildByPath(SkillType.ALLATORIxDEMO("AARGGKA"))) {
                object = MapleDataTool.getString(object72.getChildByPath(SkillType.ALLATORIxDEMO("MW")));
                if (object == null) continue;
                Object object12 = object72;
                a3322.spawnReactor(a7.ALLATORIxDEMO((MapleData)object12, (String)object, (byte)MapleDataTool.getInt(object12.getChildByPath(SkillType.ALLATORIxDEMO("U")), 0), a3322.getWorld()));
            }
        }
        try {
            a3322.setMapName(MapleItemInformationProvider.getInstance().getMapName(a2).isEmpty() ? MapleDataTool.getString(SkillType.ALLATORIxDEMO("^ECjRIV"), F.getChildByPath(a7.ALLATORIxDEMO(a2)), "") : MapleItemInformationProvider.getInstance().getMapName(a2));
            a3322.setStreetName(MapleItemInformationProvider.getInstance().getStreetName(a2).isEmpty() ? MapleDataTool.getString(SkillType.ALLATORIxDEMO("WGVVAGjRIV"), F.getChildByPath(a7.ALLATORIxDEMO(a2)), "") : MapleItemInformationProvider.getInstance().getStreetName(a2));
            mapleMap = a3322;
        }
        catch (Exception exception) {
            MapleMap mapleMap4 = a3322;
            mapleMap = mapleMap4;
            mapleMap4.setMapName("");
            mapleMap4.setStreetName("");
        }
        mapleMap.setClock(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPH\\GX")), 0) > 0);
        a3322.setEverlast(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cAEAAHRWG")), 0) > 0);
        a3322.setTown(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cP\\S]")), 0) > 0);
        a3322.setSoaring(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b]AV@`OZH_b\\VuHJ")), 0) > 0);
        MapleMap mapleMap5 = a3322;
        MapleData mapleData5 = mapleData;
        MapleMap mapleMap6 = a3322;
        MapleData mapleData6 = mapleData;
        MapleMap mapleMap7 = a3322;
        MapleMap mapleMap8 = a3322;
        MapleData mapleData7 = mapleData;
        a3322.setForceMove(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b_RuKAGVi\\RV")), 0));
        a3322.setHPDec(MapleDataTool.getInt(mapleData7.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bWAPlc")), 0));
        mapleMap8.setHPDecInterval(MapleDataTool.getInt(mapleData7.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bWAPlcm]PVVEE_")), 10000));
        mapleMap8.setHPDecProtect(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bCV\\PVGGmGA^")), 0));
        mapleMap7.setForcedReturnMap(910000000);
        mapleMap7.setTimeLimit(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bGM^A\u007fM^MG")), -1));
        a3322.setFieldLimit(MapleDataTool.getInt(mapleData6.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cBZA_@\u007fM^MG")), 0));
        mapleMap6.setFirstUserEnter(MapleDataTool.getString(mapleData6.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cK]bZV@PfWVVvJGAA")), ""));
        mapleMap6.setUserEnter(MapleDataTool.getString(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000b\\JfWVVvJGAA")), ""));
        a3322.setRecoveryRate(MapleDataTool.getFloat(mapleData5.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cVVG\\RVVJ")), 1.0f));
        mapleMap5.setFixedMob(MapleDataTool.getInt(mapleData5.getChildByPath(SkillType.ALLATORIxDEMO("ZJUK\u001cBZ\\V@~KQgRTRGZPJ")), 0));
        mapleMap5.setConsumeItemCoolTime(MapleDataTool.getInt(mapleData.getChildByPath(SkillType.ALLATORIxDEMO("M]B\\\u000bPK]WFIVmGA^g\\K_pZIV")), 0));
        MapleMap mapleMap9 = a3322;
        a7.e.put(a6, mapleMap9);
        return mapleMap9;
    }

    public /* synthetic */ boolean isMapLoaded(int a2) {
        MapleMapFactory a3;
        return a3.C.containsKey(a2);
    }

    private /* synthetic */ AbstractLoadedMapleLife ALLATORIxDEMO(MapleData a2, String a3, String a4) {
        MapleMapFactory a5;
        return a5.ALLATORIxDEMO(a2, a3, a4, 0);
    }

    public /* synthetic */ MapleMap CreateInstanceMap(int a2, boolean a3, boolean a4, boolean a5, int a6) {
        MapleMapFactory a7;
        return a7.CreateInstanceMap(a2, a3, a4, a5, a6, 0);
    }

    private static /* synthetic */ AbstractLoadedMapleLife ALLATORIxDEMO(int a2, int a3, boolean a4, int a5, int a6, int a7, int a8, int a9, int a10, String a11, int a12) {
        AbstractLoadedMapleLife abstractLoadedMapleLife = MapleLifeFactory.getLife(a2, a11);
        if (abstractLoadedMapleLife == null) {
            System.err.println("\u81ea\u8a02 npc " + a2 + " \u7570\u5e38...");
            return null;
        }
        AbstractLoadedMapleLife abstractLoadedMapleLife2 = abstractLoadedMapleLife;
        AbstractLoadedMapleLife abstractLoadedMapleLife3 = abstractLoadedMapleLife;
        AbstractLoadedMapleLife abstractLoadedMapleLife4 = abstractLoadedMapleLife;
        AbstractLoadedMapleLife abstractLoadedMapleLife5 = abstractLoadedMapleLife;
        abstractLoadedMapleLife5.setCy(a6);
        abstractLoadedMapleLife5.setF(a3);
        abstractLoadedMapleLife4.setFh(a5);
        abstractLoadedMapleLife4.setRx0(a7);
        abstractLoadedMapleLife3.setRx1(a8);
        AbstractLoadedMapleLife abstractLoadedMapleLife6 = abstractLoadedMapleLife;
        abstractLoadedMapleLife3.setPosition(new Point(a9, a10));
        abstractLoadedMapleLife3.setHide(a4);
        abstractLoadedMapleLife2.setMTime(a12);
        abstractLoadedMapleLife2.setCType(a11);
        return abstractLoadedMapleLife;
    }

    public static /* synthetic */ int loadCustomLife() {
        return MapleMapFactory.loadCustomLife(false, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ int loadCustomLife(boolean a, MapleMap a) {
        block35: {
            if (a) {
                var2_2 = a.getId();
                var3_5 = MapleMapFactory.k.get(var2_2);
                if (var3_5 != null) {
                    block24: for (AbstractLoadedMapleLife var5_11 : var3_5) {
                        var6_15 = var5_11.getCType();
                        var7_17 = -1;
                        switch (var6_15.hashCode()) {
                            case 110: {
                                if (!var6_15.equals(SkillType.ALLATORIxDEMO("]"))) break;
                                var7_17 = 0;
                                break;
                            }
                        }
                        switch (var7_17) {
                            case 0: {
                                a.removeNpc_(var5_11.getId());
                                continue block24;
                            }
                        }
                    }
                }
                MapleMapFactory.B.clear();
                MapleMapFactory.ALLATORIxDEMO = true;
            }
            try {
                var2_3 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    var3_5 = var2_3.prepareStatement(SkillType.ALLATORIxDEMO("`a\u007fapp\u0013\u000e\u0013bak~\u0004SSI{PQ@P\\I_MUAS"));
                    try {
                        var4_8 = var3_5.executeQuery();
lbl28:
                        // 3 sources

                        while (true) {
                            try {
                                v0 = var4_8;
lbl31:
                                // 2 sources

                                while (v0.next()) {
                                    v1 = var4_8;
                                    var5_12 = v1.getInt(SkillType.ALLATORIxDEMO("^MW"));
                                    v2 = v1.getInt(SkillType.ALLATORIxDEMO("@RPRMW"));
                                    v3 = var4_8.getInt(SkillType.ALLATORIxDEMO("U"));
                                    if (var4_8.getByte(SkillType.ALLATORIxDEMO("LZ@V")) <= 0) ** GOTO lbl-1000
                                    v4 = true;
                                    v5 = var4_8;
                                    ** GOTO lbl76
                                }
                                break block35;
                            }
                            catch (Throwable var5_13) {
                                if (var4_8 != null) {
                                    try {
                                        var4_8.close();
                                        v6 = var5_13;
                                        throw v6;
                                    }
                                    catch (Throwable var6_16) {
                                        var5_13.addSuppressed(var6_16);
                                    }
                                }
                                v6 = var5_13;
                                throw v6;
                            }
                            break;
                        }
                    }
                    catch (Throwable var4_9) {
                        if (var3_5 != null) {
                            try {
                                var3_5.close();
                                v7 = var4_9;
                                throw v7;
                            }
                            catch (Throwable var5_14) {
                                var4_9.addSuppressed(var5_14);
                            }
                        }
                        v7 = var4_9;
                        throw v7;
                    }
                }
                catch (Throwable var3_7) {
                    if (var2_3 != null) {
                        try {
                            var2_3.close();
                            v8 = var3_7;
                            throw v8;
                        }
                        catch (Throwable var4_10) {
                            var3_7.addSuppressed(var4_10);
                        }
                    }
                    v8 = var3_7;
                    throw v8;
                }
            }
            catch (SQLException var2_4) {
                System.err.println("Error loading custom life..." + var2_4);
                return -1;
            }
lbl-1000:
            // 1 sources

            {
                block37: {
                    block36: {
                        v4 = false;
                        v5 = var4_8;
lbl76:
                        // 2 sources

                        var6_15 = MapleMapFactory.ALLATORIxDEMO(v2, v3, v4, v5.getInt(SkillType.ALLATORIxDEMO("B[")), var4_8.getInt(SkillType.ALLATORIxDEMO("GJ")), var4_8.getInt(SkillType.ALLATORIxDEMO("A\\\u0003")), var4_8.getInt(SkillType.ALLATORIxDEMO("A\\\u0002")), var4_8.getInt(SkillType.ALLATORIxDEMO("K")), var4_8.getInt(SkillType.ALLATORIxDEMO("J")), var4_8.getString(SkillType.ALLATORIxDEMO("PJTV")), var4_8.getInt(SkillType.ALLATORIxDEMO("^KQPZIV")));
                        if (var6_15 != null) break block36;
                        v0 = var4_8;
                        ** GOTO lbl31
                    }
                    var7_19 = MapleMapFactory.B.get(var5_12);
                    v9 = a = new ArrayList<E>();
                    if (var7_19 != null) break block37;
                    v9.add(var6_15);
                    MapleMapFactory.k.put(var5_12, a);
                    MapleMapFactory.B.put(var5_12, a);
                    ** GOTO lbl28
                }
                v9.addAll(var7_19);
                a.add(var6_15);
                MapleMapFactory.k.put(var5_12, a);
                MapleMapFactory.B.put(var5_12, a);
                ** continue;
            }
        }
        if (var4_8 != null) {
            v10 = var3_5;
            var4_8.close();
        } else {
            v10 = var3_5;
        }
        if (v10 != null) {
            var3_5.close();
        }
        var3_6 = MapleMapFactory.B.size();
        if (var2_3 == null) return var3_6;
        var2_3.close();
        return var3_6;
    }

    public /* synthetic */ Collection<MapleMap> getAllMaps() {
        MapleMapFactory a2;
        return a2.C.values();
    }

    private /* synthetic */ String ALLATORIxDEMO(int a2) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (a2 < 100000000) {
            StringBuilder stringBuilder3 = stringBuilder2;
            stringBuilder = stringBuilder3;
            stringBuilder3.append(SkillType.ALLATORIxDEMO("^ECHV"));
        } else if (a2 >= 100000000 && a2 < 200000000 || a2 / 100000 == 5540) {
            StringBuilder stringBuilder4 = stringBuilder2;
            stringBuilder = stringBuilder4;
            stringBuilder4.append(SkillType.ALLATORIxDEMO("RZGGKAMR"));
        } else if (a2 >= 200000000 && a2 < 300000000) {
            StringBuilder stringBuilder5 = stringBuilder2;
            stringBuilder = stringBuilder5;
            stringBuilder5.append(SkillType.ALLATORIxDEMO("\\W@]AMR"));
        } else if (a2 >= 300000000 && a2 < 400000000) {
            StringBuilder stringBuilder6 = stringBuilder2;
            stringBuilder = stringBuilder6;
            stringBuilder6.append(SkillType.ALLATORIxDEMO("A_M]"));
        } else if (a2 >= 500000000 && a2 < 510000000) {
            StringBuilder stringBuilder7 = stringBuilder2;
            stringBuilder = stringBuilder7;
            stringBuilder7.append(SkillType.ALLATORIxDEMO("P[EZ"));
        } else if (a2 >= 540000000 && a2 < 600000000) {
            StringBuilder stringBuilder8 = stringBuilder2;
            stringBuilder = stringBuilder8;
            stringBuilder8.append(SkillType.ALLATORIxDEMO("wt"));
        } else if (a2 >= 600000000 && a2 < 620000000) {
            StringBuilder stringBuilder9 = stringBuilder2;
            stringBuilder = stringBuilder9;
            stringBuilder9.append(SkillType.ALLATORIxDEMO("iRWGAAMRc\u007f"));
        } else if (a2 >= 670000000 && a2 < 677000000 || a2 >= 678000000 && a2 < 682000000) {
            StringBuilder stringBuilder10 = stringBuilder2;
            stringBuilder = stringBuilder10;
            stringBuilder10.append(SkillType.ALLATORIxDEMO("C_KQE_"));
        } else if (a2 >= 677000000 && a2 < 678000000) {
            StringBuilder stringBuilder11 = stringBuilder2;
            stringBuilder = stringBuilder11;
            stringBuilder11.append(SkillType.ALLATORIxDEMO("aCM@KWA\u0002c\u007f"));
        } else if (a2 >= 682000000 && a2 < 683000000) {
            StringBuilder stringBuilder12 = stringBuilder2;
            stringBuilder = stringBuilder12;
            stringBuilder12.append(SkillType.ALLATORIxDEMO("{E_H\\SVA]c\u007f"));
        } else if (a2 >= 683000000 && a2 < 684000000) {
            StringBuilder stringBuilder13 = stringBuilder2;
            stringBuilder = stringBuilder13;
            stringBuilder13.append(SkillType.ALLATORIxDEMO("VRVJG"));
        } else if (a2 >= 684000000 && a2 < 685000000) {
            StringBuilder stringBuilder14 = stringBuilder2;
            stringBuilder = stringBuilder14;
            stringBuilder14.append(SkillType.ALLATORIxDEMO("VRVJG{\u0006P["));
        } else if (a2 >= 700000000 && a2 < 700000300) {
            StringBuilder stringBuilder15 = stringBuilder2;
            stringBuilder = stringBuilder15;
            stringBuilder15.append(SkillType.ALLATORIxDEMO("DAW@ZJT"));
        } else if (a2 >= 800000000 && a2 < 900000000) {
            StringBuilder stringBuilder16 = stringBuilder2;
            stringBuilder = stringBuilder16;
            stringBuilder16.append(SkillType.ALLATORIxDEMO("NC"));
        } else if (a2 >= 700000000 && a2 < 782000002) {
            StringBuilder stringBuilder17 = stringBuilder2;
            stringBuilder = stringBuilder17;
            stringBuilder17.append(SkillType.ALLATORIxDEMO("PLZJVWV"));
        } else {
            StringBuilder stringBuilder18 = stringBuilder2;
            stringBuilder = stringBuilder18;
            stringBuilder18.append(SkillType.ALLATORIxDEMO("VPP"));
        }
        stringBuilder.append("/");
        stringBuilder2.append(a2);
        return stringBuilder2.toString();
    }

    public static /* synthetic */ {
        I = MapleDataProviderFactory.getDataProvider(SkillType.ALLATORIxDEMO("iRT\u001dSI"));
        F = MapleDataProviderFactory.getDataProvider(SkillType.ALLATORIxDEMO("`PAM]C\u001dSI")).getData(SkillType.ALLATORIxDEMO("~EC\nZIT"));
        E = new HashMap<Integer, MapleNodes>();
        B = new HashMap<Integer, List<AbstractLoadedMapleLife>>();
        k = new HashMap<Integer, List<AbstractLoadedMapleLife>>();
        ALLATORIxDEMO = false;
    }
}

