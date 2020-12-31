/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 *  constants.ItemConstants$\u985e\u578b
 */
package client;

import client.ISkill;
import client.MapleCharacter;
import client.MapleCoreAura;
import client.MapleJob;
import client.MapleStat;
import client.MapleTrait;
import client.Skill;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.ItemCustomFlag;
import client.inventory.MapleInventoryType;
import client.inventory.MapleWeaponType;
import client.inventory.ModifyInventory;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.ServerConfig;
import handling.opcodes.MapleBuffStat;
import handling.world.World;
import handling.world.guild.MapleGuild;
import handling.world.guild.MapleGuildSkill;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import server.Extend.SpecialEquipFactory;
import server.ItemInformation;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.StructPotentialItem;
import server.life.Element;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;

public class PlayerStats
implements Serializable {
    public transient /* synthetic */ double jobBuff;
    public transient /* synthetic */ int hpRecoverPercent;
    public transient /* synthetic */ int pvpDamage;
    public transient /* synthetic */ int equipmentBonusExp;
    private transient /* synthetic */ float r;
    private transient /* synthetic */ int L;
    public transient /* synthetic */ int EquipMeso;
    public transient /* synthetic */ int expRate;
    public transient /* synthetic */ int recoverHP;
    public /* synthetic */ int hp;
    private transient /* synthetic */ int f;
    private transient /* synthetic */ int A;
    public transient /* synthetic */ int def;
    public transient /* synthetic */ int coolTimeR;
    public transient /* synthetic */ int questBonus;
    public transient /* synthetic */ int mpconPercent;
    public transient /* synthetic */ double carddropBuff;
    public /* synthetic */ int pickRate;
    public transient /* synthetic */ int mpRecoverProp;
    public transient /* synthetic */ int ASR;
    public transient /* synthetic */ int percent_luk;
    public /* synthetic */ int incMaxDamage;
    private transient /* synthetic */ int l;
    public transient /* synthetic */ int trueMastery;
    public transient /* synthetic */ double bossdam_r;
    public transient /* synthetic */ int reduceCooltime;
    public transient /* synthetic */ int EquipDamage;
    private transient /* synthetic */ byte P;
    private static final /* synthetic */ int[] ALLATORIxDEMO;
    private final /* synthetic */ Map<Integer, Integer> E;
    public transient /* synthetic */ int dot;
    public transient /* synthetic */ double dropBuff;
    public /* synthetic */ int InvincibleTimeAfterHit2R;
    public transient /* synthetic */ int dropMod;
    public transient /* synthetic */ double realExpBuff;
    private transient /* synthetic */ float Q;
    public transient /* synthetic */ boolean hasMeso;
    public transient /* synthetic */ double expBuffAdd;
    private transient /* synthetic */ float i;
    public transient /* synthetic */ int dodgeChance;
    private final /* synthetic */ List<Equip> R;
    public transient /* synthetic */ int combatOrders;
    public transient /* synthetic */ double mesoBuff;
    private transient /* synthetic */ short Z;
    public transient /* synthetic */ double cashBuff;
    private static final /* synthetic */ long s = -679541993413738569L;
    public /* synthetic */ short luk;
    public transient /* synthetic */ int percent_wdef;
    public /* synthetic */ short dex;
    public transient /* synthetic */ int dotTime;
    private transient /* synthetic */ float H;
    public transient /* synthetic */ int mpRecover;
    public transient /* synthetic */ int incAllskill;
    public transient /* synthetic */ int cashMod;
    private transient /* synthetic */ int c;
    private transient /* synthetic */ int m;
    public /* synthetic */ int defRange;
    public transient /* synthetic */ int percent_dex;
    public transient /* synthetic */ int percent_str;
    public transient /* synthetic */ int hpRecoverProp;
    public transient /* synthetic */ int BuffUP;
    public transient /* synthetic */ int DAMreduceR;
    public transient /* synthetic */ double mesoGuard;
    private final /* synthetic */ Map<Integer, Integer> g;
    public transient /* synthetic */ int expMod;
    public transient /* synthetic */ int pvpRank;
    public /* synthetic */ short int_;
    public transient /* synthetic */ int hpRecover;
    private transient /* synthetic */ short d;
    public transient /* synthetic */ double expBuff;
    public transient /* synthetic */ int BuffUP_Skill;
    private final /* synthetic */ Map<Integer, Integer> e;
    public transient /* synthetic */ int element_fire;
    private transient /* synthetic */ float S;
    private final transient /* synthetic */ WeakReference<MapleCharacter> n;
    private transient /* synthetic */ short a;
    public /* synthetic */ int maxhp;
    public /* synthetic */ int InvincibleTimeAfterHit2;
    public transient /* synthetic */ boolean Berserk;
    public static final /* synthetic */ int[] pvpSkills;
    public transient /* synthetic */ int percent_acc;
    public transient /* synthetic */ int equippedFairy_;
    private final /* synthetic */ Map<Integer, Integer> v;
    public transient /* synthetic */ int mpRestore;
    public /* synthetic */ int mp;
    private final /* synthetic */ Map<Integer, Integer> B;
    public transient /* synthetic */ int percent_matk;
    public transient /* synthetic */ int RecoveryUP;
    private /* synthetic */ Map<Integer, Integer> F;
    public transient /* synthetic */ int incMesoProp;
    public transient /* synthetic */ double realMesoBuff;
    private transient /* synthetic */ int b;
    public transient /* synthetic */ boolean hasItem;
    public transient /* synthetic */ int hpRecoverTime;
    public transient /* synthetic */ int element_psn;
    public transient /* synthetic */ int TER;
    public static final /* synthetic */ short maxStr = 999;
    public transient /* synthetic */ int ignoreTargetDEF;
    private final /* synthetic */ Map<Integer, Integer> K;
    public transient /* synthetic */ double dam_r;
    public transient /* synthetic */ int decreaseDebuff;
    private transient /* synthetic */ int w;
    public transient /* synthetic */ int EquipExp;
    public transient /* synthetic */ int jump;
    public transient /* synthetic */ int wdef;
    public transient /* synthetic */ boolean hasClone;
    public /* synthetic */ int maxmp;
    public transient /* synthetic */ int element_light;
    public transient /* synthetic */ int recoverMP;
    public transient /* synthetic */ int percent_atk;
    public transient /* synthetic */ boolean hasPartyBonus;
    public transient /* synthetic */ int percent_mdef;
    public transient /* synthetic */ int pvpExp;
    public transient /* synthetic */ int incRewardProp;
    public transient /* synthetic */ int element_ice;
    public transient /* synthetic */ boolean canFish;
    public transient /* synthetic */ boolean equippedFairy;
    public transient /* synthetic */ boolean hasVac;
    public transient /* synthetic */ double realDropBuff;
    public transient /* synthetic */ int mpconReduce;
    public transient /* synthetic */ int percent_hp;
    public transient /* synthetic */ int mpRecoverTime;
    private /* synthetic */ Map<Integer, Integer> I;
    private transient /* synthetic */ byte t;
    public transient /* synthetic */ int equippedSummon;
    public transient /* synthetic */ int EquipDrop;
    public transient /* synthetic */ double realCashBuff;
    public transient /* synthetic */ int percent_int;
    private transient /* synthetic */ float j;
    public transient /* synthetic */ boolean equippedWelcomeBackRing;
    public transient /* synthetic */ int BuffUP_Summon;
    private transient /* synthetic */ float C;
    private transient /* synthetic */ short o;
    public /* synthetic */ ReentrantLock lock;
    private final /* synthetic */ Map<Integer, Integer> k;
    public /* synthetic */ short str;
    public transient /* synthetic */ double mesoGuardMeso;
    private transient /* synthetic */ int h;
    public /* synthetic */ int InvincibleTimeAfterHit;
    public transient /* synthetic */ int DAMreflect_rate;
    private /* synthetic */ EnumMap<Element, Integer> M;
    public transient /* synthetic */ int mdef;
    public transient /* synthetic */ int harvestingTool;
    public transient /* synthetic */ int ignoreDAMr;
    public transient /* synthetic */ boolean isRecalc;
    private transient /* synthetic */ int G;
    public transient /* synthetic */ int ignoreDAM_rate;
    private final /* synthetic */ List<Equip> T;
    private transient /* synthetic */ float J;
    public transient /* synthetic */ double pickupRange;
    private transient /* synthetic */ int D;
    public transient /* synthetic */ int levelBonus;
    public transient /* synthetic */ int MDF;
    public /* synthetic */ int reChargeChance;
    public transient /* synthetic */ boolean canFishVIP;
    public transient /* synthetic */ int ignoreDAMr_rate;
    public transient /* synthetic */ int speed;
    public transient /* synthetic */ int DAMreflect;
    public transient /* synthetic */ int RecoveryUP_Skill;
    public transient /* synthetic */ int percent_mp;
    private transient /* synthetic */ float N;
    public transient /* synthetic */ int ignoreDAM;

    public final /* synthetic */ int getCurrentMaxHp() {
        PlayerStats a2;
        return a2.l;
    }

    public /* synthetic */ boolean checkEquipDurabilitys(MapleCharacter a2, int a3) {
        PlayerStats a4;
        return a4.checkEquipDurabilitys(a2, a3, false);
    }

    private /* synthetic */ int E(MapleCharacter a2) {
        int n2;
        int n3 = 0;
        Iterator iterator = new LinkedList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList linkedList2 = new LinkedList();
        linkedList.add(10000074);
        iterator.add(12000005);
        ISkill iSkill = null;
        int n4 = 0;
        MapleStatEffect mapleStatEffect = null;
        iterator = iterator.iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block0;
                ISkill iSkill2 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill2);
                mapleStatEffect = iSkill2.getEffect(n4);
                if (n4 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getPercentMP();
                continue block0;
            }
            break;
        }
        iterator = linkedList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator;
            while (iterator3.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block2;
                ISkill iSkill3 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill3);
                mapleStatEffect = iSkill3.getEffect(n4);
                if (n4 <= 0) {
                    iterator3 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getX();
                continue block2;
            }
            break;
        }
        iterator = linkedList2.iterator();
        block4: while (true) {
            Iterator iterator4 = iterator;
            while (iterator4.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block4;
                ISkill iSkill4 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill4);
                mapleStatEffect = iSkill4.getEffect(n4);
                if (n4 <= 0) {
                    iterator4 = iterator;
                    continue;
                }
                n3 += mapleStatEffect.getX();
                continue block4;
            }
            break;
        }
        return n3;
    }

    public final /* synthetic */ short getStr() {
        PlayerStats a2;
        return a2.str;
    }

    public final /* synthetic */ int getHands() {
        PlayerStats a2;
        return a2.h;
    }

    public /* synthetic */ void recalcLocalStats() {
        PlayerStats a2;
        a2.recalcLocalStats(false);
    }

    private /* synthetic */ int d(MapleCharacter a2) {
        int n2;
        int n3 = 0;
        Iterator iterator = new LinkedList();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        ISkill iSkill = null;
        int n4 = 0;
        MapleStatEffect mapleStatEffect = null;
        iterator = iterator.iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block0;
                ISkill iSkill2 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill2);
                mapleStatEffect = iSkill2.getEffect(n4);
                if (n4 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getPercentMP();
                continue block0;
            }
            break;
        }
        iterator = linkedList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator;
            while (iterator3.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block2;
                ISkill iSkill3 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill3);
                mapleStatEffect = iSkill3.getEffect(n4);
                if (n4 <= 0) {
                    iterator3 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getX();
                continue block2;
            }
            break;
        }
        iterator = linkedList2.iterator();
        block4: while (true) {
            Iterator iterator4 = iterator;
            while (iterator4.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block4;
                ISkill iSkill4 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill4);
                mapleStatEffect = iSkill4.getEffect(n4);
                if (n4 <= 0) {
                    iterator4 = iterator;
                    continue;
                }
                n3 += mapleStatEffect.getX();
                continue block4;
            }
            break;
        }
        return n3;
    }

    public final /* synthetic */ void setInt(short a2) {
        PlayerStats a3;
        a3.int_ = a2;
        a3.recalcLocalStats();
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void handlePassiveSkills(MapleCharacter a2) {
        ISkill iSkill = null;
        int n2 = 0;
        MapleStatEffect mapleStatEffect = null;
        switch (a2.getJob()) {
            case 100: 
            case 110: 
            case 111: 
            case 112: 
            case 120: 
            case 121: 
            case 122: 
            case 130: 
            case 131: 
            case 132: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(1210001);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.percent_wdef += mapleStatEffect.getX();
                    playerStats.percent_mdef += mapleStatEffect.getX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(1220005))) > 0) {
                    a3.percent_wdef += iSkill.getEffect(n2).getT();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(1220010))) <= 0) return;
                a3.trueMastery += iSkill.getEffect(n2).getMastery();
                return;
            }
            case 322: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(3220004);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.f += mapleStatEffect.getX();
                    playerStats.trueMastery += mapleStatEffect.getMastery();
                    playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(3220009))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ignoreTargetDEF += mapleStatEffect.getIgnoreMob();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(3220005))) <= 0 || a2.getBuffedValue(MapleBuffStat.SPIRIT_LINK) == null) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.percent_hp += mapleStatEffect.getX();
                playerStats.dam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                playerStats.bossdam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                return;
            }
            case 312: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(3120005);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    a3.f += iSkill.getEffect(n2).getX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(3120011))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ignoreTargetDEF += mapleStatEffect.getIgnoreMob();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(3120006))) <= 0 || a2.getBuffedValue(MapleBuffStat.SPIRIT_LINK) == null) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.percent_hp += mapleStatEffect.getX();
                playerStats.dam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                playerStats.bossdam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                return;
            }
            case 400: 
            case 410: 
            case 411: 
            case 412: {
                PlayerStats a3;
                a3.defRange = 200;
                iSkill = SkillFactory.getSkill(4000001);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    a3.defRange += iSkill.getEffect(n2).getRange();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4100006))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ASR += mapleStatEffect.getASRRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4100007))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.G += mapleStatEffect.getDexX();
                    playerStats.b += mapleStatEffect.getLukX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4110008))) <= 0 || iSkill == null) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.ASR += mapleStatEffect.getASRRate();
                playerStats.TER += mapleStatEffect.getTeRRate();
                return;
            }
            case 420: 
            case 421: 
            case 422: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(4200006);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ASR += mapleStatEffect.getASRRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4210000))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.percent_wdef += mapleStatEffect.getX();
                    playerStats.percent_mdef += mapleStatEffect.getX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4200007))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.G += mapleStatEffect.getDexX();
                    playerStats.b += mapleStatEffect.getLukX();
                }
                iSkill = SkillFactory.getSkill(4200010);
                MapleCharacter mapleCharacter = a2;
                n2 = mapleCharacter.getTotalSkillLevel(iSkill);
                IItem iItem = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-10);
                if (n2 <= 0 || iItem == null || !ItemConstants.\u985e\u578b.\u76fe\u724c((int)iItem.getItemId())) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.percent_wdef += mapleStatEffect.getWDEFRate();
                playerStats.percent_mdef += mapleStatEffect.getMDEFRate();
                playerStats.D += mapleStatEffect.getER();
                return;
            }
            case 431: 
            case 432: 
            case 433: 
            case 434: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(4310004);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ASR += mapleStatEffect.getASRRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4341006))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.percent_wdef += mapleStatEffect.getWDEFRate();
                    playerStats.percent_mdef += mapleStatEffect.getMDEFRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(4310006))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.G += mapleStatEffect.getDexX();
                playerStats.b += mapleStatEffect.getLukX();
                return;
            }
            case 501: 
            case 530: 
            case 531: 
            case 532: {
                PlayerStats a3;
                a3.defRange = 200;
                iSkill = SkillFactory.getSkill(5010003);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    a3.f += iSkill.getEffect(n2).getAttackX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(5300008))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.w += mapleStatEffect.getStrX();
                    playerStats.G += mapleStatEffect.getDexX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(5311001))) > 0) {
                    a3.F.put(5301001, Integer.valueOf(iSkill.getEffect(n2).getDAMRate()));
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(5310007))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.ASR += mapleStatEffect.getASRRate();
                    playerStats.percent_wdef += mapleStatEffect.getWDEFRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(5310006))) > 0) {
                    a3.f += iSkill.getEffect(n2).getAttackX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(0x513131))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.dam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                playerStats.bossdam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                playerStats.ignoreTargetDEF += mapleStatEffect.getIgnoreMob();
                return;
            }
            case 570: 
            case 571: 
            case 572: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(5700005);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                a3.N += (float)(a3.l / 100 * mapleStatEffect.getX());
                a3.hpRecoverTime = mapleStatEffect.getY() * 1000;
                a3.S += (float)(a3.m / 100 * mapleStatEffect.getX());
                a3.mpRecoverTime = mapleStatEffect.getY() * 1000;
                return;
            }
            case 3001: 
            case 3100: 
            case 3110: 
            case 3111: 
            case 3112: {
                PlayerStats a3;
                a3.mpRecoverProp = 100;
                iSkill = SkillFactory.getSkill(31100007);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.F.put(31000004, Integer.valueOf(mapleStatEffect.getDAMRate()));
                    a3.F.put(31001006, Integer.valueOf(mapleStatEffect.getDAMRate()));
                    a3.F.put(31001007, Integer.valueOf(mapleStatEffect.getDAMRate()));
                    a3.F.put(31001008, Integer.valueOf(mapleStatEffect.getDAMRate()));
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31100005))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.w += mapleStatEffect.getStrX();
                    playerStats.G += mapleStatEffect.getDexX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31100010))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.F.put(31000004, mapleStatEffect.getX());
                    a3.F.put(31001006, mapleStatEffect.getX());
                    a3.F.put(31001007, mapleStatEffect.getX());
                    a3.F.put(31001008, mapleStatEffect.getX());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31111007))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31110008))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dodgeChance += mapleStatEffect.getX();
                    playerStats.hpRecoverPercent += mapleStatEffect.getY();
                    playerStats.hpRecoverProp += mapleStatEffect.getX();
                    playerStats.mpRecover += mapleStatEffect.getY();
                    playerStats.mpRecoverProp += mapleStatEffect.getX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31110009))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    ++playerStats.mpRecover;
                    playerStats.mpRecoverProp += mapleStatEffect.getProp();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31111006))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dam_r *= ((double)mapleStatEffect.getX() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getX() + 100.0) / 100.0;
                    playerStats.P = (byte)(playerStats.P + mapleStatEffect.getY());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31121006))) > 0) {
                    a3.ignoreTargetDEF += iSkill.getEffect(n2).getIgnoreMob();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31120011))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.F.put(31000004, mapleStatEffect.getX());
                    a3.F.put(31001006, mapleStatEffect.getX());
                    a3.F.put(31001007, mapleStatEffect.getX());
                    a3.F.put(31001008, mapleStatEffect.getX());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31120008))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.f += mapleStatEffect.getAttackX();
                    playerStats.trueMastery += mapleStatEffect.getMastery();
                    playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                }
                if ((iSkill = SkillFactory.getSkill(31120009)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.DAMreduceR += mapleStatEffect.getT();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(31120010))) > 0) {
                    a3.percent_wdef += iSkill.getEffect(n2).getT();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(30010112))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.bossdam_r += (double)mapleStatEffect.getBossDamage();
                    playerStats.mpRecover += mapleStatEffect.getX();
                    playerStats.mpRecoverProp += mapleStatEffect.getBossDamage();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(30010185))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    MapleCharacter mapleCharacter = a2;
                    mapleCharacter.getTrait(MapleTrait.MapleTraitType.\u610f\u5fd7).addLocalExp(GameConstants.getTraitExpNeededForLevel(mapleStatEffect.getY()));
                    mapleCharacter.getTrait(MapleTrait.MapleTraitType.\u9818\u5c0e\u529b).addLocalExp(GameConstants.getTraitExpNeededForLevel(mapleStatEffect.getZ()));
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(30010111))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.hpRecoverPercent += mapleStatEffect.getX();
                playerStats.hpRecoverProp += mapleStatEffect.getProp();
                return;
            }
            case 2200: 
            case 2210: 
            case 2211: 
            case 2212: 
            case 2213: 
            case 2214: 
            case 2215: 
            case 2216: 
            case 2217: 
            case 2218: {
                PlayerStats a3;
                a3.A += a2.getTotalSkillLevel(SkillFactory.getSkill(22000000));
                iSkill = SkillFactory.getSkill(22150000);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.mpconPercent += mapleStatEffect.getX() - 100;
                    playerStats.dam_r *= (double)mapleStatEffect.getY() / 100.0;
                    playerStats.bossdam_r *= (double)mapleStatEffect.getY() / 100.0;
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(22160000))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(22170001))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.A += mapleStatEffect.getX();
                playerStats.trueMastery += mapleStatEffect.getMastery();
                playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                return;
            }
            case 2112: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(21120001);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.f += mapleStatEffect.getX();
                playerStats.trueMastery += mapleStatEffect.getMastery();
                playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                return;
            }
            case 2002: 
            case 2300: 
            case 2310: 
            case 2311: 
            case 2312: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(20020002);
                if (iSkill != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    a3.RecoveryUP += iSkill.getEffect(n2).getX() - 100;
                }
                if ((iSkill = SkillFactory.getSkill(20021110)) != null && (n2 = a2.getSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.jobBuff += (double)mapleStatEffect.getEXPRate();
                }
                if ((iSkill = SkillFactory.getSkill(20020112)) != null && (n2 = a2.getSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    if (a2.getTrait(MapleTrait.MapleTraitType.\u9b45\u529b).getLevel() < 30) {
                        a2.getTrait(MapleTrait.MapleTraitType.\u9b45\u529b).addTrueExp(GameConstants.getTraitExpNeededForLevel(30), (MapleCharacter)a3.n.get());
                    }
                    PlayerStats playerStats = a3;
                    playerStats.speed += mapleStatEffect.getPassiveSpeed();
                    playerStats.jump += mapleStatEffect.getPassiveJump();
                }
                if ((iSkill = SkillFactory.getSkill(23000001)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dodgeChance += mapleStatEffect.getER();
                    playerStats.speed += mapleStatEffect.getPassiveSpeed();
                }
                if ((iSkill = SkillFactory.getSkill(23100008)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.w += mapleStatEffect.getStrX();
                    playerStats.G += mapleStatEffect.getDexX();
                }
                if ((iSkill = SkillFactory.getSkill(23111004)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.dodgeChance += mapleStatEffect.getProb();
                }
                if ((iSkill = SkillFactory.getSkill(23120010)) == null) return;
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    a3.ignoreTargetDEF += iSkill.getEffect(n2).getX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(23120009))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.f += mapleStatEffect.getX();
                playerStats.trueMastery += mapleStatEffect.getMastery();
                playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                return;
            }
            case 2400: 
            case 2410: 
            case 2411: 
            case 2412: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(20030206);
                if (iSkill != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.G += mapleStatEffect.getDexX();
                    playerStats.dodgeChance += mapleStatEffect.getER();
                    if (a2.getClient().isLoggedIn()) {
                        if (a2.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).getLevel() < 20) {
                            a2.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).addTrueExp(GameConstants.getTraitExpNeededForLevel(20), (MapleCharacter)a3.n.get());
                        }
                        if (a2.getTrait(MapleTrait.MapleTraitType.\u6d1e\u5bdf\u529b).getLevel() < 20) {
                            a2.getTrait(MapleTrait.MapleTraitType.\u6d1e\u5bdf\u529b).addTrueExp(GameConstants.getTraitExpNeededForLevel(20), (MapleCharacter)a3.n.get());
                        }
                    }
                }
                if ((iSkill = SkillFactory.getSkill(24001002)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.speed += mapleStatEffect.getPassiveSpeed();
                    playerStats.jump += mapleStatEffect.getPassiveJump();
                }
                if ((iSkill = SkillFactory.getSkill(24000003)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.dodgeChance += mapleStatEffect.getER();
                }
                if ((iSkill = SkillFactory.getSkill(24100006)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.b += mapleStatEffect.getLukX();
                }
                if ((iSkill = SkillFactory.getSkill(24111002)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.b += mapleStatEffect.getLukX();
                }
                if ((iSkill = SkillFactory.getSkill(24120002)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.dodgeChance += mapleStatEffect.getSubProp();
                }
                if ((iSkill = SkillFactory.getSkill(24120044)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.addCoolTimeReduce(24121005, mapleStatEffect.getCooltimeReduceR());
                }
                if ((iSkill = SkillFactory.getSkill(24120045)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.addTargetPlus(24121005, mapleStatEffect.getTargetPlus());
                }
                if ((iSkill = SkillFactory.getSkill(24120045)) == null || (n2 = a2.getTotalSkillLevel(iSkill)) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                a3.addTargetPlus(24121000, mapleStatEffect.getTargetPlus());
                return;
            }
            case 2004: 
            case 2700: 
            case 2710: 
            case 2711: 
            case 2712: {
                int n3;
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(20040221);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.c += mapleStatEffect.getIntX();
                    if (a2.getClient().isLoggedIn()) {
                        if (a2.getTrait(MapleTrait.MapleTraitType.\u610f\u5fd7).getLevel() < 20) {
                            a2.getTrait(MapleTrait.MapleTraitType.\u610f\u5fd7).addTrueExp(GameConstants.getTraitExpNeededForLevel(20), (MapleCharacter)a3.n.get());
                        }
                        if (a2.getTrait(MapleTrait.MapleTraitType.\u6d1e\u5bdf\u529b).getLevel() < 20) {
                            a2.getTrait(MapleTrait.MapleTraitType.\u6d1e\u5bdf\u529b).addTrueExp(GameConstants.getTraitExpNeededForLevel(20), (MapleCharacter)a3.n.get());
                        }
                    }
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(20040218))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ignoreTargetDEF += mapleStatEffect.getIgnoreMob();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27000106))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    n3 = mapleStatEffect.getmdR();
                    a3.F.put(27001100, n3);
                    a3.F.put(27101100, n3);
                    a3.F.put(27101101, n3);
                    a3.F.put(27111100, n3);
                    a3.F.put(27111101, n3);
                    a3.F.put(27111303, n3);
                    a3.F.put(27121100, n3);
                    a3.F.put(27121201, n3);
                    a3.F.put(27121303, n3);
                    a3.F.put(27121304, n3);
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27000207))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    n3 = mapleStatEffect.getmdR();
                    a3.F.put(27001201, n3);
                    a3.F.put(27101202, n3);
                    a3.F.put(27111202, n3);
                    a3.F.put(27111303, n3);
                    a3.F.put(27121202, n3);
                    a3.F.put(27121303, n3);
                    a3.F.put(27121304, n3);
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27001002))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.speed += mapleStatEffect.getPassiveSpeed();
                    playerStats.jump += mapleStatEffect.getPassiveJump();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27000003))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.wdef += mapleStatEffect.getPddX();
                    playerStats.mdef += mapleStatEffect.getPddX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27100006))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.c += mapleStatEffect.getIntX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27110007))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    if (a2.getStat().getMPPercent() > a2.getStat().getHPPercent()) {
                        n3 = mapleStatEffect.getX();
                        a3.dam_r += (double)n3;
                        a3.bossdam_r += (double)n3;
                    } else {
                        a3.P = (byte)(a3.P + mapleStatEffect.getProb());
                    }
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(2711004))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.ASR += mapleStatEffect.getASRRate();
                    playerStats.TER += mapleStatEffect.getTeRRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27120007))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.trueMastery += mapleStatEffect.getMastery();
                    playerStats.f += mapleStatEffect.getX();
                    playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27120048))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.addTargetPlus(27121202, mapleStatEffect.getTargetPlus());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(27120050))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                a3.addTargetPlus(27121303, mapleStatEffect.getTargetPlus());
                return;
            }
            case 3211: 
            case 3212: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(32110000);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    a3.ASR += iSkill.getEffect(n2).getASRRate();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(32110001))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                    playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(32120000))) > 0) {
                    a3.A += iSkill.getEffect(n2).getMagicX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(32120001))) <= 0) return;
                a3.dodgeChance += iSkill.getEffect(n2).getER();
                return;
            }
            case 3300: 
            case 3310: 
            case 3311: 
            case 3312: {
                PlayerStats a3;
                a3.defRange = 200;
                iSkill = SkillFactory.getSkill(33120000);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.f += mapleStatEffect.getX();
                    playerStats.trueMastery += mapleStatEffect.getMastery();
                    playerStats.o = (short)(playerStats.o + mapleStatEffect.getCriticalMin());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(33110000))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.dam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getDamage() + 100.0) / 100.0;
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(33120010))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.ignoreTargetDEF += mapleStatEffect.getIgnoreMob();
                    playerStats.dodgeChance += mapleStatEffect.getER();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(32110001))) <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.dam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                playerStats.bossdam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                return;
            }
            case 3510: 
            case 3511: 
            case 3512: {
                a3.defRange = 200;
                iSkill = SkillFactory.getSkill(35100000);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    a3.f += iSkill.getEffect(n2).getAttackX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(35120000))) <= 0) return;
                a3.trueMastery += iSkill.getEffect(n2).getMastery();
                return;
            }
            case 6000: 
            case 6100: 
            case 6110: 
            case 6111: 
            case 6112: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(61000003);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.wdef += mapleStatEffect.getPddX();
                    playerStats.mdef += mapleStatEffect.getMddX();
                }
                if ((iSkill = SkillFactory.getSkill(61100007)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.w += mapleStatEffect.getStrX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(61110006))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    MapleStatEffect mapleStatEffect2 = mapleStatEffect;
                    a3.r = mapleStatEffect.getX();
                    a3.hpRecoverTime = mapleStatEffect2.getW() * 1000;
                    playerStats.Q = mapleStatEffect2.getX();
                    playerStats.mpRecoverTime = mapleStatEffect.getW() * 1000;
                }
                if ((iSkill = SkillFactory.getSkill(61110007)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.w += mapleStatEffect.getStrX();
                }
                if ((iSkill = SkillFactory.getSkill(61120007)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.f += mapleStatEffect.getPadX();
                }
                if ((iSkill = SkillFactory.getSkill(61120010)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.wdef += mapleStatEffect.getPddX();
                    playerStats.mdef += mapleStatEffect.getMddX();
                    playerStats.D += mapleStatEffect.getAccX();
                }
                if ((iSkill = SkillFactory.getSkill(61120011)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ignoreTargetDEF += mapleStatEffect.getIgnoreMob();
                }
                if ((iSkill = SkillFactory.getSkill(61120013)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.f += mapleStatEffect.getPadX();
                    playerStats.bossdam_r += (double)mapleStatEffect.getBossDamage();
                    playerStats.P = (byte)(playerStats.P + mapleStatEffect.getCr());
                }
                if ((iSkill = SkillFactory.getSkill(61120044)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.addDotTime(61121201, mapleStatEffect.getDuration());
                    playerStats.addDotTime(61121100, mapleStatEffect.getDuration());
                }
                if ((iSkill = SkillFactory.getSkill(61120045)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.addAttackCount(61121201, mapleStatEffect.getAttackCount());
                    playerStats.addAttackCount(61121100, mapleStatEffect.getAttackCount());
                }
                if ((iSkill = SkillFactory.getSkill(61120047)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.addDotTime(61121105, mapleStatEffect.getDuration());
                }
                if ((iSkill = SkillFactory.getSkill(61120050)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.addDotTime(61111100, mapleStatEffect.getDuration());
                    playerStats.addDotTime(61111111, mapleStatEffect.getDuration());
                }
                if ((iSkill = SkillFactory.getSkill(61120051)) == null) {
                    return;
                }
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 <= 0) return;
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.addAttackCount(61111100, mapleStatEffect.getAttackCount());
                playerStats.addAttackCount(61111111, mapleStatEffect.getAttackCount());
                return;
            }
            case 6001: 
            case 6500: 
            case 6510: 
            case 6511: 
            case 6512: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(60010217);
                if (iSkill != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    IItem iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
                    if (iItem != null && GameConstants.getWeaponType(iItem.getItemId()) == MapleWeaponType.\u9748\u9b42\u5c04\u624b) {
                        a3.trueMastery += mapleStatEffect.getMastery();
                    }
                }
                if ((iSkill = SkillFactory.getSkill(65000003)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.reChargeChance += mapleStatEffect.getX();
                }
                if ((iSkill = SkillFactory.getSkill(65100004)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.G += mapleStatEffect.getDexX();
                }
                if ((iSkill = SkillFactory.getSkill(65100005)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.ASR += mapleStatEffect.getASRRate();
                    playerStats.TER += mapleStatEffect.getTeRRate();
                }
                if ((iSkill = SkillFactory.getSkill(65110005)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.wdef += mapleStatEffect.getPddX();
                    playerStats.mdef += mapleStatEffect.getPddX();
                }
                if ((iSkill = SkillFactory.getSkill(65110006)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.G += mapleStatEffect.getDexX();
                    playerStats.dam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getDAMRate() + 100.0) / 100.0;
                }
                if ((iSkill = SkillFactory.getSkill(65120006)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.G += mapleStatEffect.getDexX();
                    playerStats.dam_r *= ((double)mapleStatEffect.getY() + 100.0) / 100.0;
                    playerStats.bossdam_r *= ((double)mapleStatEffect.getY() + 100.0) / 100.0;
                }
                if ((iSkill = SkillFactory.getSkill(65120047)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.F.put(65121002, mapleStatEffect.getU());
                }
                if ((iSkill = SkillFactory.getSkill(65120048)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.addCoolTimeReduce(65121002, mapleStatEffect.getCooltimeReduceR());
                }
                if ((iSkill = SkillFactory.getSkill(65120050)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.addCoolTimeReduce(65121003, mapleStatEffect.getCooltimeReduceR());
                }
                if ((iSkill = SkillFactory.getSkill(65120051)) == null || (n2 = a2.getTotalSkillLevel(iSkill)) <= 0) return;
                a3.addDurationTime(65121003, 4000);
                return;
            }
            case 5000: 
            case 5100: 
            case 5110: 
            case 5111: 
            case 5112: {
                PlayerStats a3;
                iSkill = SkillFactory.getSkill(51000001);
                n2 = a2.getTotalSkillLevel(iSkill);
                if (n2 > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.wdef += mapleStatEffect.getPddX();
                    playerStats.mdef += mapleStatEffect.getMddX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51000002))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.D += mapleStatEffect.getAccX();
                    playerStats.speed += mapleStatEffect.getPassiveSpeed();
                    playerStats.jump += mapleStatEffect.getPassiveJump();
                }
                if ((iSkill = SkillFactory.getSkill(51100000)) != null && (n2 = a2.getTotalSkillLevel(iSkill)) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.w += mapleStatEffect.getStrX();
                    playerStats.G += mapleStatEffect.getDexX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51110000))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.N += (float)mapleStatEffect.getHp();
                    a3.hpRecoverTime = 4000;
                    a3.S += (float)mapleStatEffect.getMp();
                    a3.mpRecoverTime = 4000;
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51110001))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.w += mapleStatEffect.getStrX();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51110002))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.percent_atk += mapleStatEffect.getX();
                    playerStats.P = (byte)(playerStats.P + mapleStatEffect.getY());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51120000))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    a3.ignoreTargetDEF += mapleStatEffect.getIgnoreMobpdpR();
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51120001))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.trueMastery += mapleStatEffect.getMastery();
                    playerStats.f += mapleStatEffect.getAttackX();
                    playerStats.d = (short)(playerStats.d + mapleStatEffect.getCriticalMin());
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51120002))) > 0) {
                    mapleStatEffect = iSkill.getEffect(n2);
                    PlayerStats playerStats = a3;
                    playerStats.f += mapleStatEffect.getAttackX();
                    playerStats.F.put(51100002, Integer.valueOf(mapleStatEffect.getDamage()));
                }
                if ((n2 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(51120003))) <= 0) return;
                a3.percent_wdef += iSkill.getEffect(n2).getT();
                return;
            }
        }
    }

    public /* synthetic */ void addCoolTimeReduce(int a2, int a3) {
        PlayerStats a4;
        if (a2 < 0 || a3 <= 0) {
            return;
        }
        if (a4.e.containsKey(a2)) {
            int n2 = a4.e.get(a2);
            a4.e.put(a2, n2 + a3);
            return;
        }
        a4.e.put(a2, a3);
    }

    public final /* synthetic */ short getInt() {
        PlayerStats a2;
        return a2.int_;
    }

    private /* synthetic */ int b(MapleCharacter a2) {
        int n2;
        int n3 = 0;
        Iterator iterator = new LinkedList();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        ISkill iSkill = null;
        int n4 = 0;
        MapleStatEffect mapleStatEffect = null;
        iterator = iterator.iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block0;
                ISkill iSkill2 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill2);
                mapleStatEffect = iSkill2.getEffect(n4);
                if (n4 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getPercentMP();
                continue block0;
            }
            break;
        }
        iterator = linkedList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator;
            while (iterator3.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block2;
                ISkill iSkill3 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill3);
                mapleStatEffect = iSkill3.getEffect(n4);
                if (n4 <= 0) {
                    iterator3 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getX();
                continue block2;
            }
            break;
        }
        iterator = linkedList2.iterator();
        block4: while (true) {
            Iterator iterator4 = iterator;
            while (iterator4.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block4;
                ISkill iSkill4 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill4);
                mapleStatEffect = iSkill4.getEffect(n4);
                if (n4 <= 0) {
                    iterator4 = iterator;
                    continue;
                }
                n3 += mapleStatEffect.getX();
                continue block4;
            }
            break;
        }
        return n3;
    }

    public /* synthetic */ void addSkillProp(int a2, int a3) {
        PlayerStats a4;
        if (a2 < 0 || a3 <= 0) {
            return;
        }
        if (a4.K.containsKey(a2)) {
            int n2 = a4.K.get(a2);
            a4.K.put(a2, n2 + a3);
            return;
        }
        a4.K.put(a2, a3);
    }

    private /* synthetic */ int D(MapleCharacter a2) {
        int n2;
        int n3 = 0;
        Iterator iterator = new LinkedList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        iterator.add(110);
        iterator.add(2000006);
        linkedList.add(50000074);
        linkedList2.add(5710004);
        ISkill iSkill = null;
        int n4 = 0;
        MapleStatEffect mapleStatEffect = null;
        iterator = iterator.iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block0;
                ISkill iSkill2 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill2);
                mapleStatEffect = iSkill2.getEffect(n4);
                if (n4 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getPercentMP();
                continue block0;
            }
            break;
        }
        iterator = linkedList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator;
            while (iterator3.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block2;
                ISkill iSkill3 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill3);
                mapleStatEffect = iSkill3.getEffect(n4);
                if (n4 <= 0) {
                    iterator3 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getX();
                continue block2;
            }
            break;
        }
        iterator = linkedList2.iterator();
        block4: while (true) {
            Iterator iterator4 = iterator;
            while (iterator4.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block4;
                ISkill iSkill4 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill4);
                mapleStatEffect = iSkill4.getEffect(n4);
                if (n4 <= 0) {
                    iterator4 = iterator;
                    continue;
                }
                n3 += mapleStatEffect.getX();
                continue block4;
            }
            break;
        }
        return n3;
    }

    public /* synthetic */ void handleGuildSkills(MapleCharacter a2) {
        if (((MapleCharacter)((Object)a2)).getGuildId() > 0 && (a2 = World.Guild.getGuild(((MapleCharacter)((Object)a2)).getGuildId())) != null && ((MapleGuild)((Object)a2)).getSkills().size() > 0) {
            long l2 = System.currentTimeMillis();
            for (MapleGuildSkill mapleGuildSkill : ((MapleGuild)((Object)a2)).getSkills()) {
                PlayerStats a3;
                if (mapleGuildSkill.timestamp <= l2 || mapleGuildSkill.activator.length() <= 0) continue;
                MapleStatEffect mapleStatEffect = SkillFactory.getSkill(mapleGuildSkill.skillID).getEffect(mapleGuildSkill.level);
                PlayerStats playerStats = a3;
                playerStats.P = (byte)(playerStats.P + mapleStatEffect.getCr());
                playerStats.f += mapleStatEffect.getAttackX();
                playerStats.A += mapleStatEffect.getMagicX();
                playerStats.expBuff *= ((double)mapleStatEffect.getEXPRate() + 100.0) / 100.0;
                playerStats.dodgeChance += mapleStatEffect.getER();
                playerStats.percent_wdef += mapleStatEffect.getWDEFRate();
                playerStats.percent_mdef += mapleStatEffect.getMDEFRate();
            }
        }
    }

    public final /* synthetic */ int getAccuracy() {
        PlayerStats a2;
        return a2.D;
    }

    public final /* synthetic */ void setMaxHp(int a2) {
        PlayerStats a3;
        a3.maxhp = a2;
        a3.recalcLocalStats();
    }

    private /* synthetic */ void H(MapleCharacter a2) {
        int n2;
        int n3;
        PlayerStats a3;
        Object object;
        ISkill iSkill = SkillFactory.getSkill(80000000);
        int n4 = a2.getSkillLevel(iSkill);
        if (n4 > 0) {
            object = iSkill.getEffect(n4);
            PlayerStats playerStats = a3;
            playerStats.w += ((MapleStatEffect)object).getStrX();
            playerStats.G += ((MapleStatEffect)object).getDexX();
            playerStats.c += ((MapleStatEffect)object).getIntX();
            playerStats.b += ((MapleStatEffect)object).getLukX();
            playerStats.percent_hp += ((MapleStatEffect)object).getPercentHP();
            playerStats.percent_mp += ((MapleStatEffect)object).getPercentMP();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000001))) > 0) {
            object = iSkill.getEffect(n4);
            a3.bossdam_r += (double)((MapleStatEffect)object).getBossDamage();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000002))) > 0) {
            object = iSkill.getEffect(n4);
            a3.P = (byte)(a3.P + ((MapleStatEffect)object).getCr());
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000003))) > 0) {
            object = iSkill.getEffect(n4);
            PlayerStats playerStats = a3;
            playerStats.w += ((MapleStatEffect)object).getStrX();
            playerStats.G += ((MapleStatEffect)object).getStrX();
            playerStats.c += ((MapleStatEffect)object).getStrX();
            playerStats.b += ((MapleStatEffect)object).getStrX();
            playerStats.f += iSkill.getEffect(n4).getAttackX();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000004))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getDAMRate();
            a3.dam_r += (double)n3;
            a3.bossdam_r += (double)n3;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000005))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getIgnoreMobpdpR();
            a3.ignoreTargetDEF += n3;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000006))) > 0) {
            object = iSkill.getEffect(n4);
            a3.percent_hp += ((MapleStatEffect)object).getPercentHP();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000024))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getDAMRate();
            a3.dam_r += (double)n3;
            a3.bossdam_r += (double)n3;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000047))) > 0) {
            object = iSkill.getEffect(n4);
            PlayerStats playerStats = a3;
            playerStats.w += ((MapleStatEffect)object).getStrX();
            playerStats.G += ((MapleStatEffect)object).getStrX();
            playerStats.c += ((MapleStatEffect)object).getStrX();
            playerStats.b += ((MapleStatEffect)object).getStrX();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000050))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getDAMRate();
            a3.dam_r += (double)n3;
            a3.bossdam_r += (double)n3;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000066))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getASRRate();
            PlayerStats playerStats = a3;
            n2 = playerStats.ASR;
            playerStats.ASR += n3;
            playerStats.TER += n2;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000067))) > 0) {
            object = iSkill.getEffect(n4);
            short s2 = ((MapleStatEffect)object).getASRRate();
            n3 = s2;
            n2 = s2;
            a3.ASR += n2;
            a3.TER += n3;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(0x4C4B444))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getASRRate();
            PlayerStats playerStats = a3;
            n2 = playerStats.ASR;
            playerStats.ASR += n3;
            playerStats.TER += n2;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000069))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getASRRate();
            PlayerStats playerStats = a3;
            n2 = playerStats.ASR;
            PlayerStats playerStats2 = a3;
            playerStats.ASR += playerStats2.ASR;
            playerStats2.TER += n2;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000070))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getASRRate();
            PlayerStats playerStats = a3;
            n2 = playerStats.ASR;
            playerStats.ASR += n3;
            playerStats.TER += n2;
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80000110))) > 0) {
            object = iSkill.getEffect(n4);
            n3 = ((MapleStatEffect)object).getIgnoreMobpdpR();
            a3.ignoreTargetDEF += n3;
            a3.DAMreduceR += ((MapleStatEffect)object).getDamAbsorbShieldR();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80010006))) > 0) {
            object = iSkill.getEffect(n4);
            PlayerStats playerStats = a3;
            playerStats.bossdam_r += (double)((MapleStatEffect)object).getBossDamage();
            playerStats.P = (byte)(playerStats.P + ((MapleStatEffect)object).getCr());
            playerStats.percent_hp += ((MapleStatEffect)object).getPercentHP();
            playerStats.percent_mp += ((MapleStatEffect)object).getPercentMP();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80001040))) > 0) {
            object = iSkill.getEffect(n4);
            a3.jobBuff += (double)((MapleStatEffect)object).getEXPRate();
        }
        if ((n4 = a2.getTotalSkillLevel(iSkill = SkillFactory.getSkill(80001151))) > 0 && (object = a2.getCoreAura()) != null) {
            PlayerStats playerStats = a3;
            playerStats.w += ((MapleCoreAura)object).getStr();
            playerStats.G += ((MapleCoreAura)object).getDex();
            playerStats.c += ((MapleCoreAura)object).getInt();
            playerStats.b += ((MapleCoreAura)object).getLuk();
            playerStats.f += ((MapleCoreAura)object).getWatk();
            playerStats.A += ((MapleCoreAura)object).getMagic();
        }
    }

    public /* synthetic */ void handleSpecialSkills(MapleCharacter a2) {
        PlayerStats a3;
        ISkill iSkill = SkillFactory.getSkill(80000000);
        int n2 = a2.getSkillLevel(iSkill);
        MapleStatEffect mapleStatEffect = null;
        if (n2 > 0) {
            mapleStatEffect = iSkill.getEffect(n2);
            PlayerStats playerStats = a3;
            playerStats.w += mapleStatEffect.getStrX();
            playerStats.G += mapleStatEffect.getDexX();
            playerStats.c += mapleStatEffect.getIntX();
            playerStats.b += mapleStatEffect.getLukX();
            playerStats.percent_hp = (int)((double)playerStats.percent_hp + mapleStatEffect.getHpR());
            playerStats.percent_mp = (int)((double)playerStats.percent_mp + mapleStatEffect.getMpR());
        }
        if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(80000001))) > 0) {
            mapleStatEffect = iSkill.getEffect(n2);
            a3.bossdam_r += (double)mapleStatEffect.getBossDamage();
        }
        if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(80001040))) > 0) {
            a3.expBuff *= ((double)iSkill.getEffect(n2).getEXPRate() + 100.0) / 100.0;
        }
        iSkill = SkillFactory.getSkill(91000001);
        if (a2.getGuild() != null && a2.getGuild().getSkill(91000001) != null) {
            MapleCharacter mapleCharacter = a2;
            n2 = mapleCharacter.getGuild().getSkillLevel(91000001);
            long l2 = mapleCharacter.getGuild().getSkill((int)91000001).timestamp;
            if (n2 > 0 && l2 > System.currentTimeMillis()) {
                a3.expBuff *= ((double)iSkill.getEffect(n2).getEXPRate() + 100.0) / 100.0;
            }
        }
        if (GameConstants.isAdventurer(a2.getJob())) {
            iSkill = SkillFactory.getSkill(74);
            n2 = a2.getSkillLevel(iSkill);
            if (n2 > 0) {
                a3.levelBonus += iSkill.getEffect(n2).getX();
            }
            if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(80))) > 0) {
                a3.levelBonus += iSkill.getEffect(n2).getX();
            }
            if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(10074))) > 0) {
                a3.levelBonus += iSkill.getEffect(n2).getX();
            }
            if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(10080))) > 0) {
                a3.levelBonus += iSkill.getEffect(n2).getX();
            }
            if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(110))) > 0) {
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.w += mapleStatEffect.getStrX();
                playerStats.G += mapleStatEffect.getDexX();
                playerStats.c += mapleStatEffect.getIntX();
                playerStats.b += mapleStatEffect.getLukX();
            }
            if ((n2 = a2.getSkillLevel(iSkill = SkillFactory.getSkill(10110))) > 0) {
                mapleStatEffect = iSkill.getEffect(n2);
                PlayerStats playerStats = a3;
                playerStats.w += mapleStatEffect.getStrX();
                playerStats.G += mapleStatEffect.getDexX();
                playerStats.c += mapleStatEffect.getIntX();
                playerStats.b += mapleStatEffect.getLukX();
                playerStats.percent_hp = (int)((double)playerStats.percent_hp + mapleStatEffect.getHpR());
                playerStats.percent_mp = (int)((double)playerStats.percent_mp + mapleStatEffect.getMpR());
            }
        }
    }

    public final /* synthetic */ void handleProfessionTool(MapleCharacter a2) {
        try {
            if (a2.getProfessionLevel(92000000) > 0 || a2.getProfessionLevel(92010000) > 0) {
                for (Equip equip : a2.getInventory(MapleInventoryType.EQUIP).newList()) {
                    if ((equip.getDurability() == 0 || equip.getItemId() / 10000 != 150 || a2.getProfessionLevel(92000000) <= 0) && (equip.getItemId() / 10000 != 151 || a2.getProfessionLevel(92010000) <= 0)) continue;
                    if (equip.getDurability() > 0) {
                        PlayerStats a3;
                        a3.T.add(equip);
                    }
                    a3.harvestingTool = equip.getPosition();
                    return;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2) {
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            int n2;
            int[] arrn = new int[61];
            arrn[0] = 21120030;
            arrn[1] = 22170030;
            arrn[2] = 23120030;
            arrn[3] = 24120030;
            arrn[4] = 27120030;
            arrn[5] = 61120030;
            arrn[6] = 65120030;
            arrn[7] = 21120031;
            arrn[8] = 22170031;
            arrn[9] = 23120031;
            arrn[10] = 24120031;
            arrn[11] = 27120031;
            arrn[12] = 61120031;
            arrn[13] = 65120031;
            arrn[14] = 21120032;
            arrn[15] = 22170032;
            arrn[16] = 23120032;
            arrn[17] = 24120032;
            arrn[18] = 27120032;
            arrn[19] = 61120032;
            arrn[20] = 65120032;
            arrn[21] = 0x1424421;
            arrn[22] = 22170033;
            arrn[23] = 23120033;
            arrn[24] = 24120033;
            arrn[25] = 27120033;
            arrn[26] = 61120033;
            arrn[27] = 65120033;
            arrn[28] = 190;
            arrn[29] = 10000190;
            arrn[30] = 20000190;
            arrn[31] = 20010190;
            arrn[32] = 20020190;
            arrn[33] = 20030190;
            arrn[34] = 20040190;
            arrn[35] = 30000190;
            arrn[36] = 30010190;
            arrn[37] = 50000190;
            arrn[38] = 60000190;
            arrn[39] = 60010190;
            arrn[40] = 0x1424424;
            arrn[41] = 22170036;
            arrn[42] = 23120036;
            arrn[43] = 24120036;
            arrn[44] = 27120036;
            arrn[45] = 61120036;
            arrn[46] = 65120036;
            arrn[47] = 21120037;
            arrn[48] = 22170037;
            arrn[49] = 23120037;
            arrn[50] = 24120037;
            arrn[51] = 27120037;
            arrn[52] = 61120037;
            arrn[53] = 65120037;
            arrn[54] = 21120038;
            arrn[55] = 22170038;
            arrn[56] = 23120038;
            arrn[57] = 24120038;
            arrn[58] = 27120038;
            arrn[59] = 61120038;
            arrn[60] = 65120038;
            int[] arrn2 = arrn;
            int n3 = arrn.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                int n5;
                Object object = SkillFactory.getSkill(arrn2[n2]);
                if (object != null && (n5 = a2.getTotalSkillLevel((ISkill)object)) > 0) {
                    PlayerStats a3;
                    object = object.getEffect(n5);
                    PlayerStats playerStats = a3;
                    playerStats.w += ((MapleStatEffect)object).getStrX();
                    playerStats.G += ((MapleStatEffect)object).getDexX();
                    playerStats.c += ((MapleStatEffect)object).getIntX();
                    playerStats.b += ((MapleStatEffect)object).getLukX();
                    playerStats.wdef += ((MapleStatEffect)object).getPddX();
                    playerStats.mdef += ((MapleStatEffect)object).getMddX();
                    playerStats.mdef += ((MapleStatEffect)object).getMddX();
                    playerStats.f += ((MapleStatEffect)object).getPadX();
                    playerStats.percent_hp += ((MapleStatEffect)object).getPercentHP();
                    playerStats.percent_mp += ((MapleStatEffect)object).getPercentMP();
                    playerStats.MDF += ((MapleStatEffect)object).getMDF();
                }
                n4 = ++n2;
            }
        }
    }

    public final /* synthetic */ int getElementBoost(Element a2) {
        PlayerStats a3;
        if (a3.M.containsKey((Object)a2)) {
            return a3.M.get((Object)a2);
        }
        return 0;
    }

    public final /* synthetic */ void init() {
        PlayerStats a2;
        PlayerStats playerStats = a2;
        playerStats.recalcLocalStats();
        playerStats.relocHeal();
    }

    public final /* synthetic */ float getCurrentMaxBaseDamage() {
        PlayerStats a2;
        return a2.J;
    }

    public /* synthetic */ void addDurationTime(int a2, int a3) {
        PlayerStats a4;
        if (a2 < 0 || a3 <= 0) {
            return;
        }
        if (a4.B.containsKey(a2)) {
            int n2 = a4.B.get(a2);
            a4.B.put(a2, n2 + a3);
            return;
        }
        a4.B.put(a2, a3);
    }

    public /* synthetic */ int getMPPercent() {
        PlayerStats a2;
        return (int)Math.ceil((double)a2.mp * 100.0 / (double)a2.m);
    }

    public final /* synthetic */ void setMaxMp(int a2) {
        PlayerStats a3;
        if (JobConstants.is\u60e1\u9b54\u6bba\u624b(((MapleCharacter)a3.n.get()).getJob())) {
            int n2 = GameConstants.getMaxMPByJob((MapleCharacter)a3.n.get());
            if (a2 > n2) {
                a2 = n2;
            }
            if (a3.MDF > 0) {
                a2 += a3.MDF;
            }
        }
        a3.maxmp = a2;
        a3.recalcLocalStats();
    }

    public final /* synthetic */ float getCurrentMaxBasePVPDamage() {
        PlayerStats a2;
        return a2.C;
    }

    public final /* synthetic */ int getTotalMagic() {
        PlayerStats a2;
        return a2.A;
    }

    public final /* synthetic */ int getDamageIncrease(int a2) {
        PlayerStats a3;
        if (a3.F.containsKey(a2)) {
            return a3.F.get(a2);
        }
        return 0;
    }

    public final /* synthetic */ float calculateMaxBaseDamage(int a22, int a3) {
        MapleWeaponType mapleWeaponType;
        int n2;
        int n3;
        PlayerStats a4;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            return a4.calculateMaxBaseDamageNewBigBang(a22, a3);
        }
        MapleCharacter a22 = (MapleCharacter)a4.n.get();
        if (a22 == null) {
            return 0.0f;
        }
        float f2 = 0.0f;
        double d2 = 0.0;
        if (a3 == 0) {
            f2 = 1.0f;
            d2 = 1.0;
            return f2;
        }
        MapleCharacter mapleCharacter = a22;
        IItem iItem = mapleCharacter.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
        short s2 = mapleCharacter.getJob();
        MapleWeaponType mapleWeaponType2 = iItem == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(iItem.getItemId());
        switch (mapleWeaponType2) {
            case \u5f13: {
                PlayerStats playerStats = a4;
                while (false) {
                }
                n3 = playerStats.G;
                n2 = playerStats.w;
                float f3 = 3.4f;
                float f4 = 3.4f;
                d2 = ((double)f3 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f4 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u5f29: {
                PlayerStats playerStats = a4;
                n3 = playerStats.G;
                n2 = playerStats.w;
                float f5 = 3.6f;
                float f6 = 3.6f;
                d2 = ((double)f5 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f6 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u96d9\u624b\u65a7: 
            case \u96d9\u624b\u68cd: {
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                float f7 = 3.4f;
                float f8 = 4.8f;
                d2 = ((double)f7 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f8 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u69cd: 
            case \u77db: {
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                float f9 = 3.0f;
                float f10 = 5.0f;
                d2 = ((double)f9 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f10 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u96d9\u624b\u528d: {
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                float f11 = 4.0f;
                float f12 = 4.6f;
                d2 = ((double)f11 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f12 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u55ae\u624b\u65a7: 
            case \u55ae\u624b\u68cd: 
            case \u77ed\u6756: 
            case \u9577\u6756: {
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                float f13 = 3.2f;
                float f14 = 4.4f;
                d2 = ((double)f13 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f14 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u77ed\u528d: 
            case \u55ae\u624b\u528d: {
                float f15 = 4.0f;
                float f16 = 4.0f;
                float f17 = 3.6f;
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                if (s2 % 1000 / 100 != 4 || mapleWeaponType2 != MapleWeaponType.\u77ed\u528d) {
                    d2 = ((double)f15 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                    f2 = (f16 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                    mapleWeaponType = mapleWeaponType2;
                    break;
                }
                PlayerStats playerStats2 = a4;
                n3 = playerStats2.b;
                n2 = playerStats2.G + a4.w;
                d2 = ((double)f17 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f17 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u62f3\u5957: {
                PlayerStats playerStats = a4;
                n3 = playerStats.b;
                n2 = playerStats.G + a4.w;
                float f18 = 3.6f;
                float f19 = 3.6f;
                d2 = ((double)f18 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f19 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u6307\u864e: {
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                float f20 = 4.8f;
                float f21 = 4.8f;
                d2 = ((double)f20 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f21 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u706b\u69cd: {
                PlayerStats playerStats = a4;
                n3 = playerStats.G;
                n2 = playerStats.w;
                float f22 = 3.6f;
                float f23 = 3.6f;
                d2 = ((double)f22 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f23 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            case \u6c92\u6709\u6b66\u5668: {
                if (s2 >= 500 && s2 <= 522 || s2 >= 1500 && s2 <= 1512) {
                    PlayerStats playerStats = a4;
                    n3 = playerStats.w;
                    n2 = playerStats.G;
                    float f24 = 0.0f;
                    float f25 = 0.0f;
                    d2 = ((double)f24 * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                    f2 = (f25 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                    mapleWeaponType = mapleWeaponType2;
                    break;
                }
                n3 = 0;
                n2 = 0;
                float f26 = 0.0f;
                float f27 = 0.0f;
                d2 = ((double)0.0f * (((double)a4.t * 5.0 + 10.0) * 0.009000000000000001) * (double)n3 + (double)n2) * (double)a3 / 100.0;
                f2 = (f26 * (float)n3 + (float)n2) * (float)a3 / 100.0f;
                mapleWeaponType = mapleWeaponType2;
                break;
            }
            default: {
                PlayerStats playerStats = a4;
                n3 = playerStats.w;
                n2 = playerStats.G;
                mapleWeaponType = mapleWeaponType2;
            }
        }
        float f28 = mapleWeaponType.getMaxDamageMultiplier();
        if (ServerConfig.LOG_DAMAGE && a22.isGM()) {
            a22.getClient().sendPacket(MaplePacketCreator.getErrorNotice("\u7576\u524d\u653b\u64ca: " + a4.J));
            a22.getClient().sendPacket(MaplePacketCreator.getErrorNotice("\u6b66\u5668\u985e\u578b: " + mapleWeaponType2 + " \u653b\u64ca\u529b: " + a3));
            a22.getClient().sendPacket(MaplePacketCreator.getErrorNotice("\u6b66\u5668\u52a0\u6210: " + f28 + " \u4e3b\u5c6c\u6027: " + n3 + " \u6b21\u8981\u5c6c\u6027: " + n2 + " \u653b\u64ca\u529b\u52a0\u6210: " + (float)a3 / 100.0f));
            a22.getClient().sendPacket(MaplePacketCreator.getErrorNotice("\u6700\u7d42\u653b\u64ca: " + (int)d2 + " - " + (int)f2));
        }
        return f2;
    }

    public /* synthetic */ boolean checkEquipDurabilitys(MapleCharacter a2, int a3, boolean a4) {
        PlayerStats a5;
        for (Equip object2 : a5.T) {
            int equip = ItemConstants.isHarvesting(object2.getItemId());
            if (a4 != equip) continue;
            Equip equip2 = object2;
            equip2.setDurability(equip2.getDurability() + a3);
            if (equip2.getDurability() >= 0) continue;
            object2.setDurability(0);
        }
        ArrayList<Equip> arrayList = new ArrayList<Equip>(a5.T);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            MapleCharacter mapleCharacter;
            Equip equip = (Equip)iterator.next();
            a3 = ItemConstants.isHarvesting(equip.getItemId()) ? 1 : 0;
            if (a4 != a3) continue;
            if (equip.getDurability() == 0) {
                if (a2.getInventory(MapleInventoryType.EQUIP).isFull()) {
                    MapleCharacter mapleCharacter2 = a2;
                    mapleCharacter2.getClient().sendPacket(MaplePacketCreator.getInventoryFull());
                    mapleCharacter2.getClient().sendPacket(MaplePacketCreator.getShowInventoryFull());
                    return false;
                }
                a5.T.remove(equip);
                MapleCharacter mapleCharacter3 = a2;
                short s2 = mapleCharacter3.getInventory(MapleInventoryType.EQUIP).getNextFreeSlot();
                Equip equip3 = equip;
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(3, equip3, equip3.getPosition())));
                Equip equip4 = equip;
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.modifyInventory(false, new ModifyInventory(0, equip4, equip4.getPosition())));
                if (a3 != 0) continue;
                MapleInventoryManipulator.unequip(a2.getClient(), equip.getPosition(), s2, true);
                continue;
            }
            if (a2.getEquipDurabilitysTime() != -1L && System.currentTimeMillis() <= a2.getEquipDurabilitysTime()) continue;
            MapleCharacter mapleCharacter4 = a2;
            if (equip.getPosition() > 0) {
                mapleCharacter4.forceReAddItem_Equip(equip.copy(), MapleInventoryType.EQUIP);
                mapleCharacter = a2;
            } else {
                mapleCharacter4.forceReAddItem_Equip(equip.copy(), MapleInventoryType.EQUIPPED);
                mapleCharacter = a2;
            }
            mapleCharacter.resetEquipDurabilitysTime();
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void E(MapleCharacter a2) {
        MapleCharacter mapleCharacter;
        int n2;
        if (a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11) == null) {
            a.t = 0;
            return;
        }
        switch (GameConstants.getWeaponType(a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11).getItemId())) {
            case \u5f13: {
                n2 = 3100000;
                mapleCharacter = a2;
                break;
            }
            case \u62f3\u5957: {
                n2 = 4100000;
                mapleCharacter = a2;
                break;
            }
            case \u77ed\u528d: {
                n2 = a2.getJob() >= 430 && a2.getJob() <= 434 ? 4300000 : 4200000;
                mapleCharacter = a2;
                break;
            }
            case \u5f29: {
                n2 = 3200000;
                mapleCharacter = a2;
                break;
            }
            case \u55ae\u624b\u65a7: 
            case \u96d9\u624b\u65a7: {
                n2 = 1100001;
                mapleCharacter = a2;
                break;
            }
            case \u55ae\u624b\u528d: 
            case \u96d9\u624b\u528d: {
                n2 = GameConstants.isKOC(a2.getJob()) ? 11100000 : (a2.getJob() > 112 ? 1200000 : 1100000);
                mapleCharacter = a2;
                break;
            }
            case \u55ae\u624b\u68cd: 
            case \u96d9\u624b\u68cd: {
                n2 = 1200001;
                mapleCharacter = a2;
                break;
            }
            case \u69cd: {
                n2 = GameConstants.isAran(a2.getJob()) ? 21100000 : 1300001;
                mapleCharacter = a2;
                break;
            }
            case \u77db: {
                n2 = 1300000;
                mapleCharacter = a2;
                break;
            }
            case \u6307\u864e: {
                n2 = GameConstants.isKOC(a2.getJob()) ? 15100001 : 5100001;
                mapleCharacter = a2;
                break;
            }
            case \u706b\u69cd: {
                n2 = 5200000;
                mapleCharacter = a2;
                break;
            }
            case \u77ed\u6756: {
                n2 = 32100006;
                mapleCharacter = a2;
                break;
            }
            default: {
                a.t = 0;
                return;
            }
        }
        if (mapleCharacter.getSkillLevel(n2) <= 0) {
            a.t = 0;
            return;
        }
        a.t = (byte)(a2.getSkillLevel(n2) / 2 + a2.getSkillLevel(n2) % 2);
    }

    public final /* synthetic */ int getMaxHp() {
        PlayerStats playerStats;
        block3: {
            PlayerStats a2;
            block2: {
                block1: {
                    if (GameSetConstants.MAPLE_VERSION >= 134) break block1;
                    if (a2.maxhp <= 30000) break block2;
                    playerStats = a2;
                    a2.maxhp = 30000;
                    break block3;
                }
                if (GameSetConstants.MAPLE_VERSION >= 134 && a2.maxhp > 99999) {
                    a2.maxhp = 99999;
                }
            }
            playerStats = a2;
        }
        return playerStats.maxhp;
    }

    public final /* synthetic */ void setLuk(short a2) {
        PlayerStats a3;
        a3.luk = a2;
        a3.recalcLocalStats();
    }

    public final /* synthetic */ float getHealMP_Percent() {
        PlayerStats a2;
        return a2.Q;
    }

    public final /* synthetic */ int getSkillIncrement(int a2) {
        PlayerStats a3;
        if (a3.I.containsKey(a2)) {
            return a3.I.get(a2);
        }
        return 0;
    }

    public final /* synthetic */ int getMp() {
        PlayerStats a2;
        return a2.mp;
    }

    public static /* synthetic */ {
        int[] arrn = new int[18];
        arrn[0] = 1000007;
        arrn[1] = 2000007;
        arrn[2] = 3000006;
        arrn[3] = 4000010;
        arrn[4] = 5000006;
        arrn[5] = 5010004;
        arrn[6] = 11000006;
        arrn[7] = 12000006;
        arrn[8] = 13000005;
        arrn[9] = 14000006;
        arrn[10] = 15000005;
        arrn[11] = 21000005;
        arrn[12] = 22000002;
        arrn[13] = 23000004;
        arrn[14] = 31000005;
        arrn[15] = 32000012;
        arrn[16] = 33000004;
        arrn[17] = 35000005;
        pvpSkills = arrn;
        int[] arrn2 = new int[8];
        arrn2[0] = 0;
        arrn2[1] = 10000;
        arrn2[2] = 10000000;
        arrn2[3] = 20000000;
        arrn2[4] = 20010000;
        arrn2[5] = 20020000;
        arrn2[6] = 30000000;
        arrn2[7] = 30010000;
        ALLATORIxDEMO = arrn2;
    }

    public final /* synthetic */ short getDex() {
        PlayerStats a2;
        return a2.dex;
    }

    public final /* synthetic */ int getSkillPropIncrease(int a2) {
        PlayerStats a3;
        if (a3.K.containsKey(a2)) {
            return a3.K.get(a2);
        }
        return 0;
    }

    public final /* synthetic */ float calculateMaxBaseDamageNewBigBang(int a2, int a3) {
        int n2;
        PlayerStats a4;
        MapleCharacter mapleCharacter = (MapleCharacter)a4.n.get();
        if (mapleCharacter == null) {
            return 0.0f;
        }
        if (a3 == 0) {
            float f2 = 1.0f;
            return 1.0f;
        }
        MapleCharacter mapleCharacter2 = mapleCharacter;
        IItem iItem = mapleCharacter2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
        short s2 = mapleCharacter2.getJob();
        MapleWeaponType mapleWeaponType = iItem == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(iItem.getItemId());
        boolean bl = mapleCharacter.isMage();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        switch (mapleWeaponType) {
            case \u77db: {
                PlayerStats playerStats = a4;
                n5 = (int)((double)playerStats.w * 1.25);
                n6 = (int)((double)playerStats.G * 1.25);
                n3 = (int)((double)playerStats.str * 1.25);
                n4 = (int)((double)playerStats.dex * 1.25);
                n2 = n5;
                break;
            }
            case \u5f13: 
            case \u5f29: {
                PlayerStats playerStats = a4;
                while (false) {
                }
                n5 = playerStats.G * 2;
                n6 = playerStats.w * 2;
                n3 = playerStats.dex;
                n4 = playerStats.str;
                n2 = n5;
                break;
            }
            case \u62f3\u5957: 
            case \u77ed\u528d: 
            case \u96d9\u5200: {
                PlayerStats playerStats = a4;
                n5 = playerStats.b;
                PlayerStats playerStats2 = a4;
                n6 = playerStats.G + playerStats2.w;
                n3 = playerStats2.luk;
                n4 = playerStats.dex + a4.str;
                n2 = n5;
                break;
            }
            case \u6307\u864e: 
            case \u52a0\u8fb2\u7832: {
                PlayerStats playerStats = a4;
                n5 = playerStats.w;
                n6 = playerStats.G;
                n3 = playerStats.luk;
                n4 = playerStats.dex;
                n2 = n5;
                break;
            }
            case \u706b\u69cd: 
            case \u96d9\u5f29: 
            case \u9748\u9b42\u5c04\u624b: {
                PlayerStats playerStats = a4;
                n5 = playerStats.G;
                n6 = playerStats.w;
                n3 = playerStats.dex;
                n4 = playerStats.str;
                n2 = n5;
                break;
            }
            case \u624b\u6756: {
                PlayerStats playerStats = a4;
                n5 = playerStats.b;
                n6 = playerStats.G;
                n3 = playerStats.luk;
                n4 = playerStats.dex;
                n2 = n5;
                break;
            }
            case \u6c92\u6709\u6b66\u5668: {
                if (s2 >= 500 && s2 <= 522 || s2 >= 1500 && s2 <= 1512) {
                    PlayerStats playerStats = a4;
                    n5 = playerStats.w;
                    n6 = playerStats.G;
                    n3 = playerStats.str;
                    n4 = playerStats.dex;
                    n2 = n5;
                    break;
                }
                n5 = 0;
                n6 = 0;
                n2 = n5;
                break;
            }
            default: {
                PlayerStats playerStats = a4;
                if (bl) {
                    n5 = playerStats.c;
                    PlayerStats playerStats3 = a4;
                    n6 = playerStats3.b;
                    n3 = playerStats3.int_;
                    n4 = playerStats3.luk;
                    n2 = n5;
                    break;
                }
                n5 = playerStats.w;
                PlayerStats playerStats4 = a4;
                n6 = playerStats4.G;
                n3 = playerStats4.str;
                n4 = playerStats4.dex;
                n2 = n5;
            }
        }
        n5 = n2 * 4;
        float f3 = (mapleWeaponType.getMaxDamageMultiplier() * (float)n5 + (float)n6) * (float)(bl ? a2 : a3) / 100.0f;
        MapleWeaponType mapleWeaponType2 = mapleWeaponType;
        a4.C = mapleWeaponType2.getMaxDamageMultiplier() * (float)(4 * n3 + n4) * (100.0f + (float)a4.pvpDamage / 100.0f);
        a4.H = mapleWeaponType2.getMaxDamageMultiplier() * (float)(4 * n5 + n6) * (100.0f + (float)a4.pvpDamage / 100.0f);
        return f3;
    }

    public /* synthetic */ void handlePotential(StructPotentialItem a2, MapleCharacter a3, boolean a4) {
        PlayerStats a5;
        PlayerStats playerStats = a5;
        playerStats.w += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002J5K"));
        playerStats.G += a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0007\u001e\u001b"));
        playerStats.c += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002P/M"));
        playerStats.b += a2.get(ItemInformation.ALLATORIxDEMO("2-8\u000f\u000e\b"));
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002J5K\ro")) > 0) {
            a5.w += a3.getLevel() / 10 * a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0010\u000f\u001175"));
        }
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002]$A\ro")) > 0) {
            a5.G += a3.getLevel() / 10 * a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0007\u001e\u001b75"));
        }
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002P/M\ro")) > 0) {
            a5.c += a3.getLevel() / 10 * a2.get(ItemInformation.ALLATORIxDEMO("2-8\n\u0015\u001775"));
        }
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002U4R\ro")) > 0) {
            a5.b += a3.getLevel() / 10 * a2.get(ItemInformation.ALLATORIxDEMO("2-8\u000f\u000e\b75"));
        }
        PlayerStats playerStats2 = a5;
        playerStats2.D += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002X\"Z"));
        playerStats2.speed += a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0010+&>'"));
        playerStats2.jump += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz+l\fi"));
        playerStats2.f += a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0013\u001a\u0007"));
        playerStats2.A += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002T ]"));
        playerStats2.wdef += a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0013\u001f\u0007"));
        playerStats2.mdef += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002T%]"));
        playerStats2.percent_str += a2.get(ItemInformation.ALLATORIxDEMO("*5 \b\u0017\t1"));
        playerStats2.percent_dex += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz%\\9k"));
        playerStats2.percent_int += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u0012\r\u000f1"));
        playerStats2.percent_luk += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz-L*k"));
        playerStats2.percent_hp += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u0016\u000b\u000b1"));
        playerStats2.percent_mp += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz,T1k"));
        playerStats2.percent_acc += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u001a\u0000\u00181"));
        playerStats2.dodgeChance += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz$O k"));
        playerStats2.percent_atk += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u000b\u0002\u001f1"));
        playerStats2.percent_matk += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz,X%k"));
        playerStats2.percent_wdef += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u000b\u0007\u001f1"));
        playerStats2.percent_mdef += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz,]%k"));
        playerStats2.P = (byte)(playerStats2.P + a2.get(ItemInformation.ALLATORIxDEMO("*5 \u00181")));
        playerStats2.bossdam_r *= ((double)a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz%X,k")) + 100.0) / 100.0;
        if (a2.get(ItemInformation.ALLATORIxDEMO("9,(0")) <= 0) {
            a5.dam_r *= ((double)a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz%X,k")) + 100.0) / 100.0;
        }
        PlayerStats playerStats3 = a5;
        playerStats3.recoverHP += a2.get(ItemInformation.ALLATORIxDEMO("\t&8,-&):\u0013\u0013"));
        playerStats3.recoverMP += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"3|\u0002v\u0017|\u0013`,I"));
        playerStats3.ignoreTargetDEF += a2.get(ItemInformation.ALLATORIxDEMO("*<-41>\u0017:1<&/\u0007\u001e\u0005"));
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u0006w\u000ek\u0004] T")) > 0) {
            PlayerStats playerStats4 = a5;
            playerStats4.ignoreDAM += a2.get(ItemInformation.ALLATORIxDEMO("*<-41>\u0007\u001a\u000e"));
            playerStats4.ignoreDAM_rate += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0011k\u000ei"));
        }
        a5.incAllskill += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u001a/700*7/"));
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\b~\u000fv\u0013|%X,k")) > 0) {
            PlayerStats playerStats5 = a5;
            playerStats5.ignoreDAMr += a2.get(ItemInformation.ALLATORIxDEMO("2$5,)&\u001f\u0002\u00161"));
            playerStats5.ignoreDAMr_rate += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0011k\u000ei"));
        }
        PlayerStats playerStats6 = a5;
        playerStats6.RecoveryUP += a2.get(ItemInformation.ALLATORIxDEMO("\t&8,-&):\u000e\u0013"));
        playerStats6.d = (short)(playerStats6.d + (short)a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002Z\u0013p\u0015p\u0002x\r}\u0000t\u0000~\u0004T\bw")));
        playerStats6.a = (short)(playerStats6.a + (short)a2.get(ItemInformation.ALLATORIxDEMO("2-8\u0000)*/*8\"7':.:$>\u000e:;")));
        playerStats6.TER += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz5|\u0013K"));
        playerStats6.ASR += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u001a0)\u0011"));
        if (a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"%X,k\u0004\u007f\r|\u0002m")) > 0) {
            PlayerStats playerStats7 = a5;
            playerStats7.DAMreflect += a2.get(ItemInformation.ALLATORIxDEMO("\u001f\u0002\u00161>%7&87"));
            playerStats7.DAMreflect_rate += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0011k\u000ei"));
        }
        PlayerStats playerStats8 = a5;
        playerStats8.mpconReduce += a2.get(ItemInformation.ALLATORIxDEMO(".+ 4-\t&?68&"));
        playerStats8.reduceCooltime += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0013|\u0005l\u0002|\"v\u000eu\u0015p\f|"));
        playerStats8.incMesoProp += a2.get(ItemInformation.ALLATORIxDEMO("*5 \u0016&(,\u000b143"));
        playerStats8.incRewardProp += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz3|\u0016x\u0013}1k\u000ei"));
        playerStats8.incMaxDamage += a2.get(ItemInformation.ALLATORIxDEMO("2-8\u000e:;\u001f\"6\"<&"));
        if ((GameSetConstants.MAPLE_VERSION >= 139 || GameSetConstants.MAPLE_VERSION < 139 && a5.InvincibleTimeAfterHit <= 0) && (a2.opID == 20366 || a2.opID == 30366 || a2.opID == 40366)) {
            a5.InvincibleTimeAfterHit += a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0015p\f|"));
        }
        if (a2.opID == 30371) {
            PlayerStats playerStats9 = a5;
            playerStats9.InvincibleTimeAfterHit2 = a2.get(ItemInformation.ALLATORIxDEMO("/*6&"));
            playerStats9.InvincibleTimeAfterHit2R = a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u0011k\u000ei"));
        }
        if (a2.get(ItemInformation.ALLATORIxDEMO("00*7/\u0012\u0007")) > 0) {
            if (!a3.isLoggedIn()) {
                MapleCharacter mapleCharacter = a3;
                mapleCharacter.changeSkillLevel_Skip(PlayerStats.getSkillByJob(a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"j\np\ru(]")), mapleCharacter.getJob()), (byte)1, (byte)0);
                return;
            }
            if (a3.getTotalSkillLevel(PlayerStats.getSkillByJob(a2.get(ItemInformation.ALLATORIxDEMO("00*7/\u0012\u0007")), a3.getJob())) <= 0) {
                MapleCharacter mapleCharacter = a3;
                mapleCharacter.changeSkillLevel(PlayerStats.getSkillByJob(a2.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"j\np\ru(]")), mapleCharacter.getJob()), 1, (byte)0);
            }
        }
    }

    public final /* synthetic */ float getShouldHealHP() {
        MapleStatEffect mapleStatEffect;
        PlayerStats a2;
        int n2 = 10;
        Skill skill = (Skill)SkillFactory.getSkill(1000000);
        int n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            mapleStatEffect = skill.getEffect(n3);
            n2 += mapleStatEffect.getHp();
        }
        skill = (Skill)SkillFactory.getSkill(1320008);
        n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            mapleStatEffect = skill.getEffect(n3);
            n2 += mapleStatEffect.getHp();
        }
        skill = (Skill)SkillFactory.getSkill(4100002);
        n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            mapleStatEffect = skill.getEffect(n3);
            n2 += mapleStatEffect.getHp();
        }
        skill = (Skill)SkillFactory.getSkill(4200001);
        n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            mapleStatEffect = skill.getEffect(n3);
            n2 += mapleStatEffect.getHp();
        }
        if (((MapleCharacter)a2.n.get()).getChair() != 0) {
            n2 += 150;
        }
        return n2;
    }

    public /* synthetic */ void handleChangeSkills(MapleCharacter a2, boolean a3) {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            PlayerStats a4;
            if (a3 != 0 && a2.getLevel() >= 30) {
                if (a2.isGM()) {
                    int n2 = a3 = 0;
                    while (n2 < ALLATORIxDEMO.length) {
                        MapleCharacter mapleCharacter = a2;
                        mapleCharacter.changeSkillLevel_Skip(SkillFactory.getSkill(1085 + ALLATORIxDEMO[a3]), (byte)1, (byte)0);
                        ISkill iSkill = SkillFactory.getSkill(1087 + ALLATORIxDEMO[a3]);
                        mapleCharacter.changeSkillLevel_Skip(iSkill, (byte)1, (byte)0);
                        n2 = ++a3;
                    }
                } else {
                    MapleCharacter mapleCharacter = a2;
                    mapleCharacter.changeSkillLevel_Skip(SkillFactory.getSkill(PlayerStats.getSkillByJob(1085, mapleCharacter.getJob())), (byte)1, (byte)0);
                    a2.changeSkillLevel_Skip(SkillFactory.getSkill(PlayerStats.getSkillByJob(1087, a2.getJob())), (byte)1, (byte)0);
                }
            }
            if (a4.equippedSummon > 0) {
                a4.equippedSummon = PlayerStats.getSkillByJob(a4.equippedSummon, a2.getJob());
            }
        }
    }

    public final /* synthetic */ boolean setHp(int a2, boolean a3) {
        PlayerStats a4;
        MapleCharacter mapleCharacter = (MapleCharacter)a4.n.get();
        int n2 = a4.hp;
        if (a2 < 0) {
            a2 = 0;
        }
        if (!mapleCharacter.inPVP() && a2 > a4.l) {
            a2 = a4.l;
        }
        a4.hp = a2;
        if (mapleCharacter != null) {
            if (!a3) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter2.doBerserk();
                mapleCharacter2.updatePartyMemberHP();
            }
            if (mapleCharacter.getClient().isLoggedIn() && n2 > a4.hp && !mapleCharacter.isAlive()) {
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.enableActions());
                mapleCharacter3.setCheckedAmulet(true);
                mapleCharacter3.playerDead();
            }
        }
        return a4.hp != n2;
    }

    public final /* synthetic */ boolean setHp(int a2) {
        PlayerStats a3;
        return a3.setHp(a2, false);
    }

    public final /* synthetic */ byte passive_mastery() {
        PlayerStats a2;
        return a2.t;
    }

    public static final /* synthetic */ int getSkillByJob(int a2, int a3) {
        if (a2 == 8) {
            int n2 = 8;
            if (JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(a3)) {
                n2 = 10000018;
                return 10000018;
            }
            if (JobConstants.is\u72c2\u72fc\u52c7\u58eb(a3)) {
                n2 = 20000024;
                return 20000024;
            }
            if (JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a3)) {
                n2 = 20011024;
                return 20011024;
            }
            if (JobConstants.is\u7cbe\u9748\u904a\u4fe0(a3)) {
                n2 = 20020213;
                return 20020213;
            }
            if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u672b\u65e5\u53cd\u6297\u8ecd(a3)) {
                n2 = 30001024;
                return 30001024;
            }
            if (JobConstants.is\u9670\u967d\u5e2b(a3)) {
                n2 = 40021024;
                return 40021024;
            }
            if (JobConstants.is\u528d\u8c6a(a3)) {
                n2 = 40011024;
                return 40011024;
            }
            if (JobConstants.is\u7c73\u54c8\u9038(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u51f1\u6492(a3) || JobConstants.is\u591c\u5149(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a3)) {
                n2 = 80000023;
                return 80000023;
            }
            if (JobConstants.is\u5e7b\u5f71\u4fe0\u76dc(a3)) {
                n2 = 80000023;
            }
            return n2;
        }
        if (a2 == 1142 && GameSetConstants.MAPLE_VERSION >= 138) {
            return 80001089;
        }
        if (a2 == 1017 && GameSetConstants.MAPLE_VERSION >= 138) {
            return 80001025;
        }
        return a2 + MapleJob.getBeginner((short)a3) * 10000;
    }

    public final /* synthetic */ int getDotTimeIncrease(int a2) {
        PlayerStats a3;
        if (a3.k.containsKey(a2)) {
            return a3.k.get(a2);
        }
        return 0;
    }

    public /* synthetic */ void recalcPVPRank(MapleCharacter a2) {
        PlayerStats a3;
        PlayerStats playerStats = a3;
        playerStats.pvpRank = 10;
        playerStats.pvpExp = a2.getTotalBattleExp();
        int n2 = a2 = 0;
        while (n2 < 10) {
            if (a3.pvpExp > GameConstants.getPVPExpNeededForLevel(a2 + 1)) {
                PlayerStats playerStats2 = a3;
                --playerStats2.pvpRank;
                playerStats2.pvpExp -= GameConstants.getPVPExpNeededForLevel(a2 + 1);
            }
            n2 = ++a2;
        }
    }

    private /* synthetic */ int l(MapleCharacter a2) {
        PlayerStats a3;
        return a3.D(a2) + a3.E(a2) + a3.I(a2) + a3.b(a2) + a3.d(a2) + a3.H(a2);
    }

    public final /* synthetic */ void setStr(short a2) {
        PlayerStats a3;
        a3.str = a2;
        a3.recalcLocalStats();
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, int a3, int a4) {
        PlayerStats a5;
        switch (a2.getJob()) {
            case 410: 
            case 411: 
            case 412: {
                int n2;
                ISkill iSkill = SkillFactory.getSkill(4100001);
                if (iSkill == null || (n2 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n2).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n2).getCriticalMin());
                    return;
                }
                ISkill iSkill2 = iSkill;
                a5.Z = (short)(iSkill2.getEffect(n2).getDamage() + a4);
                a5.P = (byte)(iSkill2.getEffect(n2).getProb() + a3);
                return;
            }
            case 1410: 
            case 1411: 
            case 1412: {
                int n3;
                ISkill iSkill = SkillFactory.getSkill(14100001);
                if (iSkill == null || (n3 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n3).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n3).getCriticalMin());
                    return;
                }
                ISkill iSkill3 = iSkill;
                a5.Z = (short)(iSkill3.getEffect(n3).getDamage() + a4);
                a5.P = (byte)(iSkill3.getEffect(n3).getProb() + a3);
                return;
            }
            case 511: 
            case 512: {
                int n4;
                ISkill iSkill = SkillFactory.getSkill(5110000);
                if (iSkill == null || (n4 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n4).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n4).getCriticalMin());
                    return;
                }
                ISkill iSkill4 = iSkill;
                a5.Z = (short)(iSkill4.getEffect(n4).getDamage() + a4);
                a5.P = (byte)(iSkill4.getEffect(n4).getProb() + a3);
                return;
            }
            case 1511: 
            case 1512: {
                ISkill iSkill;
                ISkill iSkill5 = iSkill = SkillFactory.getSkill(15110000);
                int n5 = a2.getSkillLevel(iSkill5);
                if (iSkill5 == null || n5 <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n5).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n5).getCriticalMin());
                    return;
                }
                ISkill iSkill6 = iSkill;
                a5.Z = (short)(iSkill6.getEffect(n5).getDamage() + a4);
                a5.P = (byte)(iSkill6.getEffect(n5).getProb() + a3);
                return;
            }
            case 2111: 
            case 2112: {
                int n6;
                ISkill iSkill = SkillFactory.getSkill(21110000);
                if (iSkill == null || (n6 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n6).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n6).getCriticalMin());
                    return;
                }
                ISkill iSkill7 = iSkill;
                a5.Z = (short)(iSkill7.getEffect(n6).getX() * iSkill.getEffect(n6).getDamage() + a4);
                a5.P = (byte)(iSkill7.getEffect(n6).getX() * iSkill.getEffect(n6).getY() + a3);
                return;
            }
            case 300: 
            case 310: 
            case 311: 
            case 312: 
            case 320: 
            case 321: 
            case 322: {
                int n7;
                ISkill iSkill = SkillFactory.getSkill(3000001);
                if (iSkill == null || (n7 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n7).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n7).getCriticalMin());
                    return;
                }
                ISkill iSkill8 = iSkill;
                a5.Z = (short)(iSkill8.getEffect(n7).getDamage() + a4);
                a5.P = (byte)(iSkill8.getEffect(n7).getProb() + a3);
                return;
            }
            case 1300: 
            case 1310: 
            case 1311: 
            case 1312: {
                int n8;
                ISkill iSkill = SkillFactory.getSkill(13000000);
                if (iSkill == null || (n8 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n8).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n8).getCriticalMin());
                    return;
                }
                ISkill iSkill9 = iSkill;
                a5.Z = (short)(iSkill9.getEffect(n8).getDamage() + a4);
                a5.P = (byte)(iSkill9.getEffect(n8).getProb() + a3);
                return;
            }
            case 2214: 
            case 2215: 
            case 2216: 
            case 2217: 
            case 2218: {
                int n9;
                ISkill iSkill = SkillFactory.getSkill(22140000);
                if (iSkill == null || (n9 = a2.getSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n9).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n9).getCriticalMin());
                    return;
                }
                ISkill iSkill10 = iSkill;
                a5.Z = (short)(iSkill10.getEffect(n9).getDamage() + a4);
                a5.P = (byte)(iSkill10.getEffect(n9).getProb() + a3);
                return;
            }
            case 3100: 
            case 3110: 
            case 3111: 
            case 3112: {
                int n10;
                ISkill iSkill = SkillFactory.getSkill(31100006);
                if (iSkill == null || (n10 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n10).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n10).getCriticalMin());
                    return;
                }
                ISkill iSkill11 = iSkill;
                a5.Z = (short)(iSkill11.getEffect(n10).getDamage() + a4);
                a5.P = (byte)(iSkill11.getEffect(n10).getProb() + a3);
                return;
            }
            case 2300: 
            case 2310: 
            case 2311: 
            case 2312: {
                int n11;
                ISkill iSkill = SkillFactory.getSkill(23000003);
                if (iSkill == null || (n11 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n11).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n11).getCriticalMin());
                    return;
                }
                ISkill iSkill12 = iSkill;
                a5.Z = (short)(iSkill12.getEffect(n11).getDamage() + a4);
                a5.P = (byte)(iSkill12.getEffect(n11).getProb() + a3);
                return;
            }
            case 3210: 
            case 3211: 
            case 3212: {
                int n12;
                ISkill iSkill = SkillFactory.getSkill(32100006);
                if (iSkill == null || (n12 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n12).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n12).getCriticalMin());
                    return;
                }
                ISkill iSkill13 = iSkill;
                a5.Z = (short)(iSkill13.getEffect(n12).getDamage() + a4);
                a5.P = (byte)(iSkill13.getEffect(n12).getProb() + a3);
                return;
            }
            case 434: {
                int n13;
                ISkill iSkill = SkillFactory.getSkill(4340010);
                if (iSkill == null || (n13 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n13).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n13).getCriticalMin());
                    return;
                }
                ISkill iSkill14 = iSkill;
                a5.Z = (short)(iSkill14.getEffect(n13).getDamage() + a4);
                a5.P = (byte)(iSkill14.getEffect(n13).getProb() + a3);
                return;
            }
            case 520: 
            case 521: 
            case 522: {
                int n14;
                ISkill iSkill = SkillFactory.getSkill(5200007);
                if (iSkill == null || (n14 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n14).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n14).getCriticalMin());
                    return;
                }
                ISkill iSkill15 = iSkill;
                a5.Z = (short)(iSkill15.getEffect(n14).getDamage() + a4);
                a5.P = (byte)(iSkill15.getEffect(n14).getProb() + a3);
                return;
            }
            case 1211: 
            case 1212: {
                int n15;
                ISkill iSkill = SkillFactory.getSkill(12110000);
                if (iSkill == null || (n15 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n15).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n15).getCriticalMin());
                    return;
                }
                ISkill iSkill16 = iSkill;
                a5.Z = (short)(iSkill16.getEffect(n15).getDamage() + a4);
                a5.P = (byte)(iSkill16.getEffect(n15).getProb() + a3);
                return;
            }
            case 530: 
            case 531: 
            case 532: {
                int n16;
                ISkill iSkill = SkillFactory.getSkill(5300004);
                if (iSkill == null || (n16 = a2.getTotalSkillLevel(iSkill)) <= 0) break;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    PlayerStats playerStats = a5;
                    playerStats.P = (byte)(playerStats.P + iSkill.getEffect(n16).getProb());
                    playerStats.o = (short)(playerStats.o + iSkill.getEffect(n16).getCriticalMin());
                    return;
                }
                ISkill iSkill17 = iSkill;
                a5.Z = (short)(iSkill17.getEffect(n16).getDamage() + a4);
                a5.P = (byte)(iSkill17.getEffect(n16).getProb() + a3);
                return;
            }
        }
        if (GameSetConstants.MAPLE_VERSION < 134) {
            PlayerStats playerStats = a5;
            playerStats.Z = (short)a4;
            playerStats.P = (byte)a3;
        }
    }

    private final /* synthetic */ void l(MapleCharacter a2) {
        int n2;
        a2.getTrait(MapleTrait.MapleTraitType.\u9b45\u529b).addLocalExp(a2.getFame());
        MapleTrait.MapleTraitType[] arrmapleTraitType = MapleTrait.MapleTraitType.values();
        int n3 = arrmapleTraitType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleTrait.MapleTraitType mapleTraitType = arrmapleTraitType[n2];
            a2.getTrait(mapleTraitType).recalcLevel();
            n4 = ++n2;
        }
    }

    public /* synthetic */ int getCoolTimeR() {
        PlayerStats a2;
        if (a2.coolTimeR > 5) {
            return 5;
        }
        return a2.coolTimeR;
    }

    public final /* synthetic */ float getShouldHealMP() {
        MapleStatEffect mapleStatEffect;
        PlayerStats a2;
        int n2 = 3;
        Skill skill = (Skill)SkillFactory.getSkill(2000000);
        int n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            n2 += n3 * 5;
        }
        skill = (Skill)SkillFactory.getSkill(4100002);
        n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            mapleStatEffect = skill.getEffect(n3);
            n2 += mapleStatEffect.getMp();
        }
        skill = (Skill)SkillFactory.getSkill(4200001);
        n3 = ((MapleCharacter)a2.n.get()).getSkillLevel(skill);
        if (n3 > 0) {
            mapleStatEffect = skill.getEffect(n3);
            n2 += mapleStatEffect.getMp();
        }
        if (((MapleCharacter)a2.n.get()).getChair() != 0) {
            n2 += 150;
        }
        return n2;
    }

    public final /* synthetic */ float getCurrentMaxBasePVPDamageL() {
        PlayerStats a2;
        return a2.H;
    }

    public final /* synthetic */ double getTotalDropBuff(int a2) {
        PlayerStats a3;
        MapleCharacter mapleCharacter = (MapleCharacter)a3.n.get();
        Serializable serializable = mapleCharacter.getBuffedValue(MapleBuffStat.DROP_RATE);
        if (serializable != null && a3.carddropBuff == 0.0) {
            double d2 = ((Integer)serializable).doubleValue();
            serializable = mapleCharacter.getStatForBuff(MapleBuffStat.DROP_RATE);
            if (((MapleStatEffect)serializable).getAvailableMap() != null && ((MapleStatEffect)serializable).getAvailableMap().size() > 0) {
                int n2 = 0;
                for (Pair<Integer, Integer> pair : ((MapleStatEffect)serializable).getAvailableMap()) {
                    if (mapleCharacter.getMapId() >= (Integer)pair.left && mapleCharacter.getMapId() <= (Integer)pair.right) continue;
                    ++n2;
                }
                if (n2 == ((MapleStatEffect)serializable).getAvailableMap().size()) {
                    d2 = 100.0;
                }
            }
            PlayerStats playerStats = a3;
            playerStats.dropBuff *= d2 / 100.0;
            playerStats.realDropBuff = playerStats.dropBuff;
            a3.carddropBuff = d2;
            if (serializable != null && !((MapleStatEffect)serializable).isItemDropBuff(a2)) {
                PlayerStats playerStats2 = a3;
                PlayerStats playerStats3 = a3;
                playerStats3.dropBuff /= d2 / 100.0;
                playerStats2.realDropBuff = playerStats3.dropBuff;
                playerStats2.carddropBuff = 0.0;
            }
        }
        return a3.realDropBuff;
    }

    public final /* synthetic */ int getTotalLuk() {
        PlayerStats a2;
        return a2.b;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void handlePlayerRate(MapleCharacter a) {
        var2_2 = Calendar.getInstance().get(11);
        var3_3 = Calendar.getInstance().get(7);
        v0 = a;
        a.expMod = 1;
        v0.expRate = 1;
        v0.dropMod = 1;
        for (IItem var4_5 : a.getInventory(MapleInventoryType.CASH)) {
            if (a.expMod < 3 && (var4_5.getItemId() == 5211060 || var4_5.getItemId() == 5211050 || var4_5.getItemId() == 5211051 || var4_5.getItemId() == 5211052 || var4_5.getItemId() == 5211053 || var4_5.getItemId() == 5211054)) {
                v1 = a;
                a.expMod = 3;
            } else if (a.expMod == 1 && var4_5.getItemId() == 5210000) {
                v1 = a;
                a.expMod = 2;
            } else if (a.expMod == 1 && var4_5.getItemId() == 5210001 && var2_2 >= 0 && var2_2 < 6) {
                v1 = a;
                a.expMod = 2;
            } else if (a.expMod == 1 && var4_5.getItemId() == 5210002 && var2_2 >= 6 && var2_2 < 12) {
                v1 = a;
                a.expMod = 2;
            } else if (a.expMod == 1 && var4_5.getItemId() == 5210003 && var2_2 >= 12 && var2_2 < 18) {
                v1 = a;
                a.expMod = 2;
            } else {
                if (a.expMod == 1 && var4_5.getItemId() == 5210004 && var2_2 >= 18 && var2_2 < 24) {
                    a.expMod = 2;
                }
                v1 = a;
            }
            if (v1.dropMod != 1) ** GOTO lbl50
            if (var4_5.getItemId() == 5360015) {
                v2 = var4_5;
                a.dropMod = 2;
            } else if (var4_5.getItemId() == 5360000 && var2_2 >= 0 && var2_2 < 6) {
                v2 = var4_5;
                a.dropMod = 2;
            } else if (var4_5.getItemId() == 5360001 && var2_2 >= 6 && var2_2 < 12) {
                v2 = var4_5;
                a.dropMod = 2;
            } else if (var4_5.getItemId() == 5360002 && var2_2 >= 12 && var2_2 < 18) {
                v2 = var4_5;
                a.dropMod = 2;
            } else {
                if (var4_5.getItemId() == 5360003 && var2_2 >= 18 && var2_2 < 24) {
                    a.dropMod = 2;
                }
lbl50:
                // 4 sources

                v2 = var4_5;
            }
            if (v2.getItemId() == 5650000) {
                a.hasPartyBonus = true;
                continue;
            }
            if (var4_5.getItemId() == 5590001) {
                a.levelBonus = 10;
                continue;
            }
            if (a.levelBonus == 0 && var4_5.getItemId() == 5590000) {
                a.levelBonus = 5;
                continue;
            }
            if (var4_5.getItemId() == 5710000) {
                a.questBonus = 2;
                continue;
            }
            if (var4_5.getItemId() == 5340000) {
                a.canFish = true;
                continue;
            }
            if (var4_5.getItemId() != 5340001) continue;
            v3 = a;
            v3.canFish = true;
            v3.canFishVIP = true;
        }
        var3_4 = a.getInventory(MapleInventoryType.ETC).iterator();
        block6: while (var3_4.hasNext() != false) {
            var4_5 = var3_4.next();
            switch (var4_5.getItemId()) {
                case 4030003: {
                    a.pickupRange = Infinity;
                    continue block6;
                }
                case 4030004: {
                    a.hasClone = true;
                    continue block6;
                }
                case 4030005: {
                    a.cashMod = 2;
                    continue block6;
                }
            }
        }
    }

    public final /* synthetic */ int getCurrentMaxMp() {
        PlayerStats a2;
        return a2.m;
    }

    public final /* synthetic */ double getJumpMod() {
        PlayerStats a2;
        return a2.i;
    }

    public final /* synthetic */ int getTotalStr() {
        PlayerStats a2;
        return a2.w;
    }

    public final /* synthetic */ int getMaxMp() {
        PlayerStats playerStats;
        block3: {
            PlayerStats a2;
            block2: {
                block1: {
                    if (GameSetConstants.MAPLE_VERSION >= 134) break block1;
                    if (a2.maxmp <= 30000) break block2;
                    playerStats = a2;
                    a2.maxmp = 30000;
                    break block3;
                }
                if (GameSetConstants.MAPLE_VERSION >= 134 && a2.maxmp > 99999) {
                    a2.maxmp = 99999;
                }
            }
            playerStats = a2;
        }
        return playerStats.maxmp;
    }

    public /* synthetic */ void handleLocalStats(MapleCharacter a22) {
        PlayerStats a3;
        PlayerStats playerStats = a3;
        playerStats.A += a22.getSkillLevel(SkillFactory.getSkill(22000000));
        PlayerStats playerStats2 = a3;
        playerStats.w = (int)((float)playerStats.w + (float)(playerStats2.percent_str * a3.w) / 100.0f);
        PlayerStats playerStats3 = a3;
        playerStats2.G = (int)((float)playerStats2.G + (float)(playerStats3.percent_dex * playerStats3.G) / 100.0f);
        int a22 = playerStats.c;
        PlayerStats playerStats4 = a3;
        playerStats.c = (int)((float)playerStats.c + (float)(playerStats4.percent_int * playerStats4.c) / 100.0f);
        playerStats.A += a3.c - a22;
        PlayerStats playerStats5 = a3;
        playerStats.b = (int)((float)playerStats.b + (float)(playerStats5.percent_luk * playerStats5.b) / 100.0f);
        PlayerStats playerStats6 = a3;
        playerStats.D = (int)((float)playerStats.D + (float)(playerStats6.percent_acc * playerStats6.D) / 100.0f);
        PlayerStats playerStats7 = a3;
        playerStats.f = (int)((float)playerStats.f + (float)(playerStats7.percent_atk * playerStats7.f) / 100.0f);
        PlayerStats playerStats8 = a3;
        playerStats.A = (int)((float)playerStats.A + (float)(playerStats8.percent_matk * playerStats8.A) / 100.0f);
        playerStats.A = Math.min(playerStats.A, 1999);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            PlayerStats playerStats9 = a3;
            playerStats9.D = (int)((double)playerStats9.D + (Math.floor((double)a3.b * 0.8) + Math.floor((double)a3.G * 1.6) + Math.floor((double)a3.w * 0.4)));
            playerStats9.L = (int)((double)playerStats9.L + (Math.floor((double)a3.b * 0.8) + Math.floor((double)a3.G * 0.4) + Math.floor((double)a3.c * 1.6)));
            PlayerStats playerStats10 = a3;
            playerStats9.wdef = (int)((double)playerStats9.wdef + Math.floor((double)a3.w * 1.2 + (double)(playerStats10.G + playerStats10.b) * 0.5 + (double)a3.c * 0.4));
            PlayerStats playerStats11 = a3;
            playerStats9.mdef = (int)((double)playerStats9.mdef + Math.floor((double)a3.w * 0.4 + (double)(playerStats11.G + playerStats11.b) * 0.5 + (double)a3.c * 1.2));
            PlayerStats playerStats12 = a3;
            playerStats9.D = (int)((double)playerStats9.D + Math.floor((float)(playerStats12.D * playerStats12.percent_acc) / 100.0f));
            return;
        }
        PlayerStats playerStats13 = a3;
        if (playerStats13.c > playerStats13.G) {
            a3.D = (int)((double)a3.D + ((double)a3.c + Math.floor((double)a3.b * 1.2)));
            return;
        }
        a3.D = (int)((double)a3.D + ((double)a3.b + Math.floor((double)a3.G * 1.2)));
    }

    public /* synthetic */ int getReduceCooltime() {
        PlayerStats a2;
        if (a2.reduceCooltime > 5) {
            return 5;
        }
        return a2.reduceCooltime;
    }

    public /* synthetic */ void addDotTime(int a2, int a3) {
        PlayerStats a4;
        if (a2 < 0 || a3 <= 0) {
            return;
        }
        if (a4.k.containsKey(a2)) {
            int n2 = a4.k.get(a2);
            a4.k.put(a2, n2 + a3);
            return;
        }
        a4.k.put(a2, a3);
    }

    public /* synthetic */ void addAttackCount(int a2, int a3) {
        PlayerStats a4;
        if (a2 < 0 || a3 <= 0) {
            return;
        }
        if (a4.E.containsKey(a2)) {
            int n2 = a4.E.get(a2);
            a4.E.put(a2, n2 + a3);
            return;
        }
        a4.E.put(a2, a3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean checkEquipLevels(MapleCharacter a2, int a3) {
        boolean bl = false;
        try {
            PlayerStats a4;
            Iterator iterator;
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator2 = iterator = new ArrayList<Equip>(a4.R).iterator();
            while (true) {
                Equip equip;
                block10: {
                    int n2;
                    int n3;
                    block11: {
                        block9: {
                            if (!iterator2.hasNext()) break block9;
                            equip = (Equip)iterator.next();
                            equip = (Equip)a2.getInventory(MapleInventoryType.EQUIPPED).getItem(equip.getPosition());
                            n3 = equip.getEquipLevel();
                            equip.setItemEXP(Math.min(equip.getItemEXP() + a3, Integer.MAX_VALUE));
                            if (equip.getEquipLevel() <= n3) break block10;
                            n2 = equip.getEquipLevel() - n3;
                            break block11;
                        }
                        if (!bl) return bl;
                        a4.recalcLocalStats();
                        MapleCharacter mapleCharacter = a2;
                        mapleCharacter.showInstruction(stringBuilder.toString(), 200, 100);
                        a2.getClient().sendPacket(MaplePacketCreator.showItemLevelupEffect());
                        MapleCharacter mapleCharacter2 = a2;
                        mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.showForeignItemLevelupEffect(mapleCharacter2.getId()), false);
                        return bl;
                    }
                    while (n2 > 0) {
                        int n4;
                        Map<Integer, Map<String, Integer>> map = mapleItemInformationProvider.getEquipIncrements(equip.getItemId());
                        if (map != null && map.containsKey(n3 + n4)) {
                            mapleItemInformationProvider.levelUpEquipA(equip, map.get(n3 + n4));
                        }
                        if (ItemConstants.getStatFromWeapon(equip.getItemId()) == null && ItemConstants.getMaxLevel(equip.getItemId()) < n3 + n4 && Math.random() < 0.1 && equip.getIncSkill() <= 0 && mapleItemInformationProvider.getEquipSkills(equip.getItemId()) != null) {
                            map = mapleItemInformationProvider.getEquipSkills(equip.getItemId()).iterator();
                            while (map.hasNext()) {
                                ISkill iSkill = SkillFactory.getSkill((Integer)map.next());
                                if (iSkill == null || !iSkill.canBeLearnedBy(a2.getJob())) continue;
                                equip.setIncSkill(iSkill.getId());
                            }
                        }
                        n2 = --n4;
                    }
                    stringBuilder.append(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)">")).append(equip.getItemName()).append(ItemInformation.ALLATORIxDEMO("|`9\u5db1\u7dc8\u5304\u7d41\u5273x1")).append(equip.getEquipLevel()).append(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)":\u0003\u7d03Brl\u0013"));
                    bl = true;
                }
                a2.forceReAddItem_Equip(equip.copy(), MapleInventoryType.EQUIPPED, false);
                iterator2 = iterator;
            }
        }
        catch (Exception exception) {
            FileoutputUtil.logToFile(ItemInformation.ALLATORIxDEMO("/4$(l\u8886\u50da\u531c\u7d59\u4fd0\u5955u7#7"), a2.getName() + " " + exception.toString());
        }
        return bl;
    }

    public /* synthetic */ void heal() {
        PlayerStats a2;
        PlayerStats playerStats = a2;
        playerStats.heal_noUpdate();
        ((MapleCharacter)playerStats.n.get()).updateSingleStat(MapleStat.HP, a2.getCurrentMaxHp());
        ((MapleCharacter)a2.n.get()).updateSingleStat(MapleStat.MP, a2.getCurrentMaxMp());
    }

    public final /* synthetic */ short passive_sharpeye_percent() {
        PlayerStats a2;
        return a2.Z;
    }

    public /* synthetic */ PlayerStats(MapleCharacter a2) {
        PlayerStats a3;
        PlayerStats playerStats = a3;
        PlayerStats playerStats2 = a3;
        PlayerStats playerStats3 = a3;
        PlayerStats playerStats4 = a3;
        a3.R = new ArrayList<Equip>();
        a3.Berserk = false;
        playerStats3.isRecalc = false;
        playerStats3.harvestingTool = 0;
        playerStats2.hpRecoverTime = 0;
        playerStats.mpRecoverTime = 0;
        playerStats2.lock = new ReentrantLock();
        playerStats.M = new EnumMap(Element.class);
        playerStats.I = new HashMap<Integer, Integer>();
        playerStats.F = new HashMap<Integer, Integer>();
        playerStats.e = new HashMap<Integer, Integer>();
        playerStats.E = new HashMap<Integer, Integer>();
        playerStats.g = new HashMap<Integer, Integer>();
        playerStats.B = new HashMap<Integer, Integer>();
        playerStats.k = new HashMap<Integer, Integer>();
        playerStats.K = new HashMap<Integer, Integer>();
        playerStats.v = new HashMap<Integer, Integer>();
        playerStats.T = new ArrayList<Equip>();
        playerStats.n = new WeakReference<MapleCharacter>(a2);
    }

    private /* synthetic */ int ALLATORIxDEMO(MapleCharacter a2) {
        int n2;
        ISkill iSkill;
        int n3;
        int n4 = 0;
        Iterator iterator = new LinkedList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList3 = new LinkedList<Integer>();
        iterator.add(20010194);
        iterator.add(22131001);
        iterator.add(21120004);
        iterator.add(60000222);
        iterator.add(61100007);
        iterator.add(61110007);
        iterator.add(32120009);
        iterator.add(32121010);
        iterator.add(31000003);
        iterator.add(110);
        iterator.add(1000006);
        iterator.add(4100006);
        iterator.add(4200006);
        iterator.add(4310004);
        iterator.add(4110008);
        iterator.add(4210013);
        iterator.add(4330008);
        iterator.add(14110009);
        iterator.add(3220009);
        iterator.add(3120011);
        iterator.add(5100009);
        iterator.add(5310007);
        iterator.add(51000000);
        iterator.add(3120006);
        iterator.add(3220005);
        iterator.add(11000005);
        iterator.add(15100007);
        iterator.add(15000008);
        linkedList.add(10000074);
        linkedList.add(50000074);
        linkedList2.add(5210012);
        linkedList2.add(5710004);
        linkedList3.add(65110005);
        ISkill iSkill2 = null;
        int n5 = 0;
        MapleStatEffect mapleStatEffect = null;
        iterator = iterator.iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                n3 = (Integer)iterator.next();
                iSkill2 = SkillFactory.getSkill(n3);
                if (iSkill2 == null) continue block0;
                ISkill iSkill3 = iSkill2;
                n5 = ((MapleCharacter)a2).getTotalSkillLevel(iSkill3);
                mapleStatEffect = iSkill3.getEffect(n5);
                if (n5 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                a.percent_hp += mapleStatEffect.getPercentHP();
                continue block0;
            }
            break;
        }
        iterator = linkedList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator;
            while (iterator3.hasNext()) {
                n3 = (Integer)iterator.next();
                iSkill2 = SkillFactory.getSkill(n3);
                if (iSkill2 == null) continue block2;
                ISkill iSkill4 = iSkill2;
                n5 = ((MapleCharacter)a2).getTotalSkillLevel(iSkill4);
                mapleStatEffect = iSkill4.getEffect(n5);
                if (n5 <= 0) {
                    iterator3 = iterator;
                    continue;
                }
                a.percent_hp += mapleStatEffect.getX();
                continue block2;
            }
            break;
        }
        iterator = linkedList2.iterator();
        block4: while (true) {
            Iterator iterator4 = iterator;
            while (iterator4.hasNext()) {
                n3 = (Integer)iterator.next();
                iSkill2 = SkillFactory.getSkill(n3);
                if (iSkill2 == null) continue block4;
                ISkill iSkill5 = iSkill2;
                n5 = ((MapleCharacter)a2).getTotalSkillLevel(iSkill5);
                mapleStatEffect = iSkill5.getEffect(n5);
                if (n5 <= 0) {
                    iterator4 = iterator;
                    continue;
                }
                n4 += mapleStatEffect.getX();
                continue block4;
            }
            break;
        }
        iterator = linkedList3.iterator();
        block6: while (true) {
            Iterator iterator5 = iterator;
            while (iterator5.hasNext()) {
                n3 = (Integer)iterator.next();
                iSkill2 = SkillFactory.getSkill(n3);
                if (iSkill2 == null) continue block6;
                ISkill iSkill6 = iSkill2;
                n5 = ((MapleCharacter)a2).getTotalSkillLevel(iSkill6);
                mapleStatEffect = iSkill6.getEffect(n5);
                if (n5 <= 0) {
                    iterator5 = iterator;
                    continue;
                }
                n4 += mapleStatEffect.getHpX();
                continue block6;
            }
            break;
        }
        if (((MapleCharacter)a2).getTitleEffect() > 0 && (iSkill = SkillFactory.getSkill(n2 = ((MapleCharacter)a2).getTitleEffect())) != null) {
            a2 = iSkill.getEffect(1);
            n4 += ((MapleStatEffect)a2).getHpX();
        }
        return n4;
    }

    private /* synthetic */ int H(MapleCharacter a2) {
        int n2 = 0;
        if (((MapleCharacter)a2).getTitleEffect() > 0 && (a2 = SkillFactory.getSkill(((MapleCharacter)a2).getTitleEffect())) != null) {
            a2 = a2.getEffect(1);
            n2 += ((MapleStatEffect)a2).getMpX();
        }
        return n2;
    }

    public final /* synthetic */ double getSpeedMod() {
        PlayerStats a2;
        return a2.j;
    }

    public final /* synthetic */ int getReduceCooltimeRate(int a2) {
        PlayerStats a3;
        if (a3.e.containsKey(a2)) {
            return a3.e.get(a2);
        }
        return 0;
    }

    public final /* synthetic */ float getHealHP() {
        PlayerStats a2;
        return a2.N;
    }

    public /* synthetic */ void heal_noUpdate() {
        PlayerStats a2;
        PlayerStats playerStats = a2;
        playerStats.setHp(playerStats.getCurrentMaxHp(), true);
        PlayerStats playerStats2 = a2;
        playerStats2.setMp(playerStats2.getCurrentMaxMp());
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void D(MapleCharacter a2) {
        switch (a2.getJob()) {
            case 300: 
            case 310: 
            case 311: 
            case 312: 
            case 320: 
            case 321: 
            case 322: {
                a.defRange = 100;
                ISkill iSkill = SkillFactory.getSkill(3000002);
                int n2 = a2.getSkillLevel(iSkill);
                if (n2 <= 0) return;
                a.defRange += iSkill.getEffect(n2).getRange();
                return;
            }
            case 410: 
            case 411: 
            case 412: 
            case 420: 
            case 421: 
            case 422: {
                a.defRange = 100;
                ISkill iSkill = SkillFactory.getSkill(4000001);
                int n3 = a2.getSkillLevel(iSkill);
                if (n3 <= 0) return;
                a.defRange += iSkill.getEffect(n3).getRange();
                return;
            }
            case 520: 
            case 521: 
            case 522: {
                a.defRange = 100;
                return;
            }
            case 1300: 
            case 1310: 
            case 1311: 
            case 1312: {
                a.defRange = 100;
                ISkill iSkill = SkillFactory.getSkill(13000001);
                int n4 = a2.getSkillLevel(iSkill);
                if (n4 <= 0) return;
                a.defRange += iSkill.getEffect(n4).getRange();
                return;
            }
            case 1400: 
            case 1410: 
            case 1411: 
            case 1412: {
                a.defRange = 100;
                ISkill iSkill = SkillFactory.getSkill(14000001);
                int n5 = a2.getSkillLevel(iSkill);
                if (n5 <= 0) return;
                a.defRange += iSkill.getEffect(n5).getRange();
                return;
            }
            case 2100: 
            case 2110: 
            case 2111: 
            case 2112: {
                a.defRange = 80;
                return;
            }
        }
    }

    public final /* synthetic */ boolean setMp(int a2) {
        PlayerStats a3;
        int n2 = a3.mp;
        if (a2 < 0) {
            a2 = 0;
        }
        if (a2 > a3.m) {
            a2 = a3.m;
        }
        a3.mp = a2;
        return a3.mp != n2;
    }

    public final /* synthetic */ float getHealMP() {
        PlayerStats a2;
        return a2.S;
    }

    public final /* synthetic */ short getLuk() {
        PlayerStats a2;
        return a2.luk;
    }

    public final /* synthetic */ int getHp() {
        PlayerStats a2;
        return a2.hp;
    }

    public final /* synthetic */ int getTotalDex() {
        PlayerStats a2;
        return a2.G;
    }

    public final /* synthetic */ byte passive_sharpeye_rate() {
        PlayerStats a2;
        return a2.P;
    }

    public final /* synthetic */ int getTotalInt() {
        PlayerStats a2;
        return a2.c;
    }

    public /* synthetic */ void heal(MapleCharacter a2) {
        PlayerStats a3;
        MapleCharacter mapleCharacter = a2;
        a3.heal_noUpdate();
        mapleCharacter.updateSingleStat(MapleStat.HP, a3.getCurrentMaxHp());
        mapleCharacter.updateSingleStat(MapleStat.MP, a3.getCurrentMaxMp());
    }

    public final /* synthetic */ float getHealHP_Percent() {
        PlayerStats a2;
        return a2.r;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void relocHeal() {
        block21: {
            block24: {
                block23: {
                    block22: {
                        block20: {
                            block19: {
                                block18: {
                                    var1_1 = (MapleCharacter)a.n.get();
                                    if (var1_1 == null) {
                                        return;
                                    }
                                    if (var1_1.isClone()) {
                                        return;
                                    }
                                    var2_2 = var1_1.getJob();
                                    v0 = a;
                                    v0.r = 0.0f;
                                    v0.Q = 0.0f;
                                    a.N = 10 + a.recoverHP;
                                    a.S = 3 + a.mpRestore + a.recoverMP;
                                    if (JobConstants.is\u60e1\u9b54\u6bba\u624b(var2_2)) {
                                        a.S = 0.0f;
                                    }
                                    if (!JobConstants.is\u7cbe\u9748\u904a\u4fe0(var2_2)) break block18;
                                    var3_3 = SkillFactory.getSkill(20020109);
                                    var4_5 = var1_1.getTotalSkillLevel((ISkill)var3_3);
                                    if (var4_5 > 0) {
                                        a.N += (float)(var3_3.getEffect(var4_5).getX() * a.l / 100);
                                        a.hpRecoverTime = 4000;
                                        a.S += (float)(var3_3.getEffect(var4_5).getX() * a.m / 100);
                                        a.mpRecoverTime = 4000;
                                    }
                                    ** GOTO lbl91
                                }
                                if (!JobConstants.is\u60e1\u9b54\u6bba\u624b(var2_2)) break block19;
                                var3_3 = SkillFactory.getSkill(31110009);
                                var4_6 = var1_1.getTotalSkillLevel((ISkill)var3_3);
                                if (var4_6 > 0) {
                                    a.S += (float)var3_3.getEffect(var4_6).getY();
                                    a.mpRecoverTime = 4000;
                                }
                                ** GOTO lbl91
                            }
                            if (!JobConstants.is\u6cd5\u5e2b(var2_2) || !JobConstants.is\u5192\u96aa\u5bb6(var2_2)) break block20;
                            v1 = var1_1;
                            v2 = v1;
                            a.S += (float)v1.getTotalSkillLevel(SkillFactory.getSkill(2000000)) / 10.0f * (float)var1_1.getLevel();
                            break block21;
                        }
                        if (!JobConstants.is\u528d\u58eb(var2_2) || !JobConstants.is\u5192\u96aa\u5bb6(var2_2)) break block22;
                        var3_3 = SkillFactory.getSkill(1110000);
                        var4_7 = var1_1.getTotalSkillLevel((ISkill)var3_3);
                        if (var4_7 > 0) {
                            a.S += (float)var3_3.getEffect(var4_7).getMp();
                        }
                        if ((var4_7 = var1_1.getTotalSkillLevel((ISkill)(var3_3 = SkillFactory.getSkill(1210000)))) > 0) {
                            a.S += (float)var3_3.getEffect(var4_7).getMp();
                        }
                        a.mpRecoverTime = 4000;
                        if (GameSetConstants.MAPLE_VERSION >= 138) {
                            var3_3 = SkillFactory.getSkill(1110000);
                            var4_7 = var1_1.getTotalSkillLevel((ISkill)var3_3);
                            if (var4_7 > 0) {
                                a.N += (float)var3_3.getEffect(var4_7).getMp();
                            }
                            if ((var4_7 = var1_1.getTotalSkillLevel((ISkill)(var3_3 = SkillFactory.getSkill(1210000)))) > 0) {
                                a.N += (float)var3_3.getEffect(var4_7).getMp();
                            }
                            a.hpRecoverTime = 4000;
                        }
                        ** GOTO lbl91
                    }
                    if (!JobConstants.is\u528d\u58eb(var2_2) || !JobConstants.is\u7687\u5bb6\u9a0e\u58eb\u5718(var2_2)) break block23;
                    var3_3 = SkillFactory.getSkill(11110000);
                    var4_8 = var1_1.getTotalSkillLevel((ISkill)var3_3);
                    if (var4_8 > 0) {
                        a.S += (float)var3_3.getEffect(var4_8).getMp();
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 138 && (var4_8 = var1_1.getTotalSkillLevel((ISkill)(var3_3 = SkillFactory.getSkill(11110000)))) > 0) {
                        a.N += (float)var3_3.getEffect(var4_8).getMp();
                    }
                    ** GOTO lbl91
                }
                if (!JobConstants.is\u76dc\u8cca(var2_2) || !JobConstants.is\u5192\u96aa\u5bb6(var2_2)) break block24;
                var3_3 = SkillFactory.getSkill(4100002);
                var4_9 = var1_1.getTotalSkillLevel((ISkill)var3_3);
                if (var4_9 > 0) {
                    v3 = a;
                    v3.N += (float)var3_3.getEffect(var4_9).getHp();
                    v3.S += (float)var3_3.getEffect(var4_9).getMp();
                }
                if ((var4_9 = var1_1.getTotalSkillLevel((ISkill)(var3_3 = SkillFactory.getSkill(4200001)))) > 0) {
                    v4 = a;
                    v4.N += (float)var3_3.getEffect(var4_9).getHp();
                    v4.S += (float)var3_3.getEffect(var4_9).getMp();
                }
                ** GOTO lbl91
            }
            if (!JobConstants.is\u62f3\u9738(var2_2) || !JobConstants.is\u5192\u96aa\u5bb6(var2_2) || (var4_10 = var1_1.getTotalSkillLevel((ISkill)(var3_3 = SkillFactory.getSkill(5100013)))) <= 0) ** GOTO lbl91
            v5 = a;
            v5.N += (float)(var3_3.getEffect(var4_10).getX() * a.l) / 100.0f;
            v5.S += (float)(var3_3.getEffect(var4_10).getX() * a.m) / 100.0f;
            if (GameSetConstants.MAPLE_VERSION >= 151) {
                v2 = var1_1;
                v6 = a;
                v6.hpRecoverTime = var3_3.getEffect(var4_10).getW() * 1000;
                v6.mpRecoverTime = var3_3.getEffect(var4_10).getW() * 1000;
            } else {
                v7 = var3_3;
                a.hpRecoverTime = v7.getEffect(var4_10).getY() * 1000;
                a.mpRecoverTime = v7.getEffect(var4_10).getY() * 1000;
lbl91:
                // 7 sources

                v2 = var1_1;
            }
        }
        if (v2.getChair() == 0) {
            if (var1_1.getMap() == null) return;
            var3_4 = var1_1.getMap().getRecoveryRate();
            if (!(v8 > 0.0f)) return;
            v9 = a;
            v9.N *= var3_4;
            v9.S *= var3_4;
            return;
        }
        var3_3 = MapleItemInformationProvider.getInstance().getChairRecovery(var1_1.getChair());
        v10 = a;
        if (var3_3 != null) {
            v10.N += (float)((Integer)var3_3.left).intValue();
            a.S += (float)((Integer)var3_3.right).intValue();
            return;
        }
        v10.N += 99.0f;
        a.S += 99.0f;
    }

    public final /* synthetic */ void connectData(MaplePacketLittleEndianWriter a2) {
        PlayerStats a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        PlayerStats playerStats = a3;
        a2.writeShort(a3.str);
        a2.writeShort(playerStats.dex);
        maplePacketLittleEndianWriter.writeShort(playerStats.int_);
        maplePacketLittleEndianWriter.writeShort(a3.luk);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            PlayerStats playerStats2 = a3;
            a2.writeInt(a3.hp);
            a2.writeInt(playerStats2.maxhp);
            maplePacketLittleEndianWriter2.writeInt(playerStats2.mp);
            maplePacketLittleEndianWriter2.writeInt(a3.maxmp);
            return;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        PlayerStats playerStats3 = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
        maplePacketLittleEndianWriter4.writeShort(a3.hp);
        maplePacketLittleEndianWriter4.writeShort(a3.maxhp);
        maplePacketLittleEndianWriter3.writeShort(playerStats3.mp);
        maplePacketLittleEndianWriter3.writeShort(playerStats3.maxmp);
    }

    public final /* synthetic */ void setDex(short a2) {
        PlayerStats a3;
        a3.dex = a2;
        a3.recalcLocalStats();
    }

    private /* synthetic */ int I(MapleCharacter a2) {
        int n2;
        int n3 = 0;
        Iterator iterator = new LinkedList<Integer>();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        iterator.add(32120009);
        iterator.add(32121010);
        ISkill iSkill = null;
        int n4 = 0;
        MapleStatEffect mapleStatEffect = null;
        iterator = iterator.iterator();
        block0: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block0;
                ISkill iSkill2 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill2);
                mapleStatEffect = iSkill2.getEffect(n4);
                if (n4 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getPercentMP();
                continue block0;
            }
            break;
        }
        iterator = linkedList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator;
            while (iterator3.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block2;
                ISkill iSkill3 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill3);
                mapleStatEffect = iSkill3.getEffect(n4);
                if (n4 <= 0) {
                    iterator3 = iterator;
                    continue;
                }
                a.percent_mp += mapleStatEffect.getX();
                continue block2;
            }
            break;
        }
        iterator = linkedList2.iterator();
        block4: while (true) {
            Iterator iterator4 = iterator;
            while (iterator4.hasNext()) {
                n2 = (Integer)iterator.next();
                iSkill = SkillFactory.getSkill(n2);
                if (iSkill == null) continue block4;
                ISkill iSkill4 = iSkill;
                n4 = a2.getTotalSkillLevel(iSkill4);
                mapleStatEffect = iSkill4.getEffect(n4);
                if (n4 <= 0) {
                    iterator4 = iterator;
                    continue;
                }
                n3 += mapleStatEffect.getX();
                continue block4;
            }
            break;
        }
        return n3;
    }

    public /* synthetic */ int getHPPercent() {
        PlayerStats a2;
        return (int)Math.ceil((double)a2.hp * 100.0 / (double)a2.l);
    }

    public final /* synthetic */ int getTotalWatk() {
        PlayerStats a2;
        return a2.f;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void recalcLocalStats(boolean a) {
        block282: {
            block269: {
                block272: {
                    block278: {
                        block270: {
                            block277: {
                                block276: {
                                    block275: {
                                        block274: {
                                            block273: {
                                                block271: {
                                                    var2_2 = (MapleCharacter)a.n.get();
                                                    if (var2_2 == null) {
                                                        return;
                                                    }
                                                    if (a.isRecalc) {
                                                        return;
                                                    }
                                                    if (var2_2.isClone()) {
                                                        return;
                                                    }
                                                    var3_3 = MapleItemInformationProvider.getInstance();
                                                    var4_7 = ((MapleCharacter)a.n.get()).inPVP();
                                                    var5_8 = a.l;
                                                    v0 = a;
                                                    var4_7 = var4_7 != 0 ? JobConstants.getPvpMaxHp((MapleCharacter)v0.n.get(), false) : v0.getMaxHp();
                                                    v1 = a;
                                                    var6_9 = v1.getMaxMp();
                                                    v1.coolTimeR = 0;
                                                    v1.InvincibleTimeAfterHit2 = 0;
                                                    v1.InvincibleTimeAfterHit2R = 0;
                                                    v1.incMaxDamage = 0;
                                                    v1.reduceCooltime = 0;
                                                    v1.d = (short)20;
                                                    v1.a = (short)50;
                                                    v1.ignoreDAMr = 0;
                                                    v1.ignoreDAMr_rate = 0;
                                                    v1.ignoreDAM = 0;
                                                    v1.ignoreDAM_rate = 0;
                                                    v1.InvincibleTimeAfterHit = 0;
                                                    v1.G = v1.getDex();
                                                    v1.c = v1.getInt();
                                                    v1.w = v1.getStr();
                                                    v1.b = v1.getLuk();
                                                    v1.EquipExp = 0;
                                                    v1.EquipDrop = 0;
                                                    v1.EquipMeso = 0;
                                                    v1.D = 0;
                                                    v1.wdef = 0;
                                                    v1.mdef = 0;
                                                    v1.G = v1.getDex();
                                                    v1.c = v1.getInt();
                                                    v1.w = v1.getStr();
                                                    v1.b = v1.getLuk();
                                                    v1.speed = 100;
                                                    v1.jump = 100;
                                                    v1.pickupRange = 0.0;
                                                    v1.decreaseDebuff = 0;
                                                    v1.ASR = 0;
                                                    v1.dot = 0;
                                                    v1.questBonus = 1;
                                                    v1.dotTime = 0;
                                                    v1.trueMastery = 0;
                                                    v1.percent_wdef = 0;
                                                    v1.percent_mdef = 0;
                                                    v1.percent_hp = 0;
                                                    v1.MDF = 0;
                                                    v1.percent_mp = 0;
                                                    v1.percent_str = 0;
                                                    v1.percent_dex = 0;
                                                    v1.percent_int = 0;
                                                    v1.percent_luk = 0;
                                                    v1.percent_acc = 0;
                                                    v1.percent_atk = 0;
                                                    v1.percent_matk = 0;
                                                    v1.A = 0;
                                                    v1.f = 0;
                                                    var7_10 = 0;
                                                    var8_11 = 0;
                                                    v1.A = v1.c;
                                                    v1.f = 0;
                                                    v1.k.clear();
                                                    v1.K.clear();
                                                    v1.e.clear();
                                                    v1.g.clear();
                                                    v1.E.clear();
                                                    v1.B.clear();
                                                    var9_12 = var2_2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-11);
                                                    v2 = var10_14 = var9_12 == null ? MapleWeaponType.\u6c92\u6709\u6b66\u5668 : GameConstants.getWeaponType(var9_12.getItemId());
                                                    if (!(var2_2.getJob() == 500 || var2_2.getJob() >= 510 && var2_2.getJob() <= 512 || var2_2.getJob() >= 520 && var2_2.getJob() <= 522) && (var2_2.getJob() < 1500 || var2_2.getJob() > 1512)) break block270;
                                                    if (var10_14 != MapleWeaponType.\u706b\u69cd) ** GOTO lbl151
                                                    if (!var2_2.haveItem(2330007, true ? 1 : 0, false, true) || var2_2.getLevel() < 50) break block271;
                                                    v3 = a;
                                                    a.f = 22;
                                                    break block272;
                                                }
                                                if (var2_2.getLevel() < 110) break block273;
                                                v3 = a;
                                                a.f = 20;
                                                break block272;
                                            }
                                            if (var2_2.getLevel() < 90) break block274;
                                            v3 = a;
                                            a.f = 18;
                                            break block272;
                                        }
                                        if (var2_2.getLevel() < 70) break block275;
                                        v3 = a;
                                        a.f = 16;
                                        break block272;
                                    }
                                    if (var2_2.getLevel() < 50) break block276;
                                    v3 = a;
                                    a.f = 14;
                                    break block272;
                                }
                                if (var2_2.getLevel() < 30) break block277;
                                v3 = a;
                                a.f = 12;
                                break block272;
                            }
                            if (var2_2.getLevel() < 10) ** GOTO lbl151
                            v3 = a;
                            a.f = 10;
                            break block272;
                        }
                        if (!(var2_2.getJob() == 400 || var2_2.getJob() >= 410 && var2_2.getJob() <= 412 || var2_2.getJob() >= 420 && var2_2.getJob() <= 422) && (var2_2.getJob() < 1400 || var2_2.getJob() > 1412)) break block278;
                        if (var10_14 != MapleWeaponType.\u62f3\u5957) ** GOTO lbl151
                        if (var2_2.haveItem(2070019, true ? 1 : 0, false, true) && var2_2.getLevel() >= 50) {
                            v3 = a;
                            a.f = 30;
                        } else if (var2_2.haveItem(2070006, true ? 1 : 0, false, true) || var2_2.haveItem(2070007, true ? 1 : 0, false, true)) {
                            v3 = a;
                            a.f = 27;
                        } else if (var2_2.haveItem(2070005, true ? 1 : 0, false, true)) {
                            v3 = a;
                            a.f = 25;
                        } else if (var2_2.haveItem(2070004, true ? 1 : 0, false, true)) {
                            v3 = a;
                            a.f = 23;
                        } else if (var2_2.haveItem(2070003, true ? 1 : 0, false, true)) {
                            v3 = a;
                            a.f = 21;
                        } else {
                            v4 = a;
                            if (var2_2.haveItem(2070001, true ? 1 : 0, false, true)) {
                                v4.f = 17;
                                v3 = a;
                            } else {
                                v4.f = 15;
                                v3 = a;
                            }
                        }
                        break block272;
                    }
                    if (!(var2_2.getJob() == 300 || var2_2.getJob() >= 310 && var2_2.getJob() <= 312 || var2_2.getJob() >= 320 && var2_2.getJob() <= 322) && (var2_2.getJob() < 1300 || var2_2.getJob() > 1312)) ** GOTO lbl151
                    if (var10_14 == MapleWeaponType.\u5f13) {
                        v3 = a;
                        a.f = 4;
                    } else {
                        if (var10_14 == MapleWeaponType.\u5f29) {
                            a.f = 4;
                        }
lbl151:
                        // 7 sources

                        v3 = a;
                    }
                }
                v3.dam_r = 100.0;
                v5 = a;
                v6 = a;
                v7 = a;
                v8 = a;
                v9 = a;
                v10 = a;
                v11 = a;
                v12 = a;
                v13 = a;
                v14 = a;
                v15 = a;
                v16 = a;
                v17 = a;
                v18 = a;
                v18.bossdam_r = 100.0;
                v18.realExpBuff = 100.0;
                v17.realCashBuff = 100.0;
                v17.realDropBuff = 100.0;
                v16.realMesoBuff = 100.0;
                v16.expBuff = 100.0;
                v15.cashBuff = 100.0;
                v15.dropBuff = 100.0;
                v14.mesoBuff = 100.0;
                v14.recoverHP = 0;
                v13.recoverMP = 0;
                v13.mpconReduce = 0;
                v12.incMesoProp = 0;
                v12.incRewardProp = 0;
                v11.DAMreflect = 0;
                v11.DAMreflect_rate = 0;
                v10.hpRecover = 0;
                v10.hpRecoverProp = 0;
                v9.mpRecover = 0;
                v9.mpRecoverProp = 0;
                v8.mpRestore = 0;
                v8.equippedWelcomeBackRing = false;
                v7.equippedFairy = false;
                v7.hasMeso = false;
                v6.hasItem = false;
                v6.hasPartyBonus = false;
                v5.hasVac = false;
                v5.hasClone = false;
                var10_15 = var2_2.getLevel() >= 120;
                v19 = a;
                v20 = a;
                v21 = a;
                v22 = a;
                v23 = a;
                v24 = a;
                v25 = a;
                v26 = a;
                v27 = a;
                v28 = a;
                v29 = a;
                v30 = a;
                v31 = a;
                v32 = a;
                v33 = a;
                v34 = a;
                v35 = a;
                v36 = a;
                v37 = a;
                v38 = a;
                v39 = a;
                v40 = a;
                v41 = a;
                v42 = a;
                v43 = a;
                v44 = a;
                v45 = a;
                v46 = a;
                v47 = a;
                v48 = a;
                v49 = a;
                v50 = a;
                v51 = a;
                v52 = a;
                v52.carddropBuff = 0.0;
                v52.dodgeChance = 0;
                v51.pvpDamage = 0;
                v51.mesoGuard = 50.0;
                v50.mesoGuardMeso = 0.0;
                v50.dam_r = 100.0;
                v49.bossdam_r = 100.0;
                v49.realExpBuff = 100.0;
                v48.realCashBuff = 100.0;
                v48.realDropBuff = 100.0;
                v47.realMesoBuff = 100.0;
                v47.expBuff = 100.0;
                v46.cashBuff = 100.0;
                v46.dropBuff = 100.0;
                v45.mesoBuff = 100.0;
                v45.recoverHP = 0;
                v44.recoverMP = 0;
                v44.mpconReduce = 0;
                v43.mpconPercent = 100;
                v43.incMesoProp = 0;
                v42.incRewardProp = 0;
                v42.DAMreflect = 0;
                v41.DAMreflect_rate = 0;
                v41.ignoreTargetDEF = 0;
                v40.hpRecover = 0;
                v40.hpRecoverProp = 0;
                v39.hpRecoverPercent = 0;
                v39.mpRecover = 0;
                v38.mpRecoverProp = 0;
                v38.mpRestore = 0;
                v37.pickRate = 0;
                v37.equippedWelcomeBackRing = false;
                v36.equippedFairy_ = false ? 1 : 0;
                v36.equippedSummon = 0;
                v35.hasPartyBonus = 0;
                v35.hasClone = false;
                v34.Berserk = false;
                v34.canFish = false;
                v33.canFishVIP = false;
                v33.equipmentBonusExp = 0;
                v32.RecoveryUP = 100;
                v32.BuffUP = 100;
                v31.RecoveryUP_Skill = 100;
                v31.BuffUP_Skill = 0;
                v30.BuffUP_Summon = 0;
                v30.dropMod = 1;
                v29.expMod = 1;
                v29.cashMod = 1;
                v28.expRate = 1;
                v28.expBuffAdd = 0.0;
                v27.levelBonus = 0;
                v27.incAllskill = 0;
                a.combatOrders = 0;
                v26.defRange = 0;
                a.T.clear();
                v26.R.clear();
                v26.I.clear();
                v25.F.clear();
                v25.v.clear();
                v25.harvestingTool = 0;
                v24.element_fire = 100;
                v24.element_ice = 100;
                v23.element_light = 100;
                v23.element_psn = 100;
                v22.def = 100;
                v22.TER = 0;
                v21.ASR = 0;
                v21.L = 0;
                v20.carddropBuff = 0.0;
                v20.Z = 0;
                v19.P = (byte)0;
                v19.reChargeChance = 0;
                var11_18 = MapleTrait.MapleTraitType.values();
                var12_22 = var11_18.length;
                v53 = var13_24 = 0;
                while (v53 < var12_22) {
                    var14_116 = var11_18[var13_25];
                    var2_2.getTrait((MapleTrait.MapleTraitType)var14_116).clearLocalExp();
                    v53 = ++var13_25;
                }
                var11_19 = 0;
                var12_23 = var2_2.getInventory(MapleInventoryType.EQUIPPED).iterator();
                while (true) {
                    block280: {
                        block281: {
                            block279: {
                                if (!var12_23.hasNext()) break block279;
                                var13_26 = var12_23.next();
                                var14_116 = (IEquip)var13_26;
                                if (var2_2.isLoggedIn() && (ItemCustomFlag.\u5c08\u5c6c\u9053\u5177.check(var13_26.getCustomFlag()) || MapleItemInformationProvider.getInstance().isOnlyEquip(var13_26.getItemId()) || MapleItemInformationProvider.getInstance().isOnly(var13_26.getItemId())) && var2_2.getEquippedSize(var13_26.getItemId()) > 1) {
                                    var11_19 = var13_26.getItemId();
                                }
                                if (var14_116.getPosition() == -11 && GameConstants.isMagicWeapon(var14_116.getItemId()) && (var15_119 = MapleItemInformationProvider.getInstance().getEquipStats(var14_116.getItemId())) != null) {
                                    if (var15_119.containsKey(ItemInformation.ALLATORIxDEMO("*5 \t\u000e\u001a\u0005"))) {
                                        a.element_fire = var15_119.getOrDefault(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz3T _"), 100);
                                    }
                                    if (var15_119.containsKey(ItemInformation.ALLATORIxDEMO("*5 \t\u000e\u001a\n"))) {
                                        a.element_ice = var15_119.getOrDefault(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz3T P"), 100);
                                    }
                                    if (var15_119.containsKey(ItemInformation.ALLATORIxDEMO("*5 \t\u000e\u001a\u000f"))) {
                                        a.element_light = var15_119.getOrDefault(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz3T U"), 100);
                                    }
                                    if (var15_119.containsKey(ItemInformation.ALLATORIxDEMO("*5 \t\u000e\u001a\u0010"))) {
                                        a.element_psn = var15_119.getOrDefault(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"p\u000fz3T J"), 100);
                                    }
                                    if (var15_119.containsKey(ItemInformation.ALLATORIxDEMO("&7&6\u0007>%:677"))) {
                                        a.def = var15_119.getOrDefault(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"|\r|\f]\u0004\u007f\u0000l\rm"), 100);
                                    }
                                }
                                if (var14_116.getItemId() / 10000 == 166 && var14_116.getAndroid() != null && var2_2.getAndroid() == null) {
                                    var2_2.setAndroid(var14_116.getAndroid());
                                }
                                var2_2.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).addLocalExp(var14_116.getHands());
                                v54 = a;
                                v55 = a;
                                v55.D += var14_116.getAcc();
                                var4_7 += var14_116.getHp();
                                var6_9 += var14_116.getMp();
                                v54.G += var14_116.getDex();
                                v55.c += var14_116.getInt();
                                v54.w += var14_116.getStr();
                                v54.b += var14_116.getLuk();
                                v54.A += var14_116.getMatk() + var14_116.getInt();
                                v54.f += var14_116.getWatk();
                                v54.speed += var14_116.getSpeed();
                                v56 = var14_116;
                                v54.jump += v56.getJump();
                                block0 : switch (v56.getItemId()) {
                                    case 1112427: {
                                        var7_10 += 5;
                                        v57 = a;
                                        var8_11 += 20;
                                        break;
                                    }
                                    case 1112428: {
                                        var7_10 += 10;
                                        v57 = a;
                                        var8_11 += 10;
                                        break;
                                    }
                                    case 1112429: {
                                        var7_10 += 5;
                                        v57 = a;
                                        var8_11 += 20;
                                        break;
                                    }
                                    case 1112127: 
                                    case 1112918: {
                                        v57 = a;
                                        a.equippedWelcomeBackRing = true;
                                        break;
                                    }
                                    case 0x111EE1: {
                                        v57 = a;
                                        a.equippedFairy = true;
                                        break;
                                    }
                                    case 1812000: {
                                        v57 = a;
                                        a.hasMeso = true;
                                        break;
                                    }
                                    case 1812001: {
                                        v57 = a;
                                        a.hasItem = true;
                                        break;
                                    }
                                    case 1112585: {
                                        v57 = a;
                                        a.equippedSummon = 1085;
                                        break;
                                    }
                                    case 1112586: {
                                        v57 = a;
                                        a.equippedSummon = 1087;
                                        break;
                                    }
                                    case 1112663: {
                                        v57 = a;
                                        a.equippedSummon = 1179;
                                        break;
                                    }
                                    case 1112728: {
                                        v57 = a;
                                        a.equippedFairy_ = 10;
                                        break;
                                    }
                                    case 1122158: {
                                        v57 = a;
                                        a.equippedFairy_ = 5;
                                        break;
                                    }
                                    default: {
                                        var15_119 = GameConstants.Equipments_Bonus;
                                        var16_123 = GameConstants.Equipments_Bonus.length;
                                        v58 = var17_125 = 0;
                                        while (v58 < var16_123) {
                                            var18_130 = var15_119[var17_125];
                                            if (var14_116.getItemId() == var18_130) {
                                                v59 = a;
                                                v57 = v59;
                                                v59.equipmentBonusExp += GameConstants.Equipment_Bonus_EXP((int)var18_130);
                                                break block0;
                                            }
                                            v58 = ++var17_125;
                                        }
                                        v57 = a;
                                    }
                                }
                                v57.percent_hp += var14_116.getHpR();
                                v60 = var14_116;
                                a.percent_mp += v60.getMpR();
                                var15_118 = var3_3.getSetItemID(v60.getItemId());
                                if (var15_118 > 0) {
                                    var16_123 = 1;
                                    if (a.v.get(var15_118) != null) {
                                        var16_123 += a.v.get(var15_118).intValue();
                                    }
                                    a.v.put(var15_118, var16_123);
                                }
                                if (var14_116.getIncSkill() > 0 && var3_3.getEquipSkills(var14_116.getItemId()) != null) {
                                    for (int var17_125 : var3_3.getEquipSkills(var14_116.getItemId())) {
                                        var18_131 = SkillFactory.getSkill(var17_125);
                                        if (var18_131 == null || !var18_131.canBeLearnedBy(var2_2.getJob())) continue;
                                        var19_136 = 1;
                                        if (a.I.get(var18_131.getId()) != null) {
                                            var19_136 += a.I.get(var18_131.getId()).intValue();
                                        }
                                        a.I.put(var18_131.getId(), var19_136);
                                    }
                                }
                                if ((var16_122 = var3_3.getEquipAdditions(var14_116.getItemId())) == null) break block280;
                                var17_126 = var16_122.entrySet().iterator();
                                break block281;
                            }
                            if (var11_19 != 0) {
                                var2_2.unequip(var11_19);
                            }
                            for (Map.Entry var13_27 : a.v.entrySet()) {
                                var14_116 = var3_3.getSetItem((Integer)var13_27.getKey());
                                if (var14_116 == null) continue;
                                var15_120 = var14_116.getItems();
                                var16_122 = var15_120.entrySet().iterator();
                                while (var16_122.hasNext()) {
                                    var17_128 = var16_122.next();
                                    if (var17_128.getKey() > (Integer)var13_27.getValue()) continue;
                                    var18_134 = var17_128.getValue();
                                    v61 = a;
                                    v62 = a;
                                    v63 = a;
                                    v64 = var18_134;
                                    v63.w += v64.incSTR + v64.incAllStat;
                                    v65 = var18_134;
                                    v63.G += v65.incDEX + v65.incAllStat;
                                    v66 = var18_134;
                                    v63.c += v66.incINT + v66.incAllStat;
                                    v67 = var18_134;
                                    v63.b += v67.incLUK + v67.incAllStat;
                                    v63.f += var18_134.incPAD;
                                    v63.A += var18_134.incMAD;
                                    v63.speed += var18_134.incSpeed;
                                    v62.D += var18_134.incACC;
                                    var4_7 += var18_134.incMHP;
                                    var6_9 += var18_134.incMMP;
                                    v61.percent_hp += var18_134.incMHPr;
                                    v62.percent_mp += var18_134.incMMPr;
                                    v61.wdef += var18_134.incPDD;
                                    v68 = var18_134;
                                    v61.mdef += v68.incMDD;
                                    if (v68.option1 > 0 && var18_134.option1Level > 0 && var3_3.getPotentialInfo(var18_134.option1) != null && (var9_12 = var3_3.getPotentialInfo(var18_134.option1).get(var18_134.option1Level)) != null) {
                                        var4_7 += var9_12.get(ItemInformation.ALLATORIxDEMO("2-8\u000e\u0013\u0013"));
                                        var6_9 += var9_12.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002T,I"));
                                        a.handlePotential((StructPotentialItem)var9_12, var2_2, a);
                                    }
                                    if (var18_134.option2 <= 0 || var18_134.option2Level <= 0 || var3_3.getPotentialInfo(var18_134.option2) == null || (var9_12 = var3_3.getPotentialInfo(var18_134.option2).get(var18_134.option2Level)) == null) continue;
                                    var4_7 += var9_12.get(ItemInformation.ALLATORIxDEMO("2-8\u000e\u0013\u0013"));
                                    var6_9 += var9_12.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002T,I"));
                                    a.handlePotential((StructPotentialItem)var9_12, var2_2, a);
                                }
                            }
                            v69 = a;
                            v70 = var2_2;
                            v71 = a;
                            v71.handleProfessionTool(var2_2);
                            v71.handlePlayerRate(var2_2);
                            v69.handleChangeSkills(v70, a);
                            v69.handleLocalStats(v70);
                            var15_121 = var2_2.getStatForBuff(MapleBuffStat.MONSTER_RIDING);
                            if (var15_121 != null && var15_121.getSourceId() == 33001001) {
                                v72 = a;
                                v72.P = (byte)(v72.P + var15_121.getW());
                                v72.percent_hp += var15_121.getZ();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.DICE_ROLL)) != null) {
                                v73 = a;
                                v73.percent_wdef += GameConstants.getDiceStat(var16_122.intValue(), 2);
                                v73.percent_mdef += GameConstants.getDiceStat(var16_122.intValue(), 2);
                                v73.percent_hp += GameConstants.getDiceStat(var16_122.intValue(), 3);
                                v73.percent_mp += GameConstants.getDiceStat(var16_122.intValue(), 3);
                                v73.P = (byte)(v73.P + GameConstants.getDiceStat(var16_122.intValue(), 4));
                                v73.dam_r *= ((double)GameConstants.getDiceStat(var16_122.intValue(), 5) + 100.0) / 100.0;
                                v73.bossdam_r *= ((double)GameConstants.getDiceStat(var16_122.intValue(), 5) + 100.0) / 100.0;
                                v73.expBuff *= ((double)GameConstants.getDiceStat(var16_122.intValue(), 6) + 100.0) / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.INFINITY)) != null) {
                                a.percent_matk += var16_122.intValue() - 1;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ONYX_SHROUD)) != null) {
                                a.dodgeChance += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.PVP_DAMAGE)) != null) {
                                a.pvpDamage += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.PVP_ATTACK)) != null) {
                                a.pvpDamage += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.FELINE_BERSERK)) != null) {
                                a.percent_hp += var16_122.intValue();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.BLUE_AURA)) != null) {
                                v74 = a;
                                v74.percent_wdef += var15_121.getZ() + var15_121.getY();
                                v74.percent_mdef += var15_121.getZ() + var15_121.getY();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.CONVERSION)) != null) {
                                v75 = var2_2;
                                a.percent_hp += var16_122.intValue();
                            } else {
                                var16_122 = var2_2.getBuffedValue(MapleBuffStat.MAXHP);
                                if (var16_122 != null) {
                                    a.percent_hp += var16_122.intValue();
                                }
                                v75 = var2_2;
                            }
                            var16_122 = v75.getBuffedValue(MapleBuffStat.MAXMP);
                            if (var16_122 != null) {
                                a.percent_mp += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MP_BUFF)) != null) {
                                a.percent_mp += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_X(MapleBuffStat.BUFF_MASTERY)) != null) {
                                a.BuffUP_Skill += var16_122.intValue();
                            }
                            v76 = var2_2;
                            v77 = a;
                            v78 = var2_2;
                            v79 = a;
                            v80 = a;
                            a.f = (int)((double)a.f + Math.floor((float)(v80.f * v80.percent_atk) / 100.0f));
                            v81 = a;
                            v79.A = (int)((double)v79.A + Math.floor((float)(v81.A * v81.percent_matk) / 100.0f));
                            v82 = a;
                            v79.c = (int)((double)v79.c + Math.floor((float)(v82.c * v82.percent_matk) / 100.0f));
                            v79.handlePassiveSkills(var2_2);
                            a.H(v78);
                            v77.handleSpecialSkills(v78);
                            v77.handleGuildSkills(var2_2);
                            a.ALLATORIxDEMO(v76);
                            var17_129 = v76.getTrait(MapleTrait.MapleTraitType.\u611f\u6027).getLevel();
                            var18_135 = var17_129 / 5;
                            var6_9 += var18_135 * 100;
                            var19_136 = v76.getTrait(MapleTrait.MapleTraitType.\u610f\u5fd7).getLevel();
                            var20_139 = var19_136 / 5;
                            var4_7 += var20_139 * 100;
                            a.ASR += var2_2.getTrait(MapleTrait.MapleTraitType.\u610f\u5fd7).getLevel() / 5;
                            var21_140 = var2_2.getTrait(MapleTrait.MapleTraitType.\u6d1e\u5bdf\u529b).getLevel();
                            var3_4 = var21_140 / 5;
                            var9_13 = (var3_4 * var3_4 - var3_4 + 4) * 5 / 2;
                            if (var3_4 < 5) {
                                var9_13 = 0;
                            }
                            a.D += var9_13;
                            var4_7 += a.ALLATORIxDEMO(var2_2);
                            v83 = a;
                            var6_9 += v83.l(var2_2);
                            v84 = a;
                            v83.wdef = (int)((double)v83.wdef + Math.min(30000.0, Math.floor((float)(v84.wdef * v84.percent_wdef) / 100.0f)));
                            v85 = a;
                            a.mdef = (int)((double)a.mdef + Math.min(30000.0, Math.floor((float)(v85.wdef * v85.percent_mdef) / 100.0f)));
                            var16_122 = var2_2.getBuffedValue(MapleBuffStat.STR);
                            if (var16_122 != null) {
                                a.w += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.DEX)) != null) {
                                a.G += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.INT)) != null) {
                                a.c += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.LUK)) != null) {
                                a.b += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ANGEL_STAT)) != null) {
                                v86 = a;
                                v86.w += var16_122.intValue();
                                v86.G += var16_122.intValue();
                                v86.c += var16_122.intValue();
                                v86.b += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ENHANCED_MAXHP)) != null) {
                                var4_7 += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ENHANCED_MAXMP)) != null) {
                                var6_9 += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ENHANCED_WDEF)) != null) {
                                a.wdef += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ENHANCED_MDEF)) != null) {
                                a.mdef += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.WDEF)) != null) {
                                a.wdef += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.WDEF)) != null) {
                                a.mdef += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.HP_BOOST)) != null) {
                                var4_7 += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MP_BOOST)) != null) {
                                var6_9 += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MAPLE_WARRIOR)) != null) {
                                var22_141 = var16_122.doubleValue() / 100.0;
                                v87 = a;
                                v87.w = (int)((double)v87.w + var22_141 * (double)a.str);
                                v87.G = (int)((double)v87.G + var22_141 * (double)a.dex);
                                v87.b = (int)((double)v87.b + var22_141 * (double)a.luk);
                                v87.c = (int)((double)v87.c + var22_141 * (double)a.int_);
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ECHO_OF_HERO)) != null) {
                                var22_141 = var16_122.doubleValue() / 100.0;
                                v88 = a;
                                a.f += (int)((double)v88.f * var22_141);
                                v88.A += (int)((double)a.A * var22_141);
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ARAN_COMBO)) != null) {
                                a.f += var16_122.intValue() / 10;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MESOGUARD)) != null) {
                                a.mesoGuardMeso += var16_122.doubleValue();
                            }
                            v89 = var2_2;
                            var13_28 = SkillFactory.getSkill(GameConstants.getBOF_ForJob(v89.getJob()));
                            var14_117 = v89.getSkillLevel(var13_28);
                            if (var14_117 > 0) {
                                var15_121 = var13_28.getEffect(var14_117);
                                v90 = a;
                                v90.f += var15_121.getX();
                                v90.A += var15_121.getY();
                                v90.D += var15_121.getX();
                            }
                            v91 = var2_2;
                            var13_29 = SkillFactory.getSkill(GameConstants.getEmpress_ForJob(v91.getJob()));
                            var14_117 = v91.getSkillLevel(var13_29);
                            if (var14_117 > 0) {
                                var15_121 = var13_29.getEffect(var14_117);
                                v92 = a;
                                v92.f += var15_121.getX();
                                v92.A += var15_121.getY();
                                v92.D += var15_121.getZ();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.EXPRATE)) != null) {
                                a.expBuff *= var16_122.doubleValue() / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.EXPRATE_ADD)) != null) {
                                a.expBuffAdd += var16_122.doubleValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ACASH_RATE)) != null) {
                                v93 = a;
                                v93.realCashBuff += var16_122.doubleValue();
                                v93.cashBuff *= var16_122.doubleValue() / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MESO_RATE)) != null) {
                                var22_141 = var16_122.doubleValue();
                                var3_5 = var2_2.getStatForBuff(MapleBuffStat.MESO_RATE);
                                if (var3_5.getAvailableMap() != null && var3_5.getAvailableMap().size() > 0) {
                                    var9_13 = 0;
                                    for (Pair<Integer, Integer> var11_20 : var3_5.getAvailableMap()) {
                                        if (var2_2.getMapId() >= (Integer)var11_20.left && var2_2.getMapId() <= (Integer)var11_20.right) continue;
                                        ++var9_13;
                                    }
                                    if (var9_13 == var3_5.getAvailableMap().size()) {
                                        var22_141 = 100.0;
                                    }
                                    v94 = a;
                                    v94.mesoBuff *= var22_141 / 100.0;
                                    v94.realMesoBuff = v94.mesoBuff;
                                }
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MESOUP)) != null) {
                                v95 = a;
                                v95.realMesoBuff += var16_122.doubleValue();
                                v95.mesoBuff *= var16_122.doubleValue() / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ACC)) != null) {
                                a.D += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ANGEL_ACC)) != null) {
                                a.D += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ANGEL_ATK)) != null) {
                                a.f += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ANGEL_MATK)) != null) {
                                a.A += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.WATK)) != null) {
                                a.f += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.SPIRIT_LINK)) != null) {
                                v96 = a;
                                v96.P = (byte)(v96.P + var16_122.intValue());
                                v96.dam_r *= ((double)var16_122.intValue() + 100.0) / 100.0;
                                v96.bossdam_r *= ((double)var16_122.intValue() + 100.0) / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.ENHANCED_WATK)) != null) {
                                a.f += var16_122.intValue();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.ENERGY_CHARGE)) != null) {
                                v97 = a;
                                v97.f += var15_121.getWatk();
                                v97.D += var15_121.getAcc();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MATK)) != null) {
                                a.A += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.SPEED)) != null) {
                                a.speed += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.JUMP)) != null) {
                                a.jump += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.DASH_SPEED)) != null) {
                                a.speed += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.DASH_JUMP)) != null) {
                                a.jump += var16_122.intValue();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.HIDDEN_POTENTIAL)) != null) {
                                v98 = a;
                                a.P = (byte)100;
                                v98.ASR = 100;
                                a.wdef += var15_121.getX();
                                v98.mdef += var15_121.getX();
                                v98.f += var15_121.getX();
                                v98.A += var15_121.getX();
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.DAMAGE_BUFF)) != null) {
                                v99 = a;
                                v99.dam_r *= (var16_122.doubleValue() + 100.0) / 100.0;
                                v99.bossdam_r *= (var16_122.doubleValue() + 100.0) / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_Y(MapleBuffStat.FINAL_CUT)) != null) {
                                v100 = a;
                                v100.dam_r *= var16_122.doubleValue() / 100.0;
                                v100.bossdam_r *= var16_122.doubleValue() / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.WIND_WALK)) != null && (var15_121 = var2_2.getStatForBuff(MapleBuffStat.WIND_WALK)) != null) {
                                v101 = a;
                                v101.dam_r *= (double)var15_121.getDamage() / 100.0;
                                v101.bossdam_r *= (double)var15_121.getDamage() / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_Y(MapleBuffStat.OWL_SPIRIT)) != null) {
                                v102 = a;
                                v102.dam_r *= var16_122.doubleValue() / 100.0;
                                v102.bossdam_r *= var16_122.doubleValue() / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_X(MapleBuffStat.BERSERK_FURY)) != null) {
                                v103 = a;
                                v103.dam_r *= var16_122.doubleValue() / 100.0;
                                v103.bossdam_r *= var16_122.doubleValue() / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.BLESS)) != null) {
                                v104 = a;
                                v104.f += var15_121.getX();
                                v104.A += var15_121.getY();
                                v104.D += var15_121.getV();
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_X(MapleBuffStat.CONCENTRATE)) != null) {
                                a.mpconReduce += var16_122.intValue();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.HOLY_SHIELD)) != null) {
                                v105 = a;
                                v105.f += var15_121.getX();
                                v105.A += var15_121.getY();
                                v105.D += var15_121.getV();
                                v105.mpconReduce += var15_121.getMPConReduce();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.MAGIC_RESISTANCE)) != null) {
                                a.ASR += var15_121.getX();
                            }
                            v106 = var2_2;
                            var15_121 = v106.getStatForBuff(MapleBuffStat.COMBO);
                            var16_122 = v106.getBuffedValue(MapleBuffStat.COMBO);
                            if (var15_121 != null && var16_122 != null) {
                                v107 = a;
                                v107.dam_r *= (100.0 + (double)((var15_121.getV() + var15_121.getDAMRate()) * (var16_122.intValue() - 1))) / 100.0;
                                v107.bossdam_r *= (100.0 + (double)((var15_121.getV() + var15_121.getDAMRate()) * (var16_122.intValue() - 1))) / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.SUMMON)) != null && var15_121.getSourceId() == 35121010) {
                                v108 = a;
                                v108.dam_r *= ((double)var15_121.getX() + 100.0) / 100.0;
                                v108.bossdam_r *= ((double)var15_121.getX() + 100.0) / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.DARK_AURA)) != null) {
                                v109 = a;
                                v109.dam_r *= ((double)var15_121.getX() + 100.0) / 100.0;
                                v109.bossdam_r *= ((double)var15_121.getX() + 100.0) / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.BODY_BOOST)) != null) {
                                v110 = a;
                                v110.dam_r *= ((double)var15_121.getV() + 100.0) / 100.0;
                                v110.bossdam_r *= ((double)var15_121.getV() + 100.0) / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.BEHOLDER)) != null) {
                                a.trueMastery += var15_121.getMastery();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.MECH_CHANGE)) != null) {
                                a.P = (byte)(a.P + var15_121.getCr());
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.PYRAMID_PQ)) != null && var15_121.getBerserk() > 0) {
                                v111 = a;
                                v111.dam_r *= (double)var15_121.getBerserk() / 100.0;
                                v111.bossdam_r *= (double)var15_121.getBerserk() / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.WK_CHARGE)) != null) {
                                v112 = a;
                                v112.dam_r *= (double)var15_121.getDamage() / 100.0;
                                v112.bossdam_r *= (double)var15_121.getDamage() / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.PICKPOCKET)) != null) {
                                a.pickRate = var15_121.getProp();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.DAMAGE_PERCENT)) != null) {
                                v113 = a;
                                v113.dam_r *= ((double)var15_121.getDAMRate() + 100.0) / 100.0;
                                v113.bossdam_r *= ((double)var15_121.getDAMRate() + 100.0) / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.LIGHTNING_CHARGE)) != null) {
                                v114 = a;
                                v114.dam_r *= (double)var15_121.getDamage() / 100.0;
                                v114.bossdam_r *= (double)var15_121.getDamage() / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.WIND_WALK)) != null) {
                                v115 = a;
                                v115.dam_r *= (double)var15_121.getDamage() / 100.0;
                                v115.bossdam_r *= (double)var15_121.getDamage() / 100.0;
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.DIVINE_SHIELD)) != null) {
                                a.f += var15_121.getEnhancedWatk();
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_Y(MapleBuffStat.DARKSIGHT)) != null) {
                                v116 = a;
                                v116.dam_r *= ((double)var16_122.intValue() + 100.0) / 100.0;
                                v116.bossdam_r *= ((double)var16_122.intValue() + 100.0) / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_X(MapleBuffStat.ENRAGE)) != null) {
                                v117 = a;
                                v117.dam_r *= ((double)var16_122.intValue() + 100.0) / 100.0;
                                v117.bossdam_r *= ((double)var16_122.intValue() + 100.0) / 100.0;
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_X(MapleBuffStat.COMBAT_ORDERS)) != null) {
                                a.combatOrders += var16_122.intValue();
                            }
                            if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.SHARP_EYES)) != null) {
                                v118 = a;
                                v118.P = (byte)(v118.P + var15_121.getX());
                                v118.Z = (short)(v118.Z + var15_121.getCriticalMax());
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_X(MapleBuffStat.SHARP_EYES)) != null) {
                                var7_10 += var16_122.intValue();
                            }
                            if ((var16_122 = var2_2.getBuffedSkill_Y(MapleBuffStat.SHARP_EYES)) == null) ** GOTO lbl801
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                var8_11 += var16_122.intValue();
                                v119 = var2_2;
                            } else {
                                var8_11 += var16_122.intValue() - 100;
lbl801:
                                // 2 sources

                                v119 = var2_2;
                            }
                            var16_122 = v119.getBuffedValue(MapleBuffStat.CRITICAL_RATE_BUFF);
                            if (var16_122 != null) {
                                a.P = (byte)(a.P + var16_122.intValue());
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.HP_BOOST_PERCENT)) != null) {
                                var4_7 = (int)((double)var4_7 + (double)var4_7 * var16_122.doubleValue() / 100.0);
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MP_BOOST_PERCENT)) != null) {
                                var6_9 = (int)((double)var6_9 + (double)var6_9 * var16_122.doubleValue() / 100.0);
                            }
                            if (a.speed > 140) {
                                a.speed = 140;
                            }
                            if (a.jump > 123) {
                                a.jump = 123;
                            }
                            if ((var16_122 = var2_2.getBuffedValue(MapleBuffStat.MONSTER_RIDING)) == null) ** GOTO lbl831
                            a.jump = 123;
                            switch (var16_122.intValue()) {
                                case 1: {
                                    a.speed = 150;
                                    v120 = var4_7;
                                    break;
                                }
                                case 2: {
                                    a.speed = 170;
                                    v120 = var4_7;
                                    break;
                                }
                                case 3: {
                                    a.speed = 180;
                                    v120 = var4_7;
                                    break;
                                }
                                default: {
                                    a.speed = 200;
lbl831:
                                    // 2 sources

                                    v120 = var4_7;
                                }
                            }
                            var4_7 = (int)((double)v120 + Math.floor((float)(a.percent_hp * var4_7) / 100.0f));
                            var6_9 = (int)((double)var6_9 + Math.floor((float)(a.percent_mp * var6_9) / 100.0f));
                            v121 = a;
                            a.h = v121.G + v121.c + a.b;
                            if (GameSetConstants.MAPLE_VERSION >= 134) {
                                v122 = a;
                                v122.l(var2_2);
                                v122.ignoreTargetDEF += var2_2.getTrait(MapleTrait.MapleTraitType.\u9818\u5c0e\u529b).getLevel() / 10;
                                v122.pvpDamage += var2_2.getTrait(MapleTrait.MapleTraitType.\u9818\u5c0e\u529b).getLevel() / 10;
                            }
                            var22_142 = GameSetConstants.MAPLE_VERSION >= 134 ? 99999 : 30000;
                            v123 = a;
                            v124 = var22_142;
                            v123.l = Math.min(v124, Math.abs(Math.max(-v124, var4_7)));
                            v123.m = Math.min(var22_142, Math.abs(Math.max(-var22_142, var6_9)));
                            if (var2_2.getEventInstance() != null && var2_2.getEventInstance().getName().startsWith(ItemInformation.ALLATORIxDEMO("\u0013\r\u0013"))) {
                                a.l = Math.min(40000, a.l * 1);
                                a.m = Math.min(20000, a.m * 1);
                                var23_143 = PlayerStats.pvpSkills;
                                var3_6 = PlayerStats.pvpSkills.length;
                                v125 = var9_13 = 0;
                                break;
                            }
                            break block269;
                        }
                        block61: while (var17_126.hasNext()) {
                            var18_132 = var17_126.next();
                            switch (1.d[var18_132.getKey().ordinal()]) {
                                case 1: {
                                    var19_136 = (Integer)var18_132.getValue().right;
                                    var20_137 = Element.getFromId((Integer)var18_132.getValue().left);
                                    if (a.M.get((Object)var20_137) != null) {
                                        var19_136 += a.M.get((Object)var20_137).intValue();
                                    }
                                    a.M.put(var20_137, var19_136);
                                    continue block61;
                                }
                                case 2: {
                                    a.dam_r *= ((double)((Integer)var18_132.getValue().right).intValue() + 100.0) / 100.0;
                                    a.bossdam_r += ((double)((Integer)var18_132.getValue().right).intValue() + 100.0) / 100.0;
                                    continue block61;
                                }
                                case 3: {
                                    a.P = (byte)(a.P + (Integer)var18_132.getValue().left);
                                    a.Z = (short)(a.Z + (Integer)var18_132.getValue().right);
                                    continue block61;
                                }
                                case 4: {
                                    a.bossdam_r *= ((double)((Integer)var18_132.getValue().right).intValue() + 100.0) / 100.0;
                                    continue block61;
                                }
                                case 5: {
                                    if ((Integer)var18_132.getValue().left > 0) {
                                        a.hpRecover += ((Integer)var18_132.getValue().left).intValue();
                                        a.hpRecoverProp += 5;
                                    }
                                    if ((Integer)var18_132.getValue().right <= 0) continue block61;
                                    a.mpRecover += ((Integer)var18_132.getValue().right).intValue();
                                    a.mpRecoverProp += 5;
                                    continue block61;
                                }
                                case 6: {
                                    if (!a) continue block61;
                                    var2_2.changeSkillLevel_Skip(SkillFactory.getSkill((Integer)var18_132.getValue().left), (byte)((Integer)var18_132.getValue().right).intValue(), (byte)0);
                                    continue block61;
                                }
                                case 7: {
                                    a.recoverHP += ((Integer)var18_132.getValue().left).intValue();
                                    a.recoverMP += ((Integer)var18_132.getValue().right).intValue();
                                    continue block61;
                                }
                            }
                        }
                    }
                    if (var14_116.getState() > 1) {
                        v126 = new int[3];
                        v126[0] = var14_116.getPotential1();
                        v126[1] = var14_116.getPotential2();
                        v126[2] = var14_116.getPotential3();
                        var17_127 = v126;
                        var18_133 = v126;
                        var19_136 = var18_133.length;
                        v127 = var20_138 = 0;
                        while (v127 < var19_136) {
                            var21_140 = var18_133[var20_138];
                            if (var21_140 > 0 && var3_3.getPotentialInfo(var21_140) != null && var3_3.getReqLevel(var14_116.getItemId()) / 10 < var3_3.getPotentialInfo(var21_140).size() && (var9_12 = var3_3.getPotentialInfo(var21_140).get(var3_3.getReqLevel(var14_116.getItemId()) / 10)) != null) {
                                var4_7 += var9_12.get(ItemInformation.ALLATORIxDEMO("2-8\u000e\u0013\u0013"));
                                var6_9 += var9_12.get(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\bw\u0002T,I"));
                                a.handlePotential((StructPotentialItem)var9_12, var2_2, a);
                            }
                            v127 = ++var20_138;
                        }
                    }
                    if (var14_116.getDurability() > 0 && !ItemConstants.isHarvesting(var14_116.getItemId())) {
                        a.T.add((Equip)var14_116);
                    }
                    if (!var10_15 || ItemConstants.getMaxLevel(var14_116.getItemId()) <= 0) continue;
                    if (ItemConstants.getStatFromWeapon(var14_116.getItemId()) == null) {
                        if (var14_116.getEquipLevel() > ItemConstants.getMaxLevel(var14_116.getItemId())) continue;
                        v128 = a;
                    } else {
                        if (var14_116.getEquipLevel() >= ItemConstants.getMaxLevel(var14_116.getItemId())) continue;
                        v128 = a;
                    }
                    v128.R.add((Equip)var14_116);
                }
                while (v125 < var3_6) {
                    var10_17 = var23_143[var9_13];
                    var11_21 = SkillFactory.getSkill(var10_17);
                    if (var11_21 != null && var11_21.canBeLearnedBy(var2_2.getJob())) {
                        v129 = var11_21;
                        var2_2.changeSkillLevel_Skip(v129, (byte)1, (byte)0);
                        var15_121 = v129.getEffect(1);
                        switch (var10_17 / 1000000 % 10) {
                            case 1: {
                                if (var15_121.getX() <= 0) break;
                                a.pvpDamage += a.wdef / var15_121.getX();
                                break;
                            }
                            case 3: {
                                v130 = a;
                                v130.hpRecoverProp += var15_121.getProp();
                                v130.hpRecover += var15_121.getX();
                                v130.mpRecoverProp += var15_121.getProp();
                                v130.mpRecover += var15_121.getX();
                                break;
                            }
                            case 5: {
                                a.P = (byte)(a.P + var15_121.getProp());
                                a.Z = (short)100;
                            }
                        }
                        break;
                    }
                    v125 = ++var9_13;
                }
                if ((var15_121 = var2_2.getStatForBuff(MapleBuffStat.MORPH)) != null && var15_121.getSourceId() % 10000 == 1105) {
                    v131 = a;
                    v131.l = 99999;
                    v131.m = 99999;
                }
            }
            if (JobConstants.is\u60e1\u9b54\u6bba\u624b(var2_2.getJob()) && a.m > (var23_144 = GameConstants.getMPByJob(var2_2))) {
                a.m = var23_144;
            }
            switch (var2_2.getJob()) {
                case 110: 
                case 111: 
                case 112: {
                    var13_30 = SkillFactory.getSkill(1100009);
                    if (var13_30 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_30)) > 0) {
                        var15_121 = var13_30.getEffect(var14_117);
                        a.F.put(1001004, var15_121.getX());
                        a.F.put(1001005, var15_121.getY());
                        v132 = a;
                        v132.w += var15_121.getStrX();
                        v132.G += var15_121.getDexX();
                    }
                    if ((var13_31 = SkillFactory.getSkill(1110009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_31)) > 0) {
                        var15_121 = var13_31.getEffect(var14_117);
                        v133 = a;
                        v133.dam_r *= (double)var15_121.getDamage() / 100.0;
                        v133.bossdam_r *= (double)var15_121.getDamage() / 100.0;
                    }
                    if ((var13_32 = SkillFactory.getSkill(1120012)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_32)) > 0) {
                        a.ignoreTargetDEF += var13_32.getEffect(var14_117).getIgnoreMob();
                    }
                    if ((var13_33 = SkillFactory.getSkill(1120013)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_33)) <= 0) break;
                    var15_121 = var13_33.getEffect(var14_117);
                    v134 = var2_2;
                    v135 = a;
                    v135.f += var15_121.getAttackX();
                    v135.F.put(1100002, Integer.valueOf(var15_121.getDamage()));
                    break block282;
                }
                case 120: 
                case 121: 
                case 122: {
                    var13_34 = SkillFactory.getSkill(1200009);
                    if (var13_34 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_34)) > 0) {
                        var15_121 = var13_34.getEffect(var14_117);
                        a.F.put(1001004, var15_121.getX());
                        a.F.put(1001005, var15_121.getY());
                        v136 = a;
                        v136.w += var15_121.getStrX();
                        v136.G += var15_121.getDexX();
                    }
                    if ((var13_35 = SkillFactory.getSkill(1220006)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_35)) <= 0) break;
                    v134 = var2_2;
                    a.ASR += var13_35.getEffect(var14_117).getASRRate();
                    break block282;
                }
                case 130: 
                case 131: 
                case 132: {
                    var13_36 = SkillFactory.getSkill(1300009);
                    if (var13_36 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_36)) > 0) {
                        var15_121 = var13_36.getEffect(var14_117);
                        a.F.put(1001004, var15_121.getX());
                        a.F.put(1001005, var15_121.getY());
                        v137 = a;
                        v137.w += var15_121.getStrX();
                        v137.G += var15_121.getDexX();
                    }
                    if ((var13_37 = SkillFactory.getSkill(1310009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_37)) > 0) {
                        var15_121 = var13_37.getEffect(var14_117);
                        v138 = a;
                        v138.P = (byte)(v138.P + var15_121.getCr());
                        v138.o = (short)(v138.o + var15_121.getCriticalMin());
                        v138.hpRecoverProp += var15_121.getProp();
                        v138.hpRecoverPercent += var15_121.getX();
                    }
                    if ((var13_38 = SkillFactory.getSkill(1320006)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_38)) <= 0) break;
                    var15_121 = var13_38.getEffect(var14_117);
                    v134 = var2_2;
                    v139 = a;
                    v139.dam_r *= ((double)var15_121.getDamage() + 100.0) / 100.0;
                    v139.bossdam_r *= ((double)var15_121.getDamage() + 100.0) / 100.0;
                    break block282;
                }
                case 210: 
                case 211: 
                case 212: {
                    var13_39 = SkillFactory.getSkill(2100007);
                    if (var13_39 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_39)) > 0) {
                        a.c += var13_39.getEffect(var14_117).getIntX();
                    }
                    if ((var13_40 = SkillFactory.getSkill(0x203230)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_40)) > 0) {
                        var15_121 = var13_40.getEffect(var14_117);
                        v140 = a;
                        v140.dotTime += var15_121.getX();
                        v140.dot += var15_121.getZ();
                    }
                    if ((var13_41 = SkillFactory.getSkill(2110001)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_41)) > 0) {
                        var15_121 = var13_41.getEffect(var14_117);
                        v141 = a;
                        v141.mpconPercent += var15_121.getX() - 100;
                        v141.dam_r *= (double)var15_121.getY() / 100.0;
                        v141.bossdam_r *= (double)var15_121.getY() / 100.0;
                    }
                    if ((var13_42 = SkillFactory.getSkill(2121003)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_42)) > 0) {
                        var15_121 = var13_42.getEffect(var14_117);
                        a.F.put(2111003, var15_121.getX());
                    }
                    if ((var13_43 = SkillFactory.getSkill(2120009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_43)) > 0) {
                        var15_121 = var13_43.getEffect(var14_117);
                        v142 = a;
                        v142.A += var15_121.getMagicX();
                        v142.BuffUP_Skill += var15_121.getX();
                    }
                    if ((var13_44 = SkillFactory.getSkill(2121009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_44)) > 0) {
                        a.A += var13_44.getEffect(var14_117).getMagicX();
                    }
                    if ((var13_45 = SkillFactory.getSkill(2120010)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_45)) <= 0) break;
                    var15_121 = var13_45.getEffect(var14_117);
                    v134 = var2_2;
                    v143 = a;
                    v143.dam_r *= ((double)(var15_121.getX() * var15_121.getY()) + 100.0) / 100.0;
                    v143.bossdam_r *= ((double)(var15_121.getX() * var15_121.getY()) + 100.0) / 100.0;
                    v143.ignoreTargetDEF += var15_121.getIgnoreMob();
                    break block282;
                }
                case 220: 
                case 221: 
                case 222: {
                    var13_46 = SkillFactory.getSkill(2200007);
                    if (var13_46 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_46)) > 0) {
                        a.c += var13_46.getEffect(var14_117).getIntX();
                    }
                    if ((var13_47 = SkillFactory.getSkill(2210000)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_47)) > 0) {
                        a.dot += var13_47.getEffect(var14_117).getZ();
                    }
                    if ((var13_48 = SkillFactory.getSkill(2210001)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_48)) > 0) {
                        var15_121 = var13_48.getEffect(var14_117);
                        v144 = a;
                        v144.mpconPercent += var15_121.getX() - 100;
                        v144.dam_r *= (double)var15_121.getY() / 100.0;
                        v144.bossdam_r *= (double)var15_121.getY() / 100.0;
                    }
                    if ((var13_49 = SkillFactory.getSkill(2220009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_49)) > 0) {
                        var15_121 = var13_49.getEffect(var14_117);
                        v145 = a;
                        v145.A += var15_121.getMagicX();
                        v145.BuffUP_Skill += var15_121.getX();
                    }
                    if ((var13_50 = SkillFactory.getSkill(2221009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_50)) > 0) {
                        a.A += var13_50.getEffect(var14_117).getMagicX();
                    }
                    if ((var13_51 = SkillFactory.getSkill(2220010)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_51)) <= 0) break;
                    var15_121 = var13_51.getEffect(var14_117);
                    v134 = var2_2;
                    v146 = a;
                    v146.dam_r *= ((double)(var15_121.getX() * var15_121.getY()) + 100.0) / 100.0;
                    v146.bossdam_r *= ((double)(var15_121.getX() * var15_121.getY()) + 100.0) / 100.0;
                    v146.ignoreTargetDEF += var15_121.getIgnoreMob();
                    break block282;
                }
                case 230: 
                case 231: 
                case 232: {
                    var13_52 = SkillFactory.getSkill(2300007);
                    if (var13_52 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_52)) > 0) {
                        a.c += var13_52.getEffect(var14_117).getIntX();
                    }
                    if ((var13_53 = SkillFactory.getSkill(2310008)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_53)) > 0) {
                        a.P = (byte)(a.P + var13_53.getEffect(var14_117).getCr());
                    }
                    if ((var13_54 = SkillFactory.getSkill(2320010)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_54)) > 0) {
                        var15_121 = var13_54.getEffect(var14_117);
                        v147 = a;
                        v147.A += var15_121.getMagicX();
                        v147.BuffUP_Skill += var15_121.getX();
                    }
                    if ((var13_55 = SkillFactory.getSkill(2321010)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_55)) > 0) {
                        a.A += var13_55.getEffect(var14_117).getMagicX();
                    }
                    if ((var13_56 = SkillFactory.getSkill(2320005)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_56)) > 0) {
                        a.ASR += var13_56.getEffect(var14_117).getASRRate();
                    }
                    if ((var13_57 = SkillFactory.getSkill(2320011)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_57)) <= 0) break;
                    var15_121 = var13_57.getEffect(var14_117);
                    v134 = var2_2;
                    v148 = a;
                    v148.dam_r *= ((double)(var15_121.getX() * var15_121.getY()) + 100.0) / 100.0;
                    v148.bossdam_r *= ((double)(var15_121.getX() * var15_121.getY()) + 100.0) / 100.0;
                    v148.ignoreTargetDEF += var15_121.getIgnoreMob();
                    break block282;
                }
                case 300: 
                case 310: 
                case 311: 
                case 312: {
                    a.defRange = 200;
                    var13_58 = SkillFactory.getSkill(3000002);
                    var14_117 = var2_2.getTotalSkillLevel(var13_58);
                    if (var14_117 > 0) {
                        a.defRange += var13_58.getEffect(var14_117).getRange();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_59 = SkillFactory.getSkill(3100006))) > 0) {
                        var15_121 = var13_59.getEffect(var14_117);
                        a.F.put(3001004, var15_121.getX());
                        a.F.put(3001005, var15_121.getY());
                        v149 = a;
                        v149.w += var15_121.getStrX();
                        v149.G += var15_121.getDexX();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_60 = SkillFactory.getSkill(3110007))) > 0) {
                        a.dodgeChance += var13_60.getEffect(var14_117).getER();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_61 = SkillFactory.getSkill(3120005))) <= 0) break;
                    var15_121 = var13_61.getEffect(var14_117);
                    v134 = var2_2;
                    v150 = a;
                    v150.trueMastery += var15_121.getMastery();
                    v150.o = (short)(v150.o + var15_121.getCriticalMin());
                    break block282;
                }
                case 320: 
                case 321: 
                case 322: {
                    a.defRange = 200;
                    var13_62 = SkillFactory.getSkill(3000002);
                    if (var13_62 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_62)) > 0) {
                        a.defRange += var13_62.getEffect(var14_117).getRange();
                    }
                    if ((var13_63 = SkillFactory.getSkill(3200006)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_63)) > 0) {
                        var15_121 = var13_63.getEffect(var14_117);
                        a.F.put(3001004, var15_121.getX());
                        a.F.put(3001005, var15_121.getY());
                        v151 = a;
                        v151.w += var15_121.getStrX();
                        v151.G += var15_121.getDexX();
                    }
                    if ((var13_64 = SkillFactory.getSkill(3220010)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_64)) > 0) {
                        a.F.put(3211006, var13_64.getEffect(var14_117).getDamage() - 150);
                    }
                    if ((var13_65 = SkillFactory.getSkill(3210007)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_65)) <= 0) break;
                    v134 = var2_2;
                    a.dodgeChance += var13_65.getEffect(var14_117).getER();
                    break block282;
                }
                case 411: 
                case 412: {
                    var13_66 = SkillFactory.getSkill(4110000);
                    if (var13_66 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_66)) > 0) {
                        var15_121 = var13_66.getEffect(var14_117);
                        v152 = a;
                        v152.RecoveryUP += var15_121.getX() - 100;
                        v152.BuffUP += var15_121.getY() - 100;
                    }
                    if ((var13_67 = SkillFactory.getSkill(4110014)) != null && var13_67 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_67)) > 0) {
                        var15_121 = var13_67.getEffect(var14_117);
                        v153 = a;
                        v153.RecoveryUP += var15_121.getX() - 100;
                        v153.BuffUP += var15_121.getY() - 100;
                    }
                    if ((var13_68 = SkillFactory.getSkill(4120010)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_68)) <= 0) break;
                    var15_121 = var13_68.getEffect(var14_117);
                    v134 = var2_2;
                    a.F.put(4001344, Integer.valueOf(var15_121.getDAMRate()));
                    a.F.put(4101005, Integer.valueOf(var15_121.getDAMRate()));
                    a.F.put(4111004, Integer.valueOf(var15_121.getDAMRate()));
                    a.F.put(4111005, Integer.valueOf(var15_121.getDAMRate()));
                    break block282;
                }
                case 420: 
                case 421: 
                case 422: {
                    var13_69 = SkillFactory.getSkill(4221007);
                    if (var13_69 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_69)) > 0) {
                        var15_121 = var13_69.getEffect(var14_117);
                        a.F.put(4201005, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4201004, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4211002, Integer.valueOf(var15_121.getDAMRate()));
                    }
                    if ((var13_70 = SkillFactory.getSkill(4220009)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_70)) <= 0) break;
                    var15_121 = var13_70.getEffect(var14_117);
                    v134 = var2_2;
                    v154 = a;
                    v154.mesoBuff *= ((double)var15_121.getMesoRate() + 100.0) / 100.0;
                    v154.pickRate += var15_121.getU();
                    v154.mesoGuard -= (double)var15_121.getV();
                    v154.mesoGuardMeso -= (double)var15_121.getW();
                    v154.F.put(4211006, var15_121.getX());
                    break block282;
                }
                case 433: 
                case 434: {
                    var13_71 = SkillFactory.getSkill(4330007);
                    if (var13_71 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_71)) > 0) {
                        var15_121 = var13_71.getEffect(var14_117);
                        v155 = a;
                        v155.hpRecoverProp += var15_121.getProp();
                        v155.hpRecoverPercent += var15_121.getX();
                    }
                    if ((var13_72 = SkillFactory.getSkill(4341002)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_72)) > 0) {
                        var15_121 = var13_72.getEffect(var14_117);
                        a.F.put(4311002, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4311003, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4321000, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4321001, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4331000, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4331004, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(4331005, Integer.valueOf(var15_121.getDAMRate()));
                    }
                    if ((var13_73 = SkillFactory.getSkill(4341006)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_73)) <= 0) break;
                    v134 = var2_2;
                    a.dodgeChance += var13_73.getEffect(var14_117).getER();
                    break block282;
                }
                case 510: 
                case 511: 
                case 512: {
                    var13_74 = SkillFactory.getSkill(5110008);
                    var14_117 = var2_2.getTotalSkillLevel(var13_74);
                    if (var14_117 > 0) {
                        var15_121 = var13_74.getEffect(var14_117);
                        a.F.put(5101002, var15_121.getX());
                        a.F.put(5101003, var15_121.getY());
                        a.F.put(5101004, var15_121.getZ());
                    }
                    if ((var13_75 = SkillFactory.getSkill(5100010)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_75)) <= 0) break;
                    var15_121 = var13_75.getEffect(var14_117);
                    v134 = var2_2;
                    v156 = a;
                    v156.w += var15_121.getStrX();
                    v156.G += var15_121.getDexX();
                    break block282;
                }
                case 520: 
                case 521: 
                case 522: {
                    a.defRange = 200;
                    var13_76 = SkillFactory.getSkill(5220001);
                    if (var13_76 != null && (var14_117 = var2_2.getTotalSkillLevel(var13_76)) > 0) {
                        var15_121 = var13_76.getEffect(var14_117);
                        a.F.put(5211004, Integer.valueOf(var15_121.getDamage()));
                        a.F.put(5211005, Integer.valueOf(var15_121.getDamage()));
                    }
                    if ((var13_77 = SkillFactory.getSkill(5200009)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_77)) > 0) {
                        var15_121 = var13_77.getEffect(var14_117);
                        v157 = a;
                        v157.w += var15_121.getStrX();
                        v157.G += var15_121.getDexX();
                    }
                    if ((var13_78 = SkillFactory.getSkill(5210012)) != null && (var14_117 = var2_2.getTotalSkillLevel(var13_78)) > 0) {
                        var15_121 = var13_78.getEffect(var14_117);
                        v158 = a;
                        v158.percent_wdef += var15_121.getWDEFRate();
                        v158.percent_mdef += var15_121.getWDEFRate();
                    }
                    if ((var13_79 = SkillFactory.getSkill(5110008)) == null || (var14_117 = var2_2.getTotalSkillLevel(var13_79)) <= 0) break;
                    var15_121 = var13_79.getEffect(var14_117);
                    v134 = var2_2;
                    a.F.put(5101002, var15_121.getX());
                    a.F.put(5101003, var15_121.getY());
                    a.F.put(5101004, var15_121.getZ());
                    break block282;
                }
                case 1211: 
                case 1212: {
                    var13_80 = SkillFactory.getSkill(12110001);
                    var14_117 = var2_2.getTotalSkillLevel(var13_80);
                    if (var14_117 <= 0) break;
                    var15_121 = var13_80.getEffect(var14_117);
                    v134 = var2_2;
                    v159 = a;
                    v159.mpconPercent += var15_121.getX() - 100;
                    v159.dam_r *= (double)var15_121.getY() / 100.0;
                    v159.bossdam_r *= (double)var15_121.getY() / 100.0;
                    break block282;
                }
                case 1300: 
                case 1310: 
                case 1311: 
                case 1312: {
                    a.defRange = 200;
                    var13_81 = SkillFactory.getSkill(13000001);
                    var14_117 = var2_2.getTotalSkillLevel(var13_81);
                    if (var14_117 > 0) {
                        a.defRange += var13_81.getEffect(var14_117).getRange();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_82 = SkillFactory.getSkill(13110008))) > 0) {
                        a.dodgeChance += var13_82.getEffect(var14_117).getER();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_83 = SkillFactory.getSkill(13110003))) <= 0) break;
                    var15_121 = var13_83.getEffect(var14_117);
                    v134 = var2_2;
                    v160 = a;
                    v160.trueMastery += var15_121.getMastery();
                    v160.o = (short)(v160.o + var15_121.getCriticalMin());
                    break block282;
                }
                case 1400: 
                case 1410: 
                case 1411: 
                case 1412: {
                    a.defRange = 200;
                    var13_84 = SkillFactory.getSkill(14110003);
                    var14_117 = var2_2.getTotalSkillLevel(var13_84);
                    if (var14_117 > 0) {
                        var15_121 = var13_84.getEffect(var14_117);
                        v161 = a;
                        v161.RecoveryUP += var15_121.getX() - 100;
                        v161.BuffUP += var15_121.getY() - 100;
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_85 = SkillFactory.getSkill(14000001))) <= 0) break;
                    v134 = var2_2;
                    a.defRange += var13_85.getEffect(var14_117).getRange();
                    break block282;
                }
                case 2100: 
                case 2110: 
                case 2111: 
                case 2112: {
                    var13_86 = SkillFactory.getSkill(20000194);
                    var14_117 = var2_2.getTotalSkillLevel(var13_86);
                    if (var14_117 > 0) {
                        var15_121 = var13_86.getEffect(var14_117);
                        v162 = a;
                        v162.A += var15_121.getAttackX();
                        v162.wdef += var15_121.getPddX();
                        v162.speed += var15_121.getPassiveSpeed();
                        v162.P = (byte)(v162.P + var15_121.getCr());
                        v162.bossdam_r += (double)var15_121.getBossDamage();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_87 = SkillFactory.getSkill(21100008))) > 0) {
                        var15_121 = var13_87.getEffect(var14_117);
                        v163 = a;
                        v163.w += var15_121.getStrX();
                        v163.G += var15_121.getDexX();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_88 = SkillFactory.getSkill(21120001))) > 0) {
                        var15_121 = var13_88.getEffect(var14_117);
                        a.f += var15_121.getX();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_89 = SkillFactory.getSkill(21101006))) > 0) {
                        var15_121 = var13_89.getEffect(var14_117);
                        v164 = a;
                        v164.dam_r *= ((double)var15_121.getDAMRate() + 100.0) / 100.0;
                        v164.bossdam_r *= ((double)var15_121.getDAMRate() + 100.0) / 100.0;
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_90 = SkillFactory.getSkill(21110002))) > 0) {
                        a.F.put(21000004, var13_90.getEffect(var14_117).getW());
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_91 = SkillFactory.getSkill(21111010))) > 0) {
                        a.ignoreTargetDEF += var13_91.getEffect(var14_117).getIgnoreMob();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_92 = SkillFactory.getSkill(21120002))) > 0) {
                        a.F.put(21100007, var13_92.getEffect(var14_117).getZ());
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_93 = SkillFactory.getSkill(21120011))) > 0) {
                        var15_121 = var13_93.getEffect(var14_117);
                        a.F.put(21100002, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(21110003, Integer.valueOf(var15_121.getDAMRate()));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_94 = SkillFactory.getSkill(21120012))) > 0) {
                        var15_121 = var13_94.getEffect(var14_117);
                        v165 = a;
                        v165.f += var15_121.getAttackX();
                        v165.F.put(21100010, Integer.valueOf(var15_121.getDamage()));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_95 = SkillFactory.getSkill(21120004))) > 0) {
                        a.percent_wdef += var13_95.getEffect(var14_117).getT();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_96 = SkillFactory.getSkill(21120044))) > 0) {
                        var15_121 = var13_96.getEffect(var14_117);
                        a.addCoolTimeReduce(21111009, var15_121.getCooltimeReduceR());
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_97 = SkillFactory.getSkill(21120047))) > 0) {
                        var15_121 = var13_97.getEffect(var14_117);
                        a.addAttackCount(21120005, var15_121.getAttackCount());
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_98 = SkillFactory.getSkill(21120049))) <= 0) break;
                    var15_121 = var13_98.getEffect(var14_117);
                    v134 = var2_2;
                    a.addAttackCount(21120006, var15_121.getAttackCount());
                    break block282;
                }
                case 2001: 
                case 2300: 
                case 2310: 
                case 2311: 
                case 2312: {
                    var13_99 = SkillFactory.getSkill(23111005);
                    var14_117 = var2_2.getSkillLevel(var13_99);
                    if (var14_117 > 0) {
                        v166 = a;
                        v166.TER += var13_99.getEffect(var14_117).getTeRRate();
                        v166.ASR += var13_99.getEffect(var14_117).getASRRate();
                    }
                    a.defRange = 200;
                    var13_100 = SkillFactory.getSkill(20021110);
                    var14_117 = var2_2.getSkillLevel(var13_100);
                    if (var14_117 > 0) {
                        a.expBuff *= ((double)var13_100.getEffect(var14_117).getEXPRate() + 100.0) / 100.0;
                    }
                    if ((var14_117 = var2_2.getSkillLevel(var13_101 = SkillFactory.getSkill(20020112))) > 0) {
                        var2_2.getTrait(MapleTrait.MapleTraitType.\u9b45\u529b).addLocalExp(GameConstants.getTraitExpNeededForLevel(30));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_102 = SkillFactory.getSkill(23000001))) > 0) {
                        a.dodgeChance += var13_102.getEffect(var14_117).getER();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_103 = SkillFactory.getSkill(23100008))) > 0) {
                        var15_121 = var13_103.getEffect(var14_117);
                        v167 = a;
                        v167.w += var15_121.getStrX();
                        v167.G += var15_121.getDexX();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_104 = SkillFactory.getSkill(23110004))) > 0) {
                        a.dodgeChance += var13_104.getEffect(var14_117).getProp();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_105 = SkillFactory.getSkill(23110004))) > 0) {
                        a.F.put(23101001, Integer.valueOf(var13_105.getEffect(var14_117).getDAMRate()));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_106 = SkillFactory.getSkill(23121004))) > 0) {
                        a.dodgeChance += var13_106.getEffect(var14_117).getProp();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_107 = SkillFactory.getSkill(23120009))) > 0) {
                        a.f += var13_107.getEffect(var14_117).getX();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_108 = SkillFactory.getSkill(23120010))) > 0) {
                        a.ignoreTargetDEF += var13_108.getEffect(var14_117).getX();
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_109 = SkillFactory.getSkill(23120011))) > 0) {
                        a.F.put(23101001, Integer.valueOf(var13_109.getEffect(var14_117).getDAMRate()));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_110 = SkillFactory.getSkill(23120012))) <= 0) break;
                    v134 = var2_2;
                    a.f += var13_110.getEffect(var14_117).getAttackX();
                    break block282;
                }
                case 3511: 
                case 3512: {
                    var13_111 = SkillFactory.getSkill(35110014);
                    var14_117 = var2_2.getTotalSkillLevel(var13_111);
                    if (var14_117 > 0) {
                        var15_121 = var13_111.getEffect(var14_117);
                        a.F.put(35001003, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(35101003, Integer.valueOf(var15_121.getDAMRate()));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_112 = SkillFactory.getSkill(35121006))) > 0) {
                        var15_121 = var13_112.getEffect(var14_117);
                        a.F.put(35111001, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(35111009, Integer.valueOf(var15_121.getDAMRate()));
                        a.F.put(35111010, Integer.valueOf(var15_121.getDAMRate()));
                    }
                    if ((var14_117 = var2_2.getTotalSkillLevel(var13_113 = SkillFactory.getSkill(35120001))) <= 0) break;
                    var15_121 = var13_113.getEffect(var14_117);
                    a.F.put(35111005, var15_121.getX());
                    a.F.put(35111011, var15_121.getX());
                    a.F.put(35121009, var15_121.getX());
                    a.F.put(35121010, var15_121.getX());
                    a.F.put(35121011, var15_121.getX());
                    a.BuffUP_Summon += var15_121.getY();
                }
            }
            v134 = var2_2;
        }
        if (GameConstants.isResist(v134.getJob()) && (var14_117 = var2_2.getTotalSkillLevel(var13_115 = SkillFactory.getSkill(30000002))) > 0) {
            a.RecoveryUP += var13_115.getEffect(var14_117).getX() - 100;
        }
        v168 = a;
        v169 = var2_2;
        v170 = a;
        v170.ALLATORIxDEMO(var2_2, var7_10, var8_11);
        v170.E(var2_2);
        v168.D(v169);
        v168.recalcPVPRank(v169);
        if (a) {
            a.relocHeal();
            var2_2.silentEnforceMaxHpMp();
        } else {
            var2_2.enforceMaxHpMp();
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            v171 = a;
            v172 = v171;
            a.J = v171.calculateMaxBaseDamage(v171.A, a.f);
        } else {
            v173 = a;
            v172 = v173;
            a.J = v173.calculateMaxBaseDamage(0, a.f);
        }
        v172.trueMastery = Math.min(100, a.trueMastery);
        a.o = (short)Math.min(a.o, a.Z);
        if (var5_8 != 0 && var5_8 != a.l) {
            var2_2.updatePartyMemberHP();
        }
        v174 = a;
        v174.EquipExp = SpecialEquipFactory.getInstance().getTotalEquipExp(var2_2);
        v174.EquipDrop = SpecialEquipFactory.getInstance().getTotalEquipDrop(var2_2);
        v174.EquipMeso = SpecialEquipFactory.getInstance().getTotalEquipMeso(var2_2);
        v174.EquipDamage = SpecialEquipFactory.getInstance().getTotalEquipDamage(var2_2);
        a.isRecalc = false;
    }

    public final /* synthetic */ short passive_sharpeye_min_percent() {
        PlayerStats a2;
        return a2.o;
    }

    public /* synthetic */ void addTargetPlus(int a2, int a3) {
        PlayerStats a4;
        if (a2 < 0 || a3 <= 0) {
            return;
        }
        if (a4.g.containsKey(a2)) {
            int n2 = a4.g.get(a2);
            a4.g.put(a2, n2 + a3);
            return;
        }
        a4.g.put(a2, a3);
    }
}

