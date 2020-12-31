/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.ISkill;
import client.MapleCharacter;
import client.SkillFactory;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.SkillConstants;
import java.awt.Point;
import java.util.List;
import server.AutobanManager;
import server.MapleStatEffect;
import tools.AttackPair;
import tools.FileoutputUtil;
import tools.googledrive.SyncServerData;

public class AttackInfo {
    public /* synthetic */ byte targets;
    public /* synthetic */ byte speed;
    public /* synthetic */ byte tbyte;
    public /* synthetic */ int display;
    public /* synthetic */ int charge;
    public /* synthetic */ byte csstar;
    public /* synthetic */ int skill;
    public /* synthetic */ byte hits;
    public /* synthetic */ Point position;
    public /* synthetic */ List<AttackPair> allDamage;
    public /* synthetic */ byte direction;
    public /* synthetic */ byte AOE;
    public /* synthetic */ int animation;
    public /* synthetic */ int lastAttackTickCount;
    public /* synthetic */ byte slot;
    public /* synthetic */ Point skillposition;
    public /* synthetic */ boolean real;

    public /* synthetic */ AttackInfo() {
        AttackInfo a2;
        a2.real = true;
    }

    public final /* synthetic */ MapleStatEffect getAttackEffect135(MapleCharacter a2, int a3, ISkill a4) {
        int n2;
        AttackInfo attackInfo;
        AttackInfo a5;
        if (SkillConstants.is\u6b66\u9675\u9053\u5834\u6280\u80fd(a5.skill) || SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(a5.skill) || SkillConstants.is\u5de8\u5927\u85e5\u6c34\u6280\u80fd(a5.skill)) {
            a3 = 1;
            attackInfo = a5;
        } else {
            if (a3 <= 0) {
                return null;
            }
            attackInfo = a5;
        }
        AttackInfo attackInfo2 = a5;
        int n3 = n2 = (attackInfo.display & 0x8000) != 0 ? attackInfo2.display - 32768 : attackInfo2.display;
        if (GameConstants.isLinkedAranSkill(a5.skill)) {
            ISkill iSkill = SkillFactory.getSkill(a5.skill);
            if (n2 > SkillFactory.Delay.magic6.i && n2 != SkillFactory.Delay.shot.i && n2 != SkillFactory.Delay.fist.i && (iSkill.getAnimation() == -1 || Math.abs(iSkill.getAnimation() - n2) > 16)) {
                if (iSkill.getAnimation() == -1) {
                    a2.dropMessage(5, "Please report this: animation for skill " + iSkill.getId() + " doesn't exist");
                } else {
                    AutobanManager.getInstance().autoban(a2.getClient(), "No delay hack, SkillID : " + iSkill.getId() + ", animation: " + n2 + ", expected: " + iSkill.getAnimation());
                }
                return null;
            }
            return iSkill.getEffect(a3);
        }
        return a4.getEffect(a3);
    }

    public final /* synthetic */ MapleStatEffect getAttackEffect(MapleCharacter a2, int a3, ISkill a4) {
        AttackInfo attackInfo;
        AttackInfo a5;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            return a5.getAttackEffect135(a2, a3, a4);
        }
        if (SkillConstants.is\u6b66\u9675\u9053\u5834\u6280\u80fd(a5.skill) || SkillConstants.is\u91d1\u5b57\u5854\u6280\u80fd(a5.skill)) {
            a3 = 1;
            attackInfo = a5;
        } else {
            if (a3 <= 0) {
                return null;
            }
            attackInfo = a5;
        }
        if (SkillConstants.isLinkedSkill(attackInfo.skill)) {
            AttackInfo attackInfo2 = a5;
            ISkill iSkill = SkillFactory.getSkill(attackInfo2.skill);
            if (attackInfo2.display > 80 && !iSkill.hasAction()) {
                AutobanManager.getInstance().autoban(a2.getClient(), "\u653b\u64ca\u7121\u5ef6\u9072\uff0c\u6280\u80fdID\uff1a : " + a5.skill);
                return null;
            }
            return iSkill.getEffect(a3);
        }
        if (a5.skill != a4.getId()) {
            FileoutputUtil.logToFile(SyncServerData.ALLATORIxDEMO("\u0019e\u0012yZN\u0014~\u0014%4~\u0001k\u0016a0l\u0013o\u0016~[~\r~"), FileoutputUtil.NowTime() + " \u9023\u7d50\u6280\u80fd[" + a5.skill + "](" + a4.getId() + "\u50b3\u627f) \u9023\u7d50\u6280\u80fd\u7b49\u7d1a:" + a3 + " \u4e0d\u5728getLinkedkill\u6e05\u55ae\u5167\u537b\u88ab\u89f8\u767c, \u89f8\u767c\u8005: " + a2.getName() + " \u8077\u696d: " + a2.getJob() + " \u7b49\u7d1a: " + a2.getLevel() + "\r\n");
        }
        if (a5.display > 80 && !a4.hasAction()) {
            AutobanManager.getInstance().autoban(a2.getClient(), "\u653b\u64ca\u7121\u5ef6\u9072\uff0c\u6280\u80fdID\uff1a " + a5.skill);
            return null;
        }
        return a4.getEffect(a3);
    }
}

