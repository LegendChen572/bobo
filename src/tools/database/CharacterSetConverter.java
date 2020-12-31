/*
 * Decompiled with CFR 0.150.
 */
package tools.database;

import client.inventory.MapleRing;
import database.DBConPool;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.characterCards.MapleCharacterCards;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.JsonMapConverter;
import tools.Pair;

public class CharacterSetConverter {
    private static /* synthetic */ List<Pair<Integer, Map<String, Long>>> ALLATORIxDEMO;
    private static /* synthetic */ List<Pair<Integer, Map<String, Long>>> d;

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void addDatabase() {
        var0 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var1_2 = null;
            var1_2 = var0.prepareStatement(MapleRing.ALLATORIxDEMO("\u001fH\u0019[\b_|N\u001dX\u0010_|z?r.E6i3t<:t\u0010|:<s8z|s2nt+m3|T\u0013N|T\tV\u00106V:|z6i3t<:(\u007f$n|Y\u0014[\u000e[\u001fN\u0019H|I\u0019N|o(|dw>.|T\u0013N|T\tV\u0010\u0010u:\u0019T\u001bS\u0012_aS2t3^\u001e:\u0018_\u001a[\tV\b:\u001fR\u001dH\u000f_\b'0{(s2+g"));
            var1_2.execute();
            var1_2.close();
            var1_2 = var0.prepareStatement(MapleCharacterCards.ALLATORIxDEMO("\u0015@\u0000I\u0006,\u0000M\u0016@\u0011,4o<~\u000bf'c:l^,tM\u0010Ht\\\u0006E\u0019M\u0006UtG\u0011Ut$4e0l}7"));
            var1_2.execute();
            var1_2.close();
            var1_2 = var0.prepareStatement(MapleRing.ALLATORIxDEMO("\u001dV\b_\u000e:\b[\u001eV\u0019:<y4h\u0003p/u2zV:|W\u0013^\u0015\\\u0005:<s8z|s2nt+m3|T\u0013N|T\tV\u0010:\u001dO\bU\u0003S\u0012Y\u000e_\u0011_\u0012Ng"));
            var1_2.execute();
            var1_2.close();
            var1_2 = var0.prepareStatement(MapleCharacterCards.ALLATORIxDEMO("O\u0006I\u0015X\u0011,\u0000M\u0016@\u0011,4m7o\u000bf'c:lt$^,tl=h4,=b $e=},\u001aC\u0000,\u001aY\u0018@x\u0006t,4f'c:ltx1t ,\u0017D\u0015^\u0015O\u0000I\u0006,\u0007I\u0000,!x249n`,\u001aC\u0000,\u001aY\u0018@^%tI\u001aK\u001dB\u00111\u001db:c\u0010NtH\u0011J\u0015Y\u0018XtO\u001cM\u0006_\u0011Xi`5x=be7"));
            var1_2.execute();
            var1_2.close();
            var1_2 = var0.prepareStatement(MapleRing.ALLATORIxDEMO("[\u0010N\u0019H|N\u001dX\u0010_|z=y?E6i3t<\u0010|:\u001d^\u0018:\fH\u0015W\u001dH\u0005:\u0017_\u0005:tz5~<3g"));
            var1_2.execute();
            var1_2.close();
            var1_2 = var0.prepareStatement(MapleCharacterCards.ALLATORIxDEMO("M\u0018X\u0011^tX\u0015N\u0018Itl5o7S>\u007f;b4\u0006t,\u0019C\u0010E\u0012Utl=h4,=b $e=},\u001aC\u0000,\u001aY\u0018@tM\u0001X\u001bS\u001dB\u0017^\u0011A\u0011B\u00007"));
            var1_2.execute();
            var1_2.close();
            var1_2 = var0.prepareStatement(MapleRing.ALLATORIxDEMO("\u0018H\u0013J|N\u001dX\u0010_|z?r=h=y(\u007f.i\u0003p/u2zg"));
            var1_2.execute();
            var1_2.close();
            ** if (var0 == null) goto lbl-1000
        }
        catch (Throwable var1_3) {
            if (var0 == null) ** GOTO lbl47
            try {
                var0.close();
                v0 = var1_3;
                ** GOTO lbl48
            }
            catch (Throwable var2_4) {
                try {
                    var1_3.addSuppressed(var2_4);
lbl47:
                    // 2 sources

                    v0 = var1_3;
lbl48:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var0_1) {
                    var0_1.printStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var0.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public static /* synthetic */ {
        d = new LinkedList<Pair<Integer, Map<String, Long>>>();
        ALLATORIxDEMO = new LinkedList<Pair<Integer, Map<String, Long>>>();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void convert() {
        block39: {
            block41: {
                block40: {
                    block38: {
                        try {
                            var0 = DBConPool.getInstance().getDataSource().getConnection();
                            var1_2 = null;
                            var2_9 = MapleCharacterCards.ALLATORIxDEMO("\u007f1`1o &2~;ato<m&m7x1~'S>\u007f;b");
                            var1_3 = var0.prepareStatement(var2_9);
                            var3_13 = var1_3.executeQuery();
lbl8:
                            // 4 sources

                            while (true) {
                                try {
                                    if (!var3_13.next()) ** GOTO lbl63
                                    v0 = var3_13;
                                    var4_16 = v0.getInt(MapleRing.ALLATORIxDEMO("?r=h=y(\u007f.s8"));
                                    var5_20 = v0.getString(MapleCharacterCards.ALLATORIxDEMO("2y:o e;b"));
                                    if (var5_20.equals(MapleRing.ALLATORIxDEMO("Y4{.{?n9h\u000f\u007f("))) {
                                        var6_22 = JsonMapConverter.JsonToMapLong(var3_13.getString(MapleCharacterCards.ALLATORIxDEMO(">\u007f;b")));
                                        var7_23 = new HashMap<String, Long>();
                                        for (Map.Entry<String, Long> var9_25 : var6_22.entrySet()) {
                                            if (var9_25.getKey().contains(MapleRing.ALLATORIxDEMO("\u65ff\u8a54")) && !var9_25.getKey().contains(FileoutputUtil.NowDay())) continue;
                                            var7_23.put(var9_25.getKey(), var9_25.getValue());
                                        }
                                        break block38;
                                    }
                                    ** GOTO lbl-1000
                                }
                                catch (Throwable var4_17) {
                                    if (var3_13 != null) {
                                        try {
                                            var3_13.close();
                                            v1 = var4_17;
                                            throw v1;
                                        }
                                        catch (Throwable var5_21) {
                                            var4_17.addSuppressed(var5_21);
                                        }
                                    }
                                    v1 = var4_17;
                                    throw v1;
                                }
                                break;
                            }
                        }
                        catch (SQLException var0_1) {
                            System.out.println(var0_1);
                            FilePrinter.printError(MapleRing.ALLATORIxDEMO(";\u007f(|)t?n5u24(b("), var0_1);
                            break block39;
                        }
                        catch (Throwable var1_4) {
                            if (var0 != null) {
                                try {
                                    var0.close();
                                    v2 = var1_4;
                                    throw v2;
                                }
                                catch (Throwable var2_10) {
                                    var1_4.addSuppressed(var2_10);
                                }
                            }
                            v2 = var1_4;
                            throw v2;
                        }
                    }
                    CharacterSetConverter.d.add(new Pair<Integer, HashMap<K, V>>(var4_16, var7_23));
                    ** GOTO lbl8
lbl-1000:
                    // 1 sources

                    {
                        if (!var5_20.equals(MapleCharacterCards.ALLATORIxDEMO("\u0017d5~5o i&_1x\u000bM7o"))) ** GOTO lbl8
                        var6_22 = JsonMapConverter.JsonToMapLong(var3_13.getString(MapleRing.ALLATORIxDEMO("p/u2")));
                        var7_23 = new HashMap<K, V>();
                        for (Map.Entry<String, Long> var9_25 : var6_22.entrySet()) {
                            if (var9_25.getKey().contains(MapleCharacterCards.ALLATORIxDEMO("\u65b1\u8a04")) && !var9_25.getKey().contains(FileoutputUtil.NowDay())) continue;
                            var7_23.put(var9_25.getKey(), var9_25.getValue());
                        }
                        CharacterSetConverter.ALLATORIxDEMO.add(new Pair<Integer, HashMap<K, V>>(var4_16, var7_23));
                        ** continue;
lbl63:
                        // 1 sources

                        var3_13.close();
                        if (var3_13 == null) break block40;
                        v3 = var1_3;
                    }
                    var3_13.close();
                    break block41;
                }
                v3 = var1_3;
            }
            v3.close();
            if (var0 != null) {
                var0.close();
            }
        }
        CharacterSetConverter.addDatabase();
        if (!CharacterSetConverter.d.isEmpty() || !CharacterSetConverter.ALLATORIxDEMO.isEmpty()) {
            for (Pair var1_6 : CharacterSetConverter.d) {
                try {
                    var2_9 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        var3_13 = null;
                        var3_13 = var2_9.prepareStatement(MapleCharacterCards.ALLATORIxDEMO("\u001dB\u0007I\u0006XtE\u001aX\u001b,7d&S>\u007f;bt$4e0lx,4f'c:l},\u0002M\u0018Y\u0011_t$k k%"));
                        var3_13.setInt(1, (Integer)var1_6.getLeft());
                        var3_13.setString(2, JsonMapConverter.MapToJsonLong((Map)var1_6.getRight()));
                        v4 = var3_13;
                        v4.execute();
                        v4.close();
                        if (var2_9 == null) continue;
                    }
                    catch (Throwable var3_14) {
                        if (var2_9 != null) {
                            try {
                                var2_9.close();
                                v5 = var3_14;
                                throw v5;
                            }
                            catch (Throwable var4_18) {
                                var3_14.addSuppressed(var4_18);
                            }
                        }
                        v5 = var3_14;
                        throw v5;
                    }
                    var2_9.close();
                }
                catch (SQLException var2_11) {
                    FilePrinter.printError(MapleRing.ALLATORIxDEMO("i=l9Y4{.{?n9h\u000f\u007f(4(b("), var2_11, MapleCharacterCards.ALLATORIxDEMO("\u000f\u007f5z1O<m&m7x1~\u0007i Q"));
                }
            }
            for (Pair var1_8 : CharacterSetConverter.ALLATORIxDEMO) {
                try {
                    var2_9 = DBConPool.getInstance().getDataSource().getConnection();
                    try {
                        var3_13 = null;
                        var3_13 = var2_9.prepareStatement(MapleRing.ALLATORIxDEMO("S\u0012I\u0019H\b:\u0015T\bU|{?y\u0003p/u2:tz5~<6|z6i3t<3|L\u001dV\t_\u000f:t%p%u"));
                        var3_13.setInt(1, (Integer)var1_8.getLeft());
                        var3_13.setString(2, JsonMapConverter.MapToJsonLong((Map)var1_8.getRight()));
                        v6 = var3_13;
                        v6.execute();
                        v6.close();
                        if (var2_9 == null) continue;
                    }
                    catch (Throwable var3_15) {
                        if (var2_9 != null) {
                            try {
                                var2_9.close();
                                v7 = var3_15;
                                throw v7;
                            }
                            catch (Throwable var4_19) {
                                var3_15.addSuppressed(var4_19);
                            }
                        }
                        v7 = var3_15;
                        throw v7;
                    }
                    var2_9.close();
                }
                catch (SQLException var2_12) {
                    FilePrinter.printError(MapleCharacterCards.ALLATORIxDEMO("'m\"i\u0017d5~5o i&_1xzx,x"), var2_12, MapleRing.ALLATORIxDEMO("A/{*\u007f\u001fr=h=y(\u007f.I9n\u0001"));
                }
            }
        }
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u8f1d\u63d7\u5bd8\u756eu\u4f6c\u53bb\u4ee9\u95df\u6701\u4ed2-"));
    }

    public /* synthetic */ CharacterSetConverter() {
        CharacterSetConverter a2;
    }
}

