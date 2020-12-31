/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import provider.MapleDataEntity;
import provider.MapleDataFileEntry;
import provider.WzXML.WZEntry;

public class WZFileEntry
extends WZEntry
implements MapleDataFileEntry {
    private /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ WZFileEntry(String a2, int a3, int a4, MapleDataEntity a5) {
        super(a2, a3, a4, a5);
        WZFileEntry a6;
    }

    @Override
    public /* synthetic */ void setOffset(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ int getOffset() {
        WZFileEntry a2;
        return a2.ALLATORIxDEMO;
    }
}

