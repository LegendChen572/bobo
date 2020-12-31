/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u6bd4\u5947\u8c37
 *  com.alibaba.druid.pool.DruidPooledConnection
 */
package server.characterCards;

import client.PlayerRandomStream;
import client.messages.commands.player.\u6bd4\u5947\u8c37;
import com.alibaba.druid.pool.DruidPooledConnection;
import constants.SkillConstants;
import database.DBConPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.characterCards.CardData;
import tools.FileoutputUtil;
import tools.Pair;
import tools.Triple;

public class CharacterCardFactory {
    private static final /* synthetic */ CharacterCardFactory K;
    private final /* synthetic */ Map<Integer, Integer> d;
    private final /* synthetic */ MapleDataProvider a;
    private final /* synthetic */ Map<Integer, List<Integer>> ALLATORIxDEMO;

    private static /* synthetic */ CardData ALLATORIxDEMO(Integer a2) {
        return new CardData(0, 0, 0);
    }

    public final /* synthetic */ Triple<Integer, Integer, Integer> getCardSkill(int a2, int a3) {
        CharacterCardFactory a4;
        if ((a2 = a4.d.get(a2 / 10).intValue()) <= 0) {
            return null;
        }
        return new Triple<Integer, Integer, Integer>(a2 - 71000000, a2, SkillConstants.getCardSkillLevel(a3));
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public /* synthetic */ Map<Integer, Pair<Short, Short>> loadCharactersInfo(int a2, int a3) {
        PreparedStatement preparedStatement;
        LinkedHashMap<Integer, Pair<Short, Short>> linkedHashMap = new LinkedHashMap<Integer, Pair<Short, Short>>();
        DruidPooledConnection druidPooledConnection = DBConPool.getInstance().getDataSource().getConnection();
        PreparedStatement preparedStatement2 = preparedStatement = druidPooledConnection.prepareStatement(PlayerRandomStream.ALLATORIxDEMO("\u001c\u0016\u0003\u0016\f\u0007o:+\u007fo?*%*?cs%<-s\t\u0001\u0000\u001eo0'2=2,'*!<s\u0018\u001b\n\u0001\ns.0,<:=;:+srsps\u000e\u001d\u000bs8<=?+srsp"));
        preparedStatement2.setInt(1, a2);
        preparedStatement2.setInt(2, a3);
        ResultSet resultSet = preparedStatement2.executeQuery();
        while (resultSet.next()) {
            linkedHashMap.put(resultSet.getInt(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"$\u0010")), new Pair<Short, Short>(resultSet.getShort(PlayerRandomStream.ALLATORIxDEMO("#696#")), resultSet.getShort(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u001e\"\u0016"))));
        }
        if (druidPooledConnection != null) {
            druidPooledConnection.close();
        }
        {
            catch (Throwable throwable) {
                try {
                    Throwable throwable2;
                    block11: {
                        if (druidPooledConnection != null) {
                            try {
                                druidPooledConnection.close();
                                throwable2 = throwable;
                                break block11;
                            }
                            catch (Throwable throwable3) {
                                throwable.addSuppressed(throwable3);
                            }
                        }
                        throwable2 = throwable;
                    }
                    throw throwable2;
                }
                catch (SQLException sQLException) {
                    System.err.println("\u8f09\u5165\u89d2\u8272\u5931\u6557(accid:" + a2 + " serverId:" + a3 + "), \u539f\u56e0:" + sQLException);
                    FileoutputUtil.printError(PlayerRandomStream.ALLATORIxDEMO("\u0010'2=2,'*!\f2=7\t2,' !6};+;"), sQLException.toString());
                }
            }
        }
        return linkedHashMap;
    }

    public final /* synthetic */ int getRankSkill(int a2) {
        return SkillConstants.getCardSkillLevel(a2) + 71001099;
    }

    public static /* synthetic */ CharacterCardFactory getInstance() {
        return K;
    }

    public final /* synthetic */ List<Integer> getUniqueSkills(List<Integer> a2) {
        CharacterCardFactory a3;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (Map.Entry<Integer, List<Integer>> entry : a3.ALLATORIxDEMO.entrySet()) {
            if (!entry.getValue().contains(a2.get(0)) || !entry.getValue().contains(a2.get(1)) || !entry.getValue().contains(a2.get(2))) continue;
            linkedList.add(entry.getKey());
        }
        return linkedList;
    }

    public /* synthetic */ CharacterCardFactory() {
        CharacterCardFactory a2;
        a2.a = MapleDataProviderFactory.getDataProvider(PlayerRandomStream.ALLATORIxDEMO("`\u0016;0a$5"));
        CharacterCardFactory characterCardFactory = a2;
        a2.d = new HashMap<Integer, Integer>();
        characterCardFactory.ALLATORIxDEMO = new HashMap<Integer, List<Integer>>();
    }

    public /* synthetic */ void initialize() {
        int n2;
        CharacterCardFactory a2;
        MapleData mapleData = a2.a.getData(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"7%\u0015?\u0015.\u0000(\u0006\u000e\u0015?\u0010c\u001d \u0013"));
        for (MapleData mapleData2 : mapleData.getChildByPath(PlayerRandomStream.ALLATORIxDEMO("\u0010.!+"))) {
            n2 = MapleDataTool.getIntConvert(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0007&\u001d!\u0018\u00040"), mapleData2, 0);
            if (n2 <= 0) continue;
            a2.d.put(Integer.parseInt(mapleData2.getName()), n2);
        }
        for (MapleData mapleData2 : mapleData.getChildByPath(PlayerRandomStream.ALLATORIxDEMO("\u0017*0$"))) {
            n2 = MapleDataTool.getIntConvert(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"8\u001a$\u00058\u0011\b\u0012+\u0011.\u0000"), mapleData2, 0) > 0 ? 1 : 0;
            int n3 = MapleDataTool.getIntConvert(PlayerRandomStream.ALLATORIxDEMO("<8&?#\u001a\u000b"), mapleData2, 0);
            if (n2 == 0) continue;
            LinkedList<Integer> linkedList = new LinkedList<Integer>();
            Iterator iterator = mapleData2.getChildByPath(\u6bd4\u5947\u8c37.ALLATORIxDEMO((String)"\u0006(\u0005\u000e\u0015?\u0010\u00040")).iterator();
            while (iterator.hasNext()) {
                Iterator iterator2;
                MapleData mapleData3 = (MapleData)iterator2.next();
                iterator = iterator2;
                linkedList.add(MapleDataTool.getIntConvert(mapleData3));
            }
            if (n3 <= 0 || linkedList.isEmpty()) continue;
            a2.ALLATORIxDEMO.put(n3, linkedList);
        }
    }

    public final /* synthetic */ boolean canHaveCard(int a2, int a3) {
        CharacterCardFactory a4;
        if (a2 < 30) {
            return false;
        }
        return a4.d.get(a3 / 10) != null;
    }

    public static /* synthetic */ {
        K = new CharacterCardFactory();
    }

    /*
     * Exception decompiling
     */
    public /* synthetic */ Map<Integer, CardData> loadCharacterCards(int a, int a) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:406)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:481)
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

