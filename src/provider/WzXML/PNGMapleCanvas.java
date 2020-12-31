/*
 * Decompiled with CFR 0.150.
 */
package provider.WzXML;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import provider.MapleCanvas;
import server.maps.MapleNodes;

public class PNGMapleCanvas
implements MapleCanvas {
    private /* synthetic */ int K;
    private static final /* synthetic */ int[] B;
    private /* synthetic */ int k;
    private /* synthetic */ byte[] ALLATORIxDEMO;
    private /* synthetic */ int d;
    private /* synthetic */ int a;

    public /* synthetic */ byte[] getData() {
        PNGMapleCanvas a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ {
        int[] arrn = new int[4];
        arrn[0] = 2;
        arrn[1] = 1;
        arrn[2] = 0;
        arrn[3] = 3;
        B = arrn;
    }

    @Override
    public /* synthetic */ int getHeight() {
        PNGMapleCanvas a2;
        return a2.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public /* synthetic */ BufferedImage getImage() {
        PNGMapleCanvas pNGMapleCanvas;
        PNGMapleCanvas a2;
        int n2 = 0;
        int n3 = 0;
        int n4 = 2;
        int n5 = 3;
        byte[] arrby = new byte[n4];
        switch (a2.getFormat()) {
            case 1: 
            case 513: {
                PNGMapleCanvas pNGMapleCanvas2 = a2;
                pNGMapleCanvas = pNGMapleCanvas2;
                n2 = pNGMapleCanvas2.getHeight() * a2.getWidth() * 4;
                break;
            }
            case 2: {
                PNGMapleCanvas pNGMapleCanvas3 = a2;
                pNGMapleCanvas = pNGMapleCanvas3;
                n2 = pNGMapleCanvas3.getHeight() * a2.getWidth() * 8;
                break;
            }
            case 517: {
                n2 = a2.getHeight() * a2.getWidth() / 128;
            }
            default: {
                pNGMapleCanvas = a2;
            }
        }
        n3 = pNGMapleCanvas.getHeight() * a2.getWidth() * 8;
        if (n3 > n4) {
            n4 = n3;
            arrby = new byte[n4];
        }
        if (a2.getHeight() > n5) {
            n5 = a2.getHeight();
        }
        Inflater inflater = new Inflater();
        inflater.setInput(a2.getData(), 0, a2.a);
        n4 = 0;
        byte[] arrby2 = new byte[n2];
        try {
            n4 = inflater.inflate(arrby2);
        }
        catch (DataFormatException dataFormatException) {
            throw new RuntimeException(MapleNodes.ALLATORIxDEMO("t@gN.J{Oe_"), dataFormatException);
        }
        inflater.end();
        switch (a2.getFormat()) {
            case 1: {
                int n6;
                int n7;
                int n8 = n7 = 0;
                while (n8 < n2) {
                    byte by = (byte)(arrby2[n7] & 0xF);
                    n6 = (byte)(arrby2[n7] & 0xF0);
                    arrby[n7 << 1] = (byte)((by << 4 | by) & 0xFF);
                    int n9 = (n7 << 1) + 1;
                    int n10 = n6;
                    arrby[n9] = (byte)(n10 | n10 >>> 4 & 0xF);
                    n8 = ++n7;
                }
                break;
            }
            case 2: {
                arrby = arrby2;
                break;
            }
            case 513: {
                int n6;
                int n7;
                int n11 = n7 = 0;
                while (n11 < n4) {
                    byte by = (byte)((arrby2[n7] & 0x1F) << 3);
                    n6 = (byte)((arrby2[n7 + 1] & 7) << 5 | (arrby2[n7] & 0xE0) >> 3);
                    byte by2 = (byte)(arrby2[n7 + 1] & 0xF8);
                    int n12 = n7;
                    byte by3 = by;
                    arrby[n7 << 1] = (byte)(by3 | by3 >> 5);
                    int n13 = n6;
                    arrby[(n12 << 1) + 1] = (byte)(n13 | n13 >> 6);
                    byte by4 = by2;
                    arrby[(n12 << 1) + 2] = (byte)(by4 | by4 >> 5);
                    int n14 = (n7 << 1) + 3;
                    arrby[n14] = -1;
                    n11 = n7 += 2;
                }
                break;
            }
            case 517: {
                int n6;
                int n7 = 0;
                int n15 = 0;
                int n16 = n6 = 0;
                while (n16 < n4) {
                    int n17;
                    int n18 = n17 = 0;
                    while (n18 < 8) {
                        int n19;
                        n7 = (byte)(((arrby2[n6] & 1 << 7 - n17) >> 7 - n17) * 255);
                        int n20 = n19 = 0;
                        while (n20 < 16) {
                            int n21 = n15 = (n6 << 9) + (n17 << 6) + n19 * 2;
                            arrby[n15] = n7;
                            arrby[n21 + 1] = n7;
                            arrby[n21 + 2] = n7;
                            arrby[n15 + 3] = -1;
                            n20 = ++n19;
                        }
                        n18 = ++n17;
                    }
                    n16 = ++n6;
                }
                break;
            }
        }
        DataBufferByte dataBufferByte = new DataBufferByte(arrby, n2);
        PixelInterleavedSampleModel pixelInterleavedSampleModel = new PixelInterleavedSampleModel(0, a2.getWidth(), a2.getHeight(), 4, a2.getWidth() * 4, B);
        WritableRaster writableRaster = Raster.createWritableRaster(pixelInterleavedSampleModel, dataBufferByte, new Point(0, 0));
        BufferedImage bufferedImage = new BufferedImage(a2.getWidth(), a2.getHeight(), 2);
        bufferedImage.setData(writableRaster);
        return bufferedImage;
    }

    public /* synthetic */ int getFormat() {
        PNGMapleCanvas a2;
        return a2.d;
    }

    @Override
    public /* synthetic */ int getWidth() {
        PNGMapleCanvas a2;
        return a2.K;
    }

    public /* synthetic */ PNGMapleCanvas(int a2, int a3, int a4, int a5, byte[] a6) {
        PNGMapleCanvas a7;
        PNGMapleCanvas pNGMapleCanvas = a7;
        PNGMapleCanvas pNGMapleCanvas2 = a7;
        a7.k = a3;
        pNGMapleCanvas2.K = a2;
        pNGMapleCanvas2.a = a4;
        pNGMapleCanvas.d = a5;
        pNGMapleCanvas.ALLATORIxDEMO = a6;
    }
}

