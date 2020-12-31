/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.ByteToMessageDecoder
 *  io.netty.util.AttributeKey
 */
package handling.mina;

import client.MapleClient;
import client.inventory.MapleAndroid;
import client.messages.commands.PlayerCommand;
import constants.BanAttackIP;
import constants.GameSetConstants;
import handling.RecvPacketOpcode;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.AttributeKey;
import java.util.List;
import tools.FileoutputUtil;
import tools.HexTool;
import tools.MapleAESOFB;
import tools.data.ByteArrayByteStream;
import tools.data.LittleEndianAccessor;

public class MaplePacketDecoder
extends ByteToMessageDecoder {
    public static final /* synthetic */ AttributeKey<DecoderState> DECODER_STATE_KEY;

    public /* synthetic */ MaplePacketDecoder() {
        MaplePacketDecoder a2;
    }

    public /* synthetic */ void decode(ChannelHandlerContext a2, ByteBuf a3, List<Object> a42) throws Exception {
        ByteBuf byteBuf;
        MapleClient mapleClient = (MapleClient)a2.channel().attr(MapleClient.CLIENT_KEY).get();
        DecoderState decoderState = (DecoderState)a2.channel().attr(DECODER_STATE_KEY).get();
        if (GameSetConstants.PROXY_IP && mapleClient.needDecodeProxyIP()) {
            ByteBuf byteBuf2 = a3;
            byte[] arrby = new byte[byteBuf2.readableBytes()];
            byteBuf2.readBytes(arrby);
            String string = HexTool.toStringFromAscii(arrby);
            String[] arrstring = string.split(" ");
            if (arrstring.length > 3) {
                if (!BanAttackIP.ipban.contains(arrstring[2])) {
                    mapleClient.setDecodeProxyIP(arrstring[2]);
                    BanAttackIP.checkAttackIP((ChannelHandlerContext)a2, arrstring[2]);
                    return;
                }
                a2.channel().close();
            }
            return;
        }
        if (a3.readableBytes() >= 4 && decoderState.packetlength == -1) {
            int n2 = a3.readInt();
            if (GameSetConstants.MAPLE_VERSION != 75 && !mapleClient.getReceiveCrypto().checkPacket(n2)) {
                a2.channel().close();
                return;
            }
            decoderState.packetlength = MapleAESOFB.getPacketLength(n2);
            byteBuf = a3;
        } else {
            if (a3.readableBytes() < 4 && decoderState.packetlength == -1) {
                return;
            }
            byteBuf = a3;
        }
        if (byteBuf.readableBytes() >= decoderState.packetlength) {
            byte[] arrby = new byte[decoderState.packetlength];
            a3.readBytes(arrby);
            decoderState.packetlength = -1;
            if (GameSetConstants.MAPLE_VERSION != 75) {
                mapleClient.getReceiveCrypto().crypt(arrby);
            }
            short s2 = new LittleEndianAccessor(new ByteArrayByteStream(arrby)).readShort();
            arrby = GameSetConstants.getSpecialKeyDecode(arrby, s2);
            a42.add(arrby);
            int n3 = arrby.length;
            a2 = RecvPacketOpcode.nameOf(s2);
            if (GameSetConstants.LOG_PACKETS && !RecvPacketOpcode.isSpamHeader(RecvPacketOpcode.valueOf((String)a2))) {
                a3 = "";
                int n4 = a42 = 4;
                while (n4 > ((String)a2).length() / 8) {
                    a3 = (String)a3 + "\t";
                    n4 = --a42;
                }
                String a42 = n3 >= 10 ? (n3 >= 100 ? (n3 >= 1000 ? "" : " ") : MapleAndroid.ALLATORIxDEMO("S7")) : PlayerCommand.ALLATORIxDEMO(".D.");
                a2 = new StringBuilder("[\u63a5\u6536]\t" + (String)a2 + (String)a3 + "\t\u5305\u982d:" + HexTool.getOpcodeToString(s2) + a42 + "[" + n3 + "\u5b57\u5143]" + HexTool.toString(arrby));
                System.out.println(((StringBuilder)a2).toString());
                ((StringBuilder)a2).append(MapleAndroid.ALLATORIxDEMO("~\u001d~\u001d")).append(HexTool.toString(arrby)).append(PlayerCommand.ALLATORIxDEMO("i\u0004")).append(HexTool.toStringFromAscii(arrby));
                FileoutputUtil.log("logs/\u6578\u64da\u5305\u6536\u767c/Log.txt", "\r\n\r\n" + ((StringBuilder)a2).toString() + "\r\n\r\n");
            }
        }
    }

    public static /* synthetic */ {
        DECODER_STATE_KEY = AttributeKey.valueOf((String)(MaplePacketDecoder.class.getName() + ".STATE"));
    }

    public static class DecoderState {
        public /* synthetic */ int packetlength;

        public /* synthetic */ DecoderState() {
            DecoderState a2;
            a2.packetlength = -1;
        }
    }
}

