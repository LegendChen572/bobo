/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5408\u592a\u8c37
 */
package server.game;

import client.MapleBuffStatValueHolder;
import client.MapleCharacter;
import client.PlayerRandomStream;
import client.inventory.MapleAndroid;
import client.messages.ConsoleCommandObject;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.\u5408\u592a\u8c37;
import constants.GameSetConstants;
import constants.SpecialSkillConstants;
import handling.channel.ChannelServer;
import handling.world.World;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.MapleItemInformationProvider;
import server.Timer;
import server.maps.MapleMap;
import tools.MaplePacketCreator;

public class BlackJack {
    private static /* synthetic */ long K;
    private static /* synthetic */ boolean E;
    private static final /* synthetic */ BlackJack e;
    private static /* synthetic */ BlackJackResultInfo k;
    private static /* synthetic */ long d;
    private static /* synthetic */ long a;
    private static /* synthetic */ boolean ALLATORIxDEMO;
    private static /* synthetic */ boolean g;
    private static /* synthetic */ List<GameSet> B;
    private static /* synthetic */ Map<Integer, Integer> H;

    public /* synthetic */ long getTotalBet() {
        return K;
    }

    public /* synthetic */ long getNowBet() {
        return d;
    }

    public /* synthetic */ BlackJack() {
        BlackJack a2;
    }

    public static /* synthetic */ BlackJack getInstance() {
        return e;
    }

    public /* synthetic */ String ChangeBankerCard() {
        if (ALLATORIxDEMO) {
            BlackJack a2;
            a2.getBlackJackCard(null, true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(BankSystem.ALLATORIxDEMO("\u6b17\u5c37\u83f9\u5bc1\u526e\u59bc\u723f\u57fcIW"));
            Iterator<Card> iterator = k.getCard().iterator();
            Iterator<Card> iterator2 = iterator;
            while (iterator2.hasNext()) {
                Card card = iterator.next();
                stringBuilder.append(card.toString() + " ");
                iterator2 = iterator;
            }
            stringBuilder.append(" \u9ede\u6578:" + k.getPoint());
            return stringBuilder.toString();
        }
        return \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6b5d\u5c4e\u83b3\u5bb8\u5224\u59c5\u7275\u5785\u5dcb\u9585\u7275\"\u7118\u6cdb\u51b4\u66fa\u63e2\"\u8af2\u5f8b\u4e32\u5c4e\u303b");
    }

    public /* synthetic */ void SendReward() {
        Iterator<Map.Entry<Integer, Integer>> iterator;
        GameSet gameSet = k.getGameSet();
        int n2 = k.getPoint();
        Iterator<Map.Entry<Integer, Integer>> iterator2 = iterator = H.entrySet().iterator();
        while (iterator2.hasNext()) {
            MapleCharacter mapleCharacter;
            boolean bl;
            int n3;
            int n4;
            GameSet gameSet2;
            MapleCharacter mapleCharacter2;
            boolean bl2;
            boolean bl3;
            block7: {
                block4: {
                    block5: {
                        block8: {
                            block6: {
                                Map.Entry<Integer, Integer> entry = iterator.next();
                                bl3 = false;
                                bl2 = false;
                                mapleCharacter2 = MapleCharacter.getOnlineCharacterById(entry.getKey());
                                BlackJackResultInfo blackJackResultInfo = mapleCharacter2.getBlackJackCard();
                                gameSet2 = blackJackResultInfo.getGameSet();
                                n4 = entry.getValue();
                                n3 = blackJackResultInfo.getPoint();
                                if (n4 <= 0) break block4;
                                if (gameSet2 == GameSet.\u7206\u724c) break block5;
                                if (!(gameSet2.geLevel() > gameSet.geLevel())) break block6;
                                bl = bl3 = true;
                                break block7;
                            }
                            if (gameSet2.geLevel() != gameSet.geLevel()) break block4;
                            if (n3 <= n2) break block8;
                            bl = bl3 = true;
                            break block7;
                        }
                        if (n3 != n2) break block4;
                        bl2 = true;
                        MapleCharacter mapleCharacter3 = mapleCharacter2;
                        mapleCharacter3.gainMeso(n4, true);
                        mapleCharacter3.dropMessageAll("\u548c\u5c40! \u6b64\u5c40\u838a\u5bb6\u70ba " + gameSet.getName() + " \u9ede\u6578: " + n2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + gameSet2.getName() + " \u9ede\u6578: " + n3 + ",\u9000\u56de\u6953\u5e63" + n4 + "\u5143!");
                        bl = bl3;
                        break block7;
                    }
                    bl3 = false;
                }
                bl = bl3;
            }
            if (bl) {
                double d2 = gameSet2.getOdds();
                int n5 = (int)((double)n4 * d2);
                MapleCharacter mapleCharacter4 = mapleCharacter2;
                mapleCharacter2.gainMeso(n4, true);
                mapleCharacter4.gainMeso(n5, true);
                a += (long)n5;
                mapleCharacter4.dropMessageAll("\u4f60\u8d0f\u4e86! \u6b64\u5c40\u838a\u5bb6\u70ba " + gameSet.getName() + " \u9ede\u6578: " + n2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + gameSet2.getName() + " \u9ede\u6578: " + n3 + ",\u8d0f\u5f97\u6953\u5e63" + n5 + "\u5143!");
                mapleCharacter = mapleCharacter2;
            } else {
                if (!bl3 && !bl2) {
                    a -= (long)n4;
                    mapleCharacter2.dropMessageAll("\u4f60\u8f38\u4e86! \u6b64\u5c40\u838a\u5bb6\u70ba " + gameSet.getName() + " \u9ede\u6578: " + n2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + gameSet2.getName() + " \u9ede\u6578: " + n3 + ",\u5931\u53bb\u6953\u5e63" + n4 + "\u5143!");
                }
                mapleCharacter = mapleCharacter2;
            }
            mapleCharacter.setBlackJackCard(null);
            iterator2 = iterator;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void Showdown() {
        if (!g) return;
        try {
            BlackJack a2;
            E = false;
            int n2 = 60;
            MapleMap mapleMap = ChannelServer.getInstance(0, GameSetConstants.BLACKJACK_LOCATION[0]).getMapFactory().getMap(GameSetConstants.BLACKJACK_LOCATION[1]);
            StringBuilder stringBuilder = new StringBuilder();
            if (ALLATORIxDEMO) {
                n2 -= 2;
                mapleMap.broadcastMessage(MaplePacketCreator.getSuperMegaphone(BankSystem.ALLATORIxDEMO(",AF\u9ead*SMS\u73de\u5bc5\u502b\u6b11\u4e7c\u6c9bV\u511a\u79a5\u5fff\u5304\u5c74\u95fc\u83f9\u5bc1\u8d04\u59bc\u723fY]Y"), false, 2));
                Thread.sleep(2000L);
                if (k == null) {
                    a2.getBlackJackCard(null, true);
                }
                boolean bl = false;
                for (Card card : k.getCard()) {
                    if (!bl) {
                        stringBuilder.append(card.toString() + " ");
                        bl = true;
                        continue;
                    }
                    stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u84c5\u7275"));
                }
                mapleMap.broadcastMessage(MaplePacketCreator.getSkullSmega("[21\u9ede] : \u838a\u5bb6\u5df2\u958b\u724c,\u838a\u5bb6\u8d77\u59cb\u724c \u2192 " + stringBuilder.toString() + " \u73a9\u5bb6\u53ef\u9078\u64c7\u662f\u5426\u7e7c\u7e8c\u88dc\u724c", false, 2));
                n2 -= 3;
                mapleMap.startMapEffect("\u838a\u5bb6\u5df2\u958b\u724c,\u838a\u5bb6\u8d77\u59cb\u724c \u2192 " + stringBuilder.toString() + " \u73a9\u5bb6\u53ef\u9078\u64c7\u662f\u5426\u7e7c\u7e8c\u88dc\u724c..", 5120009);
                Thread.sleep(3000L);
                ALLATORIxDEMO = false;
            } else {
                Card card;
                Iterator<Card> iterator;
                n2 -= 2;
                mapleMap.broadcastMessage(MaplePacketCreator.getSuperMegaphone(BankSystem.ALLATORIxDEMO(",AF\u9ead*SMS\u73de\u5bc5\u502b\u6b11\u88ab\u723fV\u511a\u79a5\u5fff\u83fd\u5bc5\u5304\u5c74\u95fc\u59b8\u88ab\u723fY]Y"), false, 2));
                Thread.sleep(2000L);
                while (k.getPoint() < 17) {
                    stringBuilder = new StringBuilder();
                    a2.getBlackJackCard(null, true);
                    iterator = k.getCard().iterator();
                    Iterator<Card> iterator2 = iterator;
                    while (iterator2.hasNext()) {
                        card = iterator.next();
                        stringBuilder.append(card.toString() + " ");
                        iterator2 = iterator;
                    }
                    n2 -= 3;
                    mapleMap.broadcastMessage(MaplePacketCreator.getSkullSmega("[21\u9ede] : \u838a\u5bb6\u88dc\u724c \u2192 \u9ede\u6578(" + k.getPoint() + "\u9ede)" + stringBuilder.toString(), false, 2));
                    Thread.sleep(3000L);
                }
                stringBuilder = new StringBuilder();
                Iterator<Card> iterator3 = iterator = k.getCard().iterator();
                while (iterator3.hasNext()) {
                    card = iterator.next();
                    stringBuilder.append(card.toString() + " ");
                    iterator3 = iterator;
                }
                mapleMap.startMapEffect("\u838a\u958b\u724c\u7d50\u679c \u2192 " + stringBuilder.toString() + " \u9ede\u6578:" + k.getPoint() + " \u724c\u578b:" + k.getGameSet().getName(), 5120009);
                n2 -= 3;
                mapleMap.broadcastMessage(MaplePacketCreator.getHeartSmega("[21\u9ede] : \u838a\u958b\u724c\u7d50\u679c \u2192 \u9ede\u6578:" + k.getPoint() + " \u724c\u578b:" + k.getGameSet().getName(), false, 2));
                Thread.sleep(3000L);
                a2.SendReward();
                H.clear();
                g = false;
                k = null;
                ALLATORIxDEMO = true;
                d = 0L;
            }
            E = true;
            mapleMap.broadcastMessage(MaplePacketCreator.getClock(n2));
            if (!ALLATORIxDEMO) return;
            mapleMap.broadcastMessage(MaplePacketCreator.getSuperMegaphone(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"U\u000b?\u9ee7S\u00194\u0019\u4e05\u76dd\u5dfc\u95b2\u59c5\u0018\u73a7\u5b8f\u8ac5\u4e32\u6ce6\u0017 \u0017 \u0017 \u0017&\u8b5f4\u5c36\u8ce3\u6018\u60cb\u0015\u5929\u8cd4\u50b9\u8e92/\u0010"), false, 2));
            return;
        }
        catch (InterruptedException interruptedException) {
            Logger.getLogger(BlackJack.class.getName()).log(Level.SEVERE, null, interruptedException);
        }
    }

    public /* synthetic */ String getRules() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append(BankSystem.ALLATORIxDEMO("P\u0005AF\u9eadZ\u9039\u6245\u73da\u6ca2\u53b9\u723b\u57f8\u4ebc\u7d4aM[\u5270\u8a6bV\u9039\u6245\u4e78\u6c9f\u5fff\u8184\u95f8\u7339\u6631\u8292\u65c4\u7dad\u7505\u5c37\u4e78\u6c9f\u4e73\u5bed\u6770\u88dc\u5470W\u4e7e\u88ab\u516c^~}"));
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"-[\u3004\u4e39\u8222\u89b6\u5249\u3032\u00033-]"));
        stringBuilder3.append(BankSystem.ALLATORIxDEMO("F]\u4f08\u755b\u723b\u650b\uff6d\u4e73\u5218\u723fBA\u5f42\uff7f\u4e7a\u5376\u545c\u9b4f\u723b~}"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u000b \u7275\u9ed0\u8a31\u7b99\uff23<\u81ca7\u7083<\u81ca7\u9ee7\uff02\b>\u3038D\u3038_\u3038E\u76bf\u70b4\b>\u9ee7.x\u53e1\u4edc\u7578\b\u9ed0\u622f\u6621\b?\u9ee7\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("C]\u903d\u6241\u7699\u6a6a\uff6d\u9039\u6245\u769d\u76f3\u5c42\u6658\u89f2\u53a1\u5fe4\u6777\u63d6\u8fa6\u4eff\u5336\u4e73\u9ea9\u76f7\u9ea9\u650b\uff7b\u807f\u53bf\u4e7e\u808a\u8df6\u9039\u4eff\u5336\u4e73\u9ea9~}"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"-[\u3004\u7275\u5785\u7d7d\u5406\u8a93\u6600\u3032\u00033-]"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("P\u0005[\u4e77Z@D@~}P\u0013"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6b6a\u7083\u7277\u6bb3\u7242\u57b2\"\u754f\u73a7\u5b8f\u6245\u4e14\u768a\u57c3\u6722\u7275\u5167\u5f0c\u5482\u639c\u4e05\u4fbf\u88d2\u7275\u4e23\u6730\u4e07\u5f0c9\u0015\u8cee\u73be=\u5034\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0001_\u4eff^\u4ee7\u9ffa~}P\u0013"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6b5d\u70b4\u7240\u6b84\u7275\u5785\u0015\u7578\u62c6\u523e\u4ead\u5f3b\u4edc\u4e04\u76bd\u7242\u8035\u4ec3\u6713\u7208\u7275&\u8dbc\u9040\u000b?\u9ee7'\u0015\u537d\u7083\u4e9a\u9fb4/\u8cd9\u7389\u7083<\u5034\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0001_\u4e7a^\u9ea2\u50e6\u5138_1\u001b\u0012\u0014\u0018=\u0012\u0014\u0018^~}P\u0013"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6b6a\u7083\u7277\u6bb3\u7242\u57b2\"\u59bb\u6792\u7390\u5bb8\u5fae\u523e\u76bd\u9998\u5150\u5f3b\u7275\u5208\u521c\u70b4\u4e39\u5f3bxm\\\uff06\uff18\uff07\u7275\u5482\u4e39\u5f3b\u50c0\u5032\u5378\u9ed0\u76bd\u7242\uff35\u90ad\u4eef\uff01\u5940\u4fb1\u7bae\u53d8\u5faeLUoZesoZe\uff31\u9edf\u50a8\u5145\uff30\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0001_\u56a8^\u6ba7\u9ea9~}P\u0013"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u9750\u4edc\u4e04\u76bd\u7242\u7d7d\u9850\u57b2\"\u6272\u7242\u9ee7\u6576\u53f1\u6c9c\u6730\u8d8b\u9077<\b\u9ed0\u0011\u6724\u723f\u7242\u0010\"\u527e\u970e\u89b8\u5482\u83b3\u5bb8\u6bed\u9ed0\u0011\u6bda\u52e4\u8cae\u0010\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0001_\u4ee7^\u7275\u723b~}P\u0013"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6272\u4e04\u6279\u737c\u5fae\u768a\u7275\u7e33\u54b5\u8d8b\u9077<\b\u9ed0\u534a\u70b4\u723f\u7242\u0015\u73a7\u5b8f\u82eb\u723f\u7242\u527e\u6b6a\u5c79\u76fa\u639c\u8433\u656e\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("P\u0015\u3079\u6ba3\u8c8e\u89f8\u5234\u307c~}P\u0013"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001a|\u0011\u4e0e\u0010\u7242\u57b2\u5929\u5c36\u6bda\u8f3a\u00033-]"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("@D@SIS\u4ee3\u9ffeWMW\u9ea2\u50e6\u5138WMWAF\u9eadWMW\u2055\u2051SISC\u9eadWMW\u7275\u723b~}"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001a|\u0011\u4e82\u0010\u9585\u7275\u65b7\u5f36\u00033-]"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("\u6bb8\u4e73\u5c37\u76f7\u95fc\u723f\u6635\u95e0\u70cd\u511a\u5271\u946b[\u523e\u4e77\u5275\u946f\u70c9\u4e7c\u6c9b\u6635\u95e0[\u4e73\u5271\u946b\u5ffb\u83f9\u5bc1\u95f8\u723b~}"));
        stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u83b3\u5bb8\u95b2\u7242\u5fb5\"\u5fb5\u4e0e\u523f\u9416\u7390\u5bb8\u53d6\u81e4\u8875\u9076\u64fe\u6621\u541f\u88d2\u7275\u00033"));
        stringBuilder.append(BankSystem.ALLATORIxDEMO("\u5ffb\u4e73\u5271\u946b\u7d27\u672c\u5ffb_\u9045\u883f\u83fd\u5bc5\u88ab\u723f[\u8296\u83fd\u5bc5\u9ea9\u650b\u5c78\u65cfFD\u9ea9_\u83fd\u5bc5\u5304\u6770\u7e0b\u7eff\u88ab\u723fV~}"));
        return stringBuilder3.toString();
    }

    public /* synthetic */ String bet(MapleCharacter a2, int a3) {
        String string = "";
        if (a2.getClient().getChannel() != GameSetConstants.BLACKJACK_LOCATION[0] || a2.getMapId() != GameSetConstants.BLACKJACK_LOCATION[1]) {
            return "\u60a8\u7684\u6240\u5728\u5340\u57df\u7121\u6cd5\u4e0b\u6ce8! \u8acb\u79fb\u52d5\u81f3" + GameSetConstants.BLACKJACK_LOCATION[0] + "S " + MapleItemInformationProvider.getInstance().getMapName(GameSetConstants.BLACKJACK_LOCATION[1]);
        }
        if (World.isShutDown) {
            return BankSystem.ALLATORIxDEMO("\u7699\u523e\u5304\u5c74\u95ab\u677eX\u6b10\u575f\u7dde\u8b00_\u8c9a\u5329\u7c8c\u7d02\u66dc\u502f\u4f08\u755bV");
        }
        if (a2.getMeso() < a3 * 10) {
            return \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6091\u768a\u696a\u5e6d\u4e34\u8dbd\u0018\u70b4\u960b\u73a7\u5b8f\u783a\u751b\"\u6bf6\u6b2f\u4e32\u6ce6\u9874\u5ea8\u6739\u9ad6\u50fc\u80f3\u4e32\u6ce6\u8e92\u4e04\u64f8\u6707\u8c98\u5bc2\u76bd?\t+\u0018");
        }
        if (E) {
            BlackJack a4;
            if (!H.containsKey(a2.getId()) && ALLATORIxDEMO) {
                if (a3 == 0) {
                    string = BankSystem.ALLATORIxDEMO("\u8ab8\u513f\u4e78\u6c9f\u51fe\u9045\u883f\u88ab\u723fV");
                    return string;
                }
                if (a2.getMeso() >= a3) {
                    a2.gainMeso(-a3, true);
                    K += (long)a3;
                    d += (long)a3;
                    H.put(a2.getId(), a3);
                    g = true;
                    string = a4.getBlackJackCard(a2, false);
                    return string;
                }
                string = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6091\u768a\u696a\u5e6d\u4e34\u8dbd\u0018");
                return string;
            }
            if (ALLATORIxDEMO) {
                string = BankSystem.ALLATORIxDEMO("\u511b\u9aa3\u760f\u723b\u4e5eY]Y\u8ab8\u7b3e\u5ff6\u83fd\u5bc5\u95fc\u723f[\u51fe\u6c0d\u5be9\u6658\u5455\u7e0b\u7eff\u88ab\u723fV");
                return string;
            }
            string = a4.getBlackJackCard(a2, false);
            return string;
        }
        string = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u76e0\u5274\u6b6d\u5711\u9585\u7275\u4e23\u0017 \u0017\u8ac5\u7a34\u5f82\u51b4\u4e05\u6cd1");
        return string;
    }

    public /* synthetic */ long getTotalWin() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getShowdownLog() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0017\u4ebd\u6596\u95fc\u733d\u7d77\u9377M~}~}"));
        Iterator<GameSet> iterator = B.iterator();
        block10: while (true) {
            int n2;
            block12: {
                if (!iterator.hasNext()) {
                    return stringBuilder.toString();
                }
                String string = iterator.next().getName();
                int n3 = -1;
                switch (string.hashCode()) {
                    case 1067372: {
                        if (!string.equals(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u8384\u5b8f"))) break;
                        n2 = n3 = 0;
                        break block12;
                    }
                    case 1210468: {
                        if (!string.equals(BankSystem.ALLATORIxDEMO("\u95e1\u5bc1"))) break;
                        n2 = n3 = 1;
                        break block12;
                    }
                    case 694580: {
                        if (!string.equals(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u5482\u5c79"))) break;
                        n3 = 2;
                    }
                }
                n2 = n3;
            }
            switch (n2) {
                case 0: {
                    stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0001\u83fd"));
                    continue block10;
                }
                case 1: {
                    stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001al\u95ab"));
                    continue block10;
                }
                case 2: {
                    stringBuilder.append(BankSystem.ALLATORIxDEMO("T\u0014\u54fb"));
                    continue block10;
                }
            }
        }
    }

    public /* synthetic */ String getNowCard(MapleCharacter a2) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (a2.getBlackJackCard() != null) {
            Object object = a2.getBlackJackCard().getCard();
            stringBuilder2.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001aj\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u0004\u00033"));
            stringBuilder2.append(BankSystem.ALLATORIxDEMO("P\u0015\u7505\u523a\u64b2\u677e\u76f7\u723b\u7d37MP\u0005"));
            object = object.iterator();
            Object object2 = object;
            while (object2.hasNext()) {
                Card card = (Card)object.next();
                stringBuilder2.append(" " + card.toString());
                object2 = object;
            }
            stringBuilder2.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u00033"));
            stringBuilder2.append("#b\u76ee\u524d\u624b\u724c:#r " + a2.getBlackJackCard().getPoint() + " #b\u9ede!\r\n");
            stringBuilder2.append("#b\u6b64\u724c\u7d44\u578b\u614b:#r" + a2.getBlackJackCard().getGameSet().getName() + "\r\n");
            stringBuilder2.append(BankSystem.ALLATORIxDEMO("T\u0017JNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJ~}"));
            stringBuilder = stringBuilder2;
        } else {
            StringBuilder stringBuilder3 = stringBuilder2;
            stringBuilder = stringBuilder3;
            stringBuilder3.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001aj\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u0004\u00033"));
            stringBuilder2.append(BankSystem.ALLATORIxDEMO("P\u0015\u60db\u6b13\u5c33\u5c6d\u6759\u4e7c\u6c9bV~}"));
            stringBuilder2.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001aj\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u0004\u00033"));
        }
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ String getBlackJackCard(MapleCharacter a, boolean a) {
        var3_3 = null;
        var4_4 = new StringBuilder();
        var5_5 = 2;
        var6_6 = 0;
        var6_6 = 0;
        var7_9 = null;
        if (!a) {
            if (a.getBlackJackCard() == null) {
                var5_5 = 2;
                var7_9 = new ArrayList<E>();
            } else {
                if (a.getBlackJackCard().getPoint() > 21) {
                    return BankSystem.ALLATORIxDEMO("\u60df\u6b17\u5c37\u5d81\u7271\u723fV");
                }
                if (a.getBlackJackCard().getPoint() == 21) {
                    return \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u6091\u76e0\u5274\u5dfc\u000b?\u9ee7\"\u7118\u9806\u88e5\u7242G");
                }
                var5_5 = 1;
                v0 = a;
                var6_6 = v0.getBlackJackCard().getPoint();
                var7_9 = v0.getBlackJackCard().getCard();
            }
        } else if (BlackJack.k == null) {
            var5_5 = 2;
            var7_9 = new ArrayList<E>();
        } else {
            if (BlackJack.k.getPoint() > 21) {
                return BankSystem.ALLATORIxDEMO("\u60df\u6b17\u5c37\u5d81\u7271\u723fV");
            }
            if (BlackJack.k.getPoint() == 21) {
                return \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u60a6\u76d7\u5243\u5dcb<\b\u9ed0G");
            }
            var5_5 = 1;
            var6_6 = BlackJack.k.getPoint();
            var7_9 = BlackJack.k.getCard();
        }
        v1 = var6_7 = new Poke(a);
        v1.shuffle();
        var8_10 = null;
        var8_10 = v1.draw(var5_5);
        if (var7_9 != null && var7_9.size() > 0) {
            while (var7_9.contains(var8_10 = var6_7.draw(var5_5))) {
            }
        }
        var5_5 = 0;
        v2 = var6_8 = 0;
        while (v2 < var8_10.length) {
            var7_9.add(var8_10[var6_8++]);
            v2 = var6_8;
        }
        var6_8 = 0;
        var8_11 = 0;
        var4_4.append(BankSystem.ALLATORIxDEMO("T\u0017JNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJNJ~}"));
        var4_4.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"-[\u7578\u5274\u64cf\u6730\u768a\u7275\u7d4a\u0003-K"));
        var9_12 = var7_9.iterator();
        while (var9_12.hasNext()) {
            var10_14 = (Card)var9_12.next();
            if (var10_14.getValue() != 1) {
                var5_5 += var10_14.getValue();
                v3 = var4_4;
            } else {
                ++var8_11;
                v3 = var4_4;
            }
            v3.append(" " + var10_14.toString());
            if (var10_14.getValue() != 7) continue;
            ++var6_8;
        }
        var4_4.append(BankSystem.ALLATORIxDEMO("~}"));
        var9_13 = false;
        if (var8_11 <= 0) ** GOTO lbl76
        var10_15 = var5_5 + 10 + var8_11;
        if (var10_15 <= 21) {
            var5_5 = var10_15;
            v4 = var4_4;
        } else {
            var5_5 += var8_11;
lbl76:
            // 2 sources

            v4 = var4_4;
        }
        v4.append("#b\u76ee\u524d\u624b\u724c:#r " + var5_5 + " #b\u9ede!\r\n");
        if (var7_9.size() == 2 && var5_5 == 21) {
            var3_3 = GameSet.\u9ed1\u5091\u514b;
            v5 = var4_4;
        } else if (var7_9.size() >= 5 && var5_5 <= 21) {
            var3_3 = GameSet.\u4e94\u9f8d;
            v5 = var4_4;
        } else if (var7_9.size() == 3 && var6_8 == 3) {
            var3_3 = GameSet.\u4e09\u5f35\u4e03;
            v5 = var4_4;
        } else if (var5_5 <= 21) {
            var3_3 = GameSet.\u6bd4\u9ede;
            v5 = var4_4;
        } else {
            var3_3 = GameSet.\u7206\u724c;
            v5 = var4_4;
        }
        v5.append("#b\u6b64\u724c\u7d44\u578b\u614b:#r" + var3_3.getName() + "\r\n");
        var4_4.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u001aj\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u00043\u0004\u00033"));
        var10_16 = new BlackJackResultInfo(var7_9, var3_3, var5_5);
        if (!a) {
            if (BlackJack.E) {
                v6 = var4_4;
                a.setBlackJackCard(var10_16);
                return v6.toString();
            }
        } else {
            BlackJack.k = var10_16;
        }
        v6 = var4_4;
        return v6.toString();
    }

    public static /* synthetic */ {
        H = new HashMap<Integer, Integer>();
        e = new BlackJack();
        E = true;
        g = true;
        B = new ArrayList<GameSet>();
        k = null;
        K = 0L;
        a = 0L;
        d = 0L;
        ALLATORIxDEMO = true;
    }

    public static class BlackJackResultInfo {
        private final /* synthetic */ int a;
        private /* synthetic */ List<Card> ALLATORIxDEMO;
        private final /* synthetic */ GameSet d;

        public /* synthetic */ List<Card> getCard() {
            BlackJackResultInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ int getPoint() {
            BlackJackResultInfo a2;
            return a2.a;
        }

        public /* synthetic */ GameSet getGameSet() {
            BlackJackResultInfo a2;
            return a2.d;
        }

        public /* synthetic */ BlackJackResultInfo(List<Card> a2, GameSet a3, int a4) {
            BlackJackResultInfo a5;
            BlackJackResultInfo blackJackResultInfo = a5;
            a5.d = a3;
            blackJackResultInfo.a = a4;
            blackJackResultInfo.ALLATORIxDEMO = a2;
        }
    }

    public class Card
    implements Comparable {
        private /* synthetic */ int a;
        public final /* synthetic */ BlackJack ALLATORIxDEMO;
        private /* synthetic */ String d;

        public /* synthetic */ int getValue() {
            Card a2;
            if (a2.a >= 10) {
                return 10;
            }
            return a2.a;
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
                    string = SpecialSkillConstants.ALLATORIxDEMO("v");
                    card = a2;
                    return card.d + string;
                }
                case 11: {
                    string = Timer.ALLATORIxDEMO("^");
                    card = a2;
                    return card.d + string;
                }
                case 12: {
                    string = SpecialSkillConstants.ALLATORIxDEMO("f");
                    card = a2;
                    return card.d + string;
                }
                case 13: {
                    string = Timer.ALLATORIxDEMO("_");
                    card = a2;
                    return card.d + string;
                }
            }
            Card card2 = a2;
            card = card2;
            string = String.valueOf(card2.a);
            return card.d + string;
        }

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

        /*
         * Enabled aggressive block sorting
         */
        public /* synthetic */ int getColorLevel() {
            int n2;
            int n3;
            block12: {
                Card a2;
                n3 = 0;
                String string = a2.d;
                int n4 = -1;
                switch (string.hashCode()) {
                    case 862924: {
                        if (!string.equals(SpecialSkillConstants.ALLATORIxDEMO("\u68f7\u8286"))) break;
                        n2 = n4 = 0;
                        break block12;
                    }
                    case 829873: {
                        if (!string.equals(Timer.ALLATORIxDEMO("\u65d9\u585e"))) break;
                        n2 = n4 = 1;
                        break block12;
                    }
                    case 1016670: {
                        if (!string.equals(SpecialSkillConstants.ALLATORIxDEMO("\u7d77\u5ff4"))) break;
                        n2 = n4 = 2;
                        break block12;
                    }
                    case 1287058: {
                        if (!string.equals(Timer.ALLATORIxDEMO("\u9eb1\u6857"))) break;
                        n4 = 3;
                    }
                }
                n2 = n4;
            }
            switch (n2) {
                case 0: {
                    return 1;
                }
                case 1: {
                    return 2;
                }
                case 2: {
                    return 3;
                }
                case 3: {
                    return 4;
                }
            }
            return n3;
        }

        public /* synthetic */ int getValueReal() {
            Card a2;
            return a2.a;
        }

        public /* synthetic */ Card(BlackJack a2, int a3, String a4) {
            Card a5;
            Card card = a5;
            a5.ALLATORIxDEMO = a2;
            card.a = a3;
            card.d = a4;
        }

        public /* synthetic */ String getColor() {
            Card a2;
            return a2.d;
        }
    }

    private static final class GameSet
    extends Enum<GameSet> {
        public /* synthetic */ double a;
        public /* synthetic */ int d;
        private static final /* synthetic */ GameSet[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ GameSet \u4e94\u9f8d;
        public final /* synthetic */ String K;
        public static final /* synthetic */ /* enum */ GameSet \u9ed1\u5091\u514b;
        public static final /* synthetic */ /* enum */ GameSet \u7206\u724c;
        public static final /* synthetic */ /* enum */ GameSet \u4e09\u5f35\u4e03;
        public static final /* synthetic */ /* enum */ GameSet \u6bd4\u9ede;

        public static /* synthetic */ GameSet valueOf(String a2) {
            return Enum.valueOf(GameSet.class, a2);
        }

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ GameSet(String string2, double string2, int a2) {
            void a3;
            void a4;
            void var2_-1;
            void var1_-1;
            GameSet a5;
            GameSet gameSet = a5;
            a5.K = a4;
            gameSet.a = a2;
            gameSet.d = a3;
        }

        public /* synthetic */ double getOdds() {
            GameSet a2;
            return a2.a;
        }

        public /* synthetic */ String getName() {
            GameSet a2;
            return a2.K;
        }

        public /* synthetic */ double geLevel() {
            GameSet a2;
            return a2.d;
        }

        public static /* synthetic */ GameSet[] values() {
            return (GameSet[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ {
            \u4e09\u5f35\u4e03 = new GameSet(PlayerRandomStream.ALLATORIxDEMO("\u4e46\u5f66\u4e4c"), 0, ConsoleCommandObject.ALLATORIxDEMO("\u4e33\u5f29\u4e39"), 3.0, 5);
            \u4e94\u9f8d = new GameSet(PlayerRandomStream.ALLATORIxDEMO("\u4ec7\u9fc2"), 1, ConsoleCommandObject.ALLATORIxDEMO("\u4e88\u9fb7"), 2.0, 4);
            \u9ed1\u5091\u514b = new GameSet(PlayerRandomStream.ALLATORIxDEMO("\u9e9e\u50c2\u5104"), 2, ConsoleCommandObject.ALLATORIxDEMO("\u9eeb\u508d\u5171"), 1.5, 3);
            \u6bd4\u9ede = new GameSet(PlayerRandomStream.ALLATORIxDEMO("\u6b87\u9e91"), 3, ConsoleCommandObject.ALLATORIxDEMO("\u6bc8\u9ee4"), 1.0, 2);
            \u7206\u724c = new GameSet(PlayerRandomStream.ALLATORIxDEMO("\u7255\u7203"), 4, ConsoleCommandObject.ALLATORIxDEMO("\u721a\u7276"), 0.0, 1);
            GameSet[] arrgameSet = new GameSet[5];
            arrgameSet[0] = \u4e09\u5f35\u4e03;
            arrgameSet[1] = \u4e94\u9f8d;
            arrgameSet[2] = \u9ed1\u5091\u514b;
            arrgameSet[3] = \u6bd4\u9ede;
            arrgameSet[4] = \u7206\u724c;
            ALLATORIxDEMO = arrgameSet;
        }

        public static final /* synthetic */ GameSet getByName(String a2) {
            int n2;
            GameSet[] arrgameSet = GameSet.values();
            int n3 = arrgameSet.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                GameSet gameSet = arrgameSet[n2];
                if (gameSet.K.equals(a2)) {
                    return gameSet;
                }
                n4 = ++n2;
            }
            return null;
        }
    }

    public class Poke {
        public /* synthetic */ String[] d;
        public /* synthetic */ int[] a;
        public /* synthetic */ Card[] K;
        public final /* synthetic */ BlackJack ALLATORIxDEMO;

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

        public /* synthetic */ void sortOut(Card[] a2) {
            Arrays.sort(a2);
        }

        public /* synthetic */ Poke(BlackJack a2) {
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
            arrstring[0] = MapleAndroid.ALLATORIxDEMO("\u7d76\u5fd4");
            arrstring[1] = MapleBuffStatValueHolder.ALLATORIxDEMO("\u9e81\u6803");
            arrstring[2] = MapleAndroid.ALLATORIxDEMO("\u65ca\u585d");
            arrstring[3] = MapleBuffStatValueHolder.ALLATORIxDEMO("\u68d5\u82f1");
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

    public class MathTest {
        public /* synthetic */ List<Card[]> Collections;

        public /* synthetic */ MathTest() {
            MathTest a3;
            MathTest mathTest = a3;
            mathTest.Collections = new LinkedList<Card[]>();
        }

        public /* synthetic */ long factorial(int a2) {
            if (a2 > 1) {
                MathTest a3;
                return (long)a2 * a3.factorial(a2 - 1);
            }
            return 1L;
        }

        private /* synthetic */ void ALLATORIxDEMO(Card[] a2, int a3, Card[] a4, int a5) {
            MathTest a6;
            int n2 = a4.length;
            int n3 = a5 + 1;
            Card[] arrcard = new Card[3];
            arrcard = (Card[])a4.clone();
            if (n3 > n2) {
                a6.Collections.add(arrcard);
                return;
            }
            int n4 = a3 = a3;
            while (n4 < a2.length + n3 - n2) {
                a4[a5] = a2[a3];
                a6.ALLATORIxDEMO(a2, ++a3, a4, a5 + 1);
                n4 = a3;
            }
        }

        public /* synthetic */ long arrangement(int a2, int a3) {
            if (a2 >= a3) {
                MathTest a4;
                return a4.factorial(a2) / a4.factorial(a2 - a3);
            }
            return 0L;
        }

        public /* synthetic */ List<Card[]> getarrangement(Card[] a2) {
            MathTest a3;
            MathTest mathTest = a3;
            mathTest.Collections.clear();
            mathTest.combinationSelect(a2, 3);
            return mathTest.Collections;
        }

        public /* synthetic */ long combination(int a2, int a3) {
            if (a2 >= a3) {
                MathTest a4;
                return a4.factorial(a2) / a4.factorial(a2 - a3) / a4.factorial(a3);
            }
            return 0L;
        }

        public /* synthetic */ void combinationSelect(Card[] a2, int a3) {
            MathTest a4;
            a4.ALLATORIxDEMO(a2, 0, new Card[a3], 0);
        }
    }
}

