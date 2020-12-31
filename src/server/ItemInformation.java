/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.inventory.Equip;
import client.inventory.EquipAdditions;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import server.StructRewardItem;
import tools.Pair;

public class ItemInformation {
    public /* synthetic */ int totalprob;
    public /* synthetic */ int npc;
    public /* synthetic */ int option1;
    public /* synthetic */ String script;
    public /* synthetic */ String replaceMsg;
    public /* synthetic */ List<StructRewardItem> rewardItems;
    public /* synthetic */ String desc;
    public /* synthetic */ String name;
    public /* synthetic */ int option2;
    public /* synthetic */ int stateChange;
    public /* synthetic */ int flag;
    public /* synthetic */ Equip eq;
    public /* synthetic */ int option3;
    public /* synthetic */ byte karmaEnabled;
    public /* synthetic */ int questId;
    public /* synthetic */ EnumMap<EquipAdditions, Pair<Integer, Integer>> equipAdditions;
    public /* synthetic */ String msg;
    public /* synthetic */ String afterImage;
    public /* synthetic */ int itemId;
    public /* synthetic */ int meso;
    public /* synthetic */ short slotMax;
    public /* synthetic */ Map<Integer, Map<String, Integer>> equipIncs;
    public /* synthetic */ List<Integer> questItems;
    public /* synthetic */ int create;
    public /* synthetic */ int monsterBook;
    public /* synthetic */ int mob;
    public /* synthetic */ short itemMakeLevel;
    public /* synthetic */ List<Integer> scrollReqs;
    public /* synthetic */ Map<String, Integer> equipStats;
    public /* synthetic */ List<Integer> incSkill;
    public /* synthetic */ double price;
    public /* synthetic */ int cardSet;
    public /* synthetic */ int wholePrice;
    public /* synthetic */ int replaceItem;

    public /* synthetic */ ItemInformation() {
        ItemInformation a2;
        ItemInformation itemInformation = a2;
        ItemInformation itemInformation2 = a2;
        ItemInformation itemInformation3 = a2;
        ItemInformation itemInformation4 = a2;
        itemInformation4.scrollReqs = null;
        itemInformation4.questItems = null;
        itemInformation3.incSkill = null;
        itemInformation3.eq = null;
        itemInformation2.price = 0.0;
        itemInformation2.rewardItems = null;
        itemInformation.equipAdditions = null;
        itemInformation.equipIncs = null;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 4 << 4 ^ 3;
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
}

