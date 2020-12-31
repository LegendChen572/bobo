/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package handling.channel.handler;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import constants.GameSetConstants;
import handling.auction.handler.MTSOperation;
import handling.channel.ChannelServer;
import handling.world.MaplePartyCharacter;
import handling.world.World;
import handling.world.family.MapleFamily;
import handling.world.family.MapleFamilyBuff;
import handling.world.family.MapleFamilyCharacter;
import server.maps.FieldLimitType;
import tools.MaplePacketCreator;
import tools.data.LittleEndianAccessor;
import tools.packet.FamilyPacket;

public class FamilyHandler {
    public static final /* synthetic */ void OpenFamily(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 != null && a3.getPlayer() != null) {
            MapleClient mapleClient = a3;
            mapleClient.sendPacket(FamilyPacket.getFamilyInfo(mapleClient.getPlayer()));
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static final /* synthetic */ void UseFamily(LittleEndianAccessor a, MapleClient a) {
        block25: {
            if (!a.getPlayer().isGM() && !GameSetConstants.FAMILY_BUFF) {
                v0 = a;
                v0.getPlayer().dropMessage(MTSOperation.ALLATORIxDEMO("\u76a2\u526e\u6760\u52bc\u80b1\u4e2e\u95c7\u651d\u4f33\u750b"));
                v0.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            if (!GameSetConstants.FAMILY_SYSTEM) {
                v1 = a;
                v1.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u76bf\u5279\u5be7\u65fb\u7caa\u7d45\u958d\u95bd\u4e7c\u001a\u007f"));
                v1.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            var2_2 = a.readInt();
            var3_8 = MapleFamilyBuff.getBuffEntry(var2_2);
            if (var3_8 == null) {
                return;
            }
            if (a.getPlayer().getFamilyId() <= 0) return;
            if (a.getPlayer().canUseFamilyBuff(var3_8) == false) return;
            if (a.getPlayer().getCurrentRep() <= var3_8.rep) return;
            v2 = true;
            var4_9 = v2;
            if (!var4_9) {
                return;
            }
            switch (var2_2) {
                case 0: {
                    var2_3 = a.getChannelServer().getPlayerStorage().getCharacterByName(a.readMapleAsciiString());
                    if (FieldLimitType.VipRock.check(a.getPlayer().getMap().getFieldLimit()) || !a.getPlayer().isAlive() || a.getPlayer().inBossMap() || a.getPlayer().inMapleLand()) {
                        a.getPlayer().dropMessage(5, MTSOperation.ALLATORIxDEMO("\u53a0\u55b9\u597d\u6574\uff40\u56c3\u70f6\u608b\u753a\u526e\u76c8\u4f6e\u7f22\u6235\u8049\u72e3\u6107\u660c\u4e41\u51e5\u8a7d\u53cf\u55d6\u3021"));
                        v3 = var4_9 = false;
                    } else if (var2_3 == null || var2_3.isGM() && !a.getPlayer().isGM()) {
                        a.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u7115\u6519\u76b0\u8983\u8246\u545c\u7a05\u6247\u8031\u8d8e\u609c\u4e5c\u5438\u986a\u9067\u3053"));
                        v3 = var4_9 = false;
                    } else if (!(var2_3.getFamilyId() != a.getPlayer().getFamilyId() || FieldLimitType.VipRock.check(var2_3.getMap().getFieldLimit()) || var2_3.getId() == a.getPlayer().getId() || var2_3.inBossMap() || var2_3.inMapleLand())) {
                        v3 = var4_9;
                        a.getPlayer().changeMap(var2_3.getMap(), var2_3.getMap().getPortal(0));
                    } else {
                        a.getPlayer().dropMessage(5, MTSOperation.ALLATORIxDEMO("\u53a0\u55b9\u597d\u6574\uff40\u56c3\u70f6\u608b\u753a\u526e\u76c8\u4f6e\u7f22\u6235\u8049\u72e3\u6107\u660c\u4e41\u51e5\u8a7d\u53cf\u55d6\u3021"));
                        v3 = var4_9 = false;
                    }
                    break block25;
                }
                case 1: {
                    var2_4 = a.getChannelServer().getPlayerStorage().getCharacterByName(a.readMapleAsciiString());
                    if (FieldLimitType.VipRock.check(a.getPlayer().getMap().getFieldLimit()) || !a.getPlayer().isAlive() || a.getPlayer().inBossMap() || a.getPlayer().inMapleLand()) {
                        a.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u53d8\u55cb\u5905\u6506\uff38\u56b1\u708e\u60f9\u7542\u521c\u76b0\u4f1c\u7f5a\u6247\u8031\u7291\u617f\u667e\u4e39\u5197\u8a05\u53bd\u55ae\u3053"));
                        return;
                    }
                    if (var2_4 == null || var2_4.isGM() && !a.getPlayer().isGM()) {
                        a.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u716d\u656b\u76c8\u89f1\u823e\u542e\u7a7d\u6235\u8049\u8dfc\u60e4\u4e2e\u5440\u9818\u901f\u3021"));
                        return;
                    }
                    if (var2_4.getTeleportName().length() > 0) {
                        a.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u53d2\u4e51\u503f\u73f8\u5b82\u5da3\u7da7\u8a9a\u6c76\u60f9\u53d8\u55cb\u76b0\u73f8\u5b82\u8a9a\u7a39\u5fdd\u51b9\u5646\u8a52\u3053"));
                        return;
                    }
                    if (!(var2_4.getFamilyId() != a.getPlayer().getFamilyId() || FieldLimitType.VipRock.check(var2_4.getMap().getFieldLimit()) || var2_4.getId() == a.getPlayer().getId() || var2_4.inBossMap() || var2_4.inMapleLand())) {
                        v4 = var2_4;
                        v4.getClient().sendPacket(FamilyPacket.familySummonRequest(a.getPlayer().getName(), a.getPlayer().getMap().getMapName()));
                        v4.setTeleportName(a.getPlayer().getName());
                        return;
                    }
                    a.getPlayer().dropMessage(5, MTSOperation.ALLATORIxDEMO("\u53a0\u55b9\u597d\u6574\uff40\u56c3\u70f6\u608b\u753a\u526e\u76c8\u4f6e\u7f22\u6235\u8049\u72e3\u6107\u660c\u4e41\u51e5\u8a7d\u53cf\u55d6\u3021"));
                    return;
                }
                case 4: {
                    var2_5 = World.Family.getFamily(a.getPlayer().getFamilyId());
                    var2_5 = var2_5.getMFC(a.getPlayer().getId()).getOnlineJuniors((MapleFamily)var2_5);
                    if (var2_5.size() >= 7) ** GOTO lbl65
                    v3 = var4_9 = false;
                    break block25;
lbl65:
                    // 1 sources

                    v5 = var5_10 = var2_5.iterator();
                    while (v5.hasNext()) {
                        var6_12 = (MapleFamilyCharacter)var5_10.next();
                        var7_14 = World.Find.findChannel(var6_12.getId());
                        var2_6 = World.Find.findWorld(var6_12.getId());
                        if (var7_14 == -1) {
                            v5 = var5_10;
                            continue;
                        }
                        var2_7 = World.getStorage(var2_6, var7_14).getCharacterById(var6_12.getId());
                        v5 = var5_10;
                        var3_8.applyTo(var2_7);
                    }
                    break;
                }
                case 2: 
                case 3: 
                case 5: 
                case 6: 
                case 7: 
                case 8: {
                    var3_8.applyTo(a.getPlayer());
                    v3 = var4_9;
                    break block25;
                }
                case 9: 
                case 10: {
                    var3_8.applyTo(a.getPlayer());
                    if (a.getPlayer().getParty() == null) break;
                    for (MaplePartyCharacter var6_13 : a.getPlayer().getParty().getMembers()) {
                        if (var6_13.getId() == a.getPlayer().getId() || (var7_15 = a.getPlayer().getMap().getCharacterById(var6_13.getId())) == null || !var7_15.isAlive()) continue;
                        var3_8.applyTo(var7_15);
                    }
                }
            }
            v3 = var4_9;
        }
        if (v3) {
            v6 = a;
            v6.getPlayer().setCurrentRep(a.getPlayer().getCurrentRep() - var3_8.rep);
            v6.sendPacket(FamilyPacket.changeRep(-var3_8.rep));
            v6.getPlayer().useFamilyBuff(var3_8);
            return;
        }
        a.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u762d\u752b\u4ed7\u671e\u77b4\u76b0\u937e\u8a90\u3053"));
    }

    public /* synthetic */ FamilyHandler() {
        FamilyHandler a2;
    }

    public static final /* synthetic */ void DeleteJunior(LittleEndianAccessor a2, MapleClient a3) {
        MapleClient mapleClient;
        int n2 = a2.readInt();
        if (a3.getPlayer().getFamilyId() <= 0 || n2 <= 0 || a3.getPlayer().getJunior1() != n2 && a3.getPlayer().getJunior2() != n2) {
            return;
        }
        MapleFamily mapleFamily = World.Family.getFamily(a3.getPlayer().getFamilyId());
        MapleFamilyCharacter mapleFamilyCharacter = mapleFamily.getMFC(n2);
        if (mapleFamilyCharacter == null) {
            return;
        }
        MapleFamilyCharacter mapleFamilyCharacter2 = a3.getPlayer().getMFC();
        boolean bl = mapleFamilyCharacter2.getJunior2() == n2;
        MapleFamilyCharacter mapleFamilyCharacter3 = mapleFamilyCharacter2;
        if (bl) {
            mapleFamilyCharacter3.setJunior2(0);
            mapleClient = a3;
        } else {
            mapleFamilyCharacter3.setJunior1(0);
            mapleClient = a3;
        }
        mapleClient.getPlayer().saveFamilyStatus();
        MapleFamilyCharacter mapleFamilyCharacter4 = mapleFamilyCharacter;
        mapleFamilyCharacter4.setSeniorId(0);
        MapleFamilyCharacter mapleFamilyCharacter5 = mapleFamilyCharacter;
        MapleFamily.setOfflineFamilyStatus(mapleFamilyCharacter4.getFamilyId(), mapleFamilyCharacter.getSeniorId(), mapleFamilyCharacter5.getJunior1(), mapleFamilyCharacter.getJunior2(), mapleFamilyCharacter.getCurrentRep(), mapleFamilyCharacter.getTotalRep(), mapleFamilyCharacter.getId());
        MapleCharacterUtil.sendNote(mapleFamilyCharacter5.getName(), a3.getPlayer().getName(), a3.getPlayer().getName() + " \u7d44\u9577 \u89e3\u6563\u4e86\u5bb6\u65cf", 0);
        if (!mapleFamily.splitFamily(n2, mapleFamilyCharacter)) {
            if (!bl) {
                mapleFamily.resetDescendants();
            }
            mapleFamily.resetPedigree();
        }
        a3.getPlayer().dropMessage(1, "\u8e22\u51fa\u4e86 (" + mapleFamilyCharacter.getName() + ").");
        a3.sendPacket(MaplePacketCreator.enableActions());
    }

    public static final /* synthetic */ void RequestFamily(LittleEndianAccessor a2, MapleClient a3) {
        MapleCharacter mapleCharacter;
        int n2;
        if (a3 == null || a3.getPlayer() == null) {
            return;
        }
        int n3 = 0;
        int n4 = 0;
        String string = null;
        try {
            string = a2.readMapleAsciiString();
            n3 = World.Find.findChannel(string);
            n2 = n4 = World.Find.findWorld(string);
        }
        catch (NegativeArraySizeException negativeArraySizeException) {
            n2 = n4;
        }
        if (ChannelServer.getInstance(n2, n3) != null && (mapleCharacter = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(string)) != null) {
            a3.sendPacket(FamilyPacket.getFamilyResult(mapleCharacter));
        }
    }

    public static final /* synthetic */ void AcceptFamily(LittleEndianAccessor a2, MapleClient a3) {
        if (!GameSetConstants.FAMILY_SYSTEM) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u76cd\u5201\u5b95\u6583\u7cd8\u7d3d\u95ff\u95c5\u4e0eb\r"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleCharacter mapleCharacter = a3.getPlayer().getMap().getCharacterById(a2.readInt());
        if (mapleCharacter != null && a3.getPlayer().getSeniorId() == 0 && (a3.getPlayer().isGM() || !mapleCharacter.isHidden()) && mapleCharacter.getLevel() - 20 <= a3.getPlayer().getLevel() && mapleCharacter.getLevel() >= 10 && mapleCharacter.getName().equals(a2.readMapleAsciiString()) && mapleCharacter.getNoJuniors() < 2 && a3.getPlayer().getLevel() >= 10) {
            int n2;
            int n3 = n2 = a2.readByte() > 0 ? 1 : 0;
            mapleCharacter.getClient().sendPacket(FamilyPacket.sendFamilyJoinResponse(n3 != 0, a3.getPlayer().getName()));
            if (n3 != 0) {
                int n4;
                MapleClient mapleClient = a3;
                mapleClient.sendPacket(FamilyPacket.getSeniorMessage(mapleCharacter.getName()));
                n2 = mapleClient.getPlayer().getMFC() == null ? 0 : a3.getPlayer().getMFC().getFamilyId();
                int n5 = a3.getPlayer().getMFC() == null ? 0 : a3.getPlayer().getMFC().getJunior1();
                int n6 = n4 = a3.getPlayer().getMFC() == null ? 0 : a3.getPlayer().getMFC().getJunior2();
                if (mapleCharacter.getFamilyId() > 0 && World.Family.getFamily(mapleCharacter.getFamilyId()) != null) {
                    MapleFamily mapleFamily;
                    MapleCharacter mapleCharacter2;
                    MapleFamilyCharacter mapleFamilyCharacter;
                    int n7;
                    int n8;
                    MapleCharacter mapleCharacter3;
                    int n9;
                    MapleFamily mapleFamily2 = World.Family.getFamily(mapleCharacter.getFamilyId());
                    MapleCharacter mapleCharacter4 = a3.getPlayer();
                    if (n2 <= 0) {
                        n9 = mapleCharacter.getFamilyId();
                        mapleCharacter3 = mapleCharacter;
                    } else {
                        n9 = n2;
                        mapleCharacter3 = mapleCharacter;
                    }
                    int n10 = mapleCharacter3.getId();
                    if (n5 <= 0) {
                        n8 = 0;
                        n7 = n4;
                    } else {
                        n8 = n5;
                        n7 = n4;
                    }
                    mapleCharacter4.setFamily(n9, n10, n8, n7 <= 0 ? 0 : n4);
                    MapleFamilyCharacter mapleFamilyCharacter2 = mapleFamilyCharacter = mapleCharacter.getMFC();
                    if (mapleFamilyCharacter.getJunior1() > 0) {
                        mapleFamilyCharacter2.setJunior2(a3.getPlayer().getId());
                        mapleCharacter2 = mapleCharacter;
                    } else {
                        mapleFamilyCharacter2.setJunior1(a3.getPlayer().getId());
                        mapleCharacter2 = mapleCharacter;
                    }
                    mapleCharacter2.saveFamilyStatus();
                    if (n2 > 0 && World.Family.getFamily(n2) != null) {
                        MapleFamily mapleFamily3 = mapleFamily2;
                        mapleFamily = mapleFamily3;
                        MapleFamily.mergeFamily(mapleFamily3, World.Family.getFamily(n2));
                    } else {
                        int n11;
                        int n12;
                        MapleCharacter mapleCharacter5 = a3.getPlayer();
                        int n13 = mapleCharacter.getFamilyId();
                        int n14 = mapleCharacter.getId();
                        if (n5 <= 0) {
                            n12 = 0;
                            n11 = n4;
                        } else {
                            n12 = n5;
                            n11 = n4;
                        }
                        mapleCharacter5.setFamily(n13, n14, n12, n11 <= 0 ? 0 : n4);
                        MapleFamily mapleFamily4 = mapleFamily2;
                        mapleFamily = mapleFamily4;
                        mapleFamily4.setOnline(a3.getPlayer().getId(), true, a3.getChannel());
                        a3.getPlayer().saveFamilyStatus();
                    }
                    if (mapleFamily != null) {
                        if (mapleCharacter.getNoJuniors() == 1 || n2 > 0) {
                            mapleFamily2.resetDescendants();
                        }
                        mapleFamily2.resetPedigree();
                    }
                } else {
                    int n15 = MapleFamily.createFamily(mapleCharacter.getId());
                    if (n15 > 0) {
                        MapleFamily mapleFamily;
                        int n16;
                        int n17;
                        MapleClient mapleClient2;
                        int n18;
                        int n19;
                        int n20;
                        MapleFamily.setOfflineFamilyStatus(n15, 0, a3.getPlayer().getId(), 0, mapleCharacter.getCurrentRep(), mapleCharacter.getTotalRep(), mapleCharacter.getId());
                        int n21 = mapleCharacter.getId();
                        if (n5 <= 0) {
                            n20 = 0;
                            n19 = n4;
                        } else {
                            n20 = n5;
                            n19 = n4;
                        }
                        if (n19 <= 0) {
                            n18 = 0;
                            mapleClient2 = a3;
                        } else {
                            n18 = n4;
                            mapleClient2 = a3;
                        }
                        MapleFamily.setOfflineFamilyStatus(n15, n21, n20, n18, mapleClient2.getPlayer().getCurrentRep(), a3.getPlayer().getTotalRep(), a3.getPlayer().getId());
                        mapleCharacter.setFamily(n15, 0, a3.getPlayer().getId(), 0);
                        MapleCharacter mapleCharacter6 = a3.getPlayer();
                        int n22 = mapleCharacter.getId();
                        if (n5 <= 0) {
                            n17 = 0;
                            n16 = n4;
                        } else {
                            n17 = n5;
                            n16 = n4;
                        }
                        mapleCharacter6.setFamily(n15, n22, n17, n16 <= 0 ? 0 : n4);
                        MapleFamily mapleFamily5 = World.Family.getFamily(n15);
                        mapleFamily5.setOnline(mapleCharacter.getId(), true, mapleCharacter.getClient().getChannel());
                        if (n2 > 0 && World.Family.getFamily(n2) != null) {
                            MapleFamily mapleFamily6 = mapleFamily5;
                            mapleFamily = mapleFamily6;
                            MapleFamily.mergeFamily(mapleFamily6, World.Family.getFamily(n2));
                        } else {
                            MapleFamily mapleFamily7 = mapleFamily5;
                            mapleFamily = mapleFamily7;
                            mapleFamily7.setOnline(a3.getPlayer().getId(), true, a3.getChannel());
                        }
                        mapleFamily.resetDescendants();
                        mapleFamily5.resetPedigree();
                    }
                }
                MapleClient mapleClient3 = a3;
                mapleClient3.sendPacket(FamilyPacket.getFamilyInfo(mapleClient3.getPlayer()));
            }
        }
    }

    public static final /* synthetic */ void FamilyPrecept(LittleEndianAccessor a2, MapleClient a3) {
        MapleFamily mapleFamily = World.Family.getFamily(a3.getPlayer().getFamilyId());
        if (mapleFamily == null || mapleFamily.getLeaderId() != a3.getPlayer().getId()) {
            return;
        }
        mapleFamily.setNotice(a2.readMapleAsciiString());
        a3.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u919c\u95bf\u5be7\u65fb\u89c7\u7aa3\u5322\u53db\u5906\u751c\u3053"));
    }

    public static final /* synthetic */ void FamilySummon(LittleEndianAccessor a2, MapleClient a3) {
        if (a3 == null) {
            return;
        }
        if (!a3.getPlayer().isGM() && !GameSetConstants.FAMILY_BUFF) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(MTSOperation.ALLATORIxDEMO("\u76a2\u526e\u6760\u52bc\u80b1\u4e2e\u95c7\u651d\u4f33\u750b"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        if (!GameSetConstants.FAMILY_SYSTEM) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u76bf\u5279\u5be7\u65fb\u7caa\u7d45\u958d\u95bd\u4e7c\u001a\u007f"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        MapleFamilyBuff.MapleFamilyBuffEntry mapleFamilyBuffEntry = MapleFamilyBuff.getBuffEntry(1);
        MapleClient mapleClient = a3;
        MapleCharacter mapleCharacter = mapleClient.getChannelServer().getPlayerStorage().getCharacterByName(a2.readMapleAsciiString());
        if (mapleClient.getPlayer().getFamilyId() > 0 && mapleCharacter != null && mapleCharacter.getFamilyId() == a3.getPlayer().getFamilyId() && !FieldLimitType.VipRock.check(mapleCharacter.getMap().getFieldLimit()) && !FieldLimitType.VipRock.check(a3.getPlayer().getMap().getFieldLimit()) && a3.getPlayer().isAlive() && mapleCharacter.isAlive() && mapleCharacter.canUseFamilyBuff(mapleFamilyBuffEntry) && a3.getPlayer().getTeleportName().equals(mapleCharacter.getName()) && mapleCharacter.getCurrentRep() > mapleFamilyBuffEntry.rep && a3.getPlayer().getEventInstance() == null && mapleCharacter.getEventInstance() == null) {
            boolean bl;
            boolean bl2 = bl = a2.readByte() > 0;
            if (bl) {
                MapleCharacter mapleCharacter2 = mapleCharacter;
                a3.getPlayer().changeMap(mapleCharacter2.getMap(), mapleCharacter.getMap().getPortal(0));
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.setCurrentRep(mapleCharacter3.getCurrentRep() - mapleFamilyBuffEntry.rep);
                mapleCharacter3.getClient().sendPacket(FamilyPacket.changeRep(-mapleFamilyBuffEntry.rep));
                mapleCharacter2.useFamilyBuff(mapleFamilyBuffEntry);
            } else {
                mapleCharacter.dropMessage(5, MTSOperation.ALLATORIxDEMO("\u53a0\u55b9\u597d\u6574\uff40\u56c3\u70f6\u608b\u753a\u526e\u76c8\u4f6e\u7f22\u6235\u8049\u72e3\u6107\u660c\u4e41\u51e5\u8a7d\u53cf\u55d6\u3021"));
            }
        } else {
            a3.getPlayer().dropMessage(5, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u53d8\u55cb\u5905\u6506\uff38\u56b1\u708e\u60f9\u7542\u521c\u76b0\u4f1c\u7f5a\u6247\u8031\u7291\u617f\u667e\u4e39\u5197\u8a05\u53bd\u55ae\u3053"));
        }
        a3.getPlayer().setTeleportName("");
    }

    public static final /* synthetic */ void FamilyOperation(LittleEndianAccessor a2, MapleClient a3) {
        String string;
        if (a3.getPlayer() == null) {
            return;
        }
        if (!GameSetConstants.FAMILY_SYSTEM) {
            MapleClient mapleClient = a3;
            mapleClient.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u76cd\u5201\u5b95\u6583\u7cd8\u7d3d\u95ff\u95c5\u4e0eb\r"));
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
            return;
        }
        String string2 = null;
        try {
            string = string2 = a2.readMapleAsciiString();
        }
        catch (NegativeArraySizeException negativeArraySizeException) {
            string = string2;
        }
        if (string != null) {
            MapleClient mapleClient;
            MapleCharacter mapleCharacter = a3.getChannelServer().getPlayerStorage().getCharacterByName(string2);
            if (mapleCharacter == null) {
                MapleClient mapleClient2 = a3;
                mapleClient = mapleClient2;
                mapleClient2.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u609c\u90d1\u8aff\u76d5\u739d\u5be7\u89e6\u8223\u5439\u5b06\u4e39\u6b32\u788e\u6247\u8031\u5c4b\u671e\u762a\u5151\u3053"));
            } else if (mapleCharacter.getFamilyId() == a3.getPlayer().getFamilyId() && mapleCharacter.getFamilyId() > 0) {
                MapleClient mapleClient3 = a3;
                mapleClient = mapleClient3;
                mapleClient3.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u5dbe\u7db0\u5764\u76db\u5440\u76a7\u5bfa\u65ec\u88ad\u3021"));
            } else if (mapleCharacter.getMapId() != a3.getPlayer().getMapId()) {
                MapleClient mapleClient4 = a3;
                mapleClient = mapleClient4;
                mapleClient4.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u4e5c\u51b9\u76a9\u5438\u76d5\u5704\u5747\u88d5\u3053"));
            } else if (mapleCharacter.getSeniorId() != 0) {
                MapleClient mapleClient5 = a3;
                mapleClient = mapleClient5;
                mapleClient5.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u608b\u90cc\u8ae8\u76c8\u738a\u5bfa\u89f1\u823e\u5dd1\u7ddf\u570b\u5269\u76a7\u5bfa\u65ec\u88ad\u3021"));
            } else if (mapleCharacter.getLevel() >= a3.getPlayer().getLevel()) {
                MapleClient mapleClient6 = a3;
                mapleClient = mapleClient6;
                mapleClient6.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u60f9\u9734\u89d0\u90b4\u8a9a\u6be0\u60f9\u4f7a\u7b18\u76b0\u73f8\u5b82\u3053"));
            } else if (mapleCharacter.getLevel() < a3.getPlayer().getLevel() - 20) {
                MapleClient mapleClient7 = a3;
                mapleClient = mapleClient7;
                mapleClient7.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u60e4\u90a3\u8a87\u76a7\u73e5\u5b95\u7b05\u7d39\u5f89\u982b\u76b4\u5dcd~\u0013\u7b05\u4ec6\u512b\u3021"));
            } else if (mapleCharacter.getLevel() < 10) {
                MapleClient mapleClient8 = a3;
                mapleClient = mapleClient8;
                mapleClient8.getPlayer().dropMessage(1, \u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u609c\u5f94\u983c\u90d1\u8aff`\u0004\u7d4b\u4ed1\u4e5b\u76b0\u73f8\u5b82\u3053"));
            } else if (a3.getPlayer().getJunior1() > 0 && a3.getPlayer().getJunior2() > 0) {
                MapleClient mapleClient9 = a3;
                mapleClient = mapleClient9;
                mapleClient9.getPlayer().dropMessage(1, MTSOperation.ALLATORIxDEMO("\u608b\u5bfa\u65ec\u5dbe\u7db0\u6745\u514a\u5047\u4e99\u4eca\uff2f\u8a87\u625d\u60e4\u76a7\u5fc0\u4ec0\u7e30\u7eaf\u90cc\u8ae8\u5269\u4e99\u546b\uff22"));
            } else {
                if (a3.getPlayer().isGM() || !mapleCharacter.isGM()) {
                    mapleCharacter.getClient().sendPacket(FamilyPacket.sendFamilyInvite(a3.getPlayer()));
                }
                mapleClient = a3;
            }
            mapleClient.sendPacket(MaplePacketCreator.enableActions());
        }
    }

    public static final /* synthetic */ void DeleteSenior(LittleEndianAccessor a2, MapleClient a3) {
        MapleFamilyCharacter mapleFamilyCharacter;
        if (a3.getPlayer().getFamilyId() <= 0 || a3.getPlayer().getSeniorId() <= 0) {
            return;
        }
        MapleClient mapleClient = a3;
        MapleFamily mapleFamily = World.Family.getFamily(mapleClient.getPlayer().getFamilyId());
        MapleFamilyCharacter mapleFamilyCharacter2 = mapleFamily.getMFC(a3.getPlayer().getSeniorId());
        MapleFamilyCharacter mapleFamilyCharacter3 = mapleClient.getPlayer().getMFC();
        mapleFamilyCharacter3.setSeniorId(0);
        boolean bl = mapleFamilyCharacter2.getJunior2() == a3.getPlayer().getId();
        MapleFamilyCharacter mapleFamilyCharacter4 = mapleFamilyCharacter2;
        if (bl) {
            mapleFamilyCharacter4.setJunior2(0);
            mapleFamilyCharacter = mapleFamilyCharacter2;
        } else {
            mapleFamilyCharacter4.setJunior1(0);
            mapleFamilyCharacter = mapleFamilyCharacter2;
        }
        MapleFamily.setOfflineFamilyStatus(mapleFamilyCharacter.getFamilyId(), mapleFamilyCharacter2.getSeniorId(), mapleFamilyCharacter2.getJunior1(), mapleFamilyCharacter2.getJunior2(), mapleFamilyCharacter2.getCurrentRep(), mapleFamilyCharacter2.getTotalRep(), mapleFamilyCharacter2.getId());
        a3.getPlayer().saveFamilyStatus();
        MapleCharacterUtil.sendNote(mapleFamilyCharacter2.getName(), a3.getPlayer().getName(), a3.getPlayer().getName() + " \u6210\u54e1 \u96e2\u958b\u4f60\u7684\u5bb6\u65cf", 0);
        if (!mapleFamily.splitFamily(a3.getPlayer().getId(), mapleFamilyCharacter3)) {
            if (!bl) {
                mapleFamily.resetDescendants();
            }
            mapleFamily.resetPedigree();
        }
        a3.getPlayer().dropMessage(1, "\u9000\u51fa\u4e86 (" + mapleFamilyCharacter2.getName() + ") \u7684\u5bb6\u65cf.");
        a3.sendPacket(MaplePacketCreator.enableActions());
    }
}

