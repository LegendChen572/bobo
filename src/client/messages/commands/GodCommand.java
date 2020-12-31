/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands;

import client.MapleCharacter;
import client.MapleClient;
import client.PlayerRandomStream;
import client.SkillFactory;
import client.anticheat.CheatingOffenseEntry;
import client.messages.CommandExecute;
import constants.PiPiConfig;
import constants.ServerConstants;

public class GodCommand {
    public /* synthetic */ GodCommand() {
        GodCommand a2;
    }

    public static /* synthetic */ ServerConstants.PlayerGMRank getPlayerLevelRequired() {
        return ServerConstants.PlayerGMRank.\u795e;
    }

    public static class BanCommand
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u795e.getCommandPrefix() + CheatingOffenseEntry.ALLATORIxDEMO("\u007f]S\u007fRQP]SX\u001d\u0011\u001d\u5c3d\u93ab\u633b\u4ed9");
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            PiPiConfig.setCommandLock(!PiPiConfig.getCommandLock());
            a2.getPlayer().dropMessage("\u6307\u4ee4\u5c01\u9396: " + PiPiConfig.getCommandLock());
            return true;
        }

        public /* synthetic */ BanCommand() {
            BanCommand a2;
        }
    }

    public static class Buff
    extends CommandExecute {
        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u795e.getCommandPrefix() + PlayerRandomStream.ALLATORIxDEMO("\r&)5o~o\u65ee\u6571\u7bf2\u7449\u0011\u001a\u0015\t");
        }

        public /* synthetic */ Buff() {
            Buff a2;
        }

        @Override
        public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
            a3 = a2.getPlayer();
            SkillFactory.getSkill(9001002).getEffect(1).applyTo((MapleCharacter)a3);
            SkillFactory.getSkill(9001003).getEffect(1).applyTo((MapleCharacter)a3);
            SkillFactory.getSkill(9001008).getEffect(1).applyTo((MapleCharacter)a3);
            SkillFactory.getSkill(9001001).getEffect(1).applyTo((MapleCharacter)a3);
            return true;
        }
    }
}

