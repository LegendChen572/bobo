/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleKeyLayout;
import handling.auction.handler.MTSOperation;
import server.maps.Event_PyramidSubway;
import tools.WritableLongValueHolder;
import tools.data.LittleEndianAccessor;

/*
 * Exception performing whole class analysis ignored.
 */
public final class MapleStat
extends Enum<MapleStat>
implements WritableLongValueHolder {
    public static final /* synthetic */ /* enum */ MapleStat BATTLE_RANK;
    public static final /* synthetic */ /* enum */ MapleStat GENDER;
    public static final /* synthetic */ /* enum */ MapleStat FACE;
    public static final /* synthetic */ /* enum */ MapleStat WILL;
    public static final /* synthetic */ /* enum */ MapleStat FATIGUE;
    private /* synthetic */ long d;
    private static final /* synthetic */ MapleStat[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleStat PET;
    public static final /* synthetic */ /* enum */ MapleStat GACHAPONEXP;
    public static final /* synthetic */ /* enum */ MapleStat CHARISMA;
    public static final /* synthetic */ /* enum */ MapleStat CHARM;
    public static final /* synthetic */ /* enum */ MapleStat DEX;
    public static final /* synthetic */ /* enum */ MapleStat INSIGHT;
    public static final /* synthetic */ /* enum */ MapleStat VIRTUE;
    public static final /* synthetic */ /* enum */ MapleStat SENSE;
    public static final /* synthetic */ /* enum */ MapleStat INT;
    public static final /* synthetic */ /* enum */ MapleStat ICE_GAGE;
    public static final /* synthetic */ /* enum */ MapleStat JOB;
    public static final /* synthetic */ /* enum */ MapleStat HAIR;
    public static final /* synthetic */ /* enum */ MapleStat MAXMP;
    public static final /* synthetic */ /* enum */ MapleStat EXP;
    public static final /* synthetic */ /* enum */ MapleStat LEVEL;
    public static final /* synthetic */ /* enum */ MapleStat MAXHP;
    public static final /* synthetic */ /* enum */ MapleStat STR;
    public static final /* synthetic */ /* enum */ MapleStat HP;
    public static final /* synthetic */ /* enum */ MapleStat AVAILABLESP;
    public static final /* synthetic */ /* enum */ MapleStat SKIN;
    public static final /* synthetic */ /* enum */ MapleStat MESO;
    public static final /* synthetic */ /* enum */ MapleStat MP;
    public static final /* synthetic */ /* enum */ MapleStat TRAIT_LIMIT;
    public static final /* synthetic */ /* enum */ MapleStat LUK;
    public static final /* synthetic */ /* enum */ MapleStat FAME;
    public static final /* synthetic */ /* enum */ MapleStat AVAILABLEAP;
    public static final /* synthetic */ /* enum */ MapleStat BATTLE_POINTS;
    public static final /* synthetic */ /* enum */ MapleStat BATTLE_EXP;
    public static final /* synthetic */ /* enum */ MapleStat CRAFT;

    @Override
    public /* synthetic */ long getValue() {
        MapleStat a2;
        return a2.d;
    }

    public static /* synthetic */ MapleStat valueOf(String a2) {
        return Enum.valueOf(MapleStat.class, a2);
    }

    public static /* synthetic */ MapleStat[] values() {
        return (MapleStat[])ALLATORIxDEMO.clone();
    }

    @Override
    public /* synthetic */ void setValue(long a2) {
        a.d = a2;
    }

    public static final /* synthetic */ MapleStat getByValue(long a2) {
        int n2;
        MapleStat[] arrmapleStat = MapleStat.values();
        int n3 = arrmapleStat.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleStat mapleStat = arrmapleStat[n2];
            if (mapleStat.d == a2) {
                return mapleStat;
            }
            n4 = ++n2;
        }
        return null;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleStat(long l2) {
        void a2;
        void var2_-1;
        void var1_-1;
        MapleStat a3;
        a3.d = a2;
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

    public static /* synthetic */ {
        SKIN = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("y6c3"), 0, 1L);
        FACE = new MapleStat(MTSOperation.ALLATORIxDEMO("\nb\u000ff"), 1, 2L);
        HAIR = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("b<c/"), 2, 4L);
        PET = new MapleStat(MTSOperation.ALLATORIxDEMO("s\tw"), 3, 8L);
        LEVEL = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("1o+o1"), 4, 16L);
        JOB = new MapleStat(MTSOperation.ALLATORIxDEMO("i\u0003a"), 5, 32L);
        STR = new MapleStat(MapleKeyLayout.ALLATORIxDEMO(".~/"), 6, 64L);
        DEX = new MapleStat(MTSOperation.ALLATORIxDEMO("g\t{"), 7, 128L);
        INT = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("4d)"), 8, 256L);
        LUK = new MapleStat(MTSOperation.ALLATORIxDEMO("o\u0019h"), 9, 512L);
        HP = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("b-"), 10, 1024L);
        MAXHP = new MapleStat(MTSOperation.ALLATORIxDEMO("n\r{\u0004s"), 11, 2048L);
        MP = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("g-"), 12, 4096L);
        MAXMP = new MapleStat(MTSOperation.ALLATORIxDEMO("n\r{\u0001s"), 13, 8192L);
        AVAILABLEAP = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("<|<c1k?f8k-"), 14, 16384L);
        AVAILABLESP = new MapleStat(MTSOperation.ALLATORIxDEMO("b\u001ab\u0005o\ra\u0000f\u001fs"), 15, 32768L);
        EXP = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("8r-"), 16, 65536L);
        FAME = new MapleStat(MTSOperation.ALLATORIxDEMO("\nb\u0001f"), 17, 131072L);
        MESO = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("g8y2"), 18, 262144L);
        GACHAPONEXP = new MapleStat(MTSOperation.ALLATORIxDEMO("d\r`\u0004b\u001cl\u0002f\u0014s"), 19, 0x200000L);
        FATIGUE = new MapleStat(MapleKeyLayout.ALLATORIxDEMO(";k)c:\u007f8"), 20, 524288L);
        CHARISMA = new MapleStat(MTSOperation.ALLATORIxDEMO("\u000fk\rq\u0005p\u0001b"), 21, 0x100000L);
        INSIGHT = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("4d.c:b)"), 22, 0x200000L);
        WILL = new MapleStat(MTSOperation.ALLATORIxDEMO("\u001bj\u0000o"), 23, 0x400000L);
        CRAFT = new MapleStat(MapleKeyLayout.ALLATORIxDEMO(">x<l)"), 24, 0x800000L);
        SENSE = new MapleStat(MTSOperation.ALLATORIxDEMO("p\tm\u001ff"), 25, 0x1000000L);
        CHARM = new MapleStat(MapleKeyLayout.ALLATORIxDEMO(">b<x0"), 26, 0x2000000L);
        TRAIT_LIMIT = new MapleStat(MTSOperation.ALLATORIxDEMO("w\u001eb\u0005w\u0013o\u0005n\u0005w"), 27, 0x4000000L);
        BATTLE_EXP = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("h<~)f8u8r-"), 28, 0x8000000L);
        BATTLE_RANK = new MapleStat(MTSOperation.ALLATORIxDEMO("a\rw\u0018o\t|\u001eb\u0002h"), 29, 0x10000000L);
        BATTLE_POINTS = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("?k)~1o\"z2c3~."), 30, 0x20000000L);
        ICE_GAGE = new MapleStat(MTSOperation.ALLATORIxDEMO("\u0005`\t|\u000bb\u000bf"), 31, 0x40000000L);
        VIRTUE = new MapleStat(MapleKeyLayout.ALLATORIxDEMO("|4x)\u007f8"), 32, Integer.MIN_VALUE);
        GENDER = new MapleStat(MTSOperation.ALLATORIxDEMO("\u000bf\u0002g\tq"), 33, 0x200000000L);
        MapleStat[] arrmapleStat = new MapleStat[34];
        arrmapleStat[0] = SKIN;
        arrmapleStat[1] = FACE;
        arrmapleStat[2] = HAIR;
        arrmapleStat[3] = PET;
        arrmapleStat[4] = LEVEL;
        arrmapleStat[5] = JOB;
        arrmapleStat[6] = STR;
        arrmapleStat[7] = DEX;
        arrmapleStat[8] = INT;
        arrmapleStat[9] = LUK;
        arrmapleStat[10] = HP;
        arrmapleStat[11] = MAXHP;
        arrmapleStat[12] = MP;
        arrmapleStat[13] = MAXMP;
        arrmapleStat[14] = AVAILABLEAP;
        arrmapleStat[15] = AVAILABLESP;
        arrmapleStat[16] = EXP;
        arrmapleStat[17] = FAME;
        arrmapleStat[18] = MESO;
        arrmapleStat[19] = GACHAPONEXP;
        arrmapleStat[20] = FATIGUE;
        arrmapleStat[21] = CHARISMA;
        arrmapleStat[22] = INSIGHT;
        arrmapleStat[23] = WILL;
        arrmapleStat[24] = CRAFT;
        arrmapleStat[25] = SENSE;
        arrmapleStat[26] = CHARM;
        arrmapleStat[27] = TRAIT_LIMIT;
        arrmapleStat[28] = BATTLE_EXP;
        arrmapleStat[29] = BATTLE_RANK;
        arrmapleStat[30] = BATTLE_POINTS;
        arrmapleStat[31] = ICE_GAGE;
        arrmapleStat[32] = VIRTUE;
        arrmapleStat[33] = GENDER;
        ALLATORIxDEMO = arrmapleStat;
        MapleStat.reloadValues();
    }

    public static final class Temp
    extends Enum<Temp> {
        public static final /* synthetic */ /* enum */ Temp WDEF;
        public static final /* synthetic */ /* enum */ Temp LUK;
        public static final /* synthetic */ /* enum */ Temp SPEED;
        public static final /* synthetic */ /* enum */ Temp MATK;
        private static final /* synthetic */ Temp[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ Temp ACC;
        public static final /* synthetic */ /* enum */ Temp WATK;
        public static final /* synthetic */ /* enum */ Temp INT;
        public static final /* synthetic */ /* enum */ Temp DEX;
        public static final /* synthetic */ /* enum */ Temp MDEF;
        public static final /* synthetic */ /* enum */ Temp STR;
        private final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ Temp AVOID;
        public static final /* synthetic */ /* enum */ Temp JUMP;

        public static /* synthetic */ Temp[] values() {
            return (Temp[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ Temp valueOf(String a2) {
            return Enum.valueOf(Temp.class, a2);
        }

        public /* synthetic */ int getValue() {
            Temp a2;
            return a2.d;
        }

        public static /* synthetic */ {
            STR = new Temp(Event_PyramidSubway.ALLATORIxDEMO("w\u000ev"), 0, 1);
            DEX = new Temp(LittleEndianAccessor.ALLATORIxDEMO("iQu"), 1, 2);
            INT = new Temp(Event_PyramidSubway.ALLATORIxDEMO("m\u0014p"), 2, 4);
            LUK = new Temp(LittleEndianAccessor.ALLATORIxDEMO("aAf"), 3, 8);
            WATK = new Temp(Event_PyramidSubway.ALLATORIxDEMO("\re\u000eo"), 4, 16);
            WDEF = new Temp(LittleEndianAccessor.ALLATORIxDEMO("CiQk"), 5, 32);
            MATK = new Temp(Event_PyramidSubway.ALLATORIxDEMO("\u0017e\u000eo"), 6, 64);
            MDEF = new Temp(LittleEndianAccessor.ALLATORIxDEMO("YiQk"), 7, 128);
            ACC = new Temp(Event_PyramidSubway.ALLATORIxDEMO("e\u0019g"), 8, 256);
            AVOID = new Temp(LittleEndianAccessor.ALLATORIxDEMO("lBb]i"), 9, 512);
            SPEED = new Temp(Event_PyramidSubway.ALLATORIxDEMO("w\na\u001f`"), 10, 1024);
            JUMP = new Temp(LittleEndianAccessor.ALLATORIxDEMO("^xY}"), 11, 2048);
            Temp[] arrtemp = new Temp[12];
            arrtemp[0] = STR;
            arrtemp[1] = DEX;
            arrtemp[2] = INT;
            arrtemp[3] = LUK;
            arrtemp[4] = WATK;
            arrtemp[5] = WDEF;
            arrtemp[6] = MATK;
            arrtemp[7] = MDEF;
            arrtemp[8] = ACC;
            arrtemp[9] = AVOID;
            arrtemp[10] = SPEED;
            arrtemp[11] = JUMP;
            ALLATORIxDEMO = arrtemp;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ Temp(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            Temp a3;
            a3.d = a2;
        }
    }
}

