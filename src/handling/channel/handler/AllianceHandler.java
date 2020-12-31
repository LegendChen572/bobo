/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.guild.MapleGuild;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;

public class AllianceHandler {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ (3 ^ 5);
        int cfr_ignored_0 = 4 << 4 ^ 4 << 1;
        int n5 = n3;
        int n6 = 2 << 3;
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
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ void HandleAlliance(LittleEndianAccessor a2, MapleClient a3, boolean a4) {
        if (a3.getPlayer().getGuildId() <= 0) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleGuild mapleGuild = World.Guild.getGuild(a3.getPlayer().getGuildId());
        if (mapleGuild == null) {
            a3.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        byte by = a2.readByte();
        if (a3.getPlayer().getGuildRank() != 1 && by != 1) {
            return;
        }
        if (by == 22) {
            a4 = 1;
        }
        int n2 = 0;
        if (mapleGuild.getAllianceId() > 0) {
            n2 = World.Alliance.getAllianceLeader(mapleGuild.getAllianceId());
        }
        if (by != 4 && a4 == 0 ? mapleGuild.getAllianceId() <= 0 || n2 <= 0 : n2 > 0 || mapleGuild.getAllianceId() > 0) {
            return;
        }
        if (a4 != 0) {
            AllianceHandler.DenyInvite(a3, mapleGuild);
            return;
        }
        switch (by) {
            case 1: {
                for (byte[] arrby : World.Alliance.getAllianceInfo(mapleGuild.getAllianceId(), false)) {
                    if (arrby == null) continue;
                    a3.sendPacket(arrby);
                }
                return;
            }
            case 3: {
                int n3 = World.Guild.getGuildLeader(a2.readMapleAsciiString());
                if (n3 <= 0 || a3.getPlayer().getAllianceRank() != 1 || n2 != a3.getPlayer().getId() || (a4 = a3.getChannelServer().getPlayerStorage().getCharacterById(n3)) == null || a4.getGuildId() <= 0 || !World.Alliance.canInvite(mapleGuild.getAllianceId())) return;
                MapleCharacter mapleCharacter = a4;
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.sendAllianceInvite(World.Alliance.getAlliance(mapleGuild.getAllianceId()).getName(), a3.getPlayer()));
                World.Guild.setInvitedId(mapleCharacter.getGuildId(), mapleGuild.getAllianceId());
                return;
            }
            case 4: {
                a4 = World.Guild.getInvitedId(a3.getPlayer().getGuildId());
                if (a4 <= 0) return;
                if (!World.Alliance.addGuildToAlliance(a4, a3.getPlayer().getGuildId())) {
                    a3.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0010ZqQ#F>Fq[2W$F4PqC9Q?\u00140P5]?SqS$]=P\u007f"));
                }
                World.Guild.setInvitedId(a3.getPlayer().getGuildId(), 0);
                return;
            }
            case 2: 
            case 6: {
                int n4;
                if (by == 6 && a2.available() >= 4L) {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    n4 = littleEndianAccessor.readInt();
                    if (littleEndianAccessor.available() >= 4L && mapleGuild.getAllianceId() != a2.readInt()) {
                        return;
                    }
                } else {
                    n4 = a3.getPlayer().getGuildId();
                }
                if (a3.getPlayer().getAllianceRank() > 2 || a3.getPlayer().getAllianceRank() != 1 && a3.getPlayer().getGuildId() != n4) return;
                int n5 = n4;
                if (World.Alliance.removeGuildFromAlliance(mapleGuild.getAllianceId(), n5, a3.getPlayer().getGuildId() != n5)) return;
                a3.getPlayer().dropMessage(5, MapleFamily.ALLATORIxDEMO("\u0001\u0000`\u000b2\u001c/\u001c`\u0001#\r5\u001c%\n`\u0019(\u000b.N2\u000b-\u00016\u0007.\t`\t5\u0007,\nn"));
                return;
            }
            case 7: {
                if (a3.getPlayer().getAllianceRank() != 1 || n2 != a3.getPlayer().getId() || World.Alliance.changeAllianceLeader(mapleGuild.getAllianceId(), a2.readInt())) return;
                a3.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"u?\u00144F#[#\u0014>W2A#Q5\u0014&\\4ZqW9U?S8Z6\u0014=Q0P4F\u007f"));
                return;
            }
            case 8: {
                if (a3.getPlayer().getAllianceRank() != 1 || n2 != a3.getPlayer().getId()) return;
                String[] arrstring = new String[5];
                int n6 = a4 = 0;
                while (true) {
                    if (n6 >= 5) {
                        World.Alliance.updateAllianceRanks(mapleGuild.getAllianceId(), arrstring);
                        return;
                    }
                    arrstring[a4++] = a2.readMapleAsciiString();
                    n6 = a4;
                }
            }
            case 9: {
                if (a3.getPlayer().getAllianceRank() > 2 || World.Alliance.changeAllianceRank(mapleGuild.getAllianceId(), a2.readInt(), a2.readByte())) return;
                a3.getPlayer().dropMessage(5, MapleFamily.ALLATORIxDEMO("/.N%\u001c2\u00012N/\r#\u001b2\u000b$N7\u0006%\u0000`\r(\u000f.\t)\u0000'N2\u000f.\u0005n"));
                return;
            }
            case 10: {
                if (a3.getPlayer().getAllianceRank() > 2) return;
                String string = a2.readMapleAsciiString();
                if (string.length() > 100) {
                    return;
                }
                World.Alliance.updateAllianceNotice(mapleGuild.getAllianceId(), string);
                return;
            }
            default: {
                System.out.println("Unhandled GuildAlliance op: " + by + ", \n" + a2.toString());
            }
        }
    }

    public static final /* synthetic */ void DenyInvite(MapleClient a2, MapleGuild a3) {
        int n2 = World.Guild.getInvitedId(a2.getPlayer().getGuildId());
        if (n2 > 0 && (n2 = World.Alliance.getAllianceLeader(n2)) > 0) {
            MapleCharacter mapleCharacter = a2.getChannelServer().getPlayerStorage().getCharacterById(n2);
            if (mapleCharacter != null) {
                mapleCharacter.dropMessage(5, a3.getName() + " \u516c\u6703\u62d2\u7d55\u52a0\u5165\u806f\u76df!");
            }
            World.Guild.setInvitedId(a2.getPlayer().getGuildId(), 0);
        }
    }

    public /* synthetic */ AllianceHandler() {
        AllianceHandler a2;
    }
}

