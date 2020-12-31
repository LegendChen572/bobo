/*
 * Decompiled with CFR 0.150.
 */
package tools.data;

import constants.ServerConstants;
import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import tools.EmojiFilter;
import tools.data.ByteArrayByteStream;

public class LittleEndianAccessor {
    private final /* synthetic */ ByteArrayByteStream ALLATORIxDEMO;

    public final /* synthetic */ Point readLastPos() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.unReadInt();
        short s2 = littleEndianAccessor.readShort();
        short s3 = littleEndianAccessor.readShort();
        return new Point(s2, s3);
    }

    public final /* synthetic */ void seek(long a22) {
        try {
            LittleEndianAccessor a3;
            a3.ALLATORIxDEMO.seek(a22);
            return;
        }
        catch (IOException a22) {
            System.err.println("Seek failed" + a22);
            return;
        }
    }

    public final /* synthetic */ int readInt() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n3 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n4 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return (littleEndianAccessor.ALLATORIxDEMO.readByte() << 24) + (n4 << 16) + (n3 << 8) + n2;
    }

    public final /* synthetic */ long available() {
        LittleEndianAccessor a2;
        return a2.ALLATORIxDEMO.available();
    }

    public final /* synthetic */ float readFloat() {
        LittleEndianAccessor a2;
        return Float.intBitsToFloat(a2.readInt());
    }

    public final /* synthetic */ void unReadByte() {
        LittleEndianAccessor a2;
        a2.ALLATORIxDEMO.unReadByte();
    }

    public final /* synthetic */ int readLastInt() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.unReadInt();
        int n2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n3 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n4 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return (littleEndianAccessor.ALLATORIxDEMO.readByte() << 24) + (n4 << 16) + (n3 << 8) + n2;
    }

    public final /* synthetic */ double readDouble() {
        LittleEndianAccessor a2;
        return Double.longBitsToDouble(a2.readLong());
    }

    public final /* synthetic */ short readShort() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return (short)((littleEndianAccessor.ALLATORIxDEMO.readByte() << 8) + n2);
    }

    public final /* synthetic */ short readLastShort() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.unReadShort();
        int n2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return (short)((littleEndianAccessor.ALLATORIxDEMO.readByte() << 8) + n2);
    }

    public final /* synthetic */ long getPosition() {
        LittleEndianAccessor a2;
        return a2.ALLATORIxDEMO.getPosition();
    }

    public final /* synthetic */ String toString(boolean a2) {
        LittleEndianAccessor a3;
        return a3.ALLATORIxDEMO.toString(a2);
    }

    public final /* synthetic */ long readLong() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        long l2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l3 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l4 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l5 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l6 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l7 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l8 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return ((long)littleEndianAccessor.ALLATORIxDEMO.readByte() << 56) + (l8 << 48) + (l7 << 40) + (l6 << 32) + (l5 << 24) + (l4 << 16) + (l3 << 8) + l2;
    }

    public final /* synthetic */ byte[] readLastBytes(int a2) {
        int n2;
        LittleEndianAccessor a3;
        int n3;
        int n4 = n3 = 0;
        while (n4 < a2) {
            a3.ALLATORIxDEMO.unReadByte();
            n4 = ++n3;
        }
        byte[] arrby = new byte[a2];
        int n5 = n2 = 0;
        while (n5 < a2) {
            arrby[n2++] = a3.readByte();
            n5 = n2;
        }
        return arrby;
    }

    public final /* synthetic */ long readUInt() {
        LittleEndianAccessor a2;
        int n2 = a2.readInt();
        long l2 = 0L;
        if (n2 < 0) {
            l2 += 0x80000000L;
        }
        return (long)(n2 & Integer.MAX_VALUE) + l2;
    }

    public final /* synthetic */ int readUShort() {
        LittleEndianAccessor a2;
        return a2.readShortAsInt();
    }

    public final /* synthetic */ byte[] read(int a2) {
        int n2;
        byte[] arrby = new byte[a2];
        int n3 = n2 = 0;
        while (n3 < a2) {
            LittleEndianAccessor a3;
            arrby[n2++] = a3.readByte();
            n3 = n2;
        }
        return arrby;
    }

    public /* synthetic */ int readByteAsInt() {
        LittleEndianAccessor a2;
        return a2.ALLATORIxDEMO.readByte();
    }

    public final /* synthetic */ String readLastAsciiString(int a2) {
        byte[] arrby;
        LittleEndianAccessor a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2) {
            a3.unReadByte();
            n3 = ++n2;
        }
        try {
            int n4;
            arrby = new byte[a2];
            int n5 = n4 = 0;
            while (n5 < a2) {
                arrby[n4++] = a3.readByte();
                n5 = n4;
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            System.err.println(unsupportedEncodingException);
            return "";
        }
        return new String(arrby, ServerConstants.MAPLE_TYPE.getANSI());
    }

    public final /* synthetic */ long readLastLong() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        littleEndianAccessor.unReadLong();
        int n2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n3 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n4 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        int n5 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l3 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        long l4 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return ((long)littleEndianAccessor.ALLATORIxDEMO.readByte() << 56) + (l4 << 48) + (l3 << 40) + (l2 << 32) + (long)(n5 << 24) + (long)(n4 << 16) + (long)(n3 << 8) + (long)n2;
    }

    public final /* synthetic */ String readAsciiString(int a2) {
        byte[] arrby;
        try {
            int n2;
            arrby = new byte[a2];
            int n3 = n2 = 0;
            while (n3 < a2) {
                LittleEndianAccessor a3;
                arrby[n2++] = a3.readByte();
                n3 = n2;
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            System.err.println(unsupportedEncodingException);
            return "";
        }
        return new String(arrby, ServerConstants.MAPLE_TYPE.getANSI());
    }

    public final /* synthetic */ void unReadShort() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 2) {
            LittleEndianAccessor a2;
            a2.ALLATORIxDEMO.unReadByte();
            n3 = ++n2;
        }
    }

    public final /* synthetic */ String readMapleAsciiString() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        return EmojiFilter.filterEmoji(littleEndianAccessor.readAsciiString(littleEndianAccessor.readShort()));
    }

    public final /* synthetic */ void unReadPos() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 4) {
            LittleEndianAccessor a2;
            a2.ALLATORIxDEMO.unReadByte();
            n3 = ++n2;
        }
    }

    public final /* synthetic */ String toString() {
        LittleEndianAccessor a2;
        return a2.ALLATORIxDEMO.toString();
    }

    public final /* synthetic */ long getBytesRead() {
        LittleEndianAccessor a2;
        return a2.ALLATORIxDEMO.getBytesRead();
    }

    public final /* synthetic */ void unReadInt() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 4) {
            LittleEndianAccessor a2;
            a2.ALLATORIxDEMO.unReadByte();
            n3 = ++n2;
        }
    }

    public final /* synthetic */ Point readPos() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        short s2 = littleEndianAccessor.readShort();
        short s3 = littleEndianAccessor.readShort();
        return new Point(s2, s3);
    }

    public final /* synthetic */ char readChar() {
        LittleEndianAccessor a2;
        return (char)a2.readShort();
    }

    public final /* synthetic */ void skip(int a2) {
        LittleEndianAccessor a3;
        LittleEndianAccessor littleEndianAccessor = a3;
        littleEndianAccessor.seek(littleEndianAccessor.getPosition() + (long)a2);
    }

    public final /* synthetic */ void unRead(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2) {
            LittleEndianAccessor a3;
            a3.ALLATORIxDEMO.unReadByte();
            n3 = ++n2;
        }
    }

    public final /* synthetic */ int readShortAsInt() {
        LittleEndianAccessor a2;
        LittleEndianAccessor littleEndianAccessor = a2;
        int n2 = littleEndianAccessor.ALLATORIxDEMO.readByte();
        return (littleEndianAccessor.ALLATORIxDEMO.readByte() << 8) + n2;
    }

    public /* synthetic */ LittleEndianAccessor(ByteArrayByteStream a2) {
        LittleEndianAccessor a3;
        a3.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ byte readByte() {
        LittleEndianAccessor a2;
        return (byte)a2.ALLATORIxDEMO.readByte();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 2 << 3 ^ 4;
        int cfr_ignored_0 = 4 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 5 << 3 ^ 5;
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

    public final /* synthetic */ void unReadLong() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 8) {
            LittleEndianAccessor a2;
            a2.ALLATORIxDEMO.unReadByte();
            n3 = ++n2;
        }
    }

    public final /* synthetic */ void unReadAsciiString(int a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2) {
            LittleEndianAccessor a3;
            a3.ALLATORIxDEMO.unReadByte();
            n3 = ++n2;
        }
    }

    public final /* synthetic */ String readNullTerminatedAsciiString() {
        int n2;
        byte by;
        LittleEndianAccessor a2;
        Object object = new ByteArrayOutputStream();
        LittleEndianAccessor littleEndianAccessor = a2;
        while ((by = littleEndianAccessor.readByte()) != 0) {
            ((ByteArrayOutputStream)object).write(by);
            littleEndianAccessor = a2;
        }
        byte[] arrby = ((ByteArrayOutputStream)object).toByteArray();
        object = arrby;
        char[] arrc = new char[arrby.length];
        int n3 = n2 = 0;
        while (n3 < ((Object)object).length) {
            int n4 = n2++;
            arrc[n4] = (char)object[n4];
            n3 = n2;
        }
        return String.valueOf(arrc);
    }

    public final /* synthetic */ byte readLastByte() {
        LittleEndianAccessor a2;
        return (byte)a2.ALLATORIxDEMO.readLastByte();
    }
}

