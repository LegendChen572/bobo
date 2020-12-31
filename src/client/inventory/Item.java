/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.MapleRing;
import constants.GameConstants;
import java.io.Serializable;
import server.MapleItemInformationProvider;

public class Item
implements IItem,
Serializable {
    private /* synthetic */ String a;
    private /* synthetic */ MaplePet g;
    private /* synthetic */ short C;
    private /* synthetic */ long d;
    private /* synthetic */ short F;
    private /* synthetic */ String K;
    private /* synthetic */ long E;
    private /* synthetic */ int e;
    public /* synthetic */ MapleRing ring;
    private final /* synthetic */ int I;
    private /* synthetic */ long ALLATORIxDEMO;
    private /* synthetic */ String k;
    private /* synthetic */ int B;
    private /* synthetic */ int H;

    public /* synthetic */ Item(int a2, short a3, short a4, int a5, int a6) {
        Item a7;
        Item item2 = a7;
        Item item3 = a7;
        Item item4 = a7;
        Item item5 = a7;
        Item item6 = a7;
        Item item7 = a7;
        Item item8 = a7;
        a7.E = -1L;
        item8.g = null;
        item8.B = -1;
        item7.k = "";
        item7.K = null;
        item6.a = "";
        item6.ring = null;
        item5.d = -1L;
        item5.ALLATORIxDEMO = -1L;
        item4.I = a2;
        item4.F = a3;
        item3.C = a4;
        item3.H = a5;
        item2.B = a6;
        item2.d = -1L;
    }

    @Override
    public final /* synthetic */ void setCustomFlag(int a2) {
        a.e = a2;
    }

    public /* synthetic */ int hashCode() {
        Item a2;
        int n2 = 3;
        n2 = 97 * n2 + a2.I;
        n2 = 97 * n2 + a2.F;
        n2 = 97 * n2 + a2.C;
        n2 = 97 * n2 + a2.B;
        return n2;
    }

    @Override
    public final /* synthetic */ String getItemName() {
        Item a2;
        return MapleItemInformationProvider.getInstance().getName(a2.getItemId());
    }

    public /* synthetic */ String toString() {
        Item a2;
        Item item2 = a2;
        return "\u7269\u54c1: " + item2.I + " \u6578\u91cf: " + item2.C;
    }

    public final /* synthetic */ void setPet(MaplePet a2) {
        a.g = a2;
    }

    @Override
    public final /* synthetic */ String getOwner() {
        Item a2;
        return a2.k;
    }

    @Override
    public /* synthetic */ byte getType() {
        return 2;
    }

    @Override
    public /* synthetic */ long getEquipOnlyId() {
        Item a2;
        return a2.d;
    }

    @Override
    public final /* synthetic */ void setOwner(String a2) {
        a.k = a2;
    }

    @Override
    public /* synthetic */ void removeFlag(int a2) {
        a.H &= ~a2;
    }

    @Override
    public /* synthetic */ String getGiftFrom() {
        Item a2;
        return a2.a;
    }

    @Override
    public /* synthetic */ MapleRing getRing() {
        Item a2;
        if (!GameConstants.isEffectRing(a2.I) || a2.getUniqueId() <= 0) {
            return null;
        }
        if (a2.ring == null) {
            a2.ring = MapleRing.loadFromDb(a2.getUniqueId(), a2.F < 0);
        }
        return a2.ring;
    }

    @Override
    public /* synthetic */ String getKey() {
        Item a2;
        StringBuilder stringBuilder = new StringBuilder();
        Item item2 = a2;
        stringBuilder.append(a2.I);
        stringBuilder.append(item2.F);
        stringBuilder.append(a2.C);
        stringBuilder.append(a2.H);
        stringBuilder.append(a2.E);
        stringBuilder.append(a2.B);
        stringBuilder.append(a2.k);
        stringBuilder.append(a2.K);
        stringBuilder.append(a2.a);
        stringBuilder.append(a2.d);
        stringBuilder.append(a2.ALLATORIxDEMO);
        if (GameConstants.getInventoryType(item2.I) == MapleInventoryType.EQUIP || GameConstants.getInventoryType(a2.I) == MapleInventoryType.EQUIPPED) {
            IEquip iEquip = (IEquip)((Object)a2);
            stringBuilder.append(iEquip.getUpgradeSlots());
            stringBuilder.append(iEquip.getLevel());
            stringBuilder.append(iEquip.getStr());
            stringBuilder.append(iEquip.getDex());
            stringBuilder.append(iEquip.getInt());
            stringBuilder.append(iEquip.getLuk());
            stringBuilder.append(iEquip.getHp());
            stringBuilder.append(iEquip.getMp());
            stringBuilder.append(iEquip.getWatk());
            stringBuilder.append(iEquip.getMatk());
            stringBuilder.append(iEquip.getWdef());
            stringBuilder.append(iEquip.getMdef());
            stringBuilder.append(iEquip.getAcc());
            stringBuilder.append(iEquip.getAvoid());
            stringBuilder.append(iEquip.getHands());
            stringBuilder.append(iEquip.getSpeed());
            stringBuilder.append(iEquip.getJump());
            stringBuilder.append(iEquip.getViciousHammer());
            stringBuilder.append(iEquip.getItemEXP());
            stringBuilder.append(iEquip.getDurability());
            stringBuilder.append(iEquip.getEnhance());
            stringBuilder.append(iEquip.getPotential1());
            stringBuilder.append(iEquip.getPotential2());
            stringBuilder.append(iEquip.getPotential3());
            stringBuilder.append(iEquip.getIncSkill());
            stringBuilder.append(iEquip.getHpR());
            stringBuilder.append(iEquip.getMpR());
            stringBuilder.append(iEquip.getCharmEXP());
            stringBuilder.append(iEquip.getPVPDamage());
        }
        return stringBuilder.toString();
    }

    @Override
    public /* synthetic */ void setGMLog(String a2) {
        a.K = a2;
    }

    @Override
    public final /* synthetic */ int getFlag() {
        Item a2;
        return a2.H;
    }

    @Override
    public final /* synthetic */ int getItemId() {
        Item a2;
        return a2.I;
    }

    public /* synthetic */ Item(int a2, byte a3, short a4) {
        Item a5;
        Item item2 = a5;
        Item item3 = a5;
        Item item4 = a5;
        Item item5 = a5;
        Item item6 = a5;
        Item item7 = a5;
        item7.E = -1L;
        item7.g = null;
        item6.B = -1;
        item6.k = "";
        item5.K = null;
        item5.a = "";
        item4.ring = null;
        item4.d = -1L;
        item3.ALLATORIxDEMO = -1L;
        item3.I = a2;
        item2.F = a3;
        item2.C = a4;
    }

    @Override
    public final /* synthetic */ MaplePet getPet() {
        Item a2;
        return a2.g;
    }

    @Override
    public /* synthetic */ void addFlag(int a2) {
        a.H |= a2;
    }

    @Override
    public final /* synthetic */ void setFlag(int a2) {
        a.H = a2;
    }

    @Override
    public final /* synthetic */ long getExpiration() {
        Item a2;
        return a2.E;
    }

    @Override
    public final /* synthetic */ short getQuantity() {
        Item a2;
        return a2.C;
    }

    @Override
    public final /* synthetic */ int getCustomFlag() {
        Item a2;
        return a2.e;
    }

    public /* synthetic */ void setRing(MapleRing a2) {
        a.ring = a2;
    }

    public /* synthetic */ Item(int a2, short a3, short a4, int a5) {
        Item a6;
        Item item2 = a6;
        Item item3 = a6;
        Item item4 = a6;
        Item item5 = a6;
        Item item6 = a6;
        Item item7 = a6;
        Item item8 = a6;
        item8.E = -1L;
        item8.g = null;
        item7.B = -1;
        item7.k = "";
        item6.K = null;
        item6.a = "";
        item5.ring = null;
        item5.d = -1L;
        item4.ALLATORIxDEMO = -1L;
        item4.I = a2;
        item3.F = a3;
        item3.C = a4;
        item2.H = a5;
        item2.d = -1L;
    }

    @Override
    public final /* synthetic */ int getUniqueId() {
        Item a2;
        return a2.B;
    }

    @Override
    public /* synthetic */ void setEquipOnlyId(long a2) {
        a.d = a2;
    }

    @Override
    public /* synthetic */ Item copyWithQuantity(short a22) {
        Item a3;
        Item item2 = a3;
        Item item3 = a3;
        Item a22 = new Item(item2.I, item2.F, a22, item3.H, item3.B);
        Item item4 = a3;
        Item item5 = a22;
        Item item6 = a3;
        a22.g = item6.g;
        item5.k = item6.k;
        item5.K = a3.K;
        a22.E = item4.E;
        a22.a = item4.a;
        a22.d = a3.d;
        return a22;
    }

    @Override
    public final /* synthetic */ short getPosition() {
        Item a2;
        return a2.F;
    }

    @Override
    public /* synthetic */ void setQuantity(short a2) {
        a.C = a2;
    }

    @Override
    public final /* synthetic */ String getGMLog() {
        Item a2;
        return a2.K;
    }

    @Override
    public /* synthetic */ IItem copy() {
        Item a2;
        Item item2 = a2;
        Item item3 = a2;
        Item item4 = new Item(item2.I, item2.F, item3.C, item3.H, a2.B);
        Item item5 = a2;
        Item item6 = item4;
        Item item7 = a2;
        Item item8 = item4;
        Item item9 = a2;
        item4.g = item9.g;
        item8.k = item9.k;
        item8.K = a2.K;
        item4.E = item7.E;
        item6.a = item7.a;
        item6.C = a2.C;
        item4.d = item5.d;
        item4.ALLATORIxDEMO = item5.ALLATORIxDEMO;
        item4.e = a2.e;
        return item4;
    }

    @Override
    public /* synthetic */ long getInventoryitemId() {
        Item a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ boolean equals(Object a2) {
        Item a3;
        if (!(a2 instanceof IItem)) {
            return false;
        }
        return a3.B == (a2 = (IItem)a2).getUniqueId() && a3.I == a2.getItemId() && a3.C == a2.getQuantity() && Math.abs(a3.F) == Math.abs(a2.getPosition());
    }

    @Override
    public /* synthetic */ void setGiftFrom(String a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ void setInventoryitemId(long a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public final /* synthetic */ void setPosition(short a2) {
        Item a3;
        a3.F = a2;
        if (a3.g != null) {
            a3.g.setInventoryPosition(a2);
        }
    }

    @Override
    public /* synthetic */ int compareTo(IItem a2) {
        Item a3;
        if (Math.abs(a3.F) < Math.abs(a2.getPosition())) {
            return -1;
        }
        if (Math.abs(a3.F) == Math.abs(a2.getPosition())) {
            return 0;
        }
        return 1;
    }

    @Override
    public /* synthetic */ boolean hasSetOnlyId() {
        Item a2;
        MapleItemInformationProvider mapleItemInformationProvider = MapleItemInformationProvider.getInstance();
        if (a2.B > 0 || mapleItemInformationProvider.isCash(a2.I) || a2.I / 1000000 != 1) {
            return false;
        }
        return a2.d <= 0L;
    }

    @Override
    public final /* synthetic */ void setUniqueId(int a2) {
        a.B = a2;
    }

    @Override
    public final /* synthetic */ boolean isCash() {
        Item a2;
        return MapleItemInformationProvider.getInstance().isCash(a2.getItemId());
    }

    @Override
    public final /* synthetic */ void setExpiration(long a2) {
        a.E = a2;
    }
}

