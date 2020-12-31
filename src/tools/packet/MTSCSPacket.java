/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import client.MapleCharacter;
import client.MapleClient;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ServerConstants;
import handling.SendPacketOpcode;
import handling.opcodes.CashShopType;
import handling.opcodes.SpecialEffect;
import handling.opcodes.StatusInfoType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import server.CashItem;
import server.CashItemFactory;
import server.CashItemFlag;
import server.CashModItem;
import server.CashShop;
import server.MTSStorage;
import server.MapleShopItem;
import tools.KoreanDateUtil;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.PacketHelper;
import tools.wztosql.DumpMobName;

/*
 * Exception performing whole class analysis ignored.
 */
public class MTSCSPacket {
    public static /* synthetic */ byte[] itemExpired(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.ITEM_EXPIRED.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSFailCancel() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(38);
        maplePacketLittleEndianWriter2.write(66);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] useAmulet(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter3.write(SpecialEffect.USE_AMULET.getValue());
        boolean bl = true;
        if (a4 == 5131000) {
            bl = false;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            maplePacketLittleEndianWriter2.writeInt(bl ? 1 : 0);
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(bl);
        }
        maplePacketLittleEndianWriter.write(a2);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter5.write(a3);
        maplePacketLittleEndianWriter5.writeInt(a4);
        return maplePacketLittleEndianWriter5.getPacket();
    }

    public static /* synthetic */ byte[] sendGift(String a2, CashItem a3, int a4, boolean a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a5 ? CashShopType.GIFT_SEND_PACKAGE.getValue() : CashShopType.GIFT_SEND.getValue());
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeInt(a3.getId());
        maplePacketLittleEndianWriter3.writeShort(a3.getCount());
        if (a5) {
            maplePacketLittleEndianWriter.writeShort(a4);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ void addCashItemInfo(MaplePacketLittleEndianWriter a2, int a3, int a4, int a5, int a6, int a7, String a8, long a9) {
        MTSCSPacket.addCashItemInfo(a2, a3, a4, a5, a6, a7, a8, a9, true);
    }

    public static /* synthetic */ byte[] getTrockRefresh135(MapleCharacter a2, byte a3, boolean a42) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MAP_TRANSFER_RESULT.getValue());
        maplePacketLittleEndianWriter2.write(a42 ? 2 : 3);
        byte by = a3;
        maplePacketLittleEndianWriter.write(by);
        if (by == 2) {
            int n2;
            int[] a42 = a2.getRocks();
            int n3 = n2 = 0;
            while (n3 < 10) {
                maplePacketLittleEndianWriter.writeInt(a42[n2++]);
                n3 = n2;
            }
        } else if (a3 >= 3) {
            int n4;
            int[] a42 = a2.getHyperRocks();
            int n5 = n4 = 0;
            while (n5 < 13) {
                maplePacketLittleEndianWriter.writeInt(a42[n4++]);
                n5 = n4;
            }
        } else {
            int n6;
            int[] a42 = a2.getRegRocks();
            int n7 = n6 = 0;
            while (n7 < 5) {
                maplePacketLittleEndianWriter.writeInt(a42[n6++]);
                n7 = n6;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getTrockRefresh(MapleCharacter a2, byte a3, boolean a42) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        if (GameSetConstants.MAPLE_VERSION >= 135) {
            return MTSCSPacket.getTrockRefresh135(a2, a3, a42);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MAP_TRANSFER_RESULT.getValue());
        maplePacketLittleEndianWriter2.write(a42 ? 2 : 3);
        byte by = a3;
        maplePacketLittleEndianWriter.write(by);
        if (by == 1) {
            int n2;
            int[] a42 = a2.getRocks();
            int n3 = n2 = 0;
            while (n3 < 10) {
                maplePacketLittleEndianWriter.writeInt(a42[n2++]);
                n3 = n2;
            }
        } else if (a3 >= 2) {
            int n4;
            int[] a42 = a2.getHyperRocks();
            int n5 = n4 = 0;
            while (n5 < 13) {
                maplePacketLittleEndianWriter.writeInt(a42[n4++]);
                n5 = n4;
            }
        } else {
            int n6;
            int[] a42 = a2.getRegRocks();
            int n7 = n6 = 0;
            while (n7 < 5) {
                maplePacketLittleEndianWriter.writeInt(a42[n6++]);
                n7 = n6;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] playCashSong(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CASH_SONG.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showCouponRedeemedItem(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter5.writeShort(CashShopType.COUPON_REDEEM.getValue());
        maplePacketLittleEndianWriter4.writeInt(0);
        maplePacketLittleEndianWriter4.writeInt(1);
        maplePacketLittleEndianWriter3.writeShort(1);
        maplePacketLittleEndianWriter3.writeShort(26);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBoughtRing(IItem a2, int a3, int a4, String a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.BUY.getValue());
        MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter2, a2, a4, a3, true);
        if (GameSetConstants.MAPLE_VERSION >= 149) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter.writeMapleAsciiString(a5);
            maplePacketLittleEndianWriter3.writeInt(a2.getItemId());
            maplePacketLittleEndianWriter3.writeShort(1);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] warpCS(MapleClient a2, int a2222) {
        int n2;
        int n3;
        Object object;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPEN.getValue());
        PacketHelper.addCharacterInfo(maplePacketLittleEndianWriter2, a2.getPlayer(), true);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getAccountName());
        CashItemFactory cashItemFactory = CashItemFactory.getInstance();
        maplePacketLittleEndianWriter2.writeInt(0);
        cashItemFactory = CashItemFactory.getInstance();
        Object object2 = cashItemFactory.getHideAllDefaultItems();
        if (!GameSetConstants.CS_HIDEITEMS) {
            object2.clear();
        }
        List<CashModItem> a2222 = cashItemFactory.getAllModItems(a2222);
        if (GameSetConstants.CASHSHOP_ETC) {
            a2222 = cashItemFactory.getAllModItemsMark();
        }
        maplePacketLittleEndianWriter.writeShort(object2.size() + a2222.size());
        Object object3 = object2 = object2.iterator();
        while (object3.hasNext()) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3;
            object = (CashItem)object2.next();
            maplePacketLittleEndianWriter.writeInt(((CashItem)object).getSN());
            if (GameSetConstants.MAPLE_VERSION >= 113) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeInt((short)CashItemFlag.ONSALE.getValue());
            } else {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
                maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.writeShort((short)CashItemFlag.ONSALE.getValue());
            }
            maplePacketLittleEndianWriter3.write(0);
            object3 = object2;
        }
        Object object4 = object2 = a2222.iterator();
        while (object4.hasNext()) {
            object = object2.next();
            object4 = object2;
            MTSCSPacket.addCashModItem(maplePacketLittleEndianWriter, (CashModItem)object);
        }
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            maplePacketLittleEndianWriter.writeShort(0);
        }
        maplePacketLittleEndianWriter.write(0);
        maplePacketLittleEndianWriter.writeZeroBytes(120);
        object2 = new ArrayList();
        object = ServerConstants.hot_sell;
        int a2222 = ServerConstants.hot_sell.length;
        int n4 = n3 = 0;
        while (n4 < a2222) {
            Object object5 = object[n3];
            if (cashItemFactory.getItem((int)object5) != null) {
                object2.add((int)object5);
            }
            n4 = ++n3;
        }
        int n5 = n2 = 1;
        while (n5 <= 8) {
            int n6 = a2222 = 0;
            while (n6 < 2) {
                int n7 = n3 = 0;
                while (n7 < 5) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
                    maplePacketLittleEndianWriter.writeInt(n2);
                    maplePacketLittleEndianWriter6.writeInt(a2222);
                    maplePacketLittleEndianWriter6.writeInt(object2.size() > n3 ? (Integer)object2.get(n3) : 0);
                    n7 = ++n3;
                }
                n6 = ++a2222;
            }
            n5 = ++n2;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(0);
        maplePacketLittleEndianWriter7.writeShort(0);
        maplePacketLittleEndianWriter7.write(0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] intoCs(MapleClient a2, int a32) {
        int n2;
        int n3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        CashItemFactory cashItemFactory;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        block25: {
            int n4;
            maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_INTO.getValue());
            if (GameSetConstants.MAPLE_VERSION < 151) {
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getAccountName());
            }
            cashItemFactory = CashItemFactory.getInstance();
            maplePacketLittleEndianWriter2.writeInt(0);
            cashItemFactory = CashItemFactory.getInstance();
            Object a32 = cashItemFactory.getAllModItems(a32);
            if (GameSetConstants.MAPLE_VERSION > 136 || GameSetConstants.CASHSHOP_ETC) {
                a32 = cashItemFactory.getAllModItemsMark();
            }
            maplePacketLittleEndianWriter2.writeShort(a32.size());
            Object object = a32 = a32.iterator();
            while (object.hasNext()) {
                CashModItem cashModItem = (CashModItem)a32.next();
                object = a32;
                MTSCSPacket.addCashModItem(maplePacketLittleEndianWriter2, cashModItem);
            }
            int n5 = a32 = 0;
            maplePacketLittleEndianWriter2.writeShort(n5);
            if (n5 > 0) {
                int n6;
                int n7 = n6 = 0;
                while (n7 < a32) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter3.writeInt(0);
                    maplePacketLittleEndianWriter3.writeMapleAsciiString("");
                    n7 = ++n6;
                }
            }
            int n8 = n4 = 0;
            maplePacketLittleEndianWriter2.write(n8);
            if (n8 > 0) {
                int n9 = a32 = 0;
                while (n9 < n4) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter2.write(0);
                    maplePacketLittleEndianWriter4.write(0);
                    maplePacketLittleEndianWriter4.write(0);
                    n9 = ++a32;
                }
            }
            if (GameSetConstants.MAPLE_VERSION >= 139) {
                Map<Integer, List<Integer>> map = a32 = cashItemFactory.getRandomItemInfo();
                maplePacketLittleEndianWriter2.writeInt(map.size());
                for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                    maplePacketLittleEndianWriter2.writeInt(entry.getKey());
                    if (entry.getKey() / 1000 != 5533) {
                        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                        break block25;
                    }
                    maplePacketLittleEndianWriter2.writeInt(entry.getValue().size());
                    Iterator<Integer> iterator = entry.getValue().iterator();
                    while (iterator.hasNext()) {
                        Iterator<Integer> iterator2;
                        Integer n10 = iterator2.next();
                        iterator = iterator2;
                        maplePacketLittleEndianWriter2.writeInt(n10);
                    }
                }
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.writeZeroBytes(120);
        ArrayList<Integer> a32 = new ArrayList<Integer>();
        int[] arrn = ServerConstants.hot_sell;
        int n11 = ServerConstants.hot_sell.length;
        int n12 = n3 = 0;
        while (n12 < n11) {
            int n13 = arrn[n3];
            if (cashItemFactory.getItem(n13) != null) {
                a32.add(n13);
            }
            n12 = ++n3;
        }
        int n14 = n2 = 1;
        while (n14 <= 8) {
            int n15 = n11 = 0;
            while (n15 < 2) {
                int n16 = n3 = 0;
                while (n16 < 5) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                    maplePacketLittleEndianWriter2.writeInt(n2);
                    maplePacketLittleEndianWriter5.writeInt(n11);
                    maplePacketLittleEndianWriter5.writeInt(a32.size() > n3 ? (Integer)a32.get(n3) : 0);
                    n16 = ++n3;
                }
                n15 = ++n11;
            }
            n14 = ++n2;
        }
        int n17 = n2 = 0;
        maplePacketLittleEndianWriter2.writeShort(n17);
        if (n17 > 0) {
            int n18 = n11 = 0;
            while (n18 < n2) {
                maplePacketLittleEndianWriter2.writeLong(0L);
                n18 = ++n11;
            }
        }
        int n19 = n11 = 0;
        maplePacketLittleEndianWriter2.writeShort(n19);
        if (n19 > 0) {
            int n20 = n3 = 0;
            while (n20 < n11) {
                maplePacketLittleEndianWriter2.writeZeroBytes(104);
                n20 = ++n3;
            }
        }
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            int n21 = n3 = 0;
            maplePacketLittleEndianWriter2.writeInt(n21);
            if (n21 > 0) {
                int n22;
                do {
                    boolean bl = false;
                    int n23 = a32 = 0;
                    maplePacketLittleEndianWriter2.writeInt(0);
                    maplePacketLittleEndianWriter2.writeInt(n23);
                    if (n23 <= 0) {
                        n22 = n3;
                        continue;
                    }
                    do {
                        maplePacketLittleEndianWriter2.writeZeroBytes(24);
                    } while (!(bl = --a32 == 1));
                    n22 = --n3;
                } while (n22 > 0);
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter6.writeZeroBytes(20);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] sendMesobagSuccess(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MESOBAG_SUCCESS.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBoughtCashPackage(Map<Integer, IItem> a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Map<Integer, IItem> map = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.BUY_PACKAGE.getValue());
        maplePacketLittleEndianWriter.write(map.size());
        int n2 = 0;
        for (Map.Entry<Integer, IItem> object : map.entrySet()) {
            MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter, object.getValue(), a3, object.getKey());
            if (GameSetConstants.MAPLE_VERSION < 134 || !GameConstants.isPet(object.getValue().getItemId()) && GameConstants.getInventoryType(object.getValue().getItemId()) != MapleInventoryType.EQUIP) continue;
            ++n2;
        }
        if (GameSetConstants.MAPLE_VERSION >= 134 && a2.size() > 0) {
            maplePacketLittleEndianWriter.writeInt(n2);
            for (IItem iItem : a2.values()) {
                if (!GameConstants.isPet(iItem.getItemId()) && GameConstants.getInventoryType(iItem.getItemId()) != MapleInventoryType.EQUIP) continue;
                PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] showPredictCard(String a2, String a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(103);
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] confirmFromCSInventory(IItem a2, short a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(CashShopType.CS_TO_INV.getValue());
        maplePacketLittleEndianWriter3.writeShort(a3);
        PacketHelper.addItemInfo(maplePacketLittleEndianWriter2, a2);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showCashInventory(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (a2 != null && a2.getPlayer() != null && a2.getPlayer().getCashInventory() != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
            maplePacketLittleEndianWriter2.write(CashShopType.INVENTORY.getValue());
            CashShop cashShop = a2.getPlayer().getCashInventory();
            int n2 = 0;
            CashShop cashShop2 = cashShop;
            int n3 = cashShop2.getItemsSize();
            maplePacketLittleEndianWriter2.writeShort(cashShop2.getItemsSize());
            for (IItem iItem : cashShop.getInventory()) {
                MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter, iItem, a2.getAccID(), 0);
                if (GameSetConstants.MAPLE_VERSION < 134 || !GameConstants.isPet(iItem.getItemId())) continue;
                ++n2;
            }
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                maplePacketLittleEndianWriter.writeInt(0);
            }
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MapleClient mapleClient = a2;
        maplePacketLittleEndianWriter3.writeShort(mapleClient.getPlayer().getStorage().getSlots());
        maplePacketLittleEndianWriter3.writeShort(mapleClient.getCharacterSlots());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter4.writeShort(a2.getPlayer().getStorage().getSlots());
            maplePacketLittleEndianWriter4.writeShort(a2.getCharacterSlots());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showBoughtCashItem(IItem a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.BUY.getValue());
        MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter2, a2, a4, a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ void addCashItemInfo(MaplePacketLittleEndianWriter a2, int a3, int a4, int a5, int a6, int a7, String a8, long a9, boolean a10) {
        a2.writeLong(a3 > 0 ? (long)a3 : 0L);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        a2.writeLong(a4);
        maplePacketLittleEndianWriter.writeInt(a5);
        maplePacketLittleEndianWriter.writeInt(a10 ? a6 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        maplePacketLittleEndianWriter3.writeShort(a7);
        maplePacketLittleEndianWriter3.writeAsciiString(a8, GameSetConstants.WRITE_STRING_LENGTH);
        PacketHelper.addExpirationTime(maplePacketLittleEndianWriter2, a9);
        maplePacketLittleEndianWriter2.writeLong(0L);
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            a2.writeZeroBytes(10);
        }
    }

    public static /* synthetic */ byte[] showCouponRedeemedItem(Map<Integer, IItem> a2, int a3, int a4, MapleClient a5) {
        Iterator<Map.Entry<Integer, IItem>> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        Map<Integer, IItem> map = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.writeShort(CashShopType.COUPON_REDEEM.getValue());
        maplePacketLittleEndianWriter.write(map.size());
        Iterator<Map.Entry<Integer, IItem>> iterator2 = iterator = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, IItem> entry = iterator.next();
            MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter, entry.getValue(), a5.getAccID(), entry.getKey());
            iterator2 = iterator;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeLong(a4);
        maplePacketLittleEndianWriter3.writeInt(a3);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] useCharm(byte a2, byte a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter3.write(SpecialEffect.USE_AMULET.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] useChalkboard(int a2, String a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CHALKBOARD.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        if (a3 == null || a3.length() <= 0) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.write(0);
        } else {
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter5.write(1);
            maplePacketLittleEndianWriter5.writeMapleAsciiString(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSConfirmTransfer(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(36);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showXmasSurprise(boolean a2, int a3, IItem a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        int n2 = 222;
        int n3 = 223;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_XMAS_SURPRISE.getValue());
        if (GameSetConstants.MAPLE_VERSION == 151) {
            n2 = 211;
            n3 = 212;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION == 152 || GameSetConstants.MAPLE_VERSION == 153) {
            n2 = 221;
            n3 = 222;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION == 149) {
            n2 = 212;
            n3 = 213;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION >= 147) {
            n2 = 209;
            n3 = 210;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION >= 145) {
            n2 = 207;
            n3 = 208;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION >= 142) {
            n2 = 206;
            n3 = 207;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION >= 139) {
            n2 = 205;
            n3 = 206;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION >= 134) {
            n2 = 195;
            n3 = 196;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else if (GameSetConstants.MAPLE_VERSION >= 118) {
            n2 = 238;
            n3 = 239;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 116) {
                n2 = 231;
                n3 = 232;
            }
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        }
        maplePacketLittleEndianWriter.write(a2 ? n2 : n3);
        if (!a2) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter5.writeLong(a3);
            maplePacketLittleEndianWriter5.writeInt(0);
            MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter4, a4, a5, 0);
            maplePacketLittleEndianWriter4.writeInt(a4.getItemId());
            maplePacketLittleEndianWriter3.write(1);
            maplePacketLittleEndianWriter3.write(1);
        }
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] changePetName(MapleCharacter a2, String a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.PET_NAMECHANGE.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2.getId());
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
            maplePacketLittleEndianWriter4.writeInt(a5);
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
            maplePacketLittleEndianWriter5.write(0);
        }
        maplePacketLittleEndianWriter.writeMapleAsciiString(a3);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter6.write(a4);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static final /* synthetic */ byte[] startMTS(MapleCharacter a2, MapleClient a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.ITC_OPEN.getValue());
        PacketHelper.addCharacterInfo(maplePacketLittleEndianWriter5, a2, true);
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a3.getAccountName());
        maplePacketLittleEndianWriter4.writeInt(5000);
        maplePacketLittleEndianWriter3.writeInt(10);
        maplePacketLittleEndianWriter3.writeInt(100);
        maplePacketLittleEndianWriter2.writeInt(24);
        maplePacketLittleEndianWriter.writeInt(168);
        maplePacketLittleEndianWriter2.writeLong(PacketHelper.getTime(System.currentTimeMillis()));
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] enableCSUse() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_USE.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSFailSell() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(29);
        maplePacketLittleEndianWriter2.write(66);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showNotes(ResultSet a2, int a3) throws SQLException {
        int n2;
        boolean bl = false;
        if (GameSetConstants.AUCTION_SYSTEM && a2.getString(DumpMobName.ALLATORIxDEMO("x5f#t7p")).contains(MapleShopItem.ALLATORIxDEMO("\u7ad1\u6a65\u724e\u54bd"))) {
            bl = true;
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_NOTES.getValue());
        maplePacketLittleEndianWriter.write(GameSetConstants.MAPLE_VERSION == 75 ? 2 : 3);
        maplePacketLittleEndianWriter.write(a3);
        int n3 = n2 = 0;
        while (n3 < a3) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.writeInt(a2.getInt(DumpMobName.ALLATORIxDEMO("9q")));
            maplePacketLittleEndianWriter2.writeMapleAsciiString(bl ? MapleShopItem.ALLATORIxDEMO("\u7ad1\u62b1\u7cdc\u7d0d") : a2.getString(DumpMobName.ALLATORIxDEMO("6g?x")));
            ResultSet resultSet = a2;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter3.writeMapleAsciiString(a2.getString(MapleShopItem.ALLATORIxDEMO("\u0011B\u000fT\u001d@\u0019")));
            maplePacketLittleEndianWriter3.writeLong(PacketHelper.getKoreanTimestamp(a2.getLong(DumpMobName.ALLATORIxDEMO("a9x5f$t=e"))));
            maplePacketLittleEndianWriter.write(resultSet.getInt(MapleShopItem.ALLATORIxDEMO("@\u0015A\b")));
            resultSet.next();
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendGiftFail(int a2, int a3, boolean a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a4 ? CashShopType.GIFT_SEND_PACKAGE_FAIL.getValue() : CashShopType.GIFT_SEND_FAIL.getValue());
        int n2 = a2;
        maplePacketLittleEndianWriter.writeShort(n2);
        if (n2 == 208 || a2 == 207) {
            maplePacketLittleEndianWriter.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showNXMapleTokens(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_UPDATE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getCSPoints(1));
        maplePacketLittleEndianWriter2.writeInt(a2.getCSPoints(2));
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getNotYetSoldInv(List<MTSStorage.MTSItemInfo> a2) {
        Iterator<MTSStorage.MTSItemInfo> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<MTSStorage.MTSItemInfo> list = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(32);
        maplePacketLittleEndianWriter.writeInt(list.size());
        Iterator<MTSStorage.MTSItemInfo> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            MTSStorage.MTSItemInfo mTSItemInfo = iterator.next();
            iterator2 = iterator;
            MTSCSPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter, mTSItemInfo);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.write(0);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] sendSetWishListFail(MapleClient a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.SET_WISHLIST_FAIL.getValue());
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendCSFail(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.FAILED.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendShowBoughtCashItemFail(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        block4: {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            block5: {
                block3: {
                    block2: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
                        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
                        maplePacketLittleEndianWriter3.write(CashShopType.BUY_CSITEM_FAIL.getValue());
                        maplePacketLittleEndianWriter3.writeShort(a2);
                        if (GameSetConstants.MAPLE_VERSION != 118 && GameSetConstants.MAPLE_VERSION != 119) break block2;
                        if (a2 == 208) break block3;
                        if (a2 != 207) break block4;
                        maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                        break block5;
                    }
                    if (a2 != 194 && a2 != 193) break block4;
                }
                maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            }
            maplePacketLittleEndianWriter2.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] addToCartMessage(boolean a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        if (a3) {
            if (a2) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter3;
                maplePacketLittleEndianWriter3.write(41);
                maplePacketLittleEndianWriter3.writeInt(-1);
            } else {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.write(40);
            }
        } else {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
            if (a2) {
                maplePacketLittleEndianWriter5.write(39);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter6;
                maplePacketLittleEndianWriter6.writeInt(-1);
            } else {
                maplePacketLittleEndianWriter5.write(38);
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] setWishList(MapleCharacter a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.WISH_LIST_UPDATE.getValue());
        int[] arrn = a2.getWishlist();
        int n3 = n2 = 0;
        while (n3 < 10) {
            maplePacketLittleEndianWriter.writeInt(arrn[n2] != -1 ? arrn[n2] : 0);
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSWantedListingOver(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(61);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    private static final /* synthetic */ void ALLATORIxDEMO(MaplePacketLittleEndianWriter a2, MTSStorage.MTSItemInfo a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
        MTSStorage.MTSItemInfo mTSItemInfo = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
        MTSStorage.MTSItemInfo mTSItemInfo2 = a3;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = a2;
        PacketHelper.addItemInfo(maplePacketLittleEndianWriter4, a3.getItem());
        maplePacketLittleEndianWriter4.writeInt(a3.getId());
        a2.writeInt(mTSItemInfo2.getTaxes());
        maplePacketLittleEndianWriter3.writeInt(mTSItemInfo2.getPrice());
        maplePacketLittleEndianWriter3.writeInt(a3.getItem().getQuantity());
        maplePacketLittleEndianWriter2.writeLong(0L);
        maplePacketLittleEndianWriter2.writeLong(KoreanDateUtil.getQuestTimestamp(a3.getEndingDate()));
        a2.writeMapleAsciiString(mTSItemInfo.getSeller());
        maplePacketLittleEndianWriter.writeMapleAsciiString(mTSItemInfo.getSeller());
        maplePacketLittleEndianWriter.writeZeroBytes(28);
    }

    public static final /* synthetic */ byte[] getMTSConfirmCancel() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(34);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBoughtCashItem(int a2, int a3, int a4, int a5, int a6, String a7, long a8) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.BUY.getValue());
        MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter2, a4, a5, a2, a3, a6, a7, a8);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] showBoughtCSQuestItem(int a2, short a3, byte a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter4.write(CashShopType.BUY_CS_QUSET_ITEM.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter3.writeShort(a3);
        maplePacketLittleEndianWriter2.writeShort(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendWEB(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_WEB.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showRandomRecommend(List<CashItem> a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<CashItem> list = a2;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_RANDOM_RECOMMEND.getValue());
        maplePacketLittleEndianWriter.writeInt(list.size());
        for (CashItem cashItem : list) {
            if (cashItem == null) continue;
            maplePacketLittleEndianWriter.writeInt(cashItem.getSN());
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSFailBuy() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(51);
        maplePacketLittleEndianWriter2.write(66);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendWishList(MapleCharacter a2, boolean a32) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(a32 ? CashShopType.WISH_LIST_UPDATE.getValue() : CashShopType.WISH_LIST.getValue());
        int[] a32 = a2.getWishlist();
        int n3 = n2 = 0;
        while (n3 < 10) {
            maplePacketLittleEndianWriter.writeInt(a32[n2] != -1 ? a32[n2] : 0);
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] confirmToCSInventory(IItem a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.INV_TO_CS.getValue());
        MTSCSPacket.addCashItemInfo(maplePacketLittleEndianWriter2, a2, a3, a4, true);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendChnageName(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.CHANGE_NAME.getValue());
        maplePacketLittleEndianWriter2.writeShort(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] sendMTS(List<MTSStorage.MTSItemInfo> a2, int a3, int a42, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter5.write(20);
        maplePacketLittleEndianWriter5.writeInt(a6 * 16);
        maplePacketLittleEndianWriter4.writeInt(a2.size());
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a42);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.write(1);
        Iterator<MTSStorage.MTSItemInfo> iterator = a3 = a2.iterator();
        while (iterator.hasNext()) {
            MTSStorage.MTSItemInfo a42 = a3.next();
            iterator = a3;
            MTSCSPacket.ALLATORIxDEMO(maplePacketLittleEndianWriter, a42);
        }
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter6.write(1);
        return maplePacketLittleEndianWriter6.getPacket();
    }

    public static /* synthetic */ byte[] cashItemExpired(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.CASHITEM_EXPIRED.getValue());
        maplePacketLittleEndianWriter2.writeLong(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] increasedInvSlots(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter3.write(CashShopType.INC_SLOT.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeShort(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] useWheel(byte a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.USE_WHEEL.getValue());
        maplePacketLittleEndianWriter2.writeLong(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] showMTSCash(MapleCharacter a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.GET_MTS_TOKENS.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2.getCSPoints(2));
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] changePetFlag(int a2, boolean a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PET_FLAG_CHANGE.getValue());
        maplePacketLittleEndianWriter2.writeLong(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(a4);
        return maplePacketLittleEndianWriter3.getPacket();
    }

    public static /* synthetic */ byte[] increasedStorageSlots(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.INC_SLOT_STORAGE.getValue());
        maplePacketLittleEndianWriter2.writeShort(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public /* synthetic */ MTSCSPacket() {
        MTSCSPacket a2;
    }

    public static /* synthetic */ byte[] sendShowWishListFail(MapleClient a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.SHOW_WISHLIST_FAIL.getValue());
        maplePacketLittleEndianWriter2.write(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void addCashModItem(MaplePacketLittleEndianWriter a, CashModItem a) {
        v0 = a;
        a.writeInt(v0.getSN());
        var2_2 = 0;
        v1 = var3_3 = v0.flags.iterator();
        while (v1.hasNext()) {
            var4_4 = var3_3.next();
            var2_2 = (int)((long)var2_2 | var4_4.getValue());
            v1 = var3_3;
        }
        if (GameSetConstants.MAPLE_VERSION >= 113) {
            v2 = a;
            a.writeInt(var2_2);
        } else {
            a.writeShort(var2_2);
            v2 = a;
        }
        if (v2.flags.contains(CashItemFlag.ITEMID)) {
            a.writeInt(a.getId());
        }
        if (a.flags.contains(CashItemFlag.COUNT)) {
            a.writeShort(a.getCount() == 0 ? 1 : a.getCount());
        }
        if (a.flags.contains(CashItemFlag.PRICE)) {
            a.writeInt(a.getPrice());
        }
        if (a.flags.contains(CashItemFlag.UNK3)) {
            a.write(0);
        }
        if (GameSetConstants.MAPLE_VERSION >= 113 && a.flags.contains(CashItemFlag.PRIORITY)) {
            a.write(a.getPriority());
        }
        if (a.flags.contains(CashItemFlag.PERIOD)) {
            a.writeShort(a.getPeriod());
        }
        if (a.flags.contains(CashItemFlag.UNK6)) {
            a.writeInt(0);
        }
        if (a.flags.contains(CashItemFlag.MESO)) {
            a.writeInt(0);
        }
        if (a.flags.contains(CashItemFlag.UNK8)) {
            a.write(0);
        }
        if (a.flags.contains(CashItemFlag.GENDER)) {
            a.write(a.getGender());
        }
        if (a.flags.contains(CashItemFlag.ONSALE)) {
            a.write(a.isOnSale());
        }
        if (a.flags.contains(CashItemFlag.FLAGE)) {
            a.write(a.getFlage());
        }
        if (a.flags.contains(CashItemFlag.UNK12)) {
            a.write(0);
        }
        if (a.flags.contains(CashItemFlag.UNK13)) {
            a.writeShort(0);
        }
        if (a.flags.contains(CashItemFlag.UNK14)) {
            a.writeShort(0);
        }
        if (a.flags.contains(CashItemFlag.UNK15)) {
            v3 = a;
            v3.write(0);
            v3.write(0);
        }
        if (!a.flags.contains(CashItemFlag.PACKAGEZ)) ** GOTO lbl64
        var3_3 = CashItemFactory.getInstance().getPackageItems(a.getSN());
        v4 = a;
        if (var3_3 == null) {
            v4.write(0);
            v5 = a;
        } else {
            v4.write(var3_3.size());
            v6 = var4_5 = 0;
            while (v6 < var3_3.size()) {
                v7 = var3_3.get(var4_5);
                a.writeInt(((CashItem)v7).getSN());
                v6 = ++var4_5;
            }
lbl64:
            // 2 sources

            v5 = a;
        }
        if (v5.flags.contains(CashItemFlag.UNK17) == false) return;
        a.write(0);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ 5;
        int cfr_ignored_0 = 5 << 4 ^ 5;
        int n5 = n3;
        int n6 = 5 << 3 ^ 2;
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

    public static /* synthetic */ byte[] VegaResult(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.VEGA_SCROLL.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] warpCS(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPEN.getValue());
        PacketHelper.addCharacterInfo(maplePacketLittleEndianWriter2, a2.getPlayer(), true);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ void addCashItemInfo(MaplePacketLittleEndianWriter a2, IItem a3, int a4, int a5, boolean a6) {
        MTSCSPacket.addCashItemInfo(a2, a3.getUniqueId(), a4, a3.getItemId(), a5, a3.getQuantity(), a3.getGiftFrom(), a3.getExpiration(), a6);
    }

    public static /* synthetic */ byte[] showCashShopAcc(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CS_ACCOUNT_NAME.getValue());
        maplePacketLittleEndianWriter2.write(1);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2.getAccountName());
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendMesobagFailed() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.MESOBAG_FAILURE.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendShowBoughtCashPackageFail(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        block4: {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
            block5: {
                block3: {
                    block2: {
                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
                        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
                        maplePacketLittleEndianWriter3.write(CashShopType.BUY_CASHPACKAGE_FAIL.getValue());
                        maplePacketLittleEndianWriter3.writeShort(a2);
                        if (GameSetConstants.MAPLE_VERSION != 118 && GameSetConstants.MAPLE_VERSION != 119) break block2;
                        if (a2 == 208) break block3;
                        if (a2 != 207) break block4;
                        maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
                        break block5;
                    }
                    if (a2 != 194 && a2 != 193) break block4;
                }
                maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            }
            maplePacketLittleEndianWriter2.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getTransferInventory(List<IItem> a2, boolean a3) {
        Iterator<IItem> iterator;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        List<IItem> list = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(30);
        maplePacketLittleEndianWriter.writeInt(list.size());
        int n2 = 0;
        Iterator<IItem> iterator2 = iterator = list.iterator();
        while (iterator2.hasNext()) {
            IItem iItem = iterator.next();
            iterator2 = iterator;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
            PacketHelper.addItemInfo(maplePacketLittleEndianWriter, iItem);
            maplePacketLittleEndianWriter4.writeInt(Integer.MAX_VALUE - n2);
            ++n2;
            maplePacketLittleEndianWriter4.writeInt(110);
            maplePacketLittleEndianWriter3.writeInt(1011);
            maplePacketLittleEndianWriter3.writeZeroBytes(52);
        }
        maplePacketLittleEndianWriter.writeInt(-47 + n2 - 1);
        maplePacketLittleEndianWriter.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] showGifts(MapleClient a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        if (a2 != null && a2.getPlayer() != null && a2.getPlayer().getCashInventory() != null) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter;
            maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
            maplePacketLittleEndianWriter2.write(CashShopType.GIFT_GET.getValue());
            Object object = a2.getPlayer().getCashInventory().loadGifts(a2);
            int n2 = 0;
            maplePacketLittleEndianWriter2.writeShort(object.size());
            object = object.iterator();
            while (object.hasNext()) {
                ++n2;
                Pair pair = (Pair)object.next();
                maplePacketLittleEndianWriter.writeLong(((IItem)pair.getLeft()).getUniqueId());
                maplePacketLittleEndianWriter.writeInt(((IItem)pair.getLeft()).getItemId());
                maplePacketLittleEndianWriter.writeAsciiString(((IItem)pair.getLeft()).getGiftFrom(), GameSetConstants.WRITE_STRING_LENGTH);
                maplePacketLittleEndianWriter.writeAsciiString((String)pair.getRight(), 74);
                if (GameSetConstants.MAPLE_VERSION != 75) continue;
                maplePacketLittleEndianWriter.write(0);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] ViciousHammer(boolean a2, int a3) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.VICIOUS_HAMMER_CASH.getValue());
        int n3 = 61;
        int n4 = 65;
        int n5 = 0;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n3 = 80;
            n4 = 84;
            n2 = a3;
        } else if (GameSetConstants.MAPLE_VERSION >= 151) {
            n3 = 76;
            n4 = 80;
            n2 = a3;
        } else if (GameSetConstants.MAPLE_VERSION >= 149) {
            n3 = 74;
            n4 = 78;
            n2 = a3;
        } else if (GameSetConstants.MAPLE_VERSION >= 147) {
            n3 = 75;
            n4 = 79;
            n2 = a3;
        } else if (GameSetConstants.MAPLE_VERSION >= 143) {
            n3 = 73;
            n4 = 77;
            n2 = a3;
        } else if (GameSetConstants.MAPLE_VERSION >= 139) {
            n3 = 72;
            n4 = 76;
            n2 = a3;
        } else {
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                n3 = 69;
                n4 = 73;
            }
            n2 = a3;
        }
        if (n2 == 1) {
            ++n4;
            n5 = 2;
        }
        maplePacketLittleEndianWriter.write(a2 ? n3 : n4);
        maplePacketLittleEndianWriter.writeInt(n5);
        if (a2) {
            maplePacketLittleEndianWriter.writeInt(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendShowWishList(MapleCharacter a2) {
        int n2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(CashShopType.WISH_LIST.getValue());
        int[] arrn = a2.getWishlist();
        int n3 = n2 = 0;
        while (n3 < 10) {
            maplePacketLittleEndianWriter.writeInt(arrn[n2] != -1 ? arrn[n2] : 0);
            n3 = ++n2;
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSConfirmBuy() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(50);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] getMTSConfirmSell() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.MTS_OPERATION.getValue());
        maplePacketLittleEndianWriter2.write(28);
        return maplePacketLittleEndianWriter2.getPacket();
    }
}

