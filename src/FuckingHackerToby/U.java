/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.m;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class U
implements m {
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ ServerSocket d;

    public /* synthetic */ void handleException(Exception a2) {
        U u2;
        U a3;
        if (a2 instanceof NullPointerException) {
            System.err.println("Server has not been initialized successfully: " + a2.getMessage());
            u2 = a3;
        } else if (a2 instanceof IOException) {
            System.err.println("Server closed: " + a2.getMessage());
            u2 = a3;
        } else {
            System.err.println("Server error: " + a2.getMessage());
            u2 = a3;
        }
        u2.close();
    }

    public final /* synthetic */ int getPort() {
        U a2;
        return a2.d.getLocalPort();
    }

    @Override
    public /* synthetic */ void close() {
        U a2;
        if (!a2.ALLATORIxDEMO) {
            return;
        }
        a2.ALLATORIxDEMO = false;
        try {
            a2.d.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public /* synthetic */ U(int a22) {
        U a3;
        try {
            a3.d = new ServerSocket(a22);
            a3.ALLATORIxDEMO = true;
            return;
        }
        catch (IOException a22) {
            a3.handleException(a22);
            return;
        }
    }

    @Override
    public final /* synthetic */ boolean isOpen() {
        U a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ Socket acceptConnection() {
        U a2;
        try {
            Socket socket = a2.d.accept();
            return socket;
        }
        catch (IOException | NullPointerException exception) {
            a2.handleException(exception);
            return null;
        }
    }
}

