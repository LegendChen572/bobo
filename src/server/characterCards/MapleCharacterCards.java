/*
 * Decompiled with CFR 0.150.
 */
package server.characterCards;

import client.MapleCharacter;
import client.MapleClient;
import constants.SkillConstants;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.characterCards.CardData;
import server.characterCards.CharacterCardFactory;
import tools.Pair;
import tools.Triple;
import tools.data.MaplePacketLittleEndianWriter;

public class MapleCharacterCards {
    private /* synthetic */ Map<Integer, CardData> d;
    private final /* synthetic */ List<Pair<Integer, Integer>> ALLATORIxDEMO;

    public final /* synthetic */ Map<Integer, CardData> getCards() {
        MapleCharacterCards a2;
        return a2.d;
    }

    public final /* synthetic */ void setCards(Map<Integer, CardData> a2) {
        a.d = a2;
    }

    public /* synthetic */ MapleCharacterCards() {
        MapleCharacterCards a2;
        MapleCharacterCards mapleCharacterCards = a2;
        a2.d = new LinkedHashMap<Integer, CardData>();
        mapleCharacterCards.ALLATORIxDEMO = new LinkedList<Pair<Integer, Integer>>();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 2 << 1;
        int cfr_ignored_0 = 5 << 4 ^ (3 ^ 5) << 1;
        int n5 = n3;
        int n6 = 1 << 3 ^ 4;
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

    public final /* synthetic */ void connectData(MaplePacketLittleEndianWriter a2) {
        Iterator<CardData> iterator;
        MapleCharacterCards a3;
        if (a3.d.isEmpty()) {
            a2.writeZeroBytes(54);
            return;
        }
        int n2 = 0;
        Iterator<CardData> iterator2 = iterator = a3.d.values().iterator();
        while (iterator2.hasNext()) {
            CardData cardData = iterator.next();
            if (++n2 > 6) {
                return;
            }
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            CardData cardData2 = cardData;
            a2.writeInt(cardData.chrId);
            maplePacketLittleEndianWriter.write(cardData2.level);
            maplePacketLittleEndianWriter.writeInt(cardData2.job);
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ void loadCards(MapleClient a2, boolean a3) throws SQLException {
        a4.d = CharacterCardFactory.getInstance().loadCharacterCards(a2.getAccID(), a2.getWorld());
        if (a3) {
            MapleCharacterCards a4;
            a4.calculateEffects();
        }
    }

    public /* synthetic */ void calculateEffects() {
        Iterator<Integer> iterator;
        MapleCharacterCards a2;
        MapleCharacterCards mapleCharacterCards = a2;
        mapleCharacterCards.ALLATORIxDEMO.clear();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList3 = new LinkedList<Integer>();
        CharacterCardFactory characterCardFactory = CharacterCardFactory.getInstance();
        List<Integer> list = mapleCharacterCards.d.entrySet().iterator();
        block0: while (true) {
            List<Integer> list2 = list;
            while (list2.hasNext()) {
                iterator = list.next();
                if (iterator.getValue().chrId <= 0) continue block0;
                Triple<Integer, Integer, Integer> triple = characterCardFactory.getCardSkill(iterator.getValue().job, iterator.getValue().level);
                if ((Integer)iterator.getKey() < 4) {
                    if (triple != null) {
                        linkedList.add(triple.getLeft());
                        a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(triple.getMid(), triple.getRight()));
                    }
                    ++n2;
                    if (s2 != 0 && s2 <= ((CardData)iterator.getValue()).level) {
                        list2 = list;
                        continue;
                    }
                    s2 = ((CardData)iterator.getValue()).level;
                    continue block0;
                }
                if ((Integer)iterator.getKey() > 3 && (Integer)iterator.getKey() < 7) {
                    if (triple != null) {
                        linkedList2.add(triple.getLeft());
                        a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(triple.getMid(), triple.getRight()));
                    }
                    ++n3;
                    if (s3 != 0 && s3 <= ((CardData)iterator.getValue()).level) {
                        list2 = list;
                        continue;
                    }
                    s3 = ((CardData)iterator.getValue()).level;
                    continue block0;
                }
                if (triple != null) {
                    linkedList3.add(triple.getLeft());
                    a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(triple.getMid(), triple.getRight()));
                }
                ++n4;
                if (s4 != 0 && s4 <= ((CardData)iterator.getValue()).level) {
                    list2 = list;
                    continue;
                }
                s4 = ((CardData)iterator.getValue()).level;
                continue block0;
            }
            break;
        }
        if (n2 == 3 && linkedList.size() == 3) {
            list = characterCardFactory.getUniqueSkills(linkedList);
            iterator = list.iterator();
            Iterator<Integer> iterator2 = iterator;
            while (iterator2.hasNext()) {
                int n5 = iterator.next();
                iterator2 = iterator;
                a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(n5, SkillConstants.getCardSkillLevel(s2)));
            }
            a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(characterCardFactory.getRankSkill(s2), 1));
        }
        if (n3 == 3 && linkedList2.size() == 3) {
            list = characterCardFactory.getUniqueSkills(linkedList2);
            Iterator<Integer> iterator3 = iterator = list.iterator();
            while (iterator3.hasNext()) {
                int n6 = iterator.next();
                iterator3 = iterator;
                a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(n6, SkillConstants.getCardSkillLevel(s3)));
            }
            a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(characterCardFactory.getRankSkill(s3), 1));
        }
        if (n4 == 3 && linkedList3.size() == 3) {
            list = characterCardFactory.getUniqueSkills(linkedList3);
            iterator = list.iterator();
            Iterator<Integer> iterator4 = iterator;
            while (iterator4.hasNext()) {
                int n7 = iterator.next();
                iterator4 = iterator;
                a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(n7, SkillConstants.getCardSkillLevel(s4)));
            }
            a2.ALLATORIxDEMO.add(new Pair<Integer, Integer>(characterCardFactory.getRankSkill(s4), 1));
        }
    }

    public final /* synthetic */ List<Pair<Integer, Integer>> getCardEffects() {
        MapleCharacterCards a2;
        return a2.ALLATORIxDEMO;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void recalcLocalStats(MapleCharacter a) {
        block3: {
            var2_2 = -1;
            for (Map.Entry<Integer, CardData> var4_4 : a.d.entrySet()) {
                if (var4_4.getValue().chrId != a.getId()) continue;
                v0 = var2_2 = var4_4.getKey().intValue();
                break block3;
            }
            v0 = var2_2;
        }
        if (v0 == -1) ** GOTO lbl17
        v1 = a;
        if (!CharacterCardFactory.getInstance().canHaveCard(a.getLevel(), a.getJob())) {
            v1.d.remove(var2_2);
            v2 = a;
        } else {
            v1.d.put(var2_2, new CardData(a.getId(), a.getLevel(), a.getJob()));
lbl17:
            // 2 sources

            v2 = a;
        }
        v2.calculateEffects();
    }
}

