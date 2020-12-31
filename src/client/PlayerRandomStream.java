/*
 * Decompiled with CFR 0.150.
 */
package client;

import server.Randomizer;
import tools.data.MaplePacketLittleEndianWriter;

public class PlayerRandomStream {
    private transient /* synthetic */ long a;
    private transient /* synthetic */ long g;
    private transient /* synthetic */ long ALLATORIxDEMO;
    private transient /* synthetic */ long C;
    private transient /* synthetic */ long d;
    private transient /* synthetic */ long e;
    private transient /* synthetic */ long K;
    private transient /* synthetic */ long E;
    private transient /* synthetic */ long H;
    private transient /* synthetic */ long F;
    private transient /* synthetic */ long B;
    private transient /* synthetic */ long k;

    public final /* synthetic */ long CRand32__Random_ForMonster() {
        PlayerRandomStream a2;
        PlayerRandomStream playerRandomStream = a2;
        long l2 = playerRandomStream.a;
        long l3 = playerRandomStream.d;
        long l4 = playerRandomStream.ALLATORIxDEMO;
        long l5 = playerRandomStream.a;
        l2 = (l2 & 0xFFFFFFFFFFFFFFFEL) << 12 ^ (l5 & 0x7FFC0L ^ l2 >> 13) >> 6;
        l3 = 16L * (l3 & 0xFFFFFFFFFFFFFFF8L) ^ (l3 >> 2 ^ l3 & 0x3F800000L) >> 23;
        l4 = (l4 & 0xFFFFFFFFFFFFFFF0L) << 17 ^ (l4 >> 3 ^ l4 & 0x1FFFFF00L) >> 8;
        playerRandomStream.g = l4 & 0xFFFFFFFFL;
        playerRandomStream.e = l2 & 0xFFFFFFFFL;
        playerRandomStream.E = l3 & 0xFFFFFFFFL;
        return (l2 ^ l3 ^ l4) & 0xFFFFFFFFL;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 3;
        int cfr_ignored_0 = (3 ^ 5) << 4;
        int n5 = n3;
        int n6 = 4 << 4 ^ (3 << 2 ^ 3);
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

    public final /* synthetic */ long CRand32__Random() {
        PlayerRandomStream a2;
        PlayerRandomStream playerRandomStream = a2;
        long l2 = playerRandomStream.F;
        long l3 = playerRandomStream.C;
        long l4 = playerRandomStream.H;
        long l5 = playerRandomStream.F;
        l2 = (l2 & 0xFFFFFFFFFFFFFFFEL) << 12 ^ (l5 & 0x7FFC0L ^ l2 >> 13) >> 6;
        l3 = 16L * (l3 & 0xFFFFFFFFFFFFFFF8L) ^ (l3 >> 2 ^ l3 & 0x3F800000L) >> 23;
        l4 = (l4 & 0xFFFFFFFFFFFFFFF0L) << 17 ^ (l4 >> 3 ^ l4 & 0x1FFFFF00L) >> 8;
        playerRandomStream.g = l4 & 0xFFFFFFFFL;
        playerRandomStream.e = l2 & 0xFFFFFFFFL;
        playerRandomStream.E = l3 & 0xFFFFFFFFL;
        return (l2 ^ l3 ^ l4) & 0xFFFFFFFFL;
    }

    public final /* synthetic */ void connectData(MaplePacketLittleEndianWriter a2) {
        PlayerRandomStream a3;
        PlayerRandomStream playerRandomStream = a3;
        long l2 = playerRandomStream.CRand32__Random();
        long l3 = playerRandomStream.CRand32__Random();
        long l4 = playerRandomStream.CRand32__Random();
        playerRandomStream.CRand32__Seed(l2, l3, l4);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        a2.writeInt((int)l2);
        maplePacketLittleEndianWriter.writeInt((int)l3);
        maplePacketLittleEndianWriter.writeInt((int)l4);
    }

    public final /* synthetic */ long CRand32__Random_CheckDamageMiss() {
        PlayerRandomStream a2;
        PlayerRandomStream playerRandomStream = a2;
        long l2 = playerRandomStream.B;
        long l3 = playerRandomStream.k;
        long l4 = playerRandomStream.K;
        long l5 = playerRandomStream.B;
        l2 = (l2 & 0xFFFFFFFFFFFFFFFEL) << 12 ^ (l5 & 0x7FFC0L ^ l2 >> 13) >> 6;
        l3 = 16L * (l3 & 0xFFFFFFFFFFFFFFF8L) ^ (l3 >> 2 ^ l3 & 0x3F800000L) >> 23;
        l4 = (l4 & 0xFFFFFFFFFFFFFFF0L) << 17 ^ (l4 >> 3 ^ l4 & 0x1FFFFF00L) >> 8;
        playerRandomStream.g = l4 & 0xFFFFFFFFL;
        playerRandomStream.e = l2 & 0xFFFFFFFFL;
        playerRandomStream.E = l3 & 0xFFFFFFFFL;
        return (l2 ^ l3 ^ l4) & 0xFFFFFFFFL;
    }

    public final /* synthetic */ void CRand32__Seed(long a2, long a3, long a4) {
        PlayerRandomStream a5;
        PlayerRandomStream playerRandomStream = a5;
        PlayerRandomStream playerRandomStream2 = a5;
        PlayerRandomStream playerRandomStream3 = a5;
        PlayerRandomStream playerRandomStream4 = a5;
        a5.F = a2 | 0x100000L;
        playerRandomStream4.C = a3 | 0x1000L;
        playerRandomStream4.H = a4 | 0x10L;
        playerRandomStream3.e = a2 | 0x100000L;
        playerRandomStream3.E = a3 | 0x1000L;
        playerRandomStream2.g = a4 | 0x10L;
        playerRandomStream2.B = a2 | 0x100000L;
        playerRandomStream.k = a3 | 0x1000L;
        playerRandomStream.K = a4 | 0x10L;
    }

    public final /* synthetic */ long CRand32__Random_Character() {
        PlayerRandomStream a2;
        PlayerRandomStream playerRandomStream = a2;
        long l2 = playerRandomStream.e;
        long l3 = playerRandomStream.E;
        long l4 = playerRandomStream.g;
        long l5 = playerRandomStream.e;
        l2 = (l2 & 0xFFFFFFFFFFFFFFFEL) << 12 ^ (l5 & 0x7FFC0L ^ l2 >> 13) >> 6;
        l3 = 16L * (l3 & 0xFFFFFFFFFFFFFFF8L) ^ (l3 >> 2 ^ l3 & 0x3F800000L) >> 23;
        l4 = (l4 & 0xFFFFFFFFFFFFFFF0L) << 17 ^ (l4 >> 3 ^ l4 & 0x1FFFFF00L) >> 8;
        playerRandomStream.g = l4 & 0xFFFFFFFFL;
        playerRandomStream.e = l2 & 0xFFFFFFFFL;
        playerRandomStream.E = l3 & 0xFFFFFFFFL;
        return (l2 ^ l3 ^ l4) & 0xFFFFFFFFL;
    }

    public /* synthetic */ PlayerRandomStream() {
        PlayerRandomStream a2;
        PlayerRandomStream playerRandomStream = a2;
        int n2 = 5;
        playerRandomStream.CRand32__Seed(Randomizer.nextLong(), 803157710L, 803157710L);
    }
}

