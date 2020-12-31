/*
 * Decompiled with CFR 0.150.
 */
package client.status;

import client.MapleCharacter;
import client.status.MonsterStatus;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledFuture;
import server.life.MapleMonster;
import server.life.MobSkill;

public class MonsterStatusEffect {
    private /* synthetic */ long d;
    private /* synthetic */ MonsterStatus C;
    private /* synthetic */ int k;
    private /* synthetic */ boolean K;
    private /* synthetic */ WeakReference<MapleCharacter> g;
    private final /* synthetic */ MobSkill e;
    private /* synthetic */ ScheduledFuture<?> ALLATORIxDEMO;
    private final /* synthetic */ boolean E;
    private /* synthetic */ long a;
    private final /* synthetic */ int H;
    private /* synthetic */ Integer B;

    public /* synthetic */ MonsterStatusEffect(MonsterStatus a2, Integer a3, int a4, MobSkill a5, boolean a6, boolean a7) {
        MonsterStatusEffect a8;
        MonsterStatusEffect monsterStatusEffect = a8;
        MonsterStatusEffect monsterStatusEffect2 = a8;
        MonsterStatusEffect monsterStatusEffect3 = a8;
        MonsterStatusEffect monsterStatusEffect4 = a8;
        MonsterStatusEffect monsterStatusEffect5 = a8;
        a8.g = null;
        monsterStatusEffect5.k = 0;
        monsterStatusEffect5.K = false;
        monsterStatusEffect4.a = 0L;
        monsterStatusEffect4.C = a2;
        monsterStatusEffect3.H = a4;
        monsterStatusEffect3.E = a6;
        monsterStatusEffect2.e = a5;
        monsterStatusEffect2.B = a3;
        monsterStatusEffect.K = a7;
        monsterStatusEffect.d = 0L;
    }

    public final /* synthetic */ void setValue(MonsterStatus a2, Integer a3) {
        MonsterStatusEffect a4;
        MonsterStatusEffect monsterStatusEffect = a4;
        monsterStatusEffect.C = a2;
        monsterStatusEffect.B = a3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ int genericSkill(MonsterStatus a2) {
        switch (1.ALLATORIxDEMO[a2.ordinal()]) {
            case 1: {
                return 90001001;
            }
            case 2: {
                return 90001002;
            }
            case 3: {
                return 90001003;
            }
            case 4: {
                return 90001004;
            }
            case 5: {
                return 90001005;
            }
            case 6: {
                return 90001006;
            }
            case 7: {
                return 1111007;
            }
            case 8: {
                return 4121003;
            }
            case 9: {
                return 22161002;
            }
            case 10: {
                return 4111003;
            }
            case 11: {
                return 5211004;
            }
            case 12: {
                return 2311005;
            }
            case 13: {
                return 4121004;
            }
        }
        return 0;
    }

    public final /* synthetic */ void setCancelTask(long a2) {
        a.a = System.currentTimeMillis() + a2;
    }

    public /* synthetic */ void setX(int a2) {
        a.B = a2;
    }

    public final /* synthetic */ Integer getX() {
        MonsterStatusEffect a2;
        return a2.B;
    }

    public final /* synthetic */ int getPoisonDamage() {
        MonsterStatusEffect a2;
        return a2.k;
    }

    public final /* synthetic */ MapleCharacter getFromCharacter() {
        MonsterStatusEffect a2;
        if (a2.g == null) {
            return null;
        }
        return (MapleCharacter)a2.g.get();
    }

    public /* synthetic */ MonsterStatusEffect(MonsterStatus a2, Integer a3, int a4, MobSkill a5, boolean a6) {
        MonsterStatusEffect a7;
        MonsterStatusEffect monsterStatusEffect = a7;
        MonsterStatusEffect monsterStatusEffect2 = a7;
        MonsterStatusEffect monsterStatusEffect3 = a7;
        MonsterStatusEffect monsterStatusEffect4 = a7;
        MonsterStatusEffect monsterStatusEffect5 = a7;
        monsterStatusEffect5.g = null;
        monsterStatusEffect5.k = 0;
        monsterStatusEffect4.K = 0;
        monsterStatusEffect4.a = 0L;
        monsterStatusEffect3.C = a2;
        monsterStatusEffect3.H = a4;
        monsterStatusEffect2.E = a6;
        monsterStatusEffect2.e = a5;
        monsterStatusEffect.B = a3;
        monsterStatusEffect.d = 0L;
    }

    public final /* synthetic */ MonsterStatus getStatus() {
        MonsterStatusEffect a2;
        return a2.C;
    }

    public /* synthetic */ long getDotTime() {
        MonsterStatusEffect a2;
        return a2.d;
    }

    public /* synthetic */ void setDotTime(long a2) {
        a.d = a2;
    }

    public final /* synthetic */ int getSkill() {
        MonsterStatusEffect a2;
        return a2.H;
    }

    public final /* synthetic */ long getCancelTask() {
        MonsterStatusEffect a2;
        return a2.a;
    }

    public final /* synthetic */ void cancelTask() {
        a.a = 0L;
    }

    public final /* synthetic */ void setPoisonDamage(int a2, MapleCharacter a3) {
        MonsterStatusEffect a4;
        a4.k = a2;
        MonsterStatusEffect monsterStatusEffect = a4;
        monsterStatusEffect.g = new WeakReference<MapleCharacter>(a3);
    }

    public final /* synthetic */ void cancelPoisonSchedule(MapleMonster a2) {
        MonsterStatusEffect a3;
        MonsterStatusEffect monsterStatusEffect = a3;
        monsterStatusEffect.k = 0;
        monsterStatusEffect.g = null;
    }

    public final /* synthetic */ boolean isReflect() {
        MonsterStatusEffect a2;
        return a2.K;
    }

    public final /* synthetic */ int getFromID() {
        MonsterStatusEffect a2;
        if (a2.g == null || a2.g.get() == null) {
            return 0;
        }
        return ((MapleCharacter)a2.g.get()).getId();
    }

    public final /* synthetic */ boolean shouldCancel(long a2) {
        MonsterStatusEffect a3;
        return a3.a > 0L && a3.a <= a2;
    }

    public final /* synthetic */ void cancelPoisonSchedule() {
        block3: {
            MonsterStatusEffect monsterStatusEffect;
            MonsterStatusEffect a2;
            if (a2.ALLATORIxDEMO != null) {
                try {
                    a2.ALLATORIxDEMO.cancel(false);
                    monsterStatusEffect = a2;
                    break block3;
                }
                catch (NullPointerException nullPointerException) {
                    // empty catch block
                }
            }
            monsterStatusEffect = a2;
        }
        monsterStatusEffect.ALLATORIxDEMO = null;
    }

    public final /* synthetic */ boolean isMonsterSkill() {
        MonsterStatusEffect a2;
        return a2.E;
    }

    public final /* synthetic */ void setPoisonSchedule(ScheduledFuture<?> a2) {
        a.ALLATORIxDEMO = a2;
    }

    public final /* synthetic */ MobSkill getMobSkill() {
        MonsterStatusEffect a2;
        return a2.e;
    }
}

