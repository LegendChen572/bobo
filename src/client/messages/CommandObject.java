/*
 * Decompiled with CFR 0.150.
 */
package client.messages;

import client.MapleClient;
import client.messages.CommandExecute;
import constants.ServerConstants;

public class CommandObject {
    private final /* synthetic */ int d;
    private final /* synthetic */ String a;
    private final /* synthetic */ CommandExecute ALLATORIxDEMO;

    public /* synthetic */ boolean execute(MapleClient a2, String[] a3) {
        CommandObject a4;
        return a4.ALLATORIxDEMO.execute(a2, a3);
    }

    public /* synthetic */ CommandObject(String a2, CommandExecute a3, int a4) {
        CommandObject a5;
        CommandObject commandObject = a5;
        a5.a = a2;
        commandObject.ALLATORIxDEMO = a3;
        commandObject.d = a4;
    }

    public /* synthetic */ String getMessage() {
        CommandObject a2;
        if (a2.a != null) {
            return a2.ALLATORIxDEMO.getMessage();
        }
        return "";
    }

    public /* synthetic */ ServerConstants.CommandType getType() {
        CommandObject a2;
        return a2.ALLATORIxDEMO.getType();
    }

    public /* synthetic */ int getReqGMLevel() {
        CommandObject a2;
        return a2.d;
    }
}

