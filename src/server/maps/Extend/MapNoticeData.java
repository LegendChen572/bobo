/*
 * Decompiled with CFR 0.150.
 */
package server.maps.Extend;

public class MapNoticeData {
    private final /* synthetic */ int K;
    private final /* synthetic */ int a;
    private final /* synthetic */ String ALLATORIxDEMO;
    private final /* synthetic */ int k;
    private final /* synthetic */ String d;

    public /* synthetic */ String getCongratulation() {
        MapNoticeData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ String getEventCount() {
        MapNoticeData a2;
        return a2.d;
    }

    public /* synthetic */ int getMapId() {
        MapNoticeData a2;
        return a2.k;
    }

    public /* synthetic */ MapNoticeData(int a2, int a3, int a4, String a5, String a6) {
        MapNoticeData a7;
        MapNoticeData mapNoticeData = a7;
        MapNoticeData mapNoticeData2 = a7;
        a7.k = a3;
        mapNoticeData2.K = a2;
        mapNoticeData2.a = a4;
        mapNoticeData.d = a5;
        mapNoticeData.ALLATORIxDEMO = a6;
    }

    public /* synthetic */ int getChangeMap() {
        MapNoticeData a2;
        return a2.a;
    }

    public /* synthetic */ int getMonsterId() {
        MapNoticeData a2;
        return a2.K;
    }
}

