/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import handling.SendPacketOpcode;
import handling.opcodes.SpecialEffect;
import tools.data.MaplePacketLittleEndianWriter;

public class MonsterBookPacket {
    public /* synthetic */ MonsterBookPacket() {
        MonsterBookPacket a2;
    }

    public static /* synthetic */ byte[] showForeginCardEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SHOW_FOREIGN_EFFECT.getValue());
        maplePacketLittleEndianWriter.writeInt(a2);
        maplePacketLittleEndianWriter2.write(SpecialEffect.PICKUP_MONSTER_CARD.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] changeCover(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MONSTERBOOK_CHANGE_COVER.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showGainCard(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.write(2);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showCardEffect() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter.write(SpecialEffect.PICKUP_MONSTER_CARD.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] addCard(boolean a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MONSTERBOOK_ADD.getValue());
        if (!a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter2.write(1);
            maplePacketLittleEndianWriter3.writeInt(a3);
            maplePacketLittleEndianWriter3.writeInt(a4);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }
}

