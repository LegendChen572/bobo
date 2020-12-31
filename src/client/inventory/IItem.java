/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.inventory.MaplePet;
import client.inventory.MapleRing;

public interface IItem
extends Comparable<IItem> {
    public /* synthetic */ byte getType();

    public /* synthetic */ void removeFlag(int var1);

    public /* synthetic */ long getInventoryitemId();

    public /* synthetic */ void setQuantity(short var1);

    public /* synthetic */ IItem copy();

    public /* synthetic */ MaplePet getPet();

    public /* synthetic */ void setFlag(int var1);

    public /* synthetic */ void setGMLog(String var1);

    public /* synthetic */ void addFlag(int var1);

    public /* synthetic */ void setEquipOnlyId(long var1);

    public /* synthetic */ long getEquipOnlyId();

    public /* synthetic */ void setCustomFlag(int var1);

    public /* synthetic */ MapleRing getRing();

    public /* synthetic */ long getExpiration();

    public /* synthetic */ boolean isCash();

    public /* synthetic */ String getOwner();

    public /* synthetic */ int getCustomFlag();

    public /* synthetic */ String getGiftFrom();

    public /* synthetic */ short getPosition();

    public /* synthetic */ short getQuantity();

    public /* synthetic */ void setGiftFrom(String var1);

    public /* synthetic */ void setExpiration(long var1);

    public /* synthetic */ void setOwner(String var1);

    public /* synthetic */ int getFlag();

    public /* synthetic */ int getUniqueId();

    public /* synthetic */ String getGMLog();

    public /* synthetic */ String getItemName();

    public /* synthetic */ boolean hasSetOnlyId();

    public /* synthetic */ void setInventoryitemId(long var1);

    public /* synthetic */ IItem copyWithQuantity(short var1);

    public /* synthetic */ void setPosition(short var1);

    public /* synthetic */ void setUniqueId(int var1);

    public /* synthetic */ int getItemId();

    public /* synthetic */ String getKey();
}

