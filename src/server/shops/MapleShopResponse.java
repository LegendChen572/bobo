/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u53ef\u53ef\u8c37
 */
package server.shops;

import client.messages.commands.player.\u53ef\u53ef\u8c37;
import scripting.AbstractPlayerInteraction;

public final class MapleShopResponse
extends Enum<MapleShopResponse> {
    public static final /* synthetic */ /* enum */ MapleShopResponse \u8ce3\u51fa\u9053\u5177\u5b8c\u6210;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u80cc\u5305\u7a7a\u9593\u4e0d\u5920;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u767c\u751f\u672a\u77e5\u932f\u8aa4;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u80cc\u5305\u91d1\u5e63\u4e0d\u5920;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u8cfc\u8cb7\u9053\u5177\u5b8c\u6210;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u5145\u503c\u91d1\u5e63\u4e0d\u5920;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u5145\u503c\u98db\u93e2\u5b8c\u6210;
    private static final /* synthetic */ MapleShopResponse[] ALLATORIxDEMO;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ MapleShopResponse \u8cfc\u8cb7\u56de\u8cfc\u51fa\u932f;

    public /* synthetic */ int getValue() {
        MapleShopResponse a2;
        return a2.d;
    }

    public static /* synthetic */ {
        \u8cfc\u8cb7\u9053\u5177\u5b8c\u6210 = new MapleShopResponse(AbstractPlayerInteraction.ALLATORIxDEMO("\u8caa\u8cb6\u9005\u5176\u5bda\u6211"), 0, 0);
        \u80cc\u5305\u91d1\u5e63\u4e0d\u5920 = new MapleShopResponse(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u809b\u5309\u9186\u5e6f\u4e5a\u592c"), 1, 2);
        \u80cc\u5305\u7a7a\u9593\u4e0d\u5920 = new MapleShopResponse(AbstractPlayerInteraction.ALLATORIxDEMO("\u809a\u5304\u7a2c\u9592\u4e5b\u5921"), 2, 3);
        \u8ce3\u51fa\u9053\u5177\u5b8c\u6210 = new MapleShopResponse(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u8cb4\u51f6\u9004\u517b\u5bdb\u621c"), 3, 4);
        \u5145\u503c\u98db\u93e2\u5b8c\u6210 = new MapleShopResponse(AbstractPlayerInteraction.ALLATORIxDEMO("\u5113\u503d\u988d\u93e3\u5bda\u6211"), 4, 8);
        \u5145\u503c\u91d1\u5e63\u4e0d\u5920 = new MapleShopResponse(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u5112\u5030\u9186\u5e6f\u4e5a\u592c"), 5, 10);
        \u767c\u751f\u672a\u77e5\u932f\u8aa4 = new MapleShopResponse(AbstractPlayerInteraction.ALLATORIxDEMO("\u762a\u751e\u677c\u77e4\u9379\u8aa5"), 6, 11);
        \u8cfc\u8cb7\u56de\u8cfc\u51fa\u932f = new MapleShopResponse(\u53ef\u53ef\u8c37.ALLATORIxDEMO((String)"\u8cab\u8cbb\u5689\u8cf0\u51ad\u9323"), 7, 29);
        MapleShopResponse[] arrmapleShopResponse = new MapleShopResponse[8];
        arrmapleShopResponse[0] = \u8cfc\u8cb7\u9053\u5177\u5b8c\u6210;
        arrmapleShopResponse[1] = \u80cc\u5305\u91d1\u5e63\u4e0d\u5920;
        arrmapleShopResponse[2] = \u80cc\u5305\u7a7a\u9593\u4e0d\u5920;
        arrmapleShopResponse[3] = \u8ce3\u51fa\u9053\u5177\u5b8c\u6210;
        arrmapleShopResponse[4] = \u5145\u503c\u98db\u93e2\u5b8c\u6210;
        arrmapleShopResponse[5] = \u5145\u503c\u91d1\u5e63\u4e0d\u5920;
        arrmapleShopResponse[6] = \u767c\u751f\u672a\u77e5\u932f\u8aa4;
        arrmapleShopResponse[7] = \u8cfc\u8cb7\u56de\u8cfc\u51fa\u932f;
        ALLATORIxDEMO = arrmapleShopResponse;
    }

    public static /* synthetic */ MapleShopResponse valueOf(String a2) {
        return Enum.valueOf(MapleShopResponse.class, a2);
    }

    public static /* synthetic */ MapleShopResponse[] values() {
        return (MapleShopResponse[])ALLATORIxDEMO.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ MapleShopResponse(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        MapleShopResponse a3;
        a3.d = a2;
    }
}

