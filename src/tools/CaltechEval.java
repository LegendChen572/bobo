/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.util.Vector;
import server.Extend.SpecialEquipData;
import tools.ConcurrentEnumMap;

public class CaltechEval {
    public /* synthetic */ boolean[] a;
    public /* synthetic */ String B;
    public /* synthetic */ String[] k;
    public /* synthetic */ int[] K;
    public /* synthetic */ int ALLATORIxDEMO;
    public /* synthetic */ int[] d;

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(SpecialEquipData.ALLATORIxDEMO("&\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f3\u000f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u001a&\u001a\f\u0019\f\u0019\f\u0019\f\u0019\u000f\u001a\f\u001a\f\u0019\f\u001a\f\u0019\f\u0019\u000f\u001a\f\u001a\u000f\u001a\f\u001a\u000f\u001a\f\u001a\u000f\u0019\f\u001a\u000f\u001a\f\u0019\f\u0019\f\u0019\f\u0019\u000f3\u000f\u0019\f\u0019\f\u0019\f\u0019\u000f\u0019\u000f\u0019\u000f\u0019\f\u0019\u000f\u0019\f\u0019\u000f\u0019\u000f\u0019\f\u001a\f\u0019\u000f\u0019\u000f\u0019\u000f\u0019\u000f\u0019\f\u001a\f\u0019\f\u0019\f\u0019\f\u0019\f\u001a&\u001a\f\u0019\f\u0019\f\u0019\f\u001a\u000f\u001a\f\u001a\f\u0019\f\u001a\f\u0019\f\u001a\u000f\u001a\f\u0019\u000f\u0019\f\u001a\f\u001a\f\u001a\u000f\u0019\f\u0019\u000f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\u000f3\u000f\u0019\f\u0019\f\u0019\f\u0019\u000f\u0019\u000f\u0019\u000f\u001a\u000f\u0019\u000f\u001a\u000f\u0019\u000f\u0019\u000f\u0019\f\u001a\f\u0019\u000f\u001a\u000f\u0019\u000f\u0019\u000f\u0019\u000f\u001a\u000f\u0019\f\u0019\f\u0019\f\u0019\f\u001a&\u001a\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\u000f3\u000f\u0019c[JL_ZMMEVB\u0019N@\fx@UMMCKE\u0019c[JL_ZMMCK\fO\u001b\u0017\u001f\u0019h|av\f\u001a&\u001a\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\u000f3\u000f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019DMXI\u0016\u0016\u0003N[N\u0002X@UMMCKE\u0017OVA\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u001a&\u001a\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\f\u0019\u000f3\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a\u000f\u001a&"));
        if (a2 == null || a2.length != 1) {
            System.exit(0);
        }
        CaltechEval caltechEval = new CaltechEval(a2[0]);
        System.out.println(a2[0].replace(" ", "") + " = " + caltechEval.evaluate());
    }

    private /* synthetic */ double ALLATORIxDEMO(String a2) {
        CaltechEval a3;
        Double d2 = new Double(0.0);
        Object object = a2 = a3.ALLATORIxDEMO((String)a2);
        while (((Vector)object).size() > 1) {
            object = a3.reduceTokens((Vector)a2);
        }
        return Double.parseDouble((String)((Vector)a2).elementAt(0));
    }

    private /* synthetic */ Vector ALLATORIxDEMO(String a2) {
        Vector<Object> vector = new Vector<Object>(1);
        Object object = "";
        Object object2 = "";
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < a2.length()) {
            CaltechEval a3;
            char c2 = a2.charAt(n4);
            char c3 = ' ';
            if (n4 < a2.length() - 1) {
                c3 = a2.charAt(n4 + 1);
            }
            if (n3 > 0 && ((String)object2).equals(SpecialEquipData.ALLATORIxDEMO("XXXB")) && c2 == '2') {
                vector.addElement(ConcurrentEnumMap.ALLATORIxDEMO("\u000f-\u000f7\\"));
                ++n4;
                object2 = "";
                n3 = 0;
                continue;
            }
            if (a3.ALLATORIxDEMO(c2)) {
                ++n2;
                object = (String)object + a2.charAt(n4);
                if (n3 > 0) {
                    vector.addElement(object2);
                }
                ++n4;
                n3 = 0;
                object2 = "";
                continue;
            }
            if (c2 == 'e' && n2 > 0 && n4 < a2.length() - 2 && (c3 == '+' || c3 == '-' || a3.ALLATORIxDEMO(c3))) {
                object = (String)object + c2;
                n2 += 2;
                n4 += 2;
                object = (String)object + c3;
                n3 = 0;
                continue;
            }
            if (c2 == '(' || c2 == ')') {
                if (n2 > 0) {
                    vector.addElement(object);
                }
                n2 = 0;
                object = "";
                if (n3 > 0) {
                    vector.addElement(object2);
                }
                object2 = "" + c2;
                vector.addElement(object2);
                ++n4;
                n3 = 0;
                object2 = "";
                continue;
            }
            if (n2 > 0) {
                vector.addElement(object);
            }
            n2 = 0;
            object = "";
            if (((String)(object2 = (String)object2 + c2)).equals(SpecialEquipData.ALLATORIxDEMO("\u0007")) || ((String)object2).equals(ConcurrentEnumMap.ALLATORIxDEMO("C")) || ((String)object2).equals(SpecialEquipData.ALLATORIxDEMO("\u0006")) || ((String)object2).equals("/") || ((String)object2).equals(ConcurrentEnumMap.ALLATORIxDEMO("B"))) {
                vector.addElement(object2);
                n3 = 0;
                object2 = "";
            } else {
                ++n3;
            }
            ++n4;
        }
        if (n2 > 0) {
            vector.addElement(object);
            n3 = 0;
        }
        if (n3 > 0) {
            vector.addElement(object2);
        }
        return vector;
    }

    public /* synthetic */ double evaluate() {
        CaltechEval a2;
        CaltechEval caltechEval = a2;
        return caltechEval.ALLATORIxDEMO(caltechEval.B);
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        CaltechEval a2;
        a2.ALLATORIxDEMO = 19;
        a2.k = new String[a2.ALLATORIxDEMO];
        CaltechEval caltechEval = a2;
        caltechEval.K = new int[caltechEval.ALLATORIxDEMO];
        caltechEval.a = new boolean[caltechEval.ALLATORIxDEMO];
        caltechEval.d = new int[caltechEval.ALLATORIxDEMO];
        caltechEval.k[0] = ConcurrentEnumMap.ALLATORIxDEMO("E");
        caltechEval.K[0] = 2;
        caltechEval.a[0] = true;
        caltechEval.d[0] = 2;
        caltechEval.k[1] = SpecialEquipData.ALLATORIxDEMO("\u0001");
        caltechEval.K[1] = 2;
        caltechEval.a[1] = 1;
        caltechEval.d[1] = 2;
        caltechEval.k[2] = ConcurrentEnumMap.ALLATORIxDEMO("D");
        caltechEval.K[2] = 2;
        caltechEval.a[2] = true;
        caltechEval.d[2] = 3;
        caltechEval.k[3] = "/";
        caltechEval.K[3] = 2;
        caltechEval.a[3] = true;
        caltechEval.d[3] = 3;
        caltechEval.k[4] = SpecialEquipData.ALLATORIxDEMO("_PB");
        caltechEval.K[4] = 1;
        caltechEval.a[4] = false;
        caltechEval.d[4] = 10;
        caltechEval.k[5] = ConcurrentEnumMap.ALLATORIxDEMO("\r6\u001d");
        caltechEval.K[5] = 1;
        caltechEval.a[5] = false;
        caltechEval.d[5] = 10;
        caltechEval.k[6] = SpecialEquipData.ALLATORIxDEMO("XXB");
        caltechEval.K[6] = 1;
        caltechEval.a[6] = false;
        caltechEval.d[6] = 10;
        caltechEval.k[7] = ConcurrentEnumMap.ALLATORIxDEMO("\u000b!\u001e");
        caltechEval.K[7] = 1;
        caltechEval.a[7] = false;
        caltechEval.d[7] = 10;
        caltechEval.k[8] = SpecialEquipData.ALLATORIxDEMO("J]KX");
        caltechEval.K[8] = 1;
        caltechEval.a[8] = false;
        caltechEval.d[8] = 10;
        caltechEval.k[9] = ConcurrentEnumMap.ALLATORIxDEMO("8\u001d0\u0000");
        caltechEval.K[9] = 1;
        caltechEval.a[9] = false;
        caltechEval.d[9] = 10;
        caltechEval.k[10] = SpecialEquipData.ALLATORIxDEMO("XOV_");
        caltechEval.K[10] = 1;
        caltechEval.a[10] = false;
        caltechEval.d[10] = 10;
        caltechEval.k[11] = ConcurrentEnumMap.ALLATORIxDEMO("8\u001a8\u0000");
        caltechEval.K[11] = 1;
        caltechEval.a[11] = false;
        caltechEval.d[11] = 10;
        caltechEval.k[12] = SpecialEquipData.ALLATORIxDEMO("MMMW\u001e");
        caltechEval.K[12] = 2;
        caltechEval.a[12] = false;
        caltechEval.d[12] = 10;
        caltechEval.k[13] = ConcurrentEnumMap.ALLATORIxDEMO("\u00038\u0016");
        caltechEval.K[13] = 2;
        caltechEval.a[13] = false;
        caltechEval.d[13] = 10;
        caltechEval.k[14] = SpecialEquipData.ALLATORIxDEMO("APB");
        caltechEval.K[14] = 2;
        caltechEval.a[14] = false;
        caltechEval.d[14] = 10;
        caltechEval.k[15] = ConcurrentEnumMap.ALLATORIxDEMO("B");
        caltechEval.K[15] = 2;
        caltechEval.a[15] = true;
        caltechEval.d[15] = 1;
        caltechEval.k[16] = SpecialEquipData.ALLATORIxDEMO("Y");
        caltechEval.K[16] = 1;
        caltechEval.a[16] = false;
        caltechEval.d[16] = 4;
        caltechEval.k[17] = ConcurrentEnumMap.ALLATORIxDEMO("\n");
        caltechEval.K[17] = 1;
        caltechEval.a[17] = false;
        caltechEval.d[17] = 4;
        caltechEval.k[18] = SpecialEquipData.ALLATORIxDEMO("B");
        caltechEval.K[18] = 1;
        caltechEval.a[18] = false;
        caltechEval.d[18] = 11;
    }

    public /* synthetic */ CaltechEval(String a2) {
        CaltechEval a3;
        a3.ALLATORIxDEMO();
        a3.B = a2.replace(" ", "");
    }

    private /* synthetic */ double ALLATORIxDEMO(String a2, double a3, double a4) {
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("E"))) {
            return a3 + a4;
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("\u0001"))) {
            return a3 - a4;
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("D"))) {
            return a3 * a4;
        }
        if (a2.equals("/")) {
            return a3 / a4;
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("_PB"))) {
            return Math.sin(a3);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("\r6\u001d"))) {
            return Math.cos(a3);
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("XXB"))) {
            return Math.tan(a3);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("\u000b!\u001e"))) {
            return Math.exp(a3);
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("J]KX"))) {
            return Math.sqrt(a3);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("8\u001d0\u0000"))) {
            return Math.asin(a3);
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("XOV_"))) {
            return Math.acos(a3);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("8\u001a8\u0000"))) {
            return Math.atan(a3);
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("MMMW\u001e"))) {
            return Math.atan2(a3, a4);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("\u00038\u0016"))) {
            return Math.max(a3, a4);
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("APB"))) {
            return Math.min(a3, a4);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("\u001b"))) {
            return Math.ceil(a3);
        }
        if (a2.equals(SpecialEquipData.ALLATORIxDEMO("H"))) {
            return Math.floor(a3);
        }
        if (a2.equals(ConcurrentEnumMap.ALLATORIxDEMO("\u0000"))) {
            return -a3;
        }
        throw new RuntimeException("Invalid operator: " + a2);
    }

    private /* synthetic */ boolean ALLATORIxDEMO(char a2) {
        return a2 >= '0' && a2 <= '9' || a2 == '.';
    }

    private /* synthetic */ int ALLATORIxDEMO(String a2) {
        CaltechEval a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.ALLATORIxDEMO) {
            if (a2.equals(a3.k[n2]) && a2.length() == a3.k[n2].length()) {
                return n2;
            }
            n3 = ++n2;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ Vector reduceTokens(Vector a) {
        var2_2 = new Double(0.0);
        var3_3 = 0.0;
        block0: while (a.indexOf(SpecialEquipData.ALLATORIxDEMO("\u0004")) != -1) {
            var9_4 = a.indexOf(ConcurrentEnumMap.ALLATORIxDEMO("F"));
            var10_5 = new Vector();
            var11_8 = 1;
            v0 = var9_4 + 1;
            while (v0 < a.size()) {
                var13_12 = (String)a.elementAt(var12_9);
                if (var13_12.equals(SpecialEquipData.ALLATORIxDEMO("\u0005"))) {
                    v1 = --var11_8;
                } else {
                    if (var13_12.equals(ConcurrentEnumMap.ALLATORIxDEMO("F"))) {
                        // empty if block
                    }
                    v1 = ++var11_8;
                }
                if (v1 == 0) {
                    v2 = var14_14 = var9_4 + 1;
                    while (v2 < var12_9) {
                        var10_5.addElement(a.elementAt(var14_14++));
                        v2 = var14_14;
                    }
                    var14_14 = var10_5.size();
                    var10_5 = a.reduceTokens(var10_5);
                    var15_15 = var10_5.size();
                    var16_17 = var9_4;
                    v3 = var17_20 = 0;
                    while (v3 < var10_5.size()) {
                        a.setElementAt(var10_5.elementAt(var17_20), var16_17);
                        v3 = ++var17_20;
                        ++var16_17;
                    }
                    v4 = var17_20 = 0;
                    while (v4 < var14_14 - var15_15 + 2) {
                        a.removeElementAt(var16_17);
                        v4 = ++var17_20;
                    }
                    continue block0;
                }
                v0 = ++var12_9;
            }
        }
        block5: while (true) lbl-1000:
        // 3 sources

        {
            v5 = a;
            while (v5.size() > 1) {
                block19: {
                    block20: {
                        var9_4 = 0;
                        var10_7 = -1;
                        v6 = var11_8 = 0;
                        while (v6 < a.size()) {
                            var12_11 = (String)a.elementAt(var11_8);
                            var13_13 = a.ALLATORIxDEMO(var12_11);
                            if (var13_13 != -1 && a.d[var13_13] >= var9_4) {
                                var9_4 = a.d[var13_13];
                                var10_7 = var11_8;
                            }
                            v6 = ++var11_8;
                        }
                        var11_8 = var10_7;
                        if (var10_7 == -1) {
                            return a;
                        }
                        var12_11 = (String)a.elementAt(var11_8);
                        v7 = a;
                        var13_13 = v7.ALLATORIxDEMO(var12_11);
                        if (!v7.a[var13_13]) break block19;
                        if (var12_11.equals(SpecialEquipData.ALLATORIxDEMO("\u0000"))) break block20;
                        var14_14 = var11_8 - 1;
                        if (var11_8 > 0) {
                            var15_16 = (String)a.elementAt(var11_8 - 1);
                            if (a.ALLATORIxDEMO((String)var15_16) != -1) {
                                var14_14 = var11_8;
                                var3_3 = 0.0;
                            } else {
                                var3_3 = Double.parseDouble((String)var15_16);
                            }
                        } else {
                            var14_14 = 0;
                            var3_3 = 0.0;
                        }
                        var15_16 = (String)a.elementAt(var11_8 + 1);
                        var5_21 = Double.parseDouble((String)var15_16);
                        var16_19 = a.ALLATORIxDEMO(var12_11, var3_3, var5_21);
                        var15_16 = "" + var16_19;
                        v8 = a;
                        v8.setElementAt(var15_16, var14_14);
                        v8.removeElementAt(var14_14 + 1);
                        if (var11_8 <= 0 || var14_14 == var11_8) ** GOTO lbl-1000
                        v9 = a;
                        v5 = v9;
                        v9.removeElementAt(var14_14 + 1);
                        continue;
                    }
                    v10 = a;
                    v5 = v10;
                    v10.removeElementAt(var11_8);
                    continue;
                }
                var14_14 = a.K[var13_13];
                var15_16 = (String)a.elementAt(var11_8 + 1);
                var5_21 = Double.parseDouble((String)var15_16);
                var7_22 = 0.0;
                if (var14_14 > 1) {
                    var15_16 = (String)a.elementAt(var11_8 + 2);
                    var7_22 = Double.parseDouble((String)var15_16);
                }
                var16_19 = a.ALLATORIxDEMO(var12_11, var5_21, var7_22);
                var15_16 = "" + var16_19;
                v11 = a;
                v11.setElementAt(var15_16, var11_8);
                v11.removeElementAt(var11_8 + 1);
                if (var14_14 <= 1) continue block5;
                v12 = a;
                v5 = v12;
                v12.removeElementAt(var11_8 + 1);
            }
            return a;
        }
    }
}

