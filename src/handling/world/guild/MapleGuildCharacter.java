/*
 * Decompiled with CFR 0.150.
 */
package handling.world.guild;

import client.MapleCharacter;
import java.io.Serializable;

public class MapleGuildCharacter
implements Serializable {
    private /* synthetic */ int k;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int a;
    private final /* synthetic */ int B;
    private /* synthetic */ byte E;
    public static final /* synthetic */ long serialVersionUID = 2058609046116597760L;
    private /* synthetic */ byte e;
    private final /* synthetic */ String d;
    private /* synthetic */ int K;
    private /* synthetic */ short g;
    private /* synthetic */ byte H;

    public /* synthetic */ void setGuildId(int a2) {
        a.K = a2;
    }

    public /* synthetic */ int getId() {
        MapleGuildCharacter a2;
        return a2.B;
    }

    public /* synthetic */ byte getAllianceRank() {
        MapleGuildCharacter a2;
        return a2.E;
    }

    public /* synthetic */ void setOnline(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void setGuildRank(byte a2) {
        a.e = a2;
    }

    public /* synthetic */ void setJobId(int a2) {
        a.k = a2;
    }

    public /* synthetic */ boolean isOnline() {
        MapleGuildCharacter a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ byte getGuildRank() {
        MapleGuildCharacter a2;
        return a2.e;
    }

    public /* synthetic */ void setGuildContribution(int a2) {
        a.a = a2;
    }

    public /* synthetic */ MapleGuildCharacter(MapleCharacter a2) {
        MapleGuildCharacter a3;
        MapleGuildCharacter mapleGuildCharacter = a3;
        MapleCharacter mapleCharacter = a2;
        MapleGuildCharacter mapleGuildCharacter2 = a3;
        MapleCharacter mapleCharacter2 = a2;
        MapleGuildCharacter mapleGuildCharacter3 = a3;
        MapleCharacter mapleCharacter3 = a2;
        MapleGuildCharacter mapleGuildCharacter4 = a3;
        mapleGuildCharacter4.H = (byte)-1;
        mapleGuildCharacter4.a = 0;
        a3.d = mapleCharacter3.getName();
        mapleGuildCharacter3.g = mapleCharacter3.getLevel();
        mapleGuildCharacter3.B = a2.getId();
        a3.H = (byte)mapleCharacter2.getClient().getChannel();
        mapleGuildCharacter2.k = mapleCharacter2.getJob();
        mapleGuildCharacter2.e = a2.getGuildRank();
        a3.K = mapleCharacter.getGuildId();
        mapleGuildCharacter.E = mapleCharacter.getAllianceRank();
        mapleGuildCharacter.ALLATORIxDEMO = true;
    }

    public /* synthetic */ int getJobId() {
        MapleGuildCharacter a2;
        return a2.k;
    }

    public /* synthetic */ String getName() {
        MapleGuildCharacter a2;
        int n2 = 13;
        if (a2.d.length() >= n2) {
            MapleGuildCharacter mapleGuildCharacter = a2;
            System.out.println("\u89d2\u8272\u540d\u7a31\u904e\u9577, \u89d2\u8272:" + mapleGuildCharacter.d + " \u9577\u5ea6:" + mapleGuildCharacter.d.length());
        }
        return a2.d;
    }

    public /* synthetic */ int getGuildId() {
        MapleGuildCharacter a2;
        return a2.K;
    }

    public /* synthetic */ int getLevel() {
        MapleGuildCharacter a2;
        return a2.g;
    }

    public /* synthetic */ void setLevel(short a2) {
        a.g = a2;
    }

    public /* synthetic */ int getGuildContribution() {
        MapleGuildCharacter a2;
        return a2.a;
    }

    public /* synthetic */ MapleGuildCharacter(int a2, short a3, String a4, byte a5, int a6, byte a7, byte a8, int a9, boolean a10) {
        MapleGuildCharacter a11;
        MapleGuildCharacter mapleGuildCharacter = a11;
        MapleGuildCharacter mapleGuildCharacter2 = a11;
        a11.H = (byte)-1;
        mapleGuildCharacter2.a = 0;
        mapleGuildCharacter2.g = a3;
        mapleGuildCharacter.B = a2;
        mapleGuildCharacter.d = a4;
        if (a10) {
            a11.H = a5;
        }
        MapleGuildCharacter mapleGuildCharacter3 = a11;
        MapleGuildCharacter mapleGuildCharacter4 = a11;
        mapleGuildCharacter4.k = a6;
        mapleGuildCharacter4.ALLATORIxDEMO = a10;
        mapleGuildCharacter3.e = a7;
        mapleGuildCharacter3.E = a8;
        a11.K = a9;
    }

    public /* synthetic */ void setAllianceRank(byte a2) {
        a.E = a2;
    }

    public /* synthetic */ void setChannel(byte a2) {
        a.H = a2;
    }

    public /* synthetic */ int getChannel() {
        MapleGuildCharacter a2;
        return a2.H;
    }
}

