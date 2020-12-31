/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.MapleCharacter;
import client.MapleStat;
import client.inventory.IItem;
import client.inventory.MaplePet;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import server.movement.LifeMovementFragment;
import tools.MaplePacketCreator;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;

/*
 * Exception performing whole class analysis ignored.
 */
public class PetPacket {
    private static final /* synthetic */ byte[] ALLATORIxDEMO;

    public static final /* synthetic */ byte[] petChat(int a2, int a3, String a4, byte a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PET_CHAT.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.write(a5);
        maplePacketLittleEndianWriter3.write(a3);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] emptyStatUpdate() {
        return MaplePacketCreator.enableActions();
    }

    public /* synthetic */ PetPacket() {
        PetPacket a2;
    }

    public static final /* synthetic */ byte[] showPet(MapleCharacter a2, MaplePet a3, boolean a4, boolean a5, boolean a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(a6 ? SendPacketOpcode.PET_UPDATE.getValue() : SendPacketOpcode.SPAWN_PET.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(a2.getPetIndex(a3));
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(a2.getPetIndex(a3));
        }
        maplePacketLittleEndianWriter.write(a4 ? 0 : 1);
        maplePacketLittleEndianWriter2.write(a4 && a5 ? 1 : 0);
        if (!a4) {
            PetPacket.addPetInfo(maplePacketLittleEndianWriter2, a2, a3, false);
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void addPetInfo(MaplePacketLittleEndianWriter a, MapleCharacter a, MaplePet a, boolean a) {
        if (!a) ** GOTO lbl9
        a.write(1);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            v0 = a;
            v1 = v0;
            v0.writeInt(a.getPetIndex(a));
        } else {
            a.write(a.getPetIndex(a));
lbl9:
            // 2 sources

            v1 = a;
        }
        v1.writeInt(a.getPetItemId());
        a = a.getName();
        if (a == null) {
            a = "";
        }
        v2 = a;
        v3 = a;
        v4 = a;
        v5 = a;
        a.writeMapleAsciiString((String)a);
        a.writeLong(v5.getUniqueId());
        v4.writeShort(v5.getPos().x);
        v4.writeShort(a.getPos().y - 20);
        v2.write(v3.getStance());
        v2.writeShort(v3.getFh());
        if (GameSetConstants.MAPLE_VERSION < 152) return;
        a.writeInt(a.getColor());
    }

    public static final /* synthetic */ byte[] loadExceptionList(MapleCharacter a2, MaplePet a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PET_LOAD_EXCEPTIONLIST.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a2.getPetIndex((MaplePet)((Object)a3)));
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.write(a2.getPetIndex((MaplePet)((Object)a3)));
        }
        maplePacketLittleEndianWriter.writeLong(((MaplePet)((Object)a3)).getUniqueId());
        Iterator iterator = a3 = ((MaplePet)((Object)a3)).getExcluded();
        maplePacketLittleEndianWriter2.write(iterator.size());
        Iterator iterator2 = a3 = iterator.iterator();
        while (iterator2.hasNext()) {
            Integer n2 = (Integer)a3.next();
            iterator2 = a3;
            maplePacketLittleEndianWriter2.writeInt(n2);
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] petStatUpdate(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.UPDATE_STATS.getValue());
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION == 75) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.writeLong(MapleStat.PET.getValue());
        } else {
            maplePacketLittleEndianWriter.writeInt((int)MapleStat.PET.getValue());
        }
        int n2 = 0;
        for (MaplePet maplePet : a2.getSummonedPets()) {
            if (!maplePet.getSummoned()) continue;
            maplePacketLittleEndianWriter.writeLong(maplePet.getUniqueId());
            n2 = (byte)(n2 + 1);
        }
        int n3 = n2;
        while (n3 < 3) {
            maplePacketLittleEndianWriter.writeZeroBytes(8);
            n3 = n2 = (int)((byte)(n2 + 1));
        }
        maplePacketLittleEndianWriter.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] movePet(int a2, int a3, Point a4, List<LifeMovementFragment> a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.MOVE_PET.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writePos(a4);
        maplePacketLittleEndianWriter2.writeInt(0);
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter2, a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] petTrain(MapleCharacter a2, MaplePet a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.PET_TRAIN.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter3.writeInt(a3.getSkill());
        maplePacketLittleEndianWriter2.writeInt(0);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ {
        byte[] arrby = new byte[2];
        arrby[0] = -128;
        arrby[1] = 5;
        ALLATORIxDEMO = arrby;
    }

    public static final /* synthetic */ byte[] movePet(int a2, int a3, byte a4, List<LifeMovementFragment> a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MOVE_PET.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter2.writeInt(a3);
        PacketHelper.serializeMovementList(maplePacketLittleEndianWriter2, a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] showPetUpdate(MapleCharacter a2, MaplePet a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePet maplePet = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PET_UPDATE.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter.writeInt(a2.getPetIndex(maplePet));
        maplePacketLittleEndianWriter2.writeLong(maplePet.getUniqueId());
        a3 = ((MaplePet)((Object)a3)).getExcluded();
        maplePacketLittleEndianWriter2.write(a3.size());
        Iterator iterator = a3 = a3.iterator();
        while (iterator.hasNext()) {
            Integer n2 = (Integer)a3.next();
            iterator = a3;
            maplePacketLittleEndianWriter.writeInt(n2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] commandResponse(int a2, byte a3, byte a4, boolean a5, boolean a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a6 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PET_COMMAND.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a6;
            maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a4);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a6;
            maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.write(a4);
        }
        maplePacketLittleEndianWriter2.write(a3 == 1 ? 1 : 0);
        byte by = a3;
        a6.write(by);
        if (by == 1) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a6;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
            maplePacketLittleEndianWriter6.write(0);
        } else {
            a6.writeShort(a5 ? 1 : 0);
            maplePacketLittleEndianWriter = a6;
        }
        maplePacketLittleEndianWriter.writeInt(a7);
        return a6.getPacket();
    }

    public static final /* synthetic */ byte[] removePet(MapleCharacter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_PET.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        maplePacketLittleEndianWriter2.writeShort(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] showPetLevelUp(MapleCharacter a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        maplePacketLittleEndianWriter3.write(GameSetConstants.MAPLE_VERSION >= 134 ? 6 : 4);
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a3);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.write(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] updatePet(MaplePet a2, IItem a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MODIFY_INVENTORY_ITEM.getValue());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.write(2);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter.write(0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.write(3);
        maplePacketLittleEndianWriter7.write(5);
        maplePacketLittleEndianWriter7.writeShort(a2.getInventoryPosition());
        maplePacketLittleEndianWriter6.write(0);
        maplePacketLittleEndianWriter6.write(5);
        maplePacketLittleEndianWriter5.writeShort(a2.getInventoryPosition());
        maplePacketLittleEndianWriter5.write(3);
        maplePacketLittleEndianWriter4.writeInt(a2.getPetItemId());
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter3.writeLong(a2.getUniqueId());
        PacketHelper.addPetItemInfo(maplePacketLittleEndianWriter3, a3, a2, a4);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] showOwnPetLevelUp(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(GameSetConstants.MAPLE_VERSION >= 134 ? 6 : 4);
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(a2);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] petStatUpdate_Empty() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_STATS.getValue());
        maplePacketLittleEndianWriter3.write(0);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeLong(MapleStat.PET.getValue());
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.writeInt((int)MapleStat.PET.getValue());
        }
        maplePacketLittleEndianWriter.writeZeroBytes(25);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] removePet(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SPAWN_PET.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a3);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.write(a3);
        }
        maplePacketLittleEndianWriter.writeShort(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }
}

