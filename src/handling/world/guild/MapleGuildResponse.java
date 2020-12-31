/*
 * Decompiled with CFR 0.150.
 */
package handling.world.guild;

import client.SummonSkillEntry;
import constants.GameSetConstants;
import server.gashapon.GashaponRewardSpecial;
import tools.MaplePacketCreator;

public final class MapleGuildResponse
extends Enum<MapleGuildResponse> {
    private final /* synthetic */ int d;
    private static final /* synthetic */ MapleGuildResponse[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ MapleGuildResponse NOT_IN_CHANNEL;
    public static final /* synthetic */ /* enum */ MapleGuildResponse NOT_IN_GUILD;
    public static final /* synthetic */ /* enum */ MapleGuildResponse ALREADY_IN_GUILD;

    /*
     * WARNING - Possible parameter corruption
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private /* synthetic */ MapleGuildResponse(int varnull) {
        super((String)var1_-1, (int)var2_-1);
        if (GameSetConstants.MAPLE_VERSION < 134) ** GOTO lbl-1000
        switch (a) {
            case 42: {
                a = 48;
                v0 = a;
                break;
            }
            case 40: {
                a = 46;
                v0 = a;
                break;
            }
            case 45: {
                a = 51;
            }
            default: lbl-1000:
            // 2 sources

            {
                v0 = a;
            }
        }
        v0.d = a;
    }

    public static /* synthetic */ MapleGuildResponse valueOf(String a2) {
        return Enum.valueOf(MapleGuildResponse.class, a2);
    }

    public static /* synthetic */ MapleGuildResponse[] values() {
        return (MapleGuildResponse[])ALLATORIxDEMO.clone();
    }

    public /* synthetic */ byte[] getPacket() {
        MapleGuildResponse a2;
        return MaplePacketCreator.genericGuildMessage((byte)a2.d);
    }

    public /* synthetic */ int getValue() {
        MapleGuildResponse a2;
        return a2.d;
    }

    public static /* synthetic */ {
        NOT_IN_CHANNEL = new MapleGuildResponse(SummonSkillEntry.ALLATORIxDEMO("E|_lB}TpCrE}N\u007f"), 0, 42);
        ALREADY_IN_GUILD = new MapleGuildResponse(GashaponRewardSpecial.ALLATORIxDEMO("EkVbEc]xMi[`QnHc"), 1, 40);
        NOT_IN_GUILD = new MapleGuildResponse(SummonSkillEntry.ALLATORIxDEMO("E|_lB}Tt^zGw"), 2, 45);
        MapleGuildResponse[] arrmapleGuildResponse = new MapleGuildResponse[3];
        arrmapleGuildResponse[0] = NOT_IN_CHANNEL;
        arrmapleGuildResponse[1] = ALREADY_IN_GUILD;
        arrmapleGuildResponse[2] = NOT_IN_GUILD;
        ALLATORIxDEMO = arrmapleGuildResponse;
    }
}

