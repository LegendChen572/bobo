/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5976\u8336\u8c37
 *  client.messages.commands.player.\u6070\u6070\u8c37
 */
package server.life;

import client.MapleCharacter;
import client.SkillFactory;
import client.messages.commands.player.\u5976\u8336\u8c37;
import client.messages.commands.player.\u6070\u6070\u8c37;
import constants.ItemConstants;
import constants.MobConstants;
import handling.channel.handler.InventoryHandler;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MobNameData;
import server.life.OverrideMonsterStats;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMapItem;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleMist;
import tools.MaplePacketCreator;
import tools.packet.MobPacket;

public class MapleMonsterPet
extends MapleMonster {
    public static final /* synthetic */ boolean d = false;
    public static /* synthetic */ boolean ALLATORIxDEMO;
    public static final /* synthetic */ int B = 2000;
    public static final /* synthetic */ int k = 1000;
    public /* synthetic */ int a;
    public /* synthetic */ MapleCharacter K;

    public /* synthetic */ void giveSkill(MapleMonsterPetSkill a2) {
        a.a = a2.getSkillId();
    }

    public /* synthetic */ boolean hasSkill(MapleMonsterPetSkill a2) {
        MapleMonsterPet a3;
        return a3.a == a2.getSkillId();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean BanMonsterPetMap(int a2) {
        boolean bl = false;
        switch (a2) {
            case 109010000: 
            case 910000000: {
                return true;
            }
        }
        return bl;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = false;
    }

    public /* synthetic */ void healHp() {
        MapleMonsterPet a2;
        if (!a2.K.isAlive()) {
            return;
        }
        if (a2.K.getMaxHp() != a2.K.getHp() || a2.K.getMaxMp() != a2.K.getMp()) {
            MapleMonsterPet mapleMonsterPet = a2;
            int n2 = mapleMonsterPet.K.getMonsterPet(2);
            n2 = mapleMonsterPet.K.getMaxHp() / 400 * n2;
            MapleMonsterPet mapleMonsterPet2 = a2;
            n2 = Math.min(n2, a2.K.getMaxHp() - mapleMonsterPet2.K.getHp());
            mapleMonsterPet2.K.addHP(n2);
            mapleMonsterPet.K.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(2301002, 2, a2.K.getLevel(), 1));
            MapleMonsterPet mapleMonsterPet3 = a2;
            mapleMonsterPet.K.getMap().broadcastMessage(mapleMonsterPet3.K, MaplePacketCreator.showBuffEffect(mapleMonsterPet3.K.getId(), 2301002, 2, a2.K.getLevel(), 1), false);
        }
    }

    public /* synthetic */ void setSkills(int a2) {
        a.a = a2;
    }

    public /* synthetic */ void healMp() {
        MapleMonsterPet a2;
        if (a2.K.getMaxHp() != a2.K.getHp() || a2.K.getMaxMp() != a2.K.getMp()) {
            MapleMonsterPet mapleMonsterPet = a2;
            int n2 = mapleMonsterPet.K.getMonsterPet(2);
            n2 = mapleMonsterPet.K.getMaxMp() / 400 * n2;
            MapleMonsterPet mapleMonsterPet2 = a2;
            n2 = Math.min(n2, a2.K.getMaxMp() - mapleMonsterPet2.K.getMp());
            mapleMonsterPet2.K.addMP(n2);
            mapleMonsterPet.K.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(2301002, 2, a2.K.getLevel(), 1));
            MapleMonsterPet mapleMonsterPet3 = a2;
            mapleMonsterPet.K.getMap().broadcastMessage(mapleMonsterPet3.K, MaplePacketCreator.showBuffEffect(mapleMonsterPet3.K.getId(), 2301002, 2, a2.K.getLevel(), 1), false);
        }
    }

    public /* synthetic */ MapleMonsterPet(int a22, MapleCharacter a3) {
        super(MapleLifeFactory.getMonster(a22));
        MapleMonsterPet a4;
        a4.a = 0;
        if (a3.getMonsterPet() == null || ALLATORIxDEMO) {
            OverrideMonsterStats a22 = new OverrideMonsterStats();
            MapleCharacter mapleCharacter = a3;
            int n2 = mapleCharacter.getMonsterPet(2);
            n2 = 2000 + 1000 * n2 / 4;
            OverrideMonsterStats overrideMonsterStats = a22;
            overrideMonsterStats.setOHp(n2);
            overrideMonsterStats.setOMp(0);
            a22.setOExp(0);
            MapleMonsterPet mapleMonsterPet = a4;
            MapleMonsterPet mapleMonsterPet2 = a4;
            MapleMonsterPet mapleMonsterPet3 = a4;
            a4.K = a3;
            mapleMonsterPet3.setHp(n2);
            a4.disableDrops();
            mapleMonsterPet3.setMonsterPet();
            mapleMonsterPet2.getStats().setNoSkills();
            mapleMonsterPet2.disableRevives();
            mapleMonsterPet2.setOverrideStats(a22);
            MapleMonsterPet mapleMonsterPet4 = a4;
            mapleMonsterPet.K.getMap().spawnFakeMonsterOnGroundBelow(mapleMonsterPet4, mapleMonsterPet4.K.getPosition());
            mapleMonsterPet.switchController(mapleMonsterPet4.K, true);
            mapleCharacter.setMonsterPet(a4);
            ALLATORIxDEMO = false;
        }
    }

    public /* synthetic */ void \u6703\u5fc3\u4e4b\u773cBUFF() {
        MapleMonsterPet a2;
        a2.giveBuff(3121002);
    }

    public /* synthetic */ void \u901f\u5ea6\u6fc0\u767cBUFF() {
        MapleMonsterPet a2;
        a2.giveBuff(4101004);
    }

    public /* synthetic */ void \u6953\u8449\u795d\u798fBUFF() {
        MapleMonsterPet a2;
        a2.giveBuff(1121000);
    }

    public /* synthetic */ void itemvac(MapleMonsterPet a2, int a322) {
        if (!MapleMonsterPet.BanMonsterPetMap(((MapleMonster)((Object)a2)).getMap().getId())) {
            int n2 = a322;
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.ITEM;
            for (MapleMapObject a322 : ((MapleMonster)((Object)a2)).getMap().getMapObjectsInRange(((AbstractMapleMapObject)((Object)a2)).getPosition(), n2 * n2, Arrays.asList(arrmapleMapObjectType))) {
                MapleMonsterPet a4;
                MapleMapItem mapleMapItem = (MapleMapItem)a322;
                Object object = mapleMapItem.getLock();
                if (ItemConstants.isMonsterCard(mapleMapItem.getItemId())) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (mapleMapItem.isPickedUp()) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.getInventoryFull());
                    return;
                }
                if (mapleMapItem.getOwner() != a4.K.getId() && mapleMapItem.isPlayerDrop()) {
                    return;
                }
                if (mapleMapItem.getOwner() != a4.K.getId() && (!mapleMapItem.isPlayerDrop() && mapleMapItem.getDropType() == 0 || mapleMapItem.isPlayerDrop() && a4.K.getMap().getEverlast())) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (!(mapleMapItem.isPlayerDrop() || mapleMapItem.getDropType() != 1 || mapleMapItem.getOwner() == a4.K.getId() || a4.K.getParty() != null && a4.K.getParty().getMemberById(mapleMapItem.getOwner()) != null)) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (mapleMapItem.isPlayerDrop() && mapleMapItem.getDropType() == 2 && mapleMapItem.getOwner() == a4.K.getId()) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (a4.K.getTrade() != null) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (mapleMapItem.getMeso() > 0) {
                    MapleMonsterPet mapleMonsterPet;
                    if (a4.K.getParty() != null && mapleMapItem.getOwner() != a4.K.getId()) {
                        object = new LinkedList();
                        int n3 = mapleMapItem.getMeso() * 40 / 100;
                        for (MaplePartyCharacter maplePartyCharacter : a4.K.getParty().getMembers()) {
                            MapleCharacter mapleCharacter = a4.K.getMap().getCharacterById(maplePartyCharacter.getId());
                            if (mapleCharacter == null || mapleCharacter.getId() == a4.K.getId()) continue;
                            object.add(mapleCharacter);
                        }
                        Iterator<MaplePartyCharacter> iterator = object.iterator();
                        Iterator<Object> iterator2 = iterator;
                        while (iterator2.hasNext()) {
                            MapleCharacter mapleCharacter;
                            MapleCharacter mapleCharacter2 = mapleCharacter = (MapleCharacter)((Object)iterator.next());
                            mapleCharacter2.gainMeso(n3 / object.size() + (mapleCharacter2.getStat().hasPartyBonus ? (int)((double)mapleMapItem.getMeso() / 20.0) : 0), true);
                            iterator2 = iterator;
                        }
                        MapleMonsterPet mapleMonsterPet2 = a4;
                        mapleMonsterPet = mapleMonsterPet2;
                        mapleMonsterPet2.K.gainMeso(mapleMapItem.getMeso() - n3, true);
                    } else {
                        MapleMonsterPet mapleMonsterPet3 = a4;
                        mapleMonsterPet = mapleMonsterPet3;
                        mapleMonsterPet3.K.gainMeso(mapleMapItem.getMeso(), true);
                    }
                    InventoryHandler.removeItem(mapleMonsterPet.K, mapleMapItem, a322);
                    continue;
                }
                if (MapleItemInformationProvider.getInstance().isPickupBlocked(mapleMapItem.getItemId()) || mapleMapItem.getItemId() / 10000 == 291) {
                    a4.K.getClient().sendPacket(MaplePacketCreator.enableActions());
                    continue;
                }
                if (InventoryHandler.useItem(a4.K.getClient(), mapleMapItem.getItemId())) {
                    InventoryHandler.removeItem(a4.K, mapleMapItem, a322);
                    continue;
                }
                MapleMonsterPet mapleMonsterPet = a4;
                if (ItemConstants.getSpecialItem(mapleMapItem.getItemId(), a4.K)) {
                    InventoryHandler.removeItem(mapleMonsterPet.K, mapleMapItem, a322);
                    MapleMonsterPet mapleMonsterPet4 = a4;
                    mapleMonsterPet4.K.getClient().sendPacket(MaplePacketCreator.getInventoryFull());
                    mapleMonsterPet4.K.getClient().sendPacket(MaplePacketCreator.getShowInventoryFull());
                    continue;
                }
                if (!MapleInventoryManipulator.checkSpace(mapleMonsterPet.K.getClient(), mapleMapItem.getItemId(), mapleMapItem.getItem().getQuantity(), mapleMapItem.getItem().getOwner())) continue;
                MapleMonsterPet mapleMonsterPet5 = a4;
                InventoryHandler.removeItem(mapleMonsterPet5.K, mapleMapItem, a322);
                MapleInventoryManipulator.addFromDrop(mapleMonsterPet5.K.getClient(), mapleMapItem.getItem(), true, mapleMapItem.getDropper() instanceof MapleMonster, true);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void doAction() {
        MapleMonsterPet a2;
        MapleMonsterPet mapleMonsterPet = a2;
        if (!mapleMonsterPet.isAlive()) {
            mapleMonsterPet.getMap().killMonster(mapleMonsterPet, null, false);
            MapleMonsterPet mapleMonsterPet2 = a2;
            mapleMonsterPet2.K.dropMessage(\u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u60eb\u76ea\u6069\u7207\u5bb6\u7207\u5db1\u56b0\u5bf5O\u8cff\u5fad\u6393\u91fcy\u63be\u5304\u6044\u722a\u7b27\u7d59\u5381\u628a\u9519\u6069\u7207\u4f3c\u7546\u6601\u95fd\u54a5O"));
            mapleMonsterPet2.K.setMonsterPet(null);
            return;
        }
        mapleMonsterPet.damage(a2.K, Randomizer.nextInt(200), true);
        int n2 = 0;
        try {
            if (mapleMonsterPet.getMap() != a2.K.getMap() || mapleMonsterPet.getPosition().distance(a2.K.getPosition()) > 350.0) {
                MapleMonsterPet mapleMonsterPet3 = new MapleMonsterPet(mapleMonsterPet.getId(), a2.K);
                MapleMonsterPet mapleMonsterPet4 = mapleMonsterPet;
                mapleMonsterPet3.setHp(mapleMonsterPet.getHp());
                mapleMonsterPet3.a = mapleMonsterPet4.a;
                mapleMonsterPet4.getMap().killMonster(mapleMonsterPet, null, false);
                ALLATORIxDEMO = true;
                return;
            }
            if (Randomizer.nextDouble() < 0.3) {
                int n3;
                switch (1.ALLATORIxDEMO[MapleMonsterPetSkill.getById(a2.a).ordinal()]) {
                    case 1: {
                        a2.poison(mapleMonsterPet, 150);
                        n3 = n2;
                        break;
                    }
                    case 2: {
                        a2.healHp();
                        n3 = n2;
                        break;
                    }
                    case 3: {
                        a2.healMp();
                        n3 = n2;
                        break;
                    }
                    case 4: {
                        a2.\u795e\u8056\u4e4b\u706bBUFF();
                        n3 = n2;
                        break;
                    }
                    case 5: {
                        a2.\u6703\u5fc3\u4e4b\u773cBUFF();
                        n3 = n2;
                        break;
                    }
                    case 6: {
                        a2.\u901f\u5ea6\u6fc0\u767cBUFF();
                        n3 = n2;
                        break;
                    }
                    case 7: {
                        a2.\u6953\u8449\u795d\u798fBUFF();
                        n3 = n2;
                        break;
                    }
                    case 8: {
                        a2.\u795e\u8056\u7948\u79b1BUFF();
                        n3 = n2;
                        break;
                    }
                    case 9: {
                        a2.itemvac(mapleMonsterPet, 350);
                        n3 = n2;
                        break;
                    }
                    case 10: {
                        a2.itemvac(mapleMonsterPet, 1000);
                        n3 = n2;
                        break;
                    }
                    case 11: {
                        a2.itemvac(mapleMonsterPet, 5000);
                        n3 = n2;
                        break;
                    }
                    default: {
                        n3 = n2;
                    }
                }
                n2 = n3 + Randomizer.nextInt(300);
            }
            if (n2 <= 0) return;
            MapleMonsterPet mapleMonsterPet5 = mapleMonsterPet;
            mapleMonsterPet5.getMap().broadcastMessage(a2.K, MobPacket.damageMonster(mapleMonsterPet.getObjectId(), n2), true);
            mapleMonsterPet5.damage(a2.K, n2, true);
            return;
        }
        catch (Exception exception) {
            System.out.println("bug:" + exception);
            MapleMonsterPet mapleMonsterPet6 = a2;
            mapleMonsterPet.getMap().killMonster(mapleMonsterPet, mapleMonsterPet6.K, false);
            mapleMonsterPet6.K.setMonsterPet(null);
            return;
        }
    }

    public /* synthetic */ void \u795e\u8056\u7948\u79b1BUFF() {
        MapleMonsterPet a2;
        a2.giveBuff(2311003);
    }

    public /* synthetic */ void giveBuff(int a2) {
        MapleMonsterPet a3;
        if (!a3.K.isActiveBuffedValue(a2)) {
            int n2 = Math.max(a3.K.getMonsterPet(2) * 3 / 20, 1);
            SkillFactory.getSkill(a2).getEffect(n2).applyTo(a3.K);
            MapleMonsterPet mapleMonsterPet = a3;
            mapleMonsterPet.K.getClient().sendPacket(MaplePacketCreator.showOwnBuffEffect(a2, 2, a3.K.getLevel(), n2));
            MapleMonsterPet mapleMonsterPet2 = a3;
            mapleMonsterPet.K.getMap().broadcastMessage(mapleMonsterPet2.K, MaplePacketCreator.showBuffEffect(mapleMonsterPet2.K.getId(), a2, 2, a3.K.getLevel(), n2), false);
        }
    }

    public /* synthetic */ void \u795e\u8056\u4e4b\u706bBUFF() {
        MapleMonsterPet a2;
        a2.giveBuff(1301007);
    }

    public /* synthetic */ void poison(MapleMonsterPet a2, int a322) {
        int n2 = 0;
        int n3 = a322;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        for (MapleMapObject object : a2.getMap().getMapObjectsInRange(a2.getPosition(), n3 * n3, Arrays.asList(arrmapleMapObjectType))) {
            MapleMonster mapleMonster = (MapleMonster)object;
            if (mapleMonster.isFake() || mapleMonster == a2) continue;
            n2 = 1;
        }
        if (n2 != 0) {
            MapleMonsterPet a4;
            int n4 = a322;
            Rectangle rectangle = new Rectangle(a2.getPosition().x, a2.getPosition().y - 50, n4, n4);
            MapleMonsterPet mapleMonsterPet = a2;
            mapleMonsterPet.getMap().spawnMist(new MapleMist(rectangle, a4.K), 5000, true);
            int n5 = a322;
            MapleMapObjectType[] arrmapleMapObjectType2 = new MapleMapObjectType[1];
            arrmapleMapObjectType2[0] = MapleMapObjectType.MONSTER;
            for (MapleMapObject mapleMapObject : mapleMonsterPet.getMap().getMapObjectsInRange(a2.getPosition(), n5 * n5, Arrays.asList(arrmapleMapObjectType2))) {
                MapleMonster a322 = (MapleMonster)mapleMapObject;
                if (a322.isFake() || a322 == a2 || MobConstants.isReincarnationMob(a322.getId())) continue;
                MapleMonsterPet mapleMonsterPet2 = a4;
                n2 = mapleMonsterPet2.K.getMonsterPet(2);
                double d2 = 1 + n2 / 100;
                d2 = (double)Randomizer.rand((int)mapleMonsterPet2.K.getStat().getCurrentMaxBaseDamage() / 2, (int)a4.K.getStat().getCurrentMaxBaseDamage()) * d2;
                MapleMonster mapleMonster = a322;
                a2.getMap().broadcastMessage(a4.K, MobPacket.damageMonster(mapleMonster.getObjectId(), (long)d2), true);
                mapleMonster.damage(a4.K, (int)d2, true);
            }
        }
    }

    public /* synthetic */ void checkExist() {
        MapleMonsterPet a2;
        MapleMonsterPet mapleMonsterPet = a2;
        if (World.Find.findChr(mapleMonsterPet.K.getId()) == null) {
            MapleMonsterPet mapleMonsterPet2 = a2;
            mapleMonsterPet.getMap().killMonster(mapleMonsterPet, mapleMonsterPet2.K, false);
            mapleMonsterPet2.K.setMonsterPet(null);
            return;
        }
        if (MapleMonsterPet.BanMonsterPetMap(a2.K.getMap().getId())) {
            MapleMonsterPet mapleMonsterPet3 = a2;
            mapleMonsterPet.getMap().killMonster(mapleMonsterPet, mapleMonsterPet3.K, false);
            mapleMonsterPet3.K.setMonsterPet(null);
            return;
        }
    }

    public static final class MapleMonsterPetSkill
    extends Enum<MapleMonsterPetSkill> {
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u65bd\u653e\u6bd2\u6c23;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u6953\u8449\u795d\u798f;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u6703\u5fc3\u4e4b\u773c;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u6cbb\u7652\u88dc\u9b54;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill Unknown;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u6cbb\u7652\u88dc\u8840;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u795e\u8056\u7948\u79b1;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u795e\u8056\u4e4b\u706b;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u5168\u5716\u5438\u7269;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u5927\u7bc4\u570d\u5438\u7269;
        private static final /* synthetic */ MapleMonsterPetSkill[] ALLATORIxDEMO;
        public /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u901f\u5ea6\u6fc0\u767c;
        public static final /* synthetic */ /* enum */ MapleMonsterPetSkill \u5c0f\u7bc4\u570d\u5438\u7269;

        public /* synthetic */ int getSkillId() {
            MapleMonsterPetSkill a2;
            return a2.d;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ MapleMonsterPetSkill(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            MapleMonsterPetSkill a3;
            a3.d = a2;
        }

        public static /* synthetic */ String getName(MapleMonsterPetSkill a2) {
            return a2.name();
        }

        public static /* synthetic */ MapleMonsterPetSkill getById(int a2) {
            int n2;
            MapleMonsterPetSkill[] arrmapleMonsterPetSkill = MapleMonsterPetSkill.values();
            int n3 = arrmapleMonsterPetSkill.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleMonsterPetSkill mapleMonsterPetSkill = arrmapleMonsterPetSkill[n2];
                if (mapleMonsterPetSkill.getSkillId() == a2) {
                    return mapleMonsterPetSkill;
                }
                n4 = ++n2;
            }
            return Unknown;
        }

        public static /* synthetic */ {
            \u901f\u5ea6\u6fc0\u767c = new MapleMonsterPetSkill(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u9006\u5ef7\u6fd9\u762d"), 0, 0);
            \u65bd\u653e\u6bd2\u6c23 = new MapleMonsterPetSkill(MobNameData.ALLATORIxDEMO("\u6593\u650c\u6bfc\u6c11"), 1, 1);
            \u5c0f\u7bc4\u570d\u5438\u7269 = new MapleMonsterPetSkill(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u5c5e\u7bdd\u575c\u5421\u7238"), 2, 2);
            \u6cbb\u7652\u88dc\u8840 = new MapleMonsterPetSkill(MobNameData.ALLATORIxDEMO("\u6c95\u7660\u88f2\u8872"), 3, 3);
            \u795e\u8056\u4e4b\u706b = new MapleMonsterPetSkill(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u7947\u8007\u4e52\u703a"), 4, 4);
            \u6cbb\u7652\u88dc\u9b54 = new MapleMonsterPetSkill(MobNameData.ALLATORIxDEMO("\u6c95\u7660\u88f2\u9b66"), 5, 5);
            \u5927\u7bc4\u570d\u5438\u7269 = new MapleMonsterPetSkill(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u5976\u7bdd\u575c\u5421\u7238"), 6, 6);
            \u6703\u5fc3\u4e4b\u773c = new MapleMonsterPetSkill(MobNameData.ALLATORIxDEMO("\u672d\u5ff1\u4e65\u770e"), 7, 7);
            \u6953\u8449\u795d\u798f = new MapleMonsterPetSkill(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u694a\u8418\u7944\u79de"), 8, 8);
            \u795e\u8056\u7948\u79b1 = new MapleMonsterPetSkill(MobNameData.ALLATORIxDEMO("\u7970\u8064\u7966\u7983"), 9, 9);
            \u5168\u5716\u5438\u7269 = new MapleMonsterPetSkill(\u5976\u8336\u8c37.ALLATORIxDEMO((String)"\u5171\u5747\u5421\u7238"), 10, 10);
            Unknown = new MapleMonsterPetSkill(MobNameData.ALLATORIxDEMO("g@Y@]Y\\"), 11, 999999);
            MapleMonsterPetSkill[] arrmapleMonsterPetSkill = new MapleMonsterPetSkill[12];
            arrmapleMonsterPetSkill[0] = \u901f\u5ea6\u6fc0\u767c;
            arrmapleMonsterPetSkill[1] = \u65bd\u653e\u6bd2\u6c23;
            arrmapleMonsterPetSkill[2] = \u5c0f\u7bc4\u570d\u5438\u7269;
            arrmapleMonsterPetSkill[3] = \u6cbb\u7652\u88dc\u8840;
            arrmapleMonsterPetSkill[4] = \u795e\u8056\u4e4b\u706b;
            arrmapleMonsterPetSkill[5] = \u6cbb\u7652\u88dc\u9b54;
            arrmapleMonsterPetSkill[6] = \u5927\u7bc4\u570d\u5438\u7269;
            arrmapleMonsterPetSkill[7] = \u6703\u5fc3\u4e4b\u773c;
            arrmapleMonsterPetSkill[8] = \u6953\u8449\u795d\u798f;
            arrmapleMonsterPetSkill[9] = \u795e\u8056\u7948\u79b1;
            arrmapleMonsterPetSkill[10] = \u5168\u5716\u5438\u7269;
            arrmapleMonsterPetSkill[11] = Unknown;
            ALLATORIxDEMO = arrmapleMonsterPetSkill;
        }

        public static /* synthetic */ int getSkillCount() {
            return MapleMonsterPetSkill.values().length;
        }

        public static /* synthetic */ MapleMonsterPetSkill[] values() {
            return (MapleMonsterPetSkill[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ MapleMonsterPetSkill valueOf(String a2) {
            return Enum.valueOf(MapleMonsterPetSkill.class, a2);
        }
    }
}

