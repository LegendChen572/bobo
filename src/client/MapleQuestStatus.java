/*
 * Decompiled with CFR 0.150.
 */
package client;

import constants.GameConstants;
import handling.world.sidekick.MapleSidekick;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import server.life.MapleLifeFactory;
import server.quest.MapleQuest;

public class MapleQuestStatus
implements Serializable {
    private /* synthetic */ Map<Integer, Integer> k;
    private static final /* synthetic */ long E = 91795419934134L;
    private /* synthetic */ long a;
    private /* synthetic */ int d;
    private /* synthetic */ int K;
    private /* synthetic */ String ALLATORIxDEMO;
    private /* synthetic */ byte B;
    private final transient /* synthetic */ MapleQuest g;

    public final /* synthetic */ void setMobKills(int a2, int a3) {
        MapleQuestStatus a4;
        if (a4.k == null) {
            a4.ALLATORIxDEMO();
        }
        a4.k.put(a2, a3);
    }

    public /* synthetic */ boolean isCustom() {
        MapleQuestStatus a2;
        return GameConstants.isCustomQuest(a2.g.getId());
    }

    public /* synthetic */ MapleQuestStatus(MapleQuest a2, byte a3, int a4) {
        MapleQuestStatus a5;
        MapleQuestStatus mapleQuestStatus = a5;
        MapleQuestStatus mapleQuestStatus2 = a5;
        a5.k = null;
        mapleQuestStatus2.d = 0;
        mapleQuestStatus2.g = a2;
        mapleQuestStatus.setStatus(a3);
        mapleQuestStatus.setNpc(a4);
        mapleQuestStatus.a = System.currentTimeMillis();
        if (a3 == 1 && !a2.getRelevantMobs().isEmpty()) {
            a5.ALLATORIxDEMO();
        }
    }

    public final /* synthetic */ void setForfeited(int a2) {
        MapleQuestStatus a3;
        if (a2 >= a3.d) {
            a3.d = a2;
            return;
        }
        throw new IllegalArgumentException(MapleSidekick.ALLATORIxDEMO(" \u0011\rW\u0017P\u0010\u0015\u0017P\u0005\u001f\u0011\u0016\u0006\u0019\u0017\u0003C\u0004\fP\u0010\u001f\u000e\u0015\u0017\u0018\n\u001e\u0004P\u000f\u001f\u0014\u0015\u0011P\u0017\u0018\u0002\u001eC\u0012\u0006\u0016\f\u0002\u0006^"));
    }

    public final /* synthetic */ void setCustomData(String a2) {
        a.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ int getNpc() {
        MapleQuestStatus a2;
        return a2.K;
    }

    public final /* synthetic */ byte getStatus() {
        MapleQuestStatus a2;
        return a2.B;
    }

    public final /* synthetic */ boolean mobKilled(int a2, int a322) {
        MapleQuestStatus a4;
        if (a4.g != null && a4.g.getSkillID() > 0 && a4.g.getSkillID() != a322) {
            return false;
        }
        Map.Entry<Integer, Integer> a322 = a4.k.get(a2);
        if (a322 != null) {
            int n2 = a4.ALLATORIxDEMO(a2);
            if ((Integer)((Object)a322) >= n2) {
                return false;
            }
            a4.k.put(a2, Math.min((Integer)((Object)a322) + 1, n2));
            return true;
        }
        for (Map.Entry<Integer, Integer> a322 : a4.k.entrySet()) {
            if (!a4.ALLATORIxDEMO((Integer)a322.getKey(), a2)) continue;
            int n3 = a4.ALLATORIxDEMO((Integer)a322.getKey());
            if ((Integer)a322.getValue() >= n3) {
                return false;
            }
            a4.k.put((Integer)a322.getKey(), Math.min((Integer)a322.getValue() + 1, n3));
            return true;
        }
        return false;
    }

    public final /* synthetic */ int getMobKills(int a22) {
        MapleQuestStatus a3;
        Integer a22 = a3.k.get(a22);
        if (a22 == null) {
            return 0;
        }
        return a22;
    }

    public /* synthetic */ MapleQuestStatus(MapleQuest a2, byte a3) {
        MapleQuestStatus a4;
        byte by = a3;
        MapleQuestStatus mapleQuestStatus = a4;
        a4.k = null;
        mapleQuestStatus.d = 0;
        mapleQuestStatus.g = a2;
        a4.setStatus(by);
        a4.a = System.currentTimeMillis();
        if (by == 1 && !a2.getRelevantMobs().isEmpty()) {
            a4.ALLATORIxDEMO();
        }
    }

    public final /* synthetic */ int getForfeited() {
        MapleQuestStatus a2;
        return a2.d;
    }

    public final /* synthetic */ void setStatus(byte a2) {
        a.B = a2;
    }

    public final /* synthetic */ void setCompletionTime(long a2) {
        a.a = a2;
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        MapleQuestStatus a2;
        Iterator<Integer> iterator;
        a2.k = new LinkedHashMap<Integer, Integer>();
        Iterator<Integer> iterator2 = iterator = a2.g.getRelevantMobs().keySet().iterator();
        while (iterator2.hasNext()) {
            int n2 = iterator.next();
            iterator2 = iterator;
            a2.k.put(n2, 0);
        }
    }

    private /* synthetic */ int ALLATORIxDEMO(int a2) {
        MapleQuestStatus a3;
        for (Map.Entry<Integer, Integer> entry : a3.g.getRelevantMobs().entrySet()) {
            if (entry.getKey() != a2) continue;
            return entry.getValue();
        }
        return 0;
    }

    public final /* synthetic */ String getCustomData() {
        MapleQuestStatus a2;
        return a2.ALLATORIxDEMO;
    }

    public final /* synthetic */ void setNpc(int a2) {
        a.K = a2;
    }

    public final /* synthetic */ boolean hasMobKills() {
        MapleQuestStatus a2;
        if (a2.k == null) {
            return false;
        }
        return a2.k.size() > 0;
    }

    public final /* synthetic */ MapleQuest getQuest() {
        MapleQuestStatus a2;
        return a2.g;
    }

    private /* synthetic */ boolean ALLATORIxDEMO(int a22, int a3) {
        if (MapleLifeFactory.getQuestCount(a22) != null) {
            Iterator<Integer> a22 = MapleLifeFactory.getQuestCount(a22).iterator();
            while (a22.hasNext()) {
                if (a22.next() != a3) continue;
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Map<Integer, Integer> getMobKills() {
        MapleQuestStatus a2;
        return a2.k;
    }

    public final /* synthetic */ long getCompletionTime() {
        MapleQuestStatus a2;
        return a2.a;
    }
}

