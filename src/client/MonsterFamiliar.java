/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleCharacter;
import client.MapleClient;
import java.awt.Point;
import java.io.Serializable;
import java.util.List;
import server.MapleItemInformationProvider;
import server.Randomizer;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterStats;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.MapleMapObjectType;
import server.movement.AbsoluteLifeMovement;
import server.movement.LifeMovement;
import server.movement.LifeMovementFragment;
import tools.MaplePacketCreator;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;

public class MonsterFamiliar
extends AbstractAnimatedMapleMapObject
implements Serializable {
    private /* synthetic */ int k;
    private /* synthetic */ int E;
    private /* synthetic */ long a;
    private static final /* synthetic */ long e = 795419937713738569L;
    private /* synthetic */ short d;
    private /* synthetic */ String K;
    private /* synthetic */ int g;
    private /* synthetic */ byte ALLATORIxDEMO;
    private /* synthetic */ int B;

    public /* synthetic */ void setExpiry(long a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.FAMILIAR;
    }

    public /* synthetic */ void setName(String a2) {
        a.K = a2;
    }

    public /* synthetic */ void setFatigue(int a2) {
        a.B = a2;
    }

    public /* synthetic */ void addFatigue(MapleCharacter a2, int a3) {
        MonsterFamiliar a4;
        MonsterFamiliar monsterFamiliar = a4;
        monsterFamiliar.B = Math.min(monsterFamiliar.ALLATORIxDEMO * 300, Math.max(0, a4.B + a3));
        a2.getClient().sendPacket(MaplePacketCreator.updateFamiliar(a4));
        if (monsterFamiliar.B >= a4.ALLATORIxDEMO * 300) {
            a2.removeFamiliar();
        }
    }

    public /* synthetic */ void writeRegisterPacket(MaplePacketLittleEndianWriter a2, boolean a3) {
        MonsterFamiliar a4;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        maplePacketLittleEndianWriter2.writeInt(a4.getCharacterId());
        maplePacketLittleEndianWriter2.writeInt(a4.getFamiliar());
        maplePacketLittleEndianWriter.writeZeroBytes(13);
        maplePacketLittleEndianWriter.write(a3 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        MonsterFamiliar monsterFamiliar = a4;
        a2.writeShort(monsterFamiliar.getVitality());
        maplePacketLittleEndianWriter3.writeInt(monsterFamiliar.getFatigue());
        maplePacketLittleEndianWriter3.writeLong(PacketHelper.getTime(a4.getVitality() >= 3 ? System.currentTimeMillis() : -2L));
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
        a2.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        maplePacketLittleEndianWriter4.writeLong(PacketHelper.getTime(a4.getExpiry()));
        maplePacketLittleEndianWriter4.writeShort(a4.getVitality());
    }

    public /* synthetic */ long getExpiry() {
        MonsterFamiliar a2;
        return a2.a;
    }

    public /* synthetic */ byte getVitality() {
        MonsterFamiliar a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ MonsterFamiliar(int a2, int a3, long a4) {
        MonsterFamiliar a5;
        MonsterFamiliar monsterFamiliar = a5;
        MonsterFamiliar monsterFamiliar2 = a5;
        MonsterFamiliar monsterFamiliar3 = a5;
        monsterFamiliar3.d = 0;
        monsterFamiliar3.g = a3;
        monsterFamiliar2.k = a2;
        monsterFamiliar2.a = a4;
        a5.B = 0;
        monsterFamiliar.ALLATORIxDEMO = 1;
        monsterFamiliar.K = a5.getOriginalName();
        monsterFamiliar.E = Randomizer.nextInt();
    }

    public /* synthetic */ int getCharacterId() {
        MonsterFamiliar a2;
        return a2.k;
    }

    public final /* synthetic */ void updatePosition(List<LifeMovementFragment> a2) {
        a2 = a2.iterator();
        while (a2.hasNext()) {
            MonsterFamiliar a3;
            LifeMovementFragment lifeMovementFragment = (LifeMovementFragment)a2.next();
            if (!(lifeMovementFragment instanceof LifeMovement) || !(lifeMovementFragment instanceof AbsoluteLifeMovement)) continue;
            a3.setFh(((AbsoluteLifeMovement)lifeMovementFragment).getUnk());
        }
    }

    public final /* synthetic */ String getName() {
        MonsterFamiliar a2;
        return a2.K;
    }

    public /* synthetic */ void setVitality(int a2) {
        a.ALLATORIxDEMO = (byte)a2;
    }

    public /* synthetic */ int getFamiliar() {
        MonsterFamiliar a2;
        return a2.g;
    }

    public /* synthetic */ int getId() {
        MonsterFamiliar a2;
        return a2.E;
    }

    public /* synthetic */ int getFatigue() {
        MonsterFamiliar a2;
        return a2.B;
    }

    public /* synthetic */ void addFatigue(MapleCharacter a2) {
        MonsterFamiliar a3;
        a3.addFatigue(a2, 1);
    }

    public /* synthetic */ MonsterFamiliar(int a2, int a3, int a4, long a5, String a6, int a7, byte a8) {
        MonsterFamiliar a9;
        MonsterFamiliar monsterFamiliar = a9;
        MonsterFamiliar monsterFamiliar2 = a9;
        MonsterFamiliar monsterFamiliar3 = a9;
        MonsterFamiliar monsterFamiliar4 = a9;
        a9.d = 0;
        monsterFamiliar4.g = a4;
        monsterFamiliar4.k = a2;
        monsterFamiliar3.a = a5;
        monsterFamiliar3.ALLATORIxDEMO = a8;
        monsterFamiliar2.E = a3;
        monsterFamiliar2.K = a6;
        monsterFamiliar.B = a7;
        monsterFamiliar.setStance(0);
        MonsterFamiliar monsterFamiliar5 = a9;
        monsterFamiliar.setPosition(new Point(0, 0));
    }

    public /* synthetic */ String getOriginalName() {
        MonsterFamiliar a2;
        return a2.getOriginalStats().getName();
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MonsterFamiliar a3;
        a2.sendPacket(MaplePacketCreator.spawnFamiliar(a3, false));
    }

    public /* synthetic */ MapleMonsterStats getOriginalStats() {
        MonsterFamiliar a2;
        return MapleLifeFactory.getMonster(MapleItemInformationProvider.getInstance().getFamiliar((int)a2.g).mob).getStats();
    }

    @Override
    public /* synthetic */ void setFh(int a2) {
        a.d = (short)a2;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MonsterFamiliar a3;
        a2.sendPacket(MaplePacketCreator.spawnFamiliar(a3, true));
    }
}

