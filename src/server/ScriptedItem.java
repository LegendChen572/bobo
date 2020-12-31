/*
 * Decompiled with CFR 0.150.
 */
package server;

public class ScriptedItem {
    private final /* synthetic */ String ALLATORIxDEMO;
    private final /* synthetic */ int d;
    private final /* synthetic */ boolean a;

    public /* synthetic */ String getScript() {
        ScriptedItem a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ boolean runOnPickup() {
        ScriptedItem a2;
        return a2.a;
    }

    public /* synthetic */ ScriptedItem(int a2, String a3, boolean a4) {
        ScriptedItem a5;
        ScriptedItem scriptedItem = a5;
        a5.d = a2;
        scriptedItem.ALLATORIxDEMO = a3;
        scriptedItem.a = a4;
    }

    public /* synthetic */ int getNpc() {
        ScriptedItem a2;
        return a2.d;
    }
}

