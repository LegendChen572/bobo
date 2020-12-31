/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import constants.GameConstants;
import constants.GameSetConstants;
import server.life.MapleMonster;
import server.life.MapleMonsterStats;
import server.life.OverrideMonsterStats;

public class ChangeableStats
extends OverrideMonsterStats {
    public /* synthetic */ int matk;
    public /* synthetic */ int speed;
    public /* synthetic */ int pushed;
    public /* synthetic */ int watk;
    public /* synthetic */ int PDRate;
    public /* synthetic */ int acc;
    public /* synthetic */ int MDRate;
    public /* synthetic */ int level;
    public /* synthetic */ int eva;

    public /* synthetic */ ChangeableStats(MapleMonsterStats a2, double a3) {
        ChangeableStats a4;
        ChangeableStats changeableStats = a4;
        changeableStats.hp = (long)((double)a2.getHp() * a3);
        if (changeableStats.hp <= 0L) {
            a4.hp = 1L;
        }
        if (a4.mp <= 0) {
            a4.mp = 1;
        }
        ChangeableStats changeableStats2 = a4;
        MapleMonsterStats mapleMonsterStats = a2;
        changeableStats2.mp = mapleMonsterStats.getMp();
        changeableStats2.exp = mapleMonsterStats.getExp();
    }

    public /* synthetic */ ChangeableStats(MapleMonsterStats a2, OverrideMonsterStats a3) {
        ChangeableStats a4;
        ChangeableStats changeableStats = a4;
        MapleMonsterStats mapleMonsterStats = a2;
        ChangeableStats changeableStats2 = a4;
        MapleMonsterStats mapleMonsterStats2 = a2;
        ChangeableStats changeableStats3 = a4;
        ChangeableStats changeableStats4 = a4;
        OverrideMonsterStats overrideMonsterStats = a3;
        a4.hp = overrideMonsterStats.getHp();
        changeableStats4.exp = overrideMonsterStats.getExp();
        changeableStats4.mp = a3.getMp();
        changeableStats3.watk = a2.getPhysicalAttack();
        changeableStats3.matk = a2.getMagicAttack();
        a4.acc = mapleMonsterStats2.getAcc();
        changeableStats2.eva = mapleMonsterStats2.getEva();
        changeableStats2.PDRate = a2.getPDRate();
        a4.MDRate = mapleMonsterStats.getMDRate();
        changeableStats.pushed = mapleMonsterStats.getPushed();
        changeableStats.level = a2.getLevel();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ ChangeableStats(MapleMonster a, MapleMonsterStats a, boolean a) {
        super();
        var4_4 = a.getLevel();
        var5_5 = GameSetConstants.HELL_RATE[0];
        var7_6 = GameSetConstants.HELL_RATE[1];
        var9_7 = GameSetConstants.HELL_RATE[2];
        var11_8 = GameSetConstants.HELL_RATE[3];
        var13_9 = GameSetConstants.HELL_RATE[4];
        var15_10 = GameSetConstants.HELL_RATE[5];
        if (!a) ** GOTO lbl-1000
        if (var4_4 >= 10 && var4_4 <= 49) {
            var9_7 = 1.7;
            v0 = var4_4;
        } else if (var4_4 >= 50 && var4_4 <= 69) {
            var9_7 = 1.6;
            v0 = var4_4;
        } else if (var4_4 >= 70 && var4_4 <= 89) {
            var9_7 = 1.5;
            v0 = var4_4;
        } else if (var4_4 >= 90 && var4_4 <= 109) {
            var9_7 = 1.4;
            v0 = var4_4;
        } else if (var4_4 >= 110 && var4_4 <= 129) {
            var9_7 = 1.3;
            v0 = var4_4;
        } else if (var4_4 >= 130 && var4_4 <= 160) {
            var9_7 = 1.2;
            v0 = var4_4;
        } else {
            if (var4_4 >= 161) {
                var9_7 = 1.1;
            }
            v0 = var4_4;
        }
        if (v0 >= 1 && var4_4 <= 100) {
            var5_5 = 5.0;
            var11_8 = 20.0;
            var15_10 = 22.0;
            v1 = a;
        } else if (var4_4 >= 101 && var4_4 <= 150) {
            var5_5 = 10.0;
            var11_8 = 30.0;
            var15_10 = 33.0;
            v1 = a;
        } else if (var4_4 >= 151 && var4_4 <= 170) {
            var5_5 = 15.0;
            var11_8 = 35.0;
            var15_10 = 35.0;
            v1 = a;
        } else {
            if (var4_4 >= 171) {
                var5_5 = 20.0;
                var11_8 = 50.0;
                var15_10 = 45.0;
            }
            v1 = a;
        }
        switch (v1.getId()) {
            case 8800000: 
            case 8800001: 
            case 8800002: 
            case 8800003: 
            case 8800004: 
            case 8800005: 
            case 8800006: 
            case 8800007: 
            case 8800008: 
            case 8800009: 
            case 8800010: 
            case 8810000: 
            case 8810001: 
            case 8810002: 
            case 8810003: 
            case 8810004: 
            case 8810005: 
            case 8810006: 
            case 8810007: 
            case 8810008: 
            case 8810009: 
            case 8810010: 
            case 8810011: 
            case 8810012: 
            case 8810013: 
            case 8810014: 
            case 8810015: 
            case 8810016: 
            case 8810017: 
            case 9420542: 
            case 9420543: 
            case 9420544: 
            case 9420547: 
            case 9420548: 
            case 9420549: {
                var11_8 *= 2.0;
                v2 = a;
                break;
            }
            case 9400408: 
            case 9400409: {
                var11_8 *= 1.5;
            }
            default: lbl-1000:
            // 2 sources

            {
                v2 = a;
            }
        }
        v2.setExtraMesoRate(var5_5);
        a.setExtraDropRate(var7_6);
        v3 = a;
        v4 = a;
        a.level = (int)((double)a.getLevel() * var9_7);
        a.hp = (long)((double)v4.getHp() * var11_8);
        v3.mp = (int)((double)v4.getMp() * var13_9);
        v3.exp = (int)((double)a.getExp() * var15_10);
    }

    public /* synthetic */ ChangeableStats(MapleMonsterStats a2, int a3, boolean a4) {
        MapleMonsterStats mapleMonsterStats;
        int n2;
        MapleMonsterStats mapleMonsterStats2;
        int n3;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        ChangeableStats a5;
        MapleMonsterStats mapleMonsterStats3 = a2;
        double d7 = (double)a3 / (double)mapleMonsterStats3.getLevel();
        double d8 = (double)mapleMonsterStats3.getHp() / (double)a2.getExp();
        double d9 = d6 = a4 ? 2.5 : 1.0;
        if (!a2.isBoss()) {
            d5 = GameConstants.getMonsterHP(a3);
            d4 = d6;
        } else {
            d5 = (double)a2.getHp() * d7;
            d4 = d6;
        }
        a5.hp = Math.round(d5 * d4);
        if (!a2.isBoss()) {
            d3 = (double)GameConstants.getMonsterHP(a3) / d8;
            d2 = d7;
        } else {
            d3 = (double)a2.getExp() * d7;
            d2 = d7;
        }
        a5.exp = (int)Math.round(d3 * d2 * d6);
        ChangeableStats changeableStats = a5;
        MapleMonsterStats mapleMonsterStats4 = a2;
        ChangeableStats changeableStats2 = a5;
        MapleMonsterStats mapleMonsterStats5 = a2;
        a5.mp = (int)Math.round((double)mapleMonsterStats5.getMp() * d7 * d6);
        changeableStats2.watk = (int)Math.round((double)mapleMonsterStats5.getPhysicalAttack() * d7);
        changeableStats2.matk = (int)Math.round((double)a2.getMagicAttack() * d7);
        a5.acc = Math.round(mapleMonsterStats4.getAcc() + Math.max(0, a3 - a2.getLevel()) * 2);
        changeableStats.eva = Math.round(mapleMonsterStats4.getEva() + Math.max(0, a3 - a2.getLevel()));
        if (a2.isBoss()) {
            n3 = 30;
            mapleMonsterStats2 = a2;
        } else {
            n3 = 20;
            mapleMonsterStats2 = a2;
        }
        changeableStats.PDRate = Math.min(n3, (int)Math.round((double)mapleMonsterStats2.getPDRate() * d7));
        if (a2.isBoss()) {
            n2 = 30;
            mapleMonsterStats = a2;
        } else {
            n2 = 20;
            mapleMonsterStats = a2;
        }
        a5.MDRate = Math.min(n2, (int)Math.round((double)mapleMonsterStats.getMDRate() * d7));
        ChangeableStats changeableStats3 = a5;
        changeableStats3.pushed = (int)Math.round((double)a2.getPushed() * d7);
        changeableStats3.level = a3;
    }
}

