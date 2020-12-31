/*
 * Decompiled with CFR 0.150.
 */
package client.innerSkills;

import client.SkillFactory;
import client.innerSkills.InnerSkillValueHolder;
import constants.SkillConstants;
import server.Randomizer;

public class InnerAbillity {
    private static /* synthetic */ InnerAbillity ALLATORIxDEMO;

    public /* synthetic */ int getCirculatorRank(int a2) {
        return a2 % 1000 / 100 + 1;
    }

    public /* synthetic */ InnerAbillity() {
        InnerAbillity a2;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = null;
    }

    public /* synthetic */ InnerSkillValueHolder renewSkill(int a2, int a3, boolean a4) {
        InnerAbillity a5;
        return a5.renewSkill(a2, a3, false, a4);
    }

    public static /* synthetic */ InnerAbillity getInstance() {
        if (ALLATORIxDEMO == null) {
            ALLATORIxDEMO = new InnerAbillity();
        }
        return ALLATORIxDEMO;
    }

    public /* synthetic */ InnerSkillValueHolder renewSkill(int a2, int a3, boolean a4, boolean a5) {
        int n2;
        if (a4 != 0 && a3 == 2701000) {
            a4 = SkillConstants.getInnerSkillbyRank(3)[(int)Math.floor(Math.random() * (double)SkillConstants.getInnerSkillbyRank(a2).length)];
            int n3 = Randomizer.nextInt(100);
            int n4 = n3 < 38 ? Randomizer.rand(SkillFactory.getSkill(a4).getMaxLevel() / 2, SkillFactory.getSkill(a4).getMaxLevel()) : (n3 < 70 ? Randomizer.rand(SkillFactory.getSkill(a4).getMaxLevel() / 3, SkillFactory.getSkill(a4).getMaxLevel() / 2) : Randomizer.rand(SkillFactory.getSkill(a4).getMaxLevel() / 4, SkillFactory.getSkill(a4).getMaxLevel() / 3));
            int n5 = a4;
            return new InnerSkillValueHolder(n5, (byte)n4, SkillFactory.getSkill(n5).getMaxLevel(), 3, a5);
        }
        a4 = 0;
        if (a3 == -1) {
            a4 = 10;
        } else {
            InnerAbillity a6;
            n2 = a6.getCirculatorRank(a3);
            if (n2 == 0) {
                a4 = 10;
            } else if (n2 == 1) {
                a4 = 20;
            } else if (n2 == 2) {
                a4 = 30;
            } else if (n2 == 3) {
                a4 = 35;
            } else if (n2 == 4) {
                a4 = 40;
            } else if (n2 == 5) {
                a4 = 45;
            } else if (n2 == 6) {
                a4 = 50;
            } else if (n2 == 7) {
                a4 = 55;
            } else if (n2 == 8) {
                a4 = 60;
            } else if (n2 == 9) {
                a4 = 65;
            } else if (n2 == 10) {
                a4 = 70;
            }
        }
        n2 = SkillConstants.getInnerSkillbyRank(Randomizer.isSuccess(3 + a4) ? (a2 = 1) : (Randomizer.isSuccess(2 + a4 / 2) ? (a2 = 2) : (Randomizer.isSuccess(1 + a4 / 4) ? (a2 = 3) : (a2 = 0))))[(int)Math.floor(Math.random() * (double)SkillConstants.getInnerSkillbyRank(a2).length)];
        int n6 = Randomizer.nextInt(100);
        a3 = n6 < 3 + a4 / 2 ? Randomizer.rand(SkillFactory.getSkill(n2).getMaxLevel() / 2, SkillFactory.getSkill(n2).getMaxLevel()) : (n6 < a4 ? Randomizer.rand(SkillFactory.getSkill(n2).getMaxLevel() / 3, SkillFactory.getSkill(n2).getMaxLevel() / 2) : Randomizer.rand(SkillFactory.getSkill(n2).getMaxLevel() / 4, SkillFactory.getSkill(n2).getMaxLevel() / 3));
        int n7 = n2;
        return new InnerSkillValueHolder(n7, (byte)a3, SkillFactory.getSkill(n7).getMaxLevel(), (byte)a2, a5);
    }
}

