/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import handling.SendPacketOpcode;
import handling.channel.handler.BeanGame;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;

public class BeansPacket {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 4 ^ 1 << 1;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ (2 << 2 ^ 1);
        int n5 = n3;
        int n6 = 4 << 3 ^ 5;
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

    public /* synthetic */ BeansPacket() {
        BeansPacket a2;
    }

    public static /* synthetic */ byte[] rewardBalls(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        maplePacketLittleEndianWriter3.write(5);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] rewardBalls(int a2) {
        return BeansPacket.rewardBalls(a2, 0);
    }

    public static /* synthetic */ byte[] BallGift(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.DONATE_BEANS.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] exitBeans() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        maplePacketLittleEndianWriter2.write(6);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] marqueeMessage(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PACHINKO_MARQUEE.getValue());
        int n2 = 1;
        maplePacketLittleEndianWriter2.writeInt(1);
        int n3 = n2;
        while (n3 > 0) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
            n3 = --n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] setLightLevel(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        maplePacketLittleEndianWriter2.write(3);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updateBalls(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.UPDATE_BEANS.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spinTest(int a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PACHINKO_ACT.getValue());
        maplePacketLittleEndianWriter3.write(4);
        maplePacketLittleEndianWriter2.write(a2);
        Pair<Integer, Integer> pair = BeanGame.getSpinResult(a3);
        maplePacketLittleEndianWriter.write(Byte.parseByte(((Object)pair.getLeft()).toString()));
        maplePacketLittleEndianWriter2.write(Byte.parseByte(((Object)pair.getRight()).toString()));
        maplePacketLittleEndianWriter.write(3);
        maplePacketLittleEndianWriter.write(1);
        maplePacketLittleEndianWriter.write(a3 ? 255 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(1);
        maplePacketLittleEndianWriter4.write(1);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] showBeans(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PACHINKO_SHOW.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }
}

