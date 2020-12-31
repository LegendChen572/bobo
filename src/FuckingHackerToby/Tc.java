/*
 * Decompiled with CFR 0.150.
 */
package FuckingHackerToby;

import FuckingHackerToby.k;
import FuckingHackerToby.ka;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public final class Tc
extends ka<k> {
    private /* synthetic */ SourceDataLine a;
    private /* synthetic */ byte[] k;
    private /* synthetic */ AudioFormat K;
    private /* synthetic */ float ALLATORIxDEMO;
    private /* synthetic */ boolean d;

    public static /* synthetic */ Tc ALLATORIxDEMO(byte[] a2) {
        return new Tc(a2, null);
    }

    public synchronized /* synthetic */ void ALLATORIxDEMO() {
        Tc a2;
        if (a2.a == null || !a2.d) {
            return;
        }
        Tc tc = a2;
        tc.d = false;
        tc.a.stop();
        tc.a.flush();
        tc.a.close();
        a2.a = null;
    }

    private /* synthetic */ Tc(byte[] a2, AudioFormat a3) {
        Tc a4;
        Tc tc = a4;
        tc.k = a2;
        tc.K = a3;
    }

    public static /* synthetic */ Tc H(String a2) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(Tc.class.getClassLoader().getResourceAsStream(a2));
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
            Object object = audioInputStream.getFormat();
            int n2 = audioInputStream.available();
            byte[] arrby = new byte[n2];
            audioInputStream.read(arrby, 0, n2);
            object = new Tc(arrby, (AudioFormat)object);
            return object;
        }
        catch (IOException | UnsupportedAudioFileException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public /* synthetic */ void H(float a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ void ALLATORIxDEMO(float a2) {
        Tc a3;
        a3.K = a2 = new AudioFormat(a3.K.getEncoding(), a2, a3.K.getSampleSizeInBits(), a3.K.getChannels(), a3.K.getFrameSize(), a3.K.getFrameRate(), a3.K.isBigEndian(), a3.K.properties());
    }

    public static /* synthetic */ Tc ALLATORIxDEMO(File a2) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(a2);
            int n2 = audioInputStream.available();
            byte[] arrby = new byte[n2];
            AudioFormat audioFormat = audioInputStream.getFormat();
            audioInputStream.read(arrby, 0, n2);
            Tc tc = new Tc(arrby, audioFormat);
            return tc;
        }
        catch (IOException | UnsupportedAudioFileException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private /* synthetic */ void D() {
        FloatControl floatControl;
        Tc a2;
        block3: {
            try {
                Tc tc = a2;
                tc.d = true;
                tc.a = AudioSystem.getSourceDataLine(tc.K);
                if (tc.a != null) break block3;
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return;
            }
        }
        Tc tc = a2;
        tc.a.open();
        FloatControl floatControl2 = floatControl = (FloatControl)tc.a.getControl(FloatControl.Type.MASTER_GAIN);
        float f2 = floatControl2.getMinimum();
        float f3 = floatControl2.getMaximum();
        floatControl2.setValue(Math.max(f2, Math.min(f3, a2.ALLATORIxDEMO)));
        a2.a.start();
        a2.a.write(a2.k, 0, a2.k.length);
        a2.a.drain();
    }

    public synchronized /* synthetic */ void H() {
        Tc a2;
        a2.H(1);
    }

    public static /* synthetic */ Tc ALLATORIxDEMO(String a2) {
        return Tc.ALLATORIxDEMO(new File(a2));
    }

    @Override
    public synchronized /* synthetic */ void H(int a22) {
        Tc a3;
        Runnable a22 = () -> {
            Tc tc;
            Tc a4;
            block2: {
                int n2;
                int n3 = n2 = 0;
                while (n3 < a22) {
                    Tc tc2 = a4;
                    tc2.D();
                    if (!tc2.d) {
                        tc = a4;
                        break block2;
                    }
                    Tc tc3 = a4;
                    tc3.ALLATORIxDEMO(a2 -> {
                        Tc a3;
                        a2.H(a3);
                    });
                    n3 = ++n2;
                }
                tc = a4;
            }
            tc.ALLATORIxDEMO(a2 -> {
                Tc a3;
                a2.ALLATORIxDEMO(a3);
            });
        };
        Thread thread = new Thread(a22);
        thread.setDaemon(true);
        thread.start();
    }

    public /* synthetic */ float ALLATORIxDEMO() {
        Tc a2;
        return a2.K.getSampleRate();
    }

    public /* synthetic */ float H() {
        Tc a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ boolean ALLATORIxDEMO() {
        Tc a2;
        return a2.d;
    }
}

