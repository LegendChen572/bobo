/*
 * Decompiled with CFR 0.150.
 */
package provider;

import java.util.List;
import provider.MapleDataEntry;
import provider.MapleDataFileEntry;

public interface MapleDataDirectoryEntry
extends MapleDataEntry {
    public /* synthetic */ List<MapleDataDirectoryEntry> getSubdirectories();

    public /* synthetic */ List<MapleDataFileEntry> getFiles();

    public /* synthetic */ MapleDataEntry getEntry(String var1);
}

