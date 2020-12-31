/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server;

import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import database.DBConPool;
import handling.channel.handler.BBSHandler;
import handling.world.family.MapleFamily;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.CashItem;
import server.CashModItem;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.swing.WvsCenter;

public class CashItemFactory {
    private final /* synthetic */ Map<Integer, List<CashItem>> K;
    private final /* synthetic */ Map<Integer, CashItem> k;
    private final /* synthetic */ Map<Integer, List<Integer>> g;
    private final /* synthetic */ Map<Integer, CashModItem> a;
    private final /* synthetic */ Map<Integer, CashModItem> d;
    private final /* synthetic */ MapleDataProvider ALLATORIxDEMO;
    private static final /* synthetic */ CashItemFactory E;
    private final /* synthetic */ Map<Integer, CashItem> B;

    public final /* synthetic */ Map<Integer, List<Integer>> getRandomItemInfo() {
        CashItemFactory a2;
        return a2.g;
    }

    public final /* synthetic */ CashItem getItemId(int a22) {
        CashItemFactory a3;
        CashItem cashItem = a3.k.get(a22);
        CashModItem a22 = a3.getModItemId(a22);
        if (a22 != null && a22.isOnSale()) {
            return cashItem;
        }
        if (cashItem == null || !cashItem.isOnSale() || a22 != null && !a22.isOnSale()) {
            return null;
        }
        return null;
    }

    public final /* synthetic */ CashModItem getModItemId(int a2) {
        CashItemFactory a3;
        return a3.d.get(a2);
    }

    public final /* synthetic */ List<CashItem> getHideItems() {
        CashItemFactory a2;
        LinkedList<CashItem> linkedList = new LinkedList<CashItem>();
        for (CashItem cashItem : a2.B.values()) {
            CashModItem cashModItem = a2.getModItem(cashItem.getSN());
            if (cashModItem == null || cashModItem.isOnSale()) continue;
            linkedList.add(cashItem);
        }
        return linkedList;
    }

    public final /* synthetic */ Collection<CashModItem> getAllModInfo() {
        CashItemFactory a2;
        return a2.a.values();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void updateModItem(CashModItem a22) {
        CashItemFactory a3;
        if (a22.getId() == 0) {
            if (a3.B == null || !a3.B.containsKey(a22.getSN())) {
                return;
            }
            a22.setId(a3.B.get(a22.getSN()).getId());
        }
        a3.a.put(a22.getSN(), a22);
        CashModItem cashModItem = a22;
        cashModItem.initFlags(a3.B.get(cashModItem.getSN()) != null ? a3.B.get(a22.getSN()) : null);
        PreparedStatement preparedStatement = null;
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(MapleFamily.ALLATORIxDEMO(";\u0010*\u0001:\u0005N#\u000f3\u00063\u0006/\u001e\u001f\u00074\u000b-\u001d`=\u0005:` /\u001a%N}N\u007fB`'4\u000b-'$N}N\u007fB`-/\u001b.\u001a`S`QlN\u0010\u001c)\r%N}N\u007fB`>%\u001c)\u0001$N}N\u007fB`)%\u0000$\u000b2N}N\u007fB`-,\u000f3\u001d`S`QlN\u000f\u0000\u0013\u000f,\u000b`S`QlN\r\u000f2\u0005`S`Q`9\b+\u0012+`=\u000eN}N\u007f"));
                PreparedStatement preparedStatement3 = preparedStatement;
                PreparedStatement preparedStatement4 = preparedStatement;
                PreparedStatement preparedStatement5 = preparedStatement;
                preparedStatement5.setString(1, a22.getNote());
                preparedStatement5.setInt(2, a22.getId());
                preparedStatement4.setInt(3, a22.getCount());
                preparedStatement4.setInt(4, a22.getPrice());
                preparedStatement3.setInt(5, a22.getPeriod());
                preparedStatement3.setInt(6, a22.getGender());
                preparedStatement2.setInt(7, a22.getFlage());
                preparedStatement2.setInt(8, a22.isOnSale() ? 1 : 0);
                preparedStatement.setInt(9, a22.isMark() ? 1 : 0);
                PreparedStatement preparedStatement6 = preparedStatement;
                preparedStatement6.setInt(10, a22.getSN());
                preparedStatement6.execute();
                preparedStatement6.close();
                if (druidPooledConnection == null) return;
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (Throwable a22) {
                        throwable.addSuppressed(a22);
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ List<CashModItem> getAllModItems(int a22) {
        CashItemFactory a3;
        LinkedList<CashModItem> linkedList = new LinkedList<CashModItem>();
        if (!GameSetConstants.AUTO_CS_ITEM) {
            Iterator<CashModItem> iterator = a3.getAllModInfo().iterator();
            while (iterator.hasNext()) {
                CashModItem cashModItem = iterator.next();
                if (!cashModItem.isOnSale()) continue;
                linkedList.add(cashModItem);
            }
            return linkedList;
        }
        if (GameSetConstants.CS_CLASSIFY) {
            switch (a22) {
                case 1: {
                    Iterator<CashModItem> iterator = a3.getAllModInfo().iterator();
                    while (iterator.hasNext()) {
                        CashModItem cashModItem = iterator.next();
                        if (cashModItem.getSN() < 10000000 || cashModItem.getSN() >= 20300000) continue;
                        linkedList.add(cashModItem);
                    }
                    return linkedList;
                }
                case 2: {
                    Iterator<CashModItem> iterator = a3.getAllModInfo().iterator();
                    while (iterator.hasNext()) {
                        CashModItem cashModItem = iterator.next();
                        if (cashModItem.getSN() < 20300000 || cashModItem.getSN() >= 20600000) continue;
                        linkedList.add(cashModItem);
                    }
                    return linkedList;
                }
                case 3: {
                    Iterator<CashModItem> iterator = a3.getAllModInfo().iterator();
                    while (iterator.hasNext()) {
                        CashModItem cashModItem = iterator.next();
                        if (cashModItem.getSN() < 20600000 || cashModItem.getSN() >= 30000000) continue;
                        linkedList.add(cashModItem);
                    }
                    return linkedList;
                }
                case 4: {
                    Iterator<CashModItem> iterator = a3.getAllModInfo().iterator();
                    while (iterator.hasNext()) {
                        CashModItem cashModItem = iterator.next();
                        if (cashModItem.getSN() < 30000000 || cashModItem.getSN() >= 70000000) continue;
                        linkedList.add(cashModItem);
                    }
                    return linkedList;
                }
            }
            return linkedList;
        }
        int n2 = --a22;
        Iterator<CashModItem> iterator = a3.getAllModInfo().iterator();
        while (iterator.hasNext()) {
            CashModItem a22 = iterator.next();
            if (!a22.isOnSale()) continue;
            if (a22.getSN() < 30000000 && a22.getSN() >= 20000000) {
                if (a22.getSN() % 4 != n2) continue;
                linkedList.add(a22);
                continue;
            }
            linkedList.add(a22);
        }
        return linkedList;
    }

    public final /* synthetic */ int getItemSN(int a2) {
        CashItemFactory a3;
        for (Map.Entry<Integer, CashModItem> entry : a3.a.entrySet()) {
            if (entry.getValue().getId() != a2) continue;
            return entry.getValue().getSN();
        }
        for (Map.Entry<Integer, CashItem> entry : a3.B.entrySet()) {
            if (entry.getValue().getId() != a2) continue;
            return entry.getValue().getSN();
        }
        return 0;
    }

    public final /* synthetic */ CashModItem getModItem(int a2) {
        CashItemFactory a3;
        return a3.a.get(a2);
    }

    public final /* synthetic */ CashItem getItem(int a22) {
        CashItemFactory a3;
        CashItem cashItem = a3.B.get(a22);
        CashModItem a22 = a3.getModItem(a22);
        if (a22 != null && a22.isOnSale()) {
            return cashItem;
        }
        if (cashItem == null || !cashItem.isOnSale() || a22 != null && !a22.isOnSale()) {
            return null;
        }
        return null;
    }

    public final /* synthetic */ CashItem getSimpleItem(int a2) {
        CashItemFactory a3;
        return a3.B.get(a2);
    }

    public final /* synthetic */ List<CashItem> getHideAllDefaultItems() {
        CashItemFactory a2;
        LinkedList<CashItem> linkedList = new LinkedList<CashItem>();
        for (CashItem cashItem : a2.B.values()) {
            CashModItem cashModItem = a2.getModItem(cashItem.getSN());
            if ((cashModItem == null || cashModItem.isOnSale()) && !cashItem.isOnSale()) continue;
            linkedList.add(cashItem);
        }
        return linkedList;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ boolean ALLATORIxDEMO(String a) {
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var3_5 = var2_3.prepareStatement(MapleFamily.ALLATORIxDEMO("\u0004+\f+\u0014+`(\u0012!\rN#\u000f3\u00063\u0006/\u001e\u001f\u00074\u000b-\u001d`9\b+\u0012+` /\u001a%N}N\u007f"));
            var3_5.setString(1, a);
            var3_5.execute();
            var3_5.close();
            ** if (var2_3 == null) goto lbl-1000
        }
        catch (Throwable var3_6) {
            if (var2_3 == null) ** GOTO lbl22
            try {
                var2_3.close();
                v0 = var3_6;
                ** GOTO lbl23
            }
            catch (Throwable a) {
                try {
                    var3_6.addSuppressed(a);
lbl22:
                    // 2 sources

                    v0 = var3_6;
lbl23:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var2_4) {
                    System.out.println("clearNoExistItem:" + var2_4);
                    return false;
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_3.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void deleteModItem(int a) {
        a.a.remove(a);
        var2_3 = null;
        var3_4 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = var3_4.prepareStatement(BBSHandler.ALLATORIxDEMO("gfofwf\u0003eqln\u0003@BPKPKLS|JWFNP\u0003tkfqf\u0003pm\u0003\u001e\u0003\u001c"));
            var2_3.setInt(1, a);
            var2_3.execute();
            var2_3.close();
            ** if (var3_4 == null) goto lbl-1000
        }
        catch (Throwable var4_6) {
            if (var3_4 == null) ** GOTO lbl26
            try {
                var3_4.close();
                v0 = var4_6;
                ** GOTO lbl27
            }
            catch (Throwable a) {
                try {
                    var4_6.addSuppressed(a);
lbl26:
                    // 2 sources

                    v0 = var4_6;
lbl27:
                    // 2 sources

                    throw v0;
                }
                catch (SQLException var3_5) {
                    // empty catch block
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

    public final /* synthetic */ Set<Integer> getAllItemSNs() {
        CashItemFactory a2;
        return a2.B.keySet();
    }

    public final /* synthetic */ List<CashItem> getPackageItems(int a2) {
        CashItemFactory a3;
        return a3.K.get(a2);
    }

    public /* synthetic */ void clearItems() {
        CashItemFactory a2;
        a2.ALLATORIxDEMO(false);
    }

    public /* synthetic */ Map<Integer, List<CashItem>> getPackages() {
        CashItemFactory a2;
        return a2.K;
    }

    public /* synthetic */ CashItemFactory() {
        CashItemFactory a2;
        CashItemFactory cashItemFactory = a2;
        CashItemFactory cashItemFactory2 = a2;
        a2.g = new HashMap<Integer, List<Integer>>();
        cashItemFactory2.B = new HashMap<Integer, CashItem>();
        a2.k = new HashMap<Integer, CashItem>();
        a2.K = new HashMap<Integer, List<CashItem>>();
        cashItemFactory.a = new HashMap<Integer, CashModItem>();
        cashItemFactory.d = new HashMap<Integer, CashModItem>();
        cashItemFactory.ALLATORIxDEMO = MapleDataProviderFactory.getDataProvider(BBSHandler.ALLATORIxDEMO("fW@\rTY"));
    }

    public final /* synthetic */ List<CashModItem> getAllModItemsModify() {
        CashItemFactory a2;
        LinkedList<CashModItem> linkedList = new LinkedList<CashModItem>();
        int n2 = Randomizer.rand(0, 2);
        for (CashModItem cashModItem : a2.getAllModInfo()) {
            if (!cashModItem.isOnSale()) continue;
            if (cashModItem.getSN() < 30000000 && cashModItem.getSN() >= 2000000) {
                if (cashModItem.getSN() % 3 != n2) continue;
                linkedList.add(cashModItem);
                continue;
            }
            linkedList.add(cashModItem);
        }
        return linkedList;
    }

    public /* synthetic */ void initialize(boolean a222, boolean a322) {
        Iterator<MapleData> iterator;
        Object object;
        CashItemFactory a4;
        if (a222) {
            CashItemFactory cashItemFactory = a4;
            cashItemFactory.B.clear();
            cashItemFactory.k.clear();
            cashItemFactory.K.clear();
            cashItemFactory.a.clear();
            cashItemFactory.d.clear();
            cashItemFactory.g.clear();
        }
        if (!(a4.B.isEmpty() && a4.k.isEmpty() && a4.K.isEmpty() && a4.a.isEmpty() && a4.d.isEmpty() && a4.g.isEmpty())) {
            return;
        }
        System.out.println(MapleFamily.ALLATORIxDEMO("\u3050\u8bee\u5396\u4e43\u3051N\u8cbc\u7207\u5506\u57a0\u7229\u54afzTz"));
        for (MapleData object22 : a4.ALLATORIxDEMO.getData(BBSHandler.ALLATORIxDEMO("`LNNLGJWZ\rJND")).getChildren()) {
            int mapleData = MapleDataTool.getIntConvert(MapleFamily.ALLATORIxDEMO("=\u000e"), object22, 0);
            object = new CashItem(mapleData, MapleDataTool.getIntConvert(BBSHandler.ALLATORIxDEMO("jWFNjG"), object22, 0), MapleDataTool.getIntConvert(MapleFamily.ALLATORIxDEMO("\u0003\u00015\u00004"), object22, 1), MapleDataTool.getIntConvert(BBSHandler.ALLATORIxDEMO("sQJ@F"), object22, 0), MapleDataTool.getIntConvert(MapleFamily.ALLATORIxDEMO(">%\u001c)\u0001$"), object22, 0), MapleDataTool.getIntConvert(BBSHandler.ALLATORIxDEMO("dFMGFQ"), object22, 2), MapleDataTool.getIntConvert(MapleFamily.ALLATORIxDEMO("\u0003\u0002!\u001d3"), object22, -1), false, MapleDataTool.getIntConvert(BBSHandler.ALLATORIxDEMO("lMpBOF"), object22, 0) > 0 && MapleDataTool.getIntConvert(MapleFamily.ALLATORIxDEMO("\u0010\u001c)\r%"), object22, 0) > 0, false);
            if (mapleData <= 0) continue;
            a4.B.put(mapleData, (CashItem)object);
            a4.k.put(((CashItem)object).getId(), (CashItem)object);
        }
        if (a322) {
            a4.ALLATORIxDEMO(false);
        }
        Iterator<MapleData> a222 = a4.ALLATORIxDEMO.getData(BBSHandler.ALLATORIxDEMO("`BPKsB@HBDF\rJND"));
        Iterator<MapleData> iterator2 = iterator = a222.getChildren().iterator();
        while (iterator2.hasNext()) {
            MapleData mapleData = iterator.next();
            if (mapleData.getChildByPath(MapleFamily.ALLATORIxDEMO("=\u000e")) == null) {
                iterator2 = iterator;
                continue;
            }
            object = new ArrayList<CashItem>();
            for (MapleData a322 : mapleData.getChildByPath(BBSHandler.ALLATORIxDEMO("pm")).getChildren()) {
                if (a4.B.get(MapleDataTool.getIntConvert(a322)) == null) continue;
                object.add(a4.B.get(MapleDataTool.getIntConvert(a322)));
            }
            a4.K.put(Integer.parseInt(mapleData.getName()), (List<CashItem>)object);
            iterator2 = iterator;
        }
    }

    public /* synthetic */ void checkItems() {
        CashItemFactory a2;
        a2.ALLATORIxDEMO(true);
    }

    public final /* synthetic */ List<CashItem> getAllItems() {
        CashItemFactory a2;
        return new ArrayList<CashItem>(a2.B.values());
    }

    public static final /* synthetic */ CashItemFactory getInstance() {
        return E;
    }

    public final /* synthetic */ List<CashModItem> getAllModItemsMark() {
        CashItemFactory a2;
        LinkedList<CashModItem> linkedList = new LinkedList<CashModItem>();
        for (CashModItem cashModItem : a2.getAllModInfo()) {
            if (!cashModItem.isOnSale() || !cashModItem.isMark()) continue;
            linkedList.add(cashModItem);
        }
        return linkedList;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(boolean a) {
        if (a && !WvsCenter.loaditem) {
            MapleItemInformationProvider.getInstance().loadItems(false);
            WvsCenter.loaditem = true;
        }
        v0 = a;
        v0.a.clear();
        v0.d.clear();
        try {
            var2_2 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                var3_4 = var2_2.prepareStatement(MapleFamily.ALLATORIxDEMO("=\u0005\"\u0005-\u0014NjN\u0006<\u000f#`\r!\u001d(\u001d(\u000101)\u001a%\u00033"));
                var4_6 = var3_4.executeQuery();
lbl12:
                // 5 sources

                while (var4_6.next()) {
                    v1 = v2;
                    v3 = v2;
                    v4 = var4_6.getInt(BBSHandler.ALLATORIxDEMO("pm"));
                    v5 = var4_6.getString(MapleFamily.ALLATORIxDEMO(" /\u001a%"));
                    v6 = var4_6.getInt(BBSHandler.ALLATORIxDEMO("jWFNjG"));
                    v7 = var4_6.getInt(MapleFamily.ALLATORIxDEMO("\u0003\u00015\u00004"));
                    v8 = var4_6.getInt(BBSHandler.ALLATORIxDEMO("sQJ@F"));
                    v9 = var4_6.getInt(MapleFamily.ALLATORIxDEMO(">%\u001c)\u0001$"));
                    v10 = var4_6.getInt(BBSHandler.ALLATORIxDEMO("dFMGFQ"));
                    v11 = var4_6.getInt(MapleFamily.ALLATORIxDEMO("\u0003\u0002!\u001d3"));
                    if (var4_6.getInt(BBSHandler.ALLATORIxDEMO("dBPKLMOZ")) <= 0) ** GOTO lbl-1000
                    v12 = true;
                    v13 = var4_6;
                    ** GOTO lbl43
                }
                ** GOTO lbl77
            }
            catch (Throwable var3_5) {
                if (var2_2 != null) {
                    try {
                        var2_2.close();
                        v14 = var3_5;
                        throw v14;
                    }
                    catch (Throwable var4_7) {
                        var3_5.addSuppressed(var4_7);
                    }
                }
                v14 = var3_5;
                throw v14;
            }
        }
        catch (Exception var2_3) {
            var2_3.printStackTrace();
            return;
        }
lbl-1000:
        // 1 sources

        {
            v12 = false;
            v13 = var4_6;
lbl43:
            // 2 sources

            if (v13.getInt(MapleFamily.ALLATORIxDEMO("!.=!\u0002%")) <= 0) ** GOTO lbl-1000
            v15 = true;
            v16 = var4_6;
            ** GOTO lbl49
        }
lbl-1000:
        // 1 sources

        {
            block14: {
                block15: {
                    v15 = false;
                    v16 = var4_6;
lbl49:
                    // 2 sources

                    v1(v4, v5, v6, v7, v8, v9, v10, v11, v12, v15, v16.getInt(BBSHandler.ALLATORIxDEMO("nBQH")) > 0);
                    var5_8 = v3;
                    if (v3.getId() == 0 && a.B != null && a.B.containsKey(var5_8.getSN())) {
                        v17 = var5_8;
                        v17.setId(a.B.get(v17.getSN()).getId());
                    }
                    if (!a) break block14;
                    if (!MapleItemInformationProvider.getInstance().itemExists(var5_8.getId())) break block15;
                    v18 = var5_8;
                    a.a.put(var5_8.getSN(), v18);
                    a.d.put(var5_8.getId(), var5_8);
                    if (v18.isOnSale()) {
                        var6_9 = a.B.get(var5_8.getSN());
                        var5_8.initFlags(var6_9);
                    }
                    ** GOTO lbl12
                }
                System.out.println("\u5546\u57ce\u8cc7\u6599\u5eab\u64c1\u6709\u4e0d\u5b58\u5728\u7269\u54c1 \u540d\u7a31:" + var5_8.getNote() + " \u7269\u54c1\u4ee3\u78bc:" + var5_8.getId() + " " + (a.ALLATORIxDEMO(var5_8.getNote()) != false ? MapleFamily.ALLATORIxDEMO("N\u001b\u5d9c\u6e45\u960a\u001d") : BBSHandler.ALLATORIxDEMO("x\u6e26\u9647\u5912\u6574~")));
                ** GOTO lbl12
            }
            a.a.put(var5_8.getSN(), var5_8);
            a.d.put(var5_8.getId(), var5_8);
            if (!var5_8.isOnSale()) ** GOTO lbl12
            var6_9 = a.B.get(var5_8.getSN());
            var5_8.initFlags(var6_9);
            ** GOTO lbl12
lbl77:
            // 1 sources

            var4_6.close();
            var3_4.close();
            if (var2_2 == null) return;
        }
        var2_2.close();
    }

    public static /* synthetic */ {
        E = new CashItemFactory();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void addModItem(CashModItem a22) {
        CashItemFactory a3;
        if (a22.getId() == 0) {
            if (a3.B == null || !a3.B.containsKey(a22.getSN())) {
                return;
            }
            a22.setId(a3.B.get(a22.getSN()).getId());
        }
        if (a3.a.containsKey(a22.getSN())) return;
        CashItemFactory cashItemFactory = a3;
        CashModItem cashModItem = a22;
        cashItemFactory.a.put(cashModItem.getSN(), a22);
        cashModItem.initFlags(cashItemFactory.B.get(a22.getSN()) != null ? a3.B.get(a22.getSN()) : null);
        PreparedStatement preparedStatement = null;
        try {
            DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
            try {
                PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(BBSHandler.ALLATORIxDEMO("jmpfqw\u0003jmwl\u0003@BPKPKLS|JWFNP\u0003\u000bpm\u000f\u0003mLWF\u000f\u0003jWFNjG\u000f\u0003`LVMW\u000f\u0003sQJ@F\u000f\u0003sFQJLG\u000f\u0003dFMGFQ\u000f\u0003`OBPP\u000f\u0003lMpBOF\n\u0003ubovfp\u0003\u000b\u001c\u000f\u0003\u001c\u000f\u0003\u001c\u000f\u0003\u001c\u000f\u0003\u001c\u000f\u0003\u001c\u000f\u0003\u001c\u000f\u0003\u001c\u000f\u0003\u001c\n"));
                PreparedStatement preparedStatement3 = preparedStatement;
                PreparedStatement preparedStatement4 = preparedStatement;
                PreparedStatement preparedStatement5 = preparedStatement;
                preparedStatement.setInt(1, a22.getSN());
                preparedStatement5.setString(2, a22.getNote());
                preparedStatement5.setInt(3, a22.getId());
                preparedStatement4.setInt(4, a22.getCount());
                preparedStatement4.setInt(5, a22.getPrice());
                preparedStatement3.setInt(6, a22.getPeriod());
                preparedStatement3.setInt(7, a22.getGender());
                preparedStatement2.setInt(8, a22.getFlage());
                preparedStatement2.setInt(9, a22.isOnSale() ? 1 : 0);
                PreparedStatement preparedStatement6 = preparedStatement;
                preparedStatement6.execute();
                preparedStatement6.close();
                if (druidPooledConnection == null) return;
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (Throwable a22) {
                        throwable.addSuppressed(a22);
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
            druidPooledConnection.close();
            return;
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
    }

    public final /* synthetic */ Collection<CashModItem> getAllModInfoId() {
        CashItemFactory a2;
        return a2.d.values();
    }
}

