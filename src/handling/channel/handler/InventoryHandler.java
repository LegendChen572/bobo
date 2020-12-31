/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleStat;
import client.MapleTrait;
import client.PlayerStats;
import client.SkillFactory;
import client.anticheat.CheatingOffense;
import client.innerSkills.InnerAbillity;
import client.innerSkills.InnerSkillValueHolder;
import client.inventory.CheckItemFactory;
import client.inventory.Equip;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.ItemFlag;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.inventory.MapleMount;
import client.inventory.MaplePet;
import client.inventory.ModifyInventory;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import constants.JobConstants;
import constants.MapConstants;
import constants.PiPiConfig;
import constants.ServerConfig;
import handling.cashshop.handler.CashShopOperation;
import handling.channel.ChannelServer;
import handling.login.LoginServer;
import handling.opcodes.VegaScrollType;
import handling.world.MapleAntiMacro;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import scripting.item.ItemScriptManager;
import scripting.npc.NPCScriptManager;
import server.AutobanManager;
import server.Extend.SpecialEquipFactory;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleStatEffect;
import server.RandomRewards;
import server.Randomizer;
import server.StructPotentialItem;
import server.StructRewardItem;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.maps.AbstractMapleMapObject;
import server.maps.FieldLimitType;
import server.maps.MapleMap;
import server.maps.MapleMapItem;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.MapleNodes;
import server.maps.SavedLocationType;
import server.quest.MapleQuest;
import server.shops.AbstractPlayerStore;
import server.shops.HiredMerchant;
import server.shops.IMaplePlayerShop;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.Pair;
import tools.data.LittleEndianAccessor;
import tools.packet.MTSCSPacket;
import tools.packet.PlayerShopPacket;
import tools.packet.UIPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class InventoryHandler {
    public static final /* synthetic */ int OWL_ID = 2;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void consumeItem(MapleClient a2, MapleStatEffect a3) {
        if (a3 == null) {
            return;
        }
        if (MapleItemInformationProvider.getInstance().isConsumeOnPickup(a3.getSourceId()) != 2) {
            if (!a2.getPlayer().isAlive()) return;
            a3.applyTo(a2.getPlayer());
            return;
        }
        if (a2.getPlayer().getParty() != null && a2.getPlayer().isAlive()) {
            Iterator<MaplePartyCharacter> iterator = a2.getPlayer().getParty().getMembers().iterator();
            while (iterator.hasNext()) {
                MaplePartyCharacter maplePartyCharacter = iterator.next();
                MapleCharacter mapleCharacter = a2.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId());
                if (mapleCharacter == null || !mapleCharacter.isAlive()) continue;
                a3.applyTo(mapleCharacter);
            }
            return;
        }
        a3.applyTo(a2.getPlayer());
    }

    public static /* synthetic */ boolean useOwlSearch(int a2, byte a32, byte a4, MapleClient a5) {
        ArrayList<HiredMerchant> a32 = new ArrayList<HiredMerchant>();
        for (ChannelServer channelServer : LoginServer.getWorldStatic(a5.getPlayer().getMap().getWorld()).getChannels()) {
            if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20 || channelServer.searchMerchant(a2).isEmpty()) continue;
            a32.addAll(channelServer.searchMerchant(a2));
        }
        if (a5 != null && a32 != null && a32.size() > 0) {
            if (a4 == 0) {
                a5.sendPacket(MaplePacketCreator.getOwlSearched(a2, a32));
            } else if (a4 == 1) {
                a5.sendPacket(MaplePacketCreator.getOwlSearchedAcquisition(a2, a32));
            }
            return true;
        }
        a5.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u6218\u4e3b\u5256\u9065\u5111"));
        return false;
    }

    public static final /* synthetic */ void ItemGather(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        boolean bl = false;
        LittleEndianAccessor littleEndianAccessor = a2;
        a3.getPlayer().updateTick(littleEndianAccessor.readInt());
        byte by = littleEndianAccessor.readByte();
        Object object = MapleInventoryType.getByType(by);
        if (object != null) {
            int n2;
            object = a3.getPlayer().getInventory((MapleInventoryType)((Object)object));
            LinkedList<IItem> linkedList = new LinkedList<IItem>();
            for (IItem iItem : ((MapleInventory)object).list()) {
                if (iItem.getPosition() > 96) continue;
                linkedList.add(iItem);
            }
            linkedList.sort(Comparable::compareTo);
            ArrayList arrayList = new ArrayList();
            int n3 = n2 = 0;
            while (n3 < linkedList.size() - 1) {
                int n4 = n2;
                int n5 = n2 + 1;
                while (n5 < linkedList.size()) {
                    int n6;
                    if (((IItem)linkedList.get(n6)).getItemId() < ((IItem)linkedList.get(n4)).getItemId()) {
                        n4 = n6;
                    }
                    n5 = ++n6;
                }
                if (n4 != n2) {
                    IItem iItem = (IItem)linkedList.get(n2);
                    short s2 = iItem.getPosition();
                    ((MapleInventory)object).move(s2, ((IItem)linkedList.get(n4)).getPosition(), ((MapleInventory)object).getSlotLimit(), a3.getPlayer());
                    arrayList.add(new ModifyInventory(2, iItem, s2));
                    LinkedList<IItem> linkedList2 = linkedList;
                    linkedList2.set(n2, (IItem)linkedList2.get(n4));
                    linkedList.set(n4, iItem);
                    if (ItemConstants.isHarvesting(iItem.getItemId())) {
                        bl = true;
                    }
                }
                n3 = ++n2;
            }
            if (bl) {
                a3.getPlayer().getStat().handleProfessionTool(a3.getPlayer());
            }
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(MaplePacketCreator.modifyInventory(true, arrayList));
            mapleClient.sendPacket(MaplePacketCreator.finishedGather(by));
            a3.sendPacket(MaplePacketCreator.enableActions());
            linkedList.clear();
        }
    }

    public static final /* synthetic */ void SwitchBag(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().hasBlockedInventory()) {
            return;
        }
        MapleClient mapleClient = a3;
        mapleClient.getPlayer().setScrolledPosition((short)0);
        mapleClient.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = (short)littleEndianAccessor.readInt();
        short s3 = (short)littleEndianAccessor.readInt();
        if (s2 < 100 || s3 < 100) {
            return;
        }
        MapleInventoryManipulator.move(a3, MapleInventoryType.ETC, s2, s3, true, true);
    }

    public static final /* synthetic */ void UseItem(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a4 == null || !a4.isAlive() || a4.getMapId() == 749040100 || a4.getMap() == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        long l2 = System.currentTimeMillis();
        if (a4.getNextConsume() > l2) {
            a4.dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u7557\u658a\u51d1\u534d\u6624\u95a5\u5c7c\u671c\u7d36\u6769\uff6a\u6276\u4e83\u7117\u6cb3\u4f49\u754e\u6b52\u9035\u5141\u3064"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = (byte)littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
        if (iItem == null || iItem.getQuantity() < 1 || iItem.getItemId() != n2) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (ItemScriptManager.getInstance().startUseItem(a3, 9010000, iItem)) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (GameSetConstants.MONSTERPET && iItem.getItemId() == 2022193 && (n2 = a4.getMonsterPet(1)) > 0) {
            MapleCharacter mapleCharacter = a4;
            mapleCharacter.addMonsterPetLevel(n2);
            mapleCharacter.dropMessage(1, "\u60a8\u76ee\u524d\u4f7f\u7528\u7684\u7684\u602a\u7269\u5bf5\u7269: " + MapleLifeFactory.getMonster(n2).getStats().getName() + " \u5df2\u5347\u7b49\u4e00\u7d1a!");
        }
        if (!GameSetConstants.isClickGameMap(a4.getMap().getId()) && !a4.getMap().isClickGameMap() && !FieldLimitType.PotionUse.check(a4.getMap().getFieldLimit()) || a4.getMapId() == 610030600 || a4.getMapId() == 105100300) {
            if (MapleItemInformationProvider.getInstance().getItemEffect(a4, iItem.getItemId()).applyTo(a4, true)) {
                if (!GameSetConstants.isNoConsumeItem(iItem.getItemId())) {
                    MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
                }
                if (a4.getMap().getConsumeItemCoolTime() > 0) {
                    MapleCharacter mapleCharacter = a4;
                    mapleCharacter.setNextConsume(l2 + (long)(mapleCharacter.getMap().getConsumeItemCoolTime() * 1000));
                    return;
                }
            }
        } else {
            a3.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public /* synthetic */ InventoryHandler() {
        InventoryHandler a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void useScrollGashaponBox(boolean a2, int a3, int a4, MapleClient a5, MapleCharacter a62) {
        boolean bl;
        if (!MapleItemInformationProvider.getInstance().itemExists(a3) || a3 != 5223000 || a4 > 2) {
            a5.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3 = Randomizer.rand(1, 4);
        int a62 = 2430481;
        int[] arrn = new int[86];
        arrn[0] = 2040002;
        arrn[1] = 2040005;
        arrn[2] = 2040016;
        arrn[3] = 2040026;
        arrn[4] = 2040031;
        arrn[5] = 2040100;
        arrn[6] = 2040105;
        arrn[7] = 2040105;
        arrn[8] = 2040200;
        arrn[9] = 2040205;
        arrn[10] = 2040302;
        arrn[11] = 2040310;
        arrn[12] = 2040318;
        arrn[13] = 2040323;
        arrn[14] = 2040328;
        arrn[15] = 2040329;
        arrn[16] = 2040330;
        arrn[17] = 2040331;
        arrn[18] = 2040402;
        arrn[19] = 2040412;
        arrn[20] = 2040419;
        arrn[21] = 2040422;
        arrn[22] = 2040427;
        arrn[23] = 2040502;
        arrn[24] = 2040505;
        arrn[25] = 2040514;
        arrn[26] = 2040517;
        arrn[27] = 2040534;
        arrn[28] = 2040602;
        arrn[29] = 2040612;
        arrn[30] = 2040617;
        arrn[31] = 2040619;
        arrn[32] = 2040622;
        arrn[33] = 2040627;
        arrn[34] = 2040702;
        arrn[35] = 2040705;
        arrn[36] = 2040708;
        arrn[37] = 2040802;
        arrn[38] = 2040805;
        arrn[39] = 2040816;
        arrn[40] = 2040825;
        arrn[41] = 2040902;
        arrn[42] = 2040915;
        arrn[43] = 2040920;
        arrn[44] = 2040925;
        arrn[45] = 2040928;
        arrn[46] = 2040933;
        arrn[47] = 2041002;
        arrn[48] = 2041005;
        arrn[49] = 2041008;
        arrn[50] = 2041011;
        arrn[51] = 2041014;
        arrn[52] = 2041017;
        arrn[53] = 2041020;
        arrn[54] = 2041023;
        arrn[55] = 2041058;
        arrn[56] = 2043002;
        arrn[57] = 2043008;
        arrn[58] = 2043019;
        arrn[59] = 2043102;
        arrn[60] = 2043114;
        arrn[61] = 2043202;
        arrn[62] = 2043214;
        arrn[63] = 2043302;
        arrn[64] = 2043402;
        arrn[65] = 2043702;
        arrn[66] = 2043802;
        arrn[67] = 2044002;
        arrn[68] = 2044014;
        arrn[69] = 2044015;
        arrn[70] = 2044102;
        arrn[71] = 2044114;
        arrn[72] = 2044202;
        arrn[73] = 2044214;
        arrn[74] = 2044302;
        arrn[75] = 2044314;
        arrn[76] = 2044402;
        arrn[77] = 2044414;
        arrn[78] = 2044502;
        arrn[79] = 2044602;
        arrn[80] = 2044702;
        arrn[81] = 2044802;
        arrn[82] = 2044809;
        arrn[83] = 2044902;
        arrn[84] = 2045202;
        arrn[85] = 2045302;
        int[] arrn2 = arrn;
        int[] arrn3 = new int[78];
        arrn3[0] = 2040001;
        arrn3[1] = 2040004;
        arrn3[2] = 2040017;
        arrn3[3] = 2040025;
        arrn3[4] = 2040029;
        arrn3[5] = 2040101;
        arrn3[6] = 2040106;
        arrn3[7] = 2040201;
        arrn3[8] = 2040206;
        arrn3[9] = 2040301;
        arrn3[10] = 2040311;
        arrn3[11] = 2040317;
        arrn3[12] = 2040321;
        arrn3[13] = 2040326;
        arrn3[14] = 2040401;
        arrn3[15] = 2040413;
        arrn3[16] = 2040418;
        arrn3[17] = 2040421;
        arrn3[18] = 2040425;
        arrn3[19] = 2040501;
        arrn3[20] = 2040504;
        arrn3[21] = 2040513;
        arrn3[22] = 2040516;
        arrn3[23] = 2040532;
        arrn3[24] = 2040613;
        arrn3[25] = 2040618;
        arrn3[26] = 2040621;
        arrn3[27] = 2040701;
        arrn3[28] = 2040704;
        arrn3[29] = 2040707;
        arrn3[30] = 2040801;
        arrn3[31] = 2040804;
        arrn3[32] = 2040817;
        arrn3[33] = 2040824;
        arrn3[34] = 2040901;
        arrn3[35] = 2040914;
        arrn3[36] = 2040919;
        arrn3[37] = 2040924;
        arrn3[38] = 2040927;
        arrn3[39] = 2040931;
        arrn3[40] = 2041001;
        arrn3[41] = 2041004;
        arrn3[42] = 2041007;
        arrn3[43] = 2041010;
        arrn3[44] = 2041013;
        arrn3[45] = 2041016;
        arrn3[46] = 2041019;
        arrn3[47] = 2041022;
        arrn3[48] = 2043001;
        arrn3[49] = 2043009;
        arrn3[50] = 2043017;
        arrn3[51] = 2043101;
        arrn3[52] = 2043112;
        arrn3[53] = 2043201;
        arrn3[54] = 2043212;
        arrn3[55] = 2043301;
        arrn3[56] = 2043701;
        arrn3[57] = 2043801;
        arrn3[58] = 2044001;
        arrn3[59] = 2044012;
        arrn3[60] = 2044101;
        arrn3[61] = 2044112;
        arrn3[62] = 2044201;
        arrn3[63] = 2044212;
        arrn3[64] = 2044301;
        arrn3[65] = 2044312;
        arrn3[66] = 0x1F31F1;
        arrn3[67] = 2044412;
        arrn3[68] = 2044501;
        arrn3[69] = 2044601;
        arrn3[70] = 2044701;
        arrn3[71] = 2044801;
        arrn3[72] = 2044807;
        arrn3[73] = 2044901;
        arrn3[74] = 2045201;
        arrn3[75] = 2046012;
        arrn3[76] = 2046013;
        arrn3[77] = 2046112;
        int[] arrn4 = arrn3;
        int[] arrn5 = new int[75];
        arrn5[0] = 2040009;
        arrn5[1] = 2040011;
        arrn5[2] = 2040013;
        arrn5[3] = 2040015;
        arrn5[4] = 2040030;
        arrn5[5] = 2040103;
        arrn5[6] = 2040108;
        arrn5[7] = 2040203;
        arrn5[8] = 2040208;
        arrn5[9] = 0x1F21F1;
        arrn5[10] = 2040307;
        arrn5[11] = 2040309;
        arrn5[12] = 2040322;
        arrn5[13] = 2040327;
        arrn5[14] = 2040405;
        arrn5[15] = 2040407;
        arrn5[16] = 2040409;
        arrn5[17] = 2040411;
        arrn5[18] = 2040426;
        arrn5[19] = 2040509;
        arrn5[20] = 2040511;
        arrn5[21] = 2040519;
        arrn5[22] = 2040521;
        arrn5[23] = 2040533;
        arrn5[24] = 2040605;
        arrn5[25] = 2040607;
        arrn5[26] = 2040609;
        arrn5[27] = 2040611;
        arrn5[28] = 2040713;
        arrn5[29] = 2040715;
        arrn5[30] = 2040717;
        arrn5[31] = 2040809;
        arrn5[32] = 2040811;
        arrn5[33] = 2040813;
        arrn5[34] = 2040815;
        arrn5[35] = 2040905;
        arrn5[36] = 2040907;
        arrn5[37] = 2040909;
        arrn5[38] = 2040917;
        arrn5[39] = 2040922;
        arrn5[40] = 2040932;
        arrn5[41] = 2041027;
        arrn5[42] = 2041029;
        arrn5[43] = 2041031;
        arrn5[44] = 2041033;
        arrn5[45] = 2041035;
        arrn5[46] = 2041037;
        arrn5[47] = 2041039;
        arrn5[48] = 2041041;
        arrn5[49] = 2043005;
        arrn5[50] = 2043007;
        arrn5[51] = 2043018;
        arrn5[52] = 2043105;
        arrn5[53] = 2043113;
        arrn5[54] = 2043205;
        arrn5[55] = 2043213;
        arrn5[56] = 2043305;
        arrn5[57] = 2043705;
        arrn5[58] = 2043805;
        arrn5[59] = 2044005;
        arrn5[60] = 2044013;
        arrn5[61] = 2044105;
        arrn5[62] = 2044113;
        arrn5[63] = 2044205;
        arrn5[64] = 2044213;
        arrn5[65] = 2044305;
        arrn5[66] = 2044313;
        arrn5[67] = 2044405;
        arrn5[68] = 2044413;
        arrn5[69] = 2044505;
        arrn5[70] = 2044605;
        arrn5[71] = 2044705;
        arrn5[72] = 2044804;
        arrn5[73] = 2044808;
        arrn5[74] = 2044904;
        int[] arrn6 = arrn5;
        int[] arrn7 = new int[75];
        arrn7[0] = 2040008;
        arrn7[1] = 2040010;
        arrn7[2] = 2040012;
        arrn7[3] = 2040014;
        arrn7[4] = 2040028;
        arrn7[5] = 2040104;
        arrn7[6] = 2040109;
        arrn7[7] = 2040204;
        arrn7[8] = 2040209;
        arrn7[9] = 2040304;
        arrn7[10] = 0x1F21F2;
        arrn7[11] = 2040308;
        arrn7[12] = 2040320;
        arrn7[13] = 2040325;
        arrn7[14] = 2040404;
        arrn7[15] = 2040406;
        arrn7[16] = 2040408;
        arrn7[17] = 2040410;
        arrn7[18] = 2040424;
        arrn7[19] = 2040508;
        arrn7[20] = 2040510;
        arrn7[21] = 2040518;
        arrn7[22] = 2040520;
        arrn7[23] = 2040531;
        arrn7[24] = 2040604;
        arrn7[25] = 2040606;
        arrn7[26] = 2040608;
        arrn7[27] = 2040610;
        arrn7[28] = 2040712;
        arrn7[29] = 2040714;
        arrn7[30] = 2040716;
        arrn7[31] = 2040808;
        arrn7[32] = 2040810;
        arrn7[33] = 2040812;
        arrn7[34] = 2040814;
        arrn7[35] = 2040904;
        arrn7[36] = 2040906;
        arrn7[37] = 2040908;
        arrn7[38] = 2040916;
        arrn7[39] = 2040921;
        arrn7[40] = 2040930;
        arrn7[41] = 2041026;
        arrn7[42] = 2041028;
        arrn7[43] = 2041030;
        arrn7[44] = 2041032;
        arrn7[45] = 2041034;
        arrn7[46] = 2041036;
        arrn7[47] = 2041038;
        arrn7[48] = 2041040;
        arrn7[49] = 2043004;
        arrn7[50] = 2043006;
        arrn7[51] = 2043016;
        arrn7[52] = 2043104;
        arrn7[53] = 2043111;
        arrn7[54] = 2043204;
        arrn7[55] = 2043211;
        arrn7[56] = 2043304;
        arrn7[57] = 2043704;
        arrn7[58] = 2043804;
        arrn7[59] = 2044004;
        arrn7[60] = 2044011;
        arrn7[61] = 2044104;
        arrn7[62] = 2044111;
        arrn7[63] = 2044204;
        arrn7[64] = 0x1F3133;
        arrn7[65] = 2044304;
        arrn7[66] = 2044311;
        arrn7[67] = 2044404;
        arrn7[68] = 2044411;
        arrn7[69] = 2044504;
        arrn7[70] = 2044604;
        arrn7[71] = 2044704;
        arrn7[72] = 2044803;
        arrn7[73] = 2044806;
        arrn7[74] = 2044903;
        int[] arrn8 = arrn7;
        switch (a3) {
            case 1: {
                a62 = arrn4[Randomizer.nextInt(arrn4.length)];
                bl = a2;
                break;
            }
            case 2: {
                a62 = arrn2[Randomizer.nextInt(arrn2.length)];
                bl = a2;
                break;
            }
            case 3: {
                a62 = arrn6[Randomizer.nextInt(arrn6.length)];
                bl = a2;
                break;
            }
            case 4: {
                a62 = arrn8[Randomizer.nextInt(arrn8.length)];
            }
            default: {
                bl = a2;
            }
        }
        if (bl) {
            MapleInventoryManipulator.addById(a5, a62, (short)1, "\u734e\u52f5\u7bb1\u7372\u5f97, \u6642\u9593: " + FileoutputUtil.CurrentReadable_Date());
        }
        MapleClient mapleClient = a5;
        mapleClient.sendPacket(MaplePacketCreator.showScrollGashaponBoxResult(a2, a62, a4));
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void removeItemPet(MapleCharacter a2, MapleMapItem a3, int a4) {
        MapleCharacter mapleCharacter = a2;
        MapleMapItem mapleMapItem = a3;
        mapleMapItem.setPickedUp(true);
        mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.removeItemFromMap(a3.getObjectId(), 5, a2.getId(), a4), a3.getPosition());
        mapleCharacter.getMap().removeMapObject(a3);
        if (mapleMapItem.isRandDrop()) {
            a2.getMap().spawnRandDrop();
        }
    }

    public static final /* synthetic */ void UseGashaponTicket(LittleEndianAccessor a2, MapleClient a32) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int a32 = littleEndianAccessor.readInt();
        a32 = littleEndianAccessor.readInt();
        a32.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ boolean handleApReset(short a2, int a3, MapleClient a4, MapleCharacter a5) {
        a5.resetStats(4, 4, 4, 4);
        MapleInventoryManipulator.removeFromSlot(a4, GameConstants.getInventoryType(a3), a2, (short)1, false);
        MapleClient mapleClient = a4;
        mapleClient.sendPacket(MaplePacketCreator.useAPReset(a5.getId()));
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        return true;
    }

    public static final /* synthetic */ void UseMountFood(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        LittleEndianAccessor littleEndianAccessor = a2;
        a3.getPlayer().updateTick(littleEndianAccessor.readInt());
        byte by = (byte)littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
        MapleMount mapleMount = a4.getMount();
        if (iItem != null && iItem.getQuantity() > 0 && iItem.getItemId() == n2 && mapleMount != null) {
            MapleMount mapleMount2 = mapleMount;
            n2 = mapleMount2.getFatigue();
            byte n3 = 0;
            mapleMount2.setFatigue((byte)-30);
            if (n2 > 0) {
                MapleMount mapleMount3 = mapleMount;
                mapleMount3.increaseExp();
                byte by2 = mapleMount3.getLevel();
                n2 = by2;
                if (by2 < 30 && mapleMount.getExp() >= GameConstants.getMountExpNeededForLevel(n2 + 1)) {
                    mapleMount.setLevel((byte)(n2 + 1));
                    n3 = 1;
                }
            }
            a4.getMap().broadcastMessage(MaplePacketCreator.updateMount(a4, n3 != 0));
            MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void handlePickup(MapleClient a, MapleCharacter a, MapleMapObject a, Point a, boolean a) {
        var5_7 = (MapleMapItem)a;
        if (a && var5_7.isPlayerDrop()) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var5_7.isPickedUp()) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (var5_7.getOwner() != a.getId() && (!var5_7.isPlayerDrop() && var5_7.getDropType() == 0 || var5_7.isPlayerDrop() && a.getMap().getEverlast())) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!(var5_7.isPlayerDrop() || var5_7.getDropType() != 1 || var5_7.getOwner() == a.getId() || a.getParty() != null && a.getParty().getMemberById(var5_7.getOwner()) != null)) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a == null) ** GOTO lbl25
        var6_8 = a.distanceSq(var5_7.getPosition());
        v0 = a;
        if (v1 > 2500.0) {
            v0.getCheatTracker().registerOffense(CheatingOffense.ITEMVAC_CLIENT, String.valueOf(var6_8));
            v2 = var5_7;
        } else {
            if (v0.getPosition().distanceSq(var5_7.getPosition()) > 90000.0) {
                a.getCheatTracker().registerOffense(CheatingOffense.ITEMVAC_SERVER, " \u7bc4\u570d: " + a.getPosition().distanceSq(var5_7.getPosition()));
                a.getClient().sendPacket(MaplePacketCreator.enableActions());
                return;
            }
lbl25:
            // 3 sources

            v2 = var5_7;
        }
        var6_9 = v2.getLock();
        var6_9.lock();
        try {
            block28: {
                block27: {
                    block26: {
                        block24: {
                            block25: {
                                if (var5_7.getMeso() <= 0) break block24;
                                if (a.getParty() == null || var5_7.getOwner() == a.getId()) break block25;
                                var7_10 = new LinkedList<E>();
                                for (MaplePartyCharacter a : a.getParty().getMembers()) {
                                    var8_11 = a.getMap().getCharacterById(a.getId());
                                    if (var8_11 == null) continue;
                                    var7_10.add(var8_11);
                                }
                                a = var7_10.iterator();
                                v3 /* !! */  = a;
                                break block26;
                            }
                            a.gainMeso(var5_7.getMeso(), true, true);
                            if (!a.isMonitored()) break block27;
                            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a.getPlayer().getName() + "/\u64bf\u53d6\u7269\u54c1.txt", a.getPlayer().getChrInfo("\u62fe\u53d6\u6953\u5e63\uff1a" + var5_7.getMeso()));
                            break block27;
                        }
                        v4 = a;
                        if (MapleItemInformationProvider.getInstance().isPickupBlocked(var5_7.getItem().getItemId())) {
                            v4.sendPacket(MaplePacketCreator.getInventoryFull());
                            v5 = a;
                            v5.sendPacket(MaplePacketCreator.getShowInventoryFull());
                            v5.sendPacket(MaplePacketCreator.enableActions());
                            v5.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u6b02\u725f\u54a7\u7117\u6cb3\u889d\u64d9\u8d41H"));
                        } else if (InventoryHandler.useItem(v4, var5_7.getItemId())) {
                            InventoryHandler.removeItem(a.getPlayer(), var5_7, a);
                        } else {
                            v6 = a;
                            if (ItemConstants.getSpecialItem(var5_7.getItemId(), a.getPlayer())) {
                                InventoryHandler.removeItem(v6.getPlayer(), var5_7, a);
                                v7 = a;
                                v7.sendPacket(MaplePacketCreator.getInventoryFull());
                                v7.sendPacket(MaplePacketCreator.getShowInventoryFull());
                            } else if (MapleInventoryManipulator.checkSpace(v6, var5_7.getItem().getItemId(), var5_7.getItem().getQuantity(), var5_7.getItem().getOwner())) {
                                if (MapleInventoryManipulator.addFromDrop(a, var5_7.getItem(), true, var5_7.getDropper() instanceof MapleMonster, false)) {
                                    InventoryHandler.removeItem(a, var5_7, a);
                                }
                                if (var5_7.isPlayerDrop() && GameSetConstants.COPTITEMCHECK_STRICT && var5_7.getItem().getEquipOnlyId() > 0L) {
                                    a.getPlayer().checkCopyItemsByID(var5_7.getOwner(), var5_7.getItemId());
                                }
                            } else {
                                v8 = a;
                                v8.sendPacket(MaplePacketCreator.getInventoryFull());
                                v8.sendPacket(MaplePacketCreator.getShowInventoryFull());
                                v8.sendPacket(MaplePacketCreator.enableActions());
                            }
                        }
                        break block28;
                    }
                    while (v3 /* !! */ .hasNext()) {
                        v9 = a = (MapleCharacter)a.next();
                        v9.gainMeso(var5_7.getMeso() / var7_10.size() + (v9.getStat().hasPartyBonus != false ? (int)((double)var5_7.getMeso() / 20.0) : 0), true, true);
                        v3 /* !! */  = a;
                    }
                }
                InventoryHandler.removeItem(a, var5_7, a);
            }
            var7_10 = CheckItemFactory.getItems();
            if (var7_10.containsKey(var5_7.getItemId()) == false) return;
            if (var5_7.getItem().getQuantity() <= (Integer)var7_10.get(var5_7.getItemId())) return;
            World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a.getPlayer().getName() + "\u7b49\u7d1a:" + a.getPlayer().getLevel() + "(\u7de8\u865f: " + a.getPlayer().getId() + ")\u64bf\u53d6\u7269\u54c1" + var5_7.getItem().getQuantity() + "\u5f35" + MapleItemInformationProvider.getInstance().getName(var5_7.getItemId()) + "\uff0c\u5341\u5206\u53ef\u7591\u3002"));
            FileoutputUtil.logToFile(MapleNodes.ALLATORIxDEMO("@aK}\u0003FMmG!\u755c\u5e36\u697f\u5e6d\u907f\u5179\u5059\u6e22\u0003\u64b1\u53fa\u7267\u54ed\u6aac\u6e00 XvX"), "\r\n " + FileoutputUtil.NowTime() + "\u89d2\u8272" + a.getPlayer().getName() + "\u7b49\u7d1a:" + a.getPlayer().getLevel() + " (\u7de8\u865f: " + a.getPlayer().getId() + ")\u64bf\u8d77\u7269\u54c1" + var5_7.getItem().getQuantity() + "\u5f35" + MapleItemInformationProvider.getInstance().getName(var5_7.getItemId()));
            if (GameSetConstants.AUTOMONITOR == false) return;
            if (a.isMonitored() != false) return;
            a.setMonitored(true);
            return;
        }
        finally {
            if (a.getPlayer().getDebugMessage()) {
                a.getPlayer().dropMessage(6, "[\u62fe\u53d6\u7269\u54c1] \u7269\u54c1ID: " + var5_7.getItem().getItemId() + " \u7269\u54c1\u540d\u7a31: " + MapleItemInformationProvider.getInstance().getName(var5_7.getItem().getItemId()));
            }
            var6_9.unlock();
        }
    }

    public static /* synthetic */ boolean useEquipProtectScroll(MapleClient a2, int a3, short a4, boolean a5) {
        IItem iItem;
        if ((a4 < 0 ? (iItem = a2.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(a4)) : (iItem = a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a4))) == null || iItem.getType() != 1) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u8ac5\u5c2b\u637c\u8ed4\u62d8\u521c\u898f\u4f53\u7526\u76a8\u88d3\u50b5\u4e04\u0002"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        a4 = (short)(a3 == 5064003 ? 7 : 12);
        if (((Equip)iItem).getEnhance() >= a4) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u8a44\u9035\u5141\u5686\u708c\u6679\u5341\u806a\u7117\u6cb3\u7e4a\u7eea\u4f49\u754e\u4feb\u8b11\u5341H"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        if (!ItemFlag.SHIELD_WARD.check(iItem.getFlag())) {
            MapleClient mapleClient = a2;
            iItem.addFlag(ItemFlag.SHIELD_WARD.getValue());
            mapleClient.getPlayer().forceUpdateItem(iItem);
            mapleClient.getPlayer().getMap().broadcastMessage(a2.getPlayer(), MaplePacketCreator.getScrollEffect(a2.getPlayer().getId(), IEquip.ScrollResult.SUCCESS, a5), true);
            if (ServerConfig.LOG_SCROLL) {
                FileoutputUtil.logToFile("logs/\u73a9\u5bb6\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u4f7f\u7528\u5377\u8ef8.txt", "\r\n" + FileoutputUtil.CurrentReadable_Time() + " IP: " + a2.getSessionIPAddress() + " \u73a9\u5bb6[" + a2.getPlayer().getName() + "] \u5377\u8ef8:\u88dd\u5099\u4fdd\u8b77\u5377(" + a3 + ") \u88dd\u5099:" + iItem.getItemName() + "(" + iItem.getItemId() + ")[\u529b:" + ((Equip)iItem).getStr() + "/\u654f:" + ((Equip)iItem).getDex() + "/\u5e78:" + ((Equip)iItem).getLuk() + "/\u667a:" + ((Equip)iItem).getInt() + "/\u7269\u653b:" + ((Equip)iItem).getWatk() + "/\u9b54\u529f:" + ((Equip)iItem).getMatk() + "/\u7269\u9632:" + ((Equip)iItem).getWdef() + "/\u9b54\u9632:" + ((Equip)iItem).getMdef() + "/HP:" + ((Equip)iItem).getHp() + "/MP:" + ((Equip)iItem).getMp() + "/\u79fb\u52d5\u901f\u5ea6:" + ((Equip)iItem).getSpeed() + "/\u8df3\u8e8d\u529b:" + ((Equip)iItem).getJump() + "/\u5377\u8ef8\u6b21\u6578:" + ((Equip)iItem).getUpgradeSlots() + "/+" + ((Equip)iItem).getLevel() + "/\u661f\u529b:" + ((Equip)iItem).getEnhance() + "/\u6f5b\u80fd:" + ((Equip)iItem).getPotential1() + "." + ((Equip)iItem).getPotential2() + "." + ((Equip)iItem).getPotential3() + "." + ((Equip)iItem).getPotential4() + "." + ((Equip)iItem).getPotential5() + ".] \u552f\u4e00ID[" + ((Equip)iItem).getEquipOnlyId() + " \u7d50\u679c: \u6210\u529f");
            }
            return true;
        }
        MapleClient mapleClient = a2;
        mapleClient.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u5dfc\u7dbf\u6707\u4ff1\u8b79\u635e\u6546\u67b0\u4e88\u302e"));
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        return false;
    }

    public static final /* synthetic */ void PetPickup_Petvac(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4, boolean a522, boolean a622) {
        MapleCharacter mapleCharacter;
        if (a4 == null) {
            return;
        }
        byte by = 0;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            mapleCharacter = a4;
            by = (byte)a2.readInt();
        } else {
            by = a3.getPlayer().getPetIndex((int)a2.readLong());
            mapleCharacter = a4;
        }
        MaplePet maplePet = mapleCharacter.getPet(by);
        MapleCharacter mapleCharacter2 = a4;
        int n2 = mapleCharacter2.getPetVac();
        if (mapleCharacter2.getPetVacTime() > System.currentTimeMillis()) {
            n2 = 5000;
        }
        if (a522) {
            n2 = 5000;
        }
        if (a622) {
            n2 = SpecialEquipFactory.getInstance().getVac(a4);
        }
        if (maplePet == null || a4.getMap() == null) {
            return;
        }
        int n3 = n2;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.ITEM;
        List<MapleMapObject> a522 = a4.getMap().getMapObjectsInRange(maplePet.getPos(), n3 * n3, Arrays.asList(arrmapleMapObjectType));
        Iterator<MapleMapObject> a622 = a522.iterator();
        block0: while (true) {
            Iterator<MapleMapObject> iterator = a622;
            while (iterator.hasNext()) {
                MapleMapObject mapleMapObject = a622.next();
                if (a522 == null || maplePet == null) {
                    return;
                }
                mapleMapObject = (MapleMapItem)mapleMapObject;
                Object object = ((MapleMapItem)mapleMapObject).getLock();
                if (((MapleMapItem)mapleMapObject).isPickedUp()) {
                    iterator = a622;
                    a3.sendPacket(MaplePacketCreator.getInventoryFull());
                    continue;
                }
                if (((MapleMapItem)mapleMapObject).getOwner() != a4.getId() && ((MapleMapItem)mapleMapObject).isPlayerDrop()) {
                    iterator = a622;
                    continue;
                }
                if (((MapleMapItem)mapleMapObject).getOwner() != a4.getId()) {
                    if (!((MapleMapItem)mapleMapObject).isPlayerDrop() && ((MapleMapItem)mapleMapObject).getDropType() == 0) continue block0;
                    if (((MapleMapItem)mapleMapObject).isPlayerDrop() && a4.getMap().getEverlast()) {
                        iterator = a622;
                        continue;
                    }
                }
                if (!((MapleMapItem)mapleMapObject).isPlayerDrop() && ((MapleMapItem)mapleMapObject).getDropType() == 1 && ((MapleMapItem)mapleMapObject).getOwner() != a4.getId()) {
                    if (a4.getParty() == null) continue block0;
                    if (a4.getParty().getMemberById(((MapleMapItem)mapleMapObject).getOwner()) == null) {
                        iterator = a622;
                        continue;
                    }
                }
                if (((MapleMapItem)mapleMapObject).isPlayerDrop() && ((MapleMapItem)mapleMapObject).getDropType() == 2 && ((MapleMapItem)mapleMapObject).getOwner() == a4.getId()) {
                    iterator = a622;
                    continue;
                }
                if (a4.getTrade() != null) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (((MapleMapItem)mapleMapObject).getMeso() > 0) {
                    MapleCharacter mapleCharacter3;
                    if (a4.getParty() != null && ((MapleMapItem)mapleMapObject).getOwner() != a4.getId()) {
                        object = new LinkedList();
                        int n4 = ((MapleMapItem)mapleMapObject).getMeso() * 40 / 100;
                        for (MaplePartyCharacter maplePartyCharacter : a4.getParty().getMembers()) {
                            MapleCharacter mapleCharacter4 = a4.getMap().getCharacterById(maplePartyCharacter.getId());
                            if (mapleCharacter4 == null || mapleCharacter4.getId() == a4.getId()) continue;
                            object.add(mapleCharacter4);
                        }
                        Iterator<MaplePartyCharacter> iterator2 = object.iterator();
                        Iterator<Object> iterator3 = iterator2;
                        while (iterator3.hasNext()) {
                            MapleCharacter mapleCharacter5;
                            MapleCharacter mapleCharacter6 = mapleCharacter5 = (MapleCharacter)((Object)iterator2.next());
                            mapleCharacter6.gainMeso(n4 / object.size() + (mapleCharacter6.getStat().hasPartyBonus ? (int)((double)((MapleMapItem)mapleMapObject).getMeso() / 20.0) : 0), true);
                            iterator3 = iterator2;
                        }
                        MapleCharacter mapleCharacter7 = a4;
                        mapleCharacter3 = mapleCharacter7;
                        mapleCharacter7.gainMeso(((MapleMapItem)mapleMapObject).getMeso() - n4, true);
                    } else {
                        MapleCharacter mapleCharacter8 = a4;
                        mapleCharacter3 = mapleCharacter8;
                        mapleCharacter8.gainMeso(((MapleMapItem)mapleMapObject).getMeso(), true);
                    }
                    InventoryHandler.removeItemPet(mapleCharacter3, (MapleMapItem)mapleMapObject, by);
                    continue block0;
                }
                if (MapleItemInformationProvider.getInstance().isPickupBlocked(((MapleMapItem)mapleMapObject).getItemId()) || ((MapleMapItem)mapleMapObject).getItemId() / 10000 == 291) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    continue block0;
                }
                if (InventoryHandler.useItem(a3, ((MapleMapItem)mapleMapObject).getItemId())) {
                    InventoryHandler.removeItemPet(a4, (MapleMapItem)mapleMapObject, by);
                    continue block0;
                }
                if (!MapleInventoryManipulator.checkSpace(a3, ((MapleMapItem)mapleMapObject).getItemId(), ((MapleMapItem)mapleMapObject).getItem().getQuantity(), ((MapleMapItem)mapleMapObject).getItem().getOwner())) continue block0;
                if (MapleInventoryManipulator.addFromDrop(a3, ((MapleMapItem)mapleMapObject).getItem(), true, ((MapleMapItem)mapleMapObject).getDropper() instanceof MapleMonster, true)) {
                    InventoryHandler.removeItemPet(a4, (MapleMapItem)mapleMapObject, by);
                }
                if (!((MapleMapItem)mapleMapObject).isPlayerDrop() || !GameSetConstants.COPTITEMCHECK_STRICT || ((MapleMapItem)mapleMapObject).getItem().getEquipOnlyId() <= 0L) continue block0;
                a3.getPlayer().checkCopyItemsByID(((MapleMapItem)mapleMapObject).getOwner(), ((MapleMapItem)mapleMapObject).getItemId());
                continue block0;
            }
            break;
        }
    }

    public static /* synthetic */ void UseCarvedSeal(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        if (GameSetConstants.MAPLE_VERSION < 139) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        MapleClient mapleClient2 = a3;
        mapleClient2.getPlayer().updateTick(a2.readInt());
        short s2 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readShort();
        IItem iItem = mapleClient2.getPlayer().getInventory(MapleInventoryType.USE).getItem(s2);
        IItem iItem2 = a3.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((short)n2);
        if (ItemConstants.\u985e\u578b.\u9644\u52a0\u6f5b\u80fd\u5377\u8ef8((int)iItem.getItemId())) {
            MapleClient mapleClient3 = a3;
            InventoryHandler.UseUpgradeScroll(s2, (short)n2, false ? 1 : 0, false ? 1 : 0, mapleClient3, mapleClient3.getPlayer(), 0, false);
            return;
        }
        if (!ItemConstants.is\u70d9\u5370\u5370\u7ae0(iItem.getItemId()) || GameConstants.getInventoryType(iItem2.getItemId()) != MapleInventoryType.EQUIP) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        n2 = mapleItemInformationProvider.getSuccess(iItem.getItemId(), false);
        if (Randomizer.nextInt(100) <= n2) {
            boolean bl;
            Equip equip = (Equip)iItem2;
            if (equip.getState() < 17) {
                MapleClient mapleClient4 = a3;
                mapleClient4.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u710d\u6cdb\u4f53\u7526\u302e"));
                mapleClient4.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (equip.getPotential3() != 0) {
                MapleClient mapleClient5 = a3;
                mapleClient5.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u4e6f\u63a4\u6f3d\u80cb\u7147\u6ce3\u4f19\u751e\u3064"));
                mapleClient5.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            LinkedList<Map<Integer, StructPotentialItem>> linkedList = new LinkedList<Map<Integer, StructPotentialItem>>(mapleItemInformationProvider.getAllPotentialInfo().values());
            Equip equip2 = equip;
            int n3 = mapleItemInformationProvider.getReqLevel(equip2.getItemId());
            MapleItemInformationProvider mapleItemInformationProvider2 = mapleItemInformationProvider;
            int n4 = Math.min(19, mapleItemInformationProvider2.getReqLevel(equip.getItemId()) / 10);
            if (mapleItemInformationProvider2.getReqLevel(equip2.getItemId()) % 10 == 0 && n4 != 0) {
                --n4;
            }
            byte by = equip.getState();
            n3 = by;
            if (by > 20) {
                n3 = 20;
            } else if (n3 < 17) {
                n3 = 17;
            }
            boolean bl2 = bl = false;
            while (!bl2) {
                LinkedList<Map<Integer, StructPotentialItem>> linkedList2 = linkedList;
                StructPotentialItem structPotentialItem = (StructPotentialItem)((Map)linkedList2.get(Randomizer.nextInt(linkedList2.size()))).get(n4 + 1);
                if (structPotentialItem == null) {
                    bl2 = bl;
                    continue;
                }
                if (structPotentialItem.reqLevel / 10 > n4) {
                    bl2 = bl;
                    continue;
                }
                StructPotentialItem structPotentialItem2 = structPotentialItem;
                if (!GameConstants.optionTypeFits(structPotentialItem2.opID, structPotentialItem2.optionType, equip.getItemId())) {
                    bl2 = bl;
                    continue;
                }
                if (!GameConstants.potentialIDFits(structPotentialItem.opID, n3, 0)) {
                    bl2 = bl;
                    continue;
                }
                equip.setPotential3(structPotentialItem.opID);
                bl2 = bl = true;
            }
            MapleClient mapleClient6 = a3;
            mapleClient = mapleClient6;
            MapleClient mapleClient7 = a3;
            mapleClient6.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(false, mapleClient7.getPlayer().getId(), iItem.getItemId()));
            mapleClient7.getPlayer().forceUpdateItem(iItem2);
        } else {
            MapleClient mapleClient8 = a3;
            mapleClient = mapleClient8;
            mapleClient8.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(true, a3.getPlayer().getId(), iItem.getItemId()));
        }
        MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.USE, iItem.getPosition(), true ? 1 : 0, false, true);
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ boolean UseRewardItem(byte a2, int a3, MapleClient a4, MapleCharacter a5) {
        MapleClient mapleClient = a4;
        Object object = mapleClient.getPlayer().getInventory(GameConstants.getInventoryType(a3)).getItem(a2);
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
        if (object != null && object.getQuantity() >= 1 && object.getItemId() == a3) {
            if (a5.getInventory(MapleInventoryType.EQUIP).getNextFreeSlot() > -1 && a5.getInventory(MapleInventoryType.USE).getNextFreeSlot() > -1 && a5.getInventory(MapleInventoryType.SETUP).getNextFreeSlot() > -1 && a5.getInventory(MapleInventoryType.ETC).getNextFreeSlot() > -1) {
                object = MapleItemInformationProvider.getInstance();
                Pair<Integer, List<StructRewardItem>> pair = ((MapleItemInformationProvider)object).getRewardItem(a3);
                if (pair != null && pair.getLeft() > 0) {
                    boolean bl = false;
                    while (!bl) {
                        for (StructRewardItem structRewardItem : pair.getRight()) {
                            MapleClient mapleClient2;
                            if (structRewardItem.prob <= 0 || Randomizer.nextInt(pair.getLeft()) >= structRewardItem.prob) continue;
                            if (structRewardItem.itemid == 0) {
                                MapleCharacter mapleCharacter;
                                int n2 = 0;
                                int n3 = Randomizer.nextInt(99999);
                                if (n3 >= 0 && n3 < 47200) {
                                    n2 = 100000;
                                    mapleCharacter = a5;
                                } else if (n3 >= 47200 && n3 < 77400) {
                                    n2 = 500000;
                                    mapleCharacter = a5;
                                } else if (n3 >= 77400 && n3 < 94500) {
                                    n2 = 1000000;
                                    mapleCharacter = a5;
                                } else {
                                    n2 = 5000000;
                                    mapleCharacter = a5;
                                }
                                if ((long)(mapleCharacter.getMeso() + n2) > Integer.MAX_VALUE) {
                                    a5.dropMessage(1, MapleNodes.ALLATORIxDEMO("\u8ea5\u4e26\u768a\u697f\u5e6d\u9062\u5914\u0002"));
                                    return true;
                                }
                                if (n2 <= 0) continue;
                                MapleInventoryManipulator.removeById(a4, GameConstants.getInventoryType(a3), a3, 1, false, false);
                                a5.gainMeso(n2, true);
                                return true;
                            }
                            if (GameConstants.getInventoryType(structRewardItem.itemid) == MapleInventoryType.EQUIP) {
                                Object object2 = object;
                                Equip equip = ((MapleItemInformationProvider)object2).randomizeStats((Equip)((MapleItemInformationProvider)object2).getEquipById(structRewardItem.itemid));
                                if (structRewardItem.period > 0L) {
                                    equip.setExpiration(System.currentTimeMillis() + structRewardItem.period * 60L * 60L * 10L);
                                }
                                MapleClient mapleClient3 = a4;
                                mapleClient2 = mapleClient3;
                                MapleInventoryManipulator.addbyItem(mapleClient3, equip);
                            } else {
                                MapleClient mapleClient4 = a4;
                                mapleClient2 = mapleClient4;
                                StructRewardItem structRewardItem2 = structRewardItem;
                                MapleInventoryManipulator.addById(mapleClient4, structRewardItem2.itemid, structRewardItem2.quantity);
                            }
                            MapleInventoryManipulator.removeById(mapleClient2, GameConstants.getInventoryType(a3), a3, 1, false, false);
                            StructRewardItem structRewardItem3 = structRewardItem;
                            a4.sendPacket(MaplePacketCreator.showRewardItemAnimation(structRewardItem3.itemid, structRewardItem3.effect));
                            StructRewardItem structRewardItem4 = structRewardItem;
                            MapleCharacter mapleCharacter = a5;
                            a5.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.showRewardItemAnimation(structRewardItem4.itemid, structRewardItem4.effect, mapleCharacter.getId()), false);
                            if (structRewardItem.worldmsg != null && structRewardItem.worldmsg.equals("1")) {
                                World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("[" + MapleItemInformationProvider.getInstance().getName(a3) + "] \u606d\u559c\u73a9\u5bb6 " + a5.getName() + " \u958b\u555f" + MapleItemInformationProvider.getInstance().getName(a3) + " \u7372\u5f97 " + MapleItemInformationProvider.getInstance().getName(structRewardItem.itemid) + " !"));
                            }
                            bl = true;
                            return true;
                        }
                    }
                } else {
                    a5.dropMessage(6, CashShopOperation.ALLATORIxDEMO("\u671c\u7783\u76b2\u9349\u8a92H"));
                }
            } else {
                a5.dropMessage(6, MapleNodes.ALLATORIxDEMO("\u4f6e\u6725\u4e0e\u5027\u6b0a\u4f61\u6ef1\u4eaa.\u8ae7\u7a74\u51d6\u4f88\u51a1\u625d\u95a7"));
            }
        }
        return false;
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(MapleClient a2, String a3) {
        if (GameSetConstants.MEGA_LIMIT && a2.getPlayer().getLevel() < 10) {
            a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u5fa3\u983e\u89e7\u0007V\u7b7f\u4e83\u4e3c\u622b\u80cb\u4f19\u751eH"));
            return false;
        }
        if (!a2.getPlayer().getCheatTracker().canAvatarSmega2()) {
            a2.getPlayer().dropMessage(6, MapleNodes.ALLATORIxDEMO("\u5fa4\u62bf\u6b65\u70b4\u4eaa\u963c\u6b4e\u5239\u5ecf\"\u626c\u4eeb\u4f4c\u6bc1\u001d>\u79fe\u53e4\u80d1\u7526\u4e2c\u6b2f\u0002"));
            return false;
        }
        if (!(a2.getPlayer().getCanTalk() && !a2.getChannelServer().getMegaphoneMuteState() || a2.getPlayer().isGM())) {
            a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u7688\u527b\u55e1\u53db\u503a\u6b54\u4f19\u751eH"));
            return false;
        }
        if (a2.getPlayer().isPlayer() && !PiPiConfig.isCanTalkText(a3)) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(MapleNodes.ALLATORIxDEMO("\u8a86\u9adc\u8a5d\u6621\u4e21\u79a0\u8ca0\u768a\uff20\u8ac5\u52d3\u8aa4\u9afe\u8a7f\u302e"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        if (!(a2.getPlayer().getCanTalk() && !a2.getChannelServer().getMegaphoneMuteState() || a2.getPlayer().isGM())) {
            a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u7688\u527b\u55e1\u53db\u503a\u6b54\u4f19\u751eH"));
            return false;
        }
        if (ServerConfig.LOG_MEGA) {
            FileoutputUtil.logToFile(MapleNodes.ALLATORIxDEMO("bCi_!\u8066\u5927\u0003\u5eed\u6481\u9835\u907f XvX"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a2.getSession().remoteAddress().toString().split(CashShopOperation.ALLATORIxDEMO("\\"))[0] + " " + FileoutputUtil.NowTime() + " IP: " + a2.getSession().remoteAddress().toString().split(MapleNodes.ALLATORIxDEMO("\u0016"))[0] + " \u73a9\u5bb6\u300e" + a2.getPlayer().getName() + "\u300f\u983b\u9053\u300e" + a2.getChannel() + "\u300f\uff1a" + a3);
        }
        a2.getPlayer().addUseMega(1);
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public static final /* synthetic */ void useExpPotion(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        int n2;
        short s2;
        Object object;
        String[] arrstring;
        LittleEndianAccessor littleEndianAccessor = a2;
        MapleClient mapleClient2 = a3;
        mapleClient2.getPlayer().updateTick(a2.readInt());
        byte by = (byte)littleEndianAccessor.readShort();
        int n3 = littleEndianAccessor.readInt();
        Object object2 = mapleClient2.getPlayer().getInventory(MapleInventoryType.USE).getItem(by);
        if (object2 == null || object2.getQuantity() < 1 || object2.getItemId() != n3 || a3.getPlayer().hasBlockedInventory()) {
            MapleClient mapleClient3 = a3;
            mapleClient3.getPlayer().dropMessage(6, MapleNodes.ALLATORIxDEMO("\u9303\u8aaa\u0002 \u0002"));
            mapleClient3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        object2 = MapleItemInformationProvider.getInstance();
        boolean bl = false;
        boolean bl2 = false;
        object2 = ((MapleItemInformationProvider)object2).getExpPotionLevel(n3);
        String string = a3.getPlayer().getOneInfo(7985, String.valueOf(n3));
        if (string == null) {
            bl = true;
            String[] arrstring2 = new String[2];
            arrstring2[0] = "";
            arrstring2[1] = "";
            arrstring = arrstring2;
        } else {
            arrstring = string.split(CashShopOperation.ALLATORIxDEMO("E"));
        }
        int n4 = 0;
        int n5 = 0;
        Object object3 = object = object2[0];
        while (object3 < object2[1]) {
            void var10_13;
            n4 += GameConstants.getExpNeededForLevel((int)var10_13);
            if (var10_13 <= a3.getPlayer().getLevel()) {
                n5 += GameConstants.getExpNeededForLevel((int)var10_13);
            }
            object3 = ++var10_13;
        }
        int n6 = arrstring[0].isEmpty() ? 0 : Integer.parseInt(arrstring[0]);
        int n7 = arrstring[1].isEmpty() ? n4 : Integer.parseInt(arrstring[1]);
        MapleClient mapleClient4 = a3;
        short s3 = mapleClient4.getPlayer().getLevel();
        int n8 = mapleClient4.getPlayer().getNeededExp() - a3.getPlayer().getExp();
        int n9 = 0;
        if (s3 < object2[0] || s3 >= object2[1] || n6 >= s3 || n4 < n7) {
            a3.getPlayer().dropMessage(1, "\u8acb\u78ba\u8a8d\u7b49\u7d1a\u662f\u5426\u5728" + (int)object2[0] + "~" + (int)object2[1] + "\u4e4b\u9593,\u6216\u662f\u7d93\u9a57\u5b58\u5728\u7570\u5e38\u3002");
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (n7 >= n8) {
            n9 = n8;
            n7 -= n8;
            s2 = s3;
        } else {
            n9 = n7;
            n7 = 0;
            s2 = s3;
        }
        if (s2 >= object2[1] - true || n7 <= 0) {
            bl2 = true;
        }
        a3.getPlayer().gainExp(n9, true, true, false);
        if (bl2) {
            n2 = 0;
            mapleClient = a3;
        } else {
            n2 = 2;
            mapleClient = a3;
        }
        a3.sendPacket(MaplePacketCreator.updateExpPotion(n2, mapleClient.getPlayer().getId(), n3, bl, a3.getPlayer().getLevel(), (int)object2[1], n7 + n5 - n4));
        a3.getPlayer().updateOneInfo(7985, String.valueOf(n3), String.valueOf(s3) + "#" + String.valueOf(n7));
        if (bl2) {
            MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
            a3.getPlayer().updateOneInfo(7985, String.valueOf(n3), null);
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void UseScriptedNPCItem(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        block644: {
            block643: {
                v0 = a;
                a.getPlayer().updateTick(v0.readInt());
                var3_4 = (byte)v0.readShort();
                var4_5 = v0.readInt();
                var5_6 = a.getInventory(MapleInventoryType.USE).getItem(var3_4);
                var6_7 = MapleItemInformationProvider.getInstance().getScriptedItemInfo(var4_5);
                var7_8 = 0L;
                var9_9 = 0;
                if (var5_6 == null || var5_6.getQuantity() < 1 || var5_6.getItemId() != var4_5) break block643;
                switch (var5_6.getItemId()) {
                    case 2430007: {
                        var10_10 = a.getInventory(MapleInventoryType.SETUP);
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                        if (var10_10.countById(3994102) >= 20 && var10_10.countById(3994103) >= 20 && var10_10.countById(3994104) >= 20 && var10_10.countById(3994105) >= 20) {
                            MapleInventoryManipulator.addById(a, 2430008, (short)1);
                            MapleInventoryManipulator.removeById(a, MapleInventoryType.SETUP, 3994102, 20, false, false);
                            MapleInventoryManipulator.removeById(a, MapleInventoryType.SETUP, 3994103, 20, false, false);
                            MapleInventoryManipulator.removeById(a, MapleInventoryType.SETUP, 3994104, 20, false, false);
                            MapleInventoryManipulator.removeById(a, MapleInventoryType.SETUP, 3994105, 20, false, false);
                        } else {
                            MapleInventoryManipulator.addById(a, 2430007, (short)1);
                        }
                        NPCScriptManager.getInstance().start(a, 2084001);
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430008: {
                        if (a.getMapId() == 100000000) ** GOTO lbl38
                        v1 = var9_9;
                        a.dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8aad\u571e\u5f75\u7b9b\u622d\u6767\u4f19\u751e\u3064"));
                        break block644;
lbl38:
                        // 1 sources

                        a.saveLocation(SavedLocationType.RICHIE);
                        var11_18 = false;
                        v2 = var12_21 = 390001000;
                        while (v2 <= 390001004) {
                            var10_11 = a.getChannelServer().getMapFactory().getMap(var12_21);
                            if (var10_11.getCharactersSize() != 0) ** GOTO lbl48
                            v3 = var10_11;
                            a.changeMap(v3, v3.getPortal(0));
                            v4 = var11_18 = true;
                            ** GOTO lbl51
lbl48:
                            // 1 sources

                            v2 = ++var12_21;
                        }
                        v4 = var11_18;
lbl51:
                        // 2 sources

                        if (v4) {
                            v1 = var9_9;
                            MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, 2430008, 1, false, false);
                        } else {
                            a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u5166\u90c4\u573e\u90d1\u5726\u4f53\u7526\u4e01\uff02\u8ae7\u7a03\u5fa0\u5183\u563b\u8a68\u4e2c\u6b2f\u302e"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430112: {
                        if (a.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() < 1) {
                            v1 = var9_9;
                            a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u6dee\u8021\u6b62\u7a4c\u95f5\u4e3b\u8dd5"));
                        } else if (a.getPlayer().getInventory(MapleInventoryType.USE).countById(2430112) >= 10) {
                            if (MapleInventoryManipulator.checkSpace(a, 2049400, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, 2430112, 10, true, false)) {
                                v1 = var9_9;
                                MapleInventoryManipulator.addById(a, 2049400, (short)1);
                            } else {
                                a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u6da4\u8019\u6b28\u7a74\u95bf\u4e03\u8d9f"));
                                v1 = var9_9;
                            }
                        } else if (a.getPlayer().getInventory(MapleInventoryType.USE).countById(2430112) < 5) {
                            v1 = var9_9;
                            a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u0003\u506d\u78b8\u7221\u53d9\u4e83\u517a\u63bd\u6f6d\u809b\u8cd0\u4eee\u5341\u8e9e\u001aF\u0007V\u503d\u78e8\u7271\u5389\u4ed3\u512a\u63ed\u9abe\u7d2c\u6f3d\u80cb\u8c80\u4ebe\u5311\u8eceH"));
                        } else if (MapleInventoryManipulator.checkSpace(a, 2049400, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, 2430112, 5, true, false)) {
                            v1 = var9_9;
                            MapleInventoryManipulator.addById(a, 2049401, (short)1);
                        } else {
                            a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u6da4\u8019\u6b28\u7a74\u95bf\u4e03\u8d9f"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430015: {
                        if (a.getPlayer().getMapId() != 106020500) break;
                        v1 = var9_9;
                        MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, 2430015, 1, false, false);
                        a.getPlayer().changeMap(106020502);
                        break block644;
                    }
                    case 2430032: {
                        if (a.getPlayer().getMapId() != 220011001) ** GOTO lbl108
                        if (a.getPlayer().getQuestStatus(22583) == 1) {
                            var10_12 = a.getMap().getMonsterById(9300389);
                            v5 = a;
                            v6 = v5;
                            v5.getPlayer().getMap().killMonster(var10_12, a, true, (boolean)0, (byte)0);
                            v5.getPlayer().mobKilled(9300389, 0);
                            v5.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u977e\u9b24\u5dc4\u88cd\u91fd\u6558"));
                        } else {
                            if (a.getPlayer().getQuestStatus(22584) == 1) {
                                var10_13 = a.getMap().getMonsterById(9300390);
                                v7 = a;
                                v7.getPlayer().getMap().killMonster(var10_13, a, true, (boolean)0, (byte)0);
                                v7.getPlayer().mobKilled(9300390, 0);
                                v7.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u958e\u93ba\u5dfc\u8887\u783a\u58f2"));
                            }
lbl108:
                            // 4 sources

                            v6 = a;
                        }
                        MapleInventoryManipulator.removeById(v6, MapleInventoryType.USE, 2430032, 1, false, false);
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430036: {
                        var9_9 = 1027;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430037: {
                        var9_9 = 1028;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430038: {
                        var9_9 = 1029;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430039: {
                        var9_9 = 1030;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430040: {
                        var9_9 = 1031;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430053: {
                        var9_9 = 1027;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430054: {
                        var9_9 = 1028;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430055: {
                        var9_9 = 1029;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430056: {
                        var9_9 = 1035;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430072: {
                        var9_9 = 1034;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430073: {
                        var9_9 = 1036;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430074: {
                        var9_9 = 1037;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430075: {
                        var9_9 = 1038;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430076: {
                        var9_9 = 1039;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430077: {
                        var9_9 = 1040;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430080: {
                        var9_9 = 1042;
                        var7_8 = 20L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430082: {
                        var9_9 = 1044;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430091: {
                        var9_9 = 1049;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430092: {
                        var9_9 = 1050;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430093: {
                        var9_9 = 1051;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430101: {
                        var9_9 = 1052;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430102: {
                        var9_9 = 1053;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430103: {
                        var9_9 = 1054;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430117: {
                        var9_9 = 1036;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430118: {
                        var9_9 = 1039;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430119: {
                        var9_9 = 1040;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430120: {
                        var9_9 = 1037;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430136: {
                        var9_9 = 1069;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430137: {
                        var9_9 = 1069;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430201: {
                        var9_9 = 1096;
                        var7_8 = 60L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430228: {
                        var9_9 = 1101;
                        var7_8 = 60L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x251515: {
                        var9_9 = 1102;
                        var7_8 = 60L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430481: {
                        if (a.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
                            if (a.getPlayer().getInventory(MapleInventoryType.USE).countById(2430481) >= 30) {
                                if (MapleInventoryManipulator.checkSpace(a, 2049701, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), 30, true, false)) {
                                    v1 = var9_9;
                                    MapleInventoryManipulator.addById(a, 2049701, (short)1);
                                } else {
                                    a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u6ac4\u67d3\u9035\u5141\u6b62\u4f7b\u7a1c\u95a5\u3064"));
                                    v1 = var9_9;
                                }
                            } else if (a.getPlayer().getInventory(MapleInventoryType.USE).countById(2430481) >= 20) {
                                if (MapleInventoryManipulator.checkSpace(a, 2049300, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), 20, true, false)) {
                                    v1 = var9_9;
                                    MapleInventoryManipulator.addById(a, 2049300, (short)1);
                                } else {
                                    a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                                    v1 = var9_9;
                                }
                            } else {
                                a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("Z\u5085\u8acc\u76b2\u5921\u5e4d\u65df\u587c\u78e8\u7271X\u0004V\u503d\u5389\u517a\u63bd\u0007\u5f53\u9aee\u7d7c\u88eb\u50ff\u5f01\u5370\u5341\u8e9e\uff3aU\u0006\u506d\u53d9\u512a\u63edW\u5f03\u7a66\u673f\u6f3d\u571e\u809b\u52ad\u5311\u8eceF\u000eV\u0013\u3064"));
                                v1 = var9_9;
                            }
                        } else {
                            a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430691: {
                        if (a.getPlayer().getInventory(MapleInventoryType.CASH).getNumFreeSlot() >= 1) {
                            if (a.getPlayer().getInventory(MapleInventoryType.USE).countById(2430691) >= 10) {
                                if (MapleInventoryManipulator.checkSpace(a, 5750001, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), 10, true, false)) {
                                    v1 = var9_9;
                                    MapleInventoryManipulator.addById(a, 5750001, (short)1);
                                } else {
                                    a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u6ac4\u67d3\u9035\u5141\u6b62\u4f7b\u7a1c\u95a5\u3064"));
                                    v1 = var9_9;
                                }
                            } else {
                                a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("xfI|I.BkIj_.Xa\flI.\u001d>\fH^oKcI`X}\fhC|\fo\f@IlYbEzI.hgJhY}I|\u0002"));
                                v1 = var9_9;
                            }
                        } else {
                            a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u6ac4\u67d3\u9035\u5141\u6b62\u4f7b\u7a1c\u95a5\u3064"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430748: {
                        if (a.getPlayer().getInventory(MapleInventoryType.ETC).getNumFreeSlot() >= 1) {
                            if (a.getPlayer().getInventory(MapleInventoryType.USE).countById(2430748) >= 20) {
                                if (MapleInventoryManipulator.checkSpace(a, 4420000, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), 20, true, false)) {
                                    v1 = var9_9;
                                    MapleInventoryManipulator.addById(a, 4420000, (short)1);
                                } else {
                                    a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                                    v1 = var9_9;
                                }
                            } else {
                                a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("2^\u0003D\u0003\u0016\bS\u0003R\u0015\u0016\u0012YFT\u0003\u0016T\u0006Fp\u0014W\u0001[\u0003X\u0012EFP\tDFWFf\u0014S\u000b_\u0013[Fp\u0013E\u000fY\b\u00162_\u0005]\u0003BH"));
                                v1 = var9_9;
                            }
                        } else {
                            a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 5680019: {
                        var10_14 = 32150 + a.getPlayer().getHair() % 10;
                        v1 = var9_9;
                        v8 = a;
                        v8.getPlayer().setHair(var10_14);
                        v8.getPlayer().updateSingleStat(MapleStat.HAIR, var10_14);
                        MapleInventoryManipulator.removeFromSlot(v8, MapleInventoryType.CASH, var3_4, (short)1, false);
                        break block644;
                    }
                    case 5680020: {
                        var10_15 = 32160 + a.getPlayer().getHair() % 10;
                        v1 = var9_9;
                        v9 = a;
                        v9.getPlayer().setHair(var10_15);
                        v9.getPlayer().updateSingleStat(MapleStat.HAIR, var10_15);
                        MapleInventoryManipulator.removeFromSlot(v9, MapleInventoryType.CASH, var3_4, (short)1, false);
                        break block644;
                    }
                    case 3994225: {
                        a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("f\nS\u0007E\u0003\u0016\u0004D\u000fX\u0001\u0016\u0012^\u000fEF_\u0012S\u000b\u0016\u0012YFB\u000eSFx6uH"));
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430212: {
                        var10_16 = a.getPlayer().getQuestNAdd(MapleQuest.getInstance(122500));
                        if (var10_16.getCustomData() == null) {
                            var10_16.setCustomData(MapleNodes.ALLATORIxDEMO("\u001c"));
                        }
                        var11_19 = Long.parseLong(var10_16.getCustomData());
                        v10 = a;
                        if (var11_19 + 600000L > System.currentTimeMillis()) {
                            v10.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("?Y\u0013\u0016\u0005W\b\u0016\tX\nOFC\u0015SFY\bSFS\bS\u0014Q\u001f\u0016\u0002D\u000fX\r\u0016\u0016S\u0014\u0016W\u0006F[\u000fX\u0013B\u0003EH"));
                            v1 = var9_9;
                        } else {
                            if (v10.getPlayer().getFatigue() <= 0) break;
                            v1 = var9_9;
                            MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                            a.getPlayer().setFatigue(a.getPlayer().getFatigue() - 5);
                        }
                        break block644;
                    }
                    case 2430214: 
                    case 2430220: {
                        if (a.getPlayer().getFatigue() <= 0) break;
                        v1 = var9_9;
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                        a.getPlayer().setFatigue(a.getPlayer().getFatigue() - 30);
                        break block644;
                    }
                    case 2430227: {
                        if (a.getPlayer().getFatigue() <= 0) break;
                        v1 = var9_9;
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                        a.getPlayer().setFatigue(a.getPlayer().getFatigue() - 50);
                        break block644;
                    }
                    case 2430231: {
                        var10_17 = a.getPlayer().getQuestNAdd(MapleQuest.getInstance(122500));
                        if (var10_17.getCustomData() == null) {
                            var10_17.setCustomData(MapleNodes.ALLATORIxDEMO("\u001c"));
                        }
                        var11_20 = Long.parseLong(var10_17.getCustomData());
                        v11 = a;
                        if (var11_20 + 600000L > System.currentTimeMillis()) {
                            v11.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("?Y\u0013\u0016\u0005W\b\u0016\tX\nOFC\u0015SFY\bSFS\bS\u0014Q\u001f\u0016\u0002D\u000fX\r\u0016\u0016S\u0014\u0016W\u0006F[\u000fX\u0013B\u0003EH"));
                            v1 = var9_9;
                        } else {
                            if (v11.getPlayer().getFatigue() <= 0) break;
                            v1 = var9_9;
                            MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                            a.getPlayer().setFatigue(a.getPlayer().getFatigue() - 40);
                        }
                        break block644;
                    }
                    case 2430144: {
                        a = Randomizer.nextInt(373) + 2290000;
                        if (!MapleItemInformationProvider.getInstance().itemExists(a) || MapleItemInformationProvider.getInstance().getName(a).contains(MapleNodes.ALLATORIxDEMO("\u007f~ImEo@")) || MapleItemInformationProvider.getInstance().getName(a).contains(CashShopOperation.ALLATORIxDEMO("#@\u0003X\u0012"))) break;
                        v1 = var9_9;
                        MapleInventoryManipulator.addById(a, a, (short)1, MapleNodes.ALLATORIxDEMO("\u79d6\u5bea\u768a\u62ac\u80f3\u66d4\u737c\u5fbb"));
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                        break block644;
                    }
                    case 2430370: {
                        if (!MapleInventoryManipulator.checkSpace(a, 2028062, 1, "")) break;
                        MapleInventoryManipulator.addById(a, 2028062, (short)1, "Reward item: " + var5_6.getItemId() + " on " + FileoutputUtil.CurrentReadable_Date());
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430158: {
                        if (a.getPlayer().getInventory(MapleInventoryType.ETC).getNumFreeSlot() >= 1) {
                            if (a.getPlayer().getInventory(MapleInventoryType.ETC).countById(4000630) >= 100) {
                                if (MapleInventoryManipulator.checkSpace(a, 4310010, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), true ? 1 : 0, true, false)) {
                                    v1 = var9_9;
                                    MapleInventoryManipulator.addById(a, 4310010, (short)1);
                                } else {
                                    a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u6ac4\u67d3\u9035\u5141\u6b62\u4f7b\u7a1c\u95a5\u3064"));
                                    v1 = var9_9;
                                }
                            } else if (a.getPlayer().getInventory(MapleInventoryType.ETC).countById(4000630) >= 50) {
                                if (MapleInventoryManipulator.checkSpace(a, 4310009, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), true ? 1 : 0, true, false)) {
                                    v1 = var9_9;
                                    MapleInventoryManipulator.addById(a, 4310009, (short)1);
                                } else {
                                    a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                                    v1 = var9_9;
                                }
                            } else {
                                a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\n\u7323\u5b66\u73ed\u76b2\u7328\u727aX\u0003V\u503d\u5389\u517a\u63bd\u0007\u506d\u7373\u5b36\u73bd\u76e2\u8c82\u65a9\u7378\u54a7\uff3aW\u0006V\u503d\u5389\u517a\u63bd\u0007\u506d\u6dde\u5370\u76b2\u5770\u9a06\u3064"));
                                v1 = var9_9;
                            }
                        } else {
                            a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430159: {
                        MapleQuest.getInstance(3182).forceComplete(a.getPlayer(), 2161004);
                        v1 = var9_9;
                        MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                        break block644;
                    }
                    case 2430200: {
                        if (a.getPlayer().getQuestStatus(31152) != 2) {
                            v1 = var9_9;
                            a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u4f56\u4e6b\u77d3\u9035\u8a44\u59e4\u4f63\u4f19\u751e\u5be5\u3034N\u673f\u4e9d\u52ef\u5c7c\u671c\u5bea\u6226O"));
                        } else if (a.getPlayer().getInventory(MapleInventoryType.ETC).getNumFreeSlot() >= 1) {
                            if (a.getPlayer().getInventory(MapleInventoryType.ETC).countById(4000660) >= 1 && a.getPlayer().getInventory(MapleInventoryType.ETC).countById(4000661) >= 1 && a.getPlayer().getInventory(MapleInventoryType.ETC).countById(4000662) >= 1 && a.getPlayer().getInventory(MapleInventoryType.ETC).countById(4000663) >= 1) {
                                if (MapleInventoryManipulator.checkSpace(a, 4032923, 1, "") && MapleInventoryManipulator.removeById(a, MapleInventoryType.USE, var5_6.getItemId(), true ? 1 : 0, true, false) && MapleInventoryManipulator.removeById(a, MapleInventoryType.ETC, 4000660, true ? 1 : 0, true, false) && MapleInventoryManipulator.removeById(a, MapleInventoryType.ETC, 4000661, true ? 1 : 0, true, false) && MapleInventoryManipulator.removeById(a, MapleInventoryType.ETC, 4000662, true ? 1 : 0, true, false) && MapleInventoryManipulator.removeById(a, MapleInventoryType.ETC, 4000663, true ? 1 : 0, true, false)) {
                                    v1 = var9_9;
                                    v12 = a;
                                    MapleInventoryManipulator.addById(v12, 4032923, (short)1, v12.getPlayer().getName());
                                } else {
                                    a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                                    v1 = var9_9;
                                }
                            } else {
                                a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u512a\u63ed\u5944\u4e7d\u9416\u9736\u89e7\u0007\u506d\u95b5\u969d\u77c5\u3064"));
                                v1 = var9_9;
                            }
                        } else {
                            a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u907f\u5179\u6b28\u4f43\u7a56\u959d\u302e"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430130: 
                    case 2430131: {
                        v13 = a;
                        if (GameConstants.isResist(a.getPlayer().getJob())) {
                            MapleInventoryManipulator.removeFromSlot(v13, MapleInventoryType.USE, var3_4, (short)1, false);
                            a.getPlayer().gainExp(20000 + a.getPlayer().getLevel() * 50, true, true, false);
                            v1 = var9_9;
                        } else {
                            v13.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u7117\u6cb3\u4f49\u754e\u6b52\u720f\u54f7\u3064"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430132: 
                    case 2430133: 
                    case 2430134: 
                    case 2430142: {
                        if (a.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() >= 1) {
                            if (a.getPlayer().getJob() == 3200 || a.getPlayer().getJob() == 3210 || a.getPlayer().getJob() == 3211 || a.getPlayer().getJob() == 3212) {
                                MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                                MapleInventoryManipulator.addById(a, 1382101, (short)1, "Scripted item: " + var4_5 + " on " + FileoutputUtil.CurrentReadable_Date());
                                v1 = var9_9;
                            } else if (a.getPlayer().getJob() == 3300 || a.getPlayer().getJob() == 3310 || a.getPlayer().getJob() == 3311 || a.getPlayer().getJob() == 3312) {
                                MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                                MapleInventoryManipulator.addById(a, 1462093, (short)1, "Scripted item: " + var4_5 + " on " + FileoutputUtil.CurrentReadable_Date());
                                v1 = var9_9;
                            } else if (a.getPlayer().getJob() == 3500 || a.getPlayer().getJob() == 3510 || a.getPlayer().getJob() == 3511 || a.getPlayer().getJob() == 3512) {
                                MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                                MapleInventoryManipulator.addById(a, 1492080, (short)1, "Scripted item: " + var4_5 + " on " + FileoutputUtil.CurrentReadable_Date());
                                v1 = var9_9;
                            } else {
                                a.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("WC{\fcMw\f`Cz\f{_k\fzDg_.EzIc\u0002"));
                                v1 = var9_9;
                            }
                        } else {
                            a.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("{\u0007]\u0003\u0016\u0015Y\u000bSFE\u0016W\u0005SH"));
                            v1 = var9_9;
                        }
                        break block644;
                    }
                    case 2430170: {
                        var9_9 = 1027;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430223: {
                        var9_9 = 1031;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430259: {
                        var9_9 = 1031;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x251522: {
                        var9_9 = 80001018;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430243: {
                        var9_9 = 80001019;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430261: {
                        var9_9 = 80001019;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430249: {
                        var9_9 = 80001027;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x251511: {
                        var9_9 = 1031;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430257: {
                        var9_9 = 1029;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430057: {
                        var9_9 = 1033;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430272: {
                        var9_9 = 1038;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430275: {
                        var9_9 = 80001033;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430260: {
                        var9_9 = 1044;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430263: {
                        var9_9 = 1050;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430266: {
                        var9_9 = 1054;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430265: {
                        var9_9 = 1151;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430258: {
                        var9_9 = 1115;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430271: {
                        var9_9 = 1069;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430145: {
                        var9_9 = 1070;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430146: {
                        var9_9 = 1070;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430147: {
                        var9_9 = 1071;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430148: {
                        var9_9 = 1071;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430135: {
                        var9_9 = 1065;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430149: {
                        var9_9 = 1072;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430262: {
                        var9_9 = 1072;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430179: {
                        var9_9 = 1081;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430264: {
                        var9_9 = 1081;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430276: {
                        var9_9 = 1101;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430277: {
                        var9_9 = 1101;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430283: {
                        var9_9 = 1025;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430291: {
                        var9_9 = 1145;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x251555: {
                        var9_9 = 1146;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430295: {
                        var9_9 = 1147;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430297: {
                        var9_9 = 1148;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430299: {
                        var9_9 = 1149;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430301: {
                        var9_9 = 1150;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430303: {
                        var9_9 = 1151;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430305: {
                        var9_9 = 1152;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430307: {
                        var9_9 = 1153;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430309: {
                        var9_9 = 1154;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430311: {
                        var9_9 = 1156;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430313: {
                        var9_9 = 1156;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430315: {
                        var9_9 = 1118;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430317: {
                        var9_9 = 1121;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430319: {
                        var9_9 = 1122;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430321: {
                        var9_9 = 1123;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430323: {
                        var9_9 = 1124;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430325: {
                        var9_9 = 1129;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430327: {
                        var9_9 = 1130;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430329: {
                        var9_9 = 1063;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430331: {
                        var9_9 = 1025;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430333: {
                        var9_9 = 1034;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430335: {
                        var9_9 = 1136;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430337: {
                        var9_9 = 1051;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430339: {
                        var9_9 = 1138;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430341: {
                        var9_9 = 1139;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430343: {
                        var9_9 = 1027;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430346: {
                        var9_9 = 1029;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430348: {
                        var9_9 = 1028;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430350: {
                        var9_9 = 1033;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430352: {
                        var9_9 = 1064;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430354: {
                        var9_9 = 1096;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430356: {
                        var9_9 = 1101;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430358: {
                        var9_9 = 1102;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430360: {
                        var9_9 = 1054;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430362: {
                        var9_9 = 1053;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430292: {
                        var9_9 = 1145;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430294: {
                        var9_9 = 1146;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430296: {
                        var9_9 = 1147;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430298: {
                        var9_9 = 1148;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430300: {
                        var9_9 = 1149;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430302: {
                        var9_9 = 1150;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430304: {
                        var9_9 = 1151;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430306: {
                        var9_9 = 1152;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430308: {
                        var9_9 = 1153;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430310: {
                        var9_9 = 1154;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430312: {
                        var9_9 = 1156;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430314: {
                        var9_9 = 1156;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430316: {
                        var9_9 = 1118;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430318: {
                        var9_9 = 1121;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430320: {
                        var9_9 = 1122;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430322: {
                        var9_9 = 1123;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430326: {
                        var9_9 = 1129;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430328: {
                        var9_9 = 1130;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430330: {
                        var9_9 = 1063;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430332: {
                        var9_9 = 1025;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430334: {
                        var9_9 = 1034;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430336: {
                        var9_9 = 1136;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430338: {
                        var9_9 = 1051;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430340: {
                        var9_9 = 1138;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430342: {
                        var9_9 = 1139;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430344: {
                        var9_9 = 1027;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430347: {
                        var9_9 = 1029;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430349: {
                        var9_9 = 1028;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430351: {
                        var9_9 = 1033;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430353: {
                        var9_9 = 1064;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430355: {
                        var9_9 = 1096;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430357: {
                        var9_9 = 1101;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430359: {
                        var9_9 = 1102;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430361: {
                        var9_9 = 1054;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430363: {
                        var9_9 = 1053;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430324: {
                        var9_9 = 1158;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430345: {
                        var9_9 = 1158;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430367: {
                        var9_9 = 1115;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430365: {
                        var9_9 = 1025;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430366: {
                        var9_9 = 1025;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430369: {
                        var9_9 = 1049;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430392: {
                        var9_9 = 80001038;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430476: {
                        var9_9 = 1039;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430477: {
                        var9_9 = 1039;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430232: {
                        var9_9 = 1106;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430511: {
                        var9_9 = 80001033;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430512: {
                        var9_9 = 80001033;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430536: {
                        var9_9 = 80001114;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430537: {
                        var9_9 = 80001114;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430199: {
                        var9_9 = 1102;
                        var7_8 = 60L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430206: {
                        var9_9 = 1089;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430211: {
                        var9_9 = 80001009;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432311: {
                        var9_9 = 1089;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430521: {
                        var9_9 = 80001326;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432497: {
                        var9_9 = 80011029;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430707: {
                        var9_9 = 80001348;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430464: {
                        var9_9 = 80001120;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432735: {
                        var9_9 = 80001112;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432733: {
                        var9_9 = 80001552;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432487: {
                        var9_9 = 80001531;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432496: {
                        var9_9 = 80011028;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432518: {
                        var9_9 = 80011030;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430534: {
                        var9_9 = 80001113;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430992: {
                        var9_9 = 80001181;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430993: {
                        var9_9 = 80001181;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430994: {
                        var9_9 = 80001181;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430938: {
                        var9_9 = 80001194;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430939: {
                        var9_9 = 80001195;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430968: {
                        var9_9 = 80001196;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431137: {
                        var9_9 = 80001198;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431073: {
                        var9_9 = 80001199;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431135: {
                        var9_9 = 80001220;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431136: {
                        var9_9 = 80001221;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431268: {
                        var9_9 = 80001228;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431353: {
                        var9_9 = 80001237;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431362: {
                        var9_9 = 80001240;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431423: {
                        var9_9 = 80001243;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431424: {
                        var9_9 = 80011175;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431425: {
                        var9_9 = 80001245;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431426: {
                        var9_9 = 80001645;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431473: {
                        var9_9 = 80001257;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431474: {
                        var9_9 = 80001258;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434377: {
                        var9_9 = 80001792;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434379: {
                        var9_9 = 80001790;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434277: {
                        var9_9 = 80001786;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432172: {
                        var9_9 = 80001410;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432992: {
                        var9_9 = 80011109;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433069: {
                        var9_9 = 80011110;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432806: {
                        var9_9 = 80001557;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432994: {
                        var9_9 = 80001561;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432995: {
                        var9_9 = 80001562;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432996: {
                        var9_9 = 80001563;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432997: {
                        var9_9 = 80001564;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432998: {
                        var9_9 = 80001565;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432999: {
                        var9_9 = 80001566;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433000: {
                        var9_9 = 80001567;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433001: {
                        var9_9 = 80001568;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433002: {
                        var9_9 = 80001569;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433003: {
                        var9_9 = 80001570;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433051: {
                        var9_9 = 80001582;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433053: {
                        var9_9 = 80001584;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431898: {
                        var9_9 = 80001324;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431914: {
                        var9_9 = 80001326;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431915: {
                        var9_9 = 80001327;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432003: {
                        var9_9 = 80001331;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432007: {
                        var9_9 = 80001345;
                        var7_8 = 10L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432029: {
                        var9_9 = 80001346;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432030: {
                        var9_9 = 80001347;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432031: {
                        var9_9 = 80001348;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432078: {
                        var9_9 = 80001353;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432085: {
                        var9_9 = 80001355;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431883: {
                        var9_9 = 80001330;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431765: {
                        var9_9 = 80001290;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432015: {
                        var9_9 = 80001333;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432099: {
                        var9_9 = 80001336;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431950: {
                        var9_9 = 80001337;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432149: {
                        var9_9 = 80001398;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432151: {
                        var9_9 = 80001400;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432309: {
                        var9_9 = 80001404;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432328: {
                        var9_9 = 80001435;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432216: {
                        var9_9 = 80001411;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432218: {
                        var9_9 = 80001413;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432291: {
                        var9_9 = 80001419;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432293: {
                        var9_9 = 80001421;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432295: {
                        var9_9 = 80001423;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432347: {
                        var9_9 = 80001440;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432348: {
                        var9_9 = 80001441;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432349: {
                        var9_9 = 80001442;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432350: {
                        var9_9 = 80001443;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432351: {
                        var9_9 = 80001444;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432431: {
                        var9_9 = 80001480;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432433: {
                        var9_9 = 80001482;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432449: {
                        var9_9 = 80001484;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432582: {
                        var9_9 = 80001505;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432498: {
                        var9_9 = 80001508;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432500: {
                        var9_9 = 80001510;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432645: {
                        var9_9 = 80001531;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432653: {
                        var9_9 = 80001533;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434127: {
                        var9_9 = 80001549;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433499: {
                        var9_9 = 80001671;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433501: {
                        var9_9 = 80001673;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433735: {
                        var9_9 = 80001707;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433736: {
                        var9_9 = 80001708;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433809: {
                        var9_9 = 80001711;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433811: {
                        var9_9 = 80001713;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433292: {
                        var9_9 = 80011139;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433293: {
                        var9_9 = 80011140;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433497: {
                        var9_9 = 80011147;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433511: {
                        var9_9 = 80011148;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x252424: {
                        var9_9 = 80001701;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434142: {
                        var9_9 = 80011205;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434143: {
                        var9_9 = 80011206;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434235: {
                        var9_9 = 80011236;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434236: {
                        var9_9 = 80011237;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434037: {
                        var9_9 = 80011157;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433836: {
                        var9_9 = 80011179;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x252022: {
                        var9_9 = 80011180;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433059: {
                        var9_9 = 80011181;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433060: {
                        var9_9 = 80011182;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433168: {
                        var9_9 = 80011183;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433169: {
                        var9_9 = 80011184;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433170: {
                        var9_9 = 80011185;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433198: {
                        var9_9 = 80011186;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433881: {
                        var9_9 = 80011190;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433876: {
                        var9_9 = 80011189;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x252422: {
                        var9_9 = 80011199;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434083: {
                        var9_9 = 80011200;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2435116: {
                        v1 = var9_9 = 80011303;
                        break block644;
                    }
                    case 2435133: {
                        var9_9 = 80011289;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2435036: {
                        var9_9 = 80011289;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434965: {
                        var9_9 = 80011279;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434867: {
                        var9_9 = 80011279;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434360: {
                        var9_9 = 80011279;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434690: {
                        var9_9 = 80011272;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434618: {
                        var9_9 = 80011263;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434603: {
                        var9_9 = 80011262;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433742: {
                        var9_9 = 80011148;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433743: {
                        var9_9 = 80011147;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434163: {
                        var9_9 = 80011027;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432483: {
                        var9_9 = 80011027;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434737: {
                        var9_9 = 80001923;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434649: {
                        var9_9 = 80001918;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2435103: {
                        var9_9 = 80001814;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434518: {
                        var9_9 = 80001814;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 0x2525D5: {
                        var9_9 = 80001814;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434516: {
                        var9_9 = 80001811;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434515: {
                        var9_9 = 80001811;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434378: {
                        var9_9 = 80001792;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434380: {
                        var9_9 = 80001790;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434278: {
                        var9_9 = 80001787;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434276: {
                        var9_9 = 80001785;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434275: {
                        var9_9 = 80001784;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434079: {
                        var9_9 = 80001779;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434080: {
                        var9_9 = 80001778;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434078: {
                        var9_9 = 80001777;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434077: {
                        var9_9 = 80001776;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434013: {
                        var9_9 = 80001775;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434025: {
                        var9_9 = 80001774;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433949: {
                        var9_9 = 80001767;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433948: {
                        var9_9 = 80001766;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433947: {
                        var9_9 = 80001765;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433946: {
                        var9_9 = 80001764;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433932: {
                        var9_9 = 80001763;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433812: {
                        var9_9 = 80001714;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433810: {
                        var9_9 = 80001712;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433734: {
                        var9_9 = 80001708;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433500: {
                        var9_9 = 80001673;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433498: {
                        var9_9 = 80001671;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431542: {
                        var9_9 = 80001645;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431530: {
                        var9_9 = 80001645;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433350: {
                        var9_9 = 80001628;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433349: {
                        var9_9 = 80001627;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433348: {
                        var9_9 = 80001626;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433347: {
                        var9_9 = 80001625;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433346: {
                        var9_9 = 80001624;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433345: {
                        var9_9 = 80001623;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433277: {
                        var9_9 = 80001622;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433276: {
                        var9_9 = 80001621;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433275: {
                        var9_9 = 80001620;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433274: {
                        var9_9 = 80001619;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433273: {
                        var9_9 = 80001618;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433272: {
                        var9_9 = 80001617;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433054: {
                        var9_9 = 80001585;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433052: {
                        var9_9 = 80001583;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432807: {
                        var9_9 = 80001558;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432752: {
                        var9_9 = 80001555;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432751: {
                        var9_9 = 80001554;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432734: {
                        var9_9 = 80001553;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432501: {
                        var9_9 = 80001511;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432499: {
                        var9_9 = 80001509;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432583: {
                        var9_9 = 80001506;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432581: {
                        var9_9 = 80001504;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432580: {
                        var9_9 = 80001503;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432552: {
                        var9_9 = 80001492;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432528: {
                        var9_9 = 80001491;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432527: {
                        var9_9 = 80001490;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432450: {
                        var9_9 = 80001485;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432434: {
                        var9_9 = 80001483;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432432: {
                        var9_9 = 80001481;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432362: {
                        var9_9 = 80001448;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432361: {
                        var9_9 = 80001447;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432296: {
                        var9_9 = 80001424;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432294: {
                        var9_9 = 80001422;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432292: {
                        var9_9 = 80001420;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432219: {
                        var9_9 = 80001414;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432217: {
                        var9_9 = 80001412;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434567: {
                        var9_9 = 80001410;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432167: {
                        var9_9 = 80001403;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432152: {
                        var9_9 = 80001401;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432135: {
                        var9_9 = 80001397;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432079: {
                        var9_9 = 80001354;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432006: {
                        var9_9 = 80001345;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431949: {
                        var9_9 = 80001336;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431916: {
                        var9_9 = 80001328;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431899: {
                        var9_9 = 80001325;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430079: {
                        var9_9 = 80001293;
                        var7_8 = 172800000L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431758: {
                        var9_9 = 80001288;
                        var7_8 = 1440000L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431757: {
                        var9_9 = 80001287;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431756: {
                        var9_9 = 80001285;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431755: {
                        var9_9 = 80001285;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431745: {
                        var9_9 = 80001278;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431733: {
                        var9_9 = 80001278;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431722: {
                        var9_9 = 80001261;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431700: {
                        var9_9 = 80001261;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431573: {
                        var9_9 = 80001261;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431464: {
                        var9_9 = 80001246;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431529: {
                        var9_9 = 80001245;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431462: {
                        var9_9 = 80001245;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431541: {
                        var9_9 = 80001243;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434477: {
                        var9_9 = 80001196;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431697: {
                        var9_9 = 80001166;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431833: {
                        var9_9 = 80001114;
                        var7_8 = 50L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430203: {
                        var9_9 = 80001084;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430081: {
                        var9_9 = 80001024;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431698: {
                        var9_9 = 80001013;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430050: {
                        var9_9 = 80001073;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434191: {
                        var9_9 = 80001148;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2434161: {
                        var9_9 = 80001240;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433889: {
                        var9_9 = 80011194;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433888: {
                        var9_9 = 80011199;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433884: {
                        var9_9 = 80001057;
                        var7_8 = 14L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433866: {
                        var9_9 = 80011186;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433865: {
                        var9_9 = 80011136;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433864: {
                        var9_9 = 80011184;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433863: {
                        var9_9 = 80011183;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433862: {
                        var9_9 = 80011182;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433861: {
                        var9_9 = 80011181;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433860: {
                        var9_9 = 80011180;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433805: {
                        var9_9 = 80011109;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433729: {
                        var9_9 = 80011025;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433718: {
                        var9_9 = 80001019;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433707: {
                        var9_9 = 80001244;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433659: {
                        var9_9 = 80001703;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433658: {
                        var9_9 = 80001703;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433603: {
                        var9_9 = 80001244;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433567: {
                        var9_9 = 80001191;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433566: {
                        var9_9 = 80001190;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433565: {
                        var9_9 = 80001189;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433564: {
                        var9_9 = 80001188;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433513: {
                        var9_9 = 80001025;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433461: {
                        var9_9 = 80001645;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433460: {
                        var9_9 = 80001644;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433459: {
                        var9_9 = 80001504;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433458: {
                        var9_9 = 80001029;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433454: {
                        var9_9 = 80001023;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433406: {
                        var9_9 = 80001640;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433405: {
                        var9_9 = 80001639;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433325: {
                        var9_9 = 80011139;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433324: {
                        var9_9 = 80001022;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2433006: {
                        var9_9 = 80011062;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432989: {
                        var9_9 = 80001410;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432835: {
                        var9_9 = 80011095;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432821: {
                        var9_9 = 80011094;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432820: {
                        var9_9 = 80011093;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432736: {
                        var9_9 = 80001551;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432724: {
                        var9_9 = 80001549;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432654: {
                        var9_9 = 80001782;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432646: {
                        var9_9 = 80001532;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432635: {
                        var9_9 = 80001517;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432437: {
                        var9_9 = 80011025;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432243: {
                        var9_9 = 80001026;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432191: {
                        var9_9 = 80001196;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432190: {
                        var9_9 = 80001166;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432189: {
                        var9_9 = 80001329;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432170: {
                        var9_9 = 80001261;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432110: {
                        var9_9 = 80001222;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432106: {
                        var9_9 = 80001221;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432105: {
                        var9_9 = 80001220;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432104: {
                        var9_9 = 80001290;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432100: {
                        var9_9 = 80001335;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432086: {
                        var9_9 = 80001356;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2432008: {
                        var9_9 = 80001345;
                        var7_8 = 1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431951: {
                        var9_9 = 80001293;
                        var7_8 = 172800000L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431856: {
                        var9_9 = 80001304;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431800: {
                        var9_9 = 80001303;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431799: {
                        var9_9 = 80001302;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431798: {
                        var9_9 = 80001301;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431797: {
                        var9_9 = 80001300;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431779: {
                        var9_9 = 80001290;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431778: {
                        var9_9 = 80001294;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431777: {
                        var9_9 = 80011000;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431764: {
                        var9_9 = 80001294;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431760: {
                        var9_9 = 80001291;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431528: {
                        var9_9 = 80011175;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431527: {
                        var9_9 = 80001243;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431506: {
                        var9_9 = 80001020;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431505: {
                        var9_9 = 80001119;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431504: {
                        var9_9 = 80001111;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431503: {
                        var9_9 = 80001030;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431502: {
                        var9_9 = 80001005;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431501: {
                        var9_9 = 80001003;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431500: {
                        var9_9 = 80001018;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431499: {
                        var9_9 = 80001009;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431498: {
                        var9_9 = 80011289;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431497: {
                        var9_9 = 80001004;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431496: {
                        var9_9 = 80001026;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431495: {
                        var9_9 = 80001025;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431494: {
                        var9_9 = 80001015;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431493: {
                        var9_9 = 80001013;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431492: {
                        var9_9 = 80001006;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431491: {
                        var9_9 = 80001021;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431490: {
                        var9_9 = 80001199;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431458: {
                        var9_9 = 80001243;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431454: {
                        var9_9 = 80001241;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431452: {
                        var9_9 = 80001250;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431422: {
                        var9_9 = 80001237;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431415: {
                        var9_9 = 80001241;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431393: {
                        var9_9 = 80011028;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431392: {
                        var9_9 = 80011028;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431391: {
                        var9_9 = 80011028;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431372: {
                        var9_9 = 80011028;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431371: {
                        var9_9 = 80001175;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431370: {
                        var9_9 = 80001174;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431369: {
                        var9_9 = 80001173;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431368: {
                        var9_9 = 80001191;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431367: {
                        var9_9 = 80001189;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431366: {
                        var9_9 = 80001187;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431365: {
                        var9_9 = 80001190;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431364: {
                        var9_9 = 80001188;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431267: {
                        var9_9 = 80001228;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431134: {
                        var9_9 = 80001221;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431133: {
                        var9_9 = 80001220;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2431044: {
                        var9_9 = 80001198;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430991: {
                        var9_9 = 80001174;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430948: {
                        var9_9 = 80001190;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430937: {
                        var9_9 = 80001193;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430936: {
                        var9_9 = 80001192;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430935: {
                        var9_9 = 80001191;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430934: {
                        var9_9 = 80001190;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430933: {
                        var9_9 = 80001189;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430932: {
                        var9_9 = 80001188;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430593: {
                        var9_9 = 80001057;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430931: {
                        var9_9 = 80001187;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430930: {
                        var9_9 = 80001186;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430929: {
                        var9_9 = 80001185;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430928: {
                        var9_9 = 80001184;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430927: {
                        var9_9 = 80001183;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430918: {
                        var9_9 = 80001181;
                        var7_8 = 172800000L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430908: {
                        var9_9 = 80001175;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430907: {
                        var9_9 = 80001174;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430906: {
                        var9_9 = 80001173;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430871: {
                        var9_9 = 80001006;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430794: {
                        var9_9 = 80001163;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430728: {
                        var9_9 = 80001149;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430727: {
                        var9_9 = 80001148;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430726: {
                        var9_9 = 80001144;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430719: {
                        var9_9 = 80001025;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430718: {
                        var9_9 = 80001013;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430717: {
                        var9_9 = 80001504;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430654: {
                        var9_9 = 80001113;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430634: {
                        var9_9 = 80001006;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430633: {
                        var9_9 = 80001024;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430619: {
                        var9_9 = 80001113;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430617: {
                        var9_9 = 80001112;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430616: {
                        var9_9 = 80001114;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430615: {
                        var9_9 = 80001113;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430614: {
                        var9_9 = 80001112;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430613: {
                        var9_9 = 80001114;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430610: {
                        var9_9 = 80001022;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430598: {
                        var9_9 = 80001019;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430585: {
                        var9_9 = 80001113;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430580: {
                        var9_9 = 80001112;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430579: {
                        var9_9 = 80001114;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430566: {
                        var9_9 = 80001071;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430544: {
                        var9_9 = 80001002;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430535: {
                        var9_9 = 80001113;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430533: {
                        var9_9 = 80001112;
                        var7_8 = 90L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430532: {
                        var9_9 = 80001112;
                        var7_8 = -1L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430518: {
                        var9_9 = 80001090;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430508: {
                        var9_9 = 80001084;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430507: {
                        var9_9 = 80001083;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430506: {
                        var9_9 = 80001082;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430480: {
                        var9_9 = 80001239;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430475: {
                        var9_9 = 80001121;
                        var7_8 = 30L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430458: {
                        var9_9 = 80001326;
                        var7_8 = 7L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430202: {
                        var9_9 = 80001326;
                        var7_8 = 15L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430198: {
                        var9_9 = 80001015;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430196: {
                        var9_9 = 80001024;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430195: {
                        var9_9 = 80001017;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430194: {
                        var9_9 = 80001072;
                        var7_8 = 365L;
                        v1 = var9_9;
                        break block644;
                    }
                    case 2430578: {
                        var9_9 = 80001077;
                        var7_8 = 3L;
                        v1 = var9_9;
                        break block644;
                    }
                    default: {
                        ItemScriptManager.getInstance().start(a, var6_7.getNpc(), var5_6);
                    }
                }
            }
            v1 = var9_9;
        }
        if (v1 <= 0) ** GOTO lbl3072
        if (var9_9 < 80000000) {
            var9_9 = PlayerStats.getSkillByJob(var9_9, a.getPlayer().getJob());
        }
        if (a.getPlayer().getSkillLevel(var9_9) > 0) {
            v14 = a;
            v15 = v14;
            v14.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u5dfc\u7dbf\u6707\u4eaa\u9017\u5027\u628e\u80d1\u4e88\u302e"));
        } else if (var7_8 > 0L) {
            v16 = a;
            MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
            v15 = v16;
            v16.getPlayer().changeSkillLevel(SkillFactory.getSkill(var9_9), 1, 1, System.currentTimeMillis() + var7_8 * 24L * 60L * 60L * 1000L);
            v16.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u5d94\u7da5\u5b1e\u6735\u4ee0\u902f\u506d\u62b6\u809b\u4eb0\u3064"));
        } else {
            if (var7_8 == -1L) {
                MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var3_4, (short)1, false);
                v17 = a;
                v17.getPlayer().changeSkillLevel(SkillFactory.getSkill(var9_9), 1, 1);
                v17.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u5dde\u7d9d\u5b54\u670d\u4eaa\u9017\u5027\u628e\u80d1\u4e88\u302e"));
            }
lbl3072:
            // 4 sources

            v15 = a;
        }
        v15.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void handleApReset(LittleEndianAccessor a2, MapleClient a3) {
        if (a2.available() < 10L) {
            return;
        }
        a2.readInt();
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        Object object = GameConstants.getInventoryType(n2);
        if (n2 / 1000 != 2501) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        object = a3.getPlayer().getInventory((MapleInventoryType)((Object)object)).getItem(s2);
        if (object == null || object.getQuantity() <= 0 || object.getItemId() != n2 || a3.getPlayer().hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient = a3;
        InventoryHandler.handleApReset(s2, n2, mapleClient, mapleClient.getPlayer());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void handleKaiserColorChange(LittleEndianAccessor a2, MapleClient a3) {
        Object object;
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = (short)littleEndianAccessor.readInt();
        int n2 = littleEndianAccessor.readInt();
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(n2);
        if (n2 != 2350004 && n2 != 2350005 && n2 != 2350006 && n2 != 2350007) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        Object object2 = a3.getPlayer().getInventory(mapleInventoryType).getItem(s2);
        if (object2 == null || object2.getQuantity() <= 0 || object2.getItemId() != n2 || a3.getPlayer().hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        object2 = null;
        int n3 = 0;
        switch (n2) {
            case 2350004: {
                object2 = CashShopOperation.ALLATORIxDEMO("S\u001eB\u0003D\b");
                n3 = Randomizer.rand(0, 5);
                object = object2;
                break;
            }
            case 2350005: {
                object2 = MapleNodes.ALLATORIxDEMO("E`Bk^");
                n3 = Randomizer.rand(-10, 10);
                object = object2;
                break;
            }
            case 2350006: {
                object2 = CashShopOperation.ALLATORIxDEMO("\u0016D\u000f[\u000fC\u000b");
                n3 = 1;
                object = object2;
                break;
            }
            case 2350007: {
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().updateInfoQuest(12860, MapleNodes.ALLATORIxDEMO("~^gAgYc\u0011>\u0017kTzI|B3\u001c5E`Bk^3\u001c"));
                MapleInventoryManipulator.removeById(mapleClient, MapleInventoryType.USE, n2, true ? 1 : 0, true, false);
                return;
            }
            default: {
                object = object2;
            }
        }
        if (object != null) {
            a3.getPlayer().updateOneInfo(12860, (String)object2, String.valueOf(n3));
        }
        MapleInventoryManipulator.removeById(a3, MapleInventoryType.USE, n2, true ? 1 : 0, true, false);
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ boolean shuffleCoreAura(byte a2, MapleClient a3, MapleCharacter a4, boolean a522) {
        if (a3 == null || a4.getMap() == null) {
            return false;
        }
        if (a4.hasBlockedInventory() || a4.getCoreAura() == null) {
            a3.sendPacket(MaplePacketCreator.getInventoryFull());
            return false;
        }
        if (!a522) {
            IItem a522 = a4.getInventory(MapleInventoryType.USE).getItem(a2);
            if (a522 == null || a522.getQuantity() < 1 || a522.getItemId() != 2945000) {
                return false;
            }
            MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, a2, (short)1, false);
        }
        MapleCharacter mapleCharacter = a4;
        int a522 = mapleCharacter.getCoreAura().getStr();
        int n2 = mapleCharacter.getCoreAura().getDex();
        int n3 = mapleCharacter.getCoreAura().getInt();
        int n4 = mapleCharacter.getCoreAura().getLuk();
        int n5 = mapleCharacter.getCoreAura().getWatk();
        int n6 = mapleCharacter.getCoreAura().getMagic();
        mapleCharacter.getCoreAura().setWatk(a522);
        mapleCharacter.getCoreAura().setDex(n5);
        mapleCharacter.getCoreAura().setLuk(n2);
        mapleCharacter.getCoreAura().setMagic(n4);
        mapleCharacter.getCoreAura().setInt(n6);
        mapleCharacter.getCoreAura().setStr(n3);
        mapleCharacter.getStat().recalcLocalStats(false);
        a3.sendPacket(MaplePacketCreator.updateCoreAura(a4));
        return true;
    }

    private static /* synthetic */ List<IItem> ALLATORIxDEMO(List<IItem> a2) {
        Object object;
        ArrayList<Integer> serializable2 = new ArrayList<Integer>();
        Object object2 = object = a2.iterator();
        while (object2.hasNext()) {
            IItem iItem = object.next();
            object2 = object;
            serializable2.add(iItem.getItemId());
        }
        ArrayList<Integer> arrayList = serializable2;
        Collections.sort(arrayList);
        object = new LinkedList();
        block1: for (Integer n2 : arrayList) {
            for (IItem iItem : a2) {
                if (n2.intValue() != iItem.getItemId()) continue;
                object.add(iItem);
                a2.remove(iItem);
                continue block1;
            }
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void UseTreasureChest(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        String string;
        int n2;
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        int n3 = littleEndianAccessor.readInt();
        Object object = a4.getInventory(MapleInventoryType.ETC).getItem((byte)s2);
        if (object == null || object.getQuantity() <= 0 || object.getItemId() != n3) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        String string2 = "";
        switch (object.getItemId()) {
            case 4280000: {
                RandomRewards randomRewards = RandomRewards.getInstance();
                while (false) {
                }
                object = randomRewards.getGoldBoxReward();
                n2 = 5490000;
                string = CashShopOperation.ALLATORIxDEMO("\u91b7\u5bc0\u7bd7");
                if (!GameSetConstants.SERVER_NAME.equals(MapleNodes.ALLATORIxDEMO("\u6c18\u6efa\u8c1b"))) break;
                string = CashShopOperation.ALLATORIxDEMO("{\u0007NF\u9b62\u6cb3\u8c78\u7452");
                break;
            }
            case 4280001: {
                object = RandomRewards.getInstance().getSilverBoxReward();
                n2 = 5490001;
                string = MapleNodes.ALLATORIxDEMO("\u92ac\u5bf8\u7b9d");
                if (!GameSetConstants.SERVER_NAME.equals(CashShopOperation.ALLATORIxDEMO("\u6c52\u6ec2\u8c51"))) break;
                string = MapleNodes.ALLATORIxDEMO("\u9b5a\u6cf9\u8c40\u7418");
                break;
            }
            default: {
                return;
            }
        }
        string2 = MapleItemInformationProvider.getInstance().getName(n2);
        if (a4.getInventory(MapleInventoryType.CASH).countById(n2) > 0) {
            if (a4.getInventory(MapleInventoryType.EQUIP).getNextFreeSlot() > -1 && a4.getInventory(MapleInventoryType.USE).getNextFreeSlot() > -1 && a4.getInventory(MapleInventoryType.SETUP).getNextFreeSlot() > -1 && a4.getInventory(MapleInventoryType.ETC).getNextFreeSlot() > -1) {
                Object object2 = object;
                int n4 = Randomizer.rand(((RandomRewards.RewardInfo)object).getMinNumber(), ((RandomRewards.RewardInfo)object2).getMaxNumber());
                IItem iItem = MapleInventoryManipulator.addbyId_Gachapon(a3, ((RandomRewards.RewardInfo)object).getItemId(), (short)n4, false);
                byte by = GameConstants.gachaponRareItem(iItem.getItemId());
                MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.ETC, (byte)s2, true ? 1 : 0, true);
                MapleInventoryManipulator.removeById(a3, MapleInventoryType.CASH, n2, true ? 1 : 0, true, false);
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(MaplePacketCreator.getShowItemGain(((RandomRewards.RewardInfo)object).getItemId(), (short)n4, true));
                mapleClient.sendPacket(MaplePacketCreator.treasure_Box(n3));
                if (((RandomRewards.RewardInfo)object2).getShowMessage() <= 0) return;
                World.Broadcast.broadcastMessage(MaplePacketCreator.getGachaponMega("\u606d\u559c\u0010 " + a3.getPlayer().getName() + " : \u5f9e" + string + "\u62bd\u5230\uff01", iItem, a3.getChannel(), a3.getPlayer().getName()));
                return;
            }
            a4.dropMessage(5, "\u4f60\u6709\u4e00\u500b\u6b04\u4f4d\u6eff\u4e86\uff0c\u8acb\u7a7a\u51fa\u4f86\u518d\u6253\u958b" + string + "\uff01");
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a4.dropMessage(5, "\u8acb\u78ba\u8a8d\u662f\u5426\u6709" + string2);
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ void resetCoreAura(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        byte by = a2.readByte();
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
        if (a3 == null || a4.getMap() == null || iItem == null || iItem.getQuantity() < 1) {
            return;
        }
        if (a4.hasBlockedInventory() || a4.getCoreAura() == null) {
            a3.sendPacket(MaplePacketCreator.getInventoryFull());
            return;
        }
        if (iItem.getItemId() != 2940000 && iItem.getItemId() != 2940001 && iItem.getItemId() != 2940002) {
            a3.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6b48\u905d\u515b\u712f\u6cf9\u4f71\u7504"));
            return;
        }
        MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
        MapleCharacter mapleCharacter = a4;
        mapleCharacter.getCoreAura().upgradeCoreAura(iItem.getItemId());
        mapleCharacter.getStat().recalcLocalStats(false);
        a3.sendPacket(MaplePacketCreator.updateCoreAura(mapleCharacter));
        if (a4.getCoreAura().getDelay()) {
            MapleCharacter mapleCharacter2 = a4;
            mapleCharacter2.getCoreAura().setDelay(false);
            mapleCharacter2.dropMessage(6, CashShopOperation.ALLATORIxDEMO("\u96e0\u7150\u5dc4\u4f19\u751e\u9028\u671e\u7938\u53d3\u82f4\u76b2\u842f\u5b66\uff6a\u56d6\u51eb\u6b17\u8a4b\u5bac\u809b\u52ad\u505a\uff3a\u6226\u4ed3\u6624\u95a5\u91ab\u7f58\u3064"));
        }
    }

    public static /* synthetic */ boolean addCoreAuraExpire(byte a2, MapleClient a3, MapleCharacter a4, boolean a52) {
        MapleCharacter mapleCharacter;
        long l2;
        block6: {
            block5: {
                block4: {
                    if (a3 == null || a4.getMap() == null) {
                        return false;
                    }
                    if (a4.hasBlockedInventory() || a4.getCoreAura() == null) {
                        a3.sendPacket(MaplePacketCreator.getInventoryFull());
                        return false;
                    }
                    long l3 = System.currentTimeMillis() + 31536000000L;
                    l2 = a3.getPlayer().getCoreAura().getExpiration() + 2592000000L;
                    if (!a52) break block4;
                    if (l2 <= l3) break block5;
                    l2 = l3;
                    mapleCharacter = a4;
                    break block6;
                }
                IItem a52 = a4.getInventory(MapleInventoryType.USE).getItem(a2);
                if (a52 == null || a52.getQuantity() < 1) {
                    return false;
                }
                if (a52.getItemId() != 2943000) {
                    a3.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6700\u905d\u515b\u76e0\u5261\u712f\u6cf9\u4f71\u7504"));
                    return false;
                }
                MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, a2, (short)1, false);
                l2 = System.currentTimeMillis() + 604800000L;
            }
            mapleCharacter = a4;
        }
        mapleCharacter.getCoreAura().setDelay(true);
        MapleCharacter mapleCharacter2 = a4;
        mapleCharacter2.getCoreAura().setExpiration(l2);
        a3.sendPacket(MaplePacketCreator.updateCoreAura(mapleCharacter2));
        return true;
    }

    public static final /* synthetic */ boolean UseTeleRock(LittleEndianAccessor a2, MapleClient a3, int a4) {
        boolean bl;
        block8: {
            boolean bl2;
            block5: {
                block6: {
                    block7: {
                        block4: {
                            bl2 = false;
                            if (a4 == 5041001 || a4 == 5040004) {
                                a2.readByte();
                            }
                            if (a2.readByte() != 0) break block4;
                            int n2 = a2.readInt();
                            MapleMap mapleMap = a3.getChannelServer().getMapFactory().getMap(n2);
                            if (!a3.getPlayer().inMapleLand() && !MapConstants.isMapleLand(n2)) {
                                if ((a4 == 5041000 && a3.getPlayer().isRockMap(mapleMap.getId()) || a4 != 5041000 && a3.getPlayer().isRegRockMap(mapleMap.getId()) || a4 == 5040004 || a4 == 5041001) && !FieldLimitType.VipRock.check(a3.getPlayer().getMap().getFieldLimit()) && !FieldLimitType.VipRock.check(mapleMap.getFieldLimit()) && a3.getPlayer().getEventInstance() == null && !a3.getPlayer().isInBlockedMap()) {
                                    MapleClient mapleClient = a3;
                                    mapleClient.getPlayer().handleMonsterEffectCard();
                                    MapleMap mapleMap2 = mapleMap;
                                    mapleClient.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(0));
                                    mapleClient.getPlayer().StopDpm();
                                    bl2 = true;
                                }
                            } else {
                                a3.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u710d\u6cdb\u5704\u695d\u4e67\u5cf8\u4f53\u7526\u302e"));
                            }
                            break block5;
                        }
                        MapleCharacter mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterByName(a2.readMapleAsciiString());
                        if (mapleCharacter == null || mapleCharacter.isGM() || a3.getPlayer().getEventInstance() != null || mapleCharacter.getEventInstance() != null) break block5;
                        if (mapleCharacter.inMapleLand()) break block6;
                        if (FieldLimitType.VipRock.check(a3.getPlayer().getMap().getFieldLimit()) || FieldLimitType.VipRock.check(a3.getChannelServer().getMapFactory().getMap(mapleCharacter.getMapId()).getFieldLimit()) || mapleCharacter.isInBlockedMap() || a3.getPlayer().isInBlockedMap()) break block7;
                        if (a4 != 5041000 && a4 != 5040004 && a4 != 5041001 && mapleCharacter.getMapId() / 100000000 != a3.getPlayer().getMapId() / 100000000) break block5;
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().changeMap(mapleCharacter.getMap(), mapleCharacter.getMap().findClosestSpawnpoint(mapleCharacter.getPosition()));
                        mapleClient.getPlayer().StopDpm();
                        bl = bl2 = true;
                        break block8;
                    }
                    a3.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u7117\u6cb3\u5085\u9067\u5206\u6b02\u739f\u5bd0\u6276\u574e\u76b2\u5326\u57e9\u3064"));
                    bl = bl2;
                    break block8;
                }
                a3.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u710d\u6cdb\u509f\u900f\u521c\u695d\u4e67\u5cf8\u302e"));
            }
            bl = bl2;
        }
        return bl && a4 != 5041001 && a4 != 5040004;
    }

    public static final /* synthetic */ void UseMagnify(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        a3.getPlayer().updateTick(littleEndianAccessor.readInt());
        InventoryHandler.UseMagnify((byte)littleEndianAccessor.readShort(), (byte)a2.readShort(), a3);
    }

    public static final /* synthetic */ void MoveBag(LittleEndianAccessor a2, MapleClient a3) {
        boolean bl;
        short s2;
        MapleClient mapleClient;
        byte by;
        if (a3.getPlayer().hasBlockedInventory()) {
            return;
        }
        if (a2.available() < 15L) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient2 = a3;
        mapleClient2.getPlayer().setScrolledPosition((short)0);
        mapleClient2.getPlayer().updateTick(a2.readInt());
        boolean bl2 = a2.readInt() > 0;
        short s3 = (short)a2.readInt();
        if ((GameSetConstants.MAPLE_VERSION >= 152 ? (by = (byte)a2.readByte()) : (by = 4)) != 4) {
            a3.getSession().write((Object)MaplePacketCreator.enableActions());
            return;
        }
        a2.readByte();
        short s4 = a2.readShort();
        MapleClient mapleClient3 = a3;
        if (!bl2) {
            mapleClient3.getPlayer().getInventory(MapleInventoryType.getByType(by)).addBagItem();
            mapleClient = a3;
        } else {
            mapleClient3.getPlayer().getInventory(MapleInventoryType.getByType(by)).removeBagItem();
            mapleClient = a3;
        }
        MapleInventoryType mapleInventoryType = MapleInventoryType.getByType(by);
        if (bl2) {
            s2 = s3;
            bl = bl2;
        } else {
            s2 = s4;
            bl = bl2;
        }
        MapleInventoryManipulator.move(mapleClient, mapleInventoryType, s2, bl ? s4 : s3, true, !bl2);
    }

    public static final /* synthetic */ void removeItemMonsterPet(MapleCharacter a2, MapleMapItem a3) {
        MapleCharacter mapleCharacter = a2;
        MapleMapItem mapleMapItem = a3;
        mapleMapItem.setPickedUp(true);
        mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.removeItemFromMap(a3.getObjectId(), 5, a2.getId(), 0), a3.getPosition());
        mapleCharacter.getMap().removeMapObject(a3);
        if (mapleMapItem.isRandDrop()) {
            a2.getMap().spawnRandDrop();
        }
    }

    public static /* synthetic */ void removeItem(MapleCharacter a2, MapleMapItem a3, MapleMapObject a4) {
        MapleCharacter mapleCharacter = a2;
        MapleMapItem mapleMapItem = a3;
        mapleMapItem.setPickedUp(true);
        mapleCharacter.getMap().broadcastMessage(MaplePacketCreator.removeItemFromMap(a3.getObjectId(), 2, a2.getId()), a3.getPosition());
        mapleCharacter.getMap().removeMapObject(a3);
        if (mapleMapItem.isRandDrop()) {
            a2.getMap().spawnRandDrop();
        }
    }

    public static final /* synthetic */ void PetPickup(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        block31: {
            block30: {
                if (a4 != null) break block30;
                return;
            }
            if (!GameSetConstants.isPickupMapBan(a4.getMapId())) break block31;
            a3.sendPacket(MaplePacketCreator.getInventoryFull());
            return;
        }
        try {
            MapleCharacter mapleCharacter;
            boolean bl;
            boolean bl2;
            byte by;
            block33: {
                boolean bl3;
                block35: {
                    block34: {
                        block32: {
                            bl3 = false;
                            by = 0;
                            bl2 = false;
                            if (!a4.isPetVac() && a4.getPetVacTime() <= System.currentTimeMillis()) break block32;
                            bl = bl3 = true;
                            break block33;
                        }
                        if (GameSetConstants.PETVAC_EQUIP.length == 0) break block34;
                        if (!GameSetConstants.isPetVacEquip(a4)) break block35;
                        bl3 = true;
                        by = 1;
                        bl = bl3;
                        break block33;
                    }
                    if (SpecialEquipFactory.getInstance().getVac(a4) > 0) {
                        bl3 = true;
                        bl2 = true;
                    }
                }
                bl = bl3;
            }
            if (bl) {
                InventoryHandler.PetPickup_Petvac(a2, a3, a4, by != 0, bl2);
                return;
            }
            by = 0;
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                mapleCharacter = a4;
                by = (byte)a2.readInt();
            } else {
                by = a3.getPlayer().getPetIndex((int)a2.readLong());
                mapleCharacter = a4;
            }
            Serializable serializable = mapleCharacter.getPet(by);
            LittleEndianAccessor littleEndianAccessor = a2;
            littleEndianAccessor.skip(1);
            a4.updateTick(littleEndianAccessor.readInt());
            Point point = littleEndianAccessor.readPos();
            MapleMapObject mapleMapObject = a4.getMap().getMapObject(a2.readInt(), MapleMapObjectType.ITEM);
            if (mapleMapObject == null || serializable == null) {
                return;
            }
            mapleMapObject = (MapleMapItem)mapleMapObject;
            Iterator iterator = ((MapleMapItem)mapleMapObject).getLock();
            if (((MapleMapItem)mapleMapObject).isPickedUp()) {
                a3.sendPacket(MaplePacketCreator.getInventoryFull());
                return;
            }
            if (((MapleMapItem)mapleMapObject).getOwner() != a4.getId() && ((MapleMapItem)mapleMapObject).isPlayerDrop()) {
                return;
            }
            if (((MapleMapItem)mapleMapObject).getOwner() != a4.getId() && (!((MapleMapItem)mapleMapObject).isPlayerDrop() && ((MapleMapItem)mapleMapObject).getDropType() == 0 || ((MapleMapItem)mapleMapObject).isPlayerDrop() && a4.getMap().getEverlast())) {
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (!(((MapleMapItem)mapleMapObject).isPlayerDrop() || ((MapleMapItem)mapleMapObject).getDropType() != 1 || ((MapleMapItem)mapleMapObject).getOwner() == a4.getId() || a4.getParty() != null && a4.getParty().getMemberById(((MapleMapItem)mapleMapObject).getOwner()) != null)) {
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (((MapleMapItem)mapleMapObject).isPlayerDrop() && ((MapleMapItem)mapleMapObject).getDropType() == 2 && ((MapleMapItem)mapleMapObject).getOwner() == a4.getId()) {
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (a4.getTrade() != null) {
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            double d2 = point.distanceSq(((AbstractMapleMapObject)mapleMapObject).getPosition());
            double d3 = ((MaplePet)serializable).getPos().distanceSq(((AbstractMapleMapObject)mapleMapObject).getPosition());
            if (GameSetConstants.PET_VAC_CHECK) {
                if (d2 > 10000.0 && (((MapleMapItem)mapleMapObject).getMeso() > 0 || ((MapleMapItem)mapleMapObject).getItemId() != 4001025)) {
                    a4.getCheatTracker().registerOffense(CheatingOffense.PET_ITEMVAC_CLIENT, "\u8ddd\u96e2" + d2 + " \u5bf5\u7269\u5ea7\u6a19 (" + point.getX() + "," + point.getY() + ")\u7269\u54c1\u5ea7\u6a19 (" + ((AbstractMapleMapObject)mapleMapObject).getPosition().getX() + "," + ((AbstractMapleMapObject)mapleMapObject).getPosition().getY() + ")");
                }
                double d4 = GameSetConstants.MAPLE_VERSION >= 134 ? 640000.0 : 120000.0;
                if (d3 > d4 && !a3.getPlayer().isPetVac() && a4.getPetVacTime() < System.currentTimeMillis()) {
                    if (!a4.checkWarpingMap()) {
                        a4.getCheatTracker().registerOffense(CheatingOffense.PET_ITEMVAC_SERVER, "\u8ddd\u96e2" + d3 + " \u5bf5\u7269\u5ea7\u6a19 (" + ((MaplePet)serializable).getPos().getX() + "," + ((MaplePet)serializable).getPos().getY() + ")\u7269\u54c1\u5ea7\u6a19 (" + ((AbstractMapleMapObject)mapleMapObject).getPosition().getX() + "," + ((AbstractMapleMapObject)mapleMapObject).getPosition().getY() + ")");
                    }
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
            }
            if (((MapleMapItem)mapleMapObject).getMeso() > 0) {
                MapleCharacter mapleCharacter2;
                if (a4.getParty() != null && ((MapleMapItem)mapleMapObject).getOwner() != a4.getId()) {
                    serializable = new LinkedList();
                    int n2 = ((MapleMapItem)mapleMapObject).getMeso() * 40 / 100;
                    iterator = a4.getParty().getMembers().iterator();
                    while (iterator.hasNext()) {
                        MaplePartyCharacter maplePartyCharacter = (MaplePartyCharacter)iterator.next();
                        MapleCharacter mapleCharacter3 = a4.getMap().getCharacterById(maplePartyCharacter.getId());
                        if (mapleCharacter3 == null || mapleCharacter3.getId() == a4.getId()) continue;
                        serializable.add(mapleCharacter3);
                    }
                    Iterator iterator2 = iterator = serializable.iterator();
                    while (iterator2.hasNext()) {
                        MapleCharacter mapleCharacter4;
                        MapleCharacter mapleCharacter5 = mapleCharacter4 = (MapleCharacter)iterator.next();
                        mapleCharacter5.gainMeso(n2 / serializable.size() + (mapleCharacter5.getStat().hasPartyBonus ? (int)((double)((MapleMapItem)mapleMapObject).getMeso() / 20.0) : 0), true);
                        iterator2 = iterator;
                    }
                    MapleCharacter mapleCharacter6 = a4;
                    mapleCharacter2 = mapleCharacter6;
                    mapleCharacter6.gainMeso(((MapleMapItem)mapleMapObject).getMeso() - n2, true);
                } else {
                    MapleCharacter mapleCharacter7 = a4;
                    mapleCharacter2 = mapleCharacter7;
                    mapleCharacter7.gainMeso(((MapleMapItem)mapleMapObject).getMeso(), true);
                }
                InventoryHandler.removeItemPet(mapleCharacter2, (MapleMapItem)mapleMapObject, by);
                return;
            }
            if (MapleItemInformationProvider.getInstance().isPickupBlocked(((MapleMapItem)mapleMapObject).getItemId()) || ((MapleMapItem)mapleMapObject).getItemId() / 10000 == 291) {
                a3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (InventoryHandler.useItem(a3, ((MapleMapItem)mapleMapObject).getItemId())) {
                InventoryHandler.removeItemPet(a4, (MapleMapItem)mapleMapObject, by);
                return;
            }
            if (ItemConstants.getSpecialItem(((MapleMapItem)mapleMapObject).getItemId(), a3.getPlayer())) {
                MapleClient mapleClient = a3;
                InventoryHandler.removeItemPet(a4, (MapleMapItem)mapleMapObject, by);
                mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
                mapleClient.sendPacket(MaplePacketCreator.getShowInventoryFull());
                return;
            }
            if (MapleInventoryManipulator.checkSpace(a3, ((MapleMapItem)mapleMapObject).getItemId(), ((MapleMapItem)mapleMapObject).getItem().getQuantity(), ((MapleMapItem)mapleMapObject).getItem().getOwner())) {
                if (MapleInventoryManipulator.addFromDrop(a3, ((MapleMapItem)mapleMapObject).getItem(), true, ((MapleMapItem)mapleMapObject).getDropper() instanceof MapleMonster, true)) {
                    InventoryHandler.removeItemPet(a4, (MapleMapItem)mapleMapObject, by);
                }
                if (((MapleMapItem)mapleMapObject).isPlayerDrop() && GameSetConstants.COPTITEMCHECK_STRICT && ((MapleMapItem)mapleMapObject).getItem().getEquipOnlyId() > 0L) {
                    a3.getPlayer().checkCopyItemsByID(((MapleMapItem)mapleMapObject).getOwner(), ((MapleMapItem)mapleMapObject).getItemId());
                    return;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2, StringBuilder a3) {
        IItem iItem = a2.getInventory(MapleInventoryType.EQUIPPED).getItem((short)-21);
        if (iItem != null) {
            a3.append(CashShopOperation.ALLATORIxDEMO("Z"));
            a3.append(MapleItemInformationProvider.getInstance().getName(iItem.getItemId()));
            a3.append(MapleNodes.ALLATORIxDEMO("0\f"));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ boolean ApRedistribute(MapleClient a, MapleStat a, MapleStat a) {
        block88: {
            var3_13 = new ArrayList<Pair<MapleStat, Integer>>(2);
            v0 = a;
            var4_14 = v0.getPlayer().getJob();
            var5_15 = v0.getPlayer().getStat();
            var6_16 = false;
            var7_17 = GameSetConstants.WASH_HP_LIMIT;
            if (v0.getPlayer().isReborn()) {
                var7_17 *= 2;
            }
            if (a == a) {
                return false;
            }
            if (!GameSetConstants.UNLIMITMPTOHP && a == MapleStat.MAXMP && a != MapleStat.MAXHP) {
                a.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("+f\u7147\u6ce3\u58f8\u5296\u5256~6\u4ed3\u5970\u76b2\u5c0a\u6011\u5551"));
                return false;
            }
            if (!GameSetConstants.UNLIMITMPTOHP && a == MapleStat.MAXHP && a != MapleStat.MAXMP) {
                a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("d^\u710d\u6cdb\u58b2\u52ae\u521cC|\u4eeb\u593a\u768a\u5c40\u6029\u551b"));
                return false;
            }
            if (var5_15.getMaxHp() < 50 || var5_15.getMaxMp() < 50) {
                a.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u609e\u76e2\u8876\u91a9\u8231\u9b32\u52ad\u4f28\u658aS\u0006\u7147\u6ce3\u4f19\u751e\u3064"));
                return false;
            }
            var6_16 = true;
            switch (1.ALLATORIxDEMO[a.ordinal()]) {
                case 1: {
                    if (var5_15.getStr() < 999) break;
                    var6_16 = false;
                    break;
                }
                case 2: {
                    if (var5_15.getDex() < 999) break;
                    var6_16 = false;
                    break;
                }
                case 3: {
                    if (var5_15.getInt() < 999) break;
                    var6_16 = false;
                    break;
                }
                case 4: {
                    if (var5_15.getLuk() < 999) break;
                    var6_16 = false;
                    break;
                }
                case 5: {
                    if (var5_15.getMaxHp() <= 1 || var5_15.getMaxHp() >= 30000) {
                        var6_16 = false;
                    }
                    if (a.getPlayer().getHpMpApUsed() < var7_17) break;
                    a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6d19\u886c\u6b2f\u6554\u5dfc\u9078\u670e\u590b\u5032\r"));
                    var6_16 = false;
                    break;
                }
                case 6: {
                    if (var5_15.getMaxMp() <= 1 || var5_15.getMaxMp() >= 30000) {
                        var6_16 = false;
                    }
                    if (a.getPlayer().getHpMpApUsed() < var7_17) break;
                    a.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u6d21\u8826\u6b17\u651e\u5dc4\u9032\u6736\u5941\u500aG"));
                    var6_16 = false;
                    break;
                }
            }
            switch (1.ALLATORIxDEMO[a.ordinal()]) {
                case 1: {
                    if (var5_15.getStr() <= 4) {
                        a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u52b7\u91c1\u710d\u6cdb\u6d3b\u4f40\u6590:\r"));
                        var6_16 = false;
                    }
                    if (a.getPlayer().getJob() % 1000 / 100 != 1 || var5_15.getStr() > 35) break;
                    a.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u52ad\u91a9\u7117\u6cb3\u6d21\u4f28\u658aU\u0003G"));
                    v1 = var6_16 = false;
                    break block88;
                }
                case 2: {
                    if (!(var5_15.getDex() <= 4 || a.getPlayer().getJob() % 1000 / 100 == 3 && var5_15.getDex() <= 25 || a.getPlayer().getJob() % 1000 / 100 == 4 && var5_15.getDex() <= 25) && (a.getPlayer().getJob() % 1000 / 100 != 5 || var5_15.getDex() > 20)) break;
                    a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6563\u6379\u710d\u6cdb\u6d3b\u9017\u9e90\u4f40\r"));
                    v1 = var6_16 = false;
                    break block88;
                }
                case 3: {
                    if (var5_15.getInt() > 4 && (a.getPlayer().getJob() % 1000 / 100 != 2 || var5_15.getInt() > 20)) break;
                    a.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u661c\u52ad\u7147\u6ce3\u6d71\u902f\u9eda\u4f78G"));
                    v1 = var6_16 = false;
                    break block88;
                }
                case 4: {
                    if (var5_15.getLuk() > 4) break;
                    a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u5e54\u9045\u710d\u6cdb\u6d3b\u4f40\u6590:\r"));
                    v1 = var6_16 = false;
                    break block88;
                }
                case 5: {
                    if (a.getPlayer().getHpWash() <= 0L || a.getPlayer().getHpMpApUsed() <= 0) {
                        var6_16 = false;
                    }
                    if (a.getPlayer().getHpMpApUsed() < var7_17) break;
                    a.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u6d21\u8826\u6b17\u651e\u5dc4\u9032\u6736\u5941\u500aG"));
                    v1 = var6_16 = false;
                    break block88;
                }
                case 6: {
                    if (a.getPlayer().getHpMpApUsed() <= 0) {
                        var6_16 = false;
                    }
                    if (a.getPlayer().getHpMpApUsed() < var7_17) break;
                    a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6d19\u886c\u6b2f\u6554\u5dfc\u9078\u670e\u590b\u5032\r"));
                    var6_16 = false;
                }
            }
            v1 = var6_16;
        }
        if (v1 == false) return var6_16;
        switch (1.ALLATORIxDEMO[a.ordinal()]) {
            case 1: {
                v2 = var5_15;
                a = v2.getStr() + 1;
                v2.setStr((short)a);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.STR, a));
                break;
            }
            case 2: {
                v3 = var5_15;
                a = v3.getDex() + 1;
                v3.setDex((short)a);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.DEX, a));
                break;
            }
            case 3: {
                v4 = var5_15;
                a = v4.getInt() + 1;
                v4.setInt((short)a);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.INT, a));
                break;
            }
            case 4: {
                v5 = var5_15;
                a = v5.getLuk() + 1;
                v5.setLuk((short)a);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.LUK, a));
                break;
            }
            case 5: {
                a = var5_15.getMaxHp();
                if (var4_14 == 0) {
                    a += Randomizer.rand(8, 12);
                } else if (var4_14 >= 100 && var4_14 <= 132 || var4_14 >= 3200 && var4_14 <= 3212) {
                    var7_18 = SkillFactory.getSkill(1000001);
                    var8_27 = a.getPlayer().getSkillLevel(var7_18);
                    a += Randomizer.rand(20, 25);
                    if (var8_27 >= 1) {
                        a += var7_18.getEffect(var8_27).getY();
                    }
                } else if (var4_14 >= 200 && var4_14 <= 232 || JobConstants.isEvan(var4_14)) {
                    a += Randomizer.rand(10, 20);
                } else if (var4_14 >= 300 && var4_14 <= 322 || var4_14 >= 400 && var4_14 <= 434 || var4_14 >= 1300 && var4_14 <= 1312 || var4_14 >= 1400 && var4_14 <= 1412 || var4_14 >= 3300 && var4_14 <= 3312) {
                    a += Randomizer.rand(16, 20);
                } else if (var4_14 >= 500 && var4_14 <= 522 || var4_14 >= 3500 && var4_14 <= 3512) {
                    var7_19 = SkillFactory.getSkill(5100000);
                    var8_27 = a.getPlayer().getSkillLevel(var7_19);
                    a += Randomizer.rand(18, 22);
                    if (var8_27 >= 1) {
                        a += var7_19.getEffect(var8_27).getY();
                    }
                } else if (var4_14 >= 1500 && var4_14 <= 1512) {
                    var7_20 = SkillFactory.getSkill(15100000);
                    var8_27 = a.getPlayer().getSkillLevel(var7_20);
                    a += Randomizer.rand(18, 22);
                    if (var8_27 >= 1) {
                        a += var7_20.getEffect(var8_27).getY();
                    }
                } else if (var4_14 >= 1100 && var4_14 <= 1112) {
                    var7_21 = SkillFactory.getSkill(11000000);
                    var8_27 = a.getPlayer().getSkillLevel(var7_21);
                    a += Randomizer.rand(36, 42);
                    if (var8_27 >= 1) {
                        a += var7_21.getEffect(var8_27).getY();
                    }
                } else {
                    a = var4_14 >= 1200 && var4_14 <= 1212 ? (a += Randomizer.rand(15, 21)) : (var4_14 >= 2000 && var4_14 <= 2112 ? (a += Randomizer.rand(40, 50)) : (a += Randomizer.rand(1, 10)));
                }
                a = (short)Math.min(30000, Math.abs(a));
                v6 = a;
                v6.getPlayer().addHpWash();
                v6.getPlayer().setHpMpApUsed((short)(a.getPlayer().getHpMpApUsed() + 1));
                var5_15.setMaxHp(a);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.MAXHP, a));
                break;
            }
            case 6: {
                var7_17 = var5_15.getMaxMp();
                if (var4_14 == 0) {
                    var7_17 += Randomizer.rand(6, 8);
                } else if (var4_14 >= 100 && var4_14 <= 132) {
                    var7_17 += Randomizer.rand(5, 7);
                } else if (var4_14 >= 200 && var4_14 <= 232 || JobConstants.isEvan(var4_14)) {
                    var8_28 = SkillFactory.getSkill(2000001);
                    var9_35 = a.getPlayer().getSkillLevel(var8_28);
                    var7_17 += Randomizer.rand(18, 20);
                    if (var9_35 >= 1) {
                        var7_17 += var8_28.getEffect(var9_35).getY() * 2;
                    }
                } else if (var4_14 >= 300 && var4_14 <= 322 || var4_14 >= 400 && var4_14 <= 434 || var4_14 >= 500 && var4_14 <= 522 || var4_14 >= 3200 && var4_14 <= 3212 || var4_14 >= 3500 && var4_14 <= 3512 || var4_14 >= 1300 && var4_14 <= 1312 || var4_14 >= 1400 && var4_14 <= 1412 || var4_14 >= 1500 && var4_14 <= 1512) {
                    var7_17 += Randomizer.rand(10, 12);
                } else if (var4_14 >= 1100 && var4_14 <= 1112) {
                    var7_17 += Randomizer.rand(6, 9);
                } else if (var4_14 >= 1200 && var4_14 <= 1212) {
                    var8_28 = SkillFactory.getSkill(12000000);
                    var9_35 = a.getPlayer().getSkillLevel(var8_28);
                    var7_17 += Randomizer.rand(18, 20);
                    if (var9_35 >= 1) {
                        var7_17 += var8_28.getEffect(var9_35).getY() * 2;
                    }
                } else {
                    var7_17 = var4_14 >= 2000 && var4_14 <= 2112 ? (var7_17 += Randomizer.rand(6, 9)) : (var7_17 += Randomizer.rand(50, 100));
                }
                var7_17 = (short)Math.min(30000, Math.abs(var7_17));
                a.getPlayer().setHpMpApUsed((short)(a.getPlayer().getHpMpApUsed() + 1));
                var5_15.setMaxMp(var7_17);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.MAXMP, var7_17));
                break;
            }
        }
        switch (1.ALLATORIxDEMO[a.ordinal()]) {
            case 1: {
                v7 = var5_15;
                a = v7.getStr() - 1;
                v7.setStr((short)a);
                v8 = a;
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.STR, a));
                break;
            }
            case 2: {
                v9 = var5_15;
                a = v9.getDex() - 1;
                v9.setDex((short)a);
                v8 = a;
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.DEX, a));
                break;
            }
            case 3: {
                v10 = var5_15;
                a = v10.getInt() - 1;
                v10.setInt((short)a);
                v8 = a;
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.INT, a));
                break;
            }
            case 4: {
                v11 = var5_15;
                a = v11.getLuk() - 1;
                v11.setLuk((short)a);
                v8 = a;
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.LUK, a));
                break;
            }
            case 5: {
                a = var5_15.getMaxHp();
                if (var4_14 != 0) ** GOTO lbl249
                a -= Randomizer.rand(9, 13);
                v12 = var5_15;
                ** GOTO lbl295
lbl249:
                // 1 sources

                if (var4_14 < 100 || var4_14 > 132) ** GOTO lbl256
                var7_22 = SkillFactory.getSkill(1000001);
                var8_29 = a.getPlayer().getSkillLevel(var7_22);
                a -= Randomizer.rand(21, 26);
                if (var8_29 >= 1) {
                    a -= var7_22.getEffect(var8_29).getY();
                }
                ** GOTO lbl294
lbl256:
                // 1 sources

                if ((var4_14 < 200 || var4_14 > 232) && !JobConstants.isEvan(var4_14)) ** GOTO lbl260
                a -= Randomizer.rand(18, 19);
                v12 = var5_15;
                ** GOTO lbl295
lbl260:
                // 1 sources

                if (!(var4_14 >= 300 && var4_14 <= 322 || var4_14 >= 400 && var4_14 <= 434 || var4_14 >= 1300 && var4_14 <= 1312 || var4_14 >= 1400 && var4_14 <= 1412 || var4_14 >= 3300 && var4_14 <= 3312) && (var4_14 < 3500 || var4_14 > 3512)) ** GOTO lbl264
                a -= Randomizer.rand(17, 21);
                v12 = var5_15;
                ** GOTO lbl295
lbl264:
                // 1 sources

                if (var4_14 < 500 || var4_14 > 522) ** GOTO lbl271
                var7_23 = SkillFactory.getSkill(5100000);
                var8_30 = a.getPlayer().getSkillLevel(var7_23);
                a -= Randomizer.rand(19, 23);
                if (var8_30 > 0) {
                    a -= var7_23.getEffect(var8_30).getY();
                }
                ** GOTO lbl294
lbl271:
                // 1 sources

                if (var4_14 < 1500 || var4_14 > 1512) ** GOTO lbl278
                var7_24 = SkillFactory.getSkill(15100000);
                var8_31 = a.getPlayer().getSkillLevel(var7_24);
                a -= Randomizer.rand(19, 23);
                if (var8_31 > 0) {
                    a -= var7_24.getEffect(var8_31).getY();
                }
                ** GOTO lbl294
lbl278:
                // 1 sources

                if (var4_14 < 1100 || var4_14 > 1112) ** GOTO lbl285
                var7_25 = SkillFactory.getSkill(11000000);
                var8_32 = a.getPlayer().getSkillLevel(var7_25);
                a -= Randomizer.rand(38, 43);
                if (var8_32 >= 1) {
                    a -= var7_25.getEffect(var8_32).getY();
                }
                ** GOTO lbl294
lbl285:
                // 1 sources

                if (var4_14 >= 1200 && var4_14 <= 1212) {
                    a -= Randomizer.rand(16, 22);
                    v12 = var5_15;
                } else if (var4_14 >= 2000 && var4_14 <= 2112 || var4_14 >= 3200 && var4_14 <= 3212) {
                    a -= Randomizer.rand(44, 54);
                    v12 = var5_15;
                } else {
                    a -= 20;
lbl294:
                    // 5 sources

                    v12 = var5_15;
                }
lbl295:
                // 6 sources

                if (v12.getHp() > var5_15.getMaxHp()) {
                    var5_15.setHp(a);
                }
                v8 = a;
                a.getPlayer().useHpWash();
                var5_15.setMaxHp(a);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.MAXHP, a));
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.HP, var5_15.getHp()));
                break;
            }
            case 6: {
                var7_26 = var5_15.getMaxMp();
                if (var4_14 != 0) ** GOTO lbl312
                v13 = var5_15;
                var7_26 -= 8;
                ** GOTO lbl344
lbl312:
                // 1 sources

                if (var4_14 < 100 || var4_14 > 132) ** GOTO lbl316
                v13 = var5_15;
                var7_26 -= 4;
                ** GOTO lbl344
lbl316:
                // 1 sources

                if ((var4_14 < 200 || var4_14 > 232) && !JobConstants.isEvan(var4_14)) ** GOTO lbl323
                var8_33 = SkillFactory.getSkill(2000001);
                var9_35 = a.getPlayer().getSkillLevel(var8_33);
                var7_26 -= Randomizer.rand(19, 21);
                if (var9_35 >= 1) {
                    var7_26 -= var8_33.getEffect(var9_35).getY();
                }
                ** GOTO lbl343
lbl323:
                // 1 sources

                if (!(var4_14 >= 500 && var4_14 <= 522 || var4_14 >= 300 && var4_14 <= 322 || var4_14 >= 400 && var4_14 <= 434 || var4_14 >= 1300 && var4_14 <= 1312 || var4_14 >= 1400 && var4_14 <= 1412 || var4_14 >= 1500 && var4_14 <= 1512 || var4_14 >= 3300 && var4_14 <= 3312) && (var4_14 < 3500 || var4_14 > 3512)) ** GOTO lbl327
                var7_26 -= Randomizer.rand(10, 13);
                v13 = var5_15;
                ** GOTO lbl344
lbl327:
                // 1 sources

                if (var4_14 < 1100 || var4_14 > 1112) ** GOTO lbl331
                var7_26 -= Randomizer.rand(7, 10);
                v13 = var5_15;
                ** GOTO lbl344
lbl331:
                // 1 sources

                if (var4_14 < 1200 || var4_14 > 1212) ** GOTO lbl338
                var8_34 = SkillFactory.getSkill(12000000);
                var9_35 = a.getPlayer().getSkillLevel(var8_34);
                var7_26 -= Randomizer.rand(18, 23);
                if (var9_35 >= 1) {
                    var7_26 -= var8_34.getEffect(var9_35).getY();
                }
                ** GOTO lbl343
lbl338:
                // 1 sources

                if (var4_14 >= 2000 && var4_14 <= 2112) {
                    v13 = var5_15;
                    var7_26 -= 4;
                } else {
                    var7_26 -= 20;
lbl343:
                    // 3 sources

                    v13 = var5_15;
                }
lbl344:
                // 6 sources

                if (v13.getMp() > var5_15.getMaxMp()) {
                    var5_15.setMp(var7_26);
                }
                var5_15.setMaxMp(var7_26);
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.MAXMP, var7_26));
                var3_13.add(new Pair<MapleStat, Integer>(MapleStat.MP, var5_15.getMp()));
            }
            default: {
                v8 = a;
            }
        }
        v8.sendPacket(MaplePacketCreator.updatePlayerStats(var3_13, true, a.getPlayer()));
        return var6_16;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ boolean UseUpgradeScroll(short a2, short a3, short a4, byte a5, MapleClient a6, MapleCharacter a7, int a8, boolean a9) {
        int n2;
        IEquip.ScrollResult scrollResult;
        IEquip iEquip;
        short s2;
        Object object;
        IEquip iEquip2;
        int n3;
        boolean bl;
        String string;
        IItem iItem;
        IItem iItem2;
        byte by;
        int n4;
        byte by2;
        byte by3;
        byte by4;
        boolean bl2;
        boolean bl3;
        block129: {
            block127: {
                short s3;
                int n5;
                int n6;
                block128: {
                    block125: {
                        MapleItemInformationProvider mapleItemInformationProvider;
                        block126: {
                            block124: {
                                Object object2;
                                Equip equip;
                                bl3 = false;
                                bl2 = false;
                                a5 = a5 == 1 ? (byte)1 : 0;
                                a5 = 0;
                                mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
                                if ((a4 & 2) == 2) {
                                    bl3 = true;
                                }
                                if (bl3 && (a4 = a7.getInventory(MapleInventoryType.USE).findById(2340000)) == null) {
                                    MapleClient mapleClient = a6;
                                    mapleClient.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u609e\u7f5c\u5c27\u793b\u79b9\u5311\u8eceG"));
                                    mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if (a3 < 0) {
                                    equip = a4 = (Equip)a7.getInventory(MapleInventoryType.EQUIPPED).getItem(a3);
                                } else {
                                    bl2 = true;
                                    equip = a4 = (Equip)a7.getInventory(MapleInventoryType.EQUIP).getItem(a3);
                                }
                                if (equip == null) {
                                    return false;
                                }
                                Equip equip2 = a4;
                                by4 = equip2.getLevel();
                                by3 = equip2.getEnhance();
                                by2 = equip2.getState();
                                n4 = equip2.getFlag();
                                by = equip2.getUpgradeSlots();
                                if (GameSetConstants.MAPLE_VERSION >= 147 && (iItem2 = a7.getInventory(MapleInventoryType.CASH).getItem(a2)) != null && iItem2.getItemId() == 5064200) {
                                    object2 = a7.getInventory(MapleInventoryType.USE).getItem(a2);
                                    if (object2 != null && ItemConstants.isScroll(object2.getItemId())) {
                                        a6.getPlayer().dropMessage(1, "\u4f7f\u7528" + object2.getItemName() + "\r\n\u8acb\u5c07" + iItem2.getItemName() + "\u79fb\u81f3\u7279\u6b8a\u6b04 \r\n-------------------------\r\n\u4f7f\u7528" + iItem2.getItemName() + "\r\n\u8acb\u5c07" + object2.getItemName() + "\u79fb\u81f3\u6d88\u8017\u6b04");
                                        if (bl2) {
                                            a7.getMap().broadcastMessage(a7, MaplePacketCreator.getScrollEffect(a6.getPlayer().getId(), IEquip.ScrollResult.FAIL, bl2), a8 == 0);
                                        }
                                        a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                        return false;
                                    }
                                    a9 = true;
                                }
                                if (GameSetConstants.MAPLE_VERSION >= 134 && (iItem2 = a7.getInventory(MapleInventoryType.USE).getItem(a2)) != null && iItem2.getItemId() >= 2530000 && iItem2.getItemId() <= 2530002) {
                                    object2 = a7.getInventory(MapleInventoryType.CASH).getItem(a2);
                                    if (object2 != null && ItemConstants.isScroll(object2.getItemId())) {
                                        a6.getPlayer().dropMessage(1, "\u5982\u679c\u662f\u4f7f\u7528" + object2.getItemName() + "\r\n\u8acb\u5c07" + iItem2.getItemName() + "\u79fb\u81f3\u6d88\u8017\u6b04\r\n-------------------------\r\n\u5982\u679c\u662f\u4f7f\u7528" + iItem2.getItemName() + "\r\n\u8acb\u5c07" + object2.getItemName() + "\u79fb\u81f3\u7279\u6b8a\u6b04");
                                        if (bl2) {
                                            a7.getMap().broadcastMessage(a7, MaplePacketCreator.getScrollEffect(a6.getPlayer().getId(), IEquip.ScrollResult.FAIL, bl2), a8 == 0);
                                        }
                                        a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                        return false;
                                    }
                                    a9 = false;
                                }
                                MapleCharacter mapleCharacter = a7;
                                IItem iItem3 = iItem2 = a9 ? mapleCharacter.getInventory(MapleInventoryType.CASH).getItem(a2) : mapleCharacter.getInventory(MapleInventoryType.USE).getItem(a2);
                                if (iItem2 == null) {
                                    MapleCharacter mapleCharacter2 = a7;
                                    iItem2 = a9 ? mapleCharacter2.getInventory(MapleInventoryType.USE).getItem(a2) : mapleCharacter2.getInventory(MapleInventoryType.CASH).getItem(a2);
                                    boolean bl4 = a9 = !a9;
                                }
                                if (GameConstants.isStampScroll(iItem2.getItemId())) {
                                    bl2 = false;
                                }
                                if (iItem2 == null) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if (ItemScriptManager.getInstance().start(a6, 9010000, iItem2, a4)) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return true;
                                }
                                if (GameSetConstants.isScrollupItem(iItem2.getItemId()) && (a4.getEnhance() >= 2 || GameSetConstants.isScrollupItem_Eqban(a4.getItemId()))) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if ((ItemConstants.\u985e\u578b.\u6a5f\u68b0((int)a4.getItemId()) || ItemConstants.\u985e\u578b.\u9f8d\u88dd\u5099((int)a4.getItemId())) && ItemConstants.\u985e\u578b.\u6f5b\u80fd\u5377\u8ef8((int)iItem2.getItemId())) {
                                    MapleClient mapleClient = a6;
                                    mapleClient.getPlayer().dropMessage(MapleNodes.ALLATORIxDEMO("\u6b6a\u9872\u5785\u88f1\u5097\u710d\u6cdb\u4f53\u7526\u6f77\u80f3\u535b\u8ef6\r"));
                                    mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if (ItemConstants.is\u88dd\u5099\u4fdd\u8b77\u5377\u8ef8(iItem2.getItemId())) {
                                    if (InventoryHandler.useEquipProtectScroll(a6, iItem2.getItemId(), a3, bl2)) {
                                        object2 = a9 ? MapleInventoryType.CASH : MapleInventoryType.USE;
                                        MapleInventoryManipulator.removeFromSlot(a6, (MapleInventoryType)((Object)object2), iItem2.getPosition(), (short)1, false, false);
                                    }
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return true;
                                }
                                if (!(ItemConstants.\u985e\u578b.\u6f5b\u80fd\u5377\u8ef8((int)iItem2.getItemId()) || ItemConstants.\u985e\u578b.\u9644\u52a0\u6f5b\u80fd\u5377\u8ef8((int)iItem2.getItemId()) || GameConstants.isStampScroll(iItem2.getItemId()) || ItemConstants.is\u7279\u6b8a\u5377\u8ef8(iItem2.getItemId()) || GameConstants.isCleanSlate(iItem2.getItemId()) || ItemConstants.isEquipScroll(iItem2.getItemId()) || ItemConstants.is\u6f5b\u5728\u80fd\u529b\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u56de\u771f\u5377\u8ef8(iItem2.getItemId()))) {
                                    if (a4.getUpgradeSlots() < 1) {
                                        a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                        return false;
                                    }
                                } else if (GameSetConstants.EHCHANCE_LIMIT_LEVEL && ItemConstants.isEquipScroll(iItem2.getItemId())) {
                                    if (a4.getUpgradeSlots() >= 1 || a4.getEnhance() >= 100 || a8 > 0 || mapleItemInformationProvider.isCash(a4.getItemId())) {
                                        a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                        return false;
                                    }
                                    if (a4.getEnhance() >= GameConstants.getEnchantSstarts(MapleItemInformationProvider.getInstance().getReqLevel(a4.getItemId()), MapleItemInformationProvider.getInstance().isSuperiorEquip(a4.getItemId()))) {
                                        a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                        return false;
                                    }
                                } else if (ItemConstants.is\u6f5b\u5728\u80fd\u529b\u5377\u8ef8(iItem2.getItemId())) {
                                    boolean bl5;
                                    boolean bl6 = iItem2.getItemId() / 100 == 20497 && iItem2.getItemId() < 2049750;
                                    boolean bl7 = iItem2.getItemId() / 100 == 20497 && iItem2.getItemId() >= 2049750 && iItem2.getItemId() < 2049780;
                                    boolean bl8 = bl5 = iItem2.getItemId() / 100 == 20497 && iItem2.getItemId() >= 2049780;
                                    if (!(!bl6 && !bl7 && !bl5 && a4.getState() >= 1 || bl6 && a4.getState() >= 18 || bl7 && a4.getState() >= 19 || bl5 && a4.getState() >= 20 || GameSetConstants.SERVER_NAME.equals(CashShopOperation.ALLATORIxDEMO("\u5e1e\u4e7d\u8c51")) || ItemConstants.\u985e\u578b.\u7279\u6b8a\u6f5b\u80fd\u9053\u5177((int)a4.getItemId()) || a8 > 0 || GameSetConstants.SERVER_NAME.equals(MapleNodes.ALLATORIxDEMO("\u5e54\u4e45\u8c1b")) || (a4.getUpgradeSlots() + a4.getLevel() != 0 || ItemConstants.\u985e\u578b.\u526f\u624b((int)a4.getItemId())) && !mapleItemInformationProvider.isCash(a4.getItemId()))) {
                                        a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                        return false;
                                    }
                                } else if (GameConstants.isStampScroll(iItem2.getItemId()) && (a4.getState() == 1 || a4.getPotential3() != 0 || a3 < 0)) {
                                    MapleClient mapleClient = a6;
                                    mapleClient.sendPacket(MaplePacketCreator.getInventoryFull());
                                    mapleClient.getPlayer().marriage();
                                    return false;
                                }
                                if (!GameConstants.canScroll(a4.getItemId()) && !ItemConstants.isChaosScroll(iItem2.getItemId())) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if ((ItemConstants.is\u767d\u8863\u5377\u8ef8(iItem2.getItemId()) || GameConstants.isTablet(iItem2.getItemId()) || ItemConstants.isChaosScroll(iItem2.getItemId())) && (a8 > 0 || mapleItemInformationProvider.isCash(a4.getItemId()))) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if (ItemConstants.is\u63d0\u5347\u5377(iItem2.getItemId()) && a4.getDurability() < 0) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if (!(ItemConstants.is\u63d0\u5347\u5377(iItem2.getItemId()) || ItemConstants.is\u6f5b\u5728\u80fd\u529b\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u88dd\u5099\u5f37\u5316\u5377\u8ef8(iItem2.getItemId()) || a4.getDurability() < 0 || ItemConstants.\u8010\u4e45\u5ea6\u53ef\u4f7f\u7528\u5377\u8ef8(iItem2.getItemId()))) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                iItem = null;
                                List<Integer> list = mapleItemInformationProvider.getScrollReqs(iItem2.getItemId());
                                if (iItem2.getItemId() != 2041200 && list.size() > 0 && !list.contains(a4.getItemId())) {
                                    a6.sendPacket(MaplePacketCreator.getInventoryFull());
                                    return false;
                                }
                                if (bl3 && (iItem = a7.getInventory(MapleInventoryType.USE).findById(2340000)) == null) {
                                    bl3 = false;
                                }
                                if (iItem2.getItemId() == 2049115 && a4.getItemId() != 1003068) {
                                    return false;
                                }
                                if (!ItemConstants.is\u5fc3\u81df(a4.getItemId()) && (GameConstants.isTablet(iItem2.getItemId()) || GameConstants.isGeneralScroll(iItem2.getItemId()))) {
                                    switch (iItem2.getItemId() % 1000 / 100) {
                                        case 0: {
                                            if (!ItemConstants.\u985e\u578b.\u96d9\u624b\u6b66\u5668((int)a4.getItemId()) && (ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4.getItemId()) || ItemConstants.\u985e\u578b.\u96d9\u5200((int)a4.getItemId()))) break;
                                            return false;
                                        }
                                        case 1: {
                                            if (ItemConstants.\u985e\u578b.\u96d9\u624b\u6b66\u5668((int)a4.getItemId()) && ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4.getItemId())) break;
                                            return false;
                                        }
                                        case 2: {
                                            if (!ItemConstants.\u985e\u578b.\u98fe\u54c1((int)a4.getItemId()) && !ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4.getItemId()) && !ItemConstants.\u985e\u578b.\u96d9\u5200((int)a4.getItemId())) break;
                                            return false;
                                        }
                                        case 3: {
                                            if (ItemConstants.\u985e\u578b.\u98fe\u54c1((int)a4.getItemId()) && !ItemConstants.\u985e\u578b.\u6b66\u5668((int)a4.getItemId()) && !ItemConstants.\u985e\u578b.\u96d9\u5200((int)a4.getItemId())) break;
                                            return false;
                                        }
                                    }
                                } else if (iItem2.getItemId() == 2048806 || iItem2.getItemId() == 2048807) {
                                    if (!ItemConstants.\u985e\u578b.\u5bf5\u7269\u88dd\u5099((int)a4.getItemId())) {
                                        MapleClient mapleClient = a6;
                                        mapleClient.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u53dc\u809b\u7d50\u5b93\u725f\u88bb\u50af\u4f19\u751e\u3064"));
                                        mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (iItem2.getItemId() == 2049115) {
                                    if (a4.getItemId() != 1003068) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (iItem2.getItemId() == 2049304 || iItem2.getItemId() == 2049305 || iItem2.getItemId() == 2049308 || iItem2.getItemId() == 2049309 || iItem2.getItemId() == 2049311 || iItem2.getItemId() == 2049312) {
                                    if (a4.getEnhance() >= 1) {
                                        MapleClient mapleClient = a6;
                                        mapleClient.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u8a7c\u88f1\u5097\u5dde\u7d9d\u6725\u6611\u52b7\u712f\u6cf9\u5183\u4f53\u7526\u302e"));
                                        mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (iItem2.getItemId() == 2041200) {
                                    if (a4.getItemId() != 1122000 && a4.getItemId() != 0x111F1C) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (ItemConstants.is\u98fe\u54c1\u5377\u8ef8(iItem2.getItemId())) {
                                    if (!ItemConstants.\u985e\u578b.\u98fe\u54c1((int)a4.getItemId()) && !ItemConstants.is\u5fc3\u81df(a4.getItemId())) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (ItemConstants.is\u55ae\u624b\u6b66\u5668\u5377\u8ef8(iItem2.getItemId())) {
                                    if (!ItemConstants.\u985e\u578b.\u55ae\u624b\u6b66\u5668((int)a4.getItemId()) && !ItemConstants.is\u5fc3\u81df(a4.getItemId())) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (ItemConstants.is\u96d9\u624b\u6b66\u5668\u5377\u8ef8(iItem2.getItemId())) {
                                    if (!ItemConstants.\u985e\u578b.\u96d9\u624b\u6b66\u5668((int)a4.getItemId()) && !ItemConstants.is\u5fc3\u81df(a4.getItemId())) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (ItemConstants.is\u9632\u5177\u5377\u8ef8(iItem2.getItemId())) {
                                    if (!(ItemConstants.\u985e\u578b.\u9632\u5177((int)a4.getItemId()) || ItemConstants.is\u5fc3\u81df(a4.getItemId()) || ItemConstants.\u985e\u578b.\u53ef\u7528\u5377\u8ef8\u7684\u526f\u624b((int)a4.getItemId()))) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else if (!(ItemConstants.is\u9644\u52a0\u6f5b\u80fd\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u5f8c\u671f\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u5f8c\u671f\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u5e78\u904b\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u7279\u6b8a\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u6df7\u6c8c\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u767d\u8863\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u88dd\u5099\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u6f5b\u5728\u80fd\u529b\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u56de\u771f\u5377\u8ef8(iItem2.getItemId()) || ItemConstants.is\u70d9\u5370\u5370\u7ae0(iItem2.getItemId()))) {
                                    if (!mapleItemInformationProvider.canScroll(iItem2.getItemId(), a4.getItemId())) {
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                } else {
                                    if (ItemConstants.is\u767d\u8863\u5377\u8ef8(iItem2.getItemId()) && a4.getEnhance() > 0) {
                                        a6.getPlayer().dropMessage(1, "\u8a72\u88dd\u5099\u5df2\u7d93\u6709\u661f\u529b\u7121\u6cd5\u4f7f\u7528" + iItem2.getItemName());
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                    if (ItemConstants.is\u5377\u8ef8\u4fdd\u8b77\u5361(iItem2.getItemId()) && a4.getUpgradeSlots() <= 0) {
                                        a6.getPlayer().dropMessage(1, "\u8a72\u88dd\u5099\u5df2\u7d93\u6c92\u6709\u88dd\u5099\u5377\u6578\u7121\u6cd5\u4f7f\u7528" + iItem2.getItemName());
                                        a6.sendPacket(MaplePacketCreator.enableActions());
                                        return false;
                                    }
                                }
                                if (GameConstants.isAccessoryScroll(iItem2.getItemId()) && !GameConstants.isAccessory(a4.getItemId())) {
                                    a6.sendPacket(MaplePacketCreator.enableActions());
                                    return false;
                                }
                                if (iItem2.getQuantity() <= 0) {
                                    a6.sendPacket(MaplePacketCreator.enableActions());
                                    return false;
                                }
                                if (bl2 && a8 == 0 && !ItemConstants.\u985e\u578b.\u9f8d\u88dd\u5099((int)a4.getItemId()) && a7.getSkillLevel(SkillFactory.getSkill(1003)) <= 0 && a7.getSkillLevel(SkillFactory.getSkill(10001003)) <= 0 && a7.getSkillLevel(SkillFactory.getSkill(20001003)) <= 0 && a7.getSkillLevel(SkillFactory.getSkill(20011003)) <= 0 && a7.getSkillLevel(SkillFactory.getSkill(30001003)) <= 0) {
                                    AutobanManager.getInstance().addPoints(a6, 50, 120000L, CashShopOperation.ALLATORIxDEMO("3E\u000fX\u0001\u0016\u0012^\u0003\u00165]\u000fZ\n\u0016Az\u0003Q\u0003X\u0002W\u0014OFe\u0016_\u0014_\u0012\u0011FA\u000fB\u000eY\u0013BF^\u0007@\u000fX\u0001\u0016\u000fBH"));
                                    return false;
                                }
                                string = "";
                                bl = false;
                                n3 = 0;
                                n3 = 0;
                                iEquip2 = null;
                                if (!ItemConstants.is\u56de\u771f\u5377\u8ef8(iItem2.getItemId())) break block124;
                                HashMap<IItem, Boolean> hashMap = mapleItemInformationProvider.scrollResetEquip(a4, iItem2, a7);
                                if (hashMap != null) {
                                    if (hashMap.keySet().size() > 0) {
                                        iEquip2 = (Equip)hashMap.keySet().toArray()[0];
                                    }
                                    if (hashMap.values().size() > 0) {
                                        bl = (Boolean)hashMap.values().toArray()[0];
                                    }
                                }
                                break block125;
                            }
                            if (!GameConstants.isStampScroll(iItem2.getItemId())) break block126;
                            if (Randomizer.nextInt(100) >= GameConstants.getStampRate(iItem2.getItemId())) break block127;
                            if (a4.getState() < 17) {
                                MapleClient mapleClient = a6;
                                mapleClient.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u710d\u6cdb\u4f53\u7526\u302e"));
                                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                return false;
                            }
                            if (a4.getPotential3() != 0) {
                                MapleClient mapleClient = a6;
                                mapleClient.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u4e6f\u63a4\u6f3d\u80cb\u7147\u6ce3\u4f19\u751e\u3064"));
                                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                                return false;
                            }
                            n6 = mapleItemInformationProvider.getReqLevel(a4.getItemId()) / 10;
                            object = new LinkedList<Map<Integer, StructPotentialItem>>(mapleItemInformationProvider.getAllPotentialInfo().values());
                            n5 = a4.getState();
                            if (n5 > 20) {
                                n5 = 20;
                            } else if (n5 < 17) {
                                n5 = 17;
                            }
                            s3 = s2 = 0;
                            break block128;
                        }
                        iEquip2 = (IEquip)mapleItemInformationProvider.scrollEquipWithId(a4, iItem2, bl3, a7, a8);
                    }
                    iEquip = iEquip2;
                    break block129;
                }
                while (s3 == 0) {
                    Object object3 = object;
                    StructPotentialItem structPotentialItem = (StructPotentialItem)((Map)object3.get(Randomizer.nextInt(object3.size()))).get(n6);
                    if (structPotentialItem == null) {
                        s3 = s2;
                        continue;
                    }
                    if (structPotentialItem.reqLevel / 10 > n6) {
                        s3 = s2;
                        continue;
                    }
                    StructPotentialItem structPotentialItem2 = structPotentialItem;
                    if (!GameConstants.optionTypeFits(structPotentialItem2.opID, structPotentialItem2.optionType, a4.getItemId())) {
                        s3 = s2;
                        continue;
                    }
                    if (!GameConstants.potentialIDFits(structPotentialItem.opID, n5, 0)) {
                        s3 = s2;
                        continue;
                    }
                    a4.setPotential3(structPotentialItem.opID);
                    s3 = s2 = 1;
                }
                a5 = 1;
                MapleCharacter mapleCharacter = a7;
                mapleCharacter.forceReAddItem(a4, MapleInventoryType.EQUIP);
                mapleCharacter.equipChanged();
            }
            MapleInventoryManipulator.removeFromSlot(a6, MapleInventoryType.USE, iItem2.getPosition(), (short)1, false, false);
            a7.getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(a5 != 0, a7.getId(), iItem2.getItemId()));
            a6.sendPacket(MaplePacketCreator.enableActions());
            iEquip = iEquip2;
        }
        if (iEquip == null) {
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                if (ItemFlag.SHIELD_WARD.check(n4)) {
                    iEquip2 = a4;
                    scrollResult = IEquip.ScrollResult.FAIL;
                    iEquip2.setFlag(n4 - ItemFlag.SHIELD_WARD.getValue());
                } else {
                    scrollResult = IEquip.ScrollResult.CURSE;
                }
                string = MapleNodes.ALLATORIxDEMO("\u783a\u58f2");
            } else {
                scrollResult = IEquip.ScrollResult.CURSE;
                string = CashShopOperation.ALLATORIxDEMO("\u7802\u58b8");
            }
        } else if (ItemConstants.is\u56de\u771f\u5377\u8ef8(iItem2.getItemId())) {
            iEquip2 = a4;
            if (ItemFlag.SHIELD_WARD.check(n4)) {
                iEquip2 = a4;
                iEquip2.removeFlag(ItemFlag.SHIELD_WARD.getValue());
            }
            if (bl) {
                scrollResult = IEquip.ScrollResult.SUCCESS;
                string = MapleNodes.ALLATORIxDEMO("\u621e\u52b3");
            } else {
                scrollResult = IEquip.ScrollResult.FAIL;
                string = CashShopOperation.ALLATORIxDEMO("\u5907\u6531");
            }
        } else if (iEquip2.getLevel() > by4 || iEquip2.getEnhance() > by3 || iEquip2.getState() > by2 || iEquip2.getFlag() > n4) {
            scrollResult = IEquip.ScrollResult.SUCCESS;
            string = MapleNodes.ALLATORIxDEMO("\u621e\u52b3");
            if (a8 > 0) {
                n3 = 60;
            }
        } else if (GameConstants.isCleanSlate(iItem2.getItemId()) && iEquip2.getUpgradeSlots() > by) {
            scrollResult = IEquip.ScrollResult.SUCCESS;
            string = CashShopOperation.ALLATORIxDEMO("\u6226\u52f9");
        } else {
            scrollResult = IEquip.ScrollResult.FAIL;
            string = MapleNodes.ALLATORIxDEMO("\u593f\u657b");
            if (a8 > 0) {
                n3 = 65;
            }
        }
        try {
            object = "\u5377\u8ef8: " + MapleItemInformationProvider.getInstance().getName(iItem2.getItemId()) + "(" + iItem2.getItemId() + ") \u88dd\u5099:" + MapleItemInformationProvider.getInstance().getName(a4.getItemId()) + "(" + a4.getItemId() + ")[\u529b:" + a4.getStr() + "/\u654f:" + a4.getDex() + "/\u5e78:" + a4.getLuk() + "/\u667a:" + a4.getInt() + "/\u7269\u653b:" + a4.getWatk() + "/\u9b54\u529f:" + a4.getMatk() + "/\u7269\u9632:" + a4.getWdef() + "/\u9b54\u9632:" + a4.getMdef() + "] \u795d\u798f\u5377: " + bl3 + " \u7d50\u679c: " + string;
            if (ServerConfig.LOG_SCROLL) {
                FileoutputUtil.logToFile("logs/\u73a9\u5bb6\u64cd\u4f5c/" + a6.getPlayer().getName() + "/\u4f7f\u7528\u5377\u8ef8.txt", "\r\n " + FileoutputUtil.NowTime() + " IP: " + a6.getSession().remoteAddress().toString().split(CashShopOperation.ALLATORIxDEMO("\\"))[0] + " \u73a9\u5bb6[" + a6.getPlayer().getName() + "] " + (String)object);
            }
            if (a6.getPlayer().getDebugMessage()) {
                a6.getPlayer().dropMessage(-3, (String)object);
            }
        }
        catch (Exception exception) {
            FilePrinter.printError(MapleNodes.ALLATORIxDEMO("GBxI`Xa^wdoBj@k^ XvX"), exception, CashShopOperation.ALLATORIxDEMO("C\u0015S3F\u0001D\u0007R\u0003e\u0005D\tZ\n\u0016\u000eW\u0015\u0016#N\u0005S\u0016B\u000fY\b"));
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (ItemFlag.SHIELD_WARD.check(n4) && !GameConstants.isCleanSlate(iItem2.getItemId()) && !ItemConstants.is\u7279\u6b8a\u5377\u8ef8(iItem2.getItemId())) {
                iEquip2 = a4;
                iEquip2.setFlag(n4 - ItemFlag.SHIELD_WARD.getValue());
            }
            if (ItemFlag.SHIELD_WARD.check(n4) && iEquip2 != null) {
                iEquip2 = a4;
                iEquip2.setFlag(n4 - ItemFlag.SHIELD_WARD.getValue());
            }
        }
        object = a9 ? MapleInventoryType.CASH : MapleInventoryType.USE;
        MapleInventoryManipulator.removeFromSlot(a6, object, iItem2.getPosition(), (short)1, false, false);
        if (bl3 && iItem != null) {
            MapleInventoryManipulator.removeFromSlot(a6, MapleInventoryType.USE, iItem.getPosition(), (short)1, false, false);
        } else if (scrollResult == IEquip.ScrollResult.FAIL && iEquip2.getUpgradeSlots() < by && a6.getPlayer().getInventory(MapleInventoryType.CASH).findById(5640000) != null) {
            a7.setScrolledPosition(iEquip2.getPosition());
            if (a8 == 0) {
                a6.sendPacket(MaplePacketCreator.pamSongUI());
            }
        }
        ArrayList<ModifyInventory> arrayList = new ArrayList<ModifyInventory>();
        if (scrollResult == IEquip.ScrollResult.CURSE) {
            arrayList.add(new ModifyInventory(3, a4));
            MapleClient mapleClient = a6;
            if (a3 < 0) {
                mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIPPED).removeItem(a6.getPlayer(), a4.getPosition());
                n2 = a8;
            } else {
                mapleClient.getPlayer().getInventory(MapleInventoryType.EQUIP).removeItem(a6.getPlayer(), a4.getPosition());
                n2 = a8;
            }
        } else {
            arrayList.add(new ModifyInventory(3, iEquip2));
            arrayList.add(new ModifyInventory(0, iEquip2));
            n2 = a8;
        }
        if (n2 > 0) {
            s2 = VegaScrollType.SUCCESS.getValue();
            short s4 = VegaScrollType.FAILED.getValue();
            a5 = (byte)VegaScrollType.END.getValue();
            a6.sendPacket(MTSCSPacket.VegaResult(scrollResult == IEquip.ScrollResult.SUCCESS ? s2 : s4));
            MapleClient mapleClient = a6;
            mapleClient.sendPacket(MTSCSPacket.VegaResult(a5));
            mapleClient.getPlayer().forceReAddItem_Flag(a4, MapleInventoryType.EQUIP);
        }
        a6.sendPacket(MaplePacketCreator.modifyInventory(true, arrayList));
        a7.getMap().broadcastMessage(a7, MaplePacketCreator.getScrollEffect(a6.getPlayer().getId(), scrollResult, bl2), a8 == 0);
        if (a3 < 0 && (scrollResult == IEquip.ScrollResult.SUCCESS || scrollResult == IEquip.ScrollResult.CURSE) && a8 == 0) {
            a7.equipChanged();
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void UseMagicWheel(LittleEndianAccessor a, MapleClient a, MapleCharacter a) {
        if (!a.isAlive() || a.hasBlockedInventory() || a.isInBlockedMap() || a.inPVP()) {
            a.sendPacket(MaplePacketCreator.MagicWheelAction(8));
            return;
        }
        var3_3 = a.readByte();
        if (var3_3 == 0 && World.hasWheelCache(a.getId())) {
            World.removeFromWheelCache(a.getId());
            return;
        }
        if (var3_3 == 2) {
            v0 = a;
            v0.skip(4);
            var4_4 = (short)v0.readInt();
            var5_6 = v0.readInt();
            var6_8 = a.getInventory(GameConstants.getInventoryType(var5_6)).getItem(var4_4);
            if (var6_8 == null || var6_8.getQuantity() < 1 || var6_8.getItemId() != var5_6 || var5_6 != 4400000) {
                a.sendPacket(MaplePacketCreator.MagicWheelAction(6));
                return;
            }
            if (a.getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() < 2 || a.getInventory(MapleInventoryType.USE).getNumFreeSlot() < 2 || a.getInventory(MapleInventoryType.SETUP).getNumFreeSlot() < 2 || a.getInventory(MapleInventoryType.ETC).getNumFreeSlot() < 2 || a.getInventory(MapleInventoryType.CASH).getNumFreeSlot() < 2) {
                a.sendPacket(MaplePacketCreator.MagicWheelAction(7));
                return;
            }
            if (World.hasWheelCache(a.getId())) {
                a.sendPacket(MaplePacketCreator.MagicWheelAction(8));
                return;
            }
        } else {
            if (var3_3 != 4) {
                if (var3_3 == 0) return;
                a.sendPacket(MaplePacketCreator.MagicWheelAction(8));
                return;
            }
            var4_5 = a.readMapleAsciiString();
            if (var4_5.equals(String.valueOf(a.getId())) && World.hasWheelCache(a.getId())) {
                var5_7 = World.removeFromWheelCache(a.getId());
                if (var5_7 <= 0) return;
                var6_9 = MapleInventoryManipulator.addbyId_Gachapon(a, var5_7, (short)1);
                if (var6_9 != null) return;
                a.sendPacket(MaplePacketCreator.MagicWheelAction(10));
                return;
            }
            a.sendPacket(MaplePacketCreator.MagicWheelAction(8));
            return;
        }
        MapleInventoryManipulator.removeFromSlot(a, GameConstants.getInventoryType(var5_6), var4_4, (short)1, false);
        var7_10 = new ArrayList<Integer>();
        var8_11 = 0;
        var9_12 = 0;
        block0: while (true) lbl-1000:
        // 4 sources

        {
            v1 = var8_11;
            while (true) {
                block13: {
                    block12: {
                        if (v1 >= 10) {
                            Collections.shuffle(var7_10);
                            var8_11 = Randomizer.nextInt(10);
                            World.addToWheelCache(a.getId(), (Integer)var7_10.get(var8_11));
                            a.sendPacket(MaplePacketCreator.MagicWheelAction(3, String.valueOf(a.getId()), var7_10, var8_11));
                            return;
                        }
                        if (var8_11 >= 6) break block12;
                        var9_12 = GameConstants.normalMagicWheel[Randomizer.nextInt(GameConstants.normalMagicWheel.length)];
                        if (var7_10.contains(var9_12)) ** GOTO lbl-1000
                        var7_10.add(var9_12);
                        v1 = ++var8_11;
                        continue;
                    }
                    if (var8_11 >= 9) break block13;
                    var9_12 = GameConstants.rareMagicWheel[Randomizer.nextInt(GameConstants.rareMagicWheel.length)];
                    if (var7_10.contains(var9_12)) ** GOTO lbl-1000
                    var7_10.add(var9_12);
                    v1 = ++var8_11;
                    continue;
                }
                var9_12 = GameConstants.superMagicWheel[Randomizer.nextInt(GameConstants.superMagicWheel.length)];
                if (var7_10.contains(var9_12)) continue block0;
                var7_10.add(var9_12);
                v1 = ++var8_11;
            }
            break;
        }
    }

    public static /* synthetic */ void useScrollGashaponBox(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (a3 == null || a4 == null || a4.hasBlockedInventory() || a4.inPVP()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a2.available() < 8L) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a4.updateTick(a2.readInt());
        int n2 = a2.readInt();
        a3.getPlayer().addQuestPoint(99997, -1L);
        int n3 = (int)a3.getPlayer().getQuestPoint(99997);
        InventoryHandler.useScrollGashaponBox(true, n2, n3, a3, a4);
    }

    public static /* synthetic */ void handleSpReset(LittleEndianAccessor a2, MapleClient a3) {
        if (a2.available() < 10L) {
            return;
        }
        a2.readInt();
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        Object object = GameConstants.getInventoryType(n2);
        if (n2 / 1000 != 2500) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        object = a3.getPlayer().getInventory((MapleInventoryType)((Object)object)).getItem(s2);
        if (object == null || object.getQuantity() <= 0 || object.getItemId() != n2 || a3.getPlayer().hasBlockedInventory()) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleClient mapleClient = a3;
        InventoryHandler.handleSpReset(s2, n2, mapleClient, mapleClient.getPlayer());
    }

    public static final /* synthetic */ void OwlWarp(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().getMapId() >= 910000000 && a3.getPlayer().getMapId() <= 910000022 && a3.getPlayer().getPlayerShop() == null) {
            int n2;
            int n3 = a2.readInt();
            if (GameSetConstants.MAPLE_VERSION >= 147) {
                a2.readByte();
            }
            if ((n2 = a2.readInt()) >= 910000001 && n2 <= 910000022) {
                MapleMap mapleMap = a3.getChannelServer().getMapFactory().getMap(n2);
                if (!GameSetConstants.SERVER_NAME.equals(CashShopOperation.ALLATORIxDEMO("\u5e1e\u4e7d\u8c51"))) {
                    MapleMap mapleMap2 = mapleMap;
                    a3.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(0));
                }
                AbstractPlayerStore abstractPlayerStore = null;
                block0 : switch (2) {
                    case 0: {
                        while (false) {
                        }
                        List<MapleMapObject> list = mapleMap.getAllHiredMerchantsThreadsafe();
                        for (MapleMapObject mapleMapObject : list) {
                            HiredMerchant hiredMerchant;
                            IMaplePlayerShop iMaplePlayerShop;
                            if (!(mapleMapObject instanceof IMaplePlayerShop) || !((iMaplePlayerShop = (IMaplePlayerShop)((Object)mapleMapObject)) instanceof HiredMerchant) || (hiredMerchant = (HiredMerchant)iMaplePlayerShop).getOwnerId() != n3) continue;
                            abstractPlayerStore = hiredMerchant;
                            break block0;
                        }
                        break;
                    }
                    case 1: {
                        List<MapleMapObject> list = mapleMap.getAllHiredMerchantsThreadsafe();
                        for (MapleMapObject mapleMapObject : list) {
                            HiredMerchant hiredMerchant;
                            IMaplePlayerShop iMaplePlayerShop;
                            if (!(mapleMapObject instanceof IMaplePlayerShop) || !((iMaplePlayerShop = (IMaplePlayerShop)((Object)mapleMapObject)) instanceof HiredMerchant) || (hiredMerchant = (HiredMerchant)iMaplePlayerShop).getStoreId() != n3) continue;
                            abstractPlayerStore = hiredMerchant;
                            break block0;
                        }
                        break;
                    }
                    default: {
                        IMaplePlayerShop iMaplePlayerShop;
                        MapleMapObject mapleMapObject = mapleMap.getMapObject(n3, MapleMapObjectType.HIRED_MERCHANT);
                        if (!(mapleMapObject instanceof IMaplePlayerShop) || !((iMaplePlayerShop = (IMaplePlayerShop)((Object)mapleMapObject)) instanceof HiredMerchant)) break;
                        abstractPlayerStore = (HiredMerchant)iMaplePlayerShop;
                    }
                }
                if (abstractPlayerStore != null) {
                    AbstractPlayerStore abstractPlayerStore2 = abstractPlayerStore;
                    if (abstractPlayerStore.isOwner(a3.getPlayer())) {
                        abstractPlayerStore2.setOpen(false);
                        abstractPlayerStore.removeAllVisitors((byte)MaplePacketOperation.MerchantStatus.\u5546\u5e97\u6574\u7406\u7269\u54c1, 1);
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().setPlayerShop(abstractPlayerStore);
                        mapleClient.sendPacket(PlayerShopPacket.getHiredMerch(a3.getPlayer(), (HiredMerchant)abstractPlayerStore, false));
                        return;
                    }
                    if (!abstractPlayerStore2.isOpen() || !abstractPlayerStore.isAvailable()) {
                        a3.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u9035\u5005\u556a\u5e99\u5704\u657a\u742a\u6218\u8029\u6621\u6cbe\u5726\u8c85\u8ced\u675d\u8971\u302e"));
                        return;
                    }
                    if (abstractPlayerStore.getFreeSlot() == -1) {
                        a3.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u5570\u5ef1\u4e8c\u651e\u5dc4\u7df5\u6ec9\u4ee0\uff3a\u8aad\u7a3b\u5fea\u51bb\u9054\u5153\u3064"));
                        return;
                    }
                    MapleClient mapleClient = a3;
                    if (((HiredMerchant)abstractPlayerStore).isInBlackList(a3.getPlayer().getName())) {
                        mapleClient.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u8887\u52ae\u5149\u9edf\u5421\u55a0\u4eaa\uff02\u626c\u4eeb\u4e21\u80f3\u901e\u516b\u302e"));
                        return;
                    }
                    mapleClient.getPlayer().setPlayerShop(abstractPlayerStore);
                    MapleClient mapleClient2 = a3;
                    abstractPlayerStore.addVisitor(mapleClient2.getPlayer());
                    mapleClient2.sendPacket(PlayerShopPacket.getHiredMerch(mapleClient2.getPlayer(), (HiredMerchant)abstractPlayerStore, false));
                    return;
                }
                a3.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u5570\u5ef1\u6b55\u574e\u6542\u7460\u4e1b\uff6a"));
            }
        }
    }

    public static /* synthetic */ boolean useCube(MapleClient a2, int a32, int a4) {
        boolean bl = false;
        byte n2 = 0;
        IItem a32 = a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((short)a32);
        if (a32 != null) {
            if (MapleItemInformationProvider.getInstance().isCash(a32.getItemId())) {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u9ed0\u88f1\u712f\u6cf9\u6d19\u6f77\u80f3\r"));
                mapleClient.sendPacket(MaplePacketCreator.enableActions());
                return false;
            }
        } else {
            a2.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        Equip equip = (Equip)a32;
        if (equip.getState() >= 20 && a4 != 5062002 && a4 != 5062005 && a4 != 5062500) {
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u50d5\u8a9c\u7b2f\u7d2c\u88bb\u50af\u538c\u80cb\u754e\u5085\u8acc\u658f\u582c\u54d0G"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        if (a4 == 5062000) {
            if (a32 != null && a2.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
                byte by = 5;
                byte by2 = 8;
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    by = 17;
                    by2 = 20;
                }
                if (equip.getState() >= by && by != by2) {
                    MapleClient mapleClient;
                    if (GameSetConstants.MAPLE_VERSION >= 138) {
                        if (MapleItemInformationProvider.getInstance().itemExists(0x4D4D11) && equip.getState() >= 18 && equip.getState() < 19 && a2.getPlayer().haveItem(0x4D4D11, 1)) {
                            MapleClient mapleClient2 = a2;
                            mapleClient = mapleClient2;
                            mapleClient2.getPlayer().gainItem(0x4D4D11, -1);
                            equip.renewPotential(0, 0x4D4D11, a4, a2.getPlayer());
                        } else {
                            equip.renewPotential(0, 0, a4, a2.getPlayer());
                            mapleClient = a2;
                        }
                    } else {
                        equip.renewPotential();
                        mapleClient = a2;
                    }
                    mapleClient.getPlayer().forceReAddItem_Equip(a32, MapleInventoryType.EQUIP);
                    MapleInventoryManipulator.addById(a2, ItemConstants.getCubeFragment(a4), (short)1);
                    a2.getPlayer().addUseCube(1);
                    n2 = 1;
                } else {
                    bl = true;
                    a2.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u7896\u5b94\u88f1\u5097\u6603\u5428\u6725\u4e04\u6f77\u80f3\u0002"));
                }
            } else {
                bl = true;
                a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u78dc\u8abb\u80aa\u5333\u6649\u5410\u676f\u7a4c\u95f5\u6508\u78e8\u7271H"));
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(bl, a2.getPlayer().getId(), a4));
            return n2 != 0;
        }
        if (a4 == 5062001 || a4 == 0x4D3DD4) {
            if (a2.getPlayer().getLevel() < 10) {
                a2.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u4f4c\u768a\u7b65\u7d14\u4e21\u8dbd\u001d>\u7b65\uff02\u710d\u6cdb\u4f53\u7526\u302e"));
                return n2 != 0;
            }
            if (a32 != null && a2.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
                if (MapleAntiMacro.isAntiNow(a2.getPlayer().getName())) {
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u7117\u6cb3\u51bb\u63c3\u53e1\u6e4a\u8b3c\u6a39\u6e1a\u8a00\u6674\u4f19\u751e\u3064"));
                    mapleClient.sendPacket(MaplePacketCreator.enableActions());
                    return n2 != 0;
                }
                byte by = 5;
                byte by3 = 8;
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    by = 17;
                    by3 = 20;
                }
                if (equip.getState() >= by && equip.getState() != by3) {
                    MapleClient mapleClient;
                    int n3;
                    if (GameSetConstants.MAPLE_VERSION >= 138) {
                        if (MapleItemInformationProvider.getInstance().itemExists(0x4D4D11) && equip.getState() >= 18 && equip.getState() < 19 && a2.getPlayer().haveItem(0x4D4D11, 1)) {
                            n3 = a4;
                            a2.getPlayer().gainItem(0x4D4D11, -1);
                            equip.renewPotential(1, 0x4D4D11, a4, a2.getPlayer());
                        } else {
                            equip.renewPotential(1, 0, a4, a2.getPlayer());
                            n3 = a4;
                        }
                    } else {
                        Equip equip2 = equip;
                        equip2.renewPotential1(equip2.getPotential3() <= 0);
                        n3 = a4;
                    }
                    if (n3 == 0x4D3DD4) {
                        Equip equip3;
                        Object object;
                        Equip equip4;
                        Object object2;
                        String string = MapleNodes.ALLATORIxDEMO("bCi_!HoXo\u0003\u695d\u8465\u5949\u5e57\u65b7\u5866 XvX");
                        String string2 = FileoutputUtil.NowTime();
                        String string3 = a2.getPlayer().getClient().getSession().remoteAddress().toString().split(CashShopOperation.ALLATORIxDEMO("\\"))[0];
                        String string4 = a2.getPlayer().getName();
                        int n4 = a2.getPlayer().getMap().getId();
                        String string5 = a2.getPlayer().getMap().getMapName();
                        int n5 = equip.getItemId();
                        String string6 = equip.getItemName();
                        long l2 = equip.getEquipOnlyId();
                        if (equip.getPotential1() > 0) {
                            object2 = equip.getPotential1();
                            equip4 = equip;
                        } else {
                            object2 = MapleNodes.ALLATORIxDEMO("\u710d");
                            equip4 = equip;
                        }
                        if (equip4.getPotential2() > 0) {
                            object = equip.getPotential2();
                            equip3 = equip;
                        } else {
                            object = CashShopOperation.ALLATORIxDEMO("\u7147");
                            equip3 = equip;
                        }
                        FileoutputUtil.logToFile(string, " " + string2 + " IP: " + string3 + " \u89d2\u8272\u540d\u5b57: " + string4 + " \u5728\u5730\u5716\u300c" + n4 + "-" + string5 + "\u300d \u4f7f\u7528\u4e86\u5947\u5e7b\u65b9\u584a\u5728\u88dd\u5099:" + n5 + "(" + string6 + ") \u88dd\u5099\u552f\u4e00ID:" + l2 + "\u5df2\u7d93\u91cd\u65b0\u8a2d\u5b9a\u4e86\u6f5b\u80fd\u3000\u4e4b\u524d\u7684\u6dfa\u80fd1:" + (Serializable)object2 + " \u4e4b\u524d\u7684\u6dfa\u80fd2:" + (Serializable)object + " \u4e4b\u524d\u7684\u6dfa\u80fd3:" + (Serializable)(equip3.getPotential3() > 0 ? Integer.valueOf(equip.getPotential3()) : MapleNodes.ALLATORIxDEMO("\u710d")) + "\r\n");
                        mapleClient = a2;
                    } else {
                        Equip equip5;
                        Object object;
                        Equip equip6;
                        Object object3;
                        String string = CashShopOperation.ALLATORIxDEMO("Z\tQ\u0015\u0019\u0002W\u0012WI\u8db3\u7d7c\u5971\u5e1d\u658f\u582c\u0018\u0012N\u0012");
                        String string7 = FileoutputUtil.NowTime();
                        String string8 = a2.getPlayer().getClient().getSession().remoteAddress().toString().split(MapleNodes.ALLATORIxDEMO("\u0016"))[0];
                        String string9 = a2.getPlayer().getName();
                        int n6 = a2.getPlayer().getMap().getId();
                        String string10 = a2.getPlayer().getMap().getMapName();
                        int n7 = equip.getItemId();
                        String string11 = equip.getItemName();
                        long l3 = equip.getEquipOnlyId();
                        if (equip.getPotential1() > 0) {
                            object3 = equip.getPotential1();
                            equip6 = equip;
                        } else {
                            object3 = CashShopOperation.ALLATORIxDEMO("\u7147");
                            equip6 = equip;
                        }
                        if (equip6.getPotential2() > 0) {
                            object = equip.getPotential2();
                            equip5 = equip;
                        } else {
                            object = MapleNodes.ALLATORIxDEMO("\u710d");
                            equip5 = equip;
                        }
                        FileoutputUtil.logToFile(string, " " + string7 + " IP: " + string8 + " \u89d2\u8272\u540d\u5b57: " + string9 + " \u5728\u5730\u5716\u300c" + n6 + "-" + string10 + "\u300d \u4f7f\u7528\u4e86\u5947\u5e7b\u65b9\u584a\u5728\u88dd\u5099:" + n7 + "(" + string11 + ") \u88dd\u5099\u552f\u4e00ID:" + l3 + "\u5df2\u7d93\u91cd\u65b0\u8a2d\u5b9a\u4e86\u6f5b\u80fd\u3000\u4e4b\u524d\u7684\u6dfa\u80fd1:" + (Serializable)object3 + " \u4e4b\u524d\u7684\u6dfa\u80fd2:" + (Serializable)object + " \u4e4b\u524d\u7684\u6dfa\u80fd3:" + (Serializable)(equip5.getPotential3() > 0 ? Integer.valueOf(equip.getPotential3()) : CashShopOperation.ALLATORIxDEMO("\u7147")) + "\r\n");
                        mapleClient = a2;
                    }
                    mapleClient.getPlayer().forceReAddItem_Equip(equip, MapleInventoryType.EQUIP);
                    MapleInventoryManipulator.addById(a2, ItemConstants.getCubeFragment(a4), (short)1, MapleNodes.ALLATORIxDEMO("\u5949\u5e57\u65b7\u5866\u737c\u5fbb"));
                    a2.getPlayer().addUseCube(1);
                    n2 = 1;
                } else {
                    a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8a44\u88bb\u50af\u6cf4\u673f\u6f3d\u80cb\u6270\u5dc4\u7df5\u8db3\u9028\u8a44\u65df\u587c\u809b\u650f\u8bec\u76b2\u6f3d\u80cb\u7b2f\u7d2c\u3064"));
                    bl = true;
                }
            } else {
                a2.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u6a8e\u67eb\u4f4c\u768a\u80e0\u530b\u6603\u5428\u5dde\u6ef1\u302e"));
                bl = true;
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(bl, a2.getPlayer().getId(), a4));
            return n2 != 0;
        }
        if (a4 == 5062002 || a4 == 5062005) {
            if (a2.getPlayer().getLevel() < 10) {
                a2.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u4f06\u76b2\u7b2f\u7d2c\u4e6b\u8d85W\u0006\u7b2f\uff3a\u7147\u6ce3\u4f19\u751e\u3064"));
                return n2 != 0;
            }
            if (a32 != null && a2.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
                Equip equip7 = (Equip)a32;
                byte by = 5;
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    by = 17;
                }
                if (equip7.getState() >= by) {
                    MapleClient mapleClient;
                    if (GameSetConstants.MAPLE_VERSION >= 138) {
                        if (MapleItemInformationProvider.getInstance().itemExists(5066000) && equip7.getState() >= 17 && equip7.getState() <= 20 && a2.getPlayer().haveItem(5066000, 1)) {
                            MapleClient mapleClient3 = a2;
                            mapleClient = mapleClient3;
                            mapleClient3.getPlayer().gainItem(5066000, -1);
                            equip7.renewPotential(3, 5066000, a4, a2.getPlayer());
                        } else {
                            equip7.renewPotential(3, 0, a4, a2.getPlayer());
                            mapleClient = a2;
                        }
                    } else {
                        equip7.renewPotential_super();
                        mapleClient = a2;
                    }
                    mapleClient.getPlayer().forceReAddItem_Equip(a32, MapleInventoryType.EQUIP);
                    MapleInventoryManipulator.addById(a2, ItemConstants.getCubeFragment(a4), (short)1, (a4 == 5062005 ? MapleNodes.ALLATORIxDEMO("\u9a54\u596b") : CashShopOperation.ALLATORIxDEMO("\u5085\u8acc")) + "\u65b9\u584a\u7372\u5f97");
                    n2 = 1;
                } else {
                    a2.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ae7\u78b4\u8aa1\u88d3\u50b5\u6621\u540a\u6707\u6dd6\u80f3\u0002"));
                    bl = true;
                }
            } else {
                a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u78dc\u8abb\u80aa\u5333\u7a1c\u95a5\u6649\u5410\u5389\u4ed3\u6558\u4e3d\u65df\u587c\u78e8\u7271H"));
                bl = true;
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(bl, a2.getPlayer().getId(), a4));
            return n2 != 0;
        }
        if (a4 == 5062500) {
            if (a32 != null && a2.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() >= 1) {
                byte by = 5;
                byte by4 = 8;
                if (GameSetConstants.MAPLE_VERSION >= 138) {
                    by = 17;
                    by4 = 20;
                }
                if (equip.getState() >= by && by != by4) {
                    MapleClient mapleClient = a2;
                    equip.renewPotential(0, 0, a4, a2.getPlayer());
                    mapleClient.getPlayer().forceReAddItem_Equip(a32, MapleInventoryType.EQUIP);
                    MapleInventoryManipulator.addById(mapleClient, ItemConstants.getCubeFragment(a4), (short)1);
                    a2.getPlayer().addUseCube(1);
                    n2 = 1;
                } else {
                    bl = true;
                    a2.getPlayer().dropMessage(5, MapleNodes.ALLATORIxDEMO("\u7896\u5b94\u88f1\u5097\u6603\u5428\u6725\u4e04\u6f77\u80f3\u0002"));
                }
            } else {
                bl = true;
                a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u78dc\u8abb\u80aa\u5333\u6649\u5410\u676f\u7a4c\u95f5\u6508\u78e8\u7271H"));
            }
            a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getPotentialReset(bl, a2.getPlayer().getId(), a4));
            return n2 != 0;
        }
        return false;
    }

    public static final /* synthetic */ boolean useItem(MapleClient a2, int a3) {
        if (GameConstants.isUse(a3)) {
            int n2;
            MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
            MapleStatEffect mapleStatEffect = mapleItemInformationProvider.getItemEffect(a3);
            if (mapleStatEffect == null) {
                return false;
            }
            if (a3 / 10000 == 291) {
                MapleClient mapleClient;
                block8: {
                    n2 = 0;
                    Iterator<Rectangle> iterator = a2.getPlayer().getMap().getAreas().iterator();
                    while (iterator.hasNext()) {
                        if (!iterator.next().contains(a2.getPlayer().getTruePosition())) continue;
                        n2 = 1;
                        mapleClient = a2;
                        break block8;
                    }
                    mapleClient = a2;
                }
                if (!mapleClient.getPlayer().inPVP() || a2.getPlayer().getTeam() == a3 - 2910000 && n2 != 0) {
                    return false;
                }
            }
            if ((n2 = mapleStatEffect.getConsume()) == 0) {
                n2 = mapleItemInformationProvider.isConsumeOnPickup(a3);
            }
            if (n2 > 0) {
                InventoryHandler.consumeItem(a2, mapleStatEffect);
                if (mapleItemInformationProvider.getItemEffectEX(a3) != null) {
                    InventoryHandler.consumeItem(a2, mapleItemInformationProvider.getItemEffectEX(a3));
                }
                a2.sendPacket(MaplePacketCreator.getShowItemGain(a3, (short)1));
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean useNpcTeleportRock(MapleClient a2, LittleEndianAccessor a2222, boolean a32) {
        LittleEndianAccessor littleEndianAccessor = a2222;
        short a2222 = littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        Object a2222 = MapleQuest.getInstance(a2222);
        if (!a32) {
            String a32 = CashShopOperation.ALLATORIxDEMO("q\u0007E\u000e");
            if (a2.getPlayer().getCSPoints(1) < 200) {
                a2.getPlayer().dropMessage(1, a32 + "\u4e0d\u8db3200");
                return false;
            }
            a2.getPlayer().modifyCSPoints(true ? (byte)1 : 0, -200, true);
        }
        if (a2.getPlayer().getQuest((MapleQuest)a2222).getStatus() == 1 && ((MapleQuest)a2222).canComplete(a2.getPlayer(), n2)) {
            int a32 = MapleLifeFactory.getNPCLocation(n2);
            if (a32 != -1) {
                a2222 = a2.getChannelServer().getMapFactory().getMap(a32);
                if (((MapleMap)a2222).containsNPC(n2) && a2.getPlayer().getEventInstance() == null) {
                    Object object = a2222;
                    a2.getPlayer().changeMap((MapleMap)object, ((MapleMap)object).getPortal(0));
                }
                return true;
            }
            a2.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u7672\u7533\u6724\u77c9\u768a\u9303\u8aaa\u0002"));
        }
        return false;
    }

    public static final /* synthetic */ void PlayerAutoPickup(MapleClient a2, MapleCharacter a3) {
        if (!World.isShutDown) {
            if (a3.hasBlockedInventory(true)) {
                a2.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
            arrmapleMapObjectType[0] = MapleMapObjectType.ITEM;
            for (MapleMapObject mapleMapObject : a3.getMap().getMapObjectsInRange(a3.getPosition(), 10000.0, Arrays.asList(arrmapleMapObjectType))) {
                if (mapleMapObject == null) continue;
                InventoryHandler.handlePickup(a2, a3, mapleMapObject, null, true);
            }
        }
    }

    public static final /* synthetic */ void UseSummonBag(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (!a4.isAlive() || a4.getMapId() == 910000000) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (GameSetConstants.SERVER_NAME.equals(CashShopOperation.ALLATORIxDEMO("\u6935\u4e7d\u75b3")) && a4.getMap().isTown()) {
            a4.dropMessage(1, MapleNodes.ALLATORIxDEMO("\u675f\u83a6\u712f\u6cf9\u4f71\u7504\u53e2\u55b6\u530b\r"));
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = (byte)littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
        if (iItem != null && iItem.getQuantity() >= 1 && iItem.getItemId() == n2) {
            if (!GameSetConstants.isNoConsumeItem(iItem.getItemId())) {
                MapleInventoryManipulator.removeFromSlot(a3, MapleInventoryType.USE, by, (short)1, false);
            }
            if (a3.getPlayer().isGM() || !FieldLimitType.SummoningBag.check(a4.getMap().getFieldLimit())) {
                List<Pair<Integer, Integer>> list = MapleItemInformationProvider.getInstance().getSummonMobs(n2);
                if (list == null) {
                    a3.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                n2 = 0;
                for (Pair pair : list) {
                    if (Randomizer.nextInt(99) > (Integer)pair.getRight()) continue;
                    list = MapleLifeFactory.getMonster((Integer)pair.getLeft());
                    ((MapleMonster)((Object)list)).setSummonMonster();
                    a4.getMap().spawnMonster_sSack((MapleMonster)((Object)list), a4.getPosition(), n2);
                }
            } else {
                a3.sendPacket(MaplePacketCreator.summonItemResult(false));
            }
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void UseSkillBook(byte a2, int a32, MapleClient a4, MapleCharacter a5) {
        MapleClient mapleClient;
        MapleInventoryType mapleInventoryType = GameConstants.getInventoryType(a32);
        IItem iItem = a5.getInventory(mapleInventoryType).getItem(a2);
        if (iItem == null || iItem.getQuantity() < 1 || iItem.getItemId() != a32) {
            return;
        }
        Map<String, Integer> a32 = MapleItemInformationProvider.getInstance().getSkillStats(iItem.getItemId());
        if (a32 == null) {
            return;
        }
        boolean bl = false;
        boolean bl2 = false;
        int n2 = 0;
        int n3 = 0;
        int n4 = a32.get(MapleNodes.ALLATORIxDEMO("_{OmI}_"));
        int n5 = a32.get(CashShopOperation.ALLATORIxDEMO("\u0014S\u0017e\r_\nZ*S\u0010S\n"));
        int n6 = a32.get(MapleNodes.ALLATORIxDEMO("Ao_zI|`kZk@"));
        if (n4 > 10) {
            n4 -= GameSetConstants.SKILLBOOK_DECREASE;
        }
        byte by = 0;
        while (true) {
            Object object = a32.get("skillid" + by);
            by = (byte)(by + 1);
            if (object == null) {
                mapleClient = a4;
                break;
            }
            boolean bl3 = false;
            int n7 = (int)Math.floor((Integer)object / 10000);
            if (GameConstants.isDualBlade(n7) && GameConstants.isDualBlade(a5.getJob())) {
                bl3 = true;
            }
            if (GameConstants.isEvan(n7) && GameConstants.isEvan(a5.getJob())) {
                bl3 = true;
            }
            if (Math.floor((Integer)object / 10000) != (double)a5.getJob() && !bl3) continue;
            if (a5.getSkillLevel((ISkill)(object = SkillFactory.getSkill((Integer)object))) >= n5 && a5.getMasterLevel((ISkill)object) < n6) {
                MapleClient mapleClient2;
                bl = true;
                if (Randomizer.nextInt(99) <= n4 && n4 != 0) {
                    bl2 = true;
                    mapleClient2 = a4;
                    MapleCharacter mapleCharacter = a5;
                    mapleCharacter.changeSkillLevel((ISkill)object, mapleCharacter.getSkillLevel((ISkill)object), (int)((byte)n6));
                } else {
                    bl2 = false;
                    mapleClient2 = a4;
                }
                MapleInventoryManipulator.removeFromSlot(mapleClient2, mapleInventoryType, a2, (short)1, false);
                mapleClient = a4;
                break;
            }
            bl = false;
        }
        mapleClient.getPlayer().getMap().broadcastMessage(MaplePacketCreator.useSkillBook(a5, n2, n3, bl, bl2));
    }

    public static final /* synthetic */ void UseReturnScroll(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (!a4.isAlive() || a4.getMapId() == 749040100) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = (byte)littleEndianAccessor.readShort();
        int n2 = littleEndianAccessor.readInt();
        IItem iItem = a4.getInventory(MapleInventoryType.USE).getItem(by);
        if (iItem == null || iItem.getQuantity() < 1 || iItem.getItemId() != n2) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!FieldLimitType.PotionUse.check(a4.getMap().getFieldLimit())) {
            MapleClient mapleClient = a3;
            if (MapleItemInformationProvider.getInstance().getItemEffect(iItem.getItemId()).applyReturnScroll(a4)) {
                MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.USE, by, (short)1, false);
                return;
            }
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static /* synthetic */ boolean handleSpReset(short a2, int a3, MapleClient a4, MapleCharacter a5) {
        if (JobConstants.isBeginnerJob(a5.getJob())) {
            a4.sendPacket(MaplePacketCreator.enableActions());
            return false;
        }
        a5.useSpReset();
        MapleInventoryManipulator.removeFromSlot(a4, GameConstants.getInventoryType(a3), a2, true ? (byte)1 : 0, true);
        a4.sendPacket(MaplePacketCreator.useSPReset(a5.getId()));
        return true;
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ void UseCashItem(LittleEndianAccessor a, MapleClient a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [93[DOLOOP]], but top level block is 94[WHILELOOP]
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void OwlMinerva(LittleEndianAccessor a, MapleClient a) {
        v0 = a;
        var2_2 = (byte)v0.readShort();
        var3_5 = v0.readInt();
        var2_3 = a.getPlayer().getInventory(MapleInventoryType.USE).getItem(var2_2);
        if (var2_3 == null || var2_3.getQuantity() <= 0 || var2_3.getItemId() != var3_5 || var3_5 != 2310000) ** GOTO lbl21
        var2_4 = a.readInt();
        var4_6 = new ArrayList<HiredMerchant>();
        for (ChannelServer var6_8 : LoginServer.getWorldStatic(a.getPlayer().getMap().getWorld()).getChannels()) {
            if (var6_8.getChannel() == -10 || var6_8.getChannel() == -20 || var6_8.searchMerchant(var2_4).isEmpty()) continue;
            var4_6.addAll(var6_8.searchMerchant(var2_4));
        }
        if (var4_6.size() > 0) {
            v1 = a;
            v2 = v1;
            v1.sendPacket(MaplePacketCreator.getOwlSearched(var2_4, var4_6));
            MapleInventoryManipulator.removeById(v1, MapleInventoryType.USE, var3_5, true ? 1 : 0, true, false);
        } else {
            a.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6270\u4e21\u523e\u8a5e\u7267\u54ed"));
lbl21:
            // 2 sources

            v2 = a;
        }
        v2.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void UseCatchItem(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        MapleClient mapleClient;
        block37: {
            block36: {
                LittleEndianAccessor littleEndianAccessor = a2;
                a3.getPlayer().updateTick(littleEndianAccessor.readInt());
                byte by = (byte)littleEndianAccessor.readShort();
                int n2 = littleEndianAccessor.readInt();
                MapleMonster mapleMonster = a4.getMap().getMonsterByOid(a2.readInt());
                Object object = a4.getInventory(MapleInventoryType.USE).getItem(by);
                if (object == null || object.getQuantity() <= 0 || object.getItemId() != n2 || mapleMonster == null) break block36;
                switch (n2) {
                    case 2270004: {
                        object = a4.getMap();
                        if (mapleMonster.getHp() <= mapleMonster.getMobMaxHp() / 2L) {
                            Object object2 = object;
                            ((MapleMap)object2).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)1));
                            ((MapleMap)object2).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleClient mapleClient2 = a3;
                            MapleInventoryManipulator.removeById(a3, MapleInventoryType.USE, n2, 1, false, false);
                            mapleClient = mapleClient2;
                            MapleInventoryManipulator.addById(mapleClient2, 4001169, (short)1);
                        } else {
                            ((MapleMap)object).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)0));
                            mapleClient = a3;
                            a4.dropMessage(5, MapleNodes.ALLATORIxDEMO("\u56cc\u6024\u7245\u768a\u7533\u5473\u5010\u9040\u9af4\uff02\u626c\u4eeb\u710d\u6cdb\u6379\u6347\uff2d"));
                        }
                        break block37;
                    }
                    case 0x22A332: {
                        Object object3 = object = a4.getMap();
                        if (mapleMonster.getHp() <= mapleMonster.getMobMaxHp() / 2L) {
                            ((MapleMap)object3).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)1));
                            MapleClient mapleClient3 = a3;
                            mapleClient = mapleClient3;
                            ((MapleMap)object).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleInventoryManipulator.removeById(mapleClient3, MapleInventoryType.USE, n2, 1, false, false);
                        } else {
                            ((MapleMap)object3).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)0));
                            mapleClient = a3;
                            a4.dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u5686\u601c\u720f\u76b2\u7579\u544b\u505a\u9078\u9abe\uff3a\u6226\u4ed3\u7147\u6ce3\u6333\u637f\uff67"));
                        }
                        break block37;
                    }
                    case 2270000: {
                        if (mapleMonster.getId() != 9300101) {
                            mapleClient = a3;
                        } else {
                            MapleClient mapleClient4 = a3;
                            mapleClient = mapleClient4;
                            Object object4 = object = mapleClient4.getPlayer().getMap();
                            ((MapleMap)object4).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)1));
                            ((MapleMap)object4).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleInventoryManipulator.addById(mapleClient4, 1902000, (short)1, null);
                            MapleInventoryManipulator.removeById(a3, MapleInventoryType.USE, n2, 1, false, false);
                        }
                        break block37;
                    }
                    case 0x22A333: {
                        if (mapleMonster.getId() != 9500320) {
                            mapleClient = a3;
                        } else {
                            Object object5 = object = a3.getPlayer().getMap();
                            if (mapleMonster.getHp() <= mapleMonster.getMobMaxHp() / 2L) {
                                ((MapleMap)object5).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)1));
                                MapleClient mapleClient5 = a3;
                                mapleClient = mapleClient5;
                                ((MapleMap)object).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                                MapleInventoryManipulator.removeById(mapleClient5, MapleInventoryType.USE, n2, 1, false, false);
                            } else {
                                ((MapleMap)object5).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getId(), n2, (byte)0));
                                mapleClient = a3;
                                a4.dropMessage(5, MapleNodes.ALLATORIxDEMO("\u56cc\u6024\u7245\u768a\u7533\u5473\u5010\u9040\u9af4\uff02\u626c\u4eeb\u710d\u6cdb\u6379\u6347\uff2d"));
                            }
                        }
                        break block37;
                    }
                    case 2270020: {
                        if (mapleMonster.getId() != 9300417) {
                            mapleClient = a3;
                        } else if (!a4.canHold(4032769)) {
                            mapleClient = a3;
                            a4.dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u78dc\u8abb\u80aa\u5333\u5110\u4ee0\u6b62\u4f7b\u6649\u5410\u8dd5\u5916\u3064"));
                        } else {
                            object = a3.getPlayer().getMap();
                            if (mapleMonster.getHp() > mapleMonster.getMobMaxHp() / 2L) break;
                            MapleClient mapleClient6 = a3;
                            mapleClient = mapleClient6;
                            Object object6 = object;
                            ((MapleMap)object6).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getObjectId(), n2, (byte)1));
                            ((MapleMap)object6).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleInventoryManipulator.removeById(mapleClient6, MapleInventoryType.USE, n2, 1, false, false);
                            a4.gainItem(4032769, 1);
                        }
                        break block37;
                    }
                    case 2270021: {
                        if (mapleMonster.getId() != 8600003) {
                            mapleClient = a3;
                        } else if (!a4.canHold(4032924)) {
                            mapleClient = a3;
                            a4.dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u7896\u8a83\u80e0\u530b\u515a\u4ed8\u6b28\u4f43\u6603\u5428\u8d9f\u592e\u302e"));
                        } else {
                            object = a3.getPlayer().getMap();
                            if (mapleMonster.getHp() > mapleMonster.getMobMaxHp() / 2L) break;
                            MapleClient mapleClient7 = a3;
                            mapleClient = mapleClient7;
                            Object object7 = object;
                            ((MapleMap)object7).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getObjectId(), n2, (byte)1));
                            ((MapleMap)object7).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleInventoryManipulator.removeById(mapleClient7, MapleInventoryType.USE, n2, 1, false, false);
                            a4.gainItem(4032924, 1);
                        }
                        break block37;
                    }
                    case 2270023: {
                        if (mapleMonster.getId() != 9300307) {
                            mapleClient = a3;
                        } else if (!a4.canHold(4033116)) {
                            mapleClient = a3;
                            a4.dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u8afd\u78dc\u8abb\u80aa\u5333\u5110\u4ee0\u6b62\u4f7b\u6649\u5410\u8dd5\u5916\u3064"));
                        } else {
                            object = a3.getPlayer().getMap();
                            if (mapleMonster.getHp() > mapleMonster.getMobMaxHp() / 2L) break;
                            MapleClient mapleClient8 = a3;
                            mapleClient = mapleClient8;
                            Object object8 = object;
                            ((MapleMap)object8).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getObjectId(), n2, (byte)1));
                            ((MapleMap)object8).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleInventoryManipulator.removeById(mapleClient8, MapleInventoryType.USE, n2, 1, false, false);
                            a4.gainItem(4033116, 1);
                        }
                        break block37;
                    }
                    case 2270024: {
                        if (mapleMonster.getId() != 9810303) {
                            mapleClient = a3;
                        } else if (!a4.canHold(4033206)) {
                            mapleClient = a3;
                            a4.dropMessage(5, MapleNodes.ALLATORIxDEMO("\u8ac5\u7896\u8a83\u80e0\u530b\u515a\u4ed8\u6b28\u4f43\u6603\u5428\u8d9f\u592e\u302e"));
                        } else {
                            object = a3.getPlayer().getMap();
                            if (mapleMonster.getHp() > mapleMonster.getMobMaxHp() / 2L) break;
                            MapleClient mapleClient9 = a3;
                            mapleClient = mapleClient9;
                            Object object9 = object;
                            ((MapleMap)object9).broadcastMessage(MaplePacketCreator.catchMonster(mapleMonster.getObjectId(), n2, (byte)1));
                            ((MapleMap)object9).killMonster(mapleMonster, a4, true, 0 != 0, (byte)0);
                            MapleInventoryManipulator.removeById(mapleClient9, MapleInventoryType.USE, n2, 1, false, false);
                            a4.gainItem(4033206, 1);
                        }
                        break block37;
                    }
                }
            }
            mapleClient = a3;
        }
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void ItemSort(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        a3.getPlayer().updateTick(littleEndianAccessor.readInt());
        MapleInventoryType mapleInventoryType = MapleInventoryType.getByType(littleEndianAccessor.readByte());
        if (mapleInventoryType == MapleInventoryType.UNDEFINED) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleInventory mapleInventory = a3.getPlayer().getInventory(mapleInventoryType);
        boolean bl = false;
        while (!bl) {
            byte by = (byte)mapleInventory.getNextFreeSlot();
            if (by != -1) {
                int n2;
                int n3;
                block6: {
                    n3 = -1;
                    byte by2 = (byte)(by + 1);
                    while (by2 <= mapleInventory.getSlotLimit()) {
                        byte by3;
                        if (mapleInventory.getItem(by3) != null) {
                            n2 = n3 = (int)by3;
                            break block6;
                        }
                        by2 = (byte)(by3 + 1);
                    }
                    n2 = n3;
                }
                if (n2 > 0) {
                    MapleInventoryManipulator.move(a3, mapleInventoryType, (short)n3, by);
                    continue;
                }
                bl = true;
                continue;
            }
            bl = true;
        }
        MapleClient mapleClient = a3;
        mapleClient.sendPacket(MaplePacketCreator.finishedSort(mapleInventoryType.getType()));
        mapleClient.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void PamSong(LittleEndianAccessor a2, MapleClient a3) {
        IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.CASH).findById(5640000);
        if (a2.readByte() > 0 && a3.getPlayer().getScrolledPosition() != 0 && iItem != null && iItem.getQuantity() > 0) {
            MapleInventoryType mapleInventoryType = a3.getPlayer().getScrolledPosition() < 0 ? MapleInventoryType.EQUIPPED : MapleInventoryType.EQUIP;
            MapleClient mapleClient = a3;
            IItem iItem2 = a3.getPlayer().getInventory(mapleInventoryType).getItem(mapleClient.getPlayer().getScrolledPosition());
            mapleClient.getPlayer().setScrolledPosition((short)0);
            if (iItem2 != null) {
                iItem2 = (Equip)iItem2;
                MapleClient mapleClient2 = a3;
                IItem iItem3 = iItem2;
                ((Equip)iItem3).setUpgradeSlots((byte)(((Equip)iItem3).getUpgradeSlots() + 1));
                mapleClient2.getPlayer().forceReAddItem_Flag(iItem2, mapleInventoryType);
                MapleInventoryManipulator.removeFromSlot(mapleClient2, MapleInventoryType.CASH, iItem.getPosition(), true ? (byte)1 : 0, true, false);
                a3.getPlayer().getMap().broadcastMessage(UIPacket.pamsSongEffect(a3.getPlayer().getId()));
                return;
            }
        } else {
            a3.getPlayer().setScrolledPosition((short)0);
        }
    }

    public static /* synthetic */ void owlse(MapleClient a2, int a3, int a4) {
        ArrayList<HiredMerchant> arrayList = new ArrayList<HiredMerchant>();
        for (ChannelServer channelServer : LoginServer.getWorldStatic(a2.getPlayer().getMap().getWorld()).getChannels()) {
            if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20 || channelServer.searchMerchant(a4).isEmpty()) continue;
            arrayList.addAll(channelServer.searchMerchant(a4));
        }
        if (arrayList.size() > 0) {
            if (a2.getPlayer().haveItem(5230000, 1)) {
                MapleInventoryManipulator.removeById(a2, MapleInventoryType.CASH, 5230000, true ? (byte)1 : 0, true, false);
            } else if (a2.getPlayer().getCSPoints(a3) >= 5) {
                a2.getPlayer().modifyCSPoints(a3, -5, true);
            } else {
                a2.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u9ee8\u651e\u4e3b\u8dd5\uff3a\u7147\u6ce3\u6783\u8a54\uff67"));
                return;
            }
            if (NPCScriptManager.getInstance().getCM(a2) != null) {
                NPCScriptManager.getInstance().dispose(a2);
            }
            a2.sendPacket(MaplePacketCreator.getOwlSearched(a4, arrayList));
            return;
        }
        if (NPCScriptManager.getInstance().getCM(a2) != null) {
            NPCScriptManager.getInstance().dispose(a2);
            a2.sendPacket(MaplePacketCreator.enableActions());
        }
        a2.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u6252\u4e03\u521c\u7267\u54ed"));
    }

    public static /* synthetic */ void useInnerCirculator(LittleEndianAccessor a2, MapleClient a3) {
        Object object;
        Iterator<InnerSkillValueHolder> iterator;
        if (a3 == null || a3.getPlayer() == null || a3.getPlayer().getMap() == null) {
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        short s2 = (short)littleEndianAccessor.readInt();
        Object object2 = a3.getPlayer().getInventory(GameConstants.getInventoryType(n2)).getItem(s2);
        if (object2 == null || object2.getItemId() != n2) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        object2 = new LinkedList();
        int n3 = 0;
        Iterator<InnerSkillValueHolder> iterator2 = iterator = a3.getPlayer().getInnerSkills().iterator();
        while (iterator2.hasNext()) {
            object = iterator.next();
            if (!((InnerSkillValueHolder)object).isLocked()) {
                if (n3 == 0 && a3.getPlayer().getInnerSkills().size() > 1 && n2 == 2701000) {
                    object2.add(InnerAbillity.getInstance().renewSkill(((InnerSkillValueHolder)object).getRank(), n2, true, false));
                } else {
                    object2.add(InnerAbillity.getInstance().renewSkill(((InnerSkillValueHolder)object).getRank(), n2, false, false));
                }
            } else {
                object2.add(InnerAbillity.getInstance().renewSkill(((InnerSkillValueHolder)object).getRank(), n2, false, ((InnerSkillValueHolder)object).isLocked()));
            }
            ++n3;
            iterator2 = iterator;
        }
        a3.getPlayer().getInnerSkills().clear();
        byte by = 1;
        Object object3 = object = object2.iterator();
        while (object3.hasNext()) {
            InnerSkillValueHolder innerSkillValueHolder = (InnerSkillValueHolder)object.next();
            object3 = object;
            a3.getPlayer().getInnerSkills().add(innerSkillValueHolder);
            byte by2 = by;
            a3.sendPacket(MaplePacketCreator.updateInnerPotential(by2, innerSkillValueHolder.getSkillId(), innerSkillValueHolder.getSkillLevel(), innerSkillValueHolder.getRank()));
            by = (byte)(by2 + 1);
        }
        MapleClient mapleClient = a3;
        mapleClient.getPlayer().setInnerSkillChanged();
        MapleInventoryManipulator.removeFromSlot(mapleClient, MapleInventoryType.USE, s2, (short)1, false);
        MapleClient mapleClient2 = a3;
        mapleClient2.getPlayer().getStat().recalcLocalStats(false);
        mapleClient2.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u5101\u571e\u809b\u52ad\u8a4b\u5bac\u6276\u52a9\u3064"));
        mapleClient2.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void Owl(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().haveItem(5230000, 1, false, false) || a3.getPlayer().haveItem(2310000, 1, false, false)) {
            if (a3.getPlayer().getMapId() >= 910000000 && a3.getPlayer().getMapId() <= 910000022) {
                a3.sendPacket(MaplePacketCreator.getOwlOpen());
                return;
            }
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u9636\u81dc\u7557\u5e34\u5852\u51b3\u4f19\u751e\u3064"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(MapleClient a2) {
        int n2;
        if (a2.getPlayer().getInventory(MapleInventoryType.EQUIP).getNumFreeSlot() < 2 || a2.getPlayer().getInventory(MapleInventoryType.USE).getNumFreeSlot() < 2 || a2.getPlayer().getInventory(MapleInventoryType.SETUP).getNumFreeSlot() < 2) {
            a2.getPlayer().dropMessage(5, CashShopOperation.ALLATORIxDEMO("\u80fa\u5363\u7a4c\u95f5\u4e3b\u8dd5"));
            return false;
        }
        int[] arrn = new int[84];
        arrn[0] = 2430091;
        arrn[1] = 2430092;
        arrn[2] = 2430093;
        arrn[3] = 2430101;
        arrn[4] = 2430102;
        arrn[5] = 2340000;
        arrn[6] = 1152000;
        arrn[7] = 1152001;
        arrn[8] = 1152004;
        arrn[9] = 1152005;
        arrn[10] = 1152006;
        arrn[11] = 1152007;
        arrn[12] = 1152008;
        arrn[13] = 1000040;
        arrn[14] = 1102246;
        arrn[15] = 1082276;
        arrn[16] = 1050169;
        arrn[17] = 1051210;
        arrn[18] = 1072447;
        arrn[19] = 1442106;
        arrn[20] = 3010019;
        arrn[21] = 1001060;
        arrn[22] = 1002391;
        arrn[23] = 1102004;
        arrn[24] = 1050039;
        arrn[25] = 1102040;
        arrn[26] = 1102041;
        arrn[27] = 1102042;
        arrn[28] = 1102043;
        arrn[29] = 1082145;
        arrn[30] = 1082146;
        arrn[31] = 1082147;
        arrn[32] = 1082148;
        arrn[33] = 1082149;
        arrn[34] = 1082150;
        arrn[35] = 2043704;
        arrn[36] = 2040904;
        arrn[37] = 2040409;
        arrn[38] = 2040307;
        arrn[39] = 2041030;
        arrn[40] = 2040015;
        arrn[41] = 2040109;
        arrn[42] = 2041035;
        arrn[43] = 2041036;
        arrn[44] = 2040009;
        arrn[45] = 2040511;
        arrn[46] = 2040408;
        arrn[47] = 2043804;
        arrn[48] = 2044105;
        arrn[49] = 2044903;
        arrn[50] = 2044804;
        arrn[51] = 2043009;
        arrn[52] = 2043305;
        arrn[53] = 2040610;
        arrn[54] = 2040716;
        arrn[55] = 2041037;
        arrn[56] = 2043005;
        arrn[57] = 2041032;
        arrn[58] = 0x1F21F1;
        arrn[59] = 2040211;
        arrn[60] = 2040212;
        arrn[61] = 1022097;
        arrn[62] = 2049000;
        arrn[63] = 2049001;
        arrn[64] = 2049002;
        arrn[65] = 2049003;
        arrn[66] = 1012058;
        arrn[67] = 1012059;
        arrn[68] = 1012060;
        arrn[69] = 1012061;
        arrn[70] = 1332100;
        arrn[71] = 1382058;
        arrn[72] = 1402073;
        arrn[73] = 1432066;
        arrn[74] = 1442090;
        arrn[75] = 1452058;
        arrn[76] = 1462076;
        arrn[77] = 1472069;
        arrn[78] = 1482051;
        arrn[79] = 1492024;
        arrn[80] = 1342009;
        arrn[81] = 2049400;
        arrn[82] = 2049401;
        arrn[83] = 2049301;
        int[] arrn2 = arrn;
        int[] arrn3 = new int[85];
        arrn3[0] = 100;
        arrn3[1] = 100;
        arrn3[2] = 100;
        arrn3[3] = 100;
        arrn3[4] = 100;
        arrn3[5] = 1;
        arrn3[6] = 10;
        arrn3[7] = 10;
        arrn3[8] = 10;
        arrn3[9] = 10;
        arrn3[10] = 10;
        arrn3[11] = 10;
        arrn3[12] = 10;
        arrn3[13] = 5;
        arrn3[14] = 5;
        arrn3[15] = 5;
        arrn3[16] = 5;
        arrn3[17] = 5;
        arrn3[18] = 5;
        arrn3[19] = 5;
        arrn3[20] = 2;
        arrn3[21] = 10;
        arrn3[22] = 10;
        arrn3[23] = 10;
        arrn3[24] = 10;
        arrn3[25] = 10;
        arrn3[26] = 10;
        arrn3[27] = 10;
        arrn3[28] = 10;
        arrn3[29] = 5;
        arrn3[30] = 5;
        arrn3[31] = 5;
        arrn3[32] = 5;
        arrn3[33] = 5;
        arrn3[34] = 5;
        arrn3[35] = 10;
        arrn3[36] = 10;
        arrn3[37] = 10;
        arrn3[38] = 10;
        arrn3[39] = 10;
        arrn3[40] = 10;
        arrn3[41] = 10;
        arrn3[42] = 10;
        arrn3[43] = 10;
        arrn3[44] = 10;
        arrn3[45] = 10;
        arrn3[46] = 10;
        arrn3[47] = 10;
        arrn3[48] = 10;
        arrn3[49] = 10;
        arrn3[50] = 10;
        arrn3[51] = 10;
        arrn3[52] = 10;
        arrn3[53] = 10;
        arrn3[54] = 10;
        arrn3[55] = 10;
        arrn3[56] = 10;
        arrn3[57] = 10;
        arrn3[58] = 10;
        arrn3[59] = 5;
        arrn3[60] = 5;
        arrn3[61] = 10;
        arrn3[62] = 10;
        arrn3[63] = 10;
        arrn3[64] = 10;
        arrn3[65] = 10;
        arrn3[66] = 5;
        arrn3[67] = 5;
        arrn3[68] = 5;
        arrn3[69] = 5;
        arrn3[70] = 2;
        arrn3[71] = 2;
        arrn3[72] = 2;
        arrn3[73] = 2;
        arrn3[74] = 2;
        arrn3[75] = 2;
        arrn3[76] = 2;
        arrn3[77] = 2;
        arrn3[78] = 2;
        arrn3[79] = 2;
        arrn3[80] = 2;
        arrn3[81] = 1;
        arrn3[82] = 2;
        arrn3[83] = 1;
        arrn3[84] = 2;
        int[] arrn4 = arrn3;
        int n3 = Randomizer.nextInt(arrn2.length);
        int[] arrn5 = arrn4;
        while (arrn5[n3] < Randomizer.nextInt(1000)) {
            n3 = Randomizer.nextInt(arrn2.length);
            arrn5 = arrn4;
        }
        int n4 = n2 = Randomizer.nextInt(arrn2.length);
        while (n4 == n3 || arrn4[n2] < Randomizer.nextInt(1000)) {
            n4 = Randomizer.nextInt(arrn2.length);
        }
        a2.sendPacket(MaplePacketCreator.getPeanutResult(arrn2[n3], (short)1, arrn2[n2], (short)1));
        return MapleInventoryManipulator.addById(a2, arrn2[n3], (short)1) && MapleInventoryManipulator.addById(a2, arrn2[n2], (short)1);
    }

    public static final /* synthetic */ void ItemMove(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer().hasBlockedInventory(true)) {
            return;
        }
        if (MapConstants.BanItemMoveMap(a3.getPlayer().getMapId())) {
            a3.getPlayer().dropMessage(1, CashShopOperation.ALLATORIxDEMO("\u6b02\u5706\u5770\u7117\u6cb3\u79cd\u52b3\u6220\u6692\u63ed\u88bb\u50afG"));
            return;
        }
        a3.getPlayer().updateTick(a2.readInt());
        LittleEndianAccessor littleEndianAccessor = a2;
        MapleInventoryType mapleInventoryType = MapleInventoryType.getByType(littleEndianAccessor.readByte());
        short s2 = littleEndianAccessor.readShort();
        short s3 = littleEndianAccessor.readShort();
        short s4 = littleEndianAccessor.readShort();
        if (s2 < 0 && s3 > 0) {
            MapleInventoryManipulator.unequip(a3, s2, s3, true);
            return;
        }
        if (s3 < 0) {
            MapleInventoryManipulator.equip(a3, s2, s3);
            return;
        }
        MapleClient mapleClient = a3;
        if (s3 == 0) {
            MapleInventoryManipulator.drop(mapleClient, mapleInventoryType, s2, s4);
            return;
        }
        MapleInventoryManipulator.move(mapleClient, mapleInventoryType, s2, s3);
    }

    public static final /* synthetic */ void PlayerPickup(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        if (World.isShutDown) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, MapleNodes.ALLATORIxDEMO("\u76e0\u5261\u712f\u6cf9\u64b1\u7245\u54cf\u302e"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (a4.hasBlockedInventory(true)) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        a4.updateTick(littleEndianAccessor.readInt());
        littleEndianAccessor.skip(1);
        Point point = littleEndianAccessor.readPos();
        MapleMapObject mapleMapObject = a4.getMap().getMapObject(a2.readInt(), MapleMapObjectType.ITEM);
        if (mapleMapObject == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        InventoryHandler.handlePickup(a3, a4, mapleMapObject, point, false);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void UseMagnify(byte a, byte a, MapleClient a) {
        block90: {
            a.getPlayer().setScrolledPosition((short)0);
            var3_4 = a == 127 && a.getPlayer().getTrait(MapleTrait.MapleTraitType.\u611f\u6027).getLevel() >= 30;
            var4_5 = a.getPlayer().getInventory(MapleInventoryType.USE).getItem(a);
            v0 = var5_6 = a < 0 ? a.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(a) : a.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a);
            if (var4_5 == null && !var3_4 || var5_6 == null) {
                a.sendPacket(MaplePacketCreator.getInventoryFull());
                return;
            }
            if (ItemConstants.\u985e\u578b.\u6a5f\u68b0((int)var5_6.getItemId()) || ItemConstants.\u985e\u578b.\u9f8d\u88dd\u5099((int)var5_6.getItemId())) {
                v1 = a;
                v1.getPlayer().dropMessage(MapleNodes.ALLATORIxDEMO("\u6b6a\u9872\u5785\u76a8\u88d3\u50b5\u712f\u6cf9\u4f71\u7504\u6530\u590b\u93ef\r"));
                v1.sendPacket(MaplePacketCreator.getInventoryFull());
                return;
            }
            a = (Equip)var5_6;
            var5_6 = MapleItemInformationProvider.getInstance();
            var6_7 = var5_6.getReqLevel(a.getItemId());
            v2 = a;
            var7_8 = Math.min(19, var5_6.getReqLevel(v2.getItemId()) / 10);
            var8_9 = false;
            if (v2.getPotential4() <= -17 && a.getPotential4() >= -20) {
                var8_9 = true;
            }
            if (a.getPotential5() <= -17 && a.getPotential5() >= -20) {
                var8_9 = true;
            }
            var9_10 = 0;
            var10_11 = new StringBuilder();
            if (var5_6.getReqLevel(a.getItemId()) % 10 == 0 && var7_8 != 0) {
                --var7_8;
            }
            if (var4_5 == null) ** GOTO lbl-1000
            switch (var4_5.getItemId()) {
                case 2460000: {
                    var9_10 = var6_7 <= 30 ? 1 : 0;
                    v3 = a;
                    break;
                }
                case 2460001: {
                    var9_10 = var6_7 <= 70 ? 1 : 0;
                    v3 = a;
                    break;
                }
                case 2460002: {
                    var9_10 = var6_7 <= 120 ? 1 : 0;
                    v3 = a;
                    break;
                }
                case 2460003: 
                case 2460004: 
                case 2460005: {
                    var9_10 = 1;
                }
                default: lbl-1000:
                // 2 sources

                {
                    v3 = a;
                }
            }
            if (!(v3.getState() == 1 && var3_4 && var4_5 == null || var9_10 != 0)) {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            var5_6 = new LinkedList<Map<Integer, StructPotentialItem>>(var5_6.getAllPotentialInfo().values());
            var6_7 = Math.abs(a.getPotential1());
            if (GameSetConstants.MAPLE_VERSION >= 138) {
                if (var6_7 > 21) {
                    var6_7 = 21;
                } else if (var6_7 < 17) {
                    var6_7 = 17;
                }
            } else {
                if (var6_7 < 5) {
                    var6_7 = 5;
                }
                if (var6_7 >= 8) {
                    var6_7 = 7;
                }
            }
            var9_10 = 0;
            var11_12 = 0;
            var12_13 = 10000;
            v4 = var12_13 = a.getPotential2() != 0 ? 3 : 2;
            if (var3_4) {
                var13_14 = ItemConstants.getCubeNeedMeso(a);
                if ((long)a.getPlayer().getMeso() < var13_14) {
                    a.getPlayer().dropMessage(5, "\u81f3\u5c11\u9700\u8981" + var13_14 + "\u6953\u5e63\u3002");
                    a.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                a.getPlayer().gainMeso((int)(-var13_14), false);
            }
            if ((var13_15 = var6_7) == 21) {
                var13_15 = 20;
            }
            if (var8_9) {
                v5 = a;
                var13_15 = var6_7 = Math.abs(v5.getPotential4());
                v6 = var12_13 = v5.getPotential5() != 0 ? 2 : 1;
                block15: while (a.getStateAdd() != var13_15) {
                    ++var9_10;
                    var10_11 = new StringBuilder();
                    v7 = var14_16 = 0;
                    while (true) {
                        if (v7 < var12_13) {
                            v8 = var15_18 = false;
                        } else {
                            if (var9_10 < 10000) continue block15;
                            v9 = a;
                            break block90;
                        }
                        while (!v8) {
                            v10 = var5_6;
                            var16_20 = (StructPotentialItem)((Map)v10.get(Randomizer.nextInt(v10.size()))).get(var7_8 + 1);
                            if (++var11_12 >= 10000) break;
                            if (var16_20 == null) {
                                v8 = var15_18;
                                continue;
                            }
                            if (var16_20.reqLevel / 10 > var7_8) {
                                v8 = var15_18;
                                continue;
                            }
                            v11 = var16_20;
                            if (!GameConstants.optionTypeFits(v11.opID, v11.optionType, a.getItemId())) {
                                v8 = var15_18;
                                continue;
                            }
                            if (var16_20.opID < 10000) {
                                v8 = var15_18;
                                continue;
                            }
                            if (!GameConstants.potentialIDFits(var16_20.opID, var6_7, var14_16)) {
                                v8 = var15_18;
                                continue;
                            }
                            if (!GameConstants.isAllowedPotentialStat(var16_20.opID, var8_9)) {
                                v8 = var15_18;
                                continue;
                            }
                            switch (var14_16) {
                                case 0: {
                                    a.setPotential4(var16_20.opID);
                                    a.getPlayer().dropMessage(5, "\u7b2c\u56db\u884c\u6f5b\u80fd >> " + var16_20.getInfo() + " " + var16_20.opID);
                                    var17_22 = "";
                                    if (var16_20.opID >= 40000) {
                                        var17_22 = CashShopOperation.ALLATORIxDEMO("\u0015\u0001\u001e\u50d5\u8a9cO\u0015\r");
                                        v12 = var10_11;
                                    } else if (var16_20.opID >= 30000) {
                                        var17_22 = MapleNodes.ALLATORIxDEMO("-^&\u7f79\u8985\u0005-G");
                                        v12 = var10_11;
                                    } else if (var16_20.opID >= 20000) {
                                        var17_22 = CashShopOperation.ALLATORIxDEMO("\u0015\u0002\u001e\u7a66\u673fO\u0015\r");
                                        v12 = var10_11;
                                    } else {
                                        if (var16_20.opID >= 1) {
                                            var17_22 = MapleNodes.ALLATORIxDEMO("-N&\u7255\u6b84\u0005-G");
                                        }
                                        v12 = var10_11;
                                    }
                                    v12.append(var17_22 + "\u7b2c\u56db\u884c\u6f5b\u80fd >> " + var16_20.getInfo() + "\r\n");
                                    break;
                                }
                                case 1: {
                                    a.setPotential5(var16_20.opID);
                                    a.getPlayer().dropMessage(5, "\u7b2c\u4e94\u884c\u6f5b\u80fd >> " + var16_20.getInfo());
                                    var17_22 = "";
                                    if (var16_20.opID >= 40000) {
                                        var17_22 = CashShopOperation.ALLATORIxDEMO("\u0015\u0001\u001e\u50d5\u8a9cO\u0015\r");
                                        v13 = var10_11;
                                    } else if (var16_20.opID >= 30000) {
                                        var17_22 = MapleNodes.ALLATORIxDEMO("-^&\u7f79\u8985\u0005-G");
                                        v13 = var10_11;
                                    } else if (var16_20.opID >= 20000) {
                                        var17_22 = CashShopOperation.ALLATORIxDEMO("\u0015\u0002\u001e\u7a66\u673fO\u0015\r");
                                        v13 = var10_11;
                                    } else {
                                        if (var16_20.opID >= 1) {
                                            var17_22 = MapleNodes.ALLATORIxDEMO("-N&\u7255\u6b84\u0005-G");
                                        }
                                        v13 = var10_11;
                                    }
                                    v13.append(var17_22 + "\u7b2c\u4e94\u884c\u6f5b\u80fd >> " + var16_20.getInfo() + "\r\n");
                                    break;
                                }
                            }
                            v8 = var15_18 = true;
                        }
                        var11_12 = 0;
                        v7 = ++var14_16;
                    }
                }
            } else {
                block18: while (a.getState() != var13_15) {
                    ++var9_10;
                    var10_11 = new StringBuilder();
                    v14 = var14_17 = 0;
                    while (true) {
                        if (v14 < var12_13) {
                            v15 = var15_19 = false;
                        } else {
                            if (var9_10 < 10000) continue block18;
                            v9 = a;
                            break block90;
                        }
                        while (!v15) {
                            v16 = var5_6;
                            var16_21 = (StructPotentialItem)((Map)v16.get(Randomizer.nextInt(v16.size()))).get(var7_8 + 1);
                            if (++var11_12 >= 10000) break;
                            if (var16_21 == null) {
                                v15 = var15_19;
                                continue;
                            }
                            if (var16_21.reqLevel / 10 > var7_8) {
                                v15 = var15_19;
                                continue;
                            }
                            v17 = var16_21;
                            if (!GameConstants.optionTypeFits(v17.opID, v17.optionType, a.getItemId())) {
                                v15 = var15_19;
                                continue;
                            }
                            if (!GameConstants.potentialIDFits(var16_21.opID, var6_7, var14_17)) {
                                v15 = var15_19;
                                continue;
                            }
                            if (!GameConstants.isAllowedPotentialStat(var16_21.opID, var8_9)) {
                                v15 = var15_19;
                                continue;
                            }
                            switch (var14_17) {
                                case 0: {
                                    a.setPotential1(var16_21.opID);
                                    a.getPlayer().dropMessage(5, "\u7b2c\u4e00\u884c\u6f5b\u80fd >> " + var16_21.getInfo());
                                    var17_23 = "";
                                    if (var16_21.opID >= 40000) {
                                        var17_23 = CashShopOperation.ALLATORIxDEMO("\u0015\u0001\u001e\u50d5\u8a9cO\u0015\r");
                                        v18 = var10_11;
                                    } else if (var16_21.opID >= 30000) {
                                        var17_23 = MapleNodes.ALLATORIxDEMO("-^&\u7f79\u8985\u0005-G");
                                        v18 = var10_11;
                                    } else if (var16_21.opID >= 20000) {
                                        var17_23 = CashShopOperation.ALLATORIxDEMO("\u0015\u0002\u001e\u7a66\u673fO\u0015\r");
                                        v18 = var10_11;
                                    } else {
                                        if (var16_21.opID >= 1) {
                                            var17_23 = MapleNodes.ALLATORIxDEMO("-N&\u7255\u6b84\u0005-G");
                                        }
                                        v18 = var10_11;
                                    }
                                    v18.append(var17_23 + "\u7b2c\u4e00\u884c\u6f5b\u80fd >> " + var16_21.getInfo() + "\r\n");
                                    break;
                                }
                                case 1: {
                                    a.setPotential2(var16_21.opID);
                                    a.getPlayer().dropMessage(5, "\u7b2c\u4e8c\u884c\u6f5b\u80fd >> " + var16_21.getInfo());
                                    var17_23 = "";
                                    if (var16_21.opID >= 40000) {
                                        var17_23 = CashShopOperation.ALLATORIxDEMO("\u0015\u0001\u001e\u50d5\u8a9cO\u0015\r");
                                        v19 = var10_11;
                                    } else if (var16_21.opID >= 30000) {
                                        var17_23 = MapleNodes.ALLATORIxDEMO("-^&\u7f79\u8985\u0005-G");
                                        v19 = var10_11;
                                    } else if (var16_21.opID >= 20000) {
                                        var17_23 = CashShopOperation.ALLATORIxDEMO("\u0015\u0002\u001e\u7a66\u673fO\u0015\r");
                                        v19 = var10_11;
                                    } else {
                                        if (var16_21.opID >= 1) {
                                            var17_23 = MapleNodes.ALLATORIxDEMO("-N&\u7255\u6b84\u0005-G");
                                        }
                                        v19 = var10_11;
                                    }
                                    v19.append(var17_23 + "\u7b2c\u4e8c\u884c\u6f5b\u80fd >> " + var16_21.getInfo() + "\r\n");
                                    break;
                                }
                                case 2: {
                                    a.setPotential3(var16_21.opID);
                                    a.getPlayer().dropMessage(5, "\u7b2c\u4e09\u884c\u6f5b\u80fd >> " + var16_21.getInfo());
                                    var17_23 = "";
                                    if (var16_21.opID >= 40000) {
                                        var17_23 = CashShopOperation.ALLATORIxDEMO("\u0015\u0001\u001e\u50d5\u8a9cO\u0015\r");
                                        v20 = var10_11;
                                    } else if (var16_21.opID >= 30000) {
                                        var17_23 = MapleNodes.ALLATORIxDEMO("-^&\u7f79\u8985\u0005-G");
                                        v20 = var10_11;
                                    } else if (var16_21.opID >= 20000) {
                                        var17_23 = CashShopOperation.ALLATORIxDEMO("\u0015\u0002\u001e\u7a66\u673fO\u0015\r");
                                        v20 = var10_11;
                                    } else {
                                        if (var16_21.opID >= 1) {
                                            var17_23 = MapleNodes.ALLATORIxDEMO("-N&\u7255\u6b84\u0005-G");
                                        }
                                        v20 = var10_11;
                                    }
                                    v20.append(var17_23 + "\u7b2c\u4e09\u884c\u6f5b\u80fd >> " + var16_21.getInfo() + "\r\n");
                                    break;
                                }
                            }
                            v15 = var15_19 = true;
                        }
                        var11_12 = 0;
                        v14 = ++var14_17;
                    }
                }
            }
            v9 = a;
        }
        v9.getPlayer().setNpcPotentialMessage(var10_11.toString());
        v21 = a;
        v21.getPlayer().forceReAddItem_Equip(a, MapleInventoryType.EQUIP);
        v21.getPlayer().getTrait(MapleTrait.MapleTraitType.\u6d1e\u5bdf\u529b).addExp((var3_4 != false ? 10 : var4_5.getItemId() + 2 - 2460000) * 2, a.getPlayer());
        v22 = a;
        v22.sendPacket(MaplePacketCreator.getMagnifyingGlass(v22.getPlayer().getId(), a.getPosition()));
        if (!var3_4) {
            MapleInventoryManipulator.removeFromSlot(a, MapleInventoryType.USE, var4_5.getPosition(), (short)1, false);
        }
        a.sendPacket(MaplePacketCreator.enableActions());
    }
}

