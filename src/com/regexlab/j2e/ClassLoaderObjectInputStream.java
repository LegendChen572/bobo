/*
 * Decompiled with CFR 0.150.
 */
package com.regexlab.j2e;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class ClassLoaderObjectInputStream
extends ObjectInputStream {
    private ClassLoader classLoader;

    public ClassLoaderObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
        super(inputStream);
        this.classLoader = classLoader;
    }

    protected Class resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            String string = objectStreamClass.getName();
            return Class.forName(string, false, this.classLoader);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return super.resolveClass(objectStreamClass);
        }
    }
}

