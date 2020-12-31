/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.MapleCharacter;
import java.util.Map;

public interface MapleCharacterLook {
    public /* synthetic */ int getFace();

    public /* synthetic */ int getFaceMarking();

    public /* synthetic */ byte getSkinColor();

    public /* synthetic */ int getHair();

    public /* synthetic */ Map<Byte, Integer> getTotems();

    public /* synthetic */ short getJob();

    public /* synthetic */ boolean isElfEar(MapleCharacter var1);

    public /* synthetic */ byte getGender();

    public /* synthetic */ Map<Byte, Integer> getEquips();
}

