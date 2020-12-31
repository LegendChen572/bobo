/*
 * Decompiled with CFR 0.150.
 */
package handling.opcodes;

import handling.WritableIntValueHolder;
import tools.Quadra;
import tools.packet.BeansPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public final class GameDirectionType
extends Enum<GameDirectionType>
implements WritableIntValueHolder {
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_ForcedMove;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_InputUI;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_EffectPlay;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_ForcedInput;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_VansheeMode;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_ForcedAction;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_CameraZoom;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_CameraOnCharacter;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_FaceOff;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_AvatarLookSet;
    private static final /* synthetic */ GameDirectionType[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_ForcedFlip;
    private /* synthetic */ short d;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_PatternInputRequest;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_MonologueScroll;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_Monologue;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_CameraReleaseFromUserPoint;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_Delay;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_CameraMove;
    public static final /* synthetic */ /* enum */ GameDirectionType InGameDirectionEvent_RemoveAdditionalEffect;

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void reloadValues() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK], 3[TRYBLOCK]], but top level block is 10[CATCHBLOCK]
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

    @Override
    public /* synthetic */ short getValue() {
        GameDirectionType a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void setValue(short a2) {
        a.d = a2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ GameDirectionType(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        GameDirectionType a3;
        GameDirectionType gameDirectionType = a3;
        a3.d = 0;
        gameDirectionType.d = 0;
        gameDirectionType.d = (short)a2;
    }

    public static /* synthetic */ GameDirectionType getType(int a2) {
        int n2;
        GameDirectionType[] arrgameDirectionType = GameDirectionType.values();
        int n3 = arrgameDirectionType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            GameDirectionType gameDirectionType = arrgameDirectionType[n2];
            if (gameDirectionType.getValue() == a2) {
                return gameDirectionType;
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ GameDirectionType valueOf(String a2) {
        return Enum.valueOf(GameDirectionType.class, a2);
    }

    public static /* synthetic */ GameDirectionType[] values() {
        return (GameDirectionType[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        InGameDirectionEvent_ForcedAction = new GameDirectionType(BeansPacket.ALLATORIxDEMO("l,b#H'a+W'F6L-K\u0007S'K6z\u0004J0F'A\u0003F6L-K"), 0, 0);
        InGameDirectionEvent_Delay = new GameDirectionType(Quadra.ALLATORIxDEMO("\u007f'q([,r D,U=_&X\f@,X=i\rS%W0"), 1, 1);
        InGameDirectionEvent_EffectPlay = new GameDirectionType(BeansPacket.ALLATORIxDEMO("l,b#H'a+W'F6L-K\u0007S'K6z\u0007C$@!Q\u0012I#\\"), 2, 2);
        InGameDirectionEvent_ForcedInput = new GameDirectionType(Quadra.ALLATORIxDEMO("\u007f'q([,r D,U=_&X\f@,X=i\u000fY;U,R\u0000X9C="), 3, 3);
        InGameDirectionEvent_PatternInputRequest = new GameDirectionType(BeansPacket.ALLATORIxDEMO("\u000bK\u0005D/@\u0006L0@!Q+J,`4@,Q\u001du#Q6@0K\u000bK2P6w'T7@1Q"), 4, 4);
        InGameDirectionEvent_CameraMove = new GameDirectionType(Quadra.ALLATORIxDEMO("\u0000X\u000eW$S\r_;S*B Y's?S'B\u0016u([,D({&@,"), 5, 5);
        InGameDirectionEvent_CameraOnCharacter = new GameDirectionType(BeansPacket.ALLATORIxDEMO("\u000bK\u0005D/@\u0006L0@!Q+J,`4@,Q\u001df#H'W#j,f*D0D!Q'W"), 6, 6);
        InGameDirectionEvent_CameraZoom = new GameDirectionType(Quadra.ALLATORIxDEMO("\u0000X\u000eW$S\r_;S*B Y's?S'B\u0016u([,D(l&Y$"), 7, 7);
        InGameDirectionEvent_CameraReleaseFromUserPoint = new GameDirectionType(BeansPacket.ALLATORIxDEMO("l,b#H'a+W'F6L-K\u0007S'K6z\u0001D/@0D\u0010@.@#V'c0J/p1@0u-L,Q"), 8, 8);
        InGameDirectionEvent_VansheeMode = new GameDirectionType(Quadra.ALLATORIxDEMO("\u007f'q([,r D,U=_&X\f@,X=i\u001fW'E!S,{&R,"), 9, 9);
        InGameDirectionEvent_FaceOff = new GameDirectionType(BeansPacket.ALLATORIxDEMO("\u000bK\u0005D/@\u0006L0@!Q+J,`4@,Q\u001dc#F'j$C"), 10, 10);
        InGameDirectionEvent_Monologue = new GameDirectionType(Quadra.ALLATORIxDEMO("\u007f'q([,r D,U=_&X\f@,X=i\u0004Y'Y%Y.C,"), 11, 11);
        InGameDirectionEvent_MonologueScroll = new GameDirectionType(BeansPacket.ALLATORIxDEMO("\u000bK\u0005D/@\u0006L0@!Q+J,`4@,Q\u001dh-K-I-B7@\u0011F0J.I"), 12, 12);
        InGameDirectionEvent_AvatarLookSet = new GameDirectionType(Quadra.ALLATORIxDEMO("\u007f'q([,r D,U=_&X\f@,X=i\b@(B(D\u0005Y&]\u001aS="), 13, 13);
        InGameDirectionEvent_RemoveAdditionalEffect = new GameDirectionType(BeansPacket.ALLATORIxDEMO("l,b#H'a+W'F6L-K\u0007S'K6z\u0010@/J4@\u0003A&L6L-K#I\u0007C$@!Q"), 14, 14);
        InGameDirectionEvent_ForcedMove = new GameDirectionType(Quadra.ALLATORIxDEMO("\u0000X\u000eW$S\r_;S*B Y's?S'B\u0016p&D*S-{&@,"), 15, 15);
        InGameDirectionEvent_ForcedFlip = new GameDirectionType(BeansPacket.ALLATORIxDEMO("l,b#H'a+W'F6L-K\u0007S'K6z\u0004J0F'A\u0004I+U"), 16, 16);
        InGameDirectionEvent_InputUI = new GameDirectionType(Quadra.ALLATORIxDEMO("\u007f'q([,r D,U=_&X\f@,X=i\u0000X9C=c\u0000"), 17, 17);
        GameDirectionType[] arrgameDirectionType = new GameDirectionType[18];
        arrgameDirectionType[0] = InGameDirectionEvent_ForcedAction;
        arrgameDirectionType[1] = InGameDirectionEvent_Delay;
        arrgameDirectionType[2] = InGameDirectionEvent_EffectPlay;
        arrgameDirectionType[3] = InGameDirectionEvent_ForcedInput;
        arrgameDirectionType[4] = InGameDirectionEvent_PatternInputRequest;
        arrgameDirectionType[5] = InGameDirectionEvent_CameraMove;
        arrgameDirectionType[6] = InGameDirectionEvent_CameraOnCharacter;
        arrgameDirectionType[7] = InGameDirectionEvent_CameraZoom;
        arrgameDirectionType[8] = InGameDirectionEvent_CameraReleaseFromUserPoint;
        arrgameDirectionType[9] = InGameDirectionEvent_VansheeMode;
        arrgameDirectionType[10] = InGameDirectionEvent_FaceOff;
        arrgameDirectionType[11] = InGameDirectionEvent_Monologue;
        arrgameDirectionType[12] = InGameDirectionEvent_MonologueScroll;
        arrgameDirectionType[13] = InGameDirectionEvent_AvatarLookSet;
        arrgameDirectionType[14] = InGameDirectionEvent_RemoveAdditionalEffect;
        arrgameDirectionType[15] = InGameDirectionEvent_ForcedMove;
        arrgameDirectionType[16] = InGameDirectionEvent_ForcedFlip;
        arrgameDirectionType[17] = InGameDirectionEvent_InputUI;
        ALLATORIxDEMO = arrgameDirectionType;
        GameDirectionType.reloadValues();
    }
}

