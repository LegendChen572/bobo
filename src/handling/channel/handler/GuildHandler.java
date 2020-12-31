/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import FuckingHackerToby.Rb;
import client.MapleCharacter;
import client.MapleClient;
import client.SkillFactory;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.world.World;
import handling.world.guild.MapleGuild;
import handling.world.guild.MapleGuildResponse;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import server.MapleStatEffect;
import server.Timer;
import server.maps.MapleNodes;
import tools.FilePrinter;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;
import tools.database.CashShopConvert;

public class GuildHandler {
    private static final /* synthetic */ List<Invited> d;
    private static /* synthetic */ long ALLATORIxDEMO;

    private static /* synthetic */ boolean ALLATORIxDEMO(String a2) {
        if (a2.length() > 15) {
            return false;
        }
        return a2.length() >= 3;
    }

    private static /* synthetic */ void H(MapleCharacter a2) {
        MapleCharacter mapleCharacter = a2;
        a2.getMap().broadcastMessage(mapleCharacter, MaplePacketCreator.removePlayerFromMap(mapleCharacter.getId()), false);
        MapleCharacter mapleCharacter2 = a2;
        mapleCharacter.getMap().broadcastMessage(mapleCharacter2, MaplePacketCreator.spawnPlayerMapobject(mapleCharacter2), false);
    }

    public static /* synthetic */ {
        d = new LinkedList<Invited>();
        ALLATORIxDEMO = System.currentTimeMillis() + 1200000L;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void HandleGuild(LittleEndianAccessor a2, MapleClient a3) {
        Object object;
        Object object2;
        if (System.currentTimeMillis() >= ALLATORIxDEMO) {
            object2 = d.iterator();
            block14: while (true) {
                Object object3 = object2;
                while (object3.hasNext()) {
                    object = (Invited)object2.next();
                    if (System.currentTimeMillis() < object.expiration) continue block14;
                    Iterator<Invited> iterator = object2;
                    object3 = iterator;
                    iterator.remove();
                }
                break;
            }
            ALLATORIxDEMO = System.currentTimeMillis() + 1200000L;
        }
        if ((object2 = GuildOperation.getByValue(a2.readByte())) == null) {
            return;
        }
        switch (1.ALLATORIxDEMO[((Enum)object2).ordinal()]) {
            int n2;
            case 1: {
                int n3 = GameSetConstants.CREATE_GUILD_MESO;
                if (a3.getPlayer().getGuildId() > 0 || a3.getPlayer().getMapId() != 200000301) {
                    a3.getPlayer().dropMessage(1, Rb.ALLATORIxDEMO("\u7145\u6cf6\u5e9e\u7ae8\u5108\u6720i)\u5d96\u7db0\u676d\u514f\u6767\u6235\u4e69\u570b\u8295\u96e7\u4e2f\u6b9c"));
                    return;
                }
                if (a3.getPlayer().getMeso() < n3) {
                    a3.getPlayer().dropMessage(1, "\u4f60\u6c92\u6709\u8db3\u5920\u7684\u6953\u5e63\u5efa\u7acb\u516c\u6703\u3002\u76ee\u524d\u5efa\u7acb\u516c\u6703\u9700\u8981: " + n3 + " \u7684\u6953\u5e63\u3002");
                    return;
                }
                object2 = a2.readMapleAsciiString();
                if (!GuildHandler.ALLATORIxDEMO((String)object2)) {
                    a3.getPlayer().dropMessage(1, Timer.ALLATORIxDEMO("\u9079\u501f\u510c\u6717\u546d\u7a25\u76e4\u9563\u5ec6\u663b\u4e6d\u88bf\u51a6\u8a25\u76e4:"));
                    return;
                }
                int n4 = World.Guild.createGuild(a3.getPlayer().getId(), (String)object2);
                if (n4 != 0) {
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().gainMeso(-n3, true, false, true);
                    mapleClient.getPlayer().setGuildId(n4);
                    mapleClient.getPlayer().setGuildRank((byte)1);
                    mapleClient.getPlayer().saveGuildStatus();
                    World.Guild.setGuildMemberOnline(mapleClient.getPlayer().getMGC(), true, a3.getChannel());
                    mapleClient.sendPacket(MaplePacketCreator.showGuildInfo(mapleClient.getPlayer()));
                    World.Guild.gainGP(mapleClient.getPlayer().getGuildId(), 500);
                    World.Guild.setGuildMemberOnline(mapleClient.getPlayer().getMGC(), true, a3.getChannel());
                    mapleClient.getPlayer().dropMessage(1, Timer.ALLATORIxDEMO("\u600d\u5588\u4f00\u6204\u52ff\u5261\u5e9a\u4e14\u506b\u5178\u6763:"));
                    GuildHandler.H(mapleClient.getPlayer());
                    GuildHandler.ALLATORIxDEMO(mapleClient.getPlayer());
                    return;
                }
                if (GameSetConstants.MAPLE_VERSION >= 134) {
                    a3.getPlayer().dropMessage(1, Rb.ALLATORIxDEMO("\u60cc\u76a7\u5108\u6720\u5469\u5b74\u5d96\u672a\u4ede\u4f5c\u754c\u0002"));
                    return;
                }
                a3.sendPacket(MaplePacketCreator.genericGuildMessage((byte)28));
                return;
            }
            case 2: {
                if (a3.getPlayer().getGuildId() <= 0 || a3.getPlayer().getGuildRank() > 2) {
                    return;
                }
                object = a2.readMapleAsciiString();
                object2 = MapleGuild.sendInvite(a3, (String)object);
                if (object2 != null) {
                    a3.sendPacket(((MapleGuildResponse)((Object)object2)).getPacket());
                    return;
                }
                Invited invited = new Invited((String)object, a3.getPlayer().getGuildId());
                if (d.contains(invited)) return;
                d.add(invited);
                return;
            }
            case 3: {
                if (a3.getPlayer().getGuildId() > 0) {
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                int n5 = littleEndianAccessor.readInt();
                int n6 = littleEndianAccessor.readInt();
                if (n6 != a3.getPlayer().getId()) {
                    return;
                }
                String string = a3.getPlayer().getName().toLowerCase();
                Iterator<Invited> iterator = d.iterator();
                while (iterator.hasNext()) {
                    Invited invited = iterator.next();
                    if (n5 != invited.gid || !string.equals(invited.name)) continue;
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().setGuildId(n5);
                    mapleClient.getPlayer().setGuildRank((byte)5);
                    iterator.remove();
                    if (World.Guild.addGuildMember(mapleClient.getPlayer().getMGC()) == 0) {
                        MapleClient mapleClient2 = a3;
                        mapleClient2.getPlayer().dropMessage(1, Rb.ALLATORIxDEMO("\u4f43\u6097\u89a2\u52c4\u5146\u76e0\u514f\u6767\u5dd1\u7df7\u6edc\u4ee2\r"));
                        mapleClient2.getPlayer().setGuildId(0);
                        return;
                    }
                    MapleClient mapleClient3 = a3;
                    mapleClient3.sendPacket(MaplePacketCreator.showGuildInfo(mapleClient3.getPlayer()));
                    Iterator<byte[]> iterator2 = World.Alliance.getAllianceInfo(World.Guild.getGuild(n5).getAllianceId(), true).iterator();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            MapleClient mapleClient4 = a3;
                            mapleClient4.getPlayer().saveGuildStatus();
                            GuildHandler.H(mapleClient4.getPlayer());
                            GuildHandler.ALLATORIxDEMO(mapleClient4.getPlayer());
                            return;
                        }
                        byte[] arrby = iterator2.next();
                        if (arrby == null) continue;
                        a3.sendPacket(arrby);
                    }
                }
                return;
            }
            case 4: {
                LittleEndianAccessor littleEndianAccessor = a2;
                int n7 = littleEndianAccessor.readInt();
                object2 = littleEndianAccessor.readMapleAsciiString();
                if (n7 != a3.getPlayer().getId() || !((String)object2).equals(a3.getPlayer().getName()) || a3.getPlayer().getGuildId() <= 0) {
                    return;
                }
                if (a3.getPlayer().getMapId() == 990001000) {
                    a3.getPlayer().dropMessage(5, Timer.ALLATORIxDEMO("\u7141\u6cc1\u5748\u7562\u522d\u5724\u5776\u9014\u519a\u5178\u6763\u3016"));
                    return;
                }
                MapleClient mapleClient = a3;
                World.Guild.leaveGuild(mapleClient.getPlayer().getMGC());
                mapleClient.sendPacket(MaplePacketCreator.showGuildInfo(mapleClient.getPlayer()));
                GuildHandler.ALLATORIxDEMO(mapleClient.getPlayer());
                return;
            }
            case 5: {
                LittleEndianAccessor littleEndianAccessor = a2;
                int n8 = littleEndianAccessor.readInt();
                object2 = littleEndianAccessor.readMapleAsciiString();
                MapleCharacter mapleCharacter = null;
                Iterator<Invited> iterator = object2;
                int n9 = World.Find.findChannel((String)((Object)iterator));
                int n10 = World.Find.findWorld((String)((Object)iterator));
                if (n9 >= 1 && (mapleCharacter = ChannelServer.getInstance(n10, n9).getPlayerStorage().getCharacterByName((String)object2)) != null && mapleCharacter.getMapId() == 990001000) {
                    a3.getPlayer().dropMessage(5, "\u7576\u524d\u7121\u6cd5\u9a45\u9664" + mapleCharacter.getName() + "\u516c\u6703\u3002");
                    return;
                }
                if (a3.getPlayer().getGuildRank() > 2 || a3.getPlayer().getGuildId() <= 0) return;
                MapleClient mapleClient = a3;
                World.Guild.expelMember(mapleClient.getPlayer().getMGC(), (String)object2, n8);
                GuildHandler.ALLATORIxDEMO(mapleClient.getPlayer());
                return;
            }
            case 6: {
                if (a3.getPlayer().getGuildId() <= 0 || a3.getPlayer().getGuildRank() != 1) {
                    return;
                }
            }
            object = new String[5];
            int n11 = n2 = 0;
            while (true) {
                if (n11 >= 5) {
                    World.Guild.changeRankTitle(a3.getPlayer().getGuildId(), object);
                    return;
                }
                object[n2++] = a2.readMapleAsciiString();
                n11 = n2;
            }
            case 7: {
                LittleEndianAccessor littleEndianAccessor = a2;
                int n12 = littleEndianAccessor.readInt();
                byte by = littleEndianAccessor.readByte();
                if (by <= 1 || by > 5 || a3.getPlayer().getGuildRank() > 2 || by <= 2 && a3.getPlayer().getGuildRank() != 1 || a3.getPlayer().getGuildId() <= 0) return;
                World.Guild.changeRank(a3.getPlayer().getGuildId(), n12, by);
                return;
            }
            case 8: {
                if (a3.getPlayer().getGuildId() <= 0 || a3.getPlayer().getGuildRank() != 1 || a3.getPlayer().getMapId() != 200000301) {
                    return;
                }
                if (a3.getPlayer().getMeso() < 1000000) {
                    a3.getPlayer().dropMessage(1, Rb.ALLATORIxDEMO("\u4f43\u76e0\u6970\u5e07\u4e2e\u5944\u000f\u7145\u6cf6\u5211\u5ed9\u5108\u6720\u5fd9\u7ac3"));
                    return;
                }
                LittleEndianAccessor littleEndianAccessor = a2;
                short s2 = littleEndianAccessor.readShort();
                byte by = littleEndianAccessor.readByte();
                short s3 = littleEndianAccessor.readShort();
                byte by2 = littleEndianAccessor.readByte();
                MapleClient mapleClient = a3;
                World.Guild.setGuildEmblem(mapleClient.getPlayer().getGuildId(), s2, by, s3, by2);
                mapleClient.getPlayer().gainMeso(-1000000, true, false, true);
                GuildHandler.H(mapleClient.getPlayer());
                return;
            }
            case 9: {
                object = a2.readMapleAsciiString();
                if (object.length() > 100 || a3.getPlayer().getGuildId() <= 0 || a3.getPlayer().getGuildRank() > 2) return;
                World.Guild.setGuildNotice(a3.getPlayer().getGuildId(), (String)object);
                return;
            }
            case 10: {
                object = SkillFactory.getSkill(a2.readInt());
                if (a3.getPlayer().getGuildId() <= 0 || object == null || object.getId() < 91000000) {
                    return;
                }
                int n13 = World.Guild.getSkillLevel(a3.getPlayer().getGuildId(), object.getId()) + 1;
                if (n13 > object.getMaxLevel()) {
                    return;
                }
                MapleStatEffect mapleStatEffect = object.getEffect(n13);
                if (mapleStatEffect.getReqGuildLevel() <= 0 || a3.getPlayer().getMeso() < mapleStatEffect.getPrice()) {
                    return;
                }
                if (!World.Guild.purchaseSkill(a3.getPlayer().getGuildId(), mapleStatEffect.getSourceId(), a3.getPlayer().getName(), a3.getPlayer().getId())) return;
                a3.getPlayer().gainMeso(-mapleStatEffect.getPrice(), true);
                return;
            }
            case 11: {
                object = SkillFactory.getSkill(a2.readInt());
                if (a3.getPlayer().getGuildId() <= 0 || object == null) {
                    return;
                }
                int n14 = World.Guild.getSkillLevel(a3.getPlayer().getGuildId(), object.getId());
                if (n14 <= 0) {
                    return;
                }
                MapleStatEffect mapleStatEffect = object.getEffect(n14);
                if (mapleStatEffect.getReqGuildLevel() < 0 || a3.getPlayer().getMeso() < mapleStatEffect.getExtendPrice()) {
                    return;
                }
                if (!World.Guild.activateSkill(a3.getPlayer().getGuildId(), mapleStatEffect.getSourceId(), a3.getPlayer().getName())) return;
                a3.getPlayer().gainMeso(-mapleStatEffect.getExtendPrice(), true);
                return;
            }
            case 12: {
                int n15 = a2.readInt();
                if (a3.getPlayer().getGuildId() <= 0 || a3.getPlayer().getGuildRank() > 1) {
                    return;
                }
                World.Guild.setGuildLeader(a3.getPlayer().getGuildId(), n15);
                return;
            }
        }
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleCharacter a2) {
        try {
            a2.saveToDB(false, false);
            return;
        }
        catch (Exception exception) {
            FilePrinter.printError(Rb.ALLATORIxDEMO("\u514f\u6767\u76a7\u934b\u8a87JW\u001cW"), exception, Timer.ALLATORIxDEMO("3u\u0016q#|\u0001f$v@q\u0012f\u000ff"));
            System.out.println("\u516c\u6703\u7684\u932f\u8aa4:" + exception);
            return;
        }
    }

    public static final /* synthetic */ void denyGuildRequest(String a2, MapleClient a3) {
        MapleCharacter mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterByName(a2);
        if (mapleCharacter != null) {
            mapleCharacter.getClient().sendPacket(MaplePacketCreator.denyGuildInvitation(a3.getPlayer().getName()));
        }
    }

    public /* synthetic */ GuildHandler() {
        GuildHandler a2;
    }

    private static final class Invited {
        public /* synthetic */ int gid;
        public /* synthetic */ long expiration;
        public /* synthetic */ String name;

        public final /* synthetic */ boolean equals(Object a2) {
            Invited a3;
            if (!(a2 instanceof Invited)) {
                return false;
            }
            Invited invited = (Invited)a2;
            return a3.gid == invited.gid && a3.name.equals(invited.name);
        }

        public /* synthetic */ Invited(String a2, int a3) {
            Invited a4;
            Invited invited = a4;
            invited.name = a2.toLowerCase();
            invited.gid = a3;
            invited.expiration = System.currentTimeMillis() + 3600000L;
        }

        public /* synthetic */ int hashCode() {
            Invited a2;
            int n2 = 3;
            n2 = 67 * n2 + Objects.hashCode(a2.name);
            n2 = 67 * n2 + a2.gid;
            return n2;
        }
    }

    private static final class GuildOperation
    extends Enum<GuildOperation> {
        public static final /* synthetic */ /* enum */ GuildOperation CREATE;
        private static final /* synthetic */ GuildOperation[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ GuildOperation EXPEL;
        public static final /* synthetic */ /* enum */ GuildOperation GUILD_SKILL_PURCHASE;
        public static final /* synthetic */ /* enum */ GuildOperation CHANGE_LEADER;
        public static final /* synthetic */ /* enum */ GuildOperation GUILD_SKILL_ACTIVATION;
        public static final /* synthetic */ /* enum */ GuildOperation ACCEPTED;
        public static final /* synthetic */ /* enum */ GuildOperation LEAVING;
        public static final /* synthetic */ /* enum */ GuildOperation CHANGE_RANK_TITLE;
        public static final /* synthetic */ /* enum */ GuildOperation CHANGE_NOTICE;
        public static final /* synthetic */ /* enum */ GuildOperation INVITE;
        public /* synthetic */ byte d;
        public static final /* synthetic */ /* enum */ GuildOperation CHANGE_EMBLEM;
        public static final /* synthetic */ /* enum */ GuildOperation CHANGE_RANK;

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ GuildOperation(byte by) {
            void a2;
            void var2_-1;
            void var1_-1;
            GuildOperation a3;
            a3.d = a2;
        }

        public static final /* synthetic */ GuildOperation getByValue(byte a2) {
            int n2;
            GuildOperation[] arrguildOperation = GuildOperation.values();
            int n3 = arrguildOperation.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                GuildOperation guildOperation = arrguildOperation[n2];
                if (guildOperation.d == a2) {
                    return guildOperation;
                }
                n4 = ++n2;
            }
            return null;
        }

        public static /* synthetic */ GuildOperation[] values() {
            return (GuildOperation[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ {
            CREATE = new GuildOperation(CashShopConvert.ALLATORIxDEMO(".\u0017(\u00049\u0000"), 0, 2);
            INVITE = new GuildOperation(MapleNodes.ALLATORIxDEMO("GbXeZi"), 1, 5);
            ACCEPTED = new GuildOperation(CashShopConvert.ALLATORIxDEMO(",\u0006.\u0000=\u0011(\u0001"), 2, 6);
            LEAVING = new GuildOperation(MapleNodes.ALLATORIxDEMO("`KmXe@k"), 3, 7);
            EXPEL = new GuildOperation(CashShopConvert.ALLATORIxDEMO("\u00005\u0015(\t"), 4, 8);
            CHANGE_RANK_TITLE = new GuildOperation(MapleNodes.ALLATORIxDEMO("oFm@kKs\\m@gQxGxBi"), 5, GameSetConstants.MAPLE_VERSION >= 134 ? (byte)14 : 13);
            CHANGE_RANK = new GuildOperation(CashShopConvert.ALLATORIxDEMO("\u0006%\u0004#\u0002(\u001a?\u0004#\u000e"), 6, GameSetConstants.MAPLE_VERSION >= 134 ? (byte)15 : 14);
            CHANGE_EMBLEM = new GuildOperation(MapleNodes.ALLATORIxDEMO("oFm@kKsKaL`Ka"), 7, GameSetConstants.MAPLE_VERSION >= 134 ? (byte)16 : 15);
            CHANGE_NOTICE = new GuildOperation(CashShopConvert.ALLATORIxDEMO("\u0006%\u0004#\u0002(\u001a#\n9\f.\u0000"), 8, GameSetConstants.MAPLE_VERSION >= 134 ? (byte)17 : 16);
            GUILD_SKILL_PURCHASE = new GuildOperation(MapleNodes.ALLATORIxDEMO("IyG`Js]gG`Bs^y\\oFm]i"), 9, 29);
            GUILD_SKILL_ACTIVATION = new GuildOperation(CashShopConvert.ALLATORIxDEMO("*\u0010$\t)\u001a>\u000e$\t!\u001a,\u00069\f;\u00049\f\"\u000b"), 10, 30);
            CHANGE_LEADER = new GuildOperation(MapleNodes.ALLATORIxDEMO("oFm@kKsBiOhK~"), 11, 31);
            GuildOperation[] arrguildOperation = new GuildOperation[12];
            arrguildOperation[0] = CREATE;
            arrguildOperation[1] = INVITE;
            arrguildOperation[2] = ACCEPTED;
            arrguildOperation[3] = LEAVING;
            arrguildOperation[4] = EXPEL;
            arrguildOperation[5] = CHANGE_RANK_TITLE;
            arrguildOperation[6] = CHANGE_RANK;
            arrguildOperation[7] = CHANGE_EMBLEM;
            arrguildOperation[8] = CHANGE_NOTICE;
            arrguildOperation[9] = GUILD_SKILL_PURCHASE;
            arrguildOperation[10] = GUILD_SKILL_ACTIVATION;
            arrguildOperation[11] = CHANGE_LEADER;
            ALLATORIxDEMO = arrguildOperation;
        }

        public static /* synthetic */ GuildOperation valueOf(String a2) {
            return Enum.valueOf(GuildOperation.class, a2);
        }
    }
}

