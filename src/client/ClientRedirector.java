/*
 * Decompiled with CFR 0.150.
 */
package client;

public class ClientRedirector {
    private final /* synthetic */ int d;
    private final /* synthetic */ String K;
    private final /* synthetic */ int a;
    private /* synthetic */ boolean ALLATORIxDEMO;

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 4 ^ 2 << 1;
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 2;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 5;
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

    public final /* synthetic */ void setLogined(boolean a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ ClientRedirector(String a2, int a3, int a4, boolean a5) {
        ClientRedirector a6;
        ClientRedirector clientRedirector = a6;
        ClientRedirector clientRedirector2 = a6;
        clientRedirector2.K = a2;
        clientRedirector2.a = a3;
        clientRedirector.d = a4;
        clientRedirector.ALLATORIxDEMO = a5;
    }

    public final /* synthetic */ int getChannel() {
        ClientRedirector a2;
        return a2.d;
    }

    public final /* synthetic */ boolean isLogined() {
        ClientRedirector a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ String getAccount() {
        ClientRedirector a2;
        return a2.K;
    }

    public final /* synthetic */ int getWorld() {
        ClientRedirector a2;
        return a2.a;
    }
}

