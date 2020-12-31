/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 */
package tools.data;

import client.messages.commands.player.\u61a8\u61a8\u8c37;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessByteStream {
    private final /* synthetic */ RandomAccessFile d;
    private /* synthetic */ long ALLATORIxDEMO;

    public final /* synthetic */ String toString(boolean a2) {
        RandomAccessByteStream a3;
        return a3.toString();
    }

    public final /* synthetic */ long getBytesRead() {
        RandomAccessByteStream a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ long getPosition() throws IOException {
        RandomAccessByteStream a2;
        return a2.d.getFilePointer();
    }

    public final /* synthetic */ long available() {
        try {
            RandomAccessByteStream a2;
            return a2.d.length() - a2.d.getFilePointer();
        }
        catch (IOException iOException) {
            System.err.println("ERROR" + iOException);
            return 0L;
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5;
        int cfr_ignored_0 = 3 ^ 5;
        int n5 = n3;
        int n6 = 4 << 4 ^ (3 << 2 ^ 1);
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

    public /* synthetic */ RandomAccessByteStream(RandomAccessFile a2) {
        RandomAccessByteStream a3;
        RandomAccessByteStream randomAccessByteStream = a3;
        randomAccessByteStream.ALLATORIxDEMO = 0L;
        randomAccessByteStream.d = a2;
    }

    public final /* synthetic */ int readByte() {
        try {
            RandomAccessByteStream a2;
            int n2 = a2.d.read();
            if (n2 == -1) {
                throw new RuntimeException(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)",\u0006/"));
            }
            ++a2.ALLATORIxDEMO;
            return n2;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public final /* synthetic */ byte[] toByteArray() throws IOException {
        int n2;
        RandomAccessByteStream a2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[16384];
        RandomAccessByteStream randomAccessByteStream = a2;
        while ((n2 = randomAccessByteStream.d.read(arrby, 0, arrby.length)) != -1) {
            randomAccessByteStream = a2;
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        byteArrayOutputStream2.flush();
        return byteArrayOutputStream2.toByteArray();
    }

    public final /* synthetic */ void seek(long a2) throws IOException {
        RandomAccessByteStream a3;
        a3.d.seek(a2);
    }
}

