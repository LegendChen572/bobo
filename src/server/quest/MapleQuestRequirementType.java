/*
 * Decompiled with CFR 0.150.
 */
package server.quest;

import server.Timer;
import server.buffs.AbstractBuffClass;

public final class MapleQuestRequirementType
extends Enum<MapleQuestRequirementType> {
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType willMin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType partyQuest_S;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType normalAutoStart;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType startscript;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType item;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType craftMin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType interval;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType job;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType mob;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType subJobFlags;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType pop;
    private static final /* synthetic */ MapleQuestRequirementType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType pettamenessmin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType mbcard;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType questComplete;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType end;
    public final /* synthetic */ byte d;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType charmMin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType job_TW;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType UNDEFINED;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType mbmin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType pet;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType endscript;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType npc;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType senseMin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType lvmin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType quest;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType charismaMin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType lvmax;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType dayByDay;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType insightMin;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType skill;
    public static final /* synthetic */ /* enum */ MapleQuestRequirementType fieldEnter;

    public static /* synthetic */ {
        UNDEFINED = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("A.P%R)Z%P"), 0, -1);
        job = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("tz|"), 1, 0);
        item = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("\t`\u0005y"), 2, 1);
        quest = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("o`{fj"), 3, 2);
        lvmin = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("x\u0016y\tz"), 4, 3);
        lvmax = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("rcstf"), 5, 4);
        end = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("q\u000ep"), 6, 5);
        mob = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("sz|"), 7, 6);
        npc = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("z\u0010w"), 8, 7);
        fieldEnter = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("swprq[{jpl"), 9, 8);
        interval = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("\tz\u0014q\u0012b\u0001x"), 10, 9);
        startscript = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("ma\u007fgjf}gwej"), 11, 10);
        endscript = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("q\u000ep\u0013w\u0012}\u0010`"), 12, 10);
        pet = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("npj"), 13, 11);
        pettamenessmin = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("\u0010q\u0014`\u0001y\u0005z\u0005g\u0013y\tz"), 14, 12);
        mbmin = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("sws|p"), 15, 13);
        questComplete = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("e\u0015q\u0013`#{\rd\fq\u0014q"), 16, 14);
        pop = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("nzn"), 17, 15);
        skill = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("g\u000b}\fx"), 18, 16);
        mbcard = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("x|v\u007fgz"), 19, 17);
        subJobFlags = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("g\u0015v*{\u0002R\fu\u0007g"), 20, 18);
        dayByDay = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("q\u007fl\\lZtg"), 21, 19);
        normalAutoStart = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("z\u000ff\ru\fU\u0015`\u000fG\u0014u\u0012`"), 22, 20);
        partyQuest_S = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("e\u007fgjlO`{fjJM"), 23, 21);
        charmMin = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("\u0003|\u0001f\rY\tz"), 24, 22);
        senseMin = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("f{{mpS|p"), 25, 23);
        craftMin = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("\u0003f\u0001r\u0014Y\tz"), 26, 24);
        willMin = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("i|ryS|p"), 27, 25);
        charismaMin = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("w\bu\u0012}\u0013y\u0001Y\tz"), 28, 26);
        insightMin = new MapleQuestRequirementType(AbstractBuffClass.ALLATORIxDEMO("|pfwrvaS|p"), 29, 27);
        job_TW = new MapleQuestRequirementType(Timer.ALLATORIxDEMO("\n{\u0002K4C"), 30, 28);
        MapleQuestRequirementType[] arrmapleQuestRequirementType = new MapleQuestRequirementType[31];
        arrmapleQuestRequirementType[0] = UNDEFINED;
        arrmapleQuestRequirementType[1] = job;
        arrmapleQuestRequirementType[2] = item;
        arrmapleQuestRequirementType[3] = quest;
        arrmapleQuestRequirementType[4] = lvmin;
        arrmapleQuestRequirementType[5] = lvmax;
        arrmapleQuestRequirementType[6] = end;
        arrmapleQuestRequirementType[7] = mob;
        arrmapleQuestRequirementType[8] = npc;
        arrmapleQuestRequirementType[9] = fieldEnter;
        arrmapleQuestRequirementType[10] = interval;
        arrmapleQuestRequirementType[11] = startscript;
        arrmapleQuestRequirementType[12] = endscript;
        arrmapleQuestRequirementType[13] = pet;
        arrmapleQuestRequirementType[14] = pettamenessmin;
        arrmapleQuestRequirementType[15] = mbmin;
        arrmapleQuestRequirementType[16] = questComplete;
        arrmapleQuestRequirementType[17] = pop;
        arrmapleQuestRequirementType[18] = skill;
        arrmapleQuestRequirementType[19] = mbcard;
        arrmapleQuestRequirementType[20] = subJobFlags;
        arrmapleQuestRequirementType[21] = dayByDay;
        arrmapleQuestRequirementType[22] = normalAutoStart;
        arrmapleQuestRequirementType[23] = partyQuest_S;
        arrmapleQuestRequirementType[24] = charmMin;
        arrmapleQuestRequirementType[25] = senseMin;
        arrmapleQuestRequirementType[26] = craftMin;
        arrmapleQuestRequirementType[27] = willMin;
        arrmapleQuestRequirementType[28] = charismaMin;
        arrmapleQuestRequirementType[29] = insightMin;
        arrmapleQuestRequirementType[30] = job_TW;
        ALLATORIxDEMO = arrmapleQuestRequirementType;
    }

    public static /* synthetic */ MapleQuestRequirementType[] values() {
        return (MapleQuestRequirementType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ MapleQuestRequirementType getByType(byte a2) {
        int n2;
        MapleQuestRequirementType[] arrmapleQuestRequirementType = MapleQuestRequirementType.values();
        int n3 = arrmapleQuestRequirementType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleQuestRequirementType mapleQuestRequirementType = arrmapleQuestRequirementType[n2];
            if (mapleQuestRequirementType.getType() == a2) {
                return mapleQuestRequirementType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ MapleQuestRequirementType valueOf(String a2) {
        return Enum.valueOf(MapleQuestRequirementType.class, a2);
    }

    public /* synthetic */ MapleQuestRequirementType getITEM() {
        return item;
    }

    public /* synthetic */ byte getType() {
        MapleQuestRequirementType a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleQuestRequirementType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        MapleQuestRequirementType a3;
        a3.d = (byte)a2;
    }

    public static /* synthetic */ MapleQuestRequirementType getByWZName(String a2) {
        try {
            return MapleQuestRequirementType.valueOf(a2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return UNDEFINED;
        }
    }
}

