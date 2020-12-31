/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.messages.commands.PlayerCommand;
import client.messages.commands.player.eventSystem.BankSystem;
import constants.ItemConstants;
import database.DBConPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import server.Randomizer;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleCoreAura {
    private /* synthetic */ int g;
    private /* synthetic */ long d;
    private /* synthetic */ int k;
    private /* synthetic */ int H;
    private /* synthetic */ int e;
    private /* synthetic */ int C;
    private /* synthetic */ int E;
    private /* synthetic */ int a;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int K;
    private /* synthetic */ int B;

    public /* synthetic */ int getId() {
        MapleCoreAura a2;
        return a2.C;
    }

    public /* synthetic */ MapleCoreAura(int a2) {
        MapleCoreAura a3;
        a3.C = a2;
    }

    public /* synthetic */ void randomCoreAura(int a2) {
        MapleCoreAura a3;
        int n2 = Randomizer.nextBoolean() ? (a2 == 4 ? 32 : (a2 == 3 ? 25 : (a2 == 2 ? 20 : 15))) : (a2 == 4 ? 25 : (a2 == 3 ? 20 : (a2 == 2 ? 15 : 10)));
        a2 = Randomizer.nextBoolean() ? 5 : 1;
        MapleCoreAura mapleCoreAura = a3;
        int n3 = a2;
        a3.E = Randomizer.rand(a2, n2);
        a3.g = Randomizer.rand(n3, n2);
        mapleCoreAura.B = Randomizer.rand(n3, n2);
        mapleCoreAura.k = Randomizer.rand(a2, n2);
        a3.K = Randomizer.nextInt(1000) == 1 ? Randomizer.rand(10, 32) : (Randomizer.nextInt(500) == 1 ? Randomizer.rand(10, 25) : (Randomizer.nextInt(200) == 1 ? Randomizer.rand(5, 20) : (Randomizer.nextInt(100) == 1 ? Randomizer.rand(5, 15) : Randomizer.rand(0, 15))));
        if (Randomizer.nextInt(1000) == 1) {
            a3.a = Randomizer.rand(10, 32);
            return;
        }
        if (Randomizer.nextInt(500) == 1) {
            a3.a = Randomizer.rand(10, 25);
            return;
        }
        if (Randomizer.nextInt(200) == 1) {
            a3.a = Randomizer.rand(5, 20);
            return;
        }
        if (Randomizer.nextInt(100) == 1) {
            a3.a = Randomizer.rand(5, 15);
            return;
        }
        a3.a = Randomizer.rand(0, 15);
    }

    public /* synthetic */ int getStr() {
        MapleCoreAura a2;
        return a2.E;
    }

    public /* synthetic */ boolean getDelay() {
        MapleCoreAura a2;
        return a2.ALLATORIxDEMO;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ MapleCoreAura createCoreAura(int a, int a) {
        var2_2 = new MapleCoreAura(a, a);
        try {
            block11: {
                block10: {
                    var3_3 = DBConPool.getInstance().getDataSource().getConnection();
                    var4_5 = var3_3.prepareStatement(PlayerCommand.ALLATORIxDEMO("]!B!M0.N.\"\\+CDm\fo\u0016o\u0007z\u0001|;m\u000b|\u0001o\u0011|\u0005}DY,K6KDm\fo\u0016o\u0007z\u0001|\rjD3D1"));
                    var4_5.setInt(1, a);
                    var5_7 = var4_5.executeQuery();
                    if (!var5_7.next()) break block10;
                    var4_5.close();
                    var5_7.close();
                    var6_9 = var2_2 = MapleCoreAura.loadFromDb(a, a);
                    if (var3_3 == null) return var6_9;
                    {
                        catch (Throwable var4_6) {
                            if (var3_3 != null) {
                                try {
                                    var3_3.close();
                                    v0 = var4_6;
                                    throw v0;
                                }
                                catch (Throwable var5_8) {
                                    var4_6.addSuppressed(var5_8);
                                }
                            }
                            v0 = var4_6;
                            throw v0;
                        }
                    }
                    var3_3.close();
                    return var6_9;
                }
                var4_5.close();
                var5_7.close();
                var2_2.resetCoreAura();
                v1 = var4_5 = var3_3.prepareStatement(BankSystem.ALLATORIxDEMO(":9 2!#S>=#<W\u0013\u0014\u001b\u0016\u0001\u0016\u0010\u0003\u0016\u0005,\u0014\u001c\u0005\u0016\u0016\u0006\u0005\u0012\u0004\u0013W[\u0017\u0010\u001f\u0012\u0005\u0012\u0014\u0007\u0012\u0001\u001e\u0017\u0017_W\u0013\u001b\u0016\u0001\u0016\u001b\u0013[S\u0017\u0010\u0018\u0001\u0012\u001f\u0012\u0005\u0012\u001f\u0017_W\u0013\u0004\u0007\u0005\u0013[S\u0017\u0017\u0012\u000b\u0017_W\u0013\u001e\u001d\u0003\u0013[S\u0017\u001f\u0002\u0018\u0017_W\u0013\u0000\u0012\u0003\u0018\u0017_W\u0013\u001a\u0012\u0010\u001a\u0014\u0013[S\u0017\u0017\u0012\u001f\u0016\n\u0017_W\u0013\u0012\u000b\u0007\u001a\u0005\u0016\u0013\u0012\u0003\u0016\u0017ZW%6?\"6$S_L[SH_WL[SH_WL[SH_WL[SH_WL[SH_WL^"));
                v2 = var4_5;
                v3 = var4_5;
                v4 = var4_5;
                v5 = var4_5;
                v5.setInt(1, a);
                v5.setInt(2, a);
                v4.setInt(3, var2_2.getCoreLevel());
                v4.setInt(4, var2_2.getStr());
                v3.setInt(5, var2_2.getDex());
                v3.setInt(6, var2_2.getInt());
                v2.setInt(7, var2_2.getLuk());
                v2.setInt(8, var2_2.getWatk());
                v1.setInt(9, var2_2.getMagic());
                if (!var2_2.getDelay()) break block11;
                v6 = 1;
                ** GOTO lbl50
            }
            v6 = 0;
lbl50:
            // 2 sources

            v1.setInt(10, v6);
            v7 = var4_5;
            v7.setLong(11, var2_2.getExpiration());
            v7.executeUpdate();
            v7.close();
            if (var3_3 == null) return var2_2;
            var3_3.close();
            return var2_2;
        }
        catch (SQLException var3_4) {
            System.err.println("\u5275\u5efa\u9f8d\u7684\u50b3\u4eba\u5bf6\u76d2\u4fe1\u606f\u51fa\u932f " + var3_4);
            return null;
        }
    }

    public /* synthetic */ MapleCoreAura(int a2, long a3) {
        MapleCoreAura a4;
        MapleCoreAura mapleCoreAura = a4;
        mapleCoreAura.C = a2;
        mapleCoreAura.d = a3;
    }

    public /* synthetic */ int getLevel() {
        MapleCoreAura a2;
        return a2.H;
    }

    public /* synthetic */ int getWatk() {
        MapleCoreAura a2;
        return a2.K;
    }

    public /* synthetic */ void setStr(int a2) {
        a.E = a2;
    }

    public /* synthetic */ int getDex() {
        MapleCoreAura a2;
        return a2.g;
    }

    public /* synthetic */ void setInt(int a2) {
        a.B = a2;
    }

    public /* synthetic */ long getExpiration() {
        MapleCoreAura a2;
        return a2.d;
    }

    public static /* synthetic */ MapleCoreAura loadFromDb(int a2) {
        return MapleCoreAura.loadFromDb(a2, -1);
    }

    public /* synthetic */ MapleCoreAura(int a2, int a3) {
        MapleCoreAura a4;
        MapleCoreAura mapleCoreAura = a4;
        mapleCoreAura.C = a2;
        mapleCoreAura.H = a3;
    }

    public /* synthetic */ void resetCoreAura() {
        MapleCoreAura a2;
        MapleCoreAura mapleCoreAura = a2;
        MapleCoreAura mapleCoreAura2 = a2;
        MapleCoreAura mapleCoreAura3 = a2;
        MapleCoreAura mapleCoreAura4 = a2;
        mapleCoreAura4.E = 5;
        mapleCoreAura4.g = 5;
        mapleCoreAura3.B = 5;
        mapleCoreAura3.k = 5;
        mapleCoreAura2.K = 0;
        mapleCoreAura2.a = 0;
        mapleCoreAura.e = 3;
        mapleCoreAura.ALLATORIxDEMO = false;
        mapleCoreAura.d = System.currentTimeMillis() + 86400000L;
    }

    public /* synthetic */ void upgradeCoreAura(int a2) {
        MapleCoreAura a3;
        MapleCoreAura mapleCoreAura = a3;
        mapleCoreAura.e = mapleCoreAura.calcCoreLevel(a2);
        a2 = ItemConstants.getCoreMinByLevel(mapleCoreAura.e);
        int n2 = ItemConstants.getCoreMaxByLevel(mapleCoreAura.e);
        mapleCoreAura.E = Randomizer.rand(a2, n2);
        mapleCoreAura.g = Randomizer.rand(a2, n2);
        mapleCoreAura.B = Randomizer.rand(a2, n2);
        mapleCoreAura.k = Randomizer.rand(a2, n2);
        mapleCoreAura.K = Randomizer.rand(a2, n2);
        mapleCoreAura.a = Randomizer.rand(a2, n2);
        mapleCoreAura.d = System.currentTimeMillis() + 86400000L;
        mapleCoreAura.ALLATORIxDEMO = mapleCoreAura.getDelay();
    }

    public /* synthetic */ void setDelay(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getLuk() {
        MapleCoreAura a2;
        return a2.k;
    }

    public /* synthetic */ void setMagic(int a2) {
        a.a = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ MapleCoreAura loadFromDb(int a, int a) {
        block14: {
            block15: {
                try {
                    block17: {
                        block13: {
                            var2_4 = DBConPool.getInstance().getDataSource().getConnection();
                            var3_6 = new MapleCoreAura(a);
                            var4_8 = var2_4.prepareStatement(BankSystem.ALLATORIxDEMO("$6;64'WYW5%<:S\u0014\u001b\u0016\u0001\u0016\u0010\u0003\u0016\u0005,\u0014\u001c\u0005\u0016\u0016\u0006\u0005\u0012\u0004S ;2!2S\u0014\u001b\u0016\u0001\u0016\u0010\u0003\u0016\u0005\u001a\u0013SJSH"));
                            var4_8.setInt(1, a);
                            var5_10 = var4_8.executeQuery();
                            if (var5_10.next()) break block13;
                            var5_10.close();
                            var4_8.close();
                            var6_11 = null;
                            if (var2_4 == null) return var6_11;
                            {
                                catch (Throwable var3_7) {
                                    if (var2_4 != null) {
                                        try {
                                            var2_4.close();
                                            v0 = var3_7;
                                            throw v0;
                                        }
                                        catch (Throwable var4_9) {
                                            var3_7.addSuppressed(var4_9);
                                        }
                                    }
                                    v0 = var3_7;
                                    throw v0;
                                }
                            }
                            var2_4.close();
                            return var6_11;
                        }
                        if (a <= 0) break block17;
                        v1 = a;
                        ** GOTO lbl33
                    }
                    v1 = var5_10.getInt(PlayerCommand.ALLATORIxDEMO("b\u0001x\u0001b"));
lbl33:
                    // 2 sources

                    var3_6.setLevel(v1);
                    var6_12 = var5_10.getLong(BankSystem.ALLATORIxDEMO("\u0016\u000f\u0003\u001e\u0001\u0012\u0017\u0016\u0007\u0012"));
                    v2 = var3_6;
                    if (System.currentTimeMillis() > var6_12) {
                        v2.resetCoreAura();
                        v3 = var5_10;
                        var3_6.saveToDb((Connection)var2_4);
                        break block14;
                    }
                    v2.setCoreLevel(var5_10.getInt(PlayerCommand.ALLATORIxDEMO("m\u000b|\u0001b\u0001x\u0001b")));
                    v4 = var3_6;
                    v5 = var5_10;
                    v6 = var3_6;
                    v7 = var5_10;
                    var3_6.setStr(var5_10.getInt(BankSystem.ALLATORIxDEMO("\u0004\u0007\u0005")));
                    var3_6.setDex(v7.getInt(PlayerCommand.ALLATORIxDEMO("j\u0001v")));
                    v6.setInt(v7.getInt(BankSystem.ALLATORIxDEMO("\u001e\u001d\u0003")));
                    v6.setLuk(var5_10.getInt(PlayerCommand.ALLATORIxDEMO("b\u0011e")));
                    var3_6.setWatk(v5.getInt(BankSystem.ALLATORIxDEMO("\u0004\u0016\u0007\u001c")));
                    v4.setMagic(v5.getInt(PlayerCommand.ALLATORIxDEMO("c\u0005i\rm")));
                    v4.setDelay(var5_10.getInt(BankSystem.ALLATORIxDEMO("\u0013\u0016\u001b\u0012\u000e")) > 0);
                    v8 = var3_6;
                    v8.setExpiration(var6_12);
                    if (v8.getCoreLevel() != 1) break block15;
                    a = new ArrayList<Integer>();
                    v9 = a.add(var3_6.getStr());
                    v10 = a;
                    a.add(var3_6.getDex());
                    v10.add(var3_6.getInt());
                    a.add(var3_6.getLuk());
                    a.add(var3_6.getWatk());
                    a.add(var3_6.getMagic());
                    var6_13 = (Integer)Collections.max(v10);
                    v11 = var7_14 = 15;
                }
                catch (SQLException var2_5) {
                    System.err.println("\u52a0\u8f09\u9f8d\u7684\u50b3\u4eba\u5bf6\u76d2\u4fe1\u606f\u51fa\u932f" + var2_5);
                    return null;
                }
                while (v11 > 0) {
                    if (var6_13 >= ItemConstants.getCoreMaxByLevel(var7_14)) {
                        v3 = var5_10;
                        var3_6.setCoreLevel(var7_14 + 1);
                        break block14;
                    }
                    v11 = --var7_14;
                }
            }
            v3 = var5_10;
        }
        v3.close();
        var4_8.close();
        a = var3_6;
        if (var2_4 == null) return a;
        var2_4.close();
        return a;
    }

    public /* synthetic */ void setLuk(int a2) {
        a.k = a2;
    }

    public /* synthetic */ int calcCoreLevel(int a2) {
        MapleCoreAura a3;
        if (a3.H >= 30 && a3.H < 40) {
            return 1;
        }
        if (a3.H >= 40 && a3.H < 50) {
            return 2;
        }
        if (a3.H >= 50 && a3.H < 60) {
            return 3;
        }
        if (a3.H >= 60 && a3.H < 70) {
            return 4;
        }
        if (a3.H >= 70 && a3.H < 80) {
            return 5;
        }
        if (a3.H >= 80 && a3.H < 90) {
            return 6;
        }
        if (a3.H >= 90 && a3.H < 100) {
            return 7;
        }
        if (a3.H >= 100 && a3.H < 110) {
            return 8;
        }
        if (a3.H >= 110 && a3.H < 120) {
            return 9;
        }
        if (a3.H < 120) {
            return 1;
        }
        if (a2 == 5771002) {
            return 15;
        }
        if (a2 == 5771001) {
            return Randomizer.rand(a3.e, 15);
        }
        return (int)(Math.random() * 6.0) + 10;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4;
        int cfr_ignored_0 = 1 << 3 ^ 4;
        int n5 = n3;
        int n6 = 1 << 3 ^ 4;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ void setExpiration(long a2) {
        a.d = a2;
    }

    public /* synthetic */ int getInt() {
        MapleCoreAura a2;
        return a2.B;
    }

    public /* synthetic */ void setDex(int a2) {
        a.g = a2;
    }

    public /* synthetic */ int getCoreLevel() {
        MapleCoreAura a2;
        return a2.e;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void saveToDb(Connection a2) throws SQLException {
        boolean bl = false;
        try {
            MapleCoreAura a3;
            PreparedStatement preparedStatement;
            if (a2 == null) {
                bl = true;
                a2 = DBConPool.getInstance().getDataSource().getConnection();
            }
            PreparedStatement preparedStatement2 = preparedStatement = a2.prepareStatement(PlayerCommand.ALLATORIxDEMO("[4J%Z!.\u0004m\fo\u0016o\u0007z\u0001|;m\u000b|\u0001o\u0011|\u0005}\u0004.7K0.\u0004b\u0001x\u0001b\u0004.Y.[\"Dn\u0007a\u0016k\bk\u0012k\bnD3D1H.\u0004}\u0010|\u0004.Y.[\"Dn\u0000k\u001cnD3D1H.\u0004g\nz\u0004.Y.[\"Dn\b{\u000fnD3D1H.\u0004y\u0005z\u000fnD3D1H.\u0004c\u0005i\rm\u0004.Y.[\"Dn\u0000k\bo\u001dnD3D1H.\u0004k\u001c~\r|\u0001j\u0005z\u0001nD3D1DY,K6KDn\u0007f\u0005|\u0005m\u0010k\u0016g\u0000nD3D1"));
            PreparedStatement preparedStatement3 = preparedStatement;
            PreparedStatement preparedStatement4 = preparedStatement;
            PreparedStatement preparedStatement5 = preparedStatement;
            preparedStatement.setInt(1, a3.H);
            preparedStatement5.setInt(2, a3.e);
            preparedStatement5.setInt(3, a3.E);
            preparedStatement4.setInt(4, a3.g);
            preparedStatement4.setInt(5, a3.B);
            preparedStatement3.setInt(6, a3.k);
            preparedStatement3.setInt(7, a3.K);
            preparedStatement2.setInt(8, a3.a);
            preparedStatement2.setInt(9, a3.ALLATORIxDEMO ? 1 : 0);
            PreparedStatement preparedStatement6 = preparedStatement;
            PreparedStatement preparedStatement7 = preparedStatement;
            preparedStatement7.setLong(10, a3.d);
            preparedStatement6.setInt(11, a3.C);
            preparedStatement7.executeUpdate();
            preparedStatement6.close();
            if (a2 == null || !bl) return;
        }
        catch (Exception exception) {
            System.err.println("\u4fdd\u5b58\u9f8d\u7684\u50b3\u4eba\u5bf6\u76d2\u51fa\u932f" + exception);
            return;
        }
        finally {
            if (a2 == null || !bl) return;
            a2.close();
        }
        a2.close();
        return;
    }

    public /* synthetic */ void setCoreLevel(int a2) {
        a.e = a2;
    }

    public /* synthetic */ void setLevel(int a2) {
        a.H = a2;
    }

    public /* synthetic */ int getTotal() {
        MapleCoreAura a2;
        MapleCoreAura mapleCoreAura = a2;
        return mapleCoreAura.E + mapleCoreAura.g + a2.B + a2.k + a2.K + a2.a;
    }

    public /* synthetic */ MapleCoreAura() {
        MapleCoreAura a2;
    }

    public /* synthetic */ int getCoreAuraLevel() {
        MapleCoreAura a2;
        if (a2.H >= 30 && a2.H < 70) {
            return 1;
        }
        if (a2.H >= 70 && a2.H < 120) {
            return 2;
        }
        if (a2.H >= 120 && a2.H < 160) {
            return 3;
        }
        if (a2.H >= 160) {
            return 4;
        }
        return 1;
    }

    public /* synthetic */ void setWatk(int a2) {
        a.K = a2;
    }

    public /* synthetic */ int getMagic() {
        MapleCoreAura a2;
        return a2.a;
    }
}

