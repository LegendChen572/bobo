/*
 * Decompiled with CFR 0.150.
 */
package client.innerSkills;

public class InnerSkillValueHolder {
    private /* synthetic */ byte d;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ int k;
    private /* synthetic */ byte K;
    private /* synthetic */ byte a;

    public /* synthetic */ byte getRank() {
        InnerSkillValueHolder a2;
        return a2.d;
    }

    public /* synthetic */ int getSkillId() {
        InnerSkillValueHolder a2;
        return a2.k;
    }

    public /* synthetic */ boolean isLocked() {
        InnerSkillValueHolder a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ byte getSkillLevel() {
        InnerSkillValueHolder a2;
        return a2.K;
    }

    public /* synthetic */ byte getMaxLevel() {
        InnerSkillValueHolder a2;
        return a2.a;
    }

    public /* synthetic */ InnerSkillValueHolder(int a2, byte a3, byte a4, byte a5, boolean a6) {
        InnerSkillValueHolder a7;
        InnerSkillValueHolder innerSkillValueHolder = a7;
        InnerSkillValueHolder innerSkillValueHolder2 = a7;
        InnerSkillValueHolder innerSkillValueHolder3 = a7;
        InnerSkillValueHolder innerSkillValueHolder4 = a7;
        InnerSkillValueHolder innerSkillValueHolder5 = a7;
        innerSkillValueHolder5.k = 0;
        innerSkillValueHolder5.K = 0;
        innerSkillValueHolder4.a = 0;
        innerSkillValueHolder4.d = 0;
        innerSkillValueHolder3.ALLATORIxDEMO = 0;
        innerSkillValueHolder3.k = a2;
        innerSkillValueHolder2.K = a3;
        innerSkillValueHolder2.a = a4;
        innerSkillValueHolder.d = a5;
        innerSkillValueHolder.ALLATORIxDEMO = a6;
    }
}

