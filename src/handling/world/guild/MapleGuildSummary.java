/*
 * Decompiled with CFR 0.150.
 */
package handling.world.guild;

import handling.world.guild.MapleGuild;
import java.io.Serializable;

public class MapleGuildSummary
implements Serializable {
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ byte d;
    private final /* synthetic */ short a;
    private final /* synthetic */ String B;
    private final /* synthetic */ short k;
    public static final /* synthetic */ long serialVersionUID = 3565477792085301248L;
    private final /* synthetic */ byte K;

    public /* synthetic */ int getAllianceId() {
        MapleGuildSummary a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ byte getLogoBGColor() {
        MapleGuildSummary a2;
        return a2.K;
    }

    public /* synthetic */ short getLogoBG() {
        MapleGuildSummary a2;
        return a2.k;
    }

    public /* synthetic */ byte getLogoColor() {
        MapleGuildSummary a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ 2;
        int cfr_ignored_0 = 5 << 4 ^ (3 << 2 ^ 1);
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ (2 ^ 5) << 1;
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

    public /* synthetic */ MapleGuildSummary(MapleGuild a2) {
        MapleGuildSummary a3;
        MapleGuildSummary mapleGuildSummary = a3;
        MapleGuild mapleGuild = a2;
        MapleGuildSummary mapleGuildSummary2 = a3;
        MapleGuild mapleGuild2 = a2;
        a3.B = mapleGuild2.getName();
        mapleGuildSummary2.k = (short)mapleGuild2.getLogoBG();
        mapleGuildSummary2.K = (byte)a2.getLogoBGColor();
        a3.a = (short)mapleGuild.getLogo();
        mapleGuildSummary.d = (byte)mapleGuild.getLogoColor();
        mapleGuildSummary.ALLATORIxDEMO = a2.getAllianceId();
    }

    public /* synthetic */ String getName() {
        MapleGuildSummary a2;
        return a2.B;
    }

    public /* synthetic */ short getLogo() {
        MapleGuildSummary a2;
        return a2.a;
    }
}

