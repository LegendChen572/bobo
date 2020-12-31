/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5408\u592a\u8c37
 *  com.nexmo.client.NexmoClient$Builder
 *  com.nexmo.client.sms.SmsSubmissionResponseMessage
 *  com.nexmo.client.sms.messages.Message
 *  com.nexmo.client.sms.messages.TextMessage
 */
package tools.sms;

import client.MapleCoolDownValueHolder;
import client.messages.commands.player.\u5408\u592a\u8c37;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.Message;
import com.nexmo.client.sms.messages.TextMessage;
import constants.GameSetConstants;
import tools.FileoutputUtil;

public class Nexmo {
    public static /* synthetic */ void sendSMS(String a2, String a3) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\u6b61\u8fce\u4f7f\u7528 " + GameSetConstants.SERVER_NAME + " \u624b\u6a5f\u9a57\u8b49\u7cfb\u7d71!");
            stringBuilder.append("\u60a8\u7684\u9a57\u8b49\u78bc\u662f: " + a3 + " ,");
            stringBuilder.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u7964\u60a6\u9073\u623c\u6130\u5fe5\u0018"));
            Object object = new NexmoClient.Builder().apiKey(MapleCoolDownValueHolder.ALLATORIxDEMO("8Fj\u001b8\u00169\u0017")).apiSecret(\u5408\u592a\u8c37.ALLATORIxDEMO((String)";[K\u007fYN\\T;oMp`N<^")).build();
            TextMessage textMessage = new TextMessage(MapleCoolDownValueHolder.ALLATORIxDEMO("m>[6L"), a2, stringBuilder.toString());
            object = object.getSmsClient().submitMessage((Message)textMessage).getMessages().iterator();
            Object object2 = object;
            while (object2.hasNext()) {
                textMessage = (SmsSubmissionResponseMessage)object.next();
                System.out.println((Object)textMessage);
                object2 = object;
            }
        }
        catch (Exception exception) {
            System.out.println(exception);
            return;
        }
        FileoutputUtil.logToFile(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"Ua^}\u0016\u6245\u6a66\u7c2f\u8a33\u9a59\u8b70 MvM"), "\u767c\u865f\u624b\u6a5f:" + a2 + " \u767c\u9001\u865f\u78bc:" + a3);
    }

    public /* synthetic */ Nexmo() {
        Nexmo a2;
    }
}

