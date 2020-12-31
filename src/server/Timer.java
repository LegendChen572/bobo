/*
 * Decompiled with CFR 0.150.
 */
package server;

import client.ClientRedirector;
import java.util.Calendar;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import server.Randomizer;
import tools.FilePrinter;

public abstract class Timer {
    public /* synthetic */ String name;
    public /* synthetic */ String file;
    private /* synthetic */ ScheduledThreadPoolExecutor ALLATORIxDEMO;

    public /* synthetic */ ScheduledFuture<?> registerHour(Runnable a2, long a3, long a4) {
        Timer a5;
        if (a5.ALLATORIxDEMO == null) {
            return null;
        }
        return a5.ALLATORIxDEMO.scheduleAtFixedRate(new LoggingSaveRunnable(a2, a5.file), a4, a3, TimeUnit.HOURS);
    }

    public /* synthetic */ ScheduledFuture<?> register(Runnable a2, long a3, long a4) {
        Timer a5;
        if (a5.ALLATORIxDEMO == null) {
            return null;
        }
        return a5.ALLATORIxDEMO.scheduleAtFixedRate(new LoggingSaveRunnable(a2, a5.file), a4, a3, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ long DateToStamp(int a2, int a3, int a4) {
        Calendar calendar;
        Calendar calendar2 = calendar = Calendar.getInstance();
        calendar.set(11, a2);
        calendar2.set(12, a3);
        calendar2.set(13, a4);
        return calendar2.getTime().getTime();
    }

    public /* synthetic */ ScheduledFuture<?> register(Runnable a2, long a3) {
        Timer a4;
        if (a4.ALLATORIxDEMO == null) {
            return null;
        }
        return a4.ALLATORIxDEMO.scheduleAtFixedRate(new LoggingSaveRunnable(a2, a4.file), 0L, a3, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ ScheduledFuture<?> schedule(Runnable a2, long a3) {
        Timer a4;
        if (a4.ALLATORIxDEMO == null) {
            return null;
        }
        return a4.ALLATORIxDEMO.schedule(new LoggingSaveRunnable(a2, a4.file), a3, TimeUnit.MILLISECONDS);
    }

    public /* synthetic */ ScheduledFuture<?> scheduleSecond(Runnable a2, long a3) {
        Timer a4;
        if (a4.ALLATORIxDEMO == null) {
            return null;
        }
        return a4.ALLATORIxDEMO.schedule(new LoggingSaveRunnable(a2, a4.file), a3, TimeUnit.SECONDS);
    }

    public /* synthetic */ ScheduledFuture<?> registerSec(Runnable a2, long a3, long a4) {
        Timer a5;
        if (a5.ALLATORIxDEMO == null) {
            return null;
        }
        return a5.ALLATORIxDEMO.scheduleAtFixedRate(new LoggingSaveRunnable(a2, a5.file), a4, a3, TimeUnit.SECONDS);
    }

    public /* synthetic */ void stop() {
        try {
            Timer a2;
            if (a2.ALLATORIxDEMO != null) {
                a2.ALLATORIxDEMO.shutdownNow();
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public /* synthetic */ Timer() {
        Timer a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4;
        int cfr_ignored_0 = 5 << 3;
        int n5 = n3;
        int n6 = 2 << 3 ^ 4;
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

    public /* synthetic */ ScheduledFuture<?> registerMin(Runnable a2, long a3, long a4) {
        Timer a5;
        if (a5.ALLATORIxDEMO == null) {
            return null;
        }
        return a5.ALLATORIxDEMO.scheduleAtFixedRate(new LoggingSaveRunnable(a2, a5.file), a4, a3, TimeUnit.MINUTES);
    }

    public /* synthetic */ void start() {
        Timer a2;
        if (a2.ALLATORIxDEMO != null && !a2.ALLATORIxDEMO.isShutdown() && !a2.ALLATORIxDEMO.isTerminated()) {
            return;
        }
        a2.file = "Logs/Log_" + a2.name + "_Except.rtf";
        Object object = a2.name + Randomizer.nextInt();
        object = new ThreadFactory(){
            public final /* synthetic */ String d;
            private final /* synthetic */ AtomicInteger a;

            @Override
            public /* synthetic */ Thread newThread(Runnable a2) {
                1 a3;
                Thread thread = new Thread(a2);
                1 v0 = a3;
                thread.setName(v0.d + "-Worker-" + v0.a.getAndIncrement());
                return thread;
            }
            {
                1 a3;
                a3.d = string;
                1 v0 = a3;
                v0.a = new AtomicInteger(1);
            }
        };
        Object object2 = object = new ScheduledThreadPoolExecutor(4, (ThreadFactory)object);
        Object object3 = object;
        Object object4 = object;
        ((ThreadPoolExecutor)object4).setKeepAliveTime(10L, TimeUnit.MINUTES);
        ((ThreadPoolExecutor)object4).allowCoreThreadTimeOut(true);
        ((ThreadPoolExecutor)object3).setCorePoolSize(8);
        ((ThreadPoolExecutor)object3).setMaximumPoolSize(16);
        ((ScheduledThreadPoolExecutor)object2).setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        ((ScheduledThreadPoolExecutor)object2).setExecuteExistingDelayedTasksAfterShutdownPolicy(true);
        a2.ALLATORIxDEMO = object2;
    }

    public /* synthetic */ ScheduledFuture<?> scheduleAtTimestamp(Runnable a2, long a3) {
        Timer a4;
        return a4.schedule(a2, a3 - System.currentTimeMillis());
    }

    public /* synthetic */ ScheduledFuture<?> scheduleMinute(Runnable a2, long a3) {
        Timer a4;
        if (a4.ALLATORIxDEMO == null) {
            return null;
        }
        return a4.ALLATORIxDEMO.schedule(new LoggingSaveRunnable(a2, a4.file), a3, TimeUnit.MINUTES);
    }

    public /* synthetic */ ScheduledFuture<?> registerDay(Runnable a2, long a3, long a4) {
        Timer a5;
        if (a5.ALLATORIxDEMO == null) {
            return null;
        }
        return a5.ALLATORIxDEMO.scheduleAtFixedRate(new LoggingSaveRunnable(a2, a5.file), a4, a3, TimeUnit.DAYS);
    }

    private static class LoggingSaveRunnable
    implements Runnable {
        public /* synthetic */ Runnable d;
        public /* synthetic */ String ALLATORIxDEMO;

        public /* synthetic */ LoggingSaveRunnable(Runnable a2, String a3) {
            LoggingSaveRunnable a4;
            LoggingSaveRunnable loggingSaveRunnable = a4;
            loggingSaveRunnable.d = a2;
            loggingSaveRunnable.ALLATORIxDEMO = a3;
        }

        @Override
        public /* synthetic */ void run() {
            try {
                LoggingSaveRunnable a2;
                a2.d.run();
                return;
            }
            catch (Throwable throwable) {
                FilePrinter.printError(ClientRedirector.ALLATORIxDEMO("a-X!GjA<A"), throwable);
                return;
            }
        }
    }

    public static class TimerManager
    extends Timer {
        private static /* synthetic */ TimerManager ALLATORIxDEMO;

        public static /* synthetic */ TimerManager getInstance() {
            return ALLATORIxDEMO;
        }

        private /* synthetic */ TimerManager() {
            TimerManager a2;
            a2.name = "TimerManager";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new TimerManager();
        }
    }

    public static class BackupTimer
    extends Timer {
        private static final /* synthetic */ BackupTimer ALLATORIxDEMO;

        public static /* synthetic */ BackupTimer getInstance() {
            return ALLATORIxDEMO;
        }

        private /* synthetic */ BackupTimer() {
            BackupTimer a2;
            a2.name = "Backuptimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new BackupTimer();
        }
    }

    public static class PingTimer
    extends Timer {
        private static final /* synthetic */ PingTimer ALLATORIxDEMO;

        public static /* synthetic */ PingTimer getInstance() {
            return ALLATORIxDEMO;
        }

        private /* synthetic */ PingTimer() {
            PingTimer a2;
            a2.name = "Pingtimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new PingTimer();
        }
    }

    public static class CheatTimer
    extends Timer {
        private static final /* synthetic */ CheatTimer ALLATORIxDEMO;

        public static /* synthetic */ CheatTimer getInstance() {
            return ALLATORIxDEMO;
        }

        private /* synthetic */ CheatTimer() {
            CheatTimer a2;
            a2.name = "Cheattimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new CheatTimer();
        }
    }

    public static class MobTimer
    extends Timer {
        private static final /* synthetic */ MobTimer ALLATORIxDEMO;

        public static /* synthetic */ MobTimer getInstance() {
            return ALLATORIxDEMO;
        }

        private /* synthetic */ MobTimer() {
            MobTimer a2;
            a2.name = "Mobtimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new MobTimer();
        }
    }

    public static class EtcTimer
    extends Timer {
        private static final /* synthetic */ EtcTimer ALLATORIxDEMO;

        public static /* synthetic */ EtcTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new EtcTimer();
        }

        private /* synthetic */ EtcTimer() {
            EtcTimer a2;
            a2.name = "Etctimer";
        }
    }

    public static class CloneTimer
    extends Timer {
        private static final /* synthetic */ CloneTimer ALLATORIxDEMO;

        private /* synthetic */ CloneTimer() {
            CloneTimer a2;
            a2.name = "Clonetimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new CloneTimer();
        }

        public static /* synthetic */ CloneTimer getInstance() {
            return ALLATORIxDEMO;
        }
    }

    public static class DonateTimer
    extends Timer {
        private static final /* synthetic */ DonateTimer ALLATORIxDEMO;

        private /* synthetic */ DonateTimer() {
            DonateTimer a2;
            a2.name = "Donatetimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new DonateTimer();
        }

        public static /* synthetic */ DonateTimer getInstance() {
            return ALLATORIxDEMO;
        }
    }

    public static class EventTimer
    extends Timer {
        private static final /* synthetic */ EventTimer ALLATORIxDEMO;

        private /* synthetic */ EventTimer() {
            EventTimer a2;
            a2.name = "Eventtimer";
        }

        public static /* synthetic */ EventTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new EventTimer();
        }
    }

    public static class MonsterPetTimer
    extends Timer {
        private static final /* synthetic */ MonsterPetTimer ALLATORIxDEMO;

        private /* synthetic */ MonsterPetTimer() {
            MonsterPetTimer a2;
            a2.name = "Monsterpettimer";
        }

        public static /* synthetic */ MonsterPetTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new MonsterPetTimer();
        }
    }

    public static class MonsterTimer
    extends Timer {
        private static final /* synthetic */ MonsterTimer ALLATORIxDEMO;

        private /* synthetic */ MonsterTimer() {
            MonsterTimer a2;
            a2.name = "Monstertimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new MonsterTimer();
        }

        public static /* synthetic */ MonsterTimer getInstance() {
            return ALLATORIxDEMO;
        }
    }

    public static class BuffTimer
    extends Timer {
        private static final /* synthetic */ BuffTimer ALLATORIxDEMO;

        private /* synthetic */ BuffTimer() {
            BuffTimer a2;
            a2.name = "Bufftimer";
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new BuffTimer();
        }

        public static /* synthetic */ BuffTimer getInstance() {
            return ALLATORIxDEMO;
        }
    }

    public static class ChannelTimer
    extends Timer {
        private static final /* synthetic */ ChannelTimer ALLATORIxDEMO;

        public static /* synthetic */ ChannelTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new ChannelTimer();
        }

        private /* synthetic */ ChannelTimer() {
            ChannelTimer a2;
            a2.name = "ChannelTimer";
        }
    }

    public static class MapTimer
    extends Timer {
        private static final /* synthetic */ MapTimer ALLATORIxDEMO;

        private /* synthetic */ MapTimer() {
            MapTimer a2;
            a2.name = "Maptimer";
        }

        public static /* synthetic */ MapTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new MapTimer();
        }
    }

    public static class AutoSaveTimer
    extends Timer {
        private static final /* synthetic */ AutoSaveTimer ALLATORIxDEMO;

        public static /* synthetic */ AutoSaveTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new AutoSaveTimer();
        }

        private /* synthetic */ AutoSaveTimer() {
            AutoSaveTimer a2;
            a2.name = "AutoSaveTimer";
        }
    }

    public static class WorldTimer
    extends Timer {
        private static final /* synthetic */ WorldTimer ALLATORIxDEMO;

        public static /* synthetic */ WorldTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new WorldTimer();
        }

        private /* synthetic */ WorldTimer() {
            WorldTimer a2;
            a2.name = "Worldtimer";
        }
    }

    public static class SpecialTimer
    extends Timer {
        private static final /* synthetic */ SpecialTimer ALLATORIxDEMO;

        private /* synthetic */ SpecialTimer() {
            SpecialTimer a2;
            a2.name = "SpecialTimer";
        }

        public static /* synthetic */ SpecialTimer getInstance() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new SpecialTimer();
        }
    }
}

