/*
 * Decompiled with CFR 0.150.
 */
package tools.wztosql;

import constants.SpecialSkillConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import server.characterCards.MapleCharacterCards;

public class WzStringDumper {
    public static /* synthetic */ void main(String[] a2) throws FileNotFoundException, IOException {
        Object object;
        Object object2;
        Object object3;
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u0006w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/^/t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,w\u0006w,t,t,t,t/w,w,t,w,t,t/w,w/w,w/w,w/t,w/w,t,t,t,t/^/t,t,t,t/t/t/t,t/t,t/t/t,w,t/t/t/t/t,w,t,t,t,t,w\u0006w,t,t,t,w/w,w,t,w,t,w/w,t/t,w,w,w/t,t/t,t,t,t,t/^/t,t,t,t/t/t/w/t/w/t/t/t,w,t/w/t/t/t/w/t,t,t,t,w\u0006w,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t/^/tC6j!\u007f7m e;btn-,\u0015`8m c&etC6j!\u007f7m c&,\";z?tH\u0011A\u001b,w\u0006w,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t/^/t,t,t,t,t,td x$6{##{#\"5`8m c&ezo;at,t,t,t,t,t,w\u0006w,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t,t/^/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w/w\u0006"));
        MapleDataProvider mapleDataProvider = MapleDataProviderFactory.getDataProvider(SpecialSkillConstants.ALLATORIxDEMO("D\u0006E\u001bY\u0015\u0019\u0005M"));
        Iterator<MapleData> iterator = mapleDataProvider.getData(MapleCharacterCards.ALLATORIxDEMO("\u0017m'dze9k"));
        Object object4 = mapleDataProvider.getData(SpecialSkillConstants.ALLATORIxDEMO("t\u001dY\u0001B\u001fR\\^\u001fP"));
        Object object5 = mapleDataProvider.getData(MapleCharacterCards.ALLATORIxDEMO("I%|ze9k")).getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("r\u0003G"));
        MapleData mapleData = mapleDataProvider.getData(MapleCharacterCards.ALLATORIxDEMO("I oze9k")).getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("r\u0006T"));
        MapleData mapleData2 = mapleDataProvider.getData(MapleCharacterCards.ALLATORIxDEMO("E:\u007fze9k"));
        MapleData mapleData3 = mapleDataProvider.getData(SpecialSkillConstants.ALLATORIxDEMO("g\u0017C\\^\u001fP"));
        MapleData mapleData4 = mapleDataProvider.getData(MapleCharacterCards.ALLATORIxDEMO("A5|ze9k"));
        MapleData mapleData5 = mapleDataProvider.getData(SpecialSkillConstants.ALLATORIxDEMO("z\u001dU\\^\u001fP"));
        MapleData mapleData6 = mapleDataProvider.getData(MapleCharacterCards.ALLATORIxDEMO("_?e8`ze9k"));
        MapleData mapleData7 = mapleDataProvider.getData(SpecialSkillConstants.ALLATORIxDEMO("y\u0002T\\^\u001fP"));
        String string = a2[0];
        Object object6 = new File(string);
        File object72 = new File(string + "\\Cash.txt");
        Object object7 = new File(string + "\\Use.txt");
        Object object8 = new File(string + "\\Equip");
        File file = new File(string + "\\Etc.txt");
        File file2 = new File(string + "\\Setup.txt");
        File file3 = new File(string + "\\Pet.txt");
        File file4 = new File(string + "\\Map.txt");
        File file5 = new File(string + "\\Mob.txt");
        File file6 = new File(string + "\\Skill.txt");
        File file7 = new File(string + "\\NPC.txt");
        ((File)object6).mkdir();
        object72.createNewFile();
        ((File)object7).createNewFile();
        ((File)object8).mkdir();
        file.createNewFile();
        file2.createNewFile();
        file3.createNewFile();
        file4.createNewFile();
        file5.createNewFile();
        file6.createNewFile();
        file7.createNewFile();
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u63dc\u5382,\u0017m'dze9kt\u6574\u648e\"z\""));
        object6 = new PrintWriter(new FileOutputStream(object72));
        iterator = iterator.getChildren().iterator();
        Iterator<MapleData> iterator2 = iterator;
        while (iterator2.hasNext()) {
            MapleData mapleData8 = (MapleData)iterator.next();
            object8 = mapleData8.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u001cV\u001fR"));
            object3 = mapleData8.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("0i'o"));
            object2 = "";
            object = SpecialSkillConstants.ALLATORIxDEMO("\u001f\u7153\u63f8\u8f82\u001e");
            if (object8 != null) {
                object2 = (String)object8.getData();
            }
            if (object3 != null) {
                object = (String)object3.getData();
            }
            ((PrintWriter)object6).println(mapleData8.getName() + " - " + (String)object2 + " - " + (String)object);
            iterator2 = iterator;
        }
        Object object9 = object6;
        ((PrintWriter)object9).flush();
        ((PrintWriter)object9).close();
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u0017m'dze9kt\u63dc\u5382\u5b80\u6244\""));
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("\u63a2\u53e1Rt\u001dY\u0001B\u001fR\\^\u001fPR\u654f\u64a8\u0019\\\u0019"));
        object6 = new PrintWriter(new FileOutputStream((File)object7));
        Iterator<MapleData> iterator3 = iterator = object4.getChildren().iterator();
        while (iterator3.hasNext()) {
            MapleData mapleData9 = iterator.next();
            object8 = mapleData9.getChildByPath(MapleCharacterCards.ALLATORIxDEMO(":m9i"));
            object3 = mapleData9.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u0016R\u0001T"));
            object2 = "";
            object = MapleCharacterCards.ALLATORIxDEMO("$\u7175\u63c3\u8fa4%");
            if (object8 != null) {
                object2 = (String)object8.getData();
            }
            if (object3 != null) {
                object = (String)object3.getData();
            }
            ((PrintWriter)object6).println(mapleData9.getName() + " - " + (String)object2 + " - " + (String)object);
            iterator3 = iterator;
        }
        Object object10 = object6;
        ((PrintWriter)object10).flush();
        ((PrintWriter)object10).close();
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("t\u001dY\u0001B\u001fR\\^\u001fPR\u63e7\u53a4\u5bbb\u6262\u0019"));
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u6384\u53datI%|ze9kt\u6574\u648e\"z\""));
        iterator = object5.getChildren().iterator();
        Iterator<MapleData> iterator4 = iterator;
        while (iterator4.hasNext()) {
            MapleData mapleData10 = iterator.next();
            System.out.println("\u63d0\u53d6 " + mapleData10.getName() + " \u6578\u64da...");
            object8 = new File(string + "\\Equip\\" + mapleData10.getName() + ".txt");
            ((File)object8).createNewFile();
            object3 = new PrintWriter(new FileOutputStream((File)object8));
            object2 = mapleData10.getChildren().iterator();
            Object object11 = object2;
            while (object11.hasNext()) {
                object = (MapleData)object2.next();
                object4 = object.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u001cV\u001fR"));
                object5 = object.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("0i'o"));
                object7 = "";
                String string2 = SpecialSkillConstants.ALLATORIxDEMO("\u001f\u7153\u63f8\u8f82\u001e");
                if (object4 != null) {
                    object7 = (String)object4.getData();
                }
                if (object5 != null) {
                    string2 = (String)object5.getData();
                }
                ((PrintWriter)object3).println(object.getName() + " - " + (String)object7 + " - " + string2);
                object11 = object2;
            }
            Object object12 = object3;
            ((PrintWriter)object12).flush();
            ((PrintWriter)object12).close();
            System.out.println(mapleData10.getName() + " \u63d0\u53d6\u5b8c\u6210.");
            iterator4 = iterator;
        }
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("I%|ze9kt\u63dc\u5382\u5b80\u6244\""));
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("\u63a2\u53e1Rr\u0006T\\^\u001fPR\u654f\u64a8\u0019\\\u0019"));
        object6 = new PrintWriter(new FileOutputStream(file));
        iterator = mapleData.getChildren().iterator();
        Iterator<MapleData> iterator5 = iterator;
        while (iterator5.hasNext()) {
            MapleData mapleData11 = iterator.next();
            object8 = mapleData11.getChildByPath(MapleCharacterCards.ALLATORIxDEMO(":m9i"));
            object3 = mapleData11.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u0016R\u0001T"));
            object2 = "";
            object = MapleCharacterCards.ALLATORIxDEMO("$\u7175\u63c3\u8fa4%");
            if (object8 != null) {
                object2 = (String)object8.getData();
            }
            if (object3 != null) {
                object = (String)object3.getData();
            }
            ((PrintWriter)object6).println(mapleData11.getName() + " - " + (String)object2 + " - " + (String)object);
            iterator5 = iterator;
        }
        Object object13 = object6;
        ((PrintWriter)object13).flush();
        ((PrintWriter)object13).close();
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("r\u0006T\\^\u001fPR\u63e7\u53a4\u5bbb\u6262\u0019"));
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u6384\u53datE:\u007fze9kt\u6574\u648e\"z\""));
        object6 = new PrintWriter(new FileOutputStream(file2));
        iterator = mapleData2.getChildren().iterator();
        Iterator<MapleData> iterator6 = iterator;
        while (iterator6.hasNext()) {
            MapleData mapleData12 = iterator.next();
            object8 = mapleData12.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u001cV\u001fR"));
            object3 = mapleData12.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("0i'o"));
            object2 = "";
            object = SpecialSkillConstants.ALLATORIxDEMO("\u001f\u7153\u63f8\u8f82\u001e");
            if (object8 != null) {
                object2 = (String)object8.getData();
            }
            if (object3 != null) {
                object = (String)object3.getData();
            }
            ((PrintWriter)object6).println(mapleData12.getName() + " - " + (String)object2 + " - " + (String)object);
            iterator6 = iterator;
        }
        Object object14 = object6;
        ((PrintWriter)object14).flush();
        ((PrintWriter)object14).close();
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("E:\u007fze9kt\u63dc\u5382\u5b80\u6244\""));
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("\u63a2\u53e1Rg\u0017C\\^\u001fPR\u654f\u64a8\u0019\\\u0019"));
        object6 = new PrintWriter(new FileOutputStream(file3));
        iterator = mapleData3.getChildren().iterator();
        Iterator<MapleData> iterator7 = iterator;
        while (iterator7.hasNext()) {
            MapleData mapleData13 = iterator.next();
            object8 = mapleData13.getChildByPath(MapleCharacterCards.ALLATORIxDEMO(":m9i"));
            object3 = mapleData13.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u0016R\u0001T"));
            object2 = "";
            object = MapleCharacterCards.ALLATORIxDEMO("$\u7175\u63c3\u8fa4%");
            if (object8 != null) {
                object2 = (String)object8.getData();
            }
            if (object3 != null) {
                object = (String)object3.getData();
            }
            ((PrintWriter)object6).println(mapleData13.getName() + " - " + (String)object2 + " - " + (String)object);
            iterator7 = iterator;
        }
        Object object15 = object6;
        ((PrintWriter)object15).flush();
        ((PrintWriter)object15).close();
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("g\u0017C\\^\u001fPR\u63e7\u53a4\u5bbb\u6262\u0019"));
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u6384\u53datA5|ze9kt\u6574\u648e\"z\""));
        object6 = new PrintWriter(new FileOutputStream(file4));
        iterator = mapleData4.getChildren().iterator();
        Iterator<MapleData> iterator8 = iterator;
        while (iterator8.hasNext()) {
            MapleData mapleData14 = iterator.next();
            Object object16 = object6;
            MapleData mapleData15 = mapleData14;
            ((PrintWriter)object16).println(mapleData15.getName());
            ((PrintWriter)object16).println();
            Object object17 = mapleData15.getChildren().iterator();
            while (object17.hasNext()) {
                object3 = object8.next();
                object2 = object3.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u0001C\u0000R\u0017C<V\u001fR"));
                object = object3.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("a5|\u001am9i"));
                object4 = SpecialSkillConstants.ALLATORIxDEMO("Z\u7116\u650a\u64ed\u547f\u001e");
                object5 = MapleCharacterCards.ALLATORIxDEMO("|\u712d\u5764\u571a\u5459%");
                if (object2 != null) {
                    object4 = (String)object2.getData();
                }
                if (object != null) {
                    object5 = (String)object.getData();
                }
                ((PrintWriter)object6).println(object3.getName() + " - " + (String)object4 + " - " + (String)object5);
                object17 = object8;
            }
            ((PrintWriter)object6).println();
            iterator8 = iterator;
        }
        Object object18 = object6;
        ((PrintWriter)object18).flush();
        ((PrintWriter)object18).close();
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("z\u0013G\\^\u001fPR\u63e7\u53a4\u5bbb\u6262\u0019"));
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u6384\u53datA;nze9kt\u6574\u648e\"z\""));
        object6 = new PrintWriter(new FileOutputStream(file5));
        iterator = mapleData5.getChildren().iterator();
        Iterator<MapleData> iterator9 = iterator;
        while (iterator9.hasNext()) {
            MapleData mapleData16 = iterator.next();
            object8 = mapleData16.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u001cV\u001fR"));
            object3 = "";
            if (object8 != null) {
                object3 = (String)object8.getData();
            }
            ((PrintWriter)object6).println(mapleData16.getName() + " - " + (String)object3);
            iterator9 = iterator;
        }
        Object object19 = object6;
        ((PrintWriter)object19).flush();
        ((PrintWriter)object19).close();
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("A;nze9kt\u63dc\u5382\u5b80\u6244\""));
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("\u63a2\u53e1Rd\u0019^\u001e[\\^\u001fPR\u654f\u64a8\u0019\\\u0019"));
        object6 = new PrintWriter(new FileOutputStream(file6));
        for (MapleData mapleData17 : mapleData6.getChildren()) {
            object8 = mapleData17.getChildByPath(MapleCharacterCards.ALLATORIxDEMO(":m9i"));
            object3 = mapleData17.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u0016R\u0001T"));
            object2 = mapleData17.getChildByPath(MapleCharacterCards.ALLATORIxDEMO("6c;g\u001am9i"));
            object = "";
            object4 = "";
            if (object8 != null) {
                object = (String)object8.getData();
            }
            if (object3 != null) {
                object4 = (String)object3.getData();
            }
            if (object2 != null) continue;
            ((PrintWriter)object6).println(mapleData17.getName() + " - " + (String)object + " - " + (String)object4);
        }
        Object object20 = object6;
        ((PrintWriter)object20).flush();
        ((PrintWriter)object20).close();
        System.out.println(SpecialSkillConstants.ALLATORIxDEMO("d\u0019^\u001e[\\^\u001fPR\u63e7\u53a4\u5bbb\u6262\u0019"));
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("\u6384\u53datB$oze9kt\u6574\u648e\"z\""));
        object6 = new PrintWriter(new FileOutputStream(file7));
        iterator = mapleData7.getChildren().iterator();
        Iterator<MapleData> iterator10 = iterator;
        while (iterator10.hasNext()) {
            MapleData mapleData18 = iterator.next();
            object8 = mapleData18.getChildByPath(SpecialSkillConstants.ALLATORIxDEMO("\u001cV\u001fR"));
            object3 = "";
            if (object8 != null) {
                object3 = (String)object8.getData();
            }
            ((PrintWriter)object6).println(mapleData18.getName() + " - " + (String)object3);
            iterator10 = iterator;
        }
        Object object21 = object6;
        ((PrintWriter)object21).flush();
        ((PrintWriter)object21).close();
        System.out.println(MapleCharacterCards.ALLATORIxDEMO("B$oze9kt\u63dc\u5382\u5b80\u6244\""));
    }

    public /* synthetic */ WzStringDumper() {
        WzStringDumper a2;
    }
}

