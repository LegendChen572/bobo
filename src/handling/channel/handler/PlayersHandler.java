/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleDisease;
import client.MapleJob;
import client.MapleLieDetector;
import client.MapleStat;
import client.PlayerStats;
import client.SkillFactory;
import client.anticheat.CheatTracker;
import client.anticheat.CheatingOffense;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import client.inventory.ModifyInventory;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import client.status.MonsterStatus;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.SkillConstants;
import handling.RecvPacketOpcode;
import handling.channel.ChannelServer;
import handling.channel.handler.PlayerHandler;
import handling.opcodes.MapleBuffStat;
import handling.world.MapleAntiMacro;
import handling.world.World;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import scripting.event.EventInstanceManager;
import scripting.event.EventManager;
import scripting.reactor.ReactorScriptManager;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.Randomizer;
import server.events.MapleCoconut;
import server.events.MapleEventType;
import server.life.MapleMonster;
import server.life.MobSkill;
import server.maps.FieldLimitType;
import server.maps.MapleDoor;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleMist;
import server.maps.MapleReactor;
import server.maps.MechDoor;
import server.quest.MapleQuest;
import tools.ArrayMap;
import tools.AttackPair;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.Triple;
import tools.data.LittleEndianAccessor;
import tools.otp.HmacOneTimePasswordGenerator;
import tools.packet.JobPacket;
import tools.packet.UIPacket;

public class PlayersHandler {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void UseAnyWhereDoor(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block9: {
            block8: {
                if (a == null || a.getMap() == null || a.hasBlockedInventory() || a == null) {
                    a.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                v0 = a;
                v1 = a;
                v0.updateTick(v1.readInt());
                var3_3 = v1.readInt();
                if (MapConstants.isBlockWarpMap(v0.getMapId())) {
                    v2 = a;
                    v2.sendPacket(MaplePacketCreator.getTrockMessage((byte)8));
                    v2.sendPacket(MaplePacketCreator.sendErrorAnyWhereDoor());
                    return;
                }
                var4_5 = ChannelServer.getInstance(a.getWorld(), a.getChannel()).getMapFactory().getMap(var3_3);
                if (a.getMapId() == var4_5.getId()) {
                    a.dropMessage(1, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u713f\u6cf2\u79e5\u52f2\u522e\u76df\u5412\u76a3\u535e\u57f8\u301c"));
                    a.sendPacket(MaplePacketCreator.sendErrorAnyWhereDoor());
                    return;
                }
                if (a.getLevel() < 10) {
                    a.dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u7b53\u7d4d\u4f54\u65eb+g\u7d00\u7176\u6ccf\u4f28\u7532\u6b33\u5285\u80aa\u3018"));
                    a.sendPacket(MaplePacketCreator.sendErrorAnyWhereDoor());
                    return;
                }
                if (FieldLimitType.VipRock.check(a.getPlayer().getMap().getFieldLimit()) || FieldLimitType.VipRock.check(var4_5.getFieldLimit()) || MapConstants.isMapleIsland(var3_3)) {
                    v3 = a;
                    v3.sendPacket(MaplePacketCreator.getTrockMessage((byte)8));
                    v3.sendPacket(MaplePacketCreator.sendErrorAnyWhereDoor());
                    return;
                }
                var3_4 = \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u4ee5\u6128\u959e");
                if (a.getAnyWhereDoor() <= 0) break block8;
                v4 = a;
                v4.setAnyWhereDoor(v4.getAnyWhereDoor() - 1);
                v4.dropMessage(5, "\u4f7f\u7528\u514d\u8cbb" + var3_4 + "\uff0c\u5f9e" + a.getMap().getMapName() + "\u50b3\u9001\u5230" + var4_5.getMapName() + "\uff0c\u672c\u6708\u5269\u9918\u4f7f\u7528\u6b21\u6578\uff1a " + a.getAnyWhereDoor() + " \u6b21\u3002");
                v5 = a;
                a.sendPacket(MaplePacketCreator.showAnyWhereDoor(v5.getAnyWhereDoor(), a.getAnyWhereDoorCash()));
                v6 = var4_5;
                v5.changeMap(v6, v6.getPortal(0));
                if (v5.getAnyWhereDoor() != 0) ** GOTO lbl54
                v7 = var3_4;
                a.dropMessage(1, "\u514d\u8cbb" + v7 + "\u5df2\u4f7f\u7528\u5b8c\u7562\uff01\r\n\u8acb\u81f3\u5546\u57ce\u64f4\u5145\u5f37\u5316" + v7);
                v8 = a;
                break block9;
            }
            v9 = a;
            if (a.getAnyWhereDoorCash() > 0) {
                v9.setAnyWhereDoorCash(a.getAnyWhereDoorCash() - 1);
                v10 = a;
                v10.dropMessage(5, "\u4f7f\u7528\u5f37\u5316" + var3_4 + "\uff0c\u5f9e" + v10.getMap().getMapName() + "\u50b3\u9001\u5230" + var4_5.getMapName() + "\u5269\u9918\u4f7f\u7528\u6b21\u6578\uff1a " + a.getAnyWhereDoorCash() + " \u6b21\u3002");
                v11 = a;
                v8 = v11;
                v11.sendPacket(MaplePacketCreator.showAnyWhereDoor(a.getAnyWhereDoor(), a.getAnyWhereDoorCash()));
                a.changeMap(var4_5, var4_5.getPortal(0));
            } else {
                if (v9.getAnyWhereDoor() == 0 && a.getAnyWhereDoorCash() == 0 && a.getCSPoints(0) <= 0) {
                    a.dropMessage(5, "\u4f7f\u7528\u5931\u6557\uff01\u8acb\u78ba\u8a8d\u662f\u5426" + var3_4 + "\u6b21\u6578\u8db3\u5920\u3002");
                }
lbl54:
                // 4 sources

                v8 = a;
            }
        }
        v8.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void Solomon(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient = a3;
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        mapleClient.getPlayer().updateTick(a2.readInt());
        IItem iItem = mapleClient.getPlayer().getInventory(MapleInventoryType.USE).getItem(a2.readShort());
        if (iItem == null || iItem.getItemId() != a2.readInt() || iItem.getQuantity() <= 0 || a3.getPlayer().getGachExp() > 0 || a3.getPlayer().getLevel() > 50 || MapleItemInformationProvider.getInstance().getItemEffect(iItem.getItemId()).getEXP() <= 0) {
            return;
        }
        MapleClient mapleClient2 = a3;
        mapleClient2.getPlayer().setGachExp(a3.getPlayer().getGachExp() + MapleItemInformationProvider.getInstance().getItemEffect(iItem.getItemId()).getEXP());
        MapleInventoryManipulator.removeFromSlot(mapleClient2, MapleInventoryType.USE, iItem.getPosition(), (short)1, false);
        a3.getPlayer().updateSingleStat(MapleStat.GACHAPONEXP, a3.getPlayer().getGachExp());
    }

    public static /* synthetic */ void hitCoconut(LittleEndianAccessor a2, MapleClient a3) {
        short s2 = a2.readShort();
        Object object = \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u8fac\u590c\u769a\u6a25\u8dbd");
        MapleCoconut mapleCoconut = (MapleCoconut)a3.getChannelServer().getEvent(MapleEventType.\u6253\u679c\u5b50);
        if (mapleCoconut == null || !mapleCoconut.isRunning()) {
            mapleCoconut = (MapleCoconut)a3.getChannelServer().getEvent(MapleEventType.\u6253\u74f6\u84cb);
            object = HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u53f5\u6a55\u7190");
            if (mapleCoconut == null || !mapleCoconut.isRunning()) {
                return;
            }
        }
        if ((object = mapleCoconut.getCoconut(s2)) == null || !((MapleCoconut.MapleCoconuts)object).isHittable()) {
            return;
        }
        if (System.currentTimeMillis() < ((MapleCoconut.MapleCoconuts)object).getHitTime()) {
            return;
        }
        if (((MapleCoconut.MapleCoconuts)object).getHits() > 2 && Math.random() < 0.4 && !((MapleCoconut.MapleCoconuts)object).isStopped()) {
            ((MapleCoconut.MapleCoconuts)object).setHittable(false);
            if (Math.random() < 0.01 && mapleCoconut.getStopped() > 0) {
                ((MapleCoconut.MapleCoconuts)object).setStopped(true);
                mapleCoconut.stopCoconut();
                a3.getPlayer().getMap().broadcastMessage(MaplePacketCreator.hitCoconut(false, s2, 1));
                return;
            }
            ((MapleCoconut.MapleCoconuts)object).resetHits();
            if (Math.random() < 0.05 && mapleCoconut.getBombings() > 0) {
                a3.getPlayer().getMap().broadcastMessage(MaplePacketCreator.hitCoconut(false, s2, 2));
                mapleCoconut.bombCoconut();
                return;
            }
            if (mapleCoconut.getFalling() > 0) {
                MapleClient mapleClient;
                MapleClient mapleClient2 = a3;
                mapleClient2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.hitCoconut(false, s2, 3));
                mapleCoconut.fallCoconut();
                MapleCoconut mapleCoconut2 = mapleCoconut;
                if (mapleClient2.getPlayer().getTeam() == 0) {
                    mapleCoconut2.addMapleScore();
                    mapleClient = a3;
                } else {
                    mapleCoconut2.addStoryScore();
                    mapleClient = a3;
                }
                mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.coconutScore(mapleCoconut.getCoconutScore()));
                return;
            }
        } else {
            ((MapleCoconut.MapleCoconuts)object).hit();
            a3.getPlayer().getMap().broadcastMessage(MaplePacketCreator.hitCoconut(false, s2, 1));
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 2;
        int cfr_ignored_0 = 5 << 4 ^ (3 << 2 ^ 1);
        int n5 = n3;
        int n6 = 3 ^ 5;
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

    public static /* synthetic */ void useLevelGuide(LittleEndianAccessor a2, MapleClient a32) {
        if (a32 == null || a32.getPlayer() == null) {
            return;
        }
        int a32 = a2.readInt();
    }

    public static /* synthetic */ void OldAntiMacroQuestion(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a3 == null || a4 == null) {
            return;
        }
        if (MapleAntiMacro.getCharacterState(a4) != 3) {
            return;
        }
        a3 = a2.readMapleAsciiString();
        MapleCharacter mapleCharacter = a4;
        if (MapleAntiMacro.verifyCode(a4.getName(), (String)a3)) {
            MapleAntiMacro.antiSuccess(mapleCharacter);
            return;
        }
        MapleAntiMacro.antiReduce(mapleCharacter);
    }

    public static /* synthetic */ void Note(LittleEndianAccessor a2, MapleCharacter a3) {
        byte by = a2.readByte();
        switch (by) {
            case 0: {
                LittleEndianAccessor littleEndianAccessor = a2;
                while (false) {
                }
                String string = littleEndianAccessor.readMapleAsciiString();
                String string2 = littleEndianAccessor.readMapleAsciiString();
                boolean bl = littleEndianAccessor.readByte() > 0;
                a2.readInt();
                IItem iItem = a3.getCashInventory().findByCashId((int)a2.readLong());
                if (iItem == null || !iItem.getGiftFrom().equalsIgnoreCase(string) || !a3.getCashInventory().canSendNote(iItem.getUniqueId())) {
                    return;
                }
                try {
                    a3.sendNote(string, string2, bl ? 1 : 0);
                    a3.getCashInventory().sendedNote(iItem.getUniqueId());
                    return;
                }
                catch (Exception exception) {
                    System.out.println(exception);
                    return;
                }
            }
            case 1: {
                int n2;
                LittleEndianAccessor littleEndianAccessor = a2;
                int n3 = littleEndianAccessor.readByteAsInt();
                littleEndianAccessor.skip(2);
                int n4 = n2 = 0;
                while (n4 < n3) {
                    a3.deleteNote(a2.readInt(), a2.readByte() > 0 ? 1 : 0);
                    n4 = ++n2;
                }
                break;
            }
            default: {
                System.out.println("Unhandled note action, " + by);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final /* synthetic */ void RespawnPVP(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        MapleClient mapleClient;
        Serializable serializable = new ReentrantLock();
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null || !a3.getPlayer().inPVP() || a3.getPlayer().isAlive()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient2 = a3;
        int n3 = Integer.parseInt(mapleClient2.getPlayer().getEventInstance().getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"SgW{")));
        int n4 = 0;
        mapleClient2.getPlayer().getStat().setHp(a3.getPlayer().getPvpMaxHp());
        a3.getPlayer().getStat().setMp(a3.getPlayer().getStat().getCurrentMaxMp());
        MapleClient mapleClient3 = a3;
        mapleClient3.getPlayer().updateSingleStat(MapleStat.HP, a3.getPlayer().getStat().getHp());
        MapleClient mapleClient4 = a3;
        mapleClient3.getPlayer().updateSingleStat(MapleStat.MP, mapleClient4.getPlayer().getStat().getMp());
        mapleClient4.getPlayer().getEventInstance().schedule(HmacOneTimePasswordGenerator.ALLATORIxDEMO("x%u6~4{$n\u0003c'\u007f"), 500L);
        serializable.lock();
        try {
            a3.getPlayer().getEventInstance().schedule(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"RnC\u007fS{t}HlB|H\u007fUz"), 500L);
        }
        finally {
            serializable.unlock();
        }
        a3.getPlayer().changeMap(a3.getPlayer().getMap(), a3.getPlayer().getMap().getPortal(n3 == 0 ? 0 : (n3 == 3 ? (a3.getPlayer().getTeam() == 0 ? 3 : 1) : (a3.getPlayer().getTeam() == 0 ? 2 : 3))));
        MapleClient mapleClient5 = a3;
        MapleClient mapleClient6 = a3;
        mapleClient5.sendPacket(MaplePacketCreator.getPVPScore(Integer.parseInt(mapleClient5.getPlayer().getEventInstance().getProperty(String.valueOf(mapleClient6.getPlayer().getId()))), false));
        if (mapleClient6.getPlayer().getLevel() >= 30 && a3.getPlayer().getLevel() < 70) {
            n4 = 0;
            mapleClient = a3;
        } else if (a3.getPlayer().getLevel() >= 70 && a3.getPlayer().getLevel() < 120) {
            n4 = 1;
            mapleClient = a3;
        } else if (a3.getPlayer().getLevel() >= 120 && a3.getPlayer().getLevel() < 180) {
            n4 = 2;
            mapleClient = a3;
        } else {
            if (a3.getPlayer().getLevel() >= 180) {
                n4 = 3;
            }
            mapleClient = a3;
        }
        List<MapleCharacter> list = mapleClient.getPlayer().getEventInstance().getPlayers();
        serializable = new LinkedList();
        int n5 = n2 = 0;
        while (n5 < serializable.size()) {
            serializable.add(new Pair<Integer, String>(list.get(n2).getId(), list.get(++n2).getName()));
            n5 = n2;
        }
        if (n3 == 1 || n3 == 3) {
            a3.sendPacket(MaplePacketCreator.getPVPType(n3, (List<Pair<Integer, String>>)((Object)serializable), a3.getPlayer().getTeam() + 1, true, n4));
            return;
        }
        a3.sendPacket(MaplePacketCreator.getPVPType(n3, (List<Pair<Integer, String>>)((Object)serializable), a3.getPlayer().getTeam(), true, n4));
    }

    public static /* synthetic */ void TouchReactor(LittleEndianAccessor a2, RecvPacketOpcode a32, MapleClient a4) {
        boolean bl;
        int a32 = a2.readInt();
        MapleReactor mapleReactor = a4.getPlayer().getMap().getReactorByOid(a32);
        if (mapleReactor == null || !mapleReactor.isAlive()) {
            return;
        }
        if (mapleReactor.getReactorId() == 9239000 && a4.getPlayer().getMapId() != 926010100) {
            return;
        }
        if (mapleReactor.getReactorId() == 9239000) {
            MapleMonster mapleMonster = a4.getPlayer().getMap().getMonsterByOid(a2.readInt());
            if (mapleMonster != null && a4.getPlayer().getEventInstance() != null) {
                MapleClient mapleClient = a4;
                int n2 = Integer.valueOf(mapleClient.getPlayer().getEventInstance().getEventManager().getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"KwA{")));
                mapleClient.getPlayer().getEventInstance().getEventManager().setProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO(";s1\u007f"), String.valueOf(n2 - 1));
                mapleClient.getPlayer().getEventInstance().broadcastPyramidLife(n2 - 1);
                mapleClient.getPlayer().getMap().killMonster(mapleMonster, a4.getPlayer(), false, false, (byte)1);
                if (n2 == 1) {
                    MapleClient mapleClient2 = a4;
                    mapleClient2.getPlayer().getEventInstance().getEventManager().setProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"A\u007fNrBz"), String.valueOf(1));
                    mapleClient2.getPlayer().getEventInstance().getEventManager().setProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("i#{0\u007f"), String.valueOf(3));
                    mapleClient2.getPlayer().getMap().killAllMonsters(true);
                }
            }
            return;
        }
        boolean bl2 = bl = a2.available() == 0L || a2.readByte() > 0;
        if (!(mapleReactor.getReactorId() == 9239000 || bl && mapleReactor.getTouch() != 0)) {
            return;
        }
        a4.getPlayer().dropGMMessage("\u53cd\u61c9\u7269\u8a0a\u606f - oid: " + a32 + " Touch: " + mapleReactor.getTouch() + " isTimerActive: " + mapleReactor.isTimerActive() + " ReactorType: " + mapleReactor.getReactorType());
        if (mapleReactor.getTouch() == 2) {
            ReactorScriptManager.getInstance().act(a4, mapleReactor);
            return;
        }
        if (mapleReactor.getTouch() == 1 && !mapleReactor.isTimerActive()) {
            mapleReactor.hitReactor(a4);
        }
    }

    public static /* synthetic */ void FollowRequest(LittleEndianAccessor a2, MapleClient a3) {
        MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(a2.readInt());
        if (a2.readByte() > 0) {
            mapleCharacter = a3.getPlayer().getMap().getCharacterById(a3.getPlayer().getFollowId());
            if (mapleCharacter != null && mapleCharacter.getFollowId() == a3.getPlayer().getId()) {
                mapleCharacter.setFollowOn(true);
                a3.getPlayer().setFollowOn(true);
                return;
            }
            a3.getPlayer().checkFollow();
            return;
        }
        if (a2.readByte() > 0) {
            mapleCharacter = a3.getPlayer().getMap().getCharacterById(a3.getPlayer().getFollowId());
            if (mapleCharacter != null && mapleCharacter.getFollowId() == a3.getPlayer().getId() && a3.getPlayer().isFollowOn()) {
                a3.getPlayer().checkFollow();
            }
            return;
        }
        if (mapleCharacter != null && mapleCharacter.getPosition().distanceSq(a3.getPlayer().getPosition()) < 10000.0 && mapleCharacter.getFollowId() == 0 && a3.getPlayer().getFollowId() == 0 && mapleCharacter.getId() != a3.getPlayer().getId()) {
            MapleClient mapleClient = a3;
            MapleCharacter mapleCharacter2 = mapleCharacter;
            MapleCharacter mapleCharacter3 = mapleCharacter;
            mapleCharacter3.setFollowId(a3.getPlayer().getId());
            mapleCharacter3.setFollowOn(false);
            mapleCharacter2.setFollowInitiator(false);
            mapleClient.getPlayer().setFollowOn(false);
            mapleClient.getPlayer().setFollowInitiator(false);
            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.followRequest(a3.getPlayer().getId()));
            return;
        }
        a3.sendPacket(MaplePacketCreator.getPopupMsg(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"GHk\u0007\u007fU{\u0007jHq\u0007xFl\u0007\u007fP\u007f^0")));
    }

    public static /* synthetic */ void viewSkills(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        if (a3.getPlayer().getMap() == null || !JobConstants.is\u5e7b\u5f71\u4fe0\u76dc(a3.getPlayer().getJob())) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.available() < 4L) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = null;
        int n2 = a2.readInt();
        mapleCharacter = a3.getPlayer().getMap().getCharacterById(n2);
        if (mapleCharacter != null) {
            MapleCharacter mapleCharacter2 = mapleCharacter;
            n2 = mapleCharacter2.getJob();
            if (!mapleCharacter2.getSkills().isEmpty() && MapleJob.is\u5192\u96aa\u5bb6(n2)) {
                a3.sendPacket(JobPacket.PhantomPacket.viewSkills(mapleCharacter));
                return;
            }
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(6, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u8a68\u8020\u6977\u4e5a\u6635\u51c5\u96b0\u5be1\u3018"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public static /* synthetic */ void KeepBuffs(LittleEndianAccessor a2, MapleClient a3) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void UpdateCharInfo(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a42) {
        if (a2.available() == 0L) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        switch (a2.readByte()) {
            case 0: {
                a42 = a2.readMapleAsciiString();
                a3.getPlayer().setcharmessage((String)a42);
                return;
            }
            case 1: {
                byte a42 = a2.readByte();
                if (a42 < 0 || a42 > 5) break;
                a3.getPlayer().setexpression(a42);
                return;
            }
            case 2: {
                LittleEndianAccessor littleEndianAccessor = a2;
                int a42 = littleEndianAccessor.readByte();
                byte by = littleEndianAccessor.readByte();
                int n2 = littleEndianAccessor.readByte();
                byte by2 = littleEndianAccessor.readByte();
                if (a42 >= 0 && a42 <= 3) {
                    a3.getPlayer().setblood(a42);
                }
                if (by >= 1 && by <= 12) {
                    a3.getPlayer().setmonth(by);
                }
                if (n2 >= 1 && n2 <= 31) {
                    int n3;
                    a42 = 31;
                    switch (by) {
                        case 4: 
                        case 6: 
                        case 9: 
                        case 11: {
                            a42 = 30;
                            n3 = n2;
                            break;
                        }
                        case 2: {
                            a42 = 29;
                        }
                        default: {
                            n3 = n2;
                        }
                    }
                    if (n3 <= a42 && n2 >= 1) {
                        a3.getPlayer().setday(n2);
                    }
                }
                if (by2 < 1 || by2 > 12) break;
                a3.getPlayer().setconstellation(by2);
                return;
            }
        }
    }

    public static /* synthetic */ void TransformPlayer(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a2.available() > 11L) {
            LittleEndianAccessor littleEndianAccessor = a2;
            a4.updateTick(littleEndianAccessor.readInt());
            int n2 = a2.readShort();
            n2 = littleEndianAccessor.readInt();
            Object object = littleEndianAccessor.readMapleAsciiString().toLowerCase();
            object = GameConstants.getInventoryType(n2);
            IItem iItem = null;
            if (object != null && a4.getInventory((MapleInventoryType)((Object)object)) != null) {
                iItem = a4.getInventory((MapleInventoryType)((Object)object)).findById(n2);
            }
            if (iItem == null || iItem.getQuantity() < 1 || iItem.getItemId() != n2) {
                a3.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
                return;
            }
        }
    }

    public static /* synthetic */ void UnlockItem(LittleEndianAccessor a2, MapleClient a3) {
        boolean bl;
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        s2 = littleEndianAccessor.readShort();
        short s3 = littleEndianAccessor.readShort();
        MapleInventoryType mapleInventoryType = MapleInventoryType.getByType((byte)s2);
        if (mapleInventoryType == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        IItem iItem = a3.getPlayer().getInventory(mapleInventoryType).getItem(s3);
        if (iItem == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        boolean bl2 = false;
        int n2 = 2051000;
        ArrayMap<IItem, MapleInventoryType> arrayMap = new ArrayMap<IItem, MapleInventoryType>();
        if (ItemFlag.LOCK.check(iItem.getFlag())) {
            IItem iItem2 = iItem;
            iItem2.setFlag(iItem2.getFlag() - ItemFlag.LOCK.getValue());
            bl2 = true;
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, iItem)));
            mapleClient.getPlayer().dropMessage(5, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5dec\u7db4\u89fd\u93b1\uff1f"));
            mapleClient.getPlayer().forceReAddItem_Flag(iItem, mapleInventoryType);
            bl = bl2;
        } else {
            if (ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                IItem iItem3 = iItem;
                iItem3.setFlag(iItem3.getFlag() - ItemFlag.UNTRADEABLE.getValue());
                bl2 = true;
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(1, iItem)));
                mapleClient.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5de8\u7dc4\u89f9\u93c1\uff1b"));
                mapleClient.getPlayer().forceReAddItem_Flag(iItem, mapleInventoryType);
            }
            bl = bl2;
        }
        if (bl) {
            arrayMap.put(iItem, mapleInventoryType);
            MapleInventoryManipulator.removeById(a3.getPlayer().getClient(), MapleInventoryType.USE, 2051000, 1, false, false);
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void ApplyLinkedSkill(LittleEndianAccessor a2, MapleClient a3) {
        MapleCharacter mapleCharacter = a3.getPlayer();
        if (mapleCharacter == null || mapleCharacter.getMap() == null || mapleCharacter.hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (mapleCharacter.getLevel() < 70) {
            mapleCharacter.dropMessage(1, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u670d\u6ee1\u0010.\u7d3d\u713f\u6cf2\u50ad\u63af\u629e\u80da\u301c"));
            return;
        }
        int n2 = a2.readInt();
        if (mapleCharacter.getSkillLevel(n2) < 1) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        int n3 = a2.readInt();
        Pair<String, Integer> pair = MapleCharacterUtil.getAcccountNameById(n3, a3.getPlayer().getWorld());
        if (pair == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        int n4 = pair.getRight();
        pair = pair.getLeft();
        MapleQuest mapleQuest = MapleQuest.getInstance(7783);
        if (mapleQuest == null || mapleCharacter.getAccountID() != n4) {
            mapleCharacter.dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u629a\u80aa\u50a9\u63df\u592b\u6500\u3018"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        Pair<Integer, Integer> pair2 = SkillConstants.getRelatedLinkSkill(mapleCharacter.getJob());
        if (pair2.getLeft() == 0) {
            mapleCharacter.dropMessage(1, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u629e\u80da\u50ad\u63af\u592f\u6570\u301c"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (mapleCharacter.teachSkill(pair2.getLeft(), n3) > 0 && pair2.getLeft() >= 80000000) {
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.changeTeachSkill(n2, n3);
            mapleQuest.forceComplete(mapleCharacter2, 0);
            a3.sendPacket(MaplePacketCreator.teachMessage(n2, n3, (String)((Object)pair)));
            return;
        }
        mapleCharacter.dropMessage(1, (String)((Object)pair) + "\u89d2\u8272\u5df2\u64c1\u6709\u6b64\u6280\u80fd\u3002");
    }

    public static /* synthetic */ void GachExp(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        MapleClient mapleClient2 = a3;
        mapleClient2.sendPacket(MaplePacketCreator.enableActions());
        mapleClient2.getPlayer().updateTick(a2.readInt());
        if (mapleClient2.getPlayer().getLevel() > 51) {
            MapleClient mapleClient3 = a3;
            mapleClient3.getPlayer().dropMessage(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u608f\u5dec\u8da2\u8d94\u0012/\u7b6e\u301c"));
            mapleClient3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a3.getPlayer().getGachExp() <= 0) {
            return;
        }
        MapleClient mapleClient4 = a3;
        int n2 = GameConstants.getExpNeededForLevel(mapleClient4.getPlayer().getLevel());
        int n3 = 0;
        n3 = n2 - a3.getPlayer().getExp();
        if (mapleClient4.getPlayer().getGachExp() > n3) {
            n3 = n2 - a3.getPlayer().getExp();
            mapleClient = a3;
        } else {
            MapleClient mapleClient5 = a3;
            mapleClient = mapleClient5;
            n3 = mapleClient5.getPlayer().getGachExp();
        }
        mapleClient.getPlayer().gainExp(n3, true, true, false);
        MapleClient mapleClient6 = a3;
        a3.getPlayer().setGachExp(mapleClient6.getPlayer().getGachExp() - n3);
        mapleClient6.getPlayer().updateSingleStat(MapleStat.GACHAPONEXP, a3.getPlayer().getGachExp());
    }

    public static /* synthetic */ boolean inArea(MapleCharacter a2) {
        for (Rectangle object : a2.getMap().getAreas()) {
            if (!object.contains(a2.getTruePosition())) continue;
            return true;
        }
        for (MapleMist mapleMist : a2.getMap().getAllMistsThreadsafe()) {
            if (mapleMist.getOwnerId() != a2.getId() || mapleMist.getMistType() != 2 || !mapleMist.getBox().contains(a2.getTruePosition())) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void AntiMacro(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4, boolean a5) {
        if (a3 == null || a4 == null || a4.getMap() == null) {
            return;
        }
        if (!a5 && !a4.isGM()) {
            return;
        }
        Object object = a2.readMapleAsciiString();
        object = a4.getMap().getCharacterByName((String)object);
        if (object == null || a4.getGMLevel() < ((MapleCharacter)object).getGMLevel()) {
            a3.sendPacket(MaplePacketCreator.AntiMacro.cantFindPlayer());
            return;
        }
        short s2 = 0;
        if (a5) {
            LittleEndianAccessor littleEndianAccessor = a2;
            s2 = littleEndianAccessor.readShort();
            IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(s2);
            int n2 = littleEndianAccessor.readInt();
            switch (n2) {
                case 2190000: {
                    if (iItem.getItemId() == n2) break;
                    return;
                }
                default: {
                    a4.dropMessage(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u9007\u502c\u6e32\u8b2d\u6a41\u9074\u5169\u668c\u665c\u4e2a\u80e3\u750f2\u8aec\u56c0\u5816\u7d78\u7b86\u7418\u54c6\u301c"));
                    return;
                }
            }
        }
        if (MapleAntiMacro.startAnti(a4, (MapleCharacter)object, (byte)(a5 ? 1 : 2)) && a5) {
            MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, s2, (short)1, false);
        }
    }

    public static /* synthetic */ void ChooseSkill(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null || !JobConstants.isPhantom(a3.getPlayer().getJob())) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        if (n3 <= 0) {
            a3.getPlayer().unchooseStolenSkill(n2);
            return;
        }
        a3.getPlayer().chooseStolenSkill(n3);
    }

    public static /* synthetic */ void UseDoor(LittleEndianAccessor a2, MapleCharacter a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        boolean bl = littleEndianAccessor.readByte() == 0;
        for (MapleDoor mapleDoor : a3.getMap().getAllDoorsThreadsafe()) {
            if (mapleDoor.getOwnerId() != n2) continue;
            mapleDoor.warp(a3, bl);
            return;
        }
    }

    public static /* synthetic */ void updateFriendPoints(LittleEndianAccessor a2, MapleClient a3322) {
        if (((MapleClient)a3322).getPlayer().getFriendShipToAdd() == 0) {
            ((MapleClient)a3322).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        n2 = littleEndianAccessor.readInt();
        n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        n3 = littleEndianAccessor.readInt();
        int n4 = littleEndianAccessor.readInt();
        n4 = littleEndianAccessor.readInt();
        int n5 = littleEndianAccessor.readInt();
        n5 = littleEndianAccessor.readInt();
        int n6 = 0;
        int n7 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            LittleEndianAccessor littleEndianAccessor2 = a2;
            n6 = littleEndianAccessor2.readInt();
            n7 = littleEndianAccessor2.readInt();
        }
        if (n2 + n3 + n4 + n5 + n7 != ((MapleClient)a3322).getPlayer().getFriendShipToAdd()) {
            ((MapleClient)a3322).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (n2 < 0 || n3 < 0 || n4 < 0 || n5 < 0 || n7 < 0) {
            ((MapleClient)a3322).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (n2 > 20 || n3 > 20 || n4 > 20 || n5 > 20 || n7 > 20) {
            ((MapleClient)a3322).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (((MapleClient)a3322).getPlayer().getMapId() / 1000000 != 744) {
            ((MapleClient)a3322).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        Object object = a3322;
        int[] a3322 = ((MapleClient)object).getPlayer().getFriendShipPoints();
        ((MapleClient)object).getPlayer().setFriendShipToAdd(0);
        int a3322 = a3322[0] + n2;
        n2 = a3322[1] + n3;
        n3 = a3322[2] + n4;
        n4 = a3322[3] + n5;
        n5 = a3322[4] + n7;
        ((MapleClient)object).getPlayer().setFriendShipPoints(a3322, n2, n3, n4, n5);
        ((MapleClient)object).sendPacket(MaplePacketCreator.updateFriendPoints(((MapleClient)object).getPlayer()));
        ((MapleClient)object).sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void LieDetector(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4, boolean a5) {
        if (a4 == null || a4.getMap() == null) {
            return;
        }
        String string = a2.readMapleAsciiString();
        byte by = 0;
        if (a5) {
            if (!a4.getCheatTracker().canLieDetector() && !a4.isGM()) {
                a4.dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u60b2\u5da5\u4f65\u757f\u9054\u4e57\u6b3b\u6e7b\u8b10\u563f\u3018\u66fc\u6658\u7176\u6ccf\u4f28\u7532\u6e7b\u8b10\u563f\u9049\u5120\u3018"));
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            LittleEndianAccessor littleEndianAccessor = a2;
            by = (byte)littleEndianAccessor.readShort();
            int n2 = littleEndianAccessor.readInt();
            IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
            if (iItem == null || iItem.getQuantity() <= 0 || iItem.getItemId() != n2 || n2 != 2190000) {
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
        } else if (!a4.isGM()) {
            return;
        }
        if (FieldLimitType.PotionUse.check(a4.getMap().getFieldLimit()) && a5 || a4.getMap().getReturnMapId() == a4.getMapId()) {
            a4.dropMessage(5, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u7551\u5253\u5717\u5708\u7106\u6ccb\u4f58\u7536\u6e0b\u8b14\u564f\u301c"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = a4.getMap().getCharacterByName(string);
        if (mapleCharacter == null || mapleCharacter.getId() == a4.getId() || mapleCharacter.isGM() && !a4.isGM()) {
            a4.dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u677d\u6264\u5267\u89c8\u8225\u3018"));
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            a3.getPlayer().marriage();
            return;
        }
        if (mapleCharacter.getEventInstance() != null || mapleCharacter.getMapId() == 180000001) {
            a4.dropMessage(5, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u7551\u5253\u5717\u5708\u7106\u6ccb\u4f58\u7536\u6e0b\u8b14\u564f\u301c"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (mapleCharacter.getAntiMacro().inProgress()) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.LieDetectorResponse((byte)3));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (mapleCharacter.getAntiMacro().isPassed()) {
            mapleCharacter.getAntiMacro().setPassed(false);
        }
        if (mapleCharacter.getAntiMacro().isPassed() && a5 || mapleCharacter.getAntiMacro().canDetector(System.currentTimeMillis())) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.LieDetectorResponse((byte)2));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!mapleCharacter.getAntiMacro().startLieDetector(a4.getName(), a5, false)) {
            a4.dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u4f28\u7532\u6e7b\u8b10\u563f\u592b\u6500\u3018"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a5) {
            MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
        }
        mapleCharacter.dropMessage(5, a4.getName() + " \u5c0d\u4f60\u4f7f\u7528\u6e2c\u8b0a\u5668");
    }

    public static /* synthetic */ void UseMechDoor(LittleEndianAccessor a2, MapleCharacter a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        Point point = littleEndianAccessor.readPos();
        byte by = littleEndianAccessor.readByte();
        MapleCharacter mapleCharacter = a3;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
        for (MechDoor mechDoor : mapleCharacter.getMap().getAllMechDoorsThreadsafe()) {
            if (mechDoor.getOwnerId() != n2 || mechDoor.getId() != by) continue;
            MapleCharacter mapleCharacter2 = a3;
            mapleCharacter2.checkFollow();
            mapleCharacter2.getMap().movePlayer(a3, point);
            return;
        }
    }

    public static /* synthetic */ void KeyDownMovingArea(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        if (a3 == null) {
            return;
        }
        a3 = ((MapleClient)a3).getPlayer();
        int n3 = a2.readByte();
        byte[] arrby = new byte[n3];
        int n4 = n2 = 0;
        while (n4 < n3) {
            arrby[n2++] = a2.readByte();
            n4 = n2;
        }
        Object object = a3;
        ((MapleCharacter)a3).getMap().broadcastMessage((MapleCharacter)object, MaplePacketCreator.keyDownAreaMoving((MapleCharacter)object, arrby), false);
    }

    public static /* synthetic */ void FollowReply(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().getFollowId() > 0 && a3.getPlayer().getFollowId() == a2.readInt()) {
            MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(a3.getPlayer().getFollowId());
            if (mapleCharacter != null && mapleCharacter.getPosition().distanceSq(a3.getPlayer().getPosition()) < 10000.0 && mapleCharacter.getFollowId() == 0 && mapleCharacter.getId() != a3.getPlayer().getId()) {
                boolean bl;
                boolean bl2 = bl = a2.readByte() > 0;
                if (bl) {
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    mapleCharacter.setFollowId(a3.getPlayer().getId());
                    mapleCharacter2.setFollowOn(true);
                    mapleCharacter2.setFollowInitiator(true);
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().setFollowOn(true);
                    a3.getPlayer().setFollowInitiator(false);
                    mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.followEffect(mapleCharacter.getId(), a3.getPlayer().getId(), null));
                    return;
                }
                a3.getPlayer().setFollowId(0);
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.setFollowId(0);
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.getFollowMsg(5));
                return;
            }
            if (mapleCharacter != null) {
                mapleCharacter.setFollowId(0);
                a3.getPlayer().setFollowId(0);
            }
            a3.sendPacket(MaplePacketCreator.getPopupMsg(HmacOneTimePasswordGenerator.ALLATORIxDEMO("C8ow{%\u007fwn8uw|6hw{ {.4")));
            return;
        }
        a3.getPlayer().setFollowId(0);
    }

    public static final /* synthetic */ void LeavePVP(LittleEndianAccessor a2, MapleClient a3) {
        if (!a3.getPlayer().inPVP()) {
            MapleClient mapleClient = a3;
            a3.getPlayer().changeMap(mapleClient.getChannelServer().getMapFactory().getMap(960000000));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null || !a3.getPlayer().inPVP()) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.pvpBlocked(6));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient = a3;
        int n2 = Integer.parseInt(mapleClient.getPlayer().getEventInstance().getProperty(String.valueOf(a3.getPlayer().getId())));
        if (Integer.parseInt(mapleClient.getPlayer().getEventInstance().getProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("v!v"))) < 2 && a3.getPlayer().getLevel() >= 120) {
            n2 /= 2;
        }
        MapleClient mapleClient2 = a3;
        MapleClient mapleClient3 = a3;
        mapleClient2.getPlayer().setTotalBattleExp(mapleClient3.getPlayer().getTotalBattleExp() + n2 / 10 * 3 / 2);
        mapleClient2.getPlayer().setBattlePoints(a3.getPlayer().getBattlePoints() + n2 / 10 * 3 / 2);
        mapleClient3.getPlayer().cancelAllBuffs();
        mapleClient2.getPlayer().changeRemoval();
        mapleClient2.getPlayer().dispelDebuffs();
        mapleClient2.getPlayer().clearAllCooldowns();
        mapleClient2.getPlayer().updateTick(a2.readInt());
        mapleClient2.sendPacket(UIPacket.clearMidMsg());
        mapleClient2.getPlayer().changeMap(a3.getChannelServer().getMapFactory().getMap(960000000));
        mapleClient2.getPlayer().getStat().recalcLocalStats(false);
        mapleClient2.getPlayer().getStat().heal(a3.getPlayer());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void AttackPVP(LittleEndianAccessor a2, MapleClient a3) {
        MapleCharacter mapleCharacter;
        int n2;
        MapleCharacter mapleCharacter2;
        MapleCharacter mapleCharacter3;
        boolean bl;
        Object object;
        int n3;
        byte by;
        boolean bl2;
        int n4;
        boolean bl3;
        MapleStatEffect mapleStatEffect;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        byte by2;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        MapleCharacter mapleCharacter4;
        block101: {
            block99: {
                int n14;
                int n15;
                int n16;
                Object object2;
                Object object3;
                double d2;
                boolean bl7;
                int n17;
                int n18;
                int n19;
                int n20;
                int n21;
                ReentrantLock reentrantLock;
                block98: {
                    block100: {
                        block97: {
                            double d3;
                            LittleEndianAccessor littleEndianAccessor;
                            reentrantLock = new ReentrantLock();
                            mapleCharacter4 = a3.getPlayer();
                            n12 = n13 = a2.readInt();
                            if (mapleCharacter4 == null || mapleCharacter4.isHidden() || !mapleCharacter4.isAlive() || mapleCharacter4.hasBlockedInventory() || mapleCharacter4.getMap() == null || !mapleCharacter4.inPVP() || !mapleCharacter4.getEventInstance().getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"mS\u007fUjBz")).equals("1") || n12 >= 90000000) {
                                a3.sendPacket(MaplePacketCreator.enableActions());
                                return;
                            }
                            MapleCharacter mapleCharacter5 = mapleCharacter4;
                            int n22 = Integer.parseInt(mapleCharacter5.getEventInstance().getProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("v!v")));
                            n21 = Integer.parseInt(mapleCharacter5.getEventInstance().getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"SgW{")));
                            n20 = Integer.parseInt(mapleCharacter5.getEventInstance().getProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("s4\u007f")));
                            n11 = Integer.parseInt(mapleCharacter5.getEventInstance().getProperty(String.valueOf(mapleCharacter4.getId())));
                            n10 = 0;
                            n9 = 0;
                            n8 = 0;
                            n7 = -1;
                            n6 = 0;
                            n5 = 1;
                            n19 = 1;
                            by2 = mapleCharacter5.getStat().passive_mastery();
                            n18 = mapleCharacter5.getStat().ignoreTargetDEF;
                            n17 = mapleCharacter5.getStat().passive_sharpeye_rate();
                            int n23 = 100;
                            bl7 = false;
                            bl6 = false;
                            bl5 = false;
                            bl4 = false;
                            d2 = n22 == 3 ? (double)mapleCharacter4.getStat().getCurrentMaxBasePVPDamageL() : (double)mapleCharacter4.getStat().getCurrentMaxBasePVPDamage();
                            mapleStatEffect = null;
                            MapleCharacter mapleCharacter6 = mapleCharacter4;
                            mapleCharacter6.checkFollow();
                            object3 = null;
                            IItem iItem = mapleCharacter6.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
                            IItem iItem2 = mapleCharacter6.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-10);
                            boolean bl8 = iItem2 != null && iItem2.getItemId() / 10000 == 134;
                            bl3 = iItem != null && iItem.getItemId() / 10000 == 144 && GameConstants.isAran(mapleCharacter4.getJob());
                            a2.skip(1);
                            n4 = 0;
                            LittleEndianAccessor littleEndianAccessor2 = a2;
                            if (SkillConstants.isMagicChargeSkill(n12)) {
                                n4 = littleEndianAccessor2.readInt();
                                littleEndianAccessor = a2;
                            } else {
                                littleEndianAccessor2.skip(4);
                                littleEndianAccessor = a2;
                            }
                            bl2 = littleEndianAccessor.readByte() > 0;
                            n7 = GameConstants.getRandDisplayByWeapon(iItem.getItemId(), bl8, bl3, n12);
                            n6 = GameConstants.getRandAnimationBySkill(n12);
                            if (n12 > 0) {
                                if (n12 == 3211006 && mapleCharacter4.getTotalSkillLevel(3220010) > 0) {
                                    n12 = 3220010;
                                }
                                if ((object2 = SkillFactory.getSkill(n12)) == null || object2.isPVPDisabled()) {
                                    a3.sendPacket(MaplePacketCreator.enableActions());
                                    return;
                                }
                                ISkill iSkill = object2;
                                bl7 = iSkill.isMagic();
                                bl6 = iSkill.isMovement();
                                bl4 = iSkill.isPush();
                                bl5 = iSkill.isPull();
                                if (mapleCharacter4.getTotalSkillLevel(GameConstants.getLinkedAranSkill(n12)) <= 0) {
                                    if (!SkillConstants.isIceKnightSkill(n12) && mapleCharacter4.getTotalSkillLevel(GameConstants.getLinkedAranSkill(n12)) <= 0) {
                                        a3.getSession().close();
                                        return;
                                    }
                                    if (SkillConstants.isIceKnightSkill(n12) && mapleCharacter4.getBuffSource(MapleBuffStat.MORPH) % 10000 != 1105) {
                                        return;
                                    }
                                }
                                if (object2.isMagic()) {
                                    by2 = 0;
                                }
                                MapleCharacter mapleCharacter7 = mapleCharacter4;
                                n9 = mapleCharacter7.getTotalSkillLevel(GameConstants.getLinkedAranSkill(n12));
                                n8 = mapleCharacter7.getTotalSkillLevel(GameConstants.getLinkedAranSkill(n13));
                                mapleStatEffect = object2.getPVPEffect(n9);
                                n18 += mapleStatEffect.getIgnoreMob();
                                n17 += mapleStatEffect.getCr();
                                MapleStatEffect mapleStatEffect2 = mapleStatEffect;
                                n23 = mapleStatEffect2.getDamage() + mapleCharacter4.getStat().getDamageIncrease(n12);
                                object3 = mapleStatEffect2.calculateBoundingBox(mapleCharacter4.getTruePosition(), bl2, mapleCharacter4.getStat().defRange);
                                n5 = Math.max(mapleStatEffect2.getBulletCount(), mapleStatEffect.getAttackCount());
                                MapleStatEffect mapleStatEffect3 = mapleStatEffect;
                                n19 = Math.max(1, mapleStatEffect3.getMobCount());
                                if (mapleStatEffect3.getCooldown(mapleCharacter4) > 0 && !mapleCharacter4.isGM()) {
                                    if (mapleCharacter4.skillisCooling(n12)) {
                                        a3.sendPacket(MaplePacketCreator.enableActions());
                                        return;
                                    }
                                    if (n12 != 35111004 && n12 != 35121013 || mapleCharacter4.getBuffSource(MapleBuffStat.MECH_CHANGE) != n12) {
                                        a3.sendPacket(MaplePacketCreator.skillCooldown(n12, mapleStatEffect.getCooldown(mapleCharacter4)));
                                        mapleCharacter4.addCooldown(n12, System.currentTimeMillis(), mapleStatEffect.getCooldown(mapleCharacter4) * 1000);
                                    }
                                }
                                switch (mapleCharacter4.getJob()) {
                                    case 111: 
                                    case 112: 
                                    case 1111: 
                                    case 1112: {
                                        if (PlayerHandler.isFinisher(n12) <= 0) break;
                                        if (mapleCharacter4.getBuffedValue(MapleBuffStat.COMBO) == null || mapleCharacter4.getBuffedValue(MapleBuffStat.COMBO) <= 2) {
                                            return;
                                        }
                                        n23 *= (mapleCharacter4.getBuffedValue(MapleBuffStat.COMBO) - 1) / 2;
                                        MapleCharacter mapleCharacter8 = mapleCharacter4;
                                        mapleCharacter8.handleOrbConsume(mapleCharacter8.getBuffSource(MapleBuffStat.COMBO), n12);
                                    }
                                }
                            } else {
                                MapleCharacter mapleCharacter9;
                                List<Triple<String, Point, Point>> list;
                                String string;
                                n5 = bl8 ? 2 : 1;
                                object2 = null;
                                Point point = null;
                                String string2 = bl3 ? \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"FlFp") : (bl8 ? HmacOneTimePasswordGenerator.ALLATORIxDEMO("<{#{%{") : (string = iItem == null ? \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"|FlBvFpCm") : MapleItemInformationProvider.getInstance().getAfterImage(iItem.getItemId())));
                                if (string != null && (list = MapleItemInformationProvider.getInstance().getAfterImage(string)) != null) {
                                    reentrantLock.lock();
                                    try {
                                        ReentrantLock reentrantLock2;
                                        block93: {
                                            for (n16 = 0; n16 < list.size(); ++n16) {
                                                Triple<String, Point, Point> triple = list.get(n16);
                                                if (!((String)triple.left).contains(HmacOneTimePasswordGenerator.ALLATORIxDEMO("$n6x")) && (n12 == 4001002 || n12 == 14001002) || ((String)triple.left).contains(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"TjF|")) && iItem != null && iItem.getItemId() / 10000 == 147 || SkillFactory.getDelay((String)triple.left) == null) continue;
                                                object2 = (Point)triple.mid;
                                                point = (Point)triple.right;
                                                reentrantLock2 = reentrantLock;
                                                break block93;
                                            }
                                            reentrantLock2 = reentrantLock;
                                        }
                                        reentrantLock2.unlock();
                                        mapleCharacter9 = mapleCharacter4;
                                    }
                                    catch (Throwable throwable) {
                                        reentrantLock.unlock();
                                        throw throwable;
                                    }
                                }
                                mapleCharacter9 = mapleCharacter4;
                                object3 = MapleStatEffect.calculateBoundingBox(mapleCharacter9.getTruePosition(), bl2, (Point)object2, point, mapleCharacter4.getStat().defRange);
                            }
                            MapleCharacter mapleCharacter10 = mapleCharacter4;
                            mapleCharacter10.getCheatTracker().checkPVPAttack(n12);
                            object2 = mapleCharacter10.getStatForBuff(MapleBuffStat.SHADOWPARTNER);
                            n15 = n5;
                            n5 *= object2 != null ? 2 : 1;
                            a2.readShort();
                            LittleEndianAccessor littleEndianAccessor3 = a2;
                            littleEndianAccessor3.skip(2);
                            by = littleEndianAccessor3.readByte();
                            n14 = littleEndianAccessor3.readShort();
                            n16 = littleEndianAccessor3.readShort();
                            n3 = 0;
                            if (mapleCharacter4.getJob() >= 3500 && mapleCharacter4.getJob() <= 3512) {
                                n3 = 2333000;
                                d3 = d2;
                            } else if (GameConstants.isCannon(mapleCharacter4.getJob())) {
                                n3 = 2333001;
                                d3 = d2;
                            } else {
                                if (!GameConstants.isMercedes(mapleCharacter4.getJob()) && mapleCharacter4.getBuffedValue(MapleBuffStat.SOULARROW) == null && n14 > 0) {
                                    object = mapleCharacter4.getInventory(MapleInventoryType.USE).getItem((short)n14);
                                    if (object == null) {
                                        return;
                                    }
                                    if (n16 > 0 && (object = mapleCharacter4.getInventory(MapleInventoryType.CASH).getItem((short)n16)) == null) {
                                        return;
                                    }
                                    n3 = object.getItemId();
                                }
                                d3 = d2;
                            }
                            d2 = d3 * ((double)n23 / 100.0);
                            d2 *= mapleCharacter4.getStat().dam_r / 100.0;
                            object = new ArrayList(n19);
                            n23 = PlayersHandler.inArea(mapleCharacter4) ? 1 : 0;
                            bl = false;
                            bl3 = false;
                            if (n23 != 0) break block97;
                            object3 = mapleCharacter4.getMap().getCharactersIntersect((Rectangle)object3).iterator();
                            break block98;
                        }
                        if (n21 != 3) break block99;
                        if (Integer.parseInt(mapleCharacter4.getEventInstance().getProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("h2~1v6}"))) != mapleCharacter4.getId() || !mapleCharacter4.getMap().getArea(1).contains(mapleCharacter4.getTruePosition())) break block100;
                        MapleCharacter mapleCharacter11 = mapleCharacter4;
                        mapleCharacter11.getEventInstance().setProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"lBzArFy"), HmacOneTimePasswordGenerator.ALLATORIxDEMO("*"));
                        MapleCharacter mapleCharacter12 = mapleCharacter4;
                        mapleCharacter11.getEventInstance().setProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"ErR{"), String.valueOf(Integer.parseInt(mapleCharacter12.getEventInstance().getProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("5v\"\u007f"))) + 1));
                        mapleCharacter12.getEventInstance().broadcastPlayerMsg(-7, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\\KkB>s{Fs\u0007vFm\u0007mDqU{C>F>WqNpS?"));
                        mapleCharacter11.getMap().spawnAutoDrop(2910000, (Point)mapleCharacter4.getMap().getGuardians().get((int)0).left);
                        MapleCharacter mapleCharacter13 = mapleCharacter4;
                        mapleCharacter3 = mapleCharacter13;
                        MapleCharacter mapleCharacter14 = mapleCharacter4;
                        mapleCharacter13.getEventInstance().broadcastPacket(MaplePacketCreator.getCapturePosition(mapleCharacter14.getMap()));
                        mapleCharacter13.getEventInstance().broadcastPacket(MaplePacketCreator.resetCapture());
                        mapleCharacter14.getEventInstance().schedule(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\"j3{#\u007f\u0004y8h2x8{%~"), 1000L);
                        break block101;
                    }
                    if (Integer.parseInt(mapleCharacter4.getEventInstance().getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"ErR{ArFy"))) == mapleCharacter4.getId() && mapleCharacter4.getMap().getArea(0).contains(mapleCharacter4.getTruePosition())) {
                        MapleCharacter mapleCharacter15 = mapleCharacter4;
                        mapleCharacter15.getEventInstance().setProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("5v\"\u007f1v6}"), \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"."));
                        MapleCharacter mapleCharacter16 = mapleCharacter4;
                        mapleCharacter15.getEventInstance().setProperty(HmacOneTimePasswordGenerator.ALLATORIxDEMO("h2~"), String.valueOf(Integer.parseInt(mapleCharacter16.getEventInstance().getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"lBz"))) + 1));
                        mapleCharacter16.getEventInstance().broadcastPlayerMsg(-7, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u0005\u007f3:\u0003\u007f6wwr6iwi4u%\u007f3:6:'u>t#;"));
                        mapleCharacter15.getMap().spawnAutoDrop(2910001, (Point)mapleCharacter4.getMap().getGuardians().get((int)1).left);
                        MapleCharacter mapleCharacter17 = mapleCharacter4;
                        MapleCharacter mapleCharacter18 = mapleCharacter4;
                        mapleCharacter17.getEventInstance().broadcastPacket(MaplePacketCreator.getCapturePosition(mapleCharacter18.getMap()));
                        mapleCharacter17.getEventInstance().broadcastPacket(MaplePacketCreator.resetCapture());
                        mapleCharacter18.getEventInstance().schedule(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"RnC\u007fS{t}HlB|H\u007fUz"), 1000L);
                    }
                    break block99;
                }
                while (object3.hasNext()) {
                    MapleCharacter mapleCharacter19;
                    int n24;
                    MapleCharacter mapleCharacter20;
                    int n25;
                    Object object4;
                    MapleCharacter mapleCharacter21 = (MapleCharacter)object3.next();
                    if (mapleCharacter21.getId() == mapleCharacter4.getId() || !mapleCharacter21.isAlive() || mapleCharacter21.isHidden() || n21 != 0 && mapleCharacter21.getTeam() == mapleCharacter4.getTeam()) continue;
                    MapleCharacter mapleCharacter22 = mapleCharacter21;
                    double d4 = d2 / Math.max(1.0, (double)(bl7 ? mapleCharacter22.getStat().mdef : mapleCharacter22.getStat().wdef) * Math.max(1.0, 100.0 - (double)n18) / 100.0 * (n21 == 3 ? 0.2 : 0.5));
                    if (mapleCharacter21.getBuffedValue(MapleBuffStat.INVINCIBILITY) != null || PlayersHandler.inArea(mapleCharacter21)) {
                        d4 = 0.0;
                    }
                    d4 *= mapleCharacter21.getStat().mesoGuard / 100.0;
                    d4 += d4 * (double)mapleCharacter4.getDamageIncrease(mapleCharacter21.getId()) / 100.0;
                    MapleCharacter mapleCharacter23 = mapleCharacter21;
                    d4 = (Double)mapleCharacter23.modifyDamageTaken((double)d4, (MapleMapObject)mapleCharacter23, (int)n12).left;
                    double d5 = d4 * (double)mapleCharacter4.getStat().trueMastery / 100.0;
                    ArrayList<Pair<Integer, Boolean>> arrayList = new ArrayList<Pair<Integer, Boolean>>(n5);
                    n14 = 0;
                    n16 = 0;
                    reentrantLock.lock();
                    try {
                        int n26;
                        for (int i2 = 0; i2 < n5; ++i2, n14 += n26) {
                            double d6;
                            boolean bl9 = false;
                            n26 = 0;
                            double d7 = (double)Randomizer.nextInt((int)Math.abs(Math.round(d4 - d5)) + 2) + d5;
                            if (mapleCharacter21.getStat().dodgeChance > 0 && Randomizer.nextInt(100) < mapleCharacter21.getStat().dodgeChance) {
                                d6 = d7 = 0.0;
                            } else if (mapleCharacter21.hasDisease(MapleBuffStat.DARKNESS) && Randomizer.nextInt(100) < 50) {
                                d6 = d7 = 0.0;
                            } else {
                                if (mapleCharacter21.getJob() == 122 && mapleCharacter21.getTotalSkillLevel(1220006) > 0 && mapleCharacter21.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-10) != null) {
                                    object4 = SkillFactory.getSkill(1220006).getEffect(mapleCharacter21.getTotalSkillLevel(1220006));
                                    if (((MapleStatEffect)object4).makeChanceResult()) {
                                        d7 = 0.0;
                                    }
                                } else if (mapleCharacter21.getJob() == 412 && mapleCharacter21.getTotalSkillLevel(4120002) > 0) {
                                    object4 = SkillFactory.getSkill(4120002).getEffect(mapleCharacter21.getTotalSkillLevel(4120002));
                                    if (((MapleStatEffect)object4).makeChanceResult()) {
                                        d7 = 0.0;
                                    }
                                } else if (mapleCharacter21.getJob() == 422 && mapleCharacter21.getTotalSkillLevel(0x406466) > 0) {
                                    object4 = SkillFactory.getSkill(4220002).getEffect(mapleCharacter21.getTotalSkillLevel(4220002));
                                    if (((MapleStatEffect)object4).makeChanceResult()) {
                                        d7 = 0.0;
                                    }
                                } else if (object2 != null && i2 >= n15) {
                                    d7 *= (double)((MapleStatEffect)object2).getX() / 100.0;
                                }
                                d6 = d7;
                            }
                            if (d6 > 0.0 && n12 != 4211006 && n12 != 3211003 && n12 != 4111004 && (n12 == 4221001 || n12 == 3221007 || n12 == 23121003 || n12 == 4341005 || n12 == 4331006 || n12 == 21120005 || Randomizer.nextInt(100) < n17)) {
                                d7 *= (100.0 + (double)(Randomizer.nextInt(Math.max(2, mapleCharacter4.getStat().passive_sharpeye_percent() - mapleCharacter4.getStat().passive_sharpeye_min_percent())) + mapleCharacter4.getStat().passive_sharpeye_min_percent())) / 100.0;
                                bl9 = true;
                            }
                            if (mapleCharacter21.getBuffedValue(MapleBuffStat.MAGIC_GUARD) != null) {
                                n26 = (int)Math.min((double)mapleCharacter21.getStat().getMp(), d7 * mapleCharacter21.getBuffedValue(MapleBuffStat.MAGIC_GUARD).doubleValue() / 100.0);
                            }
                            d7 -= (double)n26;
                            if (mapleCharacter21.getBuffedValue(MapleBuffStat.INFINITY) != null) {
                                n26 = 0;
                            }
                            arrayList.add(new Pair<Integer, Boolean>((int)Math.floor(d7), bl9));
                            n16 = (int)((double)n16 + Math.floor(d7));
                        }
                    }
                    finally {
                        reentrantLock.unlock();
                    }
                    if (GameConstants.isDemon(mapleCharacter4.getJob())) {
                        mapleCharacter4.handleForceGain(mapleCharacter21.getObjectId(), n12);
                    }
                    n10 += Math.min(mapleCharacter21.getStat().getHp() / 100, n16 / 100 + n14 / 100);
                    int n27 = n16;
                    mapleCharacter21.addMPHP(-n27, -n14);
                    Object object5 = object;
                    object.add(new AttackPair(mapleCharacter21.getId(), mapleCharacter21.getPosition(), arrayList));
                    MapleCharacter mapleCharacter24 = mapleCharacter21;
                    mapleCharacter4.onAttack(null, mapleCharacter24.getStat().getCurrentMaxHp(), mapleCharacter21.getStat().getCurrentMaxMp(), null, n12, mapleCharacter21.getObjectId(), n16);
                    mapleCharacter24.getCheatTracker().setAttacksWithoutHit(false);
                    if (n27 > 0) {
                        bl = true;
                    }
                    if (mapleCharacter21.getStat().getHPPercent() <= 20) {
                        mapleCharacter21.getStat();
                        SkillFactory.getSkill(PlayerStats.getSkillByJob(93, mapleCharacter21.getJob())).getEffect(1).applyTo(mapleCharacter21);
                    }
                    if (mapleStatEffect != null) {
                        MapleStatEffect mapleStatEffect4;
                        if (mapleStatEffect.getMonsterStati().size() > 0 && mapleStatEffect.makeChanceResult()) {
                            reentrantLock.lock();
                            try {
                                for (Map.Entry<MonsterStatus, Integer> entry : mapleStatEffect.getMonsterStati().entrySet()) {
                                    MapleBuffStat mapleBuffStat = MonsterStatus.getLinkedDisease(entry.getKey());
                                    if (mapleBuffStat == null) continue;
                                    mapleCharacter21.giveDebuff(mapleBuffStat, entry.getValue(), mapleStatEffect.getDuration(), MobSkill.getByDisease(mapleBuffStat), 1);
                                }
                                mapleStatEffect4 = mapleStatEffect;
                            }
                            finally {
                                reentrantLock.unlock();
                            }
                        } else {
                            mapleStatEffect4 = mapleStatEffect;
                        }
                        mapleStatEffect4.handleExtraPVP(mapleCharacter4, mapleCharacter21);
                    }
                    if (mapleCharacter4.getJob() == 121 || mapleCharacter4.getJob() == 122 || mapleCharacter4.getJob() == 2110 || mapleCharacter4.getJob() == 2111 || mapleCharacter4.getJob() == 2112) {
                        MapleStatEffect mapleStatEffect5;
                        if ((mapleCharacter4.getBuffSource(MapleBuffStat.WK_CHARGE) == 1211006 || mapleCharacter4.getBuffSource(MapleBuffStat.WK_CHARGE) == 21101006) && (mapleStatEffect5 = mapleCharacter4.getStatForBuff(MapleBuffStat.WK_CHARGE)).makeChanceResult()) {
                            mapleCharacter21.giveDebuff(MapleBuffStat.FREEZE, 1, mapleStatEffect5.getDuration(), MapleDisease.getByDisease(MapleDisease.FREEZE), 1);
                        }
                    } else if (mapleCharacter4.getBuffedValue(MapleBuffStat.HAMSTRING) != null) {
                        MapleStatEffect mapleStatEffect6 = mapleCharacter4.getStatForBuff(MapleBuffStat.HAMSTRING);
                        if (mapleStatEffect6 != null && mapleStatEffect6.makeChanceResult()) {
                            mapleCharacter21.giveDebuff(MapleBuffStat.SLOW, 100 - Math.abs(mapleStatEffect6.getX()), mapleStatEffect6.getDuration(), MapleDisease.getByDisease(MapleDisease.SLOW), 1);
                        }
                    } else if (mapleCharacter4.getBuffedValue(MapleBuffStat.SLOW) != null) {
                        MapleStatEffect mapleStatEffect7 = mapleCharacter4.getStatForBuff(MapleBuffStat.SLOW);
                        if (mapleStatEffect7 != null && mapleStatEffect7.makeChanceResult()) {
                            mapleCharacter21.giveDebuff(MapleBuffStat.SLOW, 100 - Math.abs(mapleStatEffect7.getX()), mapleStatEffect7.getDuration(), MapleDisease.getByDisease(MapleDisease.SLOW), 1);
                        }
                    } else if (mapleCharacter4.getJob() == 412 || mapleCharacter4.getJob() == 422 || mapleCharacter4.getJob() == 434 || mapleCharacter4.getJob() == 1411 || mapleCharacter4.getJob() == 1412) {
                        int[] arrn = new int[4];
                        arrn[0] = 4120005;
                        arrn[1] = 4220005;
                        arrn[2] = 4340001;
                        arrn[3] = 14110004;
                        int[] arrn2 = arrn;
                        reentrantLock.lock();
                        try {
                            ReentrantLock reentrantLock3;
                            block95: {
                                int[] arrn3 = arrn2;
                                int n28 = arrn2.length;
                                for (int i3 = 0; i3 < n28; ++i3) {
                                    n25 = arrn3[i3];
                                    object4 = SkillFactory.getSkill(n25);
                                    if (mapleCharacter4.getTotalSkillLevel((ISkill)object4) <= 0) continue;
                                    Object object6 = object4;
                                    MapleStatEffect mapleStatEffect8 = object6.getEffect(mapleCharacter4.getTotalSkillLevel((ISkill)object6));
                                    if (!mapleStatEffect8.makeChanceResult()) break;
                                    reentrantLock3 = reentrantLock;
                                    mapleCharacter21.giveDebuff(MapleBuffStat.POISON, 1, mapleStatEffect8.getDuration(), MapleDisease.getByDisease(MapleDisease.POISON), 1);
                                    break block95;
                                }
                                reentrantLock3 = reentrantLock;
                            }
                            reentrantLock3.unlock();
                            mapleCharacter20 = mapleCharacter4;
                        }
                        catch (Throwable throwable) {
                            reentrantLock.unlock();
                            throw throwable;
                        }
                    }
                    mapleCharacter20 = mapleCharacter4;
                    if (mapleCharacter20.getJob() / 100 % 10 == 2) {
                        int[] arrn = new int[4];
                        arrn[0] = 2000007;
                        arrn[1] = 12000006;
                        arrn[2] = 22000002;
                        arrn[3] = 32000012;
                        int[] arrn4 = arrn;
                        reentrantLock.lock();
                        try {
                            ReentrantLock reentrantLock4;
                            block96: {
                                int[] arrn5 = arrn4;
                                int n29 = arrn4.length;
                                for (int i4 = 0; i4 < n29; ++i4) {
                                    n25 = arrn5[i4];
                                    object4 = SkillFactory.getSkill(n25);
                                    if (mapleCharacter4.getTotalSkillLevel((ISkill)object4) <= 0) continue;
                                    Object object7 = object4;
                                    MapleStatEffect mapleStatEffect9 = object7.getEffect(mapleCharacter4.getTotalSkillLevel((ISkill)object7));
                                    if (!mapleStatEffect9.makeChanceResult()) break;
                                    reentrantLock4 = reentrantLock;
                                    mapleStatEffect9.applyTo(mapleCharacter21);
                                    break block96;
                                }
                                reentrantLock4 = reentrantLock;
                            }
                            reentrantLock4.unlock();
                            n24 = n20;
                        }
                        catch (Throwable throwable) {
                            reentrantLock.unlock();
                            throw throwable;
                        }
                    }
                    n24 = n20;
                    if (n24 == mapleCharacter21.getId()) {
                        MapleCharacter mapleCharacter25 = mapleCharacter21;
                        mapleCharacter19 = mapleCharacter25;
                        mapleCharacter4.getClient().sendPacket(MaplePacketCreator.getPVPIceHPBar(mapleCharacter21.getStat().getHp(), mapleCharacter25.getStat().getCurrentMaxHp()));
                    } else {
                        mapleCharacter4.getClient().sendPacket(MaplePacketCreator.getPVPHPBar(mapleCharacter21.getId(), mapleCharacter21.getStat().getHp(), mapleCharacter21.getPvpMaxHp()));
                        mapleCharacter19 = mapleCharacter21;
                    }
                    if (!mapleCharacter19.isAlive()) {
                        bl3 = true;
                        n10 += 5;
                    }
                    if (object.size() < n19) continue;
                }
            }
            mapleCharacter3 = mapleCharacter4;
        }
        if (mapleCharacter3.getEventInstance() == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (bl3 || n10 > 0) {
            MapleCharacter mapleCharacter26 = mapleCharacter4;
            mapleCharacter26.getEventInstance().addPVPScore(mapleCharacter4, n10);
            mapleCharacter26.getClient().sendPacket(MaplePacketCreator.getPVPScore(n11 + n10, bl3));
        }
        if (bl) {
            MapleCharacter mapleCharacter27 = mapleCharacter4;
            mapleCharacter27.afterAttack(object.size(), n5, n12);
            PlayerHandler.AranCombo(a3, mapleCharacter27, object.size() * n5);
            if (n12 > 0 && (object.size() > 0 || n12 != 4331003 && n12 != 4341002) && !GameConstants.isNoDelaySkill(n12)) {
                MapleCharacter mapleCharacter28 = mapleCharacter4;
                mapleCharacter2 = mapleCharacter28;
                mapleStatEffect.applyTo(mapleCharacter28, mapleCharacter28.getTruePosition());
            } else {
                a3.sendPacket(MaplePacketCreator.enableActions());
                mapleCharacter2 = mapleCharacter4;
            }
        } else {
            bl6 = false;
            bl5 = false;
            bl4 = false;
            mapleCharacter2 = mapleCharacter4;
            a3.sendPacket(MaplePacketCreator.enableActions());
        }
        MapleMap mapleMap = mapleCharacter2.getMap();
        int n30 = mapleCharacter4.getId();
        short s2 = mapleCharacter4.getLevel();
        if (bl2) {
            n2 = 1;
            mapleCharacter = mapleCharacter4;
        } else {
            n2 = 0;
            mapleCharacter = mapleCharacter4;
        }
        mapleMap.broadcastMessage(MaplePacketCreator.pvpAttack(n30, s2, n13, n8, by, by2, n3, n5, n4, n7, n6, n2, mapleCharacter.getStat().defRange, n12, n9, bl6, bl4, bl5, (List<AttackPair>)object));
        if (n10 > 0 && GameConstants.getAttackDelay(mapleCharacter4, n12) >= 100) {
            CheatTracker cheatTracker = mapleCharacter4.getCheatTracker();
            cheatTracker.setAttacksWithoutHit(true);
            if (cheatTracker.getAttacksWithoutHit() > 1000) {
                CheatTracker cheatTracker2 = cheatTracker;
                cheatTracker2.registerOffense(CheatingOffense.ATTACK_WITHOUT_GETTING_HIT, Integer.toString(cheatTracker2.getAttacksWithoutHit()));
            }
        }
    }

    public static /* synthetic */ void LieDetectorResponse(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null) {
            return;
        }
        Object object = a2.readMapleAsciiString();
        MapleLieDetector mapleLieDetector = a3.getPlayer().getAntiMacro();
        if (!mapleLieDetector.inProgress() || mapleLieDetector.isPassed() && mapleLieDetector.getLastType() == 0 || mapleLieDetector.getAnswer() == null || ((String)object).length() <= 0) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (((String)object).equalsIgnoreCase(mapleLieDetector.getAnswer())) {
            object = a3.getPlayer().getMap().getCharacterByName(mapleLieDetector.getTester());
            if (object != null && ((MapleCharacter)object).getId() != a3.getPlayer().getId()) {
                ((MapleCharacter)object).dropMessage(1, a3.getPlayer().getName() + " \u901a\u904e\u6e2c\u8b0a\u5668\u7684\u6aa2\u6e2c\u3002");
            }
            mapleLieDetector.end();
            a3.sendPacket(MaplePacketCreator.LieDetectorResponse((byte)9, (byte)0));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.serverNotice(6, "[GM\u5bc6\u8a9e] \u73a9\u5bb6: " + a3.getPlayer().getName() + " (\u7b49\u7d1a " + a3.getPlayer().getLevel() + ") \u901a\u904e\u4e86\u6e2c\u8b0a\u5668\u6aa2\u6e2c\u3002"));
            return;
        }
        if (mapleLieDetector.getAttempt() < 2) {
            MapleLieDetector mapleLieDetector2 = mapleLieDetector;
            mapleLieDetector2.startLieDetector(mapleLieDetector.getTester(), mapleLieDetector2.getLastType() == 0, true);
            return;
        }
        object = a3.getPlayer().getMap().getCharacterByName(mapleLieDetector.getTester());
        if (object != null && ((MapleCharacter)object).getId() != a3.getPlayer().getId()) {
            ((MapleCharacter)object).dropMessage(1, a3.getPlayer().getName() + " \u6c92\u6709\u901a\u904e\u6e2c\u8b0a\u5668\u6aa2\u6e2c\u3002");
        }
        mapleLieDetector.end();
        a3.getPlayer().getClient().getSession().write((Object)MaplePacketCreator.LieDetectorResponse((byte)7, (byte)0));
        MapleClient mapleClient = a3;
        Object object2 = object = mapleClient.getPlayer().getMap().getReturnMap();
        mapleClient.getPlayer().changeMap((MapleMap)object2, ((MapleMap)object2).getPortal(0));
        World.Broadcast.broadcastGMMessage(MaplePacketCreator.serverNotice(6, "[GM\u5bc6\u8a9e] \u89d2\u8272ID: " + a3.getPlayer().getId() + " \u73a9\u5bb6: " + a3.getPlayer().getName() + " (\u7b49\u7d1a " + a3.getPlayer().getLevel() + ") \u672a\u901a\u904e\u6e2c\u8b0a\u5668\u6aa2\u6e2c\uff0c\u7591\u4f3c\u4f7f\u7528\u8173\u672c\u5916\u639b\uff01"));
    }

    public /* synthetic */ PlayersHandler() {
        PlayersHandler a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void RingAction(LittleEndianAccessor a, MapleClient a) {
        switch (a.readByte()) {
            case 0: {
                v0 = a;
                var2_2 = v0.readMapleAsciiString();
                var3_5 = v0.readInt();
                var4_8 = 1112300 + (var3_5 - 2240004);
                v1 = a;
                var5_11 = v1.getChannelServer().getPlayerStorage().getCharacterByName(var2_2);
                var6_13 = 0;
                if (v1.getPlayer().getMarriageId() > 0) {
                    v2 = var6_13 = 23;
                } else {
                    if (a.getPlayer().haveItem(var4_8)) {
                        v3 = a;
                        v3.getPlayer().dropMessage(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u8a9c\u5152\u5c50\u8eb1\u4e5d\u769e\u6245\u631d\u4e48\u68de\u5560\u3018"));
                        v3.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    if (var5_11 == null) {
                        v2 = var6_13 = 18;
                    } else if (var5_11.getMapId() != a.getPlayer().getMapId()) {
                        v2 = var6_13 = 19;
                    } else if (!MapleInventoryManipulator.checkSpace(a, var4_8, 1, "")) {
                        v2 = var6_13 = 20;
                    } else if (!MapleInventoryManipulator.checkSpace(var5_11.getClient(), var4_8, 1, "")) {
                        v2 = var6_13 = 21;
                    } else if (var5_11.getMarriageId() > 0 || var5_11.getMarriageItemId() > 0) {
                        v2 = var6_13 = 24;
                    } else if (!a.getPlayer().haveItem(var3_5, 1) || var3_5 < 2240004 || var3_5 > 2240015) {
                        v2 = var6_13 = 13;
                    } else {
                        if (var5_11.getId() == a.getPlayer().getId()) {
                            v4 = a;
                            v4.getPlayer().dropMessage(1, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u7106\u6ccb\u8df8\u81f4\u5dd6\u7d4e\u5a7d\u301c"));
                            v4.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        v2 = var6_13;
                    }
                }
                if (v2 > 0) {
                    v5 = a;
                    v5.sendPacket(MaplePacketCreator.sendEngagement((byte)var6_13, 0, null, null));
                    v5.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (!GameSetConstants.HOMOSEX && a.getPlayer().getGender() == var5_11.getGender()) {
                    v6 = a;
                    v6.getPlayer().dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u76af\u5416\u6070\u523f\u7176\u6ccf\u7d07\u5a40\u55c3\u3018"));
                    v6.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                a.getPlayer().setMarriageItemId(var3_5);
                if (var5_11 == null) return;
                var5_11.getClient().sendPacket(MaplePacketCreator.sendEngagementRequest(a.getPlayer().getName(), a.getPlayer().getId()));
                return;
            }
            case 1: {
                a.getPlayer().setMarriageItemId(0);
                return;
            }
            case 2: {
                var2_3 = a.readByte() > 0;
                v7 = a;
                var3_6 = v7.readMapleAsciiString();
                var4_9 = v7.readInt();
                v8 = a;
                var5_12 = v8.getChannelServer().getPlayerStorage().getCharacterByName(var3_6);
                if (v8.getPlayer().getMarriageId() > 0 || var5_12 == null || var5_12.getId() != var4_9 || var5_12.getMarriageItemId() <= 0) ** GOTO lbl70
                v9 = var5_12;
                if (v9.haveItem(v9.getMarriageItemId(), 1) && var5_12.getMarriageId() <= 0) ** GOTO lbl74
lbl70:
                // 2 sources

                v10 = a;
                v10.sendPacket(MaplePacketCreator.sendEngagement((byte)29, 0, null, null));
                v10.sendPacket(MaplePacketCreator.enableActions());
                return;
lbl74:
                // 1 sources

                if (var2_3) {
                    var6_14 = 1112300 + (var5_12.getMarriageItemId() - 2240004);
                    if (!MapleInventoryManipulator.checkSpace(a, var6_14, 1, "") || !MapleInventoryManipulator.checkSpace(var5_12.getClient(), var6_14, 1, "")) {
                        v11 = a;
                        v11.sendPacket(MaplePacketCreator.sendEngagement((byte)21, 0, null, null));
                        v11.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    v12 = a;
                    v13 = v12;
                    MapleInventoryManipulator.addById(v12, var6_14, (short)1);
                    MapleInventoryManipulator.removeById(var5_12.getClient(), MapleInventoryType.USE, var5_12.getMarriageItemId(), 1, false, false);
                    MapleInventoryManipulator.addById(var5_12.getClient(), var6_14, (short)1);
                    v14 = a;
                    var5_12.getClient().sendPacket(MaplePacketCreator.sendEngagement((byte)16, var6_14, var5_12, a.getPlayer()));
                    var5_12.setMarriageId(v14.getPlayer().getId());
                    v14.getPlayer().setMarriageId(var5_12.getId());
                } else {
                    var5_12.getClient().sendPacket(MaplePacketCreator.sendEngagement((byte)30, 0, null, null));
                    v13 = a;
                }
                v13.sendPacket(MaplePacketCreator.enableActions());
                var5_12.setMarriageItemId(0);
                return;
            }
            case 3: {
                var2_4 = a.readInt();
                var3_7 = GameConstants.getInventoryType(var2_4);
                var4_10 = a.getPlayer().getInventory(var3_7).findById(var2_4);
                if (var4_10 == null) return;
                if (var3_7 != MapleInventoryType.ETC) return;
                if (var2_4 / 10000 != 421) return;
                MapleInventoryManipulator.drop(a, var3_7, var4_10.getPosition(), var4_10.getQuantity());
                return;
            }
        }
    }

    public static /* synthetic */ void StealSkill(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null || !MapleJob.is\u5e7b\u5f71\u4fe0\u76dc(a3.getPlayer().getJob())) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        if (n3 <= 0) {
            a3.getPlayer().removeStolenSkill(n2);
            return;
        }
        MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(n3);
        if (mapleCharacter == null) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(5, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u5c5a\u65a3\u5da5\u96f8\u95dc\u3018"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (mapleCharacter.getTotalSkillLevel(n2) == 0) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(5, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5c2a\u65a7\u670d\u9ec0\u6b43\u629e\u80da\u301c"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (mapleCharacter.getId() != a3.getPlayer().getId() && mapleCharacter.getTotalSkillLevel(n2) > 0) {
            int n4 = n2;
            a3.getPlayer().addStolenSkill(n4, mapleCharacter.getTotalSkillLevel(n4));
        }
    }

    public static /* synthetic */ void useQuestTip(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LittleEndianAccessor littleEndianAccessor = a2;
        int n3 = littleEndianAccessor.readByte();
        n3 = littleEndianAccessor.readShortAsInt();
        n3 = Math.min(littleEndianAccessor.readInt(), 100);
        int n4 = n2 = 0;
        while (n4 < n3) {
            linkedList.add(a2.readInt());
            n4 = ++n2;
        }
        MapleClient mapleClient = a3;
        mapleClient.sendPacket(MaplePacketCreator.showQuestTip(linkedList));
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        linkedList.clear();
    }

    public static /* synthetic */ void HitReactor(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        short s2 = littleEndianAccessor.readShort();
        MapleReactor mapleReactor = a3.getPlayer().getMap().getReactorByOid(n2);
        if (mapleReactor == null || !mapleReactor.isAlive()) {
            return;
        }
        mapleReactor.hitReactor(n3, s2, a3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void GiveFame(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        byte by = littleEndianAccessor.readByte();
        int n3 = by == 0 ? -1 : 1;
        MapleCharacter mapleCharacter = (MapleCharacter)a4.getMap().getMapObject(n2, MapleMapObjectType.PLAYER);
        if (mapleCharacter == null) return;
        if (mapleCharacter.getId() == a4.getId()) {
            FileoutputUtil.logToFile(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"Kq@m\bVF}L1e\u007fI1\u4fc9\u6527\u5c26\u531b\tj_j"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a4.getName() + "(" + a4.getId() + ") \u4fee\u6539\u540d\u8072\u5c01\u5305\uff0c\u4f7f\u7528\u6642\u5c01\u9396\u3002\u52a0\u81ea\u5df1\u540d\u8072");
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a4.getName() + " \u56e0\u70ba\u4fee\u6539\u5c01\u5305\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]  " + a4.getName() + "(" + a4.getId() + ") \u4fee\u6539\u540d\u8072\u5c01\u5305\uff0c\u4f7f\u7528\u6642\u5c01\u9396\u3002\u52a0\u81ea\u5df1\u540d\u8072"));
            a4.ban(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u4fb9\u6523\u5c56\u531f"), true, true, false);
            a4.getClient().getSession().close();
            return;
        }
        if (a4.getLevel() < 15) {
            FileoutputUtil.logToFile(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"Kq@m\bVF}L1e\u007fI1\u4fc9\u6527\u5c26\u531b\tj_j"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6\uff1a" + a4.getName() + "(" + a4.getId() + ")(\u7b49\u7d1a:" + a4.getLevel() + ") \u4fee\u6539\u540d\u8072\u5c01\u5305\uff0c\u4f7f\u7528\u6642\u5c01\u9396\u3002\u5341\u4e94\u7b49\u4ee5\u4e0b\u52a0\u540d\u8072");
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a4.getName() + " \u56e0\u70ba\u4fee\u6539\u5c01\u5305\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e]  " + a4.getName() + "(" + a4.getId() + ")(\u7b49\u7d1a:" + a4.getLevel() + ") \u4fee\u6539\u540d\u8072\u5c01\u5305\uff0c\u4f7f\u7528\u6642\u5c01\u9396\u3002\u5341\u4e94\u7b49\u4ee5\u4e0b\u52a0\u540d\u8072"));
            a4.ban(HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u4fb9\u6523\u5c56\u531f"), true, true, false);
            a4.getClient().getSession().close();
            return;
        }
        switch (1.ALLATORIxDEMO[a4.canGiveFame(mapleCharacter).ordinal()]) {
            case 1: {
                if (Math.abs(mapleCharacter.getFame() + n3) <= 30000) {
                    mapleCharacter.addFame(n3);
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    mapleCharacter2.updateSingleStat(MapleStat.FAME, mapleCharacter2.getFame());
                }
                if (!a4.isGM()) {
                    a4.hasGivenFame(mapleCharacter);
                }
                a3.sendPacket(MaplePacketCreator.giveFameResponse(by, mapleCharacter.getName(), mapleCharacter.getFame()));
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.receiveFame(by, a4.getName()));
                return;
            }
            case 2: {
                a3.sendPacket(MaplePacketCreator.giveFameErrorResponse(3));
                return;
            }
            case 3: {
                a3.sendPacket(MaplePacketCreator.giveFameErrorResponse(4));
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void EnterPVP(LittleEndianAccessor a2, MapleClient a3) {
        int n2;
        EventInstanceManager eventInstanceManager;
        ArrayList<Integer> arrayList;
        MapleClient mapleClient;
        if (!GameSetConstants.PVP_ENTER) {
            MapleClient mapleClient2 = a3;
            mapleClient2.getPlayer().dropMessage(1, HmacOneTimePasswordGenerator.ALLATORIxDEMO("\u76f4\u521aJ\u0001J\u4e5a\u9591\u6569\u3018"));
            mapleClient2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a3.getPlayer() == null || a3.getPlayer().getMap() == null || a3.getPlayer().getMapId() != 960000000) {
            MapleClient mapleClient3 = a3;
            mapleClient3.sendPacket(MaplePacketCreator.pvpBlocked(1));
            mapleClient3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a3.getPlayer().getParty() != null) {
            MapleClient mapleClient4 = a3;
            mapleClient4.sendPacket(MaplePacketCreator.pvpBlocked(9));
            mapleClient4.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(1);
        byte by = littleEndianAccessor.readByte();
        byte by2 = littleEndianAccessor.readByte();
        boolean bl = false;
        bl = false;
        switch (by2) {
            case 0: {
                bl = a3.getPlayer().getLevel() >= 30 && a3.getPlayer().getLevel() < 70;
                mapleClient = a3;
                break;
            }
            case 1: {
                bl = a3.getPlayer().getLevel() >= 70;
                mapleClient = a3;
                break;
            }
            case 2: {
                bl = a3.getPlayer().getLevel() >= 120;
                mapleClient = a3;
                break;
            }
            case 3: {
                bl = a3.getPlayer().getLevel() >= 180;
            }
            default: {
                mapleClient = a3;
            }
        }
        EventManager eventManager = mapleClient.getChannelServer().getEventSM().getEventManager(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"NqN"));
        if (!bl || eventManager == null) {
            MapleClient mapleClient5 = a3;
            mapleClient5.sendPacket(MaplePacketCreator.pvpBlocked(1));
            mapleClient5.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        switch (by) {
            case 0: {
                ArrayList<Integer> arrayList3 = arrayList2;
                arrayList = arrayList3;
                arrayList3.add(960010100);
                arrayList2.add(960010101);
                arrayList2.add(960010102);
                break;
            }
            case 1: {
                ArrayList<Integer> arrayList4 = arrayList2;
                arrayList = arrayList4;
                arrayList4.add(960020100);
                arrayList2.add(960020101);
                arrayList2.add(960020102);
                arrayList2.add(960020103);
                break;
            }
            case 2: {
                ArrayList<Integer> arrayList5 = arrayList2;
                arrayList = arrayList5;
                arrayList5.add(960030100);
                break;
            }
            case 3: {
                ArrayList<Integer> arrayList6 = arrayList2;
                arrayList = arrayList6;
                arrayList6.add(689000000);
                arrayList2.add(689000010);
                break;
            }
            default: {
                bl = false;
                arrayList = arrayList2;
            }
        }
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            int n3 = (Integer)object.next();
            EventInstanceManager eventInstanceManager2 = eventManager.getInstance("PVP" + n3);
            if (eventInstanceManager2 == null || eventInstanceManager2.getPlayerCount() > 0) continue;
            eventInstanceManager2.disposeIfPlayerBelowCheck((byte)0, 0);
        }
        if (!bl) {
            MapleClient mapleClient6 = a3;
            mapleClient6.sendPacket(MaplePacketCreator.pvpBlocked(1));
            mapleClient6.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient7 = a3;
        MapleClient mapleClient8 = a3;
        mapleClient7.getPlayer().getStat().heal(mapleClient8.getPlayer());
        mapleClient7.getPlayer().cancelAllBuffs();
        mapleClient8.getPlayer().dispelDebuffs();
        mapleClient7.getPlayer().changeRemoval();
        mapleClient7.getPlayer().clearAllCooldowns();
        mapleClient7.getPlayer().unequipAllPets();
        object = new StringBuilder().append(by2).append(" ").append(by).append(" ");
        Iterator iterator = arrayList2.iterator();
        do {
            if (!iterator.hasNext()) {
                ArrayList<Integer> arrayList7 = arrayList2;
                eventManager.startInstance_Solo(((StringBuilder)object).append(arrayList7.get(Randomizer.nextInt(arrayList7.size()))).toString(), a3.getPlayer());
                a3.getPlayer().getStat().heal(a3.getPlayer());
                return;
            }
            n2 = (Integer)iterator.next();
        } while ((eventInstanceManager = eventManager.getInstance((HmacOneTimePasswordGenerator.ALLATORIxDEMO("J\u0001J") + ((StringBuilder)object).toString() + n2).replace(" ", "").replace(" ", ""))) == null || !eventInstanceManager.getProperty(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"mS\u007fUjBz")).equals(HmacOneTimePasswordGenerator.ALLATORIxDEMO("*")) && eventInstanceManager.getPlayerCount() >= 10);
        eventInstanceManager.registerPlayer(a3.getPlayer());
    }
}

