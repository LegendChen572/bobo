/*
 * Decompiled with CFR 0.150.
 */
package handling.world.guild;

import java.io.Serializable;

public class MapleGuildSkill
implements Serializable {
    public static final /* synthetic */ long serialVersionUID = 3565477792055301248L;
    public /* synthetic */ int skillID;
    public /* synthetic */ int level;
    public /* synthetic */ String purchaser;
    public /* synthetic */ long timestamp;
    public /* synthetic */ String activator;

    public /* synthetic */ MapleGuildSkill(int a2, int a3, long a4, String a5, String a6) {
        MapleGuildSkill a7;
        MapleGuildSkill mapleGuildSkill = a7;
        MapleGuildSkill mapleGuildSkill2 = a7;
        a7.timestamp = a4;
        mapleGuildSkill2.skillID = a2;
        mapleGuildSkill2.level = a3;
        mapleGuildSkill.purchaser = a5;
        mapleGuildSkill.activator = a6;
    }
}

