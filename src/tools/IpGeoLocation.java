/*
 * Decompiled with CFR 0.150.
 */
package tools;

import client.MapleCharacter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import server.Randomizer;
import tools.Quadra;
import tools.html.getHtml;
import tools.wztosql.DumpMobName;

public class IpGeoLocation {
    public static /* synthetic */ Map<String, List<String>> \u7dda\u4e0a\u4eba\u6578\u5206\u4f48;

    public static /* synthetic */ void addPlayerLocation(MapleCharacter a2) {
        MapleCharacter mapleCharacter = a2;
        String string = IpGeoLocation.getGeoLocation(mapleCharacter.getClient().getSessionIPAddress());
        String string2 = mapleCharacter.getName();
        if (!string.equals(DumpMobName.ALLATORIxDEMO("\u571e\u5be6/p\u5725\u5310/"))) {
            if (\u7dda\u4e0a\u4eba\u6578\u5206\u4f48.containsKey(string)) {
                if (!\u7dda\u4e0a\u4eba\u6578\u5206\u4f48.get(string).contains(string2)) {
                    \u7dda\u4e0a\u4eba\u6578\u5206\u4f48.get(string).add(string2);
                    return;
                }
            } else {
                LinkedList<String> linkedList = new LinkedList<String>();
                linkedList.add(string2);
                \u7dda\u4e0a\u4eba\u6578\u5206\u4f48.put(string, linkedList);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ String getCity(String a2) {
        int n2;
        block52: {
            if ((a2 = a2.replaceAll(" ", "")).contains(Quadra.ALLATORIxDEMO("u B0"))) {
                a2 = a2.replace(DumpMobName.ALLATORIxDEMO("5\u0013|$l"), "");
            }
            if (a2.contains(Quadra.ALLATORIxDEMO("u&C'B0"))) {
                a2 = a2.replace(DumpMobName.ALLATORIxDEMO("5\u0013z%{$l"), "");
            }
            String string = a2;
            int n3 = -1;
            switch (string.hashCode()) {
                case -1797291544: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("b(_>W'"))) break;
                    n2 = n3 = 0;
                    break block52;
                }
                case -391340195: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u0018z>r\u001bz>r"))) break;
                    n2 = n3 = 1;
                    break block52;
                }
                case 71341030: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("\u0003W9W'"))) break;
                    n2 = n3 = 2;
                    break block52;
                }
                case 131201883: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u001dt<t)f9t"))) break;
                    n2 = n3 = 3;
                    break block52;
                }
                case 831452589: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("\u0002S,Z<X."))) break;
                    n2 = n3 = 4;
                    break block52;
                }
                case -1797298152: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u0004t9e5|"))) break;
                    n2 = n3 = 5;
                    break block52;
                }
                case 85428329: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("\u0010_%W'"))) break;
                    n2 = n3 = 6;
                    break block52;
                }
                case 124156619: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("A1z)`1{"))) break;
                    n2 = n3 = 7;
                    break block52;
                }
                case -1426514144: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("\u0001E X*^<"))) break;
                    n2 = n3 = 8;
                    break block52;
                }
                case -1990553113: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u001d|1z<|"))) break;
                    n2 = n3 = 9;
                    break block52;
                }
                case -638572435: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("b(_*^<X."))) break;
                    n2 = n3 = 10;
                    break block52;
                }
                case 1497064863: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u0013}1{7}%t"))) break;
                    n2 = n3 = 11;
                    break block52;
                }
                case -1635536737: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("o<X%_'"))) break;
                    n2 = n3 = 12;
                    break block52;
                }
                case -1968919937: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u001et>a?`"))) break;
                    n2 = n3 = 13;
                    break block52;
                }
                case 2017424429: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("u!_(O "))) break;
                    n2 = n3 = 14;
                    break block52;
                }
                case -1797300193: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u0004t9{1{"))) break;
                    n2 = n3 = 15;
                    break block52;
                }
                case 1949320809: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("\u0002W&^:_<X."))) break;
                    n2 = n3 = 16;
                    break block52;
                }
                case -362586996: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u0000|>r$`>r"))) break;
                    n2 = n3 = 17;
                    break block52;
                }
                case 118466934: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("\u001dW B<X."))) break;
                    n2 = n3 = 18;
                    break block52;
                }
                case -1376697926: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("]%t<|5{"))) break;
                    n2 = n3 = 19;
                    break block52;
                }
                case -1907980261: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("f,X.^<"))) break;
                    n2 = n3 = 20;
                    break block52;
                }
                case -2047426266: {
                    if (!string.equals(DumpMobName.ALLATORIxDEMO("\u001b|>x5{"))) break;
                    n2 = n3 = 21;
                    break block52;
                }
                case -1149383364: {
                    if (!string.equals(Quadra.ALLATORIxDEMO("z S'U!_(X."))) break;
                    n3 = 22;
                }
            }
            n2 = n3;
        }
        switch (n2) {
            case 0: {
                return DumpMobName.ALLATORIxDEMO("\u81aa\u7076");
            }
            case 1: {
                return Quadra.ALLATORIxDEMO("\u99af\u6e66");
            }
            case 2: {
                return DumpMobName.ALLATORIxDEMO("\u65b5\u6739");
            }
            case 3: {
                return Quadra.ALLATORIxDEMO("\u999a\u4fcf\u8949\u4ed7");
            }
            case 4: {
                return DumpMobName.ALLATORIxDEMO("\u57aa\u9693");
            }
            case 5: {
                return Quadra.ALLATORIxDEMO("\u81cc\u535e");
            }
            case 6: {
                return DumpMobName.ALLATORIxDEMO("\u5bcc\u8638");
            }
            case 7: {
                return Quadra.ALLATORIxDEMO("\u6875\u575b");
            }
            case 8: {
                return DumpMobName.ALLATORIxDEMO("\u65e0\u7aec");
            }
            case 9: {
                return Quadra.ALLATORIxDEMO("\u82e1\u685e");
            }
            case 10: {
                return DumpMobName.ALLATORIxDEMO("\u81aa\u4e38");
            }
            case 11: {
                return Quadra.ALLATORIxDEMO("\u5f46\u535f");
            }
            case 12: {
                return DumpMobName.ALLATORIxDEMO("\u96a2\u6782");
            }
            case 13: {
                return Quadra.ALLATORIxDEMO("\u5361\u62dc");
            }
            case 14: {
                return DumpMobName.ALLATORIxDEMO("\u5659\u7fbc");
            }
            case 15: {
                return Quadra.ALLATORIxDEMO("\u81cc\u531e");
            }
            case 16: {
                return DumpMobName.ALLATORIxDEMO("\u9a88\u96d1");
            }
            case 17: {
                return Quadra.ALLATORIxDEMO("\u5c79\u6738");
            }
            case 18: {
                return DumpMobName.ALLATORIxDEMO("\u81aa\u6764");
            }
            case 19: {
                return Quadra.ALLATORIxDEMO("\u8287\u84a7");
            }
            case 20: {
                return DumpMobName.ALLATORIxDEMO("\u6fde\u6e43");
            }
            case 21: {
                return Quadra.ALLATORIxDEMO("\u91e7\u95c9");
            }
            case 22: {
                return DumpMobName.ALLATORIxDEMO("\u9073\u6c4a");
            }
        }
        return a2;
    }

    public static /* synthetic */ String sendNote(MapleCharacter a2, String a3) {
        List<String> list = \u7dda\u4e0a\u4eba\u6578\u5206\u4f48.get(a2.getGeoLocation());
        String string = "";
        if (list.size() > 1) {
            List<String> list2 = list;
            String string2 = string = list2.get(Randomizer.rand(0, list2.size() - 1));
            while (string2.equals(a2.getName())) {
                List<String> list3 = list;
                string2 = list3.get(Randomizer.rand(0, list3.size() - 1));
            }
        } else {
            return DumpMobName.ALLATORIxDEMO("\u60bd\u6210\u573d\u76d4\u5355\u578f\u6c87\u6759\u5163\u4e86\u73bc\u5be64");
        }
        a2.sendNote(string, a3);
        return "\u60a8\u5df2\u7d93\u6210\u529f\u767c\u9001\u8a0a\u606f\u7d66\u8207\u60a8\u76f8\u540c\u5730\u5340\u7684\u73a9\u5bb6:" + string + " ! \u795d\u4f60\u5011\u6210\u70ba\u597d\u53cb\u3002";
    }

    public static /* synthetic */ String getGeoLocation(String a2) {
        int n2;
        String string = "";
        String string2 = "";
        a2 = a2.replace("/", "");
        String[] arrstring = getHtml.getHtmlContent("http://ip-api.com/json/" + a2 + "?lang=EN").split(Quadra.ALLATORIxDEMO("e"));
        int n3 = arrstring.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string3 = arrstring[n2];
            if (string3.contains(DumpMobName.ALLATORIxDEMO("73z%{$g)7j7"))) {
                string = string3.replaceAll(Quadra.ALLATORIxDEMO("k"), "").replace(DumpMobName.ALLATORIxDEMO("3z%{$g)/"), "");
            } else if (string3.contains(Quadra.ALLATORIxDEMO("\u0014;S._&X\u0007W$Sk\fk"))) {
                string2 = string3.replaceAll(DumpMobName.ALLATORIxDEMO("7"), "").replace(Quadra.ALLATORIxDEMO(";S._&X\u0007W$Ss"), "");
            }
            n4 = ++n2;
        }
        if (string.isEmpty()) {
            string = DumpMobName.ALLATORIxDEMO("\u677a\u77f0");
        }
        if (string2.isEmpty()) {
            string2 = Quadra.ALLATORIxDEMO("\u671c\u77ac");
        }
        return "\u570b\u5bb6:" + IpGeoLocation.getCity(string) + " \u5730\u5340:" + IpGeoLocation.getCity(string2);
    }

    public /* synthetic */ IpGeoLocation() {
        IpGeoLocation a2;
    }

    public static /* synthetic */ String getInfo() {
        Iterator<Map.Entry<String, List<String>>> iterator;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> iterator2 = iterator = \u7dda\u4e0a\u4eba\u6578\u5206\u4f48.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            Object[] arrobject = new Object[2];
            arrobject[0] = entry.getKey();
            arrobject[1] = " \u4eba\u6578: " + entry.getValue().size() + " \u4eba\r\n";
            stringBuilder.append(String.format(Quadra.ALLATORIxDEMO("\u0013d\u0003:?l\u001bx\u0006:"), arrobject));
            iterator2 = iterator;
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ {
        \u7dda\u4e0a\u4eba\u6578\u5206\u4f48 = new HashMap<String, List<String>>();
    }
}

