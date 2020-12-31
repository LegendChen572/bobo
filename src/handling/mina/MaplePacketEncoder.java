/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.MessageToByteEncoder
 */
package handling.mina;

import client.MapleClient;
import constants.GameSetConstants;
import handling.SendPacketOpcode;
import handling.channel.handler.AllianceHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import tools.FileoutputUtil;
import tools.HexTool;
import tools.MapleAESOFB;
import tools.StringUtil;
import tools.use.donate;

public class MaplePacketEncoder
extends MessageToByteEncoder<Object> {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public /* synthetic */ void encode(ChannelHandlerContext a2, Object a3, ByteBuf a4) throws Exception {
        if ((a2 = (MapleClient)a2.channel().attr(MapleClient.CLIENT_KEY).get()) != null) {
            Object object;
            Object object2;
            Object object3;
            MapleAESOFB mapleAESOFB = ((MapleClient)a2).getSendCrypto();
            byte[] arrby = (byte[])a3;
            int n2 = (arrby[0] & 0xFF) + ((arrby[1] & 0xFF) << 8);
            arrby = GameSetConstants.getSpecialKeyEncode(arrby, n2);
            String string = SendPacketOpcode.nameOf(n2);
            if (GameSetConstants.LOG_PACKETS && !SendPacketOpcode.isSpamHeader(SendPacketOpcode.valueOf(string))) {
                int n3;
                int n4 = arrby.length;
                object3 = Integer.toHexString(n2).toUpperCase();
                object3 = "0x" + StringUtil.getLeftPaddedStr((String)object3, '0', 4);
                object2 = "";
                int n5 = n3 = 4;
                while (n5 > string.length() / 8) {
                    object2 = (String)object2 + "\t";
                    n5 = --n3;
                }
                object = n4 >= 10 ? (n4 >= 100 ? (n4 >= 1000 ? "" : " ") : AllianceHandler.ALLATORIxDEMO("\u00160")) : donate.ALLATORIxDEMO("fSf");
                StringBuilder stringBuilder = new StringBuilder("[\u767c\u9001]\t" + string + (String)object2 + "\t\u5305\u982d:" + (String)object3 + (String)object + "[" + n4 + "\u5b57\u5143]");
                System.out.println(stringBuilder.toString());
                stringBuilder.append(AllianceHandler.ALLATORIxDEMO(";\u001a;\u001a")).append(HexTool.toString((byte[])a3)).append(donate.ALLATORIxDEMO("~L")).append(HexTool.toStringFromAscii((byte[])a3));
                FileoutputUtil.log("logs/\u6578\u64da\u5305\u6536\u767c/Log.txt", "\r\n\r\n" + stringBuilder.toString() + "\r\n\r\n");
            }
            byte[] arrby2 = new byte[arrby.length];
            System.arraycopy(arrby, 0, arrby2, 0, arrby.length);
            object3 = new byte[arrby2.length + 4];
            object2 = ((MapleClient)a2).getLock();
            object2.lock();
            try {
                object = mapleAESOFB.getPacketHeader(arrby2.length);
                mapleAESOFB.crypt(arrby2);
                System.arraycopy(object, 0, object3, 0, 4);
                System.arraycopy(arrby2, 0, object3, 4, arrby2.length);
                object3 = GameSetConstants.getSpecialKey((byte[])object3);
                a4.writeBytes((byte[])object3);
                return;
            }
            finally {
                object2.unlock();
            }
        }
        byte[] arrby = (byte[])a3;
        arrby = GameSetConstants.getSpecialKey(arrby);
        a4.writeBytes(arrby);
    }

    public /* synthetic */ MaplePacketEncoder() {
        MaplePacketEncoder a2;
    }
}

