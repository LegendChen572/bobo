/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 */
package client.inventory;

import client.messages.commands.player.\u61b6\u6200\u8c37;
import handling.world.MapleMessengerCharacter;
import java.io.Serializable;

public class MapleImp
implements Serializable {
    private /* synthetic */ short K;
    private /* synthetic */ int k;
    private static final /* synthetic */ long B = 91795493413738569L;
    private /* synthetic */ short a;
    private /* synthetic */ byte d;
    private /* synthetic */ byte ALLATORIxDEMO;

    public final /* synthetic */ void setState(int a2) {
        a.d = (byte)a2;
    }

    public final /* synthetic */ byte getState() {
        MapleImp a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ 3 << 1;
        int n5 = n3;
        int n6 = 5 << 4;
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

    public final /* synthetic */ void setLevel(int a2) {
        a.ALLATORIxDEMO = (byte)a2;
    }

    public final /* synthetic */ int getItemId() {
        MapleImp a2;
        return a2.k;
    }

    public /* synthetic */ MapleImp(int a2) {
        MapleImp a3;
        MapleImp mapleImp = a3;
        MapleImp mapleImp2 = a3;
        a3.K = 0;
        mapleImp2.a = 0;
        mapleImp2.d = 1;
        mapleImp.ALLATORIxDEMO = 1;
        mapleImp.k = a2;
    }

    public final /* synthetic */ byte getLevel() {
        MapleImp a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void setFullness(int a2) {
        a.K = (short)Math.min(1000, a2);
    }

    public final /* synthetic */ short getFullness() {
        MapleImp a2;
        return a2.K;
    }

    public final /* synthetic */ short getCloseness() {
        MapleImp a2;
        return a2.a;
    }

    public final /* synthetic */ void setCloseness(int a2) {
        a.a = (short)Math.min(100, a2);
    }

    public static final class ImpFlag
    extends Enum<ImpFlag> {
        public static final /* synthetic */ /* enum */ ImpFlag MAX_CLOSENESS;
        public static final /* synthetic */ /* enum */ ImpFlag LEVEL;
        public static final /* synthetic */ /* enum */ ImpFlag SLEEP_TIME;
        public static final /* synthetic */ /* enum */ ImpFlag CREATE_TIME;
        private static final /* synthetic */ ImpFlag[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ ImpFlag REMOVED;
        public static final /* synthetic */ /* enum */ ImpFlag FULLNESS;
        public static final /* synthetic */ /* enum */ ImpFlag CLOSENESS_LEFT;
        public static final /* synthetic */ /* enum */ ImpFlag STATE;
        public static final /* synthetic */ /* enum */ ImpFlag MAX_FULLNESS;
        public static final /* synthetic */ /* enum */ ImpFlag MAX_ALIVE;
        public static final /* synthetic */ /* enum */ ImpFlag AWAKE_TIME;
        public static final /* synthetic */ /* enum */ ImpFlag TYPE;
        public static final /* synthetic */ /* enum */ ImpFlag CLOSENESS;
        public static final /* synthetic */ /* enum */ ImpFlag MAX_DELAY;
        private final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ ImpFlag MINUTES_LEFT;
        public static final /* synthetic */ /* enum */ ImpFlag UPDATE_TIME;
        public static final /* synthetic */ /* enum */ ImpFlag SUMMONED;
        public static final /* synthetic */ /* enum */ ImpFlag FULLNESS_2;
        public static final /* synthetic */ /* enum */ ImpFlag MAX_MINUTES;

        public static /* synthetic */ ImpFlag valueOf(String a2) {
            return Enum.valueOf(ImpFlag.class, a2);
        }

        public final /* synthetic */ int getValue() {
            ImpFlag a2;
            return a2.d;
        }

        public final /* synthetic */ boolean check(int a2) {
            ImpFlag a3;
            return (a2 & a3.d) == a3.d;
        }

        public static /* synthetic */ ImpFlag[] values() {
            return (ImpFlag[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ {
            REMOVED = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"X\\GV\\\\N"), 0, 1);
            SUMMONED = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("]QCIAJK@"), 1, 2);
            TYPE = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"MSIO"), 2, 4);
            STATE = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("WZEZA"), 3, 8);
            FULLNESS = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"__UFWOJY"), 4, 16);
            CLOSENESS = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("GBK]A@A]W"), 5, 32);
            CLOSENESS_LEFT = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"ZFVY\\D\\YJUUO_^"), 6, 64);
            MINUTES_LEFT = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("CM@QZA][BAHP"), 7, 128);
            LEVEL = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"F\\\\\\F"), 8, 256);
            FULLNESS_2 = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("HQBH@A]WQ6"), 9, 512);
            UPDATE_TIME = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"_INX^\\UMCTO"), 10, 1024);
            CREATE_TIME = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("G\\AOPK[ZMCA"), 11, 2048);
            AWAKE_TIME = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"X]XA\\UMCTO"), 12, 4096);
            SLEEP_TIME = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("]HKA^[ZMCA"), 13, 8192);
            MAX_CLOSENESS = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"GXRFIUEJOWOJY"), 14, 16384);
            MAX_DELAY = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("IO\\Q@KHO]"), 15, 32768);
            MAX_FULLNESS = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"TKAU__UFWOJY"), 16, 65536);
            MAX_ALIVE = new ImpFlag(MapleMessengerCharacter.ALLATORIxDEMO("IO\\QEBMXA"), 17, 131072);
            MAX_MINUTES = new ImpFlag(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"GXRFGPDL^\\Y"), 18, 262144);
            ImpFlag[] arrimpFlag = new ImpFlag[19];
            arrimpFlag[0] = REMOVED;
            arrimpFlag[1] = SUMMONED;
            arrimpFlag[2] = TYPE;
            arrimpFlag[3] = STATE;
            arrimpFlag[4] = FULLNESS;
            arrimpFlag[5] = CLOSENESS;
            arrimpFlag[6] = CLOSENESS_LEFT;
            arrimpFlag[7] = MINUTES_LEFT;
            arrimpFlag[8] = LEVEL;
            arrimpFlag[9] = FULLNESS_2;
            arrimpFlag[10] = UPDATE_TIME;
            arrimpFlag[11] = CREATE_TIME;
            arrimpFlag[12] = AWAKE_TIME;
            arrimpFlag[13] = SLEEP_TIME;
            arrimpFlag[14] = MAX_CLOSENESS;
            arrimpFlag[15] = MAX_DELAY;
            arrimpFlag[16] = MAX_FULLNESS;
            arrimpFlag[17] = MAX_ALIVE;
            arrimpFlag[18] = MAX_MINUTES;
            ALLATORIxDEMO = arrimpFlag;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ ImpFlag(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            ImpFlag a3;
            a3.d = a2;
        }
    }
}

