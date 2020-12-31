/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.messages.commands.GMCommand;
import constants.ServerConstants;
import handling.world.sidekick.MapleSidekick;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.AttributedString;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import provider.MapleData;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import tools.Pair;

/*
 * Exception performing whole class analysis ignored.
 */
public class CheckCodeImageCreator {
    public /* synthetic */ CheckCodeImageCreator() {
        CheckCodeImageCreator a2;
    }

    public static /* synthetic */ Color getRandColor(int a2, int a3) {
        int n2;
        int n3;
        Random random = new Random();
        if (a2 > 255) {
            a2 = 255;
        }
        if (a3 > 255) {
            a3 = 255;
        }
        if (a2 > a3) {
            n3 = a2 - a3;
            n2 = a2;
        } else {
            n3 = a3 - a2;
            n2 = a2;
        }
        a3 = n2 + random.nextInt(n3);
        int n4 = a2 + random.nextInt(n3);
        int n5 = a2 + random.nextInt(n3);
        return new Color(a3, n4, n5);
    }

    public static /* synthetic */ void coloredAndRotation(String a2, int a3, Graphics2D a4, int a5, int a62, int a72) {
        float f2;
        Random random = new Random();
        Graphics2D graphics2D = a4;
        graphics2D.setColor(CheckCodeImageCreator.getRandColor(5, 100));
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        Rectangle2D rectangle2D = fontMetrics.getStringBounds(a2, a4);
        a3 = a62 / a5 / 2 + a62 * a3 / a5;
        a5 = a72 / 2 + 10 - random.nextInt(11);
        Random random2 = random;
        a62 = random2.nextInt(30);
        Object a72 = new AffineTransform();
        ((AffineTransform)a72).rotate((-15.0 + (double)a62) * Math.PI / 180.0, a3, a5);
        float a62 = random2.nextFloat() + 0.8f;
        if (f2 > 1.0f) {
            a62 = 1.0f;
        }
        ((AffineTransform)a72).scale(a62, a62);
        a4.setTransform((AffineTransform)a72);
        int n2 = a62 = 1;
        while (n2 >= 0) {
            Random random3;
            if (a62 == 1) {
                random3 = random;
                a4.setComposite(AlphaComposite.SrcOver.derive(0.5f));
            } else {
                a4.setComposite(AlphaComposite.SrcOver.derive(1.0f));
                random3 = random;
            }
            if (random3.nextInt(2) == 0) {
                Object object = a72 = new AttributedString(a2);
                ((AttributedString)object).addAttribute(TextAttribute.FONT, a4.getFont());
                ((AttributedString)object).addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 0, 1);
                a4.drawString(((AttributedString)object).getIterator(), a3 - (int)rectangle2D.getCenterX(), a5 + (fontMetrics.getHeight() - fontMetrics.getDescent()) / 2 * a62 + random.nextInt(fontMetrics.getDescent() / 2));
            } else {
                a4.drawString(a2, a3 - (int)rectangle2D.getCenterX(), a5 + (fontMetrics.getHeight() - fontMetrics.getDescent()) / 2 * a62 + random.nextInt(fontMetrics.getDescent() / 2));
            }
            n2 = --a62;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ String getRandWord(int a, int a, int a, Graphics2D a, ServerConstants.MapleType a) {
        var5_5 = new Random();
        var6_6 = "";
        var7_7 = "";
        var8_8 = MapleDataProviderFactory.getDataProvider(MapleSidekick.ALLATORIxDEMO("#\u0017\u0002\n\u001e\u0004^\u0014\n")).getData(GMCommand.ALLATORIxDEMO("/]\u0000\u001c\u000b_\u0005"));
        var9_10 = new LinkedList<String>();
        v0 = var8_8 = var8_8.getChildren().iterator();
        while (v0.hasNext()) {
            var10_11 = (MapleData)var8_8.next();
            v0 = var8_8;
            var9_10.add(MapleDataTool.getString(var10_11.getChildByPath(MapleSidekick.ALLATORIxDEMO("\r\u0011\u000e\u0015")), ""));
        }
        v1 = var8_9 = 0;
        while (v1 < a) {
            block6: {
                var7_7 = "";
                switch (1.ALLATORIxDEMO[a.ordinal()]) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        while (var7_7.isEmpty()) {
                            v2 = var9_10;
                            var10_12 = (String)v2.get(var5_5.nextInt(v2.size()));
                            var10_12 = var10_12.replaceAll(GMCommand.ALLATORIxDEMO("i\u0003\u001f\u0018sOh?"), "");
                            if ((var10_12 = var10_12.replaceAll(MapleSidekick.ALLATORIxDEMO("8.?\u0000/-"), "")).isEmpty()) continue;
                            v3 = var10_12;
                            v4 = var5_5.nextInt(v3.length());
                            var7_7 = v3.substring(v4, v4 + 1);
                            v5 = var6_6;
                            break block6;
                        }
                        break;
                    }
                    default: {
                        if (var5_5.nextInt(2) != 1) ** GOTO lbl36
                        var10_13 = var5_5.nextInt(2) == 0 ? 65 : 97;
                        var7_7 = String.valueOf((char)(var5_5.nextInt(26) + var10_13));
                        v5 = var6_6;
                        break block6;
lbl36:
                        // 1 sources

                        var7_7 = String.valueOf(var5_5.nextInt(10));
                    }
                }
                v5 = var6_6;
            }
            var6_6 = (String)v5 + var7_7;
            CheckCodeImageCreator.coloredAndRotation(var7_7, var8_9++, a, a, a, a);
            v1 = var8_9;
        }
        return var6_6;
    }

    public static /* synthetic */ void main(String[] a2) {
        FileInputStream fileInputStream;
        System.out.println(MapleSidekick.ALLATORIxDEMO("z@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@SiSCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCP@z@PCPCPCPCS@P@PCP@PCPCS@P@S@P@S@P@SCP@S@PCPCPCPCSiSCPCPCPCSCSCSCPCSCPCSCSCP@PCSCSCSCSCP@PCPCPCPCP@z@PCPCPCP@S@P@PCP@PCP@S@PCSCP@P@P@SCPCSCPCPCPCPCSiSCPCPCPCSCSCS@SCS@SCSCSCP@PCS@SCSCSCS@SCPCPCPCP@z@PCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCSiSC?\u0001\u0016\u0016\u0003\u0000\u0011\u0017\u0019\f\u001eC\u0012\u001aP\"\u001c\u000f\u0011\u0017\u001f\u0011\u0019C?\u0001\u0016\u0016\u0003\u0000\u0011\u0017\u001f\u0011P\u0015GMCC4&=,P@z@PCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCSiSCPCPCPCPCPC\u0018\u0017\u0004\u0013JL_\u0014\u0007\u0014^\u0002\u001c\u000f\u0011\u0017\u001f\u0011\u0019M\u0013\f\u001dCPCPCPCPCPCP@z@PCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCPCSiS@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@S@z"));
        Object object = CheckCodeImageCreator.createCheckCode(false);
        try {
            fileInputStream = new FileInputStream((File)((Pair)object).getRight());
            object = new File(((Pair)object).getLeft() + ".jpg");
            if (((File)object).exists()) {
                ((File)object).delete();
            }
            ((File)object).createNewFile();
            object = new FileOutputStream((File)object);
            byte[] arrby = new byte[512];
            int n2 = -1;
            FileInputStream fileInputStream2 = fileInputStream;
            while ((n2 = fileInputStream2.read(arrby)) > 0) {
                fileInputStream2 = fileInputStream;
                ((FileOutputStream)object).write(arrby, 0, n2);
            }
        }
        catch (Exception exception) {
            return;
        }
        ((FileOutputStream)object).close();
        fileInputStream.close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ Pair<String, File> createCheckCode(boolean a2) {
        File file;
        String[] arrstring;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = 196;
        int n7 = 44;
        BufferedImage bufferedImage = new BufferedImage(n6, n7, 1);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        Random random = new Random();
        Graphics2D graphics2D2 = graphics2D;
        graphics2D2.setColor(CheckCodeImageCreator.getRandColor(254, 255));
        graphics2D2.fillRect(0, 0, n6, n7);
        int n8 = 2000 + random.nextInt(500);
        int n9 = n5 = 0;
        while (n9 < n8) {
            Random random2 = random;
            Graphics2D graphics2D3 = graphics2D;
            graphics2D3.setColor(CheckCodeImageCreator.getRandColor(80, 150));
            n4 = random.nextInt(n6);
            n3 = random2.nextInt(n7);
            int n10 = n2 = random2.nextInt(2);
            graphics2D3.fillRect(n4, n3, n10, n10);
            n9 = ++n5;
        }
        n5 = 2 + random.nextInt(3);
        int n11 = n4 = 0;
        while (n11 < n5) {
            Random random3 = random;
            Graphics2D graphics2D4 = graphics2D;
            graphics2D4.setColor(CheckCodeImageCreator.getRandColor(80, 150));
            n3 = random3.nextInt(n6 - 50);
            n2 = random3.nextInt(n7 + 20);
            n8 = 50 + random.nextInt(50);
            int n12 = -20 + random.nextInt(50);
            int n13 = n3;
            graphics2D4.drawLine(n13, n2, n13 + n8, n2 + n12);
            n11 = ++n4;
        }
        ServerConstants.MapleType mapleType = ServerConstants.MAPLE_TYPE;
        switch (1.ALLATORIxDEMO[mapleType.ordinal()]) {
            case 1: {
                String[] arrstring2 = new String[1];
                arrstring2[0] = GMCommand.ALLATORIxDEMO("p\u0003F\u0003\\\u0005");
                arrstring = arrstring2;
                break;
            }
            case 2: {
                String[] arrstring3 = new String[1];
                arrstring3[0] = MapleSidekick.ALLATORIxDEMO("=0P$\u001f\u0017\u0018\n\u0013");
                arrstring = arrstring3;
                break;
            }
            case 3: {
                String[] arrstring4 = new String[4];
                arrstring4[0] = GMCommand.ALLATORIxDEMO("a\u000b_\u0011G\f");
                arrstring4[1] = MapleSidekick.ALLATORIxDEMO("=\n\u0013\u0011\u001f\u0010\u001f\u0005\u0004C)\u00028\u0006\u0019");
                arrstring4[2] = GMCommand.ALLATORIxDEMO(")S\u000bf\u000b");
                arrstring4[3] = MapleSidekick.ALLATORIxDEMO("0\u0019\u000e8\u0006\u0019");
                arrstring = arrstring4;
                break;
            }
            case 4: {
                String[] arrstring5 = new String[4];
                arrstring5[0] = GMCommand.ALLATORIxDEMO("/[\fU.[7");
                arrstring5[1] = MapleSidekick.ALLATORIxDEMO(".\u0019\u0000\u0002\f\u0003\f\u0016\u0017P)\u0018\u0006\u001e\u00048\u0006\u0019");
                arrstring5[2] = GMCommand.ALLATORIxDEMO("v$y\u0003[Oa ");
                arrstring5[3] = MapleSidekick.ALLATORIxDEMO("0\u0019\u000e8\u0006\u0019");
                arrstring = arrstring5;
                break;
            }
            default: {
                String[] arrstring6 = new String[1];
                arrstring6[0] = GMCommand.ALLATORIxDEMO("#@\u000bS\u000e");
                arrstring = arrstring6;
            }
        }
        Font font = new Font(arrstring[(int)(Math.random() * (double)arrstring.length)], 3, 25);
        graphics2D.setFont(font);
        String string = CheckCodeImageCreator.getRandWord(4, n6, n7, graphics2D, a2 ? ServerConstants.MapleType.GLOBAL : mapleType);
        if (string.isEmpty()) {
            return null;
        }
        graphics2D.dispose();
        File file2 = null;
        try {
            file2 = File.createTempFile(MapleSidekick.ALLATORIxDEMO("=\u0002\u0000\u000f\u00150\u0004\f\u0002\u001a3\u000b\u0015\u0000\u001b \u001f\u0007\u0015"), "");
            ImageIO.write((RenderedImage)bufferedImage, GMCommand.ALLATORIxDEMO("x2w%"), file2);
            file = file2;
        }
        catch (IOException iOException) {
            Logger.getLogger(CheckCodeImageCreator.class.getName()).log(Level.SEVERE, null, iOException);
            file = file2;
        }
        if (file == null) {
            return null;
        }
        return new Pair<String, File>(string, file2);
    }
}

