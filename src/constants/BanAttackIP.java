/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 */
package constants;

import client.MapleClient;
import constants.GameSetConstants;
import database.DBConPool;
import handling.ClientChannelGroup;
import io.netty.channel.ChannelHandlerContext;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import server.buffs.AbstractBuffClass;
import server.maps.MapleNodes;
import tools.CloudFlare.CloudFlareAPI;
import tools.FileoutputUtil;
import tools.others.PortScanner;

/*
 * Exception performing whole class analysis ignored.
 */
public class BanAttackIP {
    public static /* synthetic */ List<String> ipadd;
    private static final /* synthetic */ Map<String, Integer> ALLATORIxDEMO;
    public static /* synthetic */ HashSet<String> ipnew;
    public static /* synthetic */ HashSet<String> ipban;
    public static /* synthetic */ long time;

    public static /* synthetic */ {
        ipnew = new HashSet();
        ipadd = new LinkedList<String>();
        ALLATORIxDEMO = new ConcurrentHashMap<String, Integer>();
        ipban = new HashSet();
        time = -1L;
        BanAttackIP.loadAttackIP();
    }

    public static /* synthetic */ void InsertCloudFlare() {
        int n2 = 0;
        Iterator<String> iterator = ipban.iterator();
        while (iterator.hasNext()) {
            if (!CloudFlareAPI.addBanIP(iterator.next())) continue;
            ++n2;
        }
        System.out.println("\u532f\u5165CF\u5b8c\u7562! \u4e00\u5171\u532f\u5165:" + n2 + "\u7b46IP\u8cc7\u6599");
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void reDumpAtackIp() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void loadAttackIP() {
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapleNodes.ALLATORIxDEMO("}IbImX.\u0006.J|Cc\foXzMmGg\\"));
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            BanAttackIP.ipban.add(resultSet.getString(AbstractBuffClass.ALLATORIxDEMO("tja\u007fvu|n")));
            v0 = resultSet;
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v1 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v1 = throwable;
                    }
                    throw v1;
                }
                catch (SQLException sQLException) {
                    System.err.println(sQLException);
                }
            }
        }
    }

    public static /* synthetic */ void InsertCloudFlare(String a2) {
        int n2 = 0;
        if (CloudFlareAPI.addBanIP(a2)) {
            ++n2;
        }
        System.out.println("\u532f\u5165CF\u5b8c\u7562! \u4e00\u5171\u532f\u5165:" + n2 + "\u7b46IP\u8cc7\u6599 IP:" + a2);
    }

    public static /* synthetic */ void scanPort() throws InterruptedException, ExecutionException {
        Iterator<String> iterator;
        boolean bl = false;
        Iterator<String> iterator2 = iterator = ipban.iterator();
        while (iterator2.hasNext()) {
            PortScanner.scan(iterator.next());
            iterator2 = iterator;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void checkAttackIP(ChannelHandlerContext a2, String a3) {
        MapleClient mapleClient = (MapleClient)a2.channel().attr(MapleClient.CLIENT_KEY).get();
        if (time != -1L && System.currentTimeMillis() - time < 3000L) {
            if (ALLATORIxDEMO.containsKey(a3)) {
                int n2 = ALLATORIxDEMO.get(a3);
                ALLATORIxDEMO.remove(a3);
                ALLATORIxDEMO.put(a3, ++n2);
                if (n2 < 10) return;
                ALLATORIxDEMO.remove(a3);
                ipban.add(a3);
                a2.channel().close();
                if (GameSetConstants.CF_TRANSFER) {
                    String string = a3;
                    BanAttackIP.InsertCloudFlare(string);
                    ClientChannelGroup.DcChannelByIp_CF(string);
                }
                FileoutputUtil.logToFile(AbstractBuffClass.ALLATORIxDEMO("rzyf1\\N\u9036\u7dc4\u652e\u64d4;jmj"), "\r\n" + a3 + " " + mapleClient.getPlayer(), false);
                return;
            }
            ALLATORIxDEMO.put(a3, 1);
            return;
        }
        ALLATORIxDEMO.clear();
        time = System.currentTimeMillis();
    }

    public /* synthetic */ BanAttackIP() {
        BanAttackIP a2;
    }
}

