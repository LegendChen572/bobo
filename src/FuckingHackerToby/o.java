/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.Xa;
import FuckingHackerToby.e;
import handling.world.family.MapleFamilyCharacter;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.Painter;
import javax.swing.UIDefaults;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import tools.use.GetMACAddress;

public final class o {
    private static final /* synthetic */ Painter<?> k;
    private static final /* synthetic */ Painter<?> g;
    private static final /* synthetic */ Painter<?> a;
    private static final /* synthetic */ Painter<?> K;
    private static final /* synthetic */ Color M;
    private static final /* synthetic */ Painter<?> d;
    private static final /* synthetic */ Painter<?> H;
    private static final /* synthetic */ Painter<?> ALLATORIxDEMO;
    private static final /* synthetic */ Font C;
    private static final /* synthetic */ Color I;
    private static final /* synthetic */ Color i;
    private static final /* synthetic */ Color j;
    private static final /* synthetic */ EmptyBorder F;
    private static final /* synthetic */ Painter<?> B;
    private static final /* synthetic */ Painter<?> E;
    private static final /* synthetic */ Color J;
    private static final /* synthetic */ Painter<?> e;

    public static /* synthetic */ {
        Font font;
        j = new Color(250, 250, 255);
        i = new Color(200, 200, 200);
        J = new Color(235, 235, 235);
        M = new Color(185, 185, 185);
        I = new Color(225, 225, 225);
        F = new EmptyBorder(2, 5, 2, 5);
        H = (a2, a3, a4, a5) -> {
            Graphics2D graphics2D = a2;
            graphics2D.setColor(M);
            graphics2D.fillRect(0, 0, a4, a5);
        };
        e = (a2, a3, a4, a5) -> {
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            graphics2D.setColor(new Color(190, 190, 190));
            int n2 = a4;
            graphics2D.fillRect(a4 / 10, a5 / 2, n2 - n2 / 10 * 2, a5 / 4);
        };
        E = (a2, a3, a4, a5) -> {
            Graphics2D graphics2D = a2;
            graphics2D.setColor(j);
            graphics2D.fillRect(0, 0, a4, a5);
        };
        g = (a2, a3, a4, a5) -> {
            a3 = new GradientPaint(0.0f, 0.0f, new Color(250, 250, 250), 0.0f, a5, new Color(190, 190, 190));
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D2.setPaint((Paint)a3);
            graphics2D.fillRoundRect(0, 0, a4, a5, 5, 5);
            Graphics2D graphics2D3 = a2;
            graphics2D.setPaint(new Color(170, 170, 170));
            graphics2D.drawRoundRect(0, 0, a4 - 1, a5 - 1, 5, 5);
        };
        B = (a2, a3, a4, a5) -> {
            a3 = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255), 0.0f, a5, new Color(200, 200, 200));
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D2.setPaint((Paint)a3);
            graphics2D.fillRoundRect(0, 0, a4, a5, 5, 5);
            Graphics2D graphics2D3 = a2;
            graphics2D.setPaint(new Color(160, 160, 160));
            graphics2D.drawRoundRect(0, 0, a4 - 1, a5 - 1, 5, 5);
        };
        k = (a2, a3, a4, a5) -> {
            a3 = new GradientPaint(0.0f, 0.0f, new Color(200, 200, 200), 0.0f, a5, new Color(230, 230, 230));
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D2.setPaint((Paint)a3);
            graphics2D.fillRoundRect(0, 0, a4, a5, 5, 5);
            Graphics2D graphics2D3 = a2;
            graphics2D.setPaint(new Color(180, 180, 180));
            graphics2D.drawRoundRect(0, 0, a4 - 1, a5 - 1, 5, 5);
        };
        K = (a2, a3, a4, a5) -> {
            a3 = new GradientPaint(0.0f, 0.0f, new Color(190, 190, 190), 0.0f, a5 / 2, new Color(225, 225, 225));
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D2.setPaint((Paint)a3);
            graphics2D.fillRect(0, 0, a4, a5);
            Graphics2D graphics2D3 = a2;
            graphics2D.setPaint(new Color(150, 150, 150));
            graphics2D.drawRect(0, 0, a4 - 1, a5 - 1);
        };
        a = (a2, a3, a4, a5) -> {
            a3 = new GradientPaint(0.0f, a5 / 2, new Color(225, 225, 225), 0.0f, a5, new Color(190, 190, 190));
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            Graphics2D graphics2D3 = a2;
            a2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D3.setPaint((Paint)a3);
            graphics2D3.fillRect(0, 0, a4, a5);
            Graphics2D graphics2D4 = a2;
            graphics2D2.setPaint(new Color(130, 130, 130));
            int n2 = a5;
            graphics2D2.drawLine(a4 - 1, a5 / 6, a4 - 1, n2 - n2 / 6);
            graphics2D2.setPaint(new Color(150, 150, 150));
            graphics2D.drawLine(0, 0, a4 - 1, 0);
            graphics2D.drawLine(0, a5 - 1, a4 - 1, a5 - 1);
        };
        d = (a2, a3, a4, a5) -> {
            a3 = new GradientPaint(0.0f, a5 / 2, new Color(230, 230, 230), 0.0f, a5, new Color(200, 200, 200));
            Graphics2D graphics2D = a2;
            Graphics2D graphics2D2 = a2;
            Graphics2D graphics2D3 = a2;
            a2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D3.setPaint((Paint)a3);
            graphics2D3.fillRect(0, 0, a4, a5);
            Graphics2D graphics2D4 = a2;
            graphics2D2.setPaint(new Color(130, 130, 130));
            int n2 = a5;
            graphics2D2.drawLine(a4 - 1, a5 / 6, a4 - 1, n2 - n2 / 6);
            graphics2D2.setPaint(new Color(150, 150, 150));
            graphics2D.drawLine(0, 0, a4 - 1, 0);
            graphics2D.drawLine(0, a5 - 1, a4 - 1, a5 - 1);
        };
        ALLATORIxDEMO = (a2, a3, a4, a5) -> {
            Graphics2D graphics2D = a2;
            a2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            a2.setPaint(new Color(240, 240, 240));
            graphics2D.fillRect(0, 0, a4, a5);
            graphics2D.setPaint(new Color(150, 150, 150));
            graphics2D.drawRect(0, 0, a4 - 1, a5 - 1);
        };
        try {
            Font font2;
            font = font2 = Font.createFont(0, Xa.class.getClassLoader().getResourceAsStream(GetMACAddress.ALLATORIxDEMO("}\u00066\u0011|\u0010v\u0016k\u0000|Lu\u0002m\f7\u0017m\u0005"))).deriveFont(14.0f);
        }
        catch (FontFormatException | IOException exception) {
            Font font3;
            exception.printStackTrace();
            font = font3 = new Font(MapleFamilyCharacter.ALLATORIxDEMO("p0A Q!L'Pbi\u0011"), 0, 14);
        }
        C = font;
    }

    private /* synthetic */ o() {
        o a2;
    }

    public static /* synthetic */ void ALLATORIxDEMO(UIDefaults a2) {
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("J+I Q1f#W'"), Color.GRAY);
        a2.put(GetMACAddress.ALLATORIxDEMO("\u0000v\rm\u0011v\u000f"), j);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("6A:P\nM%L.M%L6"), M);
        a2.put(GetMACAddress.ALLATORIxDEMO("\rp\u000e{\u0016j%v\u0000l\u0010"), I);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016A:P\u0003V'E\u0019a,E H'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), E);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\u0006a\u0017_\n|\u000f}8\\\rx\u0001u\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), E);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0004K0I#P6A&p'\\6b+A.@\u0019a,E H'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), E);
        a2.put(GetMACAddress.ALLATORIxDEMO("!l\u0017m\fw8\\\rx\u0001u\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), g);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-J\u0019`'B#Q.P\u001f\n E!O%V-Q,@\u0012E+J6A0"), g);
        a2.put(GetMACAddress.ALLATORIxDEMO("!l\u0017m\fw8_\fz\u0016j\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), g);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-J\u0019`'B#Q.Pib-G7W'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), g);
        a2.put(GetMACAddress.ALLATORIxDEMO("!l\u0017m\fw8T\fl\u0010|,o\u0006k>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), B);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-J\u0019`'B#Q.Pii-Q1A\rR'V\u001f\n E!O%V-Q,@\u0012E+J6A0"), B);
        a2.put(GetMACAddress.ALLATORIxDEMO("!l\u0017m\fw8_\fz\u0016j\u0006}HT\fl\u0010|,o\u0006k>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), B);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-J\u0019`'B#Q.Pib-G7W'@ii-Q1A\rR'V\u001f\n E!O%V-Q,@\u0012E+J6A0"), B);
        a2.put(GetMACAddress.ALLATORIxDEMO("!l\u0017m\fw8I\u0011|\u0010j\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), k);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-J\u0019`'B#Q.Pit0A1W'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), k);
        a2.put(GetMACAddress.ALLATORIxDEMO("!l\u0017m\fw8_\fz\u0016j\u0006}HI\u0011|\u0010j\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), k);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-J\u0019`'B#Q.Pib-G7W'@it0A1W'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), k);
        a2.put(GetMACAddress.ALLATORIxDEMO("7v\u0004~\u000f|!l\u0017m\fw8\\\rx\u0001u\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), g);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016K%C.A\u0000Q6P-J\u0019b-G7W'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), g);
        a2.put(GetMACAddress.ALLATORIxDEMO("7v\u0004~\u000f|!l\u0017m\fw8T\fl\u0010|,o\u0006k>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), B);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016K%C.A\u0000Q6P-J\u0019b-G7W'@ii-Q1A\rR'V\u001f\n E!O%V-Q,@\u0012E+J6A0"), B);
        a2.put(GetMACAddress.ALLATORIxDEMO("7v\u0004~\u000f|!l\u0017m\fw8I\u0011|\u0010j\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), B);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016K%C.A\u0000Q6P-J\u0019b-G7W'@it0A1W'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), B);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\f~\u0004u\u0006[\u0016m\u0017v\rB0|\u000f|\u0000m\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), k);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("p-C%H'f7P6K,\u007f\u0004K!Q1A&\u000f\u0011A.A!P'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), k);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\f~\u0004u\u0006[\u0016m\u0017v\rB.v\u0016j\u0006V\u0015|\u001120|\u000f|\u0000m\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), k);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("p-C%H'f7P6K,\u007f\u0004K!Q1A&\u000f\u000fK7W'k4A0\u000f\u0011A.A!P'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), k);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\f~\u0004u\u0006[\u0016m\u0017v\rB3k\u0006j\u0010|\u000720|\u000f|\u0000m\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), k);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("p-C%H'f7P6K,\u007f\u0004K!Q1A&\u000f\u0012V'W1A&\u000f\u0011A.A!P'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), k);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\u0002{\u000f|M{\u0002z\b~\u0011v\u0016w\u0007"), new ColorUIResource(J));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016E H'\n%V+@\u0001K.K0"), i);
        a2.put(GetMACAddress.ALLATORIxDEMO("7x\u0001u\u0006#AM\u0002{\u000f|Mz\u0006u\u000fK\u0006w\u0007|\u0011|\u0011;M{\u0002z\b~\u0011v\u0016w\u0007"), J);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016E H'\n#H6A0J#P'v-S\u0001K.K0"), J);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\u0002{\u000f|8\\\rx\u0001u\u0006}HJ\u0006u\u0006z\u0017|\u0007DMm\u0006a\u0017[\u0002z\b~\u0011v\u0016w\u0007"), M);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("p#F.AlB-G7W\u0001A.H\nM%L.M%L6f-V&A0"), F);
        a2.put(GetMACAddress.ALLATORIxDEMO("7x\u0001u\u0006Q\u0006x\u0007|\u0011#AM\u0002{\u000f|+|\u0002}\u0006kMk\u0006w\u0007|\u0011|\u0011;8\\\rx\u0001u\u0006}H_\fz\u0016j\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), a);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016E H'l'E&A0\u001e`p#F.A\nA#@'VlV'J&A0A0\u0006\u0019a,E H'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), a);
        a2.put(GetMACAddress.ALLATORIxDEMO("7x\u0001u\u0006Q\u0006x\u0007|\u0011#AM\u0002{\u000f|+|\u0002}\u0006kMk\u0006w\u0007|\u0011|\u0011;8T\fl\u0010|,o\u0006k>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), d);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016E H'l'E&A0\u001e`p#F.A\nA#@'VlV'J&A0A0\u0006\u0019t0A1W'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), a);
        a2.put(GetMACAddress.ALLATORIxDEMO("I\fi\u0016i.|\rl8\\\rx\u0001u\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), ALLATORIxDEMO);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("i'J7\u007f\u0007J#F.A&\u000f\u0011A.A!P'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), H);
        a2.put(GetMACAddress.ALLATORIxDEMO(".|\rl*m\u0006t8T\fl\u0010|,o\u0006k>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), H);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0012K2Q2i'J7w'T#V#P-V\u0019a,E H'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), e);
        a2.put(GetMACAddress.ALLATORIxDEMO("T\u0006w\u0016[\u0002k8\\\rx\u0001u\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), K);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016V'Axp0A'g'H.\u007f\u0007J#F.A&\u000f\u0011A.A!P'@\u001f\n E!O%V-Q,@\u0012E+J6A0"), H);
        a2.put(GetMACAddress.ALLATORIxDEMO("7k\u0006|YM\u0011|\u0006Z\u0006u\u000fB%v\u0000l\u0010|\u000720|\u000f|\u0000m\u0006}>7\u0001x\u0000r\u0004k\fl\r}3x\nw\u0017|\u0011"), H);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u000eM1P\u0019w'H'G6A&ylP'\\6f#G)C0K7J&"), M);
        a2.put(GetMACAddress.ALLATORIxDEMO("/p\u0010m8J\u0006u\u0006z\u0017|\u0007DMm\u0006a\u0017_\fk\u0006~\u0011v\u0016w\u0007"), Color.WHITE);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0000Q6P-JlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\u0002{\u000f|M\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("h#F'HlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\u0002{\u000f|+|\u0002}\u0006kM\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("b+H'g*K-W'VlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("M\u0006a\u0017_\n|\u000f}M\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016A:P\u0003V'ElB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("%v\u0011t\u0002m\u0017|\u0007M\u0006a\u0017_\n|\u000f}M\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("t-T7T\u000fA,QlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO(".|\rlM\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u000fA,Q\u000bP'IlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("I\u0002w\u0006uM\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0016V'AlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("7v\u0004~\u000f|!l\u0017m\fwM\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u000eM1PlB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO(",i\u0017p\fw3x\r|M\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0001K/F-f-\\lB-J6"), C);
        a2.put(GetMACAddress.ALLATORIxDEMO("7p\u0017u\u0006}!v\u0011}\u0006kM\u007f\fw\u0017"), C);
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("k2P+K,t#J'\n'V0K0m!K,"), new ImageIcon(FuckingHackerToby.e.M));
        a2.put(GetMACAddress.ALLATORIxDEMO("V\u0013m\nv\rI\u0002w\u00067\nw\u0005v\u0011t\u0002m\nv\rP\u0000v\r"), new ImageIcon(FuckingHackerToby.e.I));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\rT6M-J\u0012E,AlU7A1P+K,m!K,"), new ImageIcon(FuckingHackerToby.e.E));
        a2.put(GetMACAddress.ALLATORIxDEMO("V\u0013m\nv\rI\u0002w\u00067\u0014x\u0011w\nw\u0004P\u0000v\r"), new ImageIcon(FuckingHackerToby.e.g));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0004M.A\u0001L-K1A0\n&M0A!P-V;m!K,"), new ImageIcon(FuckingHackerToby.e.O));
        a2.put(GetMACAddress.ALLATORIxDEMO("%p\u000f| q\fv\u0010|\u00117\u0005u\fi\u0013`'k\no\u0006P\u0000v\r"), new ImageIcon(FuckingHackerToby.e.Y));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("b+H'g*K-W'VlL-I'b-H&A0m!K,"), new ImageIcon(FuckingHackerToby.e.D));
        a2.put(GetMACAddress.ALLATORIxDEMO("_\nu\u0006Z\u000bv\fj\u0006kMu\nj\u0017O\n|\u0014P\u0000v\r"), new ImageIcon(FuckingHackerToby.e.R));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0004M.A\u0001L-K1A0\n,A5b-H&A0m!K,"), new ImageIcon(FuckingHackerToby.e.L));
        a2.put(GetMACAddress.ALLATORIxDEMO("_\nu\u0006Z\u000bv\fj\u0006kMl\u0013_\fu\u0007|\u0011P\u0000v\r"), new ImageIcon(FuckingHackerToby.e.Z));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("\u0004M.A\u0001L-K1A0\n*E0@\u0006V+R'm!K,"), new ImageIcon(FuckingHackerToby.e.N));
        a2.put(GetMACAddress.ALLATORIxDEMO("%p\u000f| q\fv\u0010|\u00117\u0007|\u0017x\nu\u0010O\n|\u0014P\u0000v\r"), new ImageIcon(FuckingHackerToby.e.t));
        a2.put(MapleFamilyCharacter.ALLATORIxDEMO("b+H'g*K-W'VlB+H'm!K,"), new ImageIcon(FuckingHackerToby.e.s));
    }
}

