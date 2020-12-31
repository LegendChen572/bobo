/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package server;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleTrait;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.EquipAdditions;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleWeaponType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import database.DBConPool;
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import provider.MapleData;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataFileEntry;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.ItemInformation;
import server.MapleStatEffect;
import server.Randomizer;
import server.ScriptedItem;
import server.StructAndroid;
import server.StructFamiliar;
import server.StructPotentialItem;
import server.StructRewardItem;
import server.StructSetItem;
import server.life.MonsterDropEntry;
import server.maps.MapNameData;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.StringTool;
import tools.Triple;

public class MapleItemInformationProvider {
    public final /* synthetic */ MapleDataProvider stringData;
    public final /* synthetic */ Map<Integer, Triple<Integer, List<Integer>, List<Integer>>> monsterBookSets;
    public final /* synthetic */ Map<Integer, List<Pair<Integer, Integer>>> summonMobCache;
    public final /* synthetic */ Map<Integer, StructFamiliar> familiars_Mob;
    public final /* synthetic */ Map<Integer, MapleStatEffect> itemEffectsEx;
    public final /* synthetic */ Map<Integer, Map<String, Byte>> itemMakeStatsCache;
    public final /* synthetic */ List<Pair<Integer, String>> itemNameCache;
    public final /* synthetic */ Map<Integer, StructSetItem> setItems;
    public final /* synthetic */ Map<Integer, Byte> consumeOnPickupCache;
    private static final /* synthetic */ MapleItemInformationProvider d;
    public final /* synthetic */ Map<Integer, List<Integer>> petsCanConsumeCache;
    public final /* synthetic */ Map<Integer, Map<String, Integer>> SkillStatsCache;
    public /* synthetic */ Map<Integer, Integer> forceUpgrade;
    public final /* synthetic */ Map<Integer, List<Integer>> chairRandEffect;
    public final /* synthetic */ MapleDataProvider itemData;
    public final /* synthetic */ MapleDataProvider etcData;
    public /* synthetic */ Map<Integer, Boolean> noCursedScroll;
    public /* synthetic */ Map<Integer, Pair<Integer, Integer>> chairRecovery;
    public final /* synthetic */ Map<Integer, Map<Integer, StructPotentialItem>> potentialCache;
    public /* synthetic */ Map<Integer, Boolean> onOnlyCache;
    public final /* synthetic */ Map<Integer, Equip> equipCache;
    public /* synthetic */ Map<Integer, Boolean> onEquipOnlyCache;
    private /* synthetic */ ItemInformation ALLATORIxDEMO;
    public final /* synthetic */ Map<Integer, StructFamiliar> familiars;
    public /* synthetic */ Map<Integer, Boolean> noNegativeScroll;
    public final /* synthetic */ Map<Integer, MapNameData> MapDataCache;
    public final /* synthetic */ Map<Integer, Integer> mobIds;
    public final /* synthetic */ Map<Integer, Short> petFlagInfo;
    public /* synthetic */ Map<Integer, Boolean> onEquipUntradableCache;
    public final /* synthetic */ Map<Integer, Integer> petLimitLifeInfo;
    public final /* synthetic */ List<Equip> allEquips;
    public final /* synthetic */ Map<Integer, String> nameCache;
    public final /* synthetic */ MapleDataProvider equipData;
    public final /* synthetic */ Map<Integer, Triple<Integer, Integer, List<Integer>>> questItems;
    public /* synthetic */ Map<Integer, Integer> successRates;
    public /* synthetic */ Map<Integer, ScriptedItem> scriptedItemCache;
    public final /* synthetic */ Map<Integer, StructFamiliar> familiars_Item;
    public final /* synthetic */ Map<String, List<Triple<String, Point, Point>>> afterImage;
    public final /* synthetic */ Map<Integer, StructAndroid> androidInfo;
    public final /* synthetic */ Map<Integer, Pair<Integer, Integer>> potLife;
    public final /* synthetic */ Map<Integer, Integer> petLifeInfo;
    public /* synthetic */ Map<Integer, Integer> androidType;
    public final /* synthetic */ Map<Integer, MapleStatEffect> itemEffects;
    public final /* synthetic */ Map<Integer, ItemInformation> dataCache;
    public final /* synthetic */ Map<Integer, int[]> expPotionLevel;

    public final /* synthetic */ Pair<Integer, List<StructRewardItem>> getRewardItem(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return new Pair<Integer, List<StructRewardItem>>(a22.totalprob, a22.rewardItems);
    }

    public final /* synthetic */ int getWatkForProjectile(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null || a22.equipStats == null || a22.equipStats.get(MonsterDropEntry.ALLATORIxDEMO("VY\\g~s")) == null) {
            return 0;
        }
        return a22.equipStats.get(MapNameData.ALLATORIxDEMO("y+s\u0015Q\u0001"));
    }

    public final /* synthetic */ int getReqInt(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRN~qc"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\f^\u0011"));
    }

    public final /* synthetic */ String getName(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.name;
    }

    public final /* synthetic */ Equip fuse(Equip a2, Equip a3) {
        MapleItemInformationProvider a4;
        Equip equip;
        if (a2.getItemId() != a3.getItemId()) {
            return a2;
        }
        Equip equip2 = equip = (Equip)a4.getEquipById(a2.getItemId());
        Equip equip3 = equip;
        Equip equip4 = equip;
        MapleItemInformationProvider mapleItemInformationProvider = a4;
        Equip equip5 = equip;
        Equip equip6 = equip;
        Equip equip7 = equip;
        MapleItemInformationProvider mapleItemInformationProvider2 = a4;
        Equip equip8 = equip;
        Equip equip9 = equip;
        Equip equip10 = equip;
        MapleItemInformationProvider mapleItemInformationProvider3 = a4;
        Equip equip11 = equip;
        Equip equip12 = equip;
        equip12.setStr(a4.getRandStatFusion(equip.getStr(), a2.getStr(), a3.getStr()));
        equip12.setDex(a4.getRandStatFusion(equip12.getDex(), a2.getDex(), a3.getDex()));
        equip11.setInt(a4.getRandStatFusion(equip11.getInt(), a2.getInt(), a3.getInt()));
        equip10.setLuk(mapleItemInformationProvider3.getRandStatFusion(equip11.getLuk(), a2.getLuk(), a3.getLuk()));
        equip9.setMatk(mapleItemInformationProvider3.getRandStatFusion(equip10.getMatk(), a2.getMatk(), a3.getMatk()));
        equip9.setWatk(a4.getRandStatFusion(equip9.getWatk(), a2.getWatk(), a3.getWatk()));
        equip8.setAcc(a4.getRandStatFusion(equip8.getAcc(), a2.getAcc(), a3.getAcc()));
        equip7.setAvoid(mapleItemInformationProvider2.getRandStatFusion(equip8.getAvoid(), a2.getAvoid(), a3.getAvoid()));
        equip6.setJump(mapleItemInformationProvider2.getRandStatFusion(equip7.getJump(), a2.getJump(), a3.getJump()));
        equip6.setHands(a4.getRandStatFusion(equip6.getHands(), a2.getHands(), a3.getHands()));
        equip5.setSpeed(a4.getRandStatFusion(equip5.getSpeed(), a2.getSpeed(), a3.getSpeed()));
        equip4.setWdef(mapleItemInformationProvider.getRandStatFusion(equip5.getWdef(), a2.getWdef(), a3.getWdef()));
        equip3.setMdef(mapleItemInformationProvider.getRandStatFusion(equip4.getMdef(), a2.getMdef(), a3.getMdef()));
        equip3.setHp(a4.getRandStatFusion(equip3.getHp(), a2.getHp(), a3.getHp()));
        equip2.setMp(a4.getRandStatFusion(equip2.getMp(), a2.getMp(), a3.getMp()));
        return equip2;
    }

    public final /* synthetic */ int getStateChangeItem(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        return a22.stateChange;
    }

    public /* synthetic */ void PrintSpecialCash() {
        boolean bl;
        StringBuilder stringBuilder;
        PrintWriter printWriter;
        try {
            MapleItemInformationProvider a2;
            File file = new File(MonsterDropEntry.ALLATORIxDEMO("\u80c2\u52ac\u9ee1\u88ea\u0011CGC"));
            file.createNewFile();
            printWriter = new PrintWriter(new FileOutputStream(file));
            Iterator<Map.Entry<Integer, ItemInformation>> iterator = a2.dataCache.entrySet().iterator();
            while (iterator.hasNext()) {
                Object object = iterator.next();
                stringBuilder = new StringBuilder();
                if (GameConstants.getInventoryType(object.getKey()) != MapleInventoryType.EQUIP || !a2.isCash(object.getKey())) continue;
                ItemInformation itemInformation = object.getValue();
                if (itemInformation.equipStats.size() <= 1) continue;
                bl = true;
                stringBuilder.append("\u9ede\u88dd\u4ee3\u78bc:" + object.getKey());
                stringBuilder.append("\u9ede\u88dd\u540d\u7a31:" + a2.getName(object.getKey()) + "  ");
                object = itemInformation.equipStats.entrySet().iterator();
                while (object.hasNext()) {
                    Map.Entry entry = (Map.Entry)object.next();
                    if (((String)entry.getKey()).equals(MapNameData.ALLATORIxDEMO("6u1Y1u(Y\u0001")) && itemInformation.equipStats.size() == 2) {
                        bl = false;
                    }
                    if (((String)entry.getKey()).equals(MonsterDropEntry.ALLATORIxDEMO("\\VL_"))) continue;
                    stringBuilder.append((String)entry.getKey() + ":" + entry.getValue() + " ");
                }
            }
        }
        catch (IOException iOException) {
            Logger.getLogger(MapleItemInformationProvider.class.getName()).log(Level.SEVERE, null, iOException);
            return;
        }
        {
            if (!bl) continue;
            printWriter.println(stringBuilder.toString());
            continue;
        }
        PrintWriter printWriter2 = printWriter;
        printWriter2.flush();
        printWriter2.close();
        System.out.println(MapNameData.ALLATORIxDEMO("\u80b8\u528b\u9e9b\u88cd\u8c82\u6589\u6395\u53c6\u5bc9\u6200k"));
    }

    public final /* synthetic */ Map<Integer, StructPotentialItem> getPotentialInfo(int a2) {
        MapleItemInformationProvider a3;
        return a3.potentialCache.get(a2);
    }

    public final /* synthetic */ boolean canEquip(Map<String, Integer> a22, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11) {
        MapleItemInformationProvider a12;
        if (a4 + a11 >= a12.getReqLevel(a3)) {
            int n2 = a7;
            if (n2 >= a12.getReqStr(n2) && a8 >= a12.getReqDex(a3) && a9 >= a12.getReqLuk(a3) && a10 >= a12.getReqInt(a3)) {
                int a22 = a12.getReqFame(a3);
                return a22 == 0 || a6 >= a22;
            }
        }
        return false;
    }

    public final /* synthetic */ StructFamiliar getFamiliar(int a2) {
        MapleItemInformationProvider a3;
        return a3.familiars.get(a2);
    }

    public /* synthetic */ boolean isSuperiorEquip(int a22) {
        MapleItemInformationProvider a3;
        Map<String, Integer> a22 = a3.getEquipStats(a22);
        if (a22 == null) {
            return false;
        }
        return a22.containsKey(MonsterDropEntry.ALLATORIxDEMO("DJGZEVXMrNG")) && a22.get(MapNameData.ALLATORIxDEMO("6e5u7y*b\u0000a5")) == 1;
    }

    public /* synthetic */ HashMap<IItem, Boolean> scrollResetEquip(IItem a222, IItem a3, MapleCharacter a4) {
        int n2;
        MapleItemInformationProvider a5;
        HashMap<IItem, Boolean> hashMap = new HashMap<IItem, Boolean>();
        if (a222.getType() != 1) {
            HashMap<IItem, Boolean> hashMap2 = hashMap;
            hashMap2.put(a222, false);
            return hashMap2;
        }
        Equip equip = (Equip)a222;
        Map<String, Integer> map = a5.getEquipStats(a3.getItemId());
        int n3 = map == null || !map.containsKey(MonsterDropEntry.ALLATORIxDEMO("DJT\\RLD")) ? 0 : map.get(MapNameData.ALLATORIxDEMO("6e&s c6"));
        int n4 = map == null || !map.containsKey(MonsterDropEntry.ALLATORIxDEMO("\\BMDZS")) ? 0 : map.get(MapNameData.ALLATORIxDEMO("s0b6u!"));
        int n5 = a4.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).getLevel() / 10;
        int n6 = n2 = ItemFlag.LUCKS_KEY.check(a222.getFlag()) ? 10 : 0;
        if (ItemFlag.LUCKS_KEY.check(a222.getFlag())) {
            a222.removeFlag(ItemFlag.LUCKS_KEY.getValue());
        }
        if (a3.getItemId() == 5064200) {
            n3 = 100;
        }
        int n7 = n3;
        int a222 = n7 + n7 * (n5 + n2) / 100;
        if (a4.isAdmin()) {
            a4.dropMessage(-5, "\u9084\u539f\u5377\u8ef8 - \u9ed8\u8a8d\u5e7e\u7387: " + n3 + "% \u50be\u5411\u52a0\u6210: " + n5 + "% \u5e78\u904b\u5377\u8ef8\u72c0\u614b\u52a0\u6210: " + n2 + "% \u6700\u7d42\u5e7e\u7387: " + a222 + "% \u5931\u6557\u6d88\u5931\u5e7e\u7387: " + n4 + "%");
        }
        if (Randomizer.nextInt(100) <= a222) {
            Equip a222 = a5.resetEquipStats(equip);
            HashMap<IItem, Boolean> hashMap3 = hashMap;
            hashMap3.put(a222, true);
            return hashMap3;
        }
        if (Randomizer.nextInt(99) < n4) {
            return null;
        }
        HashMap<IItem, Boolean> hashMap4 = hashMap;
        hashMap4.put(equip, false);
        return hashMap4;
    }

    public final /* synthetic */ int getTotalStat(Equip a2) {
        return a2.getStr() + a2.getDex() + a2.getInt() + a2.getLuk() + a2.getMatk() + a2.getWatk() + a2.getAcc() + a2.getAvoid() + a2.getJump() + a2.getHands() + a2.getSpeed() + a2.getHp() + a2.getMp() + a2.getWdef() + a2.getMdef();
    }

    public static /* synthetic */ {
        d = new MapleItemInformationProvider();
    }

    public /* synthetic */ List<Integer> getMapFromNpc(int a2) {
        MapleItemInformationProvider a3;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (MapNameData mapNameData : a3.MapDataCache.values()) {
            if (!mapNameData.getNpcs().contains(a2)) continue;
            linkedList.add(mapNameData.getMapId());
        }
        return linkedList;
    }

    public /* synthetic */ void initItemInformation(ResultSet a2) throws SQLException {
        int n2;
        Object object;
        ResultSet resultSet;
        Object object2;
        Object object3;
        MapleItemInformationProvider a3;
        ItemInformation itemInformation = new ItemInformation();
        int n3 = a2.getInt(MapNameData.ALLATORIxDEMO("y1u(y!"));
        ItemInformation itemInformation2 = itemInformation;
        itemInformation2.itemId = n3;
        short s2 = GameConstants.getSlotMax(n3) > 0 ? GameConstants.getSlotMax(n3) : (itemInformation2.slotMax = a3.getModifySlotMax(n3) > 0 ? a3.getModifySlotMax(n3) : a2.getShort(MonsterDropEntry.ALLATORIxDEMO("DSXKz^O")));
        if (GameSetConstants.SERVER_NAME.equals(MapNameData.ALLATORIxDEMO("\u6943\u76c1\u6555\u4ece")) && ItemConstants.is\u6280\u80fd\u66f8(n3)) {
            itemInformation.slotMax = (short)100;
        }
        ItemInformation itemInformation3 = itemInformation;
        ResultSet resultSet2 = a2;
        ItemInformation itemInformation4 = itemInformation;
        ResultSet resultSet3 = a2;
        ItemInformation itemInformation5 = itemInformation;
        ResultSet resultSet4 = a2;
        ItemInformation itemInformation6 = itemInformation;
        ResultSet resultSet5 = a2;
        ItemInformation itemInformation7 = itemInformation;
        ResultSet resultSet6 = a2;
        ItemInformation itemInformation8 = itemInformation;
        itemInformation8.price = Double.parseDouble(a2.getString(MonsterDropEntry.ALLATORIxDEMO("GM^\\R")));
        itemInformation8.wholePrice = a2.getInt(MapNameData.ALLATORIxDEMO("g-\u007f)u\u0015b,s "));
        itemInformation.stateChange = resultSet6.getInt(MonsterDropEntry.ALLATORIxDEMO("DKVKR|_^YXR"));
        itemInformation7.name = resultSet6.getString(MapNameData.ALLATORIxDEMO("~$} "));
        itemInformation7.desc = a2.getString(MonsterDropEntry.ALLATORIxDEMO("[RLT"));
        itemInformation.msg = resultSet5.getString(MapNameData.ALLATORIxDEMO("(c\""));
        itemInformation6.flag = resultSet5.getInt(MonsterDropEntry.ALLATORIxDEMO("QSVXD"));
        itemInformation6.karmaEnabled = a2.getByte(MapNameData.ALLATORIxDEMO(".q7}$"));
        itemInformation.meso = resultSet4.getInt(MonsterDropEntry.ALLATORIxDEMO("RRLX"));
        itemInformation5.monsterBook = resultSet4.getInt(MapNameData.ALLATORIxDEMO("(\u007f+c1u7R*\u007f."));
        itemInformation5.itemMakeLevel = a2.getShort(MonsterDropEntry.ALLATORIxDEMO("^KRRz^\\Z{ZAZ["));
        itemInformation.questId = resultSet3.getInt(MapNameData.ALLATORIxDEMO("4e c1Y!"));
        itemInformation4.create = resultSet3.getInt(MonsterDropEntry.ALLATORIxDEMO("\\EZVKR"));
        itemInformation4.replaceItem = a2.getInt(MapNameData.ALLATORIxDEMO("7u5|$s Y!"));
        itemInformation.replaceMsg = resultSet2.getString(MonsterDropEntry.ALLATORIxDEMO("MRO[^TZzLP"));
        itemInformation3.afterImage = resultSet2.getString(MapNameData.ALLATORIxDEMO("q#d b\f}$w "));
        itemInformation3.cardSet = 0;
        if (itemInformation.monsterBook > 0 && n3 / 10000 == 238) {
            a3.mobIds.put(itemInformation.monsterBook, n3);
            object3 = a3.monsterBookSets.entrySet().iterator();
            while (object3.hasNext()) {
                object2 = (Map.Entry)object3.next();
                if (!((List)((Triple)object2.getValue()).mid).contains(n3)) continue;
                itemInformation.cardSet = (Integer)object2.getKey();
                resultSet = a2;
                break;
            }
        } else {
            resultSet = a2;
        }
        object3 = resultSet.getString(MonsterDropEntry.ALLATORIxDEMO("LTMXS[mRND"));
        if (((String)object3).length() > 0) {
            ItemInformation itemInformation9 = itemInformation;
            itemInformation9.scrollReqs = new ArrayList<Integer>();
            object = object2 = ((String)object3).split(MapNameData.ALLATORIxDEMO("i"));
            int n4 = ((String[])object).length;
            int n5 = n2 = 0;
            while (n5 < n4) {
                String string = object[n2];
                if (string.length() > 1) {
                    itemInformation.scrollReqs.add(Integer.parseInt(string));
                }
                n5 = ++n2;
            }
        }
        if (((String)(object2 = a2.getString(MonsterDropEntry.ALLATORIxDEMO("TPYLBRRvCZZ")))).length() > 0) {
            int n6;
            itemInformation.questItems = new ArrayList<Integer>();
            object = ((String)object3).split(MapNameData.ALLATORIxDEMO("i"));
            String[] arrstring = object;
            n2 = arrstring.length;
            int n7 = n6 = 0;
            while (n7 < n2) {
                object2 = arrstring[n6];
                if (((String)object2).length() > 1) {
                    itemInformation.questItems.add(Integer.parseInt((String)object2));
                }
                n7 = ++n6;
            }
        }
        itemInformation.totalprob = a2.getInt(MonsterDropEntry.ALLATORIxDEMO("CPC^[OEPU"));
        object = a2.getString(MapNameData.ALLATORIxDEMO("y+s\u0016{,|)"));
        if (((String)object).length() > 0) {
            int n8;
            String[] arrstring;
            itemInformation.incSkill = new ArrayList<Integer>();
            String[] arrstring2 = arrstring = ((String)object).split(MonsterDropEntry.ALLATORIxDEMO("\u001b"));
            int n9 = arrstring2.length;
            int n10 = n8 = 0;
            while (n10 < n9) {
                a2 = arrstring2[n8];
                if (((String)a2).length() > 1) {
                    itemInformation.incSkill.add(Integer.parseInt((String)a2));
                }
                n10 = ++n8;
            }
        }
        a3.dataCache.put(n3, itemInformation);
    }

    public final /* synthetic */ int getSetItemID(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("DZCvCZZvs"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("6u1Y1u(Y\u0001"));
    }

    public final /* synthetic */ Map<String, Byte> getItemMakeStats(int a2) {
        MapleItemInformationProvider a3;
        if (a3.itemMakeStatsCache.containsKey(a2)) {
            return a3.itemMakeStatsCache.get(a2);
        }
        if (a2 / 10000 != 425) {
            return null;
        }
        LinkedHashMap<String, Byte> linkedHashMap = new LinkedHashMap<String, Byte>();
        MapleData mapleData = a3.getItemData(a2);
        if (mapleData == null) {
            return null;
        }
        if ((mapleData = mapleData.getChildByPath(MonsterDropEntry.ALLATORIxDEMO("VYYX"))) == null) {
            return null;
        }
        LinkedHashMap<String, Byte> linkedHashMap2 = linkedHashMap;
        linkedHashMap2.put(MapNameData.ALLATORIxDEMO("y+s\u0015Q\u0001"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\g~s"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\bQ\u0001"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\z~s"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\u0004S\u0006"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\v|t"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\u0000F\u0004"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\riv"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\u0016` u!"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\dORZS"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO(",~&Z0}5"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("^QTuBRG"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\bq=X\u0015"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\z^Owg"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\bq=]\u0015"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\z^Org"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\u0016D\u0017"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\dke"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\f^\u0011"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\~qc"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\tE\u000e"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\{j|"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("y+s\u0001U\u001d"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("VY\\szo"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("b$~!_5d,\u007f+"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("MVQSpGK^PY"), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("b$~!C1q1"), (byte)MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("MVQSlC^C"), mapleData, 0));
        a3.itemMakeStatsCache.put(a2, linkedHashMap);
        return linkedHashMap2;
    }

    public final /* synthetic */ double getPrice(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return -1.0;
        }
        return a22.price;
    }

    public final /* synthetic */ byte isConsumeOnPickup(int a2) {
        MapleItemInformationProvider a3;
        if (a3.consumeOnPickupCache.containsKey(a2)) {
            return a3.consumeOnPickupCache.get(a2);
        }
        MapleData mapleData = a3.getItemData(a2);
        byte by = (byte)MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("LGZT\u0010TPYLBRRpYo^\\\\JG"), mapleData, 0);
        if (by == 0) {
            by = (byte)MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("c5u&U=?&\u007f+c0} _+@,s.e5"), mapleData, 0);
        }
        if (by == 1 && MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("LGZT\u0010G^EKN"), a3.getItemData(a2), 0) > 0) {
            by = 2;
        }
        a3.consumeOnPickupCache.put(a2, by);
        return (byte)by;
    }

    public final /* synthetic */ StructFamiliar getFamiliarByItem(int a2) {
        MapleItemInformationProvider a3;
        return a3.familiars_Item.get(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void finalizeEquipData(ItemInformation a2) {
        block62: {
            ItemInformation itemInformation = a2;
            int n2 = itemInformation.itemId;
            if (itemInformation.equipStats == null) {
                ItemInformation itemInformation2 = a2;
                itemInformation2.equipStats = new HashMap<String, Integer>();
            }
            a2.eq = new Equip(n2, 0, -1, (int)0);
            short s2 = GameConstants.getStat(n2, 0);
            if (s2 > 0) {
                ItemInformation itemInformation3 = a2;
                itemInformation3.eq.setStr(s2);
                itemInformation3.eq.setDex(s2);
                itemInformation3.eq.setInt(s2);
                itemInformation3.eq.setLuk(s2);
            }
            if ((s2 = GameConstants.getATK(n2, 0)) > 0) {
                ItemInformation itemInformation4 = a2;
                itemInformation4.eq.setWatk(s2);
                itemInformation4.eq.setMatk(s2);
            }
            if ((s2 = GameConstants.getHpMp(n2, 0)) > 0) {
                ItemInformation itemInformation5 = a2;
                itemInformation5.eq.setHp(s2);
                itemInformation5.eq.setMp(s2);
            }
            if ((s2 = GameConstants.getDEF(n2, 0)) > 0) {
                ItemInformation itemInformation6 = a2;
                itemInformation6.eq.setWdef(s2);
                itemInformation6.eq.setMdef(s2);
            }
            if (a2.equipStats.size() <= 0) break block62;
            block48: for (Map.Entry<String, Integer> entry : a2.equipStats.entrySet()) {
                int n3;
                block63: {
                    String string = entry.getKey();
                    int n4 = -1;
                    switch (string.hashCode()) {
                        case 82449: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("dke"))) break;
                            n3 = n4 = 0;
                            break block63;
                        }
                        case 67575: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\u0001U\u001d"))) break;
                            n3 = n4 = 1;
                            break block63;
                        }
                        case 72655: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("~qc"))) break;
                            n3 = n4 = 2;
                            break block63;
                        }
                        case 75746: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\tE\u000e"))) break;
                            n3 = n4 = 3;
                            break block63;
                        }
                        case 78963: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("g~s"))) break;
                            n3 = n4 = 4;
                            break block63;
                        }
                        case 79056: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\u0015T\u0001"))) break;
                            n3 = n4 = 5;
                            break block63;
                        }
                        case 76080: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("z~s"))) break;
                            n3 = n4 = 6;
                            break block63;
                        }
                        case 76173: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\bT\u0001"))) break;
                            n3 = n4 = 7;
                            break block63;
                        }
                        case 64609: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("v|t"))) break;
                            n3 = n4 = 8;
                            break block63;
                        }
                        case 69040: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\u0000F\u0004"))) break;
                            n3 = n4 = 9;
                            break block63;
                        }
                        case 80089127: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("dORZS"))) break;
                            n3 = n4 = 10;
                            break block63;
                        }
                        case 2320462: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("Z0}5"))) break;
                            n3 = n4 = 11;
                            break block63;
                        }
                        case 76309: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("zwg"))) break;
                            n3 = n4 = 12;
                            break block63;
                        }
                        case 76464: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\b]\u0015"))) break;
                            n3 = n4 = 13;
                            break block63;
                        }
                        case 115202: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("CJT"))) break;
                            n3 = n4 = 14;
                            break block63;
                        }
                        case 65368576: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\u0006b$v1"))) break;
                            n3 = n4 = 15;
                            break block63;
                        }
                        case 716086281: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("[BMV]^S^KN"))) break;
                            n3 = n4 = 16;
                            break block63;
                        }
                        case 1015922457: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("\u0015F\u0015T$}$w "))) break;
                            n3 = n4 = 17;
                            break block63;
                        }
                        case 1436259014: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("\\_^ERrgg"))) break;
                            n3 = n4 = 18;
                            break block63;
                        }
                        case 2365693: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]\r@7"))) break;
                            n3 = n4 = 19;
                            break block63;
                        }
                        case 2370498: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rzoE"))) break;
                            n3 = n4 = 20;
                            break block63;
                        }
                        case -431118970: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("b a\tu3u)"))) break;
                            n4 = 21;
                        }
                    }
                    n3 = n4;
                }
                switch (n3) {
                    case 0: {
                        a2.eq.setStr(GameConstants.getStat(n2, entry.getValue()));
                        continue block48;
                    }
                    case 1: {
                        a2.eq.setDex(GameConstants.getStat(n2, entry.getValue()));
                        continue block48;
                    }
                    case 2: {
                        a2.eq.setInt(GameConstants.getStat(n2, entry.getValue()));
                        continue block48;
                    }
                    case 3: {
                        a2.eq.setLuk(GameConstants.getStat(n2, entry.getValue()));
                        continue block48;
                    }
                    case 4: {
                        a2.eq.setWatk(GameConstants.getATK(n2, entry.getValue()));
                        continue block48;
                    }
                    case 5: {
                        a2.eq.setWdef(GameConstants.getDEF(n2, entry.getValue()));
                        continue block48;
                    }
                    case 6: {
                        a2.eq.setMatk(GameConstants.getATK(n2, entry.getValue()));
                        continue block48;
                    }
                    case 7: {
                        a2.eq.setMdef(GameConstants.getDEF(n2, entry.getValue()));
                        continue block48;
                    }
                    case 8: {
                        a2.eq.setAcc((short)entry.getValue().intValue());
                        continue block48;
                    }
                    case 9: {
                        a2.eq.setAvoid((short)entry.getValue().intValue());
                        continue block48;
                    }
                    case 10: {
                        a2.eq.setSpeed((short)entry.getValue().intValue());
                        continue block48;
                    }
                    case 11: {
                        a2.eq.setJump((short)entry.getValue().intValue());
                        continue block48;
                    }
                    case 12: {
                        a2.eq.setHp(GameConstants.getHpMp(n2, entry.getValue()));
                        continue block48;
                    }
                    case 13: {
                        a2.eq.setMp(GameConstants.getHpMp(n2, entry.getValue()));
                        continue block48;
                    }
                    case 14: {
                        a2.eq.setUpgradeSlots(entry.getValue().byteValue());
                        continue block48;
                    }
                    case 15: {
                        a2.eq.setHands(entry.getValue().shortValue());
                        continue block48;
                    }
                    case 16: {
                        a2.eq.setDurability(entry.getValue());
                        continue block48;
                    }
                    case 17: {
                        a2.eq.setPVPDamage(entry.getValue().shortValue());
                        continue block48;
                    }
                    case 18: {
                        a2.eq.setCharmEXP(entry.getValue().shortValue());
                        continue block48;
                    }
                    case 19: {
                        a2.eq.setHpR(entry.getValue().shortValue());
                        continue block48;
                    }
                    case 20: {
                        a2.eq.setMpR(entry.getValue().shortValue());
                        continue block48;
                    }
                    case 21: {
                        a2.eq.setReqLevel(entry.getValue().byteValue());
                        continue block48;
                    }
                }
            }
            if (a2.equipStats.get(MonsterDropEntry.ALLATORIxDEMO("\\VL_")) != null && a2.eq.getCharmEXP() <= 0) {
                ItemInformation itemInformation7;
                int n5 = 0;
                int n6 = n2 / 10000;
                if (ItemConstants.\u985e\u578b.\u6b66\u5668((int)n2) || n6 == 106) {
                    n5 = 60;
                    itemInformation7 = a2;
                } else if (n6 == 100) {
                    n5 = 50;
                    itemInformation7 = a2;
                } else if (ItemConstants.\u985e\u578b.\u98fe\u54c1((int)n2) || n6 == 102 || n6 == 108 || n6 == 107) {
                    n5 = 40;
                    itemInformation7 = a2;
                } else {
                    if (n6 == 104 || n6 == 105 || n6 == 110) {
                        n5 = 30;
                    }
                    itemInformation7 = a2;
                }
                itemInformation7.eq.setCharmEXP((short)n5);
            }
        }
    }

    public final /* synthetic */ Collection<ItemInformation> getAllItems() {
        MapleItemInformationProvider a2;
        return a2.dataCache.values();
    }

    public final /* synthetic */ String getAfterImage(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.afterImage;
    }

    public final /* synthetic */ List<Pair<Integer, Integer>> getSummonMobs(int a2) {
        MapleItemInformationProvider a3;
        if (a3.summonMobCache.containsKey(a2)) {
            return a3.summonMobCache.get(a2);
        }
        if (!GameConstants.isSummonSack(a2)) {
            return null;
        }
        Object object = a3.getItemData(a2).getChildByPath(MapNameData.ALLATORIxDEMO("(\u007f'"));
        if (object == null) {
            return null;
        }
        ArrayList<Pair<Integer, Integer>> arrayList = new ArrayList<Pair<Integer, Integer>>();
        Object object2 = object = object.getChildren().iterator();
        while (object2.hasNext()) {
            MapleData mapleData = (MapleData)object.next();
            object2 = object;
            arrayList.add(new Pair<Integer, Integer>(MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("VS"), mapleData), MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("`7\u007f'"), mapleData)));
        }
        a3.summonMobCache.put(a2, arrayList);
        return arrayList;
    }

    public final /* synthetic */ boolean isPickupRestricted(int a2) {
        MapleItemInformationProvider a3;
        ItemInformation itemInformation = a3.getItemInformation(a2);
        if (itemInformation == null) {
            return false;
        }
        return ((itemInformation.flag & 0x80) != 0 || GameConstants.isPickupRestricted(a2)) && a2 != 4001168 && a2 != 4031306 && a2 != 4031307;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final /* synthetic */ IItem scrollEquipWithId(IItem a, IItem a, boolean a, MapleCharacter a, int a) {
        block87: {
            if (a.getType() != 1) return a;
            a = a.getItemId();
            if (ItemConstants.is\u88dd\u5099\u5377\u8ef8(a)) {
                return a.scrollEnhance(a, (IItem)a, (MapleCharacter)a);
            }
            if (ItemConstants.is\u6f5b\u5728\u80fd\u529b\u5377\u8ef8(a)) {
                return a.scrollPotential(a, (IItem)a, (MapleCharacter)a);
            }
            if (ItemConstants.is\u9644\u52a0\u6f5b\u80fd\u5377\u8ef8(a)) {
                return a.scrollPotentialAdd(a, (IItem)a, (MapleCharacter)a);
            }
            var6_8 = (Equip)a;
            v0 = a;
            var7_9 = v0.getEquipStats(a);
            var8_10 = v0.getEquipStats(a.getItemId());
            v1 = var7_9 == null || var7_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("DJT\\RLD")) == false ? 0 : (var9_12 = GameConstants.isTablet(a) != false ? GameConstants.getSuccessTablet(a, var6_8.getLevel()) : var7_9.get(MapNameData.ALLATORIxDEMO("6e&s c6")));
            var10_13 = var7_9 == null || var7_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("\\BMDZS")) == false ? 0 : (GameConstants.isTablet(a) != false ? GameConstants.getCurseTablet(a, var6_8.getLevel()) : var7_9.get(MapNameData.ALLATORIxDEMO("s0b6u!")));
            var11_14 = var7_9 == null || var7_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("[VZVCZSsA")) == false ? 0 : var7_9.get(MapNameData.ALLATORIxDEMO(")y(y1u!\\3"));
            var12_15 = GameConstants.getChaosNumber(a);
            var13_16 = 0;
            block51: for (Map.Entry<String, Integer> var15_19 : var7_9.entrySet()) {
                block86: {
                    var17_23 = var16_21 = var15_19.getKey();
                    var18_32 = -1;
                    switch (var17_23.hashCode()) {
                        case -1117018423: {
                            if (!var17_23.equals(MonsterDropEntry.ALLATORIxDEMO("tWVPDqBRUZE"))) break;
                            v2 = var18_32 = 0;
                            break block86;
                        }
                        case 2109080961: {
                            if (!var17_23.equals(MapNameData.ALLATORIxDEMO("B$~!\u007f(C)\u007f1"))) break;
                            var18_32 = 1;
                        }
                    }
                    v2 = var18_32;
                }
                switch (v2) {
                    case 0: {
                        var12_15 = var15_19.getValue();
                        continue block51;
                    }
                    case 1: {
                        var13_16 = var15_19.getValue();
                        continue block51;
                    }
                }
            }
            if (var11_14 > 0 && var6_8.getLevel() < var11_14) {
                return var6_8;
            }
            if (!ItemConstants.is\u7279\u6b8a\u5377\u8ef8(a)) ** GOTO lbl53
            switch (a) {
                case 2530003: 
                case 2532001: 
                case 5068000: 
                case 0x4D5544: 
                case 5068200: {
                    if (ItemConstants.isPetEquip(var6_8.getItemId()) == false) return var6_8;
                    v3 = a;
                    break;
                }
                default: {
                    if (ItemConstants.isPetEquip(var6_8.getItemId())) {
                        return var6_8;
                    }
lbl53:
                    // 3 sources

                    v3 = a;
                }
            }
            var14_18 = GameConstants.isCleanSlate(v3) != false ? 0 : a.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).getLevel() / 10;
            var15_20 = ItemFlag.LUCKS_KEY.check(a.getFlag()) != false ? 10 : 0;
            v4 = var9_12;
            var16_22 = v4 + v4 * (var15_20 + var14_18 + a.getSuccessRates(a.getItemId())) / 100;
            if (a.isAdmin()) {
                a.dropMessage(-5, "\u666e\u901a\u5377\u8ef8 - \u9ed8\u8a8d\u5e7e\u7387: " + var9_12 + "% \u50be\u5411\u52a0\u6210: " + var14_18 + "% \u5e78\u904b\u72c0\u614b\u52a0\u6210: " + var15_20 + "% \u6700\u7d42\u6982\u7387: " + var16_22 + "% \u5931\u6557\u6d88\u5931\u5e7e\u7387: " + var10_13 + "%");
            }
            if (ItemFlag.LUCKS_KEY.check(a.getFlag()) && (!ItemConstants.is\u7279\u6b8a\u5377\u8ef8(a) || ItemConstants.is\u5e36\u6210\u529f\u7387\u7279\u6b8a\u5377\u8ef8(a))) {
                v5 = a;
                v5.setFlag(v5.getFlag() - ItemFlag.LUCKS_KEY.getValue());
            }
            if ((!ItemConstants.is\u7279\u6b8a\u5377\u8ef8(a) || ItemConstants.is\u5e36\u6210\u529f\u7387\u7279\u6b8a\u5377\u8ef8(a)) && Randomizer.nextInt(100) > var16_22) break block87;
            switch (a) {
                case 2040727: {
                    v6 = var6_8;
                    var17_24 = v6.getFlag();
                    v6.setFlag(var17_24 |= ItemFlag.SPIKES.getValue());
                    v7 = a;
                    break;
                }
                case 2041058: {
                    v8 = var6_8;
                    var17_25 = v8.getFlag();
                    v8.setFlag(var17_25 |= ItemFlag.COLD.getValue());
                    v7 = a;
                    break;
                }
                default: {
                    if (ItemConstants.is\u5e78\u904b\u5377\u8ef8(a)) {
                        v9 = var6_8;
                        var17_26 = v9.getFlag();
                        v9.setFlag(var17_26 |= ItemFlag.LUCKS_KEY.getValue());
                        if (!ItemConstants.is\u9632\u66b4\u5377\u8ef8(a)) {
                            v7 = a;
                            break;
                        }
                    }
                    if (!ItemConstants.is\u9632\u66b4\u5377\u8ef8(a)) ** GOTO lbl107
                    v10 = var18_32 = var7_9 != null && var7_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("RVGdJGZEVXMrNG")) != false ? var7_9.get(MapNameData.ALLATORIxDEMO("}$h\u0016e5u7y*b\u0000a5")) : 12;
                    if (var18_32 > var6_8.getEnhance() && (var7_9 == null || !var7_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("RVGdJGZEVXMrNG")) || a.isSuperiorEquip(var6_8.getItemId()))) ** GOTO lbl100
                    if (a.isAdmin()) {
                        if (var18_32 <= var6_8.getEnhance()) {
                            v11 = true;
                            v12 = var7_9;
                        } else {
                            v11 = false;
                            v12 = var7_9;
                        }
                        a.dropMessage(-5, "\u7838\u5377\u932f\u8aa4\uff1a\u6b66\u5668\u5f37\u5316\u6b21\u6578\u8d85\u904e\u6216\u7b49\u65bc\u5377\u8ef8\u9650\u5236 " + v11 + " \u53ea\u80fd\u7838\u6975\u771f\u9053\u5177\u800c\u88dd\u5099\u4e0d\u662f\u6975\u771f\u9053\u5177 " + (v12 != null && var7_9.containsKey(MapNameData.ALLATORIxDEMO("}$h\u0016e5u7y*b\u0000a5")) != false && a.isSuperiorEquip(var6_8.getItemId()) == false || a.isSuperiorEquip(var6_8.getItemId()) != false));
                        v7 = a;
                        break;
                    }
                    ** GOTO lbl308
lbl100:
                    // 1 sources

                    v13 = var6_8;
                    var17_27 = v13.getFlag();
                    v14 = (short)(var17_27 | ItemFlag.SHIELD_WARD.getValue());
                    var17_27 = v14;
                    v13.setFlag(v14);
                    v7 = a;
                    break;
lbl107:
                    // 1 sources

                    if (ItemConstants.is\u5b89\u5168\u5377\u8ef8(a)) {
                        v15 = var6_8;
                        var17_28 = v15.getFlag();
                        v16 = (short)(var17_28 | ItemFlag.SLOTS_PROTECT.getValue());
                        var17_28 = v16;
                        v15.setFlag(v16);
                        v7 = a;
                        break;
                    }
                    if (ItemConstants.is\u5377\u8ef8\u9632\u8b77\u5377\u8ef8(a)) {
                        v17 = var6_8;
                        var17_29 = v17.getFlag();
                        v18 = (short)(var17_29 | ItemFlag.SCROLL_PROTECT.getValue());
                        var17_29 = v18;
                        v17.setFlag(v18);
                        v7 = a;
                        break;
                    }
                    if (!GameConstants.isCleanSlate(a)) ** GOTO lbl136
                    switch (a) {
                        case 2049000: 
                        case 2049001: 
                        case 2049002: 
                        case 2049003: 
                        case 2049004: 
                        case 2049005: 
                        case 2049009: 
                        case 2049010: 
                        case 2049011: 
                        case 2049013: 
                        case 2049014: 
                        case 2049015: 
                        case 2049016: 
                        case 2049018: 
                        case 2049019: 
                        case 2049024: 
                        case 2049025: {
                            if (!var8_10.containsKey(MonsterDropEntry.ALLATORIxDEMO("CJT")) || var6_8.getLevel() + var6_8.getUpgradeSlots() >= var8_10.get(MapNameData.ALLATORIxDEMO("1e&")) + var6_8.getViciousHammer()) break;
                            v19 = var6_8;
                            v19.setUpgradeSlots((byte)(v19.getUpgradeSlots() + 1));
                            break;
                        }
                        case 2049006: 
                        case 2049007: 
                        case 2049008: 
                        case 2049012: {
                            if (!var8_10.containsKey(MonsterDropEntry.ALLATORIxDEMO("CJT")) || var6_8.getLevel() + var6_8.getUpgradeSlots() >= var8_10.get(MapNameData.ALLATORIxDEMO("1e&")) + var6_8.getViciousHammer()) break;
                            v20 = var6_8;
                            v20.setUpgradeSlots((byte)(v20.getUpgradeSlots() + 2));
                        }
                    }
                    ** GOTO lbl308
lbl136:
                    // 1 sources

                    if (!ItemConstants.isChaosScroll(a)) ** GOTO lbl183
                    if (var6_8.getStr() > 0) {
                        v21 = var6_8;
                        v21.setStr((short)(v21.getStr() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getDex() > 0) {
                        v22 = var6_8;
                        v22.setDex((short)(v22.getDex() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getInt() > 0) {
                        v23 = var6_8;
                        v23.setInt((short)(v23.getInt() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getLuk() > 0) {
                        v24 = var6_8;
                        v24.setLuk((short)(v24.getLuk() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getWatk() > 0) {
                        v25 = var6_8;
                        v25.setWatk((short)(v25.getWatk() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getWdef() > 0) {
                        v26 = var6_8;
                        v26.setWdef((short)(v26.getWdef() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getMatk() > 0) {
                        v27 = var6_8;
                        v27.setMatk((short)(v27.getMatk() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getMdef() > 0) {
                        v28 = var6_8;
                        v28.setMdef((short)(v28.getMdef() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getAcc() > 0) {
                        v29 = var6_8;
                        v29.setAcc((short)(v29.getAcc() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getAvoid() > 0) {
                        v30 = var6_8;
                        v30.setAvoid((short)(v30.getAvoid() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getSpeed() > 0) {
                        v31 = var6_8;
                        v31.setSpeed((short)(v31.getSpeed() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getJump() > 0) {
                        v32 = var6_8;
                        v32.setJump((short)(v32.getJump() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getHp() > 0) {
                        v33 = var6_8;
                        v33.setHp((short)(v33.getHp() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    }
                    if (var6_8.getMp() <= 0) {
                        v7 = a;
                        break;
                    }
                    v34 = var6_8;
                    v34.setMp((short)(v34.getMp() + (Randomizer.nextInt(var12_15) + 1) * (Randomizer.nextBoolean() != false ? 1 : -1)));
                    v35 = var13_16;
                    ** GOTO lbl304
lbl183:
                    // 16 sources

                    block52: for (Map.Entry<String, Integer> a : var7_9.entrySet()) {
                        var7_9 = a.getKey();
                        var8_11 = -1;
                        switch (var7_9.hashCode()) {
                            case 82449: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("dke"))) break;
                                v36 = var8_11 = 0;
                                ** GOTO lbl244
                            }
                            case 67575: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("\u0001U\u001d"))) break;
                                v36 = var8_11 = 1;
                                ** GOTO lbl244
                            }
                            case 72655: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("~qc"))) break;
                                v36 = var8_11 = 2;
                                ** GOTO lbl244
                            }
                            case 75746: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("\tE\u000e"))) break;
                                v36 = var8_11 = 3;
                                ** GOTO lbl244
                            }
                            case 78963: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("g~s"))) break;
                                v36 = var8_11 = 4;
                                ** GOTO lbl244
                            }
                            case 79056: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("\u0015T\u0001"))) break;
                                v36 = var8_11 = 5;
                                ** GOTO lbl244
                            }
                            case 76080: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("z~s"))) break;
                                v36 = var8_11 = 6;
                                ** GOTO lbl244
                            }
                            case 76173: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("\bT\u0001"))) break;
                                v36 = var8_11 = 7;
                                ** GOTO lbl244
                            }
                            case 64609: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("v|t"))) break;
                                v36 = var8_11 = 8;
                                ** GOTO lbl244
                            }
                            case 69040: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("\u0000F\u0004"))) break;
                                v36 = var8_11 = 9;
                                ** GOTO lbl244
                            }
                            case 80089127: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("dORZS"))) break;
                                v36 = var8_11 = 10;
                                ** GOTO lbl244
                            }
                            case 2320462: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("Z0}5"))) break;
                                v36 = var8_11 = 11;
                                ** GOTO lbl244
                            }
                            case 76309: {
                                if (!var7_9.equals(MonsterDropEntry.ALLATORIxDEMO("zwg"))) break;
                                v36 = var8_11 = 12;
                                ** GOTO lbl244
                            }
                            case 76464: {
                                if (!var7_9.equals(MapNameData.ALLATORIxDEMO("\b]\u0015"))) break;
                                var8_11 = 13;
                            }
                        }
                        v36 = var8_11;
lbl244:
                        // 14 sources

                        switch (v36) {
                            case 0: {
                                v37 = var6_8;
                                v37.setStr((short)(v37.getStr() + a.getValue()));
                                continue block52;
                            }
                            case 1: {
                                v38 = var6_8;
                                v38.setDex((short)(v38.getDex() + a.getValue()));
                                continue block52;
                            }
                            case 2: {
                                v39 = var6_8;
                                v39.setInt((short)(v39.getInt() + a.getValue()));
                                continue block52;
                            }
                            case 3: {
                                v40 = var6_8;
                                v40.setLuk((short)(v40.getLuk() + a.getValue()));
                                continue block52;
                            }
                            case 4: {
                                v41 = var6_8;
                                v41.setWatk((short)(v41.getWatk() + a.getValue()));
                                continue block52;
                            }
                            case 5: {
                                v42 = var6_8;
                                v42.setWdef((short)(v42.getWdef() + a.getValue()));
                                continue block52;
                            }
                            case 6: {
                                v43 = var6_8;
                                v43.setMatk((short)(v43.getMatk() + a.getValue()));
                                continue block52;
                            }
                            case 7: {
                                v44 = var6_8;
                                v44.setMdef((short)(v44.getMdef() + a.getValue()));
                                continue block52;
                            }
                            case 8: {
                                v45 = var6_8;
                                v45.setAcc((short)(v45.getAcc() + a.getValue()));
                                continue block52;
                            }
                            case 9: {
                                v46 = var6_8;
                                v46.setAvoid((short)(v46.getAvoid() + a.getValue()));
                                continue block52;
                            }
                            case 10: {
                                v47 = var6_8;
                                v47.setSpeed((short)(v47.getSpeed() + a.getValue()));
                                continue block52;
                            }
                            case 11: {
                                v48 = var6_8;
                                v48.setJump((short)(v48.getJump() + a.getValue()));
                                continue block52;
                            }
                            case 12: {
                                v49 = var6_8;
                                v49.setHp((short)(v49.getHp() + a.getValue()));
                                continue block52;
                            }
                            case 13: {
                                v50 = var6_8;
                                v50.setMp((short)(v50.getMp() + a.getValue()));
                                continue block52;
                            }
                        }
                    }
                    v35 = var13_16;
lbl304:
                    // 2 sources

                    if (v35 > 0) {
                        var18_35 = Randomizer.rand(1, var13_16);
                        v51 = var6_8;
                        v51.setUpgradeSlots((byte)(v51.getUpgradeSlots() + var18_35));
                    }
lbl308:
                    // 5 sources

                    v7 = a;
                }
            }
            if (GameConstants.isCleanSlate(v7) != false) return a;
            if (ItemConstants.is\u7279\u6b8a\u5377\u8ef8(a) != false) return a;
            var17_30 = var6_8.getFlag();
            if (ItemFlag.SLOTS_PROTECT.check(var17_30)) {
                var6_8.setFlag(var17_30 - ItemFlag.SLOTS_PROTECT.getValue());
            }
            var18_36 = ItemConstants.isAzwanScroll(a) != false ? a.getSlots(a) : 1;
            v52 = var6_8;
            v52.setUpgradeSlots((byte)(v52.getUpgradeSlots() - var18_36));
            v52.setLevel((byte)(v52.getLevel() + var18_36));
            return a;
        }
        if (a == false && !GameConstants.isCleanSlate(a) && !ItemConstants.is\u7279\u6b8a\u5377\u8ef8(a)) {
            var17_31 = var6_8.getFlag();
            if (ItemFlag.SLOTS_PROTECT.check(var17_31)) {
                var6_8.setFlag(var17_31 - ItemFlag.SLOTS_PROTECT.getValue());
                a.dropMessage(5, MonsterDropEntry.ALLATORIxDEMO("\u750e\u658b\u5348\u8ecf\u6577\u67ab\uff33\u5370\u7d25\u6b16\u6547\u6ca5\u6736\u6e2c\u5c2e\u3035"));
            } else {
                var18_32 = ItemConstants.isAzwanScroll(a) != false ? a.getSlots(a) : 1;
                v53 = var6_8;
                v53.setUpgradeSlots((byte)(v53.getUpgradeSlots() - var18_32));
            }
        }
        if (Randomizer.nextInt(99) >= var10_13) return a;
        return null;
    }

    public /* synthetic */ ScriptedItem getScriptedItemInfo(int a2) {
        MapleItemInformationProvider a3;
        if (a3.scriptedItemCache.containsKey(a2)) {
            return a3.scriptedItemCache.get(a2);
        }
        if (a2 / 10000 != 243 && a2 / 10000 != 568) {
            return null;
        }
        ScriptedItem scriptedItem = new ScriptedItem(MapleDataTool.getInt(MapNameData.ALLATORIxDEMO("c5u&?+`&"), a3.getItemData(a2), 0), MapleDataTool.getString(MonsterDropEntry.ALLATORIxDEMO("DOR\\\u0018LTM^OC"), a3.getItemData(a2), ""), MapleDataTool.getInt(MapNameData.ALLATORIxDEMO("c5u&?7e+_+@,s.e5"), a3.getItemData(a2), 0) == 1);
        MapleItemInformationProvider mapleItemInformationProvider = a3;
        mapleItemInformationProvider.scriptedItemCache.put(a2, scriptedItem);
        return mapleItemInformationProvider.scriptedItemCache.get(a2);
    }

    public /* synthetic */ short getPetFlagInfo(int a2) {
        MapleItemInformationProvider a3;
        if (a3.petFlagInfo.containsKey(a2)) {
            return a3.petFlagInfo.get(a2);
        }
        short s2 = 0;
        if (!GameConstants.isPet(a2)) {
            return s2;
        }
        MapleData mapleData = a3.getItemData(a2);
        if (mapleData == null) {
            return s2;
        }
        if (MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018O^\\\\JGvCZZ"), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.ITEM_PICKUP.getValue());
        }
        if (MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("y+v*?)\u007f+w\u0017q+w "), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.EXPAND_PICKUP.getValue());
        }
        if (MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("VYYX\u0010GVTTBOvS["), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.AUTO_PICKUP.getValue());
        }
        if (MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fjc2u `\u0003\u007f7T7\u007f5"), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.LEFTOVER_PICKUP.getValue());
        }
        if (MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("VYYX\u0010TPYLBRRwg"), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.HP_CHARGE.getValue());
        }
        if (MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("y+v*?&\u007f+c0} ]\u0015"), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.MP_CHARGE.getValue());
            s2 = (short)(s2 | MaplePet.PetFlag.UNPICKABLE.getValue());
        }
        if (GameSetConstants.MAPLE_VERSION >= 134 && MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018^BKX}BYQ"), mapleData, 0) > 0 || GameSetConstants.GIVEALL_PETSKILL) {
            s2 = (short)(s2 | MaplePet.PetFlag.PET_BUFF.getValue());
        }
        a3.petFlagInfo.put(a2, s2);
        return s2;
    }

    public /* synthetic */ void initItemEquipData(ResultSet a2) throws SQLException {
        Map<String, Integer> map;
        MapleItemInformationProvider a3;
        int n2 = a2.getInt(MonsterDropEntry.ALLATORIxDEMO("VCZZVS"));
        if (a3.ALLATORIxDEMO == null || a3.ALLATORIxDEMO.itemId != n2) {
            if (!a3.dataCache.containsKey(n2)) {
                System.out.println("[initItemEquipData] Tried to load an item while this is not in the cache: " + n2);
                return;
            }
            a3.ALLATORIxDEMO = a3.dataCache.get(n2);
        }
        if (a3.ALLATORIxDEMO.equipStats == null) {
            a3.ALLATORIxDEMO.equipStats = new HashMap<String, Integer>();
        }
        if ((n2 = a2.getInt(MapNameData.ALLATORIxDEMO(",d }\tu3u)"))) == -1) {
            a3.ALLATORIxDEMO.equipStats.put(a2.getString(MonsterDropEntry.ALLATORIxDEMO("\\ZN")), a2.getInt(MapNameData.ALLATORIxDEMO("3q)e ")));
            return;
        }
        if (a3.ALLATORIxDEMO.equipIncs == null) {
            a3.ALLATORIxDEMO.equipIncs = new HashMap<Integer, Map<String, Integer>>();
        }
        if ((map = a3.ALLATORIxDEMO.equipIncs.get(n2)) == null) {
            map = new HashMap<String, Integer>();
            a3.ALLATORIxDEMO.equipIncs.put(n2, map);
        }
        map.put(a2.getString(MonsterDropEntry.ALLATORIxDEMO("\\ZN")), a2.getInt(MapNameData.ALLATORIxDEMO("3q)e ")));
    }

    public final /* synthetic */ Pair<Integer, List<Integer>> questItemInfo(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return new Pair<Integer, List<Integer>>(a22.questId, a22.questItems);
    }

    public final /* synthetic */ int getReqFame(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRNgpg"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\u0015_\u0015"));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void ModifySlotMax() {
        n2 = 0;
        n3 = 0;
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapNameData.ALLATORIxDEMO("C\u0000\\\u0000S\u00110o0\u0003B\n]ep2j\u001ay1u(t$d$O(\u007f!y#i\u001ac)\u007f1}$h%"));
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            v0 = resultSet;
            n3 = v0.getInt(MonsterDropEntry.ALLATORIxDEMO("VCZZVS"));
            n2 = v0.getInt(MapNameData.ALLATORIxDEMO("~ g6|*d(q="));
            if (n3 <= 0 || n2 <= 0 || (itemInformation = a2.dataCache.get(n3)) == null) continue;
            itemInformation.slotMax = (short)n2;
            a2.dataCache.replace(n3, itemInformation);
            System.out.println("\u4fee\u6539\u7269\u54c1ID: " + n3 + " \u7684\u5806\u758a \u6578\u91cf:" + n2 + " ");
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v1 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v1 = throwable;
                    }
                    throw v1;
                }
                catch (Exception exception) {
                    System.err.println("\u66f4\u65b0\u597d\u53cb\u7fa4\u7d44\u7570\u5e38 " + exception);
                    exception.printStackTrace();
                }
            }
        }
    }

    public final /* synthetic */ int getCardMobId(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        return a22.monsterBook;
    }

    public /* synthetic */ int getPetLimitLife(int a2) {
        MapleItemInformationProvider a3;
        if (a3.petLimitLifeInfo.containsKey(a2)) {
            return a3.petLimitLifeInfo.get(a2);
        }
        if (!GameConstants.isPet(a2)) {
            return 0;
        }
        MapleItemInformationProvider mapleItemInformationProvider = a3;
        MapleData mapleData = mapleItemInformationProvider.getItemData(a2);
        int n2 = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("VYYX\u0010[VZVCZSs^YR"), mapleData, 0);
        mapleItemInformationProvider.petLimitLifeInfo.put(a2, n2);
        return n2;
    }

    public /* synthetic */ StructAndroid getAndroidInfo(int a2) {
        MapleItemInformationProvider a3;
        return a3.androidInfo.get(a2);
    }

    public /* synthetic */ void initItemAddData(ResultSet a2) throws SQLException {
        EquipAdditions equipAdditions;
        MapleItemInformationProvider a3;
        int n2 = a2.getInt(MonsterDropEntry.ALLATORIxDEMO("VCZZVS"));
        if (a3.ALLATORIxDEMO == null || a3.ALLATORIxDEMO.itemId != n2) {
            if (!a3.dataCache.containsKey(n2)) {
                System.out.println("[initItemAddData] Tried to load an item while this is not in the cache: " + n2);
                return;
            }
            a3.ALLATORIxDEMO = a3.dataCache.get(n2);
        }
        if (a3.ALLATORIxDEMO.equipAdditions == null) {
            a3.ALLATORIxDEMO.equipAdditions = new EnumMap(EquipAdditions.class);
        }
        if ((equipAdditions = EquipAdditions.fromString(a2.getString(MapNameData.ALLATORIxDEMO(".u<")))) != null) {
            a3.ALLATORIxDEMO.equipAdditions.put(equipAdditions, new Pair<Integer, Integer>(a2.getInt(MonsterDropEntry.ALLATORIxDEMO("IVSBZ\u0006")), a2.getInt(MapNameData.ALLATORIxDEMO("f$|0uw"))));
        }
    }

    public /* synthetic */ int getSuccessRates(int a2) {
        MapleItemInformationProvider a3;
        if (a3.successRates.containsKey(a2)) {
            return a3.successRates.get(a2);
        }
        int n2 = 0;
        if (a2 / 10000 != 204) {
            return n2;
        }
        int n3 = n2 = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fjc0s&u6c\u0017q1u6?u"), a3.getItemData(a2), 0);
        a3.successRates.put(a2, n3);
        return n3;
    }

    public /* synthetic */ void initItemRewardData(ResultSet a2) throws SQLException {
        MapleItemInformationProvider a3;
        int n2 = a2.getInt(MapNameData.ALLATORIxDEMO("y1u(y!"));
        if (a3.ALLATORIxDEMO == null || a3.ALLATORIxDEMO.itemId != n2) {
            if (!a3.dataCache.containsKey(n2)) {
                System.out.println("[initItemRewardData] Tried to load an item while this is not in the cache: " + n2);
                return;
            }
            a3.ALLATORIxDEMO = a3.dataCache.get(n2);
        }
        if (a3.ALLATORIxDEMO.rewardItems == null) {
            a3.ALLATORIxDEMO.rewardItems = new ArrayList<StructRewardItem>();
        }
        StructRewardItem structRewardItem = new StructRewardItem();
        structRewardItem.itemid = a2.getInt(MonsterDropEntry.ALLATORIxDEMO("VCZZ"));
        structRewardItem.period = structRewardItem.itemid == 0x111EE1 ? Math.max(a2.getInt(MapNameData.ALLATORIxDEMO("` b,\u007f!")), 7200) : a2.getInt(MonsterDropEntry.ALLATORIxDEMO("ORM^PS"));
        StructRewardItem structRewardItem2 = structRewardItem;
        ResultSet resultSet = a2;
        structRewardItem.prob = resultSet.getInt(MapNameData.ALLATORIxDEMO("`7\u007f'"));
        structRewardItem2.quantity = resultSet.getShort(MonsterDropEntry.ALLATORIxDEMO("NB^YK^KN"));
        structRewardItem2.worldmsg = a2.getString(MapNameData.ALLATORIxDEMO("g*b)t\bc\"")).length() <= 0 ? null : a2.getString(MonsterDropEntry.ALLATORIxDEMO("HXM[[zLP"));
        structRewardItem.effect = a2.getString(MapNameData.ALLATORIxDEMO("u#v s1"));
        a3.ALLATORIxDEMO.rewardItems.add(structRewardItem);
    }

    public final /* synthetic */ short getSlotMax(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        return a22.slotMax;
    }

    public /* synthetic */ List<Integer> getMapFromMob(int a2) {
        MapleItemInformationProvider a3;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (MapNameData mapNameData : a3.MapDataCache.values()) {
            if (!mapNameData.getMobs().contains(a2)) continue;
            linkedList.add(mapNameData.getMapId());
        }
        return linkedList;
    }

    public final /* synthetic */ List<Triple<String, Point, Point>> getAfterImage(String a2) {
        MapleItemInformationProvider a3;
        return a3.afterImage.get(a2);
    }

    public /* synthetic */ int getSuccess(int a2, boolean a3) {
        MapleItemInformationProvider a4;
        Map<String, Integer> map = MapNameData.ALLATORIxDEMO("6e&s c6");
        map = a4.getEquipStats(a2);
        if (map == null || !map.containsKey(MonsterDropEntry.ALLATORIxDEMO("DJT\\RLD"))) {
            return 0;
        }
        if (a2 / 10000 != 204 && !a3) {
            return 0;
        }
        return (Integer)map.get(MapNameData.ALLATORIxDEMO("6e&s c6"));
    }

    public final /* synthetic */ boolean isCash(int a2) {
        int n2;
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null) {
            return GameConstants.getInventoryType(a2) == MapleInventoryType.CASH;
        }
        int[] arrn = GameSetConstants.SetItemInCash;
        int n3 = GameSetConstants.SetItemInCash.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = arrn[n2];
            if (a2 == n5) {
                return true;
            }
            n4 = ++n2;
        }
        return GameConstants.getInventoryType(a2) == MapleInventoryType.CASH || a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("s$c-")) != null;
    }

    public /* synthetic */ Pair<Integer, Integer> getChairRecovery(int a2) {
        Pair<Integer, Integer> pair;
        MapleItemInformationProvider a3;
        if (a2 / 10000 != 301) {
            return null;
        }
        if (a3.chairRecovery.containsKey(a2)) {
            return a3.chairRecovery.get(a2);
        }
        int n2 = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fjb s*f b<X\u0015"), a3.getItemData(a2), 0);
        int n3 = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018MR\\XIRMNrg"), a3.getItemData(a2), 0);
        Pair<Integer, Integer> pair2 = pair = new Pair<Integer, Integer>(n2, n3);
        a3.chairRecovery.put(a2, pair2);
        return pair2;
    }

    public /* synthetic */ MapleWeaponType getWeaponType(int a2) {
        a2 = a2 / 10000 % 100;
        MapleWeaponType[] arrmapleWeaponType = new MapleWeaponType[20];
        arrmapleWeaponType[0] = MapleWeaponType.\u55ae\u624b\u528d;
        arrmapleWeaponType[1] = MapleWeaponType.\u55ae\u624b\u65a7;
        arrmapleWeaponType[2] = MapleWeaponType.\u55ae\u624b\u68cd;
        arrmapleWeaponType[3] = MapleWeaponType.\u77ed\u528d;
        arrmapleWeaponType[4] = MapleWeaponType.\u6c92\u6709\u6b66\u5668;
        arrmapleWeaponType[5] = MapleWeaponType.\u6c92\u6709\u6b66\u5668;
        arrmapleWeaponType[6] = MapleWeaponType.\u6c92\u6709\u6b66\u5668;
        arrmapleWeaponType[7] = MapleWeaponType.\u9577\u6756;
        arrmapleWeaponType[8] = MapleWeaponType.\u77ed\u6756;
        arrmapleWeaponType[9] = MapleWeaponType.\u6c92\u6709\u6b66\u5668;
        arrmapleWeaponType[10] = MapleWeaponType.\u96d9\u624b\u528d;
        arrmapleWeaponType[11] = MapleWeaponType.\u96d9\u624b\u65a7;
        arrmapleWeaponType[12] = MapleWeaponType.\u96d9\u624b\u68cd;
        arrmapleWeaponType[13] = MapleWeaponType.\u77db;
        arrmapleWeaponType[14] = MapleWeaponType.\u69cd;
        arrmapleWeaponType[15] = MapleWeaponType.\u5f13;
        arrmapleWeaponType[16] = MapleWeaponType.\u5f29;
        arrmapleWeaponType[17] = MapleWeaponType.\u62f3\u5957;
        arrmapleWeaponType[18] = MapleWeaponType.\u6307\u864e;
        arrmapleWeaponType[19] = MapleWeaponType.\u706b\u69cd;
        MapleWeaponType[] arrmapleWeaponType2 = arrmapleWeaponType;
        if (a2 < 30 || a2 > 49) {
            return MapleWeaponType.\u6c92\u6709\u6b66\u5668;
        }
        return arrmapleWeaponType2[a2 - 30];
    }

    public /* synthetic */ boolean isOnly(int a2) {
        boolean bl;
        MapleItemInformationProvider a3;
        if (a3.onOnlyCache.containsKey(a2)) {
            return a3.onOnlyCache.get(a2);
        }
        boolean bl2 = bl = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fj\u007f+|<"), a3.getItemData(a2), 0) > 0;
        a3.onOnlyCache.put(a2, bl2);
        return bl2;
    }

    public final /* synthetic */ int getReqLuk(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRN{j|"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\tE\u000e"));
    }

    public final /* synthetic */ int getMeso(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        return a22.meso;
    }

    public final /* synthetic */ MapleStatEffect getItemEffect(MapleCharacter a2, int a3) {
        MapleItemInformationProvider a4;
        MapleStatEffect mapleStatEffect = a4.itemEffects.get(a3);
        if (mapleStatEffect == null) {
            MapleData mapleData = a4.getItemData(a3);
            if (mapleData == null) {
                a4.itemEffects.put(a3, null);
                return null;
            }
            String string = MonsterDropEntry.ALLATORIxDEMO("LGZT");
            if (mapleData.getChildByPath(MapNameData.ALLATORIxDEMO("c5u&")) == null) {
                string = MonsterDropEntry.ALLATORIxDEMO("VYYX");
            }
            if ((mapleStatEffect = MapleStatEffect.loadItemEffectFromData(mapleData.getChildByPath(string), a3)).getItemSkill() != 0 && mapleStatEffect.getItemSkillLevel() > 0 && SkillFactory.getSkill(mapleStatEffect.getItemSkill()) != null) {
                mapleStatEffect = SkillFactory.getSkill(mapleStatEffect.getItemSkill()).getEffect(mapleStatEffect.getItemSkillLevel());
            }
            a4.itemEffects.put(a3, mapleStatEffect);
        }
        if (mapleStatEffect != null && mapleStatEffect.getItemSkill() == 6666666 && a2 != null) {
            MapleCharacter mapleCharacter = a2;
            mapleCharacter.setPetVacTime(System.currentTimeMillis() + (long)(mapleStatEffect.getItemSkillLevel() * 60 * 1000));
            mapleCharacter.dropMessage(-1, "\u60a8\u7372\u5f97\u5bf5\u7269\u5168\u5716\u5438 " + mapleStatEffect.getItemSkillLevel() + " \u5206\u9418\u6548\u679c!");
        }
        return mapleStatEffect;
    }

    public final /* synthetic */ boolean itemExists(int a2) {
        MapleItemInformationProvider a3;
        if (GameConstants.getInventoryType(a2) == MapleInventoryType.UNDEFINED) {
            return false;
        }
        return a3.getItemInformation(a2) != null;
    }

    public /* synthetic */ String getStreetName(int a22) {
        MapleItemInformationProvider a3;
        MapNameData a22 = a3.MapDataCache.get(a22);
        if (a22 == null) {
            return "";
        }
        return a22.getStreetName();
    }

    public final /* synthetic */ Map<String, Integer> getSkillStats(int a2) {
        MapleItemInformationProvider a3;
        if (a3.SkillStatsCache.containsKey(a2)) {
            return a3.SkillStatsCache.get(a2);
        }
        if (a2 / 10000 != 228 && a2 / 10000 != 229 && a2 / 10000 != 562) {
            return null;
        }
        MapleData mapleData = a3.getItemData(a2);
        if (mapleData == null) {
            return null;
        }
        if ((mapleData = mapleData.getChildByPath(MapNameData.ALLATORIxDEMO("y+v*"))) == null) {
            return null;
        }
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for (MapleData mapleData2 : mapleData.getChildren()) {
            if (!mapleData2.getName().startsWith(MonsterDropEntry.ALLATORIxDEMO("^QT"))) continue;
            linkedHashMap.put(mapleData2.getName().substring(3), MapleDataTool.getIntConvert(mapleData2));
        }
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("(q6d b\tu3u)"), MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("Z^DKRM{ZAZ["), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("7u4C.y)|\tu3u)"), MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("EZFl\\V[S{ZAZ["), mapleData, 0));
        linkedHashMap.put(MapNameData.ALLATORIxDEMO("6e&s c6"), MapleDataTool.getInt(MonsterDropEntry.ALLATORIxDEMO("DJT\\RLD"), mapleData, 0));
        MapleData mapleData3 = mapleData.getChildByPath(MapNameData.ALLATORIxDEMO("6{,|)"));
        int n2 = 0;
        int n3 = n2;
        while (n3 < mapleData3.getChildren().size()) {
            String string = "skillid" + n2;
            String string2 = Integer.toString(n2);
            linkedHashMap.put(string, MapleDataTool.getInt(string2, mapleData3, 0));
            n3 = ++n2;
        }
        a3.SkillStatsCache.put(a2, linkedHashMap);
        return linkedHashMap;
    }

    public /* synthetic */ int[] getExpPotionLevel(int a2) {
        MapleItemInformationProvider a3;
        if (a3.expPotionLevel.containsKey(a2)) {
            return a3.expPotionLevel.get(a2);
        }
        MapleItemInformationProvider mapleItemInformationProvider = a3;
        Object object = mapleItemInformationProvider.getItemData(a2);
        int[] arrn = new int[2];
        arrn[0] = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fju=`j},~\tu3"), (MapleData)object, 1);
        arrn[1] = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018ZOO\u0018RVG{ZA"), (MapleData)object, 1);
        object = arrn;
        mapleItemInformationProvider.expPotionLevel.put(a2, (int[])object);
        return object;
    }

    private /* synthetic */ int ALLATORIxDEMO(int a2, int a3) {
        return Math.abs(Randomizer.rand(a2, a3));
    }

    public final /* synthetic */ boolean isPickupBlocked(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return false;
        }
        return (a22.flag & 0x40) != 0;
    }

    public final /* synthetic */ Equip randomizeStats(Equip a2) {
        MapleItemInformationProvider a3;
        Equip equip = a2;
        Equip equip2 = a2;
        Equip equip3 = a2;
        MapleItemInformationProvider mapleItemInformationProvider = a3;
        Equip equip4 = a2;
        Equip equip5 = a2;
        Equip equip6 = a2;
        MapleItemInformationProvider mapleItemInformationProvider2 = a3;
        Equip equip7 = a2;
        Equip equip8 = a2;
        Equip equip9 = a2;
        MapleItemInformationProvider mapleItemInformationProvider3 = a3;
        Equip equip10 = a2;
        Equip equip11 = a2;
        equip11.setStr(a3.ALLATORIxDEMO(a2.getStr(), 5));
        equip11.setDex(a3.ALLATORIxDEMO(equip11.getDex(), 5));
        equip10.setInt(a3.ALLATORIxDEMO(equip10.getInt(), 5));
        equip9.setLuk(mapleItemInformationProvider3.ALLATORIxDEMO(equip10.getLuk(), 5));
        equip8.setMatk(mapleItemInformationProvider3.ALLATORIxDEMO(equip9.getMatk(), 5));
        equip8.setWatk(a3.ALLATORIxDEMO(equip8.getWatk(), 5));
        equip7.setAcc(a3.ALLATORIxDEMO(equip7.getAcc(), 5));
        equip6.setAvoid(mapleItemInformationProvider2.ALLATORIxDEMO(equip7.getAvoid(), 5));
        equip5.setJump(mapleItemInformationProvider2.ALLATORIxDEMO(equip6.getJump(), 5));
        equip5.setHands(a3.ALLATORIxDEMO(equip5.getHands(), 5));
        equip4.setSpeed(a3.ALLATORIxDEMO(equip4.getSpeed(), 5));
        equip3.setWdef(mapleItemInformationProvider.ALLATORIxDEMO(equip4.getWdef(), 10));
        equip2.setMdef(mapleItemInformationProvider.ALLATORIxDEMO(equip3.getMdef(), 10));
        equip2.setHp(a3.ALLATORIxDEMO(equip2.getHp(), 10));
        equip.setMp(a3.ALLATORIxDEMO(equip.getMp(), 10));
        return equip;
    }

    public /* synthetic */ boolean isOnlyEquip(int a2) {
        boolean bl;
        MapleItemInformationProvider a3;
        if (a3.onEquipOnlyCache.containsKey(a2)) {
            return a3.onEquipOnlyCache.get(a2);
        }
        boolean bl2 = bl = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("VYYX\u0010XQ[FrNBVG"), a3.getItemData(a2), 0) > 0;
        a3.onEquipOnlyCache.put(a2, bl2);
        return bl2;
    }

    public final /* synthetic */ List<Integer> getScrollReqs(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null || a22.scrollReqs == null) {
            return new ArrayList<Integer>();
        }
        return a22.scrollReqs;
    }

    public final /* synthetic */ short getSlotMax(MapleClient a2, int a3) {
        MapleItemInformationProvider a4;
        a2 = a4.getItemInformation(a3);
        if (a2 == null) {
            return 0;
        }
        return ((ItemInformation)a2).slotMax;
    }

    public final /* synthetic */ IItem getEquipById(int a2) {
        MapleItemInformationProvider a3;
        return a3.getEquipById(a2, -1);
    }

    public final /* synthetic */ boolean cantSell(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return false;
        }
        return (a22.flag & 0x10) != 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void loadAllMapName() {
        block26: {
            block24: {
                block25: {
                    try {
                        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
                        var2_3 = var1_1.prepareStatement(MapNameData.ALLATORIxDEMO("C\u0000\\\u0000S\u00110o0\u0003B\n]eg?O(q5t$d$"));
                        var3_5 = var2_3.executeQuery();
lbl6:
                        // 2 sources

                        while (true) {
                            try {
                                if (!var3_5.next()) break block24;
                                v0 = var3_5;
                                var4_7 = v0.getInt(MonsterDropEntry.ALLATORIxDEMO("Z^GVS"));
                                var5_9 = v0.getString(MapNameData.ALLATORIxDEMO("(q5~$} "));
                                var6_11 = v0.getString(MonsterDropEntry.ALLATORIxDEMO("LCMRZCqVRR"));
                                var7_12 /* !! */  = v0.getString(MapNameData.ALLATORIxDEMO("~5s6")).split(MonsterDropEntry.ALLATORIxDEMO("\u001b"));
                                var8_13 = v0.getString(MapNameData.ALLATORIxDEMO("}*r6")).split(MonsterDropEntry.ALLATORIxDEMO("\u001b"));
                                var9_14 = new LinkedList<Integer>();
                                var10_15 = new LinkedList<Integer>();
                                var11_16 = var7_12 /* !! */ .length;
                                v1 = var12_17 = 0;
                                while (v1 < var11_16) {
                                    var13_18 = var7_12 /* !! */ [var12_17];
                                    if (StringTool.isNumeric(var13_18) && !var13_18.isEmpty()) {
                                        var9_14.add(Integer.parseInt(var13_18));
                                    }
                                    v1 = ++var12_17;
                                }
                                break block25;
                            }
                            catch (Throwable var4_8) {
                                if (var3_5 != null) {
                                    try {
                                        var3_5.close();
                                        v2 = var4_8;
                                        throw v2;
                                    }
                                    catch (Throwable var5_10) {
                                        var4_8.addSuppressed(var5_10);
                                    }
                                }
                                v2 = var4_8;
                                throw v2;
                            }
                            break;
                        }
                    }
                    catch (Exception var1_2) {
                        var1_2.printStackTrace();
                        break block26;
                    }
                    catch (Throwable var2_4) {
                        if (var1_1 != null) {
                            try {
                                var1_1.close();
                                v3 = var2_4;
                                throw v3;
                            }
                            catch (Throwable var3_6) {
                                var2_4.addSuppressed(var3_6);
                            }
                        }
                        v3 = var2_4;
                        throw v3;
                    }
                }
                var7_12 /* !! */  = var8_13;
                var11_16 = var8_13.length;
                v4 = var12_17 = 0;
                while (v4 < var11_16) {
                    var13_18 = var7_12 /* !! */ [var12_17];
                    if (StringTool.isNumeric(var13_18) && !var13_18.isEmpty()) {
                        var10_15.add(Integer.parseInt(var13_18));
                    }
                    v4 = ++var12_17;
                }
                {
                    var7_12 /* !! */  = new MapNameData(var4_7, var5_9, var6_11, var9_14, var10_15);
                    a.MapDataCache.put(var4_7, (MapNameData)var7_12 /* !! */ );
                    ** continue;
                }
            }
            if (var3_5 != null) {
                v5 = var1_1;
                var3_5.close();
            } else {
                v5 = var1_1;
            }
            if (v5 != null) {
                var1_1.close();
            }
        }
        System.out.println("--------> " + a.MapDataCache.size() + "\u500b\u5730\u5716\u8f09\u5165\u5b8c\u6210");
    }

    public final /* synthetic */ boolean isPKarmaEnabled(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return false;
        }
        return a22.karmaEnabled == 2;
    }

    public final /* synthetic */ StructFamiliar getFamiliarByMob(int a2) {
        MapleItemInformationProvider a3;
        return a3.familiars_Mob.get(a2);
    }

    public /* synthetic */ int getPetLife(int a2) {
        MapleItemInformationProvider a3;
        if (a3.petLifeInfo.containsKey(a2)) {
            return a3.petLifeInfo.get(a2);
        }
        if (!GameConstants.isPet(a2)) {
            return 0;
        }
        MapleItemInformationProvider mapleItemInformationProvider = a3;
        MapleData mapleData = mapleItemInformationProvider.getItemData(a2);
        int n2 = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fj|,v "), mapleData, 0);
        mapleItemInformationProvider.petLifeInfo.put(a2, n2);
        return n2;
    }

    public /* synthetic */ String getMapFullName(int a22) {
        MapleItemInformationProvider a3;
        MapNameData a22 = a3.MapDataCache.get(a22);
        if (a22 == null) {
            return "";
        }
        return a22.getStreetName() + " " + a22.getMapName();
    }

    public /* synthetic */ int getAndroidType(int a2) {
        MapleItemInformationProvider a3;
        if (a3.androidType.containsKey(a2)) {
            return a3.androidType.get(a2);
        }
        int n2 = 0;
        if (a2 / 10000 != 166) {
            return n2;
        }
        int n3 = n2 = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("VYYX\u0010VQSMXVS"), a3.getItemData(a2), 1);
        a3.androidType.put(a2, n3);
        return n3;
    }

    public final /* synthetic */ int getReqStr(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRNdke"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\u0016D\u0017"));
    }

    public final /* synthetic */ Equip randomizeStats_scroll(Equip a2, boolean a3) {
        MapleItemInformationProvider a4;
        Equip equip = a2;
        Equip equip2 = a2;
        MapleItemInformationProvider mapleItemInformationProvider = a4;
        Equip equip3 = a2;
        Equip equip4 = a2;
        Equip equip5 = a2;
        MapleItemInformationProvider mapleItemInformationProvider2 = a4;
        Equip equip6 = a2;
        Equip equip7 = a2;
        Equip equip8 = a2;
        MapleItemInformationProvider mapleItemInformationProvider3 = a4;
        Equip equip9 = a2;
        Equip equip10 = a2;
        Equip equip11 = a2;
        MapleItemInformationProvider mapleItemInformationProvider4 = a4;
        equip11.setStr(mapleItemInformationProvider4.ALLATORIxDEMO(a2.getStr(), 5));
        equip10.setDex(mapleItemInformationProvider4.ALLATORIxDEMO(equip11.getDex(), 5));
        equip10.setInt(a4.ALLATORIxDEMO(equip10.getInt(), 5));
        equip9.setLuk(a4.ALLATORIxDEMO(equip9.getLuk(), 5));
        equip8.setMatk(mapleItemInformationProvider3.ALLATORIxDEMO(equip9.getMatk(), 5));
        equip7.setWatk(mapleItemInformationProvider3.ALLATORIxDEMO(equip8.getWatk(), 5));
        equip7.setAcc(a4.ALLATORIxDEMO(equip7.getAcc(), 5));
        equip6.setAvoid(a4.ALLATORIxDEMO(equip6.getAvoid(), 5));
        equip5.setJump(mapleItemInformationProvider2.ALLATORIxDEMO(equip6.getJump(), 5));
        equip4.setHands(mapleItemInformationProvider2.ALLATORIxDEMO(equip5.getHands(), 5));
        equip4.setSpeed(a4.ALLATORIxDEMO(equip4.getSpeed(), 5));
        equip3.setWdef(a4.ALLATORIxDEMO(equip3.getWdef(), 10));
        equip2.setMdef(mapleItemInformationProvider.ALLATORIxDEMO(equip3.getMdef(), 10));
        equip.setHp(mapleItemInformationProvider.ALLATORIxDEMO(equip2.getHp(), 10));
        equip.setMp(a4.ALLATORIxDEMO(equip.getMp(), 10));
        if (a3 != 0) {
            a3 = (byte)a4.ALLATORIxDEMO(a2.getUpgradeSlots(), GameSetConstants.GASHAPON_RANDOM_SCROLL[0], GameSetConstants.GASHAPON_RANDOM_SCROLL[1]);
            if (GameSetConstants.UPGRADESLOT_CHECK && (a3 > 22 || a3 < 0)) {
                System.out.println("\u885d\u6372\u6578\u76ee\u7570\u5e38,[\u7269\u54c1]" + a2.getItemName() + "[\u885d\u6372\u6578]" + (byte)a3);
                FileoutputUtil.logToFile(MonsterDropEntry.ALLATORIxDEMO("SXXD\u0010ujp\u0010E^Y[XR^ERlC^CLhLTMXS[\u0011CGC"), "\u885d\u6372\u6578\u76ee\u7570\u5e38,[\u7269\u54c1]" + a2.getItemName() + "[\u885d\u6372\u6578]" + (byte)a3);
                a3 = 0;
            }
            a2.setUpgradeSlots((byte)a3);
        }
        return a2;
    }

    public final /* synthetic */ Pair<Integer, Integer> getPot(int a2) {
        MapleItemInformationProvider a3;
        return a3.potLife.get(a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ Equip levelUpEquipA(Equip a2, Map<String, Integer> a3) {
        try {
            block40: for (Map.Entry<String, Integer> entry : a3.entrySet()) {
                int n2;
                block41: {
                    String string = entry.getKey();
                    int n3 = -1;
                    switch (string.hashCode()) {
                        case -1838651775: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("C\u0011B\by+"))) break;
                            n2 = n3 = 0;
                            break block41;
                        }
                        case 2013204187: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("{rgzVY"))) break;
                            n2 = n3 = 1;
                            break block41;
                        }
                        case -2130424829: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("Y\u000bD\by+"))) break;
                            n2 = n3 = 2;
                            break block41;
                        }
                        case -2038340848: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("sbtzVY"))) break;
                            n2 = n3 = 3;
                            break block41;
                        }
                        case -1942503201: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("@\u0004T\by+"))) break;
                            n2 = n3 = 4;
                            break block41;
                        }
                        case -1939732638: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("os{zVY"))) break;
                            n2 = n3 = 5;
                            break block41;
                        }
                        case -2028390654: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]\u0004T\by+"))) break;
                            n2 = n3 = 6;
                            break block41;
                        }
                        case -2025620091: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rs{zVY"))) break;
                            n2 = n3 = 7;
                            break block41;
                        }
                        case 1924844081: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("Q\u0006S\by+"))) break;
                            n2 = n3 = 8;
                            break block41;
                        }
                        case 2056848002: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("za~zVY"))) break;
                            n2 = n3 = 9;
                            break block41;
                        }
                        case -2066556757: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("C5u t\by+"))) break;
                            n2 = n3 = 10;
                            break block41;
                        }
                        case 409484068: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("}JZOzVY"))) break;
                            n2 = n3 = 11;
                            break block41;
                        }
                        case -2021568515: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]\r@\by+"))) break;
                            n2 = n3 = 12;
                            break block41;
                        }
                        case -2016950910: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rzozVY"))) break;
                            n2 = n3 = 13;
                            break block41;
                        }
                        case 450405734: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]$h\r@\by+"))) break;
                            n2 = n3 = 14;
                            break block41;
                        }
                        case 455023339: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rVGzozVY"))) break;
                            n3 = 15;
                        }
                    }
                    n2 = n3;
                }
                switch (n2) {
                    case 0: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setStr((short)(equip.getStr() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("C\u0011B\bq=")))));
                        continue block40;
                    }
                    case 1: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setDex((short)(equip.getDex() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("{rgz^O")))));
                        continue block40;
                    }
                    case 2: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setInt((short)(equip.getInt() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("Y\u000bD\bq=")))));
                        continue block40;
                    }
                    case 3: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setLuk((short)(equip.getLuk() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("sbtz^O")))));
                        continue block40;
                    }
                    case 4: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setWatk((short)(equip.getWatk() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("@\u0004T\bq=")))));
                        continue block40;
                    }
                    case 5: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setWdef((short)(equip.getWdef() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("os{z^O")))));
                        continue block40;
                    }
                    case 6: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMatk((short)(equip.getMatk() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("]\u0004T\bq=")))));
                        continue block40;
                    }
                    case 7: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMdef((short)(equip.getMdef() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("rs{z^O")))));
                        continue block40;
                    }
                    case 8: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setAcc((short)(equip.getAcc() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("Q\u0006S\bq=")))));
                        continue block40;
                    }
                    case 9: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setAvoid((short)(equip.getAvoid() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("za~z^O")))));
                        continue block40;
                    }
                    case 10: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setSpeed((short)(equip.getSpeed() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("C5u t\bq=")))));
                        continue block40;
                    }
                    case 11: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setJump((short)(equip.getJump() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("}JZOz^O")))));
                        continue block40;
                    }
                    case 12: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setHp((short)(equip.getHp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("]\r@\bq=")))));
                        continue block40;
                    }
                    case 13: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMp((short)(equip.getMp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("rzoz^O")))));
                        continue block40;
                    }
                    case 14: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setHp((short)(equip.getHp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("]$h\r@\bq=")))));
                        continue block40;
                    }
                    case 15: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMp((short)(equip.getMp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("rVGzoz^O")))));
                        continue block40;
                    }
                }
            }
            return a2;
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return a2;
    }

    public final /* synthetic */ Map<Integer, StructFamiliar> getFamiliars() {
        MapleItemInformationProvider a2;
        return a2.familiars;
    }

    public /* synthetic */ Map<Integer, MapNameData> getAllMapData() {
        MapleItemInformationProvider a2;
        return a2.MapDataCache;
    }

    public /* synthetic */ MapleItemInformationProvider() {
        MapleItemInformationProvider a4;
        MapleItemInformationProvider mapleItemInformationProvider = a4;
        MapleItemInformationProvider mapleItemInformationProvider2 = a4;
        mapleItemInformationProvider2.etcData = MapleDataProviderFactory.getDataProvider(MonsterDropEntry.ALLATORIxDEMO("zC\\\u0019HM"));
        mapleItemInformationProvider2.itemData = MapleDataProviderFactory.getDataProvider(MapNameData.ALLATORIxDEMO("\fd }kg?"));
        mapleItemInformationProvider.equipData = MapleDataProviderFactory.getDataProvider(MonsterDropEntry.ALLATORIxDEMO("|_^E^TKRM\u0019HM"));
        mapleItemInformationProvider.stringData = MapleDataProviderFactory.getDataProvider(MapNameData.ALLATORIxDEMO("\u0016d7y+wkg?"));
        MapleItemInformationProvider mapleItemInformationProvider3 = a4;
        mapleItemInformationProvider.dataCache = new TreeMap<Integer, ItemInformation>((a2, a3) -> a2.compareTo((Integer)a3));
        a4.mobIds = new TreeMap<Integer, Integer>((a2, a3) -> a2.compareTo((Integer)a3));
        a4.monsterBookSets = new TreeMap<Integer, Triple<Integer, List<Integer>, List<Integer>>>((a2, a3) -> a2.compareTo((Integer)a3));
        MapleItemInformationProvider mapleItemInformationProvider4 = a4;
        mapleItemInformationProvider4.onEquipUntradableCache = new HashMap<Integer, Boolean>();
        mapleItemInformationProvider4.onEquipOnlyCache = new HashMap<Integer, Boolean>();
        mapleItemInformationProvider4.onOnlyCache = new HashMap<Integer, Boolean>();
        mapleItemInformationProvider4.potentialCache = new HashMap<Integer, Map<Integer, StructPotentialItem>>();
        mapleItemInformationProvider4.itemEffects = new HashMap<Integer, MapleStatEffect>();
        mapleItemInformationProvider4.itemEffectsEx = new HashMap<Integer, MapleStatEffect>();
        mapleItemInformationProvider4.itemMakeStatsCache = new HashMap<Integer, Map<String, Byte>>();
        mapleItemInformationProvider4.equipCache = new HashMap<Integer, Equip>();
        mapleItemInformationProvider4.chairRecovery = new HashMap<Integer, Pair<Integer, Integer>>();
        mapleItemInformationProvider4.petFlagInfo = new HashMap<Integer, Short>();
        mapleItemInformationProvider4.petLimitLifeInfo = new HashMap<Integer, Integer>();
        mapleItemInformationProvider4.petLifeInfo = new HashMap<Integer, Integer>();
        mapleItemInformationProvider4.SkillStatsCache = new HashMap<Integer, Map<String, Integer>>();
        mapleItemInformationProvider4.consumeOnPickupCache = new HashMap<Integer, Byte>();
        mapleItemInformationProvider4.petsCanConsumeCache = new HashMap<Integer, List<Integer>>();
        mapleItemInformationProvider4.summonMobCache = new HashMap<Integer, List<Pair<Integer, Integer>>>();
        mapleItemInformationProvider4.setItems = new HashMap<Integer, StructSetItem>();
        mapleItemInformationProvider4.itemNameCache = new ArrayList<Pair<Integer, String>>();
        mapleItemInformationProvider4.nameCache = new HashMap<Integer, String>();
        mapleItemInformationProvider4.familiars = new HashMap<Integer, StructFamiliar>();
        mapleItemInformationProvider4.familiars_Item = new HashMap<Integer, StructFamiliar>();
        mapleItemInformationProvider4.familiars_Mob = new HashMap<Integer, StructFamiliar>();
        mapleItemInformationProvider4.afterImage = new HashMap<String, List<Triple<String, Point, Point>>>();
        mapleItemInformationProvider4.potLife = new HashMap<Integer, Pair<Integer, Integer>>();
        mapleItemInformationProvider4.noCursedScroll = new HashMap<Integer, Boolean>();
        mapleItemInformationProvider4.forceUpgrade = new HashMap<Integer, Integer>();
        mapleItemInformationProvider4.successRates = new HashMap<Integer, Integer>();
        mapleItemInformationProvider4.noNegativeScroll = new HashMap<Integer, Boolean>();
        mapleItemInformationProvider4.androidType = new HashMap<Integer, Integer>();
        mapleItemInformationProvider4.scriptedItemCache = new HashMap<Integer, ScriptedItem>();
        mapleItemInformationProvider4.MapDataCache = new HashMap<Integer, MapNameData>();
        mapleItemInformationProvider4.questItems = new HashMap<Integer, Triple<Integer, Integer, List<Integer>>>();
        mapleItemInformationProvider4.chairRandEffect = new HashMap<Integer, List<Integer>>();
        mapleItemInformationProvider4.androidInfo = new TreeMap<Integer, StructAndroid>((a2, a3) -> a2.compareTo((Integer)a3));
        MapleItemInformationProvider mapleItemInformationProvider5 = a4;
        mapleItemInformationProvider5.expPotionLevel = new HashMap<Integer, int[]>();
        mapleItemInformationProvider5.allEquips = new ArrayList<Equip>();
        mapleItemInformationProvider5.ALLATORIxDEMO = null;
        System.out.println(MonsterDropEntry.ALLATORIxDEMO("\u302f\u8bb7\u53e9\u4e1a\u302e\u0017rVO[Z~KRR~QQPERVK^PYoEPAVSZE\u001f\r\u0005\r"));
    }

    public /* synthetic */ int getForceUpgrade(int a2) {
        MapleItemInformationProvider a3;
        if (a3.forceUpgrade.containsKey(a2)) {
            return a3.forceUpgrade.get(a2);
        }
        int n2 = 0;
        if (a2 / 100 != 20493) {
            return n2;
        }
        int n3 = n2 = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO(",~#\u007fjv*b&u\u0010`\"b$t "), a3.getItemData(a2), 1);
        a3.forceUpgrade.put(a2, n3);
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ Equip levelUpEquip(Equip a2, Map<String, Integer> a3) {
        a2 = (Equip)a2.copy();
        try {
            block40: for (Map.Entry<String, Integer> entry : a3.entrySet()) {
                int n2;
                block41: {
                    String string = entry.getKey();
                    int n3 = -1;
                    switch (string.hashCode()) {
                        case -1838651775: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("C\u0011B\by+"))) break;
                            n2 = n3 = 0;
                            break block41;
                        }
                        case 2013204187: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("{rgzVY"))) break;
                            n2 = n3 = 1;
                            break block41;
                        }
                        case -2130424829: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("Y\u000bD\by+"))) break;
                            n2 = n3 = 2;
                            break block41;
                        }
                        case -2038340848: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("sbtzVY"))) break;
                            n2 = n3 = 3;
                            break block41;
                        }
                        case -1942503201: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("@\u0004T\by+"))) break;
                            n2 = n3 = 4;
                            break block41;
                        }
                        case -1939732638: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("os{zVY"))) break;
                            n2 = n3 = 5;
                            break block41;
                        }
                        case -2028390654: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]\u0004T\by+"))) break;
                            n2 = n3 = 6;
                            break block41;
                        }
                        case -2025620091: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rs{zVY"))) break;
                            n2 = n3 = 7;
                            break block41;
                        }
                        case 1924844081: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("Q\u0006S\by+"))) break;
                            n2 = n3 = 8;
                            break block41;
                        }
                        case 2056848002: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("za~zVY"))) break;
                            n2 = n3 = 9;
                            break block41;
                        }
                        case -2066556757: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("C5u t\by+"))) break;
                            n2 = n3 = 10;
                            break block41;
                        }
                        case 409484068: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("}JZOzVY"))) break;
                            n2 = n3 = 11;
                            break block41;
                        }
                        case -2021568515: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]\r@\by+"))) break;
                            n2 = n3 = 12;
                            break block41;
                        }
                        case -2016950910: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rzozVY"))) break;
                            n2 = n3 = 13;
                            break block41;
                        }
                        case 450405734: {
                            if (!string.equals(MapNameData.ALLATORIxDEMO("]$h\r@\by+"))) break;
                            n2 = n3 = 14;
                            break block41;
                        }
                        case 455023339: {
                            if (!string.equals(MonsterDropEntry.ALLATORIxDEMO("rVGzozVY"))) break;
                            n3 = 15;
                        }
                    }
                    n2 = n3;
                }
                switch (n2) {
                    case 0: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setStr((short)(equip.getStr() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("C\u0011B\bq=")))));
                        continue block40;
                    }
                    case 1: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setDex((short)(equip.getDex() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("{rgz^O")))));
                        continue block40;
                    }
                    case 2: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setInt((short)(equip.getInt() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("Y\u000bD\bq=")))));
                        continue block40;
                    }
                    case 3: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setLuk((short)(equip.getLuk() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("sbtz^O")))));
                        continue block40;
                    }
                    case 4: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setWatk((short)(equip.getWatk() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("@\u0004T\bq=")))));
                        continue block40;
                    }
                    case 5: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setWdef((short)(equip.getWdef() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("os{z^O")))));
                        continue block40;
                    }
                    case 6: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMatk((short)(equip.getMatk() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("]\u0004T\bq=")))));
                        continue block40;
                    }
                    case 7: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMdef((short)(equip.getMdef() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("rs{z^O")))));
                        continue block40;
                    }
                    case 8: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setAcc((short)(equip.getAcc() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("Q\u0006S\bq=")))));
                        continue block40;
                    }
                    case 9: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setAvoid((short)(equip.getAvoid() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("za~z^O")))));
                        continue block40;
                    }
                    case 10: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setSpeed((short)(equip.getSpeed() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("C5u t\bq=")))));
                        continue block40;
                    }
                    case 11: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setJump((short)(equip.getJump() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("}JZOz^O")))));
                        continue block40;
                    }
                    case 12: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setHp((short)(equip.getHp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("]\r@\bq=")))));
                        continue block40;
                    }
                    case 13: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMp((short)(equip.getMp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("rzoz^O")))));
                        continue block40;
                    }
                    case 14: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setHp((short)(equip.getHp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MapNameData.ALLATORIxDEMO("]$h\r@\bq=")))));
                        continue block40;
                    }
                    case 15: {
                        MapleItemInformationProvider a4;
                        Equip equip = a2;
                        equip.setMp((short)(equip.getMp() + a4.ALLATORIxDEMO(entry.getValue(), (int)a3.get(MonsterDropEntry.ALLATORIxDEMO("rVGzoz^O")))));
                        continue block40;
                    }
                }
            }
            return a2;
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return a2;
    }

    public final /* synthetic */ MapleData getItemData(int a22) {
        MapleItemInformationProvider a3;
        MapleData mapleData = null;
        String a22 = "0" + String.valueOf(a22);
        MapleDataDirectoryEntry mapleDataDirectoryEntry = a3.itemData.getRoot();
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry2 : mapleDataDirectoryEntry.getSubdirectories()) {
            for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry2.getFiles()) {
                if (mapleDataFileEntry.getName().equals(a22.substring(0, 4) + ".img")) {
                    mapleData = a3.itemData.getData(mapleDataDirectoryEntry2.getName() + "/" + mapleDataFileEntry.getName());
                    if (mapleData == null) {
                        return null;
                    }
                    mapleData = mapleData.getChildByPath(a22);
                    return mapleData;
                }
                if (!mapleDataFileEntry.getName().equals(a22.substring(1) + ".img")) continue;
                return a3.itemData.getData(mapleDataDirectoryEntry2.getName() + "/" + mapleDataFileEntry.getName());
            }
        }
        mapleDataDirectoryEntry = a3.equipData.getRoot();
        for (MapleDataDirectoryEntry mapleDataDirectoryEntry2 : mapleDataDirectoryEntry.getSubdirectories()) {
            for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry2.getFiles()) {
                if (!mapleDataFileEntry.getName().equals(a22 + ".img")) continue;
                return a3.equipData.getData(mapleDataDirectoryEntry2.getName() + "/" + mapleDataFileEntry.getName());
            }
        }
        return mapleData;
    }

    public /* synthetic */ MapNameData getMapData(int a2) {
        MapleItemInformationProvider a3;
        return a3.MapDataCache.get(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ int getOption(int a22, int a3) {
        MapleItemInformationProvider a4;
        ItemInformation a22 = a4.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        switch (a3) {
            case 1: {
                return a22.option1;
            }
            case 2: {
                return a22.option2;
            }
            case 3: {
                return a22.option3;
            }
        }
        return 0;
    }

    public final /* synthetic */ MapleStatEffect getItemEffectEX(int a2) {
        MapleItemInformationProvider a3;
        MapleStatEffect mapleStatEffect = a3.itemEffectsEx.get(a2);
        if (mapleStatEffect == null) {
            MapleData mapleData = a3.getItemData(a2);
            if (mapleData == null || mapleData.getChildByPath(MapNameData.ALLATORIxDEMO("c5u&U=")) == null) {
                a3.itemEffectsEx.put(a2, null);
                return null;
            }
            mapleStatEffect = MapleStatEffect.loadItemEffectFromData(mapleData.getChildByPath(MonsterDropEntry.ALLATORIxDEMO("LGZTzO")), a2);
            a3.itemEffectsEx.put(a2, mapleStatEffect);
        }
        return mapleStatEffect;
    }

    public final /* synthetic */ Map<String, Integer> getEquipStats(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.equipStats;
    }

    public /* synthetic */ Equip resetEquipStats(Equip a2) {
        MapleItemInformationProvider a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.getEquipById(a2.getItemId());
        a2.reset(equip2);
        return equip2;
    }

    public final /* synthetic */ EnumMap<EquipAdditions, Pair<Integer, Integer>> getEquipAdditions(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.equipAdditions;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ short getModifySlotMax(int a22) {
        s2 = 0;
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapNameData.ALLATORIxDEMO("\u0016U\tU\u0006De:eV\u0017_\b0%g?O,d }!q1q\u001a}*t,v<O6|*d(q=peG\rU\u0017Uey1u(y!0x0z"));
        preparedStatement.setInt(1, a22);
        v0 = a22 = preparedStatement.executeQuery();
        while (v0.next()) {
            v1 = a22;
            v0 = v1;
            s2 = (short)v1.getInt(MonsterDropEntry.ALLATORIxDEMO("QRHDSXKZ^O"));
        }
        preparedStatement.close();
        a22.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block12;
                            }
                            catch (Throwable a22) {
                                throwable.addSuppressed(a22);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (Exception exception) {
                    System.err.println("SlotMax " + exception);
                    exception.printStackTrace();
                }
            }
        }
        return s2;
    }

    public final /* synthetic */ Triple<Integer, Integer, List<Integer>> getQuestItemInfo(int a2) {
        MapleItemInformationProvider a3;
        if (a3.questItems.containsKey(a2)) {
            return a3.questItems.get(a2);
        }
        if (a2 / 10000 != 422 || a3.getItemData(a2) == null) {
            return null;
        }
        MapleData mapleData = a3.getItemData(a2).getChildByPath(MapNameData.ALLATORIxDEMO("y+v*"));
        if (mapleData == null || mapleData.getChildByPath(MonsterDropEntry.ALLATORIxDEMO("TPYLBRRvCZZ")) == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Triple<Integer, Integer, List<Integer>> triple = mapleData.getChildByPath(MapNameData.ALLATORIxDEMO("&\u007f+c0} Y1u("));
        MapleData mapleData2 = null;
        triple = triple.iterator();
        while (triple.hasNext()) {
            MapleData mapleData3 = (MapleData)triple.next();
            int n2 = MapleDataTool.getInt(mapleData3, 0);
            mapleData2 = mapleData3.getChildByPath(String.valueOf(MonsterDropEntry.ALLATORIxDEMO("\u0007")));
            ArrayList<Integer> arrayList2 = arrayList;
            if (mapleData2 != null) {
                arrayList2.add(MapleDataTool.getInt(mapleData2));
                continue;
            }
            arrayList2.add(n2);
        }
        Triple<Integer, Integer, List<Integer>> triple2 = triple = new Triple<Integer, Integer, List<Integer>>(MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("4e c1Y!"), mapleData, 0), MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("RGG"), mapleData, 1), arrayList);
        a3.questItems.put(a2, triple2);
        return triple2;
    }

    public final /* synthetic */ List<Integer> petsCanConsume(int a2) {
        MapleItemInformationProvider mapleItemInformationProvider;
        ArrayList<Integer> arrayList;
        block6: {
            Iterator iterator;
            MapleItemInformationProvider a3;
            if (a3.petsCanConsumeCache.get(a2) != null) {
                return a3.petsCanConsumeCache.get(a2);
            }
            arrayList = new ArrayList<Integer>();
            MapleData mapleData = a3.getItemData(a2);
            if (mapleData == null || mapleData.getChildByPath(MonsterDropEntry.ALLATORIxDEMO("LGZT")) == null) {
                return arrayList;
            }
            Iterator iterator2 = iterator = mapleData.getChildByPath(MapNameData.ALLATORIxDEMO("c5u&")).iterator();
            while (iterator2.hasNext()) {
                MapleData mapleData2 = (MapleData)iterator.next();
                try {
                    Integer.parseInt(mapleData2.getName());
                }
                catch (NumberFormatException numberFormatException) {
                    iterator2 = iterator;
                    continue;
                }
                int n2 = MapleDataTool.getInt(mapleData2, 0);
                if (n2 == 0) {
                    mapleItemInformationProvider = a3;
                    break block6;
                }
                arrayList.add(n2);
                iterator2 = iterator;
            }
            mapleItemInformationProvider = a3;
        }
        mapleItemInformationProvider.petsCanConsumeCache.put(a2, arrayList);
        return arrayList;
    }

    public final /* synthetic */ boolean canScroll(int a2, int a3) {
        return a2 / 100 % 100 == a3 / 10000 % 100 || a3 >= 1672000 && a3 <= 1672010;
    }

    public final /* synthetic */ int getBagType(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        return a22.flag & 0xF;
    }

    public final /* synthetic */ short getItemMakeLevel(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return 0;
        }
        return a22.itemMakeLevel;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void loadEtc(boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[TRYBLOCK]
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

    public /* synthetic */ List<Integer> getNormalCashEquip() {
        MapleItemInformationProvider a2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry<Integer, ItemInformation> entry : a2.dataCache.entrySet()) {
            int n2 = entry.getKey();
            if ((GameConstants.getInventoryType(n2) != MapleInventoryType.EQUIP || !a2.isCash(n2)) && !ItemConstants.\u985e\u578b.\u5bf5\u7269((int)n2) && !ItemConstants.\u985e\u578b.\u98db\u93e2\u7279\u6548((int)n2) && !ItemConstants.\u985e\u578b.\u7279\u6548((int)n2) && !ItemConstants.\u985e\u578b.\u5bf5\u7269\u88dd((int)n2) && !ItemConstants.\u985e\u578b.\u8868\u60c5((int)n2)) continue;
            entry = entry.getValue();
            if (((ItemInformation)entry).equipStats.size() == 1) {
                arrayList.add(n2);
                continue;
            }
            if (!ItemConstants.\u985e\u578b.\u5bf5\u7269\u88dd((int)n2) || ((ItemInformation)entry).equipStats.size() != 2) continue;
            arrayList.add(n2);
        }
        return arrayList;
    }

    public final /* synthetic */ boolean isDropRestricted(int a2) {
        MapleItemInformationProvider a3;
        ItemInformation itemInformation = a3.getItemInformation(a2);
        if (itemInformation == null) {
            return false;
        }
        boolean bl = (itemInformation.flag & 0x200) != 0;
        boolean bl2 = bl = (itemInformation.flag & 0x400) != 0;
        return (itemInformation.flag & 0x200) != 0 || (itemInformation.flag & 0x400) != 0 || GameConstants.isDropRestricted(a2);
    }

    public final /* synthetic */ boolean isQuestItem(int a2) {
        MapleItemInformationProvider a3;
        ItemInformation itemInformation = a3.getItemInformation(a2);
        if (itemInformation == null) {
            return false;
        }
        return (itemInformation.flag & 0x200) != 0 && a2 / 10000 != 301;
    }

    public /* synthetic */ boolean isUntradeableOnEquip(int a2) {
        boolean bl;
        MapleItemInformationProvider a3;
        if (a3.onEquipUntradableCache.containsKey(a2)) {
            return a3.onEquipUntradableCache.get(a2);
        }
        boolean bl2 = bl = MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("y+v*? a0y5D7q!u\u0007|*s."), a3.getItemData(a2), 0) > 0;
        a3.onEquipUntradableCache.put(a2, bl2);
        return bl2;
    }

    public /* synthetic */ boolean isNoCursedScroll(int a2) {
        boolean bl;
        MapleItemInformationProvider a3;
        if (a3.noCursedScroll.containsKey(a2)) {
            return a3.noCursedScroll.get(a2);
        }
        if (a2 / 10000 != 204) {
            return false;
        }
        boolean bl2 = bl = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018QX|BMDZS"), a3.getItemData(a2), 0) > 0;
        a3.noCursedScroll.put(a2, bl2);
        return bl2;
    }

    public /* synthetic */ IItem scrollPotentialAdd(IItem a2, IItem a32, MapleCharacter a4) {
        int n2;
        if (a2.getType() != 1) {
            return a2;
        }
        if (((Equip)(a2 = (Equip)a2)).getAddState() != 0) {
            return a2;
        }
        int n3 = a32.getItemId();
        int n4 = 0;
        switch (n3) {
            case 2048306: 
            case 2048307: 
            case 2048315: {
                n4 = 100;
                break;
            }
            case 2048313: {
                n4 = 80;
                break;
            }
            case 2048305: {
                while (false) {
                }
                n4 = 70;
                break;
            }
            case 2048309: 
            case 2048310: 
            case 2048314: {
                n4 = 60;
                break;
            }
            case 2048308: 
            case 2048311: {
                n4 = 50;
                break;
            }
            case 2048312: {
                n4 = 1;
            }
        }
        int n5 = 0;
        switch (n3) {
            case 2048305: 
            case 2048310: {
                while (false) {
                }
                n5 = 100;
                n2 = n4;
                break;
            }
            case 2048308: 
            case 2048311: {
                n5 = 50;
            }
            default: {
                n2 = n4;
            }
        }
        if (n2 <= 0) {
            MapleItemInformationProvider a5;
            a4.dropMessage(1, "\u5377\u8ef8\u9053\u5177: " + a32.getItemId() + " - " + a5.getName(a32.getItemId()) + " \u6210\u529f\u5e7e\u7387\u70ba: " + n4 + " \u8a72\u5377\u8ef8\u53ef\u80fd\u9084\u672a\u4fee\u5fa9\u3002");
            a4.getClient().sendPacket(MaplePacketCreator.enableActions());
            return a2;
        }
        if (a4.isAdmin()) {
            int n6 = n5;
            a4.dropMessage(-5, "\u9644\u52a0\u6f5b\u80fd\u5377\u8ef8 - \u6210\u529f\u5e7e\u7387: " + n4 + "% \u5931\u6557\u6d88\u5931\u5e7e\u7387: " + n6 + "% \u5377\u8ef8\u662f\u5426\u5931\u6557\u4e0d\u6d88\u5931\u88dd\u5099: " + (n6 <= 0));
        }
        if (Randomizer.nextInt(100) <= n4) {
            int a32 = Randomizer.nextInt(100) < 10 ? (Randomizer.nextInt(100) < 5 ? -19 : -18) : -17;
            ((Equip)a2).setPotential4(a32);
            if (n3 == 2048306) {
                ((Equip)a2).setPotential5(a32);
            }
        } else if (Randomizer.nextInt(99) < n5) {
            return null;
        }
        return a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ List<Integer> getRechargeItems() {
        linkedList = new LinkedList<Integer>();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapNameData.ALLATORIxDEMO("\u0016U\tU\u0006De:eV\u0017_\b0%g?O7u&x$b\"u,d }%"));
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            v1 = resultSet;
            v0 = v1;
            linkedList.add(v1.getInt(MonsterDropEntry.ALLATORIxDEMO("VCZZVS")));
        }
        preparedStatement.close();
        resultSet.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block12: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v2 = throwable;
                                break block12;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v2 = throwable;
                    }
                    throw v2;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return linkedList;
    }

    public final /* synthetic */ Equip randomizeStats_scroll(Equip a2, int a3, int a4) {
        MapleItemInformationProvider a5;
        Equip equip = a2;
        MapleItemInformationProvider mapleItemInformationProvider = a5;
        Equip equip2 = a2;
        Equip equip3 = a2;
        Equip equip4 = a2;
        MapleItemInformationProvider mapleItemInformationProvider2 = a5;
        Equip equip5 = a2;
        Equip equip6 = a2;
        Equip equip7 = a2;
        MapleItemInformationProvider mapleItemInformationProvider3 = a5;
        Equip equip8 = a2;
        Equip equip9 = a2;
        Equip equip10 = a2;
        MapleItemInformationProvider mapleItemInformationProvider4 = a5;
        Equip equip11 = a2;
        Equip equip12 = a2;
        equip12.setStr(a5.ALLATORIxDEMO(equip12.getStr(), 5));
        equip11.setDex(a5.ALLATORIxDEMO(equip11.getDex(), 5));
        equip10.setInt(mapleItemInformationProvider4.ALLATORIxDEMO(equip11.getInt(), 5));
        equip9.setLuk(mapleItemInformationProvider4.ALLATORIxDEMO(equip10.getLuk(), 5));
        equip9.setMatk(a5.ALLATORIxDEMO(equip9.getMatk(), 5));
        equip8.setWatk(a5.ALLATORIxDEMO(equip8.getWatk(), 5));
        equip7.setAcc(mapleItemInformationProvider3.ALLATORIxDEMO(equip8.getAcc(), 5));
        equip6.setAvoid(mapleItemInformationProvider3.ALLATORIxDEMO(equip7.getAvoid(), 5));
        equip6.setJump(a5.ALLATORIxDEMO(equip6.getJump(), 5));
        equip5.setHands(a5.ALLATORIxDEMO(equip5.getHands(), 5));
        equip4.setSpeed(mapleItemInformationProvider2.ALLATORIxDEMO(equip5.getSpeed(), 5));
        equip3.setWdef(mapleItemInformationProvider2.ALLATORIxDEMO(equip4.getWdef(), 10));
        equip3.setMdef(a5.ALLATORIxDEMO(equip3.getMdef(), 10));
        equip2.setHp(a5.ALLATORIxDEMO(equip2.getHp(), 10));
        equip.setMp(mapleItemInformationProvider.ALLATORIxDEMO(equip2.getMp(), 10));
        a3 = (byte)mapleItemInformationProvider.ALLATORIxDEMO(equip.getUpgradeSlots(), a3, a4);
        if (GameSetConstants.UPGRADESLOT_CHECK && (a3 > 22 || a3 < 0)) {
            System.out.println("\u885d\u6372\u6578\u76ee\u7570\u5e38,[\u7269\u54c1]" + a2.getItemName() + "[\u885d\u6372\u6578]" + (byte)a3);
            FileoutputUtil.logToFile(MapNameData.ALLATORIxDEMO("|*w6?\u0007E\u0002?7q+t*},j C1q1c\u001ac&b*|)>1h1"), "\u885d\u6372\u6578\u76ee\u7570\u5e38,[\u7269\u54c1]" + a2.getItemName() + "[\u885d\u6372\u6578]" + (byte)a3);
            a3 = 0;
        }
        Equip equip13 = a2;
        equip13.setUpgradeSlots((byte)a3);
        return equip13;
    }

    public final /* synthetic */ String getMsg(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.msg;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ boolean isTwoHanded(int a2) {
        MapleItemInformationProvider a3;
        switch (1.ALLATORIxDEMO[a3.getWeaponType(a2).ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return true;
            }
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ IItem scrollEnhance(IItem a, IItem a, MapleCharacter a) {
        if (a.getType() != 1) {
            return a;
        }
        var4_7 = (Equip)a;
        if (var4_7.getEnhance() >= GameConstants.getEnchantSstarts(a.getReqLevel(var4_7.getItemId()), a.isSuperiorEquip(var4_7.getItemId()))) {
            return a;
        }
        var5_8 = a.getItemId();
        v0 = a;
        var6_9 = v0.getEquipStats(var5_8);
        var7_11 = v0.isNoCursedScroll(var5_8);
        var5_8 = v0.getForceUpgrade(var5_8);
        v1 = var8_12 = var6_9 == null || var6_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("DJT\\RLD")) == false ? 0 : var6_9.get(MapNameData.ALLATORIxDEMO("6e&s c6"));
        var9_13 = var7_11 != false ? 0 : (var6_9 == null || var6_9.containsKey(MonsterDropEntry.ALLATORIxDEMO("\\BMDZS")) == false ? 100 : var6_9.get(MapNameData.ALLATORIxDEMO("s0b6u!")));
        var6_10 = a.getTrait(MapleTrait.MapleTraitType.\u624b\u85dd).getLevel() / 10;
        if (var5_8 == 1 && var8_12 == 0) {
            if (a.getItemId() == 2049301 || a.getItemId() == 2049307) {
                v2 = 80;
                v3 = var4_7;
            } else {
                v2 = 100;
                v3 = var4_7;
            }
            var8_12 = Math.max(v2 - v3.getEnhance() * 10, 5);
        }
        v4 = var8_12;
        var10_14 = v4 + v4 * var6_10 / 100;
        var8_12 = a.getItemId() == 2049302 ? 100 : var8_12;
        var10_14 = a.getItemId() == 2049302 ? 100 : var10_14;
        v5 = var9_13 = a.getItemId() == 2049302 ? 0 : var9_13;
        if (a.isAdmin()) {
            a.dropMessage(-5, "\u88dd\u5099\u5f37\u5316\u5377\u8ef8 - \u9ed8\u8a8d\u5e7e\u7387: " + var8_12 + "% \u50be\u5411\u52a0\u6210: " + var6_10 + "% \u6700\u7d42\u5e7e\u7387: " + var10_14 + "% \u5931\u6557\u6d88\u5931\u5e7e\u7387: " + var9_13 + "% \u5377\u8ef8\u662f\u5426\u5931\u6557\u4e0d\u6d88\u5931\u88dd\u5099: " + var7_11);
        }
        if (var4_7.getEnhance() >= 1 && var5_8 > 1) {
            return a;
        }
        if (Randomizer.nextInt(100) > var10_14) {
            if (Randomizer.nextInt(99) >= var9_13) return var4_7;
            return null;
        }
        a = a.isSuperiorEquip(var4_7.getItemId()) != false ? 3 : 0;
        a = a.isSuperiorEquip(var4_7.getItemId()) != false ? 8 : 5;
        v6 = a = 0;
        while (v6 < var5_8) {
            if (var4_7.getStr() > 0 || Randomizer.nextInt(50) == 1) {
                v7 = var4_7;
                v7.setStr((short)(v7.getStr() + Randomizer.rand(a, a)));
            }
            if (var4_7.getDex() > 0 || Randomizer.nextInt(50) == 1) {
                v8 = var4_7;
                v8.setDex((short)(v8.getDex() + Randomizer.rand(a, a)));
            }
            if (var4_7.getInt() > 0 || Randomizer.nextInt(50) == 1) {
                v9 = var4_7;
                v9.setInt((short)(v9.getInt() + Randomizer.rand(a, a)));
            }
            if (var4_7.getLuk() > 0 || Randomizer.nextInt(50) == 1) {
                v10 = var4_7;
                v10.setLuk((short)(v10.getLuk() + Randomizer.rand(a, a)));
            }
            if (var4_7.getWatk() <= 0 || !GameConstants.isWeapon(var4_7.getItemId())) ** GOTO lbl68
            if (var4_7.getWatk() < 150) {
                v11 = var4_7;
                v12 = v11;
                v11.setWatk((short)(v11.getWatk() + 3));
            } else if (var4_7.getWatk() < 200) {
                v13 = var4_7;
                v12 = v13;
                v13.setWatk((short)(v13.getWatk() + 4));
            } else if (var4_7.getWatk() < 250) {
                v14 = var4_7;
                v12 = v14;
                v14.setWatk((short)(v14.getWatk() + 5));
            } else {
                v15 = var4_7;
                v15.setWatk((short)(v15.getWatk() + 5 + (Randomizer.nextBoolean() != false ? 1 : 0)));
lbl68:
                // 2 sources

                v12 = var4_7;
            }
            if (v12.getMatk() <= 0 || !GameConstants.isWeapon(var4_7.getItemId())) ** GOTO lbl97
            if (var4_7.getMatk() < 50) {
                v16 = var4_7;
                v17 = v16;
                v16.setMatk((short)(v16.getMatk() + 1));
            } else if (var4_7.getMatk() < 100) {
                v18 = var4_7;
                v17 = v18;
                v18.setMatk((short)(v18.getMatk() + 2));
            } else if (var4_7.getMatk() < 150) {
                v19 = var4_7;
                v17 = v19;
                v19.setMatk((short)(v19.getMatk() + 3));
            } else if (var4_7.getMatk() < 200) {
                v20 = var4_7;
                v17 = v20;
                v20.setMatk((short)(v20.getMatk() + 4));
            } else if (var4_7.getMatk() < 250) {
                v21 = var4_7;
                v17 = v21;
                v21.setMatk((short)(v21.getMatk() + 5));
            } else {
                v22 = var4_7;
                v22.setMatk((short)(v22.getMatk() + 5 + (Randomizer.nextBoolean() != false ? 1 : 0)));
lbl97:
                // 2 sources

                v17 = var4_7;
            }
            if (v17.getWdef() > 0 || Randomizer.nextInt(40) == 1) {
                v23 = var4_7;
                v23.setWdef((short)(v23.getWdef() + Randomizer.nextInt(5)));
            }
            if (var4_7.getMdef() > 0 || Randomizer.nextInt(40) == 1) {
                v24 = var4_7;
                v24.setMdef((short)(v24.getMdef() + Randomizer.nextInt(5)));
            }
            if (var4_7.getAcc() > 0 || Randomizer.nextInt(20) == 1) {
                v25 = var4_7;
                v25.setAcc((short)(v25.getAcc() + Randomizer.nextInt(5)));
            }
            if (var4_7.getAvoid() > 0 || Randomizer.nextInt(20) == 1) {
                v26 = var4_7;
                v26.setAvoid((short)(v26.getAvoid() + Randomizer.nextInt(5)));
            }
            if (var4_7.getSpeed() > 0 || Randomizer.nextInt(10) == 1) {
                v27 = var4_7;
                v27.setSpeed((short)(v27.getSpeed() + Randomizer.nextInt(5)));
            }
            if (var4_7.getJump() > 0 || Randomizer.nextInt(10) == 1) {
                v28 = var4_7;
                v28.setJump((short)(v28.getJump() + Randomizer.nextInt(5)));
            }
            if (var4_7.getHp() > 0 || Randomizer.nextInt(5) == 1) {
                v29 = var4_7;
                v29.setHp((short)(v29.getHp() + Randomizer.rand(a, a)));
            }
            if (var4_7.getMp() > 0 || Randomizer.nextInt(5) == 1) {
                v30 = var4_7;
                v30.setMp((short)(v30.getMp() + Randomizer.rand(a, a)));
            }
            v31 = var4_7;
            v31.setEnhance((byte)(v31.getEnhance() + 1));
            v6 = ++a;
        }
        return var4_7;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void loadItems(boolean a) {
        if (a) {
            a.dataCache.clear();
        }
        if (!a.dataCache.isEmpty()) {
            return;
        }
        try {
            a = DBConPool.getInstance().getDataSource().getConnection();
            try {
                var2_4 = a.prepareStatement(MapNameData.ALLATORIxDEMO("\u0016U\tU\u0006De:eV\u0017_\b02j\u001ay1u(t$d$"));
                v0 = var3_6 = var2_4.executeQuery();
                while (v0.next()) {
                    v1 = var3_6;
                    v0 = v1;
                    a.initItemInformation(v1);
                }
                var3_6.close();
                var2_4.close();
                var2_4 = a.prepareStatement(MonsterDropEntry.ALLATORIxDEMO("lrsr|c\u001f\u001d\u001fqmxr\u0017HM`^KRRRNBVG[VKV\u001fxmsze\u001fuf\u0017VCZZVS"));
                v2 = var3_6 = var2_4.executeQuery();
                while (v2.next()) {
                    v3 = var3_6;
                    v2 = v3;
                    a.initItemEquipData(v3);
                }
                var3_6.close();
                var2_4.close();
                var2_4 = a.prepareStatement(MapNameData.ALLATORIxDEMO("C\u0000\\\u0000S\u00110o0\u0003B\n]eg?O,d }$t!t$d$0\nB\u0001U\u00170\u0007Iey1u(y!"));
                v4 = var3_6 = var2_4.executeQuery();
                while (v4.next()) {
                    v5 = var3_6;
                    v4 = v5;
                    a.initItemAddData(v5);
                }
                var3_6.close();
                var2_4.close();
                var2_4 = a.prepareStatement(MonsterDropEntry.ALLATORIxDEMO("dz{ztk\u0017\u0015\u0017yepz\u001f@EhVCZZMRHVMS[VKV\u001fxmsze\u001fuf\u0017VCZZVS"));
                v6 = var3_6 = var2_4.executeQuery();
                while (v6.next()) {
                    v7 = var3_6;
                    v6 = v7;
                    a.initItemRewardData(v7);
                }
                var3_6.close();
                var2_4.close();
                for (Map.Entry<Integer, ItemInformation> var5_9 : a.dataCache.entrySet()) {
                    if (GameConstants.getInventoryType(var5_9.getKey()) != MapleInventoryType.EQUIP) continue;
                    a.finalizeEquipData(var5_9.getValue());
                }
                ** if (a == null) goto lbl-1000
            }
            catch (Throwable var2_5) {
                if (a != null) {
                    try {
                        a.close();
                        v8 = var2_5;
                        throw v8;
                    }
                    catch (Throwable var3_7) {
                        var2_5.addSuppressed(var3_7);
                    }
                }
                v8 = var2_5;
                throw v8;
            }
lbl-1000:
            // 1 sources

            {
                a.close();
            }
lbl-1000:
            // 2 sources

            {
            }
        }
        catch (SQLException a) {
            // empty catch block
        }
        a.ModifySlotMax();
    }

    public final /* synthetic */ int getReqJob(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRN}PU"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\u000f\u007f'"));
    }

    public final /* synthetic */ List<Integer> getEquipSkills(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.incSkill;
    }

    public /* synthetic */ boolean isNegativeScroll(int a2) {
        boolean bl;
        MapleItemInformationProvider a3;
        if (a3.noNegativeScroll.containsKey(a2)) {
            return a3.noNegativeScroll.get(a2);
        }
        if (a2 / 10000 != 204) {
            return false;
        }
        boolean bl2 = bl = MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018QXqRXVK^IR"), a3.getItemData(a2), 0) > 0;
        a3.noNegativeScroll.put(a2, bl2);
        return bl2;
    }

    public final /* synthetic */ boolean isOnlyTradeBlock(int a22) {
        MapleItemInformationProvider a3;
        MapleData a22 = a3.getItemData(a22);
        boolean bl = false;
        if (MapleDataTool.getIntConvert(MonsterDropEntry.ALLATORIxDEMO("^QQP\u0018KE^SZuSX\\\\"), a22, 0) == 1) {
            bl = true;
        }
        return bl;
    }

    public final /* synthetic */ IItem getEquipById(int a22, int a3) {
        MapleItemInformationProvider a4;
        MapleItemInformationProvider mapleItemInformationProvider = a4;
        ItemInformation itemInformation = mapleItemInformationProvider.getItemInformation(a22);
        Map<String, Integer> map = mapleItemInformationProvider.getEquipStats(a22);
        if (itemInformation == null || itemInformation.eq == null) {
            return new Equip(a22, 0, a3, (int)0);
        }
        ItemInformation itemInformation2 = itemInformation;
        IItem a22 = itemInformation2.eq.copy();
        if (itemInformation2.option1 > 0 && a4.getPotentialInfo(itemInformation.option1) != null) {
            ((Equip)a22).setPotential1(itemInformation.option1);
        }
        if (itemInformation.option2 > 0 && a4.getPotentialInfo(itemInformation.option2) != null) {
            ((Equip)a22).setPotential2(itemInformation.option2);
        }
        if (itemInformation.option3 > 0 && a4.getPotentialInfo(itemInformation.option3) != null) {
            ((Equip)a22).setPotential3(itemInformation.option3);
        }
        IItem iItem = a22;
        iItem.setUniqueId(a3);
        return iItem;
    }

    public final /* synthetic */ int getSlots(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("CJT"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("1e&"));
    }

    public final /* synthetic */ int getReqDex(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRNszo"))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\u0001U\u001d"));
    }

    public final /* synthetic */ StructSetItem getSetItem(int a2) {
        MapleItemInformationProvider a3;
        return a3.setItems.get(a2);
    }

    public final /* synthetic */ List<Integer> getChairRandEffect(int a2) {
        MapleItemInformationProvider a3;
        if (a2 / 10000 != 301) {
            return null;
        }
        if (a3.chairRandEffect.containsKey(a2)) {
            return a3.chairRandEffect.get(a2);
        }
        Object object = a3.getItemData(a2).getChildByPath(MapNameData.ALLATORIxDEMO("y+v*")).getChildByPath(MonsterDropEntry.ALLATORIxDEMO("MVQSzQYR\\C"));
        if (object == null) {
            a3.chairRandEffect.put(a2, null);
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Object object2 = object = object.getChildren().iterator();
        while (object2.hasNext()) {
            MapleData mapleData = (MapleData)object.next();
            object2 = object;
            arrayList.add(MapleDataTool.getIntConvert(MapNameData.ALLATORIxDEMO("`7\u007f'"), mapleData));
        }
        a3.chairRandEffect.put(a2, arrayList);
        return arrayList;
    }

    private /* synthetic */ short ALLATORIxDEMO(short a2, int a3) {
        if (a2 == 0) {
            return 0;
        }
        a3 = (int)Math.min(Math.ceil((double)a2 * 0.1), (double)a3);
        return (short)((double)(a2 - a3) + Math.floor(Math.random() * (double)(a3 * 2 + 1)));
    }

    public final /* synthetic */ String getDesc(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return null;
        }
        return a22.desc;
    }

    public final /* synthetic */ boolean isLogoutExpire(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return false;
        }
        return (a22.flag & 0x20) != 0;
    }

    public final /* synthetic */ List<Equip> getAllEquips() {
        MapleItemInformationProvider a2;
        if (a2.allEquips.size() > 0) {
            return a2.allEquips;
        }
        for (Map.Entry<Integer, ItemInformation> entry : a2.dataCache.entrySet()) {
            if (GameConstants.getInventoryType(entry.getKey()) != MapleInventoryType.EQUIP || entry.getValue() == null || entry.getValue().eq == null) continue;
            a2.allEquips.add(entry.getValue().eq);
        }
        return a2.allEquips;
    }

    public final /* synthetic */ short getRandStatFusion(short a2, int a3, int a4) {
        if (a2 == 0) {
            return 0;
        }
        a3 = (a3 + a4) / 2 - a2;
        a4 = Randomizer.nextInt(Math.abs(a3) + 1);
        return (short)(a2 + (a3 < 0 ? -a4 : a4));
    }

    private /* synthetic */ short ALLATORIxDEMO(short a2, int a3, int a4) {
        if (a2 == 0) {
            return 0;
        }
        if ((a2 = (short)(a2 + Randomizer.rand(a3, a4))) >= 0) {
            return a2;
        }
        return 0;
    }

    public final /* synthetic */ boolean isKarmaEnabled(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return false;
        }
        if (GameSetConstants.PKARMACANCUT) {
            return a22.karmaEnabled >= 1;
        }
        return a22.karmaEnabled == 1;
    }

    public final /* synthetic */ int getReqLevel(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("MRN{ZAZ["))) {
            return 0;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("b a\tu3u)"));
    }

    public final /* synthetic */ Map<Integer, Map<String, Integer>> getEquipIncrements(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null || a22.equipIncs == null) {
            return new LinkedHashMap<Integer, Map<String, Integer>>();
        }
        return a22.equipIncs;
    }

    public /* synthetic */ String getMapName(int a22) {
        MapleItemInformationProvider a3;
        MapNameData a22 = a3.MapDataCache.get(a22);
        if (a22 == null) {
            return "";
        }
        return a22.getMapName();
    }

    public static final /* synthetic */ MapleItemInformationProvider getInstance() {
        return d;
    }

    public final /* synthetic */ Map<Integer, Map<Integer, StructPotentialItem>> getAllPotentialInfo() {
        MapleItemInformationProvider a2;
        return a2.potentialCache;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ IItem scrollPotential(IItem a, IItem a, MapleCharacter a) {
        block27: {
            block26: {
                if (a.getType() != 1) {
                    return a;
                }
                a = (Equip)a;
                var4_5 = a.getItemId();
                var5_6 = a.getEquipStats(var4_5);
                var6_7 = a.isNoCursedScroll(var4_5);
                var7_8 = 0;
                var8_9 = 100;
                if (var4_5 / 100 != 20494) break block26;
                var9_10 = MonsterDropEntry.ALLATORIxDEMO("\u6651\u902d");
                var8_9 = var6_7 != false ? 0 : 100;
                switch (var4_5) {
                    case 2049402: 
                    case 2049404: 
                    case 2049405: 
                    case 2049406: 
                    case 2049414: 
                    case 2049415: 
                    case 2049417: 
                    case 2049419: 
                    case 2049423: {
                        var7_8 = 100;
                        v0 = var4_5;
                        break;
                    }
                    case 2049400: 
                    case 2049407: 
                    case 2049412: {
                        var7_8 = 90;
                        v0 = var4_5;
                        break;
                    }
                    case 2049421: 
                    case 2049424: {
                        var7_8 = 80;
                        v0 = var4_5;
                        break;
                    }
                    case 2049401: 
                    case 2049408: 
                    case 2049416: {
                        var7_8 = 70;
                        v0 = var4_5;
                        break;
                    }
                    default: {
                        if (a.getItemId() >= 2049427 && a.getItemId() <= 2049446) {
                            var7_8 = 100;
                        }
                        v0 = var4_5;
                    }
                }
                switch (v0) {
                    case 2049404: 
                    case 2049405: 
                    case 2049414: 
                    case 2049415: 
                    case 2049421: 
                    case 2049423: 
                    case 2049424: 
                    case 2049426: 
                    case 2049427: {
                        var9_10 = MapNameData.ALLATORIxDEMO("\u5c18\u756d");
                        var8_9 = 0;
                        break;
                    }
                }
                if (a.getItemId() < 2049427 || a.getItemId() > 2049446) ** GOTO lbl66
                var9_10 = MonsterDropEntry.ALLATORIxDEMO("\u5c37\u751f");
                var8_9 = 0;
                v1 = a;
                break block27;
            }
            if (var4_5 / 100 == 20497) {
                v2 = var7_8 = var5_6 == null || var5_6.containsKey(MapNameData.ALLATORIxDEMO("6e&s c6")) == false ? 0 : var5_6.get(MonsterDropEntry.ALLATORIxDEMO("DJT\\RLD"));
                v3 = var6_7 != false ? 0 : (var8_9 = var5_6 == null || var5_6.containsKey(MapNameData.ALLATORIxDEMO("s0b6u!")) == false ? 0 : var5_6.get(MonsterDropEntry.ALLATORIxDEMO("\\BMDZS")));
                if (var4_5 >= 2049700 && var4_5 < 2049750) {
                    var9_10 = MapNameData.ALLATORIxDEMO("\u7269\u6bcf");
                    v1 = a;
                } else if (var4_5 >= 2049750 && var4_5 < 2049759) {
                    var9_10 = MonsterDropEntry.ALLATORIxDEMO("\u7f6a\u89bc");
                    v1 = a;
                } else if (var4_5 == 2049780 || var4_5 == 2049782) {
                    var9_10 = MapNameData.ALLATORIxDEMO("\u50a3\u8aef");
                    v1 = a;
                } else {
                    var7_8 = 0;
                    var9_10 = MonsterDropEntry.ALLATORIxDEMO("\u6715\u77d2");
                    v1 = a;
                }
            } else {
                var9_10 = MapNameData.ALLATORIxDEMO("\u673a\u77a0");
lbl66:
                // 2 sources

                v1 = a;
            }
        }
        if (v1.isAdmin()) {
            a.dropMessage(-5, var9_10 + "\u6f5b\u80fd\u9644\u52a0\u6372\u8ef8 - \u6210\u529f\u5e7e\u7387: " + var7_8 + "% \u5931\u6557\u6d88\u5931\u5e7e\u7387: " + var8_9 + "% \u5377\u8ef8\u662f\u5426\u5931\u6557\u4e0d\u6d88\u5931\u88dd\u5099: " + var6_7);
        }
        if (var7_8 <= 0) {
            a.dropMessage(1, "\u5377\u8ef8\u9053\u5177: " + a.getItemId() + " - " + a.getName(a.getItemId()) + " \u6210\u529f\u5e7e\u7387\u70ba: " + var7_8 + " \u8a72\u5377\u8ef8\u53ef\u80fd\u9084\u672a\u4fee\u5fa9\u3002");
            a.getClient().sendPacket(MaplePacketCreator.enableActions());
            return a;
        }
        if (a.getState() != 0) {
            return a;
        }
        if (Randomizer.nextInt(100) > var7_8) {
            if (Randomizer.nextInt(99) >= var8_9) return a;
            return null;
        }
        if (var4_5 >= 2049700 && var4_5 < 2049750) {
            v4 = a;
            v4.resetPotentialA();
            return v4;
        }
        if (var4_5 >= 2049750 && var4_5 < 2049759) {
            v5 = a;
            v5.resetPotentialS();
            return v5;
        }
        if (var4_5 != 2049419) {
            v6 = a;
            v6.resetPotential();
            return v6;
        }
        a = Randomizer.nextInt(100) < 10 ? (Randomizer.nextInt(100) < 5 ? -19 : -18) : -17;
        v7 = a;
        v8 = a;
        a.setPotential1(v8);
        v7.setPotential2(v8);
        v7.setPotential3(a);
        return v7;
    }

    public final /* synthetic */ boolean isAccountShared(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return false;
        }
        return (a22.flag & 0x100) != 0;
    }

    public final /* synthetic */ ItemInformation getItemInformation(int a2) {
        MapleItemInformationProvider a3;
        if (a2 <= 0) {
            return null;
        }
        return a3.dataCache.get(a2);
    }

    public final /* synthetic */ MapleStatEffect getItemEffect(int a2) {
        MapleItemInformationProvider a3;
        return a3.getItemEffect(null, a2);
    }

    public final /* synthetic */ int getWholePrice(int a22) {
        MapleItemInformationProvider a3;
        ItemInformation a22 = a3.getItemInformation(a22);
        if (a22 == null) {
            return -1;
        }
        return a22.wholePrice;
    }

    public final /* synthetic */ int getNickSkill(int a2) {
        MapleItemInformationProvider a3;
        if (a3.getEquipStats(a2) == null || !a3.getEquipStats(a2).containsKey(MonsterDropEntry.ALLATORIxDEMO("DZCvCZZvs"))) {
            return -1;
        }
        return a3.getEquipStats(a2).get(MapNameData.ALLATORIxDEMO("+y&{\u0016{,|)"));
    }
}

