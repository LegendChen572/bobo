/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import java.awt.Point;

public class MapleFoothold
implements Comparable<MapleFoothold> {
    private /* synthetic */ Point k;
    private /* synthetic */ short ALLATORIxDEMO;
    private /* synthetic */ int a;
    private /* synthetic */ Point K;
    private /* synthetic */ short d;

    public /* synthetic */ short getNext() {
        MapleFoothold a2;
        return a2.d;
    }

    public /* synthetic */ int getX2() {
        MapleFoothold a2;
        return a2.K.x;
    }

    public /* synthetic */ Point getPoint1() {
        MapleFoothold a2;
        return a2.k;
    }

    public /* synthetic */ int getY2() {
        MapleFoothold a2;
        return a2.K.y;
    }

    public /* synthetic */ int getY1() {
        MapleFoothold a2;
        return a2.k.y;
    }

    public /* synthetic */ boolean equals(Object a2) {
        MapleFoothold a3;
        if (!(a2 instanceof MapleFoothold)) {
            return false;
        }
        return ((MapleFoothold)(a2 = (MapleFoothold)a2)).getY1() == a3.k.y && ((MapleFoothold)a2).getY2() == a3.K.y && ((MapleFoothold)a2).getX1() == a3.k.x && ((MapleFoothold)a2).getX2() == a3.K.x && a3.a == ((MapleFoothold)a2).getId();
    }

    public /* synthetic */ int getX1() {
        MapleFoothold a2;
        return a2.k.x;
    }

    public /* synthetic */ short getPrev() {
        MapleFoothold a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setPrev(short a2) {
        a.ALLATORIxDEMO = a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4;
        int cfr_ignored_0 = 4 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 5 << 4 ^ (3 ^ 5) << 1;
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

    public /* synthetic */ int getId() {
        MapleFoothold a2;
        return a2.a;
    }

    public /* synthetic */ Point getPoint2() {
        MapleFoothold a2;
        return a2.K;
    }

    public /* synthetic */ boolean isWall() {
        MapleFoothold a2;
        return a2.k.x == a2.K.x;
    }

    public /* synthetic */ MapleFoothold(Point a2, Point a3, int a4) {
        MapleFoothold a5;
        MapleFoothold mapleFoothold = a5;
        a5.k = a2;
        mapleFoothold.K = a3;
        mapleFoothold.a = a4;
    }

    public /* synthetic */ void setNext(short a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ int compareTo(MapleFoothold a2) {
        MapleFoothold a3;
        if (a3.K.y < a2.getY1()) {
            return -1;
        }
        if (a3.k.y > a2.getY2()) {
            return 1;
        }
        return 0;
    }
}

