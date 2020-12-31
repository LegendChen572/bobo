/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import FuckingHackerToby.K;
import client.ClientRedirector;
import client.MapleCharacter;
import client.MapleClient;
import constants.GameSetConstants;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import server.maps.AnimatedMapleMapObject;
import server.movement.LifeMovement;
import server.movement.LifeMovementFragment;
import server.movement.StaticLifeMovement;
import tools.FileoutputUtil;
import tools.data.LittleEndianAccessor;

public class MovementParse {
    /*
     * Enabled aggressive block sorting
     */
    public static final /* synthetic */ List<LifeMovementFragment> parseMovement(LittleEndianAccessor a2, MapleClient a3, int a4) {
        List<LifeMovementFragment> list = null;
        switch (GameSetConstants.MAPLE_VERSION) {
            case 75: {
                return MovementParse.parseMovement075(a2, a4);
            }
            case 116: 
            case 118: {
                return MovementParse.parseMovement118(a2, a3, a4);
            }
            case 134: 
            case 135: 
            case 136: {
                return MovementParse.parseMovement135(a2, a4);
            }
            case 142: 
            case 143: 
            case 145: 
            case 146: 
            case 147: 
            case 148: 
            case 149: {
                return MovementParse.parseMovement145(a2, a4);
            }
            case 151: {
                return MovementParse.parseMovement151(a2, a4);
            }
            case 152: 
            case 153: 
            case 154: {
                return MovementParse.parseMovement152(a2, a4);
            }
        }
        return MovementParse.parseMovement113(a2, a4);
    }

    public static final /* synthetic */ List<LifeMovementFragment> parseMovement118(LittleEndianAccessor a2, MapleClient a3, int a4) {
        int n2;
        a3 = ((MapleClient)((Object)a3)).getPlayer();
        a3 = new ArrayList<LifeMovementFragment>();
        byte by = a2.readByte();
        a4 = by;
        if (by == 0) {
            return null;
        }
        int n3 = n2 = 0;
        while (n3 < a4) {
            int n4;
            byte by2 = a2.readByte();
            switch (by2) {
                case 0: 
                case 5: 
                case 15: 
                case 17: 
                case 30: 
                case 31: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by2 == 15) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    short s8 = littleEndianAccessor2.readShort();
                    short s9 = littleEndianAccessor2.readShort();
                    byte by3 = littleEndianAccessor2.readByte();
                    short s10 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, new Point(s2, s3), s10, by3, s6);
                    n4 = n2;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement.setUnk(s6);
                    staticLifeMovement3.setOffset(new Point(s8, s9));
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    a3.add(staticLifeMovement2);
                    break;
                }
                case 1: 
                case 2: 
                case 6: 
                case 12: 
                case 13: 
                case 16: 
                case 18: 
                case 19: 
                case 20: 
                case 22: 
                case 24: 
                case 26: 
                case 27: 
                case 28: 
                case 29: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    byte by4 = littleEndianAccessor.readByte();
                    short s11 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, null, s11, by4, 0);
                    n4 = n2;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    staticLifeMovement4.setPixelsPerSecond(new Point(s2, s3));
                    a3.add(staticLifeMovement4);
                    break;
                }
                case 3: 
                case 4: 
                case 7: 
                case 8: 
                case 9: 
                case 11: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s12 = littleEndianAccessor.readShort();
                    byte by5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, new Point(s2, s3), 0, by5, 0);
                    n4 = n2;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setUnk(s12);
                    a3.add(staticLifeMovement5);
                    break;
                }
                case 10: {
                    short s2 = 0;
                    short s3 = 0;
                    byte by6 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, null, 0, 0, 0);
                    n4 = n2;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setWui(by6);
                    a3.add(staticLifeMovement6);
                    break;
                }
                case 14: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s13 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, null, s6, by7, 0);
                    n4 = n2;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setPixelsPerSecond(new Point(s2, s3));
                    staticLifeMovement7.setFh(s13);
                    a3.add(staticLifeMovement7);
                    break;
                }
                case 23: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s14 = littleEndianAccessor.readShort();
                    short s15 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readByte();
                    short s16 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, new Point(s2, s3), s16, s6, 0);
                    n4 = n2;
                    StaticLifeMovement staticLifeMovement8 = staticLifeMovement;
                    staticLifeMovement8.setPixelsPerSecond(new Point(s14, s15));
                    a3.add(staticLifeMovement8);
                    break;
                }
                default: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s3 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by2, null, s3, s2, 0);
                    n4 = n2;
                    a3.add(staticLifeMovement);
                }
            }
            n3 = n2 = (int)((byte)(n4 + 1));
        }
        if (a4 != a3.size()) {
            System.err.println(K.ALLATORIxDEMO("phgug:|t5wzlpwpta"));
            return null;
        }
        return a3;
    }

    public static /* synthetic */ List<LifeMovementFragment> parseMovement151(LittleEndianAccessor a2, int a32) {
        byte by;
        ArrayList<LifeMovementFragment> a32 = new ArrayList<LifeMovementFragment>();
        byte by2 = a2.readByte();
        if (by2 == 0) {
            return null;
        }
        byte by3 = by = 0;
        while (by3 < by2) {
            byte by4;
            byte by5 = a2.readByte();
            switch (by5) {
                case 0: 
                case 7: 
                case 14: 
                case 16: 
                case 47: 
                case 48: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by5 == 14) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    short s8 = littleEndianAccessor2.readShort();
                    short s9 = littleEndianAccessor2.readShort();
                    byte by6 = littleEndianAccessor2.readByte();
                    short s10 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), s10, by6, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement3.setUnk(s6);
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    staticLifeMovement2.setOffset(new Point(s8, s9));
                    a32.add(staticLifeMovement2);
                    break;
                }
                case 1: 
                case 2: 
                case 15: 
                case 18: 
                case 19: 
                case 21: 
                case 42: 
                case 43: 
                case 44: 
                case 45: {
                    short s2 = 0;
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s11 = littleEndianAccessor.readShort();
                    short s12 = littleEndianAccessor.readShort();
                    if (by5 == 18 || by5 == 19) {
                        s2 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor3 = a2;
                    short s5 = littleEndianAccessor3.readByte();
                    short s6 = littleEndianAccessor3.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, s5, 0);
                    staticLifeMovement.setPixelsPerSecond(new Point(s11, s12));
                    if (s2 > 0) {
                        staticLifeMovement.setUnk(s2);
                    }
                    a32.add(staticLifeMovement);
                    by4 = by;
                    break;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: 
                case 23: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s13 = littleEndianAccessor.readShort();
                    short s14 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s13), s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    staticLifeMovement4.setFh(s14);
                    a32.add(staticLifeMovement4);
                    break;
                }
                case 11: {
                    short s2 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, 0, 0, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setWui(s2);
                    a32.add(staticLifeMovement5);
                    break;
                }
                case 13: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s15 = littleEndianAccessor.readShort();
                    short s16 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setPixelsPerSecond(new Point(s2, s15));
                    staticLifeMovement6.setUnk(s16);
                    a32.add(staticLifeMovement6);
                    break;
                }
                case 20: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s17 = littleEndianAccessor.readShort();
                    short s18 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readByte();
                    short s19 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s17), s19, s6, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setUnk(s18);
                    staticLifeMovement7.setFh(s5);
                    a32.add(staticLifeMovement7);
                    break;
                }
                case 46: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s20 = littleEndianAccessor.readShort();
                    short s21 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s8 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s20), s8, by7, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement8 = staticLifeMovement;
                    staticLifeMovement8.setUnk(s6);
                    staticLifeMovement8.setOffset(new Point(s21, s5));
                    a32.add(staticLifeMovement8);
                    break;
                }
                default: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s22 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s22, s2, 0);
                    by4 = by;
                    a32.add(staticLifeMovement);
                    break;
                }
            }
            by3 = (byte)(by4 + 1);
        }
        if (by2 != a32.size()) {
            byte by8 = by2;
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("Y+R7\u001a\u79bf\u52e0\u5c45\u5330\u51be\u931ajA<A"), "\u5faa\u74b0\u6b21\u6578[" + by8 + "]\u548c\u5be6\u969b\u4e0a\u7372\u53d6\u7684\u5faa\u74b0\u6b21\u6578[" + a32.size() + "]\u4e0d\u7b26 \u79fb\u52d5\u5c01\u5305 \u5269\u9918\u6b21\u6578: " + (by8 - a32.size()) + "  \u5c01\u5305: " + a2.toString(true));
            return null;
        }
        return a32;
    }

    public /* synthetic */ MovementParse() {
        MovementParse a2;
    }

    public static final /* synthetic */ List<LifeMovementFragment> parseMovement113(LittleEndianAccessor a2, int a32) {
        byte by;
        ArrayList<LifeMovementFragment> a32 = new ArrayList<LifeMovementFragment>();
        byte by2 = a2.readByte();
        if (by2 == 0) {
            return null;
        }
        byte by3 = by = 0;
        while (by3 < by2) {
            byte by4;
            byte by5 = a2.readByte();
            switch (by5) {
                case 0: 
                case 5: 
                case 15: 
                case 17: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by5 == 15) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    byte by6 = littleEndianAccessor2.readByte();
                    short s8 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), s8, by6, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement3.setUnk(s6);
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    a32.add(staticLifeMovement2);
                    break;
                }
                case 1: 
                case 2: 
                case 6: 
                case 12: 
                case 13: 
                case 16: 
                case 18: 
                case 19: 
                case 20: 
                case 22: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s9 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s9, by7, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    staticLifeMovement4.setPixelsPerSecond(new Point(s2, s3));
                    a32.add(staticLifeMovement4);
                    break;
                }
                case 3: 
                case 4: 
                case 7: 
                case 8: 
                case 9: 
                case 11: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s10 = littleEndianAccessor.readShort();
                    byte by8 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), 0, by8, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setUnk(s10);
                    a32.add(staticLifeMovement5);
                    break;
                }
                case 10: {
                    short s2 = 0;
                    short s3 = 0;
                    byte by9 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, 0, 0, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setWui(by9);
                    a32.add(staticLifeMovement6);
                    break;
                }
                case 14: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s11 = littleEndianAccessor.readShort();
                    byte by10 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, by10, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setPixelsPerSecond(new Point(s2, s3));
                    staticLifeMovement7.setFh(s11);
                    a32.add(staticLifeMovement7);
                    break;
                }
                default: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s3 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s3, s2, 0);
                    by4 = by;
                    a32.add(staticLifeMovement);
                }
            }
            by3 = (byte)(by4 + 1);
        }
        if (by2 != a32.size()) {
            System.err.println(ClientRedirector.ALLATORIxDEMO("P6G+Gd\\*\u0015)Z2P)P*A"));
            return null;
        }
        return a32;
    }

    public static /* synthetic */ List<LifeMovementFragment> parseMovement152(LittleEndianAccessor a2, int a32) {
        byte by;
        ArrayList<LifeMovementFragment> a32 = new ArrayList<LifeMovementFragment>();
        byte by2 = a2.readByte();
        if (by2 == 0) {
            return null;
        }
        byte by3 = by = 0;
        while (by3 < by2) {
            byte by4;
            byte by5 = a2.readByte();
            switch (by5) {
                case 0: 
                case 8: 
                case 15: 
                case 17: 
                case 48: 
                case 49: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by5 == 15) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    short s8 = littleEndianAccessor2.readShort();
                    short s9 = littleEndianAccessor2.readShort();
                    byte by6 = littleEndianAccessor2.readByte();
                    short s10 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), s10, by6, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement3.setUnk(s6);
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    staticLifeMovement2.setOffset(new Point(s8, s9));
                    a32.add(staticLifeMovement2);
                    break;
                }
                case 1: 
                case 2: 
                case 16: 
                case 19: 
                case 20: 
                case 22: 
                case 43: 
                case 44: 
                case 45: 
                case 46: {
                    short s2 = 0;
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s11 = littleEndianAccessor.readShort();
                    short s12 = littleEndianAccessor.readShort();
                    if (by5 == 19 || by5 == 20) {
                        s2 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor3 = a2;
                    short s5 = littleEndianAccessor3.readByte();
                    short s6 = littleEndianAccessor3.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, s5, 0);
                    staticLifeMovement.setPixelsPerSecond(new Point(s11, s12));
                    if (s2 > 0) {
                        staticLifeMovement.setUnk(s2);
                    }
                    a32.add(staticLifeMovement);
                    by4 = by;
                    break;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 9: 
                case 10: 
                case 11: 
                case 13: 
                case 24: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s13 = littleEndianAccessor.readShort();
                    short s14 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s13), s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    staticLifeMovement4.setFh(s14);
                    a32.add(staticLifeMovement4);
                    break;
                }
                case 12: {
                    short s2 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, 0, 0, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setWui(s2);
                    a32.add(staticLifeMovement5);
                    break;
                }
                case 14: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s15 = littleEndianAccessor.readShort();
                    short s16 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setPixelsPerSecond(new Point(s2, s15));
                    staticLifeMovement6.setUnk(s16);
                    a32.add(staticLifeMovement6);
                    break;
                }
                case 21: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s17 = littleEndianAccessor.readShort();
                    short s18 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readByte();
                    short s19 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s17), s19, s6, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setUnk(s18);
                    staticLifeMovement7.setFh(s5);
                    a32.add(staticLifeMovement7);
                    break;
                }
                case 47: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s20 = littleEndianAccessor.readShort();
                    short s21 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s8 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s20), s8, by7, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement8 = staticLifeMovement;
                    staticLifeMovement8.setUnk(s6);
                    staticLifeMovement8.setOffset(new Point(s21, s5));
                    a32.add(staticLifeMovement8);
                    break;
                }
                default: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s22 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s22, s2, 0);
                    by4 = by;
                    a32.add(staticLifeMovement);
                    break;
                }
            }
            by3 = (byte)(by4 + 1);
        }
        if (by2 != a32.size()) {
            byte by8 = by2;
            FileoutputUtil.logToFile(K.ALLATORIxDEMO("yuri:\u79e1\u52c0\u5c1b\u5310\u51e0\u933a4aba"), "\u5faa\u74b0\u6b21\u6578[" + by8 + "]\u548c\u5be6\u969b\u4e0a\u7372\u53d6\u7684\u5faa\u74b0\u6b21\u6578[" + a32.size() + "]\u4e0d\u7b26 \u79fb\u52d5\u5c01\u5305 \u5269\u9918\u6b21\u6578: " + (by8 - a32.size()) + "  \u5c01\u5305: " + a2.toString(true));
            return null;
        }
        return a32;
    }

    public static final /* synthetic */ List<LifeMovementFragment> parseMovementHere(MapleCharacter a2) {
        ArrayList<LifeMovementFragment> arrayList = new ArrayList<LifeMovementFragment>();
        StaticLifeMovement staticLifeMovement = new StaticLifeMovement(0, a2.getTruePosition(), 0, a2.getStance(), 116);
        ArrayList<LifeMovementFragment> arrayList2 = arrayList;
        StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
        staticLifeMovement2.setUnk((short)116);
        staticLifeMovement2.setFh((short)a2.getFH());
        StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
        staticLifeMovement2.setPixelsPerSecond(new Point(0, 0));
        arrayList2.add(staticLifeMovement);
        return arrayList2;
    }

    public static /* synthetic */ List<LifeMovementFragment> parseMovement145(LittleEndianAccessor a2, int a3) {
        byte by;
        ArrayList<LifeMovementFragment> arrayList = new ArrayList<LifeMovementFragment>();
        byte by2 = a2.readByte();
        if (by2 == 0) {
            return null;
        }
        byte by3 = by = 0;
        while (by3 < by2) {
            byte by4;
            byte by5 = a2.readByte();
            switch (by5) {
                case 0: 
                case 7: 
                case 14: 
                case 16: 
                case 45: 
                case 46: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by5 == 14) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    short s8 = littleEndianAccessor2.readShort();
                    short s9 = littleEndianAccessor2.readShort();
                    byte by6 = littleEndianAccessor2.readByte();
                    short s10 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), s10, by6, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement3.setUnk(s6);
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    staticLifeMovement2.setOffset(new Point(s8, s9));
                    arrayList.add(staticLifeMovement2);
                    break;
                }
                case 44: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s11 = littleEndianAccessor.readShort();
                    short s12 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s13 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s11), s13, by7, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setUnk(s6);
                    staticLifeMovement4.setFh((short)0);
                    staticLifeMovement5.setPixelsPerSecond(new Point(s12, s5));
                    staticLifeMovement4.setOffset(new Point(0, 0));
                    arrayList.add(staticLifeMovement4);
                    break;
                }
                case 1: 
                case 2: 
                case 15: 
                case 18: 
                case 19: 
                case 21: 
                case 40: 
                case 41: 
                case 42: 
                case 43: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s14 = littleEndianAccessor.readShort();
                    short s15 = 0;
                    if (by5 == 18 || by5 == 19) {
                        s15 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor3 = a2;
                    short s5 = littleEndianAccessor3.readByte();
                    short s6 = littleEndianAccessor3.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setPixelsPerSecond(new Point(s2, s14));
                    staticLifeMovement6.setUnk(s15);
                    arrayList.add(staticLifeMovement6);
                    break;
                }
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s16 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s16, s2, 0);
                    by4 = by;
                    arrayList.add(staticLifeMovement);
                    break;
                }
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s17 = littleEndianAccessor.readShort();
                    short s18 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s17), s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setFh(s18);
                    arrayList.add(staticLifeMovement7);
                    break;
                }
                case 13: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s19 = littleEndianAccessor.readShort();
                    short s20 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement8 = staticLifeMovement;
                    staticLifeMovement8.setFh(s20);
                    staticLifeMovement8.setPixelsPerSecond(new Point(s2, s19));
                    arrayList.add(staticLifeMovement8);
                    break;
                }
                case 20: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s21 = littleEndianAccessor.readShort();
                    short s22 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readByte();
                    short s23 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s21), s23, s6, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement9 = staticLifeMovement;
                    staticLifeMovement9.setOffset(new Point(s22, s5));
                    arrayList.add(staticLifeMovement9);
                    break;
                }
                case 11: {
                    short s2 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, 0, 0, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement10 = staticLifeMovement;
                    staticLifeMovement10.setWui(s2);
                    arrayList.add(staticLifeMovement10);
                    break;
                }
                default: {
                    System.out.println("Kind movement: " + a3 + ", Remaining : " + (by2 - arrayList.size()) + " New type of movement ID : " + by5 + ", packet : " + a2.toString(true));
                    FileoutputUtil.log("logs/Except/\u79fb\u52d5\u932f\u8aa4.txt", "Kind movement: " + a3 + ", Remaining : " + (by2 - arrayList.size()) + " New type of movement ID : " + by5 + ", packet : " + a2.toString(true));
                    return null;
                }
            }
            by3 = (byte)(by4 + 1);
        }
        if (by2 != arrayList.size()) {
            byte by8 = by2;
            FileoutputUtil.logToFile(K.ALLATORIxDEMO("yuri:\u79e1\u52c0\u5c1b\u5310\u51e0\u933a4aba"), "\u5faa\u74b0\u6b21\u6578[" + by8 + "]\u548c\u5be6\u969b\u4e0a\u7372\u53d6\u7684\u5faa\u74b0\u6b21\u6578[" + arrayList.size() + "]\u4e0d\u7b26 \u79fb\u52d5\u5c01\u5305 \u5269\u9918\u6b21\u6578: " + (by8 - arrayList.size()) + "  \u5c01\u5305: " + a2.toString(true));
            return null;
        }
        return arrayList;
    }

    public static final /* synthetic */ void updatePosition(List<LifeMovementFragment> a2, AnimatedMapleMapObject a3, int a4) {
        for (LifeMovementFragment lifeMovementFragment : a2) {
            Point point;
            if (!(lifeMovementFragment instanceof LifeMovement)) continue;
            if (lifeMovementFragment instanceof StaticLifeMovement && (point = ((StaticLifeMovement)lifeMovementFragment).getPosition()) != null) {
                Point point2 = point;
                point2.y += a4;
                a3.setPosition(point2);
            }
            a3.setFh(((LifeMovement)lifeMovementFragment).getNewFh());
            a3.setStance(((StaticLifeMovement)lifeMovementFragment).getNewstate());
        }
    }

    public static final /* synthetic */ List<LifeMovementFragment> parseMovement075(LittleEndianAccessor a2, int a32) {
        byte by;
        ArrayList<LifeMovementFragment> a32 = new ArrayList<LifeMovementFragment>();
        byte by2 = a2.readByte();
        if (by2 == 0) {
            return null;
        }
        byte by3 = by = 0;
        while (by3 < by2) {
            byte by4;
            byte by5 = a2.readByte();
            switch (by5) {
                case 0: 
                case 5: 
                case 15: 
                case 17: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by5 == 15) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    byte by6 = littleEndianAccessor2.readByte();
                    short s8 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), s8, by6, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement3.setUnk(s6);
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    a32.add(staticLifeMovement2);
                    break;
                }
                case 1: 
                case 2: 
                case 6: 
                case 12: 
                case 13: 
                case 16: 
                case 18: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s9 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s9, by7, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    staticLifeMovement4.setPixelsPerSecond(new Point(s2, s3));
                    a32.add(staticLifeMovement4);
                    break;
                }
                case 3: 
                case 4: 
                case 7: 
                case 8: 
                case 9: 
                case 11: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s10 = littleEndianAccessor.readShort();
                    byte by8 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), 0, by8, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setUnk(s10);
                    a32.add(staticLifeMovement5);
                    break;
                }
                case 10: {
                    short s2 = 0;
                    short s3 = 0;
                    byte by9 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, 0, 0, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setWui(by9);
                    a32.add(staticLifeMovement6);
                    break;
                }
                case 14: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s11 = littleEndianAccessor.readShort();
                    byte by10 = littleEndianAccessor.readByte();
                    short s6 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s6, by10, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setPixelsPerSecond(new Point(s2, s3));
                    staticLifeMovement7.setFh(s11);
                    a32.add(staticLifeMovement7);
                    break;
                }
                default: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s3 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s3, s2, 0);
                    by4 = by;
                    a32.add(staticLifeMovement);
                }
            }
            by3 = (byte)(by4 + 1);
        }
        if (by2 != a32.size()) {
            System.err.println(K.ALLATORIxDEMO("phgug:|t5wzlpwpta"));
            return null;
        }
        return a32;
    }

    public static /* synthetic */ List<LifeMovementFragment> parseMovement135(LittleEndianAccessor a2, int a3) {
        byte by;
        ArrayList<LifeMovementFragment> arrayList = new ArrayList<LifeMovementFragment>();
        byte by2 = a2.readByte();
        if (by2 == 0) {
            return null;
        }
        byte by3 = by = 0;
        while (by3 < by2) {
            byte by4;
            byte by5 = a2.readByte();
            switch (by5) {
                case 0: 
                case 6: 
                case 13: 
                case 15: 
                case 37: 
                case 38: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    while (false) {
                    }
                    short s2 = littleEndianAccessor.readShort();
                    short s3 = littleEndianAccessor.readShort();
                    short s4 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s6 = littleEndianAccessor.readShort();
                    short s7 = 0;
                    if (by5 == 13) {
                        s7 = a2.readShort();
                    }
                    LittleEndianAccessor littleEndianAccessor2 = a2;
                    short s8 = littleEndianAccessor2.readShort();
                    short s9 = littleEndianAccessor2.readShort();
                    byte by6 = littleEndianAccessor2.readByte();
                    short s10 = littleEndianAccessor2.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s3), s10, by6, s6);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement2 = staticLifeMovement;
                    StaticLifeMovement staticLifeMovement3 = staticLifeMovement;
                    staticLifeMovement3.setUnk(s6);
                    staticLifeMovement2.setFh(s7);
                    staticLifeMovement3.setPixelsPerSecond(new Point(s4, s5));
                    staticLifeMovement2.setOffset(new Point(s8, s9));
                    arrayList.add(staticLifeMovement2);
                    break;
                }
                case 36: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s11 = littleEndianAccessor.readShort();
                    short s12 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    short s13 = littleEndianAccessor.readShort();
                    byte by7 = littleEndianAccessor.readByte();
                    short s14 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s11), s14, by7, s13);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement4 = staticLifeMovement;
                    staticLifeMovement4.setOffset(new Point(s12, s5));
                    staticLifeMovement4.setUnk(s13);
                    arrayList.add(staticLifeMovement4);
                    break;
                }
                case 1: 
                case 2: 
                case 14: 
                case 17: 
                case 19: 
                case 32: 
                case 33: 
                case 34: 
                case 35: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s15 = littleEndianAccessor.readShort();
                    byte by8 = littleEndianAccessor.readByte();
                    short s5 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s5, by8, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement5 = staticLifeMovement;
                    staticLifeMovement5.setPixelsPerSecond(new Point(s2, s15));
                    arrayList.add(staticLifeMovement5);
                    break;
                }
                case 16: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readByte();
                    short s16 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s16, s2, 0);
                    by4 = by;
                    arrayList.add(staticLifeMovement);
                    break;
                }
                case 3: 
                case 4: 
                case 5: 
                case 7: 
                case 8: 
                case 9: 
                case 11: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s17 = littleEndianAccessor.readShort();
                    short s18 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s19 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s17), s19, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement6 = staticLifeMovement;
                    staticLifeMovement6.setFh(s18);
                    arrayList.add(staticLifeMovement6);
                    break;
                }
                case 12: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s20 = littleEndianAccessor.readShort();
                    short s21 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readByte();
                    short s22 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, s22, s5, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement7 = staticLifeMovement;
                    staticLifeMovement7.setPixelsPerSecond(new Point(s2, s20));
                    staticLifeMovement7.setUnk(s21);
                    arrayList.add(staticLifeMovement7);
                    break;
                }
                case 18: {
                    LittleEndianAccessor littleEndianAccessor = a2;
                    short s2 = littleEndianAccessor.readShort();
                    short s23 = littleEndianAccessor.readShort();
                    short s24 = littleEndianAccessor.readShort();
                    short s5 = littleEndianAccessor.readShort();
                    byte by9 = littleEndianAccessor.readByte();
                    short s25 = littleEndianAccessor.readShort();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, new Point(s2, s23), s25, by9, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement8 = staticLifeMovement;
                    staticLifeMovement8.setUnk(s24);
                    staticLifeMovement8.setFh(s5);
                    arrayList.add(staticLifeMovement8);
                    break;
                }
                case 10: {
                    short s2 = a2.readByte();
                    StaticLifeMovement staticLifeMovement = new StaticLifeMovement(by5, null, 0, 0, 0);
                    by4 = by;
                    StaticLifeMovement staticLifeMovement9 = staticLifeMovement;
                    staticLifeMovement9.setWui(s2);
                    arrayList.add(staticLifeMovement9);
                    break;
                }
                default: {
                    System.out.println("Kind movement: " + a3 + ", Remaining : " + (by2 - arrayList.size()) + " New type of movement ID : " + by5 + ", packet : " + a2.toString(true));
                    FileoutputUtil.log("logs/Except/\u79fb\u52d5\u932f\u8aa4.txt", "Kind movement: " + a3 + ", Remaining : " + (by2 - arrayList.size()) + " New type of movement ID : " + by5 + ", packet : " + a2.toString(true));
                    return null;
                }
            }
            by3 = (byte)(by4 + 1);
        }
        if (by2 != arrayList.size()) {
            byte by10 = by2;
            FileoutputUtil.logToFile(ClientRedirector.ALLATORIxDEMO("Y+R7\u001a\u79bf\u52e0\u5c45\u5330\u51be\u931ajA<A"), "\u5faa\u74b0\u6b21\u6578[" + by10 + "]\u548c\u5be6\u969b\u4e0a\u7372\u53d6\u7684\u5faa\u74b0\u6b21\u6578[" + arrayList.size() + "]\u4e0d\u7b26 \u79fb\u52d5\u5c01\u5305 \u5269\u9918\u6b21\u6578: " + (by10 - arrayList.size()) + "  \u5c01\u5305: " + a2.toString(true));
            return null;
        }
        return arrayList;
    }
}

