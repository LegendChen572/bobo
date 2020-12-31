/*
 * Decompiled with CFR 0.150.
 */
package tools.data;

import java.io.IOException;
import tools.HexTool;

public class ByteArrayByteStream {
    private /* synthetic */ int a;
    private final /* synthetic */ byte[] ALLATORIxDEMO;
    private /* synthetic */ long d;

    public /* synthetic */ String toString(boolean a2) {
        ByteArrayByteStream a3;
        String string = "";
        if (a3.ALLATORIxDEMO.length - a3.a > 0) {
            byte[] arrby = new byte[a3.ALLATORIxDEMO.length - a3.a];
            ByteArrayByteStream byteArrayByteStream = a3;
            System.arraycopy(byteArrayByteStream.ALLATORIxDEMO, byteArrayByteStream.a, arrby, 0, a3.ALLATORIxDEMO.length - a3.a);
            string = HexTool.toString(arrby);
        }
        if (a2) {
            return "\u5168\u90e8: " + HexTool.toString(a3.ALLATORIxDEMO) + " \u73fe\u5728: " + string;
        }
        return "\u6578\u64da: " + string;
    }

    public /* synthetic */ String toString() {
        ByteArrayByteStream a2;
        return a2.toString(false);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 5;
        int cfr_ignored_0 = 3 << 3 ^ 3;
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

    public /* synthetic */ int[] readLastBytes(int a2) {
        ByteArrayByteStream a3;
        ByteArrayByteStream byteArrayByteStream = a3;
        while (byteArrayByteStream.a - a2 < 1) {
            byteArrayByteStream = a3;
            --a2;
        }
        int[] arrn = null;
        int n2 = 0;
        int n3 = a2;
        while (n3 > 0) {
            int n4 = n2++;
            ByteArrayByteStream byteArrayByteStream2 = a3;
            void v4 = arrn[n4] + byteArrayByteStream2.ALLATORIxDEMO[byteArrayByteStream2.a - a2];
            arrn[n4] = v4;
            n3 = --a2;
        }
        return arrn;
    }

    public /* synthetic */ int readLastByte() {
        ByteArrayByteStream a2;
        ByteArrayByteStream byteArrayByteStream = a2;
        return byteArrayByteStream.ALLATORIxDEMO[byteArrayByteStream.a] & 0xFF;
    }

    public /* synthetic */ long getBytesRead() {
        ByteArrayByteStream a2;
        return a2.d;
    }

    public /* synthetic */ void seek(long a2) throws IOException {
        a.a = (int)a2;
    }

    public /* synthetic */ long available() {
        ByteArrayByteStream a2;
        return a2.ALLATORIxDEMO.length - a2.a;
    }

    public /* synthetic */ int readByte() {
        ByteArrayByteStream a2;
        ByteArrayByteStream byteArrayByteStream = a2;
        ++byteArrayByteStream.d;
        return byteArrayByteStream.ALLATORIxDEMO[a2.a++] & 0xFF;
    }

    public /* synthetic */ long getPosition() {
        ByteArrayByteStream a2;
        return a2.a;
    }

    public /* synthetic */ void unReadByte() {
        ByteArrayByteStream a2;
        --a2.d;
    }

    public /* synthetic */ ByteArrayByteStream(byte[] a2) {
        ByteArrayByteStream a3;
        ByteArrayByteStream byteArrayByteStream = a3;
        a3.a = 0;
        byteArrayByteStream.d = 0L;
        byteArrayByteStream.ALLATORIxDEMO = a2;
    }
}

