/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleJob;
import client.MaplePartTimeJob;
import client.MapleStat;
import client.PlayerStats;
import client.SkillFactory;
import client.SkillMacro;
import client.anticheat.CheatingOffense;
import client.inventory.ChairDataFactory;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.ModifyInventory;
import client.messages.commands.player.eventSystem.SellSystem;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.MobConstants;
import constants.SkillConstants;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.channel.handler.AttackInfo;
import handling.channel.handler.AttackType;
import handling.channel.handler.DamageParse;
import handling.channel.handler.InventoryHandler;
import handling.channel.handler.MovementParse;
import handling.opcodes.MapleBuffStat;
import handling.world.MapleMessenger;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.SkillCollector;
import handling.world.World;
import java.awt.Point;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import server.Extend.SpecialEquipFactory;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MaplePortal;
import server.MapleShopFactory;
import server.MapleStatEffect;
import server.Randomizer;
import server.Timer;
import server.events.MapleSnowball;
import server.game.ClickGame;
import server.life.AbstractLoadedMapleLife;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterPet;
import server.life.MobAttackInfoFactory;
import server.life.MobSkill;
import server.life.MobSkillFactory;
import server.maps.AbstractMapleMapObject;
import server.maps.FieldLimitType;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.movement.AbstractLifeMovement;
import server.movement.LifeMovementFragment;
import server.quest.MapleQuest;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.Triple;
import tools.damageSkin.AttackFont;
import tools.data.LittleEndianAccessor;
import tools.packet.JobPacket;
import tools.packet.LoginPacket;
import tools.packet.MTSCSPacket;
import tools.packet.MobPacket;
import tools.packet.UIPacket;

public class PlayerHandler {
    public static final /* synthetic */ void SkillEffect(LittleEndianAccessor a2, MapleCharacter a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        byte by = littleEndianAccessor.readByte();
        byte by2 = littleEndianAccessor.readByte();
        byte by3 = littleEndianAccessor.readByte();
        byte by4 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            by4 = a2.readByte();
        }
        ISkill iSkill = SkillFactory.getSkill(n2);
        if (a3 == null) {
            return;
        }
        int n3 = a3.getSkillLevel(iSkill);
        if (n3 > 0 && n3 == by && (n2 == 33101005 || iSkill.isChargeSkill())) {
            a3.setKeyDownSkill_Time(System.currentTimeMillis());
            if (GameSetConstants.MAPLE_VERSION < 151 && n2 == 33101005) {
                MapleCharacter mapleCharacter = a3;
                mapleCharacter.clearLinkMid();
                mapleCharacter.setLinkMid(a2.readInt(), 0);
            }
            MapleCharacter mapleCharacter = a3;
            a3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.skillEffect(mapleCharacter, n2, by, by2, by3, by4), false);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void ChangeKeymap(LittleEndianAccessor a2, MapleCharacter a3) {
        if (a3 == null) return;
        if (a2.available() <= 8L) {
            if (a2.available() != 8L) return;
            LittleEndianAccessor littleEndianAccessor = a2;
            int n2 = littleEndianAccessor.readInt();
            int n3 = littleEndianAccessor.readInt();
            switch (n2) {
                case 1: {
                    if (n3 < 0) {
                        a3.getQuestRemove(MapleQuest.getInstance(122221));
                        return;
                    }
                    if (n3 <= 0) return;
                    a3.getQuestNAdd(MapleQuest.getInstance(122221)).setCustomData(String.valueOf(n3));
                    return;
                }
                case 2: {
                    if (n3 < 0) {
                        a3.getQuestRemove(MapleQuest.getInstance(122222));
                        return;
                    }
                    if (n3 <= 0) return;
                    a3.getQuestNAdd(MapleQuest.getInstance(122222)).setCustomData(String.valueOf(n3));
                    return;
                }
                case 3: {
                    MapleCharacter mapleCharacter = a3;
                    if (n3 <= 0) {
                        mapleCharacter.getQuestRemove(MapleQuest.getInstance(122224));
                        return;
                    }
                    mapleCharacter.getQuestNAdd(MapleQuest.getInstance(122224)).setCustomData(String.valueOf(n3));
                    return;
                }
                default: {
                    return;
                }
            }
        } else {
            int n4;
            LittleEndianAccessor littleEndianAccessor = a2;
            a3.updateTick(littleEndianAccessor.readInt());
            int n5 = littleEndianAccessor.readInt();
            int n6 = n4 = 0;
            while (n6 < n5) {
                ISkill iSkill;
                LittleEndianAccessor littleEndianAccessor2 = a2;
                int n7 = littleEndianAccessor2.readInt();
                byte by = littleEndianAccessor2.readByte();
                int n8 = littleEndianAccessor2.readInt();
                if (!(by == 1 && n8 >= 1000 ? (iSkill = SkillFactory.getSkill(n8)) != null && (!iSkill.isSkillNeedMasterLevel() && !iSkill.isBeginnerSkill() && iSkill.isInvisible() && a3.getSkillLevel(iSkill) <= 0 || SkillConstants.isLinkedSkill(n8)) : by == 2 && !a3.haveItem(n8, 1))) {
                    a3.changeKeybinding(n7, by, n8);
                }
                n6 = ++n4;
            }
        }
    }

    public static final /* synthetic */ void UseItemEffect(int a2, MapleClient a3, MapleCharacter a4) {
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a2);
        IItem iItem = null;
        if (a4 != null && a4.getInventory(mapleInventoryType) != null) {
            iItem = a4.getInventory(mapleInventoryType).findById(a2);
        }
        if (iItem == null || iItem.getItemId() != a2 || iItem.getQuantity() < 1) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2 != 5510000) {
            a4.setItemEffect(a2);
        }
        MapleCharacter mapleCharacter = a4;
        a4.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.itemEffect(mapleCharacter.getId(), a2), false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void UseChair(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        if (a == null) {
            return;
        }
        var3_3 = a.readInt();
        var4_4 = 0;
        var5_5 = false;
        var6_14 = 0;
        if (ItemConstants.isExpChair(var3_3)) {
            v0 = a;
            var5_6 = v0.readInt();
            var6_14 = v0.readInt();
        }
        if (GameSetConstants.MAPLE_VERSION < 143) ** GOTO lbl21
        var4_4 = a.readInt();
        var5_7 = MapleItemInformationProvider.getInstance().getChairRandEffect(var3_3);
        if (var5_7 == null) {
            var4_4 = 0;
            v1 = var3_3;
        } else {
            if (var4_4 >= var5_7.size() || var4_4 < 0) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
lbl21:
            // 3 sources

            v1 = var3_3;
        }
        var5_8 = GameConstants.getInventoryType(v1);
        var5_9 = a.getInventory(var5_8).findById(var3_3);
        if (!MapleItemInformationProvider.getInstance().itemExists(var3_3)) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!a.getPlayer().getMap().canChair()) {
            v2 = a;
            a.dropMessage(5, SellSystem.ALLATORIxDEMO("\u6b11\u575f\u5763\u7681\u5238\u79ee\u6b17\u4f10\u755d\u696a\u5b25\uff6e"));
            v2.sendPacket(MaplePacketCreator.cancelChair(-1));
            v2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var5_9 == null && var3_3 >= 3010000 && var3_3 < 9999999) {
            FileoutputUtil.logToFile(MapleMessenger.ALLATORIxDEMO("\u0017w\u001ckTP\u001a{\u001079y\u00157\u4f95\u6521\u5c7a\u531dUl\u0003l"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a.getPlayer().getName() + "(" + a.getPlayer().getId() + ") \u4fee\u6539\u6905\u5b50(" + var3_3 + ")\u5c01\u5305\uff0c\u5750\u4e0a\u6905\u5b50\u6642\u5c01\u9396\u3002 \u8eab\u4e0a\u4e26\u6c92\u6709\u8a72\u7269\u54c1");
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a.getPlayer().getName() + " \u56e0\u70ba\u4fee\u6539\u5c01\u5305\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]  " + a.getPlayer().getName() + "(" + a.getPlayer().getId() + ") \u4fee\u6539\u6905\u5b50(" + var3_3 + ")\u5c01\u5305\uff0c\u5750\u4e0a\u6905\u5b50\u6642\u5c01\u9396\u3002 \u8eab\u4e0a\u4e26\u6c92\u6709\u8a72\u7269\u54c1"));
            a.getPlayer().ban(SellSystem.ALLATORIxDEMO("\u4f9b\u6556\u5c74\u536a"), true, true, false);
            a.getSession().close();
            return;
        }
        if (MapConstants.isFishingMap(a.getMapId())) {
            block15: {
                var5_10 = false;
                var6_14 = 0;
                for (IItem var8_17 : a.getPlayer().getInventory(MapleInventoryType.CASH).list()) {
                    if (var3_3 >= 3010001 && var3_3 <= 4000000 && var8_17.getItemId() == 5340000) {
                        var5_11 = true;
                        var6_14 = 1;
                        continue;
                    }
                    if (var3_3 < 3010001 || var3_3 > 4000000 || var8_17.getItemId() != 5340001) continue;
                    var5_12 = false;
                    var6_14 = 1;
                    v3 = var5_12;
                    v4 = a;
                    v4.setcheck_FishingVip(true);
                    v4.startFishingTask();
                    break block15;
                }
                v3 = var5_11;
            }
            if (v3) {
                v5 = a;
                v5.setcheck_FishingVip(false);
                v5.startFishingTask();
            }
            if (var6_14 == 0) {
                a.dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u4e15\u7b5d\u5410\u9198\u9b42\u68e6\u4eee\uff77\u8ad3\u679e\u95a95H8\u91fb\u9b21\u65a1\u6cae\uff19"));
            }
        }
        a.setChair(var3_3);
        if (GameSetConstants.FLY_CHAIR && (var5_13 = ChairDataFactory.getFlyChair(var3_3)) != 0) {
            var6_15 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MONSTER_RIDING, 0));
            v6 = a;
            v7 = var5_13;
            a.getClient().sendPacket(MaplePacketCreator.giveMount(v7, var3_3, var6_15));
            v6.setFlyChairId(v7);
            v8 = a;
            v6.getMap().broadcastMessage(v8, MaplePacketCreator.showMonsterRiding(v8.getId(), var6_15, var5_13, var3_3), false);
            a.sendPacket(MaplePacketCreator.enableActions());
            if (v6.getMount().getFatigue() >= 95) {
                a.dropMessage(5, SellSystem.ALLATORIxDEMO("\u8b09\u543fU\u60dd\u76eb\u9a7b\u5b9a\u75c7\u52b1\u5049\u5948\u65c9V@C\u5c72\u5c61\u8181\u4eb9\u4ecf\u714e\u6ca0\u7764\u89fe\u60c7\u76f1\u98b4\u595c\u696a\u5b25N"));
            }
        }
        v9 = a;
        a.getMap().broadcastMessage(v9, MaplePacketCreator.showChair(v9.getId(), var3_3, var4_4), false);
        a.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void CancelItemEffect(int a2, MapleCharacter a3) {
        if (a3 != null) {
            a3.cancelEffect(MapleItemInformationProvider.getInstance().getItemEffect(-a2), false, -1L);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void MovePlayer(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        try {
            if (a == null) {
                return;
            }
            v0 = a;
            v0.checkYutoShieldProtecting();
            var3_3 = v0.getlastmovepackettime();
            if (var3_3 < 100L && var3_3 > 10L && !MapConstants.isPVPMap(a.getMapId())) {
                a.getPlayer().getCheatTracker().registerOffense(CheatingOffense.\u79fb\u52d5\u7121\u5ef6\u9072, "(\u5730\u5716: " + a.getPlayer().getMapId() + " \u983b\u9053: " + a.getPlayer().getClient().getChannel() + "Delay:" + var3_3);
            }
            var5_5 = a.getPosition();
            if (GameSetConstants.MAPLE_VERSION == 75) {
                v1 = a;
                v2 = v1;
                v1.skip(1);
            } else if (GameSetConstants.MAPLE_VERSION >= 139) {
                v3 = a;
                v2 = v3;
                v3.skip(9);
            } else {
                v4 = a;
                v2 = v4;
                v4.skip(29);
            }
            var4_6 = v2.readPos();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                a.skip(4);
            }
            try {
                var6_7 = MovementParse.parseMovement(a, a, 1);
            }
            catch (ArrayIndexOutOfBoundsException var7_8) {
                System.err.println("AIOBE Type1:\n" + a.toString(true));
                return;
            }
            var7_9 = false;
            var8_11 = 14;
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                var8_11 = 15;
            }
            for (LifeMovementFragment var10_17 : var6_7) {
                if (!(var10_17 instanceof AbstractLifeMovement) || ((AbstractLifeMovement)var10_17).getType() != var8_11) continue;
                var7_9 = true;
            }
            if (var7_9 && a.getMapId() == 915000300) {
                v5 = a;
                var9_13 = v5.getClient().getChannelServer().getMapFactory().getMap(915000200);
                a.getPlayer().getMap().resetFully();
                v5.dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u8ad3\u5284\u4f67\u7553\u4e13\u8d88\u506f\u6e5a\u301a"));
                v6 = var9_13;
                v5.changeMap(v6, v6.getPortal(1));
                return;
            }
            var9_14 = a.readByte();
            v7 = var10_18 = 0;
            while (v7 < var9_14) {
                a.readByte();
                v7 = var10_18 += 2;
            }
            if (a.available() < 8L) {
                System.err.println("\u89d2\u8272" + a.getName() + "(" + MapleJob.getName(MapleJob.getById(a.getJob())) + ") slea.available != 8 (\u89d2\u8272\u79fb\u52d5\u5c01\u5305\u51fa\u932f) \u5269\u9918\u5c01\u5305\u9577\u5ea6: " + a.available());
                return;
            }
            a.readShort();
            a.readShort();
            a.readShort();
            a.readShort();
            if (var6_7 == null) return;
            if (var6_7.isEmpty() != false) return;
            if (a.getPlayer().getMap() == null) return;
            if (a.available() != 0L) {
                System.err.println("\u89d2\u8272" + a.getName() + "(" + MapleJob.getName(MapleJob.getById(a.getJob())) + ") slea.available != 0 (\u89d2\u8272\u79fb\u52d5\u5c01\u5305\u51fa\u932f) \u5269\u9918\u5c01\u5305\u9577\u5ea6: " + a.available());
                return;
            }
            var10_19 = new ArrayList<LifeMovementFragment>(var6_7);
            var7_10 = a.getPlayer().getMap();
            v8 = a;
            v8.setLastRes(var10_19);
            if (v8.canShroudWalk()) {
                v9 = a;
                if (a.isHidden()) {
                    v10 = a;
                    v9.getPlayer().getMap().broadcastGMMessage(v10, MaplePacketCreator.movePlayer(v10.getId(), var6_7, var5_5), false);
                } else {
                    v9.getPlayer().getMap().broadcastMessage(a.getPlayer(), MaplePacketCreator.movePlayer(a.getId(), var6_7, var5_5), false);
                }
            }
            if (GameSetConstants.AUTO_PICKUP && a.isAutoPickup()) {
                InventoryHandler.PlayerAutoPickup(a, a);
            }
            MovementParse.updatePosition(var6_7, a, 0);
            var8_12 = a.getPosition();
            if (GameSetConstants.PVP_SYSTEM && (var9_14 = var5_5.x - var8_12.x) != 0) {
                a.setPVPDirection(var9_14);
            }
            if (GameSetConstants.CHECKMOVE && !a.getPlayer().getCheatTracker().\u5927\u7bc4\u570d\u79fb\u52d5ing()) {
                PlayerHandler.CheckMove(a, var5_5, var8_12);
            }
            var7_10.movePlayer(a, var8_12);
            if (a.getFollowId() <= 0 || !a.isFollowOn() || !a.isFollowInitiator()) ** GOTO lbl104
            var9_15 = var7_10.getCharacterById(a.getFollowId());
            if (var9_15 != null) {
                v11 = var9_15;
                var11_20 = v11.getPosition();
                v11.getClient().sendPacket(MaplePacketCreator.moveFollow(var5_5, var11_20, var8_12, var6_7));
                v12 = a;
                v13 = var9_15;
                MovementParse.updatePosition(var6_7, v13, 0);
                var7_10.broadcastMessage(v13, MaplePacketCreator.movePlayer(var9_15.getId(), var6_7, var11_20), false);
            } else {
                a.checkFollow();
lbl104:
                // 2 sources

                v12 = a;
            }
            var9_16 = v12.getClones();
            v14 = var11_21 = 0;
            while (v14 < var9_16.length) {
                if (var9_16[var11_21].get() != null) {
                    a = (MapleCharacter)var9_16[var11_21].get();
                    var6_7 = new ArrayList<LifeMovementFragment>(var10_19);
                    Timer.CloneTimer.getInstance().schedule(new Runnable(){
                        public final /* synthetic */ MapleCharacter k;
                        public final /* synthetic */ Point ALLATORIxDEMO;
                        public final /* synthetic */ MapleMap K;
                        public final /* synthetic */ Point d;
                        public final /* synthetic */ List a;

                        /*
                         * Enabled aggressive block sorting
                         * Enabled unnecessary exception pruning
                         * Enabled aggressive exception aggregation
                         */
                        @Override
                        public /* synthetic */ void run() {
                            try {
                                5 v2;
                                5 a2;
                                if (a2.k.getMap() != a2.K) return;
                                if (a2.k.isHidden()) {
                                    5 v0 = a2;
                                    5 v1 = a2;
                                    v2 = v1;
                                    5 v3 = a2;
                                    v0.K.broadcastGMMessage(v0.k, MaplePacketCreator.movePlayer(v1.k.getId(), v3.a, v3.d), false);
                                } else {
                                    5 v4 = a2;
                                    v2 = v4;
                                    5 v5 = a2;
                                    v4.K.broadcastMessage(v4.k, MaplePacketCreator.movePlayer(a2.k.getId(), v5.a, v5.d), false);
                                }
                                MovementParse.updatePosition(v2.a, a2.k, 0);
                                5 v6 = a2;
                                v6.K.movePlayer(v6.k, a2.ALLATORIxDEMO);
                                return;
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                        {
                            5 a2;
                            5 v0 = a2;
                            a2.k = mapleCharacter;
                            v0.K = mapleMap;
                            v0.a = list;
                            a2.d = point;
                            a2.ALLATORIxDEMO = point2;
                        }
                    }, 500 * var11_21 + 500);
                }
                v14 = ++var11_21;
            }
            var11_21 = a.getPlayer().getFallCounter();
            if (var7_10.getFootholds().findBelow(a.getPlayer().getPosition()) == null && a.getPlayer().getPosition().y > a.getPlayer().getOldPosition().y && a.getPlayer().getPosition().x == a.getPlayer().getOldPosition().x) {
                if (var11_21 > 10) {
                    v15 = a;
                    v16 = v15;
                    v17 = var7_10;
                    v15.getPlayer().changeMap(v17, v17.getPortal(0));
                    v15.getPlayer().setFallCounter(0);
                } else {
                    v18 = a;
                    v16 = v18;
                    v18.getPlayer().setFallCounter(++var11_21);
                }
            } else {
                if (var11_21 > 0) {
                    a.getPlayer().setFallCounter(0);
                }
                v16 = a;
            }
            v16.getPlayer().setOldPosition(new Point(a.getPlayer().getPosition()));
            return;
        }
        catch (Exception var3_4) {
            System.out.println("MOVE_PLAYER_2\u932f\u8aa4" + var3_4);
            var3_4.printStackTrace();
        }
    }

    public static /* synthetic */ void handlePartTimeJob(LittleEndianAccessor a2, MapleClient a3) {
        if (!a3.isLoggedIn()) {
            a3.getSession().close();
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = littleEndianAccessor.readByte();
        int n2 = littleEndianAccessor.readInt();
        byte by2 = littleEndianAccessor.readByte();
        if (by == 1) {
            MaplePartTimeJob maplePartTimeJob = MapleCharacterUtil.getPartTime(n2);
            if (by2 < 0 || by2 > 5 || maplePartTimeJob.getReward() > 0 || maplePartTimeJob.getJob() > 0 && maplePartTimeJob.getJob() <= 5) {
                a3.getSession().close();
                return;
            }
            long l2 = System.currentTimeMillis();
            MaplePartTimeJob maplePartTimeJob2 = maplePartTimeJob;
            maplePartTimeJob.setTime(l2);
            maplePartTimeJob2.setJob(by2);
            MapleCharacterUtil.removePartTime(n2);
            MapleCharacterUtil.addPartTime(maplePartTimeJob2);
            a3.announce(LoginPacket.updatePartTimeJob(maplePartTimeJob2));
            return;
        }
        if (by == 2) {
            MaplePartTimeJob maplePartTimeJob;
            MaplePartTimeJob maplePartTimeJob3 = MapleCharacterUtil.getPartTime(n2);
            if (maplePartTimeJob3.getReward() > 0 || maplePartTimeJob3.getJob() < 0 || maplePartTimeJob3.getJob() > 5) {
                a3.getSession().close();
                return;
            }
            long l3 = (System.currentTimeMillis() - maplePartTimeJob3.getTime()) / 3600000L;
            MaplePartTimeJob maplePartTimeJob4 = maplePartTimeJob3;
            if (l3 > 1L) {
                maplePartTimeJob4.setReward((int)((long)(maplePartTimeJob3.getJob() + 1) * 1000L + l3));
                maplePartTimeJob = maplePartTimeJob3;
            } else {
                maplePartTimeJob4.setJob((byte)0);
                MaplePartTimeJob maplePartTimeJob5 = maplePartTimeJob3;
                maplePartTimeJob = maplePartTimeJob5;
                maplePartTimeJob5.setReward(0);
            }
            maplePartTimeJob.setTime(System.currentTimeMillis());
            MapleCharacterUtil.removePartTime(n2);
            MaplePartTimeJob maplePartTimeJob6 = maplePartTimeJob3;
            MapleCharacterUtil.addPartTime(maplePartTimeJob6);
            a3.sendPacket(LoginPacket.updatePartTimeJob(maplePartTimeJob6));
        }
    }

    public static final /* synthetic */ void DropMeso(int a2, MapleCharacter a3) {
        if (!a3.isAlive() || a2 < 10 || a2 > 50000 || a2 > a3.getMeso()) {
            a3.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = a3;
        mapleCharacter.gainMeso(-a2, false, true);
        MapleCharacter mapleCharacter2 = a3;
        MapleCharacter mapleCharacter3 = a3;
        mapleCharacter.getMap().spawnMesoDrop(a2, mapleCharacter2.getPosition(), mapleCharacter3, mapleCharacter3, true, (byte)0);
        mapleCharacter2.getCheatTracker().checkDrop(true);
        if (mapleCharacter.getClient().isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a3.getName() + "/\u4e1f\u68c4\u7269\u54c1.txt", a3.getChrInfo("\u4e1f\u68c4 " + a2 + "\u6953\u5e63"));
        }
    }

    public static /* synthetic */ void ChangeSkillMacro(LittleEndianAccessor a2, MapleCharacter a3) {
        int n2;
        int n3 = a2.readByte();
        String string = "";
        int n4 = n2 = 0;
        while (n4 < n3) {
            try {
                string = a2.readMapleAsciiString();
                if (string.getBytes().length > 18) {
                    FileoutputUtil.logToFile(SellSystem.ALLATORIxDEMO("\u0019\u0000\u0012\u001cZ'\u0014\f\u001e@\u89a7\u821d\u8a7f\u6000\u8972\u8892[\u001b\r\u001b"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a3.getName() + "\u7b49\u7d1a:" + a3.getLevel() + " (\u7de8\u865f: " + a3.getId() + ") \u8a0a\u606f\u9577\u5ea6:" + string.getBytes().length + " \u8a0a\u606f\u5167\u5bb9:" + string);
                    string = string.substring(0, 18);
                }
            }
            catch (Exception exception) {
                FilePrinter.printError(MapleMessenger.ALLATORIxDEMO("8p\u001av\u001c}(s\u0012t\u0017U\u001a{\twUl\u0003l"), exception, "\u4fdd\u5b58\u6280\u80fd\u540d\u7a31\u7570\u5e38 \u8a0a\u606f\u9577\u5ea6:" + string.getBytes().length + " \u8a0a\u606f\u5167\u5bb9:" + string);
                string = "";
            }
            LittleEndianAccessor littleEndianAccessor = a2;
            byte by = littleEndianAccessor.readByte();
            int n5 = littleEndianAccessor.readInt();
            int n6 = littleEndianAccessor.readInt();
            int n7 = littleEndianAccessor.readInt();
            if (a3.getSkillLevel(n5) <= 0) {
                n5 = 0;
            }
            if (a3.getSkillLevel(n6) <= 0) {
                n6 = 0;
            }
            if (a3.getSkillLevel(n7) <= 0) {
                n7 = 0;
            }
            string = string.replace("@", "");
            SkillMacro skillMacro = new SkillMacro(n5, n6, n7, string, by, n2);
            a3.updateMacros(n2++, skillMacro);
            n4 = n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void AranCombo(MapleClient a2, MapleCharacter a3, int a4) {
        if (a3 != null && a3.getJob() >= 2000 && a3.getJob() <= 2112) {
            int n2;
            if (a3.hasGmLevel(5)) {
                a4 += 9;
            }
            int n3 = a3.getCombo();
            long l2 = System.currentTimeMillis();
            if (n3 > 0 && l2 - a3.getLastCombo() > GameSetConstants.ARAN_COMBO_TIME) {
                n3 = 0;
            }
            int n4 = n3 = (int)((short)Math.min(30000, n3 + a4));
            a3.setLastCombo(l2);
            a3.setCombo(n4);
            switch (n4) {
                case 10: 
                case 20: 
                case 30: 
                case 40: 
                case 50: 
                case 60: 
                case 70: 
                case 80: 
                case 90: 
                case 100: {
                    if (a3.getSkillLevel(21000000) < n3 / 10) {
                        n2 = n3;
                        break;
                    }
                    SkillFactory.getSkill(21000000).getEffect(n3 / 10).applyComboBuff(a3, n3);
                }
                default: {
                    n2 = n3;
                }
            }
            if (n2 > 100) {
                SkillFactory.getSkill(21000000).getEffect(10).applyComboBuff(a3, 100);
            }
        }
    }

    public static /* synthetic */ void useSilentCrusadeShop(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        if (a3.getPlayer().hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        short s3 = littleEndianAccessor.readShort();
        if (s2 > 8 || s2 < 0 || !MapleItemInformationProvider.getInstance().itemExists(n2) || s3 < 0) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleShopFactory.getInstance().getShop(144).sendShop(a3);
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void ResetSkillMacro(MapleCharacter a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 3) {
            Object object = "";
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            object = new SkillMacro(n5, n6, n7, (String)object, n4, n2);
            a2.updateMacros(n2++, (SkillMacro)object);
            n3 = n2;
        }
    }

    public static final /* synthetic */ void CancelChair(short a2, MapleClient a3, MapleCharacter a4) {
        if (a4 == null || a3 == null) {
            return;
        }
        if (a2 == -1) {
            if (a4.getChair() >= 3010001 && a4.getChair() <= 4000000 && MapConstants.isFishingMap(a4.getMapId())) {
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.cancelFishingTask();
                mapleCharacter.setcheck_FishingVip(false);
            }
            a4.setChair(0);
            a3.sendPacket(MaplePacketCreator.cancelChair(-1));
            MapleCharacter mapleCharacter = a4;
            a4.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showChair(mapleCharacter.getId(), 0, 0), false);
        } else {
            a4.setChair(a2);
            a3.sendPacket(MaplePacketCreator.cancelChair(a2));
        }
        if (GameSetConstants.FLY_CHAIR) {
            MapleBuffStat[] arrmapleBuffStat = new MapleBuffStat[1];
            arrmapleBuffStat[0] = MapleBuffStat.MONSTER_RIDING;
            a4.cancelBuffStats(arrmapleBuffStat);
            a4.setFlyChairId(0);
        }
    }

    public static /* synthetic */ void releaseTempestBlades(LittleEndianAccessor a2, MapleCharacter a3) {
        MapleStatEffect mapleStatEffect;
        int n2;
        int n3;
        if (!a3.isAlive()) {
            a3.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        int n4 = a2.readInt();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n5 = n3 = 0;
        while (n5 < n4) {
            int n6 = a2.readInt();
            MapleMonster mapleMonster = a3.getMap().getMonsterByOid(n6);
            if (mapleMonster != null && mapleMonster.isAlive()) {
                arrayList.add(n6);
            }
            n5 = ++n3;
        }
        n3 = a3.getBuffSource(MapleBuffStat.TEMPEST_BLADES);
        ArrayList<Pair<Integer, Integer>> arrayList2 = new ArrayList<Pair<Integer, Integer>>();
        boolean bl = n3 == 61120007 || n3 == 61121217;
        n4 = n3 == 61110211 || n3 == 61121217 ? 1 : 0;
        int n7 = n2 = 0;
        while (n7 < (bl ? 5 : 3)) {
            arrayList2.add(new Pair<Integer, Integer>(n2 + 2, n4 != 0 ? 4 : 2));
            n7 = ++n2;
        }
        a3.getMap().broadcastMessage(MaplePacketCreator.gainForce(false, a3, arrayList, 2, n3, arrayList2));
        ISkill iSkill = SkillFactory.getSkill(n3);
        if (iSkill != null && (mapleStatEffect = iSkill.getEffect(a3.getTotalSkillLevel(n3))) != null) {
            MapleCharacter mapleCharacter = a3;
            mapleCharacter.cancelEffectFromBuffStat(MapleBuffStat.TEMPEST_BLADES);
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.skillCooldown(61101002, mapleStatEffect.getCooldown(a3)));
            mapleCharacter.addCooldown(61101002, System.currentTimeMillis(), mapleStatEffect.getCooldown(a3) * 1000);
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 5;
        int cfr_ignored_0 = 4 << 4 ^ (3 << 2 ^ 3);
        int n5 = n3;
        int n6 = 5 << 4 ^ 1 << 1;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public static final /* synthetic */ void Heal(LittleEndianAccessor a2, MapleCharacter a3) {
        int n2;
        Serializable serializable;
        if (a3 == null) {
            return;
        }
        a3.updateTick(a2.readInt());
        if (a2.available() >= 8L && GameSetConstants.MAPLE_VERSION >= 138) {
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(littleEndianAccessor.available() >= 12L ? 8 : 4);
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n3 = littleEndianAccessor.readShort();
        int n4 = littleEndianAccessor.readShort();
        if (a3.getChair() != 0) {
            serializable = MapleItemInformationProvider.getInstance().getChairRecovery(a3.getChair());
            if (serializable == null) {
                return;
            }
            n2 = (Integer)((Pair)serializable).getLeft();
            int n5 = (Integer)((Pair)serializable).getRight();
            boolean bl = false;
            if (n3 == n2 && n4 == 0 || n4 == n5 && n3 == 0 || n4 == n5 && n3 == n2) {
                bl = true;
            }
            if (!bl) {
                return;
            }
        }
        if ((serializable = a3.getStat()) == null) {
            return;
        }
        if (((PlayerStats)serializable).getHp() <= 0) {
            return;
        }
        if (n3 != 0 && a3.canHP()) {
            n2 = (int)((PlayerStats)serializable).getShouldHealHP();
            if (n3 > n2 * 5) {
                n3 = 100;
            }
            a3.addHP(n3);
        }
        if (n4 != 0 && !JobConstants.is\u4e0d\u4f7f\u7528MP\u8077\u696d(a3.getJob()) && a3.canMP()) {
            n2 = (int)((PlayerStats)serializable).getShouldHealMP();
            if (n4 > n2 * 5) {
                n4 = 100;
            }
            a3.addMP(n4);
        }
    }

    public static final /* synthetic */ void ChangeAndroidEmotion(int a2, MapleCharacter a3) {
        if (a2 > 0 && a3 != null && a3.getMap() != null && !a3.isHidden() && a2 <= 17 && a3.getAndroid() != null) {
            a3.getMap().broadcastMessage(MaplePacketCreator.showAndroidEmotion(a3.getId(), a2));
        }
    }

    public static final /* synthetic */ void CancelSkillWithBuff(LittleEndianAccessor a2, MapleCharacter a3) {
        ISkill iSkill;
        if (a3 == null) {
            return;
        }
        int n2 = a2.readInt();
        if (n2 % 10000 < 1000 && SkillFactory.getSkill(n2) == null) {
            n2 += 1000;
        }
        if ((iSkill = SkillFactory.getSkill(n2)) == null) {
            return;
        }
        if (iSkill.isChargeSkill()) {
            MapleCharacter mapleCharacter = a3;
            mapleCharacter.setKeyDownSkill_Time(0L);
            MapleCharacter mapleCharacter2 = a3;
            mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.skillCancel(mapleCharacter2, n2), false);
            return;
        }
        if (n2 == 60011218 || n2 == 60001218) {
            LittleEndianAccessor littleEndianAccessor = a2;
            short s2 = littleEndianAccessor.readShort();
            int n3 = littleEndianAccessor.readInt();
            int n4 = littleEndianAccessor.readInt();
            int n5 = littleEndianAccessor.readInt();
            MapleCharacter mapleCharacter = a3;
            MapleCharacter mapleCharacter3 = a3;
            mapleCharacter.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.showBuffEffect(mapleCharacter3.getId(), n2, 1, 1, 1, (byte)3, n3, n4, n5), false);
            mapleCharacter.cancelEffect(iSkill.getEffect(s2), false, -1L);
            return;
        }
        int n6 = n2 - 1000;
        MapleCharacter mapleCharacter = a3;
        a3.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(n6, 1, a3.getLevel(), 1, (byte)1));
        MapleCharacter mapleCharacter4 = a3;
        mapleCharacter.getMap().broadcastMessage(mapleCharacter4, MaplePacketCreator.showBuffEffect(mapleCharacter4.getId(), n6, 1, a3.getLevel(), 1, (byte)1), false);
        mapleCharacter.cancelEffect(iSkill.getEffect(a2.readByte()), false, -1L);
    }

    public static final /* synthetic */ void CancelMech(LittleEndianAccessor a2, MapleCharacter a3) {
        ISkill iSkill;
        if (a3 == null) {
            return;
        }
        int n2 = a2.readInt();
        if (n2 % 10000 < 1000 && SkillFactory.getSkill(n2) == null) {
            n2 += 1000;
        }
        if ((iSkill = SkillFactory.getSkill(n2)) == null) {
            return;
        }
        MapleCharacter mapleCharacter = a3;
        if (iSkill.isChargeSkill()) {
            mapleCharacter.setKeyDownSkill_Time(0L);
            MapleCharacter mapleCharacter2 = a3;
            a3.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.skillCancel(mapleCharacter2, n2), false);
            return;
        }
        mapleCharacter.cancelEffect(iSkill.getEffect(a2.readByte()), false, -1L);
    }

    public static /* synthetic */ void PartyRewardClose(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || ((MapleClient)a3).getPlayer() == null) {
            return;
        }
        MapleParty mapleParty = ((MapleClient)a3).getPlayer().getParty();
        if (mapleParty == null) {
            return;
        }
        if (!((MapleClient)a3).getPlayer().isLeader()) {
            return;
        }
        if (!((MapleClient)a3).getPlayer().hasPQrewardUI()) {
            return;
        }
        Object object = a3 = mapleParty.getOnlineMembers().iterator();
        while (object.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)a3.next();
            if (maplePartyCharacter.getChr() == null) {
                object = a3;
                continue;
            }
            MapleClient mapleClient = maplePartyCharacter.getChr().getClient();
            Iterator<Triple<Integer, Integer, Integer>> iterator = mapleParty.getChooseItems().iterator();
            while (iterator.hasNext()) {
                Iterator<Triple<Integer, Integer, Integer>> iterator2;
                Triple<Integer, Integer, Integer> triple = iterator2.next();
                if (triple.getLeft().intValue() == maplePartyCharacter.getId()) {
                    maplePartyCharacter.getChr().gainItem(triple.getMid(), 1);
                }
                mapleClient.sendPacket(MaplePacketCreator.showPQrewardItem(triple.getMid(), triple.getRight()));
                iterator = iterator2;
            }
            maplePartyCharacter.getChr().setPQrewardUI(false);
            object = a3;
        }
        mapleParty.resetChooseItem();
    }

    public static /* synthetic */ void ChangeMonsterBookCover(int a2, MapleClient a3, MapleCharacter a4) {
        if (a2 == 0 || GameConstants.isMonsterCard(a2)) {
            MapleCharacter mapleCharacter = a4;
            mapleCharacter.setMonsterBookCover(a2);
            mapleCharacter.getMonsterBook().updateCard(a3, a2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void GrenadeEffect(LittleEndianAccessor a2, MapleClient a3) {
        if (a2.available() < 24L) {
            return;
        }
        a3 = ((MapleClient)a3).getPlayer();
        boolean bl = false;
        int n2 = 0;
        Point point = new Point(a2.readInt(), a2.readInt());
        a2.readInt();
        LittleEndianAccessor littleEndianAccessor = a2;
        int n3 = littleEndianAccessor.readInt();
        int n4 = littleEndianAccessor.readInt();
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            bl = a2.readByte() > 0;
            n2 = a2.readInt();
        }
        a2.readInt();
        switch (n4) {
            case 4321002: 
            case 5081001: 
            case 5201002: 
            case 5300007: 
            case 5301001: 
            case 14111006: 
            case 27120211: 
            case 27121201: {
                int n5 = ((MapleCharacter)a3).getSkillLevel(n4);
                if (n5 <= 0) break;
                Object object = a3;
                ((MapleCharacter)a3).getMap().broadcastMessage((MapleCharacter)object, MaplePacketCreator.throwGrenade(((MapleCharacter)object).getId(), point, n3, n4, n5, bl, n2), point);
                return;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void TrockAddMap(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block9: {
            block12: {
                block10: {
                    block11: {
                        block7: {
                            block8: {
                                if (GameSetConstants.MAPLE_VERSION >= 134) {
                                    PlayerHandler.TrockAddMap135(a, a, a);
                                    return;
                                }
                                v0 = a;
                                var3_3 = v0.readByte();
                                var4_4 = v0.readByte();
                                if (var4_4 != 1) break block7;
                                if (var3_3 != 0) break block8;
                                v1 = a;
                                a.deleteFromRocks(a.readInt());
                                break block9;
                            }
                            if (var3_3 != 1 || FieldLimitType.VipRock.check(a.getMap().getFieldLimit())) ** GOTO lbl49
                            if (a.getPlayer().getMapId() != 180000000) {
                                v1 = a;
                                a.addRockMap();
                            } else {
                                a.dropMessage(1, MapleMessenger.ALLATORIxDEMO("\u4f78\u4e76\u80e5\u5149\u5b40\u9062\u5f2d\u574b\u570e"));
                                v1 = a;
                            }
                            break block9;
                        }
                        if (var4_4 < 2) break block10;
                        if (var3_3 != 0) break block11;
                        v1 = a;
                        a.deleteFromHyperRocks(a.readInt());
                        break block9;
                    }
                    if (var3_3 != 1) ** GOTO lbl49
                    v2 = a;
                    if (!FieldLimitType.VipRock.check(a.getMap().getFieldLimit())) {
                        v2.addHyperRockMap();
                        v1 = a;
                    } else {
                        v2.dropMessage(1, SellSystem.ALLATORIxDEMO("\u4f0f\u4e78\u8092\u5147\u5b37\u906c\u5f5a\u5745\u5779"));
                        v1 = a;
                    }
                    break block9;
                }
                if (var3_3 != 0) break block12;
                v1 = a;
                a.deleteFromRegRocks(a.readInt());
                break block9;
            }
            if (var3_3 != 1 || FieldLimitType.VipRock.check(a.getMap().getFieldLimit())) ** GOTO lbl49
            if (a.getPlayer().getMapId() <= 197010000 && a.getPlayer().getMapId() != 180000000) {
                v1 = a;
                a.addRegRockMap();
            } else {
                a.dropMessage(1, MapleMessenger.ALLATORIxDEMO("\u4f78\u4e76\u80e5\u5149\u5b40\u9062\u5f2d\u574b\u570e"));
lbl49:
                // 4 sources

                v1 = a;
            }
        }
        v1.sendPacket(MTSCSPacket.getTrockRefresh(a, var4_4, var3_3 == (GameSetConstants.MAPLE_VERSION >= 134 ? 3 : 0)));
    }

    public /* synthetic */ PlayerHandler() {
        PlayerHandler a2;
    }

    public static /* synthetic */ void closeSilentCrusadeUI(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void GainChairExp(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void UseTitle(int a2, MapleClient a3, MapleCharacter a4) {
        MapleCharacter mapleCharacter;
        IItem iItem;
        if (a4 == null || a4.getMap() == null) {
            return;
        }
        if (a2 != 0 && ((iItem = a4.getInventory(MapleInventoryType.SETUP).findById(a2)) == null || iItem.getQuantity() < 1 || a2 / 10000 != 370)) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter2 = a4;
        if (a2 == 0) {
            mapleCharacter2.removeCharacterSet(MapleMessenger.ALLATORIxDEMO("\u000fq\u000ft\u001eK\u0010q\u0017t"));
            mapleCharacter = a4;
        } else {
            mapleCharacter2.setCharacterSet(SellSystem.ALLATORIxDEMO("\u0001\u0006\u0001\u0003\u0010<\u001e\u0006\u0019\u0003"), MapleItemInformationProvider.getInstance().getNickSkill(a2));
            mapleCharacter = a4;
        }
        mapleCharacter.setTitleEffect(a2);
        MapleClient mapleClient = a3;
        mapleClient.getPlayer().getStat().recalcLocalStats();
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        MapleCharacter mapleCharacter3 = a4;
        a4.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.showTitle(mapleCharacter3.getId(), a2), false);
    }

    public static final /* synthetic */ void QuickSlot(LittleEndianAccessor a2, MapleCharacter a3) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = n2 = 0;
        while (n3 < 8) {
            stringBuilder.append(a2.readInt());
            n3 = ++n2;
        }
        a3.getQuestNAdd(MapleQuest.getInstance(123000)).setCustomData(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int isFinisher(int a2) {
        switch (a2) {
            case 1111003: 
            case 1111004: {
                return 10;
            }
            case 1111005: 
            case 1111006: {
                return 10;
            }
            case 11111002: {
                return 10;
            }
            case 11111003: {
                return 10;
            }
        }
        return 0;
    }

    public static /* synthetic */ void RequestSetOffTrinity(LittleEndianAccessor a2, MapleCharacter a3) {
        if (!a3.isAlive() || a3.getSkillLevel(65121101) < 0) {
            a3.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        Object object = SkillFactory.getSkill(65121101);
        if (object != null && (object = object.getEffect(a3.getTotalSkillLevel(65121101))) != null) {
            ((MapleStatEffect)object).applyTo(a3);
        }
    }

    public static /* synthetic */ void MobVacSkill(MapleClient a2) {
        Iterator<MapleMonster> iterator = a2.getPlayer().getMap().getAllMonstersThreadsafe().iterator();
        while (iterator.hasNext()) {
            MapleMonster mapleMonster = (MapleMonster)((MapleMapObject)iterator.next());
            if (MobConstants.isReincarnationMob(mapleMonster.getId()) || mapleMonster.getStats().isBoss()) continue;
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().getMap().broadcastMessage(MobPacket.moveMonster(0 != 0, 0, 0, 0, 0, mapleMonster.getObjectId(), mapleMonster.getPosition(), a2.getPlayer().getPosition(), a2.getPlayer().getLastRes(), null, null));
            MapleMonster mapleMonster2 = mapleMonster;
            mapleMonster2.setPosition(a2.getPlayer().getPosition());
            mapleMonster2.setController(mapleClient.getPlayer());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void EventTakeDamage(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        if (a3 == null || a3.getPlayer() == null || a3.getPlayer().getMap() == null) {
            return;
        }
        Object object = a3.getPlayer().getMap().getMonsterById(a2.readInt());
        if (object == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        switch (((AbstractLoadedMapleLife)object).getId()) {
            case 9410052: {
                if (MapConstants.isCakeMap(a3.getPlayer().getMapId())) {
                    MapleClient mapleClient2 = a3;
                    mapleClient = mapleClient2;
                    Object object2 = object = mapleClient2.getChannelServer().getMapFactory().getMap(749020920);
                    mapleClient2.getPlayer().changeMap((MapleMap)object2, ((MapleMap)object2).getPortal(0));
                    break;
                }
            }
            default: {
                mapleClient = a3;
            }
        }
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void CharInfoRequest(int a2, MapleClient a3, MapleCharacter a4) {
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null) {
            return;
        }
        MapleClient mapleClient = a3;
        MapleCharacter mapleCharacter = mapleClient.getPlayer().getMap().getCharacterById(a2);
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        if (!(mapleCharacter == null || mapleCharacter.isClone() || mapleCharacter.isGM() && !a3.getPlayer().isGM())) {
            if (GameSetConstants.isClickGameMap(a4.getMapId()) || a4.getMap().isClickGameMap()) {
                ClickGame.ClickPlayer(a4, mapleCharacter);
                return;
            }
            a3.sendPacket(MaplePacketCreator.charInfo(mapleCharacter, a3.getPlayer().getId() == a2));
        }
    }

    public static /* synthetic */ void OpenAndroidShop(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        int n4 = littleEndianAccessor.readInt();
        n4 = littleEndianAccessor.readInt();
        if (n2 != a3.getPlayer().getId() || n3 != 100 || a3.getPlayer().getAndroid() == null || a3.getPlayer().getEventInstance() != null || a3.getPlayer().getMapId() >= 990000000 || a3.getPlayer().hasBlockedInventory()) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u7695\u5255\u715a\u6ccd\u4f04\u7530\u5908\u50cd\u6a24\u5670\u4ec1\u555e\u5eec\u301a"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a3.getPlayer().getAndroid().getItemId() != 1666000 && a3.getPlayer().getAndroid().getItemId() != 1662027 && a3.getPlayer().getAndroid().getItemId() != 1662032) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(5, SellSystem.ALLATORIxDEMO("\u769b\u5222\u7154\u6cba\u4f0a\u7547\u5906\u50ba\u6a2a\u5607\u4ecf\u5529\u5ee2\u306d"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleShopFactory.getInstance().getShop(145).sendShop(a3);
    }

    public static /* synthetic */ void RequestPartyReward(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        if (a2.available() < 5L) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = littleEndianAccessor.readByte();
        int n2 = littleEndianAccessor.readInt();
        if (!a3.getPlayer().hasPQrewardUI()) {
            return;
        }
        int[] arrn = new int[6];
        arrn[0] = 2000004;
        arrn[1] = 2000005;
        arrn[2] = 2000006;
        arrn[3] = 2000007;
        arrn[4] = 2000008;
        arrn[5] = 2020013;
        int n3 = arrn[Randomizer.nextInt(arrn.length)];
        MapleClient mapleClient = a3;
        if (a3.getPlayer().getParty() == null) {
            mapleClient.sendPacket(MaplePacketCreator.showPQRewardResult(by, n2, a3.getPlayer().getName()));
            return;
        }
        Object object = mapleClient.getPlayer().getParty();
        if (!((MapleParty)object).hasChoosenItem(a3.getPlayer().getId())) {
            ((MapleParty)object).addChooseItem(a3.getPlayer().getId(), n3, by);
        }
        Object object2 = object = ((MapleParty)object).getOnlineMembers().iterator();
        while (object2.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)object.next();
            if (maplePartyCharacter.getChr() == null) {
                object2 = object;
                continue;
            }
            maplePartyCharacter.getChr().getClient().sendPacket(MaplePacketCreator.showPQRewardResult(by, n3, a3.getPlayer().getName()));
            object2 = object;
        }
    }

    public static /* synthetic */ void RequestSilentCrusadeReward(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        short s2 = a2.readShort();
        if (a3 == null || a3.getPlayer() == null || s2 > 3 || s2 < 0) {
            return;
        }
        if (!a3.getPlayer().getInfoQuest(1648 + s2).equals(SellSystem.ALLATORIxDEMO("\u0018_H]N\u0002DRGT\u0018]H]N\u0002FRGT\u0018[H]N\u001dH_"))) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient2 = a3;
        short s3 = mapleClient2.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot();
        short s4 = mapleClient2.getPlayer().getInventory(MapleInventoryType.SETUP).getNumFreeSlot();
        short s5 = mapleClient2.getPlayer().getInventory(MapleInventoryType.ETC).getNumFreeSlot();
        if (s3 < 1 || s4 < 1 || s5 < 1) {
            MapleClient mapleClient3 = a3;
            mapleClient3.sendPacket(MaplePacketCreator.getSilentCrusadeMsg((byte)2));
            mapleClient3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        switch (s2) {
            case 0: {
                MapleClient mapleClient4 = a3;
                while (false) {
                }
                mapleClient = mapleClient4;
                mapleClient4.getPlayer().gainItem(3700031, 1);
                mapleClient4.getPlayer().gainItem(4310029, 10);
                mapleClient4.getPlayer().updateOneInfo(1648, MapleMessenger.ALLATORIxDEMO("j"), "1");
                break;
            }
            case 1: {
                MapleClient mapleClient5 = a3;
                mapleClient = mapleClient5;
                mapleClient5.getPlayer().gainItem(3700032, 1);
                mapleClient5.getPlayer().gainItem(2430669, 1);
                mapleClient5.getPlayer().gainItem(4310029, 15);
                mapleClient5.getPlayer().updateOneInfo(1649, SellSystem.ALLATORIxDEMO("\u001d"), "1");
                break;
            }
            case 2: {
                MapleClient mapleClient6 = a3;
                mapleClient = mapleClient6;
                mapleClient6.getPlayer().gainItem(3700033, 1);
                mapleClient6.getPlayer().gainItem(2430668, 1);
                mapleClient6.getPlayer().gainItem(4310029, 20);
                mapleClient6.getPlayer().updateOneInfo(1650, MapleMessenger.ALLATORIxDEMO("j"), "1");
                break;
            }
            case 3: {
                MapleClient mapleClient7 = a3;
                mapleClient7.getPlayer().gainItem(3700034, 1);
                mapleClient7.getPlayer().gainItem(2049309, 1);
                mapleClient7.getPlayer().gainItem(4310029, 30);
                mapleClient7.getPlayer().updateOneInfo(1651, SellSystem.ALLATORIxDEMO("\u001d"), "1");
            }
            default: {
                mapleClient = a3;
            }
        }
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void rangedAttack(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block73: {
            if (a == null) {
                return;
            }
            if (!a.isAlive() || a.getMap() == null) {
                a.getCheatTracker().registerOffense(CheatingOffense.ATTACKING_WHILE_DEAD);
                return;
            }
            if (GameSetConstants.DAMAGE_SKIN) {
                AttackFont.sendFontStyle(a);
            }
            var3_5 = DamageParse.Modify_AttackCrit(DamageParse.parseDmg(a, DamageParse.DamageType.RANGED_ATTACK, a), a, 2);
            v0 = var4_7 = a.getJob() >= 3500 && a.getJob() <= 3512 || GameConstants.isCannon(a.getJob()) != false || GameConstants.isMercedes(a.getJob()) != false ? 1 : 0;
            if (var3_5 == null) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (!SkillCollector.getInstance().isExistSkill(2, var3_5.skill)) {
                a.getCheatTracker().registerOffense(CheatingOffense.ATTACK_TYPE_ERROR, "\u6280\u80fd: " + var3_5.skill + " \u7a2e\u985e: 2");
                SkillCollector.getInstance().addSkill(2, var3_5.skill);
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            var5_8 = 1;
            var6_9 = 0;
            var7_10 = null;
            var8_11 = null;
            v1 = var9_12 = var3_5.skill == 4111004;
            if (a.getMap().skillDisabled() && var3_5.skill != 0 && var3_5.skill != 2301002) {
                a.getStat().setMp(0);
                v2 = a;
                a.updateSingleStat(MapleStat.MP, 0);
                v2.getDiseaseBuff(MobSkill.getByMobSkill(120), MobSkillFactory.getMobSkill(120, 1));
                v2.dropMessage(MapleMessenger.ALLATORIxDEMO("\u6b7c\u574b\u570e\u7695\u5255\u79fa\u6b7a\u4f04\u7530\u4e80\u4f4d\u62fb\u80e5"));
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (var3_5.skill == 0) ** GOTO lbl75
            var8_11 = SkillFactory.getSkill(SkillConstants.getLinkedSkill(var3_5.skill));
            if (var8_11 != null && (var6_9 = a.getSkillLevel(var8_11)) == 0 && a.containsBindingBySkillid(var3_5.skill)) {
                var6_9 = 1;
            }
            if ((var7_10 = var3_5.getAttackEffect(a, var6_9, var8_11)) == null) {
                return;
            }
            if ((a.getStat().combatOrders > 0 || a.getStat().incAllskill > 0) && var7_10 != null && SkillFactory.getSkill(var7_10.getSourceId()).getEffect(var7_10.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill) != null) {
                var7_10 = SkillFactory.getSkill(var7_10.getSourceId()).getEffect(var7_10.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill);
            }
            if (var7_10 == null) {
                return;
            }
            switch (var3_5.skill) {
                case 1077: 
                case 1078: 
                case 1079: 
                case 11077: 
                case 11078: 
                case 11079: 
                case 3111004: 
                case 3211004: 
                case 4111013: 
                case 4121003: 
                case 4221003: 
                case 5121002: 
                case 5121013: 
                case 5121016: 
                case 5201001: 
                case 5211008: 
                case 5221013: 
                case 5221016: 
                case 5221017: 
                case 5321001: 
                case 5711000: 
                case 5721006: 
                case 5721007: 
                case 5921002: 
                case 11101004: 
                case 13101005: 
                case 13111000: 
                case 13111007: 
                case 14101006: 
                case 14111008: 
                case 15111006: 
                case 15111007: 
                case 21000004: 
                case 21100004: 
                case 21100007: 
                case 21110004: 
                case 21110011: 
                case 21120006: 
                case 33101002: 
                case 33101007: 
                case 33121001: 
                case 33121002: {
                    var9_12 = true;
                    var5_8 = var7_10.getAttackCount();
                    break;
                }
                case 35111004: 
                case 35121005: 
                case 35121013: {
                    var9_12 = true;
                    var5_8 = 6;
                    break;
                }
                default: {
                    var5_8 = var7_10.getBulletCount();
                }
            }
            if (GameSetConstants.MODIFY_ATTACKCOUNT) {
                if (var7_10.getAttackCount() > var7_10.getBulletCount()) {
                    var5_8 = var7_10.getAttackCount();
                }
                if (var7_10.getBulletCount() > var7_10.getAttackCount()) {
                    var5_8 = var7_10.getBulletCount();
                }
            }
            if (var4_7 != 0 && var7_10.getBulletCount() < var7_10.getAttackCount()) {
                var5_8 = var7_10.getAttackCount();
            }
            v3 = GameSetConstants.MAPLE_VERSION >= 134 ? var7_10.getCooldown(a) > 0 && (var3_5.skill != 35111004 && var3_5.skill != 35121013 || a.getBuffSource(MapleBuffStat.MECH_CHANGE) != var3_5.skill) : (var10_14 = var7_10.getCooldown(a) > 0);
            if (!var10_14) ** GOTO lbl75
            if (a.skillisCooling(var3_5.skill)) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (SkillConstants.isMoveSkill(var3_5.skill)) {
                a.getPlayer().updateUsingMoveSkill(true);
            }
            if (a.isAdmin() && a.isInvincible()) {
                a.dropMessage("\u4f3a\u670d\u5668\u7ba1\u7406\u54e1\u7121\u6575\u72c0\u614b\u6d88\u9664\u6280\u80fd\u51b7\u537b[" + SkillFactory.getName(var3_5.skill) + "(" + var3_5.skill + ")]\uff0c\u6301\u7e8c\u6642\u9593\uff1a" + var7_10.getCooldown(a) + "\u79d2");
                v4 = a;
            } else {
                a.sendPacket(MaplePacketCreator.skillCooldown(var3_5.skill, var7_10.getCooldown(a)));
                a.addCooldown(var3_5.skill, System.currentTimeMillis(), var7_10.getCooldown(a) * 1000);
lbl75:
                // 3 sources

                v4 = a;
            }
            var10_15 = v4.getBuffedValue(MapleBuffStat.SHADOWPARTNER);
            if (var10_15 != null) {
                var5_8 *= 2;
            }
            var11_16 = 0;
            var12_18 = 0;
            v5 = var13_19 = a.getBuffedValue(MapleBuffStat.SOULARROW) == null ? 1 : 0;
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                if (var9_12) break block73;
                v6 = var13_19;
            } else {
                if (var3_5.AOE == 0) break block73;
                v6 = var13_19;
            }
            if (v6 == 0 || var3_5.skill == 4111004 || var3_5.skill == 33101005 || var3_5.skill == 33101006 || var3_5.skill == 33101007 || var4_7 != 0) break block73;
            if (var3_5.slot != 0) {
                if (a.getInventory(MapleInventoryType.USE).getItem(var3_5.slot) == null && var3_5.skill != 3121004) {
                    v7 = var3_5;
                    a.getCheatTracker().registerOffense(CheatingOffense.\u7121\u7bad\u77e2\u767c\u5c04\u5f13\u7bad, " \u6280\u80fd: " + v7.skill + " \u76ee\u6a19\u6578\u91cf: " + v7.targets);
                    return;
                }
                var14_20 = a.getInventory(MapleInventoryType.USE).getItem(var3_5.slot);
                if (var14_20 != null) {
                    var11_16 = var14_20.getItemId();
                }
                if (var3_5.csstar > 0) {
                    if (a.getInventory(MapleInventoryType.CASH).getItem(var3_5.csstar) == null) {
                        return;
                    }
                    v8 = a;
                    v9 = v8;
                    var12_18 = v8.getInventory(MapleInventoryType.CASH).getItem(var3_5.csstar).getItemId();
                } else {
                    var12_18 = var11_16;
                    v9 = a;
                }
                if (v9.getBuffedValue(MapleBuffStat.SPIRIT_CLAW) == null && a.getBuffedValue(MapleBuffStat.SPIRIT_CLAW) == null) {
                    var15_22 = var5_8;
                    if (var7_10 != null && var7_10.getBulletConsume() != 0) {
                        var15_22 = var7_10.getBulletConsume() * (var10_15 != null ? 2 : 1);
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 134 && a.getJob() == 412 && var15_22 > 0 && var14_20.getQuantity() < MapleItemInformationProvider.getInstance().getSlotMax(var11_16)) {
                        var16_23 = SkillFactory.getSkill(4120010);
                        if (GameSetConstants.MAPLE_VERSION >= 147) {
                            var16_23 = SkillFactory.getSkill(4110012);
                        }
                        if (a.getTotalSkillLevel(var16_23) > 0) {
                            v10 = var16_23;
                            var17_25 /* !! */  = v10.getEffect(a.getTotalSkillLevel(v10));
                            if (var17_25 /* !! */ .makeChanceResult()) {
                                v11 = var14_20;
                                v11.setQuantity((short)(v11.getQuantity() + 1));
                                v12 = a;
                                v12.sendPacket(MaplePacketCreator.modifyInventory(true, new ModifyInventory((int)true, var14_20), v12.getPlayer()));
                                var15_22 = 0;
                                v12.sendPacket(MaplePacketCreator.getInventoryStatus());
                            }
                        }
                    }
                    if (!GameSetConstants.isNoConsumeItem(var11_16) && !MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var11_16, var15_22, false, true)) {
                        return;
                    }
                }
            }
            ** GOTO lbl137
        }
        try {
            if (a.getJob() >= 3500 && a.getJob() <= 3512) {
                var12_18 = 2333000;
                v13 = var3_5;
            } else {
                if (GameConstants.isCannon(a.getJob())) {
                    var12_18 = 2333001;
                }
lbl137:
                // 4 sources

                v13 = var3_5;
            }
            if (v13.skill == 5211005) {
                if (GameSetConstants.SERVER_NAME.equals(SellSystem.ALLATORIxDEMO("\u51df\u82da\u8c58"))) {
                    if (!a.getPlayer().haveItem(2332000)) {
                        v14 = a;
                        v14.getPlayer().dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u5ba9\u51a8\u81db\u56d2\u4e76\u8dab"));
                        v14.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                } else if (!MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, 2332000, true ? 1 : 0, false, true)) {
                    v15 = a;
                    v15.getPlayer().dropMessage(5, SellSystem.ALLATORIxDEMO("\u5ba7\u51df\u81d5\u56a5\u4e78\u8ddc"));
                    v15.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
            } else if (var3_5.skill == 5211004) {
                if (GameSetConstants.SERVER_NAME.equals(MapleMessenger.ALLATORIxDEMO("\u51a8\u82d4\u8c2f"))) {
                    if (!a.getPlayer().haveItem(2331000)) {
                        v16 = a;
                        v16.getPlayer().dropMessage(5, SellSystem.ALLATORIxDEMO("\u701e\u70e1\u81d5\u56a5\u4e78\u8ddc"));
                        v16.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                } else if (!MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, 2331000, true ? 1 : 0, false, true)) {
                    v17 = a;
                    v17.getPlayer().dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u7010\u7096\u81db\u56d2\u4e76\u8dab"));
                    v17.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
            }
            var16_24 = 0;
            if (var11_16 != 0) {
                var16_24 = MapleItemInformationProvider.getInstance().getWatkForProjectile(var11_16);
            }
            var17_25 /* !! */  = a.getStat();
            switch (var3_5.skill) {
                case 4001344: 
                case 4121007: 
                case 14001004: 
                case 14111005: {
                    var14_21 = (float)var17_25 /* !! */ .getTotalLuk() * 5.0f * (float)(var17_25 /* !! */ .getTotalWatk() + var16_24) / 100.0f;
                    v18 = var7_10;
                    break;
                }
                case 4111004: {
                    var14_21 = 13000.0;
                    v18 = var7_10;
                    break;
                }
                default: {
                    v19 = var17_25 /* !! */ ;
                    if (var16_24 != 0) {
                        var14_21 = v19.calculateMaxBaseDamage(var17_25 /* !! */ .getTotalMagic(), var17_25 /* !! */ .getTotalWatk() + var16_24);
                        v20 = var3_5;
                    } else {
                        var14_21 = v19.getCurrentMaxBaseDamage();
                        v20 = var3_5;
                    }
                    switch (v20.skill) {
                        case 13101005: {
                            if (var7_10 == null) break;
                            var14_21 *= (double)var7_10.getX() / 100.0;
                            break;
                        }
                    }
                    v18 = var7_10;
                }
            }
            if (v18 != null) {
                var14_21 *= (double)var7_10.getDamage() / 100.0;
                a = var7_10.getMoneyCon();
                if (a != 0) {
                    if (a > a.getMeso()) {
                        a = a.getMeso();
                    }
                    a.gainMeso(-a, false);
                }
            }
            v21 = a;
            v21.checkFollow();
            v22 = a;
            v21.getMap().broadcastMessage(v22, MaplePacketCreator.rangedAttack(a, var6_9, var12_18, var3_5, a.getLevel(), a.getStat().passive_mastery()), v22.getPosition());
            DamageParse.applyAttack(var3_5, var8_11, a, var5_8, var14_21, var7_10, var10_15 != null ? AttackType.RANGED_WITH_SHADOWPARTNER : AttackType.RANGED);
            if (a.getLastUseSkill() != var3_5.skill) {
                a.setLastUseSkill(var3_5.skill);
            }
            a = a.getClones();
            var4_7 = 0;
            while (var4_7 < a.length) {
                if (a[var4_7].get() != null) {
                    var9_13 = (MapleCharacter)a[var4_7].get();
                    var10_15 = var8_11;
                    var11_17 = var7_10;
                    var18_27 = var14_21;
                    var13_19 = var5_8;
                    var16_24 = var12_18;
                    var17_26 = var6_9;
                    var20_28 = DamageParse.DivideAttack(var3_5, a.isGM() != false ? 1 : 4);
                    Timer.CloneTimer.getInstance().schedule(new Runnable(){
                        public final /* synthetic */ int a;
                        public final /* synthetic */ AttackInfo B;
                        public final /* synthetic */ ISkill k;
                        public final /* synthetic */ int g;
                        public final /* synthetic */ int E;
                        public final /* synthetic */ double d;
                        public final /* synthetic */ MapleStatEffect ALLATORIxDEMO;
                        public final /* synthetic */ MapleCharacter e;
                        public final /* synthetic */ MapleCharacter K;
                        {
                            2 a2;
                            2 v0 = a2;
                            2 v1 = a2;
                            2 v2 = a2;
                            a2.e = mapleCharacter;
                            v2.E = n2;
                            v2.g = n3;
                            v1.B = attackInfo;
                            v1.k = iSkill;
                            v0.K = mapleCharacter2;
                            v0.a = n4;
                            a2.d = d2;
                            a2.ALLATORIxDEMO = mapleStatEffect;
                        }

                        @Override
                        public /* synthetic */ void run() {
                            2 a2;
                            2 v0 = a2;
                            2 v1 = a2;
                            a2.e.getMap().broadcastMessage(MaplePacketCreator.rangedAttack(a2.e, v0.E, v1.g, v1.B, a2.e.getLevel(), a2.e.getStat().passive_mastery()));
                            2 v2 = a2;
                            2 v3 = a2;
                            DamageParse.applyAttack(v0.B, v2.k, v2.K, v3.a, v3.d, a2.ALLATORIxDEMO, AttackType.RANGED);
                        }
                    }, 500 * var4_7 + 500);
                }
                ++var4_7;
            }
            return;
        }
        catch (Exception var3_6) {
            var3_6.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void WingChange(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        if (GameSetConstants.MAPLE_VERSION < 151) ** GOTO lbl21
        if (a == null) return;
        if (a.getMap() == null) {
            return;
        }
        var3_3 = a.readInt();
        if (var3_3 == 5010094) {
            v0 = a;
            v0.setDressingUp(true);
            v1 = a;
            v0.getMap().broadcastMessage(v1, MaplePacketCreator.updateDress(var3_3, a), false);
            v2 = a;
            v1.getMap().broadcastMessage(v2, MaplePacketCreator.updateCharLook(v2, var3_3 == 5010094), false);
            v3 = a;
        } else {
            v4 = a;
            v4.setDressingUp(false);
            v5 = a;
            v4.getMap().broadcastMessage(v5, MaplePacketCreator.updateDress(var3_3, v5), false);
            v6 = a;
            v4.getMap().broadcastMessage(v6, MaplePacketCreator.updateCharLook(v6, false), false);
lbl21:
            // 2 sources

            v3 = a;
        }
        v3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void snowBall(LittleEndianAccessor a2, MapleClient a3) {
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void ChangeMap(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block63: {
            block65: {
                block81: {
                    block80: {
                        block79: {
                            block78: {
                                block77: {
                                    block76: {
                                        block75: {
                                            block74: {
                                                block73: {
                                                    block72: {
                                                        block71: {
                                                            block70: {
                                                                block69: {
                                                                    block68: {
                                                                        block67: {
                                                                            block66: {
                                                                                block64: {
                                                                                    block62: {
                                                                                        if (a == null) {
                                                                                            return;
                                                                                        }
                                                                                        if (a.getMap().isClosePortal() && a.isAlive()) {
                                                                                            a.sendPacket(MaplePacketCreator.enableActions());
                                                                                            return;
                                                                                        }
                                                                                        if (a.available() == 0L) return;
                                                                                        a.readByte();
                                                                                        var3_3 = a.readInt();
                                                                                        var4_4 = null;
                                                                                        try {
                                                                                            var4_4 = a.getMap().getPortal(a.readMapleAsciiString());
                                                                                            v0 = a;
                                                                                        }
                                                                                        catch (Exception var5_5) {
                                                                                            v0 = a;
                                                                                        }
                                                                                        v0.skip(1);
                                                                                        var5_6 = -1;
                                                                                        v1 = new int[3];
                                                                                        v1[0] = 5511001;
                                                                                        v1[1] = 5510000;
                                                                                        v1[2] = 5511000;
                                                                                        var6_8 = v1;
                                                                                        v2 = var7_9 = a.readShort() > 0 && MapConstants.isEventMap(a.getMapId()) == false;
                                                                                        if (var7_9) {
                                                                                            block61: {
                                                                                                var8_10 = var6_8;
                                                                                                var9_12 = ((int[])var6_8).length;
                                                                                                v3 = var10_15 = 0;
                                                                                                while (v3 < var9_12) {
                                                                                                    var11_17 = var8_10[var10_15];
                                                                                                    if (a.getItemQuantity(var11_17, false) > 0) {
                                                                                                        var7_9 = true;
                                                                                                        var5_6 = var11_17;
                                                                                                        v4 = a;
                                                                                                        break block61;
                                                                                                    }
                                                                                                    v3 = ++var10_15;
                                                                                                }
                                                                                                v4 = a;
                                                                                            }
                                                                                            if (!v4.canUseReviveItem()) {
                                                                                                a.dropMessage(-5, SellSystem.ALLATORIxDEMO("\u6b0b\u5745\u5779\u7154\u6cba\u4f0a\u7547\u53ea\u575f\u5fdc\u6d54\u8826\u306d"));
                                                                                                var7_9 = false;
                                                                                            }
                                                                                        }
                                                                                        var8_11 = false;
                                                                                        v5 = a;
                                                                                        v5.handleMonsterEffectCard();
                                                                                        v5.StopDpm();
                                                                                        if (var3_3 == -1 || a.isAlive()) break block62;
                                                                                        v6 = a;
                                                                                        v6.setStance(0);
                                                                                        a.getPlayer().updateWarpingMap(true);
                                                                                        if (v6.getEventInstance() != null && a.getEventInstance().revivePlayer(a) && a.isAlive()) {
                                                                                            return;
                                                                                        }
                                                                                        if (a.getPyramidSubway() != null) {
                                                                                            a.getStat().setHp(50);
                                                                                            a.getPyramidSubway().fail(a);
                                                                                            return;
                                                                                        }
                                                                                        var9_13 = a.getStatForBuff(MapleBuffStat.SOUL_STONE);
                                                                                        if (var9_13 != null) {
                                                                                            v7 = a;
                                                                                            v7.getClient().sendPacket(UIPacket.useSoulStone());
                                                                                            var10_15 = v7.getStat().getMaxHp() / 100 * var9_13.getX();
                                                                                            v7.getStat().setHp(var10_15);
                                                                                            v8 = a;
                                                                                            v8.cancelEffectFromBuffStat(MapleBuffStat.SOUL_STONE);
                                                                                            v8.updateSingleStat(MapleStat.HP, var10_15);
                                                                                            return;
                                                                                        }
                                                                                        if (var7_9) {
                                                                                            var10_15 = a.getStat().getMaxHp() / 100 * 40;
                                                                                            if (GameSetConstants.SERVER_NAME.equals(MapleMessenger.ALLATORIxDEMO("\u65cb\u871a\u4e30\u8c2f"))) {
                                                                                                var10_15 = a.getStat().getCurrentMaxHp();
                                                                                            }
                                                                                            if (var5_6 == 5511000 || var5_6 == 5511001 || a.getStat().getCurrentMaxHp() < 100) {
                                                                                                var10_15 = a.getStat().getCurrentMaxHp();
                                                                                            }
                                                                                            if (var5_6 == 5511001) {
                                                                                                var11_17 = 2002059 + Randomizer.nextInt(4);
                                                                                                v9 = MapleItemInformationProvider.getInstance().getItemEffect(var11_17);
                                                                                                var6_8 = v9;
                                                                                                if (v9 != null) {
                                                                                                    var6_8.applyTo(a);
                                                                                                }
                                                                                            }
                                                                                            a.getStat().setHp(var10_15);
                                                                                            a.updateSingleStat(MapleStat.HP, var10_15);
                                                                                            MapleInventoryManipulator.removeById(a, MapleInventoryType.CASH, 5510000, true ? 1 : 0, true, false);
                                                                                            a.dropMessage(-5, "\u539f\u5730\u5fa9\u6d3b\u8853\u6578\u91cf\u5269\u4e0b" + a.getInventory(MapleInventoryType.CASH).countById(5510000) + "\u500b\u3002");
                                                                                            return;
                                                                                        }
                                                                                        if (a.getCharm() <= 0) {
                                                                                            a.getStat().setHp(50);
                                                                                            v10 = a;
                                                                                            var10_16 = v10.getMap().getReturnMap();
                                                                                            v10.changeMap(var10_16, var10_16.getPortal(0));
                                                                                            return;
                                                                                        }
                                                                                        v11 = a;
                                                                                        var10_15 = v11.getStat().getCurrentMaxHp() / 100;
                                                                                        var11_17 = v11.getStat().getCurrentMaxMp() / 100;
                                                                                        if (v11.getStat().getCurrentMaxHp() < 100) {
                                                                                            var10_15 = a.getStat().getCurrentMaxHp();
                                                                                        }
                                                                                        if (a.getStat().getCurrentMaxMp() < 100) {
                                                                                            var11_17 = a.getStat().getCurrentMaxMp();
                                                                                        }
                                                                                        var5_6 = 0;
                                                                                        var7_9 = false;
                                                                                        switch (a.getCharm()) {
                                                                                            case 5130002: {
                                                                                                v12 = var5_6 = 30;
                                                                                                break;
                                                                                            }
                                                                                            case 5131000: {
                                                                                                var7_9 = Randomizer.nextBoolean();
                                                                                                var5_6 = 100;
                                                                                            }
                                                                                            default: {
                                                                                                v12 = var5_6;
                                                                                            }
                                                                                        }
                                                                                        if (v12 <= 0) {
                                                                                            v13 = a;
                                                                                            a.getStat().setHp(50);
                                                                                            v14 = v13;
                                                                                            v13.getStat().setMp(50);
                                                                                        } else {
                                                                                            v15 = a;
                                                                                            v14 = v15;
                                                                                            v15.getStat().setHp(var10_15 * var5_6);
                                                                                            a.getStat().setMp(var11_17 * var5_6);
                                                                                        }
                                                                                        var5_7 = v14.getMap().getReturnMap();
                                                                                        v16 = a;
                                                                                        v17 = var5_7;
                                                                                        v16.changeMap(v17, v17.getPortal(0));
                                                                                        if (v16.getCharm() != 5131000) ** GOTO lbl149
                                                                                        if (var7_9) {
                                                                                            var6_8 = MapleItemInformationProvider.getInstance().getItemEffect(2022569);
                                                                                            if (var6_8 != null) {
                                                                                                var6_8.applyTo(a);
                                                                                            }
                                                                                            a.sendPacket(UIPacket.ShowWZEffect2("Effect/ItemEff.img/" + a.getCharm() + "/0"));
                                                                                            v18 = a;
                                                                                        } else {
                                                                                            var6_8 = MapleItemInformationProvider.getInstance().getItemEffect(2022568);
                                                                                            if (var6_8 != null) {
                                                                                                var6_8.applyTo(a);
                                                                                            }
                                                                                            a.sendPacket(UIPacket.ShowWZEffect2("Effect/ItemEff.img/" + a.getCharm() + "/1"));
lbl149:
                                                                                            // 2 sources

                                                                                            v18 = a;
                                                                                        }
                                                                                        v18.setCharm(-1);
                                                                                        return;
                                                                                    }
                                                                                    if (var3_3 != -1 && a.isGM()) {
                                                                                        v19 = var9_14 = ChannelServer.getInstance(a.getWorld(), a.getChannel()).getMapFactory().getMap(var3_3);
                                                                                        a.changeMap(v19, v19.getPortal(0));
                                                                                        return;
                                                                                    }
                                                                                    if (var3_3 == -1 || a.isGM()) break block63;
                                                                                    var9_12 = a.getMapId() / 100;
                                                                                    var10_15 = 0;
                                                                                    var11_17 = 0;
                                                                                    if (var9_12 != 9130401) break block64;
                                                                                    v20 = var11_17 = var3_3 / 100 == 9130400 || var3_3 / 100 == 9130401 ? 1 : 0;
                                                                                    if (var3_3 / 10000 == 91304) ** GOTO lbl323
                                                                                    var11_17 = 1;
                                                                                    var10_15 = 1;
                                                                                    v21 = var3_3 = 130030000;
                                                                                    break block65;
                                                                                }
                                                                                if (var9_12 != 9130400) break block66;
                                                                                v22 = var11_17 = var3_3 / 100 == 9130400 || var3_3 / 100 == 9130401 ? 1 : 0;
                                                                                if (var3_3 / 10000 == 91304) ** GOTO lbl323
                                                                                var11_17 = 1;
                                                                                var10_15 = 1;
                                                                                v21 = var3_3 = 130030000;
                                                                                break block65;
                                                                            }
                                                                            if (var9_12 != 9140900) break block67;
                                                                            var11_17 = var3_3 == 914090011 || var3_3 == 914090012 || var3_3 == 914090013 || var3_3 == 140090000 ? 1 : 0;
                                                                            v21 = var3_3;
                                                                            break block65;
                                                                        }
                                                                        if (var9_12 != 9120601 && var9_12 != 9140602 && var9_12 != 9140603 && var9_12 != 9140604 && var9_12 != 9140605) break block68;
                                                                        var11_17 = var3_3 == 912060100 || var3_3 == 912060200 || var3_3 == 912060300 || var3_3 == 912060400 || var3_3 == 912060500 || var3_3 == 3000100 ? 1 : 0;
                                                                        var10_15 = 1;
                                                                        v21 = var3_3;
                                                                        break block65;
                                                                    }
                                                                    if (var9_12 != 9101500) break block69;
                                                                    var11_17 = var3_3 == 910150006 || var3_3 == 101050010 ? 1 : 0;
                                                                    var10_15 = 1;
                                                                    v21 = var3_3;
                                                                    break block65;
                                                                }
                                                                if (var9_12 != 9140901 || var3_3 != 140000000) break block70;
                                                                var10_15 = 1;
                                                                var11_17 = 1;
                                                                v21 = var3_3;
                                                                break block65;
                                                            }
                                                            if (var9_12 != 9240200 || var3_3 != 924020000) break block71;
                                                            var10_15 = 1;
                                                            var11_17 = 1;
                                                            v21 = var3_3;
                                                            break block65;
                                                        }
                                                        if (var3_3 != 980040000 || var9_12 < 9800410 || var9_12 > 9800450) break block72;
                                                        var11_17 = 1;
                                                        v21 = var3_3;
                                                        break block65;
                                                    }
                                                    if (var9_12 != 9140902 || var3_3 != 140030000 && var3_3 != 140000000) break block73;
                                                    var10_15 = 1;
                                                    var11_17 = 1;
                                                    v21 = var3_3;
                                                    break block65;
                                                }
                                                if (var9_12 != 9000900 || var3_3 / 100 != 9000900 || var3_3 <= a.getMapId()) break block74;
                                                var11_17 = 1;
                                                v21 = var3_3;
                                                break block65;
                                            }
                                            if (var9_12 / 1000 != 9000 || var3_3 / 100000 != 9000) break block75;
                                            var10_15 = var3_3 < 900090000 || var3_3 > 900090004 ? 1 : 0;
                                            var11_17 = 1;
                                            v21 = var3_3;
                                            break block65;
                                        }
                                        if (var9_12 / 10 != 1020 || var3_3 != 1020000) break block76;
                                        var10_15 = 1;
                                        var11_17 = 1;
                                        v21 = var3_3;
                                        break block65;
                                    }
                                    if (a.getMapId() != 900090101 || var3_3 != 100030100) break block77;
                                    var10_15 = 1;
                                    var11_17 = 1;
                                    v21 = var3_3;
                                    break block65;
                                }
                                if (a.getMapId() != 2010000 || var3_3 != 104000000) break block78;
                                var10_15 = 1;
                                var11_17 = 1;
                                v21 = var3_3;
                                break block65;
                            }
                            if (a.getMapId() != 912060300 || var3_3 != 912060400) break block79;
                            var10_15 = 1;
                            var11_17 = 1;
                            v21 = var3_3;
                            break block65;
                        }
                        if (a.getMapId() != 912060400 || var3_3 != 912060500) break block80;
                        var10_15 = 1;
                        var11_17 = 1;
                        v21 = var3_3;
                        break block65;
                    }
                    if (a.getMapId() != 106020001 && a.getMapId() != 106020502) break block81;
                    if (var3_3 != a.getMapId() - 1) ** GOTO lbl323
                    var10_15 = 1;
                    var11_17 = 1;
                    v21 = var3_3;
                    break block65;
                }
                if (a.getMapId() == 0 && var3_3 == 10000) {
                    var10_15 = 1;
                    var11_17 = 1;
                    v21 = var3_3;
                } else if (a.getMapId() == 931000011 && var3_3 == 931000012) {
                    var10_15 = 1;
                    var11_17 = 1;
                    v21 = var3_3;
                } else if (a.getMapId() == 931000021 && var3_3 == 931000030) {
                    var10_15 = 1;
                    var11_17 = 1;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020100) {
                    var11_17 = var3_3 == 743030000 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020101) {
                    var11_17 = var3_3 == 743030002 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020102) {
                    var11_17 = var3_3 == 743000203 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020103) {
                    var11_17 = var3_3 == 743020402 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020200) {
                    var11_17 = var3_3 == 743030001 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020201) {
                    var11_17 = var3_3 == 743030003 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020401) {
                    var11_17 = var3_3 == 743030201 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743020400) {
                    var11_17 = var3_3 == 743020000 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743000600) {
                    var11_17 = var3_3 == 743000600 ? 1 : 0;
                    v21 = var3_3;
                } else if (a.getMapId() == 743000610) {
                    var11_17 = var3_3 == 743000600 ? 1 : 0;
                    v21 = var3_3;
                } else {
                    if (a.getMapId() == 913070071) {
                        var11_17 = var3_3 == 130000000 ? 1 : 0;
                        var8_11 = true;
                    }
lbl323:
                    // 6 sources

                    v21 = var3_3;
                }
            }
            if (v21 == 912060500) {
                var8_11 = true;
            }
            if (var10_15 != 0) {
                v23 = a;
                v23.sendPacket(UIPacket.IntroDisableUI(false));
                v23.sendPacket(UIPacket.IntroLock(false));
                v23.sendPacket(MaplePacketCreator.enableActions());
            }
            if (var8_11) {
                a.sendPacket(UIPacket.IntroEnableUI(false));
            }
            if (var11_17 == 0) return;
            v24 = var6_8 = (Object)ChannelServer.getInstance(a.getWorld(), a.getChannel()).getMapFactory().getMap(var3_3);
            a.changeMap((MapleMap)v24, v24.getPortal(0));
            return;
        }
        if (var4_4 != null) {
            var4_4.enterPortal(a);
            return;
        }
        a.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void ReIssueMedal(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a2.available() >= 2L) {
            MapleQuest mapleQuest = MapleQuest.getInstance(a2.readShort());
            if (mapleQuest != null && mapleQuest.getMedalItem() > 0 && a4.getQuestStatus(mapleQuest.getId()) == 2 && !a4.haveItem(mapleQuest.getMedalItem(), true ? 1 : 0, true, true) && mapleQuest.getMedalItem() == a2.readInt() && MapleInventoryManipulator.checkSpace(a3, mapleQuest.getMedalItem(), 1, "")) {
                MapleInventoryManipulator.addById(a3, mapleQuest.getMedalItem(), (short)1, "Redeemed item through medal quest " + mapleQuest.getId() + " on " + FileoutputUtil.CurrentReadable_Date());
            }
            a3.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public static final /* synthetic */ void CancelBuffHandler(int a2, MapleCharacter a3) {
        ISkill iSkill;
        if (a3 == null) {
            return;
        }
        if (a2 == 35001002 && a3.getSkillLevel(SkillFactory.getSkill(35120000)) > 0) {
            a2 = 35120000;
        }
        if ((iSkill = SkillFactory.getSkill(a2)) != null) {
            if (iSkill.isChargeSkill()) {
                MapleCharacter mapleCharacter = a3;
                mapleCharacter.setKeyDownSkill_Time(0L);
                MapleCharacter mapleCharacter2 = a3;
                mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.skillCancel(mapleCharacter2, a2), false);
                return;
            }
            a3.cancelEffect(iSkill.getEffect(1), false, -1L);
        }
    }

    public static /* synthetic */ void specialAttack(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4 == null || a4.getMap() == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        int n4 = littleEndianAccessor.readInt();
        n4 = littleEndianAccessor.readInt();
        int n5 = littleEndianAccessor.readInt();
        int n6 = littleEndianAccessor.readInt();
        ISkill iSkill = SkillFactory.getSkill(GameConstants.getLinkedAttackSkill(n5));
        int n7 = a4.getTotalSkillLevel(iSkill);
        if (a3.getPlayer().isAdmin()) {
            System.err.println("[SpecialAttack] - \u6280\u80fdID: " + n5 + " \u6280\u80fd\u7b49\u7d1a: " + n7);
        }
        if (iSkill == null || n7 <= 0) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            mapleClient.getPlayer().marriage();
            return;
        }
        MapleCharacter mapleCharacter = a4;
        MapleCharacter mapleCharacter2 = a4;
        mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.showBuffEffect(mapleCharacter2.getId(), n5, 1, a4.getLevel(), n7), false);
        MapleCharacter mapleCharacter3 = a4;
        mapleCharacter.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.showSpecialAttack(a4.getId(), n2, n3, n4, n5, n6), mapleCharacter3.getTruePosition());
    }

    public static final /* synthetic */ void leftKnockBack(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().getMapId() / 10000 == 10906) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.leftKnockBack());
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public static final /* synthetic */ void InnerPortal(LittleEndianAccessor a2, MapleClient a322, MapleCharacter a4) {
        short s2;
        short s3;
        Object a322;
        block6: {
            block5: {
                try {
                    if (a4 != null) break block5;
                    return;
                }
                catch (Exception a322) {
                    a322.printStackTrace();
                    return;
                }
            }
            MapleCharacter mapleCharacter = a4;
            mapleCharacter.updateUsingPortal(true);
            a322 = mapleCharacter.getMap().getPortal(a2.readMapleAsciiString());
            Point point = mapleCharacter.getPosition();
            LittleEndianAccessor littleEndianAccessor = a2;
            s3 = littleEndianAccessor.readShort();
            s2 = littleEndianAccessor.readShort();
            if (a322 != null) break block6;
            return;
        }
        if (a322.getPosition().distanceSq(a4.getPosition()) > 22500.0) {
            a4.getCheatTracker().registerOffense(CheatingOffense.USING_FARAWAY_PORTAL);
        }
        MapleCharacter mapleCharacter = a4;
        mapleCharacter.getMap().movePlayer(a4, new Point(s3, s2));
        mapleCharacter.checkFollow();
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, Point a3) {
        boolean bl;
        boolean bl2 = bl = ((Point)a3).y > a2.getPlayer().getOldPosition().y && Math.abs(((Point)a3).x - a2.getPlayer().getOldPosition().x) < 5;
        if (!bl && a2.getPlayer().getBuffSource(MapleBuffStat.DARK_AURA) == 32120000) {
            a2.getPlayer().getStatForBuff(MapleBuffStat.DARK_AURA).applyMonsterBuff(a2.getPlayer());
        } else if (!bl && a2.getPlayer().getBuffSource(MapleBuffStat.YELLOW_AURA) == 32120001) {
            a2.getPlayer().getStatForBuff(MapleBuffStat.YELLOW_AURA).applyMonsterBuff(a2.getPlayer());
        }
        if (GameSetConstants.MAPLE_VERSION >= 143 && a2.getPlayer().getParty() != null) {
            a3 = a2.getPlayer().getParty().getOnlineMembers().iterator();
            block0: while (true) {
                Object object = a3;
                while (object.hasNext()) {
                    MapleStatEffect mapleStatEffect;
                    block16: {
                        int n2;
                        MapleBuffStat mapleBuffStat;
                        int n3;
                        int n4;
                        MapleBuffStat[] arrmapleBuffStat;
                        Serializable serializable = (MaplePartyCharacter)a3.next();
                        if (serializable == null || ((MaplePartyCharacter)serializable).getId() == a2.getPlayer().getId() || a2.getPlayer().getMap().getCharacterById(((MaplePartyCharacter)serializable).getId()) == null || (serializable = ((MaplePartyCharacter)serializable).getChr()) == null) continue block0;
                        if (((AbstractMapleMapObject)((Object)serializable)).getPosition().distance(a2.getPlayer().getPosition()) > 100.0) {
                            object = a3;
                            continue;
                        }
                        Serializable serializable2 = null;
                        mapleStatEffect = null;
                        MapleBuffStat[] arrmapleBuffStat2 = new MapleBuffStat[3];
                        arrmapleBuffStat2[0] = MapleBuffStat.DARK_AURA;
                        arrmapleBuffStat2[1] = MapleBuffStat.YELLOW_AURA;
                        arrmapleBuffStat2[2] = MapleBuffStat.BLUE_AURA;
                        MapleBuffStat[] arrmapleBuffStat3 = arrmapleBuffStat2;
                        if (JobConstants.is\u7149\u7344\u5deb\u5e2b(((MapleCharacter)serializable).getJob())) {
                            arrmapleBuffStat = arrmapleBuffStat3;
                            n4 = arrmapleBuffStat3.length;
                            int n5 = n3 = 0;
                            while (n5 < n4) {
                                mapleBuffStat = arrmapleBuffStat[n3];
                                if (((MapleCharacter)serializable).getBuffedValue(mapleBuffStat) != null && a2.getPlayer().getBuffedValue(mapleBuffStat) == null) {
                                    n2 = ((MapleCharacter)serializable).getBuffSource(mapleBuffStat);
                                    if (SkillFactory.getSkill(n2) != null) {
                                        mapleStatEffect = SkillFactory.getSkill(n2).getEffect(((MapleCharacter)serializable).getTotalSkillLevel(n2));
                                    }
                                    break;
                                }
                                serializable2 = a2.getPlayer();
                                n5 = ++n3;
                            }
                        } else if (JobConstants.is\u7149\u7344\u5deb\u5e2b(a2.getPlayer().getJob())) {
                            Serializable serializable3;
                            arrmapleBuffStat = arrmapleBuffStat3;
                            n4 = arrmapleBuffStat3.length;
                            int n6 = n3 = 0;
                            while (n6 < n4) {
                                mapleBuffStat = arrmapleBuffStat[n3];
                                if (a2.getPlayer().getBuffedValue(mapleBuffStat) != null && ((MapleCharacter)serializable).getBuffedValue(mapleBuffStat) == null) {
                                    n2 = a2.getPlayer().getBuffSource(mapleBuffStat);
                                    mapleStatEffect = SkillFactory.getSkill(n2).getEffect(a2.getPlayer().getTotalSkillLevel(n2));
                                    serializable3 = serializable;
                                    break block16;
                                }
                                n6 = ++n3;
                            }
                            serializable3 = serializable2 = serializable;
                        }
                    }
                    if (mapleStatEffect == null) {
                        object = a3;
                        continue;
                    }
                    mapleStatEffect.applyTo(a2.getPlayer());
                    continue block0;
                }
                break;
            }
        }
    }

    public static /* synthetic */ void UserForceAtomCollision(LittleEndianAccessor a2, MapleClient a3) {
        a3 = ((MapleClient)a3).getPlayer();
        int n2 = a2.readInt();
        n2 = ((MapleCharacter)a3).getJob();
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            int n3;
            int n4 = -1;
            if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(n2)) {
                n3 = n4 = 65111007;
            } else {
                if (JobConstants.is\u5e7b\u5f71\u4fe0\u76dc(n2)) {
                    n4 = ((MapleCharacter)a3).getSkillLevel(24120002) > 0 ? 24120002 : 24100003;
                }
                n3 = n4;
            }
            if (n3 == -1) {
                return;
            }
            Object object = SkillFactory.getSkill(n4);
            int n5 = ((MapleCharacter)a3).getSkillLevel((ISkill)object);
            if (n5 <= 0 && (n5 = ((MapleCharacter)a3).getSkillLevel((ISkill)(object = SkillFactory.getSkill(SkillConstants.getLinkedSkill(n4))))) <= 0) {
                return;
            }
            if ((object = object.getEffect(n5)) == null) {
                return;
            }
            switch (n4) {
                case 65111007: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    n4 = littleEndianAccessor.readInt();
                    n4 = littleEndianAccessor.readByte();
                    n4 = littleEndianAccessor.readInt();
                    MapleMonster mapleMonster = ((MapleCharacter)a3).getMap().getMonsterByOid(n4);
                    if (mapleMonster == null) {
                        return;
                    }
                    Object object2 = object;
                    Object object3 = a3;
                    if (!((MapleStatEffect)object2).makeChanceResult((MapleCharacter)object3, ((MapleStatEffect)object2).getProp() + (((MapleCharacter)object3).getSkillLevel(65120044) > 0 ? SkillFactory.getSkill(65120044).getEffect(1).getProp() : 0))) break;
                    Object object4 = a3;
                    ((MapleCharacter)a3).getMap().broadcastMessage((MapleCharacter)object4, MaplePacketCreator.DrainSoul((MapleCharacter)object4, mapleMonster.getObjectId(), null, 2, ((MapleStatEffect)object).getBulletCount(), 65111007, 0, true), true);
                    return;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void handleMysticDoorWarp(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        if (a3.getPlayer().getTrade() != null || a3.getPlayer().getPlayerShop() != null || a3.getPlayer().getMap() == null) {
            return;
        }
        MapleMap mapleMap = null;
        MaplePortal maplePortal = null;
        boolean bl = false;
        for (MaplePortal maplePortal2 : a3.getPlayer().getMap().getPortals()) {
            if (!maplePortal2.getName().startsWith(MapleMessenger.ALLATORIxDEMO("\u0016q\bl\u0012{"))) continue;
            maplePortal = maplePortal2;
            bl = true;
        }
        if (!bl) {
            return;
        }
        int n3 = a2.readInt();
        int n4 = -1;
        switch (n3) {
            case 1: {
                n2 = n4 = 100000000;
                break;
            }
            case 2: {
                n2 = n4 = 400000000;
                break;
            }
            case 3: {
                n4 = 240000000;
            }
            default: {
                n2 = n4;
            }
        }
        if (n2 != -1 && n4 != a3.getPlayer().getMapId()) {
            MapleClient mapleClient = a3;
            mapleMap = mapleClient.getChannelServer().getMapFactory().getMap(n4);
            mapleClient.getPlayer().changeMap(mapleMap, maplePortal);
        }
    }

    public static /* synthetic */ void togglePVP(LittleEndianAccessor a2, MapleClient a3) {
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void CheckMove(MapleCharacter a2, Point a3, Point a4) {
        block6: {
            MapleCharacter mapleCharacter;
            double d2;
            double d3;
            double d4;
            block9: {
                block8: {
                    double d5;
                    block7: {
                        if (a2.checkUsingMoveskillTime()) break block6;
                        Point point = a4;
                        Point point2 = a3;
                        a2.setDirection(point2.x - a4.x);
                        d4 = point2.getX();
                        d3 = point.getX();
                        d2 = a3.getY();
                        d5 = point.getY();
                        d4 = Math.abs(d3 - d4);
                        d3 = Math.abs(d5 - d2);
                        d2 = 200.0;
                        d5 = 380.0;
                        if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a2.getJob()) || a2.isGlidingDragon()) {
                            d2 = 255.0;
                        }
                        if ((a2.hasBuff(61111008) || a2.hasBuff(61121053)) && a2.hasBuffedValue(MapleBuffStat.MORPH)) {
                            return;
                        }
                        if (a2.checkUsingPortal() || a2.checkWarpingMap() && !(d4 > 2000.0)) break block6;
                        if (!(d4 > d2) && !(d3 > d5)) break block7;
                        MapleCharacter mapleCharacter2 = a2;
                        mapleCharacter2.addMove();
                        if (!mapleCharacter2.isStaff() || a2.isGM()) break block8;
                        a2.dropMessage(5, "[\u89f8\u767c] x: " + d4 + " y:" + d3 + " \u6b21\u6578: " + a2.getAddMove() + " \u5224\u65b7: " + d2 + ", " + d5);
                        mapleCharacter = a2;
                        break block9;
                    }
                    if (a2.getWalkDebugMessage()) {
                        a2.dropMessage(5, "[\u672a\u89f8\u767c] x: " + d4 + " y:" + d3 + " \u6b21\u6578: " + a2.getAddMove() + " \u5224\u65b7: " + d2 + ", " + d5);
                    }
                }
                mapleCharacter = a2;
            }
            if (mapleCharacter.getAddMove() > 4 && GameSetConstants.CHECKMOVE) {
                MapleCharacter mapleCharacter3;
                MapleCharacter mapleCharacter4 = a2;
                if (a2.isPlayer()) {
                    mapleCharacter4.getClient().getSession().close();
                    World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("\u73a9\u5bb6[" + a2.getName() + "] \u5730\u5716[" + a2.getMapId() + "] \u539f\u59cb\u5ea7\u6a19[" + a3.getX() + "," + a3.getY() + "] \u65b0\u5ea7\u6a19[" + a4.getX() + "," + a4.getY() + "] \u76f8\u5deex:" + d4 + " \u76f8\u5deey:" + d3 + " \u670d\u52d9\u7aef\u9810\u8a08: " + d2));
                    mapleCharacter3 = a2;
                } else {
                    mapleCharacter4.dropMessage(5, SellSystem.ALLATORIxDEMO("\u898d\u7613\u819f\u52ba\u65c2\u7db5"));
                    mapleCharacter3 = a2;
                }
                FileoutputUtil.logToFile("logs/Hack/\u79fb\u52d5\u7570\u5e38/" + mapleCharacter3.getName() + ".txt", FileoutputUtil.CurrentReadable_Time() + " \u73a9\u5bb6[" + a2.getName() + "] \u5730\u5716[" + a2.getMapId() + "] \u539f\u59cb\u5ea7\u6a19[" + a3.getX() + "," + a3.getY() + "] \u65b0\u5ea7\u6a19[" + a4.getX() + "," + a4.getY() + "] \u76f8\u5deex:" + d4 + " \u76f8\u5deey:" + d3 + " \u670d\u52d9\u7aef\u9810\u8a08: " + d2);
                a2.clearAddMove();
            }
        }
    }

    public static /* synthetic */ void SelectExpChair(LittleEndianAccessor a2, MapleCharacter a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        int n4 = littleEndianAccessor.readInt();
        boolean bl = true;
        IItem iItem = a3.getInventory(GameConstants.getInventoryType(n2)).findByUniqueId(n3);
        if (iItem != null && iItem.getItemId() == n2) {
            MapleCharacter mapleCharacter;
            if (a3.getExpChairSelect() == n3) {
                bl = false;
                MapleCharacter mapleCharacter2 = a3;
                mapleCharacter = mapleCharacter2;
                mapleCharacter2.setExpChairSelect(0);
            } else {
                MapleCharacter mapleCharacter3 = a3;
                mapleCharacter = mapleCharacter3;
                mapleCharacter3.setExpChairSelect(n3);
            }
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.selectExpChair(n2, n3, n4, bl));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void closeRangeAttack(LittleEndianAccessor a, MapleClient a, MapleCharacter a, boolean a) {
        try {
            block43: {
                block46: {
                    block44: {
                        block45: {
                            if (a == null) {
                                return;
                            }
                            if (a) {
                                var4_5 = a.getBuffedValue(MapleBuffStat.ENERGY_CHARGE);
                                var5_8 = 10000;
                                if (var4_5 != null && var4_5 < 10000) {
                                    a.getCheatTracker().registerOffense(CheatingOffense.ATTACKMOB_ENERGY_HACK, "\u84c4\u80fd\u6fc0\u767c\u653b\u64ca\u7570\u5e38, \u76ee\u524d\u80fd\u91cf\u503c[" + var4_5 + "] \u6700\u9ad8\u80fd\u91cf\u503c[10000]");
                                    return;
                                }
                            }
                            if (GameSetConstants.DAMAGE_SKIN) {
                                AttackFont.sendFontStyle(a);
                            }
                            var5_8 = 1;
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                var4_6 = a.getBuffedValue(MapleBuffStat.SHADOWPARTNER) != null;
                                v0 = a;
                            } else {
                                var4_6 = a.getBuffedValue(MapleBuffStat.MIRROR_IMAGE) != null;
                                v0 = a;
                            }
                            if (!v0.isAlive() || a.getMap() == null) {
                                a.getCheatTracker().registerOffense(CheatingOffense.ATTACKING_WHILE_DEAD);
                                return;
                            }
                            var5_9 = DamageParse.Modify_AttackCrit(DamageParse.parseDmg(a, DamageParse.DamageType.CLOSE_RANGE_ATTACK, a), a, 1);
                            if (var5_9 == null) {
                                a.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            if (a.getMap().skillDisabled() && var5_9.skill != 0 && var5_9.skill != 2301002) {
                                a.getStat().setMp(0);
                                v1 = a;
                                a.updateSingleStat(MapleStat.MP, 0);
                                v1.getDiseaseBuff(MobSkill.getByMobSkill(120), MobSkillFactory.getMobSkill(120, 1));
                                v1.dropMessage(SellSystem.ALLATORIxDEMO("\u6b0b\u5745\u5779\u769b\u5222\u79f4\u6b0d\u4f0a\u7547\u4e8e\u4f3a\u62f5\u8092"));
                                a.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            if (!SkillCollector.getInstance().isExistSkill(1, var5_9.skill)) {
                                a.getCheatTracker().registerOffense(CheatingOffense.ATTACK_TYPE_ERROR, "\u6280\u80fd: " + var5_9.skill + " \u7a2e\u985e: 1");
                                SkillCollector.getInstance().addSkill(1, var5_9.skill);
                                return;
                            }
                            var6_10 = a.getStat().getCurrentMaxBaseDamage();
                            var8_11 = 1;
                            var9_12 = 0;
                            var10_13 = null;
                            var11_14 = null;
                            if (var5_9.skill == 0) ** GOTO lbl71
                            var11_14 = SkillFactory.getSkill(SkillConstants.getLinkedSkill(var5_9.skill));
                            if (var11_14 != null && (var9_12 = a.getSkillLevel(var11_14)) == 0 && a.containsBindingBySkillid(var5_9.skill)) {
                                var9_12 = 1;
                            }
                            if ((var10_13 = var5_9.getAttackEffect(a, var9_12, var11_14)) == null) {
                                return;
                            }
                            if ((a.getStat().combatOrders > 0 || a.getStat().incAllskill > 0) && var10_13 != null && SkillFactory.getSkill(var10_13.getSourceId()).getEffect(var10_13.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill) != null) {
                                var10_13 = SkillFactory.getSkill(var10_13.getSourceId()).getEffect(var10_13.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill);
                            }
                            var6_10 *= (double)var10_13.getDamage() / 100.0;
                            var8_11 = DamageParse.getAttackCount(a, var5_9.skill, var5_9);
                            if (var10_13.getCooldown(a) <= 0 || a) ** GOTO lbl64
                            if (a.skillisCooling(var5_9.skill) && var5_9.skill != 4341003 && var5_9.skill != 24121005 && var5_9.skill != 32121003 && var5_9.skill != 65121003 && var5_9.skill != 61120007 && var5_9.skill != 61101002 && var5_9.skill != 61121217) {
                                a.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            if (a.isAdmin() || a.isInvincible()) {
                                a.dropMessage("\u4f3a\u670d\u5668\u7ba1\u7406\u54e1\u6216\u7121\u6575\u72c0\u614b\u6d88\u9664\u6280\u80fd\u51b7\u537b[" + SkillFactory.getName(var5_9.skill) + "(" + var5_9.skill + ")]\uff0c\u6301\u7e8c\u6642\u9593\uff1a" + var10_13.getCooldown(a) + "\u79d2");
                                v2 = var5_9;
                            } else {
                                a.sendPacket(MaplePacketCreator.skillCooldown(var5_9.skill, var10_13.getCooldown(a)));
                                a.addCooldown(var5_9.skill, System.currentTimeMillis(), var10_13.getCooldown(a) * 1000);
lbl64:
                                // 2 sources

                                v2 = var5_9;
                            }
                            if (SkillConstants.is\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd(v2.skill)) {
                                v3 = var8_11;
                                a.getPlayer().getCheatTracker().check\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd();
                            } else {
                                if (SkillConstants.is\u5730\u5716\u77ac\u79fb(var5_9.skill)) {
                                    a.getPlayer().getCheatTracker().check\u5730\u5716\u77ac\u79fb();
                                }
lbl71:
                                // 4 sources

                                v3 = var8_11;
                            }
                            var8_11 = v3 * (var4_6 != false ? 2 : 1);
                            if (a) break block43;
                            if ((a.getMapId() == 109060000 || a.getMapId() == 109060002 || a.getMapId() == 109060004) && var5_9.skill == 0) {
                                MapleSnowball.MapleSnowballs.hitSnowball(a);
                            }
                            var12_15 = 0;
                            v4 = a;
                            var13_18 = v4.getBuffedValue(MapleBuffStat.COMBO);
                            var14_20 /* !! */  = v4.getBuffSource(MapleBuffStat.COMBO);
                            if (PlayerHandler.isFinisher(var5_9.skill) > 0) {
                                if (var13_18 != null) {
                                    var12_15 = var13_18 - 1;
                                }
                                if (SkillConstants.is\u9b25\u6c23\u653b\u64ca(var5_9.skill)) {
                                    a.handleOrbConsume(var14_20 /* !! */ , var5_9.skill);
                                }
                            }
                            if (GameSetConstants.MAPLE_VERSION >= 134 || var5_9.targets <= 0 || var5_9.skill != 1211002) break block44;
                            var15_21 = a.getSkillLevel(SkillFactory.getSkill(1220010));
                            if (var15_21 <= 0) break block45;
                            if (SkillFactory.getSkill(1220010).getEffect(var15_21).makeChanceResult()) break block44;
                            v5 = var12_15;
                            v6 = a;
                            v6.cancelEffectFromBuffStat(MapleBuffStat.WK_CHARGE);
                            v6.cancelEffectFromBuffStat(MapleBuffStat.LIGHTNING_CHARGE);
                            break block46;
                        }
                        v7 = a;
                        v7.cancelEffectFromBuffStat(MapleBuffStat.WK_CHARGE);
                        v7.cancelEffectFromBuffStat(MapleBuffStat.LIGHTNING_CHARGE);
                    }
                    v5 = var12_15;
                }
                if (v5 > 0) {
                    var6_10 *= (double)var12_15;
                    v8 = var5_9;
                } else {
                    if (var13_18 != null) {
                        if (a.getPlayer().getJob() == 1110 || a.getPlayer().getJob() == 1111 || a.getPlayer().getJob() == 1112) {
                            var15_22 = SkillFactory.getSkill(11111001);
                            v9 = a;
                        } else {
                            var15_22 = SkillFactory.getSkill(1111002);
                            v9 = a;
                        }
                        if (v9.getPlayer().getSkillLevel(var15_22) > 0) {
                            v10 = var15_22;
                            var6_10 *= 1.0 + ((double)v10.getEffect(a.getPlayer().getSkillLevel(v10)).getDamage() / 100.0 - 1.0) * (double)(var13_18 - 1);
                        }
                    }
                    v8 = var5_9;
                }
                if (PlayerHandler.isFinisher(v8.skill) > 0) {
                    if (var12_15 == 0) {
                        return;
                    }
                    var6_10 = GameSetConstants.MAX_DAMAGE;
                }
            }
            a.checkFollow();
            switch (var5_9.skill) {
                case 1092: 
                case 1094: {
                    var9_12 = 1;
                    break;
                }
            }
            v11 = a;
            v12 = a;
            a.getMap().broadcastMessage(v12, MaplePacketCreator.closeRangeAttack(v11, v11.getId(), var9_12, var5_9, a, a.getLevel(), a.getStat().passive_mastery()), v12.getPosition());
            try {
                DamageParse.applyAttack(var5_9, var11_14, a.getPlayer(), var8_11, var6_10, var10_13, var4_6 != false ? AttackType.NON_RANGED_WITH_MIRROR : AttackType.NON_RANGED);
                v13 = a;
            }
            catch (Exception var12_16) {
                v13 = a;
                var12_16.printStackTrace();
            }
            if (v13.getLastUseSkill() != var5_9.skill) {
                a.setLastUseSkill(var5_9.skill);
            }
            var12_17 = a.getClones();
            var13_19 = 0;
            while (var13_19 < var12_17.length) {
                if (var12_17[var13_19].get() != null) {
                    var14_20 /* !! */  = (MapleCharacter)var12_17[var13_19].get();
                    var15_23 = var11_14;
                    a = var9_12;
                    var16_24 = var8_11;
                    var17_25 = var6_10;
                    var19_26 = var10_13;
                    var20_27 = DamageParse.DivideAttack(var5_9, a.isGM() != false ? 1 : 4);
                    Timer.CloneTimer.getInstance().schedule(new Runnable(){
                        public final /* synthetic */ MapleStatEffect d;
                        public final /* synthetic */ double a;
                        public final /* synthetic */ boolean g;
                        public final /* synthetic */ int K;
                        public final /* synthetic */ AttackInfo E;
                        public final /* synthetic */ boolean ALLATORIxDEMO;
                        public final /* synthetic */ int e;
                        public final /* synthetic */ MapleCharacter H;
                        public final /* synthetic */ MapleCharacter k;
                        public final /* synthetic */ ISkill B;
                        {
                            1 a2;
                            1 v0 = a2;
                            1 v1 = a2;
                            1 v2 = a2;
                            1 v3 = a2;
                            v3.H = mapleCharacter;
                            v3.e = n2;
                            v2.E = attackInfo;
                            v2.g = bl;
                            v1.B = iSkill;
                            v1.k = mapleCharacter2;
                            v0.K = n3;
                            v0.a = d2;
                            a2.d = mapleStatEffect;
                            a2.ALLATORIxDEMO = bl2;
                        }

                        @Override
                        public /* synthetic */ void run() {
                            1 a2;
                            1 v0 = a2;
                            1 v1 = a2;
                            1 v2 = a2;
                            a2.H.getMap().broadcastMessage(MaplePacketCreator.closeRangeAttack(a2.H, v0.H.getId(), v1.e, v1.E, v2.g, v2.H.getLevel(), a2.H.getStat().passive_mastery()));
                            1 v3 = a2;
                            1 v4 = a2;
                            1 v5 = a2;
                            DamageParse.applyAttack(v0.E, v3.B, v3.k, v4.K, v4.a, v5.d, v5.ALLATORIxDEMO ? AttackType.NON_RANGED_WITH_MIRROR : AttackType.NON_RANGED);
                        }
                    }, 500 * var13_19 + 500);
                }
                ++var13_19;
            }
            return;
        }
        catch (Exception var4_7) {
            var4_7.printStackTrace();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void SpecialMove(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        if (a == null || !a.isAlive() || a.getMap() == null) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        v0 = a;
        v0.skip(4);
        var4_4 = var3_3 = v0.readInt();
        if (var3_3 >= 91000000) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var3_3 == 20031205 && !a.canShroudWalk()) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        var5_6 = SkillFactory.getSkill(var3_3);
        if (FieldLimitType.MovementSkills.check(a.getMap().getFieldLimit()) && var5_6.isMovement()) {
            v1 = a;
            v1.getDiseaseBuff(MobSkill.getByMobSkill(120), MobSkillFactory.getMobSkill(120, 1));
            v1.dropMessage(SellSystem.ALLATORIxDEMO("\u6b11\u575f\u5763\u7681\u5238\u79ee\u6b17\u4f10\u755d\u4e94\u4f20\u7994\u52a0\u62ef\u8088N"));
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        switch (var3_3) {
            case 5201005: 
            case 5201011: 
            case 20010022: 
            case 30010110: 
            case 30010183: 
            case 30010184: 
            case 30010186: {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
        }
        a.getCheatTracker().UpdateBuffTime();
        if (GameSetConstants.REINCARNATION_SKILL_SYSTEM && GameSetConstants.isReincarnationSkill(var3_3)) {
            if (GameSetConstants.REINCARNATION_SKILL_EQUIP == 0 || a.hasEquipped(GameSetConstants.REINCARNATION_SKILL_EQUIP)) {
                if (a.getMap().countMonsterById(GameSetConstants.REINCARNATION_SKILL_MOB) == 0) {
                    var6_7 = MapleLifeFactory.getMonster(GameSetConstants.REINCARNATION_SKILL_MOB);
                    a.getMap().spawnMonsterOnGroundBelow(var6_7, a.getPosition());
                } else {
                    a.dropMessage(MapleMessenger.ALLATORIxDEMO("\u574b\u570e\u4e71\u5dea\u6772\u8f32\u8f8f\u7889\u77889"));
                }
            } else {
                a.dropMessage("\u60a8\u9700\u8981\u88dd\u5099 : " + MapleItemInformationProvider.getInstance().getName(GameSetConstants.REINCARNATION_SKILL_EQUIP));
            }
            if (GameSetConstants.REINCARNATION_REMOVE_SKILL_ABILITY) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
        }
        if (GameSetConstants.isMobVacSkill(var3_3)) {
            v2 = a;
            PlayerHandler.MobVacSkill(v2);
            v2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        var6_8 = a.readByte();
        if (var3_3 == 23111008) {
            var4_4 = 23111008;
            var5_6 = SkillFactory.getSkill(var3_3 += Randomizer.rand(0, 2));
        }
        if (var3_3 == 61120008) {
            var4_4 = 61111008;
            var5_6 = SkillFactory.getSkill(61111008);
        }
        if (var3_3 == 5211011) {
            var4_4 = 5211011;
            v3 = new int[3];
            v3[0] = 5211011;
            v3[1] = 5211015;
            v3[2] = 5211016;
            var7_9 = v3;
            var3_3 = v3[Randomizer.nextInt(v3.length)];
            var5_6 = SkillFactory.getSkill(var3_3);
        }
        if (var5_6 == null || SkillConstants.isAngel(var3_3) && a.getStat().equippedSummon % 10000 != var3_3 % 10000 || var3_3 >= 91000000 && var3_3 < 100000000) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (SkillConstants.isAngel(var3_3) && a.getBuffSource(MapleBuffStat.ANGEL_ATK) != -1 && a.getBuffSource(MapleBuffStat.ANGEL_MATK) != -1) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (SkillConstants.isAngel(var3_3) && a.getStackBuffInfo(MapleBuffStat.ANGEL_ATK) != null && a.getStackBuffInfo(MapleBuffStat.ANGEL_MATK) != null) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var3_3 == 61111003 && a.getStackBuffInfo(MapleBuffStat.ABNORMAL_STATUS_R).size() != 0) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (MapConstants.isBossMap(a.getId()) && SkillConstants.is\u98db\u7fd4(var3_3)) {
            v4 = a;
            v4.getPlayer().dropMessage(SellSystem.ALLATORIxDEMO("\u6b11\u575f\u5763\u714e\u6ca0\u4f10\u755d\u98b4\u7fa1N"));
            v4.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var3_3 == 5211011 && (var3_3 += Randomizer.nextInt(3)) > 5211011) {
            var3_3 += 3;
        }
        v5 = var7_10 = var3_3 / 10000 % 10 == 1 ? 1 : 0;
        if (a.getMap().skillDisabled() && var3_3 != 0 && var3_3 != 2301002) {
            a.getStat().setMp(0);
            v6 = a;
            a.updateSingleStat(MapleStat.MP, 0);
            v6.getDiseaseBuff(MobSkill.getByMobSkill(120), MobSkillFactory.getMobSkill(120, 1));
            v6.dropMessage(MapleMessenger.ALLATORIxDEMO("\u6b7c\u574b\u570e\u7695\u5255\u79fa\u6b7a\u4f04\u7530\u4e80\u4f4d\u62fb\u80e5"));
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var7_10 == 0) {
            SkillCollector.getInstance().addSkill(4, var3_3);
        }
        if (!GameSetConstants.MONSTERPET || !GameSetConstants.isMonsterPetSkill(var3_3)) ** GOTO lbl100
        if (GameConstants.SkillDisableMap(a.getMapId()) || MapleMonsterPet.BanMonsterPetMap(a.getMapId())) {
            a.dropMessage(SellSystem.ALLATORIxDEMO("\u6b11\u575f\u5763\u714e\u6ca0\u5383\u55ef\u6045\u721c\u5b9a\u721cN"));
            v7 = var3_3;
        } else {
            if (a.getMonsterPet(1) != 0 && a.getMonsterPet() == null) {
                new MapleMonsterPet(a.getMonsterPet(1), a.getPlayer()).setSkills(a.getMonsterPet(3));
                a.dropMessage(MapleMessenger.ALLATORIxDEMO("\u5d89\u53f4\u55e1\u6032\u7212\u5bed\u72129"));
            }
lbl100:
            // 4 sources

            v7 = var3_3;
        }
        if (v7 == 21001001) {
            v8 = var3_3;
            a.getPlayer().updateUsingMoveSkill_sp(2000, true);
        } else if (SkillConstants.is\u77ac\u9593\u79fb\u52d5(var3_3)) {
            v8 = var3_3;
            v9 = a;
            v9.getPlayer().updateUsingMoveSkill_sp(500, true);
            v9.getPlayer().getCheatTracker().check\u77ac\u9593\u79fb\u52d5();
        } else if (SkillConstants.is\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd(var3_3)) {
            v8 = var3_3;
            v10 = a;
            v10.getPlayer().updateUsingMoveSkill_sp(1500, true);
            v10.getPlayer().getCheatTracker().check\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd();
        } else if (SkillConstants.isMoveSkill(var3_3)) {
            v8 = var3_3;
            a.getPlayer().updateUsingMoveSkill(true);
        } else {
            if (SkillConstants.is\u5730\u5716\u77ac\u79fb(var3_3)) {
                a.getPlayer().getCheatTracker().check\u5730\u5716\u77ac\u79fb();
            }
            v8 = var3_3;
        }
        if (SkillConstants.is\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd(v8) && a.getSkillLevel(var5_6) <= 0 && !SpecialEquipFactory.getInstance().hasEquipSkill(a, var3_3)) {
            a.getPlayer().getCheatTracker().registerOffense(CheatingOffense.\u7570\u5e38\u4f7f\u7528\u4e8c\u6bb5\u8df3, " \u73a9\u5bb6: " + a.getPlayer().getName() + "(" + a.getPlayer().getLevel() + ") \u5730\u5716: " + a.getPlayer().getMapId() + "\u6280\u80fd\u4ee3\u78bc: " + var3_3 + " \u6280\u80fd\u7b49\u7d1a: " + a.getSkillLevel(var5_6));
            a.getPlayer().getCheatTracker().check\u5927\u7bc4\u570d\u79fb\u52d5\u6280\u80fd();
            return;
        }
        if (a.getSkillLevel(var4_4) > 0 && a.getSkillLevel(var4_4) == var6_8 || SpecialEquipFactory.getInstance().hasEquipSkill(a, var4_4)) ** GOTO lbl140
        if (!SkillConstants.is\u6b66\u9675\u9053\u5834\u6280\u80fd(var4_4) && !SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(var4_4) && a.getTotalSkillLevel(GameConstants.getLinkedAranSkill(var4_4)) <= 0 && a.getTotalSkillLevel(SkillConstants.getLinkedSkill(var4_4)) <= 0) {
            return;
        }
        if (SkillConstants.is\u6b66\u9675\u9053\u5834\u6280\u80fd(var4_4)) {
            if (a.getMapId() / 10000 != 92502) {
                return;
            }
            v11 = a;
            v12 = v11;
            v11.mulungEnergyModify(false);
        } else {
            if (SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(var4_4) && a.getMapId() / 10000 != 92602) {
                return;
            }
lbl140:
            // 3 sources

            v12 = a;
        }
        var7_10 = v12.getSkillLevel(SkillConstants.getLinkedSkill(var3_3));
        if (var7_10 == 0) {
            var7_10 = SpecialEquipFactory.getInstance().getEquipSkillLevel(a.getPlayer(), SkillConstants.getLinkedSkill(var3_3));
        }
        var7_11 = var5_6.getEffect(var7_10);
        if ((a.getStat().combatOrders > 0 || a.getStat().incAllskill > 0) && var7_11 != null && SkillFactory.getSkill(var7_11.getSourceId()).getEffect(var7_11.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill) != null) {
            var7_11 = SkillFactory.getSkill(var7_11.getSourceId()).getEffect(var7_11.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill);
        }
        if (var7_11.getCooldown(a) <= 0) ** GOTO lbl158
        if (a.skillisCooling(var3_3)) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var3_3 == 5221006 || var3_3 == 5221006 || var3_3 == 35111002) ** GOTO lbl158
        if (a.isAdmin() && a.isInvincible()) {
            a.dropMessage("\u4f3a\u670d\u5668\u7ba1\u7406\u54e1\u7121\u6575\u72c0\u614b\u6d88\u9664\u6280\u80fd\u51b7\u537b[" + SkillFactory.getName(var3_3) + "(" + var3_3 + ")]\uff0c\u6301\u7e8c\u6642\u9593\uff1a" + var7_11.getCooldown(a) + "\u79d2");
            v13 = var3_3;
        } else {
            a.sendPacket(MaplePacketCreator.skillCooldown(var4_4, var7_11.getCooldown(a)));
            a.addCooldown(var4_4, System.currentTimeMillis(), var7_11.getCooldown(a) * 1000);
lbl158:
            // 3 sources

            v13 = var3_3;
        }
        switch (v13) {
            case 1121001: 
            case 1221001: 
            case 1321001: 
            case 9001020: 
            case 9101020: 
            case 31111003: {
                v14 = a;
                var4_4 = v14.readByte();
                v14.skip(3);
                v15 = var8_12 = 0;
                while (v15 < var4_4) {
                    var9_13 = a.readInt();
                    var10_16 = a.getMap().getMonsterByOid(var9_13);
                    if (var10_16 != null) {
                        v16 = a;
                        v17 = a;
                        v16.getMap().broadcastMessage(v17, MaplePacketCreator.showMagnet(var9_13, a.readByte()), v17.getPosition());
                        v18 = var10_16;
                        v18.switchController(v16, v18.isControllerHasAggro());
                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                            var10_16.applyStatus(a, new MonsterStatusEffect(MonsterStatus.STUN, 1, var3_3, null, false), false, var7_11.getDuration(), true, var7_11);
                        }
                    }
                    v15 = ++var8_12;
                }
                v19 = a.readByte();
                var8_12 = v19;
                if ((v19 == 0 || var8_12 == 1) && a.getBuffedValue(MapleBuffStat.MORPH) == null) {
                    v20 = a;
                    a.getMap().broadcastMessage(v20, MaplePacketCreator.showBuffEffect(a.getId(), var3_3, 1, a.getLevel(), var6_8, var8_12), v20.getPosition());
                }
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 30001061: {
                var9_14 = a.readInt();
                var10_17 = a.getMap().getMonsterByOid(var9_14);
                if (var10_17 == null) ** GOTO lbl206
                var11_19 = var10_17.getHp() <= var10_17.getMobMaxHp() / 2L && var10_17.getId() >= 9304000 && var10_17.getId() < 9305000;
                v21 = a;
                a.getMap().broadcastMessage(v21, MaplePacketCreator.showBuffEffect(v21.getId(), var3_3, 1, a.getLevel(), var6_8, (byte)(var11_19 != false ? 1 : 0)), a.getTruePosition());
                v22 = a;
                if (var11_19) {
                    v22.getQuestNAdd(MapleQuest.getInstance(111112)).setCustomData(String.valueOf((var10_17.getId() - 9303999) * 10));
                    v23 = a;
                    v24 = v23;
                    v25 = a;
                    a.getMap().killMonster(var10_17, v25, (boolean)1, false, (byte)1);
                    v25.cancelEffectFromBuffStat(MapleBuffStat.MONSTER_RIDING);
                    v23.sendPacket(MaplePacketCreator.updateJaguar(a));
                } else {
                    v22.dropMessage(5, SellSystem.ALLATORIxDEMO("\u605f\u7206\u903b\u65d3\u5f42\u5948Y\u714e\u6ca0\u633a\u633cN"));
lbl206:
                    // 2 sources

                    v24 = a;
                }
                v24.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 30001062: {
                a.dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u6ce9\u6711\u6051\u7271\u5394\u4efd\u5397\u5582W\u8ad3\u5133\u628b\u53ad\u6032\u72129"));
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 33101005: {
                if (GameSetConstants.MAPLE_VERSION >= 151) {
                    var7_11.applyTo(a);
                    return;
                }
                v26 = a;
                var9_15 = v26.getFirstLinkMid();
                var10_18 = v26.getMap().getMonsterByOid(var9_15);
                v26.setKeyDownSkill_Time(0L);
                v27 = a;
                v26.getMap().broadcastMessage(v27, MaplePacketCreator.skillCancel(v27, var3_3), false);
                if (var10_18 != null) {
                    var11_20 = var10_18.getStats().getLevel() < a.getLevel() && var10_18.getId() < 9000000 && var10_18.getStats().isBoss() == false;
                    v28 = a;
                    if (var11_20) {
                        v28.getMap().broadcastMessage(MobPacket.suckMonster(var10_18.getObjectId(), a.getId()));
                        a.getMap().killMonster(var10_18, a, false, false, (byte)-1);
                    } else {
                        v28.dropMessage(5, SellSystem.ALLATORIxDEMO("\u605f\u7206\u903b\u65d3\u5f42\u5948Y\u714e\u6ca0\u5471\u98aaN"));
                    }
                } else {
                    a.dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u7139\u4e80\u4f4d\u6051\u7271\u88d0\u5406\u98a49U\u5406\u98a4\u5929\u652c9"));
                }
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 4341003: {
                a.readByte();
                var11_21 = a.readInt();
                var4_5 = a.getMap().getMonsterByOid(var11_21);
                if (var4_5 == null) return;
                if (!a.isAlive()) {
                    return;
                }
                if (GameSetConstants.MAPLE_VERSION < 118) return;
                if (SkillFactory.getSkill(4341003) == null) return;
                var12_22 = SkillFactory.getSkill(4341003).getEffect(a.getTotalSkillLevel(4341003));
                var13_24 = new MonsterStatusEffect(MonsterStatus.MONSTER_BOMB, 1, 4341003, null, false);
                var4_5.applyStatus(a, var13_24, false, 3500L, true, var12_22);
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 31221001: {
                var12_23 = new ArrayList<Integer>();
                var13_25 = a.readByte();
                v29 = var14_26 = 0;
                while (true) {
                    if (v29 >= var13_25) {
                        v30 = a;
                        a.getMap().broadcastMessage(v30, MaplePacketCreator.DrainSoul(v30, 0, var12_23, 2, var7_11.getBulletCount(), 31221014, a.readShort(), false), true);
                        return;
                    }
                    var12_23.add(a.readInt());
                    v29 = ++var14_26;
                }
            }
            case 65111100: {
                a.readPos();
                var14_27 = new ArrayList<Integer>();
                var4_4 = a.readByte();
                var15_28 = 0;
                v31 = var15_28;
                while (true) {
                    if (v31 >= var4_4) {
                        v32 = a;
                        a.getMap().broadcastMessage(v32, MaplePacketCreator.DrainSoul(v32, 0, var14_27, 2, var7_11.getBulletCount(), 65111007, a.readShort(), false), true);
                        a.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    var14_27.add(a.readInt());
                    v31 = ++var15_28;
                }
            }
            case 27121054: {
                v33 = a;
                v33.changeLuminousMode(v33.getRunningLight() == 1 ? 20040217 : 20040216);
                return;
            }
            case 20040216: 
            case 20040217: 
            case 20040219: 
            case 20040220: 
            case 20041239: {
                a.changeLuminousMode(var3_3);
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
        }
        var15_29 = null;
        if (a.available() == 5L || a.available() == 7L) {
            v34 = a;
            var15_29 = v34.readPos();
            var3_3 = v34.readByte() == 0 ? 1 : 0;
            v35 = var4_4 = a.getStance();
            if (var3_3 != 0) {
                var4_4 = v35 & 254;
                v36 = a;
            } else {
                var4_4 = v35 | 1;
                v36 = a;
            }
            v36.setStance(var4_4);
        }
        if (var7_11.isMagicDoor()) {
            if (!FieldLimitType.MysticDoor.check(a.getMap().getFieldLimit())) {
                var7_11.applyTo(a.getPlayer(), var15_29);
                return;
            }
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        var3_3 = MapleStatEffect.parseMountInfo(a.getPlayer(), var5_6.getId());
        if (var3_3 != 0 && var3_3 != GameConstants.getMountItem(var5_6.getId(), a.getPlayer()) && !a.getPlayer().isGM() && a.getPlayer().getBuffedValue(MapleBuffStat.MONSTER_RIDING) == null && a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118) == null && !GameConstants.isMountItemAvailable(var3_3, a.getPlayer().getJob())) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        var7_11.applyTo(a.getPlayer(), var15_29);
    }

    public static final /* synthetic */ void ChangeEmotion(final int a2, final MapleCharacter a3) {
        int n2;
        MapleInventoryType mapleInventoryType;
        if (a2 > 7 && a3.getInventory(mapleInventoryType = GameConstants.getInventoryType(n2 = 5159992 + a2)).findById(n2) == null) {
            return;
        }
        if (a2 > 0 && a3 != null && a3.getMap() != null) {
            int n3;
            MapleCharacter mapleCharacter = a3;
            a3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.facialExpression(mapleCharacter, a2), false);
            WeakReference<MapleCharacter>[] arrweakReference = mapleCharacter.getClones();
            int n4 = n3 = 0;
            while (n4 < arrweakReference.length) {
                if (arrweakReference[n3].get() != null) {
                    a3 = (MapleCharacter)arrweakReference[n3].get();
                    Timer.CloneTimer.getInstance().schedule(new Runnable(){

                        @Override
                        public /* synthetic */ void run() {
                            4 a22;
                            4 v0 = a22;
                            a22.a3.getMap().broadcastMessage(MaplePacketCreator.facialExpression(v0.a3, v0.a2));
                        }
                        {
                            4 a22;
                        }
                    }, 500 * n3 + 500);
                }
                n4 = ++n3;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void MagicDamage(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        if (a == null) {
            return;
        }
        if (!a.isAlive() || a.getMap() == null) {
            a.getCheatTracker().registerOffense(CheatingOffense.ATTACKING_WHILE_DEAD);
            return;
        }
        if (GameSetConstants.DAMAGE_SKIN) {
            AttackFont.sendFontStyle(a);
        }
        var3_3 = DamageParse.Modify_AttackCrit(DamageParse.parseDmg(a, DamageParse.DamageType.MAGIC_ATTACK, a), a, 3);
        var4_4 = null;
        var5_5 = 0;
        if (var3_3.skill != 0 && (var4_4 = SkillFactory.getSkill(SkillConstants.getLinkedSkill(var3_3.skill))) != null && (var5_5 = a.getSkillLevel(var4_4)) == 0 && a.containsBindingBySkillid(var3_3.skill)) {
            var5_5 = 1;
        }
        if ((var6_6 = var3_3.getAttackEffect(a, var5_5, var4_4)) == null) {
            return;
        }
        var7_7 = false;
        if (JobConstants.is\u591c\u5149(a.getJob()) && a.isLuminousBalance() && (var3_3.skill == 27111303 || var3_3.skill == 27121303)) {
            var7_7 = true;
        }
        if (a.getMap().skillDisabled() && var3_3.skill != 0 && var3_3.skill != 2301002) {
            a.getStat().setMp(0);
            v0 = a;
            a.updateSingleStat(MapleStat.MP, 0);
            v0.getDiseaseBuff(MobSkill.getByMobSkill(120), MobSkillFactory.getMobSkill(120, 1));
            v0.dropMessage(SellSystem.ALLATORIxDEMO("\u6b0b\u5745\u5779\u769b\u5222\u79f4\u6b0d\u4f0a\u7547\u4e8e\u4f3a\u62f5\u8092"));
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!SkillCollector.getInstance().isExistSkill(3, var3_3.skill)) {
            a.getCheatTracker().registerOffense(CheatingOffense.ATTACK_TYPE_ERROR, "\u6280\u80fd: " + var3_3.skill + " \u7a2e\u985e: 3");
            SkillCollector.getInstance().addSkill(3, var3_3.skill);
            return;
        }
        if ((a.getStat().combatOrders > 0 || a.getStat().incAllskill > 0) && var6_6 != null && SkillFactory.getSkill(var6_6.getSourceId()).getEffect(var6_6.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill) != null) {
            var6_6 = SkillFactory.getSkill(var6_6.getSourceId()).getEffect(var6_6.getLevel() + a.getStat().combatOrders + a.getStat().incAllskill);
        }
        if (var7_7 || var6_6.getCooldown(a) <= 0) ** GOTO lbl43
        if (a.skillisCooling(var3_3.skill)) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a.isAdmin() && a.isInvincible()) {
            a.dropMessage("\u4f3a\u670d\u5668\u7ba1\u7406\u54e1\u7121\u6575\u72c0\u614b\u6d88\u9664\u6280\u80fd\u51b7\u537b[" + SkillFactory.getName(var3_3.skill) + "(" + var3_3.skill + ")]\uff0c\u6301\u7e8c\u6642\u9593\uff1a" + var6_6.getCooldown(a) + "\u79d2");
            v1 = a;
        } else {
            a.sendPacket(MaplePacketCreator.skillCooldown(var3_3.skill, var6_6.getCooldown(a)));
            a.addCooldown(var3_3.skill, System.currentTimeMillis(), var6_6.getCooldown(a) * 1000);
lbl43:
            // 2 sources

            v1 = a;
        }
        var8_9 = (double)(v1.getStat().getCurrentMaxBaseDamage() * (float)(var6_6.getDamage() + a.getStat().getDamageIncrease(var3_3.skill))) / 100.0;
        if (JobConstants.isBeginnerJob(var4_4.getId() / 10000) && var4_4.getId() % 10000 == 1000) {
            var8_9 = 40.0;
            v2 = a;
        } else if (SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(var3_3.skill)) {
            var8_9 = 1.0;
            v2 = a;
        } else {
            if (GameSetConstants.MAPLE_VERSION < 134) {
                v3 = var10_10 = (double)var6_6.getMatk() * 0.058;
                var8_9 = (double)a.getStat().getTotalMagic() * ((double)a.getStat().getInt() * 0.5 + v3 * v3 + (double)var6_6.getMatk() * 3.3) / 100.0;
                var8_9 *= 1.04;
            }
            v2 = a;
        }
        v2.checkFollow();
        v4 = a;
        v5 = a;
        v6 = a;
        v4.getMap().broadcastMessage(v6, MaplePacketCreator.magicAttack(v5, var5_5, var3_3, v5.getLevel()), v6.getPosition());
        DamageParse.applyAttackMagic(var3_3, var4_4, a.getPlayer(), var6_6, var8_9);
        if (v4.getLastUseSkill() != var3_3.skill) {
            a.setLastUseSkill(var3_3.skill);
        }
        var10_11 = a.getClones();
        v7 = var11_12 = 0;
        while (v7 < var10_11.length) {
            if (var10_11[var11_12].get() != null) {
                a = (MapleCharacter)var10_11[var11_12].get();
                var7_8 = var4_4;
                var12_13 = var6_6;
                var13_14 = var5_5;
                var14_15 = var8_9;
                var16_16 = DamageParse.DivideAttack(var3_3, a.isGM() != false ? 1 : 4);
                Timer.CloneTimer.getInstance().schedule(new Runnable(){
                    public final /* synthetic */ int B;
                    public final /* synthetic */ ISkill K;
                    public final /* synthetic */ MapleCharacter a;
                    public final /* synthetic */ double ALLATORIxDEMO;
                    public final /* synthetic */ MapleCharacter g;
                    public final /* synthetic */ AttackInfo k;
                    public final /* synthetic */ MapleStatEffect d;

                    @Override
                    public /* synthetic */ void run() {
                        3 a2;
                        3 v0 = a2;
                        3 v1 = a2;
                        a2.g.getMap().broadcastMessage(MaplePacketCreator.magicAttack(a2.g, v0.B, v1.k, v1.g.getLevel()));
                        3 v2 = a2;
                        3 v3 = a2;
                        DamageParse.applyAttackMagic(v0.k, v2.K, v2.a, v3.d, v3.ALLATORIxDEMO);
                    }
                    {
                        3 a2;
                        3 v0 = a2;
                        3 v1 = a2;
                        a2.g = mapleCharacter;
                        v1.B = n2;
                        v1.k = attackInfo;
                        v0.K = iSkill;
                        v0.a = mapleCharacter2;
                        a2.d = mapleStatEffect;
                        a2.ALLATORIxDEMO = d2;
                    }
                }, 500 * var11_12 + 500);
            }
            v7 = ++var11_12;
        }
    }

    public static /* synthetic */ void getRandomDisease(MapleCharacter a2) {
        MapleCharacter mapleCharacter = a2;
        a2.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showChair(mapleCharacter.getId(), 0, 0), false);
        MobSkill mobSkill = MobSkillFactory.getAllMobSkill().get(Randomizer.rand(0, MobSkillFactory.getAllMobSkill().size() - 1));
        MapleBuffStat mapleBuffStat = MobSkill.getByMobSkill(mobSkill.getSkillId());
        if (mapleBuffStat != null) {
            a2.getDiseaseBuff(mapleBuffStat, mobSkill);
        }
    }

    public static final /* synthetic */ void MoveAndroid(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(8);
        a3 = MovementParse.parseMovement(littleEndianAccessor, (MapleClient)a3, 3);
        if (a3 != null && a4 != null && a3.size() != 0 && a4.getMap() != null && a4.getAndroid() != null) {
            Point point = new Point(a4.getAndroid().getPos());
            MapleCharacter mapleCharacter = a4;
            mapleCharacter.getAndroid().updatePosition((List<LifeMovementFragment>)a3);
            MapleCharacter mapleCharacter2 = a4;
            mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.moveAndroid(mapleCharacter2.getId(), point, (List<LifeMovementFragment>)a3), false);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void updateSpecialStat(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        int n3;
        int n4;
        int n5;
        String string;
        block20: {
            LittleEndianAccessor littleEndianAccessor = a2;
            string = littleEndianAccessor.readMapleAsciiString();
            n5 = littleEndianAccessor.readInt();
            n4 = littleEndianAccessor.readInt();
            String string2 = string;
            int n6 = -1;
            switch (string2.hashCode()) {
                case 99761772: {
                    if (!string2.equals(MapleMessenger.ALLATORIxDEMO("p\u0002h\u001ej"))) break;
                    n3 = n6 = 0;
                    break block20;
                }
                case -1398528920: {
                    if (!string2.equals(SellSystem.ALLATORIxDEMO("\u0007\u001a\u0001\u001a\u001d9\n\u0003\n\u0019\u0006\u001b\b"))) break;
                    n6 = 1;
                }
            }
            n3 = n6;
        }
        switch (n3) {
            case 0: {
                int n7;
                boolean bl;
                MapleClient mapleClient;
                int n8 = 0;
                if (n4 == 0 && (n5 == 28 || n5 == 30 || n5 == 32 || n5 == 34 || n5 == 36 || n5 == 38 || n5 == 40)) {
                    n8 = 1;
                    mapleClient = a3;
                } else if (n4 == 1 && (n5 == 28 || n5 == 32 || n5 == 36 || n5 == 38 || n5 == 40)) {
                    n8 = 1;
                    mapleClient = a3;
                } else {
                    if (n4 == 2 && (n5 == 30 || n5 == 40)) {
                        n8 = 1;
                    }
                    mapleClient = a3;
                }
                int n9 = n5;
                if (n9 < 41) {
                    bl = true;
                    n7 = n8;
                } else {
                    bl = false;
                    n7 = n8;
                }
                mapleClient.sendPacket(MaplePacketCreator.updateSpecialStat(string, n9, n4, bl, n7));
                return;
            }
            case 1: {
                a3.sendPacket(MaplePacketCreator.updateSpecialStat(string, n5, n4, a3.getPlayer().getHonorLevel() >= 12 ? 500 * a3.getPlayer().getHonorLevel() : 500));
                return;
            }
        }
        int n10 = -1;
        if (string.startsWith(MapleMessenger.ALLATORIxDEMO("B*K(")) || string.startsWith(SellSystem.ALLATORIxDEMO("L]E^"))) {
            n2 = n10 = 100;
        } else {
            int n11 = Integer.parseInt(string);
            if (n11 / 100000 == 920) {
                n10 = Math.max(0, 100 - (n5 + 1 - a3.getPlayer().getProfessionLevel(n11)) * 20);
            }
            n2 = n10;
        }
        if (n2 > -1) {
            a3.sendPacket(MaplePacketCreator.updateSpecialStat(string, n5, n4, n10));
            return;
        }
        if (!a3.getPlayer().isStaff()) {
            return;
        }
        a3.getPlayer().dropMessage(5, "[\u66f4\u65b0\u5c6c\u6027] \u672a\u8655\u7406\u5c6c\u6027 stat:" + string + " array:" + n5 + " mode:" + n4 + " \u6709\u7121\u672a\u8b80\u5b8c\u6578\u64da:" + (a2.available() > 0L ? MapleMessenger.ALLATORIxDEMO("\u6711") : SellSystem.ALLATORIxDEMO("\u714e")));
    }

    public static final /* synthetic */ void handleLogout(LittleEndianAccessor a2, MapleClient a3) {
        block34: {
            MapleClient mapleClient;
            String string = null;
            try {
                string = a2.readMapleAsciiString();
                mapleClient = a3;
            }
            catch (NegativeArraySizeException negativeArraySizeException) {
                mapleClient = a3;
            }
            if (mapleClient.getPlayer() != null) {
                return;
            }
            if (string == null) break block34;
            int n2 = 0;
            int n3 = 0;
            String string2 = "";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(SellSystem.ALLATORIxDEMO("\u0006\n\u0019\n\u0016\u001bU\u0006\u0011CU\u0003\u001a\b\u0012\n\u0011\u0006\u001bO\u0013\u001d\u001a\u0002U\u000e\u0016\f\u001a\u001a\u001b\u001b\u0006O\u0002\u0007\u0010\u001d\u0010O\u001b\u000e\u0018\nURUP"));
            if (a3 != null) {
                string2 = a3.getSessionIPAddress();
                stringBuilder.append(MapleMessenger.ALLATORIxDEMO("[y\u0015|[K\u001ek\bq\u0014v2H[%['"));
            }
            try {
                DruidPooledConnection druidPooledConnection;
                DruidPooledConnection druidPooledConnection2;
                block30: {
                    druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        PreparedStatement preparedStatement;
                        PreparedStatement preparedStatement2;
                        block28: {
                            preparedStatement2 = druidPooledConnection2.prepareStatement(stringBuilder.toString());
                            try {
                                block27: {
                                    preparedStatement2.setString(1, string);
                                    if (a3 != null) {
                                        preparedStatement2.setString(2, string2);
                                    }
                                    ResultSet resultSet = preparedStatement2.executeQuery();
                                    try {
                                        if (resultSet.next()) {
                                            ResultSet resultSet2 = resultSet;
                                            n2 = resultSet2.getInt(SellSystem.ALLATORIxDEMO("\u0019\u0000\u0012\b\u0010\u000b\u001c\u0001"));
                                            n3 = resultSet2.getInt(MapleMessenger.ALLATORIxDEMO("\u0012|"));
                                        }
                                        if (resultSet == null) break block27;
                                        preparedStatement = preparedStatement2;
                                    }
                                    catch (Throwable throwable) {
                                        Throwable throwable2;
                                        block29: {
                                            if (resultSet != null) {
                                                try {
                                                    resultSet.close();
                                                    throwable2 = throwable;
                                                    break block29;
                                                }
                                                catch (Throwable throwable3) {
                                                    throwable.addSuppressed(throwable3);
                                                }
                                            }
                                            throwable2 = throwable;
                                        }
                                        throw throwable2;
                                    }
                                    resultSet.close();
                                    break block28;
                                }
                                preparedStatement = preparedStatement2;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable4;
                                block31: {
                                    if (preparedStatement2 != null) {
                                        try {
                                            preparedStatement2.close();
                                            throwable4 = throwable;
                                            break block31;
                                        }
                                        catch (Throwable throwable5) {
                                            throwable.addSuppressed(throwable5);
                                        }
                                    }
                                    throwable4 = throwable;
                                }
                                throw throwable4;
                            }
                        }
                        if (preparedStatement != null) {
                            druidPooledConnection = druidPooledConnection2;
                            preparedStatement2.close();
                            break block30;
                        }
                        druidPooledConnection = druidPooledConnection2;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable6;
                        block33: {
                            if (druidPooledConnection2 != null) {
                                try {
                                    druidPooledConnection2.close();
                                    throwable6 = throwable;
                                    break block33;
                                }
                                catch (Throwable throwable7) {
                                    throwable.addSuppressed(throwable7);
                                }
                            }
                            throwable6 = throwable;
                        }
                        throw throwable6;
                    }
                }
                if (druidPooledConnection != null) {
                    druidPooledConnection2.close();
                }
            }
            catch (Exception exception) {
                System.err.println("[handleLogout] \u8655\u7406\u767b\u51fa\u51fa\u932f" + exception);
            }
            if (a3 != null) {
                a3.setAccID(n3);
                if (n2 > 0) {
                    MapleClient mapleClient2 = a3;
                    mapleClient2.updateLoginState(0, mapleClient2.getSessionIPAddress());
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void TrockAddMap135(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block8: {
            block11: {
                block9: {
                    block10: {
                        block6: {
                            block7: {
                                v0 = a;
                                var3_3 = v0.readByte();
                                var4_4 = v0.readByte();
                                if (var4_4 != 1) break block6;
                                if (var3_3 != 0) break block7;
                                v1 = a;
                                a.deleteFromRegRocks(a.readInt());
                                break block8;
                            }
                            if (var3_3 != 1 || FieldLimitType.VipRock.check(a.getMap().getFieldLimit())) ** GOTO lbl47
                            if (a.getPlayer().getMapId() <= 197010000 && a.getPlayer().getMapId() != 180000000) {
                                v1 = a;
                                a.addRegRockMap();
                            } else {
                                a.dropMessage(1, SellSystem.ALLATORIxDEMO("\u4f0f\u4e78\u8092\u5147\u5b37\u906c\u5f5a\u5745\u5779"));
                                v1 = a;
                            }
                            break block8;
                        }
                        if (var4_4 < 2) break block9;
                        if (var3_3 != 0) break block10;
                        v1 = a;
                        a.deleteFromRocks(a.readInt());
                        break block8;
                    }
                    if (var3_3 != 1 || FieldLimitType.VipRock.check(a.getMap().getFieldLimit())) ** GOTO lbl47
                    if (a.getPlayer().getMapId() != 180000000) {
                        v1 = a;
                        a.addRockMap();
                    } else {
                        a.dropMessage(1, MapleMessenger.ALLATORIxDEMO("\u4f78\u4e76\u80e5\u5149\u5b40\u9062\u5f2d\u574b\u570e"));
                        v1 = a;
                    }
                    break block8;
                }
                if (var4_4 < 3) ** GOTO lbl47
                if (var3_3 != 0) break block11;
                v1 = a;
                a.deleteFromHyperRocks(a.readInt());
                break block8;
            }
            if (var3_3 != 1) ** GOTO lbl47
            v2 = a;
            if (!FieldLimitType.VipRock.check(a.getMap().getFieldLimit())) {
                v2.addHyperRockMap();
                v1 = a;
            } else {
                v2.dropMessage(1, SellSystem.ALLATORIxDEMO("\u4f0f\u4e78\u8092\u5147\u5b37\u906c\u5f5a\u5745\u5779"));
lbl47:
                // 5 sources

                v1 = a;
            }
        }
        v1.sendPacket(MTSCSPacket.getTrockRefresh(a, var4_4, var3_3 == (GameSetConstants.MAPLE_VERSION >= 134 ? 3 : 0)));
    }

    public static /* synthetic */ void ThrowGrenade(LittleEndianAccessor a2, MapleCharacter a3) {
    }

    public static /* synthetic */ void DressUpTime(LittleEndianAccessor a2, MapleClient a3) {
        byte by = a2.readByte();
        if (by == 1) {
            if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a3.getPlayer().getJob())) {
                a3.sendPacket(JobPacket.AngelicPacket.DressUpTime(by));
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(JobPacket.AngelicPacket.updateDress(5010094, mapleClient.getPlayer()));
                return;
            }
            a3.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public static final /* synthetic */ void ChangeMapSpecial(String a2, MapleClient a3, MapleCharacter a4) {
        MapleCharacter mapleCharacter = a4;
        MaplePortal maplePortal = mapleCharacter.getMap().getPortal(a2);
        mapleCharacter.updateWarpingMap(true);
        if (maplePortal != null && !a4.hasBlockedInventory()) {
            maplePortal.enterPortal(a3);
            return;
        }
        if (a4.hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void TakeDamage(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block82: {
            block86: {
                block85: {
                    block83: {
                        block84: {
                            if (a.available() < 5L) {
                                return;
                            }
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                a.updateTick(a.readInt());
                            } else {
                                a.skip(4);
                            }
                            if (GameSetConstants.MAPLE_VERSION >= 139) {
                                a.readInt();
                            }
                            v0 = a;
                            var3_4 = v0.readByte();
                            v0.skip(1);
                            var4_5 = v0.readInt();
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                a.skip(2);
                            }
                            var5_6 = 0;
                            var6_7 = 0;
                            var7_8 = 0;
                            var7_8 = 0;
                            var8_9 = 0;
                            var8_9 = 0;
                            var8_9 = 0;
                            var9_10 = 0;
                            var10_11 = 0;
                            var11_12 = 0;
                            var12_13 = 0;
                            var13_14 = 0;
                            var14_15 = 0;
                            var15_16 = false;
                            var15_16 = false;
                            var16_17 = false;
                            var17_18 = new Point(0, 0);
                            var18_19 = null;
                            if (a == null) return;
                            if (a.isHidden() != false) return;
                            if (a.getMap() == null) {
                                return;
                            }
                            if (a.isGM() && a.isInvincible()) {
                                return;
                            }
                            if (a.getBuffedValue(MapleBuffStat.DIVINE_BODY) != null) {
                                return;
                            }
                            if (MapConstants.isCakeMap(a.getMapId())) {
                                var19_20 = a.getChannelServer().getMapFactory().getMap(749020920);
                                v1 = a;
                                v2 = var19_20;
                                v1.changeMap(v2, v2.getPortal(0));
                                v1.dropMessage(5, MapleMessenger.ALLATORIxDEMO("\u56f8\u70c1\u88b38y\u0010}\u7607\u73e6\uff77\u6258\u4e9e\u4f78\u88d0S\u0012{\u00108:k\bp\u0014t\u001e\u301a"));
                                return;
                            }
                            if (a.getMapId() == 915000300) {
                                v3 = a;
                                var19_21 = v3.getClient().getChannelServer().getMapFactory().getMap(915000200);
                                a.getPlayer().getMap().resetFully();
                                v3.dropMessage(5, SellSystem.ALLATORIxDEMO("\u88c4\u5bfd\u8834\u7609\u7391\u4ef3\uff63\u66de\u662d\u64d1\u906f\u5452\u306d"));
                                v4 = var19_21;
                                v3.changeMap(v4, v4.getPortal(1));
                                return;
                            }
                            var19_22 = a.getStat();
                            if (var3_4 != -2 && var3_4 != -3 && var3_4 != -4) {
                                v5 = a;
                                var6_7 = a.readInt();
                                var5_6 = v5.readInt();
                                var18_19 = a.getMap().getMonsterByOid(var5_6);
                                var7_8 = v5.readByte();
                                if (v5.available() >= 10L) {
                                    v6 = a;
                                    var10_11 = v6.readInt();
                                    var12_13 = v6.readInt();
                                    var14_15 = v6.readByte();
                                    v6.skip(1);
                                }
                                if (var18_19 == null) {
                                    return;
                                }
                                if (var18_19.isMonsterPet()) {
                                    return;
                                }
                                if (var14_15 == 1 && (var20_23 = a.getTotalSkillLevel((ISkill)(a = SkillFactory.getSkill(31110008)))) > 0) {
                                    var21_25 = a.getEffect(var20_23);
                                    if (Randomizer.nextInt(100) <= var21_25.getX()) {
                                        v7 = a;
                                        var22_29 = (int)((double)v7.getStat().getCurrentMaxHp() * ((double)var21_25.getY() / 100.0));
                                        v7.addHP(var22_29);
                                        v7.handleForceGain(var5_6, 31110008, var21_25.getZ());
                                    }
                                }
                                if (a.getPotential3() > 0L && (long)Randomizer.rand(1, 10000) <= a.getPotential3() - 10000L) {
                                    a.dropMessagePotential(MapleMessenger.ALLATORIxDEMO("\u7139\u89ed\u6032\u7212\u50af\u5bc89"));
                                    return;
                                }
                                if (var19_22.DAMreduceR > 0 && var4_5 > 1) {
                                    v8 = var4_5;
                                    var4_5 = v8 - (int)((double)v8 * ((double)var19_22.DAMreduceR / 100.0));
                                }
                                if (var10_11 != 0 && a.available() >= 14L) {
                                    var16_17 = a.readByte() > 0;
                                    v9 = a;
                                    var11_12 = v9.readInt();
                                    var13_14 = v9.readByte();
                                    v9.skip(4);
                                    var17_18 = v9.readPos();
                                }
                                if (var3_4 != -1 && (a = MobAttackInfoFactory.getInstance().getMobAttackInfo(var18_19, var3_4)) != null) {
                                    if (a.isDeadlyAttack()) {
                                        var15_16 = true;
                                        v10 = a;
                                        var9_10 = var19_22.getMp() - 1;
                                    } else {
                                        var9_10 += a.getMpBurn();
                                        v10 = a;
                                    }
                                    var20_24 = MobSkillFactory.getMobSkill(v10.getDiseaseSkill(), a.getDiseaseLevel());
                                    if (var20_24 != null && (var4_5 == -1 || var4_5 > 0)) {
                                        var20_24.applyEffect(a, var18_19, false);
                                    }
                                    v11 = var18_19;
                                    v11.setMp(v11.getMp() - a.getMpCon());
                                }
                            }
                            if (var4_5 == -1) {
                                var8_9 = 4020002 + (a.getJob() / 10 - 40) * 100000;
                                if (var8_9 != 4120002 && var8_9 != 4220002) {
                                    var8_9 = 4120002;
                                }
                                if (var3_4 == -1 && a.getJob() == 122 && var18_19 != null && a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-10) != null && a.getTotalSkillLevel(1220006) > 0) {
                                    a = SkillFactory.getSkill(1220006).getEffect(a.getTotalSkillLevel(1220006));
                                    var18_19.applyStatus(a, new MonsterStatusEffect(MonsterStatus.STUN, 1, 1220006, null, false), false, a.getDuration(), true, (MapleStatEffect)a);
                                    var8_9 = 1220006;
                                }
                                if (a.getTotalSkillLevel(var8_9) <= 0) {
                                    return;
                                }
                            } else {
                                if (var4_5 < -1) return;
                                if (var4_5 > 99999) {
                                    return;
                                }
                            }
                            if (GameSetConstants.CHECK_TAKE_DAMAGE) {
                                if (!a.inBossMap()) {
                                    a.getCheatTracker().checkTakeDamage(var4_5);
                                }
                                a.getCheatTracker().checkTakeDamage(var4_5, var6_7);
                            }
                            a = a.modifyDamageTaken(var4_5, var18_19, var10_11);
                            var4_5 = ((Double)a.left).intValue();
                            if (var4_5 <= 0) break block82;
                            v12 = a;
                            v12.getCheatTracker().setAttacksWithoutHit(false);
                            v13 = var20_23 = v12.getBuffedValue(MapleBuffStat.MORPH) != null ? 1 : 0;
                            if (var20_23 != 0) {
                                a.cancelMorphs();
                            }
                            if ((a.available() == 3L || a.available() == 4L) && (var21_26 = a.readByte()) > 0 && (var22_30 = MobSkillFactory.getMobSkill(a.readShort(), var21_26)) != null) {
                                var22_30.applyEffect(a, var18_19, false);
                            }
                            if (var3_4 == -2 || var3_4 == -3 || var3_4 == -4) break block83;
                            switch (a.getJob()) {
                                case 112: {
                                    var21_25 = SkillFactory.getSkill(1120004);
                                    if (a.getSkillLevel((ISkill)var21_25) <= 0) break;
                                    v14 = a;
                                    v15 = v14;
                                    var4_5 = (int)((double)var21_25.getEffect(v14.getSkillLevel((ISkill)var21_25)).getX() / 1000.0 * (double)var4_5);
                                    break block84;
                                }
                                case 122: {
                                    var21_25 = SkillFactory.getSkill(1220005);
                                    if (a.getSkillLevel((ISkill)var21_25) <= 0) break;
                                    v16 = a;
                                    v15 = v16;
                                    var4_5 = (int)((double)var21_25.getEffect(v16.getSkillLevel((ISkill)var21_25)).getX() / 1000.0 * (double)var4_5);
                                    break block84;
                                }
                                case 132: {
                                    var21_25 = SkillFactory.getSkill(1320005);
                                    if (a.getSkillLevel((ISkill)var21_25) <= 0) break;
                                    v17 = a;
                                    v15 = v17;
                                    var4_5 = (int)((double)var21_25.getEffect(v17.getSkillLevel((ISkill)var21_25)).getX() / 1000.0 * (double)var4_5);
                                    break block84;
                                }
                                case 2112: {
                                    var21_25 = SkillFactory.getSkill(21120004);
                                    if (a.getSkillLevel((ISkill)var21_25) <= 0) break;
                                    v18 = a;
                                    v15 = v18;
                                    var4_5 = (int)((double)var21_25.getEffect(v18.getSkillLevel((ISkill)var21_25)).getX() / 1000.0 * (double)var4_5);
                                    break block84;
                                }
                            }
                            v15 = a;
                        }
                        if (v15.getBuffedValue(MapleBuffStat.DAMAGE_ABSORBED) != null) {
                            v19 = var4_5;
                            var4_5 = v19 - (int)((double)a.getBuffedSkill_X(MapleBuffStat.DAMAGE_ABSORBED).intValue() / 100.0 * (double)v19);
                        }
                        if (a.getBuffedValue(MapleBuffStat.COMBO_BARRIER) != null) {
                            var4_5 = (int)((double)a.getBuffedSkill_X(MapleBuffStat.COMBO_BARRIER).intValue() / 1000.0 * (double)var4_5);
                        }
                        if (a.getBuffedValue(MapleBuffStat.COMBO_BARRIER) != null) {
                            var4_5 = (int)((double)a.getBuffedSkill_X(MapleBuffStat.COMBO_BARRIER).intValue() / 1000.0 * (double)var4_5);
                        }
                    }
                    var21_27 = a.getBuffedValue(MapleBuffStat.MECH_CHANGE) != null && a.getBuffSource(MapleBuffStat.MECH_CHANGE) != 35121005;
                    var22_29 = a.getBuffedValue(MapleBuffStat.MESOGUARD) != null ? 1 : 0;
                    a = a.getBuffedValue(MapleBuffStat.MAGIC_GUARD) != null;
                    var5_6 = a.getBuffedValue(MapleBuffStat.INFINITY) != null ? 1 : 0;
                    var23_31 = 0.0;
                    if (a) {
                        var23_31 = a.getBuffedValue(MapleBuffStat.MAGIC_GUARD).doubleValue();
                    }
                    if (a.getTotalSkillLevel(27000003) <= 0) break block85;
                    var14_15 = 0;
                    var25_32 = 0;
                    if (var15_16) {
                        if (var19_22.getHp() > 1) {
                            var14_15 = var19_22.getHp() - 1;
                        }
                        if (var19_22.getMp() > 1) {
                            var25_32 = var19_22.getMp() - 1;
                        }
                        if (a.getBuffedValue(MapleBuffStat.INFINITY) != null) {
                            var25_32 = 0;
                        }
                        a.addMPHP(-var14_15, -var25_32);
                    } else {
                        if (a.getTotalSkillLevel(27000003) > 0) {
                            var26_35 = SkillFactory.getSkill(27000003);
                            v20 = var26_35;
                            var26_35 = v20.getEffect(a.getTotalSkillLevel(v20));
                            var25_32 = (int)((double)var4_5 * ((double)var26_35.getX() / 100.0));
                        }
                        var14_15 = var4_5 - var25_32;
                        if (a.getBuffedValue(MapleBuffStat.INFINITY) != null) {
                            var25_32 = 0;
                            v21 = a;
                        } else {
                            if (var25_32 > var19_22.getMp()) {
                                var25_32 = var19_22.getMp();
                                var14_15 = var4_5 - var25_32 + var9_10;
                            }
                            v21 = a;
                        }
                        v21.addMPHP(-var14_15, -var25_32);
                    }
                    ** GOTO lbl275
                }
                if (!a) break block86;
                var14_15 = 0;
                var25_33 = 0;
                if (var15_16) {
                    if (var19_22.getHp() > 1) {
                        var14_15 = var19_22.getHp() - 1;
                    }
                    if (var19_22.getMp() > 1) {
                        var25_33 = var19_22.getMp() - 1;
                    }
                    if (var5_6 != 0) {
                        var25_33 = 0;
                    }
                    a.addMPHP(-var14_15, -var25_33);
                } else {
                    var25_33 = (int)((double)var4_5 * (var23_31 / 100.0)) + var9_10;
                    var14_15 = var4_5 - var25_33;
                    if (var5_6 != 0) {
                        var25_33 = 0;
                        v22 = var18_19;
                    } else {
                        if (var25_33 > var19_22.getMp()) {
                            var25_33 = var19_22.getMp();
                            var14_15 = var4_5 - var25_33 + var9_10;
                        }
                        v22 = var18_19;
                    }
                    if (v22 != null) {
                        var14_15 = (int)MobConstants.MobDamageManage(var18_19, var14_15);
                    }
                    a.addMPHP(-var14_15, -var25_33);
                }
                ** GOTO lbl275
            }
            if (var22_29 != 0) {
                v23 = var4_5;
                var4_5 = var4_5 % 2 == 0 ? v23 / 2 : v23 / 2 + 1;
                var14_15 = (int)((double)var4_5 * a.getBuffedValue(MapleBuffStat.MESOGUARD).doubleValue() / 100.0);
                if (a.getMeso() < var14_15) {
                    v24 = a;
                    v24.gainMeso(-v24.getMeso(), false);
                    v25 = new MapleBuffStat[1];
                    v25[0] = MapleBuffStat.MESOGUARD;
                    v24.cancelBuffStats(v25);
                    v26 = var15_16;
                } else {
                    a.gainMeso(-var14_15, false);
                    v26 = var15_16;
                }
                if (v26 && var19_22.getMp() > 1) {
                    var9_10 = var19_22.getMp() - 1;
                }
                if (var18_19 != null) {
                    var4_5 = (int)MobConstants.MobDamageManage(var18_19, var4_5);
                }
                a.addMPHP(-var4_5, -var9_10);
                v27 = var18_19;
            } else if (var15_16) {
                var14_15 = var19_22.getHp() > 1 ? -(var19_22.getHp() - 1) : 0;
                v28 = var25_34 = var19_22.getMp() > 1 && var21_27 == false ? -(var19_22.getMp() - 1) : 0;
                if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a.getJob())) {
                    var25_34 = 0;
                }
                a.addMPHP(var14_15, var25_34);
                v27 = var18_19;
            } else {
                if (var18_19 != null) {
                    var4_5 = (int)MobConstants.MobDamageManage(var18_19, var4_5);
                }
                a.addMPHP(-var4_5, var21_27 != false ? 0 : -var9_10);
lbl275:
                // 5 sources

                v27 = var18_19;
            }
            if (v27 != null) {
                var4_5 = (int)MobConstants.MobDamageManage(var18_19, var4_5);
            }
            a.handleBattleshipHP(var4_5);
        }
        if (a.isHidden()) ** GOTO lbl306
        if (var18_19 != null) {
            var4_5 = (int)MobConstants.MobDamageManage(var18_19, var4_5);
        }
        var20_23 = 0;
        var21_28 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (a.available() == 1L) {
                v29 = a.readByte();
                var20_23 = v29;
                if (v29 < 0 || var20_23 > 2) {
                    var20_23 = 0;
                }
            } else if (a.available() == 5L) {
                v30 = a.readByte();
                var20_23 = v30;
                if (v30 == 1 && a.available() >= 4L) {
                    var21_28 = a.readInt();
                }
                if (var20_23 < 0 || var20_23 > 2) {
                    var20_23 = 0;
                }
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            v31 = a;
            v32 = v31;
            a.getMap().broadcastMessage(v31, MaplePacketCreator.damagePlayer(v31.getId(), var3_4, var4_5, var6_7, var7_8, var10_11, var12_13, var16_17, var11_12, var13_14, var17_18, var20_23, var21_28, var8_9), false);
        } else {
            v33 = a;
            a.getMap().broadcastMessage(v33, MaplePacketCreator.damagePlayer(v33.getId(), var3_4, var4_5, var6_7, var7_8, 0, 0, (boolean)0, 0, (byte)0, new Point(0, 0), (byte)0, 0, var8_9), false);
lbl306:
            // 2 sources

            v32 = a;
        }
        v32.reduceMove();
    }

    public static /* synthetic */ void UpdateLapidieication(LittleEndianAccessor a2, MapleCharacter a3) {
        int n2 = a2.readInt();
        if (a3 == null || a3.getMap() == null || !a3.isAlive()) {
            return;
        }
        if (a3.hasDisease(MapleBuffStat.LAPID_IFICATION) && n2 == 0) {
            MapleCharacter mapleCharacter = a3;
            mapleCharacter.setLapidification(false);
            mapleCharacter.cancelDeiseaseBuff(MapleBuffStat.LAPID_IFICATION);
        }
    }
}

