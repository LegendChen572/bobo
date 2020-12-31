/*
 * Decompiled with CFR 0.150.
 */
package client;

import server.MapleStatEffect;
import server.life.Element;

public interface ISkill {
    public /* synthetic */ MapleStatEffect getPVPEffect(int var1);

    public /* synthetic */ boolean isTimeLimited();

    public /* synthetic */ int getTrueMax();

    public /* synthetic */ int getId();

    public /* synthetic */ int getPsdSkill();

    public /* synthetic */ boolean hasAction();

    public /* synthetic */ int getPsd();

    public /* synthetic */ boolean isPush();

    public /* synthetic */ int getRequiredSkillId();

    public /* synthetic */ String getPsdDamR();

    public /* synthetic */ byte getMaxLevel();

    public /* synthetic */ int getAnimationTime();

    public /* synthetic */ int getReqLevel();

    public /* synthetic */ String getName();

    public /* synthetic */ boolean hasRequiredSkill();

    public /* synthetic */ boolean isPull();

    public /* synthetic */ boolean isSkillNeedMasterLevel();

    public /* synthetic */ boolean isHyperStat();

    public /* synthetic */ int getAnimation();

    public /* synthetic */ boolean isPVPDisabled();

    public /* synthetic */ int getvehicleID();

    public /* synthetic */ int getMasterLevel();

    public /* synthetic */ boolean isMovement();

    public /* synthetic */ boolean isInvisible();

    public /* synthetic */ boolean isLinkSkills();

    public /* synthetic */ boolean isGuildSkill();

    public /* synthetic */ boolean isHyperSkill();

    public /* synthetic */ int getRequiredSkillLevel();

    public /* synthetic */ boolean isSpecialSkill();

    public /* synthetic */ int getTamingMob();

    public /* synthetic */ boolean isTeachSkills();

    public /* synthetic */ boolean isChargeSkill();

    public /* synthetic */ MapleStatEffect getEffect(int var1);

    public /* synthetic */ Element getElement();

    public /* synthetic */ int getHyper();

    public /* synthetic */ boolean isFourthJob();

    public /* synthetic */ boolean isMagic();

    public /* synthetic */ boolean canBeLearnedBy(int var1);

    public /* synthetic */ int getSkillTamingMob();

    public /* synthetic */ boolean isZeroSkill(int var1);

    public /* synthetic */ boolean isBeginnerSkill();
}

