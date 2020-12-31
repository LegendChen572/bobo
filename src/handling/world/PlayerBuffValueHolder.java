/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import handling.opcodes.MapleBuffStat;
import java.io.Serializable;
import java.util.List;
import server.MapleStatEffect;
import tools.Pair;

public class PlayerBuffValueHolder
implements Serializable {
    public /* synthetic */ int localDuration;
    public /* synthetic */ long startTime;
    public /* synthetic */ MapleStatEffect effect;
    public /* synthetic */ int cid;
    public /* synthetic */ List<Pair<MapleBuffStat, Integer>> statup;
    private static final /* synthetic */ long ALLATORIxDEMO = 9179541993413738569L;

    public /* synthetic */ PlayerBuffValueHolder(long a2, MapleStatEffect a3, List<Pair<MapleBuffStat, Integer>> a4, int a5, int a6) {
        PlayerBuffValueHolder a7;
        PlayerBuffValueHolder playerBuffValueHolder = a7;
        PlayerBuffValueHolder playerBuffValueHolder2 = a7;
        a7.startTime = a2;
        playerBuffValueHolder2.effect = a3;
        playerBuffValueHolder2.statup = a4;
        playerBuffValueHolder.localDuration = a5;
        playerBuffValueHolder.cid = a6;
    }
}

