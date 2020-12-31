/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataEntity;
import provider.MapleDataEntry;
import provider.MapleDataFileEntry;
import provider.WzXML.WZEntry;

public class WZDirectoryEntry
extends WZEntry
implements MapleDataDirectoryEntry {
    private /* synthetic */ List<MapleDataFileEntry> d;
    private /* synthetic */ Map<String, MapleDataEntry> ALLATORIxDEMO;
    private /* synthetic */ List<MapleDataDirectoryEntry> a;

    public /* synthetic */ void addDirectory(MapleDataDirectoryEntry a2) {
        WZDirectoryEntry a3;
        a3.a.add(a2);
        a3.ALLATORIxDEMO.put(a2.getName(), a2);
    }

    public /* synthetic */ WZDirectoryEntry() {
        super(null, 0, 0, null);
        WZDirectoryEntry a2;
        WZDirectoryEntry wZDirectoryEntry = a2;
        a2.a = new ArrayList<MapleDataDirectoryEntry>();
        wZDirectoryEntry.d = new ArrayList<MapleDataFileEntry>();
        a2.ALLATORIxDEMO = new HashMap<String, MapleDataEntry>();
    }

    public /* synthetic */ void addFile(MapleDataFileEntry a2) {
        WZDirectoryEntry a3;
        a3.d.add(a2);
        a3.ALLATORIxDEMO.put(a2.getName(), a2);
    }

    @Override
    public /* synthetic */ List<MapleDataFileEntry> getFiles() {
        WZDirectoryEntry a2;
        return Collections.unmodifiableList(a2.d);
    }

    public /* synthetic */ WZDirectoryEntry(String a2, int a3, int a4, MapleDataEntity a5) {
        super(a2, a3, a4, a5);
        WZDirectoryEntry a6;
        WZDirectoryEntry wZDirectoryEntry = a6;
        a6.a = new ArrayList<MapleDataDirectoryEntry>();
        wZDirectoryEntry.d = new ArrayList<MapleDataFileEntry>();
        a6.ALLATORIxDEMO = new HashMap<String, MapleDataEntry>();
    }

    @Override
    public /* synthetic */ List<MapleDataDirectoryEntry> getSubdirectories() {
        WZDirectoryEntry a2;
        return Collections.unmodifiableList(a2.a);
    }

    @Override
    public /* synthetic */ MapleDataEntry getEntry(String a2) {
        WZDirectoryEntry a3;
        return a3.ALLATORIxDEMO.get(a2);
    }
}

