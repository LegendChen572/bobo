/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import server.maps.AbstractAnimatedMapleMapObject;

public abstract class AbstractLoadedMapleLife
extends AbstractAnimatedMapleMapObject {
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int K;
    private /* synthetic */ String d;
    private /* synthetic */ int B;
    private /* synthetic */ int e;
    private /* synthetic */ int k;
    private /* synthetic */ boolean E;
    private final /* synthetic */ int H;
    private /* synthetic */ int a;
    private /* synthetic */ boolean g;

    public /* synthetic */ String getCType() {
        AbstractLoadedMapleLife a2;
        return a2.d;
    }

    public /* synthetic */ int getOriginFh() {
        AbstractLoadedMapleLife a2;
        return a2.B;
    }

    public /* synthetic */ int getMTime() {
        AbstractLoadedMapleLife a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setMTime(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ boolean isCustom() {
        AbstractLoadedMapleLife a2;
        return a2.g;
    }

    public /* synthetic */ int getId() {
        AbstractLoadedMapleLife a2;
        return a2.H;
    }

    public /* synthetic */ int getRx0() {
        AbstractLoadedMapleLife a2;
        return a2.K;
    }

    public /* synthetic */ void setF(int a2) {
        a.e = a2;
    }

    public /* synthetic */ void setRx0(int a2) {
        a.K = a2;
    }

    public /* synthetic */ AbstractLoadedMapleLife(AbstractLoadedMapleLife a2) {
        AbstractLoadedMapleLife a3;
        AbstractLoadedMapleLife abstractLoadedMapleLife = a3;
        AbstractLoadedMapleLife abstractLoadedMapleLife2 = a2;
        AbstractLoadedMapleLife abstractLoadedMapleLife3 = a3;
        AbstractLoadedMapleLife abstractLoadedMapleLife4 = a2;
        AbstractLoadedMapleLife abstractLoadedMapleLife5 = a3;
        AbstractLoadedMapleLife abstractLoadedMapleLife6 = a2;
        a3(abstractLoadedMapleLife6.getId());
        abstractLoadedMapleLife5.e = abstractLoadedMapleLife6.e;
        abstractLoadedMapleLife5.E = a2.E;
        a3.setFh(abstractLoadedMapleLife4.getFh());
        abstractLoadedMapleLife3.B = abstractLoadedMapleLife4.B;
        abstractLoadedMapleLife3.k = a2.k;
        a3.K = abstractLoadedMapleLife2.K;
        abstractLoadedMapleLife.a = abstractLoadedMapleLife2.a;
        abstractLoadedMapleLife.g = a2.g;
    }

    public /* synthetic */ int getCy() {
        AbstractLoadedMapleLife a2;
        return a2.k;
    }

    public /* synthetic */ int getRx1() {
        AbstractLoadedMapleLife a2;
        return a2.a;
    }

    public final /* synthetic */ void setCustom(boolean a2) {
        a.g = a2;
    }

    public /* synthetic */ int getF() {
        AbstractLoadedMapleLife a2;
        return a2.e;
    }

    public /* synthetic */ void setOriginFh(int a2) {
        a.B = a2;
    }

    public /* synthetic */ void setCy(int a2) {
        a.k = a2;
    }

    public /* synthetic */ void setHide(boolean a2) {
        a.E = a2;
    }

    public /* synthetic */ boolean isHidden() {
        AbstractLoadedMapleLife a2;
        return a2.E;
    }

    public /* synthetic */ void setCType(String a2) {
        a.d = a2;
    }

    public /* synthetic */ void setRx1(int a2) {
        a.a = a2;
    }

    public /* synthetic */ AbstractLoadedMapleLife(int a2) {
        AbstractLoadedMapleLife a3;
        a3.H = a2;
    }
}

