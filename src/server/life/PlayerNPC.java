/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.life;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.world.World;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.life.MapleLifeFactory;
import server.life.MapleNPC;
import server.maps.MapleMap;
import server.shark.SharkLogger;
import server.shops.MaplePlayerShopItem;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

public final class PlayerNPC
extends MapleNPC {
    private /* synthetic */ Map<Byte, Integer> e;
    private final /* synthetic */ int E;
    private /* synthetic */ byte a;
    private final /* synthetic */ int[] d;
    private /* synthetic */ int k;
    private /* synthetic */ byte K;
    private final /* synthetic */ int g;
    private /* synthetic */ int B;
    private /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ void saveToDB(Connection a2) {
        int n2;
        PreparedStatement preparedStatement;
        PlayerNPC a3;
        block7: {
            if (a3.getNPCFromWZ() != null) break block7;
            a3.destroy(true);
            return;
        }
        a3.destroy();
        PreparedStatement preparedStatement2 = preparedStatement = a2.prepareStatement(SharkLogger.ALLATORIxDEMO("hbrisx\u0001eoxn\fQ@@UD^O\\B_\tB@AD\u0000\u0001D@ES\u0000\u0001J@OD\u0000\u0001_JEO\u0000\u0001T\r\fX\u0000\u0001A@\\\r\fBD@^HH\r\fROSEQXHH\r\fGCNXICMH\r\fEES\u0000\u0001KDBEIS\u0000\u0001\\DXR\u0000\u0001[N^MH\b\fwmmyd\u007f\u0001\u0004\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\b"));
        PreparedStatement preparedStatement3 = preparedStatement;
        PreparedStatement preparedStatement4 = preparedStatement;
        PreparedStatement preparedStatement5 = preparedStatement;
        PreparedStatement preparedStatement6 = preparedStatement;
        PreparedStatement preparedStatement7 = preparedStatement;
        preparedStatement7.setString(1, a3.getName());
        preparedStatement7.setInt(2, a3.getHair());
        preparedStatement6.setInt(3, a3.getFace());
        preparedStatement6.setInt(4, a3.getSkin());
        preparedStatement5.setInt(5, a3.getPosition().x);
        preparedStatement5.setInt(6, a3.getPosition().y);
        preparedStatement4.setInt(7, a3.getMapId());
        preparedStatement4.setInt(8, a3.getCharId());
        preparedStatement3.setInt(9, a3.getId());
        preparedStatement3.setInt(10, a3.getFh());
        preparedStatement2.setInt(11, a3.getF());
        preparedStatement2.setInt(12, a3.getGender());
        String[] arrstring = new String[3];
        arrstring[0] = MaplePlayerShopItem.ALLATORIxDEMO("\u0006");
        arrstring[1] = SharkLogger.ALLATORIxDEMO("\u0011");
        arrstring[2] = MaplePlayerShopItem.ALLATORIxDEMO("\u0006");
        String[] arrstring2 = arrstring;
        int n3 = n2 = 0;
        while (n3 < 3) {
            if (a3.d[n2] > 0) {
                int n4 = n2;
                arrstring2[n4] = String.valueOf(a3.d[n4]);
            }
            n3 = ++n2;
        }
        try {
            preparedStatement.setString(13, arrstring2[0] + "," + arrstring2[1] + "," + arrstring2[2]);
            PreparedStatement preparedStatement8 = preparedStatement;
            preparedStatement8.setInt(14, a3.getWorld());
            preparedStatement8.executeUpdate();
            preparedStatement.close();
            PreparedStatement preparedStatement9 = preparedStatement = a2.prepareStatement(SharkLogger.ALLATORIxDEMO("eo\u007fd~u\fhbuc\u0001\\MMXISBQORsD]TEQ\u0004O\\BEE\u0000\u0001OIMSEE\u0000\u0001IPYH\\HH\r\fD]TEQ\\N_\b\fwmmyd\u007f\u0001\u0004\u001e\u0000\u0001\u0013\r\f\u001e\u0000\u0001\u0013\b"));
            preparedStatement9.setInt(1, a3.getId());
            PlayerNPC playerNPC = a3;
            preparedStatement9.setInt(2, playerNPC.getCharId());
            Iterator<Map.Entry<Byte, Integer>> iterator = playerNPC.e.entrySet().iterator();
            Iterator<Map.Entry<Byte, Integer>> iterator2 = iterator;
            while (iterator2.hasNext()) {
                a2 = iterator.next();
                preparedStatement.setInt(3, (Integer)a2.getValue());
                preparedStatement.setInt(4, ((Byte)a2.getKey()).byteValue());
                iterator2 = iterator;
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            return;
        }
        catch (Exception exception) {
            FileoutputUtil.outError(MaplePlayerShopItem.ALLATORIxDEMO("\u001bY\u0010EX\u8cf1\u65ee\u5e9d\u7507\u5e0eYB\u000fB"), exception);
            return;
        }
    }

    public /* synthetic */ byte getSkin() {
        PlayerNPC a2;
        return a2.K;
    }

    public /* synthetic */ void setHair(int a2) {
        a.k = a2;
    }

    public static /* synthetic */ void updateByCharId(MapleCharacter a2, Connection a3) {
        if (World.Find.findChannel(a2.getId()) > 0) {
            Iterator<PlayerNPC> iterator;
            Iterator<PlayerNPC> iterator2 = iterator = ChannelServer.getInstance(World.Find.findWorld(a2.getId()), World.Find.findChannel(a2.getId())).getAllPlayerNPC().iterator();
            while (iterator2.hasNext()) {
                iterator.next().update(a2, a3);
                iterator2 = iterator;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void destroy(boolean a) {
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var3_5 = var2_3.prepareStatement(MaplePlayerShopItem.ALLATORIxDEMO("r2z2b2\u00161d8{WF\u001bW\u000eS\u0005X\u0007U\u0004\u0016 ~2d2\u0016\u0004U\u0005_\u0007B\u001eRW\u000bW\t"));
            var3_5.setInt(1, a.getId());
            var3_5.executeUpdate();
            var3_5.close();
            var3_5 = var2_3.prepareStatement(SharkLogger.ALLATORIxDEMO("hd`dxd\fg~na\u0001\\MMXISBQORsD]TEQ\fvdd~d\fO\\BEE\f\u001c\f\u001e"));
            var3_5.setInt(1, a.getId());
            var3_5.executeUpdate();
            var3_5.close();
            if (a) {
                a.removeFromServer();
            }
            ** if (var2_3 == null) goto lbl-1000
        }
        catch (Throwable var3_6) {
            if (var2_3 == null) ** GOTO lbl30
            try {
                var2_3.close();
                v0 = var3_6;
                ** GOTO lbl31
            }
            catch (Throwable a) {
                try {
                    var3_6.addSuppressed(a);
lbl30:
                    // 2 sources

                    v0 = var3_6;
lbl31:
                    // 2 sources

                    throw v0;
                }
                catch (Exception var2_4) {
                    // empty catch block
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_3.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        PlayerNPC a3;
        MapleClient mapleClient = a2;
        PlayerNPC playerNPC = a3;
        a2.sendPacket(MaplePacketCreator.spawnNPC(playerNPC, true));
        mapleClient.sendPacket(MaplePacketCreator.spawnPlayerNPC(playerNPC));
        mapleClient.sendPacket(MaplePacketCreator.spawnNPCRequestController(a3, true));
    }

    public /* synthetic */ void setPets(List<MaplePet> a2) {
        a2 = a2.iterator();
        while (a2.hasNext()) {
            MaplePet maplePet = (MaplePet)a2.next();
            if (!maplePet.getSummoned()) continue;
            a.d[maplePet.getSummonedValue() - 1] = maplePet.getPetItemId();
        }
    }

    public /* synthetic */ PlayerNPC(MapleCharacter a2, int a3, MapleMap a4, MapleCharacter a5) {
        PlayerNPC a6;
        PlayerNPC playerNPC = a6;
        PlayerNPC playerNPC2 = a6;
        super(a3, a2.getName());
        PlayerNPC playerNPC3 = a6;
        a6.e = new HashMap<Byte, Integer>();
        int[] arrn = new int[3];
        arrn[0] = 0;
        arrn[1] = 0;
        arrn[2] = 0;
        a6.d = arrn;
        playerNPC2.g = a2.getId();
        playerNPC2.E = a4.getId();
        playerNPC.setCoords(a5.getPosition().x, a5.getPosition().y, 0, a5.getFh());
        playerNPC.update(a2);
    }

    public /* synthetic */ void addToServer() {
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
            while (iterator2.hasNext()) {
                PlayerNPC a2;
                Iterator<ChannelServer> iterator3;
                iterator3.next().addPlayerNPC(a2);
                iterator2 = iterator3;
            }
        }
    }

    public /* synthetic */ void update(MapleCharacter a2) {
        PlayerNPC a3;
        a3.update(a2, null);
    }

    public /* synthetic */ int getCharId() {
        PlayerNPC a2;
        return a2.g;
    }

    public /* synthetic */ void setGender(int a2) {
        a.a = (byte)a2;
    }

    public /* synthetic */ void destroy() {
        PlayerNPC a2;
        a2.destroy(false);
    }

    public /* synthetic */ int getHair() {
        PlayerNPC a2;
        return a2.k;
    }

    public /* synthetic */ void setFace(int a2) {
        a.B = a2;
    }

    public /* synthetic */ Map<Byte, Integer> getEquips() {
        PlayerNPC a2;
        return a2.e;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void saveToDB() {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            a.saveToDB((Connection)var1_1);
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_3) {
            if (var1_1 == null) ** GOTO lbl19
            try {
                var1_1.close();
                v0 = var2_3;
                ** GOTO lbl20
            }
            catch (Throwable var3_4) {
                try {
                    var2_3.addSuppressed(var3_4);
lbl19:
                    // 2 sources

                    v0 = var2_3;
lbl20:
                    // 2 sources

                    throw v0;
                }
                catch (Exception var1_2) {
                    FileoutputUtil.outError(MaplePlayerShopItem.ALLATORIxDEMO("\u001bY\u0010EX\u8cf1\u65ee\u5e9d\u7507\u5e0eYB\u000fB"), var1_2);
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

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void loadAll() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public /* synthetic */ int getFace() {
        PlayerNPC a2;
        return a2.B;
    }

    public /* synthetic */ int getPet(int a2) {
        PlayerNPC a3;
        if (a3.d[a2] > 0) {
            return a3.d[a2];
        }
        return 0;
    }

    public /* synthetic */ MapleNPC getNPCFromWZ() {
        PlayerNPC a2;
        MapleNPC mapleNPC = MapleLifeFactory.getNPC(a2.getId());
        if (mapleNPC != null) {
            mapleNPC.setName(a2.getName());
        }
        return mapleNPC;
    }

    public /* synthetic */ int getGender() {
        PlayerNPC a2;
        return a2.a;
    }

    public /* synthetic */ int getMapId() {
        PlayerNPC a2;
        return a2.E;
    }

    public /* synthetic */ void setSkin(byte a2) {
        a.K = a2;
    }

    public /* synthetic */ PlayerNPC(ResultSet a22) throws SQLException {
        int n2;
        PlayerNPC a3;
        PlayerNPC playerNPC = a3;
        PlayerNPC playerNPC2 = a3;
        PlayerNPC playerNPC3 = a3;
        super(a22.getInt(SharkLogger.ALLATORIxDEMO("\u007fB^H\\UeE")), a22.getString(MaplePlayerShopItem.ALLATORIxDEMO("\u0019W\u001aS")));
        PlayerNPC playerNPC4 = a3;
        playerNPC4.e = new HashMap<Byte, Integer>();
        int[] arrn = new int[3];
        arrn[0] = 0;
        arrn[1] = 0;
        arrn[2] = 0;
        playerNPC3.d = arrn;
        playerNPC3.k = a22.getInt(SharkLogger.ALLATORIxDEMO("D@ES"));
        a3.B = a22.getInt(MaplePlayerShopItem.ALLATORIxDEMO("\u0011W\u0014S"));
        playerNPC2.E = a22.getInt(SharkLogger.ALLATORIxDEMO("LMQ"));
        playerNPC2.ALLATORIxDEMO = a22.getInt(MaplePlayerShopItem.ALLATORIxDEMO("A\u0018D\u001bR"));
        a3.K = a22.getByte(SharkLogger.ALLATORIxDEMO("_JEO"));
        playerNPC.g = a22.getInt(MaplePlayerShopItem.ALLATORIxDEMO("\u0014^\u0016D\u001eR"));
        playerNPC.a = a22.getByte(SharkLogger.ALLATORIxDEMO("KDBEIS"));
        a3.setCoords(a22.getInt(MaplePlayerShopItem.ALLATORIxDEMO("N")), a22.getInt(SharkLogger.ALLATORIxDEMO("X")), a22.getInt(MaplePlayerShopItem.ALLATORIxDEMO("R\u001eD")), a22.getInt(SharkLogger.ALLATORIxDEMO("jNCUDN@E")));
        a22 = a22.getString(MaplePlayerShopItem.ALLATORIxDEMO("\u0007S\u0003E")).split(SharkLogger.ALLATORIxDEMO("\r"));
        int n3 = n2 = 0;
        while (n3 < 3) {
            if (a22[n2] != null) {
                int n4 = n2;
                a3.d[n4] = Integer.parseInt(a22[n4]);
            } else {
                a3.d[n2] = 0;
            }
            n3 = ++n2;
        }
        try {
            DruidPooledConnection druidPooledConnection;
            DruidPooledConnection druidPooledConnection2;
            block26: {
                druidPooledConnection2 = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    PreparedStatement preparedStatement;
                    PreparedStatement preparedStatement2;
                    block24: {
                        preparedStatement2 = druidPooledConnection2.prepareStatement(MaplePlayerShopItem.ALLATORIxDEMO("$s;s4bW\u001cWp%y:\u0016\u0007Z\u0016O\u0012D\u0019F\u0014E(S\u0006C\u001eFWa?s%sWx\u0007U>RW\u000bW\t"));
                        try {
                            block23: {
                                PreparedStatement preparedStatement3 = preparedStatement2;
                                preparedStatement3.setInt(1, a3.getId());
                                ResultSet resultSet = preparedStatement3.executeQuery();
                                try {
                                    while (resultSet.next()) {
                                        a3.e.put(resultSet.getByte(SharkLogger.ALLATORIxDEMO("IPYH\\QCR")), resultSet.getInt(MaplePlayerShopItem.ALLATORIxDEMO("S\u0006C\u001eF\u001eR")));
                                    }
                                    if (resultSet == null) break block23;
                                    preparedStatement = preparedStatement2;
                                }
                                catch (Throwable throwable) {
                                    Throwable throwable2;
                                    block25: {
                                        if (resultSet != null) {
                                            try {
                                                resultSet.close();
                                                throwable2 = throwable;
                                                break block25;
                                            }
                                            catch (Throwable a22) {
                                                throwable.addSuppressed(a22);
                                            }
                                        }
                                        throwable2 = throwable;
                                    }
                                    throw throwable2;
                                }
                                resultSet.close();
                                break block24;
                            }
                            preparedStatement = preparedStatement2;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable3;
                            block27: {
                                if (preparedStatement2 != null) {
                                    try {
                                        preparedStatement2.close();
                                        throwable3 = throwable;
                                        break block27;
                                    }
                                    catch (Throwable throwable4) {
                                        throwable.addSuppressed(throwable4);
                                    }
                                }
                                throwable3 = throwable;
                            }
                            throw throwable3;
                        }
                    }
                    if (preparedStatement != null) {
                        druidPooledConnection = druidPooledConnection2;
                        preparedStatement2.close();
                        break block26;
                    }
                    druidPooledConnection = druidPooledConnection2;
                }
                catch (Throwable throwable) {
                    Throwable throwable5;
                    block29: {
                        if (druidPooledConnection2 != null) {
                            try {
                                druidPooledConnection2.close();
                                throwable5 = throwable;
                                break block29;
                            }
                            catch (Throwable throwable6) {
                                throwable.addSuppressed(throwable6);
                            }
                        }
                        throwable5 = throwable;
                    }
                    throw throwable5;
                }
            }
            if (druidPooledConnection != null) {
                druidPooledConnection2.close();
                return;
            }
        }
        catch (SQLException sQLException) {
            Logger.getLogger(PlayerNPC.class.getName()).log(Level.SEVERE, null, sQLException);
        }
    }

    public /* synthetic */ void setCoords(int a2, int a3, int a4, int a5) {
        PlayerNPC a6;
        PlayerNPC playerNPC = a6;
        PlayerNPC playerNPC2 = a6;
        PlayerNPC playerNPC3 = a6;
        PlayerNPC playerNPC4 = a6;
        playerNPC3.setPosition(new Point(a2, a3));
        playerNPC3.setCy(a3);
        playerNPC2.setRx0(a2 - 50);
        playerNPC2.setRx1(a2 + 50);
        playerNPC.setF(a4);
        playerNPC.setFh(a5);
    }

    public /* synthetic */ int getWorld() {
        PlayerNPC a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void update(MapleCharacter a2, Connection a3) {
        PlayerNPC a4;
        if (a2 == null || a4.g != ((MapleCharacter)a2).getId()) {
            return;
        }
        PlayerNPC playerNPC = a4;
        MapleCharacter mapleCharacter = a2;
        PlayerNPC playerNPC2 = a4;
        MapleCharacter mapleCharacter2 = a2;
        a4.setName(mapleCharacter2.getName());
        playerNPC2.setHair(mapleCharacter2.getHair());
        playerNPC2.setFace(((MapleCharacter)a2).getFace());
        a4.setSkin(mapleCharacter.getSkinColor());
        playerNPC.setGender(mapleCharacter.getGender());
        playerNPC.setPets(((MapleCharacter)a2).getSummonedPets());
        PlayerNPC playerNPC3 = a4;
        a4.e = new HashMap<Byte, Integer>();
        Object object = a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).list().iterator();
        while (object.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (iItem.getPosition() < -128) {
                object = a2;
                continue;
            }
            a4.e.put((byte)iItem.getPosition(), iItem.getItemId());
            object = a2;
        }
        PlayerNPC playerNPC4 = a4;
        if (a3 != null) {
            playerNPC4.saveToDB(a3);
            return;
        }
        playerNPC4.saveToDB();
    }

    public /* synthetic */ void removeFromServer() {
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
            while (iterator2.hasNext()) {
                PlayerNPC a2;
                Iterator<ChannelServer> iterator3;
                iterator3.next().removePlayerNPC(a2);
                iterator2 = iterator3;
            }
        }
    }
}

