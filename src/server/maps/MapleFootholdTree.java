/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import constants.skills.SkillType;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.Randomizer;
import server.maps.MapleFoothold;

public class MapleFootholdTree {
    private /* synthetic */ int K;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ List<MapleFoothold> E;
    private /* synthetic */ Point B;
    private /* synthetic */ Point k;
    private /* synthetic */ Point g;
    private /* synthetic */ MapleFootholdTree H;
    private /* synthetic */ int d;
    private /* synthetic */ MapleFootholdTree e;
    private static final /* synthetic */ byte a = 8;
    private /* synthetic */ MapleFootholdTree C;
    private /* synthetic */ MapleFootholdTree F;

    private final /* synthetic */ List<MapleFoothold> ALLATORIxDEMO(Point a2) {
        MapleFootholdTree a3;
        return a3.ALLATORIxDEMO(a2, new LinkedList<MapleFoothold>());
    }

    public /* synthetic */ MapleFootholdTree(Point a2, Point a3, int a4) {
        MapleFootholdTree a5;
        MapleFootholdTree mapleFootholdTree = a5;
        MapleFootholdTree mapleFootholdTree2 = a5;
        MapleFootholdTree mapleFootholdTree3 = a5;
        MapleFootholdTree mapleFootholdTree4 = a5;
        mapleFootholdTree4.F = null;
        mapleFootholdTree4.C = null;
        mapleFootholdTree3.H = null;
        mapleFootholdTree3.e = null;
        MapleFootholdTree mapleFootholdTree5 = a5;
        mapleFootholdTree3.E = new LinkedList<MapleFoothold>();
        mapleFootholdTree2.K = 0;
        mapleFootholdTree2.g = a2;
        mapleFootholdTree.B = a3;
        mapleFootholdTree.K = a4;
        mapleFootholdTree.k = new Point((a3.x - a2.x) / 2, (a3.y - a2.y) / 2);
    }

    public final /* synthetic */ int getY1() {
        MapleFootholdTree a2;
        return a2.g.y;
    }

    public final /* synthetic */ void insert(MapleFoothold a2) {
        MapleFootholdTree a3;
        if (a3.K == 0) {
            if (a2.getX1() > a3.d) {
                a3.d = a2.getX1();
            }
            if (a2.getX1() < a3.ALLATORIxDEMO) {
                a3.ALLATORIxDEMO = a2.getX1();
            }
            if (a2.getX2() > a3.d) {
                a3.d = a2.getX2();
            }
            if (a2.getX2() < a3.ALLATORIxDEMO) {
                a3.ALLATORIxDEMO = a2.getX2();
            }
        }
        if (a3.K == 8 || a2.getX1() >= a3.g.x && a2.getX2() <= a3.B.x && a2.getY1() >= a3.g.y && a2.getY2() <= a3.B.y) {
            a3.E.add(a2);
            return;
        }
        if (a3.F == null) {
            MapleFootholdTree mapleFootholdTree = a3;
            MapleFootholdTree mapleFootholdTree2 = a3;
            MapleFootholdTree mapleFootholdTree3 = a3;
            mapleFootholdTree.F = new MapleFootholdTree(mapleFootholdTree3.g, mapleFootholdTree3.k, a3.K + 1);
            mapleFootholdTree2.C = new MapleFootholdTree(new Point(a3.k.x, a3.g.y), new Point(a3.B.x, a3.k.y), a3.K + 1);
            mapleFootholdTree.H = new MapleFootholdTree(new Point(a3.g.x, a3.k.y), new Point(a3.k.x, a3.B.y), a3.K + 1);
            MapleFootholdTree mapleFootholdTree4 = a3;
            mapleFootholdTree.e = new MapleFootholdTree(mapleFootholdTree4.k, mapleFootholdTree4.B, a3.K + 1);
        }
        if (a2.getX2() <= a3.k.x && a2.getY2() <= a3.k.y) {
            a3.F.insert(a2);
            return;
        }
        if (a2.getX1() > a3.k.x && a2.getY2() <= a3.k.y) {
            a3.C.insert(a2);
            return;
        }
        if (a2.getX2() <= a3.k.x && a2.getY1() > a3.k.y) {
            a3.H.insert(a2);
            return;
        }
        a3.e.insert(a2);
    }

    public final /* synthetic */ int getY2() {
        MapleFootholdTree a2;
        return a2.B.y;
    }

    public final /* synthetic */ int getMaxDropX() {
        MapleFootholdTree a2;
        return a2.d;
    }

    public final /* synthetic */ int getX1() {
        MapleFootholdTree a2;
        return a2.g.x;
    }

    public final /* synthetic */ Point getRandomPos() {
        MapleFootholdTree a2;
        ArrayList<MapleFoothold> arrayList = new ArrayList<MapleFoothold>();
        for (MapleFoothold mapleFoothold : a2.E) {
            if (mapleFoothold.getY1() != mapleFoothold.getY2()) continue;
            arrayList.add(mapleFoothold);
        }
        if (arrayList.size() > 0) {
            ArrayList<MapleFoothold> arrayList2 = arrayList;
            MapleFoothold mapleFoothold = (MapleFoothold)arrayList2.get(Randomizer.nextInt(arrayList2.size()));
            return new Point(Randomizer.rand(Math.min(mapleFoothold.getX1(), mapleFoothold.getX2()), Math.max(mapleFoothold.getX1(), mapleFoothold.getX2())), mapleFoothold.getY1());
        }
        return null;
    }

    public final /* synthetic */ List<MapleFoothold> getAllRelevants() {
        MapleFootholdTree a2;
        return a2.ALLATORIxDEMO(new LinkedList<MapleFoothold>());
    }

    public final /* synthetic */ MapleFoothold findWall(Point a2, Point a3) {
        MapleFootholdTree a4;
        if (a2.y != a3.y) {
            throw new IllegalArgumentException();
        }
        return a4.ALLATORIxDEMO(a2, a3);
    }

    public final /* synthetic */ int getMinDropX() {
        MapleFootholdTree a2;
        return a2.ALLATORIxDEMO;
    }

    private final /* synthetic */ List<MapleFoothold> ALLATORIxDEMO(Point a2, List<MapleFoothold> a3) {
        MapleFootholdTree a4;
        MapleFootholdTree mapleFootholdTree = a4;
        a3.addAll(mapleFootholdTree.E);
        if (mapleFootholdTree.F != null) {
            if (a2.x <= a4.k.x && a2.y <= a4.k.y) {
                List<MapleFoothold> list = a3;
                a4.F.ALLATORIxDEMO(a2, list);
                return list;
            }
            if (a2.x > a4.k.x && a2.y <= a4.k.y) {
                List<MapleFoothold> list = a3;
                a4.C.ALLATORIxDEMO(a2, list);
                return list;
            }
            if (a2.x <= a4.k.x && a2.y > a4.k.y) {
                List<MapleFoothold> list = a3;
                a4.H.ALLATORIxDEMO(a2, list);
                return list;
            }
            a4.e.ALLATORIxDEMO(a2, a3);
        }
        return a3;
    }

    public final /* synthetic */ MapleFoothold findBelow(Point a2) {
        MapleFootholdTree a3;
        Iterator iterator = a3.ALLATORIxDEMO(a2);
        LinkedList<MapleFoothold> linkedList = new LinkedList<MapleFoothold>();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            MapleFoothold mapleFoothold = (MapleFoothold)iterator.next();
            if (mapleFoothold.getX1() > a2.x || mapleFoothold.getX2() < a2.x) continue;
            linkedList.add(mapleFoothold);
        }
        try {
            if (!linkedList.isEmpty()) {
                Collections.sort(linkedList);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        for (MapleFoothold mapleFoothold : linkedList) {
            if (!mapleFoothold.isWall() && mapleFoothold.getY1() != mapleFoothold.getY2()) {
                MapleFoothold mapleFoothold2 = mapleFoothold;
                double d2 = Math.abs(mapleFoothold2.getY2() - mapleFoothold.getY1());
                double d3 = Math.abs(mapleFoothold2.getX2() - mapleFoothold.getX1());
                double d4 = Math.abs(a2.x - mapleFoothold.getX1());
                double d5 = Math.atan(d3 / d2);
                d2 = Math.atan(d2 / d3);
                d2 = Math.cos(d5) * (d4 / Math.cos(d2));
                if ((mapleFoothold2.getY2() < mapleFoothold.getY1() ? mapleFoothold.getY1() - (int)d2 : mapleFoothold.getY1() + (int)d2) < a2.y) continue;
                return mapleFoothold;
            }
            if (mapleFoothold.isWall() || mapleFoothold.getY1() < a2.y) continue;
            return mapleFoothold;
        }
        return null;
    }

    private final /* synthetic */ List<MapleFoothold> ALLATORIxDEMO(List<MapleFoothold> a2) {
        MapleFootholdTree a3;
        MapleFootholdTree mapleFootholdTree = a3;
        a2.addAll(mapleFootholdTree.E);
        if (mapleFootholdTree.F != null) {
            a3.F.ALLATORIxDEMO(a2);
            a3.C.ALLATORIxDEMO(a2);
            a3.H.ALLATORIxDEMO(a2);
            a3.e.ALLATORIxDEMO(a2);
        }
        return a2;
    }

    private final /* synthetic */ MapleFoothold ALLATORIxDEMO(Point a2, Point a3) {
        MapleFootholdTree a4;
        for (MapleFoothold mapleFoothold : a4.E) {
            if (!mapleFoothold.isWall() || mapleFoothold.getX1() < a2.x || mapleFoothold.getX1() > a3.x || mapleFoothold.getY1() < a2.y || mapleFoothold.getY2() > a2.y) continue;
            return mapleFoothold;
        }
        if (a4.F != null) {
            MapleFoothold mapleFoothold;
            if (a2.x <= a4.k.x && a2.y <= a4.k.y && (mapleFoothold = a4.F.ALLATORIxDEMO(a2, a3)) != null) {
                return mapleFoothold;
            }
            if ((a2.x > a4.k.x || a3.x > a4.k.x) && a2.y <= a4.k.y && (mapleFoothold = a4.C.ALLATORIxDEMO(a2, a3)) != null) {
                return mapleFoothold;
            }
            if (a2.x <= a4.k.x && a2.y > a4.k.y && (mapleFoothold = a4.H.ALLATORIxDEMO(a2, a3)) != null) {
                return mapleFoothold;
            }
            if ((a2.x > a4.k.x || a3.x > a4.k.x) && a2.y > a4.k.y && (mapleFoothold = a4.e.ALLATORIxDEMO(a2, a3)) != null) {
                return mapleFoothold;
            }
        }
        return null;
    }

    public final /* synthetic */ int getX2() {
        MapleFootholdTree a2;
        return a2.B.x;
    }

    public final /* synthetic */ boolean checkRelevantFH(short a2, short a3, short a4, short a5) {
        MapleFootholdTree mapleFootholdTree;
        MapleFoothold mapleFoothold;
        block3: {
            MapleFootholdTree a6;
            mapleFoothold = null;
            for (MapleFoothold mapleFoothold2 : a6.E) {
                if (mapleFoothold2.getX1() > a2 || mapleFoothold2.getX2() < a2 || mapleFoothold2.getY1() > a3 || mapleFoothold2.getY2() < a3) continue;
                mapleFoothold = mapleFoothold2;
                mapleFootholdTree = a6;
                break block3;
            }
            mapleFootholdTree = a6;
        }
        for (MapleFoothold mapleFoothold2 : mapleFootholdTree.E) {
            if (mapleFoothold2.getX1() > a4 || mapleFoothold2.getX2() < a4 || mapleFoothold2.getY1() > a5 || mapleFoothold2.getY2() < a5) continue;
            if (mapleFoothold.getId() != mapleFoothold2.getId() && mapleFoothold2.getId() != mapleFoothold.getNext() && mapleFoothold2.getId() != mapleFoothold.getPrev()) {
                System.err.println(SkillType.ALLATORIxDEMO("pKFHWJ\u0014P\u0013BZJW\u0004GLV\u0004PKAVVGG\u0004CK@\u0004UKA\u0004]AKP\u001cTAAE"));
                return false;
            }
            return true;
        }
        return false;
    }

    public /* synthetic */ MapleFootholdTree(Point a2, Point a3) {
        MapleFootholdTree a4;
        MapleFootholdTree mapleFootholdTree = a4;
        MapleFootholdTree mapleFootholdTree2 = a4;
        MapleFootholdTree mapleFootholdTree3 = a4;
        a4.F = null;
        mapleFootholdTree3.C = null;
        mapleFootholdTree3.H = null;
        mapleFootholdTree2.e = null;
        MapleFootholdTree mapleFootholdTree4 = a4;
        mapleFootholdTree2.E = new LinkedList<MapleFoothold>();
        mapleFootholdTree2.K = 0;
        mapleFootholdTree.g = a2;
        mapleFootholdTree.B = a3;
        mapleFootholdTree.k = new Point((a3.x - a2.x) / 2, (a3.y - a2.y) / 2);
    }
}

