/*
 * Decompiled with CFR 0.150.
 */
package constants.skills;

import server.life.MonsterGlobalDropEntry;
import server.life.MonsterQuestDropEntry;
import tools.StringTool;

public final class SummonSkillAnimation
extends Enum<SummonSkillAnimation> {
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_32111006;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35111009;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_2221005;
    private static final /* synthetic */ SummonSkillAnimation[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35121003;
    private /* synthetic */ int[] d;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_2311006;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_14001005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5211014;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3120012;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3211005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5321004;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_12001004;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5211011;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_13001004;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_23111008;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35111010;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3101007;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35111005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35111011;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5321003;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_12111004;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_33111005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3121006;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_33111003;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_2121005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5211015;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5711001;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5211002;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3221005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35111002;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_23111010;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3220012;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_33111001;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_33101008;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35121009;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_3111005;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_15001004;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5220002;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35121010;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35121011;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5211001;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_11001004;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_35111001;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_2321003;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_5211016;
    public static final /* synthetic */ /* enum */ SummonSkillAnimation SKILL_23111009;

    public static /* synthetic */ SummonSkillAnimation valueOf(String a2) {
        return Enum.valueOf(SummonSkillAnimation.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SummonSkillAnimation(int[] arrn) {
        void a2;
        void var2_-1;
        void var1_-1;
        SummonSkillAnimation a3;
        a3.d = a2;
    }

    public static /* synthetic */ SummonSkillAnimation getById(int a2) {
        int n2;
        SummonSkillAnimation[] arrsummonSkillAnimation = SummonSkillAnimation.values();
        int n3 = arrsummonSkillAnimation.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            SummonSkillAnimation summonSkillAnimation = arrsummonSkillAnimation[n2];
            if (StringTool.getIntFromString(summonSkillAnimation.name()) == a2) {
                return summonSkillAnimation;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ SummonSkillAnimation[] values() {
        return (SummonSkillAnimation[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        int[] arrn = new int[2];
        arrn[0] = 4;
        arrn[1] = -124;
        SKILL_11001004 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001fe\u001ed\u001fd\u001e`"), 0, arrn);
        int[] arrn2 = new int[2];
        arrn2[0] = 4;
        arrn2[1] = -124;
        SKILL_12001004 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\u000b\\\n^\u000b^\nZ"), 1, arrn2);
        int[] arrn3 = new int[2];
        arrn3[0] = 4;
        arrn3[1] = -124;
        SKILL_13001004 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001fg\u001ed\u001fd\u001e`"), 2, arrn3);
        int[] arrn4 = new int[2];
        arrn4[0] = 4;
        arrn4[1] = -124;
        SKILL_12111004 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\u000b\\\u000b_\u000b^\nZ"), 3, arrn4);
        int[] arrn5 = new int[2];
        arrn5[0] = -124;
        arrn5[1] = 4;
        SKILL_14001005 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001f`\u001ed\u001fd\u001ea"), 4, arrn5);
        int[] arrn6 = new int[2];
        arrn6[0] = -124;
        arrn6[1] = 4;
        SKILL_15001004 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\u000b[\n^\u000b^\nZ"), 5, arrn6);
        int[] arrn7 = new int[2];
        arrn7[0] = -124;
        arrn7[1] = 4;
        SKILL_2121005 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qf\u001ff\u001fd\u001ea"), 6, arrn7);
        int[] arrn8 = new int[2];
        arrn8[0] = -124;
        arrn8[1] = 4;
        SKILL_2221005 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e\\\b\\\u000b^\n["), 7, arrn8);
        int[] arrn9 = new int[2];
        arrn9[0] = -124;
        arrn9[1] = 4;
        SKILL_23111008 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001cg\u001fe\u001fd\u001el"), 8, arrn9);
        int[] arrn10 = new int[2];
        arrn10[0] = -124;
        arrn10[1] = 4;
        SKILL_23111009 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\b]\u000b_\u000b^\nW"), 9, arrn10);
        int[] arrn11 = new int[2];
        arrn11[0] = -124;
        arrn11[1] = 4;
        SKILL_23111010 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001cg\u001fe\u001fd\u001fd"), 10, arrn11);
        int[] arrn12 = new int[2];
        arrn12[0] = 4;
        arrn12[1] = -124;
        SKILL_2321003 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e\\\t\\\u000b^\n]"), 11, arrn12);
        int[] arrn13 = new int[2];
        arrn13[0] = 4;
        arrn13[1] = -124;
        SKILL_2311006 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qf\u001de\u001fd\u001eb"), 12, arrn13);
        int[] arrn14 = new int[2];
        arrn14[0] = 4;
        arrn14[1] = -124;
        SKILL_3111005 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e]\u000b_\u000b^\n["), 13, arrn14);
        int[] arrn15 = new int[1];
        arrn15[0] = 4;
        SKILL_3120012 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qg\u001ff\u001ed\u001ff"), 14, arrn15);
        int[] arrn16 = new int[2];
        arrn16[0] = 4;
        arrn16[1] = -124;
        SKILL_3121006 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e]\u000b\\\u000b^\nX"), 15, arrn16);
        int[] arrn17 = new int[2];
        arrn17[0] = 4;
        arrn17[1] = -124;
        SKILL_3211005 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qg\u001ce\u001fd\u001ea"), 16, arrn17);
        int[] arrn18 = new int[2];
        arrn18[0] = 4;
        arrn18[1] = -124;
        SKILL_32111006 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t\\\u000b_\u000b^\nX"), 17, arrn18);
        int[] arrn19 = new int[2];
        arrn19[0] = 4;
        arrn19[1] = -124;
        SKILL_3221005 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qg\u001cf\u001fd\u001ea"), 18, arrn19);
        int[] arrn20 = new int[1];
        arrn20[0] = 4;
        SKILL_3220012 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e]\b\\\n^\u000b\\"), 19, arrn20);
        int[] arrn21 = new int[4];
        arrn21[0] = 17;
        arrn21[1] = -111;
        arrn21[2] = -112;
        arrn21[3] = 16;
        SKILL_33101008 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001dg\u001fd\u001fd\u001el"), 20, arrn21);
        int[] arrn22 = new int[2];
        arrn22[0] = 4;
        arrn22[1] = -124;
        SKILL_33111001 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t]\u000b_\u000b^\n_"), 21, arrn22);
        int[] arrn23 = new int[1];
        arrn23[0] = 4;
        SKILL_33111003 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001dg\u001fe\u001fd\u001eg"), 22, arrn23);
        int[] arrn24 = new int[2];
        arrn24[0] = 4;
        arrn24[1] = -124;
        SKILL_33111005 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t]\u000b_\u000b^\n["), 23, arrn24);
        int[] arrn25 = new int[6];
        arrn25[0] = -121;
        arrn25[1] = -122;
        arrn25[2] = 17;
        arrn25[3] = 16;
        arrn25[4] = 7;
        arrn25[5] = 6;
        SKILL_35111002 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001da\u001fe\u001fd\u001ef"), 24, arrn25);
        int[] arrn26 = new int[2];
        arrn26[0] = 17;
        arrn26[1] = 16;
        SKILL_35111005 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t[\u000b_\u000b^\n["), 25, arrn26);
        int[] arrn27 = new int[2];
        arrn27[0] = -124;
        arrn27[1] = 4;
        SKILL_35111009 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001da\u001fe\u001fd\u001em"), 26, arrn27);
        int[] arrn28 = new int[2];
        arrn28[0] = -124;
        arrn28[1] = 4;
        SKILL_35111010 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t[\u000b_\u000b^\u000b^"), 27, arrn28);
        int[] arrn29 = new int[2];
        arrn29[0] = 17;
        arrn29[1] = 16;
        SKILL_35111011 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001da\u001fe\u001fd\u001fe"), 28, arrn29);
        int[] arrn30 = new int[2];
        arrn30[0] = -124;
        arrn30[1] = 4;
        SKILL_35111001 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t[\u000b_\u000b^\n_"), 29, arrn30);
        int[] arrn31 = new int[4];
        arrn31[0] = -111;
        arrn31[1] = 17;
        arrn31[2] = 16;
        arrn31[3] = -112;
        SKILL_35121009 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001da\u001ff\u001fd\u001em"), 30, arrn31);
        int[] arrn32 = new int[2];
        arrn32[0] = -124;
        arrn32[1] = 4;
        SKILL_35121003 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t[\u000b\\\u000b^\n]"), 31, arrn32);
        int[] arrn33 = new int[2];
        arrn33[0] = 17;
        arrn33[1] = 16;
        SKILL_35121010 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("}\u001fg\u0018b\u000b\u001da\u001ff\u001fd\u001fd"), 32, arrn33);
        int[] arrn34 = new int[4];
        arrn34[0] = -111;
        arrn34[1] = 17;
        arrn34[2] = 16;
        arrn34[3] = -112;
        SKILL_35121011 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("i%s\"v1\t[\u000b\\\u000b^\u000b_"), 33, arrn34);
        int[] arrn35 = new int[2];
        arrn35[0] = 4;
        arrn35[1] = -124;
        SKILL_5211001 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qa\u001ce\u001fd\u001ee"), 34, arrn35);
        int[] arrn36 = new int[2];
        arrn36[0] = 4;
        arrn36[1] = -124;
        SKILL_5211002 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e[\b_\u000b^\n\\"), 35, arrn36);
        int[] arrn37 = new int[2];
        arrn37[0] = 4;
        arrn37[1] = -124;
        SKILL_5211011 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qa\u001ce\u001fd\u001fe"), 36, arrn37);
        int[] arrn38 = new int[2];
        arrn38[0] = -124;
        arrn38[1] = 4;
        SKILL_5211014 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e[\b_\u000b^\u000bZ"), 37, arrn38);
        int[] arrn39 = new int[2];
        arrn39[0] = 4;
        arrn39[1] = -124;
        SKILL_5211015 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qa\u001ce\u001fd\u001fa"), 38, arrn39);
        int[] arrn40 = new int[2];
        arrn40[0] = 4;
        arrn40[1] = -124;
        SKILL_5211016 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e[\b_\u000b^\u000bX"), 39, arrn40);
        int[] arrn41 = new int[4];
        arrn41[0] = -123;
        arrn41[1] = -124;
        arrn41[2] = 4;
        arrn41[3] = 5;
        SKILL_5220002 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qa\u001cf\u001ed\u001ef"), 40, arrn41);
        int[] arrn42 = new int[5];
        arrn42[0] = -123;
        arrn42[1] = 4;
        arrn42[2] = -124;
        arrn42[3] = 17;
        arrn42[4] = 5;
        SKILL_5321003 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e[\t\\\u000b^\n]"), 41, arrn42);
        int[] arrn43 = new int[2];
        arrn43[0] = 4;
        arrn43[1] = -124;
        SKILL_5321004 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qa\u001df\u001fd\u001e`"), 42, arrn43);
        int[] arrn44 = new int[2];
        arrn44[0] = -124;
        arrn44[1] = 4;
        SKILL_5711001 = new SummonSkillAnimation(MonsterGlobalDropEntry.ALLATORIxDEMO("=q'v\"e[\r_\u000b^\n_"), 43, arrn44);
        int[] arrn45 = new int[2];
        arrn45[0] = -124;
        arrn45[1] = 4;
        SKILL_3101007 = new SummonSkillAnimation(MonsterQuestDropEntry.ALLATORIxDEMO("\u0007e\u001db\u0018qg\u001fd\u001fd\u001ec"), 44, arrn45);
        SummonSkillAnimation[] arrsummonSkillAnimation = new SummonSkillAnimation[45];
        arrsummonSkillAnimation[0] = SKILL_11001004;
        arrsummonSkillAnimation[1] = SKILL_12001004;
        arrsummonSkillAnimation[2] = SKILL_13001004;
        arrsummonSkillAnimation[3] = SKILL_12111004;
        arrsummonSkillAnimation[4] = SKILL_14001005;
        arrsummonSkillAnimation[5] = SKILL_15001004;
        arrsummonSkillAnimation[6] = SKILL_2121005;
        arrsummonSkillAnimation[7] = SKILL_2221005;
        arrsummonSkillAnimation[8] = SKILL_23111008;
        arrsummonSkillAnimation[9] = SKILL_23111009;
        arrsummonSkillAnimation[10] = SKILL_23111010;
        arrsummonSkillAnimation[11] = SKILL_2321003;
        arrsummonSkillAnimation[12] = SKILL_2311006;
        arrsummonSkillAnimation[13] = SKILL_3111005;
        arrsummonSkillAnimation[14] = SKILL_3120012;
        arrsummonSkillAnimation[15] = SKILL_3121006;
        arrsummonSkillAnimation[16] = SKILL_3211005;
        arrsummonSkillAnimation[17] = SKILL_32111006;
        arrsummonSkillAnimation[18] = SKILL_3221005;
        arrsummonSkillAnimation[19] = SKILL_3220012;
        arrsummonSkillAnimation[20] = SKILL_33101008;
        arrsummonSkillAnimation[21] = SKILL_33111001;
        arrsummonSkillAnimation[22] = SKILL_33111003;
        arrsummonSkillAnimation[23] = SKILL_33111005;
        arrsummonSkillAnimation[24] = SKILL_35111002;
        arrsummonSkillAnimation[25] = SKILL_35111005;
        arrsummonSkillAnimation[26] = SKILL_35111009;
        arrsummonSkillAnimation[27] = SKILL_35111010;
        arrsummonSkillAnimation[28] = SKILL_35111011;
        arrsummonSkillAnimation[29] = SKILL_35111001;
        arrsummonSkillAnimation[30] = SKILL_35121009;
        arrsummonSkillAnimation[31] = SKILL_35121003;
        arrsummonSkillAnimation[32] = SKILL_35121010;
        arrsummonSkillAnimation[33] = SKILL_35121011;
        arrsummonSkillAnimation[34] = SKILL_5211001;
        arrsummonSkillAnimation[35] = SKILL_5211002;
        arrsummonSkillAnimation[36] = SKILL_5211011;
        arrsummonSkillAnimation[37] = SKILL_5211014;
        arrsummonSkillAnimation[38] = SKILL_5211015;
        arrsummonSkillAnimation[39] = SKILL_5211016;
        arrsummonSkillAnimation[40] = SKILL_5220002;
        arrsummonSkillAnimation[41] = SKILL_5321003;
        arrsummonSkillAnimation[42] = SKILL_5321004;
        arrsummonSkillAnimation[43] = SKILL_5711001;
        arrsummonSkillAnimation[44] = SKILL_3101007;
        ALLATORIxDEMO = arrsummonSkillAnimation;
    }

    public static /* synthetic */ boolean checkAnimation(int a2, int a3) {
        if (SummonSkillAnimation.getById(a2) != null) {
            int n2;
            int[] arrn = SummonSkillAnimation.getById((int)a2).d;
            int n3 = SummonSkillAnimation.getById((int)a2).d.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                if (arrn[n2] == a3) {
                    return true;
                }
                n4 = ++n2;
            }
            return false;
        }
        return false;
    }
}

