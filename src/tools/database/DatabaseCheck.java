/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 */
package tools.database;

import client.messages.commands.player.\u53ef\u53ef\u8c37;
import constants.GameSetConstants;
import constants.ServerSet;
import database.DBConPool;
import handling.channel.handler.AllianceHandler;
import tools.database.CharacterSetConverter;
import tools.database.DatabaseConvert;

/*
 * Exception performing whole class analysis ignored.
 */
public class DatabaseCheck {
    public /* synthetic */ DatabaseCheck() {
        DatabaseCheck a2;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void Execute(String a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

    public static /* synthetic */ void cleanGarbageTable() {
        DatabaseCheck.dropdatabase(AllianceHandler.ALLATORIxDEMO("SfS~BcBqBc"));
        DatabaseCheck.dropdatabase(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)">b!i9x8~.`8k"));
        DatabaseCheck.dropdatabase(AllianceHandler.ALLATORIxDEMO("[eZeXwR\u007f\\\u007f"));
        DatabaseCheck.dropdatabase(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"&y2\u007f#m4x>c9\u007f"));
        DatabaseCheck.dropdatabase(AllianceHandler.ALLATORIxDEMO("Ds[uRqZc"));
        DatabaseCheck.dropdatabase(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"~2|8~#\u007f"));
        DatabaseCheck.dropdatabase(AllianceHandler.ALLATORIxDEMO("CcS|Yw"));
    }

    public static /* synthetic */ void checkAllTable() {
        if (!DBConPool.getInstance().TableExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"4d%S=\u007f8b"))) {
            CharacterSetConverter.convert();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0UxDO\\cY~\u511c\u5306\u5bba\u7572"));
        }
        if (!DBConPool.getInstance().ColumnExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)">b!i9x8~.i&y>|:i9x"), AllianceHandler.ALLATORIxDEMO("UxWb[Un@"))) {
            DatabaseConvert.ChangeItemTable();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u7265\u5496\u6574\u648d\u5ea7"));
        }
        if (GameSetConstants.MAPLE_VERSION >= 134 && !DBConPool.getInstance().ColumnExist(AllianceHandler.ALLATORIxDEMO("W~RbYyRc"), \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"#u'i"))) {
            DatabaseConvert.ChangeAndroidTable();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0\u5dc4\u66e4\u6586QXtD\u007f_t\u6a69\u5678\u4e8c\u6568\u64ec\u5ebb"));
        }
        if (!DBConPool.getInstance().ColumnExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"4d6~6o#i%\u007f"), AllianceHandler.ALLATORIxDEMO("vWd_wCu"))) {
            DatabaseConvert.ChangeChrTable();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u89de\u8225\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("PyEx_~QO]yXw"))) {
            DatabaseConvert.AddFishKing();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"W\u652f\u64d6\u5efc\u81e6\u5282\u66f8\u65e7Qw\u5dfe\u66a3\u65bc\u91b4\u9b56\u73dc\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("EuDfSbicSd"))) {
            DatabaseConvert.AddServerSet();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"W\u652f\u64d6\u5efc\u81e6\u5282\u66f8\u65e7Qw\u5dfe\u66a3\u65bc\u4f6d\u6701\u563f\u66a7\u5b0f\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("yXfS~B\u007fDi_dS}EO\\cY~"))) {
            DatabaseConvert.AddInvJson();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7e9z\bf$c9\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().ColumnExist(AllianceHandler.ALLATORIxDEMO("c^\u007fFyBu[c"), \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"%i&e#i:>"))) {
            DatabaseConvert.ChangeShopitems();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0\u5dc4\u66e4\u6586\u5556\u5ea1\u6568\u64ec\u5ebb"));
        }
        if (!DBConPool.getInstance().ColumnExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"$g>`;\u007f"), AllianceHandler.ALLATORIxDEMO("dSqUx\u007ft"))) {
            DatabaseConvert.teachskill();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u628c\u80aa\u8864"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("|_~SrYd"))) {
            DatabaseConvert.addLineBot();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"W\u652f\u64d6\u5efc\u81e6\u5282\u66f8\u65e7Qw\u5dfe\u66a3\u65bc;e9i5c#\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("WdBqU{_`"))) {
            DatabaseConvert.addAttackIp();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7m#x6o<e'\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("gLODuUxWbQu_dS}"))) {
            DatabaseConvert.addrechargeitem();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u88d0\u6a4e\u6574\u648d\u5ea7"));
        }
        if (ServerSet.getServerSet(AllianceHandler.ALLATORIxDEMO("]uO}W`")) < 1L) {
            DatabaseConvert.expandKeyMap();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7g2u:m'\u6574\u648d\u5ea7"));
            ServerSet.setServerSet(AllianceHandler.ALLATORIxDEMO("]uO}W`"), 1L);
        }
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            if (!(DBConPool.getInstance().TableExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"o?m%m4x2~\bo8~2m\"~6\u007f")) && DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("s^qDqUdSbisWbRc")) && DBConPool.getInstance().TableExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"$x8`2b")) && DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("FqDdBy[u")))) {
                DatabaseConvert.Add147sqls();
                System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"W\u652f\u64d6\u5efc\u81e6\u5282\u66f8\u65e7Qw\u5dfe\u66a3\u65bc!=c;\u4eb2\u4e06\u721f\u6720\u6217\u970c\u76d3\u8ccb\u65ce\u8864"));
            }
            if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("_~XuDOWr_|_dOOE{_|Zc"))) {
                DatabaseConvert.addInnerSkill();
                System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u89de\u8225\u628c\u80aa\u8ccb\u65ce\u8864"));
            }
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("qBdWs]vY~Bc"))) {
            DatabaseConvert.adddamageskin();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u50bb\u5be4\u5b5b\u57dc\u6574\u648d\u5ea7"));
        }
        if (!DBConPool.getInstance().ColumnExist(AllianceHandler.ALLATORIxDEMO("UxWbWsBuDc"), \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"d$|"))) {
            DatabaseConvert.addHsp();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0\u5dc4\u66e4\u6586XO`Sbe@\u6b32\u4f5d"));
        }
        if (!DBConPool.getInstance().ColumnExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u007f?c'e#i:\u007f"), AllianceHandler.ALLATORIxDEMO("[yX|SfS|"))) {
            DatabaseConvert.updateShop();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u007f?c'e#i:\u007f\u6b53\u4f41"));
        }
        if (!DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("cFuUyW|iuGe_`"))) {
            DatabaseConvert.Add_special_equip();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u65bc\u58c9\u7275\u6bdd\u88d1\u50ce\u8864"));
        }
        if (!DBConPool.getInstance().ColumnExist(AllianceHandler.ALLATORIxDEMO("cFuUyW|iuGe_`"), \u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"3m:m0i"))) {
            DatabaseConvert.update_special_equip();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0\u5dc4\u66e4\u6586\u7269\u6bbc\u88cd\u50af\u8878"));
        }
        if (!DBConPool.getInstance().TableExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"$|2o>m;S>x2a"))) {
            DatabaseConvert.Add_special_item();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0\u5dc4\u65a0\u58a8\u7269\u6bbc\u7279\u54f7\u8878"));
        }
        if (!DBConPool.getInstance().TableExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"9m:i'~>v2`8k"))) {
            DatabaseConvert.addnameprizelog();
            System.out.println(AllianceHandler.ALLATORIxDEMO("m\u6568\u64ec\u5ebb\u81dc\u52c5\u66c2\u65a0k0\u5dc4\u66e4\u6586\u4e9b\u527b\u735e\u52c3\u8878"));
        }
        if (!DBConPool.getInstance().ColumnExist(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u007f'i4e6`\bi&y>|"), AllianceHandler.ALLATORIxDEMO("[\u007fTcFqA~"))) {
            DatabaseConvert.updatespecial_equip();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"W\u652f\u64d6\u5efc\u81e6\u5282\u66f8\u65e7Qw\u5dfe\u66a3\u65bc\u722e\u6b86\u888a\u5095\u883f,z,:c5\u007f'm b"));
        }
        if (GameSetConstants.AUCTION_SYSTEM && !DBConPool.getInstance().TableExist(AllianceHandler.ALLATORIxDEMO("qCsByY~"))) {
            DatabaseConvert.Add_Auction();
            System.out.println(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\f\u6574\u648d\u5ea7\u81bd\u52d9\u66a3\u65bc\n,\u5da5\u66f8\u65e7\u7afa\u629a\u8ccb\u65ce\u8864"));
        }
        DatabaseCheck.cleanGarbageTable();
    }

    public static /* synthetic */ void dropdatabase(String a2) {
        try {
            if (DBConPool.getInstance().TableExist(a2)) {
                DatabaseCheck.Execute("DROP TABLE " + a2);
                System.out.println("[\u6578\u64da\u5eab\u81ea\u52d5\u66f4\u65b0]\u5df2\u522a\u9664\u7121\u7528\u8cc7\u6599\u8868: " + a2);
                return;
            }
        }
        catch (Exception exception) {
            System.out.println("ClearAllData:" + exception);
            System.out.println("[\u8cc7\u6599\u8868]" + a2 + " \u522a\u9664\u5931\u6557..");
        }
    }
}

