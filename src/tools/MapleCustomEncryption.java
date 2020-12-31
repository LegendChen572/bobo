/*
 * Decompiled with CFR 0.150.
 */
package tools;

import tools.BitTools;

public class MapleCustomEncryption {
    public static final /* synthetic */ byte[] encryptData(byte[] a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 6) {
            byte by;
            int n4;
            byte by2 = 0;
            byte by3 = (byte)(a2.length & 0xFF);
            if (n2 % 2 == 0) {
                int n5 = n4 = 0;
                while (n5 < a2.length) {
                    by = a2[n4];
                    by = BitTools.rollLeft(by, 3);
                    by = (byte)(by + by3);
                    by2 = by = (byte)(by ^ by2);
                    by = BitTools.rollRight(by, by3 & 0xFF);
                    by = (byte)(~by & 0xFF);
                    by = (byte)(by + 72);
                    by3 = (byte)(by3 - 1);
                    a2[n4++] = by;
                    n5 = n4;
                }
            } else {
                int n6 = a2.length - 1;
                while (n6 >= 0) {
                    by = a2[n4];
                    by = BitTools.rollLeft(by, 4);
                    by = (byte)(by + by3);
                    by2 = by = (byte)(by ^ by2);
                    by = (byte)(by ^ 0x13);
                    by = BitTools.rollRight(by, 3);
                    by3 = (byte)(by3 - 1);
                    a2[n4--] = by;
                    n6 = n4;
                }
            }
            n3 = ++n2;
        }
        return a2;
    }

    public static final /* synthetic */ byte[] decryptData(byte[] a2) {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 1) {
            byte by;
            int n4;
            byte by2 = 0;
            byte by3 = (byte)(a2.length & 0xFF);
            byte by4 = 0;
            if (n2 % 2 == 0) {
                int n5 = n4 = 0;
                while (n5 < a2.length) {
                    by = a2[n4];
                    by = (byte)(by - 72);
                    by = (byte)(~by & 0xFF);
                    by4 = by = BitTools.rollLeft(by, by3 & 0xFF);
                    by = (byte)(by ^ by2);
                    by2 = by4;
                    by = (byte)(by - by3);
                    a2[n4] = by = BitTools.rollRight(by, 3);
                    by3 = (byte)(by3 - 1);
                    n5 = ++n4;
                }
            } else {
                int n6 = a2.length - 1;
                while (n6 >= 0) {
                    by = a2[n4];
                    by = BitTools.rollLeft(by, 3);
                    by4 = by = (byte)(by ^ 0x13);
                    by = (byte)(by ^ by2);
                    by2 = by4;
                    by = (byte)(by - by3);
                    a2[n4] = by = BitTools.rollRight(by, 4);
                    by3 = (byte)(by3 - 1);
                    n6 = --n4;
                }
            }
            n3 = ++n2;
        }
        return a2;
    }

    public /* synthetic */ MapleCustomEncryption() {
        MapleCustomEncryption a2;
    }
}

