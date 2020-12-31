/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  client.messages.commands.player.\u8702\u4e4b\u8c37
 */
package server.life;

import client.messages.commands.player.eventSystem.MapOwner;
import client.messages.commands.player.\u8702\u4e4b\u8c37;
import java.awt.Point;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import server.life.MobSkill;
import tools.Pair;

public class MobSkillFactory {
    private final /* synthetic */ Map<Pair<Integer, Integer>, MobSkill> a;
    private static final /* synthetic */ MobSkillFactory ALLATORIxDEMO;
    private final /* synthetic */ List<MobSkill> d;

    public static /* synthetic */ {
        ALLATORIxDEMO = new MobSkillFactory();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* synthetic */ List<MobSkill> getAllMobSkill() {
        if (MobSkillFactory.ALLATORIxDEMO.d.isEmpty()) {
            block3: for (MobSkill mobSkill : MobSkillFactory.ALLATORIxDEMO.a.values()) {
                switch (mobSkill.getSkillId()) {
                    case 120: 
                    case 121: 
                    case 122: 
                    case 123: 
                    case 124: 
                    case 125: 
                    case 126: 
                    case 128: 
                    case 132: 
                    case 133: 
                    case 134: 
                    case 135: 
                    case 136: 
                    case 137: {
                        MobSkillFactory.ALLATORIxDEMO.d.add(mobSkill);
                        continue block3;
                    }
                }
            }
        }
        return MobSkillFactory.ALLATORIxDEMO.d;
    }

    public /* synthetic */ MobSkillFactory() {
        MobSkillFactory a2;
        MobSkillFactory mobSkillFactory = a2;
        MobSkillFactory mobSkillFactory2 = a2;
        mobSkillFactory.a = new HashMap<Pair<Integer, Integer>, MobSkill>();
        mobSkillFactory2.d = new ArrayList<MobSkill>();
        mobSkillFactory.ALLATORIxDEMO();
    }

    public static /* synthetic */ MobSkillFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public static /* synthetic */ MobSkill getMobSkill(int a2, int a3) {
        return MobSkillFactory.ALLATORIxDEMO.a.get(new Pair<Integer, Integer>(a2, a3));
    }

    private /* synthetic */ MobSkill ALLATORIxDEMO(ResultSet a2) throws SQLException {
        MobSkill mobSkill;
        int n2;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Object object = a2.getString(MapOwner.ALLATORIxDEMO(";K%S'P;")).split(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\u0018q"));
        if (((String[])object).length <= 0 && a2.getString(MapOwner.ALLATORIxDEMO(";K%S'P;")).length() > 0) {
            arrayList.add(Integer.parseInt(a2.getString(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"\"A<Y>Z\""))));
        }
        int n3 = ((String[])object).length;
        int n4 = n2 = 0;
        while (n4 < n3) {
            String string = object[n2];
            if (string.length() > 0) {
                arrayList.add(Integer.parseInt(string));
            }
            n4 = ++n2;
        }
        object = null;
        Point point = null;
        if (a2.getInt(MapOwner.ALLATORIxDEMO("$J0")) != 0 || a2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"=@(")) != 0 || a2.getInt(MapOwner.ALLATORIxDEMO(":\\0")) != 0 || a2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"#V(")) != 0) {
            object = new Point(a2.getInt(MapOwner.ALLATORIxDEMO("$J0")), a2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"=@(")));
            point = new Point(a2.getInt(MapOwner.ALLATORIxDEMO(":\\0")), a2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"#V(")));
        }
        MobSkill mobSkill2 = mobSkill = new MobSkill(a2.getInt(MapOwner.ALLATORIxDEMO(";U!R$W,")), a2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"=Q'Q=")));
        ResultSet resultSet = a2;
        MobSkill mobSkill3 = mobSkill;
        ResultSet resultSet2 = a2;
        MobSkill mobSkill4 = mobSkill;
        ResultSet resultSet3 = a2;
        MobSkill mobSkill5 = mobSkill;
        mobSkill5.addSummons(arrayList);
        mobSkill5.setCoolTime(a2.getInt(MapOwner.ALLATORIxDEMO("W&J-L>_$")) * 1000);
        mobSkill.setDuration(resultSet3.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"@8Y4")) * 1000);
        mobSkill4.setHp(resultSet3.getInt(MapOwner.ALLATORIxDEMO("V8")));
        mobSkill4.setMpCon(a2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"<D2[?")));
        mobSkill.setSpawnEffect(resultSet2.getInt(MapOwner.ALLATORIxDEMO(";N)I&[.X-]<")));
        mobSkill3.setX(resultSet2.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)")")));
        mobSkill3.setY(a2.getInt(MapOwner.ALLATORIxDEMO("1")));
        mobSkill.setProp((float)resultSet.getInt(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"D#[!")) / 100.0f);
        mobSkill2.setLimit((short)resultSet.getInt(MapOwner.ALLATORIxDEMO("$W%W<")));
        mobSkill2.setOnce(a2.getByte(\u8702\u4e4b\u8c37.ALLATORIxDEMO((String)"[?W4")) > 0);
        MobSkill mobSkill6 = mobSkill;
        mobSkill6.setLtRb((Point)object, point);
        return mobSkill6;
    }

    /*
     * Exception decompiling
     */
    private /* synthetic */ void ALLATORIxDEMO() {
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
}

