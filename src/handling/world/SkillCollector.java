/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import constants.SkillConstants;
import java.util.Iterator;
import java.util.LinkedList;
import server.Timer;
import server.maps.MapleNodes;
import tools.ExternalCodeLongTableGetter;
import tools.FileoutputUtil;

public class SkillCollector {
    private final /* synthetic */ LinkedList<Integer> d;
    private static final /* synthetic */ SkillCollector K;
    private final /* synthetic */ LinkedList<Integer> a;
    private final /* synthetic */ LinkedList<Integer> ALLATORIxDEMO;

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ boolean isExistSkill(int a2, int a3) {
        boolean bl = false;
        if (a3 / 10000000 == 3) return true;
        if (a3 / 100000 == 43) {
            return true;
        }
        switch (a2) {
            case 1: {
                return SkillConstants.isCloseRangedAttack(a3);
            }
            case 2: {
                return SkillConstants.isRangedAttack(a3);
            }
            case 3: {
                return SkillConstants.isMagicAttack(a3);
            }
            case 4: {
                return SkillConstants.isSpecialMove(a3);
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void addSkill(int a2, int a3) {
        SkillCollector a4;
        boolean bl;
        boolean bl2 = false;
        switch (a2) {
            case 1: {
                bl = bl2 = SkillConstants.isCloseRangedAttack(a3);
                break;
            }
            case 2: {
                bl = bl2 = SkillConstants.isRangedAttack(a3);
                break;
            }
            case 3: {
                bl2 = SkillConstants.isMagicAttack(a3);
            }
            default: {
                bl = bl2;
            }
        }
        if (!bl && !a4.ALLATORIxDEMO(a2).contains(a3)) {
            a4.ALLATORIxDEMO(a2).add(a3);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private /* synthetic */ LinkedList<Integer> ALLATORIxDEMO(int a2) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        switch (a2) {
            case 1: {
                SkillCollector a3;
                return a3.a;
            }
            case 2: {
                SkillCollector a3;
                return a3.d;
            }
            case 3: {
                SkillCollector a3;
                return a3.ALLATORIxDEMO;
            }
        }
        return linkedList;
    }

    public static /* synthetic */ {
        K = new SkillCollector();
    }

    public /* synthetic */ void init() {
        Timer.WorldTimer.getInstance().register(new run(), 10800000L);
    }

    public /* synthetic */ void outputList() {
        int n2;
        SkillCollector a2;
        Iterator iterator;
        Object object = ExternalCodeLongTableGetter.ALLATORIxDEMO("_a");
        Iterator iterator2 = iterator = a2.a.iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator.next();
            object = (String)object + ", " + n2;
            iterator2 = iterator;
        }
        if (!a2.a.isEmpty()) {
            FileoutputUtil.logToFile("logs/Data/\u653b\u64ca\u5206\u985e/\u8fd1\u8ddd\u96e2\u653b\u64ca_" + FileoutputUtil.getChineseData() + ".txt", (String)object);
        }
        object = MapleNodes.ALLATORIxDEMO("\u0003&");
        iterator = a2.d.iterator();
        Iterator iterator3 = iterator;
        while (iterator3.hasNext()) {
            n2 = (Integer)iterator.next();
            object = (String)object + ", " + n2;
            iterator3 = iterator;
        }
        if (!a2.d.isEmpty()) {
            FileoutputUtil.logToFile("logs/Data/\u653b\u64ca\u5206\u985e/\u9060\u8ddd\u96e2\u653b\u64ca_" + FileoutputUtil.getChineseData() + ".txt", (String)object);
        }
        object = ExternalCodeLongTableGetter.ALLATORIxDEMO("_a");
        iterator = a2.ALLATORIxDEMO.iterator();
        Iterator iterator4 = iterator;
        while (iterator4.hasNext()) {
            n2 = (Integer)iterator.next();
            object = (String)object + ", " + n2;
            iterator4 = iterator;
        }
        if (!a2.ALLATORIxDEMO.isEmpty()) {
            FileoutputUtil.logToFile("logs/Data/\u653b\u64ca\u5206\u985e/\u9b54\u6cd5\u653b\u64ca_" + FileoutputUtil.getChineseData() + ".txt", (String)object);
        }
    }

    public /* synthetic */ SkillCollector() {
        SkillCollector a2;
        SkillCollector skillCollector = a2;
        a2.a = new LinkedList();
        skillCollector.d = new LinkedList();
        a2.ALLATORIxDEMO = new LinkedList();
    }

    public static class run
    implements Runnable {
        @Override
        public /* synthetic */ void run() {
            K.outputList();
        }

        public /* synthetic */ run() {
            run a2;
        }
    }
}

