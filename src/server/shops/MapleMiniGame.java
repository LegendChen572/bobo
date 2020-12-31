/*
 * Decompiled with CFR 0.150.
 */
package server.shops;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleQuestStatus;
import handling.channel.handler.BuddyListHandler;
import handling.world.family.MapleFamily;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import server.quest.MapleQuest;
import server.shops.AbstractPlayerStore;
import tools.packet.PlayerShopPacket;

public class MapleMiniGame
extends AbstractPlayerStore {
    private /* synthetic */ boolean[] C;
    private /* synthetic */ int e;
    private /* synthetic */ int[] H;
    public /* synthetic */ int K;
    public /* synthetic */ int B;
    public /* synthetic */ int d;
    public /* synthetic */ int a;
    public /* synthetic */ boolean canShop;
    private /* synthetic */ int M;
    private /* synthetic */ boolean[] F;
    private static final /* synthetic */ int I = 2;
    private /* synthetic */ List<Integer> g;
    private /* synthetic */ int[][] E;
    public /* synthetic */ int k;
    public /* synthetic */ int ALLATORIxDEMO;

    public /* synthetic */ int getScore(MapleCharacter a22) {
        int n2;
        int n3;
        MapleMiniGame a3;
        int n4 = 2000;
        MapleMiniGame mapleMiniGame = a3;
        MapleCharacter mapleCharacter = a22;
        int a22 = a3.getWins(mapleCharacter);
        if (a22 + (n3 = mapleMiniGame.getTies(mapleCharacter)) + (n2 = mapleMiniGame.getLosses(a22)) > 0) {
            n4 += a22 * 2;
            n4 += n3;
            n4 -= n2 * 2;
        }
        return n4;
    }

    @Override
    public /* synthetic */ void buy(MapleClient a2, int a3, short a4) {
    }

    public /* synthetic */ void setRequestedTie(int a2) {
        a.d = a2;
    }

    public /* synthetic */ int getPoints() {
        int n2;
        int n3 = 0;
        int n4 = n2 = 0;
        while (n4 < 2) {
            MapleMiniGame a2;
            n3 += a2.H[n2++];
            n4 = n2;
        }
        return n3;
    }

    public /* synthetic */ void setFirstSlot(int a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3) {
        MapleMiniGame a4;
        MapleMiniGame mapleMiniGame = a4;
        mapleMiniGame.removeAllVisitors(3, 1);
        if (mapleMiniGame.getMCOwner() != null) {
            a4.getMCOwner().setPlayerShop(null);
        }
        MapleMiniGame mapleMiniGame2 = a4;
        mapleMiniGame2.update();
        mapleMiniGame2.getMap().removeMapObject(a4);
    }

    public /* synthetic */ void setPoints(int a22, int a32) {
        MapleMiniGame a4;
        MapleCharacter mapleCharacter;
        if ((a22 == 0 ? (mapleCharacter = a4.getMCOwner()) : (mapleCharacter = a4.getVisitor(a22 - 1))) != null) {
            int n2;
            String[] a22 = a4.getData(mapleCharacter).split(MapleFamily.ALLATORIxDEMO("l"));
            a22[a32] = String.valueOf(Integer.parseInt(a22[a32]) + 1);
            StringBuilder a32 = new StringBuilder();
            int n3 = n2 = 0;
            while (n3 < a22.length) {
                a32.append(a22[n2]);
                a32.append(BuddyListHandler.ALLATORIxDEMO("\u0016"));
                n3 = ++n2;
            }
            String string = a32.toString();
            String string2 = string;
            mapleCharacter.getQuestNAdd(MapleQuest.getInstance(a4.e == 1 ? 122200 : 122210)).setCustomData(string2.substring(0, string2.length() - 1));
        }
    }

    public /* synthetic */ void setRequestedREDO(int a2) {
        a.ALLATORIxDEMO = a2;
    }

    public /* synthetic */ void setExitAfter(MapleCharacter a2) {
        MapleMiniGame a3;
        if (a3.getVisitorSlot(a2) > -1) {
            a3.F[a3.getVisitorSlot((MapleCharacter)a2)] = !a3.F[a3.getVisitorSlot(a2)];
        }
    }

    public /* synthetic */ void setPieceType(int a2) {
        a.K = a2;
    }

    @Override
    public final /* synthetic */ boolean getCanShop() {
        MapleMiniGame a2;
        return a2.canShop;
    }

    public /* synthetic */ void checkExitAfterGame() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 2) {
            MapleMiniGame a2;
            if (a2.F[n2]) {
                MapleMiniGame mapleMiniGame = a2;
                mapleMiniGame.F[n2] = false;
                mapleMiniGame.exit(n2 == 0 ? a2.getMCOwner() : (MapleCharacter)a2.chrs[n2 - 1].get());
            }
            n3 = ++n2;
        }
    }

    public /* synthetic */ void shuffleList() {
        MapleMiniGame mapleMiniGame;
        MapleMiniGame a2;
        if (a2.e == 2) {
            MapleMiniGame mapleMiniGame2 = a2;
            mapleMiniGame = mapleMiniGame2;
            Collections.shuffle(mapleMiniGame2.g);
        } else {
            a2.E = new int[15][15];
            mapleMiniGame = a2;
        }
        mapleMiniGame.M = -1;
    }

    public /* synthetic */ void send(MapleClient a2) {
        MapleMiniGame a3;
        if (a3.getMCOwner() == null) {
            a3.closeShop(false, false);
            return;
        }
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(PlayerShopPacket.getMiniGame(mapleClient, a3));
    }

    public /* synthetic */ String getData(MapleCharacter a2) {
        MapleQuestStatus mapleQuestStatus;
        MapleMiniGame a3;
        MapleQuest mapleQuest = MapleQuest.getInstance(a3.e == 1 ? 122200 : 122210);
        if (a2.getQuestNoAdd(mapleQuest) == null) {
            MapleQuestStatus mapleQuestStatus2;
            mapleQuestStatus = mapleQuestStatus2 = a2.getQuestNAdd(mapleQuest);
            mapleQuestStatus2.setCustomData(MapleFamily.ALLATORIxDEMO("pBpBp"));
        } else {
            MapleQuestStatus mapleQuestStatus3 = a2.getQuestNoAdd(mapleQuest);
            if (mapleQuestStatus3.getCustomData() == null || mapleQuestStatus3.getCustomData().length() < 5 || mapleQuestStatus3.getCustomData().indexOf(BuddyListHandler.ALLATORIxDEMO("\u0016")) == -1) {
                mapleQuestStatus3.setCustomData(MapleFamily.ALLATORIxDEMO("pBpBp"));
            }
            mapleQuestStatus = mapleQuestStatus3;
        }
        return mapleQuestStatus.getCustomData();
    }

    public /* synthetic */ void nextLoser() {
        MapleMiniGame a2;
        MapleMiniGame mapleMiniGame = a2;
        ++mapleMiniGame.B;
        if (mapleMiniGame.B > 1) {
            a2.B = 0;
        }
    }

    @Override
    public /* synthetic */ void closeShop(boolean a2, boolean a3, boolean a4) {
        MapleMiniGame a5;
        a5.closeShop(a2, a3);
    }

    @Override
    public final /* synthetic */ void setCanShop(boolean a2) {
        a.canShop = a2;
    }

    public /* synthetic */ void setTurn(int a2) {
        a.k = a2;
    }

    @Override
    public /* synthetic */ byte getShopType() {
        MapleMiniGame a2;
        if (a2.e == 1) {
            return 3;
        }
        return 4;
    }

    public /* synthetic */ void checkWin() {
        MapleMiniGame a2;
        if (a2.getPoints() >= a2.getMatchesToWin() && !a2.isOpen()) {
            int n2;
            int n3;
            int n4;
            int n5 = 0;
            int n6 = 0;
            boolean bl = false;
            boolean bl2 = false;
            int n7 = n4 = 0;
            while (n7 < 2) {
                MapleMiniGame mapleMiniGame;
                if (a2.H[n4] > n6) {
                    n5 = n4;
                    MapleMiniGame mapleMiniGame2 = a2;
                    mapleMiniGame = mapleMiniGame2;
                    n6 = mapleMiniGame2.H[n4];
                    bl = false;
                    bl2 = false;
                } else {
                    if (a2.H[n4] == n6) {
                        bl = true;
                        bl2 = true;
                    }
                    mapleMiniGame = a2;
                }
                mapleMiniGame.H[n4++] = 0;
                n7 = n4;
            }
            MapleMiniGame mapleMiniGame = a2;
            if (bl) {
                n3 = 1;
                n2 = n5;
            } else {
                n3 = 2;
                n2 = n5;
            }
            mapleMiniGame.broadcastToVisitors(PlayerShopPacket.getMiniGameResult(mapleMiniGame, n3, n2));
            MapleMiniGame mapleMiniGame3 = a2;
            mapleMiniGame3.setOpen(true);
            mapleMiniGame3.update();
            mapleMiniGame3.checkExitAfterGame();
        }
    }

    public /* synthetic */ int getCardId(int a2) {
        MapleMiniGame a3;
        return a3.g.get(a2 - 1);
    }

    public /* synthetic */ MapleMiniGame(MapleCharacter a2, int a3, String a4, String a5, int a6) {
        MapleMiniGame a7;
        MapleMiniGame mapleMiniGame = a7;
        super(a2, a3, a4, a5, 1);
        a7.M = -1;
        mapleMiniGame.e = 0;
        mapleMiniGame.E = new int[15][15];
        MapleMiniGame mapleMiniGame2 = a7;
        MapleMiniGame mapleMiniGame3 = a7;
        MapleMiniGame mapleMiniGame4 = a7;
        MapleMiniGame mapleMiniGame5 = a7;
        MapleMiniGame mapleMiniGame6 = a7;
        MapleMiniGame mapleMiniGame7 = a7;
        mapleMiniGame6.g = new ArrayList<Integer>();
        mapleMiniGame6.B = 0;
        mapleMiniGame5.k = 1;
        mapleMiniGame5.K = 0;
        mapleMiniGame4.a = 0;
        mapleMiniGame4.d = -1;
        mapleMiniGame3.ALLATORIxDEMO = -1;
        mapleMiniGame3.canShop = true;
        mapleMiniGame2.e = a6;
        mapleMiniGame2.H = new int[2];
        a7.F = new boolean[2];
        a7.C = new boolean[2];
        a7.reset();
    }

    public /* synthetic */ int getRequestedREDO() {
        MapleMiniGame a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ int getPieceType() {
        MapleMiniGame a2;
        return a2.K;
    }

    public /* synthetic */ int getRequestedTie() {
        MapleMiniGame a2;
        return a2.d;
    }

    public /* synthetic */ int getLosses(MapleCharacter a2) {
        MapleMiniGame a3;
        return Integer.parseInt(a3.getData(a2).split(BuddyListHandler.ALLATORIxDEMO("\u0016"))[0]);
    }

    public /* synthetic */ void reset() {
        int n2;
        int n3 = n2 = 0;
        while (n3 < 2) {
            MapleMiniGame a2;
            MapleMiniGame mapleMiniGame = a2;
            mapleMiniGame.H[n2] = 0;
            mapleMiniGame.F[n2] = false;
            mapleMiniGame.C[n2++] = false;
            n3 = n2;
        }
    }

    public /* synthetic */ void setPiece(int a2, int a3, int a4, MapleCharacter a5) {
        MapleMiniGame a6;
        if (a6.M != a5.getId()) {
            a6.M = a5.getId();
            if (a6.E[a2][a3] == 0 && !a6.isOpen()) {
                MapleMiniGame mapleMiniGame = a6;
                mapleMiniGame.E[a2][a3] = a4;
                mapleMiniGame.broadcastToVisitors(PlayerShopPacket.getMiniGameMoveOmok(a2, a3, a4));
                a2 = 0;
                int n2 = a3 = 0;
                while (n2 < 15) {
                    int n3;
                    int n4 = n3 = 0;
                    while (n4 < 15) {
                        if (a2 == 0 && a6.searchCombo(n3, a3, a4)) {
                            MapleMiniGame mapleMiniGame2 = a6;
                            MapleMiniGame mapleMiniGame3 = a6;
                            MapleMiniGame mapleMiniGame4 = a6;
                            mapleMiniGame3.broadcastToVisitors(PlayerShopPacket.getMiniGameResult(mapleMiniGame4, 2, mapleMiniGame4.getVisitorSlot(a5)));
                            mapleMiniGame2.setOpen(1 != 0);
                            mapleMiniGame3.update();
                            mapleMiniGame2.checkExitAfterGame();
                            a2 = 1;
                        }
                        n4 = ++n3;
                    }
                    n2 = ++a3;
                }
                a6.nextLoser();
            }
        }
    }

    public /* synthetic */ int getTurn() {
        MapleMiniGame a2;
        return a2.k;
    }

    public /* synthetic */ void setGameType() {
        MapleMiniGame a2;
        if (a2.e == 2) {
            int n2;
            a2.g.clear();
            int n3 = n2 = 0;
            while (n3 < a2.getMatchesToWin()) {
                a2.g.add(n2);
                a2.g.add(n2++);
                n3 = n2;
            }
        }
    }

    public /* synthetic */ boolean searchCombo(int a2, int a3, int a4) {
        boolean bl;
        MapleMiniGame a5;
        int n2;
        boolean bl2;
        block14: {
            boolean bl3;
            block13: {
                boolean bl4;
                block12: {
                    bl2 = false;
                    if (!false && a2 < 11) {
                        bl2 = true;
                        int n3 = n2 = 0;
                        while (n3 < 5) {
                            if (a5.E[a2 + n2][a3] != a4) {
                                bl4 = bl2 = false;
                                break block12;
                            }
                            n3 = ++n2;
                        }
                    }
                    bl4 = bl2;
                }
                if (!bl4 && a3 < 11) {
                    bl2 = true;
                    int n4 = n2 = 0;
                    while (n4 < 5) {
                        if (a5.E[a2][a3 + n2] != a4) {
                            bl3 = bl2 = false;
                            break block13;
                        }
                        n4 = ++n2;
                    }
                }
                bl3 = bl2;
            }
            if (!bl3 && a2 < 11 && a3 < 11) {
                bl2 = true;
                int n5 = n2 = 0;
                while (n5 < 5) {
                    if (a5.E[a2 + n2][a3 + n2] != a4) {
                        bl = bl2 = false;
                        break block14;
                    }
                    n5 = ++n2;
                }
            }
            bl = bl2;
        }
        if (!bl && a2 > 3 && a3 < 11) {
            bl2 = true;
            int n6 = n2 = 0;
            while (n6 < 5) {
                if (a5.E[a2 - n2][a3 + n2] != a4) {
                    bl2 = false;
                    return false;
                }
                n6 = ++n2;
            }
        }
        return bl2;
    }

    public /* synthetic */ void setPoints(int a2) {
        MapleMiniGame a3;
        MapleMiniGame mapleMiniGame = a3;
        int n2 = a2;
        mapleMiniGame.H[n2] = mapleMiniGame.H[n2] + 1;
        mapleMiniGame.checkWin();
    }

    public /* synthetic */ int getTies(MapleCharacter a2) {
        MapleMiniGame a3;
        return Integer.parseInt(a3.getData(a2).split(MapleFamily.ALLATORIxDEMO("l"))[1]);
    }

    public /* synthetic */ void setLoser(int a2) {
        a.B = a2;
    }

    public /* synthetic */ int getFirstSlot() {
        MapleMiniGame a2;
        return a2.a;
    }

    public /* synthetic */ int getLoser() {
        MapleMiniGame a2;
        return a2.B;
    }

    public /* synthetic */ int getOwnerPoints(int a2) {
        MapleMiniGame a3;
        return a3.H[a2];
    }

    public /* synthetic */ void setReady(int a2) {
        MapleMiniGame a3;
        MapleMiniGame mapleMiniGame = a3;
        int n2 = a2;
        mapleMiniGame.C[n2] = !mapleMiniGame.C[n2];
    }

    public /* synthetic */ void exit(MapleCharacter a2) {
        MapleMiniGame a3;
        if (a2 == null) {
            return;
        }
        a2.setPlayerShop(null);
        if (a3.isOwner(a2)) {
            MapleMiniGame mapleMiniGame = a3;
            mapleMiniGame.update();
            mapleMiniGame.removeAllVisitors(3, 1);
            return;
        }
        a3.removeVisitor(a2);
    }

    public /* synthetic */ boolean isExitAfter(MapleCharacter a2) {
        MapleMiniGame a3;
        if (a3.getVisitorSlot(a2) > -1) {
            return a3.F[a3.getVisitorSlot(a2)];
        }
        return false;
    }

    public /* synthetic */ int getMatchesToWin() {
        MapleMiniGame a2;
        if (a2.getPieceType() == 0) {
            return 6;
        }
        if (a2.getPieceType() == 1) {
            return 10;
        }
        return 15;
    }

    public /* synthetic */ int getWins(MapleCharacter a2) {
        MapleMiniGame a3;
        return Integer.parseInt(a3.getData(a2).split(BuddyListHandler.ALLATORIxDEMO("\u0016"))[2]);
    }

    public /* synthetic */ boolean isReady(int a2) {
        MapleMiniGame a3;
        return a3.C[a2];
    }
}

