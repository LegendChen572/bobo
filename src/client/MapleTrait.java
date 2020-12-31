/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleCharacter;
import client.MapleStat;
import client.messages.commands.player.eventSystem.MapOwner;
import constants.GameConstants;
import tools.JsonMapConverter;
import tools.MaplePacketCreator;

public class MapleTrait {
    private /* synthetic */ MapleTraitType k;
    private /* synthetic */ int K;
    private /* synthetic */ byte ALLATORIxDEMO;
    private /* synthetic */ short d;
    private /* synthetic */ int a;

    public /* synthetic */ boolean recalcLevel() {
        int n2;
        MapleTrait a2;
        if (a2.K < 0) {
            MapleTrait mapleTrait = a2;
            MapleTrait mapleTrait2 = a2;
            mapleTrait2.K = 0;
            mapleTrait2.a = 0;
            mapleTrait.ALLATORIxDEMO = (byte)0;
            mapleTrait.d = false;
            return false;
        }
        byte by = a2.ALLATORIxDEMO;
        int n3 = n2 = 0;
        while (n3 < 100) {
            if (GameConstants.getTraitExpNeededForLevel(n2) > a2.a) {
                a2.d = (short)(GameConstants.getTraitExpNeededForLevel(n2) - a2.a);
                a2.ALLATORIxDEMO = (byte)(n2 - 1);
                return a2.ALLATORIxDEMO > by;
            }
            n3 = n2 = (int)((byte)(n2 + 1));
        }
        a2.d = 0;
        a2.ALLATORIxDEMO = (byte)100;
        a2.a = a2.K = GameConstants.getTraitExpNeededForLevel(a2.ALLATORIxDEMO);
        return a2.ALLATORIxDEMO > by;
    }

    public /* synthetic */ void addExp(int a2, MapleCharacter a3) {
        MapleTrait a4;
        a4.addTrueExp(a2 * a3.getClient().getChannelServer().getTraitRate(), a3);
    }

    public /* synthetic */ void addExp(int a2) {
        MapleTrait a3;
        MapleTrait mapleTrait = a3;
        mapleTrait.K += a2;
        int n2 = a2;
        mapleTrait.a += n2;
        if (n2 != 0) {
            a3.recalcLevel();
        }
    }

    public /* synthetic */ void addTrueExp(int a2, MapleCharacter a3) {
        if (a2 != 0) {
            MapleTrait a4;
            MapleTrait mapleTrait = a4;
            mapleTrait.K += a2;
            mapleTrait.a += a2;
            if (a3.getClient().isInGame()) {
                MapleCharacter mapleCharacter = a3;
                mapleCharacter.updateSingleStat(a4.k.a, a4.K);
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.showTraitGain(a4.k, a2));
            }
            a4.recalcLevel();
        }
    }

    public /* synthetic */ void clearLocalExp() {
        MapleTrait a2;
        a2.a = a2.K;
    }

    public /* synthetic */ void setExp(int a2) {
        MapleTrait a3;
        a3.K = a2;
        a3.a = a2;
        a3.recalcLevel();
    }

    public /* synthetic */ void addLocalExp(int a2) {
        a.a += a2;
    }

    public /* synthetic */ int getLevel() {
        MapleTrait a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getLocalTotalExp() {
        MapleTrait a2;
        return a2.a;
    }

    public /* synthetic */ int getExp() {
        MapleTrait a2;
        return a2.d;
    }

    public /* synthetic */ MapleTrait(MapleTraitType a2) {
        MapleTrait a3;
        MapleTrait mapleTrait = a3;
        MapleTrait mapleTrait2 = a3;
        a3.K = 0;
        mapleTrait2.a = 0;
        mapleTrait2.d = 0;
        mapleTrait.ALLATORIxDEMO = (byte)0;
        mapleTrait.k = a2;
    }

    public /* synthetic */ int getTotalExp() {
        MapleTrait a2;
        return a2.K;
    }

    public /* synthetic */ MapleTraitType getType() {
        MapleTrait a2;
        return a2.k;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (2 << 2 ^ 1);
        int cfr_ignored_0 = 5 << 4 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 5 << 4 ^ 1 << 1;
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

    public static final class MapleTraitType
    extends Enum<MapleTraitType> {
        public static final /* synthetic */ /* enum */ MapleTraitType \u9818\u5c0e\u529b;
        public static final /* synthetic */ /* enum */ MapleTraitType \u610f\u5fd7;
        public static final /* synthetic */ /* enum */ MapleTraitType \u9b45\u529b;
        public final /* synthetic */ int K;
        public final /* synthetic */ String d;
        public static final /* synthetic */ /* enum */ MapleTraitType \u6d1e\u5bdf\u529b;
        public static final /* synthetic */ /* enum */ MapleTraitType \u624b\u85dd;
        public static final /* synthetic */ /* enum */ MapleTraitType \u611f\u6027;
        public final /* synthetic */ MapleStat a;
        private static final /* synthetic */ MapleTraitType[] ALLATORIxDEMO;

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ MapleTraitType(int n22, MapleStat n22, String a2) {
            void a3;
            void a4;
            void var2_-1;
            void var1_-1;
            MapleTraitType a5;
            MapleTraitType mapleTraitType = a5;
            a5.K = (int)a2;
            mapleTraitType.a = a4;
            mapleTraitType.d = a3;
        }

        public static /* synthetic */ MapleTraitType[] values() {
            return (MapleTraitType[])ALLATORIxDEMO.clone();
        }

        public /* synthetic */ int getLimit() {
            MapleTraitType a2;
            return a2.K;
        }

        public static /* synthetic */ {
            \u9818\u5c0e\u529b = new MapleTraitType(MapOwner.ALLATORIxDEMO("\u9850\u5c30\u52d3"), 0, 500, MapleStat.CHARISMA, JsonMapConverter.ALLATORIxDEMO("g\u001de\u0007m\u0006i\u0014"));
            \u6d1e\u5bdf\u529b = new MapleTraitType(MapOwner.ALLATORIxDEMO("\u6d56\u5be1\u52d3"), 1, 500, MapleStat.INSIGHT, JsonMapConverter.ALLATORIxDEMO("\u001cj\u0006m\u0012l\u0001"));
            \u610f\u5fd7 = new MapleTraitType(MapOwner.ALLATORIxDEMO("\u6131\u5f9f"), 2, 500, MapleStat.WILL, JsonMapConverter.ALLATORIxDEMO("s\u001ch\u0019"));
            \u624b\u85dd = new MapleTraitType(MapOwner.ALLATORIxDEMO("\u6275\u8595"), 3, 500, MapleStat.CRAFT, JsonMapConverter.ALLATORIxDEMO("\u0016v\u0014b\u0001"));
            \u611f\u6027 = new MapleTraitType(MapOwner.ALLATORIxDEMO("\u6121\u606f"), 4, 500, MapleStat.SENSE, JsonMapConverter.ALLATORIxDEMO("\u0006a\u001bw\u0010"));
            \u9b45\u529b = new MapleTraitType(MapOwner.ALLATORIxDEMO("\u9b7b\u52d3"), 5, 5000, MapleStat.CHARM, JsonMapConverter.ALLATORIxDEMO("\u0016l\u0014v\u0018"));
            MapleTraitType[] arrmapleTraitType = new MapleTraitType[6];
            arrmapleTraitType[0] = \u9818\u5c0e\u529b;
            arrmapleTraitType[1] = \u6d1e\u5bdf\u529b;
            arrmapleTraitType[2] = \u610f\u5fd7;
            arrmapleTraitType[3] = \u624b\u85dd;
            arrmapleTraitType[4] = \u611f\u6027;
            arrmapleTraitType[5] = \u9b45\u529b;
            ALLATORIxDEMO = arrmapleTraitType;
        }

        public static /* synthetic */ MapleTraitType getByQuestName(String a2) {
            int n2;
            String string = a2;
            String string2 = string.substring(0, string.length() - 3);
            MapleTraitType[] arrmapleTraitType = MapleTraitType.values();
            int n3 = arrmapleTraitType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleTraitType mapleTraitType = arrmapleTraitType[n2];
                if (mapleTraitType.name().equals(string2)) {
                    return mapleTraitType;
                }
                n4 = ++n2;
            }
            return null;
        }

        public /* synthetic */ String getName() {
            MapleTraitType a2;
            return a2.d;
        }

        public static /* synthetic */ MapleTraitType valueOf(String a2) {
            return Enum.valueOf(MapleTraitType.class, a2);
        }

        public /* synthetic */ MapleStat getStat() {
            MapleTraitType a2;
            return a2.a;
        }
    }
}

