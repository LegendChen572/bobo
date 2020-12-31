/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61b6\u6200\u8c37
 */
package handling.world.family;

import FuckingHackerToby.fc;
import client.MapleCharacter;
import client.messages.CommandExecute;
import client.messages.commands.player.\u61b6\u6200\u8c37;
import constants.GameSetConstants;
import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import java.util.List;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.maps.MapleFoothold;
import tools.MaplePacketCreator;
import tools.Pair;

public class MapleFamilyBuff {
    private static final /* synthetic */ int[] B;
    private static final /* synthetic */ String[] d;
    private static final /* synthetic */ int[] k;
    private static final /* synthetic */ String[] a;
    private static final /* synthetic */ int[] g;
    private static final /* synthetic */ int[] K;
    private static final /* synthetic */ int E = 11;
    private static final /* synthetic */ List<MapleFamilyBuffEntry> ALLATORIxDEMO;

    public /* synthetic */ MapleFamilyBuff() {
        MapleFamilyBuff a2;
    }

    public static /* synthetic */ List<MapleFamilyBuffEntry> getBuffEntry() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ MapleFamilyBuffEntry getBuffEntry(int a2) {
        return ALLATORIxDEMO.get(a2);
    }

    public static /* synthetic */ {
        int n2;
        int[] arrn = new int[11];
        arrn[0] = 0;
        arrn[1] = 1;
        arrn[2] = 2;
        arrn[3] = 3;
        arrn[4] = 4;
        arrn[5] = 2;
        arrn[6] = 3;
        arrn[7] = 2;
        arrn[8] = 3;
        arrn[9] = 2;
        arrn[10] = 3;
        g = arrn;
        int[] arrn2 = new int[11];
        arrn2[0] = 0;
        arrn2[1] = 0;
        arrn2[2] = 15;
        arrn2[3] = 15;
        arrn2[4] = 30;
        arrn2[5] = 15;
        arrn2[6] = 15;
        arrn2[7] = 30;
        arrn2[8] = 30;
        arrn2[9] = 30;
        arrn2[10] = 30;
        B = arrn2;
        int[] arrn3 = new int[11];
        arrn3[0] = 0;
        arrn3[1] = 0;
        arrn3[2] = 150;
        arrn3[3] = 150;
        arrn3[4] = 200;
        arrn3[5] = 200;
        arrn3[6] = 200;
        arrn3[7] = 200;
        arrn3[8] = 200;
        arrn3[9] = 200;
        arrn3[10] = 200;
        k = arrn3;
        int[] arrn4 = new int[13];
        arrn4[0] = 0;
        arrn4[1] = 0;
        arrn4[2] = 300;
        arrn4[3] = 500;
        arrn4[4] = 700;
        arrn4[5] = 800;
        arrn4[6] = 1000;
        arrn4[7] = 1200;
        arrn4[8] = 1500;
        arrn4[9] = 2000;
        arrn4[10] = 2500;
        arrn4[11] = 4000;
        arrn4[12] = 5000;
        K = arrn4;
        String[] arrstring = new String[11];
        arrstring[0] = CommandExecute.ALLATORIxDEMO("\u7a9e\u524a\u79ae\u52a4\u81a6\u5bc7\u659a\u6261\u54b4");
        arrstring[1] = MapleFoothold.ALLATORIxDEMO("\u7a9b\u5267\u53bc\u55c6\u5be6\u6593\u6240\u54bd");
        arrstring[2] = CommandExecute.ALLATORIxDEMO("\u6260\u76d1\u63f8\u5ba3\u73f6d_`\u507c}@`Q\u5253\u9469|");
        arrstring[3] = MapleFoothold.ALLATORIxDEMO("\u624d\u76d4\u7dcf\u9a07\u5060are\u5051xme\u525a\u9448u");
        arrstring[4] = CommandExecute.ALLATORIxDEMO("\u5be3\u65be\u6245\u5490\u76d1\u5769\u7d05YfA\u5253\u9469|");
        arrstring[5] = MapleFoothold.ALLATORIxDEMO("\u6241\u76d8\u63d9\u5baa\u73d7|b\u5051xme\u525a\u9448u");
        arrstring[6] = CommandExecute.ALLATORIxDEMO("\u6244\u76f5\u7dc6\u9a26\u5069C\u5058YdD\u5253\u9469|");
        arrstring[7] = MapleFoothold.ALLATORIxDEMO("\u624d\u76d4\u63d5\u5ba6\u73dbb\u5051xo`\u525a\u9448u");
        arrstring[8] = CommandExecute.ALLATORIxDEMO("\u6244\u76f5\u7dc6\u9a26\u5069C\u5058YfA\u5253\u9469|");
        arrstring[9] = MapleFoothold.ALLATORIxDEMO("\u624d\u76d4\u96d6\u4f5d\u63d5\u5ba6\u73dbb\u5051");
        arrstring[10] = CommandExecute.ALLATORIxDEMO("\u6244\u76f5\u96df\u4f7c\u7dc6\u9a26\u5069C\u5058");
        a = arrstring;
        String[] arrstring2 = new String[11];
        arrstring2[0] = MapleFoothold.ALLATORIxDEMO("\u000b\u5c51\u8c31\u0001p\u81b6\u5da1V\u000b\u6514\u67cc\u0001p\u79a7\u5285\u526c\u60a3\u89dd\u76d4\u4e56\u7d8a\u5bea\u659f\u624c\u54b1\u621c\u5778\u576c\u5746\u305e");
        arrstring2[1] = CommandExecute.ALLATORIxDEMO("\u000e\u5c7c\u8c34,u@\u505e\u5bc7\u659a\u5c7c\u8c34{\u000e\u6539\u67c9,u\u539d\u55cf\u6376\u5bcf\u76f5\u4e5f\u7dab\u5be3\u65be\u6245\u5490\u5265\u819b\u5da4\u6231\u577d\u76f5\u5765\u5767\u3057");
        arrstring2[2] = MapleFoothold.ALLATORIxDEMO("\u000b\u5c51\u8c31\u0001p\u81b6\u5da1V\u000b\u661e\u95c3\u0001pme|\u5256\u9444~V\u000b\u6514\u67cc\u0001p\u7329\u6305\u6076\u7239\u76d8\u63d9\u5baa\u73d7\u638c\u5317|s?are\u5051sVz|\u59d2\u67c0\u6759\u4f23\u7578\u512a\u4e86\u52fc\u505d\u9045\u6518\u67c0\u5c57\u717d\u6518r");
        arrstring2[3] = CommandExecute.ALLATORIxDEMO("*\u5c58\u8c10\bQ\u81bf\u5d80_*\u6617\u95e2\bQdDu\u5277\u944d__*\u651d\u67ed\bQ\u7320\u6324\u607f\u7218\u76d1\u7de2\u9a02\u504d\u6385\u5336uR6@{D\u5058R_[u\u59f3\u67c9\u6778\u4f2a\u7559\u5123\u4ea7\u52f5\u507c\u904c\u6539\u67c9\u5c76\u7174\u6539{");
        arrstring2[4] = MapleFoothold.ALLATORIxDEMO("\u000b\u5c51\u8c31\u0001p\u81af\u5c41\u6755f\u5057\u6240\u54bd\u4eb5\u4e56\u5778\u7d86\u4e5aV\u000b\u661e\u95c3\u0001po`|\u5256\u9444\u3050V\u000b\u6514\u67cc\u0001p\u7329\u6305\u6076\u7239\u76d8\u63d9\u5baa\u73d7\u54d0\u7dc3\u9a0b\u506c\u638c\u5317|s?b\u5051sVz|\u59d2\u67c0\u6759\u4f23\u7578\u512a\u4e86\u52fc\u505d\u9045\u6518\u67c0\u5c57\u717d\u6518r");
        arrstring2[5] = CommandExecute.ALLATORIxDEMO("*\u5c58\u8c10\bQ\u81bf\u5d80_*\u6617\u95e2\bQdDu\u5277\u944d__*\u651d\u67ed\bQ\u7320\u6324\u607f\u7218\u76d1\u63f8\u5ba3\u73f6\u6385\u5336uR6C\u5058R_[u\u59f3\u67c9\u6778\u4f2a\u7559\u5123\u4ea7\u52f5\u507c\u904c\u6539\u67c9\u5c76\u7174\u6539{");
        arrstring2[6] = MapleFoothold.ALLATORIxDEMO("\u000b\u5c51\u8c31\u0001p\u81b6\u5da1V\u000b\u661e\u95c3\u0001pme|\u5256\u9444~V\u000b\u6514\u67cc\u0001p\u7329\u6305\u6076\u7239\u76d8\u7dc3\u9a0b\u506c\u638c\u5317|s?b\u5051sVz|\u59d2\u67c0\u6759\u4f23\u7578\u512a\u4e86\u52fc\u505d\u9045\u6518\u67c0\u5c57\u717d\u6518r");
        arrstring2[7] = CommandExecute.ALLATORIxDEMO("*\u5c58\u8c10\bQ\u81bf\u5d80_*\u6617\u95e2\bQfAu\u5277\u944d__*\u651d\u67ed\bQ\u7320\u6324\u607f\u7218\u76d1\u63f8\u5ba3\u73f6\u6385\u5336uR6C\u5058R_[u\u59f3\u67c9\u6778\u4f2a\u7559\u5123\u4ea7\u52f5\u507c\u904c\u6539\u67c9\u5c76\u7174\u6539{");
        arrstring2[8] = MapleFoothold.ALLATORIxDEMO("\u000b\u5c51\u8c31\u0001p\u81b6\u5da1V\u000b\u661e\u95c3\u0001po`|\u5256\u9444~V\u000b\u6514\u67cc\u0001p\u7329\u6305\u6076\u7239\u76d8\u7dc3\u9a0b\u506c\u638c\u5317|s?b\u5051sVz|\u59d2\u67c0\u6759\u4f23\u7578\u512a\u4e86\u52fc\u505d\u9045\u6518\u67c0\u5c57\u717d\u6518r");
        arrstring2[9] = CommandExecute.ALLATORIxDEMO("*\u5c58\u8c10\bQ\u6244\u76f5\u96df\u4f7c_*\u6617\u95e2\bQfAu\u5277\u944d__*\u651d\u67ed\bQ\u5459\u4e71\u5f60\u5741\u5743\u5116\u76d1\u6231\u5c39\u96fb\u4f58\u6261\u54b4\u63f8\u5ba3\u73f6\u6385\u5336uR6C\u5058R_[u\u59f3\u67c9\u6778\u4f2a\u7559\u5123\u4ea7\u52f5\u507c\u904c\u6539\u67c9\u5c76\u7174\u6539{");
        arrstring2[10] = MapleFoothold.ALLATORIxDEMO("\u000b\u5c51\u8c31\u0001p\u624d\u76d4\u96d6\u4f5dV\u000b\u661e\u95c3\u0001po`|\u5256\u9444~V\u000b\u6514\u67cc\u0001p\u5450\u4e50\u5f69\u5760\u574a\u5137\u76d8\u6210\u5c30\u96da\u4f51\u6240\u54bd\u7dc3\u9a0b\u506c\u638c\u5317|s?b\u5051sVz|\u59d2\u67c0\u6759\u4f23\u7578\u512a\u4e86\u52fc\u505d\u9045\u6518\u67c0\u5c57\u717d\u6518r");
        d = arrstring2;
        ALLATORIxDEMO = new ArrayList<MapleFamilyBuffEntry>();
        int n3 = n2 = 0;
        while (n3 < 11) {
            int n4 = n2;
            ALLATORIxDEMO.add(new MapleFamilyBuffEntry(n4, a[n2], d[n4], 1, K[n2], g[n2], 190000 + n2, B[n2], k[n2++]));
            n3 = n2;
        }
    }

    public static class MapleFamilyBuffEntry {
        public /* synthetic */ String desc;
        public /* synthetic */ int type;
        public /* synthetic */ int index;
        public /* synthetic */ String name;
        public /* synthetic */ int duration;
        public /* synthetic */ int questID;
        public /* synthetic */ List<Pair<MapleBuffStat, Integer>> effectsV2;
        public /* synthetic */ int rep;
        public /* synthetic */ List<Pair<MapleBuffStat, Integer>> effects;
        public /* synthetic */ int effect;
        public /* synthetic */ int count;

        public final /* synthetic */ List<Pair<MapleBuffStat, Integer>> getEffects() {
            MapleFamilyBuffEntry a2;
            ArrayList<Pair<MapleBuffStat, Integer>> arrayList = new ArrayList<Pair<MapleBuffStat, Integer>>();
            switch (a2.type) {
                case 2: {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList2 = arrayList;
                    while (false) {
                    }
                    arrayList2.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DROP_RATE, a2.effect));
                    arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MESO_RATE, a2.effect));
                    return arrayList2;
                }
                case 3: {
                    if (MapleItemInformationProvider.getInstance().getItemEffect(2450000).getExpBuffAdd() > 0) {
                        ArrayList<Pair<MapleBuffStat, Integer>> arrayList3 = arrayList;
                        arrayList3.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.EXPRATE_ADD, a2.effect));
                        return arrayList3;
                    }
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList4 = arrayList;
                    arrayList4.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.EXPRATE, a2.effect));
                    return arrayList4;
                }
                case 4: {
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList5;
                    ArrayList<Pair<MapleBuffStat, Integer>> arrayList6 = arrayList;
                    if (MapleItemInformationProvider.getInstance().getItemEffect(2450000).getExpBuffAdd() > 0) {
                        arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.EXPRATE_ADD, a2.effect));
                        arrayList5 = arrayList;
                    } else {
                        arrayList6.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.EXPRATE, a2.effect));
                        arrayList5 = arrayList;
                    }
                    arrayList5.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.DROP_RATE, a2.effect));
                    arrayList.add(new Pair<MapleBuffStat, Integer>(MapleBuffStat.MESO_RATE, a2.effect));
                }
            }
            return arrayList;
        }

        public /* synthetic */ void applyTo(MapleCharacter a2) {
            MapleFamilyBuffEntry a3;
            if (GameSetConstants.SERVER_NAME.equals(\u61b6\u6200\u8c37.ALLATORIxDEMO((String)"\u51ba\u82b6\u8c3d"))) {
                a2.dropMessage(fc.ALLATORIxDEMO("\u76f9\u521f\u5ba1\u659dU\u0007Q\u0014\u95cb\u95db\u7dba\u4fbc\u4e3a\u3050"));
                return;
            }
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.giveBuff(-a3.getEffectId(), a3.duration * 60000, a3.effects, null, a2));
            MapleStatEffect mapleStatEffect = MapleItemInformationProvider.getInstance().getItemEffect(a3.getEffectId());
            mapleCharacter.cancelEffect(mapleStatEffect, true, -1L, a3.effects);
            long l2 = System.currentTimeMillis();
            MapleFamilyBuffEntry mapleFamilyBuffEntry = a3;
            mapleCharacter.registerEffect(mapleStatEffect, l2, mapleFamilyBuffEntry.effects, mapleFamilyBuffEntry.duration * 60000, a2.getId());
        }

        /*
         * Enabled aggressive block sorting
         */
        public /* synthetic */ int getEffectId() {
            MapleFamilyBuffEntry a2;
            switch (a2.type) {
                case 2: {
                    return 2022463;
                }
                case 3: {
                    return 2450000;
                }
            }
            return 2022332;
        }

        public /* synthetic */ MapleFamilyBuffEntry(int a2, String a3, String a4, int a5, int a6, int a7, int a8, int a9, int a10) {
            MapleFamilyBuffEntry a11;
            MapleFamilyBuffEntry mapleFamilyBuffEntry = a11;
            MapleFamilyBuffEntry mapleFamilyBuffEntry2 = a11;
            MapleFamilyBuffEntry mapleFamilyBuffEntry3 = a11;
            MapleFamilyBuffEntry mapleFamilyBuffEntry4 = a11;
            a11.name = a3;
            mapleFamilyBuffEntry4.desc = a4;
            mapleFamilyBuffEntry4.count = a5;
            mapleFamilyBuffEntry3.rep = a6;
            mapleFamilyBuffEntry3.type = a7;
            mapleFamilyBuffEntry2.questID = a8;
            mapleFamilyBuffEntry2.index = a2;
            a11.duration = a9;
            mapleFamilyBuffEntry.effect = a10;
            mapleFamilyBuffEntry.effects = a11.getEffects();
        }
    }
}

