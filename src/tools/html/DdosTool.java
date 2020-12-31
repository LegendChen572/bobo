/*
 * Decompiled with CFR 0.150.
 */
package tools.html;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tools.html.Mythread;

public class DdosTool {
    public /* synthetic */ DdosTool() {
        DdosTool a2;
    }

    public static /* synthetic */ void main(String[] a2) {
        int n2;
        System.out.println("\n################################################\n#                                              #\n#        ## #   #    ## ### ### ##  ###        #\n#       # # #   #   # #  #  # # # #  #         #\n#       ### #   #   ###  #  # # ##   #         #\n#       # # ### ### # #  #  ### # # ###        #\n#                                              #\n# Obfuscation by Allatori Obfuscator v7.3 DEMO #\n#                                              #\n#           http://www.allatori.com            #\n#                                              #\n################################################\n");
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        Runnable runnable = new Mythread();
        runnable = new Thread(runnable);
        int n3 = n2 = 0;
        while (n3 < 100) {
            executorService.execute(runnable);
            n3 = ++n2;
        }
    }
}

