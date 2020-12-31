/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import FuckingHackerToby.L;
import java.util.HashMap;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.maps.MapleReactorStats;
import tools.Pair;
import tools.Quadra;
import tools.StringUtil;

public class MapleReactorFactory {
    private static final /* synthetic */ MapleDataProvider d;
    private static final /* synthetic */ Map<Integer, MapleReactorStats> ALLATORIxDEMO;

    public static final /* synthetic */ MapleReactorStats getReactor(int a2) {
        MapleReactorStats mapleReactorStats = ALLATORIxDEMO.get(a2);
        if (mapleReactorStats == null) {
            int n2 = a2;
            MapleData mapleData = d.getData(StringUtil.getLeftPaddedStr(Integer.toString(n2) + ".img", '0', 11));
            if (mapleData.getChildByPath(Quadra.ALLATORIxDEMO(" X/YfZ X\"")) != null) {
                n2 = MapleDataTool.getIntConvert(L.ALLATORIxDEMO("FAI@\u0000CFAD"), mapleData);
                mapleReactorStats = ALLATORIxDEMO.get(n2);
            }
            if (mapleReactorStats == null) {
                MapleData mapleData2;
                mapleReactorStats = new MapleReactorStats();
                mapleData = d.getData(StringUtil.getLeftPaddedStr(Integer.toString(n2) + ".img", '0', 11));
                if (mapleData == null) {
                    return mapleReactorStats;
                }
                boolean bl = MapleDataTool.getInt(Quadra.ALLATORIxDEMO("_'P&\u0019(U=_?W=S\u000bO\u001dY<U!"), mapleData, 0) > 0;
                boolean bl2 = false;
                boolean bl3 = false;
                byte by = 0;
                MapleData mapleData3 = mapleData;
                while ((mapleData2 = mapleData3.getChildByPath(String.valueOf(by))) != null) {
                    byte by2;
                    if ((mapleData2 = mapleData2.getChildByPath(L.ALLATORIxDEMO("JYJA["))) != null && mapleData2.getChildByPath(Quadra.ALLATORIxDEMO("y")) != null) {
                        MapleData mapleData4 = mapleData2.getChildByPath(L.ALLATORIxDEMO("\u001f"));
                        Pair<Integer, Integer> pair = null;
                        int n3 = MapleDataTool.getIntConvert(Quadra.ALLATORIxDEMO("B0F,"), mapleData4);
                        if (n3 == 100) {
                            pair = new Pair<Integer, Integer>(MapleDataTool.getIntConvert(L.ALLATORIxDEMO("\u001f"), mapleData4), MapleDataTool.getIntConvert("1", mapleData4, 1));
                            if (!bl2) {
                                MapleReactorStats mapleReactorStats2 = mapleReactorStats;
                                mapleReactorStats2.setTL(MapleDataTool.getPoint(Quadra.ALLATORIxDEMO("Z="), mapleData4));
                                mapleReactorStats2.setBR(MapleDataTool.getPoint(L.ALLATORIxDEMO("]M"), mapleData4));
                                bl2 = true;
                            }
                        }
                        bl3 = true;
                        mapleReactorStats.addState(by, n3, pair, (byte)MapleDataTool.getIntConvert(Quadra.ALLATORIxDEMO(":B(B,"), mapleData4), MapleDataTool.getIntConvert(L.ALLATORIxDEMO("[FBJ`Z["), mapleData2, -1), (byte)(bl ? 2 : (MapleDataTool.getIntConvert("2", mapleData4, 0) > 0 || mapleData4.getChildByPath(Quadra.ALLATORIxDEMO("*Z U\"w;S(")) != null || n3 == 9 ? 1 : 0)));
                        by2 = by;
                    } else {
                        mapleReactorStats.addState(by, 999, null, (byte)(bl3 ? -1 : by + 1), 0, (byte)0);
                        by2 = by;
                    }
                    by = (byte)(by2 + 1);
                    mapleData3 = mapleData;
                }
                ALLATORIxDEMO.put(n2, mapleReactorStats);
                if (a2 != n2) {
                    ALLATORIxDEMO.put(a2, mapleReactorStats);
                }
            } else {
                ALLATORIxDEMO.put(a2, mapleReactorStats);
            }
        }
        return mapleReactorStats;
    }

    public /* synthetic */ MapleReactorFactory() {
        MapleReactorFactory a2;
    }

    public static /* synthetic */ {
        d = MapleDataProviderFactory.getDataProvider(L.ALLATORIxDEMO("}JNL[@]\u0001XU"));
        ALLATORIxDEMO = new HashMap<Integer, MapleReactorStats>();
    }
}

