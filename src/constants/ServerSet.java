/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package constants;

import client.MapleCharacter;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.eventSystem.SellSystem;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.world.World;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import server.Randomizer;
import tools.FilePrinter;
import tools.MaplePacketCreator;
import tools.Triple;

public class ServerSet {
    public static /* synthetic */ Triple<String, Integer, Integer> DonateEnvelop;
    private static /* synthetic */ Map<String, Long> ALLATORIxDEMO;

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void saveServerSet() {
        String string = "";
        if (ALLATORIxDEMO.size() <= 0) return;
        try {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            Map.Entry<String, Long> entry;
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = druidPooledConnection.prepareStatement(SellSystem.ALLATORIxDEMO("1*9*!*U)' 8O\u0006\n\u0007\u0019\u0010\u001d*\u001c\u0010\u001b"));
            preparedStatement.execute();
            preparedStatement.close();
            boolean bl = true;
            StringBuilder stringBuilder3 = new StringBuilder();
            Iterator<Map.Entry<String, Long>> iterator = ALLATORIxDEMO.entrySet().iterator();
            Iterator<Map.Entry<String, Long>> iterator2 = iterator;
            while (iterator2.hasNext()) {
                entry = iterator.next();
                if (bl) {
                    bl = false;
                    StringBuilder stringBuilder4 = stringBuilder3;
                    stringBuilder2 = stringBuilder4;
                    stringBuilder4.append(BankSystem.ALLATORIxDEMO(":9 2!#S>=#<W\u0013\u0004\u0016\u0005\u0005\u0012\u0001(\u0000\u0012\u0007\u0017S_\u0013\u001e\u0017\u0017_\u0017\u0015\u0002\u001d\u0014\u0007\u001e\u001c\u0019\u0013[S\u0017\u001d\u0002\u001e\u0015\u0016\u0005\u0013^S!2;&2 _"));
                    break block12;
                }
                stringBuilder = stringBuilder3;
            }
            {
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (druidPooledConnection != null) {
                        try {
                            druidPooledConnection.close();
                            throwable2 = throwable;
                            throw throwable2;
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                    }
                    throwable2 = throwable;
                    throw throwable2;
                }
            }
            {
                block12: {
                    stringBuilder2 = stringBuilder;
                    stringBuilder.append(SellSystem.ALLATORIxDEMO("YG"));
                }
                stringBuilder2.append(BankSystem.ALLATORIxDEMO("7256&;'["));
                stringBuilder3.append("'" + entry.getKey() + "'").append(SellSystem.ALLATORIxDEMO("C"));
                stringBuilder3.append(entry.getValue()).append(BankSystem.ALLATORIxDEMO("^"));
                iterator2 = iterator;
                continue;
            }
            string = stringBuilder3.toString();
            preparedStatement = druidPooledConnection.prepareStatement(stringBuilder3.toString());
            preparedStatement.execute();
            preparedStatement.close();
            if (druidPooledConnection == null) return;
            druidPooledConnection.close();
            return;
        }
        catch (Exception exception) {
            System.out.println("saveServerSet\u932f\u8aa4:" + exception);
            FilePrinter.printError(SellSystem.ALLATORIxDEMO("\u001c\u0014\u0019\u0010<\u0010\u001d\u0003\n\u0007<\u0010\u001b[\u001b\r\u001b"), exception + string);
        }
    }

    public static /* synthetic */ String getEnvelop(MapleCharacter a2) {
        if (DonateEnvelop == null || DonateEnvelop.getRight() == 0) {
            return BankSystem.ALLATORIxDEMO("\u769d\u523a\u6ce1\u677e\u7d76\u5372\u539c\u4e92\u986b\u53a1\u5495V");
        }
        String string = DonateEnvelop.getLeft();
        int n2 = DonateEnvelop.getMid();
        int n3 = DonateEnvelop.getRight() - 1;
        if (a2.getName().equals(string)) {
            return SellSystem.ALLATORIxDEMO("\u60dd\u714e\u6ca0\u9877\u53a3\u8185\u5d84\u76eb\u7d70\u536a\u5493N");
        }
        if (a2.getAcLogReload(string + "\u7d05\u5305") < 1) {
            String string2;
            int n4 = (int)((double)(n2 * 5 * Randomizer.rand(1, 2)) * 0.01);
            DonateEnvelop = new Triple<String, Integer, Integer>(string, n2, n3);
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.modifyCSPoints(true ? 1 : 0, n4, true);
            mapleCharacter.setAcLog(string + "\u7d05\u5305");
            if (n3 == 0) {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u7d05\u5305\u5feb\u8a0a]: \u73a9\u5bb6 " + string + " \u6240\u767c\u653e\u7684\u7d05\u5305\u5df2\u5168\u6578\u88ab\u6436\u5149!"));
                string2 = string;
            } else {
                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u7d05\u5305\u5feb\u8a0a]\u73a9\u5bb6: " + a2.getName() + " \u6436\u5230\u7d05\u5305\u56c9 \u5927\u5bb6\u8981\u6436\u8981\u5feb! \u5269\u4e0b " + n3 + " \u5305!"));
                string2 = string;
            }
            return "\u606d\u559c\u60a8\u6436\u5230\u73a9\u5bb6: " + string2 + " \u6240\u767c\u9001\u7684\u7d05\u5305,\u91d1\u984d: " + n4 + " GASH";
        }
        return "\u60a8\u5df2\u7d93\u9818\u53d6\u904e " + string + " \u6240\u767c\u7684\u7d05\u5305\u4e86\u54e6!";
    }

    public static /* synthetic */ void setServerSet(String a2, long a3) {
        ALLATORIxDEMO.remove(a2);
        ALLATORIxDEMO.put(a2, a3);
    }

    public static /* synthetic */ long getServerSet(String a2) {
        long l2 = 0L;
        if (ALLATORIxDEMO.containsKey(a2)) {
            l2 = ALLATORIxDEMO.get(a2);
        }
        return l2;
    }

    public /* synthetic */ ServerSet() {
        ServerSet a2;
    }

    public static /* synthetic */ String setEnvelop(MapleCharacter a2) {
        Object object = "";
        MapleCharacter mapleCharacter = a2;
        int n2 = (int)mapleCharacter.getClient().getYesturdayDonate();
        if (mapleCharacter.getAcLogReload(BankSystem.ALLATORIxDEMO("\u760b\u7d76\u5372")) < 1) {
            if (n2 >= 1000) {
                if (DonateEnvelop == null || DonateEnvelop.getRight() == 0) {
                    DonateEnvelop = new Triple<String, Integer, Integer>(a2.getName(), n2, 50);
                    MapleCharacter mapleCharacter2 = a2;
                    mapleCharacter2.setAcLog(SellSystem.ALLATORIxDEMO("\u7613\u7d70\u536a"));
                    World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u7d05\u5305\u5feb\u8a0a]\u73a9\u5bb6: " + mapleCharacter2.getName() + " \u767c\u653e\u7d05\u5305\u56c9! \u5927\u5bb6\u8981\u6436\u8981\u5feb!"));
                    object = "\u60a8\u5df2\u653e\u7d05\u5305 " + n2 + " \u5143!";
                    return object;
                }
                object = "\u73a9\u5bb6: " + DonateEnvelop.getLeft() + " \u6240\u767c\u653e\u7684\u7d05\u5305\u5c1a\u672a\u9192\u53d6\u5b8c\u7562! \u9918: " + DonateEnvelop.getRight() + " \u5305";
                return object;
            }
            object = BankSystem.ALLATORIxDEMO("\u60df\u665b\u6592\u8d79\u52de\u6759\u9023BGCG\u5130\u7156\u6ca6\u760b\u654d\u7d72\u5376V");
            return object;
        }
        object = SellSystem.ALLATORIxDEMO("\u60c7\u4ebf\u658a\u5d87\u7613\u903b\u7d6a\u5370N");
        return object;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void loadServerSet() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
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

    public static /* synthetic */ void gainServerSet(String a2, long a3) {
        long l2 = ServerSet.getServerSet(a2);
        ALLATORIxDEMO.remove(a2);
        ALLATORIxDEMO.put(a2, l2 + a3);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new HashMap<String, Long>();
        DonateEnvelop = null;
    }
}

