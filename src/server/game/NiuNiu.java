/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package server.game;

import client.MapleCharacter;
import client.MapleCoreAura;
import client.messages.CommandExecute;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.channel.handler.BuddyListHandler;
import handling.channel.handler.PlayersHandler;
import handling.world.MapleMessenger;
import handling.world.World;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.MapleItemInformationProvider;
import server.maps.MapleMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.StringUtil;

public class NiuNiu {
    private static /* synthetic */ List<Integer> d;
    private static /* synthetic */ Map<Integer, Integer> C;
    private static /* synthetic */ long k;
    private static /* synthetic */ double ALLATORIxDEMO;
    private static /* synthetic */ long K;
    private static final /* synthetic */ NiuNiu H;
    private static /* synthetic */ long a;
    private static /* synthetic */ boolean E;
    private static /* synthetic */ boolean e;
    private static /* synthetic */ List<GameSet> g;
    private static /* synthetic */ NiuNiuResultInfo B;

    public /* synthetic */ long getNowBet() {
        return a;
    }

    public /* synthetic */ String bet(MapleCharacter a2, int a3) {
        String string = "";
        int n2 = a2.getNiuNiuOwe();
        if (d.contains(a2.getId())) {
            return StringUtil.ALLATORIxDEMO("\u6082\u56d1\u8cc7\u536b\u6b0a\u5084\u710b\u6ce4\u5135\u90b5\u8026\u905c\u521a\u79b0\u8cd7\u0010");
        }
        if (a2.getClient().getChannel() != GameSetConstants.NIUNIU_LOCATION[0] || a2.getMapId() != GameSetConstants.NIUNIU_LOCATION[1]) {
            return "\u60a8\u7684\u6240\u5728\u5340\u57df\u7121\u6cd5\u4e0b\u6ce8! \u8acb\u79fb\u52d5\u81f3" + GameSetConstants.NIUNIU_LOCATION[0] + "S " + MapleItemInformationProvider.getInstance().getMapName(GameSetConstants.NIUNIU_LOCATION[1]);
        }
        if (World.isShutDown) {
            return MapleMessenger.ALLATORIxDEMO("\u76f6\u5236\u536b\u5c7c\u95c4\u67767\u6b18\u5730\u7dd6\u8b6fW\u8cf5\u5321\u7ce3\u7d0a\u66b3\u5027\u4f67\u75539");
        }
        if (!GameSetConstants.isGamblingTime()) {
            int n3;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(StringUtil.ALLATORIxDEMO("\u76c4\u527c\u4e0c\u976f\u8cc7\u536b\u95a1\u650f\u6668\u95a2\u54cc\u0010';"));
            stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u8cf5\u5321\u9593\u6545\u665a\u95e8\"[\u6bd7\u659e8"));
            int[] arrn = GameSetConstants.GAMBLING_HOUR;
            int n4 = arrn.length;
            int n5 = n3 = 0;
            while (n5 < n4) {
                stringBuilder.append(arrn[n3++] + " ");
                n5 = n3;
            }
            StringBuilder stringBuilder2 = stringBuilder;
            stringBuilder2.append(StringUtil.ALLATORIxDEMO("\u9eef"));
            return stringBuilder2.toString();
        }
        if (n2 > 0) {
            if (a2.getMeso() >= n2) {
                MapleCharacter mapleCharacter = a2;
                mapleCharacter.gainMeso(-n2, true);
                mapleCharacter.setNiuNiuOwe(0);
                return "\u60a8\u5df2\u511f\u9084\u50b5\u6b3e " + n2 + " \u5143!\u5df2\u53ef\u7e7c\u7e8c\u9032\u884c\u904a\u6232\u3002";
            }
            return "\u60a8\u7121\u80fd\u529b\u511f\u9084\u50b5\u6b3e " + n2 + " \u5143!\u7121\u6cd5\u7e7c\u7e8c\u9032\u884c\u904a\u6232\u3002";
        }
        if (a2.getMeso() < a3 * 10) {
            return MapleMessenger.ALLATORIxDEMO("\u60b0\u76ff\u694b\u5e18\u4e15\u8dc89\u70c1\u962a\u73d2\u5bae\u784f\u753aW\u6bd7\u6b5a\u4e13\u6c93\u9855\u5edd\u6718\u9aa3\u50dd\u8086\u4e13\u6c93\u8eb3\u4e71\u64d9\u6772\u8cb9\u5bb7\u769cJ(^9");
        }
        if (e) {
            if (!C.containsKey(a2.getId())) {
                if ((int)((double)a2.getMeso() * ALLATORIxDEMO) >= a3) {
                    NiuNiu a4;
                    a2.gainMeso(-a3, true);
                    k += (long)a3;
                    a += (long)a3;
                    C.put(a2.getId(), a3);
                    E = true;
                    NiuNiuResultInfo niuNiuResultInfo = a4.getNiuNiuCard();
                    Card[] arrcard = niuNiuResultInfo.getCard();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("#b\u6295\u6ce8 " + a3 + " \u6953\u5e63\u6210\u529f!\r\n");
                    stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u6099\u7358\u5fa6\u76ae\u727d\u7090\u000b\tU';"));
                    stringBuilder.append(MapleMessenger.ALLATORIxDEMO("%F%F%F%F%F%F%F%F%F%F%F%F%F%F%F%v\u0012"));
                    int n6 = 0;
                    int n7 = n6;
                    while (n7 < arrcard.length) {
                        Card card = arrcard[n6];
                        stringBuilder.append(card.toString() + " ");
                        n7 = ++n6;
                    }
                    stringBuilder.append(StringUtil.ALLATORIxDEMO("< \f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f\u0017\f"));
                    stringBuilder.append("\r\n#b\u724c\u578b: #r" + niuNiuResultInfo.getGameSet().getName());
                    stringBuilder.append("\r\n#b\u9ede\u6578: #r" + niuNiuResultInfo.getPoint());
                    stringBuilder.append("\r\n#b\u624b\u4e2d\u6700\u5927\u724c\u70ba: #r" + niuNiuResultInfo.getBiggestCard());
                    a2.setNiuNiuCard(niuNiuResultInfo);
                    string = stringBuilder.toString();
                    return string;
                }
                string = MapleMessenger.ALLATORIxDEMO("\u60b0\u76ff\u694b\u5e18\u4e15\u8dc89\u70c1\u962a\u73d2\u5bae\u784f\u753aW\u6bd7\u6b5a\u4e13\u6c93\u9855\u5edd\u6718\u9aa3\u50dd\u8086\u4e13\u6c93\u8eb3\u4e71\u64d9\u6772\u8cb9\u5bb7\u769cJ(^9");
                return string;
            }
            string = StringUtil.ALLATORIxDEMO("\u6099\u6b4e\u5c71\u5dd8\u4e3a\u6cc2\u907f\u000b\u0011\u8ae1\u7b78\u5faf\u95ba\u7364\u001f\u0004\u001f");
            return string;
        }
        string = MapleMessenger.ALLATORIxDEMO("\u7695\u5255\u6b18\u5730\u95f0\u7356\u4e566U6\u8ab0\u7a15\u5ff7\u5195\u4e70\u6cf0");
        return string;
    }

    public static /* synthetic */ NiuNiu getInstance() {
        return H;
    }

    public static /* synthetic */ {
        C = new HashMap<Integer, Integer>();
        H = new NiuNiu();
        e = true;
        E = false;
        g = new ArrayList<GameSet>();
        B = null;
        k = 0L;
        K = 0L;
        a = 0L;
        d = new ArrayList<Integer>();
        ALLATORIxDEMO = 0.1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getShowdownLog() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012N\u4efb\u65cf\u95ba\u7364\u7d31\u932e\u000b';';"));
        Iterator<GameSet> iterator = g.iterator();
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
                        if (!string.equals(MapleMessenger.ALLATORIxDEMO("\u83f1\u5bae"))) break;
                        n2 = n3 = 0;
                        break block12;
                    }
                    case 1210468: {
                        if (!string.equals(StringUtil.ALLATORIxDEMO("\u95b8\u5b87"))) break;
                        n2 = n3 = 1;
                        break block12;
                    }
                    case 694580: {
                        if (!string.equals(MapleMessenger.ALLATORIxDEMO("\u54f7\u5c58"))) break;
                        n3 = 2;
                    }
                }
                n2 = n3;
            }
            switch (n2) {
                case 0: {
                    stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u83bb"));
                    continue block10;
                }
                case 1: {
                    stringBuilder.append(MapleMessenger.ALLATORIxDEMO(";\u0019\u958a"));
                    continue block10;
                }
                case 2: {
                    stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012M\u54bd"));
                    continue block10;
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getNiuNiuBankerCard() {
        NiuNiuResultInfo niuNiuResultInfo;
        int n2;
        int n3;
        NiuNiu a2;
        GameSet gameSet = null;
        int n4 = 5;
        int n5 = 0;
        Object object = new Poke(a2);
        Poke poke = object;
        poke.shuffle();
        Card[] arrcard = poke.draw(n4);
        object = a2.getBiggestCard(arrcard);
        int n6 = arrcard[0].getValue() + arrcard[1].getValue() + arrcard[2].getValue() + arrcard[3].getValue() + arrcard[4].getValue();
        ArrayList<Integer> arrayList = a2.new MathTest().getarrangement(arrcard);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (Card[] arrcard2 : arrayList) {
            int n7 = arrcard2[0].getValue() + arrcard2[1].getValue() + arrcard2[2].getValue();
            if (n7 % 10 != 0) continue;
            n3 = n6 - n7;
            arrayList2.add(n3);
        }
        if (arrayList2.size() > 0) {
            Iterator iterator;
            boolean bl = false;
            ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
            Iterator iterator2 = iterator = arrayList2.iterator();
            while (iterator2.hasNext()) {
                n3 = (Integer)iterator.next();
                n6 = n3 % 10;
                if (n6 == 0) {
                    gameSet = GameSet.\u599e\u599e;
                    bl = true;
                }
                arrayList3.add(n6);
                iterator2 = iterator;
            }
            if (!bl) {
                int n8;
                n5 = n8 = ((Integer)Collections.max(arrayList3)).intValue();
                switch (n8) {
                    case 8: 
                    case 9: {
                        gameSet = GameSet.\u5927\u9ede;
                        break;
                    }
                    default: {
                        gameSet = GameSet.\u5c0f\u9ede;
                        break;
                    }
                }
            }
        } else {
            int n9;
            arrayList = new ArrayList<Integer>();
            int n10 = n9 = 0;
            while (n10 < arrcard.length) {
                void var8_14;
                arrayList.add(arrcard[++var8_14].getValueReal());
                n10 = var8_14;
            }
            int n11 = (Integer)Collections.max(arrayList);
            gameSet = GameSet.\u70cf\u9f8d;
            n5 = n11;
        }
        boolean bl = true;
        int n12 = n2 = 0;
        while (n12 < arrcard.length) {
            void var8_17;
            if (arrcard[var8_17].getValueReal() <= 10) {
                bl = false;
            }
            n12 = ++var8_17;
        }
        if (bl) {
            gameSet = GameSet.\u7d42\u6975\u599e\u599e;
        }
        B = niuNiuResultInfo = new NiuNiuResultInfo(arrcard, gameSet, n5, (Card)object);
        return "\u838a\u5bb6\u724c\u578b:" + gameSet.getName() + " \u9ede\u6578:" + n5 + " \u6700\u5927\u724c:" + (Card)object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public /* synthetic */ NiuNiuResultInfo getNiuNiuCard() {
        int n2;
        int n3;
        NiuNiu a2;
        GameSet gameSet = null;
        int n4 = 5;
        int n5 = 0;
        Object object = new Poke(a2);
        Poke poke = object;
        poke.shuffle();
        Card[] arrcard = poke.draw(n4);
        object = a2.getBiggestCard(arrcard);
        int n6 = arrcard[0].getValue() + arrcard[1].getValue() + arrcard[2].getValue() + arrcard[3].getValue() + arrcard[4].getValue();
        ArrayList<Integer> arrayList = a2.new MathTest().getarrangement(arrcard);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (Card[] arrcard2 : arrayList) {
            int n7 = arrcard2[0].getValue() + arrcard2[1].getValue() + arrcard2[2].getValue();
            if (n7 % 10 != 0) continue;
            n3 = n6 - n7;
            arrayList2.add(n3);
        }
        if (arrayList2.size() > 0) {
            Iterator iterator;
            boolean bl = false;
            ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
            Iterator iterator2 = iterator = arrayList2.iterator();
            while (iterator2.hasNext()) {
                n3 = (Integer)iterator.next();
                n6 = n3 % 10;
                if (n6 == 0) {
                    gameSet = GameSet.\u599e\u599e;
                    bl = true;
                }
                arrayList3.add(n6);
                iterator2 = iterator;
            }
            if (!bl) {
                int n8;
                n5 = n8 = ((Integer)Collections.max(arrayList3)).intValue();
                switch (n8) {
                    case 8: 
                    case 9: {
                        gameSet = GameSet.\u5927\u9ede;
                        break;
                    }
                    default: {
                        gameSet = GameSet.\u5c0f\u9ede;
                        break;
                    }
                }
            }
        } else {
            int n9;
            arrayList = new ArrayList<Integer>();
            int n10 = n9 = 0;
            while (n10 < arrcard.length) {
                void var8_14;
                arrayList.add(arrcard[++var8_14].getValueReal());
                n10 = var8_14;
            }
            int n11 = (Integer)Collections.max(arrayList);
            gameSet = GameSet.\u70cf\u9f8d;
            n5 = n11;
        }
        boolean bl = true;
        int n12 = n2 = 0;
        while (n12 < arrcard.length) {
            void var8_17;
            if (arrcard[var8_17].getValueReal() <= 10) {
                bl = false;
            }
            n12 = ++var8_17;
        }
        if (!bl) return new NiuNiuResultInfo(arrcard, gameSet, n5, (Card)object);
        gameSet = GameSet.\u7d42\u6975\u599e\u599e;
        return new NiuNiuResultInfo(arrcard, gameSet, n5, (Card)object);
    }

    public /* synthetic */ NiuNiu() {
        NiuNiu a2;
    }

    public /* synthetic */ String getRules() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append(MapleMessenger.ALLATORIxDEMO(";\t\u5986\u59e55\u9031\u622a\u73d2\u6ccd\u53b1\u7254\u57f0\u4ed3\u7d42\"S\u521f\u8a639\u9031\u622a\u4e70\u6cf0\u5ff7\u81eb\u95f0\u7356\u6639\u82fd\u65cc\u7dc2\u750d\u5c58\u4e70\u6cf0\u4e7b\u5b82\u6778\u88b3\u54788\u4e76\u88c4\u51641v\u0012"));
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\tS\u3020\u4e31\u8206\u89be\u526d\u303a';\tU"));
        stringBuilder3.append(MapleMessenger.ALLATORIxDEMO(")U\u4f67\u7553\u7254\u6503\uff02\u4e7b\u5277\u7237-I\u5f2d\uff77\u4e15\u537e\u5433\u9b47\u7254v\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0003\u0004\u727d\u9ef4\u8a39\u7bbd\uff2bk\u81c2\u0013\u708b\u001b\u81c2\u0013\u9eef\uff26\u0000\u001a\u3030`\u3030{\u3030a\u76b7\u7090\u0000\u001a\u9eef';"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("H6\u82ca\u826a\u6baf\u8f1b\uff61\u9ec9\u68388E8\u7d7e\u5fdb[&[\u65a1\u58318E8\u68fe\u82a9v\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0005\u0004\u5230\u7266\u6588\u5f25\uff2b\u7383\u5b87\u5fef\u9839\u5c2d\u0004\u5f1f\u627a\u7266\u4ed4\u5267\u5158\u5f1f\u3030\u5fa6\u4e38\u5f1f\u76b5\u6593\u5f3e\u7d6e\u5439';"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("Xz\u3071\u7254\u57f0\u7d5c\u5473\u8ab2\u6675\u3013v\u0012X|"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u0019\u4e2a\u0018\u7d68\u6944\u59b4\u59af';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u756e\u73d2\u5bae\u76ff-\u5f4e\u6253\u7237\u769e\u70c1R\u307aI\u307aS\u623b\u7d5c\u626b\u665a\uff77\u536b\u70c1\u7d5a\u690e\u5986\u59e5\uff14\u8c9b\u739f\u70c1-\u50760\u83f1\u5bae\u6284\u5228\u6b1f\u7254\u57f0\u525f\u73d2\u5bae\u8c9b-\u50761v\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u0019\u4ea6\u0018\u59b4\u59af';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u5255\u5112\u5f2d\u54f7\u5f94\u4e72\u5f2d\u76ff\u9ec6\u6503\u5494\u527d\u523d\u9086\u70a2J(\u76ff\u5015\u6503\u665a\uff77\u536b\u70c1\u5986\u59e5\uff14\u8c9b\u739f\u70c1+\u50760\u83f1\u5bae\u6284\u5228\u6b1f\u7254\u57f0\u525f\u73d2\u5bae\u8c9b+\u50761v\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u0019\u4e23\u0018\u590d\u9eef';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u756e\u5ff7\u4e11\u5f4e\u769c\u7e46\u9ec6\u6503\u70a2J(\u76ff\u5015\u6503\uff14\u8077\u5255\u5112\u5f2d\u4e30\u7e25\u54f7\u9746J(\u9ea5\u665a\uff77\u53ce\u510d\u5013\u4f36\u6560\u4f27\u70a2\u9ea5\u6560\uff77\u756e\u9ea5\u6560\u70c1 \u4e9e\u4e12\u66390\u537e\u5433C\u9ec6R\u7a29\u70c1\u3014\u595c\u9ec6\u30764\u8c9b\u739f\u70c1\u5171\u50760\u83f1\u5bae\u6284\u5228\u6b1f\u7254\u57f0\u525f\u73d2\u5bae\u8c9b*\u50761v\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u0019\u56f1\u0018\u5c25\u9eef';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u750d\u5f94\u4e72\u5f2d\u76ff\u7e25\u9ea5\u6560\u70c1)K\u769c\u5076\u6560\uff77\u8014\u5236\u5171\u5f4e\u4e53\u7e46\u5494\u9725)K\u9ec6\u6639\uff14\u53ad\u516e\u5070\u4f55\u6503\u4f44\u70c1\u9ec6\u6503\uff14\u750d\u9ec6\u6503\u70a2L\u4efd\u4e70\u665aS\u531d\u5450/\u9ea51\u7a4a\u70a2\u3077\u5c17\u9ea5\u3015v\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u0012X\u0019\u4ebe\u0018\u70e5\u9fbc';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u829e\u5f94\u4e72\u5f2d\u715a\u6ccd\u63e9\u51e2\u7e46\u9ec6\u6503\u70a2J(\u9ea5\u665a\uff77\u536b\u7a4a\u70a2\u70b4\u9f95\u3079\u82fd\u83f1\u5bae\u827c\u958a\u5bcd\u769e\u70c1\u7139\u8c8f\u665a\uff77\u525f\u6baf\u8f1b\u4eef\u5f2d\u7237\u4e35\u677b\u593f\u7237\u4e53\u7237\u9ec6\uff77\u82fd\u7237\u9ec6\u4e7b\u6a3b\u595c\u525f\u6baf\u8f1b\u82ca\u826av\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\tS\u3020\u6be5\u8cd7\u89be\u526d\u303a';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO(";\t0\u4e7b1\u7237\u5793\u595c\u5c17\u6baf\u8f1bv\u0012X|"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u7d73\u695f\u59af\u59b4\u0011\u0014\u0011\u59b4\u59af\n\u000f\n\b\u9ef4\u0011\u0014\u0011\u0012\u9eef\n\u000f\n\u2017\u200c\u0011\u0014\u0011\u0018\u9eef\n\u000f\n\u0000\u9ef4\u0011\u0014\u0011\u70e5\u9fbc';"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO(";\t0\u4ef71\u70b4\u9f95\u595c\u5c17\u6baf\u8f1bv\u0012X|"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\u755c\u83bb\u5b9c\u8236\u95b8\u5b87\u76ac\u708b\u710b\u8cc5\u7266\u57ba\u6668\uff3d\u526d\u6be5\u8f29\u4ea5\u5f1f\u627a\u7266\u4e1c\u672a\u5916\u7266\uff3d\u6bfe\u8f32\u590d\u5c3e\u982c\u5ebe\u7090z\u0014`\u0014{\u0014\u0000\u001a\u000f\u200c\u2017\u0014\u0003\u0014\u0000\u3028\u82d4\u672a\u5916\u7266\u9eef\u6552\u76c9\u5426\uff3d\u526d\u6be5\u8f29\u8280\u8258\uff3d\u829b\u8243\u590d\u5c3e\u982c\u5ebe\u7090\u9ee0\u6869\u000f\u7d2f\u5ff2\u0014\u6588\u5860\u000f\u68af\u8280';"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("+6(\"\u750d\u958a\u5bcd\u769c\u4eef\u5f2d\u6230\u7254\u4e56\uff14\u677b\u593f\u7237\u97461\u3019*\u30190\u665a\uff77\u525f\u715a\u8ace\u83f1\u5bae\u677b\u593f\u7237\u70a2\u4f2e\uff14\u4e7b\u5f93\u7bec\u8392\u5bcd\u736a\u52a6\u301av\u0012"));
        stringBuilder.append(StringUtil.ALLATORIxDEMO("\tC\u0002\u4e38\u0003\u543d\u9ef4\u6549\u623c\u543d\u7266\u57ba\u6bfe\u727d';\tU"));
        stringBuilder.append(MapleMessenger.ALLATORIxDEMO("\u750d\u8392\u5bcd\u821f\u95e9\u5bae\u76ff\u769e\u6284\u7d5a\u690e\u5986\u59e5\u3019\u59e5\u5986\u626d\u9ec6\u6503\u4e18\u6a58\u7b51\u7683\u5414\u7237\u5793\uff77\u525f\u6baf\u8f1b\u4eef\u5f2d\u7237\u4e35\u677b\u593f\u7237\uff14\u6baf\u8f1b\u65c2\u5f17\u59f9\u4e12S\u70d7\u9ff6\u593f\u5c74\u6bcc\u8f781"));
        return stringBuilder3.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void SendReward() {
        var1_1 = NiuNiu.B.getGameSet();
        var2_2 = NiuNiu.B.getPoint();
        var3_3 = ChannelServer.getInstance(0, GameSetConstants.NIUNIU_LOCATION[0]).getMapFactory().getMap(GameSetConstants.NIUNIU_LOCATION[1]);
        var4_4 = NiuNiu.C.entrySet().iterator();
        while (var4_4.hasNext() != false) {
            block14: {
                block13: {
                    block8: {
                        block10: {
                            block12: {
                                block11: {
                                    block9: {
                                        var5_5 = var4_4.next();
                                        var6_7 = false;
                                        var7_8 = false;
                                        var8_9 = MapleCharacter.getOnlineCharacterById(var5_5.getKey());
                                        var9_10 = var8_9.getNiuNiuCard();
                                        if (var9_10 == null) continue;
                                        var10_12 = var9_10.getGameSet();
                                        var5_6 = var5_5.getValue();
                                        v0 = var9_10;
                                        var9_11 = v0.getPoint();
                                        var11_13 = NiuNiu.B.getBiggestCard();
                                        var12_16 = v0.getBiggestCard();
                                        if (var5_6 <= 0) break block8;
                                        if (!(var10_12.geLevel() > var1_1.geLevel())) break block9;
                                        var6_7 = true;
                                        v1 = var10_12;
                                        break block10;
                                    }
                                    if (var10_12.geLevel() != var1_1.geLevel()) ** GOTO lbl46
                                    if (var9_11 <= var2_2) break block11;
                                    var6_7 = true;
                                    v1 = var10_12;
                                    break block10;
                                }
                                if (var9_11 != var2_2) ** GOTO lbl46
                                if (var11_13.getValueReal() >= var12_16.getValueReal()) break block12;
                                var6_7 = true;
                                v1 = var10_12;
                                break block10;
                            }
                            if (var11_13.getValueReal() != var12_16.getValueReal()) ** GOTO lbl46
                            if (var12_16.getColorLevel() > var11_13.getColorLevel()) {
                                var6_7 = true;
                                v1 = var10_12;
                            } else {
                                if (var12_16.getColorLevel() == var11_13.getColorLevel()) {
                                    var7_8 = true;
                                    v2 = var8_9;
                                    v2.gainMeso(var5_6, true);
                                    v2.dropMessageAll("\u548c\u5c40! \u6b64\u5c40\u838a\u5bb6\u70ba " + var1_1.getName() + " \u9ede\u6578: " + var2_2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + var10_12.getName() + " \u9ede\u6578: " + var9_11 + ",\u9000\u56de\u6953\u5e63" + var5_6 + "\u5143!");
                                }
lbl46:
                                // 6 sources

                                v1 = var10_12;
                            }
                        }
                        if (v1 == GameSet.\u70cf\u9f8d && var12_16.getValueReal() <= 10) {
                            var6_7 = false;
                        }
                    }
                    if (!var6_7) break block13;
                    var13_17 = var10_12.getOdds();
                    var11_14 = (int)((double)var5_6 * var13_17);
                    v3 = var8_9;
                    v3.gainMeso(var5_6, true);
                    v3.gainMeso(var11_14, true);
                    NiuNiu.K += (long)var11_14;
                    if (!v3.isGM()) {
                        var3_3.broadcastMessage(MaplePacketCreator.getSkullSmega("[\u599e\u599e] : \u606d\u559c\u73a9\u5bb6:" + var8_9.getName() + " \u624b\u724c\u70ba " + var10_12.getName() + " \u9ede\u6578: " + var9_11 + " \u6b64\u5c40\u8d0f\u5f97\u6953\u5e63 " + var11_14 + " \u5143!", false, 2));
                    }
                    var8_9.dropMessageAll("\u4f60\u8d0f\u4e86! \u6b64\u5c40\u838a\u5bb6\u70ba " + var1_1.getName() + " \u9ede\u6578: " + var2_2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + var10_12.getName() + " \u9ede\u6578: " + var9_11 + ",\u8d0f\u5f97\u6953\u5e63" + var11_14 + "\u5143!");
                    v4 = var8_9;
                    break block14;
                }
                if (var6_7 || var7_8) ** GOTO lbl80
                var13_17 = var1_1.getOdds();
                var11_15 = (int)((double)var5_6 * var13_17);
                var5_6 = var11_15 - var5_6;
                NiuNiu.K -= (long)var11_15;
                if (var8_9.getMeso() >= var5_6) {
                    v5 = var8_9;
                    v5.gainMeso(-var5_6, true);
                    v5.dropMessageAll("\u4f60\u8f38\u4e86! \u6b64\u5c40\u838a\u5bb6\u70ba " + var1_1.getName() + " \u9ede\u6578: " + var2_2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + var10_12.getName() + " \u9ede\u6578: " + var9_11 + ",\u6b64\u5c40\u5931\u53bb\u6953\u5e63" + var11_15 + "\u5143!");
                    v4 = var8_9;
                } else {
                    NiuNiu.d.add(var8_9.getId());
                    var8_9.setNiuNiuOwe(var5_6);
                    var8_9.dropMessageAll("\u4f60\u8f38\u4e86! \u6b64\u5c40\u838a\u5bb6\u70ba " + var1_1.getName() + " \u9ede\u6578: " + var2_2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + var10_12.getName() + " \u9ede\u6578: " + var9_11 + ",\u56e0\u8ced\u535a\u7834\u7522\u7121\u6cd5\u511f\u9084\u6b20\u8cbb\u800c\u88ab\u7981\u6b62\u4e0b\u6ce8!");
                    FileoutputUtil.logToFile(MapleMessenger.ALLATORIxDEMO("\u0017w\u001ckT\\\u001al\u001a7\u59e5\u5986\u6b5b\u933aUl\u0003l"), "\r\n" + FileoutputUtil.NowTime() + "\u838a\u5bb6\u70ba " + var1_1.getName() + " \u9ede\u6578: " + var2_2 + " ,\u60a8\u6b64\u5c40\u7684\u624b\u724c\u70ba " + var10_12.getName() + " \u9ede\u6578: " + var9_11 + ",\u56e0\u8ced\u535a\u7834\u7522\u7121\u6cd5\u511f\u9084\u6b20\u8cbb\u800c\u88ab\u7981\u6b62\u4e0b\u6ce8");
lbl80:
                    // 2 sources

                    v4 = var8_9;
                }
            }
            v4.setNiuNiuCard(null);
        }
    }

    public /* synthetic */ void Showdown() {
        if (E) {
            int n2;
            NiuNiu a2;
            int n3 = 60;
            MapleMap mapleMap = ChannelServer.getInstance(0, GameSetConstants.NIUNIU_LOCATION[0]).getMapFactory().getMap(GameSetConstants.NIUNIU_LOCATION[1]);
            e = false;
            if (B == null) {
                B = a2.getNiuNiuCard();
            }
            if (B.getGameSet() == GameSet.\u70cf\u9f8d) {
                B = a2.getNiuNiuCard();
            }
            Card[] arrcard = B.getCard();
            StringBuilder stringBuilder = new StringBuilder();
            int n4 = n2 = 0;
            while (n4 < arrcard.length) {
                Card card = arrcard[n2];
                stringBuilder.append(card.toString() + " ");
                n4 = ++n2;
            }
            try {
                long l2 = System.currentTimeMillis();
                a2.SendReward();
                long l3 = System.currentTimeMillis();
                int n5 = (int)((l2 - l3) / 1000L) + 1;
                n3 -= n5;
                n3 -= 2;
                mapleMap.broadcastMessage(MaplePacketCreator.getSkullSmega("[\u599e\u599e] : \u838a\u5bb6\u958b\u724c \u2192 " + stringBuilder.toString(), false, 2));
                Thread.sleep(2000L);
                mapleMap.startMapEffect("\u838a\u958b\u724c\u7d50\u679c \u2192 \u9ede\u6578:" + B.getPoint() + " \u724c\u578b:" + B.getGameSet().getName(), 5120009);
                mapleMap.broadcastMessage(MaplePacketCreator.getHeartSmega("[\u599e\u599e] : \u838a\u958b\u724c\u7d50\u679c \u2192 \u9ede\u6578:" + B.getPoint() + " \u724c\u578b:" + B.getGameSet().getName(), false, 2));
                C.clear();
                e = true;
                E = false;
                B = null;
                a = 0L;
                Thread.sleep(3000L);
                MapleMap mapleMap2 = mapleMap;
                mapleMap2.broadcastMessage(MaplePacketCreator.getClock(n3 -= 3));
                mapleMap2.broadcastMessage(MaplePacketCreator.getSuperMegaphone(StringUtil.ALLATORIxDEMO("j\u59b4\u59afw\u0011\u0010\u0011\u4e21\u76d5\u5dd8\u95ba\u59e1\u0010\u7383\u5b87\u8ae1\u4e3a\u6cc2\u001f\u0004\u001f\u0004\u001f\u0004\u001f\u0002\u8b57\u0010\u5c3e\u8cc7\u6010\u60ef\u001d\u590d\u8cdc\u509d\u8e9a\u000b\u0018"), false, 2));
                return;
            }
            catch (InterruptedException interruptedException) {
                Logger.getLogger(NiuNiu.class.getName()).log(Level.SEVERE, null, interruptedException);
            }
        }
    }

    public /* synthetic */ Card getBiggestCard(Card[] a2) {
        int n2;
        int n3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n4 = n3 = 0;
        while (n4 < a2.length) {
            Card card = a2[n3];
            arrayList.add(card.getValueReal());
            n4 = ++n3;
        }
        n3 = (Integer)Collections.max(arrayList);
        int n5 = 0;
        int n6 = 0;
        int n7 = n2 = 0;
        while (n7 < a2.length) {
            if (a2[n2].getValueReal() == n3 && n5 < a2[n2].getColorLevel()) {
                n5 = a2[n2].getColorLevel();
                n6 = n2;
            }
            n7 = ++n2;
        }
        return a2[n6];
    }

    public /* synthetic */ long getTotalBet() {
        return k;
    }

    public /* synthetic */ long getTotalWin() {
        return K;
    }

    public static class NiuNiuResultInfo {
        private /* synthetic */ Card[] d;
        private final /* synthetic */ int K;
        private final /* synthetic */ Card ALLATORIxDEMO;
        private final /* synthetic */ GameSet a;

        public /* synthetic */ Card[] getCard() {
            NiuNiuResultInfo a2;
            return a2.d;
        }

        public /* synthetic */ int getPoint() {
            NiuNiuResultInfo a2;
            return a2.K;
        }

        public /* synthetic */ GameSet getGameSet() {
            NiuNiuResultInfo a2;
            return a2.a;
        }

        public /* synthetic */ Card getBiggestCard() {
            NiuNiuResultInfo a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ NiuNiuResultInfo(Card[] a2, GameSet a3, int a4, Card a5) {
            NiuNiuResultInfo a6;
            NiuNiuResultInfo niuNiuResultInfo = a6;
            NiuNiuResultInfo niuNiuResultInfo2 = a6;
            niuNiuResultInfo2.a = a3;
            niuNiuResultInfo2.K = a4;
            niuNiuResultInfo.d = a2;
            niuNiuResultInfo.ALLATORIxDEMO = a5;
        }
    }

    public class Card
    implements Comparable {
        private /* synthetic */ String d;
        public final /* synthetic */ NiuNiu ALLATORIxDEMO;
        private /* synthetic */ int a;

        public /* synthetic */ Card(NiuNiu a2, int a3, String a4) {
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

        public /* synthetic */ int getValueReal() {
            Card a2;
            return a2.a;
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
                        if (!string.equals(BankSystem.ALLATORIxDEMO("\u68f6\u82c6"))) break;
                        n2 = n4 = 0;
                        break block12;
                    }
                    case 829873: {
                        if (!string.equals(MapleCoreAura.ALLATORIxDEMO("\u65c9\u5846"))) break;
                        n2 = n4 = 1;
                        break block12;
                    }
                    case 1016670: {
                        if (!string.equals(BankSystem.ALLATORIxDEMO("\u7d76\u5fb4"))) break;
                        n2 = n4 = 2;
                        break block12;
                    }
                    case 1287058: {
                        if (!string.equals(MapleCoreAura.ALLATORIxDEMO("\u9ea1\u684f"))) break;
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

        public /* synthetic */ int getValue() {
            Card a2;
            if (a2.a >= 10) {
                return 10;
            }
            return a2.a;
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
        public /* synthetic */ String toString() {
            Card card;
            String string;
            Card a2;
            switch (a2.a) {
                case 1: {
                    string = BankSystem.ALLATORIxDEMO("6");
                    card = a2;
                    return card.d + string;
                }
                case 11: {
                    string = MapleCoreAura.ALLATORIxDEMO("F");
                    card = a2;
                    return card.d + string;
                }
                case 12: {
                    string = BankSystem.ALLATORIxDEMO("&");
                    card = a2;
                    return card.d + string;
                }
                case 13: {
                    string = MapleCoreAura.ALLATORIxDEMO("G");
                    card = a2;
                    return card.d + string;
                }
            }
            Card card2 = a2;
            card = card2;
            string = String.valueOf(card2.a);
            return card.d + string;
        }
    }

    private static final class GameSet
    extends Enum<GameSet> {
        public final /* synthetic */ String K;
        public /* synthetic */ double a;
        public static final /* synthetic */ /* enum */ GameSet \u599e\u599e;
        public static final /* synthetic */ /* enum */ GameSet \u5927\u9ede;
        public /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ GameSet \u70cf\u9f8d;
        public static final /* synthetic */ /* enum */ GameSet \u7d42\u6975\u599e\u599e;
        public static final /* synthetic */ /* enum */ GameSet \u5c0f\u9ede;
        private static final /* synthetic */ GameSet[] ALLATORIxDEMO;

        public /* synthetic */ double getOdds() {
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
                if (gameSet.K.equals(a2)) {
                    return gameSet;
                }
                n4 = ++n2;
            }
            return null;
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

        public static /* synthetic */ {
            \u7d42\u6975\u599e\u599e = new GameSet(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u7d76\u6924\u59aa\u59cf"), 0, BuddyListHandler.ALLATORIxDEMO("\u7d35\u694f\u59e9\u59a4"), 5.0, 5);
            \u599e\u599e = new GameSet("\u599e\u599e", 1, "\u599e\u599e", 3.0, 4);
            \u5927\u9ede = new GameSet(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5913\u9e8f"), 2, BuddyListHandler.ALLATORIxDEMO("\u5950\u9ee4"), 2.0, 3);
            \u5c0f\u9ede = new GameSet(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u5c3b\u9e8f"), 3, BuddyListHandler.ALLATORIxDEMO("\u5c78\u9ee4"), 1.0, 2);
            \u70cf\u9f8d = new GameSet(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u70fb\u9fdc"), 4, BuddyListHandler.ALLATORIxDEMO("\u70b8\u9fb7"), 1.0, 1);
            GameSet[] arrgameSet = new GameSet[5];
            arrgameSet[0] = \u7d42\u6975\u599e\u599e;
            arrgameSet[1] = \u599e\u599e;
            arrgameSet[2] = \u5927\u9ede;
            arrgameSet[3] = \u5c0f\u9ede;
            arrgameSet[4] = \u70cf\u9f8d;
            ALLATORIxDEMO = arrgameSet;
        }

        public /* synthetic */ String getName() {
            GameSet a2;
            return a2.K;
        }

        public static /* synthetic */ GameSet valueOf(String a2) {
            return Enum.valueOf(GameSet.class, a2);
        }

        public /* synthetic */ double geLevel() {
            GameSet a2;
            return a2.d;
        }

        public static /* synthetic */ GameSet[] values() {
            return (GameSet[])ALLATORIxDEMO.clone();
        }
    }

    public class Poke {
        public /* synthetic */ Card[] K;
        public /* synthetic */ String[] d;
        public final /* synthetic */ NiuNiu ALLATORIxDEMO;
        public /* synthetic */ int[] a;

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

        public /* synthetic */ Poke(NiuNiu a2) {
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
            arrstring[0] = PlayersHandler.ALLATORIxDEMO("\u7d2f\u5fc5");
            arrstring[1] = CommandExecute.ALLATORIxDEMO("\u9ea0\u6816");
            arrstring[2] = PlayersHandler.ALLATORIxDEMO("\u6593\u584c");
            arrstring[3] = CommandExecute.ALLATORIxDEMO("\u68f4\u82e4");
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
    }

    public class MathTest {
        public /* synthetic */ List<Card[]> Collections;

        public /* synthetic */ void combinationSelect(Card[] a2, int a3) {
            MathTest a4;
            a4.ALLATORIxDEMO(a2, 0, new Card[a3], 0);
        }

        public /* synthetic */ long combination(int a2, int a3) {
            if (a2 >= a3) {
                MathTest a4;
                return a4.factorial(a2) / a4.factorial(a2 - a3) / a4.factorial(a3);
            }
            return 0L;
        }

        public /* synthetic */ MathTest() {
            MathTest a3;
            MathTest mathTest = a3;
            mathTest.Collections = new LinkedList<Card[]>();
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

        public /* synthetic */ List<Card[]> getarrangement(Card[] a2) {
            MathTest a3;
            MathTest mathTest = a3;
            mathTest.Collections.clear();
            mathTest.combinationSelect(a2, 3);
            return mathTest.Collections;
        }

        public /* synthetic */ long arrangement(int a2, int a3) {
            if (a2 >= a3) {
                MathTest a4;
                return a4.factorial(a2) / a4.factorial(a2 - a3);
            }
            return 0L;
        }

        public /* synthetic */ long factorial(int a2) {
            if (a2 > 1) {
                MathTest a3;
                return (long)a2 * a3.factorial(a2 - 1);
            }
            return 1L;
        }
    }
}

