/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package tools.wztosql;

import com.alibaba.druid.pool.DruidPooledConnection;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.life.MobNameData;
import tools.ArrayMap;
import tools.KoreanDateUtil;
import tools.StringUtil;

public class DumpMobName {
    public /* synthetic */ boolean update;
    public /* synthetic */ List<Integer> mobids;
    public /* synthetic */ int no_exist;
    public /* synthetic */ int id;
    public /* synthetic */ boolean hadError;
    public /* synthetic */ List<Integer> alreadymobids;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void dumpMobName() throws Exception {
        DumpMobName a2;
        block18: {
            String string;
            int n2;
            Object object;
            Object object2;
            if (!a2.update) {
                a2.delete(KoreanDateUtil.ALLATORIxDEMO("R?Z?B?6<D5[Za\u0000I\u0017y\u0018r\u001bb\u001b"));
                System.out.println(ArrayMap.ALLATORIxDEMO("\u5245\u9632\u8ca8\u65cf\u8807v\u0018,0;\u00004\u000b7\u001b7O\u6246\u52f0x"));
            }
            Object object3 = MapleDataProviderFactory.getDataProvider(KoreanDateUtil.ALLATORIxDEMO(")b\b\u007f\u0014qTa\u0000"));
            MapleDataProvider mapleDataProvider = MapleDataProviderFactory.getDataProvider(ArrayMap.ALLATORIxDEMO("\"9\rx\u0018,"));
            ArrayList<MobNameData> arrayList = new ArrayList<MobNameData>();
            object3 = object3.getData(KoreanDateUtil.ALLATORIxDEMO("7y\u00188\u0013{\u001d")).getChildren();
            System.out.println(ArrayMap.ALLATORIxDEMO("\u6b35\u5747\u8bd6\u53b9\u6216\u6766\u607c\u7206\u545b\u7a5exAxAx"));
            object3 = object3.iterator();
            block8: while (true) {
                Object object4 = object3;
                while (object4.hasNext()) {
                    int n3;
                    object2 = (MapleData)object3.next();
                    object = "";
                    boolean bl = false;
                    n2 = -1;
                    string = object2.getName();
                    if (a2.isNumeric(string)) {
                        n3 = n2 = Integer.parseInt(string);
                    } else {
                        bl = true;
                        n3 = n2;
                    }
                    if (n3 != -1 && !bl) {
                        object = MapleDataTool.getString(KoreanDateUtil.ALLATORIxDEMO("x\u001b{\u001f"), (MapleData)object2, ArrayMap.ALLATORIxDEMO("\u0018 {!\u0017\"\u0013"));
                    }
                    if (!a2.mobids.contains(n2)) {
                        MapleData mapleData;
                        MapleData mapleData2 = null;
                        try {
                            mapleData = mapleData2 = mapleDataProvider.getData(StringUtil.getLeftPaddedStr(Integer.toString(n2) + ".img", '0', 11));
                        }
                        catch (Exception exception) {
                            mapleData = mapleData2;
                        }
                        if (mapleData != null) {
                            MapleData mapleData3 = mapleData2.getChildByPath(KoreanDateUtil.ALLATORIxDEMO("\u007f\u0014p\u0015"));
                            if (mapleData3 == null) continue block8;
                            int n4 = MapleDataTool.getIntConvert(ArrayMap.ALLATORIxDEMO(":\n \n:"), mapleData3, 0);
                            int n5 = MapleDataTool.getIntConvert(KoreanDateUtil.ALLATORIxDEMO("\u001fn\n"), mapleData3, 0);
                            int n6 = MapleDataTool.getIntConvert(ArrayMap.ALLATORIxDEMO(";\u000e.'\u0006"), mapleData3, 0);
                            int n7 = MapleDataTool.getIntConvert(KoreanDateUtil.ALLATORIxDEMO("\u0017w\u0002[*"), mapleData3, 0);
                            object4 = object3;
                            arrayList.add(new MobNameData(n2, (String)object, n4, n6, n7, n5));
                            a2.mobids.add(n2);
                            continue;
                        }
                    }
                    a2.alreadymobids.add(n2);
                    object4 = object3;
                }
                break;
            }
            System.out.println("\u5df2\u7d93\u8b80\u53d6\u5230" + a2.mobids.size() + "\u500b\u602a\u7269\u540d\u7a31.....");
            System.out.println(ArrayMap.ALLATORIxDEMO("\u6b0c\u577e\u5b84\u5133O!\u0015\t\u00029\r2\u000e\"\u000ev\u4e42xAxAx"));
            object3 = new StringBuilder();
            object2 = KoreanDateUtil.ALLATORIxDEMO("_4E?D.63X.YZa\u0000I\u0017y\u0018r\u001bb\u001b6,W6C?EZ");
            Object object5 = object = arrayList.iterator();
            while (object5.hasNext()) {
                MobNameData mobNameData = (MobNameData)object.next();
                n2 = mobNameData.getMobId();
                string = mobNameData.getMobName();
                ((StringBuilder)object3).append(ArrayMap.ALLATORIxDEMO("~")).append(mobNameData.getMobId()).append(KoreanDateUtil.ALLATORIxDEMO(":]")).append(mobNameData.getMobName()).append(ArrayMap.ALLATORIxDEMO("Hz")).append(mobNameData.getLevel()).append(KoreanDateUtil.ALLATORIxDEMO("V")).append(mobNameData.getMaxHp()).append(ArrayMap.ALLATORIxDEMO("z")).append(mobNameData.getMaxMp()).append(KoreanDateUtil.ALLATORIxDEMO("V")).append(mobNameData.getExp()).append(ArrayMap.ALLATORIxDEMO("Fz"));
                System.out.println("\u6e96\u5099\u5beb\u5165\u602a\u7269: " + n2 + " \u540d\u7a31 " + string);
                object5 = object;
            }
            Object object6 = object3;
            object2 = (String)object2 + ((StringBuilder)object6).substring(0, ((StringBuilder)object6).length() - 1);
            try {
                object = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    PreparedStatement preparedStatement = object.prepareStatement((String)object2);
                    preparedStatement.executeUpdate();
                    if (object == null) break block18;
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (object != null) {
                        try {
                            object.close();
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
                object.close();
            }
            catch (Exception exception) {
                System.out.println("Failed to dump mob " + exception);
            }
        }
        System.out.println("\u4e00\u5171\u6709" + a2.mobids.size() + "\u500b\u602a\u7269, \u91cd\u8907\u4e86" + a2.alreadymobids.size() + "\u500b\u602a\u7269\u4ee3\u78bc(" + a2.alreadymobids.toString() + ")");
        System.out.println(KoreanDateUtil.ALLATORIxDEMO("\u5b91\u5173Za\u0000I\u0017y\u0018r\u001bb\u001b6\u5bf6\u6206T8T"));
    }

    public /* synthetic */ DumpMobName(boolean a2) throws Exception {
        DumpMobName a3;
        DumpMobName dumpMobName = a3;
        DumpMobName dumpMobName2 = a3;
        a3.no_exist = 0;
        DumpMobName dumpMobName3 = a3;
        a3.mobids = new LinkedList<Integer>();
        dumpMobName3.alreadymobids = new LinkedList<Integer>();
        dumpMobName2.hadError = 0;
        dumpMobName2.update = false;
        dumpMobName.id = false ? 1 : 0;
        dumpMobName.update = a2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void delete(String a22) throws Exception {
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        try {
            PreparedStatement preparedStatement = druidPooledConnection.prepareStatement(a22);
            preparedStatement.executeUpdate();
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
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4;
        int cfr_ignored_0 = 3 << 3;
        int n5 = n3;
        int n6 = 2 << 3 ^ 5;
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

    public /* synthetic */ boolean isHadError() {
        DumpMobName a2;
        return a2.hadError;
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(ArrayMap.ALLATORIxDEMO("\\LuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLueuOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvL\\LvOvOvOvOuLvLvOvLvOvOuLvLuLvLuLvLuOvLuLvOvOvOvOueuOvOvOvOuOuOuOvOuOvOuOuOvLvOuOuOuOuOvLvOvOvOvOvL\\LvOvOvOvLuLvLvOvLvOvLuLvOuOvLvLvLuOvOuOvOvOvOvOueuOvOvOvOuOuOuLuOuLuOuOuOvLvOuLuOuOuOuLuOvOvOvOvL\\LvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOueuO\u0019\r0\u001a%\f7\u001b?\u00008O4\u0016v.:\u00037\u001b9\u001d?O\u0019\r0\u001a%\f7\u001b9\u001dv\u0019aAeO\u0012*\u001b vL\\LvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOueuOvOvOvOvOvO>\u001b\"\u001fl@y\u0018!\u0018x\u000e:\u00037\u001b9\u001d?A5\u0000;OvOvOvOvOvOvL\\LvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOvOueuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuLuL\\"));
        boolean bl = false;
        int n2 = 0;
        long l2 = System.currentTimeMillis();
        if (a2 != null) {
            int n3;
            String[] arrstring = a2;
            int n4 = a2.length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                String string = arrstring[n3];
                if (string.equalsIgnoreCase(KoreanDateUtil.ALLATORIxDEMO("Wc\nr\u001bb\u001f"))) {
                    n2 = 1;
                }
                n5 = ++n3;
            }
        }
        int n6 = 0;
        try {
            DumpMobName dumpMobName = new DumpMobName(n2 != 0);
            System.out.println(ArrayMap.ALLATORIxDEMO("\u507d\u51ac\u6045\u723f\u5462\u7a67"));
            dumpMobName.dumpMobName();
            DumpMobName dumpMobName2 = dumpMobName;
            bl |= dumpMobName2.isHadError();
            n6 = dumpMobName2.currentId();
        }
        catch (Exception exception) {
            bl = true;
            exception.printStackTrace();
            System.out.println(n6 + " \u4ee3\u78bc.");
        }
        long l3 = System.currentTimeMillis();
        double d2 = (double)(l3 - l2) / 1000.0;
        n2 = (int)d2 % 60;
        n6 = (int)(d2 / 60.0);
        String string = "";
        if (bl) {
            string = KoreanDateUtil.ALLATORIxDEMO("Z>\u6773\u9339\u8ade?Z");
        }
        System.out.println(string + "\u7d50\u675f\u4f7f\u7528\u4e86 " + n6 + " \u5206\u9418 " + n2 + " \u79d2\u9418");
    }

    public /* synthetic */ boolean isNumeric(String a2) throws Exception {
        return a2.matches(ArrayMap.ALLATORIxDEMO("{P\n\u000b}G\nA\n\u000b}Fi"));
    }

    public /* synthetic */ int currentId() {
        DumpMobName a2;
        return a2.id;
    }
}

