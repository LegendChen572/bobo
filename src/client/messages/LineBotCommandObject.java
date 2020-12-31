/*
 * Decompiled with CFR 0.150.
 */
package client.messages;

import client.messages.LineBotCommandExecute;

public class LineBotCommandObject {
    private /* synthetic */ LineBotCommandExecute ALLATORIxDEMO;
    private /* synthetic */ String d;

    public /* synthetic */ LineBotCommandObject(String a2, LineBotCommandExecute a3) {
        LineBotCommandObject a4;
        LineBotCommandObject lineBotCommandObject = a4;
        lineBotCommandObject.d = a2;
        lineBotCommandObject.ALLATORIxDEMO = a3;
    }

    public /* synthetic */ String getMessage() {
        LineBotCommandObject a2;
        if (a2.d != null) {
            return a2.ALLATORIxDEMO.getMessage();
        }
        return "";
    }

    public /* synthetic */ String execute(String[] a2, String a3) {
        LineBotCommandObject a4;
        return a4.ALLATORIxDEMO.execute(a2, a3);
    }
}

