/*
 * Decompiled with CFR 0.150.
 */
package client.messages.commands;

import client.messages.CommandProcessor;
import client.messages.CommandProcessorUtil;
import client.messages.LineBotCommandExecute;
import constants.ServerConstants;
import java.util.concurrent.ScheduledFuture;

public class LineBotPlayerCommand {
    private static /* synthetic */ int ALLATORIxDEMO;
    private static /* synthetic */ ScheduledFuture<?> d;
    private static /* synthetic */ Thread a;

    public /* synthetic */ LineBotPlayerCommand() {
        LineBotPlayerCommand a2;
    }

    public static /* synthetic */ {
        a = null;
        d = null;
        ALLATORIxDEMO = 0;
    }

    public static class help
    extends LineBotCommandExecute {
        @Override
        public /* synthetic */ String execute(String[] a2, String a3) {
            return CommandProcessor.dropLineBotPlayerHelp();
        }

        public /* synthetic */ help() {
            help a2;
        }

        @Override
        public /* synthetic */ String getMessage() {
            return ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix() + CommandProcessorUtil.ALLATORIxDEMO("P\u0003T\u0016\u0018K\u0018\u6783\u7733\u6361\u4edc");
        }
    }
}

