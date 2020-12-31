/*
 * Decompiled with CFR 0.150.
 */
package server.characterCards;

public class CardData {
    public final /* synthetic */ short job;
    public final /* synthetic */ int chrId;
    public final /* synthetic */ short level;

    public /* synthetic */ CardData(int a2, short a3, short a4) {
        CardData a5;
        CardData cardData = a5;
        a5.chrId = a2;
        cardData.job = a4;
        cardData.level = a3;
    }

    public /* synthetic */ String toString() {
        CardData a2;
        CardData cardData = a2;
        return "\u89d2\u8272ID: " + cardData.chrId + " \u8077\u696dID: " + cardData.job + " \u7b49\u7d1a: " + a2.level;
    }

    public /* synthetic */ int getCharacterLevel() {
        CardData a2;
        return a2.level;
    }

    public /* synthetic */ int getCharacterId() {
        CardData a2;
        return a2.chrId;
    }

    public /* synthetic */ int getCharacterJob() {
        CardData a2;
        return a2.job;
    }
}

