/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.MapleLieDetector;
import client.inventory.IItem;
import client.inventory.MapleAndroid;
import client.messages.commands.GMCommand;

public interface IEquip
extends IItem {
    public static final /* synthetic */ int ARMOR_RATIO = 350000;
    public static final /* synthetic */ int WEAPON_RATIO = 700000;

    public /* synthetic */ int getPotential5();

    public /* synthetic */ int getExpPercentage();

    public /* synthetic */ int getBaseLevel();

    public /* synthetic */ short getWdef();

    public /* synthetic */ MapleAndroid getAndroid();

    public /* synthetic */ int getPotential2();

    public /* synthetic */ void setPotential2(int var1);

    public /* synthetic */ int getIncSkill();

    public /* synthetic */ void setPotential1(int var1);

    public /* synthetic */ int getPotential1();

    public /* synthetic */ byte getUpgradeSlots();

    public /* synthetic */ short getHpR();

    public /* synthetic */ void setPotential6(int var1);

    public /* synthetic */ short getMdef();

    public /* synthetic */ int getPotential4();

    public /* synthetic */ int getEquipExp();

    public /* synthetic */ short getPVPDamage();

    public /* synthetic */ byte getLevel();

    public /* synthetic */ short getSpeed();

    public /* synthetic */ byte getStateAdd();

    public /* synthetic */ int getItemEXP();

    public /* synthetic */ short getMp();

    public /* synthetic */ byte getViciousHammer();

    public /* synthetic */ void setPotential3(int var1);

    public /* synthetic */ short getJump();

    public /* synthetic */ void setPotential5(int var1);

    public /* synthetic */ short getStr();

    public /* synthetic */ int getDurability();

    public /* synthetic */ short getCharmEXP();

    public /* synthetic */ short getLuk();

    public /* synthetic */ int getEquipExpForLevel();

    public /* synthetic */ short getInt();

    public /* synthetic */ short getAcc();

    public /* synthetic */ short getAvoid();

    public /* synthetic */ byte getState();

    public /* synthetic */ byte getEnhance();

    public /* synthetic */ int getEquipLevel();

    public /* synthetic */ short getHands();

    public /* synthetic */ int getPotential6();

    public /* synthetic */ byte getReqLevel();

    public /* synthetic */ short getWatk();

    public /* synthetic */ short getMatk();

    public /* synthetic */ void setPotential4(int var1);

    public /* synthetic */ short getDex();

    public /* synthetic */ int getPotential3();

    public /* synthetic */ short getMpR();

    public /* synthetic */ short getHp();

    public static final class ScrollResult
    extends Enum<ScrollResult> {
        public static final /* synthetic */ /* enum */ ScrollResult CURSE;
        public static final /* synthetic */ /* enum */ ScrollResult SUCCESS;
        private static final /* synthetic */ ScrollResult[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ ScrollResult FAIL;

        public static /* synthetic */ {
            SUCCESS = new ScrollResult(MapleLieDetector.ALLATORIxDEMO("nj~|xln"), 0);
            FAIL = new ScrollResult(GMCommand.ALLATORIxDEMO("t#{."), 1);
            CURSE = new ScrollResult(MapleLieDetector.ALLATORIxDEMO("~jolx"), 2);
            ScrollResult[] arrscrollResult = new ScrollResult[3];
            arrscrollResult[0] = SUCCESS;
            arrscrollResult[1] = FAIL;
            arrscrollResult[2] = CURSE;
            ALLATORIxDEMO = arrscrollResult;
        }

        public static /* synthetic */ ScrollResult valueOf(String a2) {
            return Enum.valueOf(ScrollResult.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ ScrollResult() {
            void var2_-1;
            void var1_-1;
            ScrollResult a2;
        }

        public static /* synthetic */ ScrollResult[] values() {
            return (ScrollResult[])ALLATORIxDEMO.clone();
        }
    }
}

