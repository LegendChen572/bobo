/*
 * Decompiled with CFR 0.150.
 */
package server;

import java.util.LinkedList;
import java.util.List;
import server.CashItem;
import server.CashItemFlag;

public class CashModItem
extends CashItem {
    public /* synthetic */ List<CashItemFlag> flags;
    private /* synthetic */ String ALLATORIxDEMO;

    public /* synthetic */ CashModItem(int a2, String a3, int a4, int a5, int a6, int a7, int a8, int a9, boolean a10, boolean a11, boolean a12) {
        super(a2, a4, a5, a6, a7, a8, a9, a10, a11, a12);
        CashModItem a13;
        CashModItem cashModItem = a13;
        a13.flags = new LinkedList<CashItemFlag>();
        a13.ALLATORIxDEMO = a3;
    }

    public /* synthetic */ void initFlags(CashItem a2) {
        CashModItem a3;
        if (a2 != null && a2.getSN() != a3.getSN()) {
            return;
        }
        if (a2 == null || a2.getId() != a3.getId()) {
            a3.flags.add(CashItemFlag.ITEMID);
        }
        if (a2 == null || a2.getCount() != a3.getCount()) {
            a3.flags.add(CashItemFlag.COUNT);
        }
        if (a2 == null || a2.getPrice() != a3.getPrice()) {
            a3.flags.add(CashItemFlag.PRICE);
        }
        if (a2 == null || a2.getPeriod() != a3.getPeriod()) {
            a3.flags.add(CashItemFlag.PERIOD);
        }
        if (a2 == null || a2.getGender() != a3.getGender()) {
            a3.flags.add(CashItemFlag.GENDER);
        }
        if (a2 == null || a2.isOnSale() != a3.isOnSale()) {
            a3.flags.add(CashItemFlag.ONSALE);
        }
        if (a2 == null || a2.getFlage() != a3.getFlage()) {
            a3.flags.add(CashItemFlag.FLAGE);
        }
        if (a2 == null && a3.flags.isEmpty()) {
            a3.flags.add(CashItemFlag.ONSALE);
            a3.flags.add(CashItemFlag.GENDER);
        }
    }

    public /* synthetic */ String getNote() {
        CashModItem a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setNote(String a2) {
        a.ALLATORIxDEMO = a2;
    }
}

