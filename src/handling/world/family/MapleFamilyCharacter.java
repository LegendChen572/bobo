/*
 * Decompiled with CFR 0.150.
 */
package handling.world.family;

import client.MapleCharacter;
import handling.world.family.MapleFamily;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapleFamilyCharacter
implements Serializable {
    private /* synthetic */ int M;
    private /* synthetic */ int ALLATORIxDEMO;
    private /* synthetic */ int e;
    private /* synthetic */ int F;
    private /* synthetic */ int E;
    private /* synthetic */ int I;
    private /* synthetic */ int C;
    private /* synthetic */ String a;
    private /* synthetic */ int B;
    private /* synthetic */ int H;
    private /* synthetic */ List<Integer> d;
    private /* synthetic */ int g;
    private /* synthetic */ boolean K;
    public static final /* synthetic */ long serialVersionUID = 2058609046116597760L;
    private /* synthetic */ int k;

    public /* synthetic */ int resetDescendants(MapleFamily a2) {
        MapleFamilyCharacter mapleFamilyCharacter;
        MapleFamilyCharacter a3;
        a3.ALLATORIxDEMO = 0;
        if (a3.B > 0 && (mapleFamilyCharacter = a2.getMFC(a3.B)) != null) {
            a3.ALLATORIxDEMO += 1 + mapleFamilyCharacter.resetDescendants(a2);
        }
        if (a3.k > 0 && (mapleFamilyCharacter = a2.getMFC(a3.k)) != null) {
            a3.ALLATORIxDEMO += 1 + mapleFamilyCharacter.resetDescendants(a2);
        }
        return a3.ALLATORIxDEMO;
    }

    public /* synthetic */ void setFamilyId(int a2) {
        a.H = a2;
    }

    public /* synthetic */ void setOnline(boolean a2) {
        a.K = a2;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4 << 3 ^ 4;
        int cfr_ignored_0 = 2 << 3 ^ 5;
        int n5 = n3;
        int n6 = 4 << 4 ^ 1 << 1;
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

    public /* synthetic */ void setTotalRep(int a2) {
        a.g = a2;
    }

    public /* synthetic */ int getTotalRep() {
        MapleFamilyCharacter a2;
        return a2.g;
    }

    public /* synthetic */ List<Integer> getPedigree() {
        MapleFamilyCharacter a2;
        return a2.d;
    }

    public /* synthetic */ int getCurrentRep() {
        MapleFamilyCharacter a2;
        return a2.E;
    }

    public /* synthetic */ int getJunior1() {
        MapleFamilyCharacter a2;
        return a2.B;
    }

    public /* synthetic */ int getFamilyId() {
        MapleFamilyCharacter a2;
        return a2.H;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public /* synthetic */ void resetPedigree(MapleFamily a) {
        a.d = new ArrayList<Integer>();
        v0 = a;
        a.d.add(v0.I);
        if (v0.e <= 0 || (var2_2 = a.getMFC(a.e)) == null) ** GOTO lbl23
        v1 = a;
        v1.d.add(v1.e);
        if (var2_2.getSeniorId() > 0) {
            a.d.add(var2_2.getSeniorId());
        }
        if (var2_2.getJunior1() > 0 && var2_2.getJunior1() != a.I) {
            v2 = a;
            v3 = v2;
            v2.d.add(var2_2.getJunior1());
        } else {
            if (var2_2.getJunior2() > 0 && var2_2.getJunior2() != a.I) {
                a.d.add(var2_2.getJunior2());
            }
lbl23:
            // 4 sources

            v3 = a;
        }
        if (v3.B > 0 && (var2_2 = a.getMFC(a.B)) != null) {
            v4 = a;
            v4.d.add(v4.B);
            if (var2_2.getJunior1() > 0) {
                a.d.add(var2_2.getJunior1());
            }
            if (var2_2.getJunior2() > 0) {
                a.d.add(var2_2.getJunior2());
            }
        }
        if (a.k <= 0) return;
        var2_2 = a.getMFC(a.k);
        if (var2_2 == null) return;
        v5 = a;
        v5.d.add(v5.k);
        if (var2_2.getJunior1() > 0) {
            a.d.add(var2_2.getJunior1());
        }
        if (var2_2.getJunior2() <= 0) return;
        a.d.add(var2_2.getJunior2());
    }

    public /* synthetic */ void setCurrentRep(int a2) {
        a.E = a2;
    }

    public /* synthetic */ void setJunior2(int a2) {
        a.k = a2;
    }

    public /* synthetic */ int getDescendants() {
        MapleFamilyCharacter a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ boolean isOnline() {
        MapleFamilyCharacter a2;
        return a2.K;
    }

    public /* synthetic */ List<MapleFamilyCharacter> getOnlineJuniors(MapleFamily a2) {
        MapleFamilyCharacter mapleFamilyCharacter;
        MapleFamilyCharacter mapleFamilyCharacter2;
        MapleFamilyCharacter a3;
        ArrayList<MapleFamilyCharacter> arrayList = new ArrayList<MapleFamilyCharacter>();
        MapleFamilyCharacter mapleFamilyCharacter3 = a3;
        arrayList.add(mapleFamilyCharacter3);
        if (mapleFamilyCharacter3.B > 0 && (mapleFamilyCharacter2 = a2.getMFC(a3.B)) != null) {
            if (mapleFamilyCharacter2.isOnline()) {
                arrayList.add(mapleFamilyCharacter2);
            }
            if (mapleFamilyCharacter2.getJunior1() > 0 && (mapleFamilyCharacter = a2.getMFC(mapleFamilyCharacter2.getJunior1())) != null && mapleFamilyCharacter.isOnline()) {
                arrayList.add(mapleFamilyCharacter);
            }
            if (mapleFamilyCharacter2.getJunior2() > 0 && (mapleFamilyCharacter = a2.getMFC(mapleFamilyCharacter2.getJunior2())) != null && mapleFamilyCharacter.isOnline()) {
                arrayList.add(mapleFamilyCharacter);
            }
        }
        if (a3.k > 0 && (mapleFamilyCharacter2 = a2.getMFC(a3.k)) != null) {
            if (mapleFamilyCharacter2.isOnline()) {
                arrayList.add(mapleFamilyCharacter2);
            }
            if (mapleFamilyCharacter2.getJunior1() > 0 && (mapleFamilyCharacter = a2.getMFC(mapleFamilyCharacter2.getJunior1())) != null && mapleFamilyCharacter.isOnline()) {
                arrayList.add(mapleFamilyCharacter);
            }
            if (mapleFamilyCharacter2.getJunior2() > 0 && (mapleFamilyCharacter = a2.getMFC(mapleFamilyCharacter2.getJunior2())) != null && mapleFamilyCharacter.isOnline()) {
                arrayList.add(mapleFamilyCharacter);
            }
        }
        return arrayList;
    }

    public /* synthetic */ int getJunior2() {
        MapleFamilyCharacter a2;
        return a2.k;
    }

    public /* synthetic */ boolean equals(Object a2) {
        MapleFamilyCharacter a3;
        if (!(a2 instanceof MapleFamilyCharacter)) {
            return false;
        }
        return ((MapleFamilyCharacter)(a2 = (MapleFamilyCharacter)a2)).getId() == a3.I && ((MapleFamilyCharacter)a2).getName().equals(a3.a);
    }

    public /* synthetic */ int resetGenerations(MapleFamily a2) {
        int n2;
        MapleFamilyCharacter mapleFamilyCharacter;
        MapleFamilyCharacter a3;
        int n3 = 0;
        int n4 = 0;
        if (a3.B > 0 && (mapleFamilyCharacter = a2.getMFC(a3.B)) != null) {
            n3 = mapleFamilyCharacter.resetGenerations(a2);
        }
        if (a3.k > 0 && (mapleFamilyCharacter = a2.getMFC(a3.k)) != null) {
            n4 = mapleFamilyCharacter.resetGenerations(a2);
        }
        return n2 + ((n2 = Math.max(n3, n4)) > 0 ? 1 : 0);
    }

    public /* synthetic */ void setChannel(int a2) {
        a.F = a2;
    }

    public /* synthetic */ void setSeniorId(int a2) {
        a.e = a2;
    }

    public /* synthetic */ void setJunior1(int a2) {
        a.B = a2;
    }

    public /* synthetic */ void setJobId(int a2) {
        a.C = a2;
    }

    public /* synthetic */ String getName() {
        MapleFamilyCharacter a2;
        return a2.a;
    }

    public /* synthetic */ int getLevel() {
        MapleFamilyCharacter a2;
        return a2.M;
    }

    public /* synthetic */ void setLevel(int a2) {
        a.M = a2;
    }

    public /* synthetic */ int getSeniorId() {
        MapleFamilyCharacter a2;
        return a2.e;
    }

    public /* synthetic */ MapleFamilyCharacter(int a2, int a3, String a4, int a5, int a6, int a7, int a8, int a9, int a10, int a11, int a12, boolean a13) {
        MapleFamilyCharacter a14;
        MapleFamilyCharacter mapleFamilyCharacter = a14;
        MapleFamilyCharacter mapleFamilyCharacter2 = a14;
        a14.F = -1;
        MapleFamilyCharacter mapleFamilyCharacter3 = a14;
        a14.d = new ArrayList<Integer>();
        mapleFamilyCharacter2.ALLATORIxDEMO = 0;
        mapleFamilyCharacter2.M = a3;
        mapleFamilyCharacter.I = a2;
        mapleFamilyCharacter.a = a4;
        if (a13) {
            a14.F = a5;
        }
        MapleFamilyCharacter mapleFamilyCharacter4 = a14;
        MapleFamilyCharacter mapleFamilyCharacter5 = a14;
        MapleFamilyCharacter mapleFamilyCharacter6 = a14;
        a14.C = a6;
        mapleFamilyCharacter6.K = a13;
        mapleFamilyCharacter6.H = a7;
        mapleFamilyCharacter5.e = a8;
        mapleFamilyCharacter5.E = a11;
        mapleFamilyCharacter4.g = a12;
        mapleFamilyCharacter4.B = a9;
        a14.k = a10;
    }

    public /* synthetic */ List<MapleFamilyCharacter> getAllJuniors(MapleFamily a2) {
        MapleFamilyCharacter mapleFamilyCharacter;
        MapleFamilyCharacter a3;
        ArrayList<MapleFamilyCharacter> arrayList = new ArrayList<MapleFamilyCharacter>();
        MapleFamilyCharacter mapleFamilyCharacter2 = a3;
        arrayList.add(mapleFamilyCharacter2);
        if (mapleFamilyCharacter2.B > 0 && (mapleFamilyCharacter = a2.getMFC(a3.B)) != null) {
            arrayList.addAll(mapleFamilyCharacter.getAllJuniors(a2));
        }
        if (a3.k > 0 && (mapleFamilyCharacter = a2.getMFC(a3.k)) != null) {
            arrayList.addAll(mapleFamilyCharacter.getAllJuniors(a2));
        }
        return arrayList;
    }

    public /* synthetic */ int getJobId() {
        MapleFamilyCharacter a2;
        return a2.C;
    }

    public /* synthetic */ MapleFamilyCharacter(MapleCharacter a2, int a3, int a4, int a5, int a6) {
        MapleFamilyCharacter a7;
        MapleFamilyCharacter mapleFamilyCharacter = a7;
        MapleCharacter mapleCharacter = a2;
        MapleFamilyCharacter mapleFamilyCharacter2 = a7;
        MapleFamilyCharacter mapleFamilyCharacter3 = a7;
        MapleFamilyCharacter mapleFamilyCharacter4 = a7;
        MapleCharacter mapleCharacter2 = a2;
        MapleFamilyCharacter mapleFamilyCharacter5 = a7;
        MapleFamilyCharacter mapleFamilyCharacter6 = a7;
        mapleFamilyCharacter6.F = -1;
        MapleFamilyCharacter mapleFamilyCharacter7 = a7;
        mapleFamilyCharacter6.d = new ArrayList<Integer>();
        mapleFamilyCharacter6.ALLATORIxDEMO = 0;
        mapleFamilyCharacter5.a = a2.getName();
        mapleFamilyCharacter5.M = a2.getLevel();
        a7.I = mapleCharacter2.getId();
        mapleFamilyCharacter4.F = mapleCharacter2.getClient().getChannel();
        mapleFamilyCharacter4.C = a2.getJob();
        mapleFamilyCharacter3.H = a3;
        mapleFamilyCharacter3.B = a5;
        mapleFamilyCharacter2.k = a6;
        mapleFamilyCharacter2.e = a4;
        a7.E = mapleCharacter.getCurrentRep();
        mapleFamilyCharacter.g = mapleCharacter.getTotalRep();
        mapleFamilyCharacter.K = true;
    }

    public /* synthetic */ int getNoJuniors() {
        MapleFamilyCharacter a2;
        int n2 = 0;
        if (a2.B > 0) {
            ++n2;
        }
        if (a2.k > 0) {
            ++n2;
        }
        return n2;
    }

    public /* synthetic */ int getId() {
        MapleFamilyCharacter a2;
        return a2.I;
    }

    public /* synthetic */ int getChannel() {
        MapleFamilyCharacter a2;
        return a2.F;
    }
}

