/*
 * Decompiled with CFR 0.150.
 */
package client;

import java.io.Serializable;

public class SkillMacro
implements Serializable {
    private /* synthetic */ int g;
    private static final /* synthetic */ long E = -63413738569L;
    private /* synthetic */ int d;
    private /* synthetic */ int B;
    private /* synthetic */ int k;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int K;
    private /* synthetic */ String a;

    public /* synthetic */ int getSkill3() {
        SkillMacro a2;
        return a2.K;
    }

    public /* synthetic */ void setMacroId(int a2) {
        a.g = a2;
    }

    public /* synthetic */ int getShout() {
        SkillMacro a2;
        return a2.d;
    }

    public /* synthetic */ String getName() {
        SkillMacro a2;
        return a2.a;
    }

    public /* synthetic */ void setSkill3(int a2) {
        a.K = a2;
    }

    public /* synthetic */ int getPosition() {
        SkillMacro a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ SkillMacro(int a2, int a3, int a4, String a5, int a6, int a7) {
        SkillMacro a8;
        SkillMacro skillMacro = a8;
        SkillMacro skillMacro2 = a8;
        SkillMacro skillMacro3 = a8;
        skillMacro3.B = a2;
        skillMacro3.k = a3;
        skillMacro2.K = a4;
        skillMacro2.a = a5;
        skillMacro.d = a6;
        skillMacro.ALLATORIxDEMO = a7;
    }

    public /* synthetic */ int getMacroId() {
        SkillMacro a2;
        return a2.g;
    }

    public /* synthetic */ int getSkill2() {
        SkillMacro a2;
        return a2.k;
    }

    public /* synthetic */ void setSkill1(int a2) {
        a.B = a2;
    }

    public /* synthetic */ int getSkill1() {
        SkillMacro a2;
        return a2.B;
    }

    public /* synthetic */ void setShout(int a2) {
        a.d = a2;
    }

    public /* synthetic */ void setSkill2(int a2) {
        a.k = a2;
    }

    public /* synthetic */ void setPosition(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void setName(String a2) {
        a.a = a2;
    }
}

