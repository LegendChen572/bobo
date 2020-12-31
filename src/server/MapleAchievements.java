/*
 * Decompiled with CFR 0.150.
 */
package server;

import constants.MapConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import server.MapleAchievement;
import server.life.MonsterGlobalDropEntry;

public class MapleAchievements {
    private /* synthetic */ Map<Integer, MapleAchievement> d;
    private static /* synthetic */ MapleAchievements ALLATORIxDEMO;

    public /* synthetic */ MapleAchievement getById(int a2) {
        MapleAchievements a3;
        return a3.d.get(a2);
    }

    public /* synthetic */ MapleAchievements() {
        MapleAchievements a2;
        a2.d = new LinkedHashMap<Integer, MapleAchievement>();
        a2.d.put(1, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u9074\u9074\u50dd\u903b\u95ee"), 10, false));
        a2.d.put(2, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u7b51\u7d61\u904c\u524b8H([\u7d02"), 10, false));
        a2.d.put(3, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u7b27\u7d20\u903a\u520aN\r^\u001a\u7d74"), 30, false));
        a2.d.put(4, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u7b32\u7d02\u902f\u5228[)K([\u7d02"), 80, false));
        a2.d.put(5, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u7b73\u7d74\u906e\u525e\u001a\\\n^\u001a\u7d74"), 100, false));
        a2.d.put(7, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u4ea2\u6c58\u904c\u524b8N([\u9ec6"), 50, false));
        a2.d.put(8, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u7a45\u625a\u9fb7\u76ea\u88e7\u50f7"), 8000, false));
        a2.d.put(9, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u7a04\u622c\u91b6\u7507\u88a6\u5081"), 40, false));
        a2.d.put(10, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u7a45\u625a\u6c02\u6028\u88e7\u50f7"), 50, false));
        a2.d.put(11, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u8ad1\u5584\u6b1a\u6209\u506a\u769c\u9031\u622a"), 10, false));
        a2.d.put(12, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u64f0\u6539\u4ebc\u9ebf\u9069\u5949\u59ea\u9843"), 350, false));
        a2.d.put(13, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u64b1\u654f\u4efd\u62d1\u576d\u65b7"), 250, false));
        a2.d.put(14, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u64f0\u6539\u4ebc\u6d19\u6028\u65c1"), 250, false));
        a2.d.put(15, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u64d2\u652c\u4e9e\u70f5\u9b4c"), 500, false));
        a2.d.put(16, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u64a4\u656d\u4ee8\u9fb7\u73e5"), 1500, false));
        a2.d.put(17, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u64b1\u654f\u4efd\u76b6\u531a\u4e00"), 3000, false));
        a2.d.put(18, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u6bd4\u6b41N\u000bN\u5031Nx!i="), 1000, false));
        a2.d.put(19, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u5b94\u626b\u6d23\u52ae\u4ee3\u52a28\\W#8\u9003\u64df\u9837?"), 50, false));
        a2.d.put(20, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u5be2\u622a\u6d55\u52ef\u4e95\u52e3N\u001d#[\u001eV\u000b|\u0007N\u0000_\u001dII"), 50, false));
        a2.d.put(21, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u5bf7\u6208\u6d40\u52cd\u4e80\u52c1[?4t\u001a84t\u001a?"), 50, false));
        a2.d.put(22, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u64f0\u6539\u4ebcNx\u0001I\u001dk\u001b_\u001dNN\u570a\u732a\u96d9\u5ec8"), 500));
        a2.d.put(23, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u64d2\u652c\u4e9e\u6d8c\u6c94\u70f5\u9b4c"), 10000, false));
        a2.d.put(24, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u64a4\u656d\u4ee8\u6dcd\u6ce2\u9fb7\u73e5"), 20000, false));
        a2.d.put(25, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u5b94\u626b\u6d23\u52ae\u4ee3\u52a28\\\u7507\u5b23\u6309\u624b?"), 50, false));
        a2.d.put(26, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u6501\u64a4\u8dbf\u9020\u001a_\n^\n^\u001a\u9eb0"), 200, false));
        a2.d.put(27, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u6540\u64d2\u8dfe\u9056[-K(K([\u9ec6"), 300, false));
        a2.d.put(28, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u6555\u64f0\u8deb\u9074N\u000b^\n^\n^\u001a\u9eb0"), 400, false));
        a2.d.put(29, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u6523\u64b1\u8d9d\u90358N(K(K([\u9ec6"), 500, false));
        a2.d.put(30, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u6555\u64f0\u903a\u520aN\u0003W\u0003W\u0003W\u001a\u9eb0"), 100, false));
        a2.d.put(31, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u64d9\u67728J8K(K8K(K8\u91aa\u5e7b"), 100, false));
        a2.d.put(32, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u64fb\u6767\u001a_\nN\n^\nN\n^\nN\u91eb\u5e0d"), 200, false));
        a2.d.put(33, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u64d9\u67728J(K8K(K8K(K8\u91aa\u5e7b"), 300, false));
        a2.d.put(34, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u64af\u6733N\u000bN\n^\nN\n^\nN\n^\nN\u91eb\u5e0d"), 400, false));
        a2.d.put(35, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u520e\u4e9e\u5117\u671b"), 25, false));
        a2.d.put(36, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u7d7e\u4ee8\u5b8c\u65a1"), 25, false));
        a2.d.put(37, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u99ed\u6b39\u5bf7\u6208[)[\u5013\u7d3f\u9692\u4e80\u52c1"), 40, false));
        a2.d.put(38, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99ac\u6b4f\u64f0\u6539\u4ebc\u518f\u96cd\u6007"), 250, false));
        a2.d.put(39, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u64d2\u652c\u4e9e\u9eaa\u668f\u5908\u769f"), 1000, false));
        a2.d.put(40, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u88b3\u50a3\u8deb\u9074N\u000b]\nN\u7b73\u76ea\u6b5c\u5606"), 10, false));
        a2.d.put(41, new MapleAchievement(MapConstants.ALLATORIxDEMO("\u998e\u6b5a\u88c5\u50e2\u8d9d\u90358J,K8\u7b32\u769c\u6b1d\u5670"), 15, false));
        a2.d.put(42, new MapleAchievement(MonsterGlobalDropEntry.ALLATORIxDEMO("\u99f8\u6b1b\u64a4\u656d\u4ee8\u8224\u9fe3\u8224\u732b"), 15, false));
    }

    public /* synthetic */ Integer getByMapleAchievement(MapleAchievement a2) {
        MapleAchievements a3;
        for (Map.Entry<Integer, MapleAchievement> entry : a3.d.entrySet()) {
            if (entry.getValue() != a2) continue;
            return entry.getKey();
        }
        return null;
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new MapleAchievements();
    }

    public static /* synthetic */ MapleAchievements getInstance() {
        return ALLATORIxDEMO;
    }
}

