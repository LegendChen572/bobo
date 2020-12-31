/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 */
package tools.html;

import handling.channel.handler.AllianceHandler;
import handling.world.family.MapleFamilyCharacter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import server.Randomizer;

public class JsoupTool {
    private static /* synthetic */ List<String> ALLATORIxDEMO;

    public static /* synthetic */ void main(String[] a2) throws IOException {
        System.out.println(AllianceHandler.ALLATORIxDEMO("\u001a\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153<3\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u0015\u001a\u00150\u00160\u00160\u00160\u00163\u00150\u00150\u00160\u00150\u00160\u00163\u00150\u00153\u00150\u00153\u00150\u00153\u00160\u00153\u00150\u00160\u00160\u00160\u00163<3\u00160\u00160\u00160\u00163\u00163\u00163\u00160\u00163\u00160\u00163\u00163\u00160\u00150\u00163\u00163\u00163\u00163\u00160\u00150\u00160\u00160\u00160\u00160\u0015\u001a\u00150\u00160\u00160\u00160\u00153\u00150\u00150\u00160\u00150\u00160\u00153\u00150\u00163\u00160\u00150\u00150\u00153\u00160\u00163\u00160\u00160\u00160\u00160\u00163<3\u00160\u00160\u00160\u00163\u00163\u00163\u00153\u00163\u00153\u00163\u00163\u00160\u00150\u00163\u00153\u00163\u00163\u00163\u00153\u00160\u00160\u00160\u00160\u0015\u001a\u00150\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00163<3\u0016_TvCcUqByY~\u0016rO0w|ZqB\u007fDy\u0016_TvCcUqB\u007fD0@'\u0018#\u0016Ts]y0\u0015\u001a\u00150\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00163<3\u00160\u00160\u00160\u00160\u00160\u0016xBdF*\u0019?AgA>W|ZqB\u007fDy\u0018sY}\u00160\u00160\u00160\u00160\u00160\u00160\u0015\u001a\u00150\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00160\u00163<3\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u00153\u0015\u001a"));
        Document document = Jsoup.connect((String)MapleFamilyCharacter.ALLATORIxDEMO("*P6T1\u001em\u000b,A5WlH6JlG-IlP5\u000b.M1PmF0A#O+J%J'S1")).get();
        Object object = document.title();
        Object object2 = object = document.select(AllianceHandler.ALLATORIxDEMO("|_KRqBq\u001b`WwS-\u0014!\u0014M")).eachText().iterator();
        while (object2.hasNext()) {
            String string = (String)object.next();
            System.out.println(string);
            object2 = object;
        }
    }

    public /* synthetic */ JsoupTool() {
        JsoupTool a2;
    }

    public static /* synthetic */ String getNews() throws IOException {
        return ALLATORIxDEMO.get(Randomizer.rand(0, ALLATORIxDEMO.size() - 1));
    }

    public static /* synthetic */ String getData(String a2) throws IOException {
        Document document = Jsoup.connect((String)a2).get();
        String string = document.title();
        return document.select(MapleFamilyCharacter.ALLATORIxDEMO("1T#J\u0019G.E1W\u007fN1\\o\u0015v\u0017p\u0013r\u001dt\u0011bF+CoJ7I\u001f")).text();
    }

    public static /* synthetic */ {
        ALLATORIxDEMO = new LinkedList<String>();
    }

    public static /* synthetic */ String reloadNews() throws IOException {
        ALLATORIxDEMO.clear();
        Document document = Jsoup.connect((String)MapleFamilyCharacter.ALLATORIxDEMO("*P6T1\u001em\u000b,A5WlH6JlG-IlP5\u000b.M1PmF0A#O+J%J'S1")).get();
        Object object = document.title();
        Object object2 = object = document.select(AllianceHandler.ALLATORIxDEMO("|_KRqBq\u001b`WwS-\u0014!\u0014M")).eachText().iterator();
        while (object2.hasNext()) {
            String string = (String)object.next();
            ALLATORIxDEMO.add(string);
            object2 = object;
        }
        return "";
    }
}

