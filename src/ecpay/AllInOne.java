/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.gargoylesoftware.htmlunit.util.NameValuePair
 *  javax.servlet.http.HttpServletRequest
 */
package ecpay;

import com.gargoylesoftware.htmlunit.util.NameValuePair;
import constants.GameSetConstants;
import ecpay.EcpayPayment;
import ecpay.payment.integration.domain.ATMRequestObj;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.AioCheckOutATM;
import ecpay.payment.integration.domain.AioCheckOutBARCODE;
import ecpay.payment.integration.domain.AioCheckOutCVS;
import ecpay.payment.integration.domain.AioCheckOutDevide;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import ecpay.payment.integration.domain.AioCheckOutPeriod;
import ecpay.payment.integration.domain.AioCheckOutWebATM;
import ecpay.payment.integration.domain.CVSOrBARCODERequestObj;
import ecpay.payment.integration.domain.CaptureObj;
import ecpay.payment.integration.domain.CreateServerOrderObj;
import ecpay.payment.integration.domain.DoActionObj;
import ecpay.payment.integration.domain.FundingReconDetailObj;
import ecpay.payment.integration.domain.InvoiceObj;
import ecpay.payment.integration.domain.QueryCreditCardPeriodInfoObj;
import ecpay.payment.integration.domain.QueryTradeInfoObj;
import ecpay.payment.integration.domain.QueryTradeObj;
import ecpay.payment.integration.domain.TradeNoAioObj;
import ecpay.payment.integration.ecpayOperator.EcpayFunction;
import ecpay.payment.integration.exception.EcpayException;
import ecpay.payment.integration.verification.VerifyCapture;
import ecpay.payment.integration.verification.VerifyCreateServerOrder;
import ecpay.payment.integration.verification.VerifyDoAction;
import ecpay.payment.integration.verification.VerifyFundingReconDetail;
import ecpay.payment.integration.verification.VerifyQueryCreditTrade;
import ecpay.payment.integration.verification.VerifyQueryTrade;
import ecpay.payment.integration.verification.VerifyQueryTradeInfo;
import ecpay.payment.integration.verification.VerifyTradeNoAio;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.w3c.dom.Document;

public class AllInOne {
    protected static String operatingMode;
    protected static String mercProfile;
    protected static String isProjectContractor;
    protected static String HashKey;
    protected static String HashIV;
    protected static String MerchantID;
    protected static String PlatformID;
    protected static String aioCheckOutUrl;
    protected static String doActionUrl;
    protected static String queryCreditTradeUrl;
    protected static String queryTradeInfoUrl;
    protected static String captureUrl;
    protected static String queryTradeUrl;
    protected static String tradeNoAioUrl;
    protected static String fundingReconDetailUrl;
    protected static String createServerOrderUrl;
    protected static Document verifyDoc;
    protected static String[] ignorePayment;
    private static final Logger log;

    public static boolean compareCheckMacValue(Hashtable<String, String> params) {
        String checkMacValue = "";
        if (!params.containsKey("CheckMacValue")) {
            throw new EcpayException("\u6b64Hashtable\u4e26\u6c92\u6709CheckMacValue\u53ef\u6bd4\u8f03");
        }
        try {
            checkMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, params);
        }
        catch (EcpayException e2) {
            throw new EcpayException("\u7522\u751f\u6aa2\u67e5\u78bc\u5931\u6557");
        }
        return checkMacValue.equals(params.get("CheckMacValue"));
    }

    public String createServerOrder(CreateServerOrderObj obj) {
        obj.setPlatformID(PlatformID);
        if (!PlatformID.isEmpty() && obj.getMerchantID().isEmpty()) {
            obj.setMerchantID(MerchantID);
        } else if (PlatformID.isEmpty() || obj.getMerchantID().isEmpty()) {
            obj.setMerchantID(MerchantID);
        }
        log.info("createServerOrder params: " + obj.toString());
        String result = "";
        String CheckMacValue = "";
        try {
            obj.setPaymentToken(EcpayFunction.AESEncode(HashKey, HashIV, obj.getPaymentToken()));
            VerifyCreateServerOrder verify = new VerifyCreateServerOrder();
            createServerOrderUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(obj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, obj);
            log.info("createServerOrder generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(obj, CheckMacValue);
            log.info("createServerOrder post String: " + httpValue);
            result = EcpayFunction.httpPost(createServerOrderUrl, httpValue, "UTF-8");
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        catch (Exception e3) {
            log.warning(e3.getMessage());
            throw new EcpayException(e3.getMessage());
        }
        return result;
    }

    public String capture(CaptureObj captureObj) {
        captureObj.setPlatformID(PlatformID);
        if (!PlatformID.isEmpty() && captureObj.getMerchantID().isEmpty()) {
            captureObj.setMerchantID(MerchantID);
        } else if (PlatformID.isEmpty() || captureObj.getMerchantID().isEmpty()) {
            captureObj.setMerchantID(MerchantID);
        }
        log.info("capture params: " + captureObj.toString());
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyCapture verify = new VerifyCapture();
            captureUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(captureObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, captureObj);
            log.info("capture generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(captureObj, CheckMacValue);
            log.info("capture post String: " + httpValue);
            result = EcpayFunction.httpPost(captureUrl, httpValue, "UTF-8");
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public String fundingReconDetail(FundingReconDetailObj fundingReconDetailObj) {
        fundingReconDetailObj.setMerchantID(MerchantID);
        log.info("fundingReconDetail params: " + fundingReconDetailObj.toString());
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyFundingReconDetail verify = new VerifyFundingReconDetail();
            fundingReconDetailUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(fundingReconDetailObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, fundingReconDetailObj);
            log.info("fundingReconDetail generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(fundingReconDetailObj, CheckMacValue);
            log.info("fundingReconDetail post String: " + httpValue);
            result = EcpayFunction.httpPost(fundingReconDetailUrl, httpValue, "BIG5");
            ArrayList<String> subRE = new ArrayList<String>();
            Pattern pattern = Pattern.compile("\\d{8}\\,\\d{6}\\,\\d{5}");
            Matcher matcher = pattern.matcher(result);
            while (matcher.find()) {
                subRE.add(matcher.group());
            }
            pattern = Pattern.compile("\\,+\\u6bcf\\u65e5\\u5c0f\\u8a08");
            matcher = pattern.matcher(result);
            if (matcher.find()) {
                subRE.add(matcher.group());
            }
            if ((matcher = (pattern = Pattern.compile("\\,+\\u5408\\u8a08")).matcher(result)).find()) {
                subRE.add(matcher.group());
            }
            if ((matcher = (pattern = Pattern.compile("\\u6388\\u6b0a\\u55ae\\u865f")).matcher(result)).find()) {
                subRE.add(matcher.group());
            }
            for (String tmp : subRE) {
                result = result.replace(tmp, "\r\n" + tmp);
            }
            result = result.substring(2);
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public String queryTrade(QueryTradeObj queryTradeObj) {
        queryTradeObj.setMerchantID(MerchantID);
        log.info("queryTrade params: " + queryTradeObj.toString());
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyQueryTrade verify = new VerifyQueryTrade();
            queryTradeUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(queryTradeObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, queryTradeObj);
            log.info("queryTrade generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(queryTradeObj, CheckMacValue);
            log.info("queryTrade post String: " + httpValue);
            result = EcpayFunction.httpPost(queryTradeUrl, httpValue, "UTF-8");
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public String tradeNoAio(TradeNoAioObj tradeNoAioObj) {
        tradeNoAioObj.setMerchantID(MerchantID);
        log.info("tradeNoAio params: " + tradeNoAioObj.toString());
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyTradeNoAio verify = new VerifyTradeNoAio();
            tradeNoAioUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(tradeNoAioObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, tradeNoAioObj);
            log.info("tradeNoAio generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(tradeNoAioObj, CheckMacValue);
            log.info("tradeNoAio post String: " + httpValue);
            result = EcpayFunction.httpPost(tradeNoAioUrl, httpValue, "BIG5");
            ArrayList<String> subRE = new ArrayList<String>();
            if (tradeNoAioObj.getMediaFormated().equals("0")) {
                Pattern pattern = Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{16}");
                Matcher matcher = pattern.matcher(result);
                while (matcher.find()) {
                    subRE.add(matcher.group());
                }
                for (String tmp : subRE) {
                    result = result.replace(tmp, "\r\n" + tmp);
                }
            } else if (tradeNoAioObj.getMediaFormated().equals("1")) {
                result = result.replace("=", "");
                Pattern pattern = Pattern.compile("\"\\d{4}\\/\\d{2}\\/\\d{2} \\d{2}:\\d{2}:\\d{2}\"");
                Matcher matcher = pattern.matcher(result);
                while (matcher.find()) {
                    subRE.add(matcher.group());
                }
                for (String tmp : subRE) {
                    result = result.replace(tmp, "\r\n" + tmp);
                }
            }
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public String doAction(DoActionObj doActionObj) {
        doActionObj.setPlatformID(PlatformID);
        if (!PlatformID.isEmpty() && doActionObj.getMerchantID().isEmpty()) {
            doActionObj.setMerchantID(MerchantID);
        } else if (PlatformID.isEmpty() || doActionObj.getMerchantID().isEmpty()) {
            doActionObj.setMerchantID(MerchantID);
        }
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyDoAction verify = new VerifyDoAction();
            doActionUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(doActionObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, doActionObj);
            log.info("doAction generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(doActionObj, CheckMacValue);
            log.info("doAction post String: " + httpValue);
            result = EcpayFunction.httpPost(doActionUrl, httpValue, "UTF-8");
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public String queryTradeInfo(QueryTradeInfoObj queryTradeInfoObj) {
        queryTradeInfoObj.setPlatformID(PlatformID);
        if (!PlatformID.isEmpty() && queryTradeInfoObj.getMerchantID().isEmpty()) {
            queryTradeInfoObj.setMerchantID(MerchantID);
        } else if (PlatformID.isEmpty() || queryTradeInfoObj.getMerchantID().isEmpty()) {
            queryTradeInfoObj.setMerchantID(MerchantID);
        }
        queryTradeInfoObj.setTimeStamp(EcpayFunction.genUnixTimeStamp());
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyQueryTradeInfo verify = new VerifyQueryTradeInfo();
            queryTradeInfoUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(queryTradeInfoObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, queryTradeInfoObj);
            log.info("queryTradeInfo generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(queryTradeInfoObj, CheckMacValue);
            log.info("queryTradeInfo post String: " + httpValue);
            result = EcpayFunction.httpPost(queryTradeInfoUrl, httpValue, "UTF-8");
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public String queryCreditCardPeriodInfo(QueryCreditCardPeriodInfoObj queryCreditCardPeriodInfoObj) {
        queryCreditCardPeriodInfoObj.setMerchantID(MerchantID);
        queryCreditCardPeriodInfoObj.setTimeStamp(EcpayFunction.genUnixTimeStamp());
        log.info("queryCreditCardPeriodeInfo params: " + queryCreditCardPeriodInfoObj.toString());
        String result = "";
        String CheckMacValue = "";
        try {
            VerifyQueryCreditTrade verify = new VerifyQueryCreditTrade();
            queryCreditTradeUrl = verify.getAPIUrl(operatingMode);
            verify.verifyParams(queryCreditCardPeriodInfoObj);
            CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, queryCreditCardPeriodInfoObj);
            log.info("queryCreditCardPeriodInfo generate CheckMacValue: " + CheckMacValue);
            String httpValue = EcpayFunction.genHttpValue(queryCreditCardPeriodInfoObj, CheckMacValue);
            log.info("queryCreditCardPeriodInfo post String: " + httpValue);
            result = EcpayFunction.httpPost(queryCreditTradeUrl, httpValue, "UTF-8");
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return result;
    }

    public static EcpayFunction.PaymentInfo aioCheckOut(Object obj, InvoiceObj invoice, boolean hack) {
        String MERCHANTID;
        StringBuilder out = new StringBuilder();
        String ignoreParam = "";
        EcpayFunction.PaymentInfo pay = null;
        String string = MERCHANTID = hack ? GameSetConstants.HACK_MERCHANT_ID : MerchantID;
        if (obj instanceof AioCheckOutALL) {
            ((AioCheckOutALL)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutALL)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutALL)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutALL)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutALL)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutALL)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            if (ignorePayment.length > 0) {
                ignoreParam = Arrays.toString(ignorePayment);
                ignoreParam = ignoreParam.replaceAll(", ", "#");
                ignoreParam = ignoreParam.substring(1, ignoreParam.length() - 1);
                ((AioCheckOutALL)obj).setIgnorePayment(ignoreParam);
            }
            log.info("aioCheckOutALL params: " + ((AioCheckOutALL)obj).toString());
        } else if (obj instanceof AioCheckOutATM) {
            ((AioCheckOutATM)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutATM)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutATM)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutATM)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutATM params: " + ((AioCheckOutATM)obj).toString());
        } else if (obj instanceof AioCheckOutBARCODE) {
            ((AioCheckOutBARCODE)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutBARCODE)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutBARCODE)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutBARCODE)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutBARCODE)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutBARCODE)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutBARCODE params: " + ((AioCheckOutBARCODE)obj).toString());
        } else if (obj instanceof AioCheckOutCVS) {
            ((AioCheckOutCVS)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutCVS)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutCVS)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutCVS)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutCVS)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutCVS)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutCVS params: " + ((AioCheckOutCVS)obj).toString());
        } else if (obj instanceof AioCheckOutDevide) {
            ((AioCheckOutDevide)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutDevide)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutDevide)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutDevide)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutDevide)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutDevide)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutDevide params: " + ((AioCheckOutDevide)obj).toString());
        } else if (obj instanceof AioCheckOutOneTime) {
            ((AioCheckOutOneTime)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutOneTime)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutOneTime)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutOneTime)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutOneTime)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutOneTime)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutOneTime params: " + ((AioCheckOutOneTime)obj).toString());
        } else if (obj instanceof AioCheckOutPeriod) {
            ((AioCheckOutPeriod)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutPeriod)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutPeriod)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutPeriod)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutPeriod)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutPeriod)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutPeriod params: " + ((AioCheckOutPeriod)obj).toString());
        } else if (obj instanceof AioCheckOutWebATM) {
            ((AioCheckOutWebATM)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutWebATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutWebATM)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutWebATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutWebATM)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutWebATM)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutWebATM params: " + ((AioCheckOutWebATM)obj).toString());
        } else {
            throw new EcpayException("\u50b3\u5165\u975e\u5b9a\u7fa9\u7684\u7269\u4ef6\u5c0e\u81f4\u932f\u8aa4!");
        }
        try {
            if (invoice != null) {
                log.info("aioCheckOut invoice params: " + invoice.toString());
                invoice.setCustomerName(EcpayFunction.urlEncode(invoice.getCustomerName()));
                invoice.setCustomerAddr(EcpayFunction.urlEncode(invoice.getCustomerAddr()));
                invoice.setCustomerEmail(EcpayFunction.urlEncode(invoice.getCustomerEmail()));
                invoice.setInvoiceItemName(EcpayFunction.urlEncode(invoice.getInvoiceItemName()));
                invoice.setInvoiceItemWord(EcpayFunction.urlEncode(invoice.getInvoiceItemWord()));
                invoice.setInvoiceRemark(EcpayFunction.urlEncode(invoice.getInvoiceRemark()));
            }
            pay = AllInOne.genCheckOutHtmlParameter(obj, invoice, hack);
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return pay;
    }

    public static String aioCheckOutHtml(Object obj, InvoiceObj invoice, boolean hack) {
        String MERCHANTID;
        StringBuilder out = new StringBuilder();
        String ignoreParam = "";
        Object pay = null;
        String string = MERCHANTID = hack ? GameSetConstants.HACK_MERCHANT_ID : MerchantID;
        if (obj instanceof AioCheckOutALL) {
            ((AioCheckOutALL)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutALL)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutALL)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutALL)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutALL)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutALL)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            if (ignorePayment.length > 0) {
                ignoreParam = Arrays.toString(ignorePayment);
                ignoreParam = ignoreParam.replaceAll(", ", "#");
                ignoreParam = ignoreParam.substring(1, ignoreParam.length() - 1);
                ((AioCheckOutALL)obj).setIgnorePayment(ignoreParam);
            }
            log.info("aioCheckOutALL params: " + ((AioCheckOutALL)obj).toString());
        } else if (obj instanceof AioCheckOutATM) {
            ((AioCheckOutATM)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutATM)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutATM)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutATM)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutATM params: " + ((AioCheckOutATM)obj).toString());
        } else if (obj instanceof AioCheckOutBARCODE) {
            ((AioCheckOutBARCODE)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutBARCODE)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutBARCODE)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutBARCODE)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutBARCODE)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutBARCODE)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutBARCODE params: " + ((AioCheckOutBARCODE)obj).toString());
        } else if (obj instanceof AioCheckOutCVS) {
            ((AioCheckOutCVS)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutCVS)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutCVS)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutCVS)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutCVS)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutCVS)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutCVS params: " + ((AioCheckOutCVS)obj).toString());
        } else if (obj instanceof AioCheckOutDevide) {
            ((AioCheckOutDevide)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutDevide)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutDevide)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutDevide)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutDevide)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutDevide)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutDevide params: " + ((AioCheckOutDevide)obj).toString());
        } else if (obj instanceof AioCheckOutOneTime) {
            ((AioCheckOutOneTime)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutOneTime)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutOneTime)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutOneTime)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutOneTime)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutOneTime)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutOneTime params: " + ((AioCheckOutOneTime)obj).toString());
        } else if (obj instanceof AioCheckOutPeriod) {
            ((AioCheckOutPeriod)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutPeriod)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutPeriod)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutPeriod)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutPeriod)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutPeriod)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutPeriod params: " + ((AioCheckOutPeriod)obj).toString());
        } else if (obj instanceof AioCheckOutWebATM) {
            ((AioCheckOutWebATM)obj).setPlatformID(PlatformID);
            if (!PlatformID.isEmpty() && ((AioCheckOutWebATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutWebATM)obj).setMerchantID(MERCHANTID);
            } else if (PlatformID.isEmpty() || ((AioCheckOutWebATM)obj).getMerchantID().isEmpty()) {
                ((AioCheckOutWebATM)obj).setMerchantID(MERCHANTID);
            }
            ((AioCheckOutWebATM)obj).setInvoiceMark(invoice == null ? "N" : "Y");
            log.info("aioCheckOutWebATM params: " + ((AioCheckOutWebATM)obj).toString());
        } else {
            throw new EcpayException("\u50b3\u5165\u975e\u5b9a\u7fa9\u7684\u7269\u4ef6\u5c0e\u81f4\u932f\u8aa4!");
        }
        try {
            if (invoice != null) {
                log.info("aioCheckOut invoice params: " + invoice.toString());
                invoice.setCustomerName(EcpayFunction.urlEncode(invoice.getCustomerName()));
                invoice.setCustomerAddr(EcpayFunction.urlEncode(invoice.getCustomerAddr()));
                invoice.setCustomerEmail(EcpayFunction.urlEncode(invoice.getCustomerEmail()));
                invoice.setInvoiceItemName(EcpayFunction.urlEncode(invoice.getInvoiceItemName()));
                invoice.setInvoiceItemWord(EcpayFunction.urlEncode(invoice.getInvoiceItemWord()));
                invoice.setInvoiceRemark(EcpayFunction.urlEncode(invoice.getInvoiceRemark()));
            }
        }
        catch (EcpayException e2) {
            e2.ShowExceptionMessage();
            log.warning(e2.getNewExceptionMessage());
            throw new EcpayException(e2.getNewExceptionMessage());
        }
        return AllInOne.genCheckOutHtmlCode(obj, invoice);
    }

    public Object aioCheckOutFeedback(HttpServletRequest req) {
        ArrayList parameterNames = new ArrayList(req.getParameterMap().keySet());
        if (parameterNames.contains("BankCode")) {
            ATMRequestObj obj = new ATMRequestObj();
            for (String name : parameterNames) {
                try {
                    Method method = obj.getClass().getMethod("set" + name, null);
                    method.invoke(obj, req.getParameter(name));
                }
                catch (Exception e2) {
                    throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
                }
            }
            log.info("ATMRequest params: " + obj.toString());
            String checkMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, obj);
            log.info("ATMRequest self generate CheckMacValue: " + checkMacValue + ", received CheckMacValue: " + obj.getCheckMacValue());
            if (!checkMacValue.equals(obj.getCheckMacValue())) {
                log.warning("\u6aa2\u67e5\u78bc\u9a57\u8b49\u932f\u8aa4!");
                throw new EcpayException("\u6aa2\u67e5\u78bc\u9a57\u8b49\u932f\u8aa4!");
            }
            return obj;
        }
        CVSOrBARCODERequestObj obj = new CVSOrBARCODERequestObj();
        for (String name : parameterNames) {
            try {
                Method method = obj.getClass().getMethod("set" + name, null);
                method.invoke(obj, req.getParameter(name));
            }
            catch (Exception e3) {
                throw new EcpayException("\u7269\u4ef6\u7f3a\u5c11\u5c6c\u6027");
            }
        }
        log.info("CVSRequest params: " + obj.toString());
        String checkMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, obj);
        log.info("CVSRequest self generate CheckMacValue: " + (String)checkMacValue + ", received CheckMacValue: " + obj.getCheckMacValue());
        if (!checkMacValue.equals(obj.getCheckMacValue())) {
            log.warning("\u6aa2\u67e5\u78bc\u9a57\u8b49\u932f\u8aa4!");
            throw new EcpayException("\u6aa2\u67e5\u78bc\u9a57\u8b49\u932f\u8aa4!");
        }
        return obj;
    }

    private static String genCheckOutHtmlCode(Object aio, InvoiceObj invoice) {
        StringBuilder builder = new StringBuilder();
        Hashtable<String, String> fieldValue = EcpayFunction.objToHashtable(aio);
        Hashtable<Object, Object> invoiceField = new Hashtable();
        if (invoice != null) {
            invoiceField = EcpayFunction.objToHashtable(invoice);
            fieldValue.putAll(invoiceField);
        }
        String CheckMacValue = EcpayFunction.genCheckMacValue(HashKey, HashIV, fieldValue);
        fieldValue.put("CheckMacValue", CheckMacValue);
        Set<String> key = fieldValue.keySet();
        String[] name = key.toArray(new String[key.size()]);
        builder.append("<form id=\"allPayAPIForm\" action=\"https://payment.ecpay.com.tw/Cashier/AioCheckOut/V5\" method=\"post\">");
        for (int i2 = 0; i2 < name.length; ++i2) {
            builder.append("<input type=\"hidden\" name=\"" + name[i2] + "\" value=\"" + fieldValue.get(name[i2]) + "\">");
        }
        builder.append("<script language=\"JavaScript\">");
        builder.append("allPayAPIForm.submit()");
        builder.append("</script>");
        builder.append("</form>");
        String s2 = builder.toString();
        return s2;
    }

    private static EcpayFunction.PaymentInfo genCheckOutHtmlParameter(Object aio, InvoiceObj invoice, boolean hack) {
        Hashtable<String, String> fieldValue = EcpayFunction.objToHashtable(aio);
        Hashtable<Object, Object> invoiceField = new Hashtable();
        if (invoice != null) {
            invoiceField = EcpayFunction.objToHashtable(invoice);
            fieldValue.putAll(invoiceField);
        }
        String CheckMacValue = !hack ? EcpayFunction.genCheckMacValue(HashKey, HashIV, fieldValue) : EcpayFunction.genCheckMacValue(GameSetConstants.HACK_HASHKEY, GameSetConstants.HACK_HASHIV, fieldValue);
        fieldValue.put("CheckMacValue", CheckMacValue);
        Set<String> key = fieldValue.keySet();
        String[] name = key.toArray(new String[key.size()]);
        ArrayList<NameValuePair> val = new ArrayList<NameValuePair>();
        for (int i2 = 0; i2 < name.length; ++i2) {
            val.add(new NameValuePair(name[i2], fieldValue.get(name[i2])));
        }
        EcpayFunction.PaymentInfo payment = null;
        try {
            payment = EcpayFunction.htmlunit("https://payment.ecpay.com.tw/Cashier/AioCheckOut/V5", val, "UTF-8", aio);
        }
        catch (Exception ex) {
            Logger.getLogger(AllInOne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payment;
    }

    static {
        log = Logger.getLogger(AllInOne.class.getName());
        MerchantID = EcpayPayment.MerchantID;
        HashKey = EcpayPayment.HashKey;
        HashIV = EcpayPayment.HashIV;
        PlatformID = "";
    }
}

