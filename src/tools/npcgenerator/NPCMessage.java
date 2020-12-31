/*
 * Decompiled with CFR 0.150.
 */
package tools.npcgenerator;

import FuckingHackerToby.L;
import java.util.List;
import tools.npcgenerator.Condition;
import tools.npcgenerator.Instruction;

public class NPCMessage {
    private /* synthetic */ int g;
    private /* synthetic */ int E;
    private /* synthetic */ byte k;
    private /* synthetic */ L ALLATORIxDEMO;
    private /* synthetic */ List<Instruction> a;
    private /* synthetic */ String K;
    private /* synthetic */ List<Condition> d;
    private /* synthetic */ int B;

    public /* synthetic */ int getMessageType() {
        NPCMessage a2;
        return a2.g;
    }

    public /* synthetic */ byte getMessageButtons() {
        NPCMessage a2;
        return a2.k;
    }

    public /* synthetic */ void setMessage(String a2) {
        a.K = a2;
    }

    public /* synthetic */ int getMessageChainId() {
        NPCMessage a2;
        return a2.E;
    }

    public /* synthetic */ void setPlayer(L a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void setInstructions(List<Instruction> a2) {
        a.a = a2;
    }

    public /* synthetic */ void setMessageChainId(int a2) {
        a.E = a2;
    }

    public /* synthetic */ void setSelectedOption(int a2) {
        a.B = a2;
    }

    public /* synthetic */ void setMessageType(int a2) {
        a.g = a2;
    }

    public /* synthetic */ List<Instruction> getInstructions() {
        NPCMessage a2;
        return a2.a;
    }

    public /* synthetic */ List<Condition> getConditions() {
        NPCMessage a2;
        return a2.d;
    }

    public /* synthetic */ void setMessageButtons(byte a2) {
        a.k = a2;
    }

    public /* synthetic */ L getPlayer() {
        NPCMessage a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ NPCMessage(int a2, L a3, int a4, String a5, byte a6, int a7, List<Instruction> a8, List<Condition> a9) {
        NPCMessage a10;
        NPCMessage nPCMessage = a10;
        NPCMessage nPCMessage2 = a10;
        NPCMessage nPCMessage3 = a10;
        NPCMessage nPCMessage4 = a10;
        nPCMessage4.E = a2;
        nPCMessage4.ALLATORIxDEMO = a3;
        nPCMessage3.g = a4;
        nPCMessage3.K = a5;
        nPCMessage2.k = a6;
        nPCMessage2.a = a8;
        nPCMessage.B = a7;
        nPCMessage.d = a9;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ (3 << 2 ^ 1);
        int cfr_ignored_0 = 4 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = (2 ^ 5) << 4 ^ 1 << 1;
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

    public /* synthetic */ String getMessage() {
        NPCMessage a2;
        return a2.K;
    }

    public /* synthetic */ void setConditions(List<Condition> a2) {
        a.d = a2;
    }

    public /* synthetic */ int getSelectedOption() {
        NPCMessage a2;
        return a2.B;
    }
}

