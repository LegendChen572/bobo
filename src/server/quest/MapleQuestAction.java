/*
 * Decompiled with CFR 0.150.
 */
package server.quest;

import client.MapleCharacter;
import client.MapleQuestStatus;
import client.MapleStat;
import client.MapleTrait;
import client.SkillEntry;
import client.SkillFactory;
import client.inventory.InventoryException;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.RandomRewards;
import server.Randomizer;
import server.quest.MapleQuest;
import server.quest.MapleQuestActionType;
import tools.FileoutputUtil;
import tools.JsonMapConverter;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.Triple;

public class MapleQuestAction
implements Serializable {
    private /* synthetic */ MapleQuest B;
    private /* synthetic */ List<Triple<Integer, Integer, Integer>> d;
    private /* synthetic */ List<QuestItem> a;
    private /* synthetic */ List<Integer> K;
    private /* synthetic */ List<Pair<Integer, Integer>> ALLATORIxDEMO;
    private /* synthetic */ MapleQuestActionType g;
    private static final /* synthetic */ long E = 9179541993413738569L;
    private /* synthetic */ int k;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean checkEnd(MapleCharacter a, Integer a) {
        switch (1.d[a.g.ordinal()]) {
            case 1: {
                var3_3 = new HashMap<Integer, Integer>();
                for (QuestItem var5_7 : a.a) {
                    if (var5_7.prop <= 0 || !MapleQuestAction.ALLATORIxDEMO(var5_7, a)) continue;
                    v0 = var6_9 = 0;
                    while (v0 < var5_7.prop) {
                        v1 = var3_3;
                        v1.put(v1.size(), var5_7.itemid);
                        v0 = ++var6_9;
                    }
                }
                var4_6 = 0;
                var5_8 = 0;
                if (var3_3.size() > 0) {
                    v2 = var3_3;
                    var4_6 = (Integer)v2.get(Randomizer.nextInt(v2.size()));
                }
                var6_9 = 0;
                var7_10 = 0;
                var8_11 = 0;
                var9_12 = 0;
                var10_13 = 0;
                var11_14 = a.a.iterator();
                block13: while (true) {
                    v3 = var11_14;
                    while (v3.hasNext()) {
                        var12_15 = var11_14.next();
                        if (!MapleQuestAction.ALLATORIxDEMO(var12_15, a)) {
                            v3 = var11_14;
                            continue;
                        }
                        v4 = var12_15;
                        var13_17 = v4.itemid;
                        if (v4.prop == -2) ** GOTO lbl40
                        if (var12_15.prop == -1) {
                            if (a == null || a != var5_8++) continue block13;
                            v5 = var12_15;
                        } else {
                            if (var13_17 != var4_6) continue block13;
lbl40:
                            // 2 sources

                            v5 = var12_15;
                        }
                        var12_16 = (short)v5.count;
                        if (var12_16 < 0) {
                            if (a.haveItem(var13_17, Math.abs(var12_16), false, true)) continue block13;
                            a.dropMessage(1, "\u60a8\u8eab\u4e0a\u9700\u8981" + MapleItemInformationProvider.getInstance().getName(var13_17) + " x " + Math.abs(var12_16) + " \u4f86\u5b8c\u6210\u4efb\u52d9\u3002");
                            return false;
                        }
                        if (MapleItemInformationProvider.getInstance().isPickupRestricted(var13_17) && a.haveItem(var13_17, true ? 1 : 0, true, false)) {
                            a.dropMessage(1, "\u4f60\u5df2\u7d93\u6709\u4e86\u9019\u500b\u9053\u5177: " + MapleItemInformationProvider.getInstance().getName(var13_17));
                            return false;
                        }
                        switch (1.ALLATORIxDEMO[GameConstants.getInventoryType(var13_17).ordinal()]) {
                            case 1: {
                                var6_9 = (byte)(var6_9 + 1);
                                continue block13;
                            }
                            case 2: {
                                var7_10 = (byte)(var7_10 + 1);
                                continue block13;
                            }
                            case 3: {
                                var8_11 = (byte)(var8_11 + 1);
                                continue block13;
                            }
                            case 4: {
                                var9_12 = (byte)(var9_12 + 1);
                                continue block13;
                            }
                            case 5: {
                                var10_13 = (byte)(var10_13 + 1);
                                continue block13;
                            }
                        }
                        continue block13;
                    }
                    break;
                }
                if (a.getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() < var6_9) {
                    a.dropMessage(1, JsonMapConverter.ALLATORIxDEMO("\u8abe\u78be\u8af8\u88d9\u50ec\u6b00\u665a\u5422\u6e8a\u4e82\u3077"));
                    return false;
                }
                if (a.getInventory(MapleInventoryType.USE).getNumFreeSlot() < var7_10) {
                    a.dropMessage(1, SkillEntry.ALLATORIxDEMO("\u8ade\u788b\u8a98\u6db9\u8002\u6b35\u663a\u5417\u6eea\u4eb7\u3017"));
                    return false;
                }
                if (a.getInventory(MapleInventoryType.SETUP).getNumFreeSlot() < var8_11) {
                    a.dropMessage(1, JsonMapConverter.ALLATORIxDEMO("\u8abe\u78be\u8af8\u88d9\u988b\u6b00\u665a\u5422\u6e8a\u4e82\u3077"));
                    return false;
                }
                if (a.getInventory(MapleInventoryType.ETC).getNumFreeSlot() < var9_12) {
                    a.dropMessage(1, SkillEntry.ALLATORIxDEMO("\u8ade\u788b\u8a98\u5147\u4ec3\u6b35\u663a\u5417\u6eea\u4eb7\u3017"));
                    return false;
                }
                if (a.getInventory(MapleInventoryType.CASH).getNumFreeSlot() >= var10_13) return true;
                a.dropMessage(1, JsonMapConverter.ALLATORIxDEMO("\u8abe\u78be\u8af8\u727d\u6bff\u6b00\u665a\u5422\u6e8a\u4e82\u3077"));
                return false;
            }
            case 6: {
                var3_4 = a.k;
                if (a.getMeso() + var3_4 < 0) {
                    a.dropMessage(1, SkillEntry.ALLATORIxDEMO("\u6946\u5e52\u4e18\u8d82;"));
                    return false;
                }
                if (var3_4 >= 0) return true;
                if (a.getMeso() >= Math.abs(var3_4)) return true;
                a.dropMessage(1, JsonMapConverter.ALLATORIxDEMO("\u6926\u5e67\u4e78\u8db7["));
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ MapleQuestActionType getType() {
        MapleQuestAction a2;
        return a2.g;
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(QuestItem a2, MapleCharacter a3) {
        return a2.gender == 2 || a2.gender < 0 || a2.gender == a3.getGender();
    }

    public /* synthetic */ String toString() {
        MapleQuestAction a2;
        return a2.g.toString();
    }

    private static /* synthetic */ List<Integer> H(int a2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if ((a2 & 1) != 0) {
            arrayList.add(0);
        }
        if ((a2 & 2) != 0) {
            arrayList.add(100);
        }
        if ((a2 & 4) != 0) {
            arrayList.add(200);
        }
        if ((a2 & 8) != 0) {
            arrayList.add(300);
        }
        if ((a2 & 0x10) != 0) {
            arrayList.add(400);
        }
        if ((a2 & 0x20) != 0) {
            arrayList.add(500);
        }
        if ((a2 & 0x400) != 0) {
            arrayList.add(1000);
        }
        if ((a2 & 0x800) != 0) {
            arrayList.add(1100);
        }
        if ((a2 & 0x1000) != 0) {
            arrayList.add(1200);
        }
        if ((a2 & 0x2000) != 0) {
            arrayList.add(1300);
        }
        if ((a2 & 0x4000) != 0) {
            arrayList.add(1400);
        }
        if ((a2 & 0x8000) != 0) {
            arrayList.add(1500);
        }
        if ((a2 & 0x20000) != 0) {
            arrayList.add(2001);
            arrayList.add(2200);
        }
        if ((a2 & 0x100000) != 0) {
            arrayList.add(2000);
            arrayList.add(2001);
        }
        if ((a2 & 0x200000) != 0) {
            arrayList.add(2100);
        }
        if ((a2 & 0x400000) != 0) {
            arrayList.add(2001);
            arrayList.add(2200);
        }
        if ((a2 & 0x40000000) != 0) {
            arrayList.add(3000);
            arrayList.add(3200);
            arrayList.add(3300);
            arrayList.add(3500);
        }
        return arrayList;
    }

    public /* synthetic */ List<Triple<Integer, Integer, Integer>> getSkills() {
        MapleQuestAction a2;
        return a2.d;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void runStart(MapleCharacter a, Integer a) {
        switch (1.d[a.g.ordinal()]) {
            case 4: {
                var3_3 = a.getQuest(a.B);
                if (var3_3.getForfeited() > 0) {
                    return;
                }
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    v0 = a;
                    v0.gainExp(a.k * GameConstants.getExpRate_Quest(a) * a.getStat().questBonus * (v0.getTrait(MapleTrait.MapleTraitType.\u611f\u6027).getLevel() * 3 / 10 + 100) / 100, true, true, true);
                    return;
                }
                a.gainExp(a.k * GameConstants.getExpRate_Quest(a), true, true, true);
                return;
            }
            case 1: {
                var6_10 = new HashMap<Integer, Integer>();
                for (QuestItem var8_15 : a.a) {
                    if (var8_15.prop <= 0 || !MapleQuestAction.ALLATORIxDEMO(var8_15, a)) continue;
                    v1 = var9_19 = 0;
                    while (v1 < var8_15.prop) {
                        v2 = var6_10;
                        v2.put(v2.size(), var8_15.itemid);
                        v1 = ++var9_19;
                    }
                }
                var4_22 = 0;
                var5_24 = 0;
                if (var6_10.size() > 0) {
                    v3 = var6_10;
                    var4_22 = (Integer)v3.get(Randomizer.nextInt(v3.size()));
                }
                var7_11 = a.a.iterator();
                while (true) {
                    v4 = var7_11;
                    while (v4.hasNext() != false) {
                        var8_15 = var7_11.next();
                        if (!MapleQuestAction.ALLATORIxDEMO(var8_15, a)) {
                            v4 = var7_11;
                            continue;
                        }
                        ** GOTO lbl39
                    }
                    return;
lbl39:
                    // 1 sources

                    v5 = var8_15;
                    var9_19 = v5.itemid;
                    if (v5.prop == -2) ** GOTO lbl47
                    if (var8_15.prop == -1) {
                        if (a != null || a.intValue() != var5_24++) continue;
                        v6 = var8_15;
                    } else {
                        if (var9_19 != var4_22) continue;
lbl47:
                        // 2 sources

                        v6 = var8_15;
                    }
                    var10_25 = (short)v6.count;
                    if (var10_25 < 0) {
                        try {
                            MapleInventoryManipulator.removeById(a.getClient(), GameConstants.getInventoryType(var9_19), var9_19, var10_25 * -1, true, false);
                            v7 = a;
                        }
                        catch (InventoryException var11_28) {
                            System.err.println("[h4x] Completing a quest without meeting the requirements" + var11_28);
                            v7 = a;
                        }
                        v7.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.getShowItemGain(var9_19, var10_25, true));
                        continue;
                    }
                    var11_29 = var8_15.period / 1440;
                    var12_32 = MapleItemInformationProvider.getInstance().getName(var9_19);
                    if (var9_19 / 10000 == 114 && var12_32 != null && var12_32.length() > 0) {
                        var13_35 = "\u4f60\u5df2\u7372\u5f97\u7a31\u865f <" + var12_32 + ">";
                        v8 = a;
                        v8.dropMessage(-1, var13_35);
                        v8.dropMessage(5, var13_35);
                    }
                    MapleInventoryManipulator.addById(a.getClient(), var9_19, var10_25, "", null, var11_29);
                    a.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.getShowItemGain(var9_19, var10_25, true));
                }
            }
            case 5: {
                var3_4 = a.getQuest(a.B);
                if (var3_4.getForfeited() > 0) {
                    return;
                }
                a.getClient().sendPacket(MaplePacketCreator.updateQuestFinish(a.B.getId(), var3_4.getNpc(), a.k));
                return;
            }
            case 6: {
                var3_5 = a.getQuest(a.B);
                if (var3_5.getForfeited() > 0) {
                    return;
                }
                a.gainMeso(a.k, true, false, true);
                return;
            }
            case 2: {
                v9 = var7_12 = a.ALLATORIxDEMO.iterator();
                while (v9.hasNext() != false) {
                    var8_16 = var7_12.next();
                    a.updateQuest(new MapleQuestStatus(MapleQuest.getInstance((Integer)var8_16.left), ((Integer)var8_16.right).byteValue()));
                    v9 = var7_12;
                }
                return;
            }
            case 3: {
                var7_13 = a.d.iterator();
                while (var7_13.hasNext() != false) {
                    var8_17 = var7_13.next();
                    var9_20 = (Integer)var8_17.left;
                    var10_26 = (Integer)var8_17.mid;
                    var11_30 = (Integer)var8_17.right;
                    var12_33 = SkillFactory.getSkill(var9_20);
                    var13_36 = false;
                    for (int var4_23 : a.K) {
                        if (a.getJob() != var4_23) continue;
                        var13_36 = true;
                        v10 = var12_33;
                        ** GOTO lbl111
                    }
                    v10 = var12_33;
lbl111:
                    // 2 sources

                    if (!v10.isBeginnerSkill() && !var13_36) continue;
                    v11 = var12_33;
                    a.changeSkillLevel(v11, (int)((byte)Math.max(var10_26, a.getSkillLevel(v11))), (int)((byte)Math.max(var11_30, a.getMasterLevel(var12_33))));
                }
                return;
            }
            case 7: {
                var3_6 = a.getQuest(a.B);
                if (var3_6.getForfeited() > 0) {
                    return;
                }
                var7_14 = a.k;
                v12 = a;
                v12.addFame(var7_14);
                v13 = a;
                v12.updateSingleStat(MapleStat.FAME, v13.getFame());
                v13.getClient().sendPacket(MaplePacketCreator.getShowFameGain(var7_14));
                return;
            }
            case 8: {
                var3_7 = a.getQuest(a.B);
                if (var3_7.getForfeited() > 0 && a.B.getId() != 23118) {
                    return;
                }
                var8_18 = a.k;
                if (var8_18 == -1) {
                    return;
                }
                MapleItemInformationProvider.getInstance().getItemEffect(var8_18).applyTo(a);
                return;
            }
            case 9: {
                return;
            }
            case 10: {
                var3_8 = a.getQuest(a.B);
                if (var3_8.getForfeited() > 0) {
                    return;
                }
                v14 = a;
                var9_21 = v14.k;
                if (v14.K.size() <= 0) {
                    a.gainSP(var9_21);
                    return;
                }
                var10_27 = 0;
                for (int var12_34 : a.K) {
                    if (a.getJob() < var12_34 || var12_34 <= var10_27) continue;
                    var10_27 = var12_34;
                }
                v15 = a;
                if (var10_27 == 0) {
                    v15.gainSP(var9_21);
                    return;
                }
                v15.gainSP(var9_21, GameConstants.getSkillBook(var10_27));
                return;
            }
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: {
                var3_9 = a.getQuest(a.B);
                if (var3_9.getForfeited() > 0) {
                    return;
                }
                a.getTrait(MapleTrait.MapleTraitType.getByQuestName(a.g.name())).addExp(a.k, a);
                return;
            }
        }
    }

    public /* synthetic */ List<QuestItem> getItems() {
        MapleQuestAction a2;
        return a2.a;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ boolean runEnd(MapleCharacter a, Integer a) {
        var3_3 = false;
        switch (1.d[a.g.ordinal()]) {
            case 4: {
                a.gainExp(a.k * GameConstants.getExpRate_Quest(a), true, true, true);
                return var3_3;
            }
            case 1: {
                var4_4 = new HashMap<Integer, Integer>();
                for (QuestItem var6_15 : a.a) {
                    if (var6_15.prop <= 0 || !MapleQuestAction.ALLATORIxDEMO(var6_15, a)) continue;
                    v0 = var7_19 = 0;
                    while (v0 < var6_15.prop) {
                        v1 = var4_4;
                        v1.put(v1.size(), var6_15.itemid);
                        v0 = ++var7_19;
                    }
                }
                var5_11 = 0;
                var6_16 = 0;
                if (var4_4.size() > 0) {
                    v2 = var4_4;
                    var5_11 = (Integer)v2.get(Randomizer.nextInt(v2.size()));
                }
                var7_20 = a.a.iterator();
                while (true) {
                    v3 = var7_20;
                    while (v3.hasNext() != false) {
                        var8_23 = var7_20.next();
                        if (!MapleQuestAction.ALLATORIxDEMO(var8_23, a)) {
                            v3 = var7_20;
                            continue;
                        }
                        ** GOTO lbl33
                    }
                    return var3_3;
lbl33:
                    // 1 sources

                    v4 = var8_23;
                    var9_25 = v4.itemid;
                    if (v4.prop == -2) ** GOTO lbl41
                    if (var8_23.prop == -1) {
                        if (a == null || a != var6_16++) continue;
                        v5 = var8_23;
                    } else {
                        if (var9_25 != var5_11) continue;
lbl41:
                        // 2 sources

                        v5 = var8_23;
                    }
                    var10_27 = (short)v5.count;
                    if (var10_27 < 0) {
                        var3_3 = true;
                        MapleInventoryManipulator.removeById(a.getClient(), GameConstants.getInventoryType(var9_25), var9_25, var10_27 * -1, true, false);
                        a.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.getShowItemGain(var9_25, var10_27, true));
                        continue;
                    }
                    var11_29 = var8_23.period / 1440;
                    var12_31 = MapleItemInformationProvider.getInstance().getName(var9_25);
                    if (var9_25 / 10000 == 114 && var12_31 != null && var12_31.length() > 0) {
                        var13_33 = "\u4f60\u7372\u5f97\u4e86\u52f3\u7ae0 <" + var12_31 + ">";
                        v6 = a;
                        v6.dropMessage(-1, var13_33);
                        v6.dropMessage(5, var13_33);
                    }
                    MapleInventoryManipulator.addById(a.getClient(), var9_25, var10_27, "", null, var11_29);
                    a.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.getShowItemGain(var9_25, var10_27, true));
                }
            }
            case 5: {
                a.getClient().sendPacket(MaplePacketCreator.updateQuestFinish(a.B.getId(), a.getQuest(a.B).getNpc(), a.k));
                return var3_3;
            }
            case 6: {
                a.gainMeso(a.k, true, false, true);
                return var3_3;
            }
            case 2: {
                v7 = var4_5 = a.ALLATORIxDEMO.iterator();
                while (v7.hasNext() != false) {
                    var5_12 = var4_5.next();
                    a.updateQuest(new MapleQuestStatus(MapleQuest.getInstance((Integer)var5_12.left), ((Integer)var5_12.right).byteValue()));
                    v7 = var4_5;
                }
                return var3_3;
            }
            case 3: {
                var4_6 = a.d.iterator();
                while (var4_6.hasNext() != false) {
                    var5_13 = var4_6.next();
                    var6_17 = (Integer)var5_13.left;
                    var7_21 = (Integer)var5_13.mid;
                    var8_24 = (Integer)var5_13.right;
                    var9_26 = SkillFactory.getSkill(var6_17);
                    var10_28 = false;
                    for (int var12_32 : a.K) {
                        if (a.getJob() != var12_32) continue;
                        var10_28 = true;
                        v8 = var9_26;
                        ** GOTO lbl94
                    }
                    v8 = var9_26;
lbl94:
                    // 2 sources

                    if (!v8.isBeginnerSkill() && !var10_28) continue;
                    v9 = var9_26;
                    a.changeSkillLevel(v9, (int)((byte)Math.max(var7_21, a.getSkillLevel(v9))), (int)((byte)Math.max(var8_24, a.getMasterLevel(var9_26))));
                }
                return var3_3;
            }
            case 7: {
                var4_7 = a.k;
                v10 = a;
                v10.addFame(var4_7);
                v11 = a;
                v10.updateSingleStat(MapleStat.FAME, v11.getFame());
                v11.getClient().sendPacket(MaplePacketCreator.getShowFameGain(var4_7));
                return var3_3;
            }
            case 8: {
                var4_8 = a.k;
                if (var4_8 == -1) {
                    return var3_3;
                }
                MapleItemInformationProvider.getInstance().getItemEffect(var4_8).applyTo(a);
                return var3_3;
            }
            case 9: {
                return var3_3;
            }
            case 10: {
                v12 = a;
                var4_9 = v12.k;
                if (v12.K.size() <= 0) {
                    a.gainSP(var4_9);
                    return var3_3;
                }
                var5_14 = 0;
                for (int var7_22 : a.K) {
                    if (a.getJob() < var7_22 || var7_22 <= var5_14) continue;
                    var5_14 = var7_22;
                }
                v13 = a;
                if (var5_14 == 0) {
                    v13.gainSP(var4_9);
                    return var3_3;
                }
                v13.gainSP(var4_9, GameConstants.getSkillBook(var5_14));
                return var3_3;
            }
        }
        return var3_3;
    }

    private static /* synthetic */ List<Integer> ALLATORIxDEMO(int a2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if ((a2 & 1) != 0) {
            arrayList.add(200);
        }
        if ((a2 & 2) != 0) {
            arrayList.add(300);
        }
        if ((a2 & 4) != 0) {
            arrayList.add(400);
        }
        if ((a2 & 8) != 0) {
            arrayList.add(500);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ MapleQuestAction(MapleQuestActionType a2, ResultSet a3, MapleQuest a4, PreparedStatement a5, PreparedStatement a6, PreparedStatement a7) throws SQLException {
        int n2;
        MapleQuestAction a8;
        ResultSet resultSet = a3;
        MapleQuestAction mapleQuestAction = a8;
        MapleQuestAction mapleQuestAction2 = a8;
        MapleQuestAction mapleQuestAction3 = a8;
        mapleQuestAction3.k = 0;
        MapleQuestAction mapleQuestAction4 = a8;
        mapleQuestAction3.K = new ArrayList<Integer>();
        mapleQuestAction3.a = null;
        mapleQuestAction2.d = null;
        mapleQuestAction2.ALLATORIxDEMO = null;
        mapleQuestAction.g = a2;
        mapleQuestAction.B = a4;
        a8.k = resultSet.getInt(JsonMapConverter.ALLATORIxDEMO("m\u001bp&p\u001av\u0010"));
        a4 = resultSet.getString(SkillEntry.ALLATORIxDEMO("PeAyXvPw]p{zSf")).split(JsonMapConverter.ALLATORIxDEMO("(U"));
        if (((String[])a4).length <= 0 && a3.getString(SkillEntry.ALLATORIxDEMO("PeAyXvPw]p{zSf")).length() > 0) {
            a8.K.add(Integer.parseInt(a3.getString(JsonMapConverter.ALLATORIxDEMO("e\u0005t\u0019m\u0016e\u0017h\u0010N\u001af\u0006"))));
        }
        int n3 = ((Object)a4).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            Object object = a4[n2];
            if (((String)object).length() > 0) {
                a8.K.add(Integer.parseInt((String)object));
            }
            n4 = ++n2;
        }
        switch (1.d[a2.ordinal()]) {
            case 1: {
                a8.a = new ArrayList<QuestItem>();
                PreparedStatement preparedStatement = a7;
                preparedStatement.setInt(1, a3.getInt(SkillEntry.ALLATORIxDEMO("D{XdDpXq")));
                Object object = a4 = preparedStatement.executeQuery();
                while (true) {
                    if (!object.next()) {
                        a4.close();
                        return;
                    }
                    object = a4;
                    a8.a.add(new QuestItem(a4.getInt(JsonMapConverter.ALLATORIxDEMO("m\u0001a\u0018m\u0011")), a4.getInt(SkillEntry.ALLATORIxDEMO("v^`_a")), a4.getInt(JsonMapConverter.ALLATORIxDEMO("t\u0010v\u001ck\u0011")), a4.getInt(SkillEntry.ALLATORIxDEMO("Vp_qTg")), a4.getInt(JsonMapConverter.ALLATORIxDEMO("\u001fk\u0017")), a4.getInt(SkillEntry.ALLATORIxDEMO("\u007f^wtm")), a4.getInt(JsonMapConverter.ALLATORIxDEMO("t\u0007k\u0005"))));
                }
            }
            case 2: {
                a8.ALLATORIxDEMO = new ArrayList<Pair<Integer, Integer>>();
                PreparedStatement preparedStatement = a6;
                preparedStatement.setInt(1, a3.getInt(SkillEntry.ALLATORIxDEMO("D{XdDpXq")));
                Object object = a4 = preparedStatement.executeQuery();
                while (true) {
                    if (!object.next()) {
                        a4.close();
                        return;
                    }
                    object = a4;
                    a8.ALLATORIxDEMO.add(new Pair<Integer, Integer>(a4.getInt(JsonMapConverter.ALLATORIxDEMO("\u0004q\u0010w\u0001")), a4.getInt(SkillEntry.ALLATORIxDEMO("fEtEp"))));
                }
            }
            case 3: {
                a8.d = new ArrayList<Triple<Integer, Integer, Integer>>();
                PreparedStatement preparedStatement = a5;
                preparedStatement.setInt(1, a3.getInt(JsonMapConverter.ALLATORIxDEMO("q\u001bm\u0004q\u0010m\u0011")));
                Object object = a4 = preparedStatement.executeQuery();
                while (object.next()) {
                    object = a4;
                    a8.d.add(new Triple<Integer, Integer, Integer>(a4.getInt(SkillEntry.ALLATORIxDEMO("fZ|]yXq")), a4.getInt(JsonMapConverter.ALLATORIxDEMO("w\u001em\u0019h9a\u0003a\u0019")), a4.getInt(SkillEntry.ALLATORIxDEMO("xPfEpCYTcTy"))));
                }
                a4.close();
                return;
            }
        }
    }

    public final /* synthetic */ boolean RestoreLostItem(MapleCharacter a2, int a3) {
        MapleQuestAction a4;
        if (a4.g == MapleQuestActionType.item) {
            for (QuestItem questItem : a4.a) {
                if (questItem.itemid != a3) continue;
                QuestItem questItem2 = questItem;
                if (!a2.haveItem(questItem2.itemid, questItem2.count, true, false)) {
                    QuestItem questItem3 = questItem;
                    MapleInventoryManipulator.addById(a2.getClient(), questItem3.itemid, (short)questItem3.count, "Obtained from quest (Restored) " + a4.B.getId() + " on " + FileoutputUtil.CurrentReadable_Date());
                }
                return true;
            }
        }
        return false;
    }

    public static class QuestItem {
        public /* synthetic */ int prop;
        public /* synthetic */ int period;
        public /* synthetic */ int itemid;
        public /* synthetic */ int job;
        public /* synthetic */ int jobEx;
        public /* synthetic */ int count;
        public /* synthetic */ int gender;

        public /* synthetic */ QuestItem(int a2, int a3, int a4, int a5, int a6, int a7, int a8) {
            QuestItem a9;
            if (RandomRewards.getInstance().getTenPercent().contains(a2)) {
                a3 += Randomizer.nextInt(3);
            }
            QuestItem questItem = a9;
            QuestItem questItem2 = a9;
            QuestItem questItem3 = a9;
            questItem3.itemid = a2;
            questItem3.count = a3;
            questItem2.period = a4;
            questItem2.gender = a5;
            questItem.job = a6;
            questItem.jobEx = a7;
            a9.prop = a8;
        }
    }
}

