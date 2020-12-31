/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package handling.world.weather;

import client.messages.commands.GM.\u65b0\u661f\u8c37;
import database.DatabaseException;

public final class WeatherType
extends Enum<WeatherType> {
    public static final /* synthetic */ /* enum */ WeatherType \u50be\u76c6\u5927\u96e8;
    public static final /* synthetic */ /* enum */ WeatherType \u7121;
    private static final /* synthetic */ WeatherType[] ALLATORIxDEMO;
    private /* synthetic */ double e;
    public static final /* synthetic */ /* enum */ WeatherType \u967d\u5149\u666e\u7167;
    private /* synthetic */ double g;
    private /* synthetic */ double k;
    private /* synthetic */ int C;
    public static final /* synthetic */ /* enum */ WeatherType \u98a8\u548c\u65e5\u9e97;
    private /* synthetic */ double B;
    public static final /* synthetic */ /* enum */ WeatherType \u9b54\u96f2\u74b0\u7e5e;
    private /* synthetic */ double d;
    private /* synthetic */ int H;
    private /* synthetic */ String F;
    private /* synthetic */ double K;
    public static final /* synthetic */ /* enum */ WeatherType \u71b1\u6d6a\u4f86\u8972;
    private /* synthetic */ double E;
    private /* synthetic */ double a;
    public static final /* synthetic */ /* enum */ WeatherType \u767d\u96ea\u98c4\u63da;

    public /* synthetic */ double getDropRate() {
        WeatherType a2;
        return a2.E;
    }

    public /* synthetic */ String getInfo() {
        WeatherType a2;
        return a2.F;
    }

    public static /* synthetic */ WeatherType valueOf(String a2) {
        return Enum.valueOf(WeatherType.class, a2);
    }

    public static /* synthetic */ {
        \u7121 = new WeatherType(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u716b"), 0, 0, "", 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 60);
        \u98a8\u548c\u65e5\u9e97 = new WeatherType(DatabaseException.ALLATORIxDEMO("\u98f4\u54a6\u65b9\u9ebd"), 1, 1, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6b85\u527b\u9452\u56a3\u5fe3\u4e7d\u5300\u883d\u9185"), 1.0, 1.0, 1.0, 50.0, 0.0, 1.0, 1.0, 0.0, 60);
        \u50be\u76c6\u5927\u96e8 = new WeatherType(DatabaseException.ALLATORIxDEMO("\u50e2\u76ec\u597b\u96c2"), 2, 2, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6bb2\u7998\u601f\u5fe3Lo\u9b29\u52d1"), 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1);
        \u967d\u5149\u666e\u7167 = new WeatherType(DatabaseException.ALLATORIxDEMO("\u9621\u5163\u6632\u714d"), 3, 3, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6bb2\u7998\u601f\u5fe3Lo\u7562\u5437"), 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1);
        \u71b1\u6d6a\u4f86\u8972 = new WeatherType(DatabaseException.ALLATORIxDEMO("\u71ed\u6d40\u4fda\u8958"), 4, 4, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6bb2\u524c\u9465\u6e51\u5c6c\u9b1e\u52e6xMo"), 1.0, 1.0, 1.0, 1.0, 0.2, 1.0, 1.0, 0.0, 60);
        \u767d\u96ea\u98c4\u63da = new WeatherType(DatabaseException.ALLATORIxDEMO("\u7621\u96c0\u9898\u63f0"), 5, 5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6b85\u527b\u9452\u56a3\u5fe3\u4e7d\u5300\u9b29\u9185"), 1.0, 1.0, 1.0, 1.0, 50.0, 1.0, 1.0, 0.0, 60);
        \u9b54\u96f2\u74b0\u7e5e = new WeatherType(DatabaseException.ALLATORIxDEMO("\u9b08\u96d8\u74ec\u7e74"), 6, 6, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6546\u6480\u52e6\u9607\u4f33\u70f0\u53e2\u5102\u4e7d\u5300"), 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, -50.0, 0);
        WeatherType[] arrweatherType = new WeatherType[7];
        arrweatherType[0] = \u7121;
        arrweatherType[1] = \u98a8\u548c\u65e5\u9e97;
        arrweatherType[2] = \u50be\u76c6\u5927\u96e8;
        arrweatherType[3] = \u967d\u5149\u666e\u7167;
        arrweatherType[4] = \u71b1\u6d6a\u4f86\u8972;
        arrweatherType[5] = \u767d\u96ea\u98c4\u63da;
        arrweatherType[6] = \u9b54\u96f2\u74b0\u7e5e;
        ALLATORIxDEMO = arrweatherType;
    }

    public /* synthetic */ double getAtk() {
        WeatherType a2;
        return a2.d;
    }

    public static /* synthetic */ WeatherType[] values() {
        return (WeatherType[])ALLATORIxDEMO.clone();
    }

    public /* synthetic */ int getDelay() {
        WeatherType a2;
        return a2.H;
    }

    public /* synthetic */ double getMesoRate() {
        WeatherType a2;
        return a2.g;
    }

    public /* synthetic */ double getExpRate() {
        WeatherType a2;
        return a2.e;
    }

    public /* synthetic */ double getMobMp() {
        WeatherType a2;
        return a2.a;
    }

    public /* synthetic */ double getChrHp() {
        WeatherType a2;
        return a2.B;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ WeatherType(int n22, String n22, double a2, double a3, double a4, double a5, double a6, double a7, double a8, double a9, int a10) {
        void a11;
        void a12;
        void var2_-1;
        void var1_-1;
        WeatherType a13;
        WeatherType weatherType = a13;
        WeatherType weatherType2 = a13;
        WeatherType weatherType3 = a13;
        WeatherType weatherType4 = a13;
        WeatherType weatherType5 = a13;
        a13.C = (int)a2;
        weatherType5.F = a12;
        weatherType5.e = a3;
        weatherType4.E = a4;
        weatherType4.g = a5;
        weatherType3.B = a6;
        weatherType3.k = a7;
        weatherType2.K = a8;
        weatherType2.a = a9;
        weatherType.d = a10;
        weatherType.H = a11;
    }

    public /* synthetic */ double getChrMp() {
        WeatherType a2;
        return a2.k;
    }

    public /* synthetic */ double getMobHp() {
        WeatherType a2;
        return a2.K;
    }
}

