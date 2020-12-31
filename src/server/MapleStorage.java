/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.MapleClient;
import client.MapleFriendship;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.ItemLoader;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import database.DBConPool;
import database.DatabaseException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.MapleStorageType;
import server.MerchItemPackage;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleStorage
implements Serializable {
    private /* synthetic */ int k;
    private /* synthetic */ String ALLATORIxDEMO;
    private final /* synthetic */ Map<MapleInventoryType, List<IItem>> B;
    private /* synthetic */ byte K;
    private final /* synthetic */ int H;
    private final /* synthetic */ int C;
    private /* synthetic */ boolean a;
    private static final /* synthetic */ long F = 9179541993413738569L;
    private final /* synthetic */ List<IItem> g;
    private final /* synthetic */ int E;
    private final /* synthetic */ int e;
    private /* synthetic */ MapleStorageType d;

    public /* synthetic */ void saveToDB_Replace(Connection a2, Equip a3) {
        MapleStorage a4;
        ArrayList<Pair<IItem, MapleInventoryType>> arrayList;
        block5: {
            try {
                arrayList = new ArrayList<Pair<IItem, MapleInventoryType>>();
                for (IItem iItem : a4.g) {
                    if (a3.getInventoryitemId() == iItem.getInventoryitemId()) continue;
                    IItem iItem2 = iItem;
                    arrayList.add(new Pair<IItem, MapleInventoryType>(iItem2, GameConstants.getInventoryType(iItem2.getItemId())));
                }
            }
            catch (SQLException sQLException) {
                System.err.println("Error saving storage" + sQLException);
                return;
            }
            Equip equip = a3;
            arrayList.add(new Pair<Equip, MapleInventoryType>(equip, GameConstants.getInventoryType(equip.getItemId())));
            if (!GameSetConstants.NEW_ITEM_SAVE) break block5;
            ItemLoader.STORAGE.saveItemsNew(arrayList, a2, 0, a4.H);
            return;
        }
        Integer[] arrinteger = new Integer[2];
        arrinteger[0] = a4.H;
        arrinteger[1] = a4.E;
        ItemLoader.STORAGE.saveItems(arrayList, a2, arrinteger);
    }

    public /* synthetic */ IItem takeOut(byte a22) {
        MapleStorage a3;
        if (a22 >= a3.g.size() || a22 < 0) {
            return null;
        }
        a3.a = true;
        IItem iItem = a3.g.remove(a22);
        MapleInventoryType a22 = GameConstants.getInventoryType(iItem.getItemId());
        a3.B.put(a22, new ArrayList<IItem>(a3.ALLATORIxDEMO(a22)));
        return iItem;
    }

    public /* synthetic */ List<IItem> getItems() {
        MapleStorage a2;
        return Collections.unmodifiableList(a2.g);
    }

    public /* synthetic */ int getId() {
        MapleStorage a2;
        return a2.C;
    }

    public /* synthetic */ void sendStorage(MapleClient a2, int a3, String a4) {
        int n2;
        MapleStorage a5;
        if (a2.getSecondPassword() != null) {
            if (a4 == null) {
                a2.getPlayer().dropMessage(1, MapleFriendship.ALLATORIxDEMO("\u8ae0\u8f20\u514e\u5bde\u7897\u301a"));
                return;
            }
            if (!a2.check2ndPassword((String)a4)) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(1, MerchItemPackage.ALLATORIxDEMO("\u5bf2\u7890\u931b\u8a88\u3036"));
                mapleClient.getPlayer().setConversation(0);
                mapleClient.getPlayer().setOperateStorage(false);
                if (mapleClient.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a2.getPlayer().getChrInfo(MapleFriendship.ALLATORIxDEMO("\u5022\u5eb3\u5bed\u78a4\u8f13\u517d\u9304\u8abc")));
                }
                return;
            }
        }
        Collections.sort(a5.g, new Comparator<IItem>(){
            {
                2 a3;
            }

            @Override
            public /* synthetic */ int compare(IItem a2, IItem a3) {
                if (GameConstants.getInventoryType(a2.getItemId()).getType() < GameConstants.getInventoryType(a3.getItemId()).getType()) {
                    return -1;
                }
                if (GameConstants.getInventoryType(a2.getItemId()) == GameConstants.getInventoryType(a3.getItemId())) {
                    return 0;
                }
                return 1;
            }
        });
        a4 = MapleInventoryType.values();
        int n3 = a4.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleInventoryType mapleInventoryType;
            MapleInventoryType mapleInventoryType2 = mapleInventoryType = a4[n2];
            a5.B.put(mapleInventoryType2, new ArrayList<IItem>(a5.g));
            n4 = ++n2;
        }
        a2.getPlayer().setOperateStorageExceed(a5.d);
        MapleStorage mapleStorage = a5;
        a2.sendPacket(MaplePacketCreator.getStorage(a3, mapleStorage.K, mapleStorage.g, a5.k));
    }

    public /* synthetic */ boolean containsItem(int a2) {
        MapleStorage a3;
        boolean bl = false;
        Iterator<IItem> iterator = a3.g.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getItemId() != a2) continue;
            bl = true;
        }
        return bl;
    }

    public /* synthetic */ void arrange() {
        int n2;
        MapleStorage a2;
        Collections.sort(a2.g, new Comparator<IItem>(){
            {
                3 a3;
            }

            @Override
            public /* synthetic */ int compare(IItem a2, IItem a3) {
                if (a2.getItemId() < a3.getItemId()) {
                    return -1;
                }
                if (a2.getItemId() == a3.getItemId()) {
                    return 0;
                }
                return 1;
            }
        });
        MapleInventoryType[] arrmapleInventoryType = MapleInventoryType.values();
        int n3 = arrmapleInventoryType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleInventoryType mapleInventoryType = arrmapleInventoryType[n2];
            a2.B.put(mapleInventoryType, a2.g);
            n4 = ++n2;
        }
    }

    public /* synthetic */ void close() {
        MapleStorage a2;
        a2.B.clear();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ MapleStorage loadStorage(int a, int a, int a, MapleStorageType a) {
        var4_4 = null;
        v0 = a;
        var6_5 = v0.getTable();
        var7_7 = v0.isExceed() != false ? MerchItemPackage.ALLATORIxDEMO("WDU^UO@IFEP") : MapleFriendship.ALLATORIxDEMO("yH{DmElB|");
        var8_8 = a.isExceed() != false ? a : a;
        var9_9 = a.isExceed() != false ? MerchItemPackage.ALLATORIxDEMO("\fUBP\fBMXYQ\f\t\f\u000b") : "";
        try {
            block13: {
                block14: {
                    var10_10 = DBConPool.getInstance().getDataSource().getConnection();
                    v1 = var11_12 = var10_10.prepareStatement("SELECT * FROM " + (String)var6_5 + " WHERE " + (String)var7_7 + " = ? and world = ?" + (String)var9_9);
                    v1.setInt(1, var8_8);
                    v1.setInt(2, a);
                    if (a.isExceed()) {
                        var11_12.setInt(3, a.getValue());
                    }
                    if (!(var6_5 = var11_12.executeQuery()).next()) break block13;
                    v2 = var6_5;
                    var5_14 = v2.getInt(MapleFriendship.ALLATORIxDEMO("k_wYyL}B|"));
                    var4_4 = new MapleStorage(var5_14, var6_5.getByte(MerchItemPackage.ALLATORIxDEMO("G@[XG")), var6_5.getInt(MapleFriendship.ALLATORIxDEMO("F}Xw")), a, a, a, a);
                    v2.close();
                    var11_12.close();
                    if (!a.isExceed()) break block14;
                    v3 = new Integer[3];
                    v3[0] = var8_8;
                    v3[1] = a.getValue();
                    v3[2] = a;
                    v4 = var7_7 = ItemLoader.STORAGE_EXCEED.loadItems(false, v3).values().iterator();
                    while (v4.hasNext()) {
                        var9_9 = var7_7.next();
                        var4_4.g.add(var9_9.getLeft());
                        v4 = var7_7;
                    }
                    ** GOTO lbl68
                }
                v5 = new Integer[2];
                v5[0] = var8_8;
                v5[1] = a;
                var7_7 = ItemLoader.STORAGE.loadItems(false, v5).values().iterator();
                v6 = var7_7;
                while (v6.hasNext()) {
                    var9_9 = (Pair)var7_7.next();
                    var4_4.g.add((IItem)var9_9.getLeft());
                    v6 = var7_7;
                }
                ** GOTO lbl68
            }
            try {
                var5_15 = MapleStorage.create(a, var8_8, a);
                var4_4 = new MapleStorage(var5_15, a.getCreateSlot(), 0, a, a, a, a);
                var6_5.close();
                var11_12.close();
            }
            catch (Throwable var11_13) {
                if (var10_10 != null) {
                    try {
                        var10_10.close();
                        v7 = var11_13;
                        throw v7;
                    }
                    catch (Throwable var6_6) {
                        var11_13.addSuppressed(var6_6);
                    }
                }
                v7 = var11_13;
                throw v7;
            }
lbl68:
            // 3 sources

            if (var10_10 == null) return var4_4;
            var10_10.close();
            return var4_4;
        }
        catch (SQLException var10_11) {
            System.err.println("Error loading storage" + var10_11);
        }
        return var4_4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void saveToDB(Connection a2) {
        Object object;
        String string;
        MapleStorage a3;
        try {
            string = a3.d.isExceed() ? MapleFriendship.ALLATORIxDEMO("k_wYyL}XGN`H}N|") : MerchItemPackage.ALLATORIxDEMO("_@CFMSIG");
        }
        catch (SQLException sQLException) {
            System.err.println("Error saving storage" + sQLException);
            return;
        }
        {
            String string2 = string;
            object = a2.prepareStatement("UPDATE " + string2 + " SET slots = ?, meso = ?, world = ? WHERE storageid = ?");
            PreparedStatement preparedStatement = object;
            PreparedStatement preparedStatement2 = object;
            preparedStatement2.setInt(1, a3.K);
            preparedStatement2.setInt(2, a3.k);
            preparedStatement.setInt(3, a3.E);
            preparedStatement.setInt(4, a3.C);
            preparedStatement.executeUpdate();
            object.close();
            object = new ArrayList();
            Iterator<IItem> iterator = a3.g.iterator();
            Iterator<IItem> iterator2 = iterator;
            while (iterator2.hasNext()) {
                IItem iItem = iterator.next();
                iterator2 = iterator;
                IItem iItem2 = iItem;
                object.add(new Pair<IItem, MapleInventoryType>(iItem2, GameConstants.getInventoryType(iItem2.getItemId())));
            }
        }
        {
            if (a3.d.isExceed()) {
                if (GameSetConstants.NEW_ITEM_SAVE) {
                    ItemLoader.STORAGE_EXCEED.saveItemsNew((List<Pair<IItem, MapleInventoryType>>)object, a2, a3.e, 0, a3.d.getValue());
                    return;
                }
                Integer[] arrinteger = new Integer[3];
                arrinteger[0] = a3.e;
                arrinteger[1] = a3.d.getValue();
                arrinteger[2] = a3.E;
                ItemLoader.STORAGE_EXCEED.saveItems((List<Pair<IItem, MapleInventoryType>>)object, a2, arrinteger);
                return;
            }
            if (GameSetConstants.NEW_ITEM_SAVE) {
                ItemLoader.STORAGE.saveItemsNew((List<Pair<IItem, MapleInventoryType>>)object, a2, 0, a3.H);
                return;
            }
            Integer[] arrinteger = new Integer[2];
            arrinteger[0] = a3.H;
            arrinteger[1] = a3.E;
            ItemLoader.STORAGE.saveItems((List<Pair<IItem, MapleInventoryType>>)object, a2, arrinteger);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ int create(int a2, int a32222, MapleStorageType a422222) throws SQLException {
        ResultSet resultSet;
        String string;
        ResultSet a32222;
        PreparedStatement preparedStatement;
        String string2;
        block16: {
            int a422222;
            Object object = a422222.isExceed() ? MapleFriendship.ALLATORIxDEMO("k_wYyL}XGN`H}N|") : MerchItemPackage.ALLATORIxDEMO("_@CFMSIG");
            string2 = a422222.isExceed() ? MapleFriendship.ALLATORIxDEMO("{CyYyHlNjB|") : MerchItemPackage.ALLATORIxDEMO("UOWCAB@EP");
            String string3 = object;
            object = a422222.isExceed() ? "INSERT INTO " + string3 + " (" + string2 + ", world, slots, meso, value) VALUES (?, ?, ?, ?, ?)" : "INSERT INTO " + string3 + " (" + string2 + ", world, slots, meso) VALUES (?, ?, ?, ?)";
            string2 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                block17: {
                    preparedStatement = string2.prepareStatement((String)object, 1);
                    try {
                        PreparedStatement preparedStatement2 = preparedStatement;
                        preparedStatement.setInt(1, a32222);
                        preparedStatement2.setInt(2, a2);
                        preparedStatement2.setInt(3, a422222.getCreateSlot());
                        preparedStatement.setInt(4, 0);
                        if (a422222.isExceed()) {
                            preparedStatement.setInt(5, a422222.getValue());
                        }
                        preparedStatement.executeUpdate();
                        a32222 = preparedStatement.getGeneratedKeys();
                        if (!a32222.next()) break block16;
                        ResultSet resultSet2 = a32222;
                        int n2 = resultSet2.getInt(1);
                        preparedStatement.close();
                        resultSet2.close();
                        a422222 = n2;
                        if (preparedStatement == null) break block17;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        if (preparedStatement != null) {
                            try {
                                preparedStatement.close();
                                throwable2 = throwable;
                                throw throwable2;
                            }
                            catch (Throwable a422222) {
                                throwable.addSuppressed(a422222);
                            }
                        }
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    preparedStatement.close();
                }
                if (string2 == null) return a422222;
            }
            catch (Throwable throwable) {
                Throwable throwable3;
                if (string2 != null) {
                    try {
                        string2.close();
                        throwable3 = throwable;
                        throw throwable3;
                    }
                    catch (Throwable throwable4) {
                        throwable.addSuppressed(throwable4);
                    }
                }
                throwable3 = throwable;
                throw throwable3;
            }
            string2.close();
            return a422222;
        }
        if (preparedStatement != null) {
            string = string2;
            preparedStatement.close();
        } else {
            string = string2;
        }
        if (string != null) {
            resultSet = a32222;
            string2.close();
        } else {
            resultSet = a32222;
        }
        resultSet.close();
        throw new DatabaseException(MapleFriendship.ALLATORIxDEMO("bvX}YlBvL8HpJj\u000b~JqG}O6"));
    }

    public /* synthetic */ void update(MapleClient a2) {
        MapleStorage a3;
        MapleStorage mapleStorage = a3;
        a2.sendPacket(MaplePacketCreator.arrangeStorage(mapleStorage.K, mapleStorage.g, true));
    }

    public /* synthetic */ boolean isFull() {
        MapleStorage a2;
        return a2.g.size() >= a2.K;
    }

    public /* synthetic */ void setSlots(byte a2) {
        MapleStorage a3;
        MapleStorage mapleStorage = a3;
        mapleStorage.a = true;
        mapleStorage.K = a2;
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
                catch (SQLException var1_2) {
                    FileoutputUtil.outError(MerchItemPackage.ALLATORIxDEMO("@[KG\u0003\u8cf3\u65b5\u5e9f\u755c\u5e0c\u0002@T@"), var1_2);
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

    public /* synthetic */ void store(IItem a2) {
        MapleStorage a3;
        a3.a = true;
        a3.g.add((IItem)a2);
        a3.B.put((MapleInventoryType)((Object)(a2 = GameConstants.getInventoryType(a2.getItemId()))), new ArrayList<IItem>(a3.ALLATORIxDEMO((MapleInventoryType)((Object)a2))));
    }

    public /* synthetic */ String getKey() {
        MapleStorage a2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a2.K);
        stringBuilder.append(a2.k);
        stringBuilder.append(a2.E);
        stringBuilder.append(a2.C);
        Iterator<IItem> iterator = a2.g.iterator();
        Iterator<IItem> iterator2 = iterator;
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            stringBuilder.append(iItem.getKey());
        }
        return stringBuilder.toString();
    }

    private /* synthetic */ MapleStorage(int a2, byte a3, int a4, int a5, int a6, int a7, MapleStorageType a8) {
        MapleStorage a9;
        MapleStorage mapleStorage = a9;
        MapleStorage mapleStorage2 = a9;
        MapleStorage mapleStorage3 = a9;
        MapleStorage mapleStorage4 = a9;
        MapleStorage mapleStorage5 = a9;
        a9.B = new EnumMap<MapleInventoryType, List<IItem>>(MapleInventoryType.class);
        a9.a = false;
        mapleStorage4.ALLATORIxDEMO = "";
        mapleStorage4.C = a2;
        mapleStorage3.K = a3;
        mapleStorage3.g = new LinkedList<IItem>();
        mapleStorage3.k = a4;
        mapleStorage2.H = a5;
        mapleStorage2.e = a6;
        mapleStorage.E = a7;
        mapleStorage.d = a8;
    }

    private /* synthetic */ List<IItem> ALLATORIxDEMO(MapleInventoryType a2) {
        MapleStorage a3;
        LinkedList<IItem> linkedList = new LinkedList<IItem>();
        for (IItem iItem : a3.g) {
            if (GameConstants.getInventoryType(iItem.getItemId()) != a2) continue;
            linkedList.add(iItem);
        }
        return linkedList;
    }

    public /* synthetic */ int getMeso() {
        MapleStorage a2;
        return a2.k;
    }

    public /* synthetic */ void sendMeso(MapleClient a2) {
        MapleStorage a3;
        MapleStorage mapleStorage = a3;
        a2.sendPacket(MaplePacketCreator.mesoStorage(mapleStorage.K, mapleStorage.k));
    }

    public /* synthetic */ void setMeso(int a2) {
        if (a2 < 0) {
            return;
        }
        a.a = true;
        a.k = a2;
    }

    public /* synthetic */ void setChanged(boolean a2) {
        a.a = a2;
    }

    public /* synthetic */ IItem findById(int a2) {
        MapleStorage a3;
        for (IItem iItem : a3.g) {
            if (iItem.getItemId() != a2) continue;
            return iItem;
        }
        return null;
    }

    public /* synthetic */ void sendTakenOut(MapleClient a2, MapleInventoryType a3) {
        MapleStorage a4;
        MapleStorage mapleStorage = a4;
        MapleInventoryType mapleInventoryType = a3;
        a2.sendPacket(MaplePacketCreator.takeOutStorage(mapleStorage.K, mapleInventoryType, (Collection<IItem>)mapleStorage.B.get((Object)mapleInventoryType)));
    }

    public /* synthetic */ boolean removeItemByInventoryItemId(long a2) {
        MapleStorage a3;
        int n2 = 0;
        boolean bl = false;
        if (a3.getItems() != null) {
            block2: {
                MapleStorage mapleStorage;
                Iterator<IItem> iterator = a3.getItems().iterator();
                while (iterator.hasNext()) {
                    ++n2;
                    IItem iItem = iterator.next();
                    if (iItem.getInventoryitemId() != a2) continue;
                    MapleStorage mapleStorage2 = a3;
                    mapleStorage = mapleStorage2;
                    mapleStorage2.g.remove(n2);
                    bl = true;
                    break block2;
                }
                mapleStorage = a3;
            }
            mapleStorage.a = true;
        }
        a3.saveToDB();
        return bl;
    }

    public static /* synthetic */ MapleStorage loadStorage(int a2, int a3, int a4) {
        return MapleStorage.loadStorage(a2, a3, a4, MapleStorageType.STORAGE);
    }

    public /* synthetic */ byte getSlot(MapleInventoryType a2, byte a3) {
        Iterator<IItem> iterator;
        MapleStorage a4;
        byte by = 0;
        if (a3 >= (a2 = a4.B.get(a2)).size() || a3 < 0) {
            return -1;
        }
        Iterator<IItem> iterator2 = iterator = a4.g.iterator();
        while (iterator2.hasNext()) {
            if (iterator.next() == a2.get(a3)) {
                return by;
            }
            by = (byte)(by + 1);
            iterator2 = iterator;
        }
        return -1;
    }

    public /* synthetic */ void saveToDB_RemoveList(Connection a2, List<Long> a3) {
        MapleStorage a4;
        ArrayList<Pair<IItem, MapleInventoryType>> arrayList;
        block5: {
            try {
                arrayList = new ArrayList<Pair<IItem, MapleInventoryType>>();
                for (IItem iItem : a4.g) {
                    if (a3.contains(iItem.getInventoryitemId())) continue;
                    IItem iItem2 = iItem;
                    arrayList.add(new Pair<IItem, MapleInventoryType>(iItem2, GameConstants.getInventoryType(iItem2.getItemId())));
                }
            }
            catch (SQLException sQLException) {
                System.err.println("Error saving storage" + sQLException);
                return;
            }
            if (!GameSetConstants.NEW_ITEM_SAVE) break block5;
            ItemLoader.STORAGE.saveItemsNew(arrayList, a2, 0, a4.H);
            return;
        }
        Integer[] arrinteger = new Integer[2];
        arrinteger[0] = a4.H;
        arrinteger[1] = a4.E;
        ItemLoader.STORAGE.saveItems(arrayList, a2, arrinteger);
    }

    public /* synthetic */ void sendStorage(MapleClient a2, int a3) {
        int n2;
        MapleStorage a4;
        Collections.sort(a4.g, new Comparator<IItem>(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ int compare(IItem a2, IItem a3) {
                if (GameConstants.getInventoryType(a2.getItemId()).getType() < GameConstants.getInventoryType(a3.getItemId()).getType()) {
                    return -1;
                }
                if (GameConstants.getInventoryType(a2.getItemId()) == GameConstants.getInventoryType(a3.getItemId())) {
                    return 0;
                }
                return 1;
            }
        });
        MapleInventoryType[] arrmapleInventoryType = MapleInventoryType.values();
        int n3 = arrmapleInventoryType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleInventoryType mapleInventoryType;
            MapleInventoryType mapleInventoryType2 = mapleInventoryType = arrmapleInventoryType[n2];
            a4.B.put(mapleInventoryType2, new ArrayList<IItem>(a4.g));
            n4 = ++n2;
        }
        a2.getPlayer().setOperateStorageExceed(a4.d);
        MapleStorage mapleStorage = a4;
        a2.sendPacket(MaplePacketCreator.getStorage(a3, mapleStorage.K, mapleStorage.g, a4.k));
    }

    public /* synthetic */ void sendStored(MapleClient a2, MapleInventoryType a3) {
        MapleStorage a4;
        MapleStorage mapleStorage = a4;
        MapleInventoryType mapleInventoryType = a3;
        a2.sendPacket(MaplePacketCreator.storeStorage(mapleStorage.K, mapleInventoryType, (Collection<IItem>)mapleStorage.B.get((Object)mapleInventoryType)));
    }

    public /* synthetic */ void increaseSlots(byte a2) {
        MapleStorage a3;
        a3.a = true;
        a3.K = (byte)(a3.K + a2);
    }

    public /* synthetic */ int getSlots() {
        MapleStorage a2;
        return a2.K;
    }
}

