/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u61a8\u61a8\u8c37
 *  org.apache.commons.codec.binary.Base32
 */
package tools.otp;

import client.messages.commands.player.\u61a8\u61a8\u8c37;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base32;
import server.MTSCart;
import tools.otp.TimeBasedOneTimePasswordGenerator;

public class GoogleAuthenticator {
    /*
     * Exception decompiling
     */
    public static /* synthetic */ String createOTPKey(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public static /* synthetic */ String createGoogleAuthQRCodeData(String a2, String a32, String a4) {
        String string = \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"\u0006=\u0019(\u001c=\u0001sFf\u001d&\u001d9Fl\u001av\u001a,\n;\f=Tl\u001ao\u0000:\u001a<\f;Tl\u001a");
        try {
            Object[] arrobject = new Object[3];
            arrobject[0] = URLEncoder.encode(a4 + ":" + a32, MTSCart.ALLATORIxDEMO("\u0006\u0015\u0015lk")).replace(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"B"), MTSCart.ALLATORIxDEMO("vsc"));
            arrobject[1] = URLEncoder.encode(a2, \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"<\u001d/dQ")).replace(MTSCart.ALLATORIxDEMO("x"), \u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"L{Y"));
            arrobject[2] = URLEncoder.encode(a4, MTSCart.ALLATORIxDEMO("\u0006\u0015\u0015lk")).replace(\u61a8\u61a8\u8c37.ALLATORIxDEMO((String)"B"), MTSCart.ALLATORIxDEMO("vsc"));
            return String.format(string, arrobject);
        }
        catch (UnsupportedEncodingException a32) {
            a32.printStackTrace();
            return "";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ boolean verifyOTP(String a2, String a3) {
        if (a3 == null || ((String)a3).isEmpty()) {
            return false;
        }
        try {
            int n2;
            TimeBasedOneTimePasswordGenerator timeBasedOneTimePasswordGenerator = new TimeBasedOneTimePasswordGenerator();
            Object object = a3 = (Object)new Base32().decode((String)a3);
            a3 = new SecretKeySpec((byte[])object, 0, ((Object)object).length, timeBasedOneTimePasswordGenerator.getAlgorithm());
            Date date = new Date();
            long l2 = timeBasedOneTimePasswordGenerator.getTimeStep(TimeUnit.MILLISECONDS);
            int n3 = n2 = -1;
            while (n3 <= 1) {
                Date date2 = new Date(date.getTime() + l2 * (long)n2);
                int n4 = timeBasedOneTimePasswordGenerator.generateOneTimePassword((SecretKey)a3, date2);
                Object[] arrobject = new Object[1];
                arrobject[0] = n4;
                if (String.format(MTSCart.ALLATORIxDEMO("dcw7"), arrobject).equals(a2)) {
                    return true;
                }
                n3 = ++n2;
            }
            return false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public /* synthetic */ GoogleAuthenticator() {
        GoogleAuthenticator a2;
    }
}

