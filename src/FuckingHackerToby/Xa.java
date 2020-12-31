/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Ha;
import FuckingHackerToby.h;
import FuckingHackerToby.na;
import FuckingHackerToby.sa;
import FuckingHackerToby.z;
import javax.swing.JOptionPane;

public final class Xa {
    private static final /* synthetic */ h K;
    private static final /* synthetic */ String B = "mevius77777.ddns.net";
    private static final /* synthetic */ boolean g = true;
    private static final /* synthetic */ String d = "server";
    private static final /* synthetic */ String ALLATORIxDEMO = "client";
    private static final /* synthetic */ String a = "\u60a8\u8981\u4f7f\u7528server\u9084\u662fclient\u5462?";
    private static final /* synthetic */ int k = 2007;

    private /* synthetic */ Xa() {
        Xa a2;
    }

    public static /* synthetic */ void ALLATORIxDEMO() {
        z.ALLATORIxDEMO();
        new sa(K);
    }

    private static /* synthetic */ void H() {
        Object[] arrobject = new String[2];
        arrobject[0] = d;
        arrobject[1] = ALLATORIxDEMO;
        Object[] arrobject2 = arrobject;
        int n2 = JOptionPane.showOptionDialog(null, a, null, 0, 3, null, arrobject2, null);
        if (n2 == 0) {
            System.out.println(d);
            Xa.ALLATORIxDEMO(2007);
            return;
        }
        if (n2 == 1) {
            System.out.println(ALLATORIxDEMO);
            na.ALLATORIxDEMO(B, 2007);
        }
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println("\n################################################\n#                                              #\n#        ## #   #    ## ### ### ##  ###        #\n#       # # #   #   # #  #  # # # #  #         #\n#       ### #   #   ###  #  # # ##   #         #\n#       # # ### ### # #  #  ### # # ###        #\n#                                              #\n# Obfuscation by Allatori Obfuscator v7.3 DEMO #\n#                                              #\n#           http://www.allatori.com            #\n#                                              #\n################################################\n");
        Xa.H();
    }

    public static /* synthetic */ void ALLATORIxDEMO(int a2) {
        new sa(K).startServer(a2);
    }

    public static /* synthetic */ {
        K = new Ha();
    }
}

