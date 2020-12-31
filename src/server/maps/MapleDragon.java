/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import server.maps.AbstractAnimatedMapleMapObject;
import server.maps.MapleMapObjectType;
import tools.MaplePacketCreator;
import tools.html.getHtml;

public class MapleDragon
extends AbstractAnimatedMapleMapObject {
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int d;

    public /* synthetic */ int getOwner() {
        MapleDragon a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ void sendSpawnData(MapleClient a2) {
        MapleDragon a3;
        a2.sendPacket(MaplePacketCreator.spawnDragon(a3));
    }

    @Override
    public /* synthetic */ MapleMapObjectType getType() {
        return MapleMapObjectType.SUMMON;
    }

    public /* synthetic */ MapleDragon(MapleCharacter a2) {
        MapleDragon a3;
        a3.d = a2.getId();
        a3.ALLATORIxDEMO = a2.getJob();
        if (a3.ALLATORIxDEMO < 2200 || a3.ALLATORIxDEMO > 2218) {
            throw new RuntimeException(getHtml.ALLATORIxDEMO("?x\u0012c\u0005mK~\u0004*\bx\u000ek\u001foKkKn\u0019k\fe\u0005*\re\u0019*\n*\u0005e\u0005'.|\nd"));
        }
        a3.setPosition(a2.getTruePosition());
        a3.setStance(4);
    }

    public /* synthetic */ int getJobId() {
        MapleDragon a2;
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ void sendDestroyData(MapleClient a2) {
        MapleDragon a3;
        a2.sendPacket(MaplePacketCreator.removeDragon(a3.d));
    }
}

