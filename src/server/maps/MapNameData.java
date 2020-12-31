/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import java.util.List;

public class MapNameData {
    private final /* synthetic */ int a;
    private final /* synthetic */ String k;
    private final /* synthetic */ List<Integer> ALLATORIxDEMO;
    private final /* synthetic */ List<Integer> d;
    private final /* synthetic */ String K;

    public /* synthetic */ String getStreetName() {
        MapNameData a2;
        return a2.k;
    }

    public /* synthetic */ List<Integer> getMobs() {
        MapNameData a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MapNameData(int a2, String a3, String a4, List<Integer> a5, List<Integer> a6) {
        MapNameData a7;
        MapNameData mapNameData = a7;
        MapNameData mapNameData2 = a7;
        a7.a = a2;
        mapNameData2.K = a3;
        mapNameData2.k = a4;
        mapNameData.d = a5;
        mapNameData.ALLATORIxDEMO = a6;
    }

    public /* synthetic */ int getMapId() {
        MapNameData a2;
        return a2.a;
    }

    public /* synthetic */ List<Integer> getNpcs() {
        MapNameData a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3;
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ (2 << 2 ^ 1);
        int n5 = n3;
        int n6 = 4 << 4 ^ 5;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ String getMapName() {
        MapNameData a2;
        return a2.K;
    }
}

