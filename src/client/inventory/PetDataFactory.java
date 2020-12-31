/*
 * Decompiled with CFR 0.150.
 */
package client.inventory;

import client.inventory.PetCommand;
import java.util.HashMap;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.MobSkillData;
import server.shark.SharkReader;
import tools.Pair;

public class PetDataFactory {
    private static final /* synthetic */ Map<Pair<Integer, Integer>, PetCommand> d;
    private static final /* synthetic */ MapleDataProvider a;
    private static final /* synthetic */ Map<Integer, Integer> ALLATORIxDEMO;

    public static final /* synthetic */ int getHunger(int a2) {
        Integer n2 = ALLATORIxDEMO.get(a2);
        if (n2 != null) {
            return n2;
        }
        n2 = MapleDataTool.getInt(a.getData("Pet/" + a2 + ".img").getChildByPath(SharkReader.ALLATORIxDEMO("*<%=l:6<$ :")), 1);
        ALLATORIxDEMO.put(a2, n2);
        return n2;
    }

    public static final /* synthetic */ PetCommand getPetCommand(int a2, int a3) {
        PetCommand petCommand = d.get(new Pair<Integer, Integer>(a2, a3));
        if (petCommand != null) {
            return petCommand;
        }
        MapleData mapleData = a.getData("Pet/" + a2 + ".img");
        int n2 = 0;
        int n3 = 0;
        if (mapleData != null) {
            n2 = MapleDataTool.getInt("interact/" + a3 + "/prob", mapleData, 0);
            n3 = MapleDataTool.getInt("interact/" + a3 + "/inc", mapleData, 0);
        }
        petCommand = new PetCommand(a2, a3, n2, n3);
        d.put(new Pair<Integer, Integer>(a2, a3), petCommand);
        return petCommand;
    }

    public static /* synthetic */ {
        a = MapleDataProviderFactory.getDataProvider(MobSkillData.ALLATORIxDEMO("D\u0014h\r#\u0017w"));
        d = new HashMap<Pair<Integer, Integer>, PetCommand>();
        ALLATORIxDEMO = new HashMap<Integer, Integer>();
    }

    public /* synthetic */ PetDataFactory() {
        PetDataFactory a2;
    }
}

