/*
 * Decompiled with CFR 0.150.
 */
package scripting.item;

import client.ISkill;
import client.MapleClient;
import client.SkillEntry;
import client.SkillFactory;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import constants.GameConstants;
import constants.JobConstants;
import java.util.Map;
import javax.script.Invocable;
import scripting.ScriptType;
import scripting.item.ItemScriptManager;
import scripting.npc.NPCConversationManager;
import server.MapleInventoryManipulator;
import server.MapleItemInformationProvider;
import tools.MaplePacketCreator;

public class ItemActionManager
extends NPCConversationManager {
    private final /* synthetic */ IEquip ALLATORIxDEMO;
    private final /* synthetic */ IItem d;

    public /* synthetic */ int getPosition() {
        ItemActionManager a2;
        return a2.d.getPosition();
    }

    public /* synthetic */ boolean canUseSkillBook(int a22, int a3) {
        if (a3 > 0) {
            ItemActionManager a4;
            ISkill a22 = SkillFactory.getSkill(a22);
            if (a4.c.getPlayer().getSkillLevel(a22) >= a22.getMaxLevel()) {
                return false;
            }
            ItemActionManager itemActionManager = a4;
            int n2 = itemActionManager.c.getPlayer().getSkillLevel(a22);
            if (itemActionManager.c.getPlayer().getSkillLevel(a22) >= 5 && a3 == 20 || a4.c.getPlayer().getSkillLevel(a22) >= 15 && a3 == 30) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ void remove(int a2) {
        ItemActionManager a3;
        a3.used(a2);
    }

    public /* synthetic */ void dispose(int a2) {
        ItemActionManager a3;
        if (a2 == 0) {
            a3.usedAll();
        } else if (a2 > 0) {
            a3.used(a2);
        }
        ItemActionManager itemActionManager = a3;
        ItemScriptManager.getInstance().dispose(itemActionManager, itemActionManager.getClient());
    }

    public /* synthetic */ boolean usedAll() {
        ItemActionManager a2;
        ItemActionManager itemActionManager = a2;
        return MapleInventoryManipulator.removeFromSlot(itemActionManager.c, MapleInventoryType.getByType(itemActionManager.d.getType()), a2.d.getPosition(), a2.d.getQuantity(), true, false);
    }

    public /* synthetic */ IEquip getEquip() {
        ItemActionManager a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ ItemActionManager(MapleClient a2, int a3, IItem a4, IEquip a5, Invocable a6) {
        ItemActionManager a7;
        ItemActionManager itemActionManager = a7;
        super(a2, a3, 0, 0, MapleItemInformationProvider.getInstance().getName(a4.getItemId()), ScriptType.ITEM, a6);
        itemActionManager.d = a4;
        itemActionManager.ALLATORIxDEMO = a5;
    }

    public /* synthetic */ IItem getItem() {
        ItemActionManager a2;
        return a2.d;
    }

    public /* synthetic */ String getSkillMenu(int a2) {
        ItemActionManager a3;
        Object object = "";
        for (Map.Entry<ISkill, SkillEntry> entry : a3.c.getPlayer().getSkills().entrySet()) {
            if (JobConstants.getSkillBookBySkill(entry.getKey().getId()) <= 2 || entry.getKey().getMaxLevel() <= 10 || entry.getValue().masterlevel >= entry.getKey().getMaxLevel()) continue;
            if (a2 > 20) {
                if (entry.getValue().masterlevel >= 30 || entry.getValue().masterlevel < 20 || entry.getKey().getMaxLevel() <= 20) continue;
                object = (String)object + "\r\n#L" + entry.getKey().getId() + "# #s" + entry.getKey().getId() + "# #fn\u9ed1\u9ad4##fs14##e#q" + entry.getKey().getId() + "##n#fs##fn##l";
                continue;
            }
            if (entry.getValue().masterlevel >= 20) continue;
            object = (String)object + "\r\n#L" + entry.getKey().getId() + "# #s" + entry.getKey().getId() + "# #fn\u9ed1\u9ad4##fs14##e#q" + entry.getKey().getId() + "##n#fs##fn##l";
        }
        return object;
    }

    public /* synthetic */ void useSkillBook(int a22, int a3) {
        ItemActionManager a4;
        ISkill a22 = SkillFactory.getSkill(a22);
        a3 = a3 > a22.getMaxLevel() ? (int)a22.getMaxLevel() : a3;
        ItemActionManager itemActionManager = a4;
        ISkill iSkill = a22;
        itemActionManager.c.getPlayer().changeSkillLevel(iSkill, a4.c.getPlayer().getSkillLevel(iSkill), (int)((byte)a3));
        ItemActionManager itemActionManager2 = a4;
        itemActionManager.c.getPlayer().getMap().broadcastMessage(MaplePacketCreator.useSkillBook(itemActionManager2.c.getPlayer(), 0, 0, true, true));
        itemActionManager2.c.getSession().write((Object)MaplePacketCreator.enableActions());
    }

    public /* synthetic */ int getItemId() {
        ItemActionManager a2;
        return a2.d.getItemId();
    }

    public /* synthetic */ boolean used(int a2) {
        ItemActionManager a3;
        return MapleInventoryManipulator.removeFromSlot(a3.getClient(), GameConstants.getInventoryType(a3.getItemId()), (short)a3.getPosition(), (short)a2, true, false);
    }

    @Override
    public /* synthetic */ void dispose() {
        ItemActionManager a2;
        a2.dispose(-1);
    }

    public /* synthetic */ ItemActionManager(MapleClient a2, int a3, IItem a4, Invocable a5) {
        ItemActionManager a6;
        ItemActionManager itemActionManager = a6;
        super(a2, a3, 0, 0, MapleItemInformationProvider.getInstance().getName(a4.getItemId()), ScriptType.ITEM, a5);
        itemActionManager.d = a4;
        itemActionManager.ALLATORIxDEMO = null;
    }

    public /* synthetic */ void remove() {
        ItemActionManager a2;
        a2.remove(1);
    }

    public /* synthetic */ boolean used() {
        ItemActionManager a2;
        return a2.used(1);
    }
}

