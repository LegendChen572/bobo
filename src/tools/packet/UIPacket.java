/*
 * Decompiled with CFR 0.150.
 */
package tools.packet;

import constants.GameSetConstants;
import handling.SendPacketOpcode;
import handling.opcodes.GameDirectionType;
import handling.opcodes.SpecialEffect;
import handling.opcodes.StatusInfoType;
import handling.world.MapleMessenger;
import tools.MaplePacketCreator;
import tools.data.MaplePacketLittleEndianWriter;

public class UIPacket {
    public static /* synthetic */ byte[] getBanReturnStoneMsg(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(23);
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendNewPyramidLife(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.NEW_PYRAMID_LIFE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] Aran_Start() {
        return MaplePacketCreator.environmentChange(MapleMessenger.ALLATORIxDEMO(":j\u001avTz\u001at\u0017w\u0014v"), 4);
    }

    public static /* synthetic */ byte[] sendNewPyramidScore(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.NEW_PYRAMID_SCORE.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] disableOthers(boolean a2) {
        boolean bl = a2;
        return UIPacket.disableOthers(bl, bl ? 1 : 0);
    }

    public static /* synthetic */ byte[] showFishingGain(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        int n2 = a2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(StatusInfoType.FISHING_MSG.getValue());
        maplePacketLittleEndianWriter2.write(n2);
        switch (n2) {
            case 1: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                while (false) {
                }
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter4.writeInt(a3);
                maplePacketLittleEndianWriter4.writeShort(a4);
                break;
            }
            case 2: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.writeInt(a3);
                break;
            }
            default: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter6.writeInt(a3);
                maplePacketLittleEndianWriter6.writeInt(a4);
            }
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] IntroDisableUI(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CYGNUS_INTRO_DISABLE_UI.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getMidMsg(String a2, boolean a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MID_MSG.getValue());
        maplePacketLittleEndianWriter3.write(a4);
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 0 : 1);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] setBackScreen(int a2, int a3, int a4, int a5) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SET_BACK_EFFECT.getValue());
        maplePacketLittleEndianWriter3.write(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter2.write(a4);
        maplePacketLittleEndianWriter2.write(a5);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getGPMsg(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.GP_MSG.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] IntroEnableUI(boolean a2) {
        boolean bl;
        int n2;
        if (a2) {
            n2 = 1;
            bl = a2;
        } else {
            n2 = 0;
            bl = a2;
        }
        return UIPacket.IntroEnableUI(n2, bl ? 1 : 0);
    }

    public static final /* synthetic */ byte[] playMovie(String a2, boolean a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.PLAY_MOVIE.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.write(a3 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] pamsSongEffect(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.PAMS_SONG.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public /* synthetic */ UIPacket() {
        UIPacket a2;
    }

    public static /* synthetic */ byte[] summonHelper(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.SUMMON_HINT.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getBPMsg(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.BP_MSG.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] IntroLock(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CYGNUS_INTRO_LOCK.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] closeUI(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CLOSE_UI.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] summonMessage(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.SUMMON_HINT_MSG.getValue());
        maplePacketLittleEndianWriter4.write(0);
        maplePacketLittleEndianWriter3.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter3.writeInt(200);
        maplePacketLittleEndianWriter2.writeShort(0);
        maplePacketLittleEndianWriter2.writeInt(10000);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] fishingUpdate(byte a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.FISHING_BOARD_UPDATE.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] useSoulStone() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(SpecialEffect.SOUL_STONE.getValue());
        maplePacketLittleEndianWriter2.writeZeroBytes(12);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getDirectionInfo(String a2, int a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter5.writeShort(SendPacketOpcode.DIRECTION_INFO.getValue());
        maplePacketLittleEndianWriter5.write(2);
        maplePacketLittleEndianWriter4.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter4.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter3.writeInt(a5);
        maplePacketLittleEndianWriter2.writeShort(a6);
        maplePacketLittleEndianWriter2.writeInt(0);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] sendNewPyramidResult(boolean a2, int a3, int a4, int a5, int a6) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter4.writeShort(SendPacketOpcode.NEW_PYRAMID_RESULT.getValue());
        maplePacketLittleEndianWriter4.write(a2);
        maplePacketLittleEndianWriter3.writeInt(a3);
        maplePacketLittleEndianWriter3.writeInt(a4);
        maplePacketLittleEndianWriter2.writeInt(a5);
        maplePacketLittleEndianWriter2.writeInt(a6);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] MapNameDisplay(int a2) {
        return MaplePacketCreator.environmentChange("maplemap/enter/" + a2, 3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ byte[] getDirectionEffect(GameDirectionType a2, String a3, int[] a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter2 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.DIRECTION_INFO.getValue());
        maplePacketLittleEndianWriter3.write(a2.getValue());
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 1: {
                int[] arrn;
                maplePacketLittleEndianWriter2.writeInt(a4[0]);
                int n2 = 441;
                if (GameSetConstants.MAPLE_VERSION >= 152) {
                    n2 = 539;
                    arrn = a4;
                } else if (GameSetConstants.MAPLE_VERSION > 147) {
                    n2 = 457;
                    arrn = a4;
                } else if (GameSetConstants.MAPLE_VERSION == 147) {
                    n2 = 441;
                    arrn = a4;
                } else {
                    if (GameSetConstants.MAPLE_VERSION >= 139) {
                        n2 = 397;
                    }
                    arrn = a4;
                }
                if (arrn[0] > n2) break;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter4 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter4;
                maplePacketLittleEndianWriter4.writeInt(a4[1]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 2: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter5 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter5;
                maplePacketLittleEndianWriter5.writeInt(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 3: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter6 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
                maplePacketLittleEndianWriter6.writeInt(a4[0]);
                maplePacketLittleEndianWriter6.writeInt(a4[1]);
                maplePacketLittleEndianWriter2.writeInt(a4[2]);
                maplePacketLittleEndianWriter2.write(a4[3]);
                if (a4[3] > 0) {
                    maplePacketLittleEndianWriter2.writeInt(a4[5]);
                }
                maplePacketLittleEndianWriter2.write(a4[4]);
                if (a4[4] <= 0) break;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter7 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter7.writeInt(a4[6]);
                maplePacketLittleEndianWriter7.write(a4[6] > 0 ? 0 : 1);
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter8 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter8;
                maplePacketLittleEndianWriter8.write(a4[7]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 4: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter9 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter9;
                maplePacketLittleEndianWriter9.writeInt(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 5: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter10 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter2.writeMapleAsciiString(a3);
                maplePacketLittleEndianWriter2.writeInt(a4[0]);
                maplePacketLittleEndianWriter10.writeInt(a4[1]);
                maplePacketLittleEndianWriter10.writeInt(a4[2]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 6: {
                maplePacketLittleEndianWriter2.write(a4[0]);
                maplePacketLittleEndianWriter2.writeInt(a4[1]);
                if (a4[1] <= 0 || a4[0] != 0) break;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter11 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter11;
                maplePacketLittleEndianWriter11.writeInt(a4[2]);
                maplePacketLittleEndianWriter11.writeInt(a4[3]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 7: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter12 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter12;
                maplePacketLittleEndianWriter12.write(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 8: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter13 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter14 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter14.writeInt(a4[0]);
                maplePacketLittleEndianWriter14.writeInt(a4[1]);
                maplePacketLittleEndianWriter2.writeInt(a4[2]);
                maplePacketLittleEndianWriter13.writeInt(a4[3]);
                maplePacketLittleEndianWriter13.writeInt(a4[4]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 9: {
                break;
            }
            case 10: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter15 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter15;
                maplePacketLittleEndianWriter15.write(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 11: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter16 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter16;
                maplePacketLittleEndianWriter16.writeInt(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 12: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter17 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter17.writeMapleAsciiString(a3);
                maplePacketLittleEndianWriter17.write(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 13: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter18 = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter19 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter19.writeMapleAsciiString(a3);
                maplePacketLittleEndianWriter19.write(a4[0]);
                maplePacketLittleEndianWriter2.writeShort(a4[1]);
                maplePacketLittleEndianWriter18.writeInt(a4[2]);
                maplePacketLittleEndianWriter18.writeInt(a4[3]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 14: {
                maplePacketLittleEndianWriter2.write(a4[0]);
                int n3 = a3 = 0;
                while (n3 >= a4[0]) {
                    maplePacketLittleEndianWriter2.writeInt(a4[1]);
                    n3 = ++a3;
                }
                break;
            }
            case 15: {
                break;
            }
            case 16: {
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter20 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter20.writeInt(a4[0]);
                maplePacketLittleEndianWriter20.writeInt(a4[1]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 17: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter21 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter21;
                maplePacketLittleEndianWriter21.writeInt(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            case 18: {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter22 = maplePacketLittleEndianWriter2;
                maplePacketLittleEndianWriter = maplePacketLittleEndianWriter22;
                maplePacketLittleEndianWriter22.write(a4[0]);
                return maplePacketLittleEndianWriter.getPacket();
            }
            default: {
                System.out.println("CField.getDirectionInfo() is Unknow mod :: [" + a2 + "]");
            }
        }
        maplePacketLittleEndianWriter = maplePacketLittleEndianWriter2;
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] getDirectionStatus(boolean a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.DIRECTION_STATUS.getValue());
        maplePacketLittleEndianWriter2.write(a2 ? 1 : 0);
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] IntroEnableUI(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.CYGNUS_INTRO_ENABLE_UI.getValue());
        maplePacketLittleEndianWriter2.write(a2 > 0 ? 1 : 0);
        if (a2 > 0) {
            maplePacketLittleEndianWriter.writeShort(a3);
        }
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] sendNewPyramidLevel(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.NEW_PYRAMID_LEVEL.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] ResetScreen() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CLEAR_BACK_EFFECT.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static /* synthetic */ byte[] fishingCaught(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.FISHING_CAUGHT.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] ShowWZEffect2(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter3.write(SpecialEffect.WZ_EFFECT2.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeInt(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] MoveScreen(int a2, int a3, int a4) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.MOVE_SCREEN.getValue());
        maplePacketLittleEndianWriter3.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(a3);
        maplePacketLittleEndianWriter2.writeInt(a4);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getSPMsg(byte a2, short a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter3.write(StatusInfoType.SP_MSG.getValue());
        maplePacketLittleEndianWriter2.writeShort(a3);
        maplePacketLittleEndianWriter2.write(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getStatusMsg(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_STATUS_INFO.getValue());
        maplePacketLittleEndianWriter2.write(StatusInfoType.STATUS_MSG.getValue());
        maplePacketLittleEndianWriter2.writeInt(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] EarnTitleMsg(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.EARN_TITLE_MSG.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] getTopMsg(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter2.writeShort(SendPacketOpcode.TOP_MSG.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] MapEff(String a2) {
        return MaplePacketCreator.environmentChange(a2, 3);
    }

    public static /* synthetic */ byte[] summonMessage(int a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SUMMON_HINT_MSG.getValue());
        maplePacketLittleEndianWriter3.write(1);
        maplePacketLittleEndianWriter2.writeInt(a2);
        maplePacketLittleEndianWriter2.writeInt(7000);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] clearMidMsg() {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CLEAR_MID_MSG.getValue());
        return maplePacketLittleEndianWriter.getPacket();
    }

    public static final /* synthetic */ byte[] ShowWZEffect(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter2.write(SpecialEffect.WZ_EFFECT.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static final /* synthetic */ byte[] AranTutInstructionalBalloon(String a2) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = maplePacketLittleEndianWriter;
        maplePacketLittleEndianWriter3.writeShort(SendPacketOpcode.SHOW_USER_LOCAL_EFFECT.getValue());
        maplePacketLittleEndianWriter3.write(SpecialEffect.WZ_EFFECT2.getValue());
        maplePacketLittleEndianWriter2.writeMapleAsciiString(a2);
        maplePacketLittleEndianWriter2.writeInt(1);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] disableOthers(boolean a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a3 = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.CYGNUS_INTRO_DISABLE_UI.getValue());
        maplePacketLittleEndianWriter.write(a2 ? 1 : 0);
        return a3.getPacket();
    }

    public static /* synthetic */ byte[] getDirectionInfo(int a2, int a3) {
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter;
        MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = maplePacketLittleEndianWriter = new MaplePacketLittleEndianWriter();
        maplePacketLittleEndianWriter.writeShort(SendPacketOpcode.DIRECTION_INFO.getValue());
        maplePacketLittleEndianWriter2.write(a2);
        maplePacketLittleEndianWriter2.writeLong(a3);
        return maplePacketLittleEndianWriter2.getPacket();
    }

    public static /* synthetic */ byte[] IntroEnableUI(int a2) {
        int n2 = a2;
        return UIPacket.IntroEnableUI(n2, n2);
    }
}

