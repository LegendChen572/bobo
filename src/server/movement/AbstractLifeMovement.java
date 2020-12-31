/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import java.awt.Point;
import server.movement.LifeMovement;

public abstract class AbstractLifeMovement
implements LifeMovement {
    private final /* synthetic */ int a;
    private final /* synthetic */ int d;
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ Point k;
    private final /* synthetic */ int K;

    @Override
    public /* synthetic */ int getDuration() {
        AbstractLifeMovement a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ Point getPosition() {
        AbstractLifeMovement a2;
        return a2.k;
    }

    public /* synthetic */ AbstractLifeMovement(int a2, Point a3, int a4, int a5, int a6) {
        AbstractLifeMovement a7;
        AbstractLifeMovement abstractLifeMovement = a7;
        AbstractLifeMovement abstractLifeMovement2 = a7;
        a7.ALLATORIxDEMO = a2;
        abstractLifeMovement2.k = a3;
        abstractLifeMovement2.K = a4;
        abstractLifeMovement.a = a5;
        abstractLifeMovement.d = a6;
    }

    @Override
    public /* synthetic */ int getNewstate() {
        AbstractLifeMovement a2;
        return a2.a;
    }

    @Override
    public /* synthetic */ int getType() {
        AbstractLifeMovement a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ int getNewFh() {
        AbstractLifeMovement a2;
        return a2.d;
    }
}

