/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 */
package client;

import client.messages.commands.player.\u61b6\u6200\u8c37;
import java.util.Arrays;
import java.util.List;
import tools.data.RandomAccessByteStream;

public class MapleFriendship {
    private /* synthetic */ MapleFriendshipType d;
    private /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ void setPoints(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void addPoints(int a2) {
        a.ALLATORIxDEMO += a2;
    }

    public /* synthetic */ MapleFriendshipType getType() {
        MapleFriendship a2;
        return a2.d;
    }

    public /* synthetic */ int getPoints() {
        MapleFriendship a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 3;
        int cfr_ignored_0 = 5 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 3 << 3;
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

    public /* synthetic */ MapleFriendship(MapleFriendshipType a2) {
        MapleFriendship a3;
        MapleFriendship mapleFriendship = a3;
        mapleFriendship.ALLATORIxDEMO = 0;
        mapleFriendship.d = a2;
    }

    public static final class MapleFriendshipType
    extends Enum<MapleFriendshipType> {
        public static final /* synthetic */ /* enum */ MapleFriendshipType LittleDragon;
        public final /* synthetic */ int d;
        private static final /* synthetic */ MapleFriendshipType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ MapleFriendshipType Ika;
        public static final /* synthetic */ /* enum */ MapleFriendshipType Hermonniny;
        public static final /* synthetic */ /* enum */ MapleFriendshipType JoeJoe;
        public /* synthetic */ List<Integer> id;

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ MapleFriendshipType(int n22, Integer ... n22) {
            void a2;
            void a3;
            void var2_-1;
            void var1_-1;
            MapleFriendshipType a4;
            MapleFriendshipType mapleFriendshipType = a4;
            mapleFriendshipType.d = a3;
            mapleFriendshipType.id = Arrays.asList(a2);
        }

        public static /* synthetic */ MapleFriendshipType valueOf(String a2) {
            return Enum.valueOf(MapleFriendshipType.class, a2);
        }

        public /* synthetic */ int getMobId() {
            MapleFriendshipType a2;
            return a2.d;
        }

        public static /* synthetic */ {
            Integer[] arrinteger = new Integer[6];
            arrinteger[0] = 1202023;
            arrinteger[1] = 1202024;
            arrinteger[2] = 1202025;
            arrinteger[3] = 1202026;
            arrinteger[4] = 1202043;
            arrinteger[5] = 1202039;
            JoeJoe = new MapleFriendshipType(RandomAccessByteStream.ALLATORIxDEMO("O\"`\u0007j("), 0, 9410165, arrinteger);
            Integer[] arrinteger2 = new Integer[6];
            arrinteger2[0] = 1202027;
            arrinteger2[1] = 1202028;
            arrinteger2[2] = 1202029;
            arrinteger2[3] = 1202030;
            arrinteger2[4] = 1202044;
            arrinteger2[5] = 1202040;
            Hermonniny = new MapleFriendshipType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"Qokgvdwcws"), 1, 9410166, arrinteger2);
            Integer[] arrinteger3 = new Integer[6];
            arrinteger3[0] = 1202031;
            arrinteger3[1] = 1202032;
            arrinteger3[2] = 1202033;
            arrinteger3[3] = 1202034;
            arrinteger3[4] = 1202045;
            arrinteger3[5] = 1202041;
            LittleDragon = new MapleFriendshipType(RandomAccessByteStream.ALLATORIxDEMO("I$q9i(A?d*j#"), 2, 9410167, arrinteger3);
            Integer[] arrinteger4 = new Integer[6];
            arrinteger4[0] = 1202035;
            arrinteger4[1] = 1202036;
            arrinteger4[2] = 1202037;
            arrinteger4[3] = 1202038;
            arrinteger4[4] = 1202046;
            arrinteger4[5] = 1202042;
            Ika = new MapleFriendshipType(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"Crk"), 3, 9410168, arrinteger4);
            MapleFriendshipType[] arrmapleFriendshipType = new MapleFriendshipType[4];
            arrmapleFriendshipType[0] = JoeJoe;
            arrmapleFriendshipType[1] = Hermonniny;
            arrmapleFriendshipType[2] = LittleDragon;
            arrmapleFriendshipType[3] = Ika;
            ALLATORIxDEMO = arrmapleFriendshipType;
        }

        public static /* synthetic */ MapleFriendshipType getByName(String a2) {
            int n2;
            MapleFriendshipType[] arrmapleFriendshipType = MapleFriendshipType.values();
            int n3 = arrmapleFriendshipType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleFriendshipType mapleFriendshipType = arrmapleFriendshipType[n2];
                if (mapleFriendshipType.name().equals(a2)) {
                    return mapleFriendshipType;
                }
                n4 = ++n2;
            }
            return null;
        }

        public static /* synthetic */ MapleFriendshipType getById(int a2) {
            int n2;
            MapleFriendshipType[] arrmapleFriendshipType = MapleFriendshipType.values();
            int n3 = arrmapleFriendshipType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleFriendshipType mapleFriendshipType = arrmapleFriendshipType[n2];
                if (mapleFriendshipType.id.contains(a2)) {
                    return mapleFriendshipType;
                }
                n4 = ++n2;
            }
            return JoeJoe;
        }

        public static /* synthetic */ MapleFriendshipType[] values() {
            return (MapleFriendshipType[])ALLATORIxDEMO.clone();
        }
    }
}

