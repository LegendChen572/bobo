/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5154\u5154\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.quest;

import client.MapleCharacter;
import client.MapleQuestStatus;
import client.messages.commands.player.\u5154\u5154\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import handling.channel.handler.BuddyListHandler;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import scripting.npc.NPCScriptManager;
import server.ItemInformation;
import server.quest.MapleQuestAction;
import server.quest.MapleQuestActionType;
import server.quest.MapleQuestRequirement;
import server.quest.MapleQuestRequirementType;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.use.GetMACAddress;

public class MapleQuest
implements Serializable {
    private /* synthetic */ boolean k;
    private /* synthetic */ boolean H;
    private /* synthetic */ boolean K;
    private /* synthetic */ boolean a;
    public /* synthetic */ Map<Integer, Integer> relevantMobs;
    public /* synthetic */ List<MapleQuestRequirement> completeReqs;
    private /* synthetic */ int ALLATORIxDEMO;
    public /* synthetic */ List<MapleQuestAction> startActs;
    public /* synthetic */ String name;
    public /* synthetic */ int id;
    public /* synthetic */ Map<String, List<Pair<String, Pair<String, Integer>>>> partyQuestInfo;
    private /* synthetic */ boolean e;
    private /* synthetic */ int d;
    private /* synthetic */ boolean B;
    private static final /* synthetic */ Map<Integer, MapleQuest> C;
    public /* synthetic */ List<MapleQuestRequirement> startReqs;
    private /* synthetic */ boolean E;
    private static final /* synthetic */ long F = 9179541993413738569L;
    private /* synthetic */ boolean g;
    public /* synthetic */ List<MapleQuestAction> completeActs;

    public /* synthetic */ void start(MapleCharacter a2, int a3, boolean a42) {
        MapleQuest a5;
        if (a5.canStart(a2, a3) && (a5.H || a5.checkNPCOnMap(a2, a3) || !a42)) {
            MapleQuestAction mapleQuestAction;
            Object a42 = a5.startActs.iterator();
            while (a42.hasNext()) {
                mapleQuestAction = a42.next();
                if (mapleQuestAction.checkEnd(a2, null)) continue;
                return;
            }
            Object object = a42 = a5.startActs.iterator();
            while (object.hasNext()) {
                mapleQuestAction = a42.next();
                object = a42;
                mapleQuestAction.runStart(a2, null);
            }
            if (a2.getQuestStatus(a5.getId()) == 0 || a5.E) {
                a42 = null;
                if (a5.getId() == 6029) {
                    a42 = BuddyListHandler.ALLATORIxDEMO("\nG\n");
                }
                a5.forceStart(a2, a3, (String)a42);
                return;
            }
            if (a5.g) {
                NPCScriptManager.getInstance().endQuest(a2.getClient(), a3, a5.getId(), true);
            }
        }
    }

    public /* synthetic */ boolean canComplete(MapleCharacter a2, Integer a3) {
        MapleQuest a4;
        if (a2.getQuest(a4).getStatus() != 1) {
            return false;
        }
        Iterator<MapleQuestRequirement> iterator = a4.completeReqs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().check(a2, a3)) continue;
            return false;
        }
        return true;
    }

    public /* synthetic */ MapleQuest(int a2) {
        MapleQuest a3;
        MapleQuest mapleQuest = a3;
        MapleQuest mapleQuest2 = a3;
        MapleQuest mapleQuest3 = a3;
        MapleQuest mapleQuest4 = a3;
        MapleQuest mapleQuest5 = a3;
        MapleQuest mapleQuest6 = a3;
        MapleQuest mapleQuest7 = a3;
        a3.startReqs = new LinkedList<MapleQuestRequirement>();
        mapleQuest7.completeReqs = new LinkedList<MapleQuestRequirement>();
        a3.startActs = new LinkedList<MapleQuestAction>();
        a3.completeActs = new LinkedList<MapleQuestAction>();
        a3.partyQuestInfo = new LinkedHashMap<String, List<Pair<String, Pair<String, Integer>>>>();
        a3.relevantMobs = new LinkedHashMap<Integer, Integer>();
        mapleQuest6.H = false;
        mapleQuest6.e = false;
        mapleQuest5.E = false;
        mapleQuest5.g = false;
        mapleQuest4.B = false;
        mapleQuest4.k = false;
        mapleQuest3.K = false;
        mapleQuest3.a = false;
        mapleQuest2.d = false ? 1 : 0;
        mapleQuest2.ALLATORIxDEMO = 0;
        mapleQuest.name = "";
        mapleQuest.id = a2;
    }

    public /* synthetic */ boolean hasStartScript() {
        MapleQuest a2;
        return a2.a;
    }

    public /* synthetic */ void complete(MapleCharacter a2, int a3, Integer a4) {
        MapleQuest a5;
        a5.complete(a2, a3, a4, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ MapleQuest ALLATORIxDEMO(ResultSet a2, PreparedStatement a3, PreparedStatement a4, PreparedStatement a5, PreparedStatement a6, PreparedStatement a7, PreparedStatement a8) throws SQLException {
        Enum enum_;
        MapleQuest mapleQuest;
        MapleQuest mapleQuest2 = mapleQuest = new MapleQuest(a2.getInt(BuddyListHandler.ALLATORIxDEMO("K\u0002_\u0004N\u001e^")));
        mapleQuest2.name = a2.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"b@aD"));
        mapleQuest2.H = a2.getInt(BuddyListHandler.ALLATORIxDEMO("[\u0002N\u0018i\u0003[\u0005N")) > 0;
        mapleQuest.e = a2.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"@yUcq~DONaQ`DxD")) > 0;
        mapleQuest.k = a2.getInt(BuddyListHandler.ALLATORIxDEMO("\u0016O\u0003U6Y\u0014_\u0007N")) > 0;
        mapleQuest.K = a2.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"mTxNONaQ`DxD")) > 0;
        MapleQuest mapleQuest3 = mapleQuest;
        ResultSet resultSet = a2;
        mapleQuest.d = resultSet.getInt(BuddyListHandler.ALLATORIxDEMO("L\u001e_\u0000w\u0012^\u0016V>N\u0012W"));
        mapleQuest3.ALLATORIxDEMO = resultSet.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"RiMiBxDhrgH`MEe"));
        mapleQuest3.B = a2.getInt(BuddyListHandler.ALLATORIxDEMO("X\u001bU\u0014Q\u0012^")) > 0;
        AutoCloseable autoCloseable = a3;
        autoCloseable.setInt(1, mapleQuest.id);
        a3 = autoCloseable.executeQuery();
        while (a3.next()) {
            AutoCloseable autoCloseable2;
            enum_ = MapleQuestRequirementType.getByWZName(a3.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"b@aD")));
            MapleQuestRequirement mapleQuestRequirement = new MapleQuestRequirement(mapleQuest, (MapleQuestRequirementType)enum_, (ResultSet)a3);
            switch (1.ALLATORIxDEMO[enum_.ordinal()]) {
                case 1: 
                case 2: {
                    mapleQuest.E = true;
                    autoCloseable2 = a3;
                    break;
                }
                case 3: {
                    mapleQuest.E = true;
                    mapleQuest.H = true;
                    autoCloseable2 = a3;
                    break;
                }
                case 4: {
                    mapleQuest.a = true;
                    autoCloseable2 = a3;
                    break;
                }
                case 5: {
                    mapleQuest.g = true;
                    autoCloseable2 = a3;
                    break;
                }
                case 6: {
                    Iterator<Pair<Integer, Integer>> iterator = mapleQuestRequirement.getDataStore().iterator();
                    while (iterator.hasNext()) {
                        Iterator<Pair<Integer, Integer>> iterator2;
                        Pair<Integer, Integer> pair = iterator2.next();
                        mapleQuest.relevantMobs.put((Integer)pair.left, (Integer)pair.right);
                        iterator = iterator2;
                    }
                }
                default: {
                    autoCloseable2 = a3;
                }
            }
            MapleQuest mapleQuest4 = mapleQuest;
            if (autoCloseable2.getInt(BuddyListHandler.ALLATORIxDEMO("\u0003C\u0007_")) == 0) {
                mapleQuest4.startReqs.add(mapleQuestRequirement);
                continue;
            }
            mapleQuest4.completeReqs.add(mapleQuestRequirement);
        }
        a3.close();
        PreparedStatement preparedStatement = a4;
        preparedStatement.setInt(1, mapleQuest.id);
        a3 = preparedStatement.executeQuery();
        block9: while (true) {
            AutoCloseable autoCloseable3 = a3;
            while (autoCloseable3.next()) {
                AutoCloseable autoCloseable4 = a3;
                enum_ = MapleQuestActionType.getByWZName(autoCloseable4.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"b@aD")));
                if (autoCloseable4.getInt(BuddyListHandler.ALLATORIxDEMO("\u0003C\u0007_")) == 0) {
                    if (enum_ != MapleQuestActionType.item || mapleQuest.id == 7103) {
                        // empty if block
                    }
                    mapleQuest.startActs.add(new MapleQuestAction((MapleQuestActionType)enum_, (ResultSet)a3, mapleQuest, a5, a6, a7));
                    continue block9;
                }
                if (enum_ == MapleQuestActionType.item && mapleQuest.id == 7102) {
                    autoCloseable3 = a3;
                    continue;
                }
                mapleQuest.completeActs.add(new MapleQuestAction((MapleQuestActionType)enum_, (ResultSet)a3, mapleQuest, a5, a6, a7));
                continue block9;
            }
            break;
        }
        a3.close();
        PreparedStatement preparedStatement2 = a8;
        preparedStatement2.setInt(1, mapleQuest.id);
        a3 = preparedStatement2.executeQuery();
        AutoCloseable autoCloseable5 = a3;
        while (true) {
            if (!autoCloseable5.next()) {
                a3.close();
                return mapleQuest;
            }
            if (!mapleQuest.partyQuestInfo.containsKey(a3.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"~@bJ")))) {
                mapleQuest.partyQuestInfo.put(a3.getString(BuddyListHandler.ALLATORIxDEMO("\u0005[\u0019Q")), new ArrayList());
            }
            mapleQuest.partyQuestInfo.get(a3.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"~@bJ"))).add(new Pair<String, Pair<String, Integer>>(a3.getString(BuddyListHandler.ALLATORIxDEMO("\u001aU\u0013_")), new Pair<String, Integer>(a3.getString(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"|ScQiSxX")), a3.getInt(BuddyListHandler.ALLATORIxDEMO("L\u0016V\u0002_")))));
            autoCloseable5 = a3;
        }
    }

    public /* synthetic */ boolean isBlocked() {
        MapleQuest a2;
        return a2.B;
    }

    public /* synthetic */ int getId() {
        MapleQuest a2;
        return a2.id;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean checkNPCOnMap(MapleCharacter a2, int a3) {
        boolean bl = false;
        switch (a3) {
            case 9000040: 
            case 9000066: {
                bl = true;
                break;
            }
        }
        if (GameConstants.isEvan(a2.getJob()) && (a3 == 1013000 || a3 == 1013203)) {
            bl = true;
        }
        if (a2.getSubcategory() == 1 && (a3 == 1057006 || a3 == 1057001)) {
            bl = true;
        }
        if (a2.getMap() == null) return bl;
        if (!a2.getMap().containsNPC(a3)) return bl;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void initQuests(boolean a2) {
        PreparedStatement preparedStatement;
        PreparedStatement preparedStatement2;
        ResultSet resultSet;
        PreparedStatement preparedStatement3;
        PreparedStatement preparedStatement4;
        PreparedStatement preparedStatement5;
        PreparedStatement preparedStatement6;
        PreparedStatement preparedStatement7;
        PreparedStatement preparedStatement8;
        PreparedStatement preparedStatement9;
        DruidPooledConnection druidPooledConnection;
        if (a2) {
            C.clear();
        }
        if (!C.isEmpty()) {
            return;
        }
        System.out.println(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"\u301c\u8ba1\u53da\u4e0c\u301d\u0001A@|MipyD\u007fU,\u001b6\u001b"));
        try {
            druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                preparedStatement9 = druidPooledConnection.prepareStatement(BuddyListHandler.ALLATORIxDEMO("$\u007f;\u007f4nW\u0010W|%u:\u001a\u0000@(K\u0002_\u0004N\u0013[\u0003["));
                try {
                    DruidPooledConnection druidPooledConnection2 = druidPooledConnection;
                    preparedStatement8 = druidPooledConnection2.prepareStatement(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"rImIbX\u0001&\u0001JsCl,Vv~}TiRxSiPh@x@,vDd^d,PyD\u007fUeE,\u001c,\u001e"));
                    preparedStatement7 = druidPooledConnection2.prepareStatement(BuddyListHandler.ALLATORIxDEMO("i2v2y#\u001a]\u001a1h8wWM\re\u0006O\u0012I\u0003[\u0014N\u0013[\u0003[Wm?\u007f%\u007fWK\u0002_\u0004N\u001e^W\u0007W\u0005"));
                    preparedStatement6 = druidPooledConnection2.prepareStatement(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"rImIbX\u0001&\u0001JsCl,Vv~}TiRx@oU\u007fJeM`EmUm\u0001[iIsI\u0001yOePyDeE,\u001c,\u001e"));
                    preparedStatement5 = druidPooledConnection2.prepareStatement(BuddyListHandler.ALLATORIxDEMO("i2v2y#\u001a]\u001a1h8wWM\re\u0006O\u0012I\u0003[\u0014N\u0006O\u0012I\u0003^\u0016N\u0016\u001a r2h2\u001a\u0002T\u001eK\u0002_\u001e^W\u0007W\u0005"));
                    preparedStatement4 = druidPooledConnection2.prepareStatement(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"_d@dOu,\u000b,g^nA\u0001{[SPyD\u007fUmBxHxDaEmUm\u0001[iIsI\u0001yOePyDeE,\u001c,\u001e"));
                    preparedStatement3 = druidPooledConnection2.prepareStatement(BuddyListHandler.ALLATORIxDEMO("i2v2y#\u001a]\u001a1h8wWM\re\u0006O\u0012I\u0003J\u0016H\u0003C\u0013[\u0003[Wm?\u007f%\u007fWK\u0002_\u0004N\u001e^W\u0007W\u0005"));
                    resultSet = preparedStatement9.executeQuery();
                    try {
                        while (resultSet.next()) {
                            C.put(resultSet.getInt(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"PyD\u007fUeE")), MapleQuest.ALLATORIxDEMO(resultSet, preparedStatement8, preparedStatement7, preparedStatement6, preparedStatement5, preparedStatement4, preparedStatement3));
                        }
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                                throwable2 = throwable;
                                throw throwable2;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                        throw throwable2;
                    }
                }
                catch (Throwable throwable) {
                    Throwable throwable4;
                    if (preparedStatement9 != null) {
                        try {
                            preparedStatement9.close();
                            throwable4 = throwable;
                            throw throwable4;
                        }
                        catch (Throwable throwable5) {
                            throwable.addSuppressed(throwable5);
                        }
                    }
                    throwable4 = throwable;
                    throw throwable4;
                }
            }
            catch (Throwable throwable) {
                Throwable throwable6;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
                        throwable6 = throwable;
                        throw throwable6;
                    }
                    catch (Throwable throwable7) {
                        throwable.addSuppressed(throwable7);
                    }
                }
                throwable6 = throwable;
                throw throwable6;
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
            return;
        }
        if (resultSet != null) {
            preparedStatement2 = preparedStatement9;
            resultSet.close();
        } else {
            preparedStatement2 = preparedStatement9;
        }
        if (preparedStatement2 != null) {
            preparedStatement = preparedStatement8;
            preparedStatement9.close();
        } else {
            preparedStatement = preparedStatement8;
        }
        preparedStatement.close();
        preparedStatement7.close();
        preparedStatement6.close();
        preparedStatement5.close();
        preparedStatement4.close();
        preparedStatement3.close();
        if (druidPooledConnection == null) return;
        druidPooledConnection.close();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void complete(MapleCharacter a, int a, Integer a, boolean a) {
        block14: {
            if (!a.isGM()) break block14;
            if (!a.canComplete(a, a)) ** GOTO lbl-1000
            v0 = a;
            ** GOTO lbl8
        }
        if ((a.e || a.checkNPCOnMap(a, a) || !a) && a.canComplete(a, a)) {
            v0 = a;
lbl8:
            // 3 sources

            for (MapleQuestAction var6_11 : v0.completeActs) {
                if (var6_11.checkEnd(a, a)) continue;
                return;
            }
            a.forceComplete(a, a);
            var5_9 = true;
            for (MapleQuestAction a : a.completeActs) {
                if (!a.runEnd(a, a)) continue;
                var5_9 = false;
            }
            var6_13 = MapleQuest.getInstance(a.id + 1);
            if (var6_13 != null) {
                for (MapleQuestRequirement var7_17 : var6_13.startReqs) {
                    if (var7_17 == null || var7_17.getType() != MapleQuestRequirementType.item) continue;
                    for (Pair<Integer, Integer> var9_19 : var7_17.getDataStore()) {
                        for (MapleQuestRequirement var11_22 : a.completeReqs) {
                            if (var11_22 == null || var11_22.getType() != MapleQuestRequirementType.item) continue;
                            var11_23 = var11_22.getDataStore().iterator();
                            while (var11_23.hasNext()) {
                                if (var11_23.next().getLeft().intValue() != var9_19.getLeft().intValue()) continue;
                                var5_9 = false;
                            }
                        }
                    }
                }
            }
            if (var5_9) {
                v1 = a = a.completeReqs.iterator();
                while (v1.hasNext()) {
                    var7_17 = a.next();
                    v1 = a;
                    var7_17.removeQuestItem(a);
                }
            }
            v2 = a;
            v2.getClient().sendPacket(MaplePacketCreator.showQuestFinishEffect());
            v3 = a;
            v2.getMap().broadcastMessage(v3, MaplePacketCreator.showForeignQuestFinishEffect(v3.getId()), false);
            v4 = a;
        } else lbl-1000:
        // 2 sources

        {
            if (a.id == 29507) {
                for (MapleQuestAction var6_14 : a.completeActs) {
                    if (var6_14.checkEnd(a, a)) continue;
                    return;
                }
                v5 = a;
                v5.forceComplete(a, a);
                var5_10 = v5.completeActs.iterator();
                v6 = var5_10;
                while (v6.hasNext()) {
                    var6_16 = var5_10.next();
                    v6 = var5_10;
                    var6_16.runEnd(a, a);
                }
                v7 = a;
                v7.getClient().sendPacket(MaplePacketCreator.showQuestFinishEffect());
                v8 = a;
                v7.getMap().broadcastMessage(v8, MaplePacketCreator.showForeignQuestFinishEffect(v8.getId()), false);
            }
            v4 = a;
        }
        if (v4.id != 22579) return;
        v9 = a;
        v9.changeMap(200090080);
        v9.startMapTimeLimitTask(900, 914100000);
    }

    public final /* synthetic */ int getSkillID() {
        MapleQuest a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ {
        C = new LinkedHashMap<Integer, MapleQuest>();
    }

    public static /* synthetic */ Collection<MapleQuest> getAllInstances() {
        return C.values();
    }

    public /* synthetic */ void start(MapleCharacter a2, int a3) {
        int n2;
        MapleQuestAction mapleQuestAction;
        Object object;
        MapleQuest a4;
        if ((a4.H || a4.checkNPCOnMap(a2, a3)) && a4.canStart(a2, a3)) {
            object = a4.startActs.iterator();
            while (object.hasNext()) {
                mapleQuestAction = object.next();
                if (mapleQuestAction.checkEnd(a2, null)) continue;
                return;
            }
            Object object2 = object = a4.startActs.iterator();
            while (object2.hasNext()) {
                mapleQuestAction = object.next();
                object2 = object;
                mapleQuestAction.runStart(a2, null);
            }
            if (a2.getQuestStatus(a4.getId()) == 0 || a4.E) {
                object = null;
                if (a4.getId() == 6029) {
                    object = \u5154\u5154\u8c37.ALLATORIxDEMO((String)"\u0011<\u0011");
                }
                a4.forceStart(a2, a3, (String)object);
            } else if (a4.g) {
                NPCScriptManager.getInstance().endQuest(a2.getClient(), a3, a4.getId(), true);
            }
        } else if (GameConstants.CanAcceptQuest(a4.id)) {
            object = a4.startActs.iterator();
            while (object.hasNext()) {
                mapleQuestAction = object.next();
                if (mapleQuestAction.checkEnd(a2, null)) continue;
                return;
            }
            Object object3 = object = a4.startActs.iterator();
            while (object3.hasNext()) {
                mapleQuestAction = object.next();
                object3 = object;
                mapleQuestAction.runStart(a2, null);
            }
            if (!a4.g) {
                a4.forceStart(a2, a3, null);
            } else {
                NPCScriptManager.getInstance().endQuest(a2.getClient(), a3, a4.getId(), true);
            }
        }
        int n3 = n2 = 0;
        while (n3 < GameSetConstants.QUEST_FORCE_COMPLETE.length) {
            if (a4.getId() == GameSetConstants.QUEST_FORCE_COMPLETE[n2]) {
                a4.forceComplete(a2, a3);
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ int getMedalItem() {
        MapleQuest a2;
        return a2.d;
    }

    public /* synthetic */ void forceStart_update(MapleCharacter a2, int a3, String a4) {
        MapleQuest a5;
        MapleQuestStatus mapleQuestStatus = a3 = new MapleQuestStatus(a5, 1, a3);
        MapleCharacter mapleCharacter = a2;
        a3.setForfeited(mapleCharacter.getQuest(a5).getForfeited());
        mapleQuestStatus.setCompletionTime(mapleCharacter.getQuest(a5).getCompletionTime());
        mapleQuestStatus.setCustomData(a4);
        a2.forceupdateQuest(mapleQuestStatus);
    }

    public static /* synthetic */ void clearQuests() {
        MapleQuest.initQuests(true);
    }

    public final /* synthetic */ String getName() {
        MapleQuest a2;
        return a2.name;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean RenewQuest(int a2) {
        switch (a2) {
            case 10619: {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ Map<Integer, Integer> getRelevantMobs() {
        MapleQuest a2;
        return a2.relevantMobs;
    }

    public static /* synthetic */ MapleQuest getInstance(int a2) {
        MapleQuest mapleQuest = C.get(a2);
        if (mapleQuest == null) {
            mapleQuest = new MapleQuest(a2);
            try {
                C.put(a2, mapleQuest);
                return mapleQuest;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                FileoutputUtil.outputFileError("logs/Except/\u8173\u672c\u932f\u8aa4.txt", exception);
                FileoutputUtil.log("logs/Except/\u8173\u672c\u932f\u8aa4.txt", "Caused by questID " + a2);
                System.out.println("Caused by questID " + a2);
            }
        }
        return mapleQuest;
    }

    public final /* synthetic */ void RestoreLostItem(MapleCharacter a2, int a3) {
        MapleQuest a4;
        Iterator<MapleQuestAction> iterator = a4.startActs.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().RestoreLostItem(a2, a3)) continue;
            return;
        }
    }

    public /* synthetic */ void forceComplete(MapleCharacter a2, int a3) {
        MapleQuest a4;
        MapleQuestStatus mapleQuestStatus = new MapleQuestStatus(a4, 2, a3);
        MapleCharacter mapleCharacter = a2;
        mapleQuestStatus.setForfeited(mapleCharacter.getQuest(a4).getForfeited());
        mapleCharacter.updateQuest(mapleQuestStatus);
    }

    public /* synthetic */ void forfeit(MapleCharacter a2) {
        MapleQuestStatus mapleQuestStatus;
        MapleQuest a3;
        if (((MapleCharacter)a2).getQuest(a3).getStatus() != 1) {
            return;
        }
        MapleCharacter mapleCharacter = a2;
        a2 = mapleCharacter.getQuest(a3);
        MapleQuestStatus mapleQuestStatus2 = mapleQuestStatus = new MapleQuestStatus(a3, 0);
        mapleQuestStatus2.setForfeited(((MapleQuestStatus)a2).getForfeited() + 1);
        mapleQuestStatus2.setCompletionTime(((MapleQuestStatus)a2).getCompletionTime());
        mapleCharacter.updateQuest(mapleQuestStatus2);
    }

    public /* synthetic */ boolean canStart(MapleCharacter a2, Integer a3) {
        MapleQuest a4;
        if (!(a2.getQuest(a4).getStatus() == 0 || a2.getQuest(a4).getStatus() == 2 && a4.E)) {
            return false;
        }
        if (GameSetConstants.MAPLE_VERSION != 75 && a4.B && !a2.isGM()) {
            return false;
        }
        Iterator<MapleQuestRequirement> iterator = a4.startReqs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().check(a2, a3)) continue;
            return false;
        }
        return true;
    }

    public /* synthetic */ List<Pair<String, Pair<String, Integer>>> getInfoByRank(String a2) {
        MapleQuest a3;
        return a3.partyQuestInfo.get(a2);
    }

    public /* synthetic */ void complete(MapleCharacter a2, int a3) {
        MapleQuest a4;
        a4.complete(a2, a3, null, true);
    }

    public /* synthetic */ void forceStart(MapleCharacter a2, int a3, String a4) {
        MapleQuest a5;
        MapleQuestStatus mapleQuestStatus = a3 = new MapleQuestStatus(a5, 1, a3);
        MapleCharacter mapleCharacter = a2;
        a3.setForfeited(mapleCharacter.getQuest(a5).getForfeited());
        mapleQuestStatus.setCompletionTime(mapleCharacter.getQuest(a5).getCompletionTime());
        mapleQuestStatus.setCustomData(a4);
        a2.updateQuest(mapleQuestStatus);
    }

    public static final class MedalQuest
    extends Enum<MedalQuest> {
        public static final /* synthetic */ /* enum */ MedalQuest \u51b0\u539f\u96ea\u57df\u5c71\u8108\u63a2\u96aa\u5bb6;
        private static final /* synthetic */ MedalQuest[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ MedalQuest \u6d77\u5e95\u63a2\u96aa\u5bb6;
        public static final /* synthetic */ /* enum */ MedalQuest \u5947\u5e7b\u6751\u63a2\u96aa\u5bb6;
        public static final /* synthetic */ /* enum */ MedalQuest \u6b66\u9675\u6843\u5712\u63a2\u96aa\u5bb6;
        public static final /* synthetic */ /* enum */ MedalQuest \u8def\u5fb7\u65af\u6e56\u63a2\u96aa\u5bb6;
        public /* synthetic */ int lquestid;
        public static final /* synthetic */ /* enum */ MedalQuest \u7c73\u7d0d\u723e\u68ee\u6797\u63a2\u96aa\u5bb6;
        public static final /* synthetic */ /* enum */ MedalQuest \u7d0d\u5e0c\u6c99\u6f20\u63a2\u96aa\u5bb6;
        public /* synthetic */ int[] maps;
        public /* synthetic */ int level;
        public /* synthetic */ int questid;
        public static final /* synthetic */ /* enum */ MedalQuest \u65b0\u624b\u5192\u96aa\u5bb6;

        public static /* synthetic */ {
            int[] arrn = new int[20];
            arrn[0] = 104000000;
            arrn[1] = 0x6331111;
            arrn[2] = 100000006;
            arrn[3] = 104020000;
            arrn[4] = 100000000;
            arrn[5] = 100010000;
            arrn[6] = 100040000;
            arrn[7] = 100040100;
            arrn[8] = 101010103;
            arrn[9] = 101020000;
            arrn[10] = 101000000;
            arrn[11] = 102000000;
            arrn[12] = 101030104;
            arrn[13] = 101030406;
            arrn[14] = 102020300;
            arrn[15] = 103000000;
            arrn[16] = 102050000;
            arrn[17] = 103010001;
            arrn[18] = 103030200;
            arrn[19] = 110000000;
            \u65b0\u624b\u5192\u96aa\u5bb6 = new MedalQuest(GetMACAddress.ALLATORIxDEMO("\u65d3\u6252\u51f1\u96b3\u5bd5"), 0, 29005, 29015, 15, arrn);
            int[] arrn2 = new int[10];
            arrn2[0] = 200000000;
            arrn2[1] = 200010100;
            arrn2[2] = 200010300;
            arrn2[3] = 200080000;
            arrn2[4] = 200080100;
            arrn2[5] = 211000000;
            arrn2[6] = 211030000;
            arrn2[7] = 211040300;
            arrn2[8] = 211041200;
            arrn2[9] = 211041800;
            \u51b0\u539f\u96ea\u57df\u5c71\u8108\u63a2\u96aa\u5bb6 = new MedalQuest(ItemInformation.ALLATORIxDEMO("\u51f3\u53c4\u96a9\u5784\u5c32\u8153\u63e1\u96f1\u5bf5"), 1, 29006, 29012, 50, arrn2);
            int[] arrn3 = new int[10];
            arrn3[0] = 222000000;
            arrn3[1] = 222010400;
            arrn3[2] = 222020000;
            arrn3[3] = 220000000;
            arrn3[4] = 220020300;
            arrn3[5] = 220040200;
            arrn3[6] = 221020701;
            arrn3[7] = 221000000;
            arrn3[8] = 221030600;
            arrn3[9] = 221040400;
            \u8def\u5fb7\u65af\u6e56\u63a2\u96aa\u5bb6 = new MedalQuest(GetMACAddress.ALLATORIxDEMO("\u8d8c\u5fae\u65cc\u6e4f\u63c1\u96b3\u5bd5"), 2, 29007, 29012, 40, arrn3);
            int[] arrn4 = new int[10];
            arrn4[0] = 230000000;
            arrn4[1] = 230010400;
            arrn4[2] = 230010200;
            arrn4[3] = 230010201;
            arrn4[4] = 230020000;
            arrn4[5] = 230020201;
            arrn4[6] = 230030100;
            arrn4[7] = 230040000;
            arrn4[8] = 230040200;
            arrn4[9] = 230040400;
            \u6d77\u5e95\u63a2\u96aa\u5bb6 = new MedalQuest(ItemInformation.ALLATORIxDEMO("\u6d34\u5ece\u63e1\u96f1\u5bf5"), 3, 29008, 29012, 40, arrn4);
            int[] arrn5 = new int[10];
            arrn5[0] = 251000000;
            arrn5[1] = 251010200;
            arrn5[2] = 251010402;
            arrn5[3] = 251010500;
            arrn5[4] = 250010500;
            arrn5[5] = 250010504;
            arrn5[6] = 250000000;
            arrn5[7] = 250010300;
            arrn5[8] = 250010304;
            arrn5[9] = 250020300;
            \u6b66\u9675\u6843\u5712\u63a2\u96aa\u5bb6 = new MedalQuest(GetMACAddress.ALLATORIxDEMO("\u6b05\u966c\u6820\u570b\u63c1\u96b3\u5bd5"), 4, 29009, 29012, 50, arrn5);
            int[] arrn6 = new int[10];
            arrn6[0] = 261030000;
            arrn6[1] = 261020401;
            arrn6[2] = 261020000;
            arrn6[3] = 261010100;
            arrn6[4] = 261000000;
            arrn6[5] = 260020700;
            arrn6[6] = 260020300;
            arrn6[7] = 260000000;
            arrn6[8] = 260010600;
            arrn6[9] = 260010300;
            \u7d0d\u5e0c\u6c99\u6f20\u63a2\u96aa\u5bb6 = new MedalQuest(ItemInformation.ALLATORIxDEMO("\u7d4e\u5e57\u6cda\u6f7b\u63e1\u96f1\u5bf5"), 5, 29010, 29012, 70, arrn6);
            int[] arrn7 = new int[10];
            arrn7[0] = 240000000;
            arrn7[1] = 240010200;
            arrn7[2] = 240010800;
            arrn7[3] = 240020401;
            arrn7[4] = 240020101;
            arrn7[5] = 240030000;
            arrn7[6] = 240040400;
            arrn7[7] = 240040511;
            arrn7[8] = 240040521;
            arrn7[9] = 240050000;
            \u7c73\u7d0d\u723e\u68ee\u6797\u63a2\u96aa\u5bb6 = new MedalQuest(GetMACAddress.ALLATORIxDEMO("\u7c6a\u7d6e\u7227\u688d\u678e\u63c1\u96b3\u5bd5"), 6, 29011, 29012, 70, arrn7);
            int[] arrn8 = new int[10];
            arrn8[0] = 105040300;
            arrn8[1] = 105070001;
            arrn8[2] = 105040305;
            arrn8[3] = 105090200;
            arrn8[4] = 105090300;
            arrn8[5] = 105090301;
            arrn8[6] = 105090312;
            arrn8[7] = 105090500;
            arrn8[8] = 105090900;
            arrn8[9] = 105080000;
            \u5947\u5e7b\u6751\u63a2\u96aa\u5bb6 = new MedalQuest(ItemInformation.ALLATORIxDEMO("\u591c\u5e38\u670a\u63e1\u96f1\u5bf5"), 7, 29014, 29015, 50, arrn8);
            MedalQuest[] arrmedalQuest = new MedalQuest[8];
            arrmedalQuest[0] = \u65b0\u624b\u5192\u96aa\u5bb6;
            arrmedalQuest[1] = \u51b0\u539f\u96ea\u57df\u5c71\u8108\u63a2\u96aa\u5bb6;
            arrmedalQuest[2] = \u8def\u5fb7\u65af\u6e56\u63a2\u96aa\u5bb6;
            arrmedalQuest[3] = \u6d77\u5e95\u63a2\u96aa\u5bb6;
            arrmedalQuest[4] = \u6b66\u9675\u6843\u5712\u63a2\u96aa\u5bb6;
            arrmedalQuest[5] = \u7d0d\u5e0c\u6c99\u6f20\u63a2\u96aa\u5bb6;
            arrmedalQuest[6] = \u7c73\u7d0d\u723e\u68ee\u6797\u63a2\u96aa\u5bb6;
            arrmedalQuest[7] = \u5947\u5e7b\u6751\u63a2\u96aa\u5bb6;
            ALLATORIxDEMO = arrmedalQuest;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ MedalQuest(int n22, int n22, int a2, int[] a3) {
            void a4;
            void a5;
            void var2_-1;
            void var1_-1;
            MedalQuest a6;
            MedalQuest medalQuest = a6;
            MedalQuest medalQuest2 = a6;
            medalQuest2.questid = a2;
            medalQuest2.level = a5;
            medalQuest.lquestid = (int)a3;
            medalQuest.maps = a4;
        }

        public static /* synthetic */ MedalQuest[] values() {
            return (MedalQuest[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ MedalQuest valueOf(String a2) {
            return Enum.valueOf(MedalQuest.class, a2);
        }
    }
}

