/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.MapleCharacter;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import server.MapleCarnivalParty;
import tools.data.MaplePacketLittleEndianWriter;

public class MonsterCarnivalPacket {
    public static /* synthetic */ byte[] playerSummoned(String a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MONSTER_CARNIVAL_SUMMON.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
            maplePacketLittleEndianWriter3.writeInt(0);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.write(a3);
            maplePacketLittleEndianWriter5.write(a4);
            maplePacketLittleEndianWriter5.writeMapleAsciiString(a2);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] startMonsterCarnival(MapleCharacter a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MONSTER_CARNIVAL_START.getValue());
        MapleCarnivalParty mapleCarnivalParty = a2.getCarnivalParty();
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            MapleCarnivalParty mapleCarnivalParty2 = mapleCarnivalParty;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeInt(a2.getAvailableCP());
            maplePacketLittleEndianWriter4.writeInt(a2.getTotalCP());
            maplePacketLittleEndianWriter2.writeInt(mapleCarnivalParty2.getAvailableCP());
            maplePacketLittleEndianWriter3.writeInt(mapleCarnivalParty2.getTotalCP());
            maplePacketLittleEndianWriter3.writeLong(0L);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.write(mapleCarnivalParty.getTeam());
            maplePacketLittleEndianWriter8.writeShort(a2.getAvailableCP());
            maplePacketLittleEndianWriter8.writeShort(a2.getTotalCP());
            maplePacketLittleEndianWriter7.writeShort(mapleCarnivalParty.getAvailableCP());
            maplePacketLittleEndianWriter7.writeShort(mapleCarnivalParty.getTotalCP());
            maplePacketLittleEndianWriter6.writeShort(a3);
            maplePacketLittleEndianWriter6.writeShort(a4);
            maplePacketLittleEndianWriter5.writeLong(0L);
            maplePacketLittleEndianWriter5.writeShort(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] CPUpdate(boolean a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        if (!a2) {
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MONSTER_CARNIVAL_OBTAINED_CP.getValue());
        } else {
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MONSTER_CARNIVAL_PARTY_CP.getValue());
            if (GameSetConstants.MAPLE_VERSION < 143) {
                maplePacketLittleEndianWriter2.write(a5);
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 143) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(a3);
            maplePacketLittleEndianWriter3.writeInt(a4);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeShort(a3);
            maplePacketLittleEndianWriter4.writeShort(a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public /* synthetic */ MonsterCarnivalPacket() {
        MonsterCarnivalPacket a2;
    }

    public static /* synthetic */ byte[] playerDiedMessage(String a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MONSTER_CARNIVAL_DIED.getValue());
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }
}

