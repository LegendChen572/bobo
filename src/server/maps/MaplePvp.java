/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.ISkill;
import client.MapleCharacter;
import client.MapleStat;
import client.SkillFactory;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.messages.CommandExecute;
import constants.GameSetConstants;
import constants.SkillConstants;
import handling.channel.handler.AttackInfo;
import handling.opcodes.MapleBuffStat;
import handling.world.World;
import handling.world.guild.MapleGuild;
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import server.MTSStorage;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.Randomizer;
import server.life.AbstractLoadedMapleLife;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMap;
import tools.MaplePacketCreator;

public class MaplePvp {
    private static /* synthetic */ int a;
    private static /* synthetic */ int K;
    private static /* synthetic */ int d;
    private static /* synthetic */ boolean ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean ALLATORIxDEMO(int a2) {
        switch (a2) {
            case 1111005: 
            case 1111006: 
            case 1211002: 
            case 1221011: 
            case 1311006: 
            case 2111002: 
            case 2111003: 
            case 2121001: 
            case 2121006: 
            case 2121007: 
            case 2201005: 
            case 2221001: 
            case 2221007: 
            case 2311004: 
            case 2321001: 
            case 2321008: 
            case 3101005: 
            case 3111003: 
            case 3111004: 
            case 3201005: 
            case 3211003: 
            case 3211004: 
            case 4121004: 
            case 4121008: 
            case 4211004: 
            case 4221004: 
            case 5221003: 
            case 9001001: 
            case 11111006: 
            case 12101006: 
            case 12111003: 
            case 12111005: 
            case 13111000: 
            case 14101006: 
            case 14111006: 
            case 21110006: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void checkAllSkills() {
        boolean bl = false;
        Iterator<ISkill> iterator = SkillFactory.getAllSkills().iterator();
        while (iterator.hasNext()) {
            int n2 = iterator.next().getId();
            if (n2 == 0) {
                bl = true;
                continue;
            }
            if (MaplePvp.l(n2)) {
                bl = true;
                continue;
            }
            if (!MaplePvp.ALLATORIxDEMO(n2)) continue;
            bl = true;
        }
    }

    public static /* synthetic */ boolean isSameGuild(MapleCharacter a2, MapleCharacter a3) {
        if (!GameSetConstants.PK_Guild) {
            return false;
        }
        boolean bl = false;
        if (a2.getGuild() != null && a3.getGuild() != null && a2.getGuildId() == a3.getGuildId()) {
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ boolean isSameEvent(MapleCharacter a2, MapleCharacter a3) {
        boolean bl = false;
        if (a2.getEventInstance() != null && a3.getEventInstance() != null && a2.getEventInstance() == a3.getEventInstance()) {
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ boolean isSameParty(MapleCharacter a2, MapleCharacter a3) {
        if (!GameSetConstants.PK_Party) {
            return false;
        }
        boolean bl = false;
        if (a2.getParty() != null && a3.getParty() != null && a2.getPartyId() == a3.getPartyId()) {
            bl = true;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean l(int a2) {
        switch (a2) {
            case 1001004: 
            case 1001005: 
            case 1111003: 
            case 1111004: 
            case 1111005: 
            case 1111006: 
            case 0x111AEE: 
            case 1121008: 
            case 1211002: 
            case 1221007: 
            case 1221009: 
            case 1311001: 
            case 1311002: 
            case 1311003: 
            case 1311004: 
            case 1311005: 
            case 1321003: 
            case 3101003: 
            case 3201003: 
            case 4001334: 
            case 4201005: 
            case 4221001: 
            case 5001001: 
            case 5001002: 
            case 5101002: 
            case 5101003: 
            case 5111002: 
            case 5121004: 
            case 5121007: 
            case 11001002: 
            case 11001003: 
            case 11111002: 
            case 11111003: 
            case 11111004: 
            case 15001001: 
            case 15001002: 
            case 15101003: 
            case 15101005: 
            case 15111004: 
            case 15111006: 
            case 21000002: 
            case 21100001: 
            case 21100002: 
            case 21110003: 
            case 21120005: {
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, MapleCharacter a3, MapleMap a42, AttackInfo a52) {
        void var5_30;
        int n2;
        Object object;
        K = 1;
        if (a3.isGM() && a3.isHidden()) {
            return;
        }
        AttackInfo attackInfo = a52;
        Object object2 = SkillFactory.getSkill(SkillConstants.getLinkedAranSkill(attackInfo.skill));
        int n3 = 100;
        if (attackInfo.skill > 0) {
            int n4 = a2.getSkillLevel((ISkill)object2);
            object = a52.getAttackEffect(a2, n4, (ISkill)object2);
            short s2 = ((MapleStatEffect)object).getDamage();
            int n6 = s2 + ((MapleStatEffect)object).getMatk();
            n6 = n6 + ((MapleStatEffect)object).getWatk();
            if (a52.skill == 3101005) {
                n2 = n6 + ((MapleStatEffect)object).getX();
            }
        }
        double d2 = (double)n2 / 100.0;
        switch (a52.skill) {
            case 3121004: 
            case 4121007: 
            case 13111002: 
            case 14111005: {
                d2 = 1.6;
                break;
            }
            case 5121004: {
                d2 = 1.85;
                break;
            }
            case 5221004: {
                d2 = 1.2;
                break;
            }
        }
        boolean bl = true;
        MapleCharacter mapleCharacter = a2;
        if (a2.isWarrior()) {
            int n7 = mapleCharacter.getStat().getTotalStr();
        } else {
            MapleCharacter mapleCharacter2 = a2;
            if (mapleCharacter.isMage()) {
                int n8 = mapleCharacter2.getStat().getTotalInt();
            } else {
                MapleCharacter mapleCharacter3 = a2;
                if (mapleCharacter2.isBowman()) {
                    int n9 = mapleCharacter3.getStat().getTotalDex();
                } else {
                    MapleCharacter mapleCharacter4 = a2;
                    if (mapleCharacter3.isThief()) {
                        int n10 = mapleCharacter4.getStat().getTotalLuk();
                    } else if (mapleCharacter4.isPirate()) {
                        if (a2.getJob() >= 510 && a2.getJob() <= 512) {
                            int n11 = a2.getStat().getTotalStr();
                        } else {
                            int n12 = a2.getStat().getTotalDex();
                        }
                    } else if (a2.getJob() == 900 || a2.getJob() == 800) {
                        int n14 = a2.getStat().getTotalStr() + a2.getStat().getTotalLuk() + a2.getStat().getTotalDex() + a2.getStat().getTotalInt();
                        n14 = n14 < 0 ? 10000 : n14;
                    }
                }
            }
        }
        K = (int)((double)K + (double)var5_30 * d2);
        switch (a52.skill) {
            case 5221007: {
                K /= a52.hits / 2;
                break;
            }
        }
        if (a2.getDebugMessage()) {
            double d3;
            String string;
            if (object2 != null) {
                string = object2.getName();
                d3 = d2;
            } else {
                string = "";
                d3 = d2;
            }
            a2.dropMessage("\u6700\u7d42\u50b7\u5bb3 " + K * a52.hits + " \u6280\u80fd " + string + "(" + d3 + "%) \u4e3b\u80fd\u529b\u503c:" + (int)var5_30 + " \u653b\u64ca\u6b21\u6578:" + a52.hits + "  \u50b7\u5bb3\u984d\u5916\u589e\u52a0 " + Math.abs((double)K / d2));
        }
        MapleCharacter mapleCharacter5 = a3;
        object2 = mapleCharacter5.getBuffedValue(MapleBuffStat.MAGIC_GUARD);
        Integer n15 = mapleCharacter5.getBuffedValue(MapleBuffStat.MESOGUARD);
        if (object2 != null) {
            int n16 = (int)((double)K / 0.5);
            K = (int)((double)K * 0.7);
            if (n16 > a3.getStat().getMp()) {
                K = (int)((double)K / 0.7);
                a3.cancelEffectFromBuffStat(MapleBuffStat.MAGIC_GUARD);
            } else {
                MapleCharacter mapleCharacter6 = a3;
                mapleCharacter6.setMp(mapleCharacter6.getStat().getMp() - n16);
                mapleCharacter6.updateSingleStat(MapleStat.MP, a3.getStat().getMp());
            }
        } else if (n15 != null) {
            int n17 = (int)((double)K * 0.75);
            K = (int)((double)K * 0.75);
            if (n17 > a3.getMeso()) {
                K = (int)((double)K / 0.75);
                a3.cancelEffectFromBuffStat(MapleBuffStat.MESOGUARD);
            } else {
                a3.gainMeso(-n17, false);
            }
        }
        Object object3 = MapleLifeFactory.getMonster(9001007);
        MapleCharacter mapleCharacter7 = a3;
        ((MapleMap)((Object)a42)).spawnMonsterOnGroundBelow((MapleMonster)object3, mapleCharacter7.getPosition());
        MapleCharacter mapleCharacter8 = mapleCharacter7;
        MapleCharacter mapleCharacter9 = mapleCharacter8;
        mapleCharacter9.getMap().broadcastMessage(a2, MaplePacketCreator.damageFriendlyMob((MapleMonster)object3, (K /= 3) * a52.hits, true), false);
        MapleCharacter mapleCharacter10 = mapleCharacter8;
        mapleCharacter9.getMap().broadcastMessage(mapleCharacter10, MaplePacketCreator.damagePlayer(mapleCharacter10.getId(), 0, K * a52.hits, ((AbstractLoadedMapleLife)object3).getId(), (byte)0, 0, 0, 0 != 0, 0, (byte)0, new Point((int)((AbstractMapleMapObject)object3).getPosition().getX(), (int)((AbstractMapleMapObject)object3).getPosition().getY()), (byte)0, 0, 0), false);
        if (!mapleCharacter10.isInvincible()) {
            mapleCharacter8.addHP(-K * a52.hits);
        }
        ((MapleMap)((Object)a42)).killMonster((MapleMonster)object3, a2, false, false, (byte)-1);
        if (a3.getStat().getHp() <= 0 && !a3.isAlive()) {
            short a52 = (int)Math.floor(Math.random() * 150.0 + 50.0);
            if (GameSetConstants.PK_GP && a2.isGuildPvPMap() && a2.getGuildId() != 0 && a2.getGuildId() != a3.getGuildId()) {
                try {
                    object3 = a2.getGuild();
                    if (object3 != null) {
                        Object object4 = object3;
                        ((MapleGuild)object4).gainGP(a52);
                        ((MapleGuild)object4).broadcast(MaplePacketCreator.serverNotice("[\u5bb6\u65cf\u69ae\u8b7d\u4fe1\u606f]\u65cf\u54e1\uff1a " + a2.getName() + " \u5728\u5bb6\u65cf\u722d\u9738\u4e2d\u70ba\u5bb6\u65cf\u8d0f\u5f97<" + a52 + ">GP\u9ede."));
                    }
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            if (GameSetConstants.PK_Exp) {
                a2.gainExp(a3.getExp() / a3.getLevel(), true, false, true);
            }
            a3.dropMessage(6, "\u7121\u60c5\u7684 " + a2.getName() + "\u6bba\u4e86\u4f60");
            MaplePvp.ALLATORIxDEMO(a42);
            if (GameSetConstants.PK_Meso) {
                int n18 = (int)Math.floor(Math.random() * 3000.0);
                if (a3.getMeso() >= n18) {
                    MapleCharacter mapleCharacter11 = a3;
                    mapleCharacter11.getMap().spawnMesoDrop(n18, a3.getPosition(), a3, a2, 0 != 0, (byte)0);
                    mapleCharacter11.gainMeso(-n18, true);
                    mapleCharacter11.getClient().sendPacket(MaplePacketCreator.getItemNotice("\u7121\u60c5\u7684" + a2.getName() + "\u6bba\u4e86\u4f60 \u4f60\u640d\u5931\u4e86" + n18 + "\u5143!"));
                } else {
                    a3.dropMessage(MTSStorage.ALLATORIxDEMO(";\u7ce7\u7d11\u8b7a\u542aA@\u60b4\u76e4\u694f\u5e03\u5dee\u7df3\u4e11\u8dd3\uff10\u8aab\u99b0\u4e6a\u96fe\u95eb\u301e"));
                    a2.dropMessage(CommandExecute.ALLATORIxDEMO("\u000e\u7c8a\u7d24\u8b17\u541f,u\u8aba\u4e58\u89f0\u51d8\u6be9\u5be6\u4ea7\uff59\u5c7c\u65ec\u6922\u5e36\u5d83\u8042\u7690\u3057"));
                }
            }
            if (GameSetConstants.PK_MP) {
                int n19 = (int)Math.floor(Math.random() * 10.0);
                if (a3.getCSPoints(2) >= n19) {
                    MapleCharacter mapleCharacter12 = a3;
                    mapleCharacter12.modifyCSPoints(2, -n19, true);
                    mapleCharacter12.getClient().sendPacket(MaplePacketCreator.getItemNotice("\u7121\u60c5\u7684" + a2.getName() + "\u6bba\u4e86\u4f60 \u4f60\u640d\u5931\u4e86" + n19 + "\u6953\u9ede!"));
                } else {
                    a3.dropMessage(MTSStorage.ALLATORIxDEMO(";\u7ce7\u7d11\u8b7a\u542aA@\u60b4\u76e4\u694f\u9ebe\u5dee\u7df3\u4e11\u8dd3\uff10\u8aab\u99b0\u4e6a\u96fe\u95eb\u301e"));
                    a2.dropMessage(CommandExecute.ALLATORIxDEMO("\u000e\u7c8a\u7d24\u8b17\u541f,u\u8aba\u4e58\u89f0\u51d8\u6be9\u5be6\u4ea7\uff59\u5c7c\u65ec\u6922\u9e8b\u5d83\u8042\u7690\u3057"));
                }
            }
            if (GameSetConstants.PK_Equip) {
                int n20 = (int)Math.floor(Math.random() * 2.0) + 1;
                int a42 = (int)Math.floor(Math.random() * 88.0) + 1;
                a52 = (short)a42;
                if (n20 == 1) {
                    IItem iItem;
                    if (!(a3.getInventory(MapleInventoryType.EQUIP).getItem((byte)a42) == null || (iItem = a3.getInventory(MapleInventoryType.EQUIP).getItem((byte)a42).copy()) == null || ItemFlag.LOCK.check(iItem.getFlag()) || MapleItemInformationProvider.getInstance().isCash(iItem.getItemId()) || ItemFlag.UNTRADEABLE.check(iItem.getFlag()) || iItem.getItemId() / 10000 == 114)) {
                        MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a52, (short)(true ? 1 : 0), true);
                        MapleCharacter mapleCharacter13 = a3;
                        a3.getMap().spawnItemDrop(mapleCharacter13, mapleCharacter13, iItem, mapleCharacter13.getPosition(), true, false);
                    }
                } else {
                    MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                    IItem iItem = a3.getInventory(MapleInventoryType.ETC).getItem((byte)a42);
                    if (iItem != null && !ItemFlag.LOCK.check(iItem.getFlag()) && !ItemFlag.UNTRADEABLE.check(iItem.getFlag())) {
                        object = iItem.copy();
                        MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.ETC, a52, (short)(true ? 1 : 0), true);
                        MapleCharacter mapleCharacter14 = a3;
                        a3.getMap().spawnItemDrop(mapleCharacter14, mapleCharacter14, mapleItemInformationProvider.getEquipById(object.getItemId()), mapleCharacter14.getPosition(), true, false);
                    }
                }
            }
            if (GameSetConstants.PK_Equip_ALL) {
                MapleInventory mapleInventory = a3.getInventory(MapleInventoryType.EQUIP);
                Collection<IItem> a42 = mapleInventory.list();
                for (IItem iItem : a42) {
                    int n21;
                    IItem iItem2;
                    if (iItem == null || (iItem2 = iItem.copy()) == null || (n21 = Randomizer.rand(1, 100)) > 3) continue;
                    MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, iItem2.getPosition(), (short)(true ? 1 : 0), true);
                    MapleCharacter mapleCharacter15 = a3;
                    a3.getMap().spawnItemDrop(mapleCharacter15, mapleCharacter15, iItem, mapleCharacter15.getPosition(), true, false);
                }
                mapleInventory = a3.getInventory(MapleInventoryType.EQUIPPED);
                a42 = mapleInventory.list();
                for (IItem iItem : a42) {
                    int n22;
                    IItem iItem3;
                    if (iItem == null || (iItem3 = iItem.copy()) == null || (n22 = Randomizer.rand(1, 100)) > 3) continue;
                    MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIPPED, iItem3.getPosition(), (short)(true ? 1 : 0), true);
                    MapleCharacter mapleCharacter16 = a3;
                    a3.getMap().spawnItemDrop(mapleCharacter16, mapleCharacter16, iItem, mapleCharacter16.getPosition(), true, false);
                }
            }
        }
    }

    public /* synthetic */ MaplePvp() {
        MaplePvp a2;
    }

    private static /* synthetic */ void ALLATORIxDEMO(AttackInfo a2) {
        if (a2.skill == 0) {
            K = 100;
            a = 130;
            d = 35;
            return;
        }
        if (MaplePvp.l(a2.skill)) {
            a = 130;
            d = 45;
            ALLATORIxDEMO = false;
            a = 130;
            d = 45;
            ALLATORIxDEMO = false;
            switch (a2.skill) {
                case 4201005: {
                    K = (int)Math.floor(Math.random() * 70.0 + 5.0);
                    return;
                }
                case 1121008: {
                    K = (int)Math.floor(Math.random() * 140.0 + 180.0);
                    d = 50;
                    return;
                }
                case 4221001: {
                    K = (int)Math.floor(Math.random() * 50.0 + 150.0);
                    return;
                }
                case 0x111AEE: 
                case 1221007: 
                case 1321003: {
                    double d2 = Math.random();
                    while (false) {
                    }
                    K = (int)Math.floor(d2 * 120.0 + 80.0);
                    return;
                }
            }
            K = (int)Math.floor(Math.random() * 350.0 + 250.0);
            return;
        }
        if (MaplePvp.H(a2.skill)) {
            a = 300;
            d = 40;
            ALLATORIxDEMO = false;
            switch (a2.skill) {
                case 4201005: {
                    K = (int)Math.floor(Math.random() * 70.0 + 5.0);
                    return;
                }
                case 4121007: {
                    K = (int)Math.floor(Math.random() * 45.0 + 15.0);
                    return;
                }
                case 2001005: 
                case 4001344: 
                case 12001003: {
                    double d3 = Math.random();
                    while (false) {
                    }
                    K = (int)Math.floor(d3 * 105.0 + 90.0);
                    return;
                }
                case 4221007: {
                    K = (int)Math.floor(Math.random() * 170.0 + 180.0);
                    return;
                }
                case 3111006: 
                case 3121004: 
                case 3211006: {
                    a = 450;
                    K = (int)Math.floor(Math.random() * 30.0 + 20.0);
                    return;
                }
                case 2121003: 
                case 2221003: {
                    K = (int)Math.floor(Math.random() * 300.0 + 300.0);
                    return;
                }
            }
            K = (int)Math.floor(Math.random() * 150.0 + 250.0);
            return;
        }
        if (MaplePvp.ALLATORIxDEMO(a2.skill)) {
            a = 350;
            d = 350;
            ALLATORIxDEMO = true;
            if (a2.skill == 2121001 || a2.skill == 2221001 || a2.skill == 2321001 || a2.skill == 2121006) {
                a = 175;
                d = 175;
                K = (int)Math.floor(Math.random() * 170.0 + 180.0);
                return;
            }
            K = (int)Math.floor(Math.random() * 400.0 + 300.0);
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = false;
    }

    public static /* synthetic */ boolean isSameAlliance(MapleCharacter a2, MapleCharacter a3) {
        if (!GameSetConstants.PK_Alliance) {
            return false;
        }
        boolean bl = false;
        if (a2.getGuild() != null && a3.getGuild() != null && a2.getGuild().getAllianceId() != 0 && a3.getGuild().getAllianceId() != 0 && a2.getGuild().getAllianceId() == a3.getGuild().getAllianceId()) {
            bl = true;
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ void ALLATORIxDEMO(MapleMap a2) {
        Iterator<MapleCharacter> iterator;
        MapleCharacter mapleCharacter2;
        if (!GameSetConstants.FACTION_SYSTEM) return;
        int n2 = 0;
        int n3 = 0;
        block8: for (MapleCharacter mapleCharacter2 : a2.getAllPlayersThreadsafe()) {
            int n4;
            block18: {
                String string;
                if (!mapleCharacter2.isAlive() || (string = mapleCharacter2.getFaction()).isEmpty()) continue;
                int n5 = -1;
                switch (string.hashCode()) {
                    case 1304174591: {
                        if (!string.equals(MTSStorage.ALLATORIxDEMO("\u3070\u2619\u6933\u90b6\u6d5e\u300d"))) break;
                        n4 = n5 = 0;
                        break block18;
                    }
                    case 1295927289: {
                        if (!string.equals(CommandExecute.ALLATORIxDEMO("\u3061\u2653\u6922\u6b36\u6d4f\u3044"))) break;
                        n5 = 1;
                    }
                }
                n4 = n5;
            }
            switch (n4) {
                case 0: {
                    ++n2;
                    continue block8;
                }
                case 1: {
                    ++n3;
                    continue block8;
                }
            }
        }
        if (n2 == 0 && n3 > 0) {
            iterator = a2.getAllPlayersThreadsafe().iterator();
            Iterator<MapleCharacter> iterator2 = iterator;
            while (iterator2.hasNext()) {
                mapleCharacter2 = iterator.next();
                if (mapleCharacter2.getFaction().equals(MTSStorage.ALLATORIxDEMO("\u3070\u261a\u6933\u6b7f\u6d5e\u300d"))) {
                    MapleCharacter mapleCharacter3 = mapleCharacter2;
                    mapleCharacter3.addFactionPoint(1);
                    mapleCharacter3.dropMessage(CommandExecute.ALLATORIxDEMO("\u60d9\u76d1\u95f1\u6d6b\u5759\u0005'\u0005\u4e5c\u7327\u5fe6\u5288\u5258y\u60d9\u5da7\u7303\u5fc2\u7a3c\u5253@\u9e8b"));
                }
                mapleCharacter2.changeMap(910000000);
                iterator2 = iterator;
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(MTSStorage.ALLATORIxDEMO("\u300c\u2666\u694f\u6b03\u6d22\u3071L6L\u95e0\u6d22\u9b45\u7231\u4e4d\u736e\u5ff7\u52c1\u52490\u600d\u5580A=")));
            if (!a2.getPvP()) return;
            a2.setPvP();
            return;
        } else {
            if (n3 != 0 || n2 <= 0) return;
            iterator = a2.getAllPlayersThreadsafe().iterator();
            Iterator<MapleCharacter> iterator3 = iterator;
            while (iterator3.hasNext()) {
                mapleCharacter2 = iterator.next();
                if (mapleCharacter2.getFaction().equals(CommandExecute.ALLATORIxDEMO("\u3061\u2650\u6922\u90ff\u6d4f\u3044"))) {
                    MapleCharacter mapleCharacter4 = mapleCharacter2;
                    mapleCharacter4.addFactionPoint(1);
                    mapleCharacter4.dropMessage(MTSStorage.ALLATORIxDEMO("\u60c8\u7698\u95e0\u6d22\u5748L6L\u4e4d\u736e\u5ff7\u52c1\u52490\u60c8\u5dee\u7312\u5f8b\u7a2d\u521aQ\u9ec2"));
                }
                mapleCharacter2.changeMap(910000000);
                iterator3 = iterator;
            }
            World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(CommandExecute.ALLATORIxDEMO("\u3045\u2674\u6906\u90db\u6d6b\u3060\u0005'\u0005\u95f1\u6d6b\u9b54\u7278\u4e5c\u7327\u5fe6\u5288\u5258y\u601c\u55c9Pt")));
            if (!a2.getPvP()) return;
            a2.setPvP();
        }
    }

    public static /* synthetic */ void doPvP(MapleCharacter a2, MapleMap a3, AttackInfo a4) {
        MaplePvp.ALLATORIxDEMO(a4);
        for (MapleCharacter mapleCharacter : a2.getMap().getNearestPvpChar(a2, a, d, a2.getMap().getCharacters())) {
            if (!mapleCharacter.isAlive() || MaplePvp.isSameParty(a2, mapleCharacter) || MaplePvp.isSameGuild(a2, mapleCharacter) || MaplePvp.isSameAlliance(a2, mapleCharacter) || MaplePvp.isSameEvent(a2, mapleCharacter)) continue;
            if (GameSetConstants.FACTION_SYSTEM) {
                if (!a3.getPvP() || mapleCharacter.getFaction().equals(a2.getFaction()) || a2.getFaction().isEmpty() || mapleCharacter.getFaction().isEmpty()) continue;
                MaplePvp.ALLATORIxDEMO(a2, mapleCharacter, a3, a4);
                continue;
            }
            MaplePvp.ALLATORIxDEMO(a2, mapleCharacter, a3, a4);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ boolean H(int a2) {
        switch (a2) {
            case 1000: 
            case 2001004: 
            case 2001005: 
            case 2101004: 
            case 2101005: 
            case 2111006: 
            case 2121003: 
            case 2201004: 
            case 2211002: 
            case 2211003: 
            case 2211006: 
            case 2221003: 
            case 2221006: 
            case 2301005: 
            case 2321007: 
            case 3001004: 
            case 3001005: 
            case 3101005: 
            case 3111003: 
            case 3111006: 
            case 3121003: 
            case 3121004: 
            case 3201005: 
            case 3211006: 
            case 3221001: 
            case 3221003: 
            case 3221007: 
            case 4001344: 
            case 4101005: 
            case 4111004: 
            case 4111005: 
            case 4121003: 
            case 4121007: 
            case 4211002: 
            case 4221003: 
            case 4221007: 
            case 5001003: 
            case 5111004: 
            case 5111006: 
            case 5121001: 
            case 5121005: 
            case 5201001: 
            case 5201002: 
            case 5201004: 
            case 5201006: 
            case 5210000: 
            case 5211004: 
            case 5211005: 
            case 5221004: 
            case 5221007: 
            case 5221008: 
            case 10001000: 
            case 11101004: 
            case 12001003: 
            case 12101002: 
            case 12111006: 
            case 13001003: 
            case 13101005: 
            case 13111001: 
            case 13111002: 
            case 13111006: 
            case 13111007: 
            case 14001004: 
            case 14110004: 
            case 14111001: 
            case 14111002: 
            case 14111005: 
            case 15111001: 
            case 15111003: 
            case 15111007: 
            case 20001000: 
            case 21100004: 
            case 21110004: {
                return true;
            }
        }
        return false;
    }
}

