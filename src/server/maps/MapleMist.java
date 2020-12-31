/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.SkillFactory;
import java.awt.Point;
import java.awt.Rectangle;
import server.MapleStatEffect;
import server.life.MapleMonster;
import server.life.MobSkill;
import server.maps.AbstractMapleMapObject;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;

public class MapleMist
extends AbstractMapleMapObject {
    private /* synthetic */ int K;
    private /* synthetic */ boolean H;
    private /* synthetic */ boolean e;
    private /* synthetic */ int a;
    private /* synthetic */ Point ALLATORIxDEMO;
    private /* synthetic */ Rectangle I;
    private /* synthetic */ boolean g;
    private /* synthetic */ int d;
    private /* synthetic */ MapleStatEffect F;
    private /* synthetic */ boolean E;
    private /* synthetic */ boolean B;
    private /* synthetic */ int k;
    private /* synthetic */ MobSkill C;

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.MIST;
    }

    public /* synthetic */ ISkill getSourceSkill() {
        MapleMist a2;
        return SkillFactory.getSkill(a2.F.getSourceId());
    }

    public /* synthetic */ MapleStatEffect getSource() {
        MapleMist a2;
        return a2.F;
    }

    public /* synthetic */ int getSkillLevel() {
        MapleMist a2;
        return a2.K;
    }

    public /* synthetic */ boolean isBuffMist() {
        MapleMist a2;
        return a2.B;
    }

    public /* synthetic */ int getSkillDelay() {
        MapleMist a2;
        return a2.k;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ MapleMist(Rectangle a2, MapleCharacter a3, MapleStatEffect a4, Point a5) {
        MapleMist a6;
        MapleMist mapleMist = a6;
        MapleMist mapleMist2 = a6;
        mapleMist2.I = a2;
        mapleMist2.a = a3.getId();
        mapleMist.F = a4;
        mapleMist.k = 8;
        a6.H = false;
        a6.K = a3.getSkillLevel(SkillFactory.getSkill(a4.getSourceId()));
        if (a6.K == 0 && a3.containsBindingBySkillid(a4.getSourceId())) {
            a6.K = 1;
        }
        a6.ALLATORIxDEMO = a5;
        switch (a4.getSourceId()) {
            case 24120055: 
            case 24121052: {
                MapleMist mapleMist3 = a6;
                mapleMist3.H = false;
                mapleMist3.E = false;
                a6.k = 16;
                return;
            }
        }
    }

    public /* synthetic */ void setMistType(int a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ Point getPosition() {
        MapleMist a2;
        return a2.I.getLocation();
    }

    public /* synthetic */ boolean isMonsterStatMist() {
        MapleMist a2;
        return a2.g;
    }

    public /* synthetic */ MapleMist(Rectangle a2, MapleCharacter a3) {
        MapleMist a4;
        MapleMist mapleMist = a4;
        MapleMist mapleMist2 = a4;
        MapleMist mapleMist3 = a4;
        mapleMist3.I = a2;
        mapleMist3.a = a3.getId();
        mapleMist3.F = new MapleStatEffect();
        a4.F.setSourceId(2111003);
        mapleMist2.K = 30;
        mapleMist2.H = false;
        mapleMist.d = false ? 1 : 0;
        mapleMist.k = 8;
    }

    public /* synthetic */ byte[] fakeSpawnData(int a2) {
        MapleMist a3;
        return MaplePacketCreator.spawnMist(a3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ MapleMist(Rectangle a2, MapleCharacter a3, MapleStatEffect a4) {
        MapleMist a5;
        MapleMist mapleMist = a5;
        MapleMist mapleMist2 = a5;
        mapleMist2.I = a2;
        mapleMist2.a = a3.getId();
        mapleMist.F = a4;
        mapleMist.k = 8;
        a5.H = false;
        a5.K = a3.getSkillLevel(SkillFactory.getSkill(a4.getSourceId()));
        if (a5.K == 0 && a3.containsBindingBySkillid(a4.getSourceId())) {
            a5.K = 1;
        }
        switch (a4.getSourceId()) {
            case 4121015: {
                a5.g = true;
                a5.d = true ? 1 : 0;
                return;
            }
            case 1076: 
            case 2111003: 
            case 12111005: 
            case 14111006: 
            case 61121105: {
                a5.E = true;
                a5.d = true ? 1 : 0;
                return;
            }
            case 22161003: {
                a5.e = true;
                a5.d = true ? 1 : 0;
                return;
            }
            case 35121010: {
                a5.B = true;
                a5.d = true ? 1 : 0;
                return;
            }
            case 4221006: 
            case 32121006: {
                a5.d = 2;
                return;
            }
        }
    }

    public /* synthetic */ Rectangle getBox() {
        MapleMist a2;
        return a2.I;
    }

    @Override
    public /* synthetic */ void setPosition(Point a2) {
    }

    public /* synthetic */ boolean isPoisonMist() {
        MapleMist a2;
        return a2.E;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleMist a3;
        a2.sendPacket(MaplePacketCreator.removeMist(a3.getObjectId(), false));
    }

    public /* synthetic */ MobSkill getMobSkill() {
        MapleMist a2;
        return a2.C;
    }

    public /* synthetic */ boolean makeChanceResult() {
        MapleMist a2;
        return a2.F.makeChanceResult();
    }

    public /* synthetic */ int getMistType() {
        MapleMist a2;
        return a2.d;
    }

    public /* synthetic */ boolean isMobMist() {
        MapleMist a2;
        return a2.H;
    }

    public /* synthetic */ int getOwnerId() {
        MapleMist a2;
        return a2.a;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleMist a3;
        a2.sendPacket(MaplePacketCreator.spawnMist(a3));
    }

    public /* synthetic */ MapleMist(Rectangle a2, MapleMonster a3, MobSkill a4) {
        MapleMist a5;
        MapleMist mapleMist = a5;
        MapleMist mapleMist2 = a5;
        MapleMist mapleMist3 = a5;
        mapleMist3.I = a2;
        mapleMist3.a = a3.getId();
        a5.C = a4;
        mapleMist2.K = a5.C.getSkillLevel();
        mapleMist2.d = 0;
        mapleMist.H = true;
        mapleMist.k = 0;
    }

    public /* synthetic */ boolean isRecovery() {
        MapleMist a2;
        return a2.e;
    }
}

