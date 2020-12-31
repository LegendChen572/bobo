/*
 * Decompiled with CFR 0.150.
 */
package server.game;

import FuckingHackerToby.ka;
import client.MapleCharacter;
import constants.ServerSet;
import handling.channel.handler.BBSHandler;
import handling.world.World;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import server.Randomizer;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

public class Lottory {
    public static /* synthetic */ int LottoryDate;
    public static /* synthetic */ int AllNumber;

    public /* synthetic */ Lottory() {
        Lottory a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String gainPrice(MapleCharacter a2) {
        int n2;
        int n3;
        int n4;
        block16: {
            if (a2.getLottoryDate() != (long)LottoryDate || LottoryDate == -1) {
                return ka.H("\u60ce\u73eb\u574e\u7134\u6cb3\u980d\u7328\u54f3G");
            }
            if (LottoryDate != FileoutputUtil.YesturdayTimeNumber()) {
                return BBSHandler.ALLATORIxDEMO("\u608b\u73dd\u570b\u7102\u6cf6\u983b\u736d\u54c5\u0002");
            }
            if (!a2.getLottoryStatus()) {
                return ka.H("\u60ce\u73eb\u574e\u7134\u6cb3\u980d\u7328\u54f3G");
            }
            MapleCharacter mapleCharacter = a2;
            n4 = mapleCharacter.getLottoryNumber1();
            int n5 = mapleCharacter.getLottoryNumber2();
            int n6 = mapleCharacter.getLottoryNumber3();
            int n7 = mapleCharacter.getLottoryNumber4();
            int n8 = mapleCharacter.getLottoryNumber5();
            n3 = 0;
            List<Integer> list = Lottory.getLottoryNumber();
            if (list.contains(n4)) {
                ++n3;
            }
            if (list.contains(n5)) {
                ++n3;
            }
            if (list.contains(n6)) {
                ++n3;
            }
            if (list.contains(n7)) {
                ++n3;
            }
            if (list.contains(n8)) {
                ++n3;
            }
            n4 = 0;
            switch (n3) {
                case 0: 
                case 1: {
                    break;
                }
                case 2: {
                    n2 = n4 = 10000000;
                    break block16;
                }
                case 3: {
                    n2 = n4 = 50000000;
                    break block16;
                }
                case 4: {
                    n2 = n4 = 100000000;
                    break block16;
                }
                case 5: {
                    n4 = 300000000;
                }
            }
            n2 = n4;
        }
        if (n2 > 0) {
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u606d\u559c\u8d85\u5e78\u904b\u73a9\u5bb6: " + a2.getName() + " \u6a02\u900f\u4e2d\u734e" + n3 + "\u78bc! \u7372\u5f97\u5f69\u91d1:" + n4));
            a2.gainMeso(n4, true);
        }
        a2.setLottoryStatus(false);
        return "\u606d\u559c\u60a8\u4e2d\u4e86 " + n3 + " \u500b\u6578\u5b57! \u7372\u5f97\u5f69\u91d1 " + n4 + " \u5143~";
    }

    public static /* synthetic */ {
        AllNumber = 39;
        LottoryDate = -1;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ String getRules() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
         * java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
         * java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
         * java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
         * java.base/java.util.Objects.checkIndex(Objects.java:372)
         * java.base/java.util.ArrayList.get(ArrayList.java:459)
         * org.benf.cfr.reader.bytecode.analysis.parse.rewriters.StringBuilderRewriter.genStringConcat(StringBuilderRewriter.java:202)
         * org.benf.cfr.reader.bytecode.analysis.parse.rewriters.StringBuilderRewriter.testAppendChain(StringBuilderRewriter.java:179)
         * org.benf.cfr.reader.bytecode.analysis.parse.rewriters.StringBuilderRewriter.rewriteExpression(StringBuilderRewriter.java:42)
         * org.benf.cfr.reader.bytecode.analysis.parse.statement.ReturnValueStatement.rewriteExpressions(ReturnValueStatement.java:55)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.rewrite(Op03SimpleStatement.java:471)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Op03Rewriters.rewriteWith(Op03Rewriters.java:22)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:742)
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

    public static /* synthetic */ List<Integer> DrawLottory() {
        Iterator iterator;
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = 5;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = 0;
            while (arrayList.contains(n5 = Randomizer.rand(1, AllNumber))) {
            }
            arrayList.add(n5);
            n4 = ++n2;
        }
        n2 = 1;
        Iterator iterator2 = iterator = arrayList.iterator();
        while (iterator2.hasNext()) {
            Integer n6 = (Integer)iterator.next();
            String string = "\u6a02\u900f" + n2;
            ++n2;
            ServerSet.setServerSet(string, n6.intValue());
            iterator2 = iterator;
        }
        LottoryDate = FileoutputUtil.YesturdayTimeNumber();
        return arrayList;
    }

    public static /* synthetic */ List<Integer> getLottoryNumber() {
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = n2 = 1;
        while (n3 <= 5) {
            long l2 = ServerSet.getServerSet("\u6a02\u900f" + n2);
            arrayList.add((int)l2);
            n3 = ++n2;
        }
        return arrayList;
    }
}

