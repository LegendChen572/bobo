/*
 * Decompiled with CFR 0.150.
 */
package server.events;

import client.MapleBuffStatValueHolder;
import client.MapleCharacter;
import constants.GameSetConstants;
import handling.channel.ChannelServer;
import handling.world.World;
import server.MapleInventoryManipulator;
import server.RandomRewards;
import server.Randomizer;
import server.Timer;
import server.events.MapleEventType;
import server.maps.MapleMap;
import server.maps.SavedLocationType;
import tools.JsonMapConverter;
import tools.MaplePacketCreator;

public abstract class MapleEvent {
    public /* synthetic */ int[] mapid;
    public /* synthetic */ boolean isRunning;
    public /* synthetic */ int world;
    public /* synthetic */ int channel;

    public static final /* synthetic */ void onStartEvent(MapleCharacter a2) {
        int n2;
        MapleEventType[] arrmapleEventType = MapleEventType.values();
        int n3 = arrmapleEventType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            MapleEvent mapleEvent;
            MapleEventType mapleEventType = arrmapleEventType[n2];
            if (a2.getClient().getChannelServer().getEvent(mapleEventType) != null && (mapleEvent = a2.getClient().getChannelServer().getEvent(mapleEventType)) != null && mapleEvent.isRunning) {
                int n5;
                int[] arrn = mapleEvent.mapid;
                int n6 = mapleEvent.mapid.length;
                int n7 = n5 = 0;
                while (n7 < n6) {
                    int n8 = arrn[n5];
                    if (a2.getMapId() == n8) {
                        mapleEvent.startEvent();
                        a2.getMap().broadcastMessage(MaplePacketCreator.getErrorNotice(String.valueOf((Object)mapleEventType) + " \u6d3b\u52d5\u958b\u59cb\u3002"));
                    }
                    n7 = ++n5;
                }
            }
            n4 = ++n2;
        }
    }

    public /* synthetic */ void broadcast(byte[] a2) {
        MapleEvent a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.mapid.length) {
            a3.getMap(n2++).broadcastMessage(a2);
            n3 = n2;
        }
    }

    public /* synthetic */ void unreset() {
        a.isRunning = false;
    }

    public /* synthetic */ void onMapLoad(MapleCharacter a2) {
    }

    public /* synthetic */ boolean isRunning() {
        MapleEvent a2;
        return a2.isRunning;
    }

    public /* synthetic */ void startEvent() {
    }

    public /* synthetic */ ChannelServer getChannelServer() {
        MapleEvent a2;
        MapleEvent mapleEvent = a2;
        return ChannelServer.getInstance(mapleEvent.world, mapleEvent.channel);
    }

    public /* synthetic */ void warpBack(MapleCharacter a2) {
        int n2 = a2.getSavedLocation(SavedLocationType.EVENT);
        if (n2 <= -1) {
            n2 = 104000000;
        }
        MapleCharacter mapleCharacter = a2;
        MapleMap mapleMap = mapleCharacter.getClient().getChannelServer().getMapFactory().getMap(n2);
        mapleCharacter.changeMap(mapleMap, mapleMap.getPortal(0));
    }

    public /* synthetic */ MapleEvent(int a2, int a3, int[] a4) {
        MapleEvent a5;
        MapleEvent mapleEvent = a5;
        MapleEvent mapleEvent2 = a5;
        mapleEvent2.isRunning = false;
        mapleEvent2.world = a2;
        mapleEvent.channel = a3;
        mapleEvent.mapid = a4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public /* synthetic */ void givePrize(MapleCharacter a2) {
        int n2;
        int n3 = RandomRewards.getInstance().getEventReward();
        switch (n3) {
            case 0: {
                a2.gainMeso(66666, true, false, false);
                a2.dropMessage(5, JsonMapConverter.ALLATORIxDEMO("\u4f64\u7307\u5f93U2C2C2U\u6957\u5e16"));
                return;
            }
            case 1: {
                a2.gainMeso(399999, true, false, false);
                a2.dropMessage(5, MapleBuffStatValueHolder.ALLATORIxDEMO("\u4f20\u7322\u5fd7psiyiyi`\u6903\u5e23"));
                return;
            }
            case 2: {
                a2.gainMeso(666666, true, false, false);
                a2.dropMessage(5, JsonMapConverter.ALLATORIxDEMO("\u4f15\u7376\u5fe2$C2C2C2U\u6957\u5e16"));
                return;
            }
            case 3: {
                a2.addFame(10);
                a2.dropMessage(5, MapleBuffStatValueHolder.ALLATORIxDEMO("\u4f20\u7322\u5fd7pq``\u545d\u8032"));
                return;
            }
        }
        int n4 = 1;
        switch (n3) {
            case 5062000: {
                n2 = n4 = 3;
                break;
            }
            case 5220000: {
                n2 = n4 = 25;
                break;
            }
            case 4031307: 
            case 5050000: {
                n2 = n4 = 5;
                break;
            }
            case 2022121: {
                n4 = 10;
            }
            default: {
                n2 = n4;
            }
        }
        n4 = (n2 > 1 ? Randomizer.nextInt(n4) : 0) + 1;
        MapleCharacter mapleCharacter = a2;
        if (MapleInventoryManipulator.checkSpace(a2.getClient(), n3, n4, "")) {
            MapleInventoryManipulator.addById(mapleCharacter.getClient(), n3, (short)n4);
            return;
        }
        mapleCharacter.gainMeso(100000, true, false, false);
        a2.dropMessage(5, JsonMapConverter.ALLATORIxDEMO("\u53b6\u52a4\u733b$D4E4E4U\u6957\u5e16"));
    }

    public static final /* synthetic */ void setEvent(ChannelServer a2, boolean a32) {
        if (a32) {
            int n2;
            MapleEventType[] a32 = MapleEventType.values();
            int n3 = a32.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                Object object = a32[n2];
                if ((object = a2.getEvent((MapleEventType)((Object)object))) != null && ((MapleEvent)object).isRunning) {
                    int n5;
                    int[] arrn = ((MapleEvent)object).mapid;
                    int n6 = ((MapleEvent)object).mapid.length;
                    int n7 = n5 = 0;
                    while (n7 < n6) {
                        int n8 = arrn[n5];
                        if (a2.getEvent() == n8) {
                            Object object2 = object;
                            ((MapleEvent)object2).broadcast(MaplePacketCreator.serverNotice(MapleBuffStatValueHolder.ALLATORIxDEMO("\u8d8d\u96a2\u6d6b\u5295\u95db\u598b\u53ba\u5229\u4e50\u5246\u9448a")));
                            ((MapleEvent)object2).broadcast(MaplePacketCreator.getClock(60));
                            Timer.EventTimer.getInstance().schedule(new Runnable((MapleEvent)object){
                                public final /* synthetic */ MapleEvent ALLATORIxDEMO;

                                @Override
                                public /* synthetic */ void run() {
                                    1 a2;
                                    a2.ALLATORIxDEMO.startEvent();
                                }
                                {
                                    1 a2;
                                    a2.ALLATORIxDEMO = mapleEvent;
                                }
                            }, 60000L);
                            break;
                        }
                        n7 = ++n5;
                    }
                }
                n4 = ++n2;
            }
        }
        a2.setEvent(-1);
    }

    public /* synthetic */ MapleMap getMap(int a2) {
        MapleEvent a3;
        return a3.getChannelServer().getMapFactory().getMap(a3.mapid[a2]);
    }

    public static final /* synthetic */ String scheduleEvent(MapleEventType a2, ChannelServer a3) {
        int n2;
        if (a3.getEvent() != -1 || a3.getEvent(a2) == null) {
            return JsonMapConverter.ALLATORIxDEMO("\u8a76\u6d4e\u52d1\u5d87\u7d97\u88de\u7985\u6b17\u5b8d\u63e7\u4e82[");
        }
        int[] arrn = a3.getEvent((MapleEventType)a2).mapid;
        int n3 = a3.getEvent((MapleEventType)a2).mapid.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            int n5 = arrn[n2];
            if (a3.getMapFactory().getMap(n5).getCharactersSize() > 0) {
                return MapleBuffStatValueHolder.ALLATORIxDEMO("\u8a22\u6d7b\u5285\u5db2\u7dc3\u5768\u57a7\u880c\u4e7dn");
            }
            n4 = ++n2;
        }
        ChannelServer channelServer = a3;
        MapleEventType mapleEventType = a2;
        channelServer.setEvent(channelServer.getEvent((MapleEventType)mapleEventType).mapid[0]);
        channelServer.getEvent(mapleEventType).reset();
        MapleEventType mapleEventType2 = a2;
        if (GameSetConstants.SERVER_NAME.equals(JsonMapConverter.ALLATORIxDEMO("\u6926\u4e4f\u75a0"))) {
            World.Broadcast.broadcastMessage(MaplePacketCreator.serverNotice("\u6d3b\u52d5 " + String.valueOf((Object)mapleEventType2) + " \u5373\u5c07\u5728\u983b\u9053 " + a3.getChannel() + " \u8209\u884c , \u82e5\u8981\u53c3\u52a0\u8acb\u627e-\u6d3b\u52d5NPC"));
        } else {
            World.Broadcast.broadcastMessage(MaplePacketCreator.serverNotice("\u6d3b\u52d5 " + String.valueOf((Object)mapleEventType2) + " \u5373\u5c07\u5728\u983b\u9053 " + a3.getChannel() + " \u8209\u884c , \u82e5\u8981\u53c3\u52a0\u8acb\u627e\u5c0f\u5e6b\u624b-\u53c3\u52a0\u6d3b\u52d5"));
        }
        return "";
    }

    public /* synthetic */ void finished(MapleCharacter a2) {
    }

    public /* synthetic */ void reset() {
        a.isRunning = true;
    }

    public static final /* synthetic */ void mapLoad(MapleCharacter a2, int a3, int a4) {
        int n2;
        if (a2 == null) {
            return;
        }
        MapleEventType[] arrmapleEventType = MapleEventType.values();
        int n3 = arrmapleEventType.length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            Object object = arrmapleEventType[n2];
            if (ChannelServer.getInstance(a4, a3) != null && (object = ChannelServer.getInstance(a4, a3).getEvent((MapleEventType)((Object)object))) != null && ((MapleEvent)object).isRunning) {
                int n5;
                if (a2.getMapId() == 109050000) {
                    ((MapleEvent)object).finished(a2);
                }
                int[] arrn = ((MapleEvent)object).mapid;
                int n6 = ((MapleEvent)object).mapid.length;
                int n7 = n5 = 0;
                while (n7 < n6) {
                    int n8 = arrn[n5];
                    if (a2.getMapId() == n8) {
                        ((MapleEvent)object).onMapLoad(a2);
                    }
                    n7 = ++n5;
                }
            }
            n4 = ++n2;
        }
    }
}

