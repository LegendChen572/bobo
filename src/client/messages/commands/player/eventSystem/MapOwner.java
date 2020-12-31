/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package client.messages.commands.player.eventSystem;

import client.MapleCharacter;
import client.MapleClient;
import client.messages.CommandExecute;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import constants.MapConstants;
import constants.MobConstants;
import constants.ServerConstants;
import server.life.MapleMonster;
import server.maps.MapleMapObject;
import tools.wztosql.DumpMapName;

public class MapOwner {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 3 << 3 ^ 5;
        int n5 = n3;
        int n6 = 4 << 4 ^ 4 << 1;
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

    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6;
    }

    public /* synthetic */ MapOwner() {
        MapOwner a2;
    }

    public static class OwnMap
    extends CommandExecute {
        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public /* synthetic */ boolean execute(MapleClient a, String[] a) {
            a = a.getPlayer();
            var3_3 = a.getMapId();
            var4_5 = true;
            var5_6 = "";
            if (MapConstants.isBossMap(var3_3) || MapConstants.isEventMap(var3_3)) {
                var4_5 = false;
                var5_6 = DumpMapName.ALLATORIxDEMO("\u609e\u76bd\u527b\u76d7\u5706\u5745\u708c\u73d8\u5720\u007f\u7117\u6c86\u64f7\u675a\u5706\u5745\u6b3cr");
            }
            var3_4 = a.getMap().getAllMonstersThreadsafe().iterator();
            while (var3_4.hasNext()) {
                var6_7 = (MapleMonster)((MapleMapObject)var3_4.next());
                if (!var6_7.getStats().isBoss() || MobConstants.isReincarnationMob(var6_7.getId())) continue;
                var4_5 = false;
                var5_6 = \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u60d5\u76a4\u5230\u76ce\u574d\u575c\u70c7\u73c1\u576bf\u715c\u6c9f\u64bc\u6743\u574d\u575c\u6b77k");
            }
            if (!a.getMap().getBelongsToSomeone()) ** GOTO lbl25
            if (a.getMap().getBelongsTo() == a.getId()) {
                var4_5 = false;
                a.getMap().setBelongsTo(null);
                var5_6 = DumpMapName.ALLATORIxDEMO("\u5dc4\u5385\u6dbe\u5745\u6b3cr");
                v0 = var4_5;
            } else {
                var4_5 = false;
                var5_6 = "\u76ee\u524d\u6b64\u5730\u5716\u5df2\u6709\u64c1\u6709\u8005,\u64c1\u6709\u8005\u70ba: " + MapleCharacter.getCharacterNameById(a.getMap().getBelongsTo()) + " !";
lbl25:
                // 2 sources

                v0 = var4_5;
            }
            if (v0) {
                v1 = a;
                v2 = a;
                v1.getMap().setBelongsTo((MapleCharacter)v2);
                v1.dropMessageAll("\u5df2\u8a2d\u5b9a\u5b8c\u6210\u6b64\u5730\u5716\u64c1\u6709\u6b0a,\u64c1\u6709\u8005\u70ba:" + MapleCharacter.getCharacterNameById(v2.getMap().getBelongsTo()));
                return true;
            }
            a.dropMessageAll((String)var5_6);
            return true;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"2=\u0013\u0007\u001c:]g]\u95c1R\u9596\u95f4\u577a\u576b\u648b\u6774\u6b40\u7c86\u7d3b");
        }

        public /* synthetic */ OwnMap() {
            OwnMap a2;
        }
    }
}

