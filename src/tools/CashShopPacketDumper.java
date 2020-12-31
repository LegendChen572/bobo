/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.messages.commands.player.eventSystem.BankSystem;
import database.DBConPool;
import handling.world.guild.MapleGuild;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import provider.MapleData;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.CashItem;
import server.MapleItemInformationProvider;
import tools.FileoutputUtil;
import tools.HexTool;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;

/*
 * Exception performing whole class analysis ignored.
 */
public class CashShopPacketDumper {
    private static /* synthetic */ boolean a;
    private static final /* synthetic */ HashMap<Integer, CashItem> d;
    private static /* synthetic */ boolean ALLATORIxDEMO;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void addItem(int a, String a, int a, int a, int a, int a, int a, int a, int a, int a, int a, int a, int a, int a, int a) {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void main(String[] a2) throws IOException {
        int n2;
        System.out.println(MapleGuild.ALLATORIxDEMO("j'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C\u000eC$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@'j'@$@$@$@$C'@'@$@'@$@$C'@'C'@'C'@'C$@'C'@$@$@$@$C\u000eC$@$@$@$C$C$C$@$C$@$C$C$@'@$C$C$C$C$@'@$@$@$@$@'j'@$@$@$@'C'@'@$@'@$@'C'@$C$@'@'@'C$@$C$@$@$@$@$C\u000eC$@$@$@$C$C$C'C$C'C$C$C$@'@$C'C$C$C$C'C$@$@$@$@'j'@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$C\u000eC$/f\u0006q\u0013g\u0001p\tk\u000e$\u0002}@E\fh\u0001p\u000fv\t$/f\u0006q\u0013g\u0001p\u000fv@rW*S$$A-K@'j'@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$C\u000eC$@$@$@$@$@$\bp\u0014tZ+Os\u0017sNe\fh\u0001p\u000fv\t*\u0003k\r$@$@$@$@$@$@'j'@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$@$C\u000eC'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'C'j"));
        MapleItemInformationProvider.getInstance().loadItems(false);
        Properties properties = new Properties();
        CashShopPacketDumper.deleteOldItems();
        System.out.println(BankSystem.ALLATORIxDEMO("\u3067\u8279\u5531\u57bd\u8cb0\u65ea\u525d\u9617\u5bfb\u7511\u3066"));
        Object object = new FileInputStream(MapleGuild.ALLATORIxDEMO("\u9b88\u9b5e\u8c57\u5542\u57ae\u5c05\u5365*\u0014|\u0014"));
        try {
            properties.load((InputStream)object);
        }
        catch (Throwable throwable) {
            Throwable throwable2;
            try {
                ((FileInputStream)object).close();
                throwable2 = throwable;
                throw throwable2;
            }
            catch (Throwable throwable3) {
                try {
                    Throwable throwable4 = throwable;
                    throwable2 = throwable4;
                    throwable4.addSuppressed(throwable3);
                    throw throwable2;
                }
                catch (IOException iOException) {
                    FileoutputUtil.outputFileError(BankSystem.ALLATORIxDEMO("\u001f\u0018\u0014\u0004\\2\u000b\u0014\u0016\u0007\u0007X0\u0016\u0000\u001f \u001f\u001c\u0007#\u0016\u0010\u001c\u0016\u00037\u0002\u001e\u0007\u0016\u0005]\u001b\u001c\u0010"), iOException);
                }
            }
        }
        ((FileInputStream)object).close();
        object = HexTool.getByteArrayFromHexString(properties.getProperty(MapleGuild.ALLATORIxDEMO("t\u0001g\u000b")));
        LittleEndianAccessor littleEndianAccessor = new LittleEndianAccessor(new ByteArrayByteStream((byte[])object));
        Object object2 = "";
        int n3 = littleEndianAccessor.readShort();
        byte by = 0;
        int n4 = n2 = 0;
        while (n4 < n3) {
            Object object3;
            String string;
            String string2;
            int n5;
            int n6;
            int n7 = 0;
            short s2 = 0;
            int n8 = 0;
            byte by2 = 0;
            byte by3 = -1;
            short s3 = 0;
            int n9 = 0;
            LittleEndianAccessor littleEndianAccessor2 = littleEndianAccessor;
            int n10 = littleEndianAccessor2.readInt();
            int n11 = littleEndianAccessor2.readInt();
            long l2 = littleEndianAccessor2.getBytesRead();
            if (n11 < 0) {
                if (!ALLATORIxDEMO) {
                    LittleEndianAccessor littleEndianAccessor3 = littleEndianAccessor;
                    littleEndianAccessor3.skip(1);
                    by = littleEndianAccessor3.readByte();
                    littleEndianAccessor3.skip(-2);
                    int n12 = n6 = 0;
                    while (n12 < ((Object)object).length) {
                        Object object4 = object;
                        int n13 = n6++;
                        object4[n13] = (byte)(object4[n13] ^ by);
                        n12 = n6;
                    }
                    ALLATORIxDEMO = true;
                }
                littleEndianAccessor = new LittleEndianAccessor(new ByteArrayByteStream((byte[])object));
                littleEndianAccessor.skip((int)l2 - 8);
                n10 = littleEndianAccessor.readInt();
                n11 = littleEndianAccessor.readInt();
            }
            n6 = 0;
            byte by4 = 0;
            byte by5 = 0;
            byte by6 = 0;
            byte by7 = 0;
            int n14 = 0;
            if ((n11 & 1) != 0) {
                n7 = littleEndianAccessor.readInt();
            }
            if ((n11 & 2) != 0) {
                s2 = littleEndianAccessor.readShort();
            }
            if ((n11 & 4) != 0) {
                n8 = littleEndianAccessor.readInt();
            }
            if ((n11 & 8) != 0) {
                by2 = (byte)(littleEndianAccessor.readByte() + 1);
            }
            if ((n11 & 0x10) != 0) {
                by3 = littleEndianAccessor.readByte();
            }
            if ((n11 & 0x20) != 0) {
                s3 = littleEndianAccessor.readShort();
            }
            if ((n11 & 0x40) != 0) {
                littleEndianAccessor.readInt();
            }
            if ((n11 & 0x80) != 0) {
                n9 = littleEndianAccessor.readInt();
            }
            if ((n11 & 0x100) != 0) {
                n6 = (byte)(littleEndianAccessor.readByte() + 1);
            }
            if ((n11 & 0x200) != 0) {
                by4 = littleEndianAccessor.readByte();
            }
            if ((n11 & 0x400) != 0) {
                by5 = littleEndianAccessor.readByte();
            }
            if ((n11 & 0x800) != 0) {
                by6 = littleEndianAccessor.readByte();
            }
            if ((n11 & 0x1000) != 0) {
                by7 = (byte)(littleEndianAccessor.readByte() + 1);
            }
            if ((n11 & 0x2000) != 0) {
                littleEndianAccessor.readShort();
            }
            if ((n11 & 0x4000) != 0) {
                littleEndianAccessor.readShort();
            }
            if ((n11 & 0x8000) != 0) {
                littleEndianAccessor.readShort();
            }
            if ((n11 & 0x10000) != 0) {
                n14 = 1;
                int n15 = littleEndianAccessor.readByte();
                int n16 = n15;
                n5 = n15;
                while (n16 > 0) {
                    littleEndianAccessor.readInt();
                    n16 = --n5;
                }
            }
            n5 = CashShopPacketDumper.H(n10);
            if (n7 > 0) {
                string2 = MapleItemInformationProvider.getInstance().getName(n7);
            } else {
                if (!a) {
                    CashShopPacketDumper.ALLATORIxDEMO();
                }
                int n17 = CashShopPacketDumper.H(n10);
                string2 = MapleItemInformationProvider.getInstance().getName(n17);
            }
            if (string2 == null) {
                string = "";
            }
            if (n7 > 0 && s2 == 0) {
                s2 = 1;
            }
            if (n5 == n7 && n7 > 0) {
                n7 = 0;
            }
            if (n8 <= 0) {
                n8 = CashShopPacketDumper.ALLATORIxDEMO(n10);
            }
            if (n11 < 5000 && n11 > 2000) {
                CashShopPacketDumper.addItem(n10, string, n8, by6, by5, n7, by3, n14, s3, by4, s2, n9, by2, n6, by7);
                object3 = object2;
            } else {
                System.err.println("flags\u503c\u7570\u5e38:" + n11 + " ,\u5df2\u79fb\u9664\u3002");
                object3 = object2;
            }
            object2 = (String)object3 + "NAME:" + string + " SN: " + n10 + " FLAGS: " + n11 + " ITEM: " + n7 + " count: " + s2 + " discountPrice: " + n8 + " unk_1: " + by2 + " priority: " + by3 + " period: " + s3 + " meso: " + n9 + " gender: " + by4 + " showup: " + by5 + " mark: " + by6 + " unk_3: " + by7 + "\r\n";
            System.out.println("NAME:" + string + " SN: " + n10 + " FLAGS: " + n11 + " ITEM: " + n7 + " count: " + s2 + " discountPrice: " + n8 + " unk_1: " + by2 + " priority: " + by3 + " period: " + s3 + " meso: " + n9 + " gender: " + by4 + " showup: " + by5 + " mark: " + by6 + " unk_3: " + by7);
            n4 = ++n2;
        }
        object2 = (String)object2 + "-----------------" + n3 + " in total";
        System.out.println("-----------------" + n3 + "\u500b");
        if (littleEndianAccessor.available() > 0L) {
            object2 = (String)object2 + "\r\nnow: " + littleEndianAccessor.toString();
        }
        FileoutputUtil.log(BankSystem.ALLATORIxDEMO("0\u0016\u0000\u001f \u001f\u001c\u0007]\u0003\u000b\u0003"), (String)object2);
    }

    private static /* synthetic */ int H(int a2) {
        int n2 = -1;
        if (d.containsKey(a2)) {
            n2 = d.get(a2).getId();
        }
        return n2;
    }

    public /* synthetic */ CashShopPacketDumper() {
        CashShopPacketDumper a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void deleteOldItems() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        var1_2 = MapleGuild.ALLATORIxDEMO("`\u0005h\u0005p\u0005$\u0006v\u000fi@g\u0001w\bw\bk\u0010[\tp\u0005i\u0013");
        var1_2 = var0.prepareStatement(BankSystem.ALLATORIxDEMO("\u0017\u0012\u001f\u0012\u0007\u0012S\u0011\u0001\u0018\u001eW\u0010\u0016\u0000\u001f\u0000\u001f\u001c\u0007,\u001e\u0007\u0012\u001e\u0004"));
        try {
            var1_2.executeUpdate();
            ** if (var1_2 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_2 == null) ** GOTO lbl22
            try {
                var1_2.close();
                v0 = var2_4;
                ** GOTO lbl23
            }
            catch (Throwable var1_3) {
                try {
                    var2_4.addSuppressed(var1_3);
lbl22:
                    // 2 sources

                    v0 = var2_4;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    System.err.println(var0_1);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_2.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    private static /* synthetic */ int ALLATORIxDEMO(int a2) {
        int n2 = -1;
        if (d.containsKey(a2)) {
            n2 = d.get(a2).getPrice();
        }
        return n2;
    }

    public static /* synthetic */ {
        a = false;
        d = new HashMap();
        ALLATORIxDEMO = false;
    }

    private static /* synthetic */ void ALLATORIxDEMO() {
        if (!a) {
            for (MapleData mapleData : MapleDataProviderFactory.getDataProvider(BankSystem.ALLATORIxDEMO("X6\u0003\u0010Y\u0004\r")).getData(MapleGuild.ALLATORIxDEMO("#k\ri\u000f`\tp\u0019*\ti\u0007")).getChildren()) {
                int n2 = MapleDataTool.getIntConvert(BankSystem.ALLATORIxDEMO(" 9"), mapleData, 0);
                CashItem object = new CashItem(n2, MapleDataTool.getIntConvert(MapleGuild.ALLATORIxDEMO("M\u0014a\rM\u0004"), mapleData, 0), MapleDataTool.getIntConvert(BankSystem.ALLATORIxDEMO("4\u001c\u0002\u001d\u0003"), mapleData, 1), MapleDataTool.getIntConvert(MapleGuild.ALLATORIxDEMO("0v\tg\u0005"), mapleData, 0), MapleDataTool.getIntConvert(BankSystem.ALLATORIxDEMO("#\u0012\u0001\u001e\u001c\u0013"), mapleData, 0), MapleDataTool.getIntConvert(MapleGuild.ALLATORIxDEMO("C\u0005j\u0004a\u0012"), mapleData, 2), MapleDataTool.getIntConvert(BankSystem.ALLATORIxDEMO("4\u001f\u0016\u0000\u0004"), mapleData, -1), MapleDataTool.getIntConvert(MapleGuild.ALLATORIxDEMO("C\u0001w\bk\u000eh\u0019"), mapleData, 0) > 0, MapleDataTool.getIntConvert(BankSystem.ALLATORIxDEMO("<\u0019 \u0016\u001f\u0012"), mapleData, 0) > 0 && MapleDataTool.getIntConvert(MapleGuild.ALLATORIxDEMO("0v\tg\u0005"), mapleData, 0) > 0, false);
                if (n2 <= 0) continue;
                d.put(n2, object);
            }
            a = true;
        }
    }
}

