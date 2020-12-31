/*
 * Decompiled with CFR 0.150.
 */
package constants;

import constants.GameSetConstants;
import constants.JobConstants;

public class SpecialSkillConstants {
    private static /* synthetic */ int m(int a2) {
        int n2;
        if (a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 % 100 == 0 || a2 == 501) {
            return 1;
        }
        n2 = (a2 / 10 == 43 ? (n2 = (a2 - 430) / 2) : (n2 = a2 % 10)) + 2;
        if (n2 >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            int n3 = n2;
            return n3;
        }
        int n4 = 0;
        return 0;
    }

    private static /* synthetic */ boolean K(int a2) {
        return a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 == 2003;
    }

    private static /* synthetic */ boolean I(int a2) {
        return a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 == 2003 || a2 == 5000 || a2 == 2004 || a2 == 6000 || a2 == 6001;
    }

    private static /* synthetic */ int g(int a2) {
        boolean bl;
        if (a2 > 4120010) {
            boolean bl2;
            if (a2 > 21120011) {
                boolean bl3;
                if (a2 == 22181004 || a2 == 32120009) {
                    return 1;
                }
                bl2 = bl3 = a2 == 33120010;
            } else {
                boolean bl4;
                if (a2 == 21120011 || a2 == 4220009 || a2 == 4340010 || a2 == 5120011) {
                    return 1;
                }
                bl2 = bl4 = a2 == 5220012;
            }
            if (bl2) {
                return 1;
            }
            return 0;
        }
        if (a2 == 4120010) {
            return 1;
        }
        if (a2 > 2220009) {
            if (a2 != 2320010 && a2 <= 3120009 || a2 > 3120011 && (a2 <= 3220008 || a2 > 3220010)) {
                return 0;
            }
            return 1;
        }
        if (a2 == 2220009 || a2 == 1120012 || a2 == 1220013 || a2 == 1320011) {
            return 1;
        }
        boolean bl5 = bl = a2 == 2120009;
        if (bl) {
            return 1;
        }
        return 0;
    }

    private static /* synthetic */ int B(int a2) {
        boolean bl;
        if (a2 > 3220010) {
            boolean bl2;
            if (a2 == 4120010 || a2 == 4220009 || a2 == 5120011 || a2 == 5220012 || a2 == 32120009) {
                return 1;
            }
            boolean bl3 = bl2 = a2 == 33120010;
            if (bl2) {
                return 1;
            }
            return 0;
        }
        if (a2 >= 3220009) {
            return 1;
        }
        if (a2 > 2120009) {
            if (a2 != 2220009 && a2 != 2320010 && (a2 <= 3120009 || a2 > 3120011)) {
                return 0;
            }
            return 1;
        }
        if (a2 == 2120009 || a2 == 1120012 || a2 == 1220013) {
            return 1;
        }
        boolean bl4 = bl = a2 == 1320011;
        if (bl) {
            return 1;
        }
        return 0;
    }

    private static /* synthetic */ int h(int a2) {
        int n2;
        if (a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 == 2003 || a2 % 100 == 0 || a2 == 501 || a2 == 508 || a2 == 509) {
            return 1;
        }
        n2 = (SpecialSkillConstants.j(a2) ? (n2 = a2 % 10 / 2) : (n2 = a2 % 10)) + 2;
        if (n2 >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            int n3 = n2;
            return n3;
        }
        int n4 = 0;
        return 0;
    }

    private static /* synthetic */ int a(int a2) {
        boolean bl;
        if (a2 <= 4340010) {
            boolean bl2;
            if (a2 == 4340010) {
                return 1;
            }
            if (a2 > 2321010) {
                boolean bl3;
                if (a2 <= 3220012) {
                    if (a2 != 3220012 && (a2 > 3220010 || a2 < 3220009 && (a2 < 3120010 || a2 > 3120012))) {
                        return 0;
                    }
                    return 1;
                }
                if (a2 == 4120010) {
                    return 1;
                }
                bl2 = bl3 = a2 == 4220009;
            } else {
                if (a2 == 2321010) {
                    return 1;
                }
                if (a2 > 1320011) {
                    boolean bl4;
                    if (a2 == 2121009) {
                        return 1;
                    }
                    bl2 = bl4 = a2 == 2221009;
                } else {
                    boolean bl5;
                    if (a2 == 1320011 || a2 == 1120012) {
                        return 1;
                    }
                    bl2 = bl5 = a2 == 1220013;
                }
            }
            if (!bl2) {
                return 0;
            }
            return 1;
        }
        if (a2 > 21120011) {
            boolean bl6;
            if (a2 > 23121008) {
                boolean bl7;
                if (a2 == 32120009) {
                    return 1;
                }
                bl6 = bl7 = a2 == 33120010;
            } else {
                boolean bl8;
                if (a2 == 23121008 || a2 == 22181004) {
                    return 1;
                }
                bl6 = bl8 = a2 == 23120011;
            }
            if (!bl6) {
                return 0;
            }
            return 1;
        }
        if (a2 == 21120011) {
            return 1;
        }
        if (a2 <= 5320007) {
            boolean bl9;
            if (a2 == 5320007 || a2 == 5120011) {
                return 1;
            }
            boolean bl10 = bl9 = a2 == 5220012;
            if (!bl9) {
                return 0;
            }
            return 1;
        }
        if (a2 < 5321003) {
            return 0;
        }
        if (a2 <= 5321004) {
            return 1;
        }
        boolean bl11 = bl = a2 == 5321006;
        if (!bl) {
            return 0;
        }
        return 1;
    }

    private static /* synthetic */ int i(int a2) {
        int n2;
        if (SpecialSkillConstants.m(a2) || a2 % 100 <= 0 || a2 == 501) {
            int n3 = 1;
            return 1;
        }
        int n4 = a2 % 10;
        if ((a2 / 10 == 43 ? (n2 = n4 / 2 + 2) : (n2 = n4 + 2)) >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            int n5 = n2;
            return n5;
        }
        int n6 = 0;
        return 0;
    }

    private static /* synthetic */ int l(int a2) {
        int n2;
        if (SpecialSkillConstants.I(a2) || a2 % 100 == 0 || a2 == 501 || a2 == 508) {
            return 1;
        }
        int n3 = a2 % 10;
        if ((a2 / 10 == 43 ? (n2 = n3 / 2 + 2) : (n2 = n3 + 2)) >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            n3 = n2;
            return n3;
        }
        n3 = 0;
        return 0;
    }

    private static /* synthetic */ boolean k(int a2) {
        int n2 = a2 / 10000;
        return a2 / 10000 % 1000 == 0 || n2 == 2001 || n2 == 2002 || n2 == 3001;
    }

    private static /* synthetic */ int A(int a2) {
        boolean bl;
        if (a2 > 5220014) {
            boolean bl2;
            if (a2 > 5920012) {
                if (a2 > 23121008) {
                    boolean bl3;
                    if (a2 == 33120010) {
                        return 1;
                    }
                    bl2 = bl3 = a2 == 33121005;
                } else {
                    boolean bl4;
                    if (a2 == 23121008 || a2 == 21120011 || a2 == 22181004) {
                        return 1;
                    }
                    bl2 = bl4 = a2 == 23120011;
                }
            } else {
                if (a2 == 5920012) {
                    return 1;
                }
                if (a2 > 5720005) {
                    boolean bl5;
                    if (a2 == 5720008 || a2 == 5720012) {
                        return 1;
                    }
                    bl2 = bl5 = a2 - 1430003 == 99999;
                } else {
                    if (a2 == 5720002) {
                        return 1;
                    }
                    if (a2 > 5321004) {
                        boolean bl6;
                        bl2 = bl6 = a2 == 5321006;
                    } else {
                        boolean bl7;
                        if (a2 >= 5321003) {
                            return 1;
                        }
                        bl2 = bl7 = a2 == 5320007;
                    }
                }
            }
            if (!bl2) {
                return 0;
            }
            return 1;
        }
        if (a2 == 5220014) {
            return 1;
        }
        if (a2 <= 3220010) {
            boolean bl8;
            if (a2 >= 3220009) {
                return 1;
            }
            if (a2 > 2121009) {
                boolean bl9;
                if (a2 > 2321010) {
                    if (a2 < 3120010 || a2 > 3120012) {
                        return 0;
                    }
                    return 1;
                }
                if (a2 == 2321010) {
                    return 1;
                }
                bl8 = bl9 = a2 == 2221009;
            } else {
                boolean bl10;
                if (a2 == 2121009 || a2 == 1120012 || a2 == 1220013) {
                    return 1;
                }
                bl8 = bl10 = a2 == 1320011;
            }
            if (!bl8) {
                return 0;
            }
            return 1;
        }
        if (a2 <= 4340010) {
            boolean bl11;
            if (a2 == 4340010 || a2 == 3220012 || a2 == 4110012) {
                return 1;
            }
            boolean bl12 = bl11 = a2 == 4210012;
            if (!bl11) {
                return 0;
            }
            return 1;
        }
        if (a2 < 5120011) {
            return 0;
        }
        if (a2 <= 5120012) {
            return 1;
        }
        boolean bl13 = bl = a2 == 5220012;
        if (!bl) {
            return 0;
        }
        return 1;
    }

    private static /* synthetic */ boolean ALLATORIxDEMO(int a2) {
        return a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 == 2003 || a2 == 5000;
    }

    private static /* synthetic */ boolean B(int a2) {
        return !SpecialSkillConstants.G(a2) && SpecialSkillConstants.G(10000 * (a2 / 10000));
    }

    private static /* synthetic */ int H(int a2) {
        if (a2 > 5220014) {
            if (a2 > 22181004) {
                boolean bl;
                if (a2 == 23120011 || a2 == 23121008 || a2 == 33120010 || a2 == 33121005 || a2 == 35120014) {
                    return 1;
                }
                boolean bl2 = bl = a2 == 51120000;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 22181004) {
                return 1;
            }
            if (a2 > 5720005) {
                boolean bl;
                if (a2 == 5720008 || a2 - 5720008 == 4) {
                    return 1;
                }
                boolean bl3 = bl = a2 - 5720004 == 15399999;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 5720005 || a2 == 5320007) {
                return 1;
            }
            if (a2 > 5321002) {
                boolean bl;
                if (a2 <= 5321004) {
                    return 1;
                }
                boolean bl4 = bl = a2 == 5321006;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
        } else {
            if (a2 == 5220014) {
                return 1;
            }
            if (a2 <= 3220010) {
                boolean bl;
                if (a2 >= 3220009) {
                    return 1;
                }
                if (a2 > 2121009) {
                    if (a2 != 2221009 && a2 != 2321010 && (a2 <= 3120009 || a2 > 3120012)) {
                        return 0;
                    }
                    return 1;
                }
                if (a2 == 2121009 || a2 == 1120012 || a2 == 1220013) {
                    return 1;
                }
                boolean bl5 = bl = a2 == 1320011;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 <= 4340010) {
                boolean bl;
                if (a2 == 4340010 || a2 == 3220012 || a2 == 4110012) {
                    return 1;
                }
                boolean bl6 = bl = a2 == 4210012;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 4340012) {
                return 1;
            }
            if (a2 > 5120010) {
                boolean bl;
                if (a2 <= 5120012) {
                    return 1;
                }
                boolean bl7 = bl = a2 == 5220012;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
        }
        return 0;
    }

    private static /* synthetic */ boolean C(int a2) {
        return a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001;
    }

    private static /* synthetic */ int D(int a2) {
        int n2;
        if (SpecialSkillConstants.d(a2) || a2 % 100 == 0 || a2 == 501 || a2 == 508 || a2 == 509) {
            return 1;
        }
        int n3 = a2 % 10;
        if ((a2 / 10 == 43 ? (n2 = n3 / 2 + 2) : (n2 = n3 + 2)) >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            n3 = n2;
            return n3;
        }
        n3 = 0;
        return 0;
    }

    private static /* synthetic */ boolean i(int a2) {
        return a2 / 1000000 == 92 && a2 % 10000 == 0;
    }

    private static /* synthetic */ int K(int a2) {
        int n2;
        if (a2 % 100 > 0 && a2 != 2001) {
            int n3;
            int n4 = a2 % 10;
            n2 = (a2 / 10 == 43 ? (n3 = n4 / 2 + 2) : (n3 = n4 + 2)) >= 2 && (n3 <= 4 || n3 <= 10 && JobConstants.isEvan(a2)) ? n3 : 0;
        } else {
            n2 = 1;
        }
        return n2;
    }

    private static /* synthetic */ int d(int a2) {
        int n2;
        if (SpecialSkillConstants.K(a2) || a2 % 100 == 0 || a2 == 501) {
            return 1;
        }
        int n3 = a2 % 10;
        if ((a2 / 10 == 43 ? (n2 = n3 / 2 + 2) : (n2 = n3 + 2)) >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            n3 = n2;
            return n3;
        }
        n3 = 0;
        return 0;
    }

    private static /* synthetic */ int b(int a2) {
        boolean bl;
        if (a2 <= 4340010) {
            boolean bl2;
            if (a2 == 4340010) {
                return 1;
            }
            if (a2 > 2321010) {
                if (a2 >= 3120010) {
                    if (a2 <= 3120012) {
                        return 1;
                    }
                    if (a2 > 3220008) {
                        boolean bl3;
                        if (a2 <= 3220010 || a2 == 3220012 || a2 == 4120010) {
                            return 1;
                        }
                        boolean bl4 = bl3 = a2 == 4220009;
                        if (!bl3) {
                            return 0;
                        }
                        return 1;
                    }
                }
                return 0;
            }
            if (a2 == 2321010 || a2 == 1120012 || a2 == 1220013 || a2 == 1320011 || a2 == 2121009) {
                return 1;
            }
            boolean bl5 = bl2 = a2 == 2221009;
            if (!bl2) {
                return 0;
            }
            return 1;
        }
        if (a2 <= 21120011) {
            boolean bl6;
            if (a2 == 21120011 || a2 == 5120011 || a2 == 5220012 || a2 == 5320007) {
                return 1;
            }
            if (a2 <= 5321002) {
                return 0;
            }
            if (a2 <= 5321004) {
                return 1;
            }
            boolean bl7 = bl6 = a2 == 5321006;
            if (!bl6) {
                return 0;
            }
            return 1;
        }
        if (a2 == 22181004 || a2 == 23120011 || a2 == 23121008 || a2 == 32120009) {
            return 1;
        }
        boolean bl8 = bl = a2 == 33120010;
        if (!bl) {
            return 0;
        }
        return 1;
    }

    private static /* synthetic */ boolean M(int a2) {
        int n2;
        boolean bl = false;
        if ((a2 / 1000000 != 92 || a2 % 10000 > 0) && (n2 = 10000 * (a2 / 10000)) / 1000000 == 92 && n2 % 10000 == 0) {
            bl = true;
        }
        return bl;
    }

    private static /* synthetic */ int C(int a2) {
        if (a2 % 100 == 0 || a2 == 2001) {
            return 1;
        }
        int n2 = a2 % 10 + 2;
        if (n2 < 2 || n2 > 4 && (n2 > 10 || a2 / 100 != 22)) {
            int n3 = 0;
            return 0;
        }
        int n4 = a2 % 10 + 2;
        return n4;
    }

    private static /* synthetic */ int G(int a2) {
        int n2;
        int n3 = a2 % 100 > 0 && a2 != 2001 ? ((n2 = (a2 / 10 == 43 ? (n2 = a2 % 10 / 2) : (n2 = a2 % 10)) + 2) < 2 || n2 > 4 && (n2 > 10 || a2 / 100 != 22) ? 0 : n2) : 1;
        return n3;
    }

    public static /* synthetic */ int sub_49C130_100(int a2) {
        boolean bl;
        if (a2 > 5120012) {
            if (a2 > 21120011) {
                if (a2 > 23121008) {
                    boolean bl2;
                    if (a2 == 33120010) {
                        return 1;
                    }
                    bl = bl2 = a2 == 33121005;
                } else {
                    boolean bl3;
                    if (a2 == 23121008 || a2 == 22181004) {
                        return 1;
                    }
                    bl = bl3 = a2 == 23120011;
                }
            } else {
                if (a2 == 21120011) {
                    return 1;
                }
                if (a2 > 5320007) {
                    boolean bl4;
                    if (a2 < 5321003) {
                        return 0;
                    }
                    if (a2 <= 5321004) {
                        return 1;
                    }
                    bl = bl4 = a2 == 5321006;
                } else {
                    boolean bl5;
                    if (a2 == 5320007 || a2 == 5220012) {
                        return 1;
                    }
                    bl = bl5 = a2 - 1305003 == 2;
                }
            }
        } else {
            boolean bl6;
            if (a2 >= 5120011) {
                return 1;
            }
            if (a2 <= 3120012) {
                boolean bl7;
                if (a2 >= 3120010) {
                    return 1;
                }
                if (a2 > 2121009) {
                    boolean bl8;
                    if (a2 == 2221009) {
                        return 1;
                    }
                    bl7 = bl8 = a2 == 2321010;
                } else {
                    boolean bl9;
                    if (a2 == 2121009 || a2 == 1120012 || a2 == 1220013) {
                        return 1;
                    }
                    bl7 = bl9 = a2 == 1320011;
                }
                if (!bl7) {
                    return 0;
                }
                return 1;
            }
            if (a2 <= 4120010) {
                boolean bl10;
                if (a2 == 4120010) {
                    return 1;
                }
                if (a2 < 3220009) {
                    return 0;
                }
                if (a2 <= 3220010) {
                    return 1;
                }
                boolean bl11 = bl10 = a2 == 3220012;
                if (!bl10) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 4220009) {
                return 1;
            }
            bl = bl6 = a2 == 4340010;
        }
        if (!bl) {
            return 0;
        }
        return 1;
    }

    private static /* synthetic */ boolean h(int a2) {
        return !SpecialSkillConstants.A(a2) && SpecialSkillConstants.A(10000 * (a2 / 10000));
    }

    private static /* synthetic */ boolean D(int a2) {
        return a2 / 1000000 == 92 && a2 % 10000 == 0;
    }

    private static /* synthetic */ int M(int a2) {
        int n2;
        if (a2 % 100 == 0 || a2 == 2001) {
            return 1;
        }
        n2 = (a2 / 10 == 43 ? (n2 = (a2 - 430) / 2) : (n2 = a2 % 10)) + 2;
        if (n2 >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a2))) {
            int n3 = n2;
            return n3;
        }
        int n4 = 0;
        return 0;
    }

    private static /* synthetic */ int I(int a2) {
        boolean bl;
        if (a2 <= 4340010) {
            boolean bl2;
            if (a2 == 4340010) {
                return 1;
            }
            if (a2 <= 3120012) {
                boolean bl3;
                if (a2 >= 3120010 || a2 == 1120012 || a2 == 1220013 || a2 == 1320011 || a2 == 2121009 || a2 == 2221009) {
                    return 1;
                }
                boolean bl4 = bl3 = a2 == 2321010;
                if (!bl3) {
                    return 0;
                }
                return 1;
            }
            if (a2 < 3220009) {
                return 0;
            }
            if (a2 <= 3220010 || a2 == 3220012 || a2 == 4110012 || a2 == 4120010) {
                return 1;
            }
            boolean bl5 = bl2 = a2 == 4220009;
            if (!bl2) {
                return 0;
            }
            return 1;
        }
        if (a2 > 21120011) {
            boolean bl6;
            if (a2 == 22181004 || a2 == 23120011 || a2 == 23121008 || a2 == 33120010) {
                return 1;
            }
            bl = bl6 = a2 == 33121005;
        } else {
            boolean bl7;
            if (a2 == 21120011) {
                return 1;
            }
            if (a2 > 5320007) {
                boolean bl8;
                if (a2 < 5321003) {
                    return 0;
                }
                if (a2 <= 5321004) {
                    return 1;
                }
                boolean bl9 = bl8 = a2 == 5321006;
                if (!bl8) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 5320007) {
                return 1;
            }
            if (a2 < 5120011) {
                return 0;
            }
            if (a2 <= 5120012 || a2 == 5220012) {
                return 1;
            }
            bl = bl7 = a2 == 5220014;
        }
        if (!bl) {
            return 0;
        }
        return 1;
    }

    private static /* synthetic */ boolean g(int a2) {
        return !SpecialSkillConstants.i(a2) && SpecialSkillConstants.i(10000 * (a2 / 10000));
    }

    private static /* synthetic */ boolean A(int a2) {
        return a2 / 1000000 == 92 && a2 % 10000 <= 0;
    }

    private static /* synthetic */ boolean L(int a2) {
        int n2 = a2 / 10000;
        return a2 / 10000 % 1000 == 0 || n2 == 2001 || n2 == 2002 || n2 == 3001 || n2 == 2003;
    }

    private static /* synthetic */ boolean G(int a2) {
        return a2 / 1000000 == 92 && a2 % 10000 == 0;
    }

    private static /* synthetic */ boolean f(int a2) {
        int n2 = a2 / 10000;
        return a2 / 10000 % 1000 == 0 || n2 == 2001 || n2 == 2002 || n2 == 3001;
    }

    public /* synthetic */ SpecialSkillConstants() {
        SpecialSkillConstants a2;
    }

    private static /* synthetic */ boolean e(int a2) {
        int n2;
        boolean bl = false;
        if ((a2 / 1000000 != 92 || a2 % 10000 > 0) && (n2 = 10000 * (a2 / 10000)) / 1000000 == 92 && n2 % 10000 == 0) {
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ boolean sub_4A5B80_105(int a2) {
        if (a2 > 5220014) {
            if (a2 > 5920012) {
                if (a2 > 23121008) {
                    if (a2 == 33120010 || a2 == 33121005) {
                        return true;
                    }
                    boolean bl = a2 == 51120000;
                    return bl;
                }
                if (a2 == 23121008 || a2 == 21120011 || a2 == 22181004) {
                    return true;
                }
                boolean bl = a2 == 23120011;
                return bl;
            }
            if (a2 != 5920012) {
                if (a2 > 5720005) {
                    if (a2 == 5720008 || a2 == 5720012) {
                        return true;
                    }
                    boolean bl = a2 - 1430003 == 99999;
                    return bl;
                }
                if (a2 != 5720005) {
                    if (a2 > 5321004) {
                        boolean bl = a2 == 5321006;
                        return bl;
                    }
                    if (a2 < 5321003) {
                        boolean bl = a2 == 5320007;
                        return bl;
                    }
                }
            }
            return true;
        }
        if (a2 == 5220014) {
            return true;
        }
        if (a2 > 3220010) {
            if (a2 <= 4340010) {
                if (a2 == 4340010 || a2 == 3220012 || a2 == 4110012) {
                    return true;
                }
                boolean bl = a2 == 4210012;
                return bl;
            }
            if (a2 > 5120012) {
                boolean bl = a2 == 5220012;
                return bl;
            }
            if (a2 < 5120011) {
                boolean bl = a2 == 4340012;
                return bl;
            }
            return true;
        }
        if (a2 >= 3220009) {
            return true;
        }
        if (a2 > 2121009) {
            if (a2 > 2321010) {
                if (a2 < 3120010 || a2 > 3120012) {
                    return false;
                }
            } else if (a2 != 2321010) {
                boolean bl = a2 == 2221009;
                return bl;
            }
            return true;
        }
        if (a2 == 2121009 || a2 == 1120012 || a2 == 1220013) {
            return true;
        }
        boolean bl = a2 == 1320011;
        return bl;
    }

    private static /* synthetic */ int j(int a2) {
        int n2;
        if (a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 % 100 == 0 || a2 == 501) {
            return 1;
        }
        n2 = (a2 / 10 == 43 ? (n2 = (a2 - 430) / 2) : (n2 = a2 % 10)) + 2;
        if (n2 >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            int n3 = n2;
            return n3;
        }
        int n4 = 0;
        return 0;
    }

    private static /* synthetic */ boolean c(int a2) {
        return a2 / 1000000 == 92 && a2 % 10000 == 0;
    }

    private static /* synthetic */ int ALLATORIxDEMO(int a2) {
        int n2;
        if (SpecialSkillConstants.ALLATORIxDEMO(a2) || a2 % 100 == 0 || a2 == 501 || a2 == 508) {
            return 1;
        }
        int n3 = a2 % 10;
        if ((a2 / 10 == 43 ? (n2 = n3 / 2 + 2) : (n2 = n3 + 2)) >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            n3 = n2;
            return n3;
        }
        n3 = 0;
        return 0;
    }

    private static /* synthetic */ int J(int a2) {
        if (a2 <= 4220009) {
            boolean bl;
            if (a2 == 4220009) {
                return 1;
            }
            if (a2 > 2321010) {
                boolean bl2;
                if (a2 <= 3220012) {
                    if (a2 != 3220012 && (a2 > 3220010 || a2 < 3220009 && (a2 < 3120010 || a2 > 3120012))) {
                        return 0;
                    }
                    return 1;
                }
                bl = bl2 = a2 == 4120010;
            } else {
                if (a2 == 2321010) {
                    return 1;
                }
                if (a2 > 1320011) {
                    boolean bl3;
                    if (a2 == 2121009) {
                        return 1;
                    }
                    bl = bl3 = a2 == 2221009;
                } else {
                    boolean bl4;
                    if (a2 == 1320011 || a2 == 1120012) {
                        return 1;
                    }
                    bl = bl4 = a2 == 1220013;
                }
            }
            if (!bl) {
                return 0;
            }
            return 1;
        }
        if (a2 > 5321006) {
            boolean bl;
            if (a2 > 32120009) {
                boolean bl5;
                bl = bl5 = a2 == 33120010;
            } else {
                boolean bl6;
                if (a2 == 32120009 || a2 == 21120011) {
                    return 1;
                }
                bl = bl6 = a2 == 22181004;
            }
            if (!bl) {
                return 0;
            }
            return 1;
        }
        if (a2 == 5321006) {
            return 1;
        }
        if (a2 <= 5220012) {
            boolean bl;
            if (a2 == 5220012 || a2 == 4340010) {
                return 1;
            }
            boolean bl7 = bl = a2 == 5120011;
            if (!bl) {
                return 0;
            }
            return 1;
        }
        if (a2 == 5320007) {
            return 1;
        }
        if (a2 <= 5321002) {
            return 0;
        }
        if (a2 > 5321004) {
            return 0;
        }
        return 1;
    }

    private static /* synthetic */ boolean E(int a2) {
        return !SpecialSkillConstants.D(a2) && SpecialSkillConstants.D(10000 * (a2 / 10000));
    }

    private static /* synthetic */ boolean H(int a2) {
        return !SpecialSkillConstants.l(a2) && SpecialSkillConstants.l(10000 * (a2 / 10000));
    }

    private static /* synthetic */ boolean b(int a2) {
        return !SpecialSkillConstants.c(a2) && SpecialSkillConstants.c(10000 * (a2 / 10000));
    }

    private static /* synthetic */ boolean a(int a2) {
        int n2;
        boolean bl = false;
        if ((a2 / 1000000 != 92 || a2 % 10000 > 0) && (n2 = 10000 * (a2 / 10000)) / 1000000 == 92 && n2 % 10000 == 0) {
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (2 ^ 5) << 4 ^ 1 << 1;
        int cfr_ignored_0 = 3 << 3 ^ (2 ^ 5);
        int n5 = n3;
        int n6 = (3 ^ 5) << 3 ^ (2 ^ 5);
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    private static /* synthetic */ boolean J(int a2) {
        if (a2 > 5220014) {
            if (a2 > 22181004) {
                if (a2 <= 33121005) {
                    if (a2 == 33121005 || a2 == 23120011 || a2 == 23121008) {
                        return true;
                    }
                    boolean bl = a2 == 33120010;
                    return bl;
                }
                if (a2 != 35120014) {
                    boolean bl = a2 == 51120000;
                    return bl;
                }
            } else if (a2 != 22181004) {
                if (a2 > 5720005) {
                    if (a2 == 5720008 || a2 == 5720012) {
                        return true;
                    }
                    boolean bl = a2 - 5720012 == 15399999;
                    return bl;
                }
                if (a2 != 5720005) {
                    if (a2 > 5321004) {
                        boolean bl = a2 == 5321006;
                        return bl;
                    }
                    if (a2 < 5321003) {
                        boolean bl = a2 == 5320007;
                        return bl;
                    }
                }
            }
            return true;
        }
        if (a2 == 5220014) {
            return true;
        }
        if (a2 > 3220010) {
            if (a2 <= 4340010) {
                if (a2 == 4340010 || a2 == 3220012 || a2 == 4110012) {
                    return true;
                }
                boolean bl = a2 == 4210012;
                return bl;
            }
            if (a2 > 5120012) {
                boolean bl = a2 == 5220012;
                return bl;
            }
            if (a2 < 5120011) {
                boolean bl = a2 == 4340012;
                return bl;
            }
            return true;
        }
        if (a2 >= 3220009) {
            return true;
        }
        if (a2 > 2121009) {
            if (a2 > 2321010) {
                if (a2 < 3120010 || a2 > 3120012) {
                    return false;
                }
            } else if (a2 != 2321010) {
                boolean bl = a2 == 2221009;
                return bl;
            }
            return true;
        }
        if (a2 == 2121009 || a2 == 1120012 || a2 == 1220013) {
            return true;
        }
        boolean bl = a2 == 1320011;
        return bl;
    }

    private static /* synthetic */ int c(int a2) {
        int n2;
        if (SpecialSkillConstants.C(a2) || a2 % 100 == 0 || a2 == 501) {
            return 1;
        }
        int n3 = a2 % 10;
        if ((a2 / 10 == 43 ? (n2 = n3 / 2 + 2) : (n2 = n3 + 2)) >= 2 && (n2 <= 4 || n2 <= 10 && JobConstants.isEvan(a2))) {
            n3 = n2;
            return n3;
        }
        n3 = 0;
        return 0;
    }

    private static /* synthetic */ int E(int a2) {
        if (a2 > 5220014) {
            if (a2 > 5920012) {
                boolean bl;
                if (a2 == 21120011 || a2 == 22181004 || a2 == 23120011 || a2 == 23121008 || a2 == 33120010) {
                    return 1;
                }
                boolean bl2 = bl = a2 == 33121005;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 5920012) {
                return 1;
            }
            if (a2 > 5720005) {
                boolean bl;
                if (a2 == 5720008 || a2 - 5720008 == 4) {
                    return 1;
                }
                boolean bl3 = bl = a2 - 5720008 == 100003;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 5720005 || a2 == 5320007) {
                return 1;
            }
            if (a2 > 5321002) {
                boolean bl;
                if (a2 <= 5321004) {
                    return 1;
                }
                boolean bl4 = bl = a2 == 5321006;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
        } else {
            if (a2 == 5220014) {
                return 1;
            }
            if (a2 <= 3220010) {
                boolean bl;
                if (a2 >= 3220009) {
                    return 1;
                }
                if (a2 > 2121009) {
                    if (a2 != 2221009 && a2 != 2321010 && (a2 <= 3120009 || a2 > 3120012)) {
                        return 0;
                    }
                    return 1;
                }
                if (a2 == 2121009 || a2 == 1120012 || a2 == 1220013) {
                    return 1;
                }
                boolean bl5 = bl = a2 == 1320011;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
            if (a2 == 3220012 || a2 == 4110012 || a2 == 4210012 || a2 == 4340010) {
                return 1;
            }
            if (a2 > 5120010) {
                boolean bl;
                if (a2 <= 5120012) {
                    return 1;
                }
                boolean bl6 = bl = a2 == 5220012;
                if (!bl) {
                    return 0;
                }
                return 1;
            }
        }
        return 0;
    }

    private static /* synthetic */ boolean d(int a2) {
        return a2 % 1000 == 0 || a2 == 2001 || a2 == 2002 || a2 == 3001 || a2 == 2003;
    }

    private static /* synthetic */ int L(int a2) {
        boolean bl;
        if (a2 > 3220010) {
            boolean bl2;
            if (a2 <= 5220012) {
                boolean bl3;
                if (a2 == 5220012 || a2 == 4120010 || a2 == 4220009) {
                    return 1;
                }
                boolean bl4 = bl3 = a2 == 5120011;
                if (bl3) {
                    return 1;
                }
                return 0;
            }
            if (a2 == 32120009) {
                return 1;
            }
            boolean bl5 = bl2 = a2 == 33120010;
            if (bl2) {
                return 1;
            }
            return 0;
        }
        if (a2 >= 3220009) {
            return 1;
        }
        if (a2 > 2120009) {
            if (a2 > 2320010) {
                if (a2 < 3120010 || a2 > 3120011) {
                    return 0;
                }
            } else if (a2 != 2320010) {
                boolean bl6;
                boolean bl7 = bl6 = a2 == 2220009;
                if (bl6) {
                    return 1;
                }
                return 0;
            }
            return 1;
        }
        if (a2 == 2120009 || a2 == 1120012 || a2 == 1220013) {
            return 1;
        }
        boolean bl8 = bl = a2 == 1320011;
        if (bl) {
            return 1;
        }
        return 0;
    }

    private static /* synthetic */ boolean F(int a2) {
        int n2;
        boolean bl = false;
        if ((a2 / 1000000 != 92 || a2 % 10000 > 0) && (n2 = 10000 * (a2 / 10000)) / 1000000 == 92 && n2 % 10000 == 0) {
            bl = true;
        }
        return bl;
    }

    private static /* synthetic */ boolean j(int a2) {
        return a2 / 10 == 43;
    }

    private static /* synthetic */ boolean m(int a2) {
        return a2 % 1000 <= 0 || a2 == 2001 || a2 == 2002 || a2 == 3001;
    }

    private static /* synthetic */ boolean l(int a2) {
        return a2 / 1000000 == 92 && a2 % 10000 == 0;
    }

    public static /* synthetic */ boolean isSkillNeedMasterLevel(int a2, int a3) {
        if (GameSetConstants.MAPLE_VERSION == 75) {
            return a2 / 10000 % 100 > 0 && a2 / 10000 % 10 == 2;
        }
        if (GameSetConstants.MAPLE_VERSION == 115) {
            int n2 = a2;
            int n3 = n2 / 10000;
            if (n2 / 10000 / 100 != 22 && n3 != 2001) {
                if (n3 % 100 == 0) {
                    return false;
                }
                boolean bl = n3 % 10 == 2;
                return bl;
            }
            if (SpecialSkillConstants.C(n2 / 10000) != 9 && SpecialSkillConstants.C(n3) != 10) {
                return false;
            }
            boolean bl = true;
            return true;
        }
        if (GameSetConstants.MAPLE_VERSION == 121 || GameSetConstants.MAPLE_VERSION == 122 || GameSetConstants.MAPLE_VERSION == 123) {
            int n4 = a2;
            int n5 = n4 / 10000;
            if (n4 / 10000 / 100 == 22 || n5 == 2001) {
                if (SpecialSkillConstants.G(n4 / 10000) != 9) {
                    boolean bl;
                    boolean bl2 = bl = SpecialSkillConstants.G(n5) == 10;
                    if (!bl) {
                        return false;
                    }
                }
                return true;
            }
            if (n5 / 10 == 43) {
                if (SpecialSkillConstants.G(n4 / 10000) != 4 && n4 != 4311003 && n4 != 4321000 && n4 != 4331002) {
                    boolean bl;
                    boolean bl3 = bl = n4 == 4331005;
                    if (!bl) {
                        return false;
                    }
                }
                return true;
            }
            return n5 % 100 != 0 && n5 % 10 == 2;
        }
        if (GameSetConstants.MAPLE_VERSION == 125 || GameSetConstants.MAPLE_VERSION == 126) {
            boolean bl = true;
            int n6 = a2;
            int n7 = n6 / 10000;
            int n8 = 0;
            if (SpecialSkillConstants.B(n6) > 0) {
                return false;
            }
            if (JobConstants.isEvan(n6 / 10000)) {
                n8 = SpecialSkillConstants.K(n6 / 10000);
                if (n8 != 9) {
                    boolean bl4 = n8 == 10;
                    return bl4;
                }
                return true;
            }
            if (n7 / 10 != 43) {
                bl = false;
                if (n7 % 100 > 0) {
                    bl = n7 % 10 == 2;
                }
                return bl;
            }
            if (SpecialSkillConstants.K(n6 / 10000) != 4 && n6 != 4311003 && n6 != 4321000 && n6 != 4331002) {
                boolean bl5 = n6 == 4331005;
                return bl5;
            }
            return true;
        }
        if (GameSetConstants.MAPLE_VERSION >= 132 && GameSetConstants.MAPLE_VERSION <= 136) {
            int n9 = a2;
            if (SpecialSkillConstants.g(n9) > 0 || SpecialSkillConstants.A(n9) || SpecialSkillConstants.h(n9)) {
                return false;
            }
            int n10 = n9 / 10000;
            if (JobConstants.isEvan(n9 / 10000)) {
                int n11 = SpecialSkillConstants.i(n9 / 10000);
                if (n11 == 9) {
                    return true;
                }
                boolean bl = n11 == 10;
                return bl;
            }
            if (n10 / 10 != 43) {
                boolean bl = false;
                if (n10 % 100 > 0) {
                    bl = n10 % 10 == 2;
                }
                return bl;
            }
            if (SpecialSkillConstants.i(n9 / 10000) == 4 || n9 == 4311003 || n9 == 4321000 || n9 == 4331002) {
                return true;
            }
            boolean bl = n9 == 4331005;
            return bl;
        }
        if (GameSetConstants.MAPLE_VERSION >= 139 && GameSetConstants.MAPLE_VERSION <= 142) {
            int n12 = a2;
            if (SpecialSkillConstants.b(n12) > 0 || SpecialSkillConstants.G(n12) || SpecialSkillConstants.B(n12) || n12 / 10000 == 8000 || SpecialSkillConstants.C(n12 / 10000)) {
                return false;
            }
            int n13 = SpecialSkillConstants.c(n12 / 10000);
            if (JobConstants.isEvan(n12 / 10000)) {
                return n13 == 9 || n13 == 10;
            }
            return n12 == 4311003 || n12 == 4321000 || n12 == 4331002 || n12 == 4331005 || n13 == 4;
        }
        if (GameSetConstants.MAPLE_VERSION >= 143 && GameSetConstants.MAPLE_VERSION <= 145) {
            int n14 = a2;
            if (SpecialSkillConstants.I(n14) > 0 || SpecialSkillConstants.i(n14) || SpecialSkillConstants.g(n14) || n14 / 10000 == 8000 || SpecialSkillConstants.K(n14 / 10000)) {
                return false;
            }
            int n15 = SpecialSkillConstants.d(n14 / 10000);
            if (JobConstants.isEvan(n14 / 10000)) {
                return n15 == 9 || n15 == 10;
            }
            return n14 == 4311003 || n14 == 4321000 || n14 == 4331002 || n14 == 4331005 || n15 == 4;
        }
        if (GameSetConstants.MAPLE_VERSION == 147) {
            int n16 = a2;
            if (SpecialSkillConstants.E(n16) > 0 || SpecialSkillConstants.c(n16) || SpecialSkillConstants.b(n16) || n16 / 10000 == 8000 || SpecialSkillConstants.d(n16 / 10000)) {
                return false;
            }
            int n17 = SpecialSkillConstants.D(n16 / 10000);
            if (JobConstants.isEvan(n16 / 10000)) {
                return n17 == 9 || n17 == 10;
            }
            return n16 == 4311003 || n16 == 4321000 || n16 == 4331002 || n16 == 4331005 || n17 == 4;
        }
        if (GameSetConstants.MAPLE_VERSION == 149) {
            int n18 = a2;
            if (SpecialSkillConstants.sub_4A5B80_105(n18) || SpecialSkillConstants.l(n18) || SpecialSkillConstants.H(n18) || n18 / 10000 == 8000 || SpecialSkillConstants.ALLATORIxDEMO(n18 / 10000) || n18 == 21120011) {
                return false;
            }
            int n19 = SpecialSkillConstants.ALLATORIxDEMO(n18 / 10000);
            if (JobConstants.isEvan(n18 / 10000)) {
                return n19 == 9 || n19 == 10;
            }
            return n18 == 4311003 || n18 == 4331002 || n18 == 0x41EEEE || n18 == 4330009 || n19 == 4;
        }
        if (GameSetConstants.MAPLE_VERSION >= 151 && GameSetConstants.MAPLE_VERSION <= 154) {
            int n20 = a2;
            if (SpecialSkillConstants.H(n20) > 0 || SpecialSkillConstants.D(n20) || SpecialSkillConstants.E(n20) || n20 / 10000 == 8000 || SpecialSkillConstants.I(n20 / 10000)) {
                return false;
            }
            int n21 = SpecialSkillConstants.l(n20 / 10000);
            if (JobConstants.isEvan(n20 / 10000)) {
                return n21 == 9 || n21 == 10;
            }
            return n20 == 4311003 || n20 == 4331002 || n20 == 0x41EEEE || n20 == 4330009 || n21 == 4;
        }
        if (GameSetConstants.MAPLE_VERSION > 113) {
            if (a2 / 10000 >= 2212 && a2 / 10000 < 3000) {
                return a2 / 10000 % 10 >= 7;
            }
            if (a2 / 10000 >= 430 && a2 / 10000 <= 434) {
                return a2 / 10000 % 10 == 4 || a3 > 0;
            }
        }
        return a2 / 10000 % 10 == 2;
    }
}

