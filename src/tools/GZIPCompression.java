/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  io.netty.util.CharsetUtil
 *  org.apache.commons.io.IOUtils
 */
package tools;

import constants.GameSetConstants;
import constants.MobConstants;
import io.netty.util.CharsetUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.io.IOUtils;
import tools.npcgenerator.Instruction;

public class GZIPCompression {
    public static /* synthetic */ String ByteToString(byte[] a2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        byte[] arrby = a2;
        int n3 = a2.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            stringBuilder.append(arrby[n2]);
            stringBuilder.append(Instruction.ALLATORIxDEMO("M"));
            n4 = ++n2;
        }
        if (a2.length >= 1) {
            StringBuilder stringBuilder2 = stringBuilder;
            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
        }
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ String compressA(String a2) {
        if (!GameSetConstants.COMPRESS_ITEM) {
            return a2;
        }
        if (a2 == null) return a2;
        if (a2.length() == 0) {
            return a2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(a2.getBytes());
        if (gZIPOutputStream == null) return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        try {
            gZIPOutputStream.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
        catch (IOException iOException) {
            try {
                iOException.printStackTrace();
                if (gZIPOutputStream == null) return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            }
            catch (Throwable throwable) {
                Throwable throwable2;
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (IOException iOException2) {
                        iOException2.printStackTrace();
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
            try {
                gZIPOutputStream.close();
                return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            }
            catch (IOException iOException3) {
                iOException3.printStackTrace();
                return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
            }
        }
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(Instruction.ALLATORIxDEMO("k9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B\u0010B:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A9k9A:A:A:A:B9A9A:A9A:A:B9A9B9A9B9A9B:A9B9A:A:A:A:B\u0010B:A:A:A:B:B:B:A:B:A:B:B:A9A:B:B:B:B:A9A:A:A:A:A9k9A:A:A:A9B9A9A:A9A:A9B9A:B:A9A9A9B:A:B:A:A:A:A:B\u0010B:A:A:A:B:B:B9B:B9B:B:B:A9A:B9B:B:B:B9B:A:A:A:A9k9A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:B\u0010B:.x\u0007o\u0012y\u0000n\bu\u000f:\u0003cA[\rv\u0000n\u000eh\b:.x\u0007o\u0012y\u0000n\u000ehAlV4R:%_,UA9k9A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:B\u0010B:A:A:A:A:A:\tn\u0015j[5Nm\u0016mO{\rv\u0000n\u000eh\b4\u0002u\f:A:A:A:A:A:A9k9A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:A:B\u0010B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9B9k"));
        String string = GZIPCompression.compress(MobConstants.ALLATORIxDEMO("\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d\u5e7b\u5e4d"));
        System.out.println(string);
        string = GZIPCompression.decompress(string);
        System.out.println(string);
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ String compress(String a2) {
        if (Objects.isNull(a2) || a2.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream;
        gZIPOutputStream2.write(a2.getBytes(CharsetUtil.UTF_8));
        gZIPOutputStream2.finish();
        String string = GZIPCompression.ByteToString(byteArrayOutputStream.toByteArray());
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return string;
        {
            catch (Throwable throwable) {
                try {
                    try {
                        Throwable throwable2;
                        try {
                            gZIPOutputStream.close();
                            throwable2 = throwable;
                        }
                        catch (Throwable throwable3) {
                            Throwable throwable4 = throwable;
                            throwable2 = throwable4;
                            throwable4.addSuppressed(throwable3);
                        }
                        throw throwable2;
                    }
                    catch (Throwable throwable5) {
                        Throwable throwable6;
                        try {
                            byteArrayOutputStream.close();
                            throwable6 = throwable5;
                        }
                        catch (Throwable throwable7) {
                            Throwable throwable8 = throwable5;
                            throwable6 = throwable8;
                            throwable8.addSuppressed(throwable7);
                        }
                        throw throwable6;
                    }
                }
                catch (IOException iOException) {
                    throw new UncheckedIOException(Instruction.ALLATORIxDEMO("_\u0013h\u000ehAm\ts\r\u007fAy\u000ew\u0011h\u0004i\u0012s\u000et@"), iOException);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ String uncompressA(String a) {
        block31: {
            block27: {
                block26: {
                    if (a == null) {
                        return null;
                    }
                    if (a.contains(Instruction.ALLATORIxDEMO("8P8["))) {
                        return a;
                    }
                    var1_1 = new ByteArrayOutputStream();
                    var2_2 = null;
                    var3_3 = null;
                    var4_4 = null;
                    var5_8 = null;
                    var6_9 = Base64.getMimeDecoder();
                    var4_4 = var6_9.decode(a);
                    var2_2 = new ByteArrayInputStream(var4_4);
                    var3_3 = new GZIPInputStream(var2_2);
                    var4_4 = new byte[1024];
                    var7_17 = -1;
                    v0 = var3_3;
                    while ((var7_17 = v0.read(var4_4)) != -1) {
                        v0 = var3_3;
                        var1_1.write(var4_4, 0, var7_17);
                    }
                    var5_8 = var1_1.toString();
                    if (var3_3 == null) break block26;
                    try {
                        var3_3.close();
                        v1 = var2_2;
                        break block27;
                    }
                    catch (IOException var6_10) {
                        // empty catch block
                    }
                }
                v1 = var2_2;
            }
            if (v1 == null) break block31;
            try {
                var2_2.close();
                v2 = var1_1;
                ** GOTO lbl45
            }
            catch (IOException var6_11) {
                // empty catch block
            }
        }
        try {
            v2 = var1_1;
lbl45:
            // 2 sources

            v2.close();
            return var5_8;
        }
        catch (IOException var6_12) {
            return var5_8;
        }
        catch (IOException var6_13) {
            block33: {
                block29: {
                    block28: {
                        try {
                            var6_13.printStackTrace();
                            if (var3_3 == null) break block28;
                        }
                        catch (Throwable var8_18) {
                            block32: {
                                block30: {
                                    if (var3_3 != null) {
                                        try {
                                            var3_3.close();
                                            v3 = var2_2;
                                            break block30;
                                        }
                                        catch (IOException var4_5) {
                                            // empty catch block
                                        }
                                    }
                                    v3 = var2_2;
                                }
                                if (v3 == null) break block32;
                                try {
                                    var2_2.close();
                                    v4 = var1_1;
                                    ** GOTO lbl73
                                }
                                catch (IOException var4_6) {
                                    // empty catch block
                                }
                            }
                            try {
                                v4 = var1_1;
lbl73:
                                // 2 sources

                                v4.close();
                                v5 = var8_18;
                                throw v5;
                            }
                            catch (IOException var4_7) {
                                v5 = var8_18;
                            }
                            throw v5;
                        }
                        try {
                            var3_3.close();
                            v6 = var2_2;
                            break block29;
                        }
                        catch (IOException var6_14) {
                            // empty catch block
                        }
                    }
                    v6 = var2_2;
                }
                if (v6 == null) break block33;
                try {
                    var2_2.close();
                    v7 = var1_1;
                    ** GOTO lbl98
                }
                catch (IOException var6_15) {
                    // empty catch block
                }
            }
            try {
                v7 = var1_1;
lbl98:
                // 2 sources

                v7.close();
                return var5_8;
            }
            catch (IOException var6_16) {
                return var5_8;
            }
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ String decompress(String a2) {
        Object object = GZIPCompression.StringToBytes(a2);
        if (Objects.isNull(object) || ((byte[])object).length == 0) {
            return null;
        }
        object = new GZIPInputStream(new ByteArrayInputStream((byte[])object));
        StringWriter stringWriter = new StringWriter();
        IOUtils.copy((InputStream)object, (Writer)stringWriter, (Charset)CharsetUtil.UTF_8);
        String string = stringWriter.toString();
        stringWriter.close();
        object.close();
        return string;
        {
            catch (Throwable throwable) {
                try {
                    try {
                        Throwable throwable2;
                        try {
                            stringWriter.close();
                            throwable2 = throwable;
                        }
                        catch (Throwable throwable3) {
                            Throwable throwable4 = throwable;
                            throwable2 = throwable4;
                            throwable4.addSuppressed(throwable3);
                        }
                        throw throwable2;
                    }
                    catch (Throwable throwable5) {
                        Throwable throwable6;
                        try {
                            object.close();
                            throwable6 = throwable5;
                        }
                        catch (Throwable throwable7) {
                            Throwable throwable8 = throwable5;
                            throwable6 = throwable8;
                            throwable8.addSuppressed(throwable7);
                        }
                        throw throwable6;
                    }
                }
                catch (IOException iOException) {
                    throw new UncheckedIOException(MobConstants.ALLATORIxDEMO("GFp[p\u0014u\\kXg\u0014fQa[oDpQqGk[l\u0015"), iOException);
                }
            }
        }
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 3 ^ 2;
        int cfr_ignored_0 = 3 << 3 ^ 3;
        int n5 = n3;
        int n6 = 1 << 3 ^ 4;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ GZIPCompression() {
        GZIPCompression a2;
    }

    public static /* synthetic */ byte[] StringToBytes(String a2) {
        int n2;
        String[] arrstring = a2.split(MobConstants.ALLATORIxDEMO("\u0018"));
        byte[] arrby = new byte[arrstring.length];
        int n3 = n2 = 0;
        while (n3 < arrstring.length) {
            int n4 = n2++;
            arrby[n4] = Byte.parseByte(arrstring[n4]);
            n3 = n2;
        }
        return arrby;
    }
}

