/*
 * Decompiled with CFR 0.150.
 */
package tools.wztosql;

import client.PlayerRandomStream;
import constants.skills.SkillType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import tools.Pair;
import tools.StringUtil;

public class MonsterDropCreator {
    private static /* synthetic */ List<Pair<Integer, String>> K;
    private static /* synthetic */ Map<Integer, Boolean> d;
    private static /* synthetic */ List<Pair<Integer, MobInfo>> a;
    private static final /* synthetic */ MapleDataProvider ALLATORIxDEMO;

    public static /* synthetic */ {
        K = new ArrayList<Pair<Integer, String>>();
        a = new ArrayList<Pair<Integer, MobInfo>>();
        d = new HashMap<Integer, Boolean>();
        ALLATORIxDEMO = MapleDataProviderFactory.getDataProvider(SkillType.ALLATORIxDEMO("`PAM]C\u001dSI"));
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ int ALLATORIxDEMO(int a2, int a3) {
        switch (a2) {
            case 1002357: 
            case 1002390: 
            case 1002430: 
            case 1002926: 
            case 1002927: {
                return 3;
            }
            case 1122000: {
                return 2;
            }
            case 4021010: {
                return 3;
            }
            case 1002972: {
                return 2;
            }
            case 4000172: {
                if (a3 == 7220001) {
                    return 4;
                }
                return 1;
            }
            case 4000000: 
            case 4000003: 
            case 4000005: 
            case 4000016: 
            case 4000018: 
            case 4000019: 
            case 4000021: 
            case 4000026: 
            case 4000029: 
            case 4000031: 
            case 4000032: 
            case 4000033: 
            case 4000043: 
            case 4000044: 
            case 4000073: 
            case 4000074: 
            case 4000113: 
            case 4000114: 
            case 4000115: 
            case 4000117: 
            case 4000118: 
            case 4000119: 
            case 4000166: 
            case 4000167: 
            case 4000195: 
            case 4000268: 
            case 4000269: 
            case 4000270: 
            case 4000283: 
            case 4000284: 
            case 4000285: 
            case 4000289: 
            case 4000298: 
            case 4000329: 
            case 4000330: 
            case 4000331: 
            case 4000356: 
            case 4000364: 
            case 4000365: {
                if (a3 != 2220000 && a3 != 3220000 && a3 != 0x312221 && a3 != 0x406460 && a3 != 5220000 && a3 != 5220002 && a3 != 5220003 && a3 != 6220000 && a3 != 4000119 && a3 != 7220000 && a3 != 7220002 && a3 != 8220000 && a3 != 8220002 && a3 != 8220003) {
                    return 1;
                }
                return 3;
            }
        }
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ int ALLATORIxDEMO(int a2, int a3, boolean a4) {
        switch (a2 / 10000) {
            case 100: {
                switch (a2) {
                    case 1002357: 
                    case 1002390: 
                    case 1002430: 
                    case 1002905: 
                    case 1002906: 
                    case 1002926: 
                    case 1002927: 
                    case 1002972: {
                        return 300000;
                    }
                }
                return 1500;
            }
            case 103: {
                switch (a2) {
                    case 1032062: {
                        return 100;
                    }
                }
                return 1000;
            }
            case 105: 
            case 109: {
                switch (a2) {
                    case 1092049: {
                        return 100;
                    }
                }
                return 700;
            }
            case 104: 
            case 106: 
            case 107: {
                switch (a2) {
                    case 1072369: {
                        return 300000;
                    }
                }
                return 800;
            }
            case 108: 
            case 110: {
                return 1000;
            }
            case 112: {
                switch (a2) {
                    case 1122000: {
                        return 300000;
                    }
                    case 1122011: 
                    case 1122012: {
                        return 800000;
                    }
                }
            }
            case 130: 
            case 131: 
            case 132: 
            case 137: {
                switch (a2) {
                    case 1372049: {
                        return 999999;
                    }
                }
                return 700;
            }
            case 138: 
            case 140: 
            case 141: 
            case 142: 
            case 144: {
                return 700;
            }
            case 133: 
            case 143: 
            case 145: 
            case 146: 
            case 147: 
            case 148: 
            case 149: {
                return 500;
            }
            case 204: {
                switch (a2) {
                    case 2049000: {
                        return 150;
                    }
                }
                return 300;
            }
            case 205: {
                return 50000;
            }
            case 206: {
                return 30000;
            }
            case 228: {
                return 30000;
            }
            case 229: {
                switch (a2) {
                    case 2290096: {
                        return 800000;
                    }
                    case 2290125: {
                        return 100000;
                    }
                }
                return 500;
            }
            case 233: {
                switch (a2) {
                    case 2330007: {
                        return 50;
                    }
                }
                return 500;
            }
            case 400: {
                switch (a2) {
                    case 4000021: {
                        return 50000;
                    }
                    case 4001094: {
                        return 999999;
                    }
                    case 4001000: {
                        return 5000;
                    }
                    case 4000157: {
                        return 100000;
                    }
                    case 4001023: 
                    case 0x3D0D00: {
                        return 999999;
                    }
                    case 4000244: 
                    case 4000245: {
                        return 2000;
                    }
                    case 4001005: {
                        return 5000;
                    }
                    case 4001006: {
                        return 10000;
                    }
                    case 4000017: 
                    case 4000082: {
                        return 40000;
                    }
                    case 4000446: 
                    case 4000451: 
                    case 4000456: {
                        return 10000;
                    }
                    case 4000459: {
                        return 20000;
                    }
                    case 4000030: {
                        return 60000;
                    }
                    case 4000339: {
                        return 70000;
                    }
                    case 4000313: 
                    case 4007000: 
                    case 4007001: 
                    case 4007002: 
                    case 4007003: 
                    case 4007004: 
                    case 4007005: 
                    case 4007006: 
                    case 4007007: 
                    case 4031456: {
                        return 100000;
                    }
                    case 4001126: {
                        return 500000;
                    }
                }
                switch (a2 / 1000) {
                    case 4000: 
                    case 4001: {
                        return 600000;
                    }
                    case 4003: {
                        return 200000;
                    }
                    case 4004: 
                    case 4006: {
                        return 10000;
                    }
                    case 4005: {
                        return 1000;
                    }
                }
            }
            case 401: 
            case 402: {
                switch (a2) {
                    case 4020009: {
                        return 5000;
                    }
                    case 4021010: {
                        return 300000;
                    }
                }
                return 9000;
            }
            case 403: {
                switch (a2) {
                    case 4032024: {
                        return 50000;
                    }
                    case 4032181: {
                        if (a4) {
                            return 999999;
                        }
                        return 300000;
                    }
                    case 4032025: 
                    case 4032155: 
                    case 4032156: 
                    case 4032159: 
                    case 4032161: 
                    case 4032163: {
                        return 600000;
                    }
                    case 4032166: 
                    case 4032167: 
                    case 4032168: {
                        return 10000;
                    }
                    case 4032151: 
                    case 4032158: 
                    case 4032164: 
                    case 4032180: {
                        return 2000;
                    }
                    case 4032152: 
                    case 4032153: 
                    case 4032154: {
                        return 4000;
                    }
                }
                return 300;
            }
            case 413: {
                return 6000;
            }
            case 416: {
                return 6000;
            }
            case 428: {
                return 100;
            }
        }
        switch (a2 / 1000000) {
            case 1: {
                return 999999;
            }
            case 2: {
                switch (a2) {
                    case 2000004: 
                    case 2000005: {
                        if (a4) {
                            return 999999;
                        }
                        return 20000;
                    }
                    case 2000006: {
                        if (a3 == 9420540) {
                            return 50000;
                        }
                        if (a4) {
                            return 999999;
                        }
                        return 20000;
                    }
                    case 2022345: {
                        if (a4) {
                            return 999999;
                        }
                        return 3000;
                    }
                    case 2012002: {
                        return 6000;
                    }
                    case 2020013: 
                    case 2020015: {
                        if (a4) {
                            return 999999;
                        }
                        return 20000;
                    }
                    case 2060000: 
                    case 2060001: 
                    case 2061000: 
                    case 2061001: {
                        return 25000;
                    }
                    case 2070000: 
                    case 2070001: 
                    case 2070002: 
                    case 2070003: 
                    case 2070004: 
                    case 2070008: 
                    case 2070009: 
                    case 2070010: {
                        return 500;
                    }
                    case 2070005: {
                        return 400;
                    }
                    case 2070006: 
                    case 2070007: {
                        return 200;
                    }
                    case 2070012: 
                    case 2070013: {
                        return 1500;
                    }
                    case 2070019: {
                        return 100;
                    }
                    case 2210006: {
                        return 999999;
                    }
                }
                return 20000;
            }
            case 3: {
                switch (a2) {
                    case 3010007: 
                    case 3010008: {
                        return 500;
                    }
                }
                return 2000;
            }
        }
        System.out.println("\u672a\u8655\u7406\u7684\u6578\u64da, ID : " + a2);
        return 999999;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ void H() {
        int n2;
        System.out.println(SkillType.ALLATORIxDEMO("\u8f3a\u5141\u725a\u54e5\u543e\u7a15\u001d\n\u001d"));
        ArrayList<Pair<Integer, String>> arrayList = new ArrayList<Pair<Integer, String>>();
        String[] arrstring = new String[6];
        arrstring[0] = PlayerRandomStream.ALLATORIxDEMO("\u0010. '}&>(");
        arrstring[1] = SkillType.ALLATORIxDEMO("pK]WFIV\nZIT");
        arrstring[2] = PlayerRandomStream.ALLATORIxDEMO("\u0006=<}&>(");
        arrstring[3] = SkillType.ALLATORIxDEMO("cAG\nZIT");
        arrstring[4] = PlayerRandomStream.ALLATORIxDEMO("\n\"?}&>(");
        arrstring[5] = SkillType.ALLATORIxDEMO("vPP\nZIT");
        String[] arrstring2 = arrstring;
        String[] arrstring3 = arrstring;
        int n3 = arrstring2.length;
        int n4 = n2 = 0;
        while (true) {
            Iterable<MapleData> iterable;
            int n5;
            Iterable<Object> iterable2;
            String string;
            block12: {
                if (n4 >= n3) {
                    K.addAll(arrayList);
                    return;
                }
                string = arrstring2[n2];
                iterable2 = new ArrayList<MapleData>();
                Object object = string;
                int n6 = -1;
                switch (((String)object).hashCode()) {
                    case 153247737: {
                        if (!((String)object).equals(PlayerRandomStream.ALLATORIxDEMO("\n\"?}&>("))) break;
                        n5 = n6 = 0;
                        break block12;
                    }
                    case 227129417: {
                        if (!((String)object).equals(SkillType.ALLATORIxDEMO("vPP\nZIT"))) break;
                        n6 = 1;
                    }
                }
                n5 = n6;
            }
            switch (n5) {
                case 0: {
                    iterable2 = ALLATORIxDEMO.getData(string).getChildByPath(PlayerRandomStream.ALLATORIxDEMO("\n\"?")).getChildren();
                    iterable = iterable2;
                    break;
                }
                case 1: {
                    ArrayList<MapleData> arrayList2 = iterable2;
                    iterable = arrayList2;
                    arrayList2.add(ALLATORIxDEMO.getData(string).getChildByPath(SkillType.ALLATORIxDEMO("vPP")));
                    break;
                }
                default: {
                    ArrayList<MapleData> arrayList3 = iterable2;
                    iterable = arrayList3;
                    arrayList3.add(ALLATORIxDEMO.getData(string));
                }
            }
            for (MapleData mapleData : iterable) {
                Object object = mapleData.getChildren().iterator();
                while (object.hasNext()) {
                    iterable2 = (MapleData)string.next();
                    object = string;
                    arrayList.add(new Pair<Integer, String>(Integer.parseInt(iterable2.getName()), MapleDataTool.getString(PlayerRandomStream.ALLATORIxDEMO("=.>*"), iterable2, SkillType.ALLATORIxDEMO("}k\u001ejriv"))));
                }
            }
            n4 = ++n2;
        }
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void delete(String a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 7[CATCHBLOCK]
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

    public /* synthetic */ MonsterDropCreator() {
        MonsterDropCreator a2;
    }

    private static /* synthetic */ void ALLATORIxDEMO() {
        System.out.println(PlayerRandomStream.ALLATORIxDEMO("\u8f46\u5136\u6065\u723a\u8c88\u65caa}a"));
        ArrayList<Pair<Integer, MobInfo>> arrayList = new ArrayList<Pair<Integer, MobInfo>>();
        MapleDataProvider mapleDataProvider = MapleDataProviderFactory.getDataProvider(SkillType.ALLATORIxDEMO("i\\F\u001dSI"));
        for (MapleData mapleData : ALLATORIxDEMO.getData(PlayerRandomStream.ALLATORIxDEMO("\u0002<-}&>(")).getChildren()) {
            try {
                int n2 = Integer.parseInt(mapleData.getName());
                MapleData mapleData2 = mapleDataProvider.getData(StringUtil.getLeftPaddedStr(Integer.toString(n2) + ".img", '0', 11));
                int n3 = MapleDataTool.getIntConvert(SkillType.ALLATORIxDEMO("F\\W@"), mapleData2.getChildByPath(PlayerRandomStream.ALLATORIxDEMO(":!5 ")), 0);
                if (n3 > 0) {
                    d.put(n2, Boolean.TRUE);
                }
                MobInfo mobInfo = new MobInfo(n3, MapleDataTool.getString(SkillType.ALLATORIxDEMO("JRIV"), mapleData, PlayerRandomStream.ALLATORIxDEMO("\u0001\u001cb\u001d\u000e\u001e\n")));
                arrayList.add(new Pair<Integer, MobInfo>(n2, mobInfo));
            }
            catch (Exception exception) {}
        }
        a.addAll(arrayList);
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void main(String[] a) throws Exception {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [12[DOLOOP]], but top level block is 16[UNCONDITIONALDOLOOP]
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

    private static /* synthetic */ String ALLATORIxDEMO(int a2) {
        for (Pair<Integer, String> pair : K) {
            if (pair.getLeft() != a2) continue;
            return pair.getRight();
        }
        return null;
    }

    public static class MobInfo {
        public final /* synthetic */ String name;
        public final /* synthetic */ int boss;

        public final /* synthetic */ String getName() {
            MobInfo a2;
            return a2.name;
        }

        public /* synthetic */ MobInfo(int a2, String a3) {
            MobInfo a4;
            MobInfo mobInfo = a4;
            mobInfo.boss = a2;
            mobInfo.name = a3;
        }

        public final /* synthetic */ int getBoss() {
            MobInfo a2;
            return a2.boss;
        }
    }
}

