/*
 * Decompiled with CFR 0.150.
 */
package handling.world;

import client.BuddyEntry;
import client.BuddyList;
import client.ClientRedirector;
import client.MapleCharacter;
import client.MapleClient;
import client.MapleCoolDownValueHolder;
import client.MapleDiseaseValueHolder;
import client.MapleFriendship;
import client.MapleStat;
import client.inventory.IItem;
import client.inventory.MapleInventoryType;
import client.inventory.MaplePet;
import client.inventory.PetDataFactory;
import client.messages.ConsoleCommandObject;
import client.messages.commands.player.eventSystem.BankSystem;
import client.messages.commands.player.eventSystem.MonsterPetSystem;
import client.status.MonsterStatusEffect;
import constants.BanAttackIP;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.ServerSet;
import handling.cashshop.handler.CashShopOperation;
import handling.channel.ChannelServer;
import handling.channel.MapleRanking;
import handling.channel.PlayerStorage;
import handling.channel.handler.BBSHandler;
import handling.channel.handler.PartyHandler;
import handling.login.LoginServer;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.PartyOperation;
import handling.world.CharacterIdChannelPair;
import handling.world.CharacterTransfer;
import handling.world.CheaterData;
import handling.world.MapleMessenger;
import handling.world.MapleMessengerCharacter;
import handling.world.MapleParty;
import handling.world.MaplePartyCharacter;
import handling.world.PlayerBuffValueHolder;
import handling.world.exped.ExpeditionType;
import handling.world.exped.MapleExpedition;
import handling.world.family.MapleFamily;
import handling.world.family.MapleFamilyCharacter;
import handling.world.guild.MapleBBSThread;
import handling.world.guild.MapleGuild;
import handling.world.guild.MapleGuildAlliance;
import handling.world.guild.MapleGuildCharacter;
import handling.world.guild.MapleGuildSummary;
import handling.world.sidekick.MapleSidekick;
import handling.world.weather.WeatherHandler;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import scripting.event.EventInstanceManager;
import scripting.event.EventManager;
import scripting.reactor.ReactorScriptManager;
import server.Auction.AuctionItemFactory;
import server.Framework.MapleExtendedSlots;
import server.MTSStorage;
import server.MapleCarnivalChallenge;
import server.MapleSquad;
import server.Randomizer;
import server.Timer;
import server.game.Baccarat;
import server.game.BlackJack;
import server.game.Cryptocurrency;
import server.game.Lottory;
import server.game.NiuNiu;
import server.life.MapleLifeFactory;
import server.life.MapleMonster;
import server.life.MapleMonsterInformationProvider;
import server.life.OverrideMonsterStats;
import server.maps.MapleMap;
import server.maps.MapleMapItem;
import server.shops.HiredFishing;
import server.shops.HiredMerchant;
import tools.CollectionUtil;
import tools.ConcurrentEnumMap;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.database.MysqlBackup;
import tools.html.JsoupTool;
import tools.packet.MobPacket;
import tools.packet.PetPacket;
import tools.use.donate;
import tools.windows.CmdExecute;
import tools.wztosql.DumpMapName;

/*
 * Exception performing whole class analysis ignored.
 */
public class World {
    private /* synthetic */ int B;
    private /* synthetic */ String a;
    public static /* synthetic */ boolean isWorldSaving;
    private /* synthetic */ int e;
    private static final /* synthetic */ ReentrantReadWriteLock h;
    private static final /* synthetic */ Map<String, Long> i;
    private static final /* synthetic */ Map<String, Integer> j;
    private static final /* synthetic */ ReentrantReadWriteLock D;
    private static final /* synthetic */ Map<Integer, Integer> J;
    private /* synthetic */ int E;
    private /* synthetic */ boolean d;
    private /* synthetic */ int K;
    private static final /* synthetic */ ReentrantReadWriteLock A;
    private static /* synthetic */ PlayerStorage M;
    private static final /* synthetic */ List<Integer> G;
    private static final /* synthetic */ List<Integer> P;
    private /* synthetic */ int F;
    private /* synthetic */ int H;
    private /* synthetic */ List<ChannelServer> ALLATORIxDEMO;
    private static final /* synthetic */ ReentrantReadWriteLock f;
    private static final /* synthetic */ ReentrantReadWriteLock m;
    private /* synthetic */ int k;
    private static final /* synthetic */ List<String> c;
    private /* synthetic */ int I;
    private static final /* synthetic */ List<Integer> w;
    private static final /* synthetic */ List<String> b;
    private static final /* synthetic */ ReentrantReadWriteLock L;
    private /* synthetic */ int C;
    private /* synthetic */ int g;
    private static final /* synthetic */ Map<Integer, Integer> l;
    public static /* synthetic */ boolean isShutDown;

    public static /* synthetic */ boolean isCharacterListConnected(List<String> a2) {
        for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
            for (String string : a2) {
                if (channelServer.getPlayerStorage().getCharacterByName(string) == null) continue;
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void AutoSpawnEventMob() {
        if (GameSetConstants.MAP_RANDOM_MOB) {
            System.out.println(MapleFriendship.ALLATORIxDEMO("\u3008\u81c1\u7529\u5e29\u582c\u53c7\u5582\u6001\u7ce3\u7d5a\u3009\u5574\u7530"));
            Timer.EventTimer.getInstance().registerHour(new Runnable(){
                {
                    6 a2;
                }

                @Override
                public /* synthetic */ void run() {
                    int n2;
                    int n3 = n2 = 0;
                    while (n3 < GameSetConstants.MAP_RANDOM_MOB_COUNT) {
                        int n4 = 0;
                        int n5 = Randomizer.rand(0, GameSetConstants.MAP_RANDOM_MOBID.length - 1);
                        n5 = GameSetConstants.MAP_RANDOM_MOBID[n5];
                        int n6 = Randomizer.NewRand(1, 500) + Randomizer.NewRand(1, 1000) + Randomizer.NewRand(1, 600) + Randomizer.NewRand(1, 140) - 638;
                        int n7 = Randomizer.rand(1, ChannelServer.getChannelCount());
                        MapleMap mapleMap = null;
                        int n8 = Randomizer.rand(0, GameSetConstants.MAP_RANDOM_MAPID.length - 1);
                        n8 = GameSetConstants.MAP_RANDOM_MAPID[n8];
                        int n9 = GameSetConstants.MAP_RANDOM_MOBHP;
                        for (ChannelServer channelServer : LoginServer.getWorldStatic(n4).getChannels()) {
                            String string;
                            ChannelServer channelServer2;
                            if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                            if (GameSetConstants.MAP_MOB_ALLCHANNEL) {
                                channelServer2 = channelServer;
                            } else {
                                if (channelServer.getChannel() != n7) continue;
                                channelServer2 = channelServer;
                            }
                            if ((mapleMap = channelServer2.getMapFactory().getMap(n8)) == null) continue;
                            MapleMap mapleMap2 = mapleMap;
                            String string2 = mapleMap2.getMapName();
                            mapleMap2.resetFully();
                            MapleMonster mapleMonster = MapleLifeFactory.getMonster(n5);
                            if (n9 > 0) {
                                OverrideMonsterStats overrideMonsterStats = new OverrideMonsterStats(n9, mapleMonster.getMobMaxMp(), mapleMonster.getStats().getExp(), false);
                                mapleMonster.setHp(n9);
                            }
                            mapleMonster.setEventMob(true);
                            mapleMap.spawnMonster(mapleMonster);
                            if (!GameSetConstants.SHOWMAPMOB_LOCATION) {
                                Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u5728\u67d0\u500b\u6751\u838a\u88e1\u51fa\u73fe\u4e86\u96b1\u85cfBOSS\uff01\u52c7\u8005\u5011\u5feb\u4e0a\u5427\uff01 \u4f4d\u7f6e\u4f4d\u65bc: \u983b\u9053 " + n7));
                                string = string2;
                            } else {
                                Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice("\u5728" + string2 + "\u88e1\u51fa\u73fe\u4e86\u96b1\u85cfBOSS " + mapleMonster.getStats().getName() + " \u4f4d\u7f6e\u4f4d\u65bc: \u983b\u9053 " + n7));
                                string = string2;
                            }
                            Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("<GM\u63d0\u793a> \u5728" + string + "\u88e1\u51fa\u73fe\u4e86\u96b1\u85cfBOSS " + mapleMonster.getStats().getName() + " \u4f4d\u7f6e\u4f4d\u65bc: \u983b\u9053 " + n7 + " \u602a\u7269\u4f4d\u7f6e: x:" + n6 + " y:34"));
                            System.out.println("\u5728" + string2 + "\u88e1\u51fa\u73fe\u4e86\u96b1\u85cfBOSS ");
                        }
                        n3 = ++n2;
                    }
                }
            }, GameSetConstants.MAP_RANDOM_TIME, 1L);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void handleCharacterBuff(MapleMap a, int a, int a, long a) {
        if (a.characterSize() <= 0) return;
        a = a.getCharactersThreadsafe().iterator();
        while (a.hasNext() != false) {
            var5_5 = a.next();
            var6_6 = new ArrayList<MapleBuffStat>();
            for (PlayerBuffValueHolder var8_12 : var5_5.getAllBuffs()) {
                if (var8_12.startTime + (long)var8_12.localDuration >= a) continue;
                v0 = var8_12;
                var5_5.cancelEffect(v0.effect, false, var8_12.startTime);
                v1 = v0.statup.iterator();
                while (v1.hasNext()) {
                    var10_16 = var9_14.next();
                    var6_6.add((MapleBuffStat)var10_16.left);
                    v1 = var9_14;
                }
            }
            if (var6_6.size() > 0) {
                var5_5.cancelBuffStats(var6_6);
            }
            if (var5_5.getBuffedValue(MapleBuffStat.SOARING) == null) ** GOTO lbl32
            var7_9 = var5_5.getStat().getMp() - 3;
            v2 = var5_5;
            if (var7_9 > 0) {
                v2.getStat().setMp(var7_9);
                var5_5.updateSingleStat(MapleStat.MP, var7_9);
                v3 = var5_5;
            } else {
                v2.getStat().setMp(0);
                var5_5.updateSingleStat(MapleStat.MP, 0);
lbl32:
                // 2 sources

                v3 = var5_5;
            }
            if (v3.getBuffedValue(MapleBuffStat.SOARING) == null) ** GOTO lbl45
            var7_10 = var5_5.getStat().getMp() - 3;
            v4 = var5_5;
            if (var7_10 > 0) {
                v4.getStat().setMp(var7_10);
                var5_5.updateSingleStat(MapleStat.MP, var7_10);
                v5 = a;
            } else {
                v4.getStat().setMp(0);
                var5_5.updateSingleStat(MapleStat.MP, 0);
lbl45:
                // 2 sources

                v5 = a;
            }
            if (v5 % 4 != 0 || var5_5.getBuffedValue(MapleBuffStat.INFINITY) == null || !var5_5.isAlive() || (var7_11 = var5_5.getStatForBuff(MapleBuffStat.INFINITY)) == null) continue;
            v6 = var5_5;
            var8_13 = Math.max(var7_11.getDuration(), var7_11.alchemistModifyVal(v6, var7_11.getDuration(), false));
            var9_15 = v6.getBuffedStarttime(MapleBuffStat.INFINITY);
            if ((var8_13 += (int)(var9_15 - System.currentTimeMillis())) <= 0) continue;
            var6_7 = var5_5.getBuffedValue(MapleBuffStat.INFINITY) + var7_11.getDamage();
            new EnumMap<MapleBuffStat, Integer>(MapleBuffStat.class).put(MapleBuffStat.INFINITY, var6_7);
            v7 = var7_11;
            var5_5.setBuffedValue(MapleBuffStat.INFINITY, var6_7);
            v8 = var5_5;
            v8.addHP((int)(v7.getHpR() * (double)v8.getStat().getCurrentMaxHp()));
            v9 = var5_5;
            v9.addMP((int)(v7.getMpR() * (double)v9.getStat().getCurrentMaxMp()));
        }
    }

    public static /* synthetic */ HiredFishing hasFishing(int a2) {
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            for (ChannelServer channelServer : iterator.next().getChannels()) {
                HiredFishing hiredFishing;
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20 || (hiredFishing = channelServer.containsFishing(a2)) == null) continue;
                return hiredFishing;
            }
        }
        return null;
    }

    public static final /* synthetic */ void AddClientChannelTransfer(String a2) {
        L.writeLock().lock();
        try {
            c.add(a2);
            return;
        }
        finally {
            L.writeLock().unlock();
        }
    }

    public static /* synthetic */ int getMerchantChannel(MapleCharacter a2) {
        for (ChannelServer channelServer : ChannelServer.getAllChannelInstances()) {
            if (channelServer.getMerchantMap(a2) == -1) continue;
            return channelServer.getChannel();
        }
        return -1;
    }

    public /* synthetic */ int getFlag() {
        World a2;
        return a2.F;
    }

    public static /* synthetic */ void toggleMegaphoneMuteState() {
        Iterator<ChannelServer> iterator;
        Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllInstances().iterator();
        while (iterator2.hasNext()) {
            iterator.next().toggleMegaphoneMuteState();
            iterator2 = iterator;
        }
    }

    public /* synthetic */ World(int a2, int a3, String a4, int a5, int a6, int a7, int a8, boolean a9) {
        World a10;
        World world = a10;
        World world2 = a10;
        World world3 = a10;
        World world4 = a10;
        World world5 = a10;
        a10.E = 3;
        world5.g = 3;
        world5.B = 0;
        World world6 = a10;
        world5.ALLATORIxDEMO = new ArrayList<ChannelServer>();
        world4.I = a2;
        world4.F = a3;
        world3.a = a4;
        world3.C = a5;
        world2.H = a6;
        world2.e = a7;
        world.K = a8;
        world.d = a9;
    }

    public static /* synthetic */ void channelChangeData(CharacterTransfer a2, MapleClient a3, int a4, int a5, int a6) {
        World.getStorage(a5, a6).registerPendingPlayer(a2, a4);
        World.getStorage(a5, a6).registerPendingClient(a3, a4);
    }

    public static /* synthetic */ void handleFishAction(MapleMap a2, long a3) {
        if (a2.characterSize() > 0) {
            Iterator<MapleCharacter> iterator;
            MapleMap mapleMap = a2;
            boolean bl = mapleMap.canHurt();
            Iterator<MapleCharacter> iterator2 = iterator = mapleMap.getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                World.handleFish(iterator.next(), a3);
                iterator2 = iterator;
            }
        }
    }

    public static /* synthetic */ int removeFromWheelCache(int a2) {
        return J.remove(a2);
    }

    public static /* synthetic */ void handleMonster(MapleMap a2, int a3, int a42, long a5) {
        if (a2.getMobsSize() > 0 && a2.getPlayerSize() > 0) {
            for (MapleMonster a42 : a2.getAllMonstersThreadsafe()) {
                Object object;
                if (!a42.isAlive()) continue;
                if (a42.shouldDrop(a5)) {
                    a42.doDropItem(a5);
                }
                if (a42.getStatiSize() > 0) {
                    object = a42.getAllBuffs().iterator();
                    while (object.hasNext()) {
                        MonsterStatusEffect monsterStatusEffect = (MonsterStatusEffect)object.next();
                        if (!monsterStatusEffect.shouldCancel(a5)) continue;
                        a42.cancelSingleStatus(monsterStatusEffect);
                    }
                }
                if ((object = a2.getRandChr()) == null || !((MapleCharacter)object).isAlive()) continue;
            }
        }
    }

    public static /* synthetic */ void handleMap(MapleMap a2, int a3, int a4) {
        if (a2.getItemsSize() > 0) {
            for (MapleMapItem object : a2.getAllItemsThreadsafe()) {
                if (object.shouldExpire()) {
                    object.expire(a2);
                    continue;
                }
                if (!object.shouldFFA()) continue;
                object.setDropType((byte)2);
            }
        }
        if (a2.characterSize() > 0) {
            Iterator<MapleCharacter> iterator;
            if (a2.canSpawn()) {
                a2.respawn(false);
            }
            MapleMap mapleMap = a2;
            a4 = mapleMap.canHurt() ? 1 : 0;
            Iterator<MapleCharacter> iterator2 = iterator = mapleMap.getCharactersThreadsafe().iterator();
            while (iterator2.hasNext()) {
                World.handleCooldowns(iterator.next(), a3, a4 != 0);
                iterator2 = iterator;
            }
        }
    }

    public static final /* synthetic */ void removeChangeChannel(int a2) {
        f.writeLock().lock();
        try {
            if (l.containsKey(a2)) {
                l.remove(a2);
            }
            return;
        }
        finally {
            f.writeLock().unlock();
        }
    }

    public /* synthetic */ void setEventMessage(String a2) {
        a.a = a2;
    }

    public static final /* synthetic */ void clearClientChannelTransfer() {
        L.writeLock().lock();
        try {
            c.clear();
            return;
        }
        finally {
            L.writeLock().unlock();
        }
    }

    public /* synthetic */ int getExpRate() {
        World a2;
        return a2.C;
    }

    public /* synthetic */ void setMesoRate(int a2) {
        a.H = a2;
    }

    public static /* synthetic */ void handleFish(MapleCharacter a2, long a3) {
        if (a2.canHiredFish(a3)) {
            a2.doHiredFish();
        }
    }

    public /* synthetic */ void setFlag(byte a2) {
        a.F = a2;
    }

    public static /* synthetic */ void AutoSave(int a2) {
        Timer.EventTimer.getInstance().register(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
                    for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersThreadSafe()) {
                        if (mapleCharacter == null || mapleCharacter.getClient().getLoginState() == 5 || mapleCharacter.getTrade() != null || mapleCharacter.getConversation() > 0 || mapleCharacter.getPlayerShop() != null || mapleCharacter.getMap() == null) continue;
                        mapleCharacter.saveToDB(false, channelServer.getChannel() == -10);
                    }
                }
            }
            {
                2 a2;
            }
        }, a2 * 60 * 1000, a2 * 60 * 1000);
    }

    public static /* synthetic */ int getFishingChannel(MapleCharacter a2) {
        for (ChannelServer channelServer : ChannelServer.getAllChannelInstances()) {
            if (channelServer.getFishingMap(a2) == -1) continue;
            return channelServer.getChannel();
        }
        return -1;
    }

    public static /* synthetic */ List<CheaterData> getCheaters() {
        Iterator<ChannelServer> iterator;
        ArrayList<CheaterData> arrayList = new ArrayList<CheaterData>();
        Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllInstances().iterator();
        while (iterator2.hasNext()) {
            ChannelServer channelServer = iterator.next();
            iterator2 = iterator;
            arrayList.addAll(channelServer.getCheaters());
        }
        Collections.sort(arrayList);
        return CollectionUtil.copyFirst(arrayList, 10);
    }

    public static final /* synthetic */ void removeClientRemove(Integer a2) {
        h.writeLock().lock();
        try {
            G.remove(a2);
            return;
        }
        finally {
            h.writeLock().unlock();
        }
    }

    public static /* synthetic */ void saveServerSet() {
        ServerSet.saveServerSet();
        BanAttackIP.reDumpAtackIp();
        System.out.println(MapleFriendship.ALLATORIxDEMO("\u5dd9\u81f2\u52fe\u4fc5\u5b73\u4f22\u6726\u5670\u6680\u5b40\u8cec\u6581"));
    }

    public static /* synthetic */ boolean isConnected(String a2) {
        return Find.findChannel(a2) > 0;
    }

    public static /* synthetic */ void clearChannelChangeDataByAccountId(int a2) {
        try {
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
                while (iterator2.hasNext()) {
                    Iterator<ChannelServer> iterator3;
                    ChannelServer channelServer = iterator3.next();
                    iterator2 = iterator3;
                    World.getStorage(channelServer.getWorld(), channelServer.getChannel()).deregisterPendingPlayerByAccountId(a2);
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public /* synthetic */ ChannelServer getChannel(int a2) {
        World a3;
        if (a3.ALLATORIxDEMO.isEmpty()) {
            return null;
        }
        for (ChannelServer channelServer : a3.ALLATORIxDEMO) {
            if (channelServer.getChannel() != a2) continue;
            return channelServer;
        }
        return null;
    }

    public /* synthetic */ int getChAmount() {
        World a2;
        return a2.K;
    }

    public static final /* synthetic */ int getChangeChannel(int a2) {
        f.readLock().lock();
        int n2 = 0;
        try {
            if (l.containsKey(a2)) {
                n2 = l.get(a2);
            }
            return n2;
        }
        finally {
            f.readLock().unlock();
        }
    }

    public static /* synthetic */ void addToWheelCache(int a2, int a3) {
        J.put(a2, a3);
    }

    public static /* synthetic */ void handleDeCharacterBuff(MapleMap a2, int a3, int a42, long a5) {
        if (a2.characterSize() > 0) {
            for (MapleCharacter a42 : a2.getCharactersThreadsafe()) {
                for (MapleDiseaseValueHolder mapleDiseaseValueHolder : a42.getAllDiseases()) {
                    if (mapleDiseaseValueHolder == null || mapleDiseaseValueHolder.startTime + mapleDiseaseValueHolder.length >= a5) continue;
                    a42.cancelDeiseaseBuff(mapleDiseaseValueHolder.disease);
                }
                if (!GameSetConstants.CHECK_BUFF || !a42.canCheckBuff()) continue;
                a42.checkBuff();
            }
        }
    }

    public /* synthetic */ void addChannel(ChannelServer a2) {
        World a3;
        a3.ALLATORIxDEMO.add(a2);
    }

    public static /* synthetic */ void ClearMemory(int a2) {
        Timer.EventTimer.getInstance().register(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                System.gc();
                System.out.println("\u7cfb\u7d71\u81ea\u52d5\u91cb\u653e\u8a18\u61b6\u9ad4 ---- " + FileoutputUtil.NowTime());
            }
            {
                4 a2;
            }
        }, a2 * 60 * 1000, a2 * 60 * 1000);
    }

    public static /* synthetic */ int getMerchantMap(MapleCharacter a2) {
        Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
        while (iterator.hasNext()) {
            int n2 = iterator.next().getMerchantMap(a2);
            if (n2 == -1) continue;
            return n2;
        }
        return -1;
    }

    public /* synthetic */ int getDropRate() {
        World a2;
        return a2.e;
    }

    public static /* synthetic */ Map<Integer, Integer> getConnected() {
        Iterator<ChannelServer> iterator;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int n2 = 0;
        Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllInstances().iterator();
        while (iterator2.hasNext()) {
            ChannelServer channelServer = iterator.next();
            iterator2 = iterator;
            int n3 = channelServer.getConnectedClients();
            hashMap.put(channelServer.getChannel(), n3);
            n2 += n3;
        }
        HashMap<Integer, Integer> hashMap2 = hashMap;
        hashMap2.put(0, n2);
        return hashMap2;
    }

    public /* synthetic */ void setDropRate(int a2) {
        a.e = a2;
    }

    public static /* synthetic */ void handleMapPoison(MapleMap a2) {
        if (a2.getMobsSize() > 0) {
            for (MapleMonster mapleMonster : a2.getAllMonstersThreadsafe()) {
                if (mapleMonster.getPoisonTime() < 1000L || mapleMonster.getPoisonDamage() <= 0 || mapleMonster.getPoisonChr() == null) continue;
                int n2 = mapleMonster.getPoisonDamage();
                if ((long)n2 >= mapleMonster.getHp()) {
                    n2 = (int)(mapleMonster.getHp() - 1L);
                }
                if (mapleMonster.getPoisonChr() != null) {
                    int n3 = n2;
                    mapleMonster.getPoisonChr().dropDebugMessage("[\u6301\u7e8c\u50b7\u5bb3] \u602a\u7269:" + mapleMonster.getStats().getName() + "(" + mapleMonster.getObjectId() + ") \u50b7\u5bb3\u503c:" + n3 + " \u5269\u9918HP:" + (mapleMonster.getHp() - (long)n3));
                }
                if (mapleMonster.isAlive() && mapleMonster.getHp() > 1L) {
                    MapleMonster mapleMonster2 = mapleMonster;
                    mapleMonster2.damageFromStat(mapleMonster2.getPoisonChr(), GameSetConstants.POISON_DIE ? (long)mapleMonster.getPoisonDamage() : (long)n2, false, true);
                }
                MapleMonster mapleMonster3 = mapleMonster;
                mapleMonster3.addPoisonTime(-1000);
                if (mapleMonster3.getShadowWeb()) {
                    a2.broadcastMessage(MobPacket.damageMonster(mapleMonster.getObjectId(), n2), mapleMonster.getPosition());
                }
                if (mapleMonster.getPoisonTime() >= 1000L) continue;
                MapleMonster mapleMonster4 = mapleMonster;
                mapleMonster.setPoisonChr(null);
                mapleMonster4.setPoisonTime(0);
                mapleMonster4.setPoisonDamage(0);
                mapleMonster4.resetPoisonRate();
            }
        }
    }

    public /* synthetic */ void setExpRate(int a2) {
        a.C = a2;
    }

    public static final /* synthetic */ void removeClientChannelTransfer(String a2) {
        L.writeLock().lock();
        try {
            c.remove(a2);
            return;
        }
        finally {
            L.writeLock().unlock();
        }
    }

    public /* synthetic */ List<ChannelServer> getChannels() {
        World a2;
        return a2.ALLATORIxDEMO;
    }

    public static final /* synthetic */ void clearChangeChannel() {
        f.writeLock().lock();
        try {
            l.clear();
            return;
        }
        finally {
            f.writeLock().unlock();
        }
    }

    public static final /* synthetic */ void clearClientRemove() {
        h.writeLock().lock();
        try {
            G.clear();
            return;
        }
        finally {
            h.writeLock().unlock();
        }
    }

    public /* synthetic */ String getEventMessage() {
        World a2;
        return a2.a;
    }

    public static final /* synthetic */ boolean inClientChannelTransfer(String a2) {
        L.readLock().lock();
        boolean bl = false;
        try {
            if (c.contains(a2)) {
                bl = true;
            }
            return bl;
        }
        finally {
            L.readLock().unlock();
        }
    }

    public static /* synthetic */ void registerGameLoop() {
        Timer.WorldTimer.getInstance().register(new CharacterBuffHandle(), 1000L);
        Timer.WorldTimer.getInstance().register(new EventsHandle(), GameSetConstants.EVENT_RELOADTIME);
        Timer.WorldTimer.getInstance().register(new CharacterDeBuffHandle(), 1000L);
        Timer.WorldTimer.getInstance().register(new MonsterDropHandle(), 1000L);
        Timer.WorldTimer.getInstance().register(new HandlePoison(), 1000L);
        Timer.WorldTimer.getInstance().register(new Respawn(), 3000L);
        Timer.WorldTimer.getInstance().register(new handleHiredFishs(), 1000L);
        Timer.WorldTimer.getInstance().registerHour(new handleHour(), 1L, 1L);
        Timer.WorldTimer.getInstance().register(new handleServerSet(), 60000L);
        Timer.WorldTimer.getInstance().register(new handleSecond(), 1000L);
        if (GameSetConstants.EXP_CHAIR) {
            Timer.WorldTimer.getInstance().register(new CharacterExpChairHandle(), 10000L);
        }
        if (GameSetConstants.AUTO_SAVE_MERCHANT > 0L) {
            Timer.AutoSaveTimer.getInstance().register(new AutoSaveMerchants(), GameSetConstants.AUTO_SAVE_MERCHANT);
        }
        if (GameSetConstants.MONSTERPET) {
            Timer.MonsterPetTimer.getInstance().register(new MonsterPetHandle(), 1000L);
        }
        if (GameSetConstants.AUTO_SAVE > 0L) {
            Timer.AutoSaveTimer.getInstance().register(new AutoSaveHandle(), 10000L);
        }
    }

    public static /* synthetic */ void init() {
        Find.findChannel(0);
        Guild.ALLATORIxDEMO().toString();
        Alliance.ALLATORIxDEMO().toString();
        Family.ALLATORIxDEMO().toString();
        Messenger.getMessenger(0);
        Party.getParty(0);
    }

    public static final /* synthetic */ void removePlayerSaving(Integer a2) {
        m.writeLock().lock();
        try {
            P.remove(a2);
            return;
        }
        finally {
            m.writeLock().unlock();
        }
    }

    public static final /* synthetic */ boolean needClientRemove(int a2) {
        h.readLock().lock();
        boolean bl = false;
        try {
            if (G.contains(a2)) {
                bl = true;
            }
            return bl;
        }
        finally {
            h.readLock().unlock();
        }
    }

    public static final /* synthetic */ void addChangeChannel(int a2, int a3) {
        f.writeLock().lock();
        try {
            if (l.containsKey(a2)) {
                l.remove(a2);
            }
            l.put(a2, a3);
            return;
        }
        finally {
            f.writeLock().unlock();
        }
    }

    public static /* synthetic */ {
        isShutDown = false;
        isWorldSaving = false;
        P = new ArrayList<Integer>();
        w = new ArrayList<Integer>();
        G = new ArrayList<Integer>();
        b = new ArrayList<String>();
        c = new ArrayList<String>();
        l = new HashMap<Integer, Integer>();
        m = new ReentrantReadWriteLock();
        A = new ReentrantReadWriteLock();
        f = new ReentrantReadWriteLock();
        h = new ReentrantReadWriteLock();
        D = new ReentrantReadWriteLock();
        L = new ReentrantReadWriteLock();
        j = new HashMap<String, Integer>();
        i = new HashMap<String, Long>();
        J = new HashMap<Integer, Integer>();
        M = new PlayerStorage(-1);
    }

    public /* synthetic */ void setCanCreate(boolean a2) {
        a.d = a2;
    }

    public static final /* synthetic */ void clearPlayerSaving() {
        m.writeLock().lock();
        try {
            P.clear();
            return;
        }
        finally {
            m.writeLock().unlock();
        }
    }

    public static /* synthetic */ int getLoginState(String a2) {
        if (!j.containsKey(a2)) {
            return 0;
        }
        return j.get(a2);
    }

    public static /* synthetic */ String getStatus() throws RemoteException {
        Iterator<ChannelServer> iterator;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllInstances().iterator();
        while (iterator2.hasNext()) {
            ChannelServer channelServer = iterator.next();
            iterator2 = iterator;
            stringBuilder.append(donate.ALLATORIxDEMO("\u987d\u9020f"));
            stringBuilder.append(channelServer.getChannel());
            stringBuilder.append(MapleFriendship.ALLATORIxDEMO("\u00118"));
            int n3 = channelServer.getConnectedClients();
            n2 += n3;
            stringBuilder.append(n3);
            stringBuilder.append(donate.ALLATORIxDEMO("f\u5078\u73ef\u5bc5L"));
        }
        StringBuilder stringBuilder2 = stringBuilder;
        stringBuilder2.append(MapleFriendship.ALLATORIxDEMO("\u7e16\u5169\u7df1\u4e12\u4e91\u6560\u00118"));
        stringBuilder.append(n2);
        stringBuilder.append(donate.ALLATORIxDEMO("L"));
        return stringBuilder2.toString();
    }

    public static final /* synthetic */ boolean isPlayerSaving(Integer a2) {
        m.readLock().lock();
        boolean bl = false;
        try {
            bl = P.contains(a2);
            return bl;
        }
        finally {
            m.readLock().unlock();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static /* synthetic */ void handleCooldowns(MapleCharacter a, int a, boolean a) {
        block24: {
            block27: {
                block26: {
                    block25: {
                        var3_3 = System.currentTimeMillis();
                        for (MapleCoolDownValueHolder var6_5 : a.getCooldowns()) {
                            if (var6_5.startTime + var6_5.length >= var3_3) continue;
                            var7_12 = var6_5.skillId;
                            a.removeCooldown(var7_12);
                            a.getClient().sendPacket(MaplePacketCreator.skillCooldown(var7_12, 0));
                        }
                        if (a.getDiseaseSize() > 0) {
                            for (MapleDiseaseValueHolder var6_7 : a.getAllDiseases()) {
                                if (var6_7 == null || var6_7.startTime + var6_7.length >= var3_3) continue;
                                a.cancelDeiseaseBuff(var6_7.disease);
                            }
                        }
                        for (MapleDiseaseValueHolder var6_9 : a.getAllDiseases()) {
                            if (var6_9.startTime + var6_9.length >= var3_3) continue;
                            a.cancelDeiseaseBuff(var6_9.disease);
                        }
                        if (a % 100 == 0) {
                            for (MaplePet var6_11 : a.getSummonedPets()) {
                                if (!var6_11.getSummoned()) continue;
                                if (var6_11.getPetItemId() == 5000054 && var6_11.getSecondsLeft() > 0) {
                                    v0 = var6_11;
                                    v0.setLimitedLife(v0.getSecondsLeft() - 1);
                                    if (v0.getSecondsLeft() <= 0) {
                                        a.unequipPet(var6_11, true);
                                        return;
                                    }
                                }
                                if ((var7_12 = var6_11.getFullness() - PetDataFactory.getHunger(var6_11.getPetItemId())) <= 5) {
                                    v1 = var6_11;
                                    v1.setFullness(15);
                                    a.unequipPet(v1, true);
                                    continue;
                                }
                                var6_11.setFullness(var7_12);
                                v2 = var6_11;
                                a.getClient().sendPacket(PetPacket.updatePet(v2, a.getInventory(MapleInventoryType.CASH).getItem(v2.getInventoryPosition()), true));
                            }
                        }
                        var5_4 = a.getMount();
                        if (a % GameSetConstants.FATIGUE_TIME != 0 || a.getBuffSource(MapleBuffStat.MONSTER_RIDING) != GameConstants.isMonsterRiding(var5_4.getSkillId())) break block24;
                        if (!var5_4.Riding) break block25;
                        if (a == null) break block26;
                        a.dropMessage(5, "\u9a0e\u5bf5\u76ee\u524d\u75b2\u52de\u503c:" + (var5_4.getFatigue() + 1));
                        v3 = var5_4;
                        break block27;
                    }
                    var5_4.Riding = true;
                }
                v3 = var5_4;
            }
            v3.increaseFatigue();
        }
        v4 = a;
        v4.removeExtraSummon();
        if (v4.isAlive() == false) return;
        if (GameSetConstants.ONLINETIME) {
            a.addOnlineSecond();
        }
        if (a.getJob() == 131 || a.getJob() == 132) {
            if (a.canBlood(var3_3)) {
                a.doDragonBlood();
            }
            if (a.canBerserk()) {
                a.doBerserk();
            }
        }
        if (a.canRecover(var3_3)) {
            a.doRecovery();
        }
        if (a.canHPRecover(var3_3)) {
            if (a.getStat().getHealHP() > 0.0f) {
                v5 = a;
                v5.addHP((int)v5.getStat().getHealHP());
            }
            if (a.getStat().getHealHP_Percent() > 0.0f) {
                v6 = a;
                v6.addHP((int)((double)v6.getStat().getCurrentMaxHp() * (1.0 + (double)a.getStat().getHealHP_Percent() / 100.0)));
            }
        }
        if (a.canMPRecover(var3_3)) {
            v7 = a;
            v7.addMP((int)v7.getStat().getHealMP());
        }
        if (a.getJob() >= 200 && a.getJob() <= 232 && a.canInfinity()) {
            a.doInfinity();
        }
        if (WeatherHandler.getWeather() == null || !WeatherHandler.weatherSystem || WeatherHandler.getWeather().getDelay() % a != 0) ** GOTO lbl-1000
        switch (10.ALLATORIxDEMO[WeatherHandler.getWeather().ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                a.healMP((int)(WeatherHandler.getWeather().getChrMp() * (double)a.getMaxMp()), false);
                v8 = a;
                break;
            }
            case 4: 
            case 5: {
                a.healHP((int)(WeatherHandler.getWeather().getChrHp() * (double)a.getMaxHp()), false);
            }
            default: lbl-1000:
            // 2 sources

            {
                v8 = a;
            }
        }
        if (v8 == false) return;
        if (a.getInventory(MapleInventoryType.EQUIPPED).findById(a.getMap().getHPDecProtect()) != null) return;
        if (a.getMapId() == 749040100 && a.getInventory(MapleInventoryType.CASH).findById(5451000) == null) {
            v9 = a;
            v9.addHP(-v9.getMap().getHPDec());
            return;
        }
        if (a.getMapId() == 749040100) return;
        v10 = a;
        v10.addHP(-v10.getMap().getHPDec());
    }

    public static /* synthetic */ boolean hasWheelCache(int a2) {
        return J.containsKey(a2);
    }

    public static /* synthetic */ boolean haveHiredMerchants(int a2) {
        boolean bl = false;
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            for (ChannelServer channelServer : iterator.next().getChannels()) {
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20 || !channelServer.containsMerchant(a2)) continue;
                return true;
            }
        }
        return false;
    }

    public static final /* synthetic */ void removeClientCsTransfer(String a2) {
        D.writeLock().lock();
        try {
            b.remove(a2);
            return;
        }
        finally {
            D.writeLock().unlock();
        }
    }

    public static /* synthetic */ void updateLoginTime(String a2, long a3) {
        if (i.containsKey(a2)) {
            i.remove(a2);
            i.put(a2, a3);
            return;
        }
        i.put(a2, a3);
    }

    public static /* synthetic */ void GamblingShowdown(int a2) {
        Timer.EventTimer.getInstance().registerMin(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                if (GameSetConstants.BACCARAT_SYSTEM) {
                    Baccarat.getInstance().Showdown();
                }
                if (GameSetConstants.NIUNIU_SYSTEM) {
                    NiuNiu.getInstance().Showdown();
                }
                if (GameSetConstants.BLACKJACK_SYSTEM) {
                    BlackJack.getInstance().Showdown();
                }
            }
            {
                9 a2;
            }
        }, a2, 3L);
    }

    public static final /* synthetic */ boolean isChangeChannel(Integer a2) {
        f.readLock().lock();
        boolean bl = false;
        try {
            bl = l.containsKey(a2);
            if (bl) {
                FileoutputUtil.logToFile(MapleFriendship.ALLATORIxDEMO("GwLk\u0004PJ{@7\u892c\u88e5\u0004\u5379\u63f0\u9823\u7650\u517d\u0005lSl"), "\r\n " + FileoutputUtil.NowTime() + "\u5e33\u865fID:" + a2 + " \u5361\u63db\u983b\u767b\u5165");
            }
            return bl;
        }
        finally {
            f.readLock().unlock();
        }
    }

    public static /* synthetic */ void AutoClean(final int a2) {
        Timer.EventTimer.getInstance().register(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                Iterator<World> iterator = LoginServer.getWorlds().iterator();
                while (iterator.hasNext()) {
                    for (ChannelServer channelServer : iterator.next().getChannels()) {
                        1 a22;
                        if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                        MapleMap mapleMap = channelServer.getMapFactory().getMap(a22.a2);
                        mapleMap.killAllMonsters(false);
                        mapleMap.removeDrops();
                    }
                }
            }
            {
                1 a22;
            }
        }, 600000L, 600000L);
    }

    public static /* synthetic */ void removeMerchantByAcId(int a2) {
        Iterator<ChannelServer> iterator;
        Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
        while (iterator2.hasNext()) {
            iterator.next().removeMerchantByAccId(a2);
            iterator2 = iterator;
        }
    }

    public static final /* synthetic */ void addPlayerSaving(Integer a2) {
        m.writeLock().lock();
        try {
            P.add(a2);
            return;
        }
        finally {
            m.writeLock().unlock();
        }
    }

    public static /* synthetic */ boolean hasMerchant(int a2) {
        Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().containsMerchant(a2)) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ void GainNX(int a2) {
        Timer.EventTimer.getInstance().register(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                HashMap<MapleCharacter, Integer> hashMap = new HashMap<MapleCharacter, Integer>();
                int[] arrn = GameSetConstants.ONLINEPOINT;
                Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
                while (iterator.hasNext()) {
                    Iterator<MapleCharacter> iterator2 = iterator.next().getPlayerStorage().getAllCharactersThreadSafe().iterator();
                    while (iterator2.hasNext()) {
                        HashMap<MapleCharacter, Integer> hashMap2;
                        int n2;
                        Iterator<MapleCharacter> iterator3;
                        MapleCharacter mapleCharacter = iterator3.next();
                        if (mapleCharacter == null) {
                            iterator2 = iterator3;
                            continue;
                        }
                        if (!mapleCharacter.isAlive()) {
                            iterator2 = iterator3;
                            continue;
                        }
                        if (GameSetConstants.ONLINEPOINT_MAP.length != 0 && !GameSetConstants.isPointMap(mapleCharacter.getMapId())) {
                            iterator2 = iterator3;
                            continue;
                        }
                        int n3 = arrn[0];
                        if (GameSetConstants.SERVER_NAME.equals(MapleCarnivalChallenge.ALLATORIxDEMO("\u6e74\u83f3\u8c46"))) {
                            n3 = arrn[1];
                        }
                        int n4 = arrn[1] + mapleCharacter.getVip() * 5;
                        int n5 = n2 = GameSetConstants.VIPSYSTEM && GameSetConstants.VIPPOINT && mapleCharacter.isVip() ? Randomizer.rand(n3, n4) : Randomizer.rand(arrn[0], arrn[1]);
                        if (GameSetConstants.SERVER_NAME.equals(MapleExtendedSlots.ALLATORIxDEMO("\u53b7\u53c8\u8c6f"))) {
                            if (mapleCharacter.getLevel() >= 150) {
                                n2 = Randomizer.rand(1, 10);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 120) {
                                n2 = Randomizer.rand(1, 7);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 70) {
                                n2 = Randomizer.rand(1, 5);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 30) {
                                n2 = Randomizer.rand(1, 3);
                                hashMap2 = hashMap;
                            } else {
                                n2 = Randomizer.rand(1, 1);
                                hashMap2 = hashMap;
                            }
                        } else if (GameSetConstants.SERVER_NAME.equals(MapleCarnivalChallenge.ALLATORIxDEMO("\u756d\u5fdf\u8c46"))) {
                            if (mapleCharacter.getLevel() >= 200) {
                                n2 = Randomizer.rand(1, 10);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 150) {
                                n2 = Randomizer.rand(1, 7);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 100) {
                                n2 = Randomizer.rand(1, 5);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 30) {
                                n2 = Randomizer.rand(1, 3);
                                hashMap2 = hashMap;
                            } else {
                                n2 = Randomizer.rand(1, 1);
                                hashMap2 = hashMap;
                            }
                        } else if (GameSetConstants.SERVER_NAME.equals(MapleExtendedSlots.ALLATORIxDEMO("\u6597\u59c6\u59b9\u8c6f"))) {
                            if (mapleCharacter.getLevel() >= 240) {
                                n2 = Randomizer.rand(19, 20);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 230) {
                                n2 = Randomizer.rand(18, 19);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 220) {
                                n2 = Randomizer.rand(17, 18);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 210) {
                                n2 = Randomizer.rand(16, 17);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 200) {
                                n2 = Randomizer.rand(15, 16);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 180) {
                                n2 = Randomizer.rand(13, 15);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 150) {
                                n2 = Randomizer.rand(10, 13);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 120) {
                                n2 = Randomizer.rand(7, 10);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 70) {
                                n2 = Randomizer.rand(5, 7);
                                hashMap2 = hashMap;
                            } else if (mapleCharacter.getLevel() >= 30) {
                                n2 = Randomizer.rand(3, 5);
                                hashMap2 = hashMap;
                            } else {
                                n2 = Randomizer.rand(1, 1);
                                hashMap2 = hashMap;
                            }
                        } else {
                            if (GameSetConstants.SERVER_NAME.equals(MapleCarnivalChallenge.ALLATORIxDEMO("\u6001\u606c\u8c46"))) {
                                n3 = (int)((double)mapleCharacter.getLevel() * 0.2);
                                if (n3 > 40) {
                                    n3 = 40;
                                }
                                n2 = Randomizer.rand(1, n3);
                            }
                            hashMap2 = hashMap;
                        }
                        hashMap2.put(mapleCharacter, n2);
                        iterator2 = iterator3;
                    }
                }
                if (!hashMap.isEmpty()) {
                    MapleCharacter.setMP(hashMap, true);
                }
            }
            {
                3 a2;
            }
        }, a2 * 60 * 1000, a2 * 60 * 1000);
    }

    public static /* synthetic */ long getLoginTime(String a2) {
        if (!i.containsKey(a2)) {
            return 0L;
        }
        return i.get(a2);
    }

    public static /* synthetic */ void registerExtraGame() {
        World.AutoSpawnEventMob();
        World.loadCryptocurrency();
    }

    public static /* synthetic */ void handleCharChairExp(MapleMap a2) {
        if (a2.characterSize() > 0) {
            for (MapleCharacter mapleCharacter : a2.getCharactersThreadsafe()) {
                int n2 = mapleCharacter.getExpChairSelect();
                IItem iItem = mapleCharacter.getInventory(MapleInventoryType.SETUP).findByUniqueId(n2);
                if (iItem == null || mapleCharacter.getChair() != iItem.getItemId() || n2 <= 0) continue;
                if (mapleCharacter.getChairExp(n2) >= 50) {
                    MapleCharacter mapleCharacter2 = mapleCharacter;
                    mapleCharacter2.gainChairExp(n2, -50);
                    mapleCharacter2.gainExp(50, true, false, true);
                    continue;
                }
                if (mapleCharacter.getExpZeroNotice()) continue;
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter3.getClient().sendPacket(MaplePacketCreator.selectExpChair(iItem.getItemId(), n2, 0, true));
                mapleCharacter3.SetExpZeroNotice(true);
            }
        }
    }

    public static /* synthetic */ int getFishingMap(MapleCharacter a2) {
        Iterator<ChannelServer> iterator = ChannelServer.getAllChannelInstances().iterator();
        while (iterator.hasNext()) {
            int n2 = iterator.next().getFishingMap(a2);
            if (n2 == -1) continue;
            return n2;
        }
        return -1;
    }

    public static /* synthetic */ void updateLoginState(String a2, int a3) {
        if (j.containsKey(a2)) {
            j.remove(a2);
            j.put(a2, a3);
            return;
        }
        j.put(a2, a3);
    }

    public static /* synthetic */ void Donate(int a2) {
        System.out.println(donate.ALLATORIxDEMO("\u3063\u81ac\u52a6\u8d4c\u52da\u7cbd\u7d02\u3057\u95f8\u5519"));
        Timer.DonateTimer.getInstance().registerSec(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                donate.Start();
            }
            {
                7 a2;
            }
        }, a2, 3L);
    }

    public static /* synthetic */ void saveHiredMerchants() {
        int n2 = 0;
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            for (ChannelServer channelServer : iterator.next().getChannels()) {
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                n2 += channelServer.SaveUseMerchant();
            }
        }
        System.out.println("\u5df2\u81ea\u52d5\u4fdd\u5b58 " + n2 + " \u500b\u7cbe\u9748\u5546\u4eba\u8cc7\u6599");
    }

    public static /* synthetic */ void checkDiskSpace() {
        Object object = new File("").getAbsolutePath();
        if (((File)(object = new File((String)object))).getFreeSpace() < 50000000000L) {
            System.out.println("\u78c1\u789f\u7a7a\u9593\u4e0d\u8db350GB!\u8acb\u76e1\u5feb\u6e05\u7406! \u5269\u9918\u5927\u5c0f:" + ((File)object).getFreeSpace() + " bytes");
            Broadcast.broadcastGMMessage(MaplePacketCreator.getItemNotice("[\u5371\u96aa\u8b66\u544a] \u78c1\u789f\u7a7a\u9593\u4e0d\u8db350GB!\u8acb\u76e1\u5feb\u6e05\u7406! \u5269\u9918\u5927\u5c0f:" + ((File)object).getFreeSpace() + " bytes"));
        }
    }

    public static /* synthetic */ void scheduleRateDelay(final String a2, long a3) {
        Timer.WorldTimer.getInstance().schedule(new Runnable(){

            @Override
            public /* synthetic */ void run() {
                5 a22;
                String string = a22.a2;
                if (string.equals(CashShopOperation.ALLATORIxDEMO("\u7da5\u9a31"))) {
                    Iterator<ChannelServer> iterator;
                    Iterator<ChannelServer> iterator2 = iterator = ChannelServer.getAllChannelInstances().iterator();
                    while (iterator2.hasNext()) {
                        ChannelServer channelServer = iterator.next();
                        iterator2 = iterator;
                        channelServer.setExExpRate(1);
                    }
                } else if (string.equals(BBSHandler.ALLATORIxDEMO("\u63aa\u5bd5"))) {
                    Iterator<ChannelServer> iterator;
                    Iterator<ChannelServer> iterator3 = iterator = ChannelServer.getAllChannelInstances().iterator();
                    while (iterator3.hasNext()) {
                        ChannelServer channelServer = iterator.next();
                        iterator3 = iterator;
                        channelServer.setExDropRate(1);
                    }
                } else if (string.equals(CashShopOperation.ALLATORIxDEMO("\u6965\u5e05"))) {
                    Iterator<ChannelServer> iterator;
                    Iterator<ChannelServer> iterator4 = iterator = ChannelServer.getAllChannelInstances().iterator();
                    while (iterator4.hasNext()) {
                        ChannelServer channelServer = iterator.next();
                        iterator4 = iterator;
                        channelServer.setExMesoRate(1);
                    }
                }
                Broadcast.broadcastMessage(MaplePacketCreator.getItemNotice(string + "\u96d9\u500d\u6d3b\u52d5\u5df2\u7d93\u7d50\u675f\u3002\u7cfb\u7d71\u5df2\u6210\u529f\u81ea\u52d5\u5207\u63db\u70ba\u6b63\u5e38\u904a\u6232\u6a21\u5f0f\uff01"));
            }
            {
                5 a22;
            }
        }, a3 * 60L * 1000L);
    }

    public static final /* synthetic */ boolean inClientCsTransfer(String a2) {
        D.readLock().lock();
        boolean bl = false;
        try {
            if (b.contains(a2)) {
                bl = true;
            }
            return bl;
        }
        finally {
            D.readLock().unlock();
        }
    }

    public static /* synthetic */ PlayerStorage getStorage(int a2, int a3) {
        return ChannelServer.getInstance(a2, a3).getPlayerStorage();
    }

    public /* synthetic */ void removeChannel(int a2) {
        World a3;
        a3.ALLATORIxDEMO.remove(a2);
    }

    public /* synthetic */ boolean isCanCreate() {
        World a2;
        return a2.d;
    }

    public /* synthetic */ int getWorldId() {
        World a2;
        return a2.I;
    }

    public static /* synthetic */ void loadCryptocurrency() {
        if (GameSetConstants.CRYPTOCURRENCY) {
            System.out.println(donate.ALLATORIxDEMO("\u3063\u52e6\u5bb5\u8cee\u5e10\u7cbd\u7d02\u3057\u552c\u756e"));
            Timer.EventTimer.getInstance().registerMin(new Runnable(){

                @Override
                public /* synthetic */ void run() {
                    try {
                        Cryptocurrency.loadPrize();
                        return;
                    }
                    catch (IOException iOException) {
                        System.out.println("loadCryptocurrency\u932f\u8aa4:" + iOException);
                        return;
                    }
                }
                {
                    8 a2;
                }
            }, 60L, 30L);
        }
    }

    public static final /* synthetic */ void AddClientCsTransfer(String a2) {
        D.writeLock().lock();
        try {
            b.add(a2);
            return;
        }
        finally {
            D.writeLock().unlock();
        }
    }

    public static final /* synthetic */ void AddClientRemove(Integer a2) {
        h.writeLock().lock();
        try {
            G.add(a2);
            return;
        }
        finally {
            h.writeLock().unlock();
        }
    }

    public static final /* synthetic */ void clearClientCsTransfer() {
        D.writeLock().lock();
        try {
            b.clear();
            return;
        }
        finally {
            D.writeLock().unlock();
        }
    }

    public /* synthetic */ int getMesoRate() {
        World a2;
        return a2.H;
    }

    public static /* synthetic */ HiredMerchant getMerchant(int a2) {
        for (ChannelServer channelServer : ChannelServer.getAllChannelInstances()) {
            if (channelServer.getMerchant(a2) == null) continue;
            return channelServer.getMerchant(a2);
        }
        return null;
    }

    public static class Find {
        private static final /* synthetic */ HashMap<Integer, Long> ALLATORIxDEMO;
        private static final /* synthetic */ ReentrantReadWriteLock k;
        private static final /* synthetic */ HashMap<String, Integer> d;
        private static final /* synthetic */ HashMap<Integer, Integer> a;
        private static final /* synthetic */ HashMap<Integer, Integer> K;

        public static /* synthetic */ void registerDisconnect(int a2) {
            k.writeLock().lock();
            try {
                ALLATORIxDEMO.put(a2, System.currentTimeMillis());
                return;
            }
            finally {
                k.writeLock().unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public static /* synthetic */ int findWorld(String a2) {
            int n2;
            int n3;
            block7: {
                n3 = -1;
                n2 = -1;
                k.readLock().lock();
                try {
                    MapleCharacter mapleCharacter = null;
                    Iterator<World> iterator = LoginServer.getWorlds().iterator();
                    while (iterator.hasNext()) {
                        for (ChannelServer channelServer : iterator.next().getChannels()) {
                            mapleCharacter = channelServer.getPlayerStorage().getCharacterByName(a2);
                            if (mapleCharacter == null) continue;
                            ChannelServer channelServer2 = channelServer;
                            n3 = channelServer2.getChannel();
                            n2 = channelServer2.getWorld();
                            break block7;
                        }
                    }
                }
                finally {
                    k.readLock().unlock();
                }
            }
            if (n3 != -1) {
                if (ChannelServer.getInstance(n2, n3) == null) {
                    Find.forceDeregister(a2);
                    return -1;
                }
                return n2;
            }
            return -1;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public static /* synthetic */ int findChannel(String a2) {
            int n2;
            int n3;
            block7: {
                n3 = -1;
                n2 = -1;
                k.readLock().lock();
                try {
                    MapleCharacter mapleCharacter = null;
                    Iterator<World> iterator = LoginServer.getWorlds().iterator();
                    while (iterator.hasNext()) {
                        for (ChannelServer channelServer : iterator.next().getChannels()) {
                            mapleCharacter = channelServer.getPlayerStorage().getCharacterByName(a2);
                            if (mapleCharacter == null) continue;
                            ChannelServer channelServer2 = channelServer;
                            n3 = channelServer2.getChannel();
                            n2 = channelServer2.getWorld();
                            break block7;
                        }
                    }
                }
                finally {
                    k.readLock().unlock();
                }
            }
            if (n3 != -1) {
                if (ChannelServer.getInstance(n2, n3) == null) {
                    Find.forceDeregister(a2);
                    return -1;
                }
                return n3;
            }
            return -1;
        }

        public static /* synthetic */ void register(MapleCharacter a2, int a3, int a4) {
            k.writeLock().lock();
            try {
                K.put(a2.getId(), a3);
                a.put(a2.getId(), a4);
                d.put(a2.getName().toLowerCase(), a3);
                return;
            }
            finally {
                k.writeLock().unlock();
            }
        }

        public static /* synthetic */ CharacterIdChannelPair[] multiBuddyFind(int a2, Collection<Integer> a3) {
            ArrayList<CharacterIdChannelPair> arrayList = new ArrayList<CharacterIdChannelPair>(a3.size());
            for (Integer n2 : a3) {
                Integer n3 = Find.findChannel(n2);
                if (n3 <= 0) continue;
                arrayList.add(new CharacterIdChannelPair(n2, n3));
            }
            ArrayList<CharacterIdChannelPair> arrayList2 = arrayList;
            Collections.sort(arrayList2);
            return arrayList2.toArray(new CharacterIdChannelPair[arrayList2.size()]);
        }

        public static /* synthetic */ void forceDeregisterDisconnect(int a2) {
            k.writeLock().lock();
            try {
                ALLATORIxDEMO.remove(a2);
                return;
            }
            finally {
                k.writeLock().unlock();
            }
        }

        public static /* synthetic */ {
            k = new ReentrantReadWriteLock();
            K = new HashMap();
            a = new HashMap();
            d = new HashMap();
            ALLATORIxDEMO = new HashMap();
        }

        public static /* synthetic */ MapleCharacter findChr(String a2) {
            Integer n2;
            Integer n3;
            Integer n4;
            block3: {
                n4 = null;
                n3 = null;
                MapleCharacter mapleCharacter = null;
                Iterator<World> iterator = LoginServer.getWorlds().iterator();
                while (iterator.hasNext()) {
                    for (ChannelServer channelServer : iterator.next().getChannels()) {
                        mapleCharacter = channelServer.getPlayerStorage().getCharacterByName(a2);
                        if (mapleCharacter == null) continue;
                        ChannelServer channelServer2 = channelServer;
                        n4 = channelServer2.getChannel();
                        n2 = n3 = Integer.valueOf(channelServer2.getWorld());
                        break block3;
                    }
                }
                n2 = n3;
            }
            if (n2 != null && n4 != null) {
                return ChannelServer.getInstance(n3, n4).getPlayerStorage().getCharacterByName(a2);
            }
            return null;
        }

        public static /* synthetic */ int findWorld(int a2) {
            Integer n2;
            Integer n3;
            k.readLock().lock();
            try {
                n3 = K.get(a2);
                n2 = a.get(a2);
            }
            finally {
                k.readLock().unlock();
            }
            if (n3 != null && n2 != null) {
                if (ChannelServer.getInstance(n2, n3) == null) {
                    Find.forceDeregister(a2);
                    return -1;
                }
                return n2;
            }
            return -1;
        }

        public static /* synthetic */ void forceDeregister(int a2, String a3) {
            k.writeLock().lock();
            try {
                a.remove(a2);
                K.remove(a2);
                d.remove(a3.toLowerCase());
                return;
            }
            finally {
                k.writeLock().unlock();
            }
        }

        public static /* synthetic */ int findDisconnect(int a2) {
            Integer n2 = null;
            k.readLock().lock();
            try {
                if (ALLATORIxDEMO.containsKey(a2) && (System.currentTimeMillis() - ALLATORIxDEMO.get(a2)) / 1000L <= 60L) {
                    n2 = a2;
                }
            }
            finally {
                k.readLock().unlock();
            }
            if (n2 != null) {
                return n2;
            }
            return -1;
        }

        public /* synthetic */ Find() {
            Find a2;
        }

        public static /* synthetic */ MapleCharacter findChr(int a2) {
            Integer n2;
            Integer n3;
            k.readLock().lock();
            try {
                n3 = K.get(a2);
                n2 = a.get(a2);
            }
            finally {
                k.readLock().unlock();
            }
            if (n2 != null && n3 != null) {
                return ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterById(a2);
            }
            return null;
        }

        public static /* synthetic */ void forceDeregister(String a2) {
            k.writeLock().lock();
            try {
                d.remove(a2.toLowerCase());
                return;
            }
            finally {
                k.writeLock().unlock();
            }
        }

        public static /* synthetic */ void forceDeregister(int a2) {
            k.writeLock().lock();
            try {
                a.remove(a2);
                K.remove(a2);
                return;
            }
            finally {
                k.writeLock().unlock();
            }
        }

        public static /* synthetic */ int findChannel(int a2) {
            Integer n2;
            Integer n3;
            k.readLock().lock();
            try {
                n3 = K.get(a2);
                n2 = a.get(a2);
            }
            finally {
                k.readLock().unlock();
            }
            if (n3 == null || n2 == null) {
                return -1;
            }
            if (n3 != null) {
                if (ChannelServer.getInstance(n2, n3) == null) {
                    Find.forceDeregister(a2);
                    return -1;
                }
                return n3;
            }
            return -1;
        }
    }

    public static class Guild {
        private static final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;
        private static final /* synthetic */ Map<Integer, MapleGuild> d;

        public static /* synthetic */ {
            d = new LinkedHashMap<Integer, MapleGuild>();
            ALLATORIxDEMO = new ReentrantReadWriteLock();
        }

        public static /* synthetic */ int addBBSThread(int a2, String a3, String a4, int a5, boolean a6, int a7) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.addBBSThread(a3, a4, a5, a6, a7);
            }
            return -1;
        }

        public static /* synthetic */ void deleteGuildCharacter(int a2, int a3) {
            MapleGuildCharacter mapleGuildCharacter;
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null && (mapleGuildCharacter = mapleGuild.getMGC(a3)) != null) {
                if (mapleGuildCharacter.getGuildRank() > 1) {
                    mapleGuild.leaveGuild(mapleGuildCharacter);
                    return;
                }
                mapleGuild.disbandGuild();
            }
        }

        public static /* synthetic */ int getSkillLevel(int a2, int a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.getSkillLevel(a3);
            }
            return 0;
        }

        public static /* synthetic */ void changeRankTitle(int a2, String[] a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.changeRankTitle(a3);
            }
        }

        public static /* synthetic */ int addGuildMember(MapleGuildCharacter a2) {
            return Guild.addGuildMember(a2, true);
        }

        public static /* synthetic */ MapleGuild getGuild(MapleCharacter a2) {
            return Guild.getGuild(a2.getGuildId());
        }

        public static final /* synthetic */ void deleteBBSReply(int a2, int a3, int a4, int a5, int a6) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.deleteBBSReply(a3, a4, a5, a6);
            }
        }

        public static /* synthetic */ int getGuildLeader(String a2) {
            MapleGuild mapleGuild = Guild.getGuildByName(a2);
            if (mapleGuild != null) {
                return mapleGuild.getLeaderId();
            }
            return 0;
        }

        public static /* synthetic */ int getGP(int a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.getGP();
            }
            return 0;
        }

        public static /* synthetic */ MapleGuild getGuild(int a2) {
            MapleGuild mapleGuild;
            if (a2 < 0) {
                return null;
            }
            if (!d.containsKey(a2) && (mapleGuild = MapleGuild.load(a2)) != null) {
                d.put(mapleGuild.getId(), mapleGuild);
            }
            mapleGuild = null;
            ALLATORIxDEMO.readLock().lock();
            try {
                mapleGuild = d.get(a2);
            }
            finally {
                ALLATORIxDEMO.readLock().unlock();
            }
            if (mapleGuild == null) {
                ALLATORIxDEMO.writeLock().lock();
                try {
                    mapleGuild = new MapleGuild(a2);
                    if (mapleGuild.getId() <= 0 || !mapleGuild.isProper()) {
                        MapleGuild mapleGuild2 = null;
                        return mapleGuild2;
                    }
                    d.put(a2, mapleGuild);
                    return mapleGuild;
                }
                finally {
                    ALLATORIxDEMO.writeLock().unlock();
                }
            }
            return mapleGuild;
        }

        public static final /* synthetic */ void editBBSThread(int a2, int a3, String a4, String a5, int a6, int a7, int a8) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.editBBSThread(a3, a4, a5, a6, a7, a8);
            }
        }

        public static /* synthetic */ void guildChat(int a2, String a3, int a4, String a5) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.guildChat(a3, a4, a5);
            }
        }

        public static /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ void setGuildMemberOnline(MapleGuildCharacter a2, boolean a3, int a4) {
            MapleGuild mapleGuild = Guild.getGuild(a2.getGuildId());
            if (mapleGuild != null) {
                mapleGuild.setOnline(a2.getId(), a3, a4);
            }
        }

        public static /* synthetic */ boolean activateSkill(int a2, int a3, String a4) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.activateSkill(a3, a4);
            }
            return false;
        }

        public static /* synthetic */ boolean increaseGuildCapacity(int a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.increaseCapacity();
            }
            return false;
        }

        public static /* synthetic */ boolean purchaseSkill(int a2, int a3, String a4, int a5) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.purchaseSkill(a3, a4, a5);
            }
            return false;
        }

        public static /* synthetic */ void guildPacket(int a2, byte[] a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.broadcast(a3);
            }
        }

        public static final /* synthetic */ void addBBSReply(int a2, int a3, String a4, int a5) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.addBBSReply(a3, a4, a5);
            }
        }

        public static /* synthetic */ void save() {
            System.out.println(ConsoleCommandObject.ALLATORIxDEMO("\u5108\u5b44\u5156\u671f\u8cfd\u6585\u00142\u0014"));
            ALLATORIxDEMO.writeLock().lock();
            try {
                Iterator<MapleGuild> iterator = d.values().iterator();
                while (iterator.hasNext()) {
                    iterator.next().writeToDB(false);
                }
                return;
            }
            finally {
                ALLATORIxDEMO.writeLock().unlock();
            }
        }

        public static /* synthetic */ void setGuildAndRank(int a2, int a3, int a4, int a5) {
            boolean bl;
            int n2 = Find.findChannel(a2);
            int n3 = Find.findWorld(a2);
            if (n2 == -1) {
                return;
            }
            MapleCharacter mapleCharacter = World.getStorage(n3, n2).getCharacterById(a2);
            if (mapleCharacter == null) {
                return;
            }
            if (a3 == -1 && a4 == -1) {
                boolean bl2;
                bl = bl2 = true;
            } else {
                boolean bl3;
                bl = bl3 = a3 != mapleCharacter.getGuildId();
                MapleCharacter mapleCharacter2 = mapleCharacter;
                mapleCharacter.setGuildId(a3);
                mapleCharacter2.setGuildRank((byte)a4);
                mapleCharacter2.setAllianceRank((byte)a5);
                mapleCharacter2.saveGuildStatus();
            }
            if (bl && n2 > 0) {
                MapleCharacter mapleCharacter3 = mapleCharacter;
                mapleCharacter.getMap().broadcastMessage(mapleCharacter3, MaplePacketCreator.removePlayerFromMap(a2), false);
                MapleCharacter mapleCharacter4 = mapleCharacter;
                mapleCharacter3.getMap().broadcastMessage(mapleCharacter4, MaplePacketCreator.spawnPlayerMapobject(mapleCharacter4), false);
            }
        }

        public static /* synthetic */ int addGuildMember(MapleGuildCharacter a2, boolean a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2.getGuildId());
            if (mapleGuild != null) {
                return mapleGuild.addGuildMember(a2, a3);
            }
            return 0;
        }

        public static /* synthetic */ void changeEmblem(int a2, MapleCharacter a3, MapleGuildSummary a4) {
            MapleCharacter mapleCharacter = a3;
            Broadcast.sendGuildPacket(mapleCharacter, MaplePacketCreator.guildEmblemChange(a2, a4.getLogoBG(), a4.getLogoBGColor(), a4.getLogo(), a4.getLogoColor()), -1, a2);
            Guild.setGuildAndRank(mapleCharacter.getId(), -1, -1, -1);
        }

        public static /* synthetic */ void disbandGuild(int a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            ALLATORIxDEMO.writeLock().lock();
            try {
                if (mapleGuild != null) {
                    mapleGuild.disbandGuild();
                    d.remove(a2);
                }
                return;
            }
            finally {
                ALLATORIxDEMO.writeLock().unlock();
            }
        }

        public static /* synthetic */ int createGuild(int a2, String a3) {
            return MapleGuild.createGuild(a2, a3);
        }

        public static /* synthetic */ int getInvitedId(int a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.getInvitedId();
            }
            return 0;
        }

        public static /* synthetic */ void changeRank(int a2, int a3, int a4) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.changeRank(a3, a4);
            }
        }

        public static /* synthetic */ void setInvitedId(int a2, int a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.setInvitedId(a3);
            }
        }

        public static /* synthetic */ List<MapleBBSThread> getBBS(int a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                return mapleGuild.getBBS();
            }
            return null;
        }

        public /* synthetic */ Guild() {
            Guild a2;
        }

        public static /* synthetic */ void setGuildEmblem(int a2, short a3, byte a4, short a5, byte a6) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.setGuildEmblem(a3, a4, a5, a6);
            }
        }

        public static /* synthetic */ void setGuildNotice(int a2, String a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.setGuildNotice(a3);
            }
        }

        public static /* synthetic */ void expelMember(MapleGuildCharacter a2, String a3, int a4) {
            MapleGuild mapleGuild = Guild.getGuild(a2.getGuildId());
            if (mapleGuild != null) {
                mapleGuild.expelMember(a2, a3, a4);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public static /* synthetic */ MapleGuild getGuildByName(String a2) {
            ALLATORIxDEMO.readLock().lock();
            try {
                for (MapleGuild mapleGuild : d.values()) {
                    if (mapleGuild.getName() == null || !mapleGuild.getName().equalsIgnoreCase(a2)) continue;
                    return mapleGuild;
                }
                Iterator<MapleGuild> iterator = null;
                return iterator;
            }
            finally {
                ALLATORIxDEMO.readLock().unlock();
            }
        }

        public static /* synthetic */ void gainGP(int a2, int a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.gainGP(a3);
            }
        }

        public static final /* synthetic */ void deleteBBSThread(int a2, int a3, int a4, int a5) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.deleteBBSThread(a3, a4, a5);
            }
        }

        public static /* synthetic */ void setGuildLeader(int a2, int a3) {
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuild != null) {
                mapleGuild.changeGuildLeader(a3);
            }
        }

        public static /* synthetic */ void memberLevelJobUpdate(MapleGuildCharacter a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2.getGuildId());
            if (mapleGuild != null) {
                mapleGuild.memberLevelJobUpdate(a2);
            }
        }

        public static /* synthetic */ void leaveGuild(MapleGuildCharacter a2) {
            MapleGuild mapleGuild = Guild.getGuild(a2.getGuildId());
            if (mapleGuild != null) {
                mapleGuild.leaveGuild(a2);
            }
        }
    }

    public static class Alliance {
        private static final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;
        private static final /* synthetic */ Map<Integer, MapleGuildAlliance> d;

        public static /* synthetic */ {
            Iterator<MapleGuildAlliance> iterator;
            d = new LinkedHashMap<Integer, MapleGuildAlliance>();
            ALLATORIxDEMO = new ReentrantReadWriteLock();
            System.out.println(PartyHandler.ALLATORIxDEMO("\u3048\u8be3\u538e\u4e4e\u3049C\u001f\u00161\u000f<\"4\u000f1\u00026\u0000=\u0010xYbY"));
            Iterator<MapleGuildAlliance> iterator2 = iterator = MapleGuildAlliance.loadAll().iterator();
            while (iterator2.hasNext()) {
                MapleGuildAlliance mapleGuildAlliance = iterator.next();
                d.put(mapleGuildAlliance.getId(), mapleGuildAlliance);
                iterator2 = iterator;
            }
        }

        public /* synthetic */ Alliance() {
            Alliance a2;
        }

        public static /* synthetic */ void sendGuild(byte[] a2, int a3, int a42) {
            MapleGuildAlliance a42 = Alliance.getAlliance(a42);
            if (a42 != null) {
                int n2;
                int n3 = n2 = 0;
                while (n3 < a42.getNoGuilds()) {
                    int n4 = a42.getGuildId(n2);
                    if (n4 > 0 && n4 != a3) {
                        Guild.guildPacket(n4, a2);
                    }
                    n3 = ++n2;
                }
            }
        }

        public static /* synthetic */ int getAllianceLeader(int a2) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.getLeaderId();
            }
            return 0;
        }

        public static /* synthetic */ boolean changeAllianceLeader(int a2, int a3) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.setLeaderId(a3);
            }
            return false;
        }

        public static /* synthetic */ boolean removeGuildFromAlliance(int a2, int a3, boolean a4) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.removeGuild(a3, a4);
            }
            return false;
        }

        public static /* synthetic */ boolean addGuildToAlliance(int a2, int a3) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.addGuild(a3);
            }
            return false;
        }

        public static /* synthetic */ void sendGuild(int a2) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                MapleGuildAlliance mapleGuildAlliance2 = mapleGuildAlliance;
                Alliance.sendGuild(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance2), -1, a2);
                Alliance.sendGuild(MaplePacketCreator.getGuildAlliance(mapleGuildAlliance2), -1, a2);
            }
        }

        public static /* synthetic */ void updateAllianceNotice(int a2, String a3) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                mapleGuildAlliance.setNotice(a3);
            }
        }

        public static /* synthetic */ boolean canInvite(int a2) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.getCapacity() > mapleGuildAlliance.getNoGuilds();
            }
            return false;
        }

        public static /* synthetic */ void allianceChat(int a2, String a3, int a4, String a5) {
            Serializable serializable = Guild.getGuild(a2);
            if (serializable != null && (serializable = Alliance.getAlliance(((MapleGuild)serializable).getAllianceId())) != null) {
                int n2;
                int n3 = n2 = 0;
                while (n3 < ((MapleGuildAlliance)serializable).getNoGuilds()) {
                    MapleGuild mapleGuild = Guild.getGuild(((MapleGuildAlliance)serializable).getGuildId(n2));
                    if (mapleGuild != null) {
                        mapleGuild.allianceChat(a3, a4, a5);
                    }
                    n3 = ++n2;
                }
            }
        }

        public static /* synthetic */ boolean changeAllianceLeader(int a2, int a3, boolean a4) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.setLeaderId(a3, a4);
            }
            return false;
        }

        public static /* synthetic */ boolean changeAllianceCapacity(int a2) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.setCapacity();
            }
            return false;
        }

        public static /* synthetic */ void setNewAlliance(int a2, int a3) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a3);
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuildAlliance != null && mapleGuild != null) {
                int n2;
                int n3 = n2 = 0;
                while (n3 < mapleGuildAlliance.getNoGuilds()) {
                    if (a2 == mapleGuildAlliance.getGuildId(n2)) {
                        MapleGuild mapleGuild2 = mapleGuild;
                        MapleGuildAlliance mapleGuildAlliance2 = mapleGuildAlliance;
                        MapleGuild mapleGuild3 = mapleGuild;
                        mapleGuild3.setAllianceId(a3);
                        mapleGuild3.broadcast(MaplePacketCreator.getAllianceInfo(mapleGuildAlliance));
                        mapleGuild.broadcast(MaplePacketCreator.getGuildAlliance(mapleGuildAlliance2));
                        mapleGuild2.broadcast(MaplePacketCreator.changeAlliance(mapleGuildAlliance2, true));
                        mapleGuild2.changeARank();
                        mapleGuild2.writeToDB(false);
                    } else {
                        MapleGuild mapleGuild4 = Guild.getGuild(mapleGuildAlliance.getGuildId(n2));
                        if (mapleGuild4 != null) {
                            MapleGuild mapleGuild5 = mapleGuild4;
                            mapleGuild5.broadcast(MaplePacketCreator.addGuildToAlliance(mapleGuildAlliance, mapleGuild));
                            mapleGuild5.broadcast(MaplePacketCreator.changeGuildInAlliance(mapleGuildAlliance, mapleGuild, true));
                        }
                    }
                    n3 = ++n2;
                }
            }
        }

        public static /* synthetic */ boolean disbandAlliance(int a2) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.disband();
            }
            return false;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public static /* synthetic */ void setOldAlliance(int a2, boolean a3, int a4) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a4);
            MapleGuild mapleGuild = Guild.getGuild(a2);
            if (mapleGuildAlliance != null) {
                int n2;
                int n3 = n2 = 0;
                while (n3 < mapleGuildAlliance.getNoGuilds()) {
                    MapleGuild mapleGuild2 = Guild.getGuild(mapleGuildAlliance.getGuildId(n2));
                    if (mapleGuild2 == null) {
                        if (a2 != mapleGuildAlliance.getGuildId(n2)) {
                            mapleGuildAlliance.removeGuild(a2, false, true);
                        }
                    } else if (mapleGuild == null || a2 == mapleGuildAlliance.getGuildId(n2)) {
                        MapleGuild mapleGuild3 = mapleGuild2;
                        mapleGuild3.changeARank(5, false);
                        mapleGuild3.setAllianceId(0);
                        mapleGuild2.broadcast(MaplePacketCreator.disbandAlliance(a4));
                    } else {
                        try {
                            mapleGuild2.broadcast(MaplePacketCreator.getErrorNotice("[" + mapleGuild.getName() + "] \u516c\u6703\u5df2\u9a45\u9010\u51fa\u806f\u76df!"));
                            MapleGuild mapleGuild4 = mapleGuild2;
                            mapleGuild4.broadcast(MaplePacketCreator.changeGuildInAlliance(mapleGuildAlliance, mapleGuild, false));
                            mapleGuild4.broadcast(MaplePacketCreator.removeGuildFromAlliance(mapleGuildAlliance, mapleGuild, a3));
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    n3 = ++n2;
                }
            }
            if (a2 == -1) {
                ALLATORIxDEMO.writeLock().lock();
                try {
                    d.remove(a4);
                    return;
                }
                finally {
                    ALLATORIxDEMO.writeLock().unlock();
                }
            }
        }

        public static /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ MapleGuildAlliance getAlliance(int a2) {
            MapleGuildAlliance mapleGuildAlliance = null;
            ALLATORIxDEMO.readLock().lock();
            try {
                mapleGuildAlliance = d.get(a2);
            }
            finally {
                ALLATORIxDEMO.readLock().unlock();
            }
            if (mapleGuildAlliance == null) {
                ALLATORIxDEMO.writeLock().lock();
                try {
                    mapleGuildAlliance = new MapleGuildAlliance(a2);
                    if (mapleGuildAlliance.getId() <= 0) {
                        MapleGuildAlliance mapleGuildAlliance2 = null;
                        return mapleGuildAlliance2;
                    }
                    d.put(a2, mapleGuildAlliance);
                    return mapleGuildAlliance;
                }
                finally {
                    ALLATORIxDEMO.writeLock().unlock();
                }
            }
            return mapleGuildAlliance;
        }

        public static /* synthetic */ List<byte[]> getAllianceInfo(int a2, boolean a3) {
            ArrayList<byte[]> arrayList = new ArrayList<byte[]>();
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                if (a3) {
                    arrayList.add(MaplePacketCreator.getAllianceInfo(mapleGuildAlliance));
                    arrayList.add(MaplePacketCreator.getGuildAlliance(mapleGuildAlliance));
                }
                arrayList.add(MaplePacketCreator.getAllianceUpdate(mapleGuildAlliance));
            }
            return arrayList;
        }

        public static /* synthetic */ boolean createAlliance(String a2, int a3, int a4, int a52, int a62) {
            a4 = MapleGuildAlliance.createToDb(a3, a2, a52, a62);
            if (a4 <= 0) {
                return false;
            }
            Serializable a52 = Guild.getGuild(a52);
            MapleGuild a62 = Guild.getGuild(a62);
            MapleGuild mapleGuild = a52;
            int n2 = a4;
            mapleGuild.setAllianceId(n2);
            a62.setAllianceId(n2);
            mapleGuild.changeARank(true);
            a62.changeARank(false);
            Serializable serializable = a52 = Alliance.getAlliance(a4);
            Alliance.sendGuild(MaplePacketCreator.createGuildAlliance((MapleGuildAlliance)a52), -1, a4);
            Alliance.sendGuild(MaplePacketCreator.getAllianceInfo((MapleGuildAlliance)serializable), -1, a4);
            Alliance.sendGuild(MaplePacketCreator.getGuildAlliance((MapleGuildAlliance)serializable), -1, a4);
            Alliance.sendGuild(MaplePacketCreator.changeAlliance((MapleGuildAlliance)serializable, true), -1, a4);
            return true;
        }

        public static /* synthetic */ boolean changeAllianceRank(int a2, int a3, int a4) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                return mapleGuildAlliance.changeAllianceRank(a3, a4);
            }
            return false;
        }

        public static /* synthetic */ void updateAllianceRanks(int a2, String[] a3) {
            MapleGuildAlliance mapleGuildAlliance = Alliance.getAlliance(a2);
            if (mapleGuildAlliance != null) {
                mapleGuildAlliance.setRank(a3);
            }
        }

        public static /* synthetic */ void save() {
            System.out.println(MapleExtendedSlots.ALLATORIxDEMO("\u516a\u5b7f\u8037\u76f8\u8c9f\u65bev\tv"));
            ALLATORIxDEMO.writeLock().lock();
            try {
                Iterator<MapleGuildAlliance> iterator = d.values().iterator();
                while (iterator.hasNext()) {
                    iterator.next().saveToDb();
                }
                return;
            }
            finally {
                ALLATORIxDEMO.writeLock().unlock();
            }
        }
    }

    public static class Family {
        private static final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;
        private static final /* synthetic */ Map<Integer, MapleFamily> d;

        public static /* synthetic */ void setFamily(int a2, int a3, int a4, int a5, int a6, int a7, int a82) {
            int n2 = Find.findChannel(a82);
            int n3 = Find.findWorld(a82);
            if (n2 == -1) {
                return;
            }
            MapleCharacter a82 = World.getStorage(n3, n2).getCharacterById(a82);
            if (a82 == null) {
                return;
            }
            n2 = a82.getFamilyId() != a2 || a82.getSeniorId() != a3 || a82.getJunior1() != a4 || a82.getJunior2() != a5 ? 1 : 0;
            MapleCharacter mapleCharacter = a82;
            a82.setFamily(a2, a3, a4, a5);
            mapleCharacter.setCurrentRep(a6);
            mapleCharacter.setTotalRep(a7);
            if (n2 != 0) {
                a82.saveFamilyStatus();
            }
        }

        public static /* synthetic */ MapleFamily getFamily(int a2) {
            MapleFamily mapleFamily;
            if (!d.containsKey(a2) && (mapleFamily = MapleFamily.load(a2)) != null && mapleFamily.isProper()) {
                d.put(mapleFamily.getId(), mapleFamily);
            }
            mapleFamily = null;
            ALLATORIxDEMO.readLock().lock();
            try {
                mapleFamily = d.get(a2);
            }
            finally {
                ALLATORIxDEMO.readLock().unlock();
            }
            if (mapleFamily == null) {
                ALLATORIxDEMO.writeLock().lock();
                try {
                    mapleFamily = new MapleFamily(a2);
                    if (mapleFamily.getId() <= 0 || !mapleFamily.isProper()) {
                        MapleFamily mapleFamily2 = null;
                        return mapleFamily2;
                    }
                    d.put(a2, mapleFamily);
                    return mapleFamily;
                }
                finally {
                    ALLATORIxDEMO.writeLock().unlock();
                }
            }
            return mapleFamily;
        }

        public static /* synthetic */ void setFamilyMemberOnline(MapleFamilyCharacter a2, boolean a3, int a4) {
            MapleFamily mapleFamily = Family.getFamily(a2.getFamilyId());
            if (mapleFamily != null) {
                mapleFamily.setOnline(a2.getId(), a3, a4);
            }
        }

        public static /* synthetic */ void memberFamilyUpdate(MapleFamilyCharacter a2, MapleCharacter a3) {
            MapleFamily mapleFamily = Family.getFamily(a2.getFamilyId());
            if (mapleFamily != null) {
                mapleFamily.memberLevelJobUpdate(a3);
            }
        }

        public static /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO() {
            return ALLATORIxDEMO;
        }

        public static /* synthetic */ void save() {
            System.out.println(MonsterPetSystem.ALLATORIxDEMO("\u5161\u5b00\u5be5\u6597\u8c94\u65c1}v}"));
            ALLATORIxDEMO.writeLock().lock();
            try {
                Iterator<MapleFamily> iterator = d.values().iterator();
                while (iterator.hasNext()) {
                    iterator.next().writeToDB(false);
                }
                return;
            }
            finally {
                ALLATORIxDEMO.writeLock().unlock();
            }
        }

        public static /* synthetic */ void disbandFamily(int a2) {
            MapleFamily mapleFamily = Family.getFamily(a2);
            ALLATORIxDEMO.writeLock().lock();
            try {
                if (mapleFamily != null) {
                    mapleFamily.disbandFamily();
                    d.remove(a2);
                }
                return;
            }
            finally {
                ALLATORIxDEMO.writeLock().unlock();
            }
        }

        public static /* synthetic */ void familyPacket(int a2, byte[] a3, int a4) {
            MapleFamily mapleFamily = Family.getFamily(a2);
            if (mapleFamily != null) {
                MapleFamily mapleFamily2 = mapleFamily;
                mapleFamily2.broadcast(a3, -1, mapleFamily2.getMFC(a4).getPedigree());
            }
        }

        public /* synthetic */ Family() {
            Family a2;
        }

        public static /* synthetic */ int setRep(int a2, int a3, int a4, int a5) {
            MapleFamily mapleFamily = Family.getFamily(a2);
            if (mapleFamily != null) {
                return mapleFamily.setRep(a3, a4, a5);
            }
            return 0;
        }

        public static /* synthetic */ {
            d = new LinkedHashMap<Integer, MapleFamily>();
            ALLATORIxDEMO = new ReentrantReadWriteLock();
        }
    }

    public static class Messenger {
        private static final /* synthetic */ Map<Integer, MapleMessenger> d;
        private static final /* synthetic */ AtomicInteger ALLATORIxDEMO;

        public static /* synthetic */ void silentJoinMessenger(int a2, MapleMessengerCharacter a3) {
            MapleMessenger mapleMessenger = Messenger.d.get(a2);
            if (mapleMessenger == null) {
                throw new IllegalArgumentException(DumpMapName.ALLATORIxDEMO("x<\u0016>S E6X4S!\u0016$_'^sB;SsE#S0_5_6Rs[6E S=Q6D:RsS+_ B "));
            }
            mapleMessenger.silentAddMember(a3);
        }

        public static /* synthetic */ MapleMessenger createMessenger(MapleMessengerCharacter a2) {
            int n2 = ALLATORIxDEMO.getAndIncrement();
            MapleMessenger mapleMessenger = new MapleMessenger(n2, a2);
            d.put(mapleMessenger.getId(), mapleMessenger);
            return mapleMessenger;
        }

        public static /* synthetic */ void messengerChat(int a2, String a3, String a4, String a5) {
            MapleMessenger mapleMessenger = Messenger.d.get(a2);
            if (mapleMessenger == null) {
                throw new IllegalArgumentException(DumpMapName.ALLATORIxDEMO("x<\u0016>S E6X4S!\u0016$_'^sB;SsE#S0_5_6Rs[6E S=Q6D:RsS+_ B "));
            }
            for (MapleMessengerCharacter mapleMessengerCharacter : mapleMessenger.getMembers()) {
                MapleCharacter mapleCharacter;
                int n2;
                int n3;
                if (mapleMessengerCharacter != null && !mapleMessengerCharacter.getName().equals(a5)) {
                    MapleMessengerCharacter mapleMessengerCharacter2 = mapleMessengerCharacter;
                    n3 = Find.findChannel(mapleMessengerCharacter2.getName());
                    n2 = Find.findWorld(mapleMessengerCharacter2.getName());
                    if (n3 <= 0 || (mapleCharacter = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterByName(mapleMessengerCharacter.getName())) == null) continue;
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.messengerChat(a5, a4));
                    continue;
                }
                if (mapleMessengerCharacter == null) continue;
                MapleMessengerCharacter mapleMessengerCharacter3 = mapleMessengerCharacter;
                n3 = Find.findChannel(mapleMessengerCharacter3.getName());
                n2 = Find.findWorld(mapleMessengerCharacter3.getName());
                if (n3 <= 0) continue;
                mapleCharacter = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterByName(mapleMessengerCharacter.getName());
            }
        }

        public static /* synthetic */ void messengerInvite(String a2, int a3, String a4, int a52, boolean a6) {
            if (World.isConnected(a4)) {
                String string = a4;
                int n2 = Find.findChannel(string);
                int n3 = Find.findWorld(string);
                if (n2 > 0) {
                    MapleCharacter a52 = ChannelServer.getInstance(n3, a52).getPlayerStorage().getCharacterByName(a2);
                    MapleCharacter mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(a4);
                    if (a52 != null) {
                        if (mapleCharacter != null && mapleCharacter.getMessenger() == null) {
                            if (!mapleCharacter.isGM() || a6) {
                                mapleCharacter.getClient().sendPacket(MaplePacketCreator.messengerInvite(a2, a3));
                                a52.getClient().sendPacket(MaplePacketCreator.messengerNote(a4, 4, 1));
                                return;
                            }
                            a52.getClient().sendPacket(MaplePacketCreator.messengerNote(a4, 4, 0));
                            return;
                        }
                        a52.getClient().sendPacket(MaplePacketCreator.messengerNote(a2, 5, 0));
                    }
                }
            }
        }

        public static /* synthetic */ void updateMessenger(int a2, String a3, int a4, int a5) {
            MapleMessenger mapleMessenger = Messenger.d.get(a2);
            int n2 = mapleMessenger.getPositionByName(a3);
            for (MapleMessengerCharacter mapleMessengerCharacter : mapleMessenger.getMembers()) {
                MapleCharacter mapleCharacter;
                if (mapleMessengerCharacter == null || mapleMessengerCharacter.getName().equals(a3)) continue;
                MapleMessengerCharacter mapleMessengerCharacter2 = mapleMessengerCharacter;
                int n3 = Find.findChannel(mapleMessengerCharacter2.getName());
                int n4 = Find.findWorld(mapleMessengerCharacter2.getName());
                if (n3 <= 0 || (mapleCharacter = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(mapleMessengerCharacter.getName())) == null) continue;
                MapleCharacter mapleCharacter2 = ChannelServer.getInstance(a4, a5).getPlayerStorage().getCharacterByName(a3);
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.updateMessengerPlayer(a3, mapleCharacter2, n2, a5 - 1));
            }
        }

        public static /* synthetic */ void leaveMessenger(int a2, MapleMessengerCharacter a3) {
            MapleMessenger mapleMessenger = Messenger.d.get(a2);
            if (mapleMessenger == null) {
                throw new IllegalArgumentException(DumpMapName.ALLATORIxDEMO("x<\u0016>S E6X4S!\u0016$_'^sB;SsE#S0_5_6Rs[6E S=Q6D:RsS+_ B "));
            }
            MapleMessenger mapleMessenger2 = mapleMessenger;
            int n2 = mapleMessenger2.getPositionByName(a3.getName());
            mapleMessenger2.removeMember(a3);
            for (MapleMessengerCharacter mapleMessengerCharacter : mapleMessenger.getMembers()) {
                MapleCharacter mapleCharacter;
                if (mapleMessengerCharacter == null) continue;
                MapleMessengerCharacter mapleMessengerCharacter2 = mapleMessengerCharacter;
                int n3 = Find.findChannel(mapleMessengerCharacter2.getId());
                int n4 = Find.findWorld(mapleMessengerCharacter2.getId());
                if (n3 <= 0 || (mapleCharacter = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterByName(mapleMessengerCharacter.getName())) == null) continue;
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.removeMessengerPlayer(n2));
            }
        }

        public static /* synthetic */ {
            d = new HashMap<Integer, MapleMessenger>();
            ALLATORIxDEMO = new AtomicInteger();
            ALLATORIxDEMO.set(1);
        }

        public static /* synthetic */ void silentLeaveMessenger(int a2, MapleMessengerCharacter a3) {
            MapleMessenger mapleMessenger = Messenger.d.get(a2);
            if (mapleMessenger == null) {
                throw new IllegalArgumentException(MTSStorage.ALLATORIxDEMO(".s@q\u0005o\u0013y\u000e{\u0005n@k\th\b<\u0014t\u0005<\u0013l\u0005\u007f\tz\ty\u0004<\ry\u0013o\u0005r\u0007y\u0012u\u0004<\u0005d\to\u0014o"));
            }
            mapleMessenger.silentRemoveMember(a3);
        }

        public /* synthetic */ Messenger() {
            Messenger a2;
        }

        public static /* synthetic */ void joinMessenger(int a2, MapleMessengerCharacter a3, String a4, int a5, int a6) {
            MapleMessenger mapleMessenger = Messenger.d.get(a2);
            if (mapleMessenger == null) {
                throw new IllegalArgumentException(MTSStorage.ALLATORIxDEMO(".s@q\u0005o\u0013y\u000e{\u0005n@k\th\b<\u0014t\u0005<\u0013l\u0005\u007f\tz\ty\u0004<\ry\u0013o\u0005r\u0007y\u0012u\u0004<\u0005d\to\u0014o"));
            }
            MapleMessenger mapleMessenger2 = mapleMessenger;
            mapleMessenger2.addMember(a3);
            int n2 = mapleMessenger2.getPositionByName(a3.getName());
            for (MapleMessengerCharacter mapleMessengerCharacter : mapleMessenger.getMembers()) {
                MapleCharacter mapleCharacter;
                if (mapleMessengerCharacter == null) continue;
                MapleMessengerCharacter mapleMessengerCharacter2 = mapleMessengerCharacter;
                int n3 = mapleMessenger.getPositionByName(mapleMessengerCharacter2.getName());
                int n4 = Find.findChannel(mapleMessengerCharacter.getName());
                int n5 = Find.findWorld(mapleMessengerCharacter2.getName());
                if (n4 <= 0 || a6 <= 0 || (mapleCharacter = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterByName(mapleMessengerCharacter.getName())) == null) continue;
                if (!mapleMessengerCharacter.getName().equals(a4)) {
                    MapleCharacter mapleCharacter2;
                    MapleCharacter mapleCharacter3 = mapleCharacter2 = ChannelServer.getInstance(a5, a6).getPlayerStorage().getCharacterByName(a4);
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.addMessengerPlayer(a4, mapleCharacter3, n2, a6 - 1));
                    mapleCharacter3.getClient().sendPacket(MaplePacketCreator.addMessengerPlayer(mapleCharacter.getName(), mapleCharacter, n3, mapleMessengerCharacter.getChannel() - 1));
                    continue;
                }
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.joinMessenger(n3));
            }
        }

        public static /* synthetic */ void declineChat(String a2, String a3) {
            MapleCharacter mapleCharacter;
            String string = a2;
            int n2 = Find.findChannel(string);
            int n3 = Find.findWorld(string);
            if (n2 > 0 && (mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(a2)) != null && mapleCharacter.getMessenger() != null) {
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.messengerNote(a3, 5, 0));
            }
        }
    }

    public static class Party {
        private static /* synthetic */ Map<Integer, MapleParty> a;
        private static final /* synthetic */ AtomicInteger d;
        private static /* synthetic */ Map<Integer, MapleExpedition> ALLATORIxDEMO;

        public static /* synthetic */ void partyChat(int a2, String a3, String a4) {
            MapleParty mapleParty = Party.a.get(a2);
            if (mapleParty == null) {
                throw new IllegalArgumentException(donate.ALLATORIxDEMO("\u001d)S6\u00124\u0007?S1\u001a2\u001bf\u0007.\u0016f\u00006\u0016%\u001a \u001a#\u0017f\u0003'\u00012\n/\u0017f\u0016>\u001a5\u00075"));
            }
            for (MaplePartyCharacter maplePartyCharacter : mapleParty.getMembers()) {
                MapleCharacter mapleCharacter;
                int n2 = Find.findChannel(maplePartyCharacter.getName());
                int n3 = Find.findWorld(maplePartyCharacter.getName());
                if (n2 <= 0 || (mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(maplePartyCharacter.getName())) == null || mapleCharacter.getName().equalsIgnoreCase(a4)) continue;
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.multiChat(a4, a3, 1));
            }
        }

        public /* synthetic */ Party() {
            Party a2;
        }

        /*
         * Exception decompiling
         */
        public static /* synthetic */ {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 6[TRYBLOCK]
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
             * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
             * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
             * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
             * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
             * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
             * org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:903)
             * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1015)
             * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
             * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
             * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
             * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
             * org.benf.cfr.reader.Main.main(Main.java:49)
             */
            throw new IllegalStateException(Decompilation failed);
        }

        public static /* synthetic */ void updateParty(int a2, PartyOperation a3, MaplePartyCharacter a4) {
            MapleParty mapleParty;
            MapleParty mapleParty2 = Party.a.get(a2);
            if (mapleParty2 == null) {
                return;
            }
            switch (10.a[a3.ordinal()]) {
                case 1: {
                    MapleParty mapleParty3 = mapleParty2;
                    while (false) {
                    }
                    mapleParty = mapleParty3;
                    mapleParty3.addMember(a4);
                    break;
                }
                case 2: 
                case 3: {
                    MapleParty mapleParty4 = mapleParty2;
                    mapleParty = mapleParty4;
                    mapleParty4.removeMember(a4);
                    break;
                }
                case 4: {
                    Party.a.remove(a2);
                    mapleParty = mapleParty2;
                    break;
                }
                case 5: 
                case 6: {
                    MapleParty mapleParty5 = mapleParty2;
                    mapleParty = mapleParty5;
                    mapleParty5.updateMember(a4);
                    break;
                }
                case 7: 
                case 8: {
                    MapleParty mapleParty6 = mapleParty2;
                    mapleParty = mapleParty6;
                    mapleParty6.setLeader(a4);
                    break;
                }
                default: {
                    throw new RuntimeException("Unhandeled updateParty operation " + a3.name());
                }
            }
            for (MaplePartyCharacter maplePartyCharacter : mapleParty.getMembers()) {
                MapleCharacter mapleCharacter;
                MapleCharacter mapleCharacter2;
                int n2 = Find.findChannel(maplePartyCharacter.getName());
                int n3 = Find.findWorld(maplePartyCharacter.getName());
                if (n2 <= 0 || (mapleCharacter2 = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(maplePartyCharacter.getName())) == null) continue;
                if (a3 == PartyOperation.DISBAND) {
                    MapleCharacter mapleCharacter3 = mapleCharacter2;
                    mapleCharacter = mapleCharacter3;
                    mapleCharacter3.setParty(null);
                } else {
                    MapleCharacter mapleCharacter4 = mapleCharacter2;
                    mapleCharacter = mapleCharacter4;
                    mapleCharacter4.setParty(mapleParty2);
                }
                mapleCharacter.getClient().sendPacket(MaplePacketCreator.updateParty(mapleCharacter2.getClient().getChannel(), mapleParty2, a3, a4));
            }
            switch (10.a[a3.ordinal()]) {
                case 2: 
                case 3: {
                    MapleCharacter mapleCharacter;
                    MaplePartyCharacter maplePartyCharacter = a4;
                    while (false) {
                    }
                    int n4 = Find.findChannel(maplePartyCharacter.getName());
                    int n5 = Find.findWorld(maplePartyCharacter.getName());
                    if (n4 <= 0 || (mapleCharacter = ChannelServer.getInstance(n5, n4).getPlayerStorage().getCharacterByName(a4.getName())) == null) break;
                    MapleCharacter mapleCharacter5 = mapleCharacter;
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.updateParty(mapleCharacter5.getClient().getChannel(), mapleParty2, a3, a4));
                    mapleCharacter5.setParty(null);
                }
            }
        }

        public static /* synthetic */ MapleParty createParty(MaplePartyCharacter a2, int a3) {
            Object object = ExpeditionType.getById(a3);
            MapleParty mapleParty = new MapleParty(d.getAndIncrement(), a2);
            a.put(mapleParty.getId(), mapleParty);
            if (object != null) {
                object = new MapleExpedition((ExpeditionType)((Object)object), a2.getId(), mapleParty.getExpeditionId());
                ((MapleExpedition)object).getParties().add(mapleParty.getId());
                ALLATORIxDEMO.put(mapleParty.getExpeditionId(), (MapleExpedition)object);
            }
            return mapleParty;
        }

        public static /* synthetic */ MapleParty createParty(MaplePartyCharacter a2) {
            int n2 = d.getAndIncrement();
            MapleParty mapleParty = new MapleParty(n2, a2);
            a.put(mapleParty.getId(), mapleParty);
            return mapleParty;
        }

        public static /* synthetic */ MapleExpedition getExped(int a2) {
            return ALLATORIxDEMO.get(a2);
        }
    }

    /*
     * Exception performing whole class analysis ignored.
     */
    public static class CharacterBuffHandle
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        @Override
        public synchronized /* synthetic */ void run() {
            CharacterBuffHandle a2;
            long l2 = System.currentTimeMillis();
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    MapleMap mapleMap;
                    Iterator<MapleMap> iterator2;
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Iterator<MapleMap> iterator3 = iterator2 = channelServer.getMapFactory().getAllMapThreadSafe().iterator();
                    while (iterator3.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator3 = iterator2;
                        MapleMap mapleMap2 = mapleMap;
                        World.handleCharacterBuff(mapleMap2, a2.ALLATORIxDEMO, mapleMap2.getCharactersSize(), l2);
                    }
                    iterator2 = channelServer.getMapFactory().getAllInstanceMaps().iterator();
                    Iterator<MapleMap> iterator4 = iterator2;
                    while (iterator4.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator4 = iterator2;
                        MapleMap mapleMap3 = mapleMap;
                        World.handleCharacterBuff(mapleMap3, a2.ALLATORIxDEMO, mapleMap3.getCharactersSize(), l2);
                    }
                }
            }
            ++a2.ALLATORIxDEMO;
        }

        public /* synthetic */ CharacterBuffHandle() {
            CharacterBuffHandle a2;
            a2.ALLATORIxDEMO = 0;
        }
    }

    public static class EventsHandle
    implements Runnable {
        private /* synthetic */ int d;
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ EventsHandle() {
            EventsHandle a2;
            EventsHandle eventsHandle = a2;
            a2.d = 0;
            eventsHandle.ALLATORIxDEMO = 0;
            eventsHandle.d = 0;
        }

        @Override
        public synchronized /* synthetic */ void run() {
            EventsHandle a2;
            try {
                a2.d = 0;
                a2.ALLATORIxDEMO = 0;
                long l2 = System.currentTimeMillis();
                Iterator<World> iterator = LoginServer.getWorlds().iterator();
                while (iterator.hasNext()) {
                    for (ChannelServer channelServer : iterator.next().getChannels()) {
                        Object object;
                        if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20 || (object = channelServer.getEventSM().getAllEventManager()) == null) continue;
                        object = object.iterator();
                        while (object.hasNext()) {
                            Iterator<EventInstanceManager> iterator2 = ((EventManager)object.next()).getInstances().iterator();
                            while (iterator2.hasNext()) {
                                Iterator<EventInstanceManager> iterator3;
                                EventInstanceManager eventInstanceManager = iterator3.next();
                                if (eventInstanceManager.CheckDispose() && eventInstanceManager.disposeIfPlayerBelowCheck((byte)0, 0)) {
                                    ++a2.ALLATORIxDEMO;
                                }
                                ++a2.d;
                                iterator2 = iterator3;
                            }
                        }
                    }
                }
            }
            catch (IOException iOException) {
                Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, iOException);
                return;
            }
            EventsHandle eventsHandle = a2;
            System.out.println("\u76ee\u524d\u6b63\u5728\u9032\u884c\u7684\u526f\u672c\u6578\u76ee: ---- " + eventsHandle.d + " \u500b \u5df2\u7d42\u6b62 " + eventsHandle.ALLATORIxDEMO + " \u500b\u7121\u4eba\u526f\u672c");
            JsoupTool.reloadNews();
        }
    }

    public static class CharacterDeBuffHandle
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ CharacterDeBuffHandle() {
            CharacterDeBuffHandle a2;
            a2.ALLATORIxDEMO = 0;
        }

        @Override
        public synchronized /* synthetic */ void run() {
            long l2 = System.currentTimeMillis();
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    CharacterDeBuffHandle a2;
                    MapleMap mapleMap;
                    Iterator<MapleMap> iterator2;
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Iterator<MapleMap> iterator3 = iterator2 = channelServer.getMapFactory().getAllMapThreadSafe().iterator();
                    while (iterator3.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator3 = iterator2;
                        MapleMap mapleMap2 = mapleMap;
                        World.handleDeCharacterBuff(mapleMap2, a2.ALLATORIxDEMO, mapleMap2.getCharactersSize(), l2);
                    }
                    iterator2 = channelServer.getMapFactory().getAllInstanceMaps().iterator();
                    Iterator<MapleMap> iterator4 = iterator2;
                    while (iterator4.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator4 = iterator2;
                        MapleMap mapleMap3 = mapleMap;
                        World.handleDeCharacterBuff(mapleMap3, a2.ALLATORIxDEMO, mapleMap3.getCharactersSize(), l2);
                    }
                }
            }
        }
    }

    public static class MonsterDropHandle
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        @Override
        public synchronized /* synthetic */ void run() {
            long l2 = System.currentTimeMillis();
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    MonsterDropHandle a2;
                    MapleMap mapleMap;
                    Iterator<MapleMap> iterator2;
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Iterator<MapleMap> iterator3 = iterator2 = channelServer.getMapFactory().getAllMapThreadSafe().iterator();
                    while (iterator3.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator3 = iterator2;
                        MapleMap mapleMap2 = mapleMap;
                        World.handleMonster(mapleMap2, a2.ALLATORIxDEMO, mapleMap2.getCharactersSize(), l2);
                    }
                    iterator2 = channelServer.getMapFactory().getAllInstanceMaps().iterator();
                    Iterator<MapleMap> iterator4 = iterator2;
                    while (iterator4.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator4 = iterator2;
                        MapleMap mapleMap3 = mapleMap;
                        World.handleMonster(mapleMap3, a2.ALLATORIxDEMO, mapleMap3.getCharactersSize(), l2);
                    }
                }
            }
        }

        public /* synthetic */ MonsterDropHandle() {
            MonsterDropHandle a2;
            a2.ALLATORIxDEMO = 0;
        }
    }

    public static class HandlePoison
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ HandlePoison() {
            HandlePoison a2;
            a2.ALLATORIxDEMO = 0;
        }

        @Override
        public /* synthetic */ void run() {
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    MapleMap mapleMap;
                    Iterator<MapleMap> iterator2;
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Collection<MapleMap> collection = channelServer.getMapFactory().getAllMapThreadSafe();
                    Iterator<MapleMap> iterator3 = iterator2 = collection.iterator();
                    while (iterator3.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator3 = iterator2;
                        World.handleMapPoison(mapleMap);
                    }
                    collection = channelServer.getMapFactory().getAllInstanceMaps();
                    iterator2 = collection.iterator();
                    Iterator<MapleMap> iterator4 = iterator2;
                    while (iterator4.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator4 = iterator2;
                        World.handleMapPoison(mapleMap);
                    }
                }
            }
        }
    }

    public static class Respawn
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ Respawn() {
            Respawn a2;
            a2.ALLATORIxDEMO = 0;
        }

        @Override
        public /* synthetic */ void run() {
            Respawn a2;
            ++a2.ALLATORIxDEMO;
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    MapleMap mapleMap;
                    Iterator<MapleMap> iterator2;
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Collection<MapleMap> collection = channelServer.getMapFactory().getAllMapThreadSafe();
                    Iterator<MapleMap> iterator3 = iterator2 = collection.iterator();
                    while (iterator3.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator3 = iterator2;
                        MapleMap mapleMap2 = mapleMap;
                        World.handleMap(mapleMap2, a2.ALLATORIxDEMO, mapleMap2.getCharactersSize());
                    }
                    collection = channelServer.getMapFactory().getAllInstanceMaps();
                    iterator2 = collection.iterator();
                    Iterator<MapleMap> iterator4 = iterator2;
                    while (iterator4.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator4 = iterator2;
                        MapleMap mapleMap3 = mapleMap;
                        World.handleMap(mapleMap3, a2.ALLATORIxDEMO, mapleMap3.getCharactersSize());
                    }
                }
            }
            if (a2.ALLATORIxDEMO % 4800 == 0) {
                MapleMonsterInformationProvider.getInstance().clearDrops();
                ReactorScriptManager.getInstance().clearDrops();
            }
        }
    }

    public static class handleHiredFishs
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ handleHiredFishs() {
            handleHiredFishs a2;
            a2.ALLATORIxDEMO = 0;
        }

        @Override
        public /* synthetic */ void run() {
            handleHiredFishs a2;
            ++a2.ALLATORIxDEMO;
            long l2 = System.currentTimeMillis();
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Iterator<MapleMap> iterator2 = channelServer.getMapFactory().getAllMapThreadSafe().iterator();
                    while (iterator2.hasNext()) {
                        Iterator<MapleMap> iterator3;
                        World.handleFishAction(iterator3.next(), l2);
                        iterator2 = iterator3;
                    }
                }
            }
        }
    }

    public static class handleHour
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        @Override
        public /* synthetic */ void run() {
            handleHour a2;
            if (a2.ALLATORIxDEMO % 5 == 0) {
                CmdExecute.restartExplorer();
            }
            if (a2.ALLATORIxDEMO % GameSetConstants.CYCLE_HOUR == 0 && GameSetConstants.BACKUP_SYSTEM) {
                try {
                    long l2 = System.currentTimeMillis();
                    MysqlBackup.run();
                    MysqlBackup.uploadGoogleDrive();
                    System.out.println("\u5df2\u81ea\u52d5\u96f2\u7aef\u5099\u4efd\u8cc7\u6599\u5eab \u8017\u6642: " + (System.currentTimeMillis() - l2) + " \u6beb\u79d2");
                }
                catch (Exception exception) {
                    try {
                        FileoutputUtil.logToFile(MapleSquad.ALLATORIxDEMO("`zkf#wmvg`|:\u8ccb\u658c\u5ea7\u508c\u4ef1\u933a\u8aa8;xmx"), "\r\n " + FileoutputUtil.NowTime() + " \u5099\u4efd\u5931\u6557\u3002\u932f\u8aa4:" + exception);
                    }
                    catch (Throwable throwable) {
                        FileoutputUtil.logToFile(MapleSquad.ALLATORIxDEMO("`zkf#wmvg`|:\u8ccb\u658c\u5ea7\u508c\u4ef1\u8a0d\u9308;xmx"), "\r\n " + FileoutputUtil.NowTime() + " \u5099\u4efd\u5b8c\u7562\u3002");
                        throw throwable;
                    }
                    FileoutputUtil.logToFile(ConcurrentEnumMap.ALLATORIxDEMO("\u00026\t*A;\u000f:\u0005,\u001ev\u8ca9\u65c0\u5ec5\u50c0\u4e93\u8a41\u936aw\u001a!\u001a"), "\r\n " + FileoutputUtil.NowTime() + " \u5099\u4efd\u5b8c\u7562\u3002");
                }
                FileoutputUtil.logToFile(ConcurrentEnumMap.ALLATORIxDEMO("\u00026\t*A;\u000f:\u0005,\u001ev\u8ca9\u65c0\u5ec5\u50c0\u4e93\u8a41\u936aw\u001a!\u001a"), "\r\n " + FileoutputUtil.NowTime() + " \u5099\u4efd\u5b8c\u7562\u3002");
            }
            MapleRanking.getInstance().ClearAllRank();
            World.checkDiskSpace();
            ++a2.ALLATORIxDEMO;
        }

        public /* synthetic */ handleHour() {
            handleHour a2;
            a2.ALLATORIxDEMO = 0;
        }
    }

    public static class handleServerSet
    implements Runnable {
        @Override
        public /* synthetic */ void run() {
            ServerSet.saveServerSet();
        }

        public /* synthetic */ handleServerSet() {
            handleServerSet a2;
        }
    }

    public static class handleSecond
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        @Override
        public /* synthetic */ void run() {
            handleSecond a2;
            if (GameSetConstants.LOTTORY_DRAW) {
                Date date = new Date();
                if (Lottory.LottoryDate == -1 || Lottory.LottoryDate != FileoutputUtil.YesturdayTimeNumber()) {
                    Object object = Lottory.DrawLottory().toString();
                    if (GameSetConstants.SERVER_NAME.equals(ConsoleCommandObject.ALLATORIxDEMO("\u518a\u82b3\u8c0d"))) {
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("\u4eca\u5929\u6a02\u900f\u5f69\u958b\u734e\u865f\u78bc\u70ba:" + (String)object);
                    object = ChannelServer.getAllChannelInstances().iterator();
                    Object object2 = object;
                    while (object2.hasNext()) {
                        ((ChannelServer)object.next()).setServerMessage(stringBuilder.toString());
                        object2 = object;
                    }
                    Broadcast.broadcastMessage(MaplePacketCreator.serverMessage(stringBuilder.toString()));
                }
            }
            ++a2.ALLATORIxDEMO;
            if (GameSetConstants.AUCTION_SYSTEM) {
                if (a2.ALLATORIxDEMO % 120 == 0) {
                    AuctionItemFactory.getInstance().saveAuctionItem();
                    return;
                }
                if (a2.ALLATORIxDEMO % 3 == 0) {
                    AuctionItemFactory.getInstance().checkActionItems();
                }
            }
        }

        public /* synthetic */ handleSecond() {
            handleSecond a2;
            a2.ALLATORIxDEMO = 0;
        }
    }

    public static class CharacterExpChairHandle
    implements Runnable {
        private /* synthetic */ int ALLATORIxDEMO;

        public /* synthetic */ CharacterExpChairHandle() {
            CharacterExpChairHandle a2;
            a2.ALLATORIxDEMO = 0;
        }

        @Override
        public synchronized /* synthetic */ void run() {
            long l2 = System.currentTimeMillis();
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    MapleMap mapleMap;
                    Iterator<MapleMap> iterator2;
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    Iterator<MapleMap> iterator3 = iterator2 = channelServer.getMapFactory().getAllMapThreadSafe().iterator();
                    while (iterator3.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator3 = iterator2;
                        World.handleCharChairExp(mapleMap);
                    }
                    iterator2 = channelServer.getMapFactory().getAllInstanceMaps().iterator();
                    Iterator<MapleMap> iterator4 = iterator2;
                    while (iterator4.hasNext()) {
                        mapleMap = iterator2.next();
                        iterator4 = iterator2;
                        World.handleCharChairExp(mapleMap);
                    }
                }
            }
        }
    }

    public static class AutoSaveMerchants
    implements Runnable {
        @Override
        public synchronized /* synthetic */ void run() {
            World.saveHiredMerchants();
        }

        public /* synthetic */ AutoSaveMerchants() {
            AutoSaveMerchants a2;
        }
    }

    public static class MonsterPetHandle
    implements Runnable {
        public /* synthetic */ MonsterPetHandle() {
            MonsterPetHandle a2;
        }

        @Override
        public synchronized /* synthetic */ void run() {
            long l2 = System.currentTimeMillis();
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersThreadSafe()) {
                        if (mapleCharacter.getMonsterPet() == null) continue;
                        mapleCharacter.getMonsterPet().doAction();
                    }
                }
            }
        }
    }

    public static class AutoSaveHandle
    implements Runnable {
        @Override
        public synchronized /* synthetic */ void run() {
            int n2 = 0;
            long l2 = System.currentTimeMillis();
            int n3 = 0;
            for (ChannelServer channelServer : ChannelServer.getAllInstances()) {
                for (MapleCharacter mapleCharacter : channelServer.getPlayerStorage().getAllCharactersThreadSafe()) {
                    if (mapleCharacter == null) continue;
                    if (mapleCharacter.getClient().getLoginState() != 5 && mapleCharacter.getTrade() == null && mapleCharacter.getConversation() <= 0 && mapleCharacter.getPlayerShop() == null && mapleCharacter.getMap() != null && l2 - mapleCharacter.getLastSaveTime() > GameSetConstants.AUTO_SAVE) {
                        mapleCharacter.saveToDB(false, channelServer.getChannel() == -10);
                        MapleCharacter mapleCharacter2 = mapleCharacter;
                        ++n2;
                        mapleCharacter2.handleResetDay();
                        mapleCharacter2.dropMessage(BankSystem.ALLATORIxDEMO("\u7c88\u7d06\u5d81\u70cd\u60db\u819d\u52a6\u4faa\u5b2b\u6267\u52ecV"));
                    }
                    ++n3;
                }
            }
        }

        public /* synthetic */ AutoSaveHandle() {
            AutoSaveHandle a2;
        }
    }

    public static class Broadcast {
        public static /* synthetic */ void broadcastMessage(int a2, byte[] a3) {
            for (ChannelServer channelServer : LoginServer.getWorldStatic(a2).getChannels()) {
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                channelServer.broadcastMessage(a3);
            }
        }

        public /* synthetic */ Broadcast() {
            Broadcast a2;
        }

        public static /* synthetic */ void sendGuildPacket(MapleCharacter a2, byte[] a3, int a4, int a5) {
            if (a2 != null && a2.getGuildId() == a5) {
                a2.getClient().sendPacket(a3);
            }
        }

        public static /* synthetic */ void sendPacket(List<Integer> a2, byte[] a3, int a4) {
            Iterator<Integer> iterator = a2.iterator();
            block0: while (true) {
                Iterator<Integer> iterator2 = iterator;
                while (iterator2.hasNext()) {
                    int n2 = iterator.next();
                    if (n2 == a4) {
                        iterator2 = iterator;
                        continue;
                    }
                    int n3 = Find.findChannel(n2);
                    int n4 = Find.findWorld(n2);
                    if (n3 < 0) {
                        iterator2 = iterator;
                        continue;
                    }
                    MapleCharacter mapleCharacter = ChannelServer.getInstance(n4, n3).getPlayerStorage().getCharacterById(n2);
                    if (mapleCharacter == null) continue block0;
                    mapleCharacter.getClient().sendPacket(a3);
                    continue block0;
                }
                break;
            }
        }

        public static /* synthetic */ void broadcastSmega(int a2, byte[] a3) {
            for (ChannelServer channelServer : LoginServer.getInstance().getWorld(a2).getChannels()) {
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                channelServer.broadcastSmega(a3);
            }
        }

        public static /* synthetic */ void sendFamilyPacket(int a2, byte[] a3, int a42, int a5) {
            if (a2 == a42) {
                return;
            }
            a42 = Find.findChannel(a2);
            int n2 = Find.findWorld(a2);
            if (a42 < 0) {
                return;
            }
            MapleCharacter a42 = ChannelServer.getInstance(n2, a42).getPlayerStorage().getCharacterById(a2);
            if (a42 != null && a42.getFamilyId() == a5) {
                a42.getClient().sendPacket(a3);
            }
        }

        public static /* synthetic */ void broadcastGMMessage(byte[] a2) {
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    channelServer.broadcastGMMessage(a2);
                }
            }
        }

        public static /* synthetic */ void broadcastMessage(byte[] a2) {
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    channelServer.broadcastMessage(a2);
                }
            }
        }

        public static /* synthetic */ void sendPacket(int a2, byte[] a3) {
            int n2 = Find.findChannel(a2);
            int n3 = Find.findWorld(a2);
            if (n2 < 0) {
                return;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterById(a2);
            if (mapleCharacter != null) {
                mapleCharacter.getClient().sendPacket(a3);
            }
        }

        public static /* synthetic */ void broadcastGMMessage(int a2, byte[] a3) {
            for (ChannelServer channelServer : LoginServer.getWorldStatic(a2).getChannels()) {
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                channelServer.broadcastGMMessage(a3);
            }
        }

        public static /* synthetic */ void broadcastEtcSmega(int a2, byte[] a3) {
            for (ChannelServer channelServer : LoginServer.getInstance().getWorld(a2).getChannels()) {
                if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                channelServer.broadcastEtcSmega(a3);
            }
        }

        public static /* synthetic */ void broadcastGMMessage(byte[] a2, boolean a3) {
            Iterator<World> iterator = LoginServer.getWorlds().iterator();
            while (iterator.hasNext()) {
                for (ChannelServer channelServer : iterator.next().getChannels()) {
                    if (channelServer.getChannel() == -10 || channelServer.getChannel() == -20) continue;
                    channelServer.broadcastGMMessage(a2, a3);
                }
            }
        }
    }

    public static class Redirector {
        private static final /* synthetic */ Map<String, ClientRedirector> ALLATORIxDEMO;

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ String addRedirector(MapleClient a2) {
            int n2;
            Map.Entry<String, ClientRedirector> entry2;
            for (Map.Entry<String, ClientRedirector> entry2 : ALLATORIxDEMO.entrySet()) {
                if (!entry2.getValue().getAccount().equals(a2.getAccountName())) continue;
                ALLATORIxDEMO.remove(entry2.getKey());
                break;
            }
            Random random = new Random();
            entry2 = "";
            int n3 = n2 = 0;
            while (true) {
                if (n3 >= 200) {
                    ALLATORIxDEMO.put((String)((Object)entry2), new ClientRedirector(a2.getAccountName(), a2.getWorld(), a2.getChannel(), false));
                    return entry2;
                }
                switch (random.nextInt(10)) {
                    case 0: {
                        entry2 = (String)((Object)entry2) + "_";
                        break;
                    }
                    case 1: {
                        entry2 = (String)((Object)entry2) + "~";
                        break;
                    }
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: {
                        int n4 = random.nextInt(2) == 0 ? 65 : 97;
                        entry2 = (String)((Object)entry2) + (char)(random.nextInt(26) + n4);
                        break;
                    }
                    default: {
                        entry2 = (String)((Object)entry2) + String.valueOf(random.nextInt(10));
                    }
                }
                n3 = ++n2;
            }
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new HashMap<String, ClientRedirector>();
        }

        public /* synthetic */ Redirector() {
            Redirector a2;
        }

        public static /* synthetic */ Map<String, ClientRedirector> getRedirectors() {
            return ALLATORIxDEMO;
        }
    }

    public static class Sidekick {
        private static final /* synthetic */ ReentrantReadWriteLock ALLATORIxDEMO;
        private static final /* synthetic */ Map<Integer, MapleSidekick> d;

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public static /* synthetic */ MapleSidekick getSidekickByChr(int a2) {
            ALLATORIxDEMO.readLock().lock();
            try {
                for (MapleSidekick mapleSidekick : d.values()) {
                    if (mapleSidekick.getCharacter(0).getId() != a2 && mapleSidekick.getCharacter(1).getId() != a2) continue;
                    return mapleSidekick;
                }
            }
            finally {
                ALLATORIxDEMO.readLock().unlock();
            }
            return null;
        }

        public static /* synthetic */ MapleSidekick getSidekick(int a2) {
            MapleSidekick mapleSidekick = null;
            ALLATORIxDEMO.readLock().lock();
            try {
                mapleSidekick = d.get(a2);
            }
            finally {
                ALLATORIxDEMO.readLock().unlock();
            }
            if (mapleSidekick == null) {
                ALLATORIxDEMO.writeLock().lock();
                try {
                    mapleSidekick = new MapleSidekick(a2);
                    if (mapleSidekick == null || mapleSidekick.getId() < 0) {
                        MapleSidekick mapleSidekick2 = null;
                        return mapleSidekick2;
                    }
                    d.put(a2, mapleSidekick);
                    return mapleSidekick;
                }
                finally {
                    ALLATORIxDEMO.writeLock().unlock();
                }
            }
            return mapleSidekick;
        }

        public static /* synthetic */ {
            Iterator<MapleSidekick> iterator;
            d = new LinkedHashMap<Integer, MapleSidekick>();
            ALLATORIxDEMO = new ReentrantReadWriteLock();
            Iterator<MapleSidekick> iterator2 = iterator = MapleSidekick.loadAll().iterator();
            while (iterator2.hasNext()) {
                Sidekick.addLoadedSidekick(iterator.next());
                iterator2 = iterator;
            }
        }

        public static /* synthetic */ void addLoadedSidekick(MapleSidekick a2) {
            if (a2.getId() >= 0) {
                d.put(a2.getId(), a2);
            }
        }

        public /* synthetic */ Sidekick() {
            Sidekick a2;
        }

        public static /* synthetic */ int createSidekick(int a2, int a3) {
            return MapleSidekick.create(a2, a3);
        }

        public static /* synthetic */ void erasePlayer(int a2) {
            int n2 = Find.findChannel(a2);
            int n3 = Find.findWorld(a2);
            if (n2 < 0) {
                return;
            }
            MapleCharacter mapleCharacter = ChannelServer.getInstance(n2, n3).getPlayerStorage().getCharacterById(a2);
            if (mapleCharacter != null) {
                mapleCharacter.setSidekick(null);
            }
        }

        public static /* synthetic */ void eraseSidekick(int a2) {
            ALLATORIxDEMO.writeLock().lock();
            try {
                MapleSidekick mapleSidekick = d.remove(a2);
                if (mapleSidekick != null) {
                    MapleSidekick mapleSidekick2 = mapleSidekick;
                    Sidekick.erasePlayer(mapleSidekick2.getCharacter(0).getId());
                    Sidekick.erasePlayer(mapleSidekick2.getCharacter(1).getId());
                }
                return;
            }
            finally {
                ALLATORIxDEMO.writeLock().unlock();
            }
        }
    }

    public static class mysqlBackup
    implements Runnable {
        public /* synthetic */ mysqlBackup() {
            mysqlBackup a2;
        }

        @Override
        public synchronized /* synthetic */ void run() {
        }
    }

    public static class Buddy {
        public static /* synthetic */ void loggedOff(String a2, int a3, int a4, Collection<Integer> a5, int a6, boolean a7) {
            Buddy.ALLATORIxDEMO(a3, a4, a5, true, a6, a7);
        }

        public static /* synthetic */ BuddyList.BuddyAddResult requestBuddyAdd(String a2, int a3, int a4, int a5, String a6, int a7, int a8, int a9) {
            MapleCharacter mapleCharacter;
            String string = a2;
            int n2 = Find.findChannel(string);
            int n3 = Find.findWorld(string);
            if (n2 > 0 && (mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterByName(a2)) != null) {
                BuddyList buddyList = mapleCharacter.getBuddylist();
                if (buddyList.isFull()) {
                    return BuddyList.BuddyAddResult.BUDDYLIST_FULL;
                }
                if (!buddyList.contains(a5)) {
                    buddyList.addBuddyRequest(mapleCharacter.getClient(), a5, a6, a3, a4, a7, a8, a9);
                } else if (buddyList.containsVisible(a5)) {
                    return BuddyList.BuddyAddResult.ALREADY_ON_LIST;
                }
            }
            return BuddyList.BuddyAddResult.OK;
        }

        /*
         * Enabled aggressive block sorting
         */
        public static /* synthetic */ void buddyChanged(int a2, int a3, String a4, int a5, int a6, BuddyList.BuddyOperation a7, int a8, int a9, int a10, String a11) {
            MapleCharacter mapleCharacter;
            int n2 = Find.findChannel(a2);
            int n3 = Find.findWorld(a2);
            if (n2 <= 0 || (mapleCharacter = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterById(a2)) == null) return;
            BuddyList buddyList = mapleCharacter.getBuddylist();
            switch (10.d[a7.ordinal()]) {
                case 1: {
                    if (!buddyList.contains(a3)) return;
                    buddyList.put(new BuddyEntry(a4, a3, a11, a5, a6, true, a8, a9, a10));
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.updateBuddyChannel(a3, a6 - 1));
                    return;
                }
                case 2: {
                    if (!buddyList.contains(a3)) return;
                    buddyList.put(new BuddyEntry(a4, a3, a11, -1, -1, buddyList.get(a3).isVisible(), a8, a9, a10));
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.updateBuddyChannel(a3, -1));
                    return;
                }
            }
        }

        public static /* synthetic */ void loggedOn(String a2, int a3, int a4, Collection<Integer> a5, int a6, boolean a7) {
            Buddy.ALLATORIxDEMO(a3, a4, a5, false, a6, a7);
        }

        private static /* synthetic */ void ALLATORIxDEMO(int a2, int a3, Collection<Integer> a4, boolean a5, int a6, boolean a7) {
            a4 = a4.iterator();
            while (a4.hasNext()) {
                Serializable serializable;
                BuddyEntry buddyEntry;
                Serializable serializable2 = (Integer)a4.next();
                int n2 = Find.findChannel((Integer)serializable2);
                int n3 = Find.findWorld((Integer)serializable2);
                if (n2 <= 0 || (serializable2 = ChannelServer.getInstance(n3, n2).getPlayerStorage().getCharacterById((Integer)serializable2)) == null || (buddyEntry = ((MapleCharacter)serializable2).getBuddylist().get(a2)) == null || !buddyEntry.isVisible()) continue;
                if (a5 || a7 && ((MapleCharacter)serializable2).getGMLevel() < a6) {
                    buddyEntry.setChannel(-1);
                    n3 = -1;
                    serializable = serializable2;
                } else {
                    buddyEntry.setChannel(a3);
                    n3 = a3 - 1;
                    serializable = serializable2;
                }
                ((MapleCharacter)serializable).getBuddylist().put(buddyEntry);
                ((MapleCharacter)serializable2).getClient().sendPacket(MaplePacketCreator.updateBuddyChannel(buddyEntry.getCharacterId(), n3));
            }
        }

        public /* synthetic */ Buddy() {
            Buddy a2;
        }

        public static /* synthetic */ void buddyChat(int[] a2, int a3, String a4, String a5) {
            int n2;
            int[] arrn = a2;
            int n3 = a2.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                MapleCharacter mapleCharacter;
                int n5 = arrn[n2];
                int n6 = Find.findChannel(n5);
                int n7 = Find.findWorld(n5);
                if (n6 > 0 && (mapleCharacter = ChannelServer.getInstance(n7, n6).getPlayerStorage().getCharacterById(n5)) != null && mapleCharacter.getBuddylist().containsVisible(a3)) {
                    mapleCharacter.getClient().sendPacket(MaplePacketCreator.multiChat(a4, a5, 0));
                }
                n4 = ++n2;
            }
        }
    }

    public static class PartySearch {
        private static final /* synthetic */ Map<MapleCharacter, PartySearchInfo> ALLATORIxDEMO;

        public static /* synthetic */ void startSearch(MapleCharacter a2, int a3, int a42, int a5, int a6) {
            if (a2 == null || a2.getMap() == null) {
                return;
            }
            PartySearch.stopSearch(a2);
            ALLATORIxDEMO.put(a2, new PartySearchInfo(a3, a42, a5, a6, null));
            Iterator<MapleCharacter> a42 = a2.getMap().getCharacters().iterator();
            Iterator<MapleCharacter> iterator = a42;
            while (iterator.hasNext()) {
                PartySearch.checkPartySearch(a42.next());
                iterator = a42;
            }
        }

        public static /* synthetic */ void checkPartySearch(MapleCharacter a2) {
            if (a2 == null || a2.getParty() != null) {
                return;
            }
            for (Map.Entry<MapleCharacter, PartySearchInfo> entry : ALLATORIxDEMO.entrySet()) {
                MapleCharacter mapleCharacter = entry.getKey();
                PartySearchInfo object = entry.getValue();
                if (mapleCharacter.getParty() == null || object == null) continue;
                if (mapleCharacter.getParty().getMembers().size() >= object.getMemberNum() || mapleCharacter.getParty().getMembers().size() >= 6) {
                    PartySearch.stopSearch(mapleCharacter);
                    return;
                }
                if (mapleCharacter.getMap() != a2.getMap() || !object.isInLevel(a2.getLevel()) || !object.isAllowJob(a2.getJob())) continue;
                if (mapleCharacter.getParty().getMembers().size() + 1 >= object.getMemberNum() || mapleCharacter.getParty().getMembers().size() >= 6) {
                    PartySearch.stopSearch(mapleCharacter);
                }
                a2.getClient().sendPacket(MaplePacketCreator.partyInvite(mapleCharacter, true));
                return;
            }
        }

        public static /* synthetic */ {
            ALLATORIxDEMO = new HashMap<MapleCharacter, PartySearchInfo>();
        }

        public /* synthetic */ PartySearch() {
            PartySearch a2;
        }

        public static /* synthetic */ void stopSearch(MapleCharacter a2) {
            if (a2 == null) {
                return;
            }
            if (ALLATORIxDEMO.containsKey(a2)) {
                ALLATORIxDEMO.remove(a2);
            }
        }

        public static class PartySearchInfo {
            private final /* synthetic */ int ALLATORIxDEMO;
            private final /* synthetic */ int d;
            private final /* synthetic */ int a;
            private final /* synthetic */ int K;

            public /* synthetic */ PartySearchInfo(int a2, int a3, int a4, int a5, 1 a6) {
                a7(a2, a3, a4, a5);
                PartySearchInfo a7;
            }

            public /* synthetic */ int getMemberNum() {
                PartySearchInfo a2;
                return a2.d;
            }

            private /* synthetic */ PartySearchInfo(int a2, int a3, int a4, int a5) {
                PartySearchInfo a6;
                PartySearchInfo partySearchInfo = a6;
                PartySearchInfo partySearchInfo2 = a6;
                partySearchInfo2.K = a2;
                partySearchInfo2.a = a3;
                partySearchInfo.d = a4;
                partySearchInfo.ALLATORIxDEMO = a5;
            }

            public /* synthetic */ boolean isAllowJob(int a2) {
                PartySearchInfo a3;
                return PartyHandler.PartySearchJob.checkJob(a3.ALLATORIxDEMO, a2);
            }

            public /* synthetic */ boolean isInLevel(int a2) {
                PartySearchInfo a3;
                return a2 >= a3.K && a2 <= a3.a;
            }
        }
    }
}

