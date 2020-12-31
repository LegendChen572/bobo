/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.Serializable;

public class Pair<E, F>
implements Serializable {
    private static final /* synthetic */ long ALLATORIxDEMO = 9179541993413738569L;
    public /* synthetic */ E left;
    public /* synthetic */ F right;

    public /* synthetic */ E getLeft() {
        Pair a2;
        return a2.left;
    }

    public /* synthetic */ int hashCode() {
        Pair a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + (a2.left == null ? 0 : a2.left.hashCode());
        n2 = 31 * n2 + (a2.right == null ? 0 : a2.right.hashCode());
        return n2;
    }

    public /* synthetic */ String toString() {
        Pair a2;
        return a2.left.toString() + ":" + a2.right.toString();
    }

    public /* synthetic */ boolean equals(Object a2) {
        Pair a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (Pair)a2;
        if (a3.left == null ? ((Pair)a2).left != null : !a3.left.equals(((Pair)a2).left)) {
            return false;
        }
        return !(a3.right == null ? ((Pair)a2).right != null : !a3.right.equals(((Pair)a2).right));
    }

    public /* synthetic */ Pair(E a2, F a3) {
        Pair a4;
        Pair pair = a4;
        pair.left = a2;
        pair.right = a3;
    }

    public /* synthetic */ F getRight() {
        Pair a2;
        return a2.right;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 2 << 1;
        int cfr_ignored_0 = 1 << 3 ^ 1;
        int n5 = n3;
        int n6 = 3 << 3 ^ 4;
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
}

