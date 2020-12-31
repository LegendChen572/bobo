/*
 * Decompiled with CFR 0.150.
 */
package server;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StructSetItem {
    public /* synthetic */ Map<Integer, SetItem> items;
    public /* synthetic */ int completeCount;
    public /* synthetic */ int setItemID;
    public /* synthetic */ List<String> itemIDs;

    public /* synthetic */ StructSetItem() {
        StructSetItem a2;
        StructSetItem structSetItem = a2;
        a2.items = new LinkedHashMap<Integer, SetItem>();
        structSetItem.itemIDs = new ArrayList<String>();
    }

    public /* synthetic */ Map<Integer, SetItem> getItems() {
        StructSetItem a2;
        return new LinkedHashMap<Integer, SetItem>(a2.items);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 2 << 1;
        int cfr_ignored_0 = 5 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 4 << 3 ^ (3 ^ 5);
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

    public static class SetItem {
        public /* synthetic */ int incDEX;
        public /* synthetic */ int option3;
        public /* synthetic */ int incPAD;
        public /* synthetic */ int incACC;
        public /* synthetic */ int incMHPr;
        public /* synthetic */ int option1;
        public /* synthetic */ int incMMP;
        public /* synthetic */ int incMHP;
        public /* synthetic */ int incAllStat;
        public /* synthetic */ int incLUK;
        public /* synthetic */ int incMAD;
        public /* synthetic */ int incMDD;
        public /* synthetic */ int option2;
        public /* synthetic */ int incMMPr;
        public /* synthetic */ int option1Level;
        public /* synthetic */ int incSTR;
        public /* synthetic */ int incPDD;
        public /* synthetic */ int option3Level;
        public /* synthetic */ int option2Level;
        public /* synthetic */ int incSpeed;
        public /* synthetic */ int incINT;

        public /* synthetic */ SetItem() {
            SetItem a2;
        }
    }
}

