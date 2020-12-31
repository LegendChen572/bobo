/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import provider.MapleCanvas;

public class FileStoredPngMapleCanvas
implements MapleCanvas {
    private /* synthetic */ int d;
    private /* synthetic */ File K;
    private /* synthetic */ BufferedImage ALLATORIxDEMO;
    private /* synthetic */ int a;

    @Override
    public /* synthetic */ int getHeight() {
        FileStoredPngMapleCanvas a2;
        return a2.d;
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        FileStoredPngMapleCanvas a2;
        if (a2.ALLATORIxDEMO == null) {
            try {
                FileStoredPngMapleCanvas fileStoredPngMapleCanvas = a2;
                fileStoredPngMapleCanvas.ALLATORIxDEMO = ImageIO.read(fileStoredPngMapleCanvas.K);
                fileStoredPngMapleCanvas.a = fileStoredPngMapleCanvas.ALLATORIxDEMO.getWidth();
                fileStoredPngMapleCanvas.d = fileStoredPngMapleCanvas.ALLATORIxDEMO.getHeight();
                return;
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        }
    }

    @Override
    public /* synthetic */ BufferedImage getImage() {
        FileStoredPngMapleCanvas a2;
        FileStoredPngMapleCanvas fileStoredPngMapleCanvas = a2;
        fileStoredPngMapleCanvas.ALLATORIxDEMO();
        return fileStoredPngMapleCanvas.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ int getWidth() {
        FileStoredPngMapleCanvas a2;
        return a2.a;
    }

    public /* synthetic */ FileStoredPngMapleCanvas(int a2, int a3, File a4) {
        FileStoredPngMapleCanvas a5;
        FileStoredPngMapleCanvas fileStoredPngMapleCanvas = a5;
        a5.a = a2;
        fileStoredPngMapleCanvas.d = a3;
        fileStoredPngMapleCanvas.K = a4;
    }
}

