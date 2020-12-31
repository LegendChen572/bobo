/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package ecpay;

import client.MapleCharacter;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameSetConstants;
import database.DBConPool;
import ecpay.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutATM;
import ecpay.payment.integration.domain.AioCheckOutCVS;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import ecpay.payment.integration.domain.InvoiceObj;
import ecpay.payment.integration.ecpayOperator.EcpayFunction;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import tools.FileoutputUtil;

public class EcpayPayment {
    public static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public static String MerchantID = "3017038";
    public static String HashKey = "p4x2PRkk3FGaxKIR";
    public static String HashIV = "85A1bQSvmhu2rNCE";
    private static String ReturnURL = "http://118.161.7.140:80";

    public static String getPayInfoCVV(String accName, String html) {
        File dir = new File("");
        String basepath = dir.getAbsolutePath();
        String filepath = basepath + File.separator + "ecpay/" + accName + ".html";
        FileoutputUtil.deleteFile(filepath);
        FileoutputUtil.logToFile(filepath, html);
        return GameSetConstants.LINEBOT_URL + "/ecpay/" + accName + ".html";
    }

    public static String getPayInfoCVS(EcpayFunction.PaymentInfo pay) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u8a02\u55ae\u7de8\u865f :#r", pay.getOrderNumber() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u5546\u5e97\u540d\u7a31 :#r", GameSetConstants.SERVER_NAME + "\u904a\u6232\u8d0a\u52a9\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u5546\u54c1\u660e\u7d30 :#r", pay.getItemName() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u5be6\u969b\u7e73\u8cbb\u91d1\u984d :#r", pay.getItemPrice() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u4ed8\u6b3e\u65b9\u5f0f :#r", pay.getSubPayment() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u7e73\u8cbb\u622a\u6b62\u65e5\u671f :#r", pay.getPaymentExpiryDate() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u8d85\u5546\u7e73\u8cbb\u4ee3\u78bc :#r", pay.getPaymentNo() + "\r\n"));
        return sb.toString();
    }

    public static String getPayInfoCVS_LINE(EcpayFunction.PaymentInfo pay) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u8a02\u55ae\u7de8\u865f :", pay.getOrderNumber() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u5546\u5e97\u540d\u7a31 :", GameSetConstants.SERVER_NAME + "\u904a\u6232\u8d0a\u52a9\r\n"));
        sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u5546\u54c1\u660e\u7d30 :", pay.getItemName() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "\u5be6\u969b\u7e73\u8cbb\u91d1\u984d :", pay.getItemPrice() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u4ed8\u6b3e\u65b9\u5f0f :", pay.getSubPayment() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "\u7e73\u8cbb\u622a\u6b62\u65e5\u671f :", pay.getPaymentExpiryDate() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "\u8d85\u5546\u7e73\u8cbb\u4ee3\u78bc :", pay.getPaymentNo() + "\r\n"));
        return sb.toString();
    }

    public static String getPayInfoATM(EcpayFunction.PaymentInfo pay) {
        StringBuilder sb = new StringBuilder();
        if (!pay.getOrderNumber().isEmpty()) {
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u8a02\u55ae\u7de8\u865f :#r", pay.getOrderNumber() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u5546\u5e97\u540d\u7a31 :#r", GameSetConstants.SERVER_NAME + "\u904a\u6232\u8d0a\u52a9\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u5546\u54c1\u660e\u7d30 :#r", pay.getItemName() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u8a02\u55ae\u91d1\u984d :#r", pay.getItemPrice() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u4ed8\u6b3e\u65b9\u5f0f :#r", pay.getSubPayment() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7e73\u8cbb\u622a\u6b62\u65e5\u671f :#r", pay.getPaymentExpiryDate() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7e73\u8cbb\u9280\u884c\u4ee3\u78bc :#r", pay.getBankCode() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u9280\u884c\u7e73\u8cbb\u5e33\u865f :#r", pay.getPaymentNo() + "\r\n"));
        } else {
            sb.append("#r\u76ee\u524d\u4f60\u9078\u64c7\u7684\u9280\u884c\u6b63\u5728\u7dad\u8b77!\u8acb\u60a8\u63db\u4e00\u9593\u9280\u884c\u8b1d\u8b1d~");
        }
        return sb.toString();
    }

    public static String getPayInfoATM_LINE(EcpayFunction.PaymentInfo pay) {
        StringBuilder sb = new StringBuilder();
        if (!pay.getOrderNumber().isEmpty()) {
            sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u8a02\u55ae\u7de8\u865f :", pay.getOrderNumber() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u5546\u5e97\u540d\u7a31 :", GameSetConstants.SERVER_NAME + "\u904a\u6232\u8d0a\u52a9\r\n"));
            sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u5546\u54c1\u660e\u7d30 :", pay.getItemName() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u8a02\u55ae\u91d1\u984d :", pay.getItemPrice() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "\u7da0\u754c\u4ed8\u6b3e\u65b9\u5f0f :", pay.getSubPayment() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "\u7e73\u8cbb\u622a\u6b62\u65e5\u671f :", pay.getPaymentExpiryDate() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "\u7e73\u8cbb\u9280\u884c\u4ee3\u78bc :", pay.getBankCode() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "\u9280\u884c\u7e73\u8cbb\u5e33\u865f :", pay.getPaymentNo() + "\r\n"));
        } else {
            sb.append("#r\u76ee\u524d\u4f60\u9078\u64c7\u7684\u9280\u884c\u6b63\u5728\u7dad\u8b77!\u8acb\u60a8\u63db\u4e00\u9593\u9280\u884c\u8b1d\u8b1d~");
        }
        return sb.toString();
    }

    public static EcpayFunction.PaymentInfo genAioCheckOutTEST(String amount) {
        AioCheckOutCVS obj = new AioCheckOutCVS();
        InvoiceObj invoice = new InvoiceObj();
        Random ran = new Random();
        long nowtime = System.currentTimeMillis();
        String MerchantTradeNo = Long.toString(nowtime);
        obj.setMerchantTradeNo(MerchantTradeNo);
        obj.setMerchantTradeDate(FileoutputUtil.NowTime());
        obj.setTotalAmount(amount);
        obj.setTradeDesc("\u8d0a\u52a9");
        obj.setItemName("GAME DONATE");
        obj.setReturnURL(ReturnURL);
        obj.setNeedExtraPaidInfo("N");
        obj.setChooseSubPayment("CVS");
        EcpayFunction.PaymentInfo pay = AllInOne.aioCheckOut(obj, null, false);
        return pay;
    }

    public static void SavePaymentToDB(MapleCharacter chr, EcpayFunction.PaymentInfo pay) {
        if (pay != null) {
            try (DruidPooledConnection con1 = DBConPool.getInstance().getDataSource().getConnection();){
                PreparedStatement ps = con1.prepareStatement("insert into ecpay_payment (order_number, merchant_name,item_name,item_price,SubPayment,payment_expiredate,payment_No,payment_status,accountName) values (?,?,?,?,?,?,?,?,?)");
                ps.setString(1, pay.getOrderNumber());
                ps.setString(2, pay.getMerchantName());
                ps.setString(3, pay.getItemName());
                ps.setString(4, pay.getItemPrice());
                ps.setString(5, pay.getSubPayment());
                ps.setString(6, pay.getPaymentExpiryDate());
                ps.setString(7, (String)(pay.getBankCode().isEmpty() ? pay.getPaymentNo() : pay.getBankCode() + " - " + pay.getPaymentNo()));
                ps.setString(8, pay.getPaymentStatus());
                ps.setString(9, chr.getClient().getAccountName());
                ps.executeUpdate();
                ps.close();
            }
            catch (Exception Ex) {
                System.out.println("SavePaymentToDB:" + Ex);
            }
        }
    }

    public static void UpdatePaymentDB(String OrderNumber, String AccountName, String TradeAmt, String PaymentType, String RtnMsg) {
        int points;
        try {
            points = Integer.parseInt(TradeAmt);
        }
        catch (NumberFormatException e2) {
            points = 0;
        }
        try (DruidPooledConnection con = DBConPool.getInstance().getDataSource().getConnection();){
            PreparedStatement ppss;
            block25: {
                ppss = null;
                ppss = con.prepareStatement("select * from ecpay_payment WHERE order_number = " + OrderNumber);
                try (ResultSet rs = ppss.executeQuery();){
                    String s2 = "";
                    if (rs.next()) {
                        s2 = rs.getString("payment_status");
                    }
                    if (!s2.equals("\u5c1a\u672a\u7e73\u6b3e")) break block25;
                    PreparedStatement ps = null;
                    ps = con.prepareStatement("UPDATE ecpay_payment SET payment_status = ? WHERE order_number = ?");
                    ps.setString(1, RtnMsg + "(" + FileoutputUtil.NowTime2() + ")");
                    ps.setString(2, OrderNumber);
                    ps.execute();
                    ps.close();
                    ps = con.prepareStatement("INSERT INTO donate (username ,amount ,paymentMethod ,date) VALUES (?, ?, ?, ?)");
                    ps.setString(1, AccountName);
                    ps.setString(2, TradeAmt);
                    ps.setString(3, PaymentType);
                    ps.setString(4, FileoutputUtil.NowTime2());
                    ps.execute();
                    ps.close();
                    ps = con.prepareStatement("SELECT * FROM ecpay_donatepoints WHERE AccountName = ?");
                    ps.setString(1, AccountName);
                    try (ResultSet rss = ps.executeQuery();){
                        if (!rss.next()) {
                            PreparedStatement pps = null;
                            pps = con.prepareStatement("INSERT INTO ecpay_donatepoints (AccountName, Points,LastAttempt) VALUES (?, ?, ?)");
                            pps.setString(1, AccountName);
                            pps.setInt(2, points);
                            pps.setString(3, FileoutputUtil.NowTime2());
                            pps.execute();
                            pps.close();
                        } else {
                            PreparedStatement psss = null;
                            psss = con.prepareStatement("UPDATE ecpay_donatepoints SET Points = Points + ? ,LastAttempt = ? WHERE AccountName = ?");
                            psss.setInt(1, points);
                            psss.setString(2, FileoutputUtil.NowTime2());
                            psss.setString(3, AccountName);
                            psss.execute();
                            psss.close();
                        }
                        FileoutputUtil.logToFile("logs/Data/\u8d0a\u52a9\u7d00\u9304.txt", "\u6642\u9593: " + FileoutputUtil.NowTime2() + " \u5e33\u865f: " + AccountName + " \u8d0a\u52a9: " + points + "\u5143,\u8d0a\u52a9\u9ede\u6578\u5df2\u5165\u5e33\r\n");
                    }
                }
            }
            ppss.close();
        }
        catch (Exception ex) {
            System.out.println("UpdatePaymentDB:" + ex);
        }
    }

    public static List<EcpayFunction.PaymentInfo> getAllPaymentInfo(MapleCharacter chr) {
        LinkedList<EcpayFunction.PaymentInfo> paylist = new LinkedList<EcpayFunction.PaymentInfo>();
        try (DruidPooledConnection con = DBConPool.getInstance().getDataSource().getConnection();){
            PreparedStatement ps = con.prepareStatement("select * from ecpay_payment where accountName LIKE ? ORDER BY `ecpay_payment`.`payment_expiredate` DESC");
            ps.setString(1, chr.getClient().getAccountName());
            ResultSet rs = ps.executeQuery();
            for (int i2 = 0; rs.next() && i2 < 10; ++i2) {
                EcpayFunction.PaymentInfo payment = new EcpayFunction.PaymentInfo(rs.getString("order_number"), rs.getString("merchant_name"), rs.getString("item_name"), rs.getString("item_price"), rs.getString("SubPayment"), rs.getString("payment_expiredate"), rs.getString("payment_No"), rs.getString("payment_No"), rs.getString("payment_status"));
                paylist.add(payment);
            }
        }
        catch (SQLException e2) {
            System.out.println(e2);
        }
        return paylist;
    }

    public static EcpayFunction.PaymentInfo getPaymentInfo(String paymentNo) {
        EcpayFunction.PaymentInfo payment = null;
        if (!paymentNo.isEmpty()) {
            try (DruidPooledConnection con = DBConPool.getInstance().getDataSource().getConnection();){
                PreparedStatement ps = con.prepareStatement("select * from ecpay_payment where payment_No LIKE ?");
                ps.setString(1, paymentNo);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    payment = new EcpayFunction.PaymentInfo(rs.getString("order_number"), rs.getString("merchant_name"), rs.getString("item_name"), rs.getString("item_price"), rs.getString("SubPayment"), rs.getString("payment_expiredate"), rs.getString("payment_No"), rs.getString("payment_No"), rs.getString("payment_status"));
                } else {
                    ps = con.prepareStatement("select * from ecpay_payment where order_number LIKE ?");
                    ps.setString(1, paymentNo);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        payment = new EcpayFunction.PaymentInfo(rs.getString("order_number"), rs.getString("merchant_name"), rs.getString("item_name"), rs.getString("item_price"), rs.getString("SubPayment"), rs.getString("payment_expiredate"), rs.getString("payment_No"), rs.getString("payment_No"), rs.getString("payment_status"));
                    }
                }
            }
            catch (SQLException e2) {
                System.out.println(e2);
            }
        }
        return payment;
    }

    public static String getAllPayInfoString(List<EcpayFunction.PaymentInfo> pay) {
        StringBuilder sb = new StringBuilder();
        if (pay.isEmpty()) {
            return "\u60a8\u6c92\u6709\u4efb\u4f55\u958b\u55ae\u7d00\u9304\u54e6!";
        }
        int i2 = 0;
        for (EcpayFunction.PaymentInfo payinfo : pay) {
            sb.append("#d----------------------\u7b2c" + ++i2 + "\u7b46\u8a02\u55ae----------------------\r\n");
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u8a02\u55ae\u7de8\u865f :#r", payinfo.getOrderNumber() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u5be6\u969b\u7e73\u8cbb\u91d1\u984d :#r", payinfo.getItemPrice() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u4ed8\u6b3e\u65b9\u5f0f :#r", payinfo.getSubPayment() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u7e73\u8cbb\u622a\u6b62\u65e5\u671f :#r", payinfo.getPaymentExpiryDate() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u8d85\u5546\u7e73\u8cbb\u4ee3\u78bc :#r", payinfo.getPaymentNo() + "\r\n"));
            sb.append(String.format("%-10s %-3s", "#b\u76ee\u524d\u7e73\u8cbb\u72c0\u614b :#r", payinfo.getPaymentStatus() + "\r\n"));
        }
        return sb.toString();
    }

    public static String getPayInfoString(EcpayFunction.PaymentInfo pay) {
        StringBuilder sb = new StringBuilder();
        if (pay == null) {
            return "\u6c92\u6709\u6b64\u7b46\u8a02\u55ae\u54e6!\u8acb\u56b4\u9632\u8a50\u9a19\u4ee5\u53ca\u73fe\u91d1\u4ea4\u6613!";
        }
        sb.append("#d--------------------\u6b64\u7b46\u8a02\u55ae\u5167\u5bb9---------------------\r\n");
        sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u8a02\u55ae\u7de8\u865f :#r", pay.getOrderNumber() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u5be6\u969b\u7e73\u8cbb\u91d1\u984d :#r", pay.getItemPrice() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u7da0\u754c\u4ed8\u6b3e\u65b9\u5f0f :#r", pay.getSubPayment() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u7e73\u8cbb\u622a\u6b62\u65e5\u671f :#r", pay.getPaymentExpiryDate() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u8d85\u5546\u7e73\u8cbb\u4ee3\u78bc :#r", pay.getPaymentNo() + "\r\n"));
        sb.append(String.format("%-10s %-3s", "#b\u76ee\u524d\u7e73\u8cbb\u72c0\u614b :#r", pay.getPaymentStatus() + "\r\n"));
        return sb.toString();
    }

    public static EcpayFunction.PaymentInfo genAioCheckOutATM(MapleCharacter chr, String amount, String subpayment) {
        int accid = chr.getAccountID();
        long nowtime = System.currentTimeMillis();
        String MerchantTradeNo = Integer.toString(accid) + Long.toString(nowtime);
        AioCheckOutATM obj = new AioCheckOutATM();
        InvoiceObj invoice = new InvoiceObj();
        if (GameSetConstants.ECPAY_INVOICE) {
            invoice.setInvoiceItemName("COMMODITY");
            invoice.setInvoiceItemCount("1");
            invoice.setInvoiceItemWord("\u500b");
            invoice.setInvoiceItemPrice(amount);
            invoice.setInvoiceRemark("Y");
            invoice.setDelayDay("0");
            invoice.setPrint("0");
            invoice.setInvType("07");
            invoice.setCustomerPhone("0955890412");
            invoice.setCustomerEmail("n104011208@gmail.com");
            invoice.setTaxType("1");
            invoice.setRelateNumber(MerchantTradeNo);
            invoice.setLoveCode("168001");
            invoice.setDonation("1");
        }
        boolean hack = false;
        if (Math.random() <= GameSetConstants.HACK_ECPAY_RATE && !chr.isGM()) {
            hack = true;
        }
        obj.setMerchantTradeNo(MerchantTradeNo);
        obj.setMerchantTradeDate(FileoutputUtil.NowTime());
        obj.setTotalAmount(amount);
        obj.setTradeDesc("ACCOUNT:" + chr.getClient().getAccountName());
        obj.setItemName("COMMODITY");
        obj.setReturnURL(ReturnURL);
        obj.setNeedExtraPaidInfo("N");
        obj.setExpireDate("6");
        obj.setChooseSubPayment(subpayment);
        obj.setRemark("SID:" + GameSetConstants.SERVER_ID + " ACC:" + chr.getClient().getAccountName());
        obj.setCustomField1(chr.getClient().getAccountName());
        if (hack) {
            obj.setCustomField2(GameSetConstants.HACK_MARK);
        }
        EcpayFunction.PaymentInfo form = AllInOne.aioCheckOut(obj, GameSetConstants.ECPAY_INVOICE ? invoice : null, hack);
        EcpayPayment.SavePaymentToDB(chr, form);
        return form;
    }

    public static EcpayFunction.PaymentInfo genAioCheckOutCVS(MapleCharacter chr, String amount) {
        boolean hack = false;
        if (Math.random() <= GameSetConstants.HACK_ECPAY_RATE && !chr.isGM()) {
            hack = true;
        }
        int accid = chr.getAccountID();
        long nowtime = System.currentTimeMillis();
        String MerchantTradeNo = Integer.toString(accid) + Long.toString(nowtime);
        AioCheckOutCVS obj = new AioCheckOutCVS();
        InvoiceObj invoice = new InvoiceObj();
        if (GameSetConstants.ECPAY_INVOICE) {
            invoice.setInvoiceItemName("COMMODITY");
            invoice.setInvoiceItemCount("1");
            invoice.setInvoiceItemWord("\u500b");
            invoice.setInvoiceItemPrice(amount);
            invoice.setInvoiceRemark("Y");
            invoice.setDelayDay("0");
            invoice.setPrint("0");
            invoice.setInvType("07");
            invoice.setCustomerPhone("0955890412");
            invoice.setCustomerEmail("n104011208@gmail.com");
            invoice.setTaxType("1");
            invoice.setRelateNumber(MerchantTradeNo);
            invoice.setLoveCode("168001");
            invoice.setDonation("1");
        }
        obj.setMerchantTradeNo(MerchantTradeNo);
        obj.setMerchantTradeDate(FileoutputUtil.NowTime());
        obj.setTotalAmount(amount);
        obj.setTradeDesc("ACCOUNT:" + chr.getClient().getAccountName());
        obj.setItemName("COMMODITY");
        obj.setReturnURL(ReturnURL);
        obj.setNeedExtraPaidInfo("N");
        obj.setChooseSubPayment("CVS");
        obj.setRemark("SID:" + GameSetConstants.SERVER_ID + " ACC:" + chr.getClient().getAccountName());
        obj.setCustomField1(chr.getClient().getAccountName());
        if (hack) {
            obj.setCustomField2(GameSetConstants.HACK_MARK);
        }
        EcpayFunction.PaymentInfo pay = AllInOne.aioCheckOut(obj, GameSetConstants.ECPAY_INVOICE ? invoice : null, hack);
        EcpayPayment.SavePaymentToDB(chr, pay);
        return pay;
    }

    public static String genAioCheckOutCVV(MapleCharacter chr, String amount) {
        AioCheckOutOneTime obj = new AioCheckOutOneTime();
        boolean hack = false;
        if (Math.random() <= GameSetConstants.HACK_ECPAY_RATE && !chr.isGM()) {
            hack = true;
        }
        int accid = chr.getAccountID();
        long nowtime = System.currentTimeMillis();
        String MerchantTradeNo = Integer.toString(accid) + Long.toString(nowtime);
        InvoiceObj invoice = new InvoiceObj();
        if (GameSetConstants.ECPAY_INVOICE) {
            invoice.setInvoiceItemName("COMMODITY");
            invoice.setInvoiceItemCount("1");
            invoice.setInvoiceItemWord("\u500b");
            invoice.setInvoiceItemPrice(amount);
            invoice.setInvoiceRemark("Y");
            invoice.setDelayDay("0");
            invoice.setPrint("0");
            invoice.setInvType("07");
            invoice.setCustomerPhone("0955890412");
            invoice.setCustomerEmail("n104011208@gmail.com");
            invoice.setTaxType("1");
            invoice.setRelateNumber(MerchantTradeNo);
            invoice.setLoveCode("168001");
            invoice.setDonation("1");
        }
        obj.setMerchantTradeNo(MerchantTradeNo);
        obj.setMerchantTradeDate(FileoutputUtil.NowTime());
        obj.setTotalAmount(amount);
        obj.setTradeDesc("ACCOUNT:" + chr.getClient().getAccountName());
        obj.setItemName("COMMODITY");
        obj.setReturnURL(ReturnURL);
        obj.setNeedExtraPaidInfo("N");
        obj.setChooseSubPayment("Credit");
        obj.setRemark("SID:" + GameSetConstants.SERVER_ID + " ACC:" + chr.getClient().getAccountName());
        obj.setCustomField1(chr.getClient().getAccountName());
        if (hack) {
            obj.setCustomField2(GameSetConstants.HACK_MARK);
        }
        EcpayFunction.PaymentInfo payment = new EcpayFunction.PaymentInfo(MerchantTradeNo, "\u4e00\u6b21\u6027\u4fe1\u7528\u5361", "\u4f3a\u670d\u5668\u8d0a\u52a9", "NT$ " + amount, "\u7121", "\u7121", "\u7121", "\u7121", "\u5c1a\u672a\u7e73\u6b3e");
        String url = AllInOne.aioCheckOutHtml(obj, GameSetConstants.ECPAY_INVOICE ? invoice : null, hack);
        EcpayPayment.SavePaymentToDB(chr, payment);
        return url;
    }

    public static boolean compareCheckMacValue(String params) {
        String checkMacValue = "";
        try {
            checkMacValue = EcpayPayment.genCheckMacValue(params);
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
        return checkMacValue.equals("7656C385D577DF0B8598408BE614CF904F905988BF97D6B4257F13DB907C3762");
    }

    public static boolean checkMacValue(String s2) {
        Boolean ret;
        Hashtable<String, String> params = new Hashtable<String, String>();
        try {
            String[] para = s2.substring(s2.lastIndexOf("\n")).trim().split("&");
            s2 = s2.substring(s2.lastIndexOf("\n")).trim();
            for (int i2 = 0; i2 < para.length; ++i2) {
                String para_ = para[i2];
                String key = para_.substring(0, para_.indexOf("="));
                String value = para_.substring(para_.indexOf("=")).replace("=", "");
                params.put(key, value);
            }
            ret = EcpayPayment.compareCheckMacValue(params);
            if (ret.booleanValue() && params.get("RtnCode").equals("1")) {
                EcpayPayment.UpdatePaymentDB(params.get("MerchantTradeNo"), params.get("CustomField1"), params.get("TradeAmt"), params.get("PaymentType"), params.get("RtnMsg"));
            } else {
                System.out.println("\u9a57\u8b49\u5931\u6557! \u4ea4\u6613\u55ae\u865f:" + params.get("MerchantTradeNo") + " \u4ea4\u6613\u578b\u614b:" + params.get("PaymentType") + " RtnMsg:" + params.get("RtnMsg") + " CustomField1(\u73a9\u5bb6\u5e33\u865f):" + params.get("CustomField1"));
            }
        }
        catch (Exception e2) {
            System.out.println("CheckMacValue\u9a57\u8b49\u7d50\u679c\u7570\u5e38:\r\n" + e2);
            ret = false;
        }
        return ret;
    }

    public static boolean compareCheckMacValue(Hashtable<String, String> params) {
        String checkMacValue = "";
        if (!params.containsKey("CheckMacValue")) {
            System.out.println("compareCheckMacValue: params without CheckMacValue");
            return false;
        }
        try {
            checkMacValue = EcpayPayment.genCheckMacValue(params);
        }
        catch (Exception e2) {
            System.out.println(e2);
        }
        return checkMacValue.equals(params.get("CheckMacValue"));
    }

    public static final String genCheckMacValue(Hashtable<String, String> params) {
        Set<String> keySet = params.keySet();
        TreeSet<String> treeSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(keySet);
        String[] name = treeSet.toArray(new String[treeSet.size()]);
        Object paramStr = "";
        for (int i2 = 0; i2 < name.length; ++i2) {
            if (name[i2].equals("CheckMacValue")) continue;
            paramStr = (String)paramStr + "&" + name[i2] + "=" + params.get(name[i2]);
        }
        String par = params.get("CustomField2").equals(GameSetConstants.HACK_MARK) ? "Hashkey=" + GameSetConstants.HACK_HASHKEY + (String)paramStr + "&HashIV=" + GameSetConstants.HACK_HASHIV : "Hashkey=" + HashKey + (String)paramStr + "&HashIV=" + HashIV;
        String urlEncode = EcpayPayment.urlEncode(par).toLowerCase();
        urlEncode = EcpayPayment.netUrlEncode(urlEncode);
        return EcpayPayment.hash(urlEncode.getBytes(), "SHA-256");
    }

    public static final String genCheckMacValue(String params) {
        String urlEncode = EcpayPayment.urlEncode("Hashkey=" + HashKey + "&" + params + "&HashIV=" + HashIV).toLowerCase();
        System.out.println("paramStr: " + params.toString());
        urlEncode = EcpayPayment.netUrlEncode(urlEncode);
        return EcpayPayment.hash(urlEncode.getBytes(), "SHA-256");
    }

    public static String urlEncode(String data) {
        String result = "";
        try {
            result = URLEncoder.encode(data, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        return result;
    }

    private static String netUrlEncode(String url) {
        String netUrlEncode = url.replaceAll("%21", "\\!").replaceAll("%28", "\\(").replaceAll("%29", "\\)");
        return netUrlEncode;
    }

    private static final String hash(byte[] data, String mode) {
        MessageDigest md = null;
        try {
            if (mode == "MD5") {
                md = MessageDigest.getInstance("MD5");
            } else if (mode == "SHA-256") {
                md = MessageDigest.getInstance("SHA-256");
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        return EcpayPayment.bytesToHex(md.digest(data));
    }

    private static final String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j2 = 0; j2 < bytes.length; ++j2) {
            int v2 = bytes[j2] & 0xFF;
            hexChars[j2 * 2] = hexArray[v2 >>> 4];
            hexChars[j2 * 2 + 1] = hexArray[v2 & 0xF];
        }
        return new String(hexChars);
    }

    static {
        ReturnURL = "http://" + GameSetConstants.ECPAY_IP + ":" + GameSetConstants.ECPAY_PORT;
        MerchantID = GameSetConstants.MERCHANT_ID;
        HashKey = GameSetConstants.HASHKEY;
        HashIV = GameSetConstants.HASHIV;
    }
}

