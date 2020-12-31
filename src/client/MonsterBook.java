/*
 * Decompiled with CFR 0.150.
 */
package client;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleStat;
import constants.GameConstants;
import constants.GameSetConstants;
import handling.channel.handler.HiredMerchantHandler;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import server.MapleItemInformationProvider;
import server.StructRewardItem;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.MonsterBookPacket;

public class MonsterBook
implements Serializable {
    private /* synthetic */ int d;
    private static final /* synthetic */ long B = 7179541993413738569L;
    private final /* synthetic */ Map<Integer, Integer> ALLATORIxDEMO;
    private /* synthetic */ int K;
    private /* synthetic */ int a;
    private /* synthetic */ boolean k;

    public /* synthetic */ MonsterBook(Map<Integer, Integer> a2) {
        MonsterBook a3;
        MonsterBook monsterBook = a3;
        MonsterBook monsterBook2 = a3;
        monsterBook2.k = false;
        monsterBook2.K = 0;
        monsterBook.a = 0;
        monsterBook.d = 1;
        a3.ALLATORIxDEMO = a2;
        for (Map.Entry entry : a3.ALLATORIxDEMO.entrySet()) {
            if (GameConstants.isSpecialCard((Integer)entry.getKey())) {
                a3.K += ((Integer)entry.getValue()).intValue();
                continue;
            }
            a3.a += ((Integer)entry.getValue()).intValue();
        }
        a3.ALLATORIxDEMO();
    }

    public final /* synthetic */ void saveCards(int a2, Connection a3) throws SQLException {
        MonsterBook a4;
        if (!a4.k || a4.ALLATORIxDEMO.isEmpty()) {
            return;
        }
        PreparedStatement preparedStatement = a3.prepareStatement(StructRewardItem.ALLATORIxDEMO("rOzObO\u0016LdE{*[eXyBoDhYe]*aBsXs*UbWx_n\u00167\u00165"));
        preparedStatement.setInt(1, a2);
        preparedStatement.execute();
        preparedStatement.close();
        boolean bl = true;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<Integer, Integer>> iterator = a4.ALLATORIxDEMO.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            StringBuilder stringBuilder2;
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (bl) {
                bl = false;
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2 = stringBuilder3;
                stringBuilder3.append(HiredMerchantHandler.ALLATORIxDEMO("=@'K&ZTG:Z;.\u0019a\u001a}\u0000k\u0006l\u001ba\u001f.\"O8[1]T&0K2O!B \""));
            } else {
                StringBuilder stringBuilder4 = stringBuilder;
                stringBuilder2 = stringBuilder4;
                stringBuilder4.append(StructRewardItem.ALLATORIxDEMO("\u001a\"rOpKcFb&"));
            }
            stringBuilder2.append(a2);
            stringBuilder.append(HiredMerchantHandler.ALLATORIxDEMO("\""));
            stringBuilder.append(entry.getKey());
            stringBuilder.append(StructRewardItem.ALLATORIxDEMO("&"));
            stringBuilder.append(entry.getValue());
            stringBuilder.append(HiredMerchantHandler.ALLATORIxDEMO("'"));
            iterator2 = iterator;
        }
        preparedStatement = a3.prepareStatement(stringBuilder.toString());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public final /* synthetic */ void addCardPacket(MaplePacketLittleEndianWriter a2) {
        Iterator<Map.Entry<Integer, Integer>> iterator;
        MonsterBook a3;
        MonsterBook monsterBook = a3;
        a2.writeShort(monsterBook.ALLATORIxDEMO.size());
        Iterator<Map.Entry<Integer, Integer>> iterator2 = iterator = monsterBook.ALLATORIxDEMO.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            a2.writeShort(GameConstants.getCardShortId(entry.getKey()));
            a2.write(entry.getValue());
            iterator2 = iterator;
        }
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ MonsterBook loadCards(int a) throws SQLException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 4[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public final /* synthetic */ int getLevelByCard(int a2) {
        MonsterBook a3;
        if (a3.ALLATORIxDEMO.get(a2) == null) {
            return 0;
        }
        return a3.ALLATORIxDEMO.get(a2);
    }

    public final /* synthetic */ void addCard(MapleClient a2, int a3) {
        MonsterBook monsterBook;
        MonsterBook a4;
        a4.k = true;
        a2.getPlayer().getMap().broadcastMessage(a2.getPlayer(), MonsterBookPacket.showForeginCardEffect(a2.getPlayer().getId()), false);
        if (a4.ALLATORIxDEMO.containsKey(a3)) {
            MonsterBook monsterBook2;
            int n2 = a4.ALLATORIxDEMO.get(a3);
            if (n2 >= 5) {
                a2.sendPacket(MonsterBookPacket.addCard(true, a3, n2));
                return;
            }
            if (GameConstants.isSpecialCard(a3)) {
                MonsterBook monsterBook3 = a4;
                monsterBook2 = monsterBook3;
                ++monsterBook3.K;
            } else {
                MonsterBook monsterBook4 = a4;
                monsterBook2 = monsterBook4;
                ++monsterBook4.a;
            }
            monsterBook2.ALLATORIxDEMO.put(a3, n2 + 1);
            MapleClient mapleClient = a2;
            mapleClient.sendPacket(MonsterBookPacket.addCard(false, a3, n2 + 1));
            mapleClient.sendPacket(MonsterBookPacket.showGainCard(a3));
            mapleClient.sendPacket(MonsterBookPacket.showCardEffect());
            if (GameSetConstants.SERVER_NAME.equals(StructRewardItem.ALLATORIxDEMO("\u98d1\u98ed\u8c3d"))) {
                a4.handleMonsterCard(a2.getPlayer(), a3, n2 + 1);
            }
            a4.ALLATORIxDEMO();
            return;
        }
        MonsterBook monsterBook5 = a4;
        if (GameConstants.isSpecialCard(a3)) {
            ++monsterBook5.K;
            monsterBook = a4;
        } else {
            ++monsterBook5.a;
            monsterBook = a4;
        }
        monsterBook.ALLATORIxDEMO.put(a3, 1);
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MonsterBookPacket.addCard(false, a3, 1));
        mapleClient.sendPacket(MonsterBookPacket.showGainCard(a3));
        mapleClient.sendPacket(MonsterBookPacket.showCardEffect());
        a4.ALLATORIxDEMO();
    }

    public final /* synthetic */ boolean monsterCaught(MapleClient a2, int a3, String a4) {
        MonsterBook a5;
        if (!a5.ALLATORIxDEMO.containsKey(a3) || a5.ALLATORIxDEMO.get(a3) < 2) {
            a5.k = true;
            a2.sendPacket(MaplePacketCreator.showSpecialEffect(16));
            a5.ALLATORIxDEMO.put(a3, 2);
            return true;
        }
        return false;
    }

    public final /* synthetic */ void addCharInfoPacket(int a2, MaplePacketLittleEndianWriter a3) {
        MonsterBook a4;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3;
        MonsterBook monsterBook = a4;
        a3.writeInt(a4.d);
        a3.writeInt(monsterBook.a);
        maplePacketLittleEndianWriter.writeInt(monsterBook.K);
        maplePacketLittleEndianWriter.writeInt(a4.a + a4.K);
        maplePacketLittleEndianWriter.writeInt(MapleItemInformationProvider.getInstance().getCardMobId(a2));
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void handleMonsterCard(MapleCharacter a2, int a3, int a4) {
        ArrayList<Pair<MapleStat, Integer>> arrayList;
        int n2;
        ArrayList<Pair<MapleStat, Integer>> arrayList2 = new ArrayList<Pair<MapleStat, Integer>>();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        n5 = 0;
        n5 = 0;
        n5 = 0;
        n5 = 0;
        n5 = 0;
        n5 = 0;
        n5 = 0;
        n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        switch (a3) {
            case 2380000: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2380001: {
                n4 = 15;
                n2 = a4;
                break;
            }
            case 2380004: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2380005: {
                n3 = 15;
                n2 = a4;
                break;
            }
            case 2381075: {
                n3 = 50;
                n2 = a4;
                break;
            }
            case 2381004: {
                n3 = 50;
                n2 = a4;
                break;
            }
            case 2381005: {
                n3 = 50;
                n2 = a4;
                break;
            }
            case 2381044: {
                n3 = 35;
                n2 = a4;
                break;
            }
            case 2381045: {
                n3 = 35;
                n2 = a4;
                break;
            }
            case 2381046: {
                n3 = 40;
                n2 = a4;
                break;
            }
            case 2382080: {
                n3 = 45;
                n2 = a4;
                break;
            }
            case 2381047: {
                n3 = 45;
                n2 = a4;
                break;
            }
            case 2381034: {
                n3 = 30;
                n2 = a4;
                break;
            }
            case 2382004: {
                n3 = 35;
                n2 = a4;
                break;
            }
            case 2381074: {
                n3 = 35;
                n2 = a4;
                break;
            }
            case 2381076: {
                n3 = 45;
                n2 = a4;
                break;
            }
            case 2382001: {
                n3 = 30;
                n2 = a4;
                break;
            }
            case 2382002: {
                n3 = 30;
                n2 = a4;
                break;
            }
            case 2383019: {
                n3 = 40;
                n2 = a4;
                break;
            }
            case 2382029: {
                n3 = 35;
                n2 = a4;
                break;
            }
            case 2382040: {
                n3 = 40;
                n2 = a4;
                break;
            }
            case 2382083: {
                n3 = 30;
                n2 = a4;
                break;
            }
            case 2382084: {
                n3 = 30;
                n2 = a4;
                break;
            }
            case 2382085: {
                n3 = 30;
                n2 = a4;
                break;
            }
            case 2380002: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2380007: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2380013: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2380011: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2381002: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2381007: {
                n4 = 12;
                n2 = a4;
                break;
            }
            case 2381016: {
                n4 = 12;
                n2 = a4;
                break;
            }
            case 2381037: {
                n4 = 12;
                n2 = a4;
                break;
            }
            case 2382020: {
                n4 = 15;
                n2 = a4;
                break;
            }
            case 2382064: {
                n4 = 15;
                n2 = a4;
                break;
            }
            case 2383020: {
                n4 = 15;
                n2 = a4;
                break;
            }
            case 2384048: {
                n4 = 20;
                n2 = a4;
                break;
            }
            case 2380003: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2381009: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2381000: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2381001: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2380010: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2381012: {
                n3 = 12;
                n2 = a4;
                break;
            }
            case 2381032: {
                n3 = 12;
                n2 = a4;
                break;
            }
            case 2384050: {
                n3 = 20;
                n2 = a4;
                break;
            }
            case 2380006: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2380009: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2381006: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2381022: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2383034: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2382005: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2382016: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2381003: {
                n3 = 50;
                n2 = a4;
                break;
            }
            case 2381039: {
                n3 = 50;
                n2 = a4;
                break;
            }
            case 2382011: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2382012: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2382013: {
                n3 = 10;
                n2 = a4;
                break;
            }
            case 2383021: {
                n3 = 20;
                n2 = a4;
                break;
            }
            case 2383022: {
                n3 = 20;
                n2 = a4;
                break;
            }
            case 2383023: {
                n3 = 20;
                n2 = a4;
                break;
            }
            case 2382023: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2382019: {
                n4 = 10;
                n2 = a4;
                break;
            }
            case 2383008: {
                n4 = 15;
                n2 = a4;
                break;
            }
            case 2382014: {
                n3 = 15;
                n2 = a4;
                break;
            }
            case 2382006: {
                n3 = 15;
                n2 = a4;
                break;
            }
            case 2382068: {
                n3 = 15;
                n2 = a4;
                break;
            }
            case 2381024: {
                n5 = 1;
                n2 = a4;
                break;
            }
            case 2382003: {
                n5 = 1;
                n2 = a4;
                break;
            }
            case 2382053: {
                n5 = 1;
                n2 = a4;
                break;
            }
            case 2382021: {
                n7 = 1;
                n2 = a4;
                break;
            }
            case 2382038: {
                n7 = 1;
                n2 = a4;
                break;
            }
            case 2383037: {
                n7 = 1;
                n2 = a4;
                break;
            }
            case 2382018: {
                n6 = 1;
                n2 = a4;
                break;
            }
            case 2381033: {
                n6 = 1;
                n2 = a4;
                break;
            }
            case 2382032: {
                n6 = 1;
                n2 = a4;
                break;
            }
            case 2382049: {
                n8 = 1;
                n2 = a4;
                break;
            }
            case 2383011: {
                n8 = 1;
                n2 = a4;
                break;
            }
            case 2383038: {
                n8 = 1;
                n2 = a4;
                break;
            }
            case 2388000: {
                n5 = 2;
                n2 = a4;
                break;
            }
            case 2388003: {
                n5 = 2;
                n2 = a4;
                break;
            }
            case 2388010: {
                n5 = 2;
                n2 = a4;
                break;
            }
            case 2388007: {
                n5 = 2;
                n2 = a4;
                break;
            }
            case 2388001: {
                n7 = 2;
                n2 = a4;
                break;
            }
            case 2388006: {
                n7 = 2;
                n2 = a4;
                break;
            }
            case 2388034: {
                n7 = 2;
                n2 = a4;
                break;
            }
            case 2388008: {
                n7 = 2;
                n2 = a4;
                break;
            }
            case 2388002: {
                n6 = 2;
                n2 = a4;
                break;
            }
            case 2388009: {
                n6 = 2;
                n2 = a4;
                break;
            }
            case 2388025: {
                n6 = 2;
                n2 = a4;
                break;
            }
            case 2388030: {
                n6 = 2;
                n2 = a4;
                break;
            }
            case 2388005: {
                n8 = 2;
                n2 = a4;
                break;
            }
            case 2388013: {
                n8 = 2;
                n2 = a4;
                break;
            }
            case 2388029: {
                n8 = 2;
                n2 = a4;
                break;
            }
            case 2388015: {
                n8 = 2;
                n2 = a4;
                break;
            }
            case 2388016: 
            case 2388026: {
                n5 = 2;
                n7 = 2;
                n6 = 2;
                n8 = 2;
                n2 = a4;
                break;
            }
            case 2388020: 
            case 2388035: 
            case 2388036: 
            case 2388047: {
                n5 = 3;
                n7 = 3;
                n6 = 3;
                n8 = 3;
                n2 = a4;
                break;
            }
            case 2388018: 
            case 2388019: 
            case 2388022: {
                n5 = 4;
                n7 = 4;
                n6 = 4;
                n8 = 4;
                n2 = a4;
                break;
            }
            case 2388017: 
            case 2388023: 
            case 2388038: {
                n5 = 5;
                n7 = 5;
                n6 = 5;
                n8 = 5;
                n2 = a4;
                break;
            }
            case 2388024: {
                n5 = 8;
                n7 = 8;
                n6 = 8;
                n8 = 8;
                n2 = a4;
                break;
            }
            case 2388021: 
            case 2388037: 
            case 2388043: {
                n5 = 10;
                n7 = 10;
                n6 = 10;
                n8 = 10;
            }
            default: {
                n2 = a4;
            }
        }
        if (n2 == 5) {
            int n9;
            StringBuilder stringBuilder = new StringBuilder();
            if (n5 > 0) {
                MapleCharacter mapleCharacter = a2;
                n9 = mapleCharacter.getStr() + n5;
                mapleCharacter.setStr(n9);
                arrayList2.add(new Pair<MapleStat, Integer>(MapleStat.STR, n9));
                stringBuilder.append(" \u529b\u91cf + " + n5);
            }
            if (n7 > 0) {
                MapleCharacter mapleCharacter = a2;
                n9 = mapleCharacter.getDex() + n7;
                mapleCharacter.setDex(n9);
                arrayList2.add(new Pair<MapleStat, Integer>(MapleStat.DEX, n9));
                stringBuilder.append(" \u654f\u6377 + " + n7);
            }
            if (n6 > 0) {
                MapleCharacter mapleCharacter = a2;
                n9 = mapleCharacter.getInt() + n6;
                mapleCharacter.setInt(n9);
                arrayList2.add(new Pair<MapleStat, Integer>(MapleStat.INT, n9));
                stringBuilder.append(" \u667a\u529b + " + n6);
            }
            if (n8 > 0) {
                MapleCharacter mapleCharacter = a2;
                n9 = mapleCharacter.getLuk() + n8;
                mapleCharacter.setLuk(n9);
                arrayList2.add(new Pair<MapleStat, Integer>(MapleStat.LUK, n9));
                stringBuilder.append(" \u5e78\u904b + " + n8);
            }
            if (n4 > 0) {
                MapleCharacter mapleCharacter = a2;
                n9 = mapleCharacter.getMaxMp() + n4;
                mapleCharacter.setMaxMp(n9);
                arrayList2.add(new Pair<MapleStat, Integer>(MapleStat.MP, n9));
                stringBuilder.append(" \u9b54\u529b + " + n4);
            }
            if (n3 > 0) {
                MapleCharacter mapleCharacter = a2;
                n9 = mapleCharacter.getMaxHp() + n3;
                mapleCharacter.setMaxHp(n9);
                arrayList2.add(new Pair<MapleStat, Integer>(MapleStat.HP, n9));
                stringBuilder.append(" \u8840\u91cf + " + n3);
            }
            a2.dropMessage("\u606d\u559c\u60a8\u8490\u96c6\u6eff\u4e94\u5f35 " + MapleItemInformationProvider.getInstance().getName(a3) + " !" + stringBuilder.toString());
            arrayList = arrayList2;
        } else {
            if (a4 < 5) {
                a2.dropMessage("\u606d\u559c\u60a8\u8490\u96c6\u6eff" + a4 + "\u5f35 " + MapleItemInformationProvider.getInstance().getName(a3) + " !\u8490\u96c6\u6eff5\u5f35,\u53ef\u984d\u5916\u52a0\u80fd\u529b!");
            }
            arrayList = arrayList2;
        }
        if (!arrayList.isEmpty()) {
            a2.getClient().sendPacket(MaplePacketCreator.updatePlayerStats(arrayList2, true, a2));
        }
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        int n2;
        MonsterBook a2;
        int n3 = a2.a + a2.K;
        a2.d = 8;
        int n4 = n2 = 0;
        while (n4 < 8) {
            if (n3 <= GameConstants.getBookLevel(n2)) {
                a2.d = n2 + 1;
                return;
            }
            n4 = ++n2;
        }
    }

    public final /* synthetic */ void updateCard(MapleClient a2, int a3) {
        a2.sendPacket(MonsterBookPacket.changeCover(a3));
    }

    public final /* synthetic */ int getTotalCards() {
        MonsterBook a2;
        MonsterBook monsterBook = a2;
        return monsterBook.K + monsterBook.a;
    }

    public /* synthetic */ Map<Integer, Integer> getCards() {
        MonsterBook a2;
        return a2.ALLATORIxDEMO;
    }
}

