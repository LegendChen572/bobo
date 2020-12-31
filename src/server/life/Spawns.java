/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import java.awt.Point;
import server.life.MapleMonster;
import server.maps.MapleMap;

public abstract class Spawns {
    public abstract /* synthetic */ Point getPosition();

    public /* synthetic */ Spawns() {
        Spawns a2;
    }

    public abstract /* synthetic */ MapleMonster getMonster();

    public abstract /* synthetic */ int getCarnivalId();

    public abstract /* synthetic */ byte getCarnivalTeam();

    public abstract /* synthetic */ boolean shouldSpawn(MapleMap var1);

    public abstract /* synthetic */ int getFh();

    public abstract /* synthetic */ MapleMonster spawnMonster(MapleMap var1);

    public abstract /* synthetic */ int getMobTime();
}

