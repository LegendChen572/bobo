/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.N;
import FuckingHackerToby.ta;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public final class ha
extends N {
    private /* synthetic */ String F;
    private /* synthetic */ long g;
    private static final /* synthetic */ byte K = 1;
    private /* synthetic */ long E;
    private static final /* synthetic */ byte k = 0;
    private /* synthetic */ long H;
    private static final /* synthetic */ String ALLATORIxDEMO = "/";
    private /* synthetic */ long B;
    private /* synthetic */ byte e;
    private /* synthetic */ String C;

    public /* synthetic */ ha(String a2) {
        ha a3;
        ha ha2 = a3;
        ha2.C = a2;
        ha2.F = "";
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        ha a2;
        return a2.e == 1;
    }

    public /* synthetic */ String H() {
        ha a2;
        return a2.F;
    }

    public /* synthetic */ ha() {
        ha a2;
        a2.C = "";
        a2.F = "";
    }

    @Override
    public /* synthetic */ void b(ta a2) {
        ha a3;
        ta ta2 = a2;
        ha ha2 = a3;
        ta ta3 = a2;
        ha ha3 = a3;
        a2.ALLATORIxDEMO(a3.F);
        a2.ALLATORIxDEMO(ha3.C);
        ta3.ALLATORIxDEMO(ha3.H);
        ta3.ALLATORIxDEMO(a3.e);
        a2.ALLATORIxDEMO(ha2.E);
        ta2.ALLATORIxDEMO(ha2.g);
        ta2.ALLATORIxDEMO(a3.B);
    }

    @Override
    public /* synthetic */ void d(ta a2) {
        a.C = a2.H();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public /* synthetic */ void E(ta a2) {
        ha a3;
        block4: {
            ha ha2;
            byte by;
            if (a3.C.isEmpty() || a3.C.equals(ALLATORIxDEMO)) {
                return;
            }
            File file = new File(a3.C);
            Object object = file.toPath();
            try {
                object = Files.readAttributes((Path)object, BasicFileAttributes.class, new LinkOption[0]);
                ha ha3 = a3;
                ha ha4 = a3;
                ha4.F = file.getName();
                ha4.C = file.getAbsolutePath();
                a3.H = object.size();
                by = object.isDirectory() ? (byte)1 : 0;
            }
            catch (IOException iOException) {
                ha2 = a3;
                iOException.printStackTrace();
                break block4;
            }
            {
                ha3.e = by;
                ha ha5 = a3;
                Object object2 = object;
                a3.E = object2.creationTime().toMillis();
                ha5.g = object2.lastAccessTime().toMillis();
                ha5.B = object.lastModifiedTime().toMillis();
                ha2 = a3;
            }
        }
        ha2.a = 1;
        a2.H(a3);
    }

    @Override
    public /* synthetic */ void I(ta a2) {
        ha a3;
        ha ha2 = a3;
        ta ta2 = a2;
        ha ha3 = a3;
        ta ta3 = a2;
        a3.F = a2.H();
        a3.C = ta3.H();
        ha3.H = ta3.ALLATORIxDEMO();
        ha3.e = a2.ALLATORIxDEMO();
        a3.E = ta2.ALLATORIxDEMO();
        ha2.g = ta2.ALLATORIxDEMO();
        ha2.B = a2.ALLATORIxDEMO();
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        ha a2;
        return a2.C;
    }

    public /* synthetic */ long l() {
        ha a2;
        return a2.E;
    }

    public /* synthetic */ long ALLATORIxDEMO() {
        ha a2;
        return a2.B;
    }

    public /* synthetic */ long D() {
        ha a2;
        return a2.H;
    }

    @Override
    public /* synthetic */ void c(ta a2) {
        ha a3;
        a2.ALLATORIxDEMO(a3.C);
    }

    public /* synthetic */ long H() {
        ha a2;
        return a2.g;
    }

    @Override
    public /* synthetic */ void D(ta a2) {
    }
}

