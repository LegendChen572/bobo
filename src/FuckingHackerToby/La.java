/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.ta;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

public class La
extends N {
    private static final /* synthetic */ byte k = 1;
    private /* synthetic */ String[] g;
    private static final /* synthetic */ byte B = 2;
    private /* synthetic */ String[] E;
    private static final /* synthetic */ byte K = 0;
    private /* synthetic */ String e;

    public /* synthetic */ String[] H() {
        La a2;
        return a2.E;
    }

    @Override
    public /* synthetic */ void D(ta a2) {
    }

    @Override
    public /* synthetic */ void d(ta a2) {
        a.e = a2.H();
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        String string;
        int n2;
        La a3;
        String[] arrstring = a3.E;
        int n3 = a3.E.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            string = arrstring[n2];
            ta ta2 = a2;
            ta2.ALLATORIxDEMO((byte)1);
            ta2.ALLATORIxDEMO(string);
            n4 = ++n2;
        }
        arrstring = a3.g;
        n3 = a3.g.length;
        int n5 = n2 = 0;
        while (n5 < n3) {
            string = arrstring[n2];
            ta ta3 = a2;
            ta3.ALLATORIxDEMO((byte)2);
            ta3.ALLATORIxDEMO(string);
            n5 = ++n2;
        }
        a2.ALLATORIxDEMO((byte)0);
    }

    @Override
    public /* synthetic */ void c(ta a2) {
        La a3;
        a2.ALLATORIxDEMO(a3.e);
    }

    @Override
    public /* synthetic */ void E(ta a2) {
        La a3;
        File[] arrfile = new File(a3.e).listFiles();
        if (arrfile == null) {
            return;
        }
        a3.a = 1;
        a3.E = (String[])Stream.of(arrfile).filter(File::isFile).map(File::getAbsolutePath).toArray(String[]::new);
        a3.g = (String[])Stream.of(arrfile).filter(File::isDirectory).map(File::getAbsolutePath).toArray(String[]::new);
        a2.H(a3);
    }

    public /* synthetic */ La(String a2) {
        La a3;
        a3.e = a2;
        a3.a = 0;
        a3.g = new String[0];
        a3.E = a3.g;
    }

    @Override
    public /* synthetic */ void I(ta a22) {
        La a3;
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        byte by = 0;
        while ((by = a22.ALLATORIxDEMO()) != 0) {
            String string = a22.H();
            if (by == 1) {
                arrayList.add(string);
                continue;
            }
            if (by != 2) continue;
            arrayList2.add(string);
        }
        int n2 = arrayList.size();
        int a22 = arrayList2.size();
        a3.E = new String[n2];
        a3.E = arrayList.toArray(a3.E);
        a3.g = new String[a22];
        a3.g = arrayList2.toArray(a3.g);
    }

    public /* synthetic */ La() {
        a2("");
        La a2;
        a2.a = 1;
    }

    public /* synthetic */ String[] ALLATORIxDEMO() {
        La a2;
        return a2.g;
    }
}

