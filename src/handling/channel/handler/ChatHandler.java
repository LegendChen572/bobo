/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import FuckingHackerToby.cd;
import client.MapleCharacter;
import client.MapleClient;
import client.messages.CommandProcessor;
import constants.GameSetConstants;
import constants.ServerConfig;
import constants.ServerConstants;
import handling.channel.ChannelServer;
import handling.login.LoginInformationProvider;
import handling.login.LoginServer;
import handling.world.MapleMessenger;
import handling.world.MapleMessengerCharacter;
import handling.world.World;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import server.MTSStorage;
import server.maps.MapleFoothold;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;

public class ChatHandler {
    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void Messenger(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient = a3;
        MapleMessenger mapleMessenger = mapleClient.getPlayer().getMessenger();
        byte by = a2.readByte();
        if (!mapleClient.getPlayer().getCanTalk() || !a3.getPlayer().getCanTalk_event()) {
            MapleClient mapleClient2 = a3;
            mapleClient2.getPlayer().dropMessage(5, MapleFoothold.ALLATORIxDEMO("\u76b2\u521d\u55db\u53bd\u5000\u6b32\u4f23\u7578r"));
            mapleClient2.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        switch (by) {
            case 0: {
                int n2;
                if (mapleMessenger != null) break;
                int n3 = a2.readInt();
                if (n3 == 0) {
                    a3.getPlayer().setMessenger(World.Messenger.createMessenger(new MapleMessengerCharacter(a3.getPlayer())));
                    return;
                }
                mapleMessenger = World.Messenger.getMessenger(n3);
                if (mapleMessenger == null || (n2 = mapleMessenger.getLowestPosition()) <= -1 || n2 >= 4) break;
                MapleMessenger mapleMessenger2 = mapleMessenger;
                a3.getPlayer().setMessenger(mapleMessenger2);
                World.Messenger.joinMessenger(mapleMessenger2.getId(), new MapleMessengerCharacter(a3.getPlayer()), a3.getPlayer().getName(), a3.getWorld(), a3.getChannel());
                return;
            }
            case 2: {
                if (mapleMessenger == null) break;
                MapleMessengerCharacter mapleMessengerCharacter = new MapleMessengerCharacter(a3.getPlayer());
                World.Messenger.leaveMessenger(mapleMessenger.getId(), mapleMessengerCharacter);
                a3.getPlayer().setMessenger(null);
                return;
            }
            case 3: {
                if (mapleMessenger == null) break;
                int n4 = mapleMessenger.getLowestPosition();
                if (n4 <= -1 || n4 >= 4) {
                    return;
                }
                String string = a2.readMapleAsciiString();
                MapleCharacter mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterByName(string);
                if (mapleCharacter != null) {
                    if (mapleCharacter.getMessenger() != null) {
                        a3.sendPacket(MaplePacketCreator.messengerNote(string, 5, 0));
                        return;
                    }
                    if (mapleCharacter.isGM() && !a3.getPlayer().isGM()) {
                        a3.sendPacket(MaplePacketCreator.messengerNote(string, 4, 0));
                        return;
                    }
                    a3.sendPacket(MaplePacketCreator.messengerNote(string, 4, 1));
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.messengerInvite(a3.getPlayer().getName(), mapleMessenger.getId()));
                    return;
                }
                MapleClient mapleClient3 = a3;
                if (World.isConnected(string)) {
                    World.Messenger.messengerInvite(mapleClient3.getPlayer().getName(), mapleMessenger.getId(), string, a3.getChannel(), a3.getPlayer().isGM());
                    return;
                }
                mapleClient3.sendPacket(MaplePacketCreator.messengerNote(string, 4, 0));
                return;
            }
            case 5: {
                String string = a2.readMapleAsciiString();
                MapleCharacter mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterByName(string);
                if (mapleCharacter != null) {
                    if (mapleCharacter.getMessenger() == null) break;
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.messengerNote(a3.getPlayer().getName(), 5, 0));
                    return;
                }
                if (a3.getPlayer().isGM()) break;
                World.Messenger.declineChat(string, a3.getPlayer().getName());
                return;
            }
            case 6: {
                if (mapleMessenger == null) break;
                String string = null;
                if (GameSetConstants.MAPLE_VERSION >= 148) {
                    string = a2.readMapleAsciiString();
                }
                String string2 = a2.readMapleAsciiString();
                if (ServerConfig.LOG_CHAT) {
                    FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("p\u000f{\u00133\u802a\u5935OQ\u0005o\u0013y\u000e{\u0005n\u802a\u5935Nh\u0018h"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(MapleFoothold.ALLATORIxDEMO("f"))[0] + " Messenger: " + mapleMessenger.getId() + " " + string2);
                }
                World.Messenger.messengerChat(mapleMessenger.getId(), string, string2, a3.getPlayer().getName());
                return;
            }
            default: {
                System.err.println("Unhandled Messenger operation : " + String.valueOf(by));
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void Others(LittleEndianAccessor a2, MapleClient a3, MapleCharacter a4) {
        int n2;
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = littleEndianAccessor.readByte();
        int n3 = littleEndianAccessor.readByteAsInt();
        if (n3 <= 0) {
            return;
        }
        int[] arrn = new int[n3];
        int n4 = n2 = 0;
        while (n4 < n3) {
            arrn[n2++] = a2.readInt();
            n4 = n2;
        }
        String string = a2.readMapleAsciiString();
        if (a4.getName().equals(MTSStorage.ALLATORIxDEMO("\u800f\u76c3\u5e83\u64b1\u6e4c\u8a7a"))) {
            MapleCharacter mapleCharacter = a4;
            System.out.println("chr:" + mapleCharacter + " chr.getCanTalk():" + a4.getCanTalk() + " chr.getCanTalk_event():" + mapleCharacter.getCanTalk_event());
        }
        if (a4 == null || !a4.getCanTalk() || !a4.getCanTalk_event()) {
            a3.sendPacket(MaplePacketCreator.getItemNotice(MapleFoothold.ALLATORIxDEMO("\u5778\u9045\u505b\u576c\u65e9\u4e51\u80ad\u8af6\u8a21\u305e")));
            return;
        }
        if (CommandProcessor.processCommand(a3, string, ServerConstants.CommandType.NORMAL)) {
            return;
        }
        a4.getCheatTracker().checkMsg();
        switch (by) {
            case 0: {
                if (ServerConfig.LOG_CHAT) {
                    FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("\fs\u0007oO\u8056\u59493\u591d\u53d7\u802a\u5935Nh\u0018h"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(MapleFoothold.ALLATORIxDEMO("f"))[0] + " \u597d\u53cbID: " + Arrays.toString(arrn) + "\u73a9\u5bb6: " + a4.getName() + " \u8aaa\u4e86 :" + string);
                }
                World.Buddy.buddyChat(arrn, a4.getId(), a4.getName(), string);
                return;
            }
            case 1: {
                if (a4.getParty() == null) {
                    return;
                }
                if (ServerConfig.LOG_CHAT) {
                    FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("\fs\u0007oO\u8056\u59493\u96ea\u4f11\u802a\u5935Nh\u0018h"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(MapleFoothold.ALLATORIxDEMO("f"))[0] + " \u968a\u4f0d: " + a4.getParty().getId() + " \u73a9\u5bb6: " + a4.getName() + " \u8aaa\u4e86 :" + string);
                }
                World.Party.partyChat(a4.getParty().getId(), string, a4.getName());
                return;
            }
            case 2: {
                if (a4.getGuildId() <= 0) {
                    return;
                }
                if (ServerConfig.LOG_CHAT) {
                    FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("\fs\u0007oO\u8056\u59493\u510c\u671f\u802a\u5935Nh\u0018h"), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(MapleFoothold.ALLATORIxDEMO("f"))[0] + " \u516c\u6703: " + a4.getGuildId() + " \u73a9\u5bb6: " + a4.getName() + " \u8aaa\u4e86 :" + string);
                }
                World.Guild.guildChat(a4.getGuildId(), a4.getName(), a4.getId(), string);
                return;
            }
            case 3: {
                if (a4.getName().equals(MTSStorage.ALLATORIxDEMO("\u800f\u76c3\u5e83\u64b1\u6e4c\u8a7a"))) {
                    System.out.println("0 " + a4.getGuildId());
                }
                if (a4.getGuildId() <= 0) {
                    return;
                }
                if (ServerConfig.LOG_CHAT) {
                    FileoutputUtil.logToFile(MapleFoothold.ALLATORIxDEMO("<37/\u007f\u8016\u5979s\u803f\u7683\u801a\u5975~((("), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a3.getSession().remoteAddress().toString().split(MTSStorage.ALLATORIxDEMO("&"))[0] + " \u516c\u6703: " + a4.getGuildId() + " \u73a9\u5bb6: " + a4.getName() + " \u8aaa\u4e86 :" + string);
                }
                World.Alliance.allianceChat(a4.getGuildId(), a4.getName(), a4.getId(), string);
                return;
            }
        }
    }

    public /* synthetic */ ChatHandler() {
        ChatHandler a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void WhisperFind(LittleEndianAccessor a, MapleClient a) {
        var2_2 = a.readByte();
        if (GameSetConstants.MAPLE_VERSION > 113) {
            a.readInt();
        }
        if (!a.getPlayer().getCanTalk()) {
            a.sendPacket(MaplePacketCreator.getItemNotice(MTSStorage.ALLATORIxDEMO("\u5748\u9005\u506b\u572c\u65d9\u4e11\u809d\u8ab6\u8a11\u301e")));
            return;
        }
        if (!GameSetConstants.WHISPET_FIND && var2_2 == 5) {
            a.sendPacket(MaplePacketCreator.getItemNotice(MapleFoothold.ALLATORIxDEMO("\u622e\u4ee6\u52cf\u80a1\u5da2\u9580\u95d9}")));
            return;
        }
        switch (var2_2) {
            case 5: 
            case 68: {
                var3_4 = a.readMapleAsciiString();
                var4_6 = a.getChannelServer().getPlayerStorage().getCharacterByName(var3_4);
                if (var4_6 != null) {
                    if (!var4_6.isGM() || a.getPlayer().isGM() && var4_6.isGM()) {
                        a.sendPacket(MaplePacketCreator.getFindReplyWithMap(var4_6.getName(), var4_6.getMap().getId(), var2_2 == 68));
                        return;
                    }
                    a.sendPacket(MaplePacketCreator.getWhisperReply(var3_4, (byte)0));
                    return;
                }
                v0 = var3_4;
                var5_8 = World.Find.findChannel(v0);
                var6_10 = World.Find.findWorld(v0);
                if (var5_8 > 0) {
                    var4_6 = ChannelServer.getInstance(var6_10, var5_8).getPlayerStorage().getCharacterByName(var3_4);
                    if (var4_6 == null) {
                        return;
                    }
                    if (!var4_6.isGM() || a.getPlayer().isGM() && var4_6.isGM()) {
                        a.sendPacket(MaplePacketCreator.getFindReply(var3_4, (byte)var5_8, var2_2 == 68));
                        return;
                    }
                    a.sendPacket(MaplePacketCreator.getWhisperReply(var3_4, (byte)0));
                    return;
                }
                switch (var5_8) {
                    case -10: {
                        a.sendPacket(MaplePacketCreator.getFindReplyWithCS(var3_4, var2_2 == 68));
                        return;
                    }
                    case -20: {
                        a.sendPacket(MaplePacketCreator.getFindReplyWithMTS(var3_4, var2_2 == 68));
                        return;
                    }
                }
                a.sendPacket(MaplePacketCreator.getWhisperReply(var3_4, (byte)0));
                return;
            }
            case 6: {
                if (!a.getPlayer().getCanTalk()) {
                    a.sendPacket(MaplePacketCreator.getItemNotice(MTSStorage.ALLATORIxDEMO("\u5748\u9005\u506b\u572c\u65d9\u4e11\u809d\u8ab6\u8a11\u301e")));
                    return;
                }
                a.getPlayer().getCheatTracker().checkMsg();
                v1 = a;
                var3_5 = v1.readMapleAsciiString();
                var4_7 = v1.readMapleAsciiString();
                v2 = var3_5;
                var5_9 = World.Find.findChannel(v2);
                var6_11 = World.Find.findWorld(v2);
                if (var5_9 <= 0 || a.getPlayer().getWorld() != var6_11) ** GOTO lbl77
                var2_3 = ChannelServer.getInstance(var6_11, var5_9).getPlayerStorage().getCharacterByName(var3_5);
                if (var2_3 == null) {
                    return;
                }
                if (!var2_3.isLineChatNotice()) ** GOTO lbl70
                if (var2_3.getLinePoint() <= 5L && var2_3.getLinePoint() >= 1L) {
                    v3 = var2_3;
                    v3.addLinePoint(-1);
                    cd.l(v3.getName(), "[\u5bc6\u8a9e \u4f86\u81ea-" + a.getPlayer().getName() + "] " + var4_7 + "(\u63d0\u9192\u60a8,\u60a8\u7684Line\u9ede\u6578\u5df2\u5feb\u7528\u76e1!\u5269\u9918 " + var2_3.getLinePoint() + " \u9ede!)");
                    v4 = var2_3;
                } else {
                    if (var2_3.getLinePoint() > 5L) {
                        v5 = var2_3;
                        v5.addLinePoint(-1);
                        cd.l(v5.getName(), "[\u5bc6\u8a9e \u4f86\u81ea-" + a.getPlayer().getName() + "] " + var4_7);
                    }
lbl70:
                    // 4 sources

                    v4 = var2_3;
                }
                v4.getClient().sendPacket(MaplePacketCreator.getWhisper(a.getPlayer().getName(), a.getChannel(), var4_7));
                if (!a.getPlayer().isGM() && var2_3.isGM()) {
                    a.sendPacket(MaplePacketCreator.getWhisperReply(var3_5, (byte)0));
                } else {
                    a.sendPacket(MaplePacketCreator.getWhisperReply(var3_5, (byte)1));
                }
                ** GOTO lbl78
lbl77:
                // 1 sources

                a.sendPacket(MaplePacketCreator.getWhisperReply(var3_5, (byte)0));
lbl78:
                // 3 sources

                if (ServerConfig.LOG_CHAT == false) return;
                FileoutputUtil.logToFile(MapleFoothold.ALLATORIxDEMO("<37/\u007f\u8016\u5979s\u7991\u5b9a\u801a\u5975~((("), "\r\n " + FileoutputUtil.NowTime() + " IP: " + a.getSession().remoteAddress().toString().split(MTSStorage.ALLATORIxDEMO("&"))[0] + " <\u79c1\u5bc6>: " + a.getPlayer().getName() + " \u5bc6\u8a9e " + var3_5 + " \u8aaa\u4e86 :" + var4_7);
                return;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void GeneralChat(String a, byte a, MapleClient a, MapleCharacter a) {
        block23: {
            block21: {
                block22: {
                    if (a.isMonitored()) {
                        FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a.getName() + "/\u8aaa\u8a71.txt", a.getChrInfo("\u5167\u5bb9:" + a));
                    }
                    if (GameSetConstants.isWarnText(a)) {
                        a.setSpeakOutPut(GameSetConstants.getWarnText(a));
                    }
                    if (a.getMap().isSpeakOutPut()) {
                        FileoutputUtil.logToFile("logs/Hack/\u804a\u5929\u95dc\u9375\u5b57\u8f38\u51fa/" + a.getMap().getSpeakOutPut() + "/" + a.getMap().getMapName() + ".txt", a.getChrInfo("\u5167\u5bb9:" + a));
                    }
                    v0 = a;
                    v0.handlemessage(a);
                    if (!v0.canSpeak() && !a.isGM()) {
                        a.sendPacket(MaplePacketCreator.getItemNotice(MapleFoothold.ALLATORIxDEMO("\u60f4\u8afa\u8a2d\u76d4\u9043\u5ef6\u5976\u5fbb}")));
                        return;
                    }
                    if (a == null) return;
                    if (CommandProcessor.processCommand(a, a, ServerConstants.CommandType.NORMAL) != false) return;
                    if (!a.isGM() && a.length() >= 80) {
                        return;
                    }
                    if (!(a.getCanTalk_event() && a.getCanTalk() || a.isStaff())) {
                        a.sendPacket(MaplePacketCreator.getItemNotice(MTSStorage.ALLATORIxDEMO("\u5748\u9005\u506b\u572c\u65d9\u4e11\u809d\u8ab6\u8a11\u301e")));
                        return;
                    }
                    v1 = a;
                    v2 = a;
                    var4_5 = ChatHandler.ChatPacket(v2, a, v2.isHidden());
                    var5_7 = LoginInformationProvider.getInstance().getCurseMsg(a);
                    v3 = a;
                    var6_8 = ChatHandler.ChatPacket(v1, var5_7, v3.isHidden());
                    var7_9 = v3.getMap();
                    if (!v1.isHidden()) break block21;
                    a.getCheatTracker().checkMsg();
                    if (var4_5 != null && a.isGM()) break block22;
                    v4 = a;
                    var7_9.broadcastGMMessage(v4, MaplePacketCreator.getChatText(v4.getId(), a, a.getPlayer().isAdmin(), a), true);
                    v5 = a;
                    break block23;
                }
                if (a != 0) ** GOTO lbl42
                if (a.isHiddenChatCanSee()) {
                    a.getSession().writeAndFlush(var4_5);
                    var7_9.broadcastMessage(a, (byte[])(a.isGM() != false ? var4_5 : var6_8), false);
                    v6 = var7_9;
                } else {
                    var7_9.broadcastGMMessage(a, (byte[])var4_5, true);
lbl42:
                    // 2 sources

                    v6 = var7_9;
                }
                v7 = a;
                v6.broadcastGMMessage(v7, MaplePacketCreator.getChatText(v7.getId(), a, a.getPlayer().isAdmin(), 1), true);
                v5 = a;
                break block23;
            }
            a.getCheatTracker().checkMsg();
            if (var4_5 == null) {
                a.getSession().writeAndFlush((Object)MaplePacketCreator.getChatText(a.getId(), a, a.getPlayer().isAdmin(), a));
                v8 = a;
                if (v8.isGM()) {
                    v9 = a;
                    v10 = a;
                } else {
                    v9 = var5_7;
                    v10 = a;
                }
                var7_9.broadcastMessage(v8, MaplePacketCreator.getChatText(a.getId(), v9, v10.getPlayer().isAdmin(), a), false);
                v5 = a;
            } else {
                if (a == 0) {
                    a.getSession().writeAndFlush(var4_5);
                    var7_9.broadcastMessage(a, (byte[])(a.isGM() != false ? var4_5 : var6_8), false);
                }
                a.getSession().writeAndFlush((Object)MaplePacketCreator.getChatText(a.getId(), a, a.getPlayer().isAdmin(), 1));
                v11 = a;
                if (v11.isGM()) {
                    v12 = a;
                    v13 = a;
                } else {
                    v12 = var5_7;
                    v13 = a;
                }
                var7_9.broadcastMessage(v11, MaplePacketCreator.getChatText(a.getId(), v12, v13.getPlayer().isAdmin(), 1), false);
                v5 = a;
            }
        }
        if (v5.gmLevel() == 0 && !a.isHidden() || a.isGod()) {
            if (ServerConfig.LOG_CHAT) {
                FileoutputUtil.logToFile(MTSStorage.ALLATORIxDEMO("\fs\u0007oO\u8056\u59493\u660e\u9006\u802a\u5935Nh\u0018h"), "\r\n" + FileoutputUtil.NowTime() + " IP: " + a.getSession().remoteAddress().toString().split(MapleFoothold.ALLATORIxDEMO("f"))[0] + " \u300e" + a.getName() + "\u300f \u5730\u5716\u300e" + a.getMapId() + "\u300f\uff1a  " + a);
            }
            a = new StringBuilder("[GM \u5bc6\u8a9e]\u300e" + a.getName() + "\u300f(" + a.getId() + ")\u5730\u5716\u300e" + a.getMapId() + "\u300f\u666e\u804a\uff1a  " + a);
            try {
                var4_5 = LoginServer.getWorldStatic(a.getMap().getWorld()).getChannels().iterator();
                block2: while (var4_5.hasNext()) {
                    for (MapleCharacter v14 : ((ChannelServer)var4_5.next()).getPlayerStorage().getAllCharactersThreadSafe()) {
                        var6_8 = v14;
                        if (v14 == null) continue block2;
                        if (!var6_8.getmsg_Chat()) continue;
                        var6_8.dropMessage(a.toString());
                    }
                }
            }
            catch (ConcurrentModificationException var4_6) {
                // empty catch block
            }
        }
        a.setSpeakTime();
    }

    public static /* synthetic */ byte[] ChatPacket(MapleCharacter a2, String a3) {
        return ChatHandler.ChatPacket(a2, a3, false);
    }

    public static /* synthetic */ byte[] ChatPacket(MapleCharacter a2, String a3, boolean a4) {
        Object object;
        Object object2;
        boolean bl;
        block7: {
            block6: {
                block10: {
                    block9: {
                        block8: {
                            block5: {
                                bl = false;
                                object2 = "";
                                if (!a2.isAdmin()) break block5;
                                if (a4 && a2.isHiddenChatCanSee() || !a4) {
                                    object2 = "<" + GameSetConstants.SERVER_NAME + "\u7ba1\u7406\u54e1> ";
                                }
                                if (!a4) break block6;
                                bl = true;
                                object = object2;
                                break block7;
                            }
                            if (a2.gmLevel() != 4) break block8;
                            if (a4 && a2.isHiddenChatCanSee() || !a4) {
                                object2 = "<" + GameSetConstants.SERVER_NAME + "\u9818\u5c0e\u8005> ";
                            }
                            if (!a4) break block6;
                            bl = true;
                            object = object2;
                            break block7;
                        }
                        if (a2.gmLevel() != 3) break block9;
                        if ((!a4 || !a2.isHiddenChatCanSee()) && a4) break block6;
                        object = object2 = "<" + GameSetConstants.SERVER_NAME + "\u5c0f\u7ba1\u7406\u54e1> ";
                        break block7;
                    }
                    if (a2.gmLevel() != 2) break block10;
                    if ((!a4 || !a2.isHiddenChatCanSee()) && a4) break block6;
                    object = object2 = "<" + GameSetConstants.SERVER_NAME + "\u5de1\u5bdf\u54e1> ";
                    break block7;
                }
                if (a2.gmLevel() == 1 && (a4 && a2.isHiddenChatCanSee() || !a4)) {
                    object2 = "<" + GameSetConstants.SERVER_NAME + "\u65b0\u5be6\u7fd2\u751f> ";
                }
            }
            object = object2;
        }
        if (((String)object).isEmpty() && !bl) {
            return null;
        }
        if (GameSetConstants.SERVER_NAME.equals(MapleFoothold.ALLATORIxDEMO("\u602c\u6020\u8c6b"))) {
            return MaplePacketCreator.getChatText(a2.getId(), a3, true, 0);
        }
        return MaplePacketCreator.yellowChat((String)object2 + a2.getName() + " : " + a3);
    }
}

