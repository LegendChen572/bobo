/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.GM.\u65b0\u661f\u8c37
 */
package handling;

import client.messages.commands.GM.\u65b0\u661f\u8c37;
import constants.skills.SkillType;
import handling.WritableIntValueHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;
import tools.HexTool;

public class ExternalCodeTableGetter {
    public final /* synthetic */ Properties ALLATORIxDEMO;

    public static final /* synthetic */ <T extends Enum<? extends WritableIntValueHolder>> String getOpcodeTable(T[] a2) {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = new ArrayList<T>();
        object.addAll(Arrays.asList(a2));
        ArrayList<T> arrayList = object;
        Collections.sort(arrayList, new Comparator<WritableIntValueHolder>(){
            {
                1 a2;
            }

            @Override
            public /* synthetic */ int compare(WritableIntValueHolder a2, WritableIntValueHolder a3) {
                return Short.valueOf(a2.getValue()).compareTo(a3.getValue());
            }
        });
        object = arrayList.iterator();
        Object object2 = object;
        while (object2.hasNext()) {
            Enum enum_;
            Enum enum_2 = enum_ = (Enum)object.next();
            StringBuilder stringBuilder2 = stringBuilder;
            stringBuilder.append(enum_2.name());
            stringBuilder2.append(SkillType.ALLATORIxDEMO("\u0013\u0019\u0013"));
            stringBuilder.append(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"M2"));
            stringBuilder2.append(HexTool.toString(((WritableIntValueHolder)((Object)enum_2)).getValue()));
            stringBuilder.append(SkillType.ALLATORIxDEMO("\u0004\u001b"));
            stringBuilder.append(((WritableIntValueHolder)((Object)enum_)).getValue());
            stringBuilder.append(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"T@"));
            object2 = object;
        }
        return stringBuilder.toString();
    }

    public /* synthetic */ ExternalCodeTableGetter(Properties a2) {
        ExternalCodeTableGetter a3;
        a3.ALLATORIxDEMO = a2;
    }

    private /* synthetic */ <T extends Enum<? extends WritableIntValueHolder>> short ALLATORIxDEMO(String a2, T[] a3, short a4) {
        ExternalCodeTableGetter a5;
        if ((a2 = a5.ALLATORIxDEMO.getProperty((String)a2)) != null && a2.length() > 0) {
            String string;
            String string2;
            a2 = a2.trim().split(" ");
            short s2 = 0;
            if (a2.length == 2) {
                s2 = ((WritableIntValueHolder)((Object)ExternalCodeTableGetter.ALLATORIxDEMO((String)a2[0], a3))).getValue();
                if (s2 == a4) {
                    s2 = a5.ALLATORIxDEMO(a2[0], (Enum[])a3, a4);
                }
                string = string2 = a2[1];
            } else {
                string = string2 = a2[0];
            }
            if (string.length() > 2 && string2.substring(0, 2).equals(\u65b0\u661f\u8c37.ALLATORIxDEMO((String)"M2"))) {
                return (short)(Short.parseShort(string2.substring(2), 16) + s2);
            }
            return (short)(Short.parseShort(string2) + s2);
        }
        return a4;
    }

    private static /* synthetic */ <T extends Enum<? extends WritableIntValueHolder>> T ALLATORIxDEMO(String a2, T[] a3) {
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

    public static final /* synthetic */ <T extends Enum<? extends WritableIntValueHolder>> void populateValues(Properties a2, T[] a3) {
        int n2;
        ExternalCodeTableGetter externalCodeTableGetter = new ExternalCodeTableGetter(a2);
        T[] arrT = a3;
        int n3 = a3.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            T t2 = arrT[n2];
            ((WritableIntValueHolder)t2).setValue(externalCodeTableGetter.ALLATORIxDEMO(((Enum)t2).name(), (Enum[])a3, (short)-2));
            n4 = ++n2;
        }
    }
}

