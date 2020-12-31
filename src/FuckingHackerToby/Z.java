/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Ua;
import FuckingHackerToby.s;
import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public final class Z {
    private static final /* synthetic */ int d = 6;
    private static final /* synthetic */ int B = 50;
    private static final /* synthetic */ Stroke ALLATORIxDEMO;
    private static final /* synthetic */ s[] a;
    private static final /* synthetic */ int K = 6;
    private static final /* synthetic */ int k = 6;
    private static final /* synthetic */ int g = 6;

    public static /* synthetic */ s[] ALLATORIxDEMO(BufferedImage a2, BufferedImage a3) {
        int n2;
        BufferedImage bufferedImage = a2;
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        if (a3.getWidth() != n3 || a3.getHeight() != n4) {
            return a;
        }
        int n5 = n3 / 6;
        int n6 = n4 / 6;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n7 = n2 = 0;
        while (n7 < 6) {
            int n8;
            int n9 = n8 = 0;
            while (n9 < 6) {
                int n10;
                int n11 = n2 * n5;
                int n12 = n8 * n6;
                int n13 = n11 + n5;
                int n14 = n12 + n6;
                int n15 = n11;
                block2: while (n15 < n13 && n10 < n3) {
                    int n16;
                    int n17 = n12;
                    while (n17 < n14 && n16 < n4) {
                        int n18;
                        int n19 = a2.getRGB(n10, n16);
                        if (!Z.ALLATORIxDEMO(n19, n18 = a3.getRGB(n10, n16), 50)) {
                            Object object = a3.getSubimage(n11, n12, n5, n6);
                            object = new s(n11, n12, (BufferedImage)object);
                            arrayList.add(object);
                            break block2;
                        }
                        n17 = n16 += 6;
                    }
                    n15 = n10 += 6;
                }
                n9 = ++n8;
            }
            n7 = ++n2;
        }
        s[] arrs = (s[])arrayList.stream().toArray(s[]::new);
        return arrs;
    }

    public static /* synthetic */ {
        a = new s[0];
        ALLATORIxDEMO = new BasicStroke(2.0f);
    }

    public static /* synthetic */ BufferedImage ALLATORIxDEMO() {
        Graphics2D graphics2D;
        Point point;
        BufferedImage bufferedImage = Z.H();
        if (bufferedImage == null) {
            return null;
        }
        Point point2 = point = MouseInfo.getPointerInfo().getLocation();
        int n2 = point2.x - 3;
        int n3 = point2.y - 3;
        Graphics2D graphics2D2 = graphics2D = bufferedImage.createGraphics();
        Graphics2D graphics2D3 = graphics2D;
        Ua.ALLATORIxDEMO(graphics2D3);
        graphics2D3.setStroke(ALLATORIxDEMO);
        graphics2D2.setColor(Color.RED);
        graphics2D2.drawOval(n2, n3, 6, 6);
        graphics2D2.dispose();
        return bufferedImage;
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(int a2, int a3, int a4) {
        int n2 = a2 >> 16 & 0xFF;
        int n3 = a2 >> 8 & 0xFF;
        int n4 = a2 & 0xFF;
        int n5 = a2 >> 16 & 0xFF;
        int n6 = a3 >> 8 & 0xFF;
        a3 &= 0xFF;
        n2 = Math.abs(n2 - n5);
        n3 = Math.abs(n3 - n6);
        a3 = Math.abs(n4 - a3);
        return n2 <= a4 && n3 <= a4 && a3 <= a4;
    }

    public static /* synthetic */ BufferedImage H() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Object object = new Rectangle(dimension);
        try {
            Robot robot = new Robot();
            object = robot.createScreenCapture((Rectangle)object);
            return object;
        }
        catch (AWTException aWTException) {
            aWTException.printStackTrace();
            return null;
        }
    }

    private /* synthetic */ Z() {
        Z a2;
    }
}

