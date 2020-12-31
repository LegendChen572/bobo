/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import server.maps.AbstractMapleMapObject;
import server.maps.AnimatedMapleMapObject;

public abstract class AbstractAnimatedMapleMapObject
extends AbstractMapleMapObject
implements AnimatedMapleMapObject {
    private /* synthetic */ int d;
    private /* synthetic */ int ALLATORIxDEMO;

    @Override
    public /* synthetic */ void setStance(int a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ int getStance() {
        AbstractAnimatedMapleMapObject a2;
        return a2.d;
    }

    public /* synthetic */ AbstractAnimatedMapleMapObject() {
        AbstractAnimatedMapleMapObject a2;
    }

    @Override
    public /* synthetic */ void setFh(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getFacingDirection() {
        AbstractAnimatedMapleMapObject a2;
        return a2.getStance() % 2;
    }

    @Override
    public /* synthetic */ int getFh() {
        AbstractAnimatedMapleMapObject a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ boolean isFacingLeft() {
        AbstractAnimatedMapleMapObject a2;
        return a2.getStance() % 2 != 0;
    }
}

