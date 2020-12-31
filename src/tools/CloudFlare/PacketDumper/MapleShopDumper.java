/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  constants.ItemConstants$\u985e\u578b
 */
package tools.CloudFlare.PacketDumper;

import client.inventory.InventoryException;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import constants.ItemConstants;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import server.MapleItemInformationProvider;
import tools.FileoutputUtil;
import tools.HexTool;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;

public class MapleShopDumper {
    private /* synthetic */ int ALLATORIxDEMO;

    public static /* synthetic */ String printShopItem(int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9) {
        return "INSERT INTO `shopitems` (`shopid`, `itemid`, `price`, `pitch`, `reqitem`,`reqitemq`,`position`, `reqitem2`,`reqitemq2`,`category`,`expiration`,`friends`,`friendpoints`,`minlevel`,`maxlevel`) VALUES (" + a2 + ", " + a3 + ", " + a4 + ", 0, " + a5 + ", " + a6 + ", 0,0,0,0," + a7 + ",0,0," + a8 + "," + a9 + ");\r\n";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void main(String[] a2) throws IOException {
        int n2;
        int n3;
        System.out.println(InventoryException.ALLATORIxDEMO("kYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBpBZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAYkYAZAZAZAZBYAYAZAYAZAZBYAYBYAYBYAYBZAYBYAZAZAZAZBpBZAZAZAZBZBZBZAZBZAZBZBZAYAZBZBZBZBZAYAZAZAZAZAYkYAZAZAZAYBYAYAZAYAZAYBYAZBZAYAYAYBZAZBZAZAZAZAZBpBZAZAZAZBZBZBYBZBYBZBZBZAYAZBYBZBZBZBYBZAZAZAZAYkYAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZBpBZ.\u0018\u0007\u000f\u0012\u0019\u0000\u000e\b\u0015\u000fZ\u0003\u0003A;\r\u0016\u0000\u000e\u000e\b\bZ.\u0018\u0007\u000f\u0012\u0019\u0000\u000e\u000e\bA\fVTRZ%?,5AYkYAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZBpBZAZAZAZAZAZ\t\u000e\u0015\n[UN\r\u0016\rO\u001b\r\u0016\u0000\u000e\u000e\b\bT\u0002\u0015\fZAZAZAZAZAZAYkYAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZAZBpBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYBYk"));
        MapleItemInformationProvider.getInstance().loadItems(false);
        Properties properties = new Properties();
        Object object = new FileInputStream(MonsterPetSystem.ALLATORIxDEMO("\u5c59\u5356v' '"));
        try {
            properties.load((InputStream)object);
        }
        catch (Throwable throwable) {
            Throwable throwable2;
            try {
                ((FileInputStream)object).close();
                throwable2 = throwable;
                throw throwable2;
            }
            catch (Throwable throwable3) {
                try {
                    Throwable throwable4 = throwable;
                    throwable2 = throwable4;
                    throwable4.addSuppressed(throwable3);
                    throw throwable2;
                }
                catch (IOException iOException) {
                    FileoutputUtil.logToFile(InventoryException.ALLATORIxDEMO("\u8999\u5c60\u537fN\u553c\u5ef6U\u0004\b\u0013\u0015\u0013U,\u001b\u0011\u0016\u0004)\t\u0015\u0011>\u0014\u0017\u0011\u001f\u0013T\u0015\u0002\u0015"), iOException.getMessage());
                }
            }
        }
        ((FileInputStream)object).close();
        object = new StringBuilder();
        byte[] arrby = HexTool.getByteArrayFromHexString(properties.getProperty(MonsterPetSystem.ALLATORIxDEMO("(2;8")));
        LittleEndianAccessor littleEndianAccessor = new LittleEndianAccessor(new ByteArrayByteStream(arrby));
        int n4 = littleEndianAccessor.readInt();
        ((StringBuilder)object).append("DELETE FROM `shops` WHERE `npcid` = " + n4 + ";\r\n");
        ((StringBuilder)object).append("DELETE FROM `shopitems` WHERE `shopid` = " + n4 + ";\r\n");
        int n5 = n4;
        ((StringBuilder)object).append("INSERT INTO `shops` (`shopid`, `npcid`) VALUES ('" + n5 + "', '" + n5 + "');\r\n");
        littleEndianAccessor.readByte();
        littleEndianAccessor.readInt();
        littleEndianAccessor.readInt();
        littleEndianAccessor.readByte();
        littleEndianAccessor.readInt();
        int n6 = littleEndianAccessor.readByte();
        int n7 = 0;
        int n8 = n7;
        while (n8 < n6) {
            n3 = littleEndianAccessor.readByte();
            int n9 = n2 = 0;
            while (n9 < n3) {
                littleEndianAccessor.readInt();
                littleEndianAccessor.readMapleAsciiString();
                n9 = ++n2;
            }
            n8 = ++n7;
        }
        littleEndianAccessor.readInt();
        littleEndianAccessor.readInt();
        littleEndianAccessor.readInt();
        n7 = littleEndianAccessor.readShort();
        n3 = 0;
        int n10 = n3;
        while (n10 < n7) {
            LittleEndianAccessor littleEndianAccessor2;
            int n11;
            int n12;
            int n13;
            LittleEndianAccessor littleEndianAccessor3 = littleEndianAccessor;
            littleEndianAccessor.readInt();
            n2 = littleEndianAccessor.readInt();
            int n14 = littleEndianAccessor3.readInt();
            littleEndianAccessor3.readInt();
            LittleEndianAccessor littleEndianAccessor4 = littleEndianAccessor;
            n14 = littleEndianAccessor4.readInt();
            int n15 = littleEndianAccessor4.readInt();
            n15 = littleEndianAccessor4.readInt();
            int n16 = littleEndianAccessor4.readInt();
            int n17 = littleEndianAccessor4.readInt();
            int n18 = littleEndianAccessor4.readInt();
            n18 = littleEndianAccessor4.readInt();
            littleEndianAccessor4.readInt();
            int n19 = n18 = littleEndianAccessor3.readByte() == 1 ? 1 : 0;
            if (n18 != 0) {
                littleEndianAccessor.readInt();
                littleEndianAccessor.readByte();
                littleEndianAccessor.readByte();
                littleEndianAccessor.readMapleAsciiString();
                littleEndianAccessor.readInt();
                littleEndianAccessor.readMapleAsciiString();
                littleEndianAccessor.readLong();
                littleEndianAccessor.readLong();
                n18 = littleEndianAccessor.readInt();
                n13 = 0;
                int n20 = n13;
                while (n20 < n18) {
                    littleEndianAccessor.readLong();
                    n20 = ++n13;
                }
            }
            LittleEndianAccessor littleEndianAccessor5 = littleEndianAccessor;
            n18 = littleEndianAccessor5.readInt();
            n13 = littleEndianAccessor5.readInt();
            n18 = littleEndianAccessor5.readInt();
            n18 = littleEndianAccessor5.readShort();
            n13 = littleEndianAccessor5.readShort();
            if (littleEndianAccessor5.readByte() == 3) {
                n12 = littleEndianAccessor.readInt();
                int n21 = n11 = 0;
                while (n21 < n12) {
                    littleEndianAccessor.readLong();
                    n21 = ++n11;
                }
            }
            littleEndianAccessor.readByte();
            LittleEndianAccessor littleEndianAccessor6 = littleEndianAccessor;
            littleEndianAccessor.readLong();
            littleEndianAccessor6.readLong();
            littleEndianAccessor6.readInt();
            littleEndianAccessor.readShort();
            littleEndianAccessor.readByte();
            littleEndianAccessor.readInt();
            littleEndianAccessor.readMapleAsciiString();
            littleEndianAccessor.readInt();
            littleEndianAccessor.readInt();
            littleEndianAccessor.readByte();
            LittleEndianAccessor littleEndianAccessor7 = littleEndianAccessor;
            if (ItemConstants.\u985e\u578b.\u53ef\u5145\u503c\u9053\u5177((int)n2)) {
                littleEndianAccessor7.readDouble();
                littleEndianAccessor2 = littleEndianAccessor;
            } else {
                littleEndianAccessor7.readShort();
                littleEndianAccessor2 = littleEndianAccessor;
            }
            littleEndianAccessor2.readShort();
            LittleEndianAccessor littleEndianAccessor8 = littleEndianAccessor;
            littleEndianAccessor8.readLong();
            littleEndianAccessor8.readInt();
            littleEndianAccessor.readInt();
            littleEndianAccessor.readMapleAsciiString();
            littleEndianAccessor.readMapleAsciiString();
            n12 = 0;
            int n22 = n12;
            while (n22 < 4) {
                littleEndianAccessor.readInt();
                n22 = ++n12;
            }
            int[] arrn = new int[5];
            arrn[0] = 9410165;
            arrn[1] = 9410166;
            arrn[2] = 9410167;
            arrn[3] = 9410168;
            arrn[4] = 9410198;
            int[] arrn2 = arrn;
            int n23 = n11 = 0;
            while (n23 < arrn2.length) {
                littleEndianAccessor.readInt();
                littleEndianAccessor.readInt();
                n23 = ++n11;
            }
            if (n6 > 0) {
                int n24 = n11 = littleEndianAccessor.readByte() >= 1 ? 1 : 0;
                if (n11 != 0) {
                    littleEndianAccessor.readByte();
                }
            }
            littleEndianAccessor.readByte();
            if (n15 > 0) {
                ((StringBuilder)object).append(MapleShopDumper.printShopItem(n4, n2, n15, n16, n17, n14, n18, n13));
            }
            System.out.println("itemid :" + n2 + " price :" + n15 + " itemminlevel:" + n18 + " itemmaxlevel: " + n13);
            n10 = ++n3;
        }
        FileoutputUtil.logToFile("\u89e3\u5c01\u5305/\u5546\u5e97/" + n4 + ".sql", ((StringBuilder)object).toString());
    }

    public /* synthetic */ MapleShopDumper() {
        MapleShopDumper a2;
        a2.ALLATORIxDEMO = 228;
    }
}

