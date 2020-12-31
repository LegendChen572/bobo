/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import java.io.File;
import server.swing.tools.BytesEncodingDetect;

public class EncodingDetect {
    public /* synthetic */ EncodingDetect() {
        EncodingDetect a2;
    }

    public static /* synthetic */ String getJavaEncode(String a2) {
        return EncodingDetect.getJavaEncode(new File(a2));
    }

    public static /* synthetic */ String getJavaEncode(File a2) {
        BytesEncodingDetect bytesEncodingDetect = new BytesEncodingDetect();
        return BytesEncodingDetect.javaname[bytesEncodingDetect.detectEncoding(a2)];
    }
}

