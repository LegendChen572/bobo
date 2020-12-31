/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.inventory.IItem;
import constants.GameConstants;

public class ModifyInventory {
    private /* synthetic */ boolean d;
    private final /* synthetic */ int k;
    private /* synthetic */ short ALLATORIxDEMO;
    private /* synthetic */ short a;
    private /* synthetic */ IItem K;

    public /* synthetic */ ModifyInventory(int a2, IItem a3, short a4) {
        ModifyInventory a5;
        ModifyInventory modifyInventory = a5;
        ModifyInventory modifyInventory2 = a5;
        modifyInventory2.d = false;
        modifyInventory2.k = a2;
        modifyInventory.K = a3.copy();
        modifyInventory.a = a4;
    }

    public /* synthetic */ ModifyInventory(int a2, IItem a3) {
        ModifyInventory a4;
        ModifyInventory modifyInventory = a4;
        a4.k = a2;
        modifyInventory.K = a3.copy();
        modifyInventory.d = false;
    }

    public /* synthetic */ short getIndicator() {
        ModifyInventory a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ short getOldPosition() {
        ModifyInventory a2;
        return a2.a;
    }

    public /* synthetic */ boolean switchSrcDst() {
        ModifyInventory a2;
        return a2.d;
    }

    public final /* synthetic */ short getQuantity() {
        ModifyInventory a2;
        return a2.K.getQuantity();
    }

    public final /* synthetic */ IItem getItem() {
        ModifyInventory a2;
        return a2.K;
    }

    public /* synthetic */ ModifyInventory(int a2, IItem a3, short a4, short a5, boolean a6) {
        ModifyInventory a7;
        ModifyInventory modifyInventory = a7;
        ModifyInventory modifyInventory2 = a7;
        a7.k = a2;
        modifyInventory2.K = a3.copy();
        modifyInventory2.a = a4;
        modifyInventory.d = a6;
        modifyInventory.ALLATORIxDEMO = a5;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ int getMode() {
        ModifyInventory a2;
        if ((a2.getInventoryType() == 2 || a2.getInventoryType() == 3 || a2.getInventoryType() == 4) && a2.K.getPosition() > 10000) {
            switch (a2.k) {
                case 0: {
                    return 9;
                }
                case 1: {
                    return 6;
                }
                case 2: {
                    return 5;
                }
                case 3: {
                    return 7;
                }
            }
        }
        return a2.k;
    }

    public final /* synthetic */ short getPosition() {
        ModifyInventory a2;
        return a2.K.getPosition();
    }

    public final /* synthetic */ int getInventoryType() {
        ModifyInventory a2;
        return GameConstants.getInventoryType(a2.K.getItemId()).getType();
    }

    public final /* synthetic */ void clear() {
        a.K = null;
    }

    public static class Types {
        public static final /* synthetic */ int ADD = 0;
        public static final /* synthetic */ int REMOVE_IN_BAG = 7;
        public static final /* synthetic */ int UPDATE_IN_BAG = 6;
        public static final /* synthetic */ int MOVE_TO_BAG = 5;
        public static final /* synthetic */ int ADD_IN_BAG = 9;
        public static final /* synthetic */ int UPDATE = 1;
        public static final /* synthetic */ int REMOVE = 3;
        public static final /* synthetic */ int MOVE_IN_BAG = 8;
        public static final /* synthetic */ int MOVE = 2;

        public /* synthetic */ Types() {
            Types a2;
        }
    }
}

