/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelDuplexHandler
 *  io.netty.channel.ChannelHandlerContext
 */
package handling;

import client.MapleClient;
import client.messages.commands.SkilledCommand;
import constants.BanAttackIP;
import constants.GameSetConstants;
import constants.ServerConfig;
import handling.ClientChannelGroup;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import handling.auction.handler.MTSOperation;
import handling.cashshop.handler.CashShopOperation;
import handling.channel.ChannelServer;
import handling.channel.handler.AllianceHandler;
import handling.channel.handler.BBSHandler;
import handling.channel.handler.BeanGame;
import handling.channel.handler.BuddyListHandler;
import handling.channel.handler.ChatHandler;
import handling.channel.handler.FamilyHandler;
import handling.channel.handler.GuildHandler;
import handling.channel.handler.HiredFishingHandler;
import handling.channel.handler.HiredMerchantHandler;
import handling.channel.handler.InterServerHandler;
import handling.channel.handler.InventoryHandler;
import handling.channel.handler.ItemMakerHandler;
import handling.channel.handler.MobHandler;
import handling.channel.handler.MonsterCarnivalHandler;
import handling.channel.handler.NPCHandler;
import handling.channel.handler.PartyHandler;
import handling.channel.handler.PetHandler;
import handling.channel.handler.PlayerHandler;
import handling.channel.handler.PlayerInteractionHandler;
import handling.channel.handler.PlayersHandler;
import handling.channel.handler.StatsHandling;
import handling.channel.handler.SummonHandler;
import handling.channel.handler.UserInterfaceHandler;
import handling.login.LoginServer;
import handling.login.handler.CharLoginHandler;
import handling.mina.MaplePacketDecoder;
import handling.world.World;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import scripting.npc.NPCScriptManager;
import server.MTSStorage;
import server.ShutdownServer;
import server.Timer;
import server.life.MonsterDropEntry;
import server.maps.MapleNodes;
import server.swing.WvsCenter;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.HexTool;
import tools.MapleAESOFB;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.StringUtil;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;
import tools.packet.LoginPacket;
import tools.packet.MTSCSPacket;

public class MapleServerHandler
extends ChannelDuplexHandler {
    private static final /* synthetic */ Map<String, Long> K;
    private final /* synthetic */ boolean k;
    public static final /* synthetic */ int AUCTION_SERVER = -20;
    public static /* synthetic */ List<String> iplist;
    public static final /* synthetic */ int LOGIN_SERVER = 0;
    private final /* synthetic */ int B;
    public static /* synthetic */ List<String> names;
    private final /* synthetic */ int g;
    private static final /* synthetic */ EnumSet<RecvPacketOpcode> ALLATORIxDEMO;
    private static final /* synthetic */ String d;
    private static final /* synthetic */ Map<String, Pair<Long, Byte>> a;
    public static final /* synthetic */ int CASH_SHOP_SERVER = -10;

    public /* synthetic */ void channelActive(ChannelHandlerContext a2) throws Exception {
        MapleClient mapleClient;
        MapleServerHandler a3;
        Object object;
        String string = a2.channel().remoteAddress().toString().split(SkilledCommand.ALLATORIxDEMO("\u0011"))[0];
        if (!(GameSetConstants.FOWARD_PROTECT || GameSetConstants.PROXY_IP || GameSetConstants.SERVER_NAME.equals(MonsterDropEntry.ALLATORIxDEMO("\u5e4f\u4e74\u8c00")))) {
            block23: {
                if (BanAttackIP.ipban.contains(string)) break block23;
                BanAttackIP.checkAttackIP(a2, string);
            }
            try {
                a2.channel().close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        ClientChannelGroup.getChannels().add((Object)a2.channel());
        ClientChannelGroup.CheckChannel(a2.channel());
        WvsCenter.getInstance().updateChannelNumber();
        if (GameSetConstants.LOG_PACKETS && !BanAttackIP.ipadd.contains(string)) {
            BanAttackIP.ipadd.add(string);
            FileoutputUtil.logToFile(SkilledCommand.ALLATORIxDEMO("G\u0014L\b\u00042{$h4e5n8\u007fU_\u0003_"), "\r\n " + string, false);
        }
        if (!(GameSetConstants.FOWARD_PROTECT || GameSetConstants.PROXY_IP || GameSetConstants.SERVER_NAME.equals(MonsterDropEntry.ALLATORIxDEMO("\u5e4f\u4e74\u8c00")))) {
            byte by;
            if (K.containsKey(string)) {
                long l2 = System.currentTimeMillis() - K.get(string);
                if (l2 < 60000L) {
                    a2.channel().close();
                    return;
                }
                K.remove(string);
            }
            if ((object = a.get(string)) == null) {
                by = 1;
            } else {
                byte by2;
                by = (Byte)((Pair)object).right;
                long l3 = System.currentTimeMillis() - (Long)((Pair)object).left;
                if (l3 < 2000L) {
                    by2 = by = (byte)(by + 1);
                } else {
                    if (l3 > 20000L) {
                        by = 1;
                    }
                    by2 = by;
                }
                if (by2 >= 10) {
                    K.put(string, System.currentTimeMillis());
                    a.remove(string);
                    a2.channel().close();
                    return;
                }
            }
            a.put(string, new Pair<Long, Byte>(System.currentTimeMillis(), by));
        }
        if (a3.B == -10) {
            if (ShutdownServer.running) {
                a2.channel().close();
                return;
            }
        } else if (a3.B == 0) {
            if (LoginServer.isShutdown()) {
                a2.channel().close();
                return;
            }
        } else if (a3.B > 0) {
            MapleServerHandler mapleServerHandler = a3;
            if (ChannelServer.getInstance(mapleServerHandler.g, mapleServerHandler.B).isShutdown()) {
                a2.channel().close();
                return;
            }
        } else {
            System.out.println("[\u9023\u7d50\u932f\u8aa4] \u672a\u77e5\u985e\u578b: " + a3.B);
            a2.channel().close();
            return;
        }
        byte[] arrby = new byte[4];
        arrby[0] = 70;
        arrby[1] = 114;
        arrby[2] = 122;
        arrby[3] = (byte)(Math.random() * 255.0);
        object = arrby;
        byte[] arrby2 = new byte[4];
        arrby2[0] = 82;
        arrby2[1] = 48;
        arrby2[2] = 120;
        arrby2[3] = (byte)(Math.random() * 255.0);
        byte[] arrby3 = arrby2;
        MapleClient mapleClient2 = mapleClient = new MapleClient(new MapleAESOFB(arrby3, (short)(65535 - GameSetConstants.MAPLE_VERSION)), new MapleAESOFB((byte[])object, GameSetConstants.MAPLE_VERSION), a2.channel());
        MapleServerHandler mapleServerHandler = a3;
        mapleClient.setWorld(mapleServerHandler.g);
        mapleClient2.setChannel(mapleServerHandler.B);
        mapleClient2.setCs(a3.k);
        MaplePacketDecoder.DecoderState decoderState = new MaplePacketDecoder.DecoderState();
        ChannelHandlerContext channelHandlerContext = a2;
        channelHandlerContext.channel().attr(MaplePacketDecoder.DECODER_STATE_KEY).set((Object)decoderState);
        channelHandlerContext.writeAndFlush((Object)LoginPacket.getHello(GameSetConstants.MAPLE_VERSION, arrby3, (byte[])object));
        a2.channel().attr(MapleClient.CLIENT_KEY).set((Object)mapleClient);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isPlayerPacket(RecvPacketOpcode a2) {
        switch (a2) {
            case HELLO_CHANNEL: 
            case PLAYER_LOGGEDIN: 
            case SERVERLIST_REQUEST: 
            case CHARLIST_REQUEST: 
            case CHAR_SELECT: 
            case CLIENT_HELLO: 
            case YUTO_SHIELD_DETECT: 
            case LOGIN_AUTH: 
            case CLIENT_LOGOUT: 
            case PONG: 
            case STRANGE_DATA: 
            case HELLO_LOGIN: 
            case LOGIN_PASSWORD: 
            case REMOVE_LOGIN: 
            case LOG_OUT: 
            case SERVERSTATUS_REQUEST: 
            case CHECK_CHAR_NAME: 
            case PART_TIME_JOB: 
            case CREATE_CHAR_2: 
            case CREATE_CHAR: 
            case CREATE_ULTIMATE: 
            case DELETE_CHAR: 
            case CHAR_SELECT_SECOND_PASSWORD: 
            case SET_GENDER: 
            case CLIENT_ERROR: 
            case PACKET_ERROR: 
            case CLIENT_FEEDBACK: {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ void userEventTriggered(ChannelHandlerContext a2, Object a3) throws Exception {
        MapleServerHandler a4;
        MapleClient mapleClient = (MapleClient)a2.channel().attr(MapleClient.CLIENT_KEY).get();
        if (mapleClient == null) {
            a2.channel().close();
            return;
        }
        mapleClient.sendPing();
        super.userEventTriggered(a2, a3);
    }

    public /* synthetic */ MapleServerHandler(int a2, int a3, boolean a4) {
        MapleServerHandler a5;
        MapleServerHandler mapleServerHandler = a5;
        a5.g = a2;
        mapleServerHandler.B = a3;
        mapleServerHandler.k = a4;
    }

    public static /* synthetic */ {
        K = new ConcurrentHashMap<String, Long>();
        a = new ConcurrentHashMap<String, Pair<Long, Byte>>();
        d = System.getProperty(MonsterDropEntry.ALLATORIxDEMO("S^QR\u0011DZG^E^CPE"));
        iplist = new LinkedList<String>();
        ALLATORIxDEMO = EnumSet.noneOf(RecvPacketOpcode.class);
        RecvPacketOpcode[] arrrecvPacketOpcode = new RecvPacketOpcode[7];
        arrrecvPacketOpcode[0] = RecvPacketOpcode.NPC_ACTION;
        arrrecvPacketOpcode[1] = RecvPacketOpcode.MOVE_PLAYER;
        arrrecvPacketOpcode[2] = RecvPacketOpcode.MOVE_PET;
        arrrecvPacketOpcode[3] = RecvPacketOpcode.MOVE_SUMMON;
        arrrecvPacketOpcode[4] = RecvPacketOpcode.MOVE_LIFE;
        arrrecvPacketOpcode[5] = RecvPacketOpcode.HEAL_OVER_TIME;
        arrrecvPacketOpcode[6] = RecvPacketOpcode.STRANGE_DATA;
        RecvPacketOpcode[] arrrecvPacketOpcode2 = arrrecvPacketOpcode;
        ALLATORIxDEMO.addAll(Arrays.asList(arrrecvPacketOpcode2));
        names = new LinkedList<String>();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public /* synthetic */ void channelInactive(ChannelHandlerContext a) throws Exception {
        var2_2 = (MapleClient)a.channel().attr(MapleClient.CLIENT_KEY).get();
        if (var2_2 == null) ** GOTO lbl30
        if (var2_2.getPlayer() == null) ** GOTO lbl20
        var2_2.getPlayer().saveToDB(true, a.B == -10);
        if (var2_2.getLoginState() == 4 || var2_2.getLoginState() == 9 || var2_2.getLoginState() == 7 || var2_2.getLoginState() == 10 || var2_2.getLoginState() == 6 || var2_2.getLoginState() == 1 || var2_2.getPlayer() == null) ** GOTO lbl24
        v0 = var2_2;
        var3_4 = World.Find.findChannel(v0.getPlayer().getId());
        var4_6 = World.Find.findWorld(v0.getPlayer().getId());
        try {
            if (var3_4 != -1 && var4_6 != -1 && ChannelServer.getInstance(var4_6, var3_4) != null) {
                ChannelServer.getInstance(var4_6, var3_4).removePlayer(var2_2.getPlayer());
            }
            ** GOTO lbl17
        }
        catch (Exception var3_5) {
            block11: {
                System.out.println(var3_5);
lbl17:
                // 2 sources

                var2_2.disconnect();
                v1 = a;
                break block11;
lbl20:
                // 1 sources

                if (var2_2.getLoginState() == 3 || var2_2.getLoginState() == 11 || var2_2.getLoginState() == 5) {
                    var2_2.updateLoginState(0, var2_2.getSessionIPAddress());
                }
                var2_2.getSession().close();
lbl24:
                // 2 sources

                v1 = a;
            }
            if (v1.B == 0) {
                v2 = var2_2;
                v2.setCanloginpw(false);
                LoginServer.removeClient(v2);
            }
lbl30:
            // 4 sources

            if (var2_2 != null) {
                a.channel().attr(MapleClient.CLIENT_KEY).remove();
            }
        }
        WvsCenter.getInstance().updateChannelNumber();
    }

    private static /* synthetic */ String ALLATORIxDEMO(int a2) {
        int n2;
        SendPacketOpcode[] arrsendPacketOpcode = SendPacketOpcode.values();
        int n3 = arrsendPacketOpcode.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            SendPacketOpcode sendPacketOpcode = arrsendPacketOpcode[n2];
            if (sendPacketOpcode.getValue() == a2) {
                return sendPacketOpcode.name();
            }
            n4 = ++n2;
        }
        return SkilledCommand.ALLATORIxDEMO("~5`5d,e");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void handlePacket(RecvPacketOpcode a2, LittleEndianAccessor a3, MapleClient a4, boolean a3222, int a2222) throws Exception {
        if (GameSetConstants.PACKET_CHECK && a4 != null) {
            a4.handlePacket(a3.toString().length());
        }
        if (MapleServerHandler.isPlayerPacket(a2) && a4.getPlayer() == null && !names.contains(a2.name())) {
            names.add(a2.name());
            FileoutputUtil.logToFile(SkilledCommand.ALLATORIxDEMO("\u0017D\u001cXTc\u001aH\u0010\u0004\u750b\u5e13\u5c7a\u532eU_\u0003_"), "\r\n" + FileoutputUtil.NowTime() + " " + a2.name());
            return;
        }
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 6: {
                LittleEndianAccessor littleEndianAccessor = a3;
                byte by = littleEndianAccessor.readByte();
                short s2 = littleEndianAccessor.readShort();
                String string = String.valueOf(littleEndianAccessor.readShort());
                if (by == 6 && s2 == GameSetConstants.MAPLE_VERSION && string.equals(GameSetConstants.MAPLE_PATCH)) break;
                System.out.println(by + " version:" + s2 + " patch:" + string);
                if (ServerConfig.LOG_DC) {
                    FileoutputUtil.logToFile(MonsterDropEntry.ALLATORIxDEMO("SXXD\u0010S^C^\u0018{t\u0011CGC"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                }
                a4.getSession().close();
                return;
            }
            case 7: {
                a4.getPlayer().UpdateYutoShieldTime();
                return;
            }
            case 8: {
                a4.getSession().writeAndFlush((Object)LoginPacket.getLoginAUTH());
                return;
            }
            case 9: {
                PlayerHandler.handleLogout(a3, a4);
                return;
            }
            case 10: {
                a4.pongReceived();
                return;
            }
            case 11: {
                return;
            }
            case 12: {
                if (a3.available() < 5L) break;
                Long l2 = a3.available();
                Object object = "";
                if (a4 != null) {
                    object = (String)object + a4.getAccountName() + "_";
                }
                FilePrinter.print((String)object + "38Logs.txt", HexTool.toStringFromAscii(a3.read(l2.intValue())), true);
                return;
            }
            case 1: {
                CharLoginHandler.handleWelcome(a4);
                return;
            }
            case 13: {
                CharLoginHandler.handleLogin(a3, a4);
                return;
            }
            case 14: {
                CharLoginHandler.RemoveLogin(a3, a4);
                return;
            }
            case 15: {
                CharLoginHandler.LogOut(a3, a4);
                return;
            }
            case 3: {
                CharLoginHandler.ServerListRequest(a4);
                return;
            }
            case 4: {
                CharLoginHandler.CharlistRequest(a3, a4);
                return;
            }
            case 16: {
                CharLoginHandler.ServerStatusRequest(a4);
                return;
            }
            case 17: {
                try {
                    CharLoginHandler.checkCharName(a3.readMapleAsciiString(), a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("8C\u001aY7D\u001cB\u0015c\u001aE\u001fG\u001eYU_\u0003_"), exception, " checkCharName has Exception, Packet: " + a3.toString());
                    return;
                }
            }
            case 28: {
                CashShopOperation.ChangeName(a3, a4);
                return;
            }
            case 18: {
                PlayerHandler.handlePartTimeJob(a3, a4);
                return;
            }
            case 19: {
                CharLoginHandler.handleCreateCharacter(a3, a4, true);
                return;
            }
            case 20: {
                CharLoginHandler.handleCreateCharacter(a3, a4, false);
                return;
            }
            case 21: {
                CharLoginHandler.CreateUltimate(a3, a4);
                return;
            }
            case 22: {
                CharLoginHandler.handleDeleteCharacter(a3, a4);
                return;
            }
            case 5: {
                CharLoginHandler.handleSelectCharacter(a3, a4);
                return;
            }
            case 23: {
                CharLoginHandler.handleSelectCharacter(a3, a4, true);
                return;
            }
            case 29: {
                MapleClient mapleClient = a4;
                PlayerHandler.specialAttack(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 24: {
                try {
                    CharLoginHandler.SetGenderRequest(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("|_^EsXX^Q\u007f^Y[[ZE\u0011CGC"), exception, " SetGenderRequest has Exception, Packet: " + a3.toString());
                    return;
                }
            }
            case 30: 
            case 31: {
                MapleClient mapleClient = a4;
                InterServerHandler.ChangeChannel(a3, mapleClient, mapleClient.getPlayer(), a2 == RecvPacketOpcode.CHANGE_ROOM_CHANNEL);
                return;
            }
            case 2: {
                int n2;
                int n3 = n2 = a3.readInt();
                if (a3222) {
                    CashShopOperation.EnterCashShop(n3, a4, a2222);
                    return;
                }
                InterServerHandler.LoggedIn(n3, a4);
                return;
            }
            case 32: {
                MapleClient mapleClient = a4;
                if (GameSetConstants.AUTO_CS_ITEM) {
                    mapleClient.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
                    NPCScriptManager.getInstance().start(a4, 9010000, SkilledCommand.ALLATORIxDEMO("\u9049\u514e\u553d\u57e5"));
                    return;
                }
                InterServerHandler.EnterCashShop(mapleClient, a4.getPlayer());
                return;
            }
            case 33: {
                if (a4.getPlayer().inMapleLand() && !a4.getPlayer().isGM()) {
                    a4.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
                    a4.getPlayer().dropMessage(5, MonsterDropEntry.ALLATORIxDEMO("\u571f\u696c\u4e7c\u5cc9\u7116\u6cea\u4f48\u7517\u62fa\u8cdc\u3035"));
                    return;
                }
                a4.getSession().writeAndFlush((Object)MaplePacketCreator.enableActions());
                NPCScriptManager.getInstance().start(a4, 9010000, SkilledCommand.ALLATORIxDEMO("\u8021\u5423\u52e4\u80d6"));
                return;
            }
            case 34: {
                try {
                    MapleClient mapleClient = a4;
                    PlayerHandler.MovePlayer(a3, mapleClient, mapleClient.getPlayer());
                    return;
                }
                catch (Exception exception) {
                    System.out.println("MOVE_PLAYER_1\u932f\u8aa4" + exception);
                    exception.printStackTrace();
                    return;
                }
            }
            case 35: {
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                PlayerHandler.CharInfoRequest(a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 36: {
                try {
                    MapleClient mapleClient = a4;
                    PlayerHandler.closeRangeAttack(a3, mapleClient, mapleClient.getPlayer(), false);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return;
                }
            }
            case 37: {
                MapleClient mapleClient = a4;
                PlayerHandler.rangedAttack(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 38: {
                MapleClient mapleClient = a4;
                PlayerHandler.MagicDamage(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 39: {
                MapleClient mapleClient = a4;
                PlayerHandler.SpecialMove(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 40: {
                ItemMakerHandler.ProfessionInfo(a3, a4);
                return;
            }
            case 41: 
            case 42: {
                MapleClient mapleClient = a4;
                PlayerHandler.closeRangeAttack(a3, mapleClient, mapleClient.getPlayer(), true);
                return;
            }
            case 43: {
                PlayerHandler.ChangeEmotion(a3.readInt(), a4.getPlayer());
                return;
            }
            case 44: {
                MapleClient mapleClient = a4;
                PlayerHandler.TakeDamage(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 45: {
                PlayersHandler.ApplyLinkedSkill(a3, a4);
                return;
            }
            case 46: {
                PlayerHandler.Heal(a3, a4.getPlayer());
                return;
            }
            case 47: {
                PlayerHandler.CancelBuffHandler(a3.readInt(), a4.getPlayer());
                return;
            }
            case 48: {
                PlayerHandler.CancelSkillWithBuff(a3, a4.getPlayer());
                return;
            }
            case 49: {
                PlayerHandler.CancelMech(a3, a4.getPlayer());
                return;
            }
            case 50: {
                PlayerHandler.CancelItemEffect(a3.readInt(), a4.getPlayer());
                return;
            }
            case 51: {
                MapleClient mapleClient = a4;
                PlayerHandler.UseTitle(a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 52: {
                MapleClient mapleClient = a4;
                PlayerHandler.WingChange(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 53: {
                PlayerHandler.DressUpTime(a3, a4);
                return;
            }
            case 54: {
                PlayerHandler.updateSpecialStat(a3, a4);
                return;
            }
            case 55: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.CraftComplete(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 56: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.CraftMake(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 57: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.CraftEffect(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 58: {
                MapleClient mapleClient = a4;
                PlayerHandler.UseChair(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 59: {
                PlayerHandler.SelectExpChair(a3, a4.getPlayer());
                return;
            }
            case 60: {
                MapleClient mapleClient = a4;
                PlayerHandler.GainChairExp(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 61: {
                MapleClient mapleClient = a4;
                PlayerHandler.CancelChair(a3.readShort(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 62: 
            case 63: {
                MapleClient mapleClient = a4;
                PlayerHandler.UseItemEffect(a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 64: {
                PlayerHandler.SkillEffect(a3, a4.getPlayer());
                return;
            }
            case 65: {
                PlayerHandler.QuickSlot(a3, a4.getPlayer());
                return;
            }
            case 66: {
                a4.getPlayer().updateTick(a3.readInt());
                PlayerHandler.DropMeso(a3.readInt(), a4.getPlayer());
                return;
            }
            case 67: {
                MapleClient mapleClient = a4;
                PlayerHandler.ChangeMonsterBookCover(a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 68: {
                PlayerHandler.ChangeKeymap(a3, a4.getPlayer());
                return;
            }
            case 69: {
                LittleEndianAccessor littleEndianAccessor = a3;
                if (a3222) {
                    MapleClient mapleClient = a4;
                    CashShopOperation.LeaveCashShop(littleEndianAccessor, mapleClient, mapleClient.getPlayer());
                    return;
                }
                MapleClient mapleClient = a4;
                PlayerHandler.ChangeMap(littleEndianAccessor, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 70: {
                try {
                    LittleEndianAccessor littleEndianAccessor = a3;
                    littleEndianAccessor.skip(1);
                    MapleClient mapleClient = a4;
                    PlayerHandler.ChangeMapSpecial(littleEndianAccessor.readMapleAsciiString(), mapleClient, mapleClient.getPlayer());
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("gSVFRM\u007f^Y[[ZE\u0011CGC"), exception, " ChangeMapSpecial has Exception, Packet: " + a3.toString());
                    return;
                }
            }
            case 71: {
                try {
                    MapleClient mapleClient = a4;
                    a3.skip(1);
                    PlayerHandler.InnerPortal(a3, mapleClient, mapleClient.getPlayer());
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("{\u0017J\u0002N\tc\u001aE\u001fG\u001eYU_\u0003_"), exception, " InnerPortal has Exception, Packet: " + a3.toString());
                    return;
                }
            }
            case 72: {
                MapleClient mapleClient = a4;
                PlayerHandler.TrockAddMap(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 73: 
            case 74: {
                MapleClient mapleClient = a4;
                PlayersHandler.AntiMacro(a3, mapleClient, mapleClient.getPlayer(), a2 == RecvPacketOpcode.CP_UserAntiMacroItemUseRequest);
                return;
            }
            case 75: {
                MapleClient mapleClient = a4;
                PlayersHandler.OldAntiMacroQuestion(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 76: {
                return;
            }
            case 77: {
                return;
            }
            case 78: {
                PlayerHandler.UserForceAtomCollision(a3, a4);
                return;
            }
            case 79: {
                PlayersHandler.KeepBuffs(a3, a4);
                return;
            }
            case 80: {
                PlayerHandler.ThrowGrenade(a3, a4.getPlayer());
                return;
            }
            case 81: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseMagicWheel(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 82: {
                PlayerHandler.ChangeSkillMacro(a3, a4.getPlayer());
                return;
            }
            case 83: {
                MapleClient mapleClient = a4;
                PlayersHandler.GiveFame(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 84: {
                PlayerHandler.GrenadeEffect(a3, a4);
                return;
            }
            case 85: {
                try {
                    MapleClient mapleClient = a4;
                    PlayersHandler.TransformPlayer(a3, mapleClient, mapleClient.getPlayer());
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("o[^NZEL\u007f^Y[[ZE\u0011CGC"), exception, " TransformPlayer has Exception, Packet: " + a3.toString());
                    return;
                }
            }
            case 86: {
                PlayersHandler.Note(a3, a4.getPlayer());
                return;
            }
            case 87: {
                PlayersHandler.UseDoor(a3, a4.getPlayer());
                return;
            }
            case 88: {
                PlayersHandler.UseMechDoor(a3, a4.getPlayer());
                return;
            }
            case 89: {
                PlayersHandler.HitReactor(a3, a4);
                return;
            }
            case 90: 
            case 91: {
                PlayersHandler.TouchReactor(a3, a2, a4);
                return;
            }
            case 92: {
                a4.getPlayer().setChalkboard(null);
                return;
            }
            case 93: {
                ItemMakerHandler.ItemMaker(a3, a4);
                return;
            }
            case 94: {
                InventoryHandler.ItemSort(a3, a4);
                return;
            }
            case 95: {
                InventoryHandler.ItemGather(a3, a4);
                return;
            }
            case 96: {
                InventoryHandler.ItemMove(a3, a4);
                return;
            }
            case 97: {
                InventoryHandler.MoveBag(a3, a4);
                return;
            }
            case 98: {
                InventoryHandler.SwitchBag(a3, a4);
                return;
            }
            case 99: {
                MapleClient mapleClient = a4;
                InventoryHandler.PlayerPickup(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 100: {
                InventoryHandler.UseCashItem(a3, a4);
                return;
            }
            case 101: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseItem(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 102: {
                InventoryHandler.UseMagnify(a3, a4);
                return;
            }
            case 103: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseScriptedNPCItem(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 104: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseReturnScroll(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 105: {
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                InventoryHandler.UseUpgradeScroll(a3.readShort(), a3.readShort(), (byte)a3.readShort(), a3.readByte(), mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 106: {
                InventoryHandler.UseCarvedSeal(a3, a4);
                return;
            }
            case 107: 
            case 108: {
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                InventoryHandler.UseUpgradeScroll(a3.readShort(), a3.readShort(), (short)(false ? 1 : 0), (byte)(false ? 1 : 0), mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 109: {
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                InventoryHandler.UseUpgradeScroll(a3.readShort(), a3.readShort(), (short)(false ? 1 : 0), (byte)(false ? 1 : 0), mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 110: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseSummonBag(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 111: {
                InventoryHandler.useExpPotion(a3, a4);
                return;
            }
            case 112: {
                SummonHandler.RemoveSummon(a3, a4);
                return;
            }
            case 113: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseTreasureChest(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 114: {
                if (a3.available() < 10L) {
                    return;
                }
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                InventoryHandler.UseSkillBook((byte)a3.readShort(), a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 115: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseCatchItem(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 116: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseMountFood(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 117: {
                MapleClient mapleClient = a4;
                InventoryHandler.UseRewardItem((byte)a3.readShort(), a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 118: {
                MobHandler.HypnotizeDmg(a3, a4);
                return;
            }
            case 119: {
                MobHandler.handleMobNode(a3, a4);
                return;
            }
            case 120: {
                MobHandler.handleDisplayNode(a3, a4);
                return;
            }
            case 121: {
                MobHandler.MobBomb(a3, a4.getPlayer());
                return;
            }
            case 122: {
                MobHandler.MoveMonster(a3, a4);
                return;
            }
            case 123: {
                MobHandler.handleAutoAggro(a3, a4);
                return;
            }
            case 124: {
                MobHandler.handleFriendlyDamage(a3, a4);
                return;
            }
            case 125: {
                MobHandler.MonsterBomb(a3.readInt(), a4.getPlayer());
                return;
            }
            case 126: {
                MobHandler.handleMonsterBomb(a3, a4);
                return;
            }
            case 127: {
                MapleClient mapleClient = a4;
                PlayerHandler.ReIssueMedal(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 128: {
                MapleClient mapleClient = a4;
                InventoryHandler.useScrollGashaponBox(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 129: {
                PlayerHandler.togglePVP(a3, a4);
                return;
            }
            case 130: {
                PlayerHandler.EventTakeDamage(a3, a4);
                return;
            }
            case 131: {
                PlayerHandler.handleMysticDoorWarp(a3, a4);
                return;
            }
            case 132: {
                InventoryHandler.useInnerCirculator(a3, a4);
                return;
            }
            case 133: {
                MapleClient mapleClient = a4;
                InventoryHandler.resetCoreAura(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 134: {
                MapleClient mapleClient = a4;
                InventoryHandler.addCoreAuraExpire(a3.readByte(), mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 135: {
                MapleClient mapleClient = a4;
                InventoryHandler.shuffleCoreAura(a3.readByte(), mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 136: {
                PlayerHandler.closeSilentCrusadeUI(a3, a4);
                return;
            }
            case 137: {
                PlayerHandler.RequestSilentCrusadeReward(a3, a4);
                return;
            }
            case 138: {
                PlayerHandler.useSilentCrusadeShop(a3, a4);
                return;
            }
            case 139: {
                PlayerHandler.OpenAndroidShop(a3, a4);
                return;
            }
            case 140: {
                SummonHandler.SubSummon(a3, a4.getPlayer());
                return;
            }
            case 141: {
                MapleClient mapleClient = a4;
                NPCHandler.QuestAction(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 142: {
                NPCHandler.handleNPCShop(a3, a4);
                return;
            }
            case 143: {
                MapleClient mapleClient = a4;
                NPCHandler.handleNPCTalk(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 144: {
                MapleClient mapleClient = a4;
                PlayerInteractionHandler.HiredMerchantRemoteControl(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 145: {
                NPCHandler.NPCMoreTalk(a3, a4);
                return;
            }
            case 146: {
                NPCHandler.handleNPCAnimation(a3, a4);
                return;
            }
            case 147: {
                MapleClient mapleClient = a4;
                NPCHandler.handleStorage(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 148: {
                if (a4.getPlayer() == null) {
                    return;
                }
                try {
                    if (GameSetConstants.MAPLE_VERSION >= 116 && !a4.getPlayer().CanUseBeans()) {
                        a4.getPlayer().updateTick(a3.readInt());
                    }
                    MapleClient mapleClient = a4;
                    ChatHandler.GeneralChat(a3.readMapleAsciiString(), a3.readByte(), mapleClient, mapleClient.getPlayer());
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("h\u0013J\u000fc\u001aE\u001fG\u001eYU_\u0003_"), exception, " \u89d2\u8272\u8aaa\u8a71\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 149: {
                MapleClient mapleClient = a4;
                ChatHandler.Others(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 150: {
                ChatHandler.WhisperFind(a3, a4);
                return;
            }
            case 151: {
                ChatHandler.Messenger(a3, a4);
                return;
            }
            case 152: {
                MapleClient mapleClient = a4;
                StatsHandling.AutoAssignAP(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 153: {
                MapleClient mapleClient = a4;
                StatsHandling.DistributeAP(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 154: {
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                StatsHandling.DistributeSP(a3.readInt(), mapleClient, mapleClient.getPlayer());
                return;
            }
            case 155: {
                MapleClient mapleClient = a4;
                PlayerInteractionHandler.PlayerInteraction(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 156: {
                GuildHandler.HandleGuild(a3, a4);
                return;
            }
            case 157: {
                MapleClient mapleClient = a4;
                PlayersHandler.UpdateCharInfo(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 158: {
                LittleEndianAccessor littleEndianAccessor = a3;
                littleEndianAccessor.skip(1);
                GuildHandler.denyGuildRequest(littleEndianAccessor.readMapleAsciiString(), a4);
                return;
            }
            case 159: {
                AllianceHandler.HandleAlliance(a3, a4, false);
                return;
            }
            case 160: {
                AllianceHandler.HandleAlliance(a3, a4, true);
                return;
            }
            case 161: {
                BBSHandler.HandleBBS(a3, a4);
                return;
            }
            case 162: {
                PartyHandler.PartyOperation(a3, a4);
                return;
            }
            case 163: {
                PartyHandler.DenyPartyRequest(a3, a4);
                return;
            }
            case 164: {
                PartyHandler.AllowPartyInvite(a3, a4);
                return;
            }
            case 165: {
                BuddyListHandler.BuddyOperationHandler(a3, a4);
                return;
            }
            case 166: {
                UserInterfaceHandler.CygnusSummonNPCRequest(a4);
                return;
            }
            case 167: {
                MapleClient mapleClient = a4;
                CashShopOperation.BuyCashItem(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 168: {
                CashShopOperation.sendGift(a3, a4);
                return;
            }
            case 169: {
                LittleEndianAccessor littleEndianAccessor = a3;
                littleEndianAccessor.skip(2);
                CashShopOperation.CouponCode(littleEndianAccessor.readMapleAsciiString(), a4);
                return;
            }
            case 170: {
                CashShopOperation.sendCashShopUpdate(a4);
                return;
            }
            case 171: {
                MTSOperation.MTSUpdate(MTSStorage.getInstance().getCart(a4.getPlayer().getId()), a4);
                return;
            }
            case 172: {
                MTSOperation.MTSOperation(a3, a4);
                return;
            }
            case 173: {
                ItemMakerHandler.UsePot(a3, a4);
                return;
            }
            case 174: {
                ItemMakerHandler.ClearPot(a3, a4);
                return;
            }
            case 175: {
                ItemMakerHandler.FeedPot(a3, a4);
                return;
            }
            case 176: {
                ItemMakerHandler.CurePot(a3, a4);
                return;
            }
            case 177: {
                ItemMakerHandler.RewardPot(a3, a4);
                return;
            }
            case 178: {
                a3.skip(4);
                SummonHandler.DamageSummon(a3, a4.getPlayer());
                return;
            }
            case 179: {
                SummonHandler.SubSummon(a3, a4.getPlayer());
                return;
            }
            case 180: {
                SummonHandler.MoveSummon(a3, a4.getPlayer());
                return;
            }
            case 181: {
                MapleClient mapleClient = a4;
                SummonHandler.SummonAttack(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 182: {
                SummonHandler.MoveDragon(a3, a4.getPlayer());
                return;
            }
            case 183: {
                SummonHandler.showDragonGlide(a3, a4.getPlayer());
                return;
            }
            case 184: {
                MapleClient mapleClient = a4;
                PetHandler.SpawnPet(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 185: {
                PetHandler.MovePet(a3, a4.getPlayer());
                return;
            }
            case 186: {
                if (a3.available() < 12L) {
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a3;
                int n4 = (int)littleEndianAccessor.readLong();
                a3222 = littleEndianAccessor.readShort();
                a2222 = littleEndianAccessor.readShort();
                if (littleEndianAccessor.available() < (long)a2222) {
                    System.err.println(MonsterDropEntry.ALLATORIxDEMO("\u6509\u5207\u6715\u8662\u7439\u5bc2\u7256\u8a9d\u8a4e\u5332"));
                    return;
                }
                try {
                    PetHandler.PetChat(n4, (short)a3222, a3.readAsciiString(a2222), a4.getPlayer());
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("+N\u000fc\u001aE\u001fG\u001eYU_\u0003_"), exception, " PetChat has Exception, Packet: " + a3.toString());
                    return;
                }
            }
            case 187: {
                MapleClient mapleClient = a4;
                PetHandler.PetCommand(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 188: {
                MapleClient mapleClient = a4;
                PetHandler.PetFood(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 189: {
                MapleClient mapleClient = a4;
                InventoryHandler.PetPickup(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 190: {
                MapleClient mapleClient = a4;
                PetHandler.Pet_AutoPotion(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 191: {
                MapleClient mapleClient = a4;
                PetHandler.PetIgnoreTag(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 192: {
                MapleClient mapleClient = a4;
                a3.skip(4);
                PetHandler.PetFood(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 193: {
                MapleClient mapleClient = a4;
                PlayersHandler.LieDetector(a3, mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 194: {
                MapleClient mapleClient = a4;
                PlayersHandler.LieDetector(a3, mapleClient, mapleClient.getPlayer(), true);
                return;
            }
            case 195: {
                PlayersHandler.LieDetectorResponse(a3, a4);
                return;
            }
            case 196: {
                return;
            }
            case 197: {
                MonsterCarnivalHandler.MonsterCarnival(a3, a4);
                return;
            }
            case 198: {
                PartyHandler.PartySearchStart(a3, a4.getPlayer());
                return;
            }
            case 199: {
                PartyHandler.PartySearchStop(a4.getPlayer());
                return;
            }
            case 200: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.StartHarvest(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 201: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.StopHarvest(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 202: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.MakeExtractor(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 203: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.UseBag(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 204: {
                return;
            }
            case 205: {
                HiredMerchantHandler.UseHiredMerchant(a3, a4);
                return;
            }
            case 206: {
                HiredFishingHandler.UseHiredFishing(a3, a4);
                return;
            }
            case 207: {
                int n5 = a4.getPlayer().getConversation();
                if (n5 == 3) {
                    HiredMerchantHandler.MerchantItemStore(a3, a4);
                    return;
                }
                if (!a4.getPlayer().isOperateStorage()) {
                    HiredFishingHandler.FishingItemStore(a3, a4);
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a3;
                littleEndianAccessor.skip(1);
                MapleClient mapleClient = a4;
                if (littleEndianAccessor.available() < 2L) {
                    mapleClient.getPlayer().setOperateStorage(false);
                    a4.getPlayer().setConversation(0);
                    return;
                }
                MapleClient mapleClient2 = a4;
                mapleClient.getPlayer().getStorage().sendStorage(mapleClient2, mapleClient2.getPlayer().getTalkNpc(), a3.readMapleAsciiString());
                return;
            }
            case 208: {
                return;
            }
            case 209: {
                PlayerHandler.leftKnockBack(a3, a4);
                return;
            }
            case 210: {
                PlayerHandler.snowBall(a3, a4);
                return;
            }
            case 211: {
                PlayersHandler.hitCoconut(a3, a4);
                return;
            }
            case 212: {
                NPCHandler.repair(a3, a4);
                return;
            }
            case 213: {
                NPCHandler.repairAll(a4);
                return;
            }
            case 214: {
                UserInterfaceHandler.InGamePoll(a3, a4);
                return;
            }
            case 215: {
                CashShopOperation.UseXmaxsSurprise(a3, a4);
                return;
            }
            case 216: {
                InventoryHandler.Owl(a3, a4);
                return;
            }
            case 217: {
                InventoryHandler.OwlWarp(a3, a4);
                return;
            }
            case 218: {
                InventoryHandler.OwlMinerva(a3, a4);
                return;
            }
            case 219: {
                NPCHandler.RPSGame(a3, a4);
                return;
            }
            case 220: {
                NPCHandler.UpdateQuest(a3, a4);
                return;
            }
            case 221: {
                NPCHandler.UseItemQuest(a3, a4);
                return;
            }
            case 222: {
                NPCHandler.UseItemQuest2(a3, a4);
                return;
            }
            case 223: {
                NPCHandler.ItemQuestUI(a3, a4);
                return;
            }
            case 224: {
                PlayersHandler.FollowRequest(a3, a4);
                return;
            }
            case 225: {
                PlayersHandler.FollowReply(a3, a4);
                return;
            }
            case 226: {
                PlayersHandler.RingAction(a3, a4);
                return;
            }
            case 227: {
                PlayersHandler.UnlockItem(a3, a4);
                return;
            }
            case 228: {
                PlayersHandler.Solomon(a3, a4);
                return;
            }
            case 229: {
                PlayersHandler.GachExp(a3, a4);
                return;
            }
            case 230: {
                try {
                    FamilyHandler.RequestFamily(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("q^ZV[F\u007f^Y[[ZE\u0011CGC"), exception, " \u8a2a\u554f\u5bb6\u65cf\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 231: {
                try {
                    FamilyHandler.OpenFamily(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("m\u001aF\u0012G\u0002c\u001aE\u001fG\u001eYU_\u0003_"), exception, " \u958b\u555f\u5bb6\u65cf\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 232: {
                try {
                    FamilyHandler.FamilyOperation(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("q^ZV[F\u007f^Y[[ZE\u0011CGC"), exception, " \u5bb6\u65cf\u64cd\u4f5c\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 233: {
                try {
                    FamilyHandler.DeleteJunior(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("m\u001aF\u0012G\u0002c\u001aE\u001fG\u001eYU_\u0003_"), exception, " \u5bb6\u65cfDeleteJunior\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 234: {
                try {
                    FamilyHandler.DeleteSenior(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("q^ZV[F\u007f^Y[[ZE\u0011CGC"), exception, " \u5bb6\u65cfDeleteSenior\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 235: {
                try {
                    FamilyHandler.UseFamily(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("m\u001aF\u0012G\u0002c\u001aE\u001fG\u001eYU_\u0003_"), exception, " \u4f7f\u7528\u5bb6\u65cf\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 236: {
                try {
                    FamilyHandler.FamilyPrecept(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("q^ZV[F\u007f^Y[[ZE\u0011CGC"), exception, " \u5bb6\u65cfPrecept\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 237: {
                try {
                    FamilyHandler.FamilySummon(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(SkilledCommand.ALLATORIxDEMO("m\u001aF\u0012G\u0002c\u001aE\u001fG\u001eYU_\u0003_"), exception, " \u5bb6\u65cf\u53ec\u559a\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 238: {
                if (a3.available() < 5L) {
                    return;
                }
                try {
                    FamilyHandler.AcceptFamily(a3, a4);
                    return;
                }
                catch (Exception exception) {
                    FilePrinter.printError(MonsterDropEntry.ALLATORIxDEMO("q^ZV[F\u007f^Y[[ZE\u0011CGC"), exception, " \u63a5\u53d7\u5bb6\u65cf\u6709\u7570\u5e38,Packet\u8a0a\u606f: \r\n" + a3.toString());
                    return;
                }
            }
            case 27: {
                Object object = "";
                String a3222 = "";
                if (a4.getLastFeedBackTime() - System.currentTimeMillis() > 10000L) {
                    if (ServerConfig.LOG_DC) {
                        FileoutputUtil.logToFile(SkilledCommand.ALLATORIxDEMO("\u0017D\u001cXTO\u001a_\u001a\u0004?hU_\u0003_"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                    }
                    a4.getSession().close();
                    return;
                }
                if (a3.available() > 2L) {
                    a3222 = a3.readMapleAsciiString();
                }
                if (a4 != null) {
                    object = (String)object + "_" + a4.getAccountName();
                }
                if (!"".equals(a3222)) {
                    FileoutputUtil.logToFile(MonsterDropEntry.ALLATORIxDEMO("SXXD\u0010ts~zykhyrzs}v||\u0011CGC"), "\r\n " + FileoutputUtil.NowTime() + " \u932f\u8aa4:(" + (String)object + ")" + a3222);
                }
                a4.setLastFeedBackTime(System.currentTimeMillis());
                return;
            }
            case 25: {
                Object a3222 = "";
                String a2222 = "";
                if (a3.available() > 2L) {
                    a2222 = a3.readMapleAsciiString();
                }
                if (a4 != null) {
                    a3222 = (String)a3222 + "_" + a4.getAccountName();
                }
                if (a2222.isEmpty()) break;
                FileoutputUtil.logToFile(SkilledCommand.ALLATORIxDEMO("G\u0014L\b\u00048g2n5\u007f$n)y4yU_\u0003_"), "\r\n " + FileoutputUtil.NowTime() + " \u932f\u8aa4:(" + (String)a3222 + ")" + a2222);
                return;
            }
            case 26: {
                if (a3.available() < 5L) break;
                LittleEndianAccessor littleEndianAccessor = a3;
                boolean a3222 = littleEndianAccessor.readShort();
                littleEndianAccessor.skip(4);
                short s3 = littleEndianAccessor.readShort();
                int a2222 = s3;
                String string = Integer.toHexString(s3).toUpperCase();
                string = StringUtil.getLeftPaddedStr(string, '0', 4);
                String a2222 = MapleServerHandler.ALLATORIxDEMO(a2222);
                String string2 = "\r\n------------------------ " + FileoutputUtil.CurrentReadable_Time() + " ------------------------\r\n";
                if (a4.getPlayer() != null) {
                    string2 = string2 + "\u5e33\u865f: " + a4.getAccountName() + " \u89d2\u8272: " + a4.getPlayer().getName() + " \u7b49\u7d1a(" + a4.getPlayer().getLevel() + ") \u8077\u696d: " + a4.getPlayer().getJob() + " (" + a4.getPlayer().getJob() + ") \u5730\u5716: " + a4.getPlayer().getMapId() + " BUFF:" + a4.getPlayer().getAllBuffId() + " \r\n";
                }
                String a3222 = a2222 + " [" + string + "] (" + (a3222 - 4) + ")";
                System.err.println("[ErrorCode 38] " + string2 + a3222);
                FileoutputUtil.logToFile(MonsterDropEntry.ALLATORIxDEMO("[PPL\u0018oV\\\\ZC\u0010RMEPE\f\u000f\u0011CGC"), string2 + a3222 + a3.toString(false));
                return;
            }
            case 239: {
                BeanGame.BeansGameAction(a3, a4);
                return;
            }
            case 240: {
                BeanGame.BeansUpdate(a3, a4);
                return;
            }
            case 241: {
                a4.sendPacket(MTSCSPacket.ViciousHammer(0 != 0, 0));
                return;
            }
            case 242: {
                MapleClient mapleClient = a4;
                PetHandler.ChangePetBuff(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 243: {
                PartyHandler.SidekickOperation(a3, a4);
                return;
            }
            case 244: {
                PartyHandler.DenySidekickRequest(a3, a4);
                return;
            }
            case 245: 
            case 246: {
                PlayersHandler.EnterPVP(a3, a4);
                return;
            }
            case 247: {
                PlayersHandler.AttackPVP(a3, a4);
                return;
            }
            case 248: {
                SummonHandler.SummonPVP(a3, a4);
                return;
            }
            case 249: {
                PlayersHandler.RespawnPVP(a3, a4);
                return;
            }
            case 250: {
                PlayersHandler.LeavePVP(a3, a4);
                return;
            }
            case 251: {
                MapleClient mapleClient = a4;
                MobHandler.UseFamiliar(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 252: {
                MapleClient mapleClient = a4;
                MobHandler.SpawnFamiliar(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 253: {
                MapleClient mapleClient = a4;
                MobHandler.RenameFamiliar(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 254: {
                MapleClient mapleClient = a4;
                MobHandler.MoveFamiliar(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 255: {
                MapleClient mapleClient = a4;
                MobHandler.AttackFamiliar(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 256: {
                MapleClient mapleClient = a4;
                MobHandler.TouchFamiliar(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 257: {
                MapleClient mapleClient = a4;
                ItemMakerHandler.UseRecipe(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 258: {
                MapleClient mapleClient = a4;
                PlayerHandler.MoveAndroid(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 259: {
                PlayerHandler.ChangeAndroidEmotion(a3.readInt(), a4.getPlayer());
                return;
            }
            case 260: {
                InventoryHandler.PamSong(a3, a4);
                return;
            }
            case 261: {
                InventoryHandler.UseGashaponTicket(a3, a4);
                return;
            }
            case 262: {
                PlayerHandler.RequestPartyReward(a3, a4);
                return;
            }
            case 263: {
                PlayerHandler.PartyRewardClose(a3, a4);
                return;
            }
            case 264: {
                NPCHandler.RequestRanks(a3, a4, true);
                return;
            }
            case 265: {
                NPCHandler.RequestRanks(a3, a4, false);
                return;
            }
            case 266: {
                CashShopOperation.handleRandomRecommend(a4);
                return;
            }
            case 267: {
                MapleClient mapleClient = a4;
                PlayersHandler.UseAnyWhereDoor(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 268: {
                PlayersHandler.StealSkill(a3, a4);
                return;
            }
            case 269: {
                PlayersHandler.ChooseSkill(a3, a4);
                return;
            }
            case 270: {
                PlayersHandler.viewSkills(a3, a4);
                return;
            }
            case 271: {
                PlayersHandler.useQuestTip(a3, a4);
                return;
            }
            case 272: {
                PlayersHandler.KeyDownMovingArea(a3, a4);
                return;
            }
            case 273: {
                PlayersHandler.useLevelGuide(a3, a4);
                return;
            }
            case 274: {
                PlayersHandler.updateFriendPoints(a3, a4);
                return;
            }
            case 275: {
                PlayerHandler.UpdateLapidieication(a3, a4.getPlayer());
                return;
            }
            case 276: {
                MobHandler.handleMonsterAreaDiseaseSkill(a3, a4);
                return;
            }
            case 277: {
                PlayerHandler.releaseTempestBlades(a3, a4.getPlayer());
                return;
            }
            case 278: {
                a4.getPlayer().updateTick(a3.readInt());
                MapleClient mapleClient = a4;
                StatsHandling.DistributeHyperSP(a3.readInt(), mapleClient, mapleClient.getPlayer(), false);
                return;
            }
            case 279: {
                MapleClient mapleClient = a4;
                StatsHandling.ResetHyperSP(a3, mapleClient, mapleClient.getPlayer());
                return;
            }
            case 280: {
                PlayerHandler.RequestSetOffTrinity(a3, a4.getPlayer());
                return;
            }
            case 281: {
                InventoryHandler.handleSpReset(a3, a4);
                return;
            }
            case 282: {
                InventoryHandler.handleApReset(a3, a4);
                return;
            }
            case 283: {
                InventoryHandler.handleKaiserColorChange(a3, a4);
                return;
            }
            case 284: 
            case 285: 
            case 286: 
            case 287: 
            case 288: 
            case 289: 
            case 290: 
            case 291: 
            case 292: 
            case 293: 
            case 294: 
            case 295: 
            case 296: {
                return;
            }
            default: {
                System.err.println("[\u767c\u73fe\u672a\u8655\u7406\u6578\u64da\u5305] Recv [" + a2.toString() + "]");
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ void channelRead(ChannelHandlerContext a2, Object a3) {
        int n2;
        if (((LittleEndianAccessor)(a3 = new LittleEndianAccessor(new ByteArrayByteStream((byte[])a3)))).available() < 2L) {
            return;
        }
        a2 = (MapleClient)a2.channel().attr(MapleClient.CLIENT_KEY).get();
        short s2 = ((LittleEndianAccessor)a3).readShort();
        if (a2 == null || !((MapleClient)a2).isReceiving()) {
            return;
        }
        if (ShutdownServer.running) {
            return;
        }
        Object[] arrobject = RecvPacketOpcode.values();
        int n3 = arrobject.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            RecvPacketOpcode recvPacketOpcode = arrobject[n2];
            if (recvPacketOpcode.getValue() == s2) {
                if (recvPacketOpcode.NeedsChecking() && !((MapleClient)a2).isLoggedIn()) {
                    return;
                }
                if (((MapleClient)a2).getPlayer() != null && ((MapleClient)a2).isMonitored() && !ALLATORIxDEMO.contains(recvPacketOpcode)) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + ((MapleClient)a2).getPlayer().getName() + "/Monitored.txt", FileoutputUtil.NowTime() + " " + String.valueOf(recvPacketOpcode) + " (" + Integer.toHexString(s2) + ") Handled: \r\n" + ((LittleEndianAccessor)a3).toString() + "\r\n");
                }
                try {
                    Object object;
                    boolean bl;
                    MapleServerHandler a4;
                    if (a4.B == -10) {
                        bl = true;
                        object = a2;
                    } else {
                        bl = false;
                        object = a2;
                    }
                    MapleServerHandler.handlePacket(recvPacketOpcode, (LittleEndianAccessor)a3, (MapleClient)a2, bl, ((MapleClient)object).getcs());
                    if (((MapleClient)a2).getPlayer() == null || World.Find.findChannel(((MapleClient)a2).getPlayer().getName()) != -1) return;
                    switch (recvPacketOpcode) {
                        case HELLO_CHANNEL: 
                        case PLAYER_LOGGEDIN: {
                            return;
                        }
                        case SERVERLIST_REQUEST: 
                        case CHARLIST_REQUEST: 
                        case CHAR_SELECT: {
                            System.err.println("\u5047\u65b7\u7dda\u8907\u88fd\u73a9\u5bb6: " + ((MapleClient)a2).getPlayer().getName());
                            FileoutputUtil.logToFile(SkilledCommand.ALLATORIxDEMO("\u0017D\u001cXTc\u001aH\u0010\u0004\u897c\u88d6T\u506c\u65cc\u7df1\u897c\u88d6\u73d2\u5b9dU_\u0003_"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f: " + ((MapleClient)a2).getAccountName() + "(" + ((MapleClient)a2).getAccID() + ") \u4eba\u7269: " + ((MapleClient)a2).getPlayer().getName() + "(" + recvPacketOpcode + ")\r\n");
                            return;
                        }
                    }
                    if (ChannelServer.containsPlayerTransfer(((MapleClient)a2).getPlayer().getId())) return;
                    if (GameSetConstants.DEBUG_DC) {
                        System.out.println("c.getChannel():" + ((MapleClient)a2).getChannel());
                    }
                    System.err.println("\u5047\u65b7\u7dda\u8907\u88fd\u73a9\u5bb6: " + ((MapleClient)a2).getPlayer().getName() + "(" + recvPacketOpcode + ")");
                    FileoutputUtil.logToFile(MonsterDropEntry.ALLATORIxDEMO("SXXD\u0010\u007f^TT\u0018\u8938\u88ca\u0010\u5070\u6588\u7ded\u7396\u5b81\u0011CGC"), FileoutputUtil.CurrentReadable_Time() + " \u5e33\u865f: " + ((MapleClient)a2).getAccountName() + " \u4eba\u7269: " + ((MapleClient)a2).getPlayer().getName() + "(" + recvPacketOpcode + ")");
                    if (ServerConfig.LOG_DC) {
                        FileoutputUtil.logToFile(SkilledCommand.ALLATORIxDEMO("\u0017D\u001cXTO\u001a_\u001a\u0004?hU_\u0003_"), "\r\n\u4f3a\u670d\u5668\u4e3b\u52d5\u65b7\u958b\u7528\u6236\u7aef\u9023\u63a5\uff0c\u8abf\u7528\u4f4d\u7f6e: " + new Throwable().getStackTrace()[0]);
                    }
                    ((MapleClient)a2).getSession().close();
                    return;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    arrayIndexOutOfBoundsException.printStackTrace();
                    FileoutputUtil.outputFileError("logs/Except/\u5c01\u5305\u9577\u5ea6\u7570\u5e38.txt", arrayIndexOutOfBoundsException);
                    FileoutputUtil.log("logs/Except/\u5c01\u5305\u9577\u5ea6\u7570\u5e38.txt", "Packet: " + s2 + "\r\n" + ((LittleEndianAccessor)a3).toString(true));
                    return;
                }
                catch (Exception exception) {
                    if (((MapleClient)a2).getPlayer() != null && ((MapleClient)a2).getPlayer().isShowErr()) {
                        ((MapleClient)a2).getPlayer().showInfo(MonsterDropEntry.ALLATORIxDEMO("\u654f\u64e5\u5332\u754f\u5e0f"), true, "\u5305\u982d:" + recvPacketOpcode.name() + "(0x" + Integer.toHexString(s2).toUpperCase() + ")");
                    }
                    System.out.println("\u5305\u982d:" + recvPacketOpcode.name() + "(0x" + Integer.toHexString(s2).toUpperCase() + ")");
                    exception.printStackTrace();
                    FileoutputUtil.outputFileError("logs/Except/\u5305\u982d\u932f\u8aa4.txt", exception);
                    FileoutputUtil.log("logs/Except/\u5305\u982d\u932f\u8aa4.txt", "\u5305\u982d:" + recvPacketOpcode.name() + "(0x" + Integer.toHexString(s2).toUpperCase() + ") Packet: " + s2 + "\r\n" + ((LittleEndianAccessor)a3).toString(true));
                }
                return;
            }
            n4 = ++n2;
        }
        if (RecvPacketOpcode.isUnknownRecvOpcode(s2)) return;
        Object object = a3;
        arrobject = ((LittleEndianAccessor)object).read((int)((LittleEndianAccessor)object).available());
        StringBuilder stringBuilder = new StringBuilder("\u767c\u73fe\u672a\u77e5\u7528\u6236\u7aef\u6578\u64da\u5305 - (\u5305\u982d:0x" + Integer.toHexString(s2) + ")");
        System.err.println(stringBuilder.toString() + "\u5305\u9ad4:" + HexTool.toString((byte[])arrobject) + " \u5167\u5bb9:" + HexTool.toStringFromAscii((byte[])arrobject));
        stringBuilder.append(SkilledCommand.ALLATORIxDEMO("\u0011v!")).append(HexTool.toString((byte[])arrobject)).append(MonsterDropEntry.ALLATORIxDEMO("2=")).append(HexTool.toStringFromAscii((byte[])arrobject));
        FileoutputUtil.log("logs/Except/\u6578\u64da\u5305_\u672a\u77e5.txt", stringBuilder.toString());
    }

    public /* synthetic */ void exceptionCaught(ChannelHandlerContext a2, Throwable a3) throws Exception {
    }

    private static class LoggedPacket {
        private /* synthetic */ LittleEndianAccessor a;
        private /* synthetic */ long d;
        private /* synthetic */ RecvPacketOpcode ALLATORIxDEMO;
        private static final /* synthetic */ String E;
        private /* synthetic */ String g;
        private /* synthetic */ String k;
        private /* synthetic */ String B;
        private /* synthetic */ String K;

        public /* synthetic */ String toString() {
            LoggedPacket a2;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = stringBuilder.append(Timer.ALLATORIxDEMO("O)DZ4")).append(a2.g).append(MapleNodes.ALLATORIxDEMO("q.w")).append(a2.k).append('|').append(a2.B).append('|').append(a2.K).append(Timer.ALLATORIxDEMO("I@O4}\rqZ4")).append(a2.d).append(']');
            StringBuilder stringBuilder3 = stringBuilder;
            stringBuilder.append(E);
            stringBuilder3.append(MapleNodes.ALLATORIxDEMO("wA\\4\f")).append(a2.ALLATORIxDEMO.toString()).append(']');
            stringBuilder.append(Timer.ALLATORIxDEMO("@O$u\u0014uZ4")).append(a2.a.toString()).append(']');
            return stringBuilder3.toString();
        }

        public final /* synthetic */ void setInfo(LittleEndianAccessor a2, RecvPacketOpcode a3, String a4, int a5, String a6, String a7) {
            LoggedPacket a8;
            LoggedPacket loggedPacket = a8;
            LoggedPacket loggedPacket2 = a8;
            a8.g = a4;
            loggedPacket2.ALLATORIxDEMO = a3;
            loggedPacket2.a = a2;
            loggedPacket.B = a6;
            loggedPacket.K = a7;
            loggedPacket.d = System.currentTimeMillis();
        }

        public static /* synthetic */ {
            E = System.getProperty(MapleNodes.ALLATORIxDEMO("bE`I _k\\o^oXa^"));
        }

        public /* synthetic */ LoggedPacket(LittleEndianAccessor a2, RecvPacketOpcode a3, String a4, int a5, String a6, String a7) {
            LoggedPacket a8;
            LoggedPacket loggedPacket = a8;
            loggedPacket.setInfo(a2, a3, a4, a5, a6, a7);
        }
    }
}

