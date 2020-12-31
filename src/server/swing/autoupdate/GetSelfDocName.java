/*
 * Decompiled with CFR 0.150.
 */
package server.swing.autoupdate;

import client.MapleFriendship;
import server.characterCards.MapleCharacterCards;
import tools.FileoutputUtil;

public class GetSelfDocName {
    public static /* synthetic */ void main(String[] a2) {
        int n2;
        System.out.println(MapleFriendship.ALLATORIxDEMO("\u0012\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;!;\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b;\b8\b8\u000b8\b8\u000b8\u000b;\b8\b;\b8\b;\b8\b;\u000b8\b;\b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b;\u000b;\u000b;\u000b8\u000b;\u000b8\u000b;\u000b;\u000b8\b8\u000b;\u000b;\u000b;\u000b;\u000b8\b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\b;\b8\b8\u000b8\b8\u000b8\b;\b8\u000b;\u000b8\b8\b8\b;\u000b8\u000b;\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b;\u000b;\u000b;\b;\u000b;\b;\u000b;\u000b;\u000b8\b8\u000b;\b;\u000b;\u000b;\u000b;\b;\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000bWI~^kHy_qDv\u000bzR8jtGy_wYq\u000bWI~^kHy_wY8]/\u0005+\u000b\\nUd8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\u000b8\u000b8\u000b8\u000b8\u000b8\u000bp_l[\"\u00047\\o\\6JtGy_wYq\u0005{Du\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\b\u0012\b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b8\u000b;!;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b;\b\u0012"));
        int n3 = n2 = 0;
        while (n3 < a2.length) {
            int n4 = n2;
            System.out.println("\u7b2c " + n4 + " \u500b\u53c3\u6578\uff1a" + a2[n4]);
            int n5 = n2++;
            FileoutputUtil.logToFile(MapleCharacterCards.ALLATORIxDEMO("`;k'#\u0013i _1`2H;o\u001am9izx,x"), "\u7b2c " + n5 + " \u500b\u53c3\u6578\uff1a" + a2[n5]);
            n3 = n2;
        }
    }

    public /* synthetic */ GetSelfDocName() {
        GetSelfDocName a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 2 << 1;
        int cfr_ignored_0 = (2 ^ 5) << 3 ^ 2;
        int n5 = n3;
        int n6 = 1 << 3 ^ 1;
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
}

