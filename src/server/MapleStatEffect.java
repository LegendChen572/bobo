/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.ISkill;
import client.MapleCharacter;
import client.MapleCoolDownValueHolder;
import client.MapleStat;
import client.MapleTrait;
import client.PlayerStats;
import client.SkillEntry;
import client.SkillFactory;
import client.inventory.IItem;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.SkillConstants;
import handling.channel.ChannelServer;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.SummonMovementType;
import handling.world.MaplePartyCharacter;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataTool;
import provider.WzXML.MapleDataType;
import server.MapleCarnivalFactory;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.buffs.BuffClassFetcher;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MobSkill;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleDoor;
import server.maps.MapleExtractor;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleMist;
import server.maps.MapleSummon;
import server.maps.MechDoor;
import tools.CaltechEval;
import tools.ConcurrentEnumMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.Triple;
import tools.packet.JobPacket;

public class MapleStatEffect
implements Serializable {
    public /* synthetic */ int y;
    public /* synthetic */ byte MDF;
    public /* synthetic */ int price;
    public /* synthetic */ List<Pair<MapleBuffStat, Integer>> statups;
    private /* synthetic */ ArrayList<Pair<Integer, Integer>> d;
    private /* synthetic */ List<Integer> K;
    public /* synthetic */ int ematk;
    public /* synthetic */ double mmp_temp;
    public /* synthetic */ short mddR;
    public /* synthetic */ byte recipeValidDay;
    public /* synthetic */ Point rb;
    public /* synthetic */ int u;
    public /* synthetic */ short thaw;
    public /* synthetic */ Map<MonsterStatus, Integer> monsterStatus;
    public /* synthetic */ int mmpX;
    public /* synthetic */ int fatigue;
    public /* synthetic */ int ewdef;
    public /* synthetic */ short ignoreMob;
    public /* synthetic */ int indieMhp;
    private /* synthetic */ Map<MapleTrait.MapleTraitType, Integer> B;
    public /* synthetic */ int nuffSkill;
    public /* synthetic */ short dot;
    public /* synthetic */ int mddX;
    public /* synthetic */ short dex;
    public /* synthetic */ int subProp;
    public /* synthetic */ int ItemSkillLevel;
    public /* synthetic */ int berserk;
    public /* synthetic */ int fixdamage;
    public /* synthetic */ double mhp_temp;
    public /* synthetic */ byte iceGageCon;
    public /* synthetic */ int moneyCon;
    public /* synthetic */ int sourceid;
    public /* synthetic */ byte type;
    public /* synthetic */ int itemup;
    public /* synthetic */ short hpCon;
    public /* synthetic */ short madX;
    public /* synthetic */ int indieMad;
    public /* synthetic */ int accX;
    public /* synthetic */ short intX;
    public /* synthetic */ int berserk2;
    public /* synthetic */ int emdef;
    public /* synthetic */ int bulletConsume;
    public /* synthetic */ byte reqSkillLevel;
    public /* synthetic */ int coolTimeR;
    public /* synthetic */ int psdJump;
    public /* synthetic */ int ewatk;
    public /* synthetic */ int indieAllStat;
    public /* synthetic */ int indieJump;
    public /* synthetic */ short fatigueChange;
    public /* synthetic */ int mdR;
    public /* synthetic */ int indieBooster;
    public /* synthetic */ int t;
    public /* synthetic */ boolean overTime;
    public /* synthetic */ short matk;
    private /* synthetic */ List<Integer> a;
    public /* synthetic */ int indieDEX;
    public /* synthetic */ int itemCon;
    public /* synthetic */ int indieSpeed;
    public /* synthetic */ boolean clear;
    public /* synthetic */ int interval;
    public /* synthetic */ int v;
    public /* synthetic */ int mhpX;
    public /* synthetic */ int s;
    private /* synthetic */ List<MapleBuffStat> g;
    public /* synthetic */ int kp;
    public /* synthetic */ short mobSkill;
    public /* synthetic */ int indieDamR;
    public /* synthetic */ short mpCon;
    public /* synthetic */ short hands;
    public /* synthetic */ int expinc;
    public /* synthetic */ short dotTime;
    public /* synthetic */ int z;
    public /* synthetic */ short inflation;
    public /* synthetic */ short mdef;
    public /* synthetic */ int indieMhpR;
    public /* synthetic */ short jump;
    public /* synthetic */ short pddR;
    public /* synthetic */ short mpConReduce;
    public /* synthetic */ byte mobCount;
    public /* synthetic */ double mpR;
    public /* synthetic */ int indieLUK;
    public /* synthetic */ int duration;
    public /* synthetic */ int extendPrice;
    public /* synthetic */ short strX;
    public /* synthetic */ int moveTo;
    public /* synthetic */ short criticaldamageMax;
    public /* synthetic */ int itemCode;
    public /* synthetic */ int incPVPdamage;
    public /* synthetic */ int cosmetic;
    public /* synthetic */ int pddX;
    public /* synthetic */ int totalprob;
    public /* synthetic */ int targetPlus;
    private /* synthetic */ List<Integer> k;
    public /* synthetic */ boolean partyBuff;
    public /* synthetic */ int mesoup;
    public /* synthetic */ short lukX;
    public /* synthetic */ int soulmpCon;
    public /* synthetic */ Point lt;
    public /* synthetic */ byte effectedOnAlly;
    public /* synthetic */ int consumeOnPickup;
    public /* synthetic */ byte attackCount;
    public /* synthetic */ int range;
    public /* synthetic */ int ItemSkill;
    public /* synthetic */ short watk;
    public /* synthetic */ byte mmpR;
    public /* synthetic */ short criticaldamageMin;
    public /* synthetic */ byte familiarTarget;
    public /* synthetic */ short lifeId;
    public /* synthetic */ int indieEva;
    public /* synthetic */ int prob;
    public /* synthetic */ int cr;
    public /* synthetic */ short hp;
    public /* synthetic */ int itemConNo;
    public /* synthetic */ short useLevel;
    public /* synthetic */ int prop;
    public /* synthetic */ int ehp;
    public /* synthetic */ byte expR;
    public /* synthetic */ short speed;
    public /* synthetic */ boolean skill;
    public /* synthetic */ int indieMdd;
    public /* synthetic */ short mesoR;
    public /* synthetic */ int itemRange;
    private /* synthetic */ List<Triple<Integer, Integer, Integer>> ALLATORIxDEMO;
    public /* synthetic */ int booster;
    public /* synthetic */ int illusion;
    public /* synthetic */ int onActive;
    public /* synthetic */ short mobSkillLevel;
    public /* synthetic */ byte level;
    public /* synthetic */ int indieAcc;
    public /* synthetic */ int expBuff_add;
    public /* synthetic */ short acc;
    public /* synthetic */ int exp;
    public /* synthetic */ int expBuff;
    public /* synthetic */ int plusExpRate;
    public /* synthetic */ int rewardMeso;
    public /* synthetic */ short wdef;
    public /* synthetic */ int ignoreMobDamR;
    public /* synthetic */ int psdSpeed;
    public /* synthetic */ byte mastery;
    public /* synthetic */ byte slotCount;
    public /* synthetic */ short dexX;
    public /* synthetic */ int indieSTR;
    public /* synthetic */ byte mhpR;
    public /* synthetic */ short avoid;
    public /* synthetic */ byte period;
    public /* synthetic */ short mp;
    public /* synthetic */ byte recipeUseCount;
    public /* synthetic */ short selfDestruction;
    public /* synthetic */ short str;
    public /* synthetic */ int indieMmpR;
    public /* synthetic */ int emp;
    private static final /* synthetic */ long E = 9179541993413738569L;
    public /* synthetic */ short terR;
    public /* synthetic */ int cp;
    public /* synthetic */ byte immortal;
    public /* synthetic */ int charColor;
    public /* synthetic */ short imhp;
    public /* synthetic */ short er;
    public /* synthetic */ int ignoreMobpdpR;
    public /* synthetic */ byte bs;
    public /* synthetic */ int morph;
    public /* synthetic */ int w;
    public /* synthetic */ int recipe;
    public /* synthetic */ int indieMmp;
    public /* synthetic */ byte bulletCount;
    public /* synthetic */ short padX;
    public /* synthetic */ int damAbsorbShieldR;
    public /* synthetic */ int indieINT;
    public /* synthetic */ short damage;
    public /* synthetic */ byte reqGuildLevel;
    public /* synthetic */ byte effectedOnEnemy;
    public /* synthetic */ int cashup;
    public /* synthetic */ int cooldown;
    public /* synthetic */ short asrR;
    public /* synthetic */ double hpR;
    public /* synthetic */ short int_;
    public /* synthetic */ short PVPdamage;
    public /* synthetic */ byte preventslip;
    public /* synthetic */ short bdR;
    public /* synthetic */ int indiePad;
    public /* synthetic */ short damR;
    public /* synthetic */ short forceCon;
    public /* synthetic */ short immp;
    public /* synthetic */ int indiePdd;
    public /* synthetic */ short luk;
    public /* synthetic */ int subTime;
    public /* synthetic */ int x;

    public final /* synthetic */ int getSourceId() {
        MapleStatEffect a2;
        return a2.sourceid;
    }

    public final /* synthetic */ boolean isMonsterRiding() {
        MapleStatEffect a2;
        return a2.skill && (a2.isMonsterRiding_() || GameConstants.getMountItem(a2.sourceid, null) != 0);
    }

    public final /* synthetic */ boolean isSoaring() {
        MapleStatEffect a2;
        return a2.isSoaring_Normal() || a2.isSoaring_Mount();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean applyTo(MapleCharacter a2, MapleCharacter a3, boolean a4, Point a5, int a6, boolean a7222222, boolean a8, boolean a92222) {
        MapleStatEffect mapleStatEffect;
        MapleStatEffect a10;
        block149: {
            block146: {
                Object a7222222;
                block147: {
                    MapleCharacter mapleCharacter;
                    Point point;
                    block148: {
                        block145: {
                            SummonMovementType summonMovementType;
                            MapleStatEffect mapleStatEffect2;
                            block129: {
                                block123: {
                                    block143: {
                                        block144: {
                                            block142: {
                                                Iterator<MapleCharacter> a7222222;
                                                Object n10;
                                                block141: {
                                                    block140: {
                                                        boolean bl;
                                                        block122: {
                                                            Object object;
                                                            int n2;
                                                            int iItem;
                                                            block139: {
                                                                block138: {
                                                                    block137: {
                                                                        block136: {
                                                                            block135: {
                                                                                block134: {
                                                                                    MapleCharacter mapleCharacter2;
                                                                                    block133: {
                                                                                        MapleStatEffect mapleStatEffect3;
                                                                                        block132: {
                                                                                            block131: {
                                                                                                block130: {
                                                                                                    block128: {
                                                                                                        MapleStatEffect mapleStatEffect4;
                                                                                                        block127: {
                                                                                                            block126: {
                                                                                                                block125: {
                                                                                                                    if (a10.isHeal() && (a2.getMapId() == 749040100 || a3.getMapId() == 749040100 || a3.getMap().isClickGameMap())) {
                                                                                                                        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    if (a10.isSoaring_Mount() && a2.getBuffedValue(MapleBuffStat.MONSTER_RIDING) == null || a10.isSoaring_Normal() && !a2.getMap().canSoar()) {
                                                                                                                        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    if (a10.sourceid == 4341006 && a2.getBuffedValue(MapleBuffStat.SHADOWPARTNER) == null && a2.getBuffedValue(MapleBuffStat.MIRROR_IMAGE) == null) {
                                                                                                                        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    if (!(a10.sourceid != 33101008 || a2.getBuffedValue(MapleBuffStat.RAINING_MINES) != null && a2.getBuffedValue(MapleBuffStat.SUMMON) == null && a2.canSummon())) {
                                                                                                                        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    if (a7222222 == 0 && a10.isShadow() && a2.getJob() / 100 % 10 != 4 && !a3.isGM()) {
                                                                                                                        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    if (a10.sourceid == 33101004 && a2.getMap().isTown()) {
                                                                                                                        MapleCharacter mapleCharacter3 = a2;
                                                                                                                        mapleCharacter3.dropMessage(5, ConcurrentEnumMap.ALLATORIxDEMO("\u4f0e\u7178\u6cbb\u5771\u673f\u83d3\u888f\u4f26\u7546\u6b3d\u62ee\u80a4\u306c"));
                                                                                                                        mapleCharacter3.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    MapleStatEffect mapleStatEffect5 = a10;
                                                                                                                    MapleCharacter mapleCharacter4 = a2;
                                                                                                                    iItem = mapleStatEffect5.H(mapleCharacter4, a3, a4);
                                                                                                                    n2 = mapleStatEffect5.ALLATORIxDEMO(mapleCharacter4, a3, a4);
                                                                                                                    object = a3.getStat();
                                                                                                                    if (!a4) break block125;
                                                                                                                    if (a10.itemConNo == 0 || a3.isClone() || a3.inPVP() || a7222222 != 0) break block126;
                                                                                                                    MapleStatEffect mapleStatEffect6 = a10;
                                                                                                                    if (!a3.haveItem(mapleStatEffect6.itemCon, mapleStatEffect6.itemConNo, false, true)) {
                                                                                                                        a3.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    MapleStatEffect mapleStatEffect7 = a10;
                                                                                                                    MapleInventoryManipulator.removeById(a3.getClient(), GameConstants.getInventoryType(a10.itemCon), mapleStatEffect7.itemCon, mapleStatEffect7.itemConNo, false, true);
                                                                                                                    mapleStatEffect4 = a10;
                                                                                                                    break block127;
                                                                                                                }
                                                                                                                if (!a4 && a10.isResurrection()) {
                                                                                                                    iItem = ((PlayerStats)object).getMaxHp();
                                                                                                                    a3.setStance(0);
                                                                                                                }
                                                                                                            }
                                                                                                            mapleStatEffect4 = a10;
                                                                                                        }
                                                                                                        if (mapleStatEffect4.l() && a10.makeChanceResult()) {
                                                                                                            a3.dispelDebuffs();
                                                                                                        } else if (a10.H()) {
                                                                                                            a3.cancelDeiseaseBuff(MapleBuffStat.SEDUCE);
                                                                                                        } else if (a10.g != null && a10.g.size() > 0) {
                                                                                                            Iterator<MapleBuffStat> iterator = a7222222 = a10.g.iterator();
                                                                                                            while (iterator.hasNext()) {
                                                                                                                n10 = a7222222.next();
                                                                                                                iterator = a7222222;
                                                                                                                a2.cancelDeiseaseBuff((MapleBuffStat)n10);
                                                                                                            }
                                                                                                        } else if (a10.isMPRecovery()) {
                                                                                                            PlayerStats playerStats = object;
                                                                                                            a7222222 = playerStats.getMaxHp() / 100 * 10;
                                                                                                            if (playerStats.getHp() > a7222222) {
                                                                                                                iItem += -a7222222;
                                                                                                                n2 += a7222222 / 100 * a10.getY();
                                                                                                            } else {
                                                                                                                iItem = ((PlayerStats)object).getHp() == 1 ? 0 : ((PlayerStats)object).getHp() - 1;
                                                                                                            }
                                                                                                        }
                                                                                                        a7222222 = new ArrayList<Pair<MapleStat, Integer>>(2);
                                                                                                        if (iItem != 0) {
                                                                                                            if (((PlayerStats)object).getHp() + iItem < 0) {
                                                                                                                iItem = -((PlayerStats)object).getHp();
                                                                                                            }
                                                                                                            if (iItem < 0 && -iItem > ((PlayerStats)object).getHp() && !a3.hasDisease(MapleBuffStat.ZOMBIFY)) {
                                                                                                                a3.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                return false;
                                                                                                            }
                                                                                                            PlayerStats playerStats = object;
                                                                                                            playerStats.setHp(playerStats.getHp() + iItem);
                                                                                                        }
                                                                                                        if (a2.getBuffedValue(MapleBuffStat.INFINITY) != null) {
                                                                                                            n2 = 0;
                                                                                                        }
                                                                                                        if (n2 != 0) {
                                                                                                            if (((PlayerStats)object).getMp() + n2 < 0) {
                                                                                                                n2 = -((PlayerStats)object).getMp();
                                                                                                            }
                                                                                                            if (((PlayerStats)object).getMp() + n2 < 0) {
                                                                                                                return false;
                                                                                                            }
                                                                                                            if (n2 < 0 && -n2 > ((PlayerStats)object).getMp()) {
                                                                                                                a3.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                                return false;
                                                                                                            }
                                                                                                            if (n2 < 0 && JobConstants.isDemon(a3.getJob()) || !JobConstants.isDemon(a3.getJob())) {
                                                                                                                PlayerStats playerStats = object;
                                                                                                                playerStats.setMp(playerStats.getMp() + n2);
                                                                                                            }
                                                                                                            a7222222.add((MapleCharacter)((Object)new Pair<MapleStat, Integer>(MapleStat.MP, ((PlayerStats)object).getMp())));
                                                                                                        }
                                                                                                        a7222222.add((MapleCharacter)((Object)new Pair<MapleStat, Integer>(MapleStat.HP, ((PlayerStats)object).getHp())));
                                                                                                        a3.getClient().sendPacket(MaplePacketCreator.updatePlayerStats(a7222222, true, a3));
                                                                                                        if (a92222 != 0) {
                                                                                                            a3.getClient().sendPacket(MaplePacketCreator.enableActions());
                                                                                                            return false;
                                                                                                        }
                                                                                                        if (a10.expinc == 0) break block128;
                                                                                                        MapleStatEffect mapleStatEffect8 = a10;
                                                                                                        mapleStatEffect2 = mapleStatEffect8;
                                                                                                        a3.gainExp(mapleStatEffect8.expinc, true, true, false);
                                                                                                        break block129;
                                                                                                    }
                                                                                                    if (!GameConstants.isMonsterCard(a10.sourceid) || GameSetConstants.MAPLE_VERSION >= 134) break block130;
                                                                                                    if (!a8) break block123;
                                                                                                    MapleStatEffect mapleStatEffect9 = a10;
                                                                                                    mapleStatEffect2 = mapleStatEffect9;
                                                                                                    a3.getMonsterBook().addCard(a3.getClient(), mapleStatEffect9.sourceid);
                                                                                                    break block129;
                                                                                                }
                                                                                                if (a10.sourceid / 10000 != 238) break block131;
                                                                                                n10 = MapleItemInformationProvider.getInstance();
                                                                                                int a7222222 = ((MapleItemInformationProvider)n10).getCardMobId(a10.sourceid);
                                                                                                if (a7222222 > 0) {
                                                                                                    int n3 = a7222222;
                                                                                                    boolean a92222 = a3.getMonsterBook().monsterCaught(a3.getClient(), n3, MapleLifeFactory.getMonster(n3).getStats().getName());
                                                                                                }
                                                                                                break block123;
                                                                                            }
                                                                                            mapleStatEffect3 = a10;
                                                                                            if (!a10.isReturnScroll()) break block132;
                                                                                            mapleStatEffect3.applyReturnScroll(a3);
                                                                                            mapleStatEffect2 = a10;
                                                                                            break block129;
                                                                                        }
                                                                                        if (mapleStatEffect3.useLevel <= 0 || a10.skill) break block133;
                                                                                        mapleStatEffect2 = a10;
                                                                                        MapleCharacter mapleCharacter5 = a3;
                                                                                        MapleStatEffect mapleStatEffect10 = a10;
                                                                                        mapleCharacter5.setExtractor(new MapleExtractor(a3, mapleStatEffect10.sourceid, mapleStatEffect10.useLevel * 50, 1440));
                                                                                        mapleCharacter5.getMap().spawnExtractor(a3.getExtractor());
                                                                                        break block129;
                                                                                    }
                                                                                    if (a10.cosmetic <= 0) break block134;
                                                                                    if (a10.cosmetic >= 30000) {
                                                                                        MapleCharacter mapleCharacter6 = a3;
                                                                                        mapleCharacter2 = mapleCharacter6;
                                                                                        mapleCharacter6.setHair(a10.cosmetic);
                                                                                        mapleCharacter6.updateSingleStat(MapleStat.HAIR, a10.cosmetic);
                                                                                    } else if (a10.cosmetic >= 20000) {
                                                                                        MapleCharacter mapleCharacter7 = a3;
                                                                                        mapleCharacter2 = mapleCharacter7;
                                                                                        mapleCharacter7.setFace(a10.cosmetic);
                                                                                        mapleCharacter7.updateSingleStat(MapleStat.FACE, a10.cosmetic);
                                                                                    } else {
                                                                                        if (a10.cosmetic < 100) {
                                                                                            MapleCharacter mapleCharacter8 = a3;
                                                                                            mapleCharacter8.setSkinColor((byte)a10.cosmetic);
                                                                                            mapleCharacter8.updateSingleStat(MapleStat.SKIN, a10.cosmetic);
                                                                                        }
                                                                                        mapleCharacter2 = a3;
                                                                                    }
                                                                                    mapleCharacter2.equipChanged();
                                                                                    mapleStatEffect2 = a10;
                                                                                    break block129;
                                                                                }
                                                                                if (a10.bs <= 0) break block135;
                                                                                if (!a3.inPVP()) {
                                                                                    return false;
                                                                                }
                                                                                MapleCharacter mapleCharacter9 = a3;
                                                                                MapleCharacter mapleCharacter10 = a3;
                                                                                int n11 = Integer.parseInt(mapleCharacter9.getEventInstance().getProperty(String.valueOf(mapleCharacter10.getId())));
                                                                                mapleCharacter10.getEventInstance().setProperty(String.valueOf(a3.getId()), String.valueOf(n11 + a10.bs));
                                                                                mapleCharacter9.getClient().sendPacket(MaplePacketCreator.getPVPScore(n11 + a10.bs, false));
                                                                                mapleStatEffect2 = a10;
                                                                                break block129;
                                                                            }
                                                                            if (a10.iceGageCon <= 0) break block136;
                                                                            if (!a3.inPVP()) {
                                                                                return false;
                                                                            }
                                                                            int iterator = Integer.parseInt(a3.getEventInstance().getProperty(SkillEntry.ALLATORIxDEMO("|RpVtVp")));
                                                                            if (iterator < a10.iceGageCon) {
                                                                                return false;
                                                                            }
                                                                            MapleCharacter mapleCharacter11 = a3;
                                                                            mapleCharacter11.getEventInstance().setProperty(ConcurrentEnumMap.ALLATORIxDEMO("\u0007:\u000b>\u000f>\u000b"), String.valueOf(iterator - a10.iceGageCon));
                                                                            int n4 = iterator;
                                                                            mapleCharacter11.getClient().sendPacket(MaplePacketCreator.getPVPIceGage(n4 - a10.iceGageCon));
                                                                            mapleCharacter11.applyIceGage(n4 - a10.iceGageCon);
                                                                            mapleStatEffect2 = a10;
                                                                            break block129;
                                                                        }
                                                                        if (a10.recipe <= 0) break block137;
                                                                        if (a3.getSkillLevel(a10.recipe) > 0 || a3.getProfessionLevel(a10.recipe / 10000 * 10000) < a10.reqSkillLevel) {
                                                                            return false;
                                                                        }
                                                                        MapleStatEffect mapleStatEffect11 = a10;
                                                                        a3.changeSkillLevel(SkillFactory.getCraft(a10.recipe), Integer.MAX_VALUE, (int)mapleStatEffect11.recipeUseCount, mapleStatEffect11.recipeValidDay > 0 ? System.currentTimeMillis() + (long)a10.recipeValidDay * 24L * 60L * 60L * 1000L : -1L);
                                                                        mapleStatEffect2 = a10;
                                                                        break block129;
                                                                    }
                                                                    if (!a10.isComboRecharge()) break block138;
                                                                    short summonMovementType2 = (short)(a3.getCombo() + a10.y);
                                                                    if (GameSetConstants.MAPLE_VERSION >= 152 && a3.getSkillLevel(21120045) > 0) {
                                                                        summonMovementType2 = (short)(a3.getCombo() + a10.y * 2);
                                                                    }
                                                                    MapleCharacter mapleCharacter12 = a3;
                                                                    mapleCharacter12.setCombo((short)Math.min(30000, summonMovementType2));
                                                                    mapleCharacter12.setLastCombo(System.currentTimeMillis());
                                                                    mapleCharacter12.getClient().sendPacket(MaplePacketCreator.rechargeCombo(a3.getCombo()));
                                                                    MapleCharacter mapleCharacter13 = a3;
                                                                    SkillFactory.getSkill(21000000).getEffect(10).applyComboBuff(mapleCharacter13, mapleCharacter13.getCombo());
                                                                    mapleStatEffect2 = a10;
                                                                    break block129;
                                                                }
                                                                if (!a10.isDragonBlink()) break block139;
                                                                n10 = a3.getMap().getPortal(Randomizer.nextInt(a3.getMap().getPortals().size()));
                                                                if (n10 != null) {
                                                                    MapleCharacter mapleCharacter14 = a3;
                                                                    mapleCharacter14.getClient().sendPacket(MaplePacketCreator.dragonBlink(n10.getId()));
                                                                    MapleCharacter mapleCharacter15 = a3;
                                                                    mapleCharacter14.getMap().movePlayer(mapleCharacter15, n10.getPosition());
                                                                    mapleCharacter15.checkFollow();
                                                                }
                                                                break block123;
                                                            }
                                                            if (!a10.E() && !a10.D() || a3.isClone()) break block140;
                                                            boolean bl2 = false;
                                                            a7222222 = a3.getInventory(MapleInventoryType.USE);
                                                            boolean a92222 = false;
                                                            iItem = 200;
                                                            if (a10.getBulletConsume() > 0) {
                                                                iItem = a10.getBulletConsume();
                                                            }
                                                            int n5 = n2 = 0;
                                                            while (n5 <= ((MapleInventory)((Object)a7222222)).getSlotLimit()) {
                                                                object = ((MapleInventory)((Object)a7222222)).getItem((byte)n2);
                                                                if (object != null && (a10.E() && GameConstants.isThrowingStar(object.getItemId()) || a10.D() && GameConstants.isBullet(object.getItemId()))) {
                                                                    int n6 = object.getQuantity();
                                                                    if (a92222 + n6 >= iItem) {
                                                                        n6 = iItem - a92222;
                                                                    }
                                                                    MapleInventoryManipulator.removeById(a3.getClient(), MapleInventoryType.USE, object.getItemId(), n6, false, true);
                                                                    bl2 = true;
                                                                    if ((a92222 += n6) >= iItem) {
                                                                        bl = bl2;
                                                                        break block122;
                                                                    }
                                                                }
                                                                n5 = ++n2;
                                                            }
                                                            bl = bl2;
                                                        }
                                                        if (!bl) {
                                                            return false;
                                                        }
                                                        break block123;
                                                    }
                                                    if (a10.cp == 0 || a3.getCarnivalParty() == null) break block141;
                                                    MapleCharacter mapleCharacter16 = a3;
                                                    mapleCharacter16.getCarnivalParty().addCP(a3, a10.cp);
                                                    mapleCharacter16.CPUpdate(false, a3.getAvailableCP(), a3.getTotalCP(), 0);
                                                    Iterator<MapleCharacter> iterator = n10 = mapleCharacter16.getMap().getCharactersThreadsafe().iterator();
                                                    while (iterator.hasNext()) {
                                                        a7222222 = n10.next();
                                                        iterator = n10;
                                                        ((MapleCharacter)((Object)a7222222)).CPUpdate(true, a3.getCarnivalParty().getAvailableCP(), a3.getCarnivalParty().getTotalCP(), a3.getCarnivalParty().getTeam());
                                                    }
                                                    break block123;
                                                }
                                                if (a10.nuffSkill == 0 || a3.getParty() == null) break block142;
                                                n10 = MapleCarnivalFactory.getInstance().getSkill(a10.nuffSkill);
                                                if (n10 != null) {
                                                    a7222222 = ((MapleCarnivalFactory.MCSkill)n10).getDisease();
                                                    for (MapleCharacter mapleCharacter17 : a3.getMap().getCharactersThreadsafe()) {
                                                        Iterator<MapleCharacter> iterator;
                                                        if (a3.getParty() != null && mapleCharacter17.getParty() != null && mapleCharacter17.getParty().getId() == a3.getParty().getId() || !((MapleCarnivalFactory.MCSkill)n10).targetsAll && !Randomizer.nextBoolean()) continue;
                                                        if (a7222222 == null) {
                                                            iterator = n10;
                                                            mapleCharacter17.dispel();
                                                        } else {
                                                            MapleCharacter mapleCharacter18 = mapleCharacter17;
                                                            if (((MapleCarnivalFactory.MCSkill)n10).getMobSkill() == null) {
                                                                mapleCharacter18.giveDebuff((MapleBuffStat)((Object)a7222222), 1, 30000L, MobSkill.getByDisease(a7222222), 1);
                                                                iterator = n10;
                                                            } else {
                                                                mapleCharacter18.giveDebuff((MapleBuffStat)((Object)a7222222), ((MapleCarnivalFactory.MCSkill)n10).getMobSkill());
                                                                iterator = n10;
                                                            }
                                                        }
                                                        if (((MapleCarnivalFactory.MCSkill)iterator).targetsAll) continue;
                                                        break block123;
                                                    }
                                                }
                                                break block123;
                                            }
                                            if (a10.mobSkill <= 0 || a10.mobSkillLevel <= 0 || !a4 || !a3.inPVP()) break block143;
                                            if (a10.effectedOnEnemy <= 0) break block144;
                                            MapleCharacter mapleCharacter19 = a3;
                                            int n7 = Integer.parseInt(mapleCharacter19.getEventInstance().getProperty(SkillEntry.ALLATORIxDEMO("ElAp")));
                                            for (MapleCharacter a92222 : mapleCharacter19.getMap().getCharactersThreadsafe()) {
                                                if (a92222.getId() == a3.getId() || a92222.getTeam() == a3.getTeam() && n7 != 0) continue;
                                                MapleStatEffect mapleStatEffect12 = a10;
                                                a92222.disease(mapleStatEffect12.mobSkill, mapleStatEffect12.mobSkillLevel);
                                            }
                                            break block123;
                                        }
                                        if (a10.sourceid == 2910000 || a10.sourceid == 2910001) {
                                            MapleCharacter mapleCharacter20 = a3;
                                            mapleCharacter20.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(a10.sourceid, 13, a3.getLevel(), a10.level));
                                            MapleCharacter mapleCharacter21 = a3;
                                            mapleCharacter20.getMap().broadcastMessage(mapleCharacter21, MaplePacketCreator.showBuffEffect(mapleCharacter21.getId(), a10.sourceid, 13, a3.getLevel(), a10.level), false);
                                            mapleCharacter21.getClient().sendPacket(MaplePacketCreator.showOwnCraftingEffect(ConcurrentEnumMap.ALLATORIxDEMO(";\u0010A\f'\u000e\u00077\n6\u0019k@0\u0003>A\u001a:\u001fA\u001c\b?\u000b:\u001a"), 0, 0));
                                            MapleCharacter mapleCharacter22 = a3;
                                            mapleCharacter20.getMap().broadcastMessage(mapleCharacter22, MaplePacketCreator.showCraftingEffect(mapleCharacter22.getId(), SkillEntry.ALLATORIxDEMO("@x:d\\f|_q^b\u0003;XxV:rAw:tsWpRa"), 0, 0), false);
                                            if (mapleCharacter20.getTeam() == a10.sourceid - 2910000) {
                                                MapleCharacter mapleCharacter23;
                                                if (a10.sourceid == 2910000) {
                                                    MapleCharacter mapleCharacter24 = a3;
                                                    mapleCharacter23 = mapleCharacter24;
                                                    mapleCharacter24.getEventInstance().broadcastPlayerMsg(-7, ConcurrentEnumMap.ALLATORIxDEMO("\r\u0006<N\u000b\u000b=N\r\u000b8\u0003~\u001dy\b5\u000f>N1\u000f*N;\u000b<\u0000y\u001c<\u001d-\u0001+\u000b=@"));
                                                } else {
                                                    MapleCharacter mapleCharacter25 = a3;
                                                    mapleCharacter23 = mapleCharacter25;
                                                    mapleCharacter25.getEventInstance().broadcastPlayerMsg(-7, SkillEntry.ALLATORIxDEMO("AYp\u0011W]`T5epPx\u0016f\u0011s]tV5YtB5SpT{\u0011gTfEzCpU;"));
                                                }
                                                mapleCharacter23.getMap().spawnAutoDrop(a10.sourceid, (Point)a3.getMap().getGuardians().get((int)(a10.sourceid - 2910000)).left);
                                                mapleStatEffect2 = a10;
                                            } else {
                                                MapleStatEffect mapleStatEffect13 = a10;
                                                a3.disease(mapleStatEffect13.mobSkill, mapleStatEffect13.mobSkillLevel);
                                                if (a10.sourceid == 2910000) {
                                                    mapleStatEffect2 = a10;
                                                    MapleCharacter mapleCharacter26 = a3;
                                                    MapleCharacter mapleCharacter27 = a3;
                                                    mapleCharacter26.getEventInstance().setProperty(ConcurrentEnumMap.ALLATORIxDEMO("\u001c<\n?\u00028\t"), String.valueOf(mapleCharacter27.getId()));
                                                    mapleCharacter27.getEventInstance().broadcastPlayerMsg(-7, SkillEntry.ALLATORIxDEMO("e}T5cpU5epPx\u0016f\u0011s]tV5YtB5SpT{\u0011vPeE`CpU4"));
                                                    mapleCharacter26.getClient().sendPacket(MaplePacketCreator.showOwnCraftingEffect(ConcurrentEnumMap.ALLATORIxDEMO(";\u0010A\f'\u000e\u00077\n6\u0019k@0\u0003>A\u001a:\u001fA\r\u000f0\u0002v<<\n"), 600000, 0));
                                                    MapleCharacter mapleCharacter28 = a3;
                                                    mapleCharacter26.getMap().broadcastMessage(mapleCharacter28, MaplePacketCreator.showCraftingEffect(mapleCharacter28.getId(), SkillEntry.ALLATORIxDEMO("@x:d\\f|_q^b\u0003;XxV:rAw:etXy\u001eGTq"), 600000, 0), false);
                                                } else {
                                                    MapleCharacter mapleCharacter29 = a3;
                                                    MapleCharacter mapleCharacter30 = a3;
                                                    mapleCharacter29.getEventInstance().setProperty(ConcurrentEnumMap.ALLATORIxDEMO(";\u0002,\u000b?\u00028\t"), String.valueOf(mapleCharacter30.getId()));
                                                    mapleCharacter30.getEventInstance().broadcastPlayerMsg(-7, SkillEntry.ALLATORIxDEMO("AYp\u0011W]`T5epPx\u0016f\u0011s]tV5YtB5SpT{\u0011vPeE`CpU4"));
                                                    mapleCharacter29.getClient().sendPacket(MaplePacketCreator.showOwnCraftingEffect(ConcurrentEnumMap.ALLATORIxDEMO("\f'v;\u001090\u0000=\u0001.\\w\u00074\tv-\r(v:8\u00075A\u001b\u0002,\u000b"), 600000, 0));
                                                    MapleCharacter mapleCharacter31 = a3;
                                                    mapleCharacter29.getMap().broadcastMessage(mapleCharacter31, MaplePacketCreator.showCraftingEffect(mapleCharacter31.getId(), SkillEntry.ALLATORIxDEMO("d\\\u001e@xBX{UzF'\u001f|\\r\u001eVeS\u001eAP|]:syDp"), 600000, 0), false);
                                                    mapleStatEffect2 = a10;
                                                }
                                            }
                                        } else {
                                            MapleStatEffect mapleStatEffect14 = a10;
                                            a3.disease(mapleStatEffect14.mobSkill, mapleStatEffect14.mobSkillLevel);
                                            mapleStatEffect2 = a10;
                                        }
                                        break block129;
                                    }
                                    if ((a10.effectedOnEnemy > 0 || a10.effectedOnAlly > 0) && a4 && a3.inPVP()) {
                                        int n8 = Integer.parseInt(a3.getEventInstance().getProperty(ConcurrentEnumMap.ALLATORIxDEMO("-\u0017)\u000b")));
                                        if (n8 > 0 || a10.effectedOnEnemy > 0) {
                                            for (MapleCharacter a92222 : a3.getMap().getCharactersThreadsafe()) {
                                                MapleStatEffect mapleStatEffect15;
                                                if (a92222.getId() == a3.getId()) continue;
                                                if (a10.effectedOnAlly > 0) {
                                                    if (a92222.getTeam() != a3.getTeam()) continue;
                                                    mapleStatEffect15 = a10;
                                                } else {
                                                    if (a92222.getTeam() == a3.getTeam() && n8 != 0) continue;
                                                    mapleStatEffect15 = a10;
                                                }
                                                mapleStatEffect15.applyTo(a3, a92222, false, a5, a6);
                                            }
                                        }
                                    } else if (a10.a != null && a10.a.size() > 0) {
                                        MapleStatEffect mapleStatEffect16 = a10;
                                        MapleItemInformationProvider.getInstance().getItemEffect(mapleStatEffect16.a.get(Randomizer.nextInt(mapleStatEffect16.a.size()))).applyTo(a3);
                                    }
                                }
                                mapleStatEffect2 = a10;
                            }
                            if (mapleStatEffect2.B != null) {
                                Iterator<Map.Entry<MapleTrait.MapleTraitType, Integer>> iterator;
                                Iterator<Map.Entry<MapleTrait.MapleTraitType, Integer>> iterator2 = iterator = a10.B.entrySet().iterator();
                                while (iterator2.hasNext()) {
                                    Map.Entry<MapleTrait.MapleTraitType, Integer> a7222222 = iterator.next();
                                    a3.getTrait(a7222222.getKey()).addExp(a7222222.getValue(), a3);
                                    iterator2 = iterator;
                                }
                            }
                            if ((summonMovementType = a10.getSummonMovementType()) != null && (a10.sourceid != 32111006 || a2.getBuffedValue(MapleBuffStat.REAPER) != null && !a4) && !a3.isClone()) {
                                ISkill a92222;
                                MapleStatEffect mapleStatEffect17 = a10;
                                int a7222222 = mapleStatEffect17.sourceid;
                                if (mapleStatEffect17.sourceid == 3111002) {
                                    ISkill a92222 = SkillFactory.getSkill(3120012);
                                    if (a2.getSkillLevel(a92222) > 0) {
                                        ISkill iSkill = a92222;
                                        return iSkill.getEffect(a2.getSkillLevel(iSkill)).applyTo(a2, a3, a4, a5, a6);
                                    }
                                } else if (a10.sourceid == 3211002 && a2.getSkillLevel(a92222 = SkillFactory.getSkill(3220012)) > 0) {
                                    ISkill iSkill = a92222;
                                    return iSkill.getEffect(a2.getSkillLevel(iSkill)).applyTo(a2, a3, a4, a5, a6);
                                }
                                if (!(a92222 = new MapleSummon(a2, a10, new Point(a5 == null ? a2.getTruePosition() : a5), summonMovementType)).isPuppet()) {
                                    a2.getCheatTracker().resetSummonAttack();
                                }
                                MapleCharacter mapleCharacter32 = a2;
                                mapleCharacter32.cancelEffect(a10, true, -1L, a10.statups);
                                MapleSummon mapleSummon = a92222;
                                mapleCharacter32.getMap().spawnSummon(mapleSummon);
                                mapleCharacter32.addSummon(mapleSummon);
                                MapleStatEffect mapleStatEffect18 = a10;
                                a92222.setRemoveTime(System.currentTimeMillis() + (long)a6);
                                a92222.addHP((short)mapleStatEffect18.x);
                                if (mapleStatEffect18.isBeholder()) {
                                    a92222.addHP((short)1);
                                } else if (a10.sourceid == 4341006) {
                                    MapleCharacter mapleCharacter33 = a2;
                                    mapleCharacter33.cancelEffectFromBuffStat(MapleBuffStat.SHADOWPARTNER);
                                    mapleCharacter33.cancelEffectFromBuffStat(MapleBuffStat.MIRROR_IMAGE);
                                } else {
                                    if (a10.sourceid == 32111006) {
                                        return true;
                                    }
                                    if (a10.sourceid == 35111002) {
                                        ArrayList<Integer> arrayList = new ArrayList<Integer>();
                                        List<MapleSummon> list = a2.getSummonsReadLock();
                                        try {
                                            for (MapleSummon mapleSummon2 : list) {
                                                if (mapleSummon2.getSkill() != a10.sourceid) continue;
                                                arrayList.add(mapleSummon2.getObjectId());
                                            }
                                        }
                                        finally {
                                            a2.unlockSummonsReadLock();
                                        }
                                        if (arrayList.size() != 3) {
                                            return true;
                                        }
                                        MapleCharacter mapleCharacter34 = a2;
                                        mapleCharacter34.getClient().sendPacket(MaplePacketCreator.skillCooldown(a10.sourceid, a10.getCooldown(a2)));
                                        mapleCharacter34.addCooldown(a10.sourceid, System.currentTimeMillis(), a10.getCooldown(a2) * 1000);
                                        a2.getMap().broadcastMessage(MaplePacketCreator.teslaTriangle(a2.getId(), (Integer)arrayList.get(0), (Integer)arrayList.get(1), (Integer)arrayList.get(2)));
                                    } else if (a10.sourceid == 35121003) {
                                        a2.getClient().sendPacket(MaplePacketCreator.enableActions());
                                    }
                                }
                            } else if (a10.isMechDoor()) {
                                Object object;
                                int a7222222 = 0;
                                boolean a92222 = false;
                                if (a3.getMechDoors().size() >= 2) {
                                    object = a3.getMechDoors().remove(0);
                                    a7222222 = ((MechDoor)object).getId();
                                    a3.getMap().broadcastMessage(MaplePacketCreator.removeMechDoor((MechDoor)object, true));
                                    a3.getMap().removeMapObject((MapleMapObject)object);
                                } else {
                                    for (MechDoor mechDoor : a3.getMechDoors()) {
                                        if (mechDoor.getId() != a7222222) continue;
                                        a92222 = true;
                                        a7222222 = 1;
                                        break;
                                    }
                                }
                                object = new MechDoor(a3, new Point(a5 == null ? a3.getTruePosition() : a5), a7222222);
                                MapleCharacter mapleCharacter35 = a3;
                                mapleCharacter35.getMap().spawnMechDoor((MechDoor)object);
                                mapleCharacter35.addMechDoor((MechDoor)object);
                                mapleCharacter35.getClient().sendPacket(MaplePacketCreator.mechPortal(((AbstractMapleMapObject)object).getTruePosition()));
                                if (!a92222) {
                                    return true;
                                }
                            }
                            if (a10.overTime && !a10.isEnergyCharge()) {
                                a10.ALLATORIxDEMO(a2, a3, a4, a6, a8);
                            }
                            if (a10.skill) {
                                a10.ALLATORIxDEMO(a2);
                            }
                            if (a4) {
                                if ((a10.overTime || a10.isHeal()) && !a10.isEnergyCharge()) {
                                    a10.ALLATORIxDEMO(a2, a6);
                                }
                                if (a10.isMonsterBuff()) {
                                    a10.applyMonsterBuff(a2);
                                }
                            }
                            if (!a10.isMagicDoor()) break block145;
                            a7222222 = new MapleDoor(a3, new Point(a5 == null ? a3.getTruePosition() : a5), a10.sourceid);
                            if (((MapleDoor)a7222222).getTownPortal() != null) {
                                MapleCharacter mapleCharacter36 = a3;
                                MapleCharacter mapleCharacter37 = a3;
                                mapleCharacter37.getMap().spawnDoor((MapleDoor)a7222222);
                                mapleCharacter36.addDoor((MapleDoor)a7222222);
                                MapleDoor a92222 = new MapleDoor((MapleDoor)a7222222);
                                mapleCharacter37.addDoor(a92222);
                                ((MapleDoor)a7222222).getTown().spawnDoor(a92222);
                                if (mapleCharacter36.getParty() != null) {
                                    a3.silentPartyUpdate();
                                }
                            } else {
                                a3.dropMessage(5, SkillEntry.ALLATORIxDEMO("\u7134\u6ce4\u4f6a\u7519\u6657\u7a4b\u9595\uff3d\u6744\u83bb\u4e18\u53de\u5bac\u7d3c\u3017"));
                            }
                            break block146;
                        }
                        if (!a10.isMist()) break block147;
                        if (a10.sourceid != 24121052) break block148;
                        Object object = a7222222 = a2.getSkillPosition().iterator();
                        while (object.hasNext()) {
                            Point a92222 = (Point)a7222222.next();
                            object = a7222222;
                            a2.getMap().spawnMist(new MapleMist(a10.calculateBoundingBox(a92222, a2.isFacingLeft()), a2, a10, a92222), 5000, false);
                        }
                        break block146;
                    }
                    if (a5 != null) {
                        point = a5;
                        mapleCharacter = a2;
                    } else {
                        point = a2.getPosition();
                        mapleCharacter = a2;
                    }
                    a7222222 = a10.calculateBoundingBox(point, mapleCharacter.isFacingLeft());
                    MapleMist a92222 = new MapleMist((Rectangle)a7222222, a2, a10);
                    MapleStatEffect mapleStatEffect19 = a10;
                    mapleStatEffect = mapleStatEffect19;
                    a2.getMap().spawnMist(a92222, mapleStatEffect19.getDuration(), false);
                    break block149;
                }
                if (a10.isTimeLeap()) {
                    for (MapleCoolDownValueHolder a92222 : a3.getCooldowns()) {
                        if (a92222.skillId == 5121010) continue;
                        MapleCharacter mapleCharacter = a3;
                        mapleCharacter.removeCooldown(a92222.skillId);
                        mapleCharacter.getClient().sendPacket(MaplePacketCreator.skillCooldown(a92222.skillId, 0));
                    }
                } else {
                    int n9;
                    a7222222 = a3.getClones();
                    int a92222 = ((WeakReference<MapleCharacter>[])a7222222).length;
                    int n10 = n9 = 0;
                    while (n10 < a92222) {
                        Object object = a7222222[n9];
                        if (((Reference)object).get() != null) {
                            a10.applyTo((MapleCharacter)((Reference)object).get(), (MapleCharacter)((Reference)object).get(), a4, a5, a6);
                        }
                        n10 = ++n9;
                    }
                }
            }
            mapleStatEffect = a10;
        }
        if (mapleStatEffect.rewardMeso != 0) {
            a3.gainMeso(a10.rewardMeso, false);
        }
        if (a10.ALLATORIxDEMO != null && a10.totalprob > 0) {
            for (Triple a92222 : a10.ALLATORIxDEMO) {
                if (!MapleInventoryManipulator.checkSpace(a3.getClient(), (Integer)a92222.left, (Integer)a92222.mid, "") || (Integer)a92222.right <= 0 || Randomizer.nextInt(a10.totalprob) >= (Integer)a92222.right) continue;
                if (GameConstants.getInventoryType((Integer)a92222.left) == MapleInventoryType.EQUIP) {
                    IItem iItem = MapleItemInformationProvider.getInstance().getEquipById((Integer)a92222.left);
                    iItem.setGMLog("Reward item (effect): " + a10.sourceid + " on " + FileoutputUtil.CurrentReadable_Date());
                    MapleInventoryManipulator.addbyItem(a3.getClient(), iItem);
                    continue;
                }
                MapleInventoryManipulator.addById(a3.getClient(), (Integer)a92222.left, ((Integer)a92222.mid).shortValue(), "Reward item (effect): " + a10.sourceid + " on " + FileoutputUtil.CurrentReadable_Date());
            }
        }
        if (a10.familiarTarget == 2 && a2.getParty() != null && a4) {
            for (MaplePartyCharacter a92222 : a2.getParty().getMembers()) {
                MapleCharacter mapleCharacter;
                if (a92222.getId() == a2.getId() || a92222.getChannel() != a2.getClient().getChannel() || a92222.getMapid() != a2.getMapId() || !a92222.isOnline() || (mapleCharacter = a2.getMap().getCharacterById(a92222.getId())) == null) continue;
                a10.applyTo(a2, mapleCharacter, false, null, a6);
            }
        } else if (a10.familiarTarget == 3 && a4) {
            for (MapleCharacter a92222 : a2.getMap().getCharactersThreadsafe()) {
                if (a92222.getId() == a2.getId()) continue;
                a10.applyTo(a2, a92222, false, null, a6);
            }
        }
        if ((a2.getJob() == 2711 || a2.getJob() == 2712) && a2.getTotalSkillLevel(27110007) > 0) {
            SkillFactory.getSkill(27110007).getEffect(a2.getTotalSkillLevel(27110007)).applyLunarTideBuff(a2);
        }
        return true;
    }

    public final /* synthetic */ int getHpX() {
        MapleStatEffect a2;
        return a2.mhpX;
    }

    public final /* synthetic */ int getV() {
        MapleStatEffect a2;
        return a2.v;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isBerserkFury() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1011: 
            case 10001011: 
            case 20001011: 
            case 20011011: 
            case 30001011: {
                return a2.skill;
            }
        }
        return false;
    }

    public /* synthetic */ int getPassiveJump() {
        MapleStatEffect a2;
        return a2.psdJump;
    }

    public /* synthetic */ int getPddX() {
        MapleStatEffect a2;
        return a2.pddX;
    }

    public final /* synthetic */ int getConsume() {
        MapleStatEffect a2;
        return a2.consumeOnPickup;
    }

    public final /* synthetic */ boolean isOverTime() {
        MapleStatEffect a2;
        return a2.overTime;
    }

    public final /* synthetic */ int getEnhancedHP() {
        MapleStatEffect a2;
        return a2.ehp;
    }

    public final /* synthetic */ int getMorph() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 5111005: 
            case 15111002: {
                return 1000;
            }
            case 5121003: {
                return 1001;
            }
            case 5101007: {
                while (false) {
                }
                return 1002;
            }
            case 13111005: {
                return 1003;
            }
        }
        return a2.morph;
    }

    public final /* synthetic */ int getSlotCount() {
        MapleStatEffect a2;
        return a2.slotCount;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2) {
        MapleStatEffect a3;
        ArrayList<MonsterStatus> arrayList = new ArrayList<MonsterStatus>();
        switch (a3.sourceid) {
            case 1111007: {
                arrayList.add(MonsterStatus.WDEF);
                arrayList.add(MonsterStatus.WEAPON_DEFENSE_UP);
                break;
            }
            case 1211009: 
            case 11111008: 
            case 51111005: {
                arrayList.add(MonsterStatus.MDEF);
                arrayList.add(MonsterStatus.MAGIC_DEFENSE_UP);
                break;
            }
            case 1311007: {
                arrayList.add(MonsterStatus.WATK);
                arrayList.add(MonsterStatus.WEAPON_ATTACK_UP);
                arrayList.add(MonsterStatus.MATK);
                arrayList.add(MonsterStatus.MAGIC_ATTACK_UP);
                break;
            }
            default: {
                return;
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            ArrayList<MonsterStatus> arrayList2 = arrayList;
            arrayList2.clear();
            arrayList2.add(MonsterStatus.WDEF);
            arrayList.add(MonsterStatus.MDEF);
            arrayList.add(MonsterStatus.WATK);
            arrayList.add(MonsterStatus.MATK);
            arrayList.add(MonsterStatus.WEAPON_DEFENSE_UP);
            arrayList.add(MonsterStatus.MAGIC_DEFENSE_UP);
            arrayList.add(MonsterStatus.WEAPON_ATTACK_UP);
            arrayList.add(MonsterStatus.MAGIC_ATTACK_UP);
            arrayList.add(MonsterStatus.WEAPON_IMMUNITY);
            arrayList.add(MonsterStatus.MAGIC_IMMUNITY);
        }
        Rectangle rectangle = a3.calculateBoundingBox(((AbstractMapleMapObject)((Object)a2)).getPosition(), ((AbstractAnimatedMapleMapObject)((Object)a2)).isFacingLeft());
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        a2 = ((MapleCharacter)((Object)a2)).getMap().getMapObjectsInRect(rectangle, Arrays.asList(arrmapleMapObjectType));
        byte by = 0;
        a2 = a2.iterator();
        do {
            if (!a2.hasNext()) {
                return;
            }
            MapleMapObject mapleMapObject = (MapleMapObject)a2.next();
            if (!a3.makeChanceResult()) continue;
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                Iterator iterator2;
                MonsterStatus monsterStatus = (MonsterStatus)((Object)iterator2.next());
                ((MapleMonster)mapleMapObject).cancelStatus(monsterStatus);
                iterator = iterator2;
            }
        } while (++by < a3.mobCount);
    }

    public final /* synthetic */ short getStr() {
        MapleStatEffect a2;
        return a2.str;
    }

    public final /* synthetic */ short getMp() {
        MapleStatEffect a2;
        return a2.mp;
    }

    public final /* synthetic */ short getMatk() {
        MapleStatEffect a2;
        return a2.matk;
    }

    public final /* synthetic */ Rectangle calculateBoundingBox(Point a2, boolean a3) {
        MapleStatEffect a4;
        MapleStatEffect mapleStatEffect = a4;
        return MapleStatEffect.calculateBoundingBox(a2, a3, mapleStatEffect.lt, mapleStatEffect.rb, a4.range);
    }

    public final /* synthetic */ boolean isMorph() {
        MapleStatEffect a2;
        return a2.morph > 0;
    }

    public final /* synthetic */ boolean isSkill() {
        MapleStatEffect a2;
        return a2.skill;
    }

    public /* synthetic */ String getName() {
        String string = "";
        try {
            MapleStatEffect a2;
            string = SkillFactory.getName(a2.getSourceId());
            return string;
        }
        catch (Exception exception) {
            return string;
        }
    }

    public final /* synthetic */ boolean isBeholder() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 1321007;
    }

    public final /* synthetic */ void handleExtraPVP(MapleCharacter a2, MapleCharacter a3) {
        MapleStatEffect a4;
        if (a4.sourceid == 2311005 || a4.sourceid == 5121005 || a4.sourceid == 1201006 || JobConstants.isBeginnerJob(a4.sourceid / 10000) && a4.sourceid % 10000 == 104) {
            MapleCharacter mapleCharacter;
            long l2 = System.currentTimeMillis();
            int n2 = a4.sourceid == 5121005 ? 90002000 : a4.sourceid;
            LinkedList<Pair<MapleBuffStat, Integer>> linkedList = new LinkedList<Pair<MapleBuffStat, Integer>>();
            if (a4.sourceid == 2311005) {
                mapleCharacter = a3;
                linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MORPH, 7));
            } else if (a4.sourceid == 1201006) {
                mapleCharacter = a3;
                linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.THREATEN_PVP, Integer.valueOf(a4.level)));
            } else if (a4.sourceid == 5121005) {
                mapleCharacter = a3;
                linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SNATCH, 1));
            } else {
                linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MORPH, a4.x));
                mapleCharacter = a3;
            }
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveBuff(n2, a4.getDuration(), linkedList, a4, a3));
            a3.registerEffect(a4, l2, linkedList, a4.getDuration(), a2.getId());
        }
    }

    public final /* synthetic */ int getW() {
        MapleStatEffect a2;
        return a2.w;
    }

    public final /* synthetic */ boolean isDragonBlood() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 1311008;
    }

    public final /* synthetic */ byte getReqGuildLevel() {
        MapleStatEffect a2;
        return a2.reqGuildLevel;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ MapleStatEffect ALLATORIxDEMO(MapleData a2, int a3, boolean a42, boolean a52, int a6, String a7) {
        MapleData mapleData;
        MapleData mapleData2;
        Object object;
        int n2;
        MapleStatEffect mapleStatEffect;
        MapleStatEffect mapleStatEffect2;
        MapleStatEffect mapleStatEffect3;
        MapleStatEffect mapleStatEffect4 = mapleStatEffect3 = new MapleStatEffect();
        mapleStatEffect3.sourceid = a3;
        mapleStatEffect4.skill = a42;
        mapleStatEffect4.level = (byte)a6;
        if (a2 == null) {
            return mapleStatEffect3;
        }
        ArrayList<Pair<MapleBuffStat, Integer>> a42 = new ArrayList<Pair<MapleBuffStat, Integer>>();
        MapleStatEffect mapleStatEffect5 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect6 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect7 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect8 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect9 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect10 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect11 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect12 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect13 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect14 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect15 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect16 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect17 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect18 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect19 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect20 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect21 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect22 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect23 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect24 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect25 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect26 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect27 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect28 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect29 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect30 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect31 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect32 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect33 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect34 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect35 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect36 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect37 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect38 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect39 = mapleStatEffect3;
        mapleStatEffect39.duration = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("E|\\p"), a2, -1, a7, a6);
        mapleStatEffect39.hp = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("1\u001e"), a2, 0, a7, a6);
        mapleStatEffect38.hpR = (double)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("}AG"), a2, 0, a7, a6) / 100.0;
        mapleStatEffect38.mp = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("4\u001e"), a2, 0, a7, a6);
        mapleStatEffect37.mpR = (double)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("xAG"), a2, 0, a7, a6) / 100.0;
        mapleStatEffect37.mhp_temp = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("4\u0006)1-\u000b4\u001e"), a2, 0, a7, a6);
        mapleStatEffect36.mmp_temp = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\xAJEp\\e"), a2, 0, a7, a6);
        mapleStatEffect36.mhpR = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("4\u0006)<"), a2, 0, a7, a6);
        mapleStatEffect35.mmpR = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\xAG"), a2, 0, a7, a6);
        mapleStatEffect35.MDF = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("#\u001d("), a2, 0, a7, a6);
        mapleStatEffect34.pddR = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("AqUG"), a2, 0, a7, a6);
        mapleStatEffect34.mddR = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("4\n=<"), a2, 0, a7, a6);
        mapleStatEffect33.ignoreMob = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("|V{^gTX^wAqAG"), a2, 0, a7, a6);
        mapleStatEffect33.asrR = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("8\u001d+<"), a2, 0, a7, a6);
        mapleStatEffect32.bdR = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("wUG"), a2, 0, a7, a6);
        mapleStatEffect32.damR = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("=\u000f4<"), a2, 0, a7, a6);
        mapleStatEffect31.terR = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("EpCG"), a2, 0, a7, a6);
        mapleStatEffect31.mesoR = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0003<\u001d6<"), a2, 0, a7, a6);
        mapleStatEffect30.thaw = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("E}Pb"), a2, 0, a7, a6);
        mapleStatEffect30.padX = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO(")\u000f=6"), a2, 0, a7, a6);
        mapleStatEffect29.madX = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\tUM"), a2, 0, a7, a6);
        mapleStatEffect29.dot = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\n6\u001a"), a2, 0, a7, a6);
        mapleStatEffect28.dotTime = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("q^ae|\\p"), a2, 0, a7, a6);
        mapleStatEffect28.criticaldamageMin = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\r+\u0007-\u0007:\u000f5\n8\u00038\t<#0\u0000"), a2, 0, a7, a6);
        mapleStatEffect27.criticaldamageMax = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("vC|E|Rt]qPxPrTXPm"), a2, 0, a7, a6);
        mapleStatEffect27.mpConReduce = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0003)-6\u0000\u000b\u000b=\u001b:\u000b"), a2, 0, a7, a6);
        mapleStatEffect26.forceCon = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("WzCvTV^{"), a2, 0, a7, a6);
        mapleStatEffect26.mpCon = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0003)-6\u0000"), a2, 0, a7, a6);
        mapleStatEffect25.hpCon = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("}AV^{"), a2, 0, a7, a6);
        mapleStatEffect25.mmpX = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("4\u0003)6"), a2, 0, a7, a6);
        mapleStatEffect24.mhpX = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\}AM"), a2, 0, a7, a6);
        mapleStatEffect24.prop = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO(")\u001c6\u001e"), a2, 100, a7, a6);
        mapleStatEffect23.prob = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Ag^w"), a2, 0, a7, a6) + 100;
        mapleStatEffect23.cooldown = Math.max(0, MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO(":\u00016\u0002-\u00074\u000b"), a2, 0, a7, a6));
        mapleStatEffect22.interval = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{EpCcPy"), a2, 0, a7, a6);
        mapleStatEffect22.expinc = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\u0016)\u00077\r"), a2, 0, a7, a6);
        mapleStatEffect21.exp = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("pIe"), a2, 0, a7, a6);
        mapleStatEffect21.range = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001c8\u0000>\u000b"), a2, 0, a7, a6);
        mapleStatEffect20.morph = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("x^gA}"), a2, 0, a7, a6);
        mapleStatEffect20.cp = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO(":\u001e"), a2, 0, a7, a6);
        mapleStatEffect19.cosmetic = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("RzBxTaXv"), a2, 0, a7, a6);
        mapleStatEffect19.er = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\u001c"), a2, 0, a7, a6);
        mapleStatEffect18.slotCount = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("f]zEV^`_a"), a2, 0, a7, a6);
        mapleStatEffect18.preventslip = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001e+\u000b/\u000b7\u001a*\u00020\u001e"), a2, 0, a7, a6);
        mapleStatEffect17.useLevel = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("DfTYTcTy"), a2, 0, a7, a6);
        mapleStatEffect17.nuffSkill = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0000,\b?=2\u00075\u0002"), a2, 0, a7, a6);
        mapleStatEffect16.familiarTarget = (byte)(MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Wt\\|]|PgatBfXcTFZ|]yetCrTa"), a2, 0, a7, a6) + 1);
        mapleStatEffect16.mobCount = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("4\u0001;-6\u001b7\u001a"), a2, 1, a7, a6);
        mapleStatEffect15.immortal = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Xx\\zCaPy"), a2, 0, a7, a6);
        mapleStatEffect15.iceGageCon = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\r<)8\t<-6\u0000"), a2, 0, a7, a6);
        mapleStatEffect14.expR = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("TmAG"), a2, 0, a7, a6);
        mapleStatEffect14.reqGuildLevel = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001c<\u001f\u001e\u001b0\u0002=\"<\u0018<\u0002"), a2, 0, a7, a6);
        mapleStatEffect13.period = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("ApC|^q"), a2, 0, a7, a6);
        mapleStatEffect13.type = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("-\u0017)\u000b"), a2, 0, a7, a6);
        mapleStatEffect12.bs = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Sf"), a2, 0, a7, a6);
        mapleStatEffect12.attackCount = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u000f-\u001a8\r2-6\u001b7\u001a"), a2, 1, a7, a6);
        mapleStatEffect11.bulletCount = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("wDy]pEV^`_a"), a2, 1, a7, a6);
        mapleStatEffect11.ItemSkill = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001d2\u00075\u0002"), a2, 0, a7, a6);
        mapleStatEffect10.ItemSkillLevel = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("B~Xy]yTcTy"), a2, 0, a7, a6);
        mapleStatEffect10.mdR = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0003=<"), a2, 0, a7, a6);
        mapleStatEffect9.coolTimeR = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("v^z]AXxTG"), a2, 0, a7, a6);
        mapleStatEffect9.psdJump = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001e*\n\u0013\u001b4\u001e"), a2, 0, a7, a6);
        mapleStatEffect8.psdSpeed = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("AfUFApTq"), a2, 0, a7, a6);
        mapleStatEffect8.pddX = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO(")\n=6"), a2, 0, a7, a6);
        mapleStatEffect7.targetPlus = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("EtCrTaayDf"), a2, 0, a7, a6);
        mapleStatEffect7.subProp = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001d,\f\t\u001c6\u001e"), a2, 0, a7, a6);
        mapleStatEffect6.mddX = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\qUM"), a2, 0, a7, a6);
        mapleStatEffect6.accX = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("8\r:6"), a2, 0, a7, a6);
        mapleStatEffect5.indieDamR = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("|_qXput\\G"), a2, 0, a7, a6);
        mapleStatEffect5.kp = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("2\u001e"), a2, 0, a7, a6);
        int n3 = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("eC|Rpd{Xa"), a2, 0, a7, a6);
        if (n3 > 0) {
            mapleStatEffect2 = mapleStatEffect3;
            mapleStatEffect3.price = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001e+\u0007:\u000b"), a2, 0, a7, a6) * n3;
            mapleStatEffect3.extendPrice = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("pIaT{UEC|Rp"), a2, 0, a7, a6) * n3;
        } else {
            mapleStatEffect2 = mapleStatEffect3;
            MapleStatEffect mapleStatEffect40 = mapleStatEffect3;
            mapleStatEffect40.price = 0;
            mapleStatEffect40.extendPrice = 0;
        }
        if (mapleStatEffect2.skill) {
            int n4;
            switch (a3) {
                case 1100002: 
                case 1100003: 
                case 1120013: 
                case 1200002: 
                case 1200003: 
                case 1211002: 
                case 1300002: 
                case 1300003: 
                case 2111007: 
                case 2211007: 
                case 2311007: 
                case 3100001: 
                case 3120008: 
                case 3200001: 
                case 11101002: 
                case 12111007: 
                case 13101002: 
                case 22150004: 
                case 22161005: 
                case 22181004: 
                case 23100006: 
                case 23120012: 
                case 24100003: 
                case 32001001: 
                case 32111010: 
                case 33100009: {
                    mapleStatEffect3.mobCount = (byte)6;
                    n4 = a3;
                    break;
                }
                case 35111004: 
                case 35121005: 
                case 35121013: {
                    mapleStatEffect3.attackCount = (byte)6;
                    mapleStatEffect3.bulletCount = (byte)6;
                }
                default: {
                    n4 = a3;
                }
            }
            if (GameConstants.isNoDelaySkill(n4)) {
                mapleStatEffect3.mobCount = (byte)6;
            }
        }
        if (!mapleStatEffect3.skill && mapleStatEffect3.duration > -1) {
            mapleStatEffect = mapleStatEffect3;
            mapleStatEffect3.overTime = true;
        } else {
            MapleStatEffect mapleStatEffect41 = mapleStatEffect3;
            mapleStatEffect41.duration *= 1000;
            mapleStatEffect41.subTime *= 1000;
            mapleStatEffect3.overTime = a52 || mapleStatEffect3.isMorph() || mapleStatEffect3.isPirateMorph() || mapleStatEffect3.isFinalAttack() || mapleStatEffect3.isAngel() || mapleStatEffect3.getSummonMovementType() != null || mapleStatEffect3.is\u5e78\u904b\u9ab0\u5b50() || SkillConstants.isBuffSkill(a3) || mapleStatEffect3.isLinkSkills();
            mapleStatEffect = mapleStatEffect3;
        }
        mapleStatEffect.mastery = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u00038\u001d-\u000b+\u0017"), a2, 0, a7, a6);
        MapleStatEffect mapleStatEffect42 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect43 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect44 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect45 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect46 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect47 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect48 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect49 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect50 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect51 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect52 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect53 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect54 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect55 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect56 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect57 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect58 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect59 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect60 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect61 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect62 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect63 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect64 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect65 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect66 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect67 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect68 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect69 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect70 = mapleStatEffect3;
        mapleStatEffect3.watk = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("ePq"), a2, 0, a7, a6);
        mapleStatEffect70.wdef = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001e=\n"), a2, 0, a7, a6);
        mapleStatEffect70.matk = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("xPq"), a2, 0, a7, a6);
        mapleStatEffect69.mdef = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0003=\n"), a2, 0, a7, a6);
        mapleStatEffect69.ehp = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("TxYe"), a2, 0, a7, a6);
        mapleStatEffect68.emp = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\u00034\u001e"), a2, 0, a7, a6);
        mapleStatEffect68.ewatk = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("TePq"), a2, 0, a7, a6);
        mapleStatEffect67.ematk = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\u00038\n"), a2, 0, a7, a6);
        mapleStatEffect67.ewdef = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("TeUq"), a2, 0, a7, a6);
        mapleStatEffect66.emdef = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\u0003=\n"), a2, 0, a7, a6);
        mapleStatEffect66.acc = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("tRv"), a2, 0, a7, a6);
        mapleStatEffect65.avoid = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u000b/\u000f"), a2, 0, a7, a6);
        mapleStatEffect65.speed = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("fApTq"), a2, 0, a7, a6);
        mapleStatEffect64.jump = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("3\u001b4\u001e"), a2, 0, a7, a6);
        mapleStatEffect64.indiePad = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TEPq"), a2, 0, a7, a6);
        mapleStatEffect63.indieMad = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<#8\n"), a2, 0, a7, a6);
        mapleStatEffect63.indieMhp = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TXYe"), a2, 0, a7, a6);
        mapleStatEffect62.indieMmp = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<#4\u001e"), a2, 0, a7, a6);
        mapleStatEffect62.indieSpeed = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TFApTq"), a2, 0, a7, a6);
        mapleStatEffect61.indieJump = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u00077\n0\u000b\u0013\u001b4\u001e"), a2, 0, a7, a6);
        mapleStatEffect61.indieAcc = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TTRv"), a2, 0, a7, a6);
        mapleStatEffect60.indieEva = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<+/\u000f"), a2, 0, a7, a6);
        mapleStatEffect60.indiePdd = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TEUq"), a2, 0, a7, a6);
        mapleStatEffect59.indieMdd = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<#=\n"), a2, 0, a7, a6);
        mapleStatEffect59.indieAllStat = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TT]ybaPa"), a2, 0, a7, a6);
        mapleStatEffect58.indieMhpR = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u00077\n0\u000b\u0014\u0006)<"), a2, 0, a7, a6);
        mapleStatEffect58.indieMmpR = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("|_qXp|xAG"), a2, 0, a7, a6);
        mapleStatEffect57.indieSTR = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<=\r<"), a2, 0, a7, a6);
        mapleStatEffect57.indieDEX = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TQtM"), a2, 0, a7, a6);
        mapleStatEffect56.indieINT = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<'\u0017:"), a2, 0, a7, a6);
        mapleStatEffect56.indieLUK = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TYd^"), a2, 0, a7, a6);
        mapleStatEffect55.indiePdd = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<>=\n"), a2, 0, a7, a6);
        mapleStatEffect55.indieMdd = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{U|TXUq"), a2, 0, a7, a6);
        mapleStatEffect54.indieBooster = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000=\u0007<,6\u0001*\u001a<\u001c"), a2, 0, a7, a6);
        mapleStatEffect54.str = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("fEg"), a2, 0, a7, a6);
        mapleStatEffect53.dex = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\n<\u0016"), a2, 0, a7, a6);
        mapleStatEffect53.int_ = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("|_a"), a2, 0, a7, a6);
        mapleStatEffect52.luk = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0002,\u0005"), a2, 0, a7, a6);
        mapleStatEffect52.strX = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("BaCM"), a2, 0, a7, a6);
        mapleStatEffect51.dexX = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("=\u000b!6"), a2, 0, a7, a6);
        mapleStatEffect51.intX = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("X{EM"), a2, 0, a7, a6);
        mapleStatEffect50.lukX = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("5\u001b26"), a2, 0, a7, a6);
        mapleStatEffect50.expBuff = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("pIes`Ws"), a2, 0, a7, a6);
        mapleStatEffect49.expBuff_add = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\u0016),,\b?/=\n"), a2, 0, a7, a6);
        mapleStatEffect49.cashup = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("RtB}s`Ws"), a2, 0, a7, a6);
        mapleStatEffect48.itemup = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u001a<\u0003,\u001e;\u00170\u001a<\u0003"), a2, 0, a7, a6);
        mapleStatEffect48.itemCode = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("XaTxrzUp"), a2, 0, a7, a6);
        mapleStatEffect47.itemRange = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0007-\u000b4<8\u0000>\u000b"), a2, 0, a7, a6);
        mapleStatEffect47.mesoup = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\pBzDeSlXaTx"), a2, 0, a7, a6);
        mapleStatEffect46.berserk = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\f<\u001c*\u000b+\u0005"), a2, 0, a7, a6);
        mapleStatEffect46.berserk2 = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("SpCfTgZ'"), a2, 0, a7, a6);
        mapleStatEffect45.booster = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\f6\u0001*\u001a<\u001c"), a2, 0, a7, a6);
        mapleStatEffect45.lifeId = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("]|Wpxq"), a2, 0, a7, a6);
        mapleStatEffect44.inflation = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u00077\b5\u000f-\u00076\u0000"), a2, 0, a7, a6);
        mapleStatEffect44.imhp = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("XxYe"), a2, 0, a7, a6);
        mapleStatEffect43.immp = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u00034\u001e"), a2, 0, a7, a6);
        mapleStatEffect43.illusion = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Xy]`B|^{"), a2, 0, a7, a6);
        mapleStatEffect42.consumeOnPickup = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\r6\u0000*\u001b4\u000b\u0016\u0000\t\u0007:\u0005,\u001e"), a2, 0, a7, a6);
        mapleStatEffect42.plusExpRate = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("e]`BPIectEp"), a2, 0, a7, a6);
        mapleStatEffect3.soulmpCon = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001d6\u001b5\u0003)-6\u0000"), a2, 0, a7, a6);
        mapleStatEffect3.onActive = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("^{pvE|Gp"), a2, 0, a7, a6);
        if (mapleStatEffect3.consumeOnPickup == 1 && MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001e8\u001c-\u0017"), a2, 0, a7, a6) > 0) {
            mapleStatEffect3.consumeOnPickup = 2;
        }
        mapleStatEffect3.charColor = 0;
        Object a52 = MapleDataTool.getString(SkillEntry.ALLATORIxDEMO("vYtCV^y^g"), a2, null);
        if (a52 != null) {
            mapleStatEffect3.charColor |= Integer.parseInt("0x" + ((String)a52).substring(0, 2));
            mapleStatEffect3.charColor |= Integer.parseInt("0x" + ((String)a52).substring(2, 4) + "00");
            mapleStatEffect3.charColor |= Integer.parseInt("0x" + ((String)a52).substring(4, 6) + "0000");
            mapleStatEffect3.charColor |= Integer.parseInt("0x" + ((String)a52).substring(6, 8) + "000000");
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MapleStatEffect mapleStatEffect71 = mapleStatEffect3;
            mapleStatEffect71.B = new EnumMap<MapleTrait.MapleTraitType, Integer>(MapleTrait.MapleTraitType.class);
            a52 = MapleTrait.MapleTraitType.values();
            n3 = ((MapleTrait.MapleTraitType[])a52).length;
            int n5 = n2 = 0;
            while (n5 < n3) {
                object = a52[n2];
                int n6 = MapleStatEffect.ALLATORIxDEMO(object.getName() + "EXP", a2, 0, a7, a6);
                if (n6 != 0) {
                    mapleStatEffect3.B.put((MapleTrait.MapleTraitType)((Object)object), n6);
                }
                n5 = ++n2;
            }
        }
        MapleStatEffect mapleStatEffect72 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect73 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect74 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect75 = mapleStatEffect3;
        mapleStatEffect75.recipe = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("+\u000b:\u0007)\u000b"), a2, 0, a7, a6);
        mapleStatEffect75.recipeUseCount = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("CpR|ApdfTV^`_a"), a2, 0, a7, a6);
        mapleStatEffect74.recipeValidDay = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("+\u000b:\u0007)\u000b\u000f\u000f5\u0007=*8\u0017"), a2, 0, a7, a6);
        mapleStatEffect74.reqSkillLevel = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("gTdb~Xy]YTcTy"), a2, 0, a7, a6);
        mapleStatEffect73.effectedOnAlly = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("<\b?\u000b:\u001a<\n\u0016\u0000\u0018\u00025\u0017"), a2, 0, a7, a6);
        mapleStatEffect73.effectedOnEnemy = (byte)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("pWsTvEpUZ_P_p\\l"), a2, 0, a7, a6);
        mapleStatEffect72.ignoreMobDamR = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0007>\u00006\u001c<#6\f\u001d\u000f4<"), a2, 0, a7, a6);
        mapleStatEffect72.damAbsorbShieldR = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Ut\\TSf^gSFY|TyUG"), a2, 0, a7, a6);
        mapleStatEffect3.ignoreMobpdpR = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0007>\u00006\u001c<#6\f)\n)<"), a2, 0, a7, a6);
        a52 = new ArrayList(5);
        if (MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("AzXf^{"), a2, 0, a7, a6) > 0) {
            a52.add(MapleBuffStat.POISON);
        }
        if (MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("*\u000b8\u0002"), a2, 0, a7, a6) > 0) {
            a52.add(MapleBuffStat.SEAL);
        }
        if (MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("UtC~_pBf"), a2, 0, a7, a6) > 0) {
            a52.add(MapleBuffStat.DARKNESS);
        }
        if (MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO(".\u000b8\u00057\u000b*\u001d"), a2, 0, a7, a6) > 0) {
            a52.add(MapleBuffStat.WEAKEN);
        }
        if (MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("vDgBp"), a2, 0, a7, a6) > 0) {
            a52.add(MapleBuffStat.CURSE);
        }
        MapleStatEffect mapleStatEffect76 = mapleStatEffect3;
        mapleStatEffect76.g = a52;
        mapleStatEffect76.k = new ArrayList<Integer>();
        int n7 = n3 = 0;
        while ((n2 = MapleStatEffect.ALLATORIxDEMO(String.valueOf(n7), a2, 0, a7, a6)) > 0) {
            mapleStatEffect3.k.add(n2);
            n7 = ++n3;
        }
        MapleData mapleData3 = a2.getChildByPath(ConcurrentEnumMap.ALLATORIxDEMO("^"));
        if (mapleData3 != null && mapleData3.getChildren().size() > 0) {
            mapleData2 = a2;
            MapleStatEffect mapleStatEffect77 = mapleStatEffect3;
            mapleStatEffect77.mobSkill = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\zSFZ|]y"), mapleData3, 0, a7, a6);
            mapleStatEffect77.mobSkillLevel = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0002<\u0018<\u0002"), mapleData3, 0, a7, a6);
        } else {
            mapleStatEffect3.mobSkill = 0;
            mapleStatEffect3.mobSkillLevel = 0;
            mapleData2 = a2;
        }
        Object object2 = mapleData2.getChildByPath(SkillEntry.ALLATORIxDEMO("Ct_q^xa|R~De"));
        if (object2 != null) {
            mapleStatEffect3.a = new ArrayList<Integer>();
            object = object2.iterator();
            Object object3 = object;
            while (object3.hasNext()) {
                MapleData mapleData4 = (MapleData)object.next();
                object3 = object;
                mapleStatEffect3.a.add(MapleDataTool.getInt(mapleData4));
            }
        }
        if ((object = a2.getChildByPath(ConcurrentEnumMap.ALLATORIxDEMO("5\u001a"))) != null) {
            mapleStatEffect3.lt = (Point)object.getData();
            mapleStatEffect3.rb = (Point)a2.getChildByPath(SkillEntry.ALLATORIxDEMO("Cw")).getData();
        }
        if ((mapleData = a2.getChildByPath(ConcurrentEnumMap.ALLATORIxDEMO("\r6\u0000"))) != null) {
            mapleStatEffect3.d = new ArrayList();
            Object object4 = a52 = mapleData.iterator();
            while (object4.hasNext()) {
                mapleData3 = (MapleData)a52.next();
                object4 = a52;
                mapleStatEffect3.d.add(new Pair<Integer, Integer>(MapleDataTool.getInt(SkillEntry.ALLATORIxDEMO("BXPe"), mapleData3, 0), MapleDataTool.getInt(ConcurrentEnumMap.ALLATORIxDEMO("<#8\u001e"), mapleData3, 999999999)));
            }
        }
        if ((a52 = a2.getChildByPath(SkillEntry.ALLATORIxDEMO("Wt\\|]|Pg"))) != null) {
            MapleStatEffect mapleStatEffect78 = mapleStatEffect3;
            mapleStatEffect78.fatigueChange = (short)(MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000:(8\u001a0\t,\u000b"), (MapleData)a52, 0, a7, a6) - MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("UpRSPaXrDp"), (MapleData)a52, 0, a7, a6));
            mapleStatEffect78.familiarTarget = (byte)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("-\u000f+\t<\u001a"), (MapleData)a52, 0, a7, a6);
            mapleData3 = a52.getChildByPath(SkillEntry.ALLATORIxDEMO("EtCrTa}|Ba"));
            if (mapleData3 != null) {
                mapleStatEffect3.K = new ArrayList<Integer>();
                Object object5 = object2 = mapleData3.iterator();
                while (object5.hasNext()) {
                    object = (MapleData)object2.next();
                    object5 = object2;
                    mapleStatEffect3.K.add(MapleDataTool.getInt((MapleData)object, 0));
                }
            }
        } else {
            mapleStatEffect3.fatigueChange = 0;
        }
        int n8 = 0;
        object2 = a2.getChildByPath(ConcurrentEnumMap.ALLATORIxDEMO("+\u000b.\u000f+\n"));
        if (object2 != null) {
            mapleStatEffect3.rewardMeso = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\pBz"), (MapleData)object2, 0, a7, a6);
            object = object2.getChildByPath(ConcurrentEnumMap.ALLATORIxDEMO(":\u000f*\u000b"));
            if (object != null) {
                mapleStatEffect3.ALLATORIxDEMO = new ArrayList<Triple<Integer, Integer, Integer>>();
                Object object6 = a52 = object.iterator();
                while (object6.hasNext()) {
                    object2 = (MapleData)a52.next();
                    object6 = a52;
                    mapleStatEffect3.ALLATORIxDEMO.add(new Triple<Integer, Integer, Integer>(MapleDataTool.getInt(SkillEntry.ALLATORIxDEMO("Xq"), (MapleData)object2, 0), MapleDataTool.getInt(ConcurrentEnumMap.ALLATORIxDEMO("\r6\u001b7\u001a"), (MapleData)object2, 0), MapleDataTool.getInt(SkillEntry.ALLATORIxDEMO("Ag^e"), (MapleData)object2, 0)));
                    n8 += MapleDataTool.getInt(ConcurrentEnumMap.ALLATORIxDEMO(")\u001c6\f"), (MapleData)object2, 0);
                }
            }
        } else {
            mapleStatEffect3.rewardMeso = 0;
        }
        MapleStatEffect mapleStatEffect79 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect80 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect81 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect82 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect83 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect84 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect85 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect86 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect87 = mapleStatEffect3;
        MapleStatEffect mapleStatEffect88 = mapleStatEffect3;
        mapleStatEffect88.totalprob = n8;
        mapleStatEffect88.cr = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("Rg"), a2, 0, a7, a6);
        mapleStatEffect87.s = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001d"), a2, 0, a7, a6);
        mapleStatEffect87.t = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("a"), a2, 0, a7, a6);
        mapleStatEffect86.u = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u001b"), a2, 0, a7, a6);
        mapleStatEffect86.v = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("c"), a2, 0, a7, a6);
        mapleStatEffect85.w = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0019"), a2, 0, a7, a6);
        mapleStatEffect85.x = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("m"), a2, 0, a7, a6);
        mapleStatEffect84.y = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0017"), a2, 0, a7, a6);
        mapleStatEffect84.z = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("o"), a2, 0, a7, a6);
        mapleStatEffect83.damage = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("=\u000f4\u000f>\u000b"), a2, 100, a7, a6);
        mapleStatEffect83.PVPdamage = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("EgEUt\\tVp"), a2, 0, a7, a6);
        mapleStatEffect82.incPVPdamage = (short)MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("0\u0000:>\u000f>\u001d\u000f4\u000f>\u000b"), a2, 0, a7, a6);
        mapleStatEffect82.selfDestruction = (short)MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("fTyWQTfEgDvE|^{"), a2, 0, a7, a6);
        mapleStatEffect81.bulletConsume = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\f,\u00025\u000b--6\u0000*\u001b4\u000b"), a2, 0, a7, a6);
        mapleStatEffect81.moneyCon = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\z_pHV^{"), a2, 0, a7, a6);
        mapleStatEffect80.fixdamage = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\b0\u0016=\u000f4\u000f>\u000b"), a2, 0, a7, a6);
        mapleStatEffect80.itemCon = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("|Ep\\V^{"), a2, 0, a7, a6);
        mapleStatEffect79.itemConNo = MapleStatEffect.ALLATORIxDEMO(ConcurrentEnumMap.ALLATORIxDEMO("\u0007-\u000b4-6\u0000\u0017\u0001"), a2, 0, a7, a6);
        mapleStatEffect3.moveTo = MapleStatEffect.ALLATORIxDEMO(SkillEntry.ALLATORIxDEMO("\\zGpez"), a2, -1, a7, a6);
        mapleStatEffect79.monsterStatus = new EnumMap<MonsterStatus, Integer>(MonsterStatus.class);
        if (mapleStatEffect3.overTime && mapleStatEffect3.getSummonMovementType() == null && !mapleStatEffect3.isEnergyCharge()) {
            ArrayList<Pair<MapleBuffStat, Integer>> arrayList = a42;
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.WATK, Integer.valueOf(mapleStatEffect3.watk));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.WDEF, Integer.valueOf(mapleStatEffect3.wdef));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MATK, Integer.valueOf(mapleStatEffect3.matk));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.MDEF, Integer.valueOf(mapleStatEffect3.mdef));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.ACC, Integer.valueOf(mapleStatEffect3.acc));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.AVOID, Integer.valueOf(mapleStatEffect3.avoid));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList, MapleBuffStat.SPEED, a3 == 32120001 || a3 == 32101003 ? Integer.valueOf(mapleStatEffect3.x) : Integer.valueOf(mapleStatEffect3.speed));
            ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = a42;
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList2, MapleBuffStat.JUMP, Integer.valueOf(mapleStatEffect3.jump));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList2, MapleBuffStat.MAXHP, (int)((double)mapleStatEffect3.mhpR + mapleStatEffect3.mhp_temp));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList2, MapleBuffStat.MAXMP, (int)((double)mapleStatEffect3.mmpR + mapleStatEffect3.mmp_temp));
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList2, MapleBuffStat.EXPRATE, mapleStatEffect3.expBuff);
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList2, MapleBuffStat.EXPRATE_ADD, mapleStatEffect3.expBuff_add);
            MapleStatEffect mapleStatEffect89 = mapleStatEffect3;
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList2, MapleBuffStat.ACASH_RATE, mapleStatEffect89.cashup);
            if (mapleStatEffect89.itemup >= 1) {
                MapleStatEffect.addBuffStatPairToListIfNotZero(a42, MapleBuffStat.DROP_RATE, mapleStatEffect3.prob);
            }
            if (mapleStatEffect3.mesoup >= 1) {
                MapleStatEffect.addBuffStatPairToListIfNotZero(a42, MapleBuffStat.MESO_RATE, mapleStatEffect3.prob);
            }
            ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = a42;
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList3, MapleBuffStat.BOOSTER, mapleStatEffect3.booster);
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList3, MapleBuffStat.BERSERK_FURY, mapleStatEffect3.berserk2);
            MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList3, MapleBuffStat.ILLUSION, mapleStatEffect3.illusion);
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = a42;
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_DAMAGE_PERCENT, mapleStatEffect3.indieDamR);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.HP_LOSS_GUARD, Integer.valueOf(mapleStatEffect3.thaw));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.PYRAMID_PQ, mapleStatEffect3.berserk);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ENHANCED_MAXHP, mapleStatEffect3.ehp);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ENHANCED_MAXMP, mapleStatEffect3.emp);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ENHANCED_WATK, mapleStatEffect3.ewatk);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ENHANCED_MATK, mapleStatEffect3.ematk);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ENHANCED_WDEF, mapleStatEffect3.ewdef);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ENHANCED_MDEF, mapleStatEffect3.emdef);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.GIANT_POTION, Integer.valueOf(mapleStatEffect3.inflation));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.STR, Integer.valueOf(mapleStatEffect3.str));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.DEX, Integer.valueOf(mapleStatEffect3.dex));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INT, Integer.valueOf(mapleStatEffect3.int_));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.LUK, Integer.valueOf(mapleStatEffect3.luk));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_ATK, mapleStatEffect3.indiePad);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_MATK, mapleStatEffect3.indieMad);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.HP_BOOST, Integer.valueOf(mapleStatEffect3.imhp));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.MP_BOOST, Integer.valueOf(mapleStatEffect3.immp));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.HP_BOOST, mapleStatEffect3.indieMhp);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.MP_BOOST, mapleStatEffect3.indieMmp);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.PVP_DAMAGE, mapleStatEffect3.incPVPdamage);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_JUMP, mapleStatEffect3.indieJump);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_SPEED, mapleStatEffect3.indieSpeed);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_ACC, mapleStatEffect3.indieAcc);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_AVOID, mapleStatEffect3.indieEva);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.ANGEL_STAT, mapleStatEffect3.indieAllStat);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_STR, mapleStatEffect3.indieSTR);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_DEX, mapleStatEffect3.indieDEX);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_INT, mapleStatEffect3.indieINT);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_LUK, mapleStatEffect3.indieLUK);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_PDD, mapleStatEffect3.indiePdd);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INDIE_MDD, mapleStatEffect3.indieMdd);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.PVP_ATTACK, Integer.valueOf(mapleStatEffect3.PVPdamage));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.INVINCIBILITY, Integer.valueOf(mapleStatEffect3.immortal));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.NO_SLIP, Integer.valueOf(mapleStatEffect3.preventslip));
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList4, MapleBuffStat.FAMILIAR_SHADOW, mapleStatEffect3.charColor > 0 ? 1 : 0);
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList5 = a42;
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList5, MapleBuffStat.HP_BOOST_PERCENT, mapleStatEffect3.indieMhpR);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList5, MapleBuffStat.MP_BOOST_PERCENT, mapleStatEffect3.indieMmpR);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList5, MapleBuffStat.EXP_BUFF_RATE, mapleStatEffect3.plusExpRate);
                MapleStatEffect.addBuffStatPairToListIfNotZero(arrayList5, MapleBuffStat.INDIE_BOOSTER, mapleStatEffect3.indieBooster);
            }
        }
        if (mapleStatEffect3.skill) {
            int n9;
            MapleStatEffect mapleStatEffect90 = mapleStatEffect3;
            object = BuffClassFetcher.getHandleMethod(mapleStatEffect90, a3);
            if (mapleStatEffect90.clear) {
                a42.clear();
            }
            if (object != null) {
                n9 = a3;
                a42.addAll((Collection<Pair<MapleBuffStat, Integer>>)object);
            } else {
                switch (a3) {
                    case 90001006: {
                        mapleStatEffect3.monsterStatus.put(MonsterStatus.FREEZE, 1);
                        mapleStatEffect3.duration *= 2;
                        n9 = a3;
                        break;
                    }
                    case 90001002: {
                        mapleStatEffect3.monsterStatus.put(MonsterStatus.SPEED, mapleStatEffect3.x);
                        n9 = a3;
                        break;
                    }
                    case 90001003: {
                        mapleStatEffect3.monsterStatus.put(MonsterStatus.POISON, 1);
                        n9 = a3;
                        break;
                    }
                    case 80001034: 
                    case 80001035: 
                    case 80001036: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.VIRTUE_EFFECT, 1));
                        n9 = a3;
                        break;
                    }
                    case 90001005: {
                        mapleStatEffect3.monsterStatus.put(MonsterStatus.SEAL, 1);
                        n9 = a3;
                        break;
                    }
                    case 80001040: {
                        mapleStatEffect3.moveTo = mapleStatEffect3.x;
                        n9 = a3;
                        break;
                    }
                    case 80001089: {
                        mapleStatEffect3.duration = 2100000000;
                        n9 = a3;
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOARING, 1));
                        break;
                    }
                    case 10001075: 
                    case 50001075: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ECHO_OF_HERO, mapleStatEffect3.x));
                        n9 = a3;
                        break;
                    }
                    case 80001079: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WATK, Integer.valueOf(mapleStatEffect3.damage)));
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MATK, Integer.valueOf(mapleStatEffect3.damage)));
                        mapleStatEffect3.duration = 30000;
                        n9 = a3;
                        break;
                    }
                    case 80001080: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WDEF, mapleStatEffect3.x));
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MDEF, mapleStatEffect3.y));
                        mapleStatEffect3.duration = 30000;
                        n9 = a3;
                        break;
                    }
                    case 80001081: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.EXPRATE, mapleStatEffect3.x));
                        mapleStatEffect3.duration = 30000;
                        n9 = a3;
                        break;
                    }
                    case 50001214: 
                    case 80001140: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, mapleStatEffect3.prop));
                        n9 = a3;
                        break;
                    }
                    default: {
                        n9 = a3;
                    }
                }
            }
            if (JobConstants.isBeginnerJob(n9 / 10000)) {
                switch (a3 % 10000) {
                    case 1087: {
                        mapleStatEffect3.duration = 2100000000;
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_ATK, 10));
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_MATK, 10));
                        break;
                    }
                    case 1085: 
                    case 1090: {
                        mapleStatEffect3.duration = 2100000000;
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_ATK, 5));
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_MATK, 5));
                        break;
                    }
                    case 180: 
                    case 1179: {
                        mapleStatEffect3.duration = 2100000000;
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_ATK, 12));
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_MATK, 12));
                        break;
                    }
                    case 1105: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ICE_SKILL, 1));
                        mapleStatEffect3.duration = 2100000000;
                        break;
                    }
                    case 93: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HIDDEN_POTENTIAL, 1));
                        break;
                    }
                    case 8001: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, mapleStatEffect3.x));
                        break;
                    }
                    case 1005: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ECHO_OF_HERO, mapleStatEffect3.x));
                        break;
                    }
                    case 1011: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BERSERK_FURY, mapleStatEffect3.x));
                        break;
                    }
                    case 1010: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DIVINE_BODY, 1));
                        break;
                    }
                    case 1001: {
                        if (a3 / 10000 == 3001 || a3 / 10000 == 3000) {
                            a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INFILTRATE, mapleStatEffect3.x));
                            break;
                        }
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.RECOVERY, mapleStatEffect3.x));
                        break;
                    }
                    case 8003: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAXHP, mapleStatEffect3.x));
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MAXMP, mapleStatEffect3.x));
                        break;
                    }
                    case 8004: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBAT_ORDERS, mapleStatEffect3.x));
                        break;
                    }
                    case 8005: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HOLY_SHIELD, 1));
                        break;
                    }
                    case 8006: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED_INFUSION, mapleStatEffect3.x));
                        break;
                    }
                    case 103: {
                        mapleStatEffect3.monsterStatus.put(MonsterStatus.STUN, 1);
                        break;
                    }
                    case 99: 
                    case 104: {
                        mapleStatEffect3.monsterStatus.put(MonsterStatus.FREEZE, 1);
                        mapleStatEffect3.duration *= 2;
                        break;
                    }
                    case 8002: {
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHARP_EYES, (mapleStatEffect3.x << 8) + mapleStatEffect3.criticaldamageMax));
                        break;
                    }
                    case 1026: 
                    case 1142: {
                        mapleStatEffect3.duration = 2100000000;
                        a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOARING, 1));
                    }
                    default: {
                        break;
                    }
                }
            }
        } else {
            switch (a3) {
                case 2022746: 
                case 2022747: {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList = a42;
                    arrayList.clear();
                    arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PYRAMID_PQ, 1));
                    break;
                }
            }
        }
        if (mapleStatEffect3.isPoison()) {
            mapleStatEffect3.monsterStatus.put(MonsterStatus.POISON, 1);
        }
        if ((mapleStatEffect3.isMorph() || mapleStatEffect3.isPirateMorph()) && !mapleStatEffect3.clear) {
            a42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MORPH, mapleStatEffect3.getMorph()));
        }
        a42.trimToSize();
        mapleStatEffect3.statups = a42;
        return mapleStatEffect3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isFinalAttack() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 11101002: 
            case 13101002: 
            case 21120002: {
                return a2.skill;
            }
        }
        return false;
    }

    public /* synthetic */ int getExpBuffAdd() {
        MapleStatEffect a2;
        return a2.expBuff_add;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isCombo() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1111002: 
            case 11111001: {
                return a2.skill;
            }
        }
        return false;
    }

    public final /* synthetic */ boolean makeChanceResult_z(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.z);
    }

    private /* synthetic */ boolean ALLATORIxDEMO(MapleCharacter a2, MapleCharacter a3, boolean a4, Point a5) {
        MapleStatEffect a6;
        return a6.applyTo(a2, a3, a4, a5, a6.duration);
    }

    public final /* synthetic */ short getIgnoreMob() {
        MapleStatEffect a2;
        return a2.ignoreMob;
    }

    public final /* synthetic */ byte getMastery() {
        MapleStatEffect a2;
        return a2.mastery;
    }

    public final /* synthetic */ boolean applyReturnScroll(MapleCharacter a2) {
        MapleStatEffect a3;
        if (a3.moveTo != -1) {
            MapleMap mapleMap;
            MapleCharacter mapleCharacter;
            if (a3.moveTo == 999999999) {
                MapleCharacter mapleCharacter2 = a2;
                mapleCharacter = mapleCharacter2;
                mapleMap = mapleCharacter2.getMap().getReturnMap();
            } else {
                mapleMap = ChannelServer.getInstance(a2.getClient().getWorld(), a2.getClient().getChannel()).getMapFactory().getMap(a3.moveTo);
                if (mapleMap.getId() / 10000000 != 60 && a2.getMapId() / 10000000 != 61 && mapleMap.getId() / 10000000 != 21 && a2.getMapId() / 10000000 != 20 && mapleMap.getId() / 10000000 != a2.getMapId() / 10000000) {
                    if (mapleMap.getId() == 120000000 && a2.getMapId() != 120000000) {
                        MapleMap mapleMap2 = mapleMap;
                        a2.changeMap(mapleMap2, mapleMap2.getPortal(0));
                        return true;
                    }
                    if (mapleMap.getId() != 120000000 && a2.getMapId() == 120000000) {
                        MapleMap mapleMap3 = mapleMap;
                        a2.changeMap(mapleMap3, mapleMap3.getPortal(0));
                        return true;
                    }
                    if (mapleMap.getId() == 150000000 && a3.sourceid == 20031203) {
                        MapleMap mapleMap4 = mapleMap;
                        a2.changeMap(mapleMap4, mapleMap4.getPortal(0));
                        return true;
                    }
                    return false;
                }
                mapleCharacter = a2;
            }
            MapleMap mapleMap5 = mapleMap;
            mapleCharacter.changeMap(mapleMap5, mapleMap5.getPortal(0));
            return true;
        }
        return false;
    }

    public final /* synthetic */ short getCriticalMin() {
        MapleStatEffect a2;
        return a2.criticaldamageMin;
    }

    public final /* synthetic */ boolean isMechDoor() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 35101005;
    }

    public final /* synthetic */ void setDuration(int a2) {
        a.duration = a2;
    }

    public final /* synthetic */ short getSpeed() {
        MapleStatEffect a2;
        return a2.speed;
    }

    public /* synthetic */ int getPassiveSpeed() {
        MapleStatEffect a2;
        return a2.psdSpeed;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, Point a3, boolean a4) {
        MapleStatEffect a5;
        MapleCharacter mapleCharacter = a2;
        return a5.applyTo(mapleCharacter, mapleCharacter, true, a3, a5.duration, false, true, a4);
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, Point a3) {
        MapleStatEffect a4;
        MapleCharacter mapleCharacter = a2;
        return a4.applyTo(mapleCharacter, mapleCharacter, true, a3, a4.duration);
    }

    public /* synthetic */ short getWDEFRate() {
        MapleStatEffect a2;
        return a2.pddR;
    }

    public final /* synthetic */ boolean makeChanceResult_er() {
        MapleStatEffect a2;
        return a2.er == 100 || Randomizer.nextInt(99) < a2.er;
    }

    public final /* synthetic */ int getCr() {
        MapleStatEffect a2;
        return a2.cr;
    }

    public final /* synthetic */ boolean isHide() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 9001004;
    }

    public final /* synthetic */ Map<MonsterStatus, Integer> getMonsterStati() {
        MapleStatEffect a2;
        return a2.monsterStatus;
    }

    private final /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleCharacter a3, boolean a4, int a5) {
        MapleStatEffect a6;
        a6.ALLATORIxDEMO(a2, a3, a4, a5, true);
    }

    public final /* synthetic */ boolean is\u9b54\u529b\u7121\u9650() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 2121004 || a2.sourceid == 2221004 || a2.sourceid == 2321004);
    }

    public final /* synthetic */ int getProb() {
        MapleStatEffect a2;
        return a2.prob;
    }

    public final /* synthetic */ int getIgnoreMobpdpR() {
        MapleStatEffect a2;
        return a2.ignoreMobpdpR;
    }

    public /* synthetic */ MapleStatEffect() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        a2.partyBuff = true;
        mapleStatEffect.clear = false;
        mapleStatEffect.range = 0;
    }

    public final /* synthetic */ boolean isInfinity() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 2121004 || a2.sourceid == 2221004 || a2.sourceid == 2321004);
    }

    public final /* synthetic */ int getMoneyCon() {
        MapleStatEffect a2;
        return a2.moneyCon;
    }

    public final /* synthetic */ int getProp() {
        MapleStatEffect a2;
        return a2.prop;
    }

    public final /* synthetic */ boolean isDragonBlink() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 22141004;
    }

    public final /* synthetic */ short getInt() {
        MapleStatEffect a2;
        return a2.int_;
    }

    public final /* synthetic */ short getWdef() {
        MapleStatEffect a2;
        return a2.wdef;
    }

    private /* synthetic */ boolean D() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 5201008;
    }

    public final /* synthetic */ short getDAMRate() {
        MapleStatEffect a2;
        return a2.damR;
    }

    public final /* synthetic */ boolean isTimeLeap() {
        MapleStatEffect a2;
        return a2.sourceid == 5121010;
    }

    public final /* synthetic */ void setPartyBuff(boolean a2) {
        a.partyBuff = a2;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleCharacter mapleCharacter = a2;
        return a3.applyTo(mapleCharacter, mapleCharacter, true, null, a3.duration);
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, int a3) {
        block10: {
            MapleStatEffect a4;
            block9: {
                if (!a4.d()) break block9;
                if (a2.getParty() == null) break block10;
                int n2 = 0;
                for (MapleCharacter object2 : a2.getMap().getCharactersThreadsafe()) {
                    if (object2.getParty() == null || !object2.getParty().equals(a2.getParty()) || !object2.isAlive()) continue;
                    ++n2;
                }
                ArrayList arrayList = new ArrayList();
                while (arrayList.size() < Math.min(n2, a4.y)) {
                    for (MapleCharacter mapleCharacter : a2.getMap().getCharactersThreadsafe()) {
                        if (!mapleCharacter.isAlive() || !mapleCharacter.getParty().equals(a2.getParty()) || arrayList.contains(mapleCharacter) || Randomizer.nextInt(a4.y) != 0) continue;
                        arrayList.add(mapleCharacter);
                    }
                }
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    MapleCharacter mapleCharacter;
                    MapleCharacter mapleCharacter2 = mapleCharacter = (MapleCharacter)iterator.next();
                    a4.applyTo(a2, mapleCharacter2, false, null, a3);
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(a4.sourceid, 2, mapleCharacter.getLevel(), a4.level));
                    if (mapleCharacter2.getBuffedValue(MapleBuffStat.MORPH) != null) continue;
                    MapleCharacter mapleCharacter3 = mapleCharacter;
                    mapleCharacter.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.showBuffEffect(mapleCharacter3.getId(), a4.sourceid, 2, mapleCharacter.getLevel(), a4.level), false);
                }
                break block10;
            }
            if (a4.I() && (a2.getParty() != null || a4.isGmBuff())) {
                Serializable serializable = a4.calculateBoundingBox(a2.getPosition(), a2.isFacingLeft());
                MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
                arrmapleMapObjectType[0] = MapleMapObjectType.PLAYER;
                List<MapleMapObject> list = a2.getMap().getMapObjectsInRect((Rectangle)serializable, Arrays.asList(arrmapleMapObjectType));
                Iterator<MapleMapObject> iterator = list.iterator();
                while (iterator.hasNext()) {
                    MapleMapObject mapleMapObject = iterator.next();
                    serializable = (MapleCharacter)mapleMapObject;
                    if (serializable == a2 || !a4.isGmBuff() && !a2.getParty().equals(((MapleCharacter)serializable).getParty())) continue;
                    if (a4.isResurrection() && !((MapleCharacter)serializable).isAlive() || !a4.isResurrection() && ((MapleCharacter)serializable).isAlive()) {
                        a4.applyTo(a2, (MapleCharacter)serializable, false, null, a3);
                        ((MapleCharacter)serializable).getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(a4.sourceid, 2, ((MapleCharacter)serializable).getLevel(), a4.level));
                        if (((MapleCharacter)serializable).getBuffedValue(MapleBuffStat.MORPH) == null) {
                            Serializable serializable2 = serializable;
                            ((MapleCharacter)serializable).getMap().broadcastMessage((MapleCharacter)serializable2, MaplePacketCreator.showBuffEffect(((MapleCharacter)serializable2).getId(), a4.sourceid, 2, ((MapleCharacter)serializable).getLevel(), a4.level), false);
                        }
                    }
                    if (!a4.isTimeLeap()) continue;
                    for (MapleCoolDownValueHolder mapleCoolDownValueHolder : ((MapleCharacter)serializable).getCooldowns()) {
                        if (mapleCoolDownValueHolder.skillId == 5121010) continue;
                        Serializable serializable3 = serializable;
                        ((MapleCharacter)serializable3).removeCooldown(mapleCoolDownValueHolder.skillId);
                        ((MapleCharacter)serializable3).getClient().sendPacket(MaplePacketCreator.skillCooldown(mapleCoolDownValueHolder.skillId, 0));
                    }
                }
            }
        }
    }

    public final /* synthetic */ void setConsumeOnPickup(int a2) {
        a.consumeOnPickup = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isShadow() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 4111002: 
            case 0x404140: 
            case 4331002: 
            case 14111000: {
                return a2.skill;
            }
        }
        return false;
    }

    public final /* synthetic */ int getEnhancedMP() {
        MapleStatEffect a2;
        return a2.emp;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean is\u5e78\u904b\u9ab0\u5b50() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 5111007: 
            case 5120012: 
            case 5211007: 
            case 5220014: 
            case 5311005: 
            case 5320007: 
            case 5711011: 
            case 5720005: 
            case 15111011: 
            case 35111013: 
            case 35120014: {
                return true;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isMechChange() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 35001001: 
            case 35101009: 
            case 35111004: 
            case 35121005: 
            case 35121013: {
                return a2.skill;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ int getMorph(MapleCharacter a2) {
        MapleStatEffect a3;
        int n2 = a3.getMorph();
        switch (n2) {
            case 1000: 
            case 1001: 
            case 1003: {
                int n3;
                if (a2.getGender() == 1) {
                    n3 = 100;
                    return n2 + n3;
                }
                n3 = 0;
                return n2 + n3;
            }
        }
        return n2;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, MapleCharacter a3, boolean a4, Point a5, int a6, boolean a7) {
        MapleStatEffect a8;
        return a8.applyTo(a2, a3, a4, a5, a6, a7, true, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isMistEruption() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 2121003: {
                return a2.skill;
            }
        }
        return false;
    }

    public final /* synthetic */ int getCooldown(MapleCharacter a22) {
        MapleStatEffect a3;
        int n2 = a3.cooldown;
        double d2 = a22.getStat().getReduceCooltimeRate(a3.getSourceId());
        double d3 = 0.0;
        if (d2 > 0.0) {
            d3 = d2 / 100.0 * (double)n2;
        }
        MapleCharacter mapleCharacter = a22;
        d2 = mapleCharacter.getStat().reduceCooltime;
        double d4 = 0.0;
        if (mapleCharacter.getStat().coolTimeR > 0) {
            d4 = (double)a22.getStat().coolTimeR / 100.0 * (double)n2;
        }
        int a22 = (int)((double)n2 - (d3 + d4 + d2));
        return Math.max(0, a22);
    }

    public final /* synthetic */ boolean isComboRecharge() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 21111009;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ boolean I() {
        MapleStatEffect a2;
        if (a2.lt == null || a2.rb == null || !a2.partyBuff) {
            return a2.d();
        }
        switch (a2.sourceid) {
            case 1211003: 
            case 1211004: 
            case 1211005: 
            case 1211006: 
            case 1211007: 
            case 1211008: 
            case 1221003: 
            case 1221004: 
            case 1311006: 
            case 2111007: 
            case 2211007: 
            case 2311007: 
            case 4311001: 
            case 4331003: 
            case 4341002: 
            case 11111007: 
            case 12101005: 
            case 21101006: 
            case 21111005: 
            case 22161005: 
            case 31121005: 
            case 32111010: 
            case 32121003: 
            case 35101009: 
            case 35121005: 
            case 61101002: 
            case 61110211: 
            case 61120007: 
            case 61121217: {
                return false;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ int H(MapleCharacter a2, MapleCharacter a32, boolean a4) {
        MapleStatEffect mapleStatEffect;
        MapleStatEffect a5;
        int n2;
        int n3;
        block13: {
            block11: {
                block12: {
                    MapleCharacter mapleCharacter;
                    n3 = 0;
                    MapleCharacter mapleCharacter2 = a2;
                    n2 = mapleCharacter2.getStat().getCurrentMaxHp();
                    if (mapleCharacter2.inPVP()) {
                        n2 = a2.getPvpMaxHp();
                    }
                    if (a5.sourceid == 9001000 || a5.sourceid == 9101000) {
                        n3 = 500000;
                    }
                    if (a5.hp == 0) break block11;
                    if (a5.skill) break block12;
                    if (a4) {
                        MapleStatEffect mapleStatEffect2 = a5;
                        n3 += mapleStatEffect2.alchemistModifyVal(a2, mapleStatEffect2.hp, true);
                        mapleCharacter = a2;
                    } else {
                        n3 += a5.hp;
                        mapleCharacter = a2;
                    }
                    if (mapleCharacter.hasDisease(MapleBuffStat.ZOMBIFY)) {
                        n3 /= 2;
                    }
                    if (a2.getPotential5() <= 10000L) break block11;
                    MapleStatEffect mapleStatEffect3 = a5;
                    mapleStatEffect = mapleStatEffect3;
                    int n4 = (int)((double)a2.getPotential5() * 1.0E-4 * (double)mapleStatEffect3.hp);
                    n3 += n4;
                    break block13;
                }
                n3 += MapleStatEffect.ALLATORIxDEMO((double)a5.hp / 100.0, a2.getStat().getTotalMagic(), 3.0, 5.0);
                if (a2.hasDisease(MapleBuffStat.ZOMBIFY)) {
                    n3 = -n3;
                }
            }
            mapleStatEffect = a5;
        }
        if (mapleStatEffect.hpR != 0.0) {
            n2 = a32.getStat().getCurrentMaxHp();
            n3 += (int)((double)n2 * a5.hpR) / (a2.hasDisease(MapleBuffStat.ZOMBIFY) ? 2 : 1);
        }
        if (a4 && a5.hpCon != 0) {
            n3 -= a5.hpCon;
        }
        switch (a5.sourceid) {
            case 4211001: {
                PlayerStats playerStats = a2.getStat();
                int a32 = a5.getY() + 100;
                n3 = (int)(((double)((Randomizer.rand(1, 100) + 100) * playerStats.getLuk()) * 0.033 + (double)playerStats.getDex()) * (double)a32 * 0.002);
                n3 += MapleStatEffect.ALLATORIxDEMO((double)a5.getY() / 100.0, a2.getStat().getTotalLuk(), 2.3, 3.5);
                return n3;
            }
        }
        return n3;
    }

    private /* synthetic */ boolean E() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 4121006 || a2.sourceid == 4111009 || a2.sourceid == 14111007);
    }

    public final /* synthetic */ short getDOT() {
        MapleStatEffect a2;
        return a2.dot;
    }

    private static final /* synthetic */ int ALLATORIxDEMO(String a2, MapleData a3, int a4, String a5, int a6) {
        if (a5 == null) {
            return MapleDataTool.getIntConvert(a2, (MapleData)a3, a4);
        }
        MapleData mapleData = a3.getChildByPath(a2);
        if (mapleData == null) {
            return a4;
        }
        if (mapleData.getType() != MapleDataType.STRING) {
            return MapleDataTool.getIntConvert(a2, (MapleData)a3, a4);
        }
        a3 = MapleDataTool.getString(mapleData).replace(a5, String.valueOf(a6));
        if (((String)a3).substring(0, 1).equals(ConcurrentEnumMap.ALLATORIxDEMO("C"))) {
            a3 = ((String)a3).substring(1, 2).equals(SkillEntry.ALLATORIxDEMO("`")) || ((String)a3).substring(1, 2).equals(ConcurrentEnumMap.ALLATORIxDEMO("\n")) ? "n(" + ((String)a3).substring(1, ((String)a3).length()) + ")" : "n" + ((String)a3).substring(1, ((String)a3).length());
        } else {
            Object object = a3;
            if (((String)a3).substring(0, 1).equals(SkillEntry.ALLATORIxDEMO("("))) {
                a3 = ((String)object).substring(1, ((String)a3).length());
            } else if (((String)object).contains(ConcurrentEnumMap.ALLATORIxDEMO("\u0017"))) {
                a3 = SkillEntry.ALLATORIxDEMO("%");
            }
        }
        return (int)new CaltechEval((String)a3).evaluate();
    }

    public final /* synthetic */ int getT() {
        MapleStatEffect a2;
        return a2.t;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, boolean a3) {
        MapleStatEffect a4;
        MapleCharacter mapleCharacter = a2;
        return a4.applyTo(mapleCharacter, mapleCharacter, true, null, a4.duration, a3);
    }

    public final /* synthetic */ int getPercentHP() {
        MapleStatEffect a2;
        return a2.mhpR;
    }

    public final /* synthetic */ short getMdef() {
        MapleStatEffect a2;
        return a2.mdef;
    }

    public /* synthetic */ short getMDEFRate() {
        MapleStatEffect a2;
        return a2.mddR;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isPoison() {
        MapleStatEffect a2;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            return a2.dot > 0 && a2.dotTime > 0;
        }
        switch (a2.sourceid) {
            case 2101005: 
            case 2111003: 
            case 2111006: 
            case 2121003: 
            case 2221003: 
            case 3111003: 
            case 5211004: 
            case 12111005: {
                return a2.skill;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleSummon a3) {
        if (SkillConstants.isNeedExtraRemoveSummon(a3.getSkill())) {
            Object object;
            Object object2;
            ArrayList<MapleSummon> arrayList = new ArrayList<MapleSummon>();
            try {
                object2 = new LinkedList<MapleSummon>(a2.getSummonsReadLock());
                object = object2.iterator();
                while (object.hasNext()) {
                    MapleSummon mapleSummon = (MapleSummon)object.next();
                    if (mapleSummon.getSkill() != a3.getSkill()) continue;
                    arrayList.add(mapleSummon);
                    MapleCharacter mapleCharacter = a2;
                    mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.removeSummon(mapleSummon, true));
                    mapleCharacter.getMap().removeMapObject(mapleSummon);
                    mapleCharacter.removeVisibleMapObject(mapleSummon);
                }
            }
            finally {
                a2.unlockSummonsReadLock();
            }
            Object object3 = object2 = arrayList.iterator();
            while (object3.hasNext()) {
                object = (MapleSummon)object2.next();
                object3 = object2;
                a2.removeSummon((MapleSummon)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isMechPassive() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 35121013: {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ boolean isUnstealable() {
        MapleStatEffect a2;
        Iterator<Pair<MapleBuffStat, Integer>> iterator = a2.statups.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLeft() != MapleBuffStat.MAPLE_WARRIOR) continue;
            return true;
        }
        return a2.sourceid == 4221013;
    }

    public /* synthetic */ int getActive() {
        MapleStatEffect a2;
        return a2.onActive;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ boolean H() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1121011: 
            case 1221012: 
            case 1321010: 
            case 2121008: 
            case 2221008: 
            case 2321009: 
            case 3121009: 
            case 3221008: 
            case 4121009: 
            case 4221008: 
            case 4341008: 
            case 5121008: 
            case 5221010: 
            case 5321006: 
            case 5721002: 
            case 21121008: 
            case 22171004: 
            case 23121008: 
            case 24121009: 
            case 27121010: 
            case 32121008: 
            case 33121008: 
            case 35121008: 
            case 61121015: 
            case 65121010: {
                return a2.skill;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean isGmBuff() {
        MapleStatEffect a2;
        if (GameSetConstants.GMBUFF_LIMIT) {
            return false;
        }
        switch (a2.sourceid) {
            case 1005: 
            case 9001000: 
            case 9001001: 
            case 9001002: 
            case 9001003: 
            case 9001005: 
            case 9001008: 
            case 10001005: 
            case 20001005: {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ int getItemSkill() {
        MapleStatEffect a2;
        return a2.ItemSkill;
    }

    public final /* synthetic */ short getMPConReduce() {
        MapleStatEffect a2;
        return a2.mpConReduce;
    }

    public /* synthetic */ int getBossDamage() {
        MapleStatEffect a2;
        return a2.bdR;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void applyPassive(MapleCharacter a2, MapleMapObject a3) {
        MapleStatEffect a4;
        if (!a4.makeChanceResult()) return;
        switch (a4.sourceid) {
            case 0x200B20: 
            case 2200000: 
            case 2300000: {
                int n2;
                if (a3 == null || a3.getType() != MapleMapObjectType.MONSTER) {
                    return;
                }
                if (((MapleMonster)(a3 = (MapleMonster)a3)).getStats().isBoss() || (n2 = Math.min((int)((double)((MapleMonster)a3).getMobMaxMp() * ((double)a4.getX() / 70.0)), ((MapleMonster)a3).getMp())) <= 0 || !((MapleMonster)a3).canAbsorbMP()) return;
                ((MapleMonster)a3).absorbMP(n2);
                MapleCharacter mapleCharacter = a2;
                a2.getStat().setMp(a2.getStat().getMp() + n2);
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(a4.sourceid, 1, a2.getLevel(), a4.level));
                if (mapleCharacter.getBuffedValue(MapleBuffStat.MORPH) != null) return;
                MapleCharacter mapleCharacter2 = a2;
                a2.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.showBuffEffect(mapleCharacter2.getId(), a4.sourceid, 1, a2.getLevel(), a4.level), false);
                return;
            }
        }
    }

    public final /* synthetic */ short getDex() {
        MapleStatEffect a2;
        return a2.dex;
    }

    public final /* synthetic */ int getAccX() {
        MapleStatEffect a2;
        return a2.accX;
    }

    public final /* synthetic */ boolean makeChanceResult(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.prop);
    }

    public final /* synthetic */ short getAvoid() {
        MapleStatEffect a2;
        return a2.avoid;
    }

    public final /* synthetic */ ArrayList<Pair<Integer, Integer>> getAvailableMap() {
        MapleStatEffect a2;
        return a2.d;
    }

    public final /* synthetic */ byte getLevel() {
        MapleStatEffect a2;
        return a2.level;
    }

    public final /* synthetic */ byte getAttackCount() {
        MapleStatEffect a2;
        return a2.attackCount;
    }

    public final /* synthetic */ boolean isMPRecovery() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 5101005;
    }

    public final /* synthetic */ void applyComboBuff(MapleCharacter a2, int a32) {
        MapleStatEffect a4;
        List<Pair<MapleBuffStat, Integer>> a32 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ARAN_COMBO, a32));
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveBuff(a4.sourceid, 99999, a32, a4, a2));
        mapleCharacter.registerEffect(a4, System.currentTimeMillis(), a4.getStatups(), Integer.MAX_VALUE, a2.getId());
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean isLinkSkills() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 80000000: 
            case 80000001: 
            case 80000002: 
            case 80000003: 
            case 80000004: 
            case 80000005: 
            case 80000006: 
            case 80000047: 
            case 80000050: 
            case 80000066: 
            case 80000067: 
            case 0x4C4B444: 
            case 80000069: 
            case 80000070: 
            case 80000110: 
            case 80000169: 
            case 80001040: 
            case 80001140: 
            case 80001151: 
            case 80001155: 
            case 80010006: {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ int getMpX() {
        MapleStatEffect a2;
        return a2.mmpX;
    }

    public /* synthetic */ boolean isItemDropBuff(int a2) {
        MapleStatEffect a3;
        boolean bl = false;
        if (a2 == a3.itemCode) {
            bl = true;
        }
        if (a2 / 10000 == a3.itemRange) {
            bl = true;
        }
        if (a3.itemCode == 0 && a3.itemRange == 0) {
            bl = true;
        }
        return bl;
    }

    public /* synthetic */ int getPadX() {
        MapleStatEffect a2;
        return a2.padX;
    }

    public final /* synthetic */ int getmdR() {
        MapleStatEffect a2;
        return a2.mdR;
    }

    public final /* synthetic */ boolean isResurrection() {
        MapleStatEffect a2;
        return a2.sourceid == 9001005 || a2.sourceid == 2321006;
    }

    public /* synthetic */ int getMddX() {
        MapleStatEffect a2;
        return a2.mddX;
    }

    public final /* synthetic */ int getDuration() {
        MapleStatEffect a2;
        return a2.duration;
    }

    private static /* synthetic */ int ALLATORIxDEMO(double a2, double a3, double a4, double a5) {
        return (int)(Math.random() * (double)((int)(a3 * a5 * a2) - (int)(a3 * a4 * a2) + 1) + (double)((int)(a3 * a4 * a2)));
    }

    public final /* synthetic */ boolean makeChanceResult_er(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.er);
    }

    public final /* synthetic */ int getPercentMP() {
        MapleStatEffect a2;
        return a2.mmpR;
    }

    private /* synthetic */ boolean ALLATORIxDEMO() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 5101007 || a2.sourceid == 5111005 || a2.sourceid == 5121003 || a2.sourceid == 13111005 || a2.sourceid == 15111002);
    }

    public final /* synthetic */ boolean isIceKnight() {
        MapleStatEffect a2;
        return a2.skill && JobConstants.isBeginnerJob(a2.sourceid / 10000) && a2.sourceid % 10000 == 1105;
    }

    public final /* synthetic */ boolean isAranCombo() {
        MapleStatEffect a2;
        return a2.sourceid == 21000000;
    }

    public final /* synthetic */ Rectangle calculateBoundingBox(Point a2, boolean a3, int a4) {
        MapleStatEffect a5;
        MapleStatEffect mapleStatEffect = a5;
        return MapleStatEffect.calculateBoundingBox(a2, a3, mapleStatEffect.lt, mapleStatEffect.rb, a5.range + a4);
    }

    public static final /* synthetic */ Rectangle calculateBoundingBox(Point a2, boolean a32, Point a4, Point a5, int a6) {
        Point point;
        Point a32;
        Point point2;
        if (a4 == null || a5 == null) {
            Point point3;
            int n2;
            if (a32) {
                n2 = -200 - a6;
                point3 = a2;
            } else {
                n2 = 0;
                point3 = a2;
            }
            return new Rectangle(n2 + point3.x, -100 - a6 + a2.y, 200 + a6, 100 + a6);
        }
        if (a32) {
            point2 = new Point(a4.x + a2.x - a6, a4.y + a2.y);
            a32 = point2;
            point = new Point(a5.x + a2.x, a5.y + a2.y);
        } else {
            point2 = new Point(a4.x * -1 + a2.x + a6, a5.y + a2.y);
            point = point2;
            a32 = new Point(a5.x * -1 + a2.x, a4.y + a2.y);
        }
        Point point4 = a32;
        return new Rectangle(point4.x, point4.y, point.x - a32.x, point.y - a32.y);
    }

    public final /* synthetic */ short getAttackX() {
        MapleStatEffect a2;
        return a2.padX;
    }

    public final /* synthetic */ int getExtendPrice() {
        MapleStatEffect a2;
        return a2.extendPrice;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final /* synthetic */ void ALLATORIxDEMO(MapleCharacter a, MapleCharacter a, boolean a, int a, boolean a) {
        block180: {
            var6_7 = a;
            var7_8 = true;
            if (a && a && a.getBuffedValue(MapleBuffStat.MORPH) == null && a.mesoup == 0 && a.expBuff == 0 && a.itemup == 0) {
                var6_7 = Math.max(a, a.alchemistModifyVal(a, var6_7, false));
            }
            v0 = a;
            a = v0.statups;
            var8_9 = null;
            var9_10 = new LinkedList<Pair<MapleBuffStat, Integer>>();
            var10_11 = true;
            var11_12 = a;
            var12_13 = 0;
            switch (v0.sourceid) {
                case 4221006: 
                case 5101007: {
                    if (!MapConstants.isCakeMap(a.getMapId())) break;
                    v1 = a;
                    var13_14 = v1.getClient().getChannelServer().getMapFactory().getMap(749020920);
                    v1.changeMap(var13_14, var13_14.getPortal(0));
                    v1.dropMessage(5, ConcurrentEnumMap.ALLATORIxDEMO("\u755f\u65e5\u60c6\u4f26\u7546\u4f05\u5f64\u62d9\u8093\u88f2\u86a5\u7c8c\u7612\u73a7\uff62\u7d09\u67f2\u60f1\u88c5\u8692\u7cbb\u50ea\u5194\u5769\u5778\u594f\u306c"));
                    return;
                }
            }
            switch (a.sourceid) {
                case 27101202: 
                case 27121005: 
                case 60001216: 
                case 60001217: 
                case 65101002: {
                    var9_10.addAll(a);
                    v2 = var11_12;
                    break block180;
                }
                case 5311004: {
                    var13_15 = Randomizer.nextInt(4) + 1;
                    v3 = a;
                    a.getMap().broadcastMessage(v3, MaplePacketCreator.showDiceEffect(v3.getId(), a.sourceid, var13_15, -1, a.level, 0), false);
                    v3.getClient().sendPacket(MaplePacketCreator.showOwnDiceEffect(a.sourceid, var13_15, -1, a.level, 0));
                    a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BARREL_ROLL, var13_15));
                    v2 = var11_12;
                    break block180;
                }
                case 5111007: 
                case 5211007: 
                case 5311005: 
                case 5711011: 
                case 15111011: 
                case 35111013: {
                    var13_16 = Randomizer.nextInt(6) + 1;
                    v4 = a;
                    v5 = a;
                    v4.getMap().broadcastMessage(v5, MaplePacketCreator.showDiceEffect(v5.getId(), a.sourceid, var13_16, -1, a.level, 0), false);
                    v6 = var13_16;
                    v4.getClient().sendPacket(MaplePacketCreator.showOwnDiceEffect(a.sourceid, v6, -1, a.level, 0));
                    if (v6 <= 1) {
                        a.dropMessage(-5, SkillEntry.ALLATORIxDEMO("\u5e6d\u907a\u9aa5\u5b61\u6295\u80cc\u5924\u6566\u3017"));
                        return;
                    }
                    a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DICE_ROLL, var13_16));
                    a.dropMessage(-5, "\u5e78\u904b\u9ab0\u5b50\u6280\u80fd\u767c\u52d5\u4e86[" + var13_16 + "]\u865f\u6548\u679c\u3002");
                    v7 = a;
                    v7.getClient().sendPacket(MaplePacketCreator.giveDice(var13_16, a.sourceid, var6_7, a));
                    v8 = a;
                    v7.setSkillWorking(a.skill != false ? v8.sourceid : -v8.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12 = false;
                    break block180;
                }
                case 5120012: 
                case 5220014: 
                case 5320007: 
                case 5720005: 
                case 35120014: {
                    var13_17 = Randomizer.nextInt(6) + 1;
                    var14_45 = a.makeChanceResult() != false ? Randomizer.nextInt(6) + 1 : 0;
                    v9 = a.getMap();
                    v10 = a;
                    v11 = v10.getId();
                    v12 = var13_17;
                    if (v12 > 0) {
                        v13 = -1;
                        v14 = a;
                    } else {
                        v13 = 0;
                        v14 = a;
                    }
                    v9.broadcastMessage(v10, MaplePacketCreator.showDiceEffect(v11, a.sourceid, v12, v13, v14.level, 0), false);
                    v15 = a.getClient();
                    if (var14_45 > 0) {
                        v16 = -1;
                        v17 = a;
                    } else {
                        v16 = 0;
                        v17 = a;
                    }
                    v15.sendPacket(MaplePacketCreator.showOwnDiceEffect(a.sourceid, var13_17, v16, v17.level, 0));
                    v18 = a.getMap();
                    v19 = a;
                    v20 = v19.getId();
                    v21 = var14_45;
                    if (v21 > 0) {
                        v22 = -1;
                        v23 = a;
                    } else {
                        v22 = 0;
                        v23 = a;
                    }
                    v18.broadcastMessage(v19, MaplePacketCreator.showDiceEffect(v20, a.sourceid, v21, v22, v23.level, 1), false);
                    v24 = a.getClient();
                    if (var14_45 > 0) {
                        v25 = -1;
                        v26 = a;
                    } else {
                        v25 = 0;
                        v26 = a;
                    }
                    v24.sendPacket(MaplePacketCreator.showOwnDiceEffect(a.sourceid, var13_17, v25, v26.level, 1));
                    if (var13_17 <= 1 && var14_45 <= 1) {
                        a.dropMessage(-5, ConcurrentEnumMap.ALLATORIxDEMO("\u96b7\u5054\u5e16\u9012\u9ade\u5b09\u62ee\u80a4\u595f\u650e\u306c"));
                        return;
                    }
                    v27 = var13_17 == var14_45 ? var13_17 * 100 : (var13_17 <= 1 ? var14_45 : (var15_66 = var14_45 <= 1 ? var13_17 : var13_17 * 10 + var14_45));
                    if (var15_66 >= 100) {
                        a.dropMessage(-5, "\u96d9\u500d\u5e78\u904b\u9ab0\u5b50\u6280\u80fd\u767c\u52d5\u4e86[" + var15_66 / 100 + "]\u865f\u6548\u679c\u3002");
                    } else if (var15_66 >= 10) {
                        a.dropMessage(-5, "\u96d9\u500d\u5e78\u904b\u9ab0\u5b50\u6280\u80fd\u767c\u52d5\u4e86[" + var15_66 / 10 + "]\u865f\u6548\u679c\u3002");
                    }
                    a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DICE_ROLL, var15_66));
                    v28 = a;
                    v28.getClient().sendPacket(MaplePacketCreator.giveDice(var13_17, a.sourceid, var6_7, a));
                    v29 = a;
                    v28.setSkillWorking(a.skill != false ? v29.sourceid : -v29.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12 = false;
                    break block180;
                }
                case 33101006: {
                    a.clearLinkMid();
                    var13_18 = null;
                    var14_46 = a.y;
                    switch (Randomizer.nextInt(6)) {
                        case 0: {
                            var13_18 = MapleBuffStat.CRITICAL_RATE_BUFF;
                            break;
                        }
                        case 1: {
                            var13_18 = MapleBuffStat.MP_BUFF;
                            break;
                        }
                        case 2: {
                            var13_18 = MapleBuffStat.DAMAGE_TAKEN_BUFF;
                            var14_46 = a.x;
                            break;
                        }
                        case 3: {
                            var13_18 = MapleBuffStat.DODGE_CHANGE_BUFF;
                            var14_46 = a.x;
                            break;
                        }
                        case 4: {
                            var13_18 = MapleBuffStat.DAMAGE_BUFF;
                            break;
                        }
                        case 5: {
                            var13_18 = MapleBuffStat.ATTACK_BUFF;
                            break;
                        }
                    }
                    a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(var13_18, var14_46));
                    v30 = a;
                    v30.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    v31 = a;
                    v30.setSkillWorking(a.skill != false ? v31.sourceid : -v31.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 8006: 
                case 4321000: 
                case 5001005: 
                case 5121009: 
                case 10008006: 
                case 15001003: 
                case 15111005: 
                case 20008006: 
                case 20018006: 
                case 20028006: 
                case 20038006: 
                case 20048006: 
                case 20058006: 
                case 30008006: 
                case 30018006: 
                case 30028006: 
                case 40018006: 
                case 40028006: 
                case 50008006: 
                case 60008006: 
                case 60018006: 
                case 100008006: 
                case 110008006: {
                    v32 = a;
                    v33 = a;
                    v32.getClient().sendPacket(MaplePacketCreator.givePirate(v33.statups, var6_7 / 1000, a.sourceid));
                    v34 = a;
                    v32.getMap().broadcastMessage(v34, MaplePacketCreator.giveForeignPirate(a.statups, var6_7 / 1000, v34.getId(), a.sourceid), false);
                    v35 = a;
                    v32.setSkillWorking(v33.skill != false ? v35.sourceid : -v35.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 20031205: {
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    v2 = var11_12;
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHROUD_WALK, 1));
                    var9_10.addAll(a);
                    break block180;
                }
                case 5211006: 
                case 5220011: 
                case 5221015: 
                case 5721003: 
                case 22151002: {
                    if (a.getFirstLinkMid() <= 0) return;
                    v36 = a;
                    v36.getClient().sendPacket(MaplePacketCreator.cancelHoming());
                    v36.getClient().sendPacket(MaplePacketCreator.giveHoming(a.sourceid, a.getFirstLinkMid()));
                    v37 = a;
                    v36.setSkillWorking(a.skill != false ? v37.sourceid : -v37.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 20031209: 
                case 20031210: {
                    var13_19 = Randomizer.nextInt(a.sourceid == 20031209 ? 2 : 5) + 1;
                    var14_47 = 24100003;
                    if (a.getSkillLevel(24120002) > 0) {
                        var14_47 = 24120002;
                    }
                    var15_67 = a.v;
                    switch (var13_19) {
                        case 1: {
                            var15_67 = a.v;
                            v38 = a;
                            break;
                        }
                        case 2: {
                            var15_67 = a.w;
                            v38 = a;
                            break;
                        }
                        case 3: {
                            var15_67 = a.x * 100 + a.y;
                            v38 = a;
                            break;
                        }
                        case 4: {
                            var15_67 = a.s;
                            v38 = a;
                            break;
                        }
                        case 5: {
                            var15_67 = a.z;
                        }
                        default: {
                            v38 = a;
                        }
                    }
                    v38.setCardStack((byte)0);
                    v39 = a;
                    v39.resetRunningStack();
                    v39.addRunningStack(var14_47 == 24100003 ? 5 : 10);
                    v40 = a.getMap();
                    v41 = a;
                    v42 = v41.getRunningStack();
                    if (var14_47 == 24120002) {
                        v43 = 2;
                        v44 = var14_47;
                    } else {
                        v43 = 1;
                        v44 = var14_47;
                    }
                    v40.broadcastMessage(v41, JobPacket.PhantomPacket.gainCardStack(a.getId(), v42, v43, v44, 0, var14_47 == 24100003 ? 5 : 10), true);
                    v45 = a;
                    a.getMap().broadcastMessage(v45, MaplePacketCreator.showDiceEffect(v45.getId(), a.sourceid, var13_19, -1, a.level, 0), false);
                    v45.getClient().sendPacket(MaplePacketCreator.showOwnDiceEffect(a.sourceid, var13_19, -1, a.level, 0));
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (var13_19 == 5) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABSORB_DAMAGE_HP, var13_19));
                    }
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.JUDGMENT_DRAW, var13_19));
                    var9_10.addAll(a);
                    var11_12 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 2120010: 
                case 2220010: 
                case 2320011: {
                    if (a.getArcanceDamage() <= 0) {
                        return;
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 138) {
                        a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ARCANE_AIM, a.getArcanceDamage()));
                        a.cancelEffect(a, true, -1L, a);
                        var13_20 = new HashMap<Integer, Integer>();
                        var13_20.put((int)a.getSkillTemp(a.sourceid), a.getArcanceDamage());
                        a.getClient().sendPacket(MaplePacketCreator.giveArcane(var13_20, var6_7, a.sourceid));
                    }
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 30001001: 
                case 30011001: {
                    var13_21 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INFILTRATE, 0));
                    var9_10.addAll(var13_21);
                    v46 = a;
                    a.setSkillWorking(a.skill != false ? v46.sourceid : -v46.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 33111007: 
                case 33121006: {
                    var13_22 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ATTACK_BUFF, 0));
                    var9_10.addAll(var13_22);
                    v47 = a;
                    a.setSkillWorking(a.skill != false ? v47.sourceid : -v47.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 0xC7E7CE: {
                    var13_23 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WIND_WALK, 0));
                    var9_10.addAll(var13_23);
                    v48 = a;
                    a.setSkillWorking(a.skill != false ? v48.sourceid : -v48.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 4001003: {
                    if (a.getSkillLevel(0x421211) > 0) {
                        SkillFactory.getSkill(0x421211).getEffect(a.getSkillLevel(0x421211)).ALLATORIxDEMO(a, a, a, a);
                        return;
                    }
                }
                case 0x421211: 
                case 9001004: 
                case 14001003: {
                    var13_24 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARKSIGHT, 1));
                    var9_10.addAll(var13_24);
                    v49 = a;
                    a.setSkillWorking(a.skill != false ? v49.sourceid : -v49.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 23111005: {
                    var13_25 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WATER_SHIELD, a.x));
                    var9_10.addAll(var13_25);
                    v50 = a;
                    a.setSkillWorking(a.skill != false ? v50.sourceid : -v50.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 23101003: {
                    var9_10.addAll(a);
                    v51 = a;
                    a.setSkillWorking(a.skill != false ? v51.sourceid : -v51.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 32121003: {
                    var13_26 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TORNADO, a.x));
                    var9_10.addAll(var13_26);
                    v52 = a;
                    a.setSkillWorking(a.skill != false ? v52.sourceid : -v52.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 32111005: {
                    a.cancelEffectFromBuffStat(MapleBuffStat.BODY_BOOST);
                    var13_27 = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    var14_48 = 0;
                    if (a.getStatForBuff(MapleBuffStat.DARK_AURA) != null) {
                        var14_48 = 32001003;
                        var13_27.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, a.level + 10 + a.getSkillLevel(32001003)));
                    } else if (a.getStatForBuff(MapleBuffStat.YELLOW_AURA) != null) {
                        var14_48 = 32101003;
                        var13_27.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, a.getSkillLevel(32101003)));
                    } else {
                        if (a.getStatForBuff(MapleBuffStat.BLUE_AURA) == null) return;
                        var14_48 = 32101002;
                        var6_7 = 10000;
                        var13_27.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, a.getSkillLevel(32101002)));
                        var13_27.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DIVINE_BODY, 1));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BODY_BOOST, Integer.valueOf(a.level)));
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    a.addAll(var13_27);
                    var15_68 = new LinkedList<Pair<MapleBuffStat, Integer>>(var13_27);
                    v53 = a;
                    v53.cancelEffectFromBuffStat(MapleBuffStat.BLUE_AURA, a.getId());
                    v53.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA, a.getId());
                    v53.cancelEffectFromBuffStat(MapleBuffStat.DARK_AURA, a.getId());
                    v53.getClient().sendPacket(MaplePacketCreator.giveBuff(var14_48, var6_7, var15_68, a, a));
                    v54 = a;
                    a.setSkillWorking(a.skill != false ? v54.sourceid : -v54.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 32001003: {
                    if (a.getSkillLevel(32120000) > 0) {
                        SkillFactory.getSkill(32120000).getEffect(a.getSkillLevel(32120000)).ALLATORIxDEMO(a, a, a, a);
                        return;
                    }
                }
                case 32110007: {
                    v55 = a;
                    v55.cancelEffectFromBuffStat(MapleBuffStat.DARK_AURA);
                    v55.cancelEffectFromBuffStat(MapleBuffStat.BLUE_AURA, a.getId());
                    v55.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA, a.getId());
                    v55.cancelEffectFromBuffStat(MapleBuffStat.BODY_BOOST);
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION < 152) {
                        if (a.sourceid == 32110007) {
                            v56 = MapleBuffStat.BODY_BOOST;
                            v57 = a;
                        } else {
                            v56 = MapleBuffStat.AURA;
                            v57 = a;
                        }
                        a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(v56, Integer.valueOf(v57.level)));
                        a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    }
                    a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, a.x));
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    var9_10.addAll(a);
                    v58 = a;
                    a.setSkillWorking(a.skill != false ? v58.sourceid : -v58.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 32120000: {
                    a.cancelEffectFromBuffStat(MapleBuffStat.DARK_AURA);
                    if (GameSetConstants.MAPLE_VERSION <= 143) {
                        v59 = a;
                        v59.cancelEffectFromBuffStat(MapleBuffStat.BLUE_AURA, a.getId());
                        v59.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA, a.getId());
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION < 152) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, a.getTotalSkillLevel(32001003)));
                        a.getClient().sendPacket(MaplePacketCreator.giveBuff(32001003, var6_7, a, a, a));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, a.x));
                    var13_28 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, a.x));
                    var9_10.addAll(var13_28);
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, Integer.valueOf(a.level)));
                    v60 = a;
                    a.setSkillWorking(a.skill != false ? v60.sourceid : -v60.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 32101002: 
                case 32111012: {
                    if (a.getTotalSkillLevel(32110000) > 0) {
                        SkillFactory.getSkill(32110000).getEffect(a.getTotalSkillLevel(32110000)).ALLATORIxDEMO(a, a, a, a);
                        return;
                    }
                    a.cancelEffectFromBuffStat(MapleBuffStat.BLUE_AURA);
                    if (GameSetConstants.MAPLE_VERSION <= 143) {
                        v61 = a;
                        v61.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA, a.getId());
                        v61.cancelEffectFromBuffStat(MapleBuffStat.DARK_AURA, a.getId());
                    }
                    a.cancelEffectFromBuffStat(MapleBuffStat.BODY_BOOST);
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION < 152) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                        a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a.level)));
                    var13_29 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a.level)));
                    var9_10.addAll(var13_29);
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a.level)));
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 31121005: {
                    var13_30 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DARK_AURA, 6));
                    var9_10.addAll(var13_30);
                    v62 = a;
                    a.setSkillWorking(a.skill != false ? v62.sourceid : -v62.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 32110008: {
                    var6_7 = 10000;
                }
                case 32110000: {
                    var13_31 = 32101002;
                    if (GameSetConstants.MAPLE_VERSION > 143) {
                        var13_31 = 32111012;
                    }
                    a.cancelEffectFromBuffStat(MapleBuffStat.BLUE_AURA);
                    if (GameSetConstants.MAPLE_VERSION < 145 && !GameSetConstants.MUTIPLE_AURA) {
                        v63 = a;
                        v63.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA, a.getId());
                        v63.cancelEffectFromBuffStat(MapleBuffStat.DARK_AURA, a.getId());
                    }
                    a.cancelEffectFromBuffStat(MapleBuffStat.BODY_BOOST);
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION < 152) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                        a.getClient().sendPacket(MaplePacketCreator.giveBuff(var13_31, var6_7, a, a, a));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a.level)));
                    var14_49 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a.level)));
                    var9_10.addAll(var14_49);
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLUE_AURA, Integer.valueOf(a.level)));
                    v64 = a;
                    a.setSkillWorking(a.skill != false ? v64.sourceid : -v64.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 32101003: {
                    if (a.getSkillLevel(32120001) > 0) {
                        SkillFactory.getSkill(32120001).getEffect(a.getSkillLevel(32120001)).ALLATORIxDEMO(a, a, a, a);
                        return;
                    }
                    v65 = a;
                    v65.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA);
                    v65.cancelEffectFromBuffStat(MapleBuffStat.BODY_BOOST);
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION < 152) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                        a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a.level)));
                    var13_32 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a.level)));
                    var9_10.addAll(var13_32);
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPEED, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a.level)));
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 32120001: {
                    a.cancelEffectFromBuffStat(MapleBuffStat.YELLOW_AURA);
                    if (GameSetConstants.MAPLE_VERSION < 145 && !GameSetConstants.MUTIPLE_AURA) {
                        v66 = a;
                        v66.cancelEffectFromBuffStat(MapleBuffStat.BLUE_AURA, a.getId());
                        v66.cancelEffectFromBuffStat(MapleBuffStat.DARK_AURA, a.getId());
                    }
                    a.cancelEffectFromBuffStat(MapleBuffStat.BODY_BOOST);
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION < 152) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                        a.getClient().sendPacket(MaplePacketCreator.giveBuff(32101003, var6_7, a, a, a));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a.level)));
                    var13_33 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a.level)));
                    var9_10.addAll(var13_33);
                    a.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.AURA, Integer.valueOf(a.level)));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.YELLOW_AURA, Integer.valueOf(a.level)));
                    v67 = a;
                    a.setSkillWorking(a.skill != false ? v67.sourceid : -v67.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 1211007: 
                case 1211008: {
                    if (a.getBuffedValue(MapleBuffStat.WK_CHARGE) != null && a.getBuffSource(MapleBuffStat.WK_CHARGE) != a.sourceid) {
                        a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.LIGHTNING_CHARGE, 1));
                        v68 = a;
                    } else {
                        if (!a.isHidden()) {
                            var13_34 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, 1));
                            var9_10.addAll(var13_34);
                        }
                        v68 = a;
                    }
                    v68.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    v69 = a;
                    a.setSkillWorking(a.skill != false ? v69.sourceid : -v69.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 35111004: {
                    if (a.getBuffedValue(MapleBuffStat.MECH_CHANGE) != null && a.getBuffSource(MapleBuffStat.MECH_CHANGE) == 35121005) {
                        SkillFactory.getSkill(35121013).getEffect(a.level).ALLATORIxDEMO(a, a, a, a);
                        return;
                    }
                    var13_35 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MECH_CHANGE, 1));
                    var9_10.addAll(var13_35);
                    v70 = a;
                    a.setSkillWorking(a.skill != false ? v70.sourceid : -v70.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 35001001: 
                case 35101009: 
                case 35121005: 
                case 35121013: {
                    var13_36 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MECH_CHANGE, 1));
                    var9_10.addAll(var13_36);
                    v71 = a;
                    a.setSkillWorking(a.skill != false ? v71.sourceid : -v71.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 1220013: {
                    var13_37 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DIVINE_SHIELD, a.x));
                    var9_10.addAll(var13_37);
                    v72 = a;
                    a.setSkillWorking(a.skill != false ? v72.sourceid : -v72.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 1111002: 
                case 11111001: {
                    var13_38 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.COMBO, 0));
                    var9_10.addAll(var13_38);
                    v73 = a;
                    a.setSkillWorking(a.skill != false ? v73.sourceid : -v73.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 3101004: 
                case 3201004: 
                case 13101003: {
                    var13_39 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOULARROW, 0));
                    var9_10.addAll(var13_39);
                    v74 = a;
                    a.setSkillWorking(a.skill != false ? v74.sourceid : -v74.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 2321005: {
                    break;
                }
                case 4111002: 
                case 0x404140: 
                case 14111000: {
                    var13_40 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHADOWPARTNER, 0));
                    var9_10.addAll(var13_40);
                    v75 = a;
                    a.setSkillWorking(a.skill != false ? v75.sourceid : -v75.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 4331002: {
                    var13_41 = GameSetConstants.MAPLE_VERSION >= 134 ? Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MIRROR_IMAGE, 1)) : Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SHADOWPARTNER, 1));
                    var9_10.addAll(var13_41);
                    v76 = a;
                    a.setSkillWorking(a.skill != false ? v76.sourceid : -v76.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 15111006: {
                    a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPARK, a.x));
                    v77 = a;
                    v77.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, a, a, a));
                    v78 = a;
                    v77.setSkillWorking(a.skill != false ? v78.sourceid : -v78.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var10_11 = false;
                    v2 = var11_12;
                    break block180;
                }
                case 4341002: {
                    var9_10.addAll(a);
                    v79 = a;
                    a.setSkillWorking(a.skill != false ? v79.sourceid : -v79.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 4341011: {
                    if (GameSetConstants.MAPLE_VERSION < 147) break;
                    v2 = var11_12;
                    a.monsterStatus.put(MonsterStatus.POISON, a.x);
                    break block180;
                }
                case 4341007: {
                    var13_42 = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        var14_50 = a.ewatk;
                        if (a.getId() != a.getId()) {
                            var14_50 = var14_50 / 2;
                        }
                        if (var14_50 > 0) {
                            var13_42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, var14_50));
                        }
                        if (a.prop > 0) {
                            var13_42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a.prop));
                        }
                    } else {
                        var14_51 = a.x << 8 | a.y;
                        if (a.getId() != a.getId()) {
                            var14_51 = a.x / 2 << 8 | a.y / 2;
                        }
                        if (var14_51 > 0) {
                            var13_42.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.THORNS, var14_51));
                        }
                    }
                    a.clear();
                    a.addAll(var13_42);
                    v2 = var11_12;
                    break block180;
                }
                case 3211005: {
                    if (GameSetConstants.MAPLE_VERSION < 138 || a.getSkillLevel(3220005) <= 0) break;
                    SkillFactory.getSkill(3220005).getEffect(a.getSkillLevel(3220005)).ALLATORIxDEMO(a, a, a, a);
                    v2 = var11_12;
                    break block180;
                }
                case 3111005: {
                    if (GameSetConstants.MAPLE_VERSION < 138 || a.getSkillLevel(3120006) <= 0) break;
                    SkillFactory.getSkill(3120006).getEffect(a.getSkillLevel(3120006)).ALLATORIxDEMO(a, a, a, a);
                    v2 = var11_12;
                    break block180;
                }
                case 1211004: 
                case 1211006: 
                case 1221004: 
                case 11111007: 
                case 15101006: 
                case 21101006: 
                case 21111005: {
                    var14_52 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WK_CHARGE, 1));
                    var9_10.addAll(var14_52);
                    v80 = a;
                    a.setSkillWorking(a.skill != false ? v80.sourceid : -v80.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 5211011: {
                    if (a.getTotalSkillLevel(5220019) <= 0) break;
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    v2 = var11_12;
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_ATK, Integer.valueOf(SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getWatk())));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRIT_MIN_DAMAGE, SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getZ()));
                    break block180;
                }
                case 5211015: {
                    if (a.getTotalSkillLevel(5220019) <= 0) break;
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    v2 = var11_12;
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_ATK, Integer.valueOf(SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getWatk())));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.CRIT_RATE, SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getCr()));
                    break block180;
                }
                case 5211016: {
                    if (a.getTotalSkillLevel(5220019) <= 0) break;
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    v2 = var11_12;
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_ATK, Integer.valueOf(SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getWatk())));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HP_BOOST_PERCENT, SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getX()));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MP_BOOST_PERCENT, SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getX()));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ANGEL_SPEED, SkillFactory.getSkill(5220019).getEffect(a.getTotalSkillLevel(5220019)).getU()));
                    break block180;
                }
                case 3120006: 
                case 3220005: {
                    if (a.isHidden()) {
                        v2 = var11_12;
                    } else {
                        var14_53 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SPIRIT_LINK, 0));
                        var9_10.addAll(var14_53);
                        v81 = a;
                        a.setSkillWorking(a.skill != false ? v81.sourceid : -v81.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                        v2 = var11_12;
                    }
                    break block180;
                }
                case 4221013: {
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    v2 = var11_12;
                    v82 = a;
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, v82.x + v82.kp * a.getShadowKillCount()));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.KILLING_POINT, a.getShadowKillCount()));
                    v83 = a;
                    v83.updateShadowKillCount();
                    v83.resetShadowKillCount();
                    break block180;
                }
                case 2121004: 
                case 2221004: 
                case 2321004: {
                    var12_13 = a.alchemistModifyVal(a, 4000, false);
                    if (GameSetConstants.MAPLE_VERSION < 134) break;
                    a.startInfinity();
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (GameSetConstants.MAPLE_VERSION >= 139) {
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, a.prop));
                    }
                    if (a.getInfinityCount() > 0) {
                        v2 = var11_12;
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INFINITY, Math.max(100, (a.getInfinityCount() + 1) * a.getDamage())));
                    } else {
                        a.updateInfinityTime();
                        v2 = var11_12;
                        a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.INFINITY, Integer.valueOf(a.getDamage())));
                    }
                    break block180;
                }
                case 4331003: {
                    var9_10.addAll(a);
                    v84 = a;
                    a.setSkillWorking(a.skill != false ? v84.sourceid : -v84.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
                }
                case 1121010: {
                    a.handleOrbConsume(1111002, 0);
                    v2 = var11_12;
                    break block180;
                }
                case 35121003: {
                    var6_7 = 15000;
                    v2 = var11_12;
                    break block180;
                }
                case 24111002: {
                    if (a.getSkillTemp(24111002) != 1L) break;
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.setSkillTemp(24111002, 0);
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FINAL_FEINT, 1));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.NOT_DAMAGE, 1));
                    var6_7 = a.getY() * 1000;
                    a.getClient().sendPacket(MaplePacketCreator.showOwnSpecialSkillEffect(a.sourceid));
                    a.getMap().broadcastMessage(MaplePacketCreator.showSpecialSkillEffect(a.getId(), a.sourceid));
                    v2 = var11_12;
                    break block180;
                }
                case 24111003: {
                    if (GameSetConstants.MAPLE_VERSION <= 152) {
                        v2 = var11_12;
                    } else {
                        var14_54 = new LinkedList<Pair<MapleBuffStat, Integer>>();
                        if (a.getSkillLevel(24120049) > 0) {
                            var14_54.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ABNORMAL_STATUS_R, a.x + SkillFactory.getSkill(24120049).getEffect(a.getSkillLevel(a.sourceid)).getX()));
                            var14_54.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ELEMENTAL_STATUS_R, a.y + SkillFactory.getSkill(24120049).getEffect(a.getSkillLevel(a.sourceid)).getX()));
                        }
                        if (a.getSkillLevel(24120050) > 0) {
                            var14_54.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.HP_BOOST_PERCENT, a.indieMhpR + SkillFactory.getSkill(24120050).getEffect(a.getSkillLevel(a.sourceid)).getX()));
                        }
                        if (a.getSkillLevel(24120051) > 0) {
                            var14_54.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MP_BOOST_PERCENT, a.indieMmpR + SkillFactory.getSkill(24120051).getEffect(a.getSkillLevel(a.sourceid)).getX()));
                        }
                        for (Pair<MapleBuffStat, Integer> var16_72 : a) {
                            var17_76 = var16_72.getLeft();
                            var12_13 = 0;
                            var18_78 = var14_54.iterator();
                            while (var18_78.hasNext()) {
                                if (((Pair)var18_78.next()).getLeft() != var16_72.getLeft()) continue;
                                var12_13 = 1;
                            }
                            if (var12_13 != 0) continue;
                            var14_54.add(var16_72);
                        }
                        a = var14_54;
                        v2 = var11_12;
                    }
                    break block180;
                }
                case 24121004: {
                    var14_55 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.IGNORE_DEF, 1));
                    v2 = var11_12;
                    var9_10.addAll(var14_55);
                    break block180;
                }
                case 2311009: {
                    var9_10.addAll(a);
                    v2 = var11_12;
                    break block180;
                }
                case 24121007: {
                    var14_56 = Randomizer.rand(1, 4);
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    if (a.getCharacterSet(SkillEntry.ALLATORIxDEMO("\u0003!\u0000'\u0000%\u0001\"")) == -1L) {
                        return;
                    }
                    a.removeCharacterSet(ConcurrentEnumMap.ALLATORIxDEMO("kZh\\h^iY"));
                    switch (var14_56) {
                        case 1: {
                            a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.POWERGUARD, a.y));
                            v85 = a;
                            break;
                        }
                        case 2: {
                            a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.WATER_SHIELD, a.x));
                            v85 = a;
                            break;
                        }
                        case 3: {
                            a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.NOT_DAMAGE, 1));
                            v85 = a;
                            break;
                        }
                        case 4: {
                            a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENHANCED_WATK, a.ewatk));
                        }
                        default: {
                            v85 = a;
                        }
                    }
                    v85.dispelBuff(24121007);
                    v86 = a;
                    v87 = a;
                    v86.getMap().broadcastMessage(v87, MaplePacketCreator.showDiceEffect(a.getId(), a.sourceid, var14_56, -1, a.level, 0), false);
                    v86.getClient().sendPacket(MaplePacketCreator.showOwnDiceEffect(a.sourceid, var14_56, -1, a.level, 0));
                    v87.getClient().sendPacket(MaplePacketCreator.giveVolDAme(var14_56, a.sourceid, var6_7, a));
                    var10_11 = false;
                    v2 = var11_12 = false;
                    break block180;
                }
                case 61101002: 
                case 61110211: {
                    if (a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11) == null) {
                        var10_11 = false;
                        v2 = var11_12 = false;
                    } else {
                        v88 = a;
                        v88.clear();
                        v88.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TEMPEST_BLADES, a.getSkillLevel(61101002)));
                        var8_9 = new LinkedList<Pair<MapleBuffStat, Integer>>(a.statups);
                        var9_10.addAll(var8_9);
                        v2 = var11_12;
                    }
                    break block180;
                }
                case 61121009: {
                    var14_57 = a.v;
                    if (a.getId() != a.getId()) {
                        var14_57 = a.w;
                    }
                    v89 = a;
                    v89.clear();
                    v89.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.GRAND_ARMOR, var14_57));
                    v2 = var11_12;
                    break block180;
                }
                case 61120007: 
                case 61121217: {
                    if (a.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11) == null) {
                        var10_11 = false;
                        v2 = var11_12 = false;
                    } else {
                        v90 = a;
                        v90.clear();
                        v90.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TEMPEST_BLADES, a.getSkillLevel(61120007)));
                        var8_9 = new LinkedList<Pair<MapleBuffStat, Integer>>(a.statups);
                        var9_10.addAll(var8_9);
                        v2 = var11_12;
                    }
                    break block180;
                }
                case 65121101: {
                    if (a.getSkillTemp(65121101) <= 0L) {
                        return;
                    }
                    v91 = a;
                    v91.clear();
                    v91.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.TRINITY, (int)Math.min(10L, a.getSkillTemp(65121101))));
                    v2 = var11_12;
                    break block180;
                }
                default: {
                    if (!a.isPirateMorph()) ** GOTO lbl921
                    var14_58 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MORPH, a.getMorph(a)));
                    v92 = a;
                    var9_10.addAll(var14_58);
                    v92.getClient().sendPacket(MaplePacketCreator.giveBuff(a.sourceid, var6_7, var14_58, a, a));
                    v93 = a;
                    v92.setSkillWorking(a.skill != false ? v93.sourceid : -v93.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var8_9 = new LinkedList<Pair<MapleBuffStat, Integer>>(a);
                    for (Pair var16_73 : var8_9) {
                        if (var16_73.getLeft() != MapleBuffStat.MORPH) continue;
                        var8_9.remove(var16_73);
                    }
                    var7_8 = false;
                    var10_11 = var8_9.size() > 0;
                    v2 = var11_12;
                    break block180;
lbl921:
                    // 1 sources

                    if (!a.isMorph()) ** GOTO lbl943
                    if (a.isIceKnight()) {
                        var14_59 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ICE_KNIGHT, 2));
                        v94 = a;
                        v94.getClient().sendPacket(MaplePacketCreator.giveBuff(0, var6_7, var14_59, a, a));
                        v95 = a;
                        v94.setSkillWorking(a.skill != false ? v95.sourceid : -v95.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    }
                    if (a.sourceid == 61111008 || a.sourceid == 61120008) {
                        if (a.getAttackCombo() < 700) {
                            a.dropMessage(5, SkillEntry.ALLATORIxDEMO("\u9f98\u80cc\u7416\u4e3c\u8da6\uff3d\u7134\u6ce4\u4f6a\u7519\u6295\u80cc\u3017"));
                            return;
                        }
                        v96 = a;
                        v96.resetKaiserCombo();
                        if (v96.getJob() == 6112) {
                            var6_7 += 30000;
                        }
                    }
                    var14_59 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MORPH, a.getMorph(a)));
                    var9_10.addAll(var14_59);
                    v97 = a;
                    a.setSkillWorking(a.skill != false ? v97.sourceid : -v97.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
lbl943:
                    // 1 sources

                    if (!a.isInflation()) ** GOTO lbl951
                    var14_60 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.GIANT_POTION, Integer.valueOf(a.inflation)));
                    var9_10.addAll(var14_60);
                    v98 = a;
                    a.setSkillWorking(a.skill != false ? v98.sourceid : -v98.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
lbl951:
                    // 1 sources

                    if (a.charColor <= 0) ** GOTO lbl959
                    var14_61 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.FAMILIAR_SHADOW, 1));
                    var9_10.addAll(var14_61);
                    v99 = a;
                    a.setSkillWorking(a.skill != false ? v99.sourceid : -v99.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    v2 = var11_12;
                    break block180;
lbl959:
                    // 1 sources

                    if (!a.isMonsterRiding()) ** GOTO lbl998
                    if (a.sourceid == 35001002 && a.getTotalSkillLevel(35120000) > 0) {
                        SkillFactory.getSkill(35120000).getEffect(a.getTotalSkillLevel(35120000)).ALLATORIxDEMO(a, a, a, a);
                        return;
                    }
                    var6_7 = 2100000000;
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>(a.statups);
                    v100 = a;
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MONSTER_RIDING, 1));
                    var14_62 = MapleStatEffect.parseMountInfo(a, a.sourceid);
                    var15_71 = MapleStatEffect.parseMountInfo_Pure(a, v100.sourceid);
                    if ((v100.sourceid == 1013 || a.sourceid == 10001014 || a.sourceid == 1017 || a.sourceid == 10001019 || a.sourceid == 20001019 || a.sourceid == 20011018) && GameSetConstants.SERVER_NAME.equals(ConcurrentEnumMap.ALLATORIxDEMO("\u608f\u72f5\u8c59")) && a.getMountId() == 0) {
                        return;
                    }
                    if ((a.sourceid == 1013 || a.sourceid == 10001014 || a.sourceid == 1017 || a.sourceid == 10001019 || a.sourceid == 20001019 || a.sourceid == 20011018) && a.getMountId() != 0) {
                        v101 = a;
                        var14_62 = v101.getMountId();
                        var15_71 = v101.getMountId();
                    }
                    if (var14_62 == 0) return;
                    if (var15_71 == 0) return;
                    var16_74 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MONSTER_RIDING, 0));
                    v102 = a;
                    a.cancelEffectFromBuffStat(MapleBuffStat.POWERGUARD);
                    v102.cancelEffectFromBuffStat(MapleBuffStat.MANA_REFLECTION);
                    v102.getClient().getSession().writeAndFlush((Object)MaplePacketCreator.giveMount(var15_71, a.sourceid, var16_74));
                    v103 = a;
                    a.getMap().broadcastMessage(v103, MaplePacketCreator.showMonsterRiding(v103.getId(), var16_74, var14_62, a.sourceid), false);
                    v104 = a;
                    v102.setSkillWorking(a.skill != false ? v104.sourceid : -v104.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
                    var8_9 = new LinkedList<Pair<MapleBuffStat, Integer>>(a);
                    for (Pair var17_77 : var8_9) {
                        if (var17_77.getLeft() != MapleBuffStat.MONSTER_RIDING) continue;
                        var8_9.remove(var17_77);
                    }
                    var10_11 = var8_9.size() > 0;
                    var7_8 = false;
                    v2 = var11_12;
                    break block180;
lbl998:
                    // 1 sources

                    if (!a.isSoaring()) ** GOTO lbl1005
                    var14_63 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.SOARING, 1));
                    var9_10.addAll(var14_63);
                    var7_8 = false;
                    v2 = var11_12;
                    break block180;
lbl1005:
                    // 1 sources

                    if (a.berserk <= 0) ** GOTO lbl1011
                    var14_64 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.PYRAMID_PQ, 0));
                    v2 = var11_12;
                    var9_10.addAll(var14_64);
                    break block180;
lbl1011:
                    // 1 sources

                    if (!a.isBerserkFury() && a.berserk2 <= 0) ** GOTO lbl1017
                    var14_65 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BERSERK_FURY, 1));
                    v2 = var11_12;
                    var9_10.addAll(var14_65);
                    break block180;
lbl1017:
                    // 1 sources

                    if (!a.isDivineBody()) break;
                    if (!a.isInvincible()) ** GOTO lbl1033
                    if (!GameSetConstants.ADMIN_DIVINEBODY) break;
                    if (a.isShowInfo()) {
                        a.dropMessage(-5, SkillEntry.ALLATORIxDEMO("\u5bab\u5223\u62b1\u80e8\u00118\u0011\u7134\u6544\u6829\u64fa\u8846j\u538a\u62b1\u80e8\u000b5\u91e0\u524e\u4e3c\u58cbl=\u5719\u89c7\u8243\u7134\u6544\u72d5\u617a\u6258\u6732\u750a\u6579<"));
                    }
                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, 100));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DIVINE_BODY, 1));
                    var9_10.addAll(a);
                    var6_7 = 0x7FFFFFFF;
                    var11_12 = false;
                    v2 = var11_12;
                    break block180;
lbl1033:
                    // 1 sources

                    a = new LinkedList<Pair<MapleBuffStat, Integer>>();
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.STANCE, 100));
                    a.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DIVINE_BODY, 1));
                    var9_10.addAll(a);
                }
            }
            v2 = var11_12;
        }
        if (v2 && !a.isHidden()) {
            v105 = a;
            a.getMap().broadcastMessage(v105, MaplePacketCreator.showBuffEffect(a.getId(), a.sourceid, 1, a.getLevel(), a.level), false);
            v106 = a;
            v105.setSkillWorking(a.skill != false ? v106.sourceid : -v106.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
        }
        if (a.isMechPassive()) {
            v107 = a;
            v107.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(a.sourceid - 1000, 1, a.getLevel(), a.level, (byte)1));
            v108 = a;
            v107.setSkillWorking(a.skill != false ? v108.sourceid : -v108.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
        }
        if (!a.isMonsterRiding() && !a.isMechDoor()) {
            a.cancelEffect(a, true, -1L, a);
        }
        if (a.getItemSkill() == 6666666) {
            a = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ACASH_RATE, 0));
        }
        var13_44 = System.currentTimeMillis();
        a.registerEffect(a, var13_44, a, var6_7, a.getId());
        if (var10_11 && a.size() > 0) {
            v109 = a.getClient();
            if (var7_8) {
                v110 = a;
                if (a.skill) {
                    v111 = v110.sourceid;
                    v112 = var6_7;
                } else {
                    v111 = -v110.sourceid;
                    v112 = var6_7;
                }
            } else {
                v111 = 0;
                v112 = var6_7;
            }
            if (var8_9 == null) {
                v113 = a;
                v114 = a;
            } else {
                v113 = var8_9;
                v114 = a;
            }
            v109.sendPacket(MaplePacketCreator.giveBuff(v111, v112, v113, v114, a));
            v115 = a;
            a.setSkillWorking(a.skill != false ? v115.sourceid : -v115.sourceid, System.currentTimeMillis() + (long)var6_7 - System.currentTimeMillis() + 5000L);
        }
        if (var9_10.isEmpty() != false) return;
        if (a.isHidden() != false) return;
        v116 = a;
        a.getMap().broadcastMessage(v116, MaplePacketCreator.giveForeignBuff(v116, var9_10, a), false);
    }

    private /* synthetic */ boolean d() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 22181003;
    }

    public final /* synthetic */ short getCriticalMax() {
        MapleStatEffect a2;
        return a2.criticaldamageMax;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ SummonMovementType getSummonMovementType() {
        MapleStatEffect a2;
        if (!a2.skill) {
            return null;
        }
        switch (a2.sourceid) {
            case 2311006: {
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    return null;
                }
                return SummonMovementType.CIRCLE_FOLLOW;
            }
            case 3111002: 
            case 3120012: 
            case 3211002: 
            case 3220012: 
            case 4111007: 
            case 4211007: 
            case 4341006: 
            case 5211001: 
            case 5211014: 
            case 5220002: 
            case 5320011: 
            case 5321003: 
            case 5321004: 
            case 5711001: 
            case 13111004: 
            case 14111010: 
            case 22171052: 
            case 33101008: 
            case 33111003: 
            case 35111002: 
            case 35111005: 
            case 35111011: 
            case 35121003: 
            case 35121009: 
            case 35121010: 
            case 35121011: 
            case 61111002: {
                return SummonMovementType.STATIONARY;
            }
            case 3101007: 
            case 3111005: 
            case 3121006: 
            case 3201007: 
            case 3211005: 
            case 3221005: 
            case 23111008: 
            case 23111009: 
            case 23111010: 
            case 33101011: 
            case 33111005: {
                return SummonMovementType.CIRCLE_FOLLOW;
            }
            case 5211002: {
                return SummonMovementType.CIRCLE_STATIONARY;
            }
            case 5211011: 
            case 5211015: 
            case 5211016: 
            case 32111006: {
                return SummonMovementType.WALK_STATIONARY;
            }
            case 1321007: 
            case 2121005: 
            case 2221005: 
            case 2321003: 
            case 11001004: 
            case 12001004: 
            case 12111004: 
            case 13001004: 
            case 14001005: 
            case 15001004: 
            case 35111001: 
            case 35111009: 
            case 35111010: {
                return SummonMovementType.FOLLOW;
            }
        }
        return null;
    }

    public final /* synthetic */ boolean isInflation() {
        MapleStatEffect a2;
        return a2.inflation > 0;
    }

    public final /* synthetic */ boolean makeChanceResult_w() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        return mapleStatEffect.makeChanceResult(null, mapleStatEffect.w);
    }

    public /* synthetic */ int alchemistModifyVal(MapleCharacter a2, int a3, boolean a4) {
        MapleStatEffect a5;
        if (!a5.skill) {
            return a3 * (a4 ? a2.getStat().RecoveryUP : a2.getStat().BuffUP) / 100;
        }
        MapleCharacter mapleCharacter = a2;
        double d2 = (double)(a4 ? mapleCharacter.getStat().RecoveryUP : mapleCharacter.getStat().BuffUP_Skill + (a5.getSummonMovementType() == null ? 0 : a2.getStat().BuffUP_Summon)) * 0.01 + 1.0;
        return (int)((double)a3 * d2);
    }

    private /* synthetic */ int ALLATORIxDEMO(MapleCharacter a2, MapleCharacter a32, boolean a42) {
        MapleStatEffect a5;
        int n2 = 0;
        if (a5.mp != 0) {
            MapleCharacter mapleCharacter;
            if (a42) {
                MapleStatEffect mapleStatEffect = a5;
                n2 += mapleStatEffect.alchemistModifyVal(a2, mapleStatEffect.mp, true);
                mapleCharacter = a2;
            } else {
                n2 += a5.mp;
                mapleCharacter = a2;
            }
            if (mapleCharacter.getPotential6() > 0L) {
                int n3 = (int)((double)a2.getPotential6() * 1.0E-4 * (double)a5.mp);
                n2 += n3;
            }
        }
        if (a5.mpR != 0.0) {
            n2 += (int)((double)a32.getStat().getCurrentMaxMp() * a5.mpR);
        }
        if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a2.getJob())) {
            n2 = 0;
        }
        if (a42) {
            if (a5.mpCon != 0 && !JobConstants.is\u60e1\u9b54\u6bba\u624b(a2.getJob())) {
                int n4;
                double d2 = 1.0;
                int a32 = MapleStatEffect.ALLATORIxDEMO(a2.getJob());
                if (a32 != -1 && (n4 = a2.getSkillLevel(a42 = SkillFactory.getSkill(a32))) > 0) {
                    d2 = (double)a42.getEffect(n4).getX() / 100.0;
                }
                MapleCharacter mapleCharacter = a2;
                Integer a42 = mapleCharacter.getBuffedSkill_X(MapleBuffStat.CONCENTRATE);
                n4 = mapleCharacter.getStat().mpconReduce + (a42 == null ? 0 : a42);
                if (a2.getBuffedValue(MapleBuffStat.INFINITY) != null) {
                    n2 = 0;
                } else {
                    MapleStatEffect mapleStatEffect = a5;
                    n2 = (int)((double)n2 - (double)(mapleStatEffect.mpCon - mapleStatEffect.mpCon * n4 / 100) * d2);
                }
            } else if (a5.forceCon != 0 && JobConstants.is\u60e1\u9b54\u6bba\u624b(a2.getJob())) {
                if (a2.getBuffedValue(MapleBuffStat.BOUNDLESS_RAGE) != null) {
                    n2 = 0;
                    return 0;
                }
                n2 -= a5.forceCon;
            }
        }
        return n2;
    }

    public final /* synthetic */ boolean isRecovery() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 1001 || a2.sourceid == 10001001 || a2.sourceid == 20001001 || a2.sourceid == 11001 || a2.sourceid == 35121005);
    }

    public final /* synthetic */ int getBulletConsume() {
        MapleStatEffect a2;
        return a2.bulletConsume;
    }

    public final /* synthetic */ boolean isMagicDoor() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 2311002 || a2.sourceid == 8001 || a2.sourceid == 10008001 || a2.sourceid == 20008001 || a2.sourceid == 20018001 || a2.sourceid == 30008001);
    }

    public final /* synthetic */ boolean makeChanceResult_y(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.y);
    }

    public final /* synthetic */ int getU() {
        MapleStatEffect a2;
        return a2.u;
    }

    public final /* synthetic */ int getCharColor() {
        MapleStatEffect a2;
        return a2.charColor;
    }

    public final /* synthetic */ int getRange() {
        MapleStatEffect a2;
        return a2.range;
    }

    public /* synthetic */ int getInterval() {
        MapleStatEffect a2;
        return a2.interval;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean isMist() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1076: 
            case 11076: 
            case 2111003: 
            case 4121015: 
            case 4221006: 
            case 12111005: 
            case 14111006: 
            case 22161003: 
            case 24121052: 
            case 32121006: 
            case 35121010: 
            case 61121105: {
                return a2.skill;
            }
        }
        return false;
    }

    public static final /* synthetic */ MapleStatEffect loadSkillEffectFromData(MapleData a2, int a3, boolean a4, int a5, String a6) {
        return MapleStatEffect.ALLATORIxDEMO(a2, a3, true, a4, a5, a6);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ int parseMountInfo_Pure(MapleCharacter a2, int a3) {
        switch (a3) {
            case 1004: 
            case 11004: 
            case 10001004: 
            case 20001004: 
            case 20011004: 
            case 20021004: 
            case 80001000: {
                if (a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18) != null && a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-19) != null) {
                    return a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-18).getItemId();
                }
                return 0;
            }
        }
        return GameConstants.getMountItem(a3, a2);
    }

    public final /* synthetic */ int getZ() {
        MapleStatEffect a2;
        return a2.z;
    }

    public final /* synthetic */ List<Integer> getPetsCanConsume() {
        MapleStatEffect a2;
        return a2.k;
    }

    public final /* synthetic */ boolean makeChanceResult_s(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.s);
    }

    public final /* synthetic */ int getEnhancedMdef() {
        MapleStatEffect a2;
        return a2.emdef;
    }

    public final /* synthetic */ short getIntX() {
        MapleStatEffect a2;
        return a2.intX;
    }

    public final /* synthetic */ short getWatk() {
        MapleStatEffect a2;
        return a2.watk;
    }

    public /* synthetic */ int getFixDamage() {
        MapleStatEffect a2;
        return a2.fixdamage;
    }

    public final /* synthetic */ boolean isMonsterRiding_() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 1004 || a2.sourceid == 10001004 || a2.sourceid == 20001004 || a2.sourceid == 20011004 || a2.sourceid == 30001004 || a2.sourceid >= 80001000 && a2.sourceid <= 80001033 || a2.sourceid == 80001037 || a2.sourceid == 80001038 || a2.sourceid == 80001039 || a2.sourceid == 80001044 || a2.sourceid >= 80001082 && a2.sourceid <= 80001088 || a2.sourceid == 80001090 || a2.sourceid >= 80001112 && a2.sourceid <= 80001121 || a2.sourceid == 30011159 || a2.sourceid == 30011109 || a2.sourceid == 33001001 || a2.sourceid == 35001002);
    }

    public final /* synthetic */ boolean isBerserk() {
        MapleStatEffect a2;
        return a2.skill && a2.sourceid == 1320006;
    }

    public final /* synthetic */ void applyEnergyBuff(MapleCharacter a2, boolean a3) {
        MapleStatEffect a4;
        List<Pair<MapleBuffStat, Integer>> list = a4.statups;
        long l2 = System.currentTimeMillis();
        list.clear();
        list.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENERGY_CHARGE, a2.getBuffedValue(MapleBuffStat.ENERGY_CHARGE) == null ? 0 : a2.getBuffedValue(MapleBuffStat.ENERGY_CHARGE)));
        if (a3) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveEnergyCharge(a2.getBuffSource(MapleBuffStat.ENERGY_CHARGE), 0, a4.duration / 1000));
            MapleStatEffect mapleStatEffect = a4;
            mapleCharacter.registerEffect(mapleStatEffect, l2, mapleStatEffect.getStatups(), Integer.MAX_VALUE, a2.getId());
            return;
        }
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.cancelEffect(a4, true, -1L);
        MapleCharacter mapleCharacter2 = a2;
        mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.giveForeignEnergyCharge(a2.getId(), mapleCharacter2.getBuffSource(MapleBuffStat.ENERGY_CHARGE), 10000, a4.duration / 1000), false);
        a4.statups = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.ENERGY_CHARGE, 10000));
        MapleStatEffect mapleStatEffect = a4;
        a2.registerEffect(mapleStatEffect, l2, mapleStatEffect.getStatups(), a4.duration, a2.getId());
        a4.statups = list;
    }

    private /* synthetic */ boolean l() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 2311001 || a2.sourceid == 9101000 || a2.sourceid == 9001000);
    }

    public final /* synthetic */ short getMagicX() {
        MapleStatEffect a2;
        return a2.madX;
    }

    public final /* synthetic */ boolean isHeal() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 2301002 || a2.sourceid == 9101000 || a2.sourceid == 9001000);
    }

    public final /* synthetic */ short getHands() {
        MapleStatEffect a2;
        return a2.hands;
    }

    public /* synthetic */ int getSubTime() {
        MapleStatEffect a2;
        return a2.subTime;
    }

    public final /* synthetic */ boolean makeChanceResult_w(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.w);
    }

    public final /* synthetic */ boolean makeSubChanceResult() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        return mapleStatEffect.makeChanceResult(null, mapleStatEffect.subProp);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isDivineShield() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1220013: {
                return a2.skill;
            }
        }
        return false;
    }

    public final /* synthetic */ short getDexX() {
        MapleStatEffect a2;
        return a2.dexX;
    }

    public final /* synthetic */ short getStrX() {
        MapleStatEffect a2;
        return a2.strX;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isPirateMorph() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 13111005: {
                if (GameSetConstants.MAPLE_VERSION < 134) break;
                return a2.skill;
            }
            case 5111005: 
            case 5121003: 
            case 15111002: {
                return a2.skill;
            }
        }
        return false;
    }

    public final /* synthetic */ boolean makeChanceResult_s() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        return mapleStatEffect.makeChanceResult(null, mapleStatEffect.s);
    }

    public final /* synthetic */ boolean makeChanceResult() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        return mapleStatEffect.makeChanceResult(null, mapleStatEffect.prop);
    }

    public final /* synthetic */ boolean makeSubChanceResult(MapleCharacter a2) {
        MapleStatEffect a3;
        MapleStatEffect mapleStatEffect = a3;
        return mapleStatEffect.makeChanceResult(a2, mapleStatEffect.subProp);
    }

    public final /* synthetic */ short getTeRRate() {
        MapleStatEffect a2;
        return a2.terR;
    }

    public final /* synthetic */ short getHp() {
        MapleStatEffect a2;
        return a2.hp;
    }

    public final /* synthetic */ byte getMobCount() {
        MapleStatEffect a2;
        return a2.mobCount;
    }

    public final /* synthetic */ List<Pair<MapleBuffStat, Integer>> getStatups() {
        MapleStatEffect a2;
        return a2.statups;
    }

    public final /* synthetic */ int getMDF() {
        MapleStatEffect a2;
        return a2.MDF;
    }

    public final /* synthetic */ int getPrice() {
        MapleStatEffect a2;
        return a2.price;
    }

    public /* synthetic */ int getTargetPlus() {
        MapleStatEffect a2;
        return a2.targetPlus;
    }

    public final /* synthetic */ boolean isReturnScroll() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 80001040 || a2.sourceid == 20021110 || a2.sourceid == 20031203 || a2.sourceid == 60011220 || a2.sourceid == 80001040);
    }

    public final /* synthetic */ boolean isMesoGuard() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 4211005 || a2.sourceid == 4201011);
    }

    public final /* synthetic */ int getEnhancedWdef() {
        MapleStatEffect a2;
        return a2.ewdef;
    }

    public final /* synthetic */ short getLukX() {
        MapleStatEffect a2;
        return a2.lukX;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ MapleStatEffect ALLATORIxDEMO(MapleCharacter a2) {
        switch (a2.getJob()) {
            case 411: 
            case 412: {
                ISkill iSkill = SkillFactory.getSkill(4110000);
                if (a2.getSkillLevel(iSkill) <= 0) {
                    return null;
                }
                return iSkill.getEffect(a2.getSkillLevel(iSkill));
            }
            case 1411: 
            case 1412: {
                ISkill iSkill = SkillFactory.getSkill(14110003);
                if (a2.getSkillLevel(iSkill) <= 0) {
                    return null;
                }
                return iSkill.getEffect(a2.getSkillLevel(iSkill));
            }
        }
        return null;
    }

    public final /* synthetic */ short getDamage() {
        MapleStatEffect a2;
        return a2.damage;
    }

    public /* synthetic */ int getItemSkillLevel() {
        MapleStatEffect a2;
        return a2.ItemSkillLevel;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean isMonsterBuff() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1111007: 
            case 1201006: 
            case 1211009: 
            case 1311007: 
            case 2101003: 
            case 2111004: 
            case 2201003: 
            case 2211004: 
            case 2311005: 
            case 4111003: 
            case 4121004: 
            case 4221004: 
            case 4321002: 
            case 4341003: 
            case 5011002: 
            case 12101001: 
            case 12111002: 
            case 14111001: 
            case 22121000: 
            case 22131002: 
            case 22141003: 
            case 22151001: 
            case 22161002: 
            case 32110000: 
            case 32120000: 
            case 32120001: 
            case 35111005: 
            case 51111005: 
            case 90001002: 
            case 90001003: 
            case 90001004: 
            case 90001005: 
            case 90001006: {
                return a2.skill;
            }
        }
        return false;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, MapleCharacter a3, boolean a4, Point a5, int a6) {
        MapleStatEffect a7;
        return a7.applyTo(a2, a3, a4, a5, a6, false);
    }

    public final /* synthetic */ int getY() {
        MapleStatEffect a2;
        return a2.y;
    }

    public final /* synthetic */ int getSubProp() {
        MapleStatEffect a2;
        return a2.subProp;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isDivineBody() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1010: 
            case 10001010: 
            case 20001010: 
            case 20011010: 
            case 30001010: {
                return a2.skill;
            }
        }
        return false;
    }

    public /* synthetic */ int getSoulMpCon() {
        MapleStatEffect a2;
        return a2.soulmpCon;
    }

    public final /* synthetic */ boolean makeChanceResult_z() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        return mapleStatEffect.makeChanceResult(null, mapleStatEffect.z);
    }

    public final /* synthetic */ int getInflation() {
        MapleStatEffect a2;
        return a2.inflation;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, int a3) {
        MapleStatEffect a4;
        return a4.applyTo(a2, a3, true);
    }

    public final /* synthetic */ int getEnhancedWatk() {
        MapleStatEffect a2;
        return a2.ewatk;
    }

    public final /* synthetic */ int getConsumeOnPickup() {
        MapleStatEffect a2;
        return a2.consumeOnPickup;
    }

    public final /* synthetic */ short getJump() {
        MapleStatEffect a2;
        return a2.jump;
    }

    public final /* synthetic */ short getMesoRate() {
        MapleStatEffect a2;
        return a2.mesoR;
    }

    public final /* synthetic */ short getAcc() {
        MapleStatEffect a2;
        return a2.acc;
    }

    public final /* synthetic */ int getSelfDestruction() {
        MapleStatEffect a2;
        return a2.selfDestruction;
    }

    public final /* synthetic */ void applyLunarTideBuff(MapleCharacter a2) {
        if (a2.getStat().getHp() > 0 && a2.getStat().getMp() > 0) {
            MapleStatEffect a3;
            double d2;
            MapleCharacter mapleCharacter = a2;
            double d3 = a2.getStat().getCurrentMaxHp() / mapleCharacter.getStat().getHp();
            int n2 = d3 >= (d2 = (double)(mapleCharacter.getStat().getCurrentMaxMp() / a2.getStat().getMp())) ? 1 : 2;
            LinkedList<Pair<MapleBuffStat, Integer>> linkedList = new LinkedList<Pair<MapleBuffStat, Integer>>();
            linkedList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.LUNAR_TIDE, n2));
            MapleCharacter mapleCharacter2 = a2;
            mapleCharacter2.getClient().sendPacket(MaplePacketCreator.giveBuff(a3.sourceid, Integer.MAX_VALUE, linkedList, a3, a2));
            mapleCharacter2.registerEffect(a3, System.currentTimeMillis(), linkedList, Integer.MAX_VALUE, a2.getId());
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ int ALLATORIxDEMO(int a2) {
        switch (a2) {
            case 211: 
            case 212: {
                return 2110001;
            }
            case 221: 
            case 222: {
                return 2210001;
            }
            case 1211: 
            case 1212: {
                return 12110001;
            }
        }
        return -1;
    }

    public final /* synthetic */ void silentApplyBuff(MapleCharacter a2, long a3, int a42, List<Pair<MapleBuffStat, Integer>> a5, int a6) {
        MapleStatEffect a7;
        long l2 = a3;
        a2.registerEffect(a7, l2, a5, a42, a6);
        int n2 = a42 = l2 + (long)a42 < System.currentTimeMillis() ? 1 : 0;
        if (a42 != 0) {
            a2.cancelEffect(a7, false, a3);
        }
        if ((a42 = a7.getSummonMovementType()) != null) {
            MapleCharacter mapleCharacter = a2;
            Object a42 = new MapleSummon(mapleCharacter, a7, mapleCharacter.getPosition(), (SummonMovementType)a42);
            if (!((MapleSummon)a42).isPuppet()) {
                MapleCharacter mapleCharacter2 = a2;
                mapleCharacter2.getCheatTracker().resetSummonAttack();
                mapleCharacter2.getMap().spawnSummon((MapleSummon)a42);
                MapleStatEffect mapleStatEffect = a7;
                mapleCharacter2.getSummons().add((MapleSummon)a42);
                ((MapleSummon)a42).addHP((short)mapleStatEffect.x);
                if (mapleStatEffect.isBeholder()) {
                    ((MapleSummon)a42).addHP((short)1);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isCharge() {
        MapleStatEffect a2;
        switch (a2.sourceid) {
            case 1211003: 
            case 1211008: 
            case 11111007: 
            case 12101005: 
            case 15101006: 
            case 21111005: {
                return a2.skill;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ int parseMountInfo(MapleCharacter a2, int a3) {
        switch (a3) {
            case 1004: 
            case 11004: 
            case 10001004: 
            case 20001004: 
            case 20011004: 
            case 20021004: 
            case 80001000: {
                if (a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118) != null && a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-119) != null) {
                    return a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-118).getItemId();
                }
                return MapleStatEffect.parseMountInfo_Pure(a2, a3);
            }
        }
        return GameConstants.getMountItem(a3, a2);
    }

    public final /* synthetic */ int getDamAbsorbShieldR() {
        MapleStatEffect a2;
        return a2.damAbsorbShieldR;
    }

    public final /* synthetic */ boolean applyTo(MapleCharacter a2, int a3, boolean a4) {
        MapleStatEffect a5;
        MapleCharacter mapleCharacter = a2;
        return a5.applyTo(mapleCharacter, mapleCharacter, true, null, a3, false, a4, false);
    }

    public final /* synthetic */ short getUseLevel() {
        MapleStatEffect a2;
        return a2.useLevel;
    }

    public final /* synthetic */ void applyKaiser_Combo(MapleCharacter a2, int a32) {
        MapleStatEffect a4;
        List<Pair<MapleBuffStat, Integer>> a32 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.KAISER_COMBO, a32));
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveBuff(0, 99999, a32, a4, a2));
        mapleCharacter.registerEffect(a4, System.currentTimeMillis(), a32, Integer.MAX_VALUE, a2.getId());
        if (!mapleCharacter.isHidden()) {
            MapleCharacter mapleCharacter2 = a2;
            a2.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.giveForeignBuff(mapleCharacter2, a32, a4), false);
        }
    }

    public final /* synthetic */ double getHpR() {
        MapleStatEffect a2;
        return a2.hpR;
    }

    public final /* synthetic */ int getIgnoreMobDamR() {
        MapleStatEffect a2;
        return a2.ignoreMobDamR;
    }

    public final /* synthetic */ int getCooltimeReduceR() {
        MapleStatEffect a2;
        return a2.coolTimeR;
    }

    public static /* synthetic */ void addBuffStatPairToListIfNotZero(List<Pair<MapleBuffStat, Integer>> a2, MapleBuffStat a3, Integer a4) {
        if (a4 != 0) {
            a2.add(new Pair<MapleBuffStat, Integer>(a3, a4));
        }
    }

    public final /* synthetic */ void setOverTime(boolean a2) {
        a.overTime = a2;
    }

    public final /* synthetic */ short getDOTTime() {
        MapleStatEffect a2;
        return a2.dotTime;
    }

    public final /* synthetic */ void applyBlackBlessingBuff(MapleCharacter a2, int a32) {
        MapleStatEffect a4;
        List<Pair<MapleBuffStat, Integer>> a32 = Collections.singletonList(new Pair<MapleBuffStat, Integer>(MapleBuffStat.BLACK_BLESSING, a32));
        MapleCharacter mapleCharacter = a2;
        mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveBuff(a4.sourceid, Integer.MAX_VALUE, a32, a4, a2));
        mapleCharacter.registerEffect(a4, System.currentTimeMillis(), a32, Integer.MAX_VALUE, a2.getId());
        if (!mapleCharacter.isHidden()) {
            MapleCharacter mapleCharacter2 = a2;
            a2.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.giveForeignBuff(mapleCharacter2, a32, a4), false);
        }
    }

    public final /* synthetic */ boolean isAngel() {
        MapleStatEffect a2;
        return GameConstants.isAngel(a2.sourceid);
    }

    public final /* synthetic */ boolean isSoaring_Normal() {
        MapleStatEffect a2;
        return a2.skill && JobConstants.isBeginnerJob(a2.sourceid / 10000) && a2.sourceid % 10000 == 1026;
    }

    public final /* synthetic */ int getEXP() {
        MapleStatEffect a2;
        return a2.exp;
    }

    public final /* synthetic */ int getType() {
        MapleStatEffect a2;
        return a2.type;
    }

    public final /* synthetic */ void setSourceId(int a2) {
        a.sourceid = a2;
    }

    public final /* synthetic */ boolean sameSource(MapleStatEffect a2) {
        MapleStatEffect a3;
        return a2 != null && a3.sourceid == a2.sourceid && a3.skill == a2.skill;
    }

    private /* synthetic */ int ALLATORIxDEMO() {
        MapleStatEffect a2;
        return a2.fatigue;
    }

    public final /* synthetic */ int getX() {
        MapleStatEffect a2;
        return a2.x;
    }

    public /* synthetic */ boolean isEnergyCharge() {
        MapleStatEffect a2;
        return a2.skill && (a2.sourceid == 5110001 || a2.sourceid == 15100004);
    }

    public /* synthetic */ int getMpCon() {
        MapleStatEffect a2;
        return a2.mpCon;
    }

    public final /* synthetic */ short getER() {
        MapleStatEffect a2;
        return a2.er;
    }

    public final /* synthetic */ byte getPeriod() {
        MapleStatEffect a2;
        return a2.period;
    }

    public final /* synthetic */ int getS() {
        MapleStatEffect a2;
        return a2.s;
    }

    public final /* synthetic */ short getLuk() {
        MapleStatEffect a2;
        return a2.luk;
    }

    public final /* synthetic */ void applyMonsterBuff(MapleCharacter a2) {
        List<MapleMapObject> list;
        Object object;
        MapleStatEffect a3;
        Rectangle rectangle = a3.calculateBoundingBox(a2.getTruePosition(), a2.isFacingLeft());
        boolean bl = a2.inPVP();
        Object object2 = object = bl ? MapleMapObjectType.PLAYER : MapleMapObjectType.MONSTER;
        if (a3.sourceid == 35111005) {
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = object;
            list = a2.getMap().getMapObjectsInRange(a2.getTruePosition(), Double.POSITIVE_INFINITY, Arrays.asList(arrmapleMapObjectType));
        } else {
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = object;
            list = a2.getMap().getMapObjectsInRect(rectangle, Arrays.asList(arrmapleMapObjectType));
        }
        Object object3 = list;
        byte by = 0;
        object = object3.iterator();
        while (object.hasNext()) {
            object3 = (MapleMapObject)object.next();
            if (a3.makeChanceResult()) {
                boolean bl2;
                block8: {
                    for (Map.Entry<MonsterStatus, Integer> entry : a3.getMonsterStati().entrySet()) {
                        AbstractAnimatedMapleMapObject abstractAnimatedMapleMapObject;
                        if (bl) {
                            abstractAnimatedMapleMapObject = (MapleCharacter)object3;
                            MapleBuffStat mapleBuffStat = MonsterStatus.getLinkedDisease(entry.getKey());
                            if (mapleBuffStat == null) continue;
                            ((MapleCharacter)abstractAnimatedMapleMapObject).giveDebuff(mapleBuffStat, entry.getValue(), a3.getDuration(), MobSkill.getByDisease(mapleBuffStat), 1);
                            continue;
                        }
                        abstractAnimatedMapleMapObject = (MapleMonster)object3;
                        if (a3.sourceid == 35111005 && ((MapleMonster)abstractAnimatedMapleMapObject).getStats().isBoss()) {
                            bl2 = bl;
                            break block8;
                        }
                        MapleStatEffect mapleStatEffect = a3;
                        boolean bl3 = mapleStatEffect.isSubTime(mapleStatEffect.sourceid) && a3.getSubTime() > 0;
                        MapleStatEffect mapleStatEffect2 = a3;
                        long l2 = bl3 ? (long)mapleStatEffect2.getSubTime() : (long)mapleStatEffect2.getDuration();
                        ((MapleMonster)abstractAnimatedMapleMapObject).applyStatus(a2, new MonsterStatusEffect(entry.getKey(), entry.getValue(), a3.sourceid, null, false), a3.isPoison(), l2, true, a3);
                    }
                    bl2 = bl;
                }
                if (bl2 && a3.skill) {
                    MapleCharacter mapleCharacter = (MapleCharacter)object3;
                    a3.handleExtraPVP(a2, mapleCharacter);
                }
            }
            if (++by < a3.mobCount || a3.sourceid == 35111005) continue;
            return;
        }
    }

    public static final /* synthetic */ MapleStatEffect loadItemEffectFromData(MapleData a2, int a3) {
        return MapleStatEffect.ALLATORIxDEMO(a2, a3, false, false, 1, null);
    }

    public final /* synthetic */ boolean makeChanceResult(MapleCharacter a2, int a3) {
        if (a2 != null) {
            MapleStatEffect a4;
            a3 += a2.getStat().getSkillPropIncrease(a4.sourceid);
        }
        return a3 >= 100 || Randomizer.nextInt(99) < a3;
    }

    public final /* synthetic */ boolean makeChanceResult_y() {
        MapleStatEffect a2;
        MapleStatEffect mapleStatEffect = a2;
        return mapleStatEffect.makeChanceResult(null, mapleStatEffect.y);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean isSubTime(int a2) {
        switch (a2) {
            case 23111008: 
            case 23111009: 
            case 23111010: 
            case 31101003: 
            case 31121003: 
            case 31121005: {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ double getMaxDistanceSq() {
        MapleStatEffect a2;
        int n2 = Math.max(Math.abs(a2.lt == null ? 0 : a2.lt.x), Math.abs(a2.rb == null ? 0 : a2.rb.x));
        int n3 = Math.max(Math.abs(a2.lt == null ? 0 : a2.lt.y), Math.abs(a2.rb == null ? 0 : a2.rb.y));
        int n4 = n2;
        int n5 = n3;
        return n4 * n4 + n5 * n5;
    }

    public final /* synthetic */ boolean isSoaring_Mount() {
        MapleStatEffect a2;
        return a2.skill && (JobConstants.isBeginnerJob(a2.sourceid / 10000) && a2.sourceid % 10000 == 1142 || a2.sourceid == 80001089);
    }

    public final /* synthetic */ int getBerserk() {
        MapleStatEffect a2;
        return a2.berserk;
    }

    public final /* synthetic */ byte getBulletCount() {
        MapleStatEffect a2;
        return a2.bulletCount;
    }

    public final /* synthetic */ byte getEXPRate() {
        MapleStatEffect a2;
        return a2.expR;
    }

    public final /* synthetic */ short getASRRate() {
        MapleStatEffect a2;
        return a2.asrR;
    }

    public final /* synthetic */ double getMpR() {
        MapleStatEffect a2;
        return a2.mpR;
    }

    public static class CancelEffectAction
    implements Runnable {
        private /* synthetic */ long ALLATORIxDEMO;
        private /* synthetic */ MapleStatEffect a;
        private /* synthetic */ WeakReference<MapleCharacter> d;

        @Override
        public /* synthetic */ void run() {
            CancelEffectAction a2;
            MapleCharacter mapleCharacter = (MapleCharacter)a2.d.get();
            if (mapleCharacter != null && !mapleCharacter.isClone()) {
                mapleCharacter.cancelEffect(a2.a, false, a2.ALLATORIxDEMO);
            }
        }

        public /* synthetic */ CancelEffectAction(MapleCharacter a2, MapleStatEffect a3, long a4) {
            CancelEffectAction a5;
            CancelEffectAction cancelEffectAction = a5;
            a5.a = a3;
            CancelEffectAction cancelEffectAction2 = a5;
            cancelEffectAction.d = new WeakReference<MapleCharacter>(a2);
            cancelEffectAction.ALLATORIxDEMO = a4;
        }
    }
}

