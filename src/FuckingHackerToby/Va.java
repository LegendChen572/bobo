/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.m;
import FuckingHackerToby.na;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Va
implements m {
    private /* synthetic */ DataOutputStream d;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int B;
    private /* synthetic */ int k;
    private /* synthetic */ DataInputStream a;
    private /* synthetic */ Socket K;
    private /* synthetic */ String g;

    public /* synthetic */ short ALLATORIxDEMO() {
        Va a2;
        try {
            short s2 = a2.a.readShort();
            return s2;
        }
        catch (Exception exception) {
            a2.ALLATORIxDEMO(exception);
            return 0;
        }
    }

    public final /* synthetic */ String ALLATORIxDEMO() {
        Va a2;
        return a2.g;
    }

    public /* synthetic */ Va(Socket a22) {
        Va a3;
        Va va2 = a3;
        Socket socket = a22;
        a3.K = a22;
        a3.g = socket.getInetAddress().getHostAddress();
        va2.B = socket.getPort();
        va2.k = a22.getLocalPort();
        try {
            a3.ALLATORIxDEMO(a22);
            return;
        }
        catch (IOException a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public /* synthetic */ byte ALLATORIxDEMO() {
        try {
            Va a2;
            byte by = a2.a.readByte();
            return by;
        }
        catch (Exception exception) {
            na.ALLATORIxDEMO = false;
            return 0;
        }
    }

    public /* synthetic */ long ALLATORIxDEMO() {
        Va a2;
        try {
            long l2 = a2.a.readLong();
            return l2;
        }
        catch (Exception exception) {
            a2.ALLATORIxDEMO(exception);
            return 0L;
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(Exception a2) {
        Va va2;
        Va a3;
        if (a2 instanceof NullPointerException) {
            System.err.println("Tried to close connection but it already is: " + a2.getMessage());
            va2 = a3;
        } else if (a2 instanceof IOException) {
            System.err.println("Connection closed: " + a2.getMessage());
            va2 = a3;
        } else {
            System.err.println("Connection error: " + a2.getMessage());
            va2 = a3;
        }
        va2.close();
    }

    public /* synthetic */ Va(String a22, int a3) {
        Va a4;
        Va va2 = a4;
        va2.g = a22;
        va2.B = a3;
        try {
            Va va3 = a4;
            va3.K = new Socket(a22, a3);
            va3.k = va3.K.getLocalPort();
            va3.ALLATORIxDEMO(va3.K);
            return;
        }
        catch (IOException a22) {
            return;
        }
    }

    public /* synthetic */ String H() {
        Va a2;
        try {
            String string = a2.a.readUTF();
            return string;
        }
        catch (Exception exception) {
            a2.ALLATORIxDEMO(exception);
            return null;
        }
    }

    @Override
    public final /* synthetic */ boolean isOpen() {
        Va a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void ALLATORIxDEMO(byte a22) {
        Va a3;
        try {
            Va va2 = a3;
            va2.d.writeByte(a22);
            va2.d.flush();
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public /* synthetic */ int l() {
        Va a2;
        try {
            return a2.a.available();
        }
        catch (Exception exception) {
            a2.ALLATORIxDEMO(exception);
            return 0;
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(int a22) {
        Va a3;
        try {
            Va va2 = a3;
            va2.d.writeInt(a22);
            va2.d.flush();
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public final /* synthetic */ int ALLATORIxDEMO() {
        Va a2;
        return a2.k;
    }

    public /* synthetic */ void ALLATORIxDEMO(long a22) {
        Va a3;
        try {
            Va va2 = a3;
            va2.d.writeLong(a22);
            va2.d.flush();
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(byte[] a22) {
        Va a3;
        try {
            a3.a.readFully(a22);
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public final /* synthetic */ int H() {
        Va a2;
        return a2.B;
    }

    public /* synthetic */ void H(byte[] a22) {
        Va a3;
        try {
            Va va2 = a3;
            va2.d.write(a22);
            va2.d.flush();
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public /* synthetic */ byte[] ALLATORIxDEMO() {
        Va a2;
        try {
            Va va2 = a2;
            int n2 = va2.a.available();
            byte[] arrby = new byte[n2];
            va2.a.readFully(arrby);
            return arrby;
        }
        catch (Exception exception) {
            a2.ALLATORIxDEMO(exception);
            return null;
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(Socket a2) throws IOException {
        Va a3;
        Va va2 = a3;
        Va va3 = a3;
        va2.a = new DataInputStream(a2.getInputStream());
        va2.d = new DataOutputStream(a2.getOutputStream());
        va2.ALLATORIxDEMO = true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public /* synthetic */ void close() {
        if (!a.ALLATORIxDEMO) {
            return;
        }
        a.ALLATORIxDEMO = false;
        try {
            a.a.close();
            v0 = a;
            ** GOTO lbl11
        }
        catch (Exception var1_1) {
            try {
                v0 = a;
lbl11:
                // 2 sources

                v0.d.close();
                v1 = a;
                ** GOTO lbl17
            }
            catch (Exception var1_2) {
                try {
                    v1 = a;
lbl17:
                    // 2 sources

                    v1.K.close();
                    return;
                }
                catch (Exception var1_3) {
                    return;
                }
            }
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(String a22) {
        Va a3;
        try {
            Va va2 = a3;
            va2.d.writeUTF(a22);
            va2.d.flush();
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(short a22) {
        Va a3;
        try {
            Va va2 = a3;
            va2.d.writeShort(a22);
            va2.d.flush();
            return;
        }
        catch (Exception a22) {
            a3.ALLATORIxDEMO(a22);
            return;
        }
    }

    public /* synthetic */ int D() {
        Va a2;
        try {
            int n2 = a2.a.readInt();
            return n2;
        }
        catch (Exception exception) {
            a2.ALLATORIxDEMO(exception);
            return 0;
        }
    }
}

