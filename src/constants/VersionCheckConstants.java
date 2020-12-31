/*
 * Decompiled with CFR 0.150.
 */
package constants;

import handling.world.MapleParty;
import java.util.Map;
import tools.JsonMapConverter;
import tools.crypt.AESOperator;
import tools.data.ByteArrayByteStream;
import tools.html.getHtml;

public class VersionCheckConstants {
    private static /* synthetic */ String d;
    private static /* synthetic */ int ALLATORIxDEMO;

    public static /* synthetic */ String getCryptData(int a2) {
        String string = "{\"version\":" + a2 + "}";
        return AESOperator.getInstance().encrypt(string);
    }

    public static /* synthetic */ {
        d = "http://bobofiles.tk/bobo/BOBO.txt";
        ALLATORIxDEMO = 1;
    }

    public /* synthetic */ VersionCheckConstants() {
        VersionCheckConstants a2;
    }

    public static /* synthetic */ boolean isNowVersion() {
        boolean bl;
        block4: {
            bl = false;
            String string = getHtml.getHtmlContent(d);
            if (string.isEmpty()) break block4;
            Map<String, Integer> map = JsonMapConverter.JsonToMap(AESOperator.getInstance().decrypt(string));
            if (!map.isEmpty() && map.get(ByteArrayByteStream.ALLATORIxDEMO("AHE^^BY")) == ALLATORIxDEMO) {
                bl = true;
            }
        }
        try {
            System.out.println(MapleParty.ALLATORIxDEMO("\u628a\u53a6\u5928\u65278"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return bl;
    }
}

