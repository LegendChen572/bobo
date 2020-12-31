/*
 * Decompiled with CFR 0.150.
 */
package constants;

import client.MapleCoolDownValueHolder;
import client.MapleKeyLayout;
import client.inventory.MapleImp;
import java.util.HashMap;
import java.util.Map;
import tools.KoreanDateUtil;

public class PiPiConfig {
    public static /* synthetic */ Map<Integer, String> BlackList;
    public static /* synthetic */ Map<String, String> CustomCurseText;
    public static /* synthetic */ String[] banText;
    public static /* synthetic */ boolean Start_Check;
    public static /* synthetic */ boolean CommandLock;
    public static /* synthetic */ String acc;

    public static /* synthetic */ boolean doCheck(String a2) {
        return a2.equals(PiPiConfig.acc);
    }

    public static /* synthetic */ void setCommandLock(boolean a2) {
        CommandLock = a2;
    }

    public static /* synthetic */ boolean getCommandLock() {
        return CommandLock;
    }

    public static /* synthetic */ {
        Start_Check = true;
        CommandLock = false;
        acc = "nocommercialuse";
        String[] arrstring = new String[3];
        arrstring[0] = KoreanDateUtil.ALLATORIxDEMO("\u96e4\u67ed");
        arrstring[1] = MapleKeyLayout.ALLATORIxDEMO("\u8633\u5c14\u93d3");
        arrstring[2] = KoreanDateUtil.ALLATORIxDEMO("\u9878\u5341\u8d95");
        banText = arrstring;
        BlackList = new HashMap(){
            {
                1 a2;
            }
        };
        CustomCurseText = new HashMap(){
            {
                2 a2;
                2 v0 = a2;
                v0.put(MapleImp.ALLATORIxDEMO("\u6db6"), MapleCoolDownValueHolder.ALLATORIxDEMO("\t"));
                a2.put(MapleImp.ALLATORIxDEMO("\u57bc\u576e"), MapleCoolDownValueHolder.ALLATORIxDEMO("q\t"));
                a2.put(MapleImp.ALLATORIxDEMO("\u96e9\u5c5f"), MapleCoolDownValueHolder.ALLATORIxDEMO("q\t"));
                a2.put(MapleImp.ALLATORIxDEMO("\u6ca6\u5c5f"), MapleCoolDownValueHolder.ALLATORIxDEMO("q\t"));
                a2.put(MapleImp.ALLATORIxDEMO("\u4e36\u5c5f"), MapleCoolDownValueHolder.ALLATORIxDEMO("q\t"));
            }
        };
    }

    public /* synthetic */ PiPiConfig() {
        PiPiConfig a2;
    }

    public static /* synthetic */ boolean isCanTalkText(String a2) {
        int n2;
        String string = a2.toLowerCase();
        int n3 = n2 = 0;
        while (n3 < banText.length) {
            if (string.contains(banText[n2])) {
                return false;
            }
            n3 = ++n2;
        }
        return !(string.contains(KoreanDateUtil.ALLATORIxDEMO("\u57f9")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5743")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u96ac")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5c72")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u6ce3")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5c72")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u6bc0")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5c72")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u4e73")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5c72")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u536d")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u4e7e")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u536d")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("J")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5d8e")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u4e7e")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5d8e")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("J")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5111")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u4e7e")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5111")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("J")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u7607")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u7693")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u7607")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u761c")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u7607")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u547e")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u7607")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u3169")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u7607")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u3165")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u6a25")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8eb7")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u6a25")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5116")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u4f4c")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u536a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u67ed")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u536a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5e98")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u7214")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5ac7")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u76f9")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u4fad")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8fde")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u6600")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u96e1")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u4f34")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8080")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u4e04")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5a65")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u3174")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u3178")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u3176")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u316d")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u3171")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u315d")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u02bd")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u3170")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u02b1")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u0018\u001aI")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u7618")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u761f")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8c4d")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5954")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5878")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8c4a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u600a")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u600d")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8c4d")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u593a")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u593d")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8c4a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8fc8")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8598")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8c4d")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5490")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5497")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8c4a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5674")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5673")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8c4d")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u68b4")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u82cb")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8c4a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u56a4")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u61cb")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8c4d")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5503")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u54d0")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8c4a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u55fd")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5390")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u8c4d")) || string.contains(MapleKeyLayout.ALLATORIxDEMO("\u7676")) && string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5b2a")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u8c4a")) || string.contains(KoreanDateUtil.ALLATORIxDEMO("\u82cb")) && string.contains(MapleKeyLayout.ALLATORIxDEMO("\u9e02"))) && (!string.contains(KoreanDateUtil.ALLATORIxDEMO("\u5958")) || !string.contains(MapleKeyLayout.ALLATORIxDEMO("\u5e06")));
    }

    public static /* synthetic */ Map<Integer, String> getBlackList() {
        return BlackList;
    }

    public static /* synthetic */ void setBlackList(int a2, String a3) {
        BlackList.put(a2, a3);
    }
}

