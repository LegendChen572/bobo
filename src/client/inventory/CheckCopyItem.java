/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import handling.channel.handler.PlayerHandler;
import handling.world.World;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import server.MapleItemInformationProvider;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;

public class CheckCopyItem {
    public static /* synthetic */ Map<Integer, Map<Short, IItem>> USE_Check;
    public static /* synthetic */ Map<Integer, Map<Short, IItem>> EQUIPPED_Check;
    public static /* synthetic */ Map<Integer, Map<Short, IItem>> CASH_Check;
    public static /* synthetic */ Map<Integer, Map<Short, IItem>> ETC_Check;
    public static /* synthetic */ Map<Integer, Map<Short, IItem>> EQUIP_Check;
    public static /* synthetic */ Map<Integer, Map<Short, IItem>> SETUP_Check;

    public static /* synthetic */ void getInfo(MapleCharacter a2) {
        if (CheckCopyItem.getCheckItem(MapleInventoryType.EQUIPPED).get(a2.getId()) != null) {
            System.out.println("\u88dd\u5099\u4e2d:" + CheckCopyItem.getCheckItem(MapleInventoryType.EQUIPPED).get(a2.getId()).toString());
        }
        if (CheckCopyItem.getCheckItem(MapleInventoryType.EQUIP).get(a2.getId()) != null) {
            System.out.println("\u88dd\u5099:" + CheckCopyItem.getCheckItem(MapleInventoryType.EQUIP).get(a2.getId()).toString());
        }
        if (CheckCopyItem.getCheckItem(MapleInventoryType.USE).get(a2.getId()) != null) {
            System.out.println("\u6d88\u8017:" + CheckCopyItem.getCheckItem(MapleInventoryType.USE).get(a2.getId()).toString());
        }
        if (CheckCopyItem.getCheckItem(MapleInventoryType.SETUP).get(a2.getId()) != null) {
            System.out.println("\u88dd\u98fe:" + CheckCopyItem.getCheckItem(MapleInventoryType.SETUP).get(a2.getId()).toString());
        }
        if (CheckCopyItem.getCheckItem(MapleInventoryType.ETC).get(a2.getId()) != null) {
            System.out.println("\u5176\u4ed6:" + CheckCopyItem.getCheckItem(MapleInventoryType.ETC).get(a2.getId()).toString());
        }
        if (CheckCopyItem.getCheckItem(MapleInventoryType.CASH).get(a2.getId()) != null) {
            System.out.println("\u7279\u6b8a:" + CheckCopyItem.getCheckItem(MapleInventoryType.CASH).get(a2.getId()).toString());
        }
    }

    public static /* synthetic */ Map<Integer, Map<Short, IItem>> getCheckItem(MapleInventoryType a2) {
        Map<Integer, Map<Short, IItem>> map = null;
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 1: {
                while (false) {
                }
                map = EQUIPPED_Check;
                return map;
            }
            case 2: {
                map = EQUIP_Check;
                return map;
            }
            case 3: {
                map = USE_Check;
                return map;
            }
            case 4: {
                map = SETUP_Check;
                return map;
            }
            case 5: {
                map = ETC_Check;
                return map;
            }
            case 6: {
                map = CASH_Check;
            }
        }
        return map;
    }

    public static /* synthetic */ void UpdateItem(MapleCharacter a2, Map<Short, IItem> a3, MapleInventoryType a4) {
        LinkedHashMap<Short, IItem> linkedHashMap = new LinkedHashMap<Short, IItem>();
        linkedHashMap.putAll(a3);
        a3 = CheckCopyItem.getCheckItem(a4);
        if (a3 != null) {
            if (a3.containsKey(a2.getId())) {
                a3.remove(a2.getId());
                a3.put(a2.getId(), linkedHashMap);
                return;
            }
            a3.put(a2.getId(), linkedHashMap);
        }
    }

    public static /* synthetic */ {
        EQUIPPED_Check = new HashMap<Integer, Map<Short, IItem>>();
        EQUIP_Check = new HashMap<Integer, Map<Short, IItem>>();
        USE_Check = new HashMap<Integer, Map<Short, IItem>>();
        SETUP_Check = new HashMap<Integer, Map<Short, IItem>>();
        ETC_Check = new HashMap<Integer, Map<Short, IItem>>();
        CASH_Check = new HashMap<Integer, Map<Short, IItem>>();
    }

    public /* synthetic */ CheckCopyItem() {
        CheckCopyItem a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> checkContainItems(int a, Map<Long, Pair<IItem, MapleInventoryType>> a) {
        var2_3 = new HashMap<Long, Pair<IItem, MapleInventoryType>>();
        var3_4 = new LinkedHashMap<K, V>();
        var3_4.putAll(a);
        try {
            a = var3_4.entrySet().iterator();
            while (a.hasNext() != false) {
                var3_5 = a.next();
                var4_10 = (Pair)var3_5.getValue();
                var5_11 = (Long)var3_5.getKey();
                var3_6 = CheckCopyItem.getCheckItem((MapleInventoryType)var4_10.right);
                if (var3_6 == null) ** GOTO lbl20
                var3_7 = var3_6.get(a);
                if (var3_7 != null) {
                    var7_12 = false;
                    var3_8 = var3_7.values().iterator();
                } else {
                    var2_3.put(var5_11, var4_10);
                    continue;
lbl20:
                    // 1 sources

                    var2_3.put(var5_11, var4_10);
                    continue;
                }
                while (var3_8.hasNext()) {
                    var8_13 = var3_8.next();
                    if (var8_13.getPosition() == ((IItem)var4_10.left).getPosition() && var8_13.getItemId() == ((IItem)var4_10.left).getItemId() && var8_13.getQuantity() >= ((IItem)var4_10.left).getQuantity()) {
                        var7_12 = true;
                    }
                    if (var8_13.getExpiration() > -1L || ((IItem)var4_10.left).getExpiration() > -1L) {
                        var7_12 = true;
                    }
                    if (GameSetConstants.CHECK_COPYITEM_CLEAR) {
                        if (!var7_12) continue;
                        var2_3.put(var5_11, var4_10);
                        continue;
                    }
                    var2_3.put(var5_11, var4_10);
                }
                if (var7_12) continue;
                System.out.println(FileoutputUtil.NowTime() + "\u88dd\u5099\u8907\u88fd_\u65b0\u6aa2\u6e2c \u89d2\u8272ID:" + a + "\u3000\u7269\u54c1\u540d\u7a31: " + MapleItemInformationProvider.getInstance().getName(((IItem)var4_10.left).getItemId()) + " " + ((IItem)var4_10.left).toString());
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("\u88dd\u5099\u8907\u88fd_\u65b0\u6aa2\u6e2c \u89d2\u8272ID:" + a + "\u3000\u7269\u54c1\u540d\u7a31: " + MapleItemInformationProvider.getInstance().getName(((IItem)var4_10.left).getItemId()) + " " + ((IItem)var4_10.left).toString()));
                if (GameConstants.getInventoryType(((IItem)var4_10.left).getItemId()) == MapleInventoryType.USE && (var3_9 = MapleCharacterUtil.loadAccountidByPlayerid(a)) > 0) {
                    MapleCharacterUtil.setMonitored(var3_9, true);
                }
                FileoutputUtil.logToFile(PlayerHandler.ALLATORIxDEMO(">z5f}]3v9:\u8955\u88e8}\u88c8\u50cb\u8912\u88afJ\u65e2\u6ab7\u6e7e;&m&"), FileoutputUtil.NowTime() + "\u89d2\u8272ID:" + a + "\u3000\u7269\u54c1\u540d\u7a31: " + MapleItemInformationProvider.getInstance().getName(((IItem)var4_10.left).getItemId()) + " " + ((IItem)var4_10.left).toString() + "\r\n");
            }
            return var2_3;
        }
        catch (Exception a) {
            a.printStackTrace();
        }
        return var2_3;
    }

    public static /* synthetic */ void RemoveCheck(MapleInventoryType a2) {
        CheckCopyItem.getCheckItem(a2).clear();
    }
}

