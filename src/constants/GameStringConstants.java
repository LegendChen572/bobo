/*
 * Decompiled with CFR 0.150.
 */
package constants;

import client.messages.commands.InternCommand;
import constants.GameSetConstants;
import tools.Eval;

public class GameStringConstants {
    public static /* synthetic */ String \u5e33\u865f\u5275\u5efa\u904e\u591a;
    public static /* synthetic */ String \u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f;
    public static /* synthetic */ String \u5e33\u865f\u5275\u5efa\u6210\u529f;
    public static /* synthetic */ String \u65b0\u624b\u5275\u5efa\u8a0a\u606f;
    public static /* synthetic */ String \u5e33\u865f\u904e\u9577;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ {
        int n2;
        block8: {
            \u5e33\u865f\u5275\u5efa\u904e\u591a = "\u7121\u6cd5\u8a3b\u518a\u904e\u591a\u7684\u5e33\u865f\u5bc6\u78bc\u5537!";
            \u5e33\u865f\u5275\u5efa\u6210\u529f = "\u5e33\u865f\u5275\u5efa\u6210\u529f,\r\n\u8acb\u91cd\u65b0\u767b\u5165!\r\n\u60a8\u7684\u5bc6\u78bc\u70ba:";
            \u5e33\u865f\u904e\u9577 = "\u60a8\u7684\u5e33\u865f\u9577\u5ea6\u592a\u9577\u4e86\u5537!\r\n\u8acb\u91cd\u65b0\u8f38\u5165.";
            \u65b0\u624b\u5275\u5efa\u8a0a\u606f = "\u6b61\u8fce\u4f86\u5230 " + GameSetConstants.SERVER_NAME + "\u3002\r\n\u65b0\u624b\u6280\u80fd\u8a18\u5f97\u5728\u4e00\u8f49\u4e4b\u524d\u9ede\u5b8c\uff01\r\n\u8acb\u8a18\u5f97\u8d8a\u7b49\u8f49\u8077\u6703\u55aa\u5931\u6280\u80fd\u9ede\u6578\uff01\r\n\u5e0c\u671b\u4f60\u6703\u559c\u6b61\u9019\u88e1\u3002";
            \u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f = "\u4f3a\u670d\u5668\u5373\u5c07\u95dc\u9589\u6216\u8005\u6b63\u5728\u6e96\u5099\uff0c\u6240\u4ee5\u7121\u6cd5\u6b63\u5e38\u4f7f\u7528\u7cbe\u9748\u5546\u4eba\u3001\u500b\u4eba\u5546\u5e97\u3001\u5c0f\u904a\u6232\u3002";
            String string = GameSetConstants.SERVER_NAME;
            int n3 = -1;
            switch (string.hashCode()) {
                case 981058402: {
                    if (!string.equals(Eval.ALLATORIxDEMO("\u7df2\u595e\u5276\u4eda"))) break;
                    n2 = n3 = 0;
                    break block8;
                }
                case 24526391: {
                    if (!string.equals(InternCommand.ALLATORIxDEMO("\u6075\u6041\u8c32"))) break;
                    n3 = 1;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                \u5e33\u865f\u5275\u5efa\u904e\u591a = "\u5982\u986f\u793a\u7121\u6cd5\u8a3b\u518a\uff0c\u8acb\u91cd\u65b0\u8f38\u5165\u4e00\u6b21\u3002\n\u6709\u984d\u5916\u9700\u6c42\u8acb\u79c1\u8a0a\u7c89\u5c08\u3002";
                return;
            }
            case 1: {
                \u7dad\u4fee\u6a21\u5f0f\u8a0a\u606f = " \u89aa\u611b\u7684 \"\u6070\u6070\u8c37\u73a9\u5bb6\" \u60a8\u597d\n\u76ee\u524d\u4f3a\u670d\u5668\u5c6c\u65bc\"\u7981\u6b62\"\u6a21\u5f0f\n\u7121\u6cd5\u8207NPC\u901a\u8a71\u3001\u958b\u555f\u7cbe\u9748\u5546\u4eba\n\u8acb\u7b49\u5f85\u7ba1\u7406\u54e1\"\u53d6\u6d88\"\u7981\u6b62\u6a21\u5f0f";
                return;
            }
        }
    }

    public /* synthetic */ GameStringConstants() {
        GameStringConstants a2;
    }
}

