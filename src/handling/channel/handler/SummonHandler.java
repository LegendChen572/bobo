/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.PlayerStats;
import client.SkillFactory;
import client.SummonSkillEntry;
import client.anticheat.CheatingOffense;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.skills.SummonSkillAnimation;
import handling.channel.handler.MovementParse;
import handling.channel.handler.PlayersHandler;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.SummonMovementType;
import handling.world.family.MapleFamily;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.Randomizer;
import server.Timer;
import server.life.MapleMonster;
import server.life.MobSkill;
import server.life.SummonAttackEntry;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.AbstractMapleMapObject;
import server.maps.AnimatedMapleMapObject;
import server.maps.MapleDragon;
import server.maps.MapleMap;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleSummon;
import server.movement.LifeMovementFragment;
import tools.AttackPair;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.MobPacket;

public class SummonHandler {
    private static /* synthetic */ List<Integer> ALLATORIxDEMO;

    public static final /* synthetic */ void MoveDragon(LittleEndianAccessor a2, MapleCharacter a3) {
        a2.skip(GameSetConstants.MAPLE_VERSION >= 134 ? 8 : 4);
        final List<LifeMovementFragment> list = MovementParse.parseMovement(a2, a3.getClient(), 5);
        if (a3 != null && a3.getDragon() != null && list.size() > 0) {
            int n2;
            WeakReference<MapleCharacter>[] arrweakReference = a3.getDragon().getPosition();
            MapleCharacter mapleCharacter = a3;
            MovementParse.updatePosition(list, mapleCharacter.getDragon(), 0);
            if (!mapleCharacter.isHidden()) {
                MapleCharacter mapleCharacter2 = a3;
                a3.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.moveDragon(a3.getDragon(), arrweakReference, list), mapleCharacter2.getTruePosition());
            }
            arrweakReference = a3.getClones();
            int n3 = n2 = 0;
            while (n3 < arrweakReference.length) {
                if (arrweakReference[n2].get() != null) {
                    final MapleMap mapleMap = a3.getMap();
                    final MapleCharacter mapleCharacter3 = (MapleCharacter)arrweakReference[n2].get();
                    Timer.CloneTimer.getInstance().schedule(new Runnable(){
                        {
                            1 a2;
                        }

                        @Override
                        public /* synthetic */ void run() {
                            try {
                                1 a2;
                                if (a2.mapleCharacter3.getMap() == a2.mapleMap && a2.mapleCharacter3.getDragon() != null) {
                                    1 v0 = a2;
                                    Point point = v0.mapleCharacter3.getDragon().getPosition();
                                    1 v1 = a2;
                                    MovementParse.updatePosition(v0.list, v1.mapleCharacter3.getDragon(), 0);
                                    if (!v1.mapleCharacter3.isHidden()) {
                                        1 v2 = a2;
                                        v2.mapleMap.broadcastMessage(v2.mapleCharacter3, MaplePacketCreator.moveDragon(a2.mapleCharacter3.getDragon(), point, a2.list), a2.mapleCharacter3.getTruePosition());
                                        return;
                                    }
                                }
                            }
                            catch (Exception exception) {
                                // empty catch block
                            }
                        }
                    }, 500 * n2 + 500);
                }
                n3 = ++n2;
            }
        }
    }

    public /* synthetic */ SummonHandler() {
        SummonHandler a2;
    }

    public static final /* synthetic */ void MoveSummon(LittleEndianAccessor a2, MapleCharacter a3) {
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            SummonHandler.MoveSummon135(a2, a3);
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        Point point = new Point(a2.readShort(), a2.readShort());
        List<LifeMovementFragment> list = MovementParse.parseMovement(littleEndianAccessor, a3.getClient(), 4);
        if (a3 == null) {
            return;
        }
        for (MapleSummon mapleSummon : a3.getSummons()) {
            if (mapleSummon.getObjectId() != n2 || mapleSummon.getMovementType() == SummonMovementType.STATIONARY) continue;
            Point point2 = mapleSummon.getPosition();
            MapleSummon mapleSummon2 = mapleSummon;
            MovementParse.updatePosition(list, mapleSummon2, 0);
            if (mapleSummon2.isChangedMap()) break;
            MapleCharacter mapleCharacter = a3;
            a3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.moveSummon(mapleCharacter.getId(), n2, point, list), mapleSummon.getPosition());
            return;
        }
    }

    public static final /* synthetic */ void DamageSummon(LittleEndianAccessor a2, MapleCharacter a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = littleEndianAccessor.readByte();
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        Iterator<MapleSummon> iterator = a3.getSummons().iterator();
        if (n2 > 0) {
            while (iterator.hasNext()) {
                MapleSummon mapleSummon = iterator.next();
                if (!mapleSummon.isPuppet() || mapleSummon.getOwnerId() != a3.getId()) continue;
                MapleSummon mapleSummon2 = mapleSummon;
                mapleSummon2.addHP((short)(-n2));
                if (mapleSummon2.getHP() <= 0) {
                    mapleSummon.setRemoveTime(System.currentTimeMillis());
                    a3.cancelEffectFromBuffStat(MapleBuffStat.PUPPET);
                }
                MapleCharacter mapleCharacter = a3;
                a3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.damageSummon(mapleCharacter.getId(), mapleSummon.getSkill(), n2, by, n3), mapleSummon.getPosition());
                return;
            }
        }
    }

    public static final /* synthetic */ void RemoveSummon(LittleEndianAccessor a2, MapleClient a3) {
        MapleMapObject mapleMapObject = a3.getPlayer().getMap().getMapObject(a2.readInt(), MapleMapObjectType.SUMMON);
        if (mapleMapObject == null || !(mapleMapObject instanceof MapleSummon)) {
            return;
        }
        if (((MapleSummon)(mapleMapObject = (MapleSummon)mapleMapObject)).getOwnerId() != a3.getPlayer().getId() || ((MapleSummon)mapleMapObject).getSkillLevel() <= 0) {
            a3.getPlayer().dropMessage(5, MonsterPetSystem.ALLATORIxDEMO("\u001d!*<*}"));
            return;
        }
        if (((MapleSummon)mapleMapObject).getSkill() == 35111002 || ((MapleSummon)mapleMapObject).getSkill() == 35121010) {
            return;
        }
        MapleClient mapleClient = a3;
        mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.removeSummon((MapleSummon)mapleMapObject, true));
        mapleClient.getPlayer().getMap().removeMapObject(mapleMapObject);
        mapleClient.getPlayer().removeVisibleMapObject(mapleMapObject);
        mapleClient.getPlayer().removeSummon((MapleSummon)mapleMapObject);
        if (((MapleSummon)mapleMapObject).getSkill() != 35121011) {
            a3.getPlayer().cancelEffectFromBuffStat(MapleBuffStat.SUMMON);
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new LinkedList<Integer>();
    }

    public static final /* synthetic */ void SummonPVP(LittleEndianAccessor a2, MapleClient a3) {
        boolean bl;
        Object object;
        boolean bl2;
        boolean bl3;
        int n2;
        int n3;
        MapleMapObject mapleMapObject;
        block28: {
            Object object2;
            Serializable serializable;
            Object object3;
            if ((a3 = ((MapleClient)a3).getPlayer()) == null || ((MapleCharacter)a3).isHidden() || !((MapleCharacter)a3).isAlive() || ((MapleCharacter)a3).hasBlockedInventory() || ((MapleCharacter)a3).getMap() == null || !((MapleCharacter)a3).inPVP() || !((MapleCharacter)a3).getEventInstance().getProperty(MapleFamily.ALLATORIxDEMO("3\u001a!\u001c4\u000b$")).equals("1")) {
                return;
            }
            mapleMapObject = ((MapleCharacter)a3).getMap().getMapObject(a2.readInt(), MapleMapObjectType.SUMMON);
            if (mapleMapObject == null || !(mapleMapObject instanceof MapleSummon)) {
                ((MapleCharacter)a3).dropMessage(5, MonsterPetSystem.ALLATORIxDEMO("\u53b4\u55c9\u7320\u5da1\u7dcb\u6ddb\u5969}"));
                return;
            }
            int n4 = -1;
            if (a2.available() == 27L) {
                LittleEndianAccessor littleEndianAccessor = a2;
                littleEndianAccessor.skip(23);
                n4 = littleEndianAccessor.readInt();
            }
            if (((MapleSummon)(mapleMapObject = (MapleSummon)mapleMapObject)).getOwnerId() != ((MapleCharacter)a3).getId() || ((MapleSummon)mapleMapObject).getSkillLevel() <= 0) {
                ((MapleCharacter)a3).dropMessage(5, MapleFamily.ALLATORIxDEMO("\u936f\u8acan"));
                return;
            }
            ISkill iSkill = SkillFactory.getSkill(((MapleSummon)mapleMapObject).getSkill());
            MapleStatEffect mapleStatEffect = iSkill.getEffect(((MapleSummon)mapleMapObject).getSkillLevel());
            Object object4 = a3;
            int n5 = Integer.parseInt(((MapleCharacter)object4).getEventInstance().getProperty(MonsterPetSystem.ALLATORIxDEMO("?.?")));
            int n6 = Integer.parseInt(((MapleCharacter)object4).getEventInstance().getProperty(MapleFamily.ALLATORIxDEMO("\u001a9\u001e%")));
            n3 = Integer.parseInt(((MapleCharacter)object4).getEventInstance().getProperty(String.valueOf(((MapleCharacter)a3).getId())));
            n2 = 0;
            boolean bl4 = iSkill.isMagic();
            bl3 = false;
            bl2 = false;
            double d2 = n5 == 3 ? (double)((MapleCharacter)a3).getStat().getCurrentMaxBasePVPDamageL() : (double)((MapleCharacter)a3).getStat().getCurrentMaxBasePVPDamage();
            d2 *= (double)(mapleStatEffect.getDamage() + ((MapleCharacter)a3).getStat().getDamageIncrease(((MapleSummon)mapleMapObject).getSkill())) / 100.0;
            n5 = 1;
            int n7 = 1;
            int n8 = a3.getStat().ignoreTargetDEF;
            object = SkillFactory.getSummonData(((MapleSummon)mapleMapObject).getSkill());
            if (((MapleSummon)mapleMapObject).getSkill() / 1000000 != 35 && ((MapleSummon)mapleMapObject).getSkill() != 33101008 && object == null) {
                ((MapleCharacter)a3).dropMessage(5, MonsterPetSystem.ALLATORIxDEMO("\u0016*!7!x:6s(!70= +:64x2,'903}"));
                return;
            }
            if (object != null) {
                if (((SummonSkillEntry)object).delay > 0) {
                    Object object5;
                    if (n4 != -1) {
                        Object object6 = a3;
                        object5 = object6;
                        ((MapleSummon)mapleMapObject).CheckSummonAttackFrequency((MapleCharacter)object6, n4);
                        ((MapleCharacter)object6).updateTick(n4);
                    } else {
                        ((MapleSummon)mapleMapObject).CheckPVPSummonAttackFrequency((MapleCharacter)a3);
                        object5 = a3;
                    }
                    ((MapleCharacter)object5).getCheatTracker().checkSummonAttack();
                }
                SummonSkillEntry summonSkillEntry = object;
                n5 = summonSkillEntry.mobCount;
                n7 = summonSkillEntry.attackCount;
                object3 = summonSkillEntry.lt;
                serializable = summonSkillEntry.rb;
                object2 = a3;
            } else {
                object3 = new Point(-100, -100);
                serializable = new Point(100, 100);
                object2 = a3;
            }
            Cloneable cloneable = MapleStatEffect.calculateBoundingBox(((AbstractMapleMapObject)object2).getTruePosition(), ((AbstractAnimatedMapleMapObject)a3).isFacingLeft(), (Point)object3, (Point)serializable, 0);
            object = new ArrayList();
            d2 *= a3.getStat().dam_r / 100.0;
            object3 = ((MapleCharacter)a3).getMap().getCharactersIntersect((Rectangle)cloneable).iterator();
            while (object3.hasNext()) {
                int n9;
                serializable = (MapleCharacter)((MapleMapObject)object3.next());
                if (((MapleCharacter)serializable).getId() == ((MapleCharacter)a3).getId() || !((MapleCharacter)serializable).isAlive() || ((MapleCharacter)serializable).isHidden() || n6 != 0 && ((MapleCharacter)serializable).getTeam() == ((MapleCharacter)a3).getTeam()) continue;
                Serializable serializable2 = serializable;
                double d3 = d2 / Math.max(0.0, (double)(bl4 ? serializable2.getStat().mdef : serializable2.getStat().wdef) * Math.max(1.0, 100.0 - (double)n8) / 100.0 * (n6 == 3 ? 0.1 : 0.25));
                if (((MapleCharacter)serializable).getBuffedValue(MapleBuffStat.INVINCIBILITY) != null || PlayersHandler.inArea((MapleCharacter)serializable)) {
                    d3 = 0.0;
                }
                double d4 = d3;
                d3 = d4 + d4 * (double)((MapleCharacter)a3).getDamageIncrease(((MapleCharacter)serializable).getId()) / 100.0;
                d3 *= serializable.getStat().mesoGuard / 100.0;
                Serializable serializable3 = serializable;
                d3 = (Double)serializable3.modifyDamageTaken((double)d3, (MapleMapObject)serializable3, (int)iSkill.getId()).left;
                double d5 = d3 * (double)a3.getStat().trueMastery / 100.0;
                cloneable = new ArrayList(n7);
                int n10 = 0;
                int n11 = 0;
                int n12 = n9 = 0;
                while (n12 < n7) {
                    int n13 = 0;
                    double d6 = (double)Randomizer.nextInt((int)Math.abs(Math.round(d3 - d5)) + 1) + d5;
                    if (serializable.getStat().dodgeChance > 0 && Randomizer.nextInt(100) < serializable.getStat().dodgeChance) {
                        d6 = 0.0;
                    }
                    if (((MapleCharacter)serializable).getBuffedValue(MapleBuffStat.MAGIC_GUARD) != null) {
                        n13 = (int)Math.min((double)((MapleCharacter)serializable).getStat().getMp(), d6 * ((MapleCharacter)serializable).getBuffedValue(MapleBuffStat.MAGIC_GUARD).doubleValue() / 100.0);
                    }
                    d6 -= (double)n13;
                    if (((MapleCharacter)serializable).getBuffedValue(MapleBuffStat.INFINITY) != null) {
                        n13 = 0;
                    }
                    cloneable.add(new Pair<Integer, Boolean>((int)Math.floor(d6), false));
                    n11 = (int)((double)n11 + Math.floor(d6));
                    n10 += n13;
                    n12 = ++n9;
                }
                ((MapleCharacter)serializable).addMPHP(-n11, -n10);
                object.add(new AttackPair(((MapleCharacter)serializable).getId(), ((AbstractMapleMapObject)((Object)serializable)).getPosition(), (List<Pair<Integer, Boolean>>)((Object)cloneable)));
                ((MapleCharacter)serializable).getCheatTracker().setAttacksWithoutHit(false);
                if (n11 > 0) {
                    bl2 = true;
                }
                if (((MapleCharacter)serializable).getStat().getHPPercent() <= 20) {
                    ((MapleCharacter)serializable).getStat();
                    SkillFactory.getSkill(PlayerStats.getSkillByJob(93, ((MapleCharacter)serializable).getJob())).getEffect(1).applyTo((MapleCharacter)serializable);
                }
                if (mapleStatEffect != null) {
                    if (mapleStatEffect.getMonsterStati().size() > 0 && mapleStatEffect.makeChanceResult()) {
                        for (Map.Entry<MonsterStatus, Integer> entry : mapleStatEffect.getMonsterStati().entrySet()) {
                            MapleBuffStat mapleBuffStat = MonsterStatus.getLinkedDisease(entry.getKey());
                            if (mapleBuffStat == null) continue;
                            ((MapleCharacter)serializable).giveDebuff(mapleBuffStat, entry.getValue(), 4000L, MobSkill.getByDisease(mapleBuffStat), 1);
                        }
                    }
                    mapleStatEffect.handleExtraPVP((MapleCharacter)a3, (MapleCharacter)serializable);
                }
                ((MapleCharacter)a3).getClient().sendPacket(MaplePacketCreator.getPVPHPBar(((MapleCharacter)serializable).getId(), ((MapleCharacter)serializable).getStat().getHp(), ((MapleCharacter)serializable).getStat().getCurrentMaxHp()));
                n2 += n11 / 100 + n10 / 100;
                if (!((MapleCharacter)serializable).isAlive()) {
                    bl3 = true;
                }
                if (object.size() < n5) continue;
                bl = bl3;
                break block28;
            }
            bl = bl3;
        }
        if (bl || n2 > 0) {
            Object object7 = a3;
            ((MapleCharacter)object7).getEventInstance().addPVPScore((MapleCharacter)a3, n2);
            ((MapleCharacter)object7).getClient().sendPacket(MaplePacketCreator.getPVPScore(n3 + n2, bl3));
        }
        if (bl2) {
            MapleMapObject mapleMapObject2;
            int n14;
            MapleMap mapleMap = ((MapleCharacter)a3).getMap();
            int n15 = ((MapleCharacter)a3).getId();
            short s2 = ((MapleCharacter)a3).getLevel();
            int n16 = ((AbstractMapleMapObject)mapleMapObject).getObjectId();
            if (((AbstractAnimatedMapleMapObject)mapleMapObject).isFacingLeft()) {
                n14 = 4;
                mapleMapObject2 = mapleMapObject;
            } else {
                n14 = 132;
                mapleMapObject2 = mapleMapObject;
            }
            mapleMap.broadcastMessage(MaplePacketCreator.pvpSummonAttack(n15, s2, n16, n14, ((AbstractMapleMapObject)mapleMapObject2).getTruePosition(), (List<AttackPair>)object));
            if (!((MapleSummon)mapleMapObject).isMultiAttack()) {
                MapleMapObject mapleMapObject3 = mapleMapObject;
                Object object8 = a3;
                ((MapleCharacter)object8).getMap().broadcastMessage(MaplePacketCreator.removeSummon((MapleSummon)mapleMapObject, true));
                ((MapleCharacter)object8).getMap().removeMapObject(mapleMapObject);
                ((MapleCharacter)object8).removeVisibleMapObject(mapleMapObject);
                ((MapleCharacter)a3).removeSummon((MapleSummon)mapleMapObject3);
                if (((MapleSummon)mapleMapObject3).getSkill() != 35121011) {
                    ((MapleCharacter)a3).cancelEffectFromBuffStat(MapleBuffStat.SUMMON);
                }
            }
        }
    }

    public static final /* synthetic */ void MoveSummon135(LittleEndianAccessor a2, MapleCharacter a3) {
        if (a3 == null || a3.getMap() == null) {
            return;
        }
        MapleMapObject mapleMapObject = a3.getMap().getMapObject(a2.readInt(), MapleMapObjectType.SUMMON);
        if (mapleMapObject == null) {
            return;
        }
        if (mapleMapObject instanceof MapleDragon) {
            SummonHandler.MoveDragon(a2, a3);
            return;
        }
        if (((MapleSummon)(mapleMapObject = (MapleSummon)mapleMapObject)).getOwnerId() != a3.getId() || ((MapleSummon)mapleMapObject).getSkillLevel() <= 0 || ((MapleSummon)mapleMapObject).getMovementType() == SummonMovementType.STATIONARY) {
            return;
        }
        a2.skip(8);
        List<LifeMovementFragment> list = MovementParse.parseMovement(a2, a3.getClient(), 4);
        Point point = ((AbstractMapleMapObject)mapleMapObject).getPosition();
        List<LifeMovementFragment> list2 = list;
        MovementParse.updatePosition(list2, (AnimatedMapleMapObject)mapleMapObject, 0);
        if (list2.size() > 0) {
            MapleCharacter mapleCharacter = a3;
            a3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.moveSummon(mapleCharacter.getId(), ((AbstractMapleMapObject)mapleMapObject).getObjectId(), point, list), ((AbstractMapleMapObject)mapleMapObject).getTruePosition());
        }
    }

    public static final /* synthetic */ void showDragonGlide(LittleEndianAccessor a2, MapleCharacter a3) {
        if (a3 == null || a3.getMap() == null || a3.getDragon() == null) {
            return;
        }
        if (a3.isEvan()) {
            int n2 = a2.readInt();
            int n3 = n2 == 0 ? a2.readInt() : 0;
            a3.setGildingDragon(n3 != 0);
            if (n2 == 1 && n3 == 0 || n2 == 0 && n3 >= 1902040 && n3 <= 1902042) {
                MapleCharacter mapleCharacter = a3;
                a3.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showDragonGlide(a3.getId(), n2, n3), mapleCharacter.getPosition());
            }
        }
    }

    public static final /* synthetic */ void SubSummon(LittleEndianAccessor a2, MapleCharacter a3) {
        MapleMapObject mapleMapObject;
        MapleMapObject mapleMapObject2;
        block23: {
            mapleMapObject2 = a3.getMap().getMapObject(a2.readInt(), MapleMapObjectType.SUMMON);
            if (mapleMapObject2 == null || !(mapleMapObject2 instanceof MapleSummon)) {
                return;
            }
            if (((MapleSummon)(mapleMapObject2 = (MapleSummon)mapleMapObject2)).getOwnerId() != a3.getId() || ((MapleSummon)mapleMapObject2).getSkillLevel() <= 0 || !a3.isAlive()) {
                return;
            }
            switch (((MapleSummon)mapleMapObject2).getSkill()) {
                case 1321007: {
                    MapleCharacter mapleCharacter;
                    while (false) {
                    }
                    ISkill iSkill = SkillFactory.getSkill(a2.readInt());
                    int n2 = a3.getSkillLevel(iSkill);
                    if (n2 <= 0 || iSkill == null) {
                        return;
                    }
                    ISkill iSkill2 = iSkill;
                    MapleStatEffect mapleStatEffect = iSkill2.getEffect(n2);
                    if (iSkill2.getId() == 1320009) {
                        MapleCharacter mapleCharacter2 = a3;
                        mapleCharacter = mapleCharacter2;
                        mapleStatEffect.applyTo(mapleCharacter2);
                    } else {
                        if (iSkill.getId() == 1320008) {
                            if (!a3.canSummon(mapleStatEffect.getX() * 1000)) {
                                return;
                            }
                            a3.addHP(mapleStatEffect.getHp());
                        }
                        mapleCharacter = a3;
                    }
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(((MapleSummon)mapleMapObject2).getSkill(), 2, a3.getLevel(), n2));
                    a3.getMap().broadcastMessage(MaplePacketCreator.summonSkill(a3.getId(), ((MapleSummon)mapleMapObject2).getSkill(), iSkill.getId() == 1320008 ? 5 : Randomizer.nextInt(3) + 6));
                    mapleMapObject = mapleMapObject2;
                    MapleCharacter mapleCharacter3 = a3;
                    a3.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.showBuffEffect(mapleCharacter3.getId(), ((MapleSummon)mapleMapObject2).getSkill(), 2, a3.getLevel(), n2), false);
                    break block23;
                }
                case 35121009: {
                    int n3;
                    if (!a3.canSummon(2000)) {
                        return;
                    }
                    int n2 = n3 = 0;
                    while (n2 < 3) {
                        MapleSummon mapleSummon = new MapleSummon(a3, SkillFactory.getSkill(35121011).getEffect(((MapleSummon)mapleMapObject2).getSkillLevel()), new Point(mapleMapObject2.getTruePosition().x, mapleMapObject2.getTruePosition().y - 5), SummonMovementType.WALK_STATIONARY);
                        MapleCharacter mapleCharacter = a3;
                        mapleCharacter.getMap().spawnSummon(mapleSummon);
                        mapleCharacter.addSummon(mapleSummon);
                        n2 = ++n3;
                    }
                    break;
                }
                case 35111011: {
                    if (!a3.canSummon(1000)) {
                        return;
                    }
                    MapleMapObjectType mapleMapObjectType = MapleMapObjectType.PLAYER;
                    double d2 = 40000.0;
                    MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
                    arrmapleMapObjectType[0] = mapleMapObjectType;
                    for (MapleCharacter mapleCharacter : a3.getMap().getMapObjectsInRange(((AbstractMapleMapObject)mapleMapObject2).getTruePosition(), d2, Arrays.asList(arrmapleMapObjectType))) {
                        if (!mapleCharacter.isAlive()) continue;
                        if (a3.getParty() != null && mapleCharacter.getParty() != null) {
                            if (a3.getPartyId() != mapleCharacter.getPartyId()) continue;
                            MapleCharacter mapleCharacter4 = mapleCharacter;
                            mapleCharacter4.addHP((int)((double)(a3.getStat().getCurrentMaxHp() * SkillFactory.getSkill(((MapleSummon)mapleMapObject2).getSkill()).getEffect(((MapleSummon)mapleMapObject2).getSkillLevel()).getHp()) / 100.0));
                            mapleCharacter4.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(((MapleSummon)mapleMapObject2).getSkill(), 2, a3.getLevel(), ((MapleSummon)mapleMapObject2).getSkillLevel()));
                            mapleCharacter4.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showBuffEffect(a3.getId(), ((MapleSummon)mapleMapObject2).getSkill(), 2, a3.getLevel(), ((MapleSummon)mapleMapObject2).getSkillLevel()), false);
                            continue;
                        }
                        if (mapleCharacter.getId() != a3.getId()) continue;
                        MapleCharacter mapleCharacter5 = a3;
                        mapleCharacter5.addHP((int)((double)(mapleCharacter5.getStat().getCurrentMaxHp() * SkillFactory.getSkill(((MapleSummon)mapleMapObject2).getSkill()).getEffect(((MapleSummon)mapleMapObject2).getSkillLevel()).getHp()) / 100.0));
                        mapleCharacter5.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(((MapleSummon)mapleMapObject2).getSkill(), 2, a3.getLevel(), ((MapleSummon)mapleMapObject2).getSkillLevel()));
                        MapleCharacter mapleCharacter6 = a3;
                        mapleCharacter5.getMap().broadcastMessage(mapleCharacter6, MaplePacketCreator.showBuffEffect(mapleCharacter6.getId(), ((MapleSummon)mapleMapObject2).getSkill(), 2, a3.getLevel(), ((MapleSummon)mapleMapObject2).getSkillLevel()), false);
                    }
                    break;
                }
                default: {
                    if (!a3.isShowErr()) break;
                    a3.showInfo(MapleFamily.ALLATORIxDEMO("\u5b3e\u53ac\u55f4\u7338"), true, "\u672a\u8655\u7406\u7684\u5b50\u53ec\u559a\u7378::" + ((MapleSummon)mapleMapObject2).getSkill());
                }
            }
            mapleMapObject = mapleMapObject2;
        }
        if (GameConstants.isAngel(((MapleSummon)mapleMapObject).getSkill())) {
            MapleCharacter mapleCharacter;
            if (((MapleSummon)mapleMapObject2).getSkill() % 10000 == 1087) {
                MapleItemInformationProvider.getInstance().getItemEffect(2022747).applyTo(a3);
                mapleCharacter = a3;
            } else if (((MapleSummon)mapleMapObject2).getSkill() % 10000 == 1179) {
                MapleItemInformationProvider.getInstance().getItemEffect(2022823).applyTo(a3);
                mapleCharacter = a3;
            } else {
                MapleItemInformationProvider.getInstance().getItemEffect(2022746).applyTo(a3);
                mapleCharacter = a3;
            }
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(((MapleSummon)mapleMapObject2).getSkill(), 2, 2, 1));
            MapleCharacter mapleCharacter7 = a3;
            a3.getMap().broadcastMessage(mapleCharacter7, MaplePacketCreator.showBuffEffect(mapleCharacter7.getId(), ((MapleSummon)mapleMapObject2).getSkill(), 2, 2, 1), false);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void SummonAttack(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        ISkill iSkill;
        int n2;
        Object object;
        SummonSkillEntry summonSkillEntry;
        int n3;
        int n4;
        byte by;
        Object object2;
        MapleMapObject mapleMapObject;
        block53: {
            MapleMapObject mapleMapObject2;
            if (a4 == null || !a4.isAlive()) {
                return;
            }
            a3 = a4.getMap();
            mapleMapObject = ((MapleMap)a3).getMapObject(a2.readInt(), MapleMapObjectType.SUMMON);
            if (mapleMapObject == null) {
                return;
            }
            if (((MapleSummon)(mapleMapObject = (MapleSummon)mapleMapObject)).getOwnerId() != a4.getId() || ((MapleSummon)mapleMapObject).getSkillLevel() <= 0) {
                return;
            }
            MapleMapObject mapleMapObject3 = mapleMapObject;
            object2 = SkillFactory.getSummonData(((MapleSummon)mapleMapObject3).getSkill());
            if (((MapleSummon)mapleMapObject3).getSkill() / 1000000 != 35 && ((MapleSummon)mapleMapObject).getSkill() != 33101008 && object2 == null) {
                a4.dropMessage(5, "<\u53ec\u559a\u7378\u653b\u64ca> \u6280\u80fd\u8cc7\u6599\u7570\u5e38: " + ((MapleSummon)mapleMapObject).getSkill());
                return;
            }
            if (GameSetConstants.MAPLE_VERSION != 116 && GameSetConstants.MAPLE_VERSION >= 113 && GameSetConstants.MAPLE_VERSION < 139) {
                a2.skip(8);
            }
            by = a2.readInt();
            MapleCharacter mapleCharacter = a4;
            mapleCharacter.updateTick(by);
            ((MapleSummon)mapleMapObject).CheckSummonAttackFrequency(mapleCharacter, by);
            if (GameSetConstants.MAPLE_VERSION != 116 && GameSetConstants.MAPLE_VERSION >= 113 && GameSetConstants.MAPLE_VERSION < 139) {
                a2.skip(8);
            }
            by = a2.readByte();
            if (!SummonSkillAnimation.checkAnimation(((MapleSummon)mapleMapObject).getSkill(), by)) {
                n4 = ((MapleSummon)mapleMapObject).getSkill() * 10 + by;
                if (!ALLATORIxDEMO.contains(n4)) {
                    ALLATORIxDEMO.add(n4);
                    FileoutputUtil.logToFile("logs/Animation/\u672a\u5b9a\u7fa9\u53ec\u559a\u7378\u5c01\u5305/" + ((MapleSummon)mapleMapObject).getSkill() + ".txt", by + "\r\n");
                }
                if (GameSetConstants.MAPLE_VERSION <= 149) {
                    return;
                }
            }
            if (GameSetConstants.MAPLE_VERSION != 116 && GameSetConstants.MAPLE_VERSION >= 113 && GameSetConstants.MAPLE_VERSION < 139) {
                a2.skip(8);
            }
            n4 = a2.readByte();
            n3 = 1;
            SummonSkillEntry summonSkillEntry2 = object2;
            if (summonSkillEntry2.mobCount > summonSkillEntry2.dieMobCount) {
                mapleMapObject2 = mapleMapObject;
                n3 = ((SummonSkillEntry)object2).mobCount;
            } else {
                n3 = ((SummonSkillEntry)object2).dieMobCount;
                mapleMapObject2 = mapleMapObject;
            }
            switch (((MapleSummon)mapleMapObject2).getSkill()) {
                case 33101008: {
                    n3 = 3;
                    summonSkillEntry = object2;
                    break block53;
                }
                case 35111002: {
                    n3 = 10;
                    summonSkillEntry = object2;
                    break block53;
                }
                case 35111009: {
                    if (GameSetConstants.MAPLE_VERSION < 147) break;
                    n3 = 8;
                    summonSkillEntry = object2;
                    break block53;
                }
                case 35111010: {
                    if (GameSetConstants.MAPLE_VERSION < 147) break;
                    n3 = 12;
                    summonSkillEntry = object2;
                    break block53;
                }
                case 35111005: 
                case 35111011: 
                case 35121009: 
                case 35121010: {
                    n3 = 6;
                }
            }
            summonSkillEntry = object2;
        }
        if (summonSkillEntry != null && n4 > n3) {
            a4.getCheatTracker().registerOffense(CheatingOffense.\u53ec\u559a\u7378\u653b\u64ca\u602a\u7269\u6578\u91cf\u7570\u5e38, " \u53ec\u559a\u7378: " + ((MapleSummon)mapleMapObject).getSkill() + "  \u5730\u5716: " + a4.getMapId() + " \u6b63\u5e38\u602a\u7269\u6578\u91cf: " + ((SummonSkillEntry)object2).mobCount + " \u653b\u64ca\u602a\u7269\u6578\u91cf: " + (byte)n4);
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.skip(((MapleSummon)mapleMapObject).getSkill() == 35111002 ? 24 : 12);
        } else if (GameSetConstants.MAPLE_VERSION >= 113) {
            a2.skip(8);
        }
        object2 = new ArrayList();
        a4.getCheatTracker().checkSummonAttack();
        n3 = 0;
        int n5 = n3;
        while (n5 < n4) {
            object = ((MapleMap)a3).getMonsterByOid(a2.readInt());
            if (object != null) {
                double d2 = 400000.0;
                switch (((MapleSummon)mapleMapObject).getSkill()) {
                    case 5220002: {
                        d2 = 590000.0;
                        break;
                    }
                    case 35111002: {
                        d2 = 1300000.0;
                        break;
                    }
                    case 35121003: {
                        d2 = 800000.0;
                        break;
                    }
                }
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    d2 *= 4.0;
                }
                if (((AbstractMapleMapObject)mapleMapObject).getPosition().distanceSq(((AbstractMapleMapObject)object).getPosition()) > d2 && !a4.inBossMap()) {
                    a4.getCheatTracker().registerOffense(CheatingOffense.\u53ec\u559a\u7378\u5168\u5716\u6253, " \u53ec\u559a\u7378: " + ((MapleSummon)mapleMapObject).getSkill() + "  \u5730\u5716: " + a4.getMapId() + " \u9810\u8a08\u7bc4\u570d: " + d2 + " \u5be6\u969b\u7bc4\u570d: " + (long)((AbstractMapleMapObject)mapleMapObject).getPosition().distanceSq(((AbstractMapleMapObject)object).getPosition()) + " ");
                    return;
                }
                if (GameSetConstants.MAPLE_VERSION == 75) {
                    a2.skip(14);
                } else {
                    a2.skip(18);
                }
                if (GameSetConstants.MAPLE_VERSION == 149) {
                    a2.readInt();
                }
                if (GameSetConstants.MAPLE_VERSION >= 151) {
                    a2.skip(4);
                }
                if (GameSetConstants.MAPLE_VERSION >= 152) {
                    a2.skip(1);
                }
                n2 = a2.readInt();
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    a2.skip(4);
                }
                if (GameSetConstants.MAPLE_VERSION >= 151) {
                    a2.skip(5);
                }
                object2.add(new SummonAttackEntry((MapleMonster)object, n2));
            }
            n5 = ++n3;
        }
        if (!((MapleSummon)mapleMapObject).isChangedMap()) {
            ((MapleMap)a3).broadcastMessage(a4, MaplePacketCreator.summonAttack(((MapleSummon)mapleMapObject).getOwnerId(), ((AbstractMapleMapObject)mapleMapObject).getObjectId(), by, (List<SummonAttackEntry>)object2, a4.getLevel(), false), ((AbstractMapleMapObject)mapleMapObject).getTruePosition());
        }
        if ((object = (iSkill = SkillFactory.getSkill(((MapleSummon)mapleMapObject).getSkill())).getEffect(((MapleSummon)mapleMapObject).getSkillLevel())) == null) {
            return;
        }
        Iterator iterator = object2.iterator();
        block13: while (true) {
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                SummonAttackEntry summonAttackEntry = (SummonAttackEntry)iterator.next();
                n2 = summonAttackEntry.getDamage();
                a3 = summonAttackEntry.getMonster();
                if (a3 == null) {
                    iterator2 = iterator;
                    continue;
                }
                if (!((MapleMonster)a3).isAlive()) {
                    return;
                }
                if (n2 <= 0) {
                    iterator2 = iterator;
                    continue;
                }
                if (n2 > 0 && ((MapleStatEffect)object).getMonsterStati().size() > 0 && ((MapleStatEffect)object).makeChanceResult()) {
                    Iterator<Map.Entry<MonsterStatus, Integer>> iterator3 = ((MapleStatEffect)object).getMonsterStati().entrySet().iterator();
                    while (iterator3.hasNext()) {
                        Iterator<Map.Entry<MonsterStatus, Integer>> iterator4;
                        Map.Entry<MonsterStatus, Integer> entry = iterator4.next();
                        int n6 = 4000;
                        if (((MapleStatEffect)object).getX() != 0) {
                            n6 = ((MapleStatEffect)object).getX() * 1000;
                        }
                        ((MapleMonster)a3).applyStatus(a4, new MonsterStatusEffect(entry.getKey(), entry.getValue(), iSkill.getId(), null, false), ((MapleStatEffect)object).isPoison(), n6, true, (MapleStatEffect)object);
                        iterator3 = iterator4;
                    }
                }
                long l2 = GameSetConstants.MAX_DAMAGE;
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    l2 = (long)((double)a4.getStat().getCurrentMaxBaseDamage() * 25.0 * (double)(((MapleStatEffect)object).getSelfDestruction() + ((MapleStatEffect)object).getDamage() + a4.getStat().getDamageIncrease(((MapleStatEffect)object).getSourceId())) / 100.0);
                }
                if (!a4.isGM() && (long)n2 > l2) continue block13;
                Object object3 = a3;
                MapleCharacter mapleCharacter = a4;
                ((MapleMonster)object3).damage(mapleCharacter, n2, true);
                mapleCharacter.checkMonsterAggro((MapleMonster)object3);
                if (((MapleMonster)object3).isAlive()) continue block13;
                a4.getClient().sendPacket(MobPacket.killMonster(((AbstractMapleMapObject)a3).getObjectId(), 1));
                continue block13;
            }
            break;
        }
        if (((MapleSummon)mapleMapObject).isGaviota()) {
            MapleCharacter mapleCharacter = a4;
            a4.getMap().broadcastMessage(MaplePacketCreator.removeSummon((MapleSummon)mapleMapObject, true));
            mapleCharacter.getMap().removeMapObject(mapleMapObject);
            mapleCharacter.removeVisibleMapObject(mapleMapObject);
            mapleCharacter.cancelEffectFromBuffStat(MapleBuffStat.SUMMON);
        }
        if (!((MapleSummon)mapleMapObject).isMultiAttack() || ((MapleSummon)mapleMapObject).getSkill() == 35111002 && by == 16) {
            MapleCharacter mapleCharacter = a4;
            MapleMapObject mapleMapObject4 = mapleMapObject;
            MapleCharacter mapleCharacter2 = a4;
            mapleCharacter2.getMap().broadcastMessage(MaplePacketCreator.removeSummon((MapleSummon)mapleMapObject, true));
            mapleCharacter2.getMap().removeMapObject(mapleMapObject);
            mapleCharacter.removeVisibleMapObject(mapleMapObject4);
            mapleCharacter.removeSummon((MapleSummon)mapleMapObject4);
            if (((MapleSummon)mapleMapObject).getSkill() != 35121011) {
                a4.cancelEffectFromBuffStat(MapleBuffStat.SUMMON);
            }
        }
    }
}

