/*
 * Decompiled with CFR 0.150.
 */
package scripting.event;

import constants.GameSetConstants;
import database.DatabaseException;
import handling.channel.ChannelServer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import scripting.AbstractScriptManager;
import scripting.event.EventManager;
import tools.FilePrinter;
import tools.FileoutputUtil;
import tools.JsonMapConverter;

public class EventScriptManager
extends AbstractScriptManager {
    private final /* synthetic */ AtomicInteger ALLATORIxDEMO;
    private final /* synthetic */ Map<String, EventEntry> d;

    public final /* synthetic */ void addEventManager(ChannelServer a2, String a32) {
        EventScriptManager a4;
        Invocable invocable = a4.getInvocable("event/" + a32 + ".js", null);
        if (invocable != null) {
            a2 = new EventEntry(a32, invocable, new EventManager((ChannelServer)a2, invocable, a32));
            a4.d.put(a32, (EventEntry)a2);
            try {
                ((ScriptEngine)((Object)((EventEntry)a2).iv)).put(DatabaseException.ALLATORIxDEMO("9G"), ((EventEntry)a2).em);
                Object[] arrobject = new Object[1];
                arrobject[0] = null;
                ((EventEntry)a2).iv.invokeFunction(JsonMapConverter.ALLATORIxDEMO("m\u001bm\u0001"), arrobject);
                return;
            }
            catch (NoSuchMethodException | ScriptException a32) {
                System.out.println("Error initiating event: " + ((EventEntry)a2).script + ":" + a32);
                FileoutputUtil.log("logs/Except/\u8173\u672c\u932f\u8aa4.txt", "Error initiating event: " + ((EventEntry)a2).script + ":" + a32);
            }
        }
    }

    public /* synthetic */ EventScriptManager(ChannelServer a2, String[] a3) {
        EventScriptManager a4;
        EventScriptManager eventScriptManager = a4;
        a4.d = new LinkedHashMap<String, EventEntry>();
        eventScriptManager.ALLATORIxDEMO = new AtomicInteger(0);
        if (GameSetConstants.AUTO_LOAD_EVENT) {
            ArrayList<File> arrayList;
            File file = new File(GameSetConstants.getNpcFolder() + File.separator + "event");
            ArrayList<File> arrayList2 = arrayList = new ArrayList<File>();
            a4.listDirectory(file, arrayList2);
            for (File file2 : arrayList2) {
                Invocable invocable;
                String string = file2.getName();
                if (string.equals("") || (invocable = a4.getInvocable("event/" + string, null)) == null) continue;
                String string2 = string;
                String string3 = string = string2.substring(0, string2.length() - 3);
                a4.d.put(string3, new EventEntry(string3, invocable, new EventManager(a2, invocable, string)));
            }
        } else {
            int n2;
            String[] arrstring = a3;
            int n3 = a3.length;
            int n4 = n2 = 0;
            while (n4 < n3) {
                Invocable invocable;
                String string = arrstring[n2];
                if (!string.equals("") && (invocable = a4.getInvocable("event/" + string + ".js", null)) != null) {
                    String string4 = string;
                    a4.d.put(string4, new EventEntry(string4, invocable, new EventManager(a2, invocable, string)));
                }
                n4 = ++n2;
            }
        }
        System.out.println("\u3010\u904a\u6232\u526f\u672c\u8f09\u5165\u3011\u5df2\u8f09\u5165\u526f\u672c\u6578 : " + a4.d.size());
    }

    public final /* synthetic */ void init() {
        EventScriptManager a2;
        for (EventEntry eventEntry : a2.d.values()) {
            try {
                ((ScriptEngine)((Object)eventEntry.iv)).put(JsonMapConverter.ALLATORIxDEMO("a\u0018"), eventEntry.em);
                Object[] arrobject = new Object[1];
                arrobject[0] = null;
                eventEntry.iv.invokeFunction(DatabaseException.ALLATORIxDEMO("5D5^"), arrobject);
            }
            catch (Exception exception) {
                System.err.println("Error initiating event: " + eventEntry.script + ":" + exception);
                FilePrinter.printError(JsonMapConverter.ALLATORIxDEMO("A\u0003a\u001bp&g\u0007m\u0005p8e\u001be\u0012a\u0007*\u0001|\u0001"), "Error initiating event: " + eventEntry.script + ":" + exception);
            }
        }
    }

    public final /* synthetic */ void cancel() {
        EventScriptManager a2;
        Iterator<EventEntry> iterator;
        Iterator<EventEntry> iterator2 = iterator = a2.d.values().iterator();
        while (iterator2.hasNext()) {
            iterator.next().em.cancel();
            iterator2 = iterator;
        }
    }

    public final /* synthetic */ List<EventManager> getAllEventManager() {
        EventScriptManager a2;
        Iterator<EventEntry> iterator;
        LinkedList<EventManager> linkedList = new LinkedList<EventManager>();
        Iterator<EventEntry> iterator2 = iterator = a2.d.values().iterator();
        while (iterator2.hasNext()) {
            EventEntry eventEntry = iterator.next();
            iterator2 = iterator;
            linkedList.add(eventEntry.em);
        }
        if (linkedList.size() == 0) {
            return null;
        }
        return linkedList;
    }

    public final /* synthetic */ EventManager getEventManager(String a2) {
        EventScriptManager a3;
        if ((a2 = a3.d.get(a2)) == null) {
            return null;
        }
        return ((EventEntry)a2).em;
    }

    public /* synthetic */ void listDirectory(File a2, List<File> a3) {
        if (!a2.exists()) {
            System.out.println(JsonMapConverter.ALLATORIxDEMO("\u6a90\u683d\u4e09\u5b2d\u572cT"));
            return;
        }
        if (a2.isFile()) {
            if (a2.getName().endsWith(DatabaseException.ALLATORIxDEMO("\u00046Y")) || a2.getName().endsWith(JsonMapConverter.ALLATORIxDEMO("[N&"))) {
                a3.add((File)a2);
                return;
            }
        } else {
            int n2;
            a2 = a2.listFiles();
            int n3 = n2 = 0;
            while (n3 < a2.length) {
                EventScriptManager a4;
                a4.listDirectory(a2[n2++], a3);
                n3 = n2;
            }
        }
    }

    public final /* synthetic */ void reloadEvent(ChannelServer a2, String a32) {
        EventScriptManager a4;
        Invocable invocable;
        if (!a32.equals("") && (invocable = a4.getInvocable("event/" + a32 + ".js", null)) != null) {
            EventScriptManager eventScriptManager = a4;
            a4.d.remove(a32);
            String string = a32;
            String string2 = a32;
            eventScriptManager.d.put(string2, new EventEntry(string2, invocable, new EventManager((ChannelServer)a2, invocable, a32)));
            a2 = eventScriptManager.d.get(a32);
            try {
                ((ScriptEngine)((Object)((EventEntry)a2).iv)).put(DatabaseException.ALLATORIxDEMO("9G"), ((EventEntry)a2).em);
                Object[] arrobject = new Object[1];
                arrobject[0] = null;
                ((EventEntry)a2).iv.invokeFunction(JsonMapConverter.ALLATORIxDEMO("m\u001bm\u0001"), arrobject);
                return;
            }
            catch (Exception a32) {
                System.err.println("Error initiating reloadEvent: " + ((EventEntry)a2).script + ":" + a32);
                FilePrinter.printError(DatabaseException.ALLATORIxDEMO("\u0019\\9D(y?X5Z(g=D=M9Xr^$^"), "Error  reloadEvent: " + ((EventEntry)a2).script + ":" + a32);
            }
        }
    }

    public final /* synthetic */ int getNewInstanceMapId() {
        EventScriptManager a2;
        return a2.ALLATORIxDEMO.addAndGet(1);
    }

    private static class EventEntry {
        public /* synthetic */ Invocable iv;
        public /* synthetic */ EventManager em;
        public /* synthetic */ String script;

        public /* synthetic */ EventEntry(String a2, Invocable a3, EventManager a4) {
            EventEntry a5;
            EventEntry eventEntry = a5;
            a5.script = a2;
            eventEntry.iv = a3;
            eventEntry.em = a4;
        }
    }
}

