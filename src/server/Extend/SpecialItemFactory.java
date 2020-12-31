/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.Extend;

import client.MapleCharacter;
import client.MapleStat;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.opcodes.MapleBuffStat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.Extend.SpecialItemData;
import server.MapleSquad;
import server.MapleStatEffect;
import tools.Eval;
import tools.MaplePacketCreator;
import tools.Pair;

public class SpecialItemFactory {
    public final /* synthetic */ Map<Integer, MapleStatEffect> SpecialItemEffectCache;
    public final /* synthetic */ Map<Integer, SpecialItemData> SpecialItemCache;
    private static final /* synthetic */ SpecialItemFactory ALLATORIxDEMO;

    public static final /* synthetic */ SpecialItemFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new SpecialItemFactory();
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void loadSpecialItem() {
        SpecialItemFactory a2;
        SpecialItemFactory specialItemFactory = a2;
        specialItemFactory.SpecialItemEffectCache.clear();
        specialItemFactory.SpecialItemCache.clear();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(Eval.ALLATORIxDEMO("\f\u0001\u0013\u0001\u001c\u0010\u007fn\u007f\u0002\r\u000b\u0012d,4:'6%3\u001b60:)"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int n2 = resultSet.getInt(MapleSquad.ALLATORIxDEMO("|xpa|h"));
            SpecialItemData specialItemData = new SpecialItemData(n2, resultSet.getInt(Eval.ALLATORIxDEMO("!'4")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("q~z|")), resultSet.getInt(Eval.ALLATORIxDEMO("2!,+")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("bmag")), resultSet.getInt(Eval.ALLATORIxDEMO("2%+/")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("bhpj")), resultSet.getInt(Eval.ALLATORIxDEMO("2 :\"")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("mvo")), resultSet.getInt(Eval.ALLATORIxDEMO("%)+6 ")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("\u007fyx|")), resultSet.getInt(Eval.ALLATORIxDEMO("7/!: ")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("}|gmai")), resultSet.getInt(Eval.ALLATORIxDEMO("24-%+!")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("\u007fa~")), resultSet.getInt(Eval.ALLATORIxDEMO(" :<")), resultSet.getInt(MapleSquad.ALLATORIxDEMO("e{x")), resultSet.getInt(Eval.ALLATORIxDEMO("(*/")));
            a2.SpecialItemCache.put(n2, specialItemData);
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
            return;
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block11: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block11;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                    }
                    throw throwable2;
                }
                catch (SQLException sQLException) {
                    System.out.println(sQLException);
                }
            }
        }
    }

    public /* synthetic */ MapleStatEffect getEffect(int a2) {
        SpecialItemFactory a3;
        if (a3.SpecialItemEffectCache.get(a2) != null) {
            return a3.SpecialItemEffectCache.get(a2);
        }
        MapleStatEffect mapleStatEffect = new MapleStatEffect();
        SpecialItemData specialItemData = a3.getDataByItemId(a2);
        if (specialItemData != null) {
            MapleStatEffect mapleStatEffect2 = mapleStatEffect;
            MapleStatEffect mapleStatEffect3 = mapleStatEffect;
            SpecialItemData specialItemData2 = specialItemData;
            MapleStatEffect mapleStatEffect4 = mapleStatEffect;
            SpecialItemData specialItemData3 = specialItemData;
            MapleStatEffect mapleStatEffect5 = mapleStatEffect;
            SpecialItemData specialItemData4 = specialItemData;
            MapleStatEffect mapleStatEffect6 = mapleStatEffect;
            SpecialItemData specialItemData5 = specialItemData;
            MapleStatEffect mapleStatEffect7 = mapleStatEffect;
            mapleStatEffect7.sourceid = a2;
            mapleStatEffect7.mhpR = (byte)specialItemData.getHpRate();
            mapleStatEffect.mmpR = (byte)specialItemData5.getMpRate();
            mapleStatEffect6.watk = (byte)specialItemData5.getWatk();
            mapleStatEffect6.wdef = (byte)specialItemData.getWdef();
            mapleStatEffect.matk = (byte)specialItemData4.getMatk();
            mapleStatEffect5.mdef = (byte)specialItemData4.getMdef();
            mapleStatEffect5.acc = (byte)specialItemData.getAcc();
            mapleStatEffect.avoid = (byte)specialItemData3.getAvoid();
            mapleStatEffect4.speed = (byte)specialItemData3.getSpeed();
            mapleStatEffect4.jump = (byte)specialItemData.getJump();
            mapleStatEffect.expBuff = (byte)specialItemData2.getExp();
            mapleStatEffect3.itemup = (byte)specialItemData2.getDrop();
            mapleStatEffect3.mesoup = (byte)specialItemData.getMeso();
            mapleStatEffect2.duration = Integer.MAX_VALUE;
            mapleStatEffect2.overTime = true;
            ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.WATK, Integer.valueOf(mapleStatEffect.watk));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.WDEF, Integer.valueOf(mapleStatEffect.wdef));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MATK, Integer.valueOf(mapleStatEffect.matk));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MDEF, Integer.valueOf(mapleStatEffect.mdef));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.ACC, Integer.valueOf(mapleStatEffect.acc));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.AVOID, Integer.valueOf(mapleStatEffect.avoid));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.SPEED, Integer.valueOf(mapleStatEffect.speed));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.JUMP, Integer.valueOf(mapleStatEffect.jump));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MAXHP, Integer.valueOf(mapleStatEffect.mhpR));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MAXMP, Integer.valueOf(mapleStatEffect.mmpR));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.EXPRATE, mapleStatEffect.expBuff);
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.DROP_RATE, mapleStatEffect.prob);
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MESO_RATE, mapleStatEffect.prob);
            mapleStatEffect2.statups = arrayList;
            a3.SpecialItemEffectCache.put(a2, mapleStatEffect);
        }
        return mapleStatEffect;
    }

    public /* synthetic */ void handleBuff(MapleCharacter a2) {
        SpecialItemFactory a3;
        if (a3.SpecialItemCache.isEmpty()) {
            return;
        }
        for (int n2 : a3.SpecialItemCache.keySet()) {
            if (!a2.haveItem(n2)) continue;
            a3.getEffect(n2).applyTo(a2);
        }
        a3.handleStat(a2);
    }

    public /* synthetic */ SpecialItemData getDataByItemId(int a2) {
        SpecialItemFactory a3;
        SpecialItemData specialItemData = null;
        if (a3.SpecialItemCache.isEmpty()) {
            return null;
        }
        if (a3.SpecialItemCache.containsKey(a2)) {
            specialItemData = a3.SpecialItemCache.get(a2);
        }
        return specialItemData;
    }

    public /* synthetic */ SpecialItemFactory() {
        SpecialItemFactory a2;
        SpecialItemFactory specialItemFactory = a2;
        a2.SpecialItemCache = new HashMap<Integer, SpecialItemData>();
        specialItemFactory.SpecialItemEffectCache = new HashMap<Integer, MapleStatEffect>();
        System.out.println(MapleSquad.ALLATORIxDEMO("\u3005\u8b8c\u53c3\u4e21\u3004,F|po|myEaixJtoacgu56/6"));
    }

    public /* synthetic */ void handleStat(MapleCharacter a2) {
        SpecialItemFactory a3;
        if (a3.SpecialItemCache.isEmpty()) {
            return;
        }
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        Object object = a3.SpecialItemCache.keySet().iterator();
        while (object.hasNext()) {
            int n6 = object.next();
            if (!a2.haveItem(n6)) continue;
            SpecialItemData specialItemData = a3.getDataByItemId(n6);
            n2 += specialItemData.getStr();
            n3 += specialItemData.getDex();
            n4 += specialItemData.getInt();
            n5 += specialItemData.getLuk();
        }
        object = new ArrayList();
        if (n2 > 0) {
            object.add(new Pair<MapleStat, Integer>(MapleStat.STR, a2.getStr() + n2));
        }
        if (n3 > 0) {
            object.add(new Pair<MapleStat, Integer>(MapleStat.DEX, a2.getDex() + n3));
        }
        if (n4 > 0) {
            object.add(new Pair<MapleStat, Integer>(MapleStat.INT, a2.getInt() + n4));
        }
        if (n5 > 0) {
            object.add(new Pair<MapleStat, Integer>(MapleStat.LUK, a2.getLuk() + n5));
        }
        if (object.size() > 0) {
            a2.getClient().sendPacket(MaplePacketCreator.updatePlayerStats((List<Pair<MapleStat, Integer>>)object, a2));
        }
    }
}

