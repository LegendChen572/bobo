/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.MapleCharacter;
import client.anticheat.CheatingOffenseEntry;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import tools.Quadra;
import tools.StringUtil;

public class FileoutputUtil {
    public static final /* synthetic */ String \u8173\u672c\u932f\u8aa4 = "logs/Except/\u8173\u672c\u932f\u8aa4.txt";
    public static final /* synthetic */ String \u5c01\u5305\u9577\u5ea6\u7570\u5e38 = "logs/Except/\u5c01\u5305\u9577\u5ea6\u7570\u5e38.txt";
    private static final /* synthetic */ SimpleDateFormat B;
    public static final /* synthetic */ String Packet_Log = "logs/\u6578\u64da\u5305\u6536\u767c/Log.txt";
    private static final /* synthetic */ String d = "logs/";
    public static final /* synthetic */ String \u8173\u672c\u6f0f\u6d1e = "logs/Except/\u8173\u672c\u6f0f\u6d1e.txt";
    public static final /* synthetic */ String \u6953\u9bca\u6a94\u6848 = "logs/\u6953\u9bca\u6a94\u6848/";
    public static final /* synthetic */ String \u5305\u982d\u932f\u8aa4 = "logs/Except/\u5305\u982d\u932f\u8aa4.txt";
    public static final /* synthetic */ String Client_Error = "logs/ClientError/\u7528\u6236\u7aef_\u5831\u932f.txt";
    public static final /* synthetic */ String \u79fb\u52d5\u932f\u8aa4 = "logs/Except/\u79fb\u52d5\u932f\u8aa4.txt";
    public static final /* synthetic */ String Client_Error_2 = "logs/ClientError/\u7528\u6236\u7aef_\u5831\u932f_\u975e38.txt";
    private static final /* synthetic */ SimpleDateFormat a;
    public static final /* synthetic */ String \u6307\u4ee4\u4f8b\u5916 = "logs/Except/\u6307\u4ee4\u4f8b\u5916.txt";
    private static final /* synthetic */ SimpleDateFormat k;
    public static final /* synthetic */ String \u672a\u77e5\u6578\u64da\u5305 = "logs/Except/\u6578\u64da\u5305_\u672a\u77e5.txt";
    private static final /* synthetic */ SimpleDateFormat K;
    private static final /* synthetic */ String ALLATORIxDEMO = "error/";
    public static final /* synthetic */ String \u8907\u88fd\u6e05\u9664\u4f8b\u5916 = "logs/Except/\u552f\u4e00ID\u8907\u88fd\u6e05\u9664\u4f8b\u5916.txt";

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ String getString(Throwable a2) {
        String string = null;
        StringWriter stringWriter = null;
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            a2.printStackTrace(printWriter);
            string = stringWriter.toString();
        }
        finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (stringWriter != null) {
                    stringWriter.close();
                }
            }
            catch (IOException iOException) {}
        }
        return string;
    }

    public static /* synthetic */ String NowTime2() {
        Date date = new Date();
        return new SimpleDateFormat(Quadra.ALLATORIxDEMO("0O0Od{\u0004\u001b-Ri~\u0001\f$[sE:")).format(date);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getDayOfWeek() {
        int n2 = Calendar.getInstance().get(7) - 1;
        String string = String.valueOf(n2);
        switch (n2) {
            case 0: {
                return Quadra.ALLATORIxDEMO("\u65ac");
            }
            case 1: {
                return CheatingOffenseEntry.ALLATORIxDEMO("\u4e3d");
            }
            case 2: {
                return Quadra.ALLATORIxDEMO("\u4ec5");
            }
            case 3: {
                return CheatingOffenseEntry.ALLATORIxDEMO("\u4e34");
            }
            case 4: {
                return Quadra.ALLATORIxDEMO("\u5692");
            }
            case 5: {
                return CheatingOffenseEntry.ALLATORIxDEMO("\u4ea9");
            }
            case 6: {
                return Quadra.ALLATORIxDEMO("\u5124");
            }
        }
        return string;
    }

    public static /* synthetic */ void outputFileError(String a2, Throwable a3) {
        FileoutputUtil.logToFile(a2, "\r\n------------------------ " + FileoutputUtil.CurrentReadable_Time() + " ------------------------\r\n" + FileoutputUtil.getString(a3));
    }

    public static /* synthetic */ String NowDay() {
        Date date = new Date();
        return new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("EDED\u0013pq\u0012XY")).format(date);
    }

    public static /* synthetic */ {
        B = new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("EDED\u5e48pq\u6735XY\u65d9ut\u667fQP\u523aNO\u79ef"));
        k = new SimpleDateFormat(Quadra.ALLATORIxDEMO("0O0Od{\u0004\u001b-Ri~\u0001\f$[sE:"));
        K = new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("DEDE\u0010qp\u0011YX\u001dtu\u0006PQ\u0007ON"));
        a = new SimpleDateFormat(Quadra.ALLATORIxDEMO("O0O0\u001b\u0004{dR-"));
        K.setTimeZone(TimeZone.getTimeZone(CheatingOffenseEntry.ALLATORIxDEMO("zqi")));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void logToFile(String a2, String a32222222222, boolean a4, boolean a52222222222, boolean a62222222222) {
        block14: {
            Object object = a32222222222;
            if (!((String)object).contains(Quadra.ALLATORIxDEMO(";C"))) {
                object = "\r\n" + (String)a32222222222;
            }
            a32222222222 = null;
            File file = new File(a2);
            if (a62222222222 && file.exists() && file.isFile() && file.length() >= 1024000L && a52222222222) {
                String string = a2;
                String string2 = a2;
                String a62222222222 = string.substring(0, string.indexOf(47, a2.indexOf("/") + 1) + 1) + "old/" + string2.substring(string2.indexOf(47, string2.indexOf("/") + 1) + 1, a2.length() - 4);
                Object a52222222222 = B.format(Calendar.getInstance().getTime());
                String string3 = a2;
                String string4 = string3.substring(a2.length() - 4, string3.length());
                if (new File((String)(a52222222222 = a62222222222 + "_" + (String)a52222222222 + string4)).getParentFile() != null) {
                    new File((String)a52222222222).getParentFile().mkdirs();
                }
                file.renameTo(new File((String)a52222222222));
                file = new File(a2);
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            if ((a32222222222 = new FileOutputStream(a2, true)).toString().contains((CharSequence)object) && a4) break block14;
            OutputStreamWriter a62222222222 = new OutputStreamWriter((OutputStream)a32222222222, CheatingOffenseEntry.ALLATORIxDEMO("hh{\u0011\u0005"));
            a62222222222.write((String)object);
            a62222222222.flush();
        }
        try {
            if (a32222222222 == null) return;
            ((FileOutputStream)a32222222222).close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                if (a32222222222 == null) return;
                ((FileOutputStream)a32222222222).close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
            catch (Throwable throwable) {
                try {
                    if (a32222222222 == null) throw throwable;
                    ((FileOutputStream)a32222222222).close();
                    throw throwable;
                }
                catch (IOException a32222222222) {
                    // empty catch block
                }
                throw throwable;
            }
        }
    }

    public static /* synthetic */ String NowTime() {
        Date date = new Date();
        return new SimpleDateFormat(Quadra.ALLATORIxDEMO("0O0Of{\u0004\u0019-Ri~\u0001\f$[sE:")).format(date);
    }

    public static /* synthetic */ String DayNext(int a2) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, a2);
        return a.format(calendar.getTime());
    }

    public static /* synthetic */ boolean deleteFile(String a2) {
        boolean bl = false;
        File file = new File(a2);
        if (file.isFile() && file.exists()) {
            file.delete();
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ String getTime(long a2) {
        Date date = new Date();
        return new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("DEDE\u0012qp\u0013YX\u001dtu\u0006PQ\u0007ON")).format(a2);
    }

    public static /* synthetic */ int NowTimeNumber() {
        Date date = new Date();
        return Integer.parseInt(new SimpleDateFormat(Quadra.ALLATORIxDEMO("O0O0{\u0004R-")).format(date));
    }

    public static /* synthetic */ void print(String a2, String a3) {
        FileoutputUtil.logToFile(d + a2, a3 + (true ? Quadra.ALLATORIxDEMO("D<d\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd\u001bd;C") : null));
    }

    public /* synthetic */ FileoutputUtil() {
        FileoutputUtil a2;
    }

    public static /* synthetic */ String NowMonthD() {
        Date date = new Date();
        return new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("DEDE\u0010qp")).format(date);
    }

    public static /* synthetic */ String now(String a2) {
        Calendar calendar = Calendar.getInstance();
        return new SimpleDateFormat(a2).format(calendar.getTime());
    }

    public static /* synthetic */ String getChineseData() {
        return B.format(Calendar.getInstance().getTime());
    }

    public static /* synthetic */ void logToFile(String a2, String[] a3) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.length) {
            int n4 = n2;
            FileoutputUtil.logToFile(a2, a3[n4], false, true, true);
            if (n4 < a3.length - 1) {
                FileoutputUtil.logToFile(a2, CheatingOffenseEntry.ALLATORIxDEMO("17"), false, true, true);
            }
            n3 = ++n2;
        }
    }

    public static /* synthetic */ String YesturdayDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        return new SimpleDateFormat(Quadra.ALLATORIxDEMO("O0O0\u0019\u0004{fR-")).format(calendar.getTime());
    }

    public static /* synthetic */ void logToFile_chr(MapleCharacter a2, String a3, String a4) {
        FileoutputUtil.logToFile(a3, "\r\n" + FileoutputUtil.NowTime() + " \u5e33\u865f " + a2.getClient().getAccountName() + " \u540d\u7a31 " + a2.getName() + " (" + a2.getId() + ") \u7b49\u7d1a " + a2.getLevel() + " \u5730\u5716 " + a2.getMapId() + a4, false, true, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ boolean readtxt(String a2, String a32) {
        String string;
        Object object;
        block22: {
            object = new File(a2);
            if (!((File)object).exists()) {
                try {
                    ((File)object).createNewFile();
                    string = a2;
                    break block22;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            string = a2;
        }
        String string2 = string;
        object = null;
        try {
            object = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(string2), StringUtil.codeString(string2)));
            string2 = ((BufferedReader)object).readLine();
            if (string2 != null) {
                boolean a32 = string2.contains(a32);
                return a32;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        finally {
            try {
                if (object != null) {
                    ((BufferedReader)object).close();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        return false;
    }

    public static /* synthetic */ void logToFile_NpcScript_Bug(MapleCharacter a2, String a3) {
        FileoutputUtil.logToFile(\u8173\u672c\u6f0f\u6d1e, FileoutputUtil.k.format(Calendar.getInstance().getTime()) + " \u73a9\u5bb6[" + a2.getName() + "] NPC\u8173\u672c[" + a2.getNpcNow() + "]" + a3, false, true, false);
    }

    public static /* synthetic */ void printError(String a2, Throwable a3, String a4) {
        FileoutputUtil.logToFile("logs/error/" + FileoutputUtil.a.format(Calendar.getInstance().getTime()) + "/" + a2, a4 + "\r\n" + FileoutputUtil.getString(a3) + "\r\n---------------------------------\r\n", false, true);
    }

    public static /* synthetic */ String CurrentReadable_Date() {
        return a.format(Calendar.getInstance().getTime());
    }

    public static /* synthetic */ void logToFileIfNotExists(String a2, String a3) {
        FileoutputUtil.logToFile(a2, a3, true, true, true);
    }

    public static /* synthetic */ void outputFileError(String a2, Throwable a3, boolean a4) {
        FileoutputUtil.logToFile(a2, "\r\n------------------------ " + FileoutputUtil.k.format(Calendar.getInstance().getTime()) + " ------------------------\r\n" + FileoutputUtil.getString(a3), false, true, a4);
    }

    public static /* synthetic */ void logToFile_ReactorScript_Bug(MapleCharacter a2, String a3) {
        FileoutputUtil.logToFile(\u8173\u672c\u6f0f\u6d1e, FileoutputUtil.k.format(Calendar.getInstance().getTime()) + " \u73a9\u5bb6[" + a2.getName() + "] \u53cd\u61c9\u7269\u8173\u672c[" + a2.getReactorNow() + "]" + a3, false, true, false);
    }

    public static /* synthetic */ String CurrentReadable_TimeGMT() {
        return K.format(new Date());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void outError(String a2, Throwable a322222222) {
        System.out.println(FileoutputUtil.getString(a322222222));
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(a2, true);
            fileOutputStream.write(("\n------------------------ " + FileoutputUtil.k.format(Calendar.getInstance().getTime()) + " ------------------------\n").getBytes());
            fileOutputStream.write(FileoutputUtil.getString(a322222222).getBytes());
        }
        catch (IOException a322222222) {
            try {
                if (fileOutputStream == null) return;
                fileOutputStream.close();
                return;
            }
            catch (IOException a322222222) {
                return;
            }
        }
        catch (Throwable throwable) {
            try {
                if (fileOutputStream == null) throw throwable;
                fileOutputStream.close();
                throw throwable;
            }
            catch (IOException a322222222) {
                // empty catch block
            }
            throw throwable;
        }
        try {
            if (fileOutputStream == null) return;
            fileOutputStream.close();
            return;
        }
        catch (IOException a322222222) {
            return;
        }
    }

    public static /* synthetic */ String NowDay2() {
        Date date = new Date();
        return new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("EDED\u0011pq\u0010XY")).format(date);
    }

    public static /* synthetic */ String NowMonth() {
        Date date = new Date();
        return new SimpleDateFormat(Quadra.ALLATORIxDEMO("0O0Of{\u0004")).format(date);
    }

    public static /* synthetic */ String YesturdayReadable_Date() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        return a.format(calendar.getTime());
    }

    public static /* synthetic */ int YesturdayTimeNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        return Integer.parseInt(new SimpleDateFormat(CheatingOffenseEntry.ALLATORIxDEMO("EDEDqpXY")).format(calendar.getTime()));
    }

    public static /* synthetic */ String TheDayBeforeYesturdayReadable_Date() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -2);
        return a.format(calendar.getTime());
    }

    public static /* synthetic */ void logToFile_PortalScript_Bug(MapleCharacter a2, String a3) {
        FileoutputUtil.logToFile(\u8173\u672c\u6f0f\u6d1e, FileoutputUtil.k.format(Calendar.getInstance().getTime()) + " \u73a9\u5bb6[" + a2.getName() + "] \u50b3\u9001\u8173\u672c[" + a2.getPortalNow() + "]" + a3, false, true, false);
    }
}

