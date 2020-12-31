/*
 * Decompiled with CFR 0.150.
 */
package tools;

import FuckingHackerToby.fc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import tools.HexTool;
import tools.LoadPacket;
import tools.WritableLongValueHolder;

public class ExternalCodeLongTableGetter {
    public final /* synthetic */ Properties ALLATORIxDEMO;

    public static final /* synthetic */ <T extends Enum<? extends WritableLongValueHolder>> void populateValues(Properties a2, T[] a3) {
        int n2;
        ExternalCodeLongTableGetter externalCodeLongTableGetter = new ExternalCodeLongTableGetter(a2);
        T[] arrT = a3;
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            T t2 = arrT[n2];
            ((WritableLongValueHolder)t2).setValue(externalCodeLongTableGetter.ALLATORIxDEMO(((Enum)t2).name(), (Enum[])a3, -2L));
            n4 = ++n2;
        }
    }

    private /* synthetic */ <T extends Enum<? extends WritableLongValueHolder>> long ALLATORIxDEMO(String a2, T[] a3, long a4) {
        ExternalCodeLongTableGetter a5;
        if ((a2 = a5.ALLATORIxDEMO.getProperty((String)a2)) != null && a2.length() > 0) {
            String string;
            String string2;
            a2 = a2.trim().split(" ");
            long l2 = 0L;
            if (a2.length == 2) {
                l2 = ((WritableLongValueHolder)((Object)ExternalCodeLongTableGetter.ALLATORIxDEMO((String)a2[0], a3))).getValue();
                if (l2 == a4) {
                    l2 = a5.ALLATORIxDEMO(a2[0], (Enum[])a3, a4);
                }
                string = string2 = a2[1];
            } else {
                string = string2 = a2[0];
            }
            if (string.length() > 2 && string2.substring(0, 2).equals(fc.ALLATORIxDEMO("'*"))) {
                return Long.parseLong(string2.substring(2), 16) + l2;
            }
            return Long.parseLong(string2) + l2;
        }
        return a4;
    }

    public static final /* synthetic */ <T extends Enum<? extends WritableLongValueHolder>> String getOpcodeTable(T[] a2) {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = new ArrayList<T>();
        object.addAll(Arrays.asList(a2));
        ArrayList<T> arrayList = object;
        Collections.sort(arrayList, new Comparator<WritableLongValueHolder>(){

            @Override
            public /* synthetic */ int compare(WritableLongValueHolder a2, WritableLongValueHolder a3) {
                return Long.valueOf(a2.getValue()).compareTo(a3.getValue());
            }
            {
                1 a2;
            }
        });
        object = arrayList.iterator();
        Object object2 = object;
        while (object2.hasNext()) {
            Enum enum_;
            Enum enum_2 = enum_ = (Enum)object.next();
            StringBuilder stringBuilder2 = stringBuilder;
            stringBuilder.append(enum_2.name());
            stringBuilder2.append(LoadPacket.ALLATORIxDEMO("\u0017.\u0017"));
            stringBuilder.append(fc.ALLATORIxDEMO("'*"));
            stringBuilder2.append(HexTool.toString(((WritableLongValueHolder)((Object)enum_2)).getValue()));
            stringBuilder.append(LoadPacket.ALLATORIxDEMO("3\u001f"));
            stringBuilder.append(((WritableLongValueHolder)((Object)enum_)).getValue());
            stringBuilder.append(fc.ALLATORIxDEMO(">X"));
            object2 = object;
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 4 ^ 1 << 1;
        int cfr_ignored_0 = 1 << 3;
        int n5 = n3;
        int n6 = (3 ^ 5) << 4 ^ (2 << 2 ^ 3);
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

    private static /* synthetic */ <T extends Enum<? extends WritableLongValueHolder>> T ALLATORIxDEMO(String a2, T[] a3) {
        int n2;
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            T t2 = a3[n2];
            if (((Enum)t2).name().equals(a2)) {
                return t2;
            }
            n4 = ++n2;
        }
        return null;
    }

    public /* synthetic */ ExternalCodeLongTableGetter(Properties a2) {
        ExternalCodeLongTableGetter a3;
        a3.ALLATORIxDEMO = a2;
    }
}

