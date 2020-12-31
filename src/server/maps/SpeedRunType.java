/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import FuckingHackerToby.L;
import client.MapleCoolDownValueHolder;

public final class SpeedRunType
extends Enum<SpeedRunType> {
    public static final /* synthetic */ /* enum */ SpeedRunType Pink_Bean;
    public static final /* synthetic */ /* enum */ SpeedRunType Dunas_2;
    public static final /* synthetic */ /* enum */ SpeedRunType VonLeon;
    public static final /* synthetic */ /* enum */ SpeedRunType Papulatus;
    public static final /* synthetic */ /* enum */ SpeedRunType Aufhaven;
    public static final /* synthetic */ /* enum */ SpeedRunType Targa;
    public static final /* synthetic */ /* enum */ SpeedRunType Chinese_Lion;
    public static final /* synthetic */ /* enum */ SpeedRunType Dunas;
    public static final /* synthetic */ /* enum */ SpeedRunType Nibergen;
    public static final /* synthetic */ /* enum */ SpeedRunType Scarlion;
    public static final /* synthetic */ /* enum */ SpeedRunType Zakum;
    public static final /* synthetic */ /* enum */ SpeedRunType Core_Blaze;
    public static final /* synthetic */ /* enum */ SpeedRunType Chaos_Zakum;
    public static final /* synthetic */ /* enum */ SpeedRunType Nameless_Magic_Monster;
    private static final /* synthetic */ SpeedRunType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ SpeedRunType Vergamot;
    public static final /* synthetic */ /* enum */ SpeedRunType Horntail;
    public static final /* synthetic */ /* enum */ SpeedRunType ChaosHT;
    public static final /* synthetic */ /* enum */ SpeedRunType NULL;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SpeedRunType() {
        void var2_-1;
        void var1_-1;
        SpeedRunType a2;
    }

    public static /* synthetic */ SpeedRunType valueOf(String a2) {
        return Enum.valueOf(SpeedRunType.class, a2);
    }

    public static /* synthetic */ SpeedRunType[] values() {
        return (SpeedRunType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        NULL = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u0015v\u0017o"), 0);
        Horntail = new SpeedRunType(L.ALLATORIxDEMO("g@]A[NFC"), 1);
        ChaosHT = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("`3B4P\u0013w"), 2);
        Papulatus = new SpeedRunType(L.ALLATORIxDEMO("\u007fN_ZCN[Z\\"), 3);
        Nameless_Magic_Monster = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u0015B6F7F(P\u0004n:D2@\u0004n4M(W>Q"), 4);
        Vergamot = new SpeedRunType(L.ALLATORIxDEMO("yJ]HNB@["), 5);
        Dunas = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("g.M:P"), 6);
        Nibergen = new SpeedRunType(L.ALLATORIxDEMO("aFMJ]HJA"), 7);
        Dunas_2 = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("g.M:P\u0004\u0011"), 8);
        Core_Blaze = new SpeedRunType(L.ALLATORIxDEMO("l@]JpmCNUJ"), 9);
        Aufhaven = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("\u001aV=K:U>M"), 10);
        Scarlion = new SpeedRunType(L.ALLATORIxDEMO("|LN]CF@A"), 11);
        Targa = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("w:Q<B"), 12);
        Pink_Bean = new SpeedRunType(L.ALLATORIxDEMO("\u007fFADpmJNA"), 13);
        Zakum = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("y:H.N"), 14);
        Chaos_Zakum = new SpeedRunType(L.ALLATORIxDEMO("lGN@\\puNDZB"), 15);
        VonLeon = new SpeedRunType(MapleCoolDownValueHolder.ALLATORIxDEMO("u4M\u0017F4M"), 16);
        Chinese_Lion = new SpeedRunType(L.ALLATORIxDEMO("lGFAJ\\JpcF@A"), 17);
        SpeedRunType[] arrspeedRunType = new SpeedRunType[18];
        arrspeedRunType[0] = NULL;
        arrspeedRunType[1] = Horntail;
        arrspeedRunType[2] = ChaosHT;
        arrspeedRunType[3] = Papulatus;
        arrspeedRunType[4] = Nameless_Magic_Monster;
        arrspeedRunType[5] = Vergamot;
        arrspeedRunType[6] = Dunas;
        arrspeedRunType[7] = Nibergen;
        arrspeedRunType[8] = Dunas_2;
        arrspeedRunType[9] = Core_Blaze;
        arrspeedRunType[10] = Aufhaven;
        arrspeedRunType[11] = Scarlion;
        arrspeedRunType[12] = Targa;
        arrspeedRunType[13] = Pink_Bean;
        arrspeedRunType[14] = Zakum;
        arrspeedRunType[15] = Chaos_Zakum;
        arrspeedRunType[16] = VonLeon;
        arrspeedRunType[17] = Chinese_Lion;
        ALLATORIxDEMO = arrspeedRunType;
    }
}

