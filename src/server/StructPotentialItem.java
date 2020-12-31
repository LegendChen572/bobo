/*
 * Decompiled with CFR 0.150.
 */
package server;

import java.util.HashMap;
import java.util.Map;
import tools.ArrayMap;
import tools.FixDropNullItem;

public class StructPotentialItem {
    public static final /* synthetic */ String[] types;
    public /* synthetic */ String face;
    public /* synthetic */ String opString;
    public /* synthetic */ int reqLevel;
    public /* synthetic */ int opID;
    public final /* synthetic */ Map<String, Integer> data;
    public /* synthetic */ boolean bonus;
    public /* synthetic */ int level;
    public /* synthetic */ int optionType;

    public /* synthetic */ String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (stringBuilder.length() > 0) {
            int n2;
            String[] arrstring = types;
            int n3 = types.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                StructPotentialItem a2;
                String string = arrstring[n2];
                if (a2.get(string) > 0) {
                    stringBuilder.append(a2.opString.replace("#" + string, String.valueOf(a2.get(string))));
                }
                n4 = ++n2;
            }
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ String getInfo() {
        StringBuilder stringBuilder;
        block4: {
            StructPotentialItem a2;
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Map.Entry<String, Integer> entry : a2.data.entrySet()) {
                if (entry.getValue() <= 0) continue;
                if (a2.opString.contains(ArrayMap.ALLATORIxDEMO("\u513e\u5c03\u6071"))) {
                    if (a2.opString.equals(FixDropNullItem.ALLATORIxDEMO("\u515e\u5c2a\u6011\uff5c\u001de_(U\u0015b\u0014"))) {
                        StringBuilder stringBuilder3 = stringBuilder2;
                        stringBuilder = stringBuilder3;
                        stringBuilder3.append(a2.opString.replace(ArrayMap.ALLATORIxDEMO("u\u00068\f\u0005;\u0004"), String.valueOf(entry.getValue())));
                    } else {
                        stringBuilder2.append(a2.opString.replace("#" + entry.getKey(), String.valueOf(entry.getValue())));
                        stringBuilder = stringBuilder2;
                    }
                    break block4;
                }
                stringBuilder2.append(a2.opString.replace("#" + entry.getKey(), String.valueOf(entry.getValue())).replaceAll(FixDropNullItem.ALLATORIxDEMO("e"), ""));
            }
            stringBuilder = stringBuilder2;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ StructPotentialItem() {
        StructPotentialItem a2;
        StructPotentialItem structPotentialItem = a2;
        a2.data = new HashMap<String, Integer>();
        a2.bonus = false;
    }

    public static /* synthetic */ {
        String[] arrstring = new String[60];
        arrstring[0] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0005;\u0004");
        arrstring[1] = FixDropNullItem.ALLATORIxDEMO("_(U\u0002s\u001e");
        arrstring[2] = ArrayMap.ALLATORIxDEMO("\u00068\f\u001f!\u0002");
        arrstring[3] = FixDropNullItem.ALLATORIxDEMO("_(U\nc\r");
        arrstring[4] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0017,\u0015");
        arrstring[5] = FixDropNullItem.ALLATORIxDEMO("_(U\u0003`\u0007");
        arrstring[6] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0006.\u0012");
        arrstring[7] = FixDropNullItem.ALLATORIxDEMO("_(U\u000bw\u0002");
        arrstring[8] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0006+\u0012");
        arrstring[9] = FixDropNullItem.ALLATORIxDEMO("_(U\u000br\u0002");
        arrstring[10] = ArrayMap.ALLATORIxDEMO("\u00068\f\u001b'\u0006");
        arrstring[11] = FixDropNullItem.ALLATORIxDEMO("_(U\u000b{\u0016");
        arrstring[12] = ArrayMap.ALLATORIxDEMO("?\u00015<\u0002=$");
        arrstring[13] = FixDropNullItem.ALLATORIxDEMO("/X%r\u0003n4");
        arrstring[14] = ArrayMap.ALLATORIxDEMO("?\u00015&\u0018;$");
        arrstring[15] = FixDropNullItem.ALLATORIxDEMO("/X%z\u0013}4");
        arrstring[16] = ArrayMap.ALLATORIxDEMO("?\u00015.\u0015,$");
        arrstring[17] = FixDropNullItem.ALLATORIxDEMO("/X%s\u0010w4");
        arrstring[18] = ArrayMap.ALLATORIxDEMO("?\u00015?\u0017+$");
        arrstring[19] = FixDropNullItem.ALLATORIxDEMO("/X%{\u0007r4");
        arrstring[20] = ArrayMap.ALLATORIxDEMO("?\u00015?\u0012+$");
        arrstring[21] = FixDropNullItem.ALLATORIxDEMO("/X%{\u0002r4");
        arrstring[22] = ArrayMap.ALLATORIxDEMO("?\u00015\"\u001e?$");
        arrstring[23] = FixDropNullItem.ALLATORIxDEMO("/X%{\u000bf4");
        arrstring[24] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0005;\u0004\u0003 ");
        arrstring[25] = FixDropNullItem.ALLATORIxDEMO("_(U\u0002s\u001eZ0");
        arrstring[26] = ArrayMap.ALLATORIxDEMO("\u00068\f\u001f!\u0002\u0003 ");
        arrstring[27] = FixDropNullItem.ALLATORIxDEMO("_(U\nc\rZ0");
        arrstring[28] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0006.\u0012\u0003 ");
        arrstring[29] = FixDropNullItem.ALLATORIxDEMO("_(U\u000bw\u0002Z0");
        arrstring[30] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0005\u001f3\n2");
        arrstring[31] = FixDropNullItem.ALLATORIxDEMO("/X%|3[6");
        arrstring[32] = ArrayMap.ALLATORIxDEMO("?\u00015,$");
        arrstring[33] = FixDropNullItem.ALLATORIxDEMO("/X%r\u0007{4");
        arrstring[34] = ArrayMap.ALLATORIxDEMO("?\u00015;3\u001d\u0004");
        arrstring[35] = FixDropNullItem.ALLATORIxDEMO("/X%w5D\u0014");
        arrstring[36] = ArrayMap.ALLATORIxDEMO("?\u00015*\u000e?$");
        arrstring[37] = FixDropNullItem.ALLATORIxDEMO("_(U\u000bW>r'['Q#");
        arrstring[38] = ArrayMap.ALLATORIxDEMO("'\u0006");
        arrstring[39] = FixDropNullItem.ALLATORIxDEMO("{\u0016");
        arrstring[40] = ArrayMap.ALLATORIxDEMO("=3\f9\u00193\u001d/'\u0006");
        arrstring[41] = FixDropNullItem.ALLATORIxDEMO("d#U)@#D?{\u0016");
        arrstring[42] = ArrayMap.ALLATORIxDEMO(":\n \n:");
        arrstring[43] = FixDropNullItem.ALLATORIxDEMO("F4Y6");
        arrstring[44] = ArrayMap.ALLATORIxDEMO("\u001b?\u00023");
        arrstring[45] = FixDropNullItem.ALLATORIxDEMO("/Q(Y4S\u0012W4Q#B\u0002s\u0000");
        arrstring[46] = ArrayMap.ALLATORIxDEMO("?\b8\u0000$\n\u0012.\u001b");
        arrstring[47] = FixDropNullItem.ALLATORIxDEMO("/X%w*Z5]/Z*");
        arrstring[48] = ArrayMap.ALLATORIxDEMO("\u00061\u00019\u001d3+\u0017\"$");
        arrstring[49] = FixDropNullItem.ALLATORIxDEMO("d#U)@#D?c\u0016");
        arrstring[50] = ArrayMap.ALLATORIxDEMO("\u00068\f\u0015\u001d?\u001b?\f7\u00032\u000e;\u000e1\n\u001b\u00068");
        arrstring[51] = FixDropNullItem.ALLATORIxDEMO("_(U\u0005D/B/U'Z\"W+W!S\u000bW>");
        arrstring[52] = ArrayMap.ALLATORIxDEMO("+\u0017\"$\n0\u00033\f\"");
        arrstring[53] = FixDropNullItem.ALLATORIxDEMO("+F%Y(d#R3U#");
        arrstring[54] = ArrayMap.ALLATORIxDEMO("\u001d3\u000b#\f3,9\u0000:\u001b?\u00023");
        arrstring[55] = FixDropNullItem.ALLATORIxDEMO("/X%{#E)f4Y6");
        arrstring[56] = ArrayMap.ALLATORIxDEMO("?\u00015=3\u00187\u001d2?$\u0000&");
        arrstring[57] = FixDropNullItem.ALLATORIxDEMO("T)E5");
        arrstring[58] = ArrayMap.ALLATORIxDEMO("\u000e\"\u001b7\f=;/\u001f3");
        arrstring[59] = FixDropNullItem.ALLATORIxDEMO("$C P2_+S\u0014");
        types = arrstring;
    }

    public /* synthetic */ int get(String a2) {
        StructPotentialItem a3;
        if (a3.data.get(a2) != null) {
            return a3.data.get(a2);
        }
        return 0;
    }
}

