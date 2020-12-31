/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleJob;
import client.MapleQuestStatus;
import client.MapleStat;
import client.PlayerStats;
import client.SkillEntry;
import client.SkillFactory;
import client.inventory.InventoryException;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.JobConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import server.Randomizer;
import server.quest.MapleQuest;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.wztosql.DumpMapName;

public class StatsHandling {
    public static final /* synthetic */ void DistributeSP(int a2, MapleClient a3, MapleCharacter a4) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        boolean bl = false;
        if (MapleJob.isBeginner(a2 / 10000) && (a2 % 10000 == 1000 || a2 % 10000 == 1001 || a2 % 10000 == 1002 || a2 % 10000 == 2 || a2 == 140000291)) {
            boolean bl2 = a2 / 10000 == 3000 || a2 / 10000 == 3001;
            MapleCharacter mapleCharacter = a4;
            n7 = mapleCharacter.getSkillLevel(SkillFactory.getSkill(a2 / 10000 * 10000 + 1000));
            n6 = mapleCharacter.getSkillLevel(SkillFactory.getSkill(a2 / 10000 * 10000 + 1001));
            n5 = mapleCharacter.getSkillLevel(SkillFactory.getSkill(a2 / 10000 * 10000 + (bl2 ? 2 : 1002)));
            MapleCharacter mapleCharacter2 = a4;
            n4 = mapleCharacter2.getSkillLevel(SkillFactory.getSkill(140000291));
            n3 = Math.min(mapleCharacter2.getLevel() - 1, bl2 ? 9 : 6) - n7 - n6 - n5 - n4;
            bl = true;
            n2 = a2;
        } else {
            if (MapleJob.isBeginner(a2 / 10000)) {
                if (a4.isStaff()) {
                    a4.dropMessage(5, "\u52a0\u6280\u80fd\u9ede\u932f\u8aa4 - 1\u3000\u6280\u80fdID:" + a2);
                }
                if (a2 == 112) {
                    a4.dropMessage(1, InventoryException.ALLATORIxDEMO("\u6b1e\u62e1\u8087\u5fa4\u9872\u906e\u9034\u91ac\u7848\u5114\u4ef6\u8f28\u4e81\u52b8\u4ffc\u63b1\u533d\u5251\u7b33\u7d7bH\u3063"));
                }
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            n3 = a4.getRemainingSp(JobConstants.getSkillBookBySkill(a2));
            n2 = a2;
        }
        ISkill iSkill = SkillFactory.getSkill(n2);
        if (iSkill != null) {
            int n8;
            if (iSkill.hasRequiredSkill() && a4.getSkillLevel(SkillFactory.getSkill(iSkill.getRequiredSkillId())) < iSkill.getRequiredSkillLevel()) {
                return;
            }
            n7 = iSkill.isSkillNeedMasterLevel();
            n6 = n7 != 0 ? a4.getMasterLevel(iSkill) : iSkill.getMaxLevel();
            n5 = a4.getSkillLevel(iSkill);
            if (GameSetConstants.SERVER_NAME.equals(DumpMapName.ALLATORIxDEMO("\u664c\u8036\u8c64")) && n5 == 30 && a2 != 5110001) {
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.dropMessage(1, InventoryException.ALLATORIxDEMO("IQ\u7b33\u4e84\u4e70\u76e5\u62fa\u809c\u5390\u809c\u9075\u902f\u6842\u5fa2\u5b8c\u7792\u533d\u7d7b\u549c@"));
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (iSkill.isInvisible()) {
                MapleCharacter mapleCharacter = a4;
                n4 = mapleCharacter.getMasterLevel(iSkill);
                n8 = JobConstants.isDualBlade(mapleCharacter.getJob());
                if (n7 != 0 && n4 == 0 || n7 == 0 && !bl && n4 <= 0 && n8 == 0) {
                    return;
                }
            }
            if (iSkill.hasRequiredSkill() && a4.getSkillLevel(SkillFactory.getSkill(iSkill.getRequiredSkillId())) < iSkill.getRequiredSkillLevel()) {
                return;
            }
            int[] arrn = GameConstants.blockedSkills;
            n8 = GameConstants.blockedSkills.length;
            int n9 = n7 = 0;
            while (n9 < n8) {
                int n10 = arrn[n7];
                if (iSkill.getId() == n10) {
                    a4.dropMessage(1, DumpMapName.ALLATORIxDEMO("\nY&\u0016>W*\u0016=Y'\u00162R7\u0016'^:EsE8_?Z}"));
                    return;
                }
                n9 = ++n7;
            }
            if (n3 == 0) {
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.dropMessage(1, InventoryException.ALLATORIxDEMO("\u60c9\u9ea4\u934e\u574a\u65d8\u56b3@"));
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (n3 > 0 && n5 + 1 <= n6 && (iSkill.canBeLearnedBy(a4.getJob()) || bl)) {
                if (!bl) {
                    int n11 = GameConstants.getSkillBookForSkill(a2);
                    MapleCharacter mapleCharacter = a4;
                    mapleCharacter.setRemainingSp(mapleCharacter.getRemainingSp(n11) - 1, n11);
                }
                a3.sendPacket(MaplePacketCreator.updateSp(a4, false));
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.changeSkillLevel(iSkill, n5 + 1, mapleCharacter.getMasterLevel(iSkill));
                return;
            }
            if (!iSkill.canBeLearnedBy(a4.getJob())) {
                // empty if block
            }
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 3;
        int n5 = n3;
        int n6 = 5 << 3 ^ (3 ^ 5);
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

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean checkAssignAp(MapleCharacter a2, MapleStat a3, MapleStat a4, int a5, int a6) {
        MapleCharacter mapleCharacter = a2;
        PlayerStats playerStats = mapleCharacter.getStat();
        if (mapleCharacter.getRemainingAp() != a5 + a6) {
            return false;
        }
        switch (a3) {
            case STR: {
                if (playerStats.getStr() + a5 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            case DEX: {
                if (playerStats.getDex() + a5 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            case INT: {
                if (playerStats.getInt() + a5 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            case LUK: {
                if (playerStats.getLuk() + a5 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            default: {
                return false;
            }
        }
        switch (a4) {
            case STR: {
                if (playerStats.getStr() + a6 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            case DEX: {
                if (playerStats.getDex() + a6 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            case INT: {
                if (playerStats.getInt() + a6 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
            case LUK: {
                if (playerStats.getLuk() + a6 <= GameSetConstants.MAX_STAT) break;
                return false;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int ALLATORIxDEMO(MapleCharacter a2, MapleStat a3, int a4) {
        if (a2 != null && a3 != null) {
            short s2;
            short s3 = 0;
            switch (a3) {
                case STR: {
                    short s4 = (short)(a2.getStat().getStr() + a4);
                    s3 = s4;
                    if (s4 > 999) {
                        s2 = s3;
                        a2.getStat().setStr((short)999);
                        break;
                    }
                    a2.getStat().setStr(s3);
                    s2 = s3;
                    break;
                }
                case INT: {
                    short s5 = (short)(a2.getStat().getInt() + a4);
                    s3 = s5;
                    if (s5 > 999) {
                        s2 = s3;
                        a2.getStat().setInt((short)999);
                        break;
                    }
                    a2.getStat().setInt(s3);
                    s2 = s3;
                    break;
                }
                case LUK: {
                    short s6 = (short)(a2.getStat().getLuk() + a4);
                    s3 = s6;
                    if (s6 > 999) {
                        s2 = s3;
                        a2.getStat().setLuk((short)999);
                        break;
                    }
                    a2.getStat().setLuk(s3);
                    s2 = s3;
                    break;
                }
                case DEX: {
                    short s7 = (short)(a2.getStat().getDex() + a4);
                    s3 = s7;
                    if (s7 > 999) {
                        s2 = s3;
                        a2.getStat().setDex((short)999);
                        break;
                    }
                    a2.getStat().setDex(s3);
                    s2 = s3;
                    break;
                }
                default: {
                    s2 = s3;
                }
            }
            if (s2 > 999) {
                a2.updateSingleStat(a3, 999);
                return s3 - 999;
            }
            a2.updateSingleStat(a3, s3);
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void DistributeHyperSP(int a, MapleClient a, MapleCharacter a, boolean a) {
        block3: {
            var4_4 = SkillFactory.getSkill(a);
            if (var4_4 == null || !var4_4.isHyperSkill() && !var4_4.isHyperStat()) ** GOTO lbl17
            if (a != 0) break block3;
            a = a.getRemainingHSp(var4_4.getHyper() - 1);
            if (a >= 1 && a.getLevel() >= var4_4.getReqLevel() && var4_4.canBeLearnedBy(a.getJob()) && a.getSkillLevel(var4_4) == 0) {
                v0 = a;
                v0.setRemainingHSp(var4_4.getHyper() - 1, a - 1);
                v0.changeSkillLevel(a, 1, var4_4.getMaxLevel());
            }
            ** GOTO lbl17
        }
        if (a.getSkillLevel(var4_4) >= var4_4.getMaxLevel()) ** GOTO lbl17
        if (a == 80000406 && !JobConstants.is\u60e1\u9b54\u6bba\u624b(a.getJob()) && !JobConstants.is\u795e\u4e4b\u5b50(a.getJob())) {
            v1 = a;
            a.dropMessage(1, DumpMapName.ALLATORIxDEMO("\u8a44\u62d3\u80cb\u53b9\u673f\u60b2\u9b62\u6be9\u627d|\u7968\u4e18\u5b66\u53bc\u4ed3\u4f2c\u751e}"));
        } else {
            a.changeSkillLevel(a, a.getSkillLevel(var4_4) + 1, var4_4.getMaxLevel());
lbl17:
            // 4 sources

            v1 = a;
        }
        v1.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void AutoAssignAP(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        long l2;
        LittleEndianAccessor littleEndianAccessor;
        LittleEndianAccessor littleEndianAccessor2 = a2;
        a4.updateTick(littleEndianAccessor2.readInt());
        int n2 = littleEndianAccessor2.readInt();
        if (littleEndianAccessor2.available() < (long)(GameSetConstants.MAPLE_VERSION >= 147 ? n2 * 12 : 16)) {
            return;
        }
        long l3 = 0L;
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            LittleEndianAccessor littleEndianAccessor3 = a2;
            littleEndianAccessor = littleEndianAccessor3;
            l3 = littleEndianAccessor3.readLong();
        } else {
            LittleEndianAccessor littleEndianAccessor4 = a2;
            littleEndianAccessor = littleEndianAccessor4;
            l3 = littleEndianAccessor4.readInt();
        }
        int n3 = littleEndianAccessor.readInt();
        long l4 = 0L;
        l4 = GameSetConstants.MAPLE_VERSION >= 138 ? (n2 > 1 ? (long)((int)a2.readLong()) : 0L) : (long)a2.readInt();
        int n4 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            n4 = n2 > 1 ? a2.readInt() : 0;
            l2 = l3;
        } else {
            n4 = a2.readInt();
            l2 = l3;
        }
        MapleStat mapleStat = MapleStat.getByValue(l2);
        MapleStat mapleStat2 = MapleStat.getByValue(l4);
        if (n3 < 0 || n4 < 0) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a4.getRemainingAp() < 1) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!StatsHandling.checkAssignAp(a4, mapleStat, mapleStat2, n3, n4)) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = a4;
        PlayerStats playerStats = mapleCharacter.getStat();
        ArrayList<Pair<MapleStat, Integer>> arrayList = new ArrayList<Pair<MapleStat, Integer>>(2);
        a3.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, true, a4));
        if (mapleCharacter.getRemainingAp() == n3 + n4) {
            MapleCharacter mapleCharacter2;
            switch (mapleStat) {
                case STR: {
                    if (playerStats.getStr() + n3 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats2 = playerStats;
                    playerStats2.setStr((short)(playerStats2.getStr() + n3));
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.STR, Integer.valueOf(playerStats.getStr())));
                    break;
                }
                case DEX: {
                    if (playerStats.getDex() + n3 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats3 = playerStats;
                    playerStats3.setDex((short)(playerStats3.getDex() + n3));
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.DEX, Integer.valueOf(playerStats.getDex())));
                    break;
                }
                case INT: {
                    if (playerStats.getInt() + n3 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats4 = playerStats;
                    playerStats4.setInt((short)(playerStats4.getInt() + n3));
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.INT, Integer.valueOf(playerStats.getInt())));
                    break;
                }
                case LUK: {
                    if (playerStats.getLuk() + n3 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats5 = playerStats;
                    playerStats5.setLuk((short)(playerStats5.getLuk() + n3));
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.LUK, Integer.valueOf(playerStats.getLuk())));
                    break;
                }
                default: {
                    a3.sendPacket(MaplePacketCreator.updatePlayerStats(MaplePacketCreator.EMPTY_STATUPDATE, true, a4));
                    return;
                }
            }
            switch (mapleStat2) {
                case STR: {
                    if (playerStats.getStr() + n4 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats6 = playerStats;
                    playerStats6.setStr((short)(playerStats6.getStr() + n4));
                    mapleCharacter2 = a4;
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.STR, Integer.valueOf(playerStats.getStr())));
                    break;
                }
                case DEX: {
                    if (playerStats.getDex() + n4 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats7 = playerStats;
                    playerStats7.setDex((short)(playerStats7.getDex() + n4));
                    mapleCharacter2 = a4;
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.DEX, Integer.valueOf(playerStats.getDex())));
                    break;
                }
                case INT: {
                    if (playerStats.getInt() + n4 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats8 = playerStats;
                    playerStats8.setInt((short)(playerStats8.getInt() + n4));
                    mapleCharacter2 = a4;
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.INT, Integer.valueOf(playerStats.getInt())));
                    break;
                }
                case LUK: {
                    if (playerStats.getLuk() + n4 > GameSetConstants.MAX_STAT) {
                        return;
                    }
                    PlayerStats playerStats9 = playerStats;
                    playerStats9.setLuk((short)(playerStats9.getLuk() + n4));
                    mapleCharacter2 = a4;
                    arrayList.add(new Pair<MapleStat, Integer>(MapleStat.LUK, Integer.valueOf(playerStats.getLuk())));
                    break;
                }
                default: {
                    a3.sendPacket(MaplePacketCreator.updatePlayerStats(MaplePacketCreator.EMPTY_STATUPDATE, true, a4));
                    return;
                }
            }
            mapleCharacter2.setRemainingAp((short)(a4.getRemainingAp() - (n3 + n4)));
            arrayList.add(new Pair<MapleStat, Integer>(MapleStat.AVAILABLEAP, Integer.valueOf(a4.getRemainingAp())));
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, true, a4));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void DistributeAP(MapleClient a2, MapleCharacter a3, MapleStat a42) {
        ArrayList<Pair<MapleStat, Integer>> arrayList = new ArrayList<Pair<MapleStat, Integer>>(2);
        if (a3 != null) {
            a2.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, true, a3));
            MapleCharacter mapleCharacter = a3;
            PlayerStats playerStats = mapleCharacter.getStat();
            short s2 = a3.getJob();
            if (mapleCharacter.getRemainingAp() > 0 && a42 != null) {
                MapleCharacter mapleCharacter2;
                switch (1.ALLATORIxDEMO[a42.ordinal()]) {
                    case 1: {
                        if (playerStats.getStr() >= GameSetConstants.MAX_STAT) {
                            return;
                        }
                        PlayerStats playerStats2 = playerStats;
                        playerStats2.setStr((short)(playerStats2.getStr() + 1));
                        mapleCharacter2 = a3;
                        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.STR, Integer.valueOf(playerStats.getStr())));
                        break;
                    }
                    case 2: {
                        if (playerStats.getDex() >= GameSetConstants.MAX_STAT) {
                            return;
                        }
                        PlayerStats playerStats3 = playerStats;
                        playerStats3.setDex((short)(playerStats3.getDex() + 1));
                        mapleCharacter2 = a3;
                        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.DEX, Integer.valueOf(playerStats.getDex())));
                        break;
                    }
                    case 3: {
                        if (playerStats.getInt() >= GameSetConstants.MAX_STAT) {
                            return;
                        }
                        PlayerStats playerStats4 = playerStats;
                        playerStats4.setInt((short)(playerStats4.getInt() + 1));
                        mapleCharacter2 = a3;
                        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.INT, Integer.valueOf(playerStats.getInt())));
                        break;
                    }
                    case 4: {
                        if (playerStats.getLuk() >= GameSetConstants.MAX_STAT) {
                            return;
                        }
                        PlayerStats playerStats5 = playerStats;
                        playerStats5.setLuk((short)(playerStats5.getLuk() + 1));
                        mapleCharacter2 = a3;
                        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.LUK, Integer.valueOf(playerStats.getLuk())));
                        break;
                    }
                    case 5: {
                        int a42 = playerStats.getMaxHp();
                        if (a3.getHpMpApUsed() >= 10000 || a42 >= 30000) {
                            return;
                        }
                        if (s2 == 0) {
                            a42 += Randomizer.rand(8, 12);
                        } else if (s2 >= 100 && s2 <= 132 || s2 >= 3200 && s2 <= 3212) {
                            ISkill iSkill = SkillFactory.getSkill(1000001);
                            int n2 = a2.getPlayer().getSkillLevel(iSkill);
                            a42 += Randomizer.rand(20, 25);
                            if (n2 >= 1) {
                                a42 += iSkill.getEffect(n2).getX();
                            }
                        } else if (s2 >= 200 && s2 <= 232) {
                            a42 += Randomizer.rand(10, 20);
                        } else if (s2 >= 300 && s2 <= 322 || s2 >= 400 && s2 <= 434 || s2 >= 1300 && s2 <= 1312 || s2 >= 1400 && s2 <= 1412 || s2 >= 3300 && s2 <= 3312) {
                            a42 += Randomizer.rand(16, 20);
                        } else if (s2 >= 500 && s2 <= 522 || s2 >= 3500 && s2 <= 3512) {
                            ISkill iSkill = SkillFactory.getSkill(5100000);
                            int n3 = a2.getPlayer().getSkillLevel(iSkill);
                            a42 += Randomizer.rand(18, 22);
                            if (n3 >= 1) {
                                a42 += iSkill.getEffect(n3).getY();
                            }
                        } else if (s2 >= 1500 && s2 <= 1512) {
                            ISkill iSkill = SkillFactory.getSkill(15100000);
                            int n4 = a2.getPlayer().getSkillLevel(iSkill);
                            a42 += Randomizer.rand(18, 22);
                            if (n4 >= 1) {
                                a42 += iSkill.getEffect(n4).getY();
                            }
                        } else if (s2 >= 1100 && s2 <= 1112) {
                            ISkill iSkill = SkillFactory.getSkill(11000000);
                            int n5 = a2.getPlayer().getSkillLevel(iSkill);
                            a42 += Randomizer.rand(36, 42);
                            if (n5 >= 1) {
                                a42 += iSkill.getEffect(n5).getY();
                            }
                        } else {
                            a42 = s2 >= 1200 && s2 <= 1212 ? (a42 += Randomizer.rand(15, 21)) : (s2 >= 2000 && s2 <= 2112 ? (a42 += Randomizer.rand(40, 50)) : (a42 += Randomizer.rand(50, 100)));
                        }
                        a42 = (short)Math.min(30000, Math.abs(a42));
                        mapleCharacter2 = a3;
                        MapleCharacter mapleCharacter3 = a3;
                        mapleCharacter3.setHpMpApUsed((short)(mapleCharacter3.getHpMpApUsed() + 1));
                        playerStats.setMaxHp(a42);
                        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MAXHP, a42));
                        break;
                    }
                    case 6: {
                        int n6 = playerStats.getMaxMp();
                        if (a3.getHpMpApUsed() >= 10000 || playerStats.getMaxMp() >= 30000) {
                            return;
                        }
                        if (s2 == 0) {
                            n6 += Randomizer.rand(6, 8);
                        } else if (s2 >= 100 && s2 <= 132) {
                            n6 += Randomizer.rand(2, 4);
                        } else if (s2 >= 200 && s2 <= 232 || s2 >= 3200 && s2 <= 3212) {
                            ISkill iSkill = SkillFactory.getSkill(2000001);
                            int a42 = a2.getPlayer().getSkillLevel(iSkill);
                            n6 += Randomizer.rand(18, 20);
                            if (a42 >= 1) {
                                n6 += iSkill.getEffect(a42).getY() * 2;
                            }
                        } else if (s2 >= 300 && s2 <= 322 || s2 >= 400 && s2 <= 434 || s2 >= 500 && s2 <= 522 || s2 >= 3200 && s2 <= 3212 || s2 >= 3500 && s2 <= 3512 || s2 >= 1300 && s2 <= 1312 || s2 >= 1400 && s2 <= 1412 || s2 >= 1500 && s2 <= 1512) {
                            n6 += Randomizer.rand(10, 12);
                        } else if (s2 >= 1100 && s2 <= 1112) {
                            n6 += Randomizer.rand(6, 9);
                        } else if (s2 >= 1200 && s2 <= 1212) {
                            ISkill iSkill = SkillFactory.getSkill(12000000);
                            int a42 = a2.getPlayer().getSkillLevel(iSkill);
                            n6 += Randomizer.rand(18, 20);
                            if (a42 >= 1) {
                                n6 += iSkill.getEffect(a42).getY() * 2;
                            }
                        } else {
                            n6 = s2 >= 2000 && s2 <= 2112 ? (n6 += Randomizer.rand(6, 9)) : (n6 += Randomizer.rand(50, 100));
                        }
                        n6 = (short)Math.min(30000, Math.abs(n6));
                        mapleCharacter2 = a3;
                        MapleCharacter mapleCharacter4 = a3;
                        mapleCharacter4.setHpMpApUsed((short)(mapleCharacter4.getHpMpApUsed() + 1));
                        playerStats.setMaxMp(n6);
                        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MAXMP, n6));
                        break;
                    }
                    default: {
                        a2.sendPacket(MaplePacketCreator.updatePlayerStats(MaplePacketCreator.EMPTY_STATUPDATE, true, a3));
                        return;
                    }
                }
                mapleCharacter2.setRemainingAp((short)(a3.getRemainingAp() - 1));
                arrayList.add(new Pair<MapleStat, Integer>(MapleStat.AVAILABLEAP, Integer.valueOf(a3.getRemainingAp())));
                a2.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, true, a3));
            }
        }
    }

    public /* synthetic */ StatsHandling() {
        StatsHandling a2;
    }

    public static final /* synthetic */ void DistributeAP(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4 != null) {
            LittleEndianAccessor littleEndianAccessor = a2;
            a4.updateTick(littleEndianAccessor.readInt());
            MapleStat mapleStat = MapleStat.getByValue(littleEndianAccessor.readInt());
            StatsHandling.DistributeAP(a3, a4, mapleStat);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void ResetHyperSP(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a3 == null || a4 == null) {
            return;
        }
        a4.updateTick(a2.readInt());
        int n2 = a2.readShort();
        if (n2 < 1 || n2 > 3) {
            n2 = 3;
        }
        if (n2 > 0) {
            HashMap<ISkill, SkillEntry> hashMap;
            MapleQuestStatus mapleQuestStatus = a4.getQuestNAdd(MapleQuest.getInstance(7965));
            int n3 = 1000000;
            n3 = 100000;
            if (mapleQuestStatus.getCustomData() != null && !mapleQuestStatus.getCustomData().equals(InventoryException.ALLATORIxDEMO("Q"))) {
                switch (Integer.valueOf(mapleQuestStatus.getCustomData())) {
                    case 1: {
                        n3 = 1000000;
                        break;
                    }
                    case 2: {
                        n3 = 2000000;
                        break;
                    }
                    case 3: {
                        n3 = 5000000;
                        break;
                    }
                    default: {
                        n3 = 10000000;
                    }
                }
            }
            HashMap<ISkill, SkillEntry> hashMap2 = new HashMap<ISkill, SkillEntry>(a4.getSkills());
            HashMap<ISkill, SkillEntry> hashMap3 = new HashMap<ISkill, SkillEntry>();
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            for (Map.Entry entry : hashMap2.entrySet()) {
                ISkill iSkill;
                ISkill iSkill2 = (ISkill)entry.getKey();
                if (iSkill2 == null || !iSkill2.isHyperSkill() || a4.getSkillLevel((ISkill)entry.getKey()) != 1) continue;
                if (iSkill2.getHyper() == 1) {
                    iSkill = iSkill2;
                    ++n4;
                } else if (iSkill2.getHyper() == 2) {
                    iSkill = iSkill2;
                    ++n5;
                } else {
                    if (iSkill2.getHyper() == 3) {
                        ++n6;
                    }
                    iSkill = iSkill2;
                }
                HashMap<ISkill, SkillEntry> hashMap4 = hashMap3;
                if (iSkill.canBeLearnedBy(a4.getJob())) {
                    hashMap4.put((ISkill)entry.getKey(), new SkillEntry(0, ((SkillEntry)entry.getValue()).masterlevel, ((SkillEntry)entry.getValue()).expiration));
                    continue;
                }
                hashMap4.put((ISkill)entry.getKey(), new SkillEntry(0, 0, -1L));
            }
            if (!hashMap3.isEmpty() && a4.getMeso() >= n3) {
                MapleCharacter mapleCharacter = a4;
                MapleCharacter mapleCharacter2 = a4;
                mapleCharacter2.gainMeso(-n3, true, true);
                mapleCharacter2.changeSkillLevel(hashMap3);
                a3.sendPacket(MaplePacketCreator.sendHyperSkillResetResult(true, a4.getId()));
                a4.gainHSP(0, n4);
                mapleCharacter.gainHSP(1, n5);
                mapleCharacter.gainHSP(2, n6);
                if (mapleQuestStatus.getStatus() == 0) {
                    mapleQuestStatus.setStatus((byte)1);
                }
                a4.addQuestPoint(7965, 1L);
                a4.updateQuest(mapleQuestStatus, true);
                hashMap = hashMap2;
            } else {
                a3.sendPacket(MaplePacketCreator.sendHyperSkillResetResult(false, a4.getId()));
                hashMap = hashMap2;
            }
            hashMap.clear();
            hashMap3.clear();
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }
}

