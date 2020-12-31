/*
 * Decompiled with CFR 0.150.
 */
package tools.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import server.MapleDueyActions;

public class InputStreamByteStream {
    private /* synthetic */ long ALLATORIxDEMO;
    private final /* synthetic */ InputStream d;

    public final /* synthetic */ long available() {
        try {
            InputStreamByteStream a2;
            return a2.d.available();
        }
        catch (IOException iOException) {
            System.err.println("ERROR" + iOException);
            return 0L;
        }
    }

    public final /* synthetic */ long getBytesRead() {
        InputStreamByteStream a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ byte[] toByteArray() throws IOException {
        int n2;
        InputStreamByteStream a2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] arrby = new byte[16384];
        InputStreamByteStream inputStreamByteStream = a2;
        while ((n2 = inputStreamByteStream.d.read(arrby, 0, arrby.length)) != -1) {
            inputStreamByteStream = a2;
            byteArrayOutputStream.write(arrby, 0, n2);
        }
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        byteArrayOutputStream2.flush();
        return byteArrayOutputStream2.toByteArray();
    }

    public final /* synthetic */ int readByte() {
        try {
            InputStreamByteStream a2;
            int n2 = a2.d.read();
            if (n2 == -1) {
                throw new RuntimeException(MapleDueyActions.ALLATORIxDEMO("\u0012y\u0011"));
            }
            ++a2.ALLATORIxDEMO;
            return n2;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    public final /* synthetic */ String toString(boolean a2) {
        InputStreamByteStream a3;
        return a3.toString();
    }

    public /* synthetic */ InputStreamByteStream(InputStream a2) {
        InputStreamByteStream a3;
        InputStreamByteStream inputStreamByteStream = a3;
        inputStreamByteStream.ALLATORIxDEMO = 0L;
        inputStreamByteStream.d = a2;
    }
}

