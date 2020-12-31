/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.util.ArrayList;

public class BitTools {
    public static final /* synthetic */ ArrayList intToArray(int a2) {
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        char[] arrc = String.valueOf(a2).toCharArray();
        int n3 = n2 = 0;
        while (n3 < arrc.length) {
            String string = String.valueOf(arrc[n2]);
            arrayList.add(Integer.parseInt(string));
            n3 = ++n2;
        }
        return arrayList;
    }

    public static final /* synthetic */ int getShort(byte[] a2, int a3) {
        int n2 = a2[a3];
        n2 &= 0xFF;
        return n2 |= a2[a3 + 1] << 8 & 0xFF00;
    }

    public static final /* synthetic */ String getMapleString(byte[] a2, int a3) {
        int n2 = a2[a3] & 0xFF | a2[a3 + 1] << 8 & 0xFF00;
        return BitTools.getString(a2, a3 + 2, n2);
    }

    public /* synthetic */ BitTools() {
        BitTools a2;
    }

    public static final /* synthetic */ int doubleToShortBits(double a2) {
        return (int)(Double.doubleToLongBits(a2) >> 48);
    }

    public static final /* synthetic */ String getString(byte[] a2, int a3, int a4) {
        int n2;
        char[] arrc = new char[a4];
        int n3 = n2 = 0;
        while (n3 < a4) {
            int n4 = n2++;
            arrc[n4] = (char)a2[n4 + a3];
            n3 = n2;
        }
        return String.valueOf(arrc);
    }

    public static final /* synthetic */ byte[] multiplyBytes(byte[] a2, int a3, int a4) {
        int n2;
        byte[] arrby = new byte[a3 * a4];
        int n3 = n2 = 0;
        while (n3 < a3 * a4) {
            int n4 = n2++;
            arrby[n4] = a2[n4 % a3];
            n3 = n2;
        }
        return arrby;
    }

    public static final /* synthetic */ byte rollLeft(byte a2, int a3) {
        int n2 = a2 & 0xFF;
        return (byte)((n2 <<= a3 % 8) & 0xFF | n2 >> 8);
    }

    public static final /* synthetic */ byte rollRight(byte a2, int a3) {
        int n2 = a2 & 0xFF;
        n2 = n2 << 8 >>> a3 % 8;
        return (byte)(n2 & 0xFF | n2 >>> 8);
    }
}

