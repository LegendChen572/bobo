/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import client.messages.CommandExecute;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import server.MobSkillData;

public final class Ua {
    public static final /* synthetic */ BufferedImage ALLATORIxDEMO;

    public static /* synthetic */ BufferedImage ALLATORIxDEMO(byte[] a2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a2);
        try {
            return ImageIO.read(byteArrayInputStream);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ BufferedImage ALLATORIxDEMO(File a2) {
        try {
            BufferedImage bufferedImage = ImageIO.read(a2);
            return bufferedImage;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private /* synthetic */ Ua() {
        Ua a2;
    }

    public static /* synthetic */ BufferedImage ALLATORIxDEMO(BufferedImage a2, int a32) {
        BufferedImage bufferedImage = a2;
        int n2 = bufferedImage.getWidth();
        int n3 = bufferedImage.getHeight();
        BufferedImage bufferedImage2 = new BufferedImage(n2, n3, a32);
        Graphics2D a32 = bufferedImage2.createGraphics();
        a32.drawImage((Image)a2, 0, 0, null);
        a32.dispose();
        return bufferedImage2;
    }

    public static /* synthetic */ void H(Graphics2D a2) {
        Graphics2D graphics2D = a2;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
    }

    public static /* synthetic */ BufferedImage ALLATORIxDEMO(BufferedImage a2, float a32) {
        if (a32 == 1.0f) {
            return a2;
        }
        BufferedImage bufferedImage = a2;
        int n2 = (int)((float)bufferedImage.getWidth() * a32);
        int a32 = (int)((float)bufferedImage.getHeight() * a32);
        return Ua.ALLATORIxDEMO(bufferedImage, n2, a32);
    }

    public static /* synthetic */ BufferedImage H(String a2) {
        try {
            BufferedImage bufferedImage = ImageIO.read(Ua.class.getClassLoader().getResource(a2));
            return bufferedImage;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ Shape ALLATORIxDEMO(BufferedImage a2) {
        int n2;
        Area area = new Area();
        BufferedImage bufferedImage = a2;
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        int n5 = n2 = 0;
        while (n5 < n3) {
            int n6;
            int n7 = n6 = 0;
            while (n7 < n4) {
                if ((a2.getRGB(n2, n6) >> 24 & 0xFF) != 0) {
                    Shape shape = new Rectangle(n2, n6, 1, 1);
                    shape = new Area(shape);
                    area.add((Area)shape);
                }
                n7 = ++n6;
            }
            n5 = ++n2;
        }
        return area;
    }

    public static /* synthetic */ byte[] ALLATORIxDEMO(BufferedImage a2, String a3) {
        Object object;
        a3 = new ByteArrayOutputStream();
        try {
            ImageIO.write((RenderedImage)a2, CommandExecute.ALLATORIxDEMO("\u0005?\u0012"), (OutputStream)a3);
            object = a3;
        }
        catch (IOException iOException) {
            object = a3;
            iOException.printStackTrace();
        }
        byte[] arrby = ((ByteArrayOutputStream)object).toByteArray();
        return arrby;
    }

    public static /* synthetic */ byte[] ALLATORIxDEMO(BufferedImage a2) {
        return Ua.ALLATORIxDEMO(a2, MobSkillData.ALLATORIxDEMO("].J"));
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new BufferedImage(1, 1, 2);
    }

    public static /* synthetic */ BufferedImage ALLATORIxDEMO(String a2) {
        return Ua.ALLATORIxDEMO(new File(a2));
    }

    public static /* synthetic */ void ALLATORIxDEMO(Graphics2D a2) {
        Graphics2D graphics2D = a2;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    }

    public static /* synthetic */ byte[] ALLATORIxDEMO(BufferedImage a2, float a32) {
        ImageWriter imageWriter = ImageIO.getImageWritersByFormatName(CommandExecute.ALLATORIxDEMO("\u001f!\u0012")).next();
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageWriteParam imageWriteParam2 = imageWriteParam;
        imageWriteParam2.setCompressionMode(2);
        imageWriteParam2.setCompressionQuality(a32);
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            ImageOutputStream a32 = ImageIO.createImageOutputStream(byteArrayOutputStream2);
            ImageWriter imageWriter2 = imageWriter;
            imageWriter2.setOutput(a32);
            imageWriter2.write(a2);
            return byteArrayOutputStream2.toByteArray();
        }
        catch (IOException a32) {
            a32.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ BufferedImage ALLATORIxDEMO(BufferedImage a2, int a3, int a4) {
        Graphics2D graphics2D;
        if (a2.getWidth() == a3 && a2.getHeight() == a4) {
            return a2;
        }
        int n2 = a2.getType();
        BufferedImage bufferedImage = new BufferedImage(a3, a4, n2);
        Graphics2D graphics2D2 = graphics2D = bufferedImage.createGraphics();
        Ua.H(graphics2D2);
        graphics2D2.drawImage(a2, 0, 0, a3, a4, null);
        graphics2D.dispose();
        return bufferedImage;
    }
}

