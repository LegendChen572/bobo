/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import server.buffs.AbstractBuffClass;
import tools.Quadra;

/*
 * Exception performing whole class analysis ignored.
 */
public final class SpecialEffect
extends Enum<SpecialEffect>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ SpecialEffect BLACK_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect BLESS_LUCK_CHARM;
    public static final /* synthetic */ /* enum */ SpecialEffect LOTTERY_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect SOUND;
    public static final /* synthetic */ /* enum */ SpecialEffect ITEM_LEVEL_UP;
    public static final /* synthetic */ /* enum */ SpecialEffect WZ_EFFECT2;
    public static final /* synthetic */ /* enum */ SpecialEffect SPECIAL_SKILL;
    public static final /* synthetic */ /* enum */ SpecialEffect BUFF_ITEM_SUB_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect ITEM_GAIN;
    public static final /* synthetic */ /* enum */ SpecialEffect PICKUP_MONSTER_CARD;
    public static final /* synthetic */ /* enum */ SpecialEffect RECHARGE_STATE;
    public static final /* synthetic */ /* enum */ SpecialEffect HEAL_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect QUEST_COMPLETE;
    public static final /* synthetic */ /* enum */ SpecialEffect LEVEL_UP;
    public static final /* synthetic */ /* enum */ SpecialEffect USE_AMULET;
    public static final /* synthetic */ /* enum */ SpecialEffect WZ_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect SOUL_STONE;
    public static final /* synthetic */ /* enum */ SpecialEffect EXP_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect CHANGE_ELF;
    public static final /* synthetic */ /* enum */ SpecialEffect WHEEL;
    public static final /* synthetic */ /* enum */ SpecialEffect AVOID_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect PET_LEVELUP;
    public static final /* synthetic */ /* enum */ SpecialEffect MULUNG_DOJO_UP;
    public static final /* synthetic */ /* enum */ SpecialEffect PVP_CHAMPION;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ SpecialEffect BUFF_ITEM_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect HONOR_LEVELUP;
    public static final /* synthetic */ /* enum */ SpecialEffect CRAFT_EFFECT;
    private static final /* synthetic */ SpecialEffect[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ SpecialEffect POISON_EFFECT;
    public static final /* synthetic */ /* enum */ SpecialEffect ITEM_MAKER_SUCCESS;
    public static final /* synthetic */ /* enum */ SpecialEffect CHANGE_JOB;
    public static final /* synthetic */ /* enum */ SpecialEffect HP_EFFECT;

    @Override
    public /* synthetic */ short getValue() {
        SpecialEffect a2;
        return a2.d;
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void reloadValues() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK], 1[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ SpecialEffect(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        SpecialEffect a3;
        SpecialEffect specialEffect = a3;
        a3.d = 0;
        specialEffect.d = 0;
        specialEffect.d = (short)a2;
    }

    public static /* synthetic */ {
        LEVEL_UP = new SpecialEffect(Quadra.ALLATORIxDEMO("z\f`\fz\u0016c\u0019"), 0, 0);
        ITEM_GAIN = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("WA[XAR_\\P"), 1, 3);
        PET_LEVELUP = new SpecialEffect(Quadra.ALLATORIxDEMO("\u0019s\u001di\u0005s\u001fs\u0005c\u0019"), 2, 4);
        SPECIAL_SKILL = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("ME[VWTRJM^WYR"), 3, 0);
        USE_AMULET = new SpecialEffect(Quadra.ALLATORIxDEMO("c\u001as\u0016w\u0004c\u0005s\u001d"), 4, 6);
        MULUNG_DOJO_UP = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("XKYK[YJZZTZA@N"), 5, 7);
        CHANGE_JOB = new SpecialEffect(Quadra.ALLATORIxDEMO("u\u0001w\u0007q\fi\u0003y\u000b"), 6, 8);
        BLESS_LUCK_CHARM = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("WRPMFAYKVUJ]]_GS"), 7, 255);
        QUEST_COMPLETE = new SpecialEffect(Quadra.ALLATORIxDEMO("g\u001cs\u001ab\u0016u\u0006{\u0019z\fb\f"), 8, 9);
        HP_EFFECT = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("VEAPXS[VJ"), 9, 10);
        BUFF_ITEM_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("t\u001cp\u000fi\u0000b\f{\u0016s\u000fp\fu\u001d"), 10, 11);
        PICKUP_MONSTER_CARD = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("N\\]^KEAXQ[MA[GAV_GZ"), 11, 13);
        LOTTERY_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("z\u0006b\u001ds\u001bo\u0016s\u000fp\fu\u001d"), 12, 14);
        ITEM_LEVEL_UP = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("WA[XAY[C[YA@N"), 13, 15);
        ITEM_MAKER_SUCCESS = new SpecialEffect(Quadra.ALLATORIxDEMO("\u007f\u001ds\u0004i\u0004w\u0002s\u001bi\u001ac\nu\fe\u001a"), 14, 16);
        EXP_EFFECT = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("PFEAPXS[VJ"), 15, 17);
        WZ_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("\u001el\u0016s\u000fp\fu\u001d"), 16, 18);
        WHEEL = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("I][PR"), 17, 19);
        WZ_EFFECT2 = new SpecialEffect(Quadra.ALLATORIxDEMO("a\u0013i\fp\u000fs\nb{"), 18, 21);
        POISON_EFFECT = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("NZWFQ[APXS[VJ"), 19, 25);
        CRAFT_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("u\u001bw\u000fb\u0016s\u000fp\fu\u001d"), 20, 32);
        PVP_CHAMPION = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("EHEAVVTSEWZP"), 21, 32);
        BUFF_ITEM_SUB_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("t\u001cp\u000fi\u0000b\f{\u0016e\u001ct\u0016s\u000fp\fu\u001d"), 22, 23);
        SOUL_STONE = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("FQ@RJMAQ[["), 23, 24);
        HEAL_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("\u0001s\bz\u0016s\u000fp\fu\u001d"), 24, 25);
        AVOID_EFFECT = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("THZWQAPXS[VJ"), 25, 26);
        HONOR_LEVELUP = new SpecialEffect(Quadra.ALLATORIxDEMO("\u0001y\u0007y\u001bi\u0005s\u001fs\u0005c\u0019"), 26, 0);
        SOUND = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("MZK[Z"), 27, 0);
        RECHARGE_STATE = new SpecialEffect(Quadra.ALLATORIxDEMO("d\fu\u0001w\u001bq\fi\u001ab\bb\f"), 28, 0);
        CHANGE_ELF = new SpecialEffect(AbstractBuffClass.ALLATORIxDEMO("VVTPR[J[YX"), 29, 0);
        BLACK_EFFECT = new SpecialEffect(Quadra.ALLATORIxDEMO("t\u0005w\n}\u0016s\u000fp\fu\u001d"), 30, 0);
        SpecialEffect[] arrspecialEffect = new SpecialEffect[31];
        arrspecialEffect[0] = LEVEL_UP;
        arrspecialEffect[1] = ITEM_GAIN;
        arrspecialEffect[2] = PET_LEVELUP;
        arrspecialEffect[3] = SPECIAL_SKILL;
        arrspecialEffect[4] = USE_AMULET;
        arrspecialEffect[5] = MULUNG_DOJO_UP;
        arrspecialEffect[6] = CHANGE_JOB;
        arrspecialEffect[7] = BLESS_LUCK_CHARM;
        arrspecialEffect[8] = QUEST_COMPLETE;
        arrspecialEffect[9] = HP_EFFECT;
        arrspecialEffect[10] = BUFF_ITEM_EFFECT;
        arrspecialEffect[11] = PICKUP_MONSTER_CARD;
        arrspecialEffect[12] = LOTTERY_EFFECT;
        arrspecialEffect[13] = ITEM_LEVEL_UP;
        arrspecialEffect[14] = ITEM_MAKER_SUCCESS;
        arrspecialEffect[15] = EXP_EFFECT;
        arrspecialEffect[16] = WZ_EFFECT;
        arrspecialEffect[17] = WHEEL;
        arrspecialEffect[18] = WZ_EFFECT2;
        arrspecialEffect[19] = POISON_EFFECT;
        arrspecialEffect[20] = CRAFT_EFFECT;
        arrspecialEffect[21] = PVP_CHAMPION;
        arrspecialEffect[22] = BUFF_ITEM_SUB_EFFECT;
        arrspecialEffect[23] = SOUL_STONE;
        arrspecialEffect[24] = HEAL_EFFECT;
        arrspecialEffect[25] = AVOID_EFFECT;
        arrspecialEffect[26] = HONOR_LEVELUP;
        arrspecialEffect[27] = SOUND;
        arrspecialEffect[28] = RECHARGE_STATE;
        arrspecialEffect[29] = CHANGE_ELF;
        arrspecialEffect[30] = BLACK_EFFECT;
        ALLATORIxDEMO = arrspecialEffect;
        SpecialEffect.reloadValues();
    }

    public static /* synthetic */ SpecialEffect[] values() {
        return (SpecialEffect[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    public static /* synthetic */ SpecialEffect valueOf(String a2) {
        return Enum.valueOf(SpecialEffect.class, a2);
    }
}

