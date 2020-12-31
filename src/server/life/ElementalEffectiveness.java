/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import handling.channel.handler.BuddyListHandler;
import server.MapleSquad;

public final class ElementalEffectiveness
extends Enum<ElementalEffectiveness> {
    public static final /* synthetic */ /* enum */ ElementalEffectiveness IMMUNE;
    public static final /* synthetic */ /* enum */ ElementalEffectiveness STRONG;
    public static final /* synthetic */ /* enum */ ElementalEffectiveness WEAK;
    public static final /* synthetic */ /* enum */ ElementalEffectiveness NORMAL;
    private static final /* synthetic */ ElementalEffectiveness[] ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ ElementalEffectiveness getByNumber(int a2) {
        switch (a2) {
            case 1: {
                return IMMUNE;
            }
            case 2: {
                return STRONG;
            }
            case 3: {
                return WEAK;
            }
        }
        throw new IllegalArgumentException("Unkown effectiveness: " + a2);
    }

    public static /* synthetic */ ElementalEffectiveness valueOf(String a2) {
        return Enum.valueOf(ElementalEffectiveness.class, a2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ ElementalEffectiveness() {
        void var2_-1;
        void var1_-1;
        ElementalEffectiveness a2;
    }

    public static /* synthetic */ {
        NORMAL = new ElementalEffectiveness(MapleSquad.ALLATORIxDEMO("[CGAT@"), 0);
        IMMUNE = new ElementalEffectiveness(BuddyListHandler.ALLATORIxDEMO(">w:o9\u007f"), 1);
        STRONG = new ElementalEffectiveness(MapleSquad.ALLATORIxDEMO("FXGC[K"), 2);
        WEAK = new ElementalEffectiveness(BuddyListHandler.ALLATORIxDEMO(" \u007f6q"), 3);
        ElementalEffectiveness[] arrelementalEffectiveness = new ElementalEffectiveness[4];
        arrelementalEffectiveness[0] = NORMAL;
        arrelementalEffectiveness[1] = IMMUNE;
        arrelementalEffectiveness[2] = STRONG;
        arrelementalEffectiveness[3] = WEAK;
        ALLATORIxDEMO = arrelementalEffectiveness;
    }

    public static /* synthetic */ ElementalEffectiveness[] values() {
        return (ElementalEffectiveness[])ALLATORIxDEMO.clone();
    }
}

