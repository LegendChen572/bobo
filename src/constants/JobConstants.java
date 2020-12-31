/*
 * Decompiled with CFR 0.150.
 */
package constants;

import client.MapleCharacter;
import client.MapleJob;
import constants.GameSetConstants;
import constants.SkillConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import tools.Pair;

public class JobConstants {
    public static final /* synthetic */ boolean enableJobs = true;
    public static final /* synthetic */ int jobOrder = 184;
    private static /* synthetic */ HashMap<Integer, Integer> ALLATORIxDEMO;

    public static /* synthetic */ boolean isJob12000HighLv(int a2) {
        return a2 == 12003 || a2 == 12004;
    }

    public static /* synthetic */ HashMap<Integer, Integer> getJobLeveList() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ boolean is\u51f1\u5167\u897f\u65af(int a2) {
        return a2 / 100 == 142 || a2 == 14000;
    }

    public static /* synthetic */ boolean isJob9500(int a2) {
        if (a2 >= 0) {
            boolean bl = SkillConstants.getJobBySkill(a2) == 9500;
            return bl;
        }
        boolean bl = false;
        return false;
    }

    public static /* synthetic */ boolean is\u4e0d\u4f7f\u7528MP\u8077\u696d(int a2) {
        return JobConstants.is\u60e1\u9b54\u6bba\u624b(a2) || JobConstants.is\u60e1\u9b54\u5fa9\u4ec7\u8005(a2) || JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a2) || JobConstants.is\u795e\u4e4b\u5b50(a2) || JobConstants.is\u51f1\u5167\u897f\u65af(a2);
    }

    public static /* synthetic */ int getPvpMaxHp(MapleCharacter a2, boolean a3) {
        MapleCharacter mapleCharacter = a2;
        int n2 = mapleCharacter.getPVPStage();
        short s2 = mapleCharacter.getJob();
        if (a3 == 0) {
            a3 = s2 / 10;
            if (s2 / 10 > 41) {
                int n3 = a3 - 42;
                if (n3 == 0) {
                    if (n2 >= 2) {
                        return 15000;
                    }
                    if (n2 >= 1) {
                        return 12500;
                    }
                    if (n2 >= 0) {
                        return 8000;
                    }
                    return JobConstants.label17(s2, n2);
                }
                if (--n3 == 0) {
                    if (n2 >= 2) {
                        return 13500;
                    }
                    if (n2 >= 1) {
                        return 10000;
                    }
                    if (n2 >= 0) {
                        return 6000;
                    }
                    return JobConstants.label17(s2, n2);
                }
                if ((n3 -= 8) > 0) {
                    if (n3 != 1) {
                        return JobConstants.label17(s2, n2);
                    }
                    if (n2 >= 2) {
                        return 13000;
                    }
                    if (n2 >= 1) {
                        return 10000;
                    }
                    if (n2 >= 0) {
                        return 7000;
                    }
                }
                if (n2 >= 2) {
                    return 16500;
                }
            } else {
                if (s2 / 10 == 41) {
                    if (n2 >= 2) {
                        return 13000;
                    }
                    if (n2 >= 1) {
                        return 10000;
                    }
                    if (n2 >= 0) {
                        return 7000;
                    }
                }
                if (a3 == 11) {
                    if (n2 >= 2) {
                        return 18000;
                    }
                    if (n2 >= 1) {
                        return 14000;
                    }
                    if (n2 >= 0) {
                        return 10000;
                    }
                    return JobConstants.label17(s2, n2);
                }
                if (a3 != 12) {
                    if (a3 != 13) {
                        if (a3 <= 20) {
                            return JobConstants.label17(s2, n2);
                        }
                        if (a3 <= 23) {
                            if (n2 >= 2) {
                                return 10000;
                            }
                            if (n2 >= 1) {
                                return 7500;
                            }
                            if (n2 >= 0) {
                                return 5000;
                            }
                            return JobConstants.label17(s2, n2);
                        }
                        if (a3 <= 30 || a3 > 32) {
                            return JobConstants.label17(s2, n2);
                        }
                        if (n2 >= 2) {
                            return 13000;
                        }
                        if (n2 >= 1) {
                            return 10000;
                        }
                        if (n2 >= 0) {
                            return 7000;
                        }
                        return JobConstants.label17(s2, n2);
                    }
                    if (n2 >= 2) {
                        return 20000;
                    }
                    if (n2 >= 1) {
                        return 13500;
                    }
                    if (n2 >= 0) {
                        return 10000;
                    }
                    return JobConstants.label17(s2, n2);
                }
                if (n2 >= 2) {
                    return 20000;
                }
            }
            if (n2 >= 1) {
                return 15000;
            }
            if (n2 >= 0) {
                return 10000;
            }
            return JobConstants.label17(s2, n2);
        }
        a3 = 0;
        if (n2 >= 2) {
            return 90000;
        }
        if (n2 >= 1) {
            return 72000;
        }
        if (n2 >= 0) {
            a3 = 54000;
        }
        return a3;
    }

    public static /* synthetic */ boolean is\u82f1\u96c4(int a2) {
        return a2 / 10 == 11;
    }

    public static /* synthetic */ boolean isJob8000(int a2) {
        int n2 = SkillConstants.getJobBySkill(a2);
        return n2 >= 800000 && n2 <= 800099 || n2 == 8001;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int getPvpMaxHp(MapleCharacter a2, int a3) {
        int n2;
        int n3 = 0;
        MapleCharacter mapleCharacter = a2;
        int n4 = mapleCharacter.getStat().getMaxHp();
        switch (mapleCharacter.getPVPStage()) {
            case 0: {
                n2 = n3 = 1;
                break;
            }
            case 1: {
                n2 = n3 = 2;
                break;
            }
            case 2: 
            case 3: {
                n3 = 3;
            }
            default: {
                n2 = n3;
            }
        }
        if (n2 <= 0) return n4;
        if (JobConstants.is\u5e02\u6c11(a3)) {
            switch (n3) {
                case 1: {
                    return 10000;
                }
                case 2: {
                    return 15000;
                }
                case 3: {
                    return 16500;
                }
            }
            return n4;
        }
        if (JobConstants.is\u7149\u7344\u5deb\u5e2b(a3)) {
            switch (n3) {
                case 1: {
                    return 8000;
                }
                case 2: {
                    return 11000;
                }
                case 3: {
                    return 13500;
                }
            }
            return n4;
        }
        if (JobConstants.is\u72c2\u8c79\u7375\u4eba(a3)) {
            switch (n3) {
                case 1: {
                    return 6000;
                }
                case 2: {
                    return 9000;
                }
                case 3: {
                    return 11500;
                }
            }
            return n4;
        }
        if (JobConstants.is\u6a5f\u7532\u6230\u795e(a3)) {
            switch (n3) {
                case 1: {
                    return 6000;
                }
                case 2: {
                    return 9000;
                }
                case 3: {
                    return 11500;
                }
            }
            return n4;
        }
        if (JobConstants.is\u72c2\u72fc\u52c7\u58eb(a3)) {
            switch (n3) {
                case 1: {
                    return 6000;
                }
                case 2: {
                    return 9000;
                }
                case 3: {
                    return 19300;
                }
            }
            return n4;
        }
        if (a3 / 10 == 52) {
            switch (n3) {
                case 1: {
                    return 7000;
                }
                case 2: {
                    return 35300;
                }
                case 3: {
                    return 13000;
                }
            }
            return n4;
        }
        if (a3 / 10 == 51) {
            switch (n3) {
                case 1: {
                    return 10000;
                }
                case 2: {
                    return 15000;
                }
                case 3: {
                    return 16500;
                }
            }
            return n4;
        }
        if (a3 / 10 == 43) {
            switch (n3) {
                case 1: {
                    return 6000;
                }
                case 2: {
                    return 10000;
                }
                case 3: {
                    return 13000;
                }
            }
            return n4;
        }
        if (a3 / 10 == 42) {
            switch (n3) {
                case 1: {
                    return 8000;
                }
                case 2: {
                    return 12500;
                }
                case 3: {
                    return 15000;
                }
            }
            return n4;
        }
        if (a3 / 10 == 41) {
            switch (n3) {
                case 1: {
                    return 7000;
                }
                case 2: {
                    return 10000;
                }
                case 3: {
                    return 13000;
                }
            }
            return n4;
        }
        if (a3 / 10 == 32 || a3 / 10 == 31) {
            switch (n3) {
                case 1: {
                    return 7000;
                }
                case 2: {
                    return 10000;
                }
                case 3: {
                    return 13000;
                }
            }
            return n4;
        }
        if (a3 / 10 == 23 || a3 / 10 == 22 || a3 / 10 == 21) {
            switch (n3) {
                case 1: {
                    return 5000;
                }
                case 2: {
                    return 7500;
                }
                case 3: {
                    return 10000;
                }
            }
            return n4;
        }
        if (JobConstants.is\u9f8d\u9b54\u5c0e\u58eb(a3)) {
            switch (n3) {
                case 1: {
                    return 6000;
                }
                case 2: {
                    return 8000;
                }
                case 3: {
                    return 10000;
                }
            }
            return n4;
        }
        if (a3 / 10 == 13 || a3 / 10 == 12) {
            switch (n3) {
                case 1: {
                    return 10000;
                }
                case 2: {
                    return 15000;
                }
                case 3: {
                    return 20000;
                }
            }
            return n4;
        }
        if (a3 / 10 != 11) return n4;
        switch (n3) {
            case 1: {
                return 10000;
            }
            case 2: {
                return 14000;
            }
            case 3: {
                return 18000;
            }
        }
        return n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean is\u65b0\u624b(int a2) {
        switch (a2) {
            case 0: 
            case 1000: 
            case 2000: 
            case 2001: 
            case 2002: 
            case 2003: 
            case 2004: 
            case 2005: 
            case 3000: 
            case 3001: 
            case 3002: 
            case 4001: 
            case 4002: 
            case 5000: 
            case 6000: 
            case 6001: 
            case 10000: 
            case 11000: 
            case 13000: 
            case 14000: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean is\u84bc\u9f8d\u4fe0\u5ba2(int a2) {
        return a2 / 10 == 57 || a2 == 508;
    }

    public static /* synthetic */ boolean isDualBlade(int a2) {
        return a2 >= 430 && a2 <= 434;
    }

    public static /* synthetic */ boolean is\u60e1\u9b54\u5fa9\u4ec7\u8005(int a2) {
        return a2 / 10 == 312 || a2 == 3101;
    }

    public static /* synthetic */ boolean is\u6a5f\u7532\u6230\u795e(int a2) {
        return a2 / 100 == 35;
    }

    public static /* synthetic */ boolean is\u7bad\u795e(int a2) {
        return a2 / 10 == 31;
    }

    public static /* synthetic */ boolean is\u5192\u96aa\u5bb6(int a2) {
        return a2 / 1000 == 0;
    }

    public static /* synthetic */ boolean is\u72c2\u72fc\u52c7\u58eb(int a2) {
        return a2 / 100 == 21 || a2 == 2000;
    }

    public static /* synthetic */ boolean is\u5929\u4f7f\u7834\u58de\u8005(int a2) {
        return a2 / 100 == 65 || a2 == 6001;
    }

    public static /* synthetic */ boolean is\u4e3b\u6559(int a2) {
        return a2 / 10 == 23;
    }

    public static /* synthetic */ boolean is\u9670\u967d\u5e2b(int a2) {
        return a2 / 100 == 42 || a2 == 4002;
    }

    public static /* synthetic */ boolean isEvan(int a2) {
        return a2 == 2001 || a2 >= 2200 && a2 <= 2218;
    }

    public static /* synthetic */ boolean isJobFamily(int a2, int a3) {
        return a3 >= a2 && a3 / 100 == a2 / 100;
    }

    public static /* synthetic */ boolean is\u6d77\u76dc(int a2) {
        return MapleJob.getJobBranch(a2) == 5 || MapleJob.getJobBranch(a2) == 6;
    }

    public static /* synthetic */ boolean is\u5091\u8afe(int a2) {
        return a2 / 100 == 36 || a2 == 3002;
    }

    public static /* synthetic */ boolean is\u70c8\u7130\u5deb\u5e2b(int a2) {
        return a2 / 100 == 12;
    }

    public static /* synthetic */ int getSkillBook(int a2, int a3, int a4) {
        if (MapleJob.is\u9f8d\u9b54\u5c0e\u58eb(a2)) {
            if (a3 > 160) {
                return 9;
            }
            if (a3 > 120) {
                return 8;
            }
            if (a3 > 100) {
                return 7;
            }
            if (a3 > 80) {
                return 6;
            }
            if (a3 > 60) {
                return 5;
            }
            if (a3 > 50) {
                return 4;
            }
            if (a3 > 40) {
                return 3;
            }
            if (a3 > 30) {
                return 2;
            }
            if (a3 > 20) {
                return 1;
            }
            return 0;
        }
        if (MapleJob.is\u5f71\u6b66\u8005(a2)) {
            if (a3 > 100) {
                return 5;
            }
            if (a3 > 60) {
                return 4;
            }
            if (a3 > 45) {
                return 3;
            }
            if (a3 > 30) {
                return 2;
            }
            if (a3 > 20) {
                return 1;
            }
            return 0;
        }
        if (JobConstants.isSeparatedSp(a2)) {
            if (a3 > 100) {
                return 3;
            }
            if (a3 > 60) {
                return 2;
            }
            if (a3 > 30) {
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public static /* synthetic */ boolean isJob12000LowLv(int a2) {
        return a2 == 12000 || a2 == 12001 || a2 == 12002;
    }

    public static /* synthetic */ boolean is\u672b\u65e5\u53cd\u6297\u8ecd(int a2) {
        return a2 / 1000 == 3;
    }

    public static /* synthetic */ boolean is\u5927\u9b54\u5c0e\u58eb_\u51b0\u96f7(int a2) {
        return a2 / 10 == 22;
    }

    public static /* synthetic */ boolean is\u5e7b\u5f71\u4fe0\u76dc(int a2) {
        return a2 / 100 == 24 || a2 == 2003;
    }

    public static /* synthetic */ boolean is\u9f8d\u9b54\u5c0e\u58eb(int a2) {
        return a2 == 2001 || a2 >= 2200 && a2 <= 2218;
    }

    public static /* synthetic */ int getJobNumber(int a2) {
        int n2 = a2 % 1000;
        if (n2 / 100 == 0 || JobConstants.isBeginnerJob(a2)) {
            return 0;
        }
        if (n2 / 10 % 10 == 0 || n2 == 501) {
            return 1;
        }
        return 2 + n2 % 10;
    }

    public static /* synthetic */ boolean is\u591c\u5149(int a2) {
        return a2 / 100 == 27 || a2 == 2004;
    }

    public static /* synthetic */ boolean is\u8056\u9a0e\u58eb(int a2) {
        return a2 / 10 == 12;
    }

    public static /* synthetic */ boolean is\u66c9\u306e\u9663(int a2) {
        return a2 / 1000 == 4;
    }

    public static /* synthetic */ boolean isAdventurer(int a2) {
        return a2 >= 0 && a2 < 1000;
    }

    public static /* synthetic */ boolean is\u76ae\u5361\u557e(int a2) {
        return a2 / 100 == 131 || a2 == 13000;
    }

    public static /* synthetic */ boolean is\u62f3\u9738(int a2) {
        return a2 / 10 == 51;
    }

    public static /* synthetic */ boolean is\u5e7b\u7378\u5e2b(int a2) {
        return a2 / 100 == 112 || a2 == 11000;
    }

    public static /* synthetic */ boolean is\u91cd\u7832\u6307\u63ee\u5b98(int a2) {
        return a2 / 10 == 53 || a2 == 501 || a2 == 1;
    }

    public static /* synthetic */ boolean is\u7149\u7344\u5deb\u5e2b(int a2) {
        return a2 / 100 == 32;
    }

    public static /* synthetic */ int getSkillBook(int a2, int a3) {
        return JobConstants.getSkillBook(a2, a3, 0);
    }

    public static /* synthetic */ boolean is\u6697\u591c\u884c\u8005(int a2) {
        return a2 / 100 == 14;
    }

    public static /* synthetic */ boolean is\u60e1\u9b54(int a2) {
        return JobConstants.is\u60e1\u9b54\u6bba\u624b(a2) || JobConstants.is\u60e1\u9b54\u5fa9\u4ec7\u8005(a2) || a2 == 3001;
    }

    public static /* synthetic */ boolean is\u8056\u9b42\u528d\u58eb(int a2) {
        return a2 / 100 == 11;
    }

    public static /* synthetic */ boolean isWildHunter(int a2) {
        return a2 == 3000 || a2 >= 3300 && a2 <= 3312;
    }

    public /* synthetic */ JobConstants() {
        JobConstants a2;
    }

    public static /* synthetic */ boolean is\u5f71\u6b66\u8005(int a2) {
        return a2 / 10 == 43;
    }

    public static /* synthetic */ boolean is\u76dc\u8cca(int a2) {
        return MapleJob.getJobBranch(a2) == 4 || MapleJob.getJobBranch(a2) == 6;
    }

    public static /* synthetic */ boolean is\u795e\u5c04\u624b(int a2) {
        return a2 / 10 == 32;
    }

    public static /* synthetic */ Pair<Integer, Integer> getJobDefaultFaceHair(int a2, int a3) {
        int n2;
        int n3 = a3 == 0 ? 20100 : 21700;
        int n4 = n2 = a3 == 0 ? 30030 : 31002;
        if (JobConstants.is\u5f71\u6b66\u8005(a2)) {
            n3 = a3 == 0 ? 20265 : 21261;
            n2 = a3 == 0 ? 33830 : 34820;
        } else if (JobConstants.is\u84bc\u9f8d\u4fe0\u5ba2(a2)) {
            n3 = a3 == 0 ? 20100 : 21700;
            n2 = a3 == 0 ? 36120 : 34990;
        } else if (JobConstants.is\u7cbe\u9748\u904a\u4fe0(a2)) {
            n3 = a3 == 0 ? 20549 : 21547;
            n2 = a3 == 0 ? 33453 : 34423;
        } else if (JobConstants.is\u5e7b\u5f71\u4fe0\u76dc(a2)) {
            n3 = a3 == 0 ? 20659 : 21656;
            n2 = a3 == 0 ? 33703 : 34703;
        } else if (JobConstants.is\u591c\u5149(a2)) {
            n3 = a3 == 0 ? 20174 : 21169;
            n2 = a3 == 0 ? 36190 : 37070;
        } else if (JobConstants.is\u60e1\u9b54\u6bba\u624b(a2)) {
            n3 = a3 == 0 ? 20248 : 21246;
            n2 = a3 == 0 ? 33531 : 34411;
        } else if (JobConstants.is\u60e1\u9b54\u5fa9\u4ec7\u8005(a2)) {
            n3 = a3 == 0 ? 20248 : 21280;
            n2 = a3 == 0 ? 36460 : 37450;
        } else if (JobConstants.is\u5091\u8afe(a2)) {
            n3 = a3 == 0 ? 20185 : 21182;
            n2 = a3 == 0 ? 36470 : 37490;
        } else if (JobConstants.is\u7c73\u54c8\u9038(a2)) {
            n3 = a3 == 0 ? 20169 : 21700;
            n2 = a3 == 0 ? 36033 : 31002;
        } else if (JobConstants.is\u51f1\u6492(a2)) {
            n3 = a3 == 0 ? 20576 : 21571;
            n2 = a3 == 0 ? 36245 : 37125;
        } else if (JobConstants.is\u5929\u4f7f\u7834\u58de\u8005(a2)) {
            n3 = a3 == 0 ? 20576 : 21374;
            n2 = a3 == 0 ? 36245 : 37242;
        }
        return new Pair<Integer, Integer>(n3, n2);
    }

    public static /* synthetic */ boolean isSeparatedSp(int a2) {
        return a2 / 1000 == 3 || a2 / 100 == 22 || a2 == 2001 || a2 / 100 == 23 || a2 == 2002 || a2 / 100 == 24 || a2 == 2003 || a2 / 100 == 27 || a2 == 2004 || a2 / 100 == 51 || a2 == 5000 || a2 / 100 == 61 || a2 == 6000 || a2 / 100 == 65 || a2 == 6001;
    }

    public static /* synthetic */ boolean is\u8d85\u65b0\u661f(int a2) {
        return a2 / 1000 == 6;
    }

    public static /* synthetic */ boolean isMercedes(int a2) {
        return a2 == 2002 || a2 / 100 == 23;
    }

    public static /* synthetic */ boolean isMihile(int a2) {
        return a2 == 5000 || a2 / 100 == 51;
    }

    public static /* synthetic */ boolean is\u528d\u58eb(int a2) {
        return MapleJob.getJobBranch(a2) == 1;
    }

    public static /* synthetic */ boolean isPhantom(int a2) {
        return a2 == 2003 || a2 / 100 == 24;
    }

    public static /* synthetic */ boolean isResist(int a2) {
        return a2 >= 3000 && a2 <= 3512;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ boolean isBeginnerJob(int a2) {
        switch (a2) {
            case 0: 
            case 1000: 
            case 2000: 
            case 2001: 
            case 2002: 
            case 2003: 
            case 2004: 
            case 2005: 
            case 3000: 
            case 3001: 
            case 3002: 
            case 4001: 
            case 4002: 
            case 5000: 
            case 6000: 
            case 6001: 
            case 10000: 
            case 11000: 
            case 13000: 
            case 14000: {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean is\u9ed1\u9a0e\u58eb(int a2) {
        return a2 / 10 == 13;
    }

    public static /* synthetic */ boolean is\u528d\u8c6a(int a2) {
        return a2 / 100 == 41 || a2 == 4001;
    }

    public static /* synthetic */ boolean isDemon(int a2) {
        return a2 == 3001 || a2 >= 3100 && a2 <= 3112;
    }

    public static /* synthetic */ int getSkillBookBySkill(int a2) {
        return JobConstants.getSkillBookByJob(a2 / 10000, a2);
    }

    public static /* synthetic */ boolean is\u7687\u5bb6\u9a0e\u58eb\u5718(int a2) {
        return a2 / 1000 == 1;
    }

    public static /* synthetic */ boolean is\u591c\u4f7f\u8005(int a2) {
        return a2 / 10 == 41;
    }

    public static /* synthetic */ boolean isJett(int a2) {
        return a2 == 508 || a2 / 10 == 57;
    }

    public static /* synthetic */ int getSkillBookByJob(int a2) {
        return JobConstants.getSkillBookByJob(a2, 0);
    }

    public static /* synthetic */ boolean is\u9583\u96f7\u608d\u5c07(int a2) {
        return a2 / 100 == 15;
    }

    public static /* synthetic */ boolean isAran(int a2) {
        return a2 >= 2000 && a2 <= 2112 && a2 != 2001;
    }

    public static /* synthetic */ boolean is\u60e1\u9b54\u6bba\u624b(int a2) {
        return a2 / 10 == 311 || a2 == 3100;
    }

    public static /* synthetic */ boolean is\u96b1\u6708(int a2) {
        return a2 / 100 == 25 || a2 == 2005;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ boolean is\u521d\u5fc3\u8005(int a2) {
        int n2;
        block4: {
            block3: {
                block2: {
                    if (a2 > 5000) break block2;
                    if (a2 == 5000) return true;
                    if (a2 < 2001) break block3;
                    if (a2 <= 2005) return true;
                    if (a2 <= 3000) break block3;
                    if (a2 <= 3002) return true;
                    if (a2 <= 4000) break block3;
                    if (a2 <= 4002) return true;
                    n2 = a2;
                    break block4;
                }
                if (a2 >= 6000) {
                    if (a2 <= 6001) return true;
                    if (a2 == 13000) {
                        return true;
                    }
                }
            }
            n2 = a2;
        }
        boolean bl = JobConstants.isJob12000(n2);
        if (a2 % 1000 == 0) return true;
        if (a2 / 100 == 8000) return true;
        if (a2 == 8001) return true;
        if (!bl) return bl;
        return true;
    }

    public static /* synthetic */ boolean is\u51f1\u6492(int a2) {
        return a2 / 100 == 61 || a2 == 6000;
    }

    public static /* synthetic */ boolean is\u6cd5\u5e2b(int a2) {
        return MapleJob.getJobBranch(a2) == 2;
    }

    public static /* synthetic */ boolean is\u5f13\u7bad\u624b(int a2) {
        return MapleJob.getJobBranch(a2) == 3;
    }

    public static /* synthetic */ int label17(int a2, int a3) {
        int n2 = a2 / 100;
        if (a2 / 100 <= 21) {
            if (a2 / 100 != 21) {
                int n3 = n2 - 11;
                if (n3 > 0) {
                    int n4 = n3 - 1;
                    if (n4 > 0) {
                        int n5 = n4 - 1;
                        if (n5 > 0) {
                            int n6 = n5 - 1;
                            if (n6 > 0) {
                                if (n6 != 1) {
                                    return 0;
                                }
                                if (a3 < 2) {
                                    if (a3 >= 1) {
                                        return 11500;
                                    }
                                    if (a3 >= 0) {
                                        return 9000;
                                    }
                                    return 0;
                                }
                                return 15000;
                            }
                            if (a3 < 2) {
                                if (a3 < 1) {
                                    if (a3 < 0) {
                                        return 0;
                                    }
                                    return 7000;
                                }
                                return 10000;
                            }
                        } else if (a3 < 2) {
                            if (a3 >= 1) {
                                return 9500;
                            }
                            if (a3 < 0) {
                                return 0;
                            }
                            return 7000;
                        }
                        return 13500;
                    }
                    if (a3 < 2) {
                        if (a3 < 1) {
                            if (a3 >= 0) {
                                return 4500;
                            }
                            return 0;
                        }
                        return 7000;
                    }
                    return 11000;
                }
                if (a3 < 2) {
                    if (a3 < 1) {
                        if (a3 >= 0) {
                            return 9000;
                        }
                        return 0;
                    }
                    return 13500;
                }
                return 20000;
            }
            if (a3 >= 2) {
                return 16000;
            }
            if (a3 < 1) {
                if (a3 >= 0) {
                    return 9000;
                }
                return 0;
            }
            return 13000;
        }
        int n7 = n2 - 22;
        if (n7 > 0) {
            int n8 = n7 - 10;
            if (n8 > 0) {
                int n9 = n8 - 1;
                if (n9 > 0 && n9 != 2) {
                    return 0;
                }
                if (a3 >= 2) {
                    return 11500;
                }
                if (a3 >= 1) {
                    return 9000;
                }
                if (a3 < 0) {
                    return 0;
                }
                return 6000;
            }
            if (a3 >= 2) {
                return 13500;
            }
            if (a3 >= 1) {
                return 11000;
            }
            if (a3 < 0) {
                return 0;
            }
        } else {
            if (a3 >= 2) {
                return 10000;
            }
            if (a3 < 1) {
                if (a3 >= 0) {
                    return 6000;
                }
                return 0;
            }
        }
        return 8000;
    }

    public static /* synthetic */ boolean isCygnus(int a2) {
        return a2 >= 1000 && a2 <= 1512;
    }

    public static /* synthetic */ boolean isKOC(int a2) {
        return a2 >= 1000 && a2 < 2000;
    }

    public static /* synthetic */ boolean is\u6697\u5f71\u795e\u5077(int a2) {
        return a2 / 10 == 42;
    }

    public static /* synthetic */ boolean is\u5927\u9b54\u5c0e\u58eb_\u706b\u6bd2(int a2) {
        return a2 / 10 == 21;
    }

    public static /* synthetic */ boolean is\u7834\u98a8\u4f7f\u8005(int a2) {
        return a2 / 100 == 13;
    }

    public static /* synthetic */ void loadJobLimitLevel() {
        int n2;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList3 = new LinkedList<Integer>();
        LinkedList<Integer> linkedList4 = new LinkedList<Integer>();
        linkedList.add(0);
        linkedList.add(1000);
        linkedList.add(2000);
        linkedList.add(2001);
        linkedList.add(2002);
        linkedList.add(2003);
        linkedList.add(2004);
        linkedList.add(2005);
        linkedList.add(3000);
        linkedList.add(3001);
        linkedList.add(3002);
        linkedList.add(4001);
        linkedList.add(4002);
        linkedList.add(5000);
        linkedList.add(6000);
        linkedList.add(6001);
        linkedList.add(13000);
        linkedList.add(14000);
        linkedList2.add(100);
        linkedList2.add(200);
        linkedList2.add(300);
        linkedList2.add(400);
        linkedList2.add(500);
        linkedList2.add(501);
        linkedList2.add(1100);
        linkedList2.add(1200);
        linkedList2.add(1300);
        linkedList2.add(1400);
        linkedList2.add(1500);
        linkedList2.add(2100);
        linkedList2.add(2200);
        linkedList2.add(2300);
        linkedList2.add(2400);
        linkedList2.add(2500);
        linkedList2.add(2700);
        linkedList2.add(3100);
        linkedList2.add(3200);
        linkedList2.add(3300);
        linkedList2.add(3500);
        linkedList2.add(3600);
        linkedList2.add(3700);
        linkedList2.add(4100);
        linkedList2.add(4200);
        linkedList2.add(5100);
        linkedList2.add(6100);
        linkedList2.add(6500);
        linkedList2.add(11200);
        linkedList2.add(14200);
        linkedList3.add(110);
        linkedList3.add(120);
        linkedList3.add(130);
        linkedList3.add(210);
        linkedList3.add(220);
        linkedList3.add(230);
        linkedList3.add(310);
        linkedList3.add(320);
        linkedList3.add(410);
        linkedList3.add(420);
        linkedList3.add(510);
        linkedList3.add(520);
        linkedList3.add(530);
        linkedList3.add(570);
        linkedList3.add(1110);
        linkedList3.add(1210);
        linkedList3.add(1310);
        linkedList3.add(1410);
        linkedList3.add(1510);
        linkedList3.add(2110);
        linkedList3.add(2310);
        linkedList3.add(2410);
        linkedList3.add(2510);
        linkedList3.add(2710);
        linkedList3.add(3110);
        linkedList3.add(3210);
        linkedList3.add(3310);
        linkedList3.add(3510);
        linkedList3.add(3610);
        linkedList3.add(3710);
        linkedList3.add(4110);
        linkedList3.add(4210);
        linkedList3.add(5110);
        linkedList3.add(6110);
        linkedList3.add(6510);
        linkedList3.add(11210);
        linkedList3.add(14210);
        linkedList4.add(111);
        linkedList4.add(121);
        linkedList4.add(131);
        linkedList4.add(211);
        linkedList4.add(221);
        linkedList4.add(231);
        linkedList4.add(311);
        linkedList4.add(321);
        linkedList4.add(411);
        linkedList4.add(421);
        linkedList4.add(421);
        linkedList4.add(511);
        linkedList4.add(521);
        linkedList4.add(531);
        linkedList4.add(571);
        linkedList4.add(2111);
        linkedList4.add(2311);
        linkedList4.add(2411);
        linkedList4.add(2511);
        linkedList4.add(2711);
        linkedList4.add(3111);
        linkedList4.add(3211);
        linkedList4.add(3311);
        linkedList4.add(3511);
        linkedList4.add(3611);
        linkedList4.add(3711);
        linkedList4.add(4111);
        linkedList4.add(4211);
        linkedList4.add(5111);
        linkedList4.add(6111);
        linkedList4.add(6511);
        linkedList4.add(11211);
        linkedList4.add(14211);
        Iterator iterator = linkedList.iterator();
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator.next();
            ALLATORIxDEMO.put(n2, 10);
            iterator2 = iterator;
        }
        iterator = linkedList2.iterator();
        Iterator iterator3 = iterator;
        while (iterator3.hasNext()) {
            n2 = (Integer)iterator.next();
            ALLATORIxDEMO.put(n2, 30);
            iterator3 = iterator;
        }
        iterator = linkedList3.iterator();
        Iterator iterator4 = iterator;
        while (iterator4.hasNext()) {
            n2 = (Integer)iterator.next();
            ALLATORIxDEMO.put(n2, GameSetConstants.MAPLE_VERSION >= 152 ? 60 : 70);
            iterator4 = iterator;
        }
        iterator = linkedList4.iterator();
        Iterator iterator5 = iterator;
        while (iterator5.hasNext()) {
            n2 = (Integer)iterator.next();
            ALLATORIxDEMO.put(n2, GameSetConstants.MAPLE_VERSION >= 152 ? 100 : 120);
            iterator5 = iterator;
        }
    }

    public static /* synthetic */ boolean is\u7c73\u54c8\u9038(int a2) {
        return a2 / 100 == 51 || a2 == 5000;
    }

    public static /* synthetic */ boolean is\u795e\u4e4b\u5b50(int a2) {
        return a2 == 10000 || a2 == 10100 || a2 == 10110 || a2 == 10111 || a2 == 10112;
    }

    public static /* synthetic */ int getSkillBookByJob(int a2, int a3) {
        if (MapleJob.isBeginner(a2)) {
            return 0;
        }
        if (JobConstants.isSeparatedSp(a2)) {
            return MapleJob.getNumber(a2) - 1;
        }
        return 0;
    }

    public static /* synthetic */ boolean isJob12000(int a2) {
        boolean bl = JobConstants.isJob12000HighLv(a2);
        if (JobConstants.isJob12000LowLv(a2) || bl) {
            bl = true;
        }
        return bl;
    }

    public static /* synthetic */ boolean is\u69cd\u795e(int a2) {
        return a2 / 10 == 52;
    }

    public static /* synthetic */ boolean is\u72c2\u8c79\u7375\u4eba(int a2) {
        return a2 / 100 == 33;
    }

    public static /* synthetic */ boolean is\u7ba1\u7406\u54e1(int a2) {
        return a2 == 800 || a2 == 900 || a2 == 910;
    }

    public static /* synthetic */ boolean is\u7cbe\u9748\u904a\u4fe0(int a2) {
        return a2 == 2002 || a2 / 100 == 23;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new HashMap();
    }

    public static /* synthetic */ boolean is\u5e02\u6c11(int a2) {
        return a2 == 3000;
    }
}

