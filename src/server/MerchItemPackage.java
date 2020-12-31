/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.inventory.IItem;
import java.util.ArrayList;
import java.util.List;

public class MerchItemPackage {
    private /* synthetic */ long K;
    private /* synthetic */ int a;
    private /* synthetic */ int d;
    private /* synthetic */ List<IItem> ALLATORIxDEMO;

    public /* synthetic */ MerchItemPackage() {
        MerchItemPackage a2;
        a2.a = 0;
        MerchItemPackage merchItemPackage = a2;
        a2.ALLATORIxDEMO = new ArrayList<IItem>();
    }

    public /* synthetic */ long getSentTime() {
        MerchItemPackage a2;
        return a2.K;
    }

    public /* synthetic */ int getMesos() {
        MerchItemPackage a2;
        return a2.a;
    }

    public /* synthetic */ void setItems(List<IItem> a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ List<IItem> getItems() {
        MerchItemPackage a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setPackageid(int a2) {
        a.d = a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 4;
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 4;
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

    public /* synthetic */ void setSentTime(long a2) {
        a.K = a2;
    }

    public /* synthetic */ void setMesos(int a2) {
        a.a = a2;
    }

    public /* synthetic */ int getPackageid() {
        MerchItemPackage a2;
        return a2.d;
    }
}

