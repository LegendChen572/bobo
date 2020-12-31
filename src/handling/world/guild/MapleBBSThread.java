/*
 * Decompiled with CFR 0.150.
 */
package handling.world.guild;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapleBBSThread
implements Serializable {
    public /* synthetic */ int ownerID;
    public /* synthetic */ Map<Integer, MapleBBSReply> replies;
    public /* synthetic */ int guildID;
    public /* synthetic */ int localthreadID;
    public static final /* synthetic */ long serialVersionUID = 3565477792085301248L;
    public /* synthetic */ long timestamp;
    public /* synthetic */ String text;
    public /* synthetic */ int icon;
    public /* synthetic */ String name;

    public /* synthetic */ MapleBBSThread(int a2, String a3, String a4, long a5, int a6, int a7, int a8) {
        MapleBBSThread a9;
        MapleBBSThread mapleBBSThread = a9;
        MapleBBSThread mapleBBSThread2 = a9;
        MapleBBSThread mapleBBSThread3 = a9;
        MapleBBSThread mapleBBSThread4 = a9;
        a9.replies = new HashMap<Integer, MapleBBSReply>();
        a9.localthreadID = a2;
        mapleBBSThread3.name = a3;
        mapleBBSThread3.text = a4;
        mapleBBSThread2.timestamp = a5;
        mapleBBSThread2.guildID = a6;
        mapleBBSThread.ownerID = a7;
        mapleBBSThread.icon = a8;
    }

    public final /* synthetic */ boolean isNotice() {
        MapleBBSThread a2;
        return a2.localthreadID == 0;
    }

    public final /* synthetic */ int getReplyCount() {
        MapleBBSThread a2;
        return a2.replies.size();
    }

    public static class ThreadComparator
    implements Comparator<MapleBBSThread>,
    Serializable {
        public /* synthetic */ ThreadComparator() {
            ThreadComparator a2;
        }

        @Override
        public /* synthetic */ int compare(MapleBBSThread a2, MapleBBSThread a3) {
            if (a2.localthreadID < a3.localthreadID) {
                return 1;
            }
            if (a2.localthreadID == a3.localthreadID) {
                return 0;
            }
            return -1;
        }
    }

    public static class MapleBBSReply
    implements Serializable {
        public /* synthetic */ int replyid;
        public /* synthetic */ long timestamp;
        public /* synthetic */ int ownerID;
        public /* synthetic */ String content;

        public /* synthetic */ MapleBBSReply(int a2, int a3, String a4, long a5) {
            MapleBBSReply a6;
            MapleBBSReply mapleBBSReply = a6;
            MapleBBSReply mapleBBSReply2 = a6;
            mapleBBSReply2.ownerID = a3;
            mapleBBSReply2.replyid = a2;
            mapleBBSReply.content = a4;
            mapleBBSReply.timestamp = a5;
        }
    }
}

