/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import client.MapleCharacter;
import client.MapleCoolDownValueHolder;
import client.MapleStat;
import client.status.MonsterStatus;
import constants.GameConstants;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleMist;
import tools.npcgenerator.NPCMessage;

public class MobSkill {
    private /* synthetic */ Point d;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int e;
    private /* synthetic */ long g;
    private /* synthetic */ long E;
    private final /* synthetic */ int M;
    private /* synthetic */ int I;
    private /* synthetic */ short k;
    private /* synthetic */ List<Integer> K;
    private /* synthetic */ float B;
    private /* synthetic */ int C;
    private /* synthetic */ int H;
    private /* synthetic */ Point a;
    private final /* synthetic */ int J;
    private /* synthetic */ int F;

    public /* synthetic */ Point getLt() {
        MobSkill a2;
        return a2.a;
    }

    public /* synthetic */ void setX(int a2) {
        a.H = a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void applyEffect(MapleCharacter a, MapleMonster a, boolean a) {
        block70: {
            var4_4 = MobSkill.getByMobSkill(a.J);
            var5_5 = new EnumMap<MonsterStatus, Integer>(MonsterStatus.class);
            var6_6 = new LinkedList<Integer>();
            if (a != null && a.isAdmin() && a.isInvincible()) {
                a.dropMessage("\u7121\u6575\u72c0\u614b\u6d88\u9664\u602a\u7269DEBUFF: (" + a.J + ")");
                return;
            }
            switch (a.J) {
                case 100: 
                case 110: 
                case 150: {
                    v0 = var5_5;
                    v1 = v0;
                    v0.put(MonsterStatus.WEAPON_ATTACK_UP, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 101: 
                case 111: 
                case 151: {
                    v2 = var5_5;
                    v1 = v2;
                    v2.put(MonsterStatus.MAGIC_ATTACK_UP, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 102: 
                case 112: 
                case 152: {
                    v3 = var5_5;
                    v1 = v3;
                    v3.put(MonsterStatus.WEAPON_DEFENSE_UP, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 103: 
                case 113: 
                case 153: {
                    v4 = var5_5;
                    v1 = v4;
                    v4.put(MonsterStatus.MAGIC_DEFENSE_UP, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 154: {
                    v5 = var5_5;
                    v1 = v5;
                    v5.put(MonsterStatus.ACC, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 155: {
                    v6 = var5_5;
                    v1 = v6;
                    v6.put(MonsterStatus.AVOID, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 156: {
                    v7 = var5_5;
                    v1 = v7;
                    v7.put(MonsterStatus.SPEED, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 157: {
                    v8 = var5_5;
                    v1 = v8;
                    v8.put(MonsterStatus.SEAL, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 114: {
                    if (a.a != null && a.d != null && a && a != null) {
                        v9 = a;
                        var7_7 = v9.ALLATORIxDEMO(a, MapleMapObjectType.MONSTER);
                        var8_13 = v9.getX() / 1000 * (int)(950.0 + 1050.0 * Math.random());
                        v10 = var9_19 = var7_7.iterator();
                        while (v10.hasNext()) {
                            var10_27 = var9_19.next();
                            ((MapleMonster)var10_27).heal(var8_13, 0, true);
                            v10 = var9_19;
                        }
                        break;
                    }
                    if (a == null) break;
                    v1 = var5_5;
                    a.heal(a.getHP(), 0, true);
                    break block70;
                }
                case 105: {
                    if (a.a != null && a.d != null && a && a != null) {
                        var7_8 = a.ALLATORIxDEMO(a, MapleMapObjectType.MONSTER);
                        for (MapleMapObject var9_20 : var7_8) {
                            if (var9_20.getObjectId() == a.getObjectId()) continue;
                            a.getMap().killMonster((MapleMonster)var9_20, a, (boolean)0, (boolean)0, (byte)1, 0);
                            a.heal(a.getX(), a.getY(), true);
                        }
                        break;
                    }
                    if (a == null) break;
                    v1 = var5_5;
                    a.heal(a.getX(), a.getY(), true);
                    break block70;
                }
                case 127: {
                    if (a.a != null && a.d != null && a && a != null && a != null) {
                        v11 = var7_9 = a.ALLATORIxDEMO(a, a).iterator();
                        while (v11.hasNext()) {
                            var8_15 = var7_9.next();
                            v11 = var7_9;
                            var8_15.dispel();
                        }
                        break;
                    }
                    if (a == null) break;
                    v1 = var5_5;
                    a.dispel();
                    break block70;
                }
                case 129: {
                    if (a == null) break;
                    if (a.getEventInstance() == null || !a.getEventInstance().getName().contains(NPCMessage.ALLATORIxDEMO("0\u0002\u0001\u001e#\u0018\u0017\u001e\u0006"))) ** GOTO lbl120
                    v1 = var5_5;
                    break block70;
lbl120:
                    // 1 sources

                    var7_10 = false;
                    switch (a.getId()) {
                        case 8820006: 
                        case 8820018: {
                            v12 = var7_10 = true;
                            break;
                        }
                        case 8850011: {
                            if (GameSetConstants.SERVER_NAME.equals(MapleCoolDownValueHolder.ALLATORIxDEMO("\u5e5b\u4e10\u8c14"))) {
                                var7_10 = true;
                            }
                        }
                        default: {
                            v12 = var7_10;
                        }
                    }
                    if (!v12) ** GOTO lbl134
                    v1 = var5_5;
                    break block70;
lbl134:
                    // 1 sources

                    var8_16 = a.getStats().getBanishInfo();
                    if (var8_16 == null) ** GOTO lbl152
                    if (a.a != null && a.d != null && a && a != null) {
                        for (MapleCharacter var10_28 : a.ALLATORIxDEMO(a, a)) {
                            if (var10_28.hasBlockedInventory()) continue;
                            v13 = var10_28;
                            var10_28.cancelEffectFromBuffStat(MapleBuffStat.MECH_CHANGE);
                            v13.changeMapBanish(var8_16.getMap(), var8_16.getPortal(), var8_16.getMsg());
                            v13.dropMessage("\u60a8\u88ab " + a.getName() + " \u4f7f\u7528\u6280\u80fd\u50b3\u9001\u81f3 " + MapleItemInformationProvider.getInstance().getMapName(var8_16.getMap()) + " !");
                        }
                        break;
                    }
                    if (a == null || a.hasBlockedInventory()) break;
                    v14 = a;
                    a.cancelEffectFromBuffStat(MapleBuffStat.MECH_CHANGE);
                    v14.changeMapBanish(var8_16.getMap(), var8_16.getPortal(), var8_16.getMsg());
                    v14.dropMessage("\u60a8\u88ab " + a.getName() + " \u4f7f\u7528\u6280\u80fd\u50b3\u9001\u81f3 " + MapleItemInformationProvider.getInstance().getMapName(var8_16.getMap()) + " !");
                    v1 = var5_5;
                    break block70;
lbl152:
                    // 1 sources

                    if (a.getMapId() != 272020200 || a.getId() != 8860000 || a.a == null || a.d == null || !a || a == null) break;
                    for (MapleCharacter var10_29 : a.ALLATORIxDEMO(a, a)) {
                        if (var10_29.hasBlockedInventory()) continue;
                        v15 = var10_29;
                        v15.cancelEffectFromBuffStat(MapleBuffStat.MECH_CHANGE);
                        v15.changeMapBanish(272020300, NPCMessage.ALLATORIxDEMO("\u001e\u0002"), MapleCoolDownValueHolder.ALLATORIxDEMO("\u9069\u5398\u5979\u58a0\u547c\uff22{\u4e99\u9805\u3021"));
                    }
                    break;
                }
                case 131: {
                    if (a == null) break;
                    v1 = var5_5;
                    a.getMap().spawnMist(new MapleMist(a.ALLATORIxDEMO(a.getPosition(), true), a, a), a.H * 10, false);
                    break block70;
                }
                case 140: {
                    v16 = var5_5;
                    v1 = v16;
                    v16.put(MonsterStatus.WEAPON_IMMUNITY, a.H);
                    break block70;
                }
                case 141: {
                    v17 = var5_5;
                    v1 = v17;
                    v17.put(MonsterStatus.MAGIC_IMMUNITY, a.H);
                    break block70;
                }
                case 142: {
                    v18 = var5_5;
                    v1 = v18;
                    v18.put(MonsterStatus.DAMAGE_IMMUNITY, a.H);
                    break block70;
                }
                case 143: {
                    var5_5.put(MonsterStatus.WEAPON_DAMAGE_REFLECT, a.H);
                    var5_5.put(MonsterStatus.WEAPON_IMMUNITY, a.H);
                    var6_6.add(a.H);
                    if (a == null) break;
                    a.getMap().startMapEffect("\u5feb\u505c\u4e0b\u653b\u64ca\uff01" + a.getStats().getName() + "\u4f7f\u7528\u4e86\u53cd\u5c04\u7269\u653b!", 5120025, false, 5000);
                    v1 = var5_5;
                    break block70;
                }
                case 144: {
                    var5_5.put(MonsterStatus.MAGIC_DAMAGE_REFLECT, a.H);
                    var5_5.put(MonsterStatus.MAGIC_IMMUNITY, a.H);
                    var6_6.add(a.H);
                    if (a == null) break;
                    a.getMap().startMapEffect("\u5feb\u505c\u4e0b\u653b\u64ca\uff01" + a.getStats().getName() + "\u4f7f\u7528\u4e86\u53cd\u5c04\u9b54\u653b!", 5120025, false, 5000);
                    v1 = var5_5;
                    break block70;
                }
                case 145: {
                    var5_5.put(MonsterStatus.WEAPON_DAMAGE_REFLECT, a.H);
                    var5_5.put(MonsterStatus.WEAPON_IMMUNITY, a.H);
                    var5_5.put(MonsterStatus.MAGIC_DAMAGE_REFLECT, a.H);
                    var5_5.put(MonsterStatus.MAGIC_IMMUNITY, a.H);
                    var6_6.add(a.H);
                    if (a == null) break;
                    a.getMap().startMapEffect("\u5feb\u505c\u4e0b\u653b\u64ca\uff01" + a.getStats().getName() + "\u4f7f\u7528\u4e86\u53cd\u5c04\u7269\u529f\u53ca\u9b54\u653b!", 5120025, false, 5000);
                    v1 = var5_5;
                    break block70;
                }
                case 146: {
                    v19 = var5_5;
                    v1 = v19;
                    v19.put(MonsterStatus.INVINCIBLE, a.H);
                    var6_6.add(a.H);
                    break block70;
                }
                case 176: {
                    if (a.a == null || a.d == null || !a || a == null || a == null) break;
                    v20 = var9_23 = a.ALLATORIxDEMO(a, a).iterator();
                    while (v20.hasNext()) {
                        var10_30 = var9_23.next();
                        if (var10_30 == null) {
                            v20 = var9_23;
                            continue;
                        }
                        var10_30.getStat().setHp(0);
                        var10_30.updateSingleStat(MapleStat.HP, 0);
                        v20 = var9_23;
                    }
                    break;
                }
                case 200: {
                    if (a == null) {
                        return;
                    }
                    if (a.getId() != 8850011 || a.getSummons().size() != 5) ** GOTO lbl263
                    var5_5.put(MonsterStatus.EXCHANGE_ATTACK, 1);
                    var6_6.add(1);
                    a.applyMonsterBuff(var5_5, a.getX(), a.getSkillId(), 0x7FFFFFFFL, a, var6_6);
                    var9_24 = a.getSummons().get(Randomizer.nextInt(a.getSummons().size()));
                    var10_31 = MapleLifeFactory.getMonster(var9_24);
                    v21 = a;
                    var10_31.setPosition(v21.getPosition());
                    var11_35 = (int)a.getPosition().getY();
                    var12_37 = (int)v21.getPosition().getX();
                    if (v21.getEventInstance() != null) {
                        a.getEventInstance().registerMonster(var10_31);
                    }
                    a.getMap().spawnMonsterWithEffect(var10_31, a.getSpawnEffect(), a.getMap().calcPointBelow(new Point(var12_37, var11_35 - 1)));
                    v1 = var5_5;
                    break block70;
lbl263:
                    // 1 sources

                    var9_25 = a.getSummons().iterator();
                    block46: while (true) {
                        v22 = var9_25;
                        while (v22.hasNext()) {
                            var10_32 = var9_25.next();
                            try {
                                var11_36 = MapleLifeFactory.getMonster(GameConstants.getCustomSpawnID(a.getId(), var10_32));
                            }
                            catch (RuntimeException var12_39) {
                                v22 = var9_25;
                                continue;
                            }
                            if (var11_36 == null) {
                                v22 = var9_25;
                                continue;
                            }
                            var11_36.setPosition(a.getPosition());
                            v23 = a;
                            var12_38 = (int)v23.getPosition().getY();
                            var13_40 = (int)v23.getPosition().getX();
                            switch (var10_32) {
                                case 8500003: {
                                    var11_36.setFh((int)Math.ceil(Math.random() * 19.0));
                                    var12_38 = -590;
                                    v24 = a;
                                    break;
                                }
                                case 8500004: {
                                    v25 = a;
                                    v24 = v25;
                                    var13_40 = (int)(v25.getPosition().getX() + Math.ceil(Math.random() * 1000.0) - 500.0);
                                    var12_38 = (int)v25.getPosition().getY();
                                    break;
                                }
                                case 8510100: {
                                    if (Math.ceil(Math.random() * 5.0) == 1.0) {
                                        var12_38 = 78;
                                        var13_40 = (int)(0.0 + Math.ceil(Math.random() * 5.0)) + (Math.ceil(Math.random() * 2.0) == 1.0 ? 180 : 0);
                                        v24 = a;
                                        break;
                                    }
                                    v26 = a;
                                    v24 = v26;
                                    var13_40 = (int)(v26.getPosition().getX() + Math.ceil(Math.random() * 1000.0) - 500.0);
                                    break;
                                }
                                case 8820007: {
                                    continue block46;
                                }
                                default: {
                                    v24 = a;
                                }
                            }
                            switch (v24.getMap().getId()) {
                                case 220080001: {
                                    if (var13_40 < -890) {
                                        var13_40 = (int)(-890.0 + Math.ceil(Math.random() * 150.0));
                                        v27 = a;
                                    } else {
                                        if (var13_40 <= 230) break;
                                        var13_40 = (int)(230.0 - Math.ceil(Math.random() * 150.0));
                                        v27 = a;
                                    }
                                    ** GOTO lbl327
                                }
                                case 230040420: {
                                    if (var13_40 >= -239) ** GOTO lbl324
                                    var13_40 = (int)(-239.0 + Math.ceil(Math.random() * 150.0));
                                    v27 = a;
                                    ** GOTO lbl327
lbl324:
                                    // 1 sources

                                    if (var13_40 <= 371) break;
                                    var13_40 = (int)(371.0 - Math.ceil(Math.random() * 150.0));
                                }
                            }
                            v27 = a;
lbl327:
                            // 4 sources

                            v27.getMap().spawnMonsterWithEffect(var11_36, a.getSpawnEffect(), a.getMap().calcPointBelow(new Point(var13_40, var12_38 - 1)));
                            v22 = var9_25;
                        }
                        break block1;
                        break;
                    }
                }
            }
            v1 = var5_5;
        }
        if (v1.size() > 0 && a != null) {
            if (a.a != null && a.d != null && a) {
                v28 = var7_11 = a.ALLATORIxDEMO(a, MapleMapObjectType.MONSTER).iterator();
                while (v28.hasNext()) {
                    var8_17 = var7_11.next();
                    ((MapleMonster)var8_17).applyMonsterBuff(var5_5, a.getX(), a.getSkillId(), a.getDuration(), a, var6_6);
                    v28 = var7_11;
                }
            } else {
                a.applyMonsterBuff(var5_5, a.getX(), a.getSkillId(), a.getDuration(), a, var6_6);
            }
        }
        if (var4_4 != null && a != null) {
            if (a.a != null && a.d != null && a && a != null) {
                v29 = var7_12 = a.ALLATORIxDEMO(a, a).iterator();
                while (v29.hasNext()) {
                    var8_18 = var7_12.next();
                    v29 = var7_12;
                    var8_18.getDiseaseBuff(var4_4, a);
                }
            } else {
                a.getDiseaseBuff(var4_4, a);
            }
        }
        if (a != null) {
            v30 = a;
            v30.setMp(v30.getMp() - a.getMpCon());
        }
        if (a == null) return;
        if (a == null) return;
        if (a.isStaff() == false) return;
        a.dropDebugMessage("[\u602a\u7269\u65bd\u653e\u6280\u80fd] \u602a\u7269\u540d\u5b57:" + a.getStats().getName() + "(" + a.getId() + ") \u65bd\u653e\u4e86\u6280\u80fdID:" + a.J + "\u662f\u5426\u70ba\u6280\u80fd:" + a);
    }

    public /* synthetic */ boolean makeChanceResult() {
        MobSkill a2;
        return (double)a2.B >= 1.0 || Math.random() < (double)a2.B;
    }

    public /* synthetic */ void setSpawnEffect(int a2) {
        a.F = a2;
    }

    public /* synthetic */ MobSkill(int a2, int a3) {
        MobSkill a4;
        MobSkill mobSkill = a4;
        MobSkill mobSkill2 = a4;
        mobSkill2.K = new ArrayList<Integer>();
        mobSkill.J = a2;
        mobSkill.M = a3;
    }

    public /* synthetic */ int getY() {
        MobSkill a2;
        return a2.e;
    }

    public /* synthetic */ int getX() {
        MobSkill a2;
        return a2.H;
    }

    public /* synthetic */ int getSpawnEffect() {
        MobSkill a2;
        return a2.F;
    }

    public /* synthetic */ long getDuration() {
        MobSkill a2;
        return a2.E;
    }

    public /* synthetic */ int getSkillLevel() {
        MobSkill a2;
        return a2.M;
    }

    private /* synthetic */ List<MapleCharacter> ALLATORIxDEMO(MapleMonster a2, MapleCharacter a3) {
        MobSkill a4;
        Rectangle rectangle = a4.ALLATORIxDEMO(a2.getPosition(), a2.isFacingLeft());
        ArrayList<MapleCharacter> arrayList = new ArrayList<MapleCharacter>();
        arrayList.add(a3);
        return a2.getMap().getPlayersInRectThreadsafe(rectangle, arrayList);
    }

    public /* synthetic */ int getHP() {
        MobSkill a2;
        return a2.C;
    }

    public /* synthetic */ void setOnce(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ int getHp() {
        MobSkill a2;
        return a2.C;
    }

    public /* synthetic */ void setDuration(long a2) {
        a.E = a2;
    }

    public /* synthetic */ void setCoolTime(long a2) {
        a.g = a2;
    }

    private /* synthetic */ List<MapleMapObject> ALLATORIxDEMO(MapleMonster a2, MapleMapObjectType a3) {
        MobSkill a4;
        Rectangle rectangle = a4.ALLATORIxDEMO(a2.getPosition(), a2.isFacingLeft());
        ArrayList<MapleMapObjectType> arrayList = new ArrayList<MapleMapObjectType>();
        arrayList.add(a3);
        return a2.getMap().getMapObjectsInRect(rectangle, arrayList);
    }

    public /* synthetic */ void addSummons(List<Integer> a2) {
        a.K = a2;
    }

    private /* synthetic */ Rectangle ALLATORIxDEMO(Point a2, boolean a32) {
        Point point;
        Point a32;
        MobSkill a4;
        if (a32) {
            a32 = new Point(a4.a.x + a2.x, a4.a.y + a2.y);
            point = new Point(a4.d.x + a2.x, a4.d.y + a2.y);
        } else {
            point = new Point(a4.a.x * -1 + a2.x, a4.d.y + a2.y);
            a32 = new Point(a4.d.x * -1 + a2.x, a4.a.y + a2.y);
        }
        Point point2 = a32;
        return new Rectangle(point2.x, point2.y, point.x - a32.x, point.y - a32.y);
    }

    public /* synthetic */ int getLimit() {
        MobSkill a2;
        return a2.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean checkCurrentBuff(MapleCharacter a2, MapleMonster a3) {
        MobSkill a4;
        boolean bl = false;
        switch (a4.J) {
            case 100: 
            case 110: 
            case 150: {
                return a3.isBuffed(MonsterStatus.WEAPON_ATTACK_UP);
            }
            case 101: 
            case 111: 
            case 151: {
                return a3.isBuffed(MonsterStatus.WEAPON_DEFENSE_UP);
            }
            case 102: 
            case 112: 
            case 152: {
                return a3.isBuffed(MonsterStatus.MAGIC_ATTACK_UP);
            }
            case 103: 
            case 113: 
            case 153: {
                return a3.isBuffed(MonsterStatus.MAGIC_DEFENSE_UP);
            }
            case 140: 
            case 141: 
            case 142: 
            case 143: 
            case 144: 
            case 145: {
                if (a3.isBuffed(MonsterStatus.DAMAGE_IMMUNITY)) return true;
                if (a3.isBuffed(MonsterStatus.MAGIC_IMMUNITY)) return true;
                if (!a3.isBuffed(MonsterStatus.WEAPON_IMMUNITY)) return false;
                return true;
            }
            case 200: {
                if (a2.getMap().getNumMonsters() < a4.k) return false;
                return true;
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ int getByDisease(MapleBuffStat a2) {
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 1: {
                return 120;
            }
            case 2: {
                return 121;
            }
            case 3: {
                return 122;
            }
            case 4: {
                return 123;
            }
            case 5: {
                return 124;
            }
            case 6: {
                return 125;
            }
            case 7: {
                return 126;
            }
            case 8: {
                return 128;
            }
            case 9: {
                return 132;
            }
            case 10: {
                return 133;
            }
            case 11: {
                return 134;
            }
            case 12: {
                return 135;
            }
            case 13: {
                return 136;
            }
            case 14: {
                return 137;
            }
            case 15: {
                return 173;
            }
        }
        return 0;
    }

    public /* synthetic */ int getMpCon() {
        MobSkill a2;
        return a2.I;
    }

    public /* synthetic */ void setLtRb(Point a2, Point a3) {
        MobSkill a4;
        MobSkill mobSkill = a4;
        mobSkill.a = a2;
        mobSkill.d = a3;
    }

    public /* synthetic */ void setProp(float a2) {
        a.B = a2;
    }

    public /* synthetic */ void setMpCon(int a2) {
        a.I = a2;
    }

    public /* synthetic */ void setY(int a2) {
        a.e = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ MapleBuffStat getByMobSkill(int a2) {
        switch (a2) {
            case 120: {
                return MapleBuffStat.SEAL;
            }
            case 121: {
                return MapleBuffStat.DARKNESS;
            }
            case 122: {
                return MapleBuffStat.WEAKEN;
            }
            case 123: {
                return MapleBuffStat.STUN;
            }
            case 124: {
                return MapleBuffStat.CURSE;
            }
            case 125: {
                return MapleBuffStat.POISON;
            }
            case 126: {
                return MapleBuffStat.SLOW;
            }
            case 128: {
                return MapleBuffStat.SEDUCE;
            }
            case 132: {
                return MapleBuffStat.REVERSE_DIRECTION;
            }
            case 133: {
                return MapleBuffStat.ZOMBIFY;
            }
            case 134: {
                return MapleBuffStat.POTION;
            }
            case 135: {
                return MapleBuffStat.SHADOW;
            }
            case 136: {
                return MapleBuffStat.BLIND;
            }
            case 137: {
                return MapleBuffStat.FREEZE;
            }
            case 138: {
                return MapleBuffStat.DISABLE_POTENTIAL;
            }
            case 171: {
                return MapleBuffStat.CYGNUS_BOMB;
            }
            case 172: {
                return MapleBuffStat.MORPH;
            }
            case 173: {
                return MapleBuffStat.CYGNUS_TORNADO;
            }
            case 174: {
                return MapleBuffStat.LAPID_IFICATION;
            }
            case 175: {
                return MapleBuffStat.DEATHMARK;
            }
            case 177: {
                return MapleBuffStat.VENOMSNAKE;
            }
            case 181: {
                return MapleBuffStat.MAGNET;
            }
            case 184: {
                return MapleBuffStat.RETURN_TELEPORT;
            }
            case 799: {
                return MapleBuffStat.CAPTURE_FLAG;
            }
        }
        return null;
    }

    public /* synthetic */ boolean onlyOnce() {
        MobSkill a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void setLimit(short a2) {
        a.k = a2;
    }

    public /* synthetic */ int getSkillId() {
        MobSkill a2;
        return a2.J;
    }

    public /* synthetic */ List<Integer> getSummons() {
        MobSkill a2;
        return Collections.unmodifiableList(a2.K);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 2;
        int cfr_ignored_0 = 4 << 3 ^ 5;
        int n5 = n3;
        int n6 = 5 << 3 ^ 2;
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

    public /* synthetic */ long getCoolTime() {
        MobSkill a2;
        return a2.g;
    }

    public /* synthetic */ Point getRb() {
        MobSkill a2;
        return a2.d;
    }

    public /* synthetic */ void setHp(int a2) {
        a.C = a2;
    }
}

