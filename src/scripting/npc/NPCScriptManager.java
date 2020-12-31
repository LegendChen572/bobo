/*
 * Decompiled with CFR 0.150.
 */
package scripting.npc;

import client.MapleCharacter;
import client.MapleClient;
import constants.GameSetConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import scripting.AbstractScriptManager;
import scripting.ScriptType;
import scripting.npc.NPCConversationManager;
import server.life.MapleLifeFactory;
import server.life.MapleNPC;
import server.life.MobSkill;
import server.quest.MapleQuest;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.wztosql.DumpMobName;

public class NPCScriptManager
extends AbstractScriptManager {
    private final /* synthetic */ Map<MapleClient, NPCConversationManager> d;
    private static final /* synthetic */ NPCScriptManager ALLATORIxDEMO;

    public /* synthetic */ NPCScriptManager() {
        NPCScriptManager a2;
        NPCScriptManager nPCScriptManager = a2;
        nPCScriptManager.d = new WeakHashMap<MapleClient, NPCConversationManager>();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void startQuest(MapleClient a2, byte a32, byte a4, int a5) {
        NPCScriptManager a6;
        Lock lock = a2.getNPCLock();
        NPCConversationManager nPCConversationManager = a6.d.get(a2);
        if (nPCConversationManager == null || nPCConversationManager.getLastMsg() > -1) {
            return;
        }
        lock.lock();
        try {
            Lock lock2;
            if (nPCConversationManager.pendingDisposal) {
                lock2 = lock;
                a6.dispose(a2);
            } else {
                a2.setClickedNPC();
                Object[] arrobject = new Object[3];
                arrobject[0] = a32;
                arrobject[1] = a4;
                arrobject[2] = a5;
                nPCConversationManager.getIv().invokeFunction(DumpMobName.ALLATORIxDEMO("f$t\"a"), arrobject);
                lock2 = lock;
            }
            lock2.unlock();
            return;
        }
        catch (NoSuchMethodException | ScriptException a32) {
            if (a2.getPlayer().isGM()) {
                a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u4efb\u52d9\u8173\u672c:" + nPCConversationManager.getQuest() + "\u932f\u8aa4...NPC: " + nPCConversationManager.getNpc() + ":" + a32);
            }
            System.err.println("Error executing Quest script. (" + nPCConversationManager.getQuest() + ")...NPC: " + nPCConversationManager.getNpc() + ":" + a32);
            FilePrinter.printError(MobSkill.ALLATORIxDEMO("dziyIXCZ^gKDKMOX\u0004^R^"), "Error executing Quest script. (" + nPCConversationManager.getQuest() + ")..NPCID: " + nPCConversationManager.getNpc() + ":" + a32);
            a6.dispose(a2);
            return;
        }
        finally {
            lock.unlock();
        }
    }

    public final /* synthetic */ void start(MapleClient a2, int a3) {
        NPCScriptManager a4;
        a4.start(a2, a3, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean onUserEnter(MapleClient a2, String a3) {
        NPCScriptManager a4;
        Lock lock = a2.getNPCLock();
        lock.lock();
        boolean bl = false;
        try {
            block11: {
                block12: {
                    Invocable invocable;
                    block13: {
                        if (a2.getPlayer().isShowInfo()) {
                            a2.getPlayer().showInfo(MobSkill.ALLATORIxDEMO("ED\u007fYOXoD^OX\u8159\u6706"), false, "\u958b\u59cbonUserEnter\u8173\u672c\uff1a" + a3 + " \u5730\u5716:" + a2.getPlayer().getMap().getMapName());
                        }
                        if (a4.d.containsKey(a2)) break block12;
                        invocable = a4.getInvocable("map/onUserEnter/" + a3 + ".js", a2, true);
                        if (invocable != null) break block13;
                        a4.dispose(a2);
                        break block11;
                    }
                    ScriptEngine scriptEngine = (ScriptEngine)((Object)invocable);
                    NPCConversationManager nPCConversationManager = new NPCConversationManager(a2, 0, -1, 0, a3, ScriptType.ON_USER_ENTER, invocable);
                    a4.d.put(a2, nPCConversationManager);
                    MapleClient mapleClient = a2;
                    scriptEngine.put(DumpMobName.ALLATORIxDEMO("=f"), nPCConversationManager);
                    mapleClient.getPlayer().setConversation(1);
                    mapleClient.setClickedNPC();
                    try {
                        invocable.invokeFunction(MobSkill.ALLATORIxDEMO("Y^KX^"), new Object[0]);
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        Object[] arrobject = new Object[3];
                        arrobject[0] = (byte)1;
                        arrobject[1] = (byte)0;
                        arrobject[2] = 0;
                        invocable.invokeFunction(DumpMobName.ALLATORIxDEMO("1v$|?{"), arrobject);
                    }
                    bl = true;
                    break block11;
                }
                if (a2.getPlayer().isGM()) {
                    a2.getPlayer().showInfo(MobSkill.ALLATORIxDEMO("ED\u007fYOXoD^OX\u8159\u6706"), true, "\u7121\u6cd5\u57f7\u884c\u8173\u672c:\u5df2\u6709\u8173\u672c\u57f7\u884c-" + a4.d.containsKey(a2));
                }
            }
            return bl;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("\u57f7\u884conUserEnter\u8173\u672c\u51fa\u932f : " + a3 + ". " + exception);
            FilePrinter.printError(DumpMobName.ALLATORIxDEMO("\u001eE\u0013F3g9e$X1{1r5g~a(a"), "\u57f7\u884conUserEnter\u8173\u672c\u51fa\u932f : " + a3 + ". " + exception);
            NPCScriptManager nPCScriptManager = a4;
            nPCScriptManager.dispose(a2);
            nPCScriptManager.ALLATORIxDEMO(a2, 0, a3, ScriptType.ON_USER_ENTER);
            bl = false;
            return bl;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void endQuest(MapleClient a2, int a3, int a4, boolean a52) {
        NPCScriptManager a6;
        if (!a52 && !MapleQuest.getInstance(a4).canComplete(a2.getPlayer(), null)) {
            return;
        }
        Lock a52 = a2.getNPCLock();
        a52.lock();
        try {
            if (!a6.d.containsKey(a2) && a2.canClickNPC()) {
                Invocable invocable = a6.getInvocable("quest/" + a4 + ".js", a2, true);
                if (invocable == null) {
                    if (a2.getPlayer().isGM()) {
                        a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u4efb\u52d9\u8173\u672c:" + a4 + " \u7f3a\u5931!");
                    }
                    System.err.println("\u7f3a\u5c11\u7d50\u675f\u8173\u672c: quest/" + a4 + ".js");
                    a6.dispose(a2);
                    return;
                }
                ScriptEngine scriptEngine = (ScriptEngine)((Object)invocable);
                NPCConversationManager nPCConversationManager = new NPCConversationManager(a2, a3, a4, 0, null, ScriptType.QUEST_END, invocable);
                a6.d.put(a2, nPCConversationManager);
                MapleClient mapleClient = a2;
                scriptEngine.put(DumpMobName.ALLATORIxDEMO("!x"), nPCConversationManager);
                mapleClient.getPlayer().setConversation(1);
                mapleClient.setClickedNPC();
                Object[] arrobject = new Object[3];
                arrobject[0] = (byte)1;
                arrobject[1] = (byte)0;
                arrobject[2] = 0;
                invocable.invokeFunction(MobSkill.ALLATORIxDEMO("ODN"), arrobject);
            }
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            if (a2.getPlayer().isGM()) {
                int n2 = a4;
                a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u4efb\u52d9\u8173\u672c:" + n2 + "\u932f\u8aa4...NPC: " + n2 + ":" + exception);
            }
            System.err.println("Error executing Quest script. (" + a4 + ")..NPCID: " + a3 + ":" + exception);
            FilePrinter.printError(DumpMobName.ALLATORIxDEMO("\u001eE\u0013F3g9e$X1{1r5g~a(a"), "Error executing Quest script. (" + a4 + ")..NPCID: " + a3 + ":" + exception);
            NPCScriptManager nPCScriptManager = a6;
            nPCScriptManager.dispose(a2);
            nPCScriptManager.ALLATORIxDEMO(a2, a3, String.valueOf(a4), ScriptType.QUEST_END);
            return;
        }
        finally {
            a52.unlock();
        }
    }

    public final /* synthetic */ void cleanCMS() {
        NPCScriptManager a2;
        ArrayList<MapleClient> arrayList = new ArrayList<MapleClient>();
        for (MapleClient mapleClient : a2.d.keySet()) {
            if (mapleClient != null && mapleClient.getSession() != null && mapleClient.getSession().isActive()) continue;
            arrayList.add(mapleClient);
        }
        Iterator<MapleClient> iterator = arrayList.iterator();
        Iterator<Object> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MapleClient mapleClient;
            mapleClient = iterator.next();
            iterator2 = iterator;
            a2.d.remove(mapleClient);
        }
    }

    public final /* synthetic */ void start(MapleClient a2, int a3, String a4) {
        NPCScriptManager a5;
        a5.start(a2, a3, 0, a4, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3, String a4, ScriptType a5) {
        MapleClient mapleClient;
        switch (1.ALLATORIxDEMO[((Enum)a5).ordinal()]) {
            case 1: {
                a5 = "NPC\u8173\u672c\u51fa\u932f-NPC:" + a3 + (String)(a4 != null ? " \u7279\u6b8a\u8173\u672c:" + a4 : "");
                mapleClient = a2;
                break;
            }
            case 2: {
                a5 = "\u9053\u5177\u8173\u672c\u51fa\u932f-NPC:" + a3 + " \u8173\u672c:" + a4;
                mapleClient = a2;
                break;
            }
            case 3: {
                a5 = "onUserEnter\u8173\u672c\u51fa\u932f-\u8173\u672c:" + a4;
                mapleClient = a2;
                break;
            }
            case 4: {
                a5 = "onFirstUserEnter\u8173\u672c\u51fa\u932f-\u8173\u672c:" + a4;
                mapleClient = a2;
                break;
            }
            default: {
                a5 = "\u8173\u672c\u51fa\u932f-NPC:" + a3 + " \u8173\u672c:" + a4;
                mapleClient = a2;
            }
        }
        mapleClient.getPlayer().dropMessage(1, (String)a5);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void dispose(MapleClient a2) {
        MapleClient mapleClient;
        block8: {
            block7: {
                NPCScriptManager a3;
                NPCConversationManager nPCConversationManager = a3.d.get(a2);
                String string = GameSetConstants.getNpcFolder();
                if (nPCConversationManager == null) break block7;
                a3.d.remove(a2);
                switch (1.ALLATORIxDEMO[nPCConversationManager.getType().ordinal()]) {
                    case 1: {
                        a2.removeScriptEngine(string + "/npc/" + nPCConversationManager.getNpc() + ".js");
                        a2.removeScriptEngine(string + "/special/" + nPCConversationManager.getScript() + ".js");
                        a2.removeScriptEngine(string + "/special/notcoded.js");
                        if (nPCConversationManager.getMode() == 0) break;
                        a2.removeScriptEngine(string + "/npc/" + nPCConversationManager.getNpc() + "_" + nPCConversationManager.getMode() + ".js");
                        mapleClient = a2;
                        break block8;
                    }
                    case 2: {
                        a2.removeScriptEngine(string + "/item/" + nPCConversationManager.getScript() + ".js");
                        a2.removeScriptEngine(string + "/item/scroll/" + nPCConversationManager.getScript() + ".js");
                        a2.removeScriptEngine(string + "/item/consume/" + nPCConversationManager.getScript() + ".js");
                        mapleClient = a2;
                        break block8;
                    }
                    case 3: {
                        a2.removeScriptEngine(string + "/map/onUserEnter/" + nPCConversationManager.getScript() + ".js");
                        mapleClient = a2;
                        break block8;
                    }
                    case 4: {
                        a2.removeScriptEngine(string + "/map/onFirstUserEnter/" + nPCConversationManager.getScript() + ".js");
                        mapleClient = a2;
                        break block8;
                    }
                    default: {
                        a2.removeScriptEngine(string + "/quest/" + nPCConversationManager.getQuest() + ".js");
                    }
                }
            }
            mapleClient = a2;
        }
        if (mapleClient.getPlayer() != null && a2.getPlayer().getConversation() == 1) {
            a2.getPlayer().setConversation(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void endQuest(MapleClient a2, byte a32, byte a4, int a5) {
        NPCScriptManager a6;
        Lock lock = a2.getNPCLock();
        NPCConversationManager nPCConversationManager = a6.d.get(a2);
        if (nPCConversationManager == null || nPCConversationManager.getLastMsg() > -1) {
            return;
        }
        lock.lock();
        try {
            Lock lock2;
            if (nPCConversationManager.pendingDisposal) {
                lock2 = lock;
                a6.dispose(a2);
            } else {
                a2.setClickedNPC();
                Object[] arrobject = new Object[3];
                arrobject[0] = a32;
                arrobject[1] = a4;
                arrobject[2] = a5;
                nPCConversationManager.getIv().invokeFunction(DumpMobName.ALLATORIxDEMO("p>q"), arrobject);
                lock2 = lock;
            }
            lock2.unlock();
            return;
        }
        catch (NoSuchMethodException | ScriptException a32) {
            if (a2.getPlayer().isGM()) {
                a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u4efb\u52d9\u8173\u672c:" + nPCConversationManager.getQuest() + "\u932f\u8aa4...NPC: " + nPCConversationManager.getNpc() + ":" + a32);
            }
            System.err.println("Error executing Quest script. (" + nPCConversationManager.getQuest() + ")...NPC: " + nPCConversationManager.getNpc() + ":" + a32);
            FilePrinter.printError(MobSkill.ALLATORIxDEMO("dziyIXCZ^gKDKMOX\u0004^R^"), "Error executing Quest script. (" + nPCConversationManager.getQuest() + ")..NPCID: " + nPCConversationManager.getNpc() + ":" + a32);
            a6.dispose(a2);
            return;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void startQuest(MapleClient a2, int a3, int a4) {
        NPCScriptManager a5;
        if (!MapleQuest.getInstance(a4).canStart(a2.getPlayer(), null)) {
            return;
        }
        Lock lock = a2.getNPCLock();
        lock.lock();
        try {
            if (!a5.d.containsKey(a2) && a2.canClickNPC()) {
                Invocable invocable = a5.getInvocable("quest/" + a4 + ".js", a2, true);
                if (invocable == null) {
                    a2.getPlayer().dropMessage(1, "\u6b64\u4efb\u52d9\u5c1a\u672a\u5efa\u7f6e\uff0c\u8acb\u901a\u77e5\u7ba1\u7406\u54e1\u3002\r\n\u4efb\u52d9\u7de8\u865f: " + a4);
                    a5.dispose(a2);
                    return;
                }
                ScriptEngine scriptEngine = (ScriptEngine)((Object)invocable);
                NPCConversationManager nPCConversationManager = new NPCConversationManager(a2, a3, a4, 0, null, ScriptType.QUEST_START, invocable);
                MapleClient mapleClient = a2;
                a5.d.put(a2, nPCConversationManager);
                scriptEngine.put(MobSkill.ALLATORIxDEMO("[G"), nPCConversationManager);
                mapleClient.getPlayer().setConversation(1);
                mapleClient.setClickedNPC();
                if (mapleClient.getPlayer().isGM() && a4 != 29901 && a4 != 29902 && a4 != 29903 && a4 != 29941 && a4 != 29942 && a4 != 29943 && a4 != 29944) {
                    a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u60a8\u5df2\u7d93\u5efa\u7acb\u8207\u4efb\u52d9\u8173\u672c:" + a4 + "\u7684\u5f80\u4f86\u3002");
                }
                if (a2.isMonitored()) {
                    FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a2.getPlayer().getChrInfo("\u5df2\u7d93\u5efa\u7acb\u8207\u4efb\u52d9\u8173\u672c:" + a4 + "\u7684\u5f80\u4f86\u3002"));
                }
                Object[] arrobject = new Object[3];
                arrobject[0] = (byte)1;
                arrobject[1] = (byte)0;
                arrobject[2] = 0;
                invocable.invokeFunction(DumpMobName.ALLATORIxDEMO("f$t\"a"), arrobject);
            }
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("Error executing Quest script. (" + a4 + ")..NPCID: " + a3 + ":" + exception);
            FilePrinter.printError(MobSkill.ALLATORIxDEMO("dziyIXCZ^gKDKMOX\u0004^R^"), "Error executing Quest script. (" + a4 + ")..NPCID: " + a3 + ":" + exception);
            a5.dispose(a2);
            return;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void start(MapleClient a2, int a3, int a2222, String a4, boolean a5) {
        NPCScriptManager a6;
        Lock lock = a2.getNPCLock();
        lock.lock();
        try {
            Invocable invocable;
            MapleNPC mapleNPC = MapleLifeFactory.getNPC(a3);
            if (mapleNPC == null) {
                if (a2.getPlayer().isGM()) {
                    a2.getPlayer().dropMessage("NPC " + a3 + " \u4e0d\u5b58\u5728");
                }
                a6.dispose(a2);
                return;
            }
            if (a3 == 2013001) {
                a5 = false;
            }
            MapleClient mapleClient = a2;
            mapleClient.getPlayer().setTalkNpc(a3);
            if (mapleClient.getPlayer().isGM()) {
                int n2;
                Object object;
                MapleCharacter mapleCharacter = a2.getPlayer();
                if (a4 == null) {
                    object = "";
                    n2 = a2222;
                } else {
                    object = "(" + a4 + ")";
                    n2 = a2222;
                }
                mapleCharacter.dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u60a8\u5df2\u7d93\u5efa\u7acb\u8207NPC:" + a3 + (String)object + (String)(n2 == 0 ? "" : "\u578b\u865f: " + a2222) + "\u7684\u5c0d\u8a71\u3002");
            }
            if (a2.isMonitored()) {
                int n3;
                Object object;
                String string = "logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt";
                MapleCharacter mapleCharacter = a2.getPlayer();
                if (a4 == null) {
                    object = "";
                    n3 = a2222;
                } else {
                    object = "(" + a4 + ")";
                    n3 = a2222;
                }
                FileoutputUtil.logToFile(string, mapleCharacter.getChrInfo("\u5efa\u7acb\u8207NPC:" + a3 + (String)object + (String)(n3 == 0 ? "" : "\u578b\u865f: " + a2222) + "\u7684\u5c0d\u8a71\u3002\r\n"));
            }
            if (a2 != null && a2.getPlayer().isOperateStorage()) {
                MapleClient mapleClient2 = a2;
                mapleClient2.getPlayer().dropMessage(5, MobSkill.ALLATORIxDEMO("\u4f4a\u6b49\u5702\u64e7\u4f76\u5023\u5e81\u000b"));
                a6.dispose(mapleClient2);
                return;
            }
            if (a5 && a2.getPlayer().hasBlockedInventory()) {
                a6.dispose(a2);
            }
            if (a5 && (a6.d.containsKey(a2) || !a2.canClickNPC()) && a2.getPlayer() != null) {
                a2.removeClickedNPC();
                MapleClient mapleClient3 = a2;
                NPCScriptManager.ALLATORIxDEMO.dispose(mapleClient3);
                mapleClient3.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (a5 && (a6.d.containsKey(a2) || !a2.canClickNPC())) return;
            if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(DumpMobName.ALLATORIxDEMO("#a1g$5}5qv=f~v?{$t9{#^5lxvy5v3pv~v1{\u0013y9v;[\u0000Vx<"));
            }
            if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(MobSkill.ALLATORIxDEMO("Y^KX^\n\u0007\nYO^cD\\EIKHFO"));
            }
            if (a4 == null) {
                NPCScriptManager nPCScriptManager = a6;
                invocable = a2222 != 0 ? (a5 = nPCScriptManager.getInvocable("npc/" + a3 + "_" + a2222 + ".js", a2, true)) : (a5 = nPCScriptManager.getInvocable("npc/" + a3 + ".js", a2, true));
            } else {
                invocable = a5 = a6.getInvocable("special/" + a4 + ".js", a2, true);
            }
            if (invocable == null && (a5 = a6.getInvocable(DumpMobName.ALLATORIxDEMO("f p3|1y\u007f{?a3z4p4;:f"), a2, true)) == null) {
                MapleClient mapleClient4 = a2;
                a6.dispose(mapleClient4);
                mapleClient4.getPlayer().dropMessage(5, "NPC\u672a\u958b\u653e\u3002\u5982\u679c\u60a8\u89ba\u5f97\u6211\u61c9\u8a72\u5de5\u4f5c\u7684\uff0c\u90a3\u5c31\u8acb\u60a8\u56de\u5831\u7d66\u7ba1\u7406\u54e1 NPC\u7de8\u865f:" + a3 + "(" + a4 + ")");
                return;
            }
            ScriptEngine scriptEngine = (ScriptEngine)((Object)a5);
            if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(MobSkill.ALLATORIxDEMO("Y^KX^\n\u0007\nC\\"));
            }
            NPCConversationManager a2222 = new NPCConversationManager(a2, a3, -1, a2222, a4, ScriptType.NPC, a5);
            if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(DumpMobName.ALLATORIxDEMO("#a1g$5}53x"));
            }
            if (NPCScriptManager.ALLATORIxDEMO == null) {
                if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                    a2.getPlayer().dropMessage(MobSkill.ALLATORIxDEMO("Y^KX^\n\u0017\nD_FF"));
                }
                a6.dispose(a2);
                return;
            }
            a6.d.put(a2, a2222);
            if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(DumpMobName.ALLATORIxDEMO("f$t\"ap8pv=f"));
            }
            scriptEngine.put(MobSkill.ALLATORIxDEMO("IG"), a2222);
            if (a2.getPlayer() != null) {
                a2.getPlayer().setConversation(1);
            }
            if (a2.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(DumpMobName.ALLATORIxDEMO("f$t\"ap8pf5a\u0013z>c5g#t$|?{"));
            }
            MapleClient mapleClient5 = a2;
            mapleClient5.setClickedNPC();
            if (mapleClient5.getPlayer() != null && a2.getPlayer().getDebugMessage()) {
                a2.getPlayer().dropMessage(MobSkill.ALLATORIxDEMO("Y^KX^\n\u0007\nYO^iFCIAdzi"));
            }
            try {
                a5.invokeFunction(DumpMobName.ALLATORIxDEMO("f$t\"a"), new Object[0]);
                if (a2.getPlayer() == null || !a2.getPlayer().getDebugMessage()) return;
                a2.getPlayer().dropMessage(MobSkill.ALLATORIxDEMO("Y^KX^\n\u0007\nIGY"));
                return;
            }
            catch (NoSuchMethodException a2222) {
                Object[] arrobject = new Object[3];
                arrobject[0] = (byte)1;
                arrobject[1] = (byte)0;
                arrobject[2] = 0;
                a5.invokeFunction(DumpMobName.ALLATORIxDEMO("1v$|?{"), arrobject);
            }
            return;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            String string = a4;
            System.err.println("NPC \u8173\u672c\u932f\u8aa4, \u5b83ID\u70ba : " + a3 + "(" + string + ").[special]:" + string + exception);
            if (a2.getPlayer() != null && a2.getPlayer().isGM()) {
                String string2 = a4;
                a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a] NPC " + a3 + " (" + string2 + ") \u8173\u672c\u932f\u8aa4 [special]:" + string2 + "\u8173\u672c\u932f\u8aa4" + exception);
            }
            FilePrinter.printError(MobSkill.ALLATORIxDEMO("dziyIXCZ^gKDKMOX\u0004^R^"), "Error executing NPC script, NPC ID : " + a3 + "(" + a4 + ")." + exception);
            a6.dispose(a2);
            return;
        }
        catch (Exception exception) {
            String string = a4;
            System.err.println("NPC \u8173\u672c\u932f\u8aa4, \u5b83ID\u70ba : " + a3 + "(" + string + ").[special]:" + string + exception);
            exception.printStackTrace();
            if (a2.getPlayer() != null && a2.getPlayer().isGM()) {
                String string3 = a4;
                a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a] NPC " + a3 + " (" + string3 + ") \u8173\u672c\u932f\u8aa4 [special]:" + string3 + "\u8173\u672c\u932f\u8aa4" + exception);
            }
            FilePrinter.printError(DumpMobName.ALLATORIxDEMO("\u001eE\u0013F3g9e$X1{1r5g~a(a"), "Error executing NPC script, NPC ID : " + a3 + "(" + a4 + ")." + exception);
            a6.dispose(a2);
            return;
        }
        finally {
            lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void action(MapleClient a2, byte a32, byte a4, int a5) {
        if (a32 != -1) {
            NPCScriptManager a6;
            NPCConversationManager nPCConversationManager = a6.d.get(a2);
            if (nPCConversationManager == null || nPCConversationManager.getLastMsg() > -1) {
                return;
            }
            Lock lock = a2.getNPCLock();
            lock.lock();
            try {
                Lock lock2;
                if (nPCConversationManager.pendingDisposal) {
                    lock2 = lock;
                    a6.dispose(a2);
                } else {
                    a2.setClickedNPC();
                    Object[] arrobject = new Object[3];
                    arrobject[0] = a32;
                    arrobject[1] = a4;
                    arrobject[2] = a5;
                    nPCConversationManager.getIv().invokeFunction(MobSkill.ALLATORIxDEMO("KI^CED"), arrobject);
                    lock2 = lock;
                }
                lock2.unlock();
                return;
            }
            catch (NoSuchMethodException | ScriptException a32) {
                if (a2.getPlayer() != null && a2.getPlayer().isGM()) {
                    a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a] NPC " + nPCConversationManager.getNpc() + "\u8173\u672c\u932f\u8aa4 " + a32);
                }
                System.err.println("NPC \u8173\u672c\u932f\u8aa4. \u5b83ID\u70ba : " + nPCConversationManager.getNpc() + " " + nPCConversationManager.getScript() + ":" + a32);
                FilePrinter.printError(DumpMobName.ALLATORIxDEMO("\u001eE\u0013F3g9e$X1{1r5g~a(a"), "Error executing NPC script, NPC ID : " + nPCConversationManager.getNpc() + " " + nPCConversationManager.getScript() + "." + a32);
                a6.dispose(a2);
                return;
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new NPCScriptManager();
    }

    public final /* synthetic */ NPCConversationManager getCM(MapleClient a2) {
        NPCScriptManager a3;
        return a3.d.get(a2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ boolean onFirstUserEnter(MapleClient a2, String a3) {
        NPCScriptManager a4;
        Lock lock = a2.getNPCLock();
        lock.lock();
        boolean bl = false;
        try {
            block12: {
                block13: {
                    Invocable invocable;
                    block14: {
                        if (a2.getPlayer().isShowInfo()) {
                            a2.getPlayer().showInfo(MobSkill.ALLATORIxDEMO("EDlCXY^\u007fYOXoD^OX\u8159\u6706"), false, "\u958b\u59cbonFirstUserEnter\u8173\u672c\uff1a" + a3 + a2.getPlayer().getMap());
                        }
                        if (a4.d.containsKey(a2)) break block13;
                        invocable = a4.getInvocable("map/onFirstUserEnter/" + a3 + ".js", a2, true);
                        if (invocable != null) break block14;
                        if (a2.getPlayer().isShowErr()) {
                            a2.getPlayer().showInfo(DumpMobName.ALLATORIxDEMO("?{\u0016|\"f$@#p\"P>a5g\u8123\u6739"), true, "\u627e\u4e0d\u5230onFirstUserEnter\u8173\u672c:" + a3 + a2.getPlayer().getMap());
                        }
                        a4.dispose(a2);
                        break block12;
                    }
                    ScriptEngine scriptEngine = (ScriptEngine)((Object)invocable);
                    NPCConversationManager nPCConversationManager = new NPCConversationManager(a2, 0, -1, 0, a3, ScriptType.ON_FIRST_USER_ENTER, invocable);
                    a4.d.put(a2, nPCConversationManager);
                    MapleClient mapleClient = a2;
                    scriptEngine.put(MobSkill.ALLATORIxDEMO("GY"), nPCConversationManager);
                    mapleClient.getPlayer().setConversation(1);
                    mapleClient.setClickedNPC();
                    try {
                        invocable.invokeFunction(DumpMobName.ALLATORIxDEMO("f$t\"a"), new Object[0]);
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        Object[] arrobject = new Object[3];
                        arrobject[0] = (byte)1;
                        arrobject[1] = (byte)0;
                        arrobject[2] = 0;
                        invocable.invokeFunction(MobSkill.ALLATORIxDEMO("KI^CED"), arrobject);
                    }
                    bl = true;
                    break block12;
                }
                if (a2.getPlayer().isShowErr()) {
                    a2.getPlayer().showInfo(DumpMobName.ALLATORIxDEMO("?{\u0016|\"f$@#p\"P>a5g\u8123\u6739"), true, "\u7121\u6cd5\u57f7\u884c\u8173\u672c:\u5df2\u6709\u8173\u672c\u57f7\u884c-" + a4.d.containsKey(a2));
                }
            }
            return bl;
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("\u57f7\u884c\u5730\u5716onFirstUserEnter\u8173\u672c\u51fa\u932f : " + a3 + ". " + exception);
            FilePrinter.printError(MobSkill.ALLATORIxDEMO("dziyIXCZ^gKDKMOX\u0004^R^"), "\u57f7\u884c\u5730\u5716onFirstUserEnter\u8173\u672c\u51fa\u932f : " + a3 + ". " + exception);
            NPCScriptManager nPCScriptManager = a4;
            nPCScriptManager.dispose(a2);
            nPCScriptManager.ALLATORIxDEMO(a2, 0, a3, ScriptType.ON_FIRST_USER_ENTER);
            bl = false;
            return bl;
        }
        finally {
            lock.unlock();
        }
    }
}

