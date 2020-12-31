/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.apache.commons.codec.DecoderException
 *  org.apache.commons.codec.binary.Hex
 */
package tools.npcgenerator;

import client.messages.ConsoleCommandObject;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class Reader {
    private /* synthetic */ StringBuilder ALLATORIxDEMO;

    public /* synthetic */ int readInt() {
        Reader a2;
        return (int)Long.parseLong(a2.ALLATORIxDEMO(6, 8) + a2.ALLATORIxDEMO(4, 6) + a2.ALLATORIxDEMO(2, 4) + a2.ALLATORIxDEMO(0, 2), 16);
    }

    public /* synthetic */ Reader(String a2) {
        Reader a3;
        Reader reader = a3;
        reader.ALLATORIxDEMO = new StringBuilder(a2.replace(" ", ""));
    }

    private /* synthetic */ String ALLATORIxDEMO(int a2, int a3) {
        Reader a4;
        Reader reader = a4;
        String string = reader.ALLATORIxDEMO.substring(a2, a3);
        reader.ALLATORIxDEMO = reader.ALLATORIxDEMO.delete(a2, a3);
        return string;
    }

    public /* synthetic */ String readMapleString() throws DecoderException, UnsupportedEncodingException {
        Reader a2;
        short s2 = a2.readShort();
        return new String(Hex.decodeHex((char[])a2.ALLATORIxDEMO(0, s2 * 2).toCharArray()), ConsoleCommandObject.ALLATORIxDEMO("InZ\u0002"));
    }

    public /* synthetic */ byte readByte() {
        Reader a2;
        return Byte.parseByte(a2.ALLATORIxDEMO(0, 2), 16);
    }

    public /* synthetic */ long readLong() {
        Reader a2;
        return Long.parseLong(a2.ALLATORIxDEMO(14, 16) + a2.ALLATORIxDEMO(12, 14) + a2.ALLATORIxDEMO(10, 12) + a2.ALLATORIxDEMO(8, 10) + a2.ALLATORIxDEMO(6, 8) + a2.ALLATORIxDEMO(4, 6) + a2.ALLATORIxDEMO(2, 4) + a2.ALLATORIxDEMO(0, 2), 16);
    }

    public /* synthetic */ short readShort() {
        Reader a2;
        return Short.parseShort(a2.ALLATORIxDEMO(2, 4) + a2.ALLATORIxDEMO(0, 2), 16);
    }

    public /* synthetic */ void skip(int a2) {
        Reader a3;
        a3.ALLATORIxDEMO(0, a2 * 2);
    }
}

