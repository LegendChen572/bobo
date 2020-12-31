/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import FuckingHackerToby.fc;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.MapleCoreAura;
import client.MonsterFamiliar;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import client.inventory.MapleInventoryType;
import client.status.MonsterStatus;
import client.status.MonsterStatusEffect;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.MobConstants;
import handling.channel.handler.MovementParse;
import handling.world.World;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MobSkillData;
import server.Randomizer;
import server.StructFamiliar;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterStats;
import server.life.MobSkill;
import server.life.MobSkillFactory;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMap;
import server.maps.MapleNodes;
import server.movement.AbstractLifeMovement;
import server.movement.LifeMovement;
import server.movement.LifeMovementFragment;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.Triple;
import tools.data.LittleEndianAccessor;
import tools.packet.MobPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class MobHandler {
    public static final /* synthetic */ void UseFamiliar(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a42) {
        if (a42 == null || !a42.isAlive() || a42.getMap() == null || a42.hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        a3.getPlayer().updateTick(littleEndianAccessor.readInt());
        short a42 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        Object object = a42.getInventory(MapleInventoryType.USE).getItem(a42);
        a3.sendPacket(MaplePacketCreator.enableActions());
        if (object == null || object.getQuantity() < 1 || object.getItemId() != n2 || n2 / 10000 != 287) {
            return;
        }
        StructFamiliar structFamiliar = MapleItemInformationProvider.getInstance().getFamiliarByItem(n2);
        if (MapleLifeFactory.getMonster(structFamiliar.mob).getStats().getLevel() <= a3.getPlayer().getLevel()) {
            MapleClient mapleClient;
            object = a3.getPlayer().getFamiliars().get(structFamiliar.familiar);
            if (object != null) {
                if (((MonsterFamiliar)object).getVitality() >= 3) {
                    mapleClient = a3;
                    Object object2 = object;
                    ((MonsterFamiliar)object2).setExpiry(Math.min(System.currentTimeMillis() + 7776000000L, ((MonsterFamiliar)object2).getExpiry() + 2592000000L));
                } else {
                    Object object3 = object;
                    ((MonsterFamiliar)object3).setVitality(((MonsterFamiliar)object3).getVitality() + 1);
                    ((MonsterFamiliar)object3).setExpiry(((MonsterFamiliar)object3).getExpiry() + 2592000000L);
                    mapleClient = a3;
                }
            } else {
                object = new MonsterFamiliar(a3.getPlayer().getId(), structFamiliar.familiar, System.currentTimeMillis() + 2592000000L);
                MapleClient mapleClient2 = a3;
                mapleClient = mapleClient2;
                mapleClient2.getPlayer().getFamiliars().put(structFamiliar.familiar, (MonsterFamiliar)object);
            }
            MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.USE, a42, (short)1, false, false);
            a3.sendPacket(MaplePacketCreator.registerFamiliar((MonsterFamiliar)object));
            return;
        }
    }

    public static final /* synthetic */ void MoveFamiliar(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(13);
        a3 = MovementParse.parseMovement(littleEndianAccessor, (MapleClient)a3, 6);
        if (a4 != null && a4.getSummonedFamiliar() != null && a3.size() > 0) {
            MapleCharacter mapleCharacter = a4;
            Point point = mapleCharacter.getSummonedFamiliar().getPosition();
            MapleCharacter mapleCharacter2 = a4;
            MovementParse.updatePosition((List<LifeMovementFragment>)a3, mapleCharacter2.getSummonedFamiliar(), 0);
            mapleCharacter.getSummonedFamiliar().updatePosition((List<LifeMovementFragment>)a3);
            if (!mapleCharacter2.isHidden()) {
                MapleCharacter mapleCharacter3 = a4;
                a4.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.moveFamiliar(a4.getId(), point, (List<LifeMovementFragment>)a3), mapleCharacter3.getTruePosition());
            }
        }
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void CheckMobVac_New(MapleClient a, MapleMonster a, List<LifeMovementFragment> a, Point a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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

    public static final /* synthetic */ void handleMonsterBomb(LittleEndianAccessor a2, MapleClient a3) {
        if (a2.available() >= 12L) {
            Object object = a3.getPlayer().getMap();
            if (object == null) {
                return;
            }
            object = ((MapleMap)object).getMonsterByOid(a2.readInt());
            Point point = new Point(a2.readInt(), a2.readInt());
            if (object != null && ((MapleMonster)object).getBuff(MonsterStatus.MONSTER_BOMB) != null) {
                a3.sendPacket(MaplePacketCreator.getTimeBombAttack(((MapleMonster)object).getBuff(MonsterStatus.MONSTER_BOMB).getSkill(), ((AbstractMapleMapObject)object).getPosition(), 50, 0));
            }
        }
    }

    public static final /* synthetic */ void MobBomb(LittleEndianAccessor a2, MapleCharacter a3) {
        Object object = a3.getMap();
        if (object == null) {
            return;
        }
        if (a2.available() >= 12L) {
            object = ((MapleMap)object).getMonsterByOid(a2.readInt());
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(4);
            littleEndianAccessor.readInt();
            if (object != null) {
                a3.getClient().sendPacket(MobPacket.itemBombAttack(4341003, object.getPosition().x, object.getPosition().y, 0));
            }
        }
    }

    public static final /* synthetic */ void SpawnFamiliar(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a422) {
        MapleClient mapleClient = a3;
        MapleClient mapleClient2 = a3;
        mapleClient2.getPlayer().updateTick(a2.readInt());
        int a422 = a2.readInt();
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        mapleClient2.getPlayer().removeFamiliar();
        if (mapleClient.getPlayer().getFamiliars().containsKey(a422) && a2.readByte() > 0) {
            MonsterFamiliar a422 = a3.getPlayer().getFamiliars().get(a422);
            if (a422.getFatigue() > 0) {
                a3.getPlayer().dropMessage(1, "Please wait " + a422.getFatigue() + " seconds to summon it.");
                return;
            }
            a3.getPlayer().spawnFamiliar(a422);
        }
    }

    public static final /* synthetic */ void HypnotizeDmg(LittleEndianAccessor a2, MapleClient a3) {
        a3 = ((MapleClient)a3).getPlayer();
        MapleMonster mapleMonster = ((MapleCharacter)a3).getMap().getMonsterByOid(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(4);
        int n2 = littleEndianAccessor.readInt();
        littleEndianAccessor.skip(1);
        int n3 = littleEndianAccessor.readInt();
        MapleMonster mapleMonster2 = ((MapleCharacter)a3).getMap().getMonsterByOid(n2);
        if (mapleMonster != null && mapleMonster2 != null && mapleMonster2.getStats().isFriendly()) {
            if (n3 > 30000) {
                return;
            }
            mapleMonster2.damage((MapleCharacter)a3, n3, true);
            Object object = a3;
            MobHandler.checkShammos((MapleCharacter)object, mapleMonster2, ((MapleCharacter)object).getMap());
        }
    }

    public static final /* synthetic */ void handleDisplayNode(LittleEndianAccessor a2, MapleClient a3) {
        MapleMonster mapleMonster = ((MapleCharacter)(a3 = ((MapleClient)a3).getPlayer())).getMap().getMonsterByOid(a2.readInt());
        if (mapleMonster != null) {
            ((MapleCharacter)a3).getClient().sendPacket(MaplePacketCreator.getNodeProperties(mapleMonster, ((MapleCharacter)a3).getMap()));
        }
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void CheckMobVac_x(MapleClient a, MapleMonster a, List<LifeMovementFragment> a, Point a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void CheckMobDirection(MapleClient a2, MapleMonster a3, List<LifeMovementFragment> a42, Point a5) {
        double d2 = 0.0;
        Point point = null;
        a42 = a42.iterator();
        while (a42.hasNext()) {
            LifeMovementFragment lifeMovementFragment = (LifeMovementFragment)a42.next();
            if (!(lifeMovementFragment instanceof AbstractLifeMovement)) continue;
            point = ((LifeMovement)lifeMovementFragment).getPosition();
        }
        if (point == null) {
            return;
        }
        if (a2.getPlayer().getMap().getNumMonsters() > 150) {
            return;
        }
        switch (a2.getPlayer().getLastUseSkill()) {
            case 14101006: {
                return;
            }
        }
        switch (a2.getPlayer().getMapId()) {
            case 910320100: 
            case 910320200: 
            case 910320300: 
            case 926013100: 
            case 926013200: 
            case 926013300: 
            case 926013400: 
            case 980000301: {
                return;
            }
        }
        if (a2.getPlayer().getMapId() / 100000 == 9260) {
            return;
        }
        if (a2.getPlayer().getMapId() / 10000 == 91032) {
            return;
        }
        if (MobConstants.isMonsterSpawn(a2.getPlayer().getMap()) > 1) {
            return;
        }
        int a42 = 500;
        switch (a3.getId()) {
            case 9410032: {
                a42 = 1200;
                break;
            }
        }
        if (a3.isSummonMonster()) {
            return;
        }
        d2 = a5.getX() - point.getX();
        if (d2 != 0.0) {
            MapleClient mapleClient;
            MapleClient mapleClient2 = a2;
            if (d2 >= 0.0) {
                mapleClient2.getPlayer().addMobDirection(1);
                mapleClient = a2;
            } else {
                mapleClient2.getPlayer().addMobDirection(-1);
                mapleClient = a2;
            }
            if (mapleClient.getPlayer().getMobDirection() < (long)(-a42) || a2.getPlayer().getMobDirection() > (long)a42) {
                a2.getPlayer().getCheatTracker().registerOffense(CheatingOffense.\u63a7\u602a, "(\u5730\u5716: " + a2.getPlayer().getMapId() + " \u983b\u9053: " + a2.getPlayer().getClient().getChannel() + "\u602a\u7269" + a3.getStats().getName() + "(" + a3.getId() + ") \u602a\u7269\u65b9\u5411\u63a7\u5236\u503c:" + a2.getPlayer().getMobDirection() + ")");
            }
        }
    }

    public static final /* synthetic */ void handleAutoAggro(LittleEndianAccessor a2, MapleClient a3) {
        if (((MapleClient)a3).getPlayer() == null || ((MapleClient)a3).getPlayer().getMap() == null || ((MapleClient)a3).getPlayer().isHidden()) {
            return;
        }
        MapleMonster mapleMonster = ((MapleCharacter)(a3 = ((MapleClient)a3).getPlayer())).getMap().getMonsterByOid(a2.readInt());
        if (mapleMonster != null && ((AbstractMapleMapObject)a3).getPosition().distanceSq(mapleMonster.getPosition()) < 200000.0) {
            if (mapleMonster.getController() != null) {
                if (((MapleCharacter)a3).getMap().getCharacterById(mapleMonster.getController().getId()) == null) {
                    mapleMonster.switchController((MapleCharacter)a3, true);
                    return;
                }
                MapleMonster mapleMonster2 = mapleMonster;
                mapleMonster2.switchController(mapleMonster2.getController(), true);
                return;
            }
            mapleMonster.switchController((MapleCharacter)a3, true);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void handleMobNode(LittleEndianAccessor a2, MapleClient a3) {
        a3 = ((MapleClient)a3).getPlayer();
        MapleMonster mapleMonster = ((MapleCharacter)a3).getMap().getMonsterByOid(a2.readInt());
        int n2 = a2.readInt();
        int n3 = ((MapleCharacter)a3).getMap().getNodes().size();
        if (mapleMonster != null && n3 > 0 && n3 >= n2) {
            MapleNodes.MapleNodeInfo mapleNodeInfo = ((MapleCharacter)a3).getMap().getNode(n2);
            if (mapleNodeInfo == null) {
                return;
            }
            if (mapleNodeInfo.attr == 2) {
                ((MapleCharacter)a3).getMap().talkMonster(fc.ALLATORIxDEMO("\u0002{7v!rrr!t=e&7?rrt3e7q'{>n|"), 5120035, mapleMonster.getObjectId());
            }
            if (mapleMonster.getLastNode() >= n2) {
                return;
            }
            mapleMonster.setLastNode(n2);
            if (n3 == n2) {
                int n4;
                n2 = -1;
                switch (((MapleCharacter)a3).getMapId() / 100) {
                    case 9211200: {
                        n4 = n2 = 921120100;
                        break;
                    }
                    case 9211201: {
                        n4 = n2 = 921120200;
                        break;
                    }
                    case 9211202: {
                        n4 = n2 = 921120300;
                        break;
                    }
                    case 9211203: {
                        n4 = n2 = 921120400;
                        break;
                    }
                    case 9211204: {
                        ((MapleCharacter)a3).getMap().removeMonster(mapleMonster);
                    }
                    default: {
                        n4 = n2;
                    }
                }
                if (n4 > 0) {
                    Object object = a3;
                    ((MapleCharacter)object).getMap().broadcastMessage(MaplePacketCreator.getErrorNotice(MapleCoreAura.ALLATORIxDEMO(" ~\u001fo\u0015i\u0014,\u0004cPx\u0018iPb\u0015t\u0004,\u0003x\u0011k\u0015\"")));
                    ((MapleCharacter)object).getMap().removeMonster(mapleMonster);
                }
            }
        }
    }

    public static final /* synthetic */ void RenameFamiliar(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        MapleClient mapleClient;
        MonsterFamiliar monsterFamiliar = a3.getPlayer().getFamiliars().get(a2.readInt());
        String string = a2.readMapleAsciiString();
        if (monsterFamiliar != null && monsterFamiliar.getName().equals(monsterFamiliar.getOriginalName()) && MapleCharacterUtil.isEligibleCharName(string)) {
            mapleClient = a3;
            monsterFamiliar.setName(string);
        } else {
            a4.dropMessage(1, MapleCoreAura.ALLATORIxDEMO(">m\u001diP{\u0011\u007fPb\u001fxPi\u001ce\u0017e\u0012`\u0015\""));
            mapleClient = a3;
        }
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void checkShammos(MapleCharacter a2, MapleMonster a3, MapleMap a4) {
        if (!a3.isAlive() && a3.getId() == 9300275) {
            Iterator<MapleCharacter> iterator;
            for (MapleCharacter object2 : a4.getCharactersThreadsafe()) {
                if (object2.getParty() == null || object2.getParty().getLeader().getId() != object2.getId()) continue;
                if (!object2.haveItem(2022698)) break;
                MapleInventoryManipulator.removeById(object2.getClient(), MapleInventoryType.USE, 2022698, true ? 1 : 0, false, true);
                MapleMonster mapleMonster = a3;
                mapleMonster.heal((int)a3.getMobMaxHp(), mapleMonster.getMobMaxMp(), true);
                return;
            }
            a4.broadcastMessage(MaplePacketCreator.getItemNotice(fc.ALLATORIxDEMO("\u000bx'erg3e&nr\u007f3drq3~>r67&xrg x&r1crc:rrz=y!c7e|")));
            MapleMap mapleMap = a2.getClient().getChannelServer().getMapFactory().getMap(921120001);
            Iterator<MapleCharacter> iterator2 = iterator = a4.getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                Object object = mapleMap;
                iterator.next().changeMap((MapleMap)object, ((MapleMap)object).getPortal(0));
                iterator2 = iterator;
            }
        } else if (a3.getId() == 9300275 && a3.getEventInstance() != null) {
            a3.getEventInstance().setProperty(MapleCoreAura.ALLATORIxDEMO("8\\"), String.valueOf(a3.getHp()));
        }
    }

    public static final /* synthetic */ void TouchFamiliar(LittleEndianAccessor a2, MapleClient a32, MapleCharacter a4) {
        if (a4.getSummonedFamiliar() == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(6);
        byte a32 = littleEndianAccessor.readByte();
        MapleMonster mapleMonster = a4.getMap().getMonsterByOid(a2.readInt());
        if (mapleMonster == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor2 = a2;
        int n2 = littleEndianAccessor2.readInt();
        littleEndianAccessor2.skip(4);
        int n3 = littleEndianAccessor2.readInt();
        int n4 = a4.getSummonedFamiliar().getOriginalStats().getPhysicalAttack() * 5;
        if (n3 < n4) {
            n3 = n4;
        }
        if (!mapleMonster.getStats().isFriendly() && a4.getCheatTracker().checkFamiliarAttack(a4)) {
            MapleCharacter mapleCharacter = a4;
            MapleCharacter mapleCharacter2 = a4;
            mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.touchFamiliar(a4.getId(), a32, mapleMonster.getObjectId(), n2, 600, n3), mapleCharacter2.getTruePosition());
            mapleMonster.damage(mapleCharacter, n3, true);
            mapleCharacter.getSummonedFamiliar().addFatigue(a4);
        }
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void CheckMobVac(MapleClient a, MapleMonster a, List<LifeMovementFragment> a, Point a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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

    public static final /* synthetic */ void MoveMonster(LittleEndianAccessor a2, MapleClient a3) {
        List<LifeMovementFragment> list;
        List<LifeMovementFragment> list2;
        int n2;
        int n3;
        int n4;
        MapleCharacter mapleCharacter = a3.getPlayer();
        if (mapleCharacter == null || mapleCharacter.getMap() == null) {
            return;
        }
        int n5 = a2.readInt();
        MapleMonster mapleMonster = mapleCharacter.getMap().getMonsterByOid(n5);
        if (mapleMonster == null) {
            mapleCharacter.addMoveMob(n5);
            return;
        }
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            a2.readByte();
        }
        n5 = 0;
        LittleEndianAccessor littleEndianAccessor = a2;
        int n6 = littleEndianAccessor.readShort();
        boolean bl = littleEndianAccessor.readByte() > 0;
        LittleEndianAccessor littleEndianAccessor2 = a2;
        byte by = littleEndianAccessor2.readByte();
        int n7 = littleEndianAccessor2.readByte() & 0xFF;
        int n8 = littleEndianAccessor2.readByte() & 0xFF;
        short s2 = littleEndianAccessor2.readShort();
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<Pair<Integer, Integer>>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            n4 = a2.readByte();
            int n12 = n3 = 0;
            while (n12 < n4) {
                arrayList.add(new Pair<Integer, Integer>(Integer.valueOf(a2.readShort()), Integer.valueOf(a2.readShort())));
                n12 = ++n3;
            }
            n3 = a2.readByte();
            int n13 = n2 = 0;
            while (n13 < n3) {
                arrayList2.add(Integer.valueOf(a2.readShort()));
                n13 = ++n2;
            }
        } else if (GameSetConstants.MAPLE_VERSION > 113) {
            n4 = a2.readInt();
            int n14 = n3 = 0;
            while (n14 < n4) {
                arrayList.add(new Pair<Integer, Integer>(a2.readInt(), a2.readInt()));
                n14 = ++n3;
            }
            n3 = a2.readInt();
            int n15 = n2 = 0;
            while (n15 < n3) {
                arrayList2.add(a2.readInt());
                n15 = ++n2;
            }
        }
        a2.read(1);
        if (GameSetConstants.MAPLE_VERSION == 75) {
            a2.read(4);
        } else {
            byte by2 = a2.readByte();
            n3 = by2;
            if (by2 == 18) {
                a2.read(2);
            }
        }
        if (GameSetConstants.MAPLE_VERSION != 75) {
            a2.read(11);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            a2.read(4);
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            a2.readByte();
        }
        Point point = mapleMonster.getPosition();
        point = a2.readPos();
        if (GameSetConstants.MAPLE_VERSION >= 120) {
            a2.read(4);
        }
        try {
            list2 = MovementParse.parseMovement(a2, a3, 2);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            if (mapleCharacter.isShowErr()) {
                mapleCharacter.showInfo(MapleCoreAura.ALLATORIxDEMO("\u798b\u52d9"), true, fc.ALLATORIxDEMO("\u6078\u727e\u79a9\u52c2\u937d\u8ab3\u001fx$r\r{;q77h7\u0013^\u001dU\u00177\u0006n\"r`"));
            }
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + mapleCharacter.getName() + " (\u7de8\u865f: " + mapleCharacter.getId() + ") \u602a\u7269\u79fb\u52d5\u932f\u8aa4(" + mapleMonster.getId() + ")! - \u5730\u5716:" + mapleCharacter.getMapId()), true);
            FileoutputUtil.log("logs/Except/\u79fb\u52d5\u932f\u8aa4.txt", "\u602a\u7269\u79fb\u52d5\u932f\u8aa4 AIOBE Type2 : \u73a9\u5bb6: " + a3.getPlayer().getName() + "(\u7de8\u865f" + a3.getPlayer().getId() + ") \u602a\u7269ID " + mapleMonster.getId() + "\r\n\u932f\u8aa4\u8a0a\u606f:" + arrayIndexOutOfBoundsException + "\r\n\u5c01\u5305:\r\n" + a2.toString(true));
            return;
        }
        MapleCharacter mapleCharacter2 = mapleMonster.getController();
        MapleMap mapleMap = mapleCharacter.getMap();
        try {
            if (GameSetConstants.MOB_DIRECTION_DETECT && !mapleMonster.isFirstAttack()) {
                MobHandler.CheckMobDirection(a3, mapleMonster, list2, point);
            }
            if (GameSetConstants.MOB_VAC_DETECT && !mapleMonster.getClass().getName().equals("server.life.MapleMonsterPet") && !MobConstants.isSpawnSpeed(mapleMap)) {
                MapleClient mapleClient = a3;
                MobHandler.CheckMobVac_bobo(mapleClient, mapleMonster, list2, point);
                if (!JobConstants.is\u5f71\u6b66\u8005(mapleClient.getPlayer().getJob()) && !JobConstants.is\u6a5f\u7532\u6230\u795e(a3.getPlayer().getJob())) {
                    MapleClient mapleClient2 = a3;
                    MobHandler.CheckMobVac(mapleClient2, mapleMonster, list2, point);
                    MobHandler.CheckMobVac_x(mapleClient2, mapleMonster, list2, point);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        a3.sendPacket(MobPacket.moveMonsterResponse(mapleMonster.getObjectId(), (short)n6, mapleMonster.getMp(), mapleMonster.isControllerHasAggro(), n10, n11));
        if (mapleCharacter2 != a3.getPlayer()) {
            if (mapleMonster.isAttackedBy(a3.getPlayer())) {
                mapleMonster.switchController(a3.getPlayer(), true);
            } else if (mapleCharacter2 != null && mapleCharacter2.getMapId() == mapleMonster.getMap().getId()) {
                mapleMonster.setController(null);
                return;
            }
        } else if (by == -1 && mapleMonster.isControllerKnowsAboutAggro() && !mapleMonster.getStats().getMobile() && !mapleMonster.isFirstAttack()) {
            MapleMonster mapleMonster2 = mapleMonster;
            mapleMonster2.setControllerHasAggro(false);
            mapleMonster2.setControllerKnowsAboutAggro(false);
        }
        int n16 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 149) {
            n16 = 36;
            list = list2;
        } else if (GameSetConstants.MAPLE_VERSION >= 147) {
            n16 = 35;
            list = list2;
        } else if (GameSetConstants.MAPLE_VERSION == 143 || GameSetConstants.MAPLE_VERSION == 145) {
            n16 = 30;
            list = list2;
        } else if (GameSetConstants.MAPLE_VERSION >= 134) {
            n16 = 33;
            list = list2;
        } else if (GameSetConstants.MAPLE_VERSION > 113) {
            n16 = 17;
            list = list2;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 75) {
                n16 = 9;
            }
            list = list2;
        }
        if (list != null && mapleCharacter != null) {
            if (a2.available() != (long)n16) {
                System.out.println("slea.available != " + n16 + " (\u602a\u7269\u79fb\u52d5\u51fa\u932f) \u5269\u9918\u5c01\u5305\u9577\u5ea6: " + a2.available());
                FileoutputUtil.logToFile(MapleCoreAura.ALLATORIxDEMO("`\u001fk\u0003#\u605a\u7265\u798b\u52d9\u935f\u8aa8^x\bx"), "slea.available != " + n16 + " (\u602a\u7269\u79fb\u52d5\u932f\u8aa4)\r\n\u602a\u7269ID: " + mapleMonster.getId() + "\r\n" + a2.toString(true));
                return;
            }
            MovementParse.updatePosition(list2, mapleMonster, -1);
            boolean bl2 = bl;
            MapleMonster mapleMonster3 = mapleMonster;
            mapleMap.moveMonster(mapleMonster3, mapleMonster3.getPosition());
            mapleMap.broadcastMessage(mapleCharacter, MobPacket.moveMonster(bl2, by, n7, n8, s2, mapleMonster.getObjectId(), point, mapleMonster.getPosition(), list2, arrayList2, arrayList), mapleMonster.getPosition());
            if (bl2) {
                MapleMonster mapleMonster4 = mapleMonster;
                n6 = mapleMonster4.getNoSkills();
                bl = false;
                if (!mapleMonster4.SkillsDisabled() && n6 > 0) {
                    long l2;
                    long l3;
                    n6 = Randomizer.nextInt(n6);
                    MobSkillData mobSkillData = mapleMonster.getSkills().get(n6);
                    n5 = n6;
                    MobSkillData mobSkillData2 = mobSkillData;
                    n10 = mobSkillData2.getSkill();
                    n11 = mobSkillData2.getLevel();
                    n9 = mobSkillData2.getSkillAfter();
                    MobSkill mobSkill = MobSkillFactory.getMobSkill(n10, n11);
                    if (mobSkill != null && !mobSkill.checkCurrentBuff(mapleCharacter, mapleMonster)) {
                        l3 = System.currentTimeMillis();
                        l2 = mapleMonster.getLastSkillUsed(n10);
                        if (l2 == 0L || l3 - l2 > mobSkill.getCoolTime() && !mobSkill.onlyOnce()) {
                            MapleMonster mapleMonster5 = mapleMonster;
                            mapleMonster5.setLastSkillUsed(n10, l3, mobSkill.getCoolTime());
                            int n17 = (int)((float)mapleMonster5.getHp() / (float)mapleMonster.getMobMaxHp() * 100.0f);
                            if (n17 <= mobSkill.getHP()) {
                                bl = true;
                                mobSkill.applyEffect(mapleCharacter, mapleMonster, true);
                            }
                        }
                    }
                    if (mobSkill != null && !mobSkill.checkCurrentBuff(mapleCharacter, mapleMonster)) {
                        l3 = System.currentTimeMillis();
                        l2 = mapleMonster.getLastSkillUsed(n10);
                        if (l2 == 0L || l3 - l2 > mobSkill.getCoolTime() && !mobSkill.onlyOnce()) {
                            int n18 = (int)((float)mapleMonster.getHp() / (float)mapleMonster.getMobMaxHp() * 100.0f);
                            if (n18 <= mobSkill.getHp()) {
                                mapleMonster.setLastSkillUsed(n10, l3, 0L);
                                bl = true;
                                if (n9 > 0 && GameSetConstants.MAPLE_VERSION > 113) {
                                    if (n10 == 143 || n10 == 144 || n10 == 145) {
                                        mapleMonster.getMap().startMapEffect("\u5feb\u505c\u4e0b\u653b\u64ca\uff01" + mapleMonster.getStats().getName() + "\u4f7f\u7528\u4e86\u53cd\u5c04\u7269\u653b!", 5120025, false, 5000);
                                    }
                                    a3.sendPacket(MobPacket.showMobSkillDelay(mapleMonster.getObjectId(), n10, n11, n9, s2));
                                } else {
                                    if (n10 == 143 || n10 == 144 || n10 == 145) {
                                        mapleMonster.getMap().startMapEffect("\u5feb\u505c\u4e0b\u653b\u64ca\uff01" + mapleMonster.getStats().getName() + "\u4f7f\u7528\u4e86\u53cd\u5c04\u7269\u653b!", 5120025, false, 5000);
                                    }
                                    mobSkill.applyEffect(mapleCharacter, mapleMonster, true);
                                }
                            } else if (a3.getPlayer().isStaff()) {
                                a3.getPlayer().dropDebugMessage(mapleMonster.getStats().getName() + "(" + mapleMonster.getId() + ") \u6280\u80fd<" + n10 + "> index<" + n5 + ">\u602a\u7269\u8840\u91cf:" + n18 + "% \u65bd\u653e\u4f4e\u65bc\u8840\u91cf:" + mobSkill.getHp() + "%");
                            }
                        } else if (a3.getPlayer().isStaff()) {
                            a3.getPlayer().dropDebugMessage(mapleMonster.getStats().getName() + "(" + mapleMonster.getId() + ") \u6280\u80fd<" + n10 + "> index<" + n5 + "> \u6280\u80fdCD:" + mobSkill.getCoolTime() / 1000L + "\u79d2,\u7d93\u904e" + (l3 - l2) / 1000L + "\u79d2 \u9650\u5236\u65bd\u653e\u4e00\u6b21:" + mobSkill.onlyOnce());
                        }
                    }
                }
                if (!bl) {
                    n10 = 0;
                    n11 = 0;
                }
            }
        }
    }

    public static final /* synthetic */ void MonsterBomb(int a2, MapleCharacter a3) {
        if (a3 == null) {
            return;
        }
        MapleMonster mapleMonster = a3.getMap().getMonsterByOid(a2);
        if (mapleMonster == null || mapleMonster.getStats() == null || !a3.isAlive() || a3.isHidden() || mapleMonster.getLinkCID() > 0) {
            return;
        }
        if (mapleMonster.getStats().getSelfD() != -1) {
            a3.getMap().killMonster(mapleMonster, a3, false, false, (byte)1);
        }
    }

    public static final /* synthetic */ void handleMonsterAreaDiseaseSkill(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null || a3.getPlayer().getMap() == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        n3 = littleEndianAccessor.readInt();
        n3 = littleEndianAccessor.readInt();
        n3 = littleEndianAccessor.readInt();
        if (a3.getPlayer().getMap().getMonsterByOid(n2) != null) {
            // empty if block
        }
    }

    public static final /* synthetic */ void AttackFamiliar(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        Iterator iterator;
        int n2;
        if (a4.getSummonedFamiliar() == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(6);
        a3 = SkillFactory.getFamiliar(littleEndianAccessor.readInt());
        if (a3 == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor2 = a2;
        byte by = littleEndianAccessor2.readByte();
        int n3 = littleEndianAccessor2.readByte();
        ArrayList<Triple<Integer, Integer, List<Integer>>> arrayList = new ArrayList<Triple<Integer, Integer, List<Integer>>>(n3);
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5;
            LittleEndianAccessor littleEndianAccessor3 = a2;
            int n6 = littleEndianAccessor3.readInt();
            int n7 = littleEndianAccessor3.readInt();
            littleEndianAccessor3.skip(10);
            int n8 = littleEndianAccessor3.readByte();
            iterator = new ArrayList<Integer>(n8);
            int n9 = n5 = 0;
            while (n9 < n8) {
                iterator.add(a2.readInt());
                n9 = ++n5;
            }
            arrayList.add(new Triple(n6, n7, iterator));
            n4 = ++n2;
        }
        if (arrayList.isEmpty() || !a4.getCheatTracker().checkFamiliarAttack(a4) || arrayList.size() > ((SkillFactory.FamiliarEntry)a3).targetCount) {
            return;
        }
        MapleCharacter mapleCharacter = a4;
        MapleMonsterStats mapleMonsterStats = mapleCharacter.getSummonedFamiliar().getOriginalStats();
        MapleCharacter mapleCharacter2 = a4;
        mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.familiarAttack(a4.getId(), by, arrayList), mapleCharacter2.getTruePosition());
        Iterator iterator2 = arrayList.iterator();
        block2: while (true) {
            Iterator iterator3 = iterator2;
            while (iterator3.hasNext()) {
                MapleMonster mapleMonster;
                Triple triple;
                block14: {
                    block13: {
                        triple = (Triple)iterator2.next();
                        mapleMonster = a4.getMap().getMonsterByOid((Integer)triple.left);
                        if (mapleMonster == null || !mapleMonster.isAlive() || mapleMonster.getStats().isFriendly() || mapleMonster.getLinkCID() > 0) continue block2;
                        if (((List)triple.right).size() > ((SkillFactory.FamiliarEntry)a3).attackCount) {
                            iterator3 = iterator2;
                            continue;
                        }
                        if (a4.getTruePosition().distanceSq(mapleMonster.getTruePosition()) > 640000.0) break block13;
                        Object object = a3;
                        if (!(a4.getSummonedFamiliar().getTruePosition().distanceSq(mapleMonster.getTruePosition()) > GameConstants.getAttackRange(((SkillFactory.FamiliarEntry)object).lt, ((SkillFactory.FamiliarEntry)object).rb))) break block14;
                    }
                    a4.getCheatTracker().registerOffense(CheatingOffense.\u53ec\u559a\u7378\u5168\u5716\u6253);
                }
                iterator = ((List)triple.right).iterator();
                while (iterator.hasNext()) {
                    int n10 = (Integer)iterator.next();
                    if (n10 > mapleMonsterStats.getPhysicalAttack() * 4) continue;
                    mapleMonster.damage(a4, n10, true);
                }
                if (!((SkillFactory.FamiliarEntry)a3).makeChanceResult() || !mapleMonster.isAlive()) continue block2;
                Iterator iterator4 = iterator = ((SkillFactory.FamiliarEntry)a3).status.iterator();
                while (iterator4.hasNext()) {
                    MonsterStatus monsterStatus = (MonsterStatus)((Object)iterator.next());
                    iterator4 = iterator;
                    MonsterStatus monsterStatus2 = monsterStatus;
                    mapleMonster.applyStatus(a4, new MonsterStatusEffect(monsterStatus2, Integer.valueOf(((SkillFactory.FamiliarEntry)a3).speed), MonsterStatusEffect.genericSkill(monsterStatus2), null, false), false, ((SkillFactory.FamiliarEntry)a3).time * 1000, false, null);
                }
                if (!((SkillFactory.FamiliarEntry)a3).knockback) continue block2;
                mapleMonster.switchController(a4, true);
                continue block2;
            }
            break;
        }
        a4.getSummonedFamiliar().addFatigue(a4, arrayList.size());
    }

    public /* synthetic */ MobHandler() {
        MobHandler a2;
    }

    public static /* synthetic */ void CheckMobVac_bobo(MapleClient a2, MapleMonster a3, List<LifeMovementFragment> a4, Point a5) {
        block12: {
            block11: {
                if (!a3.isSummonMonster()) break block11;
                return;
            }
            if (!MapConstants.isBossMap(a2.getPlayer().getMapId())) break block12;
            return;
        }
        try {
            if (a2.getPlayer().getMap().getNumMonsters() < 15) {
                return;
            }
            boolean bl = a3.getStats().getFly();
            Point point = null;
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            boolean bl2 = true;
            a4 = a4.iterator();
            while (a4.hasNext()) {
                LifeMovementFragment lifeMovementFragment = (LifeMovementFragment)a4.next();
                if (!(lifeMovementFragment instanceof AbstractLifeMovement)) continue;
                point = ((LifeMovement)lifeMovementFragment).getPosition();
                try {
                    Point point2 = a5;
                    n2 = point2.x - point.x;
                    n3 = point2.y - point.y;
                    int n5 = point2.x + point.x + a5.y + point.y;
                    MapleClient mapleClient = a2;
                    MapleClient mapleClient2 = a2;
                    mapleClient2.getPlayer().setMobVac_Coefficient(n5);
                    n4 += n2;
                    int n6 = mapleClient.getPlayer().getPosition().x;
                    int n7 = mapleClient2.getPlayer().getPosition().y;
                    n6 = Math.abs(n6 - point.x);
                    n7 = Math.abs(n7 - point.y);
                    mapleClient.getPlayer().checkSpecialMobVac(n6 += n7);
                }
                catch (Exception exception) {}
            }
            if (!MobConstants.isAggroMob(a3.getId())) {
                if (n4 > 0) {
                    a2.getPlayer().setMobMove(true);
                    return;
                }
                if (n4 < 0) {
                    a2.getPlayer().setMobMove(false);
                    return;
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public static final /* synthetic */ void handleFriendlyDamage(LittleEndianAccessor a2, MapleClient a3) {
        a3 = ((MapleClient)a3).getPlayer();
        MapleMap mapleMap = ((MapleCharacter)a3).getMap();
        MapleMonster mapleMonster = mapleMap.getMonsterByOid(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.skip(4);
        MapleMonster mapleMonster2 = mapleMap.getMonsterByOid(littleEndianAccessor.readInt());
        if (mapleMonster != null && mapleMonster2 != null && mapleMonster2.getStats().isFriendly()) {
            Object object = a3;
            mapleMonster2.damageFriendly((MapleCharacter)object, mapleMonster2.getStats().getLevel() * Randomizer.nextInt(99) / 2, true);
            MobHandler.checkShammos((MapleCharacter)object, mapleMonster2, mapleMap);
        }
    }
}

