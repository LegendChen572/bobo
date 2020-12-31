/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package handling.world.guild;

import client.MapleCharacter;
import client.MapleCharacterUtil;
import client.MapleClient;
import client.SkillFactory;
import client.messages.commands.InternCommand;
import client.messages.commands.PracticerCommand;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.GameConstants;
import constants.GameSetConstants;
import constants.MobConstants;
import database.DBConPool;
import handling.channel.handler.AllianceHandler;
import handling.world.World;
import handling.world.guild.MapleBBSThread;
import handling.world.guild.MapleGuildCharacter;
import handling.world.guild.MapleGuildResponse;
import handling.world.guild.MapleGuildSkill;
import handling.world.guild.MapleGuildSummary;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import server.MapleStatEffect;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.MaplePacketCreator;
import tools.Pair;
import tools.data.MaplePacketLittleEndianWriter;
import tools.packet.UIPacket;

/*
 * Exception performing whole class analysis ignored.
 */
public class MapleGuild
implements Serializable {
    private final /* synthetic */ Lock E;
    private final /* synthetic */ Map<Integer, MapleGuildSkill> G;
    private /* synthetic */ int l;
    private final /* synthetic */ ReentrantReadWriteLock e;
    private /* synthetic */ boolean I;
    private /* synthetic */ List<Pair<Integer, String>> a;
    private final /* synthetic */ Lock g;
    private /* synthetic */ List<MapleGuildCharacter> P;
    private /* synthetic */ String b;
    private /* synthetic */ int F;
    private /* synthetic */ int i;
    private final /* synthetic */ Map<Integer, MapleBBSThread> H;
    private /* synthetic */ int f;
    private /* synthetic */ String c;
    private /* synthetic */ int j;
    private /* synthetic */ int L;
    private /* synthetic */ boolean ALLATORIxDEMO;
    private /* synthetic */ long K;
    private final /* synthetic */ String[] w;
    private /* synthetic */ boolean d;
    private /* synthetic */ boolean M;
    private /* synthetic */ int C;
    public static final /* synthetic */ long serialVersionUID = 6322150443228168192L;
    private /* synthetic */ boolean B;
    private /* synthetic */ int D;
    private /* synthetic */ int J;
    private /* synthetic */ int A;
    private /* synthetic */ int m;
    private /* synthetic */ int h;
    private /* synthetic */ long k;

    public final /* synthetic */ int addGuildMember(MapleGuildCharacter a2) {
        MapleGuild a3;
        return a3.addGuildMember(a2, true);
    }

    public final /* synthetic */ void setGuildNotice(String a2) {
        MapleGuild a3;
        MapleGuild mapleGuild = a3;
        mapleGuild.c = a2;
        mapleGuild.broadcast(MaplePacketCreator.guildNotice(mapleGuild.l, a2));
    }

    public /* synthetic */ boolean hasSkill(int a2) {
        MapleGuild a3;
        return a3.G.containsKey(a2);
    }

    public final /* synthetic */ String getName() {
        MapleGuild a2;
        return a2.b;
    }

    public final /* synthetic */ void changeARank(int a2, int a3, boolean a4) {
        MapleGuild a5;
        if (a5.F <= 0) {
            return;
        }
        for (MapleGuildCharacter mapleGuildCharacter : a5.P) {
            MapleGuildCharacter mapleGuildCharacter2;
            if (a2 != mapleGuildCharacter.getId()) continue;
            if (mapleGuildCharacter.isOnline()) {
                World.Guild.setGuildAndRank(a2, a5.l, mapleGuildCharacter.getGuildRank(), a3);
                mapleGuildCharacter2 = mapleGuildCharacter;
            } else {
                MapleGuild.saveCharacterGuildInfo((short)a5.l, mapleGuildCharacter.getGuildRank(), (byte)a3, a2);
                mapleGuildCharacter2 = mapleGuildCharacter;
            }
            mapleGuildCharacter2.setAllianceRank((byte)a3);
            if (a4) {
                World.Alliance.sendGuild(a5.F);
            }
            return;
        }
        System.err.println("INFO: unable to find the correct id for changeRank({" + a2 + "}, {" + a3 + "})");
    }

    public final /* synthetic */ void changeARank(int a2, int a3) {
        MapleGuild a4;
        a4.changeARank(a2, a3, true);
    }

    /*
     * Exception decompiling
     */
    public static final /* synthetic */ Collection<MapleGuild> loadAll() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 6[TRYBLOCK]
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

    public final /* synthetic */ int getSignature() {
        MapleGuild a2;
        return a2.i;
    }

    public /* synthetic */ void setInvitedId(int a2) {
        a.C = a2;
    }

    public final /* synthetic */ boolean changeRank(int a2, int a3) {
        MapleGuild a4;
        for (MapleGuildCharacter mapleGuildCharacter : a4.P) {
            MapleGuildCharacter mapleGuildCharacter2;
            if (a2 != mapleGuildCharacter.getId()) continue;
            if (mapleGuildCharacter.isOnline()) {
                World.Guild.setGuildAndRank(a2, a4.l, a3, mapleGuildCharacter.getAllianceRank());
                mapleGuildCharacter2 = mapleGuildCharacter;
            } else {
                MapleGuild.saveCharacterGuildInfo((short)a4.l, (byte)a3, mapleGuildCharacter.getAllianceRank(), a2);
                mapleGuildCharacter2 = mapleGuildCharacter;
            }
            mapleGuildCharacter2.setGuildRank((byte)a3);
            a4.broadcast(MaplePacketCreator.changeRank(mapleGuildCharacter));
            return true;
        }
        System.err.println("INFO: unable to find the correct id for changeRank({" + a2 + "}, {" + a3 + "})");
        return false;
    }

    public final /* synthetic */ String getRankTitle(int a2) {
        MapleGuild a3;
        return a3.w[a2 - 1];
    }

    public final /* synthetic */ int getLogoBG() {
        MapleGuild a2;
        return a2.L;
    }

    public final /* synthetic */ int addBBSThread(String a2, String a3, int a4, boolean a5, int a6) {
        MapleGuild a7;
        int n2 = a7.H.get(0) == null ? 1 : 0;
        a5 = a5 != 0 ? 0 : Math.max(1, a7.H.size() + n2);
        a7.d = true;
        int n3 = a5;
        a7.H.put(n3, new MapleBBSThread(a5, a2, a3, System.currentTimeMillis(), a7.l, a6, a4));
        return n3;
    }

    public /* synthetic */ boolean activateSkill(int a2, String a3) {
        MapleGuild a4;
        if (!a4.G.containsKey(a2)) {
            return false;
        }
        MapleGuildSkill mapleGuildSkill = a4.G.get(a2);
        MapleStatEffect mapleStatEffect = SkillFactory.getSkill(a2).getEffect(mapleGuildSkill.level);
        if (mapleGuildSkill.timestamp > System.currentTimeMillis() || mapleStatEffect.getPeriod() <= 0) {
            return false;
        }
        mapleGuildSkill.timestamp = System.currentTimeMillis() + (long)mapleStatEffect.getPeriod() * 60000L;
        mapleGuildSkill.activator = a3;
        MapleGuild mapleGuild = a4;
        MapleGuildSkill mapleGuildSkill2 = mapleGuildSkill;
        mapleGuild.broadcast(MaplePacketCreator.guildSkillPurchased(mapleGuild.l, a2, mapleGuildSkill2.level, mapleGuildSkill2.timestamp, mapleGuildSkill.purchaser, a3));
        return true;
    }

    public final /* synthetic */ void changeARank() {
        MapleGuild a2;
        a2.changeARank(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final /* synthetic */ int createGuild(int a2, String a32222) {
        if (a32222.length() > 12) {
            return 0;
        }
        try {
            ResultSet resultSet;
            PreparedStatement preparedStatement;
            DruidPooledConnection druidPooledConnection;
            block11: {
                int n2;
                druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
                try {
                    preparedStatement = druidPooledConnection.prepareStatement(PracticerCommand.ALLATORIxDEMO("(B7B8S[`\u000en\u0017c\u0012c[A)H6'\u001cr\u0012k\u001ft[P3B)B[i\u001aj\u001e'F'D"));
                    preparedStatement.setString(1, a32222);
                    resultSet = preparedStatement.executeQuery();
                    if (!resultSet.first()) break block11;
                    resultSet.close();
                    preparedStatement.close();
                    n2 = 0;
                    if (druidPooledConnection == null) return n2;
                }
                catch (Throwable throwable) {
                    Throwable throwable2;
                    if (druidPooledConnection != null) {
                        try {
                            druidPooledConnection.close();
                            throwable2 = throwable;
                            throw throwable2;
                        }
                        catch (Throwable throwable3) {
                            throwable.addSuppressed(throwable3);
                        }
                    }
                    throwable2 = throwable;
                    throw throwable2;
                }
                druidPooledConnection.close();
                return n2;
            }
            preparedStatement.close();
            resultSet.close();
            PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(MobConstants.ALLATORIxDEMO("KzQqP`\"}L`M\u0014eAkXfG\"\u001cbXgUfQpT.\u0014bZcYgT.\u0014bGkSlUvApQb\u0018\"TcXn]cZaQb\u001d\"bCxWqQ\u0014*\u000b.\u0014=\u0018\"\u000b.\u00142\u001d"), 1);
            preparedStatement.setInt(1, a2);
            preparedStatement2.setString(2, a32222);
            preparedStatement2.setInt(3, (int)(System.currentTimeMillis() / 1000L));
            preparedStatement2.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            int n3 = 0;
            if (resultSet.next()) {
                n3 = resultSet.getInt(1);
            }
            resultSet.close();
            preparedStatement.close();
            int a32222 = n3;
            if (druidPooledConnection == null) return a32222;
            druidPooledConnection.close();
            return a32222;
        }
        catch (SQLException sQLException) {
            System.err.println(PracticerCommand.ALLATORIxDEMO("(V7'/O)H,"));
            FilePrinter.printError(MobConstants.ALLATORIxDEMO("\u5158\u6701\u76b0\u932d\u8a90,@z@"), sQLException, PracticerCommand.ALLATORIxDEMO("\u0018u\u001ef\u000fb<r\u0012k\u001f'\u001eu\th\t"));
            return 0;
        }
    }

    public /* synthetic */ int getGuildRank(int a2, int a3) {
        MapleGuild a4;
        MapleGuild mapleGuild = a4;
        long l2 = mapleGuild.getGuildMeso();
        long l3 = mapleGuild.getGuildPoints();
        int n2 = 0;
        if ((a2 = (int)(l2 / (long)a2)) > (a3 = (int)(l3 / (long)a3))) {
            n2 = a3;
            return n2;
        }
        n2 = a2;
        return n2;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ boolean increaseCapacity() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
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

    public final /* synthetic */ void setOnline(int a2, boolean a3, int a4) {
        boolean bl;
        MapleGuild a5;
        block4: {
            boolean bl2 = true;
            for (MapleGuildCharacter mapleGuildCharacter : a5.P) {
                if (mapleGuildCharacter.getGuildId() != a5.l || mapleGuildCharacter.getId() != a2) continue;
                if (mapleGuildCharacter.isOnline() == a3) {
                    bl2 = false;
                }
                mapleGuildCharacter.setOnline(a3);
                mapleGuildCharacter.setChannel((byte)a4);
                bl = bl2;
                break block4;
            }
            bl = bl2;
        }
        if (bl) {
            MapleGuild mapleGuild = a5;
            mapleGuild.broadcast(MaplePacketCreator.guildMemberOnline(mapleGuild.l, a2, a3), a2);
            if (mapleGuild.F > 0) {
                MapleGuild mapleGuild2 = a5;
                MapleGuild mapleGuild3 = a5;
                World.Alliance.sendGuild(MaplePacketCreator.allianceMemberOnline(mapleGuild2.F, mapleGuild2.l, a2, a3), mapleGuild3.l, mapleGuild3.F);
            }
        }
        a5.M = true;
        a5.B = true;
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ void setAllianceId(int a) {
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

    public final /* synthetic */ void memberLevelJobUpdate(MapleGuildCharacter a2) {
        MapleGuild a3;
        for (MapleGuildCharacter mapleGuildCharacter : a3.P) {
            if (mapleGuildCharacter.getId() != a2.getId()) continue;
            MapleGuildCharacter mapleGuildCharacter2 = a2;
            MapleGuildCharacter mapleGuildCharacter3 = mapleGuildCharacter;
            int n2 = mapleGuildCharacter3.getLevel();
            int n3 = mapleGuildCharacter3.getJobId();
            mapleGuildCharacter3.setJobId(a2.getJobId());
            mapleGuildCharacter.setLevel((short)mapleGuildCharacter2.getLevel());
            if (mapleGuildCharacter2.getLevel() > n2) {
                a3.gainGP((a2.getLevel() - n2) * a2.getLevel() / 10, false);
            }
            if (n2 != a2.getLevel() && !GameSetConstants.SERVER_NAME.equals(PracticerCommand.ALLATORIxDEMO("\u6a79\u5715\u8c4c"))) {
                a3.broadcast(MaplePacketCreator.sendLevelup(false, a2.getLevel(), a2.getName()), a2.getId());
            }
            if (n3 != a2.getJobId()) {
                a3.broadcast(MaplePacketCreator.sendJobup(false, a2.getJobId(), a2.getName()), a2.getId());
            }
            MapleGuild mapleGuild = a3;
            mapleGuild.broadcast(MaplePacketCreator.guildMemberLevelJobUpdate(a2));
            if (mapleGuild.F <= 0) break;
            MapleGuild mapleGuild2 = a3;
            World.Alliance.sendGuild(MaplePacketCreator.updateAlliance(a2, a3.F), mapleGuild2.l, mapleGuild2.F);
            return;
        }
    }

    public final /* synthetic */ void deleteBBSThread(int a2, int a3, int a4) {
        MapleGuild a5;
        MapleBBSThread mapleBBSThread = a5.H.get(a2);
        if (mapleBBSThread != null && (mapleBBSThread.ownerID == a3 || a4 <= 2)) {
            a5.d = true;
            a5.H.remove(a2);
        }
    }

    public final /* synthetic */ int getLogo() {
        MapleGuild a2;
        return a2.A;
    }

    public final /* synthetic */ int getLogoBGColor() {
        MapleGuild a2;
        return a2.j;
    }

    public /* synthetic */ MapleGuildSkill getSkill(int a2) {
        MapleGuild a3;
        if (!a3.G.containsKey(a2)) {
            return null;
        }
        return a3.G.get(a2);
    }

    public static final /* synthetic */ MapleGuild load(int a2) {
        return new MapleGuild(a2);
    }

    public final /* synthetic */ void addGuildMap(int a2, int a32) {
        MapleGuild a4;
        String a32 = FileoutputUtil.DayNext(a32);
        a4.a.add(new Pair<Integer, String>(a2, a32));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ int addGuildMember(MapleGuildCharacter a2, boolean a3) {
        MapleGuild mapleGuild;
        MapleGuild a4;
        block8: {
            a4.g.lock();
            try {
                if (a4.P.size() >= a4.D) {
                    int n2 = 0;
                    a4.g.unlock();
                    return n2;
                }
            }
            catch (Throwable throwable) {
                a4.g.unlock();
                throw throwable;
            }
            {
                for (int i2 = a4.P.size() - 1; i2 >= 0; --i2) {
                    if (a4.P.get(i2).getGuildRank() >= 5 && a4.P.get(i2).getName().compareTo(a2.getName()) >= 0) continue;
                    mapleGuild = a4;
                    a4.P.add(i2 + 1, a2);
                    a4.M = true;
                    break block8;
                }
            }
            mapleGuild = a4;
        }
        mapleGuild.g.unlock();
        a4.gainGP(50);
        if (a3) {
            a4.broadcast(MaplePacketCreator.newGuildMember(a2));
        }
        if (a4.F > 0) {
            World.Alliance.sendGuild(a4.F);
        }
        return 1;
    }

    public /* synthetic */ int getLevel() {
        MapleGuild a2;
        return a2.J;
    }

    public final /* synthetic */ List<MapleBBSThread> getBBS() {
        MapleGuild a2;
        ArrayList<MapleBBSThread> arrayList;
        ArrayList<MapleBBSThread> arrayList2 = arrayList = new ArrayList<MapleBBSThread>(a2.H.values());
        Collections.sort(arrayList2, new MapleBBSThread.ThreadComparator());
        return arrayList2;
    }

    public /* synthetic */ String getPrefix(MapleCharacter a2) {
        return a2.getPrefix();
    }

    public final /* synthetic */ int getGP() {
        MapleGuild a2;
        return a2.m;
    }

    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = 4;
        int cfr_ignored_0 = (2 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int n5 = n3;
        int n6 = (3 ^ 5) << 4;
        while (n5 >= 0) {
            int n7 = n3--;
            arrc[n7] = (char)(a2.charAt(n7) ^ n6);
            if (n3 < 0) break;
            int n8 = n3--;
            arrc[n8] = (char)(a2.charAt(n8) ^ n4);
            n5 = n3;
        }
        return new String(arrc);
    }

    public final /* synthetic */ String getGuildMaps() {
        MapleGuild a2;
        if (a2.a.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MobConstants.ALLATORIxDEMO("\u60aa\u76da\u524f\u6274\u5c6e\u5158\u6701\u53db\u9030\u5151\u7686\u5704\u5714\u000e\u000f>"));
        Iterator<Pair<Integer, String>> iterator = a2.a.iterator();
        Iterator<Pair<Integer, String>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Pair<Integer, String> pair = iterator.next();
            int n2 = pair.getLeft();
            String string = pair.getRight();
            int n3 = n2;
            stringBuilder.append("#b#L" + n3 + "# \u5730\u5716\u540d\u7a31:#r#m" + n3 + "# #b\u53ef\u4f7f\u7528\u81f3 #r" + string + "\r\n");
            iterator2 = iterator;
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ void changeARank(boolean a2) {
        MapleGuild a3;
        for (MapleGuildCharacter mapleGuildCharacter : a3.P) {
            if (a3.h == mapleGuildCharacter.getId()) {
                a3.changeARank(mapleGuildCharacter.getId(), a2 ? 1 : 2);
                continue;
            }
            a3.changeARank(mapleGuildCharacter.getId(), 3);
        }
    }

    public /* synthetic */ int getAllianceId() {
        MapleGuild a2;
        return a2.F;
    }

    public final /* synthetic */ void addGuildMeso(long a2) {
        MapleGuild a3;
        MapleGuild mapleGuild = a3;
        mapleGuild.k += a2;
        mapleGuild.savePoints();
    }

    public final /* synthetic */ void addBBSReply(int a22, String a3, int a4) {
        MapleGuild a5;
        MapleBBSThread a22 = a5.H.get(a22);
        if (a22 != null) {
            a5.d = true;
            a22.replies.put(a22.replies.size(), new MapleBBSThread.MapleBBSReply(a22.replies.size(), a4, a3, System.currentTimeMillis()));
        }
    }

    public final /* synthetic */ int getLeaderId() {
        MapleGuild a2;
        return a2.h;
    }

    public final /* synthetic */ int calculateLevel() {
        int n2;
        int n3 = n2 = 1;
        while (n3 < 10) {
            MapleGuild a2;
            if (a2.m < GameConstants.getGuildExpNeededForLevel(n2)) {
                return n2;
            }
            n3 = ++n2;
        }
        return 10;
    }

    public final /* synthetic */ void broadcast(byte[] a2, int a3) {
        MapleGuild a4;
        a4.broadcast(a2, a3, BCOp.NONE);
    }

    public final /* synthetic */ void setLogoBG(int a2) {
        a.L = a2;
    }

    public final /* synthetic */ void allianceChat(String a2, int a3, String a4) {
        MapleGuild a5;
        a5.broadcast(MaplePacketCreator.multiChat(a2, a4, 3), a3);
    }

    public final /* synthetic */ void gainGP(int a2) {
        MapleGuild a3;
        a3.gainGP(a2, true);
    }

    public final /* synthetic */ MapleGuildCharacter getMGC(int a2) {
        MapleGuild a3;
        for (MapleGuildCharacter mapleGuildCharacter : a3.P) {
            if (mapleGuildCharacter.getId() != a2) continue;
            return mapleGuildCharacter;
        }
        return null;
    }

    public /* synthetic */ Collection<MapleGuildSkill> getSkills() {
        MapleGuild a2;
        return a2.G.values();
    }

    public final /* synthetic */ String getNotice() {
        MapleGuild a2;
        if (a2.c == null) {
            return "";
        }
        return a2.c;
    }

    /*
     * Exception decompiling
     */
    public final /* synthetic */ void setGuildEmblem(short a, byte a, short a, byte a) {
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

    public final /* synthetic */ int getLogoColor() {
        MapleGuild a2;
        return a2.f;
    }

    public final /* synthetic */ long getGuildPoints() {
        MapleGuild a2;
        return a2.K;
    }

    public /* synthetic */ boolean purchaseSkill(int a2, String a3, int a42) {
        MapleGuild mapleGuild;
        MapleStatEffect mapleStatEffect;
        MapleGuild a5;
        MapleStatEffect a42 = SkillFactory.getSkill(a2).getEffect(a5.getSkillLevel(a2) + 1);
        if (a42.getReqGuildLevel() > a5.getLevel() || a42.getLevel() <= a5.getSkillLevel(a2)) {
            return false;
        }
        MapleGuildSkill mapleGuildSkill = a5.G.get(a2);
        if (mapleGuildSkill == null) {
            String string = a3;
            mapleGuildSkill = new MapleGuildSkill(a2, a42.getLevel(), 0L, string, string);
            mapleStatEffect = a42;
            a5.G.put(a2, mapleGuildSkill);
        } else {
            MapleGuildSkill mapleGuildSkill2 = mapleGuildSkill;
            mapleGuildSkill.level = a42.getLevel();
            mapleGuildSkill2.activator = mapleGuildSkill2.purchaser = a3;
            mapleStatEffect = a42;
        }
        MapleGuildSkill mapleGuildSkill3 = mapleGuildSkill;
        if (mapleStatEffect.getPeriod() <= 0) {
            mapleGuildSkill3.timestamp = -1L;
            mapleGuild = a5;
        } else {
            mapleGuildSkill3.timestamp = System.currentTimeMillis() + (long)a42.getPeriod() * 60000L;
            mapleGuild = a5;
        }
        mapleGuild.ALLATORIxDEMO = true;
        MapleGuild mapleGuild2 = a5;
        mapleGuild2.gainGP(1000);
        MapleGuildSkill mapleGuildSkill4 = mapleGuildSkill;
        String string = a3;
        mapleGuild2.broadcast(MaplePacketCreator.guildSkillPurchased(mapleGuild2.l, a2, mapleGuildSkill4.level, mapleGuildSkill4.timestamp, string, string));
        return true;
    }

    private /* synthetic */ void ALLATORIxDEMO(MapleGuildCharacter a2) {
        MapleGuild a3;
        int n2;
        int n3 = n2 = 0;
        while (n3 < a3.P.size()) {
            if (a3.P.get(n2).getName().equals(a2.getName())) {
                a3.P.remove(n2);
            }
            n3 = ++n2;
        }
    }

    public static final /* synthetic */ MapleGuildResponse sendInvite(MapleClient a2, String a3) {
        a3 = a2.getChannelServer().getPlayerStorage().getCharacterByName((String)a3);
        if (a3 == null) {
            return MapleGuildResponse.NOT_IN_CHANNEL;
        }
        if (((MapleCharacter)a3).getGuildId() > 0) {
            return MapleGuildResponse.ALREADY_IN_GUILD;
        }
        ((MapleCharacter)a3).getClient().sendPacket(MaplePacketCreator.guildInvite(a2.getPlayer()));
        return null;
    }

    public /* synthetic */ Collection<MapleGuildCharacter> getMembers() {
        MapleGuild a2;
        return Collections.unmodifiableCollection(a2.P);
    }

    public final /* synthetic */ boolean isInit() {
        MapleGuild a2;
        return a2.B;
    }

    public final /* synthetic */ void deleteBBSReply(int a22, int a3, int a4, int a5) {
        MapleBBSThread.MapleBBSReply mapleBBSReply;
        MapleGuild a6;
        MapleBBSThread a22 = a6.H.get(a22);
        if (a22 != null && (mapleBBSReply = a22.replies.get(a3)) != null && (mapleBBSReply.ownerID == a4 || a5 <= 2)) {
            a6.d = true;
            a22.replies.remove(a3);
        }
    }

    public final /* synthetic */ void changeARank(int a2) {
        MapleGuild a3;
        Iterator<MapleGuildCharacter> iterator;
        Iterator<MapleGuildCharacter> iterator2 = iterator = a3.P.iterator();
        while (iterator2.hasNext()) {
            MapleGuildCharacter mapleGuildCharacter = iterator.next();
            iterator2 = iterator;
            a3.changeARank(mapleGuildCharacter.getId(), a2);
        }
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ MapleGuild(int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 5[TRYBLOCK]
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

    public final /* synthetic */ int getId() {
        MapleGuild a2;
        return a2.l;
    }

    public final /* synthetic */ void editBBSThread(int a2, String a3, String a4, int a5, int a6, int a7) {
        MapleGuild a8;
        MapleBBSThread mapleBBSThread = a8.H.get(a2);
        if (mapleBBSThread != null && (mapleBBSThread.ownerID == a6 || a7 <= 2)) {
            a8.d = true;
            a8.H.put(a2, new MapleBBSThread(a2, a3, a4, System.currentTimeMillis(), a8.l, mapleBBSThread.ownerID, a5));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void expelMember(MapleGuildCharacter a22, String a3, int a4) {
        MapleGuild a5;
        a5.g.lock();
        try {
            MapleGuild mapleGuild;
            block7: {
                for (MapleGuildCharacter mapleGuildCharacter : a5.P) {
                    MapleGuild mapleGuild2;
                    if (mapleGuildCharacter.getId() != a4 || a22.getGuildRank() >= mapleGuildCharacter.getGuildRank()) continue;
                    MapleGuild mapleGuild3 = a5;
                    a5.broadcast(MaplePacketCreator.memberLeft(mapleGuildCharacter, true));
                    mapleGuild3.M = true;
                    mapleGuild3.gainGP(-50);
                    if (mapleGuild3.F > 0) {
                        World.Alliance.sendGuild(a5.F);
                    }
                    if (mapleGuildCharacter.isOnline()) {
                        World.Guild.setGuildAndRank(a4, 0, 5, 5);
                        mapleGuild2 = a5;
                    } else {
                        MapleCharacterUtil.sendNote(mapleGuildCharacter.getName(), a22.getName(), MobConstants.ALLATORIxDEMO("\u4f54\u5df0\u7da7\u88a9\u5158\u6701\u8e16\u51f8\u001a"), 0);
                        MapleGuild.saveCharacterGuildInfo(0, (byte)5, (byte)5, a4);
                        mapleGuild2 = a5;
                    }
                    mapleGuild2.ALLATORIxDEMO(mapleGuildCharacter);
                    mapleGuild = a5;
                    break block7;
                }
                mapleGuild = a5;
            }
            mapleGuild.g.unlock();
            return;
        }
        catch (Throwable a22) {
            a5.g.unlock();
            throw a22;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void savePoints() {
        var1_1 = DBConPool.getInstance().getDataSource().getConnection();
        try {
            var2_3 = new StringBuilder(PracticerCommand.ALLATORIxDEMO("R+C:S>'\u001cr\u0012k\u001ft[T>S[`\u000en\u0017c\u0016b\bh[:[8W'\u001cr\u0012k\u001fw\u0014n\u0015s\b'F'D',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
            v0 = var3_5 = var1_1.prepareStatement(var2_3.toString());
            var3_5.setLong(1, a.k);
            v0.setLong(2, a.K);
            var3_5.setInt(3, a.l);
            v0.execute();
            var3_5.close();
            ** if (var1_1 == null) goto lbl-1000
        }
        catch (Throwable var2_4) {
            if (var1_1 == null) ** GOTO lbl26
            try {
                var1_1.close();
                v1 = var2_4;
                ** GOTO lbl27
            }
            catch (Throwable var3_6) {
                try {
                    var2_4.addSuppressed(var3_6);
lbl26:
                    // 2 sources

                    v1 = var2_4;
lbl27:
                    // 2 sources

                    throw v1;
                }
                catch (SQLException var1_2) {
                    System.err.println("Error saving guild to SQL" + var1_2);
                }
            }
        }
lbl-1000:
        // 1 sources

        {
            var1_1.close();
            return;
        }
lbl-1000:
        // 1 sources

        {
        }
    }

    private /* synthetic */ void ALLATORIxDEMO() {
        Iterator<MapleGuildCharacter> iterator;
        MapleGuild a2;
        if (!a2.M) {
            return;
        }
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Iterator<MapleGuildCharacter> iterator2 = iterator = a2.P.iterator();
        while (iterator2.hasNext()) {
            MapleGuildCharacter mapleGuildCharacter = iterator.next();
            if (!mapleGuildCharacter.isOnline()) {
                iterator2 = iterator;
                continue;
            }
            if (linkedList.contains(mapleGuildCharacter.getId()) || mapleGuildCharacter.getGuildId() != a2.l) {
                a2.ALLATORIxDEMO(mapleGuildCharacter);
                iterator2 = iterator;
                continue;
            }
            linkedList.add(mapleGuildCharacter.getId());
            iterator2 = iterator;
        }
        a2.M = false;
    }

    public final /* synthetic */ MapleCharacter getLeader(MapleClient a2) {
        MapleGuild a3;
        return a2.getChannelServer().getPlayerStorage().getCharacterById(a3.h);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void writeToDB(boolean a) {
        try {
            block23: {
                block22: {
                    var2_5 = DBConPool.getInstance().getDataSource().getConnection();
                    if (a != 0) break block22;
                    var3_7 = new StringBuilder(MobConstants.ALLATORIxDEMO("WdFuVq\"Sw]nPq\u0014QqV\u0014Ed\"\t\"\u000b.\u0014n[e[\"\t\"\u000b.\u0014n[e[A[n[p\u0014?\u0014=\u0018\"XmSmvE\u0014?\u0014=\u0018\"XmSmvEwmXmF\"\t\"\u000b.\u0014"));
                    v0 = a = 1;
                    while (v0 < 6) {
                        v1 = var3_7.append(PracticerCommand.ALLATORIxDEMO("u\u001ai\u0010")).append(a);
                        v1.append(MobConstants.ALLATORIxDEMO("@k@nQ\"\t\"\u000b.\u0014"));
                        v0 = ++a;
                    }
                    var3_7.append(PracticerCommand.ALLATORIxDEMO("d\u001aw\u001ad\u0012s\u0002'F'D+[i\u0014s\u0012d\u001e'F'D+[f\u0017k\u0012f\u0015d\u001e'F'D+[`\u000en\u0017c\u0016b\bh[:[8W'\u001cr\u0012k\u001fw\u0014n\u0015s\b'F'D',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
                    v2 = a = var2_5.prepareStatement(var3_7.toString());
                    v3 = a;
                    v4 = a;
                    v5 = a;
                    v6 = a;
                    v7 = a;
                    v8 = a;
                    v9 = a;
                    v9.setInt(1, a.m);
                    v9.setInt(2, a.A);
                    v8.setInt(3, a.f);
                    v8.setInt(4, a.L);
                    v7.setInt(5, a.j);
                    v7.setString(6, a.w[0]);
                    v6.setString(7, a.w[1]);
                    v6.setString(8, a.w[2]);
                    v5.setString(9, a.w[3]);
                    v5.setString(10, a.w[4]);
                    v4.setInt(11, a.D);
                    v4.setString(12, a.c);
                    v3.setInt(13, a.F);
                    v3.setLong(14, a.k);
                    v2.setLong(15, a.K);
                    v2.setInt(16, a.l);
                    v2.execute();
                    a.close();
                    if (!a.d) ** GOTO lbl138
                    a = var2_5.prepareStatement(MobConstants.ALLATORIxDEMO("pGxG`G\u0014DfMy\"V`G]@jFgUfG\"cJqPq\"Sw]nPkP\"\t\"\u000b"));
                    a.setInt(1, a.l);
                    a.execute();
                    a.close();
                    a = var2_5.prepareStatement(PracticerCommand.ALLATORIxDEMO("?B7B/B[A)H6'\u0019e\bX\tb\u000bk\u0012b\b',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
                    a.setInt(1, a.l);
                    a.execute();
                    v10 = var2_5;
                    a.close();
                    var4_10 = v10.prepareStatement(MobConstants.ALLATORIxDEMO("}LgGfV\u0014KzV{\"V`G]FgDn]gG\"\u001cb@jFgUf]fT.\u0014bDmGvQpWkPb\u0018\"Tv]oQq@cYrT.\u0014bWmZvQl@b\u0018\"TeAkXf]fT+\u0014TuNaGg\"\u001c=\u0018\"\u000b.\u0014=\u0018\"\u000b.\u0014=\u001d"));
                    a = v10.prepareStatement(PracticerCommand.ALLATORIxDEMO("N5T>U/'2I/H[e\u0019t$s\u0013u\u001ef\u001ftSg\u000bh\bs\u001eu\u0018n\u001fgW'\u001bi\u001aj\u001egW'\u001bs\u0012j\u001et\u000ff\u0016w\u001b+[g\u0012d\u0014i\u001b+[g\bs\u001au\u000fw\u0014t\u000fgW'\u001b`\u000en\u0017c\u0012c\u001b+[g\u0017h\u0018f\u0017s\u0013u\u001ef\u001fn\u001fgR'-F7R>TS8W'D+[8W'D+[8W'D+[8R"), 1);
                    v11 = a;
                    a.setInt(6, v11.l);
                    var5_11 = v11.H.values().iterator();
                    ** GOTO lbl95
                }
                var3_8 = var2_5.prepareStatement(PracticerCommand.ALLATORIxDEMO("R+C:S>'\u0018o\u001au\u001ad\u000fb\tt[T>S[`\u000en\u0017c\u0012c[:[7W'\u001cr\u0012k\u001fu\u001ai\u0010'F'N+[f\u0017k\u0012f\u0015d\u001eu\u001ai\u0010'F'N',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
                var3_8.setInt(1, a.l);
                var3_8.execute();
                var3_8.close();
                var3_8 = var2_5.prepareStatement(MobConstants.ALLATORIxDEMO("pGxG`G\u0014DfMy\"V`G]@jFgUfG\"cJqPq\"Sw]nPkP\"\t\"\u000b"));
                var3_8.setInt(1, a.l);
                var3_8.execute();
                var3_8.close();
                var3_8 = var2_5.prepareStatement(PracticerCommand.ALLATORIxDEMO("?B7B/B[A)H6'\u0019e\bX\tb\u000bk\u0012b\b',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
                var3_8.setInt(1, a.l);
                var3_8.execute();
                var3_8.close();
                var3_8 = var2_5.prepareStatement(MobConstants.ALLATORIxDEMO("FqNqVq\"rP{O\u0014eAkXfG\"cJqPq\"Sw]nPkP\"\t\"\u000b"));
                var3_8.setInt(1, a.l);
                var3_8.execute();
                var3_8.close();
                if (DBConPool.getInstance().TableExist(PracticerCommand.ALLATORIxDEMO("\u001cr\u0012k\u001ft\u0016f\u000b"))) {
                    var3_8 = var2_5.prepareStatement(MobConstants.ALLATORIxDEMO("pGxG`G\u0014DfMy\"Sw]nPqYcD\"cJqPq\"Sw]nPkP\"\t\"\u000b"));
                    var3_8.setInt(1, a.l);
                    var3_8.execute();
                    var3_8.close();
                }
                if (a.F > 0 && (a = World.Alliance.getAlliance(a.F)) != null) {
                    a.removeGuild(a.l, false);
                }
                v12 = a;
                v12.broadcast(MaplePacketCreator.guildDisband(v12.l));
lbl95:
                // 1 sources

                block12: while (true) {
                    v13 = var5_11;
                    while (v13.hasNext()) {
                        var6_12 = (MapleBBSThread)var5_11.next();
                        v14 = a;
                        v15 = a;
                        v16 = a;
                        v16.setInt(1, var6_12.ownerID);
                        v16.setString(2, var6_12.name);
                        v15.setLong(3, var6_12.timestamp);
                        v15.setInt(4, var6_12.icon);
                        v14.setString(5, var6_12.text);
                        v14.setInt(7, var6_12.localthreadID);
                        v14.execute();
                        var7_14 = a.getGeneratedKeys();
                        if (!var7_14.next()) {
                            v13 = var5_11;
                            var7_14.close();
                            continue;
                        }
                        v17 = var7_14;
                        var7_13 = v17.getInt(1);
                        v17.close();
                        var4_10.setInt(5, a.l);
                        v18 = var6_12 = var6_12.replies.values().iterator();
                        while (true) {
                            if (!v18.hasNext()) continue block12;
                            var8_15 = (MapleBBSThread.MapleBBSReply)var6_12.next();
                            v18 = var6_12;
                            v19 = var4_10;
                            v20 = var4_10;
                            v20.setInt(1, var7_13);
                            v20.setInt(2, var8_15.ownerID);
                            v19.setLong(3, var8_15.timestamp);
                            v19.setString(4, var8_15.content);
                            v19.addBatch();
                        }
                    }
                    break;
                }
                try {
                    var4_10.executeBatch();
                    var4_10.close();
                    a.close();
lbl138:
                    // 2 sources

                    if (a.ALLATORIxDEMO) {
                        a = var2_5.prepareStatement(MobConstants.ALLATORIxDEMO("pGxG`G\u0014DfMy\"Sw]nPq_kXnG\"cJqPq\"Sw]nPkP\"\t\"\u000b"));
                        a.setInt(1, a.l);
                        a.execute();
                        a.close();
                        a = var2_5.prepareStatement(PracticerCommand.ALLATORIxDEMO("N5T>U/'2I/H[`\u000en\u0017c\bl\u0012k\u0017tSg\u001cr\u0012k\u001fn\u001fgW'\u001bt\u0010n\u0017k\u0012c\u001b+[g\u0017b\rb\u0017gW'\u001bs\u0012j\u001et\u000ff\u0016w\u001b+[g\u000br\td\u0013f\bb\tgR'-F7R>TS8W'D+[8W'D+[8R"));
                        v21 = a;
                        a.setInt(1, v21.l);
                        var4_10 = v21.G.values().iterator();
                        v22 = var4_10;
                        while (v22.hasNext()) {
                            var5_11 = (MapleGuildSkill)var4_10.next();
                            v22 = var4_10;
                            v23 = a;
                            v24 = a;
                            v24.setInt(2, var5_11.skillID);
                            v24.setByte(3, (byte)var5_11.level);
                            v23.setLong(4, var5_11.timestamp);
                            v23.setString(5, var5_11.purchaser);
                            v23.execute();
                        }
                        a.close();
                    }
                    a.ALLATORIxDEMO = false;
                    a.d = false;
                    if (!DBConPool.getInstance().TableExist(MobConstants.ALLATORIxDEMO("Sw]nPqYcD"))) break block23;
                    a = var2_5.prepareStatement(PracticerCommand.ALLATORIxDEMO("?B7B/B[A)H6'\u001cr\u0012k\u001ft\u0016f\u000b',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
                    a.setInt(1, a.l);
                    a.execute();
                    a.close();
                    a = var2_5.prepareStatement(MobConstants.ALLATORIxDEMO("}LgGfV\u0014KzV{\"Sw]nPqYcD\"\u001cbSw]nPkPb\u0018\"ToUr]fT.\u0014bQzDkFgPc@gT+\u0014TuNaGg\"\u001c=\u0018\"\u000b.\u0014=\u001d"));
                    v25 = a;
                    a.setInt(1, v25.l);
                    var4_10 = v25.a.iterator();
                    v26 = var4_10;
                    while (v26.hasNext()) {
                        var5_11 = var4_10.next();
                        a.setInt(2, var5_11.getLeft());
                        a.setString(3, var5_11.getRight());
                        v26 = var4_10;
                        a.execute();
                    }
                }
                catch (Throwable var3_9) {
                    if (var2_5 != null) {
                        try {
                            var2_5.close();
                            v27 = var3_9;
                            throw v27;
                        }
                        catch (Throwable a) {
                            var3_9.addSuppressed(a);
                        }
                    }
                    v27 = var3_9;
                    throw v27;
                }
            }
            if (var2_5 == null) return;
            var2_5.close();
            return;
        }
        catch (SQLException var2_6) {
            System.err.println(PracticerCommand.ALLATORIxDEMO(">u\th\t'\bf\rn\u0015`[`\u000en\u0017c[s\u0014'(V7"));
        }
    }

    public final /* synthetic */ void broadcast(byte[] a2) {
        MapleGuild a3;
        a3.broadcast(a2, -1, BCOp.NONE);
    }

    public /* synthetic */ int getInvitedId() {
        MapleGuild a2;
        return a2.C;
    }

    public final /* synthetic */ void disbandGuild() {
        MapleGuild a2;
        MapleGuild mapleGuild = a2;
        mapleGuild.writeToDB(true);
        mapleGuild.broadcast(null, -1, BCOp.DISBAND);
    }

    public final /* synthetic */ int getCapacity() {
        MapleGuild a2;
        return a2.D;
    }

    public final /* synthetic */ void setLogoBGColor(int a2) {
        a.j = a2;
    }

    public final /* synthetic */ void leaveGuild(MapleGuildCharacter a22) {
        MapleGuild a3;
        MapleGuild mapleGuild = a3;
        mapleGuild.broadcast(MaplePacketCreator.memberLeft(a22, false));
        mapleGuild.gainGP(-50);
        mapleGuild.g.lock();
        try {
            MapleGuild mapleGuild2;
            a3.M = true;
            a3.ALLATORIxDEMO(a22);
            if (a22.isOnline()) {
                mapleGuild2 = a3;
                World.Guild.setGuildAndRank(a22.getId(), 0, 5, 5);
            } else {
                MapleGuild.saveCharacterGuildInfo(0, (byte)5, (byte)5, a22.getId());
                mapleGuild2 = a3;
            }
            if (mapleGuild2.F > 0) {
                World.Alliance.sendGuild(a3.F);
            }
            return;
        }
        catch (Exception a22) {
            System.err.println("leaveGuild " + a22);
            FileoutputUtil.printError(MobConstants.ALLATORIxDEMO("OUrXgsw]nP,@z@"), a22, PracticerCommand.ALLATORIxDEMO("[\u96e5\u95f0\u516b\u6778\u5936\u652c"));
            return;
        }
        finally {
            a3.g.unlock();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final /* synthetic */ void changeGuildLeader(int a22) {
        MapleGuild a3;
        if (!a3.changeRank(a22, 1)) return;
        MapleGuild mapleGuild = a3;
        if (!mapleGuild.changeRank(mapleGuild.h, 2)) return;
        if (a3.F > 0) {
            MapleGuild mapleGuild2;
            MapleGuild mapleGuild3 = a3;
            byte by = mapleGuild3.getMGC(mapleGuild3.h).getAllianceRank();
            if (by == 1) {
                MapleGuild mapleGuild4 = a3;
                mapleGuild2 = mapleGuild4;
                World.Alliance.changeAllianceLeader(mapleGuild4.F, a22, true);
            } else {
                MapleGuild mapleGuild5 = a3;
                mapleGuild2 = mapleGuild5;
                mapleGuild5.changeARank(a22, by);
            }
            mapleGuild2.changeARank(a3.h, 3);
        }
        MapleGuild mapleGuild6 = a3;
        mapleGuild6.broadcast(MaplePacketCreator.guildLeaderChanged(a3.l, mapleGuild6.h, a22, a3.F));
        a3.h = a22;
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        try {
            PreparedStatement preparedStatement;
            PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(PracticerCommand.ALLATORIxDEMO("R+C:S>'\u001cr\u0012k\u001ft[T>S[k\u001ef\u001fb\t'F'D',O>U>'\u001cr\u0012k\u001fn\u001f'F'D"));
            preparedStatement2.setInt(1, a22);
            preparedStatement.setInt(2, a3.l);
            preparedStatement2.execute();
            preparedStatement.close();
            if (druidPooledConnection == null) return;
        }
        catch (Throwable throwable) {
            try {
                Throwable throwable2;
                if (druidPooledConnection != null) {
                    try {
                        druidPooledConnection.close();
                        throwable2 = throwable;
                        throw throwable2;
                    }
                    catch (Throwable a22) {
                        throwable.addSuppressed(a22);
                    }
                }
                throwable2 = throwable;
                throw throwable2;
            }
            catch (SQLException sQLException) {
                System.err.println("Saving leaderid ERROR" + sQLException);
            }
        }
        druidPooledConnection.close();
        return;
    }

    public final /* synthetic */ void changeRankTitle(String[] a2) {
        MapleGuild a3;
        MapleGuild mapleGuild = a3;
        System.arraycopy(a2, 0, mapleGuild.w, 0, 5);
        mapleGuild.broadcast(MaplePacketCreator.rankTitleChange(mapleGuild.l, a2));
    }

    public final /* synthetic */ void setLogo(int a2) {
        a.A = a2;
    }

    public final /* synthetic */ void addMemberData(MaplePacketLittleEndianWriter a2) {
        Iterator<MapleGuildCharacter> iterator;
        MapleGuild a3;
        MapleGuild mapleGuild = a3;
        a2.write(mapleGuild.P.size());
        Iterator<MapleGuildCharacter> iterator2 = iterator = mapleGuild.P.iterator();
        while (iterator2.hasNext()) {
            MapleGuildCharacter mapleGuildCharacter = iterator.next();
            iterator2 = iterator;
            a2.writeInt(mapleGuildCharacter.getId());
        }
        for (MapleGuildCharacter mapleGuildCharacter : a3.P) {
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter = a2;
            MapleGuildCharacter mapleGuildCharacter2 = mapleGuildCharacter;
            MaplePacketLittleEndianWriter maplePacketLittleEndianWriter2 = a2;
            maplePacketLittleEndianWriter2.writeAsciiString(mapleGuildCharacter.getName(), GameSetConstants.WRITE_STRING_LENGTH);
            maplePacketLittleEndianWriter2.writeInt(mapleGuildCharacter.getJobId());
            a2.writeInt(mapleGuildCharacter2.getLevel());
            maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter2.getGuildRank());
            maplePacketLittleEndianWriter.writeInt(mapleGuildCharacter.isOnline() ? 1 : 0);
            if (GameSetConstants.MAPLE_VERSION >= 134) {
                MaplePacketLittleEndianWriter maplePacketLittleEndianWriter3 = a2;
                maplePacketLittleEndianWriter3.writeInt(mapleGuildCharacter.getAllianceRank());
                maplePacketLittleEndianWriter3.writeInt(mapleGuildCharacter.getGuildContribution());
                continue;
            }
            a2.writeInt(a3.i);
            if (GameSetConstants.MAPLE_VERSION == 75) continue;
            a2.writeInt(mapleGuildCharacter.getAllianceRank());
        }
    }

    public final /* synthetic */ void changeARank(int a2, boolean a3) {
        MapleGuild a4;
        Iterator<MapleGuildCharacter> iterator;
        Iterator<MapleGuildCharacter> iterator2 = iterator = a4.P.iterator();
        while (iterator2.hasNext()) {
            MapleGuildCharacter mapleGuildCharacter = iterator.next();
            iterator2 = iterator;
            a4.changeARank(mapleGuildCharacter.getId(), a2, a3);
        }
    }

    public /* synthetic */ boolean isProper() {
        MapleGuild a2;
        return a2.I;
    }

    public final /* synthetic */ void addGuildPoints(long a2) {
        MapleGuild a3;
        MapleGuild mapleGuild = a3;
        mapleGuild.K += a2;
        mapleGuild.savePoints();
    }

    public final /* synthetic */ void setLogoColor(int a2) {
        a.f = a2;
    }

    public final /* synthetic */ long getGuildMeso() {
        MapleGuild a2;
        return a2.k;
    }

    /*
     * Exception decompiling
     */
    public static /* synthetic */ void saveCharacterGuildInfo(int a, byte a, byte a, int a) {
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

    public final /* synthetic */ void gainGP(int a2, boolean a3) {
        boolean bl;
        MapleGuild a4;
        if (a2 == 0) {
            return;
        }
        if (a2 + a4.m < 0) {
            a2 = -a4.m;
        }
        a4.m += a2;
        if (GameSetConstants.MAPLE_VERSION >= 134) {
            bl = a3;
            MapleGuild mapleGuild = a4;
            MapleGuild mapleGuild2 = a4;
            mapleGuild2.broadcast(MaplePacketCreator.updateGP(mapleGuild.l, mapleGuild.m, mapleGuild2.J));
        } else {
            MapleGuild mapleGuild = a4;
            mapleGuild.broadcast(MaplePacketCreator.updateGP(mapleGuild.l, mapleGuild.m));
            bl = a3;
        }
        if (bl) {
            a4.broadcast(UIPacket.getGPMsg(a2));
        }
    }

    public final /* synthetic */ void guildChat(String a2, int a3, String a4) {
        MapleGuild a5;
        a5.broadcast(MaplePacketCreator.multiChat(a2, a4, 2), a3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final /* synthetic */ void broadcast(byte[] a2, int a3, BCOp a4) {
        MapleGuild mapleGuild;
        MapleGuild a5;
        a5.g.lock();
        try {
            a5.ALLATORIxDEMO();
            mapleGuild = a5;
            mapleGuild.g.unlock();
        }
        catch (Throwable throwable) {
            a5.g.unlock();
            throw throwable;
        }
        mapleGuild.E.lock();
        try {
            for (Serializable serializable : a5.P) {
                if (a4 == BCOp.DISBAND) {
                    if (serializable.isOnline()) {
                        World.Guild.setGuildAndRank(serializable.getId(), 0, 5, 5);
                        continue;
                    }
                    MapleGuild.saveCharacterGuildInfo(0, (byte)5, (byte)5, serializable.getId());
                    continue;
                }
                if (serializable == null || !serializable.isOnline() || serializable.getId() == a3 || (serializable = MapleCharacter.getOnlineCharacterByName(serializable.getName())) == null) continue;
                if (a4 == BCOp.EMBELMCHANGE) {
                    World.Guild.changeEmblem(a5.l, (MapleCharacter)serializable, new MapleGuildSummary(a5));
                    continue;
                }
                World.Broadcast.sendGuildPacket((MapleCharacter)serializable, a2, a3, a5.l);
            }
            return;
        }
        catch (Exception exception) {
            System.err.println("broadcast " + exception);
            FileoutputUtil.printError(MobConstants.ALLATORIxDEMO("OUrXgsw]nP,@z@"), exception, PracticerCommand.ALLATORIxDEMO("[\u516b\u6778\u5ee4\u64d6\u5936\u652c"));
            return;
        }
        finally {
            a5.E.unlock();
        }
    }

    public /* synthetic */ int getSkillLevel(int a2) {
        MapleGuild a3;
        if (!a3.G.containsKey(a2)) {
            return 0;
        }
        return a3.G.get((Object)Integer.valueOf((int)a2)).level;
    }

    private static final class BCOp
    extends Enum<BCOp> {
        private static final /* synthetic */ BCOp[] ALLATORIxDEMO;
        public static final /* synthetic */ /* enum */ BCOp DISBAND;
        public static final /* synthetic */ /* enum */ BCOp NONE;
        public static final /* synthetic */ /* enum */ BCOp EMBELMCHANGE;

        public static /* synthetic */ BCOp valueOf(String a2) {
            return Enum.valueOf(BCOp.class, a2);
        }

        public static /* synthetic */ {
            NONE = new BCOp(AllianceHandler.ALLATORIxDEMO("x_xU"), 0);
            DISBAND = new BCOp(InternCommand.ALLATORIxDEMO("AxVsD\u007fA"), 1);
            EMBELMCHANGE = new BCOp(AllianceHandler.ALLATORIxDEMO("s]tUz]uXw^qU"), 2);
            BCOp[] arrbCOp = new BCOp[3];
            arrbCOp[0] = NONE;
            arrbCOp[1] = DISBAND;
            arrbCOp[2] = EMBELMCHANGE;
            ALLATORIxDEMO = arrbCOp;
        }

        public static /* synthetic */ BCOp[] values() {
            return (BCOp[])ALLATORIxDEMO.clone();
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private /* synthetic */ BCOp() {
            void var2_-1;
            void var1_-1;
            BCOp a2;
        }
    }
}

