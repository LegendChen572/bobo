/*
 * Decompiled with CFR 0.150.
 */
package server.game;

import handling.channel.handler.UserInterfaceHandler;
import java.io.IOException;
import server.maps.MapleFoothold;
import tools.html.JsoupTool;

public class Cryptocurrency {
    public static /* synthetic */ int BTC_TodayBuy;
    public static /* synthetic */ int ETHPrice;
    public static /* synthetic */ int BTCPrice;
    public static /* synthetic */ int ETH_TodaySell;
    public static /* synthetic */ int LTC_TodaySell;
    public static /* synthetic */ int LTCPrice;
    public static /* synthetic */ int BTC_TodaySell;
    public static /* synthetic */ int ETH_TodayBuy;
    public static /* synthetic */ int LTC_TodayBuy;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int HandlePrice(String a2, int a3) {
        int n2;
        int n3;
        block15: {
            n3 = 0;
            String string = a2;
            int n4 = -1;
            switch (string.hashCode()) {
                case 66097: {
                    if (!string.equals(MapleFoothold.ALLATORIxDEMO("\u001e\u0004\u001f"))) break;
                    n2 = n4 = 0;
                    break block15;
                }
                case 68985: {
                    if (!string.equals(UserInterfaceHandler.ALLATORIxDEMO("qo|"))) break;
                    n2 = n4 = 1;
                    break block15;
                }
                case 75707: {
                    if (!string.equals(MapleFoothold.ALLATORIxDEMO("\u0010\u0004\u001f"))) break;
                    n4 = 2;
                }
            }
            n2 = n4;
        }
        switch (n2) {
            case 0: {
                if (a3 > 0) {
                    BTC_TodayBuy += a3;
                    return n3;
                }
                BTC_TodaySell += Math.abs(a3);
                return n3;
            }
            case 1: {
                if (a3 > 0) {
                    ETH_TodayBuy += a3;
                    return ETHPrice;
                } else {
                    ETH_TodaySell += Math.abs(a3);
                }
                return ETHPrice;
            }
            case 2: {
                if (a3 > 0) {
                    LTC_TodayBuy += a3;
                    return LTCPrice;
                } else {
                    LTC_TodaySell += Math.abs(a3);
                }
                return LTCPrice;
            }
        }
        return n3;
    }

    public static /* synthetic */ void loadPrize() throws IOException {
        BTCPrice = (int)Double.parseDouble(JsoupTool.getData(UserInterfaceHandler.ALLATORIxDEMO("S@ODH\u000e\u0014\u001bXFBDO[\u0015WUM^G\u0015WTY\u0014vow\u0014\u0006\u000f\\")).replaceFirst(MapleFoothold.ALLATORIxDEMO("p"), ""));
        ETHPrice = (int)Double.parseDouble(JsoupTool.getData(UserInterfaceHandler.ALLATORIxDEMO("S@ODH\u000e\u0014\u001bXFBDO[\u0015WUM^G\u0015WTY\u0014qo|\u0014\u0006\u000f\\")));
        LTCPrice = (int)Double.parseDouble(JsoupTool.getData(MapleFoothold.ALLATORIxDEMO("8($,#f\u007fs3.),$3~?>%5/~??1\u007f\u0010\u0004\u001f\u007fnd4")));
        System.out.println(UserInterfaceHandler.ALLATORIxDEMO("\u76da\u5276\u866f\u64d7\u8c9c\u5e58\u50cd\u6807\u000e"));
        System.out.println("BTC: " + BTCPrice + "\u9382\u5143");
        System.out.println("ETH: " + ETHPrice + "\u9382\u5143");
        System.out.println("LTC: " + LTCPrice + "\u9382\u5143");
    }

    public static /* synthetic */ String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MapleFoothold.ALLATORIxDEMO("\u007f2|p|p|p|p|p|p|p|p\u4e96\u65b5\u8607\u64bc\u8cf4\u5e33\u4ef8\u6643\u9193]V"));
        stringBuilder.append("               #bBTC: \u8cb7\u5165:#r" + BTC_TodayBuy + " #b\u9846 \u8ce3\u51fa:#r" + BTC_TodaySell + " #b\u9846 \r\n");
        stringBuilder.append("               #bETH: \u8cb7\u5165:#r" + ETH_TodayBuy + " #b\u9846 \u8ce3\u51fa:#r" + ETH_TodaySell + " #b\u9846 \r\n");
        stringBuilder.append("               #bLTC: \u8cb7\u5165:#r" + LTC_TodayBuy + " #b\u9846 \u8ce3\u51fa:#r" + LTC_TodaySell + " #b\u9846 \r\n");
        return stringBuilder.toString();
    }

    public static /* synthetic */ {
        BTCPrice = 0;
        BTC_TodayBuy = 0;
        BTC_TodaySell = 0;
        ETHPrice = 0;
        ETH_TodayBuy = 0;
        ETH_TodaySell = 0;
        LTCPrice = 0;
        LTC_TodayBuy = 0;
        LTC_TodaySell = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getPrice(String a2) {
        int n2;
        int n3;
        block10: {
            n3 = 0;
            String string = a2;
            int n4 = -1;
            switch (string.hashCode()) {
                case 66097: {
                    if (!string.equals(UserInterfaceHandler.ALLATORIxDEMO("vow"))) break;
                    n2 = n4 = 0;
                    break block10;
                }
                case 68985: {
                    if (!string.equals(MapleFoothold.ALLATORIxDEMO("\u0019\u0004\u0014"))) break;
                    n2 = n4 = 1;
                    break block10;
                }
                case 75707: {
                    if (!string.equals(UserInterfaceHandler.ALLATORIxDEMO("xow"))) break;
                    n4 = 2;
                }
            }
            n2 = n4;
        }
        switch (n2) {
            case 0: {
                return BTCPrice;
            }
            case 1: {
                return ETHPrice;
            }
            case 2: {
                return LTCPrice;
            }
        }
        return n3;
    }

    public /* synthetic */ Cryptocurrency() {
        Cryptocurrency a2;
    }
}

