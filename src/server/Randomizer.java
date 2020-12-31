/*
 * Decompiled with CFR 0.150.
 */
package server;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private static final /* synthetic */ Random ALLATORIxDEMO;

    public static final /* synthetic */ float nextFloat() {
        return ALLATORIxDEMO.nextFloat();
    }

    public static /* synthetic */ boolean isSuccess(int a2) {
        return a2 > Randomizer.ALLATORIxDEMO.nextInt(100);
    }

    public static /* synthetic */ boolean newNextBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static final /* synthetic */ void nextBytes(byte[] a2) {
        ALLATORIxDEMO.nextBytes(a2);
    }

    public static final /* synthetic */ int rand(int a2, int a3) {
        if (a2 == a3) {
            return a3;
        }
        if (a2 < 0 && a3 > 0) {
            return Randomizer.getRandomNum(a2, a3);
        }
        if (a2 > a3) {
            return (int)(ALLATORIxDEMO.nextDouble() * (double)(a2 - a3 + 1) + (double)a3);
        }
        return (int)(ALLATORIxDEMO.nextDouble() * (double)(a3 - a2 + 1) + (double)a2);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new Random();
    }

    public static final /* synthetic */ int negativerand(int a2, int a3) {
        if (a2 < 0) {
            int n2 = 0;
            int n3 = a3 - a2;
            return (int)(ALLATORIxDEMO.nextDouble() * (double)(n3 - n2 + 1) + (double)n2) + a2;
        }
        return (int)(ALLATORIxDEMO.nextDouble() * (double)(a3 - a2 + 1) + (double)a2);
    }

    public static /* synthetic */ int getRandomNum(int a2, int a3) {
        return Math.abs(new Random().nextInt()) % (a3 - a2 + 1) + a2;
    }

    public static final /* synthetic */ long nextLong() {
        return ALLATORIxDEMO.nextLong();
    }

    public /* synthetic */ Randomizer() {
        Randomizer a2;
    }

    public static final /* synthetic */ double nextDouble() {
        return ALLATORIxDEMO.nextDouble();
    }

    public static /* synthetic */ int NewRand(int a2, int a3) {
        int n2 = 0;
        if (a2 == a3) {
            return a2;
        }
        if (a2 > a3) {
            n2 = ThreadLocalRandom.current().nextInt(a2) + a3;
            return n2;
        }
        n2 = ThreadLocalRandom.current().nextInt(a3) + a2;
        return n2;
    }

    public static final /* synthetic */ boolean nextBoolean() {
        return ALLATORIxDEMO.nextBoolean();
    }

    public static final /* synthetic */ int nextInt() {
        return ALLATORIxDEMO.nextInt();
    }
}

