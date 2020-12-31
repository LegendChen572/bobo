/*
 * Decompiled with CFR 0.150.
 */
package server;

import handling.channel.handler.HiredMerchantHandler;
import java.util.HashMap;
import java.util.Map;
import provider.MapleData;
import provider.MapleDataProvider;
import provider.MapleDataProviderFactory;
import provider.MapleDataTool;
import server.Randomizer;
import server.shark.SharkLogger;

public class PredictCardFactory {
    public /* synthetic */ Map<Integer, PredictCard> predictCard;
    public /* synthetic */ Map<Integer, PredictCardComment> predictCardComment;
    public /* synthetic */ MapleDataProvider etcData;
    private static final /* synthetic */ PredictCardFactory ALLATORIxDEMO;

    public /* synthetic */ PredictCardComment getPredictCardComment(int a2) {
        PredictCardFactory a3;
        if (!a3.predictCardComment.containsKey(a2)) {
            return null;
        }
        return a3.predictCardComment.get(a2);
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new PredictCardFactory();
    }

    public /* synthetic */ void initialize() {
        Object object;
        Object object2;
        Object object3;
        PredictCardFactory a2;
        if (!a2.predictCard.isEmpty() || !a2.predictCardComment.isEmpty()) {
            return;
        }
        Object object4 = a2.etcData.getData(HiredMerchantHandler.ALLATORIxDEMO("^\u0006k\u0010g\u0017z7o\u0006jZg\u0019i"));
        Object object5 = object3 = object4.iterator();
        while (object5.hasNext()) {
            object2 = (MapleData)object3.next();
            if (object2.getName().equals(SharkLogger.ALLATORIxDEMO("BCLADBU"))) {
                object5 = object3;
                continue;
            }
            object = new PredictCard();
            object5 = object3;
            Object object6 = object;
            ((PredictCard)object6).name = MapleDataTool.getString(HiredMerchantHandler.ALLATORIxDEMO("\u001ao\u0019k"), (MapleData)object2, "");
            ((PredictCard)object6).comment = MapleDataTool.getString(SharkLogger.ALLATORIxDEMO("BCLADBU"), (MapleData)object2, "");
            a2.predictCard.put(Integer.parseInt(object2.getName()), (PredictCard)object);
        }
        object3 = object4.getChildByPath(HiredMerchantHandler.ALLATORIxDEMO("m\u001bc\u0019k\u001az"));
        Object object7 = object2 = object3.iterator();
        while (object7.hasNext()) {
            object = (MapleData)object2.next();
            object4 = new PredictCardComment();
            object7 = object2;
            Object object8 = object4;
            Object object9 = object4;
            ((PredictCardComment)object9).worldmsg0 = MapleDataTool.getString(SharkLogger.ALLATORIxDEMO("\u0011"), (MapleData)object, "");
            ((PredictCardComment)object9).worldmsg1 = MapleDataTool.getString("1", (MapleData)object, "");
            ((PredictCardComment)object8).score = MapleDataTool.getIntConvert(HiredMerchantHandler.ALLATORIxDEMO("}\u0017a\u0006k"), (MapleData)object, 0);
            ((PredictCardComment)object8).effectType = MapleDataTool.getIntConvert(SharkLogger.ALLATORIxDEMO("IGJDOUxX\\D"), (MapleData)object, 0);
            a2.predictCardComment.put(Integer.parseInt(object.getName()), (PredictCardComment)object4);
        }
    }

    public /* synthetic */ PredictCardComment RandomCardComment() {
        PredictCardFactory a2;
        PredictCardFactory predictCardFactory = a2;
        return predictCardFactory.getPredictCardComment(Randomizer.nextInt(predictCardFactory.predictCardComment.size()));
    }

    public static /* synthetic */ PredictCardFactory getInstance() {
        return ALLATORIxDEMO;
    }

    public /* synthetic */ PredictCardFactory() {
        PredictCardFactory a2;
        a2.etcData = MapleDataProviderFactory.getDataProvider(SharkLogger.ALLATORIxDEMO("iUO\u000f[["));
        PredictCardFactory predictCardFactory = a2;
        a2.predictCard = new HashMap<Integer, PredictCard>();
        predictCardFactory.predictCardComment = new HashMap<Integer, PredictCardComment>();
    }

    public /* synthetic */ PredictCard getPredictCard(int a2) {
        PredictCardFactory a3;
        if (!a3.predictCard.containsKey(a2)) {
            return null;
        }
        return a3.predictCard.get(a2);
    }

    public /* synthetic */ int getCardCommentSize() {
        PredictCardFactory a2;
        return a2.predictCardComment.size();
    }

    public static class PredictCard {
        public /* synthetic */ String name;
        public /* synthetic */ String comment;

        public /* synthetic */ PredictCard() {
            PredictCard a2;
        }
    }

    public static class PredictCardComment {
        public /* synthetic */ String worldmsg1;
        public /* synthetic */ String worldmsg0;
        public /* synthetic */ int score;
        public /* synthetic */ int effectType;

        public /* synthetic */ PredictCardComment() {
            PredictCardComment a2;
        }
    }
}

