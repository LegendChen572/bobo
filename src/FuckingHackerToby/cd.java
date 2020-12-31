/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.linecorp.bot.client.LineBlobClient
 *  com.linecorp.bot.client.LineMessagingClient
 *  com.linecorp.bot.model.Multicast
 *  com.linecorp.bot.model.PushMessage
 *  com.linecorp.bot.model.ReplyMessage
 *  com.linecorp.bot.model.action.Action
 *  com.linecorp.bot.model.action.MessageAction
 *  com.linecorp.bot.model.event.Event
 *  com.linecorp.bot.model.event.FollowEvent
 *  com.linecorp.bot.model.event.JoinEvent
 *  com.linecorp.bot.model.event.MemberJoinedEvent
 *  com.linecorp.bot.model.event.MemberLeftEvent
 *  com.linecorp.bot.model.event.MessageEvent
 *  com.linecorp.bot.model.event.message.ImageMessageContent
 *  com.linecorp.bot.model.event.message.StickerMessageContent
 *  com.linecorp.bot.model.event.message.TextMessageContent
 *  com.linecorp.bot.model.event.source.GroupSource
 *  com.linecorp.bot.model.event.source.RoomSource
 *  com.linecorp.bot.model.event.source.Source
 *  com.linecorp.bot.model.event.source.UserSource
 *  com.linecorp.bot.model.message.Message
 *  com.linecorp.bot.model.message.TemplateMessage
 *  com.linecorp.bot.model.message.TextMessage
 *  com.linecorp.bot.model.message.template.ButtonsTemplate
 *  com.linecorp.bot.model.message.template.ConfirmTemplate
 *  com.linecorp.bot.model.message.template.Template
 *  com.linecorp.bot.model.profile.UserProfileResponse
 *  com.linecorp.bot.spring.boot.annotation.EventMapping
 *  com.linecorp.bot.spring.boot.annotation.LineMessageHandler
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.boot.SpringApplication
 *  org.springframework.boot.autoconfigure.SpringBootApplication
 *  org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
 *  org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
 */
package FuckingHackerToby;

import FuckingHackerToby.UC;
import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.inventory.MaplePet;
import client.messages.CommandProcessor;
import com.linecorp.bot.client.LineBlobClient;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Multicast;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.JoinEvent;
import com.linecorp.bot.model.event.MemberJoinedEvent;
import com.linecorp.bot.model.event.MemberLeftEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.source.GroupSource;
import com.linecorp.bot.model.event.source.RoomSource;
import com.linecorp.bot.model.event.source.Source;
import com.linecorp.bot.model.event.source.UserSource;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.ConfirmTemplate;
import com.linecorp.bot.model.message.template.Template;
import com.linecorp.bot.model.profile.UserProfileResponse;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import constants.GameSetConstants;
import database.DBConPool;
import ecpay.EcpayPayment;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import provider.MapleDataTool;
import server.Coupon.CouponCreate;
import server.Randomizer;
import tools.FileoutputUtil;
import tools.StringTool;
import tools.database.CashShopConvert;

/*
 * Exception performing whole class analysis ignored.
 */
@SpringBootApplication
@LineMessageHandler
public class cd
extends WebMvcConfigurerAdapter {
    private static /* synthetic */ LineMessagingClient a;
    private static /* synthetic */ Map<String, Long> ALLATORIxDEMO;
    @Autowired
    private /* synthetic */ LineBlobClient B;
    @Autowired
    private /* synthetic */ LineMessagingClient g;
    private static final /* synthetic */ String K = "@";
    private static /* synthetic */ Map<String, Integer> d;
    private static final /* synthetic */ String k = "!";

    public static /* synthetic */ UserProfileResponse ALLATORIxDEMO(String a2) {
        try {
            return (UserProfileResponse)a.getProfile(a2).get();
        }
        catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException(exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @EventMapping
    public /* synthetic */ TextMessage ALLATORIxDEMO(MessageEvent<TextMessageContent> a2) {
        cd a3;
        if (a == null) {
            a = a3.g;
        }
        MessageEvent<TextMessageContent> messageEvent = a2;
        Object object = messageEvent.getMessage();
        object = ((TextMessageContent)messageEvent.getMessage()).getText();
        Source source = a2.getSource();
        String string = source.getUserId();
        String string2 = source.getSenderId();
        string2 = cd.H(string);
        if (source instanceof UserSource) {
            if (object == null) return null;
            if (((String)object).trim().length() <= 0) return null;
            if (a3.H(string)) {
                return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u60c5\u56a5\u7dec\u5bdf\u595c\u6512\u5947\u595f\u6b4ci\u5d9f\u66ee\u662f\u9028\u525d\u5c44\u93fbd"));
            }
            if (((String)object).contains(MaplePet.ALLATORIxDEMO("|\u7db6\u5ba6\u89e5\u824e"))) {
                String[] arrstring = ((String)object).split(" ");
                return new TextMessage(a3.ALLATORIxDEMO(string, arrstring));
            }
            if (((String)object).toLowerCase().startsWith("!")) {
                if (a3.ALLATORIxDEMO(string2) < 5) return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u6b67\u9615\u4e60\u8df6A\u7164\u6cb8\u4f3a\u7545\u6342\u4e89d"));
                String string3 = "";
                String string4 = ((String)object).toLowerCase().replace("!", "").trim();
                string3 = CommandProcessor.processCommandLineBot(string4);
                return new TextMessage(string3);
            }
            if (((String)object).toLowerCase().startsWith("@")) {
                if (string2.equals(MaplePet.ALLATORIxDEMO("\u5c2d\u6716\u7db6\u5ba6"))) return new TextMessage(MaplePet.ALLATORIxDEMO("\u8af7\u517f\u7dbd\u5bad\u89ee\u8245\u001d"));
                if (a3.ALLATORIxDEMO(string2) <= -1) return new TextMessage(MaplePet.ALLATORIxDEMO("\u8af7\u517f\u7dbd\u5bad\u89ee\u8245\u001d"));
                String string5 = "";
                String string6 = ((String)object).toLowerCase().replace("@", "").trim();
                String[] arrstring = string6.split(" ");
                if (arrstring[0].equals("\u8d0a\u52a9") && arrstring.length == 2) {
                    if (GameSetConstants.SERVER_NAME.equals(CashShopConvert.ALLATORIxDEMO("\u6035\u601d\u8c72"))) {
                        return new TextMessage(MaplePet.ALLATORIxDEMO("_HCLD\u0006\u0018\u0013Y\u0012PSZEG]N\u0012VO^]\u0018rXKg]N\u0012VOGD\b_BOCSZYERX\u0001ux\u0004\u000e\u0005\rs\u0004\u000f\t\u000e\u0005r\u007fr\u000f\u0007~\u0002\b\u0006\u0005\u0000\tq\r\u0005\n\u0006\u000bu\n"));
                    }
                    if (!StringTool.isNumeric(arrstring[1])) {
                        return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u6879\u5f62\u936a\u8ac9dM\u8a8e\u8f55\u5120-\u8d4f\u52c4e\u8d67\u52ec\u91bc\u9808"));
                    }
                    int n2 = Integer.parseInt(arrstring[1]);
                    ArrayList<Message> arrayList = new ArrayList<Message>();
                    TemplateMessage templateMessage = a3.ALLATORIxDEMO(MaplePet.ALLATORIxDEMO("\u4f48\u7514\u4f88\u5215\u5571\u5eab\u4ed4\u7880\u7e44\u8c87\u9ee9\u9044\u4ed2\u4e37"), "@\u4ee3\u78bc\u7e73\u8cbb " + n2, "@\u4ee3\u78bc\u7e73\u8cbb " + n2);
                    TemplateMessage templateMessage2 = a3.ALLATORIxDEMO(CashShopConvert.ALLATORIxDEMO("\u4f3a\u7545\u4fa4\u7545\u5324\u7e1e\u8cfe\u9eb3\u903d\u4e88\u4e4e"), "@\u4fe1\u7528\u5361\u7e73\u8cbb " + n2, "@\u4fe1\u7528\u5361\u7e73\u8cbb " + n2);
                    TemplateMessage templateMessage3 = a3.ALLATORIxDEMO(MaplePet.ALLATORIxDEMO("\u4f43\u751f}cq\u8f7e\u5e0f\u9ee9\u9044\u4ed2\u4e37"), "@ATM\u8f49\u5e33\u7e73\u8cbb " + n2, "@ATM\u8f49\u5e33\u7e73\u8cbb " + n2);
                    arrayList.add((Message)templateMessage);
                    arrayList.add((Message)templateMessage2);
                    arrayList.add((Message)templateMessage3);
                    cd.ALLATORIxDEMO(a2.getReplyToken(), arrayList);
                    return new TextMessage("");
                }
                if (arrstring[0].equals(CashShopConvert.ALLATORIxDEMO("\u4e8e\u78f9\u7e1e\u8cfe")) && arrstring.length == 2) {
                    if (GameSetConstants.SERVER_NAME.equals(MaplePet.ALLATORIxDEMO("\u604c\u6047\u8c0b"))) {
                        return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u00051\u00195\u001e\u007fBj\u0003k\n*\u0000<\u001d$\u0014k\f6\u0004$B\u000b\u00022=$\u0014k\f6\u001d=R&\u00186\u0019*\u0000 \u001f+\u0002x/\u0001^w_t)}UpT|(\u0006(v]\u0007Xq\\|Zp+t_s\\r/s"));
                    }
                    if (!StringTool.isNumeric(arrstring[1])) {
                        return new TextMessage(MaplePet.ALLATORIxDEMO("\u6800\u5f38\u9313\u8a93\u001d\u0017\u8af7\u8f0f\u5159w\u4edf\u788b\u7e4f\u8c8c\u001c\u8d3d\u5295\u91e6\u9871"));
                    }
                    int n3 = Integer.parseInt(arrstring[1]);
                    if (n3 < GameSetConstants.LINEBOT_MIN_DONATE) return new TextMessage("\u203b\u8d85\u5546\u4ee3\u78bc\u7e73\u8cbb\u6350\u8d08\u91d1\u984d\u5fc5\u9808\u5728 " + GameSetConstants.LINEBOT_MIN_DONATE + " \u4ee5\u4e0a 6000 \u4ee5\u4e0b,\u95a3\u4e0b\u8f38\u5165\u7684\u91d1\u984d\u4e0d\u5728\u7bc4\u570d\u5167,\u8acb\u91cd\u65b0\u5617\u8a66\u3002");
                    if (n3 > 6000) {
                        return new TextMessage("\u203b\u8d85\u5546\u4ee3\u78bc\u7e73\u8cbb\u6350\u8d08\u91d1\u984d\u5fc5\u9808\u5728 " + GameSetConstants.LINEBOT_MIN_DONATE + " \u4ee5\u4e0a 6000 \u4ee5\u4e0b,\u95a3\u4e0b\u8f38\u5165\u7684\u91d1\u984d\u4e0d\u5728\u7bc4\u570d\u5167,\u8acb\u91cd\u65b0\u5617\u8a66\u3002");
                    }
                    MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string2);
                    return new TextMessage(EcpayPayment.getPayInfoCVS_LINE(EcpayPayment.genAioCheckOutCVS(mapleCharacter, arrstring[1])));
                }
                if (arrstring[0].equals(CashShopConvert.ALLATORIxDEMO("\u4fa4\u7545\u5324\u7e1e\u8cfe")) && arrstring.length == 2) {
                    if (GameSetConstants.SERVER_NAME.equals(MaplePet.ALLATORIxDEMO("\u604c\u6047\u8c0b"))) {
                        return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u00051\u00195\u001e\u007fBj\u0003k\n*\u0000<\u001d$\u0014k\f6\u0004$B\u000b\u00022=$\u0014k\f6\u001d=R&\u00186\u0019*\u0000 \u001f+\u0002x/\u0001^w_t)}UpT|(\u0006(v]\u0007Xq\\|Zp+t_s\\r/s"));
                    }
                    if (!StringTool.isNumeric(arrstring[1])) {
                        return new TextMessage(MaplePet.ALLATORIxDEMO("\u680b\u5f33\u9318\u8a98\u0016\u001c\u8afc\u8f04\u5152|\u4fd6\u7514\u5356\u7e4f\u8c8c\u001c\u8d3d\u5295\u91e6\u9871"));
                    }
                    int n4 = Integer.parseInt(arrstring[1]);
                    if (n4 < GameSetConstants.LINEBOT_MIN_DONATE) return new TextMessage("\u203b\u4fe1\u7528\u5361\u7e73\u8cbb\u6350\u8d08\u91d1\u984d\u5fc5\u9808\u5728 " + GameSetConstants.LINEBOT_MIN_DONATE + " \u4ee5\u4e0a 20000 \u4ee5\u4e0b,\u95a3\u4e0b\u8f38\u5165\u7684\u91d1\u984d\u4e0d\u5728\u7bc4\u570d\u5167,\u8acb\u91cd\u65b0\u5617\u8a66\u3002");
                    if (n4 > 20000) {
                        return new TextMessage("\u203b\u4fe1\u7528\u5361\u7e73\u8cbb\u6350\u8d08\u91d1\u984d\u5fc5\u9808\u5728 " + GameSetConstants.LINEBOT_MIN_DONATE + " \u4ee5\u4e0a 20000 \u4ee5\u4e0b,\u95a3\u4e0b\u8f38\u5165\u7684\u91d1\u984d\u4e0d\u5728\u7bc4\u570d\u5167,\u8acb\u91cd\u65b0\u5617\u8a66\u3002");
                    }
                    MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string2);
                    return new TextMessage("\u4e00\u6b21\u6027\u8d0a\u52a9\u7db2\u5740:\r\n" + EcpayPayment.getPayInfoCVV(mapleCharacter.getClient().getAccountName(), EcpayPayment.genAioCheckOutCVV(mapleCharacter, arrstring[1])));
                }
                if (arrstring[0].equals(CashShopConvert.ALLATORIxDEMO("$\u0019(\u8f24\u5e76\u7e1e\u8cfe")) && arrstring.length == 2) {
                    if (GameSetConstants.SERVER_NAME.equals(MaplePet.ALLATORIxDEMO("\u604c\u6047\u8c0b"))) {
                        return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u00051\u00195\u001e\u007fBj\u0003k\n*\u0000<\u001d$\u0014k\f6\u0004$B\u000b\u00022=$\u0014k\f6\u001d=R&\u00186\u0019*\u0000 \u001f+\u0002x/\u0001^w_t)}UpT|(\u0006(v]\u0007Xq\\|Zp+t_s\\r/s"));
                    }
                    if (!StringTool.isNumeric(arrstring[1])) {
                        return new TextMessage(MaplePet.ALLATORIxDEMO("\u680b\u5f33\u9318\u8a98\u0016\u001c\u8afc\u8f04\u5152|vhz\u8f75\u5e04\u7e4f\u8c8c\u001c\u8d3d\u5295\u91e6\u9871"));
                    }
                    int n5 = Integer.parseInt(arrstring[1]);
                    if (n5 < GameSetConstants.LINEBOT_MIN_DONATE) return new TextMessage("\u203bATM\u8f49\u5e33\u6350\u8d08\u91d1\u984d\u5fc5\u9808\u5728 " + GameSetConstants.LINEBOT_MIN_DONATE + " \u4ee5\u4e0a 20000 \u4ee5\u4e0b,\u95a3\u4e0b\u8f38\u5165\u7684\u91d1\u984d\u4e0d\u5728\u7bc4\u570d\u5167,\u8acb\u91cd\u65b0\u5617\u8a66\u3002");
                    if (n5 > 20000) {
                        return new TextMessage("\u203bATM\u8f49\u5e33\u6350\u8d08\u91d1\u984d\u5fc5\u9808\u5728 " + GameSetConstants.LINEBOT_MIN_DONATE + " \u4ee5\u4e0a 20000 \u4ee5\u4e0b,\u95a3\u4e0b\u8f38\u5165\u7684\u91d1\u984d\u4e0d\u5728\u7bc4\u570d\u5167,\u8acb\u91cd\u65b0\u5617\u8a66\u3002");
                    }
                    MapleCharacter mapleCharacter = MapleCharacter.getCharacterByName(string2);
                    return new TextMessage(EcpayPayment.getPayInfoATM_LINE(EcpayPayment.genAioCheckOutATM(mapleCharacter, arrstring[1], CashShopConvert.ALLATORIxDEMO(".\r$\u000b,\u0011?\u0010>\u0011"))));
                }
                string5 = CommandProcessor.processCommandLineBotPlayer(string6, string2);
                return new TextMessage(string5);
            }
            if (((String)object).equals(CashShopConvert.ALLATORIxDEMO("\u0019 \u001e1"))) {
                cd.ALLATORIxDEMO(new PushMessage(string, (Message)new TextMessage(MaplePet.ALLATORIxDEMO("CYDH"))));
                return null;
            }
            if (((String)object).equals(CashShopConvert.ALLATORIxDEMO("\u00186\b7\u0004!"))) {
                String string7 = string;
                cd.ALLATORIxDEMO(new PushMessage(string7, (Message)new TextMessage(string7)));
                return null;
            }
            if (!GameSetConstants.SERVER_NAME.equals(MaplePet.ALLATORIxDEMO("\u604c\u6047\u8c0b"))) return new TextMessage(MaplePet.ALLATORIxDEMO("\u6b53p^RR~XH\u7506~X^X\u95b7\u764b\u7d6c\u543f\u9076\u6205\u6731\u52ee\u7ad3:6\u82d2\u6094\u99a1\u6b1d\u4f48\u7514\u001b\u8af7\u517f\u5c3b[UYY\u7db6\u5ba6\u907d\u620e\u89e5\u824e\u54d1\u001d\u0017\u7dbd\u5bad\u6585\u5f38\u8af7\u8f0f\u5159\r1=\u001ew\u7dbd\u5bad\u89ee\u8245\u001c\u907d\u620e~x\u0017\u9076\u6205\u5e0f\u8668\u001c\u907d\u620e\u5bf1\u7880\u0015\u001c:6\u82d2\u973c\u89b6\u8d36\u529e\u9076\u6205\u0010\u53d8\u626f\r1=\u001ew\u8d36\u529e\u001c\u91e6\u9871\u0015\u001cRD\r\u001ew\u8d36\u529e\u001c\u0002\f\u0007\u001e"));
            return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u6b09\t\u0004+\b\u0007\u00021\u755c\u0007\u0002'\u0002\u95ce\u7611\u7d15\u5465\u900f\u625f\u6748\u52b4\u7aaa`O\u8288\u60ed\u99fb\u6b64\u4f12\u756dA\u8a8e\u5125\u5c42\u0001,\u0003 \u7dec\u5bdf\u9027\u6277\u89bf\u8237\u548bdM\u7dc4\u5bf7\u65fc\u5f62\u8a8e\u8f55\u5120WHgg-\u7dc4\u5bf7\u8997\u821fe\u9027\u6277$\u0001M\u900f\u625f\u5e76\u8632e\u9027\u6277\u5bab\u78f9Oe`O\u8288\u9745\u89ec\u8d4f\u52c4\u900f\u625fi\u5382\u6216WHgg-\u8d4f\u52c4e\u91bc\u9808Oe\b=Wg-\u8d4f\u52c4eXu]gMHg\u8d4f\u52c4\u5bc9\u627d\uff49\u8aa6\u7984\u8a67\u7ccc\u5c65\u3047`O\u6b09\t\u0004+\b\u70ff\u6a32\u562d\u4ed7\uff49\u7766\u4e48\u525d\u8a4f\u6002\u3047"));
        }
        if (source instanceof RoomSource) {
            return null;
        }
        if (!(source instanceof GroupSource)) return null;
        String string8 = ((GroupSource)source).getGroupId();
        if (((String)object).equals(CashShopConvert.ALLATORIxDEMO("\u95ce\u59a6\u7359\u6515\u5b12\u6bb9\u8cb8"))) {
            if (a3.ALLATORIxDEMO(string2) < -1) return null;
            String string9 = string8;
            UC.ALLATORIxDEMO((String)string9).B = true;
            UC.ALLATORIxDEMO((String)string9).k = Randomizer.rand(1, 50);
            return new TextMessage(MaplePet.ALLATORIxDEMO("\u6b5d\u8ff9\u95b7\u59fc\u7320\u654f\u5b6b\u5910\u8cc1\u907d\u620e\u0016\u001c\u5433\u4f71\u739e\u5b8a\u8afc\u76c8\u6392\u8f04\u5152\u7d28\u654f\u5b6b\u5344\u53d3\u0016\u001c\u6bf8\u4e86\u673e\u4e3c\u6b16\u6a63\u6734\u54daI\u001c\u654f\u5b6b\u7bf3\u5731\r\u001c\u0006B\u0002\f"));
        }
        if (UC.ALLATORIxDEMO((String)string8).k == -1) return null;
        if (!MapleDataTool.isNumeric((String)object)) return null;
        if (string2.equals(CashShopConvert.ALLATORIxDEMO("\u5c77\u676f\u7dec\u5bdf"))) return new TextMessage(MaplePet.ALLATORIxDEMO("\u8afc\u5174\u79f6\u8a36\u671b\u6a63\u565f\u4e86\u7db6\u5ba6\u609f\u76b8\u907d\u620e\u89e5\u824e\u627a\u53d3\u4ed2\u53ff\u5297\u9076\u6205\u001d"));
        int n6 = Integer.parseInt((String)object);
        if (UC.ALLATORIxDEMO((String)string8).a.contains(n6)) {
            return new TextMessage(string2 + " \u6578\u5b57 " + n6 + " \u525b\u525b\u6709\u4eba\u731c\u904e\u56c9!!");
        }
        if (UC.ALLATORIxDEMO((String)string8).K.contains(string2)) {
            return new TextMessage(string2 + " \u60a8\u525b\u525b\u731c\u904e\u56c9!!");
        }
        if (n6 > 50) {
            return new TextMessage(string2 + " \u7bc4\u570d\u662f1~50\u54e6! \u8acb\u518d\u731c\u4e00\u6b21!");
        }
        if (UC.ALLATORIxDEMO((String)string8).k != n6) {
            UC.ALLATORIxDEMO((String)string8).a.add(n6);
            UC.ALLATORIxDEMO((String)string8).K.add(string2);
            return new TextMessage(string2 + " \u60a8\u731c\u7684\u6578\u5b57\u70ba " + n6 + " \u7b54\u932f\u56c9!!");
        }
        if (UC.ALLATORIxDEMO((String)string8).k != n6) return null;
        String string10 = string8;
        UC.ALLATORIxDEMO((String)string10).B = false;
        UC.ALLATORIxDEMO((String)string10).k = -1;
        UC.ALLATORIxDEMO((String)string10).a.clear();
        UC.ALLATORIxDEMO((String)string10).K.clear();
        cd.ALLATORIxDEMO(new PushMessage(string, (Message)new TextMessage("\u606d\u559c\u904a\u6232\u7372\u734e! \u8d08\u9001\u60a8500\u6953\u8449\u9ede\u6578\u5e8f\u865f\u4f5c\u70ba\u734e\u52f5!\r\n" + CouponCreate.CreateNXCode(2, 500, 1, 1))));
        return new TextMessage(string2 + " \u606d\u559c\u60a8\u731c\u5c0d\u5e78\u904b\u6578\u5b57 " + n6 + " !! \u904a\u6232\u7d50\u675f\u3002 500\u9ede\u6953\u9ede\u5e8f\u865f\u5df2\u7d93\u79c1\u8a0a\u60a8");
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ String H(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public static /* synthetic */ {
        a = null;
        d = new HashMap<String, Integer>();
        ALLATORIxDEMO = new HashMap<String, Long>();
    }

    public static /* synthetic */ void ALLATORIxDEMO(String a2, String a3) {
        a3 = new TextMessage(a3);
        cd.ALLATORIxDEMO(a2, (Message)a3);
    }

    @EventMapping
    public /* synthetic */ TextMessage ALLATORIxDEMO(JoinEvent a2) {
        return new TextMessage(MaplePet.ALLATORIxDEMO("\u591b\u5b81\u5941"));
    }

    public static /* synthetic */ void l(String a2, String a3) {
        String string = cd.ALLATORIxDEMO(a2);
        if (!string.equals(CashShopConvert.ALLATORIxDEMO("\u5c77\u676f\u7dec\u5bdf"))) {
            cd.ALLATORIxDEMO(new PushMessage(string, (Message)new TextMessage(a3)));
        }
    }

    @EventMapping
    public /* synthetic */ TextMessage ALLATORIxDEMO(MemberJoinedEvent a2) {
        Source source = a2.getSource();
        a2 = source.getUserId();
        String string = source.getSenderId();
        if ((a2 = cd.H((String)a2)).equals(CashShopConvert.ALLATORIxDEMO("\u5c77\u676f\u7dec\u5bdf"))) {
            return new TextMessage(MaplePet.ALLATORIxDEMO("\u6b5d\u8ff9\u7395\u5b81\u529c\u5152\u7f98\u7d73\u001d\u0017\u8af7\u8da2\u5fd7\u5297\u5159\u6b53\u6a63\u565f\u4e86\u594a\u53f7\u7db6\u5ba6\u907d\u620e\u89e5\u824e\u54d1\u001d"));
        }
        return new TextMessage("\u6b61\u8fce\u73a9\u5bb6: " + (String)a2 + " \u52a0\u5165\u7fa4\u7d44!");
    }

    public /* synthetic */ void H(String a2, String a3) {
    }

    private static /* synthetic */ void ALLATORIxDEMO(ReplyMessage a2) {
        try {
            a.replyMessage(a2).get();
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException(exception);
        }
    }

    @EventMapping
    public /* synthetic */ TextMessage H(MemberLeftEvent a2) {
        Source source = a2.getSource();
        a2 = source.getUserId();
        String string = source.getSenderId();
        a2 = cd.H((String)a2);
        return new TextMessage("\u73a9\u5bb6: " + (String)a2 + " \u5df2\u96e2\u958b\u7fa4\u7d44!");
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ int ALLATORIxDEMO(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public static /* synthetic */ void l(String a2) {
        try {
            a.leaveGroup(a2).get();
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException(exception);
        }
    }

    public /* synthetic */ String ALLATORIxDEMO(String a2, String[] a3) {
        cd a4;
        if (((String[])a3).length != 4) {
            return CashShopConvert.ALLATORIxDEMO("\u6879\u5f62\u8f7d\u5108\u936a\u8ac9d\u8aa6\u8f7d\u5108\u007fO\u0005\u7dec\u5bdf\u89bf\u8237M\u900f\u625f\f)e\u9027\u6277\u5e5e\u861aM\u900f\u625f\u5b83\u78d1g");
        }
        a3 = a3[1];
        String string = a3[2];
        String string2 = a3[3];
        if (MapleCharacterUtil.getAccountNameByCharacterName((String)a3).equals(string)) {
            if (a4.ALLATORIxDEMO(a2, (String)a3)) {
                if (MapleCharacterUtil.checkPassword(string, string2)) {
                    if (a4.H(a2, (String)a3)) {
                        int n2 = 500;
                        if (GameSetConstants.SERVER_NAME.equals(MaplePet.ALLATORIxDEMO("\u696f\u4e7c\u75e9"))) {
                            n2 = 100;
                        }
                        int n3 = n2;
                        return "\u7d81\u5b9a\u6210\u529f!\u60a8\u7d81\u5b9a\u7684\u89d2\u8272\u70ba:" + (String)a3 + " \r\n\u8d08\u9001\u60a8" + n3 + "\u6953\u8449\u9ede\u6578\u5e8f\u865f\u4f5c\u70ba\u734e\u52f5!\r\n" + CouponCreate.CreateNXCode(2, n3, 1, 1) + " \r\n\u8acb\u9032\u5165\u904a\u6232\u5546\u57ce\u5167\u514c\u63db!";
                    }
                    return CashShopConvert.ALLATORIxDEMO("\u7dec\u5bdf\u595c\u6512L\u8a8e\u9077\u77a0\u7bcc\u7443\u548cd");
                }
                a4.E(a2);
                return MaplePet.ALLATORIxDEMO("\u609f\u8f04\u5152\u76b8\u5e04\u8663\u6221\u5bfa\u788b\u9313\u8a93\u0010\u7db6\u5ba6\u5906\u656b\u0016\u0014\u6cdf\u6133\r\u9313\u8a93\u9068\u0004\u6b1d\u5c30\u9051\u5c36\u93aa\u0016\u0015");
            }
            return CashShopConvert.ALLATORIxDEMO("\u60c5\u76c1!\f#\u0000\u627b\u666a\u8f55\u5120\u76e9\u8997\u821f\u5db7\u7dec\u5bdf\u9023d");
        }
        a4.E(a2);
        FileoutputUtil.logToFile(MaplePet.ALLATORIxDEMO("[SPO\u0018p^RR~XH\u0019HOH"), "\r\n\u7d81\u5b9a\u540d\u7a31:" + (String)a3 + " \u7d81\u5b9a\u5e33\u865f:" + MapleCharacterUtil.getAccountNameByCharacterName((String)a3) + " \u8f38\u5165\u5e33\u865f:" + string);
        return CashShopConvert.ALLATORIxDEMO("\u60c5\u8997\u821f\u76c1\u5e5e\u861a\u826a\u60ed\u76e9\u8f7d\u5108\u76c1\u5e5e\u861a\u4e60\u5449A\u8a8e\u51e0\u6b64\u78d7\u8ac8Lm\u6c85\u614aW\u936a\u8ac9\u9011^\u6b64\u5c6a\u9028\u5c6c\u93d3Ll");
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ boolean ALLATORIxDEMO(String a, String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public static /* synthetic */ boolean ALLATORIxDEMO(String a2) {
        if (ALLATORIxDEMO.containsKey(a2)) {
            return ALLATORIxDEMO.get(a2) > System.currentTimeMillis();
        }
        return false;
    }

    @EventMapping
    public /* synthetic */ TextMessage H(JoinEvent a2) {
        return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u0005 \u0001)\u0002d"));
    }

    public /* synthetic */ boolean H(String a2) {
        if (d.containsKey(a2)) {
            return d.get(a2) >= 50;
        }
        return false;
    }

    public static /* synthetic */ void ALLATORIxDEMO(String a2) {
        if (ALLATORIxDEMO.containsKey(a2)) {
            ALLATORIxDEMO.remove(a2);
            ALLATORIxDEMO.put(a2, System.currentTimeMillis() + 180000L);
            return;
        }
        ALLATORIxDEMO.put(a2, System.currentTimeMillis() + 180000L);
    }

    public static /* synthetic */ void ALLATORIxDEMO(Set<String> a2, Message a32) {
        try {
            a32 = new Multicast(a2, a32);
            a.multicast((Multicast)a32).get();
            return;
        }
        catch (InterruptedException | ExecutionException a32) {
            throw new RuntimeException(a32);
        }
    }

    @EventMapping
    public /* synthetic */ void ALLATORIxDEMO(FollowEvent a2) {
        if (a == null) {
            cd a3;
            a = a3.g;
        }
        ArrayList<Message> arrayList = new ArrayList<Message>();
        ConfirmTemplate confirmTemplate = new ConfirmTemplate(MaplePet.ALLATORIxDEMO("\u6b56\u8ff2\u5297\u5159usus\u673a\u52e5\u7ad8\u6a63\u565f\u4e86:6pq\u67d2\u7737\u53d8\u7514\u6330\u4ed8\u8afc\u8f04\u5152\u001d_Y[L:6\u739e\u5b8a\u67d2\u7737\u53d8\u7514\u6330\u4ed8\u8afc\u8f04\u5152|_Y[L"), (Action)new MessageAction(CashShopConvert.ALLATORIxDEMO("d\u0005 \u00015"), MaplePet.ALLATORIxDEMO("\u001d_Y[L")), (Action)new MessageAction(CashShopConvert.ALLATORIxDEMO("\u0005\u0005 \u00015"), MaplePet.ALLATORIxDEMO("|_Y[L")));
        confirmTemplate = new TemplateMessage(CashShopConvert.ALLATORIxDEMO("/\n/\n\u6760\u529c\u7a82\u6a1a\u5605\u4eff"), (Template)confirmTemplate);
        arrayList.add((Message)confirmTemplate);
        arrayList.add((Message)new TextMessage(MaplePet.ALLATORIxDEMO("\u82d9\u609f\u99aa\u6b16\u4f43\u751f\u0010\u8afc\u5174\u5c30P^RR\u7dbd\u5bad\u9076\u6205\u89ee\u8245\u54da\u0016\u001c\u7db6\u5ba6\u658e\u5f33\u8afc\u8f04\u5152\u0006\u0015|\u7db6\u5ba6\u89e5\u824e\u0017\u9076\u6205us\u001c\u907d\u620e\u5e04\u8663\u0017\u9076\u6205\u5bfa\u788b\u001e")));
        arrayList.add((Message)new TextMessage(CashShopConvert.ALLATORIxDEMO("\u6b09\t\u0004+\b\u0007\u00021\u755c\u0007\u0002'\u0002\u95ce\u7611\u7d15\u5465\u6748\u52b4\u7aaaA\u674c\u693e\u4e0e\u8c5a\u62c5\u883e\u6748\u52b4\u9745\u6c2f\u53aa\u904e\u7d24!,\u0003 W-\b+\u001f<Zu^v[i\u9027\u6277\u5522\u9809\u8aa6\u623b*\b\u4e60\u89c4\u6213\u6254A\u615a\u8b70d")));
        arrayList.add((Message)new TextMessage(MaplePet.ALLATORIxDEMO("\u82d9\u9737\u89bd\u8d3d\u5295\u907d\u620e\u001b\u53d3\u6264\u001ew\u8d36\u529e\u001c\u91e6\u9871\u0015\u001cRD\r\u001ew\u8d36\u529e\u001c\u0002\f\u0007\u001e")));
        cd.ALLATORIxDEMO(a2.getReplyToken(), arrayList);
    }

    @EventMapping
    public /* synthetic */ TextMessage ALLATORIxDEMO(MemberLeftEvent a2) {
        return new TextMessage(CashShopConvert.ALLATORIxDEMO("\u000f<\bd"));
    }

    public static /* synthetic */ void ALLATORIxDEMO(String a2, List<Message> a3) {
        cd.ALLATORIxDEMO(new ReplyMessage(a2, a3));
    }

    public static /* synthetic */ void H(String a2) {
        try {
            a.leaveGroup(a2).get();
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException(exception);
        }
    }

    @EventMapping
    public /* synthetic */ Message H(MessageEvent<ImageMessageContent> a2) {
        a2 = MaplePet.ALLATORIxDEMO("\u711d\u8cf0\u65a5");
        return null;
    }

    public /* synthetic */ void addResourceHandlers(ResourceHandlerRegistry a2) {
        cd a3;
        String string = new File("").getAbsolutePath() + File.separator + "ecpay" + File.separator;
        String[] arrstring = new String[1];
        arrstring[0] = MaplePet.ALLATORIxDEMO("\u0013R_G]N\u0013\u001d\u0016");
        String[] arrstring2 = new String[1];
        arrstring2[0] = "file:" + string;
        a2.addResourceHandler(arrstring).addResourceLocations(arrstring2);
        String[] arrstring3 = new String[1];
        arrstring3[0] = CashShopConvert.ALLATORIxDEMO("jGo");
        String[] arrstring4 = new String[1];
        arrstring4[0] = MaplePet.ALLATORIxDEMO("_[]DOG]CT\r\u0013CSXPD\u0013{UYYuSChXS[\u0013{UYYuSC\u0012]]A]");
        a2.addResourceHandler(arrstring3).addResourceLocations(arrstring4);
        System.out.println("file:" + string);
        super.addResourceHandlers(a2);
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ String ALLATORIxDEMO(String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public static /* synthetic */ void ALLATORIxDEMO() {
        String[] arrstring = new String[1];
        arrstring[0] = "";
        SpringApplication.run(cd.class, (String[])arrstring);
    }

    public /* synthetic */ TemplateMessage ALLATORIxDEMO(String a2, String a3, String a4) {
        a2 = new ButtonsTemplate(null, null, a2, Collections.singletonList(new MessageAction(a3, a4)));
        return new TemplateMessage(a3, (Template)a2);
    }

    public static /* synthetic */ void ALLATORIxDEMO(PushMessage a2) {
        try {
            a.pushMessage(a2).get();
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException(exception);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void D(String a) {
        var1_1 = null;
        var2_3 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var2_3;
            var1_1 = v0.prepareStatement(CashShopConvert.ALLATORIxDEMO(")\u0000!\u00009\u0000M\u0003?\n e\u0001,\u0003 \u000f*\u0019e:\r(\u0017(e\u0003$\u0000 MxMz"));
            var1_1.setString(1, a);
            var1_1.execute();
            var1_1.close();
            if (v0 != null) {
                var2_3.close();
                return;
            }
        }
        catch (Throwable var3_5) {
            if (var2_3 == null) ** GOTO lbl25
            try {
                var2_3.close();
                v1 = var3_5;
                ** GOTO lbl26
            }
            catch (Throwable var1_2) {
                try {
                    var3_5.addSuppressed(var1_2);
lbl25:
                    // 2 sources

                    v1 = var3_5;
lbl26:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var2_4) {
                    var2_4.printStackTrace();
                }
            }
        }
    }

    public /* synthetic */ void E(String a2) {
        if (d.containsKey(a2)) {
            int n2 = d.get(a2);
            d.remove(a2);
            d.put(a2, ++n2);
            return;
        }
        d.put(a2, 1);
    }

    public static /* synthetic */ void ALLATORIxDEMO(String a2, Message a3) {
        cd.ALLATORIxDEMO(new ReplyMessage(a2, a3));
    }

    @EventMapping
    public /* synthetic */ void ALLATORIxDEMO(Event a2) {
        System.out.println("event: " + a2);
    }

    public /* synthetic */ TemplateMessage ALLATORIxDEMO(String a2, String a3) {
        cd a4;
        String string = a3;
        return a4.ALLATORIxDEMO(a2, string, string);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ boolean H(String a, String a) {
        var3_4 = null;
        var4_5 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            v0 = var4_5;
            v1 = var3_4 = v0.prepareStatement(MaplePet.ALLATORIxDEMO("~rdyeh\u0017uyhx\u001c[UYYUSC\u001c\u001fRVQR\u0010\u0017IDYEUS\u0015\u0017jvpbyd\u001c\u001f\u0003\u001b\u001c\b\u0015"));
            v1.setString(1, a);
            v1.setString(2, a);
            v1.execute();
            if (v0 != null) {
                var4_5.close();
            }
        }
        catch (Throwable var5_7) {
            if (var4_5 == null) ** GOTO lbl24
            try {
                var4_5.close();
                v2 = var5_7;
                ** GOTO lbl25
            }
            catch (Throwable a) {
                try {
                    var5_7.addSuppressed(a);
lbl24:
                    // 2 sources

                    v2 = var5_7;
lbl25:
                    // 2 sources

                    throw v2;
                }
                catch (SQLException var4_6) {
                    var4_6.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    @EventMapping
    public /* synthetic */ Message ALLATORIxDEMO(MessageEvent<StickerMessageContent> a2) {
        return null;
    }

    public /* synthetic */ cd() {
        cd a2;
    }
}

