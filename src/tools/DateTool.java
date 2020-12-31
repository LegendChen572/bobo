/*
 * Decompiled with CFR 0.150.
 */
package tools;

import database.DatabaseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateTool {
    public /* synthetic */ DateTool() {
        DateTool a2;
    }

    public static /* synthetic */ boolean CheckDate(String a2) {
        Calendar calendar;
        Calendar calendar2 = Calendar.getInstance();
        try {
            calendar2.setTime(new SimpleDateFormat(DatabaseException.ALLATORIxDEMO("%S%Sqg\u0011\u00078N")).parse(a2));
            calendar = calendar2;
        }
        catch (ParseException parseException) {
            Logger.getLogger(DateTool.class.getName()).log(Level.SEVERE, null, parseException);
            calendar = calendar2;
        }
        return calendar.getTimeInMillis() >= System.currentTimeMillis();
    }
}

