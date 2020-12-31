/*
 * Decompiled with CFR 0.150.
 */
package tools.npcgenerator;

import FuckingHackerToby.L;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tools.npcgenerator.Condition;
import tools.npcgenerator.Instruction;
import tools.npcgenerator.Location;
import tools.npcgenerator.NPCMessage;

public class NPC {
    private static /* synthetic */ int a;
    private final /* synthetic */ int d;
    private /* synthetic */ Map<Integer, List<NPCMessage>> ALLATORIxDEMO;

    public static /* synthetic */ {
        a = 0;
    }

    public /* synthetic */ int getId() {
        NPC a2;
        return a2.d;
    }

    public /* synthetic */ NPC(int a2) {
        NPC a3;
        a3.d = a2;
    }

    public /* synthetic */ void adjustConditions() {
        NPC a2;
        for (Map.Entry<Integer, List<NPCMessage>> entry : a2.ALLATORIxDEMO.entrySet()) {
            Object object = entry.getValue();
            List<NPCMessage> list = entry.getValue();
            Iterator<NPCMessage> iterator = object.iterator();
            while (iterator.hasNext()) {
                object = iterator.next();
                if (((NPCMessage)object).getConditions() == null) continue;
                int n2 = 0;
                Condition condition = null;
                for (Condition condition2 : ((NPCMessage)object).getConditions()) {
                    if (!(condition2 instanceof Location)) continue;
                    n2 = ((NPCMessage)object).getMessageChainId();
                    condition = condition2;
                }
                if (n2 <= 0) continue;
                block3: for (List list2 : a2.ALLATORIxDEMO.values()) {
                    Iterator iterator2 = list2.iterator();
                    block4: while (true) {
                        Iterator iterator3 = iterator2;
                        while (iterator3.hasNext()) {
                            boolean bl;
                            List<Condition> list3;
                            NPCMessage nPCMessage;
                            block9: {
                                nPCMessage = (NPCMessage)iterator2.next();
                                if (nPCMessage.getMessageChainId() != n2) continue block4;
                                if (nPCMessage.getConditions() == null) {
                                    nPCMessage.setConditions(((NPCMessage)object).getConditions());
                                    continue block4;
                                }
                                list3 = nPCMessage.getConditions();
                                boolean bl2 = false;
                                Iterator<Condition> iterator4 = list3.iterator();
                                while (iterator4.hasNext()) {
                                    if (!(iterator4.next() instanceof Location)) continue;
                                    bl = bl2 = true;
                                    break block9;
                                }
                                bl = bl2;
                            }
                            if (bl) {
                                iterator3 = iterator2;
                                continue;
                            }
                            list3.add(condition);
                            nPCMessage.setConditions(list3);
                            continue block4;
                        }
                        continue block3;
                        break;
                    }
                }
            }
        }
    }

    public /* synthetic */ Map<Integer, List<NPCMessage>> getMessages() {
        NPC a2;
        return a2.ALLATORIxDEMO;
    }

    public /* synthetic */ void applyConversation(int a2, L a3, int a422, String a5, byte a622, int a722, List<Instruction> a8322) {
        NPC a9;
        if (a9.ALLATORIxDEMO == null) {
            NPC nPC = a9;
            nPC.ALLATORIxDEMO = new LinkedHashMap<Integer, List<NPCMessage>>();
        }
        if (a2 == 0) {
            // empty if block
        }
        NPCMessage a422 = new NPCMessage(++a, a3, a422, (String)((Object)a5), a622, a722, (List<Instruction>)a8322, null);
        a5 = new LinkedList<NPCMessage>();
        if (a9.ALLATORIxDEMO.get(a2) != null) {
            int a8322;
            byte by;
            block14: {
                a622 = 0;
                for (NPCMessage a8322 : a9.ALLATORIxDEMO.get(a2)) {
                    if (!a8322.getMessage().equals(a422.getMessage())) continue;
                    by = a622 = 1;
                    break block14;
                }
                by = a622;
            }
            if (by != 0) {
                return;
            }
            a5 = a9.ALLATORIxDEMO.get(a2);
            byte a722 = 0;
            int n2 = a8322 = 0;
            while (n2 < a9.ALLATORIxDEMO.get(a2).size()) {
                List<Condition> a622;
                NPCMessage nPCMessage;
                NPCMessage nPCMessage2 = a9.ALLATORIxDEMO.get(a2).get((int)a8322);
                if (nPCMessage2.getConditions() != null) {
                    NPCMessage nPCMessage3 = nPCMessage2;
                    nPCMessage = nPCMessage3;
                    a622 = nPCMessage3.getConditions();
                } else {
                    a622 = new LinkedList<Condition>();
                    nPCMessage = nPCMessage2;
                }
                if (nPCMessage.getPlayer().H() != a3.H()) {
                    boolean bl;
                    Object object;
                    a722 = (byte)(a722 | true ? 1 : 0);
                    boolean bl2 = false;
                    if (nPCMessage2.getConditions() != null) {
                        object = nPCMessage2.getConditions().iterator();
                        while (object.hasNext()) {
                            if (!((Condition)object.next() instanceof Location)) continue;
                            bl = bl2 = true;
                            break;
                        }
                    } else {
                        bl = bl2;
                    }
                    if (!bl) {
                        Object object2 = object = new Location();
                        ((Location)object2).setMapId(nPCMessage2.getPlayer().H());
                        a622.add((Condition)object2);
                        nPCMessage2.setConditions(a622);
                    }
                }
                n2 = ++a8322;
            }
            LinkedList<Condition> a8322 = new LinkedList<Condition>();
            if (a722 & true) {
                Location a622;
                Location location = a622 = new Location();
                location.setMapId(a3.H());
                a8322.add(location);
                a422.setConditions(a8322);
            }
        }
        a5.add(a422);
        a9.ALLATORIxDEMO.put(a2, a5);
    }
}

