/*
 * Decompiled with CFR 0.150.
 */
package provider;

import java.util.List;
import provider.MapleDataEntity;
import provider.WzXML.MapleDataType;

public interface MapleData
extends MapleDataEntity,
Iterable<MapleData> {
    public /* synthetic */ MapleData getChildByPath(String var1);

    public /* synthetic */ List<MapleData> getChildren();

    public /* synthetic */ Object getData();

    @Override
    public /* synthetic */ String getName();

    public /* synthetic */ MapleDataType getType();
}

