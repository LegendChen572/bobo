/*
 * Decompiled with CFR 0.150.
 */
package scripting.item;

import client.MapleClient;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.messages.ConsoleCommandObject;
import constants.GameSetConstants;
import java.util.Map;
import java.util.WeakHashMap;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import scripting.AbstractScriptManager;
import scripting.item.ItemActionManager;
import server.shops.MaplePlayerShopItem;
import tools.FileoutputUtil;

public class ItemScriptManager
extends AbstractScriptManager {
    private final /* synthetic */ Map<MapleClient, ItemActionManager> ALLATORIxDEMO;
    private static final /* synthetic */ ItemScriptManager d;

    public /* synthetic */ void dispose(MapleClient a2) {
        ItemScriptManager a3;
        ItemActionManager itemActionManager = a3.ALLATORIxDEMO.get(a2);
        String string = GameSetConstants.getNpcFolder();
        if (itemActionManager != null) {
            MapleClient mapleClient = a2;
            a3.ALLATORIxDEMO.remove(mapleClient);
            mapleClient.removeScriptEngine(string + "/item/" + itemActionManager.getItemId() + ".js");
            a2.removeScriptEngine(string + "/item/scroll/" + itemActionManager.getItemId() + ".js");
            a2.removeScriptEngine(string + "/item/consume/" + itemActionManager.getItemId() + ".js");
        }
        if (a2.getPlayer() != null && a2.getPlayer().getConversation() == 1) {
            a2.getPlayer().setConversation(0);
        }
    }

    public /* synthetic */ ItemActionManager getIM(MapleClient a2) {
        ItemScriptManager a3;
        return a3.ALLATORIxDEMO.get(a2);
    }

    public /* synthetic */ ItemScriptManager() {
        ItemScriptManager a2;
        ItemScriptManager itemScriptManager = a2;
        itemScriptManager.ALLATORIxDEMO = new WeakHashMap<MapleClient, ItemActionManager>();
    }

    public /* synthetic */ void action(MapleClient a2, byte a32, byte a4, int a5) {
        if (a32 != -1) {
            ItemActionManager itemActionManager;
            ItemScriptManager a6;
            block5: {
                itemActionManager = a6.ALLATORIxDEMO.get(a2);
                if (itemActionManager == null) {
                    return;
                }
                if (!itemActionManager.pendingDisposal) break block5;
                a6.dispose(a2);
                return;
            }
            try {
                a2.setClickedNPC();
                Object[] arrobject = new Object[3];
                arrobject[0] = a32;
                arrobject[1] = a4;
                arrobject[2] = a5;
                itemActionManager.getIv().invokeFunction(MaplePlayerShopItem.ALLATORIxDEMO("\u0016U\u0003_\u0018X"), arrobject);
                return;
            }
            catch (NoSuchMethodException | ScriptException a32) {
                ItemActionManager itemActionManager2 = itemActionManager;
                a4 = (byte)itemActionManager2.getNpc();
                a5 = itemActionManager2.getItemId();
                System.err.println("\u57f7\u884cNPC\u8173\u672c\u51fa\u932f NPC ID : " + a4 + " \u9053\u5177ID: " + a5 + " \u932f\u8aa4\u4fe1\u606f: " + a32);
                FileoutputUtil.logToFile_NpcScript_Bug(a2.getPlayer(), "\u57f7\u884cNPC\u8173\u672c\u51fa\u932f NPC ID : " + a4 + " \u9053\u5177ID: " + a5 + ". \r\n\u932f\u8aa4\u4fe1\u606f: " + a32);
                ItemScriptManager itemScriptManager = a6;
                itemScriptManager.dispose(a2);
                itemScriptManager.ALLATORIxDEMO(a2, a5);
            }
        }
    }

    public /* synthetic */ boolean start(MapleClient a2, int a3, IItem a4, IEquip a52) {
        ScriptEngine scriptEngine;
        Invocable invocable;
        ItemScriptManager a6;
        block8: {
            block7: {
                if (!a6.ALLATORIxDEMO.containsKey(a2)) break block7;
                a6.dispose(a2);
                return false;
            }
            if (a2.getPlayer().isGM()) {
                a2.getPlayer().dropMessage(5, "\u958b\u59cb\u9053\u5177\u8173\u672c NPC\uff1a" + a3 + " \u9053\u5177Id\uff1a" + a4.getItemId() + " \u4f4d\u7f6e:item/scroll/" + a4.getItemId() + ".js");
            }
            invocable = a6.getInvocable("item/scroll/" + a4.getItemId() + ".js", a2, false);
            scriptEngine = (ScriptEngine)((Object)invocable);
            a52 = new ItemActionManager(a2, a3, a4, (IEquip)a52, invocable);
            if (invocable != null) break block8;
            a6.dispose(a2);
            return false;
        }
        try {
            a6.ALLATORIxDEMO.put(a2, (ItemActionManager)a52);
            MapleClient mapleClient = a2;
            scriptEngine.put(MaplePlayerShopItem.ALLATORIxDEMO("\u001e["), a52);
            mapleClient.getPlayer().setConversation(1);
            mapleClient.setClickedNPC();
            try {
                invocable.invokeFunction(ConsoleCommandObject.ALLATORIxDEMO("Ih[nN"), new Object[0]);
            }
            catch (NoSuchMethodException a52) {
                Object[] arrobject = new Object[3];
                arrobject[0] = (byte)1;
                arrobject[1] = (byte)0;
                arrobject[2] = 0;
                invocable.invokeFunction(MaplePlayerShopItem.ALLATORIxDEMO("\u0016U\u0003_\u0018X"), arrobject);
            }
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("\u57f7\u884c\u9053\u5177\u8173\u672c\u5931\u6557 \u9053\u5177ID: (" + a4.getItemId() + ")..NPCID: " + a3 + ":" + exception);
            FileoutputUtil.logToFile_NpcScript_Bug(a2.getPlayer(), "\u57f7\u884c\u9053\u5177\u8173\u672c\u5931\u6557 \u9053\u5177ID: (" + a4.getItemId() + ")..NPCID: " + a3 + ". \r\n\u932f\u8aa4\u4fe1\u606f: " + exception);
            ItemScriptManager itemScriptManager = a6;
            itemScriptManager.dispose(a2);
            itemScriptManager.ALLATORIxDEMO(a2, a4.getItemId());
            return false;
        }
        return true;
    }

    public static /* synthetic */ {
        d = new ItemScriptManager();
    }

    public /* synthetic */ void start(MapleClient a2, int a3, IItem a4) {
        ItemActionManager itemActionManager;
        ScriptEngine scriptEngine;
        Invocable invocable;
        ItemScriptManager a5;
        block8: {
            block7: {
                if (!a5.ALLATORIxDEMO.containsKey(a2)) break block7;
                a5.dispose(a2);
                return;
            }
            if (a2.getPlayer().isGM()) {
                a2.getPlayer().dropMessage(5, "\u958b\u59cb\u9053\u5177\u8173\u672c NPC\uff1a" + a3 + " \u9053\u5177Id\uff1a" + a4.getItemId());
            }
            invocable = a5.getInvocable("item/" + a4.getItemId() + ".js", a2, false);
            scriptEngine = (ScriptEngine)((Object)invocable);
            itemActionManager = new ItemActionManager(a2, a3, a4, invocable);
            if (invocable != null) break block8;
            itemActionManager.sendOk("\u5c0d\u4e0d\u8d77\uff0c\u6211\u4e26\u6c92\u6709\u88ab\u7ba1\u7406\u54e1\u8a2d\u7f6e\u53ef\u4f7f\u7528\uff0c\u5982\u679c\u60a8\u89ba\u5f97\u6211\u61c9\u8a72\u5de5\u4f5c\u7684\uff0c\u90a3\u5c31\u8acb\u60a8\u532f\u5831\u7d66\u7ba1\u7406\u54e1\u3002\r\n\u6211\u7684\u4fe1\u606f: #b#i" + a4.getItemId() + ":##z" + a4.getItemId() + "##k ID: " + a4.getItemId());
            a5.dispose(a2);
            return;
        }
        try {
            a5.ALLATORIxDEMO.put(a2, itemActionManager);
            MapleClient mapleClient = a2;
            scriptEngine.put(ConsoleCommandObject.ALLATORIxDEMO("uW"), itemActionManager);
            mapleClient.getPlayer().setConversation(1);
            mapleClient.setClickedNPC();
            try {
                invocable.invokeFunction(MaplePlayerShopItem.ALLATORIxDEMO("E\u0003W\u0005B"), new Object[0]);
                return;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Object[] arrobject = new Object[3];
                arrobject[0] = (byte)1;
                arrobject[1] = (byte)0;
                arrobject[2] = 0;
                invocable.invokeFunction(ConsoleCommandObject.ALLATORIxDEMO("}YhSsT"), arrobject);
                return;
            }
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("\u57f7\u884c\u9053\u5177\u8173\u672c\u5931\u6557 \u9053\u5177ID: (" + a4.getItemId() + ")..NPCID: " + a3 + ":" + exception);
            FileoutputUtil.logToFile_NpcScript_Bug(a2.getPlayer(), "\u57f7\u884c\u9053\u5177\u8173\u672c\u5931\u6557 \u9053\u5177ID: (" + a4.getItemId() + ")..NPCID: " + a3 + ". \r\n\u932f\u8aa4\u4fe1\u606f: " + exception);
            ItemScriptManager itemScriptManager = a5;
            itemScriptManager.dispose(a2);
            itemScriptManager.ALLATORIxDEMO(a2, a4.getItemId());
            return;
        }
    }

    public static final /* synthetic */ ItemScriptManager getInstance() {
        return d;
    }

    public /* synthetic */ void dispose(ItemActionManager a2, MapleClient a3) {
        String string = GameSetConstants.getNpcFolder();
        if (a2 != null) {
            ItemScriptManager a4;
            MapleClient mapleClient = a3;
            a4.ALLATORIxDEMO.remove(mapleClient);
            mapleClient.removeScriptEngine(string + "/item/" + a2.getItemId() + ".js");
            a3.removeScriptEngine(string + "/item/scroll/" + a2.getItemId() + ".js");
            a3.removeScriptEngine(string + "/item/consume/" + a2.getItemId() + ".js");
        }
        if (a3.getPlayer() != null && a3.getPlayer().getConversation() == 1) {
            a3.getPlayer().setConversation(0);
        }
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3) {
        a2.getPlayer().dropMessage(1, "\u9019\u500b\u9053\u5177\u8173\u672c\u662f\u932f\u8aa4\u7684\uff0c\u8acb\u806f\u7e6b\u7ba1\u7406\u54e1\u4fee\u5fa9\u5b83.\u9053\u5177ID: " + a3);
    }

    public /* synthetic */ boolean startUseItem(MapleClient a2, int a3, IItem a4) {
        ItemActionManager itemActionManager;
        ScriptEngine scriptEngine;
        Invocable invocable;
        ItemScriptManager a5;
        block8: {
            block7: {
                if (!a5.ALLATORIxDEMO.containsKey(a2)) break block7;
                a5.dispose(a2);
                return false;
            }
            if (a2.getPlayer().isGM()) {
                a2.getPlayer().dropMessage(5, "\u958b\u59cb\u9053\u5177\u8173\u672c NPC\uff1a" + a3 + " \u9053\u5177Id\uff1a" + a4.getItemId() + " \u4f4d\u7f6e:item/consume/" + a4.getItemId() + ".js");
            }
            invocable = a5.getInvocable("item/consume/" + a4.getItemId() + ".js", a2, false);
            scriptEngine = (ScriptEngine)((Object)invocable);
            itemActionManager = new ItemActionManager(a2, a3, a4, null, invocable);
            if (invocable != null) break block8;
            a5.dispose(a2);
            return false;
        }
        try {
            a5.ALLATORIxDEMO.put(a2, itemActionManager);
            MapleClient mapleClient = a2;
            scriptEngine.put(ConsoleCommandObject.ALLATORIxDEMO("uW"), itemActionManager);
            mapleClient.getPlayer().setConversation(1);
            mapleClient.setClickedNPC();
            try {
                invocable.invokeFunction(MaplePlayerShopItem.ALLATORIxDEMO("E\u0003W\u0005B"), new Object[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Object[] arrobject = new Object[3];
                arrobject[0] = (byte)1;
                arrobject[1] = (byte)0;
                arrobject[2] = 0;
                invocable.invokeFunction(ConsoleCommandObject.ALLATORIxDEMO("}YhSsT"), arrobject);
            }
        }
        catch (NoSuchMethodException | ScriptException exception) {
            System.err.println("\u57f7\u884c\u9053\u5177\u8173\u672c\u5931\u6557 \u9053\u5177ID: (" + a4.getItemId() + ")..NPCID: " + a3 + ":" + exception);
            FileoutputUtil.logToFile_NpcScript_Bug(a2.getPlayer(), "\u57f7\u884c\u9053\u5177\u8173\u672c\u5931\u6557 \u9053\u5177ID: (" + a4.getItemId() + ")..NPCID: " + a3 + ". \r\n\u932f\u8aa4\u4fe1\u606f: " + exception);
            ItemScriptManager itemScriptManager = a5;
            itemScriptManager.dispose(a2);
            itemScriptManager.ALLATORIxDEMO(a2, a4.getItemId());
            return false;
        }
        return true;
    }
}

