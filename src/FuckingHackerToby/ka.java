/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import java.util.ArrayList;
import java.util.function.Consumer;

public abstract class ka<T> {
    private /* synthetic */ ArrayList<T> ALLATORIxDEMO;

    public /* synthetic */ ka() {
        ka a2;
        ka ka2 = a2;
        ka2.ALLATORIxDEMO = new ArrayList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void l() {
        ka a2;
        ArrayList<T> arrayList = a2.ALLATORIxDEMO;
        synchronized (arrayList) {
            a2.ALLATORIxDEMO.clear();
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void ALLATORIxDEMO(Consumer<? super T> a2) {
        ka a3;
        ArrayList<T> arrayList = a3.ALLATORIxDEMO;
        synchronized (arrayList) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < a3.ALLATORIxDEMO.size()) {
                T t2 = a3.ALLATORIxDEMO.get(n2);
                a2.accept(t2);
                n3 = ++n2;
            }
            return;
        }
    }

    public static /* synthetic */ String H(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 5;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 2 << 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ 3 << 1;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void ALLATORIxDEMO(T a2) {
        ka a3;
        ArrayList<T> arrayList = a3.ALLATORIxDEMO;
        synchronized (arrayList) {
            a3.ALLATORIxDEMO.remove(a2);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void H(T a2) {
        ka a3;
        ArrayList<T> arrayList = a3.ALLATORIxDEMO;
        synchronized (arrayList) {
            a3.ALLATORIxDEMO.add(a2);
            return;
        }
    }
}

