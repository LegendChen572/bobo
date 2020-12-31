/*
 * Decompiled with CFR 0.150.
 */
package tools.use;

import client.LoginCrypto;
import client.anticheat.CheatingOffenseEntry;
import constants.GameSetConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Calendar;
import java.util.Date;
import server.gashapon.GashaponRewardSpecial;
import server.swing.autoupdate.GetFileMD5;

/*
 * Exception performing whole class analysis ignored.
 */
public class GetMACAddress {
    public static /* synthetic */ String getStartServerKey(int a2) {
        return LoginCrypto.hexSha1(GetMACAddress.getDecodeIPAddress() + "-" + GetMACAddress.getOSName() + "-" + GetMACAddress.getCPUSerial() + "-" + GetMACAddress.getMACAddress() + "-" + GetMACAddress.getMotherboardSN() + "-" + GetMACAddress.getUserName() + "-" + GetMACAddress.getYear() + "-" + GetMACAddress.getMonth() + "-" + a2);
    }

    public static /* synthetic */ String getDecodeIPAddress() {
        return LoginCrypto.hexSha1(GameSetConstants.IP);
    }

    public static /* synthetic */ int getYear() {
        Calendar calendar;
        Calendar calendar2 = calendar = Calendar.getInstance();
        Calendar calendar3 = calendar;
        calendar2.setTime(new Date());
        return calendar2.get(1);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 << 3 ^ 1;
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 3;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ 3;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public static /* synthetic */ String getCPUSerial() {
        if (GetMACAddress.getOSName().startsWith(GashaponRewardSpecial.ALLATORIxDEMO("PmI`HsT"))) {
            return GetMACAddress.ALLATORIxDEMO();
        }
        return CheatingOffenseEntry.ALLATORIxDEMO("QUSIE");
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ String getMotherboardSN() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(GashaponRewardSpecial.ALLATORIxDEMO("-'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0004'\u0007'\u0007$\u0007'\u0007$\u0007$\u0004'\u0007'\u0004'\u0007'\u0004'\u0007'\u0004$\u0007'\u0004'\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0004$\u0004$\u0004$\u0007$\u0004$\u0007$\u0004$\u0004$\u0007'\u0007$\u0004$\u0004$\u0004$\u0004$\u0007'\u0007$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007'\u0004'\u0007'\u0007$\u0007'\u0007$\u0007'\u0004'\u0007$\u0004$\u0007'\u0007'\u0007'\u0004$\u0007$\u0004$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0004$\u0004$\u0004'\u0004$\u0004'\u0004$\u0004$\u0004$\u0007'\u0007$\u0004'\u0004$\u0004$\u0004$\u0004'\u0004$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$hfAqTgFpNkI$E}\u0007EKhFpHvN$hfAqTgFpHv\u0007r\u0010*\u0014$cAjK\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004$\u0007$\u0007$\u0007$\u0007$\u0007$OpSt\u001d+\bsPs\teKhFpHvN*DkJ$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007'-'\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0007$\u0004\u000e\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'\u0004'-"));
        System.out.println("OS: " + GetMACAddress.getOSName());
        System.out.println("\u4e3b\u6a5f\u677fSN: " + GetMACAddress.getMotherboardSN());
        System.out.println("CPU_SN: " + GetMACAddress.getCPUSerial());
        System.out.println("MAC: " + GetMACAddress.getMACAddress());
        System.out.println("IP: " + GetMACAddress.getDecodeIPAddress());
        System.out.println("\u5e74: " + GetMACAddress.getYear());
        System.out.println("\u6708: " + GetMACAddress.getMonth());
        System.out.println("\u4f7f\u7528\u8005: " + GetMACAddress.getUserName());
        System.out.println("\u7248\u672c: " + GameSetConstants.MAPLE_VERSION);
        System.out.println("113KEY: " + GetMACAddress.getStartServerKey(113));
        System.out.println("118KEY: " + GetMACAddress.getStartServerKey(118));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ String getUnixMACAddress() {
        String string = null;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(GashaponRewardSpecial.ALLATORIxDEMO("NbDkIbNc\u0007aSl\u0017"));
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String string2 = null;
            int n2 = -1;
            while ((string2 = bufferedReader.readLine()) != null) {
                n2 = string2.toLowerCase().indexOf(CheatingOffenseEntry.ALLATORIxDEMO("TJ]YXO"));
                if (n2 == -1) continue;
                string = string2.substring(n2 + GashaponRewardSpecial.ALLATORIxDEMO("lPeC`U").length() + 1).trim();
            }
            return string;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return string;
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            bufferedReader = null;
            process = null;
        }
    }

    public static /* synthetic */ String getCryptData() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = stringBuilder.append(GetMACAddress.getOSName()).append(GashaponRewardSpecial.ALLATORIxDEMO("\t-"));
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder.append(GetMACAddress.getMotherboardSN()).append(CheatingOffenseEntry.ALLATORIxDEMO("17"));
        stringBuilder3.append(GetMACAddress.getCPUSerial()).append(GashaponRewardSpecial.ALLATORIxDEMO("\t-"));
        stringBuilder.append(GetMACAddress.getOSName()).append(CheatingOffenseEntry.ALLATORIxDEMO("17"));
        stringBuilder.append(GameSetConstants.MAPLE_VERSION).append(GashaponRewardSpecial.ALLATORIxDEMO("\t-"));
        return stringBuilder3.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ String getMACAddress() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] arrby = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
            for (int i2 = 0; i2 < arrby.length; ++i2) {
                Object[] arrobject = new Object[2];
                arrobject[0] = arrby[i2];
                arrobject[1] = i2 < arrby.length - 1 ? GashaponRewardSpecial.ALLATORIxDEMO("\n") : "";
                stringBuilder.append(String.format(CheatingOffenseEntry.ALLATORIxDEMO("\u0019\r\u000ee\u0019N"), arrobject));
            }
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            stringBuilder.append(CheatingOffenseEntry.ALLATORIxDEMO("_\\RInX]Y"));
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ int getMonth() {
        Calendar calendar;
        Calendar calendar2 = calendar = Calendar.getInstance();
        Calendar calendar3 = calendar;
        calendar2.setTime(new Date());
        return calendar2.get(2) + 1;
    }

    public static /* synthetic */ String getMD5Key() {
        return GetFileMD5.getMD5String(GetMACAddress.getCryptData());
    }

    public static /* synthetic */ String getOSName() {
        return System.getProperty(CheatingOffenseEntry.ALLATORIxDEMO("RO\u0013R\\QX")).toLowerCase();
    }

    private static /* synthetic */ String ALLATORIxDEMO() {
        Object object;
        Object object2 = "";
        File file = File.createTempFile(GashaponRewardSpecial.ALLATORIxDEMO("UaFhOkPpH"), CheatingOffenseEntry.ALLATORIxDEMO("\u0012K^N"));
        file.deleteOnExit();
        Object object3 = new FileWriter(file);
        String string = GashaponRewardSpecial.ALLATORIxDEMO("taS$HfMSjMtaUrNgB$\u001a$`aSKEnBgS,\u0005sNjJcJpT>{X\tXUkHp{gNiQ6\u0005--WBp\u0007gHhnpBiT$\u001a$HfMSjMtaUrNgB*b|BgvqBv^$x$-$\u0007$\u000f&taKaDp\u0007.\u0007bUkJ$pmI7\u0015[wvHgBwTkU&\u000e$-BHv\u0007AFgO$HfMMSaJ$Nj\u0007gHhnpBiT$-$\u0007$\u0007STgUmWp\tADlH$HfMMSaJ*wvHgBwTkUMC$-$\u0007$\u0007a_mS$AkU$\u0007#\u0007`H$SlB$AmUwS$DtR$HjK}\u0006$-JB|S$-");
        FileWriter fileWriter = object3;
        fileWriter.write(CheatingOffenseEntry.ALLATORIxDEMO("nYI\u001cR^WkpunYOJT_X\u001c\u0000\u001czYIs_VX_I\u0014\u001fKTRP[PHN\u0006a`\u0013`OSRHa_TQK\u000e\u001f\u00157oXH\u001d_RPtHXQN\u001c\u0000\u001cR^WkpunYOJT_X\u0012xDX_lIXND\u001cb\u001c7\u001c\u001d\u001c\u0015\u001enYQY^H\u001d\u0016\u001dZOSP\u001cjUS\u000f\u000fcmNR_XONSO\u001e\u0014\u001c7zRN\u001dy\\_U\u001cR^WuIYP\u001cTR\u001d_RPtHXQN\u001c7\u001c\u001d\u001c\u001dkN_OUMH\u0013y^TR\u001cR^WuIYP\u0012mNR_XONSOuY\u001c7\u001c\u001d\u001c\u001dYEUI\u001c[SO\u001c\u001d\u001b\u001dXR\u001cITX\u001c[UOOI\u001c^LH\u001cRRQE\u001c\u001c7rXDI\u001c7"));
        fileWriter.close();
        object3 = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
        Object object4 = object3 = new BufferedReader(new InputStreamReader(((Process)object3).getInputStream()));
        while ((string = ((BufferedReader)object4).readLine()) != null) {
            object2 = (String)object2 + string;
            object4 = object3;
        }
        try {
            ((BufferedReader)object3).close();
            object = object2;
        }
        catch (Exception exception) {
            object = object2 = GashaponRewardSpecial.ALLATORIxDEMO("gFjSvBeC");
        }
        return ((String)object).trim();
    }

    public /* synthetic */ GetMACAddress() {
        GetMACAddress a2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static /* synthetic */ String getLinuxMACAddress() {
        String string = null;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(CheatingOffenseEntry.ALLATORIxDEMO("TZ^SSZT[\u001dYIT\r"));
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String string2 = null;
            int n2 = -1;
            while ((string2 = bufferedReader.readLine()) != null) {
                n2 = string2.toLowerCase().indexOf(GashaponRewardSpecial.ALLATORIxDEMO("LpeC`U"));
                if (n2 == -1) continue;
                string = string2.substring(n2 + 4).trim();
            }
            return string;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return string;
        }
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            bufferedReader = null;
            process = null;
        }
    }

    public static /* synthetic */ String getUserName() {
        return System.getProperty(CheatingOffenseEntry.ALLATORIxDEMO("HOXN\u0013R\\QX")).toLowerCase();
    }

    public static /* synthetic */ String getStartServerKey() {
        return LoginCrypto.hexSha1(GetMACAddress.getDecodeIPAddress() + "-" + GetMACAddress.getOSName() + "-" + GetMACAddress.getCPUSerial() + "-" + GetMACAddress.getMACAddress() + "-" + GetMACAddress.getMotherboardSN() + "-" + GetMACAddress.getUserName() + "-" + GetMACAddress.getYear() + "-" + GetMACAddress.getMonth());
    }
}

