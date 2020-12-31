/*
 * Decompiled with CFR 0.150.
 */
package constants;

import client.MapleCharacter;
import java.util.HashMap;
import java.util.Map;

public class ServerTempStorage {
    private static final /* synthetic */ Map<Integer, Integer> d;
    private static final /* synthetic */ Map<Integer, Integer> a;
    private static final /* synthetic */ Map<Integer, Map<String, Long>> ALLATORIxDEMO;

    public static /* synthetic */ void gainCharacterMeso(MapleCharacter a2, int a3) {
        MapleCharacter mapleCharacter = a2;
        ServerTempStorage.setCharacterMeso(mapleCharacter, ServerTempStorage.getCharacterMeso(mapleCharacter) + a3);
    }

    public static /* synthetic */ void setMerchant(MapleCharacter a2, boolean a3) {
        if (!d.containsKey(a2.getAccountID())) {
            d.put(a2.getAccountID(), a3 ? 1 : 0);
            return;
        }
        d.remove(a2.getAccountID());
        d.put(a2.getAccountID(), a3 ? 1 : 0);
    }

    public /* synthetic */ ServerTempStorage() {
        ServerTempStorage a2;
    }

    public static /* synthetic */ boolean getMerchant(MapleCharacter a2) {
        if (d.containsKey(a2.getAccountID())) {
            return d.get(a2.getAccountID()) == 1;
        }
        return false;
    }

    public static /* synthetic */ {
        a = new HashMap<Integer, Integer>();
        d = new HashMap<Integer, Integer>();
        ALLATORIxDEMO = new HashMap<Integer, Map<String, Long>>();
    }

    public static /* synthetic */ void setCharacterMeso(MapleCharacter a2, int a3) {
        if (!a.containsKey(a2.getId())) {
            a.put(a2.getId(), a3);
            return;
        }
        a.remove(a2.getId());
        a.put(a2.getId(), a3);
    }

    public static /* synthetic */ Map<String, Long> getCharacterSetTemp(MapleCharacter a2) {
        if (ALLATORIxDEMO.containsKey(a2.getId())) {
            return ALLATORIxDEMO.get(a2.getId());
        }
        return null;
    }

    public static /* synthetic */ int getCharacterMeso(MapleCharacter a2) {
        int n2 = 0;
        if (a.containsKey(a2.getId())) {
            if (a.get(a2.getId()) != null) {
                n2 = a.get(a2.getId());
            }
            return n2;
        }
        return 0;
    }

    public static /* synthetic */ void setCharacterSetTemp(MapleCharacter a2, Map<String, Long> a3) {
        if (!ALLATORIxDEMO.containsKey(a2.getId())) {
            ALLATORIxDEMO.put(a2.getId(), a3);
            return;
        }
        ALLATORIxDEMO.remove(a2.getId());
        ALLATORIxDEMO.put(a2.getId(), a3);
    }
}

