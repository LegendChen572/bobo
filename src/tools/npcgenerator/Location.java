/*
 * Decompiled with CFR 0.150.
 */
package tools.npcgenerator;

import tools.npcgenerator.Condition;

public class Location
extends Condition {
    private /* synthetic */ int a;
    private /* synthetic */ short ALLATORIxDEMO;
    private /* synthetic */ short d;

    public /* synthetic */ void setYposition(short a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getMapId() {
        Location a2;
        return a2.a;
    }

    public /* synthetic */ void setXposition(short a2) {
        a.d = a2;
    }

    public /* synthetic */ Location() {
        Location a2;
    }

    public /* synthetic */ void setMapId(int a2) {
        a.a = a2;
    }

    public /* synthetic */ short getYposition() {
        Location a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ short getXposition() {
        Location a2;
        return a2.d;
    }
}

