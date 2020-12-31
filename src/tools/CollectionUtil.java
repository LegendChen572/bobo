/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {
    public static /* synthetic */ <T> List<T> copyFirst(List<T> a2, int a3) {
        ArrayList<T> arrayList = new ArrayList<T>(a2.size() < a3 ? a2.size() : a3);
        int n2 = 0;
        for (T t2 : a2) {
            int n3 = n2++;
            arrayList.add(t2);
            if (n3 <= a3) continue;
            return arrayList;
        }
        return arrayList;
    }

    private /* synthetic */ CollectionUtil() {
        CollectionUtil a2;
    }
}

