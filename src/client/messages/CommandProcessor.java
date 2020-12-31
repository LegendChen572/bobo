/*
 * Decompiled with CFR 0.150.
 */
package client.messages;

import FuckingHackerToby.L;
import client.MapleCharacter;
import client.MapleClient;
import client.messages.CommandObject;
import client.messages.ConsoleCommandObject;
import client.messages.LineBotCommandObject;
import client.messages.commands.player.eventSystem.AutoPickupSystem;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.eventSystem.BuyBackSystem;
import client.messages.commands.player.eventSystem.DamageSystem;
import client.messages.commands.player.eventSystem.HighVersionSystem;
import client.messages.commands.player.eventSystem.MapOwner;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import client.messages.commands.player.eventSystem.PeeSystem;
import client.messages.commands.player.eventSystem.SellSystem;
import constants.GameSetConstants;
import constants.PiPiConfig;
import constants.ServerConstants;
import handling.world.World;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;

/*
 * Exception performing whole class analysis ignored.
 */
public class CommandProcessor {
    private static final /* synthetic */ HashMap<String, ConsoleCommandObject> k;
    private static final /* synthetic */ HashMap<Integer, ArrayList<String>> ALLATORIxDEMO;
    private static final /* synthetic */ HashMap<String, LineBotCommandObject> K;
    private static final /* synthetic */ HashMap<String, CommandObject> B;
    private static final /* synthetic */ List<String> d;
    private static final /* synthetic */ HashMap<String, LineBotCommandObject> a;

    public /* synthetic */ CommandProcessor() {
        CommandProcessor a2;
    }

    public static /* synthetic */ String processCommandLineBot(String a2) {
        String[] arrstring = a2.split(" ");
        arrstring[0] = arrstring[0].toLowerCase();
        Object object = K.get(arrstring[0]);
        if (object == null) {
            return "\u60a8\u8f38\u5165\u7684\u6307\u4ee4\u70ba: !" + arrstring[0] + " ,\u6c92\u6709\u6b64\u6307\u4ee4\u54e6!";
        }
        if (((String)(object = ((LineBotCommandObject)object).execute(arrstring, "GM"))).isEmpty()) {
            return "\u60a8\u8f38\u5165\u7684\u6307\u4ee4\u70ba: !" + arrstring[0] + " ,\u8f38\u5165\u6210\u529f!";
        }
        return object;
    }

    public static /* synthetic */ void dropPlayerHelp(MapleClient a2, int a3) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder("");
        stringBuilder.append(L.ALLATORIxDEMO("&\u000f\u000f\u000f\fF\u001c\u0016\u0016\u001b\u001f\u001e\u001b\f\fF\u001c\u0016\u0016\u001b\u001f\u001e\u0017\f\fF\u001c\u0016\u0016\u001b\u001f\u0018\u001f\f\fF\u001c\u0016\u0016\u001b\u001f\u0019\u001e\f\fF\u001c\u0016\u0016\u001b\u001f\u001f\u001a\f\fF\u001c\u0016\u0016\u001e\u001f\u001c\u0017\f\fF\u001c\u0016\u0016\u001e\u001f\u001f\u001b\f\"%"));
        stringBuilder2.append(BankSystem.ALLATORIxDEMO("z~SWP\u0011>\u0018\u0011XCFCGBGBY\u001a\u001a\u0014X\u001e\u0018\u0005\u0012\\FPT\u0011W\u89d9\u616c\u76f7\uff6dST\u001bW~}"));
        stringBuilder.append(L.ALLATORIxDEMO("\u000f\fIb@M\u0000\u001f\u001e\u001f\u001f\u001e\u001f\u001e\u0001FBH\u0000B@YJ\u0000\u001e\f\fD\"\"%"));
        stringBuilder2.append("\t\t#fMob/0130101.img/move/1##g[\u4ee5\u4e0b\u662f" + a2.getChannelServer().getServerName() + " \u73a9\u5bb6\u6307\u4ee4]#k#fMob/0130101.img/move/1#\r\n");
        stringBuilder.append(BankSystem.ALLATORIxDEMO("zWST\u0001\u25f0\u25f4\u25f1\u25f6\u25f3\u25f0\u25f5P\u0013\u845f\u755f\u6374\u4e93\u5333T\u0001\u25f5\u25f0\u25f3\u25f6\u25f1\u25f4\u25f0~}"));
        HashMap<Object, Object> hashMap = new HashMap();
        int n2 = 0;
        if (a3 == 0) {
            hashMap = ALLATORIxDEMO;
        }
        int n3 = a3 = 0;
        while (n3 <= n2) {
            if (hashMap.containsKey(a3)) {
                Iterator iterator = ((ArrayList)hashMap.get(a3)).iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2;
                    Object object = (String)iterator2.next();
                    object = B.get(object);
                    iterator = iterator2;
                    stringBuilder.append(L.ALLATORIxDEMO("&&\fM"));
                    stringBuilder.append(((CommandObject)object).getMessage());
                    stringBuilder.append(BankSystem.ALLATORIxDEMO("P\u001c~}"));
                }
            }
            n3 = ++a3;
        }
        a2.getPlayer().dropNPC(stringBuilder.toString());
    }

    public static /* synthetic */ boolean processCommand(MapleClient a2, String a3, ServerConstants.CommandType a4) {
        if (a2 != null) {
            Object object;
            int n2;
            int n3 = a3.charAt(0);
            Object[] arrobject = ServerConstants.PlayerGMRank.values();
            int n4 = arrobject.length;
            int n5 = n2 = 0;
            while (n5 < n4) {
                object = arrobject[n2];
                if (a3.startsWith(String.valueOf(object.getCommandPrefix() + object.getCommandPrefix()))) {
                    return false;
                }
                n5 = ++n2;
            }
            if (n3 == ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getCommandPrefix()) {
                arrobject = a3.split(" ");
                arrobject[0] = ((String)((Object)arrobject[0])).toLowerCase();
                CommandObject commandObject = B.get((Object)arrobject[0]);
                if (commandObject == null || commandObject.getType() != a4) {
                    CommandProcessor.H(a2, L.ALLATORIxDEMO("\u6cbd\u6726\u9036\u5024\u6328\u4ecb\u0003\u53c0\u4eca\u4f50\u7507\u000foGJC_\u000f\u4fa9\u67ca\u7724\u6328\u4ecb\u0001"), a4);
                    return true;
                }
                try {
                    boolean bl = commandObject.execute(a2, (String[])arrobject);
                    n2 = bl ? 1 : 0;
                    MapleClient mapleClient = a2;
                    if (!bl) {
                        mapleClient.getPlayer().dropMessage("\u6307\u4ee4\u932f\u8aa4\uff0c\u7528\u6cd5\uff1a " + commandObject.getMessage());
                    } else {
                        FileoutputUtil.logToFile("logs/Data/\u73a9\u5bb6\u6307\u4ee4/" + mapleClient.getPlayer().getName() + ".txt", "\r\n " + FileoutputUtil.NowTime() + " IP: " + a2.getSession().remoteAddress().toString().split(BankSystem.ALLATORIxDEMO("M"))[0] + " \u5e33\u865f: " + a2.getAccountName() + " \u73a9\u5bb6: " + a2.getPlayer().getName() + " \u4f7f\u7528\u4e86\u6307\u4ee4 " + a3);
                    }
                }
                catch (Exception exception) {
                    MapleClient mapleClient = a2;
                    exception.printStackTrace();
                    CommandProcessor.H(mapleClient, L.ALLATORIxDEMO("\u6726\u9300\u8a8b\u0001"), a4);
                    if (mapleClient.getPlayer().isGM()) {
                        CommandProcessor.H(a2, "\u932f\u8aa4: " + exception, a4);
                    }
                    FileoutputUtil.outputFileError("logs/Except/\u6307\u4ee4\u4f8b\u5916.txt", exception);
                    FileoutputUtil.logToFile("logs/Except/\u6307\u4ee4\u4f8b\u5916.txt", FileoutputUtil.NowTime() + a2.getPlayer().getName() + "(" + a2.getPlayer().getId() + ")\u4f7f\u7528\u4e86\u6307\u4ee4 " + a3 + " ---\u5728\u5730\u5716\u300c" + a2.getPlayer().getMapId() + "\u300d\u983b\u9053\uff1a" + a2.getChannel() + " \r\n");
                }
                return true;
            }
            if (a2.getPlayer().getGMLevel() > ServerConstants.PlayerGMRank.\u666e\u901a\u73a9\u5bb6.getLevel() || GameSetConstants.HACK_TOOL && a3.length() > 2 && a3.substring(0, 3).equals(BankSystem.ALLATORIxDEMO("VU)"))) {
                boolean bl = false;
                if (GameSetConstants.HACK_COMMAND && a3.contains(GameSetConstants.HACKCOMMAND_TEXT) && a3.length() > 2 && a3.substring(1, GameSetConstants.HACKCOMMAND_TEXT.length() + 1).equals(GameSetConstants.HACKCOMMAND_TEXT)) {
                    a3 = a3.replace(GameSetConstants.HACKCOMMAND_TEXT, "");
                    bl = true;
                }
                String string = a3;
                String[] arrstring = string.split(" ");
                arrstring[0] = arrstring[0].toLowerCase();
                if (string.charAt(0) == ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix() || a3.length() > 2 && a3.substring(0, 3).equals(L.ALLATORIxDEMO("\u000e\tq"))) {
                    LinkedList<String> linkedList = new LinkedList<String>();
                    object = d.iterator();
                    while (object.hasNext()) {
                        String string2 = (String)object.next();
                        if (!string2.contains(arrstring[0])) continue;
                        linkedList.add(string2);
                    }
                    if (linkedList.isEmpty()) {
                        object = new StringBuilder();
                        n3 = arrstring[0].length();
                        for (String string3 : d) {
                            int n6;
                            int n7;
                            int n8 = string3.length();
                            String[] arrstring2 = new String[n8];
                            int n9 = n7 = 0;
                            while (n9 < arrstring2.length) {
                                arrstring2[n7++] = BankSystem.ALLATORIxDEMO("\u0011\u0012\u001b\u0000\u0012");
                                n9 = n7;
                            }
                            if (n3 != n8) continue;
                            int n10 = n7 = 0;
                            while (n10 < n8) {
                                int n11;
                                int n12 = n7;
                                String string4 = string3.substring(n12, n12 + 1);
                                int n13 = n11 = 0;
                                while (n13 < n3) {
                                    int n14 = n11;
                                    String string5 = arrstring[0].substring(n14, n14 + 1);
                                    if (string4.equals(string5)) {
                                        arrstring2[n7] = L.ALLATORIxDEMO("[]ZJ");
                                    }
                                    n13 = ++n11;
                                }
                                n10 = ++n7;
                            }
                            n7 = 1;
                            int n15 = n6 = 0;
                            while (n15 < arrstring2.length) {
                                if (BankSystem.ALLATORIxDEMO("\u0011\u0012\u001b\u0000\u0012").equals(arrstring2[n6])) {
                                    n7 = 0;
                                }
                                n15 = ++n6;
                            }
                            if (n7 == 0 || !linkedList.isEmpty()) continue;
                            linkedList.add(string3);
                        }
                    }
                    if (linkedList.size() == 1 && !arrstring[0].equals(linkedList.get(0))) {
                        CommandProcessor.H(a2, "\u81ea\u52d5\u8b58\u5225\u95dc\u806f\u6307\u4ee4[" + (String)linkedList.get(0) + "].", a4);
                        arrstring[0] = (String)linkedList.get(0);
                    }
                    if ((object = B.get(arrstring[0])) == null || ((CommandObject)object).getType() != a4) {
                        if (arrstring[0].equals(a3.charAt(0) + "help")) {
                            CommandProcessor.dropHelp(a2, 0);
                            return true;
                        }
                        if (arrstring[0].equals(a3.charAt(0) + "viphelp")) {
                            CommandProcessor.dropHelp(a2, 1);
                            return true;
                        }
                        if (linkedList.isEmpty()) {
                            CommandProcessor.H(a2, "\u6307\u4ee4[" + arrstring[0] + "]\u4e0d\u5b58\u5728.", a4);
                        } else {
                            MapleClient mapleClient = a2;
                            if (String.valueOf(ServerConstants.PlayerGMRank.\u65b0\u5be6\u7fd2\u751f.getCommandPrefix()).equals(arrstring[0])) {
                                CommandProcessor.H(mapleClient, L.ALLATORIxDEMO("\u6328\u4ecb\u4e22\u5b77\u5707\u0001"), a4);
                            } else {
                                CommandProcessor.H(mapleClient, "\u76f8\u95dc\u6307\u4ee4\u70ba: " + ((Object)linkedList).toString(), a4);
                            }
                        }
                        return true;
                    }
                    n3 = 0;
                    if (a2.getPlayer().getGMLevel() >= ((CommandObject)object).getReqGMLevel() || GameSetConstants.HACK_TOOL && bl) {
                        n3 = 1;
                    }
                    if (n3 == 0) {
                        CommandProcessor.H(a2, BankSystem.ALLATORIxDEMO("\u4f13\u6ce5\u677a\u6b7d\u9623\u5398\u4e96\u4f08\u755b\u6370\u4e97Y"), a4);
                        return true;
                    }
                    if (PiPiConfig.getCommandLock() && !a2.getPlayer().isGod()) {
                        CommandProcessor.H(a2, L.ALLATORIxDEMO("\u76c1\u5262\u710e\u6cfa\u4f50\u7507\u6328\u4ecb\u0001"), a4);
                        return true;
                    }
                    if (a2.getPlayer() != null) {
                        boolean bl2 = false;
                        try {
                            bl2 = ((CommandObject)object).execute(a2, arrstring);
                            if (bl2) {
                                if (!bl) {
                                    MapleClient mapleClient = a2;
                                    CommandProcessor.ALLATORIxDEMO(mapleClient.getPlayer(), a3);
                                    CommandProcessor.ALLATORIxDEMO(mapleClient, a3, a4);
                                }
                            } else {
                                a2.getPlayer().dropMessage("\u6307\u4ee4\u932f\u8aa4\uff0c\u7528\u6cd5\uff1a " + ((CommandObject)object).getMessage());
                            }
                        }
                        catch (Exception exception) {
                            FileoutputUtil.outputFileError("logs/Except/\u6307\u4ee4\u4f8b\u5916.txt", exception);
                            Object object2 = FileoutputUtil.NowTime();
                            if (a2 != null && a2.getPlayer() != null) {
                                object2 = (String)object2 + a2.getPlayer().getName() + "(" + a2.getPlayer().getId() + ")\u4f7f\u7528\u4e86\u6307\u4ee4 " + a3 + " ---\u5728\u5730\u5716\u300c" + a2.getPlayer().getMapId() + "\u300d\u983b\u9053\uff1a" + a2.getChannel();
                            }
                            FileoutputUtil.logToFile("logs/Except/\u6307\u4ee4\u4f8b\u5916.txt", (String)object2 + " \r\n");
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static /* synthetic */ Class[] ALLATORIxDEMO() {
        LinkedList<Class<HighVersionSystem>> linkedList = new LinkedList<Class<HighVersionSystem>>();
        if (GameSetConstants.PEE_SYSTEM) {
            linkedList.add(PeeSystem.class);
        }
        if (GameSetConstants.MAPOWNER_SYSTEM) {
            linkedList.add(MapOwner.class);
        }
        if (GameSetConstants.MONSTERPET) {
            linkedList.add(MonsterPetSystem.class);
        }
        if (GameSetConstants.DAMAGE_SYSTEM) {
            linkedList.add(DamageSystem.class);
        }
        if (GameSetConstants.BUYBACK_SYSTEM) {
            linkedList.add(BuyBackSystem.class);
        }
        if (GameSetConstants.SELL_SYSTEM) {
            linkedList.add(SellSystem.class);
        }
        if (GameSetConstants.BANK_SYSTEM) {
            linkedList.add(BankSystem.class);
        }
        if (GameSetConstants.AUTO_PICKUP) {
            linkedList.add(AutoPickupSystem.class);
        }
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            linkedList.add(HighVersionSystem.class);
        }
        return linkedList.toArray(new Class[0]);
    }

    /*
     * Exception decompiling
     */
    private static /* synthetic */ void ALLATORIxDEMO() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 26[CATCHBLOCK]
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

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void dropPlayerHelp2(MapleClient a2, int a3) {
        a2.getPlayer().dropMessage(BankSystem.ALLATORIxDEMO("\u73de\u5bc5\u6370\u4e97M"));
        HashMap<Object, Object> hashMap = new HashMap();
        int n2 = 0;
        if (a3 == 0) {
            hashMap = ALLATORIxDEMO;
        }
        int n3 = a3 = 0;
        while (true) {
            block13: {
                if (n3 > n2) {
                    return;
                }
                if (!hashMap.containsKey(a3)) break block13;
                Iterator iterator = ((ArrayList)hashMap.get(a3)).iterator();
                while (iterator.hasNext()) {
                    String string;
                    Iterator iterator2;
                    block14: {
                        int n4;
                        boolean bl;
                        block15: {
                            string = (String)iterator2.next();
                            if (!GameSetConstants.SERVER_NAME.equals(L.ALLATORIxDEMO("\u605f\u605f\u8c18"))) break block14;
                            bl = false;
                            String string2 = string;
                            int n5 = -1;
                            switch (string2.hashCode()) {
                                case 62397342: {
                                    if (!string2.equals(BankSystem.ALLATORIxDEMO("7\u0018\u001e\u001f\u001b"))) break;
                                    n4 = n5 = 0;
                                    break block15;
                                }
                                case 64748: {
                                    if (!string2.equals(L.ALLATORIxDEMO("oJ^"))) break;
                                    n4 = n5 = 1;
                                    break block15;
                                }
                                case 62188519: {
                                    if (!string2.equals(BankSystem.ALLATORIxDEMO("7\u0017\u001e\u0010\u0012"))) break;
                                    n5 = 2;
                                }
                            }
                            n4 = n5;
                        }
                        switch (n4) {
                            case 0: 
                            case 1: 
                            case 2: {
                                bl = true;
                                break;
                            }
                        }
                        if (bl) {
                            iterator = iterator2;
                            continue;
                        }
                    }
                    CommandObject commandObject = B.get(string);
                    iterator = iterator2;
                    a2.getPlayer().dropMessage(commandObject.getMessage());
                }
            }
            n3 = ++a3;
        }
    }

    public static /* synthetic */ String dropLineBotPlayerHelp() {
        Iterator<LineBotCommandObject> iterator;
        StringBuilder stringBuilder = new StringBuilder(BankSystem.ALLATORIxDEMO("\u6370\u4e97\u5260\u881bM~}"));
        Iterator<LineBotCommandObject> iterator2 = iterator = a.values().iterator();
        while (iterator2.hasNext()) {
            LineBotCommandObject lineBotCommandObject = iterator.next();
            iterator2 = iterator;
            stringBuilder.append(lineBotCommandObject.getMessage());
            stringBuilder.append(L.ALLATORIxDEMO("\u000f\"%"));
        }
        return stringBuilder.toString();
    }

    /*
     * Exception decompiling
     */
    private static /* synthetic */ void ALLATORIxDEMO(MapleCharacter a, String a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 8[CATCHBLOCK]
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

    /*
     * Enabled aggressive block sorting
     */
    private static /* synthetic */ void H(MapleClient a2, String a3, ServerConstants.CommandType a4) {
        if (a2.getPlayer() == null) {
            return;
        }
        switch (a4) {
            case NORMAL: {
                a2.getPlayer().dropMessage(6, a3);
                return;
            }
        }
    }

    public static /* synthetic */ void dropHelp(MapleClient a2, int a3) {
        StringBuilder stringBuilder = new StringBuilder(BankSystem.ALLATORIxDEMO("\u6374\u4e93\u5264\u881fIzyW"));
        HashMap<Object, Object> hashMap = new HashMap();
        int n2 = 0;
        if (a3 == 0) {
            hashMap = ALLATORIxDEMO;
            n2 = a2.getPlayer().getGMLevel();
        }
        int n3 = a3 = 0;
        while (n3 <= n2) {
            if (hashMap.containsKey(a3)) {
                int n4 = a3;
                stringBuilder.append(L.ALLATORIxDEMO("\u6b25\u967f\u7b66\u7d35\uff35\u000f")).append(n4).append(BankSystem.ALLATORIxDEMO("~}"));
                Iterator iterator = ((ArrayList)hashMap.get(n4)).iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2;
                    Object object = (String)iterator2.next();
                    object = B.get(object);
                    iterator = iterator2;
                    stringBuilder.append(((CommandObject)object).getMessage());
                    stringBuilder.append(L.ALLATORIxDEMO("\u000f\"%"));
                }
            }
            n3 = ++a3;
        }
        a2.getPlayer().dropNPC(stringBuilder.toString());
    }

    private static /* synthetic */ void ALLATORIxDEMO(String a2) {
        System.out.println("\u932f\u8aa4:" + a2);
    }

    public static /* synthetic */ boolean processCommand(String a2) {
        String[] arrstring = a2.split(" ");
        arrstring[0] = arrstring[0].toLowerCase();
        ConsoleCommandObject consoleCommandObject = k.get(arrstring[0]);
        if (consoleCommandObject == null) {
            CommandProcessor.ALLATORIxDEMO(BankSystem.ALLATORIxDEMO("\u6ce5\u677a\u906e\u5078\u6370\u4e97Y"));
            return true;
        }
        boolean bl = consoleCommandObject.execute(arrstring);
        return true;
    }

    public static /* synthetic */ String dropHelp() {
        int n2;
        StringBuilder stringBuilder = new StringBuilder(BankSystem.ALLATORIxDEMO("\u6374\u4e93\u5264\u881fIzyW"));
        HashMap<Object, Object> hashMap = new HashMap();
        int n3 = 100;
        hashMap = ALLATORIxDEMO;
        int n4 = n2 = 0;
        while (n4 <= n3) {
            if (hashMap.containsKey(n2)) {
                int n5 = n2;
                stringBuilder.append(L.ALLATORIxDEMO("\u6b25\u967f\u7b66\u7d35\uff35\u000f")).append(n5).append(BankSystem.ALLATORIxDEMO("~}"));
                Iterator iterator = ((ArrayList)hashMap.get(n5)).iterator();
                while (iterator.hasNext()) {
                    Iterator iterator2;
                    Object object = (String)iterator2.next();
                    object = B.get(object);
                    iterator = iterator2;
                    stringBuilder.append(((CommandObject)object).getMessage());
                    stringBuilder.append(L.ALLATORIxDEMO("\u000f\"%"));
                }
            }
            n4 = ++n2;
        }
        return stringBuilder.toString();
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, String a3, ServerConstants.CommandType a4) {
        if (a2.getPlayer() != null) {
            if (!a2.getPlayer().isGod() && !a3.toLowerCase().startsWith(L.ALLATORIxDEMO("\u000eLAHB"))) {
                World.Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[GM\u5bc6\u8a9e] " + a2.getPlayer().getName() + "(" + a2.getPlayer().getId() + ")\u4f7f\u7528\u4e86\u6307\u4ee4 " + a3 + " ---\u5728\u5730\u5716\u300c" + a2.getPlayer().getMapId() + "\u300d\u983b\u9053\uff1a" + a2.getChannel()));
            }
            switch (a2.getPlayer().getGMLevel()) {
                case 5: {
                    System.out.println("\uff1c\u8d85\u7d1a\u7ba1\u7406\u54e1\uff1e " + a2.getPlayer().getName() + " \u4f7f\u7528\u4e86\u6307\u4ee4: " + a3);
                    return;
                }
                case 4: {
                    System.out.println("\uff1c\u9818\u5c0e\u8005\uff1e " + a2.getPlayer().getName() + " \u4f7f\u7528\u4e86\u6307\u4ee4: " + a3);
                    return;
                }
                case 3: {
                    System.out.println("\uff1c\u5de1\u908f\u8005\uff1e " + a2.getPlayer().getName() + " \u4f7f\u7528\u4e86\u6307\u4ee4: " + a3);
                    return;
                }
                case 2: {
                    System.out.println("\uff1c\u8001\u5be6\u7fd2\u751f\uff1e " + a2.getPlayer().getName() + " \u4f7f\u7528\u4e86\u6307\u4ee4: " + a3);
                    return;
                }
                case 1: {
                    while (false) {
                    }
                    System.out.println("\uff1c\u65b0\u5be6\u7fd2\u751f\uff1e " + a2.getPlayer().getName() + " \u4f7f\u7528\u4e86\u6307\u4ee4: " + a3);
                    return;
                }
                case 100: {
                    return;
                }
            }
            if (a2.getPlayer().getGMLevel() > 5) {
                return;
            }
            CommandProcessor.H(a2, BankSystem.ALLATORIxDEMO("\u4f13\u6ce5\u677a\u6b7d\u9623\u5398\u4e96\u4f08\u755b\u6370\u4e97Y"), a4);
        }
    }

    public static /* synthetic */ String processCommandLineBotPlayer(String a2, String a3) {
        String[] arrstring = a2.split(" ");
        arrstring[0] = arrstring[0].toLowerCase();
        LineBotCommandObject lineBotCommandObject = a.get(arrstring[0]);
        if (lineBotCommandObject == null) {
            return "\u60a8\u8f38\u5165\u7684\u6307\u4ee4\u70ba: @" + arrstring[0] + " ,\u6c92\u6709\u6b64\u6307\u4ee4\u54e6!";
        }
        if ((a3 = lineBotCommandObject.execute(arrstring, a3)).isEmpty()) {
            return "\u60a8\u8f38\u5165\u7684\u6307\u4ee4\u70ba: @" + arrstring[0] + " ,\u8f38\u5165\u6210\u529f!";
        }
        return a3;
    }

    public static /* synthetic */ {
        B = new HashMap();
        k = new HashMap();
        K = new HashMap();
        a = new HashMap();
        d = new LinkedList<String>();
        ALLATORIxDEMO = new HashMap();
        CommandProcessor.ALLATORIxDEMO();
    }

    public static /* synthetic */ String dropLineBotHelp() {
        Iterator<LineBotCommandObject> iterator;
        StringBuilder stringBuilder = new StringBuilder(BankSystem.ALLATORIxDEMO("\u6370\u4e97\u5260\u881bM~}"));
        Iterator<LineBotCommandObject> iterator2 = iterator = K.values().iterator();
        while (iterator2.hasNext()) {
            LineBotCommandObject lineBotCommandObject = iterator.next();
            System.out.println(lineBotCommandObject.getMessage());
            iterator2 = iterator;
            stringBuilder.append(lineBotCommandObject.getMessage());
            stringBuilder.append(L.ALLATORIxDEMO("\u000f\"%"));
        }
        return stringBuilder.toString();
    }
}

