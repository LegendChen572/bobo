/*
 * Decompiled with CFR 0.150.
 */
package server.swing.tools;

import FuckingHackerToby.ka;
import tools.ConcurrentEnumMap;

public class Encoding {
    public static /* synthetic */ int EUC_JP;
    public static /* synthetic */ int ASCII;
    public static /* synthetic */ int SJIS;
    public static /* synthetic */ int OTHER;
    public static /* synthetic */ int ISO2022CN;
    public static /* synthetic */ int JOHAB;
    public static /* synthetic */ String[] nicename;
    public static /* synthetic */ int ISO2022KR;
    public static /* synthetic */ int CNS11643;
    public static /* synthetic */ int CP949;
    public static /* synthetic */ int EUC_KR;
    public static /* synthetic */ int TOTALTYPES;
    public static /* synthetic */ int GB2312;
    public static /* synthetic */ int GBK;
    public static final /* synthetic */ int SIMP = 0;
    public static /* synthetic */ int ISO2022CN_GB;
    public static /* synthetic */ String[] htmlname;
    public static /* synthetic */ int ISO2022CN_CNS;
    public static /* synthetic */ int GB18030;
    public static final /* synthetic */ int TRAD = 1;
    public static /* synthetic */ int HZ;
    public static /* synthetic */ int UTF8;
    public static /* synthetic */ int UNICODES;
    public static /* synthetic */ String[] javaname;
    public static /* synthetic */ int UNICODE;
    public static /* synthetic */ int UTF8S;
    public static /* synthetic */ int ISO2022JP;
    public static /* synthetic */ int BIG5;
    public static /* synthetic */ int UNICODET;
    public static /* synthetic */ int UTF8T;

    public static /* synthetic */ {
        GB2312 = 0;
        GBK = 1;
        GB18030 = 2;
        HZ = 3;
        BIG5 = 4;
        CNS11643 = 5;
        UTF8 = 6;
        UTF8T = 7;
        UTF8S = 8;
        UNICODE = 9;
        UNICODET = 10;
        UNICODES = 11;
        ISO2022CN = 12;
        ISO2022CN_CNS = 13;
        ISO2022CN_GB = 14;
        EUC_KR = 15;
        CP949 = 16;
        ISO2022KR = 17;
        JOHAB = 18;
        SJIS = 19;
        EUC_JP = 20;
        ISO2022JP = 21;
        ASCII = 22;
        OTHER = 23;
        TOTALTYPES = 24;
    }

    public /* synthetic */ Encoding() {
        Encoding a2;
        javaname = new String[TOTALTYPES];
        nicename = new String[TOTALTYPES];
        htmlname = new String[TOTALTYPES];
        Encoding.javaname[Encoding.GB2312] = ConcurrentEnumMap.ALLATORIxDEMO("\u001e,k]h\\");
        Encoding.javaname[Encoding.GBK] = ka.H("!W-");
        Encoding.javaname[Encoding.GB18030] = ConcurrentEnumMap.ALLATORIxDEMO(")\u001b_a^j^");
        Encoding.javaname[Encoding.HZ] = ka.H("'F%\\/");
        Encoding.javaname[Encoding.ISO2022CN_GB] = ConcurrentEnumMap.ALLATORIxDEMO("\u0010=\u0016\\i\\k-\u00171\u001e,");
        Encoding.javaname[Encoding.BIG5] = ka.H("W/RS");
        Encoding.javaname[Encoding.CNS11643] = ConcurrentEnumMap.ALLATORIxDEMO("\u001c;\u001aC\r9");
        Encoding.javaname[Encoding.ISO2022CN_CNS] = ka.H("/F)'V'TV(J%[5");
        Encoding.javaname[Encoding.ISO2022CN] = ConcurrentEnumMap.ALLATORIxDEMO("'\n!k^k\\\u001a ");
        Encoding.javaname[Encoding.UTF8] = ka.H("3A 8^");
        Encoding.javaname[Encoding.UTF8T] = ConcurrentEnumMap.ALLATORIxDEMO(";\r(tV");
        Encoding.javaname[Encoding.UTF8S] = ka.H("3A 8^");
        Encoding.javaname[Encoding.UNICODE] = ConcurrentEnumMap.ALLATORIxDEMO(";7\u0007:\u0001=\u000b");
        Encoding.javaname[Encoding.UNICODET] = ka.H("3{\u000fv\tq\u0003");
        Encoding.javaname[Encoding.UNICODES] = ConcurrentEnumMap.ALLATORIxDEMO(";7\u0007:\u0001=\u000b");
        Encoding.javaname[Encoding.EUC_KR] = ka.H("P3V9^4");
        Encoding.javaname[Encoding.CP949] = ConcurrentEnumMap.ALLATORIxDEMO("#\nWmW");
        Encoding.javaname[Encoding.ISO2022KR] = ka.H("/F)'V'T^4");
        Encoding.javaname[Encoding.JOHAB] = ConcurrentEnumMap.ALLATORIxDEMO("$6\u00068\f");
        Encoding.javaname[Encoding.SJIS] = ka.H("F,\\5");
        Encoding.javaname[Encoding.EUC_JP] = ConcurrentEnumMap.ALLATORIxDEMO("\u001c;\u001a1\u0013>");
        Encoding.javaname[Encoding.ISO2022JP] = ka.H("/F)'V'T_6");
        Encoding.javaname[Encoding.ASCII] = ConcurrentEnumMap.ALLATORIxDEMO("/\n-\u0010'");
        Encoding.javaname[Encoding.OTHER] = ka.H("/F)-^ _JW");
        Encoding.htmlname[Encoding.GB2312] = ConcurrentEnumMap.ALLATORIxDEMO("\u001e,k]h\\");
        Encoding.htmlname[Encoding.GBK] = ka.H("!W-");
        Encoding.htmlname[Encoding.GB18030] = ConcurrentEnumMap.ALLATORIxDEMO(")\u001b_a^j^");
        Encoding.htmlname[Encoding.HZ] = ka.H("]<8!WK'U$T");
        Encoding.htmlname[Encoding.ISO2022CN_GB] = ConcurrentEnumMap.ALLATORIxDEMO("'\n!t\\i\\kC\u001a t+\u0001:");
        Encoding.htmlname[Encoding.BIG5] = ka.H("W/RS");
        Encoding.htmlname[Encoding.CNS11643] = ConcurrentEnumMap.ALLATORIxDEMO("\u001c;\u001aC\r9");
        Encoding.htmlname[Encoding.ISO2022CN_CNS] = ka.H("/F)8T%T'KV(8#M2");
        Encoding.htmlname[Encoding.ISO2022CN] = ConcurrentEnumMap.ALLATORIxDEMO("'\n!t\\i\\kC\u001a ");
        Encoding.htmlname[Encoding.UTF8] = ka.H("3A 8^");
        Encoding.htmlname[Encoding.UTF8T] = ConcurrentEnumMap.ALLATORIxDEMO(";\r(tV");
        Encoding.htmlname[Encoding.UTF8S] = ka.H("3A 8^");
        Encoding.htmlname[Encoding.UNICODE] = ConcurrentEnumMap.ALLATORIxDEMO("\f:\u001fChX");
        Encoding.htmlname[Encoding.UNICODET] = ka.H("@2SK$P");
        Encoding.htmlname[Encoding.UNICODES] = ConcurrentEnumMap.ALLATORIxDEMO("\f:\u001fChX");
        Encoding.htmlname[Encoding.EUC_KR] = ka.H("P3VK^4");
        Encoding.htmlname[Encoding.CP949] = ConcurrentEnumMap.ALLATORIxDEMO("\u0016t\u00190\u0000=\u0001.\u001dtWmW");
        Encoding.htmlname[Encoding.ISO2022KR] = ka.H("/F)8T%T'K^4");
        Encoding.htmlname[Encoding.JOHAB] = ConcurrentEnumMap.ALLATORIxDEMO("\u0016t$6\u00068\f");
        Encoding.htmlname[Encoding.SJIS] = ka.H("5}\u000fs\u0012J,\\5");
        Encoding.htmlname[Encoding.EUC_JP] = ConcurrentEnumMap.ALLATORIxDEMO("\u001c;\u001aC\u0013>");
        Encoding.htmlname[Encoding.ISO2022JP] = ka.H("/F)8T%T'K_6");
        Encoding.htmlname[Encoding.ASCII] = ConcurrentEnumMap.ALLATORIxDEMO("/\n-\u0010'");
        Encoding.htmlname[Encoding.OTHER] = ka.H("/F)-^ _8W");
        Encoding.nicename[Encoding.GB2312] = ConcurrentEnumMap.ALLATORIxDEMO(")\u001bCk]h\\");
        Encoding.nicename[Encoding.GBK] = ka.H("!W-");
        Encoding.nicename[Encoding.GB18030] = ConcurrentEnumMap.ALLATORIxDEMO(")\u001b_a^j^");
        Encoding.nicename[Encoding.HZ] = ka.H("]<");
        Encoding.nicename[Encoding.ISO2022CN_GB] = ConcurrentEnumMap.ALLATORIxDEMO("\u0010=\u0016\\i\\k-\u0017C\u001e,");
        Encoding.nicename[Encoding.BIG5] = ka.H("W\u000frS");
        Encoding.nicename[Encoding.CNS11643] = ConcurrentEnumMap.ALLATORIxDEMO("\u001a \n_hXm]");
        Encoding.nicename[Encoding.ISO2022CN_CNS] = ka.H("/F)'V'TV(8%[5");
        Encoding.nicename[Encoding.ISO2022CN] = ConcurrentEnumMap.ALLATORIxDEMO("\u0010=\u0016\\i\\kN\u001a ");
        Encoding.nicename[Encoding.UTF8] = ka.H("3A 8^");
        Encoding.nicename[Encoding.UTF8T] = ConcurrentEnumMap.ALLATORIxDEMO("\f:\u001fCaNq:+\u000f=G");
        Encoding.nicename[Encoding.UTF8S] = ka.H("@2SK-F=5|\u000beO");
        Encoding.nicename[Encoding.UNICODE] = ConcurrentEnumMap.ALLATORIxDEMO(";7\u0007:\u0001=\u000b");
        Encoding.nicename[Encoding.UNICODET] = ka.H("@\b|\u0005z\u0002pF=2g\u0007qO");
        Encoding.nicename[Encoding.UNICODES] = ConcurrentEnumMap.ALLATORIxDEMO("\f\u00000\r6\n<Nq=0\u0003)G");
        Encoding.nicename[Encoding.EUC_KR] = ka.H("P3VK^4");
        Encoding.nicename[Encoding.CP949] = ConcurrentEnumMap.ALLATORIxDEMO("-\tWmW");
        Encoding.nicename[Encoding.ISO2022KR] = ka.H("/F)5T%T'F^4");
        Encoding.nicename[Encoding.JOHAB] = ConcurrentEnumMap.ALLATORIxDEMO("$6\u00068\f");
        Encoding.nicename[Encoding.SJIS] = ka.H("5}\u000fs\u00128,\\5");
        Encoding.nicename[Encoding.EUC_JP] = ConcurrentEnumMap.ALLATORIxDEMO("\u001c;\u001aC\u0013>");
        Encoding.nicename[Encoding.ISO2022JP] = ka.H("/F)5T%T'F_6");
        Encoding.nicename[Encoding.ASCII] = ConcurrentEnumMap.ALLATORIxDEMO("/\n-\u0010'");
        Encoding.nicename[Encoding.OTHER] = ka.H(")A.P4");
    }
}

