/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.Serializable;

public class Quadra<F, S, T, Fo>
implements Serializable {
    public /* synthetic */ S second;
    public /* synthetic */ Fo forth;
    public /* synthetic */ T third;
    public /* synthetic */ F first;
    private static final /* synthetic */ long ALLATORIxDEMO = 9179541993413739999L;

    public /* synthetic */ S getSecond() {
        Quadra a2;
        return a2.second;
    }

    public /* synthetic */ Quadra(F a2, S a3, T a4, Fo a5) {
        Quadra a6;
        Quadra quadra = a6;
        Quadra quadra2 = a6;
        quadra2.first = a2;
        quadra2.second = a3;
        quadra.third = a4;
        quadra.forth = a5;
    }

    public /* synthetic */ F getFirst() {
        Quadra a2;
        return a2.first;
    }

    public /* synthetic */ int hashCode() {
        Quadra a2;
        int n2 = 31;
        n2 = 1;
        n2 = 31 * n2 + (a2.first == null ? 0 : a2.first.hashCode());
        n2 = 31 * n2 + (a2.second == null ? 0 : a2.second.hashCode());
        n2 = 31 * n2 + (a2.third == null ? 0 : a2.third.hashCode());
        n2 = 31 * n2 + (a2.forth == null ? 0 : a2.forth.hashCode());
        return n2;
    }

    public /* synthetic */ Fo getForth() {
        Quadra a2;
        return a2.forth;
    }

    public /* synthetic */ String toString() {
        Quadra a2;
        return a2.first.toString() + ":" + a2.second.toString() + ":" + a2.third.toString() + ":" + a2.forth.toString();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int n5 = n3;
        int n6 = 4 << 4 ^ (2 << 2 ^ 1);
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

    public /* synthetic */ boolean equals(Object a2) {
        Quadra a3;
        if (a3 == a2) {
            return true;
        }
        if (a2 == null) {
            return false;
        }
        if (a3.getClass() != a2.getClass()) {
            return false;
        }
        a2 = (Quadra)a2;
        if (a3.first == null ? ((Quadra)a2).first != null : !a3.first.equals(((Quadra)a2).first)) {
            return false;
        }
        if (a3.second == null ? ((Quadra)a2).second != null : !a3.second.equals(((Quadra)a2).second)) {
            return false;
        }
        if (a3.third == null ? ((Quadra)a2).third != null : !a3.third.equals(((Quadra)a2).third)) {
            return false;
        }
        return !(a3.forth == null ? ((Quadra)a2).forth != null : !a3.forth.equals(((Quadra)a2).forth));
    }

    public /* synthetic */ T getThird() {
        Quadra a2;
        return a2.third;
    }
}

