/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package tools.damageSkin;

import FuckingHackerToby.L;
import client.MapleCharacter;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import database.DBConPool;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import server.Randomizer;
import tools.FixDropNullItem;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.MTSCSPacket;

public class AttackFont {
    public static final /* synthetic */ Map<Integer, Font> all;

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ void LoadAllFont() {
        AttackFont.all.clear();
        druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        preparedStatement = druidPooledConnection.prepareStatement(L.ALLATORIxDEMO("\\JCJL[\u000f\u0005\u000fI]@B\u000fON[[NLDI@A[\\O"));
        v0 = resultSet = preparedStatement.executeQuery();
        while (v0.next()) {
            n2 = resultSet.getInt(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"}Nz"));
            if (!AttackFont.all.containsKey(n2)) {
                AttackFont.all.put(n2, new Font());
            }
            AttackFont.all.get(n2).addFont(resultSet.getInt(L.ALLATORIxDEMO("FK")), resultSet.getInt(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"AqIj")));
            v0 = resultSet;
        }
        preparedStatement.close();
        resultSet.close();
        druidPooledConnection.close();
        ** if (druidPooledConnection == null) goto lbl-1000
lbl-1000:
        // 1 sources

        {
            druidPooledConnection.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
        {
            catch (Throwable throwable) {
                try {
                    block13: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                v1 = throwable;
                                break block13;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        v1 = throwable;
                    }
                    throw v1;
                }
                catch (SQLException sQLException) {
                    System.err.println(sQLException);
                }
            }
        }
    }

    public /* synthetic */ AttackFont() {
        AttackFont a2;
    }

    public static final /* synthetic */ void sendFontStyle(MapleCharacter a2) {
        MapleCharacter mapleCharacter = a2;
        Font font = AttackFont.getFont(mapleCharacter.getId());
        int n2 = mapleCharacter.getAttackFont();
        if (font.fonts.containsKey(n2)) {
            a2.getMap().broadcastMessage(AttackFont.FontStylePacket(a2.getId(), font.fonts.get(n2)));
            return;
        }
        a2.getMap().broadcastMessage(AttackFont.FontStylePacket(a2.getId(), 0));
    }

    public static final /* synthetic */ byte[] FontStylePacket(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(1392);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ Font getFont(int a2) {
        if (!all.containsKey(a2)) {
            all.put(a2, new Font());
        }
        return all.get(a2);
    }

    public static /* synthetic */ {
        all = new ConcurrentHashMap<Integer, Font>();
    }

    public static class Font {
        public final /* synthetic */ HashMap<Integer, Integer> fonts;

        public final /* synthetic */ String getAllFont() {
            Font a2;
            Iterator<Map.Entry<Integer, Integer>> iterator;
            String string = MTSCSPacket.ALLATORIxDEMO("oCL@IQ\u0005gKVCFoCL\u000bCHM\ndJiWC\u0015u");
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Map.Entry<Integer, Integer>> iterator2 = iterator = a2.fonts.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                iterator2 = iterator;
                stringBuffer.append(FixDropNullItem.ALLATORIxDEMO("\u0015\n"));
                stringBuffer.append(entry.getKey());
                stringBuffer.append(MTSCSPacket.ALLATORIxDEMO("\t"));
                stringBuffer.append(FixDropNullItem.ALLATORIxDEMO("\u0015 "));
                stringBuffer.append(MTSCSPacket.ALLATORIxDEMO("oCL@IQ\u0005gKVCFoCL\u000bCHM\ndJiWC\u0015u"));
                stringBuffer.append(entry.getValue());
                stringBuffer.append(FixDropNullItem.ALLATORIxDEMO("i\u0006e"));
            }
            return stringBuffer.toString();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        public final /* synthetic */ boolean insertFont(int a, int a) {
            var3_3 = false;
            var4_4 = DBConPool.getInstance().getDataSource().getConnection();
            try {
                v0 = var5_6 = var4_4.prepareStatement(MTSCSPacket.ALLATORIxDEMO("CKY@XQ\nLDQE\u0005JD^QKFACEK^VJ\u0005\u0002EILNE\u0006\u0005JCEK^E\u0003\u0005\\DFPOV\n\r\u0015\t\n\u001a\u0003"), 1);
                v0.setInt(1, a);
                v0.setInt(2, a);
                v0.executeUpdate();
                var6_8 = var5_6.getGeneratedKeys();
                if (var6_8.next()) {
                    var3_3 = true;
                    var7_10 = var6_8.getInt(1);
                    a.fonts.put(var7_10, a);
                }
                var5_6.close();
                var6_8.close();
                var4_4.close();
                ** if (var4_4 == null) goto lbl-1000
            }
            catch (Throwable var5_7) {
                if (var4_4 == null) ** GOTO lbl32
                try {
                    var4_4.close();
                    v1 = var5_7;
                    ** GOTO lbl33
                }
                catch (Throwable var6_9) {
                    try {
                        var5_7.addSuppressed(var6_9);
lbl32:
                        // 2 sources

                        v1 = var5_7;
lbl33:
                        // 2 sources

                        throw v1;
                    }
                    catch (SQLException var4_5) {
                        System.err.println(var4_5);
                    }
                }
            }
lbl-1000:
            // 1 sources

            {
                var4_4.close();
            }
lbl-1000:
            // 2 sources

            {
            }
            return var3_3;
        }

        public final /* synthetic */ boolean isHaveFont(int a2) {
            Font a3;
            Iterator<Map.Entry<Integer, Integer>> iterator = a3.fonts.entrySet().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getValue() != a2) continue;
                return true;
            }
            return false;
        }

        public /* synthetic */ int getFontByValue(int a2) {
            Font a3;
            for (Map.Entry<Integer, Integer> entry : a3.fonts.entrySet()) {
                if (entry.getValue() != a2) continue;
                return entry.getKey();
            }
            return 0;
        }

        public final /* synthetic */ int getRandomFont() {
            Font a2;
            List<Integer> list = a2.getAllFontList();
            int n2 = Randomizer.rand(0, list.size() - 1);
            return list.get(n2);
        }

        public /* synthetic */ Font() {
            Font a2;
            a2.fonts = new HashMap();
            a2.fonts.put(0, 0);
        }

        public final /* synthetic */ List<Integer> getAllFontList() {
            Font a2;
            Iterator<Integer> iterator;
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            Iterator<Integer> iterator2 = iterator = a2.fonts.values().iterator();
            while (iterator2.hasNext()) {
                int n2 = iterator.next();
                iterator2 = iterator;
                linkedList.add(n2);
            }
            return linkedList;
        }

        public /* synthetic */ void addFont(int a2, int a3) {
            Font a4;
            a4.fonts.put(a2, a3);
        }
    }
}

