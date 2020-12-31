/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u5154\u5154\u8c37
 *  client.messages.commands.player.\u592d\u58fd\u8c37
 */
package server.maps;

import client.MapleCharacter;
import client.MapleClient;
import client.MapleKeyLayout;
import client.SkillFactory;
import client.messages.commands.player.eventSystem.MapOwner;
import client.messages.commands.player.\u5154\u5154\u8c37;
import client.messages.commands.player.\u592d\u58fd\u8c37;
import constants.GameSetConstants;
import handling.channel.handler.NPCHandler;
import handling.world.family.MapleFamily;
import handling.world.sidekick.MapleSidekick;
import java.awt.Point;
import java.util.Iterator;
import scripting.event.EventManager;
import scripting.npc.NPCScriptManager;
import server.ItemInformation;
import server.MapleItemInformationProvider;
import server.MapleSquad;
import server.MobSkillData;
import server.Randomizer;
import server.Timer;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MobSkill;
import server.life.OverrideMonsterStats;
import server.maps.Event_PyramidSubway;
import server.maps.MapleMap;
import server.quest.MapleQuest;
import tools.ExternalCodeLongTableGetter;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.packet.UIPacket;

public class MapScriptMethods {
    private static final /* synthetic */ Point d;
    private static final /* synthetic */ String[] ALLATORIxDEMO;

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2, int a3) {
        int n2 = 3;
        int n3 = 4;
        if (GameSetConstants.MAPLE_VERSION >= 152) {
            n2 = 4;
            n3 = 5;
        }
        MapleClient mapleClient = a2;
        mapleClient.sendPacket(MaplePacketCreator.environmentChange(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"0\t\u001e\u0007\u001a\u0001[\u0015\u0000\u0007\u0006\u0012"), n3));
        mapleClient.sendPacket(MaplePacketCreator.environmentChange(MapleSidekick.ALLATORIxDEMO("\u0007\u001f\t\u0011\r\u0017L\u0003\u0017\u0011\u0011\u0004L\u0003\u0017\u0011\u0004\u0015"), n2));
        a2.sendPacket(MaplePacketCreator.environmentChange("dojang/start/number/" + a3, n2));
        a2.sendPacket(MaplePacketCreator.trembleEffect(0, 1));
    }

    private static final /* synthetic */ int H(int a2) {
        if (a2 <= 5) {
            return 5;
        }
        if (a2 >= 7 && a2 <= 11) {
            return 6;
        }
        if (a2 >= 13 && a2 <= 17) {
            return 7;
        }
        if (a2 >= 19 && a2 <= 23) {
            return 8;
        }
        if (a2 >= 25 && a2 <= 29) {
            return 9;
        }
        if (a2 >= 31 && a2 <= 35) {
            return 10;
        }
        if (a2 >= 37 && a2 <= 38) {
            return 15;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void startScript_User(final MapleClient a, String a) {
        if (a.getPlayer() == null) {
            return;
        }
        if (a.getPlayer().hasGmLevel(5)) {
            a.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u60a8\u5df2\u7d93\u5efa\u7acb\u8207\u5730\u5716\u8173\u672c:" + a + "\u7684\u9023\u63a5\u3002(User)");
        }
        if (a.isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a.getPlayer().getChrInfo("\u5df2\u7d93\u5efa\u7acb\u8207\u5730\u5716\u8173\u672c:" + a + "\u7684\u9023\u63a5\u3002(User)"));
        }
        var2_2 = "";
        if (NPCScriptManager.getInstance().onUserEnter(a, a) != false) return;
        block1 : switch (12.ALLATORIxDEMO[onUserEnter.ALLATORIxDEMO(a).ordinal()]) {
            case 1: {
                v0 = a;
                MapScriptMethods.H(v0, "Effect/Direction.img/cygnusJobTutorial/Scene" + (v0.getPlayer().getMapId() - 913040100));
                return;
            }
            case 2: {
                if (GameSetConstants.MAPLE_VERSION < 134) {
                    v1 = a;
                    MapScriptMethods.H(v1, "Effect/Direction.img/cygnusJobTutorial/Scene" + (v1.getPlayer().getMapId() - 913040100));
                    return;
                }
                v2 = a;
                MapScriptMethods.H(v2, "Effect/Direction.img/cygnus/Scene" + (v2.getPlayer().getMapId() == 913040006 ? 9 : a.getPlayer().getMapId() - 913040000));
                return;
            }
            case 3: {
                v3 = a;
                v3.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0015\u001c\u0007\u0019\u000b\u001b\u0015+*\u0015\u0015\u00005\u0000\u0007\u0013\u0003"), String.valueOf(v3.getPlayer().getMapId() % 1000 / 100)));
                if (a.getPlayer().getEventInstance() == null) return;
                if (a.getPlayer().getMapId() != 921120500) return;
                NPCScriptManager.getInstance().dispose(a);
                NPCScriptManager.getInstance().start(a, 2022006);
                return;
            }
            case 4: {
                var3_3 = a.getChannelServer().getEventSM().getEventManager(MapleSidekick.ALLATORIxDEMO("?\u0011\u0012\n\u00033!"));
                if (var3_3 == null) return;
                if (var3_3.getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0016\u0006\u0003")).equals(MapleSidekick.ALLATORIxDEMO("@")) == false) return;
                NPCScriptManager.getInstance().dispose(a);
                NPCScriptManager.getInstance().start(a, 2013001);
                return;
            }
            case 5: {
                v4 = a;
                v5 = a;
                v6 = a;
                v7 = a;
                a.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"$4\u0015\u000f\u00109\u0011\u001e\u00046\u0011\b\u0015\n\u0000\u001f"), MapleSidekick.ALLATORIxDEMO("@")));
                v7.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"6&\u0007\u001d\u0002+#\u0018\u0007\u0004\u0015\u0007\u0003\u00102\u001d\u000b\u0011'\u0000 \u001d\u0003\u0018\u0002"), MapleSidekick.ALLATORIxDEMO("@")));
                v7.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"6&\u0007\u001d\u0002+6\u001b\u000f\u001a\u0012"), MapleSidekick.ALLATORIxDEMO("NA")));
                v6.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"6&\u0007\u001d\u0002+$\u001b\b\u0001\u0015"), MapleSidekick.ALLATORIxDEMO("NA")));
                v6.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"6&\u0007\u001d\u0002+2\u001b\u0012\u0015\n"), MapleSidekick.ALLATORIxDEMO("NA")));
                v5.sendPacket(MaplePacketCreator.sendPyramidEnergy(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"$4\u0015\u000f\u00109 \u0003\u0015\u000b"), ""));
                v4.sendPacket(MaplePacketCreator.sendPyramidEnergy(MapleSidekick.ALLATORIxDEMO("3\"\u0002\u0019\u0007/*\u00031\u0015\u0015\u0019\u0015\u0015"), \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V")));
                v5.getPlayer().writePoint(MapleSidekick.ALLATORIxDEMO(" 1\u0011\n\u0014< \f\u0019\r\u0004"), \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"YW"));
                v4.getPlayer().writeStatus(MapleSidekick.ALLATORIxDEMO("\"\u0006\u0014<#\u0017\u0011\u0004\u0015"), "1");
                v4.getPlayer().writeStatus(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"6\n\u0001\u0003+5\u0000\u0007\u0013\u0003"), "1");
                v4.getPlayer().writeStatus(MapleSidekick.ALLATORIxDEMO("\u0002\u0006\u00147\u0015\u0002\u001d'\u0011\u000e\u0011\u0004\u0015"), \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V"));
                v4.getPlayer().writeStatus(MapleSidekick.ALLATORIxDEMO("\u0001\u001c\u0016\u00157\u0015\u0002\u001d'\u0011\u000e\u0011\u0004\u0015"), \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V"));
                return;
            }
            case 6: {
                a.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u9069\u5068\u5740\u5775\u616f\u89d9\u9600\u688d\u689e\u76e7^M\u6779\u7a4d\u83db\u546e\u76f4\u5924\u605a\u617c\u89caM^"), 5120025);
                return;
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 32: {
                if (a.getPlayer().getMapId() == 925020003) {
                    a.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u600b\u55e8\u60ce\uff78\u5d94\u5bf8\u6276\u6b12\u9613\u9027\u5852\u6234\u676f\u76f0\u6a75\u5c10\u6377\u6244\u3064"), 5120024);
                }
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 33: 
            case 34: 
            case 35: 
            case 36: {
                v8 = a;
                v8.sendPacket(UIPacket.IntroDisableUI(false));
                v8.sendPacket(UIPacket.IntroLock(false));
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 37: {
                a.getPlayer().getMap().startMapEffect(MapScriptMethods.ALLATORIxDEMO[Randomizer.nextInt(MapScriptMethods.ALLATORIxDEMO.length)], 5120024);
                return;
            }
            case 38: {
                a.getPlayer().writeMulungEnergy();
                return;
            }
            case 39: 
            case 40: {
                a.getPlayer().cancelEffect(MapleItemInformationProvider.getInstance().getItemEffect(2210016), false, -1L);
                return;
            }
            case 41: {
                v9 = a;
                MapScriptMethods.H(v9, "Effect/Direction3.img/goAdventure/Scene" + (v9.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1"));
                return;
            }
            case 42: {
                v10 = a;
                MapScriptMethods.H(v10, "Effect/Direction4.img/crash/Scene" + (v10.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1"));
                return;
            }
            case 43: {
                v11 = a;
                MapScriptMethods.H(v11, "Effect/Direction4.img/getDragonEgg/Scene" + (v11.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1"));
                return;
            }
            case 44: {
                v12 = a;
                MapScriptMethods.H(v12, "Effect/Direction4.img/meetWithDragon/Scene" + (v12.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1"));
                return;
            }
            case 45: {
                v13 = a;
                MapScriptMethods.H(v13, "Effect/Direction4.img/PromiseDragon/Scene" + (v13.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1"));
                return;
            }
            case 46: {
                switch (a.getPlayer().getMapId()) {
                    case 900090000: {
                        var2_2 = "Effect/Direction4.img/promotion/Scene0" + (a.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1");
                        v14 = a;
                        break;
                    }
                    case 900090001: {
                        var2_2 = MapleSidekick.ALLATORIxDEMO("&\u0016\u0005\u0015\u0000\u0004L4\n\u0002\u0006\u0013\u0017\u0019\f\u001eW^\n\u001d\u0004_\u0013\u0002\f\u001d\f\u0004\n\u001f\r_0\u0013\u0006\u001e\u0006A");
                        v14 = a;
                        break;
                    }
                    case 900090002: {
                        var2_2 = "Effect/Direction4.img/promotion/Scene2" + (a.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1");
                        v14 = a;
                        break;
                    }
                    case 900090003: {
                        var2_2 = MapleSidekick.ALLATORIxDEMO("&\u0016\u0005\u0015\u0000\u0004L4\n\u0002\u0006\u0013\u0017\u0019\f\u001eW^\n\u001d\u0004_\u0013\u0002\f\u001d\f\u0004\n\u001f\r_0\u0013\u0006\u001e\u0006C");
                        v14 = a;
                        break;
                    }
                    case 900090004: {
                        v15 = a;
                        v16 = a;
                        v16.sendPacket(UIPacket.IntroDisableUI(false));
                        v15.sendPacket(UIPacket.IntroLock(false));
                        v16.sendPacket(MaplePacketCreator.enableActions());
                        v17 = var3_4 = v15.getChannelServer().getMapFactory().getMap(900010000);
                        v15.getPlayer().changeMap(v17, v17.getPortal(0));
                        return;
                    }
                    default: {
                        v14 = a;
                    }
                }
                MapScriptMethods.H(v14, (String)var2_2);
                return;
            }
            case 47: {
                v18 = a;
                v18.sendPacket(UIPacket.IntroDisableUI(false));
                v18.sendPacket(UIPacket.IntroLock(false));
                v18.sendPacket(MaplePacketCreator.enableActions());
                a.sendPacket(UIPacket.MapEff(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0012\u0011\u000b\u0015\"[\u0003\u001a\u0012\u0011\u0014[\u000b\u0001\u0015\u001c%\u0015\u0012\u0018\u0003")));
                return;
            }
            case 48: {
                if (a.getPlayer().getMapId() == 104000000) {
                    v19 = a;
                    v20 = a;
                    v20.sendPacket(UIPacket.IntroDisableUI(false));
                    v19.sendPacket(UIPacket.IntroLock(false));
                    v20.sendPacket(MaplePacketCreator.enableActions());
                    v19.sendPacket(UIPacket.MapNameDisplay(v19.getPlayer().getMapId()));
                }
                var3_5 = null;
                var4_9 = MapleQuest.MedalQuest.values();
                var5_13 = ((MapleQuest.MedalQuest[])var4_9).length;
                v21 = var6_17 = 0;
lbl153:
                // 2 sources

                while (true) {
                    if (v21 < var5_13) {
                        var7_18 = var4_9[var6_17];
                        var8_19 = var7_18.maps;
                        var9_21 = var7_18.maps.length;
                        v22 = var10_22 = 0;
                        break block1;
                    }
                    if (var3_5 == null) return;
                    if (a.getPlayer().getLevel() < var3_5.level) return;
                    if (a.getPlayer().getQuestStatus(var3_5.questid) == 2) return;
                    if (a.getPlayer().getQuestStatus(var3_5.lquestid) != 1) {
                        MapleQuest.getInstance(var3_5.lquestid).forceStart(a.getPlayer(), 0, MapleSidekick.ALLATORIxDEMO("@"));
                    }
                    if (a.getPlayer().getQuestStatus(var3_5.questid) != 1) {
                        MapleQuest.getInstance(var3_5.questid).forceStart(a.getPlayer(), 0, null);
                        var4_9 = new StringBuilder(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0011\b\u0000\u0003\u0006["));
                        v23 = var5_13 = 0;
                        while (v23 < var3_5.maps.length) {
                            var4_9.append(MapleSidekick.ALLATORIxDEMO("@"));
                            v23 = ++var5_13;
                        }
                        a.getPlayer().updateInfoQuest(var3_5.questid - 2005, var4_9.toString());
                        MapleQuest.getInstance(var3_5.questid - 1995).forceStart(a.getPlayer(), 0, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V"));
                    }
                    v24 = a;
                    var4_9 = v24.getPlayer().getInfoQuest(var3_5.questid - 2005);
                    var5_14 = v24.getPlayer().getQuestNAdd(MapleQuest.getInstance(var3_5.questid - 1995));
                    if (var5_14.getCustomData() == null) {
                        var5_14.setCustomData(MapleSidekick.ALLATORIxDEMO("@"));
                    }
                    var6_17 = Integer.parseInt(var5_14.getCustomData());
                    var7_18 = new StringBuilder(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0011\b\u0000\u0003\u0006["));
                    var8_20 = false;
                    v25 = var9_21 = 0;
                    while (true) {
                        if (v25 >= var3_5.maps.length) {
                            if (var8_20 == false) return;
                            v26 = var3_5;
                            a.getPlayer().updateInfoQuest(v26.questid - 2005, var7_18.toString());
                            v27 = a;
                            MapleQuest.getInstance(v26.questid - 1995).forceStart(v27.getPlayer(), 0, String.valueOf(++var6_17));
                            v27.getPlayer().dropMessage(-1, "\u8a2a\u554f " + var6_17 + "/" + var3_5.maps.length + " \u500b\u5730\u5340.");
                            a.getPlayer().dropMessage(-1, "\u7a31\u865f " + String.valueOf((Object)var3_5) + " \u5df2\u5b8c\u6210\u4e86");
                            a.sendPacket(MaplePacketCreator.showQuestMsg("\u7a31\u865f " + String.valueOf((Object)var3_5) + " \u5df2\u5b8c\u6210\u8a2a\u554f " + var6_17 + "/" + var3_5.maps.length + " \u500b\u5730\u5340"));
                            return;
                        }
                        try {
                            var10_24 = false;
                            if (a.getPlayer().getMapId() == var3_5.maps[var9_21] && !var4_9.trim().equals("") && var4_9.substring(var9_21 + 6, var9_21 + 7).equals(MapleSidekick.ALLATORIxDEMO("@"))) {
                                var7_18.append("1");
                                var10_24 = true;
                                var8_20 = true;
                            }
                            if (!var4_9.trim().equals("") && !var10_24) {
                                var7_18.append(var4_9.substring(var9_21 + 6, var9_21 + 7));
                            }
                        }
                        catch (Exception var10_25) {
                            FilePrinter.printError(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"+'+\u0011\u0012\u001c\t\u0010F8\u0003\u001a\u0001\u0000\u000eT#\u0006\u0014\u001b\u0014"), var10_25, (String)var4_9);
                        }
                        v25 = ++var9_21;
                    }
                    break;
                }
            }
            case 49: 
            case 50: {
                v28 = a;
                v28.sendPacket(UIPacket.IntroDisableUI(false));
                v28.sendPacket(UIPacket.IntroLock(false));
                a.sendPacket(MaplePacketCreator.enableActions());
            }
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 61: {
                v29 = a;
                v29.sendPacket(UIPacket.MapNameDisplay(v29.getPlayer().getMapId()));
                return;
            }
            case 62: {
                v30 = a;
                MapScriptMethods.H(v30, "Effect/Direction3.img/archer/Scene" + (v30.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1"));
                return;
            }
            case 63: {
                v31 = a;
                MapScriptMethods.H(v31, "Effect/Direction3.img/pirate/Scene" + (v31.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1"));
                return;
            }
            case 64: {
                v32 = a;
                MapScriptMethods.H(v32, "Effect/Direction3.img/rogue/Scene" + (v32.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1"));
                return;
            }
            case 65: {
                v33 = a;
                MapScriptMethods.H(v33, "Effect/Direction3.img/magician/Scene" + (v33.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1"));
                return;
            }
            case 66: {
                v34 = a;
                MapScriptMethods.H(v34, "Effect/Direction3.img/swordman/Scene" + (v34.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1"));
                return;
            }
            case 67: {
                v35 = a;
                MapScriptMethods.H(v35, "Effect/Direction3.img/goLith/Scene" + (v35.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1"));
                return;
            }
            case 68: {
                MapScriptMethods.H(a, MapleSidekick.ALLATORIxDEMO("&\u0016\u0005\u0015\u0000\u0004L4\n\u0002\u0006\u0013\u0017\u0019\f\u001eQ^\n\u001d\u0004_\f\u0000\u0006\u001e"));
                return;
            }
            case 69: {
                MapScriptMethods.H(a, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"1\u0000\u0012\u0003\u0017\u0012[\"\u001d\u0014\u0011\u0005\u0000\u000f\u001b\bFH\u001d\u000b\u0013I\u0013\u0007\u0007\u000f"));
                return;
            }
            case 70: {
                return;
            }
            case 71: {
                switch (a.getPlayer().getMapId()) {
                    case 914090010: {
                        var2_2 = MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rAM\u0019\u000e\u0017L\u0011\u0011\u0011\r$\u0016\u0004\f\u0002\n\u0011\u000f_0\u0013\u0006\u001e\u0006@");
                        v36 = a;
                        break;
                    }
                    case 914090011: {
                        var2_2 = "Effect/Direction1.img/aranTutorial/Scene1" + (a.getPlayer().getGender() == 0 ? \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V") : "1");
                        v36 = a;
                        break;
                    }
                    case 914090012: {
                        var2_2 = "Effect/Direction1.img/aranTutorial/Scene2" + (a.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1");
                        v36 = a;
                        break;
                    }
                    case 914090013: {
                        var2_2 = \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aWZ\u000f\u0019\u0001[\u0007\u0006\u0007\u001a2\u0001\u0012\u001b\u0014\u001d\u0007\u0018I'\u0005\u0011\b\u0011U");
                        v36 = a;
                        break;
                    }
                    case 914090100: {
                        var2_2 = "Effect/Direction1.img/aranTutorial/HandedPoleArm" + (a.getPlayer().getGender() == 0 ? MapleSidekick.ALLATORIxDEMO("@") : "1");
                        v36 = a;
                        break;
                    }
                    case 914090200: {
                        var2_2 = \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aWZ\u000f\u0019\u0001[\u0007\u0006\u0007\u001a2\u0001\u0012\u001b\u0014\u001d\u0007\u0018I9\u0007\u001c\u0007");
                    }
                    default: {
                        v36 = a;
                    }
                }
                MapScriptMethods.H(v36, (String)var2_2);
                return;
            }
            case 72: {
                v37 = a;
                v38 = a;
                v39 = a;
                v39.getPlayer().changeSkillLevel(SkillFactory.getSkill(20000014), -1, 0, -1L);
                v39.getPlayer().changeSkillLevel(SkillFactory.getSkill(20000015), -1, 0, -1L);
                v39.getPlayer().changeSkillLevel(SkillFactory.getSkill(20000016), -1, 0, -1L);
                v38.getPlayer().changeSkillLevel(SkillFactory.getSkill(20000017), -1, 0, -1L);
                v38.getPlayer().changeSkillLevel(SkillFactory.getSkill(20000018), -1, 0, -1L);
                v38.sendPacket(UIPacket.ShowWZEffect(MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rAM\u0019\u000e\u0017L\u0011\u0011\u0011\r$\u0016\u0004\f\u0002\n\u0011\u000f_ \u001c\n\u0013\b<\n\u0002\n\u001e")));
                v37.sendPacket(UIPacket.IntroDisableUI(false));
                v37.sendPacket(UIPacket.IntroLock(false));
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 73: {
                if (a.getPlayer().getInfoQuest(21019).equals(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u000b\u001d\u0015\u0007[\u001b]\u001c\u0003\u0018\u0016\u0011\u0014I\u0005\u0018\u0003\u0015\u0014")) == false) return;
                v40 = a;
                v40.getPlayer().updateInfoQuest(21019, MapleSidekick.ALLATORIxDEMO("\u001d\n\u0003\u0010M\fK\u0002\u0002\u0011M\fK\u000b\u0015\u000f\u0000\u0006\u0002^\u0013\u000f\u0015\u0002\u0002"));
                v40.sendPacket(UIPacket.AranTutInstructionalBalloon(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"1\u0000\u0012\u0003\u0017\u0012[)\u001a3\u0007\u0003\u0006#\u0012\u0000Z\u000f\u0019\u0001[\u0001\u0001\u000f\u0010\u00031\u0000\u0012\u0003\u0017\u0012[\u0007\u0006\u0007\u001a2\u0001\u0012\u001b\u0014\u001d\u0007\u0018I\u0000\u0013\u0000\t\u0006\u000f\u0015\n5\u0014\u0006\t\u0003U")));
                return;
            }
            case 74: {
                if (a.getPlayer().getQuestStatus(21101) == 2 && a.getPlayer().getInfoQuest(21019).equals(MapleSidekick.ALLATORIxDEMO("\u001d\n\u0003\u0010M\fK\u0002\u0002\u0011M\fK\u000b\u0015\u000f\u0000\u0006\u0002^\u0013\u000f\u0015\u0002\u0002"))) {
                    a.getPlayer().updateInfoQuest(21019, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0019\u000f\u0007\u0015I\tO\u0007\u0006\u0014I\tO\u0005\u001f[E]\u001c\u0003\u0018\u0016\u0011\u0014I\u0005\u0018\u0003\u0015\u0014"));
                }
                a.sendPacket(UIPacket.IntroDisableUI(false));
                a.sendPacket(UIPacket.IntroLock(false));
                return;
            }
            case 75: {
                return;
            }
            case 76: {
                if (a.getPlayer().getPyramidSubway() != null) return;
                a.getPlayer().setPyramidSubway(new Event_PyramidSubway(a.getPlayer()));
                return;
            }
            case 77: {
                a.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\b\u0019\u000f\u001c\n\u001e\u0004_\u0005\u0011\n\u001c")));
                return;
            }
            case 78: {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 79: {
                v41 = a;
                v41.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0004\u0003\u0004\u0003?\u000f\u001a\u0001[\u0000\u0006\u0007\u0019\u0003[1")));
                if (v41.getPlayer().getMap().getAllMonster().isEmpty()) {
                    var3_6 = Randomizer.rand(0, 2);
                    var4_10 = MapleLifeFactory.getMonster(3300005 + var3_6);
                    v42 = var5_15 = new OverrideMonsterStats();
                    v43 = var4_10;
                    v44 = var5_15;
                    v44.setOExp(7110);
                    v44.setOHp(var4_10.getMobMaxHp());
                    v42.setOMp(v43.getMobMaxMp());
                    v43.setOverrideStats(v42);
                    a.getPlayer().getMap().spawnMonsterOnGroundBelow(var4_10, new Point(358, -68));
                    switch (var3_6) {
                        case 0: {
                            a.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\u0000\u0006\u0000\u0006;\n\u001e\u0004_\u0013\u0015\u0013\u0015L\u0000\u0006\u0000\u00062")));
                            break;
                        }
                        case 1: {
                            a.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0016\u0011\u0016\u0011-\u001d\b\u0013I\u0004\u0003\u0004\u0003[\u0016\u0011\u0016\u0011!")));
                            break;
                        }
                        case 2: {
                            a.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\u0000\u0006\u0000\u0006;\n\u001e\u0004_\u0013\u0015\u0013\u0015L\u0000\u0006\u0000\u0006'")));
                            break;
                        }
                    }
                } else {
                    a.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0016\u0011\u0016\u0011-\u001d\b\u0013I\u0004\u0003\u0004\u0003[\u0016\u0011\u0016\u0011$")));
                }
                a.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\u0013\u0015\u0013\u0015(\u0019\r\u0017L\u0013\u000b\u0011\u0017_\r\u0005\u0004\u0005")));
                a.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0004\u0003\u0004\u0003?\u000f\u001a\u0001[\u0000\u0006\u0007\u0019\u0003[$")));
                return;
            }
            case 80: {
                a.getPlayer().getMap().resetFully();
                return;
            }
            case 81: 
            case 82: {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 83: {
                MapScriptMethods.H(a, MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rDM\u0019\u000e\u0017L\u0013\u0002\u001e\r\u001f\r\u0003\u000b\u001f\f\u0004\u0006\u0002L#\u0000\u0015\r\u0015S@"));
                MapScriptMethods.H(a, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aRZ\u000f\u0019\u0001[\u0005\u0015\b\u001a\t\u001a\u0015\u001c\t\u001b\u0012\u0011\u0014[\t\u0001\u0012DV"));
                return;
            }
            case 84: {
                v45 = a;
                v46 = a;
                v47 = a;
                a.sendPacket(UIPacket.IntroDisableUI(true));
                v47.sendPacket(UIPacket.IntroLock(true));
                v47.sendPacket(UIPacket.getDirectionInfo(MapleSidekick.ALLATORIxDEMO("&\u0016\u0005\u0015\u0000\u0004L4\n\u0002\u0006\u0013\u0017\u0019\f\u001eW^\n\u001d\u0004_\u0006\u0016\u0005\u0015\u0000\u0004L\u0013\u0002\u001e\r\u001f\r\u0003\u000b\u001f\f\u0004\u0006\u0002L\u0012\u0002\u001c\u000f\u001f\f\u001eL@"), 5000, 0, 0, 1));
                v46.sendPacket(UIPacket.getDirectionInfo(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"1\u0000\u0012\u0003\u0017\u0012[\"\u001d\u0014\u0011\u0005\u0000\u000f\u001b\b@H\u001d\u000b\u0013I\u0011\u0000\u0012\u0003\u0017\u0012[\u0005\u0015\b\u001a\t\u001a\u0015\u001c\t\u001b\u0012\u0011\u0014[\u0004\u0015\n\u0018\t\u001b\b[W"), 5000, 0, 0, 1));
                v46.sendPacket(UIPacket.getDirectionInfo(MapleSidekick.ALLATORIxDEMO("&\u0016\u0005\u0015\u0000\u0004L4\n\u0002\u0006\u0013\u0017\u0019\f\u001eW^\n\u001d\u0004_\u0006\u0016\u0005\u0015\u0000\u0004L\u0013\u0002\u001e\r\u001f\r\u0003\u000b\u001f\f\u0004\u0006\u0002L\u0012\u0002\u001c\u000f\u001f\f\u001eLB"), 5000, 0, 0, 1));
                v45.sendPacket(UIPacket.ShowWZEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"1\u0000\u0012\u0003\u0017\u0012[\"\u001d\u0014\u0011\u0005\u0000\u000f\u001b\b@H\u001d\u000b\u0013I\u0017\u0007\u001a\b\u001b\b\u0007\u000e\u001b\t\u0000\u0003\u0006I\u0012\u0007\u0017\u0003DR")));
                v45.sendPacket(UIPacket.ShowWZEffect(MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rDM\u0019\u000e\u0017L\u0013\u0002\u001e\r\u001f\r\u0003\u000b\u001f\f\u0004\u0006\u0002L\u001f\u0016\u0004SA")));
                a.sendPacket(UIPacket.getDirectionInfo(1, 5000));
                return;
            }
            case 85: {
                MapScriptMethods.H(a, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aRZ\u000f\u0019\u0001[\u0005\u0015\b\u001a\t\u001a\u0015\u001c\t\u001b\u0012\u0011\u0014[5\u0017\u0003\u001a\u0003DW"));
                MapScriptMethods.H(a, MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rDM\u0019\u000e\u0017L\u0013\u0002\u001e\r\u001f\r\u0003\u000b\u001f\f\u0004\u0006\u0002L\u001f\u0016\u0004SB"));
                return;
            }
            case 86: {
                if (a.getPlayer().getEventInstance() == null) return;
                if (a.getPlayer().getMapId() != 932000300) return;
                NPCScriptManager.getInstance().dispose(a);
                a.removeClickedNPC();
                NPCScriptManager.getInstance().start(a, 2159020, null);
                return;
            }
            case 87: {
                if (a.getPlayer().isGM() != false) return;
                v48 = a;
                v48.getPlayer().getQuestNAdd(MapleQuest.getInstance(123455)).setCustomData(String.valueOf(System.currentTimeMillis()));
                var3_7 = v48.getPlayer().getQuestNAdd(MapleQuest.getInstance(123456));
                if (var3_7.getCustomData() == null) return;
                var4_11 = Integer.parseInt(var3_7.getCustomData());
                if (var4_11 <= 0) return;
                a.getPlayer().startMapTimeLimitTask(var4_11, a.getChannelServer().getMapFactory().getMap(100000000));
                return;
            }
            case 88: {
                a.getPlayer().getMap().resetFully();
                return;
            }
            case 89: {
                if (a.getPlayer().getMapId() == 922010400) {
                    var3_8 = a.getChannelServer().getMapFactory();
                    var4_12 = 0;
                    v49 = var5_16 = 0;
                    while (true) {
                        if (v49 >= 5) {
                            if (var4_12 <= 0) return;
                            a.getPlayer().dropMessage(-1, "There are still " + var4_12 + " monsters remaining.");
                            return;
                        }
                        v50 = var3_8.getMap(922010401 + var5_16).getAllMonstersThreadsafe();
                        var4_12 += v50.size();
                        v49 = ++var5_16;
                    }
                }
                if (a.getPlayer().getMapId() < 922010401) return;
                if (a.getPlayer().getMapId() > 922010405) return;
                v51 = a;
                if (a.getPlayer().getMap().getAllMonstersThreadsafe().size() > 0) {
                    v51.getPlayer().dropMessage(-1, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)" \u000e\u0011\u0014\u0011F\u0015\u0014\u0011F\u0007\u0012\u001d\n\u0018F\u0007\t\u0019\u0003T\u000b\u001b\b\u0007\u0012\u0011\u0014\u0007F\u0006\u0003\u0019\u0007\u001d\b\u001d\b\u0013F\u001d\bT\u0012\u001c\u000f\u0007F\u0019\u0007\u0004H"));
                    return;
                }
                v51.getPlayer().dropMessage(-1, MapleSidekick.ALLATORIxDEMO("7\u0018\u0006\u0002\u0006P\u0002\u0002\u0006P\r\u001fC\u001d\f\u001e\u0010\u0004\u0006\u0002\u0010P\u0011\u0015\u000e\u0011\n\u001e\n\u001e\u0004P\n\u001eC\u0004\u000b\u0019\u0010P\u000e\u0011\u0013^"));
                return;
            }
            case 90: {
                if (a.getPlayer().getQuestStatus(31102) != 1) return;
                MapleQuest.getInstance(31102).forceComplete(a.getPlayer(), 2140000);
                return;
            }
            case 91: {
                if (a.getPlayer().getQuestStatus(31103) != 0) return;
                MapleQuest.getInstance(31103).forceComplete(a.getPlayer(), 2142003);
                return;
            }
            case 92: {
                a.sendPacket(UIPacket.MapEff(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0006\u0003\u0007\u000f\u0007\u0012\u0015\b\u0017\u0003[\u0012\u0001\u0012\u001b\u0014\u001d\u0007\u0018!\u0001\u000f\u0010\u0003")));
                return;
            }
            case 93: {
                a.sendPacket(UIPacket.AranTutInstructionalBalloon(MapleSidekick.ALLATORIxDEMO("&\u0016\u0005\u0015\u0000\u0004L?\r%\u0010\u0015\u00115\u0005\u0016M\u0019\u000e\u0017L\u0017\u0016\u0019\u0007\u0015&\u0016\u0005\u0015\u0000\u0004L\u0002\u0006\u0003\n\u0003\u0017\u0011\r\u0013\u0006$\u0016\u0004\f\u0002\n\u0011\u000f_\u0016\u0003\u0006\u00027\u0011\u000f\u001b")));
                return;
            }
            case 94: {
                NPCScriptManager.getInstance().dispose(a);
                a.removeClickedNPC();
                NPCScriptManager.getInstance().start(a, 2159012, null);
                return;
            }
            case 95: {
                v52 = a;
                v53 = a;
                v53.sendPacket(UIPacket.IntroDisableUI(false));
                v52.sendPacket(UIPacket.IntroLock(false));
                v53.sendPacket(MaplePacketCreator.enableActions());
                NPCScriptManager.getInstance().dispose(a);
                v52.removeClickedNPC();
                NPCScriptManager.getInstance().start(a, 2159006, null);
                return;
            }
            case 96: {
                MapScriptMethods.H(a, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"1\u0000\u0012\u0003\u0017\u0012[\"\u001d\u0014\u0011\u0005\u0000\u000f\u001b\b@H\u001d\u000b\u0013I&\u0003\u0007\u000f\u0007\u0012\u0015\b\u0017\u0003[2\u0015\n\u001f,"));
                return;
            }
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 109: 
            case 110: 
            case 111: 
            case 112: 
            case 113: 
            case 114: 
            case 115: {
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 116: {
                if (a.getPlayer().getQuestStatus(24001) != 1) return;
                MapleQuest.getInstance(24001).forceComplete(a.getPlayer(), 0);
                a.getPlayer().dropMessage(5, MapleSidekick.ALLATORIxDEMO("!\u0016\u0015\u0010\u0004C\u0013\f\u001d\u0013\u001c\u0006\u0004\u0006^"));
                return;
            }
            case 117: {
                v54 = a;
                MapScriptMethods.H(v54, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aSZ\u000f\u0019\u0001[\u000b\u0011\u0014\u0007\u0003\u0010\u0003\u00072\u0001\u0012\u001b\u0014\u001d\u0007\u0018I'\u0005\u0011\b\u0011V"));
                v54.getPlayer().changeSkillLevel(SkillFactory.getSkill(20021181), -1, 0);
                v54.getPlayer().changeSkillLevel(SkillFactory.getSkill(20021166), -1, 0);
                v54.getPlayer().changeSkillLevel(SkillFactory.getSkill(20020109), 1, 1);
                v54.getPlayer().changeSkillLevel(SkillFactory.getSkill(20021110), 1, 1);
                v54.getPlayer().changeSkillLevel(SkillFactory.getSkill(20020111), 1, 1);
                v54.getPlayer().changeSkillLevel(SkillFactory.getSkill(20020112), 1, 1);
                return;
            }
            case 118: {
                v55 = a;
                while (true) {
                    if (v55.getPlayer().getLevel() >= 10) {
                        a.getPlayer().changeJob(2300);
                        MapScriptMethods.H(a, MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rEM\u0019\u000e\u0017L\u001d\u0006\u0002\u0010\u0015\u0007\u0015\u0010$\u0016\u0004\f\u0002\n\u0011\u000f_0\u0013\u0006\u001e\u0006A"));
                        return;
                    }
                    v56 = a;
                    v55 = v56;
                    v56.getPlayer().levelUp();
                }
            }
            case 119: {
                a.sendPacket(UIPacket.IntroEnableUI(0));
                return;
            }
            case 120: {
                v57 = a;
                v57.sendPacket(UIPacket.playMovie(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"9\u0003\u0006\u0005\u0011\u0002\u0011\u0015Z\u0007\u0002\u000f"), true));
                v57.getPlayer().changeSkillLevel(SkillFactory.getSkill(20021181), 1, 1);
                v57.getPlayer().changeSkillLevel(SkillFactory.getSkill(20021166), 1, 1);
                return;
            }
            case 121: {
                v58 = a;
                v59 = a;
                v59.sendPacket(UIPacket.getDirectionStatus(true));
                v59.sendPacket(UIPacket.getDirectionInfo(MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rEM\u0019\u000e\u0017L\u0015\u0005\u0016\u0006\u0013\u0017_\u000e\u0015\u0011\u0013\u0006\u0014\u0006\u0003*\u001e*\u0013\u0006_\u000e\u0015\u00112\u0002\u001c\u000f\u001f\f\u001eLF"), 2000, 0, -100, 1));
                v58.sendPacket(UIPacket.getDirectionInfo(1, 2000));
                v58.sendPacket(UIPacket.IntroEnableUI(1));
                a.getPlayer().setDirection(0);
                return;
            }
            case 122: {
                v60 = a;
                v61 = a;
                v61.sendPacket(UIPacket.getDirectionStatus(true));
                v61.sendPacket(UIPacket.IntroEnableUI(1));
                v60.sendPacket(UIPacket.getDirectionInfo(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aSZ\u000f\u0019\u0001[\u0003\u0012\u0000\u0011\u0005\u0000I\u0019\u0003\u0006\u0005\u0011\u0002\u0011\u0015=\b=\u0005\u0011I\u0019\u0003\u0006$\u0015\n\u0018\t\u001b\b[_"), 2000, 0, -100, 1));
                v60.sendPacket(UIPacket.getDirectionInfo(1, 2000));
                a.getPlayer().setDirection(0);
                return;
            }
            case 123: {
                v62 = a;
                v62.sendPacket(UIPacket.IntroDisableUI(false));
                v62.sendPacket(UIPacket.IntroLock(false));
                a.sendPacket(MaplePacketCreator.enableActions());
                return;
            }
            case 124: {
                switch (a.getPlayer().getMapId() / 100 % 10) {
                    case 0: {
                        a.sendPacket(UIPacket.MapEff(MapleSidekick.ALLATORIxDEMO("\u0017\u0015\u000e\u0011'_\u0006\u001e\u0017\u0015\u0011_\u0017\u0015\u0011\u0011%\u001f\u0011\u0015\u0010\u0004")));
                        return;
                    }
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: {
                        v63 = a;
                        v63.sendPacket(UIPacket.MapEff("temaD/enter/neoCity" + v63.getPlayer().getMapId() / 100 % 10));
                        return;
                    }
                }
                return;
            }
            case 125: {
                a.sendPacket(UIPacket.getDirectionInfo(1, 6300));
                MapScriptMethods.H(a, \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aPZ\u000f\u0019\u0001[\"\u0011\u000b\u001b\b \u0013\u0000\t\u0006\u000f\u0015\n[5\u0017\u0003\u001a\u00038\t\u0013\t"));
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        1 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        MapleMap mapleMap;
                        1 a2;
                        1 v0 = a2;
                        v0.a.sendPacket(UIPacket.IntroDisableUI(false));
                        v0.a.sendPacket(UIPacket.IntroLock(false));
                        v0.a.sendPacket(MaplePacketCreator.enableActions());
                        MapleMap mapleMap2 = mapleMap = v0.a.getChannelServer().getMapFactory().getMap(927000000);
                        v0.a.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(0));
                    }
                }, 6300L);
                return;
            }
            case 126: {
                v64 = a;
                v65 = a;
                v66 = a;
                v66.sendPacket(UIPacket.getDirectionInfo(3, 1));
                v66.sendPacket(UIPacket.getDirectionInfo((int)true, 30));
                v65.sendPacket(UIPacket.getDirectionStatus(true));
                v65.sendPacket(UIPacket.getDirectionInfo(3, 0));
                v64.sendPacket(UIPacket.getDirectionInfo(1, 90));
                v64.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\u0007\u0015\u000e\u001f\r#\u000f\u0011\u001a\u0015\u0011_\u0017\u0015\u001b\u0004RA")));
                a.sendPacket(UIPacket.getDirectionInfo(1, 4000));
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        2 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        2 a2;
                        MapScriptMethods.H(a2.a, MapleKeyLayout.ALLATORIxDEMO("o\u001bL\u0018I\t\u00059C\u000fO\u001e^\u0014E\u0013\u001cSC\u0010MRn\u0018G\u0012D)_\tE\u000fC\u001cFRy\u001eO\u0013OO"));
                    }
                }, 1000L);
                return;
            }
            case 127: {
                v67 = a;
                v67.sendPacket(UIPacket.getDirectionInfo(3, 1));
                v67.sendPacket(UIPacket.getDirectionInfo((int)true, 30));
                a.sendPacket(UIPacket.getDirectionStatus(true));
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        3 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        3 a2;
                        3 v0 = a2;
                        v0.a.sendPacket(UIPacket.getDirectionInfo(3, 0));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(4, 2159310));
                        NPCScriptManager.getInstance().start(a2.a, 2159310, null);
                    }
                }, 1000L);
                return;
            }
            case 128: {
                v68 = a;
                v69 = a;
                v69.sendPacket(UIPacket.IntroDisableUI(true));
                v69.sendPacket(UIPacket.IntroEnableUI((int)true));
                v68.sendPacket(UIPacket.getDirectionStatus(true));
                v68.sendPacket(UIPacket.getDirectionInfo(3, 0));
                a.sendPacket(UIPacket.getDirectionInfo(4, 0x20F2F0));
                NPCScriptManager.getInstance().start(a, 0x20F2F0, null);
                return;
            }
            case 129: {
                v70 = a;
                v71 = a;
                a.sendPacket(UIPacket.IntroDisableUI((boolean)1));
                v71.sendPacket(UIPacket.IntroEnableUI(1));
                v71.sendPacket(UIPacket.getDirectionStatus(true));
                v71.getPlayer().changeSkillLevel(SkillFactory.getSkill(110), 1, 1);
                v70.sendPacket(UIPacket.getDirectionInfo(3, 0));
                v70.sendPacket(UIPacket.getDirectionInfo(3, 2));
                a.sendPacket(UIPacket.getDirectionInfo(4, 1096000));
                NPCScriptManager.getInstance().dispose(a);
                NPCScriptManager.getInstance().start(a, 1096000, null);
                return;
            }
            case 130: {
                v72 = a;
                v73 = a;
                v73.sendPacket(UIPacket.IntroDisableUI(true));
                v73.sendPacket(UIPacket.IntroEnableUI((int)true));
                v72.sendPacket(UIPacket.getDirectionStatus(true));
                v72.sendPacket(UIPacket.getDirectionInfo(3, 0));
                a.sendPacket(UIPacket.getDirectionInfo(4, 2159314));
                NPCScriptManager.getInstance().dispose(a);
                NPCScriptManager.getInstance().start(a, 2159314, null);
                return;
            }
            case 131: {
                v74 = a;
                a.sendPacket(UIPacket.getDirectionInfo(3, 1));
                v74.sendPacket(UIPacket.getDirectionInfo(1, 30));
                v74.sendPacket(UIPacket.getDirectionStatus(true));
                a.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0010\u0003\u0019\t\u001a5\u0018\u0007\r\u0003\u0006I\u0000\u0003\f\u0012ET")));
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        4 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        4 a2;
                        4 v0 = a2;
                        v0.a.sendPacket(UIPacket.getDirectionInfo(3, 0));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(4, 2159311));
                        NPCScriptManager.getInstance().dispose(a2.a);
                        NPCScriptManager.getInstance().start(a2.a, 2159311, null);
                    }
                }, 1000L);
                return;
            }
            case 132: {
                v75 = a;
                a.sendPacket(UIPacket.IntroDisableUI((boolean)1));
                v75.sendPacket(UIPacket.IntroEnableUI(1));
                v75.sendPacket(UIPacket.getDirectionStatus(true));
                if (!a.getPlayer().getMap().containsNPC(2159340)) {
                    v76 = a;
                    v76.getPlayer().getMap().spawnNpc(2159340, new Point(175, 0));
                    v76.getPlayer().getMap().spawnNpc(2159341, new Point(300, 0));
                    v76.getPlayer().getMap().spawnNpc(2159342, new Point(600, 0));
                }
                a.sendPacket(UIPacket.getDirectionInfo(MapleSidekick.ALLATORIxDEMO("5\u0005\u0016\u0006\u0013\u0017_'\u0019\u0011\u0015\u0000\u0004\n\u001f\rEM\u0019\u000e\u0017L\u0015\u0005\u0016\u0006\u0013\u0017_\u0017\u0005\u0017\u001fL\u0012\u0002\u001c\u000f\u001f\f\u001e.\u0003\u0004BL@"), 2000, 0, -100, 1));
                a.sendPacket(UIPacket.getDirectionInfo(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0012\u0000\u0011\u0005\u0000I0\u000f\u0006\u0003\u0017\u0012\u001d\t\u001aSZ\u000f\u0019\u0001[\u0003\u0012\u0000\u0011\u0005\u0000I\u0000\u0013\u0000\t[\u0004\u0015\n\u0018\t\u001b\b9\u0015\u0013W[U"), 2000, 0, -100, 1));
                Timer.EventTimer.getInstance().schedule(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        5 a2;
                        5 v0 = a2;
                        v0.a.sendPacket(UIPacket.getDirectionInfo(3, 0));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(4, 2159340));
                        NPCScriptManager.getInstance().dispose(a2.a);
                        NPCScriptManager.getInstance().start(a2.a, 2159340, null);
                    }
                    {
                        5 a2;
                    }
                }, 1000L);
                return;
            }
            case 133: {
                v77 = a;
                a.sendPacket(UIPacket.IntroEnableUI(1));
                v77.sendPacket(UIPacket.getDirectionInfo(3, 1));
                v77.sendPacket(UIPacket.getDirectionInfo((int)true, 30));
                a.sendPacket(UIPacket.getDirectionStatus(true));
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        6 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        6 a2;
                        6 v0 = a2;
                        v0.a.sendPacket(UIPacket.getDirectionInfo(3, 0));
                        v0.a.sendPacket(MaplePacketCreator.showEffect(\u5154\u5154\u8c37.ALLATORIxDEMO((String)"hDaNbr`@uD~\u000exDtU=\u0012")));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(1, 500));
                    }
                }, 1000L);
                Timer.EventTimer.getInstance().schedule(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        7 a2;
                        7 v0 = a2;
                        v0.a.sendPacket(MaplePacketCreator.showEffect(NPCHandler.ALLATORIxDEMO("\u0003f\nl\tP\u000bb\u001ef\u0015,\u0013f\u001fwV7")));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(1, 4000));
                    }
                    {
                        7 a2;
                    }
                }, 1500L);
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        8 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        MapleMap mapleMap;
                        8 a2;
                        8 v0 = a2;
                        MapleMap mapleMap2 = mapleMap = v0.a.getChannelServer().getMapFactory().getMap(927000020);
                        v0.a.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(0));
                        v0.a.sendPacket(UIPacket.IntroEnableUI(0));
                        MapleQuest.getInstance(23204).forceStart(a2.a.getPlayer(), 0, null);
                        MapleQuest.getInstance(23205).forceComplete(a2.a.getPlayer(), 0);
                        v0.a.getPlayer().changeSkillLevel(SkillFactory.getSkill(30011170), 1, 1);
                        v0.a.getPlayer().changeSkillLevel(SkillFactory.getSkill(30011169), 1, 1);
                        v0.a.getPlayer().changeSkillLevel(SkillFactory.getSkill(30011168), 1, 1);
                        v0.a.getPlayer().changeSkillLevel(SkillFactory.getSkill(30011167), 1, 1);
                        v0.a.getPlayer().changeSkillLevel(SkillFactory.getSkill(30010166), 1, 1);
                    }
                }, 5500L);
                return;
            }
            case 134: {
                v78 = a;
                v78.sendPacket(UIPacket.getDirectionInfo(3, 1));
                v78.sendPacket(UIPacket.getDirectionInfo((int)true, 30));
                a.sendPacket(UIPacket.getDirectionStatus(true));
                Timer.EventTimer.getInstance().schedule(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        9 a2;
                        9 v0 = a2;
                        v0.a.sendPacket(UIPacket.getDirectionInfo(3, 0));
                        v0.a.sendPacket(MaplePacketCreator.showEffect(MobSkillData.ALLATORIxDEMO("i\u0005`\u000fc3a\u0001t\u0005\u007fOy\u0005u\u00145")));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(1, 500));
                    }
                    {
                        9 a2;
                    }
                }, 1000L);
                Timer.EventTimer.getInstance().schedule(new Runnable(){

                    @Override
                    public /* synthetic */ void run() {
                        10 a2;
                        10 v0 = a2;
                        v0.a.sendPacket(MaplePacketCreator.showEffect(MobSkill.ALLATORIxDEMO("NOGEDyFKSOX\u0005^OR^\u0013")));
                        v0.a.sendPacket(UIPacket.getDirectionInfo(1, 3000));
                    }
                    {
                        10 a2;
                    }
                }, 1500L);
                Timer.EventTimer.getInstance().schedule(new Runnable(){
                    {
                        11 a2;
                    }

                    @Override
                    public /* synthetic */ void run() {
                        MapleMap mapleMap;
                        11 a2;
                        11 v0 = a2;
                        MapleMap mapleMap2 = mapleMap = v0.a.getChannelServer().getMapFactory().getMap(927000010);
                        v0.a.getPlayer().changeMap(mapleMap2, mapleMap2.getPortal(0));
                    }
                }, 4500L);
                return;
            }
            case 135: {
                v79 = a;
                v80 = a;
                v81 = a;
                v82 = a;
                v83 = a;
                a.sendPacket(UIPacket.getDirectionStatus((boolean)1));
                v83.sendPacket(UIPacket.IntroEnableUI(1));
                v82.sendPacket(UIPacket.IntroDisableUI(true));
                v83.getPlayer().changeSkillLevel(SkillFactory.getSkill(30011109), 1, 1);
                v82.getPlayer().changeSkillLevel(SkillFactory.getSkill(30010110), 1, 1);
                v82.getPlayer().changeSkillLevel(SkillFactory.getSkill(30010111), 1, 1);
                v82.getPlayer().changeSkillLevel(SkillFactory.getSkill(30010185), 1, 1);
                v81.sendPacket(UIPacket.getDirectionInfo(3, 0));
                v81.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\u0007\u0015\u000e\u001f\r#\u000f\u0011\u001a\u0015\u0011_\u0001\u0011\u0000\u001b")));
                v80.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0002\u0011\u000b\u001b\b'\n\u0015\u001f\u0011\u0014[\u0012\u0011\u001e\u0000V")));
                v79.sendPacket(UIPacket.getDirectionInfo(1, 500));
                v80.getPlayer().setDirection(0);
                if (v79.getPlayer().getMap().containsNPC(2159307) != false) return;
                a.getPlayer().getMap().spawnNpc(2159307, new Point(1305, 50));
                return;
            }
            case 136: {
                if (a.getPlayer().getMap().containsNPC(2159309) != false) return;
                a.getPlayer().getMap().spawnNpc(2159309, new Point(550, 50));
                return;
            }
            default: {
                System.err.println("\u672a\u8655\u7406\u7684\u8173\u672c : " + a + ", \u578b\u614b : onUserEnter - \u5730\u5716ID " + a.getPlayer().getMapId());
                FilePrinter.printError(MapleSidekick.ALLATORIxDEMO(".\u0011\u0013#\u0000\u0002\n\u0000\u0017=\u0006\u0004\u000b\u001f\u0007\u0003M\u0004\u001b\u0004"), "\u672a\u8655\u7406\u7684\u8173\u672c : " + a + ", \u578b\u614b : onUserEnter - \u5730\u5716ID " + a.getPlayer().getMapId());
                return;
            }
        }
        while (v22 < var9_21) {
            var11_26 = var8_19[var10_22];
            if (a.getPlayer().getMapId() == var11_26) {
                var3_5 = var7_18;
                break;
            }
            v22 = ++var10_22;
        }
        v21 = ++var6_17;
        ** while (true)
    }

    public /* synthetic */ MapScriptMethods() {
        MapScriptMethods a2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ void startScript_FirstUser(MapleClient a2, String a3) {
        if (a2.getPlayer() == null) {
            return;
        }
        if (a2.getPlayer().hasGmLevel(5)) {
            a2.getPlayer().dropMessage("[\u7cfb\u7d71\u63d0\u793a]\u60a8\u5df2\u7d93\u5efa\u7acb\u8207\u5730\u5716\u8173\u672c:" + a3 + "\u7684\u9023\u63a5\u3002(FirstUser)");
        }
        if (a2.isMonitored()) {
            FileoutputUtil.logToFile("logs/Hack/\u5371\u96aa\u5e33\u865f\u64cd\u4f5c/" + a2.getPlayer().getName() + "/\u5404\u5f0f\u64cd\u4f5c.txt", a2.getPlayer().getChrInfo("\u5df2\u7d93\u5efa\u7acb\u8207\u5730\u5716\u8173\u672c:" + a3 + "\u7684\u9023\u63a5\u3002(FirstUser)"));
        }
        if (NPCScriptManager.getInstance().onFirstUserEnter(a2, a3)) return;
        switch (12.d[onFirstUserEnter.H(a3).ordinal()]) {
            case 1: {
                MapleClient mapleClient = a2;
                int n2 = (mapleClient.getPlayer().getMapId() - 925000000) / 100;
                int n3 = n2 - n2 / 100 * 100;
                mapleClient.sendPacket(MaplePacketCreator.getClock(MapScriptMethods.H(n3) * 60));
                int n4 = n3;
                MapScriptMethods.ALLATORIxDEMO(mapleClient, n4 - MapScriptMethods.ALLATORIxDEMO(n4));
                return;
            }
            case 2: {
                MapScriptMethods.H(a2);
                return;
            }
            case 3: {
                MapScriptMethods.ALLATORIxDEMO(a2);
                return;
            }
            case 4: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u907f\u507f\u5756\u5762\u6179\u89ce\u9616\u689a\u6888\u76f0HZ\u676f\u7a5a\u83cd\u5479\u76e2\u5933\u604c\u616b\u89dcZH"), 5120025);
                return;
            }
            case 5: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u7cd5\u74d3\u7e2e\u676b\u7473\u76e7\u6778\u89e8\u8339\u7a4d\u5b20\u54ef\u4fad\u8b14\u6778\u7460\u5124\u5b33\uff71"), 5120016);
                return;
            }
            case 6: {
                switch (a2.getPlayer().getMapId()) {
                    case 103000800: {
                        return;
                    }
                    case 103000801: {
                        return;
                    }
                    case 103000802: {
                        return;
                    }
                    case 103000803: {
                        return;
                    }
                    case 103000804: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u8aad\u6227\u6531\u8df1\u7d7c\u7dd4\u6c52\u973cG"), 5120017);
                        return;
                    }
                }
                return;
            }
            case 7: {
                switch (a2.getPlayer().getMapId()) {
                    case 926100000: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u9079\u903e\u8adc\u6795\u5b85\u9a27\u5bc7\uff7c\u8aa8\u620e\u5253\u96c1\u85ac\u76f4\u95e3Q"), 5120021);
                        return;
                    }
                    case 926100001: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u907c\u903a\u907f\u507f\u9eb7\u66e3\u4e4b\u620a\u5256\u819e\u5d97\u76f0\u65df\u5f7bG"), 5120021);
                        return;
                    }
                    case 926100100: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u62e9\u71a2\u670c\u581b\u6e9cQ"), 5120021);
                        return;
                    }
                    case 926100200: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u906e\u9028\u6bbb\u506d\u95f4\u7314\u5fe3\u754e\u65c8\u5b80\u9a23\u4e4b\u76f0\u65e1\u4e82G"), 5120021);
                        return;
                    }
                    case 926100203: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u8aa8\u6223\u6534\u6230\u676a\u605a\u720aQ"), 5120021);
                        return;
                    }
                    case 926100300: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u906e\u9028\u5b92\u9a31\u620a\u5256\u819e\u5d97\u76f0\u65df\u5f7bG"), 5120021);
                        return;
                    }
                    case 926100401: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u8aa8\u4fad\u8b14\u6261\u76e7\u616b\u4ed9Q"), 5120021);
                        return;
                    }
                }
                return;
            }
            case 8: {
                switch (a2.getPlayer().getMapId()) {
                    case 926110000: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u906e\u9028\u8acb\u6783\u5b92\u9a31\u5bd0\uff6a\u8abf\u6218\u5244\u96d7\u85bb\u76e2\u95f4G"), 5120022);
                        return;
                    }
                    case 926110001: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u906a\u902d\u9069\u5068\u9ea1\u66f4\u4e5d\u621d\u5240\u8189\u5d81\u76e7\u65c9\u5f6cQ"), 5120022);
                        return;
                    }
                    case 926110100: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u62fe\u71b4\u671b\u580d\u6e8bG"), 5120022);
                        return;
                    }
                    case 926110200: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u9079\u903e\u6bac\u507b\u95e3\u7302\u5ff4\u7558\u65df\u5b96\u9a34\u4e5d\u76e7\u65f7\u4e95Q"), 5120022);
                        return;
                    }
                    case 926110203: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u8abf\u6235\u6523\u6226\u677d\u604c\u721dG"), 5120022);
                        return;
                    }
                    case 926110300: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u9079\u903e\u5b85\u9a27\u621d\u5240\u8189\u5d81\u76e7\u65c9\u5f6cQ"), 5120022);
                        return;
                    }
                    case 926110401: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u8abf\u4fbb\u8b03\u6277\u76f0\u617d\u4eceG"), 5120022);
                        return;
                    }
                }
                return;
            }
            case 9: {
                switch (a2.getPlayer().getMapId()) {
                    case 930000000: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u9042\u5106\u50c3\u9062\u9eae\uff6f\u6261\u89e2\u5c7d\u4f03\u5061\u65de\u654e\u8be9\u8edb\u9b37\u6ca5\u4ee5\uff71"), 5120023);
                        return;
                    }
                    case 930000100: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6dee\u6eb1\u6226\u677d\u604c\u721d\uff67"), 5120023);
                        return;
                    }
                    case 930000200: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u5c7d\u8329\u68a8\u65de\u654e\u7a63\u91bb\u76e7\u6ba2\u6dd1D\u5068\uff71"), 5120023);
                        return;
                    }
                    case 930000300: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5adb\u5ac9\u4f06\u575c\u548c\u8895\u55bc\u55aeF\u5499\u548b\u6265\u8f91\u8d9b\u4ee0"), 5120023);
                        return;
                    }
                    case 930000400: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u621d\u6261\u5c6e\u8a01\u629c\u6d98\u5375\u4e3b\u7383\u5106\u4e4e\u4e70\u5068\u96fa\u5482\u96b6\u6e9cAS\u507b\u6049\u7219\u6849\u7d16\u6272\uff71"), 5120023);
                        return;
                    }
                    case 930000500: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5fea\u604c\u4ece\u669e\u6838\u4e4b\u5c7f\u6218\u7d5f\u8214\u9b20\u52fd\u7787\uff67"), 5120023);
                        return;
                    }
                    case 930000600: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u5c64\u7d5b\u8211\u9b24\u52f8\u7783\u655d\u5758\u790e\u58b7\u4e69\uff71"), 5120023);
                        return;
                    }
                }
                return;
            }
            case 10: {
                int n5;
                MapleClient mapleClient;
                switch (a2.getPlayer().getMapId()) {
                    case 925100000: {
                        MapleClient mapleClient2 = a2;
                        mapleClient = mapleClient2;
                        mapleClient2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6227\u5074\u824d\u4e6c\u76f0\u6226\u677d\u604c\u721dG"), 5120020);
                        break;
                    }
                    case 925100100: {
                        MapleClient mapleClient3 = a2;
                        mapleClient = mapleClient3;
                        mapleClient3.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u6261\u5072\u5fb5\u986b\u8b39\u666d\u819a\u5d92\uff71\u8aa8\u7d16\u6272\u6d07\u76bf\u733e\u722fQ"), 5120020);
                        break;
                    }
                    case 925100200: {
                        MapleClient mapleClient4 = a2;
                        mapleClient = mapleClient4;
                        mapleClient4.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6227\u5074\u824d\u4e6c\u6234\u676f\u76f0\u604c\u721dG"), 5120020);
                        break;
                    }
                    case 925100300: {
                        MapleClient mapleClient5 = a2;
                        mapleClient = mapleClient5;
                        mapleClient5.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u6230\u5062\u825a\u4e7a\u6223\u6779\u76e7\u605a\u720aQ"), 5120020);
                        break;
                    }
                    case 925100400: {
                        MapleClient mapleClient6 = a2;
                        mapleClient = mapleClient6;
                        mapleClient6.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6235\u6523\u604c\u721d\u7150\u5ff8\u62ec\u9404\u537f\u654a\u5103\u95f4\u7e4d\u8895G"), 5120020);
                        break;
                    }
                    case 925100500: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u6223\u5071\u9069\u96d82,#0\u5303\u538c\u903e\u95bf\u3072"), 5120020);
                    }
                    default: {
                        mapleClient = a2;
                    }
                }
                EventManager eventManager = mapleClient.getChannelServer().getEventSM().getEventManager(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"$\u000f\u0006\u0007\u0000\u0003"));
                if (a2.getPlayer().getMapId() != 925100500 || eventManager == null || eventManager.getProperty(MapleSidekick.ALLATORIxDEMO("\u0010\u0004\u0002\u0017\u0006E")) == null) return;
                int n6 = Randomizer.nextBoolean() ? 9300119 : 9300119;
                int n7 = Integer.parseInt(eventManager.getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0007\u0012\u0015\u0001\u0011S")));
                switch (n7) {
                    case 1: {
                        n5 = n6 = 9300105;
                        break;
                    }
                    case 2: {
                        n6 = 9300106;
                    }
                    default: {
                        n5 = n6;
                    }
                }
                MapleMonster mapleMonster = MapleLifeFactory.getMonster(n5);
                if (a2.getPlayer().getEventInstance() != null) {
                    a2.getPlayer().getEventInstance().registerMonster(mapleMonster);
                }
                a2.getPlayer().getMap().spawnMonsterOnGroundBelow(mapleMonster, new Point(411, 236));
                return;
            }
            case 11: {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().getMap().resetFully();
                mapleClient.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(9400633), new Point(600, -26));
                return;
            }
            case 12: {
                a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getErrorNotice(MapleSidekick.ALLATORIxDEMO("\u511d\u6228\u90da\u793d\u5d82\u7df0\u518a\u739dQ")));
                return;
            }
            case 13: {
                int n8;
                if (!a2.getPlayer().getCheckedPyramid()) return;
                MapleClient mapleClient = a2;
                MapleClient mapleClient7 = a2;
                mapleClient7.getPlayer().getMap().resetFully();
                mapleClient7.sendPacket(MaplePacketCreator.showEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\r\u001d\n\u0018\u000f\u001a\u0001[\u0004\u001b\b\u0001\u0015[\u0004\u001b\b\u0001\u0015")));
                mapleClient.sendPacket(MaplePacketCreator.showEffect(MapleSidekick.ALLATORIxDEMO("\u001b\n\u001c\u000f\u0019\r\u0017L\u0012\f\u001e\u0016\u0003L\u0003\u0017\u0011\u0004\u0015")));
                Point point = null;
                Point point2 = null;
                Point point3 = null;
                int n9 = 0;
                int n10 = 0;
                if (mapleClient.getPlayer().getMapId() >= 910320010 && a2.getPlayer().getMapId() <= 910320029) {
                    point = new Point(121, 218);
                    point2 = new Point(396, 43);
                    point3 = new Point(-63, 43);
                    n10 = 9700020;
                    n9 = 10;
                } else if (a2.getPlayer().getMapId() >= 926010010 && a2.getPlayer().getMapId() <= 926010029) {
                    point = new Point(0, 88);
                    point2 = new Point(-326, -115);
                    point3 = new Point(361, -115);
                    n10 = 9700019;
                    n9 = 10;
                } else if (a2.getPlayer().getMapId() >= 926010030 && a2.getPlayer().getMapId() <= 926010049) {
                    point = new Point(0, 88);
                    point2 = new Point(-326, -115);
                    point3 = new Point(361, -115);
                    n10 = 9700019;
                    n9 = 15;
                } else if (a2.getPlayer().getMapId() >= 926010050 && a2.getPlayer().getMapId() <= 926010069) {
                    point = new Point(0, 88);
                    point2 = new Point(-326, -115);
                    point3 = new Point(361, -115);
                    n10 = 9700019;
                    n9 = 20;
                } else {
                    if (a2.getPlayer().getMapId() < 926010070 || a2.getPlayer().getMapId() > 926010089) return;
                    point = new Point(0, 88);
                    point2 = new Point(-326, -115);
                    point3 = new Point(361, -115);
                    n10 = 9700029;
                    n9 = 20;
                }
                int n11 = n8 = 0;
                while (true) {
                    if (n11 >= n9) {
                        MapleClient mapleClient8 = a2;
                        mapleClient8.getPlayer().startMapTimeLimitTask(120, a2.getPlayer().getMap().getReturnMap());
                        mapleClient8.getPlayer().setCheckedPyramid(false);
                        return;
                    }
                    MapleClient mapleClient9 = a2;
                    mapleClient9.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(n10), new Point(point));
                    mapleClient9.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(n10), new Point(point2));
                    mapleClient9.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(n10), new Point(point3));
                    n11 = ++n8;
                }
            }
            case 14: {
                int n12;
                if (a2.getPlayer().getEventInstance() == null || a2.getPlayer().getEventInstance().getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u0016\t\u0007\u0015")) == null || !a2.getPlayer().getEventInstance().getProperty(MapleSidekick.ALLATORIxDEMO("\u0001\u001f\u0010\u0003")).equals(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"V"))) return;
                int n13 = n12 = 9800119;
                while (n13 < 9800125) {
                    MapleMonster mapleMonster = MapleLifeFactory.getMonster(n12);
                    MapleClient mapleClient = a2;
                    mapleClient.getPlayer().getEventInstance().registerMonster(mapleMonster);
                    mapleClient.getPlayer().getMap().spawnMonsterOnGroundBelow(mapleMonster, new Point(a2.getPlayer().getMap().getPortal(2).getPosition()));
                    n13 = ++n12;
                }
                return;
            }
            case 15: {
                a2.getPlayer().getMap().broadcastMessage(MaplePacketCreator.getErrorNotice(MapleSidekick.ALLATORIxDEMO("\u5f47\u5944\u76f4\u7cea\u7d75\u70ed\u9b24\u5d91\u518a\u739dQ\u8aa8\u5768\u7d33\u5c77\u4eb5\u64ba\u6534Q")));
                return;
            }
            case 16: {
                if (a2.getPlayer().getMapId() < 921120100 || a2.getPlayer().getMapId() >= 921120300) return;
                MapleMonster mapleMonster = MapleLifeFactory.getMonster(9300275);
                if (a2.getPlayer().getEventInstance() != null) {
                    Iterator<MapleCharacter> iterator;
                    int n14 = 0;
                    int n15 = 0;
                    Iterator<MapleCharacter> iterator2 = iterator = a2.getPlayer().getEventInstance().getPlayers().iterator();
                    while (iterator2.hasNext()) {
                        MapleCharacter mapleCharacter = iterator.next();
                        ++n15;
                        n14 += mapleCharacter.getLevel();
                        iterator2 = iterator;
                    }
                    if (n15 <= 0) {
                        return;
                    }
                    MapleClient mapleClient = a2;
                    mapleMonster.changeLevel(n14 /= n15);
                    mapleClient.getPlayer().getEventInstance().registerMonster(mapleMonster);
                    if (mapleClient.getPlayer().getEventInstance().getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"<6")) == null) {
                        a2.getPlayer().getEventInstance().setProperty(MapleSidekick.ALLATORIxDEMO("+ "), n14 + "000");
                    }
                    mapleMonster.setHp(Long.parseLong(a2.getPlayer().getEventInstance().getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"<6"))));
                }
                if (GameSetConstants.MAPLE_VERSION >= 152) {
                    Point point = new Point(a2.getPlayer().getMap().getPortal((int)0).getPosition().x, a2.getPlayer().getMap().getPortal((int)0).getPosition().y - 1);
                    mapleMonster.setFh(a2.getPlayer().getMap().getFootholds().findBelow(point).getId());
                }
                a2.getPlayer().getMap().spawnMonsterWithEffectBelow(mapleMonster, new Point(a2.getPlayer().getMap().getPortal(0).getPosition()), 12);
                MapleMonster mapleMonster2 = mapleMonster;
                MapleClient mapleClient = a2;
                mapleMonster2.switchController(mapleClient.getPlayer(), false);
                mapleClient.sendPacket(MaplePacketCreator.getNodeProperties(mapleMonster2, a2.getPlayer().getMap()));
                return;
            }
            case 17: {
                switch (a2.getPlayer().getMapId() % 10) {
                    case 0: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u6df8\u6ea6\u6230\u676a\u605a\u720aQ"), 5120033);
                        return;
                    }
                    case 1: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6506\u7852\u7bc5\u5b36\u4e52\u64ac\u9074\u604c\u721dG"), 5120033);
                        return;
                    }
                    case 2: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u6df8\u6ea6\u605a\u720aQ"), 5120033);
                        return;
                    }
                    case 3: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6dee\u6eb1\u6226\u677d\u604c\u721dG"), 5120033);
                        return;
                    }
                    case 4: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("\u620e\u4e63\u68ed\u5253\u5396\u5975\u4e70\u90e9\u76f4\u8d8cQ"), 5120033);
                        return;
                    }
                }
                return;
            }
            case 18: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u64be\u6531\u9b48\u76ba\u824d\u825f\u9503G"), 5120033);
                return;
            }
            case 19: 
            case 20: {
                return;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: {
                a2.getPlayer().getMap().resetFully();
                return;
            }
            case 25: {
                MapleSquad.clearsquad(a2, MapleSidekick.ALLATORIxDEMO("\u0000\n\u001e\b\n\u0002\u001b"));
                return;
            }
            case 26: {
                MapleClient mapleClient;
                a2.getPlayer().getMap().resetFully();
                int n16 = Randomizer.nextInt(10);
                int n17 = 100100;
                if (n16 >= 4) {
                    n17 = 3300007;
                    mapleClient = a2;
                } else if (n16 >= 1) {
                    n17 = 3300006;
                    mapleClient = a2;
                } else {
                    n17 = 3300005;
                    mapleClient = a2;
                }
                mapleClient.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(n17), a2.getPlayer().getPosition());
                return;
            }
            case 27: {
                return;
            }
            case 28: {
                if (a2.getPlayer().getMapId() < 932000100 || a2.getPlayer().getMapId() >= 932000300) return;
                MapleMonster mapleMonster = MapleLifeFactory.getMonster(9300438);
                if (a2.getPlayer().getEventInstance() != null) {
                    Iterator<MapleCharacter> iterator;
                    int n18 = 0;
                    int n19 = 0;
                    Iterator<MapleCharacter> iterator3 = iterator = a2.getPlayer().getEventInstance().getPlayers().iterator();
                    while (iterator3.hasNext()) {
                        MapleCharacter mapleCharacter = iterator.next();
                        ++n19;
                        n18 += mapleCharacter.getLevel();
                        iterator3 = iterator;
                    }
                    if (n19 <= 0) {
                        return;
                    }
                    MapleClient mapleClient = a2;
                    mapleMonster.changeLevel(n18 /= n19);
                    mapleClient.getPlayer().getEventInstance().registerMonster(mapleMonster);
                    if (mapleClient.getPlayer().getEventInstance().getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"<6")) == null) {
                        a2.getPlayer().getEventInstance().setProperty(MapleSidekick.ALLATORIxDEMO("+ "), n18 + "000");
                    }
                    mapleMonster.setHp(Long.parseLong(a2.getPlayer().getEventInstance().getProperty(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"<6"))));
                }
                a2.getPlayer().getMap().spawnMonsterWithEffectBelow(mapleMonster, new Point(a2.getPlayer().getMap().getPortal(0).getPosition()), 12);
                MapleMonster mapleMonster3 = mapleMonster;
                MapleClient mapleClient = a2;
                mapleMonster3.switchController(mapleClient.getPlayer(), false);
                mapleClient.sendPacket(MaplePacketCreator.getNodeProperties(mapleMonster3, a2.getPlayer().getMap()));
                return;
            }
            case 29: {
                MapleClient mapleClient = a2;
                mapleClient.getPlayer().getMap().resetFully();
                mapleClient.getPlayer().getMap().spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(6160003), a2.getPlayer().getPosition());
                return;
            }
            case 30: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("'\u0015\u0005\u0015\u0002\u0004C\u0004\u000b\u0015C\u001d\f\u001e\u0010\u0004\u0006\u0002\u0010Q"), 5120035);
                return;
            }
            case 31: {
                switch (a2.getPlayer().getMapId() / 100 % 10) {
                    case 1: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0018\u000f\u0019\u000f\u001a\u0007\u0000\u0003T\u0007\u0018\nT\u0012\u001c\u0003T\u000b\u001b\b\u0007\u0012\u0011\u0014\u0007G"), 5120052);
                        return;
                    }
                    case 2: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("$\u0015\u0017P\u000e\u0015CBSP\"\u0019\u0011P!\u0005\u0001\u0012\u000f\u0015\u0010P\u0005\u001f\u0011P\u000e\u0015C\u0004\fP\u0010\u0005\u0011\u0006\n\u0006\u0006Q"), 5120052);
                        return;
                    }
                    case 3: {
                        a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)".\u0011\n\u0004GT+\u0015\r\u0011F\u0007\u0013\u0006\u0003T/T\n\u001d\u0010\u0011F\u0012\t\u0006F\u0000\u000e\u0006\u0003\u0011F\u0019\u000f\u001a\u0013\u0000\u0003\u0007G"), 5120052);
                        return;
                    }
                    case 4: {
                        a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("5\u000f\u0019\u000e\u0019\r\u0011\u0017\u0015C\u0004\u000b\u0015C\u0004\u0014\u001fC \n\u0011\r\u0005\u0010Q"), 5120052);
                        return;
                    }
                }
                return;
            }
            case 32: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u5d94\u7de7\u5fee\u4e31\u6cf4\u677d\u776d\u5244\u4fe0\u906d\u8887\u76f0\u4edc\u4ef2\uff6a\u4f32\u6649\u4e2b\u6cf4\u677d\u776d\u903a\u5bef\u7142\u7147\u4eff\u519c\u53cf\u76e2\u4ece\u3064"), 5120043);
                return;
            }
            case 33: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO(":\u001f\u0016P\u0014\u0019\u000f\u001cC\u0000\u0006\u0002\n\u0003\u000bQ"), 5120050);
                return;
            }
            case 34: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0018\u000f\u0019\u000f\u001a\u0007\u0000\u0003T\u0007\u0018\nT\u0012\u001c\u0003T\u000b\u001b\b\u0007\u0012\u0011\u0014\u0007G"), 5120039);
                return;
            }
            case 35: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("5\u000f\u0019\u000e\u0019\r\u0011\u0017\u0015C\u0011\u000f\u001cC\u0004\u000b\u0015C&\n\u0003\n\u0004\f\u0002\u0010Q"), 5120039);
                return;
            }
            case 36: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"1\n\u001d\u000b\u001d\b\u0015\u0012\u0011F\u0015\n\u0018F\u0000\u000e\u0011F\u0012\n\r\u000f\u001a\u0001T\u000b\u001b\b\u0007\u0012\u0011\u0014\u0007G"), 5120039);
                return;
            }
            case 37: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("&\u001c\n\u001d\n\u001e\u0002\u0004\u0006P\u0002\u001c\u000fP\u0017\u0018\u0006P\u000e\u001f\r\u0003\u0017\u0015\u0011\u0003C\u0012\u001aP\u000e\u001f\u0015\u0019\r\u0017C\u0011\u0011\u001f\u0016\u001e\u0007P\u0017\u0018\u0006P\u000e\u0011\u0013Q"), 5120039);
                return;
            }
            case 38: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)";\b\u0011F\u001b\u0000T\u0012\u001c\u0003T\u0007\u0018\u000f\u0011\b\u0007F\u0019\u0013\u0007\u0012T\u000e\u0015\u0010\u0011F\u0015F\u0017\n\u0001\u0003T\u0012\u001bF\u0000\u000e\u0011F\u0003\u0007\rF\u001b\u0013\u0000H"), 5120039);
                return;
            }
            case 39: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("5\u000f\u0019\u000e\u0019\r\u0011\u0017\u0015C\u0011\u000f\u001cC\u001f\u0005P\u0017\u0018\u0006P6\u001e\t\u0005\u0010\u0004C&\n\u0003\n\u0004\f\u0002\u0010Q"), 5120039);
                return;
            }
            case 40: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"#\u0018\u000f\u0019\u000f\u001a\u0007\u0000\u0003T\u0007\u0018\nT\t\u0012F\u0000\u000e\u0011F'\u0016\u0011\u0003\u0010\u001fT0\u001d\u0015\u001d\u0012\u001b\u0014\u0007G"), 5120039);
                return;
            }
            case 41: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("7\u0018\u0006P\u0010\u0007\n\u0004\u0000\u0018C\u0011\u0017P\u0017\u0018\u0006P\u0017\u001f\u0013P\f\u0016C\u0004\u000b\u0015C\u0002\f\u001f\u000eP\u0011\u0015\u0012\u0005\n\u0002\u0006\u0003C\u0011C\u0018\u0006\u0011\u0015\tC\u0007\u0006\u0019\u0004\u0018\u0017^"), 5120039);
                return;
            }
            case 42: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"2\u001c\u0003T\u0003\u001a\u0003\u0019\u001fT\u000f\u0007F\u0004\t\u0003\u0003\u0006\u0000\u0001\nUF#\u0007\u0000\u0005\u001cF\u001b\u0013\u0000G"), 5120039);
                return;
            }
            case 43: {
                a2.getPlayer().getMap().startMapEffect(MapleSidekick.ALLATORIxDEMO("$\u000b\u0019\u0010P5\u0019\u0010\u0019\u0017\u001f\u0011P\n\u0003C\u0003\u0017\u0002\f\u001e\u0004QC2\u0006P\u0000\u0011\u0011\u0015\u0005\u0005\u000fQ"), 5120039);
                return;
            }
            case 44: {
                a2.getPlayer().getMap().startMapEffect(\u592d\u58fd\u8c37.ALLATORIxDEMO((String)"2\u001c\u000f\u0007F\u001d\u0015T\u000f\u0000GT!\u001d\u0010\u0011F\u001d\u0012T\u001f\u001b\u0013\u0006F\u0016\u0003\u0007\u0012T\u0015\u001c\t\u0000G"), 5120039);
                return;
            }
            case 45: 
            case 46: {
                a2.getPlayer().getMap().resetFully();
                return;
            }
            case 47: {
                return;
            }
            default: {
                System.err.println("\u672a\u8655\u7406\u7684\u8173\u672c : " + a3 + ", \u578b\u614b : onFirstUserEnter - \u5730\u5716ID " + a2.getPlayer().getMapId());
                FilePrinter.printError(MapleSidekick.ALLATORIxDEMO(".\u0011\u0013#\u0000\u0002\n\u0000\u0017=\u0006\u0004\u000b\u001f\u0007\u0003M\u0004\u001b\u0004"), "\u672a\u8655\u7406\u7684\u8173\u672c : " + a3 + ", \u578b\u614b : onUserEnter - \u5730\u5716ID " + a2.getPlayer().getMapId());
            }
        }
    }

    public static /* synthetic */ {
        d = new Point(-60, 184);
        String[] arrstring = new String[3];
        arrstring[0] = \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u4f14\u76e2\u52b3\u6c45\u76f0\u6377\u6244\u7700\u96f2\u9035\u5840\u6649\u9697\u809b\u539b\u8cd2\u76f0\uff67");
        arrstring[1] = MapleSidekick.ALLATORIxDEMO("\u59e1\u67ec\u4f03\u6083\u54a2\u56e0\u5952\u5259\u76e7\u8296\u6fe3\uff7c\u9051\u4ff6\u5444\uff71");
        arrstring[2] = \u592d\u58fd\u8c37.ALLATORIxDEMO((String)"\u6265\u6765\u8be7\u4f06\u5ff8\u60f2\u5fcd\u5ef3\u6365\u6256\u7712\u96e0\u9027\u5852\uff75\u5f8d\u9eaa\uff67");
        ALLATORIxDEMO = arrstring;
    }

    private static final /* synthetic */ int ALLATORIxDEMO(int a2) {
        if (a2 <= 5) {
            return 0;
        }
        if (a2 >= 7 && a2 <= 11) {
            return 1;
        }
        if (a2 >= 13 && a2 <= 17) {
            return 2;
        }
        if (a2 >= 19 && a2 <= 23) {
            return 3;
        }
        if (a2 >= 25 && a2 <= 29) {
            return 4;
        }
        if (a2 >= 31 && a2 <= 35) {
            return 5;
        }
        if (a2 >= 37 && a2 <= 38) {
            return 6;
        }
        return 0;
    }

    private static /* synthetic */ void H(MapleClient a2, String a3) {
        MapleClient mapleClient = a2;
        a2.sendPacket(UIPacket.IntroDisableUI(true));
        mapleClient.sendPacket(UIPacket.IntroLock(true));
        mapleClient.sendPacket(UIPacket.ShowWZEffect(a3));
    }

    private static /* synthetic */ void ALLATORIxDEMO(MapleClient a2) {
        MapleMap mapleMap;
        int n2;
        MapleClient mapleClient = a2;
        MapleMap mapleMap2 = mapleClient.getPlayer().getMap();
        mapleMap2.killAllMonsters(false);
        short s2 = mapleClient.getPlayer().getLevel();
        if (s2 <= 10) {
            n2 = 9300367;
            mapleMap = mapleMap2;
        } else if (s2 <= 20) {
            n2 = 9300368;
            mapleMap = mapleMap2;
        } else if (s2 <= 30) {
            n2 = 9300369;
            mapleMap = mapleMap2;
        } else if (s2 <= 40) {
            n2 = 9300370;
            mapleMap = mapleMap2;
        } else if (s2 <= 50) {
            n2 = 9300371;
            mapleMap = mapleMap2;
        } else if (s2 <= 60) {
            n2 = 9300372;
            mapleMap = mapleMap2;
        } else if (s2 <= 70) {
            n2 = 9300373;
            mapleMap = mapleMap2;
        } else if (s2 <= 80) {
            n2 = 9300374;
            mapleMap = mapleMap2;
        } else if (s2 <= 90) {
            n2 = 9300375;
            mapleMap = mapleMap2;
        } else if (s2 <= 100) {
            n2 = 9300376;
            mapleMap = mapleMap2;
        } else {
            n2 = 9300377;
            mapleMap = mapleMap2;
        }
        mapleMap.spawnMonsterOnGroundBelow(MapleLifeFactory.getMonster(n2), d);
    }

    private static /* synthetic */ void H(MapleClient a2) {
    }

    private static final class onFirstUserEnter
    extends Enum<onFirstUserEnter> {
        public static final /* synthetic */ /* enum */ onFirstUserEnter PRaid_B_Fenter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter storymap_scenario;
        public static final /* synthetic */ /* enum */ onFirstUserEnter killing_MapSetting;
        public static final /* synthetic */ /* enum */ onFirstUserEnter visitorCube_boomboom2_Enter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter iceman_FEnter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter visitorCube_medicroom_Enter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Visitor_Cube_poison;
        public static final /* synthetic */ /* enum */ onFirstUserEnter boss_Ravana;
        public static final /* synthetic */ /* enum */ onFirstUserEnter StageMsg_juliet;
        public static final /* synthetic */ /* enum */ onFirstUserEnter visitorCube_boomboom_Enter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter GhostF;
        public static final /* synthetic */ /* enum */ onFirstUserEnter boss_Event_PinkZakum;
        public static final /* synthetic */ /* enum */ onFirstUserEnter mPark_summonBoss;
        public static final /* synthetic */ /* enum */ onFirstUserEnter dojang_Eff;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Visitor_Cube_PickAnswer_Enter_First_1;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Visitor_Cube_Hunting_Enter_First;
        public static final /* synthetic */ /* enum */ onFirstUserEnter summon_pepeking;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Xerxes_summon;
        public static final /* synthetic */ /* enum */ onFirstUserEnter StageMsg_romio;
        public static final /* synthetic */ /* enum */ onFirstUserEnter kenta_mapEnter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter StageMsg_together;
        public static final /* synthetic */ /* enum */ onFirstUserEnter visitorCube_addmobEnter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter balog_summon;
        public static final /* synthetic */ /* enum */ onFirstUserEnter killing_BonusSetting;
        public static final /* synthetic */ /* enum */ onFirstUserEnter StageMsg_davy;
        public static final /* synthetic */ /* enum */ onFirstUserEnter metro_firstSetting;
        public static final /* synthetic */ /* enum */ onFirstUserEnter balog_bonusSetting;
        public static final /* synthetic */ /* enum */ onFirstUserEnter PRaid_D_Fenter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter shammos_Fenter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter onRewordMap;
        public static final /* synthetic */ /* enum */ onFirstUserEnter VanLeon_Before;
        public static final /* synthetic */ /* enum */ onFirstUserEnter NULL;
        public static final /* synthetic */ /* enum */ onFirstUserEnter cygnus_Summon;
        public static final /* synthetic */ /* enum */ onFirstUserEnter CubeBossbang_Enter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter PinkBeen_before;
        public static final /* synthetic */ /* enum */ onFirstUserEnter visitorCube_iceyunna_Enter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter prisonBreak_mapEnter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Event_PinkZakumtimeout;
        public static final /* synthetic */ /* enum */ onFirstUserEnter MalayBoss_Int;
        public static final /* synthetic */ /* enum */ onFirstUserEnter shammos_FStart;
        public static final /* synthetic */ /* enum */ onFirstUserEnter moonrabbit_mapEnter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Visitor_Cube_AreaCheck_Enter_First;
        public static final /* synthetic */ /* enum */ onFirstUserEnter iceman_Boss;
        private static final /* synthetic */ onFirstUserEnter[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ onFirstUserEnter easy_balog_summon;
        public static final /* synthetic */ /* enum */ onFirstUserEnter party6weatherMsg;
        public static final /* synthetic */ /* enum */ onFirstUserEnter VisitorCubePhase00_Start;
        public static final /* synthetic */ /* enum */ onFirstUserEnter Sky_TrapFEnter;
        public static final /* synthetic */ /* enum */ onFirstUserEnter astaroth_summon;

        private static /* synthetic */ onFirstUserEnter H(String a2) {
            try {
                return onFirstUserEnter.valueOf(a2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return NULL;
            }
        }

        public static /* synthetic */ onFirstUserEnter valueOf(String a2) {
            return Enum.valueOf(onFirstUserEnter.class, a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ onFirstUserEnter() {
            void var2_-1;
            void var1_-1;
            onFirstUserEnter a2;
        }

        public static /* synthetic */ {
            dojang_Eff = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("?,1\"5$\u0004\u0006=%"), 0);
            PinkBeen_before = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO(";;\u00059)7\u000e<40\u000e4\u0004 \u000e"), 1);
            onRewordMap = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO(",5\u0011>441?\u000e:3"), 2);
            StageMsg_together = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("8&\n5\u000e\u001f\u001854&\u00045\u000e&\u00037\u0019"), 3);
            StageMsg_davy = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\u0010/\"<&\u00160<\u001c?\"-:"), 4);
            party6weatherMsg = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\"\n \u001f+]%\u000e3\u001f:\u000e &!\f"), 5);
            StageMsg_juliet = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\u0010/\"<&\u00160<\u001c167*>7"), 6);
            StageMsg_romio = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0001\u001f3\f7&!\f\r\u0019=\u0006;\u0004"), 7);
            moonrabbit_mapEnter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO(".4,51:!9*/\u001c6\"+\u000657>1"), 8);
            astaroth_summon = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\n!\u001f3\u0019=\u001f:4!\u001e?\u0006=\u0005"), 9);
            boss_Ravana = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("!40(\u001c\t\"-\"5\""), 10);
            killing_BonusSetting = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("9\u0002>\u0007;\u000554\u0010\u0004<\u001e!87\u001f&\u0002<\f"), 11);
            killing_MapSetting = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("0*7/2-<\u001c\u0016\"+\u0010>7/*5$"), 12);
            metro_firstSetting = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("?\u000e&\u0019=44\u0002 \u0018&87\u001f&\u0002<\f"), 13);
            balog_bonusSetting = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("9\"7,<\u001c9,56(\u0010>7/*5$"), 14);
            balog_summon = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("0\n>\u000454!\u001e?\u0006=\u0005"), 15);
            easy_balog_summon = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("&:0\"\u001c9\"7,<\u001c(66.4-"), 16);
            Sky_TrapFEnter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0001\u0000+4\u0006\u00193\u001b\u0014.<\u001f7\u0019"), 17);
            shammos_Fenter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("(+:.6,(\u001c\u001d&57>1"), 18);
            PRaid_D_Fenter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u000293\u000264\u00164\u0014\u000e<\u001f7\u0019"), 19);
            PRaid_B_Fenter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\u000b\u0011:*?\u001c\u0019\u001c\u001d&57>1"), 20);
            GhostF = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0015\u0003=\u0018&-"), 21);
            summon_pepeking = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("0..6,5\u001c+&+&0*5$"), 22);
            Event_PinkZakumtimeout = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0017\u001d7\u0005&4\u0002\u0002<\u0000\b\n9\u001e?\u001f;\u00067\u0004'\u001f"), 23);
            boss_Event_PinkZakum = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("9,(0\u0004\u0006-&57\u0004\u00132-0\u0019:(.."), 24);
            Xerxes_summon = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("37\u0019*\u000e!4!\u001e?\u0006=\u0005"), 25);
            VanLeon_Before = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\r\"5\u000f>,5\u001c\u0019&=,)&"), 26);
            cygnus_Summon = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\b+\f<\u001e!4\u0001\u001e?\u0006=\u0005"), 27);
            storymap_scenario = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("0/,):6\"+\u001c( >-:12,"), 28);
            shammos_FStart = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("!\u00033\u0006?\u0004!4\u00148&\n \u001f"), 29);
            kenta_mapEnter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("0&57:\u001c6\"+\u000657>1"), 30);
            iceman_FEnter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u00021\u000e?\n<4\u0014.<\u001f7\u0019"), 31);
            iceman_Boss = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("*8&6\"5\u001c\u0019,(0"), 32);
            prisonBreak_mapEnter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\"\u0019;\u0018=\u0005\u0010\u00197\n94?\n\".<\u001f7\u0019"), 33);
            Visitor_Cube_poison = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\u0015202741\u0004\u0000.!>\u001c+,204-"), 34);
            Visitor_Cube_Hunting_Enter_First = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0004\u0002!\u0002&\u0004 4\u0011\u001e0\u000e\r#'\u0005&\u0002<\f\r.<\u001f7\u0019\r-;\u0019!\u001f"), 35);
            VisitorCubePhase00_Start = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\r*(*/,)\u0000.!>\u00133\"(&ks\u0004\u0010/\")7"), 36);
            visitorCube_addmobEnter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001d;\u0018;\u001f=\u0019\u0011\u001e0\u000e\r\n6\u000f?\u00040.<\u001f7\u0019"), 37);
            Visitor_Cube_PickAnswer_Enter_First_1 = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\u0015202741\u0004\u0000.!>\u001c\u000b*8(\u001a-(4>1\u0004\u000657>1\u0004\u000521(7\u0004r"), 38);
            visitorCube_medicroom_Enter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001d;\u0018;\u001f=\u0019\u0011\u001e0\u000e\r\u00067\u000f;\b \u0004=\u0006\r.<\u001f7\u0019"), 39);
            visitorCube_iceyunna_Enter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("-*(*/,)\u0000.!>\u001c2 >:.-5\"\u0004\u000657>1"), 40);
            Visitor_Cube_AreaCheck_Enter_First = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u0004\u0002!\u0002&\u0004 4\u0011\u001e0\u000e\r* \u000e3(:\u000e1\u0000\r.<\u001f7\u0019\r-;\u0019!\u001f"), 41);
            visitorCube_boomboom_Enter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("-*(*/,)\u0000.!>\u001c9,4.9,4.\u0004\u000657>1"), 42);
            visitorCube_boomboom2_Enter = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001d;\u0018;\u001f=\u0019\u0011\u001e0\u000e\r\t=\u0004?\t=\u0004?Y\r.<\u001f7\u0019"), 43);
            CubeBossbang_Enter = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("\u001869&\u0019,(09\"5$\u0004\u000657>1"), 44);
            MalayBoss_Int = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("&3\u00073\u0012\u0010\u0004!\u0018\r\"<\u001f"), 45);
            mPark_summonBoss = new onFirstUserEnter(ItemInformation.ALLATORIxDEMO("6\u0013:10\u001c(66.4-\u0019,(0"), 46);
            NULL = new onFirstUserEnter(ExternalCodeLongTableGetter.ALLATORIxDEMO("\u001c>\u001e'"), 47);
            onFirstUserEnter[] arronFirstUserEnter = new onFirstUserEnter[48];
            arronFirstUserEnter[0] = dojang_Eff;
            arronFirstUserEnter[1] = PinkBeen_before;
            arronFirstUserEnter[2] = onRewordMap;
            arronFirstUserEnter[3] = StageMsg_together;
            arronFirstUserEnter[4] = StageMsg_davy;
            arronFirstUserEnter[5] = party6weatherMsg;
            arronFirstUserEnter[6] = StageMsg_juliet;
            arronFirstUserEnter[7] = StageMsg_romio;
            arronFirstUserEnter[8] = moonrabbit_mapEnter;
            arronFirstUserEnter[9] = astaroth_summon;
            arronFirstUserEnter[10] = boss_Ravana;
            arronFirstUserEnter[11] = killing_BonusSetting;
            arronFirstUserEnter[12] = killing_MapSetting;
            arronFirstUserEnter[13] = metro_firstSetting;
            arronFirstUserEnter[14] = balog_bonusSetting;
            arronFirstUserEnter[15] = balog_summon;
            arronFirstUserEnter[16] = easy_balog_summon;
            arronFirstUserEnter[17] = Sky_TrapFEnter;
            arronFirstUserEnter[18] = shammos_Fenter;
            arronFirstUserEnter[19] = PRaid_D_Fenter;
            arronFirstUserEnter[20] = PRaid_B_Fenter;
            arronFirstUserEnter[21] = GhostF;
            arronFirstUserEnter[22] = summon_pepeking;
            arronFirstUserEnter[23] = Event_PinkZakumtimeout;
            arronFirstUserEnter[24] = boss_Event_PinkZakum;
            arronFirstUserEnter[25] = Xerxes_summon;
            arronFirstUserEnter[26] = VanLeon_Before;
            arronFirstUserEnter[27] = cygnus_Summon;
            arronFirstUserEnter[28] = storymap_scenario;
            arronFirstUserEnter[29] = shammos_FStart;
            arronFirstUserEnter[30] = kenta_mapEnter;
            arronFirstUserEnter[31] = iceman_FEnter;
            arronFirstUserEnter[32] = iceman_Boss;
            arronFirstUserEnter[33] = prisonBreak_mapEnter;
            arronFirstUserEnter[34] = Visitor_Cube_poison;
            arronFirstUserEnter[35] = Visitor_Cube_Hunting_Enter_First;
            arronFirstUserEnter[36] = VisitorCubePhase00_Start;
            arronFirstUserEnter[37] = visitorCube_addmobEnter;
            arronFirstUserEnter[38] = Visitor_Cube_PickAnswer_Enter_First_1;
            arronFirstUserEnter[39] = visitorCube_medicroom_Enter;
            arronFirstUserEnter[40] = visitorCube_iceyunna_Enter;
            arronFirstUserEnter[41] = Visitor_Cube_AreaCheck_Enter_First;
            arronFirstUserEnter[42] = visitorCube_boomboom_Enter;
            arronFirstUserEnter[43] = visitorCube_boomboom2_Enter;
            arronFirstUserEnter[44] = CubeBossbang_Enter;
            arronFirstUserEnter[45] = MalayBoss_Int;
            arronFirstUserEnter[46] = mPark_summonBoss;
            arronFirstUserEnter[47] = NULL;
            ALLATORIxDEMO = arronFirstUserEnter;
        }

        public static /* synthetic */ onFirstUserEnter[] values() {
            return (onFirstUserEnter[])ALLATORIxDEMO.clone();
        }
    }

    private static final class onUserEnter
    extends Enum<onUserEnter> {
        public static final /* synthetic */ /* enum */ onUserEnter TCMobrevive;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_3_1;
        public static final /* synthetic */ /* enum */ onUserEnter visitor_ReviveMap;
        public static final /* synthetic */ /* enum */ onUserEnter getDragonEgg;
        public static final /* synthetic */ /* enum */ onUserEnter q31102e;
        public static final /* synthetic */ /* enum */ onUserEnter go1010100;
        public static final /* synthetic */ /* enum */ onUserEnter mPark_stageEff;
        public static final /* synthetic */ /* enum */ onUserEnter startEreb;
        public static final /* synthetic */ /* enum */ onUserEnter TD_MC_gasi;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor50_1;
        public static final /* synthetic */ /* enum */ onUserEnter Massacre_first;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_0_0;
        public static final /* synthetic */ /* enum */ onUserEnter check_count;
        public static final /* synthetic */ /* enum */ onUserEnter VanLeon_Before;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor20;
        private static final /* synthetic */ onUserEnter[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ onUserEnter summonIceWall;
        public static final /* synthetic */ /* enum */ onUserEnter balog_buff;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_2_prep;
        public static final /* synthetic */ /* enum */ onUserEnter VanLeon_ExpeditionEnter;
        public static final /* synthetic */ /* enum */ onUserEnter Sky_GateMapEnter;
        public static final /* synthetic */ /* enum */ onUserEnter merTutorDrecotion10;
        public static final /* synthetic */ /* enum */ onUserEnter merOutStandAlone;
        public static final /* synthetic */ /* enum */ onUserEnter PRaid_B_Enter;
        public static final /* synthetic */ /* enum */ onUserEnter enterBlackfrog;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_1_before;
        public static final /* synthetic */ /* enum */ onUserEnter summonSchiller;
        public static final /* synthetic */ /* enum */ onUserEnter goArcher;
        public static final /* synthetic */ /* enum */ onUserEnter reundodraco;
        public static final /* synthetic */ /* enum */ onUserEnter jail;
        public static final /* synthetic */ /* enum */ onUserEnter Sky_Quest;
        public static final /* synthetic */ /* enum */ onUserEnter iceman_Enter;
        public static final /* synthetic */ /* enum */ onUserEnter goSwordman;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor50;
        public static final /* synthetic */ /* enum */ onUserEnter go20000;
        public static final /* synthetic */ /* enum */ onUserEnter undomorphdarco;
        public static final /* synthetic */ /* enum */ onUserEnter findvioleta;
        public static final /* synthetic */ /* enum */ onUserEnter go40000;
        public static final /* synthetic */ /* enum */ onUserEnter shammos_Base;
        public static final /* synthetic */ /* enum */ onUserEnter metro_firstSetting;
        public static final /* synthetic */ /* enum */ onUserEnter VisitorCubePhase00_Enter;
        public static final /* synthetic */ /* enum */ onUserEnter merTutorDrecotion00;
        public static final /* synthetic */ /* enum */ onUserEnter go30000;
        public static final /* synthetic */ /* enum */ onUserEnter explorationPoint;
        public static final /* synthetic */ /* enum */ onUserEnter PRaid_FailEnter;
        public static final /* synthetic */ /* enum */ onUserEnter TD_MC_title;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_ill0;
        public static final /* synthetic */ /* enum */ onUserEnter iceCave;
        public static final /* synthetic */ /* enum */ onUserEnter Sky_StageEnter;
        public static final /* synthetic */ /* enum */ onUserEnter onSDI;
        public static final /* synthetic */ /* enum */ onUserEnter rienArrow;
        public static final /* synthetic */ /* enum */ onUserEnter pepeking_effect;
        public static final /* synthetic */ /* enum */ onUserEnter PRaid_W_Enter;
        public static final /* synthetic */ /* enum */ onUserEnter outCase;
        public static final /* synthetic */ /* enum */ onUserEnter cannon_tuto_direction2;
        public static final /* synthetic */ /* enum */ onUserEnter start_itemTake;
        public static final /* synthetic */ /* enum */ onUserEnter TD_MC_keycheck;
        public static final /* synthetic */ /* enum */ onUserEnter go1020000;
        public static final /* synthetic */ /* enum */ onUserEnter dojang_1st;
        public static final /* synthetic */ /* enum */ onUserEnter prisonBreak_1stageEnter;
        public static final /* synthetic */ /* enum */ onUserEnter goRogue;
        public static final /* synthetic */ /* enum */ onUserEnter VisitorleaveDirectionMode;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_home_before;
        public static final /* synthetic */ /* enum */ onUserEnter cygnusTest;
        public static final /* synthetic */ /* enum */ onUserEnter userInBattleSquare;
        public static final /* synthetic */ /* enum */ onUserEnter cannon_tuto_01;
        public static final /* synthetic */ /* enum */ onUserEnter aranDirection;
        public static final /* synthetic */ /* enum */ onUserEnter go1000000;
        public static final /* synthetic */ /* enum */ onUserEnter goMagician;
        public static final /* synthetic */ /* enum */ onUserEnter go1010300;
        public static final /* synthetic */ /* enum */ onUserEnter cygnus_ExpeditionEnter;
        public static final /* synthetic */ /* enum */ onUserEnter TD_NC_title;
        public static final /* synthetic */ /* enum */ onUserEnter merTutorSleep01;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_1_0;
        public static final /* synthetic */ /* enum */ onUserEnter incubation_dragon;
        public static final /* synthetic */ /* enum */ onUserEnter go1010400;
        public static final /* synthetic */ /* enum */ onUserEnter cygnusJobTutorial;
        public static final /* synthetic */ /* enum */ onUserEnter go50000;
        public static final /* synthetic */ /* enum */ onUserEnter Sky_BossEnter;
        public static final /* synthetic */ /* enum */ onUserEnter shammos_Start;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_ani;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_5_0;
        public static final /* synthetic */ /* enum */ onUserEnter PRaid_WinEnter;
        public static final /* synthetic */ /* enum */ onUserEnter merTutorSleep00;
        public static final /* synthetic */ /* enum */ onUserEnter balog_dateSet;
        public static final /* synthetic */ /* enum */ onUserEnter mirrorCave;
        public static final /* synthetic */ /* enum */ onUserEnter PromiseDragon;
        public static final /* synthetic */ /* enum */ onUserEnter TD_MC_gasi2;
        public static final /* synthetic */ /* enum */ onUserEnter go1010000;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor80;
        public static final /* synthetic */ /* enum */ onUserEnter knights_Summon;
        public static final /* synthetic */ /* enum */ onUserEnter in_secretroom;
        public static final /* synthetic */ /* enum */ onUserEnter evanTogether;
        public static final /* synthetic */ /* enum */ onUserEnter merTutorSleep02;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor10;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor30;
        public static final /* synthetic */ /* enum */ onUserEnter goAdventure;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_4_0;
        public static final /* synthetic */ /* enum */ onUserEnter TD_neo_BossEnter;
        public static final /* synthetic */ /* enum */ onUserEnter moonrabbit_takeawayitem;
        public static final /* synthetic */ /* enum */ onUserEnter shammos_Result;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor60;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_3_0;
        public static final /* synthetic */ /* enum */ onUserEnter go2000000;
        public static final /* synthetic */ /* enum */ onUserEnter shammos_Enter;
        public static final /* synthetic */ /* enum */ onUserEnter q31103s;
        public static final /* synthetic */ /* enum */ onUserEnter evanAlone;
        public static final /* synthetic */ /* enum */ onUserEnter meetWithDragon;
        public static final /* synthetic */ /* enum */ onUserEnter evanPromotion;
        public static final /* synthetic */ /* enum */ onUserEnter PRaid_Revive;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor70;
        public static final /* synthetic */ /* enum */ onUserEnter NULL;
        public static final /* synthetic */ /* enum */ onUserEnter Massacre_result;
        public static final /* synthetic */ /* enum */ onUserEnter StageMsg_crack;
        public static final /* synthetic */ /* enum */ onUserEnter babyPigMap;
        public static final /* synthetic */ /* enum */ onUserEnter merTutorDrecotion20;
        public static final /* synthetic */ /* enum */ onUserEnter evanleaveD;
        public static final /* synthetic */ /* enum */ onUserEnter go10000;
        public static final /* synthetic */ /* enum */ onUserEnter dollCave01;
        public static final /* synthetic */ /* enum */ onUserEnter goLith;
        public static final /* synthetic */ /* enum */ onUserEnter cannon_tuto_direction;
        public static final /* synthetic */ /* enum */ onUserEnter merStandAlone;
        public static final /* synthetic */ /* enum */ onUserEnter goPirate;
        public static final /* synthetic */ /* enum */ onUserEnter dojang_QcheckSet;
        public static final /* synthetic */ /* enum */ onUserEnter ds_tuto_2_before;
        public static final /* synthetic */ /* enum */ onUserEnter crash_Dragon;
        public static final /* synthetic */ /* enum */ onUserEnter cannon_tuto_direction1;
        public static final /* synthetic */ /* enum */ onUserEnter Ghost;
        public static final /* synthetic */ /* enum */ onUserEnter rien;
        public static final /* synthetic */ /* enum */ onUserEnter TD_MC_Openning;
        public static final /* synthetic */ /* enum */ onUserEnter aranTutorAlone;
        public static final /* synthetic */ /* enum */ onUserEnter go1010200;
        public static final /* synthetic */ /* enum */ onUserEnter Resi_tutor40;
        public static final /* synthetic */ /* enum */ onUserEnter EntereurelTW;
        public static final /* synthetic */ /* enum */ onUserEnter PRaid_D_Enter;
        public static final /* synthetic */ /* enum */ onUserEnter dojang_Msg;
        public static final /* synthetic */ /* enum */ onUserEnter blackSDI;
        public static final /* synthetic */ /* enum */ onUserEnter sealGarden;
        public static final /* synthetic */ /* enum */ onUserEnter dollCave00;
        public static final /* synthetic */ /* enum */ onUserEnter visitorPT_Enter;

        public static /* synthetic */ onUserEnter valueOf(String a2) {
            return Enum.valueOf(onUserEnter.class, a2);
        }

        public static /* synthetic */ onUserEnter[] values() {
            return (onUserEnter[])ALLATORIxDEMO.clone();
        }

        private static /* synthetic */ onUserEnter H(String a2) {
            try {
                return onUserEnter.valueOf(a2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return NULL;
            }
        }

        public static /* synthetic */ onUserEnter ALLATORIxDEMO(String a2) {
            return onUserEnter.H(a2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ onUserEnter() {
            void var2_-1;
            void var1_-1;
            onUserEnter a2;
        }

        public static /* synthetic */ {
            babyPigMap = new onUserEnter(MapleFamily.ALLATORIxDEMO("\f!\f9>)\t\r\u000f0"), 0);
            crash_Dragon = new onUserEnter(MapOwner.ALLATORIxDEMO("]:_;V\u0017z:_/Q&"), 1);
            evanleaveD = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u000b6\u000f.\u0002%\u000f6\u000b\u0004"), 2);
            getDragonEgg = new onUserEnter(MapOwner.ALLATORIxDEMO("Y-J\fL)Y'P\rY/"), 3);
            meetWithDragon = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0003%\u000b49)\u001a(*2\u000f'\u0001."), 4);
            go1010100 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Qy\u000ey\u000ey\u000ex"), 5);
            go1010200 = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001q^q^r^p"), 6);
            go1010300 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Qy\u000ey\u000e{\u000ex"), 7);
            go1010400 = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001q^q^t^p"), 8);
            evanPromotion = new onUserEnter(MapOwner.ALLATORIxDEMO("-H)P\u0018L'S'J!Q&"), 9);
            PromiseDragon = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0010\u001c/\u0003)\u001d%*2\u000f'\u0001."), 10);
            evanTogether = new onUserEnter(MapOwner.ALLATORIxDEMO("[>_&j'Y-J [:"), 11);
            incubation_dragon = new onUserEnter(MapleFamily.ALLATORIxDEMO(")\u0000#\u001b\"\u000f4\u0007/\u0000\u001f\n2\u000f'\u0001."), 12);
            TD_MC_Openning = new onUserEnter(MapOwner.ALLATORIxDEMO("j\fa\u0005}\u0017q8[&P!P/"), 13);
            TD_MC_gasi = new onUserEnter(MapleFamily.ALLATORIxDEMO(":\u00041\r-\u001f\t!\u001d)"), 14);
            TD_MC_title = new onUserEnter(MapOwner.ALLATORIxDEMO("\u001cz\u0017s\u000ba<W<R-"), 15);
            cygnusJobTutorial = new onUserEnter(MapleFamily.ALLATORIxDEMO("#\u0017'\u00005\u001d\n\u0001\":5\u001a/\u001c)\u000f,"), 16);
            cygnusTest = new onUserEnter(MapOwner.ALLATORIxDEMO("]1Y&K;j-M<"), 17);
            startEreb = new onUserEnter(MapleFamily.ALLATORIxDEMO("3\u001a!\u001c4+2\u000b\""), 18);
            dojang_Msg = new onUserEnter(MapOwner.ALLATORIxDEMO("Z'T)P/a\u0005M/"), 19);
            dojang_1st = new onUserEnter(MapleFamily.ALLATORIxDEMO("\n/\u0004!\u0000'1q\u001d4"), 20);
            reundodraco = new onUserEnter(MapOwner.ALLATORIxDEMO(":[=P,Q,L)]'"), 21);
            undomorphdarco = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u001b.\n/\u0003/\u001c0\u0006$\u000f2\r/"), 22);
            explorationPoint = new onUserEnter(MapOwner.ALLATORIxDEMO("[0N$Q:_<W'P\u0018Q!P<"), 23);
            goAdventure = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001\u0001\n6\u000b.\u001a5\u001c%"), 24);
            go10000 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Qy\u000ex\u000ex"), 25);
            go20000 = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001r^p^p"), 26);
            go30000 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Q{\u000ex\u000ex"), 27);
            go40000 = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001t^p^p"), 28);
            go50000 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Q}\u000ex\u000ex"), 29);
            go1000000 = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001q^p^p^p"), 30);
            go1010000 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Qy\u000ey\u000ex\u000ex"), 31);
            go1020000 = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001q^r^p^p"), 32);
            go2000000 = new onUserEnter(MapOwner.ALLATORIxDEMO("/Qz\u000ex\u000ex\u000ex"), 33);
            goArcher = new onUserEnter(MapleFamily.ALLATORIxDEMO("\t//2\r(\u000b2"), 34);
            goPirate = new onUserEnter(MapOwner.ALLATORIxDEMO("Y'n!L)J-"), 35);
            goRogue = new onUserEnter(MapleFamily.ALLATORIxDEMO("'\u0001\u0012\u0001'\u001b%"), 36);
            goMagician = new onUserEnter(MapOwner.ALLATORIxDEMO("Y's)Y!]!_&"), 37);
            goSwordman = new onUserEnter(MapleFamily.ALLATORIxDEMO("\t/=7\u00012\n-\u000f."), 38);
            goLith = new onUserEnter(MapOwner.ALLATORIxDEMO("Y'r!J "), 39);
            iceCave = new onUserEnter(MapleFamily.ALLATORIxDEMO(")\r%-!\u0018%"), 40);
            mirrorCave = new onUserEnter(MapOwner.ALLATORIxDEMO("S!L:Q:})H-"), 41);
            aranDirection = new onUserEnter(MapleFamily.ALLATORIxDEMO("!\u001c!\u0000\u0004\u00072\u000b#\u001a)\u0001."), 42);
            rienArrow = new onUserEnter(MapOwner.ALLATORIxDEMO(":W-P\tL:Q?"), 43);
            rien = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u001c)\u000b."), 44);
            check_count = new onUserEnter(MapOwner.ALLATORIxDEMO("+V-]#a+Q=P<"), 45);
            Massacre_first = new onUserEnter(MapleFamily.ALLATORIxDEMO("#!\u001d3\u000f#\u001c%1&\u00072\u001d4"), 46);
            Massacre_result = new onUserEnter(MapOwner.ALLATORIxDEMO("\u0005_;M)]:[\u0017L-M=R<"), 47);
            TD_MC_gasi2 = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0014*\u001f#\u00031'\u000f3\u0007r"), 48);
            aranTutorAlone = new onUserEnter(MapOwner.ALLATORIxDEMO("_:_&j=J'L\tR'P-"), 49);
            evanAlone = new onUserEnter(MapleFamily.ALLATORIxDEMO("%\u0018!\u0000\u0001\u0002/\u0000%"), 50);
            dojang_QcheckSet = new onUserEnter(MapOwner.ALLATORIxDEMO("Z'T)P/a\u0019] [+U\u001b[<"), 51);
            Sky_StageEnter = new onUserEnter(MapleFamily.ALLATORIxDEMO("=+\u0017\u001f=4\u000f'\u000b\u0005\u00004\u000b2"), 52);
            outCase = new onUserEnter(MapOwner.ALLATORIxDEMO("'K<})M-"), 53);
            balog_buff = new onUserEnter(MapleFamily.ALLATORIxDEMO("\f!\u0002/\t\u001f\f5\b&"), 54);
            balog_dateSet = new onUserEnter(MapOwner.ALLATORIxDEMO("*_$Q/a,_<[\u001b[<"), 55);
            Sky_BossEnter = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0013\u000591\u0002\u00013\u001d\u0005\u00004\u000b2"), 56);
            Sky_GateMapEnter = new onUserEnter(MapOwner.ALLATORIxDEMO("m#G\u0017y)J-s)N\rP<[:"), 57);
            shammos_Enter = new onUserEnter(MapleFamily.ALLATORIxDEMO("3\u0006!\u0003-\u000131\u0005\u00004\u000b2"), 58);
            shammos_Result = new onUserEnter(MapOwner.ALLATORIxDEMO("M _%S'M\u0017l-M=R<"), 59);
            shammos_Base = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u001d(\u000f-\u0003/\u001d\u001f,!\u001d%"), 60);
            dollCave00 = new onUserEnter(MapOwner.ALLATORIxDEMO("Z'R$})H-\u000ex"), 61);
            dollCave01 = new onUserEnter(MapleFamily.ALLATORIxDEMO("\n/\u0002,-!\u0018%^q"), 62);
            Sky_Quest = new onUserEnter(MapOwner.ALLATORIxDEMO("\u001bU1a\u0019K-M<"), 63);
            enterBlackfrog = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u000b.\u001a%\u001c\u0002\u0002!\r+\b2\u0001'"), 64);
            onSDI = new onUserEnter(MapOwner.ALLATORIxDEMO("'P\u001bz\u0001"), 65);
            blackSDI = new onUserEnter(MapleFamily.ALLATORIxDEMO("\f,\u000f#\u0005\u0013*\t"), 66);
            summonIceWall = new onUserEnter(MapOwner.ALLATORIxDEMO(";K%S'P\u0001]-i)R$"), 67);
            metro_firstSetting = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0003%\u001a2\u0001\u001f\b)\u001c3\u001a\u0013\u000b4\u001a)\u0000'"), 68);
            start_itemTake = new onUserEnter(MapOwner.ALLATORIxDEMO("M<_:J\u0017W<[%j)U-"), 69);
            PRaid_D_Enter = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0010<!\u0007$1\u00041\u0005\u00004\u000b2"), 70);
            PRaid_B_Enter = new onUserEnter(MapOwner.ALLATORIxDEMO("\u0018l)W,a\na\rP<[:"), 71);
            PRaid_Revive = new onUserEnter(MapleFamily.ALLATORIxDEMO(">\u0012\u000f)\n\u001f<%\u0018)\u0018%"), 72);
            PRaid_W_Enter = new onUserEnter(MapOwner.ALLATORIxDEMO("\u0018l)W,a\u001fa\rP<[:"), 73);
            PRaid_WinEnter = new onUserEnter(MapleFamily.ALLATORIxDEMO(">\u0012\u000f)\n\u001f9)\u0000\u0005\u00004\u000b2"), 74);
            PRaid_FailEnter = new onUserEnter(MapOwner.ALLATORIxDEMO("\u0018l)W,a\u000e_!R\rP<[:"), 75);
            Ghost = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0007\u0006/\u001d4"), 76);
            TD_MC_keycheck = new onUserEnter(MapOwner.ALLATORIxDEMO("j\fa\u0005}\u0017U-G+V-]#"), 77);
            pepeking_effect = new onUserEnter(MapleFamily.ALLATORIxDEMO("0\u000b0\u000b+\u0007.\t\u001f\u000b&\b%\r4"), 78);
            findvioleta = new onUserEnter(MapOwner.ALLATORIxDEMO(".W&Z>W'R-J)"), 79);
            NULL = new onUserEnter(MapleFamily.ALLATORIxDEMO(" \u0015\"\f"), 80);
            VanLeon_Before = new onUserEnter(MapOwner.ALLATORIxDEMO("h)P\u0004['P\u0017|-X'L-"), 81);
            VanLeon_ExpeditionEnter = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0016\u000f.\"%\u0001.1\u0005\u00160\u000b$\u00074\u0007/\u0000\u0005\u00004\u000b2"), 82);
            mPark_stageEff = new onUserEnter(MapOwner.ALLATORIxDEMO("S\u0018_:U\u0017M<_/[\rX."), 83);
            in_secretroom = new onUserEnter(MapleFamily.ALLATORIxDEMO(")\u0000\u001f\u001d%\r2\u000b4\u001c/\u0001-"), 84);
            sealGarden = new onUserEnter(MapOwner.ALLATORIxDEMO("M-_$y)L,[&"), 85);
            TD_NC_title = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0014*\u001f \u000314\u00074\u0002%"), 86);
            TD_neo_BossEnter = new onUserEnter(MapOwner.ALLATORIxDEMO("j\fa&['a\nQ;M\rP<[:"), 87);
            Resi_tutor10 = new onUserEnter(MapleFamily.ALLATORIxDEMO("<%\u001d)14\u001b4\u00012_p"), 88);
            Resi_tutor20 = new onUserEnter(MapOwner.ALLATORIxDEMO("l-M!a<K<Q:\fx"), 89);
            Resi_tutor30 = new onUserEnter(MapleFamily.ALLATORIxDEMO("<%\u001d)14\u001b4\u00012]p"), 90);
            Resi_tutor40 = new onUserEnter(MapOwner.ALLATORIxDEMO("l-M!a<K<Q:\nx"), 91);
            Resi_tutor50 = new onUserEnter(MapleFamily.ALLATORIxDEMO("<%\u001d)14\u001b4\u00012[p"), 92);
            Resi_tutor60 = new onUserEnter(MapOwner.ALLATORIxDEMO("l-M!a<K<Q:\bx"), 93);
            Resi_tutor70 = new onUserEnter(MapleFamily.ALLATORIxDEMO("<%\u001d)14\u001b4\u00012Yp"), 94);
            Resi_tutor80 = new onUserEnter(MapOwner.ALLATORIxDEMO("l-M!a<K<Q:\u0006x"), 95);
            Resi_tutor50_1 = new onUserEnter(MapleFamily.ALLATORIxDEMO("<%\u001d)14\u001b4\u00012[p1q"), 96);
            summonSchiller = new onUserEnter(MapOwner.ALLATORIxDEMO("M=S%Q&m+V!R$[:"), 97);
            q31102e = new onUserEnter(MapleFamily.ALLATORIxDEMO("1]q_p\\%"), 98);
            q31103s = new onUserEnter(MapOwner.ALLATORIxDEMO("9\ry\u000fx\r;"), 99);
            jail = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0004!\u0007,"), 100);
            cygnus_ExpeditionEnter = new onUserEnter(MapOwner.ALLATORIxDEMO("]1Y&K;a\rF8[,W<W'P\rP<[:"), 101);
            knights_Summon = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0005.\u0007'\u00064\u001d\u001f=5\u0003-\u0001."), 102);
            TCMobrevive = new onUserEnter(MapOwner.ALLATORIxDEMO("\u001c}\u0005Q*L-H!H-"), 103);
            moonrabbit_takeawayitem = new onUserEnter(MapleFamily.ALLATORIxDEMO("-\u0001/\u00002\u000f\"\f)\u001a\u001f\u001a!\u0005%\u000f7\u000f9\u00074\u000b-"), 104);
            StageMsg_crack = new onUserEnter(MapOwner.ALLATORIxDEMO("m<_/[\u0005M/a+L)]#"), 105);
            shammos_Start = new onUserEnter(MapleFamily.ALLATORIxDEMO("3\u0006!\u0003-\u000131\u0013\u001a!\u001c4"), 106);
            iceman_Enter = new onUserEnter(MapOwner.ALLATORIxDEMO("W+[%_&a\rP<[:"), 107);
            prisonBreak_1stageEnter = new onUserEnter(MapleFamily.ALLATORIxDEMO("0\u001c)\u001d/\u0000\u0002\u001c%\u000f+1q\u001d4\u000f'\u000b\u0005\u00004\u000b2"), 108);
            VisitorleaveDirectionMode = new onUserEnter(MapOwner.ALLATORIxDEMO("\u001eW;W<Q:R-_>[\fW:[+J!Q&s'Z-"), 109);
            visitorPT_Enter = new onUserEnter(MapleFamily.ALLATORIxDEMO("6\u00073\u00074\u00012>\u00141\u0005\u00004\u000b2"), 110);
            VisitorCubePhase00_Enter = new onUserEnter(MapOwner.ALLATORIxDEMO("h!M!J'L\u000bK*[\u0018V)M-\u000exa\rP<[:"), 111);
            visitor_ReviveMap = new onUserEnter(MapleFamily.ALLATORIxDEMO("6\u00073\u00074\u000121\u0012\u000b6\u00076\u000b\r\u000f0"), 112);
            cannon_tuto_01 = new onUserEnter(MapOwner.ALLATORIxDEMO("])P&Q&a<K<Q\u0017\u000ey"), 113);
            cannon_tuto_direction = new onUserEnter(MapleFamily.ALLATORIxDEMO("#\u000f.\u0000/\u0000\u001f\u001a5\u001a/1$\u00072\u000b#\u001a)\u0001."), 114);
            cannon_tuto_direction1 = new onUserEnter(MapOwner.ALLATORIxDEMO("])P&Q&a<K<Q\u0017Z!L-]<W'Py"), 115);
            cannon_tuto_direction2 = new onUserEnter(MapleFamily.ALLATORIxDEMO("\r!\u0000.\u0001.14\u001b4\u0001\u001f\n)\u001c%\r4\u0007/\u0000r"), 116);
            userInBattleSquare = new onUserEnter(MapOwner.ALLATORIxDEMO("K;[:w&|)J<R-m9K)L-"), 117);
            merTutorDrecotion00 = new onUserEnter(MapleFamily.ALLATORIxDEMO("-\u000b2:5\u001a/\u001c\u0004\u001c%\r/\u001a)\u0001.^p"), 118);
            merTutorDrecotion10 = new onUserEnter(MapOwner.ALLATORIxDEMO("%[:j=J'L\fL-]'J!Q&\u000fx"), 119);
            merTutorDrecotion20 = new onUserEnter(MapleFamily.ALLATORIxDEMO("-\u000b2:5\u001a/\u001c\u0004\u001c%\r/\u001a)\u0001.\\p"), 120);
            merStandAlone = new onUserEnter(MapOwner.ALLATORIxDEMO("%[:m<_&Z\tR'P-"), 121);
            merOutStandAlone = new onUserEnter(MapleFamily.ALLATORIxDEMO("\u0003%\u001c\u000f\u001b4=4\u000f.\n\u0001\u0002/\u0000%"), 122);
            merTutorSleep00 = new onUserEnter(MapOwner.ALLATORIxDEMO("%[:j=J'L\u001bR-[8\u000ex"), 123);
            merTutorSleep01 = new onUserEnter(MapleFamily.ALLATORIxDEMO("-\u000b2:5\u001a/\u001c\u0013\u0002%\u000b0^q"), 124);
            merTutorSleep02 = new onUserEnter(MapOwner.ALLATORIxDEMO("%[:j=J'L\u001bR-[8\u000ez"), 125);
            EntereurelTW = new onUserEnter(MapleFamily.ALLATORIxDEMO("+.\u001a%\u001c%\u001b2\u000b,:\u0017"), 126);
            ds_tuto_ill0 = new onUserEnter(MapOwner.ALLATORIxDEMO("Z;a<K<Q\u0017W$Rx"), 127);
            ds_tuto_0_0 = new onUserEnter(MapleFamily.ALLATORIxDEMO("$\u001d\u001f\u001a5\u001a/1p1p"), 128);
            ds_tuto_1_0 = new onUserEnter(MapOwner.ALLATORIxDEMO(",M\u0017J=J'ayax"), 129);
            ds_tuto_3_0 = new onUserEnter(MapleFamily.ALLATORIxDEMO("$\u001d\u001f\u001a5\u001a/1s1p"), 130);
            ds_tuto_3_1 = new onUserEnter(MapOwner.ALLATORIxDEMO(",M\u0017J=J'a{ay"), 131);
            ds_tuto_4_0 = new onUserEnter(MapleFamily.ALLATORIxDEMO("$\u001d\u001f\u001a5\u001a/1t1p"), 132);
            ds_tuto_5_0 = new onUserEnter(MapOwner.ALLATORIxDEMO(",M\u0017J=J'a}ax"), 133);
            ds_tuto_2_prep = new onUserEnter(MapleFamily.ALLATORIxDEMO("\n314\u001b4\u0001\u001f\\\u001f\u001e2\u000b0"), 134);
            ds_tuto_1_before = new onUserEnter(MapOwner.ALLATORIxDEMO("Z;a<K<Q\u0017\u000f\u0017\\-X'L-"), 135);
            ds_tuto_2_before = new onUserEnter(MapleFamily.ALLATORIxDEMO("\n314\u001b4\u0001\u001f\\\u001f\f%\b/\u001c%"), 136);
            ds_tuto_home_before = new onUserEnter(MapOwner.ALLATORIxDEMO(",M\u0017J=J'a Q%[\u0017\\-X'L-"), 137);
            ds_tuto_ani = new onUserEnter(MapleFamily.ALLATORIxDEMO("$\u001d\u001f\u001a5\u001a/1!\u0000)"), 138);
            onUserEnter[] arronUserEnter = new onUserEnter[139];
            arronUserEnter[0] = babyPigMap;
            arronUserEnter[1] = crash_Dragon;
            arronUserEnter[2] = evanleaveD;
            arronUserEnter[3] = getDragonEgg;
            arronUserEnter[4] = meetWithDragon;
            arronUserEnter[5] = go1010100;
            arronUserEnter[6] = go1010200;
            arronUserEnter[7] = go1010300;
            arronUserEnter[8] = go1010400;
            arronUserEnter[9] = evanPromotion;
            arronUserEnter[10] = PromiseDragon;
            arronUserEnter[11] = evanTogether;
            arronUserEnter[12] = incubation_dragon;
            arronUserEnter[13] = TD_MC_Openning;
            arronUserEnter[14] = TD_MC_gasi;
            arronUserEnter[15] = TD_MC_title;
            arronUserEnter[16] = cygnusJobTutorial;
            arronUserEnter[17] = cygnusTest;
            arronUserEnter[18] = startEreb;
            arronUserEnter[19] = dojang_Msg;
            arronUserEnter[20] = dojang_1st;
            arronUserEnter[21] = reundodraco;
            arronUserEnter[22] = undomorphdarco;
            arronUserEnter[23] = explorationPoint;
            arronUserEnter[24] = goAdventure;
            arronUserEnter[25] = go10000;
            arronUserEnter[26] = go20000;
            arronUserEnter[27] = go30000;
            arronUserEnter[28] = go40000;
            arronUserEnter[29] = go50000;
            arronUserEnter[30] = go1000000;
            arronUserEnter[31] = go1010000;
            arronUserEnter[32] = go1020000;
            arronUserEnter[33] = go2000000;
            arronUserEnter[34] = goArcher;
            arronUserEnter[35] = goPirate;
            arronUserEnter[36] = goRogue;
            arronUserEnter[37] = goMagician;
            arronUserEnter[38] = goSwordman;
            arronUserEnter[39] = goLith;
            arronUserEnter[40] = iceCave;
            arronUserEnter[41] = mirrorCave;
            arronUserEnter[42] = aranDirection;
            arronUserEnter[43] = rienArrow;
            arronUserEnter[44] = rien;
            arronUserEnter[45] = check_count;
            arronUserEnter[46] = Massacre_first;
            arronUserEnter[47] = Massacre_result;
            arronUserEnter[48] = TD_MC_gasi2;
            arronUserEnter[49] = aranTutorAlone;
            arronUserEnter[50] = evanAlone;
            arronUserEnter[51] = dojang_QcheckSet;
            arronUserEnter[52] = Sky_StageEnter;
            arronUserEnter[53] = outCase;
            arronUserEnter[54] = balog_buff;
            arronUserEnter[55] = balog_dateSet;
            arronUserEnter[56] = Sky_BossEnter;
            arronUserEnter[57] = Sky_GateMapEnter;
            arronUserEnter[58] = shammos_Enter;
            arronUserEnter[59] = shammos_Result;
            arronUserEnter[60] = shammos_Base;
            arronUserEnter[61] = dollCave00;
            arronUserEnter[62] = dollCave01;
            arronUserEnter[63] = Sky_Quest;
            arronUserEnter[64] = enterBlackfrog;
            arronUserEnter[65] = onSDI;
            arronUserEnter[66] = blackSDI;
            arronUserEnter[67] = summonIceWall;
            arronUserEnter[68] = metro_firstSetting;
            arronUserEnter[69] = start_itemTake;
            arronUserEnter[70] = PRaid_D_Enter;
            arronUserEnter[71] = PRaid_B_Enter;
            arronUserEnter[72] = PRaid_Revive;
            arronUserEnter[73] = PRaid_W_Enter;
            arronUserEnter[74] = PRaid_WinEnter;
            arronUserEnter[75] = PRaid_FailEnter;
            arronUserEnter[76] = Ghost;
            arronUserEnter[77] = TD_MC_keycheck;
            arronUserEnter[78] = pepeking_effect;
            arronUserEnter[79] = findvioleta;
            arronUserEnter[80] = NULL;
            arronUserEnter[81] = VanLeon_Before;
            arronUserEnter[82] = VanLeon_ExpeditionEnter;
            arronUserEnter[83] = mPark_stageEff;
            arronUserEnter[84] = in_secretroom;
            arronUserEnter[85] = sealGarden;
            arronUserEnter[86] = TD_NC_title;
            arronUserEnter[87] = TD_neo_BossEnter;
            arronUserEnter[88] = Resi_tutor10;
            arronUserEnter[89] = Resi_tutor20;
            arronUserEnter[90] = Resi_tutor30;
            arronUserEnter[91] = Resi_tutor40;
            arronUserEnter[92] = Resi_tutor50;
            arronUserEnter[93] = Resi_tutor60;
            arronUserEnter[94] = Resi_tutor70;
            arronUserEnter[95] = Resi_tutor80;
            arronUserEnter[96] = Resi_tutor50_1;
            arronUserEnter[97] = summonSchiller;
            arronUserEnter[98] = q31102e;
            arronUserEnter[99] = q31103s;
            arronUserEnter[100] = jail;
            arronUserEnter[101] = cygnus_ExpeditionEnter;
            arronUserEnter[102] = knights_Summon;
            arronUserEnter[103] = TCMobrevive;
            arronUserEnter[104] = moonrabbit_takeawayitem;
            arronUserEnter[105] = StageMsg_crack;
            arronUserEnter[106] = shammos_Start;
            arronUserEnter[107] = iceman_Enter;
            arronUserEnter[108] = prisonBreak_1stageEnter;
            arronUserEnter[109] = VisitorleaveDirectionMode;
            arronUserEnter[110] = visitorPT_Enter;
            arronUserEnter[111] = VisitorCubePhase00_Enter;
            arronUserEnter[112] = visitor_ReviveMap;
            arronUserEnter[113] = cannon_tuto_01;
            arronUserEnter[114] = cannon_tuto_direction;
            arronUserEnter[115] = cannon_tuto_direction1;
            arronUserEnter[116] = cannon_tuto_direction2;
            arronUserEnter[117] = userInBattleSquare;
            arronUserEnter[118] = merTutorDrecotion00;
            arronUserEnter[119] = merTutorDrecotion10;
            arronUserEnter[120] = merTutorDrecotion20;
            arronUserEnter[121] = merStandAlone;
            arronUserEnter[122] = merOutStandAlone;
            arronUserEnter[123] = merTutorSleep00;
            arronUserEnter[124] = merTutorSleep01;
            arronUserEnter[125] = merTutorSleep02;
            arronUserEnter[126] = EntereurelTW;
            arronUserEnter[127] = ds_tuto_ill0;
            arronUserEnter[128] = ds_tuto_0_0;
            arronUserEnter[129] = ds_tuto_1_0;
            arronUserEnter[130] = ds_tuto_3_0;
            arronUserEnter[131] = ds_tuto_3_1;
            arronUserEnter[132] = ds_tuto_4_0;
            arronUserEnter[133] = ds_tuto_5_0;
            arronUserEnter[134] = ds_tuto_2_prep;
            arronUserEnter[135] = ds_tuto_1_before;
            arronUserEnter[136] = ds_tuto_2_before;
            arronUserEnter[137] = ds_tuto_home_before;
            arronUserEnter[138] = ds_tuto_ani;
            ALLATORIxDEMO = arronUserEnter;
        }
    }
}

