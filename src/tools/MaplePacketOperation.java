/*
 * Decompiled with CFR 0.150.
 */
package tools;

import constants.GameSetConstants;

public class MaplePacketOperation {
    public /* synthetic */ MaplePacketOperation() {
        MaplePacketOperation a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3;
        int cfr_ignored_0 = 2 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 4 << 4 ^ 5;
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

    public static final class GuildStatus {
        public static /* synthetic */ int \u6210\u54e1\u7b49\u7d1a\u8077\u696d\u66f4\u65b0;
        public static /* synthetic */ int \u62d2\u7d55\u516c\u6703\u9080\u8acb;
        public static /* synthetic */ int \u516c\u6703\u5bb9\u7d0d\u4eba\u6578\u66f4\u6539;
        public static /* synthetic */ int \u516c\u6703\u6210\u54e1\u96e2\u958b1;
        public static /* synthetic */ int \u516c\u6703\u5f9e\u806f\u76df\u79fb\u9664;
        public static /* synthetic */ int \u516c\u6703\u6210\u54e1\u4e0a\u7dda;
        public static /* synthetic */ int \u65b0\u516c\u6703\u6210\u54e1;
        public static /* synthetic */ int \u516c\u6703\u6a19\u984c\u66f4\u63db;
        public static /* synthetic */ int \u516c\u6703\u89e3\u6563;
        public static /* synthetic */ int \u516c\u6703\u6210\u54e1\u96e2\u958b2;
        public static /* synthetic */ int \u66f4\u63db\u6210\u54e1\u968e\u7d1a;
        public static /* synthetic */ int \u516c\u6703\u5fbd\u7ae0\u66f4\u6539;
        public static /* synthetic */ int \u986f\u793a\u516c\u6703\u8cc7\u8a0a;
        public static /* synthetic */ int \u516c\u6703\u66f4\u63db\u806f\u76df;
        public static /* synthetic */ int \u516c\u6703\u8a0a\u606f;
        public static /* synthetic */ int \u516c\u6703\u9080\u8acb;

        public static /* synthetic */ {
            \u986f\u793a\u516c\u6703\u8cc7\u8a0a = 26;
            \u516c\u6703\u6210\u54e1\u4e0a\u7dda = 61;
            \u516c\u6703\u9080\u8acb = 5;
            \u62d2\u7d55\u516c\u6703\u9080\u8acb = 55;
            \u65b0\u516c\u6703\u6210\u54e1 = 39;
            \u516c\u6703\u6210\u54e1\u96e2\u958b1 = 47;
            \u516c\u6703\u6210\u54e1\u96e2\u958b2 = 44;
            \u66f4\u63db\u6210\u54e1\u968e\u7d1a = 64;
            \u516c\u6703\u8a0a\u606f = 68;
            \u6210\u54e1\u7b49\u7d1a\u8077\u696d\u66f4\u65b0 = 60;
            \u516c\u6703\u6a19\u984c\u66f4\u63db = 62;
            \u516c\u6703\u89e3\u6563 = 50;
            \u516c\u6703\u5fbd\u7ae0\u66f4\u6539 = 66;
            \u516c\u6703\u5bb9\u7d0d\u4eba\u6578\u66f4\u6539 = 58;
            \u516c\u6703\u5f9e\u806f\u76df\u79fb\u9664 = 16;
            \u516c\u6703\u66f4\u63db\u806f\u76df = 1;
            GuildStatus.reloadset();
        }

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ void reloadset() {
            switch (GameSetConstants.MAPLE_VERSION) {
                case 134: 
                case 135: 
                case 136: 
                case 142: 
                case 143: 
                case 145: 
                case 146: 
                case 147: 
                case 148: 
                case 149: 
                case 151: 
                case 152: 
                case 153: {
                    \u986f\u793a\u516c\u6703\u8cc7\u8a0a = 32;
                    \u516c\u6703\u6210\u54e1\u4e0a\u7dda = 67;
                    \u516c\u6703\u9080\u8acb = 5;
                    \u62d2\u7d55\u516c\u6703\u9080\u8acb = 61;
                    \u65b0\u516c\u6703\u6210\u54e1 = 45;
                    \u516c\u6703\u6210\u54e1\u96e2\u958b1 = 53;
                    \u516c\u6703\u6210\u54e1\u96e2\u958b2 = 50;
                    \u66f4\u63db\u6210\u54e1\u968e\u7d1a = 70;
                    \u516c\u6703\u8a0a\u606f = 75;
                    \u6210\u54e1\u7b49\u7d1a\u8077\u696d\u66f4\u65b0 = 66;
                    \u516c\u6703\u6a19\u984c\u66f4\u63db = 68;
                    \u516c\u6703\u89e3\u6563 = 56;
                    \u516c\u6703\u5fbd\u7ae0\u66f4\u6539 = 73;
                    \u516c\u6703\u5bb9\u7d0d\u4eba\u6578\u66f4\u6539 = 64;
                    \u516c\u6703\u5f9e\u806f\u76df\u79fb\u9664 = 16;
                    \u516c\u6703\u66f4\u63db\u806f\u76df = 1;
                    return;
                }
            }
        }

        public /* synthetic */ GuildStatus() {
            GuildStatus a2;
        }
    }

    public static final class NPCPacket {
        public static /* synthetic */ byte TalkNum2;
        public static /* synthetic */ byte MapSelection;
        public static /* synthetic */ byte TalkStyle;
        public static /* synthetic */ byte TalkText;
        public static /* synthetic */ byte TalkNum1;

        public static /* synthetic */ {
            TalkStyle = (byte)7;
            TalkNum2 = (byte)3;
            TalkNum1 = (byte)4;
            TalkText = (byte)2;
            MapSelection = (byte)13;
            NPCPacket.reloadset();
        }

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ void reloadset() {
            switch (GameSetConstants.MAPLE_VERSION) {
                case 75: {
                    TalkStyle = (byte)6;
                    return;
                }
                case 116: 
                case 118: 
                case 119: {
                    TalkStyle = (byte)8;
                    TalkNum1 = (byte)6;
                    TalkNum2 = (byte)4;
                    TalkText = (byte)3;
                    MapSelection = (byte)14;
                    return;
                }
                case 134: 
                case 135: 
                case 136: 
                case 142: 
                case 143: 
                case 145: 
                case 146: 
                case 147: 
                case 148: 
                case 149: {
                    TalkStyle = (byte)9;
                    TalkNum1 = (byte)6;
                    TalkNum2 = (byte)4;
                    TalkText = (byte)3;
                    MapSelection = (byte)16;
                    return;
                }
                case 151: 
                case 152: 
                case 153: {
                    TalkStyle = (byte)9;
                    TalkNum1 = (byte)6;
                    TalkNum2 = (byte)4;
                    TalkText = (byte)3;
                    MapSelection = (byte)17;
                    return;
                }
            }
        }

        public /* synthetic */ NPCPacket() {
            NPCPacket a2;
        }
    }

    public static final class NPCStatus {
        public static /* synthetic */ byte askAcceptDeclineNoESC;
        public static /* synthetic */ byte sendSimpleS;
        public static /* synthetic */ byte sendGetNumber;
        public static /* synthetic */ byte DirectionEffect;
        public static /* synthetic */ byte askAcceptDecline;
        public static /* synthetic */ byte sendGetText;
        public static /* synthetic */ byte askMapSelection;
        public static /* synthetic */ byte sendStyle;
        public static /* synthetic */ byte sendSimple;
        public static /* synthetic */ byte askAvatar;
        public static /* synthetic */ byte sendYesNo;

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ void reloadset() {
            switch (GameSetConstants.MAPLE_VERSION) {
                case 75: {
                    askAvatar = (byte)6;
                    sendStyle = (byte)6;
                    return;
                }
                case 116: 
                case 118: 
                case 119: {
                    sendYesNo = (byte)2;
                    askAcceptDecline = (byte)12;
                    askAcceptDeclineNoESC = (byte)14;
                    askAvatar = (byte)8;
                    sendSimple = (byte)5;
                    sendSimpleS = (byte)5;
                    sendStyle = (byte)8;
                    sendGetNumber = (byte)4;
                    sendGetText = (byte)3;
                    askMapSelection = (byte)14;
                    return;
                }
                case 134: 
                case 135: 
                case 136: 
                case 142: 
                case 143: 
                case 145: 
                case 146: 
                case 147: 
                case 148: 
                case 149: {
                    sendYesNo = (byte)2;
                    askAcceptDecline = (byte)14;
                    askAcceptDeclineNoESC = (byte)14;
                    askAvatar = (byte)9;
                    sendSimple = (byte)5;
                    sendSimpleS = (byte)5;
                    sendStyle = (byte)9;
                    sendGetNumber = (byte)4;
                    sendGetText = (byte)3;
                    askMapSelection = (byte)16;
                    return;
                }
                case 151: {
                    sendYesNo = (byte)2;
                    askAcceptDecline = (byte)14;
                    askAcceptDeclineNoESC = (byte)15;
                    askAvatar = (byte)9;
                    sendSimple = (byte)5;
                    sendSimpleS = (byte)5;
                    sendStyle = (byte)9;
                    sendGetNumber = (byte)4;
                    sendGetText = (byte)3;
                    askMapSelection = (byte)17;
                    return;
                }
                case 152: 
                case 153: {
                    sendYesNo = (byte)2;
                    askAcceptDecline = (byte)15;
                    askAcceptDeclineNoESC = (byte)16;
                    askAvatar = (byte)10;
                    sendSimple = (byte)5;
                    sendSimpleS = (byte)5;
                    sendStyle = (byte)9;
                    sendGetNumber = (byte)4;
                    sendGetText = (byte)3;
                    askMapSelection = (byte)17;
                    DirectionEffect = (byte)18;
                    return;
                }
            }
        }

        public /* synthetic */ NPCStatus() {
            NPCStatus a2;
        }

        public static /* synthetic */ {
            sendYesNo = 1;
            askAcceptDecline = (byte)11;
            askAcceptDeclineNoESC = (byte)12;
            askAvatar = (byte)7;
            sendSimple = (byte)4;
            sendSimpleS = (byte)4;
            sendStyle = (byte)7;
            sendGetNumber = (byte)3;
            sendGetText = (byte)2;
            askMapSelection = (byte)13;
            DirectionEffect = (byte)17;
            NPCStatus.reloadset();
        }
    }

    public static final class PartyStatus {
        public static /* synthetic */ int \u6c92\u6709\u53c3\u52a0\u7684\u7d44\u968a;
        public static /* synthetic */ int \u968a\u4f0d\u6210\u54e1\u5df2\u6eff;
        public static /* synthetic */ int \u66f4\u63db\u968a\u9577;
        public static /* synthetic */ int \u52a0\u5165\u7d44\u968a;
        public static /* synthetic */ int \u968a\u9577\u89e3\u9664\u7d44\u968a\u9000\u51fa\u968a\u4f0d;
        public static /* synthetic */ int \u76ee\u524d\u983b\u9053\u5167\u627e\u4e0d\u5230\u8a72\u8173\u8272;
        public static /* synthetic */ int \u9080\u8acb\u52a0\u5165\u7d44\u968a;
        public static /* synthetic */ int \u968a\u4f0d\u9080\u8acb;
        public static /* synthetic */ int PQ\u734e\u52f5\u7269\u54c1;
        public static /* synthetic */ int \u521d\u5fc3\u8005\u4e0d\u80fd\u958b\u555f\u968a\u4f0d;
        public static /* synthetic */ int \u5237\u65b0\u72c0\u614b;
        public static /* synthetic */ int \u968a\u4f0d\u5275\u7acb;
        public static /* synthetic */ int \u968a\u4f0d\u50b3\u9001\u9ede;
        public static /* synthetic */ int \u672a\u77e5\u932f\u8aa4;
        public static /* synthetic */ int PQ\u734e\u52f5\u7d50\u679c;
        public static /* synthetic */ int \u5df2\u7d93\u52a0\u5165\u5176\u4ed6\u7d44;

        public /* synthetic */ PartyStatus() {
            PartyStatus a2;
        }

        public static /* synthetic */ {
            \u968a\u4f0d\u9080\u8acb = 4;
            \u5237\u65b0\u72c0\u614b = 7;
            \u968a\u4f0d\u5275\u7acb = 8;
            \u521d\u5fc3\u8005\u4e0d\u80fd\u958b\u555f\u968a\u4f0d = 10;
            \u672a\u77e5\u932f\u8aa4 = 11;
            \u6c92\u6709\u53c3\u52a0\u7684\u7d44\u968a = 13;
            \u52a0\u5165\u7d44\u968a = 15;
            \u5df2\u7d93\u52a0\u5165\u5176\u4ed6\u7d44 = 16;
            \u968a\u4f0d\u6210\u54e1\u5df2\u6eff = 17;
            \u76ee\u524d\u983b\u9053\u5167\u627e\u4e0d\u5230\u8a72\u8173\u8272 = 19;
            \u968a\u9577\u89e3\u9664\u7d44\u968a\u9000\u51fa\u968a\u4f0d = 12;
            \u66f4\u63db\u968a\u9577 = 27;
            \u968a\u4f0d\u50b3\u9001\u9ede = 36;
            PQ\u734e\u52f5\u7269\u54c1 = 41;
            PQ\u734e\u52f5\u7d50\u679c = 39;
            \u9080\u8acb\u52a0\u5165\u7d44\u968a = -1;
            PartyStatus.reloadset();
        }

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ void reloadset() {
            switch (GameSetConstants.MAPLE_VERSION) {
                case 75: {
                    \u66f4\u63db\u968a\u9577 = 25;
                    \u968a\u4f0d\u50b3\u9001\u9ede = 32;
                    return;
                }
                case 118: {
                    \u521d\u5fc3\u8005\u4e0d\u80fd\u958b\u555f\u968a\u4f0d = 11;
                    \u672a\u77e5\u932f\u8aa4 = 20;
                    \u5df2\u7d93\u52a0\u5165\u5176\u4ed6\u7d44 = 17;
                    \u968a\u4f0d\u6210\u54e1\u5df2\u6eff = 18;
                    \u6c92\u6709\u53c3\u52a0\u7684\u7d44\u968a = 13;
                    \u76ee\u524d\u983b\u9053\u5167\u627e\u4e0d\u5230\u8a72\u8173\u8272 = 20;
                    \u66f4\u63db\u968a\u9577 = 31;
                    \u968a\u4f0d\u50b3\u9001\u9ede = 40;
                    return;
                }
                case 134: 
                case 135: 
                case 136: {
                    \u968a\u4f0d\u50b3\u9001\u9ede = 46;
                    \u66f4\u63db\u968a\u9577 = 31;
                    return;
                }
                case 139: 
                case 142: {
                    \u5237\u65b0\u72c0\u614b = 9;
                    \u968a\u4f0d\u5275\u7acb = 10;
                    \u521d\u5fc3\u8005\u4e0d\u80fd\u958b\u555f\u968a\u4f0d = 12;
                    \u968a\u9577\u89e3\u9664\u7d44\u968a\u9000\u51fa\u968a\u4f0d = 14;
                    \u6c92\u6709\u53c3\u52a0\u7684\u7d44\u968a = 15;
                    \u52a0\u5165\u7d44\u968a = 17;
                    \u5df2\u7d93\u52a0\u5165\u5176\u4ed6\u7d44 = 19;
                    \u968a\u4f0d\u6210\u54e1\u5df2\u6eff = 20;
                    \u9080\u8acb\u52a0\u5165\u7d44\u968a = 24;
                    \u66f4\u63db\u968a\u9577 = 33;
                    \u76ee\u524d\u983b\u9053\u5167\u627e\u4e0d\u5230\u8a72\u8173\u8272 = 22;
                    PQ\u734e\u52f5\u7d50\u679c = 45;
                    PQ\u734e\u52f5\u7269\u54c1 = 47;
                    \u968a\u4f0d\u50b3\u9001\u9ede = 58;
                    return;
                }
                case 143: 
                case 145: 
                case 146: 
                case 147: 
                case 148: 
                case 149: 
                case 151: 
                case 152: 
                case 153: {
                    \u5237\u65b0\u72c0\u614b = 11;
                    \u968a\u4f0d\u5275\u7acb = 12;
                    \u521d\u5fc3\u8005\u4e0d\u80fd\u958b\u555f\u968a\u4f0d = 14;
                    \u968a\u9577\u89e3\u9664\u7d44\u968a\u9000\u51fa\u968a\u4f0d = 16;
                    \u6c92\u6709\u53c3\u52a0\u7684\u7d44\u968a = 17;
                    \u52a0\u5165\u7d44\u968a = 19;
                    \u5df2\u7d93\u52a0\u5165\u5176\u4ed6\u7d44 = 21;
                    \u968a\u4f0d\u6210\u54e1\u5df2\u6eff = 22;
                    \u9080\u8acb\u52a0\u5165\u7d44\u968a = 26;
                    \u66f4\u63db\u968a\u9577 = 35;
                    PQ\u734e\u52f5\u7d50\u679c = 47;
                    PQ\u734e\u52f5\u7269\u54c1 = 49;
                    \u968a\u4f0d\u50b3\u9001\u9ede = 60;
                    return;
                }
            }
        }
    }

    public static final class MerchantStatus {
        public static /* synthetic */ int \u5546\u5e97\u6574\u7406\u7269\u54c1;
        public static /* synthetic */ int \u8d85\u904e\u71df\u696d\u6642\u9593;

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ void reloadset() {
            switch (GameSetConstants.MAPLE_VERSION) {
                case 75: {
                    \u8d85\u904e\u71df\u696d\u6642\u9593 = 15;
                    \u5546\u5e97\u6574\u7406\u7269\u54c1 = 14;
                    return;
                }
            }
        }

        public static /* synthetic */ {
            \u8d85\u904e\u71df\u696d\u6642\u9593 = 19;
            \u5546\u5e97\u6574\u7406\u7269\u54c1 = 18;
            MerchantStatus.reloadset();
        }

        public /* synthetic */ MerchantStatus() {
            MerchantStatus a2;
        }
    }
}

