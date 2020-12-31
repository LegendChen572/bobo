/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package handling.channel.handler;

import client.BuddyEntry;
import client.BuddyList;
import client.MapleCharacter;
import client.MapleClient;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.opcodes.BuddyType;
import handling.world.World;
import server.MapleShopItem;
import tools.FilePrinter;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;

public class BuddyListHandler {
    public /* synthetic */ BuddyListHandler() {
        BuddyListHandler a2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void BuddyOperationHandler(LittleEndianAccessor a, MapleClient a) {
        var2_2 = a.getPlayer();
        var3_3 = a.readByte();
        var4_4 = BuddyType.getBuddyOperationType(var3_3);
        v0 = var2_2;
        var5_9 = v0.getBuddylist();
        v0.setchanged_buddies();
        if (var4_4 == null) {
            BuddyListHandler.ALLATORIxDEMO(a);
            return;
        }
        switch (1.ALLATORIxDEMO[var4_4.ordinal()]) {
            case 1: {
                v1 = a;
                var4_5 = v1.readInt();
                var6_10 = v1.readInt();
                a.sendPacket(MaplePacketCreator.updateBuddylist(var2_2.getBuddylist().getBuddies()));
                return;
            }
            case 2: {
                var4_4 = a.readMapleAsciiString();
                var6_11 = GameSetConstants.MAPLE_VERSION == 75 ? "" : a.readMapleAsciiString();
                var7_15 = var5_9.get((String)var4_4);
                if (var4_4.length() > 13 || var6_11.length() > 16) {
                    BuddyListHandler.ALLATORIxDEMO(a);
                    return;
                }
                if (var7_15 != null && var7_15.getGroup().equals(var6_11)) {
                    v2 = a;
                    v2.sendPacket(MaplePacketCreator.buddylistMessage((byte)11));
                    BuddyListHandler.ALLATORIxDEMO(v2);
                    return;
                }
                if (var7_15 != null) {
                    v3 = a;
                    v4 = var7_15;
                    v4.setGroup(var6_11);
                    v4.updateGroupName();
                    v3.sendPacket(MaplePacketCreator.updateBuddylist(var5_9.getBuddies()));
                    BuddyListHandler.ALLATORIxDEMO(v3);
                    return;
                }
                if (var5_9.isFull()) {
                    a.sendPacket(MaplePacketCreator.buddylistMessage((byte)11));
                    return;
                }
                v5 = var4_4;
                var8_17 = World.Find.findChannel((String)v5);
                var9_19 = World.Find.findWorld((String)v5);
                var11_21 = null;
                var12_22 = null;
                if (var8_17 <= 0) ** GOTO lbl51
                var10_23 = ChannelServer.getInstance(var9_19, var8_17).getPlayerStorage().getCharacterByName((String)var4_4);
                if (var10_23.isGM() && !var2_2.isGM()) ** GOTO lbl52
                v6 = var11_21 = new BuddyEntry(var10_23.getName(), var10_23.getId(), var6_11, var9_19, var8_17, false, var10_23.getLevel(), var10_23.getJob(), var10_23.getSubcategory());
                ** GOTO lbl53
lbl51:
                // 1 sources

                var11_21 = BuddyEntry.getByNameFromDB((String)var4_4);
lbl52:
                // 2 sources

                v6 = var11_21;
lbl53:
                // 2 sources

                if (v6 == null) {
                    v7 = a;
                    v7.sendPacket(MaplePacketCreator.buddylistMessage((byte)15));
                    BuddyListHandler.ALLATORIxDEMO(v7);
                    return;
                }
                if (var8_17 > 0) {
                    v8 = var12_22 = World.Buddy.requestBuddyAdd((String)var4_4, a.getWorld(), a.getChannel(), a.getPlayer().getId(), a.getPlayer().getName(), a.getPlayer().getLevel(), a.getPlayer().getJob(), a.getPlayer().getSubcategory());
                } else {
                    var10_24 = BuddyList.getBuddyCount(var11_21.getCharacterId(), 0);
                    if (var10_24 == -1) {
                        throw new RuntimeException(MapleShopItem.ALLATORIxDEMO(".B\u000fR\u0010S\\T\u0019S\\B\u0004W\u0019D\bB\u0018"));
                    }
                    if (var10_24 >= BuddyList.getBuddyCapacity(var11_21.getCharacterId())) {
                        var12_22 = BuddyList.BuddyAddResult.BUDDYLIST_FULL;
                    }
                    if (BuddyList.getBuddyPending(var11_21.getCharacterId(), var2_2.getId()) > -1) {
                        var12_22 = BuddyList.BuddyAddResult.ALREADY_ON_LIST;
                    }
                    v8 = var12_22;
                }
                if (v8 == BuddyList.BuddyAddResult.BUDDYLIST_FULL) {
                    a.sendPacket(MaplePacketCreator.buddylistMessage((byte)12));
                    return;
                }
                if (var12_22 == BuddyList.BuddyAddResult.ALREADY_ON_LIST && var8_17 > 0) {
                    v9 = var5_9;
                    BuddyListHandler.ALLATORIxDEMO(a, var8_17, var11_21.getCharacterId(), var6_11, BuddyList.BuddyOperation.ADDED);
                } else {
                    BuddyList.addBuddyToDB(var2_2, var11_21);
                    v9 = var5_9;
                }
                v9.put(var11_21);
                v10 = a;
                v10.sendPacket(MaplePacketCreator.updateBuddylist(var5_9.getBuddies()));
                BuddyListHandler.ALLATORIxDEMO(v10);
                return;
            }
            case 3: {
                var4_6 = a.readInt();
                if (var5_9.isFull()) {
                    v11 = a;
                    v11.sendPacket(MaplePacketCreator.buddylistMessage((byte)11));
                    BuddyListHandler.ALLATORIxDEMO(v11);
                    return;
                }
                var6_12 = World.Find.findChannel(var4_6);
                var7_16 = World.Find.findWorld(var4_6);
                var8_18 = null;
                if (var6_12 < 0) {
                    v12 = var8_18 = BuddyEntry.getByIdfFromDB(var4_6);
                } else {
                    var9_20 = ChannelServer.getInstance(var7_16, var6_12).getPlayerStorage().getCharacterById(var4_6);
                    if (var9_20 != null) {
                        var8_18 = new BuddyEntry(var9_20.getName(), var9_20.getId(), "\u5c1a\u672a\u8a2d\u5b9a\u7fa4\u7d44", var7_16, var6_12, true, var9_20.getLevel(), var9_20.getJob(), var9_20.getSubcategory());
                    }
                    v12 = var8_18;
                }
                if (v12 == null) {
                    v13 = a;
                    v14 = v13;
                    v13.sendPacket(MaplePacketCreator.buddylistMessage((byte)11));
                } else {
                    var5_9.put(var8_18);
                    v15 = a;
                    v14 = v15;
                    v15.sendPacket(MaplePacketCreator.updateBuddylist(var5_9.getBuddies()));
                    BuddyListHandler.ALLATORIxDEMO(v15, var6_12, var4_6, var8_18.getGroup(), BuddyList.BuddyOperation.ADDED);
                }
                BuddyListHandler.ALLATORIxDEMO(v14);
                return;
            }
            case 4: {
                var4_7 = a.readInt();
                var6_13 = var5_9.get(var4_7);
                if (var6_13 != null && var6_13.isVisible()) {
                    BuddyListHandler.ALLATORIxDEMO(a, World.Find.findChannel(var4_7), var4_7, var6_13.getGroup(), BuddyList.BuddyOperation.DELETED);
                }
                var5_9.remove(var4_7);
                v16 = a;
                v16.sendPacket(MaplePacketCreator.updateBuddylist(var2_2.getBuddylist().getBuddies()));
                BuddyListHandler.ALLATORIxDEMO(v16);
                return;
            }
            case 5: {
                v17 = a;
                var4_8 = v17.readShort();
                var6_14 = v17.readByte();
                a.sendPacket(MaplePacketCreator.updateBuddylist(var2_2.getBuddylist().getBuddies()));
                return;
            }
            case 6: {
                return;
            }
        }
        FilePrinter.printError(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"ekCz^RNmSVFpCrBl\tj_j"), "Unknown Buddylist Operation " + String.valueOf(var3_3) + " " + a.toString());
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = (2 ^ 5) << 3 ^ 2;
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

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3, int a4, String a5, BuddyList.BuddyOperation a6) {
        MapleCharacter mapleCharacter = a2.getPlayer();
        if (a3 > 0) {
            World.Buddy.buddyChanged(a4, mapleCharacter.getId(), mapleCharacter.getName(), a2.getWorld(), a2.getChannel(), a6, mapleCharacter.getLevel(), mapleCharacter.getJob(), mapleCharacter.getSubcategory(), a5);
        }
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2) {
        BuddyEntry buddyEntry = a2.getPlayer().getBuddylist().pollPendingRequest();
        if (buddyEntry != null) {
            a2.sendPacket(MaplePacketCreator.requestBuddylistAdd(buddyEntry.getCharacterId(), buddyEntry.getName(), buddyEntry.getLevel(), buddyEntry.getJob(), buddyEntry.getSub()));
        }
    }
}

