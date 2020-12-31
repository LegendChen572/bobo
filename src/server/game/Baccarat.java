/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u672a\u77e5\u8c37
 *  client.messages.commands.player.\u6bcd\u6e6f\u8c37
 */
package server.game;

import client.MapleCharacter;
import client.MapleFriendship;
import client.MapleLieDetector;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.\u672a\u77e5\u8c37;
import client.messages.commands.player.\u6bcd\u6e6f\u8c37;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.world.MapleParty;
import handling.world.World;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.MapleItemInformationProvider;
import server.characterCards.MapleCharacterCards;
import server.maps.Event_PyramidSubway;
import server.maps.MapleMap;
import tools.MaplePacketCreator;
import tools.Triple;

public class Baccarat {
    private static /* synthetic */ long E;
    private static /* synthetic */ long I;
    private static /* synthetic */ long C;
    private static /* synthetic */ long k;
    private static /* synthetic */ List<GameSet> m;
    private static /* synthetic */ long e;
    private static /* synthetic */ long f;
    private static /* synthetic */ long A;
    private static /* synthetic */ long g;
    private static /* synthetic */ boolean l;
    private static /* synthetic */ long h;
    private static /* synthetic */ Card[] d;
    private static /* synthetic */ long F;
    private static /* synthetic */ long i;
    private static /* synthetic */ long J;
    private static /* synthetic */ boolean c;
    private static /* synthetic */ Map<Integer, Triple<GameSet, String, Integer>> G;
    private static /* synthetic */ long j;
    private static /* synthetic */ long K;
    private static /* synthetic */ long D;
    private static /* synthetic */ long a;
    private static /* synthetic */ long H;
    private static /* synthetic */ double ALLATORIxDEMO;
    private static /* synthetic */ long B;
    private static /* synthetic */ long L;
    private static /* synthetic */ long M;
    private static final /* synthetic */ Baccarat b;

    public /* synthetic */ String getGMInfo(MapleCharacter a2) {
        if (((MapleCharacter)a2).isGM()) {
            a2 = new StringBuilder();
            ((StringBuilder)a2).append(Event_PyramidSubway.ALLATORIxDEMO("y@g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019gc\u0017\u984b\u7960\u8a2e\u6035\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019W."));
            ((StringBuilder)a2).append("\u7576\u524d\u6b64\u5c40\u6953\u5e63\u6295\u6ce8\u984d \u838a\u5bb6: " + g + " \u5143  \u9592\u5bb6: " + F + " \u5143\r\n");
            ((StringBuilder)a2).append("\u7576\u524d\u6b64\u5c40\u6953\u9ede\u6295\u6ce8\u984d \u838a\u5bb6: " + a + " \u9ede  \u9592\u5bb6: " + E + " \u9ede\r\n");
            ((StringBuilder)a2).append("\u7576\u524d\u6b64\u5c40GASH\u6295\u6ce8\u984d \u838a\u5bb6: " + K + " \u9ede  \u9592\u5bb6: " + e + " \u9ede\r\n");
            ((StringBuilder)a2).append("\u7576\u524d\u6b64\u5c40\u7d05\u5229\u6295\u6ce8\u984d \u838a\u5bb6: " + B + " \u9ede  \u9592\u5bb6: " + C + " \u9ede\r\n");
            ((StringBuilder)a2).append("\u7576\u524d\u6b64\u5c40\u8ced\u535a\u6295\u6ce8\u984d \u838a\u5bb6: " + k + " \u9ede  \u9592\u5bb6: " + H + " \u9ede\r\n");
            ((StringBuilder)a2).append(MapleCharacterCards.ALLATORIxDEMO("!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!y!Y\u0006"));
            ((StringBuilder)a2).append("\u672c\u65e5\u7576\u524d\u8ced\u535a\u7cfb\u7d71" + (j > 0L ? Event_PyramidSubway.ALLATORIxDEMO("\u8cc4\u51a0\u0004") : MapleCharacterCards.ALLATORIxDEMO("\u737e\u527d,")) + Math.abs(j) + " \u6953\u5e63!\r\n");
            ((StringBuilder)a2).append("\u672c\u65e5\u7576\u524d\u8ced\u535a\u7cfb\u7d71" + (I > 0L ? Event_PyramidSubway.ALLATORIxDEMO("\u8cc4\u51a0\u0004") : MapleCharacterCards.ALLATORIxDEMO("\u737e\u527d,")) + Math.abs(I) + " \u6953\u9ede!\r\n");
            ((StringBuilder)a2).append("\u672c\u65e5\u7576\u524d\u8ced\u535a\u7cfb\u7d71" + (M > 0L ? Event_PyramidSubway.ALLATORIxDEMO("\u8cc4\u51a0\u0004") : MapleCharacterCards.ALLATORIxDEMO("\u737e\u527d,")) + Math.abs(M) + " GASH!\r\n");
            ((StringBuilder)a2).append("\u672c\u65e5\u7576\u524d\u8ced\u535a\u7cfb\u7d71" + (i > 0L ? Event_PyramidSubway.ALLATORIxDEMO("\u8cc4\u51a0\u0004") : MapleCharacterCards.ALLATORIxDEMO("\u737e\u527d,")) + Math.abs(i) + " \u7d05\u5229!\r\n");
            ((StringBuilder)a2).append(Event_PyramidSubway.ALLATORIxDEMO("y@g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019g\u0019W."));
            return ((StringBuilder)a2).toString();
        }
        return "";
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, String a3, int a4) {
        int n2;
        block14: {
            int n3 = -1;
            switch (a3.hashCode()) {
                case 860016: {
                    if (!a3.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u5e6f"))) break;
                    n2 = n3 = 0;
                    break block14;
                }
                case 1013188: {
                    if (!a3.equals("\u7d05\u5229")) break;
                    n2 = n3 = 1;
                    break block14;
                }
                case 1139725: {
                    if (!a3.equals(Event_PyramidSubway.ALLATORIxDEMO("\u8cb7\u537e"))) break;
                    n2 = n3 = 2;
                    break block14;
                }
                case 2180271: {
                    if (!a3.equals(MapleCharacterCards.ALLATORIxDEMO("\u0013M\u0007D"))) break;
                    n2 = n3 = 3;
                    break block14;
                }
                case 876523: {
                    if (!a3.equals(Event_PyramidSubway.ALLATORIxDEMO("\u6909\u9efa"))) break;
                    n3 = 4;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                a2.gainMeso(a4, true);
                return;
            }
            case 1: {
                MapleCharacter mapleCharacter = a2;
                mapleCharacter.setPoints(mapleCharacter.getPoints() + a4);
                return;
            }
            case 2: {
                MapleCharacter mapleCharacter = a2;
                mapleCharacter.setVPoints(mapleCharacter.getVPoints() + a4);
                return;
            }
            case 3: {
                a2.modifyCSPoints(true ? 1 : 0, a4, true);
                return;
            }
            case 4: {
                a2.modifyCSPoints(2, a4, true);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void l(String a2, int a3) {
        int n2;
        block14: {
            int n3 = 0;
            n3 = -1;
            switch (a2.hashCode()) {
                case 860016: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u5e6f"))) break;
                    n2 = n3 = 0;
                    break block14;
                }
                case 1013188: {
                    if (!a2.equals("\u7d05\u5229")) break;
                    n2 = n3 = 1;
                    break block14;
                }
                case 1139725: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u8cb7\u537e"))) break;
                    n2 = n3 = 2;
                    break block14;
                }
                case 2180271: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u0013M\u0007D"))) break;
                    n2 = n3 = 3;
                    break block14;
                }
                case 876523: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u6909\u9efa"))) break;
                    n3 = 4;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                g += (long)a3;
                return;
            }
            case 1: {
                B += (long)a3;
                return;
            }
            case 2: {
                k += (long)a3;
                return;
            }
            case 3: {
                K += (long)a3;
                return;
            }
            case 4: {
                a += (long)a3;
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ int ALLATORIxDEMO(MapleCharacter a2, String a3) {
        int n2;
        int n3;
        block14: {
            n3 = 0;
            int n4 = -1;
            switch (a3.hashCode()) {
                case 860016: {
                    if (!a3.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u5e6f"))) break;
                    n2 = n4 = 0;
                    break block14;
                }
                case 1013188: {
                    if (!a3.equals("\u7d05\u5229")) break;
                    n2 = n4 = 1;
                    break block14;
                }
                case 2180271: {
                    if (!a3.equals(Event_PyramidSubway.ALLATORIxDEMO("\u001de\tl"))) break;
                    n2 = n4 = 2;
                    break block14;
                }
                case 876523: {
                    if (!a3.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u9ed2"))) break;
                    n2 = n4 = 3;
                    break block14;
                }
                case 1139725: {
                    if (!a3.equals(Event_PyramidSubway.ALLATORIxDEMO("\u8cb7\u537e"))) break;
                    n4 = 4;
                }
            }
            n2 = n4;
        }
        switch (n2) {
            case 0: {
                return a2.getMeso();
            }
            case 1: {
                return a2.getPoints();
            }
            case 2: {
                return a2.getCSPoints(1);
            }
            case 3: {
                return a2.getCSPoints(2);
            }
            case 4: {
                return a2.getVPoints();
            }
        }
        return n3;
    }

    private /* synthetic */ void ALLATORIxDEMO(GameSet a2) {
        MapleMap mapleMap = ChannelServer.getInstance(0, GameSetConstants.BACCARAT_LOCATION[0]).getMapFactory().getMap(GameSetConstants.BACCARAT_LOCATION[1]);
        for (Map.Entry<Integer, Triple<GameSet, String, Integer>> entry : G.entrySet()) {
            Baccarat a3;
            MapleCharacter mapleCharacter = MapleCharacter.getOnlineCharacterById(entry.getKey());
            if (mapleCharacter == null) continue;
            GameSet gameSet = entry.getValue().getLeft();
            int n2 = entry.getValue().getRight();
            entry = entry.getValue().getMid();
            if (a2 == gameSet) {
                if (n2 <= 0) continue;
                int n3 = (int)((double)n2 * a2.getOdds());
                Baccarat baccarat = a3;
                MapleCharacter mapleCharacter2 = mapleCharacter;
                a3.ALLATORIxDEMO(mapleCharacter2, (String)((Object)entry), n2);
                baccarat.ALLATORIxDEMO(mapleCharacter2, (String)((Object)entry), n3);
                baccarat.ALLATORIxDEMO((String)((Object)entry), n3);
                mapleCharacter.dropMessageAll("\u4f60\u8d0f\u4e86! \u6b64\u5c40\u70ba " + a2.getName() + " \u8d0f,\u60a8\u6b64\u5c40\u7684\u58d3\u6ce8\u70ba " + gameSet.getName() + ",\u8d0f\u5f97" + (String)((Object)entry) + " " + n3 + "!");
                if (mapleCharacter.isGM()) continue;
                mapleMap.broadcastMessage(MaplePacketCreator.getSkullSmega("[\u767e\u5bb6\u6a02] : \u606d\u559c\u73a9\u5bb6:" + mapleCharacter.getName() + " \u6b64\u5c40\u8d0f\u5f97" + (String)((Object)entry) + " " + n3 + " !", false, 2));
                continue;
            }
            if (a2 == GameSet.\u548c\u5c40) {
                MapleCharacter mapleCharacter3 = mapleCharacter;
                a3.ALLATORIxDEMO(mapleCharacter3, (String)((Object)entry), n2);
                mapleCharacter3.dropMessageAll("\u6b64\u5c40\u70ba\u548c\u5c40! \u9000\u56de\u60a8\u6b64\u5c40\u7684\u58d3\u6ce8 " + n2 + " " + (String)((Object)entry) + "!");
                continue;
            }
            a3.ALLATORIxDEMO((String)((Object)entry), -n2);
            mapleCharacter.dropMessageAll("\u4f60\u8f38\u4e86! \u6b64\u5c40\u70ba " + a2.getName() + " \u8d0f,\u60a8\u6b64\u5c40\u7684\u58d3\u6ce8\u70ba " + gameSet.getName() + " " + n2 + " " + (String)((Object)entry) + "!");
        }
    }

    public /* synthetic */ long getTotalMesoBet() {
        return A;
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(String a2, int a3) {
        int n2;
        block14: {
            int n3 = 0;
            n3 = -1;
            switch (a2.hashCode()) {
                case 860016: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u5e6f"))) break;
                    n2 = n3 = 0;
                    break block14;
                }
                case 1013188: {
                    if (!a2.equals("\u7d05\u5229")) break;
                    n2 = n3 = 1;
                    break block14;
                }
                case 2180271: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u001de\tl"))) break;
                    n2 = n3 = 2;
                    break block14;
                }
                case 876523: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u9ed2"))) break;
                    n2 = n3 = 3;
                    break block14;
                }
                case 1139725: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u8cb7\u537e"))) break;
                    n3 = 4;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                j += (long)a3;
                return;
            }
            case 1: {
                i += (long)a3;
                return;
            }
            case 2: {
                M += (long)a3;
                return;
            }
            case 3: {
                I += (long)a3;
                return;
            }
            case 4: {
                J += (long)a3;
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void H(String a2, int a3) {
        int n2;
        block14: {
            int n3 = 0;
            n3 = -1;
            switch (a2.hashCode()) {
                case 860016: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u5e6f"))) break;
                    n2 = n3 = 0;
                    break block14;
                }
                case 1013188: {
                    if (!a2.equals("\u7d05\u5229")) break;
                    n2 = n3 = 1;
                    break block14;
                }
                case 2180271: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u001de\tl"))) break;
                    n2 = n3 = 2;
                    break block14;
                }
                case 876523: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u9ed2"))) break;
                    n2 = n3 = 3;
                    break block14;
                }
                case 1139725: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u8cb7\u537e"))) break;
                    n3 = 4;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                A += (long)a3;
                return;
            }
            case 1: {
                f += (long)a3;
                return;
            }
            case 2: {
                D += (long)a3;
                return;
            }
            case 3: {
                L += (long)a3;
                return;
            }
            case 4: {
                h += (long)a3;
                return;
            }
        }
    }

    public static /* synthetic */ {
        G = new HashMap<Integer, Triple<GameSet, String, Integer>>();
        b = new Baccarat();
        c = true;
        l = false;
        m = new ArrayList<GameSet>();
        A = 0L;
        f = 0L;
        h = 0L;
        D = 0L;
        L = 0L;
        j = 0L;
        i = 0L;
        J = 0L;
        M = 0L;
        I = 0L;
        F = 0L;
        C = 0L;
        H = 0L;
        e = 0L;
        E = 0L;
        g = 0L;
        B = 0L;
        k = 0L;
        K = 0L;
        a = 0L;
        d = null;
        ALLATORIxDEMO = GameSetConstants.BACCARAT_LIMIT_RATE;
    }

    public /* synthetic */ String getCards() {
        Baccarat a2;
        Poke poke;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        int n3 = 0;
        int n4 = 6;
        Poke poke2 = poke = new Poke(a2);
        poke2.shuffle();
        Card[] arrcard = poke2.draw(n4);
        n2 += arrcard[0].getValue() + arrcard[1].getValue();
        n3 += arrcard[2].getValue() + arrcard[3].getValue();
        if ((n2 %= 10) < 8 && (n3 %= 10) < 8) {
            if (n2 <= 5) {
                n2 += arrcard[4].getValue();
            }
            if (n3 <= 5) {
                n3 += arrcard[5].getValue();
            }
            n2 %= 10;
            n3 %= 10;
        }
        d = arrcard;
        stringBuilder.append("\u4e0b\u76e4\u958b\u724c\u7d50\u679c:\u838a\u5bb6\u9ede\u6578\u2192" + n2 + "\u9ede \u9592\u5bb6\u9ede\u6578\u2192" + n3 + "\u9ede");
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void D(String a2, int a3) {
        int n2;
        block14: {
            int n3 = 0;
            n3 = -1;
            switch (a2.hashCode()) {
                case 860016: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u6907\u5e6f"))) break;
                    n2 = n3 = 0;
                    break block14;
                }
                case 1013188: {
                    if (!a2.equals("\u7d05\u5229")) break;
                    n2 = n3 = 1;
                    break block14;
                }
                case 1139725: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u8cb7\u537e"))) break;
                    n2 = n3 = 2;
                    break block14;
                }
                case 2180271: {
                    if (!a2.equals(MapleCharacterCards.ALLATORIxDEMO("\u0013M\u0007D"))) break;
                    n2 = n3 = 3;
                    break block14;
                }
                case 876523: {
                    if (!a2.equals(Event_PyramidSubway.ALLATORIxDEMO("\u6909\u9efa"))) break;
                    n3 = 4;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                F += (long)a3;
                return;
            }
            case 1: {
                C += (long)a3;
                return;
            }
            case 2: {
                H += (long)a3;
                return;
            }
            case 3: {
                e += (long)a3;
                return;
            }
            case 4: {
                E += (long)a3;
                return;
            }
        }
    }

    public /* synthetic */ Baccarat() {
        Baccarat a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getShowdownLog() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("/0\u4ec6\u65b1\u9587\u731a\u7d0c\u9350$\u6754\u8fddf;d\u5c4c}6Y\u0006Y\u0006"));
        int n2 = m.size();
        int n3 = n2 - 270;
        if (n3 < 0) {
            n3 = 0;
        }
        int n4 = n3 = n3;
        while (true) {
            int n5;
            block13: {
                if (n4 >= n2) {
                    return stringBuilder.toString();
                }
                String string = m.get(n3).getName();
                int n6 = -1;
                switch (string.hashCode()) {
                    case 1067372: {
                        if (!string.equals(Event_PyramidSubway.ALLATORIxDEMO("\u83d0\u5b92"))) break;
                        n5 = n6 = 0;
                        break block13;
                    }
                    case 1210468: {
                        if (!string.equals(MapleCharacterCards.ALLATORIxDEMO("\u95c6\u5bba"))) break;
                        n5 = n6 = 1;
                        break block13;
                    }
                    case 694580: {
                        if (!string.equals(Event_PyramidSubway.ALLATORIxDEMO("\u54d6\u5c64"))) break;
                        n6 = 2;
                    }
                }
                n5 = n6;
            }
            switch (n5) {
                case 0: {
                    stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("/&\u8386"));
                    break;
                }
                case 1: {
                    stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("\u00078\u95b6"));
                    break;
                }
                case 2: {
                    stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("/3\u5480"));
                    break;
                }
            }
            n4 = ++n3;
        }
    }

    public static /* synthetic */ Baccarat getInstance() {
        return b;
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        F = 0L;
        C = 0L;
        e = 0L;
        E = 0L;
        g = 0L;
        B = 0L;
        K = 0L;
        a = 0L;
        k = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void Showdown() {
        if (l) {
            try {
                Baccarat baccarat;
                Baccarat a2;
                if (d == null) {
                    a2.getCards();
                }
                int n2 = 60;
                MapleMap mapleMap = ChannelServer.getInstance(0, GameSetConstants.BACCARAT_LOCATION[0]).getMapFactory().getMap(GameSetConstants.BACCARAT_LOCATION[1]);
                c = false;
                int n3 = 0;
                int n4 = 0;
                int n5 = 6;
                n2 -= 2;
                mapleMap.broadcastMessage(MaplePacketCreator.getSuperMegaphone(MapleCharacterCards.ALLATORIxDEMO("W\u762a\u5bba\u6a56Qt6t\u5050\u6b36\u4e07\u6cbc-\u513d\u79de\u5fd8\u537f\u5c53\u9587\u7218\"z\""), false, 2));
                Thread.sleep(2000L);
                new Poke(a2).shuffle();
                Card[] arrcard = (Card[])d.clone();
                n2 -= 3;
                mapleMap.broadcastMessage(MaplePacketCreator.getSkullSmega("[\u767e\u5bb6\u6a02] : \u838a\u5bb6\u958b\u724c \u2192 " + arrcard[0] + " " + arrcard[1], false, 2));
                Thread.sleep(3000L);
                n2 -= 3;
                mapleMap.broadcastMessage(MaplePacketCreator.getSkullSmega("[\u767e\u5bb6\u6a02] : \u9592\u5bb6\u958b\u724c \u2192 " + arrcard[2] + " " + arrcard[3], false, 2));
                Thread.sleep(3000L);
                n3 += arrcard[0].getValue() + arrcard[1].getValue();
                n4 += arrcard[2].getValue() + arrcard[3].getValue();
                if ((n3 %= 10) < 8 && (n4 %= 10) < 8) {
                    if (n3 <= 5) {
                        n3 += arrcard[4].getValue();
                        n2 -= 3;
                        mapleMap.broadcastMessage(MaplePacketCreator.getSuperMegaphone("[\u767e\u5bb6\u6a02] : \u838a\u5bb6\u88dc\u724c\u2192" + arrcard[4] + " ", false, 2));
                        Thread.sleep(3000L);
                    }
                    if (n4 <= 5) {
                        n4 += arrcard[5].getValue();
                        n2 -= 3;
                        mapleMap.broadcastMessage(MaplePacketCreator.getSuperMegaphone("[\u767e\u5bb6\u6a02] : \u9592\u5bb6\u88dc\u724c\u2192" + arrcard[5] + " ", false, 2));
                        Thread.sleep(3000L);
                    }
                    n3 %= 10;
                    n4 %= 10;
                }
                mapleMap.startMapEffect("\u958b\u724c\u7d50\u679c:\u838a\u5bb6\u9ede\u6578\u2192" + n3 + "\u9ede \u9592\u5bb6\u9ede\u6578\u2192" + n4 + "\u9ede", 5120009);
                n2 -= 3;
                mapleMap.broadcastMessage(MaplePacketCreator.getHeartSmega("[\u767e\u5bb6\u6a02] : \u958b\u724c\u7d50\u679c:\u838a\u5bb6\u9ede\u6578\u2192" + n3 + "\u9ede \u9592\u5bb6\u9ede\u6578\u2192" + n4 + "\u9ede", false, 2));
                Thread.sleep(3000L);
                if (n3 == n4) {
                    Baccarat baccarat2 = a2;
                    baccarat = baccarat2;
                    baccarat2.ALLATORIxDEMO(GameSet.\u548c\u5c40);
                    m.add(GameSet.\u548c\u5c40);
                } else if (n3 > n4) {
                    Baccarat baccarat3 = a2;
                    baccarat = baccarat3;
                    baccarat3.ALLATORIxDEMO(GameSet.\u838a\u5bb6);
                    m.add(GameSet.\u838a\u5bb6);
                } else {
                    Baccarat baccarat4 = a2;
                    baccarat = baccarat4;
                    baccarat4.ALLATORIxDEMO(GameSet.\u9592\u5bb6);
                    m.add(GameSet.\u9592\u5bb6);
                }
                baccarat.ALLATORIxDEMO();
                G.clear();
                c = true;
                l = false;
                d = null;
                MapleMap mapleMap2 = mapleMap;
                mapleMap2.broadcastMessage(MaplePacketCreator.getClock(n2));
                mapleMap2.broadcastMessage(MaplePacketCreator.getSuperMegaphone(Event_PyramidSubway.ALLATORIxDEMO("\u0001\u765a\u5bec\u6a26\u0007\u0004`\u0004\u4e51\u76c0\u5da8\u95af\u5991\u0005\u73f3\u5b92\u8a91\u4e2f\u6cb2\nt\nt\nt\nr\u8b42`\u5c2b\u8cb7\u6005\u609f\b\u597d\u8cc9\u50ed\u8e8f{\r"), false, 2));
                return;
            }
            catch (InterruptedException interruptedException) {
                Logger.getLogger(Baccarat.class.getName()).log(Level.SEVERE, null, interruptedException);
            }
        }
    }

    public /* synthetic */ String bet(MapleCharacter a2, String a3, int a4, String a5) {
        Baccarat a6;
        Object object = "";
        if (a2.getClient().getChannel() != GameSetConstants.BACCARAT_LOCATION[0] || a2.getMapId() != GameSetConstants.BACCARAT_LOCATION[1]) {
            return "\u60a8\u7684\u6240\u5728\u5340\u57df\u7121\u6cd5\u4e0b\u6ce8! \u8acb\u79fb\u52d5\u81f3" + GameSetConstants.BACCARAT_LOCATION[0] + "S " + MapleItemInformationProvider.getInstance().getMapName(GameSetConstants.BACCARAT_LOCATION[1]);
        }
        if (World.isShutDown) {
            return MapleCharacterCards.ALLATORIxDEMO("\u76e2\u5219\u537f\u5c53\u95d0\u6759#\u6b37\u5724\u7df9\u8b7bx\u8ce1\u530e\u7cf7\u7d25\u66a7\u5008\u4f73\u757c-");
        }
        if ((int)((double)a6.ALLATORIxDEMO(a2, a5) * ALLATORIxDEMO) < a4) {
            return "\u60a8\u7684\u7c4c\u78bc\u4e0d\u8db3!\u70ba\u9632\u73a9\u5bb6\u7834\u7522,\u6bcf\u6b21\u4e0b\u6ce8\u984d\u5ea6\u6700\u9ad8\u50c5\u80fd\u4e0b\u6ce8\u8eab\u4e0a\u64c1\u6709\u4e0b\u6ce8\u7c4c\u78bc\u7684" + ALLATORIxDEMO * 100.0 + "%!";
        }
        if (c) {
            if (!G.containsKey(a2.getId())) {
                if (a6.ALLATORIxDEMO(a2, a5) >= a4) {
                    if (GameSet.getByName(a3) != null) {
                        String string;
                        Baccarat baccarat = a6;
                        baccarat.H(a5, a4);
                        baccarat.ALLATORIxDEMO(a2, a5, -a4);
                        G.put(a2.getId(), new Triple<GameSet, String, Integer>(GameSet.getByName(a3), a5, a4));
                        l = true;
                        if (a3.equals(Event_PyramidSubway.ALLATORIxDEMO("\u83d0\u5b92"))) {
                            string = a3;
                            a6.l(a5, a4);
                        } else {
                            if (a3.equals(MapleCharacterCards.ALLATORIxDEMO("\u95c6\u5bba"))) {
                                a6.D(a5, a4);
                            }
                            string = a3;
                        }
                        object = "\u6295\u6ce8 " + string + " " + a4 + " " + a5 + "\u6210\u529f!";
                        return object;
                    }
                    object = Event_PyramidSubway.ALLATORIxDEMO("\u62b1\u6cb2\u7658\u7545\u7554\u5e62\u0005");
                    return object;
                }
                object = "\u60a8\u7684" + a5 + "\u4e0d\u8db3!";
                return object;
            }
            object = MapleCharacterCards.ALLATORIxDEMO("\u60a4\u6b30\u5c4c\u5da6\u4e07\u6cbc\u9042u,\u8a9f\u7b45\u5fd1\u9587\u731a\"z\"");
            return object;
        }
        object = Event_PyramidSubway.ALLATORIxDEMO("\u76b4\u5269\u6b39\u570c\u95d1\u736a\u4e77\nt\n\u8a91\u7a29\u5fd6\u51a9\u4e51\u6ccc");
        return object;
    }

    public /* synthetic */ String getRules() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("/&\u7672\u5be2\u6a0ey\u73a5\u6c81\u8983\u52136t$\u5253\u8a14u\u9046\u6266\u4e07\u6cbc\u5f80\u81a7\u9587\u731a\u664e\u82b1\u65bb\u7d8e\u4e07\u6cbc\u6705\u53bb\u80f1\u6757\u88a7\u5457,\u4e59\u88d0\u514b%Y\u0006"));
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("yF\u3050\u4e24\u8276\u89ab\u521d\u302fW.y@"));
        stringBuilder3.append(MapleCharacterCards.ALLATORIxDEMO("e\"\u62e8\u6ce4\u83de\u5bba\u8058\u8386\u8d5b\u8009\uff58\u8d03e\u8cece\uff00\u53b2\u626fa)\u4f37\u7d6a\u83de\u5bbaY\u0006"));
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("\u0016t\u6298\u6cb2\u95b6\u5bec\u8028\u95c8\u8d2b\u805f\uff28\u8d55\u0015\u8cba\u0015W."));
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("?z\u62b0\u6cbc\u5480\u5c14\uff04\u5327\u670c\u7d16\u9ed2\u652c\u4e0c\u6a77\u8009\uff5d\uff00\u8d5b=\u8cb44Y\u0006"));
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("\u0010t\u82c1\u95d1\u54a8\u5c1a\u6666\uff56\u6298\u83d0\u3025\u95c8\u76a0\u62e6\u6ccc\u6759\u9024\u5684\u7d42\u73f3\u5b92W."));
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("9z\u4f73\u757c\u7240\u652c\uff16\u4e54\u5263\u72189f\u5f39\uff58\u4e01\u5351\u5427\u9b68\u7240Y\u0006"));
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("yF\u3050\u7658\u7216\u8a8e\u6654\u302fW.y@"));
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("e\"\u7522\u4ef7\u4f01\u4e0c\u5be2\u62f3\u5264\u4f87\u7218\u3000l\u3001t\u621a\u30585\u3059\uff04\u001am y&m8\uff05\uff58\u6b68\u7a7a\u7240\u539c\u7a3d\u3058\u5925\u754b\u8d03\u5be2\u3001\u6242\u3000\u597d\u7387\u3059\u537f\u4e59\u5181\u8888\u7240Y\u0006"));
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("\u0016t\u514d\u5bec\u59a6\u90a7\u62db\u526a\u3028l\u3029\u4ebf\u4e2e\u5329\u4e29\u51d7\u88f8\u7216\n\u5397\u4e6f\u521d\u88f8\u7216\f\u83d0\b\u95c8\u9efa\u6522\u76a2\u5c55\u6598b\u76a0\u5217\u63f4\u4e51\rW."));
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("?z\u8386\u5c59\u621a\u95c6\u5c01\u5091\u965c\u5219\u5165\u5f61\u7240\uff58\u4e01\u8a5c\u7b20\u4e5d\u5f39\u8888\u7240Y\u0006"));
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("yF\u3050\u9efa\u6522\u8a2c\u7bcd\u302fW.y@"));
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("e\"\u762a\u5bba\u6a56\u53e6\u8a5c\u7b9b\u63c6\u976e\u9e8a\u6574\u4e59\u6bd8\u82e5\u827eY\u0006"));
        stringBuilder.append(Event_PyramidSubway.ALLATORIxDEMO("h\n\u001b\u709ek\u9efa\uff56\u0015j\u3025\u0010\u3025\u000b\u54a8\u0011\u709ej\u9efaW."));
        stringBuilder.append(MapleCharacterCards.ALLATORIxDEMO("g\"\u5122\u4eda\u7218\u4f91\u7218\u976e\u652c\u5b5b\u8a5c\u9ed2\uff58\u4f91\u89db\u524b\u8888\u7240\u5fd8\u53da\u6214\u6705\u7218\u6574\u7e69\u5480\u76d0\u5007\u4f19\u6574Y\u0006"));
        return stringBuilder3.toString();
    }

    private static final class GameSet
    extends Enum<GameSet> {
        public static final /* synthetic */ /* enum */ GameSet \u548c\u5c40;
        public static final /* synthetic */ /* enum */ GameSet \u838a\u5bb6;
        public /* synthetic */ double d;
        public static final /* synthetic */ /* enum */ GameSet \u9592\u5bb6;
        public final /* synthetic */ String a;
        private static final /* synthetic */ GameSet[] ALLATORIxDEMO;

        public /* synthetic */ String getName() {
            GameSet a2;
            return a2.a;
        }

        public static final /* synthetic */ GameSet getByName(String a2) {
            int n2;
            GameSet[] arrgameSet = GameSet.values();
            int n3 = arrgameSet.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                GameSet gameSet = arrgameSet[n2];
                if (gameSet.a.equals(a2)) {
                    return gameSet;
                }
                n4 = ++n2;
            }
            return null;
        }

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ GameSet(String string2, double string2) {
            void a2;
            void a3;
            void var2_-1;
            void var1_-1;
            GameSet a4;
            GameSet gameSet = a4;
            gameSet.a = a3;
            gameSet.d = a2;
        }

        public static /* synthetic */ {
            \u838a\u5bb6 = new GameSet(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u83f7\u5bb7"), 0, MapleFriendship.ALLATORIxDEMO("\u83a1\u5bae"), 0.95);
            \u9592\u5bb6 = new GameSet(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u95ef\u5bb7"), 1, MapleFriendship.ALLATORIxDEMO("\u95b9\u5bae"), 1.0);
            \u548c\u5c40 = new GameSet(\u6bcd\u6e6f\u8c37.ALLATORIxDEMO((String)"\u54f1\u5c41"), 2, MapleFriendship.ALLATORIxDEMO("\u54a7\u5c58"), 8.0);
            GameSet[] arrgameSet = new GameSet[3];
            arrgameSet[0] = \u838a\u5bb6;
            arrgameSet[1] = \u9592\u5bb6;
            arrgameSet[2] = \u548c\u5c40;
            ALLATORIxDEMO = arrgameSet;
        }

        public static /* synthetic */ GameSet[] values() {
            return (GameSet[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ GameSet valueOf(String a2) {
            return Enum.valueOf(GameSet.class, a2);
        }

        public /* synthetic */ double getOdds() {
            GameSet a2;
            return a2.d;
        }
    }

    public class Poke {
        public /* synthetic */ Card[] K;
        public final /* synthetic */ Baccarat ALLATORIxDEMO;
        public /* synthetic */ int[] a;
        public /* synthetic */ String[] d;

        public /* synthetic */ Poke(Baccarat a2) {
            int n2;
            Poke a3;
            Poke poke = a3;
            a3.ALLATORIxDEMO = a2;
            a3.K = null;
            int[] arrn = new int[13];
            arrn[0] = 1;
            arrn[1] = 2;
            arrn[2] = 3;
            arrn[3] = 4;
            arrn[4] = 5;
            arrn[5] = 6;
            arrn[6] = 7;
            arrn[7] = 8;
            arrn[8] = 9;
            arrn[9] = 10;
            arrn[10] = 11;
            arrn[11] = 12;
            arrn[12] = 13;
            poke.a = arrn;
            String[] arrstring = new String[4];
            arrstring[0] = MapleParty.ALLATORIxDEMO("\u7d75\u5fda");
            arrstring[1] = \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u9ee4\u6842");
            arrstring[2] = MapleParty.ALLATORIxDEMO("\u65c9\u5853");
            arrstring[3] = \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"\u68b0\u82b0");
            poke.d = arrstring;
            a3.K = new Card[52];
            int n3 = n2 = 0;
            while (n3 < a3.d.length) {
                int n4;
                int n5 = n4 = 0;
                while (n5 < a3.a.length) {
                    int n6 = n2 * a3.a.length + n4;
                    Card card = new Card(a2, a3.a[n4], a3.d[n2]);
                    a3.K[n6] = card;
                    n5 = ++n4;
                }
                n3 = ++n2;
            }
        }

        public /* synthetic */ void outPut() {
            Poke a2;
            int n2;
            int n3 = n2 = 0;
            while (n3 < a2.K.length) {
                if (n2 % 13 == 0) {
                    System.out.println();
                }
                System.out.print(a2.K[n2++]);
                n3 = n2;
            }
        }

        public /* synthetic */ void shuffle() {
            int n2;
            Card card = null;
            int n3 = n2 = 0;
            while (n3 < 52) {
                Poke a2;
                Poke poke = a2;
                card = poke.K[n2];
                int n4 = (int)(Math.random() * 51.0);
                Poke poke2 = a2;
                poke.K[n2] = poke2.K[n4];
                poke2.K[n4] = card;
                n3 = ++n2;
            }
        }

        public /* synthetic */ void sortOut(Card[] a2) {
            Arrays.sort(a2);
        }

        public /* synthetic */ Card[] draw(int a2) {
            int n2;
            Card[] arrcard = new Card[a2];
            int n3 = n2 = 0;
            while (n3 < a2) {
                Poke a3;
                int n4 = n2++;
                arrcard[n4] = a3.K[n4];
                n3 = n2;
            }
            return arrcard;
        }
    }

    public class Card
    implements Comparable {
        private /* synthetic */ String d;
        public final /* synthetic */ Baccarat ALLATORIxDEMO;
        private /* synthetic */ int a;

        public /* synthetic */ int compareTo(Object a2) {
            Card a3;
            if (a3.a > ((Card)a2).a) {
                return 1;
            }
            if (a3.a == ((Card)a2).a) {
                return 0;
            }
            return -1;
        }

        public /* synthetic */ Card(Baccarat a2, int a3, String a4) {
            Card a5;
            Card card = a5;
            a5.ALLATORIxDEMO = a2;
            card.a = a3;
            card.d = a4;
        }

        /*
         * Enabled aggressive block sorting
         */
        public /* synthetic */ String toString() {
            Card card;
            String string;
            Card a2;
            switch (a2.a) {
                case 1: {
                    string = MapleLieDetector.ALLATORIxDEMO("|");
                    card = a2;
                    return card.d + string;
                }
                case 11: {
                    string = BankSystem.ALLATORIxDEMO("=");
                    card = a2;
                    return card.d + string;
                }
                case 12: {
                    string = MapleLieDetector.ALLATORIxDEMO("l");
                    card = a2;
                    return card.d + string;
                }
                case 13: {
                    string = BankSystem.ALLATORIxDEMO("<");
                    card = a2;
                    return card.d + string;
                }
            }
            Card card2 = a2;
            card = card2;
            string = String.valueOf(card2.a);
            return card.d + string;
        }

        public /* synthetic */ int getValue() {
            Card a2;
            if (a2.a >= 10) {
                a2.a = 10;
            }
            return a2.a;
        }
    }
}

