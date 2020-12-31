/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleJob;
import client.messages.commands.GM.\u65b0\u661f\u8c37;
import constants.GameSetConstants;
import constants.MapConstants;
import handling.channel.ChannelServer;
import handling.channel.handler.StatsHandling;
import handling.opcodes.PartyOperation;
import handling.opcodes.PartyType;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.sidekick.MapleSidekick;
import server.maps.MapleNodes;
import server.quest.MapleQuest;
import tools.MaplePacketCreator;
import tools.MaplePacketOperation;
import tools.data.LittleEndianAccessor;

public class PartyHandler {
    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void SidekickOperation(LittleEndianAccessor a2, MapleClient a3) {
        switch (a2.readByte()) {
            case 65: {
                MapleCharacter mapleCharacter;
                if (a3.getPlayer().getSidekick() != null || (mapleCharacter = a3.getPlayer().getMap().getCharacterByName(a2.readMapleAsciiString())).getSidekick() != null || !MapleSidekick.checkLevels(a3.getPlayer().getLevel(), mapleCharacter.getLevel())) return;
                MapleClient mapleClient = a3;
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.sidekickInvite(mapleClient.getPlayer()));
                mapleClient.getPlayer().dropMessage(1, "You have sent the sidekick invite to " + mapleCharacter.getName() + ".");
                return;
            }
            case 63: {
                if (a3.getPlayer().getSidekick() == null) return;
                a3.getPlayer().getSidekick().eraseToDB();
                return;
            }
        }
    }

    public /* synthetic */ PartyHandler() {
        PartyHandler a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 4 << 1;
        int cfr_ignored_0 = 5 << 4 ^ 5;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ 3;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void DenyPartyRequest(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readByte();
        int n3 = littleEndianAccessor.readInt();
        if (a3.getPlayer().getParty() == null) {
            MapleParty mapleParty = World.Party.getParty(n3);
            if (mapleParty != null) {
                MapleCharacter mapleCharacter;
                if (GameSetConstants.MAPLE_VERSION >= 139) {
                    n2 -= 2;
                }
                if (GameSetConstants.MAPLE_VERSION >= 143) {
                    n2 -= 2;
                }
                if (n2 == 27) {
                    if (mapleParty.getMembers().size() < 6) {
                        World.Party.updateParty(n3, PartyOperation.JOIN, new MaplePartyCharacter(a3.getPlayer()));
                        MapleClient mapleClient = a3;
                        mapleClient.getPlayer().receivePartyMemberHP();
                        mapleClient.getPlayer().updatePartyMemberHP();
                        return;
                    }
                    a3.sendPacket(MaplePacketCreator.partyStatusMessage(MaplePacketOperation.PartyStatus.\u968a\u4f0d\u6210\u54e1\u5df2\u6eff));
                    return;
                }
                if (n2 == 22 || (mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterById(mapleParty.getLeader().getId())) == null) return;
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.partyStatusMessage(23, a3.getPlayer().getName()));
                return;
            }
            a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u5d89\u62ca\u7d2e\u7d5c\u96f1\u9098\u8ab0\u301a"));
            return;
        }
        a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u4e70\u80b7\u52dd\u512f\u7d39\u96c0\uff71\u56aa\u70c7\u5db8\u7dee\u6743\u7d39\u96c0\u4efb\u3048"));
    }

    public static final /* synthetic */ void PartySearchStart(LittleEndianAccessor a2, MapleCharacter a3) {
        if (a3 == null) {
            return;
        }
        MapleParty mapleParty = a3.getParty();
        if (mapleParty == null || mapleParty.getLeader().getId() != a3.getId()) {
            a3.dropMessage(1, MapConstants.ALLATORIxDEMO("\u60b0\u4e5d\u9746\u96f1\u4f15\u76ff\u9692\u950c\uff19"));
            return;
        }
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.readInt();
        int n3 = littleEndianAccessor.readInt();
        int n4 = littleEndianAccessor.readInt();
        int n5 = littleEndianAccessor.readInt();
        if (n2 > n3) {
            a3.dropMessage(1, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u6461\u5c41\u7b34\u7d50\u7bb9\u5747\u76f9\u4e41\u962d\u9a92\u5187\u4e40\u962d\uff4b\u8ab6\u9187\u65cd\u78f0\u8af0\uff4b"));
            return;
        }
        if (n2 < 0) {
            a3.dropMessage(1, MapConstants.ALLATORIxDEMO("\u7b51\u7d61\u7568\u5e43\uff19"));
            return;
        }
        if (n3 > 200) {
            a3.dropMessage(1, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u7693\u5207\u692e\u4e01\u8c4a\u76ce\u7b34\u7d50\u4e77\u961a\u70c7xMz\u7d67\uff4b"));
            return;
        }
        if (n3 - n2 > 30) {
            a3.dropMessage(1, MapConstants.ALLATORIxDEMO("\u7b32\u7d02\u7bbf\u5715\u677b\u5902\u5394\u8a35\u5be1\u5228H(\u7d61\uff19"));
            return;
        }
        if (n2 > a3.getLevel()) {
            a3.dropMessage(1, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u620a\u89fc\u6456\u5c76\u76ce\u7b34\u7d50\u7bb9\u5747\u4e50\uff46\u5fb8\u9842\u5378\u5461\u8197\u5dbb\u76f9\u7b03\u7d67\u3048"));
            return;
        }
        if (n4 < 2 || n4 > 6) {
            a3.dropMessage(1, MapConstants.ALLATORIxDEMO("\u96f1\u54f9\u677b\u5902\u8f43\u517d\u524b*\u0005.\u4ec1\uff19"));
            return;
        }
        if (mapleParty.getMembers().size() >= n4) {
            a3.dropMessage(1, "\u968a\u54e1\u5df2\u9054\u5230" + n4 + "\u4eba\u4ee5\u4e0a");
            return;
        }
        if (n5 == 0) {
            a3.dropMessage(1, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u8a81\u9005\u648d\u608e\u89cb\u7d39\u625a\u96f7\u4f47\u76f9\u8998\u820f\u803d\u6910\uff4b"));
            return;
        }
        World.PartySearch.startSearch(a3, n2, n3, n4, n5);
    }

    public static /* synthetic */ void AllowPartyInvite(LittleEndianAccessor a2, MapleClient a3) {
        if (a3.getPlayer() != null) {
            if (a2.readByte() > 0) {
                a3.getPlayer().getQuestRemove(MapleQuest.getInstance(122901));
                return;
            }
            a3.getPlayer().getQuestNAdd(MapleQuest.getInstance(122901));
        }
    }

    public static final /* synthetic */ void PartySearchStop(MapleCharacter a2) {
        if (a2 == null) {
            return;
        }
        World.PartySearch.stopSearch(a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void PartyOperation(LittleEndianAccessor a2, MapleClient a3) {
        byte by = a2.readByte();
        PartyType partyType = PartyType.getPartyOperationType(by);
        MapleParty mapleParty = a3.getPlayer().getParty();
        MaplePartyCharacter maplePartyCharacter = new MaplePartyCharacter(a3.getPlayer());
        switch (1.ALLATORIxDEMO[partyType.ordinal()]) {
            case 1: {
                if (a3.getPlayer().getParty() == null) {
                    if (MapleJob.isBeginner(a3.getPlayer().getJob()) && !GameSetConstants.BEBINNER_PARTY) {
                        a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u5266\u5fdb\u807e\u4e15\u8086\u9593\u5524\u9692\u4f76\u301a"));
                        return;
                    }
                    mapleParty = World.Party.createParty(maplePartyCharacter);
                    MapleClient mapleClient = a3;
                    mapleClient.getPlayer().setParty(mapleParty);
                    mapleClient.sendPacket(MaplePacketCreator.partyCreated(mapleParty.getId()));
                    return;
                }
                if (maplePartyCharacter.equals(mapleParty.getLeader()) && mapleParty.getMembers().size() == 1) {
                    a3.sendPacket(MaplePacketCreator.partyCreated(mapleParty.getId()));
                    return;
                }
                a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u4e70\u80b7\u5208\u5eb0\u7d39\u96c0\uff71\u56aa\u70c7\u5db8\u7dee\u6743\u7d39\u96c0\u4efb\u3048"));
                return;
            }
            case 2: {
                if (mapleParty == null) break;
                if (maplePartyCharacter.equals(mapleParty.getLeader())) {
                    World.Party.updateParty(mapleParty.getId(), PartyOperation.DISBAND, maplePartyCharacter);
                    if (a3.getPlayer().getEventInstance() != null) {
                        a3.getPlayer().getEventInstance().disbandParty();
                    }
                    if (a3.getPlayer().getPyramidSubway() != null) {
                        a3.getPlayer().getPyramidSubway().fail(a3.getPlayer());
                    }
                    for (MaplePartyCharacter maplePartyCharacter2 : mapleParty.getMembers()) {
                        MapleCharacter mapleCharacter;
                        int n2 = World.Find.findChannel(maplePartyCharacter2.getName());
                        int n3 = World.Find.findWorld(maplePartyCharacter2.getName());
                        if (n2 <= 0 || (mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(maplePartyCharacter2.getName())) == null || mapleCharacter.getMapId() / 10000 != 92502 && mapleCharacter.getMapId() / 10000 != 92506) continue;
                        mapleCharacter.changeMap(925020001);
                    }
                } else {
                    World.Party.updateParty(mapleParty.getId(), PartyOperation.LEAVE, maplePartyCharacter);
                    if (a3.getPlayer().getEventInstance() != null) {
                        a3.getPlayer().getEventInstance().leftParty(a3.getPlayer());
                    }
                    if (a3.getPlayer().getPyramidSubway() != null) {
                        a3.getPlayer().getPyramidSubway().fail(a3.getPlayer());
                    }
                    if (a3.getPlayer().getMapId() / 10000 == 92502 || a3.getPlayer().getMapId() / 10000 == 92506) {
                        a3.getPlayer().changeMap(925020001);
                    }
                }
                a3.getPlayer().setParty(null);
                return;
            }
            case 3: {
                int n4 = a2.readInt();
                if (a3.getPlayer().getParty() != null) {
                    a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u4e76\u80e5\u52db\u517d\u7d3f\u9692\uff77\u56f8\u70c1\u5dea\u7de8\u6711\u7d3f\u9692\u4efd\u301a"));
                    return;
                }
                mapleParty = World.Party.getParty(n4);
                if (mapleParty == null) {
                    a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u5d8f\u6298\u7d28\u7d0e\u96f7\u90ca\u8ab6\u3048"));
                    return;
                }
                if (mapleParty.getMemberById(a3.getPlayer().getId()) != null) {
                    a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u5d89\u52b8\u511e\u7d5c\u96f1\u301a"));
                    return;
                }
                if (mapleParty.getMembers().size() < 6) {
                    MapleClient mapleClient = a3;
                    World.Party.updateParty(mapleParty.getId(), PartyOperation.JOIN, maplePartyCharacter);
                    mapleClient.getPlayer().receivePartyMemberHP();
                    mapleClient.getPlayer().updatePartyMemberHP();
                    return;
                }
                a3.sendPacket(MaplePacketCreator.partyStatusMessage(MaplePacketOperation.PartyStatus.\u968a\u4f0d\u6210\u54e1\u5df2\u6eff));
                return;
            }
            case 4: {
                MapleCharacter mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterByName(a2.readMapleAsciiString());
                if (mapleCharacter == null) {
                    a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u7693\u5207\u9846\u9019\u511a\u6234\u4e70\u527a\u8a0f\u8139\u820f\u3048"));
                    return;
                }
                if (mapleParty == null) {
                    a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u8ad3\u5133\u9593\u5524\u7d5c\u96f1\u301a"));
                    return;
                }
                if (mapleCharacter.getParty() != null) {
                    a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u5d8f\u7dd9\u52dd\u512f\u510b\u4e9c\u7d39\u3048"));
                    return;
                }
                if (mapleCharacter.getLevel() <= 10 && mapleCharacter.getJob() != 200) {
                    a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("\u754a\u65a4\u5c76\u65a1\u76ff\u7b51\u7d61\u4f56\u65c7)K\u7d02\u4e9e\u4e13\uff77\u6258\u4e9e\u4e15\u8086\u9098\u8ab0\u5c15\u65c2\u301a"));
                    return;
                }
                if (mapleParty.getMembers().size() < 6) {
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.partyInvite(a3.getPlayer(), false));
                    return;
                }
                a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)"\u96c0\u4f70\u625a\u549c\u5db8\u6e82\u3048"));
                return;
            }
            case 5: {
                MaplePartyCharacter maplePartyCharacter3;
                if (maplePartyCharacter == null || !maplePartyCharacter.equals(mapleParty.getLeader()) || (maplePartyCharacter3 = mapleParty.getMemberById(a2.readInt())) == null) break;
                World.Party.updateParty(mapleParty.getId(), PartyOperation.EXPEL, maplePartyCharacter3);
                if (a3.getPlayer().getEventInstance() != null && maplePartyCharacter3.isOnline()) {
                    a3.getPlayer().getEventInstance().disbandParty();
                }
                if (a3.getPlayer().getPyramidSubway() == null || !maplePartyCharacter3.isOnline()) break;
                a3.getPlayer().getPyramidSubway().fail(a3.getPlayer());
                return;
            }
            case 6: {
                MaplePartyCharacter maplePartyCharacter4;
                if (mapleParty == null || (maplePartyCharacter4 = mapleParty.getMemberById(a2.readInt())) == null || !maplePartyCharacter.equals(mapleParty.getLeader())) break;
                World.Party.updateParty(mapleParty.getId(), PartyOperation.CHANGE_LEADER, maplePartyCharacter4);
                return;
            }
            default: {
                System.err.println("Unhandled Party function." + by);
            }
        }
    }

    public static final /* synthetic */ void DenySidekickRequest(LittleEndianAccessor a2, MapleClient a3) {
        LittleEndianAccessor littleEndianAccessor = a2;
        byte by = littleEndianAccessor.readByte();
        int n2 = littleEndianAccessor.readInt();
        if (a3.getPlayer().getSidekick() == null && by == 90) {
            MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(n2);
            if (mapleCharacter != null) {
                if (mapleCharacter.getSidekick() != null || !MapleSidekick.checkLevels(a3.getPlayer().getLevel(), mapleCharacter.getLevel())) {
                    return;
                }
                n2 = World.Sidekick.createSidekick(a3.getPlayer().getId(), mapleCharacter.getId());
                if (n2 <= 0) {
                    a3.getPlayer().dropMessage(5, MapConstants.ALLATORIxDEMO("H\u0017}\u001ak\u001e8\u000fj\u00028\u001a\u007f\u001aq\u00156"));
                    return;
                }
                MapleSidekick mapleSidekick = World.Sidekick.getSidekick(n2);
                MapleCharacter mapleCharacter2 = mapleCharacter;
                MapleClient mapleClient = a3;
                mapleClient.getPlayer().setSidekick(mapleSidekick);
                mapleClient.sendPacket(MaplePacketCreator.updateSidekick(mapleClient.getPlayer(), mapleSidekick, true));
                mapleCharacter2.setSidekick(mapleSidekick);
                mapleCharacter2.getClient().sendPacket(MaplePacketCreator.updateSidekick(mapleCharacter, mapleSidekick, true));
                return;
            }
            a3.getPlayer().dropMessage(5, \u65b0\u661f\u8c37.ALLATORIxDEMO((String)")\"\u0018j\u000e#\u0019/\u0016#\u001e!]3\u0012?]+\u000f/]>\u000f3\u0014$\u001aj\t%] \u0012#\u0013j\u0019%\u00189]$\u0012>]/\u0005#\u000e>"));
        }
    }

    public static final class PartySearchJob
    extends Enum<PartySearchJob> {
        public static final /* synthetic */ /* enum */ PartySearchJob \u6cd5\u5e2b;
        public static final /* synthetic */ /* enum */ PartySearchJob \u9b54\u5c0e\u58eb_\u706b\u6bd2;
        public static final /* synthetic */ /* enum */ PartySearchJob \u8056\u9b42\u528d\u58eb;
        public static final /* synthetic */ /* enum */ PartySearchJob \u9f8d\u9a0e\u58eb;
        public static final /* synthetic */ /* enum */ PartySearchJob \u683c\u9b25\u5bb6;
        public static final /* synthetic */ /* enum */ PartySearchJob \u6e38\u4fe0;
        public static final /* synthetic */ /* enum */ PartySearchJob \u9a0e\u58eb;
        public static final /* synthetic */ /* enum */ PartySearchJob \u795e\u5077;
        public static final /* synthetic */ /* enum */ PartySearchJob \u9583\u96f7\u608d\u5c07;
        private static final /* synthetic */ PartySearchJob[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ PartySearchJob \u796d\u53f8;
        public static final /* synthetic */ /* enum */ PartySearchJob \u5341\u5b57\u8ecd;
        public static final /* synthetic */ /* enum */ PartySearchJob \u76dc\u8cca;
        public static final /* synthetic */ /* enum */ PartySearchJob \u528d\u58eb;
        public static final /* synthetic */ /* enum */ PartySearchJob \u5168\u8077\u696d;
        public static final /* synthetic */ /* enum */ PartySearchJob \u7834\u98a8\u4f7f\u8005;
        public static final /* synthetic */ /* enum */ PartySearchJob \u5f13\u7bad\u624b;
        public static final /* synthetic */ /* enum */ PartySearchJob \u6697\u591c\u884c\u8005;
        public static final /* synthetic */ /* enum */ PartySearchJob \u72d9\u64ca\u624b;
        public static final /* synthetic */ /* enum */ PartySearchJob \u521d\u5fc3\u8005;
        public static final /* synthetic */ /* enum */ PartySearchJob \u6697\u6bba\u8005;
        public static final /* synthetic */ /* enum */ PartySearchJob \u6d77\u76dc;
        public static final /* synthetic */ /* enum */ PartySearchJob \u72c2\u72fc\u52c7\u58eb;
        public static final /* synthetic */ /* enum */ PartySearchJob \u795e\u69cd\u624b;
        public static final /* synthetic */ /* enum */ PartySearchJob \u9b54\u5c0e\u58eb_\u51b0\u96f7;
        public static final /* synthetic */ /* enum */ PartySearchJob \u70c8\u7130\u5deb\u5e2b;
        private /* synthetic */ int d;

        public static /* synthetic */ boolean checkJob(int a2, int a3) {
            return \u5168\u8077\u696d.check(a2) || \u521d\u5fc3\u8005.check(a2) && MapleJob.is\u521d\u5fc3\u8005(a3) && !MapleJob.is\u72c2\u72fc\u52c7\u58eb(a3) || \u72c2\u72fc\u52c7\u58eb.check(a2) && MapleJob.is\u72c2\u72fc\u52c7\u58eb(a3) || \u528d\u58eb.check(a2) && MapleJob.is\u528d\u58eb(a3) && !MapleJob.is\u72c2\u72fc\u52c7\u58eb(a3) || \u5341\u5b57\u8ecd.check(a2) && MapleJob.is\u82f1\u96c4(a3) || \u9a0e\u58eb.check(a2) && MapleJob.is\u8056\u9a0e\u58eb(a3) || \u9a0e\u58eb.check(a2) && MapleJob.is\u9ed1\u9a0e\u58eb(a3) || \u8056\u9b42\u528d\u58eb.check(a2) && MapleJob.is\u8056\u9b42\u528d\u58eb(a3) || \u6cd5\u5e2b.check(a2) && MapleJob.is\u6cd5\u5e2b(a3) || \u9b54\u5c0e\u58eb_\u706b\u6bd2.check(a2) && MapleJob.is\u5927\u9b54\u5c0e\u58eb_\u706b\u6bd2(a3) || \u9b54\u5c0e\u58eb_\u51b0\u96f7.check(a2) && MapleJob.is\u5927\u9b54\u5c0e\u58eb_\u51b0\u96f7(a3) || \u796d\u53f8.check(a2) && MapleJob.is\u4e3b\u6559(a3) || \u70c8\u7130\u5deb\u5e2b.check(a2) && MapleJob.is\u70c8\u7130\u5deb\u5e2b(a3) || \u6d77\u76dc.check(a2) && MapleJob.is\u6d77\u76dc(a3) || \u683c\u9b25\u5bb6.check(a2) && MapleJob.is\u62f3\u9738(a3) || \u795e\u69cd\u624b.check(a2) && MapleJob.is\u69cd\u795e(a3) || \u9583\u96f7\u608d\u5c07.check(a2) && MapleJob.is\u9583\u96f7\u608d\u5c07(a3) || \u76dc\u8cca.check(a2) && MapleJob.is\u76dc\u8cca(a3) || \u6697\u6bba\u8005.check(a2) && MapleJob.is\u591c\u4f7f\u8005(a3) || \u795e\u5077.check(a2) && MapleJob.is\u6697\u5f71\u795e\u5077(a3) || \u6697\u591c\u884c\u8005.check(a2) && MapleJob.is\u6697\u591c\u884c\u8005(a3) || \u5f13\u7bad\u624b.check(a2) && MapleJob.is\u5f13\u7bad\u624b(a3) || \u6e38\u4fe0.check(a2) && MapleJob.is\u7bad\u795e(a3) || \u72d9\u64ca\u624b.check(a2) && MapleJob.is\u795e\u5c04\u624b(a3) || \u7834\u98a8\u4f7f\u8005.check(a2) && MapleJob.is\u7834\u98a8\u4f7f\u8005(a3);
        }

        public static /* synthetic */ {
            \u5168\u8077\u696d = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u5146\u800c\u6943"), 0, 1);
            \u521d\u5fc3\u8005 = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u5231\u5fcd\u8029"), 1, 2);
            \u72c2\u72fc\u52c7\u58eb = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u72b9\u72d2\u52bc\u58c5"), 2, 4);
            \u528d\u58eb = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u5283\u58c7"), 3, 8);
            \u5341\u5b57\u8ecd = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u536f\u5b2c\u8ee3"), 4, 16);
            \u9a0e\u58eb = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u9a00\u58c7"), 5, 32);
            \u9f8d\u9a0e\u58eb = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u9fa3\u9a75\u58c5"), 6, 64);
            \u8056\u9b42\u528d\u58eb = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u8058\u9b6e\u5283\u58c7"), 7, 128);
            \u6cd5\u5e2b = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u6cae\u5e05"), 8, 256);
            \u9b54\u5c0e\u58eb_\u706b\u6bd2 = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u9b5a\u5c22\u58e5s\u7065\u6bfe"), 9, 512);
            \u9b54\u5c0e\u58eb_\u51b0\u96f7 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u9b2f\u5c20\u5890q\u51cb\u96d9"), 10, 1024);
            \u796d\u53f8 = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u7963\u53d4"), 11, 2048);
            \u70c8\u7130\u5deb\u5e2b = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u70b3\u711e\u5d90\u5e05"), 12, 4096);
            \u6d77\u76dc = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u6d79\u76f0"), 13, 8192);
            \u683c\u9b25\u5bb6 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u6812\u9b5e\u5b98"), 14, 16384);
            \u795e\u69cd\u624b = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u7972\u69c3\u6267"), 15, 32768);
            \u9583\u96f7\u608d\u5c07 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u95f8\u96d9\u60f6\u5c29"), 16, 65536);
            \u76dc\u8cca = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u76d2\u8ce6"), 17, 131072);
            \u6697\u6bba\u8005 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u66b9\u6bc1\u802b"), 18, 262144);
            \u795e\u5077 = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u7950\u505b"), 19, 524288);
            \u6697\u591c\u884c\u8005 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u66ec\u5932\u8837\u802b"), 20, 0x100000);
            \u5f13\u7bad\u624b = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u5f3f\u7ba3\u6267"), 21, 0x200000);
            \u6e38\u4fe0 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u6e43\u4fce"), 22, 0x400000);
            \u72d9\u64ca\u624b = new PartySearchJob(MapleNodes.ALLATORIxDEMO("\u72f5\u64c4\u6267"), 23, 0x800000);
            \u7834\u98a8\u4f7f\u8005 = new PartySearchJob(StatsHandling.ALLATORIxDEMO("\u784f\u9886\u4f04\u802b"), 24, 0x1000000);
            PartySearchJob[] arrpartySearchJob = new PartySearchJob[25];
            arrpartySearchJob[0] = \u5168\u8077\u696d;
            arrpartySearchJob[1] = \u521d\u5fc3\u8005;
            arrpartySearchJob[2] = \u72c2\u72fc\u52c7\u58eb;
            arrpartySearchJob[3] = \u528d\u58eb;
            arrpartySearchJob[4] = \u5341\u5b57\u8ecd;
            arrpartySearchJob[5] = \u9a0e\u58eb;
            arrpartySearchJob[6] = \u9f8d\u9a0e\u58eb;
            arrpartySearchJob[7] = \u8056\u9b42\u528d\u58eb;
            arrpartySearchJob[8] = \u6cd5\u5e2b;
            arrpartySearchJob[9] = \u9b54\u5c0e\u58eb_\u706b\u6bd2;
            arrpartySearchJob[10] = \u9b54\u5c0e\u58eb_\u51b0\u96f7;
            arrpartySearchJob[11] = \u796d\u53f8;
            arrpartySearchJob[12] = \u70c8\u7130\u5deb\u5e2b;
            arrpartySearchJob[13] = \u6d77\u76dc;
            arrpartySearchJob[14] = \u683c\u9b25\u5bb6;
            arrpartySearchJob[15] = \u795e\u69cd\u624b;
            arrpartySearchJob[16] = \u9583\u96f7\u608d\u5c07;
            arrpartySearchJob[17] = \u76dc\u8cca;
            arrpartySearchJob[18] = \u6697\u6bba\u8005;
            arrpartySearchJob[19] = \u795e\u5077;
            arrpartySearchJob[20] = \u6697\u591c\u884c\u8005;
            arrpartySearchJob[21] = \u5f13\u7bad\u624b;
            arrpartySearchJob[22] = \u6e38\u4fe0;
            arrpartySearchJob[23] = \u72d9\u64ca\u624b;
            arrpartySearchJob[24] = \u7834\u98a8\u4f7f\u8005;
            ALLATORIxDEMO = arrpartySearchJob;
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ PartySearchJob(int n2) {
            void a2;
            void var2_-1;
            void var1_-1;
            PartySearchJob a3;
            a3.d = a2;
        }

        public static /* synthetic */ PartySearchJob[] values() {
            return (PartySearchJob[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ PartySearchJob valueOf(String a2) {
            return Enum.valueOf(PartySearchJob.class, a2);
        }

        public final /* synthetic */ boolean check(int a2) {
            PartySearchJob a3;
            return (a2 & a3.d) == a3.d;
        }
    }
}

