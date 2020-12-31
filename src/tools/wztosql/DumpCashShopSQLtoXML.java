/*
 * Decompiled with CFR 0.150.
 */
package tools.wztosql;

import handling.channel.handler.UserInterfaceHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.CashModItem;
import tools.FileoutputUtil;
import tools.npcgenerator.Instruction;

/*
 * Exception performing whole class analysis ignored.
 */
public class DumpCashShopSQLtoXML {
    public static /* synthetic */ boolean alwaysShowUp;
    public static /* synthetic */ boolean TransXml;
    public static /* synthetic */ List<Integer> SNs;
    public static /* synthetic */ List<CashModItem> allCashShopInformations;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void loadAllCashShopData() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [15[WHILELOOP]], but top level block is 3[TRYBLOCK]
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

    public static /* synthetic */ StringBuilder makeOutputMessage() {
        Iterator<CashModItem> iterator;
        StringBuilder stringBuilder;
        int n2 = 0;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
        DumpCashShopSQLtoXML.writeLine(stringBuilder2, Instruction.ALLATORIxDEMO("]%\u0019w\r:\u0017\u007f\u0013i\bu\u000f'C+O*C:\u0004t\u0002u\u0005s\u000f}\\84N'7Y8Ai\u0015{\u000f~\u0000v\u000et\u0004'Cc\u0004iC%_"), 0);
        DumpCashShopSQLtoXML.writeLine(stringBuilder2, UserInterfaceHandler.ALLATORIxDEMO("\bRY\\PRF\u001bZZY^\t\u0019wTYV[_]OM\u0015]VS\u0019\n"), 0);
        Iterator<CashModItem> iterator2 = iterator = allCashShopInformations.iterator();
        while (iterator2.hasNext()) {
            StringBuilder stringBuilder3;
            CashModItem cashModItem = iterator.next();
            if (cashModItem.getSN() == 50400002) {
                System.out.println(Instruction.ALLATORIxDEMO("\u001f"));
            }
            DumpCashShopSQLtoXML.writeLine(stringBuilder, "<imgdir name=\"" + n2 + "\">", 1);
            DumpCashShopSQLtoXML.writeLine(stringBuilder, "<int name=\"SN\" value=\"" + cashModItem.getSN() + "\"/>", 2);
            DumpCashShopSQLtoXML.writeLine(stringBuilder, "<int name=\"ItemId\" value=\"" + cashModItem.getId() + "\"/>", 2);
            DumpCashShopSQLtoXML.writeLine(stringBuilder, "<int name=\"Count\" value=\"" + (cashModItem.getCount() <= 0 ? 1 : cashModItem.getCount()) + "\"/>", 2);
            DumpCashShopSQLtoXML.writeLine(stringBuilder, "<int name=\"Price\" value=\"" + cashModItem.getPrice() + "\"/>", 2);
            DumpCashShopSQLtoXML.writeLine(stringBuilder, "<int name=\"Period\" value=\"" + cashModItem.getPeriod() + "\"/>", 2);
            StringBuilder stringBuilder4 = stringBuilder;
            DumpCashShopSQLtoXML.writeLine(stringBuilder4, UserInterfaceHandler.ALLATORIxDEMO("\u0007]U@\u001bZZY^\t\u0019dI]TFR@B\u0016\u001bBZXNQ\u0006\u0016\n\u0016\u0014\n"), 2);
            DumpCashShopSQLtoXML.writeLine(stringBuilder4, "<int name=\"Gender\" value=\"" + cashModItem.getGender() + "\"/>", 2);
            if (alwaysShowUp) {
                StringBuilder stringBuilder5 = stringBuilder;
                stringBuilder3 = stringBuilder5;
                DumpCashShopSQLtoXML.writeLine(stringBuilder5, Instruction.ALLATORIxDEMO("&\bt\u0015:\u000f{\f\u007f\\8.t2{\r\u007fC:\u0017{\ro\u0004'C+C5_"), 2);
            } else {
                DumpCashShopSQLtoXML.writeLine(stringBuilder, "<int name=\"OnSale\" value=\"" + (cashModItem.isOnSale() ? 1 : 0) + "\"/>", 2);
                stringBuilder3 = stringBuilder;
            }
            DumpCashShopSQLtoXML.writeLine(stringBuilder3, UserInterfaceHandler.ALLATORIxDEMO("\bRZO\u0014UUVQ\u0006\u0016kVxUH\\\u0019\u0014MUWA^\t\u0019\u0007\u000b\u0016\u0014\n"), 2);
            iterator2 = iterator;
            StringBuilder stringBuilder6 = stringBuilder;
            DumpCashShopSQLtoXML.writeLine(stringBuilder, Instruction.ALLATORIxDEMO("&\bt\u0015:\u000f{\f\u007f\\81x1u\bt\u00158Al\u0000v\u0014\u007f\\8R*C5_"), 2);
            DumpCashShopSQLtoXML.writeLine(stringBuilder6, UserInterfaceHandler.ALLATORIxDEMO("\bRZO\u0014UUVQ\u0006\u0016kV|]]@\u0019\u0014MUWA^\t\u0019\u0007\u000b\u0016\u0014\n"), 2);
            ++n2;
            DumpCashShopSQLtoXML.writeLine(stringBuilder6, Instruction.ALLATORIxDEMO("]5\bw\u0006~\bh_"), 1);
        }
        StringBuilder stringBuilder7 = stringBuilder;
        DumpCashShopSQLtoXML.writeLine(stringBuilder7, UserInterfaceHandler.ALLATORIxDEMO("\b\u0014]VS_]I\n"), 0);
        return stringBuilder7;
    }

    public static /* synthetic */ {
        allCashShopInformations = new LinkedList<CashModItem>();
        SNs = new LinkedList<Integer>();
        TransXml = false;
        alwaysShowUp = false;
    }

    public /* synthetic */ DumpCashShopSQLtoXML() {
        DumpCashShopSQLtoXML a2;
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(UserInterfaceHandler.ALLATORIxDEMO(">\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u00171\u0017\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u0018>\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0017\u0018\u0014\u0018\u0014\u001b\u0014\u0018\u0014\u001b\u0014\u001b\u0017\u0018\u0014\u0018\u0017\u0018\u0014\u0018\u0017\u0018\u0014\u0018\u0017\u001b\u0014\u0018\u0017\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u00171\u0017\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0017\u001b\u0017\u001b\u0017\u001b\u0014\u001b\u0017\u001b\u0014\u001b\u0017\u001b\u0017\u001b\u0014\u0018\u0014\u001b\u0017\u001b\u0017\u001b\u0017\u001b\u0017\u001b\u0014\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u0018>\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u0018\u0017\u0018\u0014\u0018\u0014\u001b\u0014\u0018\u0014\u001b\u0014\u0018\u0017\u0018\u0014\u001b\u0017\u001b\u0014\u0018\u0014\u0018\u0014\u0018\u0017\u001b\u0014\u001b\u0017\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u00171\u0017\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0017\u001b\u0017\u001b\u0017\u0018\u0017\u001b\u0017\u0018\u0017\u001b\u0017\u001b\u0017\u001b\u0014\u0018\u0014\u001b\u0017\u0018\u0017\u001b\u0017\u001b\u0017\u001b\u0017\u0018\u0017\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u0018>\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u00171\u0017\u001b{YRNGXUO]TZ\u001bVB\u0014zXWUO[I]\u001b{YRNGXUO[I\u0014M\u0003\u0015\u0007\u001bp~yt\u0014\u0018>\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u00171\u0017\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\\O@K\u000e\u0014\u001bLCL\u001aZXWUO[I]\u0015WTY\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u0018>\u0018\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u0014\u001b\u00171\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018\u0017\u0018>"));
        FileoutputUtil.deleteFile(Instruction.ALLATORIxDEMO("\"u\fw\u000e~\bn\u00184\bw\u00064\u0019w\r"));
        allCashShopInformations.clear();
        SNs.clear();
        DumpCashShopSQLtoXML.loadAllCashShopData();
        StringBuilder stringBuilder = DumpCashShopSQLtoXML.makeOutputMessage();
        FileoutputUtil.logToFile(UserInterfaceHandler.ALLATORIxDEMO("wTYV[_]OM\u0015]VS\u0015LVX"), stringBuilder.toString(), true, false);
        System.out.println("\u4e00\u5171\u5beb\u5165\u4e86" + SNs.size() + "\u500b\u5546\u57ce\u7269\u54c1\u81f3XML");
        SNs.clear();
    }

    private static /* synthetic */ int ALLATORIxDEMO(CashModItem a2, CashModItem a3) {
        return a2.getSN() - a3.getSN();
    }

    public static /* synthetic */ void writeLine(StringBuilder a2, String a3, int a4) {
        int n2 = a4;
        while (n2 > 0) {
            a2.append(Instruction.ALLATORIxDEMO(":A:A"));
            n2 = --a4;
        }
        a2.append(a3).append(UserInterfaceHandler.ALLATORIxDEMO("6>"));
    }
}

