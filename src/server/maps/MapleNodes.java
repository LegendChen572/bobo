/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tools.Pair;

public class MapleNodes {
    private final /* synthetic */ List<Rectangle> H;
    private /* synthetic */ int d;
    private /* synthetic */ int a;
    private /* synthetic */ List<Integer> g;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int K;
    private /* synthetic */ List<Pair<Point, Integer>> k;
    private /* synthetic */ List<MonsterPoint> E;
    private /* synthetic */ List<MaplePlatform> e;
    private /* synthetic */ List<Pair<Integer, Integer>> B;
    private /* synthetic */ Map<Integer, MapleNodeInfo> C;

    public final /* synthetic */ void addMonsterPoint(int a2, int a3, int a4, int a5, int a6) {
        MapleNodes a7;
        a7.E.add(new MonsterPoint(a2, a3, a4, a5, a6));
    }

    public final /* synthetic */ void addPlatform(MaplePlatform a2) {
        MapleNodes a3;
        a3.e.add(a2);
    }

    public /* synthetic */ void addNode(MapleNodeInfo a2) {
        MapleNodes a3;
        a3.C.put(a2.key, a2);
    }

    public final /* synthetic */ List<Rectangle> getAreas() {
        MapleNodes a2;
        return new ArrayList<Rectangle>(a2.H);
    }

    public /* synthetic */ MapleNodes(int a2) {
        MapleNodes a3;
        MapleNodes mapleNodes = a3;
        MapleNodes mapleNodes2 = a3;
        MapleNodes mapleNodes3 = a3;
        a3.K = -1;
        mapleNodes3.a = -1;
        mapleNodes3.ALLATORIxDEMO = true;
        MapleNodes mapleNodes4 = a3;
        mapleNodes2.C = new LinkedHashMap<Integer, MapleNodeInfo>();
        mapleNodes4.H = new ArrayList<Rectangle>();
        mapleNodes2.e = new ArrayList<MaplePlatform>();
        mapleNodes2.g = new ArrayList<Integer>();
        mapleNodes2.E = new ArrayList<MonsterPoint>();
        mapleNodes.B = new ArrayList<Pair<Integer, Integer>>();
        mapleNodes.k = new ArrayList<Pair<Point, Integer>>();
        mapleNodes.d = a2;
    }

    public /* synthetic */ Collection<MapleNodeInfo> getNodes() {
        MapleNodes a2;
        return new ArrayList<MapleNodeInfo>(a2.C.values());
    }

    public final /* synthetic */ void addMapleArea(Rectangle a2) {
        MapleNodes a3;
        a3.H.add(a2);
    }

    public final /* synthetic */ void addGuardianSpawn(Point a2, int a3) {
        MapleNodes a4;
        a4.k.add(new Pair<Point, Integer>(a2, a3));
    }

    public final /* synthetic */ List<MaplePlatform> getPlatforms() {
        MapleNodes a2;
        return new ArrayList<MaplePlatform>(a2.e);
    }

    public /* synthetic */ void setNodeEnd(int a2) {
        a.a = a2;
    }

    public final /* synthetic */ List<MonsterPoint> getMonsterPoints() {
        MapleNodes a2;
        return a2.E;
    }

    private /* synthetic */ int ALLATORIxDEMO(MapleNodeInfo a2) {
        MapleNodes a3;
        if (a2 == null) {
            return -1;
        }
        a3.addNode((MapleNodeInfo)a2);
        int n2 = -1;
        a2 = ((MapleNodeInfo)a2).edge.iterator();
        while (a2.hasNext()) {
            int n3 = (Integer)a2.next();
            if (a3.C.get(n3) != null) continue;
            if (n2 != -1 && a3.d / 100 == 9211204) {
                if (!a3.ALLATORIxDEMO) {
                    n2 = Math.min(n2, n3);
                    continue;
                }
                a3.ALLATORIxDEMO = false;
                n2 = Math.max(n2, n3);
                return n2;
            }
            n2 = n3;
        }
        return n2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 1 << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 5 << 3 ^ 4;
        int n5 = n3;
        int n6 = 5 << 3 ^ 4;
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

    public final /* synthetic */ void addSkillId(int a2) {
        MapleNodes a3;
        a3.g.add(a2);
    }

    public final /* synthetic */ Rectangle getArea(int a2) {
        MapleNodes a3;
        return a3.getAreas().get(a2);
    }

    public final /* synthetic */ List<Pair<Integer, Integer>> getMobsToSpawn() {
        MapleNodes a2;
        return a2.B;
    }

    public /* synthetic */ void sortNodes() {
        MapleNodes a2;
        if (a2.C.size() <= 0 || a2.K < 0) {
            return;
        }
        HashMap<Integer, MapleNodeInfo> hashMap = new HashMap<Integer, MapleNodeInfo>(a2.C);
        int n2 = hashMap.size();
        MapleNodes mapleNodes = a2;
        mapleNodes.C.clear();
        int n3 = mapleNodes.ALLATORIxDEMO((MapleNodeInfo)hashMap.get(mapleNodes.K));
        MapleNodes mapleNodes2 = a2;
        while (mapleNodes2.C.size() != n2 && n3 >= 0) {
            n3 = a2.ALLATORIxDEMO((MapleNodeInfo)hashMap.get(n3));
            mapleNodes2 = a2;
        }
    }

    public /* synthetic */ void setNodeStart(int a2) {
        a.K = a2;
    }

    public final /* synthetic */ void addMobSpawn(int a2, int a3) {
        MapleNodes a4;
        a4.B.add(new Pair<Integer, Integer>(a2, a3));
    }

    public final /* synthetic */ List<Pair<Point, Integer>> getGuardians() {
        MapleNodes a2;
        return a2.k;
    }

    public /* synthetic */ MapleNodeInfo getNode(int a2) {
        MapleNodes a3;
        Iterator<MapleNodeInfo> iterator;
        int n2 = 1;
        Iterator<MapleNodeInfo> iterator2 = iterator = a3.getNodes().iterator();
        while (iterator2.hasNext()) {
            MapleNodeInfo mapleNodeInfo = iterator.next();
            if (n2 == a2) {
                return mapleNodeInfo;
            }
            ++n2;
            iterator2 = iterator;
        }
        return null;
    }

    public final /* synthetic */ List<Integer> getSkillIds() {
        MapleNodes a2;
        return a2.g;
    }

    public static class MapleNodeInfo {
        public /* synthetic */ int key;
        public /* synthetic */ int attr;
        public /* synthetic */ int node;
        public /* synthetic */ int y;
        public /* synthetic */ List<Integer> edge;
        public /* synthetic */ int x;

        public /* synthetic */ MapleNodeInfo(int a2, int a3, int a4, int a5, int a6, List<Integer> a7) {
            MapleNodeInfo a8;
            MapleNodeInfo mapleNodeInfo = a8;
            MapleNodeInfo mapleNodeInfo2 = a8;
            MapleNodeInfo mapleNodeInfo3 = a8;
            mapleNodeInfo3.node = a2;
            mapleNodeInfo3.key = a3;
            mapleNodeInfo2.x = a4;
            mapleNodeInfo2.y = a5;
            mapleNodeInfo.attr = a6;
            mapleNodeInfo.edge = a7;
        }
    }

    public static class MonsterPoint {
        public /* synthetic */ int fh;
        public /* synthetic */ int team;
        public /* synthetic */ int cy;
        public /* synthetic */ int y;
        public /* synthetic */ int x;

        public /* synthetic */ MonsterPoint(int a2, int a3, int a4, int a5, int a6) {
            MonsterPoint a7;
            MonsterPoint monsterPoint = a7;
            MonsterPoint monsterPoint2 = a7;
            a7.x = a2;
            monsterPoint2.y = a3;
            monsterPoint2.fh = a4;
            monsterPoint.cy = a5;
            monsterPoint.team = a6;
        }
    }

    public static class MaplePlatform {
        public /* synthetic */ int start;
        public /* synthetic */ int speed;
        public /* synthetic */ int y2;
        public /* synthetic */ int r;
        public /* synthetic */ int y1;
        public /* synthetic */ int x2;
        public /* synthetic */ String name;
        public /* synthetic */ int x1;
        public /* synthetic */ List<Integer> SN;

        public /* synthetic */ MaplePlatform(String a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, List<Integer> a10) {
            MaplePlatform a11;
            MaplePlatform maplePlatform = a11;
            MaplePlatform maplePlatform2 = a11;
            MaplePlatform maplePlatform3 = a11;
            MaplePlatform maplePlatform4 = a11;
            a11.name = a2;
            maplePlatform4.start = a3;
            maplePlatform4.speed = a4;
            maplePlatform3.x1 = a5;
            maplePlatform3.y1 = a6;
            maplePlatform2.x2 = a7;
            maplePlatform2.y2 = a8;
            maplePlatform.r = a9;
            maplePlatform.SN = a10;
        }
    }
}

