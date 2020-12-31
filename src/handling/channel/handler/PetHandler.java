/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import FuckingHackerToby.K;
import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.SkillFactory;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.PetCommand;
import client.inventory.PetDataFactory;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import constants.GameConstants;
import constants.GameSetConstants;
import handling.channel.handler.MovementParse;
import handling.opcodes.MapleBuffStat;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.maps.FieldLimitType;
import server.movement.LifeMovementFragment;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;
import tools.packet.PetPacket;

public class PetHandler {
    public static final /* synthetic */ void Pet_AutoPotion(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        short s2;
        MapleCharacter mapleCharacter;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleCharacter mapleCharacter2 = a4;
            mapleCharacter = mapleCharacter2;
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(1);
            mapleCharacter2.updateTick(littleEndianAccessor.readInt());
            s2 = a2.readShort();
        } else {
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(13);
            s2 = littleEndianAccessor.readByte();
            mapleCharacter = a4;
        }
        if (mapleCharacter == null || !a4.isAlive() || a4.getMapId() == 749040100 || a4.getMap() == null || a4.hasDisease(MapleBuffStat.POTION)) {
            return;
        }
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(s2);
        if (iItem == null || iItem.getQuantity() < 1) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        long l2 = System.currentTimeMillis();
        if (a4.getNextConsume() > l2) {
            a4.dropMessage(5, MonsterPetSystem.ALLATORIxDEMO("\u7562\u65e4\u51e4\u5323\u6611\u95cb\u5c49\u6772\u7d03\u6707\uff5f\u6218\u4eb6\u7179\u6c86\u4f27\u757b\u6b3c\u9000\u512f\u3051"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!FieldLimitType.PotionUse.check(a4.getMap().getFieldLimit()) || a4.getMapId() == 610030600 || a4.getMapId() == 105100300) {
            if (MapleItemInformationProvider.getInstance().getItemEffect(iItem.getItemId()).applyTo(a4)) {
                if (!GameSetConstants.isNoConsumeItem(iItem.getItemId())) {
                    MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, s2, (short)1, false);
                }
                if (a4.getMap().getConsumeItemCoolTime() > 0) {
                    MapleCharacter mapleCharacter3 = a4;
                    mapleCharacter3.setNextConsume(l2 + (long)(mapleCharacter3.getMap().getConsumeItemCoolTime() * 1000));
                    return;
                }
            }
        } else {
            a3.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public static final /* synthetic */ void PetChat(int a2, short a3, String a4, MapleCharacter a5) {
        if (a5 == null || a5.getMap() == null || a5.getPetIndex(a2) < 0) {
            return;
        }
        if (!a5.getCanTalk()) {
            a5.getClient().sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        byte by = a5.getPetIndex(a2);
        if (by < 0) {
            return;
        }
        if (a5.getPet(by) == null) {
            return;
        }
        MapleCharacter mapleCharacter = a5;
        a5.getMap().broadcastMessage(mapleCharacter, PetPacket.petChat(mapleCharacter.getId(), a3, a4, by), true);
    }

    public static final /* synthetic */ void ChangePetBuff(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        int n2 = a2.readInt();
        MaplePet maplePet = a4.getSummonedPet(n2);
        if (a4 == null || a4.getMap() == null || maplePet == null) {
            return;
        }
        int n3 = a2.readInt();
        Object object = SkillFactory.getSkill(n3);
        if (n3 == 1111002 || n3 == 11111001) {
            a4.dropMessage(1, K.ALLATORIxDEMO("\u8a67\u629a\u80e8\u713b\u6cc0\u6524\u573d\u5bef\u727c\u629a\u80e8\u4e10\u3017"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a4.getSkillLevel((ISkill)object) > 0 || n3 == 0) {
            Iterator<MaplePet> iterator;
            maplePet.setBuffSkill(n3);
            Iterator<MaplePet> iterator2 = iterator = a4.getSummonedPets().iterator();
            while (iterator2.hasNext()) {
                object = iterator.next();
                iterator2 = iterator;
                MapleClient mapleClient = a3;
                Object object2 = object;
                a3.sendPacket(PetPacket.updatePet((MaplePet)object2, a4.getInventory(MapleInventoryType.CASH).getItem((byte)((MaplePet)object).getInventoryPosition()), true));
                mapleClient.sendPacket(PetPacket.showPet(a4, (MaplePet)object2, false, false, false));
                mapleClient.sendPacket(PetPacket.loadExceptionList(a4, maplePet));
            }
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void PetIgnoreTag(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        int n2;
        MapleCharacter mapleCharacter;
        int n3 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            mapleCharacter = a4;
            n3 = a2.readInt();
        } else {
            byte by = ((MapleCharacter)a4).getPetIndex((int)a2.readLong());
            n3 = by;
            if (by == -1) {
                return;
            }
            mapleCharacter = a4;
        }
        a4 = mapleCharacter.getSummonedPet(n3);
        if (a4 == null || !MaplePet.PetFlag.UNPICKABLE.check(((MaplePet)a4).getFlags())) {
            ((MapleClient)((Object)a3)).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        byte by = a2.readByte();
        n3 = by;
        if (by > ((MaplePet)a4).getExcludedArrays().length) {
            ((MapleClient)((Object)a3)).sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3 = ((MaplePet)a4).getExcluded();
        a3 = new ArrayList<Integer>();
        int n4 = n2 = 0;
        while (n4 < n3) {
            a3.add(a2.readInt());
            n4 = ++n2;
        }
        ((MaplePet)a4).setExcluded(a3);
    }

    public /* synthetic */ PetHandler() {
        PetHandler a2;
    }

    public static final /* synthetic */ void MovePet(LittleEndianAccessor a2, MapleCharacter a3) {
        List<LifeMovementFragment> list;
        int n2 = a2.readInt();
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            a2.readByte();
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        Point point = littleEndianAccessor.readPos();
        littleEndianAccessor.skip(4);
        if (GameSetConstants.MAPLE_VERSION == 120) {
            a2.skip(4);
        }
        if ((list = MovementParse.parseMovement(a2, a3.getClient(), 3)) != null && a3 != null && !list.isEmpty() && a3.getMap() != null) {
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                MaplePet maplePet = a3.getPet(n2);
                if (maplePet == null) {
                    return;
                }
                maplePet.updatePosition(list);
                MapleCharacter mapleCharacter = a3;
                a3.getMap().broadcastMessage(mapleCharacter, PetPacket.movePet(mapleCharacter.getId(), n2, point, list), false);
                return;
            }
            byte by = a3.getPetIndex(n2);
            if (by == -1) {
                return;
            }
            MapleCharacter mapleCharacter = a3;
            mapleCharacter.getPet(by).updatePosition(list);
            MapleCharacter mapleCharacter2 = a3;
            mapleCharacter.getMap().broadcastMessage(mapleCharacter2, PetPacket.movePet(mapleCharacter2.getId(), n2, by, list), false);
        }
    }

    public static final /* synthetic */ void SpawnPet(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        LittleEndianAccessor littleEndianAccessor;
        byte by;
        MapleCharacter mapleCharacter = a4;
        mapleCharacter.updateTick(a2.readInt());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            by = a2.readByte();
            littleEndianAccessor = a2;
        } else {
            by = (byte)a2.readShort();
            littleEndianAccessor = a2;
        }
        mapleCharacter.spawnPet(by, littleEndianAccessor.readByte() > 0);
    }

    public static final /* synthetic */ void PetFood(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        MapleClient mapleClient;
        byte by = 100;
        MaplePet maplePet = null;
        if (a4 == null) {
            return;
        }
        for (MaplePet maplePet2 : a4.getSummonedPets()) {
            if (!maplePet2.getSummoned() || maplePet2.getFullness() >= by) continue;
            by = maplePet2.getFullness();
        }
        if (maplePet == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(4);
        int n2 = littleEndianAccessor.readShort();
        int n3 = littleEndianAccessor.readInt();
        IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.USE).getItem((short)n2);
        if (iItem == null || iItem.getItemId() != n3 || iItem.getQuantity() <= 0 || n3 / 10000 != 212) {
            a3.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
            return;
        }
        boolean bl = false;
        if (Randomizer.nextInt(99) <= 50) {
            bl = true;
        }
        if (maplePet.getFullness() < 100) {
            n2 = maplePet.getFullness() + 30;
            if (n2 > 100) {
                n2 = 100;
            }
            maplePet.setFullness(n2);
            byte by2 = a4.getPetIndex(maplePet);
            if (bl && maplePet.getCloseness() < 30000) {
                int n4 = maplePet.getCloseness() + 1;
                if (n4 > 30000) {
                    n4 = 30000;
                }
                maplePet.setCloseness(n4);
                if (n4 >= GameConstants.getClosenessNeededForLevel(maplePet.getLevel() + 1)) {
                    MaplePet maplePet3 = maplePet;
                    maplePet3.setLevel(maplePet3.getLevel() + 1);
                    a3.sendPacket(PetPacket.showOwnPetLevelUp(by2));
                    a4.getMap().broadcastMessage(PetPacket.showPetLevelUp(a4, by2));
                }
            }
            MapleClient mapleClient2 = a3;
            mapleClient = mapleClient2;
            MapleCharacter mapleCharacter = a4;
            mapleClient2.sendPacket(PetPacket.updatePet(maplePet, mapleCharacter.getInventory(MapleInventoryType.CASH).getItem((byte)maplePet.getInventoryPosition()), true));
            mapleCharacter.getMap().broadcastMessage(a3.getPlayer(), PetPacket.commandResponse(a4.getId(), (byte)(true ? 1 : 0), by2, true, true, n3), true);
        } else {
            if (bl) {
                n2 = maplePet.getCloseness() - 1;
                if (n2 < 0) {
                    n2 = 0;
                }
                maplePet.setCloseness(n2);
                if (n2 < GameConstants.getClosenessNeededForLevel(maplePet.getLevel())) {
                    MaplePet maplePet4 = maplePet;
                    maplePet4.setLevel(maplePet4.getLevel() - 1);
                }
            }
            MapleClient mapleClient3 = a3;
            mapleClient = mapleClient3;
            MapleCharacter mapleCharacter = a4;
            mapleClient3.sendPacket(PetPacket.updatePet(maplePet, mapleCharacter.getInventory(MapleInventoryType.CASH).getItem((byte)maplePet.getInventoryPosition()), true));
            MapleCharacter mapleCharacter2 = a4;
            mapleCharacter.getMap().broadcastMessage(mapleCharacter2, PetPacket.commandResponse(a4.getId(), (byte)1, mapleCharacter2.getPetIndex(maplePet), false, true, n3), true);
        }
        MapleInventoryManipulator.removeById(mapleClient, MapleInventoryType.USE, n3, true ? 1 : 0, true, false);
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
        int cfr_ignored_0 = 2 ^ 5;
        int n5 = n3;
        char c2 = '\u0001';
        while (n5 >= 0) {
            int n6 = n3--;
            arrc[n6] = (char)(a2.charAt(n6) ^ c2);
            if (n3 < 0) break;
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public static final /* synthetic */ void PetCommand(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        byte by = a4.getPetIndex(a2.readInt());
        if (by == -1) {
            return;
        }
        MaplePet maplePet = a4.getPet(by);
        if (maplePet == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(5);
        byte by2 = littleEndianAccessor.readByte();
        PetCommand petCommand = PetDataFactory.getPetCommand(maplePet.getPetItemId(), by2);
        boolean bl = false;
        if (Randomizer.nextInt(99) <= petCommand.getProbability()) {
            bl = true;
            if (maplePet.getCloseness() < 30000) {
                int n2 = maplePet.getCloseness() + petCommand.getIncrease();
                if (n2 > 30000) {
                    n2 = 30000;
                }
                maplePet.setCloseness(n2);
                if (n2 >= GameConstants.getClosenessNeededForLevel(maplePet.getLevel() + 1)) {
                    MaplePet maplePet2 = maplePet;
                    maplePet2.setLevel(maplePet2.getLevel() + 1);
                    a3.sendPacket(PetPacket.showOwnPetLevelUp(by));
                    a4.getMap().broadcastMessage(PetPacket.showPetLevelUp(a4, by));
                }
                MaplePet maplePet3 = maplePet;
                a3.sendPacket(PetPacket.updatePet(maplePet3, a4.getInventory(MapleInventoryType.CASH).getItem((byte)maplePet3.getInventoryPosition()), true));
            }
        }
        MapleCharacter mapleCharacter = a4;
        a4.getMap().broadcastMessage(mapleCharacter, PetPacket.commandResponse(mapleCharacter.getId(), by2, by, bl, 0 != 0, 0), true);
    }
}

