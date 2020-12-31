/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.ta;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

public class O
extends N {
    private static final /* synthetic */ byte K = 0;
    private /* synthetic */ String[] B;
    private static final /* synthetic */ byte k = 1;

    public /* synthetic */ O() {
        O a2;
        O o2 = a2;
        o2.a = 0;
        o2.B = new String[0];
    }

    @Override
    public /* synthetic */ void c(ta a2) {
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        int n2;
        O a3;
        String[] arrstring = a3.B;
        int n3 = a3.B.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            ta ta2 = a2;
            ta2.ALLATORIxDEMO((byte)1);
            ta2.ALLATORIxDEMO(arrstring[++n2]);
            n4 = n2;
        }
        a2.ALLATORIxDEMO((byte)0);
    }

    public /* synthetic */ String[] ALLATORIxDEMO() {
        O a2;
        return a2.B;
    }

    @Override
    public /* synthetic */ void D(ta a2) {
    }

    @Override
    public /* synthetic */ void E(ta a2) {
        O a3;
        O o2 = a3;
        o2.a = 1;
        o2.B = (String[])Stream.of(File.listRoots()).map(File::getAbsolutePath).toArray(String[]::new);
        a2.H(a3);
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        O a3;
        ArrayList<String> arrayList = new ArrayList<String>();
        ta ta2 = a2;
        while (ta2.ALLATORIxDEMO() == 1) {
            ta ta3 = a2;
            ta2 = ta3;
            String string = ta3.H();
            arrayList.add(string);
        }
        int n2 = arrayList.size();
        a3.B = new String[n2];
        a3.B = arrayList.toArray(a3.B);
    }

    @Override
    public /* synthetic */ void d(ta a2) {
    }
}

