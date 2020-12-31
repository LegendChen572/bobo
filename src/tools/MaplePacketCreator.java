/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.BuddyEntry;
import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleDisease;
import client.MapleJob;
import client.MapleKeyLayout;
import client.MapleQuestStatus;
import client.MapleStat;
import client.MapleTrait;
import client.MonsterFamiliar;
import client.SkillEntry;
import client.SkillFactory;
import client.SkillMacro;
import client.SpecialBuffInfo;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleAndroid;
import client.inventory.MapleImp;
import client.inventory.MapleInventoryType;
import client.inventory.MapleMount;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import client.inventory.ModifyInventory;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.ServerConstants;
import constants.SkillConstants;
import handling.SendPacketOpcode;
import handling.channel.MapleRanking;
import handling.channel.handler.AttackInfo;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.PartyOperation;
import handling.opcodes.PlayerInteraction;
import handling.opcodes.SmegaType;
import handling.opcodes.SpecialEffect;
import handling.opcodes.StatusInfoType;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.exped.MapleExpedition;
import handling.world.guild.MapleBBSThread;
import handling.world.guild.MapleGuild;
import handling.world.guild.MapleGuildAlliance;
import handling.world.guild.MapleGuildCharacter;
import handling.world.guild.MapleGuildSkill;
import handling.world.sidekick.MapleSidekick;
import handling.world.sidekick.MapleSidekickCharacter;
import java.awt.Point;
import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import scripting.AbstractPlayerInteraction;
import server.MapleDueyActions;
import server.MapleItemInformationProvider;
import server.MapleShop;
import server.MapleShopItem;
import server.MapleStatEffect;
import server.MapleStorageType;
import server.MapleTrade;
import server.Randomizer;
import server.events.MapleSnowball;
import server.life.MapleMonster;
import server.life.MapleNPC;
import server.life.PlayerNPC;
import server.life.SummonAttackEntry;
import server.maps.MapleDragon;
import server.maps.MapleMap;
import server.maps.MapleMapItem;
import server.maps.MapleMist;
import server.maps.MapleNodes;
import server.maps.MapleReactor;
import server.maps.MapleSummon;
import server.maps.MechDoor;
import server.movement.LifeMovementFragment;
import server.quest.MapleQuest;
import server.shops.HiredMerchant;
import server.shops.MaplePlayerShopItem;
import server.shops.MapleShopResponse;
import tools.AttackPair;
import tools.HexTool;
import tools.KoreanDateUtil;
import tools.MaplePacketOperation;
import tools.Pair;
import tools.StringUtil;
import tools.Triple;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;
import tools.packet.PetPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class MaplePacketCreator {
    public static final /* synthetic */ List<Pair<MapleStat, Integer>> EMPTY_STATUPDATE;

    public static final /* synthetic */ byte[] showChampionEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(32);
        maplePacketLittleEndianWriter2.writeInt(30000);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] broadcastMessage(int a2, String a3) {
        if (a2 < 0 || a2 > 6 || a2 == 3) {
            a2 = 6;
        }
        String[] arrstring = new String[1];
        arrstring[0] = a3;
        return MaplePacketCreator.ALLATORIxDEMO(a2, 0, arrstring, false, null, "");
    }

    public static /* synthetic */ byte[] showChaosHorntailShrine(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CHAOS_HORNTAIL_SHRINE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] getNPCTalkNum(int a2, String a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.NPCPacket.TalkNum1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.NPCPacket.TalkNum2);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter.write(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter4.writeInt(a4);
        maplePacketLittleEndianWriter4.writeInt(a5);
        maplePacketLittleEndianWriter3.writeInt(a6);
        maplePacketLittleEndianWriter3.writeInt(0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getFollowMsg(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FOLLOW_MSG.getValue());
        maplePacketLittleEndianWriter2.writeLong(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateGP(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(79);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] keyDownAreaMoving(MapleCharacter a2, byte[] a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.KEYDOWN_AREA_MOVE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        maplePacketLittleEndianWriter2.write(a3.length);
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            maplePacketLittleEndianWriter.write(a3[n2++]);
            n4 = n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] spawnNPCRequestController(MapleNPC a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleNPC mapleNPC = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SPAWN_NPC_REQUEST_CONTROLLER.getValue());
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter.writeShort(mapleNPC.getPosition().x);
        maplePacketLittleEndianWriter2.writeShort(mapleNPC.getCy());
        maplePacketLittleEndianWriter2.write(a2.getF() == 1 ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MapleNPC mapleNPC2 = a2;
        maplePacketLittleEndianWriter.writeShort(a2.getFh());
        maplePacketLittleEndianWriter.writeShort(mapleNPC2.getRx0());
        maplePacketLittleEndianWriter5.writeShort(mapleNPC2.getRx1());
        maplePacketLittleEndianWriter5.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateBuddylist(Collection<BuddyEntry> a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Collection<BuddyEntry> collection = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BUDDYLIST.getValue());
        maplePacketLittleEndianWriter2.write(7);
        maplePacketLittleEndianWriter.write(collection.size());
        for (BuddyEntry buddyEntry : collection) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(buddyEntry.getCharacterId());
            maplePacketLittleEndianWriter3.writeAsciiString(buddyEntry.getName(), GameSetConstants.WRITE_STRING_LENGTH);
            maplePacketLittleEndianWriter3.write(GameSetConstants.MAPLE_VERSION >= 134 ? (buddyEntry.isVisible() ? 0 : 1) : 0);
            maplePacketLittleEndianWriter.writeInt(buddyEntry.getChannel() == -1 || !buddyEntry.isVisible() ? -1 : buddyEntry.getChannel() - 1);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                try {
                    maplePacketLittleEndianWriter.writeAsciiString(buddyEntry.getGroup(), 17);
                }
                catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                    maplePacketLittleEndianWriter.writeAsciiString("", 17);
                }
            }
            if (GameSetConstants.MAPLE_VERSION < 147) continue;
            maplePacketLittleEndianWriter.writeAsciiString(buddyEntry.getGroup(), 16);
        }
        int n3 = n2 = 0;
        while (n3 < a2.size()) {
            maplePacketLittleEndianWriter.writeInt(0);
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] explodeDrop(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.REMOVE_ITEM_FROM_MAP.getValue());
        maplePacketLittleEndianWriter3.write(4);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeShort(655);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] craftMake(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CRAFT_EFFECT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getChannelChange(String a2, int a3) {
        byte[] arrby;
        byte[] arrby2 = new byte[4];
        arrby2[0] = 127;
        arrby2[1] = 0;
        arrby2[2] = 0;
        arrby2[3] = 1;
        byte[] arrby3 = arrby2;
        try {
            arrby = arrby3 = InetAddress.getByName(a2).getAddress();
        }
        catch (UnknownHostException unknownHostException) {
            arrby = arrby3;
        }
        return MaplePacketCreator.getChannelChange(arrby, a3);
    }

    public static /* synthetic */ byte[] getWhisperReply(String a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.WHISPER.getValue());
        maplePacketLittleEndianWriter3.write(10);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showTitle(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_TITLE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnMist(MapleMist a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        MapleMist mapleMist = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPAWN_MIST.getValue());
        maplePacketLittleEndianWriter2.writeInt(mapleMist.getObjectId());
        int n2 = mapleMist.getMistType();
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(n2);
        } else {
            maplePacketLittleEndianWriter2.write(a2.isMobMist() ? 1 : 0);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.writeInt(a2.getOwnerId());
        MapleMist mapleMist2 = a2;
        maplePacketLittleEndianWriter2.writeInt(a2.getMobSkill() == null ? mapleMist2.getSourceSkill().getId() : mapleMist2.getMobSkill().getSkillId());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        MapleMist mapleMist3 = a2;
        maplePacketLittleEndianWriter2.write(mapleMist3.getSkillLevel());
        maplePacketLittleEndianWriter4.writeShort(mapleMist3.getSkillDelay());
        maplePacketLittleEndianWriter4.writeRect(a2.getBox());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writePos(a2.getPosition());
        }
        if (GameSetConstants.MAPLE_VERSION == 75) {
            maplePacketLittleEndianWriter2.write(n2 != 0 ? 0 : 1);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter6.writeInt(0);
        maplePacketLittleEndianWriter6.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignPirate(Map<MapleBuffStat, Integer> a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        boolean bl = a5 == 5121009 || a5 == 15111005 || a5 % 10000 == 8006;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter3.writeInt(a4);
        PacketHelper.writeBuffMask(maplePacketLittleEndianWriter3, a2);
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.write(0);
        Iterator<Integer> iterator = a4 = a2.values().iterator();
        while (iterator.hasNext()) {
            Integer n2 = a4.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeInt(n2);
            maplePacketLittleEndianWriter4.writeLong(a5);
            maplePacketLittleEndianWriter4.writeZeroBytes(bl ? 6 : 1);
            iterator = a4;
            maplePacketLittleEndianWriter.writeShort(a3);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter5.write(1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getWarpToMap(MapleMap a2, int a3, MapleCharacter a4) {
        return MaplePacketCreator.getCharInfo(a4, false, a2, a3);
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, List<MapleRing> a3, MapleCharacter a4) {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            List<MapleRing> list = a3;
            a2.write(list.size());
            Object object = a3 = list.iterator();
            while (object.hasNext()) {
                MapleRing mapleRing = (MapleRing)a3.next();
                object = a3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                a2.writeInt(a4.getId());
                maplePacketLittleEndianWriter.writeInt(mapleRing.getPartnerChrId());
                maplePacketLittleEndianWriter.writeInt(mapleRing.getItemId());
            }
        } else {
            a2.write(a4.getMarriageRing(false) != null ? (byte)1 : 0);
            if (a4.getMarriageRing(false) != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                MapleCharacter mapleCharacter = a4;
                a2.writeInt(mapleCharacter.getId());
                maplePacketLittleEndianWriter.writeInt(mapleCharacter.getMarriageRing(false).getPartnerChrId());
                maplePacketLittleEndianWriter.writeInt(a4.getMarriageRing(false).getRingId());
            }
        }
    }

    public static /* synthetic */ byte[] updatePartyMemberHP(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_PARTYMEMBER_HP.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] denyGuildInvitation(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.GuildStatus.\u62d2\u7d55\u516c\u6703\u9080\u8acb);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] sendGhostStatus(String a2, String a3) {
        return MaplePacketCreator.sendString(3, a2, a3);
    }

    public static /* synthetic */ byte[] craftFinished(int a2, int a3, int a4, int a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CRAFT_COMPLETE.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        maplePacketLittleEndianWriter2.writeInt(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] modifyInventory(boolean a2, List<ModifyInventory> a3, MapleCharacter a4) {
        return MaplePacketCreator.modifyInventory(a2, a3, a4, false);
    }

    public static /* synthetic */ byte[] getNPCTalkStyle(int a2, String a3, int ... a4) {
        return MaplePacketCreator.getNPCTalkStyle(a2, a3, false, a4);
    }

    public static /* synthetic */ byte[] sendLevelup(boolean a2, int a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LEVEL_UPDATE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a4);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] summonMessage(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SUMMON_HINT_MSG.getValue());
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeInt(200);
        maplePacketLittleEndianWriter2.writeInt(10000);
        maplePacketLittleEndianWriter2.writeShort(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showQuestMsg(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.QUEST_MSG.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignEnergyCharge(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        ArrayList<MapleBuffStat> arrayList = new ArrayList<MapleBuffStat>();
        arrayList.add(MapleBuffStat.ENERGY_CHARGE);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketCreator.H(maplePacketLittleEndianWriter, arrayList);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        int n2 = a4;
        maplePacketLittleEndianWriter6.writeInt(Math.min(n2, 10000));
        maplePacketLittleEndianWriter6.writeInt(n2 >= 10000 ? a3 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter7.writeInt(0);
        maplePacketLittleEndianWriter7.writeShort(a4 >= 10000 ? a5 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter8.writeZeroBytes(10);
        return maplePacketLittleEndianWriter8.getPacket();
    }

    public static final /* synthetic */ byte[] showQuestEffect(MapleQuestStatus a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.writeShort(a2.getQuest().getId());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter.writeMapleAsciiString(a2.getCustomData());
        maplePacketLittleEndianWriter2.writeLong(System.currentTimeMillis());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] pamSongUI() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PAMS_SONG_UI.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getItemNotice(String a2, int a3) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.BLUE_MESSAGE.getValue(), a3, arrstring, true, null, "");
    }

    public static /* synthetic */ byte[] finishedGather(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FINISH_GATHER.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] teachMessage(int a2, int a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LINK_SKILLS.getValue());
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] updateParty(int a2, MapleParty a3, PartyOperation a4, MaplePartyCharacter a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        switch (a4) {
            case DISBAND: 
            case EXPEL: 
            case LEAVE: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.write(MaplePacketOperation.PartyStatus.\u968a\u9577\u89e3\u9664\u7d44\u968a\u9000\u51fa\u968a\u4f0d);
                maplePacketLittleEndianWriter3.writeInt(a3.getId());
                maplePacketLittleEndianWriter3.writeInt(a5.getId());
                maplePacketLittleEndianWriter2.write(a4 == PartyOperation.DISBAND ? 0 : 1);
                if (a4 == PartyOperation.DISBAND) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.writeInt(a5.getId());
                    return maplePacketLittleEndianWriter.getPacket();
                }
                maplePacketLittleEndianWriter2.write(a4 == PartyOperation.EXPEL ? 1 : 0);
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a5.getName());
                MaplePacketCreator.ALLATORIxDEMO(a2, a3, maplePacketLittleEndianWriter2, a4 == PartyOperation.LEAVE, false);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                return maplePacketLittleEndianWriter.getPacket();
            }
            case JOIN: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter5.write(MaplePacketOperation.PartyStatus.\u52a0\u5165\u7d44\u968a);
                maplePacketLittleEndianWriter5.writeInt(a3.getId());
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a5.getName());
                MaplePacketCreator.ALLATORIxDEMO(a2, a3, maplePacketLittleEndianWriter2, a4 == PartyOperation.LEAVE, false);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                return maplePacketLittleEndianWriter.getPacket();
            }
            case SILENT_UPDATE: 
            case LOG_ONOFF: {
                maplePacketLittleEndianWriter2.write(MaplePacketOperation.PartyStatus.\u5237\u65b0\u72c0\u614b);
                maplePacketLittleEndianWriter2.writeInt(a3.getId());
                MaplePacketCreator.ALLATORIxDEMO(a2, a3, maplePacketLittleEndianWriter2, a4 == PartyOperation.LOG_ONOFF, false);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                return maplePacketLittleEndianWriter.getPacket();
            }
            case CHANGE_LEADER: 
            case CHANGE_LEADER_DC: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.write(MaplePacketOperation.PartyStatus.\u66f4\u63db\u968a\u9577);
                maplePacketLittleEndianWriter6.writeInt(a5.getId());
                maplePacketLittleEndianWriter2.write(a4 == PartyOperation.CHANGE_LEADER_DC ? 1 : 0);
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] changeAllianceRank(int a2, MapleGuildCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(5);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3.getId());
        maplePacketLittleEndianWriter2.writeInt(a3.getAllianceRank());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveFameErrorResponse(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FAME_RESPONSE.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removeItemFromDuey(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.DUEY.getValue());
        maplePacketLittleEndianWriter3.write(24);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a2 ? 3 : 4);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] dropItemFromMapObject(MapleMapItem a2, Point a3, Point a4, byte a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.DROP_ITEM_FROM_MAPOBJECT.getValue());
        maplePacketLittleEndianWriter3.write(a5);
        maplePacketLittleEndianWriter2.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter2.write(a2.getMeso() > 0 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MapleMapItem mapleMapItem = a2;
        maplePacketLittleEndianWriter.writeInt(mapleMapItem.getItemId());
        maplePacketLittleEndianWriter5.writeInt(mapleMapItem.getOwner());
        maplePacketLittleEndianWriter5.write(a2.getDropType());
        maplePacketLittleEndianWriter4.writePos(a4);
        maplePacketLittleEndianWriter4.writeInt(a2.getDropType() == 0 ? a2.getOwner() : 0);
        if (a5 != 2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter6.writePos(a3);
            maplePacketLittleEndianWriter6.writeShort(0);
        }
        if (a2.getMeso() == 0) {
            PacketHelper.addExpirationTime(maplePacketLittleEndianWriter, a2.getItem().getExpiration());
        }
        maplePacketLittleEndianWriter.write(a2.isPlayerDrop() ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter7.write(false);
        maplePacketLittleEndianWriter7.writeShort(0);
        return maplePacketLittleEndianWriter7.getPacket();
    }

    public static /* synthetic */ byte[] showEventInstructions() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GMEVENT_INSTRUCTIONS.getValue());
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] destroyKite(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DESTROY_KITE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateMount(MapleCharacter a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleCharacter mapleCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_MOUNT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.writeInt(a2.getMount().getLevel());
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getMount().getExp());
        maplePacketLittleEndianWriter2.writeInt(mapleCharacter.getMount().getFatigue());
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showWeirdEffect(int a2, String a32, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (a2 == -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
            maplePacketLittleEndianWriter4.writeInt(a2);
        }
        maplePacketLittleEndianWriter.write(SpecialEffect.CHANGE_ELF.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a32);
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            maplePacketLittleEndianWriter2.write(1);
        }
        maplePacketLittleEndianWriter2.writeInt(a5);
        int a32 = 2;
        maplePacketLittleEndianWriter2.writeInt(2);
        if (a32 == 2) {
            maplePacketLittleEndianWriter2.writeInt(a4);
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showDragonGlide(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_DRAGON_GLIDE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(n2);
        if (n2 == 0) {
            maplePacketLittleEndianWriter.writeInt(a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] useViciousHammer2(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.VICIOUS_HAMMER_USE.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        if (a2 == 0) {
            maplePacketLittleEndianWriter.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] removeNPC(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.REMOVE_NPC.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] guildCapacityChange(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u5bb9\u7d0d\u4eba\u6578\u66f4\u6539);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removeMist(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REMOVE_MIST.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getFindReplyWithMTS(String a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.WHISPER.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 72 : 9);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.writeInt(-1);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] sendPyramidEnergy(String a2, String a3) {
        return MaplePacketCreator.sendString(1, a2, a3);
    }

    public static /* synthetic */ byte[] OnSetClaimSvrAvailableTime(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(4);
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REPORT_TIME.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnSummon(MapleSummon a2, boolean a32) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        MapleSummon mapleSummon = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPAWN_SUMMON.getValue());
        maplePacketLittleEndianWriter2.writeInt(mapleSummon.getOwnerId());
        maplePacketLittleEndianWriter3.writeInt(mapleSummon.getObjectId());
        maplePacketLittleEndianWriter3.writeInt(a2.getSkill());
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter2.write(a2.getOwnerLevel() - 1);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        MapleSummon mapleSummon2 = a2;
        maplePacketLittleEndianWriter4.write(mapleSummon2.getSkillLevel());
        maplePacketLittleEndianWriter4.writePos(mapleSummon2.getPosition());
        if (a2.isPuppet()) {
            maplePacketLittleEndianWriter2.write(a2.isFacingLeft() ? 4 : 5);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            maplePacketLittleEndianWriter2.write(a2.isFacingLeft() ? 5 : 4);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.writeShort(a2.getFh());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.write(a2.getMovementType().getValue());
        maplePacketLittleEndianWriter5.write(a2.getSummonType());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a32 = !a32;
        }
        maplePacketLittleEndianWriter2.write(a32 ? 0 : 1);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter2.write(1);
        }
        MapleCharacter a32 = a2.getOwner();
        maplePacketLittleEndianWriter2.write(a2.getSkill() == 4341006 && a32 != null ? 1 : 0);
        if (a2.getSkill() == 4341006 && a32 != null) {
            PacketHelper.addCharLook(maplePacketLittleEndianWriter2, a32, true);
        }
        if (a2.getSkill() == 35111002) {
            maplePacketLittleEndianWriter2.write(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter6.writeZeroBytes(20);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] getAllianceInfo(MapleGuildAlliance a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(12);
        maplePacketLittleEndianWriter2.write(a2 == null ? 0 : 1);
        if (a2 != null) {
            MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter, a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateBuddyCapacity(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.BUDDYLIST.getValue());
        maplePacketLittleEndianWriter2.write(21);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getShowItemGain(int a2, short a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (a4) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
            maplePacketLittleEndianWriter3.write(GameSetConstants.MAPLE_VERSION >= 134 ? 5 : 3);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter4.writeInt(a2);
            maplePacketLittleEndianWriter4.writeInt(a3);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter6.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
            maplePacketLittleEndianWriter6.writeShort(StatusInfoType.SHOW_INVENTORY_GAIN.getValue());
            maplePacketLittleEndianWriter5.writeInt(a2);
            maplePacketLittleEndianWriter5.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] createUltimate(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CREATE_ULTIMATE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showPQRewardResult(byte a2, int a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.PartyStatus.PQ\u734e\u52f5\u7d50\u679c);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a4);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] Mulung_DojoUp2() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        byte by = 0;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            by = 10;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION == 113) {
            by = 7;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            by = 8;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.write(by);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showEffectWin() {
        return MaplePacketCreator.environmentChange(AbstractPlayerInteraction.ALLATORIxDEMO("r#l;d$c9`\"h8fyv?o"), 3);
    }

    public static /* synthetic */ byte[] showRewardItemAnimation(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter3.write(SpecialEffect.LOTTERY_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3 != null && a3.length() > 0 ? 1 : 0);
        if (a3 != null && a3.length() > 0) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] finishedSort(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FINISH_SORT.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] newGuildMember(MapleGuildCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleGuildCharacter mapleGuildCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleGuildCharacter mapleGuildCharacter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(MaplePacketOperation.GuildStatus.\u65b0\u516c\u6703\u6210\u54e1);
        maplePacketLittleEndianWriter4.writeInt(a2.getGuildId());
        maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter2.getId());
        maplePacketLittleEndianWriter3.writeAsciiString(mapleGuildCharacter2.getName(), GameSetConstants.WRITE_STRING_LENGTH);
        maplePacketLittleEndianWriter3.writeInt(a2.getJobId());
        maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter.getLevel());
        maplePacketLittleEndianWriter2.writeInt(mapleGuildCharacter.getGuildRank());
        maplePacketLittleEndianWriter2.writeInt(a2.isOnline() ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeInt(1);
        maplePacketLittleEndianWriter5.writeInt(a2.getAllianceRank());
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] showHorntailShrine(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.HORNTAIL_SHRINE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPHPBar(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PVP_HP.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateAllianceRank(int a2, MapleGuildCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(27);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3.getId());
        maplePacketLittleEndianWriter2.writeInt(a3.getAllianceRank());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveHoming(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        ArrayList<MapleBuffStat> arrayList = new ArrayList<MapleBuffStat>();
        arrayList.add(MapleBuffStat.HOMING_BEACON);
        MaplePacketCreator.H(maplePacketLittleEndianWriter2, arrayList);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter3.writeShort(0);
            maplePacketLittleEndianWriter3.write(0);
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                maplePacketLittleEndianWriter2.writeShort(0);
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeInt(1);
            maplePacketLittleEndianWriter6.writeLong(a2);
            maplePacketLittleEndianWriter6.write(0);
            maplePacketLittleEndianWriter5.writeLong(a3);
            maplePacketLittleEndianWriter5.writeShort(0);
            maplePacketLittleEndianWriter4.writeShort(0);
            maplePacketLittleEndianWriter4.write(0);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter9.writeShort(0);
            maplePacketLittleEndianWriter9.writeInt(1);
            maplePacketLittleEndianWriter8.writeLong(a2);
            maplePacketLittleEndianWriter8.write(0);
            maplePacketLittleEndianWriter7.writeInt(a3);
            maplePacketLittleEndianWriter7.writeShort(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] itemMegaphone(String a2, IItem a3, int a4, String a5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a5);
        stringBuilder.append(AbstractPlayerInteraction.ALLATORIxDEMO("!l!"));
        stringBuilder.append(a2);
        String[] arrstring = new String[1];
        arrstring[0] = stringBuilder.toString();
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.ITEM_MESSAGE.getValue(), a4, arrstring, true, a3, "");
    }

    public static /* synthetic */ byte[] getFindReply(String a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.WHISPER.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 72 : 9);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.write(3);
        maplePacketLittleEndianWriter3.writeInt(a3 - 1);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] removeFamiliar(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SPAWN_FAMILIAR.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removeSummon(MapleSummon a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.REMOVE_SUMMON.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getOwnerId());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        if (a3) {
            switch (a2.getSkill()) {
                case 35121003: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.write(10);
                    break;
                }
                case 33101008: 
                case 35111001: 
                case 35111002: 
                case 35111005: 
                case 35111009: 
                case 35111010: 
                case 35111011: 
                case 35121009: 
                case 35121010: 
                case 35121011: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                    while (false) {
                    }
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                    maplePacketLittleEndianWriter5.write(5);
                    break;
                }
                default: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
                    maplePacketLittleEndianWriter6.write(4);
                    break;
                }
            }
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter7;
            maplePacketLittleEndianWriter7.write(1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] DressUpTime(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.writeShort(7707);
        maplePacketLittleEndianWriter.write(2);
        maplePacketLittleEndianWriter2.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        return maplePacketLittleEndianWriter.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ byte[] spawnPlayerMapobject(MapleCharacter a) {
        block30: {
            block33: {
                block32: {
                    block31: {
                        v0 = var1_1 = new MaplePacketLittleEndianWriter();
                        v0.writeShort(SendPacketOpcode.SPAWN_PLAYER.getValue());
                        v0.writeInt(a.getId());
                        if (GameSetConstants.MAPLE_VERSION >= 113) {
                            var1_1.write(a.getLevel());
                        }
                        var1_1.writeMapleAsciiString(a.getName());
                        if (GameSetConstants.MAPLE_VERSION < 134) ** GOTO lbl14
                        var2_2 = a.getQuestNoAdd(MapleQuest.getInstance(111111));
                        if (var2_2 != null && var2_2.getCustomData() != null) {
                            v1 = a;
                            var1_1.writeMapleAsciiString(var2_2.getCustomData());
                        } else {
                            var1_1.writeMapleAsciiString("");
lbl14:
                            // 2 sources

                            v1 = a;
                        }
                        var2_2 = v1.getNick();
                        if (a.getGuildId() <= 0) {
                            v2 = var1_1;
                            v3 = v2;
                            v2.writeMapleAsciiString((String)var2_2);
                            v2.writeZeroBytes(6);
                        } else {
                            var3_3 = World.Guild.getGuild(a.getGuildId());
                            v4 = var1_1;
                            if (var3_3 != null) {
                                v4.writeMapleAsciiString(var3_3.getName() + (String)var2_2);
                                v5 = var1_1;
                                v3 = v5;
                                v6 = var3_3;
                                var1_1.writeShort(var3_3.getLogoBG());
                                var1_1.write(v6.getLogoBGColor());
                                v5.writeShort(v6.getLogo());
                                v5.write(var3_3.getLogoColor());
                            } else {
                                v4.writeMapleAsciiString((String)var2_2);
                                v7 = var1_1;
                                v3 = v7;
                                v7.writeZeroBytes(6);
                            }
                        }
                        PacketHelper.addSpawnPlayerBuffStatus(v3, a);
                        var1_1.writeShort(a.getJob());
                        if (GameSetConstants.MAPLE_VERSION >= 143) {
                            var1_1.writeShort(a.getSubcategory());
                        }
                        PacketHelper.addCharLook(var1_1, a, false);
                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                            v8 = var1_1;
                            v9 = var1_1;
                            var1_1.writeInt(0);
                            v9.writeInt(0);
                            var3_4 = 0;
                            v8.writeInt(0);
                            v9.writeInt(var3_4);
                            v8.writeInt(var3_4);
                        }
                        v10 = var1_1;
                        v11 = a;
                        v10.writeInt(Math.min(250, v11.getInventory(MapleInventoryType.CASH).countById(5110000)));
                        v10.writeInt(v11.getItemEffect());
                        if (GameSetConstants.MAPLE_VERSION >= 142) {
                            v12 = var1_1;
                            var1_1.writeInt(0);
                            v12.writeInt(0);
                            v12.writeInt(0);
                        }
                        if (GameSetConstants.MAPLE_VERSION >= 151) {
                            v13 = var1_1;
                            v13.writeInt(0);
                            v13.writeInt(0);
                        }
                        if (GameSetConstants.MAPLE_VERSION >= 113) {
                            var1_1.writeInt(0);
                        }
                        if (GameSetConstants.MAPLE_VERSION <= 113 || GameSetConstants.MAPLE_VERSION == 118 || GameSetConstants.MAPLE_VERSION == 119) break block31;
                        v14 = var1_1;
                        v15 = var1_1;
                        v15.writeMapleAsciiString("");
                        v15.writeMapleAsciiString("");
                        v14.writeShort(-1);
                        v14.writeShort(-1);
                        if (GameSetConstants.MAPLE_VERSION < 139) break block32;
                        v16 = var1_1;
                        v17 = v16;
                        v16.write(0);
                        break block33;
                    }
                    if (GameSetConstants.MAPLE_VERSION != 75) {
                        v18 = var1_1;
                        v18.writeInt(0);
                        v18.writeInt(-1);
                    }
                }
                v17 = var1_1;
            }
            v17.writeInt(GameConstants.getInventoryType(a.getChair()) == MapleInventoryType.SETUP ? a.getChair() : 0);
            if (GameSetConstants.MAPLE_VERSION >= 143) {
                var1_1.writeInt(0);
            }
            v19 = var1_1;
            v20 = a;
            var1_1.writePos(a.getTruePosition());
            v19.write(v20.getStance());
            v19.writeShort(v20.getFh());
            if (GameSetConstants.MAPLE_VERSION < 113) {
                v21 = var1_1;
                v22 = v21;
                v21.write(0);
            } else {
                v23 = var3_5 = 0;
                while (v23 <= 3) {
                    var2_2 = a.getSummonedPet(var3_5);
                    var1_1.write(var2_2 != null);
                    if (var2_2 == null) {
                        v22 = var1_1;
                        break block30;
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        var1_1.writeInt(var3_5);
                    }
                    PetPacket.addPetInfo(var1_1, a, (MaplePet)var2_2, false);
                    v23 = ++var3_5;
                }
                v22 = var1_1;
            }
        }
        v22.writeInt(a.getMount().getLevel());
        v24 = var1_1;
        v25 = a;
        var1_1.writeInt(a.getMount().getExp());
        var1_1.writeInt(v25.getMount().getFatigue());
        PacketHelper.addAnnounceBox(v24, v25);
        v24.write(a.getChalkboard() != null && a.getChalkboard().length() > 0 ? 1 : 0);
        if (a.getChalkboard() != null && a.getChalkboard().length() > 0) {
            var1_1.writeMapleAsciiString(a.getChalkboard());
        }
        var3_3 = a.getRingsTriple(false);
        MaplePacketCreator.addRingInfo(var1_1, (List)var3_3.getLeft());
        MaplePacketCreator.addRingInfo(var1_1, (List)var3_3.getMid());
        MaplePacketCreator.ALLATORIxDEMO(var1_1, (List)var3_3.getRight(), a);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            v26 = var1_1;
            v26.write(0);
            v26.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            v27 = var1_1;
            v27.write(0);
            v27.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            var1_1.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            var1_1.writeInt(a.getMount() == null ? 0 : a.getMount().getItemId());
            if (JobConstants.is\u51f1\u6492(a.getJob())) {
                var2_2 = a.getOneInfo(12860, MapleParty.ALLATORIxDEMO("\u0015a\u0004|\u0002w"));
                var1_1.writeInt(var2_2 == null ? 0 : Integer.parseInt((String)var2_2));
                var2_2 = a.getOneInfo(12860, AbstractPlayerInteraction.ALLATORIxDEMO("h8o3s"));
                var1_1.writeInt(var2_2 == null ? 0 : Integer.parseInt((String)var2_2));
                var2_2 = a.getOneInfo(12860, MapleParty.ALLATORIxDEMO("i\u0002|\u001dp\u0005t"));
                var1_1.write(var2_2 == null ? 0 : Integer.parseInt((String)var2_2));
            }
            var1_1.writeInt(0);
        }
        if (a.getCarnivalParty() != null) {
            v28 = var1_1;
            v29 = v28;
            v28.write(a.getCarnivalParty().getTeam());
        } else if (a.inPVP()) {
            v30 = var1_1;
            v30.write(Integer.parseInt(a.getEventInstance().getProperty(AbstractPlayerInteraction.ALLATORIxDEMO("\"x&d"))));
            v30.write(a.getTeam() + (a.inPVP() != false ? 1 : 0));
            v29 = var1_1;
        } else {
            if (MapConstants.isTeamMap(a.getMapId())) {
                var1_1.write(a.getCoconutTeam());
            }
            v29 = var1_1;
        }
        v29.writeInt(0);
        v31 = var1_1;
        var1_1.writeInt(0);
        v31.writeInt(0);
        v31.writeZeroBytes(10);
        return v31.getPacket();
    }

    public static /* synthetic */ byte[] modifyInventory(boolean a2, List<ModifyInventory> a3) {
        return MaplePacketCreator.modifyInventory(a2, a3, null, false);
    }

    public static /* synthetic */ byte[] spawnReactor(MapleReactor a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleReactor mapleReactor = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleReactor mapleReactor2 = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REACTOR_SPAWN.getValue());
        maplePacketLittleEndianWriter.writeInt(mapleReactor2.getObjectId());
        maplePacketLittleEndianWriter3.writeInt(mapleReactor2.getReactorId());
        maplePacketLittleEndianWriter3.write(a2.getState());
        maplePacketLittleEndianWriter.writePos(mapleReactor.getPosition());
        maplePacketLittleEndianWriter2.write(mapleReactor.getFacingDirection());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateCharLook(MapleCharacter a2) {
        return MaplePacketCreator.updateCharLook(a2, false);
    }

    public static /* synthetic */ byte[] getPotentialReset(boolean a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_POTENTIAL_RESET.getValue());
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a2 ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a4);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] \u52f3\u7ae0(MapleCharacter a2) {
        int n2;
        MapleCharacter mapleCharacter = a2;
        String string = mapleCharacter.getNick();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(MaplePacketOperation.GuildStatus.\u986f\u793a\u516c\u6703\u8cc7\u8a0a);
        if (mapleCharacter == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.write(0);
            return maplePacketLittleEndianWriter2.getPacket();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter.writeMapleAsciiString(string);
        int n3 = n2 = 1;
        while (n3 <= 5) {
            maplePacketLittleEndianWriter.writeMapleAsciiString("");
            n3 = ++n2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter11.write(0);
        maplePacketLittleEndianWriter11.writeInt(0);
        maplePacketLittleEndianWriter10.writeAsciiString("", GameSetConstants.WRITE_STRING_LENGTH);
        maplePacketLittleEndianWriter10.writeInt(0);
        maplePacketLittleEndianWriter9.writeInt(0);
        maplePacketLittleEndianWriter9.writeInt(0);
        maplePacketLittleEndianWriter8.writeInt(0);
        maplePacketLittleEndianWriter8.writeInt(0);
        maplePacketLittleEndianWriter7.writeInt(0);
        maplePacketLittleEndianWriter7.writeInt(0);
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter6.write(0);
        maplePacketLittleEndianWriter5.writeShort(0);
        maplePacketLittleEndianWriter5.write(0);
        maplePacketLittleEndianWriter4.writeMapleAsciiString("");
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter13.writeInt(0);
            maplePacketLittleEndianWriter13.write(0);
            maplePacketLittleEndianWriter12.writeShort(0);
            maplePacketLittleEndianWriter12.writeShort(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showTraitMaxed(MapleTrait.MapleTraitType a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.TRAIT_MAX.getValue());
        maplePacketLittleEndianWriter2.writeLong(a2.getStat().getValue());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateFishKingScore(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_EQUIP_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] updatePlayerStats(List<Pair<MapleStat, Integer>> a2, MapleCharacter a3) {
        return MaplePacketCreator.updatePlayerStats(a2, false, a3);
    }

    public static /* synthetic */ void addShopInfo(MaplePacketLittleEndianWriter a4, MapleShop a5, MapleClient a6) {
        Object object;
        Object object2;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a4.write(a5.getRanks().size() > 0 ? 1 : 0);
            if (a5.getRanks().size() > 0) {
                MapleShop mapleShop = a5;
                a4.write(mapleShop.getRanks().size());
                Object object3 = object2 = mapleShop.getRanks().iterator();
                while (object3.hasNext()) {
                    Pair<Integer, String> pair = object2.next();
                    a4.writeInt((Integer)pair.left);
                    a4.writeMapleAsciiString((String)pair.right);
                    object3 = object2;
                }
            }
        }
        object2 = a5.getItems();
        Collections.sort(object2, (a2, a3) -> a2.getItemId() - a3.getItemId());
        int n2 = 0;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object = (MapleShopItem)object2.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            ++n2;
            MaplePacketCreator.addShopItemInfo(maplePacketLittleEndianWriter2, (MapleShopItem)object, a5, mapleItemInformationProvider, null, a6.getPlayer());
            if (maplePacketLittleEndianWriter2.getPacket().length <= 60000) continue;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            object2 = a6.getPlayer().getRebuy();
            Object object4 = object = object2.iterator();
            while (object4.hasNext()) {
                object2 = (MapleShopItem)object.next();
                object4 = object;
                Object object5 = object2;
                ++n2;
                MaplePacketCreator.addShopItemInfo(maplePacketLittleEndianWriter, (MapleShopItem)object5, a5, mapleItemInformationProvider, ((MapleShopItem)object5).getReBuyItem(), a6.getPlayer());
            }
        }
        a4.writeShort(n2);
        a4.write(maplePacketLittleEndianWriter.getPacket());
    }

    public static /* synthetic */ byte[] updateExpPotion(int a2, int a3, int a4, boolean a5, int a6, int a7, int a8) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.EXP_POTION.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter.writeInt(n2);
        if (n2 != 0) {
            maplePacketLittleEndianWriter.write(1);
            if (a2 == 1) {
                maplePacketLittleEndianWriter.writeInt(0);
            }
            if (a2 == 2) {
                maplePacketLittleEndianWriter.write(a5 ? 1 : 0);
                int n3 = a4;
                maplePacketLittleEndianWriter.writeInt(n3);
                if (n3 != 0) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter.writeInt(a6);
                    maplePacketLittleEndianWriter3.writeInt(a7);
                    maplePacketLittleEndianWriter3.writeLong(a8);
                }
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateQuestInfo(MapleCharacter a2, int a3, int a4, byte a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_QUEST_INFO.getValue());
        maplePacketLittleEndianWriter3.write(a5);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getOthersTalk(int a2, byte a3, int a4, String a5, String a6, byte a7) {
        String[] arrstring = new String[1];
        arrstring[0] = a5;
        int[] arrn = new int[3];
        arrn[0] = a6.startsWith(AbstractPlayerInteraction.ALLATORIxDEMO("1f!")) ? 0 : 1;
        arrn[1] = a6.endsWith(MapleParty.ALLATORIxDEMO("9@)")) ? 0 : 1;
        arrn[2] = 0;
        return MaplePacketCreator.OnScriptMessage(3, a2, a4 > 0 ? a4 : -1, -1, a3, a7, 0, arrstring, arrn, null, null);
    }

    public static /* synthetic */ byte[] showConsumeItemEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_CONSUME_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] moveFollow(Point a2, Point a3, Point a4, List<LifeMovementFragment> a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FOLLOW_MOVE.getValue());
        maplePacketLittleEndianWriter3.writePos(a2);
        maplePacketLittleEndianWriter3.writePos(a3);
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter2, a5);
        maplePacketLittleEndianWriter2.write(17);
        int n2 = a3 = 0;
        while (n2 < 8) {
            maplePacketLittleEndianWriter.write(136);
            n2 = ++a3;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(8);
        maplePacketLittleEndianWriter4.writePos(a4);
        maplePacketLittleEndianWriter4.writePos(a2);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] followEffect(int a2, int a3, Point a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FOLLOW_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(n2);
        if (n2 == 0) {
            maplePacketLittleEndianWriter.write(a4 == null ? 0 : 1);
            if (a4 != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter3.writeInt(a4.x);
                maplePacketLittleEndianWriter3.writeInt(a4.y);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] cancelForeignBuff(int a2, List<MapleBuffStat> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CANCEL_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        MaplePacketCreator.H(maplePacketLittleEndianWriter2, a3);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.write(3);
            maplePacketLittleEndianWriter3.write(1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] autoLogin(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.AUTO_LOGIN.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveEnergyCharge(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        ArrayList<MapleBuffStat> arrayList = new ArrayList<MapleBuffStat>();
        arrayList.add(MapleBuffStat.ENERGY_CHARGE);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketCreator.H(maplePacketLittleEndianWriter, arrayList);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        int n2 = a3;
        maplePacketLittleEndianWriter3.writeInt(Math.min(n2, 10000));
        maplePacketLittleEndianWriter3.writeInt(n2 >= 10000 ? a2 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter4.writeShort(a3 >= 10000 ? a4 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeZeroBytes(10);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static final /* synthetic */ byte[] spawnPortal(int a2, int a3, int a4, Point a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        block3: {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            block2: {
                block1: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
                    maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPAWN_PORTAL.getValue());
                    maplePacketLittleEndianWriter3.writeInt(a2);
                    maplePacketLittleEndianWriter3.writeInt(a3);
                    if (GameSetConstants.MAPLE_VERSION < 134) break block1;
                    if (a2 == 999999999 || a3 == 999999999) break block2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.writeInt(a4);
                    maplePacketLittleEndianWriter4.writePos(a5);
                    break block3;
                }
                if (a5 != null) {
                    maplePacketLittleEndianWriter2.writePos(a5);
                }
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] spawnKite(int a2, int a3, String a4, String a5, Point a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_KITE.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a5);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a4);
        maplePacketLittleEndianWriter2.writeShort(a6.x);
        maplePacketLittleEndianWriter2.writeShort(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, List<Pair<MapleBuffStat, Integer>> a3) {
        int[] arrn = new int[GameSetConstants.MAX_BUFFSTAT];
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            int n2;
            Pair pair = (Pair)a3.next();
            int n3 = n2 = ((MapleBuffStat)pair.getLeft()).getPosition();
            arrn[n3] = (int)((long)arrn[n3] | ((MapleBuffStat)pair.getLeft()).getValue());
            object = a3;
        }
        int n4 = a3 = 0;
        while (n4 < arrn.length) {
            a2.writeInt(arrn[a3++]);
            n4 = a3;
        }
    }

    public static /* synthetic */ byte[] getTradeCancel(byte a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u96e2\u958b.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3 == 0 ? 2 : (a3 == 1 ? 9 : 10));
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendMarriage(boolean a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MARRIAGE_UPDATE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] updateCookieScore(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter3.writeShort(10227);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(String.valueOf(a2));
        maplePacketLittleEndianWriter2.writeZeroBytes(8);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateMessengerPlayer(String a2, MapleCharacter a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter4.write(7);
        maplePacketLittleEndianWriter3.write(a4);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter3, a3, true);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeShort(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showLocalFacialExpression(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FACIAL_EXPRESSION_LOCAL.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(-1);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showIncFatigueByRest() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter.write(StatusInfoType.INC_FATIGUE_BY_REST.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showFishingKingPVPRank(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FISHING_KING_RANKING.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        Object object = MapleRanking.getInstance().getFishingKingRank();
        if (object != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(object.size());
            maplePacketLittleEndianWriter3.writeZeroBytes(2);
            Object object2 = object = object.iterator();
            while (object2.hasNext()) {
                MapleRanking.fishingKingRankingInfo fishingKingRankingInfo2 = (MapleRanking.fishingKingRankingInfo)object.next();
                object2 = object;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                MapleRanking.fishingKingRankingInfo fishingKingRankingInfo3 = fishingKingRankingInfo2;
                maplePacketLittleEndianWriter.writeMapleAsciiString(fishingKingRankingInfo3.getName(), 15);
                maplePacketLittleEndianWriter4.writeInt(fishingKingRankingInfo3.getPoints());
                maplePacketLittleEndianWriter4.writeZeroBytes(2);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] summonSkill(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SUMMON_SKILL.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getPlayerShopNewVisitor(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(HexTool.getByteArrayFromHexString("04 0" + a3));
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        PacketHelper.addCharLook(maplePacketLittleEndianWriter3, a2, false);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2.getName());
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] getPVPTransform(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_TRANSFORM.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getNPCShop(MapleClient a2, int a3, List<MapleShopItem> a4, MapleShop a5) {
        a4 = new MaplePacketLittleEndianWriter();
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        ((MaplePacketLittleEndianWriter)a4).writeShort(SendPacketOpcode.OPEN_NPC_SHOP.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            ((MaplePacketLittleEndianWriter)a4).writeInt(0);
        }
        ((MaplePacketLittleEndianWriter)a4).writeInt(a3);
        if (GameSetConstants.MAPLE_VERSION > 139) {
            ((MaplePacketLittleEndianWriter)a4).writeInt(GameConstants.getCurrentDate());
        }
        Object object = a4;
        MaplePacketCreator.addShopInfo((MaplePacketLittleEndianWriter)object, a5, a2);
        return ((MaplePacketLittleEndianWriter)object).getPacket();
    }

    public static /* synthetic */ byte[] spawnNPC(MapleNPC a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleNPC mapleNPC = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_NPC.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter.writeShort(mapleNPC.getPosition().x);
        maplePacketLittleEndianWriter2.writeShort(mapleNPC.getCy());
        maplePacketLittleEndianWriter2.write(a2.getF() == 1 ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MapleNPC mapleNPC2 = a2;
        maplePacketLittleEndianWriter.writeShort(a2.getFh());
        maplePacketLittleEndianWriter.writeShort(mapleNPC2.getRx0());
        maplePacketLittleEndianWriter4.writeShort(mapleNPC2.getRx1());
        maplePacketLittleEndianWriter4.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] itemCooldown(boolean a2, int a3, long a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.ITEM_COOLDOWN.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeLong(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendDamage(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(a3 ? SendPacketOpcode.NORASHIELD_DAMAGE.getValue() : SendPacketOpcode.YUTOSHIELD_DAMAGE.getValue());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] disbandAlliance(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(29);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getTimeBombAttack(int a2, Point a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.TIME_BOMB_ATTACK.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a3.x);
        maplePacketLittleEndianWriter3.writeInt(a3.y);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] serverBlocked(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SERVER_BLOCKED.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] pendantSlot(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PENDANT_SLOT.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, String[] a3) {
        int n2;
        a2.write(a3.length);
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = a3[n2];
            a2.writeMapleAsciiString(string);
            n4 = ++n2;
        }
    }

    public static /* synthetic */ byte[] openWeb(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(1395);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getWhisper(String a2, int a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.WHISPER.getValue());
        maplePacketLittleEndianWriter3.write(18);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeShort(a3 - 1);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] showOwnHpHealed(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(SpecialEffect.HEAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] summonAttack(int a2, int a3, byte a42, List<SummonAttackEntry> a52, int a6, boolean a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SUMMON_ATTACK.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter.write(a6 - 1);
        }
        maplePacketLittleEndianWriter.write(a42);
        maplePacketLittleEndianWriter.write(a52.size());
        Iterator<SummonAttackEntry> iterator = a3 = a52.iterator();
        while (iterator.hasNext()) {
            SummonAttackEntry a42 = a3.next();
            maplePacketLittleEndianWriter.writeInt(a42.getMonster().getObjectId());
            int a52 = 7;
            if (GameSetConstants.MAPLE_VERSION == 75) {
                a52 = 6;
            }
            maplePacketLittleEndianWriter.write(a52);
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                maplePacketLittleEndianWriter.write(0);
            }
            maplePacketLittleEndianWriter.writeInt(a42.getDamage());
            iterator = a3;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(a7 ? 1 : 0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getShowInventoryFull() {
        return MaplePacketCreator.getShowInventoryStatus(255);
    }

    public static /* synthetic */ byte[] updateSidekick(MapleCharacter a2, MapleSidekick a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SIDEKICK_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 78 : 70);
        MapleSidekick mapleSidekick = a3;
        MapleSidekickCharacter mapleSidekickCharacter = mapleSidekick.getCharacter(mapleSidekick.getCharacter(0).getId() == a2.getId() ? 1 : 0);
        boolean bl = a2.getMap().getCharacterById(mapleSidekickCharacter.getId()) != null;
        maplePacketLittleEndianWriter.writeInt(((MapleSidekick)((Object)a3)).getId());
        if (a4) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(mapleSidekickCharacter.getName());
        }
        Iterator iterator = a3 = ((MapleSidekick)((Object)a3)).getSidekickMsg(bl);
        maplePacketLittleEndianWriter.writeInt(iterator.size());
        Iterator iterator2 = a3 = iterator.iterator();
        while (iterator2.hasNext()) {
            String string = (String)a3.next();
            iterator2 = a3;
            maplePacketLittleEndianWriter.writeMapleAsciiString(string);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeInt(a2.getId());
        maplePacketLittleEndianWriter6.writeInt(mapleSidekickCharacter.getId());
        maplePacketLittleEndianWriter6.writeAsciiString(a2.getName(), 13);
        maplePacketLittleEndianWriter5.writeAsciiString(mapleSidekickCharacter.getName(), 13);
        maplePacketLittleEndianWriter5.writeInt(a2.getJob());
        maplePacketLittleEndianWriter4.writeInt(mapleSidekickCharacter.getJobId());
        maplePacketLittleEndianWriter4.writeInt(a2.getLevel());
        maplePacketLittleEndianWriter3.writeInt(mapleSidekickCharacter.getLevel());
        maplePacketLittleEndianWriter3.writeInt(a2.getClient().getChannel() - 1);
        maplePacketLittleEndianWriter.writeInt(bl ? a2.getClient().getChannel() - 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter7.writeLong(0L);
        maplePacketLittleEndianWriter7.writeInt(a2.getId());
        if (a4) {
            maplePacketLittleEndianWriter.writeInt(a2.getId());
        }
        maplePacketLittleEndianWriter.writeInt(mapleSidekickCharacter.getId());
        if (!a4) {
            maplePacketLittleEndianWriter.writeInt(a2.getId());
        }
        maplePacketLittleEndianWriter.writeInt(a2.getMapId());
        maplePacketLittleEndianWriter.writeInt(bl ? a2.getMapId() : 999999999);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter10.writeInt(1);
        maplePacketLittleEndianWriter10.write(Math.abs(a2.getLevel() - mapleSidekickCharacter.getLevel()));
        maplePacketLittleEndianWriter9.writeInt(0);
        maplePacketLittleEndianWriter9.writeInt(0);
        maplePacketLittleEndianWriter8.writeInt(Integer.MAX_VALUE);
        maplePacketLittleEndianWriter8.writeInt(1);
        return maplePacketLittleEndianWriter8.getPacket();
    }

    public static /* synthetic */ byte[] fuckGuildInfo(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Object object = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = object;
        ((MaplePacketLittleEndianWriter)object).writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(26);
        object = a2.getNick();
        maplePacketLittleEndianWriter.write(1);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter.writeMapleAsciiString((String)object);
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeShort(0);
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.writeShort(0);
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getLieDetector(byte a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        byte by = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LIE_DETECTOR.getValue());
        maplePacketLittleEndianWriter2.write(by);
        switch (by) {
            case 4: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                while (false) {
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter3.write(0);
                maplePacketLittleEndianWriter3.writeMapleAsciiString("");
                break;
            }
            case 5: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter4.write(1);
                maplePacketLittleEndianWriter4.writeMapleAsciiString(a3);
                break;
            }
            case 6: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter5.write(4);
                maplePacketLittleEndianWriter5.write(1);
                break;
            }
            case 7: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
                maplePacketLittleEndianWriter6.write(4);
                break;
            }
            case 9: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter7;
                maplePacketLittleEndianWriter7.write(0);
                break;
            }
            case 8: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter8.write(0);
                maplePacketLittleEndianWriter8.writeMapleAsciiString("");
                break;
            }
            case 10: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter9.write(0);
                maplePacketLittleEndianWriter9.writeMapleAsciiString("");
                break;
            }
            default: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter10;
                maplePacketLittleEndianWriter10.write(0);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] storeStorage(byte a2, MapleInventoryType a3, Collection<IItem> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.OPEN_STORAGE.getValue());
        int n2 = 13;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 = 12;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(n2);
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeShort(((MapleInventoryType)((Object)a3)).getBitfieldEncoding());
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter.write(a4.size());
        a3 = a4.iterator();
        Object object = a3;
        while (object.hasNext()) {
            a4 = (IItem)a3.next();
            object = a3;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, (IItem)a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] giveDebuff(List<Pair<MapleBuffStat, Integer>> a2, int a3, int a4, int a5, int a6) {
        Iterator<Pair<MapleBuffStat, Integer>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<Pair<MapleBuffStat, Integer>> list = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter, list);
        Iterator<Pair<MapleBuffStat, Integer>> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            Pair<MapleBuffStat, Integer> pair = iterator.next();
            maplePacketLittleEndianWriter.writeShort(pair.getRight().shortValue());
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeShort(a3);
            maplePacketLittleEndianWriter2.writeShort(a4);
            maplePacketLittleEndianWriter2.writeInt(a5);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(a6);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeZeroBytes(20);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] getOwlOpen() {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOP_SCANNER_RESULT.getValue());
        int n3 = 7;
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            n3 = 9;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.write(n3);
        maplePacketLittleEndianWriter2.write(ServerConstants.owlItems.length);
        int[] arrn = ServerConstants.owlItems;
        int n4 = ServerConstants.owlItems.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            maplePacketLittleEndianWriter.writeInt(arrn[n2++]);
            n5 = n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getOwlSearched(int a2, List<HiredMerchant> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOP_SCANNER_RESULT.getValue());
        int n2 = 6;
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            n2 = 8;
        }
        maplePacketLittleEndianWriter.write(n2);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        maplePacketLittleEndianWriter.writeInt(a2);
        TreeMap<MaplePlayerShopItem, HiredMerchant> treeMap = new TreeMap<MaplePlayerShopItem, HiredMerchant>(new Comparator<MaplePlayerShopItem>(){

            @Override
            public /* synthetic */ int compare(MaplePlayerShopItem a2, MaplePlayerShopItem a32) {
                int a32 = a2.price;
                int n2 = a32.price;
                if (a32 < n2) {
                    return -1;
                }
                if (a32 == n2) {
                    return 0;
                }
                return 1;
            }
            {
                4 a2;
            }
        });
        a3 = a3.iterator();
        while (a3.hasNext()) {
            HiredMerchant object = (HiredMerchant)((Object)a3.next());
            Iterator<MaplePlayerShopItem> iterator = object.searchItem(a2).iterator();
            while (iterator.hasNext()) {
                Iterator<MaplePlayerShopItem> iterator2;
                MaplePlayerShopItem maplePlayerShopItem = iterator2.next();
                iterator = iterator2;
                treeMap.put(maplePlayerShopItem, object);
            }
        }
        maplePacketLittleEndianWriter.writeInt(treeMap.size());
        for (Map.Entry entry : treeMap.entrySet()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter.writeMapleAsciiString(((HiredMerchant)entry.getValue()).getOwnerName());
            maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getMap().getId());
            maplePacketLittleEndianWriter.writeMapleAsciiString(((HiredMerchant)entry.getValue()).getDescription());
            maplePacketLittleEndianWriter.writeInt(((MaplePlayerShopItem)entry.getKey()).item.getQuantity());
            maplePacketLittleEndianWriter.writeInt(((MaplePlayerShopItem)entry.getKey()).bundles);
            maplePacketLittleEndianWriter.writeInt((int)((long)((MaplePlayerShopItem)entry.getKey()).price >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (long)((MaplePlayerShopItem)entry.getKey()).price));
            switch (2) {
                case 0: {
                    while (false) {
                    }
                    maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getOwnerId());
                    maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                    break;
                }
                case 1: {
                    maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getStoreId());
                    maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                    break;
                }
                default: {
                    maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getObjectId());
                    maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                }
            }
            maplePacketLittleEndianWriter2.write(((HiredMerchant)entry.getValue()).getMap().getChannel() - 1);
            int n3 = a2;
            maplePacketLittleEndianWriter.write(GameConstants.getInventoryType(n3).getType());
            if (GameConstants.getInventoryType(n3) != MapleInventoryType.EQUIP) continue;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, ((MaplePlayerShopItem)entry.getKey()).item);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] moveSummon(int a2, int a3, Point a4, List<LifeMovementFragment> a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MOVE_SUMMON.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writePos(a4);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter4, a5);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static final /* synthetic */ byte[] getSlotUpdate(byte a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_INVENTORY_SLOT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removePlayerFromMap(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.REMOVE_PLAYER_FROM_MAP.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showCraftingEffect(int a2, String a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.write(32);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] instantMapWarp(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CURRENT_MAP_WARP.getValue());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getOwlMessage(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(3);
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.OWL_RESULT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] enableActions() {
        return MaplePacketCreator.updatePlayerStats(EMPTY_STATUPDATE, true, null);
    }

    public /* synthetic */ MaplePacketCreator() {
        MaplePacketCreator a2;
    }

    public static /* synthetic */ byte[] environmentChange(String a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.BOSS_ENV.getValue());
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        if (a3 == 3) {
            maplePacketLittleEndianWriter.write(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] modifyInventory(boolean a2, List<ModifyInventory> a3, MapleCharacter a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        maplePacketLittleEndianWriter.write(a5 ? 2 : a3.size());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.write(0);
        }
        int n2 = -1;
        IItem iItem = null;
        a3 = a3.iterator();
        Iterator iterator = a3;
        while (iterator.hasNext()) {
            ModifyInventory modifyInventory;
            block18: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3;
                ModifyInventory modifyInventory2 = (ModifyInventory)a3.next();
                iItem = modifyInventory2.getItem().copy();
                if (modifyInventory2.getMode() == 1 && ItemConstants.isInBag(modifyInventory2.getPosition(), modifyInventory2.getInventoryType())) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.write(6);
                } else if (modifyInventory2.getMode() == 3 && ItemConstants.isInBag(modifyInventory2.getPosition(), modifyInventory2.getInventoryType())) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter5;
                    maplePacketLittleEndianWriter5.write(7);
                } else {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter6;
                    maplePacketLittleEndianWriter6.write(modifyInventory2.getMode());
                }
                maplePacketLittleEndianWriter3.write(modifyInventory2.getInventoryType());
                boolean bl = modifyInventory2.getMode() == 2 || modifyInventory2.getMode() == 8 || modifyInventory2.getMode() == 5 && !modifyInventory2.switchSrcDst();
                ModifyInventory modifyInventory3 = modifyInventory2;
                maplePacketLittleEndianWriter.writeShort(bl ? modifyInventory3.getOldPosition() : modifyInventory3.getPosition());
                switch (modifyInventory2.getMode()) {
                    case 0: {
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter, modifyInventory2.getItem());
                        modifyInventory = modifyInventory2;
                        break block18;
                    }
                    case 1: {
                        maplePacketLittleEndianWriter.writeShort(modifyInventory2.getQuantity());
                        modifyInventory = modifyInventory2;
                        break block18;
                    }
                    case 2: {
                        maplePacketLittleEndianWriter.writeShort(modifyInventory2.getPosition());
                        if (modifyInventory2.getPosition() >= 0 && modifyInventory2.getOldPosition() >= 0) break;
                        n2 = modifyInventory2.getOldPosition() < 0 ? 1 : 2;
                        modifyInventory = modifyInventory2;
                        break block18;
                    }
                    case 3: {
                        if (modifyInventory2.getPosition() < 0) {
                            n2 = 2;
                        }
                        if (!a5) break;
                        ModifyInventory modifyInventory4 = modifyInventory2;
                        modifyInventory = modifyInventory4;
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
                        maplePacketLittleEndianWriter.write(0);
                        maplePacketLittleEndianWriter7.write(modifyInventory2.getInventoryType());
                        maplePacketLittleEndianWriter7.writeShort(modifyInventory2.getPosition());
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter, modifyInventory4.getItem(), a4);
                        break block18;
                    }
                    case 5: {
                        ModifyInventory modifyInventory5 = modifyInventory2;
                        maplePacketLittleEndianWriter.writeShort(!modifyInventory2.switchSrcDst() ? modifyInventory5.getPosition() : modifyInventory5.getOldPosition());
                        if (modifyInventory2.getIndicator() == -1) break;
                        ModifyInventory modifyInventory6 = modifyInventory2;
                        modifyInventory = modifyInventory6;
                        maplePacketLittleEndianWriter.writeShort(modifyInventory6.getIndicator());
                        break block18;
                    }
                    case 6: {
                        maplePacketLittleEndianWriter.writeShort(modifyInventory2.getQuantity());
                        modifyInventory = modifyInventory2;
                        break block18;
                    }
                    case 8: {
                        maplePacketLittleEndianWriter.writeShort(modifyInventory2.getPosition());
                        modifyInventory = modifyInventory2;
                        break block18;
                    }
                    case 9: {
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter, modifyInventory2.getItem(), a4);
                    }
                }
                modifyInventory = modifyInventory2;
            }
            modifyInventory.clear();
            iterator = a3;
        }
        if (n2 > -1) {
            maplePacketLittleEndianWriter.write(n2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateSpecialItemUse(IItem a2, byte a3, short a4, boolean a5, MapleCharacter a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a5 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a5;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a5;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a5;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a5;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter5.write(0);
        maplePacketLittleEndianWriter4.write(2);
        maplePacketLittleEndianWriter4.write(3);
        maplePacketLittleEndianWriter3.write(a3);
        maplePacketLittleEndianWriter3.writeShort(a4);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter.writeShort(a4);
        PacketHelper.addItemInfo(maplePacketLittleEndianWriter, a2, a6);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] genericGuildMessage(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getTradeItemAdd(byte a2, IItem a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u8a2d\u5b9a\u9053\u5177.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.write(a3.getPosition());
        PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] enablePVP(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_ENABLED.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 2);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] guildLeaderChanged(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(89);
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeInt(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] useAPReset(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.AP_RESET.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] sendDuey(byte a2, List<MapleDueyActions> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        byte by = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DUEY.getValue());
        maplePacketLittleEndianWriter2.write(by);
        switch (by) {
            case 9: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.write(1);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 25: {
                break;
            }
            case 26: {
                maplePacketLittleEndianWriter2.writeMapleAsciiString("");
                byte by2 = 0;
                maplePacketLittleEndianWriter2.write((byte)0);
            }
            case 27: {
                maplePacketLittleEndianWriter2.write(0);
            }
            case 28: {
                maplePacketLittleEndianWriter2.write(0);
            }
            case 10: {
                maplePacketLittleEndianWriter2.write(0);
                maplePacketLittleEndianWriter2.write(a3.size());
                Iterator iterator = a3.iterator();
                while (iterator.hasNext()) {
                    a3 = (MapleDueyActions)iterator.next();
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                    Object object = a3;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter6.writeInt(((MapleDueyActions)a3).getPackageId());
                    maplePacketLittleEndianWriter6.writeAsciiString(((MapleDueyActions)a3).getSender(), GameSetConstants.WRITE_STRING_LENGTH);
                    maplePacketLittleEndianWriter2.writeInt(((MapleDueyActions)object).getMesos());
                    maplePacketLittleEndianWriter5.writeLong(KoreanDateUtil.getFileTimestamp(((MapleDueyActions)object).getSentTime(), false));
                    maplePacketLittleEndianWriter5.writeShort(0);
                    maplePacketLittleEndianWriter4.writeAsciiString(((MapleDueyActions)a3).getMsg(), 193);
                    maplePacketLittleEndianWriter4.writeZeroBytes(10);
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                    if (((MapleDueyActions)a3).getItem() != null) {
                        maplePacketLittleEndianWriter7.write(1);
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, ((MapleDueyActions)a3).getItem());
                        continue;
                    }
                    maplePacketLittleEndianWriter7.write(0);
                }
                maplePacketLittleEndianWriter2.write(0);
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showMuLungPortal() {
        return MaplePacketCreator.showSpecialEffect(SpecialEffect.MULUNG_DOJO_UP.getValue());
    }

    public static /* synthetic */ byte[] RemoveSpeakLimit() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REMOVE_SPEAK_LIMIT.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] showFeeMesoGain(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(StatusInfoType.SHOW_INVENTORY_GAIN_INCHAT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(24);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateBuddyChannel(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.BUDDYLIST.getValue());
        maplePacketLittleEndianWriter3.write(20);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] damageFriendlyMob(MapleMonster a2, long a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MapleMonster mapleMonster;
        MapleMonster mapleMonster2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DAMAGE_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter3.write(a4 ? 1 : 2);
        if (a3 > Integer.MAX_VALUE) {
            mapleMonster2 = a2;
            maplePacketLittleEndianWriter2.writeInt(Integer.MAX_VALUE);
        } else {
            maplePacketLittleEndianWriter2.writeInt((int)a3);
            mapleMonster2 = a2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        if (mapleMonster2.getHp() > Integer.MAX_VALUE) {
            maplePacketLittleEndianWriter4.writeInt((int)((double)(a2.getHp() / a2.getMobMaxHp()) * 2.147483647E9));
            mapleMonster = a2;
        } else {
            maplePacketLittleEndianWriter4.writeInt((int)a2.getHp());
            mapleMonster = a2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        if (mapleMonster.getMobMaxHp() > Integer.MAX_VALUE) {
            maplePacketLittleEndianWriter5.writeInt(Integer.MAX_VALUE);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            maplePacketLittleEndianWriter5.writeInt((int)a2.getMobMaxHp());
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showMagnet(int a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_MAGNET.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] cancelForeignSoulEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CANCEL_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        PacketHelper.writeBuffState(maplePacketLittleEndianWriter2, MapleBuffStat.SOUL_SKILL);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] strafeAttack(int a2, byte a3, int a422, int a522, int a6, byte a7, int a8, List<AttackPair> a9, Point a10, int a11, byte a12, byte a13, int a14) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a13 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a13;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.RANGED_ATTACK.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.write((int)a11);
        if (a422 > 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a13;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write((int)a522);
            maplePacketLittleEndianWriter4.writeInt(a422);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a13;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.write(0);
        }
        maplePacketLittleEndianWriter.write((int)a14);
        if (a14 > 0) {
            a13.writeInt(3220010);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a13;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a13;
        maplePacketLittleEndianWriter7.write(0);
        maplePacketLittleEndianWriter7.writeShort((int)a6);
        maplePacketLittleEndianWriter6.write((byte)a7);
        maplePacketLittleEndianWriter6.write((byte)a12);
        a13.writeInt((int)a8);
        for (AttackPair a422 : a9) {
            if (a422.attack == null) continue;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a13;
            maplePacketLittleEndianWriter8.writeInt(a422.objectid);
            maplePacketLittleEndianWriter8.write(7);
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                a13.write(0);
            }
            for (Pair<Integer, Boolean> a522 : a422.attack) {
                if (((Boolean)a522.right).booleanValue()) {
                    a13.writeInt((Integer)a522.left + Integer.MIN_VALUE);
                    continue;
                }
                a13.writeInt((Integer)a522.left);
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = a13;
        maplePacketLittleEndianWriter9.writePos((Point)a10);
        return maplePacketLittleEndianWriter9.getPacket();
    }

    public static final /* synthetic */ byte[] getMovingPlatforms(MapleMap a2) {
        Iterator<MapleNodes.MaplePlatform> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleMap mapleMap = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MOVE_PLATFORM.getValue());
        maplePacketLittleEndianWriter.writeInt(mapleMap.getPlatforms().size());
        Iterator<MapleNodes.MaplePlatform> iterator2 = iterator = mapleMap.getPlatforms().iterator();
        while (iterator2.hasNext()) {
            int n2;
            MapleNodes.MaplePlatform maplePlatform = iterator.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleNodes.MaplePlatform maplePlatform2 = maplePlatform;
            maplePacketLittleEndianWriter.writeMapleAsciiString(maplePlatform2.name);
            maplePacketLittleEndianWriter2.writeInt(maplePlatform2.start);
            maplePacketLittleEndianWriter2.writeInt(maplePlatform.SN.size());
            int n3 = n2 = 0;
            while (n3 < maplePlatform.SN.size()) {
                Integer n4 = maplePlatform.SN.get(n2);
                maplePacketLittleEndianWriter.writeInt(n4);
                n3 = ++n2;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleNodes.MaplePlatform maplePlatform3 = maplePlatform;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MapleNodes.MaplePlatform maplePlatform4 = maplePlatform;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            MapleNodes.MaplePlatform maplePlatform5 = maplePlatform;
            maplePacketLittleEndianWriter.writeInt(maplePlatform5.speed);
            maplePacketLittleEndianWriter5.writeInt(maplePlatform5.x1);
            maplePacketLittleEndianWriter5.writeInt(maplePlatform.x2);
            maplePacketLittleEndianWriter.writeInt(maplePlatform4.y1);
            maplePacketLittleEndianWriter4.writeInt(maplePlatform4.y2);
            maplePacketLittleEndianWriter4.writeInt(maplePlatform.x1);
            maplePacketLittleEndianWriter3.writeInt(maplePlatform3.y1);
            maplePacketLittleEndianWriter3.writeShort(maplePlatform3.r);
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] pvpBlocked(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_BLOCKED.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    private static /* synthetic */ void H(MaplePacketLittleEndianWriter a2, List<MapleBuffStat> a3) {
        int[] arrn = new int[GameSetConstants.MAX_BUFFSTAT];
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            MapleBuffStat mapleBuffStat = (MapleBuffStat)a3.next();
            object = a3;
            int n2 = mapleBuffStat.getPosition();
            arrn[n2] = (int)((long)arrn[n2] | mapleBuffStat.getValue());
        }
        int n3 = a3 = 0;
        while (n3 < arrn.length) {
            a2.writeInt(arrn[a3++]);
            n3 = a3;
        }
    }

    public static /* synthetic */ byte[] skillExpired(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(15);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showPQrewardItem(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.PartyStatus.PQ\u734e\u52f5\u7269\u54c1);
        int n2 = 6;
        do {
            maplePacketLittleEndianWriter.write(a3);
            maplePacketLittleEndianWriter.writeInt(a2);
            if (a3 <= 5) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                int n3 = a3;
                maplePacketLittleEndianWriter.write(a3 + 1);
                maplePacketLittleEndianWriter.writeShort(n3 + 1);
                maplePacketLittleEndianWriter3.writeShort(n3 + 1);
                maplePacketLittleEndianWriter3.writeShort(a3 + 1);
            }
            ++a3;
        } while (--n2 >= 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getBuffSelection(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter4.write(4);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writeShort(MaplePacketOperation.NPCPacket.MapSelection);
        maplePacketLittleEndianWriter3.writeInt(4);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showSpecailSkillEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (a2 == -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
            maplePacketLittleEndianWriter4.writeInt(a2);
        }
        maplePacketLittleEndianWriter.write(SpecialEffect.SPECIAL_SKILL.getValue());
        int n2 = a3;
        maplePacketLittleEndianWriter2.writeInt(n2);
        if (n2 == 4341003) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveMount(int a2, int a3, List<Pair<MapleBuffStat, Integer>> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a4);
        maplePacketLittleEndianWriter2.writeShort(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter3.writeZeroBytes(20);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] summonMessage(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SUMMON_HINT_MSG.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(7000);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showEffect(String a2) {
        int n2 = 3;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n2 = 4;
        }
        return MaplePacketCreator.environmentChange(a2, n2);
    }

    public static final /* synthetic */ byte[] temporaryStats_Reset() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.TEMP_STATS_RESET.getValue());
        if (GameSetConstants.MAPLE_VERSION == 75) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter2.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] removeMechDoor(MechDoor a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MECH_DOOR_REMOVE.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a2.getOwnerId());
        maplePacketLittleEndianWriter3.write(a2.getId());
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] updateCoreAura(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_CORE_AURA.getValue());
        maplePacketLittleEndianWriter2.write(1);
        PacketHelper.addCharacterInfo(maplePacketLittleEndianWriter2, a2, false);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] PVPType(int a2, boolean a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PVP_TYPE.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.write(a4);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] modifyInventory(boolean a2, ModifyInventory a3, MapleCharacter a4) {
        return MaplePacketCreator.modifyInventory(a2, Collections.singletonList(a3), a4, false);
    }

    public static /* synthetic */ byte[] setSkillMap(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SKILL_MAP.getValue());
        maplePacketLittleEndianWriter2.write(a3 != 0);
        maplePacketLittleEndianWriter.writeInt(a2);
        if (a3 != 0) {
            maplePacketLittleEndianWriter.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showForeignEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] touchFamiliar(int a2, byte a3, int a4, int a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.TOUCH_FAMILIAR.getValue());
        maplePacketLittleEndianWriter5.writeInt(a2);
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter4.write(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        maplePacketLittleEndianWriter2.writeInt(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateItemCoolTime(int a2, long a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ITEM_COOLTIME.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeLong(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] updateSp(MapleCharacter a2, boolean a3) {
        return MaplePacketCreator.updateSp(a2, a3, false);
    }

    public static /* synthetic */ byte[] joinMessenger(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] changeTeam(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LOAD_TEAM.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, String a3, int a4, short a5) {
        if ((a5 & 4) != 0) {
            a2.writeInt(a4);
        }
        a2.writeMapleAsciiString(a3);
    }

    public static /* synthetic */ byte[] showdpmRanks(int a2, List<MapleRanking.dpmRankingInfo> a32) {
        Iterator<MapleRanking.dpmRankingInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.dpmRankingInfo> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.dpmRankingInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.dpmRankingInfo dpmRankingInfo2 = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.dpmRankingInfo dpmRankingInfo3 = dpmRankingInfo2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.dpmRankingInfo dpmRankingInfo4 = dpmRankingInfo2;
            maplePacketLittleEndianWriter.writeMapleAsciiString(dpmRankingInfo2.getName());
            maplePacketLittleEndianWriter.writeInt(Long.valueOf(dpmRankingInfo4.getdps()).intValue());
            maplePacketLittleEndianWriter3.writeInt(dpmRankingInfo4.getStr());
            maplePacketLittleEndianWriter3.writeInt(dpmRankingInfo2.getDex());
            maplePacketLittleEndianWriter2.writeInt(dpmRankingInfo3.getInt());
            maplePacketLittleEndianWriter2.writeInt(dpmRankingInfo3.getLuk());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] takeOutStorage(byte a2, MapleInventoryType a3, Collection<IItem> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Collection<IItem> collection = a4;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.OPEN_STORAGE.getValue());
        maplePacketLittleEndianWriter4.write(9);
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeShort(((MapleInventoryType)((Object)a3)).getBitfieldEncoding());
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter.write(collection.size());
        a3 = collection.iterator();
        Object object = a3;
        while (object.hasNext()) {
            a4 = (IItem)a3.next();
            object = a3;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, (IItem)a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showGuildRanks(int a2, List<MapleRanking.GuildRankingInfo> a32) {
        Iterator<MapleRanking.GuildRankingInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.GuildRankingInfo> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.GuildRankingInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.GuildRankingInfo guildRankingInfo = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.GuildRankingInfo guildRankingInfo2 = guildRankingInfo;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.GuildRankingInfo guildRankingInfo3 = guildRankingInfo;
            maplePacketLittleEndianWriter.writeMapleAsciiString(guildRankingInfo.getName());
            maplePacketLittleEndianWriter.writeInt(guildRankingInfo3.getGP());
            maplePacketLittleEndianWriter3.writeInt(guildRankingInfo3.getLogo());
            maplePacketLittleEndianWriter3.writeInt(guildRankingInfo.getLogoColor());
            maplePacketLittleEndianWriter2.writeInt(guildRankingInfo2.getLogoBg());
            maplePacketLittleEndianWriter2.writeInt(guildRankingInfo2.getLogoBgColor());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] expeditionStatus(MapleExpedition a2, boolean a32) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.EXPEDITION_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a32 ? 73 : 71);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a2.getType().exped);
        maplePacketLittleEndianWriter3.writeInt(0);
        int a32 = 190;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a32 += 24;
        }
        if (GameSetConstants.MAPLE_VERSION >= 148) {
            a32 += 24;
        }
        int n3 = n2 = 0;
        while (n3 < 5) {
            if (n2 < a2.getParties().size()) {
                MapleParty mapleParty = World.Party.getParty(a2.getParties().get(n2));
                if (mapleParty != null) {
                    MaplePacketCreator.ALLATORIxDEMO(-1, mapleParty, maplePacketLittleEndianWriter, false, true);
                } else {
                    maplePacketLittleEndianWriter.writeZeroBytes((int)a32);
                }
            } else {
                maplePacketLittleEndianWriter.writeZeroBytes((int)a32);
            }
            n3 = ++n2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(0);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] petAutoHP(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PET_AUTO_HP.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] rangedAttack(MapleCharacter a2, int a3, int a4, AttackInfo a5, int a6, byte a7) {
        MapleCharacter mapleCharacter = a2;
        return MaplePacketCreator.addAttackBody(SendPacketOpcode.RANGED_ATTACK, mapleCharacter, mapleCharacter.getId(), a3, a5, a6, a7, a4);
    }

    public static /* synthetic */ byte[] hitSnowBall(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.HIT_SNOWBALL.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter2.write(a4);
        maplePacketLittleEndianWriter2.write(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] OnScriptMessage(int a2, int a3, int a4, int a5, byte a6, int a7, int a8, String[] a9, int[] a10, int[][] a11, MaplePet[] a12) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a3;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.write(a6);
        if (a5 > -1) {
            a7 |= 4;
        }
        a3.write(a7);
        switch (a6) {
            case 0: {
                int[] arrn;
                boolean bl;
                int[] arrn2;
                boolean bl2;
                String string = a9[0];
                short s2 = (short)a7;
                if (a10[0] > 0) {
                    bl2 = true;
                    arrn2 = a10;
                } else {
                    bl2 = false;
                    arrn2 = a10;
                }
                if (arrn2[1] > 0) {
                    bl = true;
                    arrn = a10;
                } else {
                    bl = false;
                    arrn = a10;
                }
                MaplePacketCreator.ALLATORIxDEMO(a3, string, a5, s2, bl2, bl, arrn[2]);
                maplePacketLittleEndianWriter = a3;
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 1: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a3;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter4, a9);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 5: {
                MaplePacketCreator.ALLATORIxDEMO(a3, a9[0], a5, (short)a7);
            }
        }
        maplePacketLittleEndianWriter = a3;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMacros(SkillMacro[] a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SKILL_MACRO.getValue());
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < 5) {
            if (a2[n2] != null) {
                ++n3;
            }
            n4 = ++n2;
        }
        maplePacketLittleEndianWriter.write(n3);
        int n5 = n2 = 0;
        while (n5 < 5) {
            SkillMacro skillMacro = a2[n2];
            if (skillMacro != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                SkillMacro skillMacro2 = skillMacro;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter3.writeMapleAsciiString(skillMacro.getName());
                maplePacketLittleEndianWriter3.write(skillMacro.getShout());
                maplePacketLittleEndianWriter.writeInt(skillMacro2.getSkill1());
                maplePacketLittleEndianWriter2.writeInt(skillMacro2.getSkill2());
                maplePacketLittleEndianWriter2.writeInt(skillMacro.getSkill3());
            }
            n5 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPType(int a2, List<Pair<Integer, String>> a3, int a42, boolean a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PVP_TYPE.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.write(a6);
        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
        if (a2 > 0) {
            List<Pair<Integer, String>> list = a3;
            maplePacketLittleEndianWriter.write(a42);
            maplePacketLittleEndianWriter.writeInt(list.size());
            Object object = a3 = list.iterator();
            while (object.hasNext()) {
                Pair a42 = (Pair)a3.next();
                maplePacketLittleEndianWriter.writeInt((Integer)a42.left);
                maplePacketLittleEndianWriter.writeMapleAsciiString((String)a42.right);
                object = a3;
                maplePacketLittleEndianWriter.writeShort(2660);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showDiceEffect(int a2, int a3, int a4, int a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (a2 == -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
            maplePacketLittleEndianWriter4.writeInt(a2);
        }
        maplePacketLittleEndianWriter.write(3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter2.writeInt(a5);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter5.write(a6);
        maplePacketLittleEndianWriter5.write(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] leftKnockBack() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LEFT_KNOCK_BACK.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] skillEffect(MapleCharacter a2, int a3, byte a4, byte a5, byte a6, byte a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SKILL_EFFECT.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getId());
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter3.write(a5);
        maplePacketLittleEndianWriter2.write(a6);
        maplePacketLittleEndianWriter2.write(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveDice(int a2, int a3, int a4, List<Pair<MapleBuffStat, Integer>> a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        PacketHelper.writeBuffMask(maplePacketLittleEndianWriter4, a5);
        maplePacketLittleEndianWriter4.writeShort(Math.max(a2 / 100, Math.max(a2 / 10, a2 % 10)));
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
        int n2 = a2;
        maplePacketLittleEndianWriter.writeInt(GameConstants.getDiceStat(n2, 3));
        maplePacketLittleEndianWriter10.writeInt(GameConstants.getDiceStat(n2, 3));
        maplePacketLittleEndianWriter10.writeInt(GameConstants.getDiceStat(a2, 4));
        maplePacketLittleEndianWriter9.writeZeroBytes(20);
        maplePacketLittleEndianWriter9.writeInt(GameConstants.getDiceStat(a2, 2));
        maplePacketLittleEndianWriter8.writeZeroBytes(12);
        maplePacketLittleEndianWriter8.writeInt(GameConstants.getDiceStat(a2, 5));
        maplePacketLittleEndianWriter7.writeZeroBytes(16);
        maplePacketLittleEndianWriter7.writeInt(GameConstants.getDiceStat(a2, 6));
        maplePacketLittleEndianWriter6.writeZeroBytes(16);
        maplePacketLittleEndianWriter6.writeInt(0);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter5.write(4);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] scrolledItem(IItem a2, IItem a3, boolean a4, boolean a5) {
        return MaplePacketCreator.scrolledItem(a2, a3, a4, a5, false);
    }

    public static /* synthetic */ byte[] messengerInvite(String a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter4.write(3);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] resetCapture() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CAPTURE_RESET.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] GreenSaver(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_STATS.getValue());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.writeLong(MapleStat.VIRTUE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getGreenSaver());
        maplePacketLittleEndianWriter2.writeLong(0L);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getClock(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CLOCK.getValue());
        maplePacketLittleEndianWriter2.write(2);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getItemNotice(String a2) {
        return MaplePacketCreator.getItemNotice(a2, 0);
    }

    public static /* synthetic */ byte[] showEquipEffect() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_EQUIP_EFFECT.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] catchMonster(int a2, int a3, byte a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CATCH_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getFusionAnvil(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(3 + (a2 ? 1 : 0));
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SYNTHESIZING_MSG.getValue());
        maplePacketLittleEndianWriter2.writeBoolean(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removeExtractor(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REMOVE_EXTRACTOR.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getCapturePosition(MapleMap a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleMap mapleMap = a2;
        Point point = mapleMap.getPointOfItem(2910000);
        Point point2 = mapleMap.getPointOfItem(2910001);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CAPTURE_POSITION.getValue());
        maplePacketLittleEndianWriter2.write(point == null ? 0 : 1);
        if (point != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(point.x);
            maplePacketLittleEndianWriter3.writeInt(point.y);
        }
        maplePacketLittleEndianWriter.write(point2 == null ? 0 : 1);
        if (point2 != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(point2.x);
            maplePacketLittleEndianWriter4.writeInt(point2.y);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showOwnSpecialSkillEffect(int a2) {
        return MaplePacketCreator.showSpecialSkillEffect(-1, a2);
    }

    public static /* synthetic */ byte[] removeSummon(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.REMOVE_SUMMON.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(10);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, Map<MapleBuffStat, Integer> a3) {
        int[] arrn = new int[4];
        Object object = a3 = a3.keySet().iterator();
        while (object.hasNext()) {
            MapleBuffStat mapleBuffStat = (MapleBuffStat)a3.next();
            int n2 = mapleBuffStat.getPosition();
            n2 = n2 < 0 ? 0 : n2;
            int[] arrn2 = arrn;
            object = a3;
            int n3 = n2;
            arrn2[n3] = arrn2[n3] | (int)mapleBuffStat.getValue();
        }
        int n4 = a3 = 0;
        while (n4 < arrn.length) {
            a2.writeInt(arrn[a3++]);
            n4 = a3;
        }
    }

    public static /* synthetic */ byte[] giveArcane(Map<Integer, Integer> a2, int a3, int a4) {
        Iterator<Map.Entry<Integer, Integer>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Map<Integer, Integer> map = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        PacketHelper.writeBuffState(maplePacketLittleEndianWriter3, MapleBuffStat.ARCANE_AIM);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter.writeInt(map.size());
        int n2 = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator2 = iterator = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            maplePacketLittleEndianWriter.writeInt(entry.getKey());
            maplePacketLittleEndianWriter.writeInt(entry.getValue());
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(a3);
            n2 = entry.getValue();
            iterator2 = iterator;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter.writeZeroBytes(20);
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter12.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
            PacketHelper.writeBuffState(maplePacketLittleEndianWriter12, MapleBuffStat.ARCANE_AIM);
            maplePacketLittleEndianWriter11.writeShort(n2);
            maplePacketLittleEndianWriter11.writeInt(a4);
            maplePacketLittleEndianWriter10.writeInt(a3);
            maplePacketLittleEndianWriter10.writeShort(0);
            maplePacketLittleEndianWriter9.write(0);
            maplePacketLittleEndianWriter9.writeShort(0);
            maplePacketLittleEndianWriter8.writeShort(0);
            maplePacketLittleEndianWriter8.write(0);
            maplePacketLittleEndianWriter7.write(0);
            maplePacketLittleEndianWriter7.writeZeroBytes(9);
            return maplePacketLittleEndianWriter7.getPacket();
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getClockTime(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CLOCK.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.write(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] boatEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.BOAT_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] destroyReactor(MapleReactor a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleReactor mapleReactor = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REACTOR_DESTROY.getValue());
        maplePacketLittleEndianWriter.writeInt(mapleReactor.getObjectId());
        maplePacketLittleEndianWriter2.write(mapleReactor.getState());
        maplePacketLittleEndianWriter2.writePos(a2.getPosition());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendFriendWindow(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (SendPacketOpcode.OPEN_UI_OPTION.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.OPEN_UI_OPTION.getValue());
        maplePacketLittleEndianWriter3.writeInt(211);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ void addQuestMedalInfo(MapleCharacter a2, MaplePacketLittleEndianWriter a3) {
        MapleCharacter mapleCharacter = a2;
        Object object = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-121);
        MapleTrait.MapleTraitType[] arrmapleTraitType = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-21);
        a3.writeInt(object != null ? object.getItemId() : (arrmapleTraitType == null ? 0 : arrmapleTraitType.getItemId()));
        object = new ArrayList();
        for (MapleQuestStatus mapleQuestStatus : a2.getCompletedQuests()) {
            if (mapleQuestStatus.getQuest().getMedalItem() <= 0 || GameConstants.getInventoryType(mapleQuestStatus.getQuest().getMedalItem()) != MapleInventoryType.EQUIP) continue;
            object.add(mapleQuestStatus);
        }
        a3.writeShort(object.size());
        arrmapleTraitType = object.iterator();
        while (arrmapleTraitType.hasNext()) {
            MapleQuestStatus mapleQuestStatus;
            mapleQuestStatus = (MapleQuestStatus)arrmapleTraitType.next();
            a3.writeShort(mapleQuestStatus.getQuest().getId());
            if (GameSetConstants.MAPLE_VERSION < 139) continue;
            a3.writeLong(mapleQuestStatus.getCompletionTime());
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            int n2;
            arrmapleTraitType = MapleTrait.MapleTraitType.values();
            int n3 = arrmapleTraitType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleTrait.MapleTraitType mapleTraitType = arrmapleTraitType[n2];
                a3.write(a2.getTrait(mapleTraitType).getLevel());
                n4 = ++n2;
            }
        }
    }

    public static final /* synthetic */ byte[] getUpdateEnvironment(MapleMap a2) {
        Iterator<Map.Entry<String, Integer>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleMap mapleMap = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MOVE_ENV.getValue());
        maplePacketLittleEndianWriter.writeInt(mapleMap.getEnvironment().size());
        Iterator<Map.Entry<String, Integer>> iterator2 = iterator = mapleMap.getEnvironment().entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            maplePacketLittleEndianWriter.writeMapleAsciiString(entry.getKey());
            maplePacketLittleEndianWriter.writeInt(entry.getValue());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] removeDragon(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DRAGON_REMOVE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getBoxMega(String a2, String a3, IItem a4, int a5) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO(SmegaType.BOX_MESSAGE.getValue(), a5, arrstring, false, a4, a3);
    }

    public static /* synthetic */ byte[] showOwnBuffEffect(int a2, int a3, int a4, int a5, byte a6) {
        return MaplePacketCreator.showBuffEffect(-1, a2, a3, a4, a5, a6);
    }

    public static /* synthetic */ byte[] showOwnCraftingEffect(String a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter4.write(32);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, String a3, int a4, short a5, boolean a6, boolean a7, int a8) {
        if ((a5 & 4) != 0) {
            a2.writeInt(a4);
        }
        a2.writeMapleAsciiString(a3);
        a2.write(a6 ? 1 : 0);
        a2.write(a7 ? 1 : 0);
    }

    public static /* synthetic */ byte[] showMonsterRiding(int a2, Map<MapleBuffStat, Integer> a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter6.writeInt(a2);
        PacketHelper.writeBuffMask(maplePacketLittleEndianWriter6, a3);
        maplePacketLittleEndianWriter5.writeShort(0);
        maplePacketLittleEndianWriter5.write(0);
        maplePacketLittleEndianWriter4.writeInt(a4);
        maplePacketLittleEndianWriter4.writeInt(a5);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] buddylistMessage(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BUDDYLIST.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] quickSlot(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.QUICK_SLOT.getValue());
        maplePacketLittleEndianWriter2.write(a2 == null || a2.equals("") ? 0 : 1);
        if (a2 != null && !a2.equals("")) {
            int n2;
            String[] arrstring = a2.split(MapleParty.ALLATORIxDEMO("5"));
            int n3 = n2 = 0;
            while (n3 < 8) {
                maplePacketLittleEndianWriter.writeInt(Integer.parseInt(arrstring[n2++]));
                n3 = n2;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] guildNotice(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u8a0a\u606f);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] guildMemberOnline(int a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u6210\u54e1\u4e0a\u7dda);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] playerDamaged(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_DAMAGED.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPScore(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_SCORE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] deactivateAndroid(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ANDROID_DEACTIVATED.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] pvpSummonAttack(int a2, int a32, int a42, int a522, Point a6, List<AttackPair> a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        void v0 = a7;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_SUMMON.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a42);
        maplePacketLittleEndianWriter3.write(a32);
        maplePacketLittleEndianWriter3.write((int)a522);
        maplePacketLittleEndianWriter2.writePos((Point)a6);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter.write(v0.size());
        Iterator a32 = v0.iterator();
        while (a32.hasNext()) {
            AttackPair attackPair = a42 = (AttackPair)a32.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(a42.objectid);
            maplePacketLittleEndianWriter5.writePos(a42.point);
            maplePacketLittleEndianWriter.writeShort(attackPair.attack.size());
            Iterator<Pair<Integer, Boolean>> iterator = attackPair.attack.iterator();
            while (iterator.hasNext()) {
                Pair<Integer, Boolean> a522 = a42.next();
                maplePacketLittleEndianWriter.writeInt((Integer)a522.left);
                iterator = a42;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateHyperSp(int a2, int a3) {
        return MaplePacketCreator.updateSpecialStat(MapleParty.ALLATORIxDEMO("q\ti\u0015k"), 28, a2, a3);
    }

    public static /* synthetic */ byte[] showOXQuiz(int a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.OX_QUIZ.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] spawnPlayerNPC(PlayerNPC a2) {
        int n2;
        Object object;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_NPC.getValue());
        maplePacketLittleEndianWriter2.write(a2.getF() != 1 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        PlayerNPC playerNPC = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(a2.getId());
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a2.getName());
        maplePacketLittleEndianWriter.write(playerNPC.getGender());
        maplePacketLittleEndianWriter3.write(playerNPC.getSkin());
        maplePacketLittleEndianWriter3.writeInt(a2.getFace());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.writeInt(a2.getHair());
        Map<Byte, Integer> map = a2.getEquips();
        LinkedHashMap<Byte, Integer> linkedHashMap = new LinkedHashMap<Byte, Integer>();
        LinkedHashMap<Byte, Integer> linkedHashMap2 = new LinkedHashMap<Byte, Integer>();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Object object2 = map.entrySet().iterator();
        while (object2.hasNext()) {
            object = object2.next();
            byte by = (byte)(object.getKey() * -1);
            if (by < 100 && linkedHashMap.get(by) == null) {
                linkedHashMap.put(by, object.getValue());
                continue;
            }
            if ((by > 100 || by == -128) && by != 111) {
                if (linkedHashMap.get(by = (byte)(by == -128 ? 28 : by - 100)) != null) {
                    linkedHashMap2.put(by, (Integer)linkedHashMap.get(by));
                }
                linkedHashMap.put(by, (Integer)object.getValue());
                continue;
            }
            if (linkedHashMap.get(by) == null) continue;
            linkedHashMap2.put(by, object.getValue());
        }
        Object object3 = object2 = linkedHashMap.entrySet().iterator();
        while (object3.hasNext()) {
            object = object2.next();
            maplePacketLittleEndianWriter.write(object.getKey());
            maplePacketLittleEndianWriter.writeInt(object.getValue());
            object3 = object2;
        }
        maplePacketLittleEndianWriter.write(255);
        Object object4 = object2 = linkedHashMap2.entrySet().iterator();
        while (object4.hasNext()) {
            object = object2.next();
            maplePacketLittleEndianWriter.write(object.getKey());
            maplePacketLittleEndianWriter.writeInt(object.getValue());
            object4 = object2;
        }
        maplePacketLittleEndianWriter.write(255);
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            Object object5 = object2 = linkedHashMap3.entrySet().iterator();
            while (object5.hasNext()) {
                object = (Map.Entry)object2.next();
                maplePacketLittleEndianWriter.write((Byte)object.getKey());
                maplePacketLittleEndianWriter.writeInt((Integer)object.getValue());
                object5 = object2;
            }
            maplePacketLittleEndianWriter.write(255);
        }
        object2 = map.get(-111);
        object = map.get(-111);
        Integer n3 = map.get(-111);
        maplePacketLittleEndianWriter.writeInt(object2 == null ? 0 : (Integer)object2);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeInt(object == null ? 0 : (Integer)object);
            maplePacketLittleEndianWriter.writeInt(n3 == null ? 0 : n3);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.write(0);
        }
        int n4 = n2 = 0;
        while (n4 < 3) {
            maplePacketLittleEndianWriter.writeInt(a2.getPet(n2++));
            n4 = n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] arrangeStorage(byte a2, Collection<IItem> a3, boolean a42) {
        MaplePacketLittleEndianWriter a42 = new MaplePacketLittleEndianWriter();
        Collection<IItem> collection = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a42;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a42;
        a42.writeShort(SendPacketOpcode.OPEN_STORAGE.getValue());
        maplePacketLittleEndianWriter2.write(15);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter.write(124);
        maplePacketLittleEndianWriter.writeZeroBytes(10);
        a42.write(collection.size());
        Object object = a3 = collection.iterator();
        while (object.hasNext()) {
            IItem iItem = (IItem)a3.next();
            object = a3;
            PacketHelper.addItemInfo(a42, iItem);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a42;
        maplePacketLittleEndianWriter3.write(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] environmentMove(String a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MOVE_ENV.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getNpcPopupMsg(int a2, String a3) {
        String[] arrstring = new String[1];
        arrstring[0] = a3;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.NPC_POP_MESSAGE.getValue(), a2, arrstring, false, null);
    }

    public static /* synthetic */ byte[] showEffectLose() {
        return MaplePacketCreator.environmentChange(MapleParty.ALLATORIxDEMO("\u0003l\u001dt\u0015k\u0012v\u0011m\u0019w\u00176\u001cv\u0003|"), 3);
    }

    public static final /* synthetic */ byte[] temporaryStats(List<Pair<MapleStat.Temp, Integer>> a2) {
        Serializable serializable;
        Object object;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.TEMP_STATS.getValue());
        int n2 = 0;
        Object object2 = object = a2.iterator();
        while (object2.hasNext()) {
            serializable = object.next();
            n2 |= ((Pair)serializable).getLeft().getValue();
            object2 = object;
        }
        object = a2;
        if (object.size() > 1) {
            Collections.sort(object, new Comparator<Pair<MapleStat.Temp, Integer>>(){
                {
                    3 a2;
                }

                @Override
                public /* synthetic */ int compare(Pair<MapleStat.Temp, Integer> a2, Pair<MapleStat.Temp, Integer> a3) {
                    int n2 = a2.getLeft().getValue();
                    if (n2 < (a3 = a3.getLeft().getValue())) {
                        return -1;
                    }
                    if (n2 == a3) {
                        return 0;
                    }
                    return 1;
                }
            });
        }
        maplePacketLittleEndianWriter.writeInt(n2);
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = (Pair)iterator.next();
            serializable = Integer.valueOf(((MapleStat.Temp)((Object)((Pair)object).getLeft())).getValue());
            if ((Integer)serializable < 1) continue;
            if ((Integer)serializable <= 512) {
                maplePacketLittleEndianWriter.writeShort(((Integer)((Pair)object).getRight()).shortValue());
                continue;
            }
            maplePacketLittleEndianWriter.write(((Integer)((Pair)object).getRight()).byteValue());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showDonateMesoRanks(int a2, List<MapleRanking.DonateMesoRankingInfo> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.DonateMesoRankingInfo> list = a3;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        Object object = a3 = list.iterator();
        while (object.hasNext()) {
            MapleRanking.DonateMesoRankingInfo donateMesoRankingInfo = (MapleRanking.DonateMesoRankingInfo)a3.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(0);
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.DonateMesoRankingInfo donateMesoRankingInfo2 = donateMesoRankingInfo;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.DonateMesoRankingInfo donateMesoRankingInfo3 = donateMesoRankingInfo;
            maplePacketLittleEndianWriter.writeMapleAsciiString(donateMesoRankingInfo.getName());
            maplePacketLittleEndianWriter.writeInt(donateMesoRankingInfo3.getMeso());
            maplePacketLittleEndianWriter3.writeInt(donateMesoRankingInfo3.getStr());
            maplePacketLittleEndianWriter3.writeInt(donateMesoRankingInfo.getDex());
            maplePacketLittleEndianWriter2.writeInt(donateMesoRankingInfo2.getInt());
            maplePacketLittleEndianWriter2.writeInt(donateMesoRankingInfo2.getLuk());
            object = a3;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] partyPortal(int a2, int a3, int a4, Point a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.PartyStatus.\u968a\u4f0d\u50b3\u9001\u9ede);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(a4);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writePos(a5);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPScoreboard(List<Pair<Integer, MapleCharacter>> a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<Pair<Integer, MapleCharacter>> list = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_SCOREBOARD.getValue());
        maplePacketLittleEndianWriter.writeShort(list.size());
        for (Pair<Integer, MapleCharacter> pair : list) {
            maplePacketLittleEndianWriter.writeInt(((MapleCharacter)pair.right).getId());
            maplePacketLittleEndianWriter.writeMapleAsciiString(((MapleCharacter)pair.right).getName());
            maplePacketLittleEndianWriter.writeInt((Integer)pair.left);
            maplePacketLittleEndianWriter.write(a3 == 0 ? 0 : ((MapleCharacter)pair.right).getTeam() + 1);
            if (GameSetConstants.MAPLE_VERSION < 139) continue;
            maplePacketLittleEndianWriter.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] gainForce(boolean a2, MapleCharacter a3, List<Integer> a4, int a5, int a6, int a7, int a8, List<Pair<Integer, Integer>> a9) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (GameSetConstants.MAPLE_VERSION == 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter2.writeInt(a4.get(0));
            int n2 = a7;
            maplePacketLittleEndianWriter.writeInt(n2);
            if (n2 > 0) {
                boolean bl = true;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter3.write(true);
                maplePacketLittleEndianWriter3.writeInt(a4.size());
                if (a7 == 2 && a4.size() > 0) {
                    Iterator<Integer> iterator;
                    Iterator<Integer> iterator2 = iterator = a4.iterator();
                    while (iterator2.hasNext()) {
                        int n3 = iterator.next();
                        iterator2 = iterator;
                        maplePacketLittleEndianWriter.writeInt(n3);
                    }
                }
                maplePacketLittleEndianWriter.writeInt(0);
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.write(1);
            maplePacketLittleEndianWriter7.writeInt(a5);
            maplePacketLittleEndianWriter7.writeInt(a6);
            maplePacketLittleEndianWriter6.writeInt(Randomizer.rand(15, 29));
            maplePacketLittleEndianWriter6.writeInt(Randomizer.rand(7, 11));
            maplePacketLittleEndianWriter5.writeInt(Randomizer.rand(0, 9));
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter4.write(0);
            maplePacketLittleEndianWriter4.writeZeroBytes(20);
            return maplePacketLittleEndianWriter.getPacket();
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8;
            Object object;
            boolean bl = a2;
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
            maplePacketLittleEndianWriter.write(bl);
            if (bl) {
                maplePacketLittleEndianWriter.writeInt(a3.getId());
            }
            maplePacketLittleEndianWriter.writeInt(a2 ? a4.get(0).intValue() : a3.getId());
            int n4 = a7;
            maplePacketLittleEndianWriter.writeInt(n4);
            if (n4 >= 2 && a7 <= 3) {
                boolean bl2 = true;
                List<Integer> list = a4;
                maplePacketLittleEndianWriter.write(true);
                maplePacketLittleEndianWriter.writeInt(list.size());
                Object object2 = object = list.iterator();
                while (object2.hasNext()) {
                    int n5 = object.next();
                    object2 = object;
                    maplePacketLittleEndianWriter.writeInt(n5);
                }
            } else {
                maplePacketLittleEndianWriter.writeInt(a4.get(0));
            }
            if (a8 == 61120007 || a8 == 61121217 || a8 == 61110211 || a8 == 61121217) {
                maplePacketLittleEndianWriter.writeInt(a8);
            }
            if (a9 == null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter9;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter.write(1);
                maplePacketLittleEndianWriter11.writeInt(a5);
                maplePacketLittleEndianWriter11.writeInt(a6);
                maplePacketLittleEndianWriter10.writeInt(Randomizer.rand(15, 29));
                maplePacketLittleEndianWriter10.writeInt(Randomizer.rand(7, 11));
                maplePacketLittleEndianWriter9.writeInt(Randomizer.rand(0, 9));
                maplePacketLittleEndianWriter9.writeInt(0);
            } else {
                Iterator<Pair<Integer, Integer>> iterator;
                Iterator<Pair<Integer, Integer>> iterator3 = iterator = a9.iterator();
                while (iterator3.hasNext()) {
                    object = iterator.next();
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter12.write(1);
                    maplePacketLittleEndianWriter12.writeInt((Integer)((Pair)object).left);
                    maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object).right);
                    iterator3 = iterator;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = maplePacketLittleEndianWriter;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter14.writeInt(Randomizer.rand(15, 29));
                    maplePacketLittleEndianWriter14.writeInt(Randomizer.rand(5, 6));
                    maplePacketLittleEndianWriter13.writeInt(Randomizer.rand(35, 50));
                    maplePacketLittleEndianWriter13.writeInt(0);
                }
                maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
            }
            maplePacketLittleEndianWriter8.write(0);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter15 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter15.writeZeroBytes(20);
            return maplePacketLittleEndianWriter15.getPacket();
        }
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter16 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
            maplePacketLittleEndianWriter16.write(1);
            maplePacketLittleEndianWriter16.writeInt(a4.get(0));
            boolean bl = false;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter17 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter18 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter19 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter20 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter20.writeInt(0);
            maplePacketLittleEndianWriter20.write(1);
            maplePacketLittleEndianWriter19.writeInt(a5);
            maplePacketLittleEndianWriter19.writeInt(a6);
            maplePacketLittleEndianWriter18.writeInt(Randomizer.rand(15, 29));
            maplePacketLittleEndianWriter18.writeInt(Randomizer.rand(7, 11));
            maplePacketLittleEndianWriter17.writeInt(Randomizer.rand(0, 9));
            maplePacketLittleEndianWriter17.write(0);
            return maplePacketLittleEndianWriter17.getPacket();
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter21 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
            maplePacketLittleEndianWriter21.write(1);
            maplePacketLittleEndianWriter21.writeInt(a4.get(0));
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter22 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter23 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter23.write(1);
            maplePacketLittleEndianWriter23.writeInt(a5);
            maplePacketLittleEndianWriter22.writeInt(a6);
            maplePacketLittleEndianWriter22.write(0);
            return maplePacketLittleEndianWriter22.getPacket();
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getAvatarMega(MapleCharacter a2, int a3, int a4, String a5, boolean a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.AVATAR_MEGA.getValue());
        maplePacketLittleEndianWriter4.writeInt(a4);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2.getName());
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a5);
        maplePacketLittleEndianWriter2.writeInt(a3 - 1);
        maplePacketLittleEndianWriter2.write(a6 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        PacketHelper.addCharLook(maplePacketLittleEndianWriter5, a2, true);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] skillCooldown(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.COOLDOWN.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a3);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.writeShort(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getDeathCountInfo(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (SendPacketOpcode.INDIVIDUAL_DEATH_COUNT_INFO.getValue() <= -1 || SendPacketOpcode.DEATH_COUNT_INFO.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        maplePacketLittleEndianWriter.writeShort(a2 ? SendPacketOpcode.INDIVIDUAL_DEATH_COUNT_INFO.getValue() : SendPacketOpcode.DEATH_COUNT_INFO.getValue());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * WARNING - void declaration
     */
    private static /* synthetic */ void ALLATORIxDEMO(int a2, MapleParty a322, MaplePacketLittleEndianWriter a4, boolean a5, boolean a6) {
        Iterator iterator;
        ArrayList<MaplePartyCharacter> arrayList;
        ArrayList<MaplePartyCharacter> arrayList2 = arrayList = new ArrayList<MaplePartyCharacter>(((MapleParty)a322).getMembers());
        while (arrayList2.size() < 6) {
            ArrayList<MaplePartyCharacter> arrayList3 = arrayList;
            arrayList2 = arrayList3;
            arrayList3.add(new MaplePartyCharacter());
        }
        Iterator iterator2 = iterator = arrayList.iterator();
        while (iterator2.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
            iterator2 = iterator;
            a4.writeInt(maplePartyCharacter.getId());
        }
        iterator = arrayList.iterator();
        Iterator iterator3 = iterator;
        while (iterator3.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
            iterator3 = iterator;
            a4.writeAsciiString(maplePartyCharacter.getName(), GameSetConstants.WRITE_STRING_LENGTH);
        }
        iterator = arrayList.iterator();
        Iterator iterator4 = iterator;
        while (iterator4.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
            iterator4 = iterator;
            a4.writeInt(maplePartyCharacter.getJobId());
        }
        if (GameSetConstants.MAPLE_VERSION >= 145 && GameSetConstants.MAPLE_VERSION != 147) {
            iterator = arrayList.iterator();
            Iterator iterator5 = iterator;
            while (iterator5.hasNext()) {
                MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
                iterator5 = iterator;
                a4.writeInt(0);
            }
        }
        iterator = arrayList.iterator();
        Iterator iterator6 = iterator;
        while (iterator6.hasNext()) {
            MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
            iterator6 = iterator;
            a4.writeInt(maplePartyCharacter.getLevel());
        }
        for (MaplePartyCharacter maplePartyCharacter : arrayList) {
            void v7 = a4;
            if (maplePartyCharacter.isOnline()) {
                v7.writeInt(maplePartyCharacter.getChannel() - 1);
                continue;
            }
            v7.writeInt(-2);
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            iterator = arrayList.iterator();
            Iterator iterator7 = iterator;
            while (iterator7.hasNext()) {
                MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
                iterator7 = iterator;
                a4.writeInt(((MapleParty)a322).getLeader().getId());
            }
        }
        a4.writeInt(a322 == null ? 0 : ((MapleParty)a322).getLeader().getId());
        if (a6 != false) {
            return;
        }
        int n2 = 999999999;
        for (MaplePartyCharacter a322 : arrayList) {
            if (a322.getDoorTown() == 999999999) continue;
            n2 = a322.getDoorTown();
        }
        for (MaplePartyCharacter a322 : arrayList) {
            if (a322.getChannel() == a2) {
                if (n2 != 999999999 && GameSetConstants.MAPLE_VERSION >= 147) {
                    a4.writeInt(n2);
                    continue;
                }
                a4.writeInt(a322.getMapid());
                continue;
            }
            a4.writeInt(999999999);
        }
        for (MaplePartyCharacter a322 : arrayList) {
            if (a322.getChannel() == a2 && a5 == false) {
                void v9 = a4;
                v9.writeInt(a322.getDoorTown());
                v9.writeInt(a322.getDoorTarget());
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    a4.writeInt(a322.getDoorSkill());
                }
                void v10 = a4;
                MaplePartyCharacter maplePartyCharacter = a322;
                v10.writeInt(maplePartyCharacter.getDoorPosition().x);
                v10.writeInt(maplePartyCharacter.getDoorPosition().y);
                continue;
            }
            a4.writeInt(a5 != false ? 999999999 : 0);
            a4.writeInt(a5 != false ? 999999999 : 0);
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                a4.writeInt(0);
            }
            a4.writeInt(a5 != false ? -1 : 0);
            a4.writeInt(a5 != false ? -1 : 0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a4.write(1);
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            int n3;
            for (MaplePartyCharacter a322 : arrayList) {
                void v12 = a4;
                if (a322.getId() > 0) {
                    v12.writeInt(255);
                    continue;
                }
                v12.writeInt(0);
            }
            int n4 = n3 = 0;
            while (n4 < 4) {
                void var7_34;
                a4.writeLong(0L);
                n4 = ++var7_34;
            }
        }
    }

    public static /* synthetic */ byte[] addGuildToAlliance(MapleGuildAlliance a2, MapleGuild a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleGuild mapleGuild = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(18);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter3, a2);
        maplePacketLittleEndianWriter.writeInt(mapleGuild.getId());
        MaplePacketCreator.getGuildInfo(maplePacketLittleEndianWriter2, mapleGuild);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getMapSelection(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter3.write(4);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeShort(MaplePacketOperation.NPCPacket.MapSelection);
        maplePacketLittleEndianWriter2.writeInt(a2 == 2083006 ? 1 : 0);
        maplePacketLittleEndianWriter.writeInt(a2 == 9010022 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] removeNPCController(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_NPC_REQUEST_CONTROLLER.getValue());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBuffEffect(int a2, int a3, int a4, int a5, int a6, byte a7) {
        return MaplePacketCreator.showBuffEffect(a2, a3, a4, a5, a6, a7, 0, 0, 0);
    }

    public static /* synthetic */ byte[] getPacketFromHexString(String a2) {
        return HexTool.getByteArrayFromHexString(a2);
    }

    public static final /* synthetic */ byte[] getPVPTeam(List<Pair<Integer, String>> a2) {
        Iterator<Pair<Integer, String>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<Pair<Integer, String>> list = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_TEAM.getValue());
        maplePacketLittleEndianWriter.writeInt(list.size());
        Iterator<Pair<Integer, String>> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            Pair<Integer, String> pair = iterator.next();
            maplePacketLittleEndianWriter.writeInt((Integer)pair.left);
            maplePacketLittleEndianWriter.writeMapleAsciiString((String)pair.right);
            iterator2 = iterator;
            maplePacketLittleEndianWriter.writeShort(2660);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateSkill(int a2, int a3, int a4, long a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_SKILLS.getValue());
        maplePacketLittleEndianWriter2.write(1);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.write(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(1);
        maplePacketLittleEndianWriter5.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter4.writeInt(a4);
        PacketHelper.addExpirationTime(maplePacketLittleEndianWriter3, a5);
        maplePacketLittleEndianWriter3.write(4);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPMode(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_MODE.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnKiteError() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_KITE_ERROR.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] summonHelper(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SUMMON_HINT.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] clearMidMsg() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (SendPacketOpcode.CLEAR_MID_MSG.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CLEAR_MID_MSG.getValue());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showForeignItemLevelupEffect(int a2) {
        return MaplePacketCreator.showSpecialEffect(a2, SpecialEffect.ITEM_LEVEL_UP.getValue());
    }

    public static /* synthetic */ byte[] receiveFame(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.FAME_RESPONSE.getValue());
        maplePacketLittleEndianWriter3.write(5);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getPotentialReset(int a2, short a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_POTENTIAL_RESET.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeShort(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] cancelDebuff(long a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CANCEL_BUFF.getValue());
        maplePacketLittleEndianWriter2.writeLong(a3 ? a2 : 0L);
        maplePacketLittleEndianWriter.writeLong(a3 ? 0L : a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(1);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignDebuff(int a2, List<Pair<MapleBuffStat, Integer>> a3, int a4, int a5, int a6) {
        return MaplePacketCreator.giveForeignDebuff(a2, a3, a4, a5, a6, 0);
    }

    public static final /* synthetic */ byte[] ItemMaker_Success() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(SpecialEffect.ITEM_MAKER_SUCCESS.getValue());
        maplePacketLittleEndianWriter2.writeZeroBytes(4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] removeItemFromMap(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.REMOVE_ITEM_FROM_MAP.getValue());
        maplePacketLittleEndianWriter3.write(a3);
        maplePacketLittleEndianWriter3.writeInt(a2);
        if (a3 >= 2) {
            maplePacketLittleEndianWriter2.writeInt(a4);
            if (a3 == 5) {
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.writeInt(a5);
                    return maplePacketLittleEndianWriter.getPacket();
                }
                maplePacketLittleEndianWriter2.write(a5);
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] memberLeft(MapleGuildCharacter a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? MaplePacketOperation.GuildStatus.\u516c\u6703\u6210\u54e1\u96e2\u958b1 : MaplePacketOperation.GuildStatus.\u516c\u6703\u6210\u54e1\u96e2\u958b2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleGuildCharacter mapleGuildCharacter = a2;
        maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter.getGuildId());
        maplePacketLittleEndianWriter3.writeInt(mapleGuildCharacter.getId());
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2.getName());
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignSoulEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter5.writeInt(a2);
        PacketHelper.writeBuffState(maplePacketLittleEndianWriter5, MapleBuffStat.SOUL_SKILL);
        maplePacketLittleEndianWriter5.writeInt(a3);
        maplePacketLittleEndianWriter4.writeLong(0x60000000000L);
        maplePacketLittleEndianWriter4.writeLong(0L);
        maplePacketLittleEndianWriter3.writeLong(0L);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showQuestTip(List<Integer> a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.QUEST_TIP.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2.size());
        int n3 = n2 = 0;
        while (n3 < a2.size()) {
            int n4;
            int n5 = a2.size();
            maplePacketLittleEndianWriter.writeShort(n5);
            int n6 = n4 = 0;
            while (n6 < n5) {
                Integer n7 = a2.get(n4);
                maplePacketLittleEndianWriter.writeInt(n7);
                n6 = ++n4;
            }
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getFindReplyWithMap(String a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.WHISPER.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 72 : 9);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeZeroBytes(8);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, MapleBBSThread a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MapleBBSThread mapleBBSThread = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MapleBBSThread mapleBBSThread2 = a3;
        a2.writeInt(mapleBBSThread2.localthreadID);
        maplePacketLittleEndianWriter2.writeInt(mapleBBSThread2.ownerID);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3.name);
        a2.writeLong(PacketHelper.getKoreanTimestamp(mapleBBSThread.timestamp));
        maplePacketLittleEndianWriter.writeInt(mapleBBSThread.icon);
        maplePacketLittleEndianWriter.writeInt(a3.getReplyCount());
    }

    public static /* synthetic */ byte[] messengerNote(String a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter3.write(a3);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] changeRank(MapleGuildCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleGuildCharacter mapleGuildCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u66f4\u63db\u6210\u54e1\u968e\u7d1a);
        maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter.getGuildId());
        maplePacketLittleEndianWriter2.writeInt(mapleGuildCharacter.getId());
        maplePacketLittleEndianWriter2.write(a2.getGuildRank());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] trembleEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.BOSS_ENV.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getNPCTalkText(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter2.write(4);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.NPCPacket.TalkText);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter.write(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter3.writeInt(0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ void getGuildInfo(MaplePacketLittleEndianWriter a2, MapleGuild a3, MapleCharacter a4) {
        String string = a4 == null ? "" : a4.getNick();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.writeInt(a3.getId());
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3.getName() + string);
        int n2 = a4 = 1;
        while (n2 <= 5) {
            if (a3.getRankTitle(a4) == null) {
                a2.writeMapleAsciiString("");
            } else {
                a2.writeMapleAsciiString(a3.getRankTitle(a4));
            }
            n2 = ++a4;
        }
        a3.addMemberData(a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MapleGuild mapleGuild = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        MapleGuild mapleGuild2 = a3;
        a2.writeInt(a3.getCapacity());
        a2.writeShort(mapleGuild2.getLogoBG());
        maplePacketLittleEndianWriter3.write(mapleGuild2.getLogoBGColor());
        maplePacketLittleEndianWriter3.writeShort(a3.getLogo());
        a2.write(mapleGuild.getLogoColor());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(mapleGuild.getNotice());
        maplePacketLittleEndianWriter2.writeInt(a3.getGP());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeInt(a3.getGP());
        }
        a2.writeInt(a3.getAllianceId() > 0 ? a3.getAllianceId() : 0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleGuild mapleGuild3 = a3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            maplePacketLittleEndianWriter4.write(a3.getLevel());
            maplePacketLittleEndianWriter4.writeShort(0);
            a2.writeShort(mapleGuild3.getSkills().size());
            Iterator<MapleGuildSkill> iterator = a4 = mapleGuild3.getSkills().iterator();
            while (iterator.hasNext()) {
                a3 = a4.next();
                iterator = a4;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
                Serializable serializable = a3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
                maplePacketLittleEndianWriter6.writeInt(((MapleGuildSkill)a3).skillID);
                maplePacketLittleEndianWriter6.writeShort(((MapleGuildSkill)a3).level);
                a2.writeLong(PacketHelper.getTime(((MapleGuildSkill)serializable).timestamp));
                maplePacketLittleEndianWriter5.writeMapleAsciiString(((MapleGuildSkill)serializable).purchaser);
                maplePacketLittleEndianWriter5.writeMapleAsciiString(((MapleGuildSkill)a3).activator);
            }
        }
    }

    public static /* synthetic */ byte[] moveDragon(MapleDragon a2, Point a3, List<LifeMovementFragment> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.DRAGON_MOVE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getOwner());
        maplePacketLittleEndianWriter2.writePos(a3);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter3, a4);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] temporaryStats_Balrog(MapleCharacter a2) {
        ArrayList<Pair<MapleStat.Temp, Integer>> arrayList = new ArrayList<Pair<MapleStat.Temp, Integer>>();
        int n2 = 1 + (a2.getLevel() - 90) / 20;
        ArrayList<Pair<MapleStat.Temp, Integer>> arrayList2 = arrayList;
        arrayList2.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.STR, a2.getStat().getTotalStr() / n2));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.DEX, a2.getStat().getTotalDex() / n2));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.INT, a2.getStat().getTotalInt() / n2));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.LUK, a2.getStat().getTotalLuk() / n2));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.WATK, a2.getStat().getTotalWatk() / n2));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.MATK, a2.getStat().getTotalMagic() / n2));
        return MaplePacketCreator.temporaryStats(arrayList2);
    }

    public static final /* synthetic */ byte[] sendHyperSkillResetResult(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.HYPER_SKILL_RESET_RESULT.getValue());
        maplePacketLittleEndianWriter3.write(true);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] serverMessage(String a2) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.SCROLL_MESSAGE.getValue(), 0, arrstring, true, null);
    }

    public static /* synthetic */ byte[] updateFamiliar(MonsterFamiliar a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MonsterFamiliar monsterFamiliar = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_FAMILIAR.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getCharacterId());
        maplePacketLittleEndianWriter.writeInt(monsterFamiliar.getFamiliar());
        maplePacketLittleEndianWriter2.writeInt(monsterFamiliar.getFatigue());
        maplePacketLittleEndianWriter2.writeLong(PacketHelper.getTime(a2.getVitality() >= 3 ? System.currentTimeMillis() : -2L));
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showHarvesting(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_HARVEST.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3 > 0 ? 1 : 0);
        if (a3 > 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(a3);
            maplePacketLittleEndianWriter3.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sidekickInvite(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleCharacter mapleCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SIDEKICK_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(65);
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2.getName());
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getLevel());
        maplePacketLittleEndianWriter2.writeInt(mapleCharacter.getJob());
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] MulungEnergy(int a2) {
        return MaplePacketCreator.sendPyramidEnergy(AbstractPlayerInteraction.ALLATORIxDEMO("3o3s1x"), String.valueOf(a2));
    }

    public static /* synthetic */ byte[] getPollReply(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GAME_POLL_REPLY.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] guildMemberLevelJobUpdate(MapleGuildCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleGuildCharacter mapleGuildCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u6210\u54e1\u7b49\u7d1a\u8077\u696d\u66f4\u65b0);
        maplePacketLittleEndianWriter3.writeInt(a2.getGuildId());
        maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter.getId());
        maplePacketLittleEndianWriter2.writeInt(mapleGuildCharacter.getLevel());
        maplePacketLittleEndianWriter2.writeInt(a2.getJobId());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] temporaryStats_Aran() {
        ArrayList<Pair<MapleStat.Temp, Integer>> arrayList;
        ArrayList<Pair<MapleStat.Temp, Integer>> arrayList2 = arrayList = new ArrayList<Pair<MapleStat.Temp, Integer>>();
        arrayList2.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.STR, 999));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.DEX, 999));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.INT, 999));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.LUK, 999));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.WATK, 255));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.ACC, 999));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.AVOID, 999));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.SPEED, 140));
        arrayList.add(new Pair<MapleStat.Temp, Integer>(MapleStat.Temp.JUMP, 120));
        return MaplePacketCreator.temporaryStats(arrayList2);
    }

    public static final /* synthetic */ byte[] GainEXP_Others(int a2, boolean a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.EXP_MSG.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.write(a3 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter4.writeZeroBytes(68);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] getEvanTutorial(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter4.writeInt(8);
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] allianceMemberOnline(int a2, int a3, int a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(14);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getPlayerShopRemoveVisitor(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter2.write(HexTool.getByteArrayFromHexString("0A 0" + a2));
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] MagicWheelAction(int a2) {
        return MaplePacketCreator.MagicWheelAction(a2, null, null, 0);
    }

    public static /* synthetic */ byte[] playVoiceEffect(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(SpecialEffect.SOUND.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getGachaponMega(String a2, IItem a3, int a4) {
        if (GameSetConstants.MAPLE_VERSION < 134) {
            String[] arrstring = new String[1];
            arrstring[0] = a2;
            return MaplePacketCreator.ALLATORIxDEMO(SmegaType.GACH_MESSAGE.getValue(), a4, arrstring, false, a3, "");
        }
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO(SmegaType.ITEM_MESSAGE.getValue(), a4, arrstring, false, a3, "");
    }

    public static /* synthetic */ byte[] showSpecialEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] fairyPendantMessage(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.FAIRY_PEND_MSG.getValue());
        maplePacketLittleEndianWriter4.writeShort(21);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter2.writeShort(a3);
        maplePacketLittleEndianWriter2.writeShort(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] rollSnowball(int a2, MapleSnowball.MapleSnowballs a3, MapleSnowball.MapleSnowballs a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ROLL_SNOWBALL.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3 == null ? 0 : a3.getSnowmanHP() / 75);
        maplePacketLittleEndianWriter.writeInt(a4 == null ? 0 : a4.getSnowmanHP() / 75);
        maplePacketLittleEndianWriter.writeShort(a3 == null ? 0 : a3.getPosition());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.writeShort(a4 == null ? 0 : a4.getPosition());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeZeroBytes(11);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] BBSThreadList(List<MapleBBSThread> a2, int a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MapleBBSThread mapleBBSThread;
        int n3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        block5: {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.BBS_OPERATION.getValue());
            maplePacketLittleEndianWriter3.write(6);
            if (a2 == null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter4.write(0);
                maplePacketLittleEndianWriter4.writeLong(0L);
                return maplePacketLittleEndianWriter4.getPacket();
            }
            List<MapleBBSThread> list = a2;
            n3 = list.size();
            mapleBBSThread = null;
            for (MapleBBSThread mapleBBSThread2 : list) {
                if (!mapleBBSThread2.isNotice()) continue;
                mapleBBSThread = mapleBBSThread2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                break block5;
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.write(mapleBBSThread == null ? 0 : 1);
        if (mapleBBSThread != null) {
            MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, mapleBBSThread);
        }
        if (n3 < a3) {
            a3 = 0;
        }
        maplePacketLittleEndianWriter2.writeInt(n3);
        int n4 = Math.min(10, n3 - a3);
        maplePacketLittleEndianWriter2.writeInt(n4);
        int n5 = n2 = 0;
        while (n5 < n4) {
            int n6 = a3 + n2;
            MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a2.get(n6));
            n5 = ++n2;
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] treasure_Box(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.TREASURE_BOX.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showMonsterRiding(int a2, List<Pair<MapleBuffStat, Integer>> a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a3);
        maplePacketLittleEndianWriter2.writeShort(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter7.writeInt(a4);
        maplePacketLittleEndianWriter7.writeInt(a5);
        maplePacketLittleEndianWriter6.writeInt(0);
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 1 : 0);
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 4 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendPVPWindow() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.OPEN_UI.getValue());
        int n2 = 51;
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            n2 = 50;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeInt(n2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] serverNotice(String a2) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.UNK_0_MESSAGE.getValue(), 0, arrstring, false, null);
    }

    public static /* synthetic */ byte[] GMPoliceMessage(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MAPLE_ADMIN_MSG.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] moveFamiliar(int a2, Point a3, List<LifeMovementFragment> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.MOVE_FAMILIAR.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.writePos(a3);
        maplePacketLittleEndianWriter2.writeInt(0);
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter2, a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] cancelHoming() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CANCEL_BUFF.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            PacketHelper.writeSingleMask(maplePacketLittleEndianWriter3, MapleBuffStat.HOMING_BEACON);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeLong(MapleBuffStat.HOMING_BEACON.getValue());
            maplePacketLittleEndianWriter4.writeLong(0L);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] givePirate(List<Pair<MapleBuffStat, Integer>> a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        Iterator<Pair<MapleBuffStat, Integer>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        boolean bl = a4 == 5121009 || a4 == 15111005 || a4 % 10000 == 8006;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter3, a2);
        maplePacketLittleEndianWriter3.writeShort(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter2.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter2.writeShort(0);
        }
        Iterator<Pair<MapleBuffStat, Integer>> iterator2 = iterator = a2.iterator();
        while (iterator2.hasNext()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4;
            Pair<MapleBuffStat, Integer> pair = iterator.next();
            maplePacketLittleEndianWriter2.writeInt(pair.getRight());
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter5.writeLong(a4);
                maplePacketLittleEndianWriter5.writeZeroBytes(bl ? 6 : 1);
                maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            } else {
                maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.writeInt(a4);
                maplePacketLittleEndianWriter6.writeInt(0);
            }
            maplePacketLittleEndianWriter4.writeShort(a3);
            iterator2 = iterator;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter7;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter8.writeShort(0);
            maplePacketLittleEndianWriter8.writeShort(0);
            maplePacketLittleEndianWriter7.write(1);
            maplePacketLittleEndianWriter7.write(1);
        } else {
            maplePacketLittleEndianWriter2.writeShort(bl ? 600 : 0);
            if (!bl) {
                maplePacketLittleEndianWriter2.write(1);
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] report(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REPORT_RESPONSE.getValue());
        maplePacketLittleEndianWriter.write(n2);
        if (n2 == 2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.write(0);
            maplePacketLittleEndianWriter2.writeInt(1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignBuff(MapleCharacter a2, List<Pair<MapleBuffStat, Integer>> a3, MapleStatEffect a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        PacketHelper.addForeignBuffStatus(maplePacketLittleEndianWriter3, a3, a2, a4);
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.writeZeroBytes(20);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] triggerReactor(MapleReactor a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleReactor mapleReactor = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.REACTOR_HIT.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter.write(mapleReactor.getState());
        maplePacketLittleEndianWriter3.writePos(mapleReactor.getPosition());
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showSpecialEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] closeRangeAttack(MapleCharacter a2, int a3, int a4, AttackInfo a5, boolean a6, int a7, byte a8) {
        MapleCharacter mapleCharacter;
        SendPacketOpcode sendPacketOpcode;
        if (a6) {
            sendPacketOpcode = SendPacketOpcode.ENERGY_ATTACK;
            mapleCharacter = a2;
        } else {
            sendPacketOpcode = SendPacketOpcode.CLOSE_RANGE_ATTACK;
            mapleCharacter = a2;
        }
        return MaplePacketCreator.addAttackBody(sendPacketOpcode, mapleCharacter, a3, a4, a5, a7, a8, 0);
    }

    public static final /* synthetic */ byte[] showHpHealed(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(SpecialEffect.HEAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void getGuildInfo(MaplePacketLittleEndianWriter a2, MapleGuild a3) {
        MaplePacketCreator.getGuildInfo(a2, a3, null);
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, MapleGuildAlliance a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        maplePacketLittleEndianWriter.writeInt(a3.getId());
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3.getName());
        int n3 = n2 = 1;
        while (n3 <= 5) {
            a2.writeMapleAsciiString(a3.getRank(n2++));
            n3 = n2;
        }
        a2.write(a3.getNoGuilds());
        int n4 = n2 = 0;
        while (n4 < a3.getNoGuilds()) {
            a2.writeInt(a3.getGuildId(n2++));
            n4 = n2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MapleGuildAlliance mapleGuildAlliance = a3;
        maplePacketLittleEndianWriter2.writeInt(mapleGuildAlliance.getCapacity());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(mapleGuildAlliance.getNotice());
    }

    public static /* synthetic */ byte[] boatEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BOAT_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] petAutoMP(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PET_AUTO_MP.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] modifyInventory(boolean a2, ModifyInventory a3) {
        return MaplePacketCreator.modifyInventory(a2, Collections.singletonList(a3));
    }

    public static /* synthetic */ byte[] professionInfo(String a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PROFESSION_INFO.getValue());
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2.startsWith(MapleParty.ALLATORIxDEMO("I+@)")) || a2.startsWith(AbstractPlayerInteraction.ALLATORIxDEMO("o3f0")) ? 100 : a5);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] throwGrenade(int a2, Point a3, int a4, int a5, int a6, boolean a7, int a8) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        Point point = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.THROW_GRENADE.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(point.x);
        maplePacketLittleEndianWriter3.writeInt(point.y);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            maplePacketLittleEndianWriter.write(a7 ? 1 : 0);
            maplePacketLittleEndianWriter.writeInt(a8);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateInnerPotential(byte a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.ENABLE_INNER_ABILITY.getValue());
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter4.writeShort(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeShort(a4);
        maplePacketLittleEndianWriter2.writeShort(a5);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void writeBuffMask(MaplePacketLittleEndianWriter a2, Collection<MapleBuffStat> a3) {
        int[] arrn = new int[4];
        arrn[2] = -262144;
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            MapleBuffStat mapleBuffStat = (MapleBuffStat)a3.next();
            object = a3;
            int n2 = mapleBuffStat.getPosition();
            arrn[n2] = (int)((long)arrn[n2] | mapleBuffStat.getValue());
        }
        int n3 = a3 = 0;
        while (n3 < arrn.length) {
            a2.writeInt(arrn[a3++]);
            n3 = a3;
        }
    }

    public static /* synthetic */ byte[] sendAllianceInvite(String a2, MapleCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleCharacter mapleCharacter = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(3);
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getGuildId());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(mapleCharacter.getName());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPResult(List<Pair<Integer, MapleCharacter>> a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<Pair<Integer, MapleCharacter>> list = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_RESULT.getValue());
        maplePacketLittleEndianWriter.writeInt(list.size());
        for (Pair<Integer, MapleCharacter> pair : list) {
            maplePacketLittleEndianWriter.writeInt(((MapleCharacter)pair.right).getId());
            maplePacketLittleEndianWriter.writeMapleAsciiString(((MapleCharacter)pair.right).getName());
            maplePacketLittleEndianWriter.writeInt((Integer)pair.left);
            maplePacketLittleEndianWriter.writeShort(((MapleCharacter)pair.right).getTeam() + 1);
            maplePacketLittleEndianWriter.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION < 139) continue;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter2.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeInt(0);
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(a3);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter7.writeInt(0);
            maplePacketLittleEndianWriter7.writeInt(0);
            maplePacketLittleEndianWriter6.write(0);
            maplePacketLittleEndianWriter6.writeShort(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter8.write(a4);
        maplePacketLittleEndianWriter8.write(a5);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendPyramidResult(byte a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PYRAMID_RESULT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] itemMegaphone(String a2, boolean a3, int a4, IItem a5) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.ITEM_MESSAGE.getValue(), a4, arrstring, a3, a5);
    }

    public static /* synthetic */ byte[] confirmShopTransaction(MapleShopResponse a2, MapleShop a3, MapleClient a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CONFIRM_SHOP_TRANSACTION.getValue());
        int n2 = a2.getValue();
        if (GameSetConstants.MAPLE_VERSION >= 152 && n2 > 0) {
            ++n2;
        }
        maplePacketLittleEndianWriter2.write(n2);
        switch (6.K[a2.ordinal()]) {
            case 1: 
            case 2: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3;
                while (false) {
                }
                maplePacketLittleEndianWriter2.write(a5 >= 0 ? 1 : 0);
                if (a5 >= 0) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.writeShort(a5);
                    maplePacketLittleEndianWriter4.writeInt(0);
                } else {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter5;
                    maplePacketLittleEndianWriter5.write(0);
                }
                maplePacketLittleEndianWriter3.writeInt(0);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                break;
            }
            case 3: {
                if (GameSetConstants.MAPLE_VERSION >= 143) {
                    maplePacketLittleEndianWriter2.writeInt(0);
                }
                maplePacketLittleEndianWriter2.writeInt(a3.getNpcId());
                if (GameSetConstants.MAPLE_VERSION > 139) {
                    maplePacketLittleEndianWriter2.writeInt(GameConstants.getCurrentDate());
                }
                MaplePacketCreator.addShopInfo(maplePacketLittleEndianWriter2, a3, a4);
            }
            case 4: {
                maplePacketLittleEndianWriter2.write(0);
                maplePacketLittleEndianWriter2.write(0);
            }
            default: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getNPCTalkStyle(int a2, String a3, boolean a4, int ... a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter3.write(4);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a4 ? (byte)10 : (byte)MaplePacketOperation.NPCPacket.TalkStyle);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter.write(0);
        }
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter.write(a5.length);
        int n2 = a3 = 0;
        while (n2 < a5.length) {
            maplePacketLittleEndianWriter.writeInt(a5[a3++]);
            n2 = a3;
        }
        if (GameSetConstants.MAPLE_VERSION > 75) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showChair(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_CHAIR.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] familiarAttack(int a2, byte a32, List<Triple<Integer, Integer, List<Integer>>> a422) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Iterator iterator = a422;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.ATTACK_FAMILIAR.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(a32);
        maplePacketLittleEndianWriter.write(iterator.size());
        Iterator a32 = iterator.iterator();
        while (a32.hasNext()) {
            Triple a422 = (Triple)a32.next();
            maplePacketLittleEndianWriter.writeInt((Integer)a422.left);
            maplePacketLittleEndianWriter.write((Integer)a422.mid);
            maplePacketLittleEndianWriter.write(((List)a422.right).size());
            Iterator iterator2 = ((List)a422.right).iterator();
            while (iterator2.hasNext()) {
                int n2 = (Integer)a422.next();
                iterator2 = a422;
                maplePacketLittleEndianWriter.writeInt(n2);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] cancelChair(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CANCEL_CHAIR.getValue());
        if (a2 == -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.write(0);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.write(1);
            maplePacketLittleEndianWriter4.writeShort(a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showSpecialAttack(int a2, int a3, int a4, int a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_SPECIAL_ATTACK.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        maplePacketLittleEndianWriter2.writeInt(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showGuildInfo(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.GuildStatus.\u986f\u793a\u516c\u6703\u8cc7\u8a0a);
        if (a2 == null || a2.getMGC() == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.write(0);
            return maplePacketLittleEndianWriter3.getPacket();
        }
        MapleGuild mapleGuild = World.Guild.getGuild(a2.getGuildId());
        if (mapleGuild == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.write(0);
            return maplePacketLittleEndianWriter4.getPacket();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.write(1);
        MaplePacketCreator.getGuildInfo(maplePacketLittleEndianWriter5, mapleGuild, a2);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] rechargeCombo(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ARAN_COMBO_RECHARGE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] OnClaimSvrStatusChanged(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(3);
        if (SendPacketOpcode.REPORT_STATUS.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REPORT_STATUS.getValue());
        maplePacketLittleEndianWriter.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getGachaponMega(String a2, IItem a3, int a4, String a5) {
        if (GameSetConstants.MAPLE_VERSION < 134) {
            String[] arrstring = new String[1];
            arrstring[0] = a2;
            return MaplePacketCreator.ALLATORIxDEMO(SmegaType.GACH_MESSAGE.getValue(), a4, arrstring, false, a3, a5);
        }
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO(SmegaType.ITEM_MESSAGE.getValue(), a4, arrstring, false, a3, a5);
    }

    public static /* synthetic */ byte[] ultimateExplorer() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ULTIMATE_EXPLORER.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendErrorAnyWhereDoor() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ANYWHERE_DOOR_ERROR.getValue());
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] DrainSoul(MapleCharacter a2, int a3, List<Integer> a42, int a5, int a6, int a7, int a8, boolean a9) {
        int n2;
        int n3 = a9 ? 4 : 3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        boolean bl = a9;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
        maplePacketLittleEndianWriter.write(bl);
        if (bl) {
            maplePacketLittleEndianWriter.writeInt(a2.getId());
        }
        maplePacketLittleEndianWriter.writeInt(a9 ? a3 : a2.getId());
        int n4 = n3;
        maplePacketLittleEndianWriter.writeInt(n4);
        if (n4 > 0) {
            maplePacketLittleEndianWriter.write(1);
            if (n3 >= 2 && n3 <= 3) {
                Iterator<Integer> iterator;
                List<Integer> list = a42;
                maplePacketLittleEndianWriter.writeInt(list.size());
                Iterator<Integer> iterator2 = iterator = list.iterator();
                while (iterator2.hasNext()) {
                    int a42 = iterator.next();
                    iterator2 = iterator;
                    maplePacketLittleEndianWriter.writeInt(a42);
                }
            } else {
                maplePacketLittleEndianWriter.writeInt(a3);
            }
            maplePacketLittleEndianWriter.writeInt(a7);
        }
        int n5 = n2 = 0;
        while (n5 < (a9 ? 1 : a6)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.write(1);
            maplePacketLittleEndianWriter2.writeInt(a5 + n2);
            maplePacketLittleEndianWriter2.writeInt(a7 == 31221014 ? 3 : 1);
            maplePacketLittleEndianWriter.writeInt(a9 ? Randomizer.rand(32, 48) : Randomizer.rand(15, 32));
            maplePacketLittleEndianWriter.writeInt(a9 ? Randomizer.rand(3, 4) : Randomizer.rand(21, 48));
            maplePacketLittleEndianWriter.writeInt(a9 ? Randomizer.rand(0, 255) : Randomizer.rand(48, 80));
            maplePacketLittleEndianWriter.writeInt(a8);
            n5 = ++n2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] guildInvite(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u9080\u8acb);
        maplePacketLittleEndianWriter2.writeInt(a2.getGuildId());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MapleCharacter mapleCharacter = a2;
            maplePacketLittleEndianWriter.writeInt(mapleCharacter.getLevel());
            maplePacketLittleEndianWriter4.writeInt(mapleCharacter.getJob());
            maplePacketLittleEndianWriter4.writeInt(a2.getSubcategory());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showAnyWhereDoor(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ANYWHERE_DOOR.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void addRingInfo(MaplePacketLittleEndianWriter a2, List<MapleRing> a3) {
        a2.write(a3.size() > 0 ? 1 : 0);
        if (a3.size() > 0) {
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.writeInt(a3.size());
            }
            Object object = a3 = a3.iterator();
            while (object.hasNext()) {
                MapleRing mapleRing = (MapleRing)a3.next();
                object = a3;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                MapleRing mapleRing2 = mapleRing;
                a2.writeLong(mapleRing2.getRingId());
                maplePacketLittleEndianWriter.writeLong(mapleRing2.getPartnerRingId());
                maplePacketLittleEndianWriter.writeInt(mapleRing.getItemId());
            }
        }
    }

    public static /* synthetic */ byte[] getNPCTalk(int a2, byte a3, String a4, String a5, byte a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        if (a2 == 0) {
            a2 = 9010000;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter3.write(4);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            byte by = a6;
            maplePacketLittleEndianWriter.write(by);
            if ((by & 4) != 0) {
                maplePacketLittleEndianWriter.writeInt(a7);
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a4);
        maplePacketLittleEndianWriter4.write(HexTool.getByteArrayFromHexString(a5));
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] giveVolDAme(int a2, int a3, int a4, List<Pair<MapleBuffStat, Integer>> a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter6, a5);
        maplePacketLittleEndianWriter5.writeShort(a2);
        maplePacketLittleEndianWriter5.writeInt(a3);
        maplePacketLittleEndianWriter4.writeInt(a4);
        maplePacketLittleEndianWriter4.writeShort(0);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeZeroBytes(25);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showlevelRanks(int a2, List<MapleRanking.levelRankingInfo> a32) {
        Iterator<MapleRanking.levelRankingInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.levelRankingInfo> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.levelRankingInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.levelRankingInfo levelRankingInfo2 = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.levelRankingInfo levelRankingInfo3 = levelRankingInfo2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.levelRankingInfo levelRankingInfo4 = levelRankingInfo2;
            maplePacketLittleEndianWriter.writeMapleAsciiString(levelRankingInfo2.getName());
            maplePacketLittleEndianWriter.writeInt(levelRankingInfo4.getLevel());
            maplePacketLittleEndianWriter3.writeInt(levelRankingInfo4.getStr());
            maplePacketLittleEndianWriter3.writeInt(levelRankingInfo2.getDex());
            maplePacketLittleEndianWriter2.writeInt(levelRankingInfo3.getInt());
            maplePacketLittleEndianWriter2.writeInt(levelRankingInfo3.getLuk());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendJobup(boolean a2, int a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.JOB_UPDATE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a4);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] makeExtractor(int a2, String a3, Point a4, int a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        Point point = a4;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_EXTRACTOR.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter.writeInt(point.x);
        maplePacketLittleEndianWriter3.writeInt(point.y);
        maplePacketLittleEndianWriter3.writeShort(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        maplePacketLittleEndianWriter2.writeInt(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getStorageFull() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.OPEN_STORAGE.getValue());
        maplePacketLittleEndianWriter2.write(17);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showDirectionFacialExpression(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.DIRECTION_FACIAL_EXPRESSION.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] followRequest(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FOLLOW_REQUEST.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showOwnDiceEffect(int a2, int a3, int a4, int a5, int a6) {
        return MaplePacketCreator.showDiceEffect(-1, a2, a3, a4, a5, a6);
    }

    public static /* synthetic */ byte[] getAdviceTalk(String[] a2) {
        return MaplePacketCreator.OnScriptMessage(8, 0, -1, -1, (byte)1, 1, 0, a2, null, null, null);
    }

    public static /* synthetic */ byte[] showTraitGain(MapleTrait.MapleTraitType a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.TRAIT_GAIN.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeLong((int)a2.getStat().getValue());
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt((int)a2.getStat().getValue());
        }
        maplePacketLittleEndianWriter.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getRelogResponse() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(3);
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.RELOG_RESPONSE.getValue());
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnFamiliar(MonsterFamiliar a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_FAMILIAR.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getCharacterId());
        maplePacketLittleEndianWriter2.writeShort(a3 ? 1 : 0);
        maplePacketLittleEndianWriter.write(0);
        if (a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MonsterFamiliar monsterFamiliar = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MonsterFamiliar monsterFamiliar2 = a2;
            maplePacketLittleEndianWriter.writeInt(a2.getFamiliar());
            maplePacketLittleEndianWriter.writeInt(monsterFamiliar2.getFatigue());
            maplePacketLittleEndianWriter4.writeInt(monsterFamiliar2.getVitality() * 300);
            maplePacketLittleEndianWriter4.writeMapleAsciiString(a2.getName());
            maplePacketLittleEndianWriter.writePos(monsterFamiliar.getTruePosition());
            maplePacketLittleEndianWriter3.write(monsterFamiliar.getStance());
            maplePacketLittleEndianWriter3.writeShort(a2.getFh());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showPQRewardUI(int a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_PQ_REWARD.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        int n3 = n2 = 0;
        while (n3 < 6) {
            maplePacketLittleEndianWriter.write(0);
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getTradeStart(MapleClient a2, MapleTrade a3, byte a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        byte by = a4;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.VISIT.getValue() + 1);
        maplePacketLittleEndianWriter2.write(3);
        maplePacketLittleEndianWriter2.write(2);
        maplePacketLittleEndianWriter.write(by);
        if (by == 1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.write(0);
            PacketHelper.addCharLook(maplePacketLittleEndianWriter4, a3.getPartner().getChr(), false);
            maplePacketLittleEndianWriter4.writeMapleAsciiString(a3.getPartner().getChr().getName());
            if (GameSetConstants.MAPLE_VERSION > 113) {
                maplePacketLittleEndianWriter.writeShort(a3.getPartner().getChr().getJob());
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MapleClient mapleClient = a2;
        maplePacketLittleEndianWriter.write(a4);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter5, mapleClient.getPlayer(), false);
        maplePacketLittleEndianWriter5.writeMapleAsciiString(mapleClient.getPlayer().getName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.writeShort(a2.getPlayer().getJob());
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.write(255);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] sendEngagement(byte a2, int a3, MapleCharacter a4, MapleCharacter a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        byte by = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MARRIAGE_RESULT.getValue());
        maplePacketLittleEndianWriter2.write(by);
        switch (by) {
            case 11: 
            case 12: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                while (false) {
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.writeInt(0);
                maplePacketLittleEndianWriter6.writeInt(a4.getId());
                maplePacketLittleEndianWriter5.writeInt(a5.getId());
                maplePacketLittleEndianWriter5.writeShort(1);
                maplePacketLittleEndianWriter4.writeInt(a3);
                maplePacketLittleEndianWriter4.writeInt(a3);
                maplePacketLittleEndianWriter3.writeAsciiString(a4.getName(), GameSetConstants.WRITE_STRING_LENGTH);
                maplePacketLittleEndianWriter3.writeAsciiString(a5.getName(), GameSetConstants.WRITE_STRING_LENGTH);
                break;
            }
            case 15: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter7.writeAsciiString(a4.getName(), GameSetConstants.WRITE_STRING_LENGTH);
                maplePacketLittleEndianWriter7.writeAsciiString(a5.getName(), GameSetConstants.WRITE_STRING_LENGTH);
                maplePacketLittleEndianWriter2.writeShort(0);
            }
            default: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getHeartSmega(String a2, boolean a3, int a4) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.LOVE_MESSAGE.getValue(), a4, arrstring, a3, null);
    }

    public static /* synthetic */ byte[] sendEngagementRequest(String a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MARRIAGE_REQUEST.getValue());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void addShopItemInfo(MaplePacketLittleEndianWriter a, MapleShopItem a, MapleShop a, MapleItemInformationProvider a, IItem a, MapleCharacter a) {
        v0 = a;
        v0.writeInt(a.getItemId());
        v0.writeInt(a.getPrice());
        if (GameSetConstants.MAPLE_VERSION <= 113) ** GOTO lbl39
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a.write(0);
        }
        v1 = a;
        v2 = a;
        v1.writeInt(v2.getReqItem());
        v1.writeInt(v2.getReqItemQ());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            v3 = a;
            v4 = a;
            a.writeInt(v4.getReqItem2());
            v3.writeInt(v4.getReqItemQ2());
            v3.writeInt(a.getExpiration());
            if (GameSetConstants.MAPLE_VERSION > 139) {
                a.writeInt(a.getMinLevel());
                if (GameSetConstants.MAPLE_VERSION > 148) {
                    a.writeInt(0);
                }
                if (GameSetConstants.MAPLE_VERSION >= 152) {
                    v5 = a;
                    v5.writeLong(PacketHelper.getTime(-2L));
                    v5.writeLong(PacketHelper.getTime(-1L));
                }
                v6 = a;
                v6.writeInt(a.getCategory());
                v6.writeMapleAsciiString(MapleParty.ALLATORIxDEMO("A @)@(@(@)"));
                a.writeMapleAsciiString(AbstractPlayerInteraction.ALLATORIxDEMO("d1a8f0f0f1"));
            }
            a.write(a.hasPotential() != false ? 1 : 0);
            v7 = a;
            v8 = v7;
            a.writeInt(v7.getBuyTimesLimit());
        } else if (GameSetConstants.MAPLE_VERSION >= 134) {
            v8 = a;
            a.writeLong(0L);
        } else {
            a.writeInt(0);
lbl39:
            // 2 sources

            v8 = a;
        }
        if (!GameConstants.isThrowingStar(v8.getItemId()) && !GameConstants.isBullet(a.getItemId())) {
            v9 = a;
            v9.writeShort(1);
            v9.writeShort(a.getBuyable());
        } else {
            var6_6 = a.getSlotMax(a.getItemId());
            var7_8 = SkillConstants.getMasterySkill(a);
            if (var7_8 != 0) {
                var6_6 += a.getSkillLevel(SkillFactory.getSkill(var7_8)) * 10;
            }
            a.writeLong(Double.doubleToLongBits(Math.max(a.getPrice(a.getItemId()), 0.0)));
            a.writeShort(var6_6);
        }
        if (GameSetConstants.MAPLE_VERSION < 139) return;
        a.write(a == null ? 0 : 1);
        if (a != null) {
            PacketHelper.addItemInfo(a, a);
        }
        if (a.getRanks().size() > 0) {
            a.write(a.getRank() >= 0 ? 1 : 0);
            if (a.getRank() >= 0) {
                a.write(a.getRank());
            }
        }
        if (GameSetConstants.MAPLE_VERSION < 147) return;
        v10 = new int[4];
        v10[0] = 9410165;
        v10[1] = 9410166;
        v10[2] = 9410167;
        v10[3] = 9410168;
        var6_7 = v10;
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            v11 = new int[5];
            v11[0] = 9410165;
            v11[1] = 9410166;
            v11[2] = 9410167;
            v11[3] = 9410168;
            v11[4] = 9410198;
            var6_7 = v11;
        }
        v12 = var7_8 = 0;
        while (v12 < 4) {
            if (a.getFriends() > 0) {
                a.writeInt(a.getFriendPoints() - a.getFriendShipPoints()[var7_8] > 0 ? 1 : 0);
            } else {
                a.writeInt(0);
            }
            v12 = ++var7_8;
        }
        v13 = var7_8 = 0;
        while (v13 < var6_7.length) {
            v14 = a;
            v14.writeInt(a.getFriends());
            v14.writeInt(a.getFriendPoints() - a.getFriendShipPoints()[var7_8++]);
            v13 = var7_8;
        }
    }

    public static /* synthetic */ byte[] getOwlSearchedAcquisition(int a2, List<HiredMerchant> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOP_SCANNER_RESULT.getValue());
        int n2 = 6;
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            n2 = 8;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.write(n2);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter.writeInt(a2);
        TreeMap<MaplePlayerShopItem, HiredMerchant> treeMap = new TreeMap<MaplePlayerShopItem, HiredMerchant>(new Comparator<MaplePlayerShopItem>(){

            @Override
            public /* synthetic */ int compare(MaplePlayerShopItem a2, MaplePlayerShopItem a32) {
                int a32 = a2.price;
                int n2 = a32.price;
                if (a32 < n2) {
                    return -1;
                }
                if (a32 == n2) {
                    return 0;
                }
                return 1;
            }
            {
                5 a2;
            }
        });
        a3 = a3.iterator();
        while (a3.hasNext()) {
            HiredMerchant object = (HiredMerchant)((Object)a3.next());
            Iterator<MaplePlayerShopItem> iterator = object.searchItem(a2).iterator();
            while (iterator.hasNext()) {
                Iterator<MaplePlayerShopItem> iterator2;
                MaplePlayerShopItem maplePlayerShopItem = iterator2.next();
                iterator = iterator2;
                treeMap.put(maplePlayerShopItem, object);
            }
        }
        maplePacketLittleEndianWriter.writeInt(treeMap.size());
        for (Map.Entry entry : treeMap.entrySet()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter.writeMapleAsciiString(((HiredMerchant)entry.getValue()).getOwnerName());
            maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getMap().getId());
            maplePacketLittleEndianWriter.writeMapleAsciiString(((HiredMerchant)entry.getValue()).getDescription());
            maplePacketLittleEndianWriter.writeInt(((MaplePlayerShopItem)entry.getKey()).item.getQuantity());
            maplePacketLittleEndianWriter.writeInt(((MaplePlayerShopItem)entry.getKey()).bundles);
            maplePacketLittleEndianWriter.writeInt((int)((long)((MaplePlayerShopItem)entry.getKey()).price >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (long)((MaplePlayerShopItem)entry.getKey()).price));
            switch (2) {
                case 0: {
                    while (false) {
                    }
                    maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getOwnerId());
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                    break;
                }
                case 1: {
                    maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getStoreId());
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                    break;
                }
                default: {
                    maplePacketLittleEndianWriter.writeInt(((HiredMerchant)entry.getValue()).getObjectId());
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                }
            }
            maplePacketLittleEndianWriter3.write(((HiredMerchant)entry.getValue()).getMap().getChannel() - 1);
            int n3 = a2;
            maplePacketLittleEndianWriter.write(GameConstants.getInventoryType(n3).getType());
            if (GameConstants.getInventoryType(n3) != MapleInventoryType.EQUIP) continue;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, ((MaplePlayerShopItem)entry.getKey()).item);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendPyramidUpdate(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PYRAMID_UPDATE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnAndroid(MapleCharacter a2, MapleAndroid a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleAndroid mapleAndroid = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ANDROID_SPAWN.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getId());
        maplePacketLittleEndianWriter4.write(a3.getType());
        maplePacketLittleEndianWriter.writeShort(mapleAndroid.getPos().x);
        maplePacketLittleEndianWriter3.writeShort(mapleAndroid.getPos().y - 10);
        maplePacketLittleEndianWriter3.write(a3.getStance());
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.writeShort(a3.getSkin() >= 2000 ? a3.getSkin() - 2000 : a3.getSkin());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(a3.getHair() - 30000);
        maplePacketLittleEndianWriter5.writeShort(a3.getFace() - 20000);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a3.getName());
        }
        short s2 = a3 = -1200;
        while (s2 > -1207) {
            IItem iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem(a3);
            maplePacketLittleEndianWriter.writeInt(iItem != null ? iItem.getItemId() : 0);
            s2 = (short)(a3 - 1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showMagnifyingGlass(int a2, short a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_MAGNIFY_GLASS.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeShort(a3);
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateGP(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(72);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] updateInfoQuest(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(StatusInfoType.UPDATE_INFO_QUEST.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateSpecialStat(String a2, int a3, int a4, boolean a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.RESULT_INSTANCE_TABLE.getValue());
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(a6);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] disbandSidekick(MapleSidekick a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SIDEKICK_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(75);
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.writeInt(a2.getCharacter(0).getId());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(a2.getCharacter(1).getId());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getChannelChange(byte[] a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CHANGE_CHANNEL.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeShort(a3);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendProfessionWindow(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.OPEN_UI_OPTION.getValue());
        int n2 = 44;
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            n2 = 42;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeInt(n2);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateAzwanFame(int a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_HONOUR.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] itemEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_ITEM_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] yellowChat(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.YELLOW_CHAT.getValue());
        maplePacketLittleEndianWriter2.write(-1);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ byte[] ALLATORIxDEMO(int a2, int a3, String[] a4, boolean a5, IItem a6, String a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        block24: {
            block23: {
                maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
                int n3 = a2;
                maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SERVERMESSAGE.getValue());
                maplePacketLittleEndianWriter2.write(n3);
                if (n3 == SmegaType.SCROLL_MESSAGE.getValue()) {
                    maplePacketLittleEndianWriter2.write(a5);
                }
                if (a2 == SmegaType.SCROLL_MESSAGE.getValue() && !a5) break block23;
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a4 == null || a4.length < 1 ? "" : a4[0]);
                SmegaType smegaType = SmegaType.getSmegaType(a2);
                switch (6.k[smegaType.ordinal()]) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: {
                        maplePacketLittleEndianWriter2.write(a3 - 1);
                        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
                        n2 = a2;
                        break block24;
                    }
                    case 6: {
                        maplePacketLittleEndianWriter2.write(a3 - 1);
                        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
                        maplePacketLittleEndianWriter2.write(a6 != null);
                        if (a6 == null) break;
                        n2 = a2;
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, a6);
                        break block24;
                    }
                    case 7: {
                        maplePacketLittleEndianWriter2.write(a3 - 1);
                        n2 = a2;
                        break block24;
                    }
                    case 8: {
                        int n4;
                        int n5 = n4 = a4 == null ? 0 : a4.length;
                        maplePacketLittleEndianWriter2.write(n5);
                        if (n5 > 1) {
                            maplePacketLittleEndianWriter2.writeMapleAsciiString(a4 == null || a4.length < 2 ? "" : a4[1]);
                        }
                        if (n4 > 2) {
                            maplePacketLittleEndianWriter2.writeMapleAsciiString(a4 == null || a4.length < 3 ? "" : a4[2]);
                        }
                        maplePacketLittleEndianWriter2.write(a3 - 1);
                        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
                        n2 = a2;
                        break block24;
                    }
                    case 9: {
                        maplePacketLittleEndianWriter2.writeInt(a3 - 1);
                        n2 = a2;
                        break block24;
                    }
                    case 10: 
                    case 11: {
                        if (a6 == null) return new MaplePacketLittleEndianWriter().getPacket();
                        maplePacketLittleEndianWriter2.writeInt(a3 - 1);
                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                            maplePacketLittleEndianWriter2.writeMapleAsciiString(a7);
                        }
                        PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, a6);
                        n2 = a2;
                        break block24;
                    }
                }
            }
            n2 = a2;
        }
        switch (n2) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                break;
            }
            case 13: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                maplePacketLittleEndianWriter2.writeInt(a3 >= 1000000 && a3 < 6000000 ? a3 : 0);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 7: {
                maplePacketLittleEndianWriter2.writeInt(-1);
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getSilentCrusadeMsg(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SILENT_CRUSADE_SHOP.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] NPCSpecialAction(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.NPC_SCRIPTABLEUP.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(a4);
        maplePacketLittleEndianWriter.writeInt(a5);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showForeignQuestFinishEffect(int a2) {
        return MaplePacketCreator.showSpecialEffect(a2, SpecialEffect.QUEST_COMPLETE.getValue());
    }

    public static /* synthetic */ byte[] updateAlliance(MapleGuildCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleGuildCharacter mapleGuildCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(24);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a2.getGuildId());
        maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter.getId());
        maplePacketLittleEndianWriter2.writeInt(mapleGuildCharacter.getLevel());
        maplePacketLittleEndianWriter2.writeInt(a2.getJobId());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBuffEffect(int a2, int a3, int a4, int a5, int a6) {
        return MaplePacketCreator.showBuffEffect(a2, a3, a4, a5, a6, (byte)3);
    }

    public static final /* synthetic */ byte[] updateQuest(MapleQuestStatus a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        MapleQuestStatus mapleQuestStatus = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(StatusInfoType.UPDATE_QUEST.getValue());
        maplePacketLittleEndianWriter3.writeShort(a2.getQuest().getId());
        maplePacketLittleEndianWriter2.write(mapleQuestStatus.getStatus());
        switch (mapleQuestStatus.getStatus()) {
            case 0: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                while (false) {
                }
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeZeroBytes(10);
                break;
            }
            case 1: {
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getCustomData() != null ? a2.getCustomData() : "");
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                break;
            }
            case 2: {
                if (GameSetConstants.MAPLE_VERSION >= 134 && GameSetConstants.MAPLE_VERSION < 139) {
                    maplePacketLittleEndianWriter2.writeShort(0);
                }
                maplePacketLittleEndianWriter2.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
            }
            default: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getNodeProperties(MapleMonster a2, MapleMap a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        if (a2.getNodePacket() != null) {
            return a2.getNodePacket();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MONSTER_PROPERTIES.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter3.writeInt(((MapleMap)a3).getNodes().size());
        maplePacketLittleEndianWriter2.writeInt(a2.getPosition().x);
        maplePacketLittleEndianWriter2.writeInt(a2.getPosition().y);
        a3 = ((MapleMap)a3).getNodes().iterator();
        while (a3.hasNext()) {
            MapleNodes.MapleNodeInfo mapleNodeInfo;
            MapleNodes.MapleNodeInfo mapleNodeInfo2 = mapleNodeInfo = (MapleNodes.MapleNodeInfo)a3.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(mapleNodeInfo.x);
            maplePacketLittleEndianWriter4.writeInt(mapleNodeInfo.y);
            maplePacketLittleEndianWriter.writeInt(mapleNodeInfo2.attr);
            if (mapleNodeInfo2.attr != 2) continue;
            maplePacketLittleEndianWriter.writeInt(500);
        }
        maplePacketLittleEndianWriter.writeZeroBytes(6);
        MapleMonster mapleMonster = a2;
        mapleMonster.setNodePacket(maplePacketLittleEndianWriter.getPacket());
        return mapleMonster.getNodePacket();
    }

    public static /* synthetic */ byte[] getPopupMsg(String a2) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.POP_MESSAGE.getValue(), 0, arrstring, false, null);
    }

    public static final /* synthetic */ byte[] spawnDoor(int a2, Point a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPAWN_DOOR.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writePos(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] getCakeSmega(String a2, boolean a3, int a4) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.CAKES_MESSAGE.getValue(), a4, arrstring, a3, null);
    }

    public static /* synthetic */ byte[] cancelSoulEffect() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CANCEL_BUFF.getValue());
        PacketHelper.writeBuffState(maplePacketLittleEndianWriter, MapleBuffStat.SOUL_SKILL);
        return maplePacketLittleEndianWriter.getPacket();
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, MapleCharacter a3) {
        MaplePacketCreator.ALLATORIxDEMO(a2, null, a3);
    }

    public static /* synthetic */ byte[] snowballMessage(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SNOWBALL_MESSAGE.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showSoulWeapon(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        HashMap<MapleBuffStat, Integer> hashMap = new HashMap<MapleBuffStat, Integer>();
        hashMap.put(MapleBuffStat.SOUL_WEAPON, 0);
        if (a2 > 0) {
            hashMap.put(MapleBuffStat.INDIE_MAD, 0);
            hashMap.put(MapleBuffStat.INDIE_PAD, 0);
        }
        PacketHelper.writeBuffMask(maplePacketLittleEndianWriter2, hashMap);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(a3);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeShort(a3);
        }
        maplePacketLittleEndianWriter.writeInt(a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter7.writeInt(0);
        maplePacketLittleEndianWriter7.writeShort(1000);
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter6.writeLong(a2);
        maplePacketLittleEndianWriter5.writeShort(0);
        maplePacketLittleEndianWriter5.writeZeroBytes(3);
        if (a2 > 0) {
            int n2 = a3 = 0;
            while (n2 < 2) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter9.writeInt(1);
                maplePacketLittleEndianWriter9.writeInt(2590000);
                maplePacketLittleEndianWriter8.writeZeroBytes(13);
                maplePacketLittleEndianWriter8.write(HexTool.getByteArrayFromHexString(AbstractPlayerInteraction.ALLATORIxDEMO("a4v3\u0014!aE")));
                n2 = ++a3;
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter10.write(HexTool.getByteArrayFromHexString(MapleParty.ALLATORIxDEMO("@)P)@9@)P)@9@(P)@9@)P)@9@)")));
        return maplePacketLittleEndianWriter10.getPacket();
    }

    public static /* synthetic */ byte[] showFreeMarketDisplay(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (SendPacketOpcode.DISPLAY_INFO.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.DISPLAY_INFO.getValue());
        maplePacketLittleEndianWriter.write(a2);
        if (a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(30000);
            maplePacketLittleEndianWriter3.writeInt(20000);
            maplePacketLittleEndianWriter2.writeInt(-1);
            int n2 = 0;
            maplePacketLittleEndianWriter2.writeInt(0);
            int n3 = n2 = 0;
            while (n3 < 0) {
                maplePacketLittleEndianWriter.writeInt(10000000);
                n3 = ++n2;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeInt(30000);
            maplePacketLittleEndianWriter4.writeInt(21000);
            maplePacketLittleEndianWriter4.writeInt(-1);
            n2 = 0;
            maplePacketLittleEndianWriter.writeInt(0);
            int n4 = n2 = 0;
            while (n4 < 0) {
                maplePacketLittleEndianWriter.writeInt(10000000);
                n4 = ++n2;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeInt(-1);
            maplePacketLittleEndianWriter5.writeInt(-1);
            maplePacketLittleEndianWriter5.writeInt(-1);
            n2 = 0;
            maplePacketLittleEndianWriter.writeInt(0);
            int n5 = n2 = 0;
            while (n5 < 0) {
                maplePacketLittleEndianWriter.writeInt(10000000);
                n5 = ++n2;
            }
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                n2 = 0;
                maplePacketLittleEndianWriter.writeInt(0);
                int n6 = n2 = 0;
                while (n6 < 0) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter.writeInt(0);
                    maplePacketLittleEndianWriter6.writeMapleAsciiString("");
                    maplePacketLittleEndianWriter6.writeMapleAsciiString("");
                    n6 = ++n2;
                }
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] startMapEffect(String a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MAP_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 0 : 1);
        maplePacketLittleEndianWriter.writeInt(a3);
        if (a4) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMagnifyingGlass(int a2, short a3) {
        return MaplePacketCreator.showMagnifyingGlass(a2, a3, false);
    }

    public static /* synthetic */ byte[] openBag(int a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.OPEN_BAG.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeShort(a4 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showfameRanks(int a2, List<MapleRanking.fameRankingInfo> a32) {
        Iterator<MapleRanking.fameRankingInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.fameRankingInfo> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.fameRankingInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.fameRankingInfo fameRankingInfo2 = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.fameRankingInfo fameRankingInfo3 = fameRankingInfo2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.fameRankingInfo fameRankingInfo4 = fameRankingInfo2;
            maplePacketLittleEndianWriter.writeMapleAsciiString(fameRankingInfo2.getName());
            maplePacketLittleEndianWriter.writeInt(fameRankingInfo4.getFame());
            maplePacketLittleEndianWriter3.writeInt(fameRankingInfo4.getStr());
            maplePacketLittleEndianWriter3.writeInt(fameRankingInfo2.getDex());
            maplePacketLittleEndianWriter2.writeInt(fameRankingInfo3.getInt());
            maplePacketLittleEndianWriter2.writeInt(fameRankingInfo3.getLuk());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] giveFameResponse(int a2, String a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.FAME_RESPONSE.getValue());
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter3.write(a2);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.writeInt(a4);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
            maplePacketLittleEndianWriter6.writeShort(a4);
        }
        maplePacketLittleEndianWriter.writeShort(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showStorageRanks(int a2, List<MapleRanking.StorageRank> a32, MapleStorageType a4) {
        Object object;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List list = new LinkedList<MapleRanking.StorageRank>();
        a32 = a32.iterator();
        while (a32.hasNext()) {
            object = (MapleRanking.StorageRank)a32.next();
            if (((MapleRanking.StorageRank)object).getType() != a4) continue;
            list.add(object);
        }
        LinkedList<MapleRanking.StorageRank> linkedList = list;
        Collections.sort(linkedList, new Comparator<MapleRanking.StorageRank>(){
            {
                2 a2;
            }

            @Override
            public /* synthetic */ int compare(MapleRanking.StorageRank a2, MapleRanking.StorageRank a32) {
                int n2;
                int a32 = a2.getCount();
                if (a32 < (n2 = a32.getCount())) {
                    return 1;
                }
                if (a32 == n2) {
                    return 0;
                }
                return -1;
            }
        });
        if (linkedList.size() > 20) {
            list = list.subList(0, 50);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List list2 = list;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list2.size());
        int a32 = 1;
        Object object2 = object = list2.iterator();
        while (object2.hasNext()) {
            a4 = (MapleRanking.StorageRank)object.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            Object object3 = a4;
            maplePacketLittleEndianWriter.writeMapleAsciiString(((MapleRanking.StorageRank)object3).getName());
            maplePacketLittleEndianWriter4.writeInt(((MapleRanking.StorageRank)object3).getCount());
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            object2 = object;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateQuestFinish(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_QUEST_INFO.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 123) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.write(10);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(8);
        }
        maplePacketLittleEndianWriter.writeShort(a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.writeInt(a3);
        maplePacketLittleEndianWriter5.writeInt(a4);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] gainForce(boolean a2, MapleCharacter a3, List<Integer> a4, int a5, int a6, int a7) {
        return MaplePacketCreator.gainForce(a2, a3, a4, a5, a6, a7, -1, null);
    }

    public static /* synthetic */ byte[] useSkillBook(MapleCharacter a2, int a3, int a4, boolean a5, boolean a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.USE_SKILL_BOOK.getValue());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.write(1);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter.write(a5 ? 1 : 0);
        maplePacketLittleEndianWriter.write(a6 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showItemLevelupEffect() {
        return MaplePacketCreator.showSpecialEffect(SpecialEffect.ITEM_LEVEL_UP.getValue());
    }

    public static /* synthetic */ byte[] showRewardItemAnimation(int a2, String a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter3.write(SpecialEffect.LOTTERY_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3 != null && a3.length() > 0 ? 1 : 0);
        if (a3 != null && a3.length() > 0) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendRemoteQuest(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.QUEST_HELPER.getValue());
        Object object = a2.getStartedQuests();
        maplePacketLittleEndianWriter2.writeInt(object.size());
        Object object2 = object = object.iterator();
        while (object2.hasNext()) {
            MapleQuestStatus mapleQuestStatus = (MapleQuestStatus)object.next();
            object2 = object;
            maplePacketLittleEndianWriter.writeInt(mapleQuestStatus.getQuest().getId());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getPVPClock(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CLOCK.getValue());
        maplePacketLittleEndianWriter3.write(3);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removeMessengerPlayer(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter2.write(2);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showSpecialSkillEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (a2 == -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
            maplePacketLittleEndianWriter4.writeInt(a2);
        }
        maplePacketLittleEndianWriter.write(SpecialEffect.SPECIAL_SKILL.getValue());
        int n2 = a3;
        maplePacketLittleEndianWriter2.writeInt(n2);
        if (n2 == 4341003) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] itemMegaphone(String a2, IItem a3, int a4) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.ITEM_MESSAGE.getValue(), a4, arrstring, true, a3);
    }

    public static /* synthetic */ byte[] changeAllianceLeader(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(2);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] teslaTriangle(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.TESLA_TRIANGLE.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getTripleSmega(List<String> a2, boolean a3, int a4) {
        List<String> list = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.TRIPLE_MEESAGE.getValue(), a4, list.toArray(new String[list.size()]), a3, null);
    }

    public static /* synthetic */ byte[] facialExpression(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FACIAL_EXPRESSION.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        maplePacketLittleEndianWriter2.writeInt(a3);
        if (GameSetConstants.MAPLE_VERSION > 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(-1);
            maplePacketLittleEndianWriter3.write(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] mesoStorage(byte a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.OPEN_STORAGE.getValue());
        int n2 = 19;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 = 18;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.write(n2);
        maplePacketLittleEndianWriter4.write(a2);
        maplePacketLittleEndianWriter3.writeShort(2);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showEquipEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_EQUIP_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] rankTitleChange(int a2, String[] a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u6a19\u984c\u66f4\u63db);
        maplePacketLittleEndianWriter2.writeInt(a2);
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = a3[n2];
            maplePacketLittleEndianWriter.writeMapleAsciiString(string);
            n4 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showmesoRanks(int a2, List<MapleRanking.mesoRankingInfo> a32) {
        Iterator<MapleRanking.mesoRankingInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.mesoRankingInfo> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.mesoRankingInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.mesoRankingInfo mesoRankingInfo2 = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.mesoRankingInfo mesoRankingInfo3 = mesoRankingInfo2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.mesoRankingInfo mesoRankingInfo4 = mesoRankingInfo2;
            maplePacketLittleEndianWriter.writeMapleAsciiString(mesoRankingInfo2.getName());
            maplePacketLittleEndianWriter.writeInt(Long.valueOf(mesoRankingInfo4.getMeso()).intValue());
            maplePacketLittleEndianWriter3.writeInt(mesoRankingInfo4.getStr());
            maplePacketLittleEndianWriter3.writeInt(mesoRankingInfo2.getDex());
            maplePacketLittleEndianWriter2.writeInt(mesoRankingInfo3.getInt());
            maplePacketLittleEndianWriter2.writeInt(mesoRankingInfo3.getLuk());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] ItemMaker_Success_3rdParty(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(SpecialEffect.ITEM_MAKER_SUCCESS.getValue());
        maplePacketLittleEndianWriter2.writeZeroBytes(4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] mountInfo(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleCharacter mapleCharacter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_MOUNT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getMount().getLevel());
        maplePacketLittleEndianWriter2.writeInt(mapleCharacter.getMount().getExp());
        maplePacketLittleEndianWriter2.writeInt(a2.getMount().getFatigue());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateCharLook(MapleCharacter a2, boolean a32) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.UPDATE_CHAR_LOOK.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.write(1);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter2, a2, false, a32);
        Triple<List<MapleRing>, List<MapleRing>, List<MapleRing>> a32 = a2.getRingsTriple(false);
        MaplePacketCreator.addRingInfo(maplePacketLittleEndianWriter2, a32.getLeft());
        MaplePacketCreator.addRingInfo(maplePacketLittleEndianWriter, a32.getMid());
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter, a32.getRight(), a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(0);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ {
        EMPTY_STATUPDATE = Collections.emptyList();
    }

    public static /* synthetic */ byte[] removeMapEffect() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MAP_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnDragon(MapleDragon a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleDragon mapleDragon = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.DRAGON_SPAWN.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getOwner());
        maplePacketLittleEndianWriter.writeInt(mapleDragon.getPosition().x);
        maplePacketLittleEndianWriter3.writeInt(mapleDragon.getPosition().y);
        maplePacketLittleEndianWriter3.write(a2.getStance());
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.writeShort(a2.getJobId());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getInventoryStatus() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] LieDetectorResponse(byte a2) {
        return MaplePacketCreator.LieDetectorResponse(a2, (byte)0);
    }

    public static /* synthetic */ byte[] sendDamage(int a2) {
        return MaplePacketCreator.sendDamage(a2, false);
    }

    public static /* synthetic */ byte[] updateAndroidLook(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ANDROID_UPDATE.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.write(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendLieDetector(byte[] a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LIE_DETECTOR.getValue());
        maplePacketLittleEndianWriter2.write(6);
        maplePacketLittleEndianWriter.write(4);
        maplePacketLittleEndianWriter.write(1);
        if (a2 == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a3;
            maplePacketLittleEndianWriter3.writeInt(0);
            return maplePacketLittleEndianWriter3.getPacket();
        }
        a3.writeInt(a2.length);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a3;
        maplePacketLittleEndianWriter4.write(a2);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] createGuildAlliance(MapleGuildAlliance a2) {
        int n2;
        int n3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleGuildAlliance mapleGuildAlliance = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(15);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter, mapleGuildAlliance);
        MapleGuild[] arrmapleGuild = new MapleGuild[mapleGuildAlliance.getNoGuilds()];
        int n4 = n3 = 0;
        while (n4 < a2.getNoGuilds()) {
            int n5 = n3;
            arrmapleGuild[n5] = World.Guild.getGuild(a2.getGuildId(n5));
            if (arrmapleGuild[n3] == null) {
                return MaplePacketCreator.enableActions();
            }
            n4 = ++n3;
        }
        MapleGuild[] arrmapleGuild2 = arrmapleGuild;
        int n6 = arrmapleGuild.length;
        int n7 = n2 = 0;
        while (n7 < n6) {
            MapleGuild mapleGuild = arrmapleGuild2[n2];
            MaplePacketCreator.getGuildInfo(maplePacketLittleEndianWriter, mapleGuild);
            n7 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] cancelForeignDebuff(int a2, MapleBuffStat a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CANCEL_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        PacketHelper.writeSingleMask(maplePacketLittleEndianWriter2, a3);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.write(3);
            maplePacketLittleEndianWriter3.write(1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] guildEmblemChange(int a2, short a3, byte a4, short a5, byte a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u5fbd\u7ae0\u66f4\u6539);
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter2.writeShort(a5);
        maplePacketLittleEndianWriter2.write(a6);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] showMesoGain(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        if (!a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter3.write(StatusInfoType.SHOW_INVENTORY_GAIN.getValue());
            maplePacketLittleEndianWriter3.write(1);
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                maplePacketLittleEndianWriter2.write(0);
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeInt(a2);
            maplePacketLittleEndianWriter4.writeShort(0);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.write(StatusInfoType.SHOW_INVENTORY_GAIN_INCHAT.getValue());
            maplePacketLittleEndianWriter5.writeInt(a2);
            maplePacketLittleEndianWriter5.writeInt(-1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] requestBuddylistAdd(int a2, String a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.BUDDYLIST.getValue());
        maplePacketLittleEndianWriter3.write(9);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        if (GameSetConstants.MAPLE_VERSION > 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(a4);
            maplePacketLittleEndianWriter4.writeInt(a5);
            if (GameSetConstants.MAPLE_VERSION > 147) {
                maplePacketLittleEndianWriter.writeInt(a6);
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeInt(a2);
        maplePacketLittleEndianWriter6.writeAsciiString(a3, GameSetConstants.WRITE_STRING_LENGTH);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter5.writeInt(0);
        maplePacketLittleEndianWriter.writeAsciiString("\u5c1a\u672a\u8a2d\u5b9a\u7fa4\u7d44", 16);
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            maplePacketLittleEndianWriter.writeAsciiString("\u5c1a\u672a\u8a2d\u5b9a\u7fa4\u7d44", 16);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter7.writeShort(0);
        return maplePacketLittleEndianWriter7.getPacket();
    }

    public static /* synthetic */ byte[] showdonateRanks(int a2, List<MapleRanking.donateRankingInfo> a32) {
        Iterator<MapleRanking.donateRankingInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.donateRankingInfo> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.donateRankingInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.donateRankingInfo donateRankingInfo2 = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MapleRanking.donateRankingInfo donateRankingInfo3 = donateRankingInfo2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.donateRankingInfo donateRankingInfo4 = donateRankingInfo2;
            maplePacketLittleEndianWriter.writeMapleAsciiString(donateRankingInfo2.getName());
            maplePacketLittleEndianWriter.writeInt(donateRankingInfo4.getdonate());
            maplePacketLittleEndianWriter3.writeInt(donateRankingInfo4.getStr());
            maplePacketLittleEndianWriter3.writeInt(donateRankingInfo2.getDex());
            maplePacketLittleEndianWriter2.writeInt(donateRankingInfo3.getInt());
            maplePacketLittleEndianWriter2.writeInt(donateRankingInfo3.getLuk());
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateFriendPoints(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_FRINED_POINTS.getValue());
        PacketHelper.addRedLeafInfo(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] serverNotice(int a2, String a3) {
        String[] arrstring = new String[1];
        arrstring[0] = a3;
        return MaplePacketCreator.ALLATORIxDEMO(a2, 0, arrstring, false, null);
    }

    public static /* synthetic */ byte[] getPeanutResult(int a2, short a3, int a4, short a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PIGMI_REWARD.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter3.writeInt(5060003);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateAriantPQRanking(String a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ARIANT_SCORE_UPDATE.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 0 : 1);
        if (!a4) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
            maplePacketLittleEndianWriter3.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateAllianceLeader(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(25);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] enterSnowBall() {
        return MaplePacketCreator.rollSnowball(0, null, null);
    }

    public static /* synthetic */ byte[] spawnMechDoor(MechDoor a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MECH_DOOR_SPAWN.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MechDoor mechDoor = a2;
        maplePacketLittleEndianWriter.writeInt(a2.getOwnerId());
        maplePacketLittleEndianWriter.writePos(mechDoor.getTruePosition());
        maplePacketLittleEndianWriter3.write(mechDoor.getId());
        maplePacketLittleEndianWriter3.writeInt(a2.getPartyId());
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] resetInnerPotential(byte a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        int n2 = a4;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DISABLE_INNER_ABILITY.getValue());
        maplePacketLittleEndianWriter2.write(n2);
        if (n2 == 1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(a3);
        } else {
            if (a4 == 2) {
                return maplePacketLittleEndianWriter2.getPacket();
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeShort(a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getTradePartnerAdd(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.VISIT.getValue());
        maplePacketLittleEndianWriter3.write(1);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter2, a2, false);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            maplePacketLittleEndianWriter.writeShort(a2.getJob());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] exitGame() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.RETURN_LOGIN.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] guildSkillPurchased(int a2, int a3, int a4, long a5, String a6, String a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter5.write(85);
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeShort(a4);
        maplePacketLittleEndianWriter3.writeLong(PacketHelper.getTime(a5));
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a6);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a7);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] changeGuildInAlliance(MapleGuildAlliance a2, MapleGuild a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(4);
        maplePacketLittleEndianWriter2.writeInt(a4 ? a2.getId() : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(((MapleGuild)((Object)a3)).getId());
        a3 = ((MapleGuild)((Object)a3)).getMembers();
        maplePacketLittleEndianWriter3.writeInt(a3.size());
        Iterator iterator = a3 = a3.iterator();
        while (iterator.hasNext()) {
            MapleGuildCharacter mapleGuildCharacter = (MapleGuildCharacter)a3.next();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(mapleGuildCharacter.getId());
            maplePacketLittleEndianWriter4.write(a4 ? mapleGuildCharacter.getAllianceRank() : (byte)0);
            iterator = a3;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateSkills(Map<ISkill, SkillEntry> a2) {
        Iterator<Map.Entry<ISkill, SkillEntry>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_SKILLS.getValue());
        maplePacketLittleEndianWriter2.write(1);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.write(0);
        }
        maplePacketLittleEndianWriter.writeShort(a2.size());
        Iterator<Map.Entry<ISkill, SkillEntry>> iterator2 = iterator = a2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<ISkill, SkillEntry> entry = iterator.next();
            maplePacketLittleEndianWriter.writeInt(entry.getKey().getId());
            maplePacketLittleEndianWriter.writeInt(entry.getValue().skillevel);
            maplePacketLittleEndianWriter.writeInt(entry.getValue().masterlevel);
            PacketHelper.addExpirationTime(maplePacketLittleEndianWriter, entry.getValue().expiration);
            iterator2 = iterator;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(4);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPKilled(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_KILLED.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] playSound(String a2) {
        int n2 = 4;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n2 = 5;
        }
        return MaplePacketCreator.environmentChange(a2, n2);
    }

    public static /* synthetic */ byte[] useSPReset(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SP_RESET.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] removeGuildFromAlliance(MapleGuildAlliance a2, MapleGuild a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u5f9e\u806f\u76df\u79fb\u9664);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter3, a2);
        MaplePacketCreator.getGuildInfo(maplePacketLittleEndianWriter2, a3);
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showZakumShrine(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.WITCH_TOWER_SCORE_UPDATE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] updateSp(MapleCharacter a2, boolean a3, boolean a4) {
        boolean bl;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_STATS.getValue());
        maplePacketLittleEndianWriter2.write(a3 != 0 ? 1 : 0);
        if (GameSetConstants.MAPLE_VERSION == 75) {
            maplePacketLittleEndianWriter.write(0);
        }
        a3 = (int)MapleStat.AVAILABLESP.getValue();
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            bl = a4;
            maplePacketLittleEndianWriter.writeLong((int)MapleStat.AVAILABLESP.getValue());
        } else {
            maplePacketLittleEndianWriter.writeInt((int)MapleStat.AVAILABLESP.getValue());
            bl = a4;
        }
        if (bl || JobConstants.isSeparatedSp(a2.getJob())) {
            maplePacketLittleEndianWriter.write(a2.getRemainingSpSize());
            int n2 = a3 = 0;
            while (n2 < a2.getRemainingSps().length) {
                if (a2.getRemainingSp(a3) > 0) {
                    maplePacketLittleEndianWriter.write(a3 + 1);
                    if (GameSetConstants.MAPLE_VERSION >= 152) {
                        maplePacketLittleEndianWriter.writeInt(a2.getRemainingSp(a3));
                    } else {
                        maplePacketLittleEndianWriter.write(a2.getRemainingSp(a3));
                    }
                }
                n2 = ++a3;
            }
        } else {
            maplePacketLittleEndianWriter.writeShort(a2.getRemainingSp());
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeZeroBytes(30);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] gainForce(MapleCharacter a2, int a3, int a4, int a5) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(a3);
        return MaplePacketCreator.gainForce(true, a2, linkedList, a4, a5, 0);
    }

    public static /* synthetic */ byte[] partyStatusMessage(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] sendRepairWindow(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.OPEN_UI_OPTION.getValue());
        int n2 = 34;
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            n2 = 33;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeInt(n2);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] addMessengerPlayer(String a2, MapleCharacter a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter4.write(a4);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter3, a3, true);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a5);
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] LieDetectorResponse(byte a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LIE_DETECTOR.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] TradeMessage(byte a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u96e2\u958b.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] cancelBuff(List<MapleBuffStat> a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        block4: {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            block3: {
                block2: {
                    maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
                    maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CANCEL_BUFF.getValue());
                    if (a2 == null) break block2;
                    MaplePacketCreator.H(maplePacketLittleEndianWriter2, a2);
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        Iterator<MapleBuffStat> iterator = a2.iterator();
                        while (iterator.hasNext()) {
                            if (!SkillConstants.isStackBuffStat(iterator.next())) continue;
                            maplePacketLittleEndianWriter2.writeInt(0);
                        }
                    }
                    maplePacketLittleEndianWriter2.write(3);
                    if (GameSetConstants.MAPLE_VERSION < 134) break block3;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                    maplePacketLittleEndianWriter3.write(1);
                    break block4;
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter4.writeLong(0L);
                maplePacketLittleEndianWriter4.writeInt(64);
                maplePacketLittleEndianWriter2.writeInt(4096);
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] addComboBuff(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        maplePacketLittleEndianWriter4.writeLong(MapleBuffStat.ARAN_COMBO.getValue());
        maplePacketLittleEndianWriter4.writeLong(0L);
        maplePacketLittleEndianWriter3.writeShort(a2);
        maplePacketLittleEndianWriter3.writeInt(21000000);
        maplePacketLittleEndianWriter2.writeInt(256);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] damagePlayer(int a2, int a3, int a4, int a5, byte a6, int a7, int a8, boolean a9, int a10, byte a11, Point a12, byte a13, int a14, int a15) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.DAMAGE_PLAYER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (a3 >= -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(a5);
            maplePacketLittleEndianWriter4.write(a6);
            if (GameSetConstants.MAPLE_VERSION >= 138) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter5.writeInt(a7);
                maplePacketLittleEndianWriter5.writeInt(a8);
            }
            maplePacketLittleEndianWriter.write(a8);
            if (a8 > 0) {
                maplePacketLittleEndianWriter.write(a9 ? 1 : 0);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter.writeInt(a10);
                maplePacketLittleEndianWriter6.write(a11);
                maplePacketLittleEndianWriter6.writePos(a12);
            }
            if (GameSetConstants.MAPLE_VERSION >= 123 && GameSetConstants.MAPLE_VERSION < 138) {
                maplePacketLittleEndianWriter.write(0);
            }
            maplePacketLittleEndianWriter.write(a13);
            if (GameSetConstants.MAPLE_VERSION >= 138 && a13 == 1) {
                maplePacketLittleEndianWriter.writeInt(a14);
            }
        }
        maplePacketLittleEndianWriter.writeInt(a4);
        if (a4 <= 0 || a15 > 0) {
            maplePacketLittleEndianWriter.writeInt(a15);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] englishQuizMsg(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ENGLISH_QUIZ.getValue());
        maplePacketLittleEndianWriter2.writeInt(20);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getGuildAlliance(MapleGuildAlliance a2) {
        int n2;
        int n3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(13);
        if (a2 == null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(0);
            return maplePacketLittleEndianWriter3.getPacket();
        }
        int n4 = a2.getNoGuilds();
        MapleGuild[] arrmapleGuild = new MapleGuild[n4];
        int n5 = n3 = 0;
        while (n5 < a2.getNoGuilds()) {
            int n6 = n3;
            arrmapleGuild[n6] = World.Guild.getGuild(a2.getGuildId(n6));
            if (arrmapleGuild[n3] == null) {
                return MaplePacketCreator.enableActions();
            }
            n5 = ++n3;
        }
        maplePacketLittleEndianWriter.writeInt(n4);
        MapleGuild[] arrmapleGuild2 = arrmapleGuild;
        n4 = arrmapleGuild.length;
        int n7 = n2 = 0;
        while (n7 < n4) {
            MapleGuild mapleGuild = arrmapleGuild2[n2];
            MaplePacketCreator.getGuildInfo(maplePacketLittleEndianWriter, mapleGuild);
            n7 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] getRPSMode(byte a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        byte by = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.RPS_GAME.getValue());
        maplePacketLittleEndianWriter2.write(by);
        switch (by) {
            case 6: {
                if (a3 == -1) break;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.writeInt(a3);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 8: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeInt(9209002);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 11: {
                maplePacketLittleEndianWriter2.write(a4);
                maplePacketLittleEndianWriter2.write(a5);
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] charInfo(MapleCharacter a2, boolean a3) {
        int n2;
        Object object2;
        Object object3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleCharacter mapleCharacter = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CHAR_INFO.getValue());
        maplePacketLittleEndianWriter.writeInt(mapleCharacter.getId());
        maplePacketLittleEndianWriter2.write(mapleCharacter.getLevel());
        maplePacketLittleEndianWriter2.writeShort(a2.getJob());
        if (GameSetConstants.MAPLE_VERSION >= 148) {
            maplePacketLittleEndianWriter.writeShort(a2.getSubcategory());
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.write(a2.getStat().pvpRank);
            maplePacketLittleEndianWriter3.writeInt(a2.getFame());
        } else {
            maplePacketLittleEndianWriter.writeShort(a2.getFame());
        }
        if (GameSetConstants.MAPLE_VERSION >= 151 && a2.getMarriageId() > 0) {
            object3 = a2.getMarriageRing(true);
            maplePacketLittleEndianWriter.write(object3 != null ? 1 : 0);
            if (object3 != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter7.writeInt(((MapleRing)object3).getRingId());
                maplePacketLittleEndianWriter7.writeInt(a2.getId());
                maplePacketLittleEndianWriter6.writeInt(((MapleRing)object3).getPartnerChrId());
                maplePacketLittleEndianWriter6.writeShort(3);
                maplePacketLittleEndianWriter5.writeInt(((MapleRing)object3).getItemId());
                maplePacketLittleEndianWriter5.writeInt(((MapleRing)object3).getItemId());
                maplePacketLittleEndianWriter4.writeAsciiString(a2.getName(), 15);
                maplePacketLittleEndianWriter4.writeAsciiString(((MapleRing)object3).getPartnerName(), 15);
            }
        } else {
            maplePacketLittleEndianWriter.write(a2.getMarriageId() > 0 ? 1 : 0);
        }
        object3 = a2.getPrefix();
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            Iterator<Integer> object5;
            object2 = a2.getProfessions();
            List<Integer> list = object2;
            maplePacketLittleEndianWriter.write(list.size());
            Iterator<Integer> iterator = object5 = list.iterator();
            while (iterator.hasNext()) {
                int n3 = object5.next();
                iterator = object5;
                maplePacketLittleEndianWriter.writeShort(n3);
            }
        }
        if (a2.getGuildId() <= 0) {
            if (a2.getPrefix().equals("")) {
                maplePacketLittleEndianWriter.writeMapleAsciiString(MapleParty.ALLATORIxDEMO("\u5c6a\u6733\u52d0\u517c\u511c\u671a"));
                if (GameSetConstants.MAPLE_VERSION != 75) {
                    maplePacketLittleEndianWriter.writeMapleAsciiString(AbstractPlayerInteraction.ALLATORIxDEMO("\u5c4c\u672b\u52f6\u5164\u8039\u76de"));
                }
            } else {
                maplePacketLittleEndianWriter.writeMapleAsciiString((String)object3);
                if (GameSetConstants.MAPLE_VERSION != 75) {
                    maplePacketLittleEndianWriter.writeMapleAsciiString(MapleParty.ALLATORIxDEMO("\u5c6a\u6733\u52d0\u517c\u801f\u76c6"));
                }
            }
        } else {
            object2 = World.Guild.getGuild(a2.getGuildId());
            if (object2 != null) {
                maplePacketLittleEndianWriter.writeMapleAsciiString(((MapleGuild)object2).getName());
                if (GameSetConstants.MAPLE_VERSION != 75) {
                    if (((MapleGuild)object2).getAllianceId() > 0) {
                        MapleGuildAlliance mapleGuildAlliance = World.Alliance.getAlliance(((MapleGuild)object2).getAllianceId());
                        if (mapleGuildAlliance != null) {
                            maplePacketLittleEndianWriter.writeMapleAsciiString(mapleGuildAlliance.getName());
                        } else {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
                            if (a2.getPrefix().equals("")) {
                                maplePacketLittleEndianWriter8.writeMapleAsciiString(AbstractPlayerInteraction.ALLATORIxDEMO("\u5c4c\u672b\u52f6\u5164\u8039\u76de"));
                            } else {
                                maplePacketLittleEndianWriter8.writeMapleAsciiString((String)object3);
                            }
                        }
                    } else {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
                        if (a2.getPrefix().equals("")) {
                            maplePacketLittleEndianWriter9.writeMapleAsciiString(MapleParty.ALLATORIxDEMO("\u5c6a\u6733\u52d0\u517c\u801f\u76c6"));
                        } else {
                            maplePacketLittleEndianWriter9.writeMapleAsciiString((String)object3);
                        }
                    }
                }
            } else if (a2.getPrefix().equals("")) {
                maplePacketLittleEndianWriter.writeMapleAsciiString(AbstractPlayerInteraction.ALLATORIxDEMO("\u5c4c\u672b\u52f6\u5164\u513a\u6702"));
                if (GameSetConstants.MAPLE_VERSION != 75) {
                    maplePacketLittleEndianWriter.writeMapleAsciiString(MapleParty.ALLATORIxDEMO("\u5c6a\u6733\u52d0\u517c\u801f\u76c6"));
                }
            } else {
                maplePacketLittleEndianWriter.writeMapleAsciiString((String)object3);
                if (GameSetConstants.MAPLE_VERSION != 75) {
                    maplePacketLittleEndianWriter.writeMapleAsciiString(AbstractPlayerInteraction.ALLATORIxDEMO("\u5c4c\u672b\u52f6\u5164\u8039\u76de"));
                }
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(a3 ? 1 : 0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.write(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
        MapleCharacter mapleCharacter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter;
        MapleCharacter mapleCharacter3 = a2;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a2.getcharmessage());
        maplePacketLittleEndianWriter.write(mapleCharacter3.getexpression());
        maplePacketLittleEndianWriter11.write(mapleCharacter3.getconstellation());
        maplePacketLittleEndianWriter11.write(a2.getblood());
        maplePacketLittleEndianWriter10.write(mapleCharacter2.getmonth());
        maplePacketLittleEndianWriter10.write(mapleCharacter2.getday());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        for (MaplePet maplePet : a2.getSummonedPets()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12;
            if (!maplePet.getSummoned()) continue;
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.write(a2.getPet(0) != null ? 1 : 0);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter13;
                maplePacketLittleEndianWriter13.writeInt(maplePet.getSummonedValue() - 1);
            } else {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter14;
                maplePacketLittleEndianWriter14.write(maplePet.getSummonedValue());
            }
            maplePacketLittleEndianWriter12.writeInt(maplePet.getPetItemId());
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter15 = maplePacketLittleEndianWriter;
            MaplePet maplePet2 = maplePet;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter16 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter16.writeMapleAsciiString(maplePet.getName());
            maplePacketLittleEndianWriter16.write(maplePet.getLevel());
            maplePacketLittleEndianWriter.writeShort(maplePet2.getCloseness());
            maplePacketLittleEndianWriter15.write(maplePet2.getFullness());
            maplePacketLittleEndianWriter15.writeShort(maplePet.getFlags());
            IItem iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((byte)(maplePet.getSummonedValue() == 2 ? -124 : (maplePet.getSummonedValue() == 1 ? -114 : -126)));
            maplePacketLittleEndianWriter.writeInt(iItem == null ? 0 : iItem.getItemId());
            if (GameSetConstants.MAPLE_VERSION < 152) continue;
            maplePacketLittleEndianWriter.writeInt(maplePet.getColor());
        }
        maplePacketLittleEndianWriter.write(0);
        if (a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18) != null) {
            MapleCharacter mapleCharacter4 = a2;
            int n4 = mapleCharacter4.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18).getItemId();
            MapleMount mapleMount = mapleCharacter4.getMount();
            boolean bl = MapleItemInformationProvider.getInstance().getReqLevel(n4) <= a2.getLevel();
            maplePacketLittleEndianWriter.write(bl ? 1 : 0);
            if (bl) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter17 = maplePacketLittleEndianWriter;
                MapleMount mapleMount2 = mapleMount;
                maplePacketLittleEndianWriter.writeInt(mapleMount2.getLevel());
                maplePacketLittleEndianWriter17.writeInt(mapleMount2.getExp());
                maplePacketLittleEndianWriter17.writeInt(mapleMount.getFatigue());
            }
        } else {
            maplePacketLittleEndianWriter.write(0);
        }
        int n4 = n2 = a2.getWishlistSize();
        maplePacketLittleEndianWriter.write(n4);
        if (n4 > 0) {
            int n5;
            int[] arrn = a2.getWishlist();
            int n6 = n5 = 0;
            while (n6 < n2) {
                maplePacketLittleEndianWriter.writeInt(arrn[n5++]);
                n6 = n5;
            }
        }
        if (GameSetConstants.MAPLE_VERSION < 134) {
            a2.getMonsterBook().addCharInfoPacket(a2.getMonsterBookCover(), maplePacketLittleEndianWriter);
        }
        MaplePacketCreator.addQuestMedalInfo(a2, maplePacketLittleEndianWriter);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter18 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter18.writeZeroBytes(4);
            maplePacketLittleEndianWriter18.writeZeroBytes(4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendGhostPoint(String a2, String a3) {
        return MaplePacketCreator.sendString(2, a2, a3);
    }

    public static /* synthetic */ byte[] messengerChat(String a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MESSENGER.getValue());
        maplePacketLittleEndianWriter2.write(6);
        if (GameSetConstants.MAPLE_VERSION >= 148) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] pvpCool(int a2, List<Integer> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<Integer> list = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_COOL.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter.write(list.size());
        Object object = a3 = list.iterator();
        while (object.hasNext()) {
            int n2 = (Integer)a3.next();
            object = a3;
            maplePacketLittleEndianWriter.writeInt(n2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getAllianceUpdate(MapleGuildAlliance a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(23);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ byte[] updatePlayerStats(List<Pair<MapleStat, Integer>> a2, boolean a3, MapleCharacter a4) {
        Object object;
        Object object2;
        Object object3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_STATS.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        if (GameSetConstants.MAPLE_VERSION == 75) {
            maplePacketLittleEndianWriter.write(0);
        }
        long l2 = 0L;
        Object object4 = object3 = a2.iterator();
        while (object4.hasNext()) {
            object2 = object3.next();
            l2 |= ((Pair)object2).getLeft().getValue();
            object4 = object3;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            object = a2;
            maplePacketLittleEndianWriter.writeLong(l2);
        } else {
            maplePacketLittleEndianWriter.writeInt((int)l2);
            object = object3 = a2;
        }
        if (object3.size() > 1) {
            Collections.sort(object3, new Comparator<Pair<MapleStat, Integer>>(){

                @Override
                public /* synthetic */ int compare(Pair<MapleStat, Integer> a2, Pair<MapleStat, Integer> a3) {
                    int n2 = (int)a2.getLeft().getValue();
                    if (n2 < (a3 = (int)a3.getLeft().getValue())) {
                        return -1;
                    }
                    if (n2 == a3) {
                        return 0;
                    }
                    return 1;
                }
                {
                    1 a2;
                }
            });
        }
        object2 = object3.iterator();
        block10: while (object2.hasNext()) {
            object3 = (Pair)object2.next();
            switch (6.B[((MapleStat)((Pair)object3).getLeft()).ordinal()]) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: {
                    maplePacketLittleEndianWriter.write(((Integer)((Pair)object3).getRight()).byteValue());
                    continue block10;
                }
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: {
                    maplePacketLittleEndianWriter.writeShort(((Integer)((Pair)object3).getRight()).shortValue());
                    continue block10;
                }
                case 13: {
                    int n2;
                    if (!JobConstants.isSeparatedSp(a4.getJob())) continue block10;
                    maplePacketLittleEndianWriter.write(a4.getRemainingSpSize());
                    int n3 = n2 = 0;
                    while (n3 < a4.getRemainingSps().length) {
                        if (a4.getRemainingSp(n2) > 0) {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
                            maplePacketLittleEndianWriter3.write(n2 + 1);
                            maplePacketLittleEndianWriter3.write(a4.getRemainingSp(n2));
                        }
                        n3 = ++n2;
                    }
                    continue block10;
                }
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: {
                    maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object3).getRight());
                    continue block10;
                }
                case 28: 
                case 29: 
                case 30: 
                case 31: {
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object3).getRight());
                        continue block10;
                    }
                    maplePacketLittleEndianWriter.writeShort(((Integer)((Pair)object3).getRight()).shortValue());
                    continue block10;
                }
                case 32: {
                    maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object3).getRight());
                    maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object3).getRight());
                    maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object3).getRight());
                    continue block10;
                }
                case 33: {
                    maplePacketLittleEndianWriter.writeLong(((Integer)((Pair)object3).getRight()).intValue());
                    maplePacketLittleEndianWriter.writeLong(((Integer)((Pair)object3).getRight()).intValue());
                    maplePacketLittleEndianWriter.writeLong(((Integer)((Pair)object3).getRight()).intValue());
                    continue block10;
                }
            }
            maplePacketLittleEndianWriter.writeInt((Integer)((Pair)object3).getRight());
        }
        if (l2 == 0L && !a3) {
            maplePacketLittleEndianWriter.write(1);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter4.writeZeroBytes(30);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] setNPCSpecialAction(int a2, String a3, int a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.NPC_SPECIAL_ACTION.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateDress(int a2, MapleCharacter a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ANGELIC_CHANGE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a3.getId());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getServerIP(byte[] a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SERVER_IP.getValue());
        maplePacketLittleEndianWriter4.writeShort(0);
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeZeroBytes(5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveDebuff(List<Pair<MapleBuffStat, Integer>> a2, int a3, int a4, int a5) {
        return MaplePacketCreator.giveDebuff(a2, a3, a4, a5, 0);
    }

    private static /* synthetic */ void l(MaplePacketLittleEndianWriter a2, List<Pair<MapleDisease, Integer>> a3) {
        long l2 = 0L;
        long l3 = 0L;
        a3 = a3.iterator();
        while (a3.hasNext()) {
            Pair pair = (Pair)a3.next();
            if (((MapleDisease)pair.getLeft()).isFirst()) {
                l2 |= ((MapleDisease)pair.getLeft()).getValue();
                continue;
            }
            l3 |= ((MapleDisease)pair.getLeft()).getValue();
        }
        a2.writeLong(l2);
        a2.writeLong(l3);
    }

    public static /* synthetic */ byte[] getShowItemGain(int a2, short a3) {
        return MaplePacketCreator.getShowItemGain(a2, a3, false);
    }

    public static final /* synthetic */ byte[] showOwnChampionEffect() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(32);
        maplePacketLittleEndianWriter2.writeInt(30000);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignDebuff(int a2, List<Pair<MapleBuffStat, Integer>> a3, int a4, int a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a3);
        if (a4 == 125) {
            maplePacketLittleEndianWriter.writeShort(0);
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.write(0);
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeShort(a6);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(a4);
        maplePacketLittleEndianWriter4.writeShort(a5);
        maplePacketLittleEndianWriter4.writeShort(a7);
        maplePacketLittleEndianWriter3.writeShort(900);
        maplePacketLittleEndianWriter3.writeZeroBytes(20);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] harvestMessage(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.HARVEST_MESSAGE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] registerFamiliar(MonsterFamiliar a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MonsterFamiliar monsterFamiliar = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.REGISTER_FAMILIAR.getValue());
        maplePacketLittleEndianWriter2.writeLong(a2.getId());
        monsterFamiliar.writeRegisterPacket(maplePacketLittleEndianWriter, false);
        maplePacketLittleEndianWriter2.writeShort(monsterFamiliar.getVitality() >= 3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] sendPVPMaps() {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_INFO.getValue());
        maplePacketLittleEndianWriter2.write(3);
        int n3 = n2 = 0;
        while (n3 < 20) {
            maplePacketLittleEndianWriter.writeInt(10);
            if (GameSetConstants.MAPLE_VERSION >= 151) {
                maplePacketLittleEndianWriter.writeZeroBytes(120);
            } else if (GameSetConstants.MAPLE_VERSION >= 139) {
                maplePacketLittleEndianWriter.writeZeroBytes(100);
            } else if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeZeroBytes(48);
            }
            n3 = ++n2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(150);
        maplePacketLittleEndianWriter3.write(0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] giveForeignPirate(List<Pair<MapleBuffStat, Integer>> a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        boolean bl = a5 == 5121009 || a5 == 15111005;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GIVE_FOREIGN_BUFF.getValue());
        maplePacketLittleEndianWriter3.writeInt(a4);
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a2);
        maplePacketLittleEndianWriter2.writeShort(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        Iterator<Pair<MapleBuffStat, Integer>> iterator = a4 = a2.iterator();
        while (iterator.hasNext()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6;
            Pair<MapleBuffStat, Integer> pair = a4.next();
            maplePacketLittleEndianWriter.writeInt(pair.getRight());
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter7.writeLong(a5);
                maplePacketLittleEndianWriter7.writeZeroBytes(bl ? (GameSetConstants.MAPLE_VERSION >= 134 ? 6 : 7) : 1);
                maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
            } else {
                maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter8.writeInt(a5);
                maplePacketLittleEndianWriter8.writeInt(0);
            }
            maplePacketLittleEndianWriter6.writeShort(a3);
            iterator = a4;
        }
        maplePacketLittleEndianWriter.writeShort(bl ? 600 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(0);
        maplePacketLittleEndianWriter10.write(1);
        maplePacketLittleEndianWriter10.write(1);
        maplePacketLittleEndianWriter9.writeInt(0);
        maplePacketLittleEndianWriter9.writeZeroBytes(20);
        return maplePacketLittleEndianWriter9.getPacket();
    }

    public static /* synthetic */ byte[] showQuestFinishEffect() {
        return MaplePacketCreator.showSpecialEffect(SpecialEffect.QUEST_COMPLETE.getValue());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ byte[] addAttackBody(SendPacketOpcode a, MapleCharacter a, int a, int a, AttackInfo a, int a, byte a, int a) {
        v0 = var8_11 = new MaplePacketLittleEndianWriter();
        var8_11.writeShort(a.getValue());
        v0.writeInt(a);
        v0.write(a.tbyte);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            var8_11.write(a);
        }
        v1 = a = a.skill > 0 ? a : 0;
        if (GameSetConstants.MAPLE_VERSION == 151 && MapleJob.is\u62f3\u9738(a.getJob()) && a.skill == 5121007) {
            a = 0;
        }
        var8_11.write(a);
        if (a > 0) {
            var8_11.writeInt(a.skill);
        }
        if (a.skill == 3211006 && GameSetConstants.MAPLE_VERSION >= 134) {
            a = 3220010;
            a = a.getSkillLevel(a);
            var8_11.write(a);
            if (a != 0) {
                var8_11.writeInt(a);
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            v2 = var8_11;
            v2.write(a.direction);
            v2.write(a.display);
        }
        var8_11.write(a.skill == 33101007 ? 0 : a.animation);
        v3 = var8_11;
        v3.write(a.speed);
        v3.write(a);
        v4 = var8_11;
        if (a > 0) {
            v4.writeInt(a);
            v5 = a;
        } else {
            v4.writeInt(a.charge);
            v5 = a;
        }
        a = v5.allDamage.iterator();
        block0: while (true) lbl-1000:
        // 3 sources

        {
            block20: {
                block19: {
                    if (!a.hasNext()) break block19;
                    a = a.next();
                    if (a.attack == null) ** GOTO lbl-1000
                    v6 = var8_11;
                    v6.writeInt(a.objectid);
                    v6.write(7);
                    if (GameSetConstants.MAPLE_VERSION >= 152) {
                        var8_11.write(0);
                    }
                    if (a.skill == 4211006) {
                        var8_11.write(a.attack.size());
                    }
                    break block20;
                }
                if (a.skill == 65121052) {
                    v7 = var8_11;
                    v7.writeInt(a.position.x);
                    v7.writeInt(a.position.y);
                }
                if (a.charge > 0) {
                    var8_11.writeInt(a.charge);
                }
                if (a != SendPacketOpcode.RANGED_ATTACK) ** GOTO lbl66
                var8_11.writePos(a.position);
                if (GameSetConstants.MAPLE_VERSION < 134) ** GOTO lbl66
                if (a.skillposition != null) {
                    var8_11.writePos(a.skillposition);
                }
                if (a.skill == 2121001 || a.skill == 2221001 || a.skill == 2321001) {
                    v8 = var8_11;
                    v9 = v8;
                    v8.writeInt(0);
                } else {
                    if (a.skill == 33101007) {
                        var8_11.writeInt(0);
                    }
lbl66:
                    // 5 sources

                    v9 = var8_11;
                }
                v9.writeZeroBytes(20);
                return var8_11.getPacket();
            }
            a = a.attack.iterator();
            while (true) {
                if (!a.hasNext()) continue block0;
                a = a.next();
                v10 = var8_11;
                if (((Boolean)a.right).booleanValue()) {
                    v10.writeInt((Integer)a.left + -2147483648);
                    continue;
                }
                v10.writeInt((Integer)a.left);
            }
            break;
        }
    }

    public static /* synthetic */ byte[] getPotentialEffect(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_POTENTIAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveSoulGauge(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        PacketHelper.writeBuffState(maplePacketLittleEndianWriter2, MapleBuffStat.SOUL_WEAPON);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeShort(a2);
            maplePacketLittleEndianWriter4.writeInt(a3);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter3.write(0);
            maplePacketLittleEndianWriter3.write(0);
        } else {
            if (GameSetConstants.MAPLE_VERSION == 151) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeShort(a2);
                maplePacketLittleEndianWriter5.writeInt(1);
                maplePacketLittleEndianWriter5.writeInt(0);
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.writeInt(1000);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter8.writeInt(a3);
        maplePacketLittleEndianWriter8.writeInt(a3);
        maplePacketLittleEndianWriter7.writeShort(0);
        maplePacketLittleEndianWriter7.writeLong(0L);
        maplePacketLittleEndianWriter6.writeInt(0);
        maplePacketLittleEndianWriter6.writeZeroBytes(20);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] hitCoconut(boolean a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.HIT_COCONUT.getValue());
        if (a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.write(0);
            maplePacketLittleEndianWriter3.writeInt(128);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeInt(a3);
            maplePacketLittleEndianWriter4.write(a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] harvestResult(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.HARVESTED.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getPieSmega(String a2, boolean a3, int a4) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.PIE_MESSAGE.getValue(), a4, arrstring, a3, null);
    }

    public static /* synthetic */ byte[] getSuperMegaphone(String a2, boolean a3, int a4) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.EFFICIENCY_MESSAGE.getValue(), a4, arrstring, a3, null);
    }

    public static /* synthetic */ byte[] showThread(MapleBBSThread a2) {
        Iterator<MapleBBSThread.MapleBBSReply> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleBBSThread mapleBBSThread = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MapleBBSThread mapleBBSThread2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleBBSThread mapleBBSThread3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.BBS_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(7);
        maplePacketLittleEndianWriter.writeInt(mapleBBSThread3.localthreadID);
        maplePacketLittleEndianWriter3.writeInt(mapleBBSThread3.ownerID);
        maplePacketLittleEndianWriter3.writeLong(PacketHelper.getKoreanTimestamp(a2.timestamp));
        maplePacketLittleEndianWriter.writeMapleAsciiString(mapleBBSThread2.name);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(mapleBBSThread2.text);
        maplePacketLittleEndianWriter2.writeInt(a2.icon);
        maplePacketLittleEndianWriter.writeInt(mapleBBSThread.getReplyCount());
        Iterator<MapleBBSThread.MapleBBSReply> iterator2 = iterator = mapleBBSThread.replies.values().iterator();
        while (iterator2.hasNext()) {
            MapleBBSThread.MapleBBSReply mapleBBSReply = iterator.next();
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            MapleBBSThread.MapleBBSReply mapleBBSReply2 = mapleBBSReply;
            maplePacketLittleEndianWriter.writeInt(mapleBBSReply.replyid);
            maplePacketLittleEndianWriter.writeInt(mapleBBSReply2.ownerID);
            maplePacketLittleEndianWriter5.writeLong(PacketHelper.getKoreanTimestamp(mapleBBSReply2.timestamp));
            maplePacketLittleEndianWriter5.writeMapleAsciiString(mapleBBSReply.content);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] multiChat(String a2, String a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MULTICHAT.getValue());
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] mechPortal(Point a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MECH_PORTAL.getValue());
        maplePacketLittleEndianWriter2.writePos(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] MagicWheelAction(int a2, String a3, List<Integer> a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MAGIC_WHEEL.getValue());
        maplePacketLittleEndianWriter.write(n2);
        if (n2 == 3) {
            List<Integer> list = a4;
            maplePacketLittleEndianWriter.write(list.size());
            Object object = a4 = list.iterator();
            while (object.hasNext()) {
                Integer n3 = (Integer)a4.next();
                object = a4;
                maplePacketLittleEndianWriter.writeInt(n3);
            }
            maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
            maplePacketLittleEndianWriter.write(a5);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getTrockMessage(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.TROCK_LOCATIONS.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getSkullSmega(String a2, boolean a3, int a4) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.SKULL_MESSAGE.getValue(), a4, arrstring, a3, null);
    }

    public static /* synthetic */ byte[] FishKingResult(int a2, int a3, int a42, int a5, int a6, int a7, List<Pair<Integer, Integer>> a8) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<Pair<Integer, Integer>> list = a8;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.SHOW_EQUIP_EFFECT.getValue());
        maplePacketLittleEndianWriter5.write(2);
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a42);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        maplePacketLittleEndianWriter2.writeInt(a7);
        maplePacketLittleEndianWriter.writeInt(list.size());
        Iterator<Pair<Integer, Integer>> iterator = a3 = list.iterator();
        while (iterator.hasNext()) {
            Pair<Integer, Integer> a42 = a3.next();
            maplePacketLittleEndianWriter.writeInt(a42.getLeft());
            maplePacketLittleEndianWriter.writeInt(a42.getRight());
            iterator = a3;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showOwnWeirdEffect(String a2, int a3, int a4) {
        return MaplePacketCreator.showWeirdEffect(-1, a2, a3, a4);
    }

    public static /* synthetic */ byte[] getChatText(int a2, String a3, boolean a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CHATTEXT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter3.write(a5);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] magicAttack(MapleCharacter a2, int a3, AttackInfo a4, int a5) {
        MapleCharacter mapleCharacter = a2;
        return MaplePacketCreator.addAttackBody(SendPacketOpcode.MAGIC_ATTACK, mapleCharacter, mapleCharacter.getId(), a3, a4, a5, (byte)0, 0);
    }

    public static /* synthetic */ byte[] showAriantScoreBoard() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ARIANT_SCOREBOARD.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] SmartMobNotice(int a2, String a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SMART_MOB_NOTICE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a4 ? 1 : 0);
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getErrorNotice(String a2) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.RED_MESSAGE.getValue(), 0, arrstring, true, null);
    }

    public static final /* synthetic */ byte[] getPVPMist(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_MIST.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.write(8);
        maplePacketLittleEndianWriter2.writeInt(1000);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBuffEffect(int a2, int a3, int a4, int a5, int a6, byte a7, int a82, int a9, int a10) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter a82 = new MaplePacketLittleEndianWriter();
        if (a2 == -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a82;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        } else {
            maplePacketLittleEndianWriter = a82;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a82;
            maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
            maplePacketLittleEndianWriter3.writeInt(a2);
        }
        maplePacketLittleEndianWriter.write(a4);
        a82.writeInt(a3);
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            a82.write(a5 - 1);
        }
        a82.write(a6);
        if (a7 != 3 || a3 == 1320006 || a3 == 30001062 || a3 == 30001061 || a3 == 22160000) {
            a82.write(a7);
        }
        if (a3 == 30001062) {
            a82.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a82;
        maplePacketLittleEndianWriter4.writeZeroBytes(10);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] showOwnSpecailSkillEffect(int a2) {
        return MaplePacketCreator.showSpecailSkillEffect(-1, a2);
    }

    public static /* synthetic */ byte[] partyCreated(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(MaplePacketOperation.PartyStatus.\u968a\u4f0d\u5275\u7acb);
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(999999999);
        maplePacketLittleEndianWriter3.writeInt(999999999);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter2.writeLong(0L);
            maplePacketLittleEndianWriter5.write(0);
            maplePacketLittleEndianWriter5.write(1);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
            maplePacketLittleEndianWriter6.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] updateQuestMobKills(MapleQuestStatus a2) {
        Iterator<Integer> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(StatusInfoType.UPDATE_QUEST.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2.getQuest().getId());
        maplePacketLittleEndianWriter2.write(1);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator2 = iterator = a2.getMobKills().values().iterator();
        while (iterator2.hasNext()) {
            int n2 = iterator.next();
            iterator2 = iterator;
            stringBuilder.append(StringUtil.getLeftPaddedStr(String.valueOf(n2), '0', 3));
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeMapleAsciiString(stringBuilder.toString());
        maplePacketLittleEndianWriter4.writeZeroBytes(8);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] musicChange(String a2) {
        int n2 = 6;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n2 = 7;
        }
        return MaplePacketCreator.environmentChange(a2, n2);
    }

    public static /* synthetic */ byte[] showSpeedRanks(int a2, List<MapleRanking.SpeedRank> a32) {
        Iterator<MapleRanking.SpeedRank> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION >= 134 ? 80 : 73);
        List<MapleRanking.SpeedRank> list = a32;
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int a32 = 1;
        Iterator<MapleRanking.SpeedRank> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MapleRanking.SpeedRank speedRank = iterator.next();
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeShort(a32);
                ++a32;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MapleRanking.SpeedRank speedRank2 = speedRank;
            maplePacketLittleEndianWriter.writeMapleAsciiString(speedRank2.getName());
            maplePacketLittleEndianWriter3.writeInt(speedRank2.getTime());
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
            iterator2 = iterator;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] guildDisband(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GUILD_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u89e3\u6563);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateImp(MapleImp a2, int a3, int a42, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ITEM_POT.getValue());
        maplePacketLittleEndianWriter2.write(a5 ? 0 : 1);
        int n2 = a3;
        maplePacketLittleEndianWriter.writeInt(a42 + 1);
        maplePacketLittleEndianWriter.writeInt(n2);
        if ((n2 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0) {
            Pair<Integer, Integer> a42 = MapleItemInformationProvider.getInstance().getPot(a2.getItemId());
            if (a42 == null) {
                return MaplePacketCreator.enableActions();
            }
            maplePacketLittleEndianWriter.writeInt((Integer)a42.left);
            maplePacketLittleEndianWriter.write(a2.getLevel());
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.STATE.getValue()) != 0) {
            maplePacketLittleEndianWriter.write(a2.getState());
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.FULLNESS.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(a2.getFullness());
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.CLOSENESS.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(a2.getCloseness());
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.CLOSENESS_LEFT.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(1);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.MINUTES_LEFT.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.LEVEL.getValue()) != 0) {
            maplePacketLittleEndianWriter.write(1);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.FULLNESS_2.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(a2.getFullness());
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.UPDATE_TIME.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.CREATE_TIME.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.AWAKE_TIME.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.SLEEP_TIME.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.MAX_CLOSENESS.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(100);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.MAX_DELAY.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(1000);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.MAX_FULLNESS.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(1000);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.MAX_ALIVE.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(1);
        }
        if ((a3 & MapleImp.ImpFlag.SUMMONED.getValue()) != 0 || (a3 & MapleImp.ImpFlag.MAX_MINUTES.getValue()) != 0) {
            maplePacketLittleEndianWriter.writeInt(10);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] removeAndroidHeart() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(19);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getJobSelection(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.NPC_TALK.getValue());
        maplePacketLittleEndianWriter3.write(5);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(23);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter.writeInt(n2);
        if (n2 == 0 || a3 == 1) {
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeMapleAsciiString("");
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showExpChairResetMessage() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CHAIR_EXP_RESET.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] pvpAttack(int a2, int a32, int a42, int a5, int a62, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14, int a15, int a16, boolean a17, boolean a18, boolean a19, List<AttackPair> a20) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        int n2 = a42;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_ATTACK.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.write(a32);
        maplePacketLittleEndianWriter2.writeInt(n2);
        if (SkillConstants.isIceKnightSkill(n2)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter4.writeInt(a42);
            maplePacketLittleEndianWriter4.write(1);
        } else {
            maplePacketLittleEndianWriter2.write(a5);
            maplePacketLittleEndianWriter2.writeInt(a15 != a42 ? a15 : 0);
            maplePacketLittleEndianWriter2.write(a16 != a5 ? a16 : 0);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.write(a13);
        maplePacketLittleEndianWriter2.write(a17 ? 1 : 0);
        maplePacketLittleEndianWriter2.write(a18 ? 1 : 0);
        maplePacketLittleEndianWriter2.write(a19 ? 1 : 0);
        int n3 = a12;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.write(0);
        maplePacketLittleEndianWriter5.write(a11);
        maplePacketLittleEndianWriter2.write(n3);
        if (n3 > 300) {
            return maplePacketLittleEndianWriter2.getPacket();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter2.write(a62);
        maplePacketLittleEndianWriter7.write(a7);
        maplePacketLittleEndianWriter7.writeInt(a8);
        maplePacketLittleEndianWriter6.writeInt(a10);
        maplePacketLittleEndianWriter6.writeInt(a14);
        maplePacketLittleEndianWriter2.write(a20.size());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter2.writeInt(0);
        }
        a32 = 0;
        a42 = a9;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter2.write(a32);
        maplePacketLittleEndianWriter8.write(a42);
        maplePacketLittleEndianWriter8.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            maplePacketLittleEndianWriter2.write(0);
        }
        if (a32 > 0) {
            Iterator<AttackPair> a32 = a20.iterator();
            while (a32.hasNext()) {
                AttackPair attackPair = a42 = a32.next();
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter9.writeInt(0);
                maplePacketLittleEndianWriter9.writeInt(a42.objectid);
                maplePacketLittleEndianWriter2.writePos(attackPair.point);
                Iterator<Pair<Integer, Boolean>> iterator = attackPair.attack.iterator();
                while (iterator.hasNext()) {
                    Pair<Integer, Boolean> a62 = a5.next();
                    maplePacketLittleEndianWriter2.writeInt((Integer)a62.left);
                    maplePacketLittleEndianWriter2.write((Boolean)a62.right != false ? 1 : 0);
                    iterator = a5;
                }
            }
        }
        for (AttackPair a42 : a20) {
            maplePacketLittleEndianWriter2.writeInt(a42.objectid);
            if (GameSetConstants.MAPLE_VERSION >= 139) {
                maplePacketLittleEndianWriter2.writeInt(0);
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter10.writePos(a42.point);
            maplePacketLittleEndianWriter10.write(0);
            maplePacketLittleEndianWriter2.writeInt(0);
            Iterator<Pair<Integer, Boolean>> iterator = a42.attack.iterator();
            while (iterator.hasNext()) {
                Pair<Integer, Boolean> a62 = a5.next();
                maplePacketLittleEndianWriter2.writeInt((Integer)a62.left);
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    maplePacketLittleEndianWriter2.writeInt(0);
                }
                maplePacketLittleEndianWriter2.write((Boolean)a62.right != false ? 1 : 0);
                iterator = a5;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter11.write(0);
                maplePacketLittleEndianWriter11.write(0);
            }
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPIceHPBar(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_ICEKNIGHT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showChaosZakumShrine(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CHAOS_ZAKUM_SHRINE.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] getInventoryFull() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPIceGage(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PVP_ICEGAGE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] cancelDebuff(MapleBuffStat a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CANCEL_BUFF.getValue());
        PacketHelper.writeSingleMask(maplePacketLittleEndianWriter2, a2);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.write(3);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(1);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] stopClock() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.STOP_CLOCK.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] boatPacket(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BOAT_PACKET.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] updateJaguar(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_JAGUAR.getValue());
        PacketHelper.addJaguarInfo(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] MapleBuffStat(List<MapleBuffStat> a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<MapleBuffStat> list = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CANCEL_BUFF.getValue());
        PacketHelper.writeMask(maplePacketLittleEndianWriter, list);
        Iterator<MapleBuffStat> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!SkillConstants.isStackBuffStat(iterator.next())) continue;
            maplePacketLittleEndianWriter.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.write(3);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] removeDoor(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPAWN_PORTAL.getValue());
            maplePacketLittleEndianWriter3.writeInt(999999999);
            maplePacketLittleEndianWriter3.writeInt(999999999);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.REMOVE_DOOR.getValue());
            maplePacketLittleEndianWriter4.write(1);
            maplePacketLittleEndianWriter4.writeInt(a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] spouseMessage(String a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPOUSE_MESSAGE.getValue());
        maplePacketLittleEndianWriter2.writeShort(a3 ? 10 : 6);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] Mulung_Pts(int a2, int a3) {
        return MaplePacketCreator.showQuestMsg("\u4f60\u7372\u5f97 " + a2 + " \u4fee\u7149\u9ede\u6578, \u76ee\u524d\u7d2f\u7a4d\u4e86 " + a3 + " \u9ede\u4fee\u7149\u9ede\u6578");
    }

    public static /* synthetic */ byte[] getTradeConfirmation() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter.write(PlayerInteraction.\u78ba\u8a8d\u4ea4\u6613.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getStorage(int a2, byte a3, Collection<IItem> a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.OPEN_STORAGE.getValue());
        int n2 = 22;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            n2 = 21;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.write(n2);
        maplePacketLittleEndianWriter5.writeInt(a2);
        maplePacketLittleEndianWriter4.write(a3);
        maplePacketLittleEndianWriter4.writeShort(126);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter2.writeInt(a5);
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter.write((byte)a4.size());
        Iterator<IItem> iterator = a3 = a4.iterator();
        while (iterator.hasNext()) {
            a4 = a3.next();
            iterator = a3;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, (IItem)a4);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeShort(0);
        maplePacketLittleEndianWriter6.write(0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getFollowMessage(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FOLLOW_MESSAGE.getValue());
        maplePacketLittleEndianWriter2.writeShort(11);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showInfo(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.SHOW_INFO.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] movePlayer(int a2, List<LifeMovementFragment> a3, Point a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MOVE_PLAYER.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writePos(a4);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter3, a3);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] partyStatusMessage(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        int n2 = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter.write(n2);
        if (n2 == 22 || a2 == 23 || a2 == 24) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] updateAp(MapleCharacter a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_STATS.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt((int)MapleStat.AVAILABLEAP.getValue());
        maplePacketLittleEndianWriter3.writeShort(a2.getRemainingAp());
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] giveArcane(Map<Integer, Integer> a2, int a3) {
        Iterator<Map.Entry<Integer, Integer>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Map<Integer, Integer> map = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        PacketHelper.writeSingleMask(maplePacketLittleEndianWriter3, MapleBuffStat.ARCANE_AIM);
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter.writeInt(map.size());
        Iterator<Map.Entry<Integer, Integer>> iterator2 = iterator = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            maplePacketLittleEndianWriter.writeInt(entry.getKey());
            maplePacketLittleEndianWriter.writeLong(entry.getValue().intValue());
            iterator2 = iterator;
            maplePacketLittleEndianWriter.writeInt(a3);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(0);
        maplePacketLittleEndianWriter5.writeShort(0);
        maplePacketLittleEndianWriter5.write(1);
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter4.writeZeroBytes(20);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] GainEXP_Monster(int a2, boolean a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        block6: {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            block5: {
                block4: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
                    maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
                    maplePacketLittleEndianWriter3.write(StatusInfoType.EXP_MSG.getValue());
                    maplePacketLittleEndianWriter3.write(a3 ? 1 : 0);
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter4.writeInt(a2);
                    maplePacketLittleEndianWriter4.write(0);
                    if (GameSetConstants.MAPLE_VERSION >= 152) {
                        maplePacketLittleEndianWriter2.writeLong(-1L);
                    }
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter10.writeInt(a4);
                    maplePacketLittleEndianWriter10.write(0);
                    maplePacketLittleEndianWriter9.write(0);
                    maplePacketLittleEndianWriter9.writeInt(a5);
                    maplePacketLittleEndianWriter8.writeInt(a6);
                    maplePacketLittleEndianWriter8.write(0);
                    maplePacketLittleEndianWriter7.writeInt(a7);
                    maplePacketLittleEndianWriter7.writeInt(a8);
                    maplePacketLittleEndianWriter6.writeInt(a9);
                    maplePacketLittleEndianWriter6.writeInt(0);
                    maplePacketLittleEndianWriter5.writeInt(0);
                    maplePacketLittleEndianWriter5.writeInt(a10);
                    maplePacketLittleEndianWriter2.writeInt(0);
                    if (GameSetConstants.MAPLE_VERSION < 143) break block4;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter2.writeInt(0);
                    maplePacketLittleEndianWriter11.writeInt(0);
                    maplePacketLittleEndianWriter11.writeInt(0);
                    if (GameSetConstants.MAPLE_VERSION >= 147) {
                        maplePacketLittleEndianWriter2.writeInt(0);
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 152) {
                        maplePacketLittleEndianWriter2.writeInt(0);
                    }
                    maplePacketLittleEndianWriter2.writeInt(0);
                    maplePacketLittleEndianWriter2.writeInt(0);
                    if (GameSetConstants.MAPLE_VERSION < 151) break block5;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter12;
                    maplePacketLittleEndianWriter12.writeInt(0);
                    break block6;
                }
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter13.writeInt(0);
                    maplePacketLittleEndianWriter13.writeInt(0);
                }
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] GameMaster_Func(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GM_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeZeroBytes(17);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getAggroRankInfo(List<String> a2) {
        Iterator<String> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (SendPacketOpcode.AGGRO_RANK_INFO.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.AGGRO_RANK_INFO.getValue());
        maplePacketLittleEndianWriter.writeInt(a2.size());
        Iterator<String> iterator2 = iterator = a2.iterator();
        while (iterator2.hasNext()) {
            String string = iterator.next();
            iterator2 = iterator;
            maplePacketLittleEndianWriter.writeMapleAsciiString(string);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getKeymap(MapleKeyLayout a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.KEYMAP.getValue());
        a2.writeData(maplePacketLittleEndianWriter2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] giveSoulEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        PacketHelper.writeBuffState(maplePacketLittleEndianWriter6, MapleBuffStat.SOUL_SKILL);
        maplePacketLittleEndianWriter6.writeShort(12000);
        maplePacketLittleEndianWriter5.writeInt(a2);
        maplePacketLittleEndianWriter5.writeInt(640000);
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter3.writeLong(0L);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter2.writeZeroBytes(20);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] gainForce(boolean a2, MapleCharacter a3, List<Integer> a4, int a5, int a6, List<Pair<Integer, Integer>> a7) {
        return MaplePacketCreator.gainForce(a2, a3, a4, -1, -1, a5, a6, a7);
    }

    public static /* synthetic */ byte[] DressUpInfoModified(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DRESS_UP_INFO_MODIFIED.getValue());
        PacketHelper.addDressUpInfo(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getTradeMesoSet(byte a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u8a2d\u5b9a\u6953\u5e63.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getNPCTalk(int a2, byte a3, String a4, String a5, byte a6) {
        return MaplePacketCreator.getNPCTalk(a2, a3, a4, a5, a6, a2);
    }

    public static /* synthetic */ byte[] getFindReplyWithCS(String a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.WHISPER.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 72 : 9);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.write(2);
        maplePacketLittleEndianWriter3.writeInt(-1);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] skillCancel(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CANCEL_SKILL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] sendString(int a2, String a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        switch (a2) {
            case 1: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                while (false) {
                }
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SESSION_VALUE.getValue());
                break;
            }
            case 2: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PARTY_VALUE.getValue());
                break;
            }
            case 3: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.MAP_VALUE.getValue());
                break;
            }
            case 4: {
                maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FIELD_VALUE.getValue());
            }
            default: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter6.writeMapleAsciiString(a4);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] sendHint(String a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (a3 < 1 && (a3 = a2.length() * 10) < 40) {
            a3 = 40;
        }
        if (a4 < 5) {
            a4 = 5;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAYER_HINT.getValue());
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter2.writeShort(a4);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getPVPPoints(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PVP_POINTS.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] damageSummon(int a2, int a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.DAMAGE_SUMMON.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.write(a5);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a6);
        maplePacketLittleEndianWriter2.write(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showScrollGashaponBoxResult(boolean a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        boolean bl = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SCROLL_GASHAPON_BOX.getValue());
        maplePacketLittleEndianWriter2.write(bl);
        if (!bl) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(a4);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeInt(a3);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getShowQuestCompletion(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_QUEST_COMPLETION.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] modifyInventory(boolean a2, ModifyInventory a3, MapleCharacter a4, boolean a5) {
        return MaplePacketCreator.modifyInventory(a2, Collections.singletonList(a3), a4, a5);
    }

    public static /* synthetic */ byte[] partyInvite(MapleCharacter a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PARTY_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(MaplePacketOperation.PartyStatus.\u968a\u4f0d\u9080\u8acb);
        maplePacketLittleEndianWriter2.writeInt(a2.getParty().getId());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        if (GameSetConstants.MAPLE_VERSION > 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(a2.getLevel());
            maplePacketLittleEndianWriter4.writeInt(a2.getJob());
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                maplePacketLittleEndianWriter.writeInt(a2.getSubcategory());
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.write(a3);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] selectExpChair(int a2, int a3, int a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SELECT_EXP_CHAIR.getValue());
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(0);
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] updateHonour(int a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_HONOUR.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] changeAlliance(MapleGuildAlliance a2, boolean a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ALLIANCE_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(MaplePacketOperation.GuildStatus.\u516c\u6703\u66f4\u63db\u806f\u76df);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        maplePacketLittleEndianWriter.writeInt(a3 ? a2.getId() : 0);
        int n3 = a2.getNoGuilds();
        MapleGuild[] arrmapleGuild = new MapleGuild[n3];
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = n2;
            arrmapleGuild[n5] = World.Guild.getGuild(a2.getGuildId(n5));
            if (arrmapleGuild[n2] == null) {
                return MaplePacketCreator.enableActions();
            }
            n4 = ++n2;
        }
        maplePacketLittleEndianWriter.write(n3);
        int n6 = n2 = 0;
        while (n6 < n3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(arrmapleGuild[n2].getId());
            Object object = arrmapleGuild[n2].getMembers();
            maplePacketLittleEndianWriter3.writeInt(object.size());
            Object object2 = object = object.iterator();
            while (object2.hasNext()) {
                MapleGuildCharacter mapleGuildCharacter = (MapleGuildCharacter)object.next();
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter4.writeInt(mapleGuildCharacter.getId());
                maplePacketLittleEndianWriter4.write(a3 ? mapleGuildCharacter.getAllianceRank() : (byte)0);
                object2 = object;
            }
            n6 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getShowFameGain(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.FAME_MSG.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showOwnBuffEffect(int a2, int a3, int a4, int a5) {
        return MaplePacketCreator.showBuffEffect(-1, a2, a3, a4, a5, (byte)3);
    }

    public static /* synthetic */ byte[] getShowInventoryStatus(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getMegaphone(String a2) {
        String[] arrstring = new String[1];
        arrstring[0] = a2;
        return MaplePacketCreator.ALLATORIxDEMO((int)SmegaType.REDMEGA_MESSAGE.getValue(), 0, arrstring, false, null);
    }

    public static final /* synthetic */ byte[] getCharInfo(MapleCharacter a2, boolean a3, MapleMap a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        block12: {
            block11: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3;
                block10: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
                    maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SET_FIELD.getValue());
                    maplePacketLittleEndianWriter4.writeInt(a2.getClient().getChannel() - 1);
                    if (GameSetConstants.MAPLE_VERSION >= 139) {
                        maplePacketLittleEndianWriter2.write(0);
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        maplePacketLittleEndianWriter2.writeInt(0);
                    }
                    maplePacketLittleEndianWriter2.write(a3 ? 1 : 2);
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        maplePacketLittleEndianWriter2.writeInt(0);
                    }
                    maplePacketLittleEndianWriter2.write(a3);
                    maplePacketLittleEndianWriter2.writeShort(0);
                    if (!a3) break block10;
                    MapleCharacter mapleCharacter = a2;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                    mapleCharacter.CRand().connectData(maplePacketLittleEndianWriter5);
                    PacketHelper.addCharacterInfo(maplePacketLittleEndianWriter5, mapleCharacter, false);
                    if (GameSetConstants.MAPLE_VERSION <= 118) break block11;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
                    maplePacketLittleEndianWriter6.writeZeroBytes(16);
                    break block12;
                }
                if (GameSetConstants.MAPLE_VERSION > 113) {
                    maplePacketLittleEndianWriter2.write(0);
                }
                maplePacketLittleEndianWriter2.writeInt(a4.getId());
                maplePacketLittleEndianWriter2.write(a5);
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter7;
                    maplePacketLittleEndianWriter7.writeInt(a2.getStat().getHp());
                } else {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter8;
                    maplePacketLittleEndianWriter8.writeShort(a2.getStat().getHp());
                }
                maplePacketLittleEndianWriter3.write(0);
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter2.writeInt(100);
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                a3 = false;
                maplePacketLittleEndianWriter2.writeBoolean(false);
            }
            maplePacketLittleEndianWriter2.write(0);
            maplePacketLittleEndianWriter2.write(0);
            if (GameSetConstants.MAPLE_VERSION >= 139) {
                maplePacketLittleEndianWriter2.write(1);
                if (GameSetConstants.MAPLE_VERSION >= 152 && a4 != null && (a4.getId() / 10 == 10520011 || a4.getId() / 10 == 10520051 || a4.getId() == 105200519)) {
                    maplePacketLittleEndianWriter2.write(0);
                }
            }
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] coconutScore(int[] a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.COCONUT_SCORE.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2[0]);
        maplePacketLittleEndianWriter2.writeShort(a2[1]);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showAndroidEmotion(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.ANDROID_EMOTION.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showEnvironment(int a2, String a3, int[] a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        int n2 = a2;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BOSS_ENV.getValue());
        maplePacketLittleEndianWriter2.write(n2);
        switch (n2) {
            case 0: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                while (false) {
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.write(a4[0]);
                maplePacketLittleEndianWriter3.writeInt(a4[1]);
                maplePacketLittleEndianWriter3.writeInt(a4[2]);
                break;
            }
            case 1: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter4.write(a4[0]);
                maplePacketLittleEndianWriter4.writeInt(a4[1]);
                break;
            }
            case 2: 
            case 4: 
            case 5: 
            case 7: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.writeMapleAsciiString(a3);
                break;
            }
            case 3: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.writeMapleAsciiString(a3);
                maplePacketLittleEndianWriter6.write(a4[0]);
                break;
            }
            case 6: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter8.writeInt(a4[0]);
                maplePacketLittleEndianWriter8.writeInt(a4[1]);
                maplePacketLittleEndianWriter2.writeInt(a4[2]);
                maplePacketLittleEndianWriter7.write(a4[3]);
                maplePacketLittleEndianWriter7.write(a4[4]);
                break;
            }
            case 8: {
                maplePacketLittleEndianWriter2.writeInt(a4[0]);
                maplePacketLittleEndianWriter2.writeInt(a4[1]);
                maplePacketLittleEndianWriter2.writeInt(a4[2]);
            }
            default: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] moveAndroid(int a2, Point a3, List<LifeMovementFragment> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.ANDROID_MOVE.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writePos(a3);
        maplePacketLittleEndianWriter2.writeInt(Integer.MAX_VALUE);
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter2, a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] scrolledItem(IItem a2, IItem a3, boolean a4, boolean a5, boolean a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(a4 ? 2 : 3);
        maplePacketLittleEndianWriter.write(a2.getQuantity() > 0 ? 1 : 3);
        IItem iItem = a2;
        maplePacketLittleEndianWriter.write(GameConstants.getInventoryType(a2.getItemId()).getType());
        maplePacketLittleEndianWriter.writeShort(iItem.getPosition());
        if (iItem.getQuantity() > 0) {
            maplePacketLittleEndianWriter.writeShort(a2.getQuantity());
        }
        maplePacketLittleEndianWriter.write(3);
        if (!a4) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.write(MapleInventoryType.EQUIP.getType());
            maplePacketLittleEndianWriter3.writeShort(a3.getPosition());
            maplePacketLittleEndianWriter3.write(0);
        }
        maplePacketLittleEndianWriter.write(MapleInventoryType.EQUIP.getType());
        maplePacketLittleEndianWriter.writeShort(a3.getPosition());
        if (!a4) {
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, a3);
        }
        if (!a5) {
            maplePacketLittleEndianWriter.write(1);
        }
        if (a6) {
            maplePacketLittleEndianWriter.write(3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getCharInfo(MapleCharacter a2) {
        return MaplePacketCreator.getCharInfo(a2, true, null, 0);
    }

    public static /* synthetic */ byte[] updateFusionAnvil(MapleCharacter a2, Item a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter6.write(0);
        maplePacketLittleEndianWriter6.write(2);
        maplePacketLittleEndianWriter5.write(0);
        maplePacketLittleEndianWriter5.write(3);
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter4.writeShort(a3.getPosition());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeShort(a3.getPosition());
        PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, a3, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateCombo(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ARAN_COMBO.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] getScrollEffect(int a2, IEquip.ScrollResult a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_SCROLL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            maplePacketLittleEndianWriter.write(a3 == IEquip.ScrollResult.CURSE ? 2 : (a3 == IEquip.ScrollResult.SUCCESS ? 1 : 0));
            maplePacketLittleEndianWriter.write(a4 ? 1 : 0);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter3.write(0);
            maplePacketLittleEndianWriter3.write(0);
        }
        switch (6.a[a3.ordinal()]) {
            case 1: {
                maplePacketLittleEndianWriter.writeShort(1);
                maplePacketLittleEndianWriter.writeShort(a4 ? 1 : 0);
                break;
            }
            case 2: {
                maplePacketLittleEndianWriter.writeShort(0);
                maplePacketLittleEndianWriter.writeShort(a4 ? 1 : 0);
                break;
            }
            case 3: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter5.write(0);
                maplePacketLittleEndianWriter5.write(1);
                maplePacketLittleEndianWriter.writeShort(a4 ? 1 : 0);
                break;
            }
        }
        if (GameSetConstants.MAPLE_VERSION < 134) {
            maplePacketLittleEndianWriter.write(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] summonItemResult(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SUMMON_ITEM_UNAVAILABLE.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] gainForce(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GAIN_FORCE.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            boolean bl = false;
            maplePacketLittleEndianWriter.writeInt(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter.writeInt(a4);
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeInt(Randomizer.rand(15, 29));
            maplePacketLittleEndianWriter4.writeInt(Randomizer.rand(7, 11));
            maplePacketLittleEndianWriter4.writeInt(Randomizer.rand(0, 9));
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.write(0);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] removeItemFromMap(int a2, int a3, int a4) {
        return MaplePacketCreator.removeItemFromMap(a2, a3, a4, 0);
    }

    public static /* synthetic */ byte[] showChinesePVPRank(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CHINESE_PVP_RANKING.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        Object object = MapleRanking.getInstance().getChinesePVPRank();
        if (object != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeInt(object.size());
            maplePacketLittleEndianWriter3.writeZeroBytes(2);
            Object object2 = object = object.iterator();
            while (object2.hasNext()) {
                MapleRanking.chinesePVPRankingInfo chinesePVPRankingInfo2 = (MapleRanking.chinesePVPRankingInfo)object.next();
                object2 = object;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter5.writeMapleAsciiString(chinesePVPRankingInfo2.getName(), 15);
                maplePacketLittleEndianWriter5.writeZeroBytes(12);
                maplePacketLittleEndianWriter4.writeInt(chinesePVPRankingInfo2.getPoints());
                maplePacketLittleEndianWriter4.writeZeroBytes(2);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] dragonBlink(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DRAGON_BLINK.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getTradeInvite(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PLAYER_INTERACTION.getValue());
        maplePacketLittleEndianWriter3.write(PlayerInteraction.\u9080\u8acb\u4ea4\u6613.getValue());
        maplePacketLittleEndianWriter3.write(3);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getName());
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showItemUnavailable() {
        return MaplePacketCreator.getShowInventoryStatus(254);
    }

    public static /* synthetic */ byte[] giveBuff(int a2, int a32, List<Pair<MapleBuffStat, Integer>> a4, MapleStatEffect a5, MapleCharacter a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        boolean bl = false;
        List<Pair<MapleBuffStat, Integer>> list = a4;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.GIVE_BUFF.getValue());
        MaplePacketCreator.ALLATORIxDEMO(maplePacketLittleEndianWriter, list);
        int n2 = -1;
        for (Pair<MapleBuffStat, Integer> pair : list) {
            if (SkillConstants.isEncode4Buff(pair.getLeft())) {
                bl = true;
            }
            if (pair.getLeft() != MapleBuffStat.JUDGMENT_DRAW) continue;
            n2 = pair.getRight();
        }
        Iterator<Pair<MapleBuffStat, Integer>> iterator = a4.iterator();
        Iterator<Pair<MapleBuffStat, Integer>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            Pair<MapleBuffStat, Integer> pair;
            pair = iterator.next();
            if (pair.getLeft().canStack()) {
                iterator2 = iterator;
                continue;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            if (bl) {
                maplePacketLittleEndianWriter3.writeInt(pair.getRight());
                maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            } else {
                maplePacketLittleEndianWriter3.writeShort(pair.getRight());
                maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            }
            maplePacketLittleEndianWriter2.writeInt(a2);
            iterator2 = iterator;
            maplePacketLittleEndianWriter.writeInt(a32);
        }
        if (GameSetConstants.MAPLE_VERSION == 147 && n2 != -1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            if (bl) {
                maplePacketLittleEndianWriter5.writeInt(n2);
                maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            } else {
                maplePacketLittleEndianWriter5.writeShort(n2);
                maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            }
            maplePacketLittleEndianWriter4.writeInt(a2);
            maplePacketLittleEndianWriter.writeInt(a32);
        }
        if (a5 != null && a5.isInflation() && GameSetConstants.MAPLE_VERSION < 152) {
            maplePacketLittleEndianWriter.writeInt(a5.getInflation());
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            List<Pair<MapleBuffStat, Integer>> list2 = a4;
            maplePacketLittleEndianWriter.write(0);
            PacketHelper.handleSpecialBuffStat(maplePacketLittleEndianWriter, a6, list2, a5, a2);
            for (Pair<MapleBuffStat, Integer> pair : list2) {
                if (!pair.getLeft().canStack() || SkillConstants.isSpecialStackBuff(pair.getLeft())) continue;
                Object a32 = a6.getStackBuffInfo(pair.getLeft());
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                if (a32 == null) {
                    maplePacketLittleEndianWriter6.writeInt(0);
                    continue;
                }
                maplePacketLittleEndianWriter6.writeInt(a32.size());
                Object object = a32 = a32.iterator();
                while (object.hasNext()) {
                    Object object2 = a4 = (SpecialBuffInfo)a32.next();
                    maplePacketLittleEndianWriter.writeInt(a4.getBuffStatValueHolder().effect.isSkill() ? object2.getBuffStatValueHolder().effect.getSourceId() : -object2.getBuffStatValueHolder().effect.getSourceId());
                    object = a32;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
                    Object object3 = a4;
                    maplePacketLittleEndianWriter.writeInt(object3.getBuffStatValueHolder().value);
                    maplePacketLittleEndianWriter7.writeInt((int)object3.getBuffStatValueHolder().startTime);
                    maplePacketLittleEndianWriter7.writeInt(a4.getBuffStatValueHolder().localDuration);
                }
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter9.writeShort(0);
        maplePacketLittleEndianWriter9.write(0);
        maplePacketLittleEndianWriter8.write(0);
        maplePacketLittleEndianWriter8.writeZeroBytes(20);
        return maplePacketLittleEndianWriter.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean ALLATORIxDEMO(List<Pair<MapleBuffStat, Integer>> a2) {
        Iterator<Pair<MapleBuffStat, Integer>> iterator = a2.iterator();
        while (iterator.hasNext()) {
            Pair<MapleBuffStat, Integer> pair = iterator.next();
            switch (6.d[pair.getLeft().ordinal()]) {
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
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ byte[] updateSpecialStat(String a2, int a3, int a4, int a5) {
        return MaplePacketCreator.updateSpecialStat(a2, a3, a4, true, a5);
    }

    public static class AntiMacro {
        private static /* synthetic */ byte[] ALLATORIxDEMO(byte a2, byte a3, String a4, File a5, int a6) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LIE_DETECTOR.getValue());
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                a2 = (byte)(a2 + 2);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            } else {
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    a2 = (byte)(a2 + 1);
                }
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
            maplePacketLittleEndianWriter.write(a2);
            maplePacketLittleEndianWriter2.write(a3);
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                a2 = (byte)(a2 - 1);
            }
            if (GameSetConstants.MAPLE_VERSION >= 139) {
                if (a2 == 7) {
                    maplePacketLittleEndianWriter2.write(a6);
                    if (GameSetConstants.MAPLE_VERSION >= 143) {
                        maplePacketLittleEndianWriter2.write(0);
                    }
                    maplePacketLittleEndianWriter2.writeFile(a5);
                }
                if (a2 == 8 || a2 == 10) {
                    // empty if block
                }
                switch (a2) {
                    case 5: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                        while (false) {
                        }
                        maplePacketLittleEndianWriter3.writeMapleAsciiString(a4);
                        return maplePacketLittleEndianWriter3.getPacket();
                    }
                    case 6: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                        maplePacketLittleEndianWriter4.writeMapleAsciiString(a4);
                        return maplePacketLittleEndianWriter4.getPacket();
                    }
                    case 11: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                        maplePacketLittleEndianWriter5.writeMapleAsciiString(a4);
                        return maplePacketLittleEndianWriter5.getPacket();
                    }
                }
                if (a2 != 9) {
                    return maplePacketLittleEndianWriter2.getPacket();
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.writeMapleAsciiString(a4);
                return maplePacketLittleEndianWriter6.getPacket();
            }
            if (a2 != 6) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7;
                if (a2 == 7 || a2 == 9) {
                    // empty if block
                }
                if (a2 == 7 || a2 == 9) {
                    // empty if block
                }
                switch (a2) {
                    case 4: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                        while (false) {
                        }
                        maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter8;
                        maplePacketLittleEndianWriter8.writeMapleAsciiString(a4);
                        break;
                    }
                    case 5: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                        maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter9;
                        maplePacketLittleEndianWriter9.writeMapleAsciiString(a4);
                        break;
                    }
                    case 10: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
                        maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter10;
                        maplePacketLittleEndianWriter10.writeMapleAsciiString(a4);
                        break;
                    }
                    default: {
                        if (a2 != 8) {
                            return maplePacketLittleEndianWriter2.getPacket();
                        }
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter2;
                        maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter11;
                        maplePacketLittleEndianWriter11.writeMapleAsciiString(a4);
                    }
                }
                return maplePacketLittleEndianWriter7.getPacket();
            }
            maplePacketLittleEndianWriter2.write(a6);
            maplePacketLittleEndianWriter2.writeFile(a5);
            if (a3 == 2) {
                // empty if block
            }
            return maplePacketLittleEndianWriter2.getPacket();
        }

        public static /* synthetic */ byte[] success(int a2) {
            return AntiMacro.ALLATORIxDEMO((byte)9, (byte)a2, null, null, 0);
        }

        public static /* synthetic */ byte[] antiMacroNow() {
            return AntiMacro.ALLATORIxDEMO((byte)3, (byte)0, null, null, 0);
        }

        public static /* synthetic */ byte[] alreadyPass() {
            return AntiMacro.ALLATORIxDEMO((byte)2, (byte)0, null, null, 0);
        }

        public static /* synthetic */ byte[] failure(int a2) {
            return AntiMacro.ALLATORIxDEMO((byte)7, (byte)a2, null, null, 0);
        }

        public static /* synthetic */ byte[] nonAttack() {
            return AntiMacro.ALLATORIxDEMO((byte)1, (byte)0, null, null, 0);
        }

        public static /* synthetic */ byte[] getImage(byte a2, File a3, int a4) {
            return AntiMacro.ALLATORIxDEMO((byte)6, a2, null, a3, a4);
        }

        public static /* synthetic */ byte[] antiMsg(int a2, String a3) {
            return AntiMacro.ALLATORIxDEMO((byte)5, (byte)a2, a3, null, 0);
        }

        public static /* synthetic */ byte[] failureScreenshot(String a2) {
            return AntiMacro.ALLATORIxDEMO((byte)8, (byte)2, a2, null, 0);
        }

        public static /* synthetic */ byte[] screenshot(String a2) {
            return AntiMacro.ALLATORIxDEMO((byte)4, (byte)0, a2, null, 0);
        }

        public /* synthetic */ AntiMacro() {
            AntiMacro a2;
        }

        public static /* synthetic */ byte[] cantFindPlayer() {
            return AntiMacro.ALLATORIxDEMO((byte)0, (byte)0, null, null, 0);
        }

        public static /* synthetic */ byte[] successMsg(int a2, String a3) {
            return AntiMacro.ALLATORIxDEMO((byte)10, (byte)a2, a3, null, 0);
        }
    }
}

