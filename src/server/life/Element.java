/*
 * Decompiled with CFR 0.150.
 */
package server.life;

import constants.SpecialSkillConstants;
import tools.wztosql.DumpMobName;

public final class Element
extends Enum<Element> {
    private static final /* synthetic */ Element[] ALLATORIxDEMO;
    public static final /* synthetic */ /* enum */ Element NEUTRAL;
    public static final /* synthetic */ /* enum */ Element LIGHTING;
    private /* synthetic */ boolean d;
    public static final /* synthetic */ /* enum */ Element ICE;
    public static final /* synthetic */ /* enum */ Element HOLY;
    private /* synthetic */ int a;
    public static final /* synthetic */ /* enum */ Element PHYSICAL;
    public static final /* synthetic */ /* enum */ Element DARKNESS;
    public static final /* synthetic */ /* enum */ Element FIRE;
    public static final /* synthetic */ /* enum */ Element POISON;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private /* synthetic */ Element(int n2) {
        void a2;
        void var2_-1;
        void var1_-1;
        Element a3;
        Element element = a3;
        element.d = false;
        element.a = a2;
    }

    public /* synthetic */ int getValue() {
        Element a2;
        return a2.a;
    }

    public static /* synthetic */ Element[] values() {
        return (Element[])ALLATORIxDEMO.clone();
    }

    public static /* synthetic */ {
        NEUTRAL = new Element(DumpMobName.ALLATORIxDEMO("[\u0015@\u0004G\u0011Y"), 0, 0);
        PHYSICAL = new Element(SpecialSkillConstants.ALLATORIxDEMO("\"\u007f+d;t3{"), 1, 1);
        FIRE = new Element(DumpMobName.ALLATORIxDEMO("\u0016\\\u0002P"), 2, 2, true);
        ICE = new Element(SpecialSkillConstants.ALLATORIxDEMO("~1r"), 3, 3, true);
        LIGHTING = new Element(DumpMobName.ALLATORIxDEMO("\u001c\\\u0017]\u0004\\\u001eR"), 4, 4);
        POISON = new Element(SpecialSkillConstants.ALLATORIxDEMO("\"x;d=y"), 5, 5);
        HOLY = new Element(DumpMobName.ALLATORIxDEMO("\u0018Z\u001cL"), 6, 6, true);
        DARKNESS = new Element(SpecialSkillConstants.ALLATORIxDEMO("6v |<r!d"), 7, 7);
        Element[] arrelement = new Element[8];
        arrelement[0] = NEUTRAL;
        arrelement[1] = PHYSICAL;
        arrelement[2] = FIRE;
        arrelement[3] = ICE;
        arrelement[4] = LIGHTING;
        arrelement[5] = POISON;
        arrelement[6] = HOLY;
        arrelement[7] = DARKNESS;
        ALLATORIxDEMO = arrelement;
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ Element(int n22, boolean n22) {
        void a2;
        void a3;
        void var2_-1;
        void var1_-1;
        Element a4;
        Element element = a4;
        a4.d = false;
        element.a = a3;
        element.d = a2;
    }

    public static /* synthetic */ Element getFromId(int a2) {
        int n2;
        Element[] arrelement = Element.values();
        int n3 = arrelement.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            Element element = arrelement[n2];
            if (element.a == a2) {
                return element;
            }
            n4 = ++n2;
        }
        throw new IllegalArgumentException("unknown elemnt id " + a2);
    }

    public static /* synthetic */ Element valueOf(String a2) {
        return Enum.valueOf(Element.class, a2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ Element getFromChar(char a2) {
        switch (Character.toUpperCase(a2)) {
            case 'F': {
                return FIRE;
            }
            case 'I': {
                return ICE;
            }
            case 'L': {
                return LIGHTING;
            }
            case 'S': {
                return POISON;
            }
            case 'H': {
                return HOLY;
            }
            case 'P': {
                return PHYSICAL;
            }
            case 'D': {
                return DARKNESS;
            }
        }
        throw new IllegalArgumentException("unknown elemnt char " + a2);
    }

    public /* synthetic */ boolean isSpecial() {
        Element a2;
        return a2.d;
    }
}

