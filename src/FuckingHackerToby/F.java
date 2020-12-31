/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import java.util.function.Consumer;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;

public final class F {
    private /* synthetic */ byte[] d;
    private /* synthetic */ Thread K;
    private /* synthetic */ TargetDataLine k;
    private /* synthetic */ boolean a;
    private /* synthetic */ Consumer<F> ALLATORIxDEMO;

    public /* synthetic */ F(int a2) {
        F a3;
        a3.d = new byte[a2];
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        F a2;
        return a2.a;
    }

    public /* synthetic */ void ALLATORIxDEMO(Consumer<F> a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void l() {
        F a2;
        if (a2.a) {
            return;
        }
        Runnable runnable = () -> {
            block0: while (true) {
                F a2;
                F f2 = a2;
                while (f2.a) {
                    F f3 = a2;
                    f3.k.read(f3.d, 0, a2.d.length);
                    if (a2.ALLATORIxDEMO == null) continue block0;
                    F f4 = a2;
                    f2 = f4;
                    a2.ALLATORIxDEMO.accept(f4);
                }
                break;
            }
        };
        try {
            F f2 = a2;
            a2.k = AudioSystem.getTargetDataLine(null);
            F f3 = a2;
            a2.K = new Thread(runnable);
            f2.a = true;
            a2.k.open();
            f2.k.start();
            f2.K.start();
            return;
        }
        catch (Exception exception) {
            a2.H();
            a2.d = new byte[0];
            exception.printStackTrace();
            return;
        }
    }

    public /* synthetic */ void H() {
        F f2;
        F a2;
        if (!a2.a) {
            return;
        }
        a2.a = false;
        try {
            F f3 = a2;
            f3.K.interrupt();
            f3.k.stop();
            f3.k.close();
            f2 = a2;
        }
        catch (Exception exception) {
            f2 = a2;
            exception.printStackTrace();
        }
        f2.K = null;
        a2.k = null;
    }

    public /* synthetic */ byte[] ALLATORIxDEMO() {
        F a2;
        return a2.d;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3;
        int cfr_ignored_0 = 5 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = 4 << 4 ^ (3 ^ 5) << 1;
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
}

