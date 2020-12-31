/*
 * Decompiled with CFR 0.150.
 */
package com.regexlab.j2e;

import java.io.Serializable;

public class Instances {
    static {
        String string = System.getProperty("j2e.app.path");
        if (string != null) {
            System.load(string);
        }
    }

    public static native int getFirstInstance();

    public static native int getCurrentInstance();

    public static native int[] getInstances();

    public static void sendObject(Serializable serializable) {
        Instances.sendObject(Instances.getFirstInstance(), serializable);
    }

    public static native void sendObject(int var0, Serializable var1);

    public static native void flush();

    public static native void setReceiver(ReceiverInterface var0);

    public static interface ReceiverInterface {
        public void onReceive(int var1, Serializable var2);
    }
}

