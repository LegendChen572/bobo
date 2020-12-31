/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UC {
    public /* synthetic */ Map<String, Long> d;
    public /* synthetic */ boolean B;
    public /* synthetic */ List<String> K;
    public /* synthetic */ int k;
    public static /* synthetic */ Map<String, UC> ALLATORIxDEMO;
    public /* synthetic */ List<Integer> a;

    public /* synthetic */ UC() {
        UC a2;
        UC uC = a2;
        UC uC2 = a2;
        uC2.B = false;
        uC2.k = -1;
        UC uC3 = a2;
        uC.K = new LinkedList<String>();
        uC3.a = new LinkedList<Integer>();
        uC.d = new HashMap<String, Long>();
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new HashMap<String, UC>();
    }

    public static /* synthetic */ UC ALLATORIxDEMO(String a2) {
        if (ALLATORIxDEMO.containsKey(a2)) {
            return ALLATORIxDEMO.get(a2);
        }
        ALLATORIxDEMO.put(a2, new UC());
        return ALLATORIxDEMO.get(a2);
    }
}

