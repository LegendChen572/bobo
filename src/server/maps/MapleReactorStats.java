/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import tools.Pair;

public class MapleReactorStats {
    private /* synthetic */ byte K;
    private /* synthetic */ Point d;
    private /* synthetic */ Map<Byte, StateData> ALLATORIxDEMO;
    private /* synthetic */ Point a;

    public /* synthetic */ Pair<Integer, Integer> getReactItem(byte a22) {
        MapleReactorStats a3;
        StateData a22 = a3.ALLATORIxDEMO.get(a22);
        if (a22 != null) {
            return a22.ALLATORIxDEMO();
        }
        return null;
    }

    public /* synthetic */ MapleReactorStats() {
        MapleReactorStats a2;
        MapleReactorStats mapleReactorStats = a2;
        mapleReactorStats.ALLATORIxDEMO = new HashMap<Byte, StateData>();
    }

    public /* synthetic */ byte getNextState(byte a22) {
        MapleReactorStats a3;
        StateData a22 = a3.ALLATORIxDEMO.get(a22);
        if (a22 != null) {
            return a22.H();
        }
        return -1;
    }

    public final /* synthetic */ void setFacingDirection(byte a2) {
        a.K = a2;
    }

    public /* synthetic */ void setTL(Point a2) {
        a.a = a2;
    }

    public /* synthetic */ byte canTouch(byte a22) {
        MapleReactorStats a3;
        StateData a22 = a3.ALLATORIxDEMO.get(a22);
        if (a22 != null) {
            return a22.ALLATORIxDEMO();
        }
        return 0;
    }

    public /* synthetic */ int getTimeOut(byte a22) {
        MapleReactorStats a3;
        StateData a22 = a3.ALLATORIxDEMO.get(a22);
        if (a22 != null) {
            return a22.ALLATORIxDEMO();
        }
        return -1;
    }

    public final /* synthetic */ byte getFacingDirection() {
        MapleReactorStats a2;
        return a2.K;
    }

    public /* synthetic */ Point getTL() {
        MapleReactorStats a2;
        return a2.a;
    }

    public /* synthetic */ void addState(byte a2, int a32, Pair<Integer, Integer> a4, byte a5, int a6, byte a7) {
        MapleReactorStats a8;
        StateData a32 = new StateData(a32, a4, a5, a6, a7, null);
        a8.ALLATORIxDEMO.put(a2, a32);
    }

    public /* synthetic */ void setBR(Point a2) {
        a.d = a2;
    }

    public /* synthetic */ Point getBR() {
        MapleReactorStats a2;
        return a2.d;
    }

    public /* synthetic */ int getType(byte a22) {
        MapleReactorStats a3;
        StateData a22 = a3.ALLATORIxDEMO.get(a22);
        if (a22 != null) {
            return a22.H();
        }
        return -1;
    }

    private static class StateData {
        private /* synthetic */ int K;
        private /* synthetic */ int k;
        private /* synthetic */ byte ALLATORIxDEMO;
        private /* synthetic */ Pair<Integer, Integer> a;
        private /* synthetic */ byte d;

        private /* synthetic */ int ALLATORIxDEMO() {
            StateData a2;
            return a2.K;
        }

        private /* synthetic */ byte ALLATORIxDEMO() {
            StateData a2;
            return a2.ALLATORIxDEMO;
        }

        private /* synthetic */ Pair<Integer, Integer> ALLATORIxDEMO() {
            StateData a2;
            return a2.a;
        }

        private /* synthetic */ byte H() {
            StateData a2;
            return a2.d;
        }

        public /* synthetic */ StateData(int a2, Pair a3, byte a4, int a5, byte a6, 1 a7) {
            a8(a2, a3, a4, a5, a6);
            StateData a8;
        }

        private /* synthetic */ StateData(int a2, Pair<Integer, Integer> a3, byte a4, int a5, byte a6) {
            StateData a7;
            StateData stateData = a7;
            StateData stateData2 = a7;
            a7.k = a2;
            stateData2.a = a3;
            stateData2.d = a4;
            stateData.K = a5;
            stateData.ALLATORIxDEMO = a6;
        }

        private /* synthetic */ int H() {
            StateData a2;
            return a2.k;
        }
    }
}

