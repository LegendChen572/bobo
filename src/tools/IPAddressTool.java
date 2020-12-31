/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.inventory.PetCommand;
import server.gashapon.GashaponRewardSpecial;

public class IPAddressTool {
    public /* synthetic */ IPAddressTool() {
        IPAddressTool a2;
    }

    public static final /* synthetic */ long dottedQuadToLong(String a2) throws RuntimeException {
        int n2;
        String[] arrstring = a2.split(PetCommand.ALLATORIxDEMO("C\u001b"));
        if (arrstring.length != 4) {
            throw new RuntimeException(GashaponRewardSpecial.ALLATORIxDEMO("MIrFhN`\u0007Mw$f`CvBwT$AkUiFp\t"));
        }
        long l2 = 0L;
        int n3 = n2 = 0;
        while (n3 < 4) {
            long l3 = Integer.parseInt(arrstring[n2]) % 256;
            long l4 = (long)Math.pow(256.0, 4 - n2);
            l2 += l3 * l4;
            n3 = ++n2;
        }
        return l2;
    }

    public static final /* synthetic */ String longToDottedQuad(long a2) throws RuntimeException {
        int n2;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = n2 = 0;
        while (n3 < 4) {
            int n4 = (int)(a2 / (long)Math.pow(256.0, 4 - n2));
            a2 -= (long)n4 * (long)Math.pow(256.0, 4 - n2);
            if (n2 > 0) {
                stringBuilder.append(PetCommand.ALLATORIxDEMO("\u001b"));
            }
            if (n4 > 255) {
                throw new RuntimeException(GashaponRewardSpecial.ALLATORIxDEMO("MIrFhN`\u0007hHj@$nT\u0007eC`UaTw\t"));
            }
            stringBuilder.append(n4);
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }
}

