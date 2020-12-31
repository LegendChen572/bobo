/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5408\u592a\u8c37
 */
package tools;

import client.messages.commands.player.\u5408\u592a\u8c37;
import database.DatabaseException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class StringUtil {
    public static final /* synthetic */ int countCharacters(String a2, char a3) {
        int n2;
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < a2.getBytes().length) {
            if (a2.charAt(n2) == a3) {
                ++n3;
            }
            n4 = ++n2;
        }
        return n3;
    }

    public static final /* synthetic */ String joinStringFrom(String[] a2, int a3, String a4) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = a3 = a3;
        while (n2 < a2.length) {
            int n3 = a3;
            stringBuilder.append(a2[n3]);
            if (n3 != a2.length - 1) {
                stringBuilder.append(a4);
            }
            n2 = ++a3;
        }
        return stringBuilder.toString();
    }

    public static final /* synthetic */ String getLeftPaddedStr(String a2, char a3, int a4) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder(a4);
        int n3 = n2 = a2.getBytes().length;
        while (n3 < a4) {
            stringBuilder.append(a3);
            n3 = ++n2;
        }
        StringBuilder stringBuilder2 = stringBuilder;
        stringBuilder2.append(a2);
        return stringBuilder2.toString();
    }

    public static final /* synthetic */ String getRightPaddedStr(String a2, char a3, int a4) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder(a2);
        int n3 = n2 = a2.getBytes().length;
        while (n3 < a4) {
            stringBuilder.append(a3);
            n3 = ++n2;
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 5 << 3 ^ 2;
        int cfr_ignored_0 = 4 << 3;
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ 1;
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

    public static final /* synthetic */ String joinStringFrom(String[] a2, int a3) {
        return StringUtil.joinStringFrom(a2, a3, " ");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ String getReadableMillis(long a2, long a32) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        double a32 = (double)(a32 - a2) / 1000.0;
        int n2 = (int)a32 % 60;
        int n3 = (int)(a32 / 60.0);
        int n4 = n3 % 60;
        int n5 = n3 / 60;
        int n6 = n5 % 24;
        if ((n5 /= 24) > 0) {
            boolean bl;
            String string;
            boolean bl2 = n6 > 0;
            StringBuilder stringBuilder3 = stringBuilder2;
            stringBuilder3.append(n5);
            if (n5 > 1) {
                string = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"J");
                bl = bl2;
            } else {
                string = "";
                bl = bl2;
            }
            stringBuilder3.append(" day" + string + (bl ? DatabaseException.ALLATORIxDEMO("p\n") : \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u0017")));
            if (bl2) {
                boolean bl3;
                String string2;
                boolean bl4;
                boolean bl5 = bl4 = n4 > 0;
                if (!bl4) {
                    stringBuilder2.append(DatabaseException.ALLATORIxDEMO("=D8\n"));
                }
                StringBuilder stringBuilder4 = stringBuilder2;
                int n7 = n6;
                stringBuilder4.append(n7);
                if (n7 > 1) {
                    string2 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"J");
                    bl3 = bl4;
                } else {
                    string2 = "";
                    bl3 = bl4;
                }
                stringBuilder4.append(" hour" + string2 + (bl3 ? DatabaseException.ALLATORIxDEMO("p\n") : \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u0017")));
                if (bl4) {
                    int n8;
                    String string3;
                    int n9 = n5 = n2 > 0 ? 1 : 0;
                    if (n5 == 0) {
                        stringBuilder2.append(DatabaseException.ALLATORIxDEMO("=D8\n"));
                    }
                    StringBuilder stringBuilder5 = stringBuilder2;
                    int n10 = n4;
                    stringBuilder5.append(n10);
                    if (n10 > 1) {
                        string3 = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"J");
                        n8 = n5;
                    } else {
                        string3 = "";
                        n8 = n5;
                    }
                    stringBuilder5.append(" minute" + string3 + (n8 != 0 ? DatabaseException.ALLATORIxDEMO("p\n") : \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\u0017")));
                    if (n5 != 0) {
                        StringBuilder stringBuilder6 = stringBuilder2;
                        stringBuilder2.append(DatabaseException.ALLATORIxDEMO("=D8\n"));
                        stringBuilder6.append(n2);
                        stringBuilder6.append(" second" + (n2 > 1 ? \u5408\u592a\u8c37.ALLATORIxDEMO((String)"J") : "") + ".");
                    }
                }
            }
        } else if (n6 > 0) {
            boolean bl;
            String string;
            boolean bl6 = n4 > 0;
            StringBuilder stringBuilder7 = stringBuilder2;
            stringBuilder7.append(n6);
            if (n6 > 1) {
                string = DatabaseException.ALLATORIxDEMO("Y");
                bl = bl6;
            } else {
                string = "";
                bl = bl6;
            }
            stringBuilder7.append(" hour" + string + (bl ? \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\"\u0019") : DatabaseException.ALLATORIxDEMO("\u0004")));
            if (bl6) {
                boolean bl7;
                String string4;
                boolean bl8;
                boolean bl9 = bl8 = n2 > 0;
                if (!bl8) {
                    stringBuilder2.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"oWj\u0019"));
                }
                StringBuilder stringBuilder8 = stringBuilder2;
                int n11 = n4;
                stringBuilder8.append(n11);
                if (n11 > 1) {
                    string4 = DatabaseException.ALLATORIxDEMO("Y");
                    bl7 = bl8;
                } else {
                    string4 = "";
                    bl7 = bl8;
                }
                stringBuilder8.append(" minute" + string4 + (bl7 ? \u5408\u592a\u8c37.ALLATORIxDEMO((String)"\"\u0019") : DatabaseException.ALLATORIxDEMO("\u0004")));
                if (bl8) {
                    StringBuilder stringBuilder9 = stringBuilder2;
                    stringBuilder2.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"oWj\u0019"));
                    stringBuilder9.append(n2);
                    stringBuilder9.append(" second" + (n2 > 1 ? DatabaseException.ALLATORIxDEMO("Y") : "") + ".");
                }
            }
        } else if (n3 > 0) {
            boolean bl;
            String string;
            boolean bl10 = n2 > 0;
            StringBuilder stringBuilder10 = stringBuilder2;
            stringBuilder10.append(n3);
            if (n3 > 1) {
                string = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"J");
                bl = bl10;
            } else {
                string = "";
                bl = bl10;
            }
            stringBuilder10.append(" minute" + string + (bl ? " " : DatabaseException.ALLATORIxDEMO("\u0004")));
            if (bl10) {
                StringBuilder stringBuilder11 = stringBuilder2;
                stringBuilder2.append(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"oWj\u0019"));
                stringBuilder11.append(n2);
                stringBuilder11.append(" second" + (n2 > 1 ? DatabaseException.ALLATORIxDEMO("Y") : "") + ".");
            }
        } else {
            if (a32 > 0.0) {
                StringBuilder stringBuilder12 = stringBuilder2;
                stringBuilder12.append((int)a32);
                stringBuilder12.append(" second" + (a32 > 1.0 ? \u5408\u592a\u8c37.ALLATORIxDEMO((String)"J") : "") + ".");
                stringBuilder = stringBuilder2;
                return stringBuilder.toString();
            }
            stringBuilder2.append(DatabaseException.ALLATORIxDEMO("d3D9\u0004"));
        }
        stringBuilder = stringBuilder2;
        return stringBuilder.toString();
    }

    public static final /* synthetic */ int getDaysAmount(long a2, long a3) {
        return (int)((double)(a3 - a2) / 1000.0 / 60.0) / 60 / 24;
    }

    public static /* synthetic */ String codeString(File a2) throws FileNotFoundException {
        int n2;
        Object object = new BufferedInputStream(new FileInputStream(a2));
        int n3 = 0;
        try {
            BufferedInputStream bufferedInputStream = object;
            n3 = (bufferedInputStream.read() << 8) + ((BufferedInputStream)object).read();
            bufferedInputStream.close();
            n2 = n3;
        }
        catch (IOException iOException) {
            n2 = n3;
        }
        switch (n2) {
            case 65534: {
                object = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"l`PmVj\\");
                return object;
            }
            case 65279: {
                while (false) {
                }
                object = DatabaseException.ALLATORIxDEMO("\t~\u001a\u0007m\u001c\u001eo");
                return object;
            }
        }
        object = \u5408\u592a\u8c37.ALLATORIxDEMO((String)"lZ\u007f#\u0001");
        return object;
    }

    public /* synthetic */ StringUtil() {
        StringUtil a2;
    }

    public static final /* synthetic */ int getlength(String a2) {
        return a2.getBytes(Charset.forName(\u5408\u592a\u8c37.ALLATORIxDEMO((String)"LpI\f"))).length;
    }

    public static final /* synthetic */ String makeEnumHumanReadable(String a2) {
        int n2;
        StringBuilder stringBuilder = new StringBuilder(a2.length() + 1);
        String[] arrstring = a2.split(DatabaseException.ALLATORIxDEMO("u"));
        int n3 = arrstring.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            StringBuilder stringBuilder2;
            String string = arrstring[n2];
            if (string.length() <= 2) {
                StringBuilder stringBuilder3 = stringBuilder;
                stringBuilder2 = stringBuilder3;
                stringBuilder3.append(string);
            } else {
                StringBuilder stringBuilder4 = stringBuilder;
                stringBuilder2 = stringBuilder4;
                stringBuilder4.append(string.charAt(0));
                stringBuilder.append(string.substring(1).toLowerCase());
            }
            stringBuilder2.append(' ');
            n4 = ++n2;
        }
        return stringBuilder.substring(0, a2.length());
    }

    public static /* synthetic */ String codeString(String a2) throws FileNotFoundException {
        return StringUtil.codeString(new File(a2));
    }
}

