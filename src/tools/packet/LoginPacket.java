/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u83c7\u83c7\u8c37
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package tools.packet;

import client.MapleCharacter;
import client.MapleClient;
import client.MaplePartTimeJob;
import client.messages.commands.player.\u83c7\u83c7\u8c37;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import constants.GameConstants;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import handling.channel.ChannelServer;
import handling.channel.handler.UserInterfaceHandler;
import handling.login.LoginServer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tools.FileTime;
import tools.HexTool;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;
import tools.use.GetMACAddress;

public class LoginPacket {
    public static final /* synthetic */ byte[] getServerStatus(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SERVERSTATUS.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getTempBan(long a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(17);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LOGIN_STATUS.getValue());
        maplePacketLittleEndianWriter3.write(2);
        maplePacketLittleEndianWriter3.write(HexTool.getByteArrayFromHexString(GetMACAddress.ALLATORIxDEMO(")S9S)C)S9S)C)S")));
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.writeLong(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public /* synthetic */ LoginPacket() {
        LoginPacket a2;
    }

    public static final /* synthetic */ byte[] getGenderChanged(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GENDER_SET.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getAccountName());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getLoginWelcome() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Object object = new LinkedList();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SET_MAP_OBJECT_VISIBLE.getValue());
        maplePacketLittleEndianWriter2.write(object == null ? 0 : object.size());
        if (object != null) {
            Object object2 = object = object.iterator();
            while (object2.hasNext()) {
                Pair pair = (Pair)object.next();
                maplePacketLittleEndianWriter.writeMapleAsciiString((String)pair.left);
                maplePacketLittleEndianWriter.write((Integer)pair.right);
                object2 = object;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] addNewCharEntry(MapleCharacter a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.ADD_NEW_CHAR_ENTRY.getValue());
        maplePacketLittleEndianWriter2.write(a3 ? 0 : 1);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        LoginPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter3, a2, false, false);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static final /* synthetic */ byte[] charNameResponse(String a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CHAR_NAME_RESPONSE.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] StrangeDATA() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(16);
        maplePacketLittleEndianWriter2.writeShort(18);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(GetMACAddress.ALLATORIxDEMO("*S!R %*S)')U)Z+\"!U-[!U_T)')R)R)R)V)S)P!R!')S*S!R!Z)Q!R!R)S Z-%-&/U[S)PXT!W*  W-&/T[&-P.V+S*'X\"+S* /T/Z)[\\V [*ZZZ[\"]& V_V*&!W!\"X%\\U('[ZZS &!S_W!U.VZ\"+U U_W\\[ T[T_R! Z!/P []Q+RZW\\ ,[+P]R( XR_! T/WXT!%!W.R(!!!/%Z\" %)R[R.RXV(&ZU/ )QZ'XZ*S![!TZ&\\[\\V  -%_S[R-U[%.R_U T\\!(R\\'Z&[%Z&)Q_!)R)RXT)T/\"*%\\!/W_U_U)Q+ !W(T\\!/!!T+T)Q)P)R)S)R"));
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getGenderNeeded(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CHOOSE_GENDER.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getAccountName());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ byte[] getLoginFailed(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter(16);
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LOGIN_STATUS.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeShort(0);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            if (a2 == 84) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeLong(PacketHelper.getTime(-2L));
                return maplePacketLittleEndianWriter.getPacket();
            }
            if (a2 == 7) {
                maplePacketLittleEndianWriter2.writeZeroBytes(5);
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getWorldSelected(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (SendPacketOpcode.LAST_CONNECT_WORLD.getValue() <= -1) {
            return maplePacketLittleEndianWriter.getPacket();
        }
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LAST_CONNECT_WORLD.getValue());
        maplePacketLittleEndianWriter.writeInt(a2 == 0 ? -3 : a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeZeroBytes(20);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] updatePartTimeJob(MaplePartTimeJob a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PART_TIME.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getCharacterId());
        maplePacketLittleEndianWriter2.write(0);
        PacketHelper.addPartTimeJob(maplePacketLittleEndianWriter2, a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] getServerList(int a2, String a3, int a42, String a52, List<ChannelServer> a6) {
        Iterator<GameConstants.Balloon> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SERVERLIST.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(a2);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(a2);
        }
        maplePacketLittleEndianWriter.writeMapleAsciiString(LoginServer.getServerName());
        List<ChannelServer> list = a6;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter6.write(a42);
        maplePacketLittleEndianWriter6.writeMapleAsciiString(a52);
        maplePacketLittleEndianWriter5.writeShort(100);
        maplePacketLittleEndianWriter5.writeShort(100);
        a42 = list.size();
        int a52 = 0;
        for (ChannelServer channelServer : list) {
            if (channelServer.getChannel() != -10 && channelServer.getChannel() != -20) continue;
            ++a52;
        }
        maplePacketLittleEndianWriter2.write(a42 - a52);
        Map<Integer, Map<Integer, Integer>> map = LoginServer.getLoad();
        for (ChannelServer a42 : a6) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7;
            if (a42.getChannel() == -10 || a42.getChannel() == -20) continue;
            maplePacketLittleEndianWriter2.writeMapleAsciiString(a3 + "-" + a42.getChannel());
            a52 = 1200;
            if (map.containsKey(a42.getWorld()) && ((Map)map.get(a42.getWorld())).containsKey(a42.getChannel())) {
                a52 = (Integer)((Map)map.get(a42.getWorld())).get(a42.getChannel());
            }
            switch (a42.getChannel()) {
                case 1: 
                case 2: 
                case 3: {
                    a52 *= 15;
                    maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                    break;
                }
                default: {
                    a52 *= 8;
                    maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                }
            }
            maplePacketLittleEndianWriter7.writeInt(a52);
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter2.write(a2);
            maplePacketLittleEndianWriter8.write(a42.getChannel() - 1);
            maplePacketLittleEndianWriter8.write(0);
        }
        maplePacketLittleEndianWriter2.writeShort(GameConstants.getBalloons().size());
        Iterator<GameConstants.Balloon> iterator2 = iterator = GameConstants.getBalloons().iterator();
        while (true) {
            if (!iterator2.hasNext()) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeInt(0);
                maplePacketLittleEndianWriter9.write(0);
                maplePacketLittleEndianWriter9.writeZeroBytes(20);
                return maplePacketLittleEndianWriter2.getPacket();
            }
            GameConstants.Balloon a42 = iterator.next();
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
            GameConstants.Balloon balloon = a42;
            maplePacketLittleEndianWriter2.writeShort(balloon.x);
            maplePacketLittleEndianWriter10.writeShort(balloon.y);
            maplePacketLittleEndianWriter10.writeMapleAsciiString(a42.msg);
        }
    }

    public static final /* synthetic */ byte[] getPermBan(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(16);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.LOGIN_STATUS.getValue());
        maplePacketLittleEndianWriter3.writeShort(2);
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(HexTool.getByteArrayFromHexString(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0004`\u0014a\u0005q\u0004`\u0014a\u0005q\u0004a")));
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getPing() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(16);
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PING.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] deleteCharResponse(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.DELETE_CHAR_RESPONSE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getHello(short a2, byte[] a3, byte[] a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(16);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(14);
        maplePacketLittleEndianWriter3.writeShort(a2);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(GameSetConstants.MAPLE_PATCH);
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter2.write(a3);
        maplePacketLittleEndianWriter2.write(6);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ byte[] getAuthSuccessRequest(MapleClient a) {
        v0 = var1_1 = new MaplePacketLittleEndianWriter();
        v1 = var1_1;
        v1.writeShort(SendPacketOpcode.LOGIN_STATUS.getValue());
        v1.write(0);
        v0.writeInt(a.getAccID());
        v0.write(a.getGender());
        if (!GameSetConstants.CLIENT_GM) {
            var1_1.write(0);
        } else {
            var1_1.write(a.isGm() != false ? 1 : 0);
        }
        if (GameSetConstants.MAPLE_VERSION != 75) {
            v2 = var1_1;
            v2.write(0);
            v2.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            v3 = var1_1;
            v4 = var1_1;
            v4.writeInt(0);
            v4.writeInt(30);
            v3.write(0);
            v3.write(a.getCanTalk() == false);
            v5 = var1_1;
            v6 = var1_1;
            v6.writeLong(PacketHelper.getTime(a.getTalkBanCalendar().getTimeInMillis()));
            v6.write(0);
            v5.writeLong(0L);
            var2_2 = 0;
            v5.write(0);
            if (var2_2 == 0) {
                var1_1.writeMapleAsciiString(a.getAccountName());
            }
            v7 = var1_1;
            v8 = var1_1;
            v9 = var1_1;
            v9.writeMapleAsciiString(a.getAccountName());
            v9.write(1);
            v8.write(1);
            v8.write(1);
            v7.write(1);
            v7.writeZeroBytes(24);
            return var1_1.getPacket();
        }
        var1_1.writeMapleAsciiString(a.getAccountName());
        var1_1.writeInt(0);
        if (GameSetConstants.MAPLE_VERSION < 149) {
            var1_1.write(0);
        }
        var1_1.write(0);
        var1_1.write(a.getCanTalk() == false);
        v10 = var1_1;
        var1_1.writeLong(PacketHelper.getTime(a.getTalkBanCalendar().getTimeInMillis()));
        v10.write(0);
        v10.writeLong(0L);
        if (GameSetConstants.MAPLE_VERSION < 143) ** GOTO lbl58
        if (GameSetConstants.MAPLE_VERSION == 143) {
            v11 = var1_1;
            v12 = v11;
            v11.write(0);
        } else {
            var1_1.write(1);
lbl58:
            // 2 sources

            v12 = var1_1;
        }
        v12.writeZeroBytes(24);
        return var1_1.getPacket();
    }

    public static final /* synthetic */ byte[] getEndOfServerList() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SERVERLIST.getValue());
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.writeShort(65535);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(255);
        }
        maplePacketLittleEndianWriter.write(0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.writeZeroBytes(20);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    private static final /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, MapleCharacter a3, boolean a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        PacketHelper.addCharStats(maplePacketLittleEndianWriter, a3);
        PacketHelper.addCharLook(maplePacketLittleEndianWriter, a3, true);
        if (!a5 && GameSetConstants.MAPLE_VERSION != 75) {
            a2.write(0);
        }
        a2.write(a4 ? 1 : 0);
        if (a4) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            MapleCharacter mapleCharacter = a3;
            a2.writeInt(a3.getRank());
            a2.writeInt(mapleCharacter.getRankMove());
            maplePacketLittleEndianWriter2.writeInt(mapleCharacter.getJobRank());
            maplePacketLittleEndianWriter2.writeInt(a3.getJobRankMove());
        }
    }

    public static final /* synthetic */ byte[] secondPwError(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter(3);
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SECONDPW_ERROR.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getCharList(boolean a2, List<MapleCharacter> a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CHARLIST.getValue());
        maplePacketLittleEndianWriter2.write(0);
        if (GameSetConstants.MAPLE_VERSION < 148) {
            maplePacketLittleEndianWriter.writeInt(1000000);
        }
        maplePacketLittleEndianWriter.write(a3.size());
        Object object = a3 = a3.iterator();
        while (object.hasNext()) {
            MapleCharacter mapleCharacter;
            MapleCharacter mapleCharacter2 = mapleCharacter = (MapleCharacter)a3.next();
            LoginPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter, mapleCharacter2, !mapleCharacter2.isGM() && mapleCharacter.getLevel() >= 10, false);
            object = a3;
        }
        maplePacketLittleEndianWriter.write(GameSetConstants.SELECT_CHR_SECPWD ? 0 : 3);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(0);
        maplePacketLittleEndianWriter3.writeInt(a4);
        if (GameSetConstants.MAPLE_VERSION >= 147) {
            a3 = FileTime.GetSystemTime();
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeInt(((FileTime)a3).dwHighDateTime);
            maplePacketLittleEndianWriter4.writeInt(((FileTime)a3).dwLowDateTime);
        }
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            maplePacketLittleEndianWriter.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            maplePacketLittleEndianWriter.writeInt(0);
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter5.writeInt(0);
            maplePacketLittleEndianWriter5.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getLoginAUTH() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.LOGIN_AUTH.getValue());
        String[] arrstring = new String[3];
        arrstring[0] = \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"y0D\u001d[6]?");
        arrstring[1] = GetMACAddress.ALLATORIxDEMO(".x\u0013U\f~\nwR");
        arrstring[2] = \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u001cU!x>S8Zc");
        String[] arrstring2 = arrstring;
        if (GameSetConstants.MAPLE_VERSION >= 151) {
            String[] arrstring3 = new String[5];
            arrstring3[0] = GetMACAddress.ALLATORIxDEMO("T\u0002i/v\u0004p\r");
            arrstring3[1] = \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u001cU!x>S8Z`");
            arrstring3[2] = GetMACAddress.ALLATORIxDEMO(".x\u0013U\f~\nwQ");
            arrstring3[3] = \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u001cU!x>S8Zb");
            arrstring3[4] = GetMACAddress.ALLATORIxDEMO(".x\u0013U\f~\nwW");
            arrstring2 = arrstring3;
        }
        maplePacketLittleEndianWriter2.writeMapleAsciiString(arrstring2[(int)(Math.random() * (double)arrstring2.length)]);
        maplePacketLittleEndianWriter2.writeInt(GameConstants.getCurrentDate());
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
            maplePacketLittleEndianWriter3.write(2);
        } else if (GameSetConstants.MAPLE_VERSION == 151) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(0);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter5.write(1);
            maplePacketLittleEndianWriter5.write(1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getComeSoon(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.COMESOON_OPEN.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final class Server
    extends Enum<Server> {
        public static final /* synthetic */ /* enum */ Server \u83c7\u83c7\u5bf6\u8c9d;
        public static final /* synthetic */ /* enum */ Server \u8774\u8776\u7cbe;
        public static final /* synthetic */ /* enum */ Server \u5df4\u6d1b\u53e4;
        public static final /* synthetic */ /* enum */ Server \u96ea\u5409\u62c9;
        public static final /* synthetic */ /* enum */ Server \u6cf0\u52d2\u718a;
        public static final /* synthetic */ /* enum */ Server \u795e\u7378;
        public final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ Server \u7da0\u6c34\u9748;
        public static final /* synthetic */ /* enum */ Server \u661f\u5149\u7cbe\u9748;
        public static final /* synthetic */ /* enum */ Server \u6d77\u6012\u65af;
        public static final /* synthetic */ /* enum */ Server \u85cd\u5bf6;
        public static final /* synthetic */ /* enum */ Server \u96fb\u64ca\u8c61;
        public static final /* synthetic */ /* enum */ Server \u6728\u5996;
        public static final /* synthetic */ /* enum */ Server \u9be8\u9b5a\u865f;
        public static final /* synthetic */ /* enum */ Server \u4e09\u773c\u7ae0\u9b5a;
        private static final /* synthetic */ Server[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ Server \u706b\u7368\u773c\u7378;
        public static final /* synthetic */ /* enum */ Server \u7dde\u5e36\u80a5\u80a5;
        public static final /* synthetic */ /* enum */ Server \u76ae\u5361\u557e;

        public /* synthetic */ int getId() {
            Server a2;
            return a2.d;
        }

        public static /* synthetic */ Server valueOf(String a2) {
            return Enum.valueOf(Server.class, a2);
        }

        public static /* synthetic */ Server getById(int a2) {
            int n2;
            Server[] arrserver = Server.values();
            int n3 = arrserver.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                Server server = arrserver[n2];
                if (server.getId() == a2) {
                    return server;
                }
                n4 = ++n2;
            }
            return null;
        }

        public static /* synthetic */ Server[] values() {
            return (Server[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ {
            \u96ea\u5409\u62c9 = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u96f3\u5468\u62d0"), 0, 0);
            \u83c7\u83c7\u5bf6\u8c9d = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u83fc\u83f3\u5bcd\u8ca9"), 1, 1);
            \u661f\u5149\u7cbe\u9748 = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u667e\u5150\u7cdf\u9751"), 2, 2);
            \u7dde\u5e36\u80a5\u80a5 = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u7de5\u5e02\u809e\u8091"), 3, 3);
            \u85cd\u5bf6 = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u85ac\u5bef"), 4, 4);
            \u7da0\u6c34\u9748 = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u7d94\u6c0f\u977c"), 5, 5);
            \u4e09\u773c\u7ae0\u9b5a = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u4e68\u7725\u7a81\u9b43"), 6, 6);
            \u6728\u5996 = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u6713\u59a2"), 7, 7);
            \u706b\u7368\u773c\u7378 = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u700a\u7371\u775d\u7361"), 8, 8);
            \u8774\u8776\u7cbe = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u8740\u874d\u7c8a"), 9, 9);
            \u5df4\u6d1b\u53e4 = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u5ded\u6d7a\u53fd"), 10, 10);
            \u6d77\u6012\u65af = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u6d43\u6029\u659b"), 11, 11);
            \u96fb\u64ca\u8c61 = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u96e2\u64ab\u8c78"), 12, 12);
            \u9be8\u9b5a\u865f = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u9bdc\u9b61\u866b"), 13, 13);
            \u76ae\u5361\u557e = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u76b7\u5300\u5567"), 14, 14);
            \u795e\u7378 = new Server(UserInterfaceHandler.ALLATORIxDEMO("\u7965\u734c"), 15, 15);
            \u6cf0\u52d2\u718a = new Server(\u83c7\u83c7\u8c37.ALLATORIxDEMO((String)"\u6ce9\u52b3\u7193"), 16, 16);
            Server[] arrserver = new Server[17];
            arrserver[0] = \u96ea\u5409\u62c9;
            arrserver[1] = \u83c7\u83c7\u5bf6\u8c9d;
            arrserver[2] = \u661f\u5149\u7cbe\u9748;
            arrserver[3] = \u7dde\u5e36\u80a5\u80a5;
            arrserver[4] = \u85cd\u5bf6;
            arrserver[5] = \u7da0\u6c34\u9748;
            arrserver[6] = \u4e09\u773c\u7ae0\u9b5a;
            arrserver[7] = \u6728\u5996;
            arrserver[8] = \u706b\u7368\u773c\u7378;
            arrserver[9] = \u8774\u8776\u7cbe;
            arrserver[10] = \u5df4\u6d1b\u53e4;
            arrserver[11] = \u6d77\u6012\u65af;
            arrserver[12] = \u96fb\u64ca\u8c61;
            arrserver[13] = \u9be8\u9b5a\u865f;
            arrserver[14] = \u76ae\u5361\u557e;
            arrserver[15] = \u795e\u7378;
            arrserver[16] = \u6cf0\u52d2\u718a;
            ALLATORIxDEMO = arrserver;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ Server(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            Server a3;
            a3.d = a2;
        }
    }
}

