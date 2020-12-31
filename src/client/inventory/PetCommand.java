/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

public class PetCommand {
    private final /* synthetic */ int ALLATORIxDEMO;
    private final /* synthetic */ int a;
    private final /* synthetic */ int K;
    private final /* synthetic */ int d;

    public /* synthetic */ int getPetId() {
        PetCommand a2;
        return a2.K;
    }

    public /* synthetic */ PetCommand(int a2, int a3, int a4, int a5) {
        PetCommand a6;
        PetCommand petCommand = a6;
        PetCommand petCommand2 = a6;
        petCommand2.K = a2;
        petCommand2.a = a3;
        petCommand.d = a4;
        petCommand.ALLATORIxDEMO = a5;
    }

    public /* synthetic */ int getIncrease() {
        PetCommand a2;
        return a2.ALLATORIxDEMO;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 3 << 3 ^ (2 ^ 5);
        int cfr_ignored_0 = (3 ^ 5) << 4 ^ 1;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 5;
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

    public /* synthetic */ int getSkillId() {
        PetCommand a2;
        return a2.a;
    }

    public /* synthetic */ int getProbability() {
        PetCommand a2;
        return a2.d;
    }
}

