/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5408\u592a\u8c37
 */
package client.messages;

import client.MapleClient;
import client.messages.commands.player.\u5408\u592a\u8c37;
import constants.ServerConstants;
import tools.Pair;

public abstract class CommandExecute {
    public /* synthetic */ CommandExecute() {
        CommandExecute a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ 1;
        int cfr_ignored_0 = 5 << 3 ^ 3;
        int n5 = n3;
        int n6 = 5 << 4 ^ 5;
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

    public abstract /* synthetic */ boolean execute(MapleClient var1, String[] var2);

    public /* synthetic */ ServerConstants.CommandType getType() {
        return ServerConstants.CommandType.NORMAL;
    }

    public abstract /* synthetic */ String getMessage();

    public static abstract class TradeExecute
    extends CommandExecute {
        public /* synthetic */ TradeExecute() {
            TradeExecute a2;
        }

        @Override
        public /* synthetic */ ServerConstants.CommandType getType() {
            return ServerConstants.CommandType.TRADE;
        }
    }

    public static final class ReturnValue
    extends Enum<ReturnValue> {
        public static final /* synthetic */ /* enum */ ReturnValue DONT_LOG;
        public static final /* synthetic */ /* enum */ ReturnValue LOG;
        private static final /* synthetic */ ReturnValue[] ALLATORIxDEMO;

        public static /* synthetic */ ReturnValue valueOf(String a2) {
            return Enum.valueOf(ReturnValue.class, a2);
        }

        public static /* synthetic */ ReturnValue[] values() {
            return (ReturnValue[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ ReturnValue() {
            void var2_-1;
            void var1_-1;
            ReturnValue a2;
        }

        public static /* synthetic */ {
            DONT_LOG = new ReturnValue(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"Jv@mQuA~"), 0);
            LOG = new ReturnValue(Pair.ALLATORIxDEMO("P+["), 1);
            ReturnValue[] arrreturnValue = new ReturnValue[2];
            arrreturnValue[0] = DONT_LOG;
            arrreturnValue[1] = LOG;
            ALLATORIxDEMO = arrreturnValue;
        }
    }
}

