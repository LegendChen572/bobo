/*
 * Decompiled with CFR 0.150.
 */
package server;

import FuckingHackerToby.cd;
import client.SkillFactory;
import client.inventory.CheckItemFactory;
import client.messages.CommandProcessor;
import constants.GameSetConstants;
import constants.JobConstants;
import constants.PiPiConfig;
import constants.ServerConfig;
import constants.ServerSet;
import constants.WorldConstants;
import ecpay.EcpayServer;
import handling.RecvPacketOpcode;
import handling.SendPacketOpcode;
import handling.auction.handler.MTSOperation;
import handling.channel.ChannelServer;
import handling.channel.MapleRanking;
import handling.channel.handler.BuddyListHandler;
import handling.login.LoginInformationProvider;
import handling.login.LoginServer;
import handling.opcodes.BuyCashShopType;
import handling.opcodes.CashShopType;
import handling.opcodes.MapleBuffStat;
import handling.opcodes.PlayerInteraction;
import handling.opcodes.SpecialEffect;
import handling.world.SkillCollector;
import handling.world.World;
import handling.world.family.MapleFamilyBuff;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.AutobanManager;
import server.CashItemFactory;
import server.Coupon.Coupon;
import server.Extend.SpecialEquipFactory;
import server.Extend.SpecialItemFactory;
import server.FishingRewardFactory;
import server.ItemMakerFactory;
import server.MTSStorage;
import server.MapleCarnivalFactory;
import server.MapleItemInformationProvider;
import server.PredictCardFactory;
import server.RandomRewards;
import server.ShutdownServer;
import server.SpeedRunner;
import server.Timer;
import server.events.MapleOxQuizFactory;
import server.gashapon.GashaponFactory;
import server.life.MapleLifeFactory;
import server.life.MapleMonsterInformationProvider;
import server.life.PlayerNPC;
import server.maps.Extend.MapNoticeFactory;
import server.maps.MapleMapFactory;
import server.quest.MapleQuest;
import server.swing.WvsCenter;
import tools.damageSkin.AttackFont;
import tools.database.DatabaseCheck;

/*
 * Exception performing whole class analysis ignored.
 */
public class Start {
    private static /* synthetic */ Thread K;
    private static /* synthetic */ Thread d;
    private static /* synthetic */ Thread ALLATORIxDEMO;
    public static /* synthetic */ boolean StartAlready;
    private static /* synthetic */ Thread a;

    public /* synthetic */ Start() {
        Start a2;
    }

    public static /* synthetic */ {
        K = null;
        a = null;
        d = null;
        ALLATORIxDEMO = null;
        StartAlready = false;
    }

    public static final /* synthetic */ void main(String[] a2) {
        System.out.println(BuddyListHandler.ALLATORIxDEMO("0T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019}\u0019W\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aT0T\u001aW\u001aW\u001aW\u001aW\u0019T\u001aT\u001aW\u001aT\u001aW\u001aW\u0019T\u001aT\u0019T\u001aT\u0019T\u001aT\u0019W\u001aT\u0019T\u001aW\u001aW\u001aW\u001aW\u0019}\u0019W\u001aW\u001aW\u001aW\u0019W\u0019W\u0019W\u001aW\u0019W\u001aW\u0019W\u0019W\u001aT\u001aW\u0019W\u0019W\u0019W\u0019W\u001aT\u001aW\u001aW\u001aW\u001aW\u001aT0T\u001aW\u001aW\u001aW\u001aT\u0019T\u001aT\u001aW\u001aT\u001aW\u001aT\u0019T\u001aW\u0019W\u001aT\u001aT\u001aT\u0019W\u001aW\u0019W\u001aW\u001aW\u001aW\u001aW\u0019}\u0019W\u001aW\u001aW\u001aW\u0019W\u0019W\u0019T\u0019W\u0019T\u0019W\u0019W\u0019W\u001aT\u001aW\u0019T\u0019W\u0019W\u0019W\u0019T\u0019W\u001aW\u001aW\u001aW\u001aT0T\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u0019}\u0019Wu\u0015\\\u0002I\u0014[\u0003S\u0018TWX\u000e\u001a6V\u001b[\u0003U\u0005SWu\u0015\\\u0002I\u0014[\u0003U\u0005\u001a\u0001\rY\tW~2w8\u001aT0T\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u0019}\u0019W\u001aW\u001aW\u001aW\u001aW\u001aWR\u0003N\u0007\u0000X\u0015\u0000M\u0000\u0014\u0016V\u001b[\u0003U\u0005SYY\u0018WW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aT0T\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u001aW\u0019}\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T\u0019T0"));
        System.setProperty(MTSOperation.ALLATORIxDEMO("I-U-\r9W%Obb>Q-Z?\r9P)o)D-@5n)Q+F\u001fL>W"), BuddyListHandler.ALLATORIxDEMO("\u0003H\u0002_"));
        if (PiPiConfig.Start_Check) {
            String string;
            String string2 = null;
            try {
                System.out.println(MTSOperation.ALLATORIxDEMO("\u8a87\u8f1b\u5129\u95a8\u6741\u5be5\u78f0\u0019"));
                string = string2 = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }
            catch (Exception exception) {
                System.out.println(exception);
                string = string2;
            }
            if (!PiPiConfig.doCheck(string)) {
                System.exit(0);
                return;
            }
        }
        if (!GameSetConstants.CANUSE) {
            System.out.println(BuddyListHandler.ALLATORIxDEMO("\u302a\u968c\u815c\u63ff\u6b30\u3066\u6716\u4f4d\u6737\u561f\u5c20\u675d\u63b2\u6b7d\u001bz0\u9777\u63b2\u6b7d\u8af1\u8018\u7e51\u7bd6\u743c\u5496\u001b"));
            System.exit(0);
        }
        long l2 = System.currentTimeMillis();
        System.setProperty(MTSOperation.ALLATORIxDEMO("E%O)\r)M/L(J\"D"), BuddyListHandler.ALLATORIxDEMO("O\u0003\\Z\u0002"));
        System.setProperty(MTSOperation.ALLATORIxDEMO("<B8K"), "");
        System.out.println(BuddyListHandler.ALLATORIxDEMO("\u3067\u53ca\u723f\u6969\u4e3c\u8c0d\u6a56\u64d6\u561f\u302b"));
        System.out.println("\u3010\u7248\u672c\u3011 v" + GameSetConstants.MAPLE_VERSION + "." + GameSetConstants.MAPLE_PATCH);
        System.out.println("\u3010\u540d\u7a31\u3011 " + GameSetConstants.SERVER_NAME);
        JobConstants.loadJobLimitLevel();
        if (!GameSetConstants.SERVER_PERMIT) {
            System.err.println(MTSOperation.ALLATORIxDEMO("\u3033\u6b28\u672e\u5c56\u6709\u95c7\u9039\u6741\u52fam\u3032"));
            System.exit(0);
            return;
        }
        Start.ALLATORIxDEMO();
        if (GameSetConstants.ADMIN_ONLY) {
            System.out.println(BuddyListHandler.ALLATORIxDEMO("\u302a\u7bd6\u743c\u5496\u6a1b\u5f78\u302b\u95fc\u5565"));
        } else {
            System.out.println(MTSOperation.ALLATORIxDEMO("\u3033\u7bed\u7425\u54ad\u6a02\u5f43\u3032\u9590\u95aa"));
        }
        if (ServerConfig.AUTO_REGISTER) {
            System.out.println(BuddyListHandler.ALLATORIxDEMO("\u3067\u81d0\u52a2\u8a01\u51fd\u302b\u95fc\u5565"));
        } else {
            System.out.println(MTSOperation.ALLATORIxDEMO("\u305c\u81c9\u5299\u8a18\u51c6\u3032\u9590\u95aa"));
        }
        if (!WorldConstants.GMITEMS) {
            System.out.println(BuddyListHandler.ALLATORIxDEMO("\u302a\u5136\u8a0b\u73de\u5b8c\u4f08\u7512\u7bd6\u743c\u5496\u7253\u54b6\u302b\u95fc\u5565"));
        } else {
            System.out.println(MTSOperation.ALLATORIxDEMO("\u3033\u510d\u8a12\u73e5\u5b95\u4f33\u750b\u7bed\u7425\u54ad\u724a\u548d\u3032\u9590\u95aa"));
        }
        ServerSet.loadServerSet();
        DatabaseCheck.checkAllTable();
        World.init();
        WorldConstants.init();
        Timer.WorldTimer.getInstance().start();
        Timer.EtcTimer.getInstance().start();
        Timer.MapTimer.getInstance().start();
        Timer.MobTimer.getInstance().start();
        Timer.MonsterTimer.getInstance().start();
        Timer.CloneTimer.getInstance().start();
        Timer.EventTimer.getInstance().start();
        Timer.BuffTimer.getInstance().start();
        Timer.TimerManager.getInstance().start();
        Timer.PingTimer.getInstance().start();
        Timer.ChannelTimer.getInstance().start();
        if (GameSetConstants.BACKUP_SYSTEM) {
            Timer.BackupTimer.getInstance().start();
        }
        if (GameSetConstants.DONATE_SYSTEM) {
            Timer.DonateTimer.getInstance().start();
        }
        if (GameSetConstants.MONSTERPET) {
            Timer.MonsterPetTimer.getInstance().start();
        }
        if (GameSetConstants.AUTO_SAVE > 0L || GameSetConstants.AUTO_SAVE_MERCHANT > 0L) {
            Timer.AutoSaveTimer.getInstance().start();
        }
        LoginInformationProvider.getInstance();
        FishingRewardFactory.getInstance();
        MapleQuest.initQuests(false);
        MapleLifeFactory.loadQuestCounts(false);
        MapleLifeFactory.loadNpcNames();
        MapleOxQuizFactory.getInstance().initialize();
        if (GameSetConstants.LOAD_MAPNAME) {
            MapleItemInformationProvider.getInstance().loadAllMapName();
        }
        if (GameSetConstants.LOAD_MOBNAME) {
            MapleMonsterInformationProvider.getInstance().loadAllMobName();
        }
        MapleItemInformationProvider.getInstance().loadEtc(false);
        if (GameSetConstants.SPECIAL_EQUIP) {
            SpecialEquipFactory.getInstance().loadSpecialEquip();
        }
        if (GameSetConstants.SPECIAL_ITEM) {
            SpecialItemFactory.getInstance().loadSpecialItem();
        }
        if (GameSetConstants.MAPNOTICE) {
            MapNoticeFactory.getInstance().loadMapNotice();
        }
        if (!WvsCenter.loaditem) {
            MapleItemInformationProvider.getInstance().loadItems(false);
            WvsCenter.loaditem = true;
        }
        ItemMakerFactory.getInstance();
        MapleLifeFactory.loadMoveNpc();
        PredictCardFactory.getInstance().initialize();
        CashItemFactory.getInstance().initialize(false, true);
        RandomRewards.getInstance();
        SkillFactory.LoadSkillInformaion(false);
        SkillCollector.getInstance().init();
        MapleCarnivalFactory.getInstance();
        MapleRanking.getInstance().reloadAllRank();
        GashaponFactory.getInstance().reloadGashapons();
        Coupon.getInstance().reloadItems();
        MapleFamilyBuff.getBuffEntry();
        LoginServer.setup();
        if (GameSetConstants.AUCTION_SERVER) {
            MTSStorage.load();
        }
        Timer.CheatTimer.getInstance().register(AutobanManager.getInstance(), 60000L);
        Runtime.getRuntime().addShutdownHook(new Thread(ShutdownServer.getInstance()));
        SpeedRunner.getInstance().loadSpeedRuns();
        LoginServer.setOn();
        MapleMapFactory.loadCustomLife();
        World.GainNX(GameSetConstants.ONLINEPOINT[2]);
        PlayerNPC.loadAll();
        if (GameSetConstants.DONATE_SYSTEM) {
            World.Donate(10);
        }
        if (GameSetConstants.SHUTDOWN_PROTECT) {
            World.isShutDown = true;
        }
        if (GameSetConstants.BACCARAT_SYSTEM || GameSetConstants.NIUNIU_SYSTEM || GameSetConstants.BLACKJACK_SYSTEM) {
            d = new Thread(){

                @Override
                public /* synthetic */ void run() {
                    World.GamblingShowdown(1);
                }
                {
                    1 a2;
                }
            };
            d.start();
        }
        a = new Thread(){
            {
                2 a2;
            }

            @Override
            public /* synthetic */ void run() {
                PlayerInteraction.reloadValues();
                CashShopType.reloadValues();
                BuyCashShopType.reloadValues();
                SpecialEffect.reloadValues();
                SendPacketOpcode.reloadValues();
                RecvPacketOpcode.reloadValues();
                MapleBuffStat.reloadValues();
            }
        };
        a.start();
        World.registerExtraGame();
        World.registerGameLoop();
        Iterator<World> iterator = LoginServer.getWorlds().iterator();
        while (iterator.hasNext()) {
            Iterator<ChannelServer> iterator2 = iterator.next().getChannels().iterator();
            while (iterator2.hasNext()) {
                Iterator<ChannelServer> iterator3;
                iterator3.next().registerGameLoop();
                iterator2 = iterator3;
            }
        }
        if (GameSetConstants.ECPAY_SYSTEM) {
            EcpayServer.SocketServer.StartServer();
        }
        System.out.println(BuddyListHandler.ALLATORIxDEMO("\u302a\u79f6\u6b58\u73de\u5b8c\u4f08\u7512M\u5565\u52a2\u001a\u59f5\u67a6\u89f6\u95b1\u6549\u8af10w\u4e7d\u7de0\u6224\u0000V\u79bb\u6b15\u7393\u5bc1\u4f45\u755f\u302b"));
        System.out.println(MTSOperation.ALLATORIxDEMO("\u3033\u4f76\u672e\u5624\u95a8\u5513\u5baf\u752e\u3032"));
        CheckItemFactory.loadItemFromDB();
        AttackFont.LoadAllFont();
        long l3 = System.currentTimeMillis() - l2;
        long l4 = l3 / 1000L;
        l2 = l3 % 1000L;
        System.out.println("\u3010\u8017\u6642: " + l4 + "\u79d2" + l2 + "\u6beb\u79d2\u3011");
        if (GameSetConstants.LINEBOT) {
            cd.ALLATORIxDEMO();
        }
        StartAlready = true;
        GameSetConstants.SystemShow();
        try {
            Thread.sleep(2000L);
        }
        catch (InterruptedException interruptedException) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, interruptedException);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (GameSetConstants.CANUSE_CONSOLE_COMMAND) {
            try {
                System.out.print(BuddyListHandler.ALLATORIxDEMO("I\u0004"));
                String string = bufferedReader.readLine();
                if (string.equals("")) continue;
                CommandProcessor.processCommand(string);
            }
            catch (IOException iOException) {
            }
            catch (Exception exception) {}
        }
    }

    /*
     * Exception decompiling
     */
    private static /* synthetic */ void ALLATORIxDEMO() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 5[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1030)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }
}

