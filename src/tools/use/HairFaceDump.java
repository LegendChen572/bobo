/*
 * Decompiled with CFR 0.150.
 */
package tools.use;

import client.SkillEntry;
import client.messages.commands.InternCommand;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import provider.MapleDataDirectoryEntry;
import provider.MapleDataFileEntry;
import provider.MapleDataProviderFactory;

public class HairFaceDump {
    public static /* synthetic */ int number;

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isFemaleHair(int a2) {
        if (a2 % 10 != 0) {
            return false;
        }
        if (a2 == 32160 || a2 == 32330 || a2 == 34740) {
            return false;
        }
        if (a2 / 1000 == 31 || a2 / 1000 == 34 || a2 / 1000 == 32 && a2 < 32370 || a2 / 1000 == 37 && a2 < 37160) {
            return true;
        }
        switch (a2) {
            case 33030: 
            case 33160: 
            case 33590: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void main(String[] a2) throws IOException {
        int n2;
        System.out.println(InternCommand.ALLATORIxDEMO("\u000f\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&;&\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0012\u000f\u0012%\u0011%\u0011%\u0011%\u0011&\u0012%\u0012%\u0011%\u0012%\u0011%\u0011&\u0012%\u0012&\u0012%\u0012&\u0012%\u0012&\u0011%\u0012&\u0012%\u0011%\u0011%\u0011%\u0011&;&\u0011%\u0011%\u0011%\u0011&\u0011&\u0011&\u0011%\u0011&\u0011%\u0011&\u0011&\u0011%\u0012%\u0011&\u0011&\u0011&\u0011&\u0011%\u0012%\u0011%\u0011%\u0011%\u0011%\u0012\u000f\u0012%\u0011%\u0011%\u0011%\u0012&\u0012%\u0012%\u0011%\u0012%\u0011%\u0012&\u0012%\u0011&\u0011%\u0012%\u0012%\u0012&\u0011%\u0011&\u0011%\u0011%\u0011%\u0011%\u0011&;&\u0011%\u0011%\u0011%\u0011&\u0011&\u0011&\u0012&\u0011&\u0012&\u0011&\u0011&\u0011%\u0012%\u0011&\u0012&\u0011&\u0011&\u0011&\u0012&\u0011%\u0011%\u0011%\u0011%\u0012\u000f\u0012%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011&;&\u0011JScDvRdEl^k\u0011gH%pi]dEjCl\u0011JScDvRdEjC%G2\u001f6\u0011AtH~%\u0012\u000f\u0012%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011&;&\u0011%\u0011%\u0011%\u0011%\u0011%\u0011mEqA?\u001e*FrF+Pi]dEjCl\u001ff^h\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0012\u000f\u0012%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011%\u0011&;&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012&\u0012\u000f"));
        Object object2 = MapleDataProviderFactory.getDataProvider(SkillEntry.ALLATORIxDEMO("\u001eVYtCtRaTg\u001fbK:ytXg"));
        StringBuilder stringBuilder = new StringBuilder();
        FileOutputStream fileOutputStream = new FileOutputStream(InternCommand.ALLATORIxDEMO("VE|]`C+[v"), false);
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList3 = new LinkedList<Integer>();
        System.out.println(SkillEntry.ALLATORIxDEMO("\u6b52\u573d\u8f38\u5170\u9adf\u579e"));
        MapleDataDirectoryEntry mapleDataDirectoryEntry = object2.getRoot();
        boolean bl = false;
        int n3 = 0;
        boolean bl2 = false;
        for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
            if (!HairFaceDump.isNumeric(mapleDataFileEntry.getName().substring(0, 8))) continue;
            ++n3;
            n2 = Integer.parseInt(mapleDataFileEntry.getName().substring(0, 8));
            if (!HairFaceDump.isNewHair(n2)) continue;
            linkedList.add(n2);
            bl2 = true;
        }
        ++number;
        bl = false;
        n3 = 0;
        for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
            if (!HairFaceDump.isNumeric(mapleDataFileEntry.getName().substring(0, 8))) continue;
            ++n3;
            n2 = Integer.parseInt(mapleDataFileEntry.getName().substring(0, 8));
            if (!HairFaceDump.isMaleHair(n2)) continue;
            linkedList2.add(n2);
            bl2 = true;
        }
        ++number;
        bl = false;
        n3 = 0;
        for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
            if (!HairFaceDump.isNumeric(mapleDataFileEntry.getName().substring(0, 8))) continue;
            ++n3;
            n2 = Integer.parseInt(mapleDataFileEntry.getName().substring(0, 8));
            if (!HairFaceDump.isFemaleHair(n2)) continue;
            linkedList3.add(n2);
            bl2 = true;
        }
        ++number;
        LinkedList<Integer> linkedList4 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList5 = new LinkedList<Integer>();
        System.out.println(InternCommand.ALLATORIxDEMO("\u8f38\u5160\u770d\u775e"));
        object2 = MapleDataProviderFactory.getDataProvider(SkillEntry.ALLATORIxDEMO("VYtCtRaTg\u001fbK:wtRp"));
        mapleDataDirectoryEntry = object2.getRoot();
        for (MapleDataFileEntry mapleDataFileEntry : mapleDataDirectoryEntry.getFiles()) {
            int n4;
            int n5 = -1;
            try {
                n4 = n5 = Integer.parseInt(mapleDataFileEntry.getName().substring(0, 8));
            }
            catch (Exception exception) {
                n4 = n5;
            }
            if (n4 == -1) continue;
            if (HairFaceDump.isMaleFace(n5)) {
                linkedList4.add(n5);
            }
            if (!HairFaceDump.isFemaleFace(n5)) continue;
            linkedList5.add(n5);
        }
        if (linkedList.isEmpty() || linkedList2.isEmpty() || linkedList3.isEmpty() || linkedList4.isEmpty() || linkedList5.isEmpty()) {
            System.out.println(InternCommand.ALLATORIxDEMO("\u627b\u4e3c\u5235\u4eca\u4f50\u0011\u9aeb\u57ba*\u770d\u775e\u0011+"));
            System.exit(0);
            return;
        }
        stringBuilder.append(HairFaceDump.createStyler(linkedList, linkedList2, linkedList3, linkedList4, linkedList5));
        fileOutputStream.write(stringBuilder.toString().getBytes());
        System.out.println(SkillEntry.ALLATORIxDEMO("\u9035\u57ba[Av\u88cc\u4f49\u5bbd\u6205"));
    }

    public /* synthetic */ HairFaceDump() {
        HairFaceDump a2;
    }

    public static /* synthetic */ boolean hairExists(int a2) {
        Iterator<MapleDataFileEntry> iterator = MapleDataProviderFactory.getDataProvider(InternCommand.ALLATORIxDEMO("FYdCdRqTw\u001frK*ydXw")).getRoot().getFiles().iterator();
        while (iterator.hasNext()) {
            if (Integer.parseInt(iterator.next().getName().substring(0, 8)) != a2) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ String createStyler(List<Integer> a2, List<Integer> a3, List<Integer> a4, List<Integer> a5, List<Integer> a6) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = stringBuilder = new StringBuilder();
        StringBuilder stringBuilder3 = stringBuilder;
        HairFaceDump.addLine(stringBuilder3, InternCommand.ALLATORIxDEMO("sPw\u0011vTi\u00118\u0011(\u0000>"));
        HairFaceDump.addLine(stringBuilder3, SkillEntry.ALLATORIxDEMO("cPg\u0011|_qTmr`E5\f5\u0000'\u0001."));
        HairFaceDump.addLine(stringBuilder2, InternCommand.ALLATORIxDEMO("\u001e*\u7506\u751a\u9adf\u578e"));
        HairFaceDump.addLine(stringBuilder2, "var BoyHairs = " + a3.toString() + ";");
        StringBuilder stringBuilder4 = stringBuilder;
        HairFaceDump.addLine(stringBuilder4, SkillEntry.ALLATORIxDEMO("\u001e:\u5942\u750a\u9adf\u579e"));
        HairFaceDump.addLine(stringBuilder4, "var GirlHairs = " + a4.toString() + ";");
        StringBuilder stringBuilder5 = stringBuilder;
        HairFaceDump.addLine(stringBuilder5, InternCommand.ALLATORIxDEMO("*\u001e1\u95ba\u9828\u9adf\u578e"));
        HairFaceDump.addLine(stringBuilder5, "var NewHairs = " + a2.toString() + ";");
        StringBuilder stringBuilder6 = stringBuilder;
        HairFaceDump.addLine(stringBuilder6, SkillEntry.ALLATORIxDEMO("\u001e:\u7506\u750a\u81f8\u579e"));
        HairFaceDump.addLine(stringBuilder6, "var BoyFaces = " + a5.toString() + ";");
        StringBuilder stringBuilder7 = stringBuilder;
        HairFaceDump.addLine(stringBuilder7, InternCommand.ALLATORIxDEMO("\u001e*\u5942\u751a\u81f8\u578e"));
        HairFaceDump.addLine(stringBuilder7, "var GirlFaces = " + a6.toString() + ";");
        StringBuilder stringBuilder8 = stringBuilder;
        StringBuilder stringBuilder9 = stringBuilder;
        StringBuilder stringBuilder10 = stringBuilder;
        StringBuilder stringBuilder11 = stringBuilder;
        HairFaceDump.addLine(stringBuilder, SkillEntry.ALLATORIxDEMO("\u001e:\u81ab\u8267\u4ed2\u78a9"));
        HairFaceDump.addLine(stringBuilder11, InternCommand.ALLATORIxDEMO("sPw\u0011VZl_f^i^wB%\f%j5\u001d%\u0000)\u00117\u001d%\u0002)\u00111\u0011)\u0007%\u001d2\u0011)\t%\u001d<\u0011)\u00005\u0011)\u00004l>"));
        HairFaceDump.addLine(stringBuilder11, SkillEntry.ALLATORIxDEMO("cPg\u0011[^bytXg\n\u001fGtC5\u007fzFSPvT.;cPg\u0011[^bvp_qTg\n\u001f;cPg\u0011SPvTFTyTvEf\n\u001fGtC5wtRpa`B}\n\u001f;cPg\u0011]P|CV^y^gB.;cPg\u0011]P|CV^y^gbp]pRaB.;\u001fGtC5pgCtHVYz^fT5\f5_pF5pgCtH=\u0018.;\u001fGtC5BaPaDf\u0011(\u00118\u0000."));
        HairFaceDump.addLine(stringBuilder10, InternCommand.ALLATORIxDEMO("sPw\u0011cXsTcPfT%\f%Wd]vT>"));
        HairFaceDump.addLine(stringBuilder10, SkillEntry.ALLATORIxDEMO("cPg\u0011vYpR~\u007ft\\p\u0011(\u0011aC`T."));
        HairFaceDump.addLine(stringBuilder9, InternCommand.ALLATORIxDEMO("cDkRqXj_%BqPwE-\u0018%J\u000f8MPlCF^i^wb`]`RqB%\f%_`F%pwCdH-\u0018>;\fwdR`b`]`RqB%\f%_`F%pwCdH-\u0018>;\f\u007fjFBTkU`C%\f%Rh\u001fbTqaiP|TwbqPq\u0019'v@\u007fAtW\u0013,\n\u000f8MPlCF^i^wB%\f%\u0001>;\f\u007fjFMPlC%\f%Rh\u001fbTqaiP|Tw\u0019,\u001fbTqydXw\u0019,\n\u000f8K^rwdR`\u00118\u0011f\\+V`EU]dH`C-\u0018+V`ECPfT-\u0018>;\fPfEl^k\u00194\u001d%\u0001)\u00115\u0018>;x"));
        HairFaceDump.addLine(stringBuilder9, SkillEntry.ALLATORIxDEMO("W`_vE|^{\u0011tRaXz_=\\zUp\u001d5ElAp\u001d5Bp]pRaXz_<\u0011n"));
        HairFaceDump.addLine(stringBuilder8, InternCommand.ALLATORIxDEMO("Xc\u0011-\\jU`\u00118\f%\u0001%\u0017#\u0011vEdEpB%\f8\u00115\u0018%J\u000f8\f8f\\+UlBu^vT-\u0018>;\f8\fC`EpCk\n\u000f8\fL\u000f8\fXc\u0011-\\jU`\u00118\f%\u0000,\u0011~;\f8\fBqPqDv\u001a.\n\u000f8\fL%TiB`\u0011~;\f8\fRh\u001faXvAjB`\u0019,\n\u000f8\f8wTqDw_>;\f8x"));
        HairFaceDump.addLine(stringBuilder8, SkillEntry.ALLATORIxDEMO("Xs\u0011=BaPaDf\u0011(\f5\u0001<\u0011n;\u001c8\u001cGtC5\\fV5\f5\u00135\u00116C6T\u6b74\u8fff\u8ade\u557e\u60e6\u7519\u4ed5\u9e8d\u9035\u57ba\u5477\u0011\u6204\u5020\u5158\u8c8a\u66e1\u63ea\u5522\u00106SICI_7\n\u001f8\u001c8xBr\u0011>\f5\u00136}%\u00126U\u6204\u60c2\u8b9f\u66c5\u818f\u82436]7\n\u001f8\u001c8xBr\u0011>\f5\u00136}$\u00126C\u6204\u60c2\u8b9f\u66c5\u9afb\u82436]7\n\u001f8\u001c8xBr\u0011>\f5\u0013ICI_ICI_7\n\u001f8\u001c8xBr\u0011>\f5\u00136}'\u00126S\u7522\u752e\u9afb\u57ba6]7\n\u001f8\u001c8xBr\u0011>\f5\u00136}&\u00126S\u5966\u752e\u9afb\u57ba6]7\n\u001f8\u001c8xBr\u0011>\f5\u0013ICI_ICI_7\n\u001f8\u001c8xBr\u0011>\f5\u00136}!\u00126C\u7522\u752e\u81dc\u57ba6]7\n\u001f8\u001c8xBr\u0011>\f5\u00136} \u00126C\u5966\u752e\u81dc\u57ba6]7\n\u001f8\u001c8xBr\u0011>\f5\u0013ICI_ICI_7\n\u001f8\u001c8xBr\u0011>\f5\u00136}#\u0012\u65a5\u7279!\u95ba\u9838\u9adf\u579e\u0019\u5de7\u66c5\u65a5\u00186]7\n\u001f8\u001c8v\\;Bp_q~~\u0019xBr\u0018.;\u001c8h\u0011p]fT5Xs\u0011=BaPaDf\u0011(\f5\u0000<\u0011n;\u001c8\u001cBp]5\f5Bp]pRaXz_.;\u001c8\u001cBbXaR}\u0011=Bp]<\u0011n;\u001c8\u001c8vPfT5\u0001/;\u001c8\u001c8\u001cBp_qbaHyT=b~X{Rz]zCf\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001c8vPfT5\u0000/;\u001c8\u001c8\u001cGtC5R`CgT{E5\f5AtCfT\\_a\u0019[^bytXg\u0011:\u0011$\u0001<\u0011?\u0011$\u0001.;\u001c8\u001c8\u001cWzC5\u0019]P|CV^y^gB.\u0011]P|CV^y^gB5\r5\t.\u0011]P|CV^y^gB>\u001a<;\u001c8\u001c8\u001c8|W5\u0019v\\;XaTxtmXfEf\u0019[^bytXg\u0011>\u0011]P|CV^y^gB<\u0018\u001f8\u001c8\u001c8\u001c8]P|CV^y^gbp]pRaB;A`B}\u0019vDgCp_a\u0011>\u0011]P|CV^y^gB<\n\u001f8\u001c8\u001c8fT{UFEl]p\u0019]P|CV^y^gbp]pRaB<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011'\u000b\u001f8\u001c8\u001c8cPg\u0011xBr\u0011(\u00117\u0013.;\u001c8\u001c8\u001cGtC5B|Kp\u0011(\u0011W^lytXgB;]p_rE}\n\u001f8\u001c8\u001c8cPg\u0011|_qTm\u0011(\u0011ePgBpx{E=B|Kp\u0011:\u0011|_qTmr`E<\u0011>\u0011$\n\u001f8\u001c8\u001c8s^g\u0011=GtC5X5\f5\u0001.\u0011|\u0011)\u0011|_qTm\n5X>\u001a<\u0011n;\u001c8\u001c8\u001c8xBr\u0011>\f5\u0013ICI_6}7\u0011>\u0011|\u0011>\u00117\u00126C5\u0011\u7522\u0011\u750a\u0011\u9afb\u0011\u579e\u00117\u0011>\u0011=X5\u001a5\u0000<\n\u001f8\u001c8\u001c8h;\u001c8\u001c8\u001cRx\u001ffT{UZZ=\\fV<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011&\u000b\u001f8\u001c8\u001c8cPg\u0011xBr\u0011(\u00117\u0013.;\u001c8\u001c8\u001cGtC5B|Kp\u0011(\u0011RXg]]P|Cf\u001fyT{VaY.;\u001c8\u001c8\u001cGtC5X{UpI5\f5AtCfT\\_a\u0019fXoT5\u001e5X{UpIVDa\u00185\u001a5\u0000.;\u001c8\u001c8\u001cWzC5\u0019cPg\u0011|\u0011(\u0011%\n5X5\r5X{UpI.\u0011|\u001a>\u00185J\u001f8\u001c8\u001c8\u001c\\fV5\u001a(\u00117mgm{\u0012Y\u00135\u001a5X5\u001a5\u00136\u0012g\u00115\u59425\u752e5\u9adf5\u57ba5\u00135\u001a5\u0019|\u0011>\u0011$\u0018.;\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8v\\;Bp_q~~\u0019xBr\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001c8vPfT5\u0005/;\u001c8\u001c8\u001cGtC5\\fV5\f5\u00137\n\u001f8\u001c8\u001c8cPg\u0011fXoT5\f5szHSPvTf\u001fyT{VaY.;\u001c8\u001c8\u001cGtC5X{UpI5\f5AtCfT\\_a\u0019fXoT5\u001e5X{UpIVDa\u00185\u001a5\u0000.;\u001c8\u001c8\u001cWzC5\u0019cPg\u0011|\u0011(\u0011%\n5X5\r5X{UpI.\u0011|\u001a>\u00185J\u001f8\u001c8\u001c8\u001c\\fV5\u001a(\u00117mgm{\u0012Y\u00135\u001a5X5\u001a5\u00136\u0012g\u00115\u75065\u752e5\u81f85\u57ba7\u0011>\u0011=X5\u001a5\u0000<\n\u001f8\u001c8\u001c8h;\u001c8\u001c8\u001cRx\u001ffT{UZZ=\\fV<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011 \u000b\u001f8\u001c8\u001c8cPg\u0011xBr\u0011(\u00117\u0013.;\u001c8\u001c8\u001cGtC5B|Kp\u0011(\u0011RXg]SPvTf\u001fyT{VaY.;\u001c8\u001c8\u001cGtC5X{UpI5\f5AtCfT\\_a\u0019fXoT5\u001e5X{UpIVDa\u00185\u001a5\u0000.;\u001c8\u001c8\u001cWzC5\u0019cPg\u0011|\u0011(\u0011%\n5X5\r5X{UpI.\u0011|\u001a>\u00185J\u001f8\u001c8\u001c8\u001c\\fV5\u001a(\u00117mgm{\u0012Y\u00135\u001a5X5\u001a5\u00136\u0012g\u00115\u59425\u752e5\u81f85\u57ba7\u0011>\u0011=X5\u001a5\u0000<\n\u001f8\u001c8\u001c8h;\u001c8\u001c8\u001cRx\u001ffT{UZZ=\\fV<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011#\u000b\u001f8\u001c8\u001c8cPg\u0011xBr\u0011(\u00117\u0013.;\u001c8\u001c8\u001cGtC5B|Kp\u0011(\u0011[TbytXgB;]p_rE}\n\u001f8\u001c8\u001c8cPg\u0011|_qTm\u0011(\u0011ePgBpx{E=B|Kp\u0011:\u0011|_qTmr`E<\u0011>\u0011$\n\u001f8\u001c8\u001c8s^g\u0011=GtC5X5\f5\u0001.\u0011|\u0011)\u0011|_qTm\n5X>\u001a<\u0011n;\u001c8\u001c8\u001c8xBr\u0011>\f5\u0013ICI_6}7\u0011>\u0011|\u0011>\u00117\u00126T5\u65815\u72795\u9adf5\u57ba7\u0011>\u0011=X5\u001a5\u0000<\n\u001f8\u001c8\u001c8h;\u001c8\u001c8\u001cRx\u001ffT{UZZ=\\fV<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cUpWtDyE/;\u001c8\u001c8\u001cRx\u001fqXfAzBp\u0019<\n\u001f8\u001c8\u001c8gTaDg_.;\u001c8\u001cL\u001f8\u001cL5TyBp\u0011|W5\u0019fEtE`B5\f(\u0011'\u00185J\u001f8\u001c8cPg\u0011fTa\u0011(\u0011sPyBp\n\u001f8\u001c8fF|EvY5\u0019fTy\u00185J\u001f8\u001c8\u001cRtBp\u0011%\u000b\u001f8\u001c8\u001c8fTa\u0011(\u0011aC`T.;\u001c8\u001c8\u001cRx\u001ffTab~X{\u0019FZ|_v^y^gBNBp]pRaXz_H\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001c8vPfT5\u0000/;\u001c8\u001c8\u001cBpE5\f5EgDp\n\u001f8\u001c8\u001c8v\\;BpE]P|C=ytXgrz]zCFTyTvEfjfTyTvE|^{l<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011'\u000b\u001f8\u001c8\u001c8cPg\u0011|_qTmBaPgE5\f5Bp]pRaXz_5\u001b5X{UpIVDa\n\u001f8\u001c8\u001c8s^g\u0011=GtC5X5\f5X{UpIfEtCa\n5X5\r5X{UpIfEtCa\u0011>\u0011|_qTmr`E.\u0011|\u001a>\u00185J\u001f8\u001c8\u001c8\u001cXs\u0011=Rx\u001f|Ep\\PI|BaB=szH]P|Cfj|l<\u00185J\u001f8\u001c8\u001c8\u001cXs\u0011=R}TvZ[PxT<\u0011n;\u001c8\u001c8\u001c8\u001cXs\u0011=Rx\u001frTaxaTx\u007ft\\p\u0019W^lytXgBNXH\u00185\f(\u00117\u0013<\u0011n;\u001c8\u001c8\u001c8\u001c8v^{E|_`T.;\u001c8\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8\u001cL\u001c8\u001c8\u001c8\u001cpgCtHVYz^fT;A`B}\u0019W^lytXgBNXH\u0018.;\u001c8\u001c8\u001c8h;\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8fT{UFEl]p\u0019TCgPlr}^zBp\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001c8vPfT5\u0002/;\u001c8\u001c8\u001cGtC5X{UpIfEtCa\u0011(\u0011fTyTvE|^{\u0011?\u0011|_qTmr`E.;\u001c8\u001c8\u001cWzC5\u0019cPg\u0011|\u0011(\u0011|_qTmBaPgE.\u0011|\u0011)\u0011|_qTmBaPgE5\u001a5X{UpIVDa\n5X>\u001a<\u0011n;\u001c8\u001c8\u001c8|W5\u0019v\\;XaTxtmXfEf\u0019RXg]]P|Cfj|l<\u00185J\u001f8|W5\u0019vYpR~\u007ft\\p\u00185J\u001f8\u001c8\u001c8\u001c8|W5\u0019v\\;VpE\\Ep\\[PxT=v|CyytXgBNXH\u00185\f(\u00117\u0013<\u0011n;\u001c8\u001c8\u001c8\u001c8v^{E|_`T.;\u001c8\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8\u001cL\u001c8\u001c8\u001c8\u001cpgCtHVYz^fT;A`B}\u0019RXg]]P|Cfj|l<\n\u001f8\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8h;\u001c8\u001c8\u001cBp_qbaHyT=pgCtHVYz^fT<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011!\u000b\u001f8\u001c8\u001c8cPg\u0011|_qTmBaPgE5\f5Bp]pRaXz_5\u001b5X{UpIVDa\n\u001f8\u001c8\u001c8s^g\u0011=GtC5X5\f5X{UpIfEtCa\n5X5\r5X{UpIfEtCa\u0011>\u0011|_qTmr`E.\u0011|\u001a>\u00185J\u001f8\u001c8\u001c8\u001cXs\u0011=Rx\u001f|Ep\\PI|BaB=szHSPvTfj|l<\u00185J\u001f8|W5\u00194W|GpWtRp\u00185J\u001f8\u001c8\u001c8\u001c8|W5\u0019W^lwtRpBNXH\u0011+\f5\u0004%\u0001%\u0001<\u0011n;\u001c8\u001c8\u001c8\u001c8v^{E|_`T.;\u001c8\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8\u001cL\u001c8\u001c8\u001c8\u001cpgCtHVYz^fT;A`B}\u0019W^lwtRpBNXH\u0018.;\u001c8\u001c8\u001c8h;\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8fT{UFEl]p\u0019TCgPlr}^zBp\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001c8vPfT5\u0004/;\u001c8\u001c8\u001cGtC5X{UpIfEtCa\u0011(\u0011fTyTvE|^{\u0011?\u0011|_qTmr`E.;\u001c8\u001c8\u001cWzC5\u0019cPg\u0011|\u0011(\u0011|_qTmBaPgE.\u0011|\u0011)\u0011|_qTmBaPgE5\u001a5X{UpIVDa\n5X>\u001a<\u0011n;\u001c8\u001c8\u001c8|W5\u0019v\\;XaTxtmXfEf\u0019RXg]SPvTfj|l<\u00185J\u001fXs\u0011=\u0010sXcTsPvT<\u0011n;\u001c8\u001c8\u001c8\u001cXs\u0011=szHSPvTfj|l5\u000f(\u0011 \u0001%\u0001%\u00185J\u001f8\u001c8\u001c8\u001c8\u001cRz_aX{Dp\n\u001f8\u001c8\u001c8\u001c8h;\u001c8\u001c8\u001c8h8\u001c8\u001c8\u001c8TCgPlr}^zBp\u001feDfY=v|CywtRpBNXH\u0018.;\u001c8\u001c8\u001c8h;\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8fT{UFEl]p\u0019TCgPlr}^zBp\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001c8vPfT5\u0007/;\u001c8\u001c8\u001cGtC5X{UpIfEtCa\u0011(\u0011fTyTvE|^{\u0011?\u0011|_qTmr`E.;\u001c8\u001c8\u001cWzC5\u0019cPg\u0011|\u0011(\u0011|_qTmBaPgE.\u0011|\u0011)\u0011|_qTmBaPgE5\u001a5X{UpIVDa\n5X>\u001a<\u0011n;\u001c8\u001c8\u001c8|W5\u0019v\\;XaTxtmXfEf\u0019[TbytXgBNXH\u0018<\u0011n;\u001cXs\u0011=R}TvZ[PxT<\u0011n;\u001c8\u001c8\u001c8\u001cXs\u0011=Rx\u001frTaxaTx\u007ft\\p\u0019[TbytXgBNXH\u00185\f(\u00117\u0013<\u0011n;\u001c8\u001c8\u001c8\u001c8v^{E|_`T.;\u001c8\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8\u001cL\u001c8\u001c8\u001c8\u001cpgCtHVYz^fT;A`B}\u0019[TbytXgBNXH\u0018.;\u001c8\u001c8\u001c8h;\u001c8\u001c8\u001cL\u001f8\u001c8\u001c8fT{UFEl]p\u0019TCgPlr}^zBp\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001cL\u001f8\u001c8|W5\u0019fTa\u00185J\u001f8\u001c8\u001cRx\u001fqXfAzBp\u0019<\n\u001f8\u001c8\u001cCpE`C{\n\u001f8\u001c8h;\u001c8h\u0011p]fT5Xs\u0011=BaPaDf\u0011(\f5\u0002<\u0011n;\u001c8\u001cBbXaR}\u0011=Bp]<\u0011n;\u001c8\u001c8vPfT5\u0003/;\u001c8\u001c8vPfT5\u0002/;\u001c8\u001c8vPfT5\u0007/;\u001c8\u001c8\u001cRx\u001ffTaytXg\u0019TCgPlr}^zBpjfTyTvE|^{l<\n\u001f8\u001c8\u001c8wCpP~\n\u001f8\u001c8\u001cRtBp\u0011!\u000b\u001f8\u001c8\u001cRtBp\u0011 \u000b\u001f8\u001c8\u001c8v\\;BpESPvT=pgCtHVYz^fTNBp]pRaXz_H\u0018.;\u001c8\u001c8\u001cSgTtZ.;\u001c8\u001cL\u001f8\u001c8v\\;U|Be^fT=\u0018.;\u001c8\u001cCpE`C{\n\u001f8\u001cL\u001f8h;\u001fW`_vE|^{\u0011fT{UFEl]p\u0019tCgPl\u00185J\u001f8v\\;Bp_qbaHyT=\u0013\u906d\u64f6\u4f75\u6731\u5589\u6b50\u7691\u00139\u0011tCgPl\u0018.;h"));
        return stringBuilder8.toString();
    }

    public static /* synthetic */ boolean isNumeric(String a2) {
        int n2 = a2.length();
        while (--n2 >= 0) {
            if (Character.isDigit(a2.charAt(n2))) continue;
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean faceExists(int a2) {
        Iterator<MapleDataFileEntry> iterator = MapleDataProviderFactory.getDataProvider(SkillEntry.ALLATORIxDEMO("VYtCtRaTg\u001fbK:wtRp")).getRoot().getFiles().iterator();
        while (iterator.hasNext()) {
            if (Integer.parseInt(iterator.next().getName().substring(0, 8)) != a2) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ {
        number = 0;
    }

    public static /* synthetic */ void addLine(StringBuilder a2, String a3) {
        a2.append(a3).append(InternCommand.ALLATORIxDEMO("<\u000f"));
    }

    public static /* synthetic */ boolean isNewHair(int a2) {
        if (a2 % 10 != 0) {
            return false;
        }
        return a2 >= 40000 && a2 < 50000;
    }

    public static /* synthetic */ boolean isMaleFace(int a2) {
        if (a2 % 1000 >= 100) {
            return false;
        }
        if (a2 / 1000 == 20) {
            return true;
        }
        if (a2 > 21000 && a2 < 29999) {
            return true;
        }
        return a2 / 1000 == 50;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isMaleHair(int a2) {
        if (a2 % 10 != 0) {
            return false;
        }
        if (a2 == 33030 || a2 == 33160 || a2 == 33590) {
            return false;
        }
        if (a2 / 1000 == 30 || a2 / 1000 == 33 || a2 / 1000 == 32 && a2 >= 32370 || a2 / 1000 == 36 || a2 / 1000 == 37 && a2 >= 37160 && a2 <= 37170) {
            return true;
        }
        switch (a2) {
            case 32160: 
            case 32330: 
            case 34740: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isFemaleFace(int a2) {
        if (a2 % 1000 >= 100) {
            return false;
        }
        if (a2 / 1000 == 21) {
            return true;
        }
        if (a2 > 21000 && a2 < 29999) {
            return true;
        }
        return a2 / 1000 == 51;
    }
}

