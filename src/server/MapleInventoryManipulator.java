/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5976\u8336\u8c37
 *  constants.ItemConstants$\u985e\u578b
 */
package server;

import client.ISkill;
import client.JobFlag;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleFriendship;
import client.MapleJob;
import client.MapleQuestStatus;
import client.MapleTrait;
import client.PlayerStats;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import client.inventory.CheckItemFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.InventoryException;
import client.inventory.Item;
import client.inventory.ItemCustomFlag;
import client.inventory.ItemFlag;
import client.inventory.MapleAndroid;
import client.inventory.MapleEquipOnlyId;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.ModifyInventory;
import client.messages.commands.player.\u5976\u8336\u8c37;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.SkillConstants;
import handling.opcodes.MapleBuffStat;
import handling.world.World;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.CashItem;
import server.CashItemFactory;
import server.Extend.SpecialEquipFactory;
import server.Framework.MapleExtendedSlots;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.Randomizer;
import server.StructPotentialItem;
import server.Timer;
import server.gashapon.GashaponReward;
import server.quest.MapleQuest;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.packet.MTSCSPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleInventoryManipulator {
    public static /* synthetic */ boolean checkEquipPosition(MapleClient a2, int a3, IItem a4) {
        MapleQuestStatus mapleQuestStatus;
        IItem iItem;
        Map<String, Integer> map;
        MapleCharacter mapleCharacter;
        boolean bl;
        block21: {
            block20: {
                block19: {
                    bl = true;
                    mapleCharacter = a2.getPlayer();
                    map = MapleItemInformationProvider.getInstance().getEquipStats(a4.getItemId());
                    if (a3 > -1200 && a3 < -999 && !ItemConstants.isEvanDragonItem(a4.getItemId()) && !ItemConstants.isMechanicItem(a4.getItemId())) {
                        if (mapleCharacter.isStaff()) {
                            IItem iItem2;
                            boolean bl2;
                            int n2 = a4.getItemId();
                            if (!ItemConstants.isEvanDragonItem(a4.getItemId())) {
                                bl2 = true;
                                iItem2 = a4;
                            } else {
                                bl2 = false;
                                iItem2 = a4;
                            }
                            mapleCharacter.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " source: " + n2 + " !isEvanDragonItem: " + bl2 + " !isMechanicItem: " + !ItemConstants.isMechanicItem(iItem2.getItemId()));
                        }
                        bl = false;
                    }
                    if (a3 > -5000 || a3 < -5003) break block19;
                    if (ItemConstants.\u985e\u578b.\u5716\u9a30((int)a4.getItemId())) break block20;
                    if (mapleCharacter.isStaff()) {
                        mapleCharacter.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " source: " + a4.getItemId() + " !\u5716\u9a30: " + !ItemConstants.\u985e\u578b.\u5716\u9a30((int)a4.getItemId()));
                    }
                    bl = false;
                    iItem = a4;
                    break block21;
                }
                if ((a3 <= -1200 || a3 >= -999 && a3 < -99) && map != null && !map.containsKey(MapleFriendship.ALLATORIxDEMO("HyXp")) && !ItemConstants.\u985e\u578b.\u6a5f\u5668\u4eba((int)a4.getItemId()) && a4.getItemId() != 1112804) {
                    if (mapleCharacter.isStaff()) {
                        IItem iItem3;
                        boolean bl3;
                        int n3 = a4.getItemId();
                        if (!map.containsKey(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"z0j9"))) {
                            bl3 = true;
                            iItem3 = a4;
                        } else {
                            bl3 = false;
                            iItem3 = a4;
                        }
                        mapleCharacter.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " source: " + n3 + " !isCash: " + bl3 + "!is\u6a5f\u5668\u4eba: " + !ItemConstants.is\u5fc3\u81df(iItem3.getItemId()));
                    }
                    bl = false;
                }
                if (a3 <= -1300 && a3 > -1400 && !JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(mapleCharacter.getJob())) {
                    if (mapleCharacter.isStaff()) {
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        mapleCharacter2.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " source: " + a4.getItemId() + " is\u5929\u4f7f\u7834\u58de\u8005: " + JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(mapleCharacter2.getJob()));
                    }
                    bl = false;
                }
                if (a3 <= -1200 && a3 > -1300 && mapleCharacter.getAndroid() == null) {
                    if (mapleCharacter.isStaff()) {
                        MapleCharacter mapleCharacter3 = mapleCharacter;
                        mapleCharacter3.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " source: " + a4.getItemId() + " android: " + mapleCharacter3.getAndroid());
                    }
                    bl = false;
                }
                if (!ItemFlag.ANDROID_ACTIVATED.check(a4.getFlag()) && a3 >= -999 && a3 < -99 && map != null && map.getOrDefault(MapleFriendship.ALLATORIxDEMO("HyXp"), 0) == 0 && a4.getItemId() != 1112804) {
                    if (mapleCharacter.isStaff()) {
                        mapleCharacter.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " stats: " + map);
                    }
                    bl = false;
                }
            }
            iItem = a4;
        }
        if (!iItem.isCash() && GameConstants.isWeapon(a4.getItemId()) && a4.getItemId() != 1342069 && a3 != -10 && a3 != -11 || a4.getItemId() == 1342069 && a3 != -110) {
            if (mapleCharacter.isStaff()) {
                mapleCharacter.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " stats: " + map + " isWeapon: " + GameConstants.isWeapon(a4.getItemId()));
            }
            bl = false;
        }
        if (ItemConstants.isPendantSlot(a3) && ((mapleQuestStatus = mapleCharacter.getQuestNoAdd(MapleQuest.getInstance(122700))) == null || mapleQuestStatus.getCustomData() == null || Long.parseLong(mapleQuestStatus.getCustomData()) < System.currentTimeMillis())) {
            if (mapleCharacter.isStaff()) {
                mapleCharacter.dropMessage("\u7a7f\u6234\u88dd\u5099\u7570\u5e38 dst: " + a3 + " stats: " + map + " isWeapon: " + GameConstants.isWeapon(a4.getItemId()));
            }
            bl = false;
        }
        return bl;
    }

    private static /* synthetic */ int ALLATORIxDEMO(int a2, int a3) {
        return Math.abs(Randomizer.rand(a2, a3));
    }

    private static final /* synthetic */ IItem ALLATORIxDEMO(IItem a2, MapleCharacter a3) {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (ItemConstants.\u985e\u578b.\u6a5f\u68b0((int)a2.getItemId()) || ItemConstants.\u985e\u578b.\u9f8d\u88dd\u5099((int)a2.getItemId())) {
                return a2;
            }
            if (a2 instanceof Equip && ((Equip)(a3 = (Equip)a2)).getState() == 0 && (((Equip)a3).getUpgradeSlots() >= 1 || ((Equip)a3).getLevel() >= 1) && Randomizer.nextInt(100) > 80) {
                ((Equip)a3).resetPotential();
            }
        }
        return a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void move(MapleClient a2, MapleInventoryType a3, short a4, short a52, boolean a62, boolean a7) {
        MapleClient mapleClient;
        short s2;
        Object object;
        short s3;
        boolean bl;
        boolean bl2;
        boolean bl3;
        IItem iItem;
        IItem iItem2;
        MapleItemInformationProvider mapleItemInformationProvider;
        block35: {
            block30: {
                block34: {
                    MapleExtendedSlots mapleExtendedSlots;
                    MapleExtendedSlots a62;
                    block33: {
                        block32: {
                            block31: {
                                if (a4 < 0 || a52 < 0 || a4 == a52 || a3 == MapleInventoryType.EQUIPPED) {
                                    return;
                                }
                                if (a52 <= 97 && a52 > a2.getPlayer().getInventory(a3).getSlotLimit()) {
                                    return;
                                }
                                mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                                MapleClient mapleClient2 = a2;
                                iItem2 = mapleClient2.getPlayer().getInventory(a3).getItem(a4);
                                iItem = mapleClient2.getPlayer().getInventory(a3).getItem(a52);
                                if (iItem2 == null) {
                                    return;
                                }
                                bl3 = false;
                                bl2 = false;
                                bl = false;
                                s3 = -1;
                                if (!a62) break block30;
                                a62 = null;
                                object = null;
                                if (!a7) break block31;
                                a62 = a2.getPlayer().getExtendedSlotByIndex(a52 / 100 - 1);
                                if (a4 < 100) break block32;
                                object = a2.getPlayer().getExtendedSlotByIndex(a4 / 100 - 1);
                                mapleExtendedSlots = a62;
                                break block33;
                            }
                            a62 = a2.getPlayer().getExtendedSlotByIndex(a4 / 100 - 1);
                        }
                        mapleExtendedSlots = a62;
                    }
                    if (mapleExtendedSlots == null) break block30;
                    int n2 = a62.getUniqueid();
                    if (!a7) break block34;
                    iItem2.setUniqueId(n2);
                    if (a4 < 100 || object == null || iItem == null) break block30;
                    s2 = a52;
                    iItem.setUniqueId(((MapleExtendedSlots)object).getUniqueid());
                    break block35;
                }
                iItem2.setUniqueId(-1);
            }
            s2 = a52;
        }
        if (s2 > a2.getPlayer().getInventory(a3).getSlotLimit()) {
            if (a3 == MapleInventoryType.ETC && a52 > 100 && a52 % 100 != 0) {
                int a62 = a2.getPlayer().getExtendedSlot(a52 / 100 - 1);
                if (a62 <= 0) {
                    MapleClient mapleClient3 = a2;
                    mapleClient3.getPlayer().dropMessage(1, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u7170\u6ccc\u79aa\u52cc\u8a23\u7270\u5490\u5229\u7977\u7270\u809d\u531c\u007f"));
                    mapleClient3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                object = mapleItemInformationProvider.getItemEffect(a62);
                if (a52 % 100 > ((MapleStatEffect)object).getSlotCount() || ((MapleStatEffect)object).getType() != mapleItemInformationProvider.getBagType(iItem2.getItemId()) || ((MapleStatEffect)object).getType() <= 0) {
                    MapleClient mapleClient4 = a2;
                    mapleClient4.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u7139\u6cfe\u79e3\u52fe\u8a6a\u7242\u54d9\u521b\u793e\u7242\u80d4\u532e6"));
                    mapleClient4.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                s3 = 0;
                bl3 = true;
            } else {
                MapleClient mapleClient5 = a2;
                mapleClient5.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u7139\u6cfe\u79e3\u52fe\u8a6a\u7242\u54d9\u521b\u793e\u7242\u80d4\u532e6"));
                mapleClient5.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
        }
        if (a4 > a2.getPlayer().getInventory(a3).getSlotLimit() && a3 == MapleInventoryType.ETC && a4 > 100 && a4 % 100 != 0) {
            if (!bl3) {
                bl2 = true;
                s3 = 0;
                bl3 = true;
            } else {
                bl = true;
            }
        }
        int a62 = -1;
        if (iItem != null) {
            a62 = iItem.getQuantity();
        }
        short s4 = iItem2.getQuantity();
        short s5 = mapleItemInformationProvider.getSlotMax(iItem2.getItemId());
        a2.getPlayer().getInventory(a3).move(a4, a52, s5, a2.getPlayer());
        ArrayList<ModifyInventory> a52 = new ArrayList<ModifyInventory>();
        if (GameConstants.isHarvesting(iItem2.getItemId())) {
            a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
        }
        if (!a3.equals((Object)MapleInventoryType.EQUIP) && iItem != null && iItem.getItemId() == iItem2.getItemId() && iItem.getOwner().equals(iItem2.getOwner()) && iItem.getExpiration() == iItem2.getExpiration() && !GameConstants.isRechargable(iItem2.getItemId()) && !a3.equals((Object)MapleInventoryType.CASH)) {
            if (GameConstants.isHarvesting(iItem.getItemId())) {
                a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
            }
            if (a62 + s4 > s5) {
                IItem iItem3;
                int n3;
                IItem iItem4;
                int n4;
                if (bl3 && (bl2 || bl)) {
                    n4 = 6;
                    iItem4 = iItem2;
                } else {
                    n4 = 1;
                    iItem4 = iItem2;
                }
                a52.add(new ModifyInventory(n4, iItem4));
                if (bl3 && (bl2 || bl)) {
                    n3 = 6;
                    iItem3 = iItem;
                } else {
                    n3 = 1;
                    iItem3 = iItem;
                }
                a52.add(new ModifyInventory(n3, iItem3));
                mapleClient = a2;
            } else {
                IItem iItem5;
                int n5;
                IItem iItem6;
                int n6;
                if (bl3 && (bl2 || bl)) {
                    n6 = 7;
                    iItem6 = iItem2;
                } else {
                    n6 = 3;
                    iItem6 = iItem2;
                }
                a52.add(new ModifyInventory(n6, iItem6));
                if (bl3 && (!bl2 || bl)) {
                    n5 = 6;
                    iItem5 = iItem;
                } else {
                    n5 = 1;
                    iItem5 = iItem;
                }
                a52.add(new ModifyInventory(n5, iItem5));
                mapleClient = a2;
            }
        } else {
            IItem iItem7;
            int n7;
            if (bl3) {
                if (bl) {
                    n7 = 8;
                    iItem7 = iItem2;
                } else {
                    n7 = 5;
                    iItem7 = iItem2;
                }
            } else {
                n7 = 2;
                iItem7 = iItem2;
            }
            a52.add(new ModifyInventory(n7, iItem7, a4, s3, bl2));
            mapleClient = a2;
        }
        mapleClient.sendPacket(MaplePacketCreator.modifyInventory(true, a52));
        a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
    }

    public static /* synthetic */ byte addId(MapleClient a2, int a3, short a4, String a5) {
        return MapleInventoryManipulator.addId(a2, a3, a4, a5, null, 0L);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void equip(MapleClient a, short a, short a) {
        block67: {
            block69: {
                block68: {
                    block66: {
                        var3_4 = MapleItemInformationProvider.getInstance();
                        v0 = a;
                        var4_7 = v0.getPlayer().getStat();
                        var5_9 = v0.getPlayer();
                        var6_10 = (Equip)v0.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a);
                        if (var6_10 == null) {
                            a.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        var7_11 = false;
                        if (MapleItemInformationProvider.getInstance().isUntradeableOnEquip(var6_10.getItemId()) && !ItemFlag.UNTRADEABLE.check(var6_10.getFlag())) {
                            var6_10.setFlag(ItemFlag.UNTRADEABLE.getValue());
                            var7_11 = true;
                        }
                        if ((ItemCustomFlag.\u5c08\u5c6c\u9053\u5177.check(var6_10.getCustomFlag()) || MapleItemInformationProvider.getInstance().isOnlyEquip(var6_10.getItemId()) || MapleItemInformationProvider.getInstance().isOnly(var6_10.getItemId())) && a.getPlayer().hasEquipped(var6_10.getItemId())) {
                            v1 = a;
                            v1.getPlayer().dropMessage(1, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u60f9\u5deb\u7a2e\u622d\u76a9\u5415\u5c59\u5c75\u9002\u516e\u3053"));
                            v1.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (GameConstants.isGMEquip(var6_10.getItemId()) && !a.getPlayer().isGM() && !a.getChannelServer().CanGMItem()) {
                            v2 = a;
                            v2.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u53f2\u6722\u7bb9\u742d\u54f9\u80d6\u88c5\u50b2\u9001\u4edd\u904b\u515c\u301a"));
                            v2.getPlayer().removeAll(var6_10.getItemId(), true);
                            v2.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (a.getPlayer().isPlayer() && ItemConstants.isOverPoweredEquip(a, a)) {
                            v3 = a;
                            v3.getPlayer().dropMessage(1, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u677d\u88c4\u50c8\u80e4\u52ca\u9057\u65ed\u5f2e\u59765q\u8ad2\u803e\u7e72\u7bf0\u741f\u54b0"));
                            v3.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (a.getPlayer().isPlayer() && ItemConstants.WashHpEquipBan(a, a)) {
                            v4 = a;
                            v4.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u6707\u88c5\u50b2\u70a2\u6d3c\u8858\u88f64\u000b\u6ccd\u5e00\u7139\u6cfe\u7a67\u621f\u301a"));
                            v4.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (var6_10.getExpiration() > 0L && var6_10.getExpiration() < System.currentTimeMillis()) {
                            MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.EQUIP, a, (short)1, false);
                            v5 = a;
                            v5.getPlayer().dropMessage(1, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u6735\u888c\u5080\u5da3\u8d9c\u901f\u4f66\u7579\u6706\u96015\u7caa\u7d68\u81bb\u52cc\u5e3a\u60b1\u6e54\u967d\u888c\u5080\u3053"));
                            v5.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (!GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u659b\u871a\u4e60\u8c2f")) && !MapleInventoryManipulator.checkEquipPosition(a, a, var6_10)) {
                            a.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        var8_12 = var3_4.getEquipStats(var6_10.getItemId());
                        if (var8_12 != null && !var3_4.canEquip(var8_12, var6_10.getItemId(), var5_9.getLevel(), var5_9.getJob(), var5_9.getFame(), var4_7.getTotalStr(), var4_7.getTotalDex(), var4_7.getTotalLuk(), var4_7.getTotalInt(), a.getPlayer().getStat().levelBonus)) {
                            var9_13 = var3_4;
                            var10_18 = "\r\n" + FileoutputUtil.CurrentReadable_Time() + " \u9053\u5177" + var6_10.getItemName() + "[" + var6_10.getItemId() + "]";
                            var11_23 = var6_10.getItemId();
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u73a9\u5bb6:" + var5_9.getName() + " \r\n\u76ee\u524d\u5e33\u865f: " + var5_9.getClient().getAccountName();
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u7b49\u7d1a:" + var5_9.getLevel() + " \r\n\u9700\u8981\u7b49\u7d1a: " + var9_13.getReqLevel(var11_23);
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u8077\u696d:" + var5_9.getJob() + " \r\n\u9700\u8981\u8077\u696d: " + var9_13.getReqJob(var11_23);
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u540d\u8072:" + var5_9.getFame() + " \r\n\u9700\u8981\u540d\u8072: " + var9_13.getReqFame(var11_23);
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u529b\u91cf:" + var5_9.getStat().getTotalStr() + " \r\n\u9700\u8981\u529b\u91cf: " + var9_13.getReqStr(var11_23);
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u654f\u6377:" + var5_9.getStat().getTotalDex() + " \r\n\u9700\u8981\u654f\u6377: " + var9_13.getReqDex(var11_23);
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u5e78\u904b:" + var5_9.getStat().getTotalLuk() + " \r\n\u9700\u8981\u5e78\u904b: " + var9_13.getReqLuk(var11_23);
                            var10_18 = var10_18 + "\r\n\u76ee\u524d\u667a\u529b:" + var5_9.getStat().getTotalInt() + "\r\n \u9700\u8981\u667a\u529b: " + var9_13.getReqInt(var11_23);
                            System.out.println(var10_18);
                            FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"u>~\"6\u0019x2r~\u7138\u6c84\u88c4\u6265\u904a\u51267%a%"), var10_18);
                            a.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        var9_14 = var3_4;
                        var10_19 = var9_14.getReqJob(var6_10.getItemId());
                        var11_24 = true;
                        var3_4 = new StringBuilder();
                        if (var10_19 > 0) {
                            var4_8 = var5_9.getJob();
                            if (MapleJob.is\u528d\u58eb(var4_8) && !JobFlag.\u528d\u58eb.check(var10_19)) {
                                var3_4.append("\u8077\u696d: \u528d\u58eb \u88dd\u5099:" + var6_10.getItemName() + " \u4ee3\u78bc:" + var6_10.getItemId());
                                var11_24 = false;
                            }
                            if (MapleJob.is\u6cd5\u5e2b(var4_8) && !JobFlag.\u6cd5\u5e2b.check(var10_19)) {
                                var3_4.append("\u8077\u696d: \u528d\u58eb \u88dd\u5099:" + var6_10.getItemName() + " \u4ee3\u78bc:" + var6_10.getItemId());
                                var11_24 = false;
                            }
                            if (MapleJob.is\u5f13\u7bad\u624b(var4_8) && !JobFlag.\u5f13\u7bad\u624b.check(var10_19)) {
                                var3_4.append("\u8077\u696d: \u528d\u58eb \u88dd\u5099:" + var6_10.getItemName() + " \u4ee3\u78bc:" + var6_10.getItemId());
                                var11_24 = false;
                            }
                            if (MapleJob.is\u76dc\u8cca(var4_8) && !JobFlag.\u76dc\u8cca.check(var10_19)) {
                                var3_4.append("\u8077\u696d: \u528d\u58eb \u88dd\u5099:" + var6_10.getItemName() + " \u4ee3\u78bc:" + var6_10.getItemId());
                                var11_24 = false;
                            }
                            if (MapleJob.is\u6d77\u76dc(var4_8) && !JobFlag.\u6d77\u76dc.check(var10_19)) {
                                var3_4.append("\u8077\u696d: \u528d\u58eb \u88dd\u5099:" + var6_10.getItemName() + " \u4ee3\u78bc:" + var6_10.getItemId());
                                var11_24 = false;
                            }
                        }
                        if (!var11_24) {
                            FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("tD\u007fX7cyHs\u0004\u7139\u6cfe\u88c5\u621f\u904b\u515c5\u805c\u6975\u0005lSl"), "\r\n" + FileoutputUtil.CurrentReadable_Time() + " " + var3_4.toString());
                            a.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        if (a.getPlayer().getDebugMessage()) {
                            a.getPlayer().dropMessage("\u7a7f\u88dd\u5099: src : " + a + " dst : " + a + " \u4ee3\u78bc\uff1a" + var6_10.getItemId() + " \u552f\u4e00ID: " + var6_10.getEquipOnlyId());
                        }
                        if (ItemConstants.isEvanDragonItem(var6_10.getItemId()) && (var5_9.getJob() < 2200 || var5_9.getJob() > 2218)) {
                            a.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        switch (a) {
                            case -106: 
                            case -6: {
                                var4_7 = a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-5);
                                if (var4_7 == null || !MapleInventoryManipulator.H(var4_7.getItemId())) break;
                                if (a.getPlayer().getInventory(MapleInventoryType.EQUIP).isFull()) {
                                    v6 = a;
                                    v6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    v6.sendPacket(MaplePacketCreator.getShowInventoryFull());
                                    return;
                                }
                                MapleInventoryManipulator.unequip(a, (short)-5, a.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
                                v7 = a;
                                break block66;
                            }
                            case -105: 
                            case -5: {
                                var3_4 = a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-6);
                                if (var3_4 == null || !MapleInventoryManipulator.H(var6_10.getItemId())) break;
                                if (a.getPlayer().getInventory(MapleInventoryType.EQUIP).isFull()) {
                                    v8 = a;
                                    v8.sendPacket(MaplePacketCreator.getInventoryFull());
                                    v8.sendPacket(MaplePacketCreator.getShowInventoryFull());
                                    return;
                                }
                                MapleInventoryManipulator.unequip(a, (short)-6, a.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
                                v7 = a;
                                break block66;
                            }
                            case -110: 
                            case -10: {
                                if (GameSetConstants.SERVER_NAME.equals(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u5e29\u4e52\u8c66")) || GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u6607\u585e\u8c2f")) || GameSetConstants.SERVER_NAME.equals(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u7cd8\u7d1c\u8c66"))) break;
                                if (GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u659b\u82a9\u5368\u8c2f"))) {
                                    v7 = a;
                                } else {
                                    var9_14 = (Equip)a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
                                    if (var9_14 == null || !MapleItemInformationProvider.getInstance().isTwoHanded(var9_14.getItemId())) break;
                                    if (ItemConstants.is\u8077\u696d\u7279\u6b8a\u88dd\u5099(var6_10.getItemId())) {
                                        v7 = a;
                                    } else {
                                        if (a.getPlayer().getInventory(MapleInventoryType.EQUIP).isFull()) {
                                            v9 = a;
                                            v9.sendPacket(MaplePacketCreator.getInventoryFull());
                                            v9.sendPacket(MaplePacketCreator.getShowInventoryFull());
                                            return;
                                        }
                                        MapleInventoryManipulator.unequip(a, (short)-11, a.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
                                        v7 = a;
                                    }
                                }
                                break block66;
                            }
                            case -11: {
                                if (GameSetConstants.SERVER_NAME.equals(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u5e29\u4e52\u8c66")) || GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u6607\u585e\u8c2f")) || GameSetConstants.SERVER_NAME.equals(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u7cd8\u7d1c\u8c66"))) break;
                                if (GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u659b\u82a9\u5368\u8c2f"))) {
                                    v7 = a;
                                } else {
                                    var10_20 = a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-10);
                                    if (var10_20 == null || !MapleItemInformationProvider.getInstance().isTwoHanded(var6_10.getItemId())) break;
                                    if (ItemConstants.is\u8077\u696d\u7279\u6b8a\u88dd\u5099(var10_20.getItemId())) {
                                        v7 = a;
                                    } else {
                                        if (a.getPlayer().getInventory(MapleInventoryType.EQUIP).isFull()) {
                                            v10 = a;
                                            v10.sendPacket(MaplePacketCreator.getInventoryFull());
                                            v10.sendPacket(MaplePacketCreator.getShowInventoryFull());
                                            return;
                                        }
                                        MapleInventoryManipulator.unequip(a, (short)-10, a.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot(), true);
                                        v7 = a;
                                    }
                                }
                                break block66;
                            }
                        }
                        v7 = a;
                    }
                    if (v7 == -18 && a.getPlayer().getMount() != null) {
                        a.getPlayer().getMount().setItemId(var6_10.getItemId());
                    }
                    var6_10 = (Equip)a.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a);
                    var4_7 = (Equip)a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(a);
                    a.getPlayer().getInventory(MapleInventoryType.EQUIP).removeSlot(a.getPlayer(), a);
                    if (var4_7 != null) {
                        a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).removeSlot(a.getPlayer(), a);
                    }
                    if (GameSetConstants.MAPLE_VERSION < 134) break block67;
                    var3_5 = var6_10.getFlag();
                    if (!(var8_12.get(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"4h$p!M#x5|\u0013u>z:")) == null && var6_10.getItemId() / 10000 != 167 || ItemFlag.UNTRADEABLE.check(var3_5))) {
                        var6_10.setFlag(var3_5 |= ItemFlag.UNTRADEABLE.getValue());
                        var7_11 = true;
                    }
                    if (var6_10.getItemId() / 10000 != 166) break block68;
                    if (var6_10.getAndroid() == null) {
                        var9_15 = MapleInventoryIdentifier.getInstance();
                        v11 = var6_10;
                        var6_10.setUniqueId(var9_15);
                        v11.setAndroid(MapleAndroid.create(v11.getItemId(), var9_15));
                        var3_5 |= ItemFlag.UNTRADEABLE.getValue();
                        v11.setFlag(var3_5 |= ItemFlag.ANDROID_ACTIVATED.getValue());
                        var7_11 = true;
                    }
                    if (!ItemFlag.ANDROID_ACTIVATED.check(var3_5)) {
                        var6_10.setFlag(var3_5 |= ItemFlag.ANDROID_ACTIVATED.getValue());
                        var7_11 = true;
                    }
                    if (!ItemFlag.UNTRADEABLE.check(var3_5)) {
                        var6_10.setFlag(var3_5 |= ItemFlag.UNTRADEABLE.getValue());
                        var7_11 = true;
                    }
                    var5_9.removeAndroid();
                    var5_9.setAndroid(var6_10.getAndroid());
                    v12 = var6_10;
                    break block69;
                }
                if (var5_9.getAndroid() == null) ** GOTO lbl198
                if (a <= -1300) {
                    v12 = var6_10;
                    v13 = var5_9;
                    v13.setAndroid(v13.getAndroid());
                } else {
                    if (a <= -1200) {
                        var5_9.updateAndroid(1, var6_10.getItemId());
                    }
lbl198:
                    // 4 sources

                    v12 = var6_10;
                }
            }
            if (v12.getCharmEXP() > 0 && !ItemFlag.CHARM_EQUIPPED.check(var3_5)) {
                v14 = var6_10;
                var5_9.getTrait(MapleTrait.MapleTraitType.\u9b45\u529b).addExp(v14.getCharmEXP(), var5_9);
                v14.setCharmEXP((short)0);
                v14.setFlag(var3_5 |= ItemFlag.CHARM_EQUIPPED.getValue());
                var7_11 = true;
            }
            if (GameConstants.isWeapon(var6_10.getItemId())) {
                v15 = a;
                v15.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.BOOSTER);
                v15.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.SPIRIT_CLAW);
                v15.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.SOULARROW);
                v15.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.WK_CHARGE);
                v15.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.LIGHTNING_CHARGE);
                if (var6_10.getItemId() / 10000 == 190 || var6_10.getItemId() / 10000 == 191) {
                    v16 = a;
                    v16.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.MONSTER_RIDING);
                    v16.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.MECH_CHANGE);
                } else if (!(GameConstants.isReverseItem(var6_10.getItemId()) || GameConstants.isTimelessItem(var6_10.getItemId()) || var8_12.containsKey(MapleFriendship.ALLATORIxDEMO("Y}ZTNnNt")) && var8_12.get(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"k4h\u001d|'|=")) >= 140 || var8_12.containsKey(MapleFriendship.ALLATORIxDEMO("Y}ZTNnNt")) && var8_12.get(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"k4h\u001d|'|=")) >= 130 || var6_10.getItemId() != 0x111EE1)) {
                    var5_9.startFairySchedule(true, true);
                }
            }
        }
        var3_6 = new ArrayList<ModifyInventory>();
        if (var7_11) {
            var3_6.add(new ModifyInventory(3, var6_10));
            var3_6.add(new ModifyInventory(0, var6_10.copy()));
        }
        var6_10.setPosition(a);
        a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).addFromDB(a.getPlayer(), var6_10);
        if (var4_7 != null) {
            var4_7.setPosition(a);
            a.getPlayer().getInventory(MapleInventoryType.EQUIP).addFromDB(a.getPlayer(), (IItem)var4_7);
        }
        if (a.getPlayer().getBuffedValue(MapleBuffStat.BOOSTER) != null && MapleInventoryManipulator.ALLATORIxDEMO(var6_10.getItemId())) {
            v17 = new MapleBuffStat[1];
            v17[0] = MapleBuffStat.BOOSTER;
            a.getPlayer().cancelBuffStats(v17);
        }
        var3_6.add(new ModifyInventory(2, var6_10, a));
        a.sendPacket(MaplePacketCreator.modifyInventory(true, var3_6, var5_9));
        if (var5_9.getStat().equipmentBonusExp > 0) {
            v18 = var5_9;
            v18.dropMessage("\u7531\u65bc\u88dd\u4e0a\u7d93\u9a57\u88dd\u5099,\u6253\u602a\u5c07\u7372\u5f97\u984d\u5916\u7684" + v18.getStat().equipmentBonusExp + "%\u7d93\u9a57\u503c");
        }
        if (ItemConstants.isHarvesting(var6_10.getItemId())) {
            var5_9.getStat().handleProfessionTool(var5_9);
        }
        if (ItemConstants.isDragonItem(var6_10.getItemId())) {
            var5_9.finishAchievement(8);
        } else if (ItemConstants.is\u5f37\u5316\u88dd\u5099(var6_10.getItemId())) {
            var5_9.finishAchievement(9);
        } else if (ItemConstants.is\u6c38\u6046\u88dd\u5099(var6_10.getItemId())) {
            var5_9.finishAchievement(10);
        }
        if (GameSetConstants.CHECK_EQUIPLVL) {
            var9_16 = MapleItemInformationProvider.getInstance().getReqLevel(var6_10.getItemId());
            var10_21 = 0;
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                var10_21 = a.getPlayer().getStat().levelBonus;
            }
            if (var9_16 > a.getPlayer().getLevel() + var10_21 && !a.getPlayer().isGM()) {
                FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("GwLk\u0004PJ{@7iyE7\u4fc5\u6521\u5c2a\u531d\u0005lSl"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a.getPlayer().getName() + "(" + a.getPlayer().getId() + ") <\u7b49\u7d1a: " + a.getPlayer().getLevel() + " > \u4fee\u6539\u88dd\u5099(" + var6_10.getItemId() + ")\u5c01\u5305\uff0c\u7a7f\u4e0a\u88dd\u5099\u6642\u5c01\u9396\u3002 \u8a72\u88dd\u5099\u9700\u6c42\u7b49\u7d1a: " + var9_16);
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a.getPlayer().getName() + " \u56e0\u70ba\u4fee\u6539\u5c01\u5305\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]  " + a.getPlayer().getName() + "(" + a.getPlayer().getId() + ") <\u7b49\u7d1a: " + a.getPlayer().getLevel() + " > \u4fee\u6539\u88dd\u5099(" + var6_10.getItemId() + ")\u5c01\u5305\uff0c\u7a7f\u4e0a\u88dd\u5099\u6642\u5c01\u9396\u3002 \u8a72\u88dd\u5099\u9700\u6c42\u7b49\u7d1a: " + var9_16));
                a.getPlayer().ban(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u4ff7\u6568\u5c18\u5354"), true, true, false);
                a.getSession().close();
                return;
            }
        }
        a.getPlayer().equipChanged();
        if (var6_10.getItemId() == 0x111EE1) {
            a.getPlayer().startFairySchedule(true, true);
        }
        if (SpecialEquipFactory.getInstance().getSkillByEquipId(var6_10.getItemId()) == null) return;
        var9_17 = SpecialEquipFactory.getInstance().getSkillByEquipId(var6_10.getItemId()).getLeft();
        var10_22 = SpecialEquipFactory.getInstance().getSkillByEquipId(var6_10.getItemId()).getRight();
        var9_17 = SkillConstants.getSpecialSkillByJob(var9_17, a.getPlayer().getJob());
        a = SkillFactory.getSkill(var9_17);
        if (a.getPlayer().containsBindingBySkillid(var9_17) != false) return;
        if (!GameSetConstants.SERVER_NAME.equals(MapleFriendship.ALLATORIxDEMO("\u832e\u831d\u8c2f")) && a.getPlayer().getSkillLevel(var9_17) > 0) {
            var5_9.dropMessage("\u60a8\u672c\u8eab\u5df2\u7d93\u64c1\u6709\u6280\u80fd:" + SkillFactory.getSkillName(var9_17) + ".\u56e0\u6b64\u7a7f\u6234\u7121\u6548!");
            return;
        }
        if (var9_17 == 4111006 && GameSetConstants.SERVER_NAME.equals(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u754d\u5fda\u8c66"))) {
            var5_9.dropMessage("\u7531\u65bc\u88dd\u4e0a\u6280\u80fd\u88dd\u5099,\u7372\u5f97\u6280\u80fd:" + SkillFactory.getSkillName(var9_17) + "!(\u4f4d\u65bc\u9375\u76e4\"-\")");
            v19 = a;
            v19.sendPacket(MaplePacketCreator.updateSkill(var9_17, var10_22, a.getMaxLevel(), -1L));
            v19.getPlayer().changeKeybinding(12, (byte)0, 0);
            v19.getPlayer().changeKeybinding(12, (byte)1, var9_17);
            v19.getPlayer().getClient().sendPacket(MaplePacketCreator.getKeymap(a.getPlayer().getKeyLayout()));
            return;
        }
        var5_9.dropMessage("\u7531\u65bc\u88dd\u4e0a\u6280\u80fd\u88dd\u5099,\u7372\u5f97\u6280\u80fd:" + SkillFactory.getSkillName(var9_17) + "!(\u4f4d\u65bc\u9375\u76e4\"=\")");
        v20 = a;
        v20.sendPacket(MaplePacketCreator.updateSkill(var9_17, var10_22, a.getMaxLevel(), -1L));
        v20.getPlayer().changeKeybinding(GameSetConstants.EQUIPSKILL_KEY, (byte)0, 0);
        v20.getPlayer().changeKeybinding(GameSetConstants.EQUIPSKILL_KEY, (byte)1, var9_17);
        v20.getPlayer().getClient().sendPacket(MaplePacketCreator.getKeymap(a.getPlayer().getKeyLayout()));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ IItem addbyId_Gachapon(MapleClient a2, int a3, short a4, int a5, int a6) {
        short s2;
        if (a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot() == -1 || a2.getPlayer().getInventory(MapleInventoryType.USE).getNextFreeSlot() == -1 || a2.getPlayer().getInventory(MapleInventoryType.ETC).getNextFreeSlot() == -1 || a2.getPlayer().getInventory(MapleInventoryType.SETUP).getNextFreeSlot() == -1) {
            return null;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (mapleItemInformationProvider.isPickupRestricted(a3) && a2.getPlayer().haveItem(a3, true ? 1 : 0, true, false)) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
            mapleClient.sendPacket(MaplePacketCreator.showItemUnavailable());
            return null;
        }
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a3);
        if (!mapleInventoryType.equals((Object)MapleInventoryType.EQUIP)) {
            MapleClient mapleClient = a2;
            short s3 = mapleItemInformationProvider.getSlotMax(mapleClient, a3);
            List<IItem> list = mapleClient.getPlayer().getInventory(mapleInventoryType).listById(a3);
            if (!GameConstants.isRechargable(a3)) {
                boolean bl;
                IItem iItem;
                block16: {
                    short s4;
                    short s5;
                    iItem = null;
                    boolean bl2 = false;
                    if (list.size() > 0) {
                        Iterator<IItem> iterator = list.iterator();
                        while (a4 > 0 && iterator.hasNext()) {
                            iItem = (Item)iterator.next();
                            s5 = iItem.getQuantity();
                            if (s5 >= s3) continue;
                            bl2 = true;
                            short s6 = (short)Math.min(s5 + a4, s3);
                            a4 = (short)(a4 - (s6 - s5));
                            iItem.setQuantity(s6);
                            a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, iItem)));
                        }
                    }
                    while (a4 > 0 && (s4 = (short)Math.min(a4, s3)) != 0) {
                        a4 = (short)(a4 - s4);
                        iItem = new Item(a3, 0, s4, 0);
                        s5 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), iItem);
                        if (s5 == -1 && bl2) {
                            return iItem;
                        }
                        if (s5 == -1) {
                            return null;
                        }
                        bl2 = true;
                        a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, iItem)));
                        if (!GameConstants.isRechargable(a3) || a4 != 0) continue;
                        bl = bl2;
                        break block16;
                    }
                    bl = bl2;
                }
                if (!bl) return null;
                IItem iItem2 = iItem;
                a2.getPlayer().havePartyQuest(iItem2.getItemId());
                return iItem2;
            }
            Item item2 = new Item(a3, 0, a4, 0);
            short s7 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), item2);
            if (s7 == -1) {
                return null;
            }
            MapleClient mapleClient2 = a2;
            mapleClient2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, item2)));
            mapleClient2.getPlayer().havePartyQuest(item2.getItemId());
            return item2;
        }
        if (a4 != 1) throw new InventoryException(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"M#`8w69%vqz#|0m494h$p!9&p%qqw>w|v?|qh$x?m8m("));
        MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
        Equip equip = mapleItemInformationProvider2.randomizeStats_scroll((Equip)mapleItemInformationProvider2.getEquipById(a3), a5, a6);
        if (GameConstants.isEquip(equip.getItemId()) && GameSetConstants.COPTITEMCHECK_STRICT) {
            a2.getPlayer().checkCopyItems(equip);
        }
        if ((s2 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), equip)) == -1) {
            return null;
        }
        if (ItemConstants.isHarvesting(equip.getItemId())) {
            a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
        }
        if (equip.hasSetOnlyId()) {
            equip.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
        }
        if (equip.getInventoryitemId() <= 0L) {
            equip.setInventoryitemId(MapleInventoryIdentifier.getInstance());
        }
        if (MapleItemInformationProvider.getInstance().isCash(equip.getItemId()) && equip.getUniqueId() < 0) {
            int n2 = MapleInventoryIdentifier.getInstance();
            equip.setUniqueId(n2);
        }
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(0, equip)));
        mapleClient.getPlayer().havePartyQuest(equip.getItemId());
        return equip;
    }

    public static /* synthetic */ boolean addbyItem(MapleClient a2, IItem a3) {
        return MapleInventoryManipulator.addbyItem(a2, a3, false) >= 0;
    }

    public static /* synthetic */ IItem addbyId_Gachapon(MapleClient a2, int a3, short a4) {
        return MapleInventoryManipulator.addbyId_Gachapon(a2, a3, a4, false, null);
    }

    public static /* synthetic */ void move(MapleClient a2, MapleInventoryType a3, short a4, short a5) {
        MapleInventoryManipulator.move(a2, a3, a4, a5, false, false);
    }

    public static /* synthetic */ void unequip(MapleClient a2, short a3, short a42, boolean a5) {
        int n2;
        Equip equip;
        block15: {
            Equip equip2;
            Object object;
            block17: {
                block22: {
                    block20: {
                        block21: {
                            block19: {
                                block18: {
                                    block16: {
                                        equip = (Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(a3);
                                        object = (Equip)a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a42);
                                        if (a42 < 0) {
                                            return;
                                        }
                                        if (equip == null) {
                                            return;
                                        }
                                        if (object != null && a3 <= 0) {
                                            a2.sendPacket(MaplePacketCreator.getInventoryFull());
                                            return;
                                        }
                                        if (a2.getPlayer().getDebugMessage()) {
                                            a2.getPlayer().dropMessage("\u812b\u88dd\u5099: src : " + a3 + " dst : " + a42 + " \u4ee3\u78bc\uff1a" + equip.getItemId() + " \u552f\u4e00ID: " + equip.getEquipOnlyId());
                                        }
                                        if (equip.getItemId() == 0x111EE1) {
                                            a2.getPlayer().cancelFairySchedule(true);
                                        }
                                        a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).removeSlot(a2.getPlayer(), a3);
                                        if (object != null) {
                                            a2.getPlayer().getInventory(MapleInventoryType.EQUIP).removeSlot(a2.getPlayer(), a42);
                                        }
                                        equip.setPosition(a42);
                                        a2.getPlayer().getInventory(MapleInventoryType.EQUIP).addFromDB(a2.getPlayer(), equip);
                                        if (object != null) {
                                            ((Item)object).setPosition(a3);
                                            a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).addFromDB(a2.getPlayer(), (IItem)object);
                                        }
                                        if (GameSetConstants.MAPLE_VERSION < 134) break block15;
                                        if (!GameConstants.isWeapon(equip.getItemId()) || equip.isCash()) break block16;
                                        equip2 = equip;
                                        MapleClient mapleClient = a2;
                                        mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.BOOSTER);
                                        mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.SPIRIT_CLAW);
                                        mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.SOULARROW);
                                        mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.WK_CHARGE);
                                        mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.LIGHTNING_CHARGE);
                                        break block17;
                                    }
                                    if (equip.getItemId() / 10000 != 190 && equip.getItemId() / 10000 != 191) break block18;
                                    MapleClient mapleClient = a2;
                                    mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.MONSTER_RIDING);
                                    mapleClient.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.MECH_CHANGE);
                                    equip2 = equip;
                                    break block17;
                                }
                                if (equip.getItemId() / 10000 != 166 && a3 != -33) break block19;
                                MapleClient mapleClient = a2;
                                mapleClient.getPlayer().removeAndroid();
                                mapleClient.sendPacket(MaplePacketCreator.removeAndroidHeart());
                                equip2 = equip;
                                break block17;
                            }
                            if (a2.getPlayer().getAndroid() == null) break block20;
                            if (a3 > -1300) break block21;
                            equip2 = equip;
                            a2.getPlayer().setAndroid(a2.getPlayer().getAndroid());
                            break block17;
                        }
                        if (a3 > -1200) break block22;
                        equip2 = equip;
                        a2.getPlayer().updateAndroid(1, 0);
                        break block17;
                    }
                    if (equip.getItemId() == 0x111EE1) {
                        a2.getPlayer().cancelFairySchedule(true);
                    }
                }
                equip2 = equip;
            }
            if (equip2.getState() > 1) {
                int n3;
                MapleItemInformationProvider a42 = MapleItemInformationProvider.getInstance();
                int[] arrn = new int[3];
                arrn[0] = equip.getPotential1();
                arrn[1] = equip.getPotential2();
                arrn[2] = equip.getPotential3();
                object = arrn;
                int[] arrn2 = arrn;
                n2 = arrn2.length;
                int n4 = n3 = 0;
                while (n4 < n2) {
                    StructPotentialItem structPotentialItem;
                    int n5 = arrn2[n3];
                    if (n5 > 0 && (structPotentialItem = a42.getPotentialInfo(n5).get(a42.getReqLevel(equip.getItemId()) / 10)) != null && structPotentialItem.get(MapleFriendship.ALLATORIxDEMO("k@qGtb\\")) > 0) {
                        MapleCharacter mapleCharacter = a2.getPlayer();
                        a2.getPlayer().getStat();
                        mapleCharacter.changeSkillLevel_Skip(SkillFactory.getSkill(PlayerStats.getSkillByJob(structPotentialItem.get(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\"r8u=P\u0015")), a2.getPlayer().getJob())), (byte)0, (byte)0, true);
                    }
                    n4 = ++n3;
                }
            }
        }
        a2.sendPacket(MaplePacketCreator.modifyInventory(true, Collections.singletonList(new ModifyInventory(2, equip, a3)), a2.getPlayer()));
        short a42 = (short)MapleItemInformationProvider.getInstance().getReqLevel(equip.getItemId());
        int n6 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            n6 = a2.getPlayer().getStat().levelBonus;
        }
        if (GameSetConstants.CHECK_EQUIPLVL && a42 > a2.getPlayer().getLevel() + n6 && !a2.getPlayer().isGM() && a5) {
            FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("GwLk\u0004PJ{@7iyE7\u4fc5\u6521\u5c2a\u531d\u0005lSl"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a2.getPlayer().getName() + "(" + a2.getPlayer().getId() + ") <\u7b49\u7d1a: " + a2.getPlayer().getLevel() + " > \u4fee\u6539\u88dd\u5099(" + equip.getItemId() + ")\u5c01\u5305\uff0c\u812b\u9664\u88dd\u5099\u6642\u5c01\u9396\u3002 \u8a72\u88dd\u5099\u9700\u6c42\u7b49\u7d1a: " + a42);
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a2.getPlayer().getName() + " \u56e0\u70ba\u4fee\u6539\u5c01\u5305\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]  " + a2.getPlayer().getName() + "(" + a2.getPlayer().getId() + ") <\u7b49\u7d1a: " + a2.getPlayer().getLevel() + " > \u4fee\u6539\u88dd\u5099(" + equip.getItemId() + ")\u5c01\u5305\uff0c\u812b\u9664\u88dd\u5099\u6642\u5c01\u9396\u3002 \u8a72\u88dd\u5099\u9700\u6c42\u7b49\u7d1a: " + a42));
            a2.getPlayer().ban(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u4ff7\u6568\u5c18\u5354"), true, true, false);
            a2.getSession().close();
            return;
        }
        if (SpecialEquipFactory.getInstance().getSkillByEquipId(equip.getItemId()) != null) {
            int n7 = SpecialEquipFactory.getInstance().getSkillByEquipId(equip.getItemId()).getLeft();
            n2 = SpecialEquipFactory.getInstance().getSkillByEquipId(equip.getItemId()).getRight();
            n7 = SkillConstants.getSpecialSkillByJob(n7, a2.getPlayer().getJob());
            ISkill iSkill = SkillFactory.getSkill(n7);
            if (a2.getPlayer().getSkillLevel(n7) <= 0) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().RemoveKeybindingBySkillid(n7);
                mapleClient.sendPacket(MaplePacketCreator.updateSkill(n7, 0, 0, -1L));
                MapleClient mapleClient2 = a2;
                mapleClient.getPlayer().getClient().sendPacket(MaplePacketCreator.getKeymap(mapleClient2.getPlayer().getKeyLayout()));
                mapleClient2.getPlayer().dropMessage(5, "\u7531\u65bc\u5378\u9664\u6280\u80fd\u88dd\u5099,\u9375\u76e4\u6280\u80fd:" + SkillFactory.getSkillName(n7) + "\u5df2\u7d93\u79fb\u9664!");
            }
        }
        a2.getPlayer().equipChanged();
    }

    public static /* synthetic */ boolean removeFromSlot(MapleClient a2, MapleInventoryType a3, short a4, short a5, boolean a6) {
        return MapleInventoryManipulator.removeFromSlot(a2, a3, a4, a5, a6, false);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ IItem addbyId_Gachapon(MapleClient a2, int a3, short a4, boolean a5, String a6) {
        short s2;
        if (a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getNextFreeSlot() == -1 || a2.getPlayer().getInventory(MapleInventoryType.USE).getNextFreeSlot() == -1 || a2.getPlayer().getInventory(MapleInventoryType.ETC).getNextFreeSlot() == -1 || a2.getPlayer().getInventory(MapleInventoryType.SETUP).getNextFreeSlot() == -1) {
            return null;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (mapleItemInformationProvider.isPickupRestricted(a3) && a2.getPlayer().haveItem(a3, true ? 1 : 0, true, false)) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
            mapleClient.sendPacket(MaplePacketCreator.showItemUnavailable());
            return null;
        }
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a3);
        if (!mapleInventoryType.equals((Object)MapleInventoryType.EQUIP)) {
            short s3;
            MapleClient mapleClient = a2;
            short s4 = mapleItemInformationProvider.getSlotMax(mapleClient, a3);
            List<IItem> list = mapleClient.getPlayer().getInventory(mapleInventoryType).listById(a3);
            if (!GameConstants.isRechargable(a3)) {
                boolean bl;
                IItem iItem;
                block19: {
                    short s5;
                    short s6;
                    iItem = null;
                    boolean bl2 = false;
                    if (list.size() > 0) {
                        Iterator<IItem> iterator = list.iterator();
                        while (a4 > 0 && iterator.hasNext()) {
                            iItem = (Item)iterator.next();
                            s6 = iItem.getQuantity();
                            if (s6 >= s4) continue;
                            bl2 = true;
                            short s7 = (short)Math.min(s6 + a4, s4);
                            a4 = (short)(a4 - (s7 - s6));
                            iItem.setQuantity(s7);
                            a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, iItem)));
                        }
                    }
                    while (a4 > 0 && (s5 = (short)Math.min(a4, s4)) != 0) {
                        a4 = (short)(a4 - s5);
                        iItem = new Item(a3, 0, s5, 0);
                        if (a6 != null) {
                            iItem.setOwner(a6);
                        }
                        if ((s6 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), iItem)) == -1 && bl2) {
                            return iItem;
                        }
                        if (s6 == -1) {
                            return null;
                        }
                        bl2 = true;
                        a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, iItem)));
                        if (!GameConstants.isRechargable(a3) || a4 != 0) continue;
                        bl = bl2;
                        break block19;
                    }
                    bl = bl2;
                }
                if (!bl) return null;
                IItem iItem2 = iItem;
                a2.getPlayer().havePartyQuest(iItem2.getItemId());
                return iItem2;
            }
            Item item2 = new Item(a3, 0, a4, 0);
            if (a6 != null) {
                item2.setOwner(a6);
            }
            if ((s3 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), item2)) == -1) {
                return null;
            }
            MapleClient mapleClient2 = a2;
            mapleClient2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, item2)));
            mapleClient2.getPlayer().havePartyQuest(item2.getItemId());
            return item2;
        }
        if (a4 != 1) throw new InventoryException(MapleFriendship.ALLATORIxDEMO("\u007fjRqE\u007f\u000blD8HjNy_}\u000b}ZmBh\u000boBlC8EwE5DvN8ZmJv_q_a"));
        MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
        Equip equip = mapleItemInformationProvider2.randomizeStats_scroll((Equip)mapleItemInformationProvider2.getEquipById(a3), a5);
        if (GameConstants.isEquip(equip.getItemId()) && GameSetConstants.COPTITEMCHECK_STRICT) {
            a2.getPlayer().checkCopyItems(equip);
        }
        if ((s2 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), equip)) == -1) {
            return null;
        }
        if (ItemConstants.isHarvesting(equip.getItemId())) {
            a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
        }
        if (equip.hasSetOnlyId()) {
            equip.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
        }
        if (equip.getInventoryitemId() <= 0L) {
            equip.setInventoryitemId(MapleInventoryIdentifier.getInstance());
        }
        if (MapleItemInformationProvider.getInstance().isCash(equip.getItemId()) && equip.getUniqueId() < 0) {
            int n2 = MapleInventoryIdentifier.getInstance();
            equip.setUniqueId(n2);
        }
        if (a6 != null) {
            equip.setOwner(a6);
        }
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(0, equip)));
        mapleClient.getPlayer().havePartyQuest(equip.getItemId());
        return equip;
    }

    public static /* synthetic */ boolean removeFromSlot(MapleClient a2, MapleInventoryType a3, short a4, short a5, boolean a6, boolean a7) {
        if (a2.getPlayer() == null || a2.getPlayer().getInventory(a3) == null) {
            return false;
        }
        IItem iItem = a2.getPlayer().getInventory(a3).getItem(a4);
        if (iItem != null) {
            a7 = a7 && GameConstants.isRechargable(iItem.getItemId());
            a2.getPlayer().getInventory(a3).removeItem(a2.getPlayer(), a4, a5, a7);
            if (GameConstants.isHarvesting(iItem.getItemId())) {
                a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
            }
            if (iItem.getQuantity() == 0 && !a7) {
                MapleClient mapleClient = a2;
                mapleClient.sendPacket(MaplePacketCreator.modifyInventory(a6, new ModifyInventory(3, iItem), mapleClient.getPlayer()));
            } else {
                a2.sendPacket(MaplePacketCreator.modifyInventory(a6, new ModifyInventory(1, iItem), a2.getPlayer()));
            }
        }
        return true;
    }

    public static /* synthetic */ boolean addById(MapleClient a2, int a3, short a4, String a5, MaplePet a6) {
        return MapleInventoryManipulator.addById(a2, a3, a4, a5, a6, 0L);
    }

    public static /* synthetic */ void addRing(MapleCharacter a2, int a3, int a4, int a5, String a6) {
        Object object = CashItemFactory.getInstance().getModItem(a5);
        if (object == null) {
            return;
        }
        object = a2.getCashInventory().toItem((CashItem)object, a4);
        if (object == null || object.getUniqueId() != a4 || object.getUniqueId() <= 0 || object.getItemId() != a3) {
            return;
        }
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getCashInventory().addToInventory((IItem)object);
        mapleCharacter.getClient().sendPacket(MTSCSPacket.showBoughtRing((IItem)object, a5, a2.getClient().getAccID(), a6));
    }

    public static /* synthetic */ void removeAllByInventoryId(MapleClient a2, long a3, int a42) {
        if (a2.getPlayer() == null) {
            return;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        Object a42 = GameConstants.getInventoryType(a42);
        IItem iItem2 = a2.getPlayer().getInventory((MapleInventoryType)((Object)a42)).getItemByInventoryItemId(a3);
        if (iItem2 != null) {
            MapleClient mapleClient = a2;
            MapleInventoryManipulator.removeFromSlot(mapleClient, (MapleInventoryType)((Object)a42), iItem2.getPosition(), iItem2.getQuantity(), true, false);
            String string = "\u73a9\u5bb6" + mapleClient.getPlayer().getName() + " ID: " + a2.getPlayer().getId() + " (\u7b49\u7d1a" + a2.getPlayer().getLevel() + ") \u5730\u5716: " + a2.getPlayer().getMapId() + " \u5728\u73a9\u5bb6\u80cc\u5305\u4e2d\u767c\u73fe\u8907\u88fd\u9053\u5177[" + iItem2.getItemName() + "]\u5df2\u7d93\u5c07\u5176\u522a\u9664\u3002";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + string));
            FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"=v6j~Q0z:6\u8956\u88e4~\u891e\u88ac\u88c4\u50c8F\u5da3\u5233\u96357%a%"), FileoutputUtil.CurrentReadable_Time() + " " + string + " \u552f\u4e00ID: " + iItem2.getEquipOnlyId() + " \u5728\u73a9\u5bb6\u80cc\u5305\u4e2d\u767c\u73fe\u8907\u88fd\u9053\u5177\r\n");
            return;
        }
        Object object = a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItemByInventoryItemId(a3);
        if (object != null) {
            MapleClient mapleClient = a2;
            MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.EQUIPPED, object.getPosition(), object.getQuantity(), true, false);
            a42 = "\u73a9\u5bb6" + mapleClient.getPlayer().getName() + " ID: " + a2.getPlayer().getId() + " (\u7b49\u7d1a" + a2.getPlayer().getLevel() + ") \u5730\u5716: " + a2.getPlayer().getMapId() + " \u5728\u73a9\u5bb6\u7a7f\u6234\u4e2d\u767c\u73fe\u8907\u88fd\u88dd\u5099[" + object.getItemName() + "]\u5df2\u7d93\u5c07\u5176\u522a\u9664\u3002";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)a42));
            FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("tD\u007fX7cyHs\u0004\u891f\u88d67\u892c\u88e5\u88f6\u5081t\u5dea\u5201\u967c\u0005lSl"), FileoutputUtil.CurrentReadable_Time() + " " + (String)a42 + " \u88dd\u5099\u552f\u4e00ID: " + object.getEquipOnlyId() + " \u5728\u73a9\u5bb6\u7a7f\u6234\u4e2d\u767c\u73fe\u8907\u88fd\u88dd\u5099\r\n");
            return;
        }
        for (IItem iItem2 : a2.getPlayer().getStorage().getItems()) {
            if (iItem2 == null || !a2.getPlayer().getStorage().removeItemByInventoryItemId(a3)) continue;
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().getStorage().saveToDB();
            object = "\u73a9\u5bb6" + mapleClient.getPlayer().getName() + " ID: " + a2.getPlayer().getId() + " (\u7b49\u7d1a" + a2.getPlayer().getLevel() + ") \u5730\u5716: " + a2.getPlayer().getMapId() + " \u5728\u73a9\u5bb6\u5009\u5eab\u4e2d\u767c\u73fe\u8907\u88fd\u9053\u5177[" + mapleItemInformationProvider.getName(iItem2.getItemId()) + "]\u5df2\u7d93\u5c07\u5176\u522a\u9664\u3002";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)object));
            FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"=v6j~Q0z:6\u8956\u88e4~\u891e\u88ac\u88c4\u50c8F\u5da3\u5233\u96357%a%"), FileoutputUtil.CurrentReadable_Time() + " " + (String)object + " \u9053\u5177\u552f\u4e00ID: " + iItem2.getEquipOnlyId() + " \u5728\u73a9\u5bb6\u5009\u5eab\u4e2d\u767c\u73fe\u8907\u88fd\u9053\u5177\r\n");
            return;
        }
    }

    public static /* synthetic */ boolean addById(MapleClient a2, int a3, short a4, String a5, MaplePet a6, long a7) {
        return MapleInventoryManipulator.addId(a2, a3, a4, a5, a6, a7) >= 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean removeById(MapleClient a2, MapleInventoryType a3, int a4, int a5, boolean a6, boolean a7) {
        try {
            for (IItem iItem : a2.getPlayer().getInventory(a3).listById(a4)) {
                if (a5 <= iItem.getQuantity()) {
                    MapleInventoryManipulator.removeFromSlot(a2, a3, iItem.getPosition(), (short)a5, a6, a7);
                    return true;
                }
                a5 -= iItem.getQuantity();
                MapleInventoryManipulator.removeFromSlot(a2, a3, iItem.getPosition(), iItem.getQuantity(), a6, a7);
            }
        }
        catch (Exception exception) {
            System.out.println("\u89d2\u8272:" + a2.getPlayer().getName() + " \u7269\u54c1:" + a4 + " \u932f\u8aa4:" + exception);
        }
        if (a5 > 0) return false;
        return true;
    }

    public /* synthetic */ MapleInventoryManipulator() {
        MapleInventoryManipulator a2;
    }

    public static /* synthetic */ IItem addbyId_Gachapon(MapleClient a2, GashaponReward a3) {
        int n2 = Randomizer.rand(a3.getMin(), a3.getMax());
        if (n2 < 1) {
            n2 = 1;
        }
        return MapleInventoryManipulator.addbyId_Gachapon(a2, a3.getItemId(), (short)n2, false, null);
    }

    public static /* synthetic */ boolean addFromDrop(MapleClient a2, IItem a3, boolean a4) {
        return MapleInventoryManipulator.addFromDrop(a2, a3, a4, false, false);
    }

    public static /* synthetic */ boolean checkSpace(MapleClient a2, int a322, int a4, String a5) {
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (mapleItemInformationProvider.isPickupRestricted(a322) && a2.getPlayer().haveItem(a322, true ? 1 : 0, true, false)) {
            a2.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        if (a4 <= 0 && !GameConstants.isRechargable(a322)) {
            return false;
        }
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a322);
        if (a2 == null || a2.getPlayer() == null || a2.getPlayer().getInventory(mapleInventoryType) == null) {
            return false;
        }
        if (!mapleInventoryType.equals((Object)MapleInventoryType.EQUIP)) {
            MapleClient mapleClient;
            int a322;
            short s2;
            MapleClient mapleClient2 = a2;
            short s3 = mapleItemInformationProvider.getSlotMax(mapleClient2, a322);
            Object object = mapleClient2.getPlayer().getInventory(mapleInventoryType).listById(a322);
            if (!GameConstants.isRechargable(a322) && object.size() > 0) {
                Iterator<IItem> a322 = object.iterator();
                while (a322.hasNext()) {
                    object = a322.next();
                    short s4 = object.getQuantity();
                    if (s4 < s3 && a5 != null && a5.equals(object.getOwner())) {
                        short s5 = (short)Math.min(s4 + a4, s3);
                        a4 -= s5 - s4;
                    }
                    if (a4 > 0) continue;
                    s2 = s3;
                    break;
                }
            } else {
                s2 = s3;
            }
            if (s2 > 0) {
                a322 = (int)Math.ceil((double)a4 / (double)s3);
                mapleClient = a2;
            } else {
                a322 = 1;
                mapleClient = a2;
            }
            return !mapleClient.getPlayer().getInventory(mapleInventoryType).isFull(a322 - 1);
        }
        return !a2.getPlayer().getInventory(mapleInventoryType).isFull();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ boolean addFromDrop(MapleClient a, IItem a, boolean a, boolean a, boolean a) {
        block26: {
            block24: {
                block25: {
                    block22: {
                        block23: {
                            var5_5 = MapleItemInformationProvider.getInstance();
                            if (var5_5.isPickupRestricted(a.getItemId()) && a.getPlayer().haveItem(a.getItemId(), true ? 1 : 0, true, false)) {
                                v0 = a;
                                v0.sendPacket(MaplePacketCreator.getInventoryFull());
                                v0.sendPacket(MaplePacketCreator.showItemUnavailable());
                                return false;
                            }
                            var6_7 = a.getPlayer().itemQuantity(a.getItemId());
                            v1 = a;
                            var7_8 = v1.getQuantity();
                            var8_9 = GameConstants.getInventoryType(v1.getItemId());
                            if ((var8_9 == MapleInventoryType.EQUIP || var8_9 == MapleInventoryType.EQUIPPED) && (ItemCustomFlag.\u5c08\u5c6c\u9053\u5177.check(a.getCustomFlag()) || MapleItemInformationProvider.getInstance().isOnly(a.getItemId())) && a.getPlayer().haveItem(a.getItemId())) {
                                v2 = a;
                                v2.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u6083\u5dea\u64ea\u6711\u6b4f\u5c10\u5c47\u904b\u515c\u301a"));
                                v2.sendPacket(MaplePacketCreator.enableActions());
                                return false;
                            }
                            if (MapleItemInformationProvider.getInstance().isCash(a.getItemId()) && a.getUniqueId() < 0) {
                                var9_10 = MapleInventoryIdentifier.getInstance();
                                a.setUniqueId(var9_10);
                            }
                            if (a.getInventoryitemId() <= 0L) {
                                a.setInventoryitemId(MapleInventoryIdentifier.getInstance());
                            }
                            if (var8_9.equals((Object)MapleInventoryType.EQUIP)) break block22;
                            v3 = a;
                            var9_10 = var5_5.getSlotMax(v3, a.getItemId());
                            var5_5 = v3.getPlayer().getInventory(var8_9).listById(a.getItemId());
                            if (GameConstants.isRechargable(a.getItemId())) break block23;
                            if (var7_8 <= 0) {
                                v4 = a;
                                v4.sendPacket(MaplePacketCreator.getInventoryFull());
                                v4.sendPacket(MaplePacketCreator.showItemUnavailable());
                                return false;
                            }
                            if (var5_5.size() <= 0) break block24;
                            var10_11 = var5_5.iterator();
                            break block25;
                        }
                        v5 = var10_11 = new Item(a.getItemId(), 0, var7_8, a.getFlag());
                        v6 = a;
                        var10_11.setExpiration(v6.getExpiration());
                        v5.setOwner(v6.getOwner());
                        v5.setPet(a.getPet());
                        var11_14 = a.getPlayer().getInventory(var8_9).addItem(a.getPlayer(), (IItem)var10_11);
                        if (var11_14 == -1) {
                            v7 = a;
                            v7.sendPacket(MaplePacketCreator.getInventoryFull());
                            v7.sendPacket(MaplePacketCreator.getShowInventoryFull());
                            return false;
                        }
                        v8 = a;
                        v8.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory((int)false, (IItem)var10_11)));
                        v8.sendPacket(MaplePacketCreator.enableActions());
                        break block26;
                    }
                    if (var7_8 != 1) throw new RuntimeException(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"M#`8w69%vqz#|0m494h$p!9&p%qqw>w|v?|qh$x?m8m("));
                    if (a.hasSetOnlyId()) {
                        a.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
                    }
                    if (a) {
                        a = MapleInventoryManipulator.ALLATORIxDEMO(a, a.getPlayer());
                    }
                    if (GameConstants.isEquip(a.getItemId()) && GameSetConstants.COPTITEMCHECK_STRICT) {
                        a.getPlayer().checkCopyItems(a);
                    }
                    v9 = a.getPlayer().getInventory(var8_9).addItem(a.getPlayer(), a);
                    var9_10 = v9;
                    if (v9 == -1) {
                        v10 = a;
                        v10.sendPacket(MaplePacketCreator.getInventoryFull());
                        v10.sendPacket(MaplePacketCreator.getShowInventoryFull());
                        return false;
                    }
                    v11 = a;
                    if (a) {
                        v11.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory((int)false, a)));
                    } else {
                        v11.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(0, a)));
                    }
                    break block26;
                }
                while (var7_8 > 0 && var10_11.hasNext()) {
                    var11_13 = (Item)var10_11.next();
                    var12_15 = var11_13.getQuantity();
                    if (var12_15 >= var9_10 || !a.getOwner().equals(var11_13.getOwner()) || a.getExpiration() != var11_13.getExpiration()) continue;
                    var5_6 = (short)Math.min(var12_15 + var7_8, var9_10);
                    var7_8 = (short)(var7_8 - (var5_6 - var12_15));
                    var11_13.setQuantity(var5_6);
                    v12 = a;
                    if (a) {
                        v12.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, var11_13)));
                        continue;
                    }
                    v12.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(1, var11_13)));
                }
            }
            v13 = var7_8;
            while (v13 > 0) {
                var10_12 = (short)Math.min(var7_8, var9_10);
                var7_8 = (short)(var7_8 - var10_12);
                v14 = var11_13 = new Item(a.getItemId(), 0, var10_12, a.getFlag());
                v15 = a;
                var11_13.setExpiration(v15.getExpiration());
                v14.setOwner(v15.getOwner());
                v14.setPet(a.getPet());
                var12_15 = a.getPlayer().getInventory(var8_9).addItem(a.getPlayer(), var11_13);
                if (var12_15 == -1) {
                    v16 = a;
                    v16.sendPacket(MaplePacketCreator.getInventoryFull());
                    v16.sendPacket(MaplePacketCreator.getShowInventoryFull());
                    a.setQuantity((short)(var7_8 + var10_12));
                    return false;
                }
                a.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(0, var11_13)));
                v13 = var7_8;
            }
        }
        if (var6_7 != 0) ** GOTO lbl-1000
        switch (a.getItemId()) {
            case 4000516: {
                v17 = a;
                v18 = v17;
                v17.getPlayer().dropMessage(5, MapleFriendship.ALLATORIxDEMO("\u4f78\u5dd9\u7d8b\u7359\u5f8f\u4ead\u4e18\u50208\u99b2\u7208\uff278\u53c4\u4efd\u521b\u4e15\u5937\u57d6\u5c20\u6266\u9fa6\u5c69\u5bd1\u5e33\u721d\u5c15\u8a5a\u301a"));
                break;
            }
            case 4031875: {
                v19 = a;
                v18 = v19;
                v19.getPlayer().dropMessage(5, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"@>lqq0o496x8w4}qxqI>n5|#9\u001a|65q`>lqz0wq~8o49%q8jqp?9%vqX#x<p09>\u007fqQ4w4j(j\u007f"));
                break;
            }
            case 4001246: {
                v20 = a;
                v18 = v20;
                v20.getPlayer().dropMessage(5, MapleFriendship.ALLATORIxDEMO("\u4f4b\u5dea\u7db8\u736a\u5fbc\u4e9e\u4e2b\u5013\u000b\u6eb3\u66bd\u9665\u5162\uff14\u000b\u53f7\u4ece\u5228\u6978\u6a21\u5c5a\u4e00\u5c20\u6266\u9614\u7c6b\u52f9\u5c15\u8a5a\u301a"));
                break;
            }
            case 4001473: {
                a.getPlayer().dropMessage(5, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\bv$99x'|q~0p?|5909\u0005k4|q]4z>k0m8v?5q`>lqz0wq~8o49%q8jqp?9%vqN9p%|qZ9k8j%t0jqQ8u=9%q#v$~99\u0011s>`2|\u007f"));
            }
            default: lbl-1000:
            // 2 sources

            {
                v18 = a;
            }
        }
        v18.getPlayer().havePartyQuest(a.getItemId());
        if (a == false) return true;
        a.sendPacket(MaplePacketCreator.getShowItemGain(a.getItemId(), a.getQuantity()));
        return true;
    }

    public static /* synthetic */ boolean addById(MapleClient a2, int a3, short a4, String a5) {
        return MapleInventoryManipulator.addById(a2, a3, a4, a5, null, 0L);
    }

    public static /* synthetic */ int getUniqueId(int a2, MaplePet a3) {
        int n2 = -1;
        if (GameConstants.isPet(a2)) {
            if (a3 != null) {
                n2 = a3.getUniqueId();
                return n2;
            }
            n2 = MapleInventoryIdentifier.getInstance();
            return n2;
        }
        if (GameConstants.getInventoryType(a2) == MapleInventoryType.CASH || MapleItemInformationProvider.getInstance().isCash(a2) || ItemConstants.isExpChair(a2)) {
            n2 = MapleInventoryIdentifier.getInstance();
        }
        return n2;
    }

    public static /* synthetic */ boolean drop(MapleClient a2, MapleInventoryType a3, short a4, short a5) {
        return MapleInventoryManipulator.drop(a2, a3, a4, a5, false);
    }

    public static /* synthetic */ boolean addById(MapleClient a2, int a3, short a4) {
        return MapleInventoryManipulator.addById(a2, a3, a4, null, null, 0L);
    }

    private static /* synthetic */ boolean H(int a2) {
        return a2 / 10000 == 105;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void handleSpecialItem(final MapleClient a2, final IItem a3) {
        switch (a3.getItemId()) {
            case 3994192: {
                int n2 = 1;
                Timer.BuffTimer buffTimer = Timer.BuffTimer.getInstance();
                buffTimer.schedule(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        1 a22;
                        if (a22.a2.getLoginState() == 2) {
                            1 v0 = a22;
                            MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(v0.a3.getItemId());
                            MapleInventoryManipulator.removeById(v0.a2, mapleInventoryType, 3994192, 1, false, false);
                            Item item2 = new Item(3994193, 0, 1, 0);
                            if (v0.a2.getPlayer().getInventory(mapleInventoryType).addItem(a22.a2.getPlayer(), item2) == -1) {
                                1 v1 = a22;
                                v1.a2.sendPacket(MaplePacketCreator.getInventoryFull());
                                v1.a2.sendPacket(MaplePacketCreator.getShowInventoryFull());
                                return;
                            }
                            a22.a2.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(0, item2)));
                        }
                    }
                    {
                        1 a22;
                    }
                }, n2 * 60 * 1000);
                return;
            }
        }
    }

    public static /* synthetic */ byte addId(MapleClient a2, int a3, short a4, String a5, MaplePet a6, long a7) {
        Map<Integer, Integer> map;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (mapleItemInformationProvider.isPickupRestricted(a3) && a2.getPlayer().haveItem(a3, true ? 1 : 0, true, false)) {
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
            mapleClient.sendPacket(MaplePacketCreator.showItemUnavailable());
            return -1;
        }
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a3);
        int n2 = MapleInventoryManipulator.getUniqueId(a3, a6);
        short s2 = -1;
        if (!mapleInventoryType.equals((Object)MapleInventoryType.EQUIP)) {
            MapleClient mapleClient = a2;
            short s3 = mapleItemInformationProvider.getSlotMax(mapleClient, a3);
            List<IItem> list = mapleClient.getPlayer().getInventory(mapleInventoryType).listById(a3);
            if (!GameConstants.isRechargable(a3)) {
                Object object;
                if (list.size() > 0) {
                    object = list.iterator();
                    while (a4 > 0 && object.hasNext()) {
                        Item item2 = (Item)object.next();
                        short s4 = item2.getQuantity();
                        if (s4 >= s3 || !item2.getOwner().equals(a5) && a5 != null || item2.getExpiration() != -1L && item2.getExpiration() <= 4000000000000L) continue;
                        short s5 = (short)Math.min(s4 + a4, s3);
                        a4 = (short)(a4 - (s5 - s4));
                        MapleClient mapleClient2 = a2;
                        item2.setQuantity(s5);
                        mapleClient2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, item2)));
                        if (!mapleClient2.isMonitored()) continue;
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u80cc\u5305\u7269\u54c1.txt", a2.getPlayer().getChrInfo("\u7269\u54c1\uff1a" + item2.getItemName() + " \u539f\u6578\u91cf:" + s4 + " \u66f4\u8b8a\u5f8c\u6578\u91cf:" + s5));
                    }
                }
                while (a4 > 0) {
                    short s6 = (short)Math.min(a4, s3);
                    if (s6 != 0) {
                        a4 = (short)(a4 - s6);
                        object = new Item(a3, 0, s6, 0, n2);
                        short s7 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), (IItem)object);
                        s2 = s7;
                        if (s7 == -1) {
                            MapleClient mapleClient3 = a2;
                            mapleClient3.sendPacket(MaplePacketCreator.getInventoryFull());
                            mapleClient3.sendPacket(MaplePacketCreator.getShowInventoryFull());
                            return -1;
                        }
                        if (a5 != null) {
                            ((Item)object).setOwner(a5);
                        }
                        if (a7 > 0L) {
                            ((Item)object).setExpiration(System.currentTimeMillis() + a7 * 24L * 60L * 60L * 1000L);
                        }
                        if (a6 != null) {
                            MaplePet maplePet = a6;
                            ((Item)object).setPet(maplePet);
                            maplePet.setInventoryPosition(s2);
                            a2.getPlayer().addPet(a6);
                        }
                        MapleInventoryManipulator.handleSpecialItem(a2, (IItem)object);
                        a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, (IItem)object)));
                        if (!GameConstants.isRechargable(a3) || a4 != 0) continue;
                        break;
                    }
                    MapleClient mapleClient4 = a2;
                    mapleClient4.getPlayer().havePartyQuest(a3);
                    mapleClient4.sendPacket(MaplePacketCreator.enableActions());
                    return (byte)s2;
                }
            } else {
                Item item3 = new Item(a3, 0, a4, 0, n2);
                MapleClient mapleClient5 = a2;
                s2 = a2.getPlayer().getInventory(mapleInventoryType).addItem(mapleClient5.getPlayer(), item3);
                if (mapleClient5.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u80cc\u5305\u7269\u54c1.txt", a2.getPlayer().getChrInfo("\u7269\u54c1\uff1a" + item3.getItemName() + " \u65b0\u589e\u6578\u91cf:" + a4));
                }
                if (s2 == -1) {
                    MapleClient mapleClient6 = a2;
                    mapleClient6.sendPacket(MaplePacketCreator.getInventoryFull());
                    mapleClient6.sendPacket(MaplePacketCreator.getShowInventoryFull());
                    return -1;
                }
                if (a7 > 0L) {
                    item3.setExpiration(System.currentTimeMillis() + a7 * 24L * 60L * 60L * 1000L);
                }
                MapleClient mapleClient7 = a2;
                mapleClient7.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, item3)));
                mapleClient7.sendPacket(MaplePacketCreator.enableActions());
            }
        } else if (a4 == 1) {
            IItem iItem = mapleItemInformationProvider.getEquipById(a3);
            if (GameConstants.isEquip(iItem.getItemId()) && GameSetConstants.COPTITEMCHECK_STRICT) {
                a2.getPlayer().checkCopyItems(iItem);
            }
            if (ItemConstants.isHarvesting(iItem.getItemId())) {
                a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
            }
            if (a5 != null) {
                iItem.setOwner(a5);
            }
            iItem.setUniqueId(n2);
            if (a7 > 0L) {
                iItem.setExpiration(System.currentTimeMillis() + a7 * 24L * 60L * 60L * 1000L);
            }
            if (iItem.hasSetOnlyId()) {
                iItem.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
            }
            if (iItem.getInventoryitemId() <= 0L) {
                iItem.setInventoryitemId(MapleInventoryIdentifier.getInstance());
            }
            if (MapleItemInformationProvider.getInstance().isCash(iItem.getItemId()) && iItem.getUniqueId() < 0) {
                int n3 = MapleInventoryIdentifier.getInstance();
                iItem.setUniqueId(n3);
            }
            MapleClient mapleClient = a2;
            s2 = mapleClient.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), iItem);
            if (mapleClient.isMonitored()) {
                FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u80cc\u5305\u7269\u54c1.txt", a2.getPlayer().getChrInfo("\u7269\u54c1\uff1a" + iItem.getItemName() + " \u65b0\u589e\u6578\u91cf:" + a4));
            }
            if (s2 == -1) {
                MapleClient mapleClient8 = a2;
                mapleClient8.sendPacket(MaplePacketCreator.getInventoryFull());
                mapleClient8.sendPacket(MaplePacketCreator.getShowInventoryFull());
                return -1;
            }
            a2.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, iItem)));
        } else {
            throw new InventoryException(MapleFriendship.ALLATORIxDEMO("\u007fjRqE\u007f\u000blD8HjNy_}\u000b}ZmBh\u000boBlC8EwE5DvN8ZmJv_q_a"));
        }
        if ((map = CheckItemFactory.getItems()).containsKey(a3) && a4 > map.get(a3)) {
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a2.getPlayer().getName() + "\u7b49\u7d1a:" + a2.getPlayer().getLevel() + "(\u7de8\u865f: " + a2.getPlayer().getId() + ")\u64bf\u53d6\u7269\u54c1" + a4 + "\u5f35" + MapleItemInformationProvider.getInstance().getName(a3) + "\uff0c\u5341\u5206\u53ef\u7591\u3002"));
            FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"=v6j~Q0z:6\u7521\u5e21\u6902\u5e7a\u9002\u516e\u5024\u6e35~\u64a6\u5387\u7270\u5490\u6abb\u6e7d7%a%"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a2.getPlayer().getName() + "\u7b49\u7d1a:" + a2.getPlayer().getLevel() + " (\u7de8\u865f: " + a2.getPlayer().getId() + ")\u64bf\u8d77\u7269\u54c1" + a4 + "\u5f35" + MapleItemInformationProvider.getInstance().getName(a3));
            if (GameSetConstants.AUTOMONITOR && !a2.isMonitored()) {
                a2.setMonitored(true);
            }
        }
        a2.getPlayer().havePartyQuest(a3);
        return (byte)s2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ boolean drop(MapleClient a, MapleInventoryType a, short a, short a, boolean a) {
        block35: {
            var5_7 = MapleItemInformationProvider.getInstance();
            if (World.isShutDown) {
                v0 = a;
                v0.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u76f6\u5266\u7139\u6cfe\u4e07\u8416\u7271\u54ea\u301a"));
                v0.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (a < 0) {
                a = MapleInventoryType.EQUIPPED;
            }
            if (a.getPlayer() == null) {
                return false;
            }
            var6_8 = a.getPlayer().getInventory(a).getItem(a);
            if (var6_8 == null || !a && GameConstants.isPet(var6_8.getItemId())) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (MapConstants.isDropProhibitedMap(a.getPlayer().getMapId())) {
                v1 = a;
                v1.getPlayer().dropMessage(1, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u6b7d\u8604\u7138\u6c84\u4e06\u6895\u7270\u5490"));
                v1.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (a.getPlayer().isPlayer() && ItemConstants.isOverPoweredEquip(a, a)) {
                v2 = a;
                v2.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u6734\u88f6\u5081\u80d6\u5283\u9065\u65a4\u5f1c\u593f\u00078\u8ae0\u8077\u7e40\u7bb9\u742d\u54f9"));
                v2.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (MapleItemInformationProvider.getInstance().isCash(var6_8.getItemId()) && !a) {
                v3 = a;
                v3.getPlayer().dropMessage(1, \u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u9048\u981c\u9002\u516e\u7170\u6ccc\u6205\u6390p"));
                v3.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (ItemCustomFlag.\u7121\u6cd5\u4e1f\u68c4.check(var6_8.getCustomFlag())) {
                v4 = a;
                v4.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u6b4f\u904b\u515c\u7139\u6cfe\u4e07\u68ef\u301a"));
                v4.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            var7_9 = var6_8.getFlag();
            if (ItemFlag.LOCK.check(var7_9) && !a) {
                var8_10 = "[\u5f37\u5236\u4e1f\u51fa\u4e0a\u9396\u9053\u5177] \u89d2\u8272:" + a.getPlayer().getName() + "(" + a.getPlayer().getId() + ") \u5e33\u865f: " + a.getAccountName() + " \u9053\u5177:" + var6_8.getItemName() + "(" + var6_8.getItemId() + ")";
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice(var8_10));
                FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"=v6j~Q0z:6\u4fbf\u6520\u5c50\u531c~\u5f2e\u5267\u4e06\u51ab\u4e13\u93c7\u904a\u51267%a%"), FileoutputUtil.CurrentReadable_Time() + " IP:" + a.getSessionIPAddress() + " " + var8_10 + "\r\n");
                a.getPlayer().getCheatTracker().registerOffense(CheatingOffense.\u4fee\u6539\u5c01\u5305_\u4e1f\u51fa\u4e0a\u9396\u9053\u5177, "\u9053\u5177:" + var6_8.getItemName() + "(" + var6_8.getItemId() + ")");
                a.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (a.getPlayer().isAdmin()) {
                a.getPlayer().dropMessage(6, "[\u4e1f\u68c4\u7269\u54c1] \u539f\u59cb\u4f4d\u7f6e:" + a + " \u7a2e\u985e:" + a + " \u7269\u54c1ID:" + var6_8.getItemId() + " \u7269\u54c1\u540d\u7a31:" + MapleItemInformationProvider.getInstance().getName(var6_8.getItemId()));
            }
            if (a > var6_8.getQuantity() && !GameConstants.isRechargable(var6_8.getItemId())) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (MapleItemInformationProvider.getInstance().isCash(var6_8.getItemId()) && !a) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (a != 1 && a == MapleInventoryType.EQUIP) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            if (var6_8.getRing() != null) {
                v5 = a;
                v5.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u53d3\u60ee4\u6130\u60dd\u9875\u620a\u632c\u7139\u6cfe\u4e07\u68ef9"));
                v5.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
            var8_11 = new Point(a.getPlayer().getPosition());
            a.getPlayer().getCheatTracker().checkDrop();
            if (a >= var6_8.getQuantity() || GameConstants.isRechargable(var6_8.getItemId())) break block35;
            v6 = var6_8;
            a = v6.copy();
            a.setQuantity(a);
            v6.setQuantity((short)(v6.getQuantity() - a));
            v7 = a;
            v7.sendPacket(MaplePacketCreator.modifyInventory(true, Collections.singletonList(new ModifyInventory((int)true, var6_8)), v7.getPlayer()));
            if (var5_7.isDropRestricted(a.getItemId()) || var5_7.isAccountShared(a.getItemId()) || ItemConstants.canTradeByCut(var7_9)) {
                if (ItemFlag.KARMA_EQ.check(var7_9)) {
                    a.setFlag(var7_9 - ItemFlag.KARMA_EQ.getValue());
                    a.getPlayer().getMap().spawnItemDrop(a.getPlayer(), a.getPlayer(), a, var8_11, true, true);
                } else if (ItemFlag.KARMA_USE.check(var7_9)) {
                    a.setFlag(var7_9 - ItemFlag.KARMA_USE.getValue());
                    a.getPlayer().getMap().spawnItemDrop(a.getPlayer(), a.getPlayer(), a, var8_11, true, true);
                } else {
                    a.getPlayer().getMap().disappearingItemDrop(a.getPlayer(), a.getPlayer(), a, var8_11);
                }
            } else if (GameConstants.isPet(var6_8.getItemId()) || ItemFlag.UNTRADEABLE.check(var7_9)) {
                a.getPlayer().getMap().disappearingItemDrop(a.getPlayer(), a.getPlayer(), a, var8_11);
            } else {
                a.getPlayer().getMap().spawnItemDrop(a.getPlayer(), a.getPlayer(), a, var8_11, true, true);
            }
            ** GOTO lbl112
        }
        a.getPlayer().getInventory(a).removeSlot(a.getPlayer(), a);
        a.sendPacket(MaplePacketCreator.modifyInventory(true, Collections.singletonList(new ModifyInventory(3, var6_8)), a.getPlayer()));
        if (a < 0) {
            a.getPlayer().equipChanged();
        }
        if (var5_7.isDropRestricted(var6_8.getItemId()) || var5_7.isAccountShared(var6_8.getItemId()) || ItemConstants.canTradeByCut(var7_9)) {
            if (ItemFlag.KARMA_EQ.check(var7_9)) {
                v8 = var6_8;
                v9 = v8;
                v8.setFlag(var7_9 - ItemFlag.KARMA_EQ.getValue());
                a.getPlayer().getMap().spawnItemDrop(a.getPlayer(), a.getPlayer(), var6_8, var8_11, true, true);
            } else if (ItemFlag.KARMA_USE.check(var7_9)) {
                v10 = var6_8;
                v9 = v10;
                v10.setFlag(var7_9 - ItemFlag.KARMA_USE.getValue());
                a.getPlayer().getMap().spawnItemDrop(a.getPlayer(), a.getPlayer(), var6_8, var8_11, true, true);
            } else {
                a.getPlayer().getMap().disappearingItemDrop(a.getPlayer(), a.getPlayer(), var6_8, var8_11);
                v9 = var6_8;
            }
        } else if (GameConstants.isPet(var6_8.getItemId()) || ItemFlag.UNTRADEABLE.check(var7_9)) {
            a.getPlayer().getMap().disappearingItemDrop(a.getPlayer(), a.getPlayer(), var6_8, var8_11);
            v9 = var6_8;
        } else {
            a.getPlayer().getMap().spawnItemDrop(a.getPlayer(), a.getPlayer(), var6_8, var8_11, true, true);
lbl112:
            // 6 sources

            v9 = var6_8;
        }
        if (ItemConstants.isHarvesting(v9.getItemId())) {
            a.getPlayer().getStat().handleProfessionTool(a.getPlayer());
        }
        if ((a = CheckItemFactory.getItems()).containsKey(var6_8.getItemId()) && a > a.get(var6_8.getItemId())) {
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a.getPlayer().getName() + "\u7b49\u7d1a:" + a.getPlayer().getLevel() + "(\u7de8\u865f: " + a.getPlayer().getId() + ")\u4e1f\u68c4\u7269\u54c1" + a + "\u5f35" + MapleItemInformationProvider.getInstance().getName(var6_8.getItemId()) + "\uff0c\u5341\u5206\u53ef\u7591\u3002"));
            FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"=v6j~Q0z:6\u7521\u5e21\u6902\u5e7a\u9002\u516e\u5024\u6e35~\u4e06\u6895\u7270\u5490\u6abb\u6e7d7%a%"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a.getPlayer().getName() + "\u7b49\u7d1a:" + a.getPlayer().getLevel() + " (\u7de8\u865f: " + a.getPlayer().getId() + ")\u4e1f\u68c4\u7269\u54c1" + a + "\u5f35" + MapleItemInformationProvider.getInstance().getName(var6_8.getItemId()));
            if (GameSetConstants.AUTOMONITOR && !a.isMonitored() && !a.isGm()) {
                a.setMonitored(true);
            }
        }
        if (a.isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a.getPlayer().getName() + "/\u4e1f\u68c4\u7269\u54c1.txt", a.getPlayer().getChrInfo("\u4e1f\u68c4\u7269\u54c1 " + a + " \u500b " + MapleItemInformationProvider.getInstance().getName(var6_8.getItemId())));
        }
        FileoutputUtil.logToFile("logs/\u73a9\u5bb6\u64cd\u4f5c/" + a.getPlayer().getName() + "/\u4e1f\u68c4\u7269\u54c1.txt", a.getPlayer().getChrInfo("\u4e1f\u68c4\u7269\u54c1 " + a + " \u500b " + var6_8.getItemName() + " \u5730\u5716:" + a.getPlayer().getMapId()));
        return true;
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(int a2) {
        return a2 >= 1302000 && a2 < 1492024;
    }

    public static /* synthetic */ void removeAllByEquipByInventoryId(MapleClient a2, long a3) {
        IItem iItem;
        if (a2.getPlayer() == null) {
            return;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        Object object2 = a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItemByInventoryItemId(a3);
        if (object2 != null) {
            MapleClient mapleClient = a2;
            MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.EQUIP, object2.getPosition(), object2.getQuantity(), true, false);
            String object3 = "\u73a9\u5bb6" + mapleClient.getPlayer().getName() + " ID: " + a2.getPlayer().getId() + " (\u7b49\u7d1a" + a2.getPlayer().getLevel() + ") \u5730\u5716: " + a2.getPlayer().getMapId() + " \u5728\u73a9\u5bb6\u80cc\u5305\u4e2d\u767c\u73fe\u8907\u88fd\u88dd\u5099[" + mapleItemInformationProvider.getName(object2.getItemId()) + "]\u5df2\u7d93\u5c07\u5176\u522a\u9664\u3002";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + object3));
            FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("tD\u007fX7cyHs\u0004\u891f\u88d67\u892c\u88e5\u88f6\u5081t\u5dea\u5201\u967c\u0005lSl"), FileoutputUtil.CurrentReadable_Time() + " " + object3 + " \u9053\u5177\u552f\u4e00ID: " + object2.getEquipOnlyId() + "\r\n");
        }
        if ((iItem = a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItemByInventoryItemId(a3)) != null) {
            MapleClient mapleClient = a2;
            MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.EQUIPPED, iItem.getPosition(), iItem.getQuantity(), true, false);
            object2 = "\u73a9\u5bb6" + mapleClient.getPlayer().getName() + " ID: " + a2.getPlayer().getId() + " (\u7b49\u7d1a" + a2.getPlayer().getLevel() + ") \u5730\u5716: " + a2.getPlayer().getMapId() + " \u5728\u73a9\u5bb6\u7a7f\u6234\u4e2d\u767c\u73fe\u8907\u88fd\u88dd\u5099[" + mapleItemInformationProvider.getName(iItem.getItemId()) + "]\u5df2\u7d93\u5c07\u5176\u522a\u9664\u3002";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + (String)object2));
            FileoutputUtil.logToFile(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"=v6j~Q0z:6\u8956\u88e4~\u891e\u88ac\u88c4\u50c8F\u5da3\u5233\u96357%a%"), FileoutputUtil.CurrentReadable_Time() + " " + (String)object2 + " \u9053\u5177\u552f\u4e00ID: " + iItem.getEquipOnlyId() + "\r\n");
        }
        for (IItem iItem2 : a2.getPlayer().getStorage().getItems()) {
            if (iItem2 == null || !a2.getPlayer().getStorage().removeItemByInventoryItemId(a3)) continue;
            String string = "\u73a9\u5bb6" + a2.getPlayer().getName() + " ID: " + a2.getPlayer().getId() + " (\u7b49\u7d1a" + a2.getPlayer().getLevel() + ") \u5730\u5716: " + a2.getPlayer().getMapId() + " \u5728\u73a9\u5bb6\u5009\u5eab\u4e2d\u767c\u73fe\u8907\u88fd\u88dd\u5099[" + mapleItemInformationProvider.getName(iItem2.getItemId()) + "]\u5df2\u7d93\u5c07\u5176\u522a\u9664\u3002";
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + string));
            FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("tD\u007fX7cyHs\u0004\u891f\u88d67\u892c\u88e5\u88f6\u5081t\u5dea\u5201\u967c\u0005lSl"), FileoutputUtil.CurrentReadable_Time() + " " + string + " \u9053\u5177\u552f\u4e00ID: " + iItem2.getEquipOnlyId() + "\r\n");
        }
    }

    public static /* synthetic */ short addbyItem(MapleClient a2, IItem a3, boolean a4) {
        int n2;
        if (GameConstants.isEquip(a3.getItemId()) && GameSetConstants.COPTITEMCHECK_STRICT) {
            a2.getPlayer().checkCopyItems(a3);
        }
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a3.getItemId());
        short s2 = a2.getPlayer().getInventory(mapleInventoryType).addItem(a2.getPlayer(), a3);
        if (s2 == -1) {
            if (!a4) {
                MapleClient mapleClient = a2;
                mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
                mapleClient.sendPacket(MaplePacketCreator.getShowInventoryFull());
            }
            return s2;
        }
        if (MapleItemInformationProvider.getInstance().isCash(a3.getItemId()) && a3.getUniqueId() < 0) {
            n2 = MapleInventoryIdentifier.getInstance();
            a3.setUniqueId(n2);
        }
        if (a3.hasSetOnlyId()) {
            a3.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
        }
        if (a3.getInventoryitemId() <= 0L) {
            a3.setInventoryitemId(MapleInventoryIdentifier.getInstance());
        }
        if (MapleItemInformationProvider.getInstance().isCash(a3.getItemId()) && a3.getUniqueId() < 0) {
            n2 = MapleInventoryIdentifier.getInstance();
            a3.setUniqueId(n2);
        }
        if (ItemConstants.isHarvesting(a3.getItemId())) {
            a2.getPlayer().getStat().handleProfessionTool(a2.getPlayer());
        }
        if (!a4) {
            a2.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory(0, a3)));
        }
        a2.getPlayer().havePartyQuest(a3.getItemId());
        return s2;
    }
}

