/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 */
package client.inventory;

import client.messages.commands.player.\u592d\u58fd\u8c37;
import handling.channel.handler.UserInterfaceHandler;
import handling.world.MapleMessengerCharacter;
import java.util.Arrays;
import java.util.List;
import server.maps.MapleNodes;

public final class EquipAdditions
extends Enum<EquipAdditions> {
    public static final /* synthetic */ /* enum */ EquipAdditions hpmpchange;
    private final /* synthetic */ String a;
    public static final /* synthetic */ /* enum */ EquipAdditions elemboost;
    private static final /* synthetic */ EquipAdditions[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ EquipAdditions boss;
    public static final /* synthetic */ /* enum */ EquipAdditions statinc;
    public static final /* synthetic */ /* enum */ EquipAdditions mobcategory;
    private final /* synthetic */ boolean d;
    public static final /* synthetic */ /* enum */ EquipAdditions skill;
    private final /* synthetic */ String K;
    private final /* synthetic */ String B;
    public static final /* synthetic */ /* enum */ EquipAdditions critical;
    private final /* synthetic */ String g;
    private final /* synthetic */ String E;
    public static final /* synthetic */ /* enum */ EquipAdditions mobdie;
    private final /* synthetic */ String k;

    public final /* synthetic */ String getValue2() {
        EquipAdditions a2;
        return a2.g;
    }

    public static /* synthetic */ EquipAdditions[] values() {
        return (EquipAdditions[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ EquipAdditions valueOf(String a2) {
        return Enum.valueOf(EquipAdditions.class, a2);
    }

    public final /* synthetic */ String getValue6() {
        EquipAdditions a2;
        return a2.a;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ EquipAdditions(String string2, String string2, String a2, String a3, String a4, String a5) {
        void a6;
        void a7;
        void var2_-1;
        void var1_-1;
        EquipAdditions a8;
        EquipAdditions equipAdditions = a8;
        EquipAdditions equipAdditions2 = a8;
        EquipAdditions equipAdditions3 = a8;
        a8.E = a2;
        equipAdditions3.g = a3;
        equipAdditions3.B = a4;
        equipAdditions2.k = a5;
        equipAdditions2.K = a7;
        equipAdditions.a = a6;
        equipAdditions.d = false;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ EquipAdditions(String string2, String string2, boolean a2) {
        void a3;
        void a4;
        void var2_-1;
        void var1_-1;
        EquipAdditions a5;
        EquipAdditions equipAdditions = a5;
        EquipAdditions equipAdditions2 = a5;
        EquipAdditions equipAdditions3 = a5;
        a5.E = (String)a2;
        equipAdditions3.g = a4;
        equipAdditions3.B = "";
        equipAdditions2.k = "";
        equipAdditions2.K = "";
        equipAdditions.a = "";
        equipAdditions.d = a3;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ EquipAdditions(String string2, String string2) {
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        EquipAdditions a4;
        EquipAdditions equipAdditions = a4;
        EquipAdditions equipAdditions2 = a4;
        EquipAdditions equipAdditions3 = a4;
        a4.E = a3;
        equipAdditions3.g = a2;
        equipAdditions3.B = "";
        equipAdditions2.k = "";
        equipAdditions2.K = "";
        equipAdditions.a = "";
        equipAdditions.d = false;
    }

    public static final /* synthetic */ EquipAdditions fromString(String a2) {
        int n2;
        EquipAdditions[] arrequipAdditions = EquipAdditions.values();
        int n3 = arrequipAdditions.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            EquipAdditions equipAdditions = arrequipAdditions[n2];
            if (equipAdditions.name().equalsIgnoreCase(a2)) {
                return equipAdditions;
            }
            n4 = ++n2;
        }
        return null;
    }

    public final /* synthetic */ String getValue4() {
        EquipAdditions a2;
        return a2.k;
    }

    public final /* synthetic */ String getValue3() {
        EquipAdditions a2;
        return a2.B;
    }

    public final /* synthetic */ String getValue5() {
        EquipAdditions a2;
        return a2.K;
    }

    public final /* synthetic */ boolean isElement() {
        EquipAdditions a2;
        return a2.d;
    }

    public static /* synthetic */ {
        elemboost = new EquipAdditions(MapleNodes.ALLATORIxDEMO("IbIcNaC}X"), 0, UserInterfaceHandler.ALLATORIxDEMO("QWQVbTX"), MapleNodes.ALLATORIxDEMO("IbIcza@"), true);
        mobcategory = new EquipAdditions(UserInterfaceHandler.ALLATORIxDEMO("YTVXUOQ\\[IM"), 1, MapleNodes.ALLATORIxDEMO("mMzIiC|U"), UserInterfaceHandler.ALLATORIxDEMO("_UVU\\Q"));
        critical = new EquipAdditions(MapleNodes.ALLATORIxDEMO("m^gXgOo@"), 2, UserInterfaceHandler.ALLATORIxDEMO("KFTV"), MapleNodes.ALLATORIxDEMO("jMcMiI"));
        boss = new EquipAdditions(UserInterfaceHandler.ALLATORIxDEMO("Y[HG"), 3, MapleNodes.ALLATORIxDEMO("~^aN"), UserInterfaceHandler.ALLATORIxDEMO("_UVU\\Q"));
        mobdie = new EquipAdditions(MapleNodes.ALLATORIxDEMO("cClHgI"), 4, UserInterfaceHandler.ALLATORIxDEMO("\\K}UWtZv[YpRQ"), MapleNodes.ALLATORIxDEMO("A~e`OABCClhgI"));
        hpmpchange = new EquipAdditions(UserInterfaceHandler.ALLATORIxDEMO("SDVDX\\ZZ\\Q"), 5, MapleNodes.ALLATORIxDEMO("f\\MDoBiI||k^ZEcI"), UserInterfaceHandler.ALLATORIxDEMO("VDx\\ZZ\\QId^Fo]VQ"));
        skill = new EquipAdditions(MapleNodes.ALLATORIxDEMO("_eEb@"), 6, UserInterfaceHandler.ALLATORIxDEMO("RP"), MapleNodes.ALLATORIxDEMO("@kZk@"));
        statinc = new EquipAdditions(UserInterfaceHandler.ALLATORIxDEMO("GOUO]UW"), 7, MapleNodes.ALLATORIxDEMO("gBmhKt"), UserInterfaceHandler.ALLATORIxDEMO("RZX}u`"), MapleNodes.ALLATORIxDEMO("gBm`[g"), UserInterfaceHandler.ALLATORIxDEMO("RZXdzp"), MapleNodes.ALLATORIxDEMO("gBm\u007f~IkH"), UserInterfaceHandler.ALLATORIxDEMO("RZXgof"));
        EquipAdditions[] arrequipAdditions = new EquipAdditions[8];
        arrequipAdditions[0] = elemboost;
        arrequipAdditions[1] = mobcategory;
        arrequipAdditions[2] = critical;
        arrequipAdditions[3] = boss;
        arrequipAdditions[4] = mobdie;
        arrequipAdditions[5] = hpmpchange;
        arrequipAdditions[6] = skill;
        arrequipAdditions[7] = statinc;
        ALLATORIxDEMO = arrequipAdditions;
    }

    public final /* synthetic */ String getValue1() {
        EquipAdditions a2;
        return a2.E;
    }

    public static final class RingSet
    extends Enum<RingSet> {
        public static final /* synthetic */ /* enum */ RingSet Job_Ring;
        public /* synthetic */ List<Integer> id;
        private static final /* synthetic */ RingSet[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ RingSet Evolving_Ring;
        public static final /* synthetic */ /* enum */ RingSet Source_Ring;
        public static final /* synthetic */ /* enum */ RingSet Angelic_Ring;
        public static final /* synthetic */ /* enum */ RingSet Evolving_Ring_II;

        public static /* synthetic */ RingSet[] values() {
            return (RingSet[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ RingSet valueOf(String a2) {
            return Enum.valueOf(RingSet.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ RingSet(Integer ... arrinteger) {
            void a2;
            void var2_-1;
            void var1_-1;
            RingSet a3;
            a3.id = Arrays.asList(a2);
        }

        public static /* synthetic */ {
            Integer[] arrinteger = new Integer[5];
            arrinteger[0] = 1112435;
            arrinteger[1] = 1112436;
            arrinteger[2] = 1112437;
            arrinteger[3] = 1112438;
            arrinteger[4] = 1112439;
            Source_Ring = new RingSet(MapleMessengerCharacter.ALLATORIxDEMO("Waq|gk[\\m`c"), 0, arrinteger);
            Integer[] arrinteger2 = new Integer[3];
            arrinteger2[0] = 1112585;
            arrinteger2[1] = 1112586;
            arrinteger2[2] = 1112594;
            Angelic_Ring = new RingSet(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"5\b\u0013\u0003\u0018\u000f\u00179&\u000f\u001a\u0001"), 1, arrinteger2);
            Integer[] arrinteger3 = new Integer[7];
            arrinteger3[0] = 1112427;
            arrinteger3[1] = 1112428;
            arrinteger3[2] = 1112429;
            arrinteger3[3] = 1112405;
            arrinteger3[4] = 1112445;
            arrinteger3[5] = 1112591;
            arrinteger3[6] = 1112592;
            Job_Ring = new RingSet(MapleMessengerCharacter.ALLATORIxDEMO("Dkl[\\m`c"), 2, arrinteger3);
            Integer[] arrinteger4 = new Integer[35];
            arrinteger4[0] = 1112499;
            arrinteger4[1] = 1112500;
            arrinteger4[2] = 1112501;
            arrinteger4[3] = 1112502;
            arrinteger4[4] = 1112503;
            arrinteger4[5] = 1112504;
            arrinteger4[6] = 1112505;
            arrinteger4[7] = 1112506;
            arrinteger4[8] = 1112507;
            arrinteger4[9] = 1112508;
            arrinteger4[10] = 1112509;
            arrinteger4[11] = 1112510;
            arrinteger4[12] = 1112511;
            arrinteger4[13] = 1112512;
            arrinteger4[14] = 1112513;
            arrinteger4[15] = 1112514;
            arrinteger4[16] = 1112515;
            arrinteger4[17] = 1112516;
            arrinteger4[18] = 1112517;
            arrinteger4[19] = 1112518;
            arrinteger4[20] = 1112519;
            arrinteger4[21] = 1112520;
            arrinteger4[22] = 1112521;
            arrinteger4[23] = 1112522;
            arrinteger4[24] = 1112523;
            arrinteger4[25] = 1112524;
            arrinteger4[26] = 1112525;
            arrinteger4[27] = 1112526;
            arrinteger4[28] = 1112527;
            arrinteger4[29] = 1112528;
            arrinteger4[30] = 1112529;
            arrinteger4[31] = 1112530;
            arrinteger4[32] = 1112531;
            arrinteger4[33] = 1112532;
            arrinteger4[34] = 1112533;
            Evolving_Ring = new RingSet(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0002\t\u0018\u0010\u001d\b\u00139&\u000f\u001a\u0001"), 3, arrinteger4);
            Integer[] arrinteger5 = new Integer[35];
            arrinteger5[0] = 1112614;
            arrinteger5[1] = 1112615;
            arrinteger5[2] = 1112616;
            arrinteger5[3] = 1112617;
            arrinteger5[4] = 1112618;
            arrinteger5[5] = 1112619;
            arrinteger5[6] = 1112620;
            arrinteger5[7] = 1112621;
            arrinteger5[8] = 1112622;
            arrinteger5[9] = 1112623;
            arrinteger5[10] = 1112624;
            arrinteger5[11] = 1112625;
            arrinteger5[12] = 1112626;
            arrinteger5[13] = 1112627;
            arrinteger5[14] = 1112628;
            arrinteger5[15] = 1112629;
            arrinteger5[16] = 1112630;
            arrinteger5[17] = 1112631;
            arrinteger5[18] = 1112632;
            arrinteger5[19] = 1112633;
            arrinteger5[20] = 1112634;
            arrinteger5[21] = 1112635;
            arrinteger5[22] = 1112636;
            arrinteger5[23] = 1112637;
            arrinteger5[24] = 1112638;
            arrinteger5[25] = 1112639;
            arrinteger5[26] = 1112640;
            arrinteger5[27] = 1112641;
            arrinteger5[28] = 1112642;
            arrinteger5[29] = 1112643;
            arrinteger5[30] = 1112644;
            arrinteger5[31] = 1112645;
            arrinteger5[32] = 1112646;
            arrinteger5[33] = 1112647;
            arrinteger5[34] = 1112648;
            Evolving_Ring_II = new RingSet(MapleMessengerCharacter.ALLATORIxDEMO("Krahxm`cQVgji[GM"), 4, arrinteger5);
            RingSet[] arrringSet = new RingSet[5];
            arrringSet[0] = Source_Ring;
            arrringSet[1] = Angelic_Ring;
            arrringSet[2] = Job_Ring;
            arrringSet[3] = Evolving_Ring;
            arrringSet[4] = Evolving_Ring_II;
            ALLATORIxDEMO = arrringSet;
        }
    }
}

