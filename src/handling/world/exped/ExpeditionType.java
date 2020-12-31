/*
 * Decompiled with CFR 0.150.
 */
package handling.world.exped;

import handling.world.MapleMessengerCharacter;
import server.MobSkillData;

public final class ExpeditionType
extends Enum<ExpeditionType> {
    public static final /* synthetic */ /* enum */ ExpeditionType ChaosHT;
    public static final /* synthetic */ /* enum */ ExpeditionType Horntail;
    public static final /* synthetic */ /* enum */ ExpeditionType CWKPQ;
    public /* synthetic */ int maxParty;
    public static final /* synthetic */ /* enum */ ExpeditionType Zakum;
    public /* synthetic */ int maxLevel;
    public /* synthetic */ int minLevel;
    public static final /* synthetic */ /* enum */ ExpeditionType Pink_Bean;
    public /* synthetic */ int exped;
    public static final /* synthetic */ /* enum */ ExpeditionType Cygnus;
    public /* synthetic */ int maxMembers;
    public static final /* synthetic */ /* enum */ ExpeditionType Chaos_Zakum;
    public static final /* synthetic */ /* enum */ ExpeditionType Normal_Balrog;
    private static final /* synthetic */ ExpeditionType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ ExpeditionType Von_Leon;
    public static final /* synthetic */ /* enum */ ExpeditionType Arkarium;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ExpeditionType(int n22, int n22, int a2, int a3) {
        void a4;
        void a5;
        void var2_-1;
        void var1_-1;
        ExpeditionType a6;
        ExpeditionType expeditionType = a6;
        a6.maxMembers = a2;
        expeditionType.exped = a3;
        expeditionType.maxParty = a2 / 2 + (a2 % 2 > 0 ? 1 : 0);
        ExpeditionType expeditionType2 = a6;
        expeditionType2.minLevel = a5;
        expeditionType2.maxLevel = a4;
    }

    public static /* synthetic */ ExpeditionType valueOf(String a2) {
        return Enum.valueOf(ExpeditionType.class, a2);
    }

    public static /* synthetic */ ExpeditionType[] values() {
        return (ExpeditionType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ ExpeditionType getById(int a2) {
        int n2;
        ExpeditionType[] arrexpeditionType = ExpeditionType.values();
        int n3 = arrexpeditionType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            ExpeditionType expeditionType = arrexpeditionType[n2];
            if (expeditionType.exped == a2) {
                return expeditionType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ {
        Normal_Balrog = new ExpeditionType(MobSkillData.ALLATORIxDEMO("C\u000f\u007f\rl\fR\"l\f\u007f\u000fj"), 0, 15, 2001, 50, 200);
        Horntail = new ExpeditionType(MapleMessengerCharacter.ALLATORIxDEMO("Fk|jzegh"), 1, 30, 2003, 80, 200);
        Zakum = new ExpeditionType(MobSkillData.ALLATORIxDEMO("W\u0001f\u0015`"), 2, 30, 2002, 50, 200);
        Chaos_Zakum = new ExpeditionType(MapleMessengerCharacter.ALLATORIxDEMO("GfeawQ^oo{i"), 3, 30, 2005, 100, 200);
        ChaosHT = new ExpeditionType(MobSkillData.ALLATORIxDEMO("N\bl\u000f~(Y"), 4, 30, 2006, 110, 200);
        Pink_Bean = new ExpeditionType(MapleMessengerCharacter.ALLATORIxDEMO("Tgje[Laoj"), 5, 30, 2004, 140, 200);
        CWKPQ = new ExpeditionType(MobSkillData.ALLATORIxDEMO("N7F0\\"), 6, 30, 2007, 90, 200);
        Von_Leon = new ExpeditionType(MapleMessengerCharacter.ALLATORIxDEMO("Xk`[Baaj"), 7, 30, 2008, 120, 200);
        Cygnus = new ExpeditionType(MobSkillData.ALLATORIxDEMO("#t\u0007c\u0015~"), 8, 18, 2009, 170, 200);
        Arkarium = new ExpeditionType(MapleMessengerCharacter.ALLATORIxDEMO("Ovee|m{i"), 9, 18, 2010, 120, 200);
        ExpeditionType[] arrexpeditionType = new ExpeditionType[10];
        arrexpeditionType[0] = Normal_Balrog;
        arrexpeditionType[1] = Horntail;
        arrexpeditionType[2] = Zakum;
        arrexpeditionType[3] = Chaos_Zakum;
        arrexpeditionType[4] = ChaosHT;
        arrexpeditionType[5] = Pink_Bean;
        arrexpeditionType[6] = CWKPQ;
        arrexpeditionType[7] = Von_Leon;
        arrexpeditionType[8] = Cygnus;
        arrexpeditionType[9] = Arkarium;
        ALLATORIxDEMO = arrexpeditionType;
    }
}

