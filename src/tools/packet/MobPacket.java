/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import server.life.MapleMonster;
import server.movement.LifeMovementFragment;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;

public class MobPacket {
    public static /* synthetic */ byte[] showBossHP(MapleMonster a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MapleMonster mapleMonster;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BOSS_ENV.getValue());
        int n2 = 5;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n2 = 6;
        }
        maplePacketLittleEndianWriter2.write(n2);
        maplePacketLittleEndianWriter2.writeInt(a2.getId());
        if (a2.getHp() > Integer.MAX_VALUE) {
            MapleMonster mapleMonster2 = a2;
            mapleMonster = mapleMonster2;
            maplePacketLittleEndianWriter2.writeInt((int)((double)mapleMonster2.getHp() / (double)a2.getMobMaxHp() * 2.147483647E9));
        } else {
            maplePacketLittleEndianWriter2.writeInt((int)a2.getHp());
            mapleMonster = a2;
        }
        if (mapleMonster.getMobMaxHp() > Integer.MAX_VALUE) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeInt(Integer.MAX_VALUE);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt((int)a2.getMobMaxHp());
        }
        maplePacketLittleEndianWriter.write(a2.getStats().getTagColor());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.write(a2.getStats().getTagBgColor());
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public /* synthetic */ MobPacket() {
        MobPacket a2;
    }

    public static /* synthetic */ byte[] killMonster(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.KILL_MONSTER.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] spawnFakeMonster(MapleMonster a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleMonster mapleMonster = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MapleMonster mapleMonster2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter7.writeShort(SendPacketOpcode.SPAWN_MONSTER_CONTROL.getValue());
        maplePacketLittleEndianWriter7.write(1);
        maplePacketLittleEndianWriter6.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter6.write(5);
        maplePacketLittleEndianWriter5.writeInt(a2.getId());
        MobPacket.addMonsterStatus(maplePacketLittleEndianWriter5, a2);
        maplePacketLittleEndianWriter.writeShort(mapleMonster2.getPosition().x);
        maplePacketLittleEndianWriter4.writeShort(mapleMonster2.getPosition().y);
        maplePacketLittleEndianWriter4.write(a2.getStance());
        maplePacketLittleEndianWriter.writeShort(mapleMonster.getFh());
        maplePacketLittleEndianWriter3.writeShort(mapleMonster.getFh());
        maplePacketLittleEndianWriter3.write(-2);
        maplePacketLittleEndianWriter2.write(a2.getCarnivalTeam());
        maplePacketLittleEndianWriter2.writeInt(0);
        if (a2.getId() / 10000 == 961) {
            maplePacketLittleEndianWriter.writeAsciiString("");
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] controlMonster(MapleMonster a2, boolean a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SPAWN_MONSTER_CONTROL.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? 2 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleMonster mapleMonster = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter4.write(1);
        maplePacketLittleEndianWriter.writeInt(mapleMonster.getId());
        MobPacket.addMonsterStatus(maplePacketLittleEndianWriter3, mapleMonster);
        MobPacket.addMonsterInformation(maplePacketLittleEndianWriter3, a2, a3, false, (byte)(a2.isFake() ? 1 : -1), 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] healMonster(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.DAMAGE_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(-a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] stopControllingMonster(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_MONSTER_CONTROL.getValue());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showMonsterHP(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_MONSTER_HP.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] itemBombAttack(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.TIME_BOMB_ATTACK.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void ProcessStatSet(MaplePacketLittleEndianWriter a2, List<MonsterStatusEffect> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MobPacket.EncodeTemporary(maplePacketLittleEndianWriter2, a3);
        maplePacketLittleEndianWriter2.writeShort(2);
        maplePacketLittleEndianWriter.write(1);
        maplePacketLittleEndianWriter.write(1);
    }

    public static /* synthetic */ byte[] talkMonster(int a2, int a3, String a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.TALK_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(500);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a3 <= 0 ? 0 : 1);
        maplePacketLittleEndianWriter.write(a4 == null || a4.length() <= 0 ? 0 : 1);
        if (a4 != null && a4.length() > 0) {
            maplePacketLittleEndianWriter.writeMapleAsciiString(a4);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeInt(1);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] damageMonster(int a2, long a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DAMAGE_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.write(0);
        if (a3 > Integer.MAX_VALUE) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(Integer.MAX_VALUE);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.writeInt((int)a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ void addMonsterStatus(MaplePacketLittleEndianWriter a2, MapleMonster a3) {
        if (GameSetConstants.MAPLE_VERSION == 75) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            maplePacketLittleEndianWriter2.write(0);
            maplePacketLittleEndianWriter2.writeShort(0);
            maplePacketLittleEndianWriter.write(8);
            maplePacketLittleEndianWriter.writeInt(0);
            return;
        }
        if (a3.getStati().size() <= 0) {
            a3.addEmpty();
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a2.write(a3.getChangedStats() != null);
            if (a3.getChangedStats() != null) {
                long l2 = a3.getChangedStats().hp;
                if (l2 <= 0L) {
                    l2 = a3.getStats().getHp();
                }
                int n2 = (int)Math.min(Integer.MAX_VALUE, l2);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                maplePacketLittleEndianWriter.writeInt(n2);
                MapleMonster mapleMonster = a3;
                maplePacketLittleEndianWriter.writeInt(a3.getChangedStats().mp > 0 ? mapleMonster.getChangedStats().mp : mapleMonster.getStats().getMp());
                MapleMonster mapleMonster2 = a3;
                a2.writeInt(a3.getChangedStats().exp > 0 ? mapleMonster2.getChangedStats().exp : mapleMonster2.getStats().getExp());
                MapleMonster mapleMonster3 = a3;
                a2.writeInt(a3.getChangedStats().watk > 0 ? mapleMonster3.getChangedStats().watk : mapleMonster3.getStats().getPhysicalAttack());
                MapleMonster mapleMonster4 = a3;
                a2.writeInt(a3.getChangedStats().matk > 0 ? mapleMonster4.getChangedStats().matk : mapleMonster4.getStats().getMagicAttack());
                MapleMonster mapleMonster5 = a3;
                a2.writeInt(a3.getChangedStats().PDRate > 0 ? mapleMonster5.getChangedStats().PDRate : (int)mapleMonster5.getStats().getPDRate());
                MapleMonster mapleMonster6 = a3;
                a2.writeInt(a3.getChangedStats().MDRate > 0 ? mapleMonster6.getChangedStats().MDRate : (int)mapleMonster6.getStats().getMDRate());
                MapleMonster mapleMonster7 = a3;
                a2.writeInt(a3.getChangedStats().acc > 0 ? mapleMonster7.getChangedStats().acc : mapleMonster7.getStats().getAcc());
                MapleMonster mapleMonster8 = a3;
                a2.writeInt(a3.getChangedStats().eva > 0 ? mapleMonster8.getChangedStats().eva : (int)mapleMonster8.getStats().getEva());
                MapleMonster mapleMonster9 = a3;
                a2.writeInt(a3.getChangedStats().pushed > 0 ? mapleMonster9.getChangedStats().pushed : mapleMonster9.getStats().getPushed());
                MapleMonster mapleMonster10 = a3;
                a2.writeInt(a3.getChangedStats().level > 0 ? mapleMonster10.getChangedStats().level : (int)mapleMonster10.getStats().getLevel());
            }
        }
        LinkedList<MonsterStatusEffect> linkedList = new LinkedList<MonsterStatusEffect>(a3.getStati().values());
        MobPacket.EncodeTemporary(a2, linkedList);
    }

    public static /* synthetic */ byte[] cancelMonsterStatus(MapleMonster a2, MonsterStatusEffect a3) {
        ArrayList<MonsterStatusEffect> arrayList;
        ArrayList<MonsterStatusEffect> arrayList2 = arrayList = new ArrayList<MonsterStatusEffect>();
        arrayList2.add(a3);
        return MobPacket.cancelMonsterStatus(a2, arrayList2);
    }

    public static /* synthetic */ void SingleProcessStatSet(MaplePacketLittleEndianWriter a2, MapleMonster a3, MonsterStatusEffect a4) {
        LinkedList<MonsterStatusEffect> linkedList = new LinkedList<MonsterStatusEffect>();
        linkedList.add(a4);
        MobPacket.ProcessStatSet(a2, a3, linkedList);
    }

    public static /* synthetic */ byte[] makeMonsterInvisible(MapleMonster a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_MONSTER_CONTROL.getValue());
        maplePacketLittleEndianWriter2.write(0);
        maplePacketLittleEndianWriter2.writeInt(a2.getObjectId());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void addMonsterInformation(MaplePacketLittleEndianWriter a2, MapleMonster a32, boolean a4, boolean a5, byte a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        block11: {
            block10: {
                block9: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
                    maplePacketLittleEndianWriter2.writePos(a32.getTruePosition());
                    maplePacketLittleEndianWriter2.write(a32.getStance());
                    if (GameSetConstants.MAPLE_VERSION >= 152 && (a32.getId() == 8910000 || a32.getId() == 8910100 || a32.getId() == 9990033)) {
                        a2.write(0);
                    }
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
                    MapleMonster mapleMonster = a32;
                    maplePacketLittleEndianWriter3.writeShort(mapleMonster.getFh());
                    maplePacketLittleEndianWriter3.writeShort(mapleMonster.getFh());
                    if (!a5) break block9;
                    byte by = a6;
                    a2.write(by);
                    if (by != -3 && a6 < 0) break block10;
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
                    maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                    maplePacketLittleEndianWriter4.writeInt(a7);
                    break block11;
                }
                a2.write(a4 ? -2 : (a32.isFake() ? -4 : -1));
            }
            maplePacketLittleEndianWriter = a2;
        }
        maplePacketLittleEndianWriter.write(a32.getCarnivalTeam());
        if (GameSetConstants.MAPLE_VERSION >= 148) {
            a2.writeInt(0);
        }
        a2.writeInt(0);
        if (GameSetConstants.MAPLE_VERSION >= 147 && (a32.getId() == 9300498 || a32.getId() == 9300507)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = a2;
            a2.writeInt(-2350);
            maplePacketLittleEndianWriter5.writeInt(-1750);
            maplePacketLittleEndianWriter5.writeInt(150);
            a2.writeInt(100);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = a2;
            a2.writeInt(0);
            maplePacketLittleEndianWriter6.writeInt(0);
            maplePacketLittleEndianWriter6.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a2.write(0);
        }
        if (a32.getId() / 10000 == 961) {
            a2.writeAsciiString("");
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = a2;
            maplePacketLittleEndianWriter8.writeInt(-1);
            maplePacketLittleEndianWriter8.writeInt(0);
            maplePacketLittleEndianWriter7.write(0);
            int a32 = 0;
            maplePacketLittleEndianWriter7.writeInt(0);
            if (a32 > 0) {
                do {
                    a2.writeInt(0);
                    a2.writeInt(0);
                } while (--a32 != 1);
            }
        }
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, Collection<MonsterStatusEffect> a3) {
        int[] arrn = new int[GameSetConstants.MAX_BUFFSTAT_MASK];
        a3 = a3.iterator();
        block0: while (true) {
            Object object = a3;
            while (object.hasNext()) {
                MonsterStatusEffect monsterStatusEffect = (MonsterStatusEffect)a3.next();
                if (monsterStatusEffect == null) continue block0;
                if (monsterStatusEffect.getStatus() == null) {
                    object = a3;
                    continue;
                }
                int n2 = monsterStatusEffect.getStatus().getPosition();
                arrn[n2] = arrn[n2] | monsterStatusEffect.getStatus().getValue();
                object = a3;
            }
            break;
        }
        int n3 = a3 = 0;
        while (n3 < arrn.length) {
            a2.writeInt(arrn[a3++]);
            n3 = a3;
        }
    }

    public static /* synthetic */ byte[] removeTalkMonster(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.REMOVE_TALK_MONSTER.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] applyMonsterStatus(MapleMonster a2, MonsterStatusEffect a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.APPLY_MONSTER_STATUS.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getObjectId());
        MobPacket.SingleProcessStatSet(maplePacketLittleEndianWriter2, a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void EncodeTemporary(MaplePacketLittleEndianWriter a2, List<MonsterStatusEffect> a3) {
        HashSet hashSet = new HashSet();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MobPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter, a3);
        MobPacket.EncodeStatusTemporary(maplePacketLittleEndianWriter, a3);
    }

    private static /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, List<LifeMovementFragment> a3) {
        List<LifeMovementFragment> list = a3;
        a2.write(list.size());
        Object object = a3 = list.iterator();
        while (object.hasNext()) {
            ((LifeMovementFragment)a3.next()).serialize(a2);
            object = a3;
        }
    }

    public static /* synthetic */ byte[] showMobSkillDelay(int a2, int a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.MOB_SKILL_DELAY.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a6);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] suckMonster(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.KILL_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.write(4);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ void ProcessStatSet(MaplePacketLittleEndianWriter a2, MapleMonster a3, List<MonsterStatusEffect> a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MobPacket.EncodeTemporary(maplePacketLittleEndianWriter2, a3, a4);
        maplePacketLittleEndianWriter2.writeShort(2);
        maplePacketLittleEndianWriter.write(2);
        maplePacketLittleEndianWriter.write(1);
    }

    public static /* synthetic */ byte[] applyMonsterStatus(MapleMonster a2, List<MonsterStatusEffect> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        if (a3.size() <= 0 || a3.get(0) == null) {
            return MaplePacketCreator.enableActions();
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.APPLY_MONSTER_STATUS.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            MobPacket.ProcessStatSet(maplePacketLittleEndianWriter4, a2, a3);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            MobPacket.ProcessStatSet(maplePacketLittleEndianWriter5, a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] spawnMonster(MapleMonster a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MapleMonster mapleMonster = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter.writeInt(mapleMonster.getId());
        MobPacket.addMonsterStatus(maplePacketLittleEndianWriter2, mapleMonster);
        MobPacket.addMonsterInformation(maplePacketLittleEndianWriter2, a2, true, true, (byte)a3, a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] makeMonsterReal(MapleMonster a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            return MobPacket.spawnMonster(a2, -1, 0);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MapleMonster mapleMonster = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SPAWN_MONSTER.getValue());
        maplePacketLittleEndianWriter6.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter6.write(1);
        maplePacketLittleEndianWriter5.writeInt(a2.getId());
        MobPacket.addMonsterStatus(maplePacketLittleEndianWriter5, a2);
        maplePacketLittleEndianWriter.writeShort(mapleMonster.getPosition().x);
        maplePacketLittleEndianWriter4.writeShort(mapleMonster.getPosition().y);
        maplePacketLittleEndianWriter4.write(a2.getStance());
        maplePacketLittleEndianWriter3.writeShort(0);
        maplePacketLittleEndianWriter3.writeShort(a2.getFh());
        maplePacketLittleEndianWriter2.writeShort(-1);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] moveMonsterResponse(int a2, short a3, int a4, boolean a5, int a6, int a7) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MOVE_MONSTER_RESPONSE.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeShort(a3);
        maplePacketLittleEndianWriter2.write(a5 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(a4);
        maplePacketLittleEndianWriter4.write(a6);
        maplePacketLittleEndianWriter4.write(a7);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ void EncodeStatusBuffTemporary(MaplePacketLittleEndianWriter a2, MonsterStatusEffect a3) {
        if (a3 != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
            MonsterStatusEffect monsterStatusEffect;
            boolean bl;
            boolean bl2 = bl = GameSetConstants.MAPLE_VERSION >= 139;
            if (bl) {
                MonsterStatusEffect monsterStatusEffect2 = a3;
                monsterStatusEffect = monsterStatusEffect2;
                a2.writeInt(monsterStatusEffect2.getX());
            } else {
                a2.writeShort(a3.getX());
                monsterStatusEffect = a3;
            }
            if (monsterStatusEffect.getMobSkill() != null) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeShort(a3.getMobSkill().getSkillId());
                maplePacketLittleEndianWriter2.writeShort(a3.getMobSkill().getSkillLevel());
            } else if (a3.getSkill() == 2211006 || a3.getSkill() == 2221003) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.writeInt(2201004);
            } else {
                a2.writeInt(a3.getSkill() > 0 ? a3.getSkill() : 0);
                maplePacketLittleEndianWriter = a2;
            }
            maplePacketLittleEndianWriter.writeShort((short)((a3.getCancelTask() - System.currentTimeMillis()) / 1000L));
        }
    }

    public static /* synthetic */ byte[] damageFriendlyMob(MapleMonster a2, long a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MapleMonster mapleMonster;
        MapleMonster mapleMonster2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DAMAGE_MONSTER.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getObjectId());
        maplePacketLittleEndianWriter3.write(a4 ? 1 : 2);
        if (a3 > Integer.MAX_VALUE) {
            mapleMonster2 = a2;
            maplePacketLittleEndianWriter2.writeInt(Integer.MAX_VALUE);
        } else {
            maplePacketLittleEndianWriter2.writeInt((int)a3);
            mapleMonster2 = a2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        if (mapleMonster2.getHp() > Integer.MAX_VALUE) {
            maplePacketLittleEndianWriter4.writeInt((int)((double)a2.getHp() / (double)a2.getMobMaxHp() * 2.147483647E9));
            mapleMonster = a2;
        } else {
            maplePacketLittleEndianWriter4.writeInt((int)a2.getHp());
            mapleMonster = a2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        if (mapleMonster.getMobMaxHp() > Integer.MAX_VALUE) {
            maplePacketLittleEndianWriter5.writeInt(Integer.MAX_VALUE);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            maplePacketLittleEndianWriter5.writeInt((int)a2.getMobMaxHp());
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    private static /* synthetic */ void H(MaplePacketLittleEndianWriter a2, Collection<MonsterStatusEffect> a3) {
        int[] arrn = new int[GameSetConstants.MAX_BUFFSTAT];
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            MonsterStatusEffect monsterStatusEffect = (MonsterStatusEffect)a3.next();
            object = a3;
            int n2 = monsterStatusEffect.getStatus().getPosition() - 1;
            arrn[n2] = arrn[n2] | monsterStatusEffect.getStatus().getValue();
        }
        int n3 = a3 = arrn.length;
        while (n3 >= 1) {
            a2.writeInt(arrn[--a3]);
            n3 = a3;
        }
    }

    public static /* synthetic */ byte[] moveMonster(boolean a2, int a3, int a42, int a5, int a6, int a7, Point a8, Point a9, List<LifeMovementFragment> a10, List<Integer> a11, List<Pair<Integer, Integer>> a12) {
        Object object;
        Object object2 = a9 = new MaplePacketLittleEndianWriter();
        ((MaplePacketLittleEndianWriter)object2).writeShort(SendPacketOpcode.MOVE_MONSTER.getValue());
        ((MaplePacketLittleEndianWriter)object2).writeInt(a7);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            ((MaplePacketLittleEndianWriter)a9).write(a2 ? 1 : 0);
            Object object3 = a9;
            object = object3;
            ((MaplePacketLittleEndianWriter)object3).write(a3);
        } else {
            if (GameSetConstants.MAPLE_VERSION != 75) {
                ((MaplePacketLittleEndianWriter)a9).write(0);
            }
            if (GameSetConstants.MAPLE_VERSION > 113) {
                ((MaplePacketLittleEndianWriter)a9).write(0);
            }
            ((MaplePacketLittleEndianWriter)a9).write(a2 ? 1 : 0);
            Object object4 = a9;
            object = object4;
            ((MaplePacketLittleEndianWriter)object4).write(a3);
        }
        ((MaplePacketLittleEndianWriter)object).write(a42);
        Object object5 = a9;
        ((MaplePacketLittleEndianWriter)object5).write(a5);
        ((MaplePacketLittleEndianWriter)object5).writeShort(a6);
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            ((MaplePacketLittleEndianWriter)a9).write(a12 == null ? 0 : a12.size());
            if (a12 != null) {
                Iterator<Pair<Integer, Integer>> iterator = a3 = a12.iterator();
                while (iterator.hasNext()) {
                    Pair<Integer, Integer> a42 = a3.next();
                    ((MaplePacketLittleEndianWriter)a9).writeShort((Integer)a42.left);
                    ((MaplePacketLittleEndianWriter)a9).writeShort((Integer)a42.right);
                    iterator = a3;
                }
            }
            ((MaplePacketLittleEndianWriter)a9).write(a11 == null ? 0 : a11.size());
            if (a11 != null) {
                Iterator<Integer> iterator = a3 = a11.iterator();
                while (iterator.hasNext()) {
                    Integer a42 = a3.next();
                    iterator = a3;
                    ((MaplePacketLittleEndianWriter)a9).writeShort(a42);
                }
            }
        } else if (GameSetConstants.MAPLE_VERSION > 113) {
            ((MaplePacketLittleEndianWriter)a9).writeInt(a12 == null ? 0 : a12.size());
            if (a12 != null) {
                Iterator<Pair<Integer, Integer>> iterator = a3 = a12.iterator();
                while (iterator.hasNext()) {
                    Pair<Integer, Integer> a42 = a3.next();
                    ((MaplePacketLittleEndianWriter)a9).writeInt((Integer)a42.left);
                    ((MaplePacketLittleEndianWriter)a9).writeInt((Integer)a42.right);
                    iterator = a3;
                }
            }
            ((MaplePacketLittleEndianWriter)a9).writeInt(a11 == null ? 0 : a11.size());
            if (a11 != null) {
                Iterator<Integer> iterator = a3 = a11.iterator();
                while (iterator.hasNext()) {
                    Integer a42 = a3.next();
                    iterator = a3;
                    ((MaplePacketLittleEndianWriter)a9).writeInt(a42);
                }
            }
        }
        ((MaplePacketLittleEndianWriter)a9).writePos(a8);
        if (GameSetConstants.MAPLE_VERSION >= 120) {
            Object object6 = a9;
            ((MaplePacketLittleEndianWriter)object6).writeShort(0);
            ((MaplePacketLittleEndianWriter)object6).writeShort(0);
        }
        Object object7 = a9;
        MobPacket.ALLATORIxDEMO((MaplePacketLittleEndianWriter)object7, a10);
        return ((MaplePacketLittleEndianWriter)object7).getPacket();
    }

    public static /* synthetic */ void EncodeStatusTemporary(MaplePacketLittleEndianWriter a2, List<MonsterStatusEffect> a32) {
        HashMap<MonsterStatus, MonsterStatusEffect> hashMap;
        HashMap<MonsterStatus, MonsterStatusEffect> hashMap2;
        HashMap<MonsterStatus, MonsterStatusEffect> hashMap3 = new HashMap<MonsterStatus, MonsterStatusEffect>();
        MonsterStatusEffect monsterStatusEffect = null;
        Object object = a32 = a32.iterator();
        while (object.hasNext()) {
            MonsterStatusEffect monsterStatusEffect2 = (MonsterStatusEffect)a32.next();
            if (monsterStatusEffect2 == null) {
                object = a32;
                continue;
            }
            hashMap3.put(monsterStatusEffect2.getStatus(), monsterStatusEffect2);
            object = a32;
        }
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.WATK);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.WDEF);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MATK);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MDEF);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.ACC);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.AVOID);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.SPEED);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.STUN);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.FREEZE);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.POISON);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.SEAL);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        if (MonsterStatus.DARKNESS.getIDAvalue() == 11) {
            monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.DARKNESS);
            MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        }
        if (MonsterStatus.DARKNESS.getIDAvalue() == 12 && hashMap3.get((Object)MonsterStatus.DARKNESS) != null) {
            monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.DARKNESS);
            hashMap2 = hashMap3;
            MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        } else {
            monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.WEAPON_ATTACK_UP);
            hashMap2 = hashMap3;
            MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        }
        monsterStatusEffect = (MonsterStatusEffect)hashMap2.get((Object)MonsterStatus.WEAPON_DEFENSE_UP);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MAGIC_ATTACK_UP);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MAGIC_DEFENSE_UP);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.WEAPON_IMMUNITY);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MAGIC_IMMUNITY);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.DOOM);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.SHADOW_WEB);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.DAMAGE_IMMUNITY);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.NINJA_AMBUSH);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.VENOMOUS_WEAPON);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        if (MonsterStatus.DARKNESS.getIDAvalue() == 25) {
            monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.DARKNESS);
            hashMap = hashMap3;
            MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        } else {
            monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.BLIND);
            hashMap = hashMap3;
            MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        }
        monsterStatusEffect = (MonsterStatusEffect)hashMap.get((Object)MonsterStatus.SEAL_SKILL);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.HYPNOTIZE);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.WEAPON_DAMAGE_REFLECT);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MAGIC_DAMAGE_REFLECT);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBS_32);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.NEUTRALISE);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.IMPRINT);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MONSTER_BOMB);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        if (GameSetConstants.MAPLE_VERSION >= 118) {
            monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.SHOWDOWN);
            MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        }
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MAGIC_CRASH);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.DANAGED_ELEM_ATTR);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.INVINCIBLE);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_39);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_40);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_41);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_42);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_43);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_44);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_45);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.FATALITY);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.EXPLOSION);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        monsterStatusEffect = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.MBUFF_48);
        MobPacket.EncodeStatusBuffTemporary(a2, monsterStatusEffect);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (hashMap3.containsKey((Object)MonsterStatus.EMPTY)) {
                int n2 = a32 = 0;
                a2.write(n2);
                if (n2 > 0) {
                    int n3;
                    int n4 = n3 = 0;
                    while (n4 < a32) {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                        int n5 = a32;
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
                        int n6 = a32;
                        a2.writeInt(n6);
                        maplePacketLittleEndianWriter2.writeInt(n6);
                        maplePacketLittleEndianWriter2.writeInt(a32);
                        a2.writeInt(n5);
                        maplePacketLittleEndianWriter.writeInt(n5);
                        maplePacketLittleEndianWriter.writeInt(a32);
                        n4 = ++n3;
                    }
                }
            }
        } else if (hashMap3.containsKey((Object)MonsterStatus.EMPTY)) {
            int n7 = a32 = 0;
            a2.writeInt(n7);
            if (n7 > 0) {
                int n8;
                int n9 = n8 = 0;
                while (n9 < a32) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    int n10 = a32;
                    a2.writeInt(n10);
                    maplePacketLittleEndianWriter.writeInt(n10);
                    maplePacketLittleEndianWriter.writeInt(a32);
                    n9 = ++n8;
                }
            }
        }
        if (hashMap3.containsKey((Object)MonsterStatus.WEAPON_DAMAGE_REFLECT)) {
            a2.writeInt(0);
        }
        if (hashMap3.containsKey((Object)MonsterStatus.MAGIC_DAMAGE_REFLECT)) {
            a2.writeInt(0);
        }
        if (hashMap3.containsKey((Object)MonsterStatus.WEAPON_DAMAGE_REFLECT) || hashMap3.containsKey((Object)MonsterStatus.MAGIC_DAMAGE_REFLECT)) {
            a2.writeInt(0);
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                a2.writeInt(0);
            }
        }
        if (hashMap3.containsKey((Object)MonsterStatus.SUMMON)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.write(0);
            maplePacketLittleEndianWriter.write(0);
        }
        if (hashMap3.containsKey((Object)MonsterStatus.EXCHANGE_ATTACK)) {
            a2.write(((MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.EXCHANGE_ATTACK)).getX());
        }
        if (hashMap3.containsKey((Object)MonsterStatus.MBUFF_42)) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.writeInt(0);
            maplePacketLittleEndianWriter.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            if (hashMap3.containsKey((Object)MonsterStatus.FATALITY)) {
                MonsterStatusEffect a32 = (MonsterStatusEffect)hashMap3.get((Object)MonsterStatus.FATALITY);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                a2.writeInt(a32.getFromID());
                maplePacketLittleEndianWriter.writeInt(0);
                maplePacketLittleEndianWriter.writeInt(a32.getFromCharacter() == null ? a32.getX() : 2 * (a32.getFromCharacter().getSkillLevel(a32.getSkill()) / 3));
                a2.writeInt(0);
            }
            if (hashMap3.containsKey((Object)MonsterStatus.EXPLOSION)) {
                a2.writeInt(0);
            }
        }
    }

    public static /* synthetic */ byte[] makeMonsterEffect(MapleMonster a2, int a3) {
        return MobPacket.spawnMonster(a2, a3, 0);
    }

    public static /* synthetic */ byte[] showBossHP(int a2, long a3, long a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        long l2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.BOSS_ENV.getValue());
        int n2 = 5;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n2 = 6;
        }
        maplePacketLittleEndianWriter2.write(n2);
        maplePacketLittleEndianWriter2.writeInt(a2);
        if (a3 > Integer.MAX_VALUE) {
            l2 = a4;
            maplePacketLittleEndianWriter2.writeInt((int)((double)a3 / (double)a4 * 2.147483647E9));
        } else {
            maplePacketLittleEndianWriter2.writeInt((int)(a3 <= 0L ? -1L : a3));
            l2 = a4;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
        if (l2 > Integer.MAX_VALUE) {
            maplePacketLittleEndianWriter3.writeInt(Integer.MAX_VALUE);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            maplePacketLittleEndianWriter3.writeInt((int)a4);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.write(6);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter4.write(5);
        return maplePacketLittleEndianWriter4.getPacket();
    }

    public static /* synthetic */ byte[] makeMonsterFake(MapleMonster a2) {
        return MobPacket.spawnMonster(a2, -4, 0);
    }

    public static /* synthetic */ byte[] cancelMonsterStatus135(MapleMonster a2, List<MonsterStatusEffect> a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.CANCEL_MONSTER_STATUS.getValue());
        maplePacketLittleEndianWriter4.writeInt(a2.getObjectId());
        MobPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter3, a3);
        maplePacketLittleEndianWriter3.write(2);
        maplePacketLittleEndianWriter2.writeZeroBytes(30);
        maplePacketLittleEndianWriter2.write(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] cancelMonsterStatus(MapleMonster a2, List<MonsterStatusEffect> a32) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            return MobPacket.cancelMonsterStatus135(a2, a32);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CANCEL_MONSTER_STATUS.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getObjectId());
        MobPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter2, a32);
        if (false) {
            int n2;
            int a32 = 0;
            maplePacketLittleEndianWriter.writeInt(a32);
            int n3 = n2 = 0;
            while (n3 < a32) {
                maplePacketLittleEndianWriter.writeInt(0);
                n3 = ++n2;
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeInt(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ void EncodeTemporary(MaplePacketLittleEndianWriter a2, MapleMonster a3, List<MonsterStatusEffect> a4) {
        a3 = new HashSet();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MobPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter, a4);
        MobPacket.EncodeStatusTemporary(maplePacketLittleEndianWriter, a4);
    }

    public static /* synthetic */ void SingleProcessStatSet(MaplePacketLittleEndianWriter a2, MonsterStatusEffect a3) {
        LinkedList<MonsterStatusEffect> linkedList = new LinkedList<MonsterStatusEffect>();
        linkedList.add(a3);
        MobPacket.ProcessStatSet(a2, linkedList);
    }
}

