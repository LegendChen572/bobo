/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6070\u6070\u8c37
 */
package FuckingHackerToby;

import FuckingHackerToby.T;
import FuckingHackerToby.Va;
import FuckingHackerToby.j;
import client.messages.commands.player.\u6070\u6070\u8c37;
import de.sogomn.rat.IConnectionObserver;
import handling.world.CharacterTransfer;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public final class ta
extends Va {
    private /* synthetic */ LinkedBlockingQueue<j> K;
    private /* synthetic */ Thread a;
    private /* synthetic */ Thread d;
    private /* synthetic */ IConnectionObserver ALLATORIxDEMO;

    @Override
    public /* synthetic */ void close() {
        ta a2;
        ta ta2 = a2;
        super.close();
        if (ta2.a != null) {
            a2.a.interrupt();
            a2.a = null;
        }
        if (a2.d != null) {
            a2.d.interrupt();
            a2.d = null;
        }
        if (a2.K != null) {
            a2.K.clear();
        }
        if (a2.ALLATORIxDEMO != null) {
            a2.ALLATORIxDEMO.disconnected(a2);
        }
    }

    public /* synthetic */ void D() {
        ta a2;
        Runnable runnable = () -> {
            ta a2;
            while (a2.isOpen()) {
                j j2 = a2.H();
                if (j2 == null) {
                    return;
                }
                if (j2 == null) continue;
                a2.l(j2);
            }
        };
        Runnable runnable2 = () -> {
            ta a2;
            while (a2.isOpen()) {
                j j2 = a2.ALLATORIxDEMO();
                if (j2 == null) {
                    return;
                }
                if (a2.ALLATORIxDEMO == null) continue;
                a2.ALLATORIxDEMO.packetReceived(a2, j2);
            }
        };
        ta ta2 = a2;
        ta ta3 = a2;
        ta2.a = new Thread(runnable, \u6070\u6070\u8c37.ALLATORIxDEMO((String)"\u0010\u000b-\n&\u001c"));
        ta3.d = new Thread(runnable2, CharacterTransfer.ALLATORIxDEMO("TSgRcD"));
        ta2.a.start();
        ta2.d.start();
    }

    public /* synthetic */ void ALLATORIxDEMO(j a2) {
        ta a3;
        a3.K.remove(a2);
    }

    private /* synthetic */ j H() {
        try {
            ta a2;
            j j2 = a2.K.take();
            return j2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public /* synthetic */ ta(String a2, int a3) {
        super(a2, a3);
        ta a4;
        ta ta2 = a4;
        ta2.K = new LinkedBlockingQueue();
    }

    public /* synthetic */ void ALLATORIxDEMO(IConnectionObserver a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        ta a2;
        return a2.K.isEmpty();
    }

    public /* synthetic */ void l() {
        ta a2;
        a2.K.clear();
    }

    private /* synthetic */ j ALLATORIxDEMO() {
        ta a2;
        Class<? extends j> class_ = T.ALLATORIxDEMO(a2.ALLATORIxDEMO());
        if (class_ == null) {
            return null;
        }
        try {
            class_ = class_.newInstance();
            class_.H(a2);
            return class_;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private /* synthetic */ void l(j a2) {
        byte by = T.ALLATORIxDEMO(a2);
        if (by != 0) {
            ta a3;
            ta ta2 = a3;
            ta2.ALLATORIxDEMO(by);
            a2.l(ta2);
        }
    }

    public /* synthetic */ ta(Socket a2) {
        super(a2);
        ta a3;
        ta ta2 = a3;
        ta2.K = new LinkedBlockingQueue();
    }

    public /* synthetic */ void H(j a2) {
        ta a3;
        a3.K.add(a2);
    }
}

