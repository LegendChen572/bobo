/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 *  com.fasterxml.jackson.core.type.TypeReference
 *  com.fasterxml.jackson.databind.ObjectMapper
 */
package client.inventory;

import client.MapleCharacter;
import client.MapleDiseaseValueHolder;
import client.inventory.CheckCopyItem;
import client.inventory.Equip;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.ItemLoaderType;
import client.inventory.MapleAndroid;
import client.inventory.MapleEquipOnlyId;
import client.inventory.MapleInventoryIdentifier;
import client.inventory.MapleInventoryIdentifierPet;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import database.DBConPool;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import server.MapleItemInformationProvider;
import tools.Eval;
import tools.FileoutputUtil;
import tools.GZIPCompression;
import tools.JsonMapConverter;
import tools.Pair;
import tools.StringTool;

public final class ItemLoader
extends Enum<ItemLoader> {
    public static final /* synthetic */ /* enum */ ItemLoader CASHSHOP_CYGNUS;
    public static final /* synthetic */ /* enum */ ItemLoader STORAGE_EXCEED;
    public static final /* synthetic */ /* enum */ ItemLoader CASHSHOP_RESIST;
    public static final /* synthetic */ /* enum */ ItemLoader CASHSHOP_EVAN;
    public static final /* synthetic */ /* enum */ ItemLoader MTS;
    public static final /* synthetic */ /* enum */ ItemLoader INVENTORY;
    private final /* synthetic */ String a;
    public static final /* synthetic */ /* enum */ ItemLoader HIRED_FISHING;
    public static final /* synthetic */ /* enum */ ItemLoader STORAGE;
    public static final /* synthetic */ /* enum */ ItemLoader CASHSHOP_EXPLORER;
    private final /* synthetic */ int k;
    public static final /* synthetic */ /* enum */ ItemLoader MTS_TRANSFER;
    public static final /* synthetic */ /* enum */ ItemLoader HIRED_MERCHANT;
    public static final /* synthetic */ /* enum */ ItemLoader CASHSHOP_DB;
    public static final /* synthetic */ /* enum */ ItemLoader DUEY;
    private final /* synthetic */ boolean K;
    private final /* synthetic */ String d;
    private static final /* synthetic */ ItemLoader[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ ItemLoader CASHSHOP_ARAN;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ItemLoader(int n22, boolean n22, String a2, String a3) {
        void a4;
        void a5;
        void var2_-1;
        void var1_-1;
        ItemLoader a6;
        ItemLoader itemLoader = a6;
        ItemLoader itemLoader2 = a6;
        itemLoader2.k = (int)a2;
        itemLoader2.K = a3;
        itemLoader.a = a5;
        itemLoader.d = a4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean isExistsByUniqueid(int a) {
        var1_1 = ItemLoader.values();
        var2_2 = var1_1.length;
        v0 = var3_3 = 0;
        while (v0 < var2_2) {
            block12: {
                block13: {
                    var4_4 = var1_1[var3_3];
                    var5_6 = new StringBuilder();
                    var5_6.append(Eval.ALLATORIxDEMO("\f\u0001\u0013\u0001\u001c\u0010\u007fn\u007f\u0002\r\u000b\u0012d?-12:*++-=60:),$\u007f\u0013\u0017\u0001\r\u0001\u007f$+=/!?dbd`d\u001e\n\u001bd**65*!6 \u007fy\u007f{"));
                    var6_8 = DBConPool.getInstance().getDataSource().getConnection();
                    v1 = var7_10 = var6_8.prepareStatement(var5_6.toString());
                    v1.setInt(1, var4_4.k);
                    v1.setInt(2, a);
                    var4_4 = v1.executeQuery();
                    if (!var4_4.first()) break block12;
                    var7_10.close();
                    var4_4.close();
                    var5_7 = true;
                    if (var6_8 == null) break block13;
                    var6_8.close();
                }
                return var5_7;
            }
            var7_10.close();
            var4_4.close();
            ** if (var6_8 == null) goto lbl-1000
lbl-1000:
            // 1 sources

            {
                var6_8.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            {
                catch (Throwable var7_11) {
                    try {
                        block14: {
                            if (var6_8 != null) {
                                try {
                                    var6_8.close();
                                    v2 = var7_11;
                                    break block14;
                                }
                                catch (Throwable var4_5) {
                                    var7_11.addSuppressed(var4_5);
                                }
                            }
                            v2 = var7_11;
                        }
                        throw v2;
                    }
                    catch (SQLException var6_9) {
                        Logger.getLogger(ItemLoader.class.getName()).log(Level.SEVERE, null, var6_9);
                    }
                }
            }
            v0 = ++var3_3;
        }
        return false;
    }

    private /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> ALLATORIxDEMO(boolean a2, boolean a3, Integer ... a4) throws SQLException {
        ItemLoader a5;
        return a5.loadItems(false, true, a3, a4);
    }

    public /* synthetic */ void saveItemInv(MapleInventoryType a222, List<Pair<IItem, MapleInventoryType>> a32, Connection a4, Integer ... a52) throws SQLException {
        ItemLoader a6;
        Object object;
        String string;
        String string2;
        String string3;
        block24: {
            block23: {
                string3 = "";
                string2 = "";
                string = "";
                object = null;
                a52 = Arrays.asList(a52);
                if (a6 != HIRED_FISHING && a6 != HIRED_MERCHANT && a6 != STORAGE && a6 != CASHSHOP_RESIST && a6 != CASHSHOP_CYGNUS && a6 != CASHSHOP_EXPLORER && a6 != CASHSHOP_ARAN && a6 != CASHSHOP_EVAN && a6 != CASHSHOP_DB || a52.size() == 2) break block23;
                return;
            }
            if (a6 != STORAGE_EXCEED || a52.size() == 3) break block24;
            return;
        }
        try {
            Object object2 = new StringBuilder();
            StringBuilder stringBuilder = object2;
            stringBuilder.append(Eval.ALLATORIxDEMO("\u001b\u0001\u0013\u0001\u000b\u0001\u007f\u0002\r\u000b\u0012d?-12:*++-=60:),$\u007f\u0013\u0017\u0001\r\u0001\u007f$+=/!?dbd`d\u001e\n\u001bd?-12:*++-=+=/!?dbd`d\u001e\n\u001bdw$"));
            stringBuilder.append(a6.K ? MapleDiseaseValueHolder.ALLATORIxDEMO("\u0016@\u0014L\u0002M\u0003J\u0013") : Eval.ALLATORIxDEMO("'7%-%<0:66 "));
            ((StringBuilder)object2).append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0017\u0003J\u0003H"));
            if (a6 == HIRED_FISHING || a6 == HIRED_MERCHANT) {
                ((StringBuilder)object2).append(Eval.ALLATORIxDEMO("d\u0010\u0016\u007f$/%</>#:-;$\u007fy\u007f{"));
            }
            if (a6 == STORAGE_EXCEED) {
                ((StringBuilder)object2).append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u00036m3\u0003\u0017S\u0016@\u001cB\u0010F\u001eG\u0017\u0003J\u0003H"));
            }
            if (a6 == STORAGE || a6 == STORAGE_EXCEED || a6 == CASHSHOP_CYGNUS || a6 == CASHSHOP_EXPLORER || a6 == CASHSHOP_ARAN || a6 == CASHSHOP_EVAN || a6 == CASHSHOP_DB || a6 == CASHSHOP_RESIST) {
                ((StringBuilder)object2).append(Eval.ALLATORIxDEMO("\u007f\u0005\u0011\u0000\u007f$(+-(;$\u007fy\u007f{"));
            }
            ((StringBuilder)object2).append(MapleDiseaseValueHolder.ALLATORIxDEMO("^"));
            object = a52;
            Object object3 = object2 = a4.prepareStatement(((StringBuilder)object2).toString());
            object3.setInt(1, a6.k);
            object3.setInt(2, a222.getType());
            int a222 = 0;
            int n2 = a222;
            while (n2 < a52.size()) {
                int n3 = a222 + 3;
                Object e2 = a52.get(a222);
                object2.setInt(n3, (Integer)e2);
                n2 = ++a222;
            }
            Object object4 = object2;
            string3 = object4.toString();
            object4.executeUpdate();
            object2.close();
            if (a32 == null) {
                return;
            }
            Object a222 = new StringBuilder(Eval.ALLATORIxDEMO("\u0016\n\f\u0001\r\u0010\u007f\r\u0011\u0010\u0010d?-12:*++-=60:),$\u007fl"));
            ((StringBuilder)a222).append(a6.K ? MapleDiseaseValueHolder.ALLATORIxDEMO("\u0016@\u0014L\u0002M\u0003J\u0013") : Eval.ALLATORIxDEMO("'7%-%<0:66 "));
            if (a6 == STORAGE_EXCEED || a6 == HIRED_FISHING || a6 == HIRED_MERCHANT) {
                ((StringBuilder)a222).append(MapleDiseaseValueHolder.ALLATORIxDEMO("[\u0003\u0007B\u0014H\u0016D\u0012J\u0013"));
            }
            if (a6 == INVENTORY || a6 == STORAGE || a6 == STORAGE_EXCEED || a6 == CASHSHOP_CYGNUS || a6 == CASHSHOP_EXPLORER || a6 == CASHSHOP_ARAN || a6 == CASHSHOP_EVAN || a6 == CASHSHOP_DB || a6 == CASHSHOP_RESIST) {
                ((StringBuilder)a222).append(Eval.ALLATORIxDEMO("h\u007f3063 "));
            }
            ((StringBuilder)a222).append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u000fWJ\u0003F\u001aJ\u0013\u000fWJ\u0019U\u0012M\u0003L\u0005Z\u0003Z\u0007F[\u0003\u0007L\u0004J\u0003J\u0018M[\u0003\u0006V\u0016M\u0003J\u0003Z[\u0003\u0018T\u0019F\u0005\u000fWd:|;L\u0010\u000fWV\u0019J\u0006V\u0012J\u0013\u000fWF\u000fS\u001eQ\u0012G\u0016W\u0012\u000fWE\u001bB\u0010\u000fWC\u0003Z\u0007F\u0017\u000fWP\u0012M\u0013F\u0005\u000fWF\u0006V\u001eS8M\u001bZ>G^\u0003!b;v2pW\u000bH\u000fW\u001c[\u0003H\u000fW\u001c[\u0003H\u000fW\u001c[\u0003H\u000fW\u001c[\u0003H\u000fW\u001c[\u0003H\u000fW\u001c[\u0003H"));
            if (a6 == STORAGE_EXCEED || a6 == HIRED_FISHING || a6 == HIRED_MERCHANT) {
                ((StringBuilder)a222).append(Eval.ALLATORIxDEMO("h\u007f{"));
            }
            if (a6 == INVENTORY || a6 == STORAGE || a6 == STORAGE_EXCEED || a6 == CASHSHOP_CYGNUS || a6 == CASHSHOP_EXPLORER || a6 == CASHSHOP_ARAN || a6 == CASHSHOP_EVAN || a6 == CASHSHOP_DB || a6 == CASHSHOP_RESIST) {
                ((StringBuilder)a222).append(MapleDiseaseValueHolder.ALLATORIxDEMO("[\u0003H"));
            }
            ((StringBuilder)a222).append(Eval.ALLATORIxDEMO("m"));
            object2 = a4.prepareStatement(((StringBuilder)a222).toString(), 1);
            a222 = "";
            int n4 = 30;
            int n5 = 0;
            int n6 = n5;
            while (n6 < n4) {
                a222 = n5 == n4 - 1 ? (String)a222 + "?" : (String)a222 + "?, ";
                n6 = ++n5;
            }
            PreparedStatement preparedStatement = a4.prepareStatement("INSERT INTO `inventoryequipment` VALUES (DEFAULT, " + (String)a222 + ")", 1);
            a222 = a32.iterator();
            while (a222.hasNext()) {
                Object object5;
                Object object6;
                block27: {
                    block25: {
                        int n7;
                        a32 = a222.next();
                        a4 = ((Pair)a32).getLeft();
                        a32 = (MapleInventoryType)((Object)((Pair)a32).getRight());
                        n4 = 1;
                        int n8 = n7 = 0;
                        while (n8 < a52.size()) {
                            object2.setInt(n4++, (Integer)a52.get(n7));
                            n8 = ++n7;
                        }
                        if (a6 == INVENTORY) {
                            object2.setInt(n4, 0);
                            ++n4;
                        }
                        Object object7 = object2;
                        object7.setInt(n4, a4.getItemId());
                        object7.setInt(++n4, ((MapleInventoryType)((Object)a32)).getType());
                        object7.setInt(++n4, a4.getPosition());
                        object7.setInt(++n4, a4.getQuantity());
                        object7.setString(++n4, a4.getOwner());
                        object7.setString(++n4, a4.getGMLog());
                        object7.setInt(++n4, a4.getUniqueId());
                        object7.setLong(++n4, a4.getExpiration());
                        object7.setInt(++n4, a4.getFlag());
                        int n9 = ++n4;
                        object7.setByte(n9, (byte)a6.k);
                        object7.setString(++n4, a4.getGiftFrom());
                        object7.setLong(++n4, a4.getEquipOnlyId());
                        ++n4;
                        object7.executeUpdate();
                        if (!((Enum)a32).equals((Object)MapleInventoryType.EQUIP) && !((Enum)a32).equals((Object)MapleInventoryType.EQUIPPED)) continue;
                        n4 = 1;
                        object6 = object2.getGeneratedKeys();
                        try {
                            if (!object6.next()) {
                                FileoutputUtil.printError(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0004B\u0001F>W\u0012N\u0004\r\u0003[\u0003"), new Throwable(), "\u3000\u5beb\u5165\u7269\u54c1\u5931\u6557(" + a6.a + ")");
                                throw new RuntimeException(Eval.ALLATORIxDEMO("\u305f\u5baf\u513a\u722d\u549e\u5975\u6508j"));
                            }
                            preparedStatement.setLong(n4++, object6.getLong(1));
                            if (object6 == null) break block25;
                            object5 = a4;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            block26: {
                                if (object6 != null) {
                                    try {
                                        object6.close();
                                        throwable2 = throwable;
                                        break block26;
                                    }
                                    catch (Throwable a32) {
                                        throwable.addSuppressed(a32);
                                    }
                                }
                                throwable2 = throwable;
                            }
                            throw throwable2;
                        }
                        object6.close();
                        break block27;
                    }
                    object5 = a4;
                }
                object6 = (IEquip)object5;
                PreparedStatement preparedStatement2 = preparedStatement;
                preparedStatement2.setInt(n4, object6.getUpgradeSlots());
                preparedStatement2.setInt(++n4, object6.getLevel());
                preparedStatement2.setInt(++n4, object6.getStr());
                preparedStatement2.setInt(++n4, object6.getDex());
                preparedStatement2.setInt(++n4, object6.getInt());
                preparedStatement2.setInt(++n4, object6.getLuk());
                preparedStatement2.setInt(++n4, object6.getHp());
                preparedStatement2.setInt(++n4, object6.getMp());
                preparedStatement2.setInt(++n4, object6.getWatk());
                preparedStatement2.setInt(++n4, object6.getMatk());
                preparedStatement2.setInt(++n4, object6.getWdef());
                preparedStatement2.setInt(++n4, object6.getMdef());
                preparedStatement2.setInt(++n4, object6.getAcc());
                preparedStatement2.setInt(++n4, object6.getAvoid());
                preparedStatement2.setInt(++n4, object6.getHands());
                preparedStatement2.setInt(++n4, object6.getSpeed());
                preparedStatement2.setInt(++n4, object6.getJump());
                preparedStatement2.setInt(++n4, object6.getViciousHammer());
                preparedStatement2.setInt(++n4, object6.getItemEXP());
                preparedStatement2.setInt(++n4, object6.getDurability());
                preparedStatement2.setByte(++n4, object6.getEnhance());
                preparedStatement2.setInt(++n4, object6.getPotential1());
                preparedStatement2.setInt(++n4, object6.getPotential2());
                preparedStatement2.setInt(++n4, object6.getPotential3());
                preparedStatement2.setInt(++n4, object6.getIncSkill());
                preparedStatement2.setInt(++n4, object6.getHpR());
                preparedStatement2.setInt(++n4, object6.getMpR());
                preparedStatement2.setShort(++n4, object6.getCharmEXP());
                preparedStatement2.setShort(++n4, object6.getPVPDamage());
                ++n4;
                string = preparedStatement2.toString();
                string2 = object2.toString();
                preparedStatement2.executeUpdate();
            }
            preparedStatement.close();
            object2.close();
            return;
        }
        catch (Exception a52) {
            System.out.println("\u547d\u4ee4:" + string3);
            System.out.println("\u547d\u4ee42:" + string2);
            System.out.println("\u547d\u4ee43:" + string);
            System.out.println("size:" + object.toString() + "  " + a6);
            a52.printStackTrace();
            FileoutputUtil.logToFile(MapleDiseaseValueHolder.ALLATORIxDEMO("O\u0018D\u0004\f\u8cb0\u65ba\u5edc\u7553\u5e4f\r\u0003[\u0003"), a52 + "\r\n\u547d\u4ee4:" + string3 + "\r\n\u547d\u4ee42:" + string2 + "\r\n\u547d\u4ee43:" + string);
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void saveItemsNew(List<Pair<IItem, MapleInventoryType>> a, int a, int a) throws SQLException {
        var4_5 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            a.saveItemsNew(a, (Connection)var4_5, a, a);
            ** if (var4_5 == null) goto lbl-1000
        }
        catch (Throwable var5_7) {
            if (var4_5 == null) ** GOTO lbl19
            try {
                var4_5.close();
                v0 = var5_7;
                ** GOTO lbl20
            }
            catch (Throwable a) {
                try {
                    var5_7.addSuppressed(a);
lbl19:
                    // 2 sources

                    v0 = var5_7;
lbl20:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var4_6) {
                    FileoutputUtil.outError(MapleDiseaseValueHolder.ALLATORIxDEMO("O\u0018D\u0004\f\u8cb0\u65ba\u5edc\u7553\u5e4f\r\u0003[\u0003"), var4_6);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var4_5.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ String uncompressA(String a) {
        block31: {
            block27: {
                block26: {
                    if (a == null) {
                        return null;
                    }
                    if (a.contains(Eval.ALLATORIxDEMO("}u}~"))) {
                        return a;
                    }
                    var2_5 = new ByteArrayOutputStream();
                    var3_6 = null;
                    var4_7 = null;
                    var5_8 = null;
                    var6_10 = null;
                    var7_11 = Base64.getMimeDecoder();
                    var5_8 = var7_11.decode((String)a);
                    var3_6 = new ByteArrayInputStream(var5_8);
                    var4_7 = new GZIPInputStream(var3_6);
                    a = new byte[1024];
                    var5_9 = -1;
                    v0 = var4_7;
                    while ((var5_9 = v0.read((byte[])a)) != -1) {
                        v0 = var4_7;
                        var2_5.write((byte[])a, 0, var5_9);
                    }
                    var6_10 = var2_5.toString();
                    if (var4_7 == null) break block26;
                    try {
                        var4_7.close();
                        v1 = var3_6;
                        break block27;
                    }
                    catch (IOException var7_12) {
                        // empty catch block
                    }
                }
                v1 = var3_6;
            }
            if (v1 == null) break block31;
            try {
                var3_6.close();
                v2 = var2_5;
                ** GOTO lbl45
            }
            catch (IOException var7_13) {
                // empty catch block
            }
        }
        try {
            v2 = var2_5;
lbl45:
            // 2 sources

            v2.close();
            return var6_10;
        }
        catch (IOException var7_14) {
            return var6_10;
        }
        catch (IOException var7_15) {
            block33: {
                block29: {
                    block28: {
                        try {
                            var7_15.printStackTrace();
                            if (var4_7 == null) break block28;
                        }
                        catch (Throwable var8_19) {
                            block32: {
                                block30: {
                                    if (var4_7 != null) {
                                        try {
                                            var4_7.close();
                                            v3 = var3_6;
                                            break block30;
                                        }
                                        catch (IOException a) {
                                            // empty catch block
                                        }
                                    }
                                    v3 = var3_6;
                                }
                                if (v3 == null) break block32;
                                try {
                                    var3_6.close();
                                    v4 = var2_5;
                                    ** GOTO lbl73
                                }
                                catch (IOException a) {
                                    // empty catch block
                                }
                            }
                            try {
                                v4 = var2_5;
lbl73:
                                // 2 sources

                                v4.close();
                                v5 = var8_19;
                                throw v5;
                            }
                            catch (IOException a) {
                                v5 = var8_19;
                            }
                            throw v5;
                        }
                        try {
                            var4_7.close();
                            v6 = var3_6;
                            break block29;
                        }
                        catch (IOException var7_16) {
                            // empty catch block
                        }
                    }
                    v6 = var3_6;
                }
                if (v6 == null) break block33;
                try {
                    var3_6.close();
                    v7 = var2_5;
                    ** GOTO lbl98
                }
                catch (IOException var7_17) {
                    // empty catch block
                }
            }
            try {
                v7 = var2_5;
lbl98:
                // 2 sources

                v7.close();
                return var6_10;
            }
            catch (IOException var7_18) {
                return var6_10;
            }
        }
    }

    public /* synthetic */ void saveItems(List<Pair<IItem, MapleInventoryType>> a2, Connection a32, Integer ... a42) throws SQLException {
        ItemLoader a5;
        Object object;
        String string;
        String string2;
        String string3;
        block24: {
            block23: {
                string3 = "";
                string2 = "";
                string = "";
                object = null;
                a42 = Arrays.asList(a42);
                if (a5 != HIRED_FISHING && a5 != HIRED_MERCHANT && a5 != STORAGE && a5 != CASHSHOP_RESIST && a5 != CASHSHOP_CYGNUS && a5 != CASHSHOP_EXPLORER && a5 != CASHSHOP_ARAN && a5 != CASHSHOP_EVAN && a5 != CASHSHOP_DB || a42.size() == 2) break block23;
                return;
            }
            if (a5 != STORAGE_EXCEED || a42.size() == 3) break block24;
            return;
        }
        try {
            Object object2 = new StringBuilder();
            StringBuilder stringBuilder = object2;
            stringBuilder.append(MapleDiseaseValueHolder.ALLATORIxDEMO("g2o2w2\u00031q8nWC\u001eM\u0001F\u0019W\u0018Q\u000eJ\u0003F\u001aP\u0017\u0003 k2q2\u0003\u0017W\u000eS\u0012CW\u001eW\u001cWb9gW\u000b\u0017"));
            stringBuilder.append(a5.K ? Eval.ALLATORIxDEMO("%<'01106 ") : MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014K\u0016Q\u0016@\u0003F\u0005J\u0013"));
            ((StringBuilder)object2).append(Eval.ALLATORIxDEMO("$\u007fy\u007f{"));
            if (a5 == HIRED_FISHING || a5 == HIRED_MERCHANT) {
                ((StringBuilder)object2).append(MapleDiseaseValueHolder.ALLATORIxDEMO("Wl%\u0003\u0017S\u0016@\u001cB\u0010F\u001eG\u0017\u0003J\u0003H"));
            }
            if (a5 == STORAGE_EXCEED) {
                ((StringBuilder)object2).append(Eval.ALLATORIxDEMO("\u007f\u0005\u0011\u0000\u007f$/%</>#:-;$\u007fy\u007f{"));
            }
            if (a5 == STORAGE || a5 == STORAGE_EXCEED || a5 == CASHSHOP_CYGNUS || a5 == CASHSHOP_EXPLORER || a5 == CASHSHOP_ARAN || a5 == CASHSHOP_EVAN || a5 == CASHSHOP_DB || a5 == CASHSHOP_RESIST) {
                ((StringBuilder)object2).append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u00036m3\u0003\u0017T\u0018Q\u001bG\u0017\u0003J\u0003H"));
            }
            ((StringBuilder)object2).append(Eval.ALLATORIxDEMO("m"));
            object = a42;
            object2 = a32.prepareStatement(((StringBuilder)object2).toString());
            object2.setInt(1, a5.k);
            int n2 = 0;
            int n3 = n2;
            while (n3 < a42.size()) {
                int n4 = n2 + 2;
                Object e2 = a42.get(n2);
                object2.setInt(n4, (Integer)e2);
                n3 = ++n2;
            }
            Object object3 = object2;
            string3 = object3.toString();
            object3.executeUpdate();
            object2.close();
            if (a2 == null) {
                return;
            }
            Object object4 = new StringBuilder(MapleDiseaseValueHolder.ALLATORIxDEMO("j9p2q#\u0003>m#lWC\u001eM\u0001F\u0019W\u0018Q\u000eJ\u0003F\u001aP\u0017\u0003_"));
            ((StringBuilder)object4).append(a5.K ? Eval.ALLATORIxDEMO("%<'01106 ") : MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014K\u0016Q\u0016@\u0003F\u0005J\u0013"));
            if (a5 == STORAGE_EXCEED || a5 == HIRED_FISHING || a5 == HIRED_MERCHANT) {
                ((StringBuilder)object4).append(Eval.ALLATORIxDEMO("h\u007f4>'4%8!6 "));
            }
            if (a5 == INVENTORY || a5 == STORAGE || a5 == STORAGE_EXCEED || a5 == CASHSHOP_CYGNUS || a5 == CASHSHOP_EXPLORER || a5 == CASHSHOP_ARAN || a5 == CASHSHOP_EVAN || a5 == CASHSHOP_DB || a5 == CASHSHOP_RESIST) {
                ((StringBuilder)object4).append(MapleDiseaseValueHolder.ALLATORIxDEMO("[\u0003\u0000L\u0005O\u0013"));
            }
            ((StringBuilder)object4).append(Eval.ALLATORIxDEMO("sd60:)6 sd6*)!1006&0&4:h\u007f407606+1h\u007f5*%1060&h\u007f+(*:6sd\u0018\t\u0000\b0#sd**65*!6 sd:</--!;%+!sd9(>#sd?0&4:$sd,!1 :6sd:5*-/\u000b1(&\r;m\u007f\u0012\u001e\b\n\u0001\fdw{sd`h\u007f{sd`h\u007f{sd`h\u007f{sd`h\u007f{sd`h\u007f{sd`h\u007f{"));
            if (a5 == STORAGE_EXCEED || a5 == HIRED_FISHING || a5 == HIRED_MERCHANT) {
                ((StringBuilder)object4).append(MapleDiseaseValueHolder.ALLATORIxDEMO("[\u0003H"));
            }
            if (a5 == INVENTORY || a5 == STORAGE || a5 == STORAGE_EXCEED || a5 == CASHSHOP_CYGNUS || a5 == CASHSHOP_EXPLORER || a5 == CASHSHOP_ARAN || a5 == CASHSHOP_EVAN || a5 == CASHSHOP_DB || a5 == CASHSHOP_RESIST) {
                ((StringBuilder)object4).append(Eval.ALLATORIxDEMO("h\u007f{"));
            }
            ((StringBuilder)object4).append(MapleDiseaseValueHolder.ALLATORIxDEMO("^"));
            object2 = a32.prepareStatement(((StringBuilder)object4).toString(), 1);
            object4 = "";
            int n5 = 30;
            int n6 = 0;
            int n7 = n6;
            while (n7 < n5) {
                object4 = n6 == n5 - 1 ? (String)object4 + "?" : (String)object4 + "?, ";
                n7 = ++n6;
            }
            PreparedStatement preparedStatement = a32.prepareStatement("INSERT INTO `inventoryequipment` VALUES (DEFAULT, " + (String)object4 + ")", 1);
            a2 = a2.iterator();
            while (a2.hasNext()) {
                Object object5;
                Object object6;
                block27: {
                    block25: {
                        int n8;
                        a32 = (Pair)a2.next();
                        object4 = (IItem)((Pair)a32).getLeft();
                        a32 = (MapleInventoryType)((Object)((Pair)a32).getRight());
                        n5 = 1;
                        int n9 = n8 = 0;
                        while (n9 < a42.size()) {
                            object2.setInt(n5++, (Integer)a42.get(n8));
                            n9 = ++n8;
                        }
                        if (a5 == INVENTORY) {
                            object2.setInt(n5, 0);
                            ++n5;
                        }
                        Object object7 = object2;
                        object7.setInt(n5, object4.getItemId());
                        object7.setInt(++n5, ((MapleInventoryType)((Object)a32)).getType());
                        object7.setInt(++n5, object4.getPosition());
                        object7.setInt(++n5, object4.getQuantity());
                        object7.setString(++n5, object4.getOwner());
                        object7.setString(++n5, object4.getGMLog());
                        object7.setInt(++n5, object4.getUniqueId());
                        object7.setLong(++n5, object4.getExpiration());
                        object7.setInt(++n5, object4.getFlag());
                        int n10 = ++n5;
                        object7.setByte(n10, (byte)a5.k);
                        object7.setString(++n5, object4.getGiftFrom());
                        object7.setLong(++n5, object4.getEquipOnlyId());
                        ++n5;
                        object7.executeUpdate();
                        if (!((Enum)a32).equals((Object)MapleInventoryType.EQUIP) && !((Enum)a32).equals((Object)MapleInventoryType.EQUIPPED)) continue;
                        n5 = 1;
                        object6 = object2.getGeneratedKeys();
                        try {
                            if (!object6.next()) {
                                FileoutputUtil.printError(Eval.ALLATORIxDEMO("7>2:\r+!27q0'0"), new Throwable(), "\u3000\u5beb\u5165\u7269\u54c1\u5931\u6557(" + a5.a + ")");
                                throw new RuntimeException(MapleDiseaseValueHolder.ALLATORIxDEMO("\u3023\u5b9c\u5146\u721e\u54e2\u5946\u6574Y"));
                            }
                            preparedStatement.setLong(n5++, object6.getLong(1));
                            if (object6 == null) break block25;
                            object5 = object4;
                        }
                        catch (Throwable throwable) {
                            Throwable throwable2;
                            block26: {
                                if (object6 != null) {
                                    try {
                                        object6.close();
                                        throwable2 = throwable;
                                        break block26;
                                    }
                                    catch (Throwable a32) {
                                        throwable.addSuppressed(a32);
                                    }
                                }
                                throwable2 = throwable;
                            }
                            throw throwable2;
                        }
                        object6.close();
                        break block27;
                    }
                    object5 = object4;
                }
                object6 = (IEquip)object5;
                PreparedStatement preparedStatement2 = preparedStatement;
                preparedStatement2.setInt(n5, object6.getUpgradeSlots());
                preparedStatement2.setInt(++n5, object6.getLevel());
                preparedStatement2.setInt(++n5, object6.getStr());
                preparedStatement2.setInt(++n5, object6.getDex());
                preparedStatement2.setInt(++n5, object6.getInt());
                preparedStatement2.setInt(++n5, object6.getLuk());
                preparedStatement2.setInt(++n5, object6.getHp());
                preparedStatement2.setInt(++n5, object6.getMp());
                preparedStatement2.setInt(++n5, object6.getWatk());
                preparedStatement2.setInt(++n5, object6.getMatk());
                preparedStatement2.setInt(++n5, object6.getWdef());
                preparedStatement2.setInt(++n5, object6.getMdef());
                preparedStatement2.setInt(++n5, object6.getAcc());
                preparedStatement2.setInt(++n5, object6.getAvoid());
                preparedStatement2.setInt(++n5, object6.getHands());
                preparedStatement2.setInt(++n5, object6.getSpeed());
                preparedStatement2.setInt(++n5, object6.getJump());
                preparedStatement2.setInt(++n5, object6.getViciousHammer());
                preparedStatement2.setInt(++n5, object6.getItemEXP());
                preparedStatement2.setInt(++n5, object6.getDurability());
                preparedStatement2.setByte(++n5, object6.getEnhance());
                preparedStatement2.setInt(++n5, object6.getPotential1());
                preparedStatement2.setInt(++n5, object6.getPotential2());
                preparedStatement2.setInt(++n5, object6.getPotential3());
                preparedStatement2.setInt(++n5, object6.getIncSkill());
                preparedStatement2.setInt(++n5, object6.getHpR());
                preparedStatement2.setInt(++n5, object6.getMpR());
                preparedStatement2.setShort(++n5, object6.getCharmEXP());
                preparedStatement2.setShort(++n5, object6.getPVPDamage());
                ++n5;
                string = preparedStatement2.toString();
                string2 = object2.toString();
                preparedStatement2.executeUpdate();
            }
            preparedStatement.close();
            object2.close();
            return;
        }
        catch (Exception a42) {
            System.out.println("\u547d\u4ee4:" + string3);
            System.out.println("\u547d\u4ee42:" + string2);
            System.out.println("\u547d\u4ee43:" + string);
            System.out.println("size:" + object.toString() + "  " + a5);
            a42.printStackTrace();
            FileoutputUtil.logToFile(Eval.ALLATORIxDEMO("3+87p\u8c83\u65c6\u5eef\u752f\u5e7cq0'0"), a42 + "\r\n\u547d\u4ee4:" + string3 + "\r\n\u547d\u4ee42:" + string2 + "\r\n\u547d\u4ee43:" + string);
            return;
        }
    }

    private /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> ALLATORIxDEMO(boolean a2, int a3, int a4) throws SQLException {
        ItemLoader a5;
        return a5.ALLATORIxDEMO(a2, a3, a4, -1);
    }

    public /* synthetic */ void saveItemsNew(List<Pair<IItem, MapleInventoryType>> a2, Connection a3, int a4, int a5) throws SQLException {
        ItemLoader a6;
        a6.saveItemsNew(a2, a3, a4, a5, -1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void saveItemsNew(List<Pair<IItem, MapleInventoryType>> a2, Connection a3, int a4, int a5, int a62) throws SQLException {
        Object object;
        long l2;
        block17: {
            l2 = System.currentTimeMillis();
            object = null;
            try {
                int n2;
                PreparedStatement preparedStatement;
                HashMap<String, Object> a62;
                block18: {
                    PreparedStatement preparedStatement2;
                    block19: {
                        block16: {
                            Object object2;
                            Object object3;
                            ItemLoader a7;
                            object = a7.name();
                            if (a62 != -1) {
                                object = a7.name() + "_" + a62;
                            }
                            a62 = new HashMap<String, Object>();
                            preparedStatement = a3.prepareStatement("select id from inventoryitems_json_key where " + (a7.K ? Eval.ALLATORIxDEMO("%<'01106 ") : MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014K\u0016Q\u0016@\u0003F\u0005J\u0013")) + " = ? AND (function = ?) LIMIT 1");
                            preparedStatement.setInt(1, a7.K ? a5 : a4);
                            PreparedStatement preparedStatement3 = preparedStatement;
                            preparedStatement3.setString(2, (String)object);
                            Object object4 = preparedStatement3.executeQuery();
                            n2 = -1;
                            if (object4.next()) {
                                n2 = object4.getInt(Eval.ALLATORIxDEMO("6 "));
                            }
                            object4.close();
                            preparedStatement.close();
                            if (a2 == null) {
                                return;
                            }
                            a2 = a2.iterator();
                            int n3 = 1;
                            Iterator iterator = a2;
                            while (iterator.hasNext()) {
                                object4 = (Pair)a2.next();
                                object3 = (IItem)((Pair)object4).getLeft();
                                object2 = new HashMap<String, Number>();
                                MapleInventoryType mapleInventoryType = (MapleInventoryType)((Object)((Pair)object4).getRight());
                                object2.put(ItemLoaderType.INVENTORYITEMID.getValueString(), object3.getInventoryitemId());
                                object2.put(ItemLoaderType.ITEMID.getValueString(), object3.getItemId());
                                object2.put(ItemLoaderType.INVENTORYTYPE.getValueString(), mapleInventoryType.getType());
                                object2.put(ItemLoaderType.POSITION.getValueString(), object3.getPosition());
                                object2.put(ItemLoaderType.QUANTITY.getValueString(), object3.getQuantity());
                                object2.put(ItemLoaderType.OWNER.getValueString(), object3.getOwner());
                                object2.put(ItemLoaderType.GM_LOG.getValueString(), object3.getGMLog());
                                object2.put(ItemLoaderType.UNIQUEID.getValueString(), object3.getUniqueId());
                                object2.put(ItemLoaderType.EXPIREDATE.getValueString(), object3.getExpiration());
                                object2.put(ItemLoaderType.FLAG.getValueString(), object3.getFlag());
                                object2.put(ItemLoaderType.CUSTOMFLAG.getValueString(), object3.getCustomFlag());
                                object2.put(ItemLoaderType.TYPE.getValueString(), object3.getType());
                                object2.put(ItemLoaderType.SENDER.getValueString(), object3.getGiftFrom());
                                object2.put(ItemLoaderType.EQUIPONLYID.getValueString(), object3.getEquipOnlyId());
                                if (mapleInventoryType.equals((Object)MapleInventoryType.EQUIP) || mapleInventoryType.equals((Object)MapleInventoryType.EQUIPPED)) {
                                    object4 = (IEquip)object3;
                                    object2.put(ItemLoaderType.UPGRADESLOTS.getValueString(), object4.getUpgradeSlots());
                                    object2.put(ItemLoaderType.LEVEL.getValueString(), object4.getLevel());
                                    object2.put(ItemLoaderType.STR.getValueString(), object4.getStr());
                                    object2.put(ItemLoaderType.DEX.getValueString(), object4.getDex());
                                    object2.put(ItemLoaderType.INT.getValueString(), object4.getInt());
                                    object2.put(ItemLoaderType.LUK.getValueString(), object4.getLuk());
                                    object2.put(ItemLoaderType.HP.getValueString(), object4.getHp());
                                    object2.put(ItemLoaderType.MP.getValueString(), object4.getMp());
                                    object2.put(ItemLoaderType.WATK.getValueString(), object4.getWatk());
                                    object2.put(ItemLoaderType.MATK.getValueString(), object4.getMatk());
                                    object2.put(ItemLoaderType.WDEF.getValueString(), object4.getWdef());
                                    object2.put(ItemLoaderType.MDEF.getValueString(), object4.getMdef());
                                    object2.put(ItemLoaderType.ACC.getValueString(), object4.getAcc());
                                    object2.put(ItemLoaderType.AVOID.getValueString(), object4.getAvoid());
                                    object2.put(ItemLoaderType.HANDS.getValueString(), object4.getHands());
                                    object2.put(ItemLoaderType.SPEED.getValueString(), object4.getSpeed());
                                    object2.put(ItemLoaderType.JUMP.getValueString(), object4.getJump());
                                    object2.put(ItemLoaderType.VICIOUSHAMMER.getValueString(), object4.getViciousHammer());
                                    object2.put(ItemLoaderType.ITEMEXP.getValueString(), object4.getItemEXP());
                                    object2.put(ItemLoaderType.DURABILITY.getValueString(), object4.getDurability());
                                    object2.put(ItemLoaderType.ENHANCE.getValueString(), object4.getEnhance());
                                    object2.put(ItemLoaderType.POTENTIAL1.getValueString(), object4.getPotential1());
                                    object2.put(ItemLoaderType.POTENTIAL2.getValueString(), object4.getPotential2());
                                    object2.put(ItemLoaderType.POTENTIAL3.getValueString(), object4.getPotential3());
                                    object2.put(ItemLoaderType.POTENTIAL4.getValueString(), object4.getPotential4());
                                    object2.put(ItemLoaderType.POTENTIAL5.getValueString(), object4.getPotential5());
                                    object2.put(ItemLoaderType.INCSKILL.getValueString(), object4.getIncSkill());
                                    object2.put(ItemLoaderType.HPR.getValueString(), object4.getHpR());
                                    object2.put(ItemLoaderType.MPR.getValueString(), object4.getMpR());
                                    object2.put(ItemLoaderType.CHARMEXP.getValueString(), object4.getCharmEXP());
                                    object2.put(ItemLoaderType.PVPDAMAGE.getValueString(), object4.getPVPDamage());
                                }
                                String string = "itemdata" + n3;
                                ItemLoader itemLoader = a7;
                                ++n3;
                                a62.put(string, itemLoader.compressA(itemLoader.MapToJsonItem((Map<String, Object>)object2)));
                                iterator = a2;
                            }
                            if (GameSetConstants.DEBUG_DC && (object3 = MapleCharacter.getOnlineCharacterById(a4)) != null && ((MapleCharacter)object3).isGM()) {
                                System.out.println("saveItemsNew-1:" + (System.currentTimeMillis() - l2));
                                l2 = System.currentTimeMillis();
                            }
                            if (n2 != -1) break block18;
                            PreparedStatement preparedStatement4 = preparedStatement = a3.prepareStatement(MapleDiseaseValueHolder.ALLATORIxDEMO(">m$f%wWj9w8\u0003\u0017J\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004|\u001dP\u0018M(H\u0012Z\u0017\u0003_C\u001eG\u0017\u000fWC\u0016@\u0014L\u0002M\u0003J\u0013C[\u0003\u0017@\u001fB\u0005B\u0014W\u0012Q\u001eG\u0017\u000fWC\u0011V\u0019@\u0003J\u0018M\u0017\nWU\u0016O\u0002F\u0004\u0003_g2e6v;w[\u001c[\u001c[\u001c^"), 1);
                            preparedStatement.setInt(1, a5);
                            preparedStatement4.setInt(2, a4);
                            preparedStatement4.setString(3, (String)object);
                            preparedStatement4.executeUpdate();
                            object3 = preparedStatement.getGeneratedKeys();
                            try {
                                if (!object3.next()) {
                                    throw new RuntimeException(Eval.ALLATORIxDEMO("\u305f\u5baf\u513a\u722d\u549e\u5975\u6508j"));
                                }
                                Object object5 = object2 = a3.prepareStatement(MapleDiseaseValueHolder.ALLATORIxDEMO(">m$f%wWj9w8\u0003\u0017J\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004|\u001dP\u0018M\u0017\u0003_C\u001eG\u0017\u000f\u0017J\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004|\u001dP\u0018M(J\u0013C[C\u001dP\u0018M\u0017\nWU\u0016O\u0002F\u0004\u0003_g2e6v;w[\u001c[\u001c^"));
                                object5.setInt(1, object3.getInt(1));
                                object5.setString(2, JsonMapConverter.MapToJsonItem(a62));
                                object5.executeUpdate();
                                object2.close();
                                object3.close();
                                if (object3 == null) break block16;
                                preparedStatement2 = preparedStatement;
                            }
                            catch (Throwable throwable) {
                                Throwable throwable2;
                                if (object3 != null) {
                                    try {
                                        object3.close();
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
                            object3.close();
                            break block19;
                        }
                        preparedStatement2 = preparedStatement;
                    }
                    preparedStatement2.close();
                    break block17;
                }
                PreparedStatement preparedStatement5 = preparedStatement = a3.prepareStatement(Eval.ALLATORIxDEMO("\n\u0014\u001b\u0005\u000b\u0001\u007f$6*)!1006&-+!27\u0000.,+1$\u007f\u0017\u001a\u0010\u007f.,+1dbd`d\b\f\u001a\u0016\u001ad6*)!1006&-+!27\u0000.,+1\u001b6 \u007fy\u007f{"));
                preparedStatement5.setString(1, JsonMapConverter.MapToJsonItem(a62));
                preparedStatement.setInt(2, n2);
                preparedStatement5.executeUpdate();
                preparedStatement.close();
            }
            catch (SQLException sQLException) {
                sQLException.printStackTrace();
                FileoutputUtil.logToFile(MapleDiseaseValueHolder.ALLATORIxDEMO("O\u0018D\u0004\f\u65c7j#f:\u4ffe\u5b2f\u7553\u5e4f\r\u0003[\u0003"), sQLException.getMessage());
            }
        }
        if (!GameSetConstants.DEBUG_DC) return;
        object = MapleCharacter.getOnlineCharacterById(a4);
        if (object == null) return;
        if (!((MapleCharacter)object).isGM()) return;
        System.out.println("saveItemsNew-2:" + (System.currentTimeMillis() - l2));
        l2 = System.currentTimeMillis();
    }

    public static /* synthetic */ ItemLoader[] values() {
        return (ItemLoader[])ALLATORIxDEMO.clone();
    }

    public /* synthetic */ int getValue() {
        ItemLoader a2;
        return a2.k;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> ALLATORIxDEMO(boolean a, int a, int a, int a) throws SQLException {
        var5_9 = new LinkedHashMap<Long, Pair<IItem, MapleInventoryType>>();
        var6_10 = a.name();
        if (a != -1) {
            var6_10 = a.name() + "_" + a;
        }
        try {
            block39: {
                a = DBConPool.getInstance().getDataSource().getConnection();
                v0 = var7_13 = a.prepareStatement("select id from inventoryitems_json_key where " + (a.K != false ? Eval.ALLATORIxDEMO("%<'01106 ") : MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014K\u0016Q\u0016@\u0003F\u0005J\u0013")) + " = ? AND (function = ?) LIMIT 1");
                if (!a.K) break block39;
                v1 = a;
                ** GOTO lbl16
            }
            try {
                block40: {
                    v1 = a;
lbl16:
                    // 2 sources

                    v0.setInt(1, v1);
                    v2 = var7_13;
                    v2.setString(2, (String)var6_10);
                    a = v2.executeQuery();
                    var6_11 = -1;
                    if (a.next()) {
                        var6_11 = a.getInt(Eval.ALLATORIxDEMO("6 "));
                    }
                    if (var6_11 == -1) break block40;
                    var7_13 = a.prepareStatement(MapleDiseaseValueHolder.ALLATORIxDEMO("P\u0012O\u0012@\u0003\t\u0011Q\u0018NWJ\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004|\u001dP\u0018MWT\u001fF\u0005FWJ\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004|\u001dP\u0018M(J\u0013\u0003J\u0003H"));
                    var7_13.setInt(1, var6_11);
                    a = var7_13.executeQuery();
                    var6_12 = MapleItemInformationProvider.getInstance();
                    if (!a.next() || (var8_15 = JsonMapConverter.JsonToMapItem(a.getString(Eval.ALLATORIxDEMO("570*")))) == null) break block40;
                    var8_15 = var8_15.entrySet().iterator();
                    block11: while (true) {
                        v3 = var8_15;
                        while (v3.hasNext()) {
                            block43: {
                                block41: {
                                    block42: {
                                        var9_16 = (Map.Entry)var8_15.next();
                                        if (!((String)var9_16.getKey()).contains(MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0003F\u001aG\u0016W\u0016"))) continue block11;
                                        v4 = a;
                                        if ((var9_16 = v4.JsonToMapItem(v4.uncompressA((String)var9_16.getValue()))) == null) {
                                            v3 = var8_15;
                                            continue;
                                        }
                                        var10_17 = Long.parseLong((String)var9_16.get(ItemLoaderType.UNIQUEID.getValueString()));
                                        if (var10_17 > 0x7FFFFFFFL) {
                                            var9_16.remove(ItemLoaderType.UNIQUEID.getValueString());
                                            var9_16.put(ItemLoaderType.UNIQUEID.getValueString(), String.valueOf(var10_17 -= 100000000L));
                                        }
                                        if ((var10_17 = Long.parseLong((String)var9_16.get(ItemLoaderType.INVENTORYITEMID.getValueString()))) <= 0L) {
                                            var10_17 = MapleInventoryIdentifier.getInstance();
                                        }
                                        if (!var6_12.itemExists(Integer.parseInt((String)var9_16.get(ItemLoaderType.ITEMID.getValueString())))) {
                                            v3 = var8_15;
                                            continue;
                                        }
                                        var12_18 = MapleInventoryType.getByType(Byte.parseByte((String)var9_16.get(ItemLoaderType.INVENTORYTYPE.getValueString())));
                                        if (a && !var12_18.equals((Object)MapleInventoryType.EQUIPPED)) {
                                            v3 = var8_15;
                                            continue;
                                        }
                                        if (var12_18.equals((Object)MapleInventoryType.EQUIP) || var12_18.equals((Object)MapleInventoryType.EQUIPPED)) {
                                            var13_19 = new Equip(Integer.parseInt((String)var9_16.get(ItemLoaderType.ITEMID.getValueString())), Short.parseShort((String)var9_16.get(ItemLoaderType.POSITION.getValueString())), Integer.parseInt((String)var9_16.get(ItemLoaderType.UNIQUEID.getValueString())), Integer.parseInt((String)var9_16.get(ItemLoaderType.FLAG.getValueString())));
                                            if (!a) {
                                                v5 = var13_19;
                                                v5.setQuantity((short)1);
                                                v5.setOwner((String)var9_16.get(ItemLoaderType.OWNER.getValueString()));
                                                var13_19.setCustomFlag(Integer.parseInt(var9_16.get(ItemLoaderType.CUSTOMFLAG.getValueString()) == null ? Eval.ALLATORIxDEMO("t") : (String)var9_16.get(ItemLoaderType.CUSTOMFLAG.getValueString())));
                                                var13_19.setInventoryitemId(var10_17);
                                                var14_20 = Long.parseLong((String)var9_16.get(ItemLoaderType.EXPIREDATE.getValueString()));
                                                var13_19.setExpiration(var14_20 > 4000000000000L ? -1L : var14_20);
                                                var13_19.setUpgradeSlots(Byte.parseByte((String)var9_16.get(ItemLoaderType.UPGRADESLOTS.getValueString())));
                                                var13_19.setLevel(Byte.parseByte((String)var9_16.get(ItemLoaderType.LEVEL.getValueString())));
                                                var13_19.setStr(Short.parseShort((String)var9_16.get(ItemLoaderType.STR.getValueString())));
                                                var13_19.setDex(Short.parseShort((String)var9_16.get(ItemLoaderType.DEX.getValueString())));
                                                var13_19.setInt(Short.parseShort((String)var9_16.get(ItemLoaderType.INT.getValueString())));
                                                var13_19.setLuk(Short.parseShort((String)var9_16.get(ItemLoaderType.LUK.getValueString())));
                                                var13_19.setHp(Short.parseShort((String)var9_16.get(ItemLoaderType.HP.getValueString())));
                                                var13_19.setMp(Short.parseShort((String)var9_16.get(ItemLoaderType.MP.getValueString())));
                                                var13_19.setWatk(Short.parseShort((String)var9_16.get(ItemLoaderType.WATK.getValueString())));
                                                var13_19.setMatk(Short.parseShort((String)var9_16.get(ItemLoaderType.MATK.getValueString())));
                                                var13_19.setWdef(Short.parseShort((String)var9_16.get(ItemLoaderType.WDEF.getValueString())));
                                                var13_19.setMdef(Short.parseShort((String)var9_16.get(ItemLoaderType.MDEF.getValueString())));
                                                var13_19.setAcc(Short.parseShort((String)var9_16.get(ItemLoaderType.ACC.getValueString())));
                                                var13_19.setAvoid(Short.parseShort((String)var9_16.get(ItemLoaderType.AVOID.getValueString())));
                                                var13_19.setHands(Short.parseShort((String)var9_16.get(ItemLoaderType.HANDS.getValueString())));
                                                var13_19.setSpeed(Short.parseShort((String)var9_16.get(ItemLoaderType.SPEED.getValueString())));
                                                var13_19.setJump(Short.parseShort((String)var9_16.get(ItemLoaderType.JUMP.getValueString())));
                                                var13_19.setViciousHammer(Byte.parseByte((String)var9_16.get(ItemLoaderType.VICIOUSHAMMER.getValueString())));
                                                var13_19.setItemEXP(Integer.parseInt((String)var9_16.get(ItemLoaderType.ITEMEXP.getValueString())));
                                                var13_19.setGMLog((String)var9_16.get(ItemLoaderType.GM_LOG.getValueString()));
                                                var13_19.setDurability(Integer.parseInt((String)var9_16.get(ItemLoaderType.DURABILITY.getValueString())));
                                                var13_19.setEnhance(Byte.parseByte((String)var9_16.get(ItemLoaderType.ENHANCE.getValueString())));
                                                var13_19.setEquipOnlyId(Long.parseLong((String)var9_16.get(ItemLoaderType.EQUIPONLYID.getValueString())));
                                                var13_19.setIncSkill(Integer.parseInt((String)var9_16.get(ItemLoaderType.INCSKILL.getValueString())));
                                                var13_19.setHpR(Short.parseShort((String)var9_16.get(ItemLoaderType.HPR.getValueString())));
                                                var13_19.setMpR(Short.parseShort((String)var9_16.get(ItemLoaderType.MPR.getValueString())));
                                                var13_19.setGiftFrom((String)var9_16.get(ItemLoaderType.SENDER.getValueString()));
                                                var13_19.setPotential1(Integer.parseInt((String)var9_16.get(ItemLoaderType.POTENTIAL1.getValueString())));
                                                var13_19.setPotential2(Integer.parseInt((String)var9_16.get(ItemLoaderType.POTENTIAL2.getValueString())));
                                                var13_19.setPotential3(Integer.parseInt((String)var9_16.get(ItemLoaderType.POTENTIAL3.getValueString())));
                                                var13_19.setPotential4(Integer.parseInt(var9_16.get(ItemLoaderType.POTENTIAL4.getValueString()) == null ? MapleDiseaseValueHolder.ALLATORIxDEMO("G") : (String)var9_16.get(ItemLoaderType.POTENTIAL4.getValueString())));
                                                var13_19.setPotential5(Integer.parseInt(var9_16.get(ItemLoaderType.POTENTIAL4.getValueString()) == null ? Eval.ALLATORIxDEMO("t") : (String)var9_16.get(ItemLoaderType.POTENTIAL5.getValueString())));
                                                var13_19.setPVPDamage(Short.parseShort((String)var9_16.get(ItemLoaderType.PVPDAMAGE.getValueString())));
                                                var13_19.setCharmEXP(Short.parseShort((String)var9_16.get(ItemLoaderType.CHARMEXP.getValueString())));
                                                if (var13_19.getCharmEXP() < 0) {
                                                    v6 = var13_19;
                                                    v6.setCharmEXP(((Equip)var6_12.getEquipById(v6.getItemId())).getCharmEXP());
                                                }
                                                if (var13_19.getUniqueId() > -1) {
                                                    if (GameConstants.isEffectRing(Integer.parseInt((String)var9_16.get(ItemLoaderType.ITEMID.getValueString())))) {
                                                        var16_26 = MapleRing.loadFromDb(var13_19.getUniqueId(), var12_18.equals((Object)MapleInventoryType.EQUIPPED));
                                                        if (var16_26 != null) {
                                                            var13_19.setRing(var16_26);
                                                        }
                                                    } else if (var13_19.getItemId() / 10000 == 166 && GameSetConstants.MAPLE_VERSION >= 134 && (var16_27 = MapleAndroid.loadFromDb(var13_19.getItemId(), var13_19.getUniqueId())) != null) {
                                                        var13_19.setAndroid(var16_27);
                                                    }
                                                } else if (MapleItemInformationProvider.getInstance().isCash(Integer.parseInt((String)var9_16.get(ItemLoaderType.ITEMID.getValueString()))) && var13_19.getUniqueId() == -1) {
                                                    var16_28 = MapleInventoryIdentifier.getInstance();
                                                    var13_19.setUniqueId(var16_28);
                                                }
                                                if (var13_19.hasSetOnlyId()) {
                                                    var13_19.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
                                                }
                                            }
                                            if (var5_9.containsKey(var10_17)) {
                                                v7 = var13_19;
                                                v7.setInventoryitemId(MapleInventoryIdentifier.getInstance());
                                                var10_17 = v7.getInventoryitemId();
                                            }
                                            var5_9.put(var10_17, new Pair<IItem, MapleInventoryType>(var13_19.copy(), var12_18));
                                            continue block11;
                                        }
                                        var13_19 = new Item(Integer.parseInt((String)var9_16.get(ItemLoaderType.ITEMID.getValueString())), Short.parseShort((String)var9_16.get(ItemLoaderType.POSITION.getValueString())), Short.parseShort((String)var9_16.get(ItemLoaderType.QUANTITY.getValueString())), Integer.parseInt((String)var9_16.get(ItemLoaderType.FLAG.getValueString())));
                                        var13_19.setUniqueId(Integer.parseInt((String)var9_16.get(ItemLoaderType.UNIQUEID.getValueString())));
                                        var13_19.setOwner((String)var9_16.get(ItemLoaderType.OWNER.getValueString()));
                                        var13_19.setCustomFlag(Integer.parseInt(var9_16.get(ItemLoaderType.CUSTOMFLAG.getValueString()) == null ? MapleDiseaseValueHolder.ALLATORIxDEMO("G") : (String)var9_16.get(ItemLoaderType.CUSTOMFLAG.getValueString())));
                                        v8 = var13_19;
                                        v8.setInventoryitemId(var10_17);
                                        v8.setExpiration(Long.parseLong((String)var9_16.get(ItemLoaderType.EXPIREDATE.getValueString())));
                                        var13_19.setGMLog((String)var9_16.get(ItemLoaderType.GM_LOG.getValueString()));
                                        var13_19.setGiftFrom((String)var9_16.get(ItemLoaderType.SENDER.getValueString()));
                                        if (!GameConstants.isPet(var13_19.getItemId())) break block41;
                                        if (var13_19.getUniqueId() <= -1) break block42;
                                        var14_21 = MaplePet.loadFromDb(var13_19.getItemId(), var13_19.getUniqueId(), var13_19.getPosition());
                                        if (var14_21 != null) {
                                            var13_19.setPet(var14_21);
                                        } else {
                                            var15_25 = MapleInventoryIdentifierPet.getInstance();
                                            v9 = var13_19;
                                            v9.setUniqueId(v9.getUniqueId());
                                            v9.setPet(MaplePet.createPet(v9.getItemId(), var13_19.getUniqueId()));
                                        }
                                        break block43;
                                    }
                                    var14_22 = MapleInventoryIdentifierPet.getInstance();
                                    v10 = var5_9;
                                    v11 = var13_19;
                                    v11.setUniqueId(var14_22);
                                    v11.setPet(MaplePet.createPet(v11.getItemId(), var14_22));
                                    ** GOTO lbl156
                                }
                                if (ItemConstants.isExpChair(var13_19.getItemId()) && var13_19.getUniqueId() <= -1) {
                                    var14_23 = MapleInventoryIdentifier.getInstance();
                                    var13_19.setUniqueId(var14_23);
                                }
                            }
                            try {
                                v10 = var5_9;
lbl156:
                                // 2 sources

                                if (v10.containsKey(var10_17)) {
                                    v12 = var13_19;
                                    v12.setInventoryitemId(MapleInventoryIdentifier.getInstance());
                                    var10_17 = v12.getInventoryitemId();
                                }
                                var5_9.put(var10_17, new Pair<IItem, MapleInventoryType>(var13_19.copy(), var12_18));
                            }
                            catch (Exception var14_24) {
                                var14_24.printStackTrace();
                            }
                            continue block11;
                        }
                        break;
                    }
                }
                a.close();
                var7_13.close();
                ** if (a == null) goto lbl-1000
            }
            catch (Throwable var7_14) {
                if (a != null) {
                    try {
                        a.close();
                        v13 = var7_14;
                        throw v13;
                    }
                    catch (Throwable a) {
                        var7_14.addSuppressed(a);
                    }
                }
                v13 = var7_14;
                throw v13;
            }
lbl-1000:
            // 1 sources

            {
                a.close();
            }
lbl-1000:
            // 2 sources

            {
            }
        }
        catch (SQLException a) {
            a.printStackTrace();
            FileoutputUtil.outError(Eval.ALLATORIxDEMO("3+87p\u8c83\u65c6\u5eef\u752f\u5e7cq0'0"), a);
        }
        if (GameSetConstants.CHECK_COPYITEM == false) return var5_9;
        if (a != false) return var5_9;
        if (a != ItemLoader.INVENTORY) return var5_9;
        return CheckCopyItem.checkContainItems(a, var5_9);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> loadItems(boolean a2, boolean a32, boolean a4, Integer ... a2222) throws SQLException {
        Map<Long, Pair<IItem, MapleInventoryType>> a2222;
        ItemLoader a5;
        List<Integer> a32;
        block32: {
            StringBuilder stringBuilder;
            ItemLoader itemLoader;
            int n2;
            ItemLoader itemLoader2;
            int n3;
            a32 = Arrays.asList(a2222);
            int a2222 = 0;
            if (a5 == HIRED_MERCHANT) {
                a2222 = 1;
            }
            if (a5.K) {
                n3 = 0;
                itemLoader2 = a5;
            } else {
                n3 = a32.get(0);
                itemLoader2 = a5;
            }
            if (itemLoader2.K) {
                n2 = a32.get(a2222);
                itemLoader = a5;
            } else {
                n2 = 0;
                itemLoader = a5;
            }
            a2222 = a5.ALLATORIxDEMO(a4, n3, n2, itemLoader == STORAGE_EXCEED ? a32.get(1) : -1);
            if (GameSetConstants.NEW_ITEM_SAVE) {
                return a2222;
            }
            a2222 = new LinkedHashMap<Long, Pair<IItem, MapleInventoryType>>();
            if ((a5 == HIRED_MERCHANT || a5 == STORAGE || a5 == CASHSHOP_RESIST || a5 == CASHSHOP_CYGNUS || a5 == CASHSHOP_EXPLORER || a5 == CASHSHOP_ARAN || a5 == CASHSHOP_EVAN || a5 == CASHSHOP_DB) && a32.size() != 2) {
                return a2222;
            }
            if (a5 == STORAGE_EXCEED && a32.size() != 3) {
                return a2222;
            }
            StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
            stringBuilder2.append(Eval.ALLATORIxDEMO("\u0017\u001a\b\u001a\u0007\u000bdud\u0019\u0016\u0010\t\u007f$"));
            stringBuilder2.append(a2 ? a5.a : MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004"));
            stringBuilder.append(Eval.ALLATORIxDEMO("$\u007f\b\u001a\u0002\u000bd\u0015\u000b\u0016\n\u007f$"));
            stringBuilder.append(a2 ? a5.d : MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0019U\u0012M\u0003L\u0005Z\u0012R\u0002J\u0007N\u0012M\u0003"));
            stringBuilder.append(Eval.ALLATORIxDEMO("$\u007f\u0011\f\r\u0011\u0003w$6*)!1006&-+!2-;$vd\b\f\u001a\u0016\u001ad?0&4:$\u007fy\u007f{\u007f\u0005\u0011\u0000\u007f$"));
            stringBuilder.append(a5.K ? MapleDiseaseValueHolder.ALLATORIxDEMO("\u0016@\u0014L\u0002M\u0003J\u0013") : Eval.ALLATORIxDEMO("'7%-%<0:66 "));
            stringBuilder.append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0017\u0003J\u0003H"));
            if (a5 == STORAGE_EXCEED || a5 == HIRED_FISHING || a5 == HIRED_MERCHANT) {
                stringBuilder.append(Eval.ALLATORIxDEMO("\u007f\u0005\u0011\u0000\u007f$/%</>#:-;$\u007fy\u007f{"));
            }
            if (a5 == STORAGE || a5 == STORAGE_EXCEED || a5 == CASHSHOP_RESIST || a5 == CASHSHOP_CYGNUS || a5 == CASHSHOP_EXPLORER || a5 == CASHSHOP_ARAN || a5 == CASHSHOP_EVAN || a5 == CASHSHOP_DB) {
                stringBuilder.append(MapleDiseaseValueHolder.ALLATORIxDEMO("\u00036m3\u0003\u0017T\u0018Q\u001bG\u0017\u0003J\u0003H"));
            }
            if (a4) {
                stringBuilder.append(Eval.ALLATORIxDEMO("d\u001e\n\u001bd?-12:*++-=+=/!?dbd"));
                stringBuilder.append(MapleInventoryType.EQUIPPED.getType());
            }
            try {
                DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    int n4;
                    PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(stringBuilder.toString());
                    preparedStatement.setInt(1, a5.k);
                    int n5 = n4 = 0;
                    while (n5 < a32.size()) {
                        int n6 = n4 + 2;
                        Integer n7 = a32.get(n4);
                        preparedStatement.setInt(n6, n7);
                        n5 = ++n4;
                    }
                    ResultSet resultSet = preparedStatement.executeQuery();
                    MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                    block7: while (true) {
                        ResultSet resultSet2 = resultSet;
                        while (resultSet2.next()) {
                            Map<Long, Pair<IItem, MapleInventoryType>> map;
                            Item item2;
                            MapleInventoryType mapleInventoryType;
                            block40: {
                                block39: {
                                    block37: {
                                        block38: {
                                            block33: {
                                                Map<Long, Pair<IItem, MapleInventoryType>> map2;
                                                block36: {
                                                    block34: {
                                                        block35: {
                                                            MapleAndroid mapleAndroid;
                                                            if (!mapleItemInformationProvider.itemExists(resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0003F\u001aJ\u0013")))) {
                                                                resultSet2 = resultSet;
                                                                continue;
                                                            }
                                                            mapleInventoryType = MapleInventoryType.getByType(resultSet.getByte(Eval.ALLATORIxDEMO("-12:*++-=+=/!")));
                                                            if (!mapleInventoryType.equals((Object)MapleInventoryType.EQUIP) && !mapleInventoryType.equals((Object)MapleInventoryType.EQUIPPED)) break block33;
                                                            item2 = new Equip(resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0003F\u001aJ\u0013")), resultSet.getShort(Eval.ALLATORIxDEMO("/+,-+-0*")), resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("V\u0019J\u0006V\u0012J\u0013")), resultSet.getInt(Eval.ALLATORIxDEMO("9(>#")));
                                                            if (a4) break block34;
                                                            ResultSet resultSet3 = resultSet;
                                                            Item item3 = item2;
                                                            ResultSet resultSet4 = resultSet;
                                                            ((Equip)item2).setQuantity((short)1);
                                                            item2.setOwner(resultSet4.getString(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0018T\u0019F\u0005")));
                                                            item3.setInventoryitemId(resultSet4.getLong(Eval.ALLATORIxDEMO("-12:*++-=60:)6 ")));
                                                            long l2 = resultSet3.getLong(MapleDiseaseValueHolder.ALLATORIxDEMO("F\u000fS\u001eQ\u0012G\u0016W\u0012"));
                                                            item3.setExpiration(resultSet3.getLong(Eval.ALLATORIxDEMO(":</--!;%+!")) > 4000000000000L ? -1L : resultSet.getLong(MapleDiseaseValueHolder.ALLATORIxDEMO("F\u000fS\u001eQ\u0012G\u0016W\u0012")));
                                                            Item item4 = item2;
                                                            ResultSet resultSet5 = resultSet;
                                                            Item item5 = item2;
                                                            ResultSet resultSet6 = resultSet;
                                                            Item item6 = item2;
                                                            ResultSet resultSet7 = resultSet;
                                                            Item item7 = item2;
                                                            ResultSet resultSet8 = resultSet;
                                                            Item item8 = item2;
                                                            ResultSet resultSet9 = resultSet;
                                                            Item item9 = item2;
                                                            ResultSet resultSet10 = resultSet;
                                                            Item item10 = item2;
                                                            ResultSet resultSet11 = resultSet;
                                                            Item item11 = item2;
                                                            ((Equip)item11).setUpgradeSlots(resultSet.getByte(Eval.ALLATORIxDEMO("*486> :73++7")));
                                                            ((Equip)item11).setLevel(resultSet.getByte(MapleDiseaseValueHolder.ALLATORIxDEMO("\u001bF\u0001F\u001b")));
                                                            ((Equip)item2).setStr(resultSet11.getShort(Eval.ALLATORIxDEMO("7+6")));
                                                            ((Equip)item10).setDex(resultSet11.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0013F\u000f")));
                                                            ((Equip)item10).setInt(resultSet.getShort(Eval.ALLATORIxDEMO("-10")));
                                                            ((Equip)item2).setLuk(resultSet10.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("\u001bV\u001c")));
                                                            ((Equip)item9).setHp(resultSet10.getShort(Eval.ALLATORIxDEMO("74")));
                                                            ((Equip)item9).setMp(resultSet.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("N\u0007")));
                                                            ((Equip)item2).setWatk(resultSet9.getShort(Eval.ALLATORIxDEMO("(%+/")));
                                                            ((Equip)item8).setMatk(resultSet9.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("N\u0016W\u001c")));
                                                            ((Equip)item8).setWdef(resultSet.getShort(Eval.ALLATORIxDEMO("( :\"")));
                                                            ((Equip)item2).setMdef(resultSet8.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("N\u0013F\u0011")));
                                                            ((Equip)item7).setAcc(resultSet8.getShort(Eval.ALLATORIxDEMO("%<'")));
                                                            ((Equip)item7).setAvoid(resultSet.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0016U\u0018J\u0013")));
                                                            ((Equip)item2).setHands(resultSet7.getShort(Eval.ALLATORIxDEMO(",>*;7")));
                                                            ((Equip)item6).setSpeed(resultSet7.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0004S\u0012F\u0013")));
                                                            ((Equip)item6).setJump(resultSet.getShort(Eval.ALLATORIxDEMO("5124")));
                                                            ((Equip)item2).setViciousHammer(resultSet6.getByte(MapleDiseaseValueHolder.ALLATORIxDEMO("!J\u0014J\u0018V\u0004k\u0016N\u001aF\u0005")));
                                                            ((Equip)item5).setItemEXP(resultSet6.getInt(Eval.ALLATORIxDEMO("-+!2\u0001\u0007\u0014")));
                                                            item5.setGMLog(resultSet.getString(MapleDiseaseValueHolder.ALLATORIxDEMO("d:|;L\u0010")));
                                                            ((Equip)item2).setDurability(resultSet5.getInt(Eval.ALLATORIxDEMO(";1-%=-3-+=")));
                                                            ((Equip)item4).setEnhance(resultSet5.getByte(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0012M\u001fB\u0019@\u0012")));
                                                            item4.setEquipOnlyId(resultSet.getLong(Eval.ALLATORIxDEMO("!.164\u0010*3=\u0016 ")));
                                                            if (!a2) {
                                                                ((Equip)item2).setIncSkill(resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0019@$H\u001eO\u001b")));
                                                            }
                                                            Item item12 = item2;
                                                            ResultSet resultSet12 = resultSet;
                                                            Item item13 = item2;
                                                            ResultSet resultSet13 = resultSet;
                                                            Item item14 = item2;
                                                            ResultSet resultSet14 = resultSet;
                                                            ((Equip)item2).setHpR(resultSet14.getShort(Eval.ALLATORIxDEMO(",/\u0016")));
                                                            ((Equip)item14).setMpR(resultSet14.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("\u001aS%")));
                                                            item14.setGiftFrom(resultSet.getString(Eval.ALLATORIxDEMO(",!1 :6")));
                                                            ((Equip)item2).setPotential1(resultSet13.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("S\u0018W\u0012M\u0003J\u0016OF")));
                                                            ((Equip)item13).setPotential2(resultSet13.getInt(Eval.ALLATORIxDEMO("/++!106%3v")));
                                                            ((Equip)item13).setPotential3(resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("S\u0018W\u0012M\u0003J\u0016OD")));
                                                            ((Equip)item2).setIncSkill(resultSet12.getInt(Eval.ALLATORIxDEMO("6*<\u00174-3(")));
                                                            ((Equip)item12).setPVPDamage(resultSet12.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0007U\u0007g\u0016N\u0016D\u0012")));
                                                            ((Equip)item12).setCharmEXP(resultSet.getShort(Eval.ALLATORIxDEMO("<,>62\u0001\u0007\u0014")));
                                                            if (((Equip)item2).getCharmEXP() < 0) {
                                                                Item item15 = item2;
                                                                ((Equip)item15).setCharmEXP(((Equip)mapleItemInformationProvider.getEquipById(item15.getItemId())).getCharmEXP());
                                                            }
                                                            if (item2.getUniqueId() <= -1) break block35;
                                                            if (GameConstants.isEffectRing(resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0003F\u001aJ\u0013")))) {
                                                                MapleRing mapleRing = MapleRing.loadFromDb(item2.getUniqueId(), mapleInventoryType.equals((Object)MapleInventoryType.EQUIPPED));
                                                                if (mapleRing != null) {
                                                                    item2.setRing(mapleRing);
                                                                }
                                                            } else if (item2.getItemId() / 10000 == 166 && GameSetConstants.MAPLE_VERSION >= 134 && (mapleAndroid = MapleAndroid.loadFromDb(item2.getItemId(), item2.getUniqueId())) != null) {
                                                                ((Equip)item2).setAndroid(mapleAndroid);
                                                            }
                                                            if (!item2.hasSetOnlyId()) break block34;
                                                            map2 = a2222;
                                                            item2.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
                                                            break block36;
                                                        }
                                                        if (MapleItemInformationProvider.getInstance().isCash(resultSet.getInt(Eval.ALLATORIxDEMO("60:)6 "))) && item2.getUniqueId() == -1) {
                                                            int n8 = MapleInventoryIdentifier.getInstance();
                                                            item2.setUniqueId(n8);
                                                        }
                                                    }
                                                    map2 = a2222;
                                                }
                                                map2.put(resultSet.getLong(MapleDiseaseValueHolder.ALLATORIxDEMO("\u001eM\u0001F\u0019W\u0018Q\u000eJ\u0003F\u001aJ\u0013")), new Pair<IItem, MapleInventoryType>(((Equip)item2).copy(), mapleInventoryType));
                                                continue block7;
                                            }
                                            Item item16 = item2 = new Item(resultSet.getInt(Eval.ALLATORIxDEMO("60:)6 ")), resultSet.getShort(MapleDiseaseValueHolder.ALLATORIxDEMO("S\u0018P\u001eW\u001eL\u0019")), resultSet.getShort(Eval.ALLATORIxDEMO(".1>*+-+=")), resultSet.getInt(MapleDiseaseValueHolder.ALLATORIxDEMO("E\u001bB\u0010")));
                                            ResultSet resultSet15 = resultSet;
                                            Item item17 = item2;
                                            ResultSet resultSet16 = resultSet;
                                            item2.setUniqueId(resultSet16.getInt(Eval.ALLATORIxDEMO("**65*!6 ")));
                                            item17.setOwner(resultSet16.getString(MapleDiseaseValueHolder.ALLATORIxDEMO("\u0018T\u0019F\u0005")));
                                            item17.setInventoryitemId(resultSet.getLong(Eval.ALLATORIxDEMO("-12:*++-=60:)6 ")));
                                            item2.setExpiration(resultSet15.getLong(MapleDiseaseValueHolder.ALLATORIxDEMO("F\u000fS\u001eQ\u0012G\u0016W\u0012")));
                                            item16.setGMLog(resultSet15.getString(Eval.ALLATORIxDEMO("\u0018\t\u0000\b0#")));
                                            item16.setGiftFrom(resultSet.getString(MapleDiseaseValueHolder.ALLATORIxDEMO("P\u0012M\u0013F\u0005")));
                                            if (!GameConstants.isPet(item16.getItemId())) break block37;
                                            if (item2.getUniqueId() <= -1) break block38;
                                            MaplePet maplePet = MaplePet.loadFromDb(item2.getItemId(), item2.getUniqueId(), item2.getPosition());
                                            if (maplePet != null) {
                                                item2.setPet(maplePet);
                                            } else {
                                                int n9 = MapleInventoryIdentifierPet.getInstance();
                                                Item item18 = item2;
                                                item18.setUniqueId(item18.getUniqueId());
                                                item18.setPet(MaplePet.createPet(item18.getItemId(), item2.getUniqueId()));
                                            }
                                            break block39;
                                        }
                                        int n10 = MapleInventoryIdentifierPet.getInstance();
                                        map = a2222;
                                        Item item19 = item2;
                                        item19.setUniqueId(n10);
                                        item19.setPet(MaplePet.createPet(item19.getItemId(), n10));
                                        break block40;
                                    }
                                    if (ItemConstants.isExpChair(item2.getItemId()) && item2.getUniqueId() <= -1) {
                                        int n11 = MapleInventoryIdentifier.getInstance();
                                        item2.setUniqueId(n11);
                                    }
                                }
                                map = a2222;
                            }
                            map.put(resultSet.getLong(Eval.ALLATORIxDEMO("-12:*++-=60:)6 ")), new Pair<IItem, MapleInventoryType>(item2.copy(), mapleInventoryType));
                            continue block7;
                        }
                        break;
                    }
                    resultSet.close();
                    preparedStatement.close();
                    if (druidPooledConnection == null) break block32;
                }
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
                druidPooledConnection.close();
            }
            catch (SQLException sQLException) {
                FileoutputUtil.outError(MapleDiseaseValueHolder.ALLATORIxDEMO("O\u0018D\u0004\f\u8cb0\u65ba\u5edc\u7553\u5e4f\r\u0003[\u0003"), sQLException);
            }
        }
        if (!GameSetConstants.CHECK_COPYITEM) return a2222;
        if (a4) return a2222;
        if (a5 != INVENTORY) return a2222;
        return CheckCopyItem.checkContainItems(a32.get(0), a2222);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ String compressA(String a2222222222222) {
        if (!GameSetConstants.COMPRESS_ITEM) {
            return a2222222222222;
        }
        if (a2222222222222 == null) return a2222222222222;
        if (a2222222222222.length() == 0) {
            return a2222222222222;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(a2222222222222.getBytes());
        if (gZIPOutputStream == null) return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        try {
            gZIPOutputStream.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
        catch (IOException a2222222222222) {
            a2222222222222.printStackTrace();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
        catch (IOException a2222222222222) {
            try {
                a2222222222222.printStackTrace();
                if (gZIPOutputStream == null) return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (IOException a2222222222222) {
                        a2222222222222.printStackTrace();
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
            try {
                gZIPOutputStream.close();
                return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            }
            catch (IOException a2222222222222) {
                a2222222222222.printStackTrace();
                return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            }
        }
    }

    public /* synthetic */ boolean isAcc() {
        ItemLoader a2;
        return a2.K;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> loadItemsByJson(String a) throws SQLException {
        if (a.isEmpty()) {
            return null;
        }
        var1_1 = new LinkedHashMap<Long, Pair<IItem, MapleInventoryType>>();
        var2_2 = JsonMapConverter.JsonToMapItem(a);
        var3_3 = MapleItemInformationProvider.getInstance();
        var2_2 = var2_2.entrySet().iterator();
        block2: while (true) {
            block24: {
                block22: {
                    block23: {
                        block18: {
                            block21: {
                                block20: {
                                    block19: {
                                        block17: {
                                            v0 = var2_2;
                                            while (v0.hasNext() != false) {
                                                var4_4 = (Map.Entry)var2_2.next();
                                                if (!((String)var4_4.getKey()).contains(MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0003F\u001aG\u0016W\u0016"))) continue block2;
                                                if ((var4_4 = JsonMapConverter.JsonToMapItem(GZIPCompression.uncompressA((String)var4_4.getValue()))) != null && var4_4.get(ItemLoaderType.UNIQUEID.getValueString()) != null && StringTool.isNumeric((String)var4_4.get(ItemLoaderType.UNIQUEID.getValueString())) && (var5_5 = Long.parseLong((String)var4_4.get(ItemLoaderType.UNIQUEID.getValueString()))) > 0x7FFFFFFFL) {
                                                    var4_4.remove(ItemLoaderType.UNIQUEID.getValueString());
                                                    var4_4.put(ItemLoaderType.UNIQUEID.getValueString(), String.valueOf(var5_5 -= 100000000L));
                                                }
                                                if (var4_4 == null) continue block2;
                                                var5_5 = Long.parseLong((String)var4_4.get(ItemLoaderType.INVENTORYITEMID.getValueString()));
                                                if (var5_5 <= 0L) {
                                                    var5_5 = MapleInventoryIdentifier.getInstance();
                                                }
                                                if (!var3_3.itemExists(Integer.parseInt((String)var4_4.get(ItemLoaderType.ITEMID.getValueString())))) {
                                                    v0 = var2_2;
                                                    continue;
                                                }
                                                break block17;
                                            }
                                            return var1_1;
                                        }
                                        var7_6 = MapleInventoryType.getByType(Byte.parseByte((String)var4_4.get(ItemLoaderType.INVENTORYTYPE.getValueString())));
                                        if (!var7_6.equals((Object)MapleInventoryType.EQUIP) && !var7_6.equals((Object)MapleInventoryType.EQUIPPED)) break block18;
                                        var8_7 = new Equip(Integer.parseInt((String)var4_4.get(ItemLoaderType.ITEMID.getValueString())), Short.parseShort((String)var4_4.get(ItemLoaderType.POSITION.getValueString())), Integer.parseInt((String)var4_4.get(ItemLoaderType.UNIQUEID.getValueString())), Integer.parseInt((String)var4_4.get(ItemLoaderType.FLAG.getValueString())));
                                        v1 = var8_7;
                                        v1.setQuantity((short)1);
                                        v1.setOwner((String)var4_4.get(ItemLoaderType.OWNER.getValueString()));
                                        var8_7.setInventoryitemId(var5_5);
                                        var9_8 = Long.parseLong((String)var4_4.get(ItemLoaderType.EXPIREDATE.getValueString()));
                                        var8_7.setExpiration(var9_8 > 4000000000000L ? -1L : var9_8);
                                        var8_7.setUpgradeSlots(Byte.parseByte((String)var4_4.get(ItemLoaderType.UPGRADESLOTS.getValueString())));
                                        var8_7.setLevel(Byte.parseByte((String)var4_4.get(ItemLoaderType.LEVEL.getValueString())));
                                        var8_7.setStr(Short.parseShort((String)var4_4.get(ItemLoaderType.STR.getValueString())));
                                        var8_7.setDex(Short.parseShort((String)var4_4.get(ItemLoaderType.DEX.getValueString())));
                                        var8_7.setInt(Short.parseShort((String)var4_4.get(ItemLoaderType.INT.getValueString())));
                                        var8_7.setLuk(Short.parseShort((String)var4_4.get(ItemLoaderType.LUK.getValueString())));
                                        var8_7.setHp(Short.parseShort((String)var4_4.get(ItemLoaderType.HP.getValueString())));
                                        var8_7.setMp(Short.parseShort((String)var4_4.get(ItemLoaderType.MP.getValueString())));
                                        var8_7.setWatk(Short.parseShort((String)var4_4.get(ItemLoaderType.WATK.getValueString())));
                                        var8_7.setMatk(Short.parseShort((String)var4_4.get(ItemLoaderType.MATK.getValueString())));
                                        var8_7.setWdef(Short.parseShort((String)var4_4.get(ItemLoaderType.WDEF.getValueString())));
                                        var8_7.setMdef(Short.parseShort((String)var4_4.get(ItemLoaderType.MDEF.getValueString())));
                                        var8_7.setAcc(Short.parseShort((String)var4_4.get(ItemLoaderType.ACC.getValueString())));
                                        var8_7.setAvoid(Short.parseShort((String)var4_4.get(ItemLoaderType.AVOID.getValueString())));
                                        var8_7.setHands(Short.parseShort((String)var4_4.get(ItemLoaderType.HANDS.getValueString())));
                                        var8_7.setSpeed(Short.parseShort((String)var4_4.get(ItemLoaderType.SPEED.getValueString())));
                                        var8_7.setJump(Short.parseShort((String)var4_4.get(ItemLoaderType.JUMP.getValueString())));
                                        var8_7.setViciousHammer(Byte.parseByte((String)var4_4.get(ItemLoaderType.VICIOUSHAMMER.getValueString())));
                                        var8_7.setItemEXP(Integer.parseInt((String)var4_4.get(ItemLoaderType.ITEMEXP.getValueString())));
                                        var8_7.setGMLog((String)var4_4.get(ItemLoaderType.GM_LOG.getValueString()));
                                        var8_7.setDurability(Integer.parseInt((String)var4_4.get(ItemLoaderType.DURABILITY.getValueString())));
                                        var8_7.setEnhance(Byte.parseByte((String)var4_4.get(ItemLoaderType.ENHANCE.getValueString())));
                                        var8_7.setEquipOnlyId(Long.parseLong((String)var4_4.get(ItemLoaderType.EQUIPONLYID.getValueString())));
                                        var8_7.setIncSkill(Integer.parseInt((String)var4_4.get(ItemLoaderType.INCSKILL.getValueString())));
                                        var8_7.setHpR(Short.parseShort((String)var4_4.get(ItemLoaderType.HPR.getValueString())));
                                        var8_7.setMpR(Short.parseShort((String)var4_4.get(ItemLoaderType.MPR.getValueString())));
                                        var8_7.setGiftFrom((String)var4_4.get(ItemLoaderType.SENDER.getValueString()));
                                        var8_7.setPotential1(Integer.parseInt((String)var4_4.get(ItemLoaderType.POTENTIAL1.getValueString())));
                                        var8_7.setPotential2(Integer.parseInt((String)var4_4.get(ItemLoaderType.POTENTIAL2.getValueString())));
                                        var8_7.setPotential3(Integer.parseInt((String)var4_4.get(ItemLoaderType.POTENTIAL3.getValueString())));
                                        var8_7.setPVPDamage(Short.parseShort((String)var4_4.get(ItemLoaderType.PVPDAMAGE.getValueString())));
                                        var8_7.setCharmEXP(Short.parseShort((String)var4_4.get(ItemLoaderType.CHARMEXP.getValueString())));
                                        if (var8_7.getCharmEXP() < 0) {
                                            v2 = var8_7;
                                            v2.setCharmEXP(((Equip)var3_3.getEquipById(v2.getItemId())).getCharmEXP());
                                        }
                                        if (var8_7.getUniqueId() <= -1) break block19;
                                        if (GameConstants.isEffectRing(Integer.parseInt((String)var4_4.get(ItemLoaderType.ITEMID.getValueString())))) {
                                            var11_14 = MapleRing.loadFromDb(var8_7.getUniqueId(), var7_6.equals((Object)MapleInventoryType.EQUIPPED));
                                            if (var11_14 != null) {
                                                var8_7.setRing(var11_14);
                                            }
                                        } else if (var8_7.getItemId() / 10000 == 166 && GameSetConstants.MAPLE_VERSION >= 134 && (var11_15 = MapleAndroid.loadFromDb(var8_7.getItemId(), var8_7.getUniqueId())) != null) {
                                            var8_7.setAndroid(var11_15);
                                        }
                                        if (!var8_7.hasSetOnlyId()) break block20;
                                        v3 = var1_1;
                                        var8_7.setEquipOnlyId(MapleEquipOnlyId.getInstance().getNextEquipOnlyId());
                                        break block21;
                                    }
                                    if (MapleItemInformationProvider.getInstance().isCash(Integer.parseInt((String)var4_4.get(ItemLoaderType.ITEMID.getValueString()))) && var8_7.getUniqueId() == -1) {
                                        var11_16 = MapleInventoryIdentifier.getInstance();
                                        var8_7.setUniqueId(var11_16);
                                    }
                                }
                                v3 = var1_1;
                            }
                            v3.put(var5_5, new Pair<IItem, MapleInventoryType>(var8_7.copy(), var7_6));
                            continue;
                        }
                        var8_7 = new Item(Integer.parseInt((String)var4_4.get(ItemLoaderType.ITEMID.getValueString())), Short.parseShort((String)var4_4.get(ItemLoaderType.POSITION.getValueString())), Short.parseShort((String)var4_4.get(ItemLoaderType.QUANTITY.getValueString())), Integer.parseInt((String)var4_4.get(ItemLoaderType.FLAG.getValueString())));
                        var8_7.setUniqueId(Integer.parseInt((String)var4_4.get(ItemLoaderType.UNIQUEID.getValueString())));
                        var8_7.setOwner((String)var4_4.get(ItemLoaderType.OWNER.getValueString()));
                        v4 = var8_7;
                        v4.setInventoryitemId(var5_5);
                        v4.setExpiration(Long.parseLong((String)var4_4.get(ItemLoaderType.EXPIREDATE.getValueString())));
                        var8_7.setGMLog((String)var4_4.get(ItemLoaderType.GM_LOG.getValueString()));
                        var8_7.setGiftFrom((String)var4_4.get(ItemLoaderType.SENDER.getValueString()));
                        if (!GameConstants.isPet(var8_7.getItemId())) break block22;
                        if (var8_7.getUniqueId() <= -1) break block23;
                        var9_9 = MaplePet.loadFromDb(var8_7.getItemId(), var8_7.getUniqueId(), var8_7.getPosition());
                        if (var9_9 != null) {
                            var8_7.setPet(var9_9);
                        } else {
                            var10_13 = MapleInventoryIdentifierPet.getInstance();
                            v5 = var8_7;
                            v5.setUniqueId(v5.getUniqueId());
                            v5.setPet(MaplePet.createPet(v5.getItemId(), var8_7.getUniqueId()));
                        }
                        break block24;
                    }
                    var9_10 = MapleInventoryIdentifierPet.getInstance();
                    v6 = var1_1;
                    v7 = var8_7;
                    v7.setUniqueId(var9_10);
                    v7.setPet(MaplePet.createPet(v7.getItemId(), var9_10));
                    ** GOTO lbl127
                }
                if (ItemConstants.isExpChair(var8_7.getItemId()) && var8_7.getUniqueId() <= -1) {
                    var9_11 = MapleInventoryIdentifier.getInstance();
                    var8_7.setUniqueId(var9_11);
                }
            }
            try {
                v6 = var1_1;
lbl127:
                // 2 sources

                v6.put(var5_5, new Pair<IItem, MapleInventoryType>(var8_7.copy(), var7_6));
            }
            catch (Exception var9_12) {
                var9_12.printStackTrace();
                continue;
            }
            break;
        }
    }

    public static /* synthetic */ ItemLoader valueOf(String a2) {
        return Enum.valueOf(ItemLoader.class, a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void saveItemInv(MapleInventoryType a, List<Pair<IItem, MapleInventoryType>> a, Integer ... a) throws SQLException {
        var4_5 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            a.saveItemInv(a, a, (Connection)var4_5, a);
            ** if (var4_5 == null) goto lbl-1000
        }
        catch (Throwable var5_7) {
            if (var4_5 == null) ** GOTO lbl19
            try {
                var4_5.close();
                v0 = var5_7;
                ** GOTO lbl20
            }
            catch (Throwable a) {
                try {
                    var5_7.addSuppressed(a);
lbl19:
                    // 2 sources

                    v0 = var5_7;
lbl20:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var4_6) {
                    FileoutputUtil.outError(MapleDiseaseValueHolder.ALLATORIxDEMO("O\u0018D\u0004\f\u8cb0\u65ba\u5edc\u7553\u5e4f\r\u0003[\u0003"), var4_6);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var4_5.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void saveItems(List<Pair<IItem, MapleInventoryType>> a, Integer ... a) throws SQLException {
        var3_4 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            a.saveItems(a, (Connection)var3_4, a);
            ** if (var3_4 == null) goto lbl-1000
        }
        catch (Throwable var4_6) {
            if (var3_4 == null) ** GOTO lbl19
            try {
                var3_4.close();
                v0 = var4_6;
                ** GOTO lbl20
            }
            catch (Throwable a) {
                try {
                    var4_6.addSuppressed(a);
lbl19:
                    // 2 sources

                    v0 = var4_6;
lbl20:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var3_5) {
                    FileoutputUtil.outError(Eval.ALLATORIxDEMO("3+87p\u8c83\u65c6\u5eef\u752f\u5e7cq0'0"), var3_5);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var3_4.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public static /* synthetic */ String getJsonByItems(Map<Long, Pair<IItem, MapleInventoryType>> a2) throws SQLException {
        if (a2 == null || a2.size() == 0) {
            return "";
        }
        Iterator<Pair<IItem, MapleInventoryType>> iterator = a2.values().iterator();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int n2 = 1;
        Iterator<Pair<IItem, MapleInventoryType>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Object object = iterator.next();
            IItem iItem = ((Pair)object).getLeft();
            HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
            object = ((Pair)object).getRight();
            hashMap2.put(ItemLoaderType.INVENTORYITEMID.getValueString(), iItem.getInventoryitemId());
            hashMap2.put(ItemLoaderType.ITEMID.getValueString(), iItem.getItemId());
            hashMap2.put(ItemLoaderType.INVENTORYTYPE.getValueString(), ((MapleInventoryType)((Object)object)).getType());
            hashMap2.put(ItemLoaderType.POSITION.getValueString(), iItem.getPosition());
            hashMap2.put(ItemLoaderType.QUANTITY.getValueString(), iItem.getQuantity());
            hashMap2.put(ItemLoaderType.OWNER.getValueString(), iItem.getOwner());
            hashMap2.put(ItemLoaderType.GM_LOG.getValueString(), iItem.getGMLog());
            hashMap2.put(ItemLoaderType.UNIQUEID.getValueString(), iItem.getUniqueId());
            hashMap2.put(ItemLoaderType.EXPIREDATE.getValueString(), iItem.getExpiration());
            hashMap2.put(ItemLoaderType.FLAG.getValueString(), iItem.getFlag());
            hashMap2.put(ItemLoaderType.TYPE.getValueString(), iItem.getType());
            hashMap2.put(ItemLoaderType.SENDER.getValueString(), iItem.getGiftFrom());
            hashMap2.put(ItemLoaderType.EQUIPONLYID.getValueString(), iItem.getEquipOnlyId());
            if (((Enum)object).equals((Object)MapleInventoryType.EQUIP) || ((Enum)object).equals((Object)MapleInventoryType.EQUIPPED)) {
                object = (IEquip)iItem;
                hashMap2.put(ItemLoaderType.UPGRADESLOTS.getValueString(), object.getUpgradeSlots());
                hashMap2.put(ItemLoaderType.LEVEL.getValueString(), object.getLevel());
                hashMap2.put(ItemLoaderType.STR.getValueString(), object.getStr());
                hashMap2.put(ItemLoaderType.DEX.getValueString(), object.getDex());
                hashMap2.put(ItemLoaderType.INT.getValueString(), object.getInt());
                hashMap2.put(ItemLoaderType.LUK.getValueString(), object.getLuk());
                hashMap2.put(ItemLoaderType.HP.getValueString(), object.getHp());
                hashMap2.put(ItemLoaderType.MP.getValueString(), object.getMp());
                hashMap2.put(ItemLoaderType.WATK.getValueString(), object.getWatk());
                hashMap2.put(ItemLoaderType.MATK.getValueString(), object.getMatk());
                hashMap2.put(ItemLoaderType.WDEF.getValueString(), object.getWdef());
                hashMap2.put(ItemLoaderType.MDEF.getValueString(), object.getMdef());
                hashMap2.put(ItemLoaderType.ACC.getValueString(), object.getAcc());
                hashMap2.put(ItemLoaderType.AVOID.getValueString(), object.getAvoid());
                hashMap2.put(ItemLoaderType.HANDS.getValueString(), object.getHands());
                hashMap2.put(ItemLoaderType.SPEED.getValueString(), object.getSpeed());
                hashMap2.put(ItemLoaderType.JUMP.getValueString(), object.getJump());
                hashMap2.put(ItemLoaderType.VICIOUSHAMMER.getValueString(), object.getViciousHammer());
                hashMap2.put(ItemLoaderType.ITEMEXP.getValueString(), object.getItemEXP());
                hashMap2.put(ItemLoaderType.DURABILITY.getValueString(), object.getDurability());
                hashMap2.put(ItemLoaderType.ENHANCE.getValueString(), object.getEnhance());
                hashMap2.put(ItemLoaderType.POTENTIAL1.getValueString(), object.getPotential1());
                hashMap2.put(ItemLoaderType.POTENTIAL2.getValueString(), object.getPotential2());
                hashMap2.put(ItemLoaderType.POTENTIAL3.getValueString(), object.getPotential3());
                hashMap2.put(ItemLoaderType.INCSKILL.getValueString(), object.getIncSkill());
                hashMap2.put(ItemLoaderType.HPR.getValueString(), object.getHpR());
                hashMap2.put(ItemLoaderType.MPR.getValueString(), object.getMpR());
                hashMap2.put(ItemLoaderType.CHARMEXP.getValueString(), object.getCharmEXP());
                hashMap2.put(ItemLoaderType.PVPDAMAGE.getValueString(), object.getPVPDamage());
            }
            String string = "itemdata" + n2;
            ++n2;
            hashMap.put(string, GZIPCompression.compressA(JsonMapConverter.MapToJsonItem(hashMap2)));
            iterator2 = iterator;
        }
        return JsonMapConverter.MapToJsonItem(hashMap);
    }

    public /* synthetic */ Map<String, String> JsonToMapItem(String a22) {
        HashMap<String, String> hashMap = new HashMap();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ItemLoader a3;
            hashMap = (Map)objectMapper.readValue(a22, (TypeReference)new TypeReference<HashMap<String, String>>(){
                {
                    1 a3;
                }
            });
            return hashMap;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            hashMap = null;
            return null;
        }
    }

    public /* synthetic */ Map<Long, Pair<IItem, MapleInventoryType>> loadItems(boolean a2, Integer ... a3) throws SQLException {
        ItemLoader a4;
        return a4.ALLATORIxDEMO(false, a2, a3);
    }

    public static /* synthetic */ {
        INVENTORY = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO(">m!f9w8q."), false ? 1 : 0, false ? 1 : 0, false, Eval.ALLATORIxDEMO("6*)!1006&-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0019U\u0012M\u0003L\u0005Z\u0012R\u0002J\u0007N\u0012M\u0003"));
        STORAGE = new ItemLoader(Eval.ALLATORIxDEMO("\u0017\u000b\u000b\r\u0005\u0018\u0001"), true ? 1 : 0, true ? 1 : 0, true, MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004"), Eval.ALLATORIxDEMO("6*)!1006&!.1642!10"));
        CASHSHOP_EXPLORER = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO("4b$k$k8s(f/s;l%f%"), 2, 2, true, Eval.ALLATORIxDEMO("',-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u0012R\u0002J\u0007N\u0012M\u0003"));
        CASHSHOP_CYGNUS = new ItemLoader(Eval.ALLATORIxDEMO("\u0007\u001e\u0017\u0017\u0017\u0017\u000b\u000f\u001b\u001c\u001d\u0018\n\n\u0017"), 3, 3, true, MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u001eW\u0012N\u0004"), Eval.ALLATORIxDEMO("',!.1642!10"));
        CASHSHOP_ARAN = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO("4b$k$k8s(b%b9"), 4, 4, true, Eval.ALLATORIxDEMO("',-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u0012R\u0002J\u0007N\u0012M\u0003"));
        HIRED_MERCHANT = new ItemLoader(Eval.ALLATORIxDEMO("\u0017\r\r\u0001\u001b\u001b\u0012\u0001\r\u0007\u0017\u0005\u0011\u0010"), 5, 5, true, MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u001eW\u0012N\u0004"), Eval.ALLATORIxDEMO("',!.1642!10"));
        DUEY = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO("g\"f."), 6, 6, false, Eval.ALLATORIxDEMO(" *!&-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("\u0013V\u0012Z\u0012R\u0002J\u0007N\u0012M\u0003"));
        CASHSHOP_EVAN = new ItemLoader(Eval.ALLATORIxDEMO("\u0007\u001e\u0017\u0017\u0017\u0017\u000b\u000f\u001b\u001a\u0012\u001e\n"), 7, 7, true, MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u001eW\u0012N\u0004"), Eval.ALLATORIxDEMO("',!.1642!10"));
        MTS = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO(":w$"), 8, 8, false, Eval.ALLATORIxDEMO("20,-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("N\u0003P\u0012R\u0002J\u0007N\u0012M\u0003"));
        MTS_TRANSFER = new ItemLoader(Eval.ALLATORIxDEMO("\u0012\u0010\f\u001b\u000b\u0016\u001e\n\f\u0002\u001a\u0016"), 9, 9, false, MapleDiseaseValueHolder.ALLATORIxDEMO("\u001aW\u0004W\u0005B\u0019P\u0011F\u0005"), Eval.ALLATORIxDEMO("20,0-%179!-!.1642!10"));
        CASHSHOP_DB = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO("4b$k$k8s(g5"), 10, 10, true, Eval.ALLATORIxDEMO("',-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u0012R\u0002J\u0007N\u0012M\u0003"));
        CASHSHOP_RESIST = new ItemLoader(Eval.ALLATORIxDEMO("\u0007\u001e\u0017\u0017\u0017\u0017\u000b\u000f\u001b\r\u0001\f\r\f\u0010"), 11, 11, true, MapleDiseaseValueHolder.ALLATORIxDEMO("\u0014P\u001eW\u0012N\u0004"), Eval.ALLATORIxDEMO("',!.1642!10"));
        HIRED_FISHING = new ItemLoader(MapleDiseaseValueHolder.ALLATORIxDEMO("?j%f3|1j$k>m0"), 12, 12, true, Eval.ALLATORIxDEMO(",66: 9-,,6*8-+!27"), MapleDiseaseValueHolder.ALLATORIxDEMO("\u001fJ\u0005F\u0013E\u001eP\u001fJ\u0019D\u0012R\u0002J\u0007N\u0012M\u0003"));
        STORAGE_EXCEED = new ItemLoader(Eval.ALLATORIxDEMO("\f\u0010\u0010\u0016\u001e\u0003\u001a\u001b\u001a\u001c\u001c\u0001\u001a\u0000"), 13, 13, false, MapleDiseaseValueHolder.ALLATORIxDEMO("J\u0019U\u0012M\u0003L\u0005Z\u001eW\u0012N\u0004"), Eval.ALLATORIxDEMO("6*)!1006&!.1642!10"));
        ItemLoader[] arritemLoader = new ItemLoader[14];
        arritemLoader[0] = INVENTORY;
        arritemLoader[1] = STORAGE;
        arritemLoader[2] = CASHSHOP_EXPLORER;
        arritemLoader[3] = CASHSHOP_CYGNUS;
        arritemLoader[4] = CASHSHOP_ARAN;
        arritemLoader[5] = HIRED_MERCHANT;
        arritemLoader[6] = DUEY;
        arritemLoader[7] = CASHSHOP_EVAN;
        arritemLoader[8] = MTS;
        arritemLoader[9] = MTS_TRANSFER;
        arritemLoader[10] = CASHSHOP_DB;
        arritemLoader[11] = CASHSHOP_RESIST;
        arritemLoader[12] = HIRED_FISHING;
        arritemLoader[13] = STORAGE_EXCEED;
        ALLATORIxDEMO = arritemLoader;
    }

    public /* synthetic */ String MapToJsonItem(Map<String, Object> a2) {
        String string = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            string = objectMapper.writeValueAsString(a2);
            return string;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return string;
        }
    }
}

