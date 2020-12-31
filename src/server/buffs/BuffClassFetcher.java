/*
 * Decompiled with CFR 0.150.
 */
package server.buffs;

import handling.opcodes.MapleBuffStat;
import java.util.ArrayList;
import server.MapleStatEffect;
import server.buffs.AbstractBuffClass;
import server.buffs.adventurer.BowmanBuff;
import server.buffs.adventurer.MagicianBuff;
import server.buffs.adventurer.PirateBuff;
import server.buffs.adventurer.ThiefBuff;
import server.buffs.adventurer.WarriorBuff;
import server.buffs.cygnus.BlazeWizardBuff;
import server.buffs.cygnus.DawnWarriorBuff;
import server.buffs.cygnus.MihileBuff;
import server.buffs.cygnus.NightWalkerBuff;
import server.buffs.cygnus.ThunderBreakerBuff;
import server.buffs.cygnus.WindArcherBuff;
import server.buffs.gamemaster.GameMasterBuff;
import server.buffs.hero.AranBuff;
import server.buffs.hero.EvanBuff;
import server.buffs.hero.MercedesBuff;
import server.buffs.hero.PhantomBuff;
import server.buffs.nova.AngelicBusterBuff;
import server.buffs.nova.KaiserBuff;
import server.buffs.nova.LuminousBuff;
import server.buffs.resistance.BattleMageBuff;
import server.buffs.resistance.DemonBuff;
import server.buffs.resistance.MechanicBuff;
import server.buffs.resistance.WildHunterBuff;
import tools.Pair;

public class BuffClassFetcher {
    public static final /* synthetic */ Class<?>[] buffClasses;

    public /* synthetic */ BuffClassFetcher() {
        BuffClassFetcher a2;
    }

    public static /* synthetic */ ArrayList<Pair<MapleBuffStat, Integer>> getHandleMethod(MapleStatEffect a2, int a3) {
        int n2;
        int n3 = a3 / 10000;
        Class<?>[] arrclass = buffClasses;
        int n4 = buffClasses.length;
        int n5 = n2 = 0;
        while (n5 < n4) {
            block6: {
                ArrayList<Pair<MapleBuffStat, Integer>> arrayList;
                Class<?> class_ = arrclass[n2];
                if (!AbstractBuffClass.class.isAssignableFrom(class_)) break block6;
                AbstractBuffClass abstractBuffClass = (AbstractBuffClass)class_.newInstance();
                if (!abstractBuffClass.containsJob(n3) || (arrayList = abstractBuffClass.handleBuff(a2, a3)).size() == 0) break block6;
                try {
                    return arrayList;
                }
                catch (IllegalAccessException | InstantiationException reflectiveOperationException) {
                    System.err.println("Error: handleBuff method was not found in " + class_.getSimpleName() + ".class");
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            n5 = ++n2;
        }
        return null;
    }

    public static /* synthetic */ void load(boolean a2) {
        int n2;
        Class<?>[] arrclass = buffClasses;
        int n3 = buffClasses.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            Class<?> class_ = arrclass[n2++];
            n4 = n2;
        }
    }

    public static /* synthetic */ {
        Class[] arrclass = new Class[25];
        arrclass[0] = MagicianBuff.class;
        arrclass[1] = WarriorBuff.class;
        arrclass[2] = WarriorBuff.class;
        arrclass[3] = MagicianBuff.class;
        arrclass[4] = BowmanBuff.class;
        arrclass[5] = ThiefBuff.class;
        arrclass[6] = PirateBuff.class;
        arrclass[7] = GameMasterBuff.class;
        arrclass[8] = DawnWarriorBuff.class;
        arrclass[9] = BlazeWizardBuff.class;
        arrclass[10] = NightWalkerBuff.class;
        arrclass[11] = WindArcherBuff.class;
        arrclass[12] = ThunderBreakerBuff.class;
        arrclass[13] = AranBuff.class;
        arrclass[14] = EvanBuff.class;
        arrclass[15] = MercedesBuff.class;
        arrclass[16] = PhantomBuff.class;
        arrclass[17] = DemonBuff.class;
        arrclass[18] = BattleMageBuff.class;
        arrclass[19] = WildHunterBuff.class;
        arrclass[20] = MechanicBuff.class;
        arrclass[21] = MihileBuff.class;
        arrclass[22] = LuminousBuff.class;
        arrclass[23] = KaiserBuff.class;
        arrclass[24] = AngelicBusterBuff.class;
        buffClasses = arrclass;
    }
}

