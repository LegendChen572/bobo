/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.Serializable;

public class Triple<E, F, G>
implements Serializable {
    public /* synthetic */ G right;
    private static final /* synthetic */ long ALLATORIxDEMO = 9179541993413739999L;
    public /* synthetic */ E left;
    public /* synthetic */ F mid;

    public /* synthetic */ G getRight() {
        Triple a2;
        return a2.right;
    }

    public /* synthetic */ int hashCode() {
        Triple a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + (a2.left == null ? 0 : a2.left.hashCode());
        n2 = 31 * n2 + (a2.mid == null ? 0 : a2.mid.hashCode());
        n2 = 31 * n2 + (a2.right == null ? 0 : a2.right.hashCode());
        return n2;
    }

    public /* synthetic */ String toString() {
        Triple a2;
        return a2.left.toString() + ":" + a2.mid.toString() + ":" + a2.right.toString();
    }

    public /* synthetic */ Triple(E a2, F a3, G a4) {
        Triple a5;
        Triple triple = a5;
        a5.left = a2;
        triple.mid = a3;
        triple.right = a4;
    }

    public /* synthetic */ E getLeft() {
        Triple a2;
        return a2.left;
    }

    public /* synthetic */ boolean equals(Object a2) {
        Triple a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (Triple)a2;
        if (a3.left == null ? ((Triple)a2).left != null : !a3.left.equals(((Triple)a2).left)) {
            return false;
        }
        if (a3.mid == null ? ((Triple)a2).mid != null : !a3.mid.equals(((Triple)a2).mid)) {
            return false;
        }
        return !(a3.right == null ? ((Triple)a2).right != null : !a3.right.equals(((Triple)a2).right));
    }

    public /* synthetic */ F getMid() {
        Triple a2;
        return a2.mid;
    }
}

