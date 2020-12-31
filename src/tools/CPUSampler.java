/*
 * Decompiled with CFR 0.150.
 */
package tools;

import handling.channel.handler.PetHandler;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.Framework.MapleExtendedSlots;
import server.characterCards.MapleCharacterCards;
import server.life.MonsterGlobalDropEntry;
import server.shark.SharkLogger;
import tools.FileOperation;

public class CPUSampler {
    private /* synthetic */ SamplerThread a;
    private /* synthetic */ Map<StackTrace, Integer> d;
    private /* synthetic */ List<String> B;
    private /* synthetic */ long K;
    private /* synthetic */ int ALLATORIxDEMO;
    private static /* synthetic */ CPUSampler k;

    public static /* synthetic */ {
        k = new CPUSampler();
    }

    public /* synthetic */ void setInterval(long a2) {
        a.K = a2;
    }

    private /* synthetic */ void ALLATORIxDEMO(Map<Thread, StackTraceElement[]> a2) {
        for (Map.Entry entry : a2.entrySet()) {
            CPUSampler a3;
            int n2 = a3.ALLATORIxDEMO((StackTraceElement[])entry.getValue());
            if (n2 == -1) continue;
            StackTrace stackTrace = new StackTrace((StackTraceElement[])entry.getValue(), n2, ((Thread)entry.getKey()).getState());
            Integer n3 = a3.d.get(stackTrace);
            ++a3.ALLATORIxDEMO;
            if (n3 == null) {
                a3.d.put(stackTrace, 1);
                continue;
            }
            a3.d.put(stackTrace, n3 + 1);
        }
    }

    public /* synthetic */ void save(Writer a2, int a3, int a4) throws IOException {
        CPUSampler a5;
        SampledStacktraces sampledStacktraces = a5.getTopConsumers();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MapleExtendedSlots.ALLATORIxDEMO("\fH(\u0007\u0015B,O7C+\u001dR"));
        int n2 = 0;
        int n3 = n2;
        while (n3 < a4 && n2 < sampledStacktraces.getTopConsumers().size()) {
            stringBuilder.append(sampledStacktraces.getTopConsumers().get(++n2).toString(sampledStacktraces.getTotalInvocations(), 1));
            n3 = n2;
        }
        stringBuilder.append(SharkLogger.ALLATORIxDEMO("+\u007fUMBG\u0001xSMBIR\u0016+"));
        Writer writer = a2;
        writer.write(stringBuilder.toString());
        writer.write(sampledStacktraces.toString(a3));
        writer.flush();
    }

    public /* synthetic */ void start() {
        CPUSampler a2;
        if (a2.a == null) {
            a2.a = new SamplerThread(a2, null);
            a2.a.start();
        }
    }

    public /* synthetic */ SampledStacktraces getTopConsumers() {
        CPUSampler a2;
        Iterator<Map.Entry<StackTrace, Integer>> iterator;
        ArrayList<StacktraceWithCount> arrayList = new ArrayList<StacktraceWithCount>();
        Iterator<Map.Entry<StackTrace, Integer>> iterator2 = iterator = a2.d.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<StackTrace, Integer> entry = iterator.next();
            arrayList.add(new StacktraceWithCount(entry.getValue(), entry.getKey()));
            iterator2 = iterator;
        }
        Collections.sort(arrayList);
        return new SampledStacktraces(arrayList, a2.ALLATORIxDEMO);
    }

    public /* synthetic */ CPUSampler() {
        CPUSampler a2;
        CPUSampler cPUSampler = a2;
        CPUSampler cPUSampler2 = a2;
        CPUSampler cPUSampler3 = a2;
        cPUSampler2.B = new LinkedList<String>();
        cPUSampler2.K = 5L;
        cPUSampler.a = null;
        cPUSampler.d = new HashMap<StackTrace, Integer>();
        cPUSampler.ALLATORIxDEMO = 0;
    }

    private /* synthetic */ int ALLATORIxDEMO(StackTraceElement[] a2) {
        CPUSampler a3;
        if (a2.length == 0) {
            return -1;
        }
        if (a3.B.size() == 0) {
            return 0;
        }
        int n2 = -1;
        block0: for (String string : a3.B) {
            int n3;
            int n4 = n3 = 0;
            while (n4 < a2.length) {
                if (a2[n3].getClassName().startsWith(string) && (n3 < n2 || n2 == -1)) {
                    n2 = n3;
                    continue block0;
                }
                n4 = ++n3;
            }
        }
        if (n2 >= 0 && a2[n2].getClassName().equals(MapleExtendedSlots.ALLATORIxDEMO("I=SvT>\t7C1I5TvS7H4TvW=U>H*J9I;Bvd\br\u000bF5W4B*\u0003\u000bF5W4B*s0U=F<"))) {
            return -1;
        }
        return n2;
    }

    public /* synthetic */ void addIncluded(String a2) {
        CPUSampler a3;
        for (String string : a3.B) {
            if (!a2.startsWith(string)) continue;
            return;
        }
        a3.B.add(a2);
    }

    public static /* synthetic */ CPUSampler getInstance() {
        return k;
    }

    public /* synthetic */ void reset() {
        CPUSampler a2;
        a2.d.clear();
        a2.ALLATORIxDEMO = 0;
    }

    public /* synthetic */ void stop() {
        CPUSampler a2;
        if (a2.a != null) {
            a2.a.stop();
            a2.a = null;
        }
    }

    private class SamplerThread
    implements Runnable {
        public final /* synthetic */ CPUSampler ALLATORIxDEMO;
        private /* synthetic */ boolean a;
        private /* synthetic */ Thread d;
        private /* synthetic */ boolean K;

        @Override
        public /* synthetic */ void run() {
            SamplerThread a2;
            SamplerThread samplerThread = a2;
            while (samplerThread.a) {
                a2.ALLATORIxDEMO.ALLATORIxDEMO(Thread.getAllStackTraces());
                try {
                    Thread.sleep(a2.ALLATORIxDEMO.K);
                    samplerThread = a2;
                }
                catch (InterruptedException interruptedException) {
                    return;
                }
            }
        }

        public /* synthetic */ void start() {
            SamplerThread a2;
            if (!a2.K) {
                a2.a = true;
                SamplerThread samplerThread = a2;
                a2.d = new Thread((Runnable)a2, MapleCharacterCards.ALLATORIxDEMO("O\u0004Yt_5a$`=b3,\u0000d&i5h"));
                a2.d.start();
                a2.K = true;
            }
        }

        private /* synthetic */ SamplerThread(CPUSampler cPUSampler) {
            SamplerThread a2;
            SamplerThread samplerThread = a2;
            a2.ALLATORIxDEMO = cPUSampler;
            samplerThread.K = false;
            samplerThread.a = false;
        }

        public /* synthetic */ SamplerThread(CPUSampler a2, 1 a3) {
            a4(a2);
            SamplerThread a4;
        }

        public /* synthetic */ void stop() {
            SamplerThread a2;
            a2.a = false;
            a2.d.interrupt();
            try {
                a2.d.join();
                return;
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                return;
            }
        }
    }

    public static class StacktraceWithCount
    implements Comparable<StacktraceWithCount> {
        private /* synthetic */ StackTrace ALLATORIxDEMO;
        private /* synthetic */ int d;

        public /* synthetic */ StackTraceElement[] getTrace() {
            StacktraceWithCount a2;
            return a2.ALLATORIxDEMO.getTrace();
        }

        public /* synthetic */ int getCount() {
            StacktraceWithCount a2;
            return a2.d;
        }

        public /* synthetic */ String toString(int a2, int a3) {
            StacktraceWithCount a4;
            int n2 = a2;
            return a4.d + "/" + n2 + " Sampled Invocations (" + a4.ALLATORIxDEMO(n2) + "%) " + a4.ALLATORIxDEMO.toString(a3);
        }

        public /* synthetic */ String toString() {
            StacktraceWithCount a2;
            StacktraceWithCount stacktraceWithCount = a2;
            return stacktraceWithCount.d + " Sampled Invocations\n" + stacktraceWithCount.ALLATORIxDEMO.toString();
        }

        public /* synthetic */ boolean equals(Object a2) {
            StacktraceWithCount a3;
            if (!(a2 instanceof StacktraceWithCount)) {
                return false;
            }
            StacktraceWithCount stacktraceWithCount = (StacktraceWithCount)a2;
            return a3.d == stacktraceWithCount.d;
        }

        public /* synthetic */ StacktraceWithCount(int a2, StackTrace a3) {
            StacktraceWithCount a4;
            StacktraceWithCount stacktraceWithCount = a4;
            stacktraceWithCount.d = a2;
            stacktraceWithCount.ALLATORIxDEMO = a3;
        }

        private /* synthetic */ double ALLATORIxDEMO(int a2) {
            StacktraceWithCount a3;
            return (double)Math.round((double)a3.d / (double)a2 * 10000.0) / 100.0;
        }

        @Override
        public /* synthetic */ int compareTo(StacktraceWithCount a2) {
            StacktraceWithCount a3;
            return -Integer.valueOf(a3.d).compareTo(a2.d);
        }
    }

    private static class StackTrace {
        private /* synthetic */ StackTraceElement[] d;
        private /* synthetic */ Thread.State ALLATORIxDEMO;

        public /* synthetic */ StackTraceElement[] getTrace() {
            StackTrace a2;
            return a2.d;
        }

        public /* synthetic */ int hashCode() {
            int n2;
            StackTrace a2;
            int n3 = 13 * a2.d.length + a2.ALLATORIxDEMO.hashCode();
            StackTraceElement[] arrstackTraceElement = a2.d;
            int n4 = a2.d.length;
            int n5 = n2 = 0;
            while (n5 < n4) {
                StackTraceElement stackTraceElement = arrstackTraceElement[n2];
                n3 ^= stackTraceElement.hashCode();
                n5 = ++n2;
            }
            return n3;
        }

        public /* synthetic */ boolean equals(Object a2) {
            int n2;
            StackTrace a3;
            if (!(a2 instanceof StackTrace)) {
                return false;
            }
            StackTrace stackTrace = (StackTrace)a2;
            if (stackTrace.d.length != a3.d.length) {
                return false;
            }
            if (stackTrace.ALLATORIxDEMO != a3.ALLATORIxDEMO) {
                return false;
            }
            int n3 = n2 = 0;
            while (n3 < a3.d.length) {
                if (!a3.d[n2].equals(stackTrace.d[n2])) {
                    return false;
                }
                n3 = ++n2;
            }
            return true;
        }

        public /* synthetic */ String toString(int a2) {
            StringBuilder stringBuilder;
            block4: {
                int n2;
                StackTrace a3;
                StringBuilder stringBuilder2 = new StringBuilder(PetHandler.ALLATORIxDEMO("R\u001a`\u001adT!"));
                stringBuilder2.append(a3.ALLATORIxDEMO.name());
                if (a2 > 1) {
                    stringBuilder2.append(MonsterGlobalDropEntry.ALLATORIxDEMO("d"));
                } else {
                    stringBuilder2.append(" ");
                }
                int n3 = 0;
                StackTraceElement[] arrstackTraceElement = a3.d;
                int n4 = a3.d.length;
                int n5 = n2 = 0;
                while (n5 < n4) {
                    StackTraceElement stackTraceElement = arrstackTraceElement[n2];
                    if (++n3 > a2) {
                        stringBuilder = stringBuilder2;
                        break block4;
                    }
                    stringBuilder2.append(stackTraceElement.getClassName());
                    stringBuilder2.append(PetHandler.ALLATORIxDEMO("\""));
                    stringBuilder2.append(stackTraceElement.getMethodName());
                    stringBuilder2.append(MonsterGlobalDropEntry.ALLATORIxDEMO("\u001aFv\u0007T\u000b\u0000N"));
                    stringBuilder2.append(stackTraceElement.getLineNumber());
                    stringBuilder2.append(PetHandler.ALLATORIxDEMO("G\u000b"));
                    n5 = ++n2;
                }
                stringBuilder = stringBuilder2;
            }
            return stringBuilder.toString();
        }

        public /* synthetic */ String toString() {
            StackTrace a2;
            return a2.toString(-1);
        }

        public /* synthetic */ StackTrace(StackTraceElement[] a2, int a3, Thread.State a4) {
            StackTrace a5;
            a5.ALLATORIxDEMO = a4;
            if (a3 == 0) {
                a5.d = a2;
                return;
            }
            a5.d = new StackTraceElement[a2.length - a3];
            System.arraycopy(a2, a3, a5.d, 0, a5.d.length);
        }
    }

    public static class SampledStacktraces {
        public /* synthetic */ int ALLATORIxDEMO;
        public /* synthetic */ List<StacktraceWithCount> d;

        public /* synthetic */ int getTotalInvocations() {
            SampledStacktraces a2;
            return a2.ALLATORIxDEMO;
        }

        public /* synthetic */ String toString() {
            SampledStacktraces a2;
            return a2.toString(0);
        }

        public /* synthetic */ SampledStacktraces(List<StacktraceWithCount> a2, int a3) {
            SampledStacktraces a4;
            SampledStacktraces sampledStacktraces = a4;
            sampledStacktraces.d = a2;
            sampledStacktraces.ALLATORIxDEMO = a3;
        }

        public /* synthetic */ List<StacktraceWithCount> getTopConsumers() {
            SampledStacktraces a2;
            return a2.d;
        }

        public /* synthetic */ String toString(int a2) {
            SampledStacktraces a3;
            StringBuilder stringBuilder = new StringBuilder();
            for (StacktraceWithCount stacktraceWithCount : a3.d) {
                if (stacktraceWithCount.getCount() < a2) continue;
                stringBuilder.append(stacktraceWithCount.toString(a3.ALLATORIxDEMO, Integer.MAX_VALUE));
                stringBuilder.append(FileOperation.ALLATORIxDEMO("\u0007"));
            }
            return stringBuilder.toString();
        }
    }
}

