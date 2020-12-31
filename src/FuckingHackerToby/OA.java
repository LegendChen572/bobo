/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.D;
import FuckingHackerToby.G;
import FuckingHackerToby.Ua;
import FuckingHackerToby.YB;
import FuckingHackerToby.bc;
import FuckingHackerToby.c;
import FuckingHackerToby.dA;
import FuckingHackerToby.ka;
import FuckingHackerToby.oC;
import FuckingHackerToby.tB;
import client.messages.commands.GMCommand;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.VolatileImage;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import scripting.AbstractPlayerInteraction;

public final class OA
extends ka<c> {
    private /* synthetic */ YB i;
    private /* synthetic */ int g;
    private /* synthetic */ int k;
    private /* synthetic */ dA K;
    private /* synthetic */ oC J;
    private /* synthetic */ VolatileImage M;
    private /* synthetic */ Canvas j;
    private /* synthetic */ int C;
    public static final /* synthetic */ Cursor ALLATORIxDEMO;
    private /* synthetic */ int F;
    private /* synthetic */ int e;
    private /* synthetic */ int E;
    private /* synthetic */ int B;
    private /* synthetic */ int H;
    private static final /* synthetic */ String d = "";
    private static final /* synthetic */ int a = 2;
    private /* synthetic */ boolean I;
    private /* synthetic */ JFrame L;

    @Override
    public /* synthetic */ void ALLATORIxDEMO(WindowListener a2) {
        OA a3;
        a3.L.removeWindowListener(a2);
    }

    private /* synthetic */ void i() {
        OA a2;
        OA oA = a2;
        float f2 = (float)a2.H / (float)oA.F;
        float f3 = (float)oA.e / (float)a2.C;
        if (f2 < f3) {
            OA oA2 = a2;
            oA2.E = (int)((float)oA2.F * f2);
            oA2.g = (int)((float)oA2.C * f2);
            return;
        }
        OA oA3 = a2;
        oA3.E = (int)((float)oA3.F * f3);
        oA3.g = (int)((float)oA3.C * f3);
    }

    public /* synthetic */ boolean D() {
        OA a2;
        return a2.L.isVisible();
    }

    public static /* synthetic */ void ALLATORIxDEMO(OA a2) {
        a2.B();
    }

    private /* synthetic */ void K() {
        OA a2;
        OA oA = a2;
        oA.E = oA.H;
        oA.g = oA.e;
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        OA a2;
        return a2.L.isFocused();
    }

    private /* synthetic */ void B() {
        OA oA;
        OA a2;
        OA oA2 = a2;
        oA2.H = oA2.j.getWidth();
        oA2.e = oA2.j.getHeight();
        if (oA2.K == dA.k) {
            OA oA3 = a2;
            oA = oA3;
            oA3.K();
        } else if (a2.K == dA.K) {
            OA oA4 = a2;
            oA = oA4;
            oA4.i();
        } else if (a2.K == dA.a) {
            OA oA5 = a2;
            oA = oA5;
            oA5.g();
        } else {
            if (a2.K == dA.d) {
                return;
            }
            oA = a2;
        }
        oA.B = a2.H / 2 - a2.E / 2;
        OA oA6 = a2;
        OA oA7 = a2;
        oA6.k = oA6.e / 2 - oA7.g / 2;
        float f2 = (float)oA7.E / (float)a2.F;
        float f3 = (float)oA6.g / (float)a2.C;
        oA6.i.ALLATORIxDEMO(f2, f3);
        OA oA8 = a2;
        oA6.i.ALLATORIxDEMO(oA8.B, oA8.k);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(dA a2) {
        a.K = a2;
    }

    @Override
    public /* synthetic */ void H(D a2) {
        OA a3;
        a3.i.H(a2);
    }

    public /* synthetic */ int ALLATORIxDEMO() {
        OA a2;
        return a2.g;
    }

    public /* synthetic */ int D() {
        OA a2;
        return a2.H;
    }

    private /* synthetic */ int ALLATORIxDEMO(VolatileImage a2) {
        OA a3;
        GraphicsConfiguration graphicsConfiguration = a3.j.getGraphicsConfiguration();
        return a2.validate(graphicsConfiguration);
    }

    public /* synthetic */ int l() {
        OA a2;
        return a2.e;
    }

    public /* synthetic */ int E() {
        OA a2;
        return a2.C;
    }

    public /* synthetic */ void E() {
        OA a2;
        if (!a2.E() || !a2.D()) {
            return;
        }
        a2.L.setVisible(false);
    }

    public /* synthetic */ void d() {
        OA a2;
        if (!a2.E() || !a2.D()) {
            return;
        }
        OA oA = a2;
        oA.c();
        oA.b();
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(G a2) {
        OA a3;
        a3.J.ALLATORIxDEMO(a2);
    }

    public /* synthetic */ void H() {
        OA a2;
        a2.i.l();
    }

    public /* synthetic */ boolean H() {
        OA a2;
        Window window = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getFullScreenWindow();
        boolean bl = window != null && window == a2.L;
        return bl;
    }

    public /* synthetic */ boolean E() {
        OA a2;
        return a2.I;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = Toolkit.getDefaultToolkit().createCustomCursor(new BufferedImage(1, 1, 2), new Point(0, 0), GMCommand.ALLATORIxDEMO(",]BQ\u0017@\u0011]\u0010"));
    }

    private /* synthetic */ void b() {
        OA a2;
        BufferStrategy bufferStrategy = a2.j.getBufferStrategy();
        do {
            Graphics2D graphics2D;
            BufferStrategy bufferStrategy2;
            OA oA = a2;
            int n2 = oA.ALLATORIxDEMO(oA.M);
            if (n2 == 1) {
                bufferStrategy2 = bufferStrategy;
                a2.c();
            } else {
                if (n2 == 2) {
                    OA oA2 = a2;
                    oA2.M = oA2.ALLATORIxDEMO();
                    oA2.c();
                }
                bufferStrategy2 = bufferStrategy;
            }
            Graphics2D graphics2D2 = graphics2D = (Graphics2D)bufferStrategy2.getDrawGraphics();
            Ua.H(graphics2D);
            OA oA3 = a2;
            graphics2D2.clearRect(0, 0, oA3.H, oA3.e);
            OA oA4 = a2;
            OA oA5 = a2;
            graphics2D2.drawImage(a2.M, oA4.B, oA4.k, oA5.E, oA5.g, null);
            graphics2D.dispose();
        } while (bufferStrategy.contentsLost());
        bufferStrategy.show();
    }

    public /* synthetic */ dA ALLATORIxDEMO() {
        OA a2;
        return a2.K;
    }

    public /* synthetic */ int I() {
        OA a2;
        return a2.F;
    }

    public /* synthetic */ void ALLATORIxDEMO() {
        OA a2;
        a2.J.l();
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(Color a2) {
        OA a3;
        a3.j.setBackground(a2);
    }

    @Override
    public /* synthetic */ void H(WindowListener a2) {
        OA a3;
        a3.L.addWindowListener(a2);
    }

    private /* synthetic */ VolatileImage ALLATORIxDEMO() {
        OA a2;
        OA oA = a2;
        return oA.j.createVolatileImage(oA.F, a2.C);
    }

    public /* synthetic */ void I() {
        OA a2;
        if (!a2.E() || a2.D()) {
            return;
        }
        OA oA = a2;
        oA.L.setVisible(true);
        oA.M = oA.ALLATORIxDEMO();
        oA.j.createBufferStrategy(2);
        oA.j.requestFocus();
        oA.B();
        oA.d();
    }

    public /* synthetic */ void ALLATORIxDEMO(int a2, int a3) {
        OA a4;
        a4.L.setLocation(a2, a3);
    }

    public /* synthetic */ void D() {
        OA a2;
        if (!a2.E() || !a2.D()) {
            return;
        }
        OA oA = a2;
        oA.H(false);
        oA.L.setVisible(false);
        oA.L.dispose();
        a2.I = false;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(BufferedImage ... a2) {
        OA a3;
        a2 = Arrays.asList(a2);
        a3.L.setIconImages((List<? extends Image>)a2);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(boolean a2) {
        OA a3;
        a3.L.setResizable(a2);
    }

    public /* synthetic */ void H(int a22, int a3) {
        OA a4;
        OA oA = a4;
        boolean bl = oA.D();
        Dimension a22 = new Dimension(a22, a3);
        oA.L.setVisible(false);
        oA.j.setPreferredSize(a22);
        oA.L.pack();
        oA.L.setLocationRelativeTo(null);
        if (bl) {
            a4.I();
        }
    }

    public /* synthetic */ OA(int a2, int a3) {
        a4(a2, a3, d);
        OA a4;
    }

    @Override
    public /* synthetic */ void H(boolean a2) {
        OA a3;
        if (!a3.D() || !a3.E()) {
            return;
        }
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        boolean bl = graphicsDevice.isFullScreenSupported();
        if (a2 && bl) {
            graphicsDevice.setFullScreenWindow(a3.L);
            return;
        }
        graphicsDevice.setFullScreenWindow(null);
    }

    private /* synthetic */ void c() {
        OA a2;
        do {
            Graphics2D graphics2D;
            OA oA = a2;
            if (oA.ALLATORIxDEMO(oA.M) == 2) {
                a2.M = a2.ALLATORIxDEMO();
            }
            OA oA2 = a2;
            Graphics2D graphics2D2 = graphics2D = oA2.M.createGraphics();
            Ua.H(graphics2D2);
            OA oA3 = a2;
            graphics2D2.clearRect(0, 0, oA3.F, oA3.C);
            oA2.ALLATORIxDEMO(a3 -> a3.ALLATORIxDEMO(graphics2D2));
            graphics2D.dispose();
        } while (a2.M.contentsLost());
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(Cursor a2) {
        OA a3;
        a3.L.setCursor(a2);
    }

    private /* synthetic */ void g() {
        OA a2;
        OA oA = a2;
        oA.E = oA.F;
        oA.g = oA.C;
    }

    public /* synthetic */ OA(int a2, int a3, String a4) {
        OA a5;
        OA oA = a5;
        a5.L = new JFrame((String)a4);
        oA.j = new Canvas();
        a5.i = new YB();
        a5.J = new oC();
        a4 = new bc(a5);
        tB tB2 = new tB(a5);
        a5.I = true;
        a5.H = a5.E = a2;
        a5.F = a5.E;
        a5.e = a5.g = a3;
        a5.C = a5.g;
        OA oA2 = a5;
        oA2.K = dA.k;
        oA2.j.setPreferredSize(new Dimension(a2, a3));
        oA2.j.setIgnoreRepaint(true);
        oA2.j.addMouseListener(a5.i);
        oA2.j.addMouseMotionListener(a5.i);
        oA2.j.addMouseWheelListener(a5.i);
        oA2.j.addKeyListener(a5.J);
        oA2.L.addMouseListener(a5.i);
        oA2.L.addMouseMotionListener(a5.i);
        oA2.L.addMouseWheelListener(a5.i);
        oA2.L.addKeyListener(a5.J);
        oA2.L.setDefaultCloseOperation(0);
        oA2.L.setIgnoreRepaint(true);
        oA2.L.enableInputMethods(false);
        oA2.L.addWindowListener((WindowListener)a4);
        oA2.L.addComponentListener(tB2);
        oA2.L.add((Component)a5.j, AbstractPlayerInteraction.ALLATORIxDEMO("\u0015d8u3s"));
        oA2.L.pack();
        oA2.L.setLocationRelativeTo(null);
    }

    public /* synthetic */ String ALLATORIxDEMO() {
        OA a2;
        return a2.L.getTitle();
    }

    public /* synthetic */ boolean l() {
        OA a2;
        return a2.L.isResizable();
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(D a2) {
        OA a3;
        a3.i.ALLATORIxDEMO(a2);
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(String a2) {
        OA a3;
        a3.L.setTitle(a2);
    }

    @Override
    public /* synthetic */ void H(G a2) {
        OA a3;
        a3.J.H(a2);
    }

    public /* synthetic */ int H() {
        OA a2;
        return a2.E;
    }
}

