/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.MapleCharacter;
import client.inventory.IEquip;
import client.inventory.IItem;
import client.inventory.Item;
import client.inventory.MapleAndroid;
import client.inventory.SocketFlag;
import client.messages.ConsoleCommandObject;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ItemConstants;
import handling.channel.handler.BBSHandler;
import java.io.Serializable;
import server.Randomizer;
import tools.FileoutputUtil;

public class Equip
extends Item
implements IEquip,
Serializable {
    private /* synthetic */ short b;
    private /* synthetic */ byte v;
    private /* synthetic */ short o;
    private /* synthetic */ int g;
    private /* synthetic */ int F;
    private /* synthetic */ short i;
    private /* synthetic */ short P;
    private /* synthetic */ short D;
    private /* synthetic */ int e;
    private /* synthetic */ short l;
    private /* synthetic */ short j;
    private /* synthetic */ byte n;
    private /* synthetic */ short Q;
    private /* synthetic */ short L;
    private /* synthetic */ short A;
    private /* synthetic */ short R;
    private /* synthetic */ short N;
    private /* synthetic */ short Z;
    private /* synthetic */ byte s;
    private /* synthetic */ MapleAndroid ALLATORIxDEMO;
    private /* synthetic */ short r;
    private /* synthetic */ byte T;
    private /* synthetic */ int E;
    private /* synthetic */ short h;
    private /* synthetic */ short t;
    private /* synthetic */ byte O;
    private /* synthetic */ short f;
    private /* synthetic */ short m;
    private /* synthetic */ int a;
    private /* synthetic */ int B;
    private /* synthetic */ int H;
    private /* synthetic */ int J;
    private /* synthetic */ int K;
    private /* synthetic */ int k;
    private /* synthetic */ short S;
    private /* synthetic */ short c;
    private /* synthetic */ int C;
    private /* synthetic */ int I;
    private /* synthetic */ int d;
    private /* synthetic */ int M;
    private /* synthetic */ short w;
    private /* synthetic */ short G;

    public /* synthetic */ short getSoulPotential() {
        Equip a2;
        return a2.i;
    }

    public /* synthetic */ void setHp(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.Q = a2;
    }

    public /* synthetic */ void renewPotential(boolean a2) {
        Equip a3;
        int n2 = Randomizer.nextInt(100) < 4 && a3.getState() != 7 ? -(a3.getState() + 1) : -a3.getState();
        Equip equip = a3;
        equip.setPotential1((short)n2);
        equip.setPotential2((short)(equip.getPotential3() > 0 || a2 && Randomizer.nextInt(10) == 0 ? n2 : 0));
        a3.setPotential3(0);
    }

    public /* synthetic */ void setMdef(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.w = a2;
    }

    @Override
    public /* synthetic */ byte getUpgradeSlots() {
        Equip a2;
        return a2.O;
    }

    @Override
    public /* synthetic */ int getEquipExpForLevel() {
        int n2;
        int n3;
        Equip a2;
        if (a2.getEquipExp() <= 0) {
            return 0;
        }
        int n4 = n3 = a2.getBaseLevel();
        for (n2 = (v126650).getEquipExp(); n4 <= ItemConstants.getMaxLevel(a2.getItemId()) && n2 >= ItemConstants.getExpForLevel(n3, a2.getItemId()); n2 -= ItemConstants.getExpForLevel(n3++, a2.getItemId())) {
            n4 = n3;
        }
        return n2;
    }

    @Override
    public /* synthetic */ short getAcc() {
        Equip a2;
        return a2.G;
    }

    @Override
    public /* synthetic */ int getPotential3() {
        Equip a2;
        return a2.H;
    }

    public /* synthetic */ void setWatk(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.Z = a2;
    }

    public /* synthetic */ void resetPotential_Fuse(boolean a2, int a3) {
        Equip a4;
        a3 = -a3;
        if (Randomizer.nextInt(100) < 4) {
            a3 -= Randomizer.nextInt(100) < 4 ? (Randomizer.nextInt(100) < 4 ? 3 : 2) : 1;
        }
        a4.setPotential1((short)a3);
        a4.setPotential2((short)(Randomizer.nextInt(a2 ? 5 : 10) == 0 ? a3 : 0));
        a4.setPotential3(0);
    }

    @Override
    public /* synthetic */ short getMdef() {
        Equip a2;
        return a2.w;
    }

    @Override
    public /* synthetic */ byte getStateAdd() {
        Equip a2;
        Equip equip = a2;
        int n2 = equip.e + equip.E;
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            if (a2.e >= 60000 || a2.E >= 60000) {
                return 20;
            }
            if (a2.e >= 40000 || a2.E >= 40000) {
                return 20;
            }
            if (a2.e >= 30000 || a2.E >= 30000) {
                return 19;
            }
            if (a2.e >= 20000 || a2.E >= 20000) {
                return 18;
            }
            if (n2 >= 1) {
                return 17;
            }
            if (n2 < 0) {
                return 1;
            }
        } else {
            if (a2.F >= 40000 || a2.C >= 40000 || a2.H >= 40000 || a2.e >= 40000 || a2.E >= 40000) {
                return 8;
            }
            if (a2.F >= 30000 || a2.C >= 30000 || a2.H >= 30000 || a2.e >= 30000 || a2.E >= 30000) {
                return 7;
            }
            if (a2.F >= 20000 || a2.C >= 20000 || a2.H >= 20000 || a2.e >= 20000 || a2.E >= 20000) {
                return 6;
            }
            if (n2 >= 1) {
                return 5;
            }
            if (n2 < 0) {
                return 1;
            }
        }
        return 0;
    }

    public /* synthetic */ void renewPotential_super() {
        Equip a2;
        int n2 = Randomizer.nextInt(100) < 8 && a2.getState() != 8 ? -(a2.getState() + 1) : -a2.getState();
        Equip equip = a2;
        equip.setPotential1(n2);
        equip.setPotential2(equip.getPotential3() > 0 ? n2 : 0);
        a2.setPotential3(0);
    }

    public /* synthetic */ void setMpR(short a2) {
        a.f = a2;
    }

    public /* synthetic */ short getSocketState() {
        Equip a2;
        int n2 = 0;
        if (a2.B > 0 || a2.k > 0 || a2.K > 0) {
            n2 |= SocketFlag.DEFAULT.getValue();
        }
        if (a2.B > 0) {
            n2 |= SocketFlag.SOCKET_BOX_1.getValue();
        }
        if (a2.k > 0) {
            n2 |= SocketFlag.SOCKET_BOX_2.getValue();
        }
        if (a2.K > 0) {
            n2 |= SocketFlag.SOCKET_BOX_3.getValue();
        }
        if (a2.B > 1) {
            n2 |= SocketFlag.USED_SOCKET_1.getValue();
        }
        if (a2.k > 1) {
            n2 |= SocketFlag.USED_SOCKET_2.getValue();
        }
        if (a2.K > 1) {
            n2 |= SocketFlag.USED_SOCKET_3.getValue();
        }
        return (short)n2;
    }

    @Override
    public /* synthetic */ short getMatk() {
        Equip a2;
        return a2.t;
    }

    @Override
    public /* synthetic */ void setPotential3(int a2) {
        a.H = a2;
    }

    @Override
    public /* synthetic */ short getHands() {
        Equip a2;
        return a2.c;
    }

    public /* synthetic */ void renewPotential1(boolean a2) {
        Equip a3;
        int n2;
        int n3 = n2 = Randomizer.nextInt(100) < 2 && a3.getState() != 7 ? -(a3.getState() + 1) : -a3.getState();
        if (n2 == -8) {
            n2 = -7;
        }
        Equip equip = a3;
        equip.setPotential1((short)n2);
        equip.setPotential2((short)(equip.getPotential3() > 0 || a2 && Randomizer.nextInt(10) == 0 ? n2 : 0));
        a3.setPotential3(0);
    }

    public /* synthetic */ void setCharmEXP(short a2) {
        a.D = a2;
    }

    @Override
    public /* synthetic */ int getPotential1() {
        Equip a2;
        return a2.F;
    }

    public /* synthetic */ void setSoulName(short a2) {
        a.L = a2;
    }

    public /* synthetic */ void setAndroid(MapleAndroid a2) {
        a.ALLATORIxDEMO = a2;
    }

    @Override
    public /* synthetic */ void setPotential4(int a2) {
        a.e = a2;
    }

    public /* synthetic */ void setWdef(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.P = a2;
    }

    public /* synthetic */ void setNoStat() {
        Equip a2;
        Equip equip = a2;
        Equip equip2 = a2;
        Equip equip3 = a2;
        Equip equip4 = a2;
        Equip equip5 = a2;
        Equip equip6 = a2;
        Equip equip7 = a2;
        a2.R = 0;
        equip7.N = 0;
        equip7.S = 0;
        equip6.r = 0;
        equip6.Q = 0;
        equip5.o = 0;
        equip5.Z = 0;
        equip4.t = 0;
        equip4.P = 0;
        equip3.w = 0;
        equip3.G = 0;
        equip2.b = 0;
        equip2.c = 0;
        equip.l = 0;
        equip.m = 0;
    }

    @Override
    public /* synthetic */ short getStr() {
        Equip a2;
        return a2.R;
    }

    @Override
    public /* synthetic */ int getBaseLevel() {
        Equip a2;
        if (ItemConstants.getStatFromWeapon(a2.getItemId()) == null) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ void setReqLevel(byte a2) {
        a.T = a2;
    }

    public /* synthetic */ void resetPotentialA() {
        Equip a2;
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            Equip equip = a2;
            equip.setPotential1(-18);
            equip.setPotential2(Randomizer.nextInt(1000) <= 100 ? -18 : 0);
            a2.setPotential3(0);
            return;
        }
        int n2 = -6;
        Equip equip = a2;
        equip.setPotential1(-6);
        equip.setPotential2(Randomizer.nextInt(10) <= 1 ? -6 : 0);
        a2.setPotential3(0);
    }

    @Override
    public /* synthetic */ int getEquipLevel() {
        Equip a2;
        if (ItemConstants.getMaxLevel(a2.getItemId()) <= 0) {
            return 0;
        }
        if (a2.getEquipExp() <= 0) {
            return a2.getBaseLevel();
        }
        Equip equip = a2;
        Equip equip2 = equip;
        int n2 = equip.getBaseLevel();
        int n3 = equip.getEquipExp();
        int n4 = n2;
        while (true) {
            int n5;
            if (ItemConstants.getStatFromWeapon(equip2.getItemId()) == null) {
                if (n4 > ItemConstants.getMaxLevel(a2.getItemId())) break;
                n5 = n3;
            } else {
                if (n4 >= ItemConstants.getMaxLevel(a2.getItemId())) break;
                n5 = n3;
            }
            if (n5 < ItemConstants.getExpForLevel(n4, a2.getItemId())) break;
            ++n2;
            n3 -= ItemConstants.getExpForLevel(n4++, a2.getItemId());
            equip2 = a2;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void renewPotential(int a2, int a3, int a4, MapleCharacter a5) {
        int n2;
        int n3;
        int n4;
        Equip a6;
        block32: {
            block27: {
                int n5;
                block31: {
                    block30: {
                        block28: {
                            block29: {
                                n4 = -a6.getState();
                                if (a2 == 2) {
                                    n4 = -18;
                                }
                                if (a4 == 5062500) {
                                    if (a6.getPotential4() > 0) {
                                        a6.setPotential4(n4);
                                    }
                                    if (a6.getPotential5() > 0) {
                                        a6.setPotential5(n4);
                                    }
                                    return;
                                }
                                if (a2 != 3) break block27;
                                if (a4 != 5062002) break block28;
                                if (!GameSetConstants.SERVER_NAME.equals(ConsoleCommandObject.ALLATORIxDEMO("\u5913\u4f63\u8c0d"))) break block29;
                                n3 = 15000;
                                switch (a5.getVip()) {
                                    case 0: {
                                        n3 = 15000;
                                        break;
                                    }
                                    case 1: {
                                        n3 = 8000;
                                        break;
                                    }
                                    case 2: {
                                        n3 = 5000;
                                        break;
                                    }
                                    case 3: {
                                        n3 = 3000;
                                        break;
                                    }
                                    case 4: {
                                        n3 = 500;
                                        break;
                                    }
                                }
                                if (Randomizer.rand(1, n3) == 1 && a6.getState() != 20) {
                                    n4 = -(a6.getState() + 1);
                                }
                                break block30;
                            }
                            if (Randomizer.nextInt(10000) >= GameSetConstants.LEGEND_CHANCE || a6.getState() == 20) break block30;
                            n4 = -(a6.getState() + 1);
                            n5 = a4;
                            break block31;
                        }
                        if (Randomizer.nextInt(20000) < GameSetConstants.SUPRISE_CHANCE && a6.getState() != 20) {
                            n4 = -(a6.getState() + 1);
                        }
                    }
                    n5 = a4;
                }
                if (n5 == 5062005) {
                    if (n4 == -20) {
                        n4 = -21;
                    }
                } else if (n4 == -21) {
                    n4 = -20;
                }
                break block32;
            }
            if (Randomizer.nextInt(20000) < GameSetConstants.NORMAL_CHANCE && a6.getState() != 19) {
                n4 = -(a6.getState() + 1);
            }
        }
        n3 = 10;
        a4 = 100;
        if (a3 == 5066000) {
            n3 = 5;
            a4 = 50;
        }
        Equip equip = a6;
        equip.setPotential1(n4);
        if (equip.getPotential3() > 0) {
            n2 = a2;
            a6.setPotential2(n4);
        } else {
            switch (a2) {
                case 1: {
                    a6.setPotential2(Randomizer.nextInt(10) == 0 ? n4 : 0);
                    n2 = a2;
                    break;
                }
                case 2: {
                    Equip equip2 = a6;
                    int n6 = n4;
                    equip2.setPotential2(n6);
                    equip2.setPotential3(n6);
                    return;
                }
                case 3: {
                    a6.setPotential2(Randomizer.nextInt(n3) <= 2 ? n4 : 0);
                    n2 = a2;
                    break;
                }
                default: {
                    a6.setPotential2(0);
                    n2 = a2;
                }
            }
        }
        if (n2 != 3) {
            a6.setPotential3(0);
            return;
        }
        a6.setPotential3(Randomizer.nextInt(a4) <= 2 ? n4 : 0);
    }

    public /* synthetic */ void setSoulEnchanter(short a2) {
        a.j = a2;
    }

    public /* synthetic */ void setItemEXP(int a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.J = a2;
    }

    @Override
    public /* synthetic */ short getHp() {
        Equip a2;
        return a2.Q;
    }

    public /* synthetic */ void setPVPDamage(short a2) {
        a.h = a2;
    }

    public /* synthetic */ void resetPotential() {
        Equip a2;
        int n2 = Randomizer.nextInt(100) < 4 ? (Randomizer.nextInt(100) < 4 ? -7 : -6) : -5;
        Equip equip = a2;
        equip.setPotential1((short)n2);
        equip.setPotential2((short)(Randomizer.nextInt(10) == 1 ? n2 : 0));
        a2.setPotential3(0);
    }

    @Override
    public /* synthetic */ void setPotential1(int a2) {
        a.F = a2;
    }

    @Override
    public /* synthetic */ short getAvoid() {
        Equip a2;
        return a2.b;
    }

    public /* synthetic */ void setSoulPotential(short a2) {
        a.i = a2;
    }

    @Override
    public /* synthetic */ byte getReqLevel() {
        Equip a2;
        return a2.T;
    }

    public /* synthetic */ void setMatk(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.t = a2;
    }

    @Override
    public /* synthetic */ int getPotential4() {
        Equip a2;
        return a2.e;
    }

    @Override
    public /* synthetic */ int getEquipExp() {
        Equip a2;
        if (a2.J <= 0) {
            return 0;
        }
        if (GameConstants.isWeapon(a2.getItemId())) {
            return a2.J / 700000;
        }
        return a2.J / 350000;
    }

    public /* synthetic */ void setAcc(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.G = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ int getSocket(int a2) {
        switch (a2) {
            case 1: {
                Equip a3;
                return a3.B;
            }
            case 2: {
                Equip a3;
                return a3.k;
            }
            case 3: {
                Equip a3;
                return a3.K;
            }
        }
        return 0;
    }

    @Override
    public /* synthetic */ short getSpeed() {
        Equip a2;
        return a2.l;
    }

    @Override
    public /* synthetic */ int getPotential6() {
        Equip a2;
        return a2.g;
    }

    @Override
    public /* synthetic */ void setPotential5(int a2) {
        a.E = a2;
    }

    @Override
    public /* synthetic */ short getWdef() {
        Equip a2;
        return a2.P;
    }

    @Override
    public /* synthetic */ short getDex() {
        Equip a2;
        return a2.N;
    }

    @Override
    public /* synthetic */ int getExpPercentage() {
        Equip a2;
        if (a2.getEquipLevel() < a2.getBaseLevel() || a2.getEquipLevel() > ItemConstants.getMaxLevel(a2.getItemId()) || ItemConstants.getExpForLevel(a2.getEquipLevel(), a2.getItemId()) <= 0) {
            return 0;
        }
        return a2.getEquipExpForLevel() * 100 / ItemConstants.getExpForLevel(a2.getEquipLevel(), a2.getItemId());
    }

    public /* synthetic */ short getSoulName() {
        Equip a2;
        return a2.L;
    }

    @Override
    public /* synthetic */ int getPotential2() {
        Equip a2;
        return a2.C;
    }

    public /* synthetic */ void setEnhance(byte a2) {
        a.v = a2;
    }

    @Override
    public /* synthetic */ byte getLevel() {
        Equip a2;
        return a2.s;
    }

    public /* synthetic */ int getSoulSkill() {
        Equip a2;
        return a2.d;
    }

    public /* synthetic */ void setDex(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.N = a2;
    }

    public /* synthetic */ void setFusionAnvil(int a2) {
        a.a = a2;
    }

    @Override
    public /* synthetic */ short getMpR() {
        Equip a2;
        return a2.f;
    }

    public /* synthetic */ void setHpR(short a2) {
        a.A = a2;
    }

    public /* synthetic */ void setSpeed(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.l = a2;
    }

    @Override
    public /* synthetic */ short getInt() {
        Equip a2;
        return a2.S;
    }

    @Override
    public /* synthetic */ MapleAndroid getAndroid() {
        Equip a2;
        if (a2.getItemId() / 10000 != 166 || a2.getUniqueId() <= 0) {
            return null;
        }
        if (a2.ALLATORIxDEMO == null) {
            a2.ALLATORIxDEMO = MapleAndroid.loadFromDb(a2.getItemId(), a2.getUniqueId());
        }
        return a2.ALLATORIxDEMO;
    }

    @Override
    public /* synthetic */ short getMp() {
        Equip a2;
        return a2.o;
    }

    @Override
    public /* synthetic */ short getCharmEXP() {
        Equip a2;
        return a2.D;
    }

    public /* synthetic */ Equip(int a2, short a3, int a4) {
        Equip a5;
        Equip equip = a5;
        Equip equip2 = a5;
        Equip equip3 = a5;
        Equip equip4 = a5;
        Equip equip5 = a5;
        Equip equip6 = a5;
        Equip equip7 = a5;
        Equip equip8 = a5;
        Equip equip9 = a5;
        Equip equip10 = a5;
        Equip equip11 = a5;
        Equip equip12 = a5;
        Equip equip13 = a5;
        Equip equip14 = a5;
        Equip equip15 = a5;
        Equip equip16 = a5;
        Equip equip17 = a5;
        Equip equip18 = a5;
        Equip equip19 = a5;
        Equip equip20 = a5;
        Equip equip21 = a5;
        super(a2, a3, (short)1, a4);
        equip21.O = 0;
        equip21.s = 0;
        equip20.n = 0;
        equip20.v = 0;
        equip19.T = 0;
        equip19.R = 0;
        equip18.N = 0;
        equip18.S = 0;
        equip17.r = 0;
        equip17.Q = 0;
        equip16.o = 0;
        equip16.Z = 0;
        equip15.t = 0;
        equip15.P = 0;
        equip14.w = 0;
        equip14.G = 0;
        equip13.b = 0;
        equip13.c = 0;
        equip12.l = 0;
        equip12.m = 0;
        equip11.A = 0;
        equip11.f = 0;
        equip10.h = 0;
        equip10.D = 0;
        equip9.L = 0;
        equip9.j = 0;
        equip8.i = 0;
        equip8.J = 0;
        equip7.M = -1;
        equip7.I = -1;
        equip6.F = 0;
        equip6.C = 0;
        equip5.H = 0;
        equip5.e = 0;
        equip4.E = 0;
        equip4.g = 0;
        equip3.B = 0;
        equip3.k = 0;
        equip2.K = 0;
        equip2.a = 0;
        equip.d = 0;
        equip.ALLATORIxDEMO = null;
    }

    @Override
    public /* synthetic */ short getLuk() {
        Equip a2;
        return a2.r;
    }

    @Override
    public /* synthetic */ byte getEnhance() {
        Equip a2;
        return a2.v;
    }

    @Override
    public /* synthetic */ void setQuantity(short a2) {
        Equip a3;
        if (a2 < 0 || a2 > 1) {
            throw new RuntimeException("Setting the quantity to " + a2 + " on an equip (itemid: " + a3.getItemId() + ")");
        }
        super.setQuantity(a2);
    }

    public /* synthetic */ void setStr(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.R = a2;
    }

    public /* synthetic */ Equip(int a2, short a3, int a4, int a5) {
        Equip a6;
        Equip equip = a6;
        Equip equip2 = a6;
        Equip equip3 = a6;
        Equip equip4 = a6;
        Equip equip5 = a6;
        Equip equip6 = a6;
        Equip equip7 = a6;
        Equip equip8 = a6;
        Equip equip9 = a6;
        Equip equip10 = a6;
        Equip equip11 = a6;
        Equip equip12 = a6;
        Equip equip13 = a6;
        Equip equip14 = a6;
        Equip equip15 = a6;
        Equip equip16 = a6;
        Equip equip17 = a6;
        Equip equip18 = a6;
        Equip equip19 = a6;
        Equip equip20 = a6;
        Equip equip21 = a6;
        super(a2, a3, (short)1, a5, a4);
        equip21.O = 0;
        equip21.s = 0;
        equip20.n = 0;
        equip20.v = 0;
        equip19.T = 0;
        equip19.R = 0;
        equip18.N = 0;
        equip18.S = 0;
        equip17.r = 0;
        equip17.Q = 0;
        equip16.o = 0;
        equip16.Z = 0;
        equip15.t = 0;
        equip15.P = 0;
        equip14.w = 0;
        equip14.G = 0;
        equip13.b = 0;
        equip13.c = 0;
        equip12.l = 0;
        equip12.m = 0;
        equip11.A = 0;
        equip11.f = 0;
        equip10.h = 0;
        equip10.D = 0;
        equip9.L = 0;
        equip9.j = 0;
        equip8.i = 0;
        equip8.J = 0;
        equip7.M = -1;
        equip7.I = -1;
        equip6.F = 0;
        equip6.C = 0;
        equip5.H = 0;
        equip5.e = 0;
        equip4.E = 0;
        equip4.g = 0;
        equip3.B = 0;
        equip3.k = 0;
        equip2.K = 0;
        equip2.a = 0;
        equip.d = 0;
        equip.ALLATORIxDEMO = null;
    }

    @Override
    public /* synthetic */ void setPotential2(int a2) {
        a.C = a2;
    }

    @Override
    public /* synthetic */ byte getViciousHammer() {
        Equip a2;
        return a2.n;
    }

    @Override
    public /* synthetic */ IItem copy() {
        Equip a2;
        Equip equip;
        Equip equip2 = equip = new Equip(a2.getItemId(), a2.getPosition(), a2.getUniqueId(), a2.getFlag());
        Equip equip3 = a2;
        Equip equip4 = equip;
        Equip equip5 = a2;
        Equip equip6 = a2;
        Equip equip7 = equip;
        Equip equip8 = a2;
        Equip equip9 = equip;
        Equip equip10 = a2;
        Equip equip11 = equip;
        Equip equip12 = a2;
        Equip equip13 = equip;
        Equip equip14 = a2;
        Equip equip15 = equip;
        Equip equip16 = a2;
        Equip equip17 = equip;
        Equip equip18 = a2;
        Equip equip19 = equip;
        Equip equip20 = a2;
        Equip equip21 = equip;
        Equip equip22 = a2;
        Equip equip23 = equip;
        Equip equip24 = a2;
        Equip equip25 = equip;
        equip25.R = a2.R;
        equip25.N = a2.N;
        equip.S = equip24.S;
        equip23.r = equip24.r;
        equip23.Q = a2.Q;
        equip.o = equip22.o;
        equip21.t = equip22.t;
        equip21.w = a2.w;
        equip.Z = equip20.Z;
        equip19.P = equip20.P;
        equip19.G = a2.G;
        equip.b = equip18.b;
        equip17.c = equip18.c;
        equip17.l = a2.l;
        equip.m = equip16.m;
        equip15.v = equip16.v;
        equip15.O = a2.O;
        equip.s = equip14.s;
        equip13.T = equip14.T;
        equip13.J = a2.J;
        equip.I = equip12.I;
        equip11.n = equip12.n;
        equip11.F = a2.F;
        equip.C = equip10.C;
        equip9.H = equip10.H;
        equip9.e = a2.e;
        equip.E = equip8.E;
        equip7.D = equip8.D;
        equip7.A = a2.A;
        equip.f = equip6.f;
        equip.L = equip6.L;
        equip.setGiftFrom(a2.getGiftFrom());
        equip.setOwner(equip5.getOwner());
        equip4.setQuantity(equip5.getQuantity());
        equip4.setExpiration(a2.getExpiration());
        equip.setEquipOnlyId(equip3.getEquipOnlyId());
        equip2.setInventoryitemId(equip3.getInventoryitemId());
        equip2.setCustomFlag(a2.getCustomFlag());
        return equip2;
    }

    public /* synthetic */ void setInt(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.S = a2;
    }

    public /* synthetic */ void setJump(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.m = a2;
    }

    public /* synthetic */ Item reset(Equip a2) {
        Equip a3;
        Equip equip = a3;
        Equip equip2 = a2;
        Equip equip3 = a3;
        Equip equip4 = a2;
        Equip equip5 = a3;
        Equip equip6 = a2;
        Equip equip7 = a3;
        Equip equip8 = a2;
        Equip equip9 = a3;
        Equip equip10 = a2;
        Equip equip11 = a3;
        Equip equip12 = a2;
        Equip equip13 = a3;
        Equip equip14 = a2;
        Equip equip15 = a3;
        Equip equip16 = a2;
        Equip equip17 = a3;
        equip17.R = a2.R;
        equip17.N = a2.N;
        a3.S = equip16.S;
        equip15.r = equip16.r;
        equip15.Q = a2.Q;
        a3.o = equip14.o;
        equip13.t = equip14.t;
        equip13.w = a2.w;
        a3.Z = equip12.Z;
        equip11.P = equip12.P;
        equip11.G = a2.G;
        a3.b = equip10.b;
        equip9.c = equip10.c;
        equip9.l = a2.l;
        a3.m = equip8.m;
        equip7.v = equip8.v;
        equip7.O = a2.O;
        a3.s = equip6.s;
        equip5.J = equip6.J;
        equip5.I = a2.I;
        a3.n = equip4.n;
        equip3.D = equip4.D;
        equip3.h = a2.h;
        a3.A = equip2.A;
        a3.f = equip2.f;
        equip.M = a2.M;
        equip.setGiftFrom(a3.getGiftFrom());
        return equip;
    }

    public /* synthetic */ void setAvoid(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.b = a2;
    }

    @Override
    public /* synthetic */ short getHpR() {
        Equip a2;
        return a2.A;
    }

    @Override
    public /* synthetic */ short getWatk() {
        Equip a2;
        return a2.Z;
    }

    public /* synthetic */ void setViciousHammer(byte a2) {
        a.n = a2;
    }

    public /* synthetic */ void renewPotential() {
        Equip a2;
        int n2 = Randomizer.nextInt(100) < 4 && a2.getState() != 7 ? -(a2.getState() + 1) : -a2.getState();
        Equip equip = a2;
        equip.setPotential1((short)n2);
        equip.setPotential2((short)(equip.getPotential3() > 0 ? n2 : 0));
        a2.setPotential3(0);
    }

    @Override
    public /* synthetic */ int getDurability() {
        Equip a2;
        return a2.I;
    }

    public /* synthetic */ void setUpgradeSlots(byte a2) {
        if (GameSetConstants.UPGRADESLOT_CHECK && (a2 > 22 || a2 < 0)) {
            Equip a3;
            System.out.println("\u885d\u6372\u6578\u76ee\u7570\u5e38,[\u7269\u54c1]" + a3.getItemName() + "[\u885d\u6372\u6578]" + a2);
            FileoutputUtil.logToFile(BBSHandler.ALLATORIxDEMO("OLDP\ff[@FSW\fPFWvSDQBGFpOLWP\rW[W"), "\u885d\u6372\u6578\u76ee\u7570\u5e38,[\u7269\u54c1]" + a3.getItemName() + "[\u885d\u6372\u6578]" + a2);
            a2 = 0;
        }
        a3.O = a2;
    }

    @Override
    public /* synthetic */ void setPotential6(int a2) {
        a.g = a2;
    }

    @Override
    public /* synthetic */ int getIncSkill() {
        Equip a2;
        return a2.M;
    }

    public /* synthetic */ void setSoulSkill(int a2) {
        a.d = a2;
    }

    public /* synthetic */ void setMp(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.o = a2;
    }

    public /* synthetic */ void setHands(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.c = a2;
    }

    public /* synthetic */ byte getAddState() {
        Equip a2;
        byte by = 0;
        if (a2.e >= 40000 || a2.E >= 40000) {
            by = 8;
            return 8;
        }
        if (a2.e >= 30000 || a2.E >= 30000) {
            by = 7;
            return 7;
        }
        if (a2.e >= 20000 || a2.E >= 20000) {
            by = 6;
            return 6;
        }
        if (a2.e >= 1 || a2.E >= 1) {
            by = 5;
            return 5;
        }
        if (a2.e < 0 || a2.E < 0) {
            by = (byte)(Math.abs(a2.e) - 16);
        }
        return by;
    }

    @Override
    public /* synthetic */ int getItemEXP() {
        Equip a2;
        return a2.J;
    }

    public /* synthetic */ short getSoulEnchanter() {
        Equip a2;
        return a2.j;
    }

    public /* synthetic */ void setLuk(short a2) {
        if (a2 < 0) {
            a2 = 0;
        }
        a.r = a2;
    }

    @Override
    public /* synthetic */ short getPVPDamage() {
        Equip a2;
        return a2.h;
    }

    public /* synthetic */ void setLevel(byte a2) {
        a.s = a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void setSocket(int a2, int a3) {
        switch (a3) {
            case 1: {
                a.B = a2;
                return;
            }
            case 2: {
                a.k = a2;
                return;
            }
            case 3: {
                a.K = a2;
                return;
            }
        }
    }

    public /* synthetic */ int getFusionAnvil() {
        Equip a2;
        return a2.a;
    }

    public /* synthetic */ void resetPotentialS() {
        Equip a2;
        if (GameSetConstants.MAPLE_VERSION >= 139) {
            Equip equip = a2;
            equip.setPotential1(-19);
            equip.setPotential2(Randomizer.nextInt(1000) <= 50 ? -19 : 0);
            a2.setPotential3(0);
            return;
        }
        int n2 = -7;
        Equip equip = a2;
        equip.setPotential1(-7);
        equip.setPotential2(Randomizer.nextInt(10) <= 1 ? -7 : 0);
        a2.setPotential3(0);
    }

    public /* synthetic */ boolean isclean() {
        Equip a2;
        return a2.R == 0 && a2.N == 0 && a2.S == 0 && a2.r == 0 && a2.Q == 0 && a2.o == 0 && a2.Z == 0 && a2.t == 0 && a2.P == 0 && a2.w == 0 && a2.G == 0 && a2.b == 0 && a2.c == 0 && a2.l == 0 && a2.m == 0;
    }

    public /* synthetic */ void setDurability(int a2) {
        a.I = a2;
    }

    @Override
    public /* synthetic */ short getJump() {
        Equip a2;
        return a2.m;
    }

    @Override
    public /* synthetic */ byte getState() {
        Equip a2;
        Equip equip = a2;
        int n2 = equip.F + equip.C + a2.H + a2.e + a2.E;
        if (GameSetConstants.MAPLE_VERSION >= 138) {
            if (a2.F >= 60000 || a2.C >= 60000 || a2.H >= 60000) {
                return 20;
            }
            if (a2.F >= 40000 || a2.C >= 40000 || a2.H >= 40000) {
                return 20;
            }
            if (a2.F >= 30000 || a2.C >= 30000 || a2.H >= 30000) {
                return 19;
            }
            if (a2.F >= 20000 || a2.C >= 20000 || a2.H >= 20000) {
                return 18;
            }
            if (n2 >= 1) {
                return 17;
            }
            if (n2 < 0) {
                return 1;
            }
        } else {
            if (a2.F >= 40000 || a2.C >= 40000 || a2.H >= 40000) {
                return 8;
            }
            if (a2.F >= 30000 || a2.C >= 30000 || a2.H >= 30000) {
                return 7;
            }
            if (a2.F >= 20000 || a2.C >= 20000 || a2.H >= 20000) {
                return 6;
            }
            if (n2 >= 1) {
                return 5;
            }
            if (n2 < 0) {
                return 1;
            }
        }
        return 0;
    }

    public /* synthetic */ void setIncSkill(int a2) {
        a.M = a2;
    }

    @Override
    public /* synthetic */ byte getType() {
        return 1;
    }

    @Override
    public /* synthetic */ int getPotential5() {
        Equip a2;
        return a2.E;
    }
}

