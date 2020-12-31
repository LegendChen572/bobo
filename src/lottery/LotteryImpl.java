/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u592f\u592f\u8c37
 */
package lottery;

import client.MapleCharacter;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import client.messages.commands.player.\u592f\u592f\u8c37;
import constants.ServerConfig;
import database.DBConPool;
import handling.channel.ChannelServer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import lottery.Lottery;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

public class LotteryImpl
implements Lottery {
    private /* synthetic */ ChannelServer E;
    private /* synthetic */ long d;
    private /* synthetic */ long ALLATORIxDEMO;
    public /* synthetic */ Collection<MapleCharacter> a;
    private static /* synthetic */ LotteryImpl e;
    private /* synthetic */ int K;
    private /* synthetic */ int k;
    public /* synthetic */ boolean jjc;
    private /* synthetic */ MapleMapFactory g;
    private /* synthetic */ int B;

    private /* synthetic */ MapleMap ALLATORIxDEMO(int a2, MapleCharacter a3) {
        if (a3.getEventInstance() == null) {
            MapleMap mapleMap = ChannelServer.getInstance(a3.getClient().getWorld(), a3.getClient().getChannel()).getMapFactory().getMap(a2);
            return mapleMap;
        }
        MapleMap mapleMap = a3.getEventInstance().getMapInstance(a2);
        return mapleMap;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void deletequest() {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var1_1.prepareStatement(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"$&57%3Q\u0007\u0004\u0013\u0002\u0002\u001f\u0006\u0012V\"3%V\u001f\u0017\u001c\u0013QKQF]\f\u0005VLVA"));
            var2_3.close();
            var2_3.executeUpdate();
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_1 == null) ** GOTO lbl22
            try {
                var1_1.close();
                v0 = var2_4;
                ** GOTO lbl23
            }
            catch (Throwable var3_5) {
                try {
                    var2_4.addSuppressed(var3_5);
lbl22:
                    // 2 sources

                    v0 = var2_4;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var1_2) {
                    var1_2.getStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_1.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    @Override
    public /* synthetic */ void setAlltouzhu(long a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ void doLottery() {
        LotteryImpl a2;
        a2.drawalottery();
    }

    private /* synthetic */ LotteryImpl() {
        LotteryImpl a2;
        LotteryImpl lotteryImpl = a2;
        lotteryImpl.a = new ArrayList<MapleCharacter>();
    }

    @Override
    public /* synthetic */ void addChar(MapleCharacter a2) {
        LotteryImpl a3;
        a3.a.add(a2);
    }

    @Override
    public /* synthetic */ MapleMapFactory getMapleMapFactory() {
        LotteryImpl a2;
        return a2.g;
    }

    public /* synthetic */ int getZjNum2() {
        LotteryImpl a2;
        return a2.k;
    }

    public /* synthetic */ void setZjNum3(int a2) {
        a.K = a2;
    }

    public static /* synthetic */ LotteryImpl getInstance() {
        if (e == null) {
            e = new LotteryImpl();
        }
        return e;
    }

    @Override
    public /* synthetic */ void setAllpeichu(long a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ Collection<MapleCharacter> getCharacters() {
        LotteryImpl a2;
        return a2.a;
    }

    @Override
    public /* synthetic */ int getZjNum() {
        LotteryImpl a2;
        return a2.B;
    }

    public static /* synthetic */ LotteryImpl getInstance(ChannelServer a2, MapleMapFactory a3) {
        if (e == null) {
            e = new LotteryImpl(a2, a3);
        }
        return e;
    }

    private /* synthetic */ LotteryImpl(ChannelServer a2, MapleMapFactory a3) {
        LotteryImpl a4;
        LotteryImpl lotteryImpl = a4;
        LotteryImpl lotteryImpl2 = a4;
        lotteryImpl2.a = new ArrayList<MapleCharacter>();
        lotteryImpl.E = a2;
        lotteryImpl.g = a3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public /* synthetic */ void drawalottery() {
        block7: {
            v0 = a;
            v0.B = (int)(Math.random() * 6.0 + 1.0);
            v1 = new int[2];
            v1[0] = 1;
            v1[1] = 5;
            var1_1 = v1;
            v0.k = var1_1[(int)(Math.random() * (double)var1_1.length)];
            var1_2 = a.k == 1 ? MonsterPetSystem.ALLATORIxDEMO("\u55fd") : (a.k == 5 ? \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u96a8") : "");
            v2 = new int[3];
            v2[0] = 1;
            v2[1] = 3;
            v2[2] = 5;
            var2_3 = v2;
            a.K = var2_3[(int)(Math.random() * (double)var2_3.length)];
            var2_4 = a.K == 1 ? MonsterPetSystem.ALLATORIxDEMO("\u5c5c") : (a.K == 3 ? \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u4e5c") : (a.K == 5 ? MonsterPetSystem.ALLATORIxDEMO("\u5974") : ""));
            var3_5 = " ";
            var4_6 = " ";
            var5_7 = " ";
            var6_8 = 0;
            var7_9 = 0;
            var8_10 = 0;
            var9_11 = 0;
            var10_12 = 0;
            var11_13 = 0;
            var12_14 = 0L;
            var14_15 = 0L;
            var16_16 = 0;
            var17_17 = a.a;
            if (var17_17 == null) break block7;
            for (MapleCharacter var19_20 : var17_17) {
                var20_22 = var19_20.getTouzhuType();
                var21_24 = var19_20.getTouzhuNum();
                var22_25 = var19_20.getTouzhuNX();
                var19_20.setTouzhuType(0);
                var19_20.setTouzhuNum(0);
                var19_20.setTouzhuNX(0);
                var12_14 += (long)var22_25;
                if (var20_22 != 2) ** GOTO lbl56
                ++var6_8;
                if (a.k == var21_24) {
                    var22_25 *= 2;
                    var22_25 -= var22_25 * 5 / 100;
                    v3 = var19_20;
                    v3.modifyCSPoints(1, var22_25);
                    v3.dropMessage(1, "\u672c\u671f\u865f\u78bc\uff1a\u3010" + var1_2 + "\u3011 \r\n\u606d\u559c\u4f60\u7372\u734e\u4e86\u3002\u6263\u9664\u624b\u7e8c\u8cbb5%\u3002\u7372\u5f97\u734e\u91d1\u984d:" + var22_25);
                    ++var9_11;
                    var5_7 = (String)var5_7 + var19_20.getName() + ":\u8d0f\u5f97" + (var14_15 += (long)var22_25) + "GASH ";
                    ++var16_16;
                    v4 = var20_22;
                } else {
                    var19_20.dropMessage(1, "\u672c\u671f\u865f\u78bc\uff1a\u3010" + var1_2 + "\u3011\r\n\u5c0d\u4e0d\u8d77\u60a8\u6c92\u6709\u4e2d\u734e\uff0c\u8acb\u7e7c\u7e8c\u52aa\u529b");
lbl56:
                    // 2 sources

                    v4 = var20_22;
                }
                if (v4 != 3) ** GOTO lbl71
                ++var7_9;
                if (a.K == var21_24) {
                    var22_25 *= 3;
                    var22_25 -= var22_25 * 5 / 100;
                    v5 = var19_20;
                    v5.modifyCSPoints(1, var22_25);
                    v5.dropMessage(1, "\u672c\u671f\u865f\u78bc\uff1a\u3010" + var2_4 + "\u3011 \r\n\u606d\u559c\u4f60\u7372\u734e\u4e86\u3002\u6263\u9664\u624b\u7e8c\u8cbb5%\u3002\u7372\u5f97\u734e\u91d1\u984d:" + var22_25);
                    ++var10_12;
                    var5_7 = (String)var5_7 + var19_20.getName() + ":\u8d0f\u5f97" + (var14_15 += (long)var22_25) + "GASH ";
                    ++var16_16;
                    v6 = var20_22;
                } else {
                    var19_20.dropMessage(1, "\u672c\u671f\u865f\u78bc\uff1a\u3010" + var2_4 + "\u3011\r\n\u5c0d\u4e0d\u8d77\u60a8\u6c92\u6709\u4e2d\u734e\uff0c\u8acb\u7e7c\u7e8c\u52aa\u529b");
lbl71:
                    // 2 sources

                    v6 = var20_22;
                }
                if (v6 != 6) continue;
                ++var8_10;
                if (a.B == var21_24) {
                    var22_25 *= 6;
                    var22_25 -= var22_25 * 5 / 100;
                    v7 = var19_20;
                    v7.modifyCSPoints(1, var22_25);
                    v7.dropMessage(1, "\u672c\u671f\u865f\u78bc\uff1a\u3010" + a.B + "\u3011 \r\n\u606d\u559c\u4f60\u7372\u734e\u4e86\u3002\u6263\u9664\u624b\u7e8c\u8cbb5%\u3002\u7372\u5f97\u734e\u91d1\u984d:" + var22_25);
                    ++var11_13;
                    var5_7 = (String)var5_7 + var19_20.getName() + ":\u8d0f\u5f97" + (var14_15 += (long)var22_25) + "GASH ";
                    ++var16_16;
                    continue;
                }
                var19_20.dropMessage(1, "\u672c\u671f\u865f\u78bc\uff1a\u3010" + a.B + "\u3011\r\n\u5c0d\u4e0d\u8d77\u60a8\u6c92\u6709\u4e2d\u734e\uff0c\u8acb\u7e7c\u7e8c\u52aa\u529b");
            }
            v8 = a;
            v8.d += var12_14;
            v8.ALLATORIxDEMO += var14_15;
            v8.a.removeAll(var17_17);
        }
        var18_19 = 0;
        if (var17_17 != null) {
            var18_19 = var17_17.size();
        }
        var19_21 = "[\u8ced\u535a\u7cfb\u7d71] : \u6240\u6709\u8ced\u5834\u73a9\u5bb6\u8acb\u4e0d\u8981\u96e2\u958b" + ServerConfig.getGamblingChannel() + "\u983b\u9053\uff0c\u5426\u5247\u7121\u6cd5\u6b63\u5e38\u53c3\u8207\u8ced\u5834\u904a\u6232\u3002" + ServerConfig.getGamblingChannel() + "\u983b\u9053\u70ba\u8ced\u535a\u983b\u9053";
        var20_23 = "[\u8ced\u535a\u7cfb\u7d71] : \u4e2d\u734e\u540d\u55ae:" + (String)(var5_7 == " " && var4_6 == " " && var3_5 == " " ? \u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u7157\u4ecb\u4e5b\u733f") : (String)var5_7 + var4_6 + var3_5);
        ChannelServer.getGamblingChannel().broadcastSmega(MaplePacketCreator.getMegaphone(var19_21));
        ChannelServer.getGamblingChannel().broadcastSmega(MaplePacketCreator.getSkullSmega(var20_23, false, ServerConfig.getGamblingChannel()));
    }

    @Override
    public /* synthetic */ void setZjNum(int a2) {
        a.B = a2;
    }

    @Override
    public /* synthetic */ long getAllpeichu() {
        LotteryImpl a2;
        return a2.ALLATORIxDEMO;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void deletebuff() {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var1_1.prepareStatement(MonsterPetSystem.ALLATORIxDEMO("\r\u0003\u001c\u0012\f\u0016x\"-6+'5<6 ,6*s\u000b\u0016\fs6256xnxct002*:<sesh\u007f\"'xnxcx\u0004\u0010\u0016\n\u0016x),sdmxc"));
            var2_3.close();
            var2_3.executeUpdate();
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_1 == null) ** GOTO lbl22
            try {
                var1_1.close();
                v0 = var2_4;
                ** GOTO lbl23
            }
            catch (Throwable var3_5) {
                try {
                    var2_4.addSuppressed(var3_5);
lbl22:
                    // 2 sources

                    v0 = var2_4;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var1_2) {
                    var1_2.getStackTrace();
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_1.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public /* synthetic */ int getZjNum3() {
        LotteryImpl a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ long getAlltouzhu() {
        LotteryImpl a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ ChannelServer getChannelServer() {
        LotteryImpl a2;
        return a2.E;
    }

    @Override
    public /* synthetic */ void warp(int a2, MapleCharacter a3) {
        LotteryImpl a4;
        MapleMap mapleMap = a2 = a4.ALLATORIxDEMO(a2, a3);
        a3.changeMap(mapleMap, mapleMap.getPortal(0));
    }

    public static /* synthetic */ int getDatetimemm() {
        Date date = new Date();
        return Integer.parseInt(new SimpleDateFormat(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u001b\u001c")).format(date));
    }

    public static /* synthetic */ {
        e = null;
    }

    @Override
    public /* synthetic */ void setCharacters(Collection<MapleCharacter> a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ int getTouNumbyType(int a2) {
        LotteryImpl a3;
        int n2 = 0;
        Iterator<MapleCharacter> iterator = a3.a.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTouzhuType() != a2) continue;
            ++n2;
        }
        return n2;
    }

    public /* synthetic */ void setZjNum2(int a2) {
        a.k = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ int test3() throws SQLException {
        block9: {
            var1_1 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                var2_3 = MonsterPetSystem.ALLATORIxDEMO("\u000b\u0016\u0014\u0016\u001b\u0007x07&6'pyqs>!7>x\"-6+'5<6 ,6*s\u000f\u001b\u001d\u0001\u001ds\"'xnxc");
                var3_5 = var1_1.prepareStatement(var2_3);
                var4_7 = var3_5.executeQuery();
                var5_9 = -1;
                if (var4_7.next()) {
                    var5_9 = var4_7.getInt(1);
                }
                var4_7.close();
                var3_5.close();
                var4_8 = var5_9;
                if (var1_1 == null) break block9;
            }
            catch (Throwable var2_4) {
                if (var1_1 == null) ** GOTO lbl24
                try {
                    var1_1.close();
                    v0 = var2_4;
                    ** GOTO lbl25
                }
                catch (Throwable var3_6) {
                    try {
                        var2_4.addSuppressed(var3_6);
lbl24:
                        // 2 sources

                        v0 = var2_4;
lbl25:
                        // 2 sources

                        throw v0;
                    }
                    catch (SQLException var1_2) {
                        FileoutputUtil.outError(\u592f\u592f\u8c37.ALLATORIxDEMO((String)"\u001a\u001e\u0011\u0002Y\u8cb6\u65ef\u5eda\u7506\u5e49X\u0005\u000e\u0005"), var1_2);
                        return 0;
                    }
                }
            }
            var1_1.close();
        }
        return var4_8;
    }
}

