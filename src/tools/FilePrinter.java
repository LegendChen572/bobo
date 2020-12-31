/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import server.Extend.SpecialItemData;
import tools.FileoutputUtil;
import tools.packet.BeansPacket;

public class FilePrinter {
    public static final /* synthetic */ String NBPQLog = "NBPQLog.txt";
    public static final /* synthetic */ String EBPQLog = "EBPQLog.txt";
    public static final /* synthetic */ String ConsoleCommandProcessor = "ConsoleCommandProcessor.txt";
    private static final /* synthetic */ SimpleDateFormat K;
    public static final /* synthetic */ String PacketLogs = "PacketLogs.txt";
    public static final /* synthetic */ String MapleQuest = "MapleQuest.txt";
    public static final /* synthetic */ String CommandProccessor = "CommandProccessor.txt";
    public static final /* synthetic */ String TokyoLog = "TokyoLog.txt";
    public static final /* synthetic */ String AccountStuck = "AccountStuck.txt";
    private static final /* synthetic */ DateFormat ALLATORIxDEMO;
    public static final /* synthetic */ String HorntailLog = "HorntailLog.txt";
    public static final /* synthetic */ String StatesHandling = "StatesHandling.txt";
    public static final /* synthetic */ String Chinese_Lion = "Chinese_Lion.txt";
    private static final /* synthetic */ String d = "error/";
    public static final /* synthetic */ String HBPQLog = "HBPQLog.txt";
    public static final /* synthetic */ String HEPQLog = "HEPQLog.txt";
    public static final /* synthetic */ String ZakumLog = "ZakumLog.txt";
    public static final /* synthetic */ String JapanBOSSLog = "JapanBOSSLog.txt";
    public static final /* synthetic */ String PinkbeanLog = "PinkbeanLog.txt";
    public static final /* synthetic */ String MapleServerHandler = "MapleServerHandler.txt";
    private static final /* synthetic */ String a;
    public static final /* synthetic */ String LoginServer = "LoginServer.txt";
    public static final /* synthetic */ String ChaosHT = "ChaosHT.txt";
    public static final /* synthetic */ String PapLog = "PapLog.txt";
    public static final /* synthetic */ String Dojodare = "Dojodare.txt";
    public static final /* synthetic */ String PacketLogsExcpt = "PacketLogsExcpt.txt";
    public static final /* synthetic */ String LoginError = "LoginError.txt";
    public static final /* synthetic */ String MalaysiaBOSSLog = "MalaysiaBOSSLog.txt";

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void print(String a2, String a32222222222, boolean a4) {
        FileOutputStream fileOutputStream;
        block11: {
            fileOutputStream = null;
            String string = a + a2;
            File file = new File(string);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            fileOutputStream = new FileOutputStream(string, true);
            fileOutputStream.write((FileoutputUtil.NowTime() + " " + a32222222222).getBytes());
            fileOutputStream.write(SpecialItemData.ALLATORIxDEMO("%9").getBytes());
            if (!a4) break block11;
            fileOutputStream.write(BeansPacket.ALLATORIxDEMO("\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bO/").getBytes());
        }
        try {
            if (fileOutputStream == null) return;
            fileOutputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                if (fileOutputStream == null) return;
                fileOutputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
            catch (Throwable throwable) {
                try {
                    if (fileOutputStream == null) throw throwable;
                    fileOutputStream.close();
                    throw throwable;
                }
                catch (IOException a32222222222) {
                    // empty catch block
                }
                throw throwable;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void printError(String a2, Throwable a32222222222, String a4) {
        FileOutputStream fileOutputStream = null;
        String string = a + d + a2;
        File file = new File(string);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        fileOutputStream = new FileOutputStream(string, true);
        fileOutputStream.write((FileoutputUtil.NowTime() + " " + a4 + "\r\n").getBytes());
        FileOutputStream fileOutputStream2 = fileOutputStream;
        fileOutputStream2.write(FilePrinter.ALLATORIxDEMO(a32222222222).getBytes());
        fileOutputStream2.write(SpecialItemData.ALLATORIxDEMO("\"\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e\u0005\u001e%9").getBytes());
        try {
            if (fileOutputStream == null) return;
            fileOutputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                if (fileOutputStream == null) return;
                fileOutputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
            catch (Throwable throwable) {
                try {
                    if (fileOutputStream == null) throw throwable;
                    fileOutputStream.close();
                    throw throwable;
                }
                catch (IOException a32222222222) {
                    // empty catch block
                }
                throw throwable;
            }
        }
    }

    public static /* synthetic */ void print(String a2, String a3) {
        FilePrinter.print(a2, a3, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void printError(String a2, String a32222222222) {
        FileOutputStream fileOutputStream = null;
        String string = a + d + a2;
        File file = new File(string);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        fileOutputStream = new FileOutputStream(string, true);
        fileOutputStream.write((FileoutputUtil.NowTime() + " " + a32222222222).getBytes());
        fileOutputStream.write(BeansPacket.ALLATORIxDEMO("H\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bO/").getBytes());
        try {
            if (fileOutputStream == null) return;
            fileOutputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                if (fileOutputStream == null) return;
                fileOutputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
            catch (Throwable throwable) {
                try {
                    if (fileOutputStream == null) throw throwable;
                    fileOutputStream.close();
                    throw throwable;
                }
                catch (IOException a32222222222) {
                    // empty catch block
                }
                throw throwable;
            }
        }
    }

    public static /* synthetic */ String getLocalDateString() {
        Date date = new Date();
        return ALLATORIxDEMO.format(date);
    }

    public /* synthetic */ FilePrinter() {
        FilePrinter a2;
    }

    public static /* synthetic */ {
        K = new SimpleDateFormat(SpecialItemData.ALLATORIxDEMO("LW\u0005~e\u001eQJQJ"));
        a = "logs/DailyError/" + K.format(Calendar.getInstance().getTime()) + "/";
        ALLATORIxDEMO = new SimpleDateFormat(BeansPacket.ALLATORIxDEMO("\\;\\;\n\u000fhmA&\u0005\nmxH/\u001f1V"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static /* synthetic */ String ALLATORIxDEMO(Throwable a2) {
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void printError(String a2, Throwable a32222222222) {
        FileOutputStream fileOutputStream = null;
        String string = a + d + a2;
        File file = new File(string);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream2 = fileOutputStream = new FileOutputStream(string, true);
        fileOutputStream2.write(FilePrinter.ALLATORIxDEMO(a32222222222).getBytes());
        fileOutputStream2.write(BeansPacket.ALLATORIxDEMO("H\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bo\bO/").getBytes());
        try {
            if (fileOutputStream == null) return;
            fileOutputStream.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (IOException iOException) {
            try {
                if (fileOutputStream == null) return;
                fileOutputStream.close();
                return;
            }
            catch (IOException iOException2) {
                return;
            }
            catch (Throwable throwable) {
                try {
                    if (fileOutputStream == null) throw throwable;
                    fileOutputStream.close();
                    throw throwable;
                }
                catch (IOException a32222222222) {
                    // empty catch block
                }
                throw throwable;
            }
        }
    }
}

