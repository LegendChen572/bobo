/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package scripting.npc;

import FuckingHackerToby.L;
import client.ISkill;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleJob;
import client.MapleStat;
import client.SkillEntry;
import client.SkillFactory;
import client.inventory.Equip;
import client.inventory.IItem;
import client.inventory.InventoryException;
import client.inventory.Item;
import client.inventory.ItemFlag;
import client.inventory.MapleImp;
import client.inventory.MapleInventory;
import client.inventory.MapleInventoryType;
import client.inventory.MapleMount;
import client.inventory.ModifyInventory;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import database.DBConPool;
import handling.channel.ChannelServer;
import handling.channel.MapleRanking;
import handling.channel.handler.InventoryHandler;
import handling.login.LoginServer;
import handling.opcodes.GameDirectionType;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.guild.MapleGuild;
import handling.world.guild.MapleGuildAlliance;
import java.awt.Point;
import java.io.Serializable;
import java.sql.SQLException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.Invocable;
import scripting.AbstractPlayerInteraction;
import scripting.ScriptType;
import scripting.event.EventInstanceManager;
import scripting.npc.NPCScriptManager;
import server.Coupon.CouponCreate;
import server.MapleCarnivalChallenge;
import server.MapleCarnivalParty;
import server.MapleGachapon;
import server.MapleGachaponItem;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import server.MapleShopFactory;
import server.MapleSquad;
import server.MapleStatEffect;
import server.MapleStorageType;
import server.Randomizer;
import server.SpeedRunner;
import server.StructPotentialItem;
import server.Timer;
import server.game.Baccarat;
import server.game.BlackJack;
import server.game.Cryptocurrency;
import server.game.NiuNiu;
import server.gashapon.Gashapon;
import server.gashapon.GashaponFactory;
import server.gashapon.GashaponRewardSpecial;
import server.gashapon.GashaponSpecial;
import server.life.ItemDropEntry;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterInformationProvider;
import server.life.MapleMonsterPet;
import server.life.MapleNPC;
import server.life.MonsterDropEntry;
import server.maps.AbstractMapleMapObject;
import server.maps.AramiaFireWorks;
import server.maps.Event_DojoAgent;
import server.maps.Event_PyramidSubway;
import server.maps.MapleFoothold;
import server.maps.MapleMap;
import server.maps.MapleMapFactory;
import server.maps.MapleMapItem;
import server.maps.MapleMapObject;
import server.maps.MapleMapObjectType;
import server.maps.SpeedRunType;
import server.quest.MapleQuest;
import tools.BitTools;
import tools.FileoutputUtil;
import tools.LoadPacket;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.Pair;
import tools.SearchGenerator;
import tools.StringTool;
import tools.StringUtil;
import tools.damageSkin.AttackFont;
import tools.data.LittleEndianAccessor;
import tools.packet.BeansPacket;
import tools.packet.PlayerShopPacket;
import tools.packet.UIPacket;

public class NPCConversationManager
extends AbstractPlayerInteraction {
    private /* synthetic */ Equip ALLATORIxDEMO;
    private final /* synthetic */ ScriptType K;
    private final /* synthetic */ int B;
    private /* synthetic */ String k;
    private final /* synthetic */ int g;
    public /* synthetic */ boolean pendingDisposal;
    private /* synthetic */ byte a;
    public static final /* synthetic */ Map<Pair<Integer, MapleClient>, MapleNPC> npcRequestController;
    private final /* synthetic */ Invocable d;
    public /* synthetic */ String script;
    public final /* synthetic */ MapleClient c;
    private final /* synthetic */ int E;

    public /* synthetic */ void sendNextPrev(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000ep\u000fa"), (byte)0));
        a3.a = 0;
    }

    public /* synthetic */ void sendLeftPlayerToNpc(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.sendNextS(a2, (byte)16, nPCConversationManager.E);
    }

    public /* synthetic */ void showdonate() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showdonateRanks(nPCConversationManager.E, MapleRanking.getInstance().getDonateRank()));
    }

    public /* synthetic */ void playerMoveLeft() {
        NPCConversationManager a2;
        int[] arrn = new int[1];
        arrn[0] = 1;
        a2.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedInput.getValue(), null, arrn);
    }

    public final /* synthetic */ void patternInput(String a2, int[] a3) {
        NPCConversationManager a4;
        a4.getDirectionEffect(GameDirectionType.InGameDirectionEvent_PatternInputRequest.getValue(), a2, a3);
    }

    public /* synthetic */ void unequipEverything() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        Iterator iterator = nPCConversationManager.getPlayer().getInventory(MapleInventoryType.EQUIPPED);
        MapleInventory mapleInventory = nPCConversationManager.getPlayer().getInventory(MapleInventoryType.EQUIP);
        LinkedList<Short> linkedList = new LinkedList<Short>();
        iterator = ((MapleInventory)((Object)iterator)).list().iterator();
        Iterator<IItem> iterator2 = iterator;
        while (iterator2.hasNext()) {
            IItem iItem = (IItem)iterator.next();
            iterator2 = iterator;
            linkedList.add(iItem.getPosition());
        }
        Iterator iterator3 = iterator = linkedList.iterator();
        while (iterator3.hasNext()) {
            short s2 = (Short)iterator.next();
            iterator3 = iterator;
            MapleInventoryManipulator.unequip(a2.getC(), s2, mapleInventory.getNextFreeSlot(), true);
        }
    }

    public /* synthetic */ void displayGuildRanks() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showGuildRanks(nPCConversationManager.E, MapleRanking.getInstance().getGuildRank()));
    }

    public /* synthetic */ void askBuffSelection(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.getPlayer().clearNpcSelect();
        nPCConversationManager.c.getPlayer().addNpcSelect(-999999999);
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getBuffSelection(a3.E, a2));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.askMapSelection;
    }

    public /* synthetic */ boolean hasSkill(int a22) {
        ISkill a22 = SkillFactory.getSkill(a22);
        if (a22 != null) {
            NPCConversationManager a3;
            return a3.c.getPlayer().getSkillLevel(a22) > 0;
        }
        return false;
    }

    public /* synthetic */ void sendNextS(String a2, byte a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.sendNextS(a2, a3, nPCConversationManager.E);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void CreateLog(String a) {
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var3_5 = var2_3.prepareStatement(InventoryException.ALLATORIxDEMO("(42?3.A3/..Z\r\u0015\u0006\tI\u001a\u0002\u0013\u0005\u001aMZ\u0001\u0014\u0000\u0017\u0004\u001aMZ\u0001\u0016\u000e\u001d\u0001SA, 64?2ZIEMEMEH"));
            var3_5.setInt(1, a.c.getPlayer().getId());
            v0.setString(2, a.c.getPlayer().getName());
            var3_5.setString(3, a);
            v0.executeUpdate();
            var3_5.close();
            ** if (var2_3 == null) goto lbl-1000
        }
        catch (Throwable var3_6) {
            if (var2_3 == null) ** GOTO lbl25
            try {
                var2_3.close();
                v1 = var3_6;
                ** GOTO lbl26
            }
            catch (Throwable a) {
                try {
                    var3_6.addSuppressed(a);
lbl25:
                    // 2 sources

                    v1 = var3_6;
lbl26:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var2_4) {
                    System.out.println("Error createlog" + var2_4);
                    FileoutputUtil.printError(MapleImp.ALLATORIxDEMO("\u0013M5^$Z\u001cP7\u0011$G$"), var2_4, InventoryException.ALLATORIxDEMO("?\u0013\b\u000e\b\"\b\u0004\u001b\u0015\u001f-\u0015\u0006Z\t\u001b\u0012Z2+-Z$\u0002\u0002\u001f\u0011\u000e\b\u0015\u000f"));
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var2_3.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    public /* synthetic */ void sendPlayerToNpc(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.sendNextS(a2, (byte)3, nPCConversationManager.E);
    }

    public /* synthetic */ void playSound(String a2) {
        NPCConversationManager a3;
        a3.playSound(false, a2);
    }

    public /* synthetic */ void showdonatemeso() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showDonateMesoRanks(nPCConversationManager.E, MapleRanking.getInstance().getDonateMesoRank()));
    }

    public final /* synthetic */ void addDojoPoints(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().setDojo(a3.c.getPlayer().getDojo() + a2);
    }

    public /* synthetic */ String EnchantCapMp(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        boolean bl2 = ItemConstants.\u985e\u578b.\u5e3d\u5b50((int)n2) && !bl;
        Object object = "";
        int n3 = 5000;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u5e47\u5b31\u9b2e\u52fa\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (bl2) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u5e3d\u5b50\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            a3 = (short)Randomizer.rand(a3, a4);
            Equip equip3 = equip2;
            short s2 = (short)(equip3.getMp() + a3);
            a4 = s2;
            equip3.setMp((short)(s2 > n3 ? (int)n3 : a4));
            object = (String)object + "\u9b54\u529b:  " + (short)a3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316MP[" + (n4 += a3) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u5e02\u5b00\u5508q\u50fa\u6759\u5e02\u5b00\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    @Override
    public /* synthetic */ void forceCompleteQuest(int a2) {
        NPCConversationManager a3;
        MapleQuest.getInstance(a2).forceComplete(a3.getPlayer(), a3.getNpc());
    }

    public /* synthetic */ void openMerchantItemStore() {
        NPCConversationManager a2;
        if (!World.isShutDown) {
            NPCConversationManager nPCConversationManager = a2;
            nPCConversationManager.c.getPlayer().setConversation(3);
            int n2 = 34;
            nPCConversationManager.c.sendPacket(PlayerShopPacket.merchItemStore((byte)n2));
            return;
        }
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.getPlayer().dropMessage(1, MapleImp.ALLATORIxDEMO("\u76be\u5272\u4e5d\u80c2\u4f2f\u7517\u7cee\u9777\u5516\u4e85\u9848\u53e9\u3052"));
        nPCConversationManager.c.sendPacket(MaplePacketCreator.enableActions());
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void \u6f5b\u80fd\u4ed8\u8cbb\u56db\u4e94\u96a8\u6a5f(byte a22, int a32, int a4) {
        NPCConversationManager a5;
        Equip a22 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(a22);
        switch (a32) {
            case 0: {
                a22.setPotential4(a4);
                break;
            }
            case 1: {
                a22.setPotential5(a4);
                break;
            }
            default: {
            }
        }
        ArrayList<ModifyInventory> a32 = new ArrayList<ModifyInventory>();
        a32.add(new ModifyInventory(3, a22));
        a32.add(new ModifyInventory(0, a22));
        a5.c.sendPacket(MaplePacketCreator.modifyInventory(true, a32));
    }

    public final /* synthetic */ void cameraZoom(int[] a2) {
        NPCConversationManager a3;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_CameraZoom.getValue(), null, a2);
    }

    public static /* synthetic */ {
        npcRequestController = new HashMap<Pair<Integer, MapleClient>, MapleNPC>();
    }

    public /* synthetic */ int getStarLevel(String a2) {
        return StringTool.appearNumber(a2, MapleImp.ALLATORIxDEMO("\u2655")) + StringTool.appearNumber(a2, InventoryException.ALLATORIxDEMO("\u2667"));
    }

    @Override
    public /* synthetic */ void forceStartQuest(int a2) {
        NPCConversationManager a3;
        MapleQuest.getInstance(a2).forceStart(a3.getPlayer(), a3.getNpc(), null);
    }

    public /* synthetic */ void sendRightPlayerNoESC(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.sendNextS(a2, (byte)7, nPCConversationManager.E);
    }

    public /* synthetic */ void askMenu(int a2, int a3, String a4) {
        NPCConversationManager a5;
        a5.askMenu(a2, -1, a3, a4);
    }

    public /* synthetic */ int getMeso() {
        NPCConversationManager a2;
        return a2.getPlayer().getMeso();
    }

    public /* synthetic */ void getNPCDirectionEffect(int a2, String a3, int a4, int a5, int a6) {
        NPCConversationManager a7;
        if (!npcRequestController.containsKey(new Pair<Integer, MapleClient>(a2, a7.c))) {
            return;
        }
        MapleNPC mapleNPC = npcRequestController.get(new Pair<Integer, MapleClient>(a2, a7.c));
        int[] arrn = new int[8];
        arrn[0] = a4;
        arrn[1] = a5;
        arrn[2] = a6;
        arrn[3] = 1;
        arrn[4] = 1;
        arrn[5] = 0;
        arrn[6] = mapleNPC.getObjectId();
        arrn[7] = 0;
        a7.c.sendPacket(UIPacket.getDirectionEffect(GameDirectionType.InGameDirectionEvent_EffectPlay, a3, arrn));
    }

    public /* synthetic */ void getDirectionFacialExpression(int a2, int a3) {
        NPCConversationManager a4;
        a4.c.sendPacket(MaplePacketCreator.showDirectionFacialExpression(a2, a3));
    }

    public /* synthetic */ void showdpm(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showdpmRanks(nPCConversationManager.E, MapleRanking.getInstance().getDpmRank(a2)));
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getEquipStarBlack(int a2) {
        String string = "";
        switch (a2) {
            case 1: {
                return MapleImp.ALLATORIxDEMO("\u2655");
            }
            case 2: {
                return InventoryException.ALLATORIxDEMO("\u267f\u2664");
            }
            case 3: {
                return MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655");
            }
            case 4: {
                return InventoryException.ALLATORIxDEMO("\u267f\u2664\u267f\u2664");
            }
            case 5: {
                return MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u263a\u2655");
            }
            case 6: {
                return InventoryException.ALLATORIxDEMO("\u267f\u2664\u267f\u2664\u267f\u2664");
            }
            case 7: {
                return MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u263a\u2655\u263a\u2655");
            }
        }
        return string;
    }

    public /* synthetic */ String EnchantCashfateMS(byte a2, int a3) {
        boolean bl;
        NPCConversationManager a4;
        Equip equip = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        Equip equip2 = (Equip)equip.copy();
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl2 = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        short s7 = 0;
        short s8 = 0;
        short s9 = 0;
        if (equip2.getOwner().equals(MapleImp.ALLATORIxDEMO("\u5da2\u967b\u9b04\f\u6b71"))) {
            return InventoryException.ALLATORIxDEMO("\u60c9\u963e\u9b35\u5d88\u9035I\u6b40V\u7140\u6caf\u7e1d\u7ef6\u9625\u9b2e@");
        }
        if (a3 == 1) {
            s2 = (short)Randomizer.rand(-4, 4);
            s3 = (short)Randomizer.rand(-4, 4);
            s4 = (short)Randomizer.rand(-4, 4);
            s5 = (short)Randomizer.rand(-4, 4);
            s8 = (short)Randomizer.rand(-4, 4);
            s9 = (short)Randomizer.rand(-4, 4);
            bl = bl2;
        } else if (a3 == 2) {
            s2 = (short)Randomizer.rand(3, 6);
            s3 = (short)Randomizer.rand(3, 6);
            s4 = (short)Randomizer.rand(3, 6);
            s5 = (short)Randomizer.rand(3, 6);
            s8 = (short)Randomizer.rand(3, 6);
            s9 = (short)Randomizer.rand(3, 6);
            bl = bl2;
        } else {
            if (a3 == 3) {
                s2 = (short)10;
                s3 = (short)10;
                s4 = 10;
                s5 = 10;
                s8 = 10;
                s9 = 10;
            }
            bl = bl2;
        }
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + s2 > 0 ? equip2.getStr() + s2 : 0));
            object = (String)object + "\u529b\u91cf + " + s2 + "\r\n";
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + s3 > 0 ? equip2.getDex() + s3 : 0));
            object = (String)object + "\u654f\u6377:  " + s3 + "\r\n";
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + s4 > 0 ? equip2.getInt() + s4 : 0));
            object = (String)object + "\u667a\u529b:  " + s4 + "\r\n";
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + s5 > 0 ? equip2.getLuk() + s5 : 0));
            object = (String)object + "\u5e78\u904b:  " + s5 + "\r\n";
            Equip equip7 = equip2;
            equip7.setHp((short)(equip7.getHp() + s6 > 0 ? equip2.getHp() + s6 : 0));
            object = (String)object + "HP:  " + s6 + "\r\n";
            Equip equip8 = equip2;
            equip8.setMp((short)(equip8.getMp() + s7 > 0 ? equip2.getMp() + s7 : 0));
            object = (String)object + "MP:  " + s7 + "\r\n";
            Equip equip9 = equip2;
            equip9.setWatk((short)(equip9.getWatk() + s8 > 0 ? equip2.getWatk() + s8 : 0));
            object = (String)object + "\u7269\u7406\u653b\u64ca:  " + s8 + "\r\n";
            Equip equip10 = equip2;
            equip10.setMatk((short)(equip10.getMatk() + s9 > 0 ? equip2.getMatk() + s9 : 0));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + s9 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip11 = equip2;
            a3 = StringTool.getIntFromString(equip11.getOwner());
            equip11.setOwner("\u5df2\u9644\u9b54" + ++a3 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), equip, false);
            a4.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
    }

    public /* synthetic */ void equip(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().equip(a2);
    }

    public /* synthetic */ String EnchantCashEqip(byte a2) {
        NPCConversationManager a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            n2 = (short)Randomizer.rand(50, 55);
            Equip equip3 = equip2;
            int n3 = n2;
            equip3.setStr((short)(equip3.getStr() + n3));
            object = (String)object + "\u529b\u91cf + " + (short)n3 + "\r\n";
            n2 = (short)Randomizer.rand(50, 55);
            Equip equip4 = equip2;
            int n4 = n2;
            equip4.setDex((short)(equip4.getDex() + n4));
            object = (String)object + "\u654f\u6377:  " + (short)n4 + "\r\n";
            n2 = (short)Randomizer.rand(50, 55);
            Equip equip5 = equip2;
            int n5 = n2;
            equip5.setInt((short)(equip5.getInt() + n5));
            object = (String)object + "\u667a\u529b:  " + (short)n5 + "\r\n";
            n2 = (short)Randomizer.rand(50, 55);
            Equip equip6 = equip2;
            int n6 = n2;
            equip6.setLuk((short)(equip6.getLuk() + n6));
            object = (String)object + "\u5e78\u904b:  " + (short)n6 + "\r\n";
            n2 = (short)Randomizer.rand(30, 35);
            Equip equip7 = equip2;
            int n7 = n2;
            equip7.setWatk((short)(equip7.getWatk() + n7));
            object = (String)object + "\u7269\u7406\u653b\u64ca:  " + (short)n7 + "\r\n";
            n2 = (short)Randomizer.rand(30, 35);
            Equip equip8 = equip2;
            int n8 = n2;
            equip8.setMatk((short)(equip8.getMatk() + n8));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + (short)n8 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u8acb\u554f\u60a8\u662f\u5426\u8981\u7e7c\u7e8c\u9644\u9b54?\r\n#d[\u9ede\u9078#r\u662f#d,\u7e7c\u7e8c\u9644\u9b54] [\u9ede\u9078#r\u5426#d,\u5b58\u53d6\u76ee\u524d\u9644\u9b54]\r\n#d\u82e5\u88dd\u5099\u7d20\u8cea\u672a\u6539\u8b8a,\u8acb\u91cd\u65b0\u767b\u5165\u6216\u63db\u983b\u5373\u53ef\u751f\u6548!";
            Equip equip9 = equip2;
            n2 = StringTool.getIntFromString(equip9.getOwner());
            equip9.setOwner("\u5df2\u9644\u9b54" + ++n2 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object;
        }
        return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
    }

    public /* synthetic */ long getBlackJackTotalWin() {
        return BlackJack.getInstance().getTotalWin();
    }

    public final /* synthetic */ void cameraMove(int[] a2) {
        NPCConversationManager a3;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_CameraMove.getValue(), null, a2);
    }

    public /* synthetic */ void playerWaite() {
        NPCConversationManager a2;
        int[] arrn = new int[1];
        arrn[0] = 0;
        a2.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedInput.getValue(), null, arrn);
    }

    public /* synthetic */ void setHair(int a2) {
        if (NPCConversationManager.hairExists(a2)) {
            NPCConversationManager a3;
            NPCConversationManager nPCConversationManager = a3;
            nPCConversationManager.getPlayer().setHair(a2);
            nPCConversationManager.getPlayer().updateSingleStat(MapleStat.HAIR, a2);
            nPCConversationManager.getPlayer().equipChanged();
        }
    }

    public /* synthetic */ int[] getCanHair(int[] a2) {
        NPCConversationManager a3;
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n3 = ((int[])a2).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = a2[n2];
            if (NPCConversationManager.hairExists(n5) || n5 < 20) {
                arrayList.add(n5);
            } else {
                arrayList2.add(n5);
            }
            n4 = ++n2;
        }
        if (arrayList2.size() > 0 && a3.c.getPlayer().isAdmin()) {
            StringBuilder stringBuilder = new StringBuilder(InventoryException.ALLATORIxDEMO("\u6b02\u5752\u8be1\u53ac\u76e5\u9a94\u57ea\u91b6\u6768"));
            a2 = stringBuilder;
            stringBuilder.append(arrayList2.size()).append(MapleImp.ALLATORIxDEMO("\u505b\u9ad1\u57db\u7517\u6266\u7ad0\u4e5d\u6510\u63a4\u9850\u796a\u8af4\u568e\u580e\u0017r\uff5c\u5dcd\u7dc3\u8894\u6e55\u965b\uff4a"));
            n3 = 0;
            int n6 = n3;
            while (n6 < arrayList2.size()) {
                int n7 = n3;
                ((StringBuilder)a2).append(arrayList2.get(n7));
                if (n7 < arrayList2.size() - 1) {
                    ((StringBuilder)a2).append(InventoryException.ALLATORIxDEMO("M"));
                }
                n6 = ++n3;
            }
            a3.playerMessage(((StringBuilder)a2).toString());
        }
        a2 = new int[arrayList.size()];
        int n8 = n3 = 0;
        while (n8 < arrayList.size()) {
            int n9 = n3++;
            a2[n9] = (Integer)arrayList.get(n9);
            n8 = n3;
        }
        return a2;
    }

    public /* synthetic */ void sendFriendWindow() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        int n2 = nPCConversationManager.c.getPlayer().getFriendShipToAdd();
        nPCConversationManager.c.sendPacket(MaplePacketCreator.sendFriendWindow(n2));
    }

    public /* synthetic */ void sendAcceptDecline(String a2) {
        NPCConversationManager a3;
        a3.askAcceptDecline(a2);
    }

    public /* synthetic */ void sendNextS(String a2, byte a3, int a4) {
        NPCConversationManager a5;
        if (a5.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a5.sendSimpleS(a2, a3);
            return;
        }
        a5.c.sendPacket(MaplePacketCreator.getNPCTalk(a4, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000fp\u000fa"), a3, a4));
        a5.a = 0;
    }

    public /* synthetic */ void maxStats() {
        NPCConversationManager a2;
        int n2 = GameSetConstants.MAPLE_VERSION >= 134 ? 99999 : 30000;
        ArrayList<Pair<MapleStat, Integer>> arrayList = new ArrayList<Pair<MapleStat, Integer>>(2);
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.getPlayer().getStat().setStr((short)32767);
        nPCConversationManager.c.getPlayer().getStat().setDex((short)32767);
        nPCConversationManager.c.getPlayer().getStat().setInt((short)32767);
        nPCConversationManager.c.getPlayer().getStat().setLuk((short)32767);
        nPCConversationManager.c.getPlayer().getStat().setMaxHp(n2);
        nPCConversationManager.c.getPlayer().getStat().setMaxMp(n2);
        nPCConversationManager.c.getPlayer().getStat().setHp(n2);
        a2.c.getPlayer().getStat().setMp(n2);
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.STR, 32767));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.DEX, 32767));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.LUK, 32767));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.INT, 32767));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.HP, n2));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MAXHP, n2));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MP, n2));
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MAXMP, n2));
        a2.c.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, a2.c.getPlayer()));
    }

    public /* synthetic */ void ItemMessage(int a22, String a3) {
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (mapleItemInformationProvider.itemExists(a22)) {
            NPCConversationManager a4;
            Equip a22 = (Equip)mapleItemInformationProvider.getEquipById(a22);
            World.Broadcast.broadcastSmega(a4.c.getWorld(), MaplePacketCreator.itemMegaphone(a3, true, a4.c.getChannel(), a22));
        }
    }

    public /* synthetic */ void inputUI(int a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_InputUI.getValue(), null, arrn);
    }

    public /* synthetic */ void setLock(Object a2) {
        if (a2 instanceof Equip) {
            if (((Item)(a2 = (Equip)a2)).getExpiration() == -1L) {
                Object object = a2;
                ((Item)object).setFlag(((Item)object).getFlag() | ItemFlag.LOCK.getValue());
                return;
            }
            Object object = a2;
            ((Item)object).setFlag(((Item)object).getFlag() | ItemFlag.UNTRADEABLE.getValue());
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void giveMerchantMesos() {
        block11: {
            var1_1 = 0L;
            var3_2 = DBConPool.getInstance().getDataSource().getConnection();
            var4_4 = var3_2.prepareStatement(MapleImp.ALLATORIxDEMO("\u0003z\u001cz\u0013kpR5L?Lpy\u0002p\u001d\u001f8V\"Z4R5M3W1Q$Lph\u0018z\u0002zpR5M3W1Q$V4\u001fm\u001fo"));
            var4_4.setInt(1, a.getPlayer().getId());
            var5_6 = var4_4.executeQuery();
            if (var5_6.next()) break block11;
            v0 = var5_6;
            v1 = v0;
            v0.close();
            var4_4.close();
            ** GOTO lbl20
        }
        v2 = var5_6;
        v1 = v2;
        var1_1 = v2.getLong(InventoryException.ALLATORIxDEMO("\f\u001f\u0012\u0015\u0012"));
lbl20:
        // 2 sources

        v1.close();
        var4_4.close();
        var4_4 = var3_2.prepareStatement(MapleImp.ALLATORIxDEMO("j\u0000{\u0011k\u0015\u001f8V\"Z4R5M3W1Q$Lpl\u0015kpR5L?Lp\u0002p\u000fph\u0018z\u0002zpR5M3W1Q$V4\u001fm\u001fo"));
        var4_4.setInt(1, a.getPlayer().getId());
        var4_4.executeUpdate();
        var4_4.close();
        ** if (var3_2 == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            var3_2.close();
        }
lbl-1000:
        // 2 sources

        {
        }
        {
            catch (Throwable var4_5) {
                try {
                    block12: {
                        if (var3_2 != null) {
                            try {
                                var3_2.close();
                                v3 = var4_5;
                                break block12;
                            }
                            catch (Throwable var5_7) {
                                var4_5.addSuppressed(var5_7);
                            }
                        }
                        v3 = var4_5;
                    }
                    throw v3;
                }
                catch (SQLException var3_3) {
                    System.err.println("Error gaining mesos in hired merchant" + var3_3);
                }
            }
        }
        a.c.getPlayer().gainMeso((int)var1_1, true);
    }

    public /* synthetic */ void sendAndroidStyle(String a2, int[] a3) {
        NPCConversationManager nPCConversationManager;
        int n2;
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        a4.c.getPlayer().clearNpcSelect();
        int n3 = 0;
        int[] arrn = a3;
        int n4 = a3.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            int n6 = arrn[n2];
            a4.c.getPlayer().addNpcSelect(n3);
            n5 = ++n2;
            ++n3;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            NPCConversationManager nPCConversationManager2 = a4;
            nPCConversationManager = nPCConversationManager2;
            a4.c.sendPacket(MaplePacketCreator.getNPCTalkStyle(nPCConversationManager2.E, a2, true, a4.getCanHair(a3)));
        } else {
            NPCConversationManager nPCConversationManager3 = a4;
            nPCConversationManager = nPCConversationManager3;
            nPCConversationManager3.c.sendPacket(MaplePacketCreator.getNPCTalkStyle(nPCConversationManager3.E, a2, a3));
        }
        nPCConversationManager.a = (byte)10;
    }

    public /* synthetic */ String ShowGMItemRank(int a2) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MapleRanking.ItemRankingInfo> list = MapleRanking.getInstance().getItemRank(a2);
        if (list != null) {
            int n2 = 0;
            Object object = list = list.iterator();
            while (object.hasNext()) {
                ++n2;
                MapleRanking.ItemRankingInfo itemRankingInfo = (MapleRanking.ItemRankingInfo)list.next();
                StringBuilder stringBuilder2 = stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z\u001c>\u001c5\u001c;\u7396\u5be6\u5432\u7a61\u0005s[p"));
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder.append(StringUtil.getRightPaddedStr(itemRankingInfo.getName(), ' ', 8));
                stringBuilder3.append(InventoryException.ALLATORIxDEMO("Y\u000fY\u0004Y\n\u7b33\u7d7b@B\u001fB\bA"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(itemRankingInfo.getLevel()), ' ', 3));
                stringBuilder3.append("#n#e#k" + MapleItemInformationProvider.getInstance().getName(a2) + "\u6578\u91cf:#e#d ");
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(itemRankingInfo.getQuantity()), ' ', 4));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z"));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("Y\u000fY\nG\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\"));
                object = list;
            }
        } else {
            stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001c\"\u67da\u8a32\u711e\u4eab\u4f6a\u7d00\u67a3\u5567"));
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ GashaponSpecial getGashaponSpecial() {
        return GashaponSpecial.getInstance();
    }

    public /* synthetic */ String getQuestCustomData() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getQuestNAdd(MapleQuest.getInstance(a2.g)).getCustomData();
    }

    public /* synthetic */ String EnchantCashEqipMinus(byte a2, int a3, int a42222, int a5) {
        NPCConversationManager a6;
        Equip equip;
        Equip equip2 = equip = (Equip)a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int s2 = a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        short s3 = MapleItemInformationProvider.getInstance().isCash(s2);
        Object object = "";
        if (s3 != 0) {
            Object object2;
            if (!a6.c.getPlayer().haveItem(a42222, a5)) {
                return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a42222 + "# " + a5 + "\u500b!";
            }
            a6.c.getPlayer().gainItem(a42222, -a5);
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + s2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            LinkedList a42222 = new LinkedList();
            if (a3 == 1) {
                a3 = 8;
                Equip equip3 = equip2;
                equip3.setStr((short)(equip3.getStr() + a3 > 0 ? equip2.getStr() + a3 : 0));
                object = (String)object + "\u529b\u91cf + " + (short)a3 + "\r\n";
                short a42222 = 8;
                Equip equip4 = equip2;
                equip4.setDex((short)(equip4.getDex() + a42222 > 0 ? equip2.getDex() + a42222 : 0));
                object = (String)object + "\u654f\u6377:  " + a42222 + "\r\n";
                a5 = 8;
                Equip equip5 = equip2;
                equip5.setInt((short)(equip5.getInt() + a5 > 0 ? equip2.getInt() + a5 : 0));
                object = (String)object + "\u667a\u529b:  " + (short)a5 + "\r\n";
                short s4 = 8;
                Equip equip6 = equip2;
                equip6.setLuk((short)(equip6.getLuk() + s4 > 0 ? equip2.getLuk() + s4 : 0));
                object = (String)object + "\u5e78\u904b:  " + s4 + "\r\n";
                s3 = 8;
                Equip equip7 = equip2;
                equip7.setWatk((short)(equip7.getWatk() + s3 > 0 ? equip2.getWatk() + s3 : 0));
                object = (String)object + "\u7269\u7406\u653b\u64ca:  " + s3 + "\r\n";
                short s5 = 8;
                Equip equip8 = equip2;
                equip8.setMatk((short)(equip8.getMatk() + s5 > 0 ? equip2.getMatk() + s5 : 0));
                object2 = object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + s5 + "\r\n";
            } else {
                a3 = (short)Randomizer.rand(1, 4);
                Equip equip9 = equip2;
                equip9.setStr((short)(equip9.getStr() + a3 > 0 ? equip2.getStr() + a3 : 0));
                object = (String)object + "\u529b\u91cf + " + (short)a3 + "\r\n";
                short a42222 = (short)Randomizer.rand(1, 4);
                Equip equip10 = equip2;
                equip10.setDex((short)(equip10.getDex() + a42222 > 0 ? equip2.getDex() + a42222 : 0));
                object = (String)object + "\u654f\u6377 +  " + a42222 + "\r\n";
                a5 = (short)Randomizer.rand(1, 4);
                Equip equip11 = equip2;
                equip11.setInt((short)(equip11.getInt() + a5 > 0 ? equip2.getInt() + a5 : 0));
                object = (String)object + "\u667a\u529b +  " + (short)a5 + "\r\n";
                short s6 = (short)Randomizer.rand(1, 4);
                Equip equip12 = equip2;
                equip12.setLuk((short)(equip12.getLuk() + s6 > 0 ? equip2.getLuk() + s6 : 0));
                object = (String)object + "\u5e78\u904b +  " + s6 + "\r\n";
                s3 = (short)Randomizer.rand(1, 4);
                Equip equip13 = equip2;
                equip13.setWatk((short)(equip13.getWatk() + s3 > 0 ? equip2.getWatk() + s3 : 0));
                object = (String)object + "\u7269\u7406\u653b\u64ca +  " + s3 + "\r\n";
                short s7 = (short)Randomizer.rand(1, 4);
                Equip equip14 = equip2;
                equip14.setMatk((short)(equip14.getMatk() + s7 > 0 ? equip2.getMatk() + s7 : 0));
                object2 = object = (String)object + "\u9b54\u6cd5\u653b\u64ca +  " + s7 + "\r\n";
            }
            object = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip15 = equip2;
            a3 = StringTool.getIntFromString(equip15.getOwner());
            equip15.setOwner("\u5df2\u9644\u9b54" + ++a3 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a6.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a6.getClient(), equip, false);
            a6.c.getPlayer().equipChanged();
            return object;
        }
        return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
    }

    public /* synthetic */ int getMode() {
        NPCConversationManager a2;
        return a2.B;
    }

    public /* synthetic */ int getPrice(String a2) {
        return Cryptocurrency.getPrice(a2);
    }

    public /* synthetic */ String CharInfo(String a2) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((a2 = World.Find.findChr((String)a2)) == null) {
            return MapleImp.ALLATORIxDEMO("\u8982\u824d\u677a\u4e35\u7d8a");
        }
        stringBuilder.append(InventoryException.ALLATORIxDEMO("Y\u0004")).append(MapleClient.getLogMessage((MapleCharacter)a2, ""));
        stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001f]5p\u5717p")).append(a2.getPosition().x);
        stringBuilder.append(InventoryException.ALLATORIxDEMO("AUA")).append(a2.getPosition().y);
        stringBuilder.append(MapleImp.ALLATORIxDEMO("p2Z\u001f\u8810\u91f0p\u0005p")).append(((MapleCharacter)a2).getStat().getHp()).append(InventoryException.ALLATORIxDEMO("ZN")).append(((MapleCharacter)a2).getStat().getCurrentMaxHp());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("pC,\u001f\u9b04\u91f0p\u0005p")).append(((MapleCharacter)a2).getStat().getMp()).append(InventoryException.ALLATORIxDEMO("ZN")).append(((MapleCharacter)a2).getStat().getCurrentMaxMp());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001f]5p\u7256\u7456\u6504\u649a\u52a4p\u0005p")).append(((MapleCharacter)a2).getStat().getTotalWatk());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("Z\u001d\u0006A\u9b2e\u6cb4\u6541\u64ab\u52e1A@A")).append(((MapleCharacter)a2).getStat().getTotalMagic());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("p2Z\u001f\u6750\u9ae7\u656b\u64f5p\u0005p")).append(((MapleCharacter)a2).getStat().getCurrentMaxBaseDamage());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("A\u0006\u001dZ\u655a\u64b0D\u6502A@A")).append(a2.getStat().dam_r);
        stringBuilder.append(MapleImp.ALLATORIxDEMO("p2Z\u001f\u0012p\u0003l\u656b\u64f5u\u6547p\u0005p")).append(a2.getStat().bossdam_r);
        stringBuilder.append(InventoryException.ALLATORIxDEMO("AwkZ\u52fa\u91b5A@A")).append(((MapleCharacter)a2).getStat().getStr());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("pC,\u001f\u651f\u6348p\u0005p")).append(((MapleCharacter)a2).getStat().getDex());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("A\u0006\u001dZ\u661b\u52e1A@A")).append(((MapleCharacter)a2).getStat().getInt());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("pC,\u001f\u5e28\u9074p\u0005p")).append(((MapleCharacter)a2).getStat().getLuk());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("AwkZB\b\u52fa\u91b5A@A")).append(((MapleCharacter)a2).getStat().getTotalStr());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("pC,\u001fsM\u651f\u6348p\u0005p")).append(((MapleCharacter)a2).getStat().getTotalDex());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("A\u0006\u001dZB\b\u661b\u52e1A@A")).append(((MapleCharacter)a2).getStat().getTotalInt());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("pC,\u001fsM\u5e28\u9074p\u0005p")).append(((MapleCharacter)a2).getStat().getTotalLuk());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("ZlpAY\n\u7de9\u9a36\u5046A@A")).append(((MapleCharacter)a2).getExp());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("pC,\u001f\u7d14\u96b5\u7290\u6174p\u0005p")).append(((MapleCharacter)a2).getParty() != null);
        stringBuilder.append(InventoryException.ALLATORIxDEMO("ZlpA\u4ede\u6672\u72ba\u612a@A")).append(((MapleCharacter)a2).getTrade() != null);
        stringBuilder.append(MapleImp.ALLATORIxDEMO("p2Z\u001f\u001c^$Z>\\)\u0005p")).append(((MapleCharacter)a2).getClient().getLatency());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("ZlpA\u677a\u5fed*(4&@A")).append(((MapleCharacter)a2).getClient().getLastPing());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001f]5p\u673f\u5fdco\u001fq\u0017\u0005p")).append(((MapleCharacter)a2).getClient().getLastPong());
        stringBuilder.append(InventoryException.ALLATORIxDEMO("ZlpA31@A")).append(((MapleCharacter)a2).getClient().getSessionIPAddress());
        stringBuilder.append(MapleImp.ALLATORIxDEMO("p2Z\u001f\"Z=P$Z\u0011[4M5L#\u0005p"));
        ((MapleCharacter)a2).getClient().DebugMessage(stringBuilder);
        return stringBuilder.toString();
    }

    public /* synthetic */ void askAcceptDecline(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, MaplePacketOperation.NPCStatus.askAcceptDecline, a2, "", (byte)0));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.askAcceptDecline;
    }

    @Override
    public /* synthetic */ void dispose() {
        NPCConversationManager a2;
        NPCScriptManager.getInstance().dispose(a2.c);
    }

    public /* synthetic */ void forcedMove(int a2, int a3) {
        NPCConversationManager a4;
        int[] arrn = new int[2];
        arrn[0] = a2;
        arrn[1] = a3;
        a4.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedMove.getValue(), null, arrn);
    }

    public /* synthetic */ void getEventEffect(String a2, int[] a3) {
        NPCConversationManager a4;
        a4.getDirectionEffect(GameDirectionType.InGameDirectionEvent_EffectPlay.getValue(), a2, a3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String CashEquipStar3(byte a2, int a3, int a4, int a5) {
        int n2;
        NPCConversationManager a6;
        Equip equip;
        Equip equip2 = equip = (Equip)a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n3 = a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n3 = MapleItemInformationProvider.getInstance().isCash(n3) ? (byte)1 : 0;
        Object object = "";
        if (n3 == 0) return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bcV\u7140\u6caf\u5326\u7d60\u3063");
        n3 = a6.getEquipLevelBlack(equip2.getOwner());
        if (n3 >= 7) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (!a6.c.getPlayer().haveItem(a4)) {
            return "#r\u5347\u7d1a\u9700\u8981#i" + a4 + "# 1 \u500b!";
        }
        a6.c.getPlayer().gainItem(a4, -1);
        a4 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        boolean bl = false;
        bl = false;
        bl = false;
        bl = false;
        bl = false;
        bl = false;
        bl = false;
        bl = false;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int n9 = n2 = 0;
        while (n9 < a5) {
            int n10 = Randomizer.rand(1, 6);
            while (linkedList.contains(n10 = Randomizer.rand(1, 6))) {
            }
            int n11 = n10;
            linkedList.add(n11);
            switch (n11) {
                case 1: {
                    a4 = Randomizer.rand(1, 4);
                    break;
                }
                case 2: {
                    n4 = Randomizer.rand(1, 4);
                    break;
                }
                case 3: {
                    n5 = Randomizer.rand(1, 4);
                    break;
                }
                case 4: {
                    n6 = Randomizer.rand(1, 4);
                    break;
                }
                case 5: {
                    n7 = Randomizer.rand(1, 2);
                    break;
                }
                case 6: {
                    n8 = Randomizer.rand(1, 2);
                    break;
                }
            }
            n9 = ++n2;
        }
        if (Randomizer.rand(0, 100) >= a3) {
            return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + a3 + "%),\u6c92\u6709\u767c\u751f\u4efb\u4f55\u6539\u8b8a!";
        }
        if (a4 > 0) {
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + a4));
        }
        if (n4 > 0) {
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + n4));
        }
        if (n5 > 0) {
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + n5));
        }
        if (n6 > 0) {
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + n6));
        }
        if (n7 > 0) {
            Equip equip7 = equip2;
            equip7.setWatk((short)(equip7.getWatk() + n7));
        }
        if (n8 > 0) {
            Equip equip8 = equip2;
            equip8.setMatk((short)(equip8.getMatk() + n8));
        }
        Equip equip9 = equip2;
        equip9.setOwner(a6.getEquipStarBlack(n3 + 1));
        equip = (Equip)equip9.copy();
        MapleInventoryManipulator.removeFromSlot(a6.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a6.getClient(), equip, false);
        a6.c.getPlayer().equipChanged();
        object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + a3 + "%)\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a6.getEquipStar(n3 + 1) + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u529b\u91cf:#r" + a4 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u654f\u6377:#r" + n4 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u667a\u529b:#r" + n5 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u5e78\u904b:#r" + n6 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
        FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a6.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + equip.getItemName() + "(" + equip.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
        return object;
    }

    public /* synthetic */ void displayGuildMesoRanks() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showGuildRanks(nPCConversationManager.E, MapleRanking.getInstance().getGuildMesoRank()));
    }

    public final /* synthetic */ void setQuestRecord(Object a2, int a3, String a4) {
        ((MapleCharacter)a2).getQuestNAdd(MapleQuest.getInstance(a3)).setCustomData(a4);
    }

    public /* synthetic */ void playWorldSound(String a2) {
        World.Broadcast.broadcastMessage(MaplePacketCreator.playSound(a2));
    }

    public /* synthetic */ void spawnNPCRequestController(int a2, int a3, int a4, int a5) {
        NPCConversationManager a6;
        a6.spawnNPCRequestController(a2, a3, a4, a5, a2);
    }

    public /* synthetic */ void playMovie(String a2) {
        NPCConversationManager a3;
        a3.playMovie(a2, true);
    }

    public /* synthetic */ void playerJump() {
        NPCConversationManager a2;
        int[] arrn = new int[1];
        arrn[0] = 3;
        a2.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedInput.getValue(), null, arrn);
    }

    public /* synthetic */ void sendSimple(String a2, String ... a3) {
        NPCConversationManager a4;
        int n2;
        if (a3.length > 0) {
            a2 = (String)a2 + "#b\r\n";
        }
        int n3 = n2 = 0;
        while (n3 < a3.length) {
            int n4 = n2++;
            a2 = (String)a2 + "#L" + n4 + "#" + a3[n4] + "#l\r\n";
            n3 = n2;
        }
        a4.sendSimple((String)a2);
    }

    public final /* synthetic */ void setLastMsg(byte a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ void playMovie(String a2, boolean a3) {
        NPCConversationManager a4;
        super.playMovie(a2, a3);
        a4.a = MaplePacketOperation.NPCStatus.DirectionEffect;
    }

    public /* synthetic */ String getReadableMillis(long a2, long a3) {
        return StringUtil.getReadableMillis(a2, a3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantCashEqipRabbit(byte a2, int a3, int a42, int a5) {
        Object object;
        int n2;
        Equip equip;
        NPCConversationManager a6;
        Equip equip2;
        block22: {
            int n3;
            LinkedList<Integer> a42;
            int n4;
            block25: {
                int n5;
                block24: {
                    block23: {
                        equip = equip2 = (Equip)a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
                        n4 = a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
                        n2 = MapleItemInformationProvider.getInstance().isCash(n4);
                        object = "";
                        if (n2 == 0) return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
                        if (!a6.c.getPlayer().haveItem(a42, a5)) {
                            return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a42 + "# " + a5 + "\u500b!";
                        }
                        if (StringTool.getIntFromString(equip.getOwner()) >= 3) {
                            return MapleImp.ALLATORIxDEMO("\u6750\u5925\u53ba\u80c2\u880d\u4e36\u6b71");
                        }
                        a6.c.getPlayer().gainItem(a42, -a5);
                        object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n4 + "##k\r\n";
                        object = (String)object + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
                        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
                        a42 = new LinkedList<Integer>();
                        a5 = -1;
                        n4 = 2;
                        if (a3 != 1 && a3 != 2 && a3 != 3) break block22;
                        if (a3 != 1 && a3 != 2) break block23;
                        if (a3 == 2) {
                            a5 = 2;
                            n4 = 4;
                        }
                        n5 = n2 = 0;
                        break block24;
                    }
                    if (a3 != 3) break block22;
                    a5 = 4;
                    n4 = 6;
                    n3 = n2 = 0;
                    break block25;
                }
                while (n5 < 4) {
                    int n6 = Randomizer.rand(1, 6);
                    while (a42.contains(n6 = Randomizer.rand(1, 6))) {
                    }
                    int n7 = n6;
                    a42.add(n7);
                    switch (n7) {
                        case 1: {
                            short s2 = (short)Randomizer.rand(a5, n4);
                            Equip equip3 = equip;
                            equip3.setStr((short)(equip3.getStr() + s2 > 0 ? equip.getStr() + s2 : 0));
                            object = (String)object + "\u529b\u91cf + " + s2 + "\r\n";
                            break;
                        }
                        case 2: {
                            short s3 = (short)Randomizer.rand(a5, n4);
                            Equip equip4 = equip;
                            equip4.setDex((short)(equip4.getDex() + s3 > 0 ? equip.getDex() + s3 : 0));
                            object = (String)object + "\u654f\u6377 +  " + s3 + "\r\n";
                            break;
                        }
                        case 3: {
                            short s4 = (short)Randomizer.rand(a5, n4);
                            Equip equip5 = equip;
                            equip5.setInt((short)(equip5.getInt() + s4 > 0 ? equip.getInt() + s4 : 0));
                            object = (String)object + "\u667a\u529b +  " + s4 + "\r\n";
                            break;
                        }
                        case 4: {
                            short s5 = (short)Randomizer.rand(a5, n4);
                            Equip equip6 = equip;
                            equip6.setLuk((short)(equip6.getLuk() + s5 > 0 ? equip.getLuk() + s5 : 0));
                            object = (String)object + "\u5e78\u904b +  " + s5 + "\r\n";
                            break;
                        }
                        case 5: {
                            short s6 = (short)Randomizer.rand(a5, n4);
                            Equip equip7 = equip;
                            equip7.setWatk((short)(equip7.getWatk() + s6 > 0 ? equip.getWatk() + s6 : 0));
                            object = (String)object + "\u7269\u7406\u653b\u64ca +  " + s6 + "\r\n";
                            break;
                        }
                        case 6: {
                            short s7 = (short)Randomizer.rand(a5, n4);
                            Equip equip8 = equip;
                            equip8.setMatk((short)(equip8.getMatk() + s7 > 0 ? equip.getMatk() + s7 : 0));
                            object = (String)object + "\u9b54\u6cd5\u653b\u64ca +  " + s7 + "\r\n";
                            break;
                        }
                    }
                    n5 = ++n2;
                }
                break block22;
            }
            while (n3 < 3) {
                int n8 = Randomizer.rand(1, 6);
                while (a42.contains(n8 = Randomizer.rand(1, 5))) {
                }
                int n9 = n8;
                a42.add(n9);
                switch (n9) {
                    case 1: {
                        short s8 = (short)Randomizer.rand(a5, n4);
                        Equip equip9 = equip;
                        equip9.setStr((short)(equip9.getStr() + s8 > 0 ? equip.getStr() + s8 : 0));
                        object = (String)object + "\u529b\u91cf + " + s8 + "\r\n";
                        break;
                    }
                    case 2: {
                        short s9 = (short)Randomizer.rand(a5, n4);
                        Equip equip10 = equip;
                        equip10.setDex((short)(equip10.getDex() + s9 > 0 ? equip.getDex() + s9 : 0));
                        object = (String)object + "\u654f\u6377 +  " + s9 + "\r\n";
                        break;
                    }
                    case 3: {
                        short s10 = (short)Randomizer.rand(a5, n4);
                        Equip equip11 = equip;
                        equip11.setInt((short)(equip11.getInt() + s10 > 0 ? equip.getInt() + s10 : 0));
                        object = (String)object + "\u667a\u529b +  " + s10 + "\r\n";
                        break;
                    }
                    case 4: {
                        short s11 = (short)Randomizer.rand(a5, n4);
                        Equip equip12 = equip;
                        equip12.setLuk((short)(equip12.getLuk() + s11 > 0 ? equip.getLuk() + s11 : 0));
                        object = (String)object + "\u5e78\u904b +  " + s11 + "\r\n";
                        break;
                    }
                    case 5: {
                        short s12 = (short)Randomizer.rand(a5, n4);
                        Equip equip13 = equip;
                        equip13.setMatk((short)(equip13.getMatk() + s12 > 0 ? equip.getMatk() + s12 : 0));
                        object = (String)object + "\u9b54\u6cd5\u653b\u64ca +  " + s12 + "\r\n";
                        break;
                    }
                }
                n3 = ++n2;
            }
            n2 = 6;
            Equip equip14 = equip;
            equip14.setWatk((short)(equip14.getWatk() + n2 > 0 ? equip.getWatk() + n2 : 0));
            object = (String)object + "\u7269\u7406\u653b\u64ca +  " + (short)n2 + "\r\n";
        }
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        Equip equip15 = equip;
        n2 = StringTool.getIntFromString(equip15.getOwner());
        equip15.setOwner("\u5df2\u9644\u9b54" + ++n2 + "\u6b21");
        equip2 = (Equip)equip.copy();
        MapleInventoryManipulator.removeFromSlot(a6.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a6.getClient(), equip2, false);
        a6.c.getPlayer().equipChanged();
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String SmileCashEquipStar(byte a2, int a3, int a4) {
        Equip equip;
        NPCConversationManager a5;
        Equip equip2;
        Equip equip3 = equip2 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n2 = MapleItemInformationProvider.getInstance().isCash(n2) ? (byte)1 : 0;
        Object object = "";
        if (n2 == 0) return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u0013\u7171\u6cea\u5317\u7d25\u3052");
        if (!(equip3.getStr() == 0 && equip3.getDex() == 0 && equip3.getInt() == 0 && equip3.getLuk() == 0 && equip3.getHp() == 0 && equip3.getMp() == 0 && equip3.getWatk() == 0 && equip3.getMatk() == 0 && equip3.getWdef() == 0 && equip3.getMdef() == 0 && equip3.getAcc() == 0 && equip3.getSpeed() == 0 && equip3.getJump() == 0 || equip3.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2655")) || equip3.getOwner().contains(InventoryException.ALLATORIxDEMO("\u2667")))) {
            return MapleImp.ALLATORIxDEMO("\u001c\"\u6b5b\u888d\u50a6\u5da2\u6736\u7229\u6bb5\u80ad\u52a4.\u56df\u6b34\u711e\u6c85\u5378\u7d4a\u54d9q");
        }
        n2 = a5.getEquipLevel(equip3.getOwner());
        if (n2 >= 5) {
            return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u5d88\u9035\u524a\u6761\u9aa2\u667e\u6502\u001f\u715b\u6cb4\u7e06\u7eed\u533d\u7d7b\u56b3@");
        }
        if (!a5.c.getPlayer().haveItem(a4)) {
            return "#r\u5347\u7d1a\u9700\u8981#i" + a4 + "# 1 \u500b!";
        }
        a5.c.getPlayer().gainItem(a4, -1);
        a4 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = Randomizer.rand(1, 14);
        if (n16 == 5 || n16 == 6) {
            n16 = Randomizer.rand(1, 14);
        }
        switch (Randomizer.rand(1, 12)) {
            case 1: {
                a4 = Randomizer.rand(1, 5);
                break;
            }
            case 2: {
                n3 = Randomizer.rand(1, 5);
                break;
            }
            case 3: {
                n4 = Randomizer.rand(1, 5);
                break;
            }
            case 4: {
                n5 = Randomizer.rand(1, 5);
                break;
            }
            case 5: {
                n6 = Randomizer.rand(1, 2);
                break;
            }
            case 6: {
                n7 = Randomizer.rand(1, 4);
                break;
            }
            case 7: {
                n8 = Randomizer.rand(10, 30);
                break;
            }
            case 8: {
                n9 = Randomizer.rand(10, 30);
                break;
            }
            case 9: {
                n10 = Randomizer.rand(100, 200);
                break;
            }
            case 10: {
                n11 = Randomizer.rand(100, 200);
                break;
            }
            case 11: {
                n12 = Randomizer.rand(5, 15);
                break;
            }
            case 12: {
                n13 = Randomizer.rand(5, 10);
                break;
            }
            case 13: {
                n14 = Randomizer.rand(1, 5);
                break;
            }
            case 14: {
                n15 = Randomizer.rand(1, 5);
                break;
            }
        }
        if (Randomizer.rand(0, 100) >= a3) {
            return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + a3 + "%),\u6c92\u6709\u767c\u751f\u4efb\u4f55\u6539\u8b8a!";
        }
        if (a4 > 0) {
            Equip equip4 = equip3;
            equip = equip4;
            equip4.setStr((short)(equip4.getStr() + a4));
        } else if (n3 > 0) {
            Equip equip5 = equip3;
            equip = equip5;
            equip5.setDex((short)(equip5.getDex() + n3));
        } else if (n4 > 0) {
            Equip equip6 = equip3;
            equip = equip6;
            equip6.setInt((short)(equip6.getInt() + n4));
        } else if (n5 > 0) {
            Equip equip7 = equip3;
            equip = equip7;
            equip7.setLuk((short)(equip7.getLuk() + n5));
        } else if (n6 > 0) {
            Equip equip8 = equip3;
            equip = equip8;
            equip8.setWatk((short)(equip8.getWatk() + n6));
        } else if (n7 > 0) {
            Equip equip9 = equip3;
            equip = equip9;
            equip9.setMatk((short)(equip9.getMatk() + n7));
        } else if (n8 > 0) {
            Equip equip10 = equip3;
            equip = equip10;
            equip10.setWdef((short)(equip10.getWdef() + n8));
        } else if (n9 > 0) {
            Equip equip11 = equip3;
            equip = equip11;
            equip11.setMdef((short)(equip11.getMdef() + n9));
        } else if (n10 > 0) {
            Equip equip12 = equip3;
            equip = equip12;
            equip12.setHp((short)(equip12.getHp() + n10));
        } else if (n11 > 0) {
            Equip equip13 = equip3;
            equip = equip13;
            equip13.setMp((short)(equip13.getMp() + n11));
        } else if (n12 > 0) {
            Equip equip14 = equip3;
            equip = equip14;
            equip14.setAcc((short)(equip14.getAcc() + n12));
        } else if (n13 > 0) {
            Equip equip15 = equip3;
            equip = equip15;
            equip15.setAvoid((short)(equip15.getAvoid() + n13));
        } else if (n15 > 0) {
            Equip equip16 = equip3;
            equip = equip16;
            equip16.setJump((short)(equip16.getJump() + n15));
        } else {
            if (n14 > 0) {
                Equip equip17 = equip3;
                equip17.setSpeed((short)(equip17.getSpeed() + n14));
            }
            equip = equip3;
        }
        equip.setOwner(a5.getEquipStar(n2 + 1));
        equip2 = (Equip)equip3.copy();
        MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a5.getClient(), equip2, false);
        a5.c.getPlayer().equipChanged();
        object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + a3 + "%)\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a5.getEquipStar(n2 + 1) + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + equip3.getStr() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + equip3.getDex() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + equip3.getInt() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + equip3.getLuk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + equip3.getWatk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + equip3.getMatk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u9632\u79a6\u529b:#r" + equip3.getWdef() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u9632\u79a6\u529b:#r" + equip3.getMdef() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8840\u91cf:#r" + equip3.getHp() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u529b:#r" + equip3.getMp() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u547d\u4e2d:#r" + equip3.getAcc() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8ff4\u907f:#r" + equip3.getAvoid() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u901f\u5ea6:#r" + equip3.getJump() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8df3\u8e8d:#r" + equip3.getSpeed() + "#b\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
        FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a5.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + equip2.getItemName() + "(" + equip2.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
        return object;
    }

    public /* synthetic */ void showdonateMonth() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showdonateRanks(nPCConversationManager.E, MapleRanking.getInstance().getDonateMonthRank()));
    }

    public /* synthetic */ void playSound(boolean a2, String a3) {
        NPCConversationManager a4;
        if (a2) {
            a4.c.getPlayer().getMap().broadcastMessage(MaplePacketCreator.playSound(a3));
            return;
        }
        a4.c.sendPacket(MaplePacketCreator.playSound(a3));
    }

    public /* synthetic */ String getNiuNiuRules() {
        return NiuNiu.getInstance().getRules();
    }

    public /* synthetic */ void removeAdditionalEffect() {
        NPCConversationManager a2;
        a2.getDirectionEffect(GameDirectionType.InGameDirectionEvent_RemoveAdditionalEffect.getValue(), null, null);
    }

    public /* synthetic */ void giveKegs(int a2) {
        NPCConversationManager a3;
        AramiaFireWorks.getInstance().giveKegs(a3.c.getPlayer(), a2);
    }

    public /* synthetic */ String SendInviteGift(MapleCharacter a2, String a3) {
        String string = a3;
        MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string);
        int n2 = World.Find.findChannel(string);
        if (mapleCharacter != null) {
            if (n2 <= 0) {
                return InventoryException.ALLATORIxDEMO("\u6b1e\u73c8\u5bcc\u768f\u5237\u4e6c\u5752\u7dbb\u4e70@\u8ab1\u7b28\u5fff\u4eb7\u4e70\u7dbb\u51f7\u9053\u8836\u732f\u528f\u512d\u63a1@");
            }
            if (a2.getPrizeLog(MapleImp.ALLATORIxDEMO("\u90bf\u8a9b\u7371\u52a5\u5173\u638b")) >= 1) {
                return InventoryException.ALLATORIxDEMO("\u60d2\u76e5\u5e49\u863e\u5d88\u7df2\u5136\u63ba\u9034\u90e1\u8ab1\u732f\u528f\u4ee7\u55ee\uff60");
            }
            if (a3.equals(a2.getName())) {
                return MapleImp.ALLATORIxDEMO("\u6097\u7171\u6cea\u511c\u63e4\u731e\u52ca\u7d36\u81d5\u5da1\u55ab\uff51");
            }
            if (a2.getLevel() < 70) {
                return InventoryException.ALLATORIxDEMO("\u60c9\u76fe\u7b28\u7d60\u9761\u89fb\u9035\u524aVJ\u7b28\u55ee\uff60");
            }
            if (mapleCharacter.canHold(4000313) && a2.canHold(5220000)) {
                mapleCharacter.gainItem(4000313, 10, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                a2.gainItem(5220000, 30, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                mapleCharacter.dropMessage(1, "\u60a8\u5df2\u6536\u5230\u4f86\u81ea" + a2.getName() + "\u6240\u767c\u9001\u7684\u7279\u5225\u9080\u8acb\u734e\u52f5!");
                a2.setPrizeLog(MapleImp.ALLATORIxDEMO("\u90bf\u8a9b\u7371\u52a5\u5173\u638b"));
                FileoutputUtil.logToFile(InventoryException.ALLATORIxDEMO("\u0016\u000e\u001d\u0012U%\u001b\u0015\u001bN\u90fa\u8aaa\u7334\u5294\u5136\u63baT\u0015\u0002\u0015"), "\r\n " + FileoutputUtil.NowTime() + "\u88ab\u9080\u8acb\u8005: " + a2.getName() + " \u5df2\u514c\u63db\u9080\u8acb\u734e\u52f5\u3002 \u9080\u8acb\u4eba: " + mapleCharacter.getName());
                return MapleImp.ALLATORIxDEMO("\u9689\u6586\u76d6\u5dcd\u762c\u903e\u90d0\u8af4\u731e\u52caq\u90bf\u8a9b\u4e85\u7322\u5fa8sId\u000f`\u000fc\u000ec\u001cpGp\u000e`\u001f\u505b\u001e]5\u4e44\u8894\u90d0\u8af4\u4eea\u734d\u5fc7\u001c&\nb\r`\u000f`\u000fs\u001f(\u001fc\u000fp\u5034q");
            }
            return InventoryException.ALLATORIxDEMO("\u8ab1\u78db\u8af7\u90e1\u8ab1\u4edb\u827d\u88ca\u90fa\u8aaa\u4ec0\u80ad\u537f\u6b65\u4f37\u5124\u8dc9@");
        }
        return MapleImp.ALLATORIxDEMO("\u67b5\u8a5d\u4e5d\u520f\u6b34\u7396\u5be6\u8cf8\u8a5a\u0013\u8a9b\u8f07\u5135\u6b5c\u78ea\u76bb\u73f9\u5b89\u0019{q");
    }

    public /* synthetic */ String getBaccaratGMInfo() {
        NPCConversationManager a2;
        return Baccarat.getInstance().getGMInfo(a2.c.getPlayer());
    }

    public /* synthetic */ void getJobSelection(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        a3.c.getPlayer().clearNpcSelect();
        nPCConversationManager.c.getPlayer().addNpcSelect(-999999999);
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getJobSelection(a3.E, a2));
        nPCConversationManager.a = 0;
    }

    public /* synthetic */ ScriptType getType() {
        NPCConversationManager a2;
        return a2.K;
    }

    public final /* synthetic */ void faceOff(int a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_FaceOff.getValue(), null, arrn);
    }

    public final /* synthetic */ void clearSkills() {
        NPCConversationManager a2;
        Iterator<Map.Entry<ISkill, SkillEntry>> iterator;
        Iterator<Map.Entry<ISkill, SkillEntry>> iterator2 = iterator = a2.getPlayer().getSkills().entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<ISkill, SkillEntry> entry = iterator.next();
            a2.getPlayer().changeSkillLevel(entry.getKey(), 0, 0);
            iterator2 = iterator;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void getDirectionEffect(int a22, String a3, int[] a4) {
        NPCConversationManager a5;
        NPCConversationManager nPCConversationManager = a5;
        a5.c.getPlayer().clearNpcSelect();
        nPCConversationManager.c.getPlayer().addNpcSelect(-999999999);
        GameDirectionType a22 = GameDirectionType.getType(a22);
        nPCConversationManager.c.sendPacket(UIPacket.getDirectionEffect(a22, a3, a4));
        if (nPCConversationManager.a > -1) {
            return;
        }
        switch (7.ALLATORIxDEMO[a22.ordinal()]) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                a5.a = MaplePacketOperation.NPCStatus.DirectionEffect;
                return;
            }
        }
    }

    public /* synthetic */ void ChangeName(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getPlayer().setName(a2);
        nPCConversationManager.save();
        nPCConversationManager.getPlayer().fakeRelog();
    }

    public /* synthetic */ String ShowJobRank(int a22) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MapleRanking.JobRankingInfo> a22 = MapleRanking.getInstance().getJobRank(a22);
        if (a22 != null) {
            int n2 = 0;
            Object object = a22 = a22.iterator();
            while (object.hasNext()) {
                MapleRanking.JobRankingInfo jobRankingInfo = (MapleRanking.JobRankingInfo)a22.next();
                object = a22;
                stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001c>\u001c5\u001c;\u63ad\u545d\u0005sMp"));
                stringBuilder.append(++n2);
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wkY\u000fY\u0004Y\n\u73d3\u5bd7\u5477\u7a50@B\u001eA"));
                stringBuilder.append(StringUtil.getRightPaddedStr(jobRankingInfo.getName(), ' ', 13));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z\u001c>\u001c5\u001c;\u7b76\u7d4a\u0005sZsMp"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(jobRankingInfo.getLevel()), ' ', 3));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wkY\u000fY\u0004Y\n\u800d\u690c@B\u001fB\u0018A"));
                stringBuilder.append(MapleJob.getName(MapleJob.getById(jobRankingInfo.getJob())));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z\u001c>\u001c5\u001c;\u52a4\u919f\u0005sZs[p"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(jobRankingInfo.getStr()), ' ', 4));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wkY\u000fY\u0004Y\n\u6535\u6316@B\u001fB\u001eA"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(jobRankingInfo.getDex()), ' ', 4));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z\u001c>\u001c5\u001c;\u6645\u52cb\u0005sZs[p"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(jobRankingInfo.getInt()), ' ', 4));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wkY\u000fY\u0004Y\n\u5e02\u902a@B\u001fB\u001eA"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(jobRankingInfo.getLuk()), ' ', 4));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z"));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("Y\u000fY\nG\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\G\\wk"));
            }
        } else {
            stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001c\"\u67da\u8a32\u711e\u4eab\u4f6a\u7d00\u67a3\u5567"));
        }
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ void setPartyBossLog(String a2) {
        NPCConversationManager a3;
        MapleParty mapleParty = a3.getPlayer().getParty();
        if (mapleParty != null) {
            for (MaplePartyCharacter maplePartyCharacter : mapleParty.getMembers()) {
                MapleCharacter serializable = World.getStorage(a3.getClient().getWorld(), a3.getChannelNumber()).getCharacterById(maplePartyCharacter.getId());
                if (serializable == null) continue;
                serializable.setBossLog(a2);
            }
        }
    }

    public /* synthetic */ void showdonateDay() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showdonateRanks(nPCConversationManager.E, MapleRanking.getInstance().getDonateDayRank()));
    }

    public /* synthetic */ void sendLeftPlayerNoESC(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.sendNextS(a2, (byte)17, nPCConversationManager.E);
    }

    public /* synthetic */ boolean start_DojoAgent(boolean a2, boolean a3) {
        NPCConversationManager a4;
        if (a2) {
            return Event_DojoAgent.warpStartDojo(a4.c.getPlayer(), a3);
        }
        return Event_DojoAgent.warpStartAgent(a4.c.getPlayer(), a3);
    }

    public /* synthetic */ void showlvl() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showlevelRanks(nPCConversationManager.E, MapleRanking.getInstance().getLevelRank()));
    }

    public /* synthetic */ void askMenu(int a2, int a3, int a4, int a5, int a6, int a7, String a8) {
        NPCConversationManager a9;
        if (!a8.contains(MapleImp.ALLATORIxDEMO("\u001c\u001c"))) {
            a9.say(a2, a3, a4, a5, a6, a7, a8, 0 != 0, 0 != 0, 0);
            return;
        }
        a9.a = (byte)5;
        a9.c.sendPacket(MaplePacketCreator.getNPCTalk(a9.E, (byte)5, a8, "", (byte)0));
    }

    public /* synthetic */ boolean reAdd(String a2, String a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        a2 = nPCConversationManager.getDisconnected((String)a2);
        a3 = nPCConversationManager.getSquad((String)a3);
        if (a2 != null && a3 != null) {
            NPCConversationManager nPCConversationManager2 = a4;
            ((MapleSquad)a3).reAddMember(nPCConversationManager2.getPlayer());
            ((EventInstanceManager)a2).registerPlayer(nPCConversationManager2.getPlayer());
            return true;
        }
        return false;
    }

    public /* synthetic */ String EnchantHp(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        boolean bl2 = ItemConstants.\u985e\u578b.\u62ab\u98a8((int)n2) && !bl;
        Object object = "";
        int n3 = 3500;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u62d1\u98c9\u883a\u91ae\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (bl2) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u62ab\u98a8\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            a3 = (short)Randomizer.rand(a3, a4);
            Equip equip3 = equip2;
            short s2 = (short)(equip3.getHp() + a3);
            a4 = s2;
            equip3.setHp((short)(s2 > n3 ? (int)n3 : a4));
            object = (String)object + "\u8840\u91cf:  " + (short)a3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316HP[" + (n4 += a3) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u6294\u98f8\u5508q\u50fa\u6759\u6294\u98f8\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ String ShowMonsterPet(int a22) {
        String string = InventoryException.ALLATORIxDEMO("Y\u0007?\u0007\u001c\u0004\u0019\u0015U\"\u0012\u0000\b\u0000\u0019\u0015\u001f\u0013?\u0007\u001cNKQHSHSINNNJB");
        string = MapleImp.ALLATORIxDEMO("\u001c6j\u0019\u0010\u0005v\u0007V>[?H~V=X\u007f~\"V1Q$r1K3W\u007f\\8^\"^3K5M\u0019\\?Q\u007f\u000fs");
        String string2 = InventoryException.ALLATORIxDEMO("Y\u0007/(U436\u0013\u000f\u001e\u000e\rO\u0013\f\u001dN;\u0013\u0013\u0000\u0014\u00157\u0000\u000e\u0002\u0012N\u0019\t\u001b\u0013\u001b\u0002\u000e\u0004\b(\u0019\u000e\u0014NKB");
        String string3 = MapleImp.ALLATORIxDEMO("\u001c6j\u0019\u0010\u0005v\u0007V>[?H~V=X\u007f~\"V1Q$r1K3W\u007f\\8^\"^3K5M\u0019\\?Q\u007f\rs");
        String string4 = InventoryException.ALLATORIxDEMO("Y\u0007/(U436\u0013\u000f\u001e\u000e\rO\u0013\f\u001dN;\u0013\u0013\u0000\u0014\u00157\u0000\u000e\u0002\u0012N\u0019\t\u001b\u0013\u001b\u0002\u000e\u0004\b(\u0019\u000e\u0014NIB");
        String string5 = MapleImp.ALLATORIxDEMO("\u001c6j\u0019\u0010\u0005v\u0007V>[?H~V=X\u007f~\"V1Q$r1K3W\u007f\\8^\"^3K5M\u0019\\?Q\u007f\u000bs");
        String string6 = InventoryException.ALLATORIxDEMO("Y\u0007/(U436\u0013\u000f\u001e\u000e\rO\u0013\f\u001dN;\u0013\u0013\u0000\u0014\u00157\u0000\u000e\u0002\u0012N\u0019\t\u001b\u0013\u001b\u0002\u000e\u0004\b(\u0019\u000e\u0014NOB");
        StringBuilder stringBuilder = new StringBuilder();
        List<MapleMount.MonsterPetInfo> a22 = MapleMount.getMonsterPet(a22);
        if (a22 != null) {
            int n2 = 0;
            Object object = a22 = a22.iterator();
            while (object.hasNext()) {
                String string7;
                MapleMount.MonsterPetInfo monsterPetInfo = (MapleMount.MonsterPetInfo)a22.next();
                Object object2 = StringUtil.getRightPaddedStr(String.valueOf(monsterPetInfo.getMountId()), ' ', 4);
                String string8 = StringUtil.getRightPaddedStr(String.valueOf(monsterPetInfo.getMountLevel()), ' ', 4);
                ++n2;
                String string9 = StringUtil.getRightPaddedStr(String.valueOf(monsterPetInfo.getPlayerKilled()), ' ', 4);
                int n3 = Integer.parseInt((String)object2);
                if (string7.length() == 6) {
                    object2 = "0" + (String)object2;
                }
                stringBuilder.append("\r\n#n#k#b\u7b2c#r" + n2 + "#b\u96bb\u602a\u7269\u5bf5\u7269  #d\r\n ");
                Object object3 = object2;
                stringBuilder.append("#L" + (String)object3 + "##r(\u9ede\u9078\u66f4\u63db)#d#o" + (String)object3 + "#\u3010\u7b49\u7d1a\u3011:" + string8 + "\u3010\u5df2\u64ca\u6bba\u3011:" + string9 + "#l  ");
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z"));
                stringBuilder.append("\r\n" + string3 + string4 + string + string2 + string3 + string4 + string5 + string6 + string + string2 + string3 + string4 + string5 + string6 + string + string2 + string3 + string4 + string5 + string6 + string);
                object = a22;
            }
        }
        if (!stringBuilder.toString().contains(InventoryException.ALLATORIxDEMO("\u5b8f\u7208"))) {
            NPCConversationManager a3;
            NPCScriptManager.getInstance().dispose(a3.c);
            return MapleImp.ALLATORIxDEMO("\u001c\"\u6097\u6cc2\u6736\u4eab\u4f6a\u76d4\u6015\u7239\u5bca\u7239\u5508qa\u000e");
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ void setNPCSpecialAction(int a2, String a3) {
        NPCConversationManager a4;
        a4.setNPCSpecialAction(a2, a3, false ? (byte)1 : 0, false);
    }

    public final /* synthetic */ void sendRPS() {
        NPCConversationManager a2;
        a2.c.sendPacket(MaplePacketCreator.getRPSMode((byte)8, -1, -1, -1));
    }

    public /* synthetic */ void startQuest(int a2) {
        NPCConversationManager a3;
        MapleQuest.getInstance(a2).start(a3.getPlayer(), a3.E);
    }

    public /* synthetic */ void showStorageRanks(MapleStorageType a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showStorageRanks(nPCConversationManager.E, MapleRanking.getInstance().getStorageRank(), a2));
    }

    public /* synthetic */ void openDuey() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.getPlayer().setConversation(2);
        nPCConversationManager.c.sendPacket(MaplePacketCreator.sendDuey((byte)9, null));
    }

    public /* synthetic */ String SendInviteGiftLaba(MapleCharacter a2, String a3) {
        String string = a3;
        MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string);
        int n2 = World.Find.findChannel(string);
        if (mapleCharacter != null) {
            if (n2 <= 0) {
                return InventoryException.ALLATORIxDEMO("\u6b1e\u73c8\u5bcc\u768f\u5237\u4e6c\u5752\u7dbb\u4e70@\u8ab1\u7b28\u5fff\u4eb7\u4e70\u7dbb\u51f7\u9053\u8836\u732f\u528f\u512d\u63a1@");
            }
            if (a2.getPrizeLog(MapleImp.ALLATORIxDEMO("\u90bf\u8a9b\u7371\u52a5\u5173\u638b")) >= 1) {
                return InventoryException.ALLATORIxDEMO("\u60d2\u76e5\u5e49\u863e\u5d88\u7df2\u5136\u63ba\u9034\u90e1\u8ab1\u732f\u528f\u4ee7\u55ee\uff60");
            }
            if (mapleCharacter.getPrizeLog(MapleImp.ALLATORIxDEMO("\u90d0\u8af4\u4eea\u6b1e\u6528")) >= 10) {
                return InventoryException.ALLATORIxDEMO("\u5c6c\u65c3\u5d93\u7de9\u90e1\u8ab1\u4ee7KQ\u5071\u4edb\u715b\u6cb4\u51f7\u9879\u53ac\u56a8[@");
            }
            if (a3.equals(a2.getName())) {
                return MapleImp.ALLATORIxDEMO("\u6097\u7171\u6cea\u511c\u63e4\u731e\u52ca\u7d36\u81d5\u5da1\u55ab\uff51");
            }
            if (a2.getAccountID() <= 95145) {
                return InventoryException.ALLATORIxDEMO("PUU\u4e31\u5fed\u65ca\u5214\u5e80\u76e5\u5e49\u863e\u6237\u88ca\u7c81\u7d10\u5be0\u70db\u88d1\u90e1\u8ab1\u76e5\u65ca\u73c8\u5bcc\uff60\u60d2\u5c0d\u65c6\u5129\u92a8\u73c8\u5bcc\u7140\u6caf\u4f1e\u7552\u6b05\u52e5\u809c[\u8df4\u5f91\u53da\u90fa\u8aaa\u65ca\u73c8\u5bcc\u7313\u5fed\u9ebf\u6502\u5446[@");
            }
            if (mapleCharacter.getLevel() < 70) {
                return MapleImp.ALLATORIxDEMO("\u6397\u85f6\u4e85\u9750\u89be\u9004\u520fg\u000f\u7b19\u55ab\uff51");
            }
            if (a2.getLevel() < 50) {
                return InventoryException.ALLATORIxDEMO("\u60c9\u76fe\u7b28\u7d60\u9761\u89fb\u9035\u524aTJ\u7b28\u55ee\uff60");
            }
            mapleCharacter.gainItem(2103006, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            mapleCharacter.gainItem(2103002, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            mapleCharacter.gainItem(2022531, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            if (mapleCharacter.getVPoints() == 0) {
                mapleCharacter.gainItem(3015598, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            }
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter2.modifyCSPoints(true ? (byte)1 : 0, 300, true);
            mapleCharacter2.setVPoints(mapleCharacter2.getVPoints() + 1);
            mapleCharacter.dropMessage(1, "\u60a8\u5df2\u6536\u5230\u4f86\u81ea" + a2.getName() + "\u6240\u767c\u9001\u7684\u9080\u8acb\u734e\u52f5");
            mapleCharacter.setPrizeLog(MapleImp.ALLATORIxDEMO("\u90d0\u8af4\u4eea\u6b1e\u6528"));
            a2.gainItem(2103006, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(2450000, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(2022531, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(3015598, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            MapleCharacter mapleCharacter3 = a2;
            mapleCharacter3.modifyCSPoints(true ? (byte)1 : 0, 350, true);
            mapleCharacter3.setPrizeLog(InventoryException.ALLATORIxDEMO("\u90fa\u8aaa\u7334\u5294\u5136\u63ba"));
            FileoutputUtil.logToFile(MapleImp.ALLATORIxDEMO("S?X#\u0010\u0014^$^\u007f\u90bf\u8a9b\u7371\u52a5\u5173\u638b\u0011$G$"), "\r\n " + FileoutputUtil.NowTime() + "\u88ab\u9080\u8acb\u8005: " + a2.getName() + " \u5df2\u514c\u63db\u9080\u8acb\u734e\u52f5\u3002 \u9080\u8acb\u4eba: " + mapleCharacter.getName());
            return InventoryException.ALLATORIxDEMO("\u96b8\u65c3\u76e7\u5d88\u761d\u907b\u90e1\u8ab1\u732f\u528f@");
        }
        return MapleImp.ALLATORIxDEMO("\u67b5\u8a5d\u4e5d\u520f\u6b34\u7396\u5be6\u8cf8\u8a5a\u0013\u8a9b\u8f07\u5135\u6b5c\u78ea\u76bb\u73f9\u5b89\u0019{q");
    }

    public /* synthetic */ String NiuNiuBet(int a2) {
        NPCConversationManager a3;
        return NiuNiu.getInstance().bet(a3.c.getPlayer(), a2);
    }

    public final /* synthetic */ short getKegs() {
        return AramiaFireWorks.getInstance().getKegsPercentage();
    }

    public /* synthetic */ void disbandGuild() {
        NPCConversationManager a2;
        int n2 = a2.c.getPlayer().getGuildId();
        if (n2 <= 0 || a2.c.getPlayer().getGuildRank() != 1) {
            return;
        }
        World.Guild.disbandGuild(n2);
    }

    public /* synthetic */ void showSpeedRank(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showSpeedRanks(nPCConversationManager.E, MapleRanking.getInstance().getSpeedRank(a2)));
    }

    public final /* synthetic */ void setGender(byte a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getPlayer().setGender(a2);
        nPCConversationManager.getPlayer().updateSingleStat(MapleStat.GENDER, a2);
        nPCConversationManager.getPlayer().equipChanged();
    }

    public /* synthetic */ String ShowMountBank(int a22) {
        CharSequence charSequence = InventoryException.ALLATORIxDEMO("Y\u0007?\u0007\u001c\u0004\u0019\u0015U\"\u0012\u0000\b\u0000\u0019\u0015\u001f\u0013?\u0007\u001cNKQHSHSINNNJB");
        if (GameSetConstants.MAPLE_VERSION == 118 || GameSetConstants.MAPLE_VERSION == 119) {
            charSequence = MapleImp.ALLATORIxDEMO("\u001c6z6Y5\\$\u0010\u0013W1M1\\$Z\"z6Y\u007f\u000ea\u000eb\u0006`\u000b\u007f\u000f\u007f\u000fs");
        }
        charSequence = new StringBuilder();
        List<MapleMount.MountBankInfo> a22 = MapleMount.getMountBank(a22);
        if (a22 != null) {
            int n2 = 0;
            a22 = a22.iterator();
            while (a22.hasNext()) {
                ++n2;
                String string = StringUtil.getRightPaddedStr(String.valueOf(((MapleMount.MountBankInfo)a22.next()).getMountId()), ' ', 4);
                int n3 = Integer.parseInt(string);
                if (!MapleItemInformationProvider.getInstance().itemExists(n3)) continue;
                ((StringBuilder)charSequence).append("\r\n#n#e#k#b\u7b2c" + n2 + "\u96bb\u9a0e\u5bf5:#e#d ");
                String string2 = string;
                ((StringBuilder)charSequence).append("#r(\u9ede\u9078\u66f4\u63db)#d #L" + string2 + "##i" + string2 + "##l   #t" + string2 + "# ");
                ((StringBuilder)charSequence).append(InventoryException.ALLATORIxDEMO("wkwk"));
                ((StringBuilder)charSequence).append(MapleImp.ALLATORIxDEMO("\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}\u0012}"));
            }
        }
        if (!((StringBuilder)charSequence).toString().contains(InventoryException.ALLATORIxDEMO("\u9a74\u5b94"))) {
            NPCConversationManager a3;
            NPCScriptManager.getInstance().dispose(a3.c);
            return MapleImp.ALLATORIxDEMO("\u001c\"\u6097\u6cc2\u6736\u4eab\u4f6a\u76d4\u62bf\u80ad\u9a31\u5ba5\u5508qa\u000e");
        }
        return ((StringBuilder)charSequence).toString();
    }

    public /* synthetic */ String EnchantWeapon(byte a2) {
        NPCConversationManager a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int s2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = GameConstants.isWeapon(s2);
        Object object = "";
        if (equip2.getOwner().contains(InventoryException.ALLATORIxDEMO("\u5f4d\u5377"))) {
            return MapleImp.ALLATORIxDEMO("\u6b5b\u6b36\u5657\u5da2\u5f08\u5346\u9071\u4ed6\u5508q");
        }
        if (bl) {
            Object object2;
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + s2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            if (equip2.getWatk() > equip2.getMatk()) {
                short s3 = (short)Randomizer.rand(3, 6);
                Equip equip3 = equip2;
                short s4 = s3;
                equip3.setWatk((short)(equip3.getWatk() + s4));
                object2 = object = (String)object + "\u7269\u7406\u653b\u64ca:  " + s4 + "\r\n";
            } else {
                short s5 = (short)Randomizer.rand(3, 6);
                Equip equip4 = equip2;
                short s6 = s5;
                equip4.setMatk((short)(equip4.getMatk() + s6));
                object2 = object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + s6 + "\r\n";
            }
            object = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip5 = equip2;
            equip5.setOwner(InventoryException.ALLATORIxDEMO("\u5f4d\u5377"));
            equip = (Equip)equip5.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u6b59\u5638\u5508q\u50fa\u6759\u6b59\u5638\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ String BaccaratBet(String a2, int a3, String a4) {
        NPCConversationManager a5;
        return Baccarat.getInstance().bet(a5.c.getPlayer(), a2, a3, a4);
    }

    public /* synthetic */ void sendPendant(boolean a2) {
        NPCConversationManager a3;
        a3.c.sendPacket(MaplePacketCreator.pendantSlot(a2));
    }

    public /* synthetic */ void openShopNPC(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        MapleShopFactory.getInstance().getShop(a2).sendShop(nPCConversationManager.c, nPCConversationManager.E);
    }

    public final /* synthetic */ int getDojoPoints() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getDojo();
    }

    public /* synthetic */ void completeQuest(int a2) {
        NPCConversationManager a3;
        MapleQuest.getInstance(a2).complete(a3.getPlayer(), a3.E);
    }

    public /* synthetic */ String Enchanthihi(byte a2) {
        NPCConversationManager a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = n2 == 0x111EE1;
        Object object = "";
        if (equip2.getOwner().equals(InventoryException.ALLATORIxDEMO("\u5d93\u5f4d\u5377"))) {
            return MapleImp.ALLATORIxDEMO("sKa\u000eb\r`\u000eg\u001c\u5da2\u5f08\u5346\u9071q");
        }
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setStr((short)10);
            object = (String)object + "\u529b\u91cf: + 10\r\n";
            equip2.setDex((short)10);
            object = (String)object + "\u654f\u6377: + 10\r\n";
            equip2.setInt((short)10);
            object = (String)object + "\u667a\u529b: + 10\r\n";
            equip2.setLuk((short)10);
            object = (String)object + "\u5e78\u904b: + 10\r\n";
            equip2.setWatk((short)10);
            object = (String)object + "\u7269\u7406\u653b\u64ca: + 10\r\n";
            equip2.setMatk((short)10);
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca: + 10\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip3 = equip2;
            equip3.setOwner(InventoryException.ALLATORIxDEMO("\u5d93\u5f4d\u5377"));
            equip = (Equip)equip3.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u001c$\u000ea\rb\u000fa\bs\u5508q\u50fa\u6759\u001c$\u000ea\rb\u000fa\bs\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ void sendProfessionWindow() {
        NPCConversationManager a2;
        a2.c.sendPacket(MaplePacketCreator.sendProfessionWindow(0));
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String CashEquipStar2(byte a2, int a3, int a4) {
        Equip equip;
        NPCConversationManager a5;
        Equip equip2;
        Equip equip3 = equip2 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n2 = MapleItemInformationProvider.getInstance().isCash(n2) ? (byte)1 : 0;
        Object object = "";
        if (n2 == 0) return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bcV\u7140\u6caf\u5326\u7d60\u3063");
        if (!(equip3.getStr() == 0 && equip3.getDex() == 0 && equip3.getInt() == 0 && equip3.getLuk() == 0 && equip3.getHp() == 0 && equip3.getMp() == 0 && equip3.getWatk() == 0 && equip3.getMatk() == 0 && equip3.getWdef() == 0 && equip3.getMdef() == 0 && equip3.getAcc() == 0 && equip3.getSpeed() == 0 && equip3.getJump() == 0 || equip3.getOwner().contains(InventoryException.ALLATORIxDEMO("\u2664")) || equip3.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2656")))) {
            return InventoryException.ALLATORIxDEMO("Y\u0013\u6b1e\u88bc\u50e3\u5d93\u6773\u7218\u6bf0\u809c\u52e1\u001f\u569a\u6b05\u715b\u6cb4\u533d\u7d7b\u549c@");
        }
        n2 = a5.getEquipLevelBlack(equip3.getOwner());
        if (n2 >= 7) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (!a5.c.getPlayer().haveItem(a4)) {
            return "#r\u5347\u7d1a\u9700\u8981#i" + a4 + "# 1 \u500b!";
        }
        a5.c.getPlayer().gainItem(a4, -1);
        a4 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        n8 = 0;
        n8 = 0;
        n8 = 0;
        n8 = 0;
        n8 = 0;
        n8 = 0;
        n8 = 0;
        n8 = Randomizer.rand(1, 6);
        if (n8 == 5 || n8 == 6) {
            n8 = Randomizer.rand(1, 6);
        }
        switch (Randomizer.rand(1, 6)) {
            case 1: {
                a4 = Randomizer.rand(-3, 3);
                break;
            }
            case 2: {
                n3 = Randomizer.rand(-3, 3);
                break;
            }
            case 3: {
                n4 = Randomizer.rand(-3, 3);
                break;
            }
            case 4: {
                n5 = Randomizer.rand(-3, 3);
                break;
            }
            case 5: {
                n6 = Randomizer.rand(-3, 2);
                break;
            }
            case 6: {
                n7 = Randomizer.rand(-2, 2);
                break;
            }
        }
        if (Randomizer.rand(0, 100) >= a3) {
            return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + a3 + "%),\u6c92\u6709\u767c\u751f\u4efb\u4f55\u6539\u8b8a!";
        }
        if (a4 > 0) {
            Equip equip4 = equip3;
            equip = equip4;
            equip4.setStr((short)(equip4.getStr() + a4));
        } else if (n3 > 0) {
            Equip equip5 = equip3;
            equip = equip5;
            equip5.setDex((short)(equip5.getDex() + n3));
        } else if (n4 > 0) {
            Equip equip6 = equip3;
            equip = equip6;
            equip6.setInt((short)(equip6.getInt() + n4));
        } else if (n5 > 0) {
            Equip equip7 = equip3;
            equip = equip7;
            equip7.setLuk((short)(equip7.getLuk() + n5));
        } else if (n6 > 0) {
            Equip equip8 = equip3;
            equip = equip8;
            equip8.setWatk((short)(equip8.getWatk() + n6));
        } else {
            if (n7 > 0) {
                Equip equip9 = equip3;
                equip9.setMatk((short)(equip9.getMatk() + n7));
            }
            equip = equip3;
        }
        equip.setOwner(a5.getEquipStarBlack(n2 + 1));
        equip2 = (Equip)equip3.copy();
        MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a5.getClient(), equip2, false);
        a5.c.getPlayer().equipChanged();
        object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + a3 + "%)\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a5.getEquipStar(n2 + 1) + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u529b\u91cf:#r" + a4 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u654f\u6377:#r" + n3 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u667a\u529b:#r" + n4 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u5e78\u904b:#r" + n5 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u7269\u7406\u653b\u64ca\u529b:#r" + n6 + "#b\r\n";
        object = (String)object + "\u6b64\u6b21\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
        FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a5.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + equip2.getItemName() + "(" + equip2.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
        return object;
    }

    public /* synthetic */ boolean addCapacityToAlliance() {
        try {
            NPCConversationManager a2;
            MapleGuild mapleGuild = World.Guild.getGuild(a2.c.getPlayer().getGuildId());
            if (mapleGuild != null && a2.c.getPlayer().getGuildRank() == 1 && a2.c.getPlayer().getAllianceRank() == 1 && World.Alliance.getAllianceLeader(mapleGuild.getAllianceId()) == a2.c.getPlayer().getId() && World.Alliance.changeAllianceCapacity(mapleGuild.getAllianceId())) {
                a2.gainMeso(-10000000);
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    public /* synthetic */ void askAvatar(String a2, int ... a3) {
        NPCConversationManager nPCConversationManager;
        int n2;
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        a4.c.getPlayer().clearNpcSelect();
        int n3 = 0;
        int[] arrn = a3;
        int n4 = a3.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            int n6 = arrn[n2];
            a4.c.getPlayer().addNpcSelect(n3);
            n5 = ++n2;
            ++n3;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            NPCConversationManager nPCConversationManager2 = a4;
            nPCConversationManager = nPCConversationManager2;
            a4.c.sendPacket(MaplePacketCreator.getNPCTalkStyle(nPCConversationManager2.E, a2, false, a4.getCanHair(a3)));
        } else {
            NPCConversationManager nPCConversationManager3 = a4;
            nPCConversationManager = nPCConversationManager3;
            nPCConversationManager3.c.sendPacket(MaplePacketCreator.getNPCTalkStyle(nPCConversationManager3.E, a2, a4.getCanHair(a3)));
        }
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.askAvatar;
    }

    public final /* synthetic */ short getSunshines() {
        return AramiaFireWorks.getInstance().getSunsPercentage();
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ long getMerchantMesos() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK], 2[TRYBLOCK]], but top level block is 7[TRYBLOCK]
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

    public /* synthetic */ void setGetText(String a2) {
        a.k = a2;
    }

    public /* synthetic */ String EnchantHp(byte a2, int a3, int a4, int a5, int a6, int a7) {
        NPCConversationManager a8;
        Equip equip;
        Equip equip2 = equip = (Equip)a8.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        NPCConversationManager nPCConversationManager = a8;
        int n2 = nPCConversationManager.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        int n3 = StringTool.getIntFromString(equip2.getOwner());
        if (!nPCConversationManager.c.getPlayer().haveItem(a6, a7)) {
            return "\u60a8\u7f3a\u4e4f\u7269\u54c1#i" + a6 + "#!";
        }
        if (n3 >= a5) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        a8.c.getPlayer().gainItem(a6, -a7);
        object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
        object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        a3 = (short)Randomizer.rand(a3, a4);
        Equip equip3 = equip2;
        short s2 = (short)(equip3.getHp() + a3);
        a4 = s2;
        equip3.setHp((short)(s2 > a5 ? (int)a5 : a4));
        object = (String)object + "\u8840\u91cf:  " + (short)a3 + "\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        equip2.setOwner("\u5f37\u5316HP[" + (n3 += a3) + "]");
        equip = (Equip)equip2.copy();
        MapleInventoryManipulator.removeFromSlot(a8.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a8.getClient(), equip, false);
        a8.c.getPlayer().equipChanged();
        return object;
    }

    public /* synthetic */ String EnchantFlowerXin(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        NPCConversationManager nPCConversationManager = a5;
        int n2 = nPCConversationManager.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        if (!nPCConversationManager.c.getPlayer().haveItem(a3, a4)) {
            return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a3 + "# " + a4 + "\u500b!";
        }
        a5.c.getPlayer().gainItem(a3, -a4);
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + 10));
            object = (String)object + "\u529b\u91cf: + 10\r\n";
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + 10));
            object = (String)object + "\u654f\u6377: + 10\r\n";
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + 10));
            object = (String)object + "\u667a\u529b: + 10\r\n";
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + 10));
            object = (String)object + "\u5e78\u904b: + 10\r\n";
            Equip equip7 = equip2;
            equip7.setWatk((short)(equip7.getWatk() + 3));
            object = (String)object + "\u7269\u7406\u653b\u64ca: + 3\r\n";
            Equip equip8 = equip2;
            equip8.setMatk((short)(equip8.getMatk() + 3));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca: + 3\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip9 = equip2;
            equip9.setOwner(InventoryException.ALLATORIxDEMO("\u5d93\u5f4d\u5377"));
            equip = (Equip)equip9.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b5b\u888d\u50a6\u4e76\u9761\u9e8e\u88e2|\u711e\u6c85\u5f08\u5346\u54d9q");
    }

    public /* synthetic */ String EnchantCashEqipPersicaMS(byte a2, int a3) {
        boolean bl;
        NPCConversationManager a4;
        Equip equip = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        Equip equip2 = (Equip)equip.copy();
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl2 = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        short s7 = 0;
        short s8 = 0;
        short s9 = 0;
        if (equip2.getOwner().equals(InventoryException.ALLATORIxDEMO("\u5d93\u963e\u9b35I\u6b40"))) {
            return MapleImp.ALLATORIxDEMO("\u60f8\u967b\u9b04\u5dcd\u9004\f\u6b71\u0013\u7171\u6cea\u7e2c\u7eb3\u9614\u9b6bq");
        }
        if (a3 == 1) {
            s2 = (short)Randomizer.rand(-4, 4);
            s3 = (short)Randomizer.rand(-4, 4);
            s4 = (short)Randomizer.rand(-4, 4);
            s5 = (short)Randomizer.rand(-4, 4);
            s8 = (short)Randomizer.rand(-4, 4);
            s9 = (short)Randomizer.rand(-4, 4);
            bl = bl2;
        } else if (a3 == 2) {
            s2 = (short)Randomizer.rand(1, 5);
            s3 = (short)Randomizer.rand(1, 5);
            s4 = (short)Randomizer.rand(1, 5);
            s5 = (short)Randomizer.rand(1, 5);
            s8 = (short)Randomizer.rand(1, 5);
            s9 = (short)Randomizer.rand(1, 5);
            bl = bl2;
        } else {
            if (a3 == 3) {
                s2 = (short)8;
                s3 = (short)8;
                s4 = 8;
                s5 = 8;
                s8 = 8;
                s9 = 8;
            }
            bl = bl2;
        }
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + s2 > 0 ? equip2.getStr() + s2 : 0));
            object = (String)object + "\u529b\u91cf + " + s2 + "\r\n";
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + s3 > 0 ? equip2.getDex() + s3 : 0));
            object = (String)object + "\u654f\u6377:  " + s3 + "\r\n";
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + s4 > 0 ? equip2.getInt() + s4 : 0));
            object = (String)object + "\u667a\u529b:  " + s4 + "\r\n";
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + s5 > 0 ? equip2.getLuk() + s5 : 0));
            object = (String)object + "\u5e78\u904b:  " + s5 + "\r\n";
            Equip equip7 = equip2;
            equip7.setHp((short)(equip7.getHp() + s6 > 0 ? equip2.getHp() + s6 : 0));
            object = (String)object + "HP:  " + s6 + "\r\n";
            Equip equip8 = equip2;
            equip8.setMp((short)(equip8.getMp() + s7 > 0 ? equip2.getMp() + s7 : 0));
            object = (String)object + "MP:  " + s7 + "\r\n";
            Equip equip9 = equip2;
            equip9.setWatk((short)(equip9.getWatk() + s8 > 0 ? equip2.getWatk() + s8 : 0));
            object = (String)object + "\u7269\u7406\u653b\u64ca:  " + s8 + "\r\n";
            Equip equip10 = equip2;
            equip10.setMatk((short)(equip10.getMatk() + s9 > 0 ? equip2.getMatk() + s9 : 0));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + s9 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip11 = equip2;
            a3 = StringTool.getIntFromString(equip11.getOwner());
            equip11.setOwner("\u5df2\u9644\u9b54" + ++a3 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), equip, false);
            a4.c.getPlayer().equipChanged();
            return object;
        }
        return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
    }

    public /* synthetic */ long getNiuNiuTotalWin() {
        return NiuNiu.getInstance().getTotalWin();
    }

    public /* synthetic */ List<MapleCharacter> getPartyMembers() {
        NPCConversationManager a2;
        if (a2.getPlayer().getParty() == null) {
            return null;
        }
        LinkedList<MapleCharacter> linkedList = new LinkedList<MapleCharacter>();
        for (MaplePartyCharacter maplePartyCharacter : a2.getPlayer().getParty().getMembers()) {
            Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
            while (iterator.hasNext()) {
                MapleCharacter mapleCharacter = iterator.next().getPlayerStorage().getCharacterById(maplePartyCharacter.getId());
                if (mapleCharacter == null) continue;
                linkedList.add(mapleCharacter);
            }
        }
        return linkedList;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String HappyCashEquipStar(byte a2, int a3, int a4) {
        Equip equip;
        NPCConversationManager a5;
        Equip equip2;
        Equip equip3 = equip2 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n2 = MapleItemInformationProvider.getInstance().isCash(n2) ? (byte)1 : 0;
        Object object = "";
        if (n2 == 0) return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bcV\u7140\u6caf\u5326\u7d60\u3063");
        if (!(equip3.getStr() == 0 && equip3.getDex() == 0 && equip3.getInt() == 0 && equip3.getLuk() == 0 && equip3.getHp() == 0 && equip3.getMp() == 0 && equip3.getWatk() == 0 && equip3.getMatk() == 0 && equip3.getWdef() == 0 && equip3.getMdef() == 0 && equip3.getAcc() == 0 && equip3.getSpeed() == 0 && equip3.getJump() == 0 || equip3.getOwner().contains(InventoryException.ALLATORIxDEMO("\u2664")) || equip3.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2656")))) {
            return InventoryException.ALLATORIxDEMO("Y\u0013\u6b1e\u88bc\u50e3\u5d93\u6773\u7218\u6bf0\u809c\u52e1\u001f\u569a\u6b05\u715b\u6cb4\u533d\u7d7b\u549c@");
        }
        n2 = a5.getEquipLevel(equip3.getOwner());
        if (n2 >= 7) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (!a5.c.getPlayer().haveItem(a4)) {
            return "#r\u5347\u7d1a\u9700\u8981#i" + a4 + "# 1 \u500b!";
        }
        a5.c.getPlayer().gainItem(a4, -1);
        a4 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = Randomizer.rand(1, 14);
        if (n16 == 5 || n16 == 6) {
            n16 = Randomizer.rand(1, 14);
        }
        switch (Randomizer.rand(1, 14)) {
            case 1: {
                a4 = Randomizer.rand(1, 3);
                break;
            }
            case 2: {
                n3 = Randomizer.rand(1, 3);
                break;
            }
            case 3: {
                n4 = Randomizer.rand(1, 3);
                break;
            }
            case 4: {
                n5 = Randomizer.rand(1, 3);
                break;
            }
            case 5: {
                n6 = Randomizer.rand(1, 2);
                break;
            }
            case 6: {
                n7 = Randomizer.rand(1, 3);
                break;
            }
            case 7: {
                n8 = Randomizer.rand(5, 10);
                break;
            }
            case 8: {
                n9 = Randomizer.rand(5, 10);
                break;
            }
            case 9: {
                n10 = Randomizer.rand(25, 80);
                break;
            }
            case 10: {
                n11 = Randomizer.rand(25, 80);
                break;
            }
            case 11: {
                n12 = Randomizer.rand(5, 10);
                break;
            }
            case 12: {
                n13 = Randomizer.rand(5, 10);
                break;
            }
            case 13: {
                n14 = Randomizer.rand(1, 5);
                break;
            }
            case 14: {
                n15 = Randomizer.rand(1, 5);
                break;
            }
        }
        if (Randomizer.rand(0, 100) >= a3) {
            return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + a3 + "%),\u6c92\u6709\u767c\u751f\u4efb\u4f55\u6539\u8b8a!";
        }
        if (a4 > 0) {
            Equip equip4 = equip3;
            equip = equip4;
            equip4.setStr((short)(equip4.getStr() + a4));
        } else if (n3 > 0) {
            Equip equip5 = equip3;
            equip = equip5;
            equip5.setDex((short)(equip5.getDex() + n3));
        } else if (n4 > 0) {
            Equip equip6 = equip3;
            equip = equip6;
            equip6.setInt((short)(equip6.getInt() + n4));
        } else if (n5 > 0) {
            Equip equip7 = equip3;
            equip = equip7;
            equip7.setLuk((short)(equip7.getLuk() + n5));
        } else if (n6 > 0) {
            Equip equip8 = equip3;
            equip = equip8;
            equip8.setWatk((short)(equip8.getWatk() + n6));
        } else if (n7 > 0) {
            Equip equip9 = equip3;
            equip = equip9;
            equip9.setMatk((short)(equip9.getMatk() + n7));
        } else if (n8 > 0) {
            Equip equip10 = equip3;
            equip = equip10;
            equip10.setWdef((short)(equip10.getWdef() + n8));
        } else if (n9 > 0) {
            Equip equip11 = equip3;
            equip = equip11;
            equip11.setMdef((short)(equip11.getMdef() + n9));
        } else if (n10 > 0) {
            Equip equip12 = equip3;
            equip = equip12;
            equip12.setHp((short)(equip12.getHp() + n10));
        } else if (n11 > 0) {
            Equip equip13 = equip3;
            equip = equip13;
            equip13.setMp((short)(equip13.getMp() + n11));
        } else if (n12 > 0) {
            Equip equip14 = equip3;
            equip = equip14;
            equip14.setAcc((short)(equip14.getAcc() + n12));
        } else if (n13 > 0) {
            Equip equip15 = equip3;
            equip = equip15;
            equip15.setAvoid((short)(equip15.getAvoid() + n13));
        } else if (n15 > 0) {
            Equip equip16 = equip3;
            equip = equip16;
            equip16.setJump((short)(equip16.getJump() + n15));
        } else {
            if (n14 > 0) {
                Equip equip17 = equip3;
                equip17.setSpeed((short)(equip17.getSpeed() + n14));
            }
            equip = equip3;
        }
        equip.setOwner(a5.getEquipStar(n2 + 1));
        equip2 = (Equip)equip3.copy();
        MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a5.getClient(), equip2, false);
        a5.c.getPlayer().equipChanged();
        object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + a3 + "%)\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a5.getEquipStar(n2 + 1) + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + equip3.getStr() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + equip3.getDex() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + equip3.getInt() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + equip3.getLuk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + equip3.getWatk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + equip3.getMatk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u9632\u79a6\u529b:#r" + equip3.getWdef() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u9632\u79a6\u529b:#r" + equip3.getMdef() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8840\u91cf:#r" + equip3.getHp() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u529b:#r" + equip3.getMp() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u547d\u4e2d:#r" + equip3.getAcc() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8ff4\u907f:#r" + equip3.getAvoid() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u901f\u5ea6:#r" + equip3.getJump() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8df3\u8e8d:#r" + equip3.getSpeed() + "#b\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
        FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a5.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + equip2.getItemName() + "(" + equip2.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
        return object;
    }

    public /* synthetic */ void say(int a2, int a3, int a4, int a5, String a6, boolean a7, boolean a8) {
        NPCConversationManager a9;
        a9.say(4, a2, a3, a4, a5, 0, a6, a7, a8, 0);
    }

    public /* synthetic */ String checkDrop(MapleCharacter a2, int a32) {
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        List<MonsterDropEntry> list = MapleMonsterInformationProvider.getInstance().retrieveDrop(a32);
        if ((list = new ArrayList<MonsterDropEntry>(list)) != null && list.size() > 0) {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder.append("\u3010#r#o" + a32 + "##k\u3011\u6389\u5bf6\u7269\u54c1\u67e5\u8a62\u5217\u8868:#b\r\n");
            int n5 = 0;
            int n6 = n5;
            while (n6 < list.size()) {
                MonsterDropEntry a32 = list.get(n5);
                if (a32.chance > 0 && (a32.questid <= 0 || a32.questid > 0 && MapleQuest.getInstance(a32.questid).getName().length() > 0)) {
                    n3 = a32.itemId;
                    String string = "#z" + n3 + "#";
                    if (n3 == 0) {
                        n3 = 4031041;
                        string = (double)a32.Minimum * a2.getAllMesoRate() + " to " + (double)a32.Maximum * a2.getAllMesoRate() + " #b\u6953\u5e63";
                    }
                    if (n3 != 0 && mapleItemInformationProvider.itemExists(n3)) {
                        MapleCharacter mapleCharacter = a2;
                        n4 = (int)((double)a32.chance * mapleCharacter.getAllDropRate(a2.getMap(), null));
                        if (!mapleCharacter.isGM()) {
                            MonsterDropEntry monsterDropEntry;
                            Object object;
                            if (GameSetConstants.SERVER_NAME.equals(MapleImp.ALLATORIxDEMO("\u6020\u604f\u8c67"))) {
                                object = "#d  \u6389\u843d\u6a5f\u7387\uff1a" + Integer.valueOf(n4 >= 999999 ? 1000000 : n4).doubleValue() / 10000.0 + "%\r\n";
                                monsterDropEntry = a32;
                            } else {
                                object = InventoryException.ALLATORIxDEMO("wk");
                                monsterDropEntry = a32;
                            }
                            stringBuilder.append("#k" + (n2 + 1) + ": #v" + n3 + "# " + string + (String)object + "#b(\u6389\u843d\u689d\u4ef6:" + (String)(monsterDropEntry.questid > 0 && MapleQuest.getInstance(a32.questid).getName().length() > 0 ? "\u9700\u8981\u63a5\u53d6\u4efb\u52d9#r " + MapleQuest.getInstance(a32.questid).getName() + " #b)\r\n" : MapleImp.ALLATORIxDEMO("\u001c\"\u711es]y")) + "\r\n");
                        } else {
                            MonsterDropEntry monsterDropEntry;
                            Object object;
                            int n7 = n3;
                            if (a2.isGM()) {
                                object = "#d  \u6389\u843d\u6a5f\u7387\uff1a" + Integer.valueOf(n4 >= 999999 ? 1000000 : n4).doubleValue() / 10000.0 + "%(\u9ede\u9078\u66f4\u6539)\r\n";
                                monsterDropEntry = a32;
                            } else {
                                object = InventoryException.ALLATORIxDEMO("wk");
                                monsterDropEntry = a32;
                            }
                            stringBuilder.append("#L" + n7 + "##k" + (n2 + 1) + ": #v" + n7 + "# " + string + (String)object + "#b(\u6389\u843d\u689d\u4ef6:" + (String)(monsterDropEntry.questid > 0 && MapleQuest.getInstance(a32.questid).getName().length() > 0 ? "\u9700\u8981\u63a5\u53d6\u4efb\u52d9#r " + MapleQuest.getInstance(a32.questid).getName() + " #b)\r\n" : MapleImp.ALLATORIxDEMO("\u001c\"\u711es]y")) + "\r\n");
                        }
                        ++n2;
                    } else {
                        stringBuilder2.append(n3 + "\r\n");
                    }
                }
                n6 = ++n5;
            }
            if (a2.isGM()) {
                stringBuilder.append("\r\n#L10000##k" + (n2 + 1) + ": #b\u6211\u8981\u984d\u5916\u65b0\u589e\u6389\u843d\u7269\u54c1!");
            }
            if (stringBuilder2.length() > 0) {
                a2.dropMessage(1, "\u7121\u6548\u7684\u7269\u54c1ID:\r\n" + stringBuilder2.toString());
            }
            if (stringBuilder.length() > 0) {
                return stringBuilder.toString();
            }
        }
        Object object = InventoryException.ALLATORIxDEMO("\u8a08\u604b\u7213\u6784\u715b\u4e9a\u4f2f\u63e8\u5b8c\u6519\u64a0\u3063");
        if (a2.isGM()) {
            object = (String)object + "\r\n#L10000##k: #b\u6211\u8981\u984d\u5916\u65b0\u589e\u6389\u843d\u7269\u54c1!";
        }
        return object;
    }

    public /* synthetic */ int[] getCanFace(int[] a2) {
        NPCConversationManager a3;
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n3 = ((int[])a2).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = a2[n2];
            if (NPCConversationManager.faceExists(n5)) {
                arrayList.add(n5);
            } else {
                arrayList2.add(n5);
            }
            n4 = ++n2;
        }
        if (arrayList2.size() > 0 && a3.c.getPlayer().isAdmin()) {
            StringBuilder stringBuilder = new StringBuilder(InventoryException.ALLATORIxDEMO("\u6b02\u5752\u8be1\u53ac\u76e5\u81b3\u57ea\u91b6\u6768"));
            a2 = stringBuilder;
            stringBuilder.append(arrayList2.size()).append(MapleImp.ALLATORIxDEMO("\u5034\u8199\u57b4\u7578\u6209\u7abf\u4e32\u657f\u63cb\u983f\u7905\uff5c\u5dcd\u7dc3\u8894\u6e55\u965b\uff4a"));
            n3 = 0;
            int n6 = n3;
            while (n6 < arrayList2.size()) {
                int n7 = n3;
                ((StringBuilder)a2).append(arrayList2.get(n7));
                if (n7 < arrayList2.size() - 1) {
                    ((StringBuilder)a2).append(InventoryException.ALLATORIxDEMO("M"));
                }
                n6 = ++n3;
            }
            a3.playerMessage(((StringBuilder)a2).toString());
        }
        a2 = new int[arrayList.size()];
        int n8 = n3 = 0;
        while (n8 < arrayList.size()) {
            int n9 = n3++;
            a2[n9] = (Integer)arrayList.get(n9);
            n8 = n3;
        }
        return a2;
    }

    public /* synthetic */ void unequip(int a2, boolean a3) {
        NPCConversationManager a4;
        a4.c.getPlayer().unequip(a2, a3);
    }

    public /* synthetic */ boolean replaceItem(int a2, int a3, Object a4, int a5, String a6) {
        NPCConversationManager a7;
        return a7.replaceItem(a2, a3, a4, a5, a6, false);
    }

    public /* synthetic */ void setAndroidSkin(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getPlayer().getAndroid().setSkin(a2);
        nPCConversationManager.getPlayer().getAndroid().saveToDb();
        nPCConversationManager.c.getPlayer().setAndroid(a3.c.getPlayer().getAndroid());
        nPCConversationManager.c.getPlayer().getAndroid().setSkin(a2);
    }

    @Override
    public /* synthetic */ void setQuestCustomData(int a2, String a3) {
        NPCConversationManager a4;
        a4.getPlayer().getQuestNAdd(MapleQuest.getInstance(a2)).setCustomData(a3);
    }

    public final /* synthetic */ String getPotentialInfo(int a2) {
        Object object = MapleItemInformationProvider.getInstance().getPotentialInfo(a2);
        StringBuilder stringBuilder = new StringBuilder(MapleImp.ALLATORIxDEMO("s]sZ\u0000p\u0004z\u001ek\u0019~\u001c\u001f\u0019q\u0016ppy\u001fmpv\u0014\u0005p"));
        stringBuilder.append(a2);
        stringBuilder.append(InventoryException.ALLATORIxDEMO("Y\u000fY\nwkwk"));
        a2 = 1;
        int n2 = 10;
        object = object.entrySet().iterator();
        Object object2 = object;
        while (object2.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            StringBuilder stringBuilder2 = stringBuilder;
            stringBuilder.append(MapleImp.ALLATORIxDEMO("sZ\u001cZ&Z<Lp"));
            stringBuilder2.append(a2);
            stringBuilder.append(InventoryException.ALLATORIxDEMO("\u001f"));
            stringBuilder.append(n2);
            stringBuilder.append(MapleImp.ALLATORIxDEMO("\u0005p\u001c>"));
            a2 += 10;
            stringBuilder2.append(((StructPotentialItem)entry.getValue()).toString());
            n2 += 10;
            stringBuilder.append(InventoryException.ALLATORIxDEMO("wk"));
            object2 = object;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ void sendOthersTalk(String a2, int a3, boolean[] a4, byte a5) {
        NPCConversationManager a6;
        Object object = "";
        if (a4.length >= 2) {
            int n2;
            int n3 = n2 = 0;
            while (n3 < 2) {
                int n4;
                if (a4[n2]) {
                    object = (String)object + "01";
                    n4 = n2;
                } else {
                    object = (String)object + "00";
                    n4 = n2;
                }
                if (n4 < a4.length - 1) {
                    object = (String)object + " ";
                }
                n3 = ++n2;
            }
        } else {
            object = InventoryException.ALLATORIxDEMO("QJAJP");
        }
        NPCConversationManager nPCConversationManager = a6;
        if (a2.contains(MapleImp.ALLATORIxDEMO("\u001c\u001c"))) {
            nPCConversationManager.a = (byte)5;
            NPCConversationManager nPCConversationManager2 = a6;
            nPCConversationManager2.c.sendPacket(MaplePacketCreator.getOthersTalk(nPCConversationManager2.E, a6.a, a3, a2, "", a5));
            return;
        }
        nPCConversationManager.a = 0;
        NPCConversationManager nPCConversationManager3 = a6;
        nPCConversationManager3.c.sendPacket(MaplePacketCreator.getOthersTalk(nPCConversationManager3.E, a6.a, a3, a2, (String)object, a5));
    }

    public /* synthetic */ void gainAp(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().gainAp((short)a2);
    }

    public final /* synthetic */ MapleCarnivalChallenge getNextCarnivalRequest() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getNextCarnivalRequest();
    }

    public /* synthetic */ void sendTellStory(String a2, boolean a3) {
        NPCConversationManager a4;
        int[] arrn = new int[1];
        arrn[0] = a3 ? 1 : 0;
        a4.getDirectionEffect(GameDirectionType.InGameDirectionEvent_Monologue.getValue(), a2, arrn);
    }

    public /* synthetic */ String Enchantmilu(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        NPCConversationManager nPCConversationManager = a5;
        int n2 = nPCConversationManager.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        if (!nPCConversationManager.c.getPlayer().haveItem(a3, a4)) {
            return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a3 + "# " + a4 + "\u500b!";
        }
        if (equip2.getOwner().equals(MapleImp.ALLATORIxDEMO("\u5da2\u967b\u9b04\n\u6b71"))) {
            return InventoryException.ALLATORIxDEMO("\u5d93\u902e\u6761\u595d\u6b40\u6502@");
        }
        a5.c.getPlayer().gainItem(a3, -a4);
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + 1));
            object = (String)object + "\u529b\u91cf: + 1\r\n";
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + 1));
            object = (String)object + "\u654f\u6377: + 1\r\n";
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + 1));
            object = (String)object + "\u667a\u529b: + 1\r\n";
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + 1));
            object = (String)object + "\u5e78\u904b: + 1\r\n";
            Equip equip7 = equip2;
            equip7.setWatk((short)(equip7.getWatk() + 1));
            object = (String)object + "\u7269\u7406\u653b\u64ca: + 1\r\n";
            Equip equip8 = equip2;
            equip8.setMatk((short)(equip8.getMatk() + 1));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca: + 1\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip9 = equip2;
            a3 = StringTool.getIntFromString(equip9.getOwner());
            equip9.setOwner("\u5df2\u9644\u9b54" + ++a3 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b5b\u888d\u50a6\u4e76\u9761\u9e8e\u88e2|\u711e\u6c85\u5f08\u5346\u54d9q");
    }

    public static /* synthetic */ boolean faceExists(int a2) {
        return MapleItemInformationProvider.getInstance().itemExists(a2);
    }

    public /* synthetic */ boolean removePlayerFromInstance() {
        NPCConversationManager a2;
        if (a2.c.getPlayer().getEventInstance() != null) {
            a2.c.getPlayer().getEventInstance().removePlayer(a2.c.getPlayer());
            return true;
        }
        return false;
    }

    public /* synthetic */ void CatchMonsterPet(MapleCharacter a22, int a3) {
        boolean bl;
        int n2;
        Object object;
        NPCConversationManager a4;
        ArrayList<Integer> arrayList;
        block13: {
            ArrayList<Integer> arrayList2;
            MapleMonster mapleMonster = MapleLifeFactory.getMonster(a3);
            arrayList = new ArrayList<Integer>();
            if (mapleMonster == null) {
                NPCConversationManager nPCConversationManager = a4;
                nPCConversationManager.sendOk(MapleImp.ALLATORIxDEMO("sM\u607a\u7256\u8c97\u65a6\u8bd0\u53e9\u937f\u8a9bq\u8af4\u803f\u7e54\u0017r\u3052"));
                nPCConversationManager.dispose();
                return;
            }
            if (!a22.isGM() && mapleMonster.getLevel() > a22.getLevel()) {
                NPCConversationManager nPCConversationManager = a4;
                nPCConversationManager.sendOk(InventoryException.ALLATORIxDEMO("Y\u0013\u60d2\u7140\u6caf\u6334\u6333\u5946\u65c6\u60c9\u7b33\u7d7b\u76fe\u604b\u7213\u5487"));
                nPCConversationManager.dispose();
                return;
            }
            if (mapleMonster.getStats().isBoss()) {
                NPCConversationManager nPCConversationManager = a4;
                nPCConversationManager.sendOk(MapleImp.ALLATORIxDEMO("\u001c\"\u6097\u7171\u6cea\u6305\u6376\u0012p\u0003l\u7d4a\u76bb\u607a\u7256\u54b6"));
                nPCConversationManager.dispose();
                return;
            }
            if (mapleMonster.getLevel() < 70) {
                boolean bl2 = arrayList.add(4251200);
                ArrayList<Integer> arrayList3 = arrayList;
                arrayList.add(4251201);
                arrayList2 = arrayList3;
                arrayList3.add(4251202);
            } else if (mapleMonster.getLevel() >= 70 && mapleMonster.getLevel() <= 120) {
                ArrayList<Integer> arrayList4 = arrayList;
                arrayList.add(4251201);
                arrayList2 = arrayList4;
                arrayList4.add(4251202);
            } else {
                if (mapleMonster.getLevel() > 120) {
                    arrayList.add(4251202);
                }
                arrayList2 = arrayList;
            }
            if (arrayList2.size() == 0) {
                NPCConversationManager nPCConversationManager = a4;
                nPCConversationManager.sendOk(InventoryException.ALLATORIxDEMO("\u6334\u6333\u7511\u5e42@"));
                nPCConversationManager.dispose();
                return;
            }
            boolean bl3 = false;
            object = arrayList.iterator();
            while (object.hasNext()) {
                n2 = (Integer)object.next();
                if (!a4.haveItem(n2)) continue;
                a4.gainItem(n2, (short)-1);
                bl = bl3 = true;
                break block13;
            }
            bl = bl3;
        }
        if (bl) {
            NPCConversationManager nPCConversationManager = a4;
            nPCConversationManager.sendOk(MapleMount.addMonsterPet(a22.getId(), a3));
            nPCConversationManager.dispose();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(MapleImp.ALLATORIxDEMO("\u60f8\u973f\u89d1\u4e3f\u505b"));
        n2 = arrayList.size() - 1;
        int a22 = 0;
        int n3 = a22;
        while (n3 < arrayList.size()) {
            a3 = (Integer)arrayList.get(a22);
            ((StringBuilder)object).append("#i" + a3 + "#");
            if (n2 != a22) {
                ((StringBuilder)object).append(InventoryException.ALLATORIxDEMO("A\u626cA"));
            }
            n3 = ++a22;
        }
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.sendOk(((StringBuilder)object).toString());
        nPCConversationManager.dispose();
    }

    public /* synthetic */ void sendGetNumber(String a2, int a3, int a4, int a5) {
        NPCConversationManager a6;
        if (a6.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a6.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a6;
        nPCConversationManager.c.getPlayer().clearNpcSelect();
        nPCConversationManager.c.getPlayer().addNpcSelect(-999999999);
        nPCConversationManager.c.getPlayer().setCheckSelectionMin(a4);
        nPCConversationManager.c.getPlayer().setCheckSelectionMax(a5);
        nPCConversationManager.c.getPlayer().setCheckSelection(true);
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalkNum(a6.E, a2, a3, a4, a5));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendGetNumber;
    }

    public /* synthetic */ long getBlackJackTotalBet() {
        return BlackJack.getInstance().getTotalBet();
    }

    public /* synthetic */ int gachapon(int a22) {
        NPCConversationManager a3;
        MapleGachaponItem mapleGachaponItem = MapleGachapon.randomItem(a22);
        String a22 = MapleGachapon.getGachaponName(a22);
        if (mapleGachaponItem == null) {
            return -1;
        }
        int n2 = MapleGachapon.gainItem(mapleGachaponItem);
        IItem iItem = MapleInventoryManipulator.addbyId_Gachapon(a3.c, mapleGachaponItem.getItemId(), (short)n2, false);
        if (iItem == null) {
            return -1;
        }
        if (mapleGachaponItem.getSmegaType() > -1) {
            World.Broadcast.broadcastEtcSmega(a3.c.getWorld(), MaplePacketCreator.getGachaponMega(a3.c.getPlayer().getName() + " : x" + n2 + "\u606d\u559c" + a3.c.getPlayer().getName() + "\u5f9e" + a22 + "\u7372\u5f97\u3002", iItem, a3.c.getChannel(), a3.c.getPlayer().getName()));
        }
        return iItem.getItemId();
    }

    @Override
    public /* synthetic */ void print(String a2) {
        NPCConversationManager a3;
        if (a3.c.getPlayer().isGM()) {
            a3.c.getPlayer().dropMessage(1, "[Npc_Debug]" + a2);
        }
        System.out.println(a2);
    }

    public final /* synthetic */ short getDecorations() {
        return AramiaFireWorks.getInstance().getDecsPercentage();
    }

    public /* synthetic */ int gainGachaponItem(int a2222, int a3, String a4) {
        IItem a2222;
        block5: {
            int a2222;
            NPCConversationManager a5;
            block4: {
                try {
                    if (MapleItemInformationProvider.getInstance().itemExists(a2222)) break block4;
                    return -1;
                }
                catch (Exception a2222) {
                    return -1;
                }
            }
            a2222 = MapleInventoryManipulator.addbyId_Gachapon(a5.c, a2222, (short)a3, false);
            if (a2222 != null) break block5;
            return -1;
        }
        return a2222.getItemId();
    }

    public /* synthetic */ void OwlAdv(int a2, int a3) {
        NPCConversationManager a4;
        InventoryHandler.owlse(a4.c, a2, a3);
    }

    public /* synthetic */ void unequip(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().unequip(a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ String EnchantCashEqipAnnMS(byte a, int a) {
        var3_4 = (Equip)((Equip)a.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a)).copy();
        a = (byte)a.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a).getItemId();
        var4_5 = MapleItemInformationProvider.getInstance().isCash(a);
        var5_6 = "";
        if (var4_5 == 0) return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
        var5_6 = (String)var5_6 + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + a + "##k\r\n";
        var5_6 = (String)var5_6 + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
        var5_6 = (String)var5_6 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        a = new LinkedList<Integer>();
        v0 = var4_5 = 0;
        while (true) {
            if (v0 >= a) {
                var5_6 = (String)var5_6 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
                var5_6 = (String)var5_6 + "\u8acb\u554f\u60a8\u662f\u5426\u8981\u4f7f\u7528\u672c\u6b21\u9644\u9b54\u6548\u679c?\r\n#d#L1#[\u76f4\u63a5\u9644\u9b54]#l \r\n#L2#[\u4e0d\u5b58\u53d6\u9644\u9b54]#l\r\n\r\n#d\u82e5\u88dd\u5099\u7d20\u8cea\u672a\u6539\u8b8a,\u8acb\u91cd\u65b0\u767b\u5165\u6216\u63db\u983b\u5373\u53ef\u751f\u6548!";
                v1 = var3_4;
                var4_5 = StringTool.getIntFromString(v1.getOwner());
                v1.setOwner("\u5df2\u9644\u9b54" + ++var4_5 + "\u6b21");
                a.ALLATORIxDEMO = (Equip)var3_4.copy();
                return var5_6;
            }
            var6_7 = Randomizer.rand(0, 12);
            while (a.contains(var6_7 = Randomizer.rand(0, 12))) {
            }
            v2 = var6_7;
            a.add(Integer.valueOf(v2));
            if (v2 != 6 && var6_7 != 7) ** GOTO lbl52
            var7_8 = Randomizer.rand(0, 100);
            if (a == 2 && var7_8 < 85) {
                var6_7 = Randomizer.rand(0, 12);
                while (a.contains(var6_7 = Randomizer.rand(0, 12))) {
                }
                v3 = var6_7;
                v4 = v3;
                a.add(Integer.valueOf(v3));
            } else if (a == 3 && var7_8 < 70) {
                var6_7 = Randomizer.rand(0, 12);
                while (a.contains(var6_7 = Randomizer.rand(0, 12))) {
                }
                v5 = var6_7;
                v4 = v5;
                a.add(Integer.valueOf(v5));
            } else {
                if (a == 4 && var7_8 < 50) {
                    var6_7 = Randomizer.rand(0, 12);
                    while (a.contains(var6_7 = Randomizer.rand(0, 12))) {
                    }
                    a.add(Integer.valueOf(var6_7));
                }
lbl52:
                // 4 sources

                v4 = var6_7;
            }
            switch (v4) {
                case 0: {
                    var7_8 = (short)Randomizer.rand(-5, 5);
                    v6 = var3_4;
                    v6.setStr((v6.getStr() + var7_8 > 0 ? var3_4.getStr() + var7_8 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u529b\u91cf + " + var7_8 + "\r\n";
                    break;
                }
                case 1: {
                    var6_7 = (short)Randomizer.rand(-5, 5);
                    v7 = var3_4;
                    v7.setDex((v7.getDex() + var6_7 > 0 ? var3_4.getDex() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u654f\u6377:  " + var6_7 + "\r\n";
                    break;
                }
                case 2: {
                    var6_7 = (short)Randomizer.rand(-5, 5);
                    v8 = var3_4;
                    v8.setInt((v8.getInt() + var6_7 > 0 ? var3_4.getInt() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u667a\u529b:  " + var6_7 + "\r\n";
                    break;
                }
                case 3: {
                    var6_7 = (short)Randomizer.rand(-5, 5);
                    v9 = var3_4;
                    v9.setLuk((v9.getLuk() + var6_7 > 0 ? var3_4.getLuk() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u5e78\u904b:  " + var6_7 + "\r\n";
                    break;
                }
                case 4: {
                    var6_7 = (short)Randomizer.rand(-150, 150);
                    v10 = var3_4;
                    v10.setHp((v10.getHp() + var6_7 > 0 ? var3_4.getHp() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "HP:  " + var6_7 + "\r\n";
                    break;
                }
                case 5: {
                    var6_7 = (short)Randomizer.rand(-150, 150);
                    v11 = var3_4;
                    v11.setMp((v11.getMp() + var6_7 > 0 ? var3_4.getMp() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "MP:  " + var6_7 + "\r\n";
                    break;
                }
                case 6: {
                    var6_7 = 0;
                    var7_8 = Randomizer.rand(1, 100);
                    var6_7 = a == 2 ? (var7_8 < 85 ? 1 : (85 < var7_8 && var7_8 < 97 ? 2 : 3)) : (a == 3 ? (var7_8 < 70 ? 1 : (70 < var7_8 && var7_8 < 90 ? 2 : 3)) : (var7_8 < 50 ? 1 : (50 < var7_8 && var7_8 < 85 ? 2 : 3)));
                    if (Randomizer.nextBoolean()) {
                        var6_7 = -var6_7;
                    }
                    v12 = var3_4;
                    v12.setWatk((v12.getWatk() + var6_7 > 0 ? var3_4.getWatk() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u7269\u7406\u653b\u64ca:  " + var6_7 + "\r\n";
                    break;
                }
                case 7: {
                    var6_7 = 0;
                    var7_8 = Randomizer.rand(1, 100);
                    var6_7 = a == 2 ? (var7_8 < 85 ? 1 : (85 < var7_8 && var7_8 < 97 ? 2 : 3)) : (a == 3 ? (var7_8 < 70 ? 1 : (70 < var7_8 && var7_8 < 90 ? 2 : 3)) : (var7_8 < 50 ? 1 : (50 < var7_8 && var7_8 < 85 ? 2 : 3)));
                    if (Randomizer.nextBoolean()) {
                        var6_7 = -var6_7;
                    }
                    v13 = var3_4;
                    v13.setMatk((v13.getMatk() + var6_7 > 0 ? var3_4.getMatk() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u9b54\u6cd5\u653b\u64ca:  " + var6_7 + "\r\n";
                    break;
                }
                case 8: {
                    var6_7 = (short)Randomizer.rand(-50, 50);
                    v14 = var3_4;
                    v14.setWdef((v14.getWdef() + var6_7 > 0 ? var3_4.getWdef() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u7269\u7406\u9632\u79a6 + " + var6_7 + "\r\n";
                    break;
                }
                case 9: {
                    var6_7 = (short)Randomizer.rand(-50, 50);
                    v15 = var3_4;
                    v15.setMdef((v15.getMdef() + var6_7 > 0 ? var3_4.getMdef() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u9b54\u6cd5\u9632\u79a6:  " + var6_7 + "\r\n";
                    break;
                }
                case 10: {
                    var6_7 = (short)Randomizer.rand(-15, 15);
                    v16 = var3_4;
                    v16.setAcc((v16.getAcc() + var6_7 > 0 ? var3_4.getAcc() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u547d\u4e2d\u7387:  " + var6_7 + "\r\n";
                    break;
                }
                case 11: {
                    var6_7 = (short)Randomizer.rand(-15, 15);
                    v17 = var3_4;
                    v17.setSpeed((v17.getSpeed() + var6_7 > 0 ? var3_4.getSpeed() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u79fb\u52d5\u901f\u5ea6:  " + var6_7 + "\r\n";
                    break;
                }
                default: {
                    var6_7 = (short)Randomizer.rand(-5, 5);
                    v18 = var3_4;
                    v18.setJump((v18.getJump() + var6_7 > 0 ? var3_4.getJump() + var6_7 : 0) ? 1 : 0);
                    var5_6 = (String)var5_6 + "\u8df3\u8e8d\u529b:  " + var6_7 + "\r\n";
                }
            }
            v0 = ++var4_5;
        }
    }

    public /* synthetic */ void FileoutputUtil(String a2) {
        NPCConversationManager a3;
        FileoutputUtil.logToFile("logs/NPC/" + a3.getNpc() + ".txt", "\r\n \u73a9\u5bb6:" + a3.c.getPlayer().getName() + " " + a2);
    }

    public /* synthetic */ void forceStartQuest() {
        NPCConversationManager a2;
        MapleQuest.getInstance(a2.g).forceStart(a2.getPlayer(), a2.getNpc(), null);
    }

    public /* synthetic */ void warpPartyWithExpMeso(int a222, int a3, int a4) {
        NPCConversationManager a5;
        NPCConversationManager nPCConversationManager = a5;
        MapleMap a222 = nPCConversationManager.getMap(a222);
        for (MaplePartyCharacter maplePartyCharacter : nPCConversationManager.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a5.c.getChannelServer().getPlayerStorage().getCharacterByName(maplePartyCharacter.getName());
            if ((serializable.getEventInstance() != null || a5.getPlayer().getEventInstance() != null) && serializable.getEventInstance() != a5.getPlayer().getEventInstance()) continue;
            MapleCharacter mapleCharacter = serializable;
            MapleMap mapleMap = a222;
            mapleCharacter.changeMap(mapleMap, mapleMap.getPortal(0));
            mapleCharacter.gainExp(a3, true, false, true);
            serializable.gainMeso(a4, true);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ String EnchantEqipp(byte a, int a) {
        var3_4 = (Equip)a.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a);
        a = (byte)a.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a).getItemId();
        var4_5 = MapleItemInformationProvider.getInstance().isCash(a);
        var5_6 = "";
        if (var4_5 == 0) return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
        var5_6 = (String)var5_6 + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + a + "##k\r\n";
        var5_6 = (String)var5_6 + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
        var5_6 = (String)var5_6 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        a = new LinkedList<Integer>();
        v0 = var4_5 = 0;
        while (true) {
            if (v0 >= a) {
                var5_6 = (String)var5_6 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
                var5_6 = (String)var5_6 + "\u8acb\u554f\u60a8\u662f\u5426\u8981\u518d\u6263\u9664\u4e00\u6b21\u6d88\u8017\u54c1\u91cd\u65b0\u9644\u9b54?\r\n#d[\u9ede\u9078#r\u662f#d,\u91cd\u65b0\u9644\u9b54] [\u9ede\u9078#r\u5426#d,\u5b58\u53d6\u76ee\u524d\u9644\u9b54]\r\n#d\u82e5\u88dd\u5099\u7d20\u8cea\u672a\u6539\u8b8a,\u8acb\u91cd\u65b0\u767b\u5165\u6216\u63db\u983b\u5373\u53ef\u751f\u6548!";
                a.c.getPlayer().equipChanged();
                return var5_6;
            }
            var6_7 = Randomizer.rand(0, 12);
            while (a.contains(var6_7 = Randomizer.rand(0, 12))) {
            }
            v1 = var6_7;
            a.add(v1);
            if (v1 != 6 && var6_7 != 7) ** GOTO lbl33
            var7_8 = Randomizer.rand(0, 100);
            if (a == 2 && var7_8 < 85) {
                v2 = var6_7 = Randomizer.rand(0, 12);
            } else if (a == 3 && var7_8 < 70) {
                v2 = var6_7 = Randomizer.rand(0, 12);
            } else {
                if (a == 4 && var7_8 < 50) {
                    var6_7 = Randomizer.rand(0, 12);
                }
lbl33:
                // 4 sources

                v2 = var6_7;
            }
            switch (v2) {
                case 0: {
                    v3 = var7_8 = (short)((short)Randomizer.rand(1, 5));
                    var3_4.setStr(v3);
                    var5_6 = (String)var5_6 + "\u529b\u91cf + " + v3 + "\r\n";
                    break;
                }
                case 1: {
                    v4 = var6_7 = (int)((short)Randomizer.rand(1, 5));
                    var3_4.setDex((short)v4);
                    var5_6 = (String)var5_6 + "\u654f\u6377:  " + (short)v4 + "\r\n";
                    break;
                }
                case 2: {
                    v5 = var6_7 = (int)((short)Randomizer.rand(1, 5));
                    var3_4.setInt((short)v5);
                    var5_6 = (String)var5_6 + "\u667a\u529b:  " + (short)v5 + "\r\n";
                    break;
                }
                case 3: {
                    v6 = var6_7 = (int)((short)Randomizer.rand(1, 5));
                    var3_4.setLuk((short)v6);
                    var5_6 = (String)var5_6 + "\u5e78\u904b:  " + (short)v6 + "\r\n";
                    break;
                }
                case 4: {
                    v7 = var6_7 = (int)((short)Randomizer.rand(50, 150));
                    var3_4.setHp((short)v7);
                    var5_6 = (String)var5_6 + "HP:  " + (short)v7 + "\r\n";
                    break;
                }
                case 5: {
                    v8 = var6_7 = (int)((short)Randomizer.rand(50, 150));
                    var3_4.setMp((short)v8);
                    var5_6 = (String)var5_6 + "MP:  " + (short)v8 + "\r\n";
                    break;
                }
                case 6: {
                    var6_7 = 0;
                    var7_8 = Randomizer.rand(1, 100);
                    if (a == 2) {
                        if (var7_8 < 85) {
                            var6_7 = 1;
                            v9 = var3_4;
                        } else if (85 < var7_8 && var7_8 < 97) {
                            var6_7 = 2;
                            v9 = var3_4;
                        } else {
                            var6_7 = 3;
                            v9 = var3_4;
                        }
                    } else if (a == 3) {
                        if (var7_8 < 70) {
                            var6_7 = 1;
                            v9 = var3_4;
                        } else if (70 < var7_8 && var7_8 < 90) {
                            var6_7 = 2;
                            v9 = var3_4;
                        } else {
                            var6_7 = 3;
                            v9 = var3_4;
                        }
                    } else if (var7_8 < 50) {
                        var6_7 = 1;
                        v9 = var3_4;
                    } else if (50 < var7_8 && var7_8 < 85) {
                        var6_7 = 2;
                        v9 = var3_4;
                    } else {
                        var6_7 = 3;
                        v9 = var3_4;
                    }
                    v9.setWatk((short)var6_7);
                    var5_6 = (String)var5_6 + "\u7269\u7406\u653b\u64ca:  " + (short)var6_7 + "\r\n";
                    break;
                }
                case 7: {
                    var6_7 = 0;
                    var7_8 = Randomizer.rand(1, 100);
                    if (a == 2) {
                        if (var7_8 < 85) {
                            var6_7 = 1;
                            v10 = var3_4;
                        } else if (85 < var7_8 && var7_8 < 97) {
                            var6_7 = 2;
                            v10 = var3_4;
                        } else {
                            var6_7 = 3;
                            v10 = var3_4;
                        }
                    } else if (a == 3) {
                        if (var7_8 < 70) {
                            var6_7 = 1;
                            v10 = var3_4;
                        } else if (70 < var7_8 && var7_8 < 90) {
                            var6_7 = 2;
                            v10 = var3_4;
                        } else {
                            var6_7 = 3;
                            v10 = var3_4;
                        }
                    } else if (var7_8 < 50) {
                        var6_7 = 1;
                        v10 = var3_4;
                    } else if (50 < var7_8 && var7_8 < 85) {
                        var6_7 = 2;
                        v10 = var3_4;
                    } else {
                        var6_7 = 3;
                        v10 = var3_4;
                    }
                    v10.setMatk((short)var6_7);
                    var5_6 = (String)var5_6 + "\u9b54\u6cd5\u653b\u64ca:  " + (short)var6_7 + "\r\n";
                    break;
                }
                case 8: {
                    v11 = var6_7 = (int)((short)Randomizer.rand(20, 50));
                    var3_4.setWdef((short)v11);
                    var5_6 = (String)var5_6 + "\u7269\u7406\u9632\u79a6 + " + (short)v11 + "\r\n";
                    break;
                }
                case 9: {
                    v12 = var6_7 = (int)((short)Randomizer.rand(20, 50));
                    var3_4.setMdef((short)v12);
                    var5_6 = (String)var5_6 + "\u9b54\u6cd5\u9632\u79a6:  " + (short)v12 + "\r\n";
                    break;
                }
                case 10: {
                    v13 = var6_7 = (int)((short)Randomizer.rand(1, 15));
                    var3_4.setAcc((short)v13);
                    var5_6 = (String)var5_6 + "\u547d\u4e2d\u7387:  " + (short)v13 + "\r\n";
                    break;
                }
                case 11: {
                    v14 = var6_7 = (int)((short)Randomizer.rand(1, 15));
                    var3_4.setSpeed((short)v14);
                    var5_6 = (String)var5_6 + "\u79fb\u52d5\u901f\u5ea6:  " + (short)v14 + "\r\n";
                    break;
                }
                default: {
                    v15 = var6_7 = (int)((short)Randomizer.rand(1, 5));
                    var3_4.setJump((short)v15);
                    var5_6 = (String)var5_6 + "\u8df3\u8e8d\u529b:  " + (short)v15 + "\r\n";
                }
            }
            v0 = ++var4_5;
        }
    }

    public /* synthetic */ void setNPCOtherAction(int a22, String a3) {
        NPCConversationManager a4;
        MapleMap mapleMap = a4.c.getPlayer().getMap();
        MapleNPC a22 = mapleMap.getNPCById(a22);
        if (mapleMap == null || a22 == null) {
            return;
        }
        a4.c.sendPacket(MaplePacketCreator.setNPCSpecialAction(a22.getObjectId(), a3, -1, false));
    }

    public /* synthetic */ void sendNextNoESC(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.sendNextS(a2, (byte)1, nPCConversationManager.E);
    }

    public /* synthetic */ void sendPrev(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000ep\u000f`"), (byte)0));
        a3.a = 0;
    }

    public /* synthetic */ void showSpeedRank(int a2, boolean a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showSpeedRanks(nPCConversationManager.E, MapleRanking.getInstance().getSpeedRank(a2, a3)));
    }

    public /* synthetic */ boolean registerSquad(String a2, int a3, String a4) {
        NPCConversationManager a5;
        MapleSquad mapleSquad = new MapleSquad(a5.c.getWorld(), a5.c.getChannel(), (String)a2, a5.c.getPlayer(), a3 * 60 * 1000, a4);
        boolean bl = a5.c.getChannelServer().addMapleSquad(mapleSquad, (String)a2);
        if (bl) {
            MapleMap mapleMap;
            MapleMap mapleMap2 = mapleMap = a5.c.getPlayer().getMap();
            mapleMap2.broadcastMessage(MaplePacketCreator.getClock(a3 * 60));
            mapleMap2.broadcastMessage(MaplePacketCreator.getItemNotice(a5.c.getPlayer().getName() + a4));
            return bl;
        }
        if (((String)a2).contains(MapleImp.ALLATORIxDEMO("w?M>K1V<"))) {
            MapleMapFactory mapleMapFactory = ChannelServer.getInstance(a5.c.getWorld(), a5.c.getChannel()).getMapFactory();
            int[] arrn = new int[3];
            arrn[0] = 240060000;
            arrn[1] = 240060100;
            arrn[2] = 240060200;
            a2 = arrn;
            a3 = 0;
            int n2 = a4 = 0;
            while (n2 < ((Object)a2).length) {
                MapleMap mapleMap = mapleMapFactory.getMap((int)a2[a4]);
                a3 += mapleMap.getCharactersSize();
                n2 = ++a4;
            }
            if (a3 == 0) {
                mapleSquad.clear();
            }
        } else {
            mapleSquad.clear();
        }
        return bl;
    }

    public /* synthetic */ void UpdateDropChance(int a2, int a3, int a4) {
        MapleMonsterInformationProvider.getInstance().UpdateDropChance(a2, a3, a4);
    }

    public final /* synthetic */ void cameraOnCharacter(int a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_CameraOnCharacter.getValue(), null, arrn);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ int getEquipLevelBlack(String a2) {
        int n2;
        int n3;
        block18: {
            n3 = 0;
            int n4 = -1;
            switch (a2.hashCode()) {
                case 9733: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664"))) break;
                    n2 = n4 = 0;
                    break block18;
                }
                case 311456: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u263a\u2655"))) break;
                    n2 = n4 = 1;
                    break block18;
                }
                case 9664869: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664"))) break;
                    n2 = n4 = 2;
                    break block18;
                }
                case 299620672: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u263a\u2655\u263a\u2655"))) break;
                    n2 = n4 = 3;
                    break block18;
                }
                case 698315973: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664\u267f\u2664"))) break;
                    n2 = n4 = 4;
                    break block18;
                }
                case 172968416: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u263a\u2655\u263a\u2655\u263a\u2655"))) break;
                    n2 = n4 = 5;
                    break block18;
                }
                case 1067063333: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664\u267f\u2664\u267f\u2664"))) break;
                    n4 = 6;
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
            case 4: {
                return 5;
            }
            case 5: {
                return 6;
            }
            case 6: {
                return 7;
            }
        }
        return n3;
    }

    public /* synthetic */ void \u958b\u555f\u5c0f\u92fc\u73e0() {
        NPCConversationManager a2;
        a2.c.sendPacket(BeansPacket.showBeans(a2.getPlayer().getBeans()));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ Map<String, String> ShowEventCount() {
        string = "";
        n2 = 0;
        hashMap = new HashMap<String, String>();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(MapleImp.ALLATORIxDEMO("\u0003z\u001cz\u0013kp\u0015py\u0002p\u001d\u001f0Z&Z>K\u000f\\?J>K0\u001f\u0007w\u0015m\u0015\u001f0\\8^\"^3K5M9[0\u001fm\u001fo"));
        preparedStatement.setInt(1, a2.getPlayer().getId());
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            stringBuilder = new StringBuilder();
            v1 = resultSet;
            string = v1.getString(InventoryException.ALLATORIxDEMO("\u0004\f\u0004\u0014\u0015\u0014\u0000\u0017\u0004"));
            n2 = v1.getInt(MapleImp.ALLATORIxDEMO("\\?R S5K5[$V=Z#"));
            stringBuilder.append("#d\u6d3b\u52d5\u540d\u7a31 #k#fUI/UIWindow/Quest/icon6/7# #r" + string + "#k #b#k\r\n");
            stringBuilder.append("#b \u3000\u5b8c\u6210\u7d2f\u7a4d\u6b21\u6578#k #fUI/UIWindow/Quest/icon8/0# #r" + n2 + "#k  ");
            stringBuilder.append("#b\u4eca\u65e5\u5b8c\u6210\u6b21\u6578#k #fUI/UIWindow/Quest/icon8/0# #r" + a2.c.getPlayer().getBossLogReload(string) + "#k#l\r\n");
            hashMap.put(string, stringBuilder.toString());
            v0 = resultSet;
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
                catch (SQLException sQLException) {
                    System.err.println("\u672a\u80fd\u986f\u793a\u89d2\u8272" + a2.getPlayer().getId() + "\u6d3b\u52d5\u5b8c\u6210\u6b21\u6578");
                }
            }
        }
        return hashMap;
    }

    public /* synthetic */ void forcedFlip(int a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedFlip.getValue(), null, arrn);
    }

    public /* synthetic */ void expandInventory(byte a2, int a3) {
        NPCConversationManager a4;
        a4.c.getPlayer().expandInventory(a2, a3);
    }

    public /* synthetic */ String BlackJackBet(int a2) {
        NPCConversationManager a3;
        return BlackJack.getInstance().bet(a3.c.getPlayer(), a2);
    }

    public /* synthetic */ void sendLeftPlayerNoESC(String a2, int a3) {
        NPCConversationManager a4;
        a4.sendNextS(a2, (byte)17, a3);
    }

    public /* synthetic */ String EnchantCashEqipBadDog(byte a2, int a2222, int a3) {
        NPCConversationManager a4;
        Equip equip;
        Equip equip2 = equip = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        if (bl) {
            if (!a4.c.getPlayer().haveItem(a2222, a3)) {
                return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a2222 + "# " + a3 + "\u500b!";
            }
            a4.c.getPlayer().gainItem(a2222, -a3);
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            LinkedList a2222 = new LinkedList();
            int a2222 = Randomizer.rand(-3, 3);
            short s2 = (short)(equip2.getStr() + a2222);
            a3 = s2;
            if (s2 > 10) {
                a3 = 10;
            }
            equip2.setStr((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u529b\u91cf + " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-3, 3);
            short s3 = (short)(equip2.getDex() + a2222);
            a3 = s3;
            if (s3 > 10) {
                a3 = 10;
            }
            equip2.setDex((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u654f\u6377 +  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-3, 3);
            short s4 = (short)(equip2.getInt() + a2222);
            a3 = s4;
            if (s4 > 10) {
                a3 = 10;
            }
            equip2.setInt((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u667a\u529b +  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-3, 3);
            short s5 = (short)(equip2.getLuk() + a2222);
            a3 = s5;
            if (s5 > 10) {
                a3 = 10;
            }
            equip2.setLuk((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u5e78\u904b +  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-1, 1);
            short s6 = (short)(equip2.getWatk() + a2222);
            a3 = s6;
            if (s6 > 5) {
                a3 = 5;
            }
            equip2.setWatk((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u7269\u7406\u653b\u64ca +  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-1, 1);
            short s7 = (short)(equip2.getMatk() + a2222);
            a3 = s7;
            if (s7 > 5) {
                a3 = 5;
            }
            equip2.setMatk((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca +  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-10, 10);
            short s8 = (short)(equip2.getWdef() + a2222);
            a3 = s8;
            if (s8 > 100) {
                a3 = 100;
            }
            equip2.setWdef((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u7269\u7406\u9632\u79a6 + " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-10, 10);
            short s9 = (short)(equip2.getMdef() + a2222);
            a3 = s9;
            if (s9 > 100) {
                a3 = 100;
            }
            equip2.setMdef((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u9b54\u6cd5\u9632\u79a6:  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-3, 3);
            short s10 = (short)(equip2.getSpeed() + a2222);
            a3 = s10;
            if (s10 > 30) {
                a3 = 30;
            }
            Equip equip3 = equip2;
            equip3.setSpeed((short)(equip3.getSpeed() + a2222 > 0 ? equip2.getSpeed() + a2222 : 0));
            object = (String)object + "\u79fb\u52d5\u901f\u5ea6:  " + (short)a2222 + "\r\n";
            a2222 = (short)Randomizer.rand(-3, 3);
            short s11 = (short)(equip2.getJump() + a2222);
            a3 = s11;
            if (s11 > 30) {
                a3 = 30;
            }
            equip2.setJump((short)(a3 > 0 ? a3 : 0));
            object = (String)object + "\u8df3\u8e8d\u529b:  " + (short)a2222 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip4 = equip2;
            a2222 = StringTool.getIntFromString(equip4.getOwner());
            equip4.setOwner("\u5df2\u9644\u9b54" + ++a2222 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), equip, false);
            a4.c.getPlayer().equipChanged();
            return object;
        }
        return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
    }

    public /* synthetic */ void sendYesNoS(String a2, byte a3) {
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        if (a2.contains(MapleImp.ALLATORIxDEMO("\u001c\u001c"))) {
            a4.sendSimpleS(a2, a3);
            return;
        }
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, MaplePacketOperation.NPCStatus.sendYesNo, a2, "", a3));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendYesNo;
    }

    public /* synthetic */ boolean foundData(int a2, String a3) {
        return SearchGenerator.foundData(a2, a3);
    }

    public /* synthetic */ void removeNPCRequestController(int a2) {
        NPCConversationManager a3;
        if (!npcRequestController.containsKey(new Pair<Integer, MapleClient>(a2, a3.c))) {
            return;
        }
        MapleNPC mapleNPC = npcRequestController.get(new Pair<Integer, MapleClient>(a2, a3.c));
        a3.c.sendPacket(MaplePacketCreator.removeNPCController(mapleNPC.getObjectId()));
        a3.c.sendPacket(MaplePacketCreator.removeNPC(mapleNPC.getObjectId()));
        npcRequestController.remove(new Pair<Integer, MapleClient>(a2, a3.c));
    }

    public /* synthetic */ void forfeitQuest() {
        NPCConversationManager a2;
        MapleQuest.getInstance(a2.g).forfeit(a2.getPlayer());
    }

    public /* synthetic */ void sendNextPrevS(String a2, byte a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.sendNextPrevS(a2, a3, nPCConversationManager.E);
    }

    public /* synthetic */ String EnchantHp(byte a2) {
        NPCConversationManager a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int s2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean object = MapleItemInformationProvider.getInstance().isCash(s2);
        short s3 = ItemConstants.\u985e\u578b.\u62ab\u98a8((int)s2) && !object ? (short)1 : 0;
        Object object2 = "";
        int n2 = 3500;
        int n3 = StringTool.getIntFromString(equip2.getOwner());
        if (n3 >= n2) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u62d1\u98c9\u883a\u91ae\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (s3 != 0) {
            object2 = (String)object2 + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u62ab\u98a8\u70ba#b#z" + s2 + "##k\r\n";
            object2 = (String)object2 + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object2 = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            short s4 = (short)Randomizer.rand(8, 15);
            Equip equip3 = equip2;
            s3 = (short)(equip3.getHp() + s4);
            equip3.setHp(s3 > n2 ? (short)n2 : s3);
            object2 = (String)object2 + "\u8840\u91cf:  " + s4 + "\r\n";
            object2 = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316HP[" + (n3 += s4) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object2;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u6294\u98f8\u5508q\u50fa\u6759\u6294\u98f8\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void changeStat(byte a22, int a3, int a4) {
        NPCConversationManager nPCConversationManager;
        NPCConversationManager a5;
        Equip a22 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIPPED).getItem(a22);
        switch (a3) {
            case 0: {
                a22.setStr((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 1: {
                a22.setDex((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 2: {
                a22.setInt((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 3: {
                a22.setLuk((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 4: {
                a22.setHp((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 5: {
                a22.setMp((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 6: {
                a22.setWatk((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 7: {
                a22.setMatk((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 8: {
                a22.setWdef((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 9: {
                a22.setMdef((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 10: {
                a22.setAcc((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 11: {
                a22.setAvoid((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 12: {
                a22.setHands((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 13: {
                a22.setSpeed((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 14: {
                a22.setJump((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 15: {
                a22.setUpgradeSlots((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 16: {
                a22.setViciousHammer((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 17: {
                a22.setLevel((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 18: {
                a22.setEnhance((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 19: {
                a22.setPotential1(a4);
                nPCConversationManager = a5;
                break;
            }
            case 20: {
                a22.setPotential2(a4);
                nPCConversationManager = a5;
                break;
            }
            case 21: {
                a22.setPotential3(a4);
                nPCConversationManager = a5;
                break;
            }
            case 22: {
                a22.setOwner(a5.getText());
                nPCConversationManager = a5;
                break;
            }
            default: {
                nPCConversationManager = a5;
            }
        }
        nPCConversationManager.c.getPlayer().equipChanged();
    }

    @Override
    public /* synthetic */ int getPartyBossLog(String a2) {
        NPCConversationManager a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getParty() != null) {
            for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
                if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
                MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId());
                arrayList.add(mapleCharacter.getBossLog(a2));
            }
        } else {
            return a3.getBossLog(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public /* synthetic */ void setFace(int a2) {
        if (NPCConversationManager.faceExists(a2)) {
            NPCConversationManager a3;
            NPCConversationManager nPCConversationManager = a3;
            nPCConversationManager.getPlayer().setFace(a2);
            nPCConversationManager.getPlayer().updateSingleStat(MapleStat.FACE, a2);
            nPCConversationManager.getPlayer().equipChanged();
        }
    }

    public /* synthetic */ void safeDispose() {
        a.pendingDisposal = true;
    }

    public /* synthetic */ void warpBack(int a2, final int a3, int a4) {
        NPCConversationManager a5;
        NPCConversationManager nPCConversationManager = a5;
        MapleMap mapleMap = a2 = nPCConversationManager.c.getChannelServer().getMapFactory().getMap(a2);
        nPCConversationManager.c.getPlayer().changeMap(mapleMap, mapleMap.getPortal(0));
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getClock(a4));
        Timer.EventTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                3 a2;
                3 v0 = a2;
                MapleMap mapleMap = a2.NPCConversationManager.this.c.getChannelServer().getMapFactory().getMap(v0.a3);
                if (v0.NPCConversationManager.this.c.getPlayer() != null) {
                    3 v1 = a2;
                    v1.NPCConversationManager.this.c.sendPacket(MaplePacketCreator.stopClock());
                    MapleMap mapleMap2 = mapleMap;
                    v1.NPCConversationManager.this.c.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(0));
                    v1.NPCConversationManager.this.c.getPlayer().dropMessage(6, LoadPacket.ALLATORIxDEMO("\u5dc5\u7d80\u5207\u9047\u76d9\u7697\u5707\u4e95\u0016"));
                }
            }
            {
                3 a32;
            }
        }, 1000 * a4);
    }

    public /* synthetic */ boolean isPlayerInstance() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getEventInstance() != null;
    }

    public final /* synthetic */ List<StructPotentialItem> getPotentialName(String a4) {
        LinkedList<StructPotentialItem> linkedList = new LinkedList<StructPotentialItem>();
        for (Map.Entry<Integer, Map<Integer, StructPotentialItem>> entry : MapleItemInformationProvider.getInstance().getAllPotentialInfo().entrySet()) {
            if (entry.getValue().get(1) == null || !entry.getValue().get((Object)Integer.valueOf((int)1)).opString.contains(a4)) continue;
            linkedList.add(entry.getValue().get(1));
        }
        Collections.sort(linkedList, (a2, a3) -> a2.opID - a3.opID);
        return linkedList;
    }

    public /* synthetic */ void forceCompleteQuest() {
        NPCConversationManager a2;
        MapleQuest.getInstance(a2.g).forceComplete(a2.getPlayer(), a2.getNpc());
    }

    public /* synthetic */ void SeeMonsterPets(MapleCharacter a2) {
        int n2;
        NPCConversationManager a3;
        if (a3.getMap().getAllMonstersThreadsafe().size() <= 0) {
            NPCConversationManager nPCConversationManager = a3;
            nPCConversationManager.sendOk(InventoryException.ALLATORIxDEMO("Y\u5751\u576c\u4e6b\u6ce8\u6768\u6050\u7208\u549c@[\u3063"));
            nPCConversationManager.dispose();
        }
        List<MapleMonster> list = a3.getMap().getAllMonstersThreadsafe();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        String string = "\u73a9\u5bb6 #b" + a2.getName() + "#k \u6b64\u5730\u5716\u64c1\u6709\u7684\u602a\u7269\u70ba:\r\n#d";
        int n3 = n2 = 0;
        while (n3 < list.size()) {
            MapleMonster mapleMonster = list.get(n2);
            int n4 = mapleMonster.getId();
            if (!linkedList.contains(n4)) {
                linkedList.add(n4);
                if (!mapleMonster.isMonsterPet()) {
                    if (a2.isGM()) {
                        int n5 = n4;
                        string = string + "#L" + n5 + "##o" + n5 + "# \u602a\u7269\u4ee3\u78bc:" + n5 + " (\u9ede\u9078\u6355\u6349)#l\r\n";
                    } else if (!MapleLifeFactory.getMonster(n4).getStats().isBoss()) {
                        int n6 = n4;
                        string = string + "#L" + n6 + "##o" + n6 + "# \u602a\u7269\u4ee3\u78bc:" + n6 + " (\u9ede\u9078\u6355\u6349)#l\r\n";
                    }
                }
            }
            n3 = ++n2;
        }
        a3.sendOk(string);
    }

    public /* synthetic */ void equip(int a2, boolean a3, boolean a4) {
        NPCConversationManager a5;
        a5.c.getPlayer().equip(a2, a3, a4);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String MushroomCashEquipStar(byte a2, int a3, int a4) {
        Equip equip;
        NPCConversationManager a5;
        Equip equip2;
        Equip equip3 = equip2 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n2 = MapleItemInformationProvider.getInstance().isCash(n2) ? (byte)1 : 0;
        Object object = "";
        if (n2 == 0) return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bcV\u7140\u6caf\u5326\u7d60\u3063");
        if (!(equip3.getStr() == 0 && equip3.getDex() == 0 && equip3.getInt() == 0 && equip3.getLuk() == 0 && equip3.getHp() == 0 && equip3.getMp() == 0 && equip3.getWatk() == 0 && equip3.getMatk() == 0 && equip3.getWdef() == 0 && equip3.getMdef() == 0 && equip3.getAcc() == 0 && equip3.getSpeed() == 0 && equip3.getJump() == 0 || equip3.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2656")))) {
            return InventoryException.ALLATORIxDEMO("Y\u0013\u6b1e\u88bc\u50e3\u5d93\u6773\u7218\u6bf0\u809c\u52e1\u001f\u569a\u6b05\u715b\u6cb4\u533d\u7d7b\u549c@");
        }
        n2 = a5.getEquipLevel(equip3.getOwner());
        if (n2 >= 7) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (!a5.c.getPlayer().haveItem(a4)) {
            return "#r\u5347\u7d1a\u9700\u8981#i" + a4 + "# 1 \u500b!";
        }
        a5.c.getPlayer().gainItem(a4, -1);
        a4 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = Randomizer.rand(1, 14);
        if (n16 == 5 || n16 == 6) {
            n16 = Randomizer.rand(1, 14);
        }
        switch (Randomizer.rand(1, 14)) {
            case 1: {
                a4 = Randomizer.rand(1, 5);
                break;
            }
            case 2: {
                n3 = Randomizer.rand(1, 5);
                break;
            }
            case 3: {
                n4 = Randomizer.rand(1, 5);
                break;
            }
            case 4: {
                n5 = Randomizer.rand(1, 5);
                break;
            }
            case 5: {
                n6 = Randomizer.rand(1, 3);
                break;
            }
            case 6: {
                n7 = Randomizer.rand(1, 3);
                break;
            }
            case 7: {
                n8 = Randomizer.rand(15, 60);
                break;
            }
            case 8: {
                n9 = Randomizer.rand(15, 60);
                break;
            }
            case 9: {
                n10 = Randomizer.rand(50, 300);
                break;
            }
            case 10: {
                n11 = Randomizer.rand(50, 300);
                break;
            }
            case 11: {
                n12 = Randomizer.rand(1, 10);
                break;
            }
            case 12: {
                n13 = Randomizer.rand(1, 10);
                break;
            }
            case 13: {
                n14 = Randomizer.rand(1, 5);
                break;
            }
            case 14: {
                n15 = Randomizer.rand(1, 5);
                break;
            }
        }
        if (Randomizer.rand(0, 100) >= a3) {
            return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387 " + a3 + "%),\u6c92\u6709\u767c\u751f\u4efb\u4f55\u6539\u8b8a!";
        }
        if (a4 > 0) {
            Equip equip4 = equip3;
            equip = equip4;
            equip4.setStr((short)(equip4.getStr() + a4));
        } else if (n3 > 0) {
            Equip equip5 = equip3;
            equip = equip5;
            equip5.setDex((short)(equip5.getDex() + n3));
        } else if (n4 > 0) {
            Equip equip6 = equip3;
            equip = equip6;
            equip6.setInt((short)(equip6.getInt() + n4));
        } else if (n5 > 0) {
            Equip equip7 = equip3;
            equip = equip7;
            equip7.setLuk((short)(equip7.getLuk() + n5));
        } else if (n6 > 0) {
            Equip equip8 = equip3;
            equip = equip8;
            equip8.setWatk((short)(equip8.getWatk() + n6));
        } else if (n7 > 0) {
            Equip equip9 = equip3;
            equip = equip9;
            equip9.setMatk((short)(equip9.getMatk() + n7));
        } else if (n8 > 0) {
            Equip equip10 = equip3;
            equip = equip10;
            equip10.setWdef((short)(equip10.getWdef() + n8));
        } else if (n9 > 0) {
            Equip equip11 = equip3;
            equip = equip11;
            equip11.setMdef((short)(equip11.getMdef() + n9));
        } else if (n10 > 0) {
            Equip equip12 = equip3;
            equip = equip12;
            equip12.setHp((short)(equip12.getHp() + n10));
        } else if (n11 > 0) {
            Equip equip13 = equip3;
            equip = equip13;
            equip13.setMp((short)(equip13.getMp() + n11));
        } else if (n12 > 0) {
            Equip equip14 = equip3;
            equip = equip14;
            equip14.setAcc((short)(equip14.getAcc() + n12));
        } else if (n13 > 0) {
            Equip equip15 = equip3;
            equip = equip15;
            equip15.setAvoid((short)(equip15.getAvoid() + n13));
        } else if (n15 > 0) {
            Equip equip16 = equip3;
            equip = equip16;
            equip16.setJump((short)(equip16.getJump() + n15));
        } else {
            if (n14 > 0) {
                Equip equip17 = equip3;
                equip17.setSpeed((short)(equip17.getSpeed() + n14));
            }
            equip = equip3;
        }
        equip.setOwner(a5.getEquipStar(n2 + 1));
        equip2 = (Equip)equip3.copy();
        MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a5.getClient(), equip2, false);
        a5.c.getPlayer().equipChanged();
        object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + a3 + "%)\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a5.getEquipStar(n2 + 1) + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + equip3.getStr() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + equip3.getDex() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + equip3.getInt() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + equip3.getLuk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + equip3.getWatk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + equip3.getMatk() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u9632\u79a6\u529b:#r" + equip3.getWdef() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u9632\u79a6\u529b:#r" + equip3.getMdef() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8840\u91cf:#r" + equip3.getHp() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u529b:#r" + equip3.getMp() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u547d\u4e2d:#r" + equip3.getAcc() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8ff4\u907f:#r" + equip3.getAvoid() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u901f\u5ea6:#r" + equip3.getJump() + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u8df3\u8e8d:#r" + equip3.getSpeed() + "#b\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
        FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a5.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + equip2.getItemName() + "(" + equip2.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
        return object;
    }

    public /* synthetic */ boolean replaceItem(int a2, int a32, Object a4, int a5, String a6, boolean a7) {
        NPCConversationManager a8;
        MapleInventoryType a32 = MapleInventoryType.getByType((byte)a32);
        if (a32 == null) {
            return false;
        }
        IItem iItem = a8.getPlayer().getInventory(a32).getItem((byte)a2);
        if (iItem == null || a4 instanceof IItem) {
            iItem = (IItem)a4;
        }
        if (a5 > 0) {
            Object object;
            Object object2;
            if (a32 != MapleInventoryType.EQUIP) {
                return false;
            }
            a4 = (Equip)iItem;
            if (a7) {
                if (((Equip)a4).getUpgradeSlots() < 1) {
                    return false;
                }
                Object object3 = a4;
                ((Equip)object3).setUpgradeSlots((byte)(((Equip)object3).getUpgradeSlots() - 1));
            }
            if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("\u0003S?K#"))) {
                Object object4 = a4;
                object2 = object4;
                ((Equip)object4).setUpgradeSlots((byte)(((Equip)object4).getUpgradeSlots() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("-\u001f\u0017\u001f\r"))) {
                Object object5 = a4;
                object2 = object5;
                ((Equip)object5).setLevel((byte)(((Equip)object5).getLevel() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("w1R=Z\""))) {
                Object object6 = a4;
                object2 = object6;
                ((Equip)object6).setViciousHammer((byte)(((Equip)object6).getViciousHammer() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("2.3"))) {
                Object object7 = a4;
                object2 = object7;
                ((Equip)object7).setStr((short)(((Equip)object7).getStr() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("\u0014z\b"))) {
                Object object8 = a4;
                object2 = object8;
                ((Equip)object8).setDex((short)(((Equip)object8).getDex() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("(45"))) {
                Object object9 = a4;
                object2 = object9;
                ((Equip)object9).setInt((short)(((Equip)object9).getInt() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("\u001cj\u001b"))) {
                Object object10 = a4;
                object2 = object10;
                ((Equip)object10).setLuk((short)(((Equip)object10).getLuk() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("21"))) {
                Object object11 = a4;
                object2 = object11;
                ((Equip)object11).setHp((short)(((Equip)object11).getHp() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("r\u0000"))) {
                Object object12 = a4;
                object2 = object12;
                ((Equip)object12).setMp((short)(((Equip)object12).getMp() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("- .*"))) {
                Object object13 = a4;
                object2 = object13;
                ((Equip)object13).setWatk((short)(((Equip)object13).getWatk() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("r\u0011k\u001b"))) {
                Object object14 = a4;
                object2 = object14;
                ((Equip)object14).setMatk((short)(((Equip)object14).getMatk() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("-%?'"))) {
                Object object15 = a4;
                object2 = object15;
                ((Equip)object15).setWdef((short)(((Equip)object15).getWdef() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("r\u0014z\u0016"))) {
                Object object16 = a4;
                object2 = object16;
                ((Equip)object16).setMdef((short)(((Equip)object16).getMdef() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO(" 9\""))) {
                Object object17 = a4;
                object2 = object17;
                ((Equip)object17).setAcc((short)(((Equip)object17).getAcc() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("\u0011I?V4"))) {
                Object object18 = a4;
                object2 = object18;
                ((Equip)object18).setAvoid((short)(((Equip)object18).getAvoid() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO(")\u001b\u000f\u001e\u0012"))) {
                Object object19 = a4;
                object2 = object19;
                ((Equip)object19).setHands((short)(((Equip)object19).getHands() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("\u0003O5Z4"))) {
                Object object20 = a4;
                object2 = object20;
                ((Equip)object20).setSpeed((short)(((Equip)object20).getSpeed() + a5));
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("0\u0014\u0017\u0011"))) {
                Object object21 = a4;
                object2 = object21;
                ((Equip)object21).setJump((short)(((Equip)object21).getJump() + a5));
            } else if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("\u0019K5R\u0015g\u0000"))) {
                Object object22 = a4;
                object2 = object22;
                ((Equip)object22).setItemEXP(((Equip)object22).getItemEXP() + a5);
            } else if (a6.equalsIgnoreCase(InventoryException.ALLATORIxDEMO("?\u0019\n\b\b\u0000\u000e\b\u0015\u000f"))) {
                Object object23 = a4;
                object2 = object23;
                ((Item)object23).setExpiration(((Item)object23).getExpiration() + (long)a5);
            } else {
                if (a6.equalsIgnoreCase(MapleImp.ALLATORIxDEMO("y<^7"))) {
                    Object object24 = a4;
                    ((Item)object24).setFlag(((Item)object24).getFlag() + a5);
                }
                object2 = a4;
            }
            Object object25 = a4;
            if (((Item)object2).getExpiration() == -1L) {
                ((Item)object25).setFlag(((Item)a4).getFlag() | ItemFlag.LOCK.getValue());
                object = a4;
            } else {
                ((Item)object25).setFlag(((Item)a4).getFlag() | ItemFlag.UNTRADEABLE.getValue());
                object = a4;
            }
            iItem = ((Equip)object).copy();
        }
        NPCConversationManager nPCConversationManager = a8;
        MapleInventoryManipulator.removeFromSlot(nPCConversationManager.getClient(), a32, (short)a2, iItem.getQuantity(), false);
        return MapleInventoryManipulator.addFromDrop(nPCConversationManager.getClient(), iItem, false);
    }

    public final /* synthetic */ AttackFont.Font getFont() {
        NPCConversationManager a2;
        return AttackFont.getFont(a2.c.getPlayer().getId());
    }

    public /* synthetic */ String getInfo() {
        return Cryptocurrency.getInfo();
    }

    public /* synthetic */ void showCharacterRank(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showSpeedRanks(nPCConversationManager.E, MapleRanking.getInstance().getCharacterRank(a2)));
    }

    public /* synthetic */ void AddDropData(int a2, int a3, int a4, int a5) {
        MapleMonsterInformationProvider.getInstance().AddDropData(a2, a3, a4, a5);
    }

    public /* synthetic */ void sendPVPWindow() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.sendPVPWindow());
        nPCConversationManager.c.sendPacket(MaplePacketCreator.sendPVPMaps());
    }

    public /* synthetic */ String getScript() {
        NPCConversationManager a2;
        return a2.script;
    }

    public /* synthetic */ void addMaxMp(int a2) {
        NPCConversationManager a3;
        int n2 = a3.c.getPlayer().getStat().getMaxMp();
        a2 += n2;
        if (GameSetConstants.MAPLE_VERSION < 134) {
            if (a2 > 30000) {
                a2 = 30000;
            }
        } else if (a2 > 99999) {
            a2 = 99999;
        }
        ArrayList<Pair<MapleStat, Integer>> arrayList = new ArrayList<Pair<MapleStat, Integer>>(2);
        a3.c.getPlayer().getStat().setMaxMp(a2);
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MAXMP, a2));
        a3.c.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, a3.c.getPlayer()));
    }

    public /* synthetic */ void say(int a2, int a3, String a4, boolean a5, boolean a6) {
        NPCConversationManager a7;
        a7.say(a2, -1, a3, a4, a5, a6);
    }

    public /* synthetic */ ScriptType getScriptType() {
        NPCConversationManager a2;
        return a2.K;
    }

    public /* synthetic */ void sendRightPlayerToNpc(String a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.sendNextS(a2, (byte)10, nPCConversationManager.E);
    }

    public /* synthetic */ boolean replaceItem(int a2, int a3, Object a4, int a5) {
        NPCConversationManager a6;
        return a6.replaceItem(a2, a3, a4, a5, InventoryException.ALLATORIxDEMO("2\u0016\u000e\u000e\u0012"));
    }

    public /* synthetic */ boolean getexpiration(int a2) {
        int n2;
        int n3 = n2 = 1;
        while (n3 <= 96) {
            int n4;
            NPCConversationManager a3;
            IItem iItem = a3.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem((short)n2);
            if (iItem == null) {
                n4 = n2;
            } else {
                if (iItem.getItemId() == a2 && iItem.getExpiration() != -1L) {
                    return true;
                }
                n4 = n2;
            }
            n3 = n2 = (int)((byte)(n4 + 1));
        }
        return false;
    }

    public /* synthetic */ void updateNPCSpecialAction(int a2, int a3, int a4, int a5) {
        NPCConversationManager a6;
        if (!npcRequestController.containsKey(new Pair<Integer, MapleClient>(a2, a6.c))) {
            return;
        }
        MapleNPC mapleNPC = npcRequestController.get(new Pair<Integer, MapleClient>(a2, a6.c));
        a6.c.sendPacket(MaplePacketCreator.NPCSpecialAction(mapleNPC.getObjectId(), a3, a4, a5));
    }

    public /* synthetic */ void sendAcceptDeclineNoESC(String a2) {
        NPCConversationManager a3;
        a3.askAcceptDeclineNoESC(a2);
    }

    public /* synthetic */ void worldMessage(String a2) {
        World.Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(a2));
    }

    public /* synthetic */ void sendOkS(String a2, byte a3) {
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a4.sendSimpleS(a2, a3);
            return;
        }
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000fp\u000f`"), a3));
        a4.a = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void getlfj(int a2, int a3) {
        NPCConversationManager a4;
        int n2 = 0;
        if (a3 == 0 && a2 < 100) {
            a4.c.getPlayer().dropMessage(1, MapleImp.ALLATORIxDEMO("\u6903\u5e5c\u4e5d\u8d8c\uff51"));
            return;
        }
        if (a3 == 1 && a2 < 1000) {
            a4.c.getPlayer().dropMessage(1, InventoryException.ALLATORIxDEMO("\u6932\u5e19\u4e6c\u8dc9\uff60"));
            return;
        }
        if (a3 == 2 && a2 < 10000) {
            a4.c.getPlayer().dropMessage(1, MapleImp.ALLATORIxDEMO("\u6903\u5e5c\u4e5d\u8d8c\uff51"));
            return;
        }
        if (a3 == 0) {
            n2 = 100;
        } else if (a3 == 1) {
            n2 = 1000;
        } else if (a3 == 2) {
            n2 = 10000;
        }
        a2 = Randomizer.nextInt(5);
        a2 = Randomizer.nextInt(5);
        a3 = Randomizer.nextInt(5);
        int n3 = Randomizer.nextInt(6);
        int n4 = 0;
        if (a2 == 0 && a3 == 0 || a2 == 1 && a3 == 1 || a2 == 2 && a3 == 2 || a2 == 3 && a3 == 3 || a2 == 4 && a3 == 4) {
            NPCConversationManager nPCConversationManager;
            a4.showEffect(false, InventoryException.ALLATORIxDEMO("\u0017\b\b\u000eU\u0007\b\u0000\u0017\u0004"));
            a4.showEffect(false, "miro/RR1/" + a2);
            a4.showEffect(false, "miro/RR2/" + a3);
            a4.showEffect(false, "miro/RR3/" + n3);
            switch (n3) {
                case 0: {
                    n4 = 3;
                    nPCConversationManager = a4;
                    break;
                }
                case 1: {
                    n4 = 4;
                    nPCConversationManager = a4;
                    break;
                }
                case 2: {
                    n4 = 5;
                    nPCConversationManager = a4;
                    break;
                }
                case 3: {
                    n4 = 6;
                    nPCConversationManager = a4;
                    break;
                }
                case 4: {
                    n4 = 7;
                    nPCConversationManager = a4;
                    break;
                }
                case 5: {
                    n4 = 8;
                }
                default: {
                    nPCConversationManager = a4;
                }
            }
            int n5 = n2;
            nPCConversationManager.c.getPlayer().modifyCSPoints(1, n5 + n5 / 100 * n4);
            int n6 = n4;
            a4.c.getPlayer().dropMessage(-1, "\u6210\u529f\u4e2d\u734e\uff1a" + n6 + "0%\u500d\r\n\u6210\u529f\u4e2d\u734e\uff1a" + n6 + "0%\u500d\r\n\u6210\u529f\u4e2d\u734e\uff1a" + n6 + "0%\u500d");
            a4.c.getPlayer().dropMessage(5, "" + n2 / 100 * n4 * 10);
            String string = n2 + "\u500d\u6e38\u620f\u673a\uff01\u6210\u529f\u4e2d\u5956\uff1a" + n4 + "0%\u500d";
            return;
        }
        a4.showEffect(false, MapleImp.ALLATORIxDEMO("R9M?\u00106M1R5"));
        a4.showEffect(false, "miro/RR1/" + a2);
        a4.showEffect(false, "miro/RR2/" + a3);
        a4.showEffect(false, "miro/RR3/" + n3);
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.c.getPlayer().dropMessage(-1, InventoryException.ALLATORIxDEMO("\u5fe9\u62cb\u6b28\uff76\u60c9\u6ce8\u4e4c\u7334\uff60"));
        nPCConversationManager.c.getPlayer().dropMessage(5, "" + -n2);
        int n7 = n2;
        a4.c.getPlayer().modifyCSPoints(1, -n7);
        String string = n7 + "\u500d\u904a\u6232\u6a5f\uff01\u672a\u4e2d\u734e\uff01";
    }

    public /* synthetic */ void openShop(int a2) {
        NPCConversationManager a3;
        MapleShopFactory.getInstance().getShop(a2).sendShop(a3.c);
    }

    public /* synthetic */ void cleardrops() {
        MapleMonsterInformationProvider.getInstance().clearDrops();
    }

    public /* synthetic */ void setDojoRecord(boolean a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().setDojoRecord(a2);
    }

    public /* synthetic */ boolean isCash(int a2) {
        return MapleItemInformationProvider.getInstance().isCash(a2);
    }

    public /* synthetic */ void say(int a2, String a3, boolean a4, boolean a5) {
        NPCConversationManager a6;
        NPCConversationManager nPCConversationManager = a6;
        nPCConversationManager.say(nPCConversationManager.E, a2, a3, a4, a5);
    }

    public /* synthetic */ void displayGuildPointRanks() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showGuildRanks(nPCConversationManager.E, MapleRanking.getInstance().getGuildPointRank()));
    }

    @Override
    public /* synthetic */ String getQuestCustomData(int a2) {
        NPCConversationManager a3;
        return a3.c.getPlayer().getQuestNAdd(MapleQuest.getInstance(a2)).getCustomData();
    }

    public /* synthetic */ int getSquadAvailability(String a2) {
        NPCConversationManager a3;
        a2 = a3.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 == null) {
            return -1;
        }
        return ((MapleSquad)a2).getStatus();
    }

    public /* synthetic */ void increaseGuildCapacity() {
        NPCConversationManager a2;
        if (a2.c.getPlayer().getMeso() < 250000) {
            a2.c.sendPacket(MaplePacketCreator.getPopupMsg(InventoryException.ALLATORIxDEMO("\u91ab\u9343\u4e77\u8dd2HT\u8456O")));
            return;
        }
        int n2 = a2.c.getPlayer().getGuildId();
        if (n2 <= 0) {
            return;
        }
        NPCConversationManager nPCConversationManager = a2;
        if (World.Guild.increaseGuildCapacity(n2)) {
            nPCConversationManager.c.getPlayer().gainMeso(-250000, true, false, true);
            return;
        }
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getPopupMsg(MapleImp.ALLATORIxDEMO("\u513c\u673c\u64a4\u517a\u4eea\u6547\u5da2\u906b\u6750\u5918\u4e5a\u966f~")));
    }

    public final /* synthetic */ MapleCarnivalParty getCarnivalParty() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getCarnivalParty();
    }

    public /* synthetic */ void forceUpdateStartQuest() {
        NPCConversationManager a2;
        MapleQuest.getInstance(a2.g).forceStart_update(a2.getPlayer(), a2.getNpc(), null);
    }

    public final /* synthetic */ void doWeddingEffect(Object a2) {
        NPCConversationManager a3;
        a2 = (MapleCharacter)a2;
        a3.getMap().broadcastMessage(MaplePacketCreator.yellowChat(((MapleCharacter)a2).getName() + ", \u59b3\u9858\u610f\u627f\u8a8d " + a3.getPlayer().getName() + " \u505a\u59b3\u7684\u4e08\u592b\uff0c\u8aa0\u5be6\u9075\u7167\u4e0a\u5e1d\u7684\u8aa1\u547d\uff0c\u548c\u4ed6\u751f\u6d3b\u5728\u4e00\u8d77\uff0c\u7121\u8ad6\u5728\u4ec0\u9ebc\u74b0\u5883\u9858\u9806\u670d\u4ed6\u3001\u611b\u60dc\u4ed6\u3001\u5b89\u6170\u4ed6\u3001\u5c0a\u91cd\u4ed6\u4fdd\u8b77\u4ed6\uff0c\u4ee5\u81f4\u5949\u53ec\u6b78\u4e3b\uff1f\uff1f"));
        Timer.CloneTimer.getInstance().schedule(new Runnable(){
            public final /* synthetic */ MapleCharacter d;
            {
                1 a3;
                a3.d = mapleCharacter;
            }

            @Override
            public /* synthetic */ void run() {
                1 a2;
                if (a2.d == null || a2.NPCConversationManager.this.getPlayer() == null) {
                    a2.NPCConversationManager.this.warpMap(680000500, 0);
                    return;
                }
                a2.NPCConversationManager.this.getMap().broadcastMessage(MaplePacketCreator.yellowChat(a2.NPCConversationManager.this.getPlayer().getName() + ", \u4f60\u9858\u610f\u627f\u8a8d\u63a5\u7d0d " + a2.d.getName() + " \u505a\u4f60\u7684\u59bb\u5b50\uff0c\u8aa0\u5be6\u9075\u7167\u4e0a\u5e1d\u7684\u8aa1\u547d\uff0c\u548c\u5979\u751f\u6d3b\u5728\u4e00\u8d77\uff0c\u7121\u8ad6\u5728\u4ec0\u9ebc\u74b0\u5883\uff0c\u9858\u610f\u7d42\u751f\u990a\u5979\u3001\u611b\u60dc\u5979\u3001\u5b89\u6170\u5979\u3001\u5c0a\u91cd\u5979\u3001\u4fdd\u8b77\u5979\uff0c\u4ee5\u81f3\u5949\u53ec\u6b78\u4e3b\uff1f\uff1f"));
            }
        }, 10000L);
        Timer.CloneTimer.getInstance().schedule(new Runnable(){
            public final /* synthetic */ MapleCharacter d;

            @Override
            public /* synthetic */ void run() {
                2 a2;
                if (a2.d == null || a2.NPCConversationManager.this.getPlayer() == null) {
                    2 v2;
                    if (a2.NPCConversationManager.this.getPlayer() != null) {
                        2 v0 = a2;
                        2 v1 = a2;
                        v2 = v1;
                        v0.NPCConversationManager.this.setQuestRecord(v1.NPCConversationManager.this.getPlayer(), 160001, "3");
                        v0.NPCConversationManager.this.setQuestRecord(a2.NPCConversationManager.this.getPlayer(), 160002, GashaponRewardSpecial.ALLATORIxDEMO("\u0017"));
                    } else {
                        if (a2.d != null) {
                            2 v3 = a2;
                            a2.NPCConversationManager.this.setQuestRecord(v3.d, 160001, "3");
                            v3.NPCConversationManager.this.setQuestRecord(a2.d, 160002, MonsterPetSystem.ALLATORIxDEMO("c"));
                        }
                        v2 = a2;
                    }
                    v2.NPCConversationManager.this.warpMap(680000500, 0);
                    return;
                }
                2 v4 = a2;
                2 v5 = a2;
                v4.NPCConversationManager.this.setQuestRecord(v5.NPCConversationManager.this.getPlayer(), 160001, "2");
                v5.NPCConversationManager.this.setQuestRecord(a2.d, 160001, "2");
                v4.NPCConversationManager.this.sendNPCText(a2.NPCConversationManager.this.getPlayer().getName() + " \u548c " + a2.d.getName() + "\uff0c \u6211\u5e0c\u671b\u4f60\u5011\u5169\u500b\u80fd\u5728\u6b64\u6642\u6b64\u523b\u6c38\u9060\u611b\u8457\u5c0d\u65b9\uff01", 9201002);
                a2.NPCConversationManager.this.getMap().startExtendedMapEffect("\u90a3\u9ebc\u73fe\u5728\u8acb\u65b0\u5a18\u89aa\u543b " + a2.NPCConversationManager.this.getPlayer().getName() + "\uff01", 5120006);
                if (a2.d.getGuildId() > 0) {
                    World.Guild.guildPacket(a2.d.getGuildId(), MaplePacketCreator.sendMarriage(false, a2.d.getName()));
                }
                if (a2.d.getFamilyId() > 0) {
                    World.Family.familyPacket(a2.d.getFamilyId(), MaplePacketCreator.sendMarriage(true, a2.d.getName()), a2.d.getId());
                }
                if (a2.NPCConversationManager.this.getPlayer().getGuildId() > 0) {
                    World.Guild.guildPacket(a2.NPCConversationManager.this.getPlayer().getGuildId(), MaplePacketCreator.sendMarriage(false, a2.NPCConversationManager.this.getPlayer().getName()));
                }
                if (a2.NPCConversationManager.this.getPlayer().getFamilyId() > 0) {
                    World.Family.familyPacket(a2.NPCConversationManager.this.getPlayer().getFamilyId(), MaplePacketCreator.sendMarriage(true, a2.d.getName()), a2.NPCConversationManager.this.getPlayer().getId());
                }
            }
            {
                2 a3;
                a3.d = mapleCharacter;
            }
        }, 20000L);
    }

    public /* synthetic */ void addMountId(int a2, int a3) {
        MapleMount.addMountId(a2, a3);
    }

    public /* synthetic */ int addMember(String a2, boolean a3) {
        NPCConversationManager a4;
        a2 = a4.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 != null) {
            return ((MapleSquad)a2).addMember(a4.c.getPlayer(), a3);
        }
        return -1;
    }

    public /* synthetic */ void clearsquad(String a2) {
        NPCConversationManager a3;
        a2 = a3.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 != null) {
            ((MapleSquad)a2).clear();
        }
    }

    public /* synthetic */ void askMenu(int a2, int a3, int a4, int a5, String a6) {
        NPCConversationManager a7;
        a7.askMenu(4, a2, a3, a4, a5, 0, a6);
    }

    public /* synthetic */ Gashapon getGashapon() {
        NPCConversationManager a2;
        return GashaponFactory.getInstance().getGashaponByNpcId(a2.getNpc());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ String getRecroNews() throws SQLException {
        var1_1 = new StringBuilder();
        var2_2 = DBConPool.getInstance().getDataSource().getConnection();
        var3_4 = var2_2.prepareStatement(InventoryException.ALLATORIxDEMO("2?-?\".A\u000e\b\u000e\r\u001fMZ\f\u001f\u0012\t\u0000\u001d\u0004VA\u001e\u0000\u000e\u0004Z'(.7A\b\u0004\u0019\u0013\u0015\u000f\u001f\u0016\tA53>$(A88Z\u000f\u001f\u0016\t\b\u001eA\u001e\u0004\t\u0002Z-3,35ZT"));
        var4_6 = var3_4.executeQuery();
        try {
            while (var4_6.next()) {
                var1_1.append(MapleImp.ALLATORIxDEMO("2Z\u001c5")).append(var4_6.getString(InventoryException.ALLATORIxDEMO("\u0015\u0013\u0015\u0016\u0004"))).append(MapleImp.ALLATORIxDEMO("\u001f}\u001fx")).append(var4_6.getString(InventoryException.ALLATORIxDEMO("\u001e\u0000\u000e\u0004"))).append(MapleImp.ALLATORIxDEMO("y\u001c>2Z")).append(var4_6.getString(InventoryException.ALLATORIxDEMO("\f\u001f\u0012\t\u0000\u001d\u0004"))).append(MapleImp.ALLATORIxDEMO("2Z"));
            }
            ** GOTO lbl17
        }
        catch (SQLException var5_8) {
            try {
                try {
                    Logger.getLogger(NPCConversationManager.class.getName()).log(Level.SEVERE, null, var5_8);
lbl17:
                    // 2 sources

                    var3_4.close();
                    var4_6.close();
                    ** if (var2_2 == null) goto lbl-1000
                }
                catch (Throwable var3_5) {
                    block13: {
                        if (var2_2 != null) {
                            try {
                                var2_2.close();
                                v0 = var3_5;
                                break block13;
                            }
                            catch (Throwable var4_7) {
                                var3_5.addSuppressed(var4_7);
                            }
                        }
                        v0 = var3_5;
                    }
                    throw v0;
                }
lbl-1000:
                // 1 sources

                {
                    var2_2.close();
                }
lbl-1000:
                // 2 sources

                {
                }
            }
            catch (SQLException var2_3) {
                FileoutputUtil.outError(InventoryException.ALLATORIxDEMO("\u0016\u000e\u001d\u0012U\u8ca6\u65e3\u5eca\u750a\u5e59T\u0015\u0002\u0015"), var2_3);
            }
        }
        return var1_1.toString();
    }

    public /* synthetic */ void askMapSelection(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.getPlayer().clearNpcSelect();
        nPCConversationManager.c.getPlayer().addNpcSelect(-999999999);
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getMapSelection(a3.E, a2));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.askMapSelection;
    }

    public /* synthetic */ boolean createAlliance(String a22) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        Serializable serializable = nPCConversationManager.c.getPlayer().getParty();
        serializable = nPCConversationManager.c.getChannelServer().getPlayerStorage().getCharacterById(((MapleParty)serializable).getMemberByIndex(1).getId());
        if (serializable == null || ((MapleCharacter)serializable).getId() == a3.c.getPlayer().getId()) {
            return false;
        }
        try {
            return World.Alliance.createAlliance(a22, a3.c.getPlayer().getId(), ((MapleCharacter)serializable).getId(), a3.c.getPlayer().getGuildId(), ((MapleCharacter)serializable).getGuildId());
        }
        catch (Exception a22) {
            return false;
        }
    }

    public /* synthetic */ String getNowBlackJackCard() {
        NPCConversationManager a2;
        return BlackJack.getInstance().getNowCard(a2.c.getPlayer());
    }

    public /* synthetic */ void EnchantCashEqip(byte a2, int a3, MapleCharacter a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13, int a14) {
        NPCConversationManager a15;
        Equip equip = (Equip)((MapleCharacter)a4).getInventory(MapleInventoryType.EQUIP).getItem(a2);
        a4 = (Equip)((MapleCharacter)a4).getInventory(MapleInventoryType.EQUIP).getItem(a2).copy();
        Serializable serializable = a4;
        Equip equip2 = equip;
        Serializable serializable2 = a4;
        Equip equip3 = equip;
        Serializable serializable3 = a4;
        Equip equip4 = equip;
        Serializable serializable4 = a4;
        ((Equip)serializable4).setStr((short)(equip.getStr() + a5));
        ((Equip)serializable4).setDex((short)(equip.getDex() + a6));
        ((Equip)a4).setInt((short)(equip4.getInt() + a7));
        ((Equip)serializable3).setLuk((short)(equip4.getLuk() + a8));
        ((Equip)serializable3).setHp((short)(equip.getHp() + a11));
        ((Equip)a4).setMp((short)(equip3.getMp() + a12));
        ((Equip)serializable2).setWatk((short)(equip3.getWatk() + a9));
        ((Equip)serializable2).setMatk((short)(equip.getMatk() + a10));
        ((Equip)a4).setAvoid((short)(equip2.getAvoid() + a13));
        ((Equip)serializable).setAcc((short)(equip2.getAcc() + a14));
        ((Item)serializable).setOwner("\u5f37\u5316 " + ++a3 + " \u6b21");
        MapleInventoryManipulator.removeFromSlot(a15.getClient(), MapleInventoryType.EQUIP, a2, ((Item)a4).getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a15.getClient(), (IItem)((Object)a4), false);
    }

    public /* synthetic */ long getBaccaratTotalBet() {
        return Baccarat.getInstance().getTotalMesoBet();
    }

    public /* synthetic */ void askMenu(int a2, int a3, int a4, String a5) {
        NPCConversationManager a6;
        a6.askMenu(a2, a3, -1, a4, a5);
    }

    public /* synthetic */ void exceTime(int a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_Delay.getValue(), null, arrn);
    }

    public final /* synthetic */ void maxAllSkills() {
        for (ISkill iSkill : SkillFactory.getAllSkills()) {
            NPCConversationManager a2;
            if (!GameConstants.isApplicableSkill(iSkill.getId())) continue;
            a2.teachSkill(iSkill.getId(), iSkill.getMaxLevel(), iSkill.getMaxLevel());
        }
    }

    public /* synthetic */ int setRandomAvatarFree(int ... a22) {
        NPCConversationManager nPCConversationManager;
        block2: {
            NPCConversationManager a3;
            block4: {
                int a22;
                block3: {
                    block1: {
                        a22 = a22[Randomizer.nextInt(a22.length)];
                        if (a22 >= 100) break block1;
                        NPCConversationManager nPCConversationManager2 = a3;
                        nPCConversationManager = nPCConversationManager2;
                        nPCConversationManager2.c.getPlayer().setSkinColor((byte)a22);
                        nPCConversationManager2.c.getPlayer().updateSingleStat(MapleStat.SKIN, a22);
                        break block2;
                    }
                    if (a22 >= 30000) break block3;
                    if (!NPCConversationManager.faceExists(a22)) break block4;
                    NPCConversationManager nPCConversationManager3 = a3;
                    nPCConversationManager = nPCConversationManager3;
                    nPCConversationManager3.c.getPlayer().setFace(a22);
                    nPCConversationManager3.c.getPlayer().updateSingleStat(MapleStat.FACE, a22);
                    break block2;
                }
                if (NPCConversationManager.hairExists(a22)) {
                    NPCConversationManager nPCConversationManager4 = a3;
                    nPCConversationManager4.c.getPlayer().setHair(a22);
                    nPCConversationManager4.c.getPlayer().updateSingleStat(MapleStat.HAIR, a22);
                }
            }
            nPCConversationManager = a3;
        }
        nPCConversationManager.c.getPlayer().equipChanged();
        return 1;
    }

    public /* synthetic */ String EnchantCashEqipBeginMS(byte a2, int a3, int a4) {
        boolean bl;
        NPCConversationManager a5;
        Equip equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        Equip equip2 = (Equip)equip.copy();
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl2 = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        short s7 = 0;
        if (equip2.getOwner().equals(InventoryException.ALLATORIxDEMO("\u5d93\u963e\u9b35O\u6b40"))) {
            return MapleImp.ALLATORIxDEMO("\u60f8\u967b\u9b04\u5dcd\u9004\n\u6b71\u0013\u7171\u6cea\u7e2c\u7eb3\u9614\u9b6bq");
        }
        if (!a5.c.getPlayer().haveItem(a4)) {
            return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a4 + "#!";
        }
        a5.c.getPlayer().gainItem(a4, -1);
        if (a3 == 1) {
            s5 = 1;
            s4 = 1;
            s3 = 1;
            s2 = 1;
            bl = bl2;
        } else {
            if (a3 == 2) {
                s6 = 1;
                s7 = 1;
            }
            bl = bl2;
        }
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            if (s2 > 0) {
                Equip equip3 = equip2;
                equip3.setStr((short)(equip3.getStr() + s2 > 0 ? equip2.getStr() + s2 : 0));
                object = (String)object + "\u529b\u91cf + " + s2 + "\r\n";
            }
            if (s3 > 0) {
                Equip equip4 = equip2;
                equip4.setDex((short)(equip4.getDex() + s3 > 0 ? equip2.getDex() + s3 : 0));
                object = (String)object + "\u654f\u6377 + " + s3 + "\r\n";
            }
            if (s4 > 0) {
                Equip equip5 = equip2;
                equip5.setInt((short)(equip5.getInt() + s4 > 0 ? equip2.getInt() + s4 : 0));
                object = (String)object + "\u667a\u529b + " + s4 + "\r\n";
            }
            if (s5 > 0) {
                Equip equip6 = equip2;
                equip6.setLuk((short)(equip6.getLuk() + s5 > 0 ? equip2.getLuk() + s5 : 0));
                object = (String)object + "\u5e78\u904b + " + s5 + "\r\n";
            }
            if (s6 > 0) {
                Equip equip7 = equip2;
                equip7.setWatk((short)(equip7.getWatk() + s6 > 0 ? equip2.getWatk() + s6 : 0));
                object = (String)object + "\u7269\u7406\u653b\u64ca + " + s6 + "\r\n";
            }
            if (s7 > 0) {
                Equip equip8 = equip2;
                equip8.setMatk((short)(equip8.getMatk() + s7 > 0 ? equip2.getMatk() + s7 : 0));
                object = (String)object + "\u9b54\u6cd5\u653b\u64ca + " + s7 + "\r\n";
            }
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip9 = equip2;
            a3 = StringTool.getIntFromString(equip9.getOwner());
            equip9.setOwner("\u5df2\u9644\u9b54" + ++a3 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
    }

    public /* synthetic */ void sendOk(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000fp\u000f`"), (byte)0));
        a3.a = 0;
    }

    public /* synthetic */ void setExpiration(Object a2, long a3) {
        if (a2 instanceof Equip) {
            ((Equip)a2).setExpiration(System.currentTimeMillis() + a3 * 24L * 60L * 60L * 1000L);
        }
    }

    public /* synthetic */ void showmeso() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showmesoRanks(nPCConversationManager.E, MapleRanking.getInstance().getMesoRank()));
    }

    public /* synthetic */ String MonsterPetSkillDemo(MapleCharacter a22) {
        StringBuilder stringBuilder = new StringBuilder();
        int a22 = a22.getMonsterPet(2);
        stringBuilder.append(MapleImp.ALLATORIxDEMO("sM\u607a\u7256\u53bf\u64fe\u6759\u76bb\u62d0\u80c2p\u0005p2Z"));
        int n2 = 0;
        int n3 = n2;
        while (n3 < MapleMonsterPet.MapleMonsterPetSkill.getSkillCount()) {
            int n4 = n2 + 1;
            if (!MapleMonsterPet.MapleMonsterPetSkill.getName(MapleMonsterPet.MapleMonsterPetSkill.getById(n2)).equals(InventoryException.ALLATORIxDEMO("4\u0014\n\u0014\u000e\r\u000f"))) {
                int n5;
                String string;
                String string2 = MapleMonsterPet.MapleMonsterPetSkill.getName(MapleMonsterPet.MapleMonsterPetSkill.getById(n2));
                if (a22 >= n2 * 10) {
                    string = MapleImp.ALLATORIxDEMO("p\u001c2\u302f\u5da2\u53d0\u4f2f\u7517\u3041\u001c;");
                    n5 = n2;
                } else {
                    string = InventoryException.ALLATORIxDEMO("Y\u0013\u306a\u7140\u6caf\u4f1e\u7552\u3070Y\n");
                    n5 = n2;
                }
                stringBuilder.append("#b\u6280\u80fd" + n4 + ":#d" + string2 + string + "#d\u3010\u9700\u8981\u602a\u7269\u7b49\u7d1a:" + n5 * 10 + "\u7b49\u3011\r\n");
            }
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ MapleSquad getSquad(String a2) {
        NPCConversationManager a3;
        return a3.c.getChannelServer().getMapleSquad(a2);
    }

    public /* synthetic */ void setSkin(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getPlayer().setSkinColor((byte)a2);
        nPCConversationManager.getPlayer().updateSingleStat(MapleStat.SKIN, a2);
        nPCConversationManager.getPlayer().equipChanged();
    }

    public /* synthetic */ void setAndroidHair(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getPlayer().getAndroid().setHair(a2);
        nPCConversationManager.getPlayer().getAndroid().saveToDb();
        nPCConversationManager.c.getPlayer().setAndroid(a3.c.getPlayer().getAndroid());
    }

    public /* synthetic */ void dc() {
        NPCConversationManager a2;
        MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterByName(a2.getPlayer().getName());
        mapleCharacter.getClient().getSession().close();
        mapleCharacter.getClient().disconnect();
    }

    public /* synthetic */ String EnchantEquipHp(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        boolean bl2 = ItemConstants.\u985e\u578b.\u6b66\u5668((int)n2) && !bl;
        Object object = "";
        int n3 = 3500;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u6b1c\u5609\u883a\u91ae\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (bl2) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u6b66\u5668\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            a3 = (short)Randomizer.rand(a3, a4);
            Equip equip3 = equip2;
            short s2 = (short)(equip3.getHp() + a3);
            a4 = s2;
            equip3.setHp((short)(s2 > n3 ? (int)n3 : a4));
            object = (String)object + "\u8840\u91cf:  " + (short)a3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316HP[" + (n4 += a3) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u6b59\u5638\u5508q\u50fa\u6759\u6b59\u5638\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ void addMaxHp(int a2) {
        NPCConversationManager a3;
        int n2 = a3.c.getPlayer().getStat().getMaxHp();
        a2 += n2;
        if (GameSetConstants.MAPLE_VERSION < 134) {
            if (a2 > 30000) {
                a2 = 30000;
            }
        } else if (a2 > 99999) {
            a2 = 99999;
        }
        ArrayList<Pair<MapleStat, Integer>> arrayList = new ArrayList<Pair<MapleStat, Integer>>(2);
        a3.c.getPlayer().getStat().setMaxHp(a2);
        arrayList.add(new Pair<MapleStat, Integer>(MapleStat.MAXHP, a2));
        a3.c.sendPacket(MaplePacketCreator.updatePlayerStats(arrayList, a3.c.getPlayer()));
    }

    public /* synthetic */ void sendSimple(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (!a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendNext(a2);
            return;
        }
        Matcher matcher = Pattern.compile(MapleImp.ALLATORIxDEMO("\f\u001c\u001cd\u000ecsb{cs")).matcher(a2);
        a3.c.getPlayer().clearNpcSelect();
        while (matcher.find()) {
            String string = matcher.group().replaceAll(InventoryException.ALLATORIxDEMO("B"), "").replaceAll(MapleImp.ALLATORIxDEMO("\u001c"), "").replaceAll(" ", "");
            if (!StringTool.isNumeric(string)) continue;
            a3.c.getPlayer().addNpcSelect(Integer.parseInt(string));
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, MaplePacketOperation.NPCStatus.sendSimple, a2, "", (byte)0));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendSimple;
    }

    public /* synthetic */ String checkItemDrop(MapleCharacter a2, int a32) {
        List<ItemDropEntry> list = MapleItemInformationProvider.getInstance();
        list = MapleMonsterInformationProvider.getInstance().retrieveMonster(a32);
        if (list != null && list.size() > 0) {
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder.append("\u3010#r#i" + a32 + "##k\u3011\u6389\u5bf6\u602a\u7269\u67e5\u8a62\u5217\u8868:#b\r\n");
            int n5 = 0;
            int n6 = n5;
            while (n6 < list.size()) {
                ItemDropEntry a32 = (ItemDropEntry)list.get(n5);
                if (a32.chance > 0 && (a32.questid <= 0 || a32.questid > 0 && MapleQuest.getInstance(a32.questid).getName().length() > 0)) {
                    n3 = a32.dropperid;
                    String string = "#o" + n3 + "#";
                    if (n3 != 0) {
                        NPCConversationManager a4;
                        n4 = (int)((double)a32.chance * a4.getClient().getChannelServer().getDropRate(a4.c.getPlayer().getWorld()));
                        if (a2.isGM()) {
                            int n7 = n3;
                            stringBuilder.append("#L" + n7 + "##k" + (n2 + 1) + ":" + string + " #d\u4ee3\u78bc:#r" + n7 + "  #k#d\u6389\u843d\u6a5f\u7387\uff1a" + Integer.valueOf(n4 >= 999999 ? 1000000 : n4).doubleValue() / 10000.0 + "%(\u9ede\u9078\u66f4\u6539)\r\n#b(\u6389\u843d\u689d\u4ef6:" + (String)(a32.questid > 0 && MapleQuest.getInstance(a32.questid).getName().length() > 0 ? "\u9700\u8981\u63a5\u53d6\u4efb\u52d9#r " + MapleQuest.getInstance(a32.questid).getName() + " #b)\r\n" : MapleImp.ALLATORIxDEMO("\u001c\"\u711es]y")) + "#l\r\n");
                        } else {
                            stringBuilder.append(n2 + 1 + ":" + string + " #d\u4ee3\u78bc:#r" + n3 + "  #k\r\n#b(\u6389\u843d\u689d\u4ef6:" + (String)(a32.questid > 0 && MapleQuest.getInstance(a32.questid).getName().length() > 0 ? "\u9700\u8981\u63a5\u53d6\u4efb\u52d9#r " + MapleQuest.getInstance(a32.questid).getName() + " #b)\r\n" : InventoryException.ALLATORIxDEMO("Y\u0013\u715bB\u0018H")) + "#l\r\n");
                        }
                        ++n2;
                    } else {
                        stringBuilder2.append(n3 + "\r\n");
                    }
                }
                n6 = ++n5;
            }
            if (stringBuilder2.length() > 0) {
                a2.dropMessage(1, "\u7121\u6548\u7684\u7269\u54c1ID:\r\n" + stringBuilder2.toString());
            }
            if (stringBuilder.length() > 0) {
                return stringBuilder.toString();
            }
        }
        return MapleImp.ALLATORIxDEMO("\u8a4d\u9003\u5148\u67b5\u711e\u4eab\u4f6a\u607a\u7256\u63d9\u8402\u6528\u64e5\u3052");
    }

    public /* synthetic */ void spawnNPCRequestController(int a2, int a3, int a4) {
        NPCConversationManager a5;
        a5.spawnNPCRequestController(a2, a3, a4, 0);
    }

    public /* synthetic */ byte getLastMsg() {
        NPCConversationManager a2;
        return a2.a;
    }

    public /* synthetic */ long getNiuNiuTotalBet() {
        return NiuNiu.getInstance().getTotalBet();
    }

    public /* synthetic */ void setQuestCustomData(String a2) {
        NPCConversationManager a3;
        a3.getPlayer().getQuestNAdd(MapleQuest.getInstance(a3.g)).setCustomData(a2);
    }

    public /* synthetic */ long getTotalDonate() {
        NPCConversationManager a2;
        return a2.getClient().getTotalDonate();
    }

    public /* synthetic */ String getNumberIcon3(int a2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        ArrayList arrayList = BitTools.intToArray(a2);
        int n3 = 0;
        int n4 = a2 = 0;
        while (n4 < arrayList.size()) {
            n2 = (Integer)arrayList.get(a2);
            ++n3;
            stringBuilder.append("#fUI/UIWindow.img/Horus/Menu/float/number/" + n2 + "#");
            n4 = ++a2;
        }
        n2 = 6 - n3;
        if (n2 > 0) {
            int n5 = a2 = 0;
            while (n5 < n2) {
                stringBuilder2.append(MapleImp.ALLATORIxDEMO("\u001c6j\u0019\u0010\u0005v\u0007V>[?H~V=X\u007fw?M%L\u007fr5Q%\u00106S?^$\u0010>J=]5M\u007f\u000fs"));
                n5 = ++a2;
            }
        }
        StringBuilder stringBuilder3 = stringBuilder2;
        stringBuilder3.append(stringBuilder.toString());
        return stringBuilder3.toString();
    }

    public /* synthetic */ void setNPCSpecialAction(int a2, String a3, int a4, boolean a5) {
        NPCConversationManager a6;
        a6.setNPCSpecialAction(a2, a3, a4, a5, -1);
    }

    public /* synthetic */ void forcedAction(int[] a2) {
        NPCConversationManager a3;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedAction.getValue(), null, a2);
    }

    public /* synthetic */ void banMember(String a2, int a3) {
        NPCConversationManager a4;
        a2 = a4.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 != null) {
            ((MapleSquad)a2).banMember(a3);
        }
    }

    public /* synthetic */ void sendStorage() {
        NPCConversationManager a2;
        if (a2.getPlayer().getMap() == null || a2.getPlayer().getTrade() != null || !a2.getPlayer().isAlive()) {
            NPCConversationManager nPCConversationManager = a2;
            nPCConversationManager.c.getPlayer().dropMessage(1, MapleImp.ALLATORIxDEMO("\u76d1\u521d\u711e\u6c85\u57c8\u881c\u6b5b\u5285\u4f63\u3052"));
            nPCConversationManager.c.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!World.isShutDown) {
            NPCConversationManager nPCConversationManager = a2;
            a2.getPlayer().addStorageMsg(a2.getPlayer().getName(), InventoryException.ALLATORIxDEMO("A\u95f1\u553e\u5073\u5ecawk"));
            nPCConversationManager.c.getPlayer().setConversation(4);
            nPCConversationManager.getPlayer().setOperateStorage(true);
            int n2 = 34;
            nPCConversationManager.c.sendPacket(PlayerShopPacket.merchItemStore((byte)n2));
            return;
        }
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.getPlayer().dropMessage(1, MapleImp.ALLATORIxDEMO("\u76be\u5272\u4e5d\u80c2\u4f2f\u7517\u5059\u5e94\u3052"));
        nPCConversationManager.c.sendPacket(MaplePacketCreator.enableActions());
    }

    public /* synthetic */ String searchData(int a2, String a3) {
        return SearchGenerator.searchData(a2, a3);
    }

    public /* synthetic */ void equip(int a2, boolean a3) {
        NPCConversationManager a4;
        a4.c.getPlayer().equip(a2, a3);
    }

    public /* synthetic */ void sendYesNo(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, MaplePacketOperation.NPCStatus.sendYesNo, a2, "", (byte)0));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendYesNo;
    }

    public /* synthetic */ String EnchantCashEqipFlowerMS(byte a2) {
        NPCConversationManager a3;
        Equip equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        Equip equip2 = (Equip)equip.copy();
        int n2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            n2 = 5;
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + n2 > 0 ? equip2.getStr() + n2 : 0));
            object = (String)object + "\u529b\u91cf + " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + n2 > 0 ? equip2.getDex() + n2 : 0));
            object = (String)object + "\u654f\u6377:  " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + n2 > 0 ? equip2.getInt() + n2 : 0));
            object = (String)object + "\u667a\u529b:  " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + n2 > 0 ? equip2.getLuk() + n2 : 0));
            object = (String)object + "\u5e78\u904b:  " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip7 = equip2;
            equip7.setHp((short)(equip7.getHp() + n2 > 0 ? equip2.getHp() + n2 : 0));
            object = (String)object + "HP:  " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip8 = equip2;
            equip8.setMp((short)(equip8.getMp() + n2 > 0 ? equip2.getMp() + n2 : 0));
            object = (String)object + "MP:  " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip9 = equip2;
            equip9.setWatk((short)(equip9.getWatk() + n2 > 0 ? equip2.getWatk() + n2 : 0));
            object = (String)object + "\u7269\u7406\u653b\u64ca:  " + (short)n2 + "\r\n";
            n2 = 5;
            Equip equip10 = equip2;
            equip10.setMatk((short)(equip10.getMatk() + n2 > 0 ? equip2.getMatk() + n2 : 0));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + (short)n2 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip11 = equip2;
            n2 = StringTool.getIntFromString(equip11.getOwner());
            equip11.setOwner("\u5df2\u9644\u9b54" + ++n2 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
    }

    public /* synthetic */ void sendRepairWindow() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.sendRepairWindow(nPCConversationManager.E));
    }

    public /* synthetic */ void sendSimpleS(String a2, byte a3) {
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        if (!a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a4.sendNextS(a2, a3);
            return;
        }
        Matcher matcher = Pattern.compile(MapleImp.ALLATORIxDEMO("\f\u001c\u001cd\u000ecsb{cs")).matcher(a2);
        a4.c.getPlayer().clearNpcSelect();
        while (matcher.find()) {
            String string = matcher.group().replaceAll(InventoryException.ALLATORIxDEMO("B"), "").replaceAll(MapleImp.ALLATORIxDEMO("\u001c"), "");
            if (!StringTool.isNumeric(string)) continue;
            a4.c.getPlayer().addNpcSelect(Integer.parseInt(string));
        }
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, MaplePacketOperation.NPCStatus.sendSimpleS, a2, "", a3));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendSimpleS;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantCashEqipHappy(byte a2, int a322, int a4) {
        Equip equip;
        NPCConversationManager a5;
        Equip equip2;
        Equip equip3 = equip2 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        short s2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(s2);
        Object object = "";
        if (!bl) return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
        if (!a5.c.getPlayer().haveItem(a322, a4)) {
            return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a322 + "# " + a4 + "\u500b!";
        }
        a5.c.getPlayer().gainItem(a322, -a4);
        object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + s2 + "##k\r\n";
        object = (String)object + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        LinkedList a322 = new LinkedList();
        switch (Randomizer.rand(1, 6)) {
            case 1: {
                short a322 = (short)Randomizer.rand(1, 3);
                Equip equip4 = equip3;
                short s3 = (short)(equip4.getStr() + a322);
                a4 = s3;
                equip4.setStr((short)(s3 > 0 ? a4 : 0));
                object = (String)object + "\u529b\u91cf + " + a322 + "\r\n";
                equip = equip3;
                break;
            }
            case 2: {
                s2 = (short)Randomizer.rand(1, 3);
                Equip equip5 = equip3;
                short s4 = (short)(equip5.getDex() + s2);
                a4 = s4;
                equip5.setDex((short)(s4 > 0 ? a4 : 0));
                object = (String)object + "\u654f\u6377 +  " + s2 + "\r\n";
                equip = equip3;
                break;
            }
            case 3: {
                s2 = (short)Randomizer.rand(1, 3);
                Equip equip6 = equip3;
                short s5 = (short)(equip6.getInt() + s2);
                a4 = s5;
                equip6.setInt((short)(s5 > 0 ? a4 : 0));
                object = (String)object + "\u667a\u529b +  " + s2 + "\r\n";
                equip = equip3;
                break;
            }
            case 4: {
                s2 = (short)Randomizer.rand(1, 3);
                Equip equip7 = equip3;
                short s6 = (short)(equip7.getLuk() + s2);
                a4 = s6;
                equip7.setLuk((short)(s6 > 0 ? a4 : 0));
                object = (String)object + "\u5e78\u904b +  " + s2 + "\r\n";
                equip = equip3;
                break;
            }
            case 5: {
                s2 = (short)Randomizer.rand(1, 2);
                Equip equip8 = equip3;
                short s7 = (short)(equip8.getWatk() + s2);
                a4 = s7;
                equip8.setWatk((short)(s7 > 0 ? a4 : 0));
                object = (String)object + "\u7269\u7406\u653b\u64ca +  " + s2 + "\r\n";
                equip = equip3;
                break;
            }
            case 6: {
                s2 = (short)Randomizer.rand(1, 2);
                Equip equip9 = equip3;
                short s8 = (short)(equip9.getMatk() + s2);
                a4 = s8;
                equip9.setMatk((short)(s8 > 0 ? a4 : 0));
                object = (String)object + "\u9b54\u6cd5\u653b\u64ca +  " + s2 + "\r\n";
                object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            }
            default: {
                equip = equip3;
            }
        }
        int a322 = StringTool.getIntFromString(equip.getOwner());
        equip3.setOwner("\u5df2\u9644\u9b54" + ++a322 + "\u6b21");
        equip2 = (Equip)equip3.copy();
        MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a5.getClient(), equip2, false);
        a5.c.getPlayer().equipChanged();
        return object;
    }

    public /* synthetic */ void sendNextPrev(String a2, byte a3) {
        NPCConversationManager a4;
        a4.sendNextPrevS(a2, a3);
    }

    public final /* synthetic */ void setDojoPoints(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().setDojo(a2);
    }

    public /* synthetic */ int[] getCanStyle(int[] a2) {
        NPCConversationManager a3;
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        int n3 = ((int[])a2).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = a2[n2];
            if (NPCConversationManager.hairExists(n5) || n5 < 20 || NPCConversationManager.faceExists(n5)) {
                arrayList.add(n5);
            } else {
                arrayList2.add(n5);
            }
            n4 = ++n2;
        }
        if (arrayList2.size() > 0 && a3.c.getPlayer().isAdmin()) {
            StringBuilder stringBuilder = new StringBuilder(MapleImp.ALLATORIxDEMO("\u6b33\u5717\u8bd0\u53e9\u76d4\u901f\u57db\u91f3\u6759"));
            a2 = stringBuilder;
            stringBuilder.append(arrayList2.size()).append(InventoryException.ALLATORIxDEMO("\u506a\u7552\u6257\u7a95\u4e6c\u6555\u6395\u9815\u795b\u8ab1\u56bf\u584b&7\uff6d\u5d88\u7df2\u88d1\u6e64\u961e\uff7b"));
            n3 = 0;
            int n6 = n3;
            while (n6 < arrayList2.size()) {
                int n7 = n3;
                ((StringBuilder)a2).append(arrayList2.get(n7));
                if (n7 < arrayList2.size() - 1) {
                    ((StringBuilder)a2).append(MapleImp.ALLATORIxDEMO("|"));
                }
                n6 = ++n3;
            }
            a3.playerMessage(((StringBuilder)a2).toString());
        }
        a2 = new int[arrayList.size()];
        int n8 = n3 = 0;
        while (n8 < arrayList.size()) {
            int n9 = n3++;
            a2[n9] = (Integer)arrayList.get(n9);
            n8 = n3;
        }
        return a2;
    }

    public /* synthetic */ void PlayerToNpc(String a2) {
        NPCConversationManager a3;
        a3.sendNextPrevS(a2, (byte)3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean getSquadList(String a2, byte a3) {
        NPCConversationManager a4;
        a2 = a4.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 == null) {
            return false;
        }
        switch (a3) {
            case 0: 
            case 3: {
                a4.sendNext(((MapleSquad)a2).getSquadMemberString(a3));
                return true;
            }
            case 1: {
                a4.sendSimple(((MapleSquad)a2).getSquadMemberString(a3));
                return true;
            }
            case 2: {
                NPCConversationManager nPCConversationManager = a4;
                if (((MapleSquad)a2).getBannedMemberSize() > 0) {
                    nPCConversationManager.sendSimple(((MapleSquad)a2).getSquadMemberString(a3));
                    return true;
                }
                nPCConversationManager.sendNext(((MapleSquad)a2).getSquadMemberString(a3));
                return true;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String SugarCashEquipStar(byte a2, int a32) {
        Equip a32;
        NPCConversationManager a4;
        Equip equip = a32 = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        int n3 = n2 == 1112942 || n2 == 1112944 ? 1 : 0;
        Object object = "";
        if (n3 == 0) return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u4e19\u970e\u6b5e\u6a52\u622d\u6357\u0013\u7171\u6cea\u5317\u7d25\u3052");
        if (!(equip.getStr() == 0 && equip.getDex() == 0 && equip.getInt() == 0 && equip.getLuk() == 0 && equip.getHp() == 0 && equip.getMp() == 0 && equip.getWatk() == 0 && equip.getMatk() == 0 && equip.getWdef() == 0 && equip.getMdef() == 0 && equip.getAcc() == 0 && equip.getSpeed() == 0 && equip.getJump() == 0 || equip.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2656")) || equip.getOwner().contains(InventoryException.ALLATORIxDEMO("\u2664")))) {
            return MapleImp.ALLATORIxDEMO("\u001c\"\u6b5b\u888d\u50a6\u5da2\u6736\u7229\u6bb5\u80ad\u52a4.\u56df\u6b34\u711e\u6c85\u5378\u7d4a\u54d9q");
        }
        n3 = a4.getEquipLevel(equip.getOwner());
        if (n3 >= 14) {
            return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u5d88\u9035\u524a\u6761\u9aa2\u667e\u6502\u001f\u715b\u6cb4\u7e06\u7eed\u533d\u7d7b\u56b3@");
        }
        if (n3 < 7) {
            if (!a4.c.getPlayer().haveItem(4300007)) {
                return MapleImp.ALLATORIxDEMO("sM\u5317\u7d25aAg\u6620\u9750\u89besVd\f`\u000f`\u000fg\u001cp\u000ep\u5034q");
            }
            a4.c.getPlayer().gainItem(4300007, -1);
        } else {
            NPCConversationManager nPCConversationManager = a4;
            if (a4.c.getPlayer().haveItem(4300006)) {
                nPCConversationManager.c.getPlayer().gainItem(4300006, -1);
            } else {
                if (!nPCConversationManager.c.getPlayer().haveItem(4300082)) {
                    return InventoryException.ALLATORIxDEMO("B\b\u5326\u7d60Y\u0004PN\u667e\u977a\u89e0Y\bNRJQJQLBZ\u6277ZB\u0013UIQJQBSYAKA\u5071@");
                }
                a4.c.getPlayer().gainItem(4300082, -1);
            }
        }
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        switch (n3 + 1) {
            case 1: {
                n4 = 5;
                n5 = 5;
                n6 = 5;
                n7 = 5;
                n10 = 90;
                break;
            }
            case 2: {
                n4 = 6;
                n5 = 6;
                n6 = 6;
                n7 = 6;
                n10 = 90;
                break;
            }
            case 3: {
                n4 = 7;
                n5 = 7;
                n6 = 7;
                n7 = 7;
                n10 = 90;
                break;
            }
            case 4: {
                n4 = 8;
                n5 = 8;
                n6 = 8;
                n7 = 8;
                n8 = 1;
                n9 = 1;
                n10 = 80;
                break;
            }
            case 5: {
                n4 = 9;
                n5 = 9;
                n6 = 9;
                n7 = 9;
                n8 = 2;
                n9 = 2;
                n10 = 75;
                break;
            }
            case 6: {
                n4 = 10;
                n5 = 10;
                n6 = 10;
                n7 = 10;
                n8 = 3;
                n9 = 3;
                n10 = 70;
                break;
            }
            case 7: {
                n4 = 15;
                n5 = 15;
                n6 = 15;
                n7 = 15;
                n8 = 5;
                n9 = 5;
                n10 = 60;
                break;
            }
            case 8: {
                n4 = 18;
                n5 = 18;
                n6 = 18;
                n7 = 18;
                n8 = 7;
                n9 = 7;
                n10 = 55;
                break;
            }
            case 9: {
                n4 = 21;
                n5 = 21;
                n6 = 21;
                n7 = 21;
                n8 = 10;
                n9 = 10;
                n10 = 50;
                break;
            }
            case 10: {
                n4 = 25;
                n5 = 25;
                n6 = 25;
                n7 = 25;
                n8 = 15;
                n9 = 15;
                n10 = 40;
                break;
            }
            case 11: {
                n4 = 30;
                n5 = 30;
                n6 = 30;
                n7 = 30;
                n8 = 20;
                n9 = 20;
                n10 = 30;
                break;
            }
            case 12: {
                n4 = 35;
                n5 = 35;
                n6 = 35;
                n7 = 35;
                n8 = 25;
                n9 = 25;
                n10 = 25;
                break;
            }
            case 13: {
                n4 = 45;
                n5 = 45;
                n6 = 45;
                n7 = 45;
                n8 = 35;
                n9 = 35;
                n10 = 15;
                break;
            }
            case 14: {
                n4 = 60;
                n5 = 60;
                n6 = 60;
                n7 = 60;
                n8 = 50;
                n9 = 50;
                n10 = 10;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < n10) {
            Equip equip2 = equip;
            Equip equip3 = equip;
            Equip equip4 = equip;
            equip.setStr((short)n4);
            equip4.setDex((short)n5);
            equip4.setInt((short)n6);
            equip3.setLuk((short)n7);
            equip3.setWatk((short)n8);
            equip2.setMatk((short)n9);
            equip2.setOwner(a4.getEquipStar(n3 + 1));
            a32 = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), a32, false);
            a4.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + n10 + "%)\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a4.getEquipStar(n3 + 1) + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + n4 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + n5 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n9 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a4.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        n4 = 0;
        n5 = 0;
        n6 = 0;
        n7 = 0;
        n8 = 0;
        n9 = 0;
        switch (n3 - 1) {
            case 1: {
                n4 = 5;
                n5 = 5;
                n6 = 5;
                n7 = 5;
                break;
            }
            case 2: {
                n4 = 6;
                n5 = 6;
                n6 = 6;
                n7 = 6;
                break;
            }
            case 3: {
                n4 = 7;
                n5 = 7;
                n6 = 7;
                n7 = 7;
                break;
            }
            case 4: {
                n4 = 8;
                n5 = 8;
                n6 = 8;
                n7 = 8;
                n8 = 1;
                n9 = 1;
                break;
            }
            case 5: {
                n4 = 9;
                n5 = 9;
                n6 = 9;
                n7 = 9;
                n8 = 2;
                n9 = 2;
                break;
            }
            case 6: {
                n4 = 10;
                n5 = 10;
                n6 = 10;
                n7 = 10;
                n8 = 3;
                n9 = 3;
                break;
            }
            case 7: {
                n4 = 15;
                n5 = 15;
                n6 = 15;
                n7 = 15;
                n8 = 5;
                n9 = 5;
                break;
            }
            case 8: {
                n4 = 18;
                n5 = 18;
                n6 = 18;
                n7 = 18;
                n8 = 7;
                n9 = 7;
                break;
            }
            case 9: {
                n4 = 21;
                n5 = 21;
                n6 = 21;
                n7 = 21;
                n8 = 10;
                n9 = 10;
                break;
            }
            case 10: {
                n4 = 25;
                n5 = 25;
                n6 = 25;
                n7 = 25;
                n8 = 15;
                n9 = 15;
                break;
            }
            case 11: {
                n4 = 30;
                n5 = 30;
                n6 = 30;
                n7 = 30;
                n8 = 20;
                n9 = 20;
                break;
            }
            case 12: {
                n4 = 35;
                n5 = 35;
                n6 = 35;
                n7 = 35;
                n8 = 25;
                n9 = 25;
                break;
            }
            case 13: {
                n4 = 45;
                n5 = 45;
                n6 = 45;
                n7 = 45;
                n8 = 35;
                n9 = 35;
                break;
            }
            case 14: {
                n4 = 60;
                n5 = 60;
                n6 = 60;
                n7 = 60;
                n8 = 50;
                n9 = 50;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < 50) {
            Equip equip5 = equip;
            Equip equip6 = equip;
            Equip equip7 = equip;
            equip.setStr((short)n4);
            equip7.setDex((short)n5);
            equip7.setInt((short)n6);
            equip6.setLuk((short)n7);
            equip6.setWatk((short)n8);
            equip5.setMatk((short)n9);
            equip5.setOwner(a4.getEquipStar(n3 - 1));
            a32 = (Equip)equip5.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), a32, false);
            a4.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u5931\u6557!!\u88dd\u5099\u964d\u7d1a!!(\u6210\u529f\u6a5f\u7387" + n10 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u738750%)\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a4.getEquipStar(n3 - 1) + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + n4 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + n5 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n9 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a4.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + n10 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u7387 50 %)";
    }

    public /* synthetic */ void resetReactors() {
        NPCConversationManager a2;
        a2.getPlayer().getMap().resetReactors();
    }

    public /* synthetic */ void spawnNPCRequestController(int a22, int a3, int a4, int a5, int a6) {
        MapleNPC mapleNPC;
        NPCConversationManager a7;
        if (npcRequestController.containsKey(new Pair<Integer, MapleClient>(a6, a7.c))) {
            npcRequestController.remove(new Pair<Integer, MapleClient>(a6, a7.c));
        }
        if ((mapleNPC = a7.c.getPlayer().getMap().getNPCById(a22)) == null) {
            mapleNPC = MapleLifeFactory.getNPC(a22);
            if (mapleNPC == null) {
                return;
            }
            MapleNPC mapleNPC2 = mapleNPC;
            int n2 = a3;
            MapleNPC mapleNPC3 = mapleNPC;
            mapleNPC3.setPosition(new Point(a3, a4));
            mapleNPC3.setCy(a4);
            mapleNPC.setRx0(n2 - 50);
            mapleNPC2.setRx1(n2 + 50);
            mapleNPC2.setF(a5);
            MapleFoothold a22 = a7.c.getPlayer().getMap().getFootholds().findBelow(new Point(a3, a4));
            mapleNPC.setFh(a22 == null ? 0 : a22.getId());
            MapleNPC mapleNPC4 = mapleNPC;
            mapleNPC4.setCustom(true);
            mapleNPC4.setObjectId(a6);
        }
        npcRequestController.put(new Pair<Integer, MapleClient>(a6, a7.c), mapleNPC);
        NPCConversationManager nPCConversationManager = a7;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.spawnNPCRequestController(mapleNPC, true));
        nPCConversationManager.c.sendPacket(MaplePacketCreator.setNPCSpecialAction(mapleNPC.getObjectId(), MapleImp.ALLATORIxDEMO("L%R=P>"), false ? (byte)1 : 0, false));
    }

    public /* synthetic */ String getBaccaratRules() {
        return Baccarat.getInstance().getRules();
    }

    public /* synthetic */ String EnchantMp(byte a2, int a3, int a4, int a5, int a6, int a7) {
        NPCConversationManager a8;
        Equip equip;
        Equip equip2 = equip = (Equip)a8.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        NPCConversationManager nPCConversationManager = a8;
        int n2 = nPCConversationManager.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        int n3 = StringTool.getIntFromString(equip2.getOwner());
        if (!nPCConversationManager.c.getPlayer().haveItem(a6, a7)) {
            return "\u60a8\u7f3a\u4e4f\u7269\u54c1#i" + a6 + "#!";
        }
        if (n3 >= a5) {
            return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u5f67\u5329\u4e5a\u966fq");
        }
        a8.c.getPlayer().gainItem(a6, -a7);
        object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
        object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        a3 = (short)Randomizer.rand(a3, a4);
        Equip equip3 = equip2;
        short s2 = (short)(equip3.getMp() + a3);
        a4 = s2;
        equip3.setMp((short)(s2 > a5 ? (int)a5 : a4));
        object = (String)object + "\u9b54\u529b:  " + (short)a3 + "\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        equip2.setOwner("\u5f37\u5316MP[" + (n3 += a3) + "]");
        equip = (Equip)equip2.copy();
        MapleInventoryManipulator.removeFromSlot(a8.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a8.getClient(), equip, false);
        a8.c.getPlayer().equipChanged();
        return object;
    }

    public /* synthetic */ NPCConversationManager(MapleClient a2, int a3, int a4, int a5, String a6, ScriptType a7, Invocable a8) {
        NPCConversationManager a9;
        NPCConversationManager nPCConversationManager = a9;
        NPCConversationManager nPCConversationManager2 = a9;
        NPCConversationManager nPCConversationManager3 = a9;
        NPCConversationManager nPCConversationManager4 = a9;
        super(a2);
        a9.a = (byte)-1;
        nPCConversationManager4.pendingDisposal = false;
        nPCConversationManager4.c = a2;
        nPCConversationManager3.E = a3;
        nPCConversationManager3.g = a4;
        nPCConversationManager2.B = a5;
        nPCConversationManager2.K = a7;
        nPCConversationManager.d = a8;
        nPCConversationManager.script = a6;
        if (a2.getPlayer() != null) {
            a2.getPlayer().setNpcNow(a3);
        }
    }

    public /* synthetic */ void checkMobs(MapleCharacter a2) {
        Iterator<Integer> iterator;
        NPCConversationManager a3;
        if (a3.getMap().getAllMonstersThreadsafe().size() <= 0) {
            NPCConversationManager nPCConversationManager = a3;
            nPCConversationManager.sendOk(InventoryException.ALLATORIxDEMO("Y\u5751\u576c\u4e6b\u6ce8\u6768\u6050\u7208\u549c@[\u3063"));
            nPCConversationManager.dispose();
        }
        a2 = "\u73a9\u5bb6 #b" + ((MapleCharacter)a2).getName() + "#k \u6b64\u5730\u5716\u602a\u7269\u6389\u5bf6\u67e5\u8a62:\r\n#r(\u82e5\u6709\u4efb\u4f55\u6389\u5bf6\u554f\u984c,\u8acb\u81f3\u793e\u5718BUG\u5340\u56de\u5831\u602a\u7269\u540d\u7a31\u548c\u4ee3\u78bc)\r\n#d";
        Iterator<Integer> iterator2 = iterator = a3.getMap().getAllUniqueMonsters().iterator();
        while (iterator2.hasNext()) {
            Integer n2;
            Integer n3 = n2 = iterator.next();
            a2 = (String)a2 + "#L" + n3 + "##o" + n3 + "# \u4ee3\u78bc:" + n3 + " (\u67e5\u770b)#l\r\n";
            iterator2 = iterator;
        }
        a3.sendOk((String)a2);
    }

    public /* synthetic */ String EnchantGlove(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        boolean bl2 = ItemConstants.\u985e\u578b.\u624b\u5957((int)n2) && !bl;
        Object object = "";
        int n3 = 3500;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u6231\u5936\u9b2e\u52fa\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (bl2) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u624b\u5957\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            a3 = (short)Randomizer.rand(a3, a4);
            Equip equip3 = equip2;
            short s2 = (short)(equip3.getMp() + a3);
            a4 = s2;
            equip3.setMp((short)(s2 > n3 ? (int)n3 : a4));
            object = (String)object + "\u9b54\u529b:  " + (short)a3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316MP[" + (n4 += a3) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u6274\u5907\u5508q\u50fa\u6759\u6274\u5907\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ void checkMapDrops(MapleCharacter a2) {
        NPCConversationManager a3;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Object object = MapleImp.ALLATORIxDEMO("\u001c2");
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.ITEM;
        a2 = ((MapleCharacter)a2).getMap().getMapObjectsInRange(((AbstractMapleMapObject)a2).getPosition(), 2.5E7, Arrays.asList(arrmapleMapObjectType));
        Iterator<MapleMapObject> iterator = a2.iterator();
        while (iterator.hasNext()) {
            MapleMapObject mapleMapObject = iterator.next();
            if (a2 == null) {
                return;
            }
            MapleMapItem mapleMapItem = (MapleMapItem)mapleMapObject;
            if (linkedList.contains(mapleMapItem.getItemId()) || mapleMapItem.getItemId() < 1000000) continue;
            linkedList.add(mapleMapItem.getItemId());
        }
        if (linkedList.size() > 0) {
            iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                int n2 = (Integer)((Object)iterator.next());
                if (!MapleItemInformationProvider.getInstance().itemExists(n2)) continue;
                int n3 = n2;
                object = (String)object + "#L" + n3 + "##i" + n3 + "#  #t" + n3 + "# #l\r\n";
            }
        } else {
            object = (String)object + "#r\u5730\u5716\u4e0a\u6c92\u6709\u4efb\u4f55\u6389\u843d\u7269\u54e6!";
        }
        a3.sendOk((String)object);
    }

    public /* synthetic */ boolean addFromDrop(Object a2) {
        if (a2 instanceof IItem) {
            NPCConversationManager a3;
            a2 = (IItem)a2;
            return MapleInventoryManipulator.checkSpace(a3.getClient(), a2.getItemId(), a2.getQuantity(), a2.getOwner()) && MapleInventoryManipulator.addFromDrop(a3.getClient(), (IItem)a2, false);
        }
        return false;
    }

    public /* synthetic */ void playerMoveRight() {
        NPCConversationManager a2;
        int[] arrn = new int[1];
        arrn[0] = 2;
        a2.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedInput.getValue(), null, arrn);
    }

    public /* synthetic */ Invocable getIv() {
        NPCConversationManager a2;
        return a2.d;
    }

    public /* synthetic */ String SendInviteGifts(MapleCharacter a2, String a3) {
        String string = a3;
        MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string);
        int n2 = World.Find.findChannel(string);
        if (mapleCharacter != null) {
            if (n2 <= 0) {
                return InventoryException.ALLATORIxDEMO("\u6b1e\u73c8\u5bcc\u768f\u5237\u4e6c\u5752\u7dbb\u4e70@\u8ab1\u7b28\u5fff\u4eb7\u4e70\u7dbb\u51f7\u9053\u8836\u732f\u528f\u512d\u63a1@");
            }
            if (a2.getPrizeLog(MapleImp.ALLATORIxDEMO("\u90bf\u8a9b\u7371\u52a5\u5173\u638b")) >= 1) {
                return InventoryException.ALLATORIxDEMO("\u60d2\u76e5\u5e49\u863e\u5d88\u7df2\u5136\u63ba\u9034\u90e1\u8ab1\u732f\u528f\u4ee7\u55ee\uff60");
            }
            if (a3.equals(a2.getName())) {
                return MapleImp.ALLATORIxDEMO("\u6097\u7171\u6cea\u511c\u63e4\u731e\u52ca\u7d36\u81d5\u5da1\u55ab\uff51");
            }
            if (mapleCharacter.getPrizeLog(InventoryException.ALLATORIxDEMO("\u90e1\u8ab1\u4edb\u6b5b\u6519")) >= 10) {
                return MapleImp.ALLATORIxDEMO("\u5c5d\u6586\u5da2\u7dac\u90d0\u8af4\u4ed6\u000e`\u5034\u4eea\u711e\u6c85\u51b2\u9848\u53e9\u5699\u001eq");
            }
            if (a2.getLevel() < 70) {
                return InventoryException.ALLATORIxDEMO("\u60c9\u76fe\u7b28\u7d60\u9761\u89fb\u9035\u524aVJ\u7b28\u55ee\uff60");
            }
            mapleCharacter.modifyCSPoints(2, 60, true);
            a2.modifyCSPoints(2, 150, true);
            mapleCharacter.dropMessage(1, "\u60a8\u5df2\u6536\u5230\u4f86\u81ea" + a2.getName() + "\u6240\u767c\u9001\u7684\u7279\u5225\u9080\u8acb\u734e\u52f5!");
            mapleCharacter.setPrizeLog(MapleImp.ALLATORIxDEMO("\u90d0\u8af4\u4eea\u6b1e\u6528"));
            a2.setPrizeLog(InventoryException.ALLATORIxDEMO("\u90fa\u8aaa\u7334\u5294\u5136\u63ba"));
            FileoutputUtil.logToFile(MapleImp.ALLATORIxDEMO("S?X#\u0010\u0014^$^\u007f\u90bf\u8a9b\u7371\u52a5\u5173\u638b\u0011$G$"), "\r\n " + FileoutputUtil.NowTime() + "\u88ab\u9080\u8acb\u8005: " + a2.getName() + " \u5df2\u514c\u63db\u9080\u8acb\u734e\u52f5\u3002 \u9080\u8acb\u4eba: " + mapleCharacter.getName());
            return InventoryException.ALLATORIxDEMO("\u96a3\u65d8\u76fc\u5d93\u7606\u9060\u90fa\u8aaa\u7334\u5294[\u90e1\u8ab1\u4edb\u7308\u5ff6LQ\u9ea4\u6932\u9ea4@wk\u4e6e\u88ca\u90fa\u8aaa\u4ec0\u7313\u5fedPOQ\u9ea4\u6932\u9ea4@");
        }
        return MapleImp.ALLATORIxDEMO("\u67b5\u8a5d\u4e5d\u520f\u6b34\u7396\u5be6\u8cf8\u8a5a\u0013\u8a9b\u8f07\u5135\u6b5c\u78ea\u76bb\u73f9\u5b89\u0019{q");
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getNumberIcon(int a2, int a3) {
        if (a3 < 0 || a3 > 3) {
            a3 = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = BitTools.intToArray(a2);
        int n2 = a2 = 0;
        while (n2 < arrayList.size()) {
            switch ((Integer)arrayList.get(a2)) {
                case 0: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/0/0#");
                    break;
                }
                case 1: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/1/0#");
                    break;
                }
                case 2: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/2/0#");
                    break;
                }
                case 3: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/3/0#");
                    break;
                }
                case 4: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/4/0#");
                    break;
                }
                case 5: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/5/0#");
                    break;
                }
                case 6: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/6/0#");
                    break;
                }
                case 7: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/7/0#");
                    break;
                }
                case 8: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/8/0#");
                    break;
                }
                case 9: {
                    stringBuilder.append("#fEffect/BasicEff/Combo/" + a3 + "/9/0#");
                    break;
                }
            }
            n2 = ++a2;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ byte isSquadMember(String a2) {
        NPCConversationManager a3;
        a2 = a3.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 == null) {
            return -1;
        }
        if (((MapleSquad)a2).getMembers().contains(a3.c.getPlayer().getName())) {
            return 1;
        }
        if (((MapleSquad)a2).isBanned(a3.c.getPlayer())) {
            return 2;
        }
        return 0;
    }

    public /* synthetic */ void sendPrevS(String a2, byte a3) {
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a4.sendSimpleS(a2, a3);
            return;
        }
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000ep\u000f`"), a3));
        a4.a = 0;
    }

    public /* synthetic */ String EnchantCashEqipFanMS(byte a2, int a3) {
        boolean bl;
        NPCConversationManager a4;
        Equip equip = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        Equip equip2 = (Equip)equip.copy();
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl2 = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        short s2 = 0;
        short s3 = 0;
        if (equip2.getOwner().equals(MapleImp.ALLATORIxDEMO("\u5da2\u967b\u9b04\n\u6b71"))) {
            return InventoryException.ALLATORIxDEMO("\u60c9\u963e\u9b35\u5d88\u9035O\u6b40V\u7140\u6caf\u7e1d\u7ef6\u9625\u9b2e@");
        }
        if (a3 == 1) {
            s2 = 1;
            s3 = 1;
            bl = bl2;
        } else if (a3 == 2) {
            s2 = 3;
            s3 = 3;
            bl = bl2;
        } else {
            if (a3 == 3) {
                s2 = 5;
                s3 = 5;
            }
            bl = bl2;
        }
        if (bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u9644\u9b54\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip3 = equip2;
            equip3.setWatk((short)(equip3.getWatk() + s2 > 0 ? equip2.getWatk() + s2 : 0));
            object = (String)object + "\u7269\u7406\u653b\u64ca:  " + s2 + "\r\n";
            Equip equip4 = equip2;
            equip4.setMatk((short)(equip4.getMatk() + s3 > 0 ? equip2.getMatk() + s3 : 0));
            object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + s3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            Equip equip5 = equip2;
            a3 = StringTool.getIntFromString(equip5.getOwner());
            equip5.setOwner("\u5df2\u9644\u9b54" + ++a3 + "\u6b21");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), equip, false);
            a4.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
    }

    public /* synthetic */ String SendInviteGiftAnn(MapleCharacter a2, String a3) {
        String string = a3;
        MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string);
        int n2 = World.Find.findChannel(string);
        if (mapleCharacter != null) {
            if (n2 <= 0) {
                return InventoryException.ALLATORIxDEMO("\u6b1e\u73c8\u5bcc\u768f\u5237\u4e6c\u5752\u7dbb\u4e70@\u8ab1\u7b28\u5fff\u4eb7\u4e70\u7dbb\u51f7\u9053\u8836\u732f\u528f\u512d\u63a1@");
            }
            if (a2.getPrizeLog(MapleImp.ALLATORIxDEMO("\u90bf\u8a9b\u7371\u52a5\u5173\u638b")) >= 1) {
                return InventoryException.ALLATORIxDEMO("\u60d2\u76e5\u5e49\u863e\u5d88\u7df2\u5136\u63ba\u9034\u90e1\u8ab1\u732f\u528f\u4ee7\u55ee\uff60");
            }
            if (a3.equals(a2.getName())) {
                return MapleImp.ALLATORIxDEMO("\u6097\u7171\u6cea\u511c\u63e4\u731e\u52ca\u7d36\u81d5\u5da1\u55ab\uff51");
            }
            if (a2.getAccountID() <= 1784) {
                return InventoryException.ALLATORIxDEMO("QCNHT\u4e31\u5fed\u65ca\u5214\u5e80\u76e5\u5e49\u863e\u6237\u88ca\u7c81\u7d10\u5be0\u70db\u88d1\u90e1\u8ab1\u76e5\u65ca\u73c8\u5bcc\uff60\u60d2\u5c0d\u65c6\u5129\u92a8\u73c8\u5bcc\u7140\u6caf\u4f1e\u7552\u6b05\u52e5\u809c[\u8df4\u5f91\u53da\u90fa\u8aaa\u65ca\u73c8\u5bcc\u7313\u5fed\u9ebf\u6502\u5446[@");
            }
            if (a2.getLevel() < 50 || mapleCharacter.getLevel() < 50) {
                return MapleImp.ALLATORIxDEMO("\u96e6\u65e9\u6736\u4e50\u4e85\u677a\u906be\u000f\u7b19\u54d9q\u001eq");
            }
            mapleCharacter.gainItem(2450000, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            mapleCharacter.gainItem(5220000, 5, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            mapleCharacter.gainItem(2022179, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            mapleCharacter.gainItem(4000038, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            MapleCharacter mapleCharacter2 = mapleCharacter;
            mapleCharacter.modifyCSPoints(true ? (byte)1 : 0, 350, true);
            mapleCharacter2.setVPoints(mapleCharacter2.getVPoints() + 1);
            mapleCharacter2.dropMessage(1, "\u60a8\u5df2\u6536\u5230\u4f86\u81ea" + a2.getName() + "\u6240\u767c\u9001\u7684\u9080\u8acb\u734e\u52f5");
            a2.gainItem(5220000, 5, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(2022463, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(2022179, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(2450000, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(4000038, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            a2.gainItem(4251202, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            MapleCharacter mapleCharacter3 = a2;
            mapleCharacter3.modifyCSPoints(true ? (byte)1 : 0, 500, true);
            mapleCharacter3.setPrizeLog(InventoryException.ALLATORIxDEMO("\u90fa\u8aaa\u7334\u5294\u5136\u63ba"));
            FileoutputUtil.logToFile(MapleImp.ALLATORIxDEMO("S?X#\u0010\u0014^$^\u007f\u90bf\u8a9b\u7371\u52a5\u5173\u638b\u0011$G$"), "\r\n " + FileoutputUtil.NowTime() + "\u88ab\u9080\u8acb\u8005: " + a2.getName() + " \u5df2\u514c\u63db\u9080\u8acb\u734e\u52f5\u3002 \u9080\u8acb\u4eba: " + mapleCharacter.getName());
            return InventoryException.ALLATORIxDEMO("\u96b8\u65c3\u76e7\u5d88\u761d\u907b\u90e1\u8ab1\u732f\u528f@");
        }
        return MapleImp.ALLATORIxDEMO("\u67b5\u8a5d\u4e5d\u520f\u6b34\u7396\u5be6\u8cf8\u8a5a\u0013\u8a9b\u8f07\u5135\u6b5c\u78ea\u76bb\u73f9\u5b89\u0019{q");
    }

    public /* synthetic */ void sendGetText(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(MapleImp.ALLATORIxDEMO("\u001c\u001c"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.getPlayer().clearNpcSelect();
        nPCConversationManager.c.getPlayer().addNpcSelect(-999999999);
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalkText(a3.E, a2));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendGetText;
    }

    public /* synthetic */ String EnchantAllHp(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        Object object = "";
        int n3 = 3500;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u883a\u91ae\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (!bl) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            a3 = (short)Randomizer.rand(a3, a4);
            Equip equip3 = equip2;
            short s2 = (short)(equip3.getHp() + a3);
            a4 = s2;
            equip3.setHp((short)(s2 > n3 ? (int)n3 : a4));
            object = (String)object + "\u8840\u91cf:  " + (short)a3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316HP[" + (n4 += a3) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u6610\u9e8e\u88e2\u7171\u6cea\u4f2f\u7517.");
    }

    public /* synthetic */ void sendNextPrevS(String a2, byte a3, int a4) {
        NPCConversationManager a5;
        if (a5.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a5.sendSimpleS(a2, a3);
            return;
        }
        a5.c.sendPacket(MaplePacketCreator.getNPCTalk(a4, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000ep\u000fa"), a3, a4));
        a5.a = 0;
    }

    public final /* synthetic */ void doJapaneseWeddingEffect(Object a2) {
        NPCConversationManager a3;
        a2 = (MapleCharacter)a2;
        Object object = InventoryException.ALLATORIxDEMO("\u6270\u506b\u4eab\u5953\u664e\u70c0\u4ee7\u89f1\u8b28\u5113\u506a\u5e0e\u8f74\u4ec0\u76e5\u6161\u60a4\u8076\u803b\u96bc\u5749\u6b1e\uff60\u64a0\u8acb\u4e70\u5948\u623a\u7543\u7da0\u76e5\u5a20\u7d82\uff76\u664e\u4e9f\u7dbf\u5e4c\u80c4\u80df\u76e5\u7d7f\u8213\u7da4\u5e57\u623a\u7dcc\u7e11\u51ec\u4e7a\u8d16\u3078\u6270\u6089\u9078\u5113\u506a\u4ec0\uff6d\u5c4b\u664e\u6204\u5251\u4efc\u7dbf\u5e4c\u5387\u4e7a\u7a8e\u76fe\u5c6c\u65c3\uff60");
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getMap().broadcastMessage(MaplePacketCreator.yellowChat(MapleImp.ALLATORIxDEMO("\u6241\u502e\u4e9a\u5916\u667f\u7085\u4ed6\u89b4\u8b19\u5156\u505b\u5e4b\u8f45\u4e85\u76d4\u6124\u6095\u8033\u800a\u96f9\u5778\u6b5b\uff51\u64e5\u8afa\u4e35\u5979\u627f\u7572\u7de5\u76d4\u5a65\u7db3\uff33\u667f\u4eda\u7d8e\u5e09\u80f5\u809a\u76d4\u7d3a\u8222\u7de1\u5e66\u627f\u7dfd\u7e54\u51dd\u4e3f\u8d27\u303d\u6241\u60cc\u9049\u5156\u505b\u4e85\uff5c\u5c0e\u667f\u6241\u5260\u4eb9\u7d8e\u5e09\u53b6\u4e3f\u7abf\u76bb\u5c5d\u6586\uff51")));
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            public final /* synthetic */ MapleCharacter d;
            {
                4 a3;
                a3.d = mapleCharacter;
            }

            @Override
            public /* synthetic */ void run() {
                4 a2;
                if (a2.d == null || a2.NPCConversationManager.this.getPlayer() == null) {
                    a2.NPCConversationManager.this.warpMap(680000500, 0);
                    return;
                }
                String string = LittleEndianAccessor.ALLATORIxDEMO("\u5705\u6f3f\u955a\u7690\u65e8\u9000\u4e00\uff18\u5705\u7135\u6555\u7690\u65e8\u4eae\u4e66\u9587\u0003:\u0003:\u80d0\u5934\u6253\u5224\u5f51\u6b70\uff21\u900d\u8a87\u663b\u6958\u5933\u76a9\u5e6c\u9066\uff15\u5c2a\u7728\u5260\u7690\u5e55\u905f\u662a\u83fb\u7097\u5e6c\u79a2:\u0003:\u0003\u8018\u9034\u5c25\u6602\u517d\u4e97\u7728\u5260\u7690\u4ed6\u52cd\u302f");
                a2.NPCConversationManager.this.getMap().broadcastMessage(MaplePacketCreator.yellowChat(MapleParty.ALLATORIxDEMO("\u5731\u6f5b\u956e\u76f4\u65dc\u9064\u4e34\uff7c\u5731\u7151\u6561\u76f4\u65dc\u4eca\u4e52\u95e37^7^\u80e4\u5950\u6267\u5240\u5f65\u6b14\uff15\u9069\u8ab3\u665f\u696c\u5957\u769d\u5e08\u9052\uff71\u5c1e\u774c\u5254\u76f4\u5e61\u903b\u661e\u839f\u70a3\u5e08\u7996^7^7\u807c\u9000\u5c41\u6636\u5119\u4ea3\u774c\u5254\u76f4\u4ee2\u52a9\u301b")));
            }
        }, 3000L);
        object = nPCConversationManager.getPlayer().getName() + "\u65b0\u90ce\uff01\u4f60\u9858\u610f\u611b\u8457 " + ((MapleCharacter)a2).getName() + "\u5a18\u76f4\u5230\u9ed1\u9aee\u8b8a\u6210\u96ea\u5409\u62c9\u6bdb\u9aee\u822c\u96ea\u767d\u55ce\uff1f";
        a3.getMap().broadcastMessage(MaplePacketCreator.yellowChat((String)object));
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            public final /* synthetic */ MapleCharacter d;

            @Override
            public /* synthetic */ void run() {
                5 a2;
                if (a2.d == null || a2.NPCConversationManager.this.getPlayer() == null) {
                    a2.NPCConversationManager.this.warpMap(680000500, 0);
                    return;
                }
                String string = a2.d.getName() + " \u65b0\u5a18\uff01\u59b3\u9858\u610f\u611b\u8457" + a2.NPCConversationManager.this.getPlayer().getName() + "\u65b0\u90ce\u76f4\u5230\u51b0\u539f\u96ea\u7389\u7684\u842c\u5e74\u96ea\u878d\u5316\u6b86\u76e1\u55ce\uff1f";
                a2.NPCConversationManager.this.getMap().broadcastMessage(MaplePacketCreator.yellowChat(string));
            }
            {
                5 a3;
                a3.d = mapleCharacter;
            }
        }, 3000L);
        Timer.MapTimer.getInstance().schedule(new Runnable(){
            public final /* synthetic */ MapleCharacter d;
            {
                6 a3;
                a3.d = mapleCharacter;
            }

            @Override
            public /* synthetic */ void run() {
                6 a2;
                if (a2.d == null || a2.NPCConversationManager.this.getPlayer() == null) {
                    6 v2;
                    if (a2.NPCConversationManager.this.getPlayer() != null) {
                        6 v0 = a2;
                        6 v1 = a2;
                        v2 = v1;
                        v0.NPCConversationManager.this.setQuestRecord(v1.NPCConversationManager.this.getPlayer(), 160005, "3");
                        v0.NPCConversationManager.this.setQuestRecord(a2.NPCConversationManager.this.getPlayer(), 160006, L.ALLATORIxDEMO("\u001f"));
                    } else {
                        if (a2.d != null) {
                            6 v3 = a2;
                            a2.NPCConversationManager.this.setQuestRecord(v3.d, 160005, "3");
                            v3.NPCConversationManager.this.setQuestRecord(a2.d, 160006, MapleFamily.ALLATORIxDEMO("p"));
                        }
                        v2 = a2;
                    }
                    v2.NPCConversationManager.this.warpMap(680000500, 0);
                    return;
                }
                6 v4 = a2;
                6 v5 = a2;
                v4.NPCConversationManager.this.setQuestRecord(v5.NPCConversationManager.this.getPlayer(), 160005, "2");
                v4.NPCConversationManager.this.setQuestRecord(a2.d, 160005, "2");
                v5.NPCConversationManager.this.sendNPCText(L.ALLATORIxDEMO("\u8ae4\u626f\u4eca\u53ec\u528f\u9036\u581b\u5a75\u7981\u76ab\u542b\u4f62\uff23\u4f73\u7095\u9036\u581b\u6d58\u8abc\u5c5e\u76f0\u76ab\u8b66\u4e95\u5408\uff2e\u000f\u623e\u5707\u6b4b\u5b8c\u5e2c\u0001\u0001\u0001\u5707\u5908\u5b99\u76ab\u7972\u79a0\u4e02\uff23\u5146\u4e95\u7d7f\u7095\u5904\u5994\u302d"), 9110200);
                if (v4.d.getGuildId() > 0) {
                    World.Guild.guildPacket(a2.d.getGuildId(), MaplePacketCreator.sendMarriage(false, a2.d.getName()));
                }
                if (a2.d.getFamilyId() > 0) {
                    World.Family.familyPacket(a2.d.getFamilyId(), MaplePacketCreator.sendMarriage(true, a2.d.getName()), a2.d.getId());
                }
                if (a2.NPCConversationManager.this.getPlayer().getGuildId() > 0) {
                    World.Guild.guildPacket(a2.NPCConversationManager.this.getPlayer().getGuildId(), MaplePacketCreator.sendMarriage(false, a2.NPCConversationManager.this.getPlayer().getName()));
                }
                if (a2.NPCConversationManager.this.getPlayer().getFamilyId() > 0) {
                    World.Family.familyPacket(a2.NPCConversationManager.this.getPlayer().getFamilyId(), MaplePacketCreator.sendMarriage(true, a2.d.getName()), a2.NPCConversationManager.this.getPlayer().getId());
                }
            }
        }, 20000L);
    }

    public /* synthetic */ void forceStartQuest(String a2) {
        NPCConversationManager a3;
        MapleQuest.getInstance(a3.g).forceStart(a3.getPlayer(), a3.getNpc(), a2);
    }

    public /* synthetic */ void askAcceptDeclineNoESC(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(MapleImp.ALLATORIxDEMO("\u001c\u001c"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, MaplePacketOperation.NPCStatus.askAcceptDeclineNoESC, a2, "", (byte)0));
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.askAcceptDeclineNoESC;
    }

    public /* synthetic */ void genericGuildMessage(int a2) {
        NPCConversationManager a3;
        a3.c.sendPacket(MaplePacketCreator.genericGuildMessage((byte)a2));
    }

    public /* synthetic */ int setAvatar(int a2, int a3) {
        NPCConversationManager a4;
        return a4.setAvatar(a2, a3, false);
    }

    public /* synthetic */ String SendInviteGiftTree(MapleCharacter a2, String a3) {
        String string = a3;
        MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string);
        int n2 = World.Find.findChannel(string);
        MapleCharacter mapleCharacter2 = mapleCharacter;
        int n3 = mapleCharacter2.getPrizeLog(InventoryException.ALLATORIxDEMO("\u90e1\u8ab1\u4edb\u6b5b\u6519"));
        if (mapleCharacter2 != null) {
            MapleCharacter mapleCharacter3;
            if (n2 <= 0) {
                return MapleImp.ALLATORIxDEMO("\u6b5b\u73f9\u5b89\u76be\u5272\u4e5d\u5717\u7d8a\u4e35q\u8af4\u7b19\u5fba\u4e86\u4e35\u7d8a\u51b2\u9062\u8873\u731e\u52ca\u511c\u63e4q");
            }
            if (a2.getPrizeLog(InventoryException.ALLATORIxDEMO("\u90fa\u8aaa\u7334\u5294\u5136\u63ba")) >= 1) {
                return MapleImp.ALLATORIxDEMO("\u6097\u76d4\u5e0c\u860f\u5dcd\u7dc3\u5173\u638b\u9071\u90d0\u8af4\u731e\u52ca\u4ed6\u55ab\uff51");
            }
            if (n3 >= 10) {
                return InventoryException.ALLATORIxDEMO("\u5c6c\u65c3\u5d93\u7de9\u90e1\u8ab1\u4ee7KQ\u5071\u4edb\u715b\u6cb4\u51f7\u9879\u53ac\u56a8[@");
            }
            if (a3.equals(a2.getName())) {
                return MapleImp.ALLATORIxDEMO("\u6097\u7171\u6cea\u511c\u63e4\u731e\u52ca\u7d36\u81d5\u5da1\u55ab\uff51");
            }
            if (mapleCharacter.getLevel() < 70) {
                return InventoryException.ALLATORIxDEMO("\u63d2\u85c7\u4ec0\u9761\u89fb\u9035\u524aVJ\u7b28\u55ee\uff60");
            }
            if (a2.getLevel() < 50) {
                return MapleImp.ALLATORIxDEMO("\u60f8\u76bb\u7b19\u7d25\u9750\u89be\u9004\u520fe\u000f\u7b19\u55ab\uff51");
            }
            if (a2.getAccountID() <= 625) {
                return InventoryException.ALLATORIxDEMO("PKNKR\u4e31\u5fed\u65ca\u5214\u5e80\u76e5\u5e49\u863e\u6237\u88ca\u7c81\u7d10\u5be0\u70db\u88d1\u90e1\u8ab1\u76e5\u65ca\u73c8\u5bcc\uff60\u60d2\u5c0d\u65c6\u5129\u92a8\u73c8\u5bcc\u7140\u6caf\u4f1e\u7552\u6b05\u52e5\u809c[\u8df4\u5f91\u53da\u90fa\u8aaa\u65ca\u73c8\u5bcc\u7313\u5fed\u9ebf\u6502\u5446[@");
            }
            switch (n3) {
                case 0: {
                    MapleCharacter mapleCharacter4 = mapleCharacter;
                    while (false) {
                    }
                    mapleCharacter3 = mapleCharacter4;
                    mapleCharacter4.modifyCSPoints(2, 1000, true);
                    break;
                }
                case 1: {
                    MapleCharacter mapleCharacter5 = mapleCharacter;
                    mapleCharacter3 = mapleCharacter5;
                    mapleCharacter5.modifyCSPoints(2, 1000, true);
                    break;
                }
                case 2: {
                    MapleCharacter mapleCharacter6 = mapleCharacter;
                    mapleCharacter3 = mapleCharacter6;
                    mapleCharacter6.modifyCSPoints(2, 1000, true);
                    break;
                }
                case 3: {
                    MapleCharacter mapleCharacter7 = mapleCharacter;
                    mapleCharacter3 = mapleCharacter7;
                    mapleCharacter7.modifyCSPoints(true ? (byte)1 : 0, 1000, true);
                    break;
                }
                case 4: {
                    mapleCharacter.gainItem(5220010, 1, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                    mapleCharacter3 = mapleCharacter;
                    break;
                }
                case 5: {
                    mapleCharacter.gainItem(2450000, 3, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                    mapleCharacter3 = mapleCharacter;
                    break;
                }
                case 6: {
                    mapleCharacter.gainItem(2022530, 5, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                    mapleCharacter3 = mapleCharacter;
                    break;
                }
                case 7: {
                    mapleCharacter.gainItem(4001460, 10, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                    mapleCharacter3 = mapleCharacter;
                    break;
                }
                case 8: {
                    mapleCharacter.gainItem(4001460, 10, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
                    mapleCharacter3 = mapleCharacter;
                    break;
                }
                case 9: {
                    MapleCharacter mapleCharacter8 = mapleCharacter;
                    mapleCharacter8.setPoints(mapleCharacter8.getPoints() + 1000);
                }
                default: {
                    mapleCharacter3 = mapleCharacter;
                }
            }
            mapleCharacter3.setVPoints(mapleCharacter.getVPoints() + 1);
            mapleCharacter.dropMessage(1, "\u60a8\u5df2\u6536\u5230\u4f86\u81ea" + a2.getName() + "\u6240\u767c\u9001\u7684\u9080\u8acb\u734e\u52f5");
            mapleCharacter.setPrizeLog(MapleImp.ALLATORIxDEMO("\u90d0\u8af4\u4eea\u6b1e\u6528"));
            a2.gainItem(2450000, 2, a3 + "\u9080\u8acb" + a2.getName() + "\u6240\u7372\u5f97");
            MapleCharacter mapleCharacter9 = a2;
            mapleCharacter9.modifyCSPoints(2, 2000, true);
            mapleCharacter9.setPrizeLog(InventoryException.ALLATORIxDEMO("\u90fa\u8aaa\u7334\u5294\u5136\u63ba"));
            FileoutputUtil.logToFile(MapleImp.ALLATORIxDEMO("S?X#\u0010\u0014^$^\u007f\u90bf\u8a9b\u7371\u52a5\u5173\u638b\u0011$G$"), "\r\n " + FileoutputUtil.NowTime() + "\u88ab\u9080\u8acb\u8005: " + a2.getName() + " \u5df2\u514c\u63db\u9080\u8acb\u734e\u52f5\u3002 \u9080\u8acb\u4eba: " + mapleCharacter.getName());
            return InventoryException.ALLATORIxDEMO("\u96b8\u65c3\u76e7\u5d88\u761d\u907b\u90e1\u8ab1\u732f\u528f@");
        }
        return MapleImp.ALLATORIxDEMO("\u67b5\u8a5d\u4e5d\u520f\u6b34\u7396\u5be6\u8cf8\u8a5a\u0013\u8a9b\u8f07\u5135\u6b5c\u78ea\u76bb\u73f9\u5b89\u0019{q");
    }

    public /* synthetic */ void sendUltimateExplorer() {
        NPCConversationManager a2;
        a2.getClient().sendPacket(MaplePacketCreator.ultimateExplorer());
    }

    public /* synthetic */ void updateBuddyCapacity(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().setBuddyCapacity((byte)a2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ String EnchantCashEqip(byte a, int a) {
        var4_4 = var3_3 = (Equip)a.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a);
        var5_5 = a.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a).getItemId();
        var6_7 = MapleItemInformationProvider.getInstance().isCash(var5_5);
        var7_8 = "";
        if (var6_7 == 0) return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
        v0 = var4_4;
        v1 = var4_4;
        v2 = var4_4;
        v3 = var4_4;
        v4 = var4_4;
        v5 = var4_4;
        var4_4.setStr((short)0);
        v5.setDex((short)0);
        v5.setInt((short)0);
        v4.setLuk((short)0);
        v4.setHp((short)0);
        v3.setMp((short)0);
        v3.setWatk((short)0);
        v2.setMatk((short)0);
        v2.setWdef((short)0);
        v1.setMdef((short)0);
        v1.setAcc((short)0);
        v0.setSpeed((short)0);
        v0.setJump((short)0);
        var7_8 = (String)var7_8 + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + var5_5 + "##k\r\n";
        var7_8 = (String)var7_8 + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
        var7_8 = (String)var7_8 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        var5_6 = new LinkedList<Integer>();
        v6 = var6_7 = 0;
        while (true) {
            if (v6 >= a) {
                var7_8 = (String)var7_8 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
                var7_8 = (String)var7_8 + "\u8acb\u554f\u60a8\u662f\u5426\u8981\u518d\u6263\u9664\u4e00\u6b21\u6d88\u8017\u54c1\u91cd\u65b0\u9644\u9b54?\r\n#d[\u9ede\u9078#r\u662f#d,\u91cd\u65b0\u9644\u9b54] [\u9ede\u9078#r\u5426#d,\u5b58\u53d6\u76ee\u524d\u9644\u9b54]\r\n#d\u82e5\u88dd\u5099\u7d20\u8cea\u672a\u6539\u8b8a,\u8acb\u91cd\u65b0\u767b\u5165\u6216\u63db\u983b\u5373\u53ef\u751f\u6548!";
                v7 = var4_4;
                var6_7 = StringTool.getIntFromString(v7.getOwner());
                v7.setOwner("\u5df2\u9644\u9b54" + ++var6_7 + "\u6b21");
                var3_3 = (Equip)var4_4.copy();
                MapleInventoryManipulator.removeFromSlot(a.getClient(), MapleInventoryType.EQUIP, a, var3_3.getQuantity(), false);
                MapleInventoryManipulator.addFromDrop(a.getClient(), var3_3, false);
                a.c.getPlayer().equipChanged();
                return var7_8;
            }
            var8_9 = Randomizer.rand(0, 12);
            while (var5_6.contains(var8_9 = Randomizer.rand(0, 12))) {
            }
            v8 = var8_9;
            var5_6.add(Integer.valueOf(v8));
            if (v8 != 6 && var8_9 != 7) ** GOTO lbl76
            var9_10 = Randomizer.rand(0, 100);
            if (a == 2 && var9_10 < 85) {
                var8_9 = Randomizer.rand(0, 12);
                while (var5_6.contains(var8_9 = Randomizer.rand(0, 12))) {
                }
                v9 = var8_9;
                v10 = v9;
                var5_6.add(Integer.valueOf(v9));
            } else if (a == 3 && var9_10 < 70) {
                var8_9 = Randomizer.rand(0, 12);
                while (var5_6.contains(var8_9 = Randomizer.rand(0, 12))) {
                }
                v11 = var8_9;
                v10 = v11;
                var5_6.add(Integer.valueOf(v11));
            } else {
                if (a == 4 && var9_10 < 50) {
                    var8_9 = Randomizer.rand(0, 12);
                    while (var5_6.contains(var8_9 = Randomizer.rand(0, 12))) {
                    }
                    var5_6.add(Integer.valueOf(var8_9));
                }
lbl76:
                // 4 sources

                v10 = var8_9;
            }
            switch (v10) {
                case 0: {
                    var9_10 = (short)Randomizer.rand(1, 5);
                    v12 = var4_4;
                    v13 = var9_10;
                    v12.setStr((short)(v12.getStr() + v13));
                    var7_8 = (String)var7_8 + "\u529b\u91cf + " + v13 + "\r\n";
                    break;
                }
                case 1: {
                    var8_9 = (short)Randomizer.rand(1, 5);
                    v14 = var4_4;
                    v15 = var8_9;
                    v14.setDex((short)(v14.getDex() + v15));
                    var7_8 = (String)var7_8 + "\u654f\u6377:  " + v15 + "\r\n";
                    break;
                }
                case 2: {
                    var8_9 = (short)Randomizer.rand(1, 5);
                    v16 = var4_4;
                    v17 = var8_9;
                    v16.setInt((short)(v16.getInt() + v17));
                    var7_8 = (String)var7_8 + "\u667a\u529b:  " + v17 + "\r\n";
                    break;
                }
                case 3: {
                    var8_9 = (short)Randomizer.rand(1, 5);
                    v18 = var4_4;
                    v19 = var8_9;
                    v18.setLuk((short)(v18.getLuk() + v19));
                    var7_8 = (String)var7_8 + "\u5e78\u904b:  " + v19 + "\r\n";
                    break;
                }
                case 4: {
                    var8_9 = (short)Randomizer.rand(50, 150);
                    v20 = var4_4;
                    v21 = var8_9;
                    v20.setHp((short)(v20.getHp() + v21));
                    var7_8 = (String)var7_8 + "HP:  " + v21 + "\r\n";
                    break;
                }
                case 5: {
                    var8_9 = (short)Randomizer.rand(50, 150);
                    v22 = var4_4;
                    v23 = var8_9;
                    v22.setMp((short)(v22.getMp() + v23));
                    var7_8 = (String)var7_8 + "MP:  " + v23 + "\r\n";
                    break;
                }
                case 6: {
                    var8_9 = 0;
                    var9_10 = Randomizer.rand(1, 100);
                    if (a == 2) {
                        if (var9_10 < 85) {
                            var8_9 = 1;
                            v24 = var4_4;
                        } else if (85 < var9_10 && var9_10 < 97) {
                            var8_9 = 2;
                            v24 = var4_4;
                        } else {
                            var8_9 = 3;
                            v24 = var4_4;
                        }
                    } else if (a == 3) {
                        if (var9_10 < 70) {
                            var8_9 = 1;
                            v24 = var4_4;
                        } else if (70 < var9_10 && var9_10 < 90) {
                            var8_9 = 2;
                            v24 = var4_4;
                        } else {
                            var8_9 = 3;
                            v24 = var4_4;
                        }
                    } else if (var9_10 < 50) {
                        var8_9 = 1;
                        v24 = var4_4;
                    } else if (50 < var9_10 && var9_10 < 85) {
                        var8_9 = 2;
                        v24 = var4_4;
                    } else {
                        var8_9 = 3;
                        v24 = var4_4;
                    }
                    v24.setWatk((short)(var4_4.getWatk() + var8_9));
                    var7_8 = (String)var7_8 + "\u7269\u7406\u653b\u64ca:  " + var8_9 + "\r\n";
                    break;
                }
                case 7: {
                    var8_9 = 0;
                    var9_10 = Randomizer.rand(1, 100);
                    if (a == 2) {
                        if (var9_10 < 85) {
                            var8_9 = 1;
                            v25 = var4_4;
                        } else if (85 < var9_10 && var9_10 < 97) {
                            var8_9 = 2;
                            v25 = var4_4;
                        } else {
                            var8_9 = 3;
                            v25 = var4_4;
                        }
                    } else if (a == 3) {
                        if (var9_10 < 70) {
                            var8_9 = 1;
                            v25 = var4_4;
                        } else if (70 < var9_10 && var9_10 < 90) {
                            var8_9 = 2;
                            v25 = var4_4;
                        } else {
                            var8_9 = 3;
                            v25 = var4_4;
                        }
                    } else if (var9_10 < 50) {
                        var8_9 = 1;
                        v25 = var4_4;
                    } else if (50 < var9_10 && var9_10 < 85) {
                        var8_9 = 2;
                        v25 = var4_4;
                    } else {
                        var8_9 = 3;
                        v25 = var4_4;
                    }
                    v25.setMatk((short)(var4_4.getMatk() + var8_9));
                    var7_8 = (String)var7_8 + "\u9b54\u6cd5\u653b\u64ca:  " + var8_9 + "\r\n";
                    break;
                }
                case 8: {
                    var8_9 = (short)Randomizer.rand(20, 50);
                    v26 = var4_4;
                    v27 = var8_9;
                    v26.setWdef((short)(v26.getWdef() + v27));
                    var7_8 = (String)var7_8 + "\u7269\u7406\u9632\u79a6 + " + v27 + "\r\n";
                    break;
                }
                case 9: {
                    var8_9 = (short)Randomizer.rand(20, 50);
                    v28 = var4_4;
                    v29 = var8_9;
                    v28.setMdef((short)(v28.getMdef() + v29));
                    var7_8 = (String)var7_8 + "\u9b54\u6cd5\u9632\u79a6:  " + v29 + "\r\n";
                    break;
                }
                case 10: {
                    var8_9 = (short)Randomizer.rand(1, 15);
                    v30 = var4_4;
                    v31 = var8_9;
                    v30.setAcc((short)(v30.getAcc() + v31));
                    var7_8 = (String)var7_8 + "\u547d\u4e2d\u7387:  " + v31 + "\r\n";
                    break;
                }
                case 11: {
                    var8_9 = (short)Randomizer.rand(1, 15);
                    v32 = var4_4;
                    v33 = var8_9;
                    v32.setSpeed((short)(v32.getSpeed() + v33));
                    var7_8 = (String)var7_8 + "\u79fb\u52d5\u901f\u5ea6:  " + v33 + "\r\n";
                    break;
                }
                default: {
                    var8_9 = (short)Randomizer.rand(1, 5);
                    v34 = var4_4;
                    v35 = var8_9;
                    v34.setJump((short)(v34.getJump() + v35));
                    var7_8 = (String)var7_8 + "\u8df3\u8e8d\u529b:  " + v35 + "\r\n";
                }
            }
            v6 = ++var6_7;
        }
    }

    public /* synthetic */ int[] getSearchData(int a22, String a32) {
        Iterator<Integer> iterator;
        Map<Integer, String> a22 = SearchGenerator.getSearchData(a22, a32);
        if (a22.isEmpty()) {
            return null;
        }
        Map<Integer, String> map = a22;
        a22 = (Map<Integer, String>)new int[map.size()];
        int a32 = 0;
        Iterator<Integer> iterator2 = iterator = map.keySet().iterator();
        while (iterator2.hasNext()) {
            int n2 = iterator.next();
            iterator2 = iterator;
            a22[a32++] = n2;
        }
        return a22;
    }

    public /* synthetic */ String disbandAlliance() {
        block7: {
            block11: {
                MapleGuild mapleGuild;
                NPCConversationManager a2;
                block9: {
                    block10: {
                        block8: {
                            mapleGuild = World.Guild.getGuild(a2.c.getPlayer().getGuildId());
                            if (mapleGuild == null || a2.c.getPlayer().getGuildRank() != 1 || a2.c.getPlayer().getAllianceRank() != 1) break block7;
                            if (mapleGuild.getAllianceId() != 0) break block8;
                            return MapleImp.ALLATORIxDEMO("\u60f8\u4e19\u6cc2\u6736\u5393\u529f\u4eab\u4f6a\u513c\u673c\u803f\u76e0q");
                        }
                        if (mapleGuild.getAllianceId() == 0 || World.Alliance.getAllianceLeader(mapleGuild.getAllianceId()) != 0) break block9;
                        if (!MapleGuildAlliance.ForceDeleteAlliance(a2.c.getPlayer().getGuildId())) break block10;
                        return InventoryException.ALLATORIxDEMO("\u8015\u76be\u5180\u739f\u750a\u5e59[\u5d93\u5f4d\u5257\u8999\u9605\u8015\u76be[\u4e6a\u6b5b\u7dcc\u4f94\u5fed\u5309\u6003\u5fd3\u6b02\u5e42@");
                    }
                    return MapleImp.ALLATORIxDEMO("\u8050\u768f\u51c5\u73ae\u754f\u5e68\u001e\u4e44\u711e\u6c85\u5f08\u5266\u89dc\u9634\u8050\u768f\u001e\u8a9b\u8050\u7e3bx\u001d\u001eq");
                }
                if (World.Alliance.getAllianceLeader(mapleGuild.getAllianceId()) != a2.c.getPlayer().getId()) break block11;
                if (World.Alliance.disbandAlliance(mapleGuild.getAllianceId())) {
                    return InventoryException.ALLATORIxDEMO("\u8982\u961e\u800e\u76a5\u6271\u52e5@");
                }
            }
            try {
                return MapleImp.ALLATORIxDEMO("\u6097\u4e76\u9761\u513c\u673c\u803f\u76e0\u9527");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return InventoryException.ALLATORIxDEMO("\u8999\u6502\u8015\u76be\u750a\u5e59");
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantCashEqipTreeMS(byte a2, int a3) {
        int n2;
        NPCConversationManager a4;
        Equip equip = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        Equip equip2 = (Equip)equip.copy();
        int n3 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n3);
        Object object = "";
        short s2 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        short s7 = 0;
        short s8 = 0;
        short s9 = 0;
        if (a3 == 1) {
            s2 = (short)Randomizer.rand(-3, 3);
            s3 = (short)Randomizer.rand(-3, 3);
            s4 = (short)Randomizer.rand(-3, 3);
            s5 = (short)Randomizer.rand(-3, 3);
            s8 = (short)Randomizer.rand(-3, 3);
            s9 = (short)Randomizer.rand(-3, 3);
            n2 = Randomizer.rand(1, 15);
            switch (n2) {
                case 1: {
                    s2 = 0;
                    s9 = 0;
                    break;
                }
                case 2: {
                    s2 = 0;
                    s3 = 0;
                    break;
                }
                case 3: {
                    s2 = 0;
                    s4 = 0;
                    break;
                }
                case 4: {
                    s2 = 0;
                    s5 = 0;
                    break;
                }
                case 5: {
                    s2 = 0;
                    s8 = 0;
                    break;
                }
                case 6: {
                    s3 = 0;
                    s4 = 0;
                    break;
                }
                case 7: {
                    s3 = 0;
                    s5 = 0;
                    break;
                }
                case 8: {
                    s3 = 0;
                    s8 = 0;
                    break;
                }
                case 9: {
                    s3 = 0;
                    s9 = 0;
                    break;
                }
                case 10: {
                    s4 = 0;
                    s5 = 0;
                    break;
                }
                case 11: {
                    s4 = 0;
                    s8 = 0;
                    break;
                }
                case 12: {
                    s4 = 0;
                    s9 = 0;
                    break;
                }
                case 13: {
                    s5 = 0;
                    s8 = 0;
                    break;
                }
                case 14: {
                    s5 = 0;
                    s9 = 0;
                    break;
                }
                case 15: {
                    s8 = 0;
                    s9 = 0;
                }
            }
        } else if (a3 == 2) {
            s2 = (short)Randomizer.rand(1, 5);
            s3 = (short)Randomizer.rand(1, 5);
            s4 = (short)Randomizer.rand(1, 5);
            s5 = (short)Randomizer.rand(1, 5);
            s8 = (short)Randomizer.rand(1, 5);
            s9 = (short)Randomizer.rand(1, 5);
            n2 = Randomizer.rand(1, 15);
            switch (n2) {
                case 1: {
                    s2 = 0;
                    s9 = 0;
                    break;
                }
                case 2: {
                    s2 = 0;
                    s3 = 0;
                    break;
                }
                case 3: {
                    s2 = 0;
                    s4 = 0;
                    break;
                }
                case 4: {
                    s2 = 0;
                    s5 = 0;
                    break;
                }
                case 5: {
                    s2 = 0;
                    s8 = 0;
                    break;
                }
                case 6: {
                    s3 = 0;
                    s4 = 0;
                    break;
                }
                case 7: {
                    s3 = 0;
                    s5 = 0;
                    break;
                }
                case 8: {
                    s3 = 0;
                    s8 = 0;
                    break;
                }
                case 9: {
                    s3 = 0;
                    s9 = 0;
                    break;
                }
                case 10: {
                    s4 = 0;
                    s5 = 0;
                    break;
                }
                case 11: {
                    s4 = 0;
                    s8 = 0;
                    break;
                }
                case 12: {
                    s4 = 0;
                    s9 = 0;
                    break;
                }
                case 13: {
                    s5 = 0;
                    s8 = 0;
                    break;
                }
                case 14: {
                    s5 = 0;
                    s9 = 0;
                    break;
                }
                case 15: {
                    s8 = 0;
                    s9 = 0;
                }
            }
        } else if (a3 == 3) {
            s2 = (short)10;
            s3 = (short)10;
            s4 = 10;
            s5 = 10;
            s8 = 10;
            s9 = 10;
        }
        if (!bl) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u9625\u9b2e\u001f");
        }
        object = (String)object + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + n3 + "##k\r\n";
        object = (String)object + "\u9644\u9b54\u70ba:\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        Equip equip3 = equip2;
        equip3.setStr((short)(equip3.getStr() + s2 > 0 ? equip2.getStr() + s2 : 0));
        object = (String)object + "\u529b\u91cf + " + s2 + "\r\n";
        Equip equip4 = equip2;
        equip4.setDex((short)(equip4.getDex() + s3 > 0 ? equip2.getDex() + s3 : 0));
        object = (String)object + "\u654f\u6377:  " + s3 + "\r\n";
        Equip equip5 = equip2;
        equip5.setInt((short)(equip5.getInt() + s4 > 0 ? equip2.getInt() + s4 : 0));
        object = (String)object + "\u667a\u529b:  " + s4 + "\r\n";
        Equip equip6 = equip2;
        equip6.setLuk((short)(equip6.getLuk() + s5 > 0 ? equip2.getLuk() + s5 : 0));
        object = (String)object + "\u5e78\u904b:  " + s5 + "\r\n";
        Equip equip7 = equip2;
        equip7.setHp((short)(equip7.getHp() + s6 > 0 ? equip2.getHp() + s6 : 0));
        object = (String)object + "HP:  " + s6 + "\r\n";
        Equip equip8 = equip2;
        equip8.setMp((short)(equip8.getMp() + s7 > 0 ? equip2.getMp() + s7 : 0));
        object = (String)object + "MP:  " + s7 + "\r\n";
        Equip equip9 = equip2;
        equip9.setWatk((short)(equip9.getWatk() + s8 > 0 ? equip2.getWatk() + s8 : 0));
        object = (String)object + "\u7269\u7406\u653b\u64ca:  " + s8 + "\r\n";
        Equip equip10 = equip2;
        equip10.setMatk((short)(equip10.getMatk() + s9 > 0 ? equip2.getMatk() + s9 : 0));
        object = (String)object + "\u9b54\u6cd5\u653b\u64ca:  " + s9 + "\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        Equip equip11 = equip2;
        n2 = StringTool.getIntFromString(equip11.getOwner());
        equip11.setOwner("\u5df2\u9644\u9b54" + ++n2 + "\u6b21");
        equip = (Equip)equip2.copy();
        MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a4.getClient(), equip, false);
        a4.c.getPlayer().equipChanged();
        return object;
    }

    public final /* synthetic */ String getNpcName() {
        NPCConversationManager a2;
        return MapleLifeFactory.getNPC(a2.E).getName();
    }

    public /* synthetic */ void sendNextPrevS(String a2) {
        NPCConversationManager a3;
        a3.sendNextPrevS(a2, (byte)3);
    }

    public /* synthetic */ int partyMembersInMap() {
        NPCConversationManager a2;
        int n2 = 0;
        Iterator<MapleCharacter> iterator = a2.getPlayer().getMap().getCharactersThreadsafe().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getParty() != a2.getPlayer().getParty()) continue;
            ++n2;
        }
        return n2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ int setAvatar(int a, int a, boolean a) {
        block9: {
            block10: {
                block8: {
                    if (!a.haveItem(a)) {
                        return -1;
                    }
                    a.gainItem(a, (short)-1);
                    if (a >= 100) break block8;
                    if (a) {
                        v0 = a;
                        a.getPlayer().getSecondSkinColor();
                    } else {
                        v1 = a;
                        v1.c.getPlayer().setSkinColor((byte)a);
                        v1.c.getPlayer().updateSingleStat(MapleStat.SKIN, a);
                        v0 = a;
                    }
                    break block9;
                }
                if (a >= 30000) break block10;
                if (!NPCConversationManager.faceExists(a)) ** GOTO lbl36
                v2 = a;
                if (a) {
                    v2.getPlayer().setSecondFace(a);
                    v0 = a;
                } else {
                    v2.c.getPlayer().setFace(a);
                    v0 = a;
                    a.c.getPlayer().updateSingleStat(MapleStat.FACE, a);
                }
                break block9;
            }
            if (!NPCConversationManager.hairExists(a)) ** GOTO lbl36
            v3 = a;
            if (a) {
                v3.getPlayer().setSecondHair(a);
                v0 = a;
            } else {
                v3.c.getPlayer().setHair(a);
                a.c.getPlayer().updateSingleStat(MapleStat.HAIR, a);
lbl36:
                // 3 sources

                v0 = a;
            }
        }
        if (v0) {
            if (MapleJob.is\u5929\u4f7f\u7834\u58de\u8005(a.getJob()) == false) return 1;
            a.getClient().announce(MaplePacketCreator.DressUpInfoModified(a.getPlayer()));
            return 1;
        }
        a.c.getPlayer().equipChanged();
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantCashEqipOld(byte a2, int a32, int a4, int a5) {
        Object object;
        NPCConversationManager a6;
        Equip equip;
        Equip equip2 = equip = (Equip)a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        short s2 = a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        short s3 = MapleItemInformationProvider.getInstance().isCash(s2);
        Object object2 = "";
        if (s3 == 0) return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u9ee1\u888d\u5508q\u50fa\u6759\u9ee1\u888d\u6272\u53bf\u4eda\u9614\u9b6b.");
        if (!a6.c.getPlayer().haveItem(a4, a5)) {
            return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a4 + "# " + a5 + "\u500b!";
        }
        a6.c.getPlayer().gainItem(a4, -a5);
        object2 = (String)object2 + "\u60a8\u6b64\u6b21\u6240\u9644\u9b54\u7684\u9ede\u88dd\u70ba#b#z" + s2 + "##k\r\n";
        object2 = (String)object2 + "\u60a8\u6b64\u6b21\u7684\u9644\u9b54\u70ba:\r\n";
        object2 = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        if (a32 == 1) {
            a32 = (short)Randomizer.rand(-1, 3);
            Equip equip3 = equip2;
            equip3.setStr((short)(equip3.getStr() + a32 > 0 ? equip2.getStr() + a32 : 0));
            object2 = (String)object2 + "\u529b\u91cf:  " + (short)a32 + "\r\n";
            a4 = (short)Randomizer.rand(-1, 3);
            Equip equip4 = equip2;
            equip4.setDex((short)(equip4.getDex() + a4 > 0 ? equip2.getDex() + a4 : 0));
            object2 = (String)object2 + "\u654f\u6377:  " + (short)a4 + "\r\n";
            a5 = (short)Randomizer.rand(-1, 3);
            Equip equip5 = equip2;
            equip5.setInt((short)(equip5.getInt() + a5 > 0 ? equip2.getInt() + a5 : 0));
            object2 = (String)object2 + "\u667a\u529b:  " + (short)a5 + "\r\n";
            s2 = (short)Randomizer.rand(-1, 3);
            Equip equip6 = equip2;
            equip6.setLuk((short)(equip6.getLuk() + s2 > 0 ? equip2.getLuk() + s2 : 0));
            object2 = (String)object2 + "\u5e78\u904b:  " + s2 + "\r\n";
            s3 = (short)Randomizer.rand(-1, 3);
            Equip equip7 = equip2;
            equip7.setWatk((short)(equip7.getWatk() + s3 > 0 ? equip2.getWatk() + s3 : 0));
            object2 = (String)object2 + "\u7269\u7406\u653b\u64ca:  " + s3 + "\r\n";
            short s4 = (short)Randomizer.rand(-1, 3);
            Equip equip8 = equip2;
            equip8.setMatk((short)(equip8.getMatk() + s4 > 0 ? equip2.getMatk() + s4 : 0));
            object2 = (String)object2 + "\u9b54\u6cd5\u653b\u64ca:  " + s4 + "\r\n";
            short s5 = (short)Randomizer.rand(-5, 10);
            Equip equip9 = equip2;
            equip9.setHp((short)(equip9.getHp() + s5 > 0 ? equip2.getHp() + s5 : 0));
            object2 = (String)object2 + "HP:  " + s5 + "\r\n";
            short s6 = (short)Randomizer.rand(-5, 10);
            Equip equip10 = equip2;
            equip10.setMp((short)(equip10.getMp() + s6 > 0 ? equip2.getMp() + s6 : 0));
            object = object2 = (String)object2 + "MP:  " + s6 + "\r\n";
        } else {
            LinkedList<Integer> a32 = new LinkedList<Integer>();
            int n2 = a4 = 0;
            while (n2 < 4) {
                a5 = Randomizer.rand(0, 7);
                while (a32.contains(a5 = Randomizer.rand(0, 7))) {
                }
                int n3 = a5;
                a32.add(n3);
                switch (n3) {
                    case 0: {
                        s2 = (short)Randomizer.rand(-2, 3);
                        Equip equip11 = equip2;
                        equip11.setStr((short)(equip11.getStr() + s2 > 0 ? equip2.getStr() + s2 : 0));
                        object2 = (String)object2 + "\u529b\u91cf:  " + s2 + "\r\n";
                        break;
                    }
                    case 1: {
                        s3 = (short)Randomizer.rand(-2, 3);
                        Equip equip12 = equip2;
                        equip12.setDex((short)(equip12.getDex() + s3 > 0 ? equip2.getDex() + s3 : 0));
                        object2 = (String)object2 + "\u654f\u6377:  " + s3 + "\r\n";
                        break;
                    }
                    case 2: {
                        short s7 = (short)Randomizer.rand(-2, 3);
                        Equip equip13 = equip2;
                        equip13.setInt((short)(equip13.getInt() + s7 > 0 ? equip2.getInt() + s7 : 0));
                        object2 = (String)object2 + "\u667a\u529b:  " + s7 + "\r\n";
                        break;
                    }
                    case 3: {
                        short s8 = (short)Randomizer.rand(-2, 3);
                        Equip equip14 = equip2;
                        equip14.setLuk((short)(equip14.getLuk() + s8 > 0 ? equip2.getLuk() + s8 : 0));
                        object2 = (String)object2 + "\u5e78\u904b:  " + s8 + "\r\n";
                        break;
                    }
                    case 4: {
                        short s9 = (short)Randomizer.rand(-2, 3);
                        Equip equip15 = equip2;
                        equip15.setWatk((short)(equip15.getWatk() + s9 > 0 ? equip2.getWatk() + s9 : 0));
                        object2 = (String)object2 + "\u7269\u7406\u653b\u64ca:  " + s9 + "\r\n";
                        break;
                    }
                    case 5: {
                        short s10 = (short)Randomizer.rand(-2, 3);
                        Equip equip16 = equip2;
                        equip16.setMatk((short)(equip16.getMatk() + s10 > 0 ? equip2.getMatk() + s10 : 0));
                        object2 = (String)object2 + "\u9b54\u6cd5\u653b\u64ca:  " + s10 + "\r\n";
                        break;
                    }
                    case 6: {
                        short s10 = (short)Randomizer.rand(-5, 10);
                        Equip equip17 = equip2;
                        equip17.setHp((short)(equip17.getHp() + s10 > 0 ? equip2.getHp() + s10 : 0));
                        object2 = (String)object2 + "HP:  " + s10 + "\r\n";
                        break;
                    }
                    case 7: {
                        short s10 = (short)Randomizer.rand(-5, 10);
                        Equip equip18 = equip2;
                        equip18.setMp((short)(equip18.getMp() + s10 > 0 ? equip2.getMp() + s10 : 0));
                        object2 = (String)object2 + "MP:  " + s10 + "\r\n";
                        break;
                    }
                }
                n2 = ++a4;
            }
            object = object2;
        }
        object2 = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        Equip equip19 = equip2;
        int a32 = StringTool.getIntFromString(equip19.getOwner());
        equip19.setOwner("\u5df2\u9644\u9b54" + ++a32 + "\u6b21");
        equip = (Equip)equip2.copy();
        MapleInventoryManipulator.removeFromSlot(a6.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a6.getClient(), equip, false);
        a6.c.getPlayer().equipChanged();
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String getEquipStar(int a2) {
        String string = "";
        switch (a2) {
            case 1: {
                return InventoryException.ALLATORIxDEMO("\u2667");
            }
            case 2: {
                return MapleImp.ALLATORIxDEMO("\u2639\u2656");
            }
            case 3: {
                return InventoryException.ALLATORIxDEMO("\u2667\u267c\u2667");
            }
            case 4: {
                return MapleImp.ALLATORIxDEMO("\u2639\u2656\u2639\u2656");
            }
            case 5: {
                return InventoryException.ALLATORIxDEMO("\u2667\u267c\u2667\u267c\u2667");
            }
            case 6: {
                return MapleImp.ALLATORIxDEMO("\u2639\u2656\u2639\u2656\u2639\u2656");
            }
            case 7: {
                return InventoryException.ALLATORIxDEMO("\u2667\u267c\u2667\u267c\u2667\u267c\u2667");
            }
            case 8: {
                return MapleImp.ALLATORIxDEMO("\u2655\u2639\u2656\u2639\u2656\u2639\u2656");
            }
            case 9: {
                return InventoryException.ALLATORIxDEMO("\u2664\u267f\u2667\u267c\u2667\u267c\u2667");
            }
            case 10: {
                return MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u2639\u2656\u2639\u2656");
            }
            case 11: {
                return InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664\u267f\u2667\u267c\u2667");
            }
            case 12: {
                return MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u263a\u2655\u2639\u2656");
            }
            case 13: {
                return InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664\u267f\u2664\u267f\u2667");
            }
            case 14: {
                return MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u263a\u2655\u263a\u2655");
            }
        }
        return string;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantSour(byte a2, int a32, int a4, boolean a5) {
        Equip equip;
        Object object;
        NPCConversationManager a6;
        Equip equip2;
        Equip equip3 = equip2 = (Equip)a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        boolean bl2 = false;
        int n3 = 7;
        switch (n2) {
            case 1112127: 
            case 1112906: {
                bl2 = true;
                n3 = 5;
                break;
            }
        }
        if (bl2 && a4 == 3) {
            return InventoryException.ALLATORIxDEMO("\u6273\u637d\u538b\u5395\u4e84\u4f05\u7549\u9aa2\u7d7b\u5f4d\u5377\u549c@");
        }
        Object object2 = "";
        if (a6.getStarLevel(equip3.getOwner()) >= n3) {
            return MapleImp.ALLATORIxDEMO("\u6b34\u9ee1\u888d\u5dcd\u9004\u520f\u5f67\u5329\u4e5a\u966fq");
        }
        if (!bl) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bc\u554d@\u50bf\u6768\u9ea4\u88bc\u6237\u538e\u4e9f\u5f56\u536c\u001f");
        }
        object2 = (String)object2 + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u9ede\u88dd\u70ba#b#z" + n2 + "##k\r\n";
        object2 = (String)object2 + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
        object2 = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        int n4 = a32;
        if (a5) {
            a32 = (short)Randomizer.rand(n4, a4);
            Equip equip4 = equip3;
            a5 = (short)(equip4.getWatk() + a32);
            equip4.setWatk((short)a5);
            object = object2 = (String)object2 + "\u7269\u7406\u653b\u64ca\u529b:  " + (short)a32 + "\r\n";
        } else {
            a32 = (short)Randomizer.rand(n4, a4);
            Equip equip5 = equip3;
            a5 = (short)(equip5.getMatk() + a32);
            equip5.setMatk((short)a5);
            object = object2 = (String)object2 + "\u9b54\u6cd5\u653b\u64ca\u529b:  " + (short)a32 + "\r\n";
        }
        object2 = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        StringBuilder a32 = new StringBuilder();
        a32.append(equip3.getOwner());
        if (a4 == 3) {
            equip = equip3;
            a32.append(InventoryException.ALLATORIxDEMO("\u2667"));
        } else {
            a32.append(MapleImp.ALLATORIxDEMO("\u2655"));
            equip = equip3;
        }
        equip.setOwner(a32.toString());
        equip2 = (Equip)equip3.copy();
        MapleInventoryManipulator.removeFromSlot(a6.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a6.getClient(), equip2, false);
        a6.c.getPlayer().equipChanged();
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ int getEquipLevel(String a2) {
        int n2;
        int n3;
        block32: {
            n3 = 0;
            int n4 = -1;
            switch (a2.hashCode()) {
                case 9734: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2667"))) break;
                    n2 = n4 = 0;
                    break block32;
                }
                case 311488: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2639\u2656"))) break;
                    n2 = n4 = 1;
                    break block32;
                }
                case 9665862: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2667\u267c\u2667"))) break;
                    n2 = n4 = 2;
                    break block32;
                }
                case 299651456: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2639\u2656\u2639\u2656"))) break;
                    n2 = n4 = 3;
                    break block32;
                }
                case 699270278: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2667\u267c\u2667\u267c\u2667"))) break;
                    n2 = n4 = 4;
                    break block32;
                }
                case 202551872: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2639\u2656\u2639\u2656\u2639\u2656"))) break;
                    n2 = n4 = 5;
                    break block32;
                }
                case 1984150470: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2667\u267c\u2667\u267c\u2667\u267c\u2667"))) break;
                    n2 = n4 = 6;
                    break block32;
                }
                case 1096646789: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2655\u2639\u2656\u2639\u2656\u2639\u2656"))) break;
                    n2 = n4 = 7;
                    break block32;
                }
                case 1068017638: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664\u267f\u2667\u267c\u2667\u267c\u2667"))) break;
                    n2 = n4 = 8;
                    break block32;
                }
                case 1067094117: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u2639\u2656\u2639\u2656"))) break;
                    n2 = n4 = 9;
                    break block32;
                }
                case 1067064326: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664\u267f\u2667\u267c\u2667"))) break;
                    n2 = n4 = 10;
                    break block32;
                }
                case 1067063365: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u263a\u2655\u2639\u2656"))) break;
                    n2 = n4 = 11;
                    break block32;
                }
                case 1067063334: {
                    if (!a2.equals(InventoryException.ALLATORIxDEMO("\u2664\u267f\u2664\u267f\u2664\u267f\u2667"))) break;
                    n2 = n4 = 12;
                    break block32;
                }
                case 1067063333: {
                    if (!a2.equals(MapleImp.ALLATORIxDEMO("\u2655\u263a\u2655\u263a\u2655\u263a\u2655"))) break;
                    n4 = 13;
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
            case 4: {
                return 5;
            }
            case 5: {
                return 6;
            }
            case 6: {
                return 7;
            }
            case 7: {
                return 8;
            }
            case 8: {
                return 9;
            }
            case 9: {
                return 10;
            }
            case 10: {
                return 11;
            }
            case 11: {
                return 12;
            }
            case 12: {
                return 13;
            }
            case 13: {
                return 14;
            }
        }
        return n3;
    }

    public /* synthetic */ void say(int a2, int a3, int a4, int a5, int a6, int a7, String a8, boolean a9, boolean a10, int a11) {
        NPCConversationManager a12;
        if (a8.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a12.askMenu(a2, a3, a4, a5, a6, a7, a8);
            return;
        }
        a12.a = 0;
        String[] arrstring = new String[1];
        arrstring[0] = a8;
        int[] arrn = new int[3];
        arrn[0] = a9 ? 1 : 0;
        arrn[1] = a10 ? 1 : 0;
        arrn[2] = a11;
        a12.c.sendPacket(MaplePacketCreator.OnScriptMessage(a2, a3, a4, a5, a12.a, a6, a7, arrstring, arrn, null, null));
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantCashEquipStar(byte a2, int a32) {
        Equip equip;
        Equip a32;
        NPCConversationManager a4;
        Equip equip2 = a32 = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n2 = MapleItemInformationProvider.getInstance().isCash(n2) ? (byte)1 : 0;
        Object object = "";
        if (n2 == 0) return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u4e5c\u973f\u9ea4\u88bcV\u7140\u6caf\u5326\u7d60\u3063");
        if (!(equip2.getStr() == 0 && equip2.getDex() == 0 && equip2.getInt() == 0 && equip2.getLuk() == 0 && equip2.getHp() == 0 && equip2.getMp() == 0 && equip2.getWatk() == 0 && equip2.getMatk() == 0 && equip2.getWdef() == 0 && equip2.getMdef() == 0 && equip2.getAcc() == 0 && equip2.getSpeed() == 0 && equip2.getJump() == 0 || equip2.getOwner().contains(InventoryException.ALLATORIxDEMO("\u2667")) || equip2.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2655")))) {
            return InventoryException.ALLATORIxDEMO("Y\u0013\u6b1e\u88bc\u50e3\u5d93\u6773\u7218\u6bf0\u809c\u52e1\u001f\u569a\u6b05\u715b\u6cb4\u533d\u7d7b\u549c@");
        }
        n2 = a4.getEquipLevel(equip2.getOwner());
        if (n2 >= 7) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (n2 < 4) {
            if (!a4.c.getPlayer().haveItem(4036501)) {
                return InventoryException.ALLATORIxDEMO("B\b\u5326\u7d60P\u0004R\u6665\u9761\u89fbB\u0013UJRLTJPYAKA\u5071@");
            }
            a4.c.getPlayer().gainItem(4036501, -1);
        } else {
            if (!a4.c.getPlayer().haveItem(4036500)) {
                return MapleImp.ALLATORIxDEMO("sM\u5317\u7d25dAg\u6620\u9750\u89besVd\u000fc\te\u000f`\u001cp\u000ep\u5034q");
            }
            a4.c.getPlayer().gainItem(4036500, -1);
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        switch (n2 + 1) {
            case 1: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 90;
                break;
            }
            case 2: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 80;
                break;
            }
            case 3: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 70;
                break;
            }
            case 4: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n7 = 1;
                n8 = 1;
                n9 = 50;
                break;
            }
            case 5: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n7 = 2;
                n8 = 2;
                n9 = 50;
                break;
            }
            case 6: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n7 = 3;
                n8 = 3;
                n9 = 40;
                break;
            }
            case 7: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n7 = 5;
                n8 = 5;
                n9 = 30;
                break;
            }
            case 8: {
                n3 = 8;
                n4 = 8;
                n5 = 8;
                n6 = 8;
                n7 = 3;
                n8 = 3;
                n9 = 65;
                break;
            }
            case 9: {
                n3 = 9;
                n4 = 9;
                n5 = 9;
                n6 = 9;
                n7 = 4;
                n8 = 4;
                n9 = 60;
                break;
            }
            case 10: {
                n3 = 10;
                n4 = 10;
                n5 = 10;
                n6 = 10;
                n7 = 5;
                n8 = 5;
                n9 = 50;
                break;
            }
            case 11: {
                n3 = 15;
                n4 = 15;
                n5 = 15;
                n6 = 15;
                n7 = 8;
                n8 = 8;
                n9 = 45;
                break;
            }
            case 12: {
                n3 = 20;
                n4 = 20;
                n5 = 20;
                n6 = 20;
                n7 = 10;
                n8 = 10;
                n9 = 40;
                break;
            }
            case 13: {
                n3 = 25;
                n4 = 25;
                n5 = 25;
                n6 = 25;
                n7 = 12;
                n8 = 12;
                n9 = 30;
                break;
            }
            case 14: {
                n3 = 30;
                n4 = 30;
                n5 = 30;
                n6 = 30;
                n7 = 15;
                n8 = 15;
                n9 = 20;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < n9) {
            Equip equip3 = equip2;
            Equip equip4 = equip2;
            Equip equip5 = equip2;
            equip2.setStr((short)n3);
            equip5.setDex((short)n4);
            equip5.setInt((short)n5);
            equip4.setLuk((short)n6);
            equip4.setWatk((short)n7);
            equip3.setMatk((short)n8);
            equip3.setOwner(a4.getEquipStar(n2 + 1));
            a32 = (Equip)equip3.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), a32, false);
            a4.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + n9 + "%)\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a4.getEquipStar(n2 + 1) + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + n3 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + n4 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + n5 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a4.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        if (Randomizer.rand(0, 100) >= 50) {
            return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + n9 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u738750%)";
        }
        n3 = 0;
        n4 = 0;
        n5 = 0;
        n6 = 0;
        n7 = 0;
        n8 = 0;
        n9 = 0;
        switch (n2 - 1) {
            case 1: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 100;
                equip = equip2;
                break;
            }
            case 2: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                equip = equip2;
                break;
            }
            case 3: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 100;
                equip = equip2;
                break;
            }
            case 4: {
                n3 = 4;
                n4 = 4;
                n5 = 4;
                n6 = 4;
                n9 = 100;
                equip = equip2;
                break;
            }
            case 5: {
                n3 = 5;
                n4 = 5;
                n5 = 5;
                n6 = 5;
                n9 = 100;
                equip = equip2;
                break;
            }
            case 6: {
                n3 = 6;
                n4 = 6;
                n5 = 6;
                n6 = 6;
                n7 = 1;
                n8 = 1;
                n9 = 95;
                equip = equip2;
                break;
            }
            case 7: {
                n3 = 7;
                n4 = 7;
                n5 = 7;
                n6 = 7;
                n7 = 2;
                n8 = 2;
                n9 = 90;
                equip = equip2;
                break;
            }
            case 8: {
                n3 = 8;
                n4 = 8;
                n5 = 8;
                n6 = 8;
                n7 = 3;
                n8 = 3;
                n9 = 85;
                equip = equip2;
                break;
            }
            case 9: {
                n3 = 9;
                n4 = 9;
                n5 = 9;
                n6 = 9;
                n7 = 4;
                n8 = 4;
                n9 = 80;
                equip = equip2;
                break;
            }
            case 10: {
                n3 = 10;
                n4 = 10;
                n5 = 10;
                n6 = 10;
                n7 = 5;
                n8 = 5;
                n9 = 70;
                equip = equip2;
                break;
            }
            case 11: {
                n3 = 15;
                n4 = 15;
                n5 = 15;
                n6 = 15;
                n7 = 8;
                n8 = 8;
                n9 = 50;
                equip = equip2;
                break;
            }
            case 12: {
                n3 = 20;
                n4 = 20;
                n5 = 20;
                n6 = 20;
                n7 = 10;
                n8 = 10;
                n9 = 40;
                equip = equip2;
                break;
            }
            case 13: {
                n3 = 25;
                n4 = 25;
                n5 = 25;
                n6 = 25;
                n7 = 12;
                n8 = 12;
                n9 = 30;
                equip = equip2;
                break;
            }
            case 14: {
                n3 = 30;
                n4 = 30;
                n5 = 30;
                n6 = 30;
                n7 = 15;
                n8 = 15;
                n9 = 20;
            }
            default: {
                equip = equip2;
            }
        }
        equip.setStr((short)n3);
        Equip equip6 = equip2;
        Equip equip7 = equip2;
        Equip equip8 = equip2;
        equip8.setDex((short)n4);
        equip8.setInt((short)n5);
        equip7.setLuk((short)n6);
        equip7.setWatk((short)n7);
        equip6.setMatk((short)n8);
        equip6.setOwner(a4.getEquipStar(n2 - 1));
        a32 = (Equip)equip6.copy();
        MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a4.getClient(), a32, false);
        a4.c.getPlayer().equipChanged();
        object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u5931\u6557!!\u88dd\u5099\u964d\u7d1a!!(\u6210\u529f\u6a5f\u7387" + n9 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u738750%)\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a4.getEquipStar(n2 - 1) + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + n3 + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + n4 + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + n5 + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + n6 + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
        object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        object = (String)object + "!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!";
        FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a4.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
        return object;
    }

    public final /* synthetic */ int getDojoRecord() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getDojoRecord();
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String TreeCashEquipStar(byte a2, int a32) {
        Equip a32;
        NPCConversationManager a4;
        Equip equip = a32 = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId() == 1112942 ? 1 : 0;
        Object object = "";
        if (n2 == 0) return InventoryException.ALLATORIxDEMO("B\b\u6b05\u88a7\u50f8\u4e5c\u973f\u6b1b\u6a63\u6268\u6366V\u7140\u6caf\u5326\u7d60\u3063");
        if (!(equip.getStr() == 0 && equip.getDex() == 0 && equip.getInt() == 0 && equip.getLuk() == 0 && equip.getHp() == 0 && equip.getMp() == 0 && equip.getWatk() == 0 && equip.getMatk() == 0 && equip.getWdef() == 0 && equip.getMdef() == 0 && equip.getAcc() == 0 && equip.getSpeed() == 0 && equip.getJump() == 0 || equip.getOwner().contains(InventoryException.ALLATORIxDEMO("\u2667")) || equip.getOwner().contains(MapleImp.ALLATORIxDEMO("\u2655")))) {
            return InventoryException.ALLATORIxDEMO("Y\u0013\u6b1e\u88bc\u50e3\u5d93\u6773\u7218\u6bf0\u809c\u52e1\u001f\u569a\u6b05\u715b\u6cb4\u533d\u7d7b\u549c@");
        }
        n2 = a4.getEquipLevel(equip.getOwner());
        if (n2 >= 14) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (n2 < 3) {
            if (!a4.c.getPlayer().haveItem(4001470)) {
                return InventoryException.ALLATORIxDEMO("B\b\u5326\u7d60P\u0004R\u6665\u9761\u89fbB\u0013UJQKUMQYAKA\u5071@");
            }
            a4.c.getPlayer().gainItem(4001470, -1);
        } else if (n2 < 6) {
            if (!a4.c.getPlayer().haveItem(4001471)) {
                return MapleImp.ALLATORIxDEMO("sM\u5317\u7d25dAf\u6620\u9750\u89besVd\u000f`\u000ed\ba\u001cp\u000ep\u5034q");
            }
            a4.c.getPlayer().gainItem(4001471, -1);
        } else if (n2 < 9) {
            if (!a4.c.getPlayer().haveItem(4001473)) {
                return InventoryException.ALLATORIxDEMO("Y\u0013\u533d\u7d7bM\u001fC\u667e\u977a\u89e0YUJQKUMRYAKA\u5071@");
            }
            a4.c.getPlayer().gainItem(4001473, -1);
        } else {
            if (!a4.c.getPlayer().haveItem(4001472)) {
                return MapleImp.ALLATORIxDEMO("\u001c\"\u5378\u7d4a\u000e`Aa\u000b\u664f\u973f\u89d1\u001cd\u000f`\u000ed\bb\u001cp\u000ep\u5034q");
            }
            a4.c.getPlayer().gainItem(4001472, -1);
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        switch (n2 + 1) {
            case 1: {
                n3 = 5;
                n4 = 5;
                n5 = 5;
                n6 = 5;
                n9 = 90;
                break;
            }
            case 2: {
                n3 = 6;
                n4 = 6;
                n5 = 6;
                n6 = 6;
                n9 = 90;
                break;
            }
            case 3: {
                n3 = 7;
                n4 = 7;
                n5 = 7;
                n6 = 7;
                n9 = 90;
                break;
            }
            case 4: {
                n3 = 8;
                n4 = 8;
                n5 = 8;
                n6 = 8;
                n7 = 1;
                n8 = 1;
                n9 = 80;
                break;
            }
            case 5: {
                n3 = 9;
                n4 = 9;
                n5 = 9;
                n6 = 9;
                n7 = 2;
                n8 = 2;
                n9 = 75;
                break;
            }
            case 6: {
                n3 = 10;
                n4 = 10;
                n5 = 10;
                n6 = 10;
                n7 = 3;
                n8 = 3;
                n9 = 70;
                break;
            }
            case 7: {
                n3 = 15;
                n4 = 15;
                n5 = 15;
                n6 = 15;
                n7 = 5;
                n8 = 5;
                n9 = 50;
                break;
            }
            case 8: {
                n3 = 16;
                n4 = 16;
                n5 = 16;
                n6 = 16;
                n7 = 6;
                n8 = 6;
                n9 = 45;
                break;
            }
            case 9: {
                n3 = 17;
                n4 = 17;
                n5 = 17;
                n6 = 17;
                n7 = 7;
                n8 = 7;
                n9 = 40;
                break;
            }
            case 10: {
                n3 = 20;
                n4 = 20;
                n5 = 20;
                n6 = 20;
                n7 = 10;
                n8 = 10;
                n9 = 30;
                break;
            }
            case 11: {
                n3 = 25;
                n4 = 25;
                n5 = 25;
                n6 = 25;
                n7 = 15;
                n8 = 15;
                n9 = 25;
                break;
            }
            case 12: {
                n3 = 30;
                n4 = 30;
                n5 = 30;
                n6 = 30;
                n7 = 20;
                n8 = 20;
                n9 = 20;
                break;
            }
            case 13: {
                n3 = 40;
                n4 = 40;
                n5 = 40;
                n6 = 40;
                n7 = 30;
                n8 = 30;
                n9 = 10;
                break;
            }
            case 14: {
                n3 = 50;
                n4 = 50;
                n5 = 50;
                n6 = 50;
                n7 = 40;
                n8 = 40;
                n9 = 10;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < n9) {
            Equip equip2 = equip;
            Equip equip3 = equip;
            Equip equip4 = equip;
            equip.setStr((short)n3);
            equip4.setDex((short)n4);
            equip4.setInt((short)n5);
            equip3.setLuk((short)n6);
            equip3.setWatk((short)n7);
            equip2.setMatk((short)n8);
            equip2.setOwner(a4.getEquipStar(n2 + 1));
            a32 = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), a32, false);
            a4.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!(\u6210\u529f\u6a5f\u7387" + n9 + "%)\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a4.getEquipStar(n2 + 1) + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + n3 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + n4 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + n5 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a4.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        n3 = 0;
        n4 = 0;
        n5 = 0;
        n6 = 0;
        n7 = 0;
        n8 = 0;
        int n10 = 100;
        switch (n2 - 1) {
            case 1: {
                n3 = 5;
                n4 = 5;
                n5 = 5;
                n6 = 5;
                n10 = 100;
                break;
            }
            case 2: {
                n3 = 6;
                n4 = 6;
                n5 = 6;
                n6 = 6;
                n10 = 100;
                break;
            }
            case 3: {
                n3 = 7;
                n4 = 7;
                n5 = 7;
                n6 = 7;
                n10 = 100;
                break;
            }
            case 4: {
                n3 = 8;
                n4 = 8;
                n5 = 8;
                n6 = 8;
                n7 = 1;
                n8 = 1;
                n10 = 10;
                break;
            }
            case 5: {
                n3 = 9;
                n4 = 9;
                n5 = 9;
                n6 = 9;
                n7 = 2;
                n8 = 2;
                n10 = 20;
                break;
            }
            case 6: {
                n3 = 10;
                n4 = 10;
                n5 = 10;
                n6 = 10;
                n7 = 3;
                n8 = 3;
                n10 = 40;
                break;
            }
            case 7: {
                n3 = 15;
                n4 = 15;
                n5 = 15;
                n6 = 15;
                n7 = 5;
                n8 = 5;
                n10 = 40;
                break;
            }
            case 8: {
                n3 = 16;
                n4 = 16;
                n5 = 16;
                n6 = 16;
                n7 = 6;
                n8 = 6;
                n10 = 40;
                break;
            }
            case 9: {
                n3 = 17;
                n4 = 17;
                n5 = 17;
                n6 = 17;
                n7 = 7;
                n8 = 7;
                n10 = 50;
                break;
            }
            case 10: {
                n3 = 20;
                n4 = 20;
                n5 = 20;
                n6 = 20;
                n7 = 10;
                n8 = 10;
                n10 = 60;
                break;
            }
            case 11: {
                n3 = 25;
                n4 = 25;
                n5 = 25;
                n6 = 25;
                n7 = 15;
                n8 = 15;
                n10 = 70;
                break;
            }
            case 12: {
                n3 = 30;
                n4 = 30;
                n5 = 30;
                n6 = 30;
                n7 = 20;
                n8 = 20;
                n10 = 90;
                break;
            }
            case 13: {
                n3 = 40;
                n4 = 40;
                n5 = 40;
                n6 = 40;
                n7 = 30;
                n8 = 30;
                n10 = 100;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < n10) {
            Equip equip5 = equip;
            Equip equip6 = equip;
            Equip equip7 = equip;
            equip.setStr((short)n3);
            equip7.setDex((short)n4);
            equip7.setInt((short)n5);
            equip6.setLuk((short)n6);
            equip6.setWatk((short)n7);
            equip5.setMatk((short)n8);
            equip5.setOwner(a4.getEquipStar(n2 - 1));
            a32 = (Equip)equip5.copy();
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), a32, false);
            a4.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u5931\u6557!!\u88dd\u5099\u964d\u7d1a!!(\u6210\u529f\u6a5f\u7387" + n9 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u738750%)\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a4.getEquipStar(n2 - 1) + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u529b\u91cf:#r" + n3 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u654f\u6377:#r" + n4 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u667a\u529b:#r" + n5 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u5e78\u904b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u76ee\u524d\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a4.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387)" + n9 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u7387" + n10 + "%)";
    }

    public static /* synthetic */ boolean hairExists(int a2) {
        return MapleItemInformationProvider.getInstance().itemExists(a2);
    }

    public /* synthetic */ void setNPCSpecialAction(int a2, String a3, int a4, boolean a5, int a6) {
        NPCConversationManager a7;
        if (!npcRequestController.containsKey(new Pair<Integer, MapleClient>(a2, a7.c))) {
            return;
        }
        MapleNPC mapleNPC = npcRequestController.get(new Pair<Integer, MapleClient>(a2, a7.c));
        a7.c.sendPacket(MaplePacketCreator.setNPCSpecialAction(mapleNPC.getObjectId(), a3, a4, a5));
        if (a6 > -1) {
            a7.exceTime(a6 > 0 ? a6 : a4);
        }
    }

    public /* synthetic */ void setVip(int a2) {
        NPCConversationManager a3;
        a3.getClient().setVip(a2);
    }

    public /* synthetic */ String getCoupon() {
        return CouponCreate.RandomItem();
    }

    public /* synthetic */ void changeWorldMusic(String a2) {
        World.Broadcast.broadcastMessage(MaplePacketCreator.musicChange(a2));
    }

    public /* synthetic */ void say(String a2, boolean a3, boolean a4) {
        NPCConversationManager a5;
        a5.say(0, a2, a3, a4);
    }

    public /* synthetic */ String getText() {
        NPCConversationManager a2;
        return a2.k;
    }

    public /* synthetic */ void addSunshines(int a2) {
        NPCConversationManager a3;
        AramiaFireWorks.getInstance().giveSuns(a3.c.getPlayer(), a2);
    }

    public final /* synthetic */ List<Integer> getAllPotentialInfo() {
        return new ArrayList<Integer>(MapleItemInformationProvider.getInstance().getAllPotentialInfo().keySet());
    }

    public /* synthetic */ String getBlackJackRules() {
        return BlackJack.getInstance().getRules();
    }

    public /* synthetic */ void askMenu(int a2, String a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        nPCConversationManager.askMenu(nPCConversationManager.E, a2, a3);
    }

    public final /* synthetic */ void resetStats(int a2, int a3, int a4, int a5) {
        NPCConversationManager a6;
        a6.c.getPlayer().resetStats(a2, a3, a4, a5);
    }

    public /* synthetic */ boolean check2ndPassword(MapleCharacter a2, String a3) {
        NPCConversationManager a4;
        return a4.c.check2ndPassword(a3);
    }

    public /* synthetic */ void sendOthersTalk(String a2, int a3, boolean[] a4) {
        NPCConversationManager a5;
        a5.sendOthersTalk(a2, a3, a4, (byte)1);
    }

    public /* synthetic */ int gainGachaponItem(int a2, int a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        return nPCConversationManager.gainGachaponItem(a2, a3, nPCConversationManager.c.getPlayer().getMap().getStreetName() + " - " + a4.c.getPlayer().getMap().getMapName());
    }

    public /* synthetic */ int getNpc() {
        NPCConversationManager a2;
        return a2.E;
    }

    public /* synthetic */ long getNiuNiuNowBet() {
        return NiuNiu.getInstance().getNowBet();
    }

    public final /* synthetic */ void hidePlayer(boolean a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2 ? 1 : 0;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_VansheeMode.getValue(), null, arrn);
    }

    public /* synthetic */ void sendRightPlayerNoESC(String a2, int a3) {
        NPCConversationManager a4;
        a4.sendNextS(a2, (byte)7, a3);
    }

    public /* synthetic */ void say(String a2) {
        NPCConversationManager a3;
        a3.say(a2, false, false);
    }

    public /* synthetic */ void environmentChange(boolean a2, String a3) {
        NPCConversationManager a4;
        if (a2) {
            a4.c.getPlayer().getMap().broadcastMessage(MaplePacketCreator.environmentChange(a3, 2));
            return;
        }
        a4.c.sendPacket(MaplePacketCreator.environmentChange(a3, 2));
    }

    public /* synthetic */ void sendStyle(String a2, int[] a3) {
        NPCConversationManager nPCConversationManager;
        int n2;
        NPCConversationManager a4;
        if (a4.a > -1) {
            return;
        }
        a4.c.getPlayer().clearNpcSelect();
        int n3 = 0;
        int[] arrn = a3;
        int n4 = a3.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            int n6 = arrn[n2];
            a4.c.getPlayer().addNpcSelect(n3);
            n5 = ++n2;
            ++n3;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            NPCConversationManager nPCConversationManager2 = a4;
            nPCConversationManager = nPCConversationManager2;
            a4.c.sendPacket(MaplePacketCreator.getNPCTalkStyle(nPCConversationManager2.E, a2, false, a4.getCanHair(a3)));
        } else {
            NPCConversationManager nPCConversationManager3 = a4;
            nPCConversationManager = nPCConversationManager3;
            nPCConversationManager3.c.sendPacket(MaplePacketCreator.getNPCTalkStyle(nPCConversationManager3.E, a2, a4.getCanHair(a3)));
        }
        nPCConversationManager.a = MaplePacketOperation.NPCStatus.sendStyle;
    }

    @Override
    public /* synthetic */ int getPartyBossLogReload(String a2) {
        NPCConversationManager a3;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (a3.getParty() != null) {
            for (MaplePartyCharacter maplePartyCharacter : a3.getParty().getMembers()) {
                if (a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId()) == null) continue;
                MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(maplePartyCharacter.getId());
                arrayList.add(mapleCharacter.getBossLogReload(a2));
            }
        } else {
            return a3.c.getPlayer().getBossLogReload(a2);
        }
        int n2 = (Integer)Collections.max(arrayList);
        return n2;
    }

    public /* synthetic */ String EnchantInt(byte a2) {
        NPCConversationManager a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        short s2 = n2 == 1112657 ? (short)1 : 0;
        Object object = "";
        int n3 = 400;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("Y\u0015KPKSLTMB\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (s2 != 0) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            n2 = (short)Randomizer.rand(5, 20);
            Equip equip3 = equip2;
            s2 = (short)(equip3.getInt() + n2);
            equip3.setInt(s2 > n3 ? (short)n3 : s2);
            object = (String)object + "\u667a\u529b:  " + (short)n2 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316\u667a\u529b[" + (n4 += n2) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u001c$\u000ea\u000eb\te\bs\u5508q\u50fa\u6759\u001c$\u000ea\u000eb\te\bs\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ Equip getEquip(int a2) {
        return (Equip)MapleItemInformationProvider.getInstance().getEquipById(a2);
    }

    public /* synthetic */ void acceptMember(String a2, int a3) {
        NPCConversationManager a4;
        a2 = a4.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 != null) {
            ((MapleSquad)a2).acceptMember(a3);
        }
    }

    public /* synthetic */ void EnchantCashEqip(byte a2, MapleCharacter a3, int a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, int a13) {
        NPCConversationManager a14;
        Equip equip = (Equip)((MapleCharacter)a3).getInventory(MapleInventoryType.EQUIP).getItem(a2);
        a3 = (Equip)((MapleCharacter)a3).getInventory(MapleInventoryType.EQUIP).getItem(a2).copy();
        int n2 = StringTool.getIntFromString(equip.getOwner()) > 0 ? StringTool.getIntFromString(equip.getOwner()) : 0;
        Serializable serializable = a3;
        Equip equip2 = equip;
        Serializable serializable2 = a3;
        Equip equip3 = equip;
        Serializable serializable3 = a3;
        Equip equip4 = equip;
        Serializable serializable4 = a3;
        ((Equip)serializable4).setStr((short)(equip.getStr() + a4));
        ((Equip)serializable4).setDex((short)(equip.getDex() + a5));
        ((Equip)a3).setInt((short)(equip4.getInt() + a6));
        ((Equip)serializable3).setLuk((short)(equip4.getLuk() + a7));
        ((Equip)serializable3).setHp((short)(equip.getHp() + a10));
        ((Equip)a3).setMp((short)(equip3.getMp() + a11));
        ((Equip)serializable2).setWatk((short)(equip3.getWatk() + a8));
        ((Equip)serializable2).setMatk((short)(equip.getMatk() + a9));
        ((Equip)a3).setAvoid((short)(equip2.getAvoid() + a12));
        ((Equip)serializable).setAcc((short)(equip2.getAcc() + a13));
        ((Item)serializable).setOwner("\u5f37\u5316 " + ++n2 + " \u6b21");
        MapleInventoryManipulator.removeFromSlot(a14.getClient(), MapleInventoryType.EQUIP, a2, ((Item)a3).getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a14.getClient(), (IItem)((Object)a3), false);
    }

    public /* synthetic */ int getQuest() {
        NPCConversationManager a2;
        return a2.g;
    }

    public /* synthetic */ boolean getSR(Pair<String, Map<Integer, String>> a2, int a3) {
        NPCConversationManager a4;
        if (a2.getRight().get(a3) == null || a2.getRight().get(a3).length() <= 0) {
            a4.dispose();
            return false;
        }
        a4.sendOk(a2.getRight().get(a3));
        return true;
    }

    public /* synthetic */ void playerMoveDown() {
        NPCConversationManager a2;
        int[] arrn = new int[1];
        arrn[0] = 4;
        a2.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedInput.getValue(), null, arrn);
    }

    public /* synthetic */ String getNumberIcon2(int a2, int a3) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList = BitTools.intToArray(a2);
        int n2 = a2 = 0;
        while (n2 < arrayList.size()) {
            int n3 = (Integer)arrayList.get(a2);
            stringBuilder.append("#fUI/Basic/unknownMs/num" + a3 + "/" + n3 + "#");
            n2 = ++a2;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ void sendNext(String a2) {
        NPCConversationManager a3;
        if (a3.a > -1) {
            return;
        }
        if (a2.contains(InventoryException.ALLATORIxDEMO("Y-"))) {
            a3.sendSimple(a2);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.getNPCTalk(nPCConversationManager.E, (byte)0, a2, MapleImp.ALLATORIxDEMO("`\u000fp\u000fa"), (byte)0));
        a3.a = 0;
    }

    public /* synthetic */ boolean bonus_PyramidSubway(int a2) {
        NPCConversationManager a3;
        if (a2 >= 0) {
            NPCConversationManager nPCConversationManager = a3;
            nPCConversationManager.c.getPlayer().setCheckedPyramid(true);
            return Event_PyramidSubway.warpBonusPyramid(nPCConversationManager.c.getPlayer(), a2);
        }
        return Event_PyramidSubway.warpBonusSubway(a3.c.getPlayer());
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void changeStatEquip(byte a22, int a3, int a4) {
        NPCConversationManager nPCConversationManager;
        NPCConversationManager a5;
        Equip a22 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a22);
        switch (a3) {
            case 0: {
                a22.setStr((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 1: {
                a22.setDex((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 2: {
                a22.setInt((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 3: {
                a22.setLuk((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 4: {
                a22.setHp((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 5: {
                a22.setMp((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 6: {
                a22.setWatk((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 7: {
                a22.setMatk((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 8: {
                a22.setWdef((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 9: {
                a22.setMdef((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 10: {
                a22.setAcc((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 11: {
                a22.setAvoid((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 12: {
                a22.setHands((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 13: {
                a22.setSpeed((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 14: {
                a22.setJump((short)a4);
                nPCConversationManager = a5;
                break;
            }
            case 15: {
                a22.setUpgradeSlots((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 16: {
                a22.setViciousHammer((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 17: {
                a22.setLevel((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 18: {
                a22.setEnhance((byte)a4);
                nPCConversationManager = a5;
                break;
            }
            case 19: {
                a22.setPotential1(a4);
                nPCConversationManager = a5;
                break;
            }
            case 20: {
                a22.setPotential2(a4);
                nPCConversationManager = a5;
                break;
            }
            case 21: {
                a22.setPotential3(a4);
                nPCConversationManager = a5;
                break;
            }
            case 22: {
                a22.setOwner(a5.getText());
                nPCConversationManager = a5;
                break;
            }
            default: {
                nPCConversationManager = a5;
            }
        }
        nPCConversationManager.c.getPlayer().equipChanged();
    }

    public final /* synthetic */ MapleCarnivalChallenge getCarnivalChallenge(MapleCharacter a2) {
        return new MapleCarnivalChallenge(a2);
    }

    public /* synthetic */ void gainBeans(int a2) {
        NPCConversationManager a3;
        a3.getPlayer().gainBeans(a2);
    }

    public /* synthetic */ String CashEqipUse(byte a2, boolean a3) {
        NPCConversationManager a4;
        Equip equip = (Equip)a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a4.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        if (a3) {
            MapleInventoryManipulator.removeFromSlot(a4.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a4.getClient(), a4.ALLATORIxDEMO, false);
            a4.c.getPlayer().equipChanged();
            a4.ALLATORIxDEMO = null;
            return MapleImp.ALLATORIxDEMO("\u9614\u9b6b\u6240\u52a0q");
        }
        a4.ALLATORIxDEMO = null;
        return InventoryException.ALLATORIxDEMO("\u5d88\u53b7\u6df2\u9625\u9b2e@");
    }

    public /* synthetic */ String ShowItemRank(int a2) {
        StringBuilder stringBuilder = new StringBuilder();
        List<MapleRanking.ItemRankingInfo> list = MapleRanking.getInstance().getItemRank(a2);
        if (list != null) {
            int n2 = 0;
            Object object = list = list.iterator();
            while (object.hasNext()) {
                MapleRanking.ItemRankingInfo itemRankingInfo = (MapleRanking.ItemRankingInfo)list.next();
                stringBuilder.append("#n#e#k\u7269\u54c1#d" + MapleItemInformationProvider.getInstance().getName(a2) + "#k\u6392\u540d:#r ");
                stringBuilder.append(++n2);
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wkY\u000fY\u0004Y\n\u73d3\u5bd7\u5477\u7a50@B\u001eA"));
                stringBuilder.append(StringUtil.getRightPaddedStr(itemRankingInfo.getName(), ' ', 13));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z\u001c>\u001c5\u001c;\u7b76\u7d4a\u0005sZsMp"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(itemRankingInfo.getLevel()), ' ', 3));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wkY\u000fY\u0004Y\n\u800d\u690c@B\u001fB\u0018A"));
                stringBuilder.append(MapleJob.getName(MapleJob.getById(itemRankingInfo.getJob())));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("2Z\u001c>\u001c5\u001c;\u7256\u5491\u6547\u919f\u0005sZs[p"));
                stringBuilder.append(StringUtil.getRightPaddedStr(String.valueOf(itemRankingInfo.getQuantity()), ' ', 4));
                stringBuilder.append(InventoryException.ALLATORIxDEMO("wk"));
                stringBuilder.append(MapleImp.ALLATORIxDEMO("\u001c>\u001c;\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m\u0002m2Z"));
                object = list;
            }
        } else {
            stringBuilder.append(InventoryException.ALLATORIxDEMO("Y\u0013\u679f\u8a03\u715b\u4e9a\u4f2f\u7d31\u67e6\u5556"));
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ String getShowdownLog() {
        return Baccarat.getInstance().getShowdownLog();
    }

    public /* synthetic */ void forcedInput(int a2) {
        NPCConversationManager a3;
        int[] arrn = new int[1];
        arrn[0] = a2;
        a3.getDirectionEffect(GameDirectionType.InGameDirectionEvent_ForcedInput.getValue(), null, arrn);
    }

    public final /* synthetic */ void sendFontStyle() {
        NPCConversationManager a2;
        AttackFont.sendFontStyle(a2.c.getPlayer());
    }

    public /* synthetic */ Pair<String, Map<Integer, String>> getSpeedRun(String a2) {
        a2 = SpeedRunType.valueOf(a2);
        if (SpeedRunner.getInstance().getSpeedRunData((SpeedRunType)((Object)a2)) != null) {
            return SpeedRunner.getInstance().getSpeedRunData((SpeedRunType)((Object)a2));
        }
        return new Pair<String, Map<Integer, String>>("", new HashMap());
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String EnchantCashBai(byte a2, int a3, int a4, int a5) {
        short s2;
        short s3;
        short s4;
        short s5;
        Object object;
        boolean bl;
        int n2;
        Equip equip;
        NPCConversationManager a6;
        Equip equip2;
        block38: {
            int n3;
            int n4;
            LinkedList<Integer> linkedList;
            block39: {
                int n5;
                int n6;
                block37: {
                    int n7;
                    int n8;
                    block35: {
                        block36: {
                            block34: {
                                equip = equip2 = (Equip)a6.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
                                NPCConversationManager nPCConversationManager = a6;
                                n2 = nPCConversationManager.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
                                bl = MapleItemInformationProvider.getInstance().isCash(n2);
                                object = "";
                                if (!nPCConversationManager.c.getPlayer().haveItem(a4, a5)) {
                                    return "\u60a8\u7f3a\u5c11\u7269\u54c1#i" + a4 + "# " + a5 + "\u500b!";
                                }
                                if (!GameSetConstants.SERVER_NAME.equals(InventoryException.ALLATORIxDEMO("\u8357\u834c\u8c56")) && equip.getOwner().equals(MapleImp.ALLATORIxDEMO("\u5da2\u967b\u9b04\n\u6b71"))) {
                                    return InventoryException.ALLATORIxDEMO("\u5d93\u902e\u6761\u595d\u6b40\u6502@");
                                }
                                a6.c.getPlayer().gainItem(a4, -a5);
                                a4 = 0;
                                a5 = 0;
                                s5 = 0;
                                s4 = 0;
                                s3 = 0;
                                s2 = 0;
                                if (a3 != 1) break block34;
                                linkedList = new LinkedList<Integer>();
                                n7 = n8 = 0;
                                break block35;
                            }
                            if (a3 != 2) break block36;
                            linkedList = new LinkedList();
                            n5 = n6 = 0;
                            break block37;
                        }
                        if (a3 != 3) break block38;
                        linkedList = new LinkedList();
                        n3 = n4 = 0;
                        break block39;
                    }
                    while (n7 < 4) {
                        int n9 = Randomizer.rand(0, 5);
                        while (linkedList.contains(n9 = Randomizer.rand(0, 5))) {
                        }
                        int n10 = n9;
                        linkedList.add(n10);
                        switch (n10) {
                            case 0: {
                                a4 = (short)Randomizer.rand(-2, 2);
                                break;
                            }
                            case 1: {
                                a5 = (short)Randomizer.rand(-2, 2);
                                break;
                            }
                            case 2: {
                                s5 = (short)Randomizer.rand(-2, 2);
                                break;
                            }
                            case 3: {
                                s4 = (short)Randomizer.rand(-2, 2);
                                break;
                            }
                            case 4: {
                                s3 = (short)Randomizer.rand(-2, 2);
                                break;
                            }
                            case 5: {
                                s2 = (short)Randomizer.rand(-2, 2);
                                break;
                            }
                        }
                        n7 = ++n8;
                    }
                    break block38;
                }
                while (n5 < 4) {
                    int n11 = Randomizer.rand(0, 5);
                    while (linkedList.contains(n11 = Randomizer.rand(0, 5))) {
                    }
                    int n12 = n11;
                    linkedList.add(n12);
                    switch (n12) {
                        case 0: {
                            a4 = (short)Randomizer.rand(1, 3);
                            break;
                        }
                        case 1: {
                            a5 = (short)Randomizer.rand(1, 3);
                            break;
                        }
                        case 2: {
                            s5 = (short)Randomizer.rand(1, 3);
                            break;
                        }
                        case 3: {
                            s4 = (short)Randomizer.rand(1, 3);
                            break;
                        }
                        case 4: {
                            s3 = (short)Randomizer.rand(1, 3);
                            break;
                        }
                        case 5: {
                            s2 = (short)Randomizer.rand(1, 3);
                            break;
                        }
                    }
                    n5 = ++n6;
                }
                break block38;
            }
            while (n3 < 4) {
                int n13 = Randomizer.rand(0, 5);
                while (linkedList.contains(n13 = Randomizer.rand(0, 5))) {
                }
                int n14 = n13;
                linkedList.add(n14);
                switch (n14) {
                    case 0: {
                        a4 = (short)Randomizer.rand(4, 6);
                        break;
                    }
                    case 1: {
                        a5 = (short)Randomizer.rand(4, 6);
                        break;
                    }
                    case 2: {
                        s5 = (short)Randomizer.rand(4, 6);
                        break;
                    }
                    case 3: {
                        s4 = (short)Randomizer.rand(4, 6);
                        break;
                    }
                    case 4: {
                        s3 = (short)Randomizer.rand(4, 6);
                        break;
                    }
                    case 5: {
                        s2 = (short)Randomizer.rand(4, 6);
                        break;
                    }
                }
                n3 = ++n4;
            }
        }
        if (!bl) {
            return InventoryException.ALLATORIxDEMO("\u6b1e\u88bc\u50e3\u4e47\u9724\u9ebf\u88a7M\u715b\u6cb4\u963e\u9b35\u549c@");
        }
        object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + n2 + "##k\r\n";
        object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        Equip equip3 = equip;
        equip3.setStr((short)(equip3.getStr() + a4 > 0 ? equip.getStr() + a4 : 0));
        object = (String)object + "\u529b\u91cf + " + (short)a4 + "\r\n";
        Equip equip4 = equip;
        equip4.setDex((short)(equip4.getDex() + a5 > 0 ? equip.getDex() + a5 : 0));
        object = (String)object + "\u654f\u6377 + " + (short)a5 + "\r\n";
        Equip equip5 = equip;
        equip5.setInt((short)(equip5.getInt() + s5 > 0 ? equip.getInt() + s5 : 0));
        object = (String)object + "\u667a\u529b + " + s5 + "\r\n";
        Equip equip6 = equip;
        equip6.setLuk((short)(equip6.getLuk() + s4 > 0 ? equip.getLuk() + s4 : 0));
        object = (String)object + "\u5e78\u904b + " + s4 + "\r\n";
        Equip equip7 = equip;
        equip7.setWatk((short)(equip7.getWatk() + s3 > 0 ? equip.getWatk() + s3 : 0));
        object = (String)object + "\u7269\u7406\u653b\u64ca + " + s3 + "\r\n";
        Equip equip8 = equip;
        equip8.setMatk((short)(equip8.getMatk() + s2 > 0 ? equip.getMatk() + s2 : 0));
        object = (String)object + "\u9b54\u6cd5\u653b\u64ca + " + s2 + "\r\n";
        object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
        int n15 = StringTool.getIntFromString(equip.getOwner());
        ++n15;
        if (!GameSetConstants.SERVER_NAME.equals(MapleImp.ALLATORIxDEMO("\u8366\u8309\u8c67"))) {
            equip.setOwner("\u5df2\u9644\u9b54" + n15 + "\u6b21");
        }
        equip2 = (Equip)equip.copy();
        MapleInventoryManipulator.removeFromSlot(a6.getClient(), MapleInventoryType.EQUIP, a2, equip2.getQuantity(), false);
        MapleInventoryManipulator.addFromDrop(a6.getClient(), equip2, false);
        a6.c.getPlayer().equipChanged();
        return object;
    }

    public /* synthetic */ boolean start_PyramidSubway(int a2) {
        NPCConversationManager a3;
        if (a2 >= 0) {
            return Event_PyramidSubway.warpStartPyramid(a3.c.getPlayer(), a2);
        }
        return Event_PyramidSubway.warpStartSubway(a3.c.getPlayer());
    }

    public /* synthetic */ void askMenu(String a2) {
        NPCConversationManager a3;
        a3.askMenu(0, a2);
    }

    public /* synthetic */ void setAndroidFace(int a2) {
        NPCConversationManager a3;
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.getPlayer().getAndroid().setFace(a2);
        nPCConversationManager.getPlayer().getAndroid().saveToDb();
        nPCConversationManager.c.getPlayer().setAndroid(a3.c.getPlayer().getAndroid());
    }

    public /* synthetic */ void getAdviceTalk(String[] a2) {
        NPCConversationManager a3;
        a3.a = 1;
        a3.c.sendPacket(MaplePacketCreator.getAdviceTalk(a2));
    }

    public /* synthetic */ String EnchantShoes(byte a2, int a3, int a4) {
        NPCConversationManager a5;
        Equip equip;
        Equip equip2 = equip = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean bl = MapleItemInformationProvider.getInstance().isCash(n2);
        boolean bl2 = ItemConstants.\u985e\u578b.\u978b\u5b50((int)n2) && !bl;
        Object object = "";
        int n3 = 3500;
        int n4 = StringTool.getIntFromString(equip2.getOwner());
        if (n4 >= n3) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u97f1\u5b31\u9b2e\u52fa\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (bl2) {
            object = (String)object + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u624b\u5957\u70ba#b#z" + n2 + "##k\r\n";
            object = (String)object + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            a3 = (short)Randomizer.rand(a3, a4);
            Equip equip3 = equip2;
            short s2 = (short)(equip3.getMp() + a3);
            a4 = s2;
            equip3.setMp((short)(s2 > n3 ? (int)n3 : a4));
            object = (String)object + "\u9b54\u529b:  " + (short)a3 + "\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316MP[" + (n4 += a3) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), equip, false);
            a5.c.getPlayer().equipChanged();
            return object;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u97b4\u5b00\u5508q\u50fa\u6759\u97b4\u5b00\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ String EnchantHpSugar(byte a2) {
        NPCConversationManager a3;
        Equip equip;
        Equip equip2 = equip = (Equip)a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int s2 = a3.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        boolean object = MapleItemInformationProvider.getInstance().isCash(s2);
        short s3 = (ItemConstants.\u985e\u578b.\u62ab\u98a8((int)s2) || ItemConstants.\u985e\u578b.\u624b\u5957((int)s2) || ItemConstants.\u985e\u578b.\u978b\u5b50((int)s2)) && !object ? (short)1 : 0;
        Object object2 = "";
        int n2 = 3500;
        int n3 = StringTool.getIntFromString(equip2.getOwner());
        if (n3 >= n2) {
            return InventoryException.ALLATORIxDEMO("\u6b05\u88a7\u50f8\u883a\u91ae\u5d88\u9035\u524a\u5f56\u536c\u4e6b\u962a@");
        }
        if (s3 != 0) {
            object2 = (String)object2 + "\u60a8\u6b64\u6b21\u6240\u5f37\u5316\u7684\u88dd\u5099\u70ba#b#z" + s2 + "##k\r\n";
            object2 = (String)object2 + "\u60a8\u6b64\u6b21\u7684\u5f37\u5316\u70ba:\r\n";
            object2 = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            short s4 = (short)Randomizer.rand(8, 15);
            Equip equip3 = equip2;
            s3 = (short)(equip3.getHp() + s4);
            equip3.setHp(s3 > n2 ? (short)n2 : s3);
            object2 = (String)object2 + "\u8840\u91cf:  " + s4 + "\r\n";
            object2 = (String)object2 + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            equip2.setOwner("\u5f37\u5316HP[" + (n3 += s4) + "]");
            equip = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a3.getClient(), MapleInventoryType.EQUIP, a2, equip.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a3.getClient(), equip, false);
            a3.c.getPlayer().equipChanged();
            return object2;
        }
        return MapleImp.ALLATORIxDEMO("\u6b34\u88e2\u50c9\u4e19\u970e\u6294\u98f8\u001f\u621b\u5968p\u97b4\u5b00\u5508q\u50fa\u6759\u6294\u98f8\u001f\u621b\u5968p\u97b4\u5b00\u6272\u53bf\u4eda\u5f67\u5329.");
    }

    public /* synthetic */ void openFishingItemStore() {
        NPCConversationManager a2;
        if (!World.isShutDown) {
            NPCConversationManager nPCConversationManager = a2;
            nPCConversationManager.c.getPlayer().setConversation(6);
            nPCConversationManager.c.sendPacket(PlayerShopPacket.fishingItemStore((byte)34));
            return;
        }
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.getPlayer().dropMessage(1, InventoryException.ALLATORIxDEMO("\u768f\u5237\u4e6c\u8087\u4f1e\u7552\u7cdf\u9732\u5527\u4ec0\u9879\u53ac\u3063"));
        nPCConversationManager.c.sendPacket(MaplePacketCreator.enableActions());
    }

    public /* synthetic */ void forfeitQuest(int a2) {
        NPCConversationManager a3;
        MapleQuest.getInstance(a2).forfeit(a3.getPlayer());
    }

    public /* synthetic */ void changeJob(int a2) {
        NPCConversationManager a3;
        a3.c.getPlayer().changeJob(a2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public /* synthetic */ int setRandomAvatar(int a2, int ... a32) {
        NPCConversationManager nPCConversationManager;
        NPCConversationManager a4;
        if (!a4.haveItem(a2) && a2 != 0) {
            return -1;
        }
        int a32 = (a32 = a4.getCanStyle(a32))[Randomizer.nextInt(a32.length)];
        if (a32 < 100) {
            NPCConversationManager nPCConversationManager2 = a4;
            nPCConversationManager = nPCConversationManager2;
            a4.c.getPlayer().setSkinColor((byte)a32);
            nPCConversationManager2.c.getPlayer().updateSingleStat(MapleStat.SKIN, a32);
            nPCConversationManager2.gainItem(a2, (short)-1);
        } else if (a32 < 30000) {
            if (!NPCConversationManager.faceExists(a32)) return -1;
            NPCConversationManager nPCConversationManager3 = a4;
            nPCConversationManager = nPCConversationManager3;
            a4.c.getPlayer().setFace(a32);
            nPCConversationManager3.c.getPlayer().updateSingleStat(MapleStat.FACE, a32);
            nPCConversationManager3.gainItem(a2, (short)-1);
        } else {
            if (!NPCConversationManager.hairExists(a32)) return -1;
            NPCConversationManager nPCConversationManager4 = a4;
            nPCConversationManager = nPCConversationManager4;
            a4.c.getPlayer().setHair(a32);
            nPCConversationManager4.c.getPlayer().updateSingleStat(MapleStat.HAIR, a32);
            nPCConversationManager4.gainItem(a2, (short)-1);
        }
        nPCConversationManager.c.getPlayer().equipChanged();
        return 1;
    }

    public /* synthetic */ void buffGuild(int a22, int a3, String a4) {
        NPCConversationManager a5;
        Object object = MapleItemInformationProvider.getInstance();
        if (((MapleItemInformationProvider)object).getItemEffect(a22) != null && a5.getPlayer().getGuildId() > 0) {
            MapleStatEffect a22 = ((MapleItemInformationProvider)object).getItemEffect(a22);
            object = LoginServer.getWorlds().iterator();
            while (object.hasNext()) {
                Iterator<ChannelServer> iterator = ((World)object.next()).getChannels().iterator();
                while (iterator.hasNext()) {
                    for (MapleCharacter mapleCharacter : iterator.next().getPlayerStorage().getAllCharacters()) {
                        if (mapleCharacter.getGuildId() != a5.getPlayer().getGuildId()) continue;
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        a22.applyTo(mapleCharacter2, mapleCharacter, true, null, a3);
                        mapleCharacter2.dropMessage(5, "Your guild has gotten a " + a4 + " buff.");
                    }
                }
            }
        }
    }

    public /* synthetic */ void killAllMonsters() {
        NPCConversationManager a2;
        MapleMap mapleMap = a2.c.getPlayer().getMap();
        double d2 = Double.POSITIVE_INFINITY;
        MapleMapObjectType[] arrmapleMapObjectType = new MapleMapObjectType[1];
        arrmapleMapObjectType[0] = MapleMapObjectType.MONSTER;
        for (MapleMonster mapleMonster : mapleMap.getMapObjectsInRange(a2.c.getPlayer().getPosition(), d2, Arrays.asList(arrmapleMapObjectType))) {
            if (!mapleMonster.getStats().isBoss()) continue;
            mapleMap.killMonster(mapleMonster, a2.c.getPlayer(), false, false, (byte)1);
        }
    }

    public /* synthetic */ long getBlackJackNowBet() {
        return BlackJack.getInstance().getNowBet();
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ String HappyEquipStar(byte a2, int a32, int a4) {
        Equip a32;
        NPCConversationManager a5;
        Equip equip = a32 = (Equip)a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2);
        int n2 = a5.c.getPlayer().getInventory(MapleInventoryType.EQUIP).getItem(a2).getItemId();
        n2 = MapleItemInformationProvider.getInstance().isCash(n2) ? (byte)1 : 0;
        Object object = "";
        if (n2 == 0) return InventoryException.ALLATORIxDEMO("Y\u0013\u6b1e\u88bc\u50e3\u4e47\u9724\u5326\u6665\u9032\u510dA\uff76\u7140\u6caf\u5326\u7d60\u3063");
        n2 = a5.getEquipLevel(equip.getOwner());
        if (n2 >= 14) {
            return MapleImp.ALLATORIxDEMO("sM\u6b34\u88e2\u50c9\u5dcd\u9004\u520f\u6750\u9ae7\u664f\u6547.\u711e\u6c85\u7e43\u7edc\u5378\u7d4a\u56f6q");
        }
        if (!a5.c.getPlayer().haveItem(a4)) {
            return "#r\u5347\u661f\u9700\u8981#i" + a4 + "# 1 \u500b!";
        }
        a5.c.getPlayer().gainItem(a4, -1);
        a4 = 0;
        short s2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        short s3 = 0;
        short s4 = 0;
        short s5 = 0;
        short s6 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        switch (n2 + 1) {
            case 1: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n11 = 100;
                break;
            }
            case 2: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n11 = 100;
                break;
            }
            case 3: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n11 = 100;
                break;
            }
            case 4: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n11 = 100;
                break;
            }
            case 5: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n11 = 100;
                break;
            }
            case 6: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n11 = 100;
                break;
            }
            case 7: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 40;
                n10 = 40;
                n8 = 1;
                n7 = 1;
                n11 = 50;
                break;
            }
            case 8: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 40;
                n10 = 40;
                n8 = 1;
                n7 = 1;
                n11 = 40;
                break;
            }
            case 9: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                n10 = 100;
                n8 = 1;
                n7 = 1;
                n11 = 40;
                break;
            }
            case 10: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                n10 = 100;
                n8 = 2;
                n7 = 2;
                n11 = 40;
                break;
            }
            case 11: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                n10 = 100;
                n8 = 2;
                n7 = 2;
                n11 = 30;
                break;
            }
            case 12: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 100;
                n10 = 100;
                n8 = 2;
                n7 = 2;
                n11 = 30;
                break;
            }
            case 13: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 200;
                n10 = 200;
                n8 = 3;
                n7 = 3;
                n11 = 30;
                break;
            }
            case 14: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 200;
                n10 = 200;
                n8 = 3;
                n7 = 3;
                n11 = 20;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < n11) {
            Equip equip2 = equip;
            Equip equip3 = equip;
            equip3.setStr((short)(equip3.getStr() + n3));
            equip3.setDex((short)(equip3.getDex() + n4));
            equip3.setInt((short)(equip3.getInt() + n5));
            equip3.setLuk((short)(equip3.getLuk() + n6));
            equip3.setWatk((short)(equip3.getWatk() + n7));
            equip3.setMatk((short)(equip3.getMatk() + n8));
            equip3.setMdef((short)(equip3.getMdef() + s4));
            equip3.setWdef((short)(equip3.getWdef() + s5));
            equip3.setAcc((short)(equip3.getAcc() + s6));
            equip3.setAvoid((short)(equip3.getAvoid() + s3));
            equip3.setJump((short)(equip3.getJump() + a4));
            equip3.setSpeed((short)(equip3.getSpeed() + s2));
            equip3.setHp((short)(equip3.getHp() + n9));
            equip2.setMp((short)(equip3.getMp() + n10));
            equip2.setOwner(a5.getEquipStar(n2 + 1));
            a32 = (Equip)equip2.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), a32, false);
            a5.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u6210\u529f!!\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a5.getEquipStar(n2 + 1) + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u529b\u91cf:#r" + n3 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u654f\u6377:#r" + n4 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u667a\u529b:#r" + n5 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u5e78\u904b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u7269\u7406\u9632\u79a6\u529b:#r" + s5 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u9b54\u6cd5\u9632\u79a6\u529b:#r" + s4 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u8df3\u8e8d\u529b:#r" + a4 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u79fb\u52d5\u901f\u5ea6:#r" + s2 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u8ff4\u907f\u7387:#r" + s3 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u547d\u4e2d\u7387:#r" + s6 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u8840\u91cf:#r" + n9 + "#b\r\n";
            object = (String)object + "\u589e\u52a0\u9b54\u529b:#r" + n10 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!!\u606d\u559c!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a5.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        a4 = 0;
        s2 = 0;
        n3 = 0;
        n4 = 0;
        n5 = 0;
        n6 = 0;
        n7 = 0;
        n8 = 0;
        s3 = 0;
        s4 = 0;
        s5 = 0;
        s6 = 0;
        n9 = 0;
        n10 = 0;
        n11 = 0;
        int n12 = 0;
        switch (n2) {
            case 1: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n12 = 0;
                break;
            }
            case 2: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n12 = 0;
                break;
            }
            case 3: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n12 = 0;
                break;
            }
            case 4: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n12 = 0;
                break;
            }
            case 5: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n12 = 0;
                break;
            }
            case 6: {
                n3 = 1;
                n4 = 1;
                n5 = 1;
                n6 = 1;
                n9 = 20;
                n10 = 20;
                n12 = 0;
                break;
            }
            case 7: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 40;
                n10 = 40;
                n8 = 1;
                n7 = 1;
                n12 = 50;
                break;
            }
            case 8: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 40;
                n10 = 40;
                n8 = 1;
                n7 = 1;
                n12 = 50;
                break;
            }
            case 9: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                n10 = 100;
                n8 = 1;
                n7 = 1;
                n12 = 40;
                break;
            }
            case 10: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                n10 = 100;
                n8 = 2;
                n7 = 2;
                n12 = 30;
                break;
            }
            case 11: {
                n3 = 2;
                n4 = 2;
                n5 = 2;
                n6 = 2;
                n9 = 100;
                n10 = 100;
                n8 = 2;
                n7 = 2;
                n12 = 30;
                break;
            }
            case 12: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 100;
                n10 = 100;
                n8 = 2;
                n7 = 2;
                n12 = 20;
                break;
            }
            case 13: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 200;
                n10 = 200;
                n8 = 3;
                n7 = 3;
                n12 = 20;
                break;
            }
            case 14: {
                n3 = 3;
                n4 = 3;
                n5 = 3;
                n6 = 3;
                n9 = 200;
                n10 = 200;
                n8 = 3;
                n7 = 3;
                n12 = 30;
                break;
            }
        }
        if (Randomizer.rand(0, 100) < n12) {
            Equip equip4 = equip;
            Equip equip5 = equip;
            equip5.setStr((short)(equip5.getStr() - n3));
            equip5.setDex((short)(equip5.getDex() - n4));
            equip5.setInt((short)(equip5.getInt() - n5));
            equip5.setLuk((short)(equip5.getLuk() - n6));
            equip5.setWatk((short)(equip5.getWatk() - n7));
            equip5.setMatk((short)(equip5.getMatk() - n8));
            equip5.setMdef((short)(equip5.getMdef() - s4));
            equip5.setWdef((short)(equip5.getWdef() - s5));
            equip5.setAcc((short)(equip5.getAcc() - s6));
            equip5.setAvoid((short)(equip5.getAvoid() - s3));
            equip5.setJump((short)(equip5.getJump() - a4));
            equip5.setSpeed((short)(equip5.getSpeed() - s2));
            equip5.setHp((short)(equip5.getHp() - n9));
            equip4.setMp((short)(equip5.getMp() - n10));
            equip4.setOwner(a5.getEquipStar(n2 - 1));
            a32 = (Equip)equip4.copy();
            MapleInventoryManipulator.removeFromSlot(a5.getClient(), MapleInventoryType.EQUIP, a2, a32.getQuantity(), false);
            MapleInventoryManipulator.addFromDrop(a5.getClient(), a32, false);
            a5.c.getPlayer().equipChanged();
            object = (String)object + "#b\u88dd\u5099\u5347\u7d1a\u5931\u6557!!\u88dd\u5099\u964d\u7d1a!!(\u6210\u529f\u6a5f\u7387" + n11 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u738750%)\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "\u76ee\u524d\u88dd\u5099\u7b49\u7d1a:#r" + a5.getEquipStar(n2 - 1) + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u529b\u91cf:#r" + n3 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u654f\u6377:#r" + n4 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u667a\u529b:#r" + n5 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u5e78\u904b:#r" + n6 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u7269\u7406\u653b\u64ca\u529b:#r" + n7 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u9b54\u6cd5\u653b\u64ca\u529b:#r" + n8 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u7269\u7406\u9632\u79a6\u529b:#r" + s5 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u9b54\u6cd5\u9632\u79a6\u529b:#r" + s4 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u8df3\u8e8d\u529b:#r" + a4 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u79fb\u52d5\u901f\u5ea6:#r" + s2 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u8ff4\u907f\u7387:#r" + s3 + "#b\r\n";
            object = (String)object + "\u6e1b\u5c11\u547d\u4e2d\u7387:#r" + s6 + "#b\r\n";
            object = (String)object + "\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\uff0d\r\n";
            object = (String)object + "!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!!\u62b1\u6b49!!";
            FileoutputUtil.logToFile("logs/Data/\u88dd\u5099\u5347\u7d1a\u7d00\u9304/" + a5.c.getPlayer().getName() + ".txt", "\r\n" + FileoutputUtil.NowTime() + "\u7269\u54c1ID:" + a32.getItemName() + "(" + a32.getItemId() + ") \u8cc7\u8a0a:" + (String)object);
            return object;
        }
        return "#r\u88dd\u5099\u5347\u7d1a\u5931\u6557!!(\u6210\u529f\u6a5f\u7387" + n11 + "%)(\u5931\u6557\u5f8c\u964d\u7d1a\u6a5f\u7387" + n12 + "%)";
    }

    public /* synthetic */ void showFm() {
        NPCConversationManager a2;
        NPCConversationManager nPCConversationManager = a2;
        nPCConversationManager.c.sendPacket(MaplePacketCreator.showfameRanks(nPCConversationManager.E, MapleRanking.getInstance().getFameRank()));
    }

    public /* synthetic */ byte isSquadLeader(String a2) {
        NPCConversationManager a3;
        a2 = a3.c.getChannelServer().getMapleSquad((String)a2);
        if (a2 == null) {
            return -1;
        }
        if (((MapleSquad)a2).getLeader() != null && ((MapleSquad)a2).getLeader().getId() == a3.c.getPlayer().getId()) {
            return 1;
        }
        return 0;
    }

    public final /* synthetic */ boolean dropItem(int a2, int a32, int a4) {
        NPCConversationManager a5;
        MapleInventoryType a32 = MapleInventoryType.getByType((byte)a32);
        if (a32 == null) {
            return false;
        }
        return MapleInventoryManipulator.drop(a5.c, a32, (short)a2, (short)a4, true);
    }

    public /* synthetic */ int getBuddyCapacity() {
        NPCConversationManager a2;
        return a2.c.getPlayer().getBuddyCapacity();
    }

    public /* synthetic */ int getBeans() {
        NPCConversationManager a2;
        return a2.getClient().getPlayer().getBeans();
    }

    public /* synthetic */ boolean useGoldScissor(int a22, short a32) {
        IItem iItem;
        NPCConversationManager a4;
        IItem a22 = a4.getInventory(a22).getItem(a32);
        if (a22 == null) {
            return false;
        }
        MapleInventoryType a32 = GameConstants.getInventoryType(a22.getItemId());
        if (a32 == null) {
            return false;
        }
        int n2 = a22.getFlag();
        int n3 = 0;
        if (a32 == MapleInventoryType.EQUIP ? ItemFlag.KARMA_EQ.check(n2) : ItemFlag.KARMA_USE.check(n2)) {
            return false;
        }
        if (a32 == MapleInventoryType.EQUIP) {
            n3 |= ItemFlag.KARMA_EQ.getValue();
            iItem = a22;
        } else {
            n3 |= ItemFlag.KARMA_USE.getValue();
            iItem = a22;
        }
        iItem.setFlag(n3);
        a4.c.getPlayer().forceReAddItem_Flag(a22, a32);
        return true;
    }

    public /* synthetic */ String ShowMonsterPetSkill(MapleCharacter a2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = a2.getMonsterPet(2) / 10;
        stringBuilder.append(InventoryException.ALLATORIxDEMO("B\b\u538e\u668e\u63ba\u76fe\u62e1\u8087[wk"));
        int n3 = 0;
        int n4 = n3;
        while (n4 <= n2) {
            int n5 = n3 + 1;
            if (!MapleMonsterPet.MapleMonsterPetSkill.getName(MapleMonsterPet.MapleMonsterPetSkill.getById(n3)).equals(MapleImp.ALLATORIxDEMO("\u0005Q;Q?H>"))) {
                int n6 = n3;
                stringBuilder.append("#b#L" + n6 + "# \u6280\u80fd" + n5 + ":#d" + MapleMonsterPet.MapleMonsterPetSkill.getName(MapleMonsterPet.MapleMonsterPetSkill.getById(n6)) + (a2.getMonsterPet(3) == n3 ? InventoryException.ALLATORIxDEMO("B\b\u3071\u4f05\u7549\u4e57\u3070Y\n") : "") + "\r\n");
            }
            n4 = ++n3;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ void sendStorageExceed(MapleStorageType a2) {
        NPCConversationManager a3;
        if (a3.getPlayer().getMap() == null || a3.getPlayer().getTrade() != null || !a3.getPlayer().isAlive()) {
            NPCConversationManager nPCConversationManager = a3;
            nPCConversationManager.c.getPlayer().dropMessage(1, InventoryException.ALLATORIxDEMO("\u7694\u522c\u715b\u6cb4\u578d\u882d\u6b1e\u52b4\u4f26\u3063"));
            nPCConversationManager.c.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!World.isShutDown) {
            NPCConversationManager nPCConversationManager = a3;
            NPCConversationManager nPCConversationManager2 = a3;
            nPCConversationManager.getPlayer().addStorageMsg(nPCConversationManager2.getPlayer().getName(), MapleImp.ALLATORIxDEMO("p\u95b4\u550f\u9872\u5946\u5036\u5efb2Z"));
            nPCConversationManager.c.getPlayer().setConversation(4);
            nPCConversationManager2.getPlayer().setOperateStorage(true);
            NPCConversationManager nPCConversationManager3 = a3;
            nPCConversationManager.c.getPlayer().getStorageExceed().get((Object)a2).sendStorage(nPCConversationManager3.c, nPCConversationManager3.E);
            return;
        }
        NPCConversationManager nPCConversationManager = a3;
        nPCConversationManager.c.getPlayer().dropMessage(1, InventoryException.ALLATORIxDEMO("\u768f\u5237\u4e6c\u8087\u4f1e\u7552\u982c\u596c\u5068\u5ed1\u3063"));
        nPCConversationManager.c.sendPacket(MaplePacketCreator.enableActions());
    }

    public /* synthetic */ void warpPartyWithExp(int a222, int a3) {
        NPCConversationManager a4;
        NPCConversationManager nPCConversationManager = a4;
        MapleMap a222 = nPCConversationManager.getMap(a222);
        for (MaplePartyCharacter maplePartyCharacter : nPCConversationManager.getPlayer().getParty().getMembers()) {
            MapleCharacter serializable = a4.c.getChannelServer().getPlayerStorage().getCharacterByName(maplePartyCharacter.getName());
            if ((serializable.getEventInstance() != null || a4.getPlayer().getEventInstance() != null) && serializable.getEventInstance() != a4.getPlayer().getEventInstance()) continue;
            MapleMap mapleMap = a222;
            serializable.changeMap(mapleMap, mapleMap.getPortal(0));
            serializable.gainExp(a3, true, false, true);
        }
    }

    public /* synthetic */ void say(int a2, int a3, int a4, String a5, boolean a6, boolean a7) {
        NPCConversationManager a8;
        a8.say(a2, a3, -1, a4, a5, a6, a7);
    }

    public /* synthetic */ void addDecorations(int a22) {
        try {
            NPCConversationManager a3;
            AramiaFireWorks.getInstance().giveDecs(a3.c.getPlayer(), a22);
            return;
        }
        catch (Exception a22) {
            return;
        }
    }
}

