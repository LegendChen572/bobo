/*
 * Decompiled with CFR 0.150.
 */
package server;

public class CashItem {
    private /* synthetic */ int H;
    private /* synthetic */ boolean k;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int B;
    private /* synthetic */ boolean a;
    private /* synthetic */ boolean K;
    private /* synthetic */ int g;
    private /* synthetic */ int F;
    private /* synthetic */ int E;
    private /* synthetic */ int C;
    private /* synthetic */ int I;
    private /* synthetic */ int d;
    private /* synthetic */ int e;

    public /* synthetic */ int getFlage() {
        CashItem a2;
        return a2.B;
    }

    public /* synthetic */ void setTimeBegin(int a2) {
        a.d = a2;
    }

    public /* synthetic */ void setCount(int a2) {
        a.C = a2;
    }

    public /* synthetic */ void setGashOnly(boolean a2) {
        a.K = a2;
    }

    public /* synthetic */ void setTimeEnd(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void setOnSale(boolean a2) {
        a.k = a2;
    }

    public /* synthetic */ void setSN(int a2) {
        a.e = a2;
    }

    public /* synthetic */ void setGender(int a2) {
        a.g = a2;
    }

    public /* synthetic */ CashItem(int a2, int a3, int a4, int a5, int a6, int a7, int a8, boolean a9, boolean a10, boolean a11) {
        CashItem a12;
        CashItem cashItem = a12;
        CashItem cashItem2 = a12;
        CashItem cashItem3 = a12;
        CashItem cashItem4 = a12;
        CashItem cashItem5 = a12;
        CashItem cashItem6 = a12;
        a12.e = a2;
        cashItem6.F = a3;
        cashItem6.C = a4;
        cashItem5.H = a5;
        cashItem5.E = a6;
        cashItem4.g = a7;
        cashItem4.B = a8;
        cashItem3.k = a10;
        cashItem3.K = a9;
        cashItem2.I = 0;
        cashItem2.d = 0;
        cashItem.ALLATORIxDEMO = 0;
        cashItem.a = a11;
    }

    public /* synthetic */ void setPeriod(int a2) {
        a.E = a2;
    }

    public /* synthetic */ void setMark(boolean a2) {
        a.a = a2;
    }

    public /* synthetic */ int getTimeEnd(int a2) {
        CashItem a3;
        return a3.ALLATORIxDEMO;
    }

    public /* synthetic */ int getGender() {
        CashItem a2;
        return a2.g;
    }

    public /* synthetic */ void setPrice(int a2) {
        a.H = a2;
    }

    public /* synthetic */ void setPriority(int a2) {
        a.I = a2;
    }

    public /* synthetic */ boolean genderEquals(int a2) {
        CashItem a3;
        return a2 == a3.g || a3.g == 2;
    }

    public /* synthetic */ void setFlage(int a2) {
        a.B = a2;
    }

    public /* synthetic */ int getPriority() {
        CashItem a2;
        return a2.I;
    }

    public /* synthetic */ int getCount() {
        CashItem a2;
        if (a2.C == 0) {
            return 1;
        }
        return a2.C;
    }

    public /* synthetic */ int getId() {
        CashItem a2;
        return a2.F;
    }

    public /* synthetic */ boolean isMark() {
        CashItem a2;
        return a2.a;
    }

    public /* synthetic */ int getTimeBegin(int a2) {
        CashItem a3;
        return a3.d;
    }

    public /* synthetic */ int getSN() {
        CashItem a2;
        return a2.e;
    }

    public /* synthetic */ boolean isGashOnly() {
        CashItem a2;
        return a2.K;
    }

    public /* synthetic */ int getPeriod() {
        CashItem a2;
        return a2.E;
    }

    public /* synthetic */ boolean isOnSale() {
        CashItem a2;
        return a2.k;
    }

    public /* synthetic */ void setId(int a2) {
        a.F = a2;
    }

    public /* synthetic */ int getPrice() {
        CashItem a2;
        return a2.H;
    }
}

