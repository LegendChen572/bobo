/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 */
package tools;

import client.SkillEntry;
import client.messages.commands.player.\u6070\u6070\u8c37;
import database.DBConPool;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.MapleItemInformationProvider;

public class FixShopItemsPrice {
    public static /* synthetic */ void main(String[] a2) {
        System.out.println(SkillEntry.ALLATORIxDEMO("\u001f\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126;6\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u0012\u001f\u00125\u00115\u00115\u00115\u00116\u00125\u00125\u00115\u00125\u00115\u00116\u00125\u00126\u00125\u00126\u00125\u00126\u00115\u00126\u00125\u00115\u00115\u00115\u00116;6\u00115\u00115\u00115\u00116\u00116\u00116\u00115\u00116\u00115\u00116\u00116\u00115\u00125\u00116\u00116\u00116\u00116\u00115\u00125\u00115\u00115\u00115\u00115\u0012\u001f\u00125\u00115\u00115\u00115\u00126\u00125\u00125\u00115\u00125\u00115\u00126\u00125\u00116\u00115\u00125\u00125\u00126\u00115\u00116\u00115\u00115\u00115\u00115\u00116;6\u00115\u00115\u00115\u00116\u00116\u00116\u00126\u00116\u00126\u00116\u00116\u00115\u00125\u00116\u00126\u00116\u00116\u00116\u00126\u00115\u00115\u00115\u00115\u0012\u001f\u00125\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00116;6\u0011ZSsDfRtE|^{\u0011wH5py]tEzC|\u0011ZSsDfRtEzC5G\"\u001f&\u0011QtX~5\u0012\u001f\u00125\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00116;6\u00115\u00115\u00115\u00115\u00115\u0011}EaA/\u001e:FbF;Py]tEzC|\u001fv^x\u00115\u00115\u00115\u00115\u00115\u00115\u0012\u001f\u00125\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00115\u00116;6\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u00126\u0012\u001f"));
        FixShopItemsPrice fixShopItemsPrice = new FixShopItemsPrice();
        System.out.println(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u6b20\u5746\u52e3\u8f67\u9010\u5119\u653b\u64b4m@m@m@"));
        MapleItemInformationProvider.getInstance().loadEtc(false);
        MapleItemInformationProvider.getInstance().loadItems(false);
        System.out.println(SkillEntry.ALLATORIxDEMO("\u6b52\u573d\u8bb1\u53c3\u5577\u5e82\u6271\u671c\u5577\u54d4\u001f;\u001f;\u001f;"));
        Object object = fixShopItemsPrice.ALLATORIxDEMO();
        System.out.println(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u6b20\u5746\u8616\u7468\u5505\u5ef9\u5505\u54af\u50ba\u6852m@m@m@"));
        Object object2 = object = object.iterator();
        while (object2.hasNext()) {
            int n2 = (Integer)object.next();
            object2 = object;
            fixShopItemsPrice.ALLATORIxDEMO(n2);
        }
        System.out.println(SkillEntry.ALLATORIxDEMO("\u8640\u7437\u5553\u5ea6\u5553\u54f0\u50ec\u680d\u7565\u5e09\u7d45\u676e\u3017"));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ List<Integer> ALLATORIxDEMO() {
        arrayList = new ArrayList<Integer>();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0010+\u000f+\u0000:c\u00077\u000b.\u0007'N\u0005<\f#c\u001d+\u00013\u00077\u000b.\u001dc!\u0011*\u0006<c,\u001aN*\u001a&\u0003*\n"));
        resultSet = preparedStatement.executeQuery();
        n2 = 0;
        block9: while (true) {
            v0 = resultSet;
            while (v0.next()) {
                if (n2 == resultSet.getInt(SkillEntry.ALLATORIxDEMO("XaTxXq"))) continue block9;
                v1 = resultSet;
                v0 = v1;
                n2 = v1.getInt(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"*\u001a&\u0003*\n"));
                arrayList.add(n2);
            }
            break;
        }
        resultSet.close();
        preparedStatement.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block13;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (SQLException sQLException) {
                    System.err.println(SkillEntry.ALLATORIxDEMO("\u7110\u6cc0\u8f38\u5170\u5577\u5e82"));
                }
            }
        }
        return arrayList;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void ALLATORIxDEMO(int a2) {
        mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"=\u0006\"\u0006-\u0017N0\u0006,\u001e*\noN3\u001c*\r&N\u0005<\f#c\u001d+\u00013\u00077\u000b.\u001dc9\u000b+\u0011+c\u00077\u000b.\u0007'N~N|N\f<\u0007+\u0011N\u00017c\u001e1\u0007 \u000b"));
        preparedStatement.setInt(1, a2);
        resultSet = preparedStatement.executeQuery();
        block9: while (true) {
            v0 = resultSet;
            while (v0.next()) {
                if (!(mapleItemInformationProvider.getPrice(a2) > (double)resultSet.getLong(SkillEntry.ALLATORIxDEMO("eC|Rp"))) || resultSet.getLong(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001e1\u0007 \u000b")) == 0L || !(mapleItemInformationProvider.getPrice(a2) > 1.0)) continue block9;
                System.out.println("\u9053\u5177: " + MapleItemInformationProvider.getInstance().getName(a2) + "\u9053\u5177ID: " + a2 + " \u5546\u5e97: " + resultSet.getInt(SkillEntry.ALLATORIxDEMO("B}^eXq")) + " \u539f\u50f9\u683c: " + resultSet.getLong(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u001e1\u0007 \u000b")) + " \u65b0\u50f9\u683c:" + (long)mapleItemInformationProvider.getPrice(a2));
                preparedStatement2 = druidPooledConnection.prepareStatement(SkillEntry.ALLATORIxDEMO("dEuTeP\u0011fYzA|Ep\\f\u0011FtA\u0011eC|Rp\u0011(\u0011*\u0011ByPcP\u0011|Ep\\|U5\f5\u000e5p[u5B}^eXq\u0011(\u0011*"));
                v0 = resultSet;
                v1 = preparedStatement2;
                preparedStatement2.setLong(1, (long)mapleItemInformationProvider.getPrice(a2));
                v1.setInt(2, a2);
                v1.setInt(3, resultSet.getInt(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"0\u0006,\u001e*\n")));
                v1.execute();
                preparedStatement2.close();
            }
            break;
        }
        resultSet.close();
        preparedStatement.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block13;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (SQLException sQLException) {
                    System.out.println("\u8655\u7406\u5546\u54c1\u5931\u6557, \u9053\u5177ID:" + a2);
                }
            }
        }
    }

    public /* synthetic */ FixShopItemsPrice() {
        FixShopItemsPrice a2;
    }
}

