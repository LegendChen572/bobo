/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleTrait;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleInventoryType;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MapConstants;
import constants.MobConstants;
import constants.SpecialSkillConstants;
import handling.channel.ChannelServer;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import scripting.event.EventInstanceManager;
import server.Extend.SpecialEquipData;
import server.MTSCart;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.MobSkillData;
import server.Randomizer;
import server.Timer;
import server.life.AbstractLoadedMapleLife;
import server.life.ChangeableStats;
import server.life.Element;
import server.life.ElementalEffectiveness;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterInformationProvider;
import server.life.MapleMonsterStats;
import server.life.MobSkill;
import server.life.MonsterDropEntry;
import server.life.MonsterListener;
import server.life.OverrideMonsterStats;
import server.maps.AbstractMapleMapObject;
import server.maps.MapScriptMethods;
import server.maps.MapleMap;
import server.maps.MapleMapEffect;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.packet.FamilyPacket;
import tools.packet.MobPacket;
import tools.use.donate;

public class MapleMonster
extends AbstractLoadedMapleLife {
    private /* synthetic */ boolean r;
    private /* synthetic */ long L;
    private /* synthetic */ byte X;
    private /* synthetic */ boolean a;
    private /* synthetic */ WeakReference<MapleCharacter> N;
    private /* synthetic */ double I;
    private /* synthetic */ int E;
    private /* synthetic */ ChangeableStats u;
    private /* synthetic */ byte[] b;
    private /* synthetic */ boolean j;
    private /* synthetic */ int f;
    private /* synthetic */ boolean Q;
    private /* synthetic */ int T;
    private /* synthetic */ long e;
    private /* synthetic */ boolean H;
    private /* synthetic */ MapleCharacter K;
    private /* synthetic */ int n;
    private /* synthetic */ byte[] G;
    public /* synthetic */ MonsterListener listener;
    private /* synthetic */ long B;
    private /* synthetic */ boolean Z;
    private /* synthetic */ int v;
    private /* synthetic */ int q;
    private /* synthetic */ boolean o;
    private /* synthetic */ boolean D;
    private /* synthetic */ int k;
    private /* synthetic */ WeakReference<MapleMonster> O;
    private /* synthetic */ boolean S;
    private /* synthetic */ int J;
    private /* synthetic */ ScheduledFuture<?> h;
    private /* synthetic */ long U;
    private /* synthetic */ boolean C;
    private /* synthetic */ int d;
    private /* synthetic */ int x;
    private /* synthetic */ EventInstanceManager w;
    private /* synthetic */ Map<Integer, Long> A;
    private /* synthetic */ MapleMonsterStats V;
    private /* synthetic */ long ALLATORIxDEMO;
    private /* synthetic */ byte z;
    private /* synthetic */ boolean t;
    private /* synthetic */ MapleMap Y;
    private /* synthetic */ double M;
    private /* synthetic */ int s;
    private final /* synthetic */ ReentrantReadWriteLock m;
    private final /* synthetic */ EnumMap<MonsterStatus, MonsterStatusEffect> c;
    private /* synthetic */ int R;
    private /* synthetic */ double F;
    private /* synthetic */ boolean i;
    private final /* synthetic */ Collection<AttackerEntry> P;
    private /* synthetic */ double g;
    private final /* synthetic */ LinkedList<MonsterStatusEffect> l;

    public final /* synthetic */ void applyStatus(MapleCharacter a2, MonsterStatusEffect a3, boolean a4, long a5, boolean a6, MapleStatEffect a7) {
        MapleMonster a8;
        a8.applyStatus(a2, a3, a4, a5, a6, a7, 0, true);
    }

    public final /* synthetic */ int getMobMaxMp() {
        MapleMonster a2;
        if (a2.u != null) {
            return a2.u.getMp();
        }
        return a2.V.getMp();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void spawnRevives(MapleMap a2) {
        MapleMonster a3;
        List<Integer> list = a3.V.getRevives();
        if (GameSetConstants.UNDER_CITY) {
            a3.spawnSpecialRevives(a2);
        }
        if (list == null) {
            return;
        }
        if (a3.RevivesDisabled()) {
            return;
        }
        AbstractLoadedMapleLife abstractLoadedMapleLife = null;
        switch (a3.getId()) {
            case 6160003: 
            case 8820002: 
            case 8820003: 
            case 8820004: 
            case 8820005: 
            case 8820006: 
            case 8840000: 
            case 8850011: {
                return;
            }
            case 0x866E86: 
            case 8810119: 
            case 0x866E88: 
            case 8810121: {
                MapleMonster mapleMonster;
                Iterator<Object> iterator = list.iterator();
                block15: while (iterator.hasNext()) {
                    int n2 = iterator.next();
                    mapleMonster = MapleLifeFactory.getMonster(n2);
                    MapleMonster mapleMonster2 = a3;
                    mapleMonster.setPosition(mapleMonster2.getPosition());
                    if (mapleMonster2.w != null) {
                        a3.w.registerMonster(mapleMonster);
                    }
                    if (a3.dropsDisabled()) {
                        mapleMonster.disableDrops();
                    }
                    switch (mapleMonster.getId()) {
                        case 8810119: 
                        case 0x866E88: 
                        case 8810121: 
                        case 8810122: {
                            abstractLoadedMapleLife = mapleMonster;
                            continue block15;
                        }
                    }
                }
                if (abstractLoadedMapleLife == null || a2.getMonsterById(abstractLoadedMapleLife.getId()) != null) return;
                MapleMap mapleMap = a2;
                mapleMap.spawnRevives((MapleMonster)abstractLoadedMapleLife, a3.getObjectId());
                for (MapleMapObject mapleMapObject : mapleMap.getAllMonstersThreadsafe()) {
                    mapleMonster = (MapleMonster)mapleMapObject;
                    if (mapleMonster.getObjectId() == abstractLoadedMapleLife.getObjectId() || mapleMonster.getSponge() != a3 && mapleMonster.getLinkOid() != a3.getObjectId()) continue;
                    MapleMonster mapleMonster3 = mapleMonster;
                    AbstractLoadedMapleLife abstractLoadedMapleLife2 = abstractLoadedMapleLife;
                    mapleMonster3.setSponge((MapleMonster)abstractLoadedMapleLife2);
                    mapleMonster3.setLinkOid(abstractLoadedMapleLife2.getObjectId());
                }
                return;
            }
            case 8810026: 
            case 8810130: 
            case 8820008: 
            case 8820009: 
            case 8820010: 
            case 8820011: 
            case 8820012: 
            case 8820013: {
                ArrayList<MapleMonster> arrayList;
                boolean bl;
                Object object;
                ArrayList<MapleMonster> arrayList2 = new ArrayList<MapleMonster>();
                boolean bl2 = false;
                Object object2 = list.iterator();
                block17: while (object2.hasNext()) {
                    int n3 = object2.next();
                    object = MapleLifeFactory.getMonster(n3);
                    MapleMonster mapleMonster = a3;
                    ((AbstractMapleMapObject)object).setPosition(mapleMonster.getPosition());
                    if (mapleMonster.w != null) {
                        a3.w.registerMonster((MapleMonster)object);
                    }
                    if (a3.dropsDisabled()) {
                        ((MapleMonster)object).disableDrops();
                    }
                    switch (((AbstractLoadedMapleLife)object).getId()) {
                        case 8810018: 
                        case 0x866E86: {
                            bl = true;
                        }
                        case 8820009: 
                        case 8820010: 
                        case 8820011: 
                        case 8820012: 
                        case 8820013: 
                        case 8820014: {
                            abstractLoadedMapleLife = object;
                            continue block17;
                        }
                    }
                    arrayList2.add((MapleMonster)object);
                }
                if (abstractLoadedMapleLife == null || a2.getMonsterById(abstractLoadedMapleLife.getId()) != null) return;
                if (a3.getspawnRevivesHpRate() != 1.0) {
                    object2 = new OverrideMonsterStats((long)((double)((MapleMonster)abstractLoadedMapleLife).getMobMaxHp() * a3.getspawnRevivesHpRate()), (int)((double)((MapleMonster)abstractLoadedMapleLife).getMobMaxMp() * a3.getspawnRevivesHpRate()), (int)((double)((MapleMonster)abstractLoadedMapleLife).getMobExp() * a3.getspawnRevivesHpRate()), false);
                    AbstractLoadedMapleLife abstractLoadedMapleLife3 = abstractLoadedMapleLife;
                    AbstractLoadedMapleLife abstractLoadedMapleLife4 = abstractLoadedMapleLife;
                    ((MapleMonster)abstractLoadedMapleLife4).setHp((long)((double)((MapleMonster)abstractLoadedMapleLife4).getHp() * a3.getspawnRevivesHpRate()));
                    ((MapleMonster)abstractLoadedMapleLife3).setMp((int)((double)((MapleMonster)abstractLoadedMapleLife3).getMp() * a3.getspawnRevivesHpRate()));
                    ((MapleMonster)abstractLoadedMapleLife3).setOverrideStats((OverrideMonsterStats)object2);
                }
                MapleMap mapleMap = a2;
                if (bl) {
                    mapleMap.spawnRevives((MapleMonster)abstractLoadedMapleLife, a3.getObjectId());
                    arrayList = arrayList2;
                } else {
                    mapleMap.spawnMonster((MapleMonster)abstractLoadedMapleLife, -2);
                    arrayList = arrayList2;
                }
                for (MapleMonster mapleMonster : arrayList) {
                    mapleMonster.setSponge((MapleMonster)abstractLoadedMapleLife);
                    if (a3.getspawnRevivesHpRate() != 1.0) {
                        object = new OverrideMonsterStats((long)((double)mapleMonster.getMobMaxHp() * a3.getspawnRevivesHpRate()), (int)((double)mapleMonster.getMobMaxMp() * a3.getspawnRevivesHpRate()), (int)((double)mapleMonster.getMobExp() * a3.getspawnRevivesHpRate()), false);
                        MapleMonster mapleMonster4 = mapleMonster;
                        MapleMonster mapleMonster5 = mapleMonster;
                        mapleMonster5.setHp((long)((double)mapleMonster5.getHp() * a3.getspawnRevivesHpRate()));
                        mapleMonster4.setMp((int)((double)mapleMonster4.getMp() * a3.getspawnRevivesHpRate()));
                        mapleMonster4.setOverrideStats((OverrideMonsterStats)object);
                    }
                    MapleMap mapleMap2 = a2;
                    if (bl) {
                        mapleMap2.spawnRevives(mapleMonster, a3.getObjectId());
                        continue;
                    }
                    mapleMap2.spawnMonster(mapleMonster, -2);
                }
                return;
            }
            case 8820014: {
                Iterator<Integer> iterator;
                Iterator<Integer> iterator2 = iterator = list.iterator();
                while (iterator2.hasNext()) {
                    int n4 = iterator.next();
                    MapleMonster mapleMonster = MapleLifeFactory.getMonster(n4);
                    if (mapleMonster.getId() == 8820001 && a2.getMonsterById(8820001) != null) {
                        iterator2 = iterator;
                        continue;
                    }
                    if (a3.w != null) {
                        a3.w.registerMonster(mapleMonster);
                    }
                    mapleMonster.setPosition(a3.getTruePosition());
                    if (a3.dropsDisabled()) {
                        mapleMonster.disableDrops();
                    }
                    a2.spawnMonster(mapleMonster, -2);
                    iterator2 = iterator;
                }
                return;
            }
            default: {
                for (int n5 : list) {
                    MapleMonster mapleMonster;
                    try {
                        mapleMonster = MapleLifeFactory.getMonster(n5);
                    }
                    catch (Exception exception) {
                        return;
                    }
                    if (mapleMonster == null) {
                        return;
                    }
                    if (a3.w != null) {
                        a3.w.registerMonster(mapleMonster);
                    }
                    mapleMonster.setPosition(a3.getPosition());
                    if (a3.dropsDisabled()) {
                        mapleMonster.disableDrops();
                    }
                    a2.spawnRevives(mapleMonster, a3.getObjectId());
                    if (mapleMonster.getId() != 9300216) continue;
                    MapleMap mapleMap = a2;
                    mapleMap.broadcastMessage(MaplePacketCreator.environmentChange(donate.ALLATORIxDEMO("7)\u0019'\u001d!\\%\u001f#\u00124"), 4));
                    mapleMap.broadcastMessage(MaplePacketCreator.environmentChange(MapleMapEffect.ALLATORIxDEMO("S!]/Y)\u0018+Y*\u0018-[+V<"), 3));
                }
            }
        }
    }

    public /* synthetic */ int getBelongsTo() {
        MapleMonster a2;
        if (a2.ALLATORIxDEMO < System.currentTimeMillis()) {
            return -1;
        }
        return a2.d;
    }

    public final /* synthetic */ ElementalEffectiveness getEffectiveness(Element a2) {
        MapleMonster a3;
        if (a3.c.size() > 0 && a3.c.get((Object)MonsterStatus.DOOM) != null) {
            return ElementalEffectiveness.NORMAL;
        }
        return a3.V.getEffectiveness(a2);
    }

    public /* synthetic */ boolean getChanged() {
        MapleMonster a2;
        return a2.j;
    }

    public final /* synthetic */ void startDropItemSchedule() {
        MapleMonster a2;
        MapleMonster mapleMonster = a2;
        mapleMonster.cancelDropItem();
        if (mapleMonster.V.getDropItemPeriod() <= 0 || !a2.isAlive()) {
            return;
        }
        MapleMonster mapleMonster2 = a2;
        mapleMonster2.D = false;
        mapleMonster2.e = System.currentTimeMillis();
    }

    public final /* synthetic */ int getPoisonDamage() {
        MapleMonster a2;
        return a2.k;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void cancelSingleStatus(MonsterStatusEffect a2) {
        MapleMonster a3;
        if (a2 == null || a2.getStatus() == MonsterStatus.EMPTY || a2.getStatus() == MonsterStatus.SUMMON || !a3.isAlive()) {
            return;
        }
        if (a2.getStatus() != MonsterStatus.POISON) {
            a3.cancelStatus(a2.getStatus());
            return;
        }
        a3.m.writeLock().lock();
        try {
            MonsterStatusEffect monsterStatusEffect;
            if (!a3.l.contains(a2)) {
                return;
            }
            a3.l.remove(a2);
            if (a2.isReflect()) {
                a3.G = null;
            }
            MonsterStatusEffect monsterStatusEffect2 = a2;
            monsterStatusEffect2.cancelPoisonSchedule(a3);
            monsterStatusEffect2.cancelPoisonSchedule();
            MapleCharacter mapleCharacter = a3.getController();
            if (mapleCharacter != null) {
                if (mapleCharacter.getDebugMessage()) {
                    Iterator<MonsterStatus> object;
                    Object object2 = "";
                    Iterator<MonsterStatus> iterator = object = Collections.singletonList(a2.getStatus()).iterator();
                    while (iterator.hasNext()) {
                        MonsterStatus monsterStatus = object.next();
                        object2 = (String)object2 + " " + monsterStatus.name();
                        iterator = object;
                    }
                    mapleCharacter.dropDebugMessage("(" + (String)object2 + ") \u7d50\u675f => \u6301\u7e8c\u50b7\u5bb3: \u7d50\u675f\u6642\u9593[" + System.currentTimeMillis() + "]");
                }
                a3.Y.broadcastMessage(mapleCharacter, MobPacket.cancelMonsterStatus(a3, a2), a3.getTruePosition());
                MonsterStatusEffect monsterStatusEffect3 = a2;
                monsterStatusEffect = monsterStatusEffect3;
                mapleCharacter.getClient().sendPacket(MobPacket.cancelMonsterStatus(a3, monsterStatusEffect3));
            } else {
                a3.Y.broadcastMessage(mapleCharacter, MobPacket.cancelMonsterStatus(a3, a2), a3.getTruePosition());
                monsterStatusEffect = a2;
            }
            for (MonsterStatus monsterStatus : Collections.singletonList(monsterStatusEffect.getStatus())) {
                a3.getStati().remove((Object)monsterStatus);
            }
            return;
        }
        finally {
            a3.m.writeLock().unlock();
        }
    }

    public final /* synthetic */ void applyMonsterStatus(byte[] a2) {
        MapleMonster a3;
        MapleCharacter mapleCharacter = a3.getController();
        if (mapleCharacter != null) {
            MapleCharacter mapleCharacter2 = mapleCharacter;
            a3.Y.broadcastMessage(mapleCharacter2, a2, a3.getTruePosition());
            mapleCharacter2.getClient().sendPacket(a2);
            return;
        }
        a3.Y.broadcastMessage(a2, a3.getTruePosition());
    }

    public final /* synthetic */ void doPoison(MonsterStatusEffect a2, WeakReference<MapleCharacter> a3) {
        MapleMonster a4;
        if ((((MonsterStatusEffect)a2).getStatus() == MonsterStatus.VENOMOUS_WEAPON || ((MonsterStatusEffect)a2).getStatus() == MonsterStatus.POISON) && a4.l.size() <= 0) {
            return;
        }
        if (((MonsterStatusEffect)a2).getStatus() != MonsterStatus.VENOMOUS_WEAPON && ((MonsterStatusEffect)a2).getStatus() != MonsterStatus.POISON && !a4.c.containsKey((Object)((MonsterStatusEffect)a2).getStatus())) {
            return;
        }
        if (a3 == null) {
            return;
        }
        MonsterStatusEffect monsterStatusEffect = a2;
        int n2 = monsterStatusEffect.getPoisonDamage();
        boolean bl = monsterStatusEffect.getSkill() == 4111003 || ((MonsterStatusEffect)a2).getSkill() == 14111001;
        a2 = (MapleCharacter)a3.get();
        boolean bl2 = a3 = n2 <= 0 || a2 == null || ((MapleCharacter)a2).getMapId() != a4.Y.getId();
        if ((long)n2 >= a4.U) {
            n2 = (int)a4.U--;
            boolean bl3 = a3 = !bl || a3;
        }
        if (!a3) {
            a4.damage((MapleCharacter)a2, n2, false);
            if (bl) {
                a4.Y.broadcastMessage(MobPacket.damageMonster(a4.getObjectId(), n2), a4.getTruePosition());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ int killBy(MapleCharacter a2, int a322) {
        int n2;
        MapleMonster a4;
        MapleMonster mapleMonster = a4;
        int n3 = mapleMonster.getMobExp();
        AttackerEntry attackerEntry = null;
        long l2 = 0L;
        for (AttackerEntry attackerEntry2 : mapleMonster.P) {
            if (attackerEntry2.getDamage() <= l2) continue;
            attackerEntry = attackerEntry2;
            l2 = attackerEntry.getDamage();
        }
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        for (AttackerEntry attackerEntry3 : a4.P) {
            int n4;
            boolean bl2;
            int n5 = (int)Math.ceil((double)n3 * ((double)attackerEntry3.getDamage() / (double)a4.getMobMaxHp()));
            for (AttackingMapleCharacter object : attackerEntry3.getAttackers()) {
                if (!arrayList.contains(object.getAttacker())) {
                    arrayList.add(object.getAttacker());
                    continue;
                }
                bl = true;
            }
            if (bl) continue;
            AttackerEntry attackerEntry2 = attackerEntry3;
            if (attackerEntry2 == attackerEntry) {
                bl2 = true;
                n4 = a322;
            } else {
                bl2 = false;
                n4 = a322;
            }
            attackerEntry2.killedMob(a4.getMap(), n5, bl2, n4);
        }
        MapleCharacter mapleCharacter = a4.getController();
        if (mapleCharacter != null) {
            Object object = mapleCharacter;
            ((MapleCharacter)object).getClient().sendPacket(MobPacket.stopControllingMonster(a4.getObjectId()));
            ((MapleCharacter)object).stopControllingMonster(a4);
        }
        int n6 = 0;
        switch (a4.getId()) {
            case 9400121: {
                n2 = n6 = 12;
                break;
            }
            case 8500002: {
                while (false) {
                }
                n2 = n6 = 13;
                break;
            }
            case 8510000: 
            case 8520000: {
                n2 = n6 = 14;
                break;
            }
            default: {
                n2 = n6;
            }
        }
        if (n2 != 0) {
            if (a2 != null && a2.getParty() != null) {
                for (MaplePartyCharacter linkedList : a2.getParty().getMembers()) {
                    MapleCharacter a322 = a2.getMap().getCharacterById(linkedList.getId());
                    if (a322 == null) continue;
                    a322.finishAchievement(n6);
                }
            } else if (a2 != null) {
                a2.finishAchievement(n6);
            }
        }
        if (a2 != null && a4.V.isBoss()) {
            a2.finishAchievement(18);
        }
        MapleMonster mapleMonster2 = a4;
        mapleMonster2.spawnRevives(mapleMonster2.getMap());
        if (mapleMonster2.w != null) {
            a4.w.unregisterMonster(a4);
            a4.w = null;
        }
        if (a2 != null && a2.getPyramidSubway() != null) {
            a2.getPyramidSubway().onKill(a2);
        }
        if (a2 != null) {
            a2.handleMapKillAll();
        }
        MapleMonster mapleMonster3 = a4.getSponge();
        MapleMonster mapleMonster4 = a4;
        a4.O = new WeakReference<Object>(null);
        if (mapleMonster3 != null && mapleMonster3.isAlive()) {
            boolean bl3;
            block33: {
                boolean linkedList = true;
                for (MapleMapObject mapleMapObject : a4.Y.getAllMonstersThreadsafe()) {
                    boolean n7;
                    MapleMonster mapleMonster5 = (MapleMonster)mapleMapObject;
                    if (mapleMonster5.getObjectId() == mapleMonster3.getObjectId() || mapleMonster5.getObjectId() == a4.getObjectId() || mapleMonster5.getSponge() != mapleMonster3 && mapleMonster5.getLinkOid() != mapleMonster3.getObjectId()) continue;
                    bl3 = n7 = false;
                    break block33;
                }
                bl3 = linkedList;
            }
            if (bl3) {
                a4.Y.killMonster(mapleMonster3, a2, 1 != 0, false, (byte)1);
            }
        }
        a4.b = null;
        a4.G = null;
        a4.cancelDropItem();
        if (a4.c.size() > 0) {
            Iterator a322;
            LinkedList<MonsterStatus> linkedList = new LinkedList<MonsterStatus>(a4.c.keySet());
            Iterator iterator = a322 = linkedList.iterator();
            while (iterator.hasNext()) {
                MonsterStatus monsterStatus = (MonsterStatus)((Object)a322.next());
                iterator = a322;
                a4.cancelStatus(monsterStatus);
            }
            linkedList.clear();
        }
        if (a4.l.size() > 0) {
            Iterator a322;
            LinkedList<MonsterStatusEffect> linkedList = new LinkedList<MonsterStatusEffect>();
            a4.m.readLock().lock();
            try {
                linkedList.addAll(a4.l);
            }
            finally {
                a4.m.readLock().unlock();
            }
            Iterator iterator = a322 = linkedList.iterator();
            while (iterator.hasNext()) {
                MonsterStatusEffect monsterStatusEffect = (MonsterStatusEffect)a322.next();
                iterator = a322;
                a4.cancelSingleStatus(monsterStatusEffect);
            }
            linkedList.clear();
        }
        if (a4.listener != null) {
            a4.listener.monsterKilled();
        }
        int n5 = a4.T;
        a4.T = 0;
        return n5;
    }

    public /* synthetic */ void setLinkCID(int a2) {
        MapleMonster a3;
        a3.R = a2;
        if (a3.R > 0) {
            a3.c.put(MonsterStatus.HYPNOTIZE, new MonsterStatusEffect(MonsterStatus.HYPNOTIZE, 60000, 30001062, null, false));
        }
    }

    public /* synthetic */ byte[] getNodePacket() {
        MapleMonster a2;
        return a2.b;
    }

    public final /* synthetic */ boolean isAlive() {
        MapleMonster a2;
        return a2.U > 0L;
    }

    public /* synthetic */ String getName() {
        MapleMonster a2;
        return MapleMonsterInformationProvider.getInstance().getMobName(a2.getId());
    }

    public /* synthetic */ boolean getCanBelong() {
        MapleMonster a2;
        if (a2.d == -1) {
            return true;
        }
        return a2.ALLATORIxDEMO < System.currentTimeMillis();
    }

    public final /* synthetic */ boolean isBuffed(MonsterStatus a2) {
        MapleMonster a3;
        return a3.c.containsKey((Object)a2);
    }

    public final /* synthetic */ void damage(MapleCharacter a2, long a3, boolean a4, boolean a5) {
        MapleMonster a6;
        a6.damage(a2, a3, a4, 0, a5);
    }

    public final /* synthetic */ void dispelSkill(MobSkill a2) {
        MapleMonster a3;
        ArrayList<MonsterStatus> arrayList = new ArrayList<MonsterStatus>();
        for (Map.Entry<MonsterStatus, MonsterStatusEffect> object : a3.c.entrySet()) {
            MonsterStatusEffect monsterStatusEffect = object.getValue();
            if (monsterStatusEffect == null || monsterStatusEffect.getMobSkill() == null || monsterStatusEffect.getMobSkill().getSkillId() != a2.getSkillId()) continue;
            arrayList.add(object.getKey());
        }
        Iterator<Map.Entry<MonsterStatus, MonsterStatusEffect>> iterator = arrayList.iterator();
        Iterator<Object> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MonsterStatus monsterStatus = (MonsterStatus)((Object)iterator.next());
            iterator2 = iterator;
            a3.cancelStatus(monsterStatus);
        }
    }

    public /* synthetic */ int getLevel() {
        MapleMonster a2;
        return a2.V.getLevel();
    }

    public final /* synthetic */ void killed() {
        MapleMonster a2;
        if (a2.listener != null) {
            a2.listener.monsterKilled();
        }
        a2.listener = null;
    }

    public final /* synthetic */ void disableSkills() {
        a.t = true;
    }

    public final /* synthetic */ void setSponge(MapleMonster a2) {
        MapleMonster a3;
        MapleMonster mapleMonster = a3;
        mapleMonster.O = new WeakReference<MapleMonster>(a2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void damage(MapleCharacter a2, long a3, boolean a42, int a5, boolean a6, boolean a7) {
        MapleMonster a8;
        block26: {
            MapleMonster mapleMonster;
            block28: {
                block27: {
                    MapleMonster mapleMonster2;
                    MapleMonster mapleMonster3;
                    long l2;
                    long l3;
                    block25: {
                        block23: {
                            block24: {
                                void var8_13;
                                boolean bl;
                                block22: {
                                    AttackerEntry attackerEntry;
                                    if (a2 == null || a3 <= 0L || !a8.isAlive()) {
                                        if (!a8.isAlive() && a8.getMobMaxHp() > 0L) {
                                            OverrideMonsterStats overrideMonsterStats = new OverrideMonsterStats();
                                            MapleMonster mapleMonster4 = a8;
                                            overrideMonsterStats.setOExp(0);
                                            mapleMonster4.setOverrideStats(overrideMonsterStats);
                                            mapleMonster4.getMap().killMonster(a8, a2, false, false, (byte)1, a5);
                                        }
                                        return;
                                    }
                                    if (a8.getStats().isFriendly() && !a7) {
                                        return;
                                    }
                                    if (a2.getParty() != null) {
                                        MapleMonster mapleMonster5 = a8;
                                        attackerEntry = new PartyAttackerEntry(mapleMonster5, a2.getParty().getId(), mapleMonster5.Y.getChannel());
                                    } else {
                                        MapleMonster mapleMonster6 = a8;
                                        attackerEntry = new SingleAttackerEntry(mapleMonster6, a2, mapleMonster6.Y.getChannel());
                                    }
                                    AttackerEntry attackerEntry2 = attackerEntry;
                                    a7 = false;
                                    for (AttackerEntry attackerEntry3 : a8.P) {
                                        if (!attackerEntry3.equals(attackerEntry2)) continue;
                                        AttackerEntry attackerEntry4 = attackerEntry3;
                                        bl = a7 = true;
                                        break block22;
                                    }
                                    bl = a7;
                                }
                                if (!bl) {
                                    a8.P.add((AttackerEntry)var8_13);
                                }
                                l3 = Math.max(0L, Math.min(a3, a8.U));
                                var8_13.addDamage(a2, l3, a42);
                                if (a8.getSponge() == null || a8.getSponge().getHp() <= 0L) break block23;
                                MapleMonster mapleMonster7 = a8;
                                l2 = mapleMonster7.getSponge().getHp() - l3;
                                mapleMonster7.getSponge().setHp(l2);
                                if (mapleMonster7.getSponge().getHp() > 0L) break block24;
                                if (!a6) break block23;
                                MapleMonster mapleMonster8 = a8;
                                a2.addMobCount(mapleMonster8.getLevel());
                                mapleMonster8.getMap().killMonster((MapleMonster)a8.O.get(), a2, 1 != 0, false, (byte)1, a5);
                                mapleMonster3 = a8;
                                break block25;
                            }
                            if (((MapleMonster)a8.O.get()).getStats().getRemoveAfter() != 1) {
                                a8.getMap().broadcastMessage(MobPacket.showBossHP((MapleMonster)a8.O.get()));
                            }
                        }
                        mapleMonster3 = a8;
                    }
                    if (mapleMonster3.getHp() <= 0L) break block26;
                    MapleMonster mapleMonster9 = a8;
                    l2 = mapleMonster9.getHp() - l3;
                    mapleMonster9.setHp(l2);
                    if (mapleMonster9.w != null) {
                        MapleMonster mapleMonster2 = a8;
                        mapleMonster2 = mapleMonster2;
                        a8.w.monsterDamaged(a2, mapleMonster10, (int)l3);
                    } else {
                        EventInstanceManager a42 = a2.getEventInstance();
                        if (a42 != null) {
                            a42.monsterDamaged(a2, a8, (int)l3);
                        }
                        mapleMonster2 = a8;
                    }
                    if (mapleMonster2.getSponge() != null || a8.U <= 0L) break block27;
                    switch (a8.getStats().getHPDisplayType()) {
                        case 0: {
                            if (a8.getStats().getRemoveAfter() == 1) break;
                            MapleMonster mapleMonster = a8;
                            mapleMonster = mapleMonster;
                            a8.getMap().broadcastMessage(MobPacket.showBossHP(a8), mapleMonster11.getPosition());
                            break block28;
                        }
                        case 1: {
                            MapleMonster mapleMonster = a8;
                            mapleMonster = mapleMonster;
                            mapleMonster12.getMap().broadcastMessage(MobPacket.damageFriendlyMob(a8, a3, true));
                            break block28;
                        }
                        case -1: 
                        case 2: {
                            mapleMonster = a8;
                            a8.getMap().broadcastMessage(MobPacket.showMonsterHP(a8.getObjectId(), (int)Math.ceil((double)a8.U * 100.0 / (double)a8.getMobMaxHp())));
                            a2.mulungEnergyModify(true);
                            break block28;
                        }
                        case 3: {
                            Iterator<AttackerEntry> a42 = a8.P.iterator();
                            while (a42.hasNext()) {
                                for (AttackingMapleCharacter attackingMapleCharacter : a42.next().getAttackers()) {
                                    if (attackingMapleCharacter == null || attackingMapleCharacter.getAttacker().getMap() != a2.getMap() || attackingMapleCharacter.getLastAttackTime() < System.currentTimeMillis() - 4000L) continue;
                                    attackingMapleCharacter.getAttacker().getClient().sendPacket(MobPacket.showMonsterHP(a8.getObjectId(), (int)Math.ceil((double)a8.U * 100.0 / (double)a8.getMobMaxHp())));
                                }
                            }
                            break block0;
                        }
                    }
                }
                mapleMonster = a8;
            }
            if (mapleMonster.getHp() <= 0L) {
                if (a8.getStats().getHPDisplayType() == -1) {
                    a8.getMap().broadcastMessage(MobPacket.showMonsterHP(a8.getObjectId(), (int)Math.ceil((double)a8.U * 100.0 / (double)a8.getMobMaxHp())));
                }
                if (a6) {
                    MapleMonster mapleMonster13 = a8;
                    a2.addMobCount(mapleMonster13.getLevel());
                    mapleMonster13.getMap().killMonster(a8, a2, 1 != 0, false, (byte)1, a5);
                }
            }
        }
        a8.startDropItemSchedule();
    }

    public final /* synthetic */ void setMonsterPet() {
        a.C = true;
    }

    public final /* synthetic */ void handleSteal(MapleCharacter a2) {
        MapleMonster a3;
        double d2 = 100.0;
        List<MonsterDropEntry> list = a3.getBuff(MonsterStatus.SHOWDOWN);
        if (list != null) {
            d2 += (double)((MonsterStatusEffect)((Object)list)).getX().intValue();
        }
        list = SkillFactory.getSkill(4201004);
        MapleCharacter mapleCharacter = a2;
        int n2 = mapleCharacter.getSkillLevel((ISkill)((Object)list));
        double d3 = ChannelServer.getInstance(mapleCharacter.getClient().getWorld(), a2.getClient().getChannel()).getDropRate(a2.getWorld());
        if (n2 > 0 && !a3.getStats().isBoss() && a3.f == -1 && list.getEffect(n2).makeChanceResult()) {
            list = MapleMonsterInformationProvider.getInstance().retrieveDrop(a3.getId());
            if (list == null) {
                a3.f = 0;
                return;
            }
            ArrayList<MonsterDropEntry> arrayList = new ArrayList<MonsterDropEntry>(list);
            Collections.shuffle(arrayList);
            for (MonsterDropEntry monsterDropEntry : arrayList) {
                MapleMonster mapleMonster;
                if (monsterDropEntry.itemId <= 0 || monsterDropEntry.questid != 0 || monsterDropEntry.itemId / 10000 == 238 || Randomizer.nextInt(999999) >= (int)((double)(10 * monsterDropEntry.chance) * d3 * (double)a2.getDropMod() * (a2.getStat().dropBuff / 100.0) * (d2 / 100.0))) continue;
                if (GameConstants.getInventoryType(monsterDropEntry.itemId) == MapleInventoryType.EQUIP) {
                    Equip equip = (Equip)MapleItemInformationProvider.getInstance().getEquipById(monsterDropEntry.itemId);
                    list = MapleItemInformationProvider.getInstance().randomizeStats(equip);
                    mapleMonster = a3;
                } else {
                    int n3;
                    if (monsterDropEntry.Maximum != 1) {
                        MonsterDropEntry monsterDropEntry2 = monsterDropEntry;
                        n3 = Randomizer.nextInt(monsterDropEntry2.Maximum - monsterDropEntry2.Minimum) + monsterDropEntry.Minimum;
                    } else {
                        n3 = 1;
                    }
                    list = new Item(monsterDropEntry.itemId, 0, (short)n3, 0);
                    mapleMonster = a3;
                }
                mapleMonster.f = monsterDropEntry.itemId;
                a3.Y.spawnMobDrop((IItem)((Object)list), a3.Y.calcDropPos(a3.getPosition(), a3.getTruePosition()), a3, a2, (byte)0, 0);
                return;
            }
        } else {
            a3.f = 0;
        }
    }

    public final /* synthetic */ ChangeableStats getChangedStats() {
        MapleMonster a2;
        return a2.u;
    }

    public final /* synthetic */ void setSummonMonster() {
        a.H = true;
    }

    public /* synthetic */ void addEmpty() {
        int n2;
        MonsterStatus[] arrmonsterStatus = MonsterStatus.values();
        int n3 = arrmonsterStatus.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MonsterStatus monsterStatus = arrmonsterStatus[n2];
            if (MonsterStatus.isDefaultStatus(monsterStatus)) {
                MapleMonster a2;
                MonsterStatus monsterStatus2 = monsterStatus;
                MonsterStatus monsterStatus3 = monsterStatus;
                a2.c.put(monsterStatus3, new MonsterStatusEffect(monsterStatus3, 0, false ? 1 : 0, null, false));
            }
            n4 = ++n2;
        }
    }

    public final /* synthetic */ void setVenomMulti(byte a2) {
        a.X = a2;
    }

    public /* synthetic */ long getBelongTimeLeft() {
        MapleMonster a2;
        if (a2.getBelongsToSomeone()) {
            return a2.ALLATORIxDEMO - System.currentTimeMillis();
        }
        return 0L;
    }

    public final /* synthetic */ void setListener(MonsterListener a2) {
        a.listener = a2;
    }

    public final /* synthetic */ void damage(MapleCharacter a2, long a3, boolean a4, int a5, boolean a6) {
        MapleMonster a7;
        a7.damage(a2, a3, a4, a5, a6, false);
    }

    public final /* synthetic */ void setFake(boolean a2) {
        a.S = a2;
    }

    public final /* synthetic */ String toStringX() {
        MapleMonster a2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append(a2.V.getName());
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("f"));
        stringBuilder3.append(a2.getId());
        stringBuilder.append(donate.ALLATORIxDEMO("Zf[\u7b0f\u7d69f"));
        stringBuilder.append(a2.V.getLevel());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("g\u0017\u5ee9\u6a2en"));
        stringBuilder.append(a2.getHp());
        stringBuilder.append(donate.ALLATORIxDEMO("\\f"));
        stringBuilder.append(a2.getMobMaxHp());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u8877\u9181\u001bn"));
        stringBuilder.append(a2.getMp());
        stringBuilder.append(donate.ALLATORIxDEMO("\\f"));
        stringBuilder.append(a2.getMobMaxMp());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0017\u9b1a\u52acb\u0017\u5383\u61fe\u5848\rn"));
        stringBuilder.append(a2.getObjectId());
        stringBuilder.append(donate.ALLATORIxDEMO("S\u6669\u5455\u70fc1\t \u0015If"));
        stringBuilder.append(a2.getStats().isBoss());
        return stringBuilder3.toString();
    }

    public final /* synthetic */ void disableRevives() {
        a.Z = true;
    }

    public final /* synthetic */ void setHp(long a2) {
        a.U = a2;
    }

    public final /* synthetic */ boolean SkillsDisabled() {
        MapleMonster a2;
        return a2.t;
    }

    public final /* synthetic */ void damage(MapleCharacter a2, long a3, boolean a4) {
        MapleMonster a5;
        a5.damage(a2, a3, a4, 0);
    }

    public final /* synthetic */ byte getVenomMulti() {
        MapleMonster a2;
        return a2.X;
    }

    public /* synthetic */ void setBelongsTo(MapleCharacter a2) {
        MapleMonster a3;
        if (a3.getBelongsTo() != -1) {
            return;
        }
        MapleMonster mapleMonster = a3;
        mapleMonster.d = a2.getId();
        mapleMonster.ALLATORIxDEMO = System.currentTimeMillis() + 30000L;
    }

    public /* synthetic */ boolean isEventMob() {
        MapleMonster a2;
        return a2.i;
    }

    public /* synthetic */ void setChanged(boolean a2) {
        a.j = a2;
    }

    public final /* synthetic */ boolean dropsDisabled() {
        MapleMonster a2;
        return a2.r;
    }

    public final /* synthetic */ long getLastAbsorbMP() {
        MapleMonster a2;
        return a2.L;
    }

    public final /* synthetic */ int getBuffToGive() {
        MapleMonster a2;
        return a2.V.getBuffToGive();
    }

    public final /* synthetic */ int getStatusSourceID(MonsterStatus a2) {
        MapleMonster a3;
        if ((a2 = a3.c.get(a2)) != null) {
            return ((MonsterStatusEffect)a2).getSkill();
        }
        return -1;
    }

    public final /* synthetic */ boolean isFirstAttack() {
        MapleMonster a2;
        return a2.V.isFirstAttack();
    }

    public /* synthetic */ void resetPoisonRate() {
        a.J = 1;
    }

    public /* synthetic */ void setNodePacket(byte[] a2) {
        a.b = a2;
    }

    public final /* synthetic */ double getspawnRevivesHpRate() {
        MapleMonster a2;
        return a2.F;
    }

    public final /* synthetic */ byte getCarnivalTeam() {
        MapleMonster a2;
        return a2.z;
    }

    public /* synthetic */ MapleMonster(MapleMonster a2) {
        MapleMonster a3;
        MapleMonster mapleMonster = a3;
        MapleMonster mapleMonster2 = a3;
        MapleMonster mapleMonster3 = a3;
        MapleMonster mapleMonster4 = a3;
        MapleMonster mapleMonster5 = a3;
        MapleMonster mapleMonster6 = a3;
        MapleMonster mapleMonster7 = a3;
        MapleMonster mapleMonster8 = a3;
        MapleMonster mapleMonster9 = a3;
        MapleMonster mapleMonster10 = a3;
        MapleMonster mapleMonster11 = a3;
        MapleMonster mapleMonster12 = a3;
        MapleMonster mapleMonster13 = a3;
        MapleMonster mapleMonster14 = a3;
        super(a2);
        mapleMonster14.u = null;
        MapleMonster mapleMonster15 = a3;
        mapleMonster14.O = new WeakReference<Object>(null);
        mapleMonster14.s = 0;
        mapleMonster13.n = -1;
        mapleMonster13.v = -1;
        mapleMonster12.T = 0;
        mapleMonster12.R = 0;
        mapleMonster11.N = new WeakReference<Object>(null);
        mapleMonster11.P = new LinkedList<AttackerEntry>();
        mapleMonster11.listener = null;
        mapleMonster10.G = null;
        mapleMonster9.b = null;
        mapleMonster10.c = new EnumMap(MonsterStatus.class);
        mapleMonster9.l = new LinkedList();
        mapleMonster9.m = new ReentrantReadWriteLock();
        mapleMonster8.f = -1;
        mapleMonster8.D = false;
        mapleMonster7.j = false;
        mapleMonster7.i = false;
        mapleMonster6.J = 1;
        mapleMonster6.M = 1.0;
        mapleMonster5.I = 1.0;
        mapleMonster5.F = 1.0;
        mapleMonster4.C = false;
        mapleMonster4.H = false;
        mapleMonster3.E = -1;
        mapleMonster3.g = 1.0;
        mapleMonster2.B = 0L;
        mapleMonster2.k = 0;
        mapleMonster.K = null;
        mapleMonster.a = false;
        a3.d = -1;
        a3.ALLATORIxDEMO(a2.V);
    }

    public final /* synthetic */ void setOverrideStats(OverrideMonsterStats a2) {
        MapleMonster a3;
        OverrideMonsterStats overrideMonsterStats = a2;
        MapleMonster mapleMonster = a3;
        a3.u = new ChangeableStats(a3.V, a2);
        a3.U = overrideMonsterStats.getHp();
        a3.x = overrideMonsterStats.getMp();
        a3.setChanged(true);
    }

    public final /* synthetic */ void setPoisonDamage(int a2) {
        a.k = a2;
    }

    public final /* synthetic */ void setEventInstance(EventInstanceManager a2) {
        a.w = a2;
    }

    public /* synthetic */ boolean isAttackedBy(MapleCharacter a2) {
        MapleMonster a3;
        Iterator<AttackerEntry> iterator = a3.P.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().contains(a2)) continue;
            return true;
        }
        return false;
    }

    public final /* synthetic */ void changeHellsettings() {
        MapleMonster a2;
        MapleMonster mapleMonster = a2;
        a2.u = new ChangeableStats(a2, a2.V, !GameSetConstants.HELL_CUSTOMIZE);
        MapleMonster mapleMonster2 = a2;
        mapleMonster2.U = mapleMonster2.u.getHp();
        mapleMonster2.x = mapleMonster2.u.getMp();
        mapleMonster2.q = mapleMonster2.u.getExp();
    }

    public final /* synthetic */ boolean isFake() {
        MapleMonster a2;
        return a2.S;
    }

    @Override
    public final /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleMonster a3;
        if (!a3.isAlive()) {
            return;
        }
        MapleMonster mapleMonster = a3;
        a2.sendPacket(MobPacket.spawnMonster(mapleMonster, mapleMonster.S && a3.R <= 0 ? -4 : -1, 0));
        if (a3.G != null) {
            a2.sendPacket(a3.G);
        }
        if (a3.n >= 0) {
            MapleMonster mapleMonster2 = a3;
            a2.sendPacket(MaplePacketCreator.getNodeProperties(mapleMonster2, mapleMonster2.Y));
            if (mapleMonster2.getId() == 9300275 && a3.Y.getId() >= 921120100 && a3.Y.getId() < 921120500) {
                if (a3.v != -1) {
                    a3.resetShammos(a2);
                    return;
                }
                a3.setLastNodeController(a2.getPlayer().getId());
            }
        }
    }

    public /* synthetic */ void setEventMob(boolean a2) {
        a.i = a2;
    }

    public final /* synthetic */ boolean isSummonMonster() {
        MapleMonster a2;
        return a2.H;
    }

    public final /* synthetic */ long getHp() {
        MapleMonster a2;
        return a2.U;
    }

    public final /* synthetic */ void setLastNode(int a2) {
        a.n = a2;
    }

    public final /* synthetic */ double getExtraDropRate() {
        MapleMonster a2;
        return a2.I;
    }

    public final /* synthetic */ void resetShammos(MapleClient a2) {
        Iterator<MapleCharacter> iterator;
        MapleMonster a3;
        MapleMonster mapleMonster = a3;
        mapleMonster.Y.killAllMonsters(true);
        mapleMonster.Y.broadcastMessage(MaplePacketCreator.getErrorNotice(donate.ALLATORIxDEMO("2f\u0003*\u0012?\u00164S.\u00125S+\u001c0\u0016\"S2\u001c)S \u00124S \u0001)\u001ef .\u0012+\u001e)\u0000hS\u0015\u001b'\u001e+\u001c5S/\u0000f\u0014)\u001a(\u0014f\u0011'\u0010-S2\u001cf\u0007.\u0016f\u00002\u00124\u0007h")));
        Iterator<MapleCharacter> iterator2 = iterator = mapleMonster.Y.getCharactersThreadsafe().iterator();
        while (iterator2.hasNext()) {
            MapleCharacter mapleCharacter = iterator.next();
            iterator2 = iterator;
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.changeMap(mapleCharacter.getMap(), mapleCharacter2.getMap().getPortal(0));
        }
        MapScriptMethods.startScript_FirstUser(a2, MapleMapEffect.ALLATORIxDEMO("D&V#Z!D\u0011q+Y:R<"));
    }

    public final /* synthetic */ void setShadowWeb(boolean a2) {
        a.a = a2;
    }

    public final /* synthetic */ int getMobExp() {
        MapleMonster a2;
        if (a2.u != null) {
            return a2.u.getExp();
        }
        return a2.V.getExp();
    }

    public final /* synthetic */ long getPoisonTime() {
        MapleMonster a2;
        return a2.B;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void spawnSpecialRevives(MapleMap a2) {
        int n2 = 200;
        int n3 = 0;
        if (a2.getId() < 100020100) return;
        if (a2.getId() <= 100020129) {
            Iterator<MapleCharacter> iterator;
            Iterator<MapleCharacter> iterator2 = iterator = a2.getCharacters().iterator();
            while (iterator2.hasNext()) {
                MapleCharacter mapleCharacter = iterator.next();
                iterator2 = iterator;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                n2 = mapleCharacter2.getLevel();
                n3 = mapleCharacter2.getJob();
            }
            switch (n3) {
                case 300: 
                case 310: 
                case 311: 
                case 312: 
                case 320: 
                case 321: 
                case 322: 
                case 410: 
                case 411: 
                case 412: 
                case 1400: 
                case 1410: 
                case 1411: 
                case 1412: {
                    MapleMonster a3;
                    if (Randomizer.rand(1, 100) <= 50) break;
                    MapleMap mapleMap = a2;
                    mapleMap.spawnMonsterOnGroundBelow(MapleLifeFactory.getRandomMonster(mapleMap, n2), a3.getPosition());
                    return;
                }
                default: {
                    MapleMonster a3;
                    MapleMap mapleMap = a2;
                    mapleMap.spawnMonsterOnGroundBelow(MapleLifeFactory.getRandomMonster(mapleMap, n2), a3.getPosition());
                }
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void doDropItem(long a) {
        var3_2 = 0;
        switch (a.getId()) {
            case 9300061: {
                var3_2 = 4001101;
                v0 = a;
                break;
            }
            case 9300102: {
                var3_2 = 4031507;
                v0 = a;
                break;
            }
            default: {
                a.cancelDropItem();
                return;
            }
        }
        if (!v0.isAlive() || a.Y == null) ** GOTO lbl21
        if (a.D) {
            a.Y.spawnAutoDrop(var3_2, a.getTruePosition());
            v1 = a;
        } else {
            a.D = true;
lbl21:
            // 2 sources

            v1 = a;
        }
        v1.e = a;
    }

    public /* synthetic */ int getLinkOid() {
        MapleMonster a2;
        return a2.s;
    }

    public final /* synthetic */ void damageFromStat(MapleCharacter a2, long a3, boolean a4, boolean a5) {
        MapleMonster a6;
        if (!a6.getStats().getOnlyNoramlAttack()) {
            a6.damage(a2, a3, a4, 0, a5);
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleMonsterStats a2) {
        MapleMonster a3;
        MapleMonster mapleMonster = a3;
        MapleMonster mapleMonster2 = a3;
        MapleMonster mapleMonster3 = a3;
        a3.setStance(5);
        a3.V = a2;
        mapleMonster3.U = a3.V.getHp();
        mapleMonster3.x = a2.getMp();
        mapleMonster2.X = 0;
        mapleMonster2.z = (byte)-1;
        mapleMonster.S = false;
        mapleMonster.r = false;
        if (a2.getNoSkills() > 0) {
            MapleMonster mapleMonster4 = a3;
            mapleMonster4.A = new HashMap<Integer, Long>();
        }
    }

    public /* synthetic */ void setDpmBelongTo(MapleCharacter a2) {
        a.E = a2.getId();
    }

    public final /* synthetic */ void damage(MapleCharacter a2, long a3, boolean a4, int a5) {
        MapleMonster a6;
        a6.damage(a2, a3, a4, a5, true);
    }

    public final /* synthetic */ MapleCharacter getController() {
        MapleMonster a2;
        return (MapleCharacter)a2.N.get();
    }

    public /* synthetic */ int getHPPercent() {
        MapleMonster a2;
        return (int)Math.ceil((double)a2.U * 100.0 / (double)a2.getMobMaxHp());
    }

    public final /* synthetic */ void absorbMP(int a2) {
        MapleMonster mapleMonster;
        MapleMonster a3;
        if (!a3.canAbsorbMP()) {
            return;
        }
        if (a3.getMp() >= a2) {
            MapleMonster mapleMonster2 = a3;
            mapleMonster = mapleMonster2;
            mapleMonster2.setMp(mapleMonster2.getMp() - a2);
        } else {
            MapleMonster mapleMonster3 = a3;
            mapleMonster = mapleMonster3;
            mapleMonster3.setMp(0);
        }
        mapleMonster.L = System.currentTimeMillis();
    }

    public final /* synthetic */ byte getNoSkills() {
        MapleMonster a2;
        return a2.V.getNoSkills();
    }

    public final /* synthetic */ EventInstanceManager getEventInstance() {
        MapleMonster a2;
        return a2.w;
    }

    public /* synthetic */ boolean getBelongsToSomeone() {
        MapleMonster a2;
        return a2.getBelongsTo() != -1 && a2.ALLATORIxDEMO > System.currentTimeMillis();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void applyStatus(MapleCharacter a, MonsterStatusEffect a, boolean a, long a, boolean a, MapleStatEffect a, int a, boolean a) {
        block86: {
            block89: {
                block88: {
                    block87: {
                        block82: {
                            block85: {
                                block84: {
                                    block83: {
                                        block81: {
                                            if (!a.isAlive()) {
                                                return;
                                            }
                                            if (a.isMonsterPet() != false) return;
                                            if (MobConstants.isReincarnationMob(a.getId())) {
                                                return;
                                            }
                                            var10_13 = SkillFactory.getSkill(a.getSkill());
                                            if (var10_13 != null) {
                                                switch (5.ALLATORIxDEMO[a.V.getEffectiveness(var10_13.getElement()).ordinal()]) {
                                                    case 1: 
                                                    case 2: {
                                                        return;
                                                    }
                                                    case 3: 
                                                    case 4: {
                                                        break;
                                                    }
                                                    default: {
                                                        return;
                                                    }
                                                }
                                            }
                                            var11_16 = a.getSkill();
                                            switch (var11_16) {
                                                case 2111006: {
                                                    switch (5.ALLATORIxDEMO[a.V.getEffectiveness(Element.POISON).ordinal()]) {
                                                        case 1: 
                                                        case 2: {
                                                            return;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2211006: {
                                                    switch (5.ALLATORIxDEMO[a.V.getEffectiveness(Element.ICE).ordinal()]) {
                                                        case 1: 
                                                        case 2: {
                                                            return;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 4120005: 
                                                case 4220005: 
                                                case 14110004: {
                                                    switch (5.ALLATORIxDEMO[a.V.getEffectiveness(Element.POISON).ordinal()]) {
                                                        case 4: {
                                                            return;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            if (a >= 2000000000L) {
                                                a = 5000L;
                                                if (a.getSourceId() == 32120000) {
                                                    a = 8000L;
                                                }
                                            }
                                            var12_17 = a.getStatus();
                                            if (a.V.isNoDoom() && var12_17 == MonsterStatus.DOOM) {
                                                return;
                                            }
                                            if (var12_17 == MonsterStatus.FREEZE) {
                                                switch (a.getId()) {
                                                    case 9400253: 
                                                    case 9400254: {
                                                        return;
                                                    }
                                                }
                                            }
                                            var13_18 = true;
                                            if (a != null) {
                                                switch (a.getSourceId()) {
                                                    case 1201006: 
                                                    case 31121006: {
                                                        var13_18 = false;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (a.V.isBoss() && var13_18) {
                                                if (var12_17 == MonsterStatus.STUN) {
                                                    return;
                                                }
                                                if (a != 0 && var12_17 != MonsterStatus.SPEED && var12_17 != MonsterStatus.NINJA_AMBUSH && var12_17 != MonsterStatus.WATK && var12_17 != MonsterStatus.POISON && var12_17 != MonsterStatus.DARKNESS && var12_17 != MonsterStatus.MAGIC_CRASH) {
                                                    return;
                                                }
                                                if (var12_17 == MonsterStatus.FREEZE) {
                                                    return;
                                                }
                                                if (var12_17 == MonsterStatus.SEAL) {
                                                    return;
                                                }
                                            }
                                            if (a.V.isFriendly() || a.isFake()) {
                                                if (var12_17 == MonsterStatus.STUN) return;
                                                if (var12_17 == MonsterStatus.SPEED) return;
                                                if (var12_17 == MonsterStatus.POISON) return;
                                                if (var12_17 == MonsterStatus.VENOMOUS_WEAPON) {
                                                    return;
                                                }
                                            }
                                            if ((var12_17 == MonsterStatus.VENOMOUS_WEAPON || var12_17 == MonsterStatus.POISON) && a == null) {
                                                return;
                                            }
                                            if (!GameSetConstants.POISON_BOSS && a.V.isBoss() && var12_17 == MonsterStatus.POISON) {
                                                return;
                                            }
                                            switch (var11_16) {
                                                case 2121003: 
                                                case 2221003: {
                                                    if (!a.V.isBoss() || var12_17 != MonsterStatus.POISON) break;
                                                    return;
                                                }
                                            }
                                            if (a.c.containsKey((Object)var12_17) && a != null) {
                                                a = 0;
                                                if (a.J < 3 && (a.getSourceId() == 4220011 || a.getSourceId() == 4120011)) {
                                                    a = 1;
                                                }
                                                if (a.J < 3 && a.getSourceId() == 32120000) {
                                                    a = 1;
                                                }
                                                if (a == 0) return;
                                                v0 = var12_17;
                                                v1 = a;
                                                a.getClient().sendPacket(MobPacket.cancelMonsterStatus(v1, a));
                                                ++v1.J;
                                            } else {
                                                v0 = var12_17;
                                            }
                                            if (v0 == MonsterStatus.POISON || var12_17 == MonsterStatus.VENOMOUS_WEAPON) {
                                                a = 0;
                                                a.m.readLock().lock();
                                                try {
                                                    for (MonsterStatusEffect var14_21 : a.l) {
                                                        if (var14_21 == null || var14_21.getSkill() != a.getSourceId() && var14_21.getSkill() != GameConstants.getLinkedAttackSkill(a.getSourceId()) && GameConstants.getLinkedAttackSkill(var14_21.getSkill()) != a.getSourceId()) continue;
                                                        ++a;
                                                    }
                                                }
                                                finally {
                                                    a.m.readLock().unlock();
                                                }
                                            }
                                            a = 0;
                                            var13_20 = false;
                                            if (a != null) {
                                                switch (a.getSourceId()) {
                                                    case 2121006: 
                                                    case 2211006: 
                                                    case 2221007: 
                                                    case 3120010: {
                                                        a = 1;
                                                        break;
                                                    }
                                                    case 2221005: {
                                                        var13_20 = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (GameSetConstants.MAPLE_VERSION < 134) break block81;
                                            if (!a || a.getHp() <= 1L || a == null) ** GOTO lbl121
                                            a = Math.max(a, (long)(a.getDOTTime() * 1000));
                                            if (a != 0) {
                                                v2 = a;
                                                a = a.getDOTTime() * 1000;
                                            } else {
                                                if (var13_20) {
                                                    a = a.getX() * 1000;
                                                }
lbl121:
                                                // 4 sources

                                                v2 = a;
                                            }
                                            if (v2 != null && a.getStat() != null && a) {
                                                a += (long)(a.getStat().dotTime * 1000);
                                                if (a != null && a.getStat().getDotTimeIncrease(a.getSourceId()) > 0) {
                                                    a += (long)a.getStat().getDotTimeIncrease(a.getSourceId());
                                                }
                                            }
                                        }
                                        var14_22 = a;
                                        if (var10_13 != null) {
                                            var14_22 += (long)var10_13.getAnimationTime();
                                        }
                                        if (a.hasGmLevel(5) && a.getStatus() != null && a != null) {
                                            a.dropMessage(6, "\u602a\u7269: " + a.getId() + " \u72c0\u614b: " + a.getStatus().name() + " \u662f\u5426\u70ba\u6bd2: " + a + " \u6301\u7e8c\u6642\u9593: " + a + " \u6280\u80fd: " + SkillFactory.getSkillName(a.getSourceId()));
                                        }
                                        if (!a || a.getHp() <= 1L || a.getStats().getOnlyNoramlAttack() || a.getStats().getFixedDamage() > 0) break block82;
                                        v3 = a;
                                        a = v3.isPirate() ? 1 : 0;
                                        a = v3.isBowman();
                                        a = v3.isMage();
                                        a = v3.isThief();
                                        a = (double)a.getMobMaxHp() * (1.0 / (double)(70 - a.getSkillLevel(a.getSourceId())));
                                        if (GameSetConstants.MAPLE_VERSION >= 134) {
                                            var10_14 = Math.max(1, a.getDOT() + a.getStat().dot + a.getStat().getDamageIncrease(a.getSourceId()));
                                            a = (double)((float)var10_14 * a.getStat().getCurrentMaxBaseDamage()) / 100.0;
                                        }
                                        a = a * GameSetConstants.POISON_DAMAGE_RATE;
                                        v4 = var10_15 = a == 0 ? a.intValue() : a;
                                        if (var10_15 <= 1) {
                                            var10_15 += Randomizer.rand(10, (int)a.getMobMaxHp());
                                        }
                                        var10_15 *= a.J;
                                        if (GameSetConstants.MAPLE_VERSION < 134) break block83;
                                        if (var10_15 <= 999999) break block84;
                                        var10_15 = 999999;
                                        v5 = a;
                                        break block85;
                                    }
                                    if (var10_15 > 32767) {
                                        var10_15 = 32767;
                                    }
                                }
                                v5 = a;
                            }
                            if (v5.hasGmLevel(5)) {
                                a.dropMessage(6, "\u602a\u7269: " + a.getId() + " \u72c0\u614b: \u6bd2 \u6280\u80fd: " + SkillFactory.getSkillName(a.getSourceId()) + " \u50b7\u5bb3: " + var10_15 + " \u5806\u758a\u500d\u7387:" + a.J);
                            }
                            v6 = a;
                            v7 = var10_15;
                            v6.setValue(var12_17, v7);
                            v6.setX(v7);
                            v8 = a;
                            v9 = a;
                            v10 = a;
                            v10.B = a;
                            v10.k = var10_15;
                            v9.K = a;
                            v9.a = false;
                            break block86;
                        }
                        if (var11_16 != 4111003 && var11_16 != 14111001) break block87;
                        v11 = a;
                        a.B = a;
                        v11.k = 9999;
                        v11.K = a;
                        a.a = true;
                        v8 = a;
                        break block86;
                    }
                    if (var11_16 != 4341003) break block88;
                    if (GameSetConstants.MAPLE_VERSION >= 134) break block89;
                    v8 = a;
                    v12 = a;
                    v13 = a;
                    v13.B = a;
                    v14 = a;
                    v13.k = (int)((double)((float)a.getDamage() * v14.getStat().getCurrentMaxBaseDamage()) / 100.0);
                    v12.K = v14;
                    v12.a = true;
                    break block86;
                }
                if (var11_16 == 4121004 || var11_16 == 4221004) {
                    v15 = a;
                    v15.setValue(v15.getStatus(), Math.min(32767, (int)((double)((float)a.getDamage() * a.getStat().getCurrentMaxBaseDamage()) / 100.0)));
                    a = (int)(var14_22 / 1000L * (long)a.getX().intValue() / 2L);
                    v16 = a;
                    v17 = a;
                    v17.B = a;
                    v17.k = a;
                    v16.K = a;
                    v16.a = false;
                    if (a > 0) {
                        if ((long)a >= a.U) {
                            a = (int)(a.U - 1L);
                        }
                        a.damageFromStat(a, a, false, false);
                    }
                }
            }
            v8 = a;
        }
        if (v8 && a.getHp() <= 1L) {
            return;
        }
        try {
            a.setCancelTask(var14_22);
            v18 = a;
        }
        catch (RejectedExecutionException a) {
            System.err.println(MapleMapEffect.ALLATORIxDEMO("l\u000fG>[7d:V:B=jn\u62fc\u51b4\u7547\u5e76\rne+]+T:R*r6R-B:^!Y\u000bO-R>C'X \u0017c\u0017\u001a^#R<\u62e5\u7d1b\u57c0\u8802\u4fbc\u5958"));
            FileoutputUtil.printError(donate.ALLATORIxDEMO("\u0014\u0016,\u0016%\u0007#\u0017\u0003\u000b#\u00103\u0007/\u001c(]2\u000b2"), a, MapleMapEffect.ALLATORIxDEMO("\u0015z/G\"R\u0003X D:R<\u0017c\u0017\u000fG>[7d:V:B=\u0017c\u0017\rV R\"c/D%jnc'Z+E\u629c\u7d62\u57b9\u887bn"));
            v18 = a;
        }
        a = v18.getController();
        if (var12_17 == MonsterStatus.POISON || var12_17 == MonsterStatus.VENOMOUS_WEAPON) {
            a.m.writeLock().lock();
            try {
                v19 = a;
                v20 = a;
                v19.c.put(var12_17, a);
                v20.l.add(a);
                v19.applyMonsterStatus(MobPacket.applyMonsterStatus(v20, v19.l));
            }
            finally {
                a.m.writeLock().unlock();
            }
        } else {
            a.c.put(var12_17, a);
            v21 = a;
            v21.applyMonsterStatus(MobPacket.applyMonsterStatus(v21, a));
        }
        if (a == null) return;
        if (a.getDebugMessage() == false) return;
        a.dropMessage(6, "\u958b\u59cb => \u7d66\u4e88\u602a\u7269\u72c0\u614b: \u6301\u7e8c\u6642\u9593[" + var14_22 + "] \u72c0\u614b\u6548\u679c[" + a.getStatus().name() + "] \u958b\u59cb\u6642\u9593[" + System.currentTimeMillis() + "]");
    }

    public final /* synthetic */ int getStolen() {
        MapleMonster a2;
        return a2.f;
    }

    public final /* synthetic */ void modifyHp(double a2) {
        MapleMonster a3;
        a3.u = new ChangeableStats(a3.V, a2);
        a3.U = a3.u.getHp();
        a3.x = a3.u.getMp();
    }

    public final /* synthetic */ void setStolen(int a2) {
        a.f = a2;
    }

    public /* synthetic */ void statClear() {
        MapleMonster a2;
        a2.c.clear();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ ArrayList<MonsterStatusEffect> getAllBuffs() {
        MapleMonster a2;
        ArrayList<MonsterStatusEffect> arrayList = new ArrayList<MonsterStatusEffect>();
        Iterator<MonsterStatusEffect> iterator = a2.c.values().iterator();
        Iterator<MonsterStatusEffect> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MonsterStatusEffect monsterStatusEffect = iterator.next();
            iterator2 = iterator;
            arrayList.add(monsterStatusEffect);
        }
        a2.m.readLock().lock();
        try {
            for (MonsterStatusEffect monsterStatusEffect : a2.l) {
                arrayList.add(monsterStatusEffect);
            }
            return arrayList;
        }
        finally {
            a2.m.readLock().unlock();
        }
    }

    public final /* synthetic */ String toString() {
        MapleMonster a2;
        StringBuilder stringBuilder = new StringBuilder();
        MapleMonster mapleMonster = a2;
        stringBuilder.append(mapleMonster.V.getName());
        stringBuilder.append(donate.ALLATORIxDEMO("n"));
        stringBuilder.append(a2.getId());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u001en\u001f\u7b07\u7d2dn"));
        stringBuilder.append(a2.V.getLevel());
        stringBuilder.append(donate.ALLATORIxDEMO("Zf\u575bf[\u001e"));
        stringBuilder.append(a2.getPosition().x);
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("a\u0017\u0017"));
        stringBuilder.append(a2.getPosition().y);
        stringBuilder.append(donate.ALLATORIxDEMO("oS\u5ee1\u6a6af"));
        stringBuilder.append(a2.getHp());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0018n"));
        stringBuilder.append(a2.getMobMaxHp());
        stringBuilder.append(donate.ALLATORIxDEMO("\u8833\u9189_f"));
        stringBuilder.append(a2.getMp());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0018n"));
        stringBuilder.append(a2.getMobMaxMp());
        stringBuilder.append(donate.ALLATORIxDEMO("S\u9b12\u52e8jS\u538b\u61ba\u5840If"));
        stringBuilder.append(a2.getObjectId());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("nK2\u0017\u4e89\u605f\u76a0\u6a2en\rn"));
        MapleCharacter mapleCharacter = (MapleCharacter)mapleMonster.N.get();
        stringBuilder.append(mapleCharacter != null ? mapleCharacter.getName() : donate.ALLATORIxDEMO("\u7167"));
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0017\u6661\u5411\u70f4u\u0001d\u001d\rn"));
        stringBuilder.append(a2.getStats().isBoss());
        stringBuilder.append(donate.ALLATORIxDEMO("S\t:\u0002If"));
        stringBuilder.append(a2.getObjectId());
        return stringBuilder.toString();
    }

    public final /* synthetic */ void setControllerHasAggro(boolean a2) {
        a.Q = a2;
    }

    public final /* synthetic */ void setExtraDropRate(double a2) {
        a.I = a2;
    }

    public final /* synthetic */ long getLastSkillUsed(int a2) {
        MapleMonster a3;
        if (a3.A.containsKey(a2)) {
            return a3.A.get(a2);
        }
        return 0L;
    }

    public final /* synthetic */ void setPoisonTime(int a2) {
        a.B = a2;
    }

    public final /* synthetic */ void cancelDropItem() {
        MapleMonster a2;
        if (a2.h != null) {
            a2.h.cancel(false);
            a2.h = null;
        }
    }

    public final /* synthetic */ void setExtraMesoRate(double a2) {
        a.M = a2;
    }

    public /* synthetic */ int getDpmBelongTo() {
        MapleMonster a2;
        return a2.E;
    }

    public final /* synthetic */ boolean getShadowWeb() {
        MapleMonster a2;
        return a2.a;
    }

    public final /* synthetic */ MonsterStatusEffect getBuff(MonsterStatus a2) {
        MapleMonster a3;
        return a3.c.get((Object)a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void setLastSkillUsed(int a2, long a3, long a4) {
        MapleMonster a5;
        switch (a2) {
            case 140: {
                a5.A.put(a2, a3 + a4 * 2L);
                a5.A.put(141, a3);
                return;
            }
            case 141: {
                a5.A.put(a2, a3 + a4 * 2L);
                a5.A.put(140, a3 + a4);
                return;
            }
        }
        a5.A.put(a2, a3 + a4);
    }

    public final /* synthetic */ void cancelStatus(MonsterStatus a2) {
        MapleMonster a3;
        if (a2 == MonsterStatus.EMPTY || a2 == MonsterStatus.SUMMON) {
            return;
        }
        a3.cancelStatus(Collections.singletonList(a2));
    }

    public final /* synthetic */ boolean isMonsterPet() {
        MapleMonster a2;
        return a2.C;
    }

    public final /* synthetic */ int getStatiSize() {
        MapleMonster a2;
        return a2.c.size() + (a2.l.size() > 0 ? 1 : 0);
    }

    public final /* synthetic */ boolean RevivesDisabled() {
        MapleMonster a2;
        return a2.Z;
    }

    public final /* synthetic */ void setLastNodeController(int a2) {
        a.v = a2;
    }

    public final /* synthetic */ void setspawnRevivesHpRate(double a2) {
        a.F = a2;
    }

    public final /* synthetic */ boolean isControllerKnowsAboutAggro() {
        MapleMonster a2;
        return a2.o;
    }

    public final /* synthetic */ MapleCharacter getPoisonChr() {
        MapleMonster a2;
        return a2.K;
    }

    public final /* synthetic */ void switchController(MapleCharacter a2, boolean a3) {
        MapleMonster a4;
        MapleCharacter mapleCharacter = a4.getController();
        if (mapleCharacter == a2) {
            return;
        }
        if (mapleCharacter != null) {
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.stopControllingMonster(a4);
            mapleCharacter2.getClient().sendPacket(MobPacket.stopControllingMonster(a4.getObjectId()));
        }
        a2.controlMonster(a4, a3);
        a4.setController(a2);
        if (a3) {
            a4.setControllerHasAggro(true);
        }
        MapleMonster mapleMonster = a4;
        mapleMonster.setControllerKnowsAboutAggro(false);
        if (mapleMonster.getId() == 9300275 && a4.Y.getId() >= 921120100 && a4.Y.getId() < 921120500) {
            if (a4.v != -1 && a4.v != a2.getId()) {
                a4.resetShammos(a2.getClient());
                return;
            }
            a4.setLastNodeController(a2.getId());
        }
    }

    public /* synthetic */ MapleMonster(int a2, MapleMonsterStats a3) {
        MapleMonster a4;
        MapleMonster mapleMonster = a4;
        MapleMonster mapleMonster2 = a4;
        MapleMonster mapleMonster3 = a4;
        MapleMonster mapleMonster4 = a4;
        MapleMonster mapleMonster5 = a4;
        MapleMonster mapleMonster6 = a4;
        MapleMonster mapleMonster7 = a4;
        MapleMonster mapleMonster8 = a4;
        MapleMonster mapleMonster9 = a4;
        MapleMonster mapleMonster10 = a4;
        MapleMonster mapleMonster11 = a4;
        MapleMonster mapleMonster12 = a4;
        MapleMonster mapleMonster13 = a4;
        MapleMonster mapleMonster14 = a4;
        super(a2);
        mapleMonster14.u = null;
        MapleMonster mapleMonster15 = a4;
        mapleMonster14.O = new WeakReference<Object>(null);
        mapleMonster14.s = 0;
        mapleMonster13.n = -1;
        mapleMonster13.v = -1;
        mapleMonster12.T = 0;
        mapleMonster12.R = 0;
        mapleMonster11.N = new WeakReference<Object>(null);
        mapleMonster11.P = new LinkedList<AttackerEntry>();
        mapleMonster11.listener = null;
        mapleMonster10.G = null;
        mapleMonster9.b = null;
        mapleMonster10.c = new EnumMap(MonsterStatus.class);
        mapleMonster9.l = new LinkedList();
        mapleMonster9.m = new ReentrantReadWriteLock();
        mapleMonster8.f = -1;
        mapleMonster8.D = false;
        mapleMonster7.j = false;
        mapleMonster7.i = false;
        mapleMonster6.J = 1;
        mapleMonster6.M = 1.0;
        mapleMonster5.I = 1.0;
        mapleMonster5.F = 1.0;
        mapleMonster4.C = false;
        mapleMonster4.H = false;
        mapleMonster3.E = -1;
        mapleMonster3.g = 1.0;
        mapleMonster2.B = 0L;
        mapleMonster2.k = 0;
        mapleMonster.K = null;
        mapleMonster.a = false;
        a4.d = -1;
        a4.ALLATORIxDEMO(a3);
    }

    public final /* synthetic */ void sendStatus(MapleClient a2) {
        MapleMonster a3;
        if (a3.G != null) {
            a2.sendPacket(a3.G);
        }
        if (a3.l.size() > 0) {
            a3.m.readLock().lock();
            try {
                MapleMonster mapleMonster = a3;
                a2.sendPacket(MobPacket.applyMonsterStatus(mapleMonster, mapleMonster.l));
                return;
            }
            finally {
                a3.m.readLock().unlock();
            }
        }
    }

    public final /* synthetic */ int getMp() {
        MapleMonster a2;
        return a2.x;
    }

    public final /* synthetic */ void disableDrops() {
        a.r = true;
    }

    public final /* synthetic */ void changeLevel(int a2, boolean a3) {
        MapleMonster a4;
        if (!a4.V.isChangeable()) {
            return;
        }
        MapleMonster mapleMonster = a4;
        a4.u = new ChangeableStats(a4.V, a2, a3);
        mapleMonster.U = mapleMonster.u.getHp();
        mapleMonster.x = mapleMonster.u.getMp();
    }

    public final /* synthetic */ long getMobMaxHp() {
        MapleMonster a2;
        if (a2.u != null) {
            return a2.u.getHp();
        }
        return a2.V.getHp();
    }

    public final /* synthetic */ String toStringPlayer() {
        MapleMonster a2;
        StringBuilder stringBuilder = new StringBuilder();
        MapleMonster mapleMonster = a2;
        stringBuilder.append(mapleMonster.V.getName());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u001f\u7b07\u7d2dn"));
        stringBuilder.append(a2.V.getLevel());
        stringBuilder.append(donate.ALLATORIxDEMO("Zf\u575bf[\u001e"));
        stringBuilder.append(a2.getPosition().x);
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("a\u0017\u0017"));
        stringBuilder.append(a2.getPosition().y);
        stringBuilder.append(donate.ALLATORIxDEMO("oS\u5ee1\u6a6af"));
        stringBuilder.append(a2.getHp());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0018n"));
        stringBuilder.append(a2.getMobMaxHp());
        stringBuilder.append(donate.ALLATORIxDEMO("\u8833\u9189_f"));
        stringBuilder.append(a2.getMp());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0018n"));
        stringBuilder.append(a2.getMobMaxMp());
        stringBuilder.append(donate.ALLATORIxDEMO("f\u9b27\u52dd_fS\t:\u0002If"));
        stringBuilder.append(a2.getObjectId());
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("nK2\u0017\u4e89\u605f\u76a0\u6a2en\rn"));
        MapleCharacter mapleCharacter = (MapleCharacter)mapleMonster.N.get();
        stringBuilder.append(mapleCharacter != null ? mapleCharacter.getName() : donate.ALLATORIxDEMO("\u7167"));
        stringBuilder.append(MapleMapEffect.ALLATORIxDEMO("\u0017\u6661\u5411\u70f4u\u0001d\u001d\rn"));
        stringBuilder.append(a2.getStats().isBoss());
        stringBuilder.append(donate.ALLATORIxDEMO("S\u000b<\u0004:\u0002If"));
        stringBuilder.append(a2.getId());
        return stringBuilder.toString();
    }

    public final /* synthetic */ void setMp(int a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.x = a2;
    }

    public final /* synthetic */ MapleMonsterStats getStats() {
        MapleMonster a2;
        return a2.V;
    }

    @Override
    public final /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleMonster a3;
        if (a3.n == -1) {
            a2.sendPacket(MobPacket.killMonster(a3.getObjectId(), 0));
        }
        if (a3.getId() == 9300275 && a3.Y.getId() >= 921120100 && a3.Y.getId() < 921120500) {
            a3.resetShammos(a2);
        }
    }

    public /* synthetic */ int getLinkCID() {
        MapleMonster a2;
        return a2.R;
    }

    public final /* synthetic */ double getDamageModify() {
        MapleMonster a2;
        return a2.g;
    }

    public final /* synthetic */ int getLastNodeController() {
        MapleMonster a2;
        return a2.v;
    }

    public final /* synthetic */ void setCarnivalTeam(byte a2) {
        a.z = a2;
    }

    public final /* synthetic */ void cancelStatus(Collection<MonsterStatus> a22) {
        Object object;
        MapleMonster a3;
        Object object2;
        Iterator<MonsterStatus> iterator;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator<MonsterStatus> iterator2 = iterator = a22.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator.next();
            if (object2 == MonsterStatus.SUMMON) {
                return;
            }
            object = a3.c.get(object2);
            if (object == null || !a3.isAlive()) {
                return;
            }
            if (((MonsterStatusEffect)object).isReflect()) {
                a3.G = null;
            }
            Object object3 = object;
            ((MonsterStatusEffect)object3).cancelPoisonSchedule(a3);
            ((MonsterStatusEffect)object3).cancelPoisonSchedule();
            iterator2 = iterator;
            arrayList.add(object);
        }
        MapleMonster mapleMonster = a3;
        int n2 = mapleMonster.getMap().incApplyedStatusMonsterCount();
        object2 = mapleMonster.getController();
        object = new Runnable(){
            public final /* synthetic */ MapleCharacter K;
            public final /* synthetic */ List d;
            public final /* synthetic */ Collection a;
            public final /* synthetic */ MapleMonster ALLATORIxDEMO;
            {
                3 a3;
                3 v0 = a3;
                v0.ALLATORIxDEMO = a2;
                v0.K = mapleCharacter;
                a3.a = collection;
                a3.d = list;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public final /* synthetic */ void run() {
                try {
                    3 v3;
                    Object object;
                    3 a2;
                    if (a2.K != null) {
                        if (a2.K.getDebugMessage()) {
                            Iterator iterator;
                            object = "";
                            Iterator iterator2 = iterator = a2.a.iterator();
                            while (iterator2.hasNext()) {
                                MonsterStatus monsterStatus = (MonsterStatus)((Object)iterator.next());
                                object = (String)object + " " + monsterStatus.name();
                                iterator2 = iterator;
                            }
                            a2.K.dropDebugMessage("(" + (String)object + ") \u7d50\u675f => \u6301\u7e8c\u50b7\u5bb3: \u7d50\u675f\u6642\u9593[" + System.currentTimeMillis() + "]");
                        }
                        if (a2.ALLATORIxDEMO.Y != null) {
                            3 v1 = a2;
                            a2.ALLATORIxDEMO.Y.broadcastMessage(v1.K, MobPacket.cancelMonsterStatus(v1.ALLATORIxDEMO, a2.d), a2.ALLATORIxDEMO.getTruePosition());
                        }
                        3 v2 = a2;
                        v3 = v2;
                        3 v4 = a2;
                        v2.K.getClient().sendPacket(MobPacket.cancelMonsterStatus(v4.ALLATORIxDEMO, v4.d));
                    } else {
                        if (a2.ALLATORIxDEMO.Y != null) {
                            3 v5 = a2;
                            a2.ALLATORIxDEMO.Y.broadcastMessage(MobPacket.cancelMonsterStatus(v5.ALLATORIxDEMO, v5.d), a2.ALLATORIxDEMO.getTruePosition());
                        }
                        v3 = a2;
                    }
                    Object object2 = object = v3.a.iterator();
                    while (true) {
                        if (!object2.hasNext()) {
                            a2.ALLATORIxDEMO.getMap().decApplyedStatusMonster();
                            return;
                        }
                        MonsterStatus monsterStatus = (MonsterStatus)((Object)object.next());
                        object2 = object;
                        a2.ALLATORIxDEMO.getStati().remove((Object)monsterStatus);
                    }
                }
                catch (RejectedExecutionException rejectedExecutionException) {
                    System.err.println(FamilyPacket.ALLATORIxDEMO("y\u0011C<A7N\u0001V3V'Q\u000f\u0002\u6299\u51d8\u7522\u5e1ah\u0002\u0000G8G1V7F\u0017Z7A'V;M<g*A7R&K=Lr\u000frv;O7P\u6280\u7d77\u57a5\u886e\u4fd9\u5934"));
                    FileoutputUtil.printError(SpecialSkillConstants.ALLATORIxDEMO("e\u0017]\u0017T\u0006R\u0016r\nR\u0011B\u0006^\u001dY\\C\nC"), rejectedExecutionException, FamilyPacket.ALLATORIxDEMO("ro3R>G\u001fM<Q&G \u0002\u007f\u0002\u0011C<A7N\u0001V3V'Q"));
                    return;
                }
            }
        };
        if (mapleMonster.getStats().isBoss()) {
            int a22 = n2 * 100;
            int n3 = 30000;
            if (n2 * 100 > 30000) {
                a22 = 30000;
                a3.getMap().resetApplyedStatusMonster();
            }
            Timer.BuffTimer.getInstance().schedule((Runnable)object, a22);
            return;
        }
        object.run();
    }

    public final /* synthetic */ List<MobSkillData> getSkills() {
        MapleMonster a2;
        return a2.V.getSkills();
    }

    public final /* synthetic */ MapleMonster getSponge() {
        MapleMonster a2;
        return (MapleMonster)a2.O.get();
    }

    public final /* synthetic */ void setPoisonChr(MapleCharacter a2) {
        a.K = a2;
    }

    public /* synthetic */ void setLinkOid(int a2) {
        a.s = a2;
    }

    public final /* synthetic */ void setControllerKnowsAboutAggro(boolean a2) {
        a.o = a2;
    }

    public final /* synthetic */ boolean hasSkill(int a2, int a3) {
        MapleMonster a4;
        return a4.V.hasSkill(a2, a3);
    }

    public final /* synthetic */ void setTempEffectiveness(final Element a2, long a3) {
        MapleMonster a4;
        a4.V.setEffectiveness(a2, ElementalEffectiveness.WEAK);
        Timer.MobTimer.getInstance().schedule(new Runnable(){
            {
                4 a3;
            }

            @Override
            public /* synthetic */ void run() {
                4 a22;
                a22.MapleMonster.this.V.removeEffectiveness(a22.a2);
            }
        }, a3);
    }

    public final /* synthetic */ void addPoisonTime(int a2) {
        a.B += (long)a2;
    }

    public final /* synthetic */ void damageFriendly(MapleCharacter a2, long a3, boolean a4) {
        MapleMonster a5;
        a5.damage(a2, a3, a4, 0, true, true);
    }

    public final /* synthetic */ boolean isControllerHasAggro() {
        MapleMonster a2;
        return a2.Q;
    }

    public final /* synthetic */ Map<MonsterStatus, MonsterStatusEffect> getStati() {
        MapleMonster a2;
        return a2.c;
    }

    public final /* synthetic */ void heal(int a2, int a3, boolean a4) {
        MapleMonster a5;
        MapleMonster mapleMonster = a5;
        long l2 = mapleMonster.getHp() + (long)a2;
        int n2 = mapleMonster.getMp() + a3;
        l2 = l2 > a5.getMobMaxHp() ? a5.getMobMaxHp() : l2;
        n2 = n2 > a5.getMobMaxMp() ? a5.getMobMaxMp() : n2;
        MapleMonster mapleMonster2 = a5;
        mapleMonster2.setHp(l2);
        mapleMonster2.setMp(n2);
        if (a4) {
            a5.getMap().broadcastMessage(MobPacket.healMonster(a5.getObjectId(), a2));
        }
        if (a5.getSponge() != null) {
            MapleMonster mapleMonster3 = a5;
            l2 = mapleMonster3.getSponge().getHp() + (long)a2;
            n2 = mapleMonster3.getSponge().getMp() + a3;
            l2 = l2 > a5.getSponge().getMobMaxHp() ? a5.getSponge().getMobMaxHp() : l2;
            n2 = n2 > a5.getSponge().getMobMaxMp() ? a5.getSponge().getMobMaxMp() : n2;
            MapleMonster mapleMonster4 = a5;
            mapleMonster4.getSponge().setHp(l2);
            mapleMonster4.getSponge().setMp(n2);
        }
    }

    public final /* synthetic */ double getExtraMesoRate() {
        MapleMonster a2;
        return a2.M;
    }

    public final /* synthetic */ void changeLevel(int a2) {
        MapleMonster a3;
        a3.changeLevel(a2, true);
    }

    public /* synthetic */ void applyMonsterBuff(final Map<MonsterStatus, Integer> a22, int a322, int a42, long a5, MobSkill a6, final List<Integer> a7) {
        Object object;
        Object object2;
        MapleMonster a8;
        MapleCharacter a322 = a8.getController();
        Timer.MobTimer a42 = Timer.MobTimer.getInstance();
        Runnable runnable = new Runnable(){
            {
                1 a3;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                if (a2.MapleMonster.this.isAlive()) {
                    1 v0 = a2;
                    a2.MapleMonster.this.cancelStatus(v0.a22.keySet());
                    v0.a7.clear();
                }
            }
        };
        ArrayList<MonsterStatusEffect> arrayList = new ArrayList<MonsterStatusEffect>();
        Object object3 = object2 = a22.entrySet().iterator();
        while (object3.hasNext()) {
            Map.Entry<MonsterStatus, Integer> entry = object2.next();
            if (a8.c.containsKey((Object)entry.getKey())) {
                a8.cancelStatus(entry.getKey());
            }
            object = new MonsterStatusEffect(entry.getKey(), entry.getValue(), 0, a6, true, a7.size() > 0);
            ((MonsterStatusEffect)object).setCancelTask(a5);
            a8.c.put(entry.getKey(), (MonsterStatusEffect)object);
            arrayList.add((MonsterStatusEffect)object);
            object3 = object2;
        }
        if (arrayList.isEmpty()) {
            return;
        }
        object2 = MobPacket.applyMonsterStatus(a8, arrayList);
        if (a7.size() > 0) {
            a8.G = (byte[])object2;
        }
        MapleMonster mapleMonster = a8;
        int n2 = mapleMonster.getMap().incApplyedStatusMonsterCount();
        object = new Runnable(){
            public final /* synthetic */ MapleCharacter K;
            public final /* synthetic */ byte[] E;
            public final /* synthetic */ Timer.MobTimer g;
            public final /* synthetic */ long k;
            public final /* synthetic */ MapleMonster ALLATORIxDEMO;
            public final /* synthetic */ int d;
            public final /* synthetic */ Runnable B;
            public final /* synthetic */ Map a;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public final /* synthetic */ void run() {
                2 a2;
                2 v0 = a2;
                v0.ALLATORIxDEMO.applyMonsterStatus(v0.E);
                try {
                    2 v1 = a2;
                    v1.g.schedule(v1.B, a2.k);
                    if (v1.K != null && a2.K.getDebugMessage()) {
                        Iterator iterator;
                        Object object = "";
                        Iterator iterator2 = iterator = a2.a.entrySet().iterator();
                        while (iterator2.hasNext()) {
                            Map.Entry entry = iterator.next();
                            object = (String)object + "[" + ((MonsterStatus)((Object)entry.getKey())).name() + "] ";
                            iterator2 = iterator;
                        }
                        2 v3 = a2;
                        v3.K.dropDebugMessage("\u602a\u7269\u65bd\u653e\u72c0\u614b" + v3.d + ": \u6301\u7e8c\u6642\u9593[" + a2.k + "] \u958b\u59cb\u6642\u9593[" + System.currentTimeMillis() + "] \u72c0\u614b\u6548\u679c:" + (String)object);
                    }
                    a2.ALLATORIxDEMO.getMap().decApplyedStatusMonster();
                    return;
                }
                catch (RejectedExecutionException rejectedExecutionException) {
                    System.err.println(SpecialEquipData.ALLATORIxDEMO("wx\\I@@aVBJX\\^{Y_Jd\f\u62f2\u51d6\u7549\u5e14\u0003\fkISIZX\\H|T\\OLXPCWiAO\\\\MEVB\u0019\u0001\u0019xPA\\^\u62eb\u7d79\u57ce\u8860\u4fb2\u593a"));
                    FileoutputUtil.printError(MTSCart.ALLATORIxDEMO("\u0001$9$056%\u001696\"&5:.=o'9'"), rejectedExecutionException, SpecialEquipData.ALLATORIxDEMO("mI\\UUtCW_MIKnLJ_\fmETIK\u62fe\u7d6c\u57db\u8875\f"));
                    return;
                }
            }
            {
                2 a3;
                2 v0 = a3;
                2 v1 = a3;
                2 v2 = a3;
                v2.ALLATORIxDEMO = a2;
                v2.E = arrby;
                v1.g = mobTimer;
                v1.B = runnable;
                v0.k = l2;
                v0.K = mapleCharacter;
                a3.a = map;
                a3.d = n2;
            }
        };
        if (mapleMonster.getStats().isBoss()) {
            int a22 = n2 * 100;
            int a322 = 30000;
            if (n2 * 100 > 30000) {
                a22 = 30000;
                a8.getMap().resetApplyedStatusMonster();
            }
            Timer.BuffTimer.getInstance().schedule((Runnable)object, a22);
            return;
        }
        object.run();
    }

    public final /* synthetic */ void setDamageModify(double a2) {
        a.g = a2;
    }

    public final /* synthetic */ void setController(MapleCharacter a2) {
        MapleMonster a3;
        MapleMonster mapleMonster = a3;
        mapleMonster.N = new WeakReference<MapleCharacter>(a2);
    }

    public final /* synthetic */ void setMap(MapleMap a2) {
        MapleMonster a3;
        a3.Y = a2;
        a3.startDropItemSchedule();
    }

    public /* synthetic */ boolean shouldDrop(long a2) {
        MapleMonster a3;
        return a3.e > 0L && a3.e + (long)(a3.V.getDropItemPeriod() * 1000) < a2;
    }

    public final /* synthetic */ int getLastNode() {
        MapleMonster a2;
        return a2.n;
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, int a3, boolean a4, int a5, int a6, int a7, int a8) {
        MapleMonster a9;
        if (a9.isAlive()) {
            return;
        }
        if (a4) {
            MapleMonster mapleMonster;
            if (a9.w != null) {
                MapleMonster mapleMonster2 = a9;
                mapleMonster = mapleMonster2;
                a9.w.monsterKilled(a2, mapleMonster2);
            } else {
                EventInstanceManager eventInstanceManager = a2.getEventInstance();
                if (eventInstanceManager != null) {
                    eventInstanceManager.monsterKilled(a2, a9);
                }
                mapleMonster = a9;
            }
            mapleMonster.T = a2.getId();
        }
        if (a3 > 0) {
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                a2.getTrait(MapleTrait.MapleTraitType.\u9818\u5c0e\u529b).addExp(a9.V.getCharismaEXP(), a2);
            }
            a2.gainExpMonster(a3, true, a4, a5, a6, a7, a9);
        }
        a2.mobKilled(a9.getId(), a8);
    }

    public final /* synthetic */ MapleMap getMap() {
        MapleMonster a2;
        return a2.Y;
    }

    public /* synthetic */ void expireAntiKS() {
        a.d = -2;
    }

    @Override
    public final /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.MONSTER;
    }

    public final /* synthetic */ boolean canAbsorbMP() {
        MapleMonster a2;
        return System.currentTimeMillis() - a2.L > 10000L;
    }

    private class PartyAttackerEntry
    implements AttackerEntry {
        private /* synthetic */ long k;
        private final /* synthetic */ Map<Integer, OnePartyAttacker> K;
        public final /* synthetic */ MapleMonster ALLATORIxDEMO;
        private final /* synthetic */ int a;
        private final /* synthetic */ int d;

        public final /* synthetic */ int hashCode() {
            PartyAttackerEntry a2;
            int n2 = 31;
            int n3 = 1;
            n3 = 31 * n3 + a2.a;
            return n3;
        }

        @Override
        public /* synthetic */ void addDamage(MapleCharacter a2, long a3, boolean a4) {
            block3: {
                PartyAttackerEntry partyAttackerEntry;
                PartyAttackerEntry a5;
                block2: {
                    OnePartyAttacker onePartyAttacker;
                    block1: {
                        onePartyAttacker = a5.K.get(a2.getId());
                        if (onePartyAttacker == null) break block1;
                        onePartyAttacker.damage += a3;
                        onePartyAttacker.lastKnownParty = a2.getParty();
                        if (!a4) break block2;
                        partyAttackerEntry = a5;
                        onePartyAttacker.lastAttackTime = System.currentTimeMillis();
                        break block3;
                    }
                    onePartyAttacker = new OnePartyAttacker(a2.getParty(), a3);
                    a5.K.put(a2.getId(), onePartyAttacker);
                    if (!a4) {
                        onePartyAttacker.lastAttackTime = 0L;
                    }
                }
                partyAttackerEntry = a5;
            }
            partyAttackerEntry.k += a3;
        }

        @Override
        public final /* synthetic */ long getDamage() {
            PartyAttackerEntry a2;
            return a2.k;
        }

        private /* synthetic */ Map<MapleCharacter, OnePartyAttacker> ALLATORIxDEMO() {
            PartyAttackerEntry a2;
            HashMap<MapleCharacter, OnePartyAttacker> hashMap = new HashMap<MapleCharacter, OnePartyAttacker>(a2.K.size());
            for (Map.Entry<Integer, OnePartyAttacker> entry : a2.K.entrySet()) {
                MapleCharacter mapleCharacter = a2.ALLATORIxDEMO.Y.getCharacterById(entry.getKey());
                if (mapleCharacter == null) continue;
                hashMap.put(mapleCharacter, entry.getValue());
            }
            return hashMap;
        }

        public final /* synthetic */ boolean equals(Object a2) {
            PartyAttackerEntry a3;
            if (a3 == a2) {
                return true;
            }
            if (a2 == null) {
                return false;
            }
            if (a3.getClass() != a2.getClass()) {
                return false;
            }
            PartyAttackerEntry partyAttackerEntry = (PartyAttackerEntry)a2;
            return a3.a == partyAttackerEntry.a;
        }

        @Override
        public final /* synthetic */ boolean contains(MapleCharacter a2) {
            PartyAttackerEntry a3;
            return a3.K.containsKey(a2.getId());
        }

        @Override
        public /* synthetic */ List<AttackingMapleCharacter> getAttackers() {
            PartyAttackerEntry a2;
            ArrayList<AttackingMapleCharacter> arrayList = new ArrayList<AttackingMapleCharacter>(a2.K.size());
            for (Map.Entry<Integer, OnePartyAttacker> entry : a2.K.entrySet()) {
                MapleCharacter mapleCharacter = a2.ALLATORIxDEMO.Y.getCharacterById(entry.getKey());
                if (mapleCharacter == null) continue;
                arrayList.add(new AttackingMapleCharacter(mapleCharacter, entry.getValue().lastAttackTime));
            }
            return arrayList;
        }

        @Override
        public final /* synthetic */ void killedMob(MapleMap a2, int a3, boolean a4, int a5) {
            Iterator iterator;
            PartyAttackerEntry a6;
            MapleCharacter mapleCharacter = null;
            long l2 = 0L;
            HashMap<Serializable, ExpMap> hashMap = new HashMap<Serializable, ExpMap>(6);
            int n2 = 0;
            for (Map.Entry<MapleCharacter, OnePartyAttacker> object2 : a6.ALLATORIxDEMO().entrySet()) {
                Map.Entry<MapleCharacter, OnePartyAttacker> entry;
                Serializable serializable = object2.getValue().lastKnownParty;
                double d2 = 0.0;
                int n3 = 0;
                int n4 = 0;
                ArrayList<MapleCharacter> arrayList = new ArrayList<MapleCharacter>();
                boolean bl = false;
                for (MaplePartyCharacter maplePartyCharacter : ((MapleParty)serializable).getMembers()) {
                    int n5;
                    if (object2.getKey().getLevel() - maplePartyCharacter.getLevel() > 5 && a6.ALLATORIxDEMO.V.getLevel() - maplePartyCharacter.getLevel() > 5) continue;
                    MapleCharacter mapleCharacter2 = a2.getCharacterById(maplePartyCharacter.getId());
                    if (mapleCharacter2 != null && mapleCharacter2.isAlive() && mapleCharacter2.getMap() == a2) {
                        arrayList.add(mapleCharacter2);
                        d2 += (double)mapleCharacter2.getLevel();
                        n5 = mapleCharacter2.getPartyMapMembers();
                        if (n3 == 0) {
                            // empty if block
                        }
                        if (mapleCharacter2.getPartyMapMembers() > 1 && mapleCharacter2.getStat().equippedWelcomeBackRing && n4 < 80) {
                            n4 = 80;
                        }
                        if (GameSetConstants.EXPRingPartyUnlimit && mapleCharacter2.getStat().equippedWelcomeBackRing && n4 < 80) {
                            n4 = 80;
                        }
                        if (GameSetConstants.SEPECIAL_PARTY_EXP && n5 > 1 && n4 < 80) {
                            n4 = (n5 - 1) * 10;
                        }
                        if (mapleCharacter2.getStat().hasPartyBonus && n2 < 4) {
                            ++n2;
                        }
                    }
                    if (mapleCharacter2 == null) continue;
                    n5 = mapleCharacter2.getPartyMapMembers();
                    if (!GameSetConstants.VONLEONMAP_PARTYEXPBONUS || !MapConstants.isVonleonMap(a2.getId()) || bl || n5 <= 1) continue;
                    n4 += (n5 - 1) * 20;
                    bl = true;
                }
                if (arrayList.size() > 1) {
                    d2 /= (double)arrayList.size();
                    entry = object2;
                } else {
                    n3 = 0;
                    entry = object2;
                }
                long l3 = entry.getValue().damage;
                if (l3 > l2) {
                    mapleCharacter = object2.getKey();
                    l2 = l3;
                }
                double d3 = (double)a3 * ((double)l3 / (double)a6.k) / (double)(arrayList.size() + 1);
                int n6 = ((MapleParty)serializable).getMembers().size();
                int maplePartyCharacter = object2.getKey().getPartyMapMembers();
                Iterator iterator2 = arrayList.iterator();
                while (iterator2.hasNext()) {
                    int n8;
                    Iterator n5;
                    serializable = (MapleCharacter)n5.next();
                    int n7 = n8 = hashMap.get(serializable) == null ? 0 : ((ExpMap)hashMap.get((Object)serializable)).exp;
                    double d4 = maplePartyCharacter > 1 ? (serializable == object2.getKey() ? 1.5 : 0.8) : (serializable == object2.getKey() ? 2.0 : 0.3);
                    double d5 = (double)((MapleCharacter)serializable).getLevel() / d2;
                    if (d5 > 1.0 || a6.K.containsKey(((MapleCharacter)serializable).getId())) {
                        d5 = 1.0;
                    }
                    iterator2 = n5;
                    hashMap.put(serializable, new ExpMap(n8 += (int)Math.round(d3 * d4 * d5), arrayList.size() + n2, n3, n4));
                }
            }
            Iterator iterator3 = iterator = hashMap.entrySet().iterator();
            while (iterator3.hasNext()) {
                ExpMap expMap;
                boolean bl;
                Map.Entry entry = iterator.next();
                ExpMap expMap2 = (ExpMap)entry.getValue();
                MapleCharacter mapleCharacter2 = (MapleCharacter)entry.getKey();
                if (a4) {
                    if (entry.getKey() == mapleCharacter) {
                        bl = true;
                        expMap = expMap2;
                    } else {
                        bl = false;
                        expMap = expMap2;
                    }
                } else {
                    bl = false;
                    expMap = expMap2;
                }
                ExpMap expMap3 = expMap2;
                a6.ALLATORIxDEMO.ALLATORIxDEMO(mapleCharacter2, expMap2.exp, bl, expMap.ptysize, expMap3.Class_Bonus_EXP, expMap3.Premium_Bonus_EXP, a5);
                iterator3 = iterator;
            }
        }

        public /* synthetic */ PartyAttackerEntry(MapleMonster mapleMonster, int a2, int a3) {
            PartyAttackerEntry a4;
            PartyAttackerEntry partyAttackerEntry = a4;
            a4.ALLATORIxDEMO = mapleMonster;
            PartyAttackerEntry partyAttackerEntry2 = a4;
            partyAttackerEntry2.K = new HashMap<Integer, OnePartyAttacker>(6);
            partyAttackerEntry.a = a2;
            partyAttackerEntry.d = a3;
        }
    }

    private final class SingleAttackerEntry
    implements AttackerEntry {
        private final /* synthetic */ int d;
        private /* synthetic */ long a;
        private /* synthetic */ long k;
        private final /* synthetic */ int K;
        public final /* synthetic */ MapleMonster ALLATORIxDEMO;

        @Override
        public /* synthetic */ boolean contains(MapleCharacter a2) {
            SingleAttackerEntry a3;
            return a3.K == a2.getId();
        }

        @Override
        public /* synthetic */ void addDamage(MapleCharacter a2, long a3, boolean a4) {
            SingleAttackerEntry a5;
            if (a5.K == a2.getId()) {
                a5.k += a3;
                if (a4) {
                    a5.a = System.currentTimeMillis();
                }
            }
        }

        @Override
        public /* synthetic */ void killedMob(MapleMap a2, int a3, boolean a4, int a5) {
            SingleAttackerEntry a6;
            MapleCharacter mapleCharacter = a2.getCharacterById(a6.K);
            if (mapleCharacter != null && mapleCharacter.isAlive()) {
                a6.ALLATORIxDEMO.ALLATORIxDEMO(mapleCharacter, a3, a4, 0, 0, 0, a5);
            }
        }

        public final /* synthetic */ boolean equals(Object a2) {
            SingleAttackerEntry a3;
            if (a3 == a2) {
                return true;
            }
            if (a2 == null) {
                return false;
            }
            if (a3.getClass() != a2.getClass()) {
                return false;
            }
            SingleAttackerEntry singleAttackerEntry = (SingleAttackerEntry)a2;
            return a3.K == singleAttackerEntry.K;
        }

        @Override
        public /* synthetic */ long getDamage() {
            SingleAttackerEntry a2;
            return a2.k;
        }

        @Override
        public final /* synthetic */ List<AttackingMapleCharacter> getAttackers() {
            SingleAttackerEntry a2;
            MapleCharacter mapleCharacter = a2.ALLATORIxDEMO.Y.getCharacterById(a2.K);
            if (mapleCharacter != null) {
                return Collections.singletonList(new AttackingMapleCharacter(mapleCharacter, a2.a));
            }
            return Collections.emptyList();
        }

        public /* synthetic */ SingleAttackerEntry(MapleMonster mapleMonster, MapleCharacter a2, int a3) {
            SingleAttackerEntry a4;
            SingleAttackerEntry singleAttackerEntry = a4;
            a4.ALLATORIxDEMO = mapleMonster;
            a4.k = 0L;
            singleAttackerEntry.K = a2.getId();
            singleAttackerEntry.d = a3;
        }

        public /* synthetic */ int hashCode() {
            SingleAttackerEntry a2;
            return a2.K;
        }
    }

    private static interface AttackerEntry {
        public /* synthetic */ boolean contains(MapleCharacter var1);

        public /* synthetic */ void addDamage(MapleCharacter var1, long var2, boolean var4);

        public /* synthetic */ void killedMob(MapleMap var1, int var2, boolean var3, int var4);

        public /* synthetic */ List<AttackingMapleCharacter> getAttackers();

        public /* synthetic */ long getDamage();
    }

    private static class AttackingMapleCharacter {
        private /* synthetic */ long ALLATORIxDEMO;
        private final /* synthetic */ WeakReference<MapleCharacter> d;

        public /* synthetic */ AttackingMapleCharacter(MapleCharacter a2, long a3) {
            AttackingMapleCharacter a4;
            AttackingMapleCharacter attackingMapleCharacter = a4;
            AttackingMapleCharacter attackingMapleCharacter2 = a4;
            attackingMapleCharacter.d = new WeakReference<MapleCharacter>(a2);
            attackingMapleCharacter.ALLATORIxDEMO = a3;
        }

        public final /* synthetic */ MapleCharacter getAttacker() {
            AttackingMapleCharacter a2;
            return (MapleCharacter)a2.d.get();
        }

        public final /* synthetic */ long getLastAttackTime() {
            AttackingMapleCharacter a2;
            return a2.ALLATORIxDEMO;
        }

        public final /* synthetic */ void setLastAttackTime(long a2) {
            a.ALLATORIxDEMO = a2;
        }
    }

    private static final class OnePartyAttacker {
        public /* synthetic */ long lastAttackTime;
        public /* synthetic */ MapleParty lastKnownParty;
        public /* synthetic */ long damage;

        public /* synthetic */ OnePartyAttacker(MapleParty a2, long a3) {
            OnePartyAttacker a4;
            OnePartyAttacker onePartyAttacker = a4;
            onePartyAttacker.lastKnownParty = a2;
            onePartyAttacker.damage = a3;
            onePartyAttacker.lastAttackTime = System.currentTimeMillis();
        }
    }

    private static final class ExpMap {
        public final /* synthetic */ int ptysize;
        public final /* synthetic */ int exp;
        public final /* synthetic */ int Premium_Bonus_EXP;
        public final /* synthetic */ int Class_Bonus_EXP;

        public /* synthetic */ ExpMap(int a2, int a3, int a4, int a5) {
            ExpMap a6;
            ExpMap expMap = a6;
            ExpMap expMap2 = a6;
            expMap2.exp = a2;
            expMap2.ptysize = a3;
            expMap.Class_Bonus_EXP = a4;
            expMap.Premium_Bonus_EXP = a5;
        }
    }
}

