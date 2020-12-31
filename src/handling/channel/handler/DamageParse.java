/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.MapleJob;
import client.PlayerStats;
import client.SkillFactory;
import client.anticheat.CheatTracker;
import client.anticheat.CheatingOffense;
import client.messages.commands.player.eventSystem.MapOwner;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.ServerConfig;
import constants.SkillConstants;
import handling.channel.handler.AttackInfo;
import handling.channel.handler.AttackType;
import handling.channel.handler.PlayerHandler;
import handling.opcodes.MapleBuffStat;
import handling.world.World;
import handling.world.weather.WeatherHandler;
import handling.world.weather.WeatherType;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import server.MapleDueyActions;
import server.MapleStatEffect;
import server.Randomizer;
import server.characterCards.MapleCharacterCards;
import server.life.Element;
import server.life.MapleMonster;
import server.life.MapleMonsterStats;
import server.life.MonsterGlobalDropEntry;
import server.maps.MapleMap;
import server.maps.MapleMapObjectType;
import server.maps.MaplePvp;
import tools.AttackPair;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.LittleEndianAccessor;

/*
 * Exception performing whole class analysis ignored.
 */
public class DamageParse {
    private static /* synthetic */ List<Integer> ALLATORIxDEMO;

    public static /* synthetic */ {
        ALLATORIxDEMO = new LinkedList<Integer>();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final /* synthetic */ double ALLATORIxDEMO(Element a2, double a3, PlayerStats a4) {
        switch (a2) {
            case FIRE: {
                return a3 / 100.0 * (double)(a4.element_fire + a4.getElementBoost(a2));
            }
            case ICE: {
                return a3 / 100.0 * (double)(a4.element_ice + a4.getElementBoost(a2));
            }
            case LIGHTING: {
                return a3 / 100.0 * (double)(a4.element_light + a4.getElementBoost(a2));
            }
            case POISON: {
                return a3 / 100.0 * (double)(a4.element_psn + a4.getElementBoost(a2));
            }
        }
        return a3 / 100.0 * (double)(a4.def + a4.getElementBoost(a2));
    }

    public static /* synthetic */ int getAttackCount(MapleCharacter a2, int a32, AttackInfo a4) {
        Object object = SkillFactory.getSkill(SkillConstants.getLinkedSkill(a32));
        int n2 = 0;
        int n3 = 1;
        if (object != null && (n2 = a2.getSkillLevel((ISkill)object)) == 0 && a2.containsBindingBySkillid(a4.skill)) {
            n2 = 1;
        }
        n3 = ((MapleStatEffect)(object = a4.getAttackEffect(a2, n2, (ISkill)object))).getAttackCount() > ((MapleStatEffect)object).getBulletCount() ? ((MapleStatEffect)object).getAttackCount() : ((MapleStatEffect)object).getBulletCount();
        int n4 = a32;
        if (n4 != SkillConstants.getLinkedSkill(n4)) {
            int n5 = 0;
            n2 = 1;
            Object a32 = SkillFactory.getSkill(a32);
            if (a32 != null) {
                n5 = a2.getSkillLevel((ISkill)a32);
                if (n5 == 0) {
                    n5 = 1;
                }
                if ((a32 = a4.getAttackEffect(a2, n5, (ISkill)a32)) != null && (n2 = (int)(((MapleStatEffect)a32).getAttackCount() > ((MapleStatEffect)a32).getBulletCount() ? ((MapleStatEffect)a32).getAttackCount() : ((MapleStatEffect)a32).getBulletCount())) > n3) {
                    n3 = n2;
                }
            }
        }
        return n3;
    }

    public static /* synthetic */ int getAttackTarget(MapleCharacter a2, int a32, AttackInfo a4) {
        ISkill iSkill = SkillFactory.getSkill(SkillConstants.getLinkedSkill(a32));
        int n2 = 0;
        int n3 = 1;
        if (iSkill != null && (n2 = a2.getSkillLevel(iSkill)) == 0 && a2.containsBindingBySkillid(a4.skill)) {
            n2 = 1;
        }
        n3 = a4.getAttackEffect(a2, n2, iSkill).getMobCount();
        int n4 = a32;
        if (n4 != SkillConstants.getLinkedSkill(n4)) {
            int n5 = 0;
            n2 = 1;
            Object a32 = SkillFactory.getSkill(a32);
            if (a32 != null) {
                n5 = a2.getSkillLevel((ISkill)a32);
                if (n5 == 0) {
                    n5 = 1;
                }
                if ((a32 = a4.getAttackEffect(a2, n5, (ISkill)a32)) != null) {
                    byte by = ((MapleStatEffect)a32).getMobCount();
                    n2 = by;
                    if (by > n3) {
                        n3 = n2;
                    }
                }
            }
        }
        return n3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static /* synthetic */ double H(MapleCharacter a, MapleMonster a, AttackInfo a, ISkill a, MapleStatEffect a, double a, Integer a) {
        block49: {
            block48: {
                if (a.getMapId() / 1000000 == 914) {
                    return 199999.0;
                }
                var8_8 = GameSetConstants.MAX_DAMAGE;
                var9_9 = new ArrayList<Element>();
                var10_10 = false;
                if (a == null) break block48;
                var9_9.add(a.getElement());
                if (a.getStatusSourceID(MonsterStatus.FREEZE) == 21120006) {
                    var10_10 = true;
                }
                switch (a.getId()) {
                    case 3001004: 
                    case 3221001: 
                    case 4221001: 
                    case 4331003: {
                        var10_10 = true;
                        v0 = a;
                        break block49;
                    }
                    case 1000: 
                    case 10001000: 
                    case 20001000: 
                    case 20011000: 
                    case 30001000: {
                        a = 40.0;
                        var10_10 = true;
                        v0 = a;
                        break block49;
                    }
                    case 1020: 
                    case 10001020: 
                    case 20001020: 
                    case 20011020: 
                    case 30001020: {
                        a = 1.0;
                        var10_10 = true;
                        v0 = a;
                        break block49;
                    }
                    case 3221007: {
                        a = a.getStats().isBoss() != false ? var8_8.longValue() : a.getMobMaxHp();
                        var10_10 = true;
                        v0 = a;
                        break block49;
                    }
                    case 1221011: {
                        a = a.getStats().isBoss() != false ? var8_8 : a.getHp() - 1L;
                        var10_10 = true;
                        v0 = a;
                        break block49;
                    }
                    case 4211006: {
                        a = a.getStats().isBoss() != false ? var8_8.longValue() : a.getMobMaxHp();
                        var10_10 = true;
                        v0 = a;
                        break block49;
                    }
                    case 1009: 
                    case 10001009: 
                    case 20001009: 
                    case 20011009: 
                    case 30001009: {
                        var10_10 = true;
                        v1 = a;
                        a = a.getStats().isBoss() != false ? v1.getMobMaxHp() / 30L * 100L : v1.getMobMaxHp();
                        v0 = a;
                        break block49;
                    }
                    case 3211006: {
                        if (a.getStatusSourceID(MonsterStatus.FREEZE) != 3211003) break;
                        var10_10 = true;
                        v0 = a;
                        a = a.getHp();
                        break block49;
                    }
                    case 5121007: {
                        a *= 2.8;
                        v0 = a;
                        break block49;
                    }
                    case 1111008: 
                    case 0x111AEE: 
                    case 1311001: 
                    case 1311006: 
                    case 4201005: {
                        a *= 3.0;
                        v0 = a;
                        break block49;
                    }
                    case 1001004: 
                    case 1121008: {
                        a *= 2.5;
                        v0 = a;
                        break block49;
                    }
                    case 1001005: 
                    case 1311004: 
                    case 3121004: {
                        a *= 2.0;
                    }
                }
            }
            v0 = a;
        }
        if (MapleJob.is\u72c2\u72fc\u52c7\u58eb(v0.getJob())) {
            a *= 2.0;
            v2 = a;
        } else {
            if (MapleJob.is\u62f3\u9738(a.getJob())) {
                a *= 1.1;
            }
            v2 = a;
        }
        if (v2.getBuffedValue(MapleBuffStat.WK_CHARGE) == null) ** GOTO lbl-1000
        var11_11 = a.getBuffSource(MapleBuffStat.WK_CHARGE);
        switch (var11_11) {
            case 1211003: 
            case 1211004: {
                var9_9.add(Element.FIRE);
                v3 = a;
                break;
            }
            case 1211005: 
            case 1211006: 
            case 21111005: {
                var9_9.add(Element.ICE);
                v3 = a;
                break;
            }
            case 1211007: 
            case 1211008: 
            case 15101006: {
                var9_9.add(Element.LIGHTING);
                v3 = a;
                break;
            }
            case 1221003: 
            case 1221004: 
            case 11111007: {
                var9_9.add(Element.HOLY);
                v3 = a;
                break;
            }
            case 12101005: {
                var9_9.clear();
            }
            default: lbl-1000:
            // 2 sources

            {
                v3 = a;
            }
        }
        if (v3.getBuffedValue(MapleBuffStat.LIGHTNING_CHARGE) != null) {
            var9_9.add(Element.LIGHTING);
        }
        var11_12 = a;
        if (var9_9.size() > 0) {
            switch (a.skill) {
                case 3111003: 
                case 3211003: {
                    a = (double)a.getX() / 200.0;
                    v4 = var9_9;
                    break;
                }
                default: {
                    a = 0.5;
                    v4 = var9_9;
                }
            }
            block32: for (Element var15_14 : v4) {
                switch (1.d[a.getEffectiveness(var15_14 /* !! */ ).ordinal()]) {
                    case 1: {
                        var11_12 = 1.0;
                        continue block32;
                    }
                    case 3: {
                        var11_12 *= 1.0 + a;
                        continue block32;
                    }
                    case 4: {
                        var11_12 *= 1.0 - a;
                        continue block32;
                    }
                }
            }
        }
        var13_15 = (a = a.getStats().getLevel()) > a.getLevel() ? (short)(a - a.getLevel()) : 0;
        var11_12 = var11_12 * (1.0 - 0.01 * (double)var13_15) - (double)a.getStats().getPhysicalDefense() * 0.5;
        var11_12 += var11_12 / 100.0 * (double)a.intValue();
        if (a != null && a.isChargeSkill() && a.getKeyDownSkill_Time() == 0L && a.getId() != 4111005) {
            return 0.0;
        }
        var14_13 = a.getStatForBuff(MapleBuffStat.HOMING_BEACON);
        if (var14_13 != null && a.getFirstLinkMid() == a.getObjectId() && var14_13.getSourceId() == 5220011) {
            v5 = var11_12;
            var11_12 = v5 + v5 * (double)var14_13.getX();
        }
        var15_14 /* !! */  = a.getStat();
        v6 = var11_12;
        v7 /* !! */  = var15_14 /* !! */ ;
        var11_12 = v6 + v6 * (a.getStats().isBoss() != false ? v7 /* !! */ .bossdam_r * 2.0 : v7 /* !! */ .dam_r) / 100.0;
        switch (a.getId()) {
            case 1110101: {
                var11_12 *= 2.0;
                break;
            }
        }
        if (a.isBuffed(MonsterStatus.DAMAGE_IMMUNITY) || a.isBuffed(MonsterStatus.WEAPON_IMMUNITY) || a.isBuffed(MonsterStatus.WEAPON_DAMAGE_REFLECT)) {
            var11_12 = 1.0;
        }
        if (a.getAttackDebugMessage()) {
            v8 = a;
            v8.dropMessage("[\u50b7\u5bb3\u8a08\u7b97]\u5c6c\u6027\u50b7\u5bb3\uff1a" + (int)Math.ceil(var11_12) + " BOSS\u50b7\u5bb3\uff1a" + (int)Math.ceil((a.getStats().isBoss() != false ? v8.getStat().bossdam_r : v8.getStat().dam_r) - 100.0) + "%");
        }
        if (var11_12 > (double)var8_8.longValue() && !var10_10) {
            v9 = a;
            var11_12 = var8_8.longValue();
        } else {
            if (var11_12 < 0.0) {
                var11_12 = 1.0;
            }
            v9 = a;
        }
        if (v9 == null) {
            v10 = 0;
            v11 = var11_12;
            return SkillConstants.handleSpecialSkillDamage(v10, (long)v11);
        }
        v10 = a.getId();
        v11 = var11_12;
        return SkillConstants.handleSpecialSkillDamage(v10, (long)v11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void applyAttackMagic(AttackInfo a2, ISkill a3, MapleCharacter a4, MapleStatEffect a5, double a6) {
        if (!a4.isAlive()) {
            a4.getCheatTracker().registerOffense(CheatingOffense.ATTACKING_WHILE_DEAD);
            return;
        }
        if (a2.real && !MapleJob.is\u91cd\u7832\u6307\u63ee\u5b98(a4.getJob()) && !MapConstants.isVonleonMap(a4.getMapId())) {
            AttackInfo attackInfo = a2;
            if (!a4.getCheatTracker().checkAttack(attackInfo.skill, attackInfo.lastAttackTickCount)) {
                return;
            }
        }
        if ((a4.getStat().combatOrders > 0 || a4.getStat().incAllskill > 0) && a5 != null && SkillFactory.getSkill(a5.getSourceId()).getEffect(a5.getLevel() + a4.getStat().combatOrders + a4.getStat().incAllskill) != null) {
            a5 = SkillFactory.getSkill(a5.getSourceId()).getEffect(a5.getLevel() + a4.getStat().combatOrders + a4.getStat().incAllskill);
        }
        int n2 = DamageParse.getAttackCount(a4, a2.skill, a2);
        AttackInfo attackInfo = a2;
        DamageParse.CheckAttackCount(attackInfo, a4, a5, n2);
        if (attackInfo.hits > 0 && a2.targets > 0 && !a4.getStat().checkEquipDurabilitys(a4, -1)) {
            a4.dropMessage(5, MapleDueyActions.ALLATORIxDEMO("\u0016Xw_#S:\u0016?W$\u0016%C9\u00168C#\u00168PwR\"D6T>Z>B.\u00165C#\u0016?W$\u00169Yw_9@2X#Y%OwD8Y:\u0016#YwQ8\u0016#Yy"));
            return;
        }
        if (SkillConstants.is\u6b66\u9675\u9053\u5834\u6280\u80fd(a2.skill)) {
            if (a4.getMapId() / 10000 != 92502) {
                return;
            }
            a4.mulungEnergyModify(false);
        }
        if (SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(a2.skill)) {
            if (a4.getMapId() / 1000000 != 926) {
                return;
            }
            if (a4.getPyramidSubway() == null || !a4.getPyramidSubway().onSkillUse(a4)) {
                return;
            }
        }
        MapleCharacter mapleCharacter = a4;
        PlayerStats playerStats = mapleCharacter.getStat();
        Element element = mapleCharacter.getBuffedValue(MapleBuffStat.ELEMENT_RESET) != null ? Element.NEUTRAL : a3.getElement();
        double d2 = 0.0;
        int n3 = 0;
        int n4 = 0;
        long l2 = 0L;
        short s2 = playerStats.passive_sharpeye_percent();
        MapleCharacter mapleCharacter2 = a4;
        ISkill iSkill = SkillFactory.getSkill(GameConstants.getMPEaterForJob(mapleCharacter2.getJob()));
        int n5 = mapleCharacter2.getSkillLevel(iSkill);
        MapleMap mapleMap = mapleCharacter2.getMap();
        Object object = a2.allDamage.iterator();
        block6: while (true) {
            MapleStatEffect mapleStatEffect;
            MapleMonster mapleMonster;
            int n6;
            MapleMonster mapleMonster2;
            block65: {
                block64: {
                    int n7;
                    block63: {
                        Object object2 = object;
                        while (true) {
                            Iterator<Pair<Integer, Boolean>> iterator;
                            double d3;
                            int n8;
                            MapleMonsterStats mapleMonsterStats;
                            boolean bl;
                            Object object3;
                            if (object2.hasNext()) {
                                object3 = object.next();
                                mapleMonster2 = mapleMap.getMonsterByOid(((AttackPair)object3).objectid);
                                if (mapleMonster2 == null) continue block6;
                                bl = mapleMonster2.getStatusSourceID(MonsterStatus.FREEZE) == 21120006 && !mapleMonster2.getStats().isBoss();
                                n3 = 0;
                                MapleMonster mapleMonster3 = mapleMonster2;
                                l2 = mapleMonster3.getMobMaxHp();
                                mapleMonsterStats = mapleMonster3.getStats();
                                n8 = mapleMonsterStats.getFixedDamage();
                                d2 = DamageParse.ALLATORIxDEMO(a4, a3, mapleMonster2, mapleMonsterStats, playerStats, element, Integer.valueOf(s2), a6, a5);
                                n6 = 0;
                                if (GameSetConstants.ACCURATE_DMG_STAGE < 100) {
                                    d3 = 100.0 / (double)GameSetConstants.ACCURATE_DMG_STAGE;
                                    d2 = (int)(d2 * d3);
                                }
                                iterator = ((AttackPair)object3).attack.iterator();
                            } else {
                                int n9;
                                block57: {
                                    if (a2.skill != 2301002) {
                                        a5.applyTo(a4);
                                    }
                                    if (ServerConfig.isPvP(a4.getClient().getChannel(), a4.getMapId())) {
                                        try {
                                            MaplePvp.doPvP(a4, mapleMap, a2);
                                            n9 = n4;
                                            break block57;
                                        }
                                        catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                    }
                                    n9 = n4;
                                }
                                if (n9 > 1) {
                                    object = a4.getCheatTracker();
                                    ((CheatTracker)object).setAttacksWithoutHit(true);
                                    if (((CheatTracker)object).getAttacksWithoutHit() > 1000) {
                                        Object object4 = object;
                                        ((CheatTracker)object4).registerOffense(CheatingOffense.ATTACK_WITHOUT_GETTING_HIT, Integer.toString(((CheatTracker)object4).getAttacksWithoutHit()));
                                    }
                                }
                                return;
                            }
                            while (iterator.hasNext()) {
                                int n10;
                                Iterator<Pair<Integer, Boolean>> iterator2;
                                block59: {
                                    block61: {
                                        block62: {
                                            block60: {
                                                block58: {
                                                    object3 = (Integer)iterator2.next().left;
                                                    n6 = (byte)(n6 + 1);
                                                    if (!GameConstants.isElseSkill(a2.skill) && GameSetConstants.CHECK_ALLDAMAGE) {
                                                        if (GameConstants.Novice_Skill(a2.skill)) {
                                                            AttackInfo attackInfo2 = a2;
                                                            int n11 = a4.getSkillLevel(attackInfo2.skill);
                                                            n7 = SkillFactory.getSkill(attackInfo2.skill).getEffect(n11).getFixDamage();
                                                            if ((Integer)object3 > n7) {
                                                                int n12 = n7;
                                                                FileoutputUtil.logToFile(MapOwner.ALLATORIxDEMO("R'Y;\u0011\u0000_+Ug|)Pg\u5089\u5bfb\u754e\u5e70\u0010<F<"), "\r\n " + FileoutputUtil.CurrentReadable_TimeGMT() + " \u73a9\u5bb6<" + a4.getLevel() + ">: " + a4.getName() + " \u602a\u7269 " + mapleMonster2.getId() + " \u5730\u5716: " + a4.getMapId() + " \u6280\u80fd\u4ee3\u78bc: " + a2.skill + " \u6280\u80fd\u7b49\u7d1a " + n11 + " \u6700\u9ad8\u50b7\u5bb3: " + n12 + " \u672c\u6b21\u50b7\u5bb3 :" + (Integer)object3 + " \u9810\u8a08\u50b7\u5bb3: " + n12 + (String)(mapleMonster2.getStats().isBoss() ? " \u662f\u5426\u70baBOSS: " + mapleMonster2.getStats().isBoss() : ""));
                                                                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a4.getName() + " \u56e0\u70ba\u4f7f\u7528\u4e0d\u6cd5\u7a0b\u5f0f\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
                                                                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e\u7cfb\u7d71] " + a4.getName() + " (\u7b49\u7d1a " + a4.getLevel() + ") \u50b7\u5bb3\u7570\u5e38\u3002 \u6700\u9ad8\u50b7\u5bb3 " + n7 + " \u672c\u6b21\u50b7\u5bb3 " + (Integer)object3 + " \u6280\u80fdID " + a2.skill + " \u6280\u80fd\u7b49\u7d1a " + n11));
                                                                MapleCharacter mapleCharacter3 = a4;
                                                                mapleCharacter3.ban(mapleCharacter3.getName() + "\u50b7\u5bb3\u7570\u5e38", true, true, false);
                                                                a4.getClient().getSession().close();
                                                                return;
                                                            }
                                                        }
                                                        long l3 = 999999L;
                                                        if (!GameConstants.isAran(a4.getJob()) && a4.getLevel() > 10) {
                                                            n7 = 0;
                                                            l3 = SkillConstants.getMaxDamage(a4, a2.skill);
                                                            if (GameSetConstants.CHECKDAMAGE_BAN && (long)((Integer)object3).intValue() > l3 && (double)((Integer)object3).intValue() > d2) {
                                                                n7 = 1;
                                                            }
                                                            if ((long)((Integer)object3).intValue() == mapleMonster2.getMobMaxHp()) {
                                                                n7 = 0;
                                                            }
                                                            if (a4.hasGmLevel(1)) {
                                                                n7 = 0;
                                                            }
                                                            if (n7 != 0) {
                                                                MapleCharacter mapleCharacter4;
                                                                Object object5;
                                                                String string = MapleDueyActions.ALLATORIxDEMO("Z8Q$\u0019\u001fW4]xt6Xx\u5081\u5be4\u7546\u5e6f\u0018#N#");
                                                                String string2 = FileoutputUtil.NowTime();
                                                                short s3 = a4.getLevel();
                                                                String string3 = a4.getName();
                                                                int n13 = mapleMonster2.getId();
                                                                int n14 = a4.getMapId();
                                                                int n15 = (int)a6;
                                                                if (mapleMonster2.getStats().isBoss()) {
                                                                    object5 = " \u662f\u5426\u70baBOSS: " + mapleMonster2.getStats().isBoss();
                                                                    mapleCharacter4 = a4;
                                                                } else {
                                                                    object5 = "";
                                                                    mapleCharacter4 = a4;
                                                                }
                                                                FileoutputUtil.logToFile(string, "\r\n " + string2 + " \u73a9\u5bb6<" + s3 + ">: " + string3 + " \u602a\u7269 " + n13 + " \u5730\u5716: " + n14 + " \u6280\u80fd\u4ee3\u78bc: " + a2.skill + " \u6700\u9ad8\u50b7\u5bb3: " + l3 + " \u672c\u6b21\u50b7\u5bb3 :" + (Integer)object3 + " \u9810\u8a08\u50b7\u5bb3: " + n15 + (String)object5 + (String)(DamageParse.ALLATORIxDEMO(mapleCharacter4).isEmpty() ? "" : " BUFF: " + DamageParse.ALLATORIxDEMO(a4)));
                                                                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[\u5c01\u9396\u7cfb\u7d71] " + a4.getName() + " \u56e0\u70ba\u50b7\u5bb3\u7570\u5e38\u800c\u88ab\u7ba1\u7406\u54e1\u6c38\u4e45\u505c\u6b0a\u3002"));
                                                                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e\u7cfb\u7d71] " + a4.getName() + " (\u7b49\u7d1a " + a4.getLevel() + ") \u50b7\u5bb3\u7570\u5e38\u3002 \u6700\u9ad8\u50b7\u5bb3 " + l3 + " \u672c\u6b21\u50b7\u5bb3 " + (Integer)object3 + " \u6280\u80fdID " + a2.skill));
                                                                MapleCharacter mapleCharacter5 = a4;
                                                                mapleCharacter5.ban(mapleCharacter5.getName() + "\u50b7\u5bb3\u7570\u5e38", true, true, false);
                                                                a4.getClient().getSession().close();
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    if (n8 == -1) break block58;
                                                    object3 = mapleMonsterStats.getOnlyNoramlAttack() ? 0 : n8;
                                                    n10 = n3;
                                                    break block59;
                                                }
                                                if (!mapleMonsterStats.getOnlyNoramlAttack()) break block60;
                                                object3 = 0;
                                                n10 = n3;
                                                break block59;
                                            }
                                            if (a4.isGM()) break block61;
                                            if (!bl) break block62;
                                            if ((long)((Integer)object3).intValue() <= mapleMonster2.getMobMaxHp()) break block61;
                                            object3 = (int)Math.min(mapleMonster2.getMobMaxHp(), Integer.MAX_VALUE);
                                            n10 = n3;
                                            a4.getCheatTracker().registerOffense(CheatingOffense.HIGH_DAMAGE_MAGIC);
                                            break block59;
                                        }
                                        if (!(mapleMonster2.isBuffed(MonsterStatus.DAMAGE_IMMUNITY) || mapleMonster2.isBuffed(MonsterStatus.MAGIC_IMMUNITY) || mapleMonster2.isBuffed(MonsterStatus.MAGIC_DAMAGE_REFLECT))) {
                                            if (GameSetConstants.CHECK_ALLDAMAGE && (double)((Integer)object3).intValue() > a6) {
                                                a4.getCheatTracker().registerOffense(CheatingOffense.HIGH_DAMAGE, new StringBuilder().insert(0, MapOwner.ALLATORIxDEMO("\u0013\u5089\u5bfb\u0004h")).append(object3).append(MapleDueyActions.ALLATORIxDEMO("\u001aw\u9826\u6748\fw")).append(a6).append(MapOwner.ALLATORIxDEMO("\u0012h\u6014\u7221\u0004h")).append(mapleMonster2.getId()).append(MapleDueyActions.ALLATORIxDEMO("\n\u0016\f\u8041\u693a\fw")).append(a4.getJob()).append(MapOwner.ALLATORIxDEMO("\u0012h\u7b77\u7d52\u0004h")).append(a4.getLevel()).append(MapleDueyActions.ALLATORIxDEMO("{\u0016\u4f28\u751e\u76d3\u62b6\u80aa\fw")).append(a2.skill).append(MapOwner.ALLATORIxDEMO("\u0015")).toString());
                                                if (a2.real) {
                                                    a4.getCheatTracker().checkSameDamage((Integer)object3, a6);
                                                }
                                                if ((double)((Integer)object3).intValue() > d2 * 2.0) {
                                                    object3 = (int)(d2 * 2.0);
                                                    a4.getCheatTracker().registerOffense(CheatingOffense.HIGH_DAMAGE_MAGIC_2, new StringBuilder().insert(0, MapleDueyActions.ALLATORIxDEMO("\f\u5081\u5be4\fw")).append(object3).append(MapOwner.ALLATORIxDEMO("\u0012h\u982e\u6757\u0004h")).append(a6).append(MapleDueyActions.ALLATORIxDEMO("\u001aw\u601c\u723e\fw")).append(mapleMonster2.getId()).append(MapOwner.ALLATORIxDEMO("\u0015\u001e\u0013\u8049\u6925\u0004h")).append(a4.getJob()).append(MapleDueyActions.ALLATORIxDEMO("\u001aw\u7b7f\u7d4d\fw")).append(a4.getLevel()).append(MapOwner.ALLATORIxDEMO("d\u001e\u4f37\u7516\u76cc\u62be\u80b5\u0004h")).append(a2.skill).append(MapleDueyActions.ALLATORIxDEMO("\n")).toString());
                                                    if ((Integer)object3 >= 10000) {
                                                        if (ServerConfig.LOG_DAMAGE) {
                                                            FileoutputUtil.logToFile(MapOwner.ALLATORIxDEMO("$Q/Mgv)]#\u0011\u50ff\u5b8d\u8a40\u7ba9g\u9b6a\u6c9d\u5089\u5bfb\u8a36\u7bdf\u4fd0\u6b2b\u0010<F<"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6: " + a4.getName() + "(" + a4.getLevel() + ") \u8077\u696d: " + a4.getJob() + " \u602a\u7269:" + mapleMonster2.getId() + " \u5c01\u5305\u50b7\u5bb3 :" + (Integer)object3 + " \u9810\u8a08\u50b7\u5bb3 :" + (int)a6 + (String)(mapleMonster2.getStats().isBoss() ? " \u662f\u5426\u70baBOSS: " + mapleMonster2.getStats().isBoss() : ""), false, false);
                                                        }
                                                        a4.getCheatTracker().registerOffense(CheatingOffense.HIGH_DAMAGE_MAGIC_2, new StringBuilder().insert(0, MapleDueyActions.ALLATORIxDEMO("\f\u5081\u5be4\fw")).append(object3).append(MapOwner.ALLATORIxDEMO("\u0012h\u982e\u6757\u0004h")).append(a6).append(MapleDueyActions.ALLATORIxDEMO("\u001aw\u601c\u723e\fw")).append(mapleMonster2.getId()).append(MapOwner.ALLATORIxDEMO("\u0015\u001e\u0013\u8049\u6925\u0004h")).append(a4.getJob()).append(MapleDueyActions.ALLATORIxDEMO("\u001aw\u7b7f\u7d4d\fw")).append(a4.getLevel()).append(MapOwner.ALLATORIxDEMO("d\u001e\u4f37\u7516\u76cc\u62be\u80b5\u0004h")).append(a2.skill).append(MapleDueyActions.ALLATORIxDEMO("\n")).toString());
                                                        return;
                                                    }
                                                }
                                            }
                                        } else if ((double)((Integer)object3).intValue() > a6) {
                                            Integer n16;
                                            object3 = (int)a6;
                                            if ((double)n16.intValue() > d2 * 2.0 && a6 != 1.0 && ServerConfig.LOG_DAMAGE) {
                                                FileoutputUtil.logToFile(MapOwner.ALLATORIxDEMO("$Q/Mgv)]#\u0011\u50ff\u5b8d\u8a40\u7ba9g\u9b6a\u6c9d\u5089\u5bfb\u8a36\u7bdf\u4fd0\u6b2b\u0010<F<"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6: " + a4.getName() + "(" + a4.getLevel() + ") \u8077\u696d: " + a4.getJob() + " \u602a\u7269:" + mapleMonster2.getId() + " \u5c01\u5305\u50b7\u5bb3 :" + (Integer)object3 + " \u9810\u8a08\u50b7\u5bb3 :" + (int)a6 + (String)(mapleMonster2.getStats().isBoss() ? " \u662f\u5426\u70baBOSS: " + mapleMonster2.getStats().isBoss() : ""), false, false);
                                            }
                                        }
                                    }
                                    n10 = n3;
                                }
                                n3 = n10 + (Integer)object3;
                                iterator = iterator2;
                            }
                            n4 += n3;
                            MapleCharacter mapleCharacter6 = a4;
                            mapleCharacter6.checkMonsterAggro(mapleMonster2);
                            d3 = mapleCharacter6.getPosition().distanceSq(mapleMonster2.getPosition());
                            double d4 = GameConstants.getAttackRange(mapleCharacter6, a5, a2);
                            if (GameSetConstants.ATTACKRANGE_CHECK && !a4.getCheatTracker().\u5730\u5716\u77ac\u79fbing() && !mapleMonster2.isEventMob() && !mapleMonster2.getStats().isBoss()) {
                                if (a4.getDebugMessage() && d3 > d4) {
                                    a4.dropMessage("\u6280\u80fd[" + a2.skill + "] \u9810\u8a08\u7bc4\u570d: " + (int)d4 + " \u5be6\u969b\u7bc4\u570d: " + (int)d3);
                                }
                                if (d3 > d4 && !a4.inBossMap()) {
                                    AttackInfo attackInfo3 = a2;
                                    a4.getCheatTracker().registerOffense(CheatingOffense.ATTACK_FARAWAY_MONSTER, "\u653b\u64ca\u7bc4\u570d\u7570\u5e38,\u6280\u80fd:" + attackInfo3.skill + "(" + SkillFactory.getName(attackInfo3.skill) + ")\u3000\u6b63\u5e38\u7bc4\u570d:" + (int)d4 + " \u8a08\u7b97\u7bc4\u570d:" + (int)d3);
                                    if (d3 > d4 * 2.0) {
                                        AttackInfo attackInfo4 = a2;
                                        a4.getCheatTracker().registerOffense(CheatingOffense.ATTACK_FARAWAY_MONSTER_BAN, "\u8d85\u5927\u653b\u64ca\u7bc4\u570d,\u6280\u80fd:" + attackInfo4.skill + "(" + SkillFactory.getName(attackInfo4.skill) + ")\u3000\u602a\u7269:" + mapleMonster2.getId() + " \u6b63\u5e38\u7bc4\u570d:" + (int)d4 + " \u8a08\u7b97\u7bc4\u570d:" + (int)d3);
                                    }
                                    return;
                                }
                            }
                            if (a2.skill == 2301002 && !mapleMonsterStats.getUndead()) {
                                a4.getCheatTracker().registerOffense(CheatingOffense.\u7fa4\u9ad4\u6cbb\u7652\u653b\u64ca\u4e0d\u6b7b\u7cfb\u602a\u7269, "\r\n " + FileoutputUtil.CurrentReadable_TimeGMT() + " \u73a9\u5bb6<" + a4.getLevel() + ">: " + a4.getName() + " \u602a\u7269 " + mapleMonster2.getId() + " \u5730\u5716: " + a4.getMapId() + " \u6280\u80fd\u4ee3\u78bc: " + a2.skill + " \u4f7f\u7528\u7fa4\u9ad4\u6cbb\u7652\u653b\u64ca\u975e\u4e0d\u6b7b\u7cfb\u602a\u7269");
                                return;
                            }
                            if ((long)n3 > 0L || a2.skill == 27101101) break;
                            object2 = object;
                        }
                        MapleMonster mapleMonster4 = mapleMonster2;
                        a4.handleJobAttack(mapleMonster4, a2);
                        n3 = (int)a4.handleSkillDamage(mapleMonster4, a2, n3);
                        if (!mapleMonster2.getStats().isBoss()) break block63;
                        if (a4.getPotential2() <= 0L) break block64;
                        n7 = (int)((double)n3 * 1.0E-4 * (double)a4.getPotential2());
                        n3 += n7;
                        a4.dropMessagePotential("\u984d\u5916\u6f5b\u80fdBOSS\u50b7\u5bb3 " + n7 + " !");
                        mapleMonster = mapleMonster2;
                        break block65;
                    }
                    if (a4.getPotential1() > 0L) {
                        n7 = (int)((double)n3 * 1.0E-4 * (double)a4.getPotential1());
                        n3 += n7;
                        a4.dropMessagePotential("\u984d\u5916\u6f5b\u80fd\u4e00\u822c\u50b7\u5bb3 " + n7 + " !");
                    }
                }
                mapleMonster = mapleMonster2;
            }
            mapleMonster.damage(a4, (long)n3, true, a2.skill);
            if (mapleMonster2.isBuffed(MonsterStatus.MAGIC_DAMAGE_REFLECT)) {
                a4.addHP(-(7000 + Randomizer.nextInt(8000)));
            }
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                MapleCharacter mapleCharacter7 = a4;
                MapleMonster mapleMonster5 = mapleMonster2;
                AttackInfo attackInfo5 = a2;
                mapleCharacter7.onAttack(mapleMonster5, mapleMonster2.getMobMaxHp(), mapleMonster5.getMobMaxMp(), attackInfo5, attackInfo5.skill, mapleMonster2.getObjectId(), n4);
                mapleCharacter7.handleApplyStatus(mapleMonster2, a2.skill, a5.getAttackCount());
            }
            switch (a2.skill) {
                case 2221003: {
                    ISkill iSkill2 = a3;
                    mapleMonster2.setTempEffectiveness(Element.FIRE, iSkill2.getEffect(a4.getSkillLevel(iSkill2)).getDuration());
                    mapleStatEffect = a5;
                    break;
                }
                case 2121003: {
                    ISkill iSkill3 = a3;
                    mapleMonster2.setTempEffectiveness(Element.ICE, iSkill3.getEffect(a4.getSkillLevel(iSkill3)).getDuration());
                }
                default: {
                    mapleStatEffect = a5;
                }
            }
            if (mapleStatEffect.getMonsterStati().size() >= 0 && a5.makeChanceResult()) {
                for (Map.Entry<MonsterStatus, Integer> entry : a5.getMonsterStati().entrySet()) {
                    n6 = 1;
                    if (GameSetConstants.SERVER_NAME.equals(MapleDueyActions.ALLATORIxDEMO("\u6b8c\u549c\u8c60")) && a3.getId() == 12111005 && (mapleMonster2.getLevel() - a4.getLevel() > 25 || a4.getLevel() - mapleMonster2.getLevel() > 25)) {
                        n6 = 0;
                    }
                    if (n6 == 0) continue;
                    mapleMonster2.applyStatus(a4, new MonsterStatusEffect(entry.getKey(), entry.getValue(), a3.getId(), null, false), a5.isPoison(), a5.getDuration(), mapleMonster2.getStats().isBoss(), a5);
                }
            }
            if (n5 > 0) {
                iSkill.getEffect(n5).applyPassive(a4, mapleMonster2);
            }
            if (!JobConstants.is\u591c\u5149(a4.getJob())) continue;
            MapleCharacter mapleCharacter8 = a4;
            mapleCharacter8.handleLuminous(a2.skill);
            mapleCharacter8.handleDarkCrescendo();
            mapleCharacter8.handleBlackBless();
        }
    }

    public static final /* synthetic */ AttackInfo DivideAttack(AttackInfo a2, int a3) {
        a2.real = false;
        if (a3 <= 1) {
            return a2;
        }
        for (AttackPair attackPair : a2.allDamage) {
            if (attackPair.attack == null) continue;
            Iterator<Pair<Integer, Boolean>> iterator = attackPair.attack.iterator();
            while (iterator.hasNext()) {
                Iterator<Pair<Integer, Boolean>> iterator2;
                Integer.valueOf((Integer)iterator2.next().left / a3);
                iterator2.next().left = iterator2.next().left;
                iterator = iterator2;
            }
        }
        return a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static /* synthetic */ double ALLATORIxDEMO(MapleCharacter a, MapleStatEffect a, AttackInfo a) {
        v0 = a;
        v1 = a;
        var5_3 = (double)v0.getStat().getCurrentMaxBaseDamage() * (double)v1.getBuffedDamage(MapleBuffStat.MATK) * 0.01 * (double)a.getBuffedDamage(MapleBuffStat.WATK) * 0.01;
        var3_4 = v1.getStat().passive_sharpeye_percent();
        var4_6 = v0.getStat().passive_sharpeye_rate();
        var7_7 = (double)var3_4 * 0.01;
        var9_8 = 1.0;
        var11_9 = 1.0;
        var3_5 = v0.getBuffedValue(MapleBuffStat.COMBO);
        var13_10 = GameSetConstants.MAX_DAMAGE;
        var14_11 = SkillFactory.getSkill(1320006);
        if (v0.getJob() == 132 && a.getSkillLevel(var14_11) > 0) {
            v2 = var14_11;
            var5_3 *= (var9_8 += (double)v2.getEffect(a.getSkillLevel(v2)).getDamage() * 0.01);
        }
        if (a != null) {
            var11_9 = (double)a.getDamage() * 0.01;
        }
        if (!a.hasBuffedValue(MapleBuffStat.SHARP_EYES)) ** GOTO lbl25
        var15_12 = a.getBuffedSkill_Y(MapleBuffStat.SHARP_EYES);
        if (GameSetConstants.MAPLE_VERSION >= 134) ** GOTO lbl25
        if (a.getJob() == 300 || a.getJob() >= 310 && a.getJob() <= 312 || a.getJob() >= 320 && a.getJob() <= 322 || a.getJob() >= 1300 && a.getJob() <= 1312 || a.getJob() == 400 || a.getJob() >= 410 && a.getJob() <= 412 || a.getJob() >= 420 && a.getJob() <= 422 || a.getJob() >= 1400 && a.getJob() <= 1412) {
            var7_7 = var7_7 - ((double)var15_12.intValue() * 0.01 - 1.0) + ((double)var15_12.intValue() * 0.01 + 0.2);
            v3 = a;
        } else {
            var11_9 *= (double)var15_12.intValue() * 0.01;
lbl25:
            // 3 sources

            v3 = a;
        }
        if (v3.hasBuffedValue(MapleBuffStat.WK_CHARGE) && ((var15_12 = a.getStatForBuff(MapleBuffStat.WK_CHARGE)).getSourceId() == 1211006 || var15_12.getSourceId() == 1211003 || var15_12.getSourceId() == 1211004 || var15_12.getSourceId() == 1211005 || var15_12.getSourceId() == 1211007 || var15_12.getSourceId() == 1211008 || var15_12.getSourceId() == 1221003 || var15_12.getSourceId() == 1221004 || var15_12.getSourceId() == 11111007 || var15_12.getSourceId() == 15101006 || var15_12.getSourceId() == 21111005)) {
            var11_9 *= (double)(var15_12.getMatk() + 12) * 0.01 + 1.0;
        }
        if (var3_5 != null) {
            if (a.getJob() == 1110 || a.getJob() == 1111 || a.getJob() == 1112) {
                var15_12 = SkillFactory.getSkill(11111001);
                v4 = a;
            } else {
                var15_12 = SkillFactory.getSkill(1111002);
                v4 = a;
            }
            if (v4.getSkillLevel((ISkill)var15_12) > 0) {
                v5 = var15_12;
                var16_13 = 1.0 + ((double)v5.getEffect(a.getSkillLevel((ISkill)v5)).getDamage() / 100.0 - 1.0) * (double)(var3_5 - 1);
                v6 = var15_12;
                var11_9 *= 1.0 + ((double)v6.getEffect(a.getSkillLevel((ISkill)v6)).getDamage() / 100.0 - 1.0) * (double)(var3_5 - 1);
            }
        }
        if (a.skill == 4001344 || a.skill == 14001004 || a.skill == 4111005 || a.skill == 14111002 || a.skill == 4121007 || a.skill == 14111005) {
            var11_9 *= 1.4;
            v7 = a;
        } else if (a.skill == 4221001) {
            var11_9 = (var11_9 * 0.5 + var11_9) * 6.0;
            v7 = a;
        } else {
            if (a.skill == 3101005) {
                v8 = var15_12 = SkillFactory.getSkill(3101005);
                var11_9 *= (double)v8.getEffect(a.getSkillLevel((ISkill)v8)).getX() / 100.0;
            }
            v7 = a;
        }
        if (v7.hasBuffedValue(MapleBuffStat.DARKSIGHT)) {
            var11_9 = var11_9 * 0.5 + var11_9;
        }
        if (a.hasBuffedValue(MapleBuffStat.COMBO)) {
            var5_3 *= var11_9;
            v9 = a;
        } else if (a == null) {
            if (var7_7 != 0.0) {
                var5_3 *= var7_7;
                v9 = a;
            } else {
                v9 = a;
            }
        } else if (var4_6 == 0) {
            var5_3 *= var11_9;
            v9 = a;
        } else if (a.getJob() == 300 || a.getJob() >= 310 && a.getJob() <= 312 || a.getJob() >= 320 && a.getJob() <= 322 || a.getJob() >= 1300 && a.getJob() <= 1312 || a.getJob() == 400 || a.getJob() >= 410 && a.getJob() <= 412 || a.getJob() >= 420 && a.getJob() <= 422 || a.getJob() >= 1400 && a.getJob() <= 1412) {
            if (a.skill == 14101006) {
                var5_3 *= var11_9 + var7_7 - 1.0;
                v9 = a;
            } else {
                var5_3 *= var11_9 * var7_7;
                v9 = a;
            }
        } else {
            var5_3 *= var11_9 + var7_7;
            v9 = a;
        }
        if (v9.skill == 3221007 || PlayerHandler.isFinisher(a.skill) > 0) {
            var5_3 = var13_10.longValue();
        }
        if (a.getAttackDebugMessage() == false) return var5_3;
        v10 = a;
        v10.dropMessage(6, "[CheckRealMaxDamage]\u6700\u9ad8\u653b\u64ca\u529b :" + (int)v10.getStat().getCurrentMaxBaseDamage() + " \u8a08\u7b97\u5f8c\u9810\u6e2c\u50b7\u5bb3: " + (int)var5_3);
        a.dropMessage(6, "\u7206\u64ca\u50b7\u5bb3\u653b\u64ca\u52a0\u6210: " + var7_7 * 100.0 + "% \u7206\u64ca\u6a5f\u7387: " + var4_6 + "%");
        a.dropMessage(6, "\u4e3b\u52d5\u6280\u80fd\u653b\u64ca\u52a0\u6210: " + (String)(a != null ? var11_9 * 100.0 + "%" : MapOwner.ALLATORIxDEMO("\u7169")));
        v11 = a;
        v11.dropMessage(6, "\u9b54\u6cd5\u653b\u64ca\u88ab\u52d5\u52a0\u6210: " + v11.getBuffedDamage(MapleBuffStat.MATK) + "%");
        v12 = a;
        v12.dropMessage(6, "\u7269\u7406\u653b\u64ca\u88ab\u52d5\u52a0\u6210: " + v12.getBuffedDamage(MapleBuffStat.WATK) + "%");
        v13 = a;
        v13.dropMessage(6, "\u9ed1\u6697\u529b\u91cf\u653b\u64ca\u52a0\u6210: " + (String)(v13.getSkillLevel(var14_11) > 0 ? var9_8 * 100.0 + "%" : MapleDueyActions.ALLATORIxDEMO("\u7176")));
        v14 = a;
        v14.dropMessage(6, "\u6280\u80fd\u9b25\u6c23\u653b\u64ca\u52a0\u6210: " + (String)(v14.hasBuffedValue(MapleBuffStat.COMBO) != false ? a.getBuffedDamage(MapleBuffStat.COMBO) + "%" : MapOwner.ALLATORIxDEMO("\u7169")));
        return var5_3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ double ALLATORIxDEMO(MapleCharacter a2, ISkill a3, MapleMonster a4, MapleMonsterStats a5, PlayerStats a6, Element a72, Integer a8, double a9, MapleStatEffect a10) {
        MapleCharacter mapleCharacter;
        double d2;
        double d3;
        MapleMonsterStats mapleMonsterStats = a5;
        int n2 = Math.max(mapleMonsterStats.getLevel() - a2.getLevel(), 0);
        int n3 = (int)(Math.floor((double)a6.getTotalInt() / 10.0) + Math.floor((double)a6.getTotalLuk() / 10.0));
        int n4 = mapleMonsterStats.getEva() * (n2 * 2 + 51) / 120;
        long l2 = GameSetConstants.MAX_DAMAGE;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            int n5;
            n2 = Math.max(a5.getLevel() - a2.getLevel(), 0) * 2;
            if (n2 > (n5 = Math.min((int)Math.floor(Math.sqrt(a6.getAccuracy())) - (int)Math.floor(Math.sqrt(a5.getEva())) + 100, 100))) {
                n5 = n2;
            }
            if ((n5 -= n2) <= 0) {
                if (!JobConstants.isBeginnerJob(a3.getId() / 10000)) return 0.0;
                if (a3.getId() % 10000 != 1000) {
                    return 0.0;
                }
            }
        } else if (n4 > n3 && a3.getId() != 1000 && a3.getId() != 10001000 && a3.getId() != 20001000 && a3.getId() != 20011000 && a3.getId() != 30001000 && !SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(a3.getId())) {
            return 0.0;
        }
        switch (1.d[a4.getEffectiveness(a72).ordinal()]) {
            case 1: {
                d3 = 1.0;
                break;
            }
            case 2: {
                d3 = DamageParse.ALLATORIxDEMO(a72, a9, a6);
                break;
            }
            case 3: {
                d3 = DamageParse.ALLATORIxDEMO(a72, a9 * 1.5, a6);
                break;
            }
            case 4: {
                d3 = DamageParse.ALLATORIxDEMO(a72, a9 * 0.5, a6);
                break;
            }
            default: {
                throw new RuntimeException(MapOwner.ALLATORIxDEMO("\u001dP#P'I&\u001e-P=Sh]'P;J)P<"));
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleMonster mapleMonster = a4;
            int a72 = mapleMonster.getStats().getMDRate();
            MonsterStatusEffect monsterStatusEffect = mapleMonster.getBuff(MonsterStatus.MDEF);
            if (monsterStatusEffect != null) {
                a72 += monsterStatusEffect.getX().intValue();
            }
            double d4 = d3;
            d2 = d3 = d4 - d4 * (double)Math.max(a72 - a6.ignoreTargetDEF - a10.getIgnoreMob(), 0) / 100.0;
        } else {
            d2 = d3 = d3 - (double)a5.getMagicDefense() * 0.5;
        }
        d3 = d2 + d3 / 100.0 * (double)a8.intValue();
        if (a3.getId() == 21120006) {
            d3 *= 15.0;
        }
        if (a3.getId() == 2211006) {
            d3 *= 2.0;
        }
        double d5 = d3;
        PlayerStats playerStats = a6;
        d3 = d5 + d5 * (a5.isBoss() ? playerStats.bossdam_r : playerStats.dam_r) / 100.0;
        switch (a3.getId()) {
            case 1000: 
            case 10001000: 
            case 20001000: {
                d3 = 40.0;
                mapleCharacter = a2;
                break;
            }
            case 1020: 
            case 10001020: 
            case 20001020: {
                d3 = 1.0;
            }
            default: {
                mapleCharacter = a2;
            }
        }
        if (mapleCharacter.getAttackDebugMessage()) {
            MapleCharacter mapleCharacter2 = a2;
            mapleCharacter2.dropMessage("[\u50b7\u5bb3\u8a08\u7b97]\u5c6c\u6027\u50b7\u5bb3\uff1a" + (int)Math.ceil(d3) + " BOSS\u50b7\u5bb3\uff1a" + (int)Math.ceil((a4.getStats().isBoss() ? mapleCharacter2.getStat().bossdam_r : mapleCharacter2.getStat().dam_r) - 100.0) + "%");
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            d3 *= 2.0;
        }
        if (a4.isBuffed(MonsterStatus.DAMAGE_IMMUNITY) || a4.isBuffed(MonsterStatus.MAGIC_IMMUNITY) || a4.isBuffed(MonsterStatus.MAGIC_DAMAGE_REFLECT)) {
            d3 = 1.0;
        }
        if (d3 > (double)l2) {
            return l2;
        }
        if (!(d3 < 0.0)) return d3;
        return 1.0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ AttackInfo parseDmg(LittleEndianAccessor a2, DamageType a3, MapleCharacter a4) {
        AttackInfo attackInfo = new AttackInfo();
        int n2 = -1;
        String string = a2.toString();
        try {
            int n3;
            int n4;
            int n5;
            if (a2.available() == 7L) {
                attackInfo.skill = a2.readInt();
                return null;
            }
            a2.skip(1);
            if (GameSetConstants.MAPLE_VERSION >= 113 && GameSetConstants.MAPLE_VERSION < 139) {
                a2.skip(8);
            }
            AttackInfo attackInfo2 = attackInfo;
            attackInfo2.tbyte = a2.readByte();
            attackInfo2.targets = (byte)(attackInfo2.tbyte >>> 4 & 0xF);
            attackInfo2.hits = (byte)(attackInfo2.tbyte & 0xF);
            if (GameSetConstants.MAPLE_VERSION >= 113 && GameSetConstants.MAPLE_VERSION < 139) {
                a2.skip(8);
            }
            n2 = attackInfo.skill = a2.readInt();
            if (attackInfo.skill >= 91000000) {
                return null;
            }
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                LittleEndianAccessor littleEndianAccessor;
                n5 = 12;
                if (GameSetConstants.MAPLE_VERSION > 139) {
                    n5 = 5;
                    littleEndianAccessor = a2;
                } else {
                    if (GameSetConstants.MAPLE_VERSION > 134) {
                        n5 = 13;
                    }
                    littleEndianAccessor = a2;
                }
                littleEndianAccessor.skip(n5);
                if (GameSetConstants.MAPLE_VERSION >= 134 && a3 == DamageType.RANGED_ATTACK) {
                    a2.skip(1);
                }
            }
            AttackInfo attackInfo3 = attackInfo;
            attackInfo3.charge = SkillConstants.isChargeSkill(attackInfo.skill) ? a2.readInt() : -1;
            if (GameSetConstants.MAPLE_VERSION >= 152) {
                a2.skip(1);
            }
            attackInfo.direction = GameSetConstants.MAPLE_VERSION >= 113 ? a2.readByte() : (byte)0;
            attackInfo.display = a2.readByte();
            attackInfo.animation = a2.readByte();
            if (attackInfo.animation != 0 && attackInfo.animation != 1 && attackInfo.animation != -127 && attackInfo.animation != -128) {
                FileoutputUtil.logToFile("logs/Animation/\u7570\u5e38\u653b\u64ca\u5c01\u5305/" + attackInfo.skill + ".txt", attackInfo.animation + "\r\n");
                return null;
            }
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                a2.skip(4);
            }
            a2.skip(1);
            if (GameSetConstants.MAPLE_VERSION >= 145) {
                if (attackInfo.skill == 23111001) {
                    a2.readInt();
                    a2.readInt();
                    a2.readInt();
                }
                if ((attackInfo.skill == 5300007 || attackInfo.skill == 0x4DD5D4 || attackInfo.skill == 5081001 || attackInfo.skill == 15101010) && GameSetConstants.MAPLE_VERSION > 147) {
                    a2.readInt();
                }
                if (attackInfo.skill == 24121005) {
                    a2.readInt();
                }
            }
            AttackInfo attackInfo4 = attackInfo;
            attackInfo4.speed = a2.readByte();
            attackInfo4.lastAttackTickCount = a2.readInt();
            n5 = 0;
            switch (attackInfo.skill) {
                case 4211006: 
                case 24121005: 
                case 61111113: {
                    n5 = 1;
                    break;
                }
            }
            if (GameSetConstants.MAPLE_VERSION > 113) {
                if (GameSetConstants.MAPLE_VERSION >= 148 && n5 != 0) {
                    a2.skip(4);
                }
                if (GameSetConstants.MAPLE_VERSION >= 151) {
                    switch (attackInfo.skill) {
                        case 32121003: {
                            a2.skip(8);
                            break;
                        }
                    }
                }
                if ((n4 = a2.readInt()) != 0 && a4.getMap().getMapObject(n4, MapleMapObjectType.MIST) == null && (attackInfo.speed < 0 || attackInfo.speed > 10)) {
                    if (a4.isStaff()) {
                        MapleCharacter mapleCharacter = a4;
                        AttackInfo attackInfo5 = attackInfo;
                        mapleCharacter.dropMessage("\u672a\u8655\u7406\u6280\u80fd\u50b7\u5bb3 -  " + a4.getName() + " Lv." + a4.getLevel() + " \u8077\u696d: " + mapleCharacter.getJob() + " \u6280\u80fd:" + SkillFactory.getSkillName(attackInfo.skill) + "(" + attackInfo5.skill + ") speed:" + attackInfo5.speed + " - " + n4);
                    }
                    AttackInfo attackInfo6 = attackInfo;
                    FileoutputUtil.logToFile(MapleDueyActions.ALLATORIxDEMO("Z8Q$\u0019'W4]2BxR2U8R2\u0018#N#"), FileoutputUtil.CurrentReadable_Time() + " " + a4.getName() + " Lv." + a4.getLevel() + " \u8077\u696d: " + a4.getJob() + " \u6280\u80fd:" + SkillFactory.getSkillName(attackInfo.skill) + "(" + attackInfo6.skill + ") speed:" + attackInfo6.speed + " - " + n4 + " \r\n");
                }
            }
            if (a3 == DamageType.RANGED_ATTACK) {
                AttackInfo attackInfo7 = attackInfo;
                LittleEndianAccessor littleEndianAccessor = a2;
                attackInfo.slot = (byte)littleEndianAccessor.readShort();
                attackInfo7.csstar = (byte)littleEndianAccessor.readShort();
                attackInfo7.AOE = a2.readByte();
            }
            n4 = GameSetConstants.MAPLE_VERSION >= 148 && SkillConstants.is\u7279\u6b8a\u89e3\u5305\u6280\u80fd(attackInfo.skill) ? 1 : 0;
            attackInfo.allDamage = new ArrayList<AttackPair>();
            if (attackInfo.skill == 4211006) {
                return DamageParse.parseExplosionAttack(a2, attackInfo);
            }
            int n6 = n3 = 0;
            while (true) {
                int n7;
                int n8;
                ArrayList<Pair<Integer, Boolean>> arrayList;
                int n9;
                int n10;
                if (n6 < attackInfo.targets) {
                    if (GameSetConstants.MAPLE_VERSION >= 148) {
                        if (n3 == 0 && a3 == DamageType.CLOSE_RANGE_ATTACK && n4 == 0) {
                            a2.readInt();
                        }
                        if (SkillConstants.is\u7d42\u6975\u653b\u64ca(attackInfo.skill)) {
                            switch (attackInfo.skill) {
                                case 21120005: 
                                case 21120009: 
                                case 21120010: 
                                case 22150004: 
                                case 24100003: 
                                case 32121002: {
                                    break;
                                }
                                default: {
                                    a2.skip(1);
                                }
                            }
                        }
                    }
                    LittleEndianAccessor littleEndianAccessor = a2;
                    n10 = littleEndianAccessor.readInt();
                    littleEndianAccessor.skip(4);
                    n9 = littleEndianAccessor.readInt();
                    littleEndianAccessor.skip(6);
                    if (GameSetConstants.MAPLE_VERSION >= 148) {
                        a2.skip(4);
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 152) {
                        a2.skip(1);
                    }
                    arrayList = new ArrayList<Pair<Integer, Boolean>>();
                    n7 = n8 = 0;
                } else {
                    attackInfo.position = a2.readPos();
                    if (attackInfo.skill == 24121052) {
                        n3 = a2.readShort();
                        a4.clearSkillPosition();
                        int n11 = n8 = 0;
                        while (n11 < n3) {
                            LittleEndianAccessor littleEndianAccessor = a2;
                            n9 = littleEndianAccessor.readShort();
                            short s2 = littleEndianAccessor.readShort();
                            a4.addSkillPosition(new Point(n9, s2));
                            n11 = ++n8;
                        }
                    }
                    if (a2.available() == 4L) {
                        attackInfo.skillposition = a2.readPos();
                    }
                    switch (attackInfo.skill) {
                        case 5221007: 
                        case 5221008: 
                        case 33101002: 
                        case 33101007: 
                        case 33111002: 
                        case 33111006: 
                        case 33121002: 
                        case 33121005: 
                        case 35001003: 
                        case 35101003: 
                        case 35101009: 
                        case 35101010: 
                        case 35111015: {
                            if (a4.getBuffedValue(MapleBuffStat.MONSTER_RIDING) != null) return attackInfo;
                            return null;
                        }
                        case 35111004: 
                        case 35121005: 
                        case 35121012: 
                        case 35121013: {
                            if (a4.getBuffedValue(MapleBuffStat.MECH_CHANGE) != null) return attackInfo;
                            return null;
                        }
                        case 5121004: 
                        case 5121005: {
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == null) return null;
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1001) return attackInfo;
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1101) return attackInfo;
                            return null;
                        }
                        case 5111006: {
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == null) return null;
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1000) return attackInfo;
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1100) return attackInfo;
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1001) return attackInfo;
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1101) return attackInfo;
                            return null;
                        }
                        case 13111006: 
                        case 13111007: {
                            if (a4.getBuffedValue(MapleBuffStat.MORPH) != null) {
                                if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1003) return attackInfo;
                                if (a4.getBuffedValue(MapleBuffStat.MORPH) == 1103) return attackInfo;
                            }
                            if (GameSetConstants.SERVER_NAME.equals(MapOwner.ALLATORIxDEMO("\u6b93\u5494\u8c7f"))) return attackInfo;
                            return null;
                        }
                        case 5111002: 
                        case 5111004: 
                        case 5121002: {
                            if (a4.getBuffedValue(MapleBuffStat.ENERGY_CHARGE) == null) return null;
                            if (a4.getBuffedValue(MapleBuffStat.ENERGY_CHARGE) >= 10000) return attackInfo;
                            return null;
                        }
                    }
                    return attackInfo;
                }
                while (n7 < attackInfo.hits) {
                    int n12 = WeatherHandler.getWeather() == WeatherType.\u9b54\u96f2\u74b0\u7e5e ? a2.readInt() / 2 : a2.readInt();
                    arrayList.add(new Pair<Integer, Boolean>(n12, false));
                    n7 = ++n8;
                }
                if (GameSetConstants.MAPLE_VERSION >= 113) {
                    a2.skip(4);
                }
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    a2.skip(4);
                }
                if (a3 != DamageType.PASSIVE_ENERGY && GameSetConstants.MAPLE_VERSION >= 152) {
                    a2.skip(4);
                }
                attackInfo.allDamage.add(new AttackPair(n10, arrayList));
                n6 = ++n3;
            }
        }
        catch (Exception exception) {
            FileoutputUtil.logToFile(MapleDueyActions.ALLATORIxDEMO("Z8Q$\u0019\u0007W4]2BxR2U8R2\u0018#N#"), "\r\n " + FileoutputUtil.NowTime() + "\u6280\u80fd:" + n2 + " \u7570\u5e38:" + exception.toString() + " packet:" + string);
        }
        return attackInfo;
    }

    public static final /* synthetic */ AttackInfo parseExplosionAttack(LittleEndianAccessor a2, AttackInfo a3) {
        int n2;
        int n3;
        if (a3.hits == 0) {
            int n4;
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(4);
            int n5 = littleEndianAccessor.readByte();
            int n6 = n4 = 0;
            while (n6 < n5) {
                a3.allDamage.add(new AttackPair(a2.readInt(), null));
                a2.skip(1);
                n6 = ++n4;
            }
            a2.skip(2);
            return a3;
        }
        int n7 = n3 = 0;
        while (n7 < a3.targets) {
            int n8;
            LittleEndianAccessor littleEndianAccessor = a2;
            n2 = littleEndianAccessor.readInt();
            littleEndianAccessor.skip(12);
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                a2.skip(4);
            }
            int n9 = a2.readByte();
            ArrayList<Pair<Integer, Boolean>> arrayList = new ArrayList<Pair<Integer, Boolean>>();
            int n10 = n8 = 0;
            while (n10 < n9) {
                arrayList.add(new Pair<Integer, Boolean>(a2.readInt(), false));
                n10 = ++n8;
            }
            a3.allDamage.add(new AttackPair(n2, arrayList));
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                a2.skip(4);
            }
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                a2.skip(4);
            }
            n7 = ++n3;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(4);
        n3 = littleEndianAccessor.readByte();
        int n11 = n2 = 0;
        while (n11 < n3) {
            a3.allDamage.add(new AttackPair(a2.readInt(), null));
            a2.skip(GameSetConstants.MAPLE_VERSION >= 134 ? 2 : 1);
            n11 = ++n2;
        }
        if (GameSetConstants.MAPLE_VERSION < 134) {
            a2.skip(2);
        }
        return a3;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void applyAttack(AttackInfo a, ISkill a, MapleCharacter a, int a, double a, MapleStatEffect a, AttackType a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[UNCONDITIONALDOLOOP]], but top level block is 0[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static final /* synthetic */ AttackInfo Modify_AttackCrit(AttackInfo a2, MapleCharacter a3, int a4222) {
        boolean bl;
        byte by = ((MapleCharacter)((Object)a3)).getStat().passive_sharpeye_rate();
        Long l2 = GameSetConstants.MAX_DAMAGE;
        boolean bl2 = bl = a4222 == 2 && ((MapleCharacter)((Object)a3)).getBuffedValue(MapleBuffStat.SHADOWPARTNER) != null || a4222 == 1 && ((MapleCharacter)((Object)a3)).getBuffedValue(MapleBuffStat.MIRROR_IMAGE) != null;
        if (a2 != null && a2.skill != 4211006 && a2.skill != 3211003 && a2.skill != 4111004 && (by > 0 || a2.skill == 4221001 || a2.skill == 3221007) && a2.allDamage != null) {
            for (AttackPair a4222 : a2.allDamage) {
                if (a4222.attack == null) continue;
                int n2 = 0;
                int n3 = a4222.attack.size() / 2;
                AttackPair attackPair = a4222;
                ArrayList<Pair<Integer, Boolean>> a4222 = new ArrayList<Pair<Integer, Boolean>>(attackPair.attack);
                Iterator<Pair<Integer, Boolean>> iterator = attackPair.attack.iterator();
                while (iterator.hasNext()) {
                    ArrayList<Pair<Integer, Boolean>> arrayList;
                    ++n2;
                    Pair<Integer, Boolean> pair = iterator.next();
                    if (((Boolean)pair.right).booleanValue()) continue;
                    if (a2.skill == 4221001) {
                        pair.right = n2 == 4 && Randomizer.nextInt(100) < 90;
                        arrayList = a4222;
                    } else if (a2.skill == 3221007 || (long)((Integer)pair.left).intValue() > l2) {
                        pair.right = true;
                        arrayList = a4222;
                    } else if (bl && n2 > n3) {
                        pair.right = ((Pair)a4222.get((int)(n2 - 1 - n3))).right;
                        arrayList = a4222;
                    } else {
                        pair.right = Randomizer.nextInt(100) < by;
                        arrayList = a4222;
                    }
                    ((Pair)arrayList.get((int)(n2 - 1))).right = pair.right;
                }
            }
        }
        return a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void CheckAttackCount(AttackInfo a, MapleCharacter a, MapleStatEffect a, int a) {
        if (GameSetConstants.COUNT_CHECK == false) return;
        switch (a.skill) {
            case 31001007: {
                a = 2;
                v0 = a;
                break;
            }
            case 31001008: {
                a = 3;
                v0 = a;
                break;
            }
            case 24111008: {
                a = 3;
                v0 = a;
                break;
            }
            case 27001100: 
            case 27001201: 
            case 27101100: 
            case 27101101: 
            case 27101202: 
            case 27111100: 
            case 27111101: 
            case 27111202: 
            case 27111303: 
            case 27120211: 
            case 27121100: 
            case 27121201: 
            case 27121202: 
            case 27121303: {
                a *= 2;
                v0 = a;
                break;
            }
            case 65111007: 
            case 65111100: {
                a = 8;
                v0 = a;
                break;
            }
            case 61001004: 
            case 61001005: {
                a = 5;
                v0 = a;
                break;
            }
            case 61110009: {
                a = 2;
                v0 = a;
                break;
            }
            case 22181002: {
                a = 4;
                v0 = a;
                break;
            }
            case 21120005: 
            case 21120006: 
            case 61001000: 
            case 61121100: 
            case 61121201: {
                ++a;
                v0 = a;
                break;
            }
            case 61110212: {
                a += 2;
            }
            default: {
                v0 = a;
            }
        }
        if (SkillConstants.AttackCountCheck(v0.skill) && a.hits > a) {
            v1 = a;
            if (!a.hasGmLevel(1)) {
                v1.getCheatTracker().registerOffense(CheatingOffense.\u6280\u80fd\u653b\u64ca\u6b21\u6578\u7570\u5e38, "\u73a9\u5bb6: " + a.getName() + "(" + a.getLevel() + ") \u5730\u5716: " + a.getMapId() + " \u6280\u80fd\u4ee3\u78bc: " + a.skill + " \u6280\u80fd\u7b49\u7d1a: " + a.getSkillLevel(a.skill) + " \u653b\u64ca\u6b21\u6578 : " + a.hits + " \u6b63\u5e38\u653b\u64ca\u6b21\u6578 :" + a);
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e\u7cfb\u7d71] " + a.getName() + " (\u7b49\u7d1a " + a.getLevel() + ") \u653b\u64ca\u6b21\u6578\u7570\u5e38\u5df2\u7d93\u7d00\u9304\u3002 \u73a9\u5bb6\u653b\u64ca\u6b21\u6578 " + a.hits + " \u6b63\u78ba\u6b21\u6578 " + a + " \u6280\u80fdID " + a.skill));
                FileoutputUtil.logToFile(MapleDueyActions.ALLATORIxDEMO("Z8Q$\u0019\u001fW4]x\u62b6\u80aa\u650d\u649d\u6b17\u652f\u0018#N#"), "\r\n" + FileoutputUtil.NowTime() + "\u73a9\u5bb6: " + a.getName() + "(" + a.getLevel() + ") \u5730\u5716: " + a.getMapId() + " \u6280\u80fd\u4ee3\u78bc: " + a.skill + " \u6280\u80fd\u7b49\u7d1a: " + a.getSkillLevel(a.skill) + " \u653b\u64ca\u6b21\u6578 : " + a.hits + " \u6b63\u5e38\u653b\u64ca\u6b21\u6578 :" + a);
                return;
            }
            v1.dropMessage("\u653b\u64ca\u6b21\u6578\u7570\u5e38\u653b\u64ca\u6b21\u6578 " + a.hits + " \u670d\u52d9\u7aef\u5224\u65b7\u6b63\u5e38\u653b\u64ca\u6b21\u6578 " + a + " \u6280\u80fdID " + a.skill);
            v2 = a;
        } else {
            v2 = a;
        }
        a = DamageParse.getAttackTarget(v2, a.skill, a);
        if (GameSetConstants.MAPLE_VERSION < 152) ** GOTO lbl-1000
        switch (a.skill) {
            case 5710012: 
            case 32121003: {
                a = 2;
                v3 = a;
                break;
            }
            case 1301008: 
            case 4341004: 
            case 61001000: 
            case 61121100: 
            case 61121201: {
                ++a;
                v3 = a;
                break;
            }
            case 24121000: 
            case 27121202: 
            case 27121303: 
            case 61111111: {
                a *= 2;
            }
            case 24121005: {
                a += 2;
            }
            default: lbl-1000:
            // 2 sources

            {
                v3 = a;
            }
        }
        a = SkillConstants.handleSpecialAttackMobCount(v3.skill, a);
        if (SkillConstants.AttackCountCheck(a.skill) == false) return;
        if (a.targets <= a) return;
        v4 = a;
        if (a.hasGmLevel(1)) {
            v5 = a;
            v4.dropMessage("\u6253\u602a\u6578\u91cf\u7570\u5e38,\u6280\u80fd\u4ee3\u78bc: " + v5.skill + " \u5c01\u5305\u602a\u7269\u91cf : " + v5.targets + " \u670d\u52d9\u7aef\u602a\u7269\u91cf :" + a);
            return;
        }
        v4.getCheatTracker().registerOffense(CheatingOffense.\u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38, " \u73a9\u5bb6: " + a.getName() + "(" + a.getLevel() + ") \u5730\u5716: " + a.getMapId() + "\u6280\u80fd\u4ee3\u78bc: " + a.skill + " \u6280\u80fd\u7b49\u7d1a: " + a.getSkillLevel(a.getSourceId()) + " \u5c01\u5305\u602a\u7269\u91cf : " + a.targets + " \u670d\u52d9\u7aef\u602a\u7269\u91cf :" + a);
        FileoutputUtil.logToFile(MapOwner.ALLATORIxDEMO("R'Y;\u0011\u0000_+Ug\u626d\u6062\u6546\u9187\u754e\u5e70\u0010<F<"), "\r\n " + FileoutputUtil.NowTime() + " \u73a9\u5bb6: " + a.getName() + "(" + a.getLevel() + ") \u5730\u5716: " + a.getMapId() + "\u6280\u80fd\u4ee3\u78bc: " + a.skill + " \u6280\u80fd\u7b49\u7d1a: " + a.getSkillLevel(a.getSourceId()) + " \u5c01\u5305\u602a\u7269\u91cf : " + a.targets + " \u670d\u52d9\u7aef\u602a\u7269\u91cf :" + a);
        World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM \u5bc6\u8a9e\u7cfb\u7d71] " + a.getName() + " (\u7b49\u7d1a " + a.getLevel() + ") \u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38\u3002 \u5c01\u5305\u602a\u7269\u91cf " + a.targets + " \u670d\u52d9\u7aef\u602a\u7269\u91cf " + a.getMobCount() + " \u6280\u80fdID " + a.skill));
    }

    public /* synthetic */ DamageParse() {
        DamageParse a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static /* synthetic */ double ALLATORIxDEMO(MapleCharacter a, MapleMonster a, AttackInfo a, ISkill a, MapleStatEffect a, double a, Integer a) {
        block48: {
            block47: {
                block46: {
                    var8_13 = Math.max(a.getStats().getLevel() - a.getLevel(), 0) * 2;
                    var9_15 = GameSetConstants.MAX_DAMAGE;
                    var10_16 = Math.min((int)Math.floor(Math.sqrt(a.getStat().getAccuracy())) - (int)Math.floor(Math.sqrt(a.getStats().getEva())) + 100, 100);
                    if (var8_13 > var10_16) {
                        var10_16 = var8_13;
                    }
                    if (!((var10_16 -= var8_13) > 0 || JobConstants.isBeginnerJob(a.skill / 10000) && a.skill % 10000 == 1000 || SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(a.skill) || SkillConstants.is\u6b66\u9675\u9053\u5834\u6280\u80fd(a.skill) || SkillConstants.isInflationSkill(a.skill))) {
                        return 0.0;
                    }
                    if (a.getMapId() / 1000000 == 914) return 999999.0;
                    if (a.getMapId() / 1000000 == 927) {
                        return 999999.0;
                    }
                    var8_14 = new ArrayList<Element>();
                    var10_16 = 0;
                    a = a;
                    var11_17 = a.getStats().getPDRate();
                    var12_18 = a.getBuff(MonsterStatus.WDEF);
                    if (var12_18 != null) {
                        var11_17 += var12_18.getX().intValue();
                    }
                    if (a /* !! */  == null) break block46;
                    v0 = a /* !! */ ;
                    var8_14.add(v0.getElement());
                    if (!JobConstants.isBeginnerJob(v0.getId() / 10000)) ** GOTO lbl-1000
                    switch (a /* !! */ .getId() % 10000) {
                        case 1000: {
                            a = 40.0;
                            var10_16 = 1;
                            v1 = a /* !! */ ;
                            break;
                        }
                        case 1020: {
                            a = 1.0;
                            var10_16 = 1;
                            v1 = a /* !! */ ;
                            break;
                        }
                        case 1009: {
                            v2 = a;
                            a = a.getStats().isBoss() != false ? v2.getMobMaxHp() / 30L * 100L : v2.getMobMaxHp();
                            var10_16 = 1;
                        }
                        default: lbl-1000:
                        // 2 sources

                        {
                            v1 = a /* !! */ ;
                        }
                    }
                    switch (v1.getId()) {
                        case 1311005: {
                            var11_17 = a.getStats().isBoss() != false ? var11_17 : 0;
                            v3 = a;
                            break block47;
                        }
                        case 3221001: 
                        case 33101001: {
                            var10_16 = 1;
                            v3 = a *= (double)a.getMobCount();
                            break block47;
                        }
                        case 3101005: {
                            var10_16 = 1;
                            v3 = a;
                            break block47;
                        }
                        case 32001000: 
                        case 32101000: 
                        case 32111002: 
                        case 32121002: {
                            v3 = a = a * 1.5;
                            break block47;
                        }
                        case 1221009: 
                        case 1321012: 
                        case 3221007: 
                        case 4331003: 
                        case 23121003: {
                            if (a.getStats().isBoss()) break;
                            a = a.getMobMaxHp();
                            var10_16 = 1;
                            v3 = a;
                            break block47;
                        }
                        case 1221011: 
                        case 21120006: {
                            a = a.getStats().isBoss() != false ? var9_15 : a.getHp() - 1L;
                            var10_16 = 1;
                            v3 = a;
                            break block47;
                        }
                        case 3211006: {
                            if (a.getStatusSourceID(MonsterStatus.FREEZE) != 3211003) break;
                            var10_16 = 1;
                            a = var9_15.longValue();
                        }
                    }
                }
                v3 = var13_19 = a;
            }
            if (a.getJob() == 311 || a.getJob() == 312 || a.getJob() == 321 || a.getJob() == 322) {
                a = SkillFactory.getSkill(a.getJob() == 311 || a.getJob() == 312 ? 3110001 : 3210001);
                if (a.getTotalSkillLevel(a) > 0) {
                    v4 = a;
                    var15_20 = v4.getEffect(a.getTotalSkillLevel(v4));
                    if (var15_20 != null && a.getHPPercent() < var15_20.getX()) {
                        var13_19 = var9_15.longValue();
                        var10_16 = 1;
                        if (var15_20.getZ() > 0) {
                            v5 = a;
                            v5.addHP(v5.getStat().getMaxHp() * var15_20.getZ() / 100);
                        }
                    }
                }
            } else if ((a.getJob() == 221 || a.getJob() == 222) && a.getTotalSkillLevel(a = SkillFactory.getSkill(2210000)) > 0) {
                v6 = a;
                var15_20 = v6.getEffect(a.getTotalSkillLevel(v6));
                if (var15_20 != null && a.getHPPercent() < var15_20.getX()) {
                    var13_19 = 999999.0;
                    var10_16 = 1;
                }
            }
            if (var10_16 != 0 && (a /* !! */  == null || a /* !! */ .getId() != 33101001 && a /* !! */ .getId() != 3221001)) break block48;
            if (a.getBuffedValue(MapleBuffStat.WK_CHARGE) == null) ** GOTO lbl-1000
            a = a.getBuffSource(MapleBuffStat.WK_CHARGE);
            switch (a) {
                case 1211003: 
                case 1211004: {
                    var8_14.add(Element.FIRE);
                    v7 = a;
                    break;
                }
                case 1211005: 
                case 1211006: 
                case 21111005: {
                    var8_14.add(Element.ICE);
                    v7 = a;
                    break;
                }
                case 1211007: 
                case 1211008: 
                case 15101006: {
                    var8_14.add(Element.LIGHTING);
                    v7 = a;
                    break;
                }
                case 1221003: 
                case 1221004: 
                case 11111007: {
                    var8_14.add(Element.HOLY);
                }
                default: lbl-1000:
                // 2 sources

                {
                    v7 = a;
                }
            }
            if (v7.getBuffedValue(MapleBuffStat.LIGHTNING_CHARGE) != null) {
                var8_14.add(Element.LIGHTING);
            }
            if (a.getBuffedValue(MapleBuffStat.ELEMENT_RESET) != null) {
                var8_14.clear();
            }
            if (var8_14.size() > 0) {
                a = 0.0;
                switch (a.skill) {
                    case 3111003: 
                    case 3211003: {
                        a = (double)a.getX() / 100.0;
                        v8 = var8_14;
                        break;
                    }
                    default: {
                        a = 0.5 / (double)var8_14.size();
                        v8 = var8_14;
                    }
                }
                a = v8.iterator();
                block28: while (true) {
                    v9 = a;
                    block29: while (v9.hasNext()) {
                        a /* !! */  = (Element)a.next();
                        switch (1.d[a.getEffectiveness((Element)a /* !! */ ).ordinal()]) {
                            case 1: {
                                var13_19 = 1.0;
                                v9 = a;
                                continue block29;
                            }
                            case 3: {
                                var13_19 *= 1.0 + a + (double)a.getStat().getElementBoost((Element)a /* !! */ );
                                v9 = a;
                                continue block29;
                            }
                            case 4: {
                                var13_19 *= 1.0 - a - (double)a.getStat().getElementBoost((Element)a /* !! */ );
                                v9 = a;
                                continue block29;
                            }
                        }
                        continue block28;
                    }
                    break;
                }
            }
            v10 = var13_19;
            var13_19 = v10 - v10 * ((double)Math.max(var11_17 - Math.max(a.getStat().ignoreTargetDEF, 0) - Math.max(a == null ? 0 : a.getIgnoreMob(), 0), 0) / 100.0);
            var13_19 += var13_19 / 100.0 * (double)a;
            a = a.getBuff(MonsterStatus.IMPRINT);
            if (a != null) {
                v11 = var13_19;
                var13_19 = v11 + v11 * (double)a.getX().intValue() / 100.0;
            }
            v12 = var13_19;
            var13_19 = v12 + v12 * (double)a.getDamageIncrease(a.getObjectId()) / 100.0;
            var13_19 *= (a.getStats().isBoss() != false && a != null ? a.getStat().bossdam_r + (double)a.getBossDamage() : a.getStat().dam_r) / 100.0;
        }
        if (var13_19 > (double)var9_15.longValue()) {
            if (var10_16 != 0) return var13_19;
            return var9_15.longValue();
        }
        if (!(var13_19 <= 0.0)) return var13_19;
        return 1.0;
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleStatEffect a32, int a4, AttackInfo a5) {
        boolean bl;
        a4 = a32 == null ? (a5.skill == 0 ? 16 : 1) : a32.getMobCount();
        a4 = a32 == null ? 0 : a32.getMpCon();
        MapleCharacter mapleCharacter = a2;
        int a32 = mapleCharacter.getStat().getMp();
        boolean bl2 = bl = mapleCharacter.isSkillWorking(2121004) || a2.isSkillWorking(2221004) || a2.isSkillWorking(2321004);
        if (a4 > 0 && a32 < a4 && !bl && a5.skill != 2301002 && a5.skill != 21101003 && a5.skill != 2321008 && a5.skill != 2221007 && a5.skill != 2121007) {
            MapleCharacter mapleCharacter2 = a2;
            if (a2.hasGmLevel(1)) {
                mapleCharacter2.dropMessage(6, "MP\u91cf\u7570\u5e38,\u6280\u80fd\u4ee3\u78bc: " + a5.skill + " \u9700\u8981MP\u91cf : " + a4 + "  \u76ee\u524dMP\u91cf :" + a32);
                return;
            }
            mapleCharacter2.getCheatTracker().registerOffense(CheatingOffense.\u7121MP\u4f7f\u7528\u6280\u80fd, " \u73a9\u5bb6: " + a2.getName() + "(" + a2.getLevel() + ") \u5730\u5716: " + a2.getMapId() + "\u6280\u80fd\u4ee3\u78bc: " + a5.skill + " \u6280\u80fd\u7b49\u7d1a: " + a2.getSkillLevel(a5.skill) + " \u9700\u8981MP\u91cf : " + a4 + "  \u76ee\u524dMP\u91cf :" + a32);
            return;
        }
        if (a4 > 0 && a32 < a4 && (a5.skill == 21101003 || a5.skill == 2301002 || a5.skill == 2321008 || a5.skill == 2221007 || a5.skill == 2121007)) {
            return;
        }
    }

    private static /* synthetic */ String ALLATORIxDEMO(MapleCharacter a2) {
        Object object = "";
        if (a2 != null) {
            MapleCharacter mapleCharacter = a2;
            int n2 = mapleCharacter.getBuffSource(MapleBuffStat.WATK);
            int n3 = mapleCharacter.getBuffSource(MapleBuffStat.MATK);
            int n4 = mapleCharacter.getBuffSource(MapleBuffStat.MAPLE_WARRIOR);
            int n5 = mapleCharacter.getBuffSource(MapleBuffStat.SHARP_EYES);
            if (n2 != -1) {
                object = (String)object + n2;
            }
            if (n3 != -1) {
                object = (String)object + ", " + n3;
            }
            if (n4 != -1) {
                object = (String)object + ", " + n4;
            }
            if (n5 != -1) {
                object = (String)object + ", " + n5;
            }
        }
        return object;
    }

    private static /* synthetic */ int ALLATORIxDEMO(MapleCharacter a2, AttackInfo a3, MapleMonster a4, int a5, int a6) {
        double d2;
        double d3;
        int n2 = a5;
        if (!GameSetConstants.ACCURATE_DMG_TO_MOB || a3.skill == 4211006 || MapleJob.is\u5f71\u6b66\u8005(a2.getJob())) {
            return a5;
        }
        if (MapleJob.is\u72c2\u72fc\u52c7\u58eb(a2.getJob())) {
            a6 = (int)((double)a6 * 1.5);
        }
        if (GameSetConstants.ACCURATE_DMG_STAGE < 100) {
            d3 = 100.0 / (double)GameSetConstants.ACCURATE_DMG_STAGE;
            a6 = (int)((double)a6 * d3);
        }
        if (a5 > a6) {
            n2 = a6;
        }
        d3 = (double)a5 / (double)a6;
        if (d2 > 1.5 && ServerConfig.LOG_DAMAGE) {
            MapleCharacter mapleCharacter;
            Object object;
            String string = "logs/Hack/\u50b7\u5bb3\u7570\u5e38_\u7cbe\u5bc6\u8a08\u7b97/" + SkillFactory.getName(a3.skill) + ".txt";
            String string2 = FileoutputUtil.NowTime();
            short s2 = a2.getLevel();
            String string3 = a2.getName();
            int n3 = a4.getId();
            int n4 = a2.getMapId();
            int n5 = a6;
            int n6 = a5;
            int n7 = n5 - n6;
            if (a4.getStats().isBoss()) {
                object = " \u662f\u5426\u70baBOSS: " + a4.getStats().isBoss();
                mapleCharacter = a2;
            } else {
                object = "";
                mapleCharacter = a2;
            }
            FileoutputUtil.logToFile(string, "\r\n " + string2 + " \u73a9\u5bb6<\u7b49\u7d1a:" + s2 + ">: " + string3 + " \u602a\u7269 " + n3 + " \u5730\u5716: " + n4 + " \u6280\u80fd\u4ee3\u78bc: " + a3.skill + " \u672c\u6b21\u50b7\u5bb3 :" + n6 + " \u9810\u8a08\u6700\u9ad8\u50b7\u5bb3: " + n5 + "\u8d85\u51fa\u50b7\u5bb3:" + n7 + (String)object + (String)(DamageParse.ALLATORIxDEMO(mapleCharacter).isEmpty() ? "" : " BUFF: " + DamageParse.ALLATORIxDEMO(a2)));
        }
        return n2;
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleMonster a3, AttackPair a4) {
        int n2 = GameSetConstants.MAPLE_VERSION >= 134 ? a2.getBuffedValue(MapleBuffStat.PICKPOCKET) : a2.getBuffedValue(MapleBuffStat.PICKPOCKET);
        Object object = SkillFactory.getSkill(4211003);
        ISkill iSkill = object;
        object = iSkill.getEffect(a2.getSkillLevel(iSkill));
        for (Pair<Integer, Boolean> serializable : ((AttackPair)a4).attack) {
            int n3;
            boolean bl = new Random().nextBoolean();
            Integer n32 = (Integer)serializable.left;
            if (!bl || !((MapleStatEffect)object).makeChanceResult() || a2.getStat().pickRate < 100 && Randomizer.nextInt(99) >= a2.getStat().pickRate) continue;
            int n4 = Math.min((int)Math.max((double)n32.intValue() / 20000.0 * (double)n2, 1.0), n2);
            if (MapleJob.is\u5e7b\u5f71\u4fe0\u76dc(a2.getJob())) {
                n3 = n4 / 10;
            }
            a2.getMap().spawnMesoDrop(n3, new Point((int)(a3.getTruePosition().getX() + (double)Randomizer.nextInt(100) - 50.0), (int)a3.getTruePosition().getY()), a3, a2, 0 != 0, (byte)0);
        }
    }

    public static final class DamageType
    extends Enum<DamageType> {
        public static final /* synthetic */ /* enum */ DamageType RANGED_ATTACK;
        public static final /* synthetic */ /* enum */ DamageType PASSIVE_ENERGY;
        private static final /* synthetic */ DamageType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ DamageType MAGIC_ATTACK;
        public static final /* synthetic */ /* enum */ DamageType CLOSE_RANGE_ATTACK;

        public static /* synthetic */ DamageType[] values() {
            return (DamageType[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ DamageType valueOf(String a2) {
            return Enum.valueOf(DamageType.class, a2);
        }

        public static /* synthetic */ {
            CLOSE_RANGE_ATTACK = new DamageType(MapleCharacterCards.ALLATORIxDEMO("\u0017@\u001b_\u0011S\u0006M\u001aK\u0011S\u0015X\u0000M\u0017G"), 0);
            RANGED_ATTACK = new DamageType(MonsterGlobalDropEntry.ALLATORIxDEMO("<{ }+~1{:n/y%"), 1);
            MAGIC_ATTACK = new DamageType(MapleCharacterCards.ALLATORIxDEMO("\u0019M\u0013E\u0017S\u0015X\u0000M\u0017G"), 2);
            PASSIVE_ENERGY = new DamageType(MonsterGlobalDropEntry.ALLATORIxDEMO("j/i=s8\u007f1\u007f \u007f<}7"), 3);
            DamageType[] arrdamageType = new DamageType[4];
            arrdamageType[0] = CLOSE_RANGE_ATTACK;
            arrdamageType[1] = RANGED_ATTACK;
            arrdamageType[2] = MAGIC_ATTACK;
            arrdamageType[3] = PASSIVE_ENERGY;
            ALLATORIxDEMO = arrdamageType;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ DamageType() {
            void var2_-1;
            void var1_-1;
            DamageType a2;
        }
    }
}

