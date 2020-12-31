/*
 * Decompiled with CFR 0.150.
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleClient;
import handling.world.CharacterTransfer;
import server.Extend.SpecialItemData;
import server.MapleCarnivalFactory;
import server.Randomizer;
import server.life.MapleLifeFactory;
import server.life.MobSkill;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;
import tools.packet.MonsterCarnivalPacket;

public class MonsterCarnivalHandler {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void MonsterCarnival(LittleEndianAccessor a, MapleClient a) {
        if (a.getPlayer().getCarnivalParty() == null) {
            a.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        v0 = a;
        var2_2 = v0.readByte();
        var3_3 = v0.readInt();
        switch (var2_2) {
            case 0: {
                var4_4 = a.getPlayer().getMap().getMobsToSpawn();
                if (var3_3 >= var4_4.size() || a.getPlayer().getAvailableCP() < (Integer)var4_4.get((int)var3_3).right) {
                    v1 = a;
                    v1.getPlayer().dropMessage(5, CharacterTransfer.ALLATORIxDEMO("\u4f66\u6ca4\u670f\u8d85\u5926\u76b2&uV\u0018"));
                    v1.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                var5_6 = MapleLifeFactory.getMonster((Integer)var4_4.get((int)var3_3).left);
                if (var5_6 != null && a.getPlayer().getMap().makeCarnivalSpawn(a.getPlayer().getCarnivalParty().getTeam(), var5_6, var3_3)) {
                    a.getPlayer().getCarnivalParty().useCP(a.getPlayer(), (Integer)var4_4.get((int)var3_3).right);
                    v2 = a;
                    a.getPlayer().CPUpdate(false, v2.getPlayer().getAvailableCP(), a.getPlayer().getTotalCP(), 0);
                    v3 = var6_8 = v2.getPlayer().getMap().getCharactersThreadsafe().iterator();
                    while (true) {
                        if (!v3.hasNext()) {
                            v4 = a;
                            v4.getPlayer().getMap().broadcastMessage(MonsterCarnivalPacket.playerSummoned(a.getPlayer().getName(), var2_2, var3_3));
                            v4.sendPacket(MaplePacketCreator.enableActions());
                            return;
                        }
                        var7_11 = var6_8.next();
                        v3 = var6_8;
                        var7_11.CPUpdate(true, a.getPlayer().getCarnivalParty().getAvailableCP(), a.getPlayer().getCarnivalParty().getTotalCP(), a.getPlayer().getCarnivalParty().getTeam());
                    }
                }
                v5 = a;
                v5.getPlayer().dropMessage(5, SpecialItemData.ALLATORIxDEMO("\u4f48\u7112\u6cfd\u51be\u53c4\u55a9\u66dc\u5929\u76ac\u6019\u7241\u3031"));
                v5.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 1: {
                var6_9 = a.getPlayer().getMap().getSkillIds();
                if (var3_3 >= var6_9.size()) {
                    v6 = a;
                    v6.getPlayer().dropMessage(5, CharacterTransfer.ALLATORIxDEMO("\u671c\u77e3\u76b2\u9329\u8a92"));
                    v6.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                var7_12 = MapleCarnivalFactory.getInstance().getSkill(var6_9.get(var3_3));
                if (var7_12 == null || a.getPlayer().getAvailableCP() < var7_12.cpLoss) {
                    v7 = a;
                    v7.getPlayer().dropMessage(5, SpecialItemData.ALLATORIxDEMO("\u4f48\u6ca1\u6721\u8d80\u5908\u76b7\bpx\u001d"));
                    v7.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                var8_14 = var7_12.getDisease();
                var4_5 = false;
                for (MapleCharacter var9_16 : a.getPlayer().getMap().getCharactersThreadsafe()) {
                    if (var9_16.getParty() != null && (a.getPlayer().getParty() == null || var9_16.getParty().getId() == a.getPlayer().getParty().getId()) || !var7_12.targetsAll && !Randomizer.nextBoolean()) continue;
                    var4_5 = true;
                    if (var8_14 == null) {
                        v8 = var7_12;
                        var9_16.dispel();
                    } else {
                        v9 = var9_16;
                        if (var7_12.getMobSkill() == null) {
                            v9.getDiseaseBuff(var8_14, 1, 30000L, MobSkill.getByDisease(var8_14), 1);
                            v8 = var7_12;
                        } else {
                            v9.getDiseaseBuff(var8_14, var7_12.getMobSkill());
                            v8 = var7_12;
                        }
                    }
                    if (v8.targetsAll) continue;
                    v10 = var4_5;
                    ** GOTO lbl69
                }
                v10 = var4_5;
lbl69:
                // 2 sources

                if (!v10) {
                    v11 = a;
                    v11.getPlayer().dropMessage(5, CharacterTransfer.ALLATORIxDEMO("\u672c\u77d3\u7682\u9319\u8aa2\u0018"));
                    v11.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                v12 = a;
                v13 = a;
                v12.getPlayer().getCarnivalParty().useCP(v13.getPlayer(), var7_12.cpLoss);
                v12.getPlayer().CPUpdate((boolean)0, a.getPlayer().getAvailableCP(), a.getPlayer().getTotalCP(), 0);
                var5_7 = v13.getPlayer().getMap().getCharactersThreadsafe().iterator();
                v14 = var5_7;
                while (true) {
                    if (!v14.hasNext()) {
                        v15 = a;
                        v15.getPlayer().getMap().broadcastMessage(MonsterCarnivalPacket.playerSummoned(a.getPlayer().getName(), var2_2, var3_3));
                        v15.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    var9_16 = var5_7.next();
                    v14 = var5_7;
                    var9_16.CPUpdate(true, a.getPlayer().getCarnivalParty().getAvailableCP(), a.getPlayer().getCarnivalParty().getTotalCP(), a.getPlayer().getCarnivalParty().getTeam());
                }
            }
            case 2: {
                var6_10 = MapleCarnivalFactory.getInstance().getGuardian(var3_3);
                if (var6_10 == null || a.getPlayer().getAvailableCP() < var6_10.cpLoss) {
                    v16 = a;
                    v16.getPlayer().dropMessage(5, SpecialItemData.ALLATORIxDEMO("\u4f48\u6ca1\u6721\u8d80\u5908\u76b7\bpx\u001d"));
                    v16.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                if (!a.getPlayer().getMap().makeCarnivalReactor(a.getPlayer().getCarnivalParty().getTeam(), var3_3)) {
                    v17 = a;
                    v17.getPlayer().dropMessage(5, CharacterTransfer.ALLATORIxDEMO("\u4f56\u7127\u6ce3\u518b\u53da\u559c\u66c2\u591c\u76b2\u53cb\u61ff\u726f\u3034"));
                    v17.sendPacket(MaplePacketCreator.enableActions());
                    return;
                }
                v18 = a;
                v19 = a;
                v18.getPlayer().getCarnivalParty().useCP(v19.getPlayer(), var6_10.cpLoss);
                v18.getPlayer().CPUpdate((boolean)0, a.getPlayer().getAvailableCP(), a.getPlayer().getTotalCP(), 0);
                v20 = var7_13 = v19.getPlayer().getMap().getCharactersThreadsafe().iterator();
                while (true) {
                    if (!v20.hasNext()) {
                        v21 = a;
                        v21.getPlayer().getMap().broadcastMessage(MonsterCarnivalPacket.playerSummoned(a.getPlayer().getName(), var2_2, var3_3));
                        v21.sendPacket(MaplePacketCreator.enableActions());
                        return;
                    }
                    var8_15 = var7_13.next();
                    v20 = var7_13;
                    var8_15.CPUpdate(true, a.getPlayer().getCarnivalParty().getAvailableCP(), a.getPlayer().getCarnivalParty().getTotalCP(), a.getPlayer().getCarnivalParty().getTeam());
                }
            }
        }
    }

    public /* synthetic */ MonsterCarnivalHandler() {
        MonsterCarnivalHandler a2;
    }
}

