/*
 * Decompiled with CFR 0.150.
 */
package provider;

import handling.world.MapleMessenger;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.regex.Pattern;
import provider.MapleCanvas;
import provider.MapleData;
import provider.MapleDataEntity;
import provider.WzXML.MapleDataType;
import server.maps.MapleNodes;
import tools.FilePrinter;

public class MapleDataTool {
    public static /* synthetic */ String getString(MapleData a2) {
        if (a2.getType() == MapleDataType.STRING) {
            return (String)a2.getData();
        }
        return String.valueOf(MapleDataTool.getInt(a2));
    }

    public static /* synthetic */ String getString(String a2, MapleData a3, String a4) {
        return MapleDataTool.getString(a3.getChildByPath(a2), a4);
    }

    public static /* synthetic */ Point getPoint(MapleData a2) {
        return (Point)a2.getData();
    }

    public static /* synthetic */ BufferedImage getImage(MapleData a2) {
        return ((MapleCanvas)a2.getData()).getImage();
    }

    public static /* synthetic */ double getDouble(MapleData a2) {
        return (Double)a2.getData();
    }

    public static /* synthetic */ int getIntConvert(MapleData a2, int a3) {
        try {
            return MapleDataTool.getIntConvert(a2);
        }
        catch (Exception exception) {
            return a3;
        }
    }

    public static /* synthetic */ Point getPoint(String a2, MapleData a3) {
        return MapleDataTool.getPoint(a3.getChildByPath(a2));
    }

    public static /* synthetic */ String getFullDataPath(MapleData a2) {
        MapleDataEntity mapleDataEntity;
        Object object = "";
        MapleDataEntity mapleDataEntity2 = mapleDataEntity = a2;
        while (mapleDataEntity2 != null) {
            object = mapleDataEntity.getName() + "/" + (String)object;
            mapleDataEntity2 = mapleDataEntity.getParent();
        }
        return ((String)object).substring(0, ((String)object).length() - 1);
    }

    public static /* synthetic */ int getInt(String a2, MapleData a3) {
        return MapleDataTool.getInt(a3.getChildByPath(a2));
    }

    public static /* synthetic */ long getLongConvert(MapleData a2) {
        if (a2.getType() == MapleDataType.STRING) {
            return Long.parseLong(MapleDataTool.getString(a2));
        }
        return MapleDataTool.getLong(a2);
    }

    public static /* synthetic */ int getIntConvert(String a2, MapleData a3, int a4) {
        if (a3 == null) {
            return a4;
        }
        if ((a3 = a3.getChildByPath(a2)) == null) {
            return a4;
        }
        if (a3.getType() == MapleDataType.STRING) {
            try {
                return Integer.parseInt(MapleDataTool.getString(a3));
            }
            catch (NumberFormatException numberFormatException) {
                return a4;
            }
        }
        return MapleDataTool.getInt(a3, a4);
    }

    public static /* synthetic */ long getLongConvert(String a2, MapleData a32, long a4) {
        a32 = a32.getChildByPath(a2);
        try {
            return Long.parseLong(MapleDataTool.getString(a32));
        }
        catch (Exception a32) {
            return a4;
        }
    }

    public static /* synthetic */ String getString(String a2, MapleData a3) {
        return MapleDataTool.getString(a3.getChildByPath(a2));
    }

    public static /* synthetic */ float getFloat(MapleData a2) {
        return ((Float)a2.getData()).floatValue();
    }

    public static /* synthetic */ long getLong(MapleData a2) {
        try {
            long l2 = (Long)a2.getData();
            return l2;
        }
        catch (Exception exception) {
            long l3 = ((Integer)a2.getData()).intValue();
            return l3;
        }
    }

    public static /* synthetic */ int getInt(String a2, MapleData a3, int a4) {
        return MapleDataTool.getInt(a3.getChildByPath(a2), a4);
    }

    public static /* synthetic */ int getIntConvert(MapleData a2) {
        if (a2.getType() == MapleDataType.STRING) {
            return Integer.parseInt(MapleDataTool.getString(a2));
        }
        return MapleDataTool.getInt(a2);
    }

    public static /* synthetic */ int getInt(MapleData a2) {
        Object object = a2.getData();
        try {
            return Integer.parseInt(object.toString());
        }
        catch (Exception exception) {
            FilePrinter.printError(MapleNodes.ALLATORIxDEMO("ao\\bIJMzMZCa@ XvX"), exception, MapleMessenger.ALLATORIxDEMO("\u001c}\u000fQ\u0015l"));
            exception.printStackTrace();
            return 0;
        }
    }

    public static /* synthetic */ long getLongConvert(String a2, MapleData a3) {
        if ((a3 = a3.getChildByPath(a2)).getType() == MapleDataType.STRING) {
            return Long.parseLong(MapleDataTool.getString(a3));
        }
        return MapleDataTool.getLong(a3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getInt(MapleData a2, int a32) {
        if (a2 == null || a2.getData() == null) {
            return a32;
        }
        if (null == a2.getType()) {
            return (Integer)a2.getData();
        }
        switch (1.ALLATORIxDEMO[a2.getType().ordinal()]) {
            case 1: {
                String a32 = MapleDataTool.getString(a2);
                if (!a32.isEmpty() && MapleDataTool.isNumeric(a32)) {
                    return Integer.parseInt(a32);
                }
                return 0;
            }
            case 2: {
                return ((Short)a2.getData()).shortValue();
            }
            case 3: {
                return 0;
            }
            case 4: {
                return Math.round(((Float)a2.getData()).floatValue());
            }
        }
        return (Integer)a2.getData();
    }

    public static /* synthetic */ boolean isNumeric(String a2) {
        return Pattern.compile(MapleNodes.ALLATORIxDEMO("U\u001c#\u0015S\u0006")).matcher(a2).matches();
    }

    public static /* synthetic */ float getFloat(MapleData a2, float a3) {
        if (a2 == null || a2.getData() == null) {
            return a3;
        }
        return ((Float)a2.getData()).floatValue();
    }

    public /* synthetic */ MapleDataTool() {
        MapleDataTool a2;
    }

    public static /* synthetic */ Point getPoint(String a2, MapleData a3, Point a4) {
        if ((a3 = a3.getChildByPath(a2)) == null) {
            return a4;
        }
        return MapleDataTool.getPoint(a3);
    }

    public static /* synthetic */ String getString(MapleData a2, String a3) {
        if (a2 == null || a2.getData() == null) {
            return a3;
        }
        return String.valueOf(a2.getData());
    }

    public static /* synthetic */ int getIntConvert(String a2, MapleData a3) {
        return MapleDataTool.getIntConvert(a3.getChildByPath(a2));
    }

    public static /* synthetic */ long getLongConvert(MapleData a2, long a3) {
        try {
            return MapleDataTool.getLongConvert(a2);
        }
        catch (Exception exception) {
            return a3;
        }
    }
}

