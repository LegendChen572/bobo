/*
 * Decompiled with CFR 0.150.
 */
package client.anticheat;

import client.anticheat.CheatingOffenseEntry;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import server.Timer;

public class CheatingOffensePersister {
    private static final /* synthetic */ CheatingOffensePersister a;
    private final /* synthetic */ Set<CheatingOffenseEntry> d;
    private final /* synthetic */ Lock ALLATORIxDEMO;

    public /* synthetic */ void persistEntry(CheatingOffenseEntry a2) {
        CheatingOffensePersister a3;
        a3.ALLATORIxDEMO.lock();
        try {
            CheatingOffensePersister cheatingOffensePersister = a3;
            cheatingOffensePersister.d.remove(a2);
            cheatingOffensePersister.d.add(a2);
            return;
        }
        finally {
            a3.ALLATORIxDEMO.unlock();
        }
    }

    public static /* synthetic */ CheatingOffensePersister getInstance() {
        return a;
    }

    private /* synthetic */ CheatingOffensePersister() {
        CheatingOffensePersister a2;
        CheatingOffensePersister cheatingOffensePersister = a2;
        a2.d = new LinkedHashSet<CheatingOffenseEntry>();
        cheatingOffensePersister.ALLATORIxDEMO = new ReentrantLock();
        Timer.CheatTimer.getInstance().register(a2.new PersistingTask(), 3600000L);
    }

    public static /* synthetic */ {
        a = new CheatingOffensePersister();
    }

    public class PersistingTask
    implements Runnable {
        public /* synthetic */ PersistingTask() {
            PersistingTask a3;
        }

        @Override
        public /* synthetic */ void run() {
            PersistingTask a2;
            a2.CheatingOffensePersister.this.ALLATORIxDEMO.lock();
            try {
                a2.CheatingOffensePersister.this.d.clear();
                return;
            }
            finally {
                a2.CheatingOffensePersister.this.ALLATORIxDEMO.unlock();
            }
        }
    }
}

