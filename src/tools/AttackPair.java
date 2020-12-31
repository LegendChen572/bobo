/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.awt.Point;
import java.util.List;
import tools.Pair;

public class AttackPair {
    public /* synthetic */ Point point;
    public /* synthetic */ int objectid;
    public /* synthetic */ List<Pair<Integer, Boolean>> attack;

    public /* synthetic */ AttackPair(int a2, List<Pair<Integer, Boolean>> a3) {
        AttackPair a4;
        AttackPair attackPair = a4;
        attackPair.objectid = a2;
        attackPair.attack = a3;
    }

    public /* synthetic */ AttackPair(int a2, Point a3, List<Pair<Integer, Boolean>> a4) {
        AttackPair a5;
        AttackPair attackPair = a5;
        a5.objectid = a2;
        attackPair.point = a3;
        attackPair.attack = a4;
    }
}

