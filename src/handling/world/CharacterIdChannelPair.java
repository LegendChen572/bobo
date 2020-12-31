/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CharacterIdChannelPair
implements Externalizable,
Comparable<CharacterIdChannelPair> {
    private /* synthetic */ int d;
    private /* synthetic */ int ALLATORIxDEMO;

    @Override
    public /* synthetic */ void readExternal(ObjectInput a2) throws IOException, ClassNotFoundException {
        CharacterIdChannelPair a3;
        CharacterIdChannelPair characterIdChannelPair = a3;
        characterIdChannelPair.d = a2.readInt();
        characterIdChannelPair.ALLATORIxDEMO = a2.readByte();
    }

    public /* synthetic */ CharacterIdChannelPair(int a2, int a3) {
        CharacterIdChannelPair a4;
        CharacterIdChannelPair characterIdChannelPair = a4;
        CharacterIdChannelPair characterIdChannelPair2 = a4;
        characterIdChannelPair2.d = 0;
        characterIdChannelPair2.ALLATORIxDEMO = 1;
        characterIdChannelPair.d = a2;
        characterIdChannelPair.ALLATORIxDEMO = a3;
    }

    @Override
    public /* synthetic */ int compareTo(CharacterIdChannelPair a2) {
        CharacterIdChannelPair a3;
        return a3.ALLATORIxDEMO - a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getCharacterId() {
        CharacterIdChannelPair a2;
        return a2.d;
    }

    public /* synthetic */ CharacterIdChannelPair() {
        CharacterIdChannelPair a2;
        CharacterIdChannelPair characterIdChannelPair = a2;
        characterIdChannelPair.d = 0;
        characterIdChannelPair.ALLATORIxDEMO = 1;
    }

    @Override
    public /* synthetic */ void writeExternal(ObjectOutput a2) throws IOException {
        CharacterIdChannelPair a3;
        ObjectOutput objectOutput = a2;
        objectOutput.writeInt(a3.d);
        objectOutput.writeByte(a3.ALLATORIxDEMO);
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 5 << 1;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ 3 << 1;
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ 1;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public /* synthetic */ int getChannel() {
        CharacterIdChannelPair a2;
        return a2.ALLATORIxDEMO;
    }
}

