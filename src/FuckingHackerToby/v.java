/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public final class v {
    private /* synthetic */ ArrayList<String> d;
    private /* synthetic */ HashMap<String, byte[]> ALLATORIxDEMO;
    private /* synthetic */ Path a;

    public /* synthetic */ v ALLATORIxDEMO(String a2, byte[] a3) {
        v a4;
        v v2 = a4;
        v2.ALLATORIxDEMO.put(a2, a3);
        return v2;
    }

    public /* synthetic */ v ALLATORIxDEMO(String ... a2) {
        v a3;
        int n2;
        int n3 = a2.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = a2[n2];
            a3.d.add(string);
            n4 = ++n2;
        }
        return a3;
    }

    public /* synthetic */ v(String a2) {
        a3(Paths.get(a2, new String[0]));
        v a3;
    }

    public /* synthetic */ v(Path a2) {
        v a3;
        a3.a = a2;
        v v2 = a3;
        a3.d = new ArrayList();
        v2.ALLATORIxDEMO = new HashMap();
    }

    public /* synthetic */ void ALLATORIxDEMO() throws IOException {
    }
}

