/*
 * Decompiled with CFR 0.150.
 */
package server.shark;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import server.life.ItemDropEntry;
import server.shark.SharkPacket;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;
import tools.wztosql.DumpMobName;

public class SharkReader {
    public /* synthetic */ int mBuild;
    private /* synthetic */ List<SharkPacket> B;
    public /* synthetic */ String mPatchLocation;
    private /* synthetic */ long ALLATORIxDEMO;
    public /* synthetic */ int mRemotePort;
    public /* synthetic */ int mLocalPort;
    private static final /* synthetic */ int k = 127;
    private /* synthetic */ int a;
    public /* synthetic */ String mLocalEndpoint;
    public /* synthetic */ String mRemoteEndpoint;
    private final /* synthetic */ File d;
    private static final /* synthetic */ int K = 128;
    public /* synthetic */ int mLocale;

    private /* synthetic */ void ALLATORIxDEMO() {
        LittleEndianAccessor littleEndianAccessor;
        LittleEndianAccessor littleEndianAccessor2;
        SharkReader a2;
        block7: {
            block11: {
                byte by;
                byte by2;
                byte by3;
                byte by4;
                block10: {
                    block9: {
                        block8: {
                            block6: {
                                if (!a2.d.exists()) {
                                    System.out.println(ItemDropEntry.ALLATORIxDEMO("\u659d\u4efb\u4e17\u5b55\u5732"));
                                }
                                littleEndianAccessor2 = new LittleEndianAccessor(new ByteArrayByteStream(SharkReader.getBytes(a2.d)));
                                a2.a = littleEndianAccessor2.readUShort();
                                if (a2.a >= 8192) break block6;
                                LittleEndianAccessor littleEndianAccessor3 = littleEndianAccessor2;
                                littleEndianAccessor = littleEndianAccessor3;
                                a2.mLocalPort = littleEndianAccessor3.readUShort();
                                break block7;
                            }
                            SharkReader sharkReader = a2;
                            by4 = (byte)(sharkReader.a >> 12 & 0xF);
                            by3 = (byte)(sharkReader.a >> 8 & 0xF);
                            by2 = (byte)(sharkReader.a >> 4 & 0xF);
                            by = (byte)(sharkReader.a & 0xF);
                            System.out.println("Loading MSB file, saved by MapleShark V" + by4 + "." + by3 + "." + by2 + "." + by);
                            if (a2.a != 8210) break block8;
                            LittleEndianAccessor littleEndianAccessor4 = littleEndianAccessor2;
                            littleEndianAccessor = littleEndianAccessor4;
                            SharkReader sharkReader2 = a2;
                            sharkReader2.mLocale = littleEndianAccessor2.readUShort();
                            sharkReader2.mBuild = littleEndianAccessor2.readUShort();
                            a2.mLocalPort = littleEndianAccessor4.readUShort();
                            break block7;
                        }
                        if (a2.a != 8212) break block9;
                        LittleEndianAccessor littleEndianAccessor5 = littleEndianAccessor2;
                        littleEndianAccessor = littleEndianAccessor5;
                        SharkReader sharkReader = a2;
                        LittleEndianAccessor littleEndianAccessor6 = littleEndianAccessor2;
                        LittleEndianAccessor littleEndianAccessor7 = littleEndianAccessor2;
                        a2.mLocalEndpoint = littleEndianAccessor7.readAsciiString(a2.ALLATORIxDEMO(littleEndianAccessor7));
                        a2.mLocalPort = littleEndianAccessor2.readUShort();
                        a2.mRemoteEndpoint = littleEndianAccessor6.readAsciiString(a2.ALLATORIxDEMO(littleEndianAccessor2));
                        sharkReader.mRemotePort = littleEndianAccessor6.readUShort();
                        sharkReader.mLocale = littleEndianAccessor2.readUShort();
                        a2.mBuild = littleEndianAccessor5.readUShort();
                        break block7;
                    }
                    if (a2.a != 8213 && a2.a < 8224) break block10;
                    SharkReader sharkReader = a2;
                    LittleEndianAccessor littleEndianAccessor8 = littleEndianAccessor2;
                    LittleEndianAccessor littleEndianAccessor9 = littleEndianAccessor2;
                    a2.mLocalEndpoint = littleEndianAccessor9.readAsciiString(a2.ALLATORIxDEMO(littleEndianAccessor2));
                    a2.mLocalPort = littleEndianAccessor9.readUShort();
                    a2.mRemoteEndpoint = littleEndianAccessor2.readAsciiString(a2.ALLATORIxDEMO(littleEndianAccessor2));
                    a2.mRemotePort = littleEndianAccessor8.readUShort();
                    sharkReader.mLocale = littleEndianAccessor8.readByte();
                    sharkReader.mBuild = littleEndianAccessor2.readUShort();
                    if (a2.a < 8225) break block11;
                    LittleEndianAccessor littleEndianAccessor10 = littleEndianAccessor2;
                    littleEndianAccessor = littleEndianAccessor10;
                    a2.mPatchLocation = littleEndianAccessor10.readAsciiString(a2.ALLATORIxDEMO(littleEndianAccessor2));
                    break block7;
                }
                System.out.println("I have no idea how to open this MSB file. It looks to me as a version " + by4 + "." + by3 + "." + by2 + "." + by + " MapleShark MSB file... O.o?!");
                return;
            }
            littleEndianAccessor = littleEndianAccessor2;
        }
        while (littleEndianAccessor.available() >= (long)(a2.a >= 8224 ? 13 : 12)) {
            LittleEndianAccessor littleEndianAccessor11;
            boolean bl;
            long l2 = littleEndianAccessor2.readLong();
            long l3 = a2.a < 8231 ? (long)littleEndianAccessor2.readUShort() : littleEndianAccessor2.readUInt();
            int n2 = littleEndianAccessor2.readUShort();
            if (a2.a >= 8224) {
                bl = littleEndianAccessor2.readByte() == 1;
                littleEndianAccessor11 = littleEndianAccessor2;
            } else {
                bl = (l3 & 0x8000L) != 0L;
                l3 &= 0x7FFFL;
                littleEndianAccessor11 = littleEndianAccessor2;
            }
            if (littleEndianAccessor11.available() < l3 + (long)(a2.a >= 8229 ? 8 : 0)) {
                System.out.println(DumpMobName.ALLATORIxDEMO("\u527c\u9948\u656d\u648a\u9562\u5ef6\u4e18\u6b33\u78af"));
                return;
            }
            byte[] arrby = littleEndianAccessor2.read((int)l3);
            int n3 = 0;
            int n4 = 0;
            if (a2.a >= 8229) {
                LittleEndianAccessor littleEndianAccessor12 = littleEndianAccessor2;
                n3 = littleEndianAccessor12.readInt();
                n4 = littleEndianAccessor12.readInt();
            }
            a2.B.add(new SharkPacket(arrby, n2, bl, l2));
            littleEndianAccessor = littleEndianAccessor2;
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 1 << 1;
        int cfr_ignored_0 = 2 << 3 ^ 3;
        int n5 = n3;
        int n6 = 4 << 4 ^ 3;
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

    public static /* synthetic */ byte[] getBytes(File a2) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        byte[] arrby = null;
        try {
            int n2;
            fileInputStream = new FileInputStream(a2);
            byteArrayOutputStream = new ByteArrayOutputStream((int)a2.length());
            byte[] arrby2 = new byte[(int)a2.length()];
            FileInputStream fileInputStream2 = fileInputStream;
            while ((n2 = fileInputStream2.read(arrby2)) != -1) {
                fileInputStream2 = fileInputStream;
                byteArrayOutputStream.write(arrby2, 0, n2);
            }
        }
        catch (Exception exception) {
            return arrby;
        }
        fileInputStream.close();
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        byteArrayOutputStream2.close();
        arrby = byteArrayOutputStream2.toByteArray();
        return arrby;
    }

    public /* synthetic */ SharkReader(File a2) {
        SharkReader a3;
        SharkReader sharkReader = a3;
        SharkReader sharkReader2 = a3;
        SharkReader sharkReader3 = a3;
        SharkReader sharkReader4 = a3;
        SharkReader sharkReader5 = a3;
        sharkReader5.B = new ArrayList<SharkPacket>();
        sharkReader4.a = 0;
        sharkReader4.mLocalPort = 0;
        sharkReader3.mRemotePort = 0;
        sharkReader3.mLocale = 0;
        sharkReader2.mBuild = 0;
        sharkReader2.mLocalEndpoint = "";
        sharkReader.mRemoteEndpoint = "";
        sharkReader.mPatchLocation = "";
        a3.ALLATORIxDEMO = 0L;
        a3.d = a2;
        a3.ALLATORIxDEMO();
    }

    private /* synthetic */ int ALLATORIxDEMO(LittleEndianAccessor a2) {
        int n2 = 0;
        byte by = a2.readByte();
        n2 += by & 0x7F;
        if ((by & 0x80) == 0) {
            return n2;
        }
        by = a2.readByte();
        n2 += (by & 0x7F) << 7;
        if ((by & 0x80) == 0) {
            return n2;
        }
        by = a2.readByte();
        n2 += (by & 0x7F) << 14;
        if ((by & 0x80) == 0) {
            return n2;
        }
        by = a2.readByte();
        n2 += (by & 0x7F) << 21;
        if ((by & 0x80) == 0) {
            return n2;
        }
        by = a2.readByte();
        return n2 += (by & 0x7F) << 28;
    }

    public /* synthetic */ long available() {
        SharkReader a2;
        return (long)a2.B.size() - a2.ALLATORIxDEMO;
    }

    public /* synthetic */ SharkPacket read() {
        SharkReader a2;
        if (a2.available() <= 0L) {
            System.out.println(ItemDropEntry.ALLATORIxDEMO("\u5273\u9915\u6562\u64d7\u531f\u4e00\u8da9"));
            return null;
        }
        return a2.B.get((int)a2.ALLATORIxDEMO++);
    }
}

