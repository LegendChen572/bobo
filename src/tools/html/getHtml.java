/*
 * Decompiled with CFR 0.150.
 */
package tools.html;

import client.messages.ConsoleCommandExecute;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import server.ItemInformation;

public class getHtml {
    public static /* synthetic */ String ALLATORIxDEMO(String a2) {
        int n2 = a2.length();
        int n3 = n2 - 1;
        char[] arrc = new char[n2];
        int n4 = (3 ^ 5) << 4 ^ (2 << 2 ^ 3);
        int cfr_ignored_0 = 5 << 4;
        int n5 = n3;
        int n6 = 1 << 3 ^ 2;
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

    public /* synthetic */ List<String> getNews(String a2) {
        a2 = Pattern.compile(ConsoleCommandExecute.ALLATORIxDEMO(";,)g8q(,9"), 32).matcher((CharSequence)a2);
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = a2;
        while (((Matcher)object).find()) {
            Object object2 = a2;
            object = object2;
            arrayList.add(((Matcher)object2).group());
        }
        return arrayList;
    }

    public /* synthetic */ List<String> getCSS(String a2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = a2 = Pattern.compile(ItemInformation.ALLATORIxDEMO("\u007f(7\"/>mq|gl(7\"/>}"), 32).matcher((CharSequence)a2);
        while (((Matcher)object).find()) {
            Object object2 = a2;
            object = object2;
            arrayList.add(((Matcher)object2).group());
        }
        return arrayList;
    }

    public /* synthetic */ List<String> getLink(String a2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = a2 = Pattern.compile(ConsoleCommandExecute.ALLATORIxDEMO("qf\u0016YsZgo?b+:e%e\\\u0013%\u0010-d%1 e\\\u0013 \u0010-d 1/\u0016Y\u0011tsZg.d\\\u00139\u0010-s/c-r.q(,9"), 32).matcher((CharSequence)a2);
        while (((Matcher)object).find()) {
            Object object2 = a2;
            object = object2;
            arrayList.add(((Matcher)object2).group());
        }
        return arrayList;
    }

    public /* synthetic */ String getTitle(String a2) {
        getHtml a3;
        Object object = "";
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object2 = a2 = Pattern.compile(ItemInformation.ALLATORIxDEMO("g7277&emq|gl/*//>}"), 128).matcher((CharSequence)a2);
        while (((Matcher)object2).find()) {
            Object object3 = a2;
            object2 = object3;
            arrayList.add(((Matcher)object3).group());
        }
        int n2 = a2 = 0;
        while (n2 < arrayList.size()) {
            Object e2 = arrayList.get(a2);
            object = (String)object + (String)e2;
            n2 = ++a2;
        }
        return a3.outTag((String)object);
    }

    public static /* synthetic */ void main(String[] a2) {
        System.out.println(ItemInformation.ALLATORIxDEMO("Ix`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`Q`{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{cxIxc{c{c{c{`xcxc{cxc{c{`xcx`xcx`xcx`{cx`xc{c{c{c{`Q`{c{c{c{`{`{`{c{`{c{`{`{cxc{`{`{`{`{cxc{c{c{c{cxIxc{c{c{cx`xcxc{cxc{cx`xc{`{cxcxcx`{c{`{c{c{c{c{`Q`{c{c{c{`{`{`x`{`x`{`{`{cxc{`x`{`{`{`x`{c{c{c{cxIxc{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{`Q`{\f9%.08\"/*4-{!\"c\u001a/7\"/,)*{\f9%.08\"/,)c-tup{\u0007\u001e\u000e\u0014cxIxc{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{`Q`{c{c{c{c{c{+/7+ytl,4,m:/7\"/,)*u 4.{c{c{c{c{c{cxIxc{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{c{`Q`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`x`xI"));
        Iterator iterator = new getHtml();
        Object object = getHtml.getHtmlContent("http://www.taobao.com");
        System.out.println((String)object);
        System.out.println(((getHtml)((Object)iterator)).getTitle((String)object));
        iterator = ((getHtml)((Object)iterator)).getNews((String)object);
        object = new ArrayList();
        iterator = iterator.iterator();
        Iterator iterator2 = iterator;
        while (iterator2.hasNext()) {
            String string = (String)iterator.next();
            iterator2 = iterator;
            object.add(string.replaceAll(ConsoleCommandExecute.ALLATORIxDEMO(";c-r9"), ""));
        }
        System.out.println(object);
    }

    public /* synthetic */ String outTag(String a2) {
        return a2.replaceAll(ConsoleCommandExecute.ALLATORIxDEMO(";c-r9"), "");
    }

    public /* synthetic */ getHtml() {
        getHtml a2;
    }

    public static /* synthetic */ String getHtmlContent(String a2) {
        StringBuffer stringBuffer;
        String string;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer2 = new StringBuffer();
        URLConnection uRLConnection = new URL(a2).openConnection();
        uRLConnection.setRequestProperty("User-Agent", ConsoleCommandExecute.ALLATORIxDEMO("\u0000h7n!k,(y)}'ed\"j=f9n/k(<mJ\u001eN\b'x)}<mP$i)h:tmI\u0019<mC$`\b\u007f9."));
        BufferedReader bufferedReader2 = bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), ItemInformation.ALLATORIxDEMO("6/%v{")));
        while ((string = bufferedReader2.readLine()) != null) {
            stringBuffer2.append(string + "\r\n");
            bufferedReader2 = bufferedReader;
        }
        try {
            bufferedReader.close();
            stringBuffer = stringBuffer2;
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println(ConsoleCommandExecute.ALLATORIxDEMO("\u4f67\u8fde\u5162\u76c9R\u001fK\u6871\u5f08\u6744\u95e9\u98d5&"));
            stringBuffer = stringBuffer2;
            malformedURLException.getMessage();
        }
        catch (IOException iOException) {
            stringBuffer = stringBuffer2;
            iOException.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public /* synthetic */ List<String> getScript(String a2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = a2 = Pattern.compile(ItemInformation.ALLATORIxDEMO("\u007f\b\u0000\t\n\u000b\u0017uid\u007ft\u0010\u0018\u0011\u0012\u0013\u000f}"), 32).matcher((CharSequence)a2);
        while (((Matcher)object).find()) {
            Object object2 = a2;
            object = object2;
            arrayList.add(((Matcher)object2).group());
        }
        return arrayList;
    }
}

