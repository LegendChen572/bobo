/*
 * Decompiled with CFR 0.150.
 */
package provider;

import constants.GameSetConstants;
import java.io.File;
import provider.MapleDataProvider;
import provider.WzXML.XMLWZFile;

public class MapleDataProviderFactory {
    private static final /* synthetic */ String ALLATORIxDEMO;

    public static /* synthetic */ {
        ALLATORIxDEMO = GameSetConstants.getWzPath();
    }

    private static /* synthetic */ MapleDataProvider ALLATORIxDEMO(Object a2, boolean a32) {
        if (a2 instanceof File) {
            File a32 = (File)a2;
            return new XMLWZFile(a32);
        }
        throw new IllegalArgumentException("Can't create data provider for input " + a2);
    }

    public /* synthetic */ MapleDataProviderFactory() {
        MapleDataProviderFactory a2;
    }

    public static /* synthetic */ File fileInWZPath(String a2) {
        return new File(ALLATORIxDEMO, a2);
    }

    public static /* synthetic */ MapleDataProvider getDataProvider(String a2) {
        return MapleDataProviderFactory.ALLATORIxDEMO(MapleDataProviderFactory.fileInWZPath(a2), false);
    }

    public static /* synthetic */ MapleDataProvider getDataProvider(File a2) {
        return MapleDataProviderFactory.ALLATORIxDEMO(a2, false);
    }
}

