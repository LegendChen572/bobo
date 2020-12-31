/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.linecorp.bot.client.LineMessagingClient
 *  com.linecorp.bot.model.Multicast
 *  com.linecorp.bot.model.PushMessage
 *  com.linecorp.bot.model.ReplyMessage
 *  com.linecorp.bot.model.message.Message
 *  com.linecorp.bot.model.message.TextMessage
 *  com.linecorp.bot.model.profile.UserProfileResponse
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package FuckingHackerToby;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Multicast;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.profile.UserProfileResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rc {
    @Autowired
    private /* synthetic */ LineMessagingClient ALLATORIxDEMO;

    public /* synthetic */ void ALLATORIxDEMO(String a2, Message a3) {
        Rc a4;
        a2 = new ReplyMessage(a2, a3);
        a4.ALLATORIxDEMO((ReplyMessage)a2);
    }

    public /* synthetic */ void ALLATORIxDEMO(String a2, String[] a3) {
        Rc a4;
        a3 = Arrays.stream(a3).map(TextMessage::new).collect(Collectors.toList());
        a4.ALLATORIxDEMO(a2, (List<Message>)a3);
    }

    public /* synthetic */ void ALLATORIxDEMO(Set<String> a22, Message a3) {
        try {
            Rc a4;
            a22 = new Multicast(a22, a3);
            a4.ALLATORIxDEMO.multicast(a22).get();
            return;
        }
        catch (InterruptedException | ExecutionException a22) {
            throw new RuntimeException(a22);
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(ReplyMessage a22) {
        try {
            Rc a3;
            a3.ALLATORIxDEMO.replyMessage(a22).get();
            return;
        }
        catch (InterruptedException | ExecutionException a22) {
            throw new RuntimeException(a22);
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(String a2, List<Message> a3) {
        Rc a4;
        a2 = new ReplyMessage(a2, a3);
        a4.ALLATORIxDEMO((ReplyMessage)a2);
    }

    public /* synthetic */ UserProfileResponse ALLATORIxDEMO(String a22) {
        try {
            Rc a3;
            return (UserProfileResponse)a3.ALLATORIxDEMO.getProfile(a22).get();
        }
        catch (InterruptedException | ExecutionException a22) {
            throw new RuntimeException(a22);
        }
    }

    public /* synthetic */ Rc() {
        Rc a2;
    }

    public /* synthetic */ void ALLATORIxDEMO(String a2, String a3) {
        Rc a4;
        a3 = new TextMessage(a3);
        a4.ALLATORIxDEMO(a2, (Message)a3);
    }

    public /* synthetic */ void ALLATORIxDEMO(PushMessage a22) {
        try {
            Rc a3;
            a3.ALLATORIxDEMO.pushMessage(a22).get();
            return;
        }
        catch (InterruptedException | ExecutionException a22) {
            throw new RuntimeException(a22);
        }
    }

    public /* synthetic */ void ALLATORIxDEMO(String a22) {
        try {
            Rc a3;
            a3.ALLATORIxDEMO.leaveGroup(a22).get();
            return;
        }
        catch (InterruptedException | ExecutionException a22) {
            throw new RuntimeException(a22);
        }
    }

    public /* synthetic */ void H(String a22) {
        try {
            Rc a3;
            a3.ALLATORIxDEMO.leaveGroup(a22).get();
            return;
        }
        catch (InterruptedException | ExecutionException a22) {
            throw new RuntimeException(a22);
        }
    }
}

