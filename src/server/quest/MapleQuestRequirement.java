/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 */
package server.quest;

import client.MapleCharacter;
import client.MapleJob;
import client.SkillFactory;
import client.inventory.MapleInventoryType;
import client.messages.commands.player.\u6070\u6070\u8c37;
import constants.GameConstants;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import provider.MapleData;
import provider.MapleDataTool;
import server.Extend.SpecialItemData;
import server.MapleItemInformationProvider;
import server.quest.MapleQuest;
import server.quest.MapleQuestRequirementType;
import tools.Pair;

public class MapleQuestRequirement
implements Serializable {
    private /* synthetic */ int a;
    private /* synthetic */ String d;
    private /* synthetic */ List<Pair<Integer, Integer>> ALLATORIxDEMO;
    private static final /* synthetic */ long B = 9179541993413738569L;
    private /* synthetic */ MapleQuest k;
    private /* synthetic */ MapleQuestRequirementType K;

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ MapleQuestRequirement(MapleQuest a2, MapleQuestRequirementType a3, MapleData a4) {
        MapleQuestRequirement a5;
        MapleQuestRequirement mapleQuestRequirement = a5;
        mapleQuestRequirement.K = a3;
        mapleQuestRequirement.k = a2;
        switch (1.ALLATORIxDEMO[((Enum)a3).ordinal()]) {
            case 7: {
                a2 = a4.getChildren();
                MapleQuestRequirement mapleQuestRequirement2 = a5;
                mapleQuestRequirement2.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                int n2 = a3 = 0;
                while (n2 < a2.size()) {
                    Integer n3 = a3;
                    int n4 = MapleDataTool.getInt((MapleData)a2.get(a3), -1);
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(n3, n4));
                    n2 = ++a3;
                }
                return;
            }
            case 6: {
                a2 = a4.getChildren();
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                int n5 = a3 = 0;
                while (n5 < a2.size()) {
                    MapleData mapleData = (MapleData)a2.get(a3);
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(MapleDataTool.getInt(mapleData.getChildByPath(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"*\n")), 0), MapleDataTool.getInt(mapleData.getChildByPath(SpecialItemData.ALLATORIxDEMO("RKB]ZZV")), 0)));
                    n5 = ++a3;
                }
                return;
            }
            case 5: {
                a2 = a4.getChildren();
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                int n6 = a3 = 0;
                while (n6 < a2.size()) {
                    MapleData mapleData = (MapleData)a2.get(a3);
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(MapleDataTool.getInt(mapleData.getChildByPath(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"*\n"))), MapleDataTool.getInt(mapleData.getChildByPath(SpecialItemData.ALLATORIxDEMO("@\\R\\V")), 0)));
                    n6 = ++a3;
                }
                return;
            }
            case 4: {
                a2 = a4.getChildren();
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                int n7 = a3 = 0;
                while (n7 < a2.size()) {
                    MapleData mapleData = (MapleData)a2.get(a3);
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(MapleDataTool.getInt(mapleData.getChildByPath(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"*\n"))), MapleDataTool.getInt(mapleData.getChildByPath(SpecialItemData.ALLATORIxDEMO("PGFFG")), 0)));
                    n7 = ++a3;
                }
                return;
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
                a5.a = MapleDataTool.getInt(a4, -1);
                return;
            }
            case 22: {
                a5.d = MapleDataTool.getString(a4, null);
                return;
            }
            case 3: {
                a2 = a4.getChildren();
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                int n8 = a3 = 0;
                while (n8 < a2.size()) {
                    MapleData mapleData = (MapleData)a2.get(a3);
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(MapleDataTool.getInt(mapleData.getChildByPath(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"*\n")), 0), MapleDataTool.getInt(mapleData.getChildByPath(SpecialItemData.ALLATORIxDEMO("PGFFG")), 0)));
                    n8 = ++a3;
                }
                return;
            }
            case 13: {
                a2 = a4.getChildByPath(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"^"));
                MapleQuestRequirement mapleQuestRequirement3 = a5;
                if (a2 != null) {
                    mapleQuestRequirement3.a = MapleDataTool.getInt(a2);
                    return;
                }
                mapleQuestRequirement3.a = -1;
                return;
            }
            case 2: {
                a2 = a4.getChildren();
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                int n9 = a3 = 0;
                while (n9 < a2.size()) {
                    MapleData mapleData = (MapleData)a2.get(a3);
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(MapleDataTool.getInt(mapleData.getChildByPath(SpecialItemData.ALLATORIxDEMO("AW")), 0), MapleDataTool.getInt(mapleData.getChildByPath(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0003*\u0000")), 0)));
                    n9 = ++a3;
                }
                return;
            }
            case 1: {
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                Object object = a2 = a4.iterator();
                while (object.hasNext()) {
                    a3 = (MapleData)a2.next();
                    object = a2;
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(-1, MapleDataTool.getInt(SpecialItemData.ALLATORIxDEMO("AW"), (MapleData)a3, 0)));
                }
                return;
            }
        }
    }

    public /* synthetic */ List<Pair<Integer, Integer>> getDataStore() {
        MapleQuestRequirement a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MapleQuestRequirementType getType() {
        MapleQuestRequirement a2;
        return a2.K;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean check(MapleCharacter a, Integer a) {
        if (a.ALLATORIxDEMO == null) return true;
        if (a.ALLATORIxDEMO.isEmpty()) {
            return true;
        }
        switch (1.ALLATORIxDEMO[a.K.ordinal()]) {
            case 7: {
                var3_3 = a.ALLATORIxDEMO.iterator();
                do {
                    if (var3_3.hasNext() == false) return false;
                    var4_7 = var3_3.next();
                    if (var4_7.getRight().intValue() == a.getJob()) return true;
                } while (!a.isGM());
                return true;
            }
            case 6: {
                var3_4 = a.ALLATORIxDEMO.iterator();
                do lbl-1000:
                // 3 sources

                {
                    if (var3_4.hasNext() == false) return true;
                    var4_8 = var3_4.next();
                    var5_11 = var4_8.getRight() > 0;
                    var6_14 = var4_8.getLeft();
                    var7_18 = SkillFactory.getSkill(var6_14);
                    if (!var5_11) ** GOTO lbl31
                    if (var7_18.isGuildSkill()) {
                        if (a.getGuild() == null) return false;
                        if (a.getGuild().getLevel() < 1) return false;
                        if (a.getGuild().hasSkill(var6_14) == false) return false;
                        return true;
                    }
                    if (a.getSkillLevel(var7_18) == 0) {
                        return false;
                    }
                    if (a.getSkillLevel(var7_18) != 0) ** GOTO lbl-1000
                    return false;
lbl31:
                    // 1 sources

                    if (a.getSkillLevel(var7_18) > 0) return false;
                } while (a.getMasterLevel(var7_18) <= 0);
                return false;
            }
            case 5: {
                var3_5 = a.ALLATORIxDEMO.iterator();
                do lbl-1000:
                // 3 sources

                {
                    v0 = var3_5;
                    while (v0.hasNext() != false) {
                        var4_9 = var3_5.next();
                        var5_12 = a.getQuest(MapleQuest.getInstance(var4_9.getLeft()));
                        var6_15 = var4_9.getRight();
                        if (var6_15 == 0) ** GOTO lbl-1000
                        if (var5_12 == null && var6_15 == 0) {
                            v0 = var3_5;
                            continue;
                        }
                        ** GOTO lbl48
                    }
                    return true;
lbl48:
                    // 1 sources

                    if (a.k.getId() == 1507) {
                        if (GameConstants.isMercedes(a.getJob()) && a.getQuestStatus(23280) == 2) {
                            if (a.getQuestStatus(1514) == 2) return true;
                        }
                        if (GameConstants.isResist(a.getJob()) && a.getQuestStatus(1513) == 2) {
                            if (a.getQuestStatus(23148) == 2) return true;
                        }
                        if (GameConstants.isDemon(a.getJob())) {
                            if (a.getQuestStatus(23280) == 2) return true;
                        }
                        if (a.isAran() && a.getQuestStatus(1512) == 2) {
                            if (a.getQuestStatus(21769) == 2) return true;
                        }
                        if (a.isEvan() && a.getQuestStatus(1511) == 2) {
                            if (a.getQuestStatus(22614) == 2) return true;
                        }
                        if (a.isKOC() && a.getQuestStatus(1510) == 2 && a.getQuestStatus(20742) == 2 && a.getQuestStatus(20741) == 2) {
                            if (a.getQuestStatus(20739) == 2) return true;
                        }
                        if (a.isAdventurer() && a.getQuestStatus(1505) == 2) {
                            return true;
                        }
                    }
                    if (a.k.id == 20734 && a.getLevel() >= 120 && MapleJob.is\u7687\u5bb6\u9a0e\u58eb\u5718(a.getJob())) {
                        return true;
                    }
                    if (var5_12 == null) return false;
                } while (var5_12.getStatus() == var6_15);
                return false;
            }
            case 4: {
                var6_16 = a.ALLATORIxDEMO.iterator();
                do {
                    if (var6_16.hasNext() == false) return true;
                    var7_19 = var6_16.next();
                    var4_10 = var7_19.getLeft();
                    var5_13 = 0;
                    var3_6 = GameConstants.getInventoryType(var4_10);
                    v1 = a.getInventory(var3_6).listById(var4_10).iterator();
                    while (v1.hasNext()) {
                        var9_27 = var8_22.next();
                        var5_13 = (short)(var5_13 + var9_27.getQuantity());
                        v1 = var8_22;
                    }
                    if (!a.hasEquipped(var4_10) || var3_6 != MapleInventoryType.EQUIP) continue;
                    var8_22 = a.getInventory(MapleInventoryType.EQUIPPED).listById(var4_10).iterator();
                    v2 = var8_22;
                    while (v2.hasNext()) {
                        var9_27 = var8_22.next();
                        var5_13 = (short)(var5_13 + var9_27.getQuantity());
                        v2 = var8_22;
                    }
                } while (var5_13 >= (var8_21 = var7_19.getRight().intValue()) && (var8_21 > 0 || var5_13 <= 0));
                var9_27 = MapleItemInformationProvider.getInstance().getName(var4_10);
                switch (var4_10) {
                    case 4031179: {
                        a.dropMessage(-1, "\u7531\u65bc\u8eab\u4e0a\u5df2\u7d93\u6709" + (String)var9_27 + ", \u7121\u6cd5\u63a5\u53d6\u6b64\u4efb\u52d9");
                        a.dropMessage(5, "\u7531\u65bc\u8eab\u4e0a\u5df2\u7d93\u6709" + (String)var9_27 + ", \u7121\u6cd5\u63a5\u53d6\u6b64\u4efb\u52d9");
                        return false;
                    }
                }
                return false;
            }
            case 21: {
                if (a.getLevel() < a.a) return false;
                return true;
            }
            case 20: {
                if (a.getLevel() > a.a) return false;
                return true;
            }
            case 22: {
                var6_17 = a.d;
                var7_20 = Calendar.getInstance();
                var7_20.set(Integer.parseInt(var6_17.substring(0, 4)), Integer.parseInt(var6_17.substring(4, 6)), Integer.parseInt(var6_17.substring(6, 8)), Integer.parseInt(var6_17.substring(8, 10)), 0);
                if (var7_20.getTimeInMillis() < System.currentTimeMillis()) return false;
                return true;
            }
            case 3: {
                var8_23 = a.ALLATORIxDEMO.iterator();
                do {
                    if (var8_23.hasNext() == false) return true;
                    var9_28 = var8_23.next();
                    var10_32 = var9_28.getLeft();
                    var11_34 = var9_28.getRight();
                } while (a.getQuest(a.k).getMobKills(var10_32) >= var11_34);
                return false;
            }
            case 15: {
                if (a == null) return true;
                if (a != a.a) return false;
                return true;
            }
            case 13: {
                if (a.a == -1) return false;
                if (a.a != a.getMapId()) return false;
                return true;
            }
            case 19: {
                if (a.getMonsterBook().getTotalCards() < a.a) return false;
                return true;
            }
            case 2: {
                var8_24 = a.ALLATORIxDEMO.iterator();
                do {
                    if (var8_24.hasNext() == false) return true;
                    var9_29 = var8_24.next();
                    var10_33 = var9_29.getLeft();
                    var11_35 = var9_29.getRight();
                } while (a.getMonsterBook().getLevelByCard(var10_33) >= var11_35);
                return false;
            }
            case 17: {
                if (a.getFame() > a.a) return false;
                return true;
            }
            case 16: {
                if (a.getNumQuest() < a.a) return false;
                return true;
            }
            case 18: {
                if (a.getQuest(a.k).getStatus() != 2) return true;
                if (a.getQuest(a.k).getCompletionTime() > System.currentTimeMillis() - (long)(a.a * 60) * 1000L) return false;
                return true;
            }
            case 1: {
                var8_25 = a.ALLATORIxDEMO.iterator();
                do {
                    if (var8_25.hasNext() == false) return false;
                } while (a.getPetById((var9_30 = var8_25.next()).getRight()) == -1);
                return true;
            }
            case 14: {
                var8_26 = a.getSummonedPets().iterator();
                do {
                    if (var8_26.hasNext() == false) return false;
                } while (!(var9_31 = var8_26.next()).getSummoned() || var9_31.getCloseness() < a.a);
                return true;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void removeQuestItem(MapleCharacter a2) {
        MapleQuestRequirement a3;
        if (a3.ALLATORIxDEMO == null || a3.ALLATORIxDEMO.isEmpty()) {
            return;
        }
        switch (a3.K) {
            case item: {
                Iterator<Pair<Integer, Integer>> iterator;
                Iterator<Pair<Integer, Integer>> iterator2 = iterator = a3.ALLATORIxDEMO.iterator();
                while (iterator2.hasNext()) {
                    Pair<Integer, Integer> pair = iterator.next();
                    a2.gainItem(pair.getLeft(), -pair.getRight().intValue());
                    iterator2 = iterator;
                }
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ MapleQuestRequirement(MapleQuest a2, MapleQuestRequirementType a3, ResultSet a4) throws SQLException {
        MapleQuestRequirement a5;
        MapleQuestRequirement mapleQuestRequirement = a5;
        mapleQuestRequirement.K = a3;
        mapleQuestRequirement.k = a2;
        switch (1.ALLATORIxDEMO[a3.ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                int n2;
                a5.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
                ResultSet resultSet = a4;
                a2 = resultSet.getString(SpecialItemData.ALLATORIxDEMO("A]\\`\\\\ZV[uAA[G")).split(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"oN"));
                a3 = resultSet.getString(SpecialItemData.ALLATORIxDEMO("ZFG{GGAM@{VK\\FW")).split(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"oN"));
                if (a2.length <= 0 && a4.getString(SpecialItemData.ALLATORIxDEMO("A]\\`\\\\ZV[uAA[G")).length() > 0) {
                    a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(Integer.parseInt(a4.getString(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"*\u00007=7\u00011\u000b0(*\u001c0\u001a"))), Integer.parseInt(a4.getString(SpecialItemData.ALLATORIxDEMO("ZFG{GGAM@{VK\\FW")))));
                }
                int n3 = n2 = 0;
                while (n3 < a2.length) {
                    if (a2[n2].length() > 0 && a3[n2].length() > 0) {
                        a5.ALLATORIxDEMO.add(new Pair<Integer, Integer>(Integer.parseInt(a2[n2]), Integer.parseInt(a3[n2])));
                    }
                    n3 = ++n2;
                }
                return;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: {
                a5.a = Integer.parseInt(a4.getString(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001d7\u001c*\u0000$=7\u00011\u000b")));
                return;
            }
            case 22: {
                a5.d = a4.getString(SpecialItemData.ALLATORIxDEMO("@\\AA]O`\\\\ZV"));
                return;
            }
        }
    }

    public /* synthetic */ String toString() {
        MapleQuestRequirement a2;
        return a2.K.toString();
    }
}

