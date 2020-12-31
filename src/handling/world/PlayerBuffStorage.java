/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.MapleCoolDownValueHolder;
import client.MapleDiseaseValueHolder;
import client.SpecialBuffInfo;
import handling.world.PlayerBuffValueHolder;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerBuffStorage
implements Serializable {
    private static final /* synthetic */ Map<Integer, List<MapleDiseaseValueHolder>> d;
    private static final /* synthetic */ Map<Integer, List<MapleCoolDownValueHolder>> a;
    private static final /* synthetic */ Map<Integer, List<SpecialBuffInfo>> ALLATORIxDEMO;
    private static final /* synthetic */ Map<Integer, List<PlayerBuffValueHolder>> K;

    public static final /* synthetic */ void addStackBuffsToStorage(int a2, List<SpecialBuffInfo> a3) {
        ALLATORIxDEMO.put(a2, a3);
    }

    public static final /* synthetic */ List<PlayerBuffValueHolder> getBuffsFromStorage(int a2) {
        return K.remove(a2);
    }

    public static /* synthetic */ {
        K = new ConcurrentHashMap<Integer, List<PlayerBuffValueHolder>>();
        a = new ConcurrentHashMap<Integer, List<MapleCoolDownValueHolder>>();
        d = new ConcurrentHashMap<Integer, List<MapleDiseaseValueHolder>>();
        ALLATORIxDEMO = new ConcurrentHashMap<Integer, List<SpecialBuffInfo>>();
    }

    public static final /* synthetic */ List<MapleDiseaseValueHolder> getDiseaseFromStorage(int a2) {
        return d.remove(a2);
    }

    public static final /* synthetic */ void addBuffsToStorage(int a2, List<PlayerBuffValueHolder> a3) {
        K.put(a2, a3);
    }

    public static final /* synthetic */ void addCooldownsToStorage(int a2, List<MapleCoolDownValueHolder> a3) {
        a.put(a2, a3);
    }

    public /* synthetic */ PlayerBuffStorage() {
        PlayerBuffStorage a2;
    }

    public static final /* synthetic */ List<MapleCoolDownValueHolder> getCooldownsFromStorage(int a2) {
        return a.remove(a2);
    }

    public static final /* synthetic */ void addDiseaseToStorage(int a2, List<MapleDiseaseValueHolder> a3) {
        d.put(a2, a3);
    }
}

