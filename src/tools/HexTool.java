/*
 * Decompiled with CFR 0.150.
 */
package tools;

import handling.world.CheaterData;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import server.shops.MaplePlayerShopItem;
import tools.StringUtil;

public class HexTool {
    private static final /* synthetic */ char[] ALLATORIxDEMO;

    public static final /* synthetic */ String getOpcodeToString(int a2) {
        return "0x" + StringUtil.getLeftPaddedStr(Integer.toHexString(a2).toUpperCase(), '0', 4);
    }

    public static final /* synthetic */ String toString(ByteBuffer a2) {
        a2.flip();
        ByteBuffer byteBuffer = a2;
        byte[] arrby = new byte[byteBuffer.remaining()];
        byteBuffer.get(arrby);
        String string = HexTool.toString(arrby);
        a2.flip();
        a2.put(arrby);
        return string;
    }

    public static final /* synthetic */ String toString(int a2) {
        return Integer.toHexString(a2);
    }

    public static /* synthetic */ {
        char[] arrc = new char[16];
        arrc[0] = 48;
        arrc[1] = 49;
        arrc[2] = 50;
        arrc[3] = 51;
        arrc[4] = 52;
        arrc[5] = 53;
        arrc[6] = 54;
        arrc[7] = 55;
        arrc[8] = 56;
        arrc[9] = 57;
        arrc[10] = 65;
        arrc[11] = 66;
        arrc[12] = 67;
        arrc[13] = 68;
        arrc[14] = 69;
        arrc[15] = 70;
        ALLATORIxDEMO = arrc;
    }

    public static final /* synthetic */ String toStringFromAscii(byte[] a2) {
        int n2;
        byte[] arrby = new byte[a2.length];
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            if (a2[n2] < 32 && a2[n2] >= 0) {
                arrby[n2] = 46;
            } else {
                int n4 = (short)a2[n2] & 0xFF;
                arrby[n2] = (byte)n4;
            }
            n3 = ++n2;
        }
        String string = CheaterData.ALLATORIxDEMO("G\\B ");
        try {
            String string2 = new String(arrby, string);
            return string2;
        }
        catch (Exception exception) {
            return "";
        }
    }

    public /* synthetic */ HexTool() {
        HexTool a2;
    }

    public static final /* synthetic */ String toString(byte a2) {
        int n2 = a2 << 8;
        char[] arrc = new char[2];
        arrc[0] = ALLATORIxDEMO[n2 >> 12 & 0xF];
        arrc[1] = ALLATORIxDEMO[n2 >> 8 & 0xF];
        return String.valueOf(arrc);
    }

    public static final /* synthetic */ String toString(long a2) {
        return Long.toHexString(a2);
    }

    public static /* synthetic */ byte[] getByteArrayFromHexString(String a2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = 0;
        int n3 = 0;
        boolean bl = true;
        block0: while (true) {
            int n4;
            int n5 = n4 = -1;
            while (n5 == -1) {
                if (n2 == a2.length()) break block0;
                char c2 = a2.charAt(n2);
                n4 = c2 >= '0' && c2 <= '9' ? c2 - 48 : (c2 >= 'a' && c2 <= 'f' ? c2 - 97 + 10 : (c2 >= 'A' && c2 <= 'F' ? c2 - 65 + 10 : -1));
                ++n2;
                n5 = n4;
            }
            if (bl) {
                n3 = n4 << 4;
                bl = false;
                continue;
            }
            bl = true;
            byteArrayOutputStream.write(n3 |= n4);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final /* synthetic */ String toString(byte[] a2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            stringBuilder.append(HexTool.toString(a2[n2]));
            stringBuilder.append(' ');
            n3 = ++n2;
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static final /* synthetic */ String toPaddedStringFromAscii(byte[] a2) {
        int n2;
        String string = HexTool.toStringFromAscii(a2);
        StringBuilder stringBuilder = new StringBuilder(string.length() * 3);
        int n3 = n2 = 0;
        while (n3 < string.length()) {
            stringBuilder.append(string.charAt(n2));
            stringBuilder.append(MaplePlayerShopItem.ALLATORIxDEMO("W\u0016"));
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }
}

