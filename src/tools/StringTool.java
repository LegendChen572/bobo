/*
 * Decompiled with CFR 0.150.
 */
package tools;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import server.life.ItemDropEntry;
import server.maps.Event_PyramidSubway;

public class StringTool {
    public static /* synthetic */ float parseFloat(String a2) {
        return (float)Double.parseDouble(a2);
    }

    public static /* synthetic */ boolean containsBlank(String a2) {
        return a2.contains(" ") || a2.contains(ItemDropEntry.ALLATORIxDEMO("\u301a"));
    }

    public static /* synthetic */ String unite(List<String> a2, String a3) {
        Iterator<String> iterator;
        if (a2 == null || a2.isEmpty() || a3 == null) {
            return null;
        }
        Object object = "";
        Iterator<String> iterator2 = iterator = a2.iterator();
        while (iterator2.hasNext()) {
            String string = iterator.next();
            object = (String)object + string + a3;
            iterator2 = iterator;
        }
        object = ((String)object).isEmpty() ? object : ((String)object).substring(0, ((String)object).length() - a3.length());
        return object;
    }

    public static /* synthetic */ int parseInt(String a2) {
        return (int)StringTool.parseLong(a2);
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(char a2) {
        if (a2 >= '0' && a2 <= '9') {
            return true;
        }
        if (a2 >= 'A' && a2 <= 'Z') {
            return true;
        }
        return a2 >= 'a' && a2 <= 'z';
    }

    public static /* synthetic */ String getOneValue(String a2, String a3) {
        int n2;
        if (a2 == null || a3 == null) {
            return null;
        }
        String[] arrstring = a2.split(ItemDropEntry.ALLATORIxDEMO("!"));
        int n3 = arrstring.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String[] arrstring2 = arrstring[n2].split(Event_PyramidSubway.ALLATORIxDEMO("\u0019"));
            if (arrstring2.length == 2 && arrstring2[0].equals(a3)) {
                return arrstring2[1];
            }
            n4 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ boolean ValidString(String a2) {
        int n2;
        int n3 = n2 = 0;
        while (n3 < a2.length()) {
            int n4 = n2++;
            if (a2.substring(n4, n4 + 1).matches(Event_PyramidSubway.ALLATORIxDEMO("\u0001\uac24w\ud787\u0007\u000f"))) {
                return false;
            }
            n3 = n2;
        }
        return true;
    }

    public static /* synthetic */ String updateOneValue(String a2, String a3, String a4) {
        int n2;
        if (a3 == null) {
            return null;
        }
        if (a2 == null) {
            if (a4 != null) {
                a2 = a3 + "=" + a4;
            }
            return a2;
        }
        String[] arrstring = ((String)a2).split(ItemDropEntry.ALLATORIxDEMO("!"));
        boolean bl = false;
        boolean bl2 = false;
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = arrstring.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = arrstring[n2];
            String[] arrstring2 = string.split(Event_PyramidSubway.ALLATORIxDEMO("\u0019"));
            if (arrstring2.length == 2) {
                StringBuilder stringBuilder2;
                if (arrstring2[0].equals(a3)) {
                    if (a4 != null) {
                        stringBuilder.append(a3).append(ItemDropEntry.ALLATORIxDEMO("'")).append(a4);
                    }
                    bl2 = true;
                    stringBuilder2 = stringBuilder;
                } else {
                    StringBuilder stringBuilder3 = stringBuilder;
                    stringBuilder2 = stringBuilder3;
                    stringBuilder3.append(string);
                }
                stringBuilder2.append(Event_PyramidSubway.ALLATORIxDEMO("\u001f"));
                bl = true;
            }
            n4 = ++n2;
        }
        if (!bl2 && a4 != null) {
            stringBuilder.append(a3).append(ItemDropEntry.ALLATORIxDEMO("'")).append(a4).append(Event_PyramidSubway.ALLATORIxDEMO("\u001f"));
        }
        StringBuilder stringBuilder4 = stringBuilder;
        Object object = a2 = bl ? stringBuilder4.toString().substring(0, stringBuilder.toString().length() - 1) : stringBuilder4.toString();
        if (((String)a2).isEmpty()) {
            return null;
        }
        return a2;
    }

    public static /* synthetic */ short parseByte(String a2) {
        return (short)(StringTool.parseLong(a2) & 0xFFL);
    }

    public static /* synthetic */ byte parseSByte(String a2) {
        return (byte)StringTool.parseLong(a2);
    }

    public static /* synthetic */ int parseUShort(String a2) {
        return (short)(StringTool.parseLong(a2) & 0xFFFFL);
    }

    public static /* synthetic */ String[] split(String a2, String a3) {
        if (a2 == null || a3 == null) {
            return null;
        }
        return a2.split(a3);
    }

    public static /* synthetic */ boolean parseBoolean(String a2) {
        return a2 != null && a2.equalsIgnoreCase(ItemDropEntry.ALLATORIxDEMO("yhx\u007f")) || StringTool.parseLong(a2) > 0L;
    }

    public /* synthetic */ StringTool() {
        StringTool a2;
    }

    public static /* synthetic */ String unite(String[] a2, String a3) {
        return StringTool.unite(Arrays.asList(a2), a3);
    }

    public static /* synthetic */ List<String> splitList(String a2, String a3) {
        if (a2 == null || a3 == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addAll(Arrays.asList(StringTool.split(a2, a3)));
        return linkedList;
    }

    public static /* synthetic */ short parseShort(String a2) {
        return (short)StringTool.parseLong(a2);
    }

    public static /* synthetic */ int appearNumber(String a2, String a3) {
        int n2 = 0;
        Object object = a3 = Pattern.compile((String)a3).matcher(a2);
        while (((Matcher)object).find()) {
            object = a3;
            ++n2;
        }
        return n2;
    }

    private static /* synthetic */ boolean H(char a2) {
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(a2);
        return Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS == unicodeBlock || Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS == unicodeBlock || Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS == unicodeBlock || Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT == unicodeBlock || Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A == unicodeBlock || Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B == unicodeBlock;
    }

    public static /* synthetic */ double parseDouble(String a2) {
        if (a2 == null || a2.isEmpty() || !a2.matches(Event_PyramidSubway.ALLATORIxDEMO("w\u001b\u0001\u0014w\u001d\u0007\u000et\u001b\u0001\u0014w\u001d\u0007\u000e"))) {
            return 0.0;
        }
        return Double.parseDouble(a2);
    }

    public static /* synthetic */ boolean isDigitOrLetter(String a2) {
        int n2 = a2.length();
        while (--n2 >= 0) {
            if (StringTool.ALLATORIxDEMO(a2.charAt(n2))) continue;
            return false;
        }
        return true;
    }

    public static /* synthetic */ int getIntFromString(String a2) {
        return StringTool.parseInt(Pattern.compile(ItemDropEntry.ALLATORIxDEMO("VD=74G")).matcher(a2).replaceAll("").trim());
    }

    public static /* synthetic */ long parseUInt(String a2) {
        return StringTool.parseLong(a2) & 0xFFFFFFFFFFFFFFFFL;
    }

    public static /* synthetic */ boolean isNumeric(String a2) {
        int n2 = a2.length();
        while (--n2 >= 0) {
            if (Character.isDigit(a2.charAt(n2))) continue;
            return false;
        }
        return true;
    }

    public static /* synthetic */ String FormatString(int a2, String a3) {
        Object object = a3;
        int n2 = a3 = a2 - a3.length();
        while (n2 > 0) {
            object = (String)object + " ";
            n2 = --a3;
        }
        return object;
    }

    public static /* synthetic */ boolean isNormalName(String a2) {
        int n2 = a2.length();
        while (--n2 >= 0) {
            if (Character.isDigit(a2.charAt(n2)) || Character.isLetter(a2.charAt(n2)) || StringTool.H(a2.charAt(n2))) continue;
            return false;
        }
        return true;
    }

    public static /* synthetic */ long parseLong(String a2) {
        return (long)StringTool.parseDouble(a2);
    }
}

