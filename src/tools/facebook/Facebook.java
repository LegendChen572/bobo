/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 *  com.restfb.Connection
 *  com.restfb.ConnectionIterator
 *  com.restfb.DefaultFacebookClient
 *  com.restfb.FacebookClient
 *  com.restfb.Parameter
 *  com.restfb.Version
 *  com.restfb.types.Comment
 *  com.restfb.types.Conversation
 *  com.restfb.types.Group
 *  com.restfb.types.MessageTag
 *  com.restfb.types.NamedFacebookType
 *  com.restfb.types.User
 *  com.restfb.types.send.IdMessageRecipient
 *  com.restfb.types.send.SendResponse
 */
package tools.facebook;

import client.messages.commands.player.\u738b\u4e4b\u8c37;
import com.restfb.Connection;
import com.restfb.ConnectionIterator;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.Comment;
import com.restfb.types.Conversation;
import com.restfb.types.Group;
import com.restfb.types.MessageTag;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;
import com.restfb.types.send.IdMessageRecipient;
import com.restfb.types.send.SendResponse;
import java.util.List;
import server.shark.SharkLogger;

public class Facebook {
    public static final /* synthetic */ String a = "EAAGWPKGOHdQBAOj2XaZBDdqS1ZBUPWRXJmSVpEFpP2eYtobBZBqkPOG7ZBDEj2opUfAnnPvXZCsHZAZBAgLWVpQYrAgkXnUPpnmiDvFnQQNNi6iZADdH7qvANIu4JnxO8x6HFaXo4HfiZBW85E0bkYwZAZAPiDG1XsaJN8hAr1giBMVr8KN8DnHUyNeUkkUWx3LBuJMALdZB1mtKjHh2PByd8d7cgA8btZCZAzIkc6AdnuqZB0HjAZDZD";
    public static final /* synthetic */ String ALLATORIxDEMO = "2613201495422724";
    public static final /* synthetic */ FacebookClient d;

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0014\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=-=\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0004\u0014\u0004>\u0007>\u0007>\u0007>\u0007=\u0004>\u0004>\u0007>\u0004>\u0007>\u0007=\u0004>\u0004=\u0004>\u0004=\u0004>\u0004=\u0007>\u0004=\u0004>\u0007>\u0007>\u0007>\u0007=-=\u0007>\u0007>\u0007>\u0007=\u0007=\u0007=\u0007>\u0007=\u0007>\u0007=\u0007=\u0007>\u0004>\u0007=\u0007=\u0007=\u0007=\u0007>\u0004>\u0007>\u0007>\u0007>\u0007>\u0004\u0014\u0004>\u0007>\u0007>\u0007>\u0004=\u0004>\u0004>\u0007>\u0004>\u0007>\u0004=\u0004>\u0007=\u0007>\u0004>\u0004>\u0004=\u0007>\u0007=\u0007>\u0007>\u0007>\u0007>\u0007=-=\u0007>\u0007>\u0007>\u0007=\u0007=\u0007=\u0004=\u0007=\u0004=\u0007=\u0007=\u0007>\u0004>\u0007=\u0004=\u0007=\u0007=\u0007=\u0004=\u0007>\u0007>\u0007>\u0007>\u0004\u0014\u0004>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007=-=\u0007QExRmD\u007fSwHp\u0007|^>frK\u007fSqUw\u0007QExRmD\u007fSqU>Q)\t-\u0007ZbSh>\u0004\u0014\u0004>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007=-=\u0007>\u0007>\u0007>\u0007>\u0007>\u0007vSjW$\b1PiP0FrK\u007fSqUw\t}Hs\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0004\u0014\u0004>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007>\u0007=-=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004=\u0004\u0014"));
        System.out.println(Facebook.getSharePageComments(SharkLogger.ALLATORIxDEMO("\u5e58")));
    }

    public /* synthetic */ Facebook() {
        Facebook a2;
    }

    public static /* synthetic */ String getSharePageComments(String a2) {
        Object object = \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"/\u0016,\u0013.\u0011&\u001e.\u0015+\u0017*\u0014'");
        Object object2 = SharkLogger.ALLATORIxDEMO("\u0010\u001d\u0013\u0018\u0015\u0015\u0016\u0019\u0011\u001e\u0015\u001a\u0010\u0019\u0012");
        object = (String)object + "_" + (String)object2;
        Parameter[] arrparameter = new Parameter[1];
        arrparameter[0] = Parameter.with((String)SharkLogger.ALLATORIxDEMO("JHIMHR"), (Object)\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"{J\u007fNr\u000bxNlTjxpFsB2K\u007fTjxpFsB2@{IzBl"));
        object2 = (User)d.fetchObject(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"J{"), User.class, arrparameter);
        Connection connection = d.fetchConnection(SharkLogger.ALLATORIxDEMO("AD\u0003G^HIOHR"), User.class, new Parameter[0]);
        Connection connection2 = d.fetchConnection(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"sB1@lHkWm"), Group.class, new Parameter[0]);
        System.out.println(object2.getLastName() + connection.getData().size());
        Parameter[] arrparameter2 = new Parameter[1];
        arrparameter2[0] = Parameter.with((String)SharkLogger.ALLATORIxDEMO("JHIMHR"), (Object)\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"Nz\u000b>W{UsFrNpLARlK2\u0007xUqJ2\u0007}U{FjBzxjNsB2\u0007sBmT\u007f@{\u000b>J{TmFyBAS\u007f@m\u000b>FjS\u007fDvJ{Ij\u000b>KwL{x}HkIj"));
        object = d.fetchConnection((String)object + "/comments", Comment.class, arrparameter2);
        object2 = "#b\u300a\u7559\u8a00\u7be9\u9078\u300b#k #d\u767b\u5165FB\u540d\u5b57 :#k #r" + a2 + "#k\r\n";
        int n2 = 0;
        object = object.iterator();
        while (object.hasNext()) {
            for (Object object3 : (List)object.next()) {
                int n3 = 0;
                object2 = (String)object2 + "---------------------------------------\r\n";
                object2 = (String)object2 + "#d\u7559\u8a00\u8005\u540d\u5b57#k : " + object3.getFrom().getName() + "\r\n";
                object2 = (String)object2 + "#d\u7559\u8a00\u6642\u9593#k : " + object3.getCreatedTime() + "\r\n";
                object2 = (String)object2 + "#d\u7559\u8a00\u5167\u5bb9#k : " + object3.getMessage() + "\r\n";
                object2 = (String)object2 + "#d\u6a19\u8a18\u72c0\u614b#k : " + (object3.getMessageTags() == null ? 0 : object3.getMessageTags().size()) + " \u4ef6\r\n";
                if ((object3 = object3.getMessageTags()) != null && !object3.isEmpty()) {
                    object2 = (String)object2 + "#d\u6a19\u8a18\u4eba #k: [";
                    object3 = object3.iterator();
                    while (object3.hasNext()) {
                        MessageTag messageTag = (MessageTag)object3.next();
                        if (!SharkLogger.ALLATORIxDEMO("YRIS").equals(messageTag.getType())) continue;
                        ++n3;
                        object2 = (String)object2 + messageTag.getName() + "/";
                    }
                    object2 = (String)object2 + "]\r\n";
                }
                object2 = (String)object2 + "#b\u7559\u8a00\u5be9\u67e5#k :#r" + (n3 >= 3 ? \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0007\u7b38\u542f\u9806\u53f1\u6a07\u6eb1>") : SharkLogger.ALLATORIxDEMO("\u0001\u4e21\u7b07\u5424\u9839\u53fa\u6a38\u6eba\u0001")) + "#k\r\n";
                if (n3 < 3) continue;
                ++n2;
            }
        }
        if (n2 > 0) {
            return (String)object2 + "---------------------------------------\r\n#d#L0# \u9818\u53d6\u5206\u4eab\u91d1\u9470#k";
        }
        return (String)object2 + "\r\n#d\u7559\u8a00\u7686\u4e0d\u7b26\u5408\u9818\u53d6\u6a19\u6e96#k";
    }

    public static /* synthetic */ String getConversation(String a2) {
        String string = \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"=U\u82fb\u5dd5\u6ee1\u8d94\u6883\u4ed1\uff12\u8aec\u5156\u79e6\u8a14\u7cae\u7d6c\u573f\u5f92\u9ef9\u9066\u0004u");
        IdMessageRecipient idMessageRecipient = new IdMessageRecipient(SharkLogger.ALLATORIxDEMO("ZYRISsHH\\"));
        Parameter[] arrparameter = new Parameter[1];
        arrparameter[0] = Parameter.with((String)SharkLogger.ALLATORIxDEMO("JHIMHR"), (Object)\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"Nz\u000bsBmT\u007f@{T2W\u007fUjN}NnFpSm"));
        ConnectionIterator connectionIterator = d.fetchConnection(\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"-\u0017/\u0014.\u001e+\u0015*\u0016,\u0012.\u0012/\b}HpQ{UmFjNqIm"), Conversation.class, arrparameter).iterator();
        while (connectionIterator.hasNext()) {
            for (Conversation conversation : (List)connectionIterator.next()) {
                boolean bl = false;
                Conversation conversation2 = conversation;
                String string2 = conversation2.getId();
                for (NamedFacebookType namedFacebookType : conversation2.getParticipants()) {
                    if (!a2.equals(namedFacebookType.getName())) continue;
                    bl = true;
                    string2 = conversation.getId();
                }
                if (!bl) continue;
                Parameter[] arrparameter2 = new Parameter[2];
                arrparameter2[0] = Parameter.with((String)SharkLogger.ALLATORIxDEMO("SIBEQEDBU"), (Object)idMessageRecipient);
                arrparameter2[1] = Parameter.with((String)\u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"sBmT\u007f@{"), (Object)("[\u5206\u4eab\u734e\u52f5] \u91d1\u9470 :" + Facebook.getRandomPassword() + "\r\n\u8acb\u8f38\u5165\u65bc\u5206\u62cd\u8ce3-\u5206\u4eab\u734e\u52f5"));
                SendResponse sendResponse = (SendResponse)d.publish(string2 + "/messages", SendResponse.class, arrparameter2);
                string = SharkLogger.ALLATORIxDEMO("\u000fS\u91fd\u9451\u5dde\u9020\u9078\r\u8ae7\u81d2jc\u79ed\u8a2b\u67c9\u772a\u000fJ");
            }
        }
        return string;
    }

    public static /* synthetic */ {
        d = new DefaultFacebookClient(a, Version.LATEST);
    }

    public static /* synthetic */ String getRandomPassword() {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = n2 = 0;
        while (n3 < 12) {
            int n4 = (int)(Math.random() * 7.0 % 3.0);
            if (n4 == 1) {
                stringBuilder.append((int)(Math.random() * 10.0 + 48.0));
            } else if (n4 == 2) {
                stringBuilder.append((char)(Math.random() * 26.0 + 65.0));
            } else {
                stringBuilder.append((char)(Math.random() * 26.0 + 97.0));
            }
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }
}

