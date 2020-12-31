/*
 * Decompiled with CFR 0.150.
 */
package server.movement;

import constants.GameSetConstants;
import java.awt.Point;
import server.movement.AbstractLifeMovement;
import tools.data.MaplePacketLittleEndianWriter;

public class StaticLifeMovement
extends AbstractLifeMovement {
    private /* synthetic */ Point k;
    private /* synthetic */ short d;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ short a;
    private /* synthetic */ Point K;

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public /* synthetic */ void serialize(MaplePacketLittleEndianWriter a2) {
        StaticLifeMovement staticLifeMovement;
        StaticLifeMovement a3;
        block83: {
            block81: {
                StaticLifeMovement staticLifeMovement2;
                block82: {
                    block79: {
                        StaticLifeMovement staticLifeMovement3;
                        block80: {
                            block77: {
                                StaticLifeMovement staticLifeMovement4;
                                block78: {
                                    block75: {
                                        StaticLifeMovement staticLifeMovement5;
                                        block76: {
                                            block73: {
                                                StaticLifeMovement staticLifeMovement6;
                                                block74: {
                                                    if (GameSetConstants.MAPLE_VERSION != 116 && GameSetConstants.MAPLE_VERSION != 118 && GameSetConstants.MAPLE_VERSION != 119) break block73;
                                                    a2.write(a3.getType());
                                                    switch (a3.getType()) {
                                                        case 0: 
                                                        case 5: 
                                                        case 15: 
                                                        case 17: 
                                                        case 23: 
                                                        case 30: 
                                                        case 31: {
                                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                            StaticLifeMovement staticLifeMovement7 = a3;
                                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement7.getPosition());
                                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement7.k);
                                                            if (a3.getType() != 23) {
                                                                a2.writeShort(a3.a);
                                                            }
                                                            if (a3.getType() == 15) {
                                                                a2.writeShort(a3.d);
                                                            }
                                                            if (a3.getType() == 23) break;
                                                            StaticLifeMovement staticLifeMovement8 = a3;
                                                            staticLifeMovement6 = staticLifeMovement8;
                                                            a2.writePos(staticLifeMovement8.K);
                                                            break block74;
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
                                                            a2.writePos(a3.k);
                                                            staticLifeMovement6 = a3;
                                                            break block74;
                                                        }
                                                        case 3: 
                                                        case 4: 
                                                        case 7: 
                                                        case 8: 
                                                        case 9: 
                                                        case 11: {
                                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                            StaticLifeMovement staticLifeMovement9 = a3;
                                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement9.getPosition());
                                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement9.a);
                                                            staticLifeMovement6 = a3;
                                                            break block74;
                                                        }
                                                        case 14: {
                                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                            StaticLifeMovement staticLifeMovement10 = a3;
                                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement10.k);
                                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement10.d);
                                                        }
                                                    }
                                                    staticLifeMovement6 = a3;
                                                }
                                                if (staticLifeMovement6.getType() != 10) {
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    maplePacketLittleEndianWriter.write(a3.getNewstate());
                                                    maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                                                    return;
                                                }
                                                a2.write(a3.ALLATORIxDEMO);
                                                return;
                                            }
                                            if (GameSetConstants.MAPLE_VERSION == 120) {
                                                StaticLifeMovement staticLifeMovement11;
                                                StaticLifeMovement staticLifeMovement12 = a3;
                                                a2.write(staticLifeMovement12.getType());
                                                switch (staticLifeMovement12.getType()) {
                                                    case 0: 
                                                    case 5: 
                                                    case 12: 
                                                    case 14: 
                                                    case 35: 
                                                    case 36: {
                                                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                        StaticLifeMovement staticLifeMovement13 = a3;
                                                        a2.writePos(a3.getPosition());
                                                        maplePacketLittleEndianWriter.writePos(staticLifeMovement13.k);
                                                        maplePacketLittleEndianWriter.writeShort(staticLifeMovement13.a);
                                                        if (a3.getType() == 12) {
                                                            a2.writeShort(a3.d);
                                                        }
                                                        a2.writePos(a3.K);
                                                        staticLifeMovement11 = a3;
                                                        break;
                                                    }
                                                    case 1: 
                                                    case 2: 
                                                    case 13: 
                                                    case 16: 
                                                    case 18: 
                                                    case 31: 
                                                    case 32: 
                                                    case 33: 
                                                    case 34: {
                                                        a2.writePos(a3.k);
                                                        staticLifeMovement11 = a3;
                                                        break;
                                                    }
                                                    case 3: 
                                                    case 4: 
                                                    case 6: 
                                                    case 7: 
                                                    case 8: 
                                                    case 10: {
                                                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                        StaticLifeMovement staticLifeMovement14 = a3;
                                                        maplePacketLittleEndianWriter.writePos(staticLifeMovement14.getPosition());
                                                        maplePacketLittleEndianWriter.writeShort(staticLifeMovement14.d);
                                                        staticLifeMovement11 = a3;
                                                        break;
                                                    }
                                                    case 11: {
                                                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                        StaticLifeMovement staticLifeMovement15 = a3;
                                                        maplePacketLittleEndianWriter.writePos(staticLifeMovement15.k);
                                                        maplePacketLittleEndianWriter.writeShort(staticLifeMovement15.a);
                                                        staticLifeMovement11 = a3;
                                                        break;
                                                    }
                                                    case 17: {
                                                        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                        StaticLifeMovement staticLifeMovement16 = a3;
                                                        a2.writePos(a3.getPosition());
                                                        maplePacketLittleEndianWriter.writeShort(staticLifeMovement16.a);
                                                        maplePacketLittleEndianWriter.writeShort(staticLifeMovement16.d);
                                                    }
                                                    default: {
                                                        staticLifeMovement11 = a3;
                                                    }
                                                }
                                                if (staticLifeMovement11.getType() != 9) {
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    maplePacketLittleEndianWriter.write(a3.getNewstate());
                                                    maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                                                    return;
                                                }
                                                a2.write(a3.ALLATORIxDEMO);
                                                return;
                                            }
                                            if (GameSetConstants.MAPLE_VERSION < 152) break block75;
                                            StaticLifeMovement staticLifeMovement17 = a3;
                                            a2.write(staticLifeMovement17.getType());
                                            switch (staticLifeMovement17.getType()) {
                                                case 0: 
                                                case 8: 
                                                case 15: 
                                                case 17: 
                                                case 48: 
                                                case 49: {
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    StaticLifeMovement staticLifeMovement18 = a3;
                                                    a2.writePos(a3.getPosition());
                                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement18.k);
                                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement18.a);
                                                    if (a3.getType() == 15) {
                                                        a2.writeShort(a3.d);
                                                    }
                                                    a2.writePos(a3.K);
                                                    staticLifeMovement5 = a3;
                                                    break block76;
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
                                                    a2.writePos(a3.k);
                                                    if (a3.getType() != 19 && a3.getType() != 20) break;
                                                    a2.writeShort(a3.a);
                                                    staticLifeMovement5 = a3;
                                                    break block76;
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
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    StaticLifeMovement staticLifeMovement19 = a3;
                                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement19.getPosition());
                                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement19.d);
                                                    staticLifeMovement5 = a3;
                                                    break block76;
                                                }
                                                case 14: {
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    StaticLifeMovement staticLifeMovement20 = a3;
                                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement20.k);
                                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement20.a);
                                                    staticLifeMovement5 = a3;
                                                    break block76;
                                                }
                                                case 21: {
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    StaticLifeMovement staticLifeMovement21 = a3;
                                                    a2.writePos(a3.getPosition());
                                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement21.a);
                                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement21.d);
                                                    staticLifeMovement5 = a3;
                                                    break block76;
                                                }
                                                case 47: {
                                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                                    StaticLifeMovement staticLifeMovement22 = a3;
                                                    a2.writePos(a3.getPosition());
                                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement22.a);
                                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement22.K);
                                                }
                                            }
                                            staticLifeMovement5 = a3;
                                        }
                                        if (staticLifeMovement5.getType() != 12) {
                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                            maplePacketLittleEndianWriter.write(a3.getNewstate());
                                            maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                                            return;
                                        }
                                        a2.write(a3.ALLATORIxDEMO);
                                        return;
                                    }
                                    if (GameSetConstants.MAPLE_VERSION != 151) break block77;
                                    StaticLifeMovement staticLifeMovement23 = a3;
                                    a2.write(staticLifeMovement23.getType());
                                    switch (staticLifeMovement23.getType()) {
                                        case 0: 
                                        case 7: 
                                        case 14: 
                                        case 16: 
                                        case 47: 
                                        case 48: {
                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                            StaticLifeMovement staticLifeMovement24 = a3;
                                            a2.writePos(a3.getPosition());
                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement24.k);
                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement24.a);
                                            if (a3.getType() == 14) {
                                                a2.writeShort(a3.d);
                                            }
                                            a2.writePos(a3.K);
                                            staticLifeMovement4 = a3;
                                            break block78;
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
                                            a2.writePos(a3.k);
                                            if (a3.getType() != 18 && a3.getType() != 19) break;
                                            a2.writeShort(a3.a);
                                            staticLifeMovement4 = a3;
                                            break block78;
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
                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                            StaticLifeMovement staticLifeMovement25 = a3;
                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement25.getPosition());
                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement25.d);
                                            staticLifeMovement4 = a3;
                                            break block78;
                                        }
                                        case 13: {
                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                            StaticLifeMovement staticLifeMovement26 = a3;
                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement26.k);
                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement26.a);
                                            staticLifeMovement4 = a3;
                                            break block78;
                                        }
                                        case 20: {
                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                            StaticLifeMovement staticLifeMovement27 = a3;
                                            a2.writePos(a3.getPosition());
                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement27.a);
                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement27.d);
                                            staticLifeMovement4 = a3;
                                            break block78;
                                        }
                                        case 46: {
                                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                            StaticLifeMovement staticLifeMovement28 = a3;
                                            a2.writePos(a3.getPosition());
                                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement28.a);
                                            maplePacketLittleEndianWriter.writePos(staticLifeMovement28.K);
                                        }
                                    }
                                    staticLifeMovement4 = a3;
                                }
                                if (staticLifeMovement4.getType() != 11) {
                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                    maplePacketLittleEndianWriter.write(a3.getNewstate());
                                    maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                                    return;
                                }
                                a2.write(a3.ALLATORIxDEMO);
                                return;
                            }
                            if (GameSetConstants.MAPLE_VERSION < 139) break block79;
                            StaticLifeMovement staticLifeMovement29 = a3;
                            a2.write(staticLifeMovement29.getType());
                            switch (staticLifeMovement29.getType()) {
                                case 0: 
                                case 7: 
                                case 14: 
                                case 16: 
                                case 45: 
                                case 46: {
                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                    StaticLifeMovement staticLifeMovement30 = a3;
                                    a2.writePos(a3.getPosition());
                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement30.k);
                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement30.a);
                                    if (a3.getType() == 14) {
                                        a2.writeShort(a3.d);
                                    }
                                    a2.writePos(a3.K);
                                    staticLifeMovement3 = a3;
                                    break block80;
                                }
                                case 44: {
                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                    StaticLifeMovement staticLifeMovement31 = a3;
                                    a2.writePos(a3.getPosition());
                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement31.a);
                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement31.K);
                                    staticLifeMovement3 = a3;
                                    break block80;
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
                                    a2.writePos(a3.k);
                                    if (a3.getType() != 18 && a3.getType() != 19) break;
                                    a2.writeShort(a3.a);
                                    staticLifeMovement3 = a3;
                                    break block80;
                                }
                                case 3: 
                                case 4: 
                                case 5: 
                                case 6: 
                                case 8: 
                                case 9: 
                                case 10: 
                                case 12: {
                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                    StaticLifeMovement staticLifeMovement32 = a3;
                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement32.getPosition());
                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement32.d);
                                    staticLifeMovement3 = a3;
                                    break block80;
                                }
                                case 13: {
                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                    StaticLifeMovement staticLifeMovement33 = a3;
                                    maplePacketLittleEndianWriter.writePos(staticLifeMovement33.k);
                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement33.a);
                                    staticLifeMovement3 = a3;
                                    break block80;
                                }
                                case 20: {
                                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                    StaticLifeMovement staticLifeMovement34 = a3;
                                    a2.writePos(a3.getPosition());
                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement34.a);
                                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement34.d);
                                }
                            }
                            staticLifeMovement3 = a3;
                        }
                        if (staticLifeMovement3.getType() != 11) {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                            maplePacketLittleEndianWriter.write(a3.getNewstate());
                            maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                            return;
                        }
                        a2.write(a3.ALLATORIxDEMO);
                        return;
                    }
                    if (GameSetConstants.MAPLE_VERSION >= 134) {
                        StaticLifeMovement staticLifeMovement35;
                        StaticLifeMovement staticLifeMovement36 = a3;
                        a2.write(staticLifeMovement36.getType());
                        switch (staticLifeMovement36.getType()) {
                            case 0: 
                            case 6: 
                            case 13: 
                            case 15: 
                            case 37: 
                            case 38: {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                StaticLifeMovement staticLifeMovement37 = a3;
                                a2.writePos(a3.getPosition());
                                maplePacketLittleEndianWriter.writePos(staticLifeMovement37.k);
                                maplePacketLittleEndianWriter.writeShort(staticLifeMovement37.a);
                                if (a3.getType() == 13) {
                                    a2.writeShort(a3.d);
                                }
                                a2.writePos(a3.K);
                                staticLifeMovement35 = a3;
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
                                a2.writePos(a3.k);
                                staticLifeMovement35 = a3;
                                break;
                            }
                            case 3: 
                            case 4: 
                            case 5: 
                            case 7: 
                            case 8: 
                            case 9: 
                            case 11: {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                StaticLifeMovement staticLifeMovement38 = a3;
                                maplePacketLittleEndianWriter.writePos(staticLifeMovement38.getPosition());
                                maplePacketLittleEndianWriter.writeShort(staticLifeMovement38.d);
                                staticLifeMovement35 = a3;
                                break;
                            }
                            case 12: {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                StaticLifeMovement staticLifeMovement39 = a3;
                                maplePacketLittleEndianWriter.writePos(staticLifeMovement39.k);
                                maplePacketLittleEndianWriter.writeShort(staticLifeMovement39.a);
                                staticLifeMovement35 = a3;
                                break;
                            }
                            case 18: {
                                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                                StaticLifeMovement staticLifeMovement40 = a3;
                                a2.writePos(a3.getPosition());
                                maplePacketLittleEndianWriter.writeShort(staticLifeMovement40.a);
                                maplePacketLittleEndianWriter.writeShort(staticLifeMovement40.d);
                            }
                            default: {
                                staticLifeMovement35 = a3;
                            }
                        }
                        if (staticLifeMovement35.getType() != 10) {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                            maplePacketLittleEndianWriter.write(a3.getNewstate());
                            maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                            return;
                        }
                        a2.write(a3.ALLATORIxDEMO);
                        return;
                    }
                    if (GameSetConstants.MAPLE_VERSION != 75) break block81;
                    StaticLifeMovement staticLifeMovement41 = a3;
                    a2.write(staticLifeMovement41.getType());
                    switch (staticLifeMovement41.getType()) {
                        case 0: 
                        case 5: 
                        case 15: 
                        case 17: {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                            StaticLifeMovement staticLifeMovement42 = a3;
                            a2.writePos(a3.getPosition());
                            maplePacketLittleEndianWriter.writePos(staticLifeMovement42.k);
                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement42.a);
                            if (a3.getType() != 15 && a3.getType() != 16) break;
                            a2.writeShort(a3.d);
                            staticLifeMovement2 = a3;
                            break block82;
                        }
                        case 1: 
                        case 2: 
                        case 6: 
                        case 12: 
                        case 13: 
                        case 16: 
                        case 18: {
                            a2.writePos(a3.k);
                            staticLifeMovement2 = a3;
                            break block82;
                        }
                        case 3: 
                        case 4: 
                        case 7: 
                        case 8: 
                        case 9: 
                        case 11: {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                            StaticLifeMovement staticLifeMovement43 = a3;
                            maplePacketLittleEndianWriter.writePos(staticLifeMovement43.getPosition());
                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement43.a);
                            staticLifeMovement2 = a3;
                            break block82;
                        }
                        case 14: {
                            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                            StaticLifeMovement staticLifeMovement44 = a3;
                            maplePacketLittleEndianWriter.writePos(staticLifeMovement44.k);
                            maplePacketLittleEndianWriter.writeShort(staticLifeMovement44.d);
                        }
                    }
                    staticLifeMovement2 = a3;
                }
                if (staticLifeMovement2.getType() != 10) {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    maplePacketLittleEndianWriter.write(a3.getNewstate());
                    maplePacketLittleEndianWriter.writeShort(a3.getDuration());
                    return;
                }
                a2.write(a3.ALLATORIxDEMO);
                return;
            }
            a2.write(a3.getType());
            switch (a3.getType()) {
                case 0: 
                case 5: 
                case 15: 
                case 17: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    StaticLifeMovement staticLifeMovement45 = a3;
                    a2.writePos(a3.getPosition());
                    maplePacketLittleEndianWriter.writePos(staticLifeMovement45.k);
                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement45.a);
                    if (a3.getType() != 15 && a3.getType() != 16) break;
                    a2.writeShort(a3.d);
                    staticLifeMovement = a3;
                    break block83;
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
                    a2.writePos(a3.k);
                    staticLifeMovement = a3;
                    break block83;
                }
                case 3: 
                case 4: 
                case 7: 
                case 8: 
                case 9: 
                case 11: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    StaticLifeMovement staticLifeMovement46 = a3;
                    maplePacketLittleEndianWriter.writePos(staticLifeMovement46.getPosition());
                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement46.a);
                    staticLifeMovement = a3;
                    break block83;
                }
                case 14: {
                    MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
                    StaticLifeMovement staticLifeMovement47 = a3;
                    maplePacketLittleEndianWriter.writePos(staticLifeMovement47.k);
                    maplePacketLittleEndianWriter.writeShort(staticLifeMovement47.d);
                }
            }
            staticLifeMovement = a3;
        }
        if (staticLifeMovement.getType() != 10) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            maplePacketLittleEndianWriter.write(a3.getNewstate());
            maplePacketLittleEndianWriter.writeShort(a3.getDuration());
            return;
        }
        a2.write(a3.ALLATORIxDEMO);
    }

    public /* synthetic */ StaticLifeMovement(int a2, Point a3, int a4, int a5, int a6) {
        super(a2, a3, a4, a5, a6);
        StaticLifeMovement a7;
    }

    public /* synthetic */ short getUnk() {
        StaticLifeMovement a2;
        return a2.a;
    }

    public /* synthetic */ void setPixelsPerSecond(Point a2) {
        a.k = a2;
    }

    public /* synthetic */ void setOffset(Point a2) {
        a.K = a2;
    }

    public /* synthetic */ void setFh(short a2) {
        a.d = a2;
    }

    public /* synthetic */ void defaulted() {
        StaticLifeMovement a2;
        StaticLifeMovement staticLifeMovement = a2;
        a2.a = 0;
        staticLifeMovement.d = 0;
        StaticLifeMovement staticLifeMovement2 = a2;
        staticLifeMovement.k = new Point(0, 0);
        staticLifeMovement.ALLATORIxDEMO = 0;
    }

    public /* synthetic */ void setUnk(short a2) {
        a.a = a2;
    }

    public /* synthetic */ void setWui(int a2) {
        a.ALLATORIxDEMO = a2;
    }
}

