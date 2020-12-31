/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import provider.MapleDataEntity;
import provider.MapleDataEntry;

public class WZEntry
implements MapleDataEntry {
    private /* synthetic */ String k;
    private /* synthetic */ int a;
    private /* synthetic */ int K;
    private /* synthetic */ MapleDataEntity ALLATORIxDEMO;
    private /* synthetic */ int d;

    @Override
    public /* synthetic */ String getName() {
        WZEntry a2;
        return a2.k;
    }

    @Override
    public /* synthetic */ int getOffset() {
        WZEntry a2;
        return a2.d;
    }

    public /* synthetic */ WZEntry(String a2, int a3, int a4, MapleDataEntity a5) {
        WZEntry a6;
        WZEntry wZEntry = a6;
        WZEntry wZEntry2 = a6;
        wZEntry2.k = a2;
        wZEntry2.K = a3;
        wZEntry.a = a4;
        wZEntry.ALLATORIxDEMO = a5;
    }

    @Override
    public /* synthetic */ MapleDataEntity getParent() {
        WZEntry a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ int getChecksum() {
        WZEntry a2;
        return a2.a;
    }

    @Override
    public /* synthetic */ int getSize() {
        WZEntry a2;
        return a2.K;
    }
}

