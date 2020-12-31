/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.inventory.MapleAndroid;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import server.buffs.AbstractBuffClass;
import tools.HexTool;
import tools.data.MaplePacketLittleEndianWriter;

public class LoadPacket {
    public static /* synthetic */ byte[] getPacket() {
        Object object;
        Properties properties = new Properties();
        try {
            object = new FileReader(MapleAndroid.ALLATORIxDEMO("\u5105\u4ec1\\\u6e3b\u8a15\u656f\u64a9\u5312]c\u000bc"));
            FileReader fileReader = object;
            properties.load(fileReader);
            fileReader.close();
        }
        catch (IOException iOException) {
            System.err.println(AbstractBuffClass.ALLATORIxDEMO("\u8b9e\u53c3>\u6e39\u8a78\u656d\u64c4\u53100afa>\u5924\u6549"));
        }
        object = new MaplePacketLittleEndianWriter();
        ((MaplePacketLittleEndianWriter)object).write(HexTool.getByteArrayFromHexString(properties.getProperty(MapleAndroid.ALLATORIxDEMO("\u0003v\u0010|\u0016c"))));
        return ((MaplePacketLittleEndianWriter)object).getPacket();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 3;
        int cfr_ignored_0 = 2 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ (2 ^ 5);
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

    public /* synthetic */ LoadPacket() {
        LoadPacket a2;
    }
}

