/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.Extend;

import client.MapleCharacter;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import handling.channel.handler.BuddyListHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import server.Extend.SpecialEquipData;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.database.UniqueIdReset;

public class SpecialEquipFactory {
    public final /* synthetic */ Map<Integer, SpecialEquipData> SpecialEquipCache;
    private static final /* synthetic */ SpecialEquipFactory ALLATORIxDEMO;

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void loadSpecialEquip() {
        SpecialEquipFactory a2;
        a2.SpecialEquipCache.clear();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(BuddyListHandler.ALLATORIxDEMO("i2v2y#\u001a]\u001a1h8wWI\u0007_\u0014S\u0016V(_\u0006O\u001eJ"));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int n2 = resultSet.getInt(UniqueIdReset.ALLATORIxDEMO("o\u0013c\no\u0003"));
            SpecialEquipData specialEquipData = new SpecialEquipData(n2, resultSet.getInt(BuddyListHandler.ALLATORIxDEMO("_\u000fJ")), resultSet.getInt(UniqueIdReset.ALLATORIxDEMO("b\u0015i\u0017")), resultSet.getInt(BuddyListHandler.ALLATORIxDEMO("\u001a_\u0004U")), resultSet.getInt(UniqueIdReset.ALLATORIxDEMO("\u0014m\u000ej\u000b")), resultSet.getInt(BuddyListHandler.ALLATORIxDEMO("\u0004Q\u001eV\u001bV\u0012L\u0012V")), resultSet.getInt(UniqueIdReset.ALLATORIxDEMO("b\u0006k\u0006a\u0002")), resultSet.getInt(BuddyListHandler.ALLATORIxDEMO("\u001aU\u0015I\u0007[\u0000T")), resultSet.getInt(UniqueIdReset.ALLATORIxDEMO("\u0011g\u0004")));
            a2.SpecialEquipCache.put(n2, specialEquipData);
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
            return;
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block11: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block11;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                    }
                    throw throwable2;
                }
                catch (SQLException sQLException) {
                    System.out.println(sQLException);
                }
            }
        }
    }

    public /* synthetic */ void getTotalEquipSkill(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return;
        }
        int n2 = 0;
        int n3 = 0;
        Iterator<IItem> iterator = a2.getInventory(MapleInventoryType.EQUIPPED).iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            IItem iItem = iterator.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n2 = a3.SpecialEquipCache.get(iItem.getItemId()).getSkill();
            n3 = a3.SpecialEquipCache.get(iItem.getItemId()).getSkillLevel();
            int n4 = a2.getSkillLevel(n2);
            if (n3 <= 0 || n3 <= n4) continue;
            int n5 = n3;
            a2.getClient().sendPacket(MaplePacketCreator.updateSkill(n2, n5, n5, -1L));
        }
    }

    public /* synthetic */ int getVac(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).iterator();
        int n2 = 0;
        while (a2.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n2 += a3.SpecialEquipCache.get(iItem.getItemId()).getVac();
        }
        return n2;
    }

    public /* synthetic */ SpecialEquipFactory() {
        SpecialEquipFactory a2;
        SpecialEquipFactory specialEquipFactory = a2;
        specialEquipFactory.SpecialEquipCache = new HashMap<Integer, SpecialEquipData>();
        System.out.println(UniqueIdReset.ALLATORIxDEMO("\u3077\u8b86\u53b1\u4e2b\u3076&4v\u0002e\u000eg\u000bC\u0016s\u000ev!g\u0004r\bt\u001e&]<]"));
    }

    public /* synthetic */ int getTotalEquipExp(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).iterator();
        int n2 = 0;
        while (a2.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n2 += a3.SpecialEquipCache.get(iItem.getItemId()).getExp();
        }
        return n2;
    }

    public /* synthetic */ int getTotalEquipMeso(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).iterator();
        int n2 = 0;
        while (a2.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n2 += a3.SpecialEquipCache.get(iItem.getItemId()).getMeso();
        }
        return n2;
    }

    public /* synthetic */ int getTotalEquipDrop(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).iterator();
        int n2 = 0;
        while (a2.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n2 += a3.SpecialEquipCache.get(iItem.getItemId()).getDrop();
        }
        return n2;
    }

    public /* synthetic */ boolean hasEquipSkill(MapleCharacter a2, int a3) {
        int n2;
        int n3;
        SpecialEquipFactory a4;
        if (a4.SpecialEquipCache.isEmpty()) {
            return false;
        }
        Iterator<IItem> iterator = a2.getInventory(MapleInventoryType.EQUIPPED).iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            IItem iItem = iterator.next();
            if (!a4.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n3 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkill();
            n2 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkillLevel();
            if (n3 != a3 || n2 <= 0) continue;
            return true;
        }
        for (IItem iItem : a2.getInventory(MapleInventoryType.EQUIP)) {
            if (!a4.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n3 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkill();
            n2 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkillLevel();
            if (n3 != a3 || n2 <= 0) continue;
            return true;
        }
        return false;
    }

    public static final /* synthetic */ SpecialEquipFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public /* synthetic */ int getEquipSkillLevel(MapleCharacter a2, int a3) {
        int n2;
        int n3;
        SpecialEquipFactory a4;
        if (a4.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        Iterator<IItem> iterator = a2.getInventory(MapleInventoryType.EQUIPPED).iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            IItem iItem = iterator.next();
            if (!a4.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n3 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkill();
            n2 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkillLevel();
            if (n3 != a3 || n2 <= 0) continue;
            return n2;
        }
        for (IItem iItem : a2.getInventory(MapleInventoryType.EQUIP)) {
            if (!a4.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n3 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkill();
            n2 = a4.SpecialEquipCache.get(iItem.getItemId()).getSkillLevel();
            if (n3 != a3 || n2 <= 0) continue;
            return n2;
        }
        return 0;
    }

    public /* synthetic */ int getTotalEquipDamage(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).iterator();
        int n2 = 0;
        while (a2.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId())) continue;
            n2 += a3.SpecialEquipCache.get(iItem.getItemId()).getDamage();
        }
        return n2;
    }

    public /* synthetic */ Pair<Integer, Integer> getSkillByEquipId(int a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return null;
        }
        int n2 = 0;
        int n3 = 0;
        if (a3.SpecialEquipCache.containsKey(a2)) {
            n2 = a3.SpecialEquipCache.get(a2).getSkill();
            n3 = a3.SpecialEquipCache.get(a2).getSkillLevel();
        }
        if (n3 == 0) {
            return null;
        }
        return new Pair<Integer, Integer>(n2, n3);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new SpecialEquipFactory();
    }

    public /* synthetic */ int getMobSpawn(MapleCharacter a2) {
        SpecialEquipFactory a3;
        if (a3.SpecialEquipCache.isEmpty()) {
            return 0;
        }
        a2 = ((MapleCharacter)a2).getInventory(MapleInventoryType.EQUIPPED).iterator();
        int n2 = 0;
        while (a2.hasNext()) {
            IItem iItem = (IItem)a2.next();
            if (!a3.SpecialEquipCache.containsKey(iItem.getItemId()) || a3.SpecialEquipCache.get(iItem.getItemId()).getMobSpawn() <= n2) continue;
            n2 = a3.SpecialEquipCache.get(iItem.getItemId()).getMobSpawn();
        }
        return n2;
    }
}

