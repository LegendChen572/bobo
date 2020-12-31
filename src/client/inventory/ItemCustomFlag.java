/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import handling.channel.handler.PetHandler;
import handling.world.CharacterTransfer;

public final class ItemCustomFlag
extends Enum<ItemCustomFlag> {
    public static final /* synthetic */ /* enum */ ItemCustomFlag \u7121\u6cd5\u8ca9\u8ce3\u5546\u5e97;
    private final /* synthetic */ int d;
    public static final /* synthetic */ /* enum */ ItemCustomFlag \u5c08\u5c6c\u9053\u5177;
    private static final /* synthetic */ ItemCustomFlag[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ ItemCustomFlag \u7121\u6cd5\u4e1f\u68c4;
    public static final /* synthetic */ /* enum */ ItemCustomFlag \u7121\u6cd5\u653e\u5165\u5009\u5eab;
    public static final /* synthetic */ /* enum */ ItemCustomFlag \u7121\u6cd5\u4ea4\u6613;

    public final /* synthetic */ boolean check(int a2) {
        ItemCustomFlag a3;
        return (a2 & a3.d) == a3.d;
    }

    public static /* synthetic */ {
        \u7121\u6cd5\u4ea4\u6613 = new ItemCustomFlag(PetHandler.ALLATORIxDEMO("\u714f\u6cd4\u4eca\u6612"), 0, 1);
        \u7121\u6cd5\u4e1f\u68c4 = new ItemCustomFlag(CharacterTransfer.ALLATORIxDEMO("\u7127\u6ce3\u4e19\u68f2"), 1, 2);
        \u5c08\u5c6c\u9053\u5177 = new ItemCustomFlag(PetHandler.ALLATORIxDEMO("\u5c66\u5c6d\u903d\u5176"), 2, 4);
        \u7121\u6cd5\u653e\u5165\u5009\u5eab = new ItemCustomFlag(CharacterTransfer.ALLATORIxDEMO("\u7127\u6ce3\u6538\u5153\u500f\u5e9d"), 3, 8);
        \u7121\u6cd5\u8ca9\u8ce3\u5546\u5e97 = new ItemCustomFlag(PetHandler.ALLATORIxDEMO("\u714f\u6cd4\u8cc7\u8ce2\u5528\u5e96"), 4, 16);
        ItemCustomFlag[] arritemCustomFlag = new ItemCustomFlag[5];
        arritemCustomFlag[0] = \u7121\u6cd5\u4ea4\u6613;
        arritemCustomFlag[1] = \u7121\u6cd5\u4e1f\u68c4;
        arritemCustomFlag[2] = \u5c08\u5c6c\u9053\u5177;
        arritemCustomFlag[3] = \u7121\u6cd5\u653e\u5165\u5009\u5eab;
        arritemCustomFlag[4] = \u7121\u6cd5\u8ca9\u8ce3\u5546\u5e97;
        ALLATORIxDEMO = arritemCustomFlag;
    }

    public static /* synthetic */ ItemCustomFlag[] values() {
        return (ItemCustomFlag[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ ItemCustomFlag valueOf(String a2) {
        return Enum.valueOf(ItemCustomFlag.class, a2);
    }

    public final /* synthetic */ int getValue() {
        ItemCustomFlag a2;
        return a2.d;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ItemCustomFlag(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        ItemCustomFlag a3;
        a3.d = a2;
    }
}

