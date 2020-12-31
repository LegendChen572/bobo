/*
 * Decompiled with CFR 0.150.
 */
package tools.npcgenerator;

import tools.npcgenerator.Instruction;

public class Warp
extends Instruction {
    private /* synthetic */ short ALLATORIxDEMO;
    private /* synthetic */ int d;

    public /* synthetic */ Warp() {
        super(true);
        Warp a2;
    }

    public /* synthetic */ void setSpawnPoint(short a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getMapId() {
        Warp a2;
        return a2.d;
    }

    public /* synthetic */ void setMapId(int a2) {
        a.d = a2;
    }

    public /* synthetic */ short getSpawnPoint() {
        Warp a2;
        return a2.ALLATORIxDEMO;
    }
}

