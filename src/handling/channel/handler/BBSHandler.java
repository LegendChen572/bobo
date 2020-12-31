/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleClient;
import client.MapleKeyLayout;
import handling.world.World;
import handling.world.guild.MapleBBSThread;
import java.util.List;
import tools.LoadPacket;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;

public class BBSHandler {
    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, String a3, String a4, int a5, boolean a6) {
        MapleClient mapleClient = a2;
        BBSHandler.ALLATORIxDEMO(mapleClient, World.Guild.addBBSThread(mapleClient.getPlayer().getGuildId(), a3, a4, a5, a6, a2.getPlayer().getId()));
    }

    private static /* synthetic */ void l(MapleClient a2, int a3) {
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MaplePacketCreator.BBSThreadList(World.Guild.getBBS(mapleClient.getPlayer().getGuildId()), a3));
    }

    private static /* synthetic */ String ALLATORIxDEMO(String a2, int a3) {
        if (a2.length() > a3) {
            return a2.substring(0, a3);
        }
        return a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void HandleBBS(LittleEndianAccessor a, MapleClient a) {
        if (a.getPlayer().getGuildId() <= 0) {
            return;
        }
        try {
            block21: {
                var2_2 = 0;
                var3_4 = a.readByte();
                var4_5 /* !! */  = BBSOperation.getByValue(var3_4);
                if (var4_5 /* !! */  == null) break block21;
                switch (1.ALLATORIxDEMO[var4_5 /* !! */ .ordinal()]) {
                    case 1: {
                        v0 = var4_6 = a.readByte() > 0;
                        if (var4_6) {
                            var2_2 = a.readInt();
                        }
                        var5_11 = a.readByte() > 0;
                        v1 = a;
                        var6_12 = BBSHandler.ALLATORIxDEMO(v1.readMapleAsciiString(), 25);
                        var7_13 = BBSHandler.ALLATORIxDEMO(v1.readMapleAsciiString(), 600);
                        var8_14 = v1.readInt();
                        if (var8_14 >= 100 && var8_14 <= 106) {
                            if (!a.getPlayer().haveItem(5290000 + var8_14 - 100, true ? 1 : 0, false, true)) {
                                return;
                            }
                        } else {
                            if (var8_14 < 0) return;
                            if (var8_14 > 2) {
                                return;
                            }
                        }
                        v2 = a;
                        if (var4_6) ** GOTO lbl31
                        BBSHandler.ALLATORIxDEMO(v2, var6_12, var7_13, var8_14, var5_11);
                        v3 = a;
                        ** GOTO lbl34
lbl31:
                        // 1 sources

                        BBSHandler.ALLATORIxDEMO(v2, var6_12, var7_13, var8_14, var2_2);
                    }
                    case 2: {
                        v3 = a;
lbl34:
                        // 2 sources

                        var2_2 = v3.readInt();
                        BBSHandler.H(a, var2_2);
                    }
                    case 3: {
                        try {
                            var4_7 = a.readInt();
                            BBSHandler.l(a, var4_7 * 10);
                            v4 = a;
                            ** GOTO lbl47
                        }
                        catch (ArrayIndexOutOfBoundsException var4_8) {
                            // empty catch block
                        }
                    }
                    case 4: {
                        try {
                            v4 = a;
lbl47:
                            // 2 sources

                            var2_2 = v4.readInt();
                            BBSHandler.ALLATORIxDEMO(a, var2_2);
                            v5 = a;
                            ** GOTO lbl55
                        }
                        catch (ArrayIndexOutOfBoundsException var4_9) {
                            // empty catch block
                        }
                    }
                    case 5: {
                        v5 = a;
lbl55:
                        // 2 sources

                        var2_2 = v5.readInt();
                        var4_5 /* !! */  = BBSHandler.ALLATORIxDEMO(a.readMapleAsciiString(), 25);
                        BBSHandler.ALLATORIxDEMO(a, var2_2, (String)var4_5 /* !! */ );
                    }
                    case 6: {
                        v6 = a;
                        var2_2 = v6.readInt();
                        var4_10 = v6.readInt();
                        BBSHandler.ALLATORIxDEMO(a, var2_2, var4_10);
                        return;
                    }
                }
                System.err.println("\u672a\u8655\u7406\u7684BBS\u52d5\u4f5c: " + var3_4);
                return;
            }
            System.err.println("\u672a\u8655\u7406\u7684BBS\u52d5\u4f5c: " + var3_4);
            return;
        }
        catch (ArrayIndexOutOfBoundsException var2_3) {
            return;
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ 3;
        int cfr_ignored_0 = 3 << 3 ^ 3;
        int n5 = n3;
        int n6 = 4 << 3 ^ 3;
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

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, String a3, String a4, int a5, int a6) {
        MapleClient mapleClient = a2;
        World.Guild.editBBSThread(mapleClient.getPlayer().getGuildId(), a6, a3, a4, a5, a2.getPlayer().getId(), a2.getPlayer().getGuildRank());
        BBSHandler.ALLATORIxDEMO(mapleClient, a6);
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3) {
        List<MapleBBSThread> list = World.Guild.getBBS(a2.getPlayer().getGuildId());
        if (list != null) {
            for (MapleBBSThread mapleBBSThread : list) {
                if (mapleBBSThread == null || mapleBBSThread.localthreadID != a3) continue;
                a2.sendPacket(MaplePacketCreator.showThread(mapleBBSThread));
            }
        }
    }

    public /* synthetic */ BBSHandler() {
        BBSHandler a2;
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3, String a4) {
        MapleClient mapleClient = a2;
        World.Guild.addBBSReply(mapleClient.getPlayer().getGuildId(), a3, a4, a2.getPlayer().getId());
        BBSHandler.ALLATORIxDEMO(mapleClient, a3);
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3, int a4) {
        MapleClient mapleClient = a2;
        World.Guild.deleteBBSReply(mapleClient.getPlayer().getGuildId(), a3, a4, a2.getPlayer().getId(), a2.getPlayer().getGuildRank());
        BBSHandler.ALLATORIxDEMO(mapleClient, a3);
    }

    private static /* synthetic */ void H(MapleClient a2, int a3) {
        World.Guild.deleteBBSThread(a2.getPlayer().getGuildId(), a3, a2.getPlayer().getId(), a2.getPlayer().getGuildRank());
    }

    public static final class BBSOperation
    extends Enum<BBSOperation> {
        public static final /* synthetic */ /* enum */ BBSOperation ADD_THREAD;
        public static final /* synthetic */ /* enum */ BBSOperation DELETE_REPLY;
        public static final /* synthetic */ /* enum */ BBSOperation DELETE_THREAD;
        public static final /* synthetic */ /* enum */ BBSOperation DISPLAY_THREAD;
        public static final /* synthetic */ /* enum */ BBSOperation LIST_THREAD;
        public /* synthetic */ byte d;
        public static final /* synthetic */ /* enum */ BBSOperation ADD_REPLY;
        private static final /* synthetic */ BBSOperation[] ALLATORIxDEMO;

        public static /* synthetic */ BBSOperation valueOf(String a2) {
            return Enum.valueOf(BBSOperation.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ BBSOperation(byte by) {
            void a2;
            void var2_-1;
            void var1_-1;
            BBSOperation a3;
            BBSOperation bBSOperation = a3;
            bBSOperation.d = (byte)-1;
            bBSOperation.d = a2;
        }

        public /* synthetic */ int getValue() {
            BBSOperation a2;
            return a2.d;
        }

        public static /* synthetic */ {
            ADD_THREAD = new BBSOperation(LoadPacket.ALLATORIxDEMO("RsWhG\u007fArRs"), (int)0, 0);
            DELETE_THREAD = new BBSOperation(MapleKeyLayout.ALLATORIxDEMO("9o1o)o\"~5x8k9"), (int)1, 1);
            LIST_THREAD = new BBSOperation(LoadPacket.ALLATORIxDEMO("{ZdGhG\u007fArRs"), (int)2, 2);
            DISPLAY_THREAD = new BBSOperation(MapleKeyLayout.ALLATORIxDEMO("n4y-f<s\"~5x8k9"), (int)3, 3);
            ADD_REPLY = new BBSOperation(LoadPacket.ALLATORIxDEMO("vWsLeVg_n"), (int)4, 4);
            DELETE_REPLY = new BBSOperation(MapleKeyLayout.ALLATORIxDEMO("n8f8~8u/o-f$"), (int)5, 5);
            BBSOperation[] arrbBSOperation = new BBSOperation[6];
            arrbBSOperation[0] = ADD_THREAD;
            arrbBSOperation[1] = DELETE_THREAD;
            arrbBSOperation[2] = LIST_THREAD;
            arrbBSOperation[3] = DISPLAY_THREAD;
            arrbBSOperation[4] = ADD_REPLY;
            arrbBSOperation[5] = DELETE_REPLY;
            ALLATORIxDEMO = arrbBSOperation;
        }

        public static /* synthetic */ BBSOperation[] values() {
            return (BBSOperation[])ALLATORIxDEMO.clone();
        }

        public static /* synthetic */ BBSOperation getByValue(byte a2) {
            int n2;
            BBSOperation[] arrbBSOperation = BBSOperation.values();
            int n3 = arrbBSOperation.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                BBSOperation bBSOperation = arrbBSOperation[n2];
                if (bBSOperation.getValue() == a2) {
                    return bBSOperation;
                }
                n4 = ++n2;
            }
            return null;
        }
    }
}

