/*
 * Decompiled with CFR 0.150.
 */
package lottery;

import client.MapleCharacter;
import handling.channel.ChannelServer;
import java.util.Collection;
import server.maps.MapleMapFactory;

public interface Lottery {
    public /* synthetic */ Collection<MapleCharacter> getCharacters();

    public /* synthetic */ ChannelServer getChannelServer();

    public /* synthetic */ long getAllpeichu();

    public /* synthetic */ void setZjNum(int var1);

    public /* synthetic */ MapleMapFactory getMapleMapFactory();

    public /* synthetic */ void drawalottery();

    public /* synthetic */ void setCharacters(Collection<MapleCharacter> var1);

    public /* synthetic */ void setAllpeichu(long var1);

    public /* synthetic */ long getAlltouzhu();

    public /* synthetic */ int getTouNumbyType(int var1);

    public /* synthetic */ void doLottery();

    public /* synthetic */ void addChar(MapleCharacter var1);

    public /* synthetic */ void warp(int var1, MapleCharacter var2);

    public /* synthetic */ int getZjNum();

    public /* synthetic */ void setAlltouzhu(long var1);
}

