/*
 * Decompiled with CFR 0.150.
 */
package constants;

import client.ClientRedirector;
import client.inventory.MaplePet;
import constants.GameSetConstants;
import database.DatabaseException;
import handling.channel.handler.PetHandler;
import handling.world.CharacterIdChannelPair;
import java.net.InetAddress;
import java.net.UnknownHostException;
import server.ServerProperties;
import server.life.MonsterDropEntry;
import tools.LoadPacket;
import tools.packet.MTSCSPacket;

public class ServerConstants {
    public static /* synthetic */ MapleType MAPLE_TYPE;
    public static final /* synthetic */ int MTS_BASE = 100;
    public static final /* synthetic */ int MTS_MESO = 5000;
    public static final /* synthetic */ boolean PollEnabled = false;
    public static final /* synthetic */ String Login_Key = "pWv]xq:SPTCtk^LGnU9F";
    public static /* synthetic */ int[] owlItems;
    public static final /* synthetic */ String CashShop_Key = "a;!%dfb_=*-a123d9{P~";
    public static final /* synthetic */ String Poll_Question = "Are you mudkiz?";
    public static final /* synthetic */ int MIN_MTS = 110;
    public static /* synthetic */ int[] hot_sell;
    public static final /* synthetic */ int CHANNEL_COUNT = 200;
    public static /* synthetic */ boolean TESPIA;
    public static final /* synthetic */ int MTS_TAX = 10;
    public static final /* synthetic */ String[] Poll_Answers;
    public static /* synthetic */ boolean Use_Fixed_IV;

    public /* synthetic */ ServerConstants() {
        ServerConstants a2;
    }

    public static final /* synthetic */ String getHostAddress() {
        InetAddress inetAddress = ServerConstants.ALLATORIxDEMO();
        if (inetAddress == null) {
            return "127.0.0.1";
        }
        return inetAddress.getHostAddress();
    }

    private static /* synthetic */ InetAddress ALLATORIxDEMO() {
        try {
            return InetAddress.getByName(GameSetConstants.IP);
        }
        catch (UnknownHostException unknownHostException) {
            System.err.println("\u7372\u53d6IP\u932f\u8aa4_\u672a\u77e5\u7684IP\u5730\u5740,\u932f\u8aa4\u5167\u5bb9:" + unknownHostException);
            return null;
        }
    }

    public static final /* synthetic */ byte[] getGatewayIP() {
        InetAddress inetAddress = ServerConstants.ALLATORIxDEMO();
        if (inetAddress == null) {
            byte[] arrby = new byte[4];
            arrby[0] = 127;
            arrby[1] = 0;
            arrby[2] = 0;
            arrby[3] = 1;
            return arrby;
        }
        return inetAddress.getAddress();
    }

    public static /* synthetic */ {
        TESPIA = false;
        String[] arrstring = new String[3];
        arrstring[0] = PetHandler.ALLATORIxDEMO("u\u000br\u001a0");
        arrstring[1] = ClientRedirector.ALLATORIxDEMO("A!F0\u0007");
        arrstring[2] = PetHandler.ALLATORIxDEMO("u\u000br\u001a2");
        Poll_Answers = arrstring;
        MAPLE_TYPE = MapleType.\u53f0\u7063;
        Use_Fixed_IV = false;
        int[] arrn = new int[5];
        arrn[0] = 10000007;
        arrn[1] = 0x989688;
        arrn[2] = 0x989689;
        arrn[3] = 10000010;
        arrn[4] = 10000011;
        hot_sell = arrn;
        int[] arrn2 = new int[10];
        arrn2[0] = 1082002;
        arrn2[1] = 2070005;
        arrn2[2] = 2070006;
        arrn2[3] = 1022047;
        arrn2[4] = 1102041;
        arrn2[5] = 2044705;
        arrn2[6] = 2340000;
        arrn2[7] = 2040017;
        arrn2[8] = 1092030;
        arrn2[9] = 2040804;
        owlItems = arrn2;
        ServerConstants.loadSetting();
    }

    public static /* synthetic */ void loadSetting() {
        int n2;
        int n3;
        String[] arrstring = ServerProperties.getProperty(PetHandler.ALLATORIxDEMO("\u001dd\u001cw\u000bs@r\u000bu\u001ah\u0000f\u001d/\r`\u001di\u001di\u0001q@I\u0001u=d\u0002m"), ClientRedirector.ALLATORIxDEMO("u\u0005t\u0005t\u0005t\u0002h\u0015u\u0005t\u0005t\u0005t\rh\u0015u\u0005t\u0005t\u0005t\fh\u0015u\u0005t\u0005t\u0005u\u0005h\u0015u\u0005t\u0005t\u0005u\u0004")).split(PetHandler.ALLATORIxDEMO("-"));
        int[] arrn = new int[arrstring.length];
        int n4 = n3 = 0;
        while (n4 < arrstring.length) {
            int n5 = n3++;
            arrn[n5] = Integer.parseInt(arrstring[n5].replace(" ", ""));
            n4 = n3;
        }
        hot_sell = arrn;
        String[] arrstring2 = ServerProperties.getProperty(ClientRedirector.ALLATORIxDEMO("7P6C!GjF!A0\\*R7\u001b\u000bB(\u001b\fZ0a+E\rA!X"), PetHandler.ALLATORIxDEMO("_1V3^1\\-N3^6^1^4B!\\1Y1^1X-N0^3\\1Z6B!_0^3^5_-N3^5Z6^4B!\\2Z1^1^-N3^5^1_6B!_1W3^2^-N3^5^9^5")).split(ClientRedirector.ALLATORIxDEMO("\u0019"));
        arrn = new int[arrstring2.length];
        int n6 = n2 = 0;
        while (n6 < arrstring2.length) {
            int n7 = n2++;
            arrn[n7] = Integer.parseInt(arrstring2[n7].replace(" ", ""));
            n6 = n2;
        }
        owlItems = arrn;
        TESPIA = ServerProperties.getProperty(PetHandler.ALLATORIxDEMO("\u001dd\u001cw\u000bs@r\u000bu\u001ah\u0000f\u001d/\u001ad\u001dq\u0007`"), TESPIA);
        Use_Fixed_IV = ServerProperties.getProperty(ClientRedirector.ALLATORIxDEMO("7P6C!GjV6L4A"), Use_Fixed_IV);
    }

    public static final class MapleType
    extends Enum<MapleType> {
        public static final /* synthetic */ /* enum */ MapleType \ud55c\uad6d_TEST;
        public static final /* synthetic */ /* enum */ MapleType GLOBAL;
        public static final /* synthetic */ /* enum */ MapleType UNKNOWN;
        public static final /* synthetic */ /* enum */ MapleType \ud55c\uad6d;
        public static final /* synthetic */ /* enum */ MapleType \u65e5\u672c;
        private static final /* synthetic */ MapleType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ MapleType TESPIA;
        public static final /* synthetic */ /* enum */ MapleType \u4e2d\u56fd;
        public static final /* synthetic */ /* enum */ MapleType SEA;
        public /* synthetic */ byte a;
        public static final /* synthetic */ /* enum */ MapleType \u53f0\u7063;
        public final /* synthetic */ String d;
        public static final /* synthetic */ /* enum */ MapleType BRAZIL;

        public static /* synthetic */ MapleType[] values() {
            return (MapleType[])ALLATORIxDEMO.clone();
        }

        public /* synthetic */ String getANSI() {
            MapleType a2;
            return a2.d;
        }

        public static /* synthetic */ MapleType getByType(byte a2) {
            int n2;
            MapleType[] arrmapleType = MapleType.values();
            int n3 = arrmapleType.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleType mapleType = arrmapleType[n2];
                if (mapleType.getType() == a2) {
                    return mapleType;
                }
                n4 = ++n2;
            }
            return UNKNOWN;
        }

        public /* synthetic */ byte getType() {
            MapleType a2;
            if (!TESPIA) {
                return a2.a;
            }
            if (a2 == \ud55c\uad6d || a2 == \ud55c\uad6d_TEST) {
                return 2;
            }
            return 5;
        }

        /*
         * WARNING - void declaration
         */
        private /* synthetic */ MapleType(int n22, String n22) {
            void a2;
            void a3;
            void var2_-1;
            void var1_-1;
            MapleType a4;
            MapleType mapleType = a4;
            mapleType.a = (byte)a3;
            mapleType.d = a2;
        }

        public static /* synthetic */ {
            UNKNOWN = new MapleType(LoadPacket.ALLATORIxDEMO("b]|]xDy"), 0, -1, CharacterIdChannelPair.ALLATORIxDEMO("$\u000e7wI"));
            \ud55c\uad6d = new MapleType(LoadPacket.ALLATORIxDEMO("\ud54f\uad5a"), 1, 1, CharacterIdChannelPair.ALLATORIxDEMO("\u001f$\u0019.\u0011#"));
            \ud55c\uad6d_TEST = new MapleType(LoadPacket.ALLATORIxDEMO("\ud56b\uad7ehGr@c"), 2, 1, CharacterIdChannelPair.ALLATORIxDEMO("\u001f$\u0019.\u0011#"));
            \u65e5\u672c = new MapleType(LoadPacket.ALLATORIxDEMO("\u65f6\u671b"), 3, 3, CharacterIdChannelPair.ALLATORIxDEMO("\"2\u0018<\u0005\u0005;\u0013\""));
            \u4e2d\u56fd = new MapleType(LoadPacket.ALLATORIxDEMO("\u4e3e\u56ca"), 4, 4, CharacterIdChannelPair.ALLATORIxDEMO("6\u0018@bAiA"));
            TESPIA = new MapleType(LoadPacket.ALLATORIxDEMO("Gr@gZv"), 5, 5, CharacterIdChannelPair.ALLATORIxDEMO("$\u000e7wI"));
            \u53f0\u7063 = new MapleType(LoadPacket.ALLATORIxDEMO("\u53e3\u7054"), 6, 6, CharacterIdChannelPair.ALLATORIxDEMO("\u00188\u001dDw9\u0011\"\u0019\""));
            SEA = new MapleType(LoadPacket.ALLATORIxDEMO("dVv"), 7, 7, CharacterIdChannelPair.ALLATORIxDEMO("$\u000e7wI"));
            GLOBAL = new MapleType(LoadPacket.ALLATORIxDEMO("T{\\uR{"), 8, 8, CharacterIdChannelPair.ALLATORIxDEMO("$\u000e7wI"));
            BRAZIL = new MapleType(LoadPacket.ALLATORIxDEMO("QeRmZ{"), 9, 9, CharacterIdChannelPair.ALLATORIxDEMO("$\u000e7wI"));
            MapleType[] arrmapleType = new MapleType[10];
            arrmapleType[0] = UNKNOWN;
            arrmapleType[1] = \ud55c\uad6d;
            arrmapleType[2] = \ud55c\uad6d_TEST;
            arrmapleType[3] = \u65e5\u672c;
            arrmapleType[4] = \u4e2d\u56fd;
            arrmapleType[5] = TESPIA;
            arrmapleType[6] = \u53f0\u7063;
            arrmapleType[7] = SEA;
            arrmapleType[8] = GLOBAL;
            arrmapleType[9] = BRAZIL;
            ALLATORIxDEMO = arrmapleType;
        }

        public /* synthetic */ void setType(int a2) {
            a.a = (byte)a2;
        }

        public static /* synthetic */ MapleType valueOf(String a2) {
            return Enum.valueOf(MapleType.class, a2);
        }
    }

    public static final class CommandType
    extends Enum<CommandType> {
        public static final /* synthetic */ /* enum */ CommandType TRADE;
        private final /* synthetic */ int d;
        private static final /* synthetic */ CommandType[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ CommandType NORMAL;

        public static /* synthetic */ CommandType[] values() {
            return (CommandType[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ CommandType valueOf(String a2) {
            return Enum.valueOf(CommandType.class, a2);
        }

        public /* synthetic */ int getType() {
            CommandType a2;
            return a2.d;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ CommandType(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            CommandType a3;
            a3.d = a2;
        }

        public static /* synthetic */ {
            NORMAL = new CommandType(MaplePet.ALLATORIxDEMO("yseqvp"), 0, 0);
            TRADE = new CommandType(MonsterDropEntry.ALLATORIxDEMO("cmv{r"), 1, 1);
            CommandType[] arrcommandType = new CommandType[2];
            arrcommandType[0] = NORMAL;
            arrcommandType[1] = TRADE;
            ALLATORIxDEMO = arrcommandType;
        }
    }

    public static final class PlayerGMRank
    extends Enum<PlayerGMRank> {
        public static final /* synthetic */ /* enum */ PlayerGMRank \u5de1\u908f\u8005;
        public static final /* synthetic */ /* enum */ PlayerGMRank \u8001\u5be6\u7fd2\u751f;
        public static final /* synthetic */ /* enum */ PlayerGMRank \u65b0\u5be6\u7fd2\u751f;
        public static final /* synthetic */ /* enum */ PlayerGMRank \u8d85\u7d1a\u7ba1\u7406\u54e1;
        private static final /* synthetic */ PlayerGMRank[] ALLATORIxDEMO;
        private final /* synthetic */ int d;
        public static final /* synthetic */ /* enum */ PlayerGMRank \u9818\u5c0e\u8005;
        private final /* synthetic */ char a;
        public static final /* synthetic */ /* enum */ PlayerGMRank \u666e\u901a\u73a9\u5bb6;
        public static final /* synthetic */ /* enum */ PlayerGMRank \u795e;

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ PlayerGMRank(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            PlayerGMRank a3;
            a3.a = (char)(a2 > 0 ? 33 : 64);
            a3.d = a2;
        }

        public /* synthetic */ char getCommandPrefix() {
            PlayerGMRank a2;
            return a2.a;
        }

        public static /* synthetic */ PlayerGMRank valueOf(String a2) {
            return Enum.valueOf(PlayerGMRank.class, a2);
        }

        public static /* synthetic */ PlayerGMRank[] values() {
            return (PlayerGMRank[])ALLATORIxDEMO.clone();
        }

        public /* synthetic */ int getLevel() {
            PlayerGMRank a2;
            return a2.d;
        }

        public static /* synthetic */ {
            \u666e\u901a\u73a9\u5bb6 = new PlayerGMRank(MTSCSPacket.ALLATORIxDEMO("\u664b\u9030\u738c\u5b9c"), 0, 0);
            \u65b0\u5be6\u7fd2\u751f = new PlayerGMRank(DatabaseException.ALLATORIxDEMO("\u65ec\u5bcc\u7f8e\u7535"), 1, 1);
            \u8001\u5be6\u7fd2\u751f = new PlayerGMRank(MTSCSPacket.ALLATORIxDEMO("\u8024\u5bcc\u7ff7\u7535"), 2, 2);
            \u5de1\u908f\u8005 = new PlayerGMRank(DatabaseException.ALLATORIxDEMO("\u5dcb\u90d3\u802f"), 3, 3);
            \u9818\u5c0e\u8005 = new PlayerGMRank(MTSCSPacket.ALLATORIxDEMO("\u9832\u5c2b\u802f"), 4, 4);
            \u8d85\u7d1a\u7ba1\u7406\u54e1 = new PlayerGMRank(DatabaseException.ALLATORIxDEMO("\u8daf\u7d46\u7b8b\u745a\u54cb"), 5, 5);
            \u795e = new PlayerGMRank(MTSCSPacket.ALLATORIxDEMO("\u7974"), 6, 100);
            PlayerGMRank[] arrplayerGMRank = new PlayerGMRank[7];
            arrplayerGMRank[0] = \u666e\u901a\u73a9\u5bb6;
            arrplayerGMRank[1] = \u65b0\u5be6\u7fd2\u751f;
            arrplayerGMRank[2] = \u8001\u5be6\u7fd2\u751f;
            arrplayerGMRank[3] = \u5de1\u908f\u8005;
            arrplayerGMRank[4] = \u9818\u5c0e\u8005;
            arrplayerGMRank[5] = \u8d85\u7d1a\u7ba1\u7406\u54e1;
            arrplayerGMRank[6] = \u795e;
            ALLATORIxDEMO = arrplayerGMRank;
        }
    }
}

