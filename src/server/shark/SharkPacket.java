/*
 * Decompiled with CFR 0.150.
 */
package server.shark;

import java.util.Arrays;
import tools.data.MaplePacketLittleEndianWriter;

public class SharkPacket {
    private /* synthetic */ boolean ALLATORIxDEMO;
    public final /* synthetic */ byte[] info;
    private final /* synthetic */ long d;
    public /* synthetic */ int opcode;
    public final /* synthetic */ boolean outbound;

    public /* synthetic */ SharkPacket(byte[] a22, boolean a3) {
        SharkPacket a4;
        SharkPacket sharkPacket = a4;
        a4.ALLATORIxDEMO = false;
        sharkPacket.info = a22;
        sharkPacket.d = System.currentTimeMillis();
        sharkPacket.outbound = a3;
        try {
            a4.opcode = (short)(((a22[1] & 0xFF) << 8) + (a22[0] & 0xFF));
            return;
        }
        catch (ArrayIndexOutOfBoundsException a22) {
            SharkPacket sharkPacket2 = a4;
            sharkPacket2.opcode = -1;
            sharkPacket2.ALLATORIxDEMO = true;
            return;
        }
    }

    public /* synthetic */ void dump(MaplePacketLittleEndianWriter a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        SharkPacket a4;
        if (a4.ALLATORIxDEMO) {
            return;
        }
        int n2 = a4.info.length - 2;
        if (a3 < 8224 && a4.outbound) {
            n2 |= 0x8000;
        }
        a2.writeLong(a4.d);
        if (a3 >= 8231) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeInt(n2);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(n2);
        }
        maplePacketLittleEndianWriter.writeShort(a4.opcode);
        if (a3 >= 8224) {
            a2.write(a4.outbound);
        }
        if (a4.info.length > 2) {
            a2.write(Arrays.copyOfRange(a4.info, 2, a4.info.length));
        }
        if (a3 >= 8229) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
            maplePacketLittleEndianWriter4.writeInt(0);
            maplePacketLittleEndianWriter4.writeInt(0);
        }
    }

    public /* synthetic */ SharkPacket(byte[] a2, int a3, boolean a4, long a5) {
        SharkPacket a6;
        SharkPacket sharkPacket = a6;
        SharkPacket sharkPacket2 = a6;
        a6.ALLATORIxDEMO = false;
        sharkPacket2.info = a2;
        sharkPacket2.d = a5;
        sharkPacket.outbound = a4;
        sharkPacket.opcode = a3;
    }
}

