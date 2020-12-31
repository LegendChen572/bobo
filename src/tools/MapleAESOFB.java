/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.MapleCoolDownValueHolder;
import constants.GameSetConstants;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import server.shark.SharkLogger;
import tools.BitTools;
import tools.HexTool;

public class MapleAESOFB {
    private static final /* synthetic */ byte[] ALLATORIxDEMO;
    private /* synthetic */ Cipher a;
    private /* synthetic */ byte[] K;
    private /* synthetic */ short d;

    public /* synthetic */ MapleAESOFB(byte[] a2, short a3) {
        MapleAESOFB mapleAESOFB;
        MapleAESOFB a4;
        try {
            a4.a = Cipher.getInstance(SharkLogger.ALLATORIxDEMO("`ir"));
            a4.a.init(1, GameSetConstants.SKEY);
            mapleAESOFB = a4;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.err.println("ERROR" + noSuchAlgorithmException);
            mapleAESOFB = a4;
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            System.err.println("ERROR" + noSuchPaddingException);
            mapleAESOFB = a4;
        }
        catch (InvalidKeyException invalidKeyException) {
            System.err.println(MapleCoolDownValueHolder.ALLATORIxDEMO("\u523e\u5990\u5335\u52fb\u5be5\u596a\u6574u\u0003{\u8ae8\u78e1\u8aae\u6674\u5405\u4f24\u750b\u4edd\u7102\u960b\u5215\u52fb\u501f\u57d0\u5be5\u78e7\u7cd8\u7d2a\u76a7\u0011B)\u6ab7\u6813\u000b\u0011`\u001e\n"));
            mapleAESOFB = a4;
        }
        mapleAESOFB.ALLATORIxDEMO(a2);
        a4.d = (short)(a3 >> 8 & 0xFF | a3 << 8 & 0xFF00);
    }

    public static /* synthetic */ int getPacketLength(int a2) {
        int n2 = a2 >>> 16 ^ a2 & 0xFFFF;
        n2 = n2 << 8 & 0xFF00 | n2 >>> 8 & 0xFF;
        return n2;
    }

    public /* synthetic */ boolean checkPacket(byte[] a2) {
        MapleAESOFB a3;
        return ((a2[0] ^ a3.K[2]) & 0xFF) == (a3.d >> 8 & 0xFF) && ((a2[1] ^ a3.K[3]) & 0xFF) == (a3.d & 0xFF);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ byte[] crypt(byte[] a2) {
        MapleAESOFB a3;
        if (GameSetConstants.MAPLE_VERSION == 75) {
            a3.ALLATORIxDEMO();
            return a2;
        }
        int n2 = a2.length;
        int n3 = 1456;
        int n4 = 0;
        try {
            int n5 = n2;
            while (true) {
                int n6;
                byte[] arrby;
                if (n5 > 0) {
                    arrby = BitTools.multiplyBytes(a3.K, 4, 4);
                    if (n2 < n3) {
                        n3 = n2;
                    }
                    n6 = n4;
                } else {
                    a3.ALLATORIxDEMO();
                    return a2;
                }
                while (n6 < n4 + n3) {
                    int n7;
                    if ((n7 - n4) % arrby.length == 0) {
                        System.arraycopy(a3.a.doFinal(arrby), 0, arrby, 0, arrby.length);
                    }
                    if (GameSetConstants.AESOFB_CRYPT) {
                        int n8 = n7;
                        a2[n8] = (byte)(a2[n8] - arrby[(n7 - n4) % arrby.length]);
                    } else {
                        int n9 = n7;
                        a2[n9] = (byte)(a2[n9] ^ arrby[(n7 - n4) % arrby.length]);
                    }
                    n6 = ++n7;
                }
                n4 += n3;
                n3 = 1460;
                n5 = n2 -= n3;
            }
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            illegalBlockSizeException.printStackTrace();
            return a2;
        }
        catch (BadPaddingException badPaddingException) {
            badPaddingException.printStackTrace();
            return a2;
        }
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        MapleAESOFB a2;
        a2.K = MapleAESOFB.getNewIv(a2.K);
    }

    public /* synthetic */ byte[] getPacketHeader(int a2) {
        MapleAESOFB a3;
        int n2 = (a3.K[3] & 0xFF | a3.K[2] << 8 & 0xFF00) ^ a3.d;
        a2 = (a2 << 8 & 0xFF00 | a2 >>> 8) ^ n2;
        byte[] arrby = new byte[4];
        arrby[0] = (byte)(n2 >>> 8 & 0xFF);
        arrby[1] = (byte)(n2 & 0xFF);
        arrby[2] = (byte)(a2 >>> 8 & 0xFF);
        arrby[3] = (byte)(a2 & 0xFF);
        return arrby;
    }

    private /* synthetic */ void ALLATORIxDEMO(byte[] a2) {
        a.K = a2;
    }

    public /* synthetic */ boolean checkPacket(int a2) {
        MapleAESOFB a3;
        byte[] arrby = new byte[2];
        arrby[0] = (byte)(a2 >> 24 & 0xFF);
        arrby[1] = (byte)(a2 >> 16 & 0xFF);
        return a3.checkPacket(arrby);
    }

    public /* synthetic */ String toString() {
        MapleAESOFB a2;
        return "IV: " + HexTool.toString(a2.K);
    }

    public static /* synthetic */ byte[] getNewIv(byte[] a2) {
        int n2;
        byte[] arrby = new byte[4];
        arrby[0] = -14;
        arrby[1] = 83;
        arrby[2] = 80;
        arrby[3] = -58;
        byte[] arrby2 = arrby;
        int n3 = n2 = 0;
        while (n3 < 4) {
            MapleAESOFB.funnyShit(a2[n2++], arrby2);
            n3 = n2;
        }
        return arrby2;
    }

    public static /* synthetic */ {
        byte[] arrby = new byte[256];
        arrby[0] = -20;
        arrby[1] = 63;
        arrby[2] = 119;
        arrby[3] = -92;
        arrby[4] = 69;
        arrby[5] = -48;
        arrby[6] = 113;
        arrby[7] = -65;
        arrby[8] = -73;
        arrby[9] = -104;
        arrby[10] = 32;
        arrby[11] = -4;
        arrby[12] = 75;
        arrby[13] = -23;
        arrby[14] = -77;
        arrby[15] = -31;
        arrby[16] = 92;
        arrby[17] = 34;
        arrby[18] = -9;
        arrby[19] = 12;
        arrby[20] = 68;
        arrby[21] = 27;
        arrby[22] = -127;
        arrby[23] = -67;
        arrby[24] = 99;
        arrby[25] = -115;
        arrby[26] = -44;
        arrby[27] = -61;
        arrby[28] = -14;
        arrby[29] = 16;
        arrby[30] = 25;
        arrby[31] = -32;
        arrby[32] = -5;
        arrby[33] = -95;
        arrby[34] = 110;
        arrby[35] = 102;
        arrby[36] = -22;
        arrby[37] = -82;
        arrby[38] = -42;
        arrby[39] = -50;
        arrby[40] = 6;
        arrby[41] = 24;
        arrby[42] = 78;
        arrby[43] = -21;
        arrby[44] = 120;
        arrby[45] = -107;
        arrby[46] = -37;
        arrby[47] = -70;
        arrby[48] = -74;
        arrby[49] = 66;
        arrby[50] = 122;
        arrby[51] = 42;
        arrby[52] = -125;
        arrby[53] = 11;
        arrby[54] = 84;
        arrby[55] = 103;
        arrby[56] = 109;
        arrby[57] = -24;
        arrby[58] = 101;
        arrby[59] = -25;
        arrby[60] = 47;
        arrby[61] = 7;
        arrby[62] = -13;
        arrby[63] = -86;
        arrby[64] = 39;
        arrby[65] = 123;
        arrby[66] = -123;
        arrby[67] = -80;
        arrby[68] = 38;
        arrby[69] = -3;
        arrby[70] = -117;
        arrby[71] = -87;
        arrby[72] = -6;
        arrby[73] = -66;
        arrby[74] = -88;
        arrby[75] = -41;
        arrby[76] = -53;
        arrby[77] = -52;
        arrby[78] = -110;
        arrby[79] = -38;
        arrby[80] = -7;
        arrby[81] = -109;
        arrby[82] = 96;
        arrby[83] = 45;
        arrby[84] = -35;
        arrby[85] = -46;
        arrby[86] = -94;
        arrby[87] = -101;
        arrby[88] = 57;
        arrby[89] = 95;
        arrby[90] = -126;
        arrby[91] = 33;
        arrby[92] = 76;
        arrby[93] = 105;
        arrby[94] = -8;
        arrby[95] = 49;
        arrby[96] = -121;
        arrby[97] = -18;
        arrby[98] = -114;
        arrby[99] = -83;
        arrby[100] = -116;
        arrby[101] = 106;
        arrby[102] = -68;
        arrby[103] = -75;
        arrby[104] = 107;
        arrby[105] = 89;
        arrby[106] = 19;
        arrby[107] = -15;
        arrby[108] = 4;
        arrby[109] = 0;
        arrby[110] = -10;
        arrby[111] = 90;
        arrby[112] = 53;
        arrby[113] = 121;
        arrby[114] = 72;
        arrby[115] = -113;
        arrby[116] = 21;
        arrby[117] = -51;
        arrby[118] = -105;
        arrby[119] = 87;
        arrby[120] = 18;
        arrby[121] = 62;
        arrby[122] = 55;
        arrby[123] = -1;
        arrby[124] = -99;
        arrby[125] = 79;
        arrby[126] = 81;
        arrby[127] = -11;
        arrby[128] = -93;
        arrby[129] = 112;
        arrby[130] = -69;
        arrby[131] = 20;
        arrby[132] = 117;
        arrby[133] = -62;
        arrby[134] = -72;
        arrby[135] = 114;
        arrby[136] = -64;
        arrby[137] = -19;
        arrby[138] = 125;
        arrby[139] = 104;
        arrby[140] = -55;
        arrby[141] = 46;
        arrby[142] = 13;
        arrby[143] = 98;
        arrby[144] = 70;
        arrby[145] = 23;
        arrby[146] = 17;
        arrby[147] = 77;
        arrby[148] = 108;
        arrby[149] = -60;
        arrby[150] = 126;
        arrby[151] = 83;
        arrby[152] = -63;
        arrby[153] = 37;
        arrby[154] = -57;
        arrby[155] = -102;
        arrby[156] = 28;
        arrby[157] = -120;
        arrby[158] = 88;
        arrby[159] = 44;
        arrby[160] = -119;
        arrby[161] = -36;
        arrby[162] = 2;
        arrby[163] = 100;
        arrby[164] = 64;
        arrby[165] = 1;
        arrby[166] = 93;
        arrby[167] = 56;
        arrby[168] = -91;
        arrby[169] = -30;
        arrby[170] = -81;
        arrby[171] = 85;
        arrby[172] = -43;
        arrby[173] = -17;
        arrby[174] = 26;
        arrby[175] = 124;
        arrby[176] = -89;
        arrby[177] = 91;
        arrby[178] = -90;
        arrby[179] = 111;
        arrby[180] = -122;
        arrby[181] = -97;
        arrby[182] = 115;
        arrby[183] = -26;
        arrby[184] = 10;
        arrby[185] = -34;
        arrby[186] = 43;
        arrby[187] = -103;
        arrby[188] = 74;
        arrby[189] = 71;
        arrby[190] = -100;
        arrby[191] = -33;
        arrby[192] = 9;
        arrby[193] = 118;
        arrby[194] = -98;
        arrby[195] = 48;
        arrby[196] = 14;
        arrby[197] = -28;
        arrby[198] = -78;
        arrby[199] = -108;
        arrby[200] = -96;
        arrby[201] = 59;
        arrby[202] = 52;
        arrby[203] = 29;
        arrby[204] = 40;
        arrby[205] = 15;
        arrby[206] = 54;
        arrby[207] = -29;
        arrby[208] = 35;
        arrby[209] = -76;
        arrby[210] = 3;
        arrby[211] = -40;
        arrby[212] = -112;
        arrby[213] = -56;
        arrby[214] = 60;
        arrby[215] = -2;
        arrby[216] = 94;
        arrby[217] = 50;
        arrby[218] = 36;
        arrby[219] = 80;
        arrby[220] = 31;
        arrby[221] = 58;
        arrby[222] = 67;
        arrby[223] = -118;
        arrby[224] = -106;
        arrby[225] = 65;
        arrby[226] = 116;
        arrby[227] = -84;
        arrby[228] = 82;
        arrby[229] = 51;
        arrby[230] = -16;
        arrby[231] = -39;
        arrby[232] = 41;
        arrby[233] = -128;
        arrby[234] = -79;
        arrby[235] = 22;
        arrby[236] = -45;
        arrby[237] = -85;
        arrby[238] = -111;
        arrby[239] = -71;
        arrby[240] = -124;
        arrby[241] = 127;
        arrby[242] = 97;
        arrby[243] = 30;
        arrby[244] = -49;
        arrby[245] = -59;
        arrby[246] = -47;
        arrby[247] = 86;
        arrby[248] = 61;
        arrby[249] = -54;
        arrby[250] = -12;
        arrby[251] = 5;
        arrby[252] = -58;
        arrby[253] = -27;
        arrby[254] = 8;
        arrby[255] = 73;
        ALLATORIxDEMO = arrby;
    }

    public static final /* synthetic */ void funnyShit(byte a2, byte[] a32) {
        byte[] arrby = a32;
        byte[] arrby2 = a32;
        int n2 = arrby[1];
        byte by = a2;
        int n3 = ALLATORIxDEMO[n2 & 0xFF];
        n3 = (byte)(n3 - a2);
        arrby2[0] = (byte)(arrby2[0] + n3);
        n3 = arrby[2];
        n3 = (byte)(n3 ^ ALLATORIxDEMO[by & 0xFF]);
        arrby2[1] = n2 = (byte)(n2 - (n3 & 0xFF));
        n3 = n2 = arrby[3];
        n2 = (byte)(n2 - (a32[0] & 0xFF));
        n3 = ALLATORIxDEMO[n3 & 0xFF];
        n3 = n3 + a2;
        arrby2[2] = n3 = (byte)(n3 ^ a32[2]);
        arrby[3] = n2 = (byte)(n2 + (ALLATORIxDEMO[by & 0xFF] & 0xFF));
        n2 = arrby2[0] & 0xFF;
        n2 |= a32[1] << 8 & 0xFF00;
        n2 |= a32[2] << 16 & 0xFF0000;
        int a32 = (n2 |= a32[3] << 24 & 0xFF000000) >>> 29;
        arrby[0] = (byte)((a32 |= (n2 <<= 3)) & 0xFF);
        arrby2[1] = (byte)(a32 >> 8 & 0xFF);
        arrby[2] = (byte)(a32 >> 16 & 0xFF);
        arrby2[3] = (byte)(a32 >> 24 & 0xFF);
    }

    public /* synthetic */ byte[] getIv() {
        MapleAESOFB a2;
        return a2.K;
    }
}

