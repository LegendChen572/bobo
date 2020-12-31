/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import java.util.HashMap;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.life.MapleMonster;
import server.life.MobAttackInfo;
import server.shark.SharkLogger;
import tools.Pair;
import tools.Quadra;
import tools.StringUtil;

public class MobAttackInfoFactory {
    private static final /* synthetic */ MobAttackInfoFactory a;
    private static final /* synthetic */ Map<Pair<Integer, Integer>, MobAttackInfo> ALLATORIxDEMO;
    private static final /* synthetic */ MapleDataProvider d;

    public static /* synthetic */ MobAttackInfoFactory getInstance() {
        return a;
    }

    public /* synthetic */ MobAttackInfoFactory() {
        MobAttackInfoFactory a2;
    }

    public static /* synthetic */ {
        a = new MobAttackInfoFactory();
        d = MapleDataProviderFactory.getDataProvider(SharkLogger.ALLATORIxDEMO("aNN\u000f[["));
        ALLATORIxDEMO = new HashMap<Pair<Integer, Integer>, MobAttackInfo>();
    }

    public /* synthetic */ MobAttackInfo getMobAttackInfo(MapleMonster a2, int a3) {
        MobAttackInfo mobAttackInfo = ALLATORIxDEMO.get(new Pair<Integer, Integer>(a2.getId(), a3));
        if (mobAttackInfo != null) {
            return mobAttackInfo;
        }
        MapleData mapleData = d.getData(StringUtil.getLeftPaddedStr(Integer.toString(a2.getId()) + ".img", '0', 11));
        if (mapleData != null) {
            Object object;
            if (mapleData.getChildByPath(Quadra.ALLATORIxDEMO(" X/YfZ X\"")) != null) {
                object = MapleDataTool.getString(SharkLogger.ALLATORIxDEMO("HBGC\u000e@HBJ"), mapleData);
                mapleData = d.getData(StringUtil.getLeftPaddedStr((String)object + ".img", '0', 11));
            }
            if ((object = mapleData.getChildByPath("attack" + (a3 + 1) + "/info")) != null) {
                mobAttackInfo = new MobAttackInfo();
                mobAttackInfo.setDeadlyAttack(object.getChildByPath(Quadra.ALLATORIxDEMO("R,W-Z0w=B(U\"")) != null);
                MobAttackInfo mobAttackInfo2 = mobAttackInfo;
                MobAttackInfo mobAttackInfo3 = mobAttackInfo;
                mobAttackInfo3.setMpBurn(MapleDataTool.getInt(SharkLogger.ALLATORIxDEMO("AQnT^O"), (MapleData)object, 0));
                mobAttackInfo3.setDiseaseSkill(MapleDataTool.getInt(Quadra.ALLATORIxDEMO("-_:S(E,"), (MapleData)object, 0));
                mobAttackInfo2.setDiseaseLevel(MapleDataTool.getInt(SharkLogger.ALLATORIxDEMO("MIWIM"), (MapleData)object, 0));
                mobAttackInfo2.setMpCon(MapleDataTool.getInt(Quadra.ALLATORIxDEMO("*Y'{\u0019"), (MapleData)object, 0));
            }
        }
        ALLATORIxDEMO.put(new Pair<Integer, Integer>(a2.getId(), a3), mobAttackInfo);
        return mobAttackInfo;
    }
}

