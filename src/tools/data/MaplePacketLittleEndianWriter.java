/*
 * Decompiled with CFR 0.150.
 */
package tools.data;

import client.MapleFriendship;
import constants.ServerConstants;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import tools.HexTool;

public class MaplePacketLittleEndianWriter {
    private final /* synthetic */ ByteArrayOutputStream d;
    private static final /* synthetic */ Charset ALLATORIxDEMO;

    public final /* synthetic */ void write(int a2) {
        MaplePacketLittleEndianWriter a3;
        a3.ALLATORIxDEMO((byte)a2);
    }

    public final /* synthetic */ void writeMapleAsciiString(String a2, int a3) {
        MaplePacketLittleEndianWriter a4;
        if (a2.getBytes(ALLATORIxDEMO).length > a3) {
            a2 = a2.substring(0, a3);
        }
        a4.writeShort((short)a2.getBytes(ALLATORIxDEMO).length);
        String string = a2;
        a4.write(string.getBytes(ALLATORIxDEMO));
        int n2 = a2 = string.getBytes(ALLATORIxDEMO).length;
        while (n2 < a3) {
            a4.ALLATORIxDEMO((byte)0);
            n2 = ++a2;
        }
    }

    public final /* synthetic */ void writePos(Point a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        maplePacketLittleEndianWriter.writeShort(a2.x);
        maplePacketLittleEndianWriter.writeShort(a2.y);
    }

    public final /* synthetic */ void write(boolean a2) {
        MaplePacketLittleEndianWriter a3;
        a3.ALLATORIxDEMO((byte)(a2 ? 1 : 0));
    }

    public /* synthetic */ void writeReversedInt(long a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        long l2 = a2;
        a3.ALLATORIxDEMO((byte)(a2 >>> 32 & 0xFFL));
        a3.ALLATORIxDEMO((byte)(l2 >>> 40 & 0xFFL));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(l2 >>> 48 & 0xFFL));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(a2 >>> 56 & 0xFFL));
    }

    public final /* synthetic */ void writeAsciiString(String a2) {
        MaplePacketLittleEndianWriter a3;
        a3.write(a2.getBytes(ALLATORIxDEMO));
    }

    public final /* synthetic */ byte[] getPacket() {
        MaplePacketLittleEndianWriter a2;
        return a2.d.toByteArray();
    }

    public final /* synthetic */ String toString() {
        MaplePacketLittleEndianWriter a2;
        return HexTool.toString(a2.d.toByteArray());
    }

    public final /* synthetic */ void writeAsciiString(String a2, int a3) {
        MaplePacketLittleEndianWriter a4;
        if (a2.getBytes(ALLATORIxDEMO).length > a3) {
            a2 = a2.substring(0, a3);
        }
        a4.write(a2.getBytes(ALLATORIxDEMO));
        int n2 = a2 = a2.getBytes(ALLATORIxDEMO).length;
        while (n2 < a3) {
            a4.ALLATORIxDEMO((byte)0);
            n2 = ++a2;
        }
    }

    public final /* synthetic */ void writeLong(long a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        long l2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3;
        long l3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a3;
        maplePacketLittleEndianWriter3.ALLATORIxDEMO((byte)(a2 & 0xFFL));
        maplePacketLittleEndianWriter3.ALLATORIxDEMO((byte)(a2 >>> 8 & 0xFFL));
        a3.ALLATORIxDEMO((byte)(l3 >>> 16 & 0xFFL));
        maplePacketLittleEndianWriter2.ALLATORIxDEMO((byte)(l3 >>> 24 & 0xFFL));
        maplePacketLittleEndianWriter2.ALLATORIxDEMO((byte)(a2 >>> 32 & 0xFFL));
        a3.ALLATORIxDEMO((byte)(l2 >>> 40 & 0xFFL));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(l2 >>> 48 & 0xFFL));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(a2 >>> 56 & 0xFFL));
    }

    private /* synthetic */ void ALLATORIxDEMO(byte a2) {
        MaplePacketLittleEndianWriter a3;
        a3.d.write(a2);
    }

    public final /* synthetic */ void writeBoolean(boolean a2) {
        MaplePacketLittleEndianWriter a3;
        a3.ALLATORIxDEMO((byte)(a2 ? 1 : 0));
    }

    public final /* synthetic */ void writeNullTerminatedCharString(String a2) {
        int n2;
        byte[] arrby = ((String)a2).getBytes(ALLATORIxDEMO);
        a2 = arrby;
        int n3 = arrby.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MaplePacketLittleEndianWriter a3;
            Object object = a2[n2];
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
            maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)object);
            maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)0);
            n4 = ++n2;
        }
    }

    public final /* synthetic */ void writeRect(Rectangle a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        Rectangle rectangle = a2;
        a3.writeInt(a2.x);
        a3.writeInt(rectangle.y);
        maplePacketLittleEndianWriter.writeInt(rectangle.x + a2.width);
        maplePacketLittleEndianWriter.writeInt(a2.y + a2.height);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = Charset.forName(ServerConstants.MAPLE_TYPE.getANSI());
    }

    public /* synthetic */ MaplePacketLittleEndianWriter() {
        a2(32);
        MaplePacketLittleEndianWriter a2;
    }

    public final /* synthetic */ void writeMapleAsciiString(String a2) {
        MaplePacketLittleEndianWriter a3;
        a3.writeShort((short)a2.getBytes(ALLATORIxDEMO).length);
        a3.writeAsciiString(a2);
    }

    public final /* synthetic */ void writeInt(int a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        int n2 = a2;
        a3.ALLATORIxDEMO((byte)(a2 & 0xFF));
        a3.ALLATORIxDEMO((byte)(n2 >>> 8 & 0xFF));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(n2 >>> 16 & 0xFF));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(a2 >>> 24 & 0xFF));
    }

    public final /* synthetic */ void writeShort(int a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(a2 & 0xFF));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(a2 >>> 8 & 0xFF));
    }

    public final /* synthetic */ void writeZeroBytes(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2) {
            MaplePacketLittleEndianWriter a3;
            a3.ALLATORIxDEMO((byte)0);
            n3 = ++n2;
        }
    }

    public final /* synthetic */ void writeReversedLong(long a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        long l2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a3;
        long l3 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a3;
        maplePacketLittleEndianWriter3.ALLATORIxDEMO((byte)(a2 >>> 32 & 0xFFL));
        maplePacketLittleEndianWriter3.ALLATORIxDEMO((byte)(a2 >>> 40 & 0xFFL));
        a3.ALLATORIxDEMO((byte)(l3 >>> 48 & 0xFFL));
        maplePacketLittleEndianWriter2.ALLATORIxDEMO((byte)(l3 >>> 56 & 0xFFL));
        maplePacketLittleEndianWriter2.ALLATORIxDEMO((byte)(a2 & 0xFFL));
        a3.ALLATORIxDEMO((byte)(l2 >>> 8 & 0xFFL));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(l2 >>> 16 & 0xFFL));
        maplePacketLittleEndianWriter.ALLATORIxDEMO((byte)(a2 >>> 24 & 0xFFL));
    }

    public final /* synthetic */ void write(byte a2) {
        MaplePacketLittleEndianWriter a3;
        a3.ALLATORIxDEMO(a2);
    }

    public final /* synthetic */ void write(byte[] a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            MaplePacketLittleEndianWriter a3;
            a3.ALLATORIxDEMO(a2[n2++]);
            n3 = n2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void writeFile(File a) {
        var2_2 = new byte[]{};
        if (a == null || !a.exists()) ** GOTO lbl40
        var3_3 = a.length();
        if (var3_3 > 0x7FFFFFFFL) {
            System.err.println(MapleFriendship.ALLATORIxDEMO("\u6abf\u6850\u5901\u593f"));
            v0 = a;
        } else {
            var2_2 = new byte[(int)var3_3];
            var4_5 = 0;
            try {
                var6_6 = new FileInputStream(a);
                try {
                    for (var3_4 = 0; var3_4 < var2_2.length && (var4_5 = var6_6.read(var2_2, var3_4, var2_2.length - var3_4)) >= 0; var3_4 += var4_5) {
                    }
                }
                catch (Throwable var5_8) {
                    try {
                        var6_6.close();
                        v1 = var5_8;
                        throw v1;
                    }
                    catch (Throwable var7_9) {
                        v2 = var5_8;
                        v1 = v2;
                        v2.addSuppressed(var7_9);
                    }
                    throw v1;
                }
                var6_6.close();
            }
            catch (IOException var6_7) {
                System.err.println("\u8b80\u53d6\u6a94\u6848\u5931\u6557:" + var6_7);
                var2_2 = new byte[]{};
            }
            if (var3_4 < var2_2.length) {
                System.err.println("\u7121\u6cd5\u5b8c\u6574\u8b80\u53d6\u6a94\u6848:" + a.getName());
                var2_2 = new byte[]{};
            }
lbl40:
            // 4 sources

            v0 = a;
        }
        v0.writeInt(var2_2.length);
        a.write(var2_2);
    }

    public /* synthetic */ MaplePacketLittleEndianWriter(int a2) {
        MaplePacketLittleEndianWriter a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        maplePacketLittleEndianWriter.d = new ByteArrayOutputStream(a2);
    }
}

