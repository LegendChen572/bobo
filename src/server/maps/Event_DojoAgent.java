/*
 * Decompiled with CFR 0.150.
 */
package server.maps;

import client.MapleCharacter;
import client.MapleTrait;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.world.MaplePartyCharacter;
import java.awt.Point;
import server.Randomizer;
import server.Timer;
import server.life.MapleLifeFactory;
import server.maps.MapleMap;
import tools.packet.BeansPacket;

public class Event_DojoAgent {
    private static final /* synthetic */ int K = 970030000;
    private static final /* synthetic */ Point a;
    private static final /* synthetic */ Point ALLATORIxDEMO;
    private static final /* synthetic */ Point d;

    /*
     * Exception decompiling
     */
    public static /* synthetic */ boolean warpNextMap(MapleCharacter a, boolean a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[TRYBLOCK]], but top level block is 12[WHILELOOP]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    public static /* synthetic */ boolean warpStartAgent(MapleCharacter a2, boolean a3322) {
        int n2;
        a3322 = true;
        int a3322 = 970030100;
        ChannelServer a3322 = a2.getClient().getChannelServer();
        int n3 = n2 = 970030100;
        while (n3 < 970030110) {
            MapleMap mapleMap = a3322.getMapFactory().getMap(n2);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap2 = mapleMap;
                Event_DojoAgent.ALLATORIxDEMO(mapleMap, false);
                a2.changeMap(mapleMap2, mapleMap.getPortal(0));
                mapleMap2.respawn(true);
                return true;
            }
            n3 = ++n2;
        }
        return false;
    }

    public static /* synthetic */ {
        a = new Point(140, 0);
        d = new Point(-193, 0);
        ALLATORIxDEMO = new Point(355, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final /* synthetic */ int ALLATORIxDEMO(int a2) {
        if (GameSetConstants.DojoPoints_AllPass) {
            if (a2 == 38) {
                return Randomizer.rand(GameSetConstants.DojoPoints[0], GameSetConstants.DojoPoints[1]);
            }
            return 0;
        }
        if (GameSetConstants.DojoPoints[0] != 0) {
            return Randomizer.rand(GameSetConstants.DojoPoints[0], GameSetConstants.DojoPoints[1]);
        }
        switch (a2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 1;
            }
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 19: 
            case 20: {
                return 2;
            }
            case 21: 
            case 22: 
            case 23: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: {
                return 3;
            }
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: {
                return 4;
            }
            case 37: 
            case 38: {
                return 8;
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final /* synthetic */ void ALLATORIxDEMO(final MapleMap a2, final int a3) {
        int n2;
        int n3;
        if (GameSetConstants.MAPLE_VERSION >= 148) {
            switch (a3) {
                case 1: {
                    n2 = n3 = 9305300;
                    break;
                }
                case 2: {
                    n2 = n3 = 9305301;
                    break;
                }
                case 3: {
                    n2 = n3 = 9305302;
                    break;
                }
                case 4: {
                    n2 = n3 = 9305303;
                    break;
                }
                case 5: {
                    n2 = n3 = 9305304;
                    break;
                }
                case 7: {
                    n2 = n3 = 9305305;
                    break;
                }
                case 8: {
                    n2 = n3 = 9305306;
                    break;
                }
                case 9: {
                    n2 = n3 = 9305307;
                    break;
                }
                case 10: {
                    n2 = n3 = 9305308;
                    break;
                }
                case 11: {
                    n2 = n3 = 9305309;
                    break;
                }
                case 13: {
                    n2 = n3 = 9305310;
                    break;
                }
                case 14: {
                    n2 = n3 = 9305311;
                    break;
                }
                case 15: {
                    n2 = n3 = 9305312;
                    break;
                }
                case 16: {
                    n2 = n3 = 9305313;
                    break;
                }
                case 17: {
                    n2 = n3 = 9305314;
                    break;
                }
                case 19: {
                    n2 = n3 = 9305315;
                    break;
                }
                case 20: {
                    n2 = n3 = 9305316;
                    break;
                }
                case 21: {
                    n2 = n3 = 9305317;
                    break;
                }
                case 22: {
                    n2 = n3 = 9305318;
                    break;
                }
                case 23: {
                    n2 = n3 = 9305319;
                    break;
                }
                case 25: {
                    n2 = n3 = 9305320;
                    break;
                }
                case 26: {
                    n2 = n3 = 9305321;
                    break;
                }
                case 27: {
                    n2 = n3 = 9305322;
                    break;
                }
                case 28: {
                    n2 = n3 = 9305323;
                    break;
                }
                case 29: {
                    n2 = n3 = 9305324;
                    break;
                }
                case 31: {
                    n2 = n3 = 9305325;
                    break;
                }
                case 32: {
                    n2 = n3 = 9305326;
                    break;
                }
                case 33: {
                    n2 = n3 = 9305327;
                    break;
                }
                case 34: {
                    n2 = n3 = 9305328;
                    break;
                }
                case 35: {
                    n2 = n3 = 9305329;
                    break;
                }
                case 37: {
                    n2 = n3 = 9305330;
                    break;
                }
                case 38: {
                    n2 = n3 = 9305331;
                    break;
                }
                case 39: {
                    n2 = n3 = 9305332;
                    break;
                }
                case 40: {
                    n2 = n3 = 9305333;
                    break;
                }
                case 41: {
                    n2 = n3 = 9305334;
                    break;
                }
                case 43: {
                    n2 = n3 = 9305335;
                    break;
                }
                case 44: {
                    n2 = n3 = 9305336;
                    break;
                }
                case 45: {
                    n2 = n3 = 9305337;
                    break;
                }
                case 46: {
                    n2 = n3 = 9305338;
                    break;
                }
                case 47: {
                    n2 = n3 = 9305339;
                    break;
                }
                default: {
                    n2 = n3 = 0;
                    break;
                }
            }
        } else {
            switch (a3) {
                case 1: {
                    n2 = n3 = 0x8DE8D8;
                    break;
                }
                case 2: {
                    n2 = n3 = 9300185;
                    break;
                }
                case 3: {
                    n2 = n3 = 9300186;
                    break;
                }
                case 4: {
                    n2 = n3 = 9300187;
                    break;
                }
                case 5: {
                    n2 = n3 = 9300188;
                    break;
                }
                case 7: {
                    n2 = n3 = 0x8DE8DD;
                    break;
                }
                case 8: {
                    n2 = n3 = 0x8DE8DE;
                    break;
                }
                case 9: {
                    n2 = n3 = 9300191;
                    break;
                }
                case 10: {
                    n2 = n3 = 9300192;
                    break;
                }
                case 11: {
                    n2 = n3 = 9300193;
                    break;
                }
                case 13: {
                    n2 = n3 = 9300194;
                    break;
                }
                case 14: {
                    n2 = n3 = 9300195;
                    break;
                }
                case 15: {
                    n2 = n3 = 9300196;
                    break;
                }
                case 16: {
                    n2 = n3 = 9300197;
                    break;
                }
                case 17: {
                    n2 = n3 = 9300198;
                    break;
                }
                case 19: {
                    n2 = n3 = 9300199;
                    break;
                }
                case 20: {
                    n2 = n3 = 0x8DE8E8;
                    break;
                }
                case 21: {
                    n2 = n3 = 9300201;
                    break;
                }
                case 22: {
                    n2 = n3 = 9300202;
                    break;
                }
                case 23: {
                    n2 = n3 = 9300203;
                    break;
                }
                case 25: {
                    n2 = n3 = 9300204;
                    break;
                }
                case 26: {
                    n2 = n3 = 0x8DE8ED;
                    break;
                }
                case 27: {
                    n2 = n3 = 0x8DE8EE;
                    break;
                }
                case 28: {
                    n2 = n3 = 9300207;
                    break;
                }
                case 29: {
                    n2 = n3 = 9300208;
                    break;
                }
                case 31: {
                    n2 = n3 = 9300209;
                    break;
                }
                case 32: {
                    n2 = n3 = 9300210;
                    break;
                }
                case 33: {
                    n2 = n3 = 9300211;
                    break;
                }
                case 34: {
                    n2 = n3 = 9300212;
                    break;
                }
                case 35: {
                    n2 = n3 = 9300213;
                    break;
                }
                case 37: {
                    n2 = n3 = 9300214;
                    break;
                }
                case 38: {
                    n2 = n3 = 9300215;
                    break;
                }
                default: {
                    n2 = n3 = 0;
                }
            }
        }
        if (n2 != 0) {
            a3 = Randomizer.nextInt(3);
            Timer.MapTimer.getInstance().schedule(new Runnable(){
                {
                    1 a22;
                }

                @Override
                public /* synthetic */ void run() {
                    1 a22;
                    1 v0 = a22;
                    v0.a2.spawnMonsterWithEffect(MapleLifeFactory.getMonster(v0.n3), 15, a22.a3 == 0 ? a : (a22.a3 == 1 ? d : ALLATORIxDEMO));
                }
            }, 3000L);
        }
    }

    public static /* synthetic */ boolean warpStartDojo(MapleCharacter a2, boolean a322) {
        ChannelServer channelServer;
        boolean bl;
        int n2;
        int n3;
        block19: {
            int n4;
            int n5;
            int n6;
            n3 = 1;
            if (a322 || n3 <= -1 || n3 > 38) {
                n3 = 1;
            }
            n2 = 925020000 + n3 * 100;
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                n2 = 925060000 + n3 * 100;
            }
            bl = false;
            ChannelServer channelServer2 = a2.getClient().getChannelServer();
            if (GameSetConstants.MAPLE_VERSION >= 148) {
                n6 = 1;
                int n7 = n5 = 0;
                while (n7 < 1) {
                    int n8;
                    block16: {
                        int n9 = n4 = 1;
                        while (n9 <= 47) {
                            MapleMap object = channelServer2.getMapFactory().getMap(925060000 + 100 * n4);
                            if (object.getCharactersSize() > 0) {
                                n8 = n6 = 0;
                                break block16;
                            }
                            Event_DojoAgent.ALLATORIxDEMO(object, false);
                            n9 = ++n4;
                        }
                        n8 = n6;
                    }
                    if (n8 != 0) {
                        bl = true;
                        n2 += n5;
                        break;
                    }
                    n7 = ++n5;
                }
            } else {
                int n10 = n6 = 0;
                while (n10 < 10) {
                    int n11;
                    block18: {
                        n5 = 1;
                        int n12 = n4 = 1;
                        while (n12 < 39) {
                            MapleMap mapleMap = channelServer2.getMapFactory().getMap(925020000 + 100 * n4 + n6);
                            if (mapleMap.getCharactersSize() > 0) {
                                n11 = n5 = 0;
                                break block18;
                            }
                            Event_DojoAgent.ALLATORIxDEMO(mapleMap, false);
                            n12 = ++n4;
                        }
                        n11 = n5;
                    }
                    if (n11 != 0) {
                        bl = true;
                        n2 += n6;
                        channelServer = channelServer2;
                        break block19;
                    }
                    n10 = ++n6;
                }
            }
            channelServer = channelServer2;
        }
        MapleMap mapleMap = channelServer.getMapFactory().getMap(n2);
        MapleMap mapleMap2 = a2.getMap();
        if (bl) {
            if (a322 && a2.getParty() != null) {
                for (MaplePartyCharacter maplePartyCharacter : a2.getParty().getMembers()) {
                    MapleCharacter a322 = mapleMap2.getCharacterById(maplePartyCharacter.getId());
                    if (a322 == null || !a322.isAlive()) continue;
                    MapleCharacter mapleCharacter = a322;
                    MapleMap mapleMap3 = mapleMap;
                    mapleCharacter.changeMap(mapleMap3, mapleMap3.getPortal(0));
                    mapleCharacter.setAcLog(MapleTrait.ALLATORIxDEMO("\u6b3f\u9627\u900a\u5866"));
                }
            } else {
                MapleMap mapleMap4 = mapleMap;
                a2.changeMap(mapleMap4, mapleMap4.getPortal(0));
                a2.setAcLog(BeansPacket.ALLATORIxDEMO("\u6b24\u9650\u9011\u5811"));
            }
            Event_DojoAgent.ALLATORIxDEMO(mapleMap, n3);
        }
        return bl;
    }

    public /* synthetic */ Event_DojoAgent() {
        Event_DojoAgent a2;
    }

    public static /* synthetic */ boolean warpNextMap_Agent(MapleCharacter a2, boolean a32) {
        MapleCharacter mapleCharacter = a2;
        int n2 = mapleCharacter.getMapId();
        int n3 = (n2 - 970030000) / 100;
        MapleMap mapleMap = mapleCharacter.getMap();
        if (mapleMap.getNumMonsters() > 0) {
            return false;
        }
        if (!a32) {
            Event_DojoAgent.ALLATORIxDEMO(mapleMap, true);
        }
        ChannelServer a32 = a2.getClient().getChannelServer();
        if (n2 >= 970032700 && n2 <= 970032800) {
            MapleMap mapleMap2 = mapleMap = a32.getMapFactory().getMap(970030000);
            a2.changeMap(mapleMap2, mapleMap2.getPortal(0));
            return true;
        }
        int n4 = n3 = (n2 = 970030000 + (n3 + 1) * 100);
        while (n4 < n2 + 7) {
            mapleMap = a32.getMapFactory().getMap(n3);
            if (mapleMap.getCharactersSize() == 0) {
                MapleMap mapleMap3 = mapleMap;
                Event_DojoAgent.ALLATORIxDEMO(mapleMap, false);
                a2.changeMap(mapleMap3, mapleMap.getPortal(0));
                mapleMap3.respawn(true);
                return true;
            }
            n4 = ++n3;
        }
        return false;
    }

    private static final /* synthetic */ void ALLATORIxDEMO(MapleMap a2, boolean a3) {
        if (a3 && a2.getCharactersSize() != 0) {
            return;
        }
        a2.resetFully();
    }
}

