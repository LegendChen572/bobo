/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u672a\u77e5\u8c37
 *  client.messages.commands.player.\u738b\u4e4b\u8c37
 */
package constants;

import client.messages.commands.player.\u672a\u77e5\u8c37;
import client.messages.commands.player.\u738b\u4e4b\u8c37;
import constants.GameSetConstants;
import handling.login.LoginServer;
import java.lang.invoke.CallSite;
import java.util.LinkedList;
import java.util.List;
import server.ServerProperties;
import tools.Pair;
import tools.packet.LoginPacket;

public class WorldConstants {
    public static /* synthetic */ boolean GLOBAL_CAN_CREATE;
    public static /* synthetic */ List<Pair<Integer, Boolean>> canCreates;
    public static /* synthetic */ boolean USE_GLOBAL_EVENT_MSG;
    public static /* synthetic */ String WORLD_TIP;
    public static /* synthetic */ boolean AVAILABLE;
    public static /* synthetic */ int USER_LIMIT;
    public static /* synthetic */ List<Pair<Integer, Integer>> dropRates;
    public static /* synthetic */ int CHANNEL_COUNT;
    public static /* synthetic */ int Worlds;
    public static /* synthetic */ int UserLimit;
    public static /* synthetic */ String GLOBAL_EVENT_MSGS;
    public static final /* synthetic */ int gmserver = -1;
    public static /* synthetic */ boolean USE_GLOBAL_CHANNEL_COUNT;
    public static /* synthetic */ byte FLAG;
    public static /* synthetic */ List<Pair<Integer, Integer>> flags;
    public static /* synthetic */ int EXP_RATE;
    public static /* synthetic */ List<Pair<Integer, Integer>> chAmounts;
    public static /* synthetic */ String SCROLL_MESSAGE;
    public static final /* synthetic */ byte recommended = -1;
    public static /* synthetic */ List<Pair<Integer, Integer>> expRates;
    public static /* synthetic */ boolean USE_GLOBAL_FLAG;
    public static /* synthetic */ List<Pair<Integer, String>> eventMessages;
    public static /* synthetic */ boolean GMITEMS;
    public static /* synthetic */ List<Pair<Integer, Integer>> mesoRates;
    public static /* synthetic */ int MESO_RATE;
    public static /* synthetic */ int DROP_RATE;
    public static /* synthetic */ int MAX_CHAR_VIEW;
    public static /* synthetic */ boolean USE_GLOBAL_RATES;

    public /* synthetic */ WorldConstants() {
        WorldConstants a2;
    }

    private static /* synthetic */ void ALLATORIxDEMO(List<Pair<Integer, Integer>> a2, boolean a3, String a4, int a5) {
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u96ea\u5409\u62c9.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4, a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u83c7\u83c7\u5bf6\u8c9d.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "2", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u661f\u5149\u7cbe\u9748.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "3", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u7dde\u5e36\u80a5\u80a5.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "4", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u85cd\u5bf6.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "5", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u7da0\u6c34\u9748.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "6", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u4e09\u773c\u7ae0\u9b5a.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "7", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u6728\u5996.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "8", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u706b\u7368\u773c\u7378.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "9", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u8774\u8776\u7cbe.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "10", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u5df4\u6d1b\u53e4.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "11", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u6d77\u6012\u65af.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "12", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u96fb\u64ca\u8c61.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "13", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u9be8\u9b5a\u865f.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "14", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u76ae\u5361\u557e.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "15", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u795e\u7378.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "16", a5)));
        a2.add(new Pair<Integer, Integer>(LoginPacket.Server.\u6cf0\u52d2\u718a.getId(), a3 ? a5 : ServerProperties.getWorldProperty(a4 + "17", a5)));
    }

    public static /* synthetic */ {
        USER_LIMIT = GameSetConstants.USER_LIMIT;
        MAX_CHAR_VIEW = GameSetConstants.MAX_CHAR_VIEW;
        GMITEMS = GameSetConstants.GMITEMS;
        EXP_RATE = GameSetConstants.EXP_RATE;
        MESO_RATE = GameSetConstants.MESO_RATE;
        DROP_RATE = GameSetConstants.DROP_RATE;
        FLAG = GameSetConstants.FLAG;
        CHANNEL_COUNT = GameSetConstants.CHANNEL_COUNT;
        WORLD_TIP = GameSetConstants.WORLD_TIP;
        SCROLL_MESSAGE = GameSetConstants.SCROLL_MESSAGE;
        AVAILABLE = GameSetConstants.AVAILABLE;
        flags = new LinkedList<Pair<Integer, Integer>>();
        chAmounts = new LinkedList<Pair<Integer, Integer>>();
        expRates = new LinkedList<Pair<Integer, Integer>>();
        mesoRates = new LinkedList<Pair<Integer, Integer>>();
        dropRates = new LinkedList<Pair<Integer, Integer>>();
        eventMessages = new LinkedList<Pair<Integer, String>>();
        canCreates = new LinkedList<Pair<Integer, Boolean>>();
        Worlds = GameSetConstants.WORLD_COUNT;
        UserLimit = GameSetConstants.USER_LIMIT;
        USE_GLOBAL_EVENT_MSG = true;
        GLOBAL_EVENT_MSGS = GameSetConstants.SCROLL_MESSAGE;
        USE_GLOBAL_CHANNEL_COUNT = true;
        USE_GLOBAL_FLAG = true;
        USE_GLOBAL_RATES = true;
        GLOBAL_CAN_CREATE = true;
    }

    public static /* synthetic */ void init() {
        WorldConstants.ALLATORIxDEMO(chAmounts, USE_GLOBAL_CHANNEL_COUNT, \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"rPsCdG/FdAu\\oRr\u001bb]`[oPm\u001bbZt[u"), GameSetConstants.CHANNEL_COUNT);
        WorldConstants.ALLATORIxDEMO(flags, USE_GLOBAL_FLAG, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"mBlQ{U0T{SjNp@m\txK\u007f@m"), GameSetConstants.FLAG);
        WorldConstants.ALLATORIxDEMO(expRates, USE_GLOBAL_RATES, \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"rPsCdG/FdAu\\oRr\u001bdMqg`Ad"), GameSetConstants.EXP_RATE);
        WorldConstants.ALLATORIxDEMO(mesoRates, USE_GLOBAL_RATES, \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"T{UhBl\tmBjSwIyT0J{Tqu\u007fS{"), GameSetConstants.MESO_RATE);
        WorldConstants.ALLATORIxDEMO(dropRates, USE_GLOBAL_RATES, \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"FdGwPs\u001brPuAh[fF/QsZqg`Ad"), GameSetConstants.DROP_RATE);
        String string = GLOBAL_EVENT_MSGS;
        String string2 = \u738b\u4e4b\u8c37.ALLATORIxDEMO((String)"T{UhBl\tmBjSwIyT0BhBpSSBmT\u007f@{");
        eventMessages.add(new Pair<Integer, CallSite>(LoginPacket.Server.\u96ea\u5409\u62c9.getId(), (CallSite)((Object)("\u6b61\u8fce\u4f86\u5230 #b" + LoginServer.getServerName() + "!#k\r\n" + ServerProperties.getWorldProperty(string2, string)))));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u83c7\u83c7\u5bf6\u8c9d.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "2", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u661f\u5149\u7cbe\u9748.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "3", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u7dde\u5e36\u80a5\u80a5.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "4", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u85cd\u5bf6.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "5", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u7da0\u6c34\u9748.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "6", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u4e09\u773c\u7ae0\u9b5a.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "7", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u6728\u5996.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "8", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u706b\u7368\u773c\u7378.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "9", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u8774\u8776\u7cbe.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "10", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u5df4\u6d1b\u53e4.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "11", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u6d77\u6012\u65af.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "12", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u96fb\u64ca\u8c61.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "13", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u9be8\u9b5a\u865f.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "14", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u76ae\u5361\u557e.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "15", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u795e\u7378.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "16", string)));
        eventMessages.add(new Pair<Integer, String>(LoginPacket.Server.\u6cf0\u52d2\u718a.getId(), USE_GLOBAL_EVENT_MSG ? GLOBAL_EVENT_MSGS : ServerProperties.getWorldProperty(string2 + "17", string)));
        string = \u672a\u77e5\u8c37.ALLATORIxDEMO((String)"rPsCdG/FdAu\\oRr\u001bbTovsP`Ad");
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u96ea\u5409\u62c9.getId(), ServerProperties.getWorldProperty(string + "1", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u83c7\u83c7\u5bf6\u8c9d.getId(), ServerProperties.getWorldProperty(string + "2", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u661f\u5149\u7cbe\u9748.getId(), ServerProperties.getWorldProperty(string + "3", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u7dde\u5e36\u80a5\u80a5.getId(), ServerProperties.getWorldProperty(string + "4", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u85cd\u5bf6.getId(), ServerProperties.getWorldProperty(string + "5", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u7da0\u6c34\u9748.getId(), ServerProperties.getWorldProperty(string + "6", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u4e09\u773c\u7ae0\u9b5a.getId(), ServerProperties.getWorldProperty(string + "7", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u6728\u5996.getId(), ServerProperties.getWorldProperty(string + "8", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u706b\u7368\u773c\u7378.getId(), ServerProperties.getWorldProperty(string + "9", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u8774\u8776\u7cbe.getId(), ServerProperties.getWorldProperty(string + "10", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u5df4\u6d1b\u53e4.getId(), ServerProperties.getWorldProperty(string + "11", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u6d77\u6012\u65af.getId(), ServerProperties.getWorldProperty(string + "12", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u96fb\u64ca\u8c61.getId(), ServerProperties.getWorldProperty(string + "13", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u9be8\u9b5a\u865f.getId(), ServerProperties.getWorldProperty(string + "14", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u76ae\u5361\u557e.getId(), ServerProperties.getWorldProperty(string + "15", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u795e\u7378.getId(), ServerProperties.getWorldProperty(string + "16", GLOBAL_CAN_CREATE)));
        canCreates.add(new Pair<Integer, Boolean>(LoginPacket.Server.\u6cf0\u52d2\u718a.getId(), ServerProperties.getWorldProperty(string + "17", GLOBAL_CAN_CREATE)));
    }
}

