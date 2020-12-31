/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 */
package handling.login;

import client.MapleJob;
import client.messages.commands.player.\u6070\u6070\u8c37;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import constants.GameSetConstants;
import constants.MobConstants;
import handling.world.CharacterIdChannelPair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.ServerProperties;
import tools.Triple;
import tools.data.ByteArrayByteStream;

public class LoginInformationProvider {
    public final /* synthetic */ Map<Triple<Integer, Integer, Integer>, List<Integer>> makeCharInfo;
    public final /* synthetic */ List<String> ForbiddenName;
    public final /* synthetic */ Map<String, String> Curse;
    private static final /* synthetic */ LoginInformationProvider ALLATORIxDEMO;

    /*
     * Exception decompiling
     */
    public /* synthetic */ LoginInformationProvider() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 7[DOLOOP]
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

    public final /* synthetic */ boolean isEligibleItem(int a22, int a3, int a4, int a5) {
        LoginInformationProvider a6;
        if (a5 < 0) {
            return false;
        }
        Triple<Integer, Integer, Integer> a22 = new Triple<Integer, Integer, Integer>(a22, a3, a4);
        List<Integer> list = a6.makeCharInfo.get(a22);
        if (list == null || !list.contains(a5)) {
            if (a4 == 1) {
                a22 = new Triple<Integer, Integer, Integer>(1, a3, a4);
                list = a6.makeCharInfo.get(a22);
                if (list == null) {
                    return false;
                }
                return list.contains(a5);
            }
            return false;
        }
        return list.contains(a5);
    }

    public final /* synthetic */ boolean isForbiddenName(String a2) {
        LoginInformationProvider a3;
        for (String string : a3.ForbiddenName) {
            if (!a2.toLowerCase().contains(string.toLowerCase())) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new LoginInformationProvider();
    }

    public static /* synthetic */ LoginInformationProvider getInstance() {
        return ALLATORIxDEMO;
    }

    public /* synthetic */ String getCurseMsg(String a2) {
        LoginInformationProvider a3;
        Iterator<Map.Entry<String, String>> iterator;
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            return a2;
        }
        Iterator<Map.Entry<String, String>> iterator2 = iterator = a3.Curse.entrySet().iterator();
        while (iterator2.hasNext()) {
            int n2;
            Map.Entry<String, String> entry = iterator.next();
            Object object = "";
            int n3 = 1;
            String[] arrstring = entry.getKey().split("");
            int n4 = arrstring.length;
            int n5 = n2 = 0;
            while (n5 < n4) {
                String string = arrstring[n2];
                object = (String)object + string;
                if (entry.getKey().length() > n3++ && !string.matches(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0018\u000fn\u0014\u0002C\u00193"))) {
                    object = (String)object + "[[^\\pL]a-zA-Z]*";
                }
                n5 = ++n2;
            }
            if (((String)object).isEmpty()) {
                iterator2 = iterator;
                continue;
            }
            a2 = a2.replaceAll("(?i)" + (String)object, entry.getValue());
            iterator2 = iterator;
        }
        return a2;
    }

    public static final class JobType
    extends Enum<JobType> {
        public /* synthetic */ int flag;
        public static final /* synthetic */ /* enum */ JobType \u5f71\u6b66\u8005;
        public static final /* synthetic */ /* enum */ JobType \u7687\u5bb6\u9a0e\u58eb\u5718;
        public static final /* synthetic */ /* enum */ JobType \u5192\u96aa\u5bb6;
        public static final /* synthetic */ /* enum */ JobType \u60e1\u9b54\u6bba\u624b;
        public static final /* synthetic */ /* enum */ JobType \u51f1\u6492;
        public static final /* synthetic */ /* enum */ JobType \u7c73\u54c8\u9038;
        public static final /* synthetic */ /* enum */ JobType \u5929\u4f7f\u7834\u58de\u8005;
        public static final /* synthetic */ /* enum */ JobType \u84bc\u9f8d\u4fe0\u5ba2;
        public static final /* synthetic */ /* enum */ JobType \u7cbe\u9748\u904a\u4fe0;
        public static final /* synthetic */ /* enum */ JobType \u591c\u5149;
        public static final /* synthetic */ /* enum */ JobType \u5e7b\u5f71\u4fe0\u76dc;
        public static final /* synthetic */ /* enum */ JobType \u91cd\u7832\u6307\u63ee\u5b98;
        private final /* synthetic */ boolean d = true;
        public static final /* synthetic */ /* enum */ JobType \u9f8d\u9b54\u5c0e\u58eb;
        public static final /* synthetic */ /* enum */ JobType \u7d42\u6975\u5192\u96aa\u5bb6;
        public /* synthetic */ int type;
        public /* synthetic */ int id;
        public static final /* synthetic */ /* enum */ JobType \u672b\u65e5\u53cd\u6297\u8ecd;
        public static final /* synthetic */ /* enum */ JobType \u72c2\u72fc\u52c7\u58eb;
        private static final /* synthetic */ JobType[] ALLATORIxDEMO;
        public /* synthetic */ int map;

        public static /* synthetic */ JobType[] values() {
            return (JobType[])ALLATORIxDEMO.clone();
        }

        public /* synthetic */ boolean enableCreate() {
            JobType a2;
            return Boolean.valueOf(ServerProperties.getProperty("JobEnableCreate" + a2.type, String.valueOf(true)));
        }

        public static /* synthetic */ JobType getByType(int a2) {
            int n2;
            JobType[] arrjobType = JobType.values();
            int n3 = arrjobType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                JobType jobType = arrjobType[n2];
                if (jobType.type == a2) {
                    if (GameSetConstants.CREATE_MAP != 0) {
                        jobType.map = GameSetConstants.CREATE_MAP;
                    }
                    return jobType;
                }
                n4 = ++n2;
            }
            return \u5192\u96aa\u5bb6;
        }

        public static /* synthetic */ {
            \u7d42\u6975\u5192\u96aa\u5bb6 = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u7d5b\u6914\u518b\u96cb\u5baf"), 0, JobCreateType.\u7d42\u6975\u5192\u96aa\u5bb6, MapleJob.\u521d\u5fc3\u8005.getId(), JobCreateMap.\u7d42\u6975\u5192\u96aa\u5bb6, JobInfoFlag.\u5e3d\u5b50.getVelue() | JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u8932\u88d9.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue());
            \u672b\u65e5\u53cd\u6297\u8ecd = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u675a\u65bf\u53bc\u62cd\u8ebc"), 1, JobCreateType.\u672b\u65e5\u53cd\u6297\u8ecd, MapleJob.\u5e02\u6c11.getId(), JobCreateMap.\u672b\u65e5\u53cd\u6297\u8ecd, JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue() | (GameSetConstants.MAPLE_VERSION >= 142 ? 0 : JobInfoFlag.\u8932\u88d9.getVelue()));
            \u5192\u96aa\u5bb6 = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u518b\u96cb\u5baf"), 2, JobCreateType.\u5192\u96aa\u5bb6, MapleJob.\u521d\u5fc3\u8005.getId(), JobCreateMap.\u5192\u96aa\u5bb6);
            \u7687\u5bb6\u9a0e\u58eb\u5718 = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u76f6\u5bec\u9a7f\u58b1\u5769"), 3, JobCreateType.\u7687\u5bb6\u9a0e\u58eb\u5718, MapleJob.\u8cb4\u65cf.getId(), JobCreateMap.\u7687\u5bb6\u9a0e\u58eb\u5718);
            \u72c2\u72fc\u52c7\u58eb = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u72a3\u72e5\u52a6\u58f2"), 4, JobCreateType.\u72c2\u72fc\u52c7\u58eb, MapleJob.\u50b3\u8aaa.getId(), JobCreateMap.\u72c2\u72fc\u52c7\u58eb);
            \u9f8d\u9b54\u5c0e\u58eb = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u9fd7\u9b25\u5c54\u589a"), 5, JobCreateType.\u9f8d\u9b54\u5c0e\u58eb, MapleJob.\u9f8d\u9b54\u5c0e\u58eb0\u8f49.getId(), JobCreateMap.\u9f8d\u9b54\u5c0e\u58eb);
            \u7cbe\u9748\u904a\u4fe0 = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u7cdf\u9751\u902b\u4ff9"), 6, JobCreateType.\u7cbe\u9748\u904a\u4fe0, MapleJob.\u7cbe\u9748\u904a\u4fe0.getId(), JobCreateMap.\u7cbe\u9748\u904a\u4fe0, JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue());
            \u60e1\u9b54\u6bba\u624b = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u60bb\u9b25\u6be0\u623a"), 7, JobCreateType.\u60e1\u9b54\u6bba\u624b, MapleJob.\u60e1\u9b54\u6bba\u624b.getId(), JobCreateMap.\u60e1\u9b54\u6bba\u624b, JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u8932\u88d9.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue() | JobInfoFlag.\u76fe\u724c.getVelue());
            \u5e7b\u5f71\u4fe0\u76dc = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5e1a\u5f68\u4f81\u76c5"), 8, JobCreateType.\u5e7b\u5f71\u4fe0\u76dc, MapleJob.\u5e7b\u5f71\u4fe0\u76dc.getId(), JobCreateMap.\u5e7b\u5f71\u4fe0\u76dc);
            \u5f71\u6b66\u8005 = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u5f00\u6b3c\u8074"), 9, JobCreateType.\u5f71\u6b66\u8005, MapleJob.\u521d\u5fc3\u8005.getId(), JobCreateMap.\u5f71\u6b66\u8005);
            \u7c73\u54c8\u9038 = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u7c6a\u54a9\u9021"), 10, JobCreateType.\u7c73\u54c8\u9038, MapleJob.\u7c73\u54c8\u9038.getId(), JobCreateMap.\u7c73\u54c8\u9038);
            \u591c\u5149 = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u5946\u5138"), 11, JobCreateType.\u591c\u5149, MapleJob.\u591c\u5149.getId(), JobCreateMap.\u591c\u5149);
            \u51f1\u6492 = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5190\u648b"), 12, JobCreateType.\u51f1\u6492, MapleJob.\u51f1\u6492.getId(), JobCreateMap.\u51f1\u6492, JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue());
            \u5929\u4f7f\u7834\u58de\u8005 = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u5958\u4f25\u7845\u5884\u8074"), 13, JobCreateType.\u5929\u4f7f\u7834\u58de\u8005, MapleJob.\u5929\u4f7f\u7834\u58de\u8005.getId(), JobCreateMap.\u5929\u4f7f\u7834\u58de\u8005, JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue());
            \u91cd\u7832\u6307\u63ee\u5b98 = new JobType(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u91d4\u7853\u631e\u638f\u5b81"), 14, JobCreateType.\u91cd\u7832\u6307\u63ee\u5b98, MapleJob.\u521d\u5fc3\u8005.getId(), JobCreateMap.\u91cd\u7832\u6307\u63ee\u5b98);
            \u84bc\u9f8d\u4fe0\u5ba2 = new JobType(CharacterIdChannelPair.ALLATORIxDEMO("\u84e6\u9ffc\u4fba\u5bd3"), 15, JobCreateType.\u84bc\u9f8d\u4fe0\u5ba2, MapleJob.\u521d\u5fc3\u8005.getId(), JobCreateMap.\u84bc\u9f8d\u4fe0\u5ba2);
            JobType[] arrjobType = new JobType[16];
            arrjobType[0] = \u7d42\u6975\u5192\u96aa\u5bb6;
            arrjobType[1] = \u672b\u65e5\u53cd\u6297\u8ecd;
            arrjobType[2] = \u5192\u96aa\u5bb6;
            arrjobType[3] = \u7687\u5bb6\u9a0e\u58eb\u5718;
            arrjobType[4] = \u72c2\u72fc\u52c7\u58eb;
            arrjobType[5] = \u9f8d\u9b54\u5c0e\u58eb;
            arrjobType[6] = \u7cbe\u9748\u904a\u4fe0;
            arrjobType[7] = \u60e1\u9b54\u6bba\u624b;
            arrjobType[8] = \u5e7b\u5f71\u4fe0\u76dc;
            arrjobType[9] = \u5f71\u6b66\u8005;
            arrjobType[10] = \u7c73\u54c8\u9038;
            arrjobType[11] = \u591c\u5149;
            arrjobType[12] = \u51f1\u6492;
            arrjobType[13] = \u5929\u4f7f\u7834\u58de\u8005;
            arrjobType[14] = \u91cd\u7832\u6307\u63ee\u5b98;
            arrjobType[15] = \u84bc\u9f8d\u4fe0\u5ba2;
            ALLATORIxDEMO = arrjobType;
        }

        public static /* synthetic */ JobType valueOf(String a2) {
            return Enum.valueOf(JobType.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ JobType(int n22, int n22, int a2) {
            void a3;
            void a4;
            void var2_-1;
            void var1_-1;
            JobType a5;
            JobType jobType = a5;
            JobType jobType2 = a5;
            a5.flag = JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u8932\u88d9.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue();
            jobType2.d = true;
            jobType2.type = a2;
            jobType.id = a4;
            jobType.map = a3;
        }

        public static /* synthetic */ JobType getById(int a2) {
            int n2;
            JobType[] arrjobType = JobType.values();
            int n3 = arrjobType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                JobType jobType = arrjobType[n2];
                if (jobType.id == a2) {
                    return jobType;
                }
                n4 = ++n2;
            }
            return \u5192\u96aa\u5bb6;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ JobType(int n22, int n22, int a2, int a3) {
            void a4;
            void a5;
            void var2_-1;
            void var1_-1;
            JobType a6;
            JobType jobType = a6;
            JobType jobType2 = a6;
            a6.flag = JobInfoFlag.\u81c9\u578b.getVelue() | JobInfoFlag.\u9aee\u578b.getVelue() | JobInfoFlag.\u8863\u670d.getVelue() | JobInfoFlag.\u8932\u88d9.getVelue() | JobInfoFlag.\u978b\u5b50.getVelue() | JobInfoFlag.\u6b66\u5668.getVelue();
            a6.d = true;
            jobType2.type = a2;
            jobType2.id = a3;
            jobType.map = a5;
            jobType.flag = a4;
        }

        public /* synthetic */ void setEnableCreate(boolean a2) {
            JobType a3;
            if (a2) {
                ServerProperties.removeProperty("JobEnableCreate" + a3.type);
                return;
            }
            ServerProperties.setProperty("JobEnableCreate" + a3.type, String.valueOf(a2));
        }
    }

    public static final class JobCreateType {
        public static /* synthetic */ int \u9f8d\u9b54\u5c0e\u58eb;
        public static /* synthetic */ int \u5929\u4f7f\u7834\u58de\u8005;
        public static /* synthetic */ int \u672b\u65e5\u53cd\u6297\u8ecd;
        public static /* synthetic */ int \u72c2\u72fc\u52c7\u58eb;
        public static /* synthetic */ int \u60e1\u9b54\u6bba\u624b;
        public static /* synthetic */ int \u7c73\u54c8\u9038;
        public static /* synthetic */ int \u7687\u5bb6\u9a0e\u58eb\u5718;
        public static /* synthetic */ int \u84bc\u9f8d\u4fe0\u5ba2;
        public static /* synthetic */ int \u5e7b\u5f71\u4fe0\u76dc;
        public static /* synthetic */ int \u51f1\u6492;
        public static /* synthetic */ int \u7d42\u6975\u5192\u96aa\u5bb6;
        public static /* synthetic */ int \u5f71\u6b66\u8005;
        public static /* synthetic */ int \u7cbe\u9748\u904a\u4fe0;
        public static /* synthetic */ int \u5192\u96aa\u5bb6;
        public static /* synthetic */ int \u591c\u5149;
        public static /* synthetic */ int \u91cd\u7832\u6307\u63ee\u5b98;

        public /* synthetic */ JobCreateType() {
            JobCreateType a2;
        }

        public static /* synthetic */ {
            \u7d42\u6975\u5192\u96aa\u5bb6 = -1;
            \u672b\u65e5\u53cd\u6297\u8ecd = 0;
            \u5192\u96aa\u5bb6 = 1;
            \u7687\u5bb6\u9a0e\u58eb\u5718 = 2;
            \u72c2\u72fc\u52c7\u58eb = 3;
            \u9f8d\u9b54\u5c0e\u58eb = 4;
            \u7cbe\u9748\u904a\u4fe0 = 5;
            \u60e1\u9b54\u6bba\u624b = 6;
            \u5e7b\u5f71\u4fe0\u76dc = 7;
            \u5f71\u6b66\u8005 = 8;
            \u7c73\u54c8\u9038 = 9;
            \u591c\u5149 = 10;
            \u51f1\u6492 = 11;
            \u5929\u4f7f\u7834\u58de\u8005 = 12;
            \u91cd\u7832\u6307\u63ee\u5b98 = 13;
            \u84bc\u9f8d\u4fe0\u5ba2 = 19;
            JobCreateType.reloadset();
        }

        public static /* synthetic */ void reloadset() {
            if (GameSetConstants.MAPLE_VERSION < 134) {
                \u7687\u5bb6\u9a0e\u58eb\u5718 = 0;
                \u5192\u96aa\u5bb6 = 1;
                \u72c2\u72fc\u52c7\u58eb = 2;
                \u9f8d\u9b54\u5c0e\u58eb = 3;
                \u672b\u65e5\u53cd\u6297\u8ecd = 4;
            }
        }
    }

    public static final class JobCreateMap {
        public static /* synthetic */ int \u591c\u5149;
        public static /* synthetic */ int \u9f8d\u9b54\u5c0e\u58eb;
        public static /* synthetic */ int \u51f1\u6492;
        public static /* synthetic */ int \u60e1\u9b54\u6bba\u624b;
        public static /* synthetic */ int \u7d42\u6975\u5192\u96aa\u5bb6;
        public static /* synthetic */ int \u5929\u4f7f\u7834\u58de\u8005;
        public static /* synthetic */ int \u5192\u96aa\u5bb6;
        public static /* synthetic */ int \u84bc\u9f8d\u4fe0\u5ba2;
        public static /* synthetic */ int \u91cd\u7832\u6307\u63ee\u5b98;
        public static /* synthetic */ int \u7c73\u54c8\u9038;
        public static /* synthetic */ int \u5f71\u6b66\u8005;
        public static /* synthetic */ int \u72c2\u72fc\u52c7\u58eb;
        public static /* synthetic */ int \u7cbe\u9748\u904a\u4fe0;
        public static /* synthetic */ int \u5e7b\u5f71\u4fe0\u76dc;
        public static /* synthetic */ int \u672b\u65e5\u53cd\u6297\u8ecd;
        public static /* synthetic */ int \u7687\u5bb6\u9a0e\u58eb\u5718;

        public static /* synthetic */ void reloadset() {
            if (GameSetConstants.MAPLE_VERSION == 116) {
                \u9f8d\u9b54\u5c0e\u58eb = 900010000;
            }
            if (GameSetConstants.MAPLE_VERSION >= 134 && GameSetConstants.MAPLE_VERSION <= 136) {
                \u7687\u5bb6\u9a0e\u58eb\u5718 = 913040000;
            }
        }

        public /* synthetic */ JobCreateMap() {
            JobCreateMap a2;
        }

        public static /* synthetic */ {
            \u7d42\u6975\u5192\u96aa\u5bb6 = 100000000;
            \u7687\u5bb6\u9a0e\u58eb\u5718 = 130030000;
            \u5192\u96aa\u5bb6 = 0;
            \u72c2\u72fc\u52c7\u58eb = 914000000;
            \u9f8d\u9b54\u5c0e\u58eb = 900090000;
            \u672b\u65e5\u53cd\u6297\u8ecd = 931000000;
            \u7cbe\u9748\u904a\u4fe0 = 910150000;
            \u60e1\u9b54\u6bba\u624b = 931050310;
            \u5e7b\u5f71\u4fe0\u76dc = 915000000;
            \u5f71\u6b66\u8005 = 0;
            \u7c73\u54c8\u9038 = 913070000;
            \u591c\u5149 = 927020080;
            \u51f1\u6492 = 940001000;
            \u5929\u4f7f\u7834\u58de\u8005 = 940011000;
            \u91cd\u7832\u6307\u63ee\u5b98 = 3000600;
            \u84bc\u9f8d\u4fe0\u5ba2 = 743020100;
            JobCreateMap.reloadset();
        }
    }

    public static final class JobInfoFlag
    extends Enum<JobInfoFlag> {
        public static final /* synthetic */ /* enum */ JobInfoFlag \u9aee\u578b;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u5e3d\u5b50;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u6b66\u5668;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u5c3e\u5df4;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u8932\u88d9;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u76fe\u724c;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u81c9\u98fe;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u8863\u670d;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u62ab\u98a8;
        private static final /* synthetic */ JobInfoFlag[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u8033\u6735;
        private final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u526f\u624b;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u81c9\u578b;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u978b\u5b50;
        public static final /* synthetic */ /* enum */ JobInfoFlag \u624b\u5957;

        public static /* synthetic */ {
            \u81c9\u578b = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u81e4\u57bc"), 0, 1);
            \u9aee\u578b = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u9aec\u57bf"), 1, 2);
            \u81c9\u98fe = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u81e4\u98c9"), 2, 4);
            \u8033\u6735 = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u8031\u6701"), 3, 8);
            \u5c3e\u5df4 = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u5c13\u5dc3"), 4, 16);
            \u5e3d\u5b50 = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u5e3f\u5b64"), 5, 32);
            \u8863\u670d = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u884e\u673a"), 6, 64);
            \u8932\u88d9 = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u8930\u88ed"), 7, 128);
            \u62ab\u98a8 = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u6286\u989f"), 8, 256);
            \u978b\u5b50 = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u9789\u5b64"), 9, 512);
            \u624b\u5957 = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u6266\u5960"), 10, 1024);
            \u6b66\u5668 = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u6b64\u565c"), 11, 2048);
            \u526f\u624b = new JobInfoFlag(ByteArrayByteStream.ALLATORIxDEMO("\u5242\u627c"), 12, 4096);
            \u76fe\u724c = new JobInfoFlag(MobConstants.ALLATORIxDEMO("\u76fc\u7278"), 13, 8192);
            JobInfoFlag[] arrjobInfoFlag = new JobInfoFlag[14];
            arrjobInfoFlag[0] = \u81c9\u578b;
            arrjobInfoFlag[1] = \u9aee\u578b;
            arrjobInfoFlag[2] = \u81c9\u98fe;
            arrjobInfoFlag[3] = \u8033\u6735;
            arrjobInfoFlag[4] = \u5c3e\u5df4;
            arrjobInfoFlag[5] = \u5e3d\u5b50;
            arrjobInfoFlag[6] = \u8863\u670d;
            arrjobInfoFlag[7] = \u8932\u88d9;
            arrjobInfoFlag[8] = \u62ab\u98a8;
            arrjobInfoFlag[9] = \u978b\u5b50;
            arrjobInfoFlag[10] = \u624b\u5957;
            arrjobInfoFlag[11] = \u6b66\u5668;
            arrjobInfoFlag[12] = \u526f\u624b;
            arrjobInfoFlag[13] = \u76fe\u724c;
            ALLATORIxDEMO = arrjobInfoFlag;
        }

        public static /* synthetic */ JobInfoFlag[] values() {
            return (JobInfoFlag[])ALLATORIxDEMO.clone();
        }

        public /* synthetic */ int getVelue() {
            JobInfoFlag a2;
            return a2.d;
        }

        public /* synthetic */ boolean check(int a2) {
            JobInfoFlag a3;
            return (a3.d & a2) != 0;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ JobInfoFlag(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            JobInfoFlag a3;
            a3.d = a2;
        }

        public static /* synthetic */ JobInfoFlag valueOf(String a2) {
            return Enum.valueOf(JobInfoFlag.class, a2);
        }
    }
}

