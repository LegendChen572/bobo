/*
 * Decompiled with CFR 0.150.
 */
package client.messages;

import tools.StringUtil;

public class CommandProcessorUtil {
    public static /* synthetic */ String joinAfterString(String[] a2, String a3) {
        int n2;
        int n3 = n2 = 1;
        while (n3 < a2.length) {
            if (a2[n2].equalsIgnoreCase(a3) && n2 + 1 < a2.length) {
                return StringUtil.joinStringFrom(a2, n2 + 1);
            }
            n3 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ Double getNamedDoubleArg(String[] a2, int a322, String a4) {
        String a322 = CommandProcessorUtil.getNamedArg(a2, a322, a4);
        if (a322 != null) {
            try {
                return Double.parseDouble(a322);
            }
            catch (NumberFormatException a322) {
                // empty catch block
            }
        }
        return null;
    }

    public static /* synthetic */ Long getNamedLongArg(String[] a2, int a322, String a4) {
        String a322 = CommandProcessorUtil.getNamedArg(a2, a322, a4);
        if (a322 != null) {
            try {
                return Long.parseLong(a322);
            }
            catch (NumberFormatException a322) {
                // empty catch block
            }
        }
        return null;
    }

    public static /* synthetic */ Integer getNamedIntArg(String[] a2, int a322, String a4) {
        String a322 = CommandProcessorUtil.getNamedArg(a2, a322, a4);
        if (a322 != null) {
            try {
                return Integer.parseInt(a322);
            }
            catch (NumberFormatException a322) {
                // empty catch block
            }
        }
        return null;
    }

    public /* synthetic */ CommandProcessorUtil() {
        CommandProcessorUtil a2;
    }

    public static /* synthetic */ String getNamedStringArg(String[] a2, int a322, String a4) {
        String a322 = CommandProcessorUtil.getNamedArg(a2, a322, a4);
        if (a322 != null) {
            try {
                return a322;
            }
            catch (NumberFormatException a322) {
                // empty catch block
            }
        }
        return null;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ 3 << 1;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ (2 << 2 ^ 1);
        int n5 = n3;
        int n6 = (2 ^ 5) << 3;
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

    public static /* synthetic */ int getOptionalIntArg(String[] a2, int a32, int a4) {
        if (a2.length > a32) {
            try {
                return Integer.parseInt(a2[a32]);
            }
            catch (NumberFormatException a32) {
                return a4;
            }
        }
        return a4;
    }

    public static /* synthetic */ int getNamedIntArg(String[] a2, int a32, String a4, int a5) {
        Integer a32 = CommandProcessorUtil.getNamedIntArg(a2, a32, a4);
        if (a32 == null) {
            return a5;
        }
        return a32;
    }

    public static /* synthetic */ String getNamedArg(String[] a2, int a3, String a4) {
        int n2 = a3 = a3;
        while (n2 < a2.length) {
            if (a2[a3].equalsIgnoreCase(a4) && a3 + 1 < a2.length) {
                return a2[a3 + 1];
            }
            n2 = ++a3;
        }
        return null;
    }
}

