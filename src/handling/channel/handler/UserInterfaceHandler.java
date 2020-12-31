/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleClient;
import scripting.npc.NPCScriptManager;
import tools.data.LittleEndianAccessor;

public class UserInterfaceHandler {
    public static final /* synthetic */ void InGamePoll(LittleEndianAccessor a2, MapleClient a3) {
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ 3;
        int cfr_ignored_0 = (3 ^ 5) << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 4;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ UserInterfaceHandler() {
        UserInterfaceHandler a2;
    }

    public static final /* synthetic */ void CygnusSummonNPCRequest(MapleClient a2) {
        if (a2.getPlayer().getJob() == 2000) {
            NPCScriptManager.getInstance().start(a2, 1202000);
            return;
        }
        if (a2.getPlayer().getJob() == 1000) {
            NPCScriptManager.getInstance().start(a2, 1101008);
        }
    }
}

