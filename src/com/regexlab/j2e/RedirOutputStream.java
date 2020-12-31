/*
 * Decompiled with CFR 0.150.
 */
package com.regexlab.j2e;

import java.io.IOException;
import java.io.OutputStream;

public class RedirOutputStream
extends OutputStream {
    protected long h = 0L;

    static {
        String string = System.getProperty("j2e.app.path");
        if (string != null) {
            System.load(string);
        }
    }

    public native void write(int var1) throws IOException;
}

