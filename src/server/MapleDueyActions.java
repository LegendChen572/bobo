/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.inventory.IItem;

public class MapleDueyActions {
    private /* synthetic */ long a;
    private /* synthetic */ int K;
    private /* synthetic */ IItem B;
    private /* synthetic */ String g;
    private /* synthetic */ String ALLATORIxDEMO;
    private /* synthetic */ int k;
    private /* synthetic */ int d;

    public /* synthetic */ int getMesos() {
        MapleDueyActions a2;
        return a2.k;
    }

    public /* synthetic */ long getSentTime() {
        MapleDueyActions a2;
        return a2.a;
    }

    public /* synthetic */ int getPackageId() {
        MapleDueyActions a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 1;
        int n5 = n3;
        int n6 = 5 << 4 ^ (2 ^ 5);
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

    public /* synthetic */ void setMesos(int a2) {
        a.k = a2;
    }

    public /* synthetic */ IItem getItem() {
        MapleDueyActions a2;
        return a2.B;
    }

    public /* synthetic */ MapleDueyActions(int a2) {
        MapleDueyActions a3;
        MapleDueyActions mapleDueyActions = a3;
        MapleDueyActions mapleDueyActions2 = a3;
        MapleDueyActions mapleDueyActions3 = a3;
        a3.g = null;
        mapleDueyActions3.B = null;
        mapleDueyActions3.k = 0;
        mapleDueyActions2.K = 1;
        mapleDueyActions2.d = 0;
        mapleDueyActions.ALLATORIxDEMO = null;
        mapleDueyActions.d = a2;
    }

    public /* synthetic */ void setSentTime(long a2) {
        a.a = a2;
    }

    public /* synthetic */ void setMsg(String a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ MapleDueyActions(int a2, IItem a3) {
        MapleDueyActions a4;
        MapleDueyActions mapleDueyActions = a4;
        MapleDueyActions mapleDueyActions2 = a4;
        MapleDueyActions mapleDueyActions3 = a4;
        MapleDueyActions mapleDueyActions4 = a4;
        mapleDueyActions4.g = null;
        mapleDueyActions4.B = null;
        mapleDueyActions3.k = 0;
        mapleDueyActions3.K = 1;
        mapleDueyActions2.d = 0;
        mapleDueyActions2.ALLATORIxDEMO = null;
        a4.B = a3;
        mapleDueyActions.K = a4.B.getQuantity();
        mapleDueyActions.d = a2;
    }

    public /* synthetic */ String getSender() {
        MapleDueyActions a2;
        return a2.g;
    }

    public /* synthetic */ String getMsg() {
        MapleDueyActions a2;
        return "13" + a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getQuantity() {
        MapleDueyActions a2;
        return a2.K;
    }

    public /* synthetic */ void setSender(String a2) {
        a.g = a2;
    }
}

