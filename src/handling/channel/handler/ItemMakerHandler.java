/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleQuestStatus;
import client.MapleTrait;
import client.SkillEntry;
import client.SkillFactory;
import client.anticheat.CheatingOffenseEntry;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.ItemFlag;
import client.inventory.MapleImp;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import client.inventory.ModifyInventory;
import client.messages.ConsoleCommandExecute;
import constants.GameConstants;
import constants.ItemConstants;
import constants.MapConstants;
import handling.world.CheaterData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.Framework.MapleExtendedSlots;
import server.ItemMakerFactory;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.maps.MapleExtractor;
import server.maps.MapleReactor;
import server.quest.MapleQuest;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.Triple;
import tools.data.LittleEndianAccessor;

public class ItemMakerHandler {
    private static final /* synthetic */ Map<String, Integer> ALLATORIxDEMO;

    private static /* synthetic */ int ALLATORIxDEMO(int a2) {
        short s2 = MapleItemInformationProvider.getInstance().getItemMakeLevel(a2);
        if (s2 >= 31 && s2 <= 50) {
            int n2 = 4260000;
            return 4260000;
        }
        if (s2 >= 51 && s2 <= 60) {
            int n3 = 4260001;
            return 4260001;
        }
        if (s2 >= 61 && s2 <= 70) {
            int n4 = 4260002;
            return 4260002;
        }
        if (s2 >= 71 && s2 <= 80) {
            int n5 = 4260003;
            return 4260003;
        }
        if (s2 >= 81 && s2 <= 90) {
            int n6 = 4260004;
            return 4260004;
        }
        if (s2 >= 91 && s2 <= 100) {
            int n7 = 4260005;
            return 4260005;
        }
        if (s2 >= 101 && s2 <= 110) {
            int n8 = 4260006;
            return 4260006;
        }
        if (s2 >= 111 && s2 <= 120) {
            int n9 = 4260007;
            return 4260007;
        }
        if (s2 >= 121) {
            int n10 = 4260008;
            return 4260008;
        }
        throw new RuntimeException(ConsoleCommandExecute.ALLATORIxDEMO("N#q,k$cmN9b '\u0000f&b?'$c"));
    }

    public /* synthetic */ ItemMakerHandler() {
        ItemMakerHandler a2;
    }

    private static /* synthetic */ int ALLATORIxDEMO(MapleClient a2, List<Pair<Integer, Integer>> a3) {
        int n2 = 0;
        for (Pair<Integer, Integer> pair : a3) {
            if (a2.getPlayer().haveItem(pair.getLeft(), Math.abs(pair.getRight()), false, true)) continue;
            return 0;
        }
        Iterator<Pair<Integer, Integer>> iterator = a3.iterator();
        Iterator<Pair<Integer, Integer>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Pair<Integer, Integer> pair;
            pair = iterator.next();
            n2 = pair.getLeft();
            MapleInventoryManipulator.removeById(a2, GameConstants.getInventoryType(n2), n2, pair.getRight(), false, false);
            iterator2 = iterator;
        }
        return n2;
    }

    public static final /* synthetic */ void MakeExtractor(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4 == null || !a4.isAlive() || a4.getMap() == null || a4.hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.SETUP).findById(n2);
        if (iItem == null || iItem.getQuantity() < 1 || n2 / 10000 != 304 || n3 <= 0 || a4.getExtractor() != null || !a4.getMap().isTown()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = a4;
        mapleCharacter.setExtractor(new MapleExtractor(mapleCharacter, n2, n3, a4.getFH()));
        a4.getMap().spawnExtractor(a4.getExtractor());
    }

    private static /* synthetic */ int ALLATORIxDEMO(List<Pair<Integer, Integer>> a2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Pair<Integer, Integer> pair : a2) {
            int n2;
            int n3 = pair.getLeft();
            int n4 = n2 = 0;
            while (n4 < pair.getRight()) {
                arrayList.add(n3);
                n4 = ++n2;
            }
        }
        ArrayList<Integer> arrayList2 = arrayList;
        return (Integer)arrayList2.get(Randomizer.nextInt(arrayList2.size()));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void CraftComplete(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block71: {
            block75: {
                block74: {
                    block69: {
                        block73: {
                            block72: {
                                block70: {
                                    var3_3 = a.readInt();
                                    var4_4 = SkillFactory.getCraft(var3_3);
                                    var5_5 = MapleItemInformationProvider.getInstance();
                                    if (a.getMapId() != 910001000) {
                                        if (var3_3 != 92049000) return;
                                        if (a.getMap().getExtractorSize() <= 0) return;
                                    }
                                    if (var4_4 == null) return;
                                    if (a.getFatigue() >= 200) {
                                        return;
                                    }
                                    var6_6 = a.getPlayer().getProfessionLevel(var3_3 / 10000 * 10000);
                                    if (var6_6 <= 0 && var3_3 != 92049000) {
                                        return;
                                    }
                                    var7_7 = 0;
                                    var8_8 = 0;
                                    var9_9 = 0;
                                    var10_10 = 1;
                                    var11_11 = CraftRanking.GOOD;
                                    if (var3_3 != 92049000) break block70;
                                    v0 = a;
                                    var12_12 = v0.readInt();
                                    var13_14 = v0.readInt();
                                    var14_17 = v0.readLong();
                                    var16_20 = var5_5.getReqLevel(var13_14);
                                    var17_22 = a.getInventory(MapleInventoryType.EQUIP).findByInventoryIdAndItemId(var14_17, var13_14);
                                    if (var17_22 == null) return;
                                    if (a.getInventory(MapleInventoryType.ETC).isFull()) {
                                        return;
                                    }
                                    if (var12_12 <= 0) {
                                        if (var6_6 == 0) return;
                                        if (var6_6 < (var16_20 > 130 ? 6 : (var16_20 - 30) / 20)) {
                                            return;
                                        }
                                    }
                                    if (var12_12 > 0) {
                                        var18_25 = a.getMap().getCharacterById(var12_12);
                                        if (var18_25 == null || var18_25.getExtractor() == null) {
                                            a.dropMessage(1, CheatingOffenseEntry.ALLATORIxDEMO("\u754c\u5e05\u0010\u523b\u89df\u6a62\u4e07\u4e87\u4e1a\u6717\u5714\u6b59\u570c\u572b\u4e36\u001c"));
                                            return;
                                        }
                                        var19_29 = var18_25.getExtractor();
                                        if (var19_29.owner != a.getId()) {
                                            if (a.getMeso() < var19_29.fee) {
                                                a.dropMessage(1, "\u6953\u5e63\u4e0d\u8db3,\u60a8\u81f3\u5c11\u9700\u8981\u6953\u5e63 " + var19_29.fee + " \u5143!");
                                                return;
                                            }
                                            var20_31 = var5_5.getItemEffect(var19_29.itemId);
                                            if (var20_31 != null && var20_31.getUseLevel() < var16_20) {
                                                return;
                                            }
                                            v1 = a;
                                            v1.gainMeso(-var19_29.fee, true);
                                            var21_33 = v1.getMap().getCharacterById(var19_29.owner);
                                            if (var21_33 != null && var21_33.getMeso() < 0x7FFFFFFF - var19_29.fee) {
                                                v2 = var21_33;
                                                v2.gainMeso(var19_29.fee, false);
                                                v2.getClient().sendPacket(MaplePacketCreator.showFeeMesoGain(var19_29.fee, a.getName()));
                                            }
                                        }
                                    }
                                    var7_7 = 4021016;
                                    var10_10 = (short)Randomizer.rand(3, GameConstants.isWeapon(var13_14) != false || GameConstants.isOverall(var13_14) != false ? 11 : 7);
                                    if (var16_20 <= 60) {
                                        var7_7 = 4021013;
                                        v3 = var10_10;
                                    } else if (var16_20 <= 90) {
                                        var7_7 = 4021014;
                                        v3 = var10_10;
                                    } else {
                                        if (var16_20 <= 120) {
                                            var7_7 = 4021015;
                                        }
                                        v3 = var10_10;
                                    }
                                    if (v3 <= 5) {
                                        var11_11 = CraftRanking.SOSO;
                                    }
                                    if (Randomizer.nextInt(5) == 0 && var7_7 != 4021016) {
                                        var10_10 = 1;
                                        ++var7_7;
                                        var11_11 = CraftRanking.COOL;
                                    }
                                    var9_9 = 3;
                                    v4 = var8_8;
                                    MapleInventoryManipulator.addById(a, var7_7, var10_10, ConsoleCommandExecute.ALLATORIxDEMO("\u524b\u89e4\u733f\u5f90"));
                                    MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.EQUIP, var17_22.getPosition(), (short)1, false);
                                    break block71;
                                }
                                if (var3_3 != 92049001) break block72;
                                v5 = a;
                                var12_12 = v5.readInt();
                                var13_15 = v5.readLong();
                                var15_36 = v5.readLong();
                                var17_23 = var5_5.getReqLevel(var12_12);
                                var18_26 = (Equip)a.getInventory(MapleInventoryType.EQUIP).getItemByInventoryItemId(var13_15);
                                var19_29 = (Equip)a.getInventory(MapleInventoryType.EQUIP).getItemByInventoryItemId(var15_36);
                                v6 = var20_32 = 0;
                                break block73;
                            }
                            var12_12 = 100 - (var4_4.reqSkillLevel - var6_6) * 20;
                            if (var12_12 < 0) {
                                var12_12 = 0;
                            }
                            if (var12_12 == 0) {
                                a.dropMessage(1, "\u60a8\u7684\u88fd\u4f5c\u6280\u80fd\u7b49\u7d1a\u70ba" + var6_6 + ",\u6210\u529f\u6a5f\u7387\u70ba" + var12_12 + " %,\u70ba\u4e86\u907f\u514d\u60a8\u6d6a\u8cbb\u6750\u6599,\u6211\u5011\u5df2\u8cbc\u5fc3\u7684\u4e2d\u6b62\u60a8\u7576\u524d\u7684\u88fd\u4f5c\u3002");
                                return;
                            }
                            if (var4_4.needOpenItem && a.getSkillLevel(var3_3) <= 0) {
                                return;
                            }
                            for (Map.Entry<Integer, Integer> var14_18 : var4_4.reqItems.entrySet()) {
                                if (a.haveItem(var14_18.getKey(), var14_18.getValue())) continue;
                                return;
                            }
                            var13_16 = var4_4.targetItems.iterator();
                            while (var13_16.hasNext()) {
                                var14_18 = (Triple)var13_16.next();
                                if (MapleInventoryManipulator.checkSpace(a, (Integer)var14_18.left, (Integer)var14_18.mid, "")) continue;
                                return;
                            }
                            v7 = var13_16 = var4_4.reqItems.entrySet().iterator();
                            while (v7.hasNext()) {
                                var14_18 = (Map.Entry)var13_16.next();
                                MapleInventoryManipulator.removeById(a, GameConstants.getInventoryType((Integer)var14_18.getKey()), (Integer)var14_18.getKey(), (Integer)var14_18.getValue(), false, false);
                                v7 = var13_16;
                            }
                            a.dropMessage(5, "\u60a8\u7684\u88fd\u4f5c\u6280\u80fd\u7b49\u7d1a: " + var6_6 + " \u7b49  \u6210\u529f\u6a5f\u7387: " + var12_12 + " %");
                            if (Randomizer.nextInt(100) < var12_12 || var3_3 / 10000 <= 9201) break block74;
                            var10_10 = 0;
                            var11_11 = CraftRanking.FAIL;
                            break block75;
                        }
                        while (v6 < a.getInventory(MapleInventoryType.EQUIP).getSlotLimit()) {
                            var21_34 = a.getInventory(MapleInventoryType.EQUIP).getItem((short)var20_32);
                            if (var21_34 == null || var21_34.getItemId() != var12_12 || var21_34 == var18_26 || var21_34 == var19_29) ** GOTO lbl130
                            if (var18_26 == null) {
                                var18_26 = (Equip)var21_34;
                                v8 = var20_32;
                            } else {
                                if (var19_29 == null) {
                                    var19_29 = (Equip)var21_34;
                                    v9 = var18_26;
                                    break block69;
                                }
lbl130:
                                // 3 sources

                                v8 = var20_32;
                            }
                            v6 = v8 + 1;
                        }
                        v9 = var18_26;
                    }
                    if (v9 == null) return;
                    if (var19_29 == null) {
                        return;
                    }
                    if (var12_12 != var18_26.getItemId() || var12_12 != var19_29.getItemId() || var18_26.getItemId() != var19_29.getItemId()) {
                        a.dropMessage(CheatingOffenseEntry.ALLATORIxDEMO("\u5435\u622c\u6734\u8a98\u001d\u8af7\u9027\u77d9zq\u001c"));
                        FileoutputUtil.logToFile(ConsoleCommandExecute.ALLATORIxDEMO("!h*tbE\u0018@bD?f+s\u000eh w!b9bcs5s"), a.getInfo() + " Itemid:" + var12_12 + " item1:" + var18_26.getItemId() + " item2:" + var19_29.getItemId());
                        return;
                    }
                    if (var6_6 < (var17_23 > 130 ? 6 : (var17_23 - 30) / 20)) {
                        return;
                    }
                    var20_32 = 5;
                    var21_35 = var6_6 * 2;
                    if (var18_26.getState() > 0 && var19_29.getState() > 0) {
                        var21_35 = 100;
                        v10 = var18_26;
                    } else {
                        if (var18_26.getState() > 0 || var19_29.getState() > 0) {
                            var21_35 *= 2;
                        }
                        v10 = var18_26;
                    }
                    if (v10.getState() == var19_29.getState() && var18_26.getState() > 5) {
                        var20_32 = var18_26.getState();
                    }
                    if (var18_26.getLevel() > 0) {
                        v11 = (Equip)var5_5.getEquipById(var12_12);
                        v12 = var19_29;
                    } else {
                        v11 = var18_26;
                        v12 = var19_29;
                    }
                    var22_38 = var5_5.fuse(v11, (Equip)(v12.getLevel() > 0 ? (Equip)var5_5.getEquipById(var12_12) : var19_29));
                    var23_39 = var5_5.getTotalStat(var22_38);
                    if (var23_39 > var5_5.getTotalStat(var18_26) || var23_39 > var5_5.getTotalStat((Equip)var19_29)) {
                        var11_11 = CraftRanking.COOL;
                    } else if (var23_39 < var5_5.getTotalStat(var18_26) || var23_39 < var5_5.getTotalStat((Equip)var19_29)) {
                        var11_11 = CraftRanking.SOSO;
                    }
                    if (Randomizer.nextInt(100) < (var22_38.getUpgradeSlots() > 0 || var21_35 >= 100 ? var21_35 : var21_35 / 2)) {
                        if (var6_6 > 5) {
                            v13 = true;
                            v14 = var20_32;
                        } else {
                            v13 = false;
                            v14 = var20_32;
                        }
                        var22_38.resetPotential_Fuse(v13, v14);
                    }
                    v15 = var22_38;
                    v15.setFlag(ItemFlag.CRAFTED.getValue());
                    v15.setOwner(a.getName());
                    var7_7 = var22_38.getItemId();
                    var8_8 = (60 - (var6_6 - 1) * 2) * 2;
                    var9_9 = 3;
                    try {
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.EQUIP, var18_26.getPosition(), (short)1, false);
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.EQUIP, var19_29.getPosition(), (short)1, false);
                        MapleInventoryManipulator.addbyItem(a, var22_38);
                    }
                    catch (Exception var19_30) {
                        var19_30.printStackTrace();
                    }
                    break block75;
                }
                var13_16 = new HashMap<K, V>();
                block12: do {
                    var14_19 = false;
                    for (Triple<Integer, Integer, Integer> var16_21 : var4_4.targetItems) {
                        if (Randomizer.nextInt(100) >= (Integer)var16_21.right) continue;
                        if (Randomizer.nextInt(100) < 80) {
                            var7_7 = (Integer)var16_21.left;
                            v16 = var16_21;
                        } else {
                            var7_7 = ItemMakerHandler.getMakeedMagicPowder((Integer)var16_21.left);
                            if (var7_7 == 0) {
                                var7_7 = (Integer)var16_21.left;
                            }
                            v16 = var16_21;
                        }
                        var10_10 = ((Integer)v16.mid).shortValue();
                        var17_24 = null;
                        if (GameConstants.getInventoryType(var7_7) == MapleInventoryType.EQUIP) {
                            var18_27 = (Equip)var5_5.getEquipById(var7_7);
                            if (Randomizer.nextInt(100) < var6_6 * 2) {
                                var18_27 = var5_5.randomizeStats(var18_27);
                                var11_11 = CraftRanking.COOL;
                            }
                            if (!ItemConstants.\u985e\u578b.\u6a5f\u68b0((int)var18_27.getItemId()) && !ItemConstants.\u985e\u578b.\u9f8d\u88dd\u5099((int)var18_27.getItemId()) && Randomizer.nextInt(100) < var6_6 * (var18_27.getUpgradeSlots() > 0 ? 2 : 1)) {
                                var18_27.resetPotential();
                                var11_11 = CraftRanking.COOL;
                            }
                            var17_24 = var18_27;
                            v17 = var4_4;
                            var17_24.setFlag(ItemFlag.CRAFTED.getValue());
                        } else {
                            var17_24 = new Item(var7_7, 0, var10_10, ItemFlag.CRAFTED_USE.getValue());
                            v17 = var4_4;
                        }
                        if (v17.period > 0) {
                            var17_24.setExpiration(System.currentTimeMillis() + (long)(var4_4.period * 60000));
                        }
                        var17_24.setOwner(a.getName());
                        var17_24.setGMLog("Crafted from " + var3_3 + " on " + FileoutputUtil.CurrentReadable_Date());
                        MapleInventoryManipulator.addFromDrop(a, var17_24, true);
                        if (!var4_4.needOpenItem) ** GOTO lbl243
                        var18_28 = a.getMasterLevel(var3_3);
                        if (var18_28 == 1) {
                            v18 = var4_4;
                            v19 = v18;
                            v20 = var4_4;
                            var13_16.put(v18, new SkillEntry(0, 0, SkillFactory.getDefaultSExpiry(var4_4)));
                        } else {
                            if (var18_28 > 1) {
                                var13_16.put(var4_4, new SkillEntry(0x7FFFFFFF, a.getMasterLevel(var3_3) - 1, SkillFactory.getDefaultSExpiry(var4_4)));
                            }
lbl243:
                            // 4 sources

                            v19 = var4_4;
                        }
                        var9_9 = v19.incFatigability;
                        var8_8 = var4_4.incSkillProficiency == 0 ? (var9_9 * 20 - (var4_4.reqSkillLevel - var6_6) * 2) * 2 : var4_4.incSkillProficiency;
                        a.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).addExp(var11_11.craft, a);
                        v21 = var14_19 = true;
                        continue block12;
                    }
                    v21 = var14_19;
                } while (!v21);
            }
            v4 = var8_8;
        }
        if (v4 > 0 && var6_6 < 10) {
            var8_8 *= a.getClient().getChannelServer().getTraitRate();
            if (Randomizer.nextInt(100) < a.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).getLevel() / 5) {
                var8_8 *= 2;
            }
            var12_13 = CheatingOffenseEntry.ALLATORIxDEMO("\u7174\u91ed\u886e");
            switch (var3_3 / 10000) {
                case 9200: {
                    var12_13 = ConsoleCommandExecute.ALLATORIxDEMO("\u63ec\u85e2");
                    v22 = a;
                    break;
                }
                case 9201: {
                    var12_13 = CheatingOffenseEntry.ALLATORIxDEMO("\u639d\u791b");
                    v22 = a;
                    break;
                }
                case 9202: {
                    var12_13 = ConsoleCommandExecute.ALLATORIxDEMO("\u8890\u509e\u88b0\u4f5b");
                    v22 = a;
                    break;
                }
                case 9203: {
                    var12_13 = CheatingOffenseEntry.ALLATORIxDEMO("\u98c2\u54fc\u88c1\u4f61");
                }
                default: {
                    v22 = a;
                }
            }
            v22.dropMessage(-5, var12_13 + "\u7684\u719f\u7df4\u5ea6\u63d0\u9ad8\u4e86\u3002 (+" + var8_8 + ")");
            if (a.addProfessionExp(var3_3 / 10000 * 10000, var8_8)) {
                a.dropMessage(-5, var12_13 + "\u7684\u7b49\u7d1a\u63d0\u5347\u4e86\u3002");
            }
        } else {
            var8_8 = 0;
        }
        MapleQuest.getInstance(2550).forceStart(a.getPlayer(), 9031000, "1");
        v23 = a;
        v23.setFatigue((byte)(v23.getFatigue() + var9_9));
        v23.getMap().broadcastMessage(MaplePacketCreator.craftFinished(a.getId(), var3_3, var11_11.i, var7_7, var10_10, var8_8));
    }

    public static final /* synthetic */ void UsePot(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = a2.readInt();
        IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.USE).getItem(a2.readShort());
        if (iItem == null || iItem.getQuantity() <= 0 || iItem.getItemId() != n2 || n2 / 10000 != 244 || MapleItemInformationProvider.getInstance().getPot(n2) == null) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        a3.getSession().write((Object)MaplePacketCreator.enableActions());
        a3.getPlayer().marriage();
        int n3 = 0;
        int n4 = n3;
        while (n4 < a3.getPlayer().getImps().length) {
            if (a3.getPlayer().getImps()[n3] == null) {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().getImps()[n3] = new MapleImp(n2);
                mapleClient.sendPacket(MaplePacketCreator.updateImp(mapleClient.getPlayer().getImps()[n3], MapleImp.ImpFlag.SUMMONED.getValue(), n3, false));
                MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.USE, iItem.getPosition(), (short)1, false, false);
                return;
            }
            n4 = ++n3;
        }
    }

    public static final /* synthetic */ void ProfessionInfo(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        int n3;
        String string;
        block3: {
            try {
                LittleEndianAccessor littleEndianAccessor = a2;
                string = littleEndianAccessor.readMapleAsciiString();
                n3 = littleEndianAccessor.readInt();
                n2 = littleEndianAccessor.readInt();
                if (!string.equalsIgnoreCase(CheatingOffenseEntry.ALLATORIxDEMO("USSSOpXJXPTRZ"))) break block3;
                a3.sendPacket(MaplePacketCreator.professionInfo(string, n3, n2, 500));
                return;
            }
            catch (NumberFormatException numberFormatException) {
                return;
            }
        }
        a3.sendPacket(MaplePacketCreator.professionInfo(string, n3, n2, Math.max(0, 100 - (n3 + 1 - a3.getPlayer().getProfessionLevel(Integer.parseInt(string))) * 20)));
    }

    public static final /* synthetic */ void FeedPot(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        int n2;
        int n3 = a2.readInt();
        IItem iItem = a3.getPlayer().getInventory(GameConstants.getInventoryType(n3)).getItem((short)a2.readInt());
        if (iItem == null || iItem.getQuantity() <= 0 || iItem.getItemId() != n3) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        int n4 = n2 = GameConstants.getInventoryType(n3) == MapleInventoryType.ETC ? MapleItemInformationProvider.getInstance().getItemMakeLevel(n3) : MapleItemInformationProvider.getInstance().getReqLevel(n3);
        if (n2 <= 0 || n2 < Math.min(120, a3.getPlayer().getLevel()) - 50 || GameConstants.getInventoryType(n3) != MapleInventoryType.ETC && GameConstants.getInventoryType(n3) != MapleInventoryType.EQUIP) {
            MapleClient mapleClient2 = a3;
            mapleClient2.getPlayer().dropMessage(1, ConsoleCommandExecute.ALLATORIxDEMO("\u901e\u5046\u9802\u76a3\u5fc2\u9845\u572f\u59fe\u7683x7\u5046\u7b4e\u7d57\u4e4c\u512a\u3005"));
            mapleClient2.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        n2 = a2.readInt() - 1;
        if (n2 < 0 || n2 >= a3.getPlayer().getImps().length || a3.getPlayer().getImps()[n2] == null || a3.getPlayer().getImps()[n2].getLevel() >= (Integer)MapleItemInformationProvider.getInstance().getPot((int)a3.getPlayer().getImps()[n2].getItemId()).right - 1 || a3.getPlayer().getImps()[n2].getState() != 1) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        int n5 = MapleImp.ImpFlag.FULLNESS.getValue();
        n5 |= MapleImp.ImpFlag.FULLNESS_2.getValue();
        n5 |= MapleImp.ImpFlag.UPDATE_TIME.getValue();
        n5 |= MapleImp.ImpFlag.AWAKE_TIME.getValue();
        a3.getPlayer().getImps()[n2].setFullness(a3.getPlayer().getImps()[n2].getFullness() + 100 * (GameConstants.getInventoryType(n3) == MapleInventoryType.EQUIP ? 2 : 1));
        if (Randomizer.nextBoolean()) {
            n5 |= MapleImp.ImpFlag.CLOSENESS.getValue();
            a3.getPlayer().getImps()[n2].setCloseness(a3.getPlayer().getImps()[n2].getCloseness() + 1 + Randomizer.nextInt(5 * (GameConstants.getInventoryType(n3) == MapleInventoryType.EQUIP ? 2 : 1)));
            mapleClient = a3;
        } else {
            if (Randomizer.nextInt(5) == 0) {
                a3.getPlayer().getImps()[n2].setState(4);
                n5 |= MapleImp.ImpFlag.STATE.getValue();
            }
            mapleClient = a3;
        }
        if (mapleClient.getPlayer().getImps()[n2].getFullness() >= 1000) {
            MapleClient mapleClient3 = a3;
            a3.getPlayer().getImps()[n2].setState(1);
            mapleClient3.getPlayer().getImps()[n2].setFullness(0);
            mapleClient3.getPlayer().getImps()[n2].setLevel(a3.getPlayer().getImps()[n2].getLevel() + 1);
            n5 |= MapleImp.ImpFlag.SUMMONED.getValue();
            if (mapleClient3.getPlayer().getImps()[n2].getLevel() >= (Integer)MapleItemInformationProvider.getInstance().getPot((int)a3.getPlayer().getImps()[n2].getItemId()).right - 1) {
                a3.getPlayer().getImps()[n2].setState(5);
            }
        }
        MapleInventoryManipulator.removeFromSlot(a3, GameConstants.getInventoryType(n3), iItem.getPosition(), (short)1, false, false);
        a3.getSession().write((Object)MaplePacketCreator.updateImp(a3.getPlayer().getImps()[n2], n5, n2, false));
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new HashMap<String, Integer>();
        ALLATORIxDEMO.put(ConsoleCommandExecute.ALLATORIxDEMO("B+a(d9(\u000ff>n.B+acn `bw?h+b>t$h#tbo(u/f!n>j"), 92000000);
        ALLATORIxDEMO.put(CheatingOffenseEntry.ALLATORIxDEMO("y[ZX_I\u0013\u007f]NU^y[Z\u0013UP[\u0012LOS[YNOTSSO\u0012QTRTRZ"), 92010000);
        ALLATORIxDEMO.put(ConsoleCommandExecute.ALLATORIxDEMO("\ba+b.sbE,t$d\ba+)$j*(=u\"a(t>n\"i>(%b?e,k$t B5s?f.s"), 92000000);
        ALLATORIxDEMO.put(CheatingOffenseEntry.ALLATORIxDEMO("xZ[Y^H\u0012~\\OT_xZ[\u0012TQZ\u0013MNRZXONURRN\u0013PUSUS[xDIN\\_I"), 92010000);
        ALLATORIxDEMO.put(ConsoleCommandExecute.ALLATORIxDEMO("B+a(d9(\u000ff>n.B+acn `bw?h+b>t$h#tbb<r$w\u0012w?h)r.s"), 92020000);
        ALLATORIxDEMO.put(CheatingOffenseEntry.ALLATORIxDEMO("xZ[Y^H\u0012~\\OT_xZ[\u0012TQZ\u0013MNRZXONURRN\u0013\\_^cMNRXH_I"), 92030000);
        ALLATORIxDEMO.put(ConsoleCommandExecute.ALLATORIxDEMO("B+a(d9(\u000ff>n.B+acn `bw?h+b>t$h#tbf!d%b ~"), 92040000);
    }

    public static final /* synthetic */ void StartHarvest(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        MapleReactor mapleReactor = a3.getPlayer().getMap().getReactorByOid(a2.readInt());
        if (mapleReactor == null || !mapleReactor.isAlive() || mapleReactor.getReactorId() > 200011 || a4.getStat().harvestingTool <= 0 || mapleReactor.getTruePosition().distanceSq(a4.getTruePosition()) > 10000.0 || a3.getPlayer().getFatigue() >= 200) {
            return;
        }
        IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((short)a3.getPlayer().getStat().harvestingTool);
        if (iItem == null || ((Equip)iItem).getDurability() == 0) {
            a3.getPlayer().getStat().handleProfessionTool(a3.getPlayer());
            return;
        }
        MapleQuestStatus mapleQuestStatus = a3.getPlayer().getQuestNAdd(MapleQuest.getInstance(122501));
        if (mapleQuestStatus.getCustomData() == null) {
            mapleQuestStatus.setCustomData(ConsoleCommandExecute.ALLATORIxDEMO("7"));
        }
        a3.getPlayer().setHarvesting(true);
        if (Long.parseLong(mapleQuestStatus.getCustomData()) + 5000L > System.currentTimeMillis()) {
            a3.sendPacket(MaplePacketCreator.harvestMessage(mapleReactor.getObjectId(), 9));
            return;
        }
        mapleQuestStatus.setCustomData(String.valueOf(System.currentTimeMillis()));
        MapleClient mapleClient = a3;
        mapleClient.sendPacket(MaplePacketCreator.harvestMessage(mapleReactor.getObjectId(), 11));
        MapleCharacter mapleCharacter = a4;
        mapleClient.getPlayer().getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showHarvesting(mapleCharacter.getId(), iItem.getItemId()), false);
    }

    public static final /* synthetic */ void UseBag(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        boolean bl;
        if (a4 == null || !a4.isAlive() || a4.getMap() == null || a4.hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = (byte)littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.ETC).getItem(by);
        if (iItem == null || iItem.getQuantity() < 1 || iItem.getItemId() != n2 || n2 / 10000 != 433) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        boolean bl2 = bl = a4.getExtendedSlotsByUniqueid(iItem.getUniqueId()) == null;
        if (bl) {
            int n3 = MapleInventoryIdentifier.getInstance();
            a4.getExtendedSlots().add(new MapleExtendedSlots(n2, n3));
            IItem iItem2 = iItem;
            a4.changedExtended();
            int n4 = iItem.getFlag();
            n4 |= ItemFlag.LOCK.getValue();
            iItem2.setFlag(n4 |= ItemFlag.UNTRADEABLE.getValue());
            iItem2.setUniqueId(n3);
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(3, iItem, 4), mapleClient.getPlayer(), true));
        }
        MapleClient mapleClient = a3;
        mapleClient.sendPacket(MaplePacketCreator.openBag(a4.getExtendedSlotsIndexByUniqueid(iItem.getUniqueId()), n2, bl));
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void RewardPot(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = a2.readInt() - 1;
        if (n2 < 0 || n2 >= a3.getPlayer().getImps().length || a3.getPlayer().getImps()[n2] == null || a3.getPlayer().getImps()[n2].getLevel() < (Integer)MapleItemInformationProvider.getInstance().getPot((int)a3.getPlayer().getImps()[n2].getItemId()).right - 1) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        int n3 = ItemConstants.getRewardPot(a3.getPlayer().getImps()[n2].getItemId(), a3.getPlayer().getImps()[n2].getCloseness());
        if (n3 <= 0 || !MapleInventoryManipulator.checkSpace(a3, n3, 1, "")) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, CheatingOffenseEntry.ALLATORIxDEMO("mPX]NY\u001dQ\\WX\u001cNSPY\u001dOM]^Y\u0013"));
            mapleClient.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        MapleInventoryManipulator.addById(a3, n3, (short)1, "Item Pot from " + a3.getPlayer().getImps()[n2].getItemId() + " on " + FileoutputUtil.CurrentReadable_Date());
        a3.getSession().write((Object)MaplePacketCreator.updateImp(a3.getPlayer().getImps()[n2], MapleImp.ImpFlag.REMOVED.getValue(), n2, false));
        a3.getPlayer().getImps()[n2] = null;
    }

    private static /* synthetic */ int[] ALLATORIxDEMO(int a2, int a3) {
        int n2;
        int[] arrn = new int[2];
        arrn[0] = -1;
        if (a3 >= 31 && a3 <= 50) {
            n2 = a2;
            arrn[0] = 4260000;
        } else if (a3 >= 51 && a3 <= 60) {
            n2 = a2;
            arrn[0] = 4260001;
        } else if (a3 >= 61 && a3 <= 70) {
            n2 = a2;
            arrn[0] = 4260002;
        } else if (a3 >= 71 && a3 <= 80) {
            n2 = a2;
            arrn[0] = 4260003;
        } else if (a3 >= 81 && a3 <= 90) {
            n2 = a2;
            arrn[0] = 4260004;
        } else if (a3 >= 91 && a3 <= 100) {
            n2 = a2;
            arrn[0] = 4260005;
        } else if (a3 >= 101 && a3 <= 110) {
            n2 = a2;
            arrn[0] = 4260006;
        } else if (a3 >= 111 && a3 <= 120) {
            n2 = a2;
            arrn[0] = 4260007;
        } else if (a3 >= 121 && a3 <= 200) {
            n2 = a2;
            arrn[0] = 4260008;
        } else {
            throw new RuntimeException("Invalid Item Maker type" + a3);
        }
        if (GameConstants.isWeapon(n2) || GameConstants.isOverall(a2)) {
            arrn[1] = Randomizer.rand(5, 11);
            return arrn;
        }
        arrn[1] = Randomizer.rand(3, 7);
        return arrn;
    }

    public static final /* synthetic */ void ClearPot(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = a2.readInt() - 1;
        if (n2 < 0 || n2 >= a3.getPlayer().getImps().length || a3.getPlayer().getImps()[n2] == null) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        a3.getSession().write((Object)MaplePacketCreator.updateImp(a3.getPlayer().getImps()[n2], MapleImp.ImpFlag.REMOVED.getValue(), n2, false));
        a3.getPlayer().getImps()[n2] = null;
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(MapleClient a2, int a3) {
        if (GameConstants.isKOC(a2.getPlayer().getJob())) {
            return a2.getPlayer().getSkillLevel(SkillFactory.getSkill(10001007)) >= a3;
        }
        if (GameConstants.isAran(a2.getPlayer().getJob())) {
            return a2.getPlayer().getSkillLevel(SkillFactory.getSkill(20001007)) >= a3;
        }
        return a2.getPlayer().getSkillLevel(SkillFactory.getSkill(1007)) >= a3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getMakeedMagicPowder(int a2) {
        switch (a2) {
            case 4011000: 
            case 4011003: 
            case 4023006: 
            case 4023007: {
                return 4007000;
            }
            case 4021002: 
            case 4021007: 
            case 4023013: 
            case 4023014: {
                return 4007001;
            }
            case 4011001: 
            case 4021005: 
            case 4023004: 
            case 4023005: {
                return 4007002;
            }
            case 4005002: 
            case 4011002: 
            case 4021003: 
            case 4023008: 
            case 4023009: 
            case 4023010: {
                return 4007003;
            }
            case 4011006: 
            case 4021006: 
            case 4023011: 
            case 4023012: {
                return 4007004;
            }
            case 4005001: 
            case 4005003: 
            case 4011008: 
            case 4023019: 
            case 4023020: 
            case 4023021: {
                return 4007005;
            }
            case 4005000: 
            case 4021000: 
            case 4023015: 
            case 4023016: {
                return 4007006;
            }
            case 4021008: 
            case 4023017: 
            case 4023018: {
                return 4007007;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void CraftEffect(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        block20: {
            MapleClient mapleClient;
            int n2;
            int n3;
            String string;
            String string2;
            block21: {
                if (a4.getMapId() != 910001000 && a4.getMap().getExtractorSize() <= 0) {
                    return;
                }
                String string3 = string2 = a2.readMapleAsciiString();
                string = string3.substring(32, string3.length());
                Integer n4 = ALLATORIxDEMO.get(string2);
                if (n4 == null || a3.getPlayer().getProfessionLevel(n4) <= 0 && (n4 != 92040000 || a4.getMap().getExtractorSize() <= 0)) break block20;
                n3 = a2.readInt();
                if (n3 > 6000 || n3 < 3000) {
                    n3 = 4000;
                }
                String string4 = string;
                int n5 = -1;
                switch (string4.hashCode()) {
                    case -1074038704: {
                        if (!string4.equals(CheatingOffenseEntry.ALLATORIxDEMO("QTRTRZ"))) break;
                        n2 = n5 = 0;
                        break block21;
                    }
                    case 2021065233: {
                        if (!string4.equals(ConsoleCommandExecute.ALLATORIxDEMO("j$i$i*B5s?f.s"))) break;
                        n2 = n5 = 1;
                        break block21;
                    }
                    case 1928246443: {
                        if (!string4.equals(CheatingOffenseEntry.ALLATORIxDEMO("UYO^\\PTOP"))) break;
                        n2 = n5 = 2;
                        break block21;
                    }
                    case -776783530: {
                        if (!string4.equals(ConsoleCommandExecute.ALLATORIxDEMO("%b?e,k$t B5s?f.s"))) break;
                        n2 = n5 = 3;
                        break block21;
                    }
                    case -919880447: {
                        if (!string4.equals(CheatingOffenseEntry.ALLATORIxDEMO("\\P^TXQD"))) break;
                        n2 = n5 = 4;
                        break block21;
                    }
                    case 365865952: {
                        if (!string4.equals(ConsoleCommandExecute.ALLATORIxDEMO("b<r$w\u0012w?h)r.s"))) break;
                        n2 = n5 = 5;
                        break block21;
                    }
                    case -1281172687: {
                        if (!string4.equals(CheatingOffenseEntry.ALLATORIxDEMO("\\_^cMNRXH_I"))) break;
                        n2 = n5 = 6;
                        break block21;
                    }
                    case -1893816272: {
                        if (!string4.equals(ConsoleCommandExecute.ALLATORIxDEMO(" n#n#`\u0012k(q(k8w"))) break;
                        n2 = n5 = 7;
                        break block21;
                    }
                    case 1567185291: {
                        if (!string4.equals(CheatingOffenseEntry.ALLATORIxDEMO("UYO^\\PTOPcQYKYQIM"))) break;
                        n2 = n5 = 8;
                        break block21;
                    }
                    case 421243873: {
                        if (!string4.equals(ConsoleCommandExecute.ALLATORIxDEMO("f!d%b ~\u0012k(q(k8w"))) break;
                        n2 = n5 = 9;
                        break block21;
                    }
                    case 1787644864: {
                        if (!string4.equals(CheatingOffenseEntry.ALLATORIxDEMO("XMHUMcMNRXH_IcQYKYQIM"))) break;
                        n2 = n5 = 10;
                        break block21;
                    }
                    case 1852414481: {
                        if (!string4.equals(ConsoleCommandExecute.ALLATORIxDEMO("f.d\u0012w?h)r.s\u0012k(q(k8w"))) break;
                        n5 = 11;
                    }
                }
                n2 = n5;
            }
            switch (n2) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: {
                    MapleCharacter mapleCharacter = a4;
                    String string5 = string2;
                    a4.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showCraftingEffect(mapleCharacter.getId(), string5, n3, string5.endsWith(CheatingOffenseEntry.ALLATORIxDEMO("xDIN\\_I")) ? 1 : 0), false);
                    mapleClient = a3;
                    break;
                }
                default: {
                    if (a4.isStaff()) {
                        a4.dropMessage("\u672a\u8655\u7406\u7684\u5c08\u696d\u6280\u8853\u7279\u6548\u540d\u7a31: " + string);
                    }
                    FileoutputUtil.logToFile(ConsoleCommandExecute.ALLATORIxDEMO("k\"`>(\b\u007f.b=sb\u672d\u8618\u7401\u5c45\u696a\u62cd\u8854\u7234\u654fcs5s"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " \u5e33\u865f: " + a3.getAccountName() + " \u7279\u6548\u540d\u7a31: " + string + " IP:" + a3.getSessionIPAddress() + " MAC:" + a3.getClientMac() + " \r\n");
                    System.out.println("\u672a\u8655\u7406\u7684\u5c08\u696d\u6280\u8853\u7279\u6548\u540d\u7a31: " + string);
                    mapleClient = a3;
                }
            }
            mapleClient.sendPacket(MaplePacketCreator.showOwnCraftingEffect(string2, n3, string2.endsWith(CheatingOffenseEntry.ALLATORIxDEMO("xDIN\\_I")) ? 1 : 0));
        }
    }

    public static final /* synthetic */ void UseRecipe(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4 == null || !a4.isAlive() || a4.getMap() == null || a4.hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = (byte)littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
        if (iItem == null || iItem.getQuantity() < 1 || iItem.getItemId() != n2 || n2 / 10000 != 251) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (MapleItemInformationProvider.getInstance().getItemEffect(iItem.getItemId()).applyTo(a4)) {
            MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
        }
    }

    public static final /* synthetic */ void CurePot(LittleEndianAccessor a2, MapleClient a3) {
        int n2 = a2.readInt();
        IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.ETC).getItem((short)a2.readInt());
        if (iItem == null || iItem.getQuantity() <= 0 || iItem.getItemId() != n2 || n2 / 10000 != 434) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        n2 = a2.readInt() - 1;
        if (n2 < 0 || n2 >= a3.getPlayer().getImps().length || a3.getPlayer().getImps()[n2] == null || a3.getPlayer().getImps()[n2].getState() != 4) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        MapleClient mapleClient = a3;
        mapleClient.getPlayer().getImps()[n2].setState(1);
        mapleClient.getSession().write((Object)MaplePacketCreator.updateImp(a3.getPlayer().getImps()[n2], MapleImp.ImpFlag.STATE.getValue(), n2, false));
        MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.ETC, iItem.getPosition(), (short)1, false, false);
    }

    private static /* synthetic */ void ALLATORIxDEMO(Map<String, Byte> a2, Equip a3) {
        short s2;
        short s3;
        boolean bl;
        short s4 = a2.get(CheatingOffenseEntry.ALLATORIxDEMO("US_m}y")).byteValue();
        if (s4 != 0) {
            Equip equip = a3;
            equip.setWatk((short)(equip.getWatk() + s4));
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("$i.J\fC")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setMatk((short)(equip.getMatk() + s4));
        }
        if ((s4 = (short)a2.get(CheatingOffenseEntry.ALLATORIxDEMO("US_|\u007f~")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setAcc((short)(equip.getAcc() + s4));
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("$i.B\u001bF")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setAvoid((short)(equip.getAvoid() + s4));
        }
        if ((s4 = (short)a2.get(CheatingOffenseEntry.ALLATORIxDEMO("US_nLXYY")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setSpeed((short)(equip.getSpeed() + s4));
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("n#d\u0007r w")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setJump((short)(equip.getJump() + s4));
        }
        if ((s4 = (short)a2.get(CheatingOffenseEntry.ALLATORIxDEMO("US_p]Etm")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setHp((short)(equip.getHp() + s4));
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("$i.J,\u007f\u0000W")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setMp((short)(equip.getMp() + s4));
        }
        if ((s4 = (short)a2.get(CheatingOffenseEntry.ALLATORIxDEMO("US_nho")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setStr((short)(equip.getStr() + s4));
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("$i.C\b_")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setDex((short)(equip.getDex() + s4));
        }
        if ((s4 = (short)a2.get(CheatingOffenseEntry.ALLATORIxDEMO("US_tri")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setInt((short)(equip.getInt() + s4));
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("$i.K\u0018L")).byteValue()) != 0) {
            Equip equip = a3;
            equip.setLuk((short)(equip.getLuk() + s4));
        }
        if ((s4 = (short)a2.get(CheatingOffenseEntry.ALLATORIxDEMO("N\\RYsMHTSS")).byteValue()) > 0) {
            bl = Randomizer.nextBoolean();
            Equip equip = a3;
            s3 = equip.getMatk();
            s2 = equip.getWatk();
            if (s2 > 0) {
                a3.setWatk((short)(bl ? s2 + s4 : s2 - s4));
            }
            if (s3 > 0) {
                a3.setMatk((short)(bl ? s3 + s4 : s3 - s4));
            }
        }
        if ((s4 = (short)a2.get(ConsoleCommandExecute.ALLATORIxDEMO("?f#c\u001es,s")).byteValue()) > 0) {
            bl = Randomizer.nextBoolean();
            Equip equip = a3;
            s3 = equip.getStr();
            s2 = equip.getDex();
            short s5 = equip.getLuk();
            short s6 = equip.getInt();
            if (s3 > 0) {
                short s7 = s3;
                a3.setStr((short)(bl ? s7 + s4 : s7 - s4));
            }
            if (s2 > 0) {
                short s8 = s2;
                a3.setDex((short)(bl ? s8 + s4 : s8 - s4));
            }
            if (s6 > 0) {
                short s9 = s6;
                a3.setInt((short)(bl ? s9 + s4 : s9 - s4));
            }
            if (s5 > 0) {
                short s10 = s5;
                a3.setLuk((short)(bl ? s10 + s4 : s10 - s4));
            }
        }
    }

    public static final /* synthetic */ void StopHarvest(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        MapleClient mapleClient = a3;
        MapleCharacter mapleCharacter = a4;
        mapleClient.getPlayer().getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showHarvesting(mapleCharacter.getId(), 0), false);
        mapleClient.getPlayer().setHarvesting(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void ItemMaker(LittleEndianAccessor a2, MapleClient a3) {
        switch (a2.readInt()) {
            case 1: {
                int n2 = a2.readInt();
                if (GameConstants.isGem(n2)) {
                    ItemMakerFactory.GemCreateEntry gemCreateEntry = ItemMakerFactory.getInstance().getGemInfo(n2);
                    if (gemCreateEntry == null) {
                        return;
                    }
                    if (!ItemMakerHandler.ALLATORIxDEMO(a3, gemCreateEntry.getReqSkillLevel())) {
                        return;
                    }
                    if (a3.getPlayer().getMeso() < gemCreateEntry.getCost()) {
                        return;
                    }
                    int n3 = ItemMakerHandler.ALLATORIxDEMO(gemCreateEntry.getRandomReward());
                    if (a3.getPlayer().getInventory(GameConstants.getInventoryType(n3)).isFull()) {
                        return;
                    }
                    int n4 = ItemMakerHandler.ALLATORIxDEMO(a3, gemCreateEntry.getReqRecipes());
                    if (n4 == 0) {
                        return;
                    }
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().gainMeso(-gemCreateEntry.getCost(), false);
                    int n5 = n3;
                    MapleInventoryManipulator.addById(mapleClient, n5, (byte)(n4 == n5 ? 9 : 1));
                    MapleClient mapleClient2 = a3;
                    mapleClient2.sendPacket(MaplePacketCreator.ItemMaker_Success());
                    mapleClient2.getPlayer().getMap().broadcastMessage(a3.getPlayer(), MaplePacketCreator.ItemMaker_Success_3rdParty(a3.getPlayer().getId()), false);
                    return;
                }
                if (GameConstants.isOtherGem(n2)) {
                    MapleClient mapleClient;
                    ItemMakerFactory.GemCreateEntry gemCreateEntry = ItemMakerFactory.getInstance().getGemInfo(n2);
                    if (gemCreateEntry == null) {
                        return;
                    }
                    if (!ItemMakerHandler.ALLATORIxDEMO(a3, gemCreateEntry.getReqSkillLevel())) {
                        return;
                    }
                    if (a3.getPlayer().getMeso() < gemCreateEntry.getCost()) {
                        return;
                    }
                    if (a3.getPlayer().getInventory(GameConstants.getInventoryType(n2)).isFull()) {
                        return;
                    }
                    if (ItemMakerHandler.ALLATORIxDEMO(a3, gemCreateEntry.getReqRecipes()) == 0) {
                        return;
                    }
                    a3.getPlayer().gainMeso(-gemCreateEntry.getCost(), false);
                    if (GameConstants.getInventoryType(n2) == MapleInventoryType.EQUIP) {
                        MapleClient mapleClient3 = a3;
                        mapleClient = mapleClient3;
                        MapleInventoryManipulator.addbyItem(mapleClient3, MapleItemInformationProvider.getInstance().getEquipById(n2));
                    } else {
                        MapleClient mapleClient4 = a3;
                        mapleClient = mapleClient4;
                        MapleInventoryManipulator.addById(mapleClient4, n2, (short)1);
                    }
                    mapleClient.sendPacket(MaplePacketCreator.ItemMaker_Success());
                    a3.getPlayer().getMap().broadcastMessage(a3.getPlayer(), MaplePacketCreator.ItemMaker_Success_3rdParty(a3.getPlayer().getId()), false);
                    return;
                }
                boolean bl = a2.readByte() > 0;
                int n6 = a2.readInt();
                ItemMakerFactory.ItemMakerCreateEntry itemMakerCreateEntry = ItemMakerFactory.getInstance().getCreateInfo(n2);
                if (itemMakerCreateEntry == null) {
                    return;
                }
                if (n6 > itemMakerCreateEntry.getTUC()) {
                    return;
                }
                if (!ItemMakerHandler.ALLATORIxDEMO(a3, (int)itemMakerCreateEntry.getReqSkillLevel())) {
                    return;
                }
                if (a3.getPlayer().getMeso() < itemMakerCreateEntry.getCost()) {
                    return;
                }
                if (a3.getPlayer().getInventory(GameConstants.getInventoryType(n2)).isFull()) {
                    return;
                }
                if (ItemMakerHandler.ALLATORIxDEMO(a3, itemMakerCreateEntry.getReqItems()) == 0) {
                    return;
                }
                a3.getPlayer().gainMeso(-itemMakerCreateEntry.getCost(), false);
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                Equip equip = (Equip)mapleItemInformationProvider.getEquipById(n2);
                if (bl || n6 > 0) {
                    int n7;
                    if (a3.getPlayer().haveItem(itemMakerCreateEntry.getStimulator(), true ? 1 : 0, false, true)) {
                        mapleItemInformationProvider.randomizeStats(equip);
                        MapleInventoryManipulator.removeById(a3, MapleInventoryType.ETC, itemMakerCreateEntry.getStimulator(), 1, false, false);
                    }
                    int n8 = n7 = 0;
                    while (n8 < n6) {
                        Map<String, Byte> map;
                        int n9 = a2.readInt();
                        if (a3.getPlayer().haveItem(n9, true ? 1 : 0, false, true) && (map = mapleItemInformationProvider.getItemMakeStats(n9)) != null) {
                            ItemMakerHandler.ALLATORIxDEMO(map, equip);
                            MapleInventoryManipulator.removeById(a3, MapleInventoryType.ETC, n9, 1, false, false);
                        }
                        n8 = ++n7;
                    }
                }
                MapleInventoryManipulator.addbyItem(a3, equip);
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MaplePacketCreator.ItemMaker_Success());
                mapleClient.getPlayer().getMap().broadcastMessage(a3.getPlayer(), MaplePacketCreator.ItemMaker_Success_3rdParty(a3.getPlayer().getId()), false);
                return;
            }
            case 3: {
                int n10 = a2.readInt();
                if (!a3.getPlayer().haveItem(n10, 100, false, true)) break;
                MapleInventoryManipulator.addById(a3, ItemMakerHandler.ALLATORIxDEMO(n10), (short)1);
                MapleInventoryManipulator.removeById(a3, MapleInventoryType.ETC, n10, 100, false, false);
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MaplePacketCreator.ItemMaker_Success());
                mapleClient.getPlayer().getMap().broadcastMessage(a3.getPlayer(), MaplePacketCreator.ItemMaker_Success_3rdParty(a3.getPlayer().getId()), false);
                return;
            }
            case 4: {
                int n11 = a2.readInt();
                a3.getPlayer().updateTick(a2.readInt());
                byte by = (byte)a2.readInt();
                IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(by);
                if (iItem == null || iItem.getItemId() != n11 || iItem.getQuantity() < 1) {
                    return;
                }
                MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                if (!mapleItemInformationProvider.isDropRestricted(n11) && !mapleItemInformationProvider.isAccountShared(n11)) {
                    int n12 = n11;
                    int[] arrn = ItemMakerHandler.ALLATORIxDEMO(n12, mapleItemInformationProvider.getReqLevel(n12));
                    MapleInventoryManipulator.addById(a3, arrn[0], (byte)arrn[1]);
                    MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.EQUIP, by, (short)1, false);
                }
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MaplePacketCreator.ItemMaker_Success());
                mapleClient.getPlayer().getMap().broadcastMessage(a3.getPlayer(), MaplePacketCreator.ItemMaker_Success_3rdParty(a3.getPlayer().getId()), false);
                return;
            }
        }
    }

    public static final /* synthetic */ void CraftMake(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4.getMapId() != 910001000 && a4.getMap().getExtractorSize() <= 0) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        if (n3 > 6000 || n3 < 3000) {
            n3 = 4000;
        }
        if (n2 == 2 || n2 >= 280 && n2 <= 500) {
            a4.getMap().broadcastMessage(MaplePacketCreator.craftMake(a4.getId(), n2, n3));
            return;
        }
        if (a4.isStaff()) {
            a4.dropMessage("\u672a\u8655\u7406\u7684\u5c08\u696d\u6280\u8853\u88fd\u4f5c\u7279\u6548: " + n2);
        }
        FileoutputUtil.logToFile(ConsoleCommandExecute.ALLATORIxDEMO("k\"`>(\b\u007f.b=sb\u672d\u8618\u7401\u5c45\u696a\u62cd\u8854\u88b0\u4f5b\u7234\u654fcs5s"), FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " \u5e33\u865f: " + a3.getAccountName() + " \u7279\u6548\u503c: " + n2 + " IP:" + a3.getSessionIPAddress() + " MAC:" + a3.getClientMac() + " \r\n");
        System.out.println("\u672a\u8655\u7406\u7684\u5c08\u696d\u6280\u8853\u88fd\u4f5c\u7279\u6548: " + n2);
    }

    public static final class CraftRanking
    extends Enum<CraftRanking> {
        public static final /* synthetic */ /* enum */ CraftRanking SOSO;
        public /* synthetic */ int i;
        public static final /* synthetic */ /* enum */ CraftRanking COOL;
        private static final /* synthetic */ CraftRanking[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ CraftRanking GOOD;
        public /* synthetic */ int craft;
        public static final /* synthetic */ /* enum */ CraftRanking FAIL;

        public static /* synthetic */ {
            SOSO = new CraftRanking(CheaterData.ALLATORIxDEMO("VZVZ"), 0, 19, 30);
            GOOD = new CraftRanking(MapConstants.ALLATORIxDEMO("<W4\\"), 1, 20, 40);
            COOL = new CraftRanking(CheaterData.ALLATORIxDEMO("FZJY"), 2, 21, 50);
            FAIL = new CraftRanking(MapConstants.ALLATORIxDEMO("=Y2T"), 3, 23, 0);
            CraftRanking[] arrcraftRanking = new CraftRanking[4];
            arrcraftRanking[0] = SOSO;
            arrcraftRanking[1] = GOOD;
            arrcraftRanking[2] = COOL;
            arrcraftRanking[3] = FAIL;
            ALLATORIxDEMO = arrcraftRanking;
        }

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ CraftRanking(int n22, int n22) {
            void a2;
            void a3;
            void var2_-1;
            void var1_-1;
            CraftRanking a4;
            CraftRanking craftRanking = a4;
            craftRanking.i = a3;
            craftRanking.craft = a2;
        }

        public static /* synthetic */ CraftRanking valueOf(String a2) {
            return Enum.valueOf(CraftRanking.class, a2);
        }

        public static /* synthetic */ CraftRanking[] values() {
            return (CraftRanking[])ALLATORIxDEMO.clone();
        }
    }
}

