/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import java.lang.ref.WeakReference;
import server.life.MapleMonster;

public class SummonAttackEntry {
    private final /* synthetic */ WeakReference<MapleMonster> d;
    private final /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ MapleMonster getMonster() {
        SummonAttackEntry a2;
        return (MapleMonster)a2.d.get();
    }

    public /* synthetic */ int getDamage() {
        SummonAttackEntry a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ SummonAttackEntry(MapleMonster a2, int a3) {
        SummonAttackEntry a4;
        SummonAttackEntry summonAttackEntry = a4;
        a4.d = new WeakReference<MapleMonster>(a2);
        a4.ALLATORIxDEMO = a3;
    }
}

