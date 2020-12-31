/*
 * Decompiled with CFR 0.150.
 */
package server.shark;

import client.MapleClient;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.MobConstants;
import constants.ServerConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import server.shark.SharkPacket;
import tools.data.MaplePacketLittleEndianWriter;

public class SharkLogger {
    private final /* synthetic */ MapleClient ALLATORIxDEMO;
    private /* synthetic */ List<SharkPacket> k;
    private final /* synthetic */ int d;
    private static final /* synthetic */ int K = 127;
    private static final /* synthetic */ int a = 128;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void dump() {
        SharkLogger sharkLogger;
        Object object;
        SharkLogger sharkLogger2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        int n2;
        SharkLogger a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        SharkLogger sharkLogger3 = a2;
        Object object2 = sharkLogger3.ALLATORIxDEMO.getSession().remoteAddress().toString().replace("/", "");
        switch (sharkLogger3.ALLATORIxDEMO.getChannel()) {
            case -1: {
                n2 = 5555;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                break;
            }
            case 0: {
                n2 = GameSetConstants.LOGIN_PORT;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                break;
            }
            default: {
                n2 = a2.ALLATORIxDEMO.getChannelServer().getPort();
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        maplePacketLittleEndianWriter.writeShort(a2.d);
        if (a2.d == 8210) {
            sharkLogger2 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.writeShort(ServerConstants.MAPLE_TYPE.getType());
            maplePacketLittleEndianWriter3.writeShort(GameSetConstants.MAPLE_VERSION);
            maplePacketLittleEndianWriter3.writeShort(Integer.parseInt(((String)object2).split(MapConstants.ALLATORIxDEMO("\""))[1]));
        } else if (a2.d == 8212) {
            SharkLogger sharkLogger4 = a2;
            sharkLogger4.ALLATORIxDEMO(((String)object2).length(), maplePacketLittleEndianWriter2);
            maplePacketLittleEndianWriter2.writeAsciiString((String)object2);
            maplePacketLittleEndianWriter2.writeShort(Integer.parseInt(((String)object2).split(MobConstants.ALLATORIxDEMO("\u000e"))[1]));
            sharkLogger4.ALLATORIxDEMO((ServerConstants.getHostAddress() + ":" + n2).length(), maplePacketLittleEndianWriter2);
            maplePacketLittleEndianWriter2.writeAsciiString(ServerConstants.getHostAddress() + ":" + n2);
            sharkLogger2 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter4.writeShort(n2);
            maplePacketLittleEndianWriter4.writeShort(ServerConstants.MAPLE_TYPE.getType());
            maplePacketLittleEndianWriter4.writeShort(GameSetConstants.MAPLE_VERSION);
        } else {
            if (a2.d == 8213 || a2.d >= 8224) {
                String string = object2;
                a2.ALLATORIxDEMO(string.length(), maplePacketLittleEndianWriter2);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter5.writeAsciiString((String)object2);
                maplePacketLittleEndianWriter5.writeShort(Integer.parseInt(string.split(MapConstants.ALLATORIxDEMO("\""))[1]));
                a2.ALLATORIxDEMO((ServerConstants.getHostAddress() + ":" + n2).length(), maplePacketLittleEndianWriter2);
                maplePacketLittleEndianWriter2.writeAsciiString(ServerConstants.getHostAddress() + ":" + n2);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.writeShort(n2);
                maplePacketLittleEndianWriter6.write(ServerConstants.MAPLE_TYPE.getType());
                maplePacketLittleEndianWriter6.writeShort(GameSetConstants.MAPLE_VERSION);
                if (a2.d >= 8225) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                    a2.ALLATORIxDEMO(GameSetConstants.MAPLE_PATCH.length(), maplePacketLittleEndianWriter7);
                    maplePacketLittleEndianWriter7.writeAsciiString(GameSetConstants.MAPLE_PATCH);
                }
            }
            sharkLogger2 = a2;
        }
        Object object3 = object2 = sharkLogger2.k.iterator();
        while (object3.hasNext()) {
            SharkPacket sharkPacket = (SharkPacket)object2.next();
            object3 = object2;
            sharkPacket.dump(maplePacketLittleEndianWriter2, a2.d);
        }
        if (a2.ALLATORIxDEMO.getPlayer() != null) {
            object = a2.ALLATORIxDEMO.getPlayer().getName() + "_";
            sharkLogger = a2;
        } else {
            object = "";
            sharkLogger = a2;
        }
        object2 = new File("logs/\u6953\u9bca\u6a94\u6848/" + (String)object + sharkLogger.ALLATORIxDEMO.getClientKey() + ".msb");
        if (((File)object2).getParentFile() != null) {
            ((File)object2).getParentFile().mkdirs();
        }
        try {
            ((File)object2).createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream((File)object2);
            try {
                FileOutputStream fileOutputStream2 = fileOutputStream;
                fileOutputStream2.write(maplePacketLittleEndianWriter2.getPacket());
                fileOutputStream2.flush();
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                try {
                    fileOutputStream.close();
                    throwable2 = throwable;
                    throw throwable2;
                }
                catch (Throwable throwable3) {
                    Throwable throwable4 = throwable;
                    throwable2 = throwable4;
                    throwable4.addSuppressed(throwable3);
                }
                throw throwable2;
            }
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            System.out.println("Ex" + iOException);
        }
        a2.k.clear();
    }

    public /* synthetic */ void log(SharkPacket a2) {
        SharkLogger a3;
        a3.k.add(a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(int a2, MaplePacketLittleEndianWriter a3) {
        if ((a2 & 0xFFFFFF80) == 0) {
            a3.write((byte)(a2 & 0x7F));
            return;
        }
        a3.write((byte)(a2 & 0x7F | 0x80));
        if ((a2 & 0xFFFFC000) == 0) {
            a3.write((byte)(a2 >>> 7 & 0x7F));
            return;
        }
        a3.write((byte)(a2 >>> 7 & 0x7F | 0x80));
        if ((a2 & 0xFFE00000) == 0) {
            a3.write((byte)(a2 >>> 14 & 0x7F));
            return;
        }
        a3.write((byte)(a2 >>> 14 & 0x7F | 0x80));
        if ((a2 & 0xF0000000) == 0) {
            a3.write((byte)(a2 >>> 21 & 0x7F));
            return;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        int n2 = a2;
        maplePacketLittleEndianWriter.write((byte)(n2 >>> 21 & 0x7F | 0x80));
        maplePacketLittleEndianWriter.write((byte)(n2 >>> 28 & 0x7F));
    }

    public /* synthetic */ SharkLogger(int a2, MapleClient a3) {
        SharkLogger a4;
        SharkLogger sharkLogger = a4;
        SharkLogger sharkLogger2 = a4;
        sharkLogger2.k = new ArrayList<SharkPacket>();
        sharkLogger.d = a2;
        sharkLogger.ALLATORIxDEMO = a3;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 4;
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ 1;
        int n5 = n3;
        int n6 = 4 << 3 ^ 1;
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
}

