/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.messages.commands.PlayerCommand;
import java.text.SimpleDateFormat;
import java.util.Date;
import tools.FileOperation;

public class DataConvertTool {
    public static /* synthetic */ String StampToDate(long a2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PlayerCommand.ALLATORIxDEMO("w\u001dw\u001d#)CIj\u0000.,F^c\t4\u0017}"));
        return simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(a2))));
    }

    public static /* synthetic */ String StampToDate2(long a2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FileOperation.ALLATORIxDEMO("tutu-\u5e78-A@,\u6705,ih-\u65e9-DE,\u65fb,`a-\u520a-\u007f~,\u79df"));
        return simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(a2))));
    }

    public /* synthetic */ DataConvertTool() {
        DataConvertTool a2;
    }
}

